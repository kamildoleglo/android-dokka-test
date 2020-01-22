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

import java.util.function.Supplier;

/**
 * A {@link java.util.concurrent.Future Future} that may be explicitly completed (setting its
 * value and status), and may be used as a {@link java.util.concurrent.CompletionStage CompletionStage},
 * supporting dependent functions and actions that trigger upon its
 * completion.
 *
 * <p>When two or more threads attempt to
 * {@link #complete complete},
 * {@link #completeExceptionally completeExceptionally}, or
 * {@link #cancel cancel}
 * a CompletableFuture, only one of them succeeds.
 *
 * <p>In addition to these and related methods for directly
 * manipulating status and results, CompletableFuture implements
 * interface {@link java.util.concurrent.CompletionStage CompletionStage} with the following policies: <ul>
 *
 * <li>Actions supplied for dependent completions of
 * <em>non-async</em> methods may be performed by the thread that
 * completes the current CompletableFuture, or by any other caller of
 * a completion method.
 *
 * <li>All <em>async</em> methods without an explicit Executor
 * argument are performed using the {@link java.util.concurrent.ForkJoinPool#commonPool() ForkJoinPool#commonPool()}
 * (unless it does not support a parallelism level of at least two, in
 * which case, a new Thread is created to run each task).
 * To simplify monitoring, debugging,
 * and tracking, all generated asynchronous tasks are instances of the
 * marker interface {@link java.util.concurrent.CompletableFuture.AsynchronousCompletionTask AsynchronousCompletionTask}.  Operations
 * with time-delays can use adapter methods defined in this class, for
 * example: {@code supplyAsync(supplier, delayedExecutor(timeout,
 * timeUnit))}.  To support methods with delays and timeouts, this
 * class maintains at most one daemon thread for triggering and
 * cancelling actions, not for running them.
 *
 * <li>All CompletionStage methods are implemented independently of
 * other public methods, so the behavior of one method is not impacted
 * by overrides of others in subclasses.
 *
 * </ul>
 *
 * <p>CompletableFuture also implements {@link java.util.concurrent.Future Future} with the following
 * policies: <ul>
 *
 * <li>Since (unlike {@link java.util.concurrent.FutureTask FutureTask}) this class has no direct
 * control over the computation that causes it to be completed,
 * cancellation is treated as just another form of exceptional
 * completion.  Method {@link #cancel cancel} has the same effect as
 * {@code completeExceptionally(new CancellationException())}. Method
 * {@link #isCompletedExceptionally} can be used to determine if a
 * CompletableFuture completed in any exceptional fashion.
 *
 * <li>In case of exceptional completion with a CompletionException,
 * methods {@link #get()} and {@link #get(long,java.util.concurrent.TimeUnit)} throw an
 * {@link java.util.concurrent.ExecutionException ExecutionException} with the same cause as held in the
 * corresponding CompletionException.  To simplify usage in most
 * contexts, this class also defines methods {@link #join()} and
 * {@link #getNow} that instead throw the CompletionException directly
 * in these cases.
 * </ul>
 *
 * <p>Arguments used to pass a completion result (that is, for
 * parameters of type {@code T}) for methods accepting them may be
 * null, but passing a null value for any other parameter will result
 * in a {@link java.lang.NullPointerException NullPointerException} being thrown.
 *
 * @author Doug Lea
 * @since 1.8
 * @param <T> The result type returned by this future's {@code join}
 * and {@code get} methods
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CompletableFuture<T> implements java.util.concurrent.Future<T>, java.util.concurrent.CompletionStage<T> {

/**
 * Creates a new incomplete CompletableFuture.
 * @apiSince 24
 */

public CompletableFuture() { throw new RuntimeException("Stub!"); }

/**
 * Returns a new CompletableFuture that is asynchronously completed
 * by a task running in the {@link java.util.concurrent.ForkJoinPool#commonPool() ForkJoinPool#commonPool()} with
 * the value obtained by calling the given Supplier.
 *
 * @param supplier a function returning the value to be used
 * to complete the returned CompletableFuture
 * @param <U> the function's return type
 * @return the new CompletableFuture
 * @apiSince 24
 */

