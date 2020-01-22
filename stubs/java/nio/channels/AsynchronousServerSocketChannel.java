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
import java.net.SocketAddress;
import java.io.IOException;
import java.util.concurrent.Future;

/**
 * An asynchronous channel for stream-oriented listening sockets.
 *
 * <p> An asynchronous server-socket channel is created by invoking the
 * {@link #open open} method of this class.
 * A newly-created asynchronous server-socket channel is open but not yet bound.
 * It can be bound to a local address and configured to listen for connections
 * by invoking the {@link #bind(java.net.SocketAddress,int) bind} method. Once bound,
 * the {@link #accept(java.lang.Object,java.nio.channels.CompletionHandler) accept} method
 * is used to initiate the accepting of connections to the channel's socket.
 * An attempt to invoke the <tt>accept</tt> method on an unbound channel will
 * cause a {@link java.nio.channels.NotYetBoundException NotYetBoundException} to be thrown.
 *
 * <p> Channels of this type are safe for use by multiple concurrent threads
 * though at most one accept operation can be outstanding at any time.
 * If a thread initiates an accept operation before a previous accept operation
 * has completed then an {@link java.nio.channels.AcceptPendingException AcceptPendingException} will be thrown.
 *
 * <p> Socket options are configured using the {@link #setOption(java.net.SocketOption,java.lang.Object)
 * setOption} method. Channels of this type support the following options:
 * <blockquote>
 * <table border summary="Socket options">
 *   <tr>
 *     <th>Option Name</th>
 *     <th>Description</th>
 *   </tr>
 *   <tr>
 *     <td> {@link java.net.StandardSocketOptions#SO_RCVBUF SO_RCVBUF} </td>
 *     <td> The size of the socket receive buffer </td>
 *   </tr>
 *   <tr>
 *     <td> {@link java.net.StandardSocketOptions#SO_REUSEADDR SO_REUSEADDR} </td>
 *     <td> Re-use address </td>
 *   </tr>
 * </table>
 * </blockquote>
 * Additional (implementation specific) options may also be supported.
 *
 * <p> <b>Usage Example:</b>
 * <pre>
 *  final AsynchronousServerSocketChannel listener =
 *      AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(5000));
 *
 *  listener.accept(null, new CompletionHandler&lt;AsynchronousSocketChannel,Void&gt;() {
 *      public void completed(AsynchronousSocketChannel ch, Void att) {
 *          // accept the next connection
 *          listener.accept(null, this);
 *
 *          // handle this connection
 *          handle(ch);
 *      }
 *      public void failed(Throwable exc, Void att) {
 *          ...
 *      }
 *  });
 * </pre>
 *
 * @since 1.7
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class AsynchronousServerSocketChannel implements java.nio.channels.AsynchronousChannel, java.nio.channels.NetworkChannel {

/**
 * Initializes a new instance of this class.
 *
 * @param  provider
 *         The provider that created this channel
 * @apiSince 26
 */

protected AsynchronousServerSocketChannel(java.nio.channels.spi.AsynchronousChannelProvider provider) { throw new RuntimeException("Stub!"); }

/**
 * Returns the provider that created this channel.
 *
 * @return  The provider that created this channel
 * @apiSince 26
 */

public final java.nio.channels.spi.AsynchronousChannelProvider provider() { throw new RuntimeException("Stub!"); }

/**
 * Opens an asynchronous server-socket channel.
 *
 * <p> The new channel is created by invoking the {@link
 * java.nio.channels.spi.AsynchronousChannelProvider#openAsynchronousServerSocketChannel
 * openAsynchronousServerSocketChannel} method on the {@link
 * java.nio.channels.spi.AsynchronousChannelProvider} object that created
 * the given group. If the group parameter is <tt>null</tt> then the
 * resulting channel is created by the system-wide default provider, and
 * bound to the <em>default group</em>.
 *
 * @param   group
 *          The group to which the newly constructed channel should be bound,
 *          or <tt>null</tt> for the default group
 *
 * @return  A new asynchronous server socket channel
 *
 * @throws  java.nio.channels.ShutdownChannelGroupException
 *          If the channel group is shutdown
 * @throws  java.io.IOException
 *          If an I/O error occurs
 * @apiSince 26
 */

public static java.nio.channels.AsynchronousServerSocketChannel open(java.nio.channels.AsynchronousChannelGroup group) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Opens an asynchronous server-socket channel.
 *
 * <p> This method returns an asynchronous server socket channel that is
 * bound to the <em>default group</em>. This method is equivalent to evaluating
 * the expression:
 * <blockquote><pre>
 * open((AsynchronousChannelGroup)null);
 * </pre></blockquote>
 *
 * @return  A new asynchronous server socket channel
 *
 * @throws  java.io.IOException
 *          If an I/O error occurs
 * @apiSince 26
 */

public static java.nio.channels.AsynchronousServerSocketChannel open() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Binds the channel's socket to a local address and configures the socket to
 * listen for connections.
 *
 * <p> An invocation of this method is equivalent to the following:
 * <blockquote><pre>
 * bind(local, 0);
 * </pre></blockquote>
 *
 * @param   local
 *          The local address to bind the socket, or <tt>null</tt> to bind
 *          to an automatically assigned socket address
 *
 * @return  This channel
 *
 * @throws  java.nio.channels.AlreadyBoundException               {@inheritDoc}
 * @throws  java.nio.channels.UnsupportedAddressTypeException     {@inheritDoc}
 * @throws  java.lang.SecurityException                   {@inheritDoc}
 * @throws  java.nio.channels.ClosedChannelException              {@inheritDoc}
 * @throws  java.io.IOException                         {@inheritDoc}
 * @apiSince 26
 */

