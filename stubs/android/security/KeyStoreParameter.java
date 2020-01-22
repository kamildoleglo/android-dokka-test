/*
 * Copyright (C) 2013 The Android Open Source Project
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

import java.security.KeyPairGenerator;
import android.security.keystore.KeyProtection;
import android.app.KeyguardManager;

/**
 * This provides the optional parameters that can be specified for
 * {@code KeyStore} entries that work with
 * <a href="{@docRoot}training/articles/keystore.html">Android KeyStore
 * facility</a>. The Android KeyStore facility is accessed through a
 * {@link java.security.KeyStore} API using the {@code AndroidKeyStore}
 * provider. The {@code context} passed in may be used to pop up some UI to ask
 * the user to unlock or initialize the Android KeyStore facility.
 * <p>
 * Any entries placed in the {@code KeyStore} may be retrieved later. Note that
 * there is only one logical instance of the {@code KeyStore} per application
 * UID so apps using the {@code sharedUid} facility will also share a
 * {@code KeyStore}.
 * <p>
 * Keys may be generated using the {@link java.security.KeyPairGenerator KeyPairGenerator} facility with a
 * {@link android.security.KeyPairGeneratorSpec KeyPairGeneratorSpec} to specify the entry's {@code alias}. A
 * self-signed X.509 certificate will be attached to generated entries, but that
 * may be replaced at a later time by a certificate signed by a real Certificate
 * Authority.
 *
 * @deprecated Use {@link android.security.keystore.KeyProtection KeyProtection} instead.
 * @apiSince 18
 * @deprecatedSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public final class KeyStoreParameter implements java.security.KeyStore.ProtectionParameter {

private KeyStoreParameter() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the {@link java.security.KeyStore} entry must be encrypted at rest.
 * This will protect the entry with the secure lock screen credential (e.g., password, PIN, or
 * pattern).
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
 * Builder class for {@link android.security.KeyStoreParameter KeyStoreParameter} objects.
 * <p>
 * This will build protection parameters for use with the
 * <a href="{@docRoot}training/articles/keystore.html">Android KeyStore
 * facility</a>.
 * <p>
 * This can be used to require that KeyStore entries be stored encrypted.
 * <p>
 * Example:
 *
 * <pre class="prettyprint">
 * KeyStoreParameter params = new KeyStoreParameter.Builder(mContext)
 *         .setEncryptionRequired()
 *         .build();
 * </pre>
 *
 *  @deprecated Use {@link android.security.keystore.KeyProtection.Builder KeyProtection.Builder} instead.
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
 * Sets whether this {@link java.security.KeyStore} entry must be encrypted at rest.
 * Encryption at rest will protect the entry with the secure lock screen credential (e.g.,
 * password, PIN, or pattern).
 *
 * <p>Note that enabling this feature requires that the secure lock screen (e.g., password,
 * PIN, pattern) is set up, otherwise setting the {@code KeyStore} entry will fail.
 * Moreover, this entry will be deleted when the secure lock screen is disabled or reset
 * (e.g., by the user or a Device Administrator). Finally, this entry cannot be used until
 * the user unlocks the secure lock screen after boot.
 *
 * @see android.app.KeyguardManager#isDeviceSecure()
 
 * @return This value will never be {@code null}.
 * @apiSince 18
 * @deprecatedSince 23
 */

@Deprecated
@androidx.annotation.NonNull
public android.security.KeyStoreParameter.Builder setEncryptionRequired(boolean required) { throw new RuntimeException("Stub!"); }

/**
 * Builds the instance of the {@code KeyStoreParameter}.
 *
 * @throws java.lang.IllegalArgumentException if a required field is missing
 * @return built instance of {@code KeyStoreParameter}
 
 * This value will never be {@code null}.
 * @apiSince 18
 * @deprecatedSince 23
 */

@Deprecated
@androidx.annotation.NonNull
public android.security.KeyStoreParameter build() { throw new RuntimeException("Stub!"); }
}

}

