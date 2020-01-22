/*
 * Copyright (C) 2014 The Android Open Source Project
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

import java.nio.channels.DatagramChannel;
import java.io.IOException;

/**
 * This class represents a socket for sending and receiving datagram packets.
 *
 * <p>A datagram socket is the sending or receiving point for a packet
 * delivery service. Each packet sent or received on a datagram socket
 * is individually addressed and routed. Multiple packets sent from
 * one machine to another may be routed differently, and may arrive in
 * any order.
 *
 * <p> Where possible, a newly constructed {@code DatagramSocket} has the
 * {@link java.net.SocketOptions#SO_BROADCAST SocketOptions#SO_BROADCAST} socket option enabled so as
 * to allow the transmission of broadcast datagrams. In order to receive
 * broadcast packets a DatagramSocket should be bound to the wildcard address.
 * In some implementations, broadcast packets may also be received when
 * a DatagramSocket is bound to a more specific address.
 * <p>
 * Example:
 * {@code
 *              DatagramSocket s = new DatagramSocket(null);
 *              s.bind(new InetSocketAddress(8888));
 * }
 * Which is equivalent to:
 * {@code
 *              DatagramSocket s = new DatagramSocket(8888);
 * }
 * Both cases will create a DatagramSocket able to receive broadcasts on
 * UDP port 8888.
 *
 * @author  Pavani Diwanji
 * @see     java.net.DatagramPacket
 * @see     java.nio.channels.DatagramChannel
 * @since JDK1.0
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DatagramSocket implements java.io.Closeable {

/**
 * Constructs a datagram socket and binds it to any available port
 * on the local host machine.  The socket will be bound to the
 * {@link java.net.InetAddress#isAnyLocalAddress InetAddress#isAnyLocalAddress} address,
 * an IP address chosen by the kernel.
 *
 * <p>If there is a security manager,
 * its {@code checkListen} method is first called
 * with 0 as its argument to ensure the operation is allowed.
 * This could result in a SecurityException.
 *
 * @exception  java.net.SocketException  if the socket could not be opened,
 *               or the socket could not bind to the specified local port.
 * @exception  java.lang.SecurityException  if a security manager exists and its
 *             {@code checkListen} method doesn't allow the operation.
 *
 * @see java.lang.SecurityManager#checkListen
 * @apiSince 1
 */

public DatagramSocket() throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Creates an unbound datagram socket with the specified
 * DatagramSocketImpl.
 *
 * @param impl an instance of a <B>DatagramSocketImpl</B>
 *        the subclass wishes to use on the DatagramSocket.
 * @since   1.4
 * @apiSince 1
 */

protected DatagramSocket(java.net.DatagramSocketImpl impl) { throw new RuntimeException("Stub!"); }

/**
 * Creates a datagram socket, bound to the specified local
 * socket address.
 * <p>
 * If, if the address is {@code null}, creates an unbound socket.
 *
 * <p>If there is a security manager,
 * its {@code checkListen} method is first called
 * with the port from the socket address
 * as its argument to ensure the operation is allowed.
 * This could result in a SecurityException.
 *
 * @param bindaddr local socket address to bind, or {@code null}
 *                 for an unbound socket.
 *
 * @exception  java.net.SocketException  if the socket could not be opened,
 *               or the socket could not bind to the specified local port.
 * @exception  java.lang.SecurityException  if a security manager exists and its
 *             {@code checkListen} method doesn't allow the operation.
 *
 * @see java.lang.SecurityManager#checkListen
 * @since   1.4
 * @apiSince 1
 */

