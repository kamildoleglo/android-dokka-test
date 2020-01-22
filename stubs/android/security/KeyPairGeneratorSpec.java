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


package android.security;

import java.security.PrivateKey;
import android.security.keystore.KeyGenParameterSpec;
import java.security.cert.Certificate;
import android.security.keystore.KeyProperties;
import java.security.spec.AlgorithmParameterSpec;
import android.app.KeyguardManager;
import java.math.BigInteger;
import javax.security.auth.x500.X500Principal;

/**
 * This provides the required parameters needed for initializing the
 * {@code KeyPairGenerator} that works with
 * <a href="{@docRoot}training/articles/keystore.html">Android KeyStore
 * facility</a>. The Android KeyStore facility is accessed through a
 * {@link java.security.KeyPairGenerator} API using the {@code AndroidKeyStore}
 * provider. The {@code context} passed in may be used to pop up some UI to ask
 * the user to unlock or initialize the Android KeyStore facility.
 * <p>
 * After generation, the {@code keyStoreAlias} is used with the
 * {@link java.security.KeyStore#getEntry(String, java.security.KeyStore.ProtectionParameter)}
 * interface to retrieve the {@link java.security.PrivateKey PrivateKey} and its associated
 * {@link java.security.cert.Certificate Certificate} chain.
 * <p>
 * The KeyPair generator will create a self-signed certificate with the subject
 * as its X.509v3 Subject Distinguished Name and as its X.509v3 Issuer
 * Distinguished Name along with the other parameters specified with the
 * {@link android.security.KeyPairGeneratorSpec.Builder Builder}.
 * <p>
 * The self-signed X.509 certificate may be replaced at a later time by a
 * certificate signed by a real Certificate Authority.
 *
 * @deprecated Use {@link android.security.keystore.KeyGenParameterSpec KeyGenParameterSpec} instead.
 * @apiSince 18
 * @deprecatedSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public final class KeyPairGeneratorSpec implements java.security.spec.AlgorithmParameterSpec {

KeyPairGeneratorSpec() { throw new RuntimeException("Stub!"); }

/**
 * Gets the Android context used for operations with this instance.
 * @apiSince 18
 * @deprecatedSince 23
 */

@Deprecated
public android.content.Context getContext() { throw new RuntimeException("Stub!"); }

/**
 * Returns the alias that will be used in the {@code java.security.KeyStore}
 * in conjunction with the {@code AndroidKeyStore}.
 * @apiSince 18
 * @deprecatedSince 23
 */

@Deprecated
public java.lang.String getKeystoreAlias() { throw new RuntimeException("Stub!"); }

/**
 * Returns the type of key pair (e.g., {@code EC}, {@code RSA}) to be generated. See
 * {@link android.security.keystore.KeyProperties KeyProperties}.{@code KEY_ALGORITHM} constants.
 
 * @return This value may be {@code null}.
 
 * Value is {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_RSA}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_EC}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_AES}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_HMAC_SHA1}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_HMAC_SHA224}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_HMAC_SHA256}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_HMAC_SHA384}, or {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_HMAC_SHA512}
 * @apiSince 19
 * @deprecatedSince 23
 */

@Deprecated
@androidx.annotation.Nullable
public java.lang.String getKeyType() { throw new RuntimeException("Stub!"); }

/**
 * Returns the key size specified by this parameter. For instance, for RSA
 * this will return the modulus size and for EC it will return the field
 * size.
 * @apiSince 19
 * @deprecatedSince 23
 */

@Deprecated
public int getKeySize() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link java.security.spec.AlgorithmParameterSpec AlgorithmParameterSpec} that will be used for creation
 * of the key pair.
 
 * @return This value will never be {@code null}.
 * @apiSince 19
 * @deprecatedSince 23
 */

@Deprecated
@androidx.annotation.NonNull
public java.security.spec.AlgorithmParameterSpec getAlgorithmParameterSpec() { throw new RuntimeException("Stub!"); }

/**
 * Gets the subject distinguished name to be used on the X.509 certificate
 * that will be put in the {@link java.security.KeyStore}.
 
 * @return This value will never be {@code null}.
 * @apiSince 18
 * @deprecatedSince 23
 */

@Deprecated
@androidx.annotation.NonNull
public javax.security.auth.x500.X500Principal getSubjectDN() { throw new RuntimeException("Stub!"); }

