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

import java.io.Serializable;

/**
 * Abstract base class for tasks that run within a {@link java.util.concurrent.ForkJoinPool ForkJoinPool}.
 * A {@code ForkJoinTask} is a thread-like entity that is much
 * lighter weight than a normal thread.  Huge numbers of tasks and
 * subtasks may be hosted by a small number of actual threads in a
 * ForkJoinPool, at the price of some usage limitations.
 *
 * <p>A "main" {@code ForkJoinTask} begins execution when it is
 * explicitly submitted to a {@link java.util.concurrent.ForkJoinPool ForkJoinPool}, or, if not already
 * engaged in a ForkJoin computation, commenced in the {@link java.util.concurrent.ForkJoinPool#commonPool() ForkJoinPool#commonPool()} via {@link #fork}, {@link #invoke}, or
 * related methods.  Once started, it will usually in turn start other
 * subtasks.  As indicated by the name of this class, many programs
 * using {@code ForkJoinTask} employ only methods {@link #fork} and
 * {@link #join}, or derivatives such as {@link
 * #invokeAll(java.util.concurrent.ForkJoinTask...) invokeAll}.  However, this class also
 * provides a number of other methods that can come into play in
 * advanced usages, as well as extension mechanics that allow support
 * of new forms of fork/join processing.
 *
 * <p>A {@code ForkJoinTask} is a lightweight form of {@link java.util.concurrent.Future Future}.
 * The efficiency of {@code ForkJoinTask}s stems from a set of
 * restrictions (that are only partially statically enforceable)
 * reflecting their main use as computational tasks calculating pure
 * functions or operating on purely isolated objects.  The primary
 * coordination mechanisms are {@link #fork}, that arranges
 * asynchronous execution, and {@link #join}, that doesn't proceed
 * until the task's result has been computed.  Computations should
 * ideally avoid {@code synchronized} methods or blocks, and should
 * minimize other blocking synchronization apart from joining other
 * tasks or using synchronizers such as Phasers that are advertised to
 * cooperate with fork/join scheduling. Subdividable tasks should also
 * not perform blocking I/O, and should ideally access variables that
 * are completely independent of those accessed by other running
 * tasks. These guidelines are loosely enforced by not permitting
 * checked exceptions such as {@code IOExceptions} to be
 * thrown. However, computations may still encounter unchecked
 * exceptions, that are rethrown to callers attempting to join
 * them. These exceptions may additionally include {@link java.util.concurrent.RejectedExecutionException RejectedExecutionException} stemming from internal resource
 * exhaustion, such as failure to allocate internal task
 * queues. Rethrown exceptions behave in the same way as regular
 * exceptions, but, when possible, contain stack traces (as displayed
 * for example using {@code ex.printStackTrace()}) of both the thread
 * that initiated the computation as well as the thread actually
 * encountering the exception; minimally only the latter.
 *
 * <p>It is possible to define and use ForkJoinTasks that may block,
 * but doing do requires three further considerations: (1) Completion
 * of few if any <em>other</em> tasks should be dependent on a task
 * that blocks on external synchronization or I/O. Event-style async
 * tasks that are never joined (for example, those subclassing {@link java.util.concurrent.CountedCompleter CountedCompleter}) often fall into this category.  (2) To minimize
 * resource impact, tasks should be small; ideally performing only the
 * (possibly) blocking action. (3) Unless the {@link java.util.concurrent.ForkJoinPool.ManagedBlocker ForkJoinPool.ManagedBlocker} API is used, or the number of possibly
 * blocked tasks is known to be less than the pool's {@link java.util.concurrent.ForkJoinPool#getParallelism ForkJoinPool#getParallelism} level, the pool cannot guarantee that
 * enough threads will be available to ensure progress or good
 * performance.
 *
 * <p>The primary method for awaiting completion and extracting
 * results of a task is {@link #join}, but there are several variants:
 * The {@link java.util.concurrent.Future#get Future#get} methods support interruptible and/or timed
 * waits for completion and report results using {@code Future}
 * conventions. Method {@link #invoke} is semantically
 * equivalent to {@code fork(); join()} but always attempts to begin
 * execution in the current thread. The "<em>quiet</em>" forms of
 * these methods do not extract results or report exceptions. These
 * may be useful when a set of tasks are being executed, and you need
 * to delay processing of results or exceptions until all complete.
 * Method {@code invokeAll} (available in multiple versions)
 * performs the most common form of parallel invocation: forking a set
 * of tasks and joining them all.
 *
 * <p>In the most typical usages, a fork-join pair act like a call
 * (fork) and return (join) from a parallel recursive function. As is
 * the case with other forms of recursive calls, returns (joins)
 * should be performed innermost-first. For example, {@code a.fork();
 * b.fork(); b.join(); a.join();} is likely to be substantially more
 * efficient than joining {@code a} before {@code b}.
 *
 * <p>The execution status of tasks may be queried at several levels
 * of detail: {@link #isDone} is true if a task completed in any way
 * (including the case where a task was cancelled without executing);
 * {@link #isCompletedNormally} is true if a task completed without
 * cancellation or encountering an exception; {@link #isCancelled} is
 * true if the task was cancelled (in which case {@link #getException}
 * returns a {@link java.util.concurrent.CancellationException}); and
 * {@link #isCompletedAbnormally} is true if a task was either
 * cancelled or encountered an exception, in which case {@link
 * #getException} will return either the encountered exception or
 * {@link java.util.concurrent.CancellationException}.
 *
 * <p>The ForkJoinTask class is not usually directly subclassed.
 * Instead, you subclass one of the abstract classes that support a
 * particular style of fork/join processing, typically {@link java.util.concurrent.RecursiveAction RecursiveAction} for most computations that do not return results,
 * {@link java.util.concurrent.RecursiveTask RecursiveTask} for those that do, and {@link java.util.concurrent.CountedCompleter CountedCompleter} for those in which completed actions trigger
 * other actions.  Normally, a concrete ForkJoinTask subclass declares
 * fields comprising its parameters, established in a constructor, and
 * then defines a {@code compute} method that somehow uses the control
 * methods supplied by this base class.
 *
 * <p>Method {@link #join} and its variants are appropriate for use
 * only when completion dependencies are acyclic; that is, the
 * parallel computation can be described as a directed acyclic graph
 * (DAG). Otherwise, executions may encounter a form of deadlock as
 * tasks cyclically wait for each other.  However, this framework
 * supports other methods and techniques (for example the use of
 * {@link java.util.concurrent.Phaser Phaser}, {@link #helpQuiesce}, and {@link #complete}) that
 * may be of use in constructing custom subclasses for problems that
 * are not statically structured as DAGs. To support such usages, a
 * ForkJoinTask may be atomically <em>tagged</em> with a {@code short}
 * value using {@link #setForkJoinTaskTag} or {@link
 * #compareAndSetForkJoinTaskTag} and checked using {@link
 * #getForkJoinTaskTag}. The ForkJoinTask implementation does not use
 * these {@code protected} methods or tags for any purpose, but they
 * may be of use in the construction of specialized subclasses.  For
 * example, parallel graph traversals can use the supplied methods to
 * avoid revisiting nodes/tasks that have already been processed.
 * (Method names for tagging are bulky in part to encourage definition
 * of methods that reflect their usage patterns.)
 *
 * <p>Most base support methods are {@code final}, to prevent
 * overriding of implementations that are intrinsically tied to the
 * underlying lightweight task scheduling framework.  Developers
 * creating new basic styles of fork/join processing should minimally
 * implement {@code protected} methods {@link #exec}, {@link
 * #setRawResult}, and {@link #getRawResult}, while also introducing
 * an abstract computational method that can be implemented in its
 * subclasses, possibly relying on other {@code protected} methods
 * provided by this class.
 *
 * <p>ForkJoinTasks should perform relatively small amounts of
 * computation. Large tasks should be split into smaller subtasks,
 * usually via recursive decomposition. As a very rough rule of thumb,
 * a task should perform more than 100 and less than 10000 basic
 * computational steps, and should avoid indefinite looping. If tasks
 * are too big, then parallelism cannot improve throughput. If too
 * small, then memory and internal task maintenance overhead may
 * overwhelm processing.
 *
 * <p>This class provides {@code adapt} methods for {@link java.lang.Runnable Runnable}
 * and {@link java.util.concurrent.Callable Callable}, that may be of use when mixing execution of
 * {@code ForkJoinTasks} with other kinds of tasks. When all tasks are
 * of this form, consider using a pool constructed in <em>asyncMode</em>.
 *
 * <p>ForkJoinTasks are {@code Serializable}, which enables them to be
 * used in extensions such as remote execution frameworks. It is
 * sensible to serialize tasks only before or after, but not during,
 * execution. Serialization is not relied on during execution itself.
 *
 * @since 1.7
 * @author Doug Lea
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class ForkJoinTask<V> implements java.util.concurrent.Future<V>, java.io.Serializable {

/** @apiSince 21 */

