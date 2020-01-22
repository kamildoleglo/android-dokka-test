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
 * Factory and utility methods for {@link java.util.concurrent.Executor Executor}, {@link java.util.concurrent.ExecutorService ExecutorService}, {@link java.util.concurrent.ScheduledExecutorService ScheduledExecutorService}, {@link java.util.concurrent.ThreadFactory ThreadFactory}, and {@link java.util.concurrent.Callable Callable} classes defined in this
 * package. This class supports the following kinds of methods:
 *
 * <ul>
 *   <li>Methods that create and return an {@link java.util.concurrent.ExecutorService ExecutorService}
 *       set up with commonly useful configuration settings.
 *   <li>Methods that create and return a {@link java.util.concurrent.ScheduledExecutorService ScheduledExecutorService}
 *       set up with commonly useful configuration settings.
 *   <li>Methods that create and return a "wrapped" ExecutorService, that
 *       disables reconfiguration by making implementation-specific methods
 *       inaccessible.
 *   <li>Methods that create and return a {@link java.util.concurrent.ThreadFactory ThreadFactory}
 *       that sets newly created threads to a known state.
 *   <li>Methods that create and return a {@link java.util.concurrent.Callable Callable}
 *       out of other closure-like forms, so they can be used
 *       in execution methods requiring {@code Callable}.
 * </ul>
 *
 * @since 1.5
 * @author Doug Lea
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Executors {

private Executors() { throw new RuntimeException("Stub!"); }

/**
 * Creates a thread pool that reuses a fixed number of threads
 * operating off a shared unbounded queue.  At any point, at most
 * {@code nThreads} threads will be active processing tasks.
 * If additional tasks are submitted when all threads are active,
 * they will wait in the queue until a thread is available.
 * If any thread terminates due to a failure during execution
 * prior to shutdown, a new one will take its place if needed to
 * execute subsequent tasks.  The threads in the pool will exist
 * until it is explicitly {@link java.util.concurrent.ExecutorService#shutdown ExecutorService#shutdown}.
 *
 * @param nThreads the number of threads in the pool
 * @return the newly created thread pool
 * @throws java.lang.IllegalArgumentException if {@code nThreads <= 0}
 * @apiSince 1
 */

public static java.util.concurrent.ExecutorService newFixedThreadPool(int nThreads) { throw new RuntimeException("Stub!"); }

/**
 * Creates a thread pool that maintains enough threads to support
 * the given parallelism level, and may use multiple queues to
 * reduce contention. The parallelism level corresponds to the
 * maximum number of threads actively engaged in, or available to
 * engage in, task processing. The actual number of threads may
 * grow and shrink dynamically. A work-stealing pool makes no
 * guarantees about the order in which submitted tasks are
 * executed.
 *
 * @param parallelism the targeted parallelism level
 * @return the newly created thread pool
 * @throws java.lang.IllegalArgumentException if {@code parallelism <= 0}
 * @since 1.8
 * @apiSince 24
 */

public static java.util.concurrent.ExecutorService newWorkStealingPool(int parallelism) { throw new RuntimeException("Stub!"); }

/**
 * Creates a work-stealing thread pool using the number of
 * {@linkplain java.lang.Runtime#availableProcessors Runtime#availableProcessors}
 * as its target parallelism level.
 *
 * @return the newly created thread pool
 * @see #newWorkStealingPool(int)
 * @since 1.8
 * @apiSince 24
 */

public static java.util.concurrent.ExecutorService newWorkStealingPool() { throw new RuntimeException("Stub!"); }

/**
 * Creates a thread pool that reuses a fixed number of threads
 * operating off a shared unbounded queue, using the provided
 * ThreadFactory to create new threads when needed.  At any point,
 * at most {@code nThreads} threads will be active processing
 * tasks.  If additional tasks are submitted when all threads are
 * active, they will wait in the queue until a thread is
 * available.  If any thread terminates due to a failure during
 * execution prior to shutdown, a new one will take its place if
 * needed to execute subsequent tasks.  The threads in the pool will
 * exist until it is explicitly {@link java.util.concurrent.ExecutorService#shutdown ExecutorService#shutdown}.
 *
 * @param nThreads the number of threads in the pool
 * @param threadFactory the factory to use when creating new threads
 * @return the newly created thread pool
 * @throws java.lang.NullPointerException if threadFactory is null
 * @throws java.lang.IllegalArgumentException if {@code nThreads <= 0}
 * @apiSince 1
 */

public static java.util.concurrent.ExecutorService newFixedThreadPool(int nThreads, java.util.concurrent.ThreadFactory threadFactory) { throw new RuntimeException("Stub!"); }

/**
 * Creates an Executor that uses a single worker thread operating
 * off an unbounded queue. (Note however that if this single
 * thread terminates due to a failure during execution prior to
 * shutdown, a new one will take its place if needed to execute
 * subsequent tasks.)  Tasks are guaranteed to execute
 * sequentially, and no more than one task will be active at any
 * given time. Unlike the otherwise equivalent
 * {@code newFixedThreadPool(1)} the returned executor is
 * guaranteed not to be reconfigurable to use additional threads.
 *
 * @return the newly created single-threaded Executor
 * @apiSince 1
 */

public static java.util.concurrent.ExecutorService newSingleThreadExecutor() { throw new RuntimeException("Stub!"); }

/**
 * Creates an Executor that uses a single worker thread operating
 * off an unbounded queue, and uses the provided ThreadFactory to
 * create a new thread when needed. Unlike the otherwise
 * equivalent {@code newFixedThreadPool(1, threadFactory)} the
 * returned executor is guaranteed not to be reconfigurable to use
 * additional threads.
 *
 * @param threadFactory the factory to use when creating new
 * threads
 *
 * @return the newly created single-threaded Executor
 * @throws java.lang.NullPointerException if threadFactory is null
 * @apiSince 1
 */

public static java.util.concurrent.ExecutorService newSingleThreadExecutor(java.util.concurrent.ThreadFactory threadFactory) { throw new RuntimeException("Stub!"); }

/**
 * Creates a thread pool that creates new threads as needed, but
 * will reuse previously constructed threads when they are
 * available.  These pools will typically improve the performance
 * of programs that execute many short-lived asynchronous tasks.
 * Calls to {@code execute} will reuse previously constructed
 * threads if available. If no existing thread is available, a new
 * thread will be created and added to the pool. Threads that have
 * not been used for sixty seconds are terminated and removed from
 * the cache. Thus, a pool that remains idle for long enough will
 * not consume any resources. Note that pools with similar
 * properties but different details (for example, timeout parameters)
 * may be created using {@link java.util.concurrent.ThreadPoolExecutor ThreadPoolExecutor} constructors.
 *
 * @return the newly created thread pool
 * @apiSince 1
 */

public static java.util.concurrent.ExecutorService newCachedThreadPool() { throw new RuntimeException("Stub!"); }

/**
 * Creates a thread pool that creates new threads as needed, but
 * will reuse previously constructed threads when they are
 * available, and uses the provided
 * ThreadFactory to create new threads when needed.
 * @param threadFactory the factory to use when creating new threads
 * @return the newly created thread pool
 * @throws java.lang.NullPointerException if threadFactory is null
 * @apiSince 1
 */

public static java.util.concurrent.ExecutorService newCachedThreadPool(java.util.concurrent.ThreadFactory threadFactory) { throw new RuntimeException("Stub!"); }

/**
 * Creates a single-threaded executor that can schedule commands
 * to run after a given delay, or to execute periodically.
 * (Note however that if this single
 * thread terminates due to a failure during execution prior to
 * shutdown, a new one will take its place if needed to execute
 * subsequent tasks.)  Tasks are guaranteed to execute
 * sequentially, and no more than one task will be active at any
 * given time. Unlike the otherwise equivalent
 * {@code newScheduledThreadPool(1)} the returned executor is
 * guaranteed not to be reconfigurable to use additional threads.
 * @return the newly created scheduled executor
 * @apiSince 1
 */

public static java.util.concurrent.ScheduledExecutorService newSingleThreadScheduledExecutor() { throw new RuntimeException("Stub!"); }

/**
 * Creates a single-threaded executor that can schedule commands
 * to run after a given delay, or to execute periodically.  (Note
 * however that if this single thread terminates due to a failure
 * during execution prior to shutdown, a new one will take its
 * place if needed to execute subsequent tasks.)  Tasks are
 * guaranteed to execute sequentially, and no more than one task
 * will be active at any given time. Unlike the otherwise
 * equivalent {@code newScheduledThreadPool(1, threadFactory)}
 * the returned executor is guaranteed not to be reconfigurable to
 * use additional threads.
 * @param threadFactory the factory to use when creating new
 * threads
 * @return a newly created scheduled executor
 * @throws java.lang.NullPointerException if threadFactory is null
 * @apiSince 1
 */

public static java.util.concurrent.ScheduledExecutorService newSingleThreadScheduledExecutor(java.util.concurrent.ThreadFactory threadFactory) { throw new RuntimeException("Stub!"); }

/**
 * Creates a thread pool that can schedule commands to run after a
 * given delay, or to execute periodically.
 * @param corePoolSize the number of threads to keep in the pool,
 * even if they are idle
 * @return a newly created scheduled thread pool
 * @throws java.lang.IllegalArgumentException if {@code corePoolSize < 0}
 * @apiSince 1
 */

public static java.util.concurrent.ScheduledExecutorService newScheduledThreadPool(int corePoolSize) { throw new RuntimeException("Stub!"); }

/**
 * Creates a thread pool that can schedule commands to run after a
 * given delay, or to execute periodically.
 * @param corePoolSize the number of threads to keep in the pool,
 * even if they are idle
 * @param threadFactory the factory to use when the executor
 * creates a new thread
 * @return a newly created scheduled thread pool
 * @throws java.lang.IllegalArgumentException if {@code corePoolSize < 0}
 * @throws java.lang.NullPointerException if threadFactory is null
 * @apiSince 1
 */

public static java.util.concurrent.ScheduledExecutorService newScheduledThreadPool(int corePoolSize, java.util.concurrent.ThreadFactory threadFactory) { throw new RuntimeException("Stub!"); }

/**
 * Returns an object that delegates all defined {@link java.util.concurrent.ExecutorService ExecutorService} methods to the given executor, but not any
 * other methods that might otherwise be accessible using
 * casts. This provides a way to safely "freeze" configuration and
 * disallow tuning of a given concrete implementation.
 * @param executor the underlying implementation
 * @return an {@code ExecutorService} instance
 * @throws java.lang.NullPointerException if executor null
 * @apiSince 1
 */

public static java.util.concurrent.ExecutorService unconfigurableExecutorService(java.util.concurrent.ExecutorService executor) { throw new RuntimeException("Stub!"); }

/**
 * Returns an object that delegates all defined {@link java.util.concurrent.ScheduledExecutorService ScheduledExecutorService} methods to the given executor, but
 * not any other methods that might otherwise be accessible using
 * casts. This provides a way to safely "freeze" configuration and
 * disallow tuning of a given concrete implementation.
 * @param executor the underlying implementation
 * @return a {@code ScheduledExecutorService} instance
 * @throws java.lang.NullPointerException if executor null
 * @apiSince 1
 */

public static java.util.concurrent.ScheduledExecutorService unconfigurableScheduledExecutorService(java.util.concurrent.ScheduledExecutorService executor) { throw new RuntimeException("Stub!"); }

/**
 * Returns a default thread factory used to create new threads.
 * This factory creates all new threads used by an Executor in the
 * same {@link java.lang.ThreadGroup ThreadGroup}. Each new
 * thread is created as a non-daemon thread with priority set to
 * the smaller of {@code Thread.NORM_PRIORITY} and the maximum
 * priority permitted in the thread group.  New threads have names
 * accessible via {@link java.lang.Thread#getName Thread#getName} of
 * <em>pool-N-thread-M</em>, where <em>N</em> is the sequence
 * number of this factory, and <em>M</em> is the sequence number
 * of the thread created by this factory.
 * @return a thread factory
 * @apiSince 1
 */

public static java.util.concurrent.ThreadFactory defaultThreadFactory() { throw new RuntimeException("Stub!"); }

/**
 * Legacy security code; do not use.
 * @apiSince 1
 */

public static java.util.concurrent.ThreadFactory privilegedThreadFactory() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.concurrent.Callable Callable} object that, when
 * called, runs the given task and returns the given result.  This
 * can be useful when applying methods requiring a
 * {@code Callable} to an otherwise resultless action.
 * @param task the task to run
 * @param result the result to return
 * @param <T> the type of the result
 * @return a callable object
 * @throws java.lang.NullPointerException if task null
 * @apiSince 1
 */

