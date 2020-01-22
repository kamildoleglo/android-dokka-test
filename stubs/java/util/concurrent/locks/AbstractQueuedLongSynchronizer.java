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



package java.util.concurrent.locks;

import java.util.concurrent.TimeUnit;

/**
 * A version of {@link java.util.concurrent.locks.AbstractQueuedSynchronizer AbstractQueuedSynchronizer} in
 * which synchronization state is maintained as a {@code long}.
 * This class has exactly the same structure, properties, and methods
 * as {@code AbstractQueuedSynchronizer} with the exception
 * that all state-related parameters and results are defined
 * as {@code long} rather than {@code int}. This class
 * may be useful when creating synchronizers such as
 * multilevel locks and barriers that require
 * 64 bits of state.
 *
 * <p>See {@link java.util.concurrent.locks.AbstractQueuedSynchronizer AbstractQueuedSynchronizer} for usage
 * notes and examples.
 *
 * @since 1.6
 * @author Doug Lea
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class AbstractQueuedLongSynchronizer extends java.util.concurrent.locks.AbstractOwnableSynchronizer implements java.io.Serializable {

/**
 * Creates a new {@code AbstractQueuedLongSynchronizer} instance
 * with initial synchronization state of zero.
 * @apiSince 9
 */

protected AbstractQueuedLongSynchronizer() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current value of synchronization state.
 * This operation has memory semantics of a {@code volatile} read.
 * @return current state value
 * @apiSince 9
 */

protected final long getState() { throw new RuntimeException("Stub!"); }

/**
 * Sets the value of synchronization state.
 * This operation has memory semantics of a {@code volatile} write.
 * @param newState the new state value
 * @apiSince 9
 */

protected final void setState(long newState) { throw new RuntimeException("Stub!"); }

/**
 * Atomically sets synchronization state to the given updated
 * value if the current state value equals the expected value.
 * This operation has memory semantics of a {@code volatile} read
 * and write.
 *
 * @param expect the expected value
 * @param update the new value
 * @return {@code true} if successful. False return indicates that the actual
 *         value was not equal to the expected value.
 * @apiSince 9
 */

protected final boolean compareAndSetState(long expect, long update) { throw new RuntimeException("Stub!"); }

/**
 * Attempts to acquire in exclusive mode. This method should query
 * if the state of the object permits it to be acquired in the
 * exclusive mode, and if so to acquire it.
 *
 * <p>This method is always invoked by the thread performing
 * acquire.  If this method reports failure, the acquire method
 * may queue the thread, if it is not already queued, until it is
 * signalled by a release from some other thread. This can be used
 * to implement method {@link java.util.concurrent.locks.Lock#tryLock() Lock#tryLock()}.
 *
 * <p>The default
 * implementation throws {@link java.lang.UnsupportedOperationException UnsupportedOperationException}.
 *
 * @param arg the acquire argument. This value is always the one
 *        passed to an acquire method, or is the value saved on entry
 *        to a condition wait.  The value is otherwise uninterpreted
 *        and can represent anything you like.
 * @return {@code true} if successful. Upon success, this object has
 *         been acquired.
 * @throws java.lang.IllegalMonitorStateException if acquiring would place this
 *         synchronizer in an illegal state. This exception must be
 *         thrown in a consistent fashion for synchronization to work
 *         correctly.
 * @throws java.lang.UnsupportedOperationException if exclusive mode is not supported
 * @apiSince 9
 */

protected boolean tryAcquire(long arg) { throw new RuntimeException("Stub!"); }

/**
 * Attempts to set the state to reflect a release in exclusive
 * mode.
 *
 * <p>This method is always invoked by the thread performing release.
 *
 * <p>The default implementation throws
 * {@link java.lang.UnsupportedOperationException UnsupportedOperationException}.
 *
 * @param arg the release argument. This value is always the one
 *        passed to a release method, or the current state value upon
 *        entry to a condition wait.  The value is otherwise
 *        uninterpreted and can represent anything you like.
 * @return {@code true} if this object is now in a fully released
 *         state, so that any waiting threads may attempt to acquire;
 *         and {@code false} otherwise.
 * @throws java.lang.IllegalMonitorStateException if releasing would place this
 *         synchronizer in an illegal state. This exception must be
 *         thrown in a consistent fashion for synchronization to work
 *         correctly.
 * @throws java.lang.UnsupportedOperationException if exclusive mode is not supported
 * @apiSince 9
 */