public ForkJoinTask() { throw new RuntimeException("Stub!"); }

/**
 * Arranges to asynchronously execute this task in the pool the
 * current task is running in, if applicable, or using the {@link java.util.concurrent.ForkJoinPool#commonPool() ForkJoinPool#commonPool()} if not {@link #inForkJoinPool}.  While
 * it is not necessarily enforced, it is a usage error to fork a
 * task more than once unless it has completed and been
 * reinitialized.  Subsequent modifications to the state of this
 * task or any data it operates on are not necessarily
 * consistently observable by any thread other than the one
 * executing it unless preceded by a call to {@link #join} or
 * related methods, or a call to {@link #isDone} returning {@code
 * true}.
 *
 * @return {@code this}, to simplify usage
 * @apiSince 21
 */

public final java.util.concurrent.ForkJoinTask<V> fork() { throw new RuntimeException("Stub!"); }

/**
 * Returns the result of the computation when it {@link #isDone is
 * done}.  This method differs from {@link #get()} in that
 * abnormal completion results in {@code RuntimeException} or
 * {@code Error}, not {@code ExecutionException}, and that
 * interrupts of the calling thread do <em>not</em> cause the
 * method to abruptly return by throwing {@code
 * InterruptedException}.
 *
 * @return the computed result
 * @apiSince 21
 */

