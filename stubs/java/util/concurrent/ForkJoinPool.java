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

import java.security.Permissions;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.locks.ReentrantLock;

/**
 * An {@link java.util.concurrent.ExecutorService ExecutorService} for running {@link java.util.concurrent.ForkJoinTask ForkJoinTask}s.
 * A {@code ForkJoinPool} provides the entry point for submissions
 * from non-{@code ForkJoinTask} clients, as well as management and
 * monitoring operations.
 *
 * <p>A {@code ForkJoinPool} differs from other kinds of {@link java.util.concurrent.ExecutorService ExecutorService} mainly by virtue of employing
 * <em>work-stealing</em>: all threads in the pool attempt to find and
 * execute tasks submitted to the pool and/or created by other active
 * tasks (eventually blocking waiting for work if none exist). This
 * enables efficient processing when most tasks spawn other subtasks
 * (as do most {@code ForkJoinTask}s), as well as when many small
 * tasks are submitted to the pool from external clients.  Especially
 * when setting <em>asyncMode</em> to true in constructors, {@code
 * ForkJoinPool}s may also be appropriate for use with event-style
 * tasks that are never joined.
 *
 * <p>A static {@link #commonPool()} is available and appropriate for
 * most applications. The common pool is used by any ForkJoinTask that
 * is not explicitly submitted to a specified pool. Using the common
 * pool normally reduces resource usage (its threads are slowly
 * reclaimed during periods of non-use, and reinstated upon subsequent
 * use).
 *
 * <p>For applications that require separate or custom pools, a {@code
 * ForkJoinPool} may be constructed with a given target parallelism
 * level; by default, equal to the number of available processors.
 * The pool attempts to maintain enough active (or available) threads
 * by dynamically adding, suspending, or resuming internal worker
 * threads, even if some tasks are stalled waiting to join others.
 * However, no such adjustments are guaranteed in the face of blocked
 * I/O or other unmanaged synchronization. The nested {@link java.util.concurrent.ForkJoinPool.ManagedBlocker ManagedBlocker} interface enables extension of the kinds of
 * synchronization accommodated.
 *
 * <p>In addition to execution and lifecycle control methods, this
 * class provides status check methods (for example
 * {@link #getStealCount}) that are intended to aid in developing,
 * tuning, and monitoring fork/join applications. Also, method
 * {@link #toString} returns indications of pool state in a
 * convenient form for informal monitoring.
 *
 * <p>As is the case with other ExecutorServices, there are three
 * main task execution methods summarized in the following table.
 * These are designed to be used primarily by clients not already
 * engaged in fork/join computations in the current pool.  The main
 * forms of these methods accept instances of {@code ForkJoinTask},
 * but overloaded forms also allow mixed execution of plain {@code
 * Runnable}- or {@code Callable}- based activities as well.  However,
 * tasks that are already executing in a pool should normally instead
 * use the within-computation forms listed in the table unless using
 * async event-style tasks that are not usually joined, in which case
 * there is little difference among choice of methods.
 *
 * <table BORDER CELLPADDING=3 CELLSPACING=1>
 * <caption>Summary of task execution methods</caption>
 *  <tr>
 *    <td></td>
 *    <td ALIGN=CENTER> <b>Call from non-fork/join clients</b></td>
 *    <td ALIGN=CENTER> <b>Call from within fork/join computations</b></td>
 *  </tr>
 *  <tr>
 *    <td> <b>Arrange async execution</b></td>
 *    <td> {@link #execute(java.util.concurrent.ForkJoinTask)}</td>
 *    <td> {@link java.util.concurrent.ForkJoinTask#fork ForkJoinTask#fork}</td>
 *  </tr>
 *  <tr>
 *    <td> <b>Await and obtain result</b></td>
 *    <td> {@link #invoke(java.util.concurrent.ForkJoinTask)}</td>
 *    <td> {@link java.util.concurrent.ForkJoinTask#invoke ForkJoinTask#invoke}</td>
 *  </tr>
 *  <tr>
 *    <td> <b>Arrange exec and obtain Future</b></td>
 *    <td> {@link #submit(java.util.concurrent.ForkJoinTask)}</td>
 *    <td> {@link java.util.concurrent.ForkJoinTask#fork ForkJoinTask#fork} (ForkJoinTasks <em>are</em> Futures)</td>
 *  </tr>
 * </table>
 *
 * <p>The common pool is by default constructed with default
 * parameters, but these may be controlled by setting three
 * {@linkplain java.lang.System#getProperty System#getProperty}:
 * <ul>
 * <li>{@code java.util.concurrent.ForkJoinPool.common.parallelism}
 * - the parallelism level, a non-negative integer
 * <li>{@code java.util.concurrent.ForkJoinPool.common.threadFactory}
 * - the class name of a {@link java.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory ForkJoinWorkerThreadFactory}
 * <li>{@code java.util.concurrent.ForkJoinPool.common.exceptionHandler}
 * - the class name of a {@link java.lang.Thread.UncaughtExceptionHandler UncaughtExceptionHandler}
 * <li>{@code java.util.concurrent.ForkJoinPool.common.maximumSpares}
 * - the maximum number of allowed extra threads to maintain target
 * parallelism (default 256).
 * </ul>
 * If a {@link java.lang.SecurityManager SecurityManager} is present and no factory is
 * specified, then the default pool uses a factory supplying
 * threads that have no {@link java.security.Permissions Permissions} enabled.
 * The system class loader is used to load these classes.
 * Upon any error in establishing these settings, default parameters
 * are used. It is possible to disable or limit the use of threads in
 * the common pool by setting the parallelism property to zero, and/or
 * using a factory that may return {@code null}. However doing so may
 * cause unjoined tasks to never be executed.
 *
 * <p><b>Implementation notes</b>: This implementation restricts the
 * maximum number of running threads to 32767. Attempts to create
 * pools with greater than the maximum number result in
 * {@code IllegalArgumentException}.
 *
 * <p>This implementation rejects submitted tasks (that is, by throwing
 * {@link java.util.concurrent.RejectedExecutionException RejectedExecutionException}) only when the pool is shut down
 * or internal resources have been exhausted.
 *
 * @since 1.7
 * @author Doug Lea
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ForkJoinPool extends java.util.concurrent.AbstractExecutorService {

/**
 * Creates a {@code ForkJoinPool} with parallelism equal to {@link
 * java.lang.Runtime#availableProcessors}, using the {@linkplain
 * #defaultForkJoinWorkerThreadFactory default thread factory},
 * no UncaughtExceptionHandler, and non-async LIFO processing mode.
 *
 * @throws java.lang.SecurityException if a security manager exists and
 *         the caller is not permitted to modify threads
 *         because it does not hold {@link
 *         java.lang.RuntimePermission}{@code ("modifyThread")}
 * @apiSince 21
 */

