/*
 * Copyright (c) 1995, 2013, Oracle and/or its affiliates. All rights reserved.
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



package java.net;

import java.nio.channels.ServerSocketChannel;
import java.io.IOException;

/**
 * This class implements server sockets. A server socket waits for
 * requests to come in over the network. It performs some operation
 * based on that request, and then possibly returns a result to the requester.
 * <p>
 * The actual work of the server socket is performed by an instance
 * of the {@code SocketImpl} class. An application can
 * change the socket factory that creates the socket
 * implementation to configure itself to create sockets
 * appropriate to the local firewall.
 *
 * @author  unascribed
 * @see     java.net.SocketImpl
 * @see     java.net.ServerSocket#setSocketFactory(java.net.SocketImplFactory)
 * @see     java.nio.channels.ServerSocketChannel
 * @since   JDK1.0
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ServerSocket implements java.io.Closeable {

/**
 * Creates an unbound server socket.
 *
 * @exception java.io.IOException IO error when opening the socket.
 * @revised 1.4
 * @apiSince 1
 */

public ServerSocket() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Creates a server socket, bound to the specified port. A port number
 * of {@code 0} means that the port number is automatically
 * allocated, typically from an ephemeral port range. This port
 * number can then be retrieved by calling {@link #getLocalPort getLocalPort}.
 * <p>
 * The maximum queue length for incoming connection indications (a
 * request to connect) is set to {@code 50}. If a connection
 * indication arrives when the queue is full, the connection is refused.
 * <p>
 * If the application has specified a server socket factory, that
 * factory's {@code createSocketImpl} method is called to create
 * the actual socket implementation. Otherwise a "plain" socket is created.
 * <p>
 * If there is a security manager,
 * its {@code checkListen} method is called
 * with the {@code port} argument
 * as its argument to ensure the operation is allowed.
 * This could result in a SecurityException.
 *
 *
 * @param      port  the port number, or {@code 0} to use a port
 *                   number that is automatically allocated.
 *
 * @exception  java.io.IOException  if an I/O error occurs when opening the socket.
 * @exception  java.lang.SecurityException
 * if a security manager exists and its {@code checkListen}
 * method doesn't allow the operation.
 * @exception  java.lang.IllegalArgumentException if the port parameter is outside
 *             the specified range of valid port values, which is between
 *             0 and 65535, inclusive.
 *
 * @see        java.net.SocketImpl
 * @see        java.net.SocketImplFactory#createSocketImpl()
 * @see        java.net.ServerSocket#setSocketFactory(java.net.SocketImplFactory)
 * @see        java.lang.SecurityManager#checkListen
 * @apiSince 1
 */

public ServerSocket(int port) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Creates a server socket and binds it to the specified local port
 * number, with the specified backlog.
 * A port number of {@code 0} means that the port number is
 * automatically allocated, typically from an ephemeral port range.
 * This port number can then be retrieved by calling
 * {@link #getLocalPort getLocalPort}.
 * <p>
 * The maximum queue length for incoming connection indications (a
 * request to connect) is set to the {@code backlog} parameter. If
 * a connection indication arrives when the queue is full, the
 * connection is refused.
 * <p>
 * If the application has specified a server socket factory, that
 * factory's {@code createSocketImpl} method is called to create
 * the actual socket implementation. Otherwise a "plain" socket is created.
 * <p>
 * If there is a security manager,
 * its {@code checkListen} method is called
 * with the {@code port} argument
 * as its argument to ensure the operation is allowed.
 * This could result in a SecurityException.
 *
 * The {@code backlog} argument is the requested maximum number of
 * pending connections on the socket. Its exact semantics are implementation
 * specific. In particular, an implementation may impose a maximum length
 * or may choose to ignore the parameter altogther. The value provided
 * should be greater than {@code 0}. If it is less than or equal to
 * {@code 0}, then an implementation specific default will be used.
 * <P>
 *
 * @param      port     the port number, or {@code 0} to use a port
 *                      number that is automatically allocated.
 * @param      backlog  requested maximum length of the queue of incoming
 *                      connections.
 *
 * @exception  java.io.IOException  if an I/O error occurs when opening the socket.
 * @exception  java.lang.SecurityException
 * if a security manager exists and its {@code checkListen}
 * method doesn't allow the operation.
 * @exception  java.lang.IllegalArgumentException if the port parameter is outside
 *             the specified range of valid port values, which is between
 *             0 and 65535, inclusive.
 *
 * @see        java.net.SocketImpl
 * @see        java.net.SocketImplFactory#createSocketImpl()
 * @see        java.net.ServerSocket#setSocketFactory(java.net.SocketImplFactory)
 * @see        java.lang.SecurityManager#checkListen
 * @apiSince 1
 */

public ServerSocket(int port, int backlog) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Create a server with the specified port, listen backlog, and
 * local IP address to bind to.  The <i>bindAddr</i> argument
 * can be used on a multi-homed host for a ServerSocket that
 * will only accept connect requests to one of its addresses.
 * If <i>bindAddr</i> is null, it will default accepting
 * connections on any/all local addresses.
 * The port must be between 0 and 65535, inclusive.
 * A port number of {@code 0} means that the port number is
 * automatically allocated, typically from an ephemeral port range.
 * This port number can then be retrieved by calling
 * {@link #getLocalPort getLocalPort}.
 *
 * <P>If there is a security manager, this method
 * calls its {@code checkListen} method
 * with the {@code port} argument
 * as its argument to ensure the operation is allowed.
 * This could result in a SecurityException.
 *
 * The {@code backlog} argument is the requested maximum number of
 * pending connections on the socket. Its exact semantics are implementation
 * specific. In particular, an implementation may impose a maximum length
 * or may choose to ignore the parameter altogther. The value provided
 * should be greater than {@code 0}. If it is less than or equal to
 * {@code 0}, then an implementation specific default will be used.
 * <P>
 * @param port  the port number, or {@code 0} to use a port
 *              number that is automatically allocated.
 * @param backlog requested maximum length of the queue of incoming
 *                connections.
 * @param bindAddr the local InetAddress the server will bind to
 *
 * @throws  java.lang.SecurityException if a security manager exists and
 * its {@code checkListen} method doesn't allow the operation.
 *
 * @throws  java.io.IOException if an I/O error occurs when opening the socket.
 * @exception  java.lang.IllegalArgumentException if the port parameter is outside
 *             the specified range of valid port values, which is between
 *             0 and 65535, inclusive.
 *
 * @see java.net.SocketOptions
 * @see java.net.SocketImpl
 * @see java.lang.SecurityManager#checkListen
 * @since   JDK1.1
 * @apiSince 1
 */

public ServerSocket(int port, int backlog, java.net.InetAddress bindAddr) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 *
 * Binds the {@code ServerSocket} to a specific address
 * (IP address and port number).
 * <p>
 * If the address is {@code null}, then the system will pick up
 * an ephemeral port and a valid local address to bind the socket.
 * <p>
 * @param   endpoint        The IP address and port number to bind to.
 * @throws  java.io.IOException if the bind operation fails, or if the socket
 *                     is already bound.
 * @throws  java.lang.SecurityException       if a {@code SecurityManager} is present and
 * its {@code checkListen} method doesn't allow the operation.
 * @throws  java.lang.IllegalArgumentException if endpoint is a
 *          SocketAddress subclass not supported by this socket
 * @since 1.4
 @apiSince 1
 */

public void bind(java.net.SocketAddress endpoint) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 *
 * Binds the {@code ServerSocket} to a specific address
 * (IP address and port number).
 * <p>
 * If the address is {@code null}, then the system will pick up
 * an ephemeral port and a valid local address to bind the socket.
 * <P>
 * The {@code backlog} argument is the requested maximum number of
 * pending connections on the socket. Its exact semantics are implementation
 * specific. In particular, an implementation may impose a maximum length
 * or may choose to ignore the parameter altogther. The value provided
 * should be greater than {@code 0}. If it is less than or equal to
 * {@code 0}, then an implementation specific default will be used.
 * @param   endpoint        The IP address and port number to bind to.
 * @param   backlog         requested maximum length of the queue of
 *                          incoming connections.
 * @throws  java.io.IOException if the bind operation fails, or if the socket
 *                     is already bound.
 * @throws  java.lang.SecurityException       if a {@code SecurityManager} is present and
 * its {@code checkListen} method doesn't allow the operation.
 * @throws  java.lang.IllegalArgumentException if endpoint is a
 *          SocketAddress subclass not supported by this socket
 * @since 1.4
 @apiSince 1
 */

public void bind(java.net.SocketAddress endpoint, int backlog) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns the local address of this server socket.
 * <p>
 * If the socket was bound prior to being {@link #close closed},
 * then this method will continue to return the local address
 * after the socket is closed.
 * <p>
 * If there is a security manager set, its {@code checkConnect} method is
 * called with the local address and {@code -1} as its arguments to see
 * if the operation is allowed. If the operation is not allowed,
 * the {@link java.net.InetAddress#getLoopbackAddress InetAddress#getLoopbackAddress} address is returned.
 *
 * @return  the address to which this socket is bound,
 *          or the loopback address if denied by the security manager,
 *          or {@code null} if the socket is unbound.
 *
 * @see SecurityManager#checkConnect
 * @apiSince 1
 */

public java.net.InetAddress getInetAddress() { throw new RuntimeException("Stub!"); }

/**
 * Returns the port number on which this socket is listening.
 * <p>
 * If the socket was bound prior to being {@link #close closed},
 * then this method will continue to return the port number
 * after the socket is closed.
 *
 * @return  the port number to which this socket is listening or
 *          -1 if the socket is not bound yet.
 * @apiSince 1
 */

public int getLocalPort() { throw new RuntimeException("Stub!"); }

/**
 * Returns the address of the endpoint this socket is bound to.
 * <p>
 * If the socket was bound prior to being {@link #close closed},
 * then this method will continue to return the address of the endpoint
 * after the socket is closed.
 * <p>
 * If there is a security manager set, its {@code checkConnect} method is
 * called with the local address and {@code -1} as its arguments to see
 * if the operation is allowed. If the operation is not allowed,
 * a {@code SocketAddress} representing the
 * {@link java.net.InetAddress#getLoopbackAddress InetAddress#getLoopbackAddress} address and the local
 * port to which the socket is bound is returned.
 *
 * @return a {@code SocketAddress} representing the local endpoint of
 *         this socket, or a {@code SocketAddress} representing the
 *         loopback address if denied by the security manager,
 *         or {@code null} if the socket is not bound yet.
 *
 * @see #getInetAddress()
 * @see #getLocalPort()
 * @see #bind(SocketAddress)
 * @see SecurityManager#checkConnect
 * @since 1.4
 * @apiSince 1
 */

public java.net.SocketAddress getLocalSocketAddress() { throw new RuntimeException("Stub!"); }

/**
 * Listens for a connection to be made to this socket and accepts
 * it. The method blocks until a connection is made.
 *
 * <p>A new Socket {@code s} is created and, if there
 * is a security manager,
 * the security manager's {@code checkAccept} method is called
 * with {@code s.getInetAddress().getHostAddress()} and
 * {@code s.getPort()}
 * as its arguments to ensure the operation is allowed.
 * This could result in a SecurityException.
 *
 * @exception  java.io.IOException  if an I/O error occurs when waiting for a
 *               connection.
 * @exception  java.lang.SecurityException  if a security manager exists and its
 *             {@code checkAccept} method doesn't allow the operation.
 * @exception  java.net.SocketTimeoutException if a timeout was previously set with setSoTimeout and
 *             the timeout has been reached.
 * @exception  java.nio.channels.IllegalBlockingModeException
 *             if this socket has an associated channel, the channel is in
 *             non-blocking mode, and there is no connection ready to be
 *             accepted
 *
 * @return the new Socket
 * @see java.lang.SecurityManager#checkAccept
 * @revised 1.4
 * @spec JSR-51
 * @apiSince 1
 */

public java.net.Socket accept() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Subclasses of ServerSocket use this method to override accept()
 * to return their own subclass of socket.  So a FooServerSocket
 * will typically hand this method an <i>empty</i> FooSocket.  On
 * return from implAccept the FooSocket will be connected to a client.
 *
 * @param s the Socket
 * @throws java.nio.channels.IllegalBlockingModeException
 *         if this socket has an associated channel,
 *         and the channel is in non-blocking mode
 * @throws java.io.IOException if an I/O error occurs when waiting
 * for a connection.
 * @since   JDK1.1
 * @revised 1.4
 * @spec JSR-51
 * @apiSince 1
 */

protected final void implAccept(java.net.Socket s) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Closes this socket.
 *
 * Any thread currently blocked in {@link #accept()} will throw
 * a {@link java.net.SocketException SocketException}.
 *
 * <p> If this socket has an associated channel then the channel is closed
 * as well.
 *
 * @exception  java.io.IOException  if an I/O error occurs when closing the socket.
 * @revised 1.4
 * @spec JSR-51
 * @apiSince 1
 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns the unique {@link java.nio.channels.ServerSocketChannel} object
 * associated with this socket, if any.
 *
 * <p> A server socket will have a channel if, and only if, the channel
 * itself was created via the {@link
 * java.nio.channels.ServerSocketChannel#open ServerSocketChannel.open}
 * method.
 *
 * @return  the server-socket channel associated with this socket,
 *          or {@code null} if this socket was not created
 *          for a channel
 *
 * @since 1.4
 * @spec JSR-51
 * @apiSince 1
 */

public java.nio.channels.ServerSocketChannel getChannel() { throw new RuntimeException("Stub!"); }

/**
 * Returns the binding state of the ServerSocket.
 *
 * @return true if the ServerSocket successfully bound to an address
 * @since 1.4
 * @apiSince 1
 */

public boolean isBound() { throw new RuntimeException("Stub!"); }

/**
 * Returns the closed state of the ServerSocket.
 *
 * @return true if the socket has been closed
 * @since 1.4
 * @apiSince 1
 */

public boolean isClosed() { throw new RuntimeException("Stub!"); }

/**
 * Enable/disable {@link java.net.SocketOptions#SO_TIMEOUT SocketOptions#SO_TIMEOUT} with the
 * specified timeout, in milliseconds.  With this option set to a non-zero
 * timeout, a call to accept() for this ServerSocket
 * will block for only this amount of time.  If the timeout expires,
 * a <B>java.net.SocketTimeoutException</B> is raised, though the
 * ServerSocket is still valid.  The option <B>must</B> be enabled
 * prior to entering the blocking operation to have effect.  The
 * timeout must be {@code > 0}.
 * A timeout of zero is interpreted as an infinite timeout.
 * @param timeout the specified timeout, in milliseconds
 * @exception java.net.SocketException if there is an error in
 * the underlying protocol, such as a TCP error.
 * @since   JDK1.1
 * @see #getSoTimeout()
 * @apiSince 1
 */

public synchronized void setSoTimeout(int timeout) throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Retrieve setting for {@link java.net.SocketOptions#SO_TIMEOUT SocketOptions#SO_TIMEOUT}.
 * 0 returns implies that the option is disabled (i.e., timeout of infinity).
 * @return the {@link java.net.SocketOptions#SO_TIMEOUT SocketOptions#SO_TIMEOUT} value
 * @exception java.io.IOException if an I/O error occurs
 * @since   JDK1.1
 * @see #setSoTimeout(int)
 * @apiSince 1
 */

public synchronized int getSoTimeout() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Enable/disable the {@link java.net.SocketOptions#SO_REUSEADDR SocketOptions#SO_REUSEADDR}
 * socket option.
 * <p>
 * When a TCP connection is closed the connection may remain
 * in a timeout state for a period of time after the connection
 * is closed (typically known as the {@code TIME_WAIT} state
 * or {@code 2MSL} wait state).
 * For applications using a well known socket address or port
 * it may not be possible to bind a socket to the required
 * {@code SocketAddress} if there is a connection in the
 * timeout state involving the socket address or port.
 * <p>
 * Enabling {@link java.net.SocketOptions#SO_REUSEADDR SocketOptions#SO_REUSEADDR} prior to
 * binding the socket using {@link #bind(java.net.SocketAddress)} allows the socket
 * to be bound even though a previous connection is in a timeout state.
 * <p>
 * When a {@code ServerSocket} is created the initial setting
 * of {@link java.net.SocketOptions#SO_REUSEADDR SocketOptions#SO_REUSEADDR} is not defined.
 * Applications can use {@link #getReuseAddress()} to determine the initial
 * setting of {@link java.net.SocketOptions#SO_REUSEADDR SocketOptions#SO_REUSEADDR}.
 * <p>
 * The behaviour when {@link java.net.SocketOptions#SO_REUSEADDR SocketOptions#SO_REUSEADDR} is
 * enabled or disabled after a socket is bound (See {@link #isBound()})
 * is not defined.
 *
 * @param on  whether to enable or disable the socket option
 * @exception java.net.SocketException if an error occurs enabling or
 *            disabling the {@link java.net.SocketOptions#SO_REUSEADDR SocketOptions#SO_REUSEADDR}
 *            socket option, or the socket is closed.
 * @since 1.4
 * @see #getReuseAddress()
 * @see #bind(SocketAddress)
 * @see #isBound()
 * @see #isClosed()
 * @apiSince 1
 */

public void setReuseAddress(boolean on) throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Tests if {@link java.net.SocketOptions#SO_REUSEADDR SocketOptions#SO_REUSEADDR} is enabled.
 *
 * @return a {@code boolean} indicating whether or not
 *         {@link java.net.SocketOptions#SO_REUSEADDR SocketOptions#SO_REUSEADDR} is enabled.
 * @exception java.net.SocketException if there is an error
 * in the underlying protocol, such as a TCP error.
 * @since   1.4
 * @see #setReuseAddress(boolean)
 * @apiSince 1
 */

public boolean getReuseAddress() throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Returns the implementation address and implementation port of
 * this socket as a {@code String}.
 * <p>
 * If there is a security manager set, its {@code checkConnect} method is
 * called with the local address and {@code -1} as its arguments to see
 * if the operation is allowed. If the operation is not allowed,
 * an {@code InetAddress} representing the
 * {@link java.net.InetAddress#getLoopbackAddress InetAddress#getLoopbackAddress} address is returned as
 * the implementation address.
 *
 * @return  a string representation of this socket.
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Sets the server socket implementation factory for the
 * application. The factory can be specified only once.
 * <p>
 * When an application creates a new server socket, the socket
 * implementation factory's {@code createSocketImpl} method is
 * called to create the actual socket implementation.
 * <p>
 * Passing {@code null} to the method is a no-op unless the factory
 * was already set.
 * <p>
 * If there is a security manager, this method first calls
 * the security manager's {@code checkSetFactory} method
 * to ensure the operation is allowed.
 * This could result in a SecurityException.
 *
 * @param      fac   the desired factory.
 * @exception  java.io.IOException  if an I/O error occurs when setting the
 *               socket factory.
 * @exception  java.net.SocketException  if the factory has already been defined.
 * @exception  java.lang.SecurityException  if a security manager exists and its
 *             {@code checkSetFactory} method doesn't allow the operation.
 * @see        java.net.SocketImplFactory#createSocketImpl()
 * @see        java.lang.SecurityManager#checkSetFactory
 * @apiSince 1
 */

public static synchronized void setSocketFactory(java.net.SocketImplFactory fac) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Sets a default proposed value for the
 * {@link java.net.SocketOptions#SO_RCVBUF SocketOptions#SO_RCVBUF} option for sockets
 * accepted from this {@code ServerSocket}. The value actually set
 * in the accepted socket must be determined by calling
 * {@link java.net.Socket#getReceiveBufferSize() Socket#getReceiveBufferSize()} after the socket
 * is returned by {@link #accept()}.
 * <p>
 * The value of {@link java.net.SocketOptions#SO_RCVBUF SocketOptions#SO_RCVBUF} is used both to
 * set the size of the internal socket receive buffer, and to set the size
 * of the TCP receive window that is advertized to the remote peer.
 * <p>
 * It is possible to change the value subsequently, by calling
 * {@link java.net.Socket#setReceiveBufferSize(int) Socket#setReceiveBufferSize(int)}. However, if the application
 * wishes to allow a receive window larger than 64K bytes, as defined by RFC1323
 * then the proposed value must be set in the ServerSocket <B>before</B>
 * it is bound to a local address. This implies, that the ServerSocket must be
 * created with the no-argument constructor, then setReceiveBufferSize() must
 * be called and lastly the ServerSocket is bound to an address by calling bind().
 * <p>
 * Failure to do this will not cause an error, and the buffer size may be set to the
 * requested value but the TCP receive window in sockets accepted from
 * this ServerSocket will be no larger than 64K bytes.
 *
 * @exception java.net.SocketException if there is an error
 * in the underlying protocol, such as a TCP error.
 *
 * @param size the size to which to set the receive buffer
 * size. This value must be greater than 0.
 *
 * @exception java.lang.IllegalArgumentException if the
 * value is 0 or is negative.
 *
 * @since 1.4
 * @see #getReceiveBufferSize
 * @apiSince 1
 */

public synchronized void setReceiveBufferSize(int size) throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Gets the value of the {@link java.net.SocketOptions#SO_RCVBUF SocketOptions#SO_RCVBUF} option
 * for this {@code ServerSocket}, that is the proposed buffer size that
 * will be used for Sockets accepted from this {@code ServerSocket}.
 *
 * <p>Note, the value actually set in the accepted socket is determined by
 * calling {@link java.net.Socket#getReceiveBufferSize() Socket#getReceiveBufferSize()}.
 * @return the value of the {@link java.net.SocketOptions#SO_RCVBUF SocketOptions#SO_RCVBUF}
 *         option for this {@code Socket}.
 * @exception java.net.SocketException if there is an error
 *            in the underlying protocol, such as a TCP error.
 * @see #setReceiveBufferSize(int)
 * @since 1.4
 * @apiSince 1
 */

public synchronized int getReceiveBufferSize() throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Sets performance preferences for this ServerSocket.
 *
 * <p> Sockets use the TCP/IP protocol by default.  Some implementations
 * may offer alternative protocols which have different performance
 * characteristics than TCP/IP.  This method allows the application to
 * express its own preferences as to how these tradeoffs should be made
 * when the implementation chooses from the available protocols.
 *
 * <p> Performance preferences are described by three integers
 * whose values indicate the relative importance of short connection time,
 * low latency, and high bandwidth.  The absolute values of the integers
 * are irrelevant; in order to choose a protocol the values are simply
 * compared, with larger values indicating stronger preferences.  If the
 * application prefers short connection time over both low latency and high
 * bandwidth, for example, then it could invoke this method with the values
 * {@code (1, 0, 0)}.  If the application prefers high bandwidth above low
 * latency, and low latency above short connection time, then it could
 * invoke this method with the values {@code (0, 1, 2)}.
 *
 * <p> Invoking this method after this socket has been bound
 * will have no effect. This implies that in order to use this capability
 * requires the socket to be created with the no-argument constructor.
 *
 * @param  connectionTime
 *         An {@code int} expressing the relative importance of a short
 *         connection time
 *
 * @param  latency
 *         An {@code int} expressing the relative importance of low
 *         latency
 *
 * @param  bandwidth
 *         An {@code int} expressing the relative importance of high
 *         bandwidth
 *
 * @since 1.5
 * @apiSince 1
 */

public void setPerformancePreferences(int connectionTime, int latency, int bandwidth) { throw new RuntimeException("Stub!"); }
}

