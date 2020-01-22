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

import java.net.SocketOption;
import java.net.SocketAddress;
import java.io.IOException;

/**
 * A channel to a network socket.
 *
 * <p> A channel that implements this interface is a channel to a network
 * socket. The {@link #bind(java.net.SocketAddress) bind} method is used to bind the
 * socket to a local {@link java.net.SocketAddress SocketAddress}, the {@link #getLocalAddress()
 * getLocalAddress} method returns the address that the socket is bound to, and
 * the {@link #setOption(java.net.SocketOption,java.lang.Object) setOption} and {@link
 * #getOption(java.net.SocketOption) getOption} methods are used to set and query socket
 * options.  An implementation of this interface should specify the socket options
 * that it supports.
 *
 * <p> The {@link #bind bind} and {@link #setOption setOption} methods that do
 * not otherwise have a value to return are specified to return the network
 * channel upon which they are invoked. This allows method invocations to be
 * chained. Implementations of this interface should specialize the return type
 * so that method invocations on the implementation class can be chained.
 *
 * @since 1.7
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface NetworkChannel extends java.nio.channels.Channel {

/**
 * Binds the channel's socket to a local address.
 *
 * <p> This method is used to establish an association between the socket and
 * a local address. Once an association is established then the socket remains
 * bound until the channel is closed. If the {@code local} parameter has the
 * value {@code null} then the socket will be bound to an address that is
 * assigned automatically.
 *
 * @param   local
 *          The address to bind the socket, or {@code null} to bind the socket
 *          to an automatically assigned socket address
 *
 * @return  This channel
 *
 * @throws  java.nio.channels.AlreadyBoundException
 *          If the socket is already bound
 * @throws  java.nio.channels.UnsupportedAddressTypeException
 *          If the type of the given address is not supported
 * @throws  java.nio.channels.ClosedChannelException
 *          If the channel is closed
 * @throws  java.io.IOException
 *          If some other I/O error occurs
 * @throws  java.lang.SecurityException
 *          If a security manager is installed and it denies an unspecified
 *          permission. An implementation of this interface should specify
 *          any required permissions.
 *
 * @see #getLocalAddress
 * @apiSince 24
 */

public java.nio.channels.NetworkChannel bind(java.net.SocketAddress local) throws java.io.IOException;

/**
 * Returns the socket address that this channel's socket is bound to.
 *
 * <p> Where the channel is {@link #bind bound} to an Internet Protocol
 * socket address then the return value from this method is of type {@link
 * java.net.InetSocketAddress}.
 *
 * @return  The socket address that the socket is bound to, or {@code null}
 *          if the channel's socket is not bound
 *
 * @throws  java.nio.channels.ClosedChannelException
 *          If the channel is closed
 * @throws  java.io.IOException
 *          If an I/O error occurs
 * @apiSince 24
 */

public java.net.SocketAddress getLocalAddress() throws java.io.IOException;

/**
 * Sets the value of a socket option.
 *
 * @param   <T>
 *          The type of the socket option value
 * @param   name
 *          The socket option
 * @param   value
 *          The value of the socket option. A value of {@code null} may be
 *          a valid value for some socket options.
 *
 * @return  This channel
 *
 * @throws  java.lang.UnsupportedOperationException
 *          If the socket option is not supported by this channel
 * @throws  java.lang.IllegalArgumentException
 *          If the value is not a valid value for this socket option
 * @throws  java.nio.channels.ClosedChannelException
 *          If this channel is closed
 * @throws  java.io.IOException
 *          If an I/O error occurs
 *
 * @see java.net.StandardSocketOptions
 * @apiSince 24
 */

public <T> java.nio.channels.NetworkChannel setOption(java.net.SocketOption<T> name, T value) throws java.io.IOException;

/**
 * Returns the value of a socket option.
 *
 * @param   <T>
 *          The type of the socket option value
 * @param   name
 *          The socket option
 *
 * @return  The value of the socket option. A value of {@code null} may be
 *          a valid value for some socket options.
 *
 * @throws  java.lang.UnsupportedOperationException
 *          If the socket option is not supported by this channel
 * @throws  java.nio.channels.ClosedChannelException
 *          If this channel is closed
 * @throws  java.io.IOException
 *          If an I/O error occurs
 *
 * @see java.net.StandardSocketOptions
 * @apiSince 24
 */

public <T> T getOption(java.net.SocketOption<T> name) throws java.io.IOException;

/**
 * Returns a set of the socket options supported by this channel.
 *
 * <p> This method will continue to return the set of options even after the
 * channel has been closed.
 *
 * @return  A set of the socket options supported by this channel
 * @apiSince 24
 */

public java.util.Set<java.net.SocketOption<?>> supportedOptions();
}