public final V join() { throw new RuntimeException("Stub!"); }

/**
 * Commences performing this task, awaits its completion if
 * necessary, and returns its result, or throws an (unchecked)
 * {@code RuntimeException} or {@code Error} if the underlying
 * computation did so.
 *
 * @return the computed result
 * @apiSince 21
 */

public final V invoke() { throw new RuntimeException("Stub!"); }

/**
 * Forks the given tasks, returning when {@code isDone} holds for
 * each task or an (unchecked) exception is encountered, in which
 * case the exception is rethrown. If more than one task
 * encounters an exception, then this method throws any one of
 * these exceptions. If any task encounters an exception, the
 * other may be cancelled. However, the execution status of
 * individual tasks is not guaranteed upon exceptional return. The
 * status of each task may be obtained using {@link
 * #getException()} and related methods to check if they have been
 * cancelled, completed normally or exceptionally, or left
 * unprocessed.
 *
 * @param t1 the first task
 * @param t2 the second task
 * @throws java.lang.NullPointerException if any task is null
 * @apiSince 21
 */

public static void invokeAll(java.util.concurrent.ForkJoinTask<?> t1, java.util.concurrent.ForkJoinTask<?> t2) { throw new RuntimeException("Stub!"); }

/**
 * Forks the given tasks, returning when {@code isDone} holds for
 * each task or an (unchecked) exception is encountered, in which
 * case the exception is rethrown. If more than one task
 * encounters an exception, then this method throws any one of
 * these exceptions. If any task encounters an exception, others
 * may be cancelled. However, the execution status of individual
 * tasks is not guaranteed upon exceptional return. The status of
 * each task may be obtained using {@link #getException()} and
 * related methods to check if they have been cancelled, completed
 * normally or exceptionally, or left unprocessed.
 *
 * @param tasks the tasks
 * @throws java.lang.NullPointerException if any task is null
 * @apiSince 21
 */

