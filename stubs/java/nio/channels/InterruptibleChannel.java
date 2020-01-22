/*
 * Copyright (c) 2001, Oracle and/or its affiliates. All rights reserved.
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

/*
 */



package java.nio.channels;

import java.io.IOException;

/**
 * A channel that can be asynchronously closed and interrupted.
 *
 * <p> A channel that implements this interface is <i>asynchronously
 * closeable:</i> If a thread is blocked in an I/O operation on an
 * interruptible channel then another thread may invoke the channel's {@link
 * #close close} method.  This will cause the blocked thread to receive an
 * {@link java.nio.channels.AsynchronousCloseException AsynchronousCloseException}.
 *
 * <p> A channel that implements this interface is also <i>interruptible:</i>
 * If a thread is blocked in an I/O operation on an interruptible channel then
 * another thread may invoke the blocked thread's {@link java.lang.Thread#interrupt() Thread#interrupt()} method.  This will cause the channel to be closed, the blocked
 * thread to receive a {@link java.nio.channels.ClosedByInterruptException ClosedByInterruptException}, and the blocked
 * thread's interrupt status to be set.
 *
 * <p> If a thread's interrupt status is already set and it invokes a blocking
 * I/O operation upon a channel then the channel will be closed and the thread
 * will immediately receive a {@link java.nio.channels.ClosedByInterruptException ClosedByInterruptException}; its interrupt
 * status will remain set.
 *
 * <p> A channel supports asynchronous closing and interruption if, and only
 * if, it implements this interface.  This can be tested at runtime, if
 * necessary, via the <tt>instanceof</tt> operator.
 *
 *
 * @author Mark Reinhold
 * @author JSR-51 Expert Group
 * @since 1.4
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface InterruptibleChannel extends java.nio.channels.Channel {

/**
 * Closes this channel.
 *
 * <p> Any thread currently blocked in an I/O operation upon this channel
 * will receive an {@link java.nio.channels.AsynchronousCloseException AsynchronousCloseException}.
 *
 * <p> This method otherwise behaves exactly as specified by the {@link java.nio.channels.Channel#close Channel#close} interface.  </p>
 *
 * @throws  java.io.IOException  If an I/O error occurs
 * @apiSince 1
 */

public void close() throws java.io.IOException;
}

