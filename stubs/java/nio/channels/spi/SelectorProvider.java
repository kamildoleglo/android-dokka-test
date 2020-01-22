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



package java.nio.channels.spi;

import java.nio.channels.*;
import java.io.IOException;

/**
 * Service-provider class for selectors and selectable channels.
 *
 * <p> A selector provider is a concrete subclass of this class that has a
 * zero-argument constructor and implements the abstract methods specified
 * below.  A given invocation of the Java virtual machine maintains a single
 * system-wide default provider instance, which is returned by the {@link
 * #provider() provider} method.  The first invocation of that method will locate
 * the default provider as specified below.
 *
 * <p> The system-wide default provider is used by the static <tt>open</tt>
 * methods of the {@link java.nio.channels.DatagramChannel#open
 * DatagramChannel}, {@link java.nio.channels.Pipe#open Pipe}, {@link
 * java.nio.channels.Selector#open Selector}, {@link
 * java.nio.channels.ServerSocketChannel#open ServerSocketChannel}, and {@link
 * java.nio.channels.SocketChannel#open SocketChannel} classes.  It is also
 * used by the {@link java.lang.System#inheritedChannel System.inheritedChannel()}
 * method. A program may make use of a provider other than the default provider
 * by instantiating that provider and then directly invoking the <tt>open</tt>
 * methods defined in this class.
 *
 * <p> All of the methods in this class are safe for use by multiple concurrent
 * threads.  </p>
 *
 *
 * @author Mark Reinhold
 * @author JSR-51 Expert Group
 * @since 1.4
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class SelectorProvider {

/**
 * Initializes a new instance of this class.
 *
 * @throws  java.lang.SecurityException
 *          If a security manager has been installed and it denies
 *          {@link java.lang.RuntimePermission RuntimePermission}<tt>("selectorProvider")</tt>
 * @apiSince 1
 */

protected SelectorProvider() { throw new RuntimeException("Stub!"); }

/**
 * Returns the system-wide default selector provider for this invocation of
 * the Java virtual machine.
 *
 * <p> The first invocation of this method locates the default provider
 * object as follows: </p>
 *
 * <ol>
 *
 *   <li><p> If the system property
 *   <tt>java.nio.channels.spi.SelectorProvider</tt> is defined then it is
 *   taken to be the fully-qualified name of a concrete provider class.
 *   The class is loaded and instantiated; if this process fails then an
 *   unspecified error is thrown.  </p></li>
 *
 *   <li><p> If a provider class has been installed in a jar file that is
 *   visible to the system class loader, and that jar file contains a
 *   provider-configuration file named
 *   <tt>java.nio.channels.spi.SelectorProvider</tt> in the resource
 *   directory <tt>META-INF/services</tt>, then the first class name
 *   specified in that file is taken.  The class is loaded and
 *   instantiated; if this process fails then an unspecified error is
 *   thrown.  </p></li>
 *
 *   <li><p> Finally, if no provider has been specified by any of the above
 *   means then the system-default provider class is instantiated and the
 *   result is returned.  </p></li>
 *
 * </ol>
 *
 * <p> Subsequent invocations of this method return the provider that was
 * returned by the first invocation.  </p>
 *
 * @return  The system-wide default selector provider
 * @apiSince 1
 */

public static java.nio.channels.spi.SelectorProvider provider() { throw new RuntimeException("Stub!"); }

/**
 * Opens a datagram channel.
 *
 * @return  The new channel
 *
 * @throws  java.io.IOException
 *          If an I/O error occurs
 * @apiSince 1
 */

public abstract java.nio.channels.DatagramChannel openDatagramChannel() throws java.io.IOException;

/**
 * Opens a datagram channel.
 *
 * @param   family
 *          The protocol family
 *
 * @return  A new datagram channel
 *
 * @throws  java.lang.UnsupportedOperationException
 *          If the specified protocol family is not supported
 * @throws  java.io.IOException
 *          If an I/O error occurs
 *
 * @since 1.7
 * @apiSince 24
 */

public abstract java.nio.channels.DatagramChannel openDatagramChannel(java.net.ProtocolFamily family) throws java.io.IOException;

/**
 * Opens a pipe.
 *
 * @return  The new pipe
 *
 * @throws  java.io.IOException
 *          If an I/O error occurs
 * @apiSince 1
 */

public abstract java.nio.channels.Pipe openPipe() throws java.io.IOException;

/**
 * Opens a selector.
 *
 * @return  The new selector
 *
 * @throws  java.io.IOException
 *          If an I/O error occurs
 * @apiSince 1
 */

public abstract java.nio.channels.spi.AbstractSelector openSelector() throws java.io.IOException;

/**
 * Opens a server-socket channel.
 *
 * @return  The new channel
 *
 * @throws  java.io.IOException
 *          If an I/O error occurs
 * @apiSince 1
 */

public abstract java.nio.channels.ServerSocketChannel openServerSocketChannel() throws java.io.IOException;

/**
 * Opens a socket channel.
 *
 * @return  The new channel
 *
 * @throws  java.io.IOException
 *          If an I/O error occurs
 * @apiSince 1
 */

public abstract java.nio.channels.SocketChannel openSocketChannel() throws java.io.IOException;

/**
 * Returns the channel inherited from the entity that created this
 * Java virtual machine.
 *
 * <p> On many operating systems a process, such as a Java virtual
 * machine, can be started in a manner that allows the process to
 * inherit a channel from the entity that created the process. The
 * manner in which this is done is system dependent, as are the
 * possible entities to which the channel may be connected. For example,
 * on UNIX systems, the Internet services daemon (<i>inetd</i>) is used to
 * start programs to service requests when a request arrives on an
 * associated network port. In this example, the process that is started,
 * inherits a channel representing a network socket.
 *
 * <p> In cases where the inherited channel represents a network socket
 * then the {@link java.nio.channels.Channel Channel} type returned
 * by this method is determined as follows:
 *
 * <ul>
 *
 *  <li><p> If the inherited channel represents a stream-oriented connected
 *  socket then a {@link java.nio.channels.SocketChannel SocketChannel} is
 *  returned. The socket channel is, at least initially, in blocking
 *  mode, bound to a socket address, and connected to a peer.
 *  </p></li>
 *
 *  <li><p> If the inherited channel represents a stream-oriented listening
 *  socket then a {@link java.nio.channels.ServerSocketChannel
 *  ServerSocketChannel} is returned. The server-socket channel is, at
 *  least initially, in blocking mode, and bound to a socket address.
 *  </p></li>
 *
 *  <li><p> If the inherited channel is a datagram-oriented socket
 *  then a {@link java.nio.channels.DatagramChannel DatagramChannel} is
 *  returned. The datagram channel is, at least initially, in blocking
 *  mode, and bound to a socket address.
 *  </p></li>
 *
 * </ul>
 *
 * <p> In addition to the network-oriented channels described, this method
 * may return other kinds of channels in the future.
 *
 * <p> The first invocation of this method creates the channel that is
 * returned. Subsequent invocations of this method return the same
 * channel. </p>
 *
 * @return  The inherited channel, if any, otherwise <tt>null</tt>.
 *
 * @throws  java.io.IOException
 *          If an I/O error occurs
 *
 * @throws  java.lang.SecurityException
 *          If a security manager has been installed and it denies
 *          {@link java.lang.RuntimePermission RuntimePermission}<tt>("inheritedChannel")</tt>
 *
 * @since 1.5
 * @apiSince 1
 */

public java.nio.channels.Channel inheritedChannel() throws java.io.IOException { throw new RuntimeException("Stub!"); }
}

