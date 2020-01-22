/*
 * Copyright (C) 2015 The Android Open Source Project
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

import java.security.Signature;
import javax.crypto.Cipher;
import java.security.Key;
import javax.crypto.Mac;
import java.security.KeyStore.ProtectionParameter;
import java.security.cert.Certificate;
import java.util.Date;
import android.hardware.biometrics.BiometricManager;
import android.app.KeyguardManager;
import android.hardware.biometrics.BiometricPrompt;

/**
 * Specification of how a key or key pair is secured when imported into the
 * <a href="{@docRoot}training/articles/keystore.html">Android Keystore system</a>. This class
 * specifies authorized uses of the imported key, such as whether user authentication is required
 * for using the key, what operations the key is authorized for (e.g., decryption, but not signing)
 * with what parameters (e.g., only with a particular padding scheme or digest), and the key's
 * validity start and end dates. Key use authorizations expressed in this class apply only to secret
 * keys and private keys -- public keys can be used for any supported operations.
 *
 * <p>To import a key or key pair into the Android Keystore, create an instance of this class using
 * the {@link android.security.keystore.KeyProtection.Builder Builder} and pass the instance into {@link java.security.KeyStore#setEntry(String, java.security.KeyStore.Entry, ProtectionParameter) KeyStore.setEntry}
 * with the key or key pair being imported.
 *
 * <p>To obtain the secret/symmetric or private key from the Android Keystore use
 * {@link java.security.KeyStore#getKey(String, char[]) KeyStore.getKey(String, null)} or
 * {@link java.security.KeyStore#getEntry(String, java.security.KeyStore.ProtectionParameter) KeyStore.getEntry(String, null)}.
 * To obtain the public key from the Android Keystore use
 * {@link java.security.KeyStore#getCertificate(String)} and then
 * {@link java.security.cert.Certificate#getPublicKey() Certificate#getPublicKey()}.
 *
 * <p>To help obtain algorithm-specific public parameters of key pairs stored in the Android
 * Keystore, its private keys implement {@link java.security.interfaces.ECKey} or
 * {@link java.security.interfaces.RSAKey} interfaces whereas its public keys implement
 * {@link java.security.interfaces.ECPublicKey} or {@link java.security.interfaces.RSAPublicKey}
 * interfaces.
 *
 * <p>NOTE: The key material of keys stored in the Android Keystore is not accessible.
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
 * <p><h3>Example: AES key for encryption/decryption in GCM mode</h3>
 * This example illustrates how to import an AES key into the Android KeyStore under alias
 * {@code key1} authorized to be used only for encryption/decryption in GCM mode with no padding.
 * The key must export its key material via {@link java.security.Key#getEncoded() Key#getEncoded()} in {@code RAW} format.
 * <pre> {@code
 * SecretKey key = ...; // AES key
 *
 * KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
 * keyStore.load(null);
 * keyStore.setEntry(
 *         "key1",
 *         new KeyStore.SecretKeyEntry(key),
 *         new KeyProtection.Builder(KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
 *                 .setBlockMode(KeyProperties.BLOCK_MODE_GCM)
 *                 .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
 *                 .build());
 * // Key imported, obtain a reference to it.
 * SecretKey keyStoreKey = (SecretKey) keyStore.getKey("key1", null);
 * // The original key can now be discarded.
 *
 * Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
 * cipher.init(Cipher.ENCRYPT_MODE, keyStoreKey);
 * ...
 * }</pre>
 *
 * <p><h3>Example: HMAC key for generating MACs using SHA-512</h3>
 * This example illustrates how to import an HMAC key into the Android KeyStore under alias
 * {@code key1} authorized to be used only for generating MACs using SHA-512 digest. The key must
 * export its key material via {@link java.security.Key#getEncoded() Key#getEncoded()} in {@code RAW} format.
 * <pre> {@code
 * SecretKey key = ...; // HMAC key of algorithm "HmacSHA512".
 *
 * KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
 * keyStore.load(null);
 * keyStore.setEntry(
 *         "key1",
 *         new KeyStore.SecretKeyEntry(key),
 *         new KeyProtection.Builder(KeyProperties.PURPOSE_SIGN).build());
 * // Key imported, obtain a reference to it.
 * SecretKey keyStoreKey = (SecretKey) keyStore.getKey("key1", null);
 * // The original key can now be discarded.
 *
 * Mac mac = Mac.getInstance("HmacSHA512");
 * mac.init(keyStoreKey);
 * ...
 * }</pre>
 *
 * <p><h3>Example: EC key pair for signing/verification using ECDSA</h3>
 * This example illustrates how to import an EC key pair into the Android KeyStore under alias
 * {@code key2} with the private key authorized to be used only for signing with SHA-256 or SHA-512
 * digests. The use of the public key is unrestricted. Both the private and the public key must
 * export their key material via {@link java.security.Key#getEncoded() Key#getEncoded()} in {@code PKCS#8} and {@code X.509} format
 * respectively.
 * <pre> {@code
 * PrivateKey privateKey = ...;   // EC private key
 * Certificate[] certChain = ...; // Certificate chain with the first certificate
 *                                // containing the corresponding EC public key.
 *
 * KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
 * keyStore.load(null);
 * keyStore.setEntry(
 *         "key2",
 *         new KeyStore.PrivateKeyEntry(privateKey, certChain),
 *         new KeyProtection.Builder(KeyProperties.PURPOSE_SIGN)
 *                 .setDigests(KeyProperties.DIGEST_SHA256, KeyProperties.DIGEST_SHA512)
 *                 .build());
 * // Key pair imported, obtain a reference to it.
 * PrivateKey keyStorePrivateKey = (PrivateKey) keyStore.getKey("key2", null);
 * PublicKey publicKey = keyStore.getCertificate("key2").getPublicKey();
 * // The original private key can now be discarded.
 *
 * Signature signature = Signature.getInstance("SHA256withECDSA");
 * signature.initSign(keyStorePrivateKey);
 * ...
 * }</pre>
 *
 * <p><h3>Example: RSA key pair for signing/verification using PKCS#1 padding</h3>
 * This example illustrates how to import an RSA key pair into the Android KeyStore under alias
 * {@code key2} with the private key authorized to be used only for signing using the PKCS#1
 * signature padding scheme with SHA-256 digest and only if the user has been authenticated within
 * the last ten minutes. The use of the public key is unrestricted (see Known Issues). Both the
 * private and the public key must export their key material via {@link java.security.Key#getEncoded() Key#getEncoded()} in
 * {@code PKCS#8} and {@code X.509} format respectively.
 * <pre> {@code
 * PrivateKey privateKey = ...;   // RSA private key
 * Certificate[] certChain = ...; // Certificate chain with the first certificate
 *                                // containing the corresponding RSA public key.
 *
 * KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
 * keyStore.load(null);
 * keyStore.setEntry(
 *         "key2",
 *         new KeyStore.PrivateKeyEntry(privateKey, certChain),
 *         new KeyProtection.Builder(KeyProperties.PURPOSE_SIGN)
 *                 .setDigests(KeyProperties.DIGEST_SHA256)
 *                 .setSignaturePaddings(KeyProperties.SIGNATURE_PADDING_RSA_PKCS1)
 *                 // Only permit this key to be used if the user
 *                 // authenticated within the last ten minutes.
 *                 .setUserAuthenticationRequired(true)
 *                 .setUserAuthenticationValidityDurationSeconds(10 * 60)
 *                 .build());
 * // Key pair imported, obtain a reference to it.
 * PrivateKey keyStorePrivateKey = (PrivateKey) keyStore.getKey("key2", null);
 * PublicKey publicKey = keyStore.getCertificate("key2").getPublicKey();
 * // The original private key can now be discarded.
 *
 * Signature signature = Signature.getInstance("SHA256withRSA");
 * signature.initSign(keyStorePrivateKey);
 * ...
 * }</pre>
 *
 * <p><h3>Example: RSA key pair for encryption/decryption using PKCS#1 padding</h3>
 * This example illustrates how to import an RSA key pair into the Android KeyStore under alias
 * {@code key2} with the private key authorized to be used only for decryption using the PKCS#1
 * encryption padding scheme. The use of public key is unrestricted, thus permitting encryption
 * using any padding schemes and digests. Both the private and the public key must export their key
 * material via {@link java.security.Key#getEncoded() Key#getEncoded()} in {@code PKCS#8} and {@code X.509} format respectively.
 * <pre> {@code
 * PrivateKey privateKey = ...;   // RSA private key
 * Certificate[] certChain = ...; // Certificate chain with the first certificate
 *                                // containing the corresponding RSA public key.
 *
 * KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
 * keyStore.load(null);
 * keyStore.setEntry(
 *         "key2",
 *         new KeyStore.PrivateKeyEntry(privateKey, certChain),
 *         new KeyProtection.Builder(KeyProperties.PURPOSE_DECRYPT)
 *                 .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_RSA_PKCS1)
 *                 .build());
 * // Key pair imported, obtain a reference to it.
 * PrivateKey keyStorePrivateKey = (PrivateKey) keyStore.getKey("key2", null);
 * PublicKey publicKey = keyStore.getCertificate("key2").getPublicKey();
 * // The original private key can now be discarded.
 *
 * Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
 * cipher.init(Cipher.DECRYPT_MODE, keyStorePrivateKey);
 * ...
 * }</pre>
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class KeyProtection implements java.security.KeyStore.ProtectionParameter {

private KeyProtection() { throw new RuntimeException("Stub!"); }

/**
 * Gets the time instant before which the key is not yet valid.
 *
 * @return instant or {@code null} if not restricted.
 * @apiSince 23
 */