public static <U> java.util.concurrent.CompletableFuture<U> supplyAsync(java.util.function.Supplier<U> supplier) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new CompletableFuture that is asynchronously completed
 * by a task running in the given executor with the value obtained
 * by calling the given Supplier.
 *
 * @param supplier a function returning the value to be used
 * to complete the returned CompletableFuture
 * @param executor the executor to use for asynchronous execution
 * @param <U> the function's return type
 * @return the new CompletableFuture
 * @apiSince 24
 */

public static <U> java.util.concurrent.CompletableFuture<U> supplyAsync(java.util.function.Supplier<U> supplier, java.util.concurrent.Executor executor) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new CompletableFuture that is asynchronously completed
 * by a task running in the {@link java.util.concurrent.ForkJoinPool#commonPool() ForkJoinPool#commonPool()} after
 * it runs the given action.
 *
 * @param runnable the action to run before completing the
 * returned CompletableFuture
 * @return the new CompletableFuture
 * @apiSince 24
 */

public static java.util.concurrent.CompletableFuture<java.lang.Void> runAsync(java.lang.Runnable runnable) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new CompletableFuture that is asynchronously completed
 * by a task running in the given executor after it runs the given
 * action.
 *
 * @param runnable the action to run before completing the
 * returned CompletableFuture
 * @param executor the executor to use for asynchronous execution
 * @return the new CompletableFuture
 * @apiSince 24
 */

public static java.util.concurrent.CompletableFuture<java.lang.Void> runAsync(java.lang.Runnable runnable, java.util.concurrent.Executor executor) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new CompletableFuture that is already completed with
 * the given value.
 *
 * @param value the value
 * @param <U> the type of the value
 * @return the completed CompletableFuture
 * @apiSince 24
 */

public static <U> java.util.concurrent.CompletableFuture<U> completedFuture(U value) { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if completed in any fashion: normally,
 * exceptionally, or via cancellation.
 *
 * @return {@code true} if completed
 * @apiSince 24
 */

public boolean isDone() { throw new RuntimeException("Stub!"); }

/**
 * Waits if necessary for this future to complete, and then
 * returns its result.
 *
 * @return the result value
 * @throws java.util.concurrent.CancellationException if this future was cancelled
 * @throws java.util.concurrent.ExecutionException if this future completed exceptionally
 * @throws java.lang.InterruptedException if the current thread was interrupted
 * while waiting
 * @apiSince 24
 */

public T get() throws java.util.concurrent.ExecutionException, java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * Waits if necessary for at most the given time for this future
 * to complete, and then returns its result, if available.
 *
 * @param timeout the maximum time to wait
 * @param unit the time unit of the timeout argument
 * @return the result value
 * @throws java.util.concurrent.CancellationException if this future was cancelled
 * @throws java.util.concurrent.ExecutionException if this future completed exceptionally
 * @throws java.lang.InterruptedException if the current thread was interrupted
 * while waiting
 * @throws java.util.concurrent.TimeoutException if the wait timed out
 * @apiSince 24
 */

public T get(long timeout, java.util.concurrent.TimeUnit unit) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException, java.util.concurrent.TimeoutException { throw new RuntimeException("Stub!"); }

/**
 * Returns the result value when complete, or throws an
 * (unchecked) exception if completed exceptionally. To better
 * conform with the use of common functional forms, if a
 * computation involved in the completion of this
 * CompletableFuture threw an exception, this method throws an
 * (unchecked) {@link java.util.concurrent.CompletionException CompletionException} with the underlying
 * exception as its cause.
 *
 * @return the result value
 * @throws java.util.concurrent.CancellationException if the computation was cancelled
 * @throws java.util.concurrent.CompletionException if this future completed
 * exceptionally or a completion computation threw an exception
 * @apiSince 24
 */

public T join() { throw new RuntimeException("Stub!"); }

/**
 * Returns the result value (or throws any encountered exception)
 * if completed, else returns the given valueIfAbsent.
 *
 * @param valueIfAbsent the value to return if not completed
 * @return the result value, if completed, else the given valueIfAbsent
 * @throws java.util.concurrent.CancellationException if the computation was cancelled
 * @throws java.util.concurrent.CompletionException if this future completed
 * exceptionally or a completion computation threw an exception
 * @apiSince 24
 */

public T getNow(T valueIfAbsent) { throw new RuntimeException("Stub!"); }

/**
 * If not already completed, sets the value returned by {@link
 * #get()} and related methods to the given value.
 *
 * @param value the result value
 * @return {@code true} if this invocation caused this CompletableFuture
 * to transition to a completed state, else {@code false}
 * @apiSince 24
 */

public boolean complete(T value) { throw new RuntimeException("Stub!"); }

/**
 * If not already completed, causes invocations of {@link #get()}
 * and related methods to throw the given exception.
 *
 * @param ex the exception
 * @return {@code true} if this invocation caused this CompletableFuture
 * to transition to a completed state, else {@code false}
 * @apiSince 24
 */

public boolean completeExceptionally(java.lang.Throwable ex) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public <U> java.util.concurrent.CompletableFuture<U> thenApply(java.util.function.Function<? super T,? extends U> fn) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public <U> java.util.concurrent.CompletableFuture<U> thenApplyAsync(java.util.function.Function<? super T,? extends U> fn) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public <U> java.util.concurrent.CompletableFuture<U> thenApplyAsync(java.util.function.Function<? super T,? extends U> fn, java.util.concurrent.Executor executor) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public java.util.concurrent.CompletableFuture<java.lang.Void> thenAccept(java.util.function.Consumer<? super T> action) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public java.util.concurrent.CompletableFuture<java.lang.Void> thenAcceptAsync(java.util.function.Consumer<? super T> action) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public java.util.concurrent.CompletableFuture<java.lang.Void> thenAcceptAsync(java.util.function.Consumer<? super T> action, java.util.concurrent.Executor executor) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public java.util.concurrent.CompletableFuture<java.lang.Void> thenRun(java.lang.Runnable action) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public java.util.concurrent.CompletableFuture<java.lang.Void> thenRunAsync(java.lang.Runnable action) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public java.util.concurrent.CompletableFuture<java.lang.Void> thenRunAsync(java.lang.Runnable action, java.util.concurrent.Executor executor) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public <U, V> java.util.concurrent.CompletableFuture<V> thenCombine(java.util.concurrent.CompletionStage<? extends U> other, java.util.function.BiFunction<? super T,? super U,? extends V> fn) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public <U, V> java.util.concurrent.CompletableFuture<V> thenCombineAsync(java.util.concurrent.CompletionStage<? extends U> other, java.util.function.BiFunction<? super T,? super U,? extends V> fn) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public <U, V> java.util.concurrent.CompletableFuture<V> thenCombineAsync(java.util.concurrent.CompletionStage<? extends U> other, java.util.function.BiFunction<? super T,? super U,? extends V> fn, java.util.concurrent.Executor executor) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public <U> java.util.concurrent.CompletableFuture<java.lang.Void> thenAcceptBoth(java.util.concurrent.CompletionStage<? extends U> other, java.util.function.BiConsumer<? super T,? super U> action) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public <U> java.util.concurrent.CompletableFuture<java.lang.Void> thenAcceptBothAsync(java.util.concurrent.CompletionStage<? extends U> other, java.util.function.BiConsumer<? super T,? super U> action) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public <U> java.util.concurrent.CompletableFuture<java.lang.Void> thenAcceptBothAsync(java.util.concurrent.CompletionStage<? extends U> other, java.util.function.BiConsumer<? super T,? super U> action, java.util.concurrent.Executor executor) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public java.util.concurrent.CompletableFuture<java.lang.Void> runAfterBoth(java.util.concurrent.CompletionStage<?> other, java.lang.Runnable action) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public java.util.concurrent.CompletableFuture<java.lang.Void> runAfterBothAsync(java.util.concurrent.CompletionStage<?> other, java.lang.Runnable action) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public java.util.concurrent.CompletableFuture<java.lang.Void> runAfterBothAsync(java.util.concurrent.CompletionStage<?> other, java.lang.Runnable action, java.util.concurrent.Executor executor) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public <U> java.util.concurrent.CompletableFuture<U> applyToEither(java.util.concurrent.CompletionStage<? extends T> other, java.util.function.Function<? super T,U> fn) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public <U> java.util.concurrent.CompletableFuture<U> applyToEitherAsync(java.util.concurrent.CompletionStage<? extends T> other, java.util.function.Function<? super T,U> fn) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public <U> java.util.concurrent.CompletableFuture<U> applyToEitherAsync(java.util.concurrent.CompletionStage<? extends T> other, java.util.function.Function<? super T,U> fn, java.util.concurrent.Executor executor) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public java.util.concurrent.CompletableFuture<java.lang.Void> acceptEither(java.util.concurrent.CompletionStage<? extends T> other, java.util.function.Consumer<? super T> action) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public java.util.concurrent.CompletableFuture<java.lang.Void> acceptEitherAsync(java.util.concurrent.CompletionStage<? extends T> other, java.util.function.Consumer<? super T> action) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public java.util.concurrent.CompletableFuture<java.lang.Void> acceptEitherAsync(java.util.concurrent.CompletionStage<? extends T> other, java.util.function.Consumer<? super T> action, java.util.concurrent.Executor executor) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public java.util.concurrent.CompletableFuture<java.lang.Void> runAfterEither(java.util.concurrent.CompletionStage<?> other, java.lang.Runnable action) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public java.util.concurrent.CompletableFuture<java.lang.Void> runAfterEitherAsync(java.util.concurrent.CompletionStage<?> other, java.lang.Runnable action) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public java.util.concurrent.CompletableFuture<java.lang.Void> runAfterEitherAsync(java.util.concurrent.CompletionStage<?> other, java.lang.Runnable action, java.util.concurrent.Executor executor) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public <U> java.util.concurrent.CompletableFuture<U> thenCompose(java.util.function.Function<? super T,? extends java.util.concurrent.CompletionStage<U>> fn) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public <U> java.util.concurrent.CompletableFuture<U> thenComposeAsync(java.util.function.Function<? super T,? extends java.util.concurrent.CompletionStage<U>> fn) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public <U> java.util.concurrent.CompletableFuture<U> thenComposeAsync(java.util.function.Function<? super T,? extends java.util.concurrent.CompletionStage<U>> fn, java.util.concurrent.Executor executor) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public java.util.concurrent.CompletableFuture<T> whenComplete(java.util.function.BiConsumer<? super T,? super java.lang.Throwable> action) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public java.util.concurrent.CompletableFuture<T> whenCompleteAsync(java.util.function.BiConsumer<? super T,? super java.lang.Throwable> action) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public java.util.concurrent.CompletableFuture<T> whenCompleteAsync(java.util.function.BiConsumer<? super T,? super java.lang.Throwable> action, java.util.concurrent.Executor executor) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public <U> java.util.concurrent.CompletableFuture<U> handle(java.util.function.BiFunction<? super T,java.lang.Throwable,? extends U> fn) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public <U> java.util.concurrent.CompletableFuture<U> handleAsync(java.util.function.BiFunction<? super T,java.lang.Throwable,? extends U> fn) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public <U> java.util.concurrent.CompletableFuture<U> handleAsync(java.util.function.BiFunction<? super T,java.lang.Throwable,? extends U> fn, java.util.concurrent.Executor executor) { throw new RuntimeException("Stub!"); }

/**
 * Returns this CompletableFuture.
 *
 * @return this CompletableFuture
 * @apiSince 24
 */

public java.util.concurrent.CompletableFuture<T> toCompletableFuture() { throw new RuntimeException("Stub!"); }

/**
 * Returns a new CompletableFuture that is completed when this
 * CompletableFuture completes, with the result of the given
 * function of the exception triggering this CompletableFuture's
 * completion when it completes exceptionally; otherwise, if this
 * CompletableFuture completes normally, then the returned
 * CompletableFuture also completes normally with the same value.
 * Note: More flexible versions of this functionality are
 * available using methods {@code whenComplete} and {@code handle}.
 *
 * @param fn the function to use to compute the value of the
 * returned CompletableFuture if this CompletableFuture completed
 * exceptionally
 * @return the new CompletableFuture
 * @apiSince 24
 */

public java.util.concurrent.CompletableFuture<T> exceptionally(java.util.function.Function<java.lang.Throwable,? extends T> fn) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new CompletableFuture that is completed when all of
 * the given CompletableFutures complete.  If any of the given
 * CompletableFutures complete exceptionally, then the returned
 * CompletableFuture also does so, with a CompletionException
 * holding this exception as its cause.  Otherwise, the results,
 * if any, of the given CompletableFutures are not reflected in
 * the returned CompletableFuture, but may be obtained by
 * inspecting them individually. If no CompletableFutures are
 * provided, returns a CompletableFuture completed with the value
 * {@code null}.
 *
 * <p>Among the applications of this method is to await completion
 * of a set of independent CompletableFutures before continuing a
 * program, as in: {@code CompletableFuture.allOf(c1, c2,
 * c3).join();}.
 *
 * @param cfs the CompletableFutures
 * @return a new CompletableFuture that is completed when all of the
 * given CompletableFutures complete
 * @throws java.lang.NullPointerException if the array or any of its elements are
 * {@code null}
 * @apiSince 24
 */

public static java.util.concurrent.CompletableFuture<java.lang.Void> allOf(java.util.concurrent.CompletableFuture<?>... cfs) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new CompletableFuture that is completed when any of
 * the given CompletableFutures complete, with the same result.
 * Otherwise, if it completed exceptionally, the returned
 * CompletableFuture also does so, with a CompletionException
 * holding this exception as its cause.  If no CompletableFutures
 * are provided, returns an incomplete CompletableFuture.
 *
 * @param cfs the CompletableFutures
 * @return a new CompletableFuture that is completed with the
 * result or exception of any of the given CompletableFutures when
 * one completes
 * @throws java.lang.NullPointerException if the array or any of its elements are
 * {@code null}
 * @apiSince 24
 */

public static java.util.concurrent.CompletableFuture<java.lang.Object> anyOf(java.util.concurrent.CompletableFuture<?>... cfs) { throw new RuntimeException("Stub!"); }

/**
 * If not already completed, completes this CompletableFuture with
 * a {@link java.util.concurrent.CancellationException CancellationException}. Dependent CompletableFutures
 * that have not already completed will also complete
 * exceptionally, with a {@link java.util.concurrent.CompletionException CompletionException} caused by
 * this {@code CancellationException}.
 *
 * @param mayInterruptIfRunning this value has no effect in this
 * implementation because interrupts are not used to control
 * processing.
 *
 * @return {@code true} if this task is now cancelled
 * @apiSince 24
 */

public boolean cancel(boolean mayInterruptIfRunning) { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this CompletableFuture was cancelled
 * before it completed normally.
 *
 * @return {@code true} if this CompletableFuture was cancelled
 * before it completed normally
 * @apiSince 24
 */

public boolean isCancelled() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this CompletableFuture completed
 * exceptionally, in any way. Possible causes include
 * cancellation, explicit invocation of {@code
 * completeExceptionally}, and abrupt termination of a
 * CompletionStage action.
 *
 * @return {@code true} if this CompletableFuture completed
 * exceptionally
 * @apiSince 24
 */

public boolean isCompletedExceptionally() { throw new RuntimeException("Stub!"); }

/**
 * Forcibly sets or resets the value subsequently returned by
 * method {@link #get()} and related methods, whether or not
 * already completed. This method is designed for use only in
 * error recovery actions, and even in such situations may result
 * in ongoing dependent completions using established versus
 * overwritten outcomes.
 *
 * @param value the completion value
 * @apiSince 24
 */

public void obtrudeValue(T value) { throw new RuntimeException("Stub!"); }

/**
 * Forcibly causes subsequent invocations of method {@link #get()}
 * and related methods to throw the given exception, whether or
 * not already completed. This method is designed for use only in
 * error recovery actions, and even in such situations may result
 * in ongoing dependent completions using established versus
 * overwritten outcomes.
 *
 * @param ex the exception
 * @throws java.lang.NullPointerException if the exception is null
 * @apiSince 24
 */

public void obtrudeException(java.lang.Throwable ex) { throw new RuntimeException("Stub!"); }

/**
 * Returns the estimated number of CompletableFutures whose
 * completions are awaiting completion of this CompletableFuture.
 * This method is designed for use in monitoring system state, not
 * for synchronization control.
 *
 * @return the number of dependent CompletableFutures
 * @apiSince 24
 */

public int getNumberOfDependents() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string identifying this CompletableFuture, as well as
 * its completion state.  The state, in brackets, contains the
 * String {@code "Completed Normally"} or the String {@code
 * "Completed Exceptionally"}, or the String {@code "Not
 * completed"} followed by the number of CompletableFutures
 * dependent upon its completion, if any.
 *
 * @return a string identifying this CompletableFuture, as well as its state
 * @apiSince 24
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
/**
 * A marker interface identifying asynchronous tasks produced by
 * {@code async} methods. This may be useful for monitoring,
 * debugging, and tracking asynchronous activities.
 *
 * @since 1.8
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface AsynchronousCompletionTask {
}

}

