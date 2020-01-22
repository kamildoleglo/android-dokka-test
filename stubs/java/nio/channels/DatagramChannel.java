/*
 * Copyright (c) 2000, 2013, Oracle and/or its affiliates. All rights reserved.
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



package java.nio.channels;

import java.net.SocketOption;
import java.nio.ByteBuffer;
import java.nio.channels.spi.SelectorProvider;
import java.net.ProtocolFamily;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketAddress;

/**
 * A selectable channel for datagram-oriented sockets.
 *
 * <p> A datagram channel is created by invoking one of the {@link #open open} methods
 * of this class. It is not possible to create a channel for an arbitrary,
 * pre-existing datagram socket. A newly-created datagram channel is open but not
 * connected. A datagram channel need not be connected in order for the {@link #send
 * send} and {@link #receive receive} methods to be used.  A datagram channel may be
 * connected, by invoking its {@link #connect connect} method, in order to
 * avoid the overhead of the security checks are otherwise performed as part of
 * every send and receive operation.  A datagram channel must be connected in
 * order to use the {@link #read(java.nio.ByteBuffer) read} and {@link
 * #write(java.nio.ByteBuffer) write} methods, since those methods do not
 * accept or return socket addresses.
 *
 * <p> Once connected, a datagram channel remains connected until it is
 * disconnected or closed.  Whether or not a datagram channel is connected may
 * be determined by invoking its {@link #isConnected isConnected} method.
 *
 * <p> Socket options are configured using the {@link #setOption(java.net.SocketOption,java.lang.Object)
 * setOption} method. A datagram channel to an Internet Protocol socket supports
 * the following options:
 * <blockquote>
 * <table border summary="Socket options">
 *   <tr>
 *     <th>Option Name</th>
 *     <th>Description</th>
 *   </tr>
 *   <tr>
 *     <td> {@link java.net.StandardSocketOptions#SO_SNDBUF SO_SNDBUF} </td>
 *     <td> The size of the socket send buffer </td>
 *   </tr>
 *   <tr>
 *     <td> {@link java.net.StandardSocketOptions#SO_RCVBUF SO_RCVBUF} </td>
 *     <td> The size of the socket receive buffer </td>
 *   </tr>
 *   <tr>
 *     <td> {@link java.net.StandardSocketOptions#SO_REUSEADDR SO_REUSEADDR} </td>
 *     <td> Re-use address </td>
 *   </tr>
 *   <tr>
 *     <td> {@link java.net.StandardSocketOptions#SO_BROADCAST SO_BROADCAST} </td>
 *     <td> Allow transmission of broadcast datagrams </td>
 *   </tr>
 *   <tr>
 *     <td> {@link java.net.StandardSocketOptions#IP_TOS IP_TOS} </td>
 *     <td> The Type of Service (ToS) octet in the Internet Protocol (IP) header </td>
 *   </tr>
 *   <tr>
 *     <td> {@link java.net.StandardSocketOptions#IP_MULTICAST_IF IP_MULTICAST_IF} </td>
 *     <td> The network interface for Internet Protocol (IP) multicast datagrams </td>
 *   </tr>
 *   <tr>
 *     <td> {@link java.net.StandardSocketOptions#IP_MULTICAST_TTL
 *       IP_MULTICAST_TTL} </td>
 *     <td> The <em>time-to-live</em> for Internet Protocol (IP) multicast
 *       datagrams </td>
 *   </tr>
 *   <tr>
 *     <td> {@link java.net.StandardSocketOptions#IP_MULTICAST_LOOP
 *       IP_MULTICAST_LOOP} </td>
 *     <td> Loopback for Internet Protocol (IP) multicast datagrams </td>
 *   </tr>
 * </table>
 * </blockquote>
 * Additional (implementation specific) options may also be supported.
 *
 * <p> Datagram channels are safe for use by multiple concurrent threads.  They
 * support concurrent reading and writing, though at most one thread may be
 * reading and at most one thread may be writing at any given time.  </p>
 *
 * @author Mark Reinhold
 * @author JSR-51 Expert Group
 * @since 1.4
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class DatagramChannel extends java.nio.channels.spi.AbstractSelectableChannel implements java.nio.channels.ByteChannel, java.nio.channels.ScatteringByteChannel, java.nio.channels.GatheringByteChannel, java.nio.channels.MulticastChannel {

/**
 * Initializes a new instance of this class.
 *
 * @param  provider
 *         The provider that created this channel
 * @apiSince 1
 */