public ForkJoinPool() { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code ForkJoinPool} with the indicated parallelism
 * level, the {@linkplain
 * #defaultForkJoinWorkerThreadFactory default thread factory},
 * no UncaughtExceptionHandler, and non-async LIFO processing mode.
 *
 * @param parallelism the parallelism level
 * @throws java.lang.IllegalArgumentException if parallelism less than or
 *         equal to zero, or greater than implementation limit
 * @throws java.lang.SecurityException if a security manager exists and
 *         the caller is not permitted to modify threads
 *         because it does not hold {@link
 *         java.lang.RuntimePermission}{@code ("modifyThread")}
 * @apiSince 21
 */

public ForkJoinPool(int parallelism) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code ForkJoinPool} with the given parameters.
 *
 * @param parallelism the parallelism level. For default value,
 * use {@link java.lang.Runtime#availableProcessors}.
 * @param factory the factory for creating new threads. For default value,
 * use {@link #defaultForkJoinWorkerThreadFactory}.
 * @param handler the handler for internal worker threads that
 * terminate due to unrecoverable errors encountered while executing
 * tasks. For default value, use {@code null}.
 * @param asyncMode if true,
 * establishes local first-in-first-out scheduling mode for forked
 * tasks that are never joined. This mode may be more appropriate
 * than default locally stack-based mode in applications in which
 * worker threads only process event-style asynchronous tasks.
 * For default value, use {@code false}.
 * @throws java.lang.IllegalArgumentException if parallelism less than or
 *         equal to zero, or greater than implementation limit
 * @throws java.lang.NullPointerException if the factory is null
 * @throws java.lang.SecurityException if a security manager exists and
 *         the caller is not permitted to modify threads
 *         because it does not hold {@link
 *         java.lang.RuntimePermission}{@code ("modifyThread")}
 * @apiSince 21
 */

public ForkJoinPool(int parallelism, java.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory factory, java.lang.Thread.UncaughtExceptionHandler handler, boolean asyncMode) { throw new RuntimeException("Stub!"); }

/**
 * Returns the common pool instance. This pool is statically
 * constructed; its run state is unaffected by attempts to {@link
 * #shutdown} or {@link #shutdownNow}. However this pool and any
 * ongoing processing are automatically terminated upon program
 * {@link java.lang.System#exit System#exit}.  Any program that relies on asynchronous
 * task processing to complete before program termination should
 * invoke {@code commonPool().}{@link #awaitQuiescence awaitQuiescence},
 * before exit.
 *
 * @return the common pool instance
 * @since 1.8
 * @apiSince 24
 */

public static java.util.concurrent.ForkJoinPool commonPool() { throw new RuntimeException("Stub!"); }

/**
 * Performs the given task, returning its result upon completion.
 * If the computation encounters an unchecked Exception or Error,
 * it is rethrown as the outcome of this invocation.  Rethrown
 * exceptions behave in the same way as regular exceptions, but,
 * when possible, contain stack traces (as displayed for example
 * using {@code ex.printStackTrace()}) of both the current thread
 * as well as the thread actually encountering the exception;
 * minimally only the latter.
 *
 * @param task the task
 * @param <T> the type of the task's result
 * @return the task's result
 * @throws java.lang.NullPointerException if the task is null
 * @throws java.util.concurrent.RejectedExecutionException if the task cannot be
 *         scheduled for execution
 * @apiSince 21
 */

public <T> T invoke(java.util.concurrent.ForkJoinTask<T> task) { throw new RuntimeException("Stub!"); }

/**
 * Arranges for (asynchronous) execution of the given task.
 *
 * @param task the task
 * @throws java.lang.NullPointerException if the task is null
 * @throws java.util.concurrent.RejectedExecutionException if the task cannot be
 *         scheduled for execution
 * @apiSince 21
 */

public void execute(java.util.concurrent.ForkJoinTask<?> task) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.NullPointerException if the task is null
 * @throws java.util.concurrent.RejectedExecutionException if the task cannot be
 *         scheduled for execution
 * @apiSince 21
 */

public void execute(java.lang.Runnable task) { throw new RuntimeException("Stub!"); }

/**
 * Submits a ForkJoinTask for execution.
 *
 * @param task the task to submit
 * @param <T> the type of the task's result
 * @return the task
 * @throws java.lang.NullPointerException if the task is null
 * @throws java.util.concurrent.RejectedExecutionException if the task cannot be
 *         scheduled for execution
 * @apiSince 21
 */

public <T> java.util.concurrent.ForkJoinTask<T> submit(java.util.concurrent.ForkJoinTask<T> task) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.NullPointerException if the task is null
 * @throws java.util.concurrent.RejectedExecutionException if the task cannot be
 *         scheduled for execution
 * @apiSince 21
 */

public <T> java.util.concurrent.ForkJoinTask<T> submit(java.util.concurrent.Callable<T> task) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.NullPointerException if the task is null
 * @throws java.util.concurrent.RejectedExecutionException if the task cannot be
 *         scheduled for execution
 * @apiSince 21
 */

public <T> java.util.concurrent.ForkJoinTask<T> submit(java.lang.Runnable task, T result) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.NullPointerException if the task is null
 * @throws java.util.concurrent.RejectedExecutionException if the task cannot be
 *         scheduled for execution
 * @apiSince 21
 */

public java.util.concurrent.ForkJoinTask<?> submit(java.lang.Runnable task) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.NullPointerException       {@inheritDoc}
 * @throws java.util.concurrent.RejectedExecutionException {@inheritDoc}
 * @apiSince 21
 */

public <T> java.util.List<java.util.concurrent.Future<T>> invokeAll(java.util.Collection<? extends java.util.concurrent.Callable<T>> tasks) { throw new RuntimeException("Stub!"); }

/**
 * Returns the factory used for constructing new workers.
 *
 * @return the factory used for constructing new workers
 * @apiSince 21
 */

public java.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory getFactory() { throw new RuntimeException("Stub!"); }

/**
 * Returns the handler for internal worker threads that terminate
 * due to unrecoverable errors encountered while executing tasks.
 *
 * @return the handler, or {@code null} if none
 * @apiSince 21
 */

public java.lang.Thread.UncaughtExceptionHandler getUncaughtExceptionHandler() { throw new RuntimeException("Stub!"); }

/**
 * Returns the targeted parallelism level of this pool.
 *
 * @return the targeted parallelism level of this pool
 * @apiSince 21
 */

public int getParallelism() { throw new RuntimeException("Stub!"); }

/**
 * Returns the targeted parallelism level of the common pool.
 *
 * @return the targeted parallelism level of the common pool
 * @since 1.8
 * @apiSince 24
 */

public static int getCommonPoolParallelism() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of worker threads that have started but not
 * yet terminated.  The result returned by this method may differ
 * from {@link #getParallelism} when threads are created to
 * maintain parallelism when others are cooperatively blocked.
 *
 * @return the number of worker threads
 * @apiSince 21
 */

public int getPoolSize() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this pool uses local first-in-first-out
 * scheduling mode for forked tasks that are never joined.
 *
 * @return {@code true} if this pool uses async mode
 * @apiSince 21
 */

public boolean getAsyncMode() { throw new RuntimeException("Stub!"); }

/**
 * Returns an estimate of the number of worker threads that are
 * not blocked waiting to join tasks or for other managed
 * synchronization. This method may overestimate the
 * number of running threads.
 *
 * @return the number of worker threads
 * @apiSince 21
 */

public int getRunningThreadCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns an estimate of the number of threads that are currently
 * stealing or executing tasks. This method may overestimate the
 * number of active threads.
 *
 * @return the number of active threads
 * @apiSince 21
 */

public int getActiveThreadCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if all worker threads are currently idle.
 * An idle worker is one that cannot obtain a task to execute
 * because none are available to steal from other threads, and
 * there are no pending submissions to the pool. This method is
 * conservative; it might not return {@code true} immediately upon
 * idleness of all threads, but will eventually become true if
 * threads remain inactive.
 *
 * @return {@code true} if all threads are currently idle
 * @apiSince 21
 */

public boolean isQuiescent() { throw new RuntimeException("Stub!"); }

/**
 * Returns an estimate of the total number of tasks stolen from
 * one thread's work queue by another. The reported value
 * underestimates the actual total number of steals when the pool
 * is not quiescent. This value may be useful for monitoring and
 * tuning fork/join programs: in general, steal counts should be
 * high enough to keep threads busy, but low enough to avoid
 * overhead and contention across threads.
 *
 * @return the number of steals
 * @apiSince 21
 */

public long getStealCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns an estimate of the total number of tasks currently held
 * in queues by worker threads (but not including tasks submitted
 * to the pool that have not begun executing). This value is only
 * an approximation, obtained by iterating across all threads in
 * the pool. This method may be useful for tuning task
 * granularities.
 *
 * @return the number of queued tasks
 * @apiSince 21
 */

public long getQueuedTaskCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns an estimate of the number of tasks submitted to this
 * pool that have not yet begun executing.  This method may take
 * time proportional to the number of submissions.
 *
 * @return the number of queued submissions
 * @apiSince 21
 */

public int getQueuedSubmissionCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if there are any tasks submitted to this
 * pool that have not yet begun executing.
 *
 * @return {@code true} if there are any queued submissions
 * @apiSince 21
 */

public boolean hasQueuedSubmissions() { throw new RuntimeException("Stub!"); }

/**
 * Removes and returns the next unexecuted submission if one is
 * available.  This method may be useful in extensions to this
 * class that re-assign work in systems with multiple pools.
 *
 * @return the next submission, or {@code null} if none
 * @apiSince 21
 */

protected java.util.concurrent.ForkJoinTask<?> pollSubmission() { throw new RuntimeException("Stub!"); }

/**
 * Removes all available unexecuted submitted and forked tasks
 * from scheduling queues and adds them to the given collection,
 * without altering their execution status. These may include
 * artificially generated or wrapped tasks. This method is
 * designed to be invoked only when the pool is known to be
 * quiescent. Invocations at other times may not remove all
 * tasks. A failure encountered while attempting to add elements
 * to collection {@code c} may result in elements being in
 * neither, either or both collections when the associated
 * exception is thrown.  The behavior of this operation is
 * undefined if the specified collection is modified while the
 * operation is in progress.
 *
 * @param c the collection to transfer elements into
 * @return the number of elements transferred
 * @apiSince 21
 */

protected int drainTasksTo(java.util.Collection<? super java.util.concurrent.ForkJoinTask<?>> c) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string identifying this pool, as well as its state,
 * including indications of run state, parallelism level, and
 * worker and task counts.
 *
 * @return a string identifying this pool, as well as its state
 * @apiSince 21
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Possibly initiates an orderly shutdown in which previously
 * submitted tasks are executed, but no new tasks will be
 * accepted. Invocation has no effect on execution state if this
 * is the {@link #commonPool()}, and no additional effect if
 * already shut down.  Tasks that are in the process of being
 * submitted concurrently during the course of this method may or
 * may not be rejected.
 *
 * @throws java.lang.SecurityException if a security manager exists and
 *         the caller is not permitted to modify threads
 *         because it does not hold {@link
 *         java.lang.RuntimePermission}{@code ("modifyThread")}
 * @apiSince 21
 */

public void shutdown() { throw new RuntimeException("Stub!"); }

/**
 * Possibly attempts to cancel and/or stop all tasks, and reject
 * all subsequently submitted tasks.  Invocation has no effect on
 * execution state if this is the {@link #commonPool()}, and no
 * additional effect if already shut down. Otherwise, tasks that
 * are in the process of being submitted or executed concurrently
 * during the course of this method may or may not be
 * rejected. This method cancels both existing and unexecuted
 * tasks, in order to permit termination in the presence of task
 * dependencies. So the method always returns an empty list
 * (unlike the case for some other Executors).
 *
 * @return an empty list
 * @throws java.lang.SecurityException if a security manager exists and
 *         the caller is not permitted to modify threads
 *         because it does not hold {@link
 *         java.lang.RuntimePermission}{@code ("modifyThread")}
 * @apiSince 21
 */

public java.util.List<java.lang.Runnable> shutdownNow() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if all tasks have completed following shut down.
 *
 * @return {@code true} if all tasks have completed following shut down
 * @apiSince 21
 */

public boolean isTerminated() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the process of termination has
 * commenced but not yet completed.  This method may be useful for
 * debugging. A return of {@code true} reported a sufficient
 * period after shutdown may indicate that submitted tasks have
 * ignored or suppressed interruption, or are waiting for I/O,
 * causing this executor not to properly terminate. (See the
 * advisory notes for class {@link java.util.concurrent.ForkJoinTask ForkJoinTask} stating that
 * tasks should not normally entail blocking operations.  But if
 * they do, they must abort them on interrupt.)
 *
 * @return {@code true} if terminating but not yet terminated
 * @apiSince 21
 */

public boolean isTerminating() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this pool has been shut down.
 *
 * @return {@code true} if this pool has been shut down
 * @apiSince 21
 */

public boolean isShutdown() { throw new RuntimeException("Stub!"); }

/**
 * Blocks until all tasks have completed execution after a
 * shutdown request, or the timeout occurs, or the current thread
 * is interrupted, whichever happens first. Because the {@link
 * #commonPool()} never terminates until program shutdown, when
 * applied to the common pool, this method is equivalent to {@link
 * #awaitQuiescence(long,java.util.concurrent.TimeUnit)} but always returns {@code false}.
 *
 * @param timeout the maximum time to wait
 * @param unit the time unit of the timeout argument
 * @return {@code true} if this executor terminated and
 *         {@code false} if the timeout elapsed before termination
 * @throws java.lang.InterruptedException if interrupted while waiting
 * @apiSince 21
 */

public boolean awaitTermination(long timeout, java.util.concurrent.TimeUnit unit) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * If called by a ForkJoinTask operating in this pool, equivalent
 * in effect to {@link java.util.concurrent.ForkJoinTask#helpQuiesce ForkJoinTask#helpQuiesce}. Otherwise,
 * waits and/or attempts to assist performing tasks until this
 * pool {@link #isQuiescent} or the indicated timeout elapses.
 *
 * @param timeout the maximum time to wait
 * @param unit the time unit of the timeout argument
 * @return {@code true} if quiescent; {@code false} if the
 * timeout elapsed.
 * @apiSince 21
 */

public boolean awaitQuiescence(long timeout, java.util.concurrent.TimeUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * Runs the given possibly blocking task.  When {@linkplain java.util.concurrent.ForkJoinTask#inForkJoinPool() ForkJoinTask#inForkJoinPool()}, this
 * method possibly arranges for a spare thread to be activated if
 * necessary to ensure sufficient parallelism while the current
 * thread is blocked in {@link java.util.concurrent.ForkJoinPool.ManagedBlocker#block ManagedBlocker#block}.
 *
 * <p>This method repeatedly calls {@code blocker.isReleasable()} and
 * {@code blocker.block()} until either method returns {@code true}.
 * Every call to {@code blocker.block()} is preceded by a call to
 * {@code blocker.isReleasable()} that returned {@code false}.
 *
 * <p>If not running in a ForkJoinPool, this method is
 * behaviorally equivalent to
 * <pre> {@code
 * while (!blocker.isReleasable())
 *   if (blocker.block())
 *     break;}</pre>
 *
 * If running in a ForkJoinPool, the pool may first be expanded to
 * ensure sufficient parallelism available during the call to
 * {@code blocker.block()}.
 *
 * @param blocker the blocker task
 * @throws java.lang.InterruptedException if {@code blocker.block()} did so
 * @apiSince 21
 */

public static void managedBlock(java.util.concurrent.ForkJoinPool.ManagedBlocker blocker) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

protected <T> java.util.concurrent.RunnableFuture<T> newTaskFor(java.lang.Runnable runnable, T value) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

protected <T> java.util.concurrent.RunnableFuture<T> newTaskFor(java.util.concurrent.Callable<T> callable) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new ForkJoinWorkerThread. This factory is used unless
 * overridden in ForkJoinPool constructors.
 * @apiSince 21
 */

public static final java.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory defaultForkJoinWorkerThreadFactory;
static { defaultForkJoinWorkerThreadFactory = null; }
/**
 * Factory for creating new {@link java.util.concurrent.ForkJoinWorkerThread ForkJoinWorkerThread}s.
 * A {@code ForkJoinWorkerThreadFactory} must be defined and used
 * for {@code ForkJoinWorkerThread} subclasses that extend base
 * functionality or initialize threads with different contexts.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface ForkJoinWorkerThreadFactory {

/**
 * Returns a new worker thread operating in the given pool.
 *
 * @param pool the pool this thread works in
 * @return the new worker thread, or {@code null} if the request
 *         to create a thread is rejected
 * @throws java.lang.NullPointerException if the pool is null
 * @apiSince 21
 */

public java.util.concurrent.ForkJoinWorkerThread newThread(java.util.concurrent.ForkJoinPool pool);
}

/**
 * Interface for extending managed parallelism for tasks running
 * in {@link java.util.concurrent.ForkJoinPool ForkJoinPool}s.
 *
 * <p>A {@code ManagedBlocker} provides two methods.  Method
 * {@link #isReleasable} must return {@code true} if blocking is
 * not necessary. Method {@link #block} blocks the current thread
 * if necessary (perhaps internally invoking {@code isReleasable}
 * before actually blocking). These actions are performed by any
 * thread invoking {@link java.util.concurrent.ForkJoinPool#managedBlock(java.util.concurrent.ForkJoinPool.ManagedBlocker) ForkJoinPool#managedBlock(ManagedBlocker)}.
 * The unusual methods in this API accommodate synchronizers that
 * may, but don't usually, block for long periods. Similarly, they
 * allow more efficient internal handling of cases in which
 * additional workers may be, but usually are not, needed to
 * ensure sufficient parallelism.  Toward this end,
 * implementations of method {@code isReleasable} must be amenable
 * to repeated invocation.
 *
 * <p>For example, here is a ManagedBlocker based on a
 * ReentrantLock:
 * <pre> {@code
 * class ManagedLocker implements ManagedBlocker {
 *   final ReentrantLock lock;
 *   boolean hasLock = false;
 *   ManagedLocker(ReentrantLock lock) { this.lock = lock; }
 *   public boolean block() {
 *     if (!hasLock)
 *       lock.lock();
 *     return true;
 *   }
 *   public boolean isReleasable() {
 *     return hasLock || (hasLock = lock.tryLock());
 *   }
 * }}</pre>
 *
 * <p>Here is a class that possibly blocks waiting for an
 * item on a given queue:
 * <pre> {@code
 * class QueueTaker<E> implements ManagedBlocker {
 *   final BlockingQueue<E> queue;
 *   volatile E item = null;
 *   QueueTaker(BlockingQueue<E> q) { this.queue = q; }
 *   public boolean block() throws InterruptedException {
 *     if (item == null)
 *       item = queue.take();
 *     return true;
 *   }
 *   public boolean isReleasable() {
 *     return item != null || (item = queue.poll()) != null;
 *   }
 *   public E getItem() { // call after pool.managedBlock completes
 *     return item;
 *   }
 * }}</pre>
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface ManagedBlocker {

/**
 * Possibly blocks the current thread, for example waiting for
 * a lock or condition.
 *
 * @return {@code true} if no additional blocking is necessary
 * (i.e., if isReleasable would return true)
 * @throws java.lang.InterruptedException if interrupted while waiting
 * (the method is not required to do so, but is allowed to)
 * @apiSince 21
 */

public boolean block() throws java.lang.InterruptedException;

/**
 * Returns {@code true} if blocking is unnecessary.
 * @return {@code true} if blocking is unnecessary
 * @apiSince 21
 */

public boolean isReleasable();
}

}

