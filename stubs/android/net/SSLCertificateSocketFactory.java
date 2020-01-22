/*
 * Copyright (C) 2008 The Android Open Source Project
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


package android.net;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.TrustManager;
import javax.net.ssl.KeyManager;

/**
 * SSLSocketFactory implementation with several extra features:
 *
 * <ul>
 * <li>Timeout specification for SSL handshake operations
 * <li>Hostname verification in most cases (see WARNINGs below)
 * <li>Optional SSL session caching with {@link android.net.SSLSessionCache SSLSessionCache}
 * <li>Optionally bypass all SSL certificate checks
 * </ul>
 *
 * The handshake timeout does not apply to actual TCP socket connection.
 * If you want a connection timeout as well, use {@link #createSocket()}
 * and {@link java.net.Socket#connect(java.net.SocketAddress,int) Socket#connect(java.net.SocketAddress, int)}, after which you
 * must verify the identity of the server you are connected to.
 *
 * <p class="caution"><b>Most {@link javax.net.ssl.SSLSocketFactory SSLSocketFactory} implementations do not
 * verify the server's identity, allowing man-in-the-middle attacks.</b>
 * This implementation does check the server's certificate hostname, but only
 * for createSocket variants that specify a hostname.  When using methods that
 * use {@link java.net.InetAddress InetAddress} or which return an unconnected socket, you MUST
 * verify the server's identity yourself to ensure a secure connection.
 *
 * Refer to
 * <a href="https://developer.android.com/training/articles/security-gms-provider.html">
 * Updating Your Security Provider to Protect Against SSL Exploits</a>
 * for further information.</p>
 *
 * <p>The recommended way to verify the server's identity is to use
 * {@link javax.net.ssl.HttpsURLConnection#getDefaultHostnameVerifier() HttpsURLConnection#getDefaultHostnameVerifier()} to get a
 * {@link javax.net.ssl.HostnameVerifier HostnameVerifier} to verify the certificate hostname.
 *
 * <p><b>Warning</b>: Some methods on this class return connected sockets and some return
 * unconnected sockets.  For the methods that return connected sockets, setting
 * connection- or handshake-related properties on those sockets will have no effect.
 *
 * <p>On development devices, "setprop socket.relaxsslcheck yes" bypasses all
 * SSL certificate and hostname checks for testing purposes.  This setting
 * requires root access.
 *
 * @deprecated This class has less error-prone replacements using standard APIs.  To create an
 * {@code SSLSocket}, obtain an {@link javax.net.ssl.SSLSocketFactory SSLSocketFactory} from {@link javax.net.ssl.SSLSocketFactory#getDefault() SSLSocketFactory#getDefault()}
 * or {@link javax.net.ssl.SSLContext#getSocketFactory()}.  To verify hostnames, pass
 * {@code "HTTPS"} to
 * {@link javax.net.ssl.SSLParameters#setEndpointIdentificationAlgorithm(String)}.  To enable ALPN,
 * use {@link javax.net.ssl.SSLParameters#setApplicationProtocols(String[])}.  To enable SNI,
 * use {@link javax.net.ssl.SSLParameters#setServerNames(java.util.List)}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class SSLCertificateSocketFactory extends javax.net.ssl.SSLSocketFactory {

/**
 * @deprecated Use {@link #getDefault(int)} instead.
 * @apiSince 1
 */

@Deprecated
public SSLCertificateSocketFactory(int handshakeTimeoutMillis) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new socket factory instance with an optional handshake timeout.
 *
 * @param handshakeTimeoutMillis to use for SSL connection handshake, or 0
 *         for none.  The socket timeout is reset to 0 after the handshake.
 * @return a new SSLSocketFactory with the specified parameters
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public static javax.net.SocketFactory getDefault(int handshakeTimeoutMillis) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new socket factory instance with an optional handshake timeout
 * and SSL session cache.
 *
 * @param handshakeTimeoutMillis to use for SSL connection handshake, or 0
 *         for none.  The socket timeout is reset to 0 after the handshake.
 * @param cache The {@link android.net.SSLSessionCache SSLSessionCache} to use, or null for no cache.
 * @return a new SSLSocketFactory with the specified parameters
 * @apiSince 8
 * @deprecatedSince 29
 */

@Deprecated
public static javax.net.ssl.SSLSocketFactory getDefault(int handshakeTimeoutMillis, android.net.SSLSessionCache cache) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new instance of a socket factory with all SSL security checks
 * disabled, using an optional handshake timeout and SSL session cache.
 *
 * <p class="caution"><b>Warning:</b> Sockets created using this factory
 * are vulnerable to man-in-the-middle attacks!</p>
 *
 * @param handshakeTimeoutMillis to use for SSL connection handshake, or 0
 *         for none.  The socket timeout is reset to 0 after the handshake.
 * @param cache The {@link android.net.SSLSessionCache SSLSessionCache} to use, or null for no cache.
 * @return an insecure SSLSocketFactory with the specified parameters
 * @apiSince 8
 * @deprecatedSince 29
 */

@Deprecated
public static javax.net.ssl.SSLSocketFactory getInsecure(int handshakeTimeoutMillis, android.net.SSLSessionCache cache) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link javax.net.ssl.TrustManager TrustManager}s to be used for connections made by this factory.
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public void setTrustManagers(javax.net.ssl.TrustManager[] trustManager) { throw new RuntimeException("Stub!"); }