protected DatagramChannel(java.nio.channels.spi.SelectorProvider provider) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Opens a datagram channel.
 *
 * <p> The new channel is created by invoking the {@link
 * java.nio.channels.spi.SelectorProvider#openDatagramChannel()
 * openDatagramChannel} method of the system-wide default {@link
 * java.nio.channels.spi.SelectorProvider} object.  The channel will not be
 * connected.
 *
 * <p> The {@link java.net.ProtocolFamily ProtocolFamily} of the channel's socket
 * is platform (and possibly configuration) dependent and therefore unspecified.
 * The {@link #open(java.net.ProtocolFamily) open} allows the protocol family to be
 * selected when opening a datagram channel, and should be used to open
 * datagram channels that are intended for Internet Protocol multicasting.
 *
 * @return  A new datagram channel
 *
 * @throws  java.io.IOException
 *          If an I/O error occurs
 * @apiSince 1
 */

public static java.nio.channels.DatagramChannel open() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Opens a datagram channel.
 *
 * <p> The {@code family} parameter is used to specify the {@link java.net.ProtocolFamily ProtocolFamily}. If the datagram channel is to be used for IP multicasting
 * then this should correspond to the address type of the multicast groups
 * that this channel will join.
 *
 * <p> The new channel is created by invoking the {@link
 * java.nio.channels.spi.SelectorProvider#openDatagramChannel(ProtocolFamily)
 * openDatagramChannel} method of the system-wide default {@link
 * java.nio.channels.spi.SelectorProvider} object.  The channel will not be
 * connected.
 *
 * @param   family
 *          The protocol family
 *
 * @return  A new datagram channel
 *
 * @throws  java.lang.UnsupportedOperationException
 *          If the specified protocol family is not supported. For example,
 *          suppose the parameter is specified as {@link
 *          java.net.StandardProtocolFamily#INET6 StandardProtocolFamily.INET6}
 *          but IPv6 is not enabled on the platform.
 * @throws  java.io.IOException
 *          If an I/O error occurs
 *
 * @since   1.7
 * @apiSince 24
 */

public static java.nio.channels.DatagramChannel open(java.net.ProtocolFamily family) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns an operation set identifying this channel's supported
 * operations.
 *
 * <p> Datagram channels support reading and writing, so this method
 * returns <tt>(</tt>{@link java.nio.channels.SelectionKey#OP_READ SelectionKey#OP_READ} <tt>|</tt>&nbsp;{@link java.nio.channels.SelectionKey#OP_WRITE SelectionKey#OP_WRITE}<tt>)</tt>.  </p>
 *
 * @return  The valid-operation set
 * @apiSince 1
 */

public final int validOps() { throw new RuntimeException("Stub!"); }

/**
 * @throws  java.nio.channels.AlreadyBoundException               {@inheritDoc}
 * @throws  java.nio.channels.UnsupportedAddressTypeException     {@inheritDoc}
 * @throws  java.nio.channels.ClosedChannelException              {@inheritDoc}
 * @throws  java.io.IOException                         {@inheritDoc}
 * @throws  java.lang.SecurityException
 *          If a security manager has been installed and its {@link java.lang.SecurityManager#checkListen SecurityManager#checkListen} method denies the
 *          operation
 *
 * @since 1.7
 * @apiSince 24
 */

public abstract java.nio.channels.DatagramChannel bind(java.net.SocketAddress local) throws java.io.IOException;

/**
 * @throws  java.lang.UnsupportedOperationException           {@inheritDoc}
 * @throws  java.lang.IllegalArgumentException                {@inheritDoc}
 * @throws  java.nio.channels.ClosedChannelException                  {@inheritDoc}
 * @throws  java.io.IOException                             {@inheritDoc}
 *
 * @since 1.7
 * @apiSince 24
 */

public abstract <T> java.nio.channels.DatagramChannel setOption(java.net.SocketOption<T> name, T value) throws java.io.IOException;

/**
 * Retrieves a datagram socket associated with this channel.
 *
 * <p> The returned object will not declare any public methods that are not
 * declared in the {@link java.net.DatagramSocket} class.  </p>
 *
 * @return  A datagram socket associated with this channel
 * @apiSince 1
 */

public abstract java.net.DatagramSocket socket();

/**
 * Tells whether or not this channel's socket is connected.
 *
 * @return  {@code true} if, and only if, this channel's socket
 *          is {@link #isOpen open} and connected
 * @apiSince 1
 */

public abstract boolean isConnected();

/**
 * Connects this channel's socket.
 *
 * <p> The channel's socket is configured so that it only receives
 * datagrams from, and sends datagrams to, the given remote <i>peer</i>
 * address.  Once connected, datagrams may not be received from or sent to
 * any other address.  A datagram socket remains connected until it is
 * explicitly disconnected or until it is closed.
 *
 * <p> This method performs exactly the same security checks as the {@link
 * java.net.DatagramSocket#connect connect} method of the {@link
 * java.net.DatagramSocket} class.  That is, if a security manager has been
 * installed then this method verifies that its {@link
 * java.lang.SecurityManager#checkAccept checkAccept} and {@link
 * java.lang.SecurityManager#checkConnect checkConnect} methods permit
 * datagrams to be received from and sent to, respectively, the given
 * remote address.
 *
 * <p> This method may be invoked at any time.  It will not have any effect
 * on read or write operations that are already in progress at the moment
 * that it is invoked. If this channel's socket is not bound then this method
 * will first cause the socket to be bound to an address that is assigned
 * automatically, as if invoking the {@link #bind bind} method with a
 * parameter of {@code null}. </p>
 *
 * @param  remote
 *         The remote address to which this channel is to be connected
 *
 * @return  This datagram channel
 *
 * @throws  java.nio.channels.ClosedChannelException
 *          If this channel is closed
 *
 * @throws  java.nio.channels.AsynchronousCloseException
 *          If another thread closes this channel
 *          while the connect operation is in progress
 *
 * @throws  java.nio.channels.ClosedByInterruptException
 *          If another thread interrupts the current thread
 *          while the connect operation is in progress, thereby
 *          closing the channel and setting the current thread's
 *          interrupt status
 *
 * @throws  java.lang.SecurityException
 *          If a security manager has been installed
 *          and it does not permit access to the given remote address
 *
 * @throws  java.io.IOException
 *          If some other I/O error occurs
 * @apiSince 1
 */

public abstract java.nio.channels.DatagramChannel connect(java.net.SocketAddress remote) throws java.io.IOException;

/**
 * Disconnects this channel's socket.
 *
 * <p> The channel's socket is configured so that it can receive datagrams
 * from, and sends datagrams to, any remote address so long as the security
 * manager, if installed, permits it.
 *
 * <p> This method may be invoked at any time.  It will not have any effect
 * on read or write operations that are already in progress at the moment
 * that it is invoked.
 *
 * <p> If this channel's socket is not connected, or if the channel is
 * closed, then invoking this method has no effect.  </p>
 *
 * @return  This datagram channel
 *
 * @throws  java.io.IOException
 *          If some other I/O error occurs
 * @apiSince 1
 */

public abstract java.nio.channels.DatagramChannel disconnect() throws java.io.IOException;

/**
 * Returns the remote address to which this channel's socket is connected.
 *
 * @return  The remote address; {@code null} if the channel's socket is not
 *          connected
 *
 * @throws  java.nio.channels.ClosedChannelException
 *          If the channel is closed
 * @throws  java.io.IOException
 *          If an I/O error occurs
 *
 * @since 1.7
 * @apiSince 24
 */

public abstract java.net.SocketAddress getRemoteAddress() throws java.io.IOException;

/**
 * Receives a datagram via this channel.
 *
 * <p> If a datagram is immediately available, or if this channel is in
 * blocking mode and one eventually becomes available, then the datagram is
 * copied into the given byte buffer and its source address is returned.
 * If this channel is in non-blocking mode and a datagram is not
 * immediately available then this method immediately returns
 * <tt>null</tt>.
 *
 * <p> The datagram is transferred into the given byte buffer starting at
 * its current position, as if by a regular {@link java.nio.channels.ReadableByteChannel#read(java.nio.ByteBuffer) ReadableByteChannel#read(java.nio.ByteBuffer)} operation.  If there
 * are fewer bytes remaining in the buffer than are required to hold the
 * datagram then the remainder of the datagram is silently discarded.
 *
 * <p> This method performs exactly the same security checks as the {@link
 * java.net.DatagramSocket#receive receive} method of the {@link
 * java.net.DatagramSocket} class.  That is, if the socket is not connected
 * to a specific remote address and a security manager has been installed
 * then for each datagram received this method verifies that the source's
 * address and port number are permitted by the security manager's {@link
 * java.lang.SecurityManager#checkAccept checkAccept} method.  The overhead
 * of this security check can be avoided by first connecting the socket via
 * the {@link #connect connect} method.
 *
 * <p> This method may be invoked at any time.  If another thread has
 * already initiated a read operation upon this channel, however, then an
 * invocation of this method will block until the first operation is
 * complete. If this channel's socket is not bound then this method will
 * first cause the socket to be bound to an address that is assigned
 * automatically, as if invoking the {@link #bind bind} method with a
 * parameter of {@code null}. </p>
 *
 * @param  dst
 *         The buffer into which the datagram is to be transferred
 *
 * @return  The datagram's source address,
 *          or <tt>null</tt> if this channel is in non-blocking mode
 *          and no datagram was immediately available
 *
 * @throws  java.nio.channels.ClosedChannelException
 *          If this channel is closed
 *
 * @throws  java.nio.channels.AsynchronousCloseException
 *          If another thread closes this channel
 *          while the read operation is in progress
 *
 * @throws  java.nio.channels.ClosedByInterruptException
 *          If another thread interrupts the current thread
 *          while the read operation is in progress, thereby
 *          closing the channel and setting the current thread's
 *          interrupt status
 *
 * @throws  java.lang.SecurityException
 *          If a security manager has been installed
 *          and it does not permit datagrams to be accepted
 *          from the datagram's sender
 *
 * @throws  java.io.IOException
 *          If some other I/O error occurs
 * @apiSince 1
 */

public abstract java.net.SocketAddress receive(java.nio.ByteBuffer dst) throws java.io.IOException;

/**
 * Sends a datagram via this channel.
 *
 * <p> If this channel is in non-blocking mode and there is sufficient room
 * in the underlying output buffer, or if this channel is in blocking mode
 * and sufficient room becomes available, then the remaining bytes in the
 * given buffer are transmitted as a single datagram to the given target
 * address.
 *
 * <p> The datagram is transferred from the byte buffer as if by a regular
 * {@link java.nio.channels.WritableByteChannel#write(java.nio.ByteBuffer) WritableByteChannel#write(java.nio.ByteBuffer)} operation.
 *
 * <p> This method performs exactly the same security checks as the {@link
 * java.net.DatagramSocket#send send} method of the {@link
 * java.net.DatagramSocket} class.  That is, if the socket is not connected
 * to a specific remote address and a security manager has been installed
 * then for each datagram sent this method verifies that the target address
 * and port number are permitted by the security manager's {@link
 * java.lang.SecurityManager#checkConnect checkConnect} method.  The
 * overhead of this security check can be avoided by first connecting the
 * socket via the {@link #connect connect} method.
 *
 * <p> This method may be invoked at any time.  If another thread has
 * already initiated a write operation upon this channel, however, then an
 * invocation of this method will block until the first operation is
 * complete. If this channel's socket is not bound then this method will
 * first cause the socket to be bound to an address that is assigned
 * automatically, as if by invoking the {@link #bind bind} method with a
 * parameter of {@code null}. </p>
 *
 * @param  src
 *         The buffer containing the datagram to be sent
 *
 * @param  target
 *         The address to which the datagram is to be sent
 *
 * @return   The number of bytes sent, which will be either the number
 *           of bytes that were remaining in the source buffer when this
 *           method was invoked or, if this channel is non-blocking, may be
 *           zero if there was insufficient room for the datagram in the
 *           underlying output buffer
 *
 * @throws  java.nio.channels.ClosedChannelException
 *          If this channel is closed
 *
 * @throws  java.nio.channels.AsynchronousCloseException
 *          If another thread closes this channel
 *          while the read operation is in progress
 *
 * @throws  java.nio.channels.ClosedByInterruptException
 *          If another thread interrupts the current thread
 *          while the read operation is in progress, thereby
 *          closing the channel and setting the current thread's
 *          interrupt status
 *
 * @throws  java.lang.SecurityException
 *          If a security manager has been installed
 *          and it does not permit datagrams to be sent
 *          to the given address
 *
 * @throws  java.io.IOException
 *          If some other I/O error occurs
 * @apiSince 1
 */

public abstract int send(java.nio.ByteBuffer src, java.net.SocketAddress target) throws java.io.IOException;

/**
 * Reads a datagram from this channel.
 *
 * <p> This method may only be invoked if this channel's socket is
 * connected, and it only accepts datagrams from the socket's peer.  If
 * there are more bytes in the datagram than remain in the given buffer
 * then the remainder of the datagram is silently discarded.  Otherwise
 * this method behaves exactly as specified in the {@link java.nio.channels.ReadableByteChannel ReadableByteChannel} interface.  </p>
 *
 * @throws  java.nio.channels.NotYetConnectedException
 *          If this channel's socket is not connected
 * @apiSince 1
 */

public abstract int read(java.nio.ByteBuffer dst) throws java.io.IOException;

/**
 * Reads a datagram from this channel.
 *
 * <p> This method may only be invoked if this channel's socket is
 * connected, and it only accepts datagrams from the socket's peer.  If
 * there are more bytes in the datagram than remain in the given buffers
 * then the remainder of the datagram is silently discarded.  Otherwise
 * this method behaves exactly as specified in the {@link java.nio.channels.ScatteringByteChannel ScatteringByteChannel} interface.  </p>
 *
 * @throws  java.nio.channels.NotYetConnectedException
 *          If this channel's socket is not connected
 * @apiSince 1
 */

public abstract long read(java.nio.ByteBuffer[] dsts, int offset, int length) throws java.io.IOException;

/**
 * Reads a datagram from this channel.
 *
 * <p> This method may only be invoked if this channel's socket is
 * connected, and it only accepts datagrams from the socket's peer.  If
 * there are more bytes in the datagram than remain in the given buffers
 * then the remainder of the datagram is silently discarded.  Otherwise
 * this method behaves exactly as specified in the {@link java.nio.channels.ScatteringByteChannel ScatteringByteChannel} interface.  </p>
 *
 * @throws  java.nio.channels.NotYetConnectedException
 *          If this channel's socket is not connected
 * @apiSince 1
 */

public final long read(java.nio.ByteBuffer[] dsts) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Writes a datagram to this channel.
 *
 * <p> This method may only be invoked if this channel's socket is
 * connected, in which case it sends datagrams directly to the socket's
 * peer.  Otherwise it behaves exactly as specified in the {@link java.nio.channels.WritableByteChannel WritableByteChannel} interface.  </p>
 *
 * @throws  java.nio.channels.NotYetConnectedException
 *          If this channel's socket is not connected
 * @apiSince 1
 */

public abstract int write(java.nio.ByteBuffer src) throws java.io.IOException;

/**
 * Writes a datagram to this channel.
 *
 * <p> This method may only be invoked if this channel's socket is
 * connected, in which case it sends datagrams directly to the socket's
 * peer.  Otherwise it behaves exactly as specified in the {@link java.nio.channels.GatheringByteChannel GatheringByteChannel} interface.  </p>
 *
 * @return   The number of bytes sent, which will be either the number
 *           of bytes that were remaining in the source buffer when this
 *           method was invoked or, if this channel is non-blocking, may be
 *           zero if there was insufficient room for the datagram in the
 *           underlying output buffer
 *
 * @throws  java.nio.channels.NotYetConnectedException
 *          If this channel's socket is not connected
 * @apiSince 1
 */

public abstract long write(java.nio.ByteBuffer[] srcs, int offset, int length) throws java.io.IOException;

/**
 * Writes a datagram to this channel.
 *
 * <p> This method may only be invoked if this channel's socket is
 * connected, in which case it sends datagrams directly to the socket's
 * peer.  Otherwise it behaves exactly as specified in the {@link java.nio.channels.GatheringByteChannel GatheringByteChannel} interface.  </p>
 *
 * @return   The number of bytes sent, which will be either the number
 *           of bytes that were remaining in the source buffer when this
 *           method was invoked or, if this channel is non-blocking, may be
 *           zero if there was insufficient room for the datagram in the
 *           underlying output buffer
 *
 * @throws  java.nio.channels.NotYetConnectedException
 *          If this channel's socket is not connected
 * @apiSince 1
 */

public final long write(java.nio.ByteBuffer[] srcs) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * <p>
 * If there is a security manager set, its {@code checkConnect} method is
 * called with the local address and {@code -1} as its arguments to see
 * if the operation is allowed. If the operation is not allowed,
 * a {@code SocketAddress} representing the
 * {@link java.net.InetAddress#getLoopbackAddress loopback} address and the
 * local port of the channel's socket is returned.
 *
 * @return  The {@code SocketAddress} that the socket is bound to, or the
 *          {@code SocketAddress} representing the loopback address if
 *          denied by the security manager, or {@code null} if the
 *          channel's socket is not bound
 *
 * @throws  java.nio.channels.ClosedChannelException     {@inheritDoc}
 * @throws  java.io.IOException                {@inheritDoc}
 * @apiSince 24
 */

public abstract java.net.SocketAddress getLocalAddress() throws java.io.IOException;
}