/**
 * Gets the serial number to be used on the X.509 certificate that will be
 * put in the {@link java.security.KeyStore}.
 
 * @return This value will never be {@code null}.
 * @apiSince 18
 * @deprecatedSince 23
 */

@Deprecated
@androidx.annotation.NonNull
public java.math.BigInteger getSerialNumber() { throw new RuntimeException("Stub!"); }

/**
 * Gets the start date to be used on the X.509 certificate that will be put
 * in the {@link java.security.KeyStore}.
 
 * @return This value will never be {@code null}.
 * @apiSince 18
 * @deprecatedSince 23
 */

@Deprecated
@androidx.annotation.NonNull
public java.util.Date getStartDate() { throw new RuntimeException("Stub!"); }

/**
 * Gets the end date to be used on the X.509 certificate that will be put in
 * the {@link java.security.KeyStore}.
 
 * @return This value will never be {@code null}.
 * @apiSince 18
 * @deprecatedSince 23
 */

@Deprecated
@androidx.annotation.NonNull
public java.util.Date getEndDate() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the key must be encrypted at rest. This will protect the key pair
 * with the secure lock screen credential (e.g., password, PIN, or pattern).
 *
 * <p>Note that encrypting the key at rest requires that the secure lock screen (e.g., password,
 * PIN, pattern) is set up, otherwise key generation will fail. Moreover, this key will be
 * deleted when the secure lock screen is disabled or reset (e.g., by the user or a Device
 * Administrator). Finally, this key cannot be used until the user unlocks the secure lock
 * screen after boot.
 *
 * @see android.app.KeyguardManager#isDeviceSecure()
 * @apiSince 18
 * @deprecatedSince 23
 */

@Deprecated
public boolean isEncryptionRequired() { throw new RuntimeException("Stub!"); }
/**
 * Builder class for {@link android.security.KeyPairGeneratorSpec KeyPairGeneratorSpec} objects.
 * <p>
 * This will build a parameter spec for use with the
 * <a href="{@docRoot}training/articles/keystore.html">Android KeyStore
 * facility</a>.
 * <p>
 * The required fields must be filled in with the builder.
 * <p>
 * Example:
 *
 * <pre class="prettyprint">
 * Calendar start = Calendar.getInstance();
 * Calendar end = Calendar.getInstance();
 * end.add(Calendar.YEAR, 1);
 *
 * KeyPairGeneratorSpec spec =
 *         new KeyPairGeneratorSpec.Builder(mContext).setAlias(&quot;myKey&quot;)
 *                 .setSubject(new X500Principal(&quot;CN=myKey&quot;)).setSerialNumber(BigInteger.valueOf(1337))
 *                 .setStartDate(start.getTime()).setEndDate(end.getTime()).build();
 * </pre>
 *
 *  @deprecated Use {@link android.security.keystore.KeyGenParameterSpec.Builder KeyGenParameterSpec.Builder} instead.
 * @apiSince 18
 * @deprecatedSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static final class Builder {

/**
 * Creates a new instance of the {@code Builder} with the given
 * {@code context}. The {@code context} passed in may be used to pop up
 * some UI to ask the user to unlock or initialize the Android KeyStore
 * facility.
 
 * @param context This value must never be {@code null}.
 * @apiSince 18
 */