protected boolean tryRelease(long arg) { throw new RuntimeException("Stub!"); }

/**
 * Attempts to acquire in shared mode. This method should query if
 * the state of the object permits it to be acquired in the shared
 * mode, and if so to acquire it.
 *
 * <p>This method is always invoked by the thread performing
 * acquire.  If this method reports failure, the acquire method
 * may queue the thread, if it is not already queued, until it is
 * signalled by a release from some other thread.
 *
 * <p>The default implementation throws {@link java.lang.UnsupportedOperationException UnsupportedOperationException}.
 *
 * @param arg the acquire argument. This value is always the one
 *        passed to an acquire method, or is the value saved on entry
 *        to a condition wait.  The value is otherwise uninterpreted
 *        and can represent anything you like.
 * @return a negative value on failure; zero if acquisition in shared
 *         mode succeeded but no subsequent shared-mode acquire can
 *         succeed; and a positive value if acquisition in shared
 *         mode succeeded and subsequent shared-mode acquires might
 *         also succeed, in which case a subsequent waiting thread
 *         must check availability. (Support for three different
 *         return values enables this method to be used in contexts
 *         where acquires only sometimes act exclusively.)  Upon
 *         success, this object has been acquired.
 * @throws java.lang.IllegalMonitorStateException if acquiring would place this
 *         synchronizer in an illegal state. This exception must be
 *         thrown in a consistent fashion for synchronization to work
 *         correctly.
 * @throws java.lang.UnsupportedOperationException if shared mode is not supported
 * @apiSince 9
 */

protected long tryAcquireShared(long arg) { throw new RuntimeException("Stub!"); }

/**
 * Attempts to set the state to reflect a release in shared mode.
 *
 * <p>This method is always invoked by the thread performing release.
 *
 * <p>The default implementation throws
 * {@link java.lang.UnsupportedOperationException UnsupportedOperationException}.
 *
 * @param arg the release argument. This value is always the one
 *        passed to a release method, or the current state value upon
 *        entry to a condition wait.  The value is otherwise
 *        uninterpreted and can represent anything you like.
 * @return {@code true} if this release of shared mode may permit a
 *         waiting acquire (shared or exclusive) to succeed; and
 *         {@code false} otherwise
 * @throws java.lang.IllegalMonitorStateException if releasing would place this
 *         synchronizer in an illegal state. This exception must be
 *         thrown in a consistent fashion for synchronization to work
 *         correctly.
 * @throws java.lang.UnsupportedOperationException if shared mode is not supported
 * @apiSince 9
 */

