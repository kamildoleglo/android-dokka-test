/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1999, 2012, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */



package javax.net.ssl;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * <code>HttpsURLConnection</code> extends <code>HttpURLConnection</code>
 * with support for https-specific features.
 * <P>
 * See <A HREF="http://www.w3.org/pub/WWW/Protocols/">
 * http://www.w3.org/pub/WWW/Protocols/</A> and
 * <A HREF="http://www.ietf.org/"> RFC 2818 </A>
 * for more details on the
 * https specification.
 * <P>
 * This class uses <code>HostnameVerifier</code> and
 * <code>SSLSocketFactory</code>.
 * There are default implementations defined for both classes.
 * However, the implementations can be replaced on a per-class (static) or
 * per-instance basis.  All new <code>HttpsURLConnection</code>s instances
 * will be assigned
 * the "default" static values at instance creation, but they can be overriden
 * by calling the appropriate per-instance set method(s) before
 * <code>connect</code>ing.
 *
 * @since 1.4
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class HttpsURLConnection extends java.net.HttpURLConnection {

/**
 * Creates an <code>HttpsURLConnection</code> using the
 * URL specified.
 *
 * @param url the URL
 * @apiSince 1
 */

protected HttpsURLConnection(java.net.URL url) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Returns the cipher suite in use on this connection.
 *
 * @return the cipher suite
 * @throws java.lang.IllegalStateException if this method is called before
 *          the connection has been established.
 * @apiSince 1
 */

public abstract java.lang.String getCipherSuite();

/**
 * Returns the certificate(s) that were sent to the server during
 * handshaking.
 * <P>
 * Note: This method is useful only when using certificate-based
 * cipher suites.
 * <P>
 * When multiple certificates are available for use in a
 * handshake, the implementation chooses what it considers the
 * "best" certificate chain available, and transmits that to
 * the other side.  This method allows the caller to know
 * which certificate chain was actually sent.
 *
 * @return an ordered array of certificates,
 *          with the client's own certificate first followed by any
 *          certificate authorities.  If no certificates were sent,
 *          then null is returned.
 * @throws java.lang.IllegalStateException if this method is called before
 *          the connection has been established.
 * @see #getLocalPrincipal()
 * @apiSince 1
 */

public abstract java.security.cert.Certificate[] getLocalCertificates();

/**
 * Returns the server's certificate chain which was established
 * as part of defining the session.
 * <P>
 * Note: This method can be used only when using certificate-based
 * cipher suites; using it with non-certificate-based cipher suites,
 * such as Kerberos, will throw an SSLPeerUnverifiedException.
 *
 * @return an ordered array of server certificates,
 *          with the peer's own certificate first followed by
 *          any certificate authorities.
 * @throws javax.net.ssl.SSLPeerUnverifiedException if the peer is not verified.
 * @throws java.lang.IllegalStateException if this method is called before
 *          the connection has been established.
 * @see #getPeerPrincipal()
 * @apiSince 1
 */

public abstract java.security.cert.Certificate[] getServerCertificates() throws javax.net.ssl.SSLPeerUnverifiedException;

/**
 * Returns the server's principal which was established as part of
 * defining the session.
 * <P>
 * Note: Subclasses should override this method. If not overridden, it
 * will default to returning the X500Principal of the server's end-entity
 * certificate for certificate-based ciphersuites, or throw an
 * SSLPeerUnverifiedException for non-certificate based ciphersuites,
 * such as Kerberos.
 *
 * @return the server's principal. Returns an X500Principal of the
 * end-entity certiticate for X509-based cipher suites, and
 * KerberosPrincipal for Kerberos cipher suites.
 *
 * @throws javax.net.ssl.SSLPeerUnverifiedException if the peer was not verified
 * @throws java.lang.IllegalStateException if this method is called before
 *          the connection has been established.
 *
 * @see #getServerCertificates()
 * @see #getLocalPrincipal()
 *
 * @since 1.5
 * @apiSince 1
 */

public java.security.Principal getPeerPrincipal() throws javax.net.ssl.SSLPeerUnverifiedException { throw new RuntimeException("Stub!"); }

/**
 * Returns the principal that was sent to the server during handshaking.
 * <P>
 * Note: Subclasses should override this method. If not overridden, it
 * will default to returning the X500Principal of the end-entity certificate
 * that was sent to the server for certificate-based ciphersuites or,
 * return null for non-certificate based ciphersuites, such as Kerberos.
 *
 * @return the principal sent to the server. Returns an X500Principal
 * of the end-entity certificate for X509-based cipher suites, and
 * KerberosPrincipal for Kerberos cipher suites. If no principal was
 * sent, then null is returned.
 *
 * @throws java.lang.IllegalStateException if this method is called before
 *          the connection has been established.
 *
 * @see #getLocalCertificates()
 * @see #getPeerPrincipal()
 *
 * @since 1.5
 * @apiSince 1
 */

public java.security.Principal getLocalPrincipal() { throw new RuntimeException("Stub!"); }

/**
 * Sets the default <code>HostnameVerifier</code> inherited by a
 * new instance of this class.
 * <p>
 * Developers are <em>strongly</em> discouraged from changing the default
 * {@code HostnameVerifier} as {@link #getDefaultHostnameVerifier()} is used by several
 * classes for hostname verification on Android.
 * <table>
 *     <tr>
 *         <th>User</th>
 *         <th>Effect</th>
 *     </tr>
 *     <tr>
 *         <td>Android's default {@link javax.net.ssl.TrustManager TrustManager}, as used with Android's default
 *         {@link javax.net.ssl.SSLContext SSLContext}, {@link javax.net.ssl.SSLSocketFactory SSLSocketFactory} and {@link javax.net.ssl.SSLSocket SSLSocket} implementations.
 *         </td>
 *         <td>The {@code HostnameVerifier} is used to verify the peer's
 *         certificate hostname after connecting if {@code
 *         SSLParameters.setEndpointIdentificationAlgorithm("HTTPS")} has been called.
 *         Instances use the <em>current</em> default {@code HostnameVerifier} at verification
 *         time.</td>
 *     </tr>
 *     <tr>
 *         <td>{@link android.net.SSLCertificateSocketFactory}</td>
 *         <td>The current default {@code HostnameVerifier} is used from various {@code
 *         createSocket} methods. See {@link android.net.SSLCertificateSocketFactory} for
 *         details; for example {@link
 *         android.net.SSLCertificateSocketFactory#createSocket(String, int)}.
 *         </td>
 *     </tr>
 *     <tr>
 *         <td>Android's default {@link javax.net.ssl.HttpsURLConnection HttpsURLConnection} implementation.</td>
 *         <td>The {@code HostnameVerifier} is used after a successful TLS handshake to verify
 *         the URI host against the TLS session server. Instances use the default {@code
 *         HostnameVerifier} set <em>when they were created</em> unless overridden with {@link
 *         #setHostnameVerifier(javax.net.ssl.HostnameVerifier)}.
 *         Android's <code>HttpsURLConnection</code> relies on the {@code HostnameVerifier}
 *         for the <em>entire</em> hostname verification step.</td>
 *     </tr>
 * </table>
 * <p>
 * If this method is not called, the default <code>HostnameVerifier</code> will check the
 * hostname according to RFC 2818.
 *
 * @param v the default host name verifier
 * @throws java.lang.IllegalArgumentException if the <code>HostnameVerifier</code>
 *          parameter is null.
 * @throws java.lang.SecurityException if a security manager exists and its
 *         <code>checkPermission</code> method does not allow
 *         <code>SSLPermission("setHostnameVerifier")</code>
 * @see #getDefaultHostnameVerifier()
 * @apiSince 1
 */

public static void setDefaultHostnameVerifier(javax.net.ssl.HostnameVerifier v) { throw new RuntimeException("Stub!"); }

/**
 * Gets the default <code>HostnameVerifier</code> that is inherited
 * by new instances of this class.
 *
 * @return the default host name verifier
 * @see #setDefaultHostnameVerifier(HostnameVerifier)
 * @apiSince 1
 */

public static javax.net.ssl.HostnameVerifier getDefaultHostnameVerifier() { throw new RuntimeException("Stub!"); }

/**
 * Sets the <code>HostnameVerifier</code> for this instance.
 * <P>
 * New instances of this class inherit the default static hostname
 * verifier set by {@link #setDefaultHostnameVerifier(javax.net.ssl.HostnameVerifier)
 * setDefaultHostnameVerifier}.  Calls to this method replace
 * this object's <code>HostnameVerifier</code>.
 * <p>
 * Android's <code>HttpsURLConnection</code> relies on the {@code HostnameVerifier}
 * for the <em>entire</em> hostname verification step.
 *
 * @param v the host name verifier
 * @throws java.lang.IllegalArgumentException if the <code>HostnameVerifier</code>
 *  parameter is null.
 * @see #getHostnameVerifier()
 * @see #setDefaultHostnameVerifier(HostnameVerifier)
 * @apiSince 1
 */

public void setHostnameVerifier(javax.net.ssl.HostnameVerifier v) { throw new RuntimeException("Stub!"); }

/**
 * Gets the <code>HostnameVerifier</code> in place on this instance.
 *
 * @return the host name verifier
 * @see #setHostnameVerifier(HostnameVerifier)
 * @see #setDefaultHostnameVerifier(HostnameVerifier)
 * @apiSince 1
 */

public javax.net.ssl.HostnameVerifier getHostnameVerifier() { throw new RuntimeException("Stub!"); }

/**
 * Sets the default <code>SSLSocketFactory</code> inherited by new
 * instances of this class.
 * <P>
 * The socket factories are used when creating sockets for secure
 * https URL connections.
 *
 * @param sf the default SSL socket factory
 * @throws java.lang.IllegalArgumentException if the SSLSocketFactory
 *          parameter is null.
 * @throws java.lang.SecurityException if a security manager exists and its
 *         <code>checkSetFactory</code> method does not allow
 *         a socket factory to be specified.
 * @see #getDefaultSSLSocketFactory()
 * @apiSince 1
 */

public static void setDefaultSSLSocketFactory(javax.net.ssl.SSLSocketFactory sf) { throw new RuntimeException("Stub!"); }

/**
 * Gets the default static <code>SSLSocketFactory</code> that is
 * inherited by new instances of this class.
 * <P>
 * The socket factories are used when creating sockets for secure
 * https URL connections.
 *
 * @return the default <code>SSLSocketFactory</code>
 * @see #setDefaultSSLSocketFactory(SSLSocketFactory)
 * @apiSince 1
 */

public static javax.net.ssl.SSLSocketFactory getDefaultSSLSocketFactory() { throw new RuntimeException("Stub!"); }

/**
 * Sets the <code>SSLSocketFactory</code> to be used when this instance
 * creates sockets for secure https URL connections.
 * <P>
 * New instances of this class inherit the default static
 * <code>SSLSocketFactory</code> set by
 * {@link #setDefaultSSLSocketFactory(javax.net.ssl.SSLSocketFactory)
 * setDefaultSSLSocketFactory}.  Calls to this method replace
 * this object's <code>SSLSocketFactory</code>.
 *
 * @param sf the SSL socket factory
 * @throws java.lang.IllegalArgumentException if the <code>SSLSocketFactory</code>
 *          parameter is null.
 * @throws java.lang.SecurityException if a security manager exists and its
 *         <code>checkSetFactory</code> method does not allow
 *         a socket factory to be specified.
 * @see #getSSLSocketFactory()
 * @apiSince 1
 */

public void setSSLSocketFactory(javax.net.ssl.SSLSocketFactory sf) { throw new RuntimeException("Stub!"); }

/**
 * Gets the SSL socket factory to be used when creating sockets
 * for secure https URL connections.
 *
 * @return the <code>SSLSocketFactory</code>
 * @see #setSSLSocketFactory(SSLSocketFactory)
 * @apiSince 1
 */

public javax.net.ssl.SSLSocketFactory getSSLSocketFactory() { throw new RuntimeException("Stub!"); }

/**
 * The <code>hostnameVerifier</code> for this object.
 * @apiSince 1
 */

protected javax.net.ssl.HostnameVerifier hostnameVerifier;
}

