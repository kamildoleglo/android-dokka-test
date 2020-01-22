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



package java.nio.channels.spi;

import java.nio.channels.*;
import java.util.concurrent.*;
import java.io.IOException;

/**
 * Service-provider class for asynchronous channels.
 *
 * <p> An asynchronous channel provider is a concrete subclass of this class that
 * has a zero-argument constructor and implements the abstract methods specified
 * below.  A given invocation of the Java virtual machine maintains a single
 * system-wide default provider instance, which is returned by the {@link
 * #provider() provider} method.  The first invocation of that method will locate
 * the default provider as specified below.
 *
 * <p> All of the methods in this class are safe for use by multiple concurrent
 * threads.  </p>
 *
 * @since 1.7
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class AsynchronousChannelProvider {

/**
 * Initializes a new instance of this class.
 *
 * @throws  java.lang.SecurityException
 *          If a security manager has been installed and it denies
 *          {@link java.lang.RuntimePermission RuntimePermission}<tt>("asynchronousChannelProvider")</tt>
 * @apiSince 26
 */

protected AsynchronousChannelProvider() { throw new RuntimeException("Stub!"); }

/**
 * Returns the system-wide default asynchronous channel provider for this
 * invocation of the Java virtual machine.
 *
 * <p> The first invocation of this method locates the default provider
 * object as follows: </p>
 *
 * <ol>
 *
 *   <li><p> If the system property
 *   <tt>java.nio.channels.spi.AsynchronousChannelProvider</tt> is defined
 *   then it is taken to be the fully-qualified name of a concrete provider class.
 *   The class is loaded and instantiated; if this process fails then an
 *   unspecified error is thrown.  </p></li>
 *
 *   <li><p> If a provider class has been installed in a jar file that is
 *   visible to the system class loader, and that jar file contains a
 *   provider-configuration file named
 *   <tt>java.nio.channels.spi.AsynchronousChannelProvider</tt> in the resource
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
 * @return  The system-wide default AsynchronousChannel provider
 * @apiSince 26
 */

public static java.nio.channels.spi.AsynchronousChannelProvider provider() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new asynchronous channel group with a fixed thread pool.
 *
 * @param   nThreads
 *          The number of threads in the pool
 * @param   threadFactory
 *          The factory to use when creating new threads
 *
 * @return  A new asynchronous channel group
 *
 * @throws  java.lang.IllegalArgumentException
 *          If {@code nThreads <= 0}
 * @throws  java.io.IOException
 *          If an I/O error occurs
 *
 * @see java.nio.channels.AsynchronousChannelGroup#withFixedThreadPool
 * @apiSince 26
 */

public abstract java.nio.channels.AsynchronousChannelGroup openAsynchronousChannelGroup(int nThreads, java.util.concurrent.ThreadFactory threadFactory) throws java.io.IOException;

/**
 * Constructs a new asynchronous channel group with the given thread pool.
 *
 * @param   executor
 *          The thread pool
 * @param   initialSize
 *          A value {@code >=0} or a negative value for implementation
 *          specific default
 *
 * @return  A new asynchronous channel group
 *
 * @throws  java.io.IOException
 *          If an I/O error occurs
 *
 * @see java.nio.channels.AsynchronousChannelGroup#withCachedThreadPool
 * @apiSince 26
 */

public abstract java.nio.channels.AsynchronousChannelGroup openAsynchronousChannelGroup(java.util.concurrent.ExecutorService executor, int initialSize) throws java.io.IOException;

/**
 * Opens an asynchronous server-socket channel.
 *
 * @param   group
 *          The group to which the channel is bound, or {@code null} to
 *          bind to the default group
 *
 * @return  The new channel
 *
 * @throws  java.nio.channels.IllegalChannelGroupException
 *          If the provider that created the group differs from this provider
 * @throws  java.nio.channels.ShutdownChannelGroupException
 *          The group is shutdown
 * @throws  java.io.IOException
 *          If an I/O error occurs
 * @apiSince 26
 */

public abstract java.nio.channels.AsynchronousServerSocketChannel openAsynchronousServerSocketChannel(java.nio.channels.AsynchronousChannelGroup group) throws java.io.IOException;

/**
 * Opens an asynchronous socket channel.
 *
 * @param   group
 *          The group to which the channel is bound, or {@code null} to
 *          bind to the default group
 *
 * @return  The new channel
 *
 * @throws  java.nio.channels.IllegalChannelGroupException
 *          If the provider that created the group differs from this provider
 * @throws  java.nio.channels.ShutdownChannelGroupException
 *          The group is shutdown
 * @throws  java.io.IOException
 *          If an I/O error occurs
 * @apiSince 26
 */

public abstract java.nio.channels.AsynchronousSocketChannel openAsynchronousSocketChannel(java.nio.channels.AsynchronousChannelGroup group) throws java.io.IOException;
}

