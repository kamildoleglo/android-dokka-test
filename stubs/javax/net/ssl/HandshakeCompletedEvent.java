/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

import java.security.cert.X509Certificate;

/**
 * This event indicates that an SSL handshake completed on a given
 * SSL connection.  All of the core information about that handshake's
 * result is captured through an "SSLSession" object.  As a convenience,
 * this event class provides direct access to some important session
 * attributes.
 *
 * <P> The source of this event is the SSLSocket on which handshaking
 * just completed.
 *
 * @see javax.net.ssl.SSLSocket
 * @see javax.net.ssl.HandshakeCompletedListener
 * @see javax.net.ssl.SSLSession
 *
 * @since 1.4
 * @author David Brownell
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class HandshakeCompletedEvent extends java.util.EventObject {

/**
 * Constructs a new HandshakeCompletedEvent.
 *
 * @param sock the SSLSocket acting as the source of the event
 * @param s the SSLSession this event is associated with
 * @apiSince 1
 */

public HandshakeCompletedEvent(javax.net.ssl.SSLSocket sock, javax.net.ssl.SSLSession s) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Returns the session that triggered this event.
 *
 * @return the <code>SSLSession</code> for this handshake
 * @apiSince 1
 */

public javax.net.ssl.SSLSession getSession() { throw new RuntimeException("Stub!"); }

/**
 * Returns the cipher suite in use by the session which was produced
 * by the handshake.  (This is a convenience method for
 * getting the ciphersuite from the SSLsession.)
 *
 * @return the name of the cipher suite negotiated during this session.
 * @apiSince 1
 */

public java.lang.String getCipherSuite() { throw new RuntimeException("Stub!"); }

/**
 * Returns the certificate(s) that were sent to the peer during
 * handshaking.
 * Note: This method is useful only when using certificate-based
 * cipher suites.
 *
 * When multiple certificates are available for use in a
 * handshake, the implementation chooses what it considers the
 * "best" certificate chain available, and transmits that to
 * the other side.  This method allows the caller to know
 * which certificate chain was actually used.
 *
 * @return an ordered array of certificates, with the local
 *          certificate first followed by any
 *          certificate authorities.  If no certificates were sent,
 *          then null is returned.
 * @see #getLocalPrincipal()
 * @apiSince 1
 */

public java.security.cert.Certificate[] getLocalCertificates() { throw new RuntimeException("Stub!"); }

/**
 * Returns the identity of the peer which was established as part
 * of defining the session.
 * Note: This method can be used only when using certificate-based
 * cipher suites; using it with non-certificate-based cipher suites,
 * such as Kerberos, will throw an SSLPeerUnverifiedException.
 *
 * @return an ordered array of the peer certificates,
 *          with the peer's own certificate first followed by
 *          any certificate authorities.
 * @exception javax.net.ssl.SSLPeerUnverifiedException if the peer is not verified.
 * @see #getPeerPrincipal()
 * @apiSince 1
 */

public java.security.cert.Certificate[] getPeerCertificates() throws javax.net.ssl.SSLPeerUnverifiedException { throw new RuntimeException("Stub!"); }

/**
 * Returns the identity of the peer which was identified as part
 * of defining the session.
 * Note: This method can be used only when using certificate-based
 * cipher suites; using it with non-certificate-based cipher suites,
 * such as Kerberos, will throw an SSLPeerUnverifiedException.
 *
 * <p><em>Note: this method exists for compatibility with previous
 * releases. New applications should use
 * {@link #getPeerCertificates} instead.</em></p>
 *
 * @return an ordered array of peer X.509 certificates,
 *          with the peer's own certificate first followed by any
 *          certificate authorities.  (The certificates are in
 *          the original JSSE
 *          {@link javax.security.cert.X509Certificate} format).
 * @exception javax.net.ssl.SSLPeerUnverifiedException if the peer is not verified.
 * @see #getPeerPrincipal()
 * @apiSince 1
 */

public javax.security.cert.X509Certificate[] getPeerCertificateChain() throws javax.net.ssl.SSLPeerUnverifiedException { throw new RuntimeException("Stub!"); }

/**
 * Returns the identity of the peer which was established as part of
 * defining the session.
 *
 * @return the peer's principal. Returns an X500Principal of the
 * end-entity certiticate for X509-based cipher suites, and
 * KerberosPrincipal for Kerberos cipher suites.
 *
 * @throws javax.net.ssl.SSLPeerUnverifiedException if the peer's identity has not
 *          been verified
 *
 * @see #getPeerCertificates()
 * @see #getLocalPrincipal()
 *
 * @since 1.5
 * @apiSince 1
 */

public java.security.Principal getPeerPrincipal() throws javax.net.ssl.SSLPeerUnverifiedException { throw new RuntimeException("Stub!"); }

/**
 * Returns the principal that was sent to the peer during handshaking.
 *
 * @return the principal sent to the peer. Returns an X500Principal
 * of the end-entity certificate for X509-based cipher suites, and
 * KerberosPrincipal for Kerberos cipher suites. If no principal was
 * sent, then null is returned.
 *
 * @see #getLocalCertificates()
 * @see #getPeerPrincipal()
 *
 * @since 1.5
 * @apiSince 1
 */

public java.security.Principal getLocalPrincipal() { throw new RuntimeException("Stub!"); }

/**
 * Returns the socket which is the source of this event.
 * (This is a convenience function, to let applications
 * write code without type casts.)
 *
 * @return the socket on which the connection was made.
 * @apiSince 1
 */

public javax.net.ssl.SSLSocket getSocket() { throw new RuntimeException("Stub!"); }
}

