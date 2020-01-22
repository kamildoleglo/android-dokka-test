/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1997, 2005, Oracle and/or its affiliates. All rights reserved.
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



package java.lang.ref;


/**
 * Reference queues, to which registered reference objects are appended by the
 * garbage collector after the appropriate reachability changes are detected.
 *
 * @author   Mark Reinhold
 * @since    1.2
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ReferenceQueue<T> {

/**
 * Constructs a new reference-object queue.
 * @apiSince 1
 */

public ReferenceQueue() { throw new RuntimeException("Stub!"); }

/**
 * Polls this queue to see if a reference object is available.  If one is
 * available without further delay then it is removed from the queue and
 * returned.  Otherwise this method immediately returns <tt>null</tt>.
 *
 * @return  A reference object, if one was immediately available,
 *          otherwise <code>null</code>
 * @apiSince 1
 */

public java.lang.ref.Reference<? extends T> poll() { throw new RuntimeException("Stub!"); }

/**
 * Removes the next reference object in this queue, blocking until either
 * one becomes available or the given timeout period expires.
 *
 * <p> This method does not offer real-time guarantees: It schedules the
 * timeout as if by invoking the {@link java.lang.Object#wait(long) Object#wait(long)} method.
 *
 * @param  timeout  If positive, block for up to <code>timeout</code>
 *                  milliseconds while waiting for a reference to be
 *                  added to this queue.  If zero, block indefinitely.
 *
 * @return  A reference object, if one was available within the specified
 *          timeout period, otherwise <code>null</code>
 *
 * @throws  java.lang.IllegalArgumentException
 *          If the value of the timeout argument is negative
 *
 * @throws  java.lang.InterruptedException
 *          If the timeout wait is interrupted
 * @apiSince 1
 */

public java.lang.ref.Reference<? extends T> remove(long timeout) throws java.lang.IllegalArgumentException, java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * Removes the next reference object in this queue, blocking until one
 * becomes available.
 *
 * @return A reference object, blocking until one becomes available
 * @throws  java.lang.InterruptedException  If the wait is interrupted
 * @apiSince 1
 */

public java.lang.ref.Reference<? extends T> remove() throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }
}