protected boolean tryReleaseShared(long arg) { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if synchronization is held exclusively with
 * respect to the current (calling) thread.  This method is invoked
 * upon each call to a non-waiting {@link java.util.concurrent.locks.AbstractQueuedLongSynchronizer.ConditionObject ConditionObject} method.
 * (Waiting methods instead invoke {@link #release}.)
 *
 * <p>The default implementation throws {@link java.lang.UnsupportedOperationException UnsupportedOperationException}. This method is invoked
 * internally only within {@link java.util.concurrent.locks.AbstractQueuedLongSynchronizer.ConditionObject ConditionObject} methods, so need
 * not be defined if conditions are not used.
 *
 * @return {@code true} if synchronization is held exclusively;
 *         {@code false} otherwise
 * @throws java.lang.UnsupportedOperationException if conditions are not supported
 * @apiSince 9
 */

protected boolean isHeldExclusively() { throw new RuntimeException("Stub!"); }

/**
 * Acquires in exclusive mode, ignoring interrupts.  Implemented
 * by invoking at least once {@link #tryAcquire},
 * returning on success.  Otherwise the thread is queued, possibly
 * repeatedly blocking and unblocking, invoking {@link
 * #tryAcquire} until success.  This method can be used
 * to implement method {@link java.util.concurrent.locks.Lock#lock Lock#lock}.
 *
 * @param arg the acquire argument.  This value is conveyed to
 *        {@link #tryAcquire} but is otherwise uninterpreted and
 *        can represent anything you like.
 * @apiSince 9
 */

public final void acquire(long arg) { throw new RuntimeException("Stub!"); }

/**
 * Acquires in exclusive mode, aborting if interrupted.
 * Implemented by first checking interrupt status, then invoking
 * at least once {@link #tryAcquire}, returning on
 * success.  Otherwise the thread is queued, possibly repeatedly
 * blocking and unblocking, invoking {@link #tryAcquire}
 * until success or the thread is interrupted.  This method can be
 * used to implement method {@link java.util.concurrent.locks.Lock#lockInterruptibly Lock#lockInterruptibly}.
 *
 * @param arg the acquire argument.  This value is conveyed to
 *        {@link #tryAcquire} but is otherwise uninterpreted and
 *        can represent anything you like.
 * @throws java.lang.InterruptedException if the current thread is interrupted
 * @apiSince 9
 */

public final void acquireInterruptibly(long arg) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * Attempts to acquire in exclusive mode, aborting if interrupted,
 * and failing if the given timeout elapses.  Implemented by first
 * checking interrupt status, then invoking at least once {@link
 * #tryAcquire}, returning on success.  Otherwise, the thread is
 * queued, possibly repeatedly blocking and unblocking, invoking
 * {@link #tryAcquire} until success or the thread is interrupted
 * or the timeout elapses.  This method can be used to implement
 * method {@link java.util.concurrent.locks.Lock#tryLock(long,java.util.concurrent.TimeUnit) Lock#tryLock(long, TimeUnit)}.
 *
 * @param arg the acquire argument.  This value is conveyed to
 *        {@link #tryAcquire} but is otherwise uninterpreted and
 *        can represent anything you like.
 * @param nanosTimeout the maximum number of nanoseconds to wait
 * @return {@code true} if acquired; {@code false} if timed out
 * @throws java.lang.InterruptedException if the current thread is interrupted
 * @apiSince 9
 */

public final boolean tryAcquireNanos(long arg, long nanosTimeout) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * Releases in exclusive mode.  Implemented by unblocking one or
 * more threads if {@link #tryRelease} returns true.
 * This method can be used to implement method {@link java.util.concurrent.locks.Lock#unlock Lock#unlock}.
 *
 * @param arg the release argument.  This value is conveyed to
 *        {@link #tryRelease} but is otherwise uninterpreted and
 *        can represent anything you like.
 * @return the value returned from {@link #tryRelease}
 * @apiSince 9
 */

public final boolean release(long arg) { throw new RuntimeException("Stub!"); }

/**
 * Acquires in shared mode, ignoring interrupts.  Implemented by
 * first invoking at least once {@link #tryAcquireShared},
 * returning on success.  Otherwise the thread is queued, possibly
 * repeatedly blocking and unblocking, invoking {@link
 * #tryAcquireShared} until success.
 *
 * @param arg the acquire argument.  This value is conveyed to
 *        {@link #tryAcquireShared} but is otherwise uninterpreted
 *        and can represent anything you like.
 * @apiSince 9
 */

public final void acquireShared(long arg) { throw new RuntimeException("Stub!"); }

/**
 * Acquires in shared mode, aborting if interrupted.  Implemented
 * by first checking interrupt status, then invoking at least once
 * {@link #tryAcquireShared}, returning on success.  Otherwise the
 * thread is queued, possibly repeatedly blocking and unblocking,
 * invoking {@link #tryAcquireShared} until success or the thread
 * is interrupted.
 * @param arg the acquire argument.
 * This value is conveyed to {@link #tryAcquireShared} but is
 * otherwise uninterpreted and can represent anything
 * you like.
 * @throws java.lang.InterruptedException if the current thread is interrupted
 * @apiSince 9
 */

public final void acquireSharedInterruptibly(long arg) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * Attempts to acquire in shared mode, aborting if interrupted, and
 * failing if the given timeout elapses.  Implemented by first
 * checking interrupt status, then invoking at least once {@link
 * #tryAcquireShared}, returning on success.  Otherwise, the
 * thread is queued, possibly repeatedly blocking and unblocking,
 * invoking {@link #tryAcquireShared} until success or the thread
 * is interrupted or the timeout elapses.
 *
 * @param arg the acquire argument.  This value is conveyed to
 *        {@link #tryAcquireShared} but is otherwise uninterpreted
 *        and can represent anything you like.
 * @param nanosTimeout the maximum number of nanoseconds to wait
 * @return {@code true} if acquired; {@code false} if timed out
 * @throws java.lang.InterruptedException if the current thread is interrupted
 * @apiSince 9
 */

public final boolean tryAcquireSharedNanos(long arg, long nanosTimeout) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * Releases in shared mode.  Implemented by unblocking one or more
 * threads if {@link #tryReleaseShared} returns true.
 *
 * @param arg the release argument.  This value is conveyed to
 *        {@link #tryReleaseShared} but is otherwise uninterpreted
 *        and can represent anything you like.
 * @return the value returned from {@link #tryReleaseShared}
 * @apiSince 9
 */

public final boolean releaseShared(long arg) { throw new RuntimeException("Stub!"); }

/**
 * Queries whether any threads are waiting to acquire. Note that
 * because cancellations due to interrupts and timeouts may occur
 * at any time, a {@code true} return does not guarantee that any
 * other thread will ever acquire.
 *
 * <p>In this implementation, this operation returns in
 * constant time.
 *
 * @return {@code true} if there may be other threads waiting to acquire
 * @apiSince 9
 */

public final boolean hasQueuedThreads() { throw new RuntimeException("Stub!"); }

/**
 * Queries whether any threads have ever contended to acquire this
 * synchronizer; that is, if an acquire method has ever blocked.
 *
 * <p>In this implementation, this operation returns in
 * constant time.
 *
 * @return {@code true} if there has ever been contention
 * @apiSince 9
 */

public final boolean hasContended() { throw new RuntimeException("Stub!"); }

/**
 * Returns the first (longest-waiting) thread in the queue, or
 * {@code null} if no threads are currently queued.
 *
 * <p>In this implementation, this operation normally returns in
 * constant time, but may iterate upon contention if other threads are
 * concurrently modifying the queue.
 *
 * @return the first (longest-waiting) thread in the queue, or
 *         {@code null} if no threads are currently queued
 * @apiSince 9
 */

public final java.lang.Thread getFirstQueuedThread() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the given thread is currently queued.
 *
 * <p>This implementation traverses the queue to determine
 * presence of the given thread.
 *
 * @param thread the thread
 * @return {@code true} if the given thread is on the queue
 * @throws java.lang.NullPointerException if the thread is null
 * @apiSince 9
 */

public final boolean isQueued(java.lang.Thread thread) { throw new RuntimeException("Stub!"); }

/**
 * Queries whether any threads have been waiting to acquire longer
 * than the current thread.
 *
 * <p>An invocation of this method is equivalent to (but may be
 * more efficient than):
 * <pre> {@code
 * getFirstQueuedThread() != Thread.currentThread()
 *   && hasQueuedThreads()}</pre>
 *
 * <p>Note that because cancellations due to interrupts and
 * timeouts may occur at any time, a {@code true} return does not
 * guarantee that some other thread will acquire before the current
 * thread.  Likewise, it is possible for another thread to win a
 * race to enqueue after this method has returned {@code false},
 * due to the queue being empty.
 *
 * <p>This method is designed to be used by a fair synchronizer to
 * avoid <a href="AbstractQueuedSynchronizer.html#barging">barging</a>.
 * Such a synchronizer's {@link #tryAcquire} method should return
 * {@code false}, and its {@link #tryAcquireShared} method should
 * return a negative value, if this method returns {@code true}
 * (unless this is a reentrant acquire).  For example, the {@code
 * tryAcquire} method for a fair, reentrant, exclusive mode
 * synchronizer might look like this:
 *
 * <pre> {@code
 * protected boolean tryAcquire(int arg) {
 *   if (isHeldExclusively()) {
 *     // A reentrant acquire; increment hold count
 *     return true;
 *   } else if (hasQueuedPredecessors()) {
 *     return false;
 *   } else {
 *     // try to acquire normally
 *   }
 * }}</pre>
 *
 * @return {@code true} if there is a queued thread preceding the
 *         current thread, and {@code false} if the current thread
 *         is at the head of the queue or the queue is empty
 * @since 1.7
 * @apiSince 21
 */

public final boolean hasQueuedPredecessors() { throw new RuntimeException("Stub!"); }

/**
 * Returns an estimate of the number of threads waiting to
 * acquire.  The value is only an estimate because the number of
 * threads may change dynamically while this method traverses
 * internal data structures.  This method is designed for use in
 * monitoring system state, not for synchronization control.
 *
 * @return the estimated number of threads waiting to acquire
 * @apiSince 9
 */

public final int getQueueLength() { throw new RuntimeException("Stub!"); }

/**
 * Returns a collection containing threads that may be waiting to
 * acquire.  Because the actual set of threads may change
 * dynamically while constructing this result, the returned
 * collection is only a best-effort estimate.  The elements of the
 * returned collection are in no particular order.  This method is
 * designed to facilitate construction of subclasses that provide
 * more extensive monitoring facilities.
 *
 * @return the collection of threads
 * @apiSince 9
 */

public final java.util.Collection<java.lang.Thread> getQueuedThreads() { throw new RuntimeException("Stub!"); }

/**
 * Returns a collection containing threads that may be waiting to
 * acquire in exclusive mode. This has the same properties
 * as {@link #getQueuedThreads} except that it only returns
 * those threads waiting due to an exclusive acquire.
 *
 * @return the collection of threads
 * @apiSince 9
 */

public final java.util.Collection<java.lang.Thread> getExclusiveQueuedThreads() { throw new RuntimeException("Stub!"); }

/**
 * Returns a collection containing threads that may be waiting to
 * acquire in shared mode. This has the same properties
 * as {@link #getQueuedThreads} except that it only returns
 * those threads waiting due to a shared acquire.
 *
 * @return the collection of threads
 * @apiSince 9
 */

public final java.util.Collection<java.lang.Thread> getSharedQueuedThreads() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string identifying this synchronizer, as well as its state.
 * The state, in brackets, includes the String {@code "State ="}
 * followed by the current value of {@link #getState}, and either
 * {@code "nonempty"} or {@code "empty"} depending on whether the
 * queue is empty.
 *
 * @return a string identifying this synchronizer, as well as its state
 * @apiSince 9
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Queries whether the given ConditionObject
 * uses this synchronizer as its lock.
 *
 * @param condition the condition
 * @return {@code true} if owned
 * @throws java.lang.NullPointerException if the condition is null
 * @apiSince 9
 */

public final boolean owns(java.util.concurrent.locks.AbstractQueuedLongSynchronizer.ConditionObject condition) { throw new RuntimeException("Stub!"); }

/**
 * Queries whether any threads are waiting on the given condition
 * associated with this synchronizer. Note that because timeouts
 * and interrupts may occur at any time, a {@code true} return
 * does not guarantee that a future {@code signal} will awaken
 * any threads.  This method is designed primarily for use in
 * monitoring of the system state.
 *
 * @param condition the condition
 * @return {@code true} if there are any waiting threads
 * @throws java.lang.IllegalMonitorStateException if exclusive synchronization
 *         is not held
 * @throws java.lang.IllegalArgumentException if the given condition is
 *         not associated with this synchronizer
 * @throws java.lang.NullPointerException if the condition is null
 * @apiSince 9
 */

public final boolean hasWaiters(java.util.concurrent.locks.AbstractQueuedLongSynchronizer.ConditionObject condition) { throw new RuntimeException("Stub!"); }

/**
 * Returns an estimate of the number of threads waiting on the
 * given condition associated with this synchronizer. Note that
 * because timeouts and interrupts may occur at any time, the
 * estimate serves only as an upper bound on the actual number of
 * waiters.  This method is designed for use in monitoring system
 * state, not for synchronization control.
 *
 * @param condition the condition
 * @return the estimated number of waiting threads
 * @throws java.lang.IllegalMonitorStateException if exclusive synchronization
 *         is not held
 * @throws java.lang.IllegalArgumentException if the given condition is
 *         not associated with this synchronizer
 * @throws java.lang.NullPointerException if the condition is null
 * @apiSince 9
 */

public final int getWaitQueueLength(java.util.concurrent.locks.AbstractQueuedLongSynchronizer.ConditionObject condition) { throw new RuntimeException("Stub!"); }

/**
 * Returns a collection containing those threads that may be
 * waiting on the given condition associated with this
 * synchronizer.  Because the actual set of threads may change
 * dynamically while constructing this result, the returned
 * collection is only a best-effort estimate. The elements of the
 * returned collection are in no particular order.
 *
 * @param condition the condition
 * @return the collection of threads
 * @throws java.lang.IllegalMonitorStateException if exclusive synchronization
 *         is not held
 * @throws java.lang.IllegalArgumentException if the given condition is
 *         not associated with this synchronizer
 * @throws java.lang.NullPointerException if the condition is null
 * @apiSince 9
 */

public final java.util.Collection<java.lang.Thread> getWaitingThreads(java.util.concurrent.locks.AbstractQueuedLongSynchronizer.ConditionObject condition) { throw new RuntimeException("Stub!"); }
/**
 * Condition implementation for a {@link java.util.concurrent.locks.AbstractQueuedLongSynchronizer AbstractQueuedLongSynchronizer} serving as the basis of a {@link java.util.concurrent.locks.Lock Lock} implementation.
 *
 * <p>Method documentation for this class describes mechanics,
 * not behavioral specifications from the point of view of Lock
 * and Condition users. Exported versions of this class will in
 * general need to be accompanied by documentation describing
 * condition semantics that rely on those of the associated
 * {@code AbstractQueuedLongSynchronizer}.
 *
 * <p>This class is Serializable, but all fields are transient,
 * so deserialized conditions have no waiters.
 *
 * @since 1.6
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ConditionObject implements java.util.concurrent.locks.Condition, java.io.Serializable {

/**
 * Creates a new {@code ConditionObject} instance.
 */

public ConditionObject() { throw new RuntimeException("Stub!"); }

/**
 * Moves the longest-waiting thread, if one exists, from the
 * wait queue for this condition to the wait queue for the
 * owning lock.
 *
 * @throws java.lang.IllegalMonitorStateException if {@link #isHeldExclusively}
 *         returns {@code false}
 * @apiSince 9
 */

public final void signal() { throw new RuntimeException("Stub!"); }

/**
 * Moves all threads from the wait queue for this condition to
 * the wait queue for the owning lock.
 *
 * @throws java.lang.IllegalMonitorStateException if {@link #isHeldExclusively}
 *         returns {@code false}
 * @apiSince 9
 */

public final void signalAll() { throw new RuntimeException("Stub!"); }

/**
 * Implements uninterruptible condition wait.
 * <ol>
 * <li>Save lock state returned by {@link #getState}.
 * <li>Invoke {@link #release} with saved state as argument,
 *     throwing IllegalMonitorStateException if it fails.
 * <li>Block until signalled.
 * <li>Reacquire by invoking specialized version of
 *     {@link #acquire} with saved state as argument.
 * </ol>
 * @apiSince 9
 */

public final void awaitUninterruptibly() { throw new RuntimeException("Stub!"); }

/**
 * Implements interruptible condition wait.
 * <ol>
 * <li>If current thread is interrupted, throw InterruptedException.
 * <li>Save lock state returned by {@link #getState}.
 * <li>Invoke {@link #release} with saved state as argument,
 *     throwing IllegalMonitorStateException if it fails.
 * <li>Block until signalled or interrupted.
 * <li>Reacquire by invoking specialized version of
 *     {@link #acquire} with saved state as argument.
 * <li>If interrupted while blocked in step 4, throw InterruptedException.
 * </ol>
 * @apiSince 9
 */

public final void await() throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * Implements timed condition wait.
 * <ol>
 * <li>If current thread is interrupted, throw InterruptedException.
 * <li>Save lock state returned by {@link #getState}.
 * <li>Invoke {@link #release} with saved state as argument,
 *     throwing IllegalMonitorStateException if it fails.
 * <li>Block until signalled, interrupted, or timed out.
 * <li>Reacquire by invoking specialized version of
 *     {@link #acquire} with saved state as argument.
 * <li>If interrupted while blocked in step 4, throw InterruptedException.
 * </ol>
 * @apiSince 9
 */

public final long awaitNanos(long nanosTimeout) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * Implements absolute timed condition wait.
 * <ol>
 * <li>If current thread is interrupted, throw InterruptedException.
 * <li>Save lock state returned by {@link #getState}.
 * <li>Invoke {@link #release} with saved state as argument,
 *     throwing IllegalMonitorStateException if it fails.
 * <li>Block until signalled, interrupted, or timed out.
 * <li>Reacquire by invoking specialized version of
 *     {@link #acquire} with saved state as argument.
 * <li>If interrupted while blocked in step 4, throw InterruptedException.
 * <li>If timed out while blocked in step 4, return false, else true.
 * </ol>
 * @apiSince 9
 */

public final boolean awaitUntil(java.util.Date deadline) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * Implements timed condition wait.
 * <ol>
 * <li>If current thread is interrupted, throw InterruptedException.
 * <li>Save lock state returned by {@link #getState}.
 * <li>Invoke {@link #release} with saved state as argument,
 *     throwing IllegalMonitorStateException if it fails.
 * <li>Block until signalled, interrupted, or timed out.
 * <li>Reacquire by invoking specialized version of
 *     {@link #acquire} with saved state as argument.
 * <li>If interrupted while blocked in step 4, throw InterruptedException.
 * <li>If timed out while blocked in step 4, return false, else true.
 * </ol>
 * @apiSince 9
 */

public final boolean await(long time, java.util.concurrent.TimeUnit unit) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * Queries whether any threads are waiting on this condition.
 * Implements {@link java.util.concurrent.locks.AbstractQueuedLongSynchronizer#hasWaiters(java.util.concurrent.locks.AbstractQueuedLongSynchronizer.ConditionObject) AbstractQueuedLongSynchronizer#hasWaiters(ConditionObject)}.
 *
 * @return {@code true} if there are any waiting threads
 * @throws java.lang.IllegalMonitorStateException if {@link #isHeldExclusively}
 *         returns {@code false}
 * @apiSince 9
 */

protected final boolean hasWaiters() { throw new RuntimeException("Stub!"); }

/**
 * Returns an estimate of the number of threads waiting on
 * this condition.
 * Implements {@link java.util.concurrent.locks.AbstractQueuedLongSynchronizer#getWaitQueueLength(java.util.concurrent.locks.AbstractQueuedLongSynchronizer.ConditionObject) AbstractQueuedLongSynchronizer#getWaitQueueLength(ConditionObject)}.
 *
 * @return the estimated number of waiting threads
 * @throws java.lang.IllegalMonitorStateException if {@link #isHeldExclusively}
 *         returns {@code false}
 * @apiSince 9
 */

protected final int getWaitQueueLength() { throw new RuntimeException("Stub!"); }

/**
 * Returns a collection containing those threads that may be
 * waiting on this Condition.
 * Implements {@link java.util.concurrent.locks.AbstractQueuedLongSynchronizer#getWaitingThreads(java.util.concurrent.locks.AbstractQueuedLongSynchronizer.ConditionObject) AbstractQueuedLongSynchronizer#getWaitingThreads(ConditionObject)}.
 *
 * @return the collection of threads
 * @throws java.lang.IllegalMonitorStateException if {@link #isHeldExclusively}
 *         returns {@code false}
 * @apiSince 9
 */

protected final java.util.Collection<java.lang.Thread> getWaitingThreads() { throw new RuntimeException("Stub!"); }
}

}