public final java.nio.channels.AsynchronousServerSocketChannel bind(java.net.SocketAddress local) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Binds the channel's socket to a local address and configures the socket to
 * listen for connections.
 *
 * <p> This method is used to establish an association between the socket and
 * a local address. Once an association is established then the socket remains
 * bound until the associated channel is closed.
 *
 * <p> The {@code backlog} parameter is the maximum number of pending
 * connections on the socket. Its exact semantics are implementation specific.
 * In particular, an implementation may impose a maximum length or may choose
 * to ignore the parameter altogther. If the {@code backlog} parameter has
 * the value {@code 0}, or a negative value, then an implementation specific
 * default is used.
 *
 * @param   local
 *          The local address to bind the socket, or {@code null} to bind
 *          to an automatically assigned socket address
 * @param   backlog
 *          The maximum number of pending connections
 *
 * @return  This channel
 *
 * @throws  java.nio.channels.AlreadyBoundException
 *          If the socket is already bound
 * @throws  java.nio.channels.UnsupportedAddressTypeException
 *          If the type of the given address is not supported
 * @throws  java.lang.SecurityException
 *          If a security manager has been installed and its {@link java.lang.SecurityManager#checkListen SecurityManager#checkListen} method denies the operation
 * @throws  java.nio.channels.ClosedChannelException
 *          If the channel is closed
 * @throws  java.io.IOException
 *          If some other I/O error occurs
 * @apiSince 26
 */

public abstract java.nio.channels.AsynchronousServerSocketChannel bind(java.net.SocketAddress local, int backlog) throws java.io.IOException;

/**
 * @throws  java.lang.IllegalArgumentException                {@inheritDoc}
 * @throws  java.nio.channels.ClosedChannelException                  {@inheritDoc}
 * @throws  java.io.IOException                             {@inheritDoc}
 * @apiSince 26
 */

public abstract <T> java.nio.channels.AsynchronousServerSocketChannel setOption(java.net.SocketOption<T> name, T value) throws java.io.IOException;

/**
 * Accepts a connection.
 *
 * <p> This method initiates an asynchronous operation to accept a
 * connection made to this channel's socket. The {@code handler} parameter is
 * a completion handler that is invoked when a connection is accepted (or
 * the operation fails). The result passed to the completion handler is
 * the {@link java.nio.channels.AsynchronousSocketChannel AsynchronousSocketChannel} to the new connection.
 *
 * <p> When a new connection is accepted then the resulting {@code
 * AsynchronousSocketChannel} will be bound to the same {@link java.nio.channels.AsynchronousChannelGroup AsynchronousChannelGroup} as this channel. If the group is {@link java.nio.channels.AsynchronousChannelGroup#isShutdown AsynchronousChannelGroup#isShutdown} and a connection is accepted,
 * then the connection is closed, and the operation completes with an {@code
 * IOException} and cause {@link java.nio.channels.ShutdownChannelGroupException ShutdownChannelGroupException}.
 *
 * <p> To allow for concurrent handling of new connections, the completion
 * handler is not invoked directly by the initiating thread when a new
 * connection is accepted immediately (see <a
 * href="AsynchronousChannelGroup.html#threading">Threading</a>).
 *
 * <p> If a security manager has been installed then it verifies that the
 * address and port number of the connection's remote endpoint are permitted
 * by the security manager's {@link java.lang.SecurityManager#checkAccept SecurityManager#checkAccept}
 * method. The permission check is performed with privileges that are restricted
 * by the calling context of this method. If the permission check fails then
 * the connection is closed and the operation completes with a {@link java.lang.SecurityException SecurityException}.
 *
 * @param   <A>
 *          The type of the attachment
 * @param   attachment
 *          The object to attach to the I/O operation; can be {@code null}
 * @param   handler
 *          The handler for consuming the result
 *
 * @throws  java.nio.channels.AcceptPendingException
 *          If an accept operation is already in progress on this channel
 * @throws  java.nio.channels.NotYetBoundException
 *          If this channel's socket has not yet been bound
 * @throws  java.nio.channels.ShutdownChannelGroupException
 *          If the channel group has terminated
 * @apiSince 26
 */

public abstract <A> void accept(A attachment, java.nio.channels.CompletionHandler<java.nio.channels.AsynchronousSocketChannel,? super A> handler);

/**
 * Accepts a connection.
 *
 * <p> This method initiates an asynchronous operation to accept a
 * connection made to this channel's socket. The method behaves in exactly
 * the same manner as the {@link #accept(java.lang.Object,java.nio.channels.CompletionHandler)} method
 * except that instead of specifying a completion handler, this method
 * returns a {@code Future} representing the pending result. The {@code
 * Future}'s {@link java.util.concurrent.Future#get() Future#get()} method returns the {@link java.nio.channels.AsynchronousSocketChannel AsynchronousSocketChannel} to the new connection on successful completion.
 *
 * @return  a {@code Future} object representing the pending result
 *
 * @throws  java.nio.channels.AcceptPendingException
 *          If an accept operation is already in progress on this channel
 * @throws  java.nio.channels.NotYetBoundException
 *          If this channel's socket has not yet been bound
 * @apiSince 26
 */

public abstract java.util.concurrent.Future<java.nio.channels.AsynchronousSocketChannel> accept();

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