@androidx.annotation.Nullable
public java.util.Date getKeyValidityStart() { throw new RuntimeException("Stub!"); }

/**
 * Gets the time instant after which the key is no long valid for decryption and verification.
 *
 * @return instant or {@code null} if not restricted.
 * @apiSince 23
 */

@androidx.annotation.Nullable
public java.util.Date getKeyValidityForConsumptionEnd() { throw new RuntimeException("Stub!"); }

/**
 * Gets the time instant after which the key is no long valid for encryption and signing.
 *
 * @return instant or {@code null} if not restricted.
 * @apiSince 23
 */

@androidx.annotation.Nullable
public java.util.Date getKeyValidityForOriginationEnd() { throw new RuntimeException("Stub!"); }

/**
 * Gets the set of purposes (e.g., encrypt, decrypt, sign) for which the key can be used.
 * Attempts to use the key for any other purpose will be rejected.
 *
 * <p>See {@link android.security.keystore.KeyProperties KeyProperties}.{@code PURPOSE} flags.
 
 * @return Value is either <code>0</code> or a combination of {@link android.security.keystore.KeyProperties#PURPOSE_ENCRYPT}, {@link android.security.keystore.KeyProperties#PURPOSE_DECRYPT}, {@link android.security.keystore.KeyProperties#PURPOSE_SIGN}, {@link android.security.keystore.KeyProperties#PURPOSE_VERIFY}, and {@link android.security.keystore.KeyProperties#PURPOSE_WRAP_KEY}
 * @apiSince 23
 */

