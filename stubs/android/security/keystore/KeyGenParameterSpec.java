/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package android.security.keystore;

import java.security.KeyPairGenerator;
import java.util.Date;
import javax.crypto.Mac;
import java.security.Signature;
import javax.crypto.Cipher;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.KeyGenerator;
import java.security.cert.Certificate;
import android.hardware.biometrics.BiometricManager;
import android.app.KeyguardManager;
import android.hardware.biometrics.BiometricPrompt;

/**
 * {@link java.security.spec.AlgorithmParameterSpec AlgorithmParameterSpec} for initializing a {@link java.security.KeyPairGenerator KeyPairGenerator} or a
 * {@link javax.crypto.KeyGenerator KeyGenerator} of the <a href="{@docRoot}training/articles/keystore.html">Android Keystore
 * system</a>. The spec determines authorized uses of the key, such as whether user authentication
 * is required for using the key, what operations are authorized (e.g., signing, but not
 * decryption), with what parameters (e.g., only with a particular padding scheme or digest), and
 * the key's validity start and end dates. Key use authorizations expressed in the spec apply
 * only to secret keys and private keys -- public keys can be used for any supported operations.
 *
 * <p>To generate an asymmetric key pair or a symmetric key, create an instance of this class using
 * the {@link android.security.keystore.KeyGenParameterSpec.Builder Builder}, initialize a {@code KeyPairGenerator} or a {@code KeyGenerator} of the
 * desired key type (e.g., {@code EC} or {@code AES} -- see
 * {@link android.security.keystore.KeyProperties KeyProperties}.{@code KEY_ALGORITHM} constants) from the {@code AndroidKeyStore} provider
 * with the {@code KeyGenParameterSpec} instance, and then generate a key or key pair using
 * {@link javax.crypto.KeyGenerator#generateKey() KeyGenerator#generateKey()} or {@link java.security.KeyPairGenerator#generateKeyPair() KeyPairGenerator#generateKeyPair()}.
 *
 * <p>The generated key pair or key will be returned by the generator and also stored in the Android
 * Keystore under the alias specified in this spec. To obtain the secret or private key from the
 * Android Keystore use {@link java.security.KeyStore#getKey(String, char[]) KeyStore.getKey(String, null)}
 * or {@link java.security.KeyStore#getEntry(String, java.security.KeyStore.ProtectionParameter) KeyStore.getEntry(String, null)}.
 * To obtain the public key from the Android Keystore use
 * {@link java.security.KeyStore#getCertificate(String)} and then
 * {@link java.security.cert.Certificate#getPublicKey() Certificate#getPublicKey()}.
 *
 * <p>To help obtain algorithm-specific public parameters of key pairs stored in the Android
 * Keystore, generated private keys implement {@link java.security.interfaces.ECKey} or
 * {@link java.security.interfaces.RSAKey} interfaces whereas public keys implement
 * {@link java.security.interfaces.ECPublicKey} or {@link java.security.interfaces.RSAPublicKey}
 * interfaces.
 *
 * <p>For asymmetric key pairs, a self-signed X.509 certificate will be also generated and stored in
 * the Android Keystore. This is because the {@link java.security.KeyStore} abstraction does not
 * support storing key pairs without a certificate. The subject, serial number, and validity dates
 * of the certificate can be customized in this spec. The self-signed certificate may be replaced at
 * a later time by a certificate signed by a Certificate Authority (CA).
 *
 * <p>NOTE: If a private key is not authorized to sign the self-signed certificate, then the
 * certificate will be created with an invalid signature which will not verify. Such a certificate
 * is still useful because it provides access to the public key. To generate a valid signature for
 * the certificate the key needs to be authorized for all of the following:
 * <ul>
 * <li>{@link android.security.keystore.KeyProperties#PURPOSE_SIGN KeyProperties#PURPOSE_SIGN},</li>
 * <li>operation without requiring the user to be authenticated (see
 * {@link android.security.keystore.KeyGenParameterSpec.Builder#setUserAuthenticationRequired(boolean) Builder#setUserAuthenticationRequired(boolean)}),</li>
 * <li>signing/origination at this moment in time (see {@link android.security.keystore.KeyGenParameterSpec.Builder#setKeyValidityStart(java.util.Date) Builder#setKeyValidityStart(Date)}
 * and {@link android.security.keystore.KeyGenParameterSpec.Builder#setKeyValidityForOriginationEnd(java.util.Date) Builder#setKeyValidityForOriginationEnd(Date)}),</li>
 * <li>suitable digest,</li>
 * <li>(RSA keys only) padding scheme {@link android.security.keystore.KeyProperties#SIGNATURE_PADDING_RSA_PKCS1 KeyProperties#SIGNATURE_PADDING_RSA_PKCS1}.</li>
 * </ul>
 *
 * <p>NOTE: The key material of the generated symmetric and private keys is not accessible. The key
 * material of the public keys is accessible.
 *
 * <p>Instances of this class are immutable.
 *
 * <p><h3>Known issues</h3>
 * A known bug in Android 6.0 (API Level 23) causes user authentication-related authorizations to be
 * enforced even for public keys. To work around this issue extract the public key material to use
 * outside of Android Keystore. For example:
 * <pre> {@code
 * PublicKey unrestrictedPublicKey =
 *         KeyFactory.getInstance(publicKey.getAlgorithm()).generatePublic(
 *                 new X509EncodedKeySpec(publicKey.getEncoded()));
 * }</pre>
 *
 * <p><h3>Example: NIST P-256 EC key pair for signing/verification using ECDSA</h3>
 * This example illustrates how to generate a NIST P-256 (aka secp256r1 aka prime256v1) EC key pair
 * in the Android KeyStore system under alias {@code key1} where the private key is authorized to be
 * used only for signing using SHA-256, SHA-384, or SHA-512 digest and only if the user has been
 * authenticated within the last five minutes. The use of the public key is unrestricted (See Known
 * Issues).
 * <pre> {@code
 * KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(
 *         KeyProperties.KEY_ALGORITHM_EC, "AndroidKeyStore");
 * keyPairGenerator.initialize(
 *         new KeyGenParameterSpec.Builder(
 *                 "key1",
 *                 KeyProperties.PURPOSE_SIGN)
 *                 .setAlgorithmParameterSpec(new ECGenParameterSpec("secp256r1"))
 *                 .setDigests(KeyProperties.DIGEST_SHA256,
 *                         KeyProperties.DIGEST_SHA384,
 *                         KeyProperties.DIGEST_SHA512)
 *                 // Only permit the private key to be used if the user authenticated
 *                 // within the last five minutes.
 *                 .setUserAuthenticationRequired(true)
 *                 .setUserAuthenticationValidityDurationSeconds(5 * 60)
 *                 .build());
 * KeyPair keyPair = keyPairGenerator.generateKeyPair();
 * Signature signature = Signature.getInstance("SHA256withECDSA");
 * signature.initSign(keyPair.getPrivate());
 * ...
 *
 * // The key pair can also be obtained from the Android Keystore any time as follows:
 * KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
 * keyStore.load(null);
 * PrivateKey privateKey = (PrivateKey) keyStore.getKey("key1", null);
 * PublicKey publicKey = keyStore.getCertificate("key1").getPublicKey();
 * }</pre>
 *
 * <p><h3>Example: RSA key pair for signing/verification using RSA-PSS</h3>
 * This example illustrates how to generate an RSA key pair in the Android KeyStore system under
 * alias {@code key1} authorized to be used only for signing using the RSA-PSS signature padding
 * scheme with SHA-256 or SHA-512 digests. The use of the public key is unrestricted.
 * <pre> {@code
 * KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(
 *         KeyProperties.KEY_ALGORITHM_RSA, "AndroidKeyStore");
 * keyPairGenerator.initialize(
 *         new KeyGenParameterSpec.Builder(
 *                 "key1",
 *                 KeyProperties.PURPOSE_SIGN)
 *                 .setDigests(KeyProperties.DIGEST_SHA256, KeyProperties.DIGEST_SHA512)
 *                 .setSignaturePaddings(KeyProperties.SIGNATURE_PADDING_RSA_PSS)
 *                 .build());
 * KeyPair keyPair = keyPairGenerator.generateKeyPair();
 * Signature signature = Signature.getInstance("SHA256withRSA/PSS");
 * signature.initSign(keyPair.getPrivate());
 * ...
 *
 * // The key pair can also be obtained from the Android Keystore any time as follows:
 * KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
 * keyStore.load(null);
 * PrivateKey privateKey = (PrivateKey) keyStore.getKey("key1", null);
 * PublicKey publicKey = keyStore.getCertificate("key1").getPublicKey();
 * }</pre>
 *
 * <p><h3>Example: RSA key pair for encryption/decryption using RSA OAEP</h3>
 * This example illustrates how to generate an RSA key pair in the Android KeyStore system under
 * alias {@code key1} where the private key is authorized to be used only for decryption using RSA
 * OAEP encryption padding scheme with SHA-256 or SHA-512 digests. The use of the public key is
 * unrestricted.
 * <pre> {@code
 * KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(
 *         KeyProperties.KEY_ALGORITHM_RSA, "AndroidKeyStore");
 * keyPairGenerator.initialize(
 *         new KeyGenParameterSpec.Builder(
 *                 "key1",
 *                 KeyProperties.PURPOSE_DECRYPT)
 *                 .setDigests(KeyProperties.DIGEST_SHA256, KeyProperties.DIGEST_SHA512)
 *                 .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_RSA_OAEP)
 *                 .build());
 * KeyPair keyPair = keyPairGenerator.generateKeyPair();
 * Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
 * cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
 * ...
 *
 * // The key pair can also be obtained from the Android Keystore any time as follows:
 * KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
 * keyStore.load(null);
 * PrivateKey privateKey = (PrivateKey) keyStore.getKey("key1", null);
 * PublicKey publicKey = keyStore.getCertificate("key1").getPublicKey();
 * }</pre>
 *
 * <p><h3>Example: AES key for encryption/decryption in GCM mode</h3>
 * The following example illustrates how to generate an AES key in the Android KeyStore system under
 * alias {@code key2} authorized to be used only for encryption/decryption in GCM mode with no
 * padding.
 * <pre> {@code
 * KeyGenerator keyGenerator = KeyGenerator.getInstance(
 *         KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore");
 * keyGenerator.init(
 *         new KeyGenParameterSpec.Builder("key2",
 *                 KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
 *                 .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
 *                 .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
 *                 .build());
 * SecretKey key = keyGenerator.generateKey();
 *
 * Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
 * cipher.init(Cipher.ENCRYPT_MODE, key);
 * ...
 *
 * // The key can also be obtained from the Android Keystore any time as follows:
 * KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
 * keyStore.load(null);
 * key = (SecretKey) keyStore.getKey("key2", null);
 * }</pre>
 *
 * <p><h3>Example: HMAC key for generating a MAC using SHA-256</h3>
 * This example illustrates how to generate an HMAC key in the Android KeyStore system under alias
 * {@code key2} authorized to be used only for generating an HMAC using SHA-256.
 * <pre> {@code
 * KeyGenerator keyGenerator = KeyGenerator.getInstance(
 *         KeyProperties.KEY_ALGORITHM_HMAC_SHA256, "AndroidKeyStore");
 * keyGenerator.init(
 *         new KeyGenParameterSpec.Builder("key2", KeyProperties.PURPOSE_SIGN).build());
 * SecretKey key = keyGenerator.generateKey();
 * Mac mac = Mac.getInstance("HmacSHA256");
 * mac.init(key);
 * ...
 *
 * // The key can also be obtained from the Android Keystore any time as follows:
 * KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
 * keyStore.load(null);
 * key = (SecretKey) keyStore.getKey("key2", null);
 * }</pre>
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class KeyGenParameterSpec implements java.security.spec.AlgorithmParameterSpec {

KeyGenParameterSpec() { throw new RuntimeException("Stub!"); }

/**
 * Returns the alias that will be used in the {@code java.security.KeyStore}
 * in conjunction with the {@code AndroidKeyStore}.
 
 * @return This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public java.lang.String getKeystoreAlias() { throw new RuntimeException("Stub!"); }

/**
 * Returns the requested key size. If {@code -1}, the size should be looked up from
 * {@link #getAlgorithmParameterSpec()}, if provided, otherwise an algorithm-specific default
 * size should be used.
 * @apiSince 23
 */