public static <T> java.util.concurrent.Callable<T> callable(java.lang.Runnable task, T result) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.concurrent.Callable Callable} object that, when
 * called, runs the given task and returns {@code null}.
 * @param task the task to run
 * @return a callable object
 * @throws java.lang.NullPointerException if task null
 * @apiSince 1
 */

public static java.util.concurrent.Callable<java.lang.Object> callable(java.lang.Runnable task) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.concurrent.Callable Callable} object that, when
 * called, runs the given privileged action and returns its result.
 * @param action the privileged action to run
 * @return a callable object
 * @throws java.lang.NullPointerException if action null
 * @apiSince 1
 */

public static java.util.concurrent.Callable<java.lang.Object> callable(java.security.PrivilegedAction<?> action) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.concurrent.Callable Callable} object that, when
 * called, runs the given privileged exception action and returns
 * its result.
 * @param action the privileged exception action to run
 * @return a callable object
 * @throws java.lang.NullPointerException if action null
 * @apiSince 1
 */

public static java.util.concurrent.Callable<java.lang.Object> callable(java.security.PrivilegedExceptionAction<?> action) { throw new RuntimeException("Stub!"); }

/**
 * Legacy security code; do not use.
 * @apiSince 1
 */

public static <T> java.util.concurrent.Callable<T> privilegedCallable(java.util.concurrent.Callable<T> callable) { throw new RuntimeException("Stub!"); }

/**
 * Legacy security code; do not use.
 * @apiSince 1
 */

public static <T> java.util.concurrent.Callable<T> privilegedCallableUsingCurrentClassLoader(java.util.concurrent.Callable<T> callable) { throw new RuntimeException("Stub!"); }
}