public int getPurposes() { throw new RuntimeException("Stub!"); }

/**
 * Gets the set of padding schemes (e.g., {@code PKCS7Padding}, {@code PKCS1Padding},
 * {@code NoPadding}) with which the key can be used when encrypting/decrypting. Attempts to use
 * the key with any other padding scheme will be rejected.
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
 * Gets the set of digest algorithms (e.g., {@code SHA-256}, {@code SHA-384}) with which the key
 * can be used.
 *
 * <p>See {@link android.security.keystore.KeyProperties KeyProperties}.{@code DIGEST} constants.
 *
 * @throws java.lang.IllegalStateException if this set has not been specified.
 *
 * @see #isDigestsSpecified()
 
 * @return This value will never be {@code null}.
 
 * Value is {@link android.security.keystore.KeyProperties#DIGEST_NONE}, {@link android.security.keystore.KeyProperties#DIGEST_MD5}, {@link android.security.keystore.KeyProperties#DIGEST_SHA1}, {@link android.security.keystore.KeyProperties#DIGEST_SHA224}, {@link android.security.keystore.KeyProperties#DIGEST_SHA256}, {@link android.security.keystore.KeyProperties#DIGEST_SHA384}, or {@link android.security.keystore.KeyProperties#DIGEST_SHA512}
 * @apiSince 23
 */