@Deprecated
public Builder(@androidx.annotation.NonNull android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Sets the alias to be used to retrieve the key later from a
 * {@link java.security.KeyStore} instance using the
 * {@code AndroidKeyStore} provider.
 
 * @param alias This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 18
 * @deprecatedSince 23
 */

@Deprecated
@androidx.annotation.NonNull
public android.security.KeyPairGeneratorSpec.Builder setAlias(@androidx.annotation.NonNull java.lang.String alias) { throw new RuntimeException("Stub!"); }

/**
 * Sets the type of key pair (e.g., {@code EC}, {@code RSA}) of the key pair to be
 * generated. See {@link android.security.keystore.KeyProperties KeyProperties}.{@code KEY_ALGORITHM} constants.
 *
 
 * @param keyType This value must never be {@code null}.
 * Value is {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_RSA}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_EC}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_AES}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_HMAC_SHA1}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_HMAC_SHA224}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_HMAC_SHA256}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_HMAC_SHA384}, or {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_HMAC_SHA512}
 * @return This value will never be {@code null}.
 * @apiSince 19
 * @deprecatedSince 23
 */

@Deprecated
@androidx.annotation.NonNull
public android.security.KeyPairGeneratorSpec.Builder setKeyType(@androidx.annotation.NonNull java.lang.String keyType) throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Sets the key size for the keypair to be created. For instance, for a
 * key type of RSA this will set the modulus size and for a key type of
 * EC it will select a curve with a matching field size.
 
 * @return This value will never be {@code null}.
 * @apiSince 19
 * @deprecatedSince 23
 */

@Deprecated
@androidx.annotation.NonNull
public android.security.KeyPairGeneratorSpec.Builder setKeySize(int keySize) { throw new RuntimeException("Stub!"); }

/**
 * Sets the algorithm-specific key generation parameters. For example, for RSA keys
 * this may be an instance of {@link java.security.spec.RSAKeyGenParameterSpec}.
 
 * @param spec This value must never be {@code null}.
 * @apiSince 19
 * @deprecatedSince 23
 */

@Deprecated
public android.security.KeyPairGeneratorSpec.Builder setAlgorithmParameterSpec(@androidx.annotation.NonNull java.security.spec.AlgorithmParameterSpec spec) { throw new RuntimeException("Stub!"); }

/**
 * Sets the subject used for the self-signed certificate of the
 * generated key pair.
 
 * @param subject This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 18
 * @deprecatedSince 23
 */

@Deprecated
@androidx.annotation.NonNull
public android.security.KeyPairGeneratorSpec.Builder setSubject(@androidx.annotation.NonNull javax.security.auth.x500.X500Principal subject) { throw new RuntimeException("Stub!"); }

/**
 * Sets the serial number used for the self-signed certificate of the
 * generated key pair.
 
 * @param serialNumber This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 18
 * @deprecatedSince 23
 */

@Deprecated
@androidx.annotation.NonNull
public android.security.KeyPairGeneratorSpec.Builder setSerialNumber(@androidx.annotation.NonNull java.math.BigInteger serialNumber) { throw new RuntimeException("Stub!"); }

/**
 * Sets the start of the validity period for the self-signed certificate
 * of the generated key pair.
 
 * @param startDate This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 18
 * @deprecatedSince 23
 */

@Deprecated
@androidx.annotation.NonNull
public android.security.KeyPairGeneratorSpec.Builder setStartDate(@androidx.annotation.NonNull java.util.Date startDate) { throw new RuntimeException("Stub!"); }

/**
 * Sets the end of the validity period for the self-signed certificate
 * of the generated key pair.
 
 * @param endDate This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 18
 * @deprecatedSince 23
 */

@Deprecated
@androidx.annotation.NonNull
public android.security.KeyPairGeneratorSpec.Builder setEndDate(@androidx.annotation.NonNull java.util.Date endDate) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that this key pair must be encrypted at rest. This will protect the key pair
 * with the secure lock screen credential (e.g., password, PIN, or pattern).
 *
 * <p>Note that this feature requires that the secure lock screen (e.g., password, PIN,
 * pattern) is set up, otherwise key pair generation will fail. Moreover, this key pair will
 * be deleted when the secure lock screen is disabled or reset (e.g., by the user or a
 * Device Administrator). Finally, this key pair cannot be used until the user unlocks the
 * secure lock screen after boot.
 *
 * @see android.app.KeyguardManager#isDeviceSecure()
 
 * @return This value will never be {@code null}.
 * @apiSince 18
 * @deprecatedSince 23
 */

@Deprecated
@androidx.annotation.NonNull
public android.security.KeyPairGeneratorSpec.Builder setEncryptionRequired() { throw new RuntimeException("Stub!"); }

/**
 * Builds the instance of the {@code KeyPairGeneratorSpec}.
 *
 * @throws java.lang.IllegalArgumentException if a required field is missing
 * @return built instance of {@code KeyPairGeneratorSpec}
 
 * This value will never be {@code null}.
 * @apiSince 18
 * @deprecatedSince 23
 */

@Deprecated
@androidx.annotation.NonNull
public android.security.KeyPairGeneratorSpec build() { throw new RuntimeException("Stub!"); }
}

}

