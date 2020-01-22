/*
 * Copyright (C) 2011 The Android Open Source Project
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

import android.content.Intent;
import java.security.cert.Certificate;
import android.app.Activity;
import android.security.keystore.KeyProperties;
import javax.security.auth.x500.X500Principal;
import java.security.PrivateKey;
import android.content.Context;
import android.app.Service;
import java.security.cert.X509Certificate;

/**
 * The {@code KeyChain} class provides access to private keys and
 * their corresponding certificate chains in credential storage.
 *
 * <p>Applications accessing the {@code KeyChain} normally go through
 * these steps:
 *
 * <ol>
 *
 * <li>Receive a callback from an {@link javax.net.ssl.X509KeyManager
 * X509KeyManager} that a private key is requested.
 *
 * <li>Call {@link #choosePrivateKeyAlias
 * choosePrivateKeyAlias} to allow the user to select from a
 * list of currently available private keys and corresponding
 * certificate chains. The chosen alias will be returned by the
 * callback {@link android.security.KeyChainAliasCallback#alias KeyChainAliasCallback#alias}, or null if no private
 * key is available or the user cancels the request.
 *
 * <li>Call {@link #getPrivateKey} and {@link #getCertificateChain} to
 * retrieve the credentials to return to the corresponding {@link
 * javax.net.ssl.X509KeyManager} callbacks.
 *
 * </ol>
 *
 * <p>An application may remember the value of a selected alias to
 * avoid prompting the user with {@link #choosePrivateKeyAlias
 * choosePrivateKeyAlias} on subsequent connections. If the alias is
 * no longer valid, null will be returned on lookups using that value
 *
 * <p>An application can request the installation of private keys and
 * certificates via the {@code Intent} provided by {@link
 * #createInstallIntent}. Private keys installed via this {@code
 * Intent} will be accessible via {@link #choosePrivateKeyAlias} while
 * Certificate Authority (CA) certificates will be trusted by all
 * applications through the default {@code X509TrustManager}.
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class KeyChain {

public KeyChain() { throw new RuntimeException("Stub!"); }

/**
 * Returns an {@code Intent} that can be used for credential
 * installation. The intent may be used without any extras, in
 * which case the user will be able to install credentials from
 * their own source.
 *
 * <p>Alternatively, {@link #EXTRA_CERTIFICATE} or {@link
 * #EXTRA_PKCS12} maybe used to specify the bytes of an X.509
 * certificate or a PKCS#12 key store for installation. These
 * extras may be combined with {@link #EXTRA_NAME} to provide a
 * default alias name for credentials being installed.
 *
 * <p>When used with {@link android.app.Activity#startActivityForResult Activity#startActivityForResult},
 * {@link android.app.Activity#RESULT_OK Activity#RESULT_OK} will be returned if a credential was
 * successfully installed, otherwise {@link android.app.Activity#RESULT_CANCELED Activity#RESULT_CANCELED} will be returned.
 
 * @return This value will never be {@code null}.
 * @apiSince 14
 */

@androidx.annotation.NonNull
public static android.content.Intent createInstallIntent() { throw new RuntimeException("Stub!"); }

/**
 * Launches an {@code Activity} for the user to select the alias
 * for a private key and certificate pair for authentication. The
 * selected alias or null will be returned via the
 * KeyChainAliasCallback callback.
 *
 * <p>A device policy controller (as a device or profile owner) can
 * intercept the request before the activity is shown, to pick a
 * specific private key alias by implementing
 * {@link android.app.admin.DeviceAdminReceiver#onChoosePrivateKeyAlias
 * onChoosePrivateKeyAlias}.
 *
 * <p>{@code keyTypes} and {@code issuers} may be used to
 * narrow down suggested choices to the user. If either {@code keyTypes}
 * or {@code issuers} is specified and non-empty, and there are no
 * matching certificates in the KeyChain, then the certificate
 * selection prompt would be suppressed entirely.
 *
 * <p>{@code host} and {@code port} may be used to give the user
 * more context about the server requesting the credentials.
 *
 * <p>{@code alias} allows the caller to preselect an existing
 * alias which will still be subject to user confirmation.
 *
 * @param activity The {@link android.app.Activity Activity} context to use for
 *     launching the new sub-Activity to prompt the user to select
 *     a private key; used only to call startActivity(); must not
 *     be null.
 * This value must never be {@code null}.
 * @param response Callback to invoke when the request completes;
 *     must not be null.
 * This value must never be {@code null}.
 * @param keyTypes The acceptable types of asymmetric keys such as
 *     "RSA", "EC" or null.
 * This value may be {@code null}.
 * Value is {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_RSA}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_EC}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_AES}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_HMAC_SHA1}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_HMAC_SHA224}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_HMAC_SHA256}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_HMAC_SHA384}, or {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_HMAC_SHA512}
 * @param issuers The acceptable certificate issuers for the
 *     certificate matching the private key, or null.
 * This value may be {@code null}.
 * @param host The host name of the server requesting the
 *     certificate, or null if unavailable.
 * This value may be {@code null}.
 * @param port The port number of the server requesting the
 *     certificate, or -1 if unavailable.
 * @param alias The alias to preselect if available, or null if
 *     unavailable.
 
 * This value may be {@code null}.
 * @apiSince 14
 */

