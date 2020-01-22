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

import java.io.IOException;
import java.nio.channels.Selector;

/**
 * Base implementation class for selectors.
 *
 * <p> This class encapsulates the low-level machinery required to implement
 * the interruption of selection operations.  A concrete selector class must
 * invoke the {@link #begin begin} and {@link #end end} methods before and
 * after, respectively, invoking an I/O operation that might block
 * indefinitely.  In order to ensure that the {@link #end end} method is always
 * invoked, these methods should be used within a
 * <tt>try</tt>&nbsp;...&nbsp;<tt>finally</tt> block:
 *
 * <blockquote><pre>
 * try {
 *     begin();
 *     // Perform blocking I/O operation here
 *     ...
 * } finally {
 *     end();
 * }</pre></blockquote>
 *
 * <p> This class also defines methods for maintaining a selector's
 * cancelled-key set and for removing a key from its channel's key set, and
 * declares the abstract {@link #register register} method that is invoked by a
 * selectable channel's {@link java.nio.channels.spi.AbstractSelectableChannel#register AbstractSelectableChannel#register}
 * method in order to perform the actual work of registering a channel.  </p>
 *
 *
 * @author Mark Reinhold
 * @author JSR-51 Expert Group
 * @since 1.4
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class AbstractSelector extends java.nio.channels.Selector {

/**
 * Initializes a new instance of this class.
 *
 * @param  provider
 *         The provider that created this selector
 * @apiSince 1
 */

protected AbstractSelector(java.nio.channels.spi.SelectorProvider provider) { throw new RuntimeException("Stub!"); }

/**
 * Closes this selector.
 *
 * <p> If the selector has already been closed then this method returns
 * immediately.  Otherwise it marks the selector as closed and then invokes
 * the {@link #implCloseSelector implCloseSelector} method in order to
 * complete the close operation.  </p>
 *
 * @throws  java.io.IOException
 *          If an I/O error occurs
 * @apiSince 1
 */

public final void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Closes this selector.
 *
 * <p> This method is invoked by the {@link #close close} method in order
 * to perform the actual work of closing the selector.  This method is only
 * invoked if the selector has not yet been closed, and it is never invoked
 * more than once.
 *
 * <p> An implementation of this method must arrange for any other thread
 * that is blocked in a selection operation upon this selector to return
 * immediately as if by invoking the {@link
 * java.nio.channels.Selector#wakeup wakeup} method. </p>
 *
 * @throws  java.io.IOException
 *          If an I/O error occurs while closing the selector
 * @apiSince 1
 */

protected abstract void implCloseSelector() throws java.io.IOException;

/** @apiSince 1 */

public final boolean isOpen() { throw new RuntimeException("Stub!"); }

/**
 * Returns the provider that created this channel.
 *
 * @return  The provider that created this channel
 * @apiSince 1
 */

public final java.nio.channels.spi.SelectorProvider provider() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves this selector's cancelled-key set.
 *
 * <p> This set should only be used while synchronized upon it.  </p>
 *
 * @return  The cancelled-key set
 * @apiSince 1
 */

protected final java.util.Set<java.nio.channels.SelectionKey> cancelledKeys() { throw new RuntimeException("Stub!"); }

/**
 * Registers the given channel with this selector.
 *
 * <p> This method is invoked by a channel's {@link java.nio.channels.spi.AbstractSelectableChannel#register AbstractSelectableChannel#register} method in order to perform
 * the actual work of registering the channel with this selector.  </p>
 *
 * @param  ch
 *         The channel to be registered
 *
 * @param  ops
 *         The initial interest set, which must be valid
 *
 * @param  att
 *         The initial attachment for the resulting key
 *
 * @return  A new key representing the registration of the given channel
 *          with this selector
 * @apiSince 1
 */

protected abstract java.nio.channels.SelectionKey register(java.nio.channels.spi.AbstractSelectableChannel ch, int ops, java.lang.Object att);

/**
 * Removes the given key from its channel's key set.
 *
 * <p> This method must be invoked by the selector for each channel that it
 * deregisters.  </p>
 *
 * @param  key
 *         The selection key to be removed
 * @apiSince 1
 */

protected final void deregister(java.nio.channels.spi.AbstractSelectionKey key) { throw new RuntimeException("Stub!"); }

/**
 * Marks the beginning of an I/O operation that might block indefinitely.
 *
 * <p> This method should be invoked in tandem with the {@link #end end}
 * method, using a <tt>try</tt>&nbsp;...&nbsp;<tt>finally</tt> block as
 * shown <a href="#be">above</a>, in order to implement interruption for
 * this selector.
 *
 * <p> Invoking this method arranges for the selector's {@link java.nio.channels.Selector#wakeup Selector#wakeup} method to be invoked if a thread's {@link java.lang.Thread#interrupt Thread#interrupt} method is invoked while the thread is
 * blocked in an I/O operation upon the selector.  </p>
 * @apiSince 1
 */

protected final void begin() { throw new RuntimeException("Stub!"); }

/**
 * Marks the end of an I/O operation that might block indefinitely.
 *
 * <p> This method should be invoked in tandem with the {@link #begin begin}
 * method, using a <tt>try</tt>&nbsp;...&nbsp;<tt>finally</tt> block as
 * shown <a href="#be">above</a>, in order to implement interruption for
 * this selector.  </p>
 * @apiSince 1
 */

protected final void end() { throw new RuntimeException("Stub!"); }
}

