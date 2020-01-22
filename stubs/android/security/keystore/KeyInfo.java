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

import javax.crypto.SecretKey;
import java.security.PrivateKey;

/**
 * Information about a key from the <a href="{@docRoot}training/articles/keystore.html">Android
 * Keystore system</a>. This class describes whether the key material is available in
 * plaintext outside of secure hardware, whether user authentication is required for using the key
 * and whether this requirement is enforced by secure hardware, the key's origin, what uses the key
 * is authorized for (e.g., only in {@code GCM} mode, or signing only), whether the key should be
 * encrypted at rest, the key's and validity start and end dates.
 *
 * <p>Instances of this class are immutable.
 *
 * <p><h3>Example: Symmetric Key</h3>
 * The following example illustrates how to obtain a {@code KeyInfo} describing the provided Android
 * Keystore {@link javax.crypto.SecretKey SecretKey}.
 * <pre>{@code
 * SecretKey key = ...; // Android Keystore key
 *
 * SecretKeyFactory factory = SecretKeyFactory.getInstance(key.getAlgorithm(), "AndroidKeyStore");
 * KeyInfo keyInfo;
 * try {
 *     keyInfo = (KeyInfo) factory.getKeySpec(key, KeyInfo.class);
 * } catch (InvalidKeySpecException e) {
 *     // Not an Android KeyStore key.
 * }}</pre>
 *
 * <p><h3>Example: Private Key</h3>
 * The following example illustrates how to obtain a {@code KeyInfo} describing the provided
 * Android KeyStore {@link java.security.PrivateKey PrivateKey}.
 * <pre>{@code
 * PrivateKey key = ...; // Android KeyStore key
 *
 * KeyFactory factory = KeyFactory.getInstance(key.getAlgorithm(), "AndroidKeyStore");
 * KeyInfo keyInfo;
 * try {
 *     keyInfo = factory.getKeySpec(key, KeyInfo.class);
 * } catch (InvalidKeySpecException e) {
 *     // Not an Android KeyStore key.
 * }}</pre>
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class KeyInfo implements java.security.spec.KeySpec {

KeyInfo() { throw new RuntimeException("Stub!"); }

/**
 * Gets the entry alias under which the key is stored in the {@code AndroidKeyStore}.
 * @apiSince 23
 */

public java.lang.String getKeystoreAlias() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the key resides inside secure hardware (e.g., Trusted Execution
 * Environment (TEE) or Secure Element (SE)). Key material of such keys is available in
 * plaintext only inside the secure hardware and is not exposed outside of it.
 * @apiSince 23
 */

public boolean isInsideSecureHardware() { throw new RuntimeException("Stub!"); }

/**
 * Gets the origin of the key. See {@link android.security.keystore.KeyProperties KeyProperties}.{@code ORIGIN} constants.
 
 * @return Value is {@link android.security.keystore.KeyProperties#ORIGIN_GENERATED}, {@link android.security.keystore.KeyProperties#ORIGIN_IMPORTED}, or {@link android.security.keystore.KeyProperties#ORIGIN_UNKNOWN}
 * @apiSince 23
 */

public int getOrigin() { throw new RuntimeException("Stub!"); }

/**
 * Gets the size of the key in bits.
 * @apiSince 23
 */

public int getKeySize() { throw new RuntimeException("Stub!"); }

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
 
 * @return This value will never be {@code null}.
 
 * Value is {@link android.security.keystore.KeyProperties#DIGEST_NONE}, {@link android.security.keystore.KeyProperties#DIGEST_MD5}, {@link android.security.keystore.KeyProperties#DIGEST_SHA1}, {@link android.security.keystore.KeyProperties#DIGEST_SHA224}, {@link android.security.keystore.KeyProperties#DIGEST_SHA256}, {@link android.security.keystore.KeyProperties#DIGEST_SHA384}, or {@link android.security.keystore.KeyProperties#DIGEST_SHA512}
 * @apiSince 23
 */

@androidx.annotation.NonNull
public java.lang.String[] getDigests() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the key is authorized to be used only if the user has been
 * authenticated.
 *
 * <p>This authorization applies only to secret key and private key operations. Public key
 * operations are not restricted.
 *
 * @see #getUserAuthenticationValidityDurationSeconds()
 * @see android.security.keystore.KeyGenParameterSpec.Builder#setUserAuthenticationRequired(boolean)
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
 * @see android.security.keystore.KeyGenParameterSpec.Builder#setUserConfirmationRequired(boolean)
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
 * @apiSince 23
 */

public int getUserAuthenticationValidityDurationSeconds() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the requirement that this key can only be used if the user has been
 * authenticated is enforced by secure hardware (e.g., Trusted Execution Environment (TEE) or
 * Secure Element (SE)).
 *
 * @see #isUserAuthenticationRequired()
 * @apiSince 23
 */

public boolean isUserAuthenticationRequirementEnforcedBySecureHardware() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this key will become unusable when the device is removed from the
 * user's body.  This is possible only for keys with a specified validity duration, and only on
 * devices with an on-body sensor.  Always returns {@code false} on devices that lack an on-body
 * sensor.
 * @apiSince 24
 */

public boolean isUserAuthenticationValidWhileOnBody() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the key will be invalidated by enrollment of a new fingerprint or
 * removal of all fingerprints.
 * @apiSince 24
 */

public boolean isInvalidatedByBiometricEnrollment() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the key can only be only be used if a test for user presence has
 * succeeded since Signature.initSign() has been called.
 * @apiSince 28
 */

public boolean isTrustedUserPresenceRequired() { throw new RuntimeException("Stub!"); }
}