public static void choosePrivateKeyAlias(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull android.security.KeyChainAliasCallback response, @androidx.annotation.Nullable java.lang.String[] keyTypes, @androidx.annotation.Nullable java.security.Principal[] issuers, @androidx.annotation.Nullable java.lang.String host, int port, @androidx.annotation.Nullable java.lang.String alias) { throw new RuntimeException("Stub!"); }

/**
 * Launches an {@code Activity} for the user to select the alias
 * for a private key and certificate pair for authentication. The
 * selected alias or null will be returned via the
 * KeyChainAliasCallback callback.
 *
 * <p>A device policy controller (as a device or profile owner) can
 * intercept the request before the activity is shown, to pick a
 * specific private key alias by implementing
 * {@link android.app.admin.DeviceAdminReceiver#onChoosePrivateKeyAlias
 * onChoosePrivateKeyAlias}.
 *
 * <p>{@code keyTypes} and {@code issuers} may be used to
 * narrow down suggested choices to the user. If either {@code keyTypes}
 * or {@code issuers} is specified and non-empty, and there are no
 * matching certificates in the KeyChain, then the certificate
 * selection prompt would be suppressed entirely.
 *
 * <p>{@code uri} may be used to give the user more context about
 * the server requesting the credentials.
 *
 * <p>{@code alias} allows the caller to preselect an existing
 * alias which will still be subject to user confirmation.
 *
 * @param activity The {@link android.app.Activity Activity} context to use for
 *     launching the new sub-Activity to prompt the user to select
 *     a private key; used only to call startActivity(); must not
 *     be null.
 * This value must never be {@code null}.
 * @param response Callback to invoke when the request completes;
 *     must not be null.
 * This value must never be {@code null}.
 * @param keyTypes The acceptable types of asymmetric keys such as
 *     "RSA", "EC" or null.
 * This value may be {@code null}.
 * Value is {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_RSA}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_EC}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_AES}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_HMAC_SHA1}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_HMAC_SHA224}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_HMAC_SHA256}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_HMAC_SHA384}, or {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_HMAC_SHA512}
 * @param issuers The acceptable certificate issuers for the
 *     certificate matching the private key, or null.
 * This value may be {@code null}.
 * @param uri The full URI the server is requesting the certificate
 *     for, or null if unavailable.
 * This value may be {@code null}.
 * @param alias The alias to preselect if available, or null if
 *     unavailable.
 * This value may be {@code null}.
 * @throws java.lang.IllegalArgumentException if the specified issuers are not
 *     of type {@code X500Principal}.
 * @apiSince 23
 */

