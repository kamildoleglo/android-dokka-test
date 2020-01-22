/*
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/conn/ssl/SSLSocketFactory.java $
 * $Revision: 659194 $
 * $Date: 2008-05-22 11:33:47 -0700 (Thu, 22 May 2008) $
 *
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */


package org.apache.http.conn.ssl;

import java.security.KeyStore;

/**
 * Layered socket factory for TLS/SSL connections, based on JSSE.
 *.
 * <p>
 * SSLSocketFactory can be used to validate the identity of the HTTPS
 * server against a list of trusted certificates and to authenticate to
 * the HTTPS server using a private key.
 * </p>
 *
 * <p>
 * SSLSocketFactory will enable server authentication when supplied with
 * a {@link java.security.KeyStore KeyStore} file containg one or several trusted
 * certificates. The client secure socket will reject the connection during
 * the SSL session handshake if the target HTTPS server attempts to
 * authenticate itself with a non-trusted certificate.
 * </p>
 *
 * <p>
 * Use JDK keytool utility to import a trusted certificate and generate a truststore file:
 *    <pre>
 *     keytool -import -alias "my server cert" -file server.crt -keystore my.truststore
 *    </pre>
 * </p>
 *
 * <p>
 * SSLSocketFactory will enable client authentication when supplied with
 * a {@link java.security.KeyStore KeyStore} file containg a private key/public certificate
 * pair. The client secure socket will use the private key to authenticate
 * itself to the target HTTPS server during the SSL session handshake if
 * requested to do so by the server.
 * The target HTTPS server will in its turn verify the certificate presented
 * by the client in order to establish client's authenticity
 * </p>
 *
 * <p>
 * Use the following sequence of actions to generate a keystore file
 * </p>
 *   <ul>
 *     <li>
 *      <p>
 *      Use JDK keytool utility to generate a new key
 *      <pre>keytool -genkey -v -alias "my client key" -validity 365 -keystore my.keystore</pre>
 *      For simplicity use the same password for the key as that of the keystore
 *      </p>
 *     </li>
 *     <li>
 *      <p>
 *      Issue a certificate signing request (CSR)
 *      <pre>keytool -certreq -alias "my client key" -file mycertreq.csr -keystore my.keystore</pre>
 *     </p>
 *     </li>
 *     <li>
 *      <p>
 *      Send the certificate request to the trusted Certificate Authority for signature.
 *      One may choose to act as her own CA and sign the certificate request using a PKI
 *      tool, such as OpenSSL.
 *      </p>
 *     </li>
 *     <li>
 *      <p>
 *       Import the trusted CA root certificate
 *       <pre>keytool -import -alias "my trusted ca" -file caroot.crt -keystore my.keystore</pre>
 *      </p>
 *     </li>
 *     <li>
 *      <p>
 *       Import the PKCS#7 file containg the complete certificate chain
 *       <pre>keytool -import -alias "my client key" -file mycert.p7 -keystore my.keystore</pre>
 *      </p>
 *     </li>
 *     <li>
 *      <p>
 *       Verify the content the resultant keystore file
 *       <pre>keytool -list -v -keystore my.keystore</pre>
 *      </p>
 *     </li>
 *   </ul>
 * @author <a href="mailto:oleg at ural.ru">Oleg Kalnichevski</a>
 * @author Julius Davies
 *
 * @deprecated Please use {@link java.net.URL#openConnection} instead.
 *     Please visit <a href="http://android-developers.blogspot.com/2011/09/androids-http-clients.html">this webpage</a>
 *     for further details.
 * @apiSince 1
 * @deprecatedSince 22
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class SSLSocketFactory implements org.apache.http.conn.scheme.LayeredSocketFactory {

/** @apiSince 1 */

@Deprecated
public SSLSocketFactory(java.lang.String algorithm, java.security.KeyStore keystore, java.lang.String keystorePassword, java.security.KeyStore truststore, java.security.SecureRandom random, org.apache.http.conn.scheme.HostNameResolver nameResolver) throws java.security.KeyManagementException, java.security.KeyStoreException, java.security.NoSuchAlgorithmException, java.security.UnrecoverableKeyException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@Deprecated
public SSLSocketFactory(java.security.KeyStore keystore, java.lang.String keystorePassword, java.security.KeyStore truststore) throws java.security.KeyManagementException, java.security.KeyStoreException, java.security.NoSuchAlgorithmException, java.security.UnrecoverableKeyException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@Deprecated
public SSLSocketFactory(java.security.KeyStore keystore, java.lang.String keystorePassword) throws java.security.KeyManagementException, java.security.KeyStoreException, java.security.NoSuchAlgorithmException, java.security.UnrecoverableKeyException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@Deprecated
public SSLSocketFactory(java.security.KeyStore truststore) throws java.security.KeyManagementException, java.security.KeyStoreException, java.security.NoSuchAlgorithmException, java.security.UnrecoverableKeyException { throw new RuntimeException("Stub!"); }

/**
 * Gets an singleton instance of the SSLProtocolSocketFactory.
 * @return a SSLProtocolSocketFactory
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public static org.apache.http.conn.ssl.SSLSocketFactory getSocketFactory() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public java.net.Socket createSocket() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public java.net.Socket connectSocket(java.net.Socket sock, java.lang.String host, int port, java.net.InetAddress localAddress, int localPort, org.apache.http.params.HttpParams params) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Checks whether a socket connection is secure.
 * This factory creates TLS/SSL socket connections
 * which, by default, are considered secure.
 * <br/>
 * Derived classes may override this method to perform
 * runtime checks, for example based on the cypher suite.
 *
 * @param sock      the connected socket
 *
 * @return  <code>true</code>
 *
 * @throws java.lang.IllegalArgumentException if the argument is invalid
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public boolean isSecure(java.net.Socket sock) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public java.net.Socket createSocket(java.net.Socket socket, java.lang.String host, int port, boolean autoClose) throws java.io.IOException, java.net.UnknownHostException { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public void setHostnameVerifier(org.apache.http.conn.ssl.X509HostnameVerifier hostnameVerifier) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated
public org.apache.http.conn.ssl.X509HostnameVerifier getHostnameVerifier() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated public static final org.apache.http.conn.ssl.X509HostnameVerifier ALLOW_ALL_HOSTNAME_VERIFIER;
static { ALLOW_ALL_HOSTNAME_VERIFIER = null; }

/**
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated public static final org.apache.http.conn.ssl.X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;
static { BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = null; }

/**
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated public static final java.lang.String SSL = "SSL";

/**
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated public static final java.lang.String SSLV2 = "SSLv2";

/**
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated public static final org.apache.http.conn.ssl.X509HostnameVerifier STRICT_HOSTNAME_VERIFIER;
static { STRICT_HOSTNAME_VERIFIER = null; }

/**
 * @apiSince 1
 * @deprecatedSince 22
 */

@Deprecated public static final java.lang.String TLS = "TLS";
}

