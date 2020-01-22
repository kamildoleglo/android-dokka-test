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
 * Provides default implementations of {@link java.util.concurrent.ExecutorService ExecutorService}
 * execution methods. This class implements the {@code submit},
 * {@code invokeAny} and {@code invokeAll} methods using a
 * {@link java.util.concurrent.RunnableFuture RunnableFuture} returned by {@code newTaskFor}, which defaults
 * to the {@link java.util.concurrent.FutureTask FutureTask} class provided in this package.  For example,
 * the implementation of {@code submit(Runnable)} creates an
 * associated {@code RunnableFuture} that is executed and
 * returned. Subclasses may override the {@code newTaskFor} methods
 * to return {@code RunnableFuture} implementations other than
 * {@code FutureTask}.
 *
 * <p><b>Extension example</b>. Here is a sketch of a class
 * that customizes {@link java.util.concurrent.ThreadPoolExecutor ThreadPoolExecutor} to use
 * a {@code CustomTask} class instead of the default {@code FutureTask}:
 * <pre> {@code
 * public class CustomThreadPoolExecutor extends ThreadPoolExecutor {
 *
 *   static class CustomTask<V> implements RunnableFuture<V> {...}
 *
 *   protected <V> RunnableFuture<V> newTaskFor(Callable<V> c) {
 *       return new CustomTask<V>(c);
 *   }
 *   protected <V> RunnableFuture<V> newTaskFor(Runnable r, V v) {
 *       return new CustomTask<V>(r, v);
 *   }
 *   // ... add constructors, etc.
 * }}</pre>
 *
 * @since 1.5
 * @author Doug Lea
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class AbstractExecutorService implements java.util.concurrent.ExecutorService {

/** @apiSince 1 */

public AbstractExecutorService() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code RunnableFuture} for the given runnable and default
 * value.
 *
 * @param runnable the runnable task being wrapped
 * @param value the default value for the returned future
 * @param <T> the type of the given value
 * @return a {@code RunnableFuture} which, when run, will run the
 * underlying runnable and which, as a {@code Future}, will yield
 * the given value as its result and provide for cancellation of
 * the underlying task
 * @since 1.6
 * @apiSince 9
 */

protected <T> java.util.concurrent.RunnableFuture<T> newTaskFor(java.lang.Runnable runnable, T value) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code RunnableFuture} for the given callable task.
 *
 * @param callable the callable task being wrapped
 * @param <T> the type of the callable's result
 * @return a {@code RunnableFuture} which, when run, will call the
 * underlying callable and which, as a {@code Future}, will yield
 * the callable's result as its result and provide for
 * cancellation of the underlying task
 * @since 1.6
 * @apiSince 9
 */

protected <T> java.util.concurrent.RunnableFuture<T> newTaskFor(java.util.concurrent.Callable<T> callable) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.util.concurrent.RejectedExecutionException {@inheritDoc}
 * @throws java.lang.NullPointerException       {@inheritDoc}
 * @apiSince 1
 */

public java.util.concurrent.Future<?> submit(java.lang.Runnable task) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.util.concurrent.RejectedExecutionException {@inheritDoc}
 * @throws java.lang.NullPointerException       {@inheritDoc}
 * @apiSince 1
 */

public <T> java.util.concurrent.Future<T> submit(java.lang.Runnable task, T result) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.util.concurrent.RejectedExecutionException {@inheritDoc}
 * @throws java.lang.NullPointerException       {@inheritDoc}
 * @apiSince 1
 */

public <T> java.util.concurrent.Future<T> submit(java.util.concurrent.Callable<T> task) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public <T> T invokeAny(java.util.Collection<? extends java.util.concurrent.Callable<T>> tasks) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public <T> T invokeAny(java.util.Collection<? extends java.util.concurrent.Callable<T>> tasks, long timeout, java.util.concurrent.TimeUnit unit) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException, java.util.concurrent.TimeoutException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public <T> java.util.List<java.util.concurrent.Future<T>> invokeAll(java.util.Collection<? extends java.util.concurrent.Callable<T>> tasks) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public <T> java.util.List<java.util.concurrent.Future<T>> invokeAll(java.util.Collection<? extends java.util.concurrent.Callable<T>> tasks, long timeout, java.util.concurrent.TimeUnit unit) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }
}