public static void choosePrivateKeyAlias(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull android.security.KeyChainAliasCallback response, @androidx.annotation.Nullable java.lang.String[] keyTypes, @androidx.annotation.Nullable java.security.Principal[] issuers, @androidx.annotation.Nullable android.net.Uri uri, @androidx.annotation.Nullable java.lang.String alias) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@code PrivateKey} for the requested alias, or null if the alias does not exist
 * or the caller has no permission to access it (see note on exceptions below).
 *
 * <p> This method may block while waiting for a connection to another process, and must never
 * be called from the main thread.
 * <p> As {@link android.app.Activity Activity} and {@link android.app.Service Service} contexts are short-lived and can be destroyed
 * at any time from the main thread, it is safer to rely on a long-lived context such as one
 * returned from {@link android.content.Context#getApplicationContext() Context#getApplicationContext()}.
 *
 * <p> If the caller provides a valid alias to which it was not granted access, then the
 * caller must invoke {@link #choosePrivateKeyAlias} again to get another valid alias
 * or a grant to access the same alias.
 * <p>On Android versions prior to Q, when a key associated with the specified alias is
 * unavailable, the method will throw a {@code KeyChainException} rather than return null.
 * If the exception's cause (as obtained by calling {@code KeyChainException.getCause()})
 * is a throwable of type {@code IllegalStateException} then the caller lacks a grant
 * to access the key and certificates associated with this alias.
 *
 * <br>
 * This method may take several seconds to complete, so it should
 * only be called from a worker thread.
 * @param alias The alias of the desired private key, typically returned via
 *              {@link android.security.KeyChainAliasCallback#alias KeyChainAliasCallback#alias}.
 * This value must never be {@code null}.
 * @throws android.security.KeyChainException if the alias was valid but there was some problem accessing it.
 * @throws java.lang.IllegalStateException if called from the main thread.
 
 * @param context This value must never be {@code null}.
 * @apiSince 14
 */

@androidx.annotation.Nullable
public static java.security.PrivateKey getPrivateKey(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String alias) throws java.lang.InterruptedException, android.security.KeyChainException { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@code X509Certificate} chain for the requested alias, or null if the alias
 * does not exist or the caller has no permission to access it (see note on exceptions
 * in {@link #getPrivateKey}).
 *
 * <p>
 * <strong>Note:</strong> If a certificate chain was explicitly specified when the alias was
 * installed, this method will return that chain. If only the client certificate was specified
 * at the installation time, this method will try to build a certificate chain using all
 * available trust anchors (preinstalled and user-added).
 *
 * <p> This method may block while waiting for a connection to another process, and must never
 * be called from the main thread.
 * <p> As {@link android.app.Activity Activity} and {@link android.app.Service Service} contexts are short-lived and can be destroyed
 * at any time from the main thread, it is safer to rely on a long-lived context such as one
 * returned from {@link android.content.Context#getApplicationContext() Context#getApplicationContext()}.
 * <p> In case the caller specifies an alias for which it lacks a grant, it must call
 * {@link #choosePrivateKeyAlias} again. See {@link #getPrivateKey} for more details on
 * coping with this scenario.
 *
 * <br>
 * This method may take several seconds to complete, so it should
 * only be called from a worker thread.
 * @param alias The alias of the desired certificate chain, typically
 * returned via {@link android.security.KeyChainAliasCallback#alias KeyChainAliasCallback#alias}.
 * This value must never be {@code null}.
 * @throws android.security.KeyChainException if the alias was valid but there was some problem accessing it.
 * @throws java.lang.IllegalStateException if called from the main thread.
 
 * @param context This value must never be {@code null}.
 * @apiSince 14
 */

@androidx.annotation.Nullable
public static java.security.cert.X509Certificate[] getCertificateChain(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String alias) throws java.lang.InterruptedException, android.security.KeyChainException { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the current device's {@code KeyChain} supports a
 * specific {@code PrivateKey} type indicated by {@code algorithm} (e.g.,
 * "RSA").
 
 * @param algorithm This value must never be {@code null}.
 
 * Value is {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_RSA}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_EC}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_AES}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_HMAC_SHA1}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_HMAC_SHA224}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_HMAC_SHA256}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_HMAC_SHA384}, or {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_HMAC_SHA512}
 * @apiSince 18
 */

public static boolean isKeyAlgorithmSupported(@androidx.annotation.NonNull java.lang.String algorithm) { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the current device's {@code KeyChain} binds any
 * {@code PrivateKey} of the given {@code algorithm} to the device once
 * imported or generated. This can be used to tell if there is special
 * hardware support that can be used to bind keys to the device in a way
 * that makes it non-exportable.
 *
 * @deprecated Whether the key is bound to the secure hardware is known only
 * once the key has been imported. To find out, use:
 * <pre>{@code
 * PrivateKey key = ...; // private key from KeyChain
 *
 * KeyFactory keyFactory =
 *     KeyFactory.getInstance(key.getAlgorithm(), "AndroidKeyStore");
 * KeyInfo keyInfo = keyFactory.getKeySpec(key, KeyInfo.class);
 * if (keyInfo.isInsideSecureHardware()) {
 *     // The key is bound to the secure hardware of this Android
 * }}</pre>
 
 * @param algorithm This value must never be {@code null}.
 
 * Value is {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_RSA}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_EC}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_AES}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_HMAC_SHA1}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_HMAC_SHA224}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_HMAC_SHA256}, {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_HMAC_SHA384}, or {@link android.security.keystore.KeyProperties#KEY_ALGORITHM_HMAC_SHA512}
 * @apiSince 18
 * @deprecatedSince 23
 */

@Deprecated
public static boolean isBoundKeyAlgorithm(@androidx.annotation.NonNull java.lang.String algorithm) { throw new RuntimeException("Stub!"); }

/**
 * Broadcast Action: Indicates the contents of the keychain has changed. Sent when a KeyChain
 * entry is added, modified or removed.
 * @apiSince 26
 */

public static final java.lang.String ACTION_KEYCHAIN_CHANGED = "android.security.action.KEYCHAIN_CHANGED";

/**
 * Broadcast Action: Indicates that the access permissions for a private key have changed.
 *
 * @apiSince 26
 */

public static final java.lang.String ACTION_KEY_ACCESS_CHANGED = "android.security.action.KEY_ACCESS_CHANGED";

/**
 * Broadcast Action: Indicates the trusted storage has changed. Sent when
 * one of this happens:
 *
 * <ul>
 * <li>a new CA is added,
 * <li>an existing CA is removed or disabled,
 * <li>a disabled CA is enabled,
 * <li>trusted storage is reset (all user certs are cleared),
 * <li>when permission to access a private key is changed.
 * </ul>
 *
 * @deprecated Use {@link #ACTION_KEYCHAIN_CHANGED}, {@link #ACTION_TRUST_STORE_CHANGED} or
 * {@link #ACTION_KEY_ACCESS_CHANGED}. Apps that target a version higher than
 * {@link android.os.Build.VERSION_CODES#N_MR1} will only receive this broadcast if they
 * register for it at runtime.
 * @apiSince 16
 * @deprecatedSince 26
 */

@Deprecated public static final java.lang.String ACTION_STORAGE_CHANGED = "android.security.STORAGE_CHANGED";

/**
 * Broadcast Action: Indicates the contents of the trusted certificate store has changed. Sent
 * when one the following occurs:
 *
 * <ul>
 * <li>A pre-installed CA is disabled or re-enabled</li>
 * <li>A CA is added or removed from the trust store</li>
 * </ul>
 * @apiSince 26
 */

public static final java.lang.String ACTION_TRUST_STORE_CHANGED = "android.security.action.TRUST_STORE_CHANGED";

/**
 * Optional extra to specify an X.509 certificate to install on
 * the {@code Intent} returned by {@link #createInstallIntent}.
 * The extra value should be a PEM or ASN.1 DER encoded {@code
 * byte[]}. An {@link java.security.cert.X509Certificate X509Certificate} can be converted to DER
 * encoded bytes with {@link java.security.cert.X509Certificate#getEncoded X509Certificate#getEncoded}.
 *
 * <p>{@link #EXTRA_NAME} may be used to provide a default alias
 * name for the installed certificate.
 * @apiSince 14
 */

public static final java.lang.String EXTRA_CERTIFICATE = "CERT";

/**
 * Used as a boolean extra field in {@link #ACTION_KEY_ACCESS_CHANGED} to supply if the key is
 * accessible to the application.
 * @apiSince 26
 */

public static final java.lang.String EXTRA_KEY_ACCESSIBLE = "android.security.extra.KEY_ACCESSIBLE";

/**
 * Used as a String extra field in {@link #ACTION_KEY_ACCESS_CHANGED} to supply the alias of
 * the key.
 * @apiSince 26
 */

public static final java.lang.String EXTRA_KEY_ALIAS = "android.security.extra.KEY_ALIAS";

/**
 * Optional extra to specify a {@code String} credential name on
 * the {@code Intent} returned by {@link #createInstallIntent}.
 * @apiSince 14
 */

public static final java.lang.String EXTRA_NAME = "name";

/**
 * Optional extra for use with the {@code Intent} returned by
 * {@link #createInstallIntent} to specify a PKCS#12 key store to
 * install. The extra value should be a {@code byte[]}. The bytes
 * may come from an external source or be generated with {@link
 * java.security.KeyStore#store} on a "PKCS12" instance.
 *
 * <p>The user will be prompted for the password to load the key store.
 *
 * <p>The key store will be scanned for {@link
 * java.security.KeyStore.PrivateKeyEntry} entries and both the
 * private key and associated certificate chain will be installed.
 *
 * <p>{@link #EXTRA_NAME} may be used to provide a default alias
 * name for the installed credentials.
 * @apiSince 14
 */

public static final java.lang.String EXTRA_PKCS12 = "PKCS12";
}

