/*
 * Copyright (C) 2014 The Android Open Source Project
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


package android.webkit;


/**
 * ClientCertRequest: The user receives an instance of this class as
 * a parameter of {@link android.webkit.WebViewClient#onReceivedClientCertRequest WebViewClient#onReceivedClientCertRequest}.
 * The request includes the parameters to choose the client certificate,
 * such as the host name and the port number requesting the cert, the acceptable
 * key types and the principals.
 *
 * The user should call one of the class methods to indicate how to deal
 * with the client certificate request. All methods should be called on
 * UI thread.
 *
 * WebView caches the {@link #proceed} and {@link #cancel} responses in memory
 * and uses them to handle future client certificate requests for the same
 * host/port pair. The user can clear the cached data using
 * {@link android.webkit.WebView#clearClientCertPreferences WebView#clearClientCertPreferences}.
 *
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class ClientCertRequest {

/** @apiSince 21 */

public ClientCertRequest() { throw new RuntimeException("Stub!"); }

/**
 * Returns the acceptable types of asymmetric keys.
 
 * @return This value may be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public abstract java.lang.String[] getKeyTypes();

/**
 * Returns the acceptable certificate issuers for the certificate
 *            matching the private key.
 
 * @return This value may be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public abstract java.security.Principal[] getPrincipals();

/**
 * Returns the host name of the server requesting the certificate.
 * @apiSince 21
 */

public abstract java.lang.String getHost();

/**
 * Returns the port number of the server requesting the certificate.
 * @apiSince 21
 */

public abstract int getPort();

/**
 * Proceed with the specified private key and client certificate chain.
 * Remember the user's positive choice and use it for future requests.
 * @apiSince 21
 */

public abstract void proceed(java.security.PrivateKey privateKey, java.security.cert.X509Certificate[] chain);

/**
 * Ignore the request for now. Do not remember user's choice.
 * @apiSince 21
 */

public abstract void ignore();

/**
 * Cancel this request. Remember the user's choice and use it for
 * future requests.
 * @apiSince 21
 */

public abstract void cancel();
}

