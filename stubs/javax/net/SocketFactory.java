/*
 * Copyright (c) 1997, 2010, Oracle and/or its affiliates. All rights reserved.
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




package javax.net;

import java.net.Socket;
import java.io.IOException;
import java.net.UnknownHostException;
import java.net.InetAddress;

/**
 * This class creates sockets.  It may be subclassed by other factories,
 * which create particular subclasses of sockets and thus provide a general
 * framework for the addition of public socket-level functionality.
 *
 * <P> Socket factories are a simple way to capture a variety of policies
 * related to the sockets being constructed, producing such sockets in
 * a way which does not require special configuration of the code which
 * asks for the sockets:  <UL>
 *
 *      <LI> Due to polymorphism of both factories and sockets, different
 *      kinds of sockets can be used by the same application code just
 *      by passing it different kinds of factories.
 *
 *      <LI> Factories can themselves be customized with parameters used
 *      in socket construction.  So for example, factories could be
 *      customized to return sockets with different networking timeouts
 *      or security parameters already configured.
 *
 *      <LI> The sockets returned to the application can be subclasses
 *      of java.net.Socket, so that they can directly expose new APIs
 *      for features such as compression, security, record marking,
 *      statistics collection, or firewall tunneling.
 *
 *      </UL>
 *
 * <P> Factory classes are specified by environment-specific configuration
 * mechanisms.  For example, the <em>getDefault</em> method could return
 * a factory that was appropriate for a particular user or applet, and a
 * framework could use a factory customized to its own purposes.
 *
 * @since 1.4
 * @see javax.net.ServerSocketFactory
 *
 * @author David Brownell
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class SocketFactory {

/**
 * Creates a <code>SocketFactory</code>.
 * @apiSince 1
 */

protected SocketFactory() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of the environment's default socket factory.
 *
 * @return the default <code>SocketFactory</code>
 * @apiSince 1
 */

public static javax.net.SocketFactory getDefault() { throw new RuntimeException("Stub!"); }

/**
 * Creates an unconnected socket.
 *
 * @return the unconnected socket
 * @throws java.io.IOException if the socket cannot be created
 * @see java.net.Socket#connect(java.net.SocketAddress)
 * @see java.net.Socket#connect(java.net.SocketAddress, int)
 * @see java.net.Socket#Socket()
 * @apiSince 1
 */

public java.net.Socket createSocket() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Creates a socket and connects it to the specified remote host
 * at the specified remote port.  This socket is configured using
 * the socket options established for this factory.
 * <p>
 * If there is a security manager, its <code>checkConnect</code>
 * method is called with the host address and <code>port</code>
 * as its arguments. This could result in a SecurityException.
 *
 * @param host the server host name with which to connect, or
 *        <code>null</code> for the loopback address.
 * @param port the server port
 * @return the <code>Socket</code>
 * @throws java.io.IOException if an I/O error occurs when creating the socket
 * @throws java.lang.SecurityException if a security manager exists and its
 *         <code>checkConnect</code> method doesn't allow the operation.
 * @throws java.net.UnknownHostException if the host is not known
 * @throws java.lang.IllegalArgumentException if the port parameter is outside the
 *         specified range of valid port values, which is between 0 and
 *         65535, inclusive.
 * @see SecurityManager#checkConnect
 * @see java.net.Socket#Socket(String, int)
 * @apiSince 1
 */

public abstract java.net.Socket createSocket(java.lang.String host, int port) throws java.io.IOException, java.net.UnknownHostException;

/**
 * Creates a socket and connects it to the specified remote host
 * on the specified remote port.
 * The socket will also be bound to the local address and port supplied.
 * This socket is configured using
 * the socket options established for this factory.
 * <p>
 * If there is a security manager, its <code>checkConnect</code>
 * method is called with the host address and <code>port</code>
 * as its arguments. This could result in a SecurityException.
 *
 * @param host the server host name with which to connect, or
 *        <code>null</code> for the loopback address.
 * @param port the server port
 * @param localHost the local address the socket is bound to
 * @param localPort the local port the socket is bound to
 * @return the <code>Socket</code>
 * @throws java.io.IOException if an I/O error occurs when creating the socket
 * @throws java.lang.SecurityException if a security manager exists and its
 *         <code>checkConnect</code> method doesn't allow the operation.
 * @throws java.net.UnknownHostException if the host is not known
 * @throws java.lang.IllegalArgumentException if the port parameter or localPort
 *         parameter is outside the specified range of valid port values,
 *         which is between 0 and 65535, inclusive.
 * @see SecurityManager#checkConnect
 * @see java.net.Socket#Socket(String, int, java.net.InetAddress, int)
 * @apiSince 1
 */

public abstract java.net.Socket createSocket(java.lang.String host, int port, java.net.InetAddress localHost, int localPort) throws java.io.IOException, java.net.UnknownHostException;

/**
 * Creates a socket and connects it to the specified port number
 * at the specified address.  This socket is configured using
 * the socket options established for this factory.
 * <p>
 * If there is a security manager, its <code>checkConnect</code>
 * method is called with the host address and <code>port</code>
 * as its arguments. This could result in a SecurityException.
 *
 * @param host the server host
 * @param port the server port
 * @return the <code>Socket</code>
 * @throws java.io.IOException if an I/O error occurs when creating the socket
 * @throws java.lang.SecurityException if a security manager exists and its
 *         <code>checkConnect</code> method doesn't allow the operation.
 * @throws java.lang.IllegalArgumentException if the port parameter is outside the
 *         specified range of valid port values, which is between 0 and
 *         65535, inclusive.
 * @throws java.lang.NullPointerException if <code>host</code> is null.
 * @see SecurityManager#checkConnect
 * @see java.net.Socket#Socket(java.net.InetAddress, int)
 * @apiSince 1
 */

public abstract java.net.Socket createSocket(java.net.InetAddress host, int port) throws java.io.IOException;

/**
 * Creates a socket and connect it to the specified remote address
 * on the specified remote port.  The socket will also be bound
 * to the local address and port suplied.  The socket is configured using
 * the socket options established for this factory.
 * <p>
 * If there is a security manager, its <code>checkConnect</code>
 * method is called with the host address and <code>port</code>
 * as its arguments. This could result in a SecurityException.
 *
 * @param address the server network address
 * @param port the server port
 * @param localAddress the client network address
 * @param localPort the client port
 * @return the <code>Socket</code>
 * @throws java.io.IOException if an I/O error occurs when creating the socket
 * @throws java.lang.SecurityException if a security manager exists and its
 *         <code>checkConnect</code> method doesn't allow the operation.
 * @throws java.lang.IllegalArgumentException if the port parameter or localPort
 *         parameter is outside the specified range of valid port values,
 *         which is between 0 and 65535, inclusive.
 * @throws java.lang.NullPointerException if <code>address</code> is null.
 * @see SecurityManager#checkConnect
 * @see java.net.Socket#Socket(java.net.InetAddress, int,
 *     java.net.InetAddress, int)
 * @apiSince 1
 */

public abstract java.net.Socket createSocket(java.net.InetAddress address, int port, java.net.InetAddress localAddress, int localPort) throws java.io.IOException;
}

