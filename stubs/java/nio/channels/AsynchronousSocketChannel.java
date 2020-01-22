/*
 * Copyright (c) 2007, 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.nio.channels.spi.*;
import java.net.SocketOption;
import java.util.concurrent.TimeUnit;
import java.nio.ByteBuffer;
import java.io.IOException;
import java.util.concurrent.Future;
import java.net.SocketAddress;

/**
 * An asynchronous channel for stream-oriented connecting sockets.
 *
 * <p> Asynchronous socket channels are created in one of two ways. A newly-created
 * {@code AsynchronousSocketChannel} is created by invoking one of the {@link
 * #open open} methods defined by this class. A newly-created channel is open but
 * not yet connected. A connected {@code AsynchronousSocketChannel} is created
 * when a connection is made to the socket of an {@link java.nio.channels.AsynchronousServerSocketChannel AsynchronousServerSocketChannel}.
 * It is not possible to create an asynchronous socket channel for an arbitrary,
 * pre-existing {@link java.net.Socket socket}.
 *
 * <p> A newly-created channel is connected by invoking its {@link #connect connect}
 * method; once connected, a channel remains connected until it is closed.  Whether
 * or not a socket channel is connected may be determined by invoking its {@link
 * #getRemoteAddress getRemoteAddress} method. An attempt to invoke an I/O
 * operation upon an unconnected channel will cause a {@link java.nio.channels.NotYetConnectedException NotYetConnectedException}
 * to be thrown.
 *
 * <p> Channels of this type are safe for use by multiple concurrent threads.
 * They support concurrent reading and writing, though at most one read operation
 * and one write operation can be outstanding at any time.
 * If a thread initiates a read operation before a previous read operation has
 * completed then a {@link java.nio.channels.ReadPendingException ReadPendingException} will be thrown. Similarly, an
 * attempt to initiate a write operation before a previous write has completed
 * will throw a {@link java.nio.channels.WritePendingException WritePendingException}.
 *
 * <p> Socket options are configured using the {@link #setOption(java.net.SocketOption,java.lang.Object)
 * setOption} method. Asynchronous socket channels support the following options:
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
 *     <td> {@link java.net.StandardSocketOptions#SO_KEEPALIVE SO_KEEPALIVE} </td>
 *     <td> Keep connection alive </td>
 *   </tr>
 *   <tr>
 *     <td> {@link java.net.StandardSocketOptions#SO_REUSEADDR SO_REUSEADDR} </td>
 *     <td> Re-use address </td>
 *   </tr>
 *   <tr>
 *     <td> {@link java.net.StandardSocketOptions#TCP_NODELAY TCP_NODELAY} </td>
 *     <td> Disable the Nagle algorithm </td>
 *   </tr>
 * </table>
 * </blockquote>
 * Additional (implementation specific) options may also be supported.
 *
 * <h2>Timeouts</h2>
 *
 * <p> The {@link #read(java.nio.ByteBuffer,long,java.util.concurrent.TimeUnit,java.lang.Object,java.nio.channels.CompletionHandler) read}
 * and {@link #write(java.nio.ByteBuffer,long,java.util.concurrent.TimeUnit,java.lang.Object,java.nio.channels.CompletionHandler) write}
 * methods defined by this class allow a timeout to be specified when initiating
 * a read or write operation. If the timeout elapses before an operation completes
 * then the operation completes with the exception {@link java.nio.channels.InterruptedByTimeoutException InterruptedByTimeoutException}. A timeout may leave the channel, or the
 * underlying connection, in an inconsistent state. Where the implementation
 * cannot guarantee that bytes have not been read from the channel then it puts
 * the channel into an implementation specific <em>error state</em>. A subsequent
 * attempt to initiate a {@code read} operation causes an unspecified runtime
 * exception to be thrown. Similarly if a {@code write} operation times out and
 * the implementation cannot guarantee bytes have not been written to the
 * channel then further attempts to {@code write} to the channel cause an
 * unspecified runtime exception to be thrown. When a timeout elapses then the
 * state of the {@link java.nio.ByteBuffer ByteBuffer}, or the sequence of buffers, for the I/O
 * operation is not defined. Buffers should be discarded or at least care must
 * be taken to ensure that the buffers are not accessed while the channel remains
 * open. All methods that accept timeout parameters treat values less than or
 * equal to zero to mean that the I/O operation does not timeout.
 *
 * @since 1.7
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class AsynchronousSocketChannel implements java.nio.channels.AsynchronousByteChannel, java.nio.channels.NetworkChannel {

/**
 * Initializes a new instance of this class.
 *
 * @param  provider
 *         The provider that created this channel
 * @apiSince 26
 */

