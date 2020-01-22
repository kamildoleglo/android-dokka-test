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
 * A cancellable asynchronous computation.  This class provides a base
 * implementation of {@link java.util.concurrent.Future Future}, with methods to start and cancel
 * a computation, query to see if the computation is complete, and
 * retrieve the result of the computation.  The result can only be
 * retrieved when the computation has completed; the {@code get}
 * methods will block if the computation has not yet completed.  Once
 * the computation has completed, the computation cannot be restarted
 * or cancelled (unless the computation is invoked using
 * {@link #runAndReset}).
 *
 * <p>A {@code FutureTask} can be used to wrap a {@link java.util.concurrent.Callable Callable} or
 * {@link java.lang.Runnable Runnable} object.  Because {@code FutureTask} implements
 * {@code Runnable}, a {@code FutureTask} can be submitted to an
 * {@link java.util.concurrent.Executor Executor} for execution.
 *
 * <p>In addition to serving as a standalone class, this class provides
 * {@code protected} functionality that may be useful when creating
 * customized task classes.
 *
 * @since 1.5
 * @author Doug Lea
 * @param <V> The result type returned by this FutureTask's {@code get} methods
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class FutureTask<V> implements java.util.concurrent.RunnableFuture<V> {

/**
 * Creates a {@code FutureTask} that will, upon running, execute the
 * given {@code Callable}.
 *
 * @param  callable the callable task
 * @throws java.lang.NullPointerException if the callable is null
 * @apiSince 1
 */

public FutureTask(java.util.concurrent.Callable<V> callable) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code FutureTask} that will, upon running, execute the
 * given {@code Runnable}, and arrange that {@code get} will return the
 * given result on successful completion.
 *
 * @param runnable the runnable task
 * @param result the result to return on successful completion. If
 * you don't need a particular result, consider using
 * constructions of the form:
 * {@code Future<?> f = new FutureTask<Void>(runnable, null)}
 * @throws java.lang.NullPointerException if the runnable is null
 * @apiSince 1
 */

public FutureTask(java.lang.Runnable runnable, V result) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean isCancelled() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean isDone() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean cancel(boolean mayInterruptIfRunning) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.util.concurrent.CancellationException {@inheritDoc}
 * @apiSince 1
 */

public V get() throws java.util.concurrent.ExecutionException, java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * @throws java.util.concurrent.CancellationException {@inheritDoc}
 * @apiSince 1
 */

public V get(long timeout, java.util.concurrent.TimeUnit unit) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException, java.util.concurrent.TimeoutException { throw new RuntimeException("Stub!"); }

/**
 * Protected method invoked when this task transitions to state
 * {@code isDone} (whether normally or via cancellation). The
 * default implementation does nothing.  Subclasses may override
 * this method to invoke completion callbacks or perform
 * bookkeeping. Note that you can query status inside the
 * implementation of this method to determine whether this task
 * has been cancelled.
 * @apiSince 1
 */

protected void done() { throw new RuntimeException("Stub!"); }

/**
 * Sets the result of this future to the given value unless
 * this future has already been set or has been cancelled.
 *
 * <p>This method is invoked internally by the {@link #run} method
 * upon successful completion of the computation.
 *
 * @param v the value
 * @apiSince 1
 */

protected void set(V v) { throw new RuntimeException("Stub!"); }

/**
 * Causes this future to report an {@link java.util.concurrent.ExecutionException ExecutionException}
 * with the given throwable as its cause, unless this future has
 * already been set or has been cancelled.
 *
 * <p>This method is invoked internally by the {@link #run} method
 * upon failure of the computation.
 *
 * @param t the cause of failure
 * @apiSince 1
 */

protected void setException(java.lang.Throwable t) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void run() { throw new RuntimeException("Stub!"); }

/**
 * Executes the computation without setting its result, and then
 * resets this future to initial state, failing to do so if the
 * computation encounters an exception or is cancelled.  This is
 * designed for use with tasks that intrinsically execute more
 * than once.
 *
 * @return {@code true} if successfully run and reset
 * @apiSince 1
 */

protected boolean runAndReset() { throw new RuntimeException("Stub!"); }
}