public int getKeySize() { throw new RuntimeException("Stub!"); }

/**
 * Returns the key algorithm-specific {@link java.security.spec.AlgorithmParameterSpec AlgorithmParameterSpec} that will be used for
 * creation of the key or {@code null} if algorithm-specific defaults should be used.
 * @apiSince 23
 */

@androidx.annotation.Nullable
public java.security.spec.AlgorithmParameterSpec getAlgorithmParameterSpec() { throw new RuntimeException("Stub!"); }

/**
 * Returns the subject distinguished name to be used on the X.509 certificate that will be put
 * in the {@link java.security.KeyStore}.
 
 * @return This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public javax.security.auth.x500.X500Principal getCertificateSubject() { throw new RuntimeException("Stub!"); }

/**
 * Returns the serial number to be used on the X.509 certificate that will be put in the
 * {@link java.security.KeyStore}.
 
 * @return This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public java.math.BigInteger getCertificateSerialNumber() { throw new RuntimeException("Stub!"); }

/**
 * Returns the start date to be used on the X.509 certificate that will be put in the
 * {@link java.security.KeyStore}.
 
 * @return This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public java.util.Date getCertificateNotBefore() { throw new RuntimeException("Stub!"); }

/**
 * Returns the end date to be used on the X.509 certificate that will be put in the
 * {@link java.security.KeyStore}.
 
 * @return This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public java.util.Date getCertificateNotAfter() { throw new RuntimeException("Stub!"); }

/**
 * Returns the time instant before which the key is not yet valid or {@code null} if not
 * restricted.
 * @apiSince 23
 */