public DatagramSocket(java.net.SocketAddress bindaddr) throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Constructs a datagram socket and binds it to the specified port
 * on the local host machine.  The socket will be bound to the
 * {@link java.net.InetAddress#isAnyLocalAddress InetAddress#isAnyLocalAddress} address,
 * an IP address chosen by the kernel.
 *
 * <p>If there is a security manager,
 * its {@code checkListen} method is first called
 * with the {@code port} argument
 * as its argument to ensure the operation is allowed.
 * This could result in a SecurityException.
 *
 * @param      port port to use.
 * @exception  java.net.SocketException  if the socket could not be opened,
 *               or the socket could not bind to the specified local port.
 * @exception  java.lang.SecurityException  if a security manager exists and its
 *             {@code checkListen} method doesn't allow the operation.
 *
 * @see java.lang.SecurityManager#checkListen
 * @apiSince 1
 */

public DatagramSocket(int port) throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Creates a datagram socket, bound to the specified local
 * address.  The local port must be between 0 and 65535 inclusive.
 * If the IP address is 0.0.0.0, the socket will be bound to the
 * {@link java.net.InetAddress#isAnyLocalAddress InetAddress#isAnyLocalAddress} address,
 * an IP address chosen by the kernel.
 *
 * <p>If there is a security manager,
 * its {@code checkListen} method is first called
 * with the {@code port} argument
 * as its argument to ensure the operation is allowed.
 * This could result in a SecurityException.
 *
 * @param port local port to use
 * @param laddr local address to bind
 *
 * @exception  java.net.SocketException  if the socket could not be opened,
 *               or the socket could not bind to the specified local port.
 * @exception  java.lang.SecurityException  if a security manager exists and its
 *             {@code checkListen} method doesn't allow the operation.
 *
 * @see java.lang.SecurityManager#checkListen
 * @since   JDK1.1
 * @apiSince 1
 */

public DatagramSocket(int port, java.net.InetAddress laddr) throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Binds this DatagramSocket to a specific address and port.
 * <p>
 * If the address is {@code null}, then the system will pick up
 * an ephemeral port and a valid local address to bind the socket.
 *<p>
 * @param   addr The address and port to bind to.
 * @throws  java.net.SocketException if any error happens during the bind, or if the
 *          socket is already bound.
 * @throws  java.lang.SecurityException  if a security manager exists and its
 *             {@code checkListen} method doesn't allow the operation.
 * @throws java.lang.IllegalArgumentException if addr is a SocketAddress subclass
 *         not supported by this socket.
 * @since 1.4
 * @apiSince 1
 */

public synchronized void bind(java.net.SocketAddress addr) throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Connects the socket to a remote address for this socket. When a
 * socket is connected to a remote address, packets may only be
 * sent to or received from that address. By default a datagram
 * socket is not connected.
 *
 * <p>If the remote destination to which the socket is connected does not
 * exist, or is otherwise unreachable, and if an ICMP destination unreachable
 * packet has been received for that address, then a subsequent call to
 * send or receive may throw a PortUnreachableException. Note, there is no
 * guarantee that the exception will be thrown.
 *
 * <p> If a security manager has been installed then it is invoked to check
 * access to the remote address. Specifically, if the given {@code address}
 * is a {@link java.net.InetAddress#isMulticastAddress InetAddress#isMulticastAddress},
 * the security manager's {@link
 * java.lang.SecurityManager#checkMulticast(InetAddress)
 * checkMulticast} method is invoked with the given {@code address}.
 * Otherwise, the security manager's {@link
 * java.lang.SecurityManager#checkConnect(String,int) checkConnect}
 * and {@link java.lang.SecurityManager#checkAccept checkAccept} methods
 * are invoked, with the given {@code address} and {@code port}, to
 * verify that datagrams are permitted to be sent and received
 * respectively.
 *
 * <p> When a socket is connected, {@link #receive receive} and
 * {@link #send send} <b>will not perform any security checks</b>
 * on incoming and outgoing packets, other than matching the packet's
 * and the socket's address and port. On a send operation, if the
 * packet's address is set and the packet's address and the socket's
 * address do not match, an {@code IllegalArgumentException} will be
 * thrown. A socket connected to a multicast address may only be used
 * to send packets.
 *
 * @param address the remote address for the socket
 *
 * @param port the remote port for the socket.
 *
 * @throws java.lang.IllegalArgumentException
 *         if the address is null, or the port is out of range.
 *
 * @throws java.lang.SecurityException
 *         if a security manager has been installed and it does
 *         not permit access to the given remote address
 *
 * @see #disconnect
 * @apiSince 1
 */

public void connect(java.net.InetAddress address, int port) { throw new RuntimeException("Stub!"); }

/**
 * Connects this socket to a remote socket address (IP address + port number).
 *
 * <p> If given an {@link java.net.InetSocketAddress InetSocketAddress}, this method
 * behaves as if invoking {@link #connect(java.net.InetAddress,int) connect(InetAddress,int)}
 * with the the given socket addresses IP address and port number.
 *
 * @param   addr    The remote address.
 *
 * @throws  java.net.SocketException
 *          if the connect fails
 *
 * @throws java.lang.IllegalArgumentException
 *         if {@code addr} is {@code null}, or {@code addr} is a SocketAddress
 *         subclass not supported by this socket
 *
 * @throws java.lang.SecurityException
 *         if a security manager has been installed and it does
 *         not permit access to the given remote address
 *
 * @since 1.4
 * @apiSince 1
 */

public void connect(java.net.SocketAddress addr) throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Disconnects the socket. If the socket is closed or not connected,
 * then this method has no effect.
 *
 * @see #connect
 * @apiSince 1
 */

public void disconnect() { throw new RuntimeException("Stub!"); }

/**
 * Returns the binding state of the socket.
 * <p>
 * If the socket was bound prior to being {@link #close closed},
 * then this method will continue to return {@code true}
 * after the socket is closed.
 *
 * @return true if the socket successfully bound to an address
 * @since 1.4
 * @apiSince 1
 */

public boolean isBound() { throw new RuntimeException("Stub!"); }

/**
 * Returns the connection state of the socket.
 * <p>
 * If the socket was connected prior to being {@link #close closed},
 * then this method will continue to return {@code true}
 * after the socket is closed.
 *
 * @return true if the socket successfully connected to a server
 * @since 1.4
 * @apiSince 1
 */

public boolean isConnected() { throw new RuntimeException("Stub!"); }

/**
 * Returns the address to which this socket is connected. Returns
 * {@code null} if the socket is not connected.
 * <p>
 * If the socket was connected prior to being {@link #close closed},
 * then this method will continue to return the connected address
 * after the socket is closed.
 *
 * @return the address to which this socket is connected.
 * @apiSince 1
 */

public java.net.InetAddress getInetAddress() { throw new RuntimeException("Stub!"); }

/**
 * Returns the port number to which this socket is connected.
 * Returns {@code -1} if the socket is not connected.
 * <p>
 * If the socket was connected prior to being {@link #close closed},
 * then this method will continue to return the connected port number
 * after the socket is closed.
 *
 * @return the port number to which this socket is connected.
 * @apiSince 1
 */

public int getPort() { throw new RuntimeException("Stub!"); }

/**
 * Returns the address of the endpoint this socket is connected to, or
 * {@code null} if it is unconnected.
 * <p>
 * If the socket was connected prior to being {@link #close closed},
 * then this method will continue to return the connected address
 * after the socket is closed.
 *
 * @return a {@code SocketAddress} representing the remote
 *         endpoint of this socket, or {@code null} if it is
 *         not connected yet.
 * @see #getInetAddress()
 * @see #getPort()
 * @see #connect(SocketAddress)
 * @since 1.4
 * @apiSince 1
 */

public java.net.SocketAddress getRemoteSocketAddress() { throw new RuntimeException("Stub!"); }

/**
 * Returns the address of the endpoint this socket is bound to.
 *
 * @return a {@code SocketAddress} representing the local endpoint of this
 *         socket, or {@code null} if it is closed or not bound yet.
 * @see #getLocalAddress()
 * @see #getLocalPort()
 * @see #bind(SocketAddress)
 * @since 1.4
 * @apiSince 1
 */

public java.net.SocketAddress getLocalSocketAddress() { throw new RuntimeException("Stub!"); }

/**
 * Sends a datagram packet from this socket. The
 * {@code DatagramPacket} includes information indicating the
 * data to be sent, its length, the IP address of the remote host,
 * and the port number on the remote host.
 *
 * <p>If there is a security manager, and the socket is not currently
 * connected to a remote address, this method first performs some
 * security checks. First, if {@code p.getAddress().isMulticastAddress()}
 * is true, this method calls the
 * security manager's {@code checkMulticast} method
 * with {@code p.getAddress()} as its argument.
 * If the evaluation of that expression is false,
 * this method instead calls the security manager's
 * {@code checkConnect} method with arguments
 * {@code p.getAddress().getHostAddress()} and
 * {@code p.getPort()}. Each call to a security manager method
 * could result in a SecurityException if the operation is not allowed.
 *
 * @param      p   the {@code DatagramPacket} to be sent.
 *
 * @exception  java.io.IOException  if an I/O error occurs.
 * @exception  java.lang.SecurityException  if a security manager exists and its
 *             {@code checkMulticast} or {@code checkConnect}
 *             method doesn't allow the send.
 * @exception  java.net.PortUnreachableException may be thrown if the socket is connected
 *             to a currently unreachable destination. Note, there is no
 *             guarantee that the exception will be thrown.
 * @exception  java.nio.channels.IllegalBlockingModeException
 *             if this socket has an associated channel,
 *             and the channel is in non-blocking mode.
 * @exception  java.lang.IllegalArgumentException if the socket is connected,
 *             and connected address and packet address differ.
 *
 * @see        java.net.DatagramPacket
 * @see        java.lang.SecurityManager#checkMulticast(InetAddress)
 * @see        SecurityManager#checkConnect
 * @revised 1.4
 * @spec JSR-51
 * @apiSince 1
 */

public void send(java.net.DatagramPacket p) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Receives a datagram packet from this socket. When this method
 * returns, the {@code DatagramPacket}'s buffer is filled with
 * the data received. The datagram packet also contains the sender's
 * IP address, and the port number on the sender's machine.
 * <p>
 * This method blocks until a datagram is received. The
 * {@code length} field of the datagram packet object contains
 * the length of the received message. If the message is longer than
 * the packet's length, the message is truncated.
 * <p>
 * If there is a security manager, a packet cannot be received if the
 * security manager's {@code checkAccept} method
 * does not allow it.
 *
 * @param      p   the {@code DatagramPacket} into which to place
 *                 the incoming data.
 * @exception  java.io.IOException  if an I/O error occurs.
 * @exception  java.net.SocketTimeoutException  if setSoTimeout was previously called
 *                 and the timeout has expired.
 * @exception  java.net.PortUnreachableException may be thrown if the socket is connected
 *             to a currently unreachable destination. Note, there is no guarantee that the
 *             exception will be thrown.
 * @exception  java.nio.channels.IllegalBlockingModeException
 *             if this socket has an associated channel,
 *             and the channel is in non-blocking mode.
 * @see        java.net.DatagramPacket
 * @see        java.net.DatagramSocket
 * @revised 1.4
 * @spec JSR-51
 * @apiSince 1
 */

public synchronized void receive(java.net.DatagramPacket p) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Gets the local address to which the socket is bound.
 *
 * <p>If there is a security manager, its
 * {@code checkConnect} method is first called
 * with the host address and {@code -1}
 * as its arguments to see if the operation is allowed.
 *
 * @see SecurityManager#checkConnect
 * @return  the local address to which the socket is bound,
 *          {@code null} if the socket is closed, or
 *          an {@code InetAddress} representing
 *          {@link java.net.InetAddress#isAnyLocalAddress InetAddress#isAnyLocalAddress}
 *          address if either the socket is not bound, or
 *          the security manager {@code checkConnect}
 *          method does not allow the operation
 * @since   1.1
 * @apiSince 1
 */

public java.net.InetAddress getLocalAddress() { throw new RuntimeException("Stub!"); }

/**
 * Returns the port number on the local host to which this socket
 * is bound.
 *
 * @return  the port number on the local host to which this socket is bound,
          {@code -1} if the socket is closed, or
          {@code 0} if it is not bound yet.
 * @apiSince 1
 */

public int getLocalPort() { throw new RuntimeException("Stub!"); }

/** Enable/disable SO_TIMEOUT with the specified timeout, in
 *  milliseconds. With this option set to a non-zero timeout,
 *  a call to receive() for this DatagramSocket
 *  will block for only this amount of time.  If the timeout expires,
 *  a <B>java.net.SocketTimeoutException</B> is raised, though the
 *  DatagramSocket is still valid.  The option <B>must</B> be enabled
 *  prior to entering the blocking operation to have effect.  The
 *  timeout must be {@code > 0}.
 *  A timeout of zero is interpreted as an infinite timeout.
 *
 * @param timeout the specified timeout in milliseconds.
 * @throws java.net.SocketException if there is an error in the underlying protocol, such as an UDP error.
 * @since   JDK1.1
 * @see #getSoTimeout()
 * @apiSince 1
 */

public synchronized void setSoTimeout(int timeout) throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Retrieve setting for SO_TIMEOUT.  0 returns implies that the
 * option is disabled (i.e., timeout of infinity).
 *
 * @return the setting for SO_TIMEOUT
 * @throws java.net.SocketException if there is an error in the underlying protocol, such as an UDP error.
 * @since   JDK1.1
 * @see #setSoTimeout(int)
 * @apiSince 1
 */

public synchronized int getSoTimeout() throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Sets the SO_SNDBUF option to the specified value for this
 * {@code DatagramSocket}. The SO_SNDBUF option is used by the
 * network implementation as a hint to size the underlying
 * network I/O buffers. The SO_SNDBUF setting may also be used
 * by the network implementation to determine the maximum size
 * of the packet that can be sent on this socket.
 * <p>
 * As SO_SNDBUF is a hint, applications that want to verify
 * what size the buffer is should call {@link #getSendBufferSize()}.
 * <p>
 * Increasing the buffer size may allow multiple outgoing packets
 * to be queued by the network implementation when the send rate
 * is high.
 * <p>
 * Note: If {@link #send(java.net.DatagramPacket)} is used to send a
 * {@code DatagramPacket} that is larger than the setting
 * of SO_SNDBUF then it is implementation specific if the
 * packet is sent or discarded.
 *
 * @param size the size to which to set the send buffer
 * size. This value must be greater than 0.
 *
 * @exception java.net.SocketException if there is an error
 * in the underlying protocol, such as an UDP error.
 * @exception java.lang.IllegalArgumentException if the value is 0 or is
 * negative.
 * @see #getSendBufferSize()
 * @apiSince 1
 */

public synchronized void setSendBufferSize(int size) throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Get value of the SO_SNDBUF option for this {@code DatagramSocket}, that is the
 * buffer size used by the platform for output on this {@code DatagramSocket}.
 *
 * @return the value of the SO_SNDBUF option for this {@code DatagramSocket}
 * @exception java.net.SocketException if there is an error in
 * the underlying protocol, such as an UDP error.
 * @see #setSendBufferSize
 * @apiSince 1
 */

public synchronized int getSendBufferSize() throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Sets the SO_RCVBUF option to the specified value for this
 * {@code DatagramSocket}. The SO_RCVBUF option is used by the
 * the network implementation as a hint to size the underlying
 * network I/O buffers. The SO_RCVBUF setting may also be used
 * by the network implementation to determine the maximum size
 * of the packet that can be received on this socket.
 * <p>
 * Because SO_RCVBUF is a hint, applications that want to
 * verify what size the buffers were set to should call
 * {@link #getReceiveBufferSize()}.
 * <p>
 * Increasing SO_RCVBUF may allow the network implementation
 * to buffer multiple packets when packets arrive faster than
 * are being received using {@link #receive(java.net.DatagramPacket)}.
 * <p>
 * Note: It is implementation specific if a packet larger
 * than SO_RCVBUF can be received.
 *
 * @param size the size to which to set the receive buffer
 * size. This value must be greater than 0.
 *
 * @exception java.net.SocketException if there is an error in
 * the underlying protocol, such as an UDP error.
 * @exception java.lang.IllegalArgumentException if the value is 0 or is
 * negative.
 * @see #getReceiveBufferSize()
 * @apiSince 1
 */

public synchronized void setReceiveBufferSize(int size) throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Get value of the SO_RCVBUF option for this {@code DatagramSocket}, that is the
 * buffer size used by the platform for input on this {@code DatagramSocket}.
 *
 * @return the value of the SO_RCVBUF option for this {@code DatagramSocket}
 * @exception java.net.SocketException if there is an error in the underlying protocol, such as an UDP error.
 * @see #setReceiveBufferSize(int)
 * @apiSince 1
 */

public synchronized int getReceiveBufferSize() throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Enable/disable the SO_REUSEADDR socket option.
 * <p>
 * For UDP sockets it may be necessary to bind more than one
 * socket to the same socket address. This is typically for the
 * purpose of receiving multicast packets
 * (See {@link java.net.MulticastSocket}). The
 * {@code SO_REUSEADDR} socket option allows multiple
 * sockets to be bound to the same socket address if the
 * {@code SO_REUSEADDR} socket option is enabled prior
 * to binding the socket using {@link #bind(java.net.SocketAddress)}.
 * <p>
 * Note: This functionality is not supported by all existing platforms,
 * so it is implementation specific whether this option will be ignored
 * or not. However, if it is not supported then
 * {@link #getReuseAddress()} will always return {@code false}.
 * <p>
 * When a {@code DatagramSocket} is created the initial setting
 * of {@code SO_REUSEADDR} is disabled.
 * <p>
 * The behaviour when {@code SO_REUSEADDR} is enabled or
 * disabled after a socket is bound (See {@link #isBound()})
 * is not defined.
 *
 * @param on  whether to enable or disable the
 * @exception java.net.SocketException if an error occurs enabling or
 *            disabling the {@code SO_RESUEADDR} socket option,
 *            or the socket is closed.
 * @since 1.4
 * @see #getReuseAddress()
 * @see #bind(SocketAddress)
 * @see #isBound()
 * @see #isClosed()
 * @apiSince 1
 */

public synchronized void setReuseAddress(boolean on) throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Tests if SO_REUSEADDR is enabled.
 *
 * @return a {@code boolean} indicating whether or not SO_REUSEADDR is enabled.
 * @exception java.net.SocketException if there is an error
 * in the underlying protocol, such as an UDP error.
 * @since   1.4
 * @see #setReuseAddress(boolean)
 * @apiSince 1
 */

public synchronized boolean getReuseAddress() throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Enable/disable SO_BROADCAST.
 *
 * <p> Some operating systems may require that the Java virtual machine be
 * started with implementation specific privileges to enable this option or
 * send broadcast datagrams.
 *
 * @param  on
 *         whether or not to have broadcast turned on.
 *
 * @throws  java.net.SocketException
 *          if there is an error in the underlying protocol, such as an UDP
 *          error.
 *
 * @since 1.4
 * @see #getBroadcast()
 * @apiSince 1
 */

public synchronized void setBroadcast(boolean on) throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Tests if SO_BROADCAST is enabled.
 * @return a {@code boolean} indicating whether or not SO_BROADCAST is enabled.
 * @exception java.net.SocketException if there is an error
 * in the underlying protocol, such as an UDP error.
 * @since 1.4
 * @see #setBroadcast(boolean)
 * @apiSince 1
 */

public synchronized boolean getBroadcast() throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Sets traffic class or type-of-service octet in the IP
 * datagram header for datagrams sent from this DatagramSocket.
 * As the underlying network implementation may ignore this
 * value applications should consider it a hint.
 *
 * <P> The tc <B>must</B> be in the range {@code 0 <= tc <=
 * 255} or an IllegalArgumentException will be thrown.
 * <p>Notes:
 * <p>For Internet Protocol v4 the value consists of an
 * {@code integer}, the least significant 8 bits of which
 * represent the value of the TOS octet in IP packets sent by
 * the socket.
 * RFC 1349 defines the TOS values as follows:
 *
 * <UL>
 * <LI><CODE>IPTOS_LOWCOST (0x02)</CODE></LI>
 * <LI><CODE>IPTOS_RELIABILITY (0x04)</CODE></LI>
 * <LI><CODE>IPTOS_THROUGHPUT (0x08)</CODE></LI>
 * <LI><CODE>IPTOS_LOWDELAY (0x10)</CODE></LI>
 * </UL>
 * The last low order bit is always ignored as this
 * corresponds to the MBZ (must be zero) bit.
 * <p>
 * Setting bits in the precedence field may result in a
 * SocketException indicating that the operation is not
 * permitted.
 * <p>
 * for Internet Protocol v6 {@code tc} is the value that
 * would be placed into the sin6_flowinfo field of the IP header.
 *
 * @param tc        an {@code int} value for the bitset.
 * @throws java.net.SocketException if there is an error setting the
 * traffic class or type-of-service
 * @since 1.4
 * @see #getTrafficClass
 * @apiSince 1
 */

public synchronized void setTrafficClass(int tc) throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Gets traffic class or type-of-service in the IP datagram
 * header for packets sent from this DatagramSocket.
 * <p>
 * As the underlying network implementation may ignore the
 * traffic class or type-of-service set using {@link #setTrafficClass(int)}
 * this method may return a different value than was previously
 * set using the {@link #setTrafficClass(int)} method on this
 * DatagramSocket.
 *
 * @return the traffic class or type-of-service already set
 * @throws java.net.SocketException if there is an error obtaining the
 * traffic class or type-of-service value.
 * @since 1.4
 * @see #setTrafficClass(int)
 * @apiSince 1
 */

public synchronized int getTrafficClass() throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Closes this datagram socket.
 * <p>
 * Any thread currently blocked in {@link #receive} upon this socket
 * will throw a {@link java.net.SocketException SocketException}.
 *
 * <p> If this socket has an associated channel then the channel is closed
 * as well.
 *
 * @revised 1.4
 * @spec JSR-51
 * @apiSince 1
 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the socket is closed or not.
 *
 * @return true if the socket has been closed
 * @since 1.4
 * @apiSince 1
 */

public boolean isClosed() { throw new RuntimeException("Stub!"); }

/**
 * Returns the unique {@link java.nio.channels.DatagramChannel} object
 * associated with this datagram socket, if any.
 *
 * <p> A datagram socket will have a channel if, and only if, the channel
 * itself was created via the {@link java.nio.channels.DatagramChannel#open
 * DatagramChannel.open} method.
 *
 * @return  the datagram channel associated with this datagram socket,
 *          or {@code null} if this socket was not created for a channel
 *
 * @since 1.4
 * @spec JSR-51
 * @apiSince 1
 */

public java.nio.channels.DatagramChannel getChannel() { throw new RuntimeException("Stub!"); }

/**
 * Sets the datagram socket implementation factory for the
 * application. The factory can be specified only once.
 * <p>
 * When an application creates a new datagram socket, the socket
 * implementation factory's {@code createDatagramSocketImpl} method is
 * called to create the actual datagram socket implementation.
 * <p>
 * Passing {@code null} to the method is a no-op unless the factory
 * was already set.
 *
 * <p>If there is a security manager, this method first calls
 * the security manager's {@code checkSetFactory} method
 * to ensure the operation is allowed.
 * This could result in a SecurityException.
 *
 * @param      fac   the desired factory.
 * @exception  java.io.IOException  if an I/O error occurs when setting the
 *              datagram socket factory.
 * @exception  java.net.SocketException  if the factory is already defined.
 * @exception  java.lang.SecurityException  if a security manager exists and its
 *             {@code checkSetFactory} method doesn't allow the
 operation.
 * @see
 java.net.DatagramSocketImplFactory#createDatagramSocketImpl()
 * @see       java.lang.SecurityManager#checkSetFactory
 * @since 1.3
 * @apiSince 1
 */

public static synchronized void setDatagramSocketImplFactory(java.net.DatagramSocketImplFactory fac) throws java.io.IOException { throw new RuntimeException("Stub!"); }
}

