/*
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
 * This file is available under and governed by the GNU General Public
 * License version 2 only, as published by the Free Software Foundation.
 * However, the following notice accompanied the original version of this
 * file:
 *
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 */



package java.util.concurrent;


/**
 * A {@link java.util.concurrent.ScheduledFuture ScheduledFuture} that is {@link java.lang.Runnable Runnable}. Successful
 * execution of the {@code run} method causes completion of the
 * {@code Future} and allows access to its results.
 * @see java.util.concurrent.FutureTask
 * @see java.util.concurrent.Executor
 * @since 1.6
 * @author Doug Lea
 * @param <V> The result type returned by this Future's {@code get} method
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface RunnableScheduledFuture<V> extends java.util.concurrent.RunnableFuture<V>,  java.util.concurrent.ScheduledFuture<V> {

/**
 * Returns {@code true} if this task is periodic. A periodic task may
 * re-run according to some schedule. A non-periodic task can be
 * run only once.
 *
 * @return {@code true} if this task is periodic
 * @apiSince 9
 */

public boolean isPeriodic();
}