@androidx.annotation.Nullable
public java.util.Date getKeyValidityStart() { throw new RuntimeException("Stub!"); }

/**
 * Returns the time instant after which the key is no longer valid for decryption and
 * verification or {@code null} if not restricted.
 * @apiSince 23
 */

@androidx.annotation.Nullable
public java.util.Date getKeyValidityForConsumptionEnd() { throw new RuntimeException("Stub!"); }

/**
 * Returns the time instant after which the key is no longer valid for encryption and signing
 * or {@code null} if not restricted.
 * @apiSince 23
 */

@androidx.annotation.Nullable
public java.util.Date getKeyValidityForOriginationEnd() { throw new RuntimeException("Stub!"); }

/**
 * Returns the set of purposes (e.g., encrypt, decrypt, sign) for which the key can be used.
 * Attempts to use the key for any other purpose will be rejected.
 *
 * <p>See {@link android.security.keystore.KeyProperties KeyProperties}.{@code PURPOSE} flags.
 
 * @return Value is either <code>0</code> or a combination of {@link android.security.keystore.KeyProperties#PURPOSE_ENCRYPT}, {@link android.security.keystore.KeyProperties#PURPOSE_DECRYPT}, {@link android.security.keystore.KeyProperties#PURPOSE_SIGN}, {@link android.security.keystore.KeyProperties#PURPOSE_VERIFY}, and {@link android.security.keystore.KeyProperties#PURPOSE_WRAP_KEY}
 * @apiSince 23
 */

public int getPurposes() { throw new RuntimeException("Stub!"); }

/**
 * Returns the set of digest algorithms (e.g., {@code SHA-256}, {@code SHA-384} with which the
 * key can be used or {@code null} if not specified.
 *
 * <p>See {@link android.security.keystore.KeyProperties KeyProperties}.{@code DIGEST} constants.
 *
 * @throws java.lang.IllegalStateException if this set has not been specified.
 *
 * @see #isDigestsSpecified()
 
 * @return Value is {@link android.security.keystore.KeyProperties#DIGEST_NONE}, {@link android.security.keystore.KeyProperties#DIGEST_MD5}, {@link android.security.keystore.KeyProperties#DIGEST_SHA1}, {@link android.security.keystore.KeyProperties#DIGEST_SHA224}, {@link android.security.keystore.KeyProperties#DIGEST_SHA256}, {@link android.security.keystore.KeyProperties#DIGEST_SHA384}, or {@link android.security.keystore.KeyProperties#DIGEST_SHA512}
 * @apiSince 23
 */

@androidx.annotation.NonNull
public java.lang.String[] getDigests() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the set of digest algorithms with which the key can be used has been
 * specified.
 *
 * @see #getDigests()
 
 * @return This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public boolean isDigestsSpecified() { throw new RuntimeException("Stub!"); }

/**
 * Returns the set of padding schemes (e.g., {@code PKCS7Padding}, {@code OEAPPadding},
 * {@code PKCS1Padding}, {@code NoPadding}) with which the key can be used when
 * encrypting/decrypting. Attempts to use the key with any other padding scheme will be
 * rejected.
 *
 * <p>See {@link android.security.keystore.KeyProperties KeyProperties}.{@code ENCRYPTION_PADDING} constants.
 
 * @return This value will never be {@code null}.
 
 * Value is {@link android.security.keystore.KeyProperties#ENCRYPTION_PADDING_NONE}, {@link android.security.keystore.KeyProperties#ENCRYPTION_PADDING_PKCS7}, {@link android.security.keystore.KeyProperties#ENCRYPTION_PADDING_RSA_PKCS1}, or {@link android.security.keystore.KeyProperties#ENCRYPTION_PADDING_RSA_OAEP}
 * @apiSince 23
 */

@androidx.annotation.NonNull
public java.lang.String[] getEncryptionPaddings() { throw new RuntimeException("Stub!"); }

/**
 * Gets the set of padding schemes (e.g., {@code PSS}, {@code PKCS#1}) with which the key
 * can be used when signing/verifying. Attempts to use the key with any other padding scheme
 * will be rejected.
 *
 * <p>See {@link android.security.keystore.KeyProperties KeyProperties}.{@code SIGNATURE_PADDING} constants.
 
 * @return This value will never be {@code null}.
 
 * Value is {@link android.security.keystore.KeyProperties#SIGNATURE_PADDING_RSA_PKCS1}, or {@link android.security.keystore.KeyProperties#SIGNATURE_PADDING_RSA_PSS}
 * @apiSince 23
 */

@androidx.annotation.NonNull
public java.lang.String[] getSignaturePaddings() { throw new RuntimeException("Stub!"); }