public static void invokeAll(java.util.concurrent.ForkJoinTask<?>... tasks) { throw new RuntimeException("Stub!"); }

/**
 * Forks all tasks in the specified collection, returning when
 * {@code isDone} holds for each task or an (unchecked) exception
 * is encountered, in which case the exception is rethrown. If
 * more than one task encounters an exception, then this method
 * throws any one of these exceptions. If any task encounters an
 * exception, others may be cancelled. However, the execution
 * status of individual tasks is not guaranteed upon exceptional
 * return. The status of each task may be obtained using {@link
 * #getException()} and related methods to check if they have been
 * cancelled, completed normally or exceptionally, or left
 * unprocessed.
 *
 * @param tasks the collection of tasks
 * @param <T> the type of the values returned from the tasks
 * @return the tasks argument, to simplify usage
 * @throws java.lang.NullPointerException if tasks or any element are null
 * @apiSince 21
 */

public static <T extends java.util.concurrent.ForkJoinTask<?>> java.util.Collection<T> invokeAll(java.util.Collection<T> tasks) { throw new RuntimeException("Stub!"); }

/**
 * Attempts to cancel execution of this task. This attempt will
 * fail if the task has already completed or could not be
 * cancelled for some other reason. If successful, and this task
 * has not started when {@code cancel} is called, execution of
 * this task is suppressed. After this method returns
 * successfully, unless there is an intervening call to {@link
 * #reinitialize}, subsequent calls to {@link #isCancelled},
 * {@link #isDone}, and {@code cancel} will return {@code true}
 * and calls to {@link #join} and related methods will result in
 * {@code CancellationException}.
 *
 * <p>This method may be overridden in subclasses, but if so, must
 * still ensure that these properties hold. In particular, the
 * {@code cancel} method itself must not throw exceptions.
 *
 * <p>This method is designed to be invoked by <em>other</em>
 * tasks. To terminate the current task, you can just return or
 * throw an unchecked exception from its computation method, or
 * invoke {@link #completeExceptionally(java.lang.Throwable)}.
 *
 * @param mayInterruptIfRunning this value has no effect in the
 * default implementation because interrupts are not used to
 * control cancellation.
 *
 * @return {@code true} if this task is now cancelled
 * @apiSince 21
 */

public boolean cancel(boolean mayInterruptIfRunning) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public final boolean isDone() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public final boolean isCancelled() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this task threw an exception or was cancelled.
 *
 * @return {@code true} if this task threw an exception or was cancelled
 * @apiSince 21
 */

public final boolean isCompletedAbnormally() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this task completed without throwing an
 * exception and was not cancelled.
 *
 * @return {@code true} if this task completed without throwing an
 * exception and was not cancelled
 * @apiSince 21
 */

public final boolean isCompletedNormally() { throw new RuntimeException("Stub!"); }

/**
 * Returns the exception thrown by the base computation, or a
 * {@code CancellationException} if cancelled, or {@code null} if
 * none or if the method has not yet completed.
 *
 * @return the exception, or {@code null} if none
 * @apiSince 21
 */

public final java.lang.Throwable getException() { throw new RuntimeException("Stub!"); }