protected AsynchronousSocketChannel(java.nio.channels.spi.AsynchronousChannelProvider provider) { throw new RuntimeException("Stub!"); }

/**
 * Returns the provider that created this channel.
 *
 * @return  The provider that created this channel
 * @apiSince 26
 */

public final java.nio.channels.spi.AsynchronousChannelProvider provider() { throw new RuntimeException("Stub!"); }

/**
 * Opens an asynchronous socket channel.
 *
 * <p> The new channel is created by invoking the {@link java.nio.channels.spi.AsynchronousChannelProvider#openAsynchronousSocketChannel AsynchronousChannelProvider#openAsynchronousSocketChannel} method on the {@link java.nio.channels.spi.AsynchronousChannelProvider AsynchronousChannelProvider} that created the group. If the group parameter
 * is {@code null} then the resulting channel is created by the system-wide
 * default provider, and bound to the <em>default group</em>.
 *
 * @param   group
 *          The group to which the newly constructed channel should be bound,
 *          or {@code null} for the default group
 *
 * @return  A new asynchronous socket channel
 *
 * @throws  java.nio.channels.ShutdownChannelGroupException
 *          If the channel group is shutdown
 * @throws  java.io.IOException
 *          If an I/O error occurs
 * @apiSince 26
 */

public static java.nio.channels.AsynchronousSocketChannel open(java.nio.channels.AsynchronousChannelGroup group) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Opens an asynchronous socket channel.
 *
 * <p> This method returns an asynchronous socket channel that is bound to
 * the <em>default group</em>.This method is equivalent to evaluating the
 * expression:
 * <blockquote><pre>
 * open((AsynchronousChannelGroup)null);
 * </pre></blockquote>
 *
 * @return  A new asynchronous socket channel
 *
 * @throws  java.io.IOException
 *          If an I/O error occurs
 * @apiSince 26
 */