/**
 * Gets the set of block modes (e.g., {@code GCM}, {@code CBC}) with which the key can be used
 * when encrypting/decrypting. Attempts to use the key with any other block modes will be
 * rejected.
 *
 * <p>See {@link android.security.keystore.KeyProperties KeyProperties}.{@code BLOCK_MODE} constants.
 
 * @return This value will never be {@code null}.
 
 * Value is {@link android.security.keystore.KeyProperties#BLOCK_MODE_ECB}, {@link android.security.keystore.KeyProperties#BLOCK_MODE_CBC}, {@link android.security.keystore.KeyProperties#BLOCK_MODE_CTR}, or {@link android.security.keystore.KeyProperties#BLOCK_MODE_GCM}
 * @apiSince 23
 */

@androidx.annotation.NonNull
public java.lang.String[] getBlockModes() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if encryption using this key must be sufficiently randomized to produce
 * different ciphertexts for the same plaintext every time. The formal cryptographic property
 * being required is <em>indistinguishability under chosen-plaintext attack ({@code
 * IND-CPA})</em>. This property is important because it mitigates several classes of
 * weaknesses due to which ciphertext may leak information about plaintext.  For example, if a
 * given plaintext always produces the same ciphertext, an attacker may see the repeated
 * ciphertexts and be able to deduce something about the plaintext.
 * @apiSince 23
 */

public boolean isRandomizedEncryptionRequired() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the key is authorized to be used only if the user has been
 * authenticated.
 *
 * <p>This authorization applies only to secret key and private key operations. Public key
 * operations are not restricted.
 *
 * @see #getUserAuthenticationValidityDurationSeconds()
 * @see android.security.keystore.KeyGenParameterSpec.Builder#setUserAuthenticationRequired(boolean)
 * @apiSince 23
 */