/**
 * Completes this task abnormally, and if not already aborted or
 * cancelled, causes it to throw the given exception upon
 * {@code join} and related operations. This method may be used
 * to induce exceptions in asynchronous tasks, or to force
 * completion of tasks that would not otherwise complete.  Its use
 * in other situations is discouraged.  This method is
 * overridable, but overridden versions must invoke {@code super}
 * implementation to maintain guarantees.
 *
 * @param ex the exception to throw. If this exception is not a
 * {@code RuntimeException} or {@code Error}, the actual exception
 * thrown will be a {@code RuntimeException} with cause {@code ex}.
 * @apiSince 21
 */

public void completeExceptionally(java.lang.Throwable ex) { throw new RuntimeException("Stub!"); }

/**
 * Completes this task, and if not already aborted or cancelled,
 * returning the given value as the result of subsequent
 * invocations of {@code join} and related operations. This method
 * may be used to provide results for asynchronous tasks, or to
 * provide alternative handling for tasks that would not otherwise
 * complete normally. Its use in other situations is
 * discouraged. This method is overridable, but overridden
 * versions must invoke {@code super} implementation to maintain
 * guarantees.
 *
 * @param value the result value for this task
 * @apiSince 21
 */

public void complete(V value) { throw new RuntimeException("Stub!"); }

/**
 * Completes this task normally without setting a value. The most
 * recent value established by {@link #setRawResult} (or {@code
 * null} by default) will be returned as the result of subsequent
 * invocations of {@code join} and related operations.
 *
 * @since 1.8
 * @apiSince 24
 */

public final void quietlyComplete() { throw new RuntimeException("Stub!"); }

/**
 * Waits if necessary for the computation to complete, and then
 * retrieves its result.
 *
 * @return the computed result
 * @throws java.util.concurrent.CancellationException if the computation was cancelled
 * @throws java.util.concurrent.ExecutionException if the computation threw an
 * exception
 * @throws java.lang.InterruptedException if the current thread is not a
 * member of a ForkJoinPool and was interrupted while waiting
 * @apiSince 21
 */

public final V get() throws java.util.concurrent.ExecutionException, java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * Waits if necessary for at most the given time for the computation
 * to complete, and then retrieves its result, if available.
 *
 * @param timeout the maximum time to wait
 * @param unit the time unit of the timeout argument
 * @return the computed result
 * @throws java.util.concurrent.CancellationException if the computation was cancelled
 * @throws java.util.concurrent.ExecutionException if the computation threw an
 * exception
 * @throws java.lang.InterruptedException if the current thread is not a
 * member of a ForkJoinPool and was interrupted while waiting
 * @throws java.util.concurrent.TimeoutException if the wait timed out
 * @apiSince 21
 */

public final V get(long timeout, java.util.concurrent.TimeUnit unit) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException, java.util.concurrent.TimeoutException { throw new RuntimeException("Stub!"); }

/**
 * Joins this task, without returning its result or throwing its
 * exception. This method may be useful when processing
 * collections of tasks when some have been cancelled or otherwise
 * known to have aborted.
 * @apiSince 21
 */

public final void quietlyJoin() { throw new RuntimeException("Stub!"); }

/**
 * Commences performing this task and awaits its completion if
 * necessary, without returning its result or throwing its
 * exception.
 * @apiSince 21
 */

public final void quietlyInvoke() { throw new RuntimeException("Stub!"); }

/**
 * Possibly executes tasks until the pool hosting the current task
 * {@linkplain java.util.concurrent.ForkJoinPool#isQuiescent ForkJoinPool#isQuiescent}.  This
 * method may be of use in designs in which many tasks are forked,
 * but none are explicitly joined, instead executing them until
 * all are processed.
 * @apiSince 21
 */

public static void helpQuiesce() { throw new RuntimeException("Stub!"); }

/**
 * Resets the internal bookkeeping state of this task, allowing a
 * subsequent {@code fork}. This method allows repeated reuse of
 * this task, but only if reuse occurs when this task has either
 * never been forked, or has been forked, then completed and all
 * outstanding joins of this task have also completed. Effects
 * under any other usage conditions are not guaranteed.
 * This method may be useful when executing
 * pre-constructed trees of subtasks in loops.
 *
 * <p>Upon completion of this method, {@code isDone()} reports
 * {@code false}, and {@code getException()} reports {@code
 * null}. However, the value returned by {@code getRawResult} is
 * unaffected. To clear this value, you can invoke {@code
 * setRawResult(null)}.
 * @apiSince 21
 */