/**
 * Sets the
 * <a class="external" href="https://tools.ietf.org/id/draft-agl-tls-nextprotoneg-03.html">Next
 * Protocol Negotiation (NPN)</a> protocols that this peer is interested in.
 *
 * <p>For servers this is the sequence of protocols to advertise as
 * supported, in order of preference. This list is sent unencrypted to
 * all clients that support NPN.
 *
 * <p>For clients this is a list of supported protocols to match against the
 * server's list. If there is no protocol supported by both client and
 * server then the first protocol in the client's list will be selected.
 * The order of the client's protocols is otherwise insignificant.
 *
 * @param npnProtocols a non-empty list of protocol byte arrays. All arrays
 *     must be non-empty and of length less than 256.
 * @apiSince 16
 * @deprecatedSince 29
 */

@Deprecated
public void setNpnProtocols(byte[][] npnProtocols) { throw new RuntimeException("Stub!"); }

/**
 * Returns the <a href="http://technotes.googlecode.com/git/nextprotoneg.html">Next
 * Protocol Negotiation (NPN)</a> protocol selected by client and server, or
 * null if no protocol was negotiated.
 *
 * @param socket a socket created by this factory.
 * @throws java.lang.IllegalArgumentException if the socket was not created by this factory.
 * @apiSince 16
 * @deprecatedSince 29
 */

@Deprecated
public byte[] getNpnSelectedProtocol(java.net.Socket socket) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link javax.net.ssl.KeyManager KeyManager}s to be used for connections made by this factory.
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public void setKeyManagers(javax.net.ssl.KeyManager[] keyManagers) { throw new RuntimeException("Stub!"); }

/**
 * Enables <a href="http://tools.ietf.org/html/rfc5077#section-3.2">session ticket</a>
 * support on the given socket.
 *
 * @param socket a socket created by this factory
 * @param useSessionTickets {@code true} to enable session ticket support on this socket.
 * @throws java.lang.IllegalArgumentException if the socket was not created by this factory.
 * @apiSince 17
 * @deprecatedSince 29
 */

@Deprecated
public void setUseSessionTickets(java.net.Socket socket, boolean useSessionTickets) { throw new RuntimeException("Stub!"); }

/**
 * Turns on <a href="http://tools.ietf.org/html/rfc6066#section-3">Server
 * Name Indication (SNI)</a> on a given socket.
 *
 * @param socket a socket created by this factory.
 * @param hostName the desired SNI hostname, null to disable.
 * @throws java.lang.IllegalArgumentException if the socket was not created by this factory.
 * @apiSince 17
 * @deprecatedSince 29
 */

@Deprecated
public void setHostname(java.net.Socket socket, java.lang.String hostName) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * <p>By default, this method returns a <i>connected</i> socket and verifies the peer's
 * certificate hostname after connecting using the {@link javax.net.ssl.HostnameVerifier HostnameVerifier} obtained from
 * {@code HttpsURLConnection.getDefaultHostnameVerifier()}; if this instance was created with
 * {@link #getInsecure(int,android.net.SSLSessionCache)}, it returns a socket that is <i>not connected</i>
 * instead.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public java.net.Socket createSocket(java.net.Socket k, java.lang.String host, int port, boolean close) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Creates a new socket which is <i>not connected</i> to any remote host.
 * You must use {@link java.net.Socket#connect Socket#connect} to connect the socket.
 *
 * <p class="caution"><b>Warning:</b> Hostname verification is not performed
 * with this method.  You MUST verify the server's identity after connecting
 * the socket to avoid man-in-the-middle attacks.</p>
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public java.net.Socket createSocket() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * <p>This method returns a socket that is <i>not connected</i>.
 *
 * <p class="caution"><b>Warning:</b> Hostname verification is not performed
 * with this method.  You MUST verify the server's identity after connecting
 * the socket to avoid man-in-the-middle attacks.</p>
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public java.net.Socket createSocket(java.net.InetAddress addr, int port, java.net.InetAddress localAddr, int localPort) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * <p>This method returns a socket that is <i>not connected</i>.
 *
 * <p class="caution"><b>Warning:</b> Hostname verification is not performed
 * with this method.  You MUST verify the server's identity after connecting
 * the socket to avoid man-in-the-middle attacks.</p>
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public java.net.Socket createSocket(java.net.InetAddress addr, int port) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * <p>By default, this method returns a <i>connected</i> socket and verifies the peer's
 * certificate hostname after connecting using the {@link javax.net.ssl.HostnameVerifier HostnameVerifier} obtained from
 * {@code HttpsURLConnection.getDefaultHostnameVerifier()}; if this instance was created with
 * {@link #getInsecure(int,android.net.SSLSessionCache)}, it returns a socket that is <i>not connected</i>
 * instead.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public java.net.Socket createSocket(java.lang.String host, int port, java.net.InetAddress localAddr, int localPort) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * <p>By default, this method returns a <i>connected</i> socket and verifies the peer's
 * certificate hostname after connecting using the {@link javax.net.ssl.HostnameVerifier HostnameVerifier} obtained from
 * {@code HttpsURLConnection.getDefaultHostnameVerifier()}; if this instance was created with
 * {@link #getInsecure(int,android.net.SSLSessionCache)}, it returns a socket that is <i>not connected</i>
 * instead.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public java.net.Socket createSocket(java.lang.String host, int port) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public java.lang.String[] getDefaultCipherSuites() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public java.lang.String[] getSupportedCipherSuites() { throw new RuntimeException("Stub!"); }
}