public boolean isUserAuthenticationRequired() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the key is authorized to be used only for messages confirmed by the
 * user.
 *
 * Confirmation is separate from user authentication (see
 * {@link android.security.keystore.KeyGenParameterSpec.Builder#setUserAuthenticationRequired(boolean) Builder#setUserAuthenticationRequired(boolean)}). Keys can be created that require
 * confirmation but not user authentication, or user authentication but not confirmation, or
 * both. Confirmation verifies that some user with physical possession of the device has
 * approved a displayed message. User authentication verifies that the correct user is present
 * and has authenticated.
 *
 * <p>This authorization applies only to secret key and private key operations. Public key
 * operations are not restricted.
 *
 * @see android.security.keystore.KeyGenParameterSpec.Builder#setUserConfirmationRequired(boolean)
 * @apiSince 28
 */

public boolean isUserConfirmationRequired() { throw new RuntimeException("Stub!"); }

/**
 * Gets the duration of time (seconds) for which this key is authorized to be used after the
 * user is successfully authenticated. This has effect only if user authentication is required
 * (see {@link #isUserAuthenticationRequired()}).
 *
 * <p>This authorization applies only to secret key and private key operations. Public key
 * operations are not restricted.
 *
 * @return duration in seconds or {@code -1} if authentication is required for every use of the
 *         key.
 *
 * @see #isUserAuthenticationRequired()
 * @see android.security.keystore.KeyGenParameterSpec.Builder#setUserAuthenticationValidityDurationSeconds(int)
 * @apiSince 23
 */

public int getUserAuthenticationValidityDurationSeconds() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the key is authorized to be used only if a test of user presence has
 * been performed between the {@code Signature.initSign()} and {@code Signature.sign()} calls.
 * It requires that the KeyStore implementation have a direct way to validate the user presence
 * for example a KeyStore hardware backed strongbox can use a button press that is observable
 * in hardware. A test for user presence is tangential to authentication. The test can be part
 * of an authentication step as long as this step can be validated by the hardware protecting
 * the key and cannot be spoofed. For example, a physical button press can be used as a test of
 * user presence if the other pins connected to the button are not able to simulate a button
 * press. There must be no way for the primary processor to fake a button press, or that
 * button must not be used as a test of user presence.
 * @apiSince 28
 */

public boolean isUserPresenceRequired() { throw new RuntimeException("Stub!"); }

/**
 * Returns the attestation challenge value that will be placed in attestation certificate for
 * this key pair.
 *
 * <p>If this method returns non-{@code null}, the public key certificate for this key pair will
 * contain an extension that describes the details of the key's configuration and
 * authorizations, including the content of the attestation challenge value. If the key is in
 * secure hardware, and if the secure hardware supports attestation, the certificate will be
 * signed by a chain of certificates rooted at a trustworthy CA key. Otherwise the chain will
 * be rooted at an untrusted certificate.
 *
 * <p>If this method returns {@code null}, and the spec is used to generate an asymmetric (RSA
 * or EC) key pair, the public key will have a self-signed certificate if it has purpose {@link android.security.keystore.KeyProperties#PURPOSE_SIGN KeyProperties#PURPOSE_SIGN}. If does not have purpose {@link android.security.keystore.KeyProperties#PURPOSE_SIGN KeyProperties#PURPOSE_SIGN}, it
 * will have a fake certificate.
 *
 * <p>Symmetric keys, such as AES and HMAC keys, do not have public key certificates. If a
 * KeyGenParameterSpec with getAttestationChallenge returning non-null is used to generate a
 * symmetric (AES or HMAC) key, {@link javax.crypto.KeyGenerator#generateKey()} will throw
 * {@link java.security.InvalidAlgorithmParameterException}.
 *
 * @see android.security.keystore.KeyGenParameterSpec.Builder#setAttestationChallenge(byte[])
 * @apiSince 24
 */

public byte[] getAttestationChallenge() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the key will remain authorized only until the device is removed from
 * the user's body, up to the validity duration.  This option has no effect on keys that don't
 * have an authentication validity duration, and has no effect if the device lacks an on-body
 * sensor.
 *
 * <p>Authorization applies only to secret key and private key operations. Public key operations
 * are not restricted.
 *
 * @see #isUserAuthenticationRequired()
 * @see #getUserAuthenticationValidityDurationSeconds()
 * @see android.security.keystore.KeyGenParameterSpec.Builder#setUserAuthenticationValidWhileOnBody(boolean)
 * @apiSince 24
 */

public boolean isUserAuthenticationValidWhileOnBody() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the key is irreversibly invalidated when a new biometric is
 * enrolled or all enrolled biometrics are removed. This has effect only for keys that
 * require biometric user authentication for every use.
 *
 * @see #isUserAuthenticationRequired()
 * @see #getUserAuthenticationValidityDurationSeconds()
 * @see android.security.keystore.KeyGenParameterSpec.Builder#setInvalidatedByBiometricEnrollment(boolean)
 * @apiSince 24
 */

public boolean isInvalidatedByBiometricEnrollment() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the key is protected by a Strongbox security chip.
 * @apiSince 28
 */

public boolean isStrongBoxBacked() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the screen must be unlocked for this key to be used for decryption or
 * signing. Encryption and signature verification will still be available when the screen is
 * locked.
 *
 * @see android.security.keystore.KeyGenParameterSpec.Builder#setUnlockedDeviceRequired(boolean)
 * @apiSince 28
 */

public boolean isUnlockedDeviceRequired() { throw new RuntimeException("Stub!"); }
/**
 * Builder of {@link android.security.keystore.KeyGenParameterSpec KeyGenParameterSpec} instances.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Creates a new instance of the {@code Builder}.
 *
 * @param keystoreAlias alias of the entry in which the generated key will appear in
 *        Android KeyStore. Must not be empty.
 * This value must never be {@code null}.
 * @param purposes set of purposes (e.g., encrypt, decrypt, sign) for which the key can be
 *        used. Attempts to use the key for any other purpose will be rejected.
 *
 *        <p>If the set of purposes for which the key can be used does not contain
 *        {@link android.security.keystore.KeyProperties#PURPOSE_SIGN KeyProperties#PURPOSE_SIGN}, the self-signed certificate generated by
 *        {@link java.security.KeyPairGenerator KeyPairGenerator} of {@code AndroidKeyStore} provider will contain an
 *        invalid signature. This is OK if the certificate is only used for obtaining the
 *        public key from Android KeyStore.
 *
 *        <p>See {@link android.security.keystore.KeyProperties KeyProperties}.{@code PURPOSE} flags.
 
 * Value is either <code>0</code> or a combination of {@link android.security.keystore.KeyProperties#PURPOSE_ENCRYPT}, {@link android.security.keystore.KeyProperties#PURPOSE_DECRYPT}, {@link android.security.keystore.KeyProperties#PURPOSE_SIGN}, {@link android.security.keystore.KeyProperties#PURPOSE_VERIFY}, and {@link android.security.keystore.KeyProperties#PURPOSE_WRAP_KEY}
 * @apiSince 23
 */

public Builder(@androidx.annotation.NonNull java.lang.String keystoreAlias, int purposes) { throw new RuntimeException("Stub!"); }

/**
 * Sets the size (in bits) of the key to be generated. For instance, for RSA keys this sets
 * the modulus size, for EC keys this selects a curve with a matching field size, and for
 * symmetric keys this sets the size of the bitstring which is their key material.
 *
 * <p>The default key size is specific to each key algorithm. If key size is not set
 * via this method, it should be looked up from the algorithm-specific parameters (if any)
 * provided via
 * {@link #setAlgorithmParameterSpec(java.security.spec.AlgorithmParameterSpec) setAlgorithmParameterSpec}.
 
 * @return This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.security.keystore.KeyGenParameterSpec.Builder setKeySize(int keySize) { throw new RuntimeException("Stub!"); }

/**
 * Sets the algorithm-specific key generation parameters. For example, for RSA keys this may
 * be an instance of {@link java.security.spec.RSAKeyGenParameterSpec} whereas for EC keys
 * this may be an instance of {@link java.security.spec.ECGenParameterSpec}.
 *
 * <p>These key generation parameters must match other explicitly set parameters (if any),
 * such as key size.
 
 * @param spec This value must never be {@code null}.
 * @apiSince 23
 */

public android.security.keystore.KeyGenParameterSpec.Builder setAlgorithmParameterSpec(@androidx.annotation.NonNull java.security.spec.AlgorithmParameterSpec spec) { throw new RuntimeException("Stub!"); }

/**
 * Sets the subject used for the self-signed certificate of the generated key pair.
 *
 * <p>By default, the subject is {@code CN=fake}.
 
 * @param subject This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.security.keystore.KeyGenParameterSpec.Builder setCertificateSubject(@androidx.annotation.NonNull javax.security.auth.x500.X500Principal subject) { throw new RuntimeException("Stub!"); }

/**
 * Sets the serial number used for the self-signed certificate of the generated key pair.
 *
 * <p>By default, the serial number is {@code 1}.
 
 * @param serialNumber This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.security.keystore.KeyGenParameterSpec.Builder setCertificateSerialNumber(@androidx.annotation.NonNull java.math.BigInteger serialNumber) { throw new RuntimeException("Stub!"); }

/**
 * Sets the start of the validity period for the self-signed certificate of the generated
 * key pair.
 *
 * <p>By default, this date is {@code Jan 1 1970}.
 
 * @param date This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.security.keystore.KeyGenParameterSpec.Builder setCertificateNotBefore(@androidx.annotation.NonNull java.util.Date date) { throw new RuntimeException("Stub!"); }

/**
 * Sets the end of the validity period for the self-signed certificate of the generated key
 * pair.
 *
 * <p>By default, this date is {@code Jan 1 2048}.
 
 * @param date This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.security.keystore.KeyGenParameterSpec.Builder setCertificateNotAfter(@androidx.annotation.NonNull java.util.Date date) { throw new RuntimeException("Stub!"); }

/**
 * Sets the time instant before which the key is not yet valid.
 *
 * <p>By default, the key is valid at any instant.
 *
 * @see #setKeyValidityEnd(Date)
 
 * @return This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.security.keystore.KeyGenParameterSpec.Builder setKeyValidityStart(java.util.Date startDate) { throw new RuntimeException("Stub!"); }

/**
 * Sets the time instant after which the key is no longer valid.
 *
 * <p>By default, the key is valid at any instant.
 *
 * @see #setKeyValidityStart(Date)
 * @see #setKeyValidityForConsumptionEnd(Date)
 * @see #setKeyValidityForOriginationEnd(Date)
 
 * @return This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.security.keystore.KeyGenParameterSpec.Builder setKeyValidityEnd(java.util.Date endDate) { throw new RuntimeException("Stub!"); }

/**
 * Sets the time instant after which the key is no longer valid for encryption and signing.
 *
 * <p>By default, the key is valid at any instant.
 *
 * @see #setKeyValidityForConsumptionEnd(Date)
 
 * @return This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.security.keystore.KeyGenParameterSpec.Builder setKeyValidityForOriginationEnd(java.util.Date endDate) { throw new RuntimeException("Stub!"); }

/**
 * Sets the time instant after which the key is no longer valid for decryption and
 * verification.
 *
 * <p>By default, the key is valid at any instant.
 *
 * @see #setKeyValidityForOriginationEnd(Date)
 
 * @return This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.security.keystore.KeyGenParameterSpec.Builder setKeyValidityForConsumptionEnd(java.util.Date endDate) { throw new RuntimeException("Stub!"); }

/**
 * Sets the set of digests algorithms (e.g., {@code SHA-256}, {@code SHA-384}) with which
 * the key can be used. Attempts to use the key with any other digest algorithm will be
 * rejected.
 *
 * <p>This must be specified for signing/verification keys and RSA encryption/decryption
 * keys used with RSA OAEP padding scheme because these operations involve a digest. For
 * HMAC keys, the default is the digest associated with the key algorithm (e.g.,
 * {@code SHA-256} for key algorithm {@code HmacSHA256}). HMAC keys cannot be authorized
 * for more than one digest.
 *
 * <p>For private keys used for TLS/SSL client or server authentication it is usually
 * necessary to authorize the use of no digest ({@link android.security.keystore.KeyProperties#DIGEST_NONE KeyProperties#DIGEST_NONE}). This is
 * because TLS/SSL stacks typically generate the necessary digest(s) themselves and then use
 * a private key to sign it.
 *
 * <p>See {@link android.security.keystore.KeyProperties KeyProperties}.{@code DIGEST} constants.
 
 * @param digests Value is {@link android.security.keystore.KeyProperties#DIGEST_NONE}, {@link android.security.keystore.KeyProperties#DIGEST_MD5}, {@link android.security.keystore.KeyProperties#DIGEST_SHA1}, {@link android.security.keystore.KeyProperties#DIGEST_SHA224}, {@link android.security.keystore.KeyProperties#DIGEST_SHA256}, {@link android.security.keystore.KeyProperties#DIGEST_SHA384}, or {@link android.security.keystore.KeyProperties#DIGEST_SHA512}
 * @return This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.security.keystore.KeyGenParameterSpec.Builder setDigests(java.lang.String... digests) { throw new RuntimeException("Stub!"); }

/**
 * Sets the set of padding schemes (e.g., {@code PKCS7Padding}, {@code OAEPPadding},
 * {@code PKCS1Padding}, {@code NoPadding}) with which the key can be used when
 * encrypting/decrypting. Attempts to use the key with any other padding scheme will be
 * rejected.
 *
 * <p>This must be specified for keys which are used for encryption/decryption.
 *
 * <p>For RSA private keys used by TLS/SSL servers to authenticate themselves to clients it
 * is usually necessary to authorize the use of no/any padding
 * ({@link android.security.keystore.KeyProperties#ENCRYPTION_PADDING_NONE KeyProperties#ENCRYPTION_PADDING_NONE}) and/or PKCS#1 encryption padding
 * ({@link android.security.keystore.KeyProperties#ENCRYPTION_PADDING_RSA_PKCS1 KeyProperties#ENCRYPTION_PADDING_RSA_PKCS1}). This is because RSA decryption is
 * required by some cipher suites, and some stacks request decryption using no padding
 * whereas others request PKCS#1 padding.
 *
 * <p>See {@link android.security.keystore.KeyProperties KeyProperties}.{@code ENCRYPTION_PADDING} constants.
 
 * @param paddings Value is {@link android.security.keystore.KeyProperties#ENCRYPTION_PADDING_NONE}, {@link android.security.keystore.KeyProperties#ENCRYPTION_PADDING_PKCS7}, {@link android.security.keystore.KeyProperties#ENCRYPTION_PADDING_RSA_PKCS1}, or {@link android.security.keystore.KeyProperties#ENCRYPTION_PADDING_RSA_OAEP}
 * @return This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.security.keystore.KeyGenParameterSpec.Builder setEncryptionPaddings(java.lang.String... paddings) { throw new RuntimeException("Stub!"); }

/**
 * Sets the set of padding schemes (e.g., {@code PSS}, {@code PKCS#1}) with which the key
 * can be used when signing/verifying. Attempts to use the key with any other padding scheme
 * will be rejected.
 *
 * <p>This must be specified for RSA keys which are used for signing/verification.
 *
 * <p>See {@link android.security.keystore.KeyProperties KeyProperties}.{@code SIGNATURE_PADDING} constants.
 
 * @param paddings Value is {@link android.security.keystore.KeyProperties#SIGNATURE_PADDING_RSA_PKCS1}, or {@link android.security.keystore.KeyProperties#SIGNATURE_PADDING_RSA_PSS}
 * @return This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.security.keystore.KeyGenParameterSpec.Builder setSignaturePaddings(java.lang.String... paddings) { throw new RuntimeException("Stub!"); }

/**
 * Sets the set of block modes (e.g., {@code GCM}, {@code CBC}) with which the key can be
 * used when encrypting/decrypting. Attempts to use the key with any other block modes will
 * be rejected.
 *
 * <p>This must be specified for symmetric encryption/decryption keys.
 *
 * <p>See {@link android.security.keystore.KeyProperties KeyProperties}.{@code BLOCK_MODE} constants.
 
 * @param blockModes Value is {@link android.security.keystore.KeyProperties#BLOCK_MODE_ECB}, {@link android.security.keystore.KeyProperties#BLOCK_MODE_CBC}, {@link android.security.keystore.KeyProperties#BLOCK_MODE_CTR}, or {@link android.security.keystore.KeyProperties#BLOCK_MODE_GCM}
 * @return This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.security.keystore.KeyGenParameterSpec.Builder setBlockModes(java.lang.String... blockModes) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether encryption using this key must be sufficiently randomized to produce
 * different ciphertexts for the same plaintext every time. The formal cryptographic
 * property being required is <em>indistinguishability under chosen-plaintext attack
 * ({@code IND-CPA})</em>. This property is important because it mitigates several classes
 * of weaknesses due to which ciphertext may leak information about plaintext. For example,
 * if a given plaintext always produces the same ciphertext, an attacker may see the
 * repeated ciphertexts and be able to deduce something about the plaintext.
 *
 * <p>By default, {@code IND-CPA} is required.
 *
 * <p>When {@code IND-CPA} is required:
 * <ul>
 * <li>encryption/decryption transformation which do not offer {@code IND-CPA}, such as
 * {@code ECB} with a symmetric encryption algorithm, or RSA encryption/decryption without
 * padding, are prohibited;</li>
 * <li>in block modes which use an IV, such as {@code GCM}, {@code CBC}, and {@code CTR},
 * caller-provided IVs are rejected when encrypting, to ensure that only random IVs are
 * used.</li>
 * </ul>
 *
 * <p>Before disabling this requirement, consider the following approaches instead:
 * <ul>
 * <li>If you are generating a random IV for encryption and then initializing a {@code}
 * Cipher using the IV, the solution is to let the {@code Cipher} generate a random IV
 * instead. This will occur if the {@code Cipher} is initialized for encryption without an
 * IV. The IV can then be queried via {@link javax.crypto.Cipher#getIV() Cipher#getIV()}.</li>
 * <li>If you are generating a non-random IV (e.g., an IV derived from something not fully
 * random, such as the name of the file being encrypted, or transaction ID, or password,
 * or a device identifier), consider changing your design to use a random IV which will then
 * be provided in addition to the ciphertext to the entities which need to decrypt the
 * ciphertext.</li>
 * <li>If you are using RSA encryption without padding, consider switching to encryption
 * padding schemes which offer {@code IND-CPA}, such as PKCS#1 or OAEP.</li>
 * </ul>
 
 * @return This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.security.keystore.KeyGenParameterSpec.Builder setRandomizedEncryptionRequired(boolean required) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this key is authorized to be used only if the user has been authenticated.
 *
 * <p>By default, the key is authorized to be used regardless of whether the user has been
 * authenticated.
 *
 * <p>When user authentication is required:
 * <ul>
 * <li>The key can only be generated if secure lock screen is set up (see
 * {@link android.app.KeyguardManager#isDeviceSecure() KeyguardManager#isDeviceSecure()}). Additionally, if the key requires that user
 * authentication takes place for every use of the key (see
 * {@link #setUserAuthenticationValidityDurationSeconds(int)}), at least one biometric
 * must be enrolled (see {@link android.hardware.biometrics.BiometricManager#canAuthenticate() BiometricManager#canAuthenticate()}).</li>
 * <li>The use of the key must be authorized by the user by authenticating to this Android
 * device using a subset of their secure lock screen credentials such as
 * password/PIN/pattern or biometric.
 * <a href="{@docRoot}training/articles/keystore.html#UserAuthentication">More
 * information</a>.
 * <li>The key will become <em>irreversibly invalidated</em> once the secure lock screen is
 * disabled (reconfigured to None, Swipe or other mode which does not authenticate the user)
 * or when the secure lock screen is forcibly reset (e.g., by a Device Administrator).
 * Additionally, if the key requires that user authentication takes place for every use of
 * the key, it is also irreversibly invalidated once a new biometric is enrolled or once\
 * no more biometrics are enrolled, unless {@link
 * #setInvalidatedByBiometricEnrollment(boolean)} is used to allow validity after
 * enrollment. Attempts to initialize cryptographic operations using such keys will throw
 * {@link android.security.keystore.KeyPermanentlyInvalidatedException KeyPermanentlyInvalidatedException}.</li>
 * </ul>
 *
 * <p>This authorization applies only to secret key and private key operations. Public key
 * operations are not restricted.
 *
 * @see #setUserAuthenticationValidityDurationSeconds(int)
 * @see android.app.KeyguardManager#isDeviceSecure()
 * @see android.hardware.biometrics.BiometricManager#canAuthenticate()
 
 * @return This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.security.keystore.KeyGenParameterSpec.Builder setUserAuthenticationRequired(boolean required) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this key is authorized to be used only for messages confirmed by the
 * user.
 *
 * Confirmation is separate from user authentication (see
 * {@link #setUserAuthenticationRequired(boolean)}). Keys can be created that require
 * confirmation but not user authentication, or user authentication but not confirmation,
 * or both. Confirmation verifies that some user with physical possession of the device has
 * approved a displayed message. User authentication verifies that the correct user is
 * present and has authenticated.
 *
 * <p>This authorization applies only to secret key and private key operations. Public key
 * operations are not restricted.
 *
 * See {@link android.security.ConfirmationPrompt} class for
 * more details about user confirmations.
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.security.keystore.KeyGenParameterSpec.Builder setUserConfirmationRequired(boolean required) { throw new RuntimeException("Stub!"); }

/**
 * Sets the duration of time (seconds) for which this key is authorized to be used after the
 * user is successfully authenticated. This has effect if the key requires user
 * authentication for its use (see {@link #setUserAuthenticationRequired(boolean)}).
 *
 * <p>By default, if user authentication is required, it must take place for every use of
 * the key.
 *
 * <p>Cryptographic operations involving keys which require user authentication to take
 * place for every operation can only use biometric authentication. This is achieved by
 * initializing a cryptographic operation ({@link java.security.Signature Signature}, {@link javax.crypto.Cipher Cipher}, {@link javax.crypto.Mac Mac})
 * with the key, wrapping it into a {@link android.hardware.biometrics.BiometricPrompt.CryptoObject BiometricPrompt.CryptoObject}, invoking
 * {@code BiometricPrompt.authenticate} with {@code CryptoObject}, and proceeding with
 * the cryptographic operation only if the authentication flow succeeds.
 *
 * <p>Cryptographic operations involving keys which are authorized to be used for a duration
 * of time after a successful user authentication event can only use secure lock screen
 * authentication. These cryptographic operations will throw
 * {@link android.security.keystore.UserNotAuthenticatedException UserNotAuthenticatedException} during initialization if the user needs to be
 * authenticated to proceed. This situation can be resolved by the user unlocking the secure
 * lock screen of the Android or by going through the confirm credential flow initiated by
 * {@link android.app.KeyguardManager#createConfirmDeviceCredentialIntent(java.lang.CharSequence,java.lang.CharSequence) KeyguardManager#createConfirmDeviceCredentialIntent(CharSequence, CharSequence)}.
 * Once resolved, initializing a new cryptographic operation using this key (or any other
 * key which is authorized to be used for a fixed duration of time after user
 * authentication) should succeed provided the user authentication flow completed
 * successfully.
 *
 * @param seconds duration in seconds or {@code -1} if user authentication must take place
 *        for every use of the key.
 *
 * Value is -1 or greater
 * @see #setUserAuthenticationRequired(boolean)
 * @see android.hardware.biometrics.BiometricPrompt
 * @see android.hardware.biometrics.BiometricPrompt.CryptoObject
 * @see android.app.KeyguardManager
 
 * @return This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.security.keystore.KeyGenParameterSpec.Builder setUserAuthenticationValidityDurationSeconds(int seconds) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether a test of user presence is required to be performed between the
 * {@code Signature.initSign()} and {@code Signature.sign()} method calls.
 * It requires that the KeyStore implementation have a direct way to validate the user
 * presence for example a KeyStore hardware backed strongbox can use a button press that
 * is observable in hardware. A test for user presence is tangential to authentication. The
 * test can be part of an authentication step as long as this step can be validated by the
 * hardware protecting the key and cannot be spoofed. For example, a physical button press
 * can be used as a test of user presence if the other pins connected to the button are not
 * able to simulate a button press.There must be no way for the primary processor to fake a
 * button press, or that button must not be used as a test of user presence.
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.security.keystore.KeyGenParameterSpec.Builder setUserPresenceRequired(boolean required) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether an attestation certificate will be generated for this key pair, and what
 * challenge value will be placed in the certificate.  The attestation certificate chain
 * can be retrieved with with {@link java.security.KeyStore#getCertificateChain(String)}.
 *
 * <p>If {@code attestationChallenge} is not {@code null}, the public key certificate for
 * this key pair will contain an extension that describes the details of the key's
 * configuration and authorizations, including the {@code attestationChallenge} value. If
 * the key is in secure hardware, and if the secure hardware supports attestation, the
 * certificate will be signed by a chain of certificates rooted at a trustworthy CA key.
 * Otherwise the chain will be rooted at an untrusted certificate.
 *
 * <p>The purpose of the challenge value is to enable relying parties to verify that the key
 * was created in response to a specific request. If attestation is desired but no
 * challenged is needed, any non-{@code null} value may be used, including an empty byte
 * array.
 *
 * <p>If {@code attestationChallenge} is {@code null}, and this spec is used to generate an
 * asymmetric (RSA or EC) key pair, the public key certificate will be self-signed if the
 * key has purpose {@link android.security.keystore.KeyProperties#PURPOSE_SIGN}. If the key
 * does not have purpose {@link android.security.keystore.KeyProperties#PURPOSE_SIGN}, it is
 * not possible to use the key to sign a certificate, so the public key certificate will
 * contain a dummy signature.
 *
 * <p>Symmetric keys, such as AES and HMAC keys, do not have public key certificates. If a
 * {@link #getAttestationChallenge()} returns non-null and the spec is used to generate a
 * symmetric (AES or HMAC) key, {@link javax.crypto.KeyGenerator#generateKey()} will throw
 * {@link java.security.InvalidAlgorithmParameterException}.
 * @apiSince 24
 */

@androidx.annotation.NonNull
public android.security.keystore.KeyGenParameterSpec.Builder setAttestationChallenge(byte[] attestationChallenge) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the key will remain authorized only until the device is removed from the
 * user's body up to the limit of the authentication validity period (see
 * {@link #setUserAuthenticationValidityDurationSeconds} and
 * {@link #setUserAuthenticationRequired}). Once the device has been removed from the
 * user's body, the key will be considered unauthorized and the user will need to
 * re-authenticate to use it. For keys without an authentication validity period this
 * parameter has no effect.
 *
 * <p>Similarly, on devices that do not have an on-body sensor, this parameter will have no
 * effect; the device will always be considered to be "on-body" and the key will therefore
 * remain authorized until the validity period ends.
 *
 * @param remainsValid if {@code true}, and if the device supports on-body detection, key
 * will be invalidated when the device is removed from the user's body or when the
 * authentication validity expires, whichever occurs first.
 
 * @return This value will never be {@code null}.
 * @apiSince 24
 */

@androidx.annotation.NonNull
public android.security.keystore.KeyGenParameterSpec.Builder setUserAuthenticationValidWhileOnBody(boolean remainsValid) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this key should be invalidated on biometric enrollment.  This
 * applies only to keys which require user authentication (see {@link
 * #setUserAuthenticationRequired(boolean)}) and if no positive validity duration has been
 * set (see {@link #setUserAuthenticationValidityDurationSeconds(int)}, meaning the key is
 * valid for biometric authentication only.
 *
 * <p>By default, {@code invalidateKey} is {@code true}, so keys that are valid for
 * biometric authentication only are <em>irreversibly invalidated</em> when a new
 * biometric is enrolled, or when all existing biometrics are deleted.  That may be
 * changed by calling this method with {@code invalidateKey} set to {@code false}.
 *
 * <p>Invalidating keys on enrollment of a new biometric or unenrollment of all biometrics
 * improves security by ensuring that an unauthorized person who obtains the password can't
 * gain the use of biometric-authenticated keys by enrolling their own biometric.  However,
 * invalidating keys makes key-dependent operations impossible, requiring some fallback
 * procedure to authenticate the user and set up a new key.
 
 * @return This value will never be {@code null}.
 * @apiSince 24
 */

@androidx.annotation.NonNull
public android.security.keystore.KeyGenParameterSpec.Builder setInvalidatedByBiometricEnrollment(boolean invalidateKey) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this key should be protected by a StrongBox security chip.
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.security.keystore.KeyGenParameterSpec.Builder setIsStrongBoxBacked(boolean isStrongBoxBacked) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the keystore requires the screen to be unlocked before allowing decryption
 * using this key. If this is set to {@code true}, any attempt to decrypt or sign using this
 * key while the screen is locked will fail. A locked device requires a PIN, password,
 * biometric, or other trusted factor to access. While the screen is locked, the key can
 * still be used for encryption or signature verification.
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.security.keystore.KeyGenParameterSpec.Builder setUnlockedDeviceRequired(boolean unlockedDeviceRequired) { throw new RuntimeException("Stub!"); }

/**
 * Builds an instance of {@code KeyGenParameterSpec}.
 
 * @return This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.security.keystore.KeyGenParameterSpec build() { throw new RuntimeException("Stub!"); }
}

}