@androidx.annotation.NonNull
public java.lang.String[] getDigests() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the set of digest algorithms with which the key can be used has been
 * specified.
 *
 * @see #getDigests()
 * @apiSince 23
 */

public boolean isDigestsSpecified() { throw new RuntimeException("Stub!"); }

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
 * weaknesses due to which ciphertext may leak information about plaintext. For example, if a
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
 * @see android.security.keystore.KeyProtection.Builder#setUserAuthenticationRequired(boolean)
 * @apiSince 23
 */

public boolean isUserAuthenticationRequired() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the key is authorized to be used only for messages confirmed by the
 * user.
 *
 * Confirmation is separate from user authentication (see
 * {@link #isUserAuthenticationRequired()}). Keys can be created that require confirmation but
 * not user authentication, or user authentication but not confirmation, or both. Confirmation
 * verifies that some user with physical possession of the device has approved a displayed
 * message. User authentication verifies that the correct user is present and has
 * authenticated.
 *
 * <p>This authorization applies only to secret key and private key operations. Public key
 * operations are not restricted.
 *
 * @see android.security.keystore.KeyProtection.Builder#setUserConfirmationRequired(boolean)
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
 * @see android.security.keystore.KeyProtection.Builder#setUserAuthenticationValidityDurationSeconds(int)
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
 * Returns {@code true} if the key will be de-authorized when the device is removed from the
 * user's body.  This option has no effect on keys that don't have an authentication validity
 * duration, and has no effect if the device lacks an on-body sensor.
 *
 * <p>Authorization applies only to secret key and private key operations. Public key operations
 * are not restricted.
 *
 * @see #isUserAuthenticationRequired()
 * @see #getUserAuthenticationValidityDurationSeconds()
 * @see android.security.keystore.KeyProtection.Builder#setUserAuthenticationValidWhileOnBody(boolean)
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
 * @see android.security.keystore.KeyProtection.Builder#setInvalidatedByBiometricEnrollment(boolean)
 * @apiSince 24
 */

public boolean isInvalidatedByBiometricEnrollment() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the screen must be unlocked for this key to be used for decryption or
 * signing. Encryption and signature verification will still be available when the screen is
 * locked.
 *
 * @see android.security.keystore.KeyProtection.Builder#setUnlockedDeviceRequired(boolean)
 * @apiSince 28
 */

public boolean isUnlockedDeviceRequired() { throw new RuntimeException("Stub!"); }
/**
 * Builder of {@link android.security.keystore.KeyProtection KeyProtection} instances.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Creates a new instance of the {@code Builder}.
 *
 * @param purposes set of purposes (e.g., encrypt, decrypt, sign) for which the key can be
 *        used. Attempts to use the key for any other purpose will be rejected.
 *
 *        <p>See {@link android.security.keystore.KeyProperties KeyProperties}.{@code PURPOSE} flags.
 
 * Value is either <code>0</code> or a combination of {@link android.security.keystore.KeyProperties#PURPOSE_ENCRYPT}, {@link android.security.keystore.KeyProperties#PURPOSE_DECRYPT}, {@link android.security.keystore.KeyProperties#PURPOSE_SIGN}, {@link android.security.keystore.KeyProperties#PURPOSE_VERIFY}, and {@link android.security.keystore.KeyProperties#PURPOSE_WRAP_KEY}
 * @apiSince 23
 */

public Builder(int purposes) { throw new RuntimeException("Stub!"); }

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
public android.security.keystore.KeyProtection.Builder setKeyValidityStart(java.util.Date startDate) { throw new RuntimeException("Stub!"); }

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
public android.security.keystore.KeyProtection.Builder setKeyValidityEnd(java.util.Date endDate) { throw new RuntimeException("Stub!"); }

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
public android.security.keystore.KeyProtection.Builder setKeyValidityForOriginationEnd(java.util.Date endDate) { throw new RuntimeException("Stub!"); }

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
public android.security.keystore.KeyProtection.Builder setKeyValidityForConsumptionEnd(java.util.Date endDate) { throw new RuntimeException("Stub!"); }

/**
 * Sets the set of padding schemes (e.g., {@code OAEPPadding}, {@code PKCS7Padding},
 * {@code NoPadding}) with which the key can be used when encrypting/decrypting. Attempts to
 * use the key with any other padding scheme will be rejected.
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
public android.security.keystore.KeyProtection.Builder setEncryptionPaddings(java.lang.String... paddings) { throw new RuntimeException("Stub!"); }

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
public android.security.keystore.KeyProtection.Builder setSignaturePaddings(java.lang.String... paddings) { throw new RuntimeException("Stub!"); }

/**
 * Sets the set of digest algorithms (e.g., {@code SHA-256}, {@code SHA-384}) with which the
 * key can be used. Attempts to use the key with any other digest algorithm will be
 * rejected.
 *
 * <p>This must be specified for signing/verification keys and RSA encryption/decryption
 * keys used with RSA OAEP padding scheme because these operations involve a digest. For
 * HMAC keys, the default is the digest specified in {@link java.security.Key#getAlgorithm() Key#getAlgorithm()} (e.g.,
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
public android.security.keystore.KeyProtection.Builder setDigests(java.lang.String... digests) { throw new RuntimeException("Stub!"); }

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
public android.security.keystore.KeyProtection.Builder setBlockModes(java.lang.String... blockModes) { throw new RuntimeException("Stub!"); }

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
 * <li>transformation which do not offer {@code IND-CPA}, such as symmetric ciphers using
 * {@code ECB} mode or RSA encryption without padding, are prohibited;</li>
 * <li>in transformations which use an IV, such as symmetric ciphers in {@code GCM},
 * {@code CBC}, and {@code CTR} block modes, caller-provided IVs are rejected when
 * encrypting, to ensure that only random IVs are used.</li>
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
 * <li>If you are using RSA encryption without padding, consider switching to padding
 * schemes which offer {@code IND-CPA}, such as PKCS#1 or OAEP.</li>
 * </ul>
 
 * @return This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.security.keystore.KeyProtection.Builder setRandomizedEncryptionRequired(boolean required) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this key is authorized to be used only if the user has been authenticated.
 *
 * <p>By default, the key is authorized to be used regardless of whether the user has been
 * authenticated.
 *
 * <p>When user authentication is required:
 * <ul>
 * <li>The key can only be import if secure lock screen is set up (see
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
 * {@link android.security.keystore.KeyPermanentlyInvalidatedException KeyPermanentlyInvalidatedException}.</li> </ul>
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
public android.security.keystore.KeyProtection.Builder setUserAuthenticationRequired(boolean required) { throw new RuntimeException("Stub!"); }

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
public android.security.keystore.KeyProtection.Builder setUserConfirmationRequired(boolean required) { throw new RuntimeException("Stub!"); }

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
public android.security.keystore.KeyProtection.Builder setUserAuthenticationValidityDurationSeconds(int seconds) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether a test of user presence is required to be performed between the
 * {@code Signature.initSign()} and {@code Signature.sign()} method calls. It requires that
 * the KeyStore implementation have a direct way to validate the user presence for example
 * a KeyStore hardware backed strongbox can use a button press that is observable in
 * hardware. A test for user presence is tangential to authentication. The test can be part
 * of an authentication step as long as this step can be validated by the hardware
 * protecting the key and cannot be spoofed. For example, a physical button press can be
 * used as a test of user presence if the other pins connected to the button are not able
 * to simulate a button press. There must be no way for the primary processor to fake a
 * button press, or that button must not be used as a test of user presence.
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.security.keystore.KeyProtection.Builder setUserPresenceRequired(boolean required) { throw new RuntimeException("Stub!"); }

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
public android.security.keystore.KeyProtection.Builder setUserAuthenticationValidWhileOnBody(boolean remainsValid) { throw new RuntimeException("Stub!"); }

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
public android.security.keystore.KeyProtection.Builder setInvalidatedByBiometricEnrollment(boolean invalidateKey) { throw new RuntimeException("Stub!"); }

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
public android.security.keystore.KeyProtection.Builder setUnlockedDeviceRequired(boolean unlockedDeviceRequired) { throw new RuntimeException("Stub!"); }

/**
 * Builds an instance of {@link android.security.keystore.KeyProtection KeyProtection}.
 *
 * @throws java.lang.IllegalArgumentException if a required field is missing
 
 * @return This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.security.keystore.KeyProtection build() { throw new RuntimeException("Stub!"); }
}

}

