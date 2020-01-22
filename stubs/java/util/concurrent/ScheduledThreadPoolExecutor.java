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
 * A {@link java.util.concurrent.ThreadPoolExecutor ThreadPoolExecutor} that can additionally schedule
 * commands to run after a given delay, or to execute periodically.
 * This class is preferable to {@link java.util.Timer} when multiple
 * worker threads are needed, or when the additional flexibility or
 * capabilities of {@link java.util.concurrent.ThreadPoolExecutor ThreadPoolExecutor} (which this class
 * extends) are required.
 *
 * <p>Delayed tasks execute no sooner than they are enabled, but
 * without any real-time guarantees about when, after they are
 * enabled, they will commence. Tasks scheduled for exactly the same
 * execution time are enabled in first-in-first-out (FIFO) order of
 * submission.
 *
 * <p>When a submitted task is cancelled before it is run, execution
 * is suppressed.  By default, such a cancelled task is not
 * automatically removed from the work queue until its delay elapses.
 * While this enables further inspection and monitoring, it may also
 * cause unbounded retention of cancelled tasks.
 *
 * <p>Successive executions of a periodic task scheduled via
 * {@link #scheduleAtFixedRate scheduleAtFixedRate} or
 * {@link #scheduleWithFixedDelay scheduleWithFixedDelay}
 * do not overlap. While different executions may be performed by
 * different threads, the effects of prior executions
 * <a href="package-summary.html#MemoryVisibility"><i>happen-before</i></a>
 * those of subsequent ones.
 *
 * <p>While this class inherits from {@link java.util.concurrent.ThreadPoolExecutor ThreadPoolExecutor}, a few
 * of the inherited tuning methods are not useful for it. In
 * particular, because it acts as a fixed-sized pool using
 * {@code corePoolSize} threads and an unbounded queue, adjustments
 * to {@code maximumPoolSize} have no useful effect. Additionally, it
 * is almost never a good idea to set {@code corePoolSize} to zero or
 * use {@code allowCoreThreadTimeOut} because this may leave the pool
 * without threads to handle tasks once they become eligible to run.
 *
 * <p><b>Extension notes:</b> This class overrides the
 * {@link java.util.concurrent.ThreadPoolExecutor#execute(java.lang.Runnable) ThreadPoolExecutor#execute(Runnable)} and
 * {@link java.util.concurrent.AbstractExecutorService#submit(java.lang.Runnable) AbstractExecutorService#submit(Runnable)}
 * methods to generate internal {@link java.util.concurrent.ScheduledFuture ScheduledFuture} objects to
 * control per-task delays and scheduling.  To preserve
 * functionality, any further overrides of these methods in
 * subclasses must invoke superclass versions, which effectively
 * disables additional task customization.  However, this class
 * provides alternative protected extension method
 * {@code decorateTask} (one version each for {@code Runnable} and
 * {@code Callable}) that can be used to customize the concrete task
 * types used to execute commands entered via {@code execute},
 * {@code submit}, {@code schedule}, {@code scheduleAtFixedRate},
 * and {@code scheduleWithFixedDelay}.  By default, a
 * {@code ScheduledThreadPoolExecutor} uses a task type extending
 * {@link java.util.concurrent.FutureTask FutureTask}. However, this may be modified or replaced using
 * subclasses of the form:
 *
 * <pre> {@code
 * public class CustomScheduledExecutor extends ScheduledThreadPoolExecutor {
 *
 *   static class CustomTask<V> implements RunnableScheduledFuture<V> { ... }
 *
 *   protected <V> RunnableScheduledFuture<V> decorateTask(
 *                Runnable r, RunnableScheduledFuture<V> task) {
 *       return new CustomTask<V>(r, task);
 *   }
 *
 *   protected <V> RunnableScheduledFuture<V> decorateTask(
 *                Callable<V> c, RunnableScheduledFuture<V> task) {
 *       return new CustomTask<V>(c, task);
 *   }
 *   // ... add constructors, etc.
 * }}</pre>
 *
 * @since 1.5
 * @author Doug Lea
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ScheduledThreadPoolExecutor extends java.util.concurrent.ThreadPoolExecutor implements java.util.concurrent.ScheduledExecutorService {

/**
 * Creates a new {@code ScheduledThreadPoolExecutor} with the
 * given core pool size.
 *
 * @param corePoolSize the number of threads to keep in the pool, even
 *        if they are idle, unless {@code allowCoreThreadTimeOut} is set
 * @throws java.lang.IllegalArgumentException if {@code corePoolSize < 0}
 * @apiSince 1
 */

public ScheduledThreadPoolExecutor(int corePoolSize) { super(0, 0, 0, (java.util.concurrent.TimeUnit)null, (java.util.concurrent.BlockingQueue)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@code ScheduledThreadPoolExecutor} with the
 * given initial parameters.
 *
 * @param corePoolSize the number of threads to keep in the pool, even
 *        if they are idle, unless {@code allowCoreThreadTimeOut} is set
 * @param threadFactory the factory to use when the executor
 *        creates a new thread
 * @throws java.lang.IllegalArgumentException if {@code corePoolSize < 0}
 * @throws java.lang.NullPointerException if {@code threadFactory} is null
 * @apiSince 1
 */

public ScheduledThreadPoolExecutor(int corePoolSize, java.util.concurrent.ThreadFactory threadFactory) { super(0, 0, 0, (java.util.concurrent.TimeUnit)null, (java.util.concurrent.BlockingQueue)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@code ScheduledThreadPoolExecutor} with the
 * given initial parameters.
 *
 * @param corePoolSize the number of threads to keep in the pool, even
 *        if they are idle, unless {@code allowCoreThreadTimeOut} is set
 * @param handler the handler to use when execution is blocked
 *        because the thread bounds and queue capacities are reached
 * @throws java.lang.IllegalArgumentException if {@code corePoolSize < 0}
 * @throws java.lang.NullPointerException if {@code handler} is null
 * @apiSince 1
 */

public ScheduledThreadPoolExecutor(int corePoolSize, java.util.concurrent.RejectedExecutionHandler handler) { super(0, 0, 0, (java.util.concurrent.TimeUnit)null, (java.util.concurrent.BlockingQueue)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@code ScheduledThreadPoolExecutor} with the
 * given initial parameters.
 *
 * @param corePoolSize the number of threads to keep in the pool, even
 *        if they are idle, unless {@code allowCoreThreadTimeOut} is set
 * @param threadFactory the factory to use when the executor
 *        creates a new thread
 * @param handler the handler to use when execution is blocked
 *        because the thread bounds and queue capacities are reached
 * @throws java.lang.IllegalArgumentException if {@code corePoolSize < 0}
 * @throws java.lang.NullPointerException if {@code threadFactory} or
 *         {@code handler} is null
 * @apiSince 1
 */

public ScheduledThreadPoolExecutor(int corePoolSize, java.util.concurrent.ThreadFactory threadFactory, java.util.concurrent.RejectedExecutionHandler handler) { super(0, 0, 0, (java.util.concurrent.TimeUnit)null, (java.util.concurrent.BlockingQueue)null); throw new RuntimeException("Stub!"); }

/**
 * Modifies or replaces the task used to execute a runnable.
 * This method can be used to override the concrete
 * class used for managing internal tasks.
 * The default implementation simply returns the given task.
 *
 * @param runnable the submitted Runnable
 * @param task the task created to execute the runnable
 * @param <V> the type of the task's result
 * @return a task that can execute the runnable
 * @since 1.6
 * @apiSince 9
 */

protected <V> java.util.concurrent.RunnableScheduledFuture<V> decorateTask(java.lang.Runnable runnable, java.util.concurrent.RunnableScheduledFuture<V> task) { throw new RuntimeException("Stub!"); }

/**
 * Modifies or replaces the task used to execute a callable.
 * This method can be used to override the concrete
 * class used for managing internal tasks.
 * The default implementation simply returns the given task.
 *
 * @param callable the submitted Callable
 * @param task the task created to execute the callable
 * @param <V> the type of the task's result
 * @return a task that can execute the callable
 * @since 1.6
 * @apiSince 9
 */

protected <V> java.util.concurrent.RunnableScheduledFuture<V> decorateTask(java.util.concurrent.Callable<V> callable, java.util.concurrent.RunnableScheduledFuture<V> task) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.util.concurrent.RejectedExecutionException {@inheritDoc}
 * @throws java.lang.NullPointerException       {@inheritDoc}
 * @apiSince 1
 */

public java.util.concurrent.ScheduledFuture<?> schedule(java.lang.Runnable command, long delay, java.util.concurrent.TimeUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.util.concurrent.RejectedExecutionException {@inheritDoc}
 * @throws java.lang.NullPointerException       {@inheritDoc}
 * @apiSince 1
 */

public <V> java.util.concurrent.ScheduledFuture<V> schedule(java.util.concurrent.Callable<V> callable, long delay, java.util.concurrent.TimeUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.util.concurrent.RejectedExecutionException {@inheritDoc}
 * @throws java.lang.NullPointerException       {@inheritDoc}
 * @throws java.lang.IllegalArgumentException   {@inheritDoc}
 * @apiSince 1
 */

public java.util.concurrent.ScheduledFuture<?> scheduleAtFixedRate(java.lang.Runnable command, long initialDelay, long period, java.util.concurrent.TimeUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.util.concurrent.RejectedExecutionException {@inheritDoc}
 * @throws java.lang.NullPointerException       {@inheritDoc}
 * @throws java.lang.IllegalArgumentException   {@inheritDoc}
 * @apiSince 1
 */

public java.util.concurrent.ScheduledFuture<?> scheduleWithFixedDelay(java.lang.Runnable command, long initialDelay, long delay, java.util.concurrent.TimeUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * Executes {@code command} with zero required delay.
 * This has effect equivalent to
 * {@link #schedule(java.lang.Runnable,long,java.util.concurrent.TimeUnit) schedule(command, 0, anyUnit)}.
 * Note that inspections of the queue and of the list returned by
 * {@code shutdownNow} will access the zero-delayed
 * {@link java.util.concurrent.ScheduledFuture ScheduledFuture}, not the {@code command} itself.
 *
 * <p>A consequence of the use of {@code ScheduledFuture} objects is
 * that {@link java.util.concurrent.ThreadPoolExecutor#afterExecute ThreadPoolExecutor#afterExecute} is always
 * called with a null second {@code Throwable} argument, even if the
 * {@code command} terminated abruptly.  Instead, the {@code Throwable}
 * thrown by such a task can be obtained via {@link java.util.concurrent.Future#get Future#get}.
 *
 * @throws java.util.concurrent.RejectedExecutionException at discretion of
 *         {@code RejectedExecutionHandler}, if the task
 *         cannot be accepted for execution because the
 *         executor has been shut down
 * @throws java.lang.NullPointerException {@inheritDoc}
 * @apiSince 1
 */

public void execute(java.lang.Runnable command) { throw new RuntimeException("Stub!"); }

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

/**
 * Sets the policy on whether to continue executing existing
 * periodic tasks even when this executor has been {@code shutdown}.
 * In this case, these tasks will only terminate upon
 * {@code shutdownNow} or after setting the policy to
 * {@code false} when already shutdown.
 * This value is by default {@code false}.
 *
 * @param value if {@code true}, continue after shutdown, else don't
 * @see #getContinueExistingPeriodicTasksAfterShutdownPolicy
 * @apiSince 1
 */

public void setContinueExistingPeriodicTasksAfterShutdownPolicy(boolean value) { throw new RuntimeException("Stub!"); }

/**
 * Gets the policy on whether to continue executing existing
 * periodic tasks even when this executor has been {@code shutdown}.
 * In this case, these tasks will only terminate upon
 * {@code shutdownNow} or after setting the policy to
 * {@code false} when already shutdown.
 * This value is by default {@code false}.
 *
 * @return {@code true} if will continue after shutdown
 * @see #setContinueExistingPeriodicTasksAfterShutdownPolicy
 * @apiSince 1
 */

public boolean getContinueExistingPeriodicTasksAfterShutdownPolicy() { throw new RuntimeException("Stub!"); }

/**
 * Sets the policy on whether to execute existing delayed
 * tasks even when this executor has been {@code shutdown}.
 * In this case, these tasks will only terminate upon
 * {@code shutdownNow}, or after setting the policy to
 * {@code false} when already shutdown.
 * This value is by default {@code true}.
 *
 * @param value if {@code true}, execute after shutdown, else don't
 * @see #getExecuteExistingDelayedTasksAfterShutdownPolicy
 * @apiSince 1
 */

public void setExecuteExistingDelayedTasksAfterShutdownPolicy(boolean value) { throw new RuntimeException("Stub!"); }

/**
 * Gets the policy on whether to execute existing delayed
 * tasks even when this executor has been {@code shutdown}.
 * In this case, these tasks will only terminate upon
 * {@code shutdownNow}, or after setting the policy to
 * {@code false} when already shutdown.
 * This value is by default {@code true}.
 *
 * @return {@code true} if will execute after shutdown
 * @see #setExecuteExistingDelayedTasksAfterShutdownPolicy
 * @apiSince 1
 */

public boolean getExecuteExistingDelayedTasksAfterShutdownPolicy() { throw new RuntimeException("Stub!"); }

/**
 * Sets the policy on whether cancelled tasks should be immediately
 * removed from the work queue at time of cancellation.  This value is
 * by default {@code false}.
 *
 * @param value if {@code true}, remove on cancellation, else don't
 * @see #getRemoveOnCancelPolicy
 * @since 1.7
 * @apiSince 21
 */

public void setRemoveOnCancelPolicy(boolean value) { throw new RuntimeException("Stub!"); }

/**
 * Gets the policy on whether cancelled tasks should be immediately
 * removed from the work queue at time of cancellation.  This value is
 * by default {@code false}.
 *
 * @return {@code true} if cancelled tasks are immediately removed
 *         from the queue
 * @see #setRemoveOnCancelPolicy
 * @since 1.7
 * @apiSince 21
 */

public boolean getRemoveOnCancelPolicy() { throw new RuntimeException("Stub!"); }

/**
 * Initiates an orderly shutdown in which previously submitted
 * tasks are executed, but no new tasks will be accepted.
 * Invocation has no additional effect if already shut down.
 *
 * <p>This method does not wait for previously submitted tasks to
 * complete execution.  Use {@link #awaitTermination awaitTermination}
 * to do that.
 *
 * <p>If the {@code ExecuteExistingDelayedTasksAfterShutdownPolicy}
 * has been set {@code false}, existing delayed tasks whose delays
 * have not yet elapsed are cancelled.  And unless the {@code
 * ContinueExistingPeriodicTasksAfterShutdownPolicy} has been set
 * {@code true}, future executions of existing periodic tasks will
 * be cancelled.
 * @apiSince 1
 */

public void shutdown() { throw new RuntimeException("Stub!"); }

/**
 * Attempts to stop all actively executing tasks, halts the
 * processing of waiting tasks, and returns a list of the tasks
 * that were awaiting execution. These tasks are drained (removed)
 * from the task queue upon return from this method.
 *
 * <p>This method does not wait for actively executing tasks to
 * terminate.  Use {@link #awaitTermination awaitTermination} to
 * do that.
 *
 * <p>There are no guarantees beyond best-effort attempts to stop
 * processing actively executing tasks.  This implementation
 * interrupts tasks via {@link java.lang.Thread#interrupt Thread#interrupt}; any task that
 * fails to respond to interrupts may never terminate.
 *
 * @return list of tasks that never commenced execution.
 *         Each element of this list is a {@link java.util.concurrent.ScheduledFuture ScheduledFuture}.
 *         For tasks submitted via one of the {@code schedule}
 *         methods, the element will be identical to the returned
 *         {@code ScheduledFuture}.  For tasks submitted using
 *         {@link #execute execute}, the element will be a
 *         zero-delay {@code ScheduledFuture}.
 * @apiSince 1
 */

public java.util.List<java.lang.Runnable> shutdownNow() { throw new RuntimeException("Stub!"); }

/**
 * Returns the task queue used by this executor.  Access to the
 * task queue is intended primarily for debugging and monitoring.
 * This queue may be in active use.  Retrieving the task queue
 * does not prevent queued tasks from executing.
 *
 * <p>Each element of this queue is a {@link java.util.concurrent.ScheduledFuture ScheduledFuture}.
 * For tasks submitted via one of the {@code schedule} methods, the
 * element will be identical to the returned {@code ScheduledFuture}.
 * For tasks submitted using {@link #execute execute}, the element
 * will be a zero-delay {@code ScheduledFuture}.
 *
 * <p>Iteration over this queue is <em>not</em> guaranteed to traverse
 * tasks in the order in which they will execute.
 *
 * @return the task queue
 * @apiSince 1
 */

public java.util.concurrent.BlockingQueue<java.lang.Runnable> getQueue() { throw new RuntimeException("Stub!"); }
}