public void reinitialize() { throw new RuntimeException("Stub!"); }

/**
 * Returns the pool hosting the current thread, or {@code null}
 * if the current thread is executing outside of any ForkJoinPool.
 *
 * <p>This method returns {@code null} if and only if {@link
 * #inForkJoinPool} returns {@code false}.
 *
 * @return the pool, or {@code null} if none
 * @apiSince 21
 */

public static java.util.concurrent.ForkJoinPool getPool() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the current thread is a {@link java.util.concurrent.ForkJoinWorkerThread ForkJoinWorkerThread} executing as a ForkJoinPool computation.
 *
 * @return {@code true} if the current thread is a {@link java.util.concurrent.ForkJoinWorkerThread ForkJoinWorkerThread} executing as a ForkJoinPool computation,
 * or {@code false} otherwise
 * @apiSince 21
 */

public static boolean inForkJoinPool() { throw new RuntimeException("Stub!"); }

/**
 * Tries to unschedule this task for execution. This method will
 * typically (but is not guaranteed to) succeed if this task is
 * the most recently forked task by the current thread, and has
 * not commenced executing in another thread.  This method may be
 * useful when arranging alternative local processing of tasks
 * that could have been, but were not, stolen.
 *
 * @return {@code true} if unforked
 * @apiSince 21
 */

public boolean tryUnfork() { throw new RuntimeException("Stub!"); }

/**
 * Returns an estimate of the number of tasks that have been
 * forked by the current worker thread but not yet executed. This
 * value may be useful for heuristic decisions about whether to
 * fork other tasks.
 *
 * @return the number of tasks
 * @apiSince 21
 */

public static int getQueuedTaskCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns an estimate of how many more locally queued tasks are
 * held by the current worker thread than there are other worker
 * threads that might steal them, or zero if this thread is not
 * operating in a ForkJoinPool. This value may be useful for
 * heuristic decisions about whether to fork other tasks. In many
 * usages of ForkJoinTasks, at steady state, each worker should
 * aim to maintain a small constant surplus (for example, 3) of
 * tasks, and to process computations locally if this threshold is
 * exceeded.
 *
 * @return the surplus number of tasks, which may be negative
 * @apiSince 21
 */

public static int getSurplusQueuedTaskCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the result that would be returned by {@link #join}, even
 * if this task completed abnormally, or {@code null} if this task
 * is not known to have been completed.  This method is designed
 * to aid debugging, as well as to support extensions. Its use in
 * any other context is discouraged.
 *
 * @return the result, or {@code null} if not completed
 * @apiSince 21
 */

public abstract V getRawResult();

/**
 * Forces the given value to be returned as a result.  This method
 * is designed to support extensions, and should not in general be
 * called otherwise.
 *
 * @param value the value
 * @apiSince 21
 */

protected abstract void setRawResult(V value);

/**
 * Immediately performs the base action of this task and returns
 * true if, upon return from this method, this task is guaranteed
 * to have completed normally. This method may return false
 * otherwise, to indicate that this task is not necessarily
 * complete (or is not known to be complete), for example in
 * asynchronous actions that require explicit invocations of
 * completion methods. This method may also throw an (unchecked)
 * exception to indicate abnormal exit. This method is designed to
 * support extensions, and should not in general be called
 * otherwise.
 *
 * @return {@code true} if this task is known to have completed normally
 * @apiSince 21
 */

protected abstract boolean exec();

/**
 * Returns, but does not unschedule or execute, a task queued by
 * the current thread but not yet executed, if one is immediately
 * available. There is no guarantee that this task will actually
 * be polled or executed next. Conversely, this method may return
 * null even if a task exists but cannot be accessed without
 * contention with other threads.  This method is designed
 * primarily to support extensions, and is unlikely to be useful
 * otherwise.
 *
 * @return the next task, or {@code null} if none are available
 * @apiSince 21
 */

protected static java.util.concurrent.ForkJoinTask<?> peekNextLocalTask() { throw new RuntimeException("Stub!"); }

/**
 * Unschedules and returns, without executing, the next task
 * queued by the current thread but not yet executed, if the
 * current thread is operating in a ForkJoinPool.  This method is
 * designed primarily to support extensions, and is unlikely to be
 * useful otherwise.
 *
 * @return the next task, or {@code null} if none are available
 * @apiSince 21
 */

protected static java.util.concurrent.ForkJoinTask<?> pollNextLocalTask() { throw new RuntimeException("Stub!"); }

/**
 * If the current thread is operating in a ForkJoinPool,
 * unschedules and returns, without executing, the next task
 * queued by the current thread but not yet executed, if one is
 * available, or if not available, a task that was forked by some
 * other thread, if available. Availability may be transient, so a
 * {@code null} result does not necessarily imply quiescence of
 * the pool this task is operating in.  This method is designed
 * primarily to support extensions, and is unlikely to be useful
 * otherwise.
 *
 * @return a task, or {@code null} if none are available
 * @apiSince 21
 */

protected static java.util.concurrent.ForkJoinTask<?> pollTask() { throw new RuntimeException("Stub!"); }

/**
 * Returns the tag for this task.
 *
 * @return the tag for this task
 * @since 1.8
 * @apiSince 24
 */

public final short getForkJoinTaskTag() { throw new RuntimeException("Stub!"); }

/**
 * Atomically sets the tag value for this task and returns the old value.
 *
 * @param newValue the new tag value
 * @return the previous value of the tag
 * @since 1.8
 * @apiSince 24
 */

public final short setForkJoinTaskTag(short newValue) { throw new RuntimeException("Stub!"); }

/**
 * Atomically conditionally sets the tag value for this task.
 * Among other applications, tags can be used as visit markers
 * in tasks operating on graphs, as in methods that check: {@code
 * if (task.compareAndSetForkJoinTaskTag((short)0, (short)1))}
 * before processing, otherwise exiting because the node has
 * already been visited.
 *
 * @param expect the expected tag value
 * @param update the new tag value
 * @return {@code true} if successful; i.e., the current value was
 * equal to {@code expect} and was changed to {@code update}.
 * @since 1.8
 * @apiSince 24
 */

public final boolean compareAndSetForkJoinTaskTag(short expect, short update) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code ForkJoinTask} that performs the {@code run}
 * method of the given {@code Runnable} as its action, and returns
 * a null result upon {@link #join}.
 *
 * @param runnable the runnable action
 * @return the task
 * @apiSince 21
 */

public static java.util.concurrent.ForkJoinTask<?> adapt(java.lang.Runnable runnable) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code ForkJoinTask} that performs the {@code run}
 * method of the given {@code Runnable} as its action, and returns
 * the given result upon {@link #join}.
 *
 * @param runnable the runnable action
 * @param result the result upon completion
 * @param <T> the type of the result
 * @return the task
 * @apiSince 21
 */

public static <T> java.util.concurrent.ForkJoinTask<T> adapt(java.lang.Runnable runnable, T result) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code ForkJoinTask} that performs the {@code call}
 * method of the given {@code Callable} as its action, and returns
 * its result upon {@link #join}, translating any checked exceptions
 * encountered into {@code RuntimeException}.
 *
 * @param callable the callable action
 * @param <T> the type of the callable's result
 * @return the task
 * @apiSince 21
 */

public static <T> java.util.concurrent.ForkJoinTask<T> adapt(java.util.concurrent.Callable<? extends T> callable) { throw new RuntimeException("Stub!"); }
}

