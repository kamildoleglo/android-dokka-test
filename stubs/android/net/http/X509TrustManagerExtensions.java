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


package android.net.http;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * X509TrustManager wrapper exposing Android-added features.
 * <p>
 * The checkServerTrusted method allows callers to perform additional
 * verification of certificate chains after they have been successfully verified
 * by the platform.
 * </p>
 * @apiSince 17
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class X509TrustManagerExtensions {

/**
 * Constructs a new X509TrustManagerExtensions wrapper.
 *
 * @param tm A {@link javax.net.ssl.X509TrustManager X509TrustManager} as returned by TrustManagerFactory.getInstance();
 * @throws java.lang.IllegalArgumentException If tm is an unsupported TrustManager type.
 * @apiSince 17
 */

public X509TrustManagerExtensions(javax.net.ssl.X509TrustManager tm) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Verifies the given certificate chain.
 *
 * <p>See {@link javax.net.ssl.X509TrustManager#checkServerTrusted(java.security.cert.X509Certificate[],java.lang.String) X509TrustManager#checkServerTrusted(X509Certificate[], String)} for a
 * description of the chain and authType parameters. The final parameter, host, should be the
 * hostname of the server.</p>
 *
 * @throws java.security.cert.CertificateException if the chain does not verify correctly.
 * @return the properly ordered chain used for verification as a list of X509Certificates.
 * @apiSince 17
 */

public java.util.List<java.security.cert.X509Certificate> checkServerTrusted(java.security.cert.X509Certificate[] chain, java.lang.String authType, java.lang.String host) throws java.security.cert.CertificateException { throw new RuntimeException("Stub!"); }

/**
 * Checks whether a CA certificate is added by an user.
 *
 * <p>Since {@link javax.net.ssl.X509TrustManager#checkServerTrusted X509TrustManager#checkServerTrusted} may allow its parameter {@code chain} to
 * chain up to user-added CA certificates, this method can be used to perform additional
 * policies for user-added CA certificates.
 *
 * @return {@code true} to indicate that the certificate authority exists in the user added
 * certificate store, {@code false} otherwise.
 * @apiSince 21
 */

public boolean isUserAddedCertificate(java.security.cert.X509Certificate cert) { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the TrustManager uses the same trust configuration for the provided
 * hostnames.
 * @apiSince 28
 */

public boolean isSameTrustConfiguration(java.lang.String hostname1, java.lang.String hostname2) { throw new RuntimeException("Stub!"); }
}