public static java.nio.channels.AsynchronousSocketChannel open() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * @throws  java.nio.channels.ConnectionPendingException
 *          If a connection operation is already in progress on this channel
 * @throws  java.nio.channels.AlreadyBoundException               {@inheritDoc}
 * @throws  java.nio.channels.UnsupportedAddressTypeException     {@inheritDoc}
 * @throws  java.nio.channels.ClosedChannelException              {@inheritDoc}
 * @throws  java.io.IOException                         {@inheritDoc}
 * @throws  java.lang.SecurityException
 *          If a security manager has been installed and its
 *          {@link java.lang.SecurityManager#checkListen SecurityManager#checkListen} method denies
 *          the operation
 * @apiSince 26
 */

public abstract java.nio.channels.AsynchronousSocketChannel bind(java.net.SocketAddress local) throws java.io.IOException;

/**
 * @throws  java.lang.IllegalArgumentException                {@inheritDoc}
 * @throws  java.nio.channels.ClosedChannelException                  {@inheritDoc}
 * @throws  java.io.IOException                             {@inheritDoc}
 * @apiSince 26
 */

public abstract <T> java.nio.channels.AsynchronousSocketChannel setOption(java.net.SocketOption<T> name, T value) throws java.io.IOException;

/**
 * Shutdown the connection for reading without closing the channel.
 *
 * <p> Once shutdown for reading then further reads on the channel will
 * return {@code -1}, the end-of-stream indication. If the input side of the
 * connection is already shutdown then invoking this method has no effect.
 * The effect on an outstanding read operation is system dependent and
 * therefore not specified. The effect, if any, when there is data in the
 * socket receive buffer that has not been read, or data arrives subsequently,
 * is also system dependent.
 *
 * @return  The channel
 *
 * @throws  java.nio.channels.NotYetConnectedException
 *          If this channel is not yet connected
 * @throws  java.nio.channels.ClosedChannelException
 *          If this channel is closed
 * @throws  java.io.IOException
 *          If some other I/O error occurs
 * @apiSince 26
 */

public abstract java.nio.channels.AsynchronousSocketChannel shutdownInput() throws java.io.IOException;

/**
 * Shutdown the connection for writing without closing the channel.
 *
 * <p> Once shutdown for writing then further attempts to write to the
 * channel will throw {@link java.nio.channels.ClosedChannelException ClosedChannelException}. If the output side of
 * the connection is already shutdown then invoking this method has no
 * effect. The effect on an outstanding write operation is system dependent
 * and therefore not specified.
 *
 * @return  The channel
 *
 * @throws  java.nio.channels.NotYetConnectedException
 *          If this channel is not yet connected
 * @throws  java.nio.channels.ClosedChannelException
 *          If this channel is closed
 * @throws  java.io.IOException
 *          If some other I/O error occurs
 * @apiSince 26
 */

public abstract java.nio.channels.AsynchronousSocketChannel shutdownOutput() throws java.io.IOException;

/**
 * Returns the remote address to which this channel's socket is connected.
 *
 * <p> Where the channel is bound and connected to an Internet Protocol
 * socket address then the return value from this method is of type {@link
 * java.net.InetSocketAddress}.
 *
 * @return  The remote address; {@code null} if the channel's socket is not
 *          connected
 *
 * @throws  java.nio.channels.ClosedChannelException
 *          If the channel is closed
 * @throws  java.io.IOException
 *          If an I/O error occurs
 * @apiSince 26
 */

public abstract java.net.SocketAddress getRemoteAddress() throws java.io.IOException;

/**
 * Connects this channel.
 *
 * <p> This method initiates an operation to connect this channel. The
 * {@code handler} parameter is a completion handler that is invoked when
 * the connection is successfully established or connection cannot be
 * established. If the connection cannot be established then the channel is
 * closed.
 *
 * <p> This method performs exactly the same security checks as the {@link
 * java.net.Socket} class.  That is, if a security manager has been
 * installed then this method verifies that its {@link
 * java.lang.SecurityManager#checkConnect checkConnect} method permits
 * connecting to the address and port number of the given remote endpoint.
 *
 * @param   <A>
 *          The type of the attachment
 * @param   remote
 *          The remote address to which this channel is to be connected
 * @param   attachment
 *          The object to attach to the I/O operation; can be {@code null}
 * @param   handler
 *          The handler for consuming the result
 *
 * @throws  java.nio.channels.UnresolvedAddressException
 *          If the given remote address is not fully resolved
 * @throws  java.nio.channels.UnsupportedAddressTypeException
 *          If the type of the given remote address is not supported
 * @throws  java.nio.channels.AlreadyConnectedException
 *          If this channel is already connected
 * @throws  java.nio.channels.ConnectionPendingException
 *          If a connection operation is already in progress on this channel
 * @throws  java.nio.channels.ShutdownChannelGroupException
 *          If the channel group has terminated
 * @throws  java.lang.SecurityException
 *          If a security manager has been installed
 *          and it does not permit access to the given remote endpoint
 *
 * @see #getRemoteAddress
 * @apiSince 26
 */

public abstract <A> void connect(java.net.SocketAddress remote, A attachment, java.nio.channels.CompletionHandler<java.lang.Void,? super A> handler);

/**
 * Connects this channel.
 *
 * <p> This method initiates an operation to connect this channel. This
 * method behaves in exactly the same manner as the {@link
 * #connect(java.net.SocketAddress,java.lang.Object,java.nio.channels.CompletionHandler)} method except that
 * instead of specifying a completion handler, this method returns a {@code
 * Future} representing the pending result. The {@code Future}'s {@link java.util.concurrent.Future#get() Future#get()} method returns {@code null} on successful completion.
 *
 * @param   remote
 *          The remote address to which this channel is to be connected
 *
 * @return  A {@code Future} object representing the pending result
 *
 * @throws  java.nio.channels.UnresolvedAddressException
 *          If the given remote address is not fully resolved
 * @throws  java.nio.channels.UnsupportedAddressTypeException
 *          If the type of the given remote address is not supported
 * @throws  java.nio.channels.AlreadyConnectedException
 *          If this channel is already connected
 * @throws  java.nio.channels.ConnectionPendingException
 *          If a connection operation is already in progress on this channel
 * @throws  java.lang.SecurityException
 *          If a security manager has been installed
 *          and it does not permit access to the given remote endpoint
 * @apiSince 26
 */

public abstract java.util.concurrent.Future<java.lang.Void> connect(java.net.SocketAddress remote);

/**
 * Reads a sequence of bytes from this channel into the given buffer.
 *
 * <p> This method initiates an asynchronous read operation to read a
 * sequence of bytes from this channel into the given buffer. The {@code
 * handler} parameter is a completion handler that is invoked when the read
 * operation completes (or fails). The result passed to the completion
 * handler is the number of bytes read or {@code -1} if no bytes could be
 * read because the channel has reached end-of-stream.
 *
 * <p> If a timeout is specified and the timeout elapses before the operation
 * completes then the operation completes with the exception {@link java.nio.channels.InterruptedByTimeoutException InterruptedByTimeoutException}. Where a timeout occurs, and the
 * implementation cannot guarantee that bytes have not been read, or will not
 * be read from the channel into the given buffer, then further attempts to
 * read from the channel will cause an unspecific runtime exception to be
 * thrown.
 *
 * <p> Otherwise this method works in the same manner as the {@link java.nio.channels.AsynchronousByteChannel#read(java.nio.ByteBuffer,java.lang.Object,java.nio.channels.CompletionHandler) AsynchronousByteChannel#read(ByteBuffer,Object,CompletionHandler)}
 * method.
 *
 * @param   <A>
 *          The type of the attachment
 * @param   dst
 *          The buffer into which bytes are to be transferred
 * @param   timeout
 *          The maximum time for the I/O operation to complete
 * @param   unit
 *          The time unit of the {@code timeout} argument
 * @param   attachment
 *          The object to attach to the I/O operation; can be {@code null}
 * @param   handler
 *          The handler for consuming the result
 *
 * @throws  java.lang.IllegalArgumentException
 *          If the buffer is read-only
 * @throws  java.nio.channels.ReadPendingException
 *          If a read operation is already in progress on this channel
 * @throws  java.nio.channels.NotYetConnectedException
 *          If this channel is not yet connected
 * @throws  java.nio.channels.ShutdownChannelGroupException
 *          If the channel group has terminated
 * @apiSince 26
 */

public abstract <A> void read(java.nio.ByteBuffer dst, long timeout, java.util.concurrent.TimeUnit unit, A attachment, java.nio.channels.CompletionHandler<java.lang.Integer,? super A> handler);

/**
 * @throws  java.lang.IllegalArgumentException        {@inheritDoc}
 * @throws  java.nio.channels.ReadPendingException            {@inheritDoc}
 * @throws  java.nio.channels.NotYetConnectedException
 *          If this channel is not yet connected
 * @throws  java.nio.channels.ShutdownChannelGroupException
 *          If the channel group has terminated
 * @apiSince 26
 */

public final <A> void read(java.nio.ByteBuffer dst, A attachment, java.nio.channels.CompletionHandler<java.lang.Integer,? super A> handler) { throw new RuntimeException("Stub!"); }

/**
 * @throws  java.lang.IllegalArgumentException        {@inheritDoc}
 * @throws  java.nio.channels.ReadPendingException            {@inheritDoc}
 * @throws  java.nio.channels.NotYetConnectedException
 *          If this channel is not yet connected
 * @apiSince 26
 */

public abstract java.util.concurrent.Future<java.lang.Integer> read(java.nio.ByteBuffer dst);

/**
 * Reads a sequence of bytes from this channel into a subsequence of the
 * given buffers. This operation, sometimes called a <em>scattering read</em>,
 * is often useful when implementing network protocols that group data into
 * segments consisting of one or more fixed-length headers followed by a
 * variable-length body. The {@code handler} parameter is a completion
 * handler that is invoked when the read operation completes (or fails). The
 * result passed to the completion handler is the number of bytes read or
 * {@code -1} if no bytes could be read because the channel has reached
 * end-of-stream.
 *
 * <p> This method initiates a read of up to <i>r</i> bytes from this channel,
 * where <i>r</i> is the total number of bytes remaining in the specified
 * subsequence of the given buffer array, that is,
 *
 * <blockquote><pre>
 * dsts[offset].remaining()
 *     + dsts[offset+1].remaining()
 *     + ... + dsts[offset+length-1].remaining()</pre></blockquote>
 *
 * at the moment that the read is attempted.
 *
 * <p> Suppose that a byte sequence of length <i>n</i> is read, where
 * <tt>0</tt>&nbsp;<tt>&lt;</tt>&nbsp;<i>n</i>&nbsp;<tt>&lt;=</tt>&nbsp;<i>r</i>.
 * Up to the first <tt>dsts[offset].remaining()</tt> bytes of this sequence
 * are transferred into buffer <tt>dsts[offset]</tt>, up to the next
 * <tt>dsts[offset+1].remaining()</tt> bytes are transferred into buffer
 * <tt>dsts[offset+1]</tt>, and so forth, until the entire byte sequence
 * is transferred into the given buffers.  As many bytes as possible are
 * transferred into each buffer, hence the final position of each updated
 * buffer, except the last updated buffer, is guaranteed to be equal to
 * that buffer's limit. The underlying operating system may impose a limit
 * on the number of buffers that may be used in an I/O operation. Where the
 * number of buffers (with bytes remaining), exceeds this limit, then the
 * I/O operation is performed with the maximum number of buffers allowed by
 * the operating system.
 *
 * <p> If a timeout is specified and the timeout elapses before the operation
 * completes then it completes with the exception {@link java.nio.channels.InterruptedByTimeoutException InterruptedByTimeoutException}. Where a timeout occurs, and the
 * implementation cannot guarantee that bytes have not been read, or will not
 * be read from the channel into the given buffers, then further attempts to
 * read from the channel will cause an unspecific runtime exception to be
 * thrown.
 *
 * @param   <A>
 *          The type of the attachment
 * @param   dsts
 *          The buffers into which bytes are to be transferred
 * @param   offset
 *          The offset within the buffer array of the first buffer into which
 *          bytes are to be transferred; must be non-negative and no larger than
 *          {@code dsts.length}
 * @param   length
 *          The maximum number of buffers to be accessed; must be non-negative
 *          and no larger than {@code dsts.length - offset}
 * @param   timeout
 *          The maximum time for the I/O operation to complete
 * @param   unit
 *          The time unit of the {@code timeout} argument
 * @param   attachment
 *          The object to attach to the I/O operation; can be {@code null}
 * @param   handler
 *          The handler for consuming the result
 *
 * @throws  java.lang.IndexOutOfBoundsException
 *          If the pre-conditions for the {@code offset}  and {@code length}
 *          parameter aren't met
 * @throws  java.lang.IllegalArgumentException
 *          If the buffer is read-only
 * @throws  java.nio.channels.ReadPendingException
 *          If a read operation is already in progress on this channel
 * @throws  java.nio.channels.NotYetConnectedException
 *          If this channel is not yet connected
 * @throws  java.nio.channels.ShutdownChannelGroupException
 *          If the channel group has terminated
 * @apiSince 26
 */

public abstract <A> void read(java.nio.ByteBuffer[] dsts, int offset, int length, long timeout, java.util.concurrent.TimeUnit unit, A attachment, java.nio.channels.CompletionHandler<java.lang.Long,? super A> handler);

/**
 * Writes a sequence of bytes to this channel from the given buffer.
 *
 * <p> This method initiates an asynchronous write operation to write a
 * sequence of bytes to this channel from the given buffer. The {@code
 * handler} parameter is a completion handler that is invoked when the write
 * operation completes (or fails). The result passed to the completion
 * handler is the number of bytes written.
 *
 * <p> If a timeout is specified and the timeout elapses before the operation
 * completes then it completes with the exception {@link java.nio.channels.InterruptedByTimeoutException InterruptedByTimeoutException}. Where a timeout occurs, and the
 * implementation cannot guarantee that bytes have not been written, or will
 * not be written to the channel from the given buffer, then further attempts
 * to write to the channel will cause an unspecific runtime exception to be
 * thrown.
 *
 * <p> Otherwise this method works in the same manner as the {@link java.nio.channels.AsynchronousByteChannel#write(java.nio.ByteBuffer,java.lang.Object,java.nio.channels.CompletionHandler) AsynchronousByteChannel#write(ByteBuffer,Object,CompletionHandler)}
 * method.
 *
 * @param   <A>
 *          The type of the attachment
 * @param   src
 *          The buffer from which bytes are to be retrieved
 * @param   timeout
 *          The maximum time for the I/O operation to complete
 * @param   unit
 *          The time unit of the {@code timeout} argument
 * @param   attachment
 *          The object to attach to the I/O operation; can be {@code null}
 * @param   handler
 *          The handler for consuming the result
 *
 * @throws  java.nio.channels.WritePendingException
 *          If a write operation is already in progress on this channel
 * @throws  java.nio.channels.NotYetConnectedException
 *          If this channel is not yet connected
 * @throws  java.nio.channels.ShutdownChannelGroupException
 *          If the channel group has terminated
 * @apiSince 26
 */

public abstract <A> void write(java.nio.ByteBuffer src, long timeout, java.util.concurrent.TimeUnit unit, A attachment, java.nio.channels.CompletionHandler<java.lang.Integer,? super A> handler);

/**
 * @throws  java.nio.channels.WritePendingException          {@inheritDoc}
 * @throws  java.nio.channels.NotYetConnectedException
 *          If this channel is not yet connected
 * @throws  java.nio.channels.ShutdownChannelGroupException
 *          If the channel group has terminated
 * @apiSince 26
 */

public final <A> void write(java.nio.ByteBuffer src, A attachment, java.nio.channels.CompletionHandler<java.lang.Integer,? super A> handler) { throw new RuntimeException("Stub!"); }

/**
 * @throws  java.nio.channels.WritePendingException       {@inheritDoc}
 * @throws  java.nio.channels.NotYetConnectedException
 *          If this channel is not yet connected
 * @apiSince 26
 */

public abstract java.util.concurrent.Future<java.lang.Integer> write(java.nio.ByteBuffer src);

/**
 * Writes a sequence of bytes to this channel from a subsequence of the given
 * buffers. This operation, sometimes called a <em>gathering write</em>, is
 * often useful when implementing network protocols that group data into
 * segments consisting of one or more fixed-length headers followed by a
 * variable-length body. The {@code handler} parameter is a completion
 * handler that is invoked when the write operation completes (or fails).
 * The result passed to the completion handler is the number of bytes written.
 *
 * <p> This method initiates a write of up to <i>r</i> bytes to this channel,
 * where <i>r</i> is the total number of bytes remaining in the specified
 * subsequence of the given buffer array, that is,
 *
 * <blockquote><pre>
 * srcs[offset].remaining()
 *     + srcs[offset+1].remaining()
 *     + ... + srcs[offset+length-1].remaining()</pre></blockquote>
 *
 * at the moment that the write is attempted.
 *
 * <p> Suppose that a byte sequence of length <i>n</i> is written, where
 * <tt>0</tt>&nbsp;<tt>&lt;</tt>&nbsp;<i>n</i>&nbsp;<tt>&lt;=</tt>&nbsp;<i>r</i>.
 * Up to the first <tt>srcs[offset].remaining()</tt> bytes of this sequence
 * are written from buffer <tt>srcs[offset]</tt>, up to the next
 * <tt>srcs[offset+1].remaining()</tt> bytes are written from buffer
 * <tt>srcs[offset+1]</tt>, and so forth, until the entire byte sequence is
 * written.  As many bytes as possible are written from each buffer, hence
 * the final position of each updated buffer, except the last updated
 * buffer, is guaranteed to be equal to that buffer's limit. The underlying
 * operating system may impose a limit on the number of buffers that may be
 * used in an I/O operation. Where the number of buffers (with bytes
 * remaining), exceeds this limit, then the I/O operation is performed with
 * the maximum number of buffers allowed by the operating system.
 *
 * <p> If a timeout is specified and the timeout elapses before the operation
 * completes then it completes with the exception {@link java.nio.channels.InterruptedByTimeoutException InterruptedByTimeoutException}. Where a timeout occurs, and the
 * implementation cannot guarantee that bytes have not been written, or will
 * not be written to the channel from the given buffers, then further attempts
 * to write to the channel will cause an unspecific runtime exception to be
 * thrown.
 *
 * @param   <A>
 *          The type of the attachment
 * @param   srcs
 *          The buffers from which bytes are to be retrieved
 * @param   offset
 *          The offset within the buffer array of the first buffer from which
 *          bytes are to be retrieved; must be non-negative and no larger
 *          than {@code srcs.length}
 * @param   length
 *          The maximum number of buffers to be accessed; must be non-negative
 *          and no larger than {@code srcs.length - offset}
 * @param   timeout
 *          The maximum time for the I/O operation to complete
 * @param   unit
 *          The time unit of the {@code timeout} argument
 * @param   attachment
 *          The object to attach to the I/O operation; can be {@code null}
 * @param   handler
 *          The handler for consuming the result
 *
 * @throws  java.lang.IndexOutOfBoundsException
 *          If the pre-conditions for the {@code offset}  and {@code length}
 *          parameter aren't met
 * @throws  java.nio.channels.WritePendingException
 *          If a write operation is already in progress on this channel
 * @throws  java.nio.channels.NotYetConnectedException
 *          If this channel is not yet connected
 * @throws  java.nio.channels.ShutdownChannelGroupException
 *          If the channel group has terminated
 * @apiSince 26
 */

public abstract <A> void write(java.nio.ByteBuffer[] srcs, int offset, int length, long timeout, java.util.concurrent.TimeUnit unit, A attachment, java.nio.channels.CompletionHandler<java.lang.Long,? super A> handler);

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
 * @apiSince 26
 */

public abstract java.net.SocketAddress getLocalAddress() throws java.io.IOException;
}

