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
 * A capability-based lock with three modes for controlling read/write
 * access.  The state of a StampedLock consists of a version and mode.
 * Lock acquisition methods return a stamp that represents and
 * controls access with respect to a lock state; "try" versions of
 * these methods may instead return the special value zero to
 * represent failure to acquire access. Lock release and conversion
 * methods require stamps as arguments, and fail if they do not match
 * the state of the lock. The three modes are:
 *
 * <ul>
 *
 *  <li><b>Writing.</b> Method {@link #writeLock} possibly blocks
 *   waiting for exclusive access, returning a stamp that can be used
 *   in method {@link #unlockWrite} to release the lock. Untimed and
 *   timed versions of {@code tryWriteLock} are also provided. When
 *   the lock is held in write mode, no read locks may be obtained,
 *   and all optimistic read validations will fail.
 *
 *  <li><b>Reading.</b> Method {@link #readLock} possibly blocks
 *   waiting for non-exclusive access, returning a stamp that can be
 *   used in method {@link #unlockRead} to release the lock. Untimed
 *   and timed versions of {@code tryReadLock} are also provided.
 *
 *  <li><b>Optimistic Reading.</b> Method {@link #tryOptimisticRead}
 *   returns a non-zero stamp only if the lock is not currently held
 *   in write mode. Method {@link #validate} returns true if the lock
 *   has not been acquired in write mode since obtaining a given
 *   stamp.  This mode can be thought of as an extremely weak version
 *   of a read-lock, that can be broken by a writer at any time.  The
 *   use of optimistic mode for short read-only code segments often
 *   reduces contention and improves throughput.  However, its use is
 *   inherently fragile.  Optimistic read sections should only read
 *   fields and hold them in local variables for later use after
 *   validation. Fields read while in optimistic mode may be wildly
 *   inconsistent, so usage applies only when you are familiar enough
 *   with data representations to check consistency and/or repeatedly
 *   invoke method {@code validate()}.  For example, such steps are
 *   typically required when first reading an object or array
 *   reference, and then accessing one of its fields, elements or
 *   methods.
 *
 * </ul>
 *
 * <p>This class also supports methods that conditionally provide
 * conversions across the three modes. For example, method {@link
 * #tryConvertToWriteLock} attempts to "upgrade" a mode, returning
 * a valid write stamp if (1) already in writing mode (2) in reading
 * mode and there are no other readers or (3) in optimistic mode and
 * the lock is available. The forms of these methods are designed to
 * help reduce some of the code bloat that otherwise occurs in
 * retry-based designs.
 *
 * <p>StampedLocks are designed for use as internal utilities in the
 * development of thread-safe components. Their use relies on
 * knowledge of the internal properties of the data, objects, and
 * methods they are protecting.  They are not reentrant, so locked
 * bodies should not call other unknown methods that may try to
 * re-acquire locks (although you may pass a stamp to other methods
 * that can use or convert it).  The use of read lock modes relies on
 * the associated code sections being side-effect-free.  Unvalidated
 * optimistic read sections cannot call methods that are not known to
 * tolerate potential inconsistencies.  Stamps use finite
 * representations, and are not cryptographically secure (i.e., a
 * valid stamp may be guessable). Stamp values may recycle after (no
 * sooner than) one year of continuous operation. A stamp held without
 * use or validation for longer than this period may fail to validate
 * correctly.  StampedLocks are serializable, but always deserialize
 * into initial unlocked state, so they are not useful for remote
 * locking.
 *
 * <p>The scheduling policy of StampedLock does not consistently
 * prefer readers over writers or vice versa.  All "try" methods are
 * best-effort and do not necessarily conform to any scheduling or
 * fairness policy. A zero return from any "try" method for acquiring
 * or converting locks does not carry any information about the state
 * of the lock; a subsequent invocation may succeed.
 *
 * <p>Because it supports coordinated usage across multiple lock
 * modes, this class does not directly implement the {@link java.util.concurrent.locks.Lock Lock} or
 * {@link java.util.concurrent.locks.ReadWriteLock ReadWriteLock} interfaces. However, a StampedLock may be
 * viewed {@link #asReadLock()}, {@link #asWriteLock()}, or {@link
 * #asReadWriteLock()} in applications requiring only the associated
 * set of functionality.
 *
 * <p><b>Sample Usage.</b> The following illustrates some usage idioms
 * in a class that maintains simple two-dimensional points. The sample
 * code illustrates some try/catch conventions even though they are
 * not strictly needed here because no exceptions can occur in their
 * bodies.<br>
 *
 * <pre> {@code
 * class Point {
 *   private double x, y;
 *   private final StampedLock sl = new StampedLock();
 *
 *   void move(double deltaX, double deltaY) { // an exclusively locked method
 *     long stamp = sl.writeLock();
 *     try {
 *       x += deltaX;
 *       y += deltaY;
 *     } finally {
 *       sl.unlockWrite(stamp);
 *     }
 *   }
 *
 *   double distanceFromOrigin() { // A read-only method
 *     long stamp = sl.tryOptimisticRead();
 *     double currentX = x, currentY = y;
 *     if (!sl.validate(stamp)) {
 *        stamp = sl.readLock();
 *        try {
 *          currentX = x;
 *          currentY = y;
 *        } finally {
 *           sl.unlockRead(stamp);
 *        }
 *     }
 *     return Math.sqrt(currentX * currentX + currentY * currentY);
 *   }
 *
 *   void moveIfAtOrigin(double newX, double newY) { // upgrade
 *     // Could instead start with optimistic, not read mode
 *     long stamp = sl.readLock();
 *     try {
 *       while (x == 0.0 && y == 0.0) {
 *         long ws = sl.tryConvertToWriteLock(stamp);
 *         if (ws != 0L) {
 *           stamp = ws;
 *           x = newX;
 *           y = newY;
 *           break;
 *         }
 *         else {
 *           sl.unlockRead(stamp);
 *           stamp = sl.writeLock();
 *         }
 *       }
 *     } finally {
 *       sl.unlock(stamp);
 *     }
 *   }
 * }}</pre>
 *
 * @since 1.8
 * @author Doug Lea
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class StampedLock implements java.io.Serializable {

/**
 * Creates a new lock, initially in unlocked state.
 * @apiSince 24
 */

public StampedLock() { throw new RuntimeException("Stub!"); }

/**
 * Exclusively acquires the lock, blocking if necessary
 * until available.
 *
 * @return a stamp that can be used to unlock or convert mode
 * @apiSince 24
 */

public long writeLock() { throw new RuntimeException("Stub!"); }

/**
 * Exclusively acquires the lock if it is immediately available.
 *
 * @return a stamp that can be used to unlock or convert mode,
 * or zero if the lock is not available
 * @apiSince 24
 */

public long tryWriteLock() { throw new RuntimeException("Stub!"); }

/**
 * Exclusively acquires the lock if it is available within the
 * given time and the current thread has not been interrupted.
 * Behavior under timeout and interruption matches that specified
 * for method {@link java.util.concurrent.locks.Lock#tryLock(long,java.util.concurrent.TimeUnit) Lock#tryLock(long,TimeUnit)}.
 *
 * @param time the maximum time to wait for the lock
 * @param unit the time unit of the {@code time} argument
 * @return a stamp that can be used to unlock or convert mode,
 * or zero if the lock is not available
 * @throws java.lang.InterruptedException if the current thread is interrupted
 * before acquiring the lock
 * @apiSince 24
 */

public long tryWriteLock(long time, java.util.concurrent.TimeUnit unit) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * Exclusively acquires the lock, blocking if necessary
 * until available or the current thread is interrupted.
 * Behavior under interruption matches that specified
 * for method {@link java.util.concurrent.locks.Lock#lockInterruptibly() Lock#lockInterruptibly()}.
 *
 * @return a stamp that can be used to unlock or convert mode
 * @throws java.lang.InterruptedException if the current thread is interrupted
 * before acquiring the lock
 * @apiSince 24
 */

public long writeLockInterruptibly() throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * Non-exclusively acquires the lock, blocking if necessary
 * until available.
 *
 * @return a stamp that can be used to unlock or convert mode
 * @apiSince 24
 */

public long readLock() { throw new RuntimeException("Stub!"); }

/**
 * Non-exclusively acquires the lock if it is immediately available.
 *
 * @return a stamp that can be used to unlock or convert mode,
 * or zero if the lock is not available
 * @apiSince 24
 */

public long tryReadLock() { throw new RuntimeException("Stub!"); }

/**
 * Non-exclusively acquires the lock if it is available within the
 * given time and the current thread has not been interrupted.
 * Behavior under timeout and interruption matches that specified
 * for method {@link java.util.concurrent.locks.Lock#tryLock(long,java.util.concurrent.TimeUnit) Lock#tryLock(long,TimeUnit)}.
 *
 * @param time the maximum time to wait for the lock
 * @param unit the time unit of the {@code time} argument
 * @return a stamp that can be used to unlock or convert mode,
 * or zero if the lock is not available
 * @throws java.lang.InterruptedException if the current thread is interrupted
 * before acquiring the lock
 * @apiSince 24
 */

public long tryReadLock(long time, java.util.concurrent.TimeUnit unit) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * Non-exclusively acquires the lock, blocking if necessary
 * until available or the current thread is interrupted.
 * Behavior under interruption matches that specified
 * for method {@link java.util.concurrent.locks.Lock#lockInterruptibly() Lock#lockInterruptibly()}.
 *
 * @return a stamp that can be used to unlock or convert mode
 * @throws java.lang.InterruptedException if the current thread is interrupted
 * before acquiring the lock
 * @apiSince 24
 */

public long readLockInterruptibly() throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * Returns a stamp that can later be validated, or zero
 * if exclusively locked.
 *
 * @return a stamp, or zero if exclusively locked
 * @apiSince 24
 */

public long tryOptimisticRead() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the lock has not been exclusively acquired
 * since issuance of the given stamp. Always returns false if the
 * stamp is zero. Always returns true if the stamp represents a
 * currently held lock. Invoking this method with a value not
 * obtained from {@link #tryOptimisticRead} or a locking method
 * for this lock has no defined effect or result.
 *
 * @param stamp a stamp
 * @return {@code true} if the lock has not been exclusively acquired
 * since issuance of the given stamp; else false
 * @apiSince 24
 */

public boolean validate(long stamp) { throw new RuntimeException("Stub!"); }

/**
 * If the lock state matches the given stamp, releases the
 * exclusive lock.
 *
 * @param stamp a stamp returned by a write-lock operation
 * @throws java.lang.IllegalMonitorStateException if the stamp does
 * not match the current state of this lock
 * @apiSince 24
 */

public void unlockWrite(long stamp) { throw new RuntimeException("Stub!"); }

/**
 * If the lock state matches the given stamp, releases the
 * non-exclusive lock.
 *
 * @param stamp a stamp returned by a read-lock operation
 * @throws java.lang.IllegalMonitorStateException if the stamp does
 * not match the current state of this lock
 * @apiSince 24
 */

public void unlockRead(long stamp) { throw new RuntimeException("Stub!"); }

/**
 * If the lock state matches the given stamp, releases the
 * corresponding mode of the lock.
 *
 * @param stamp a stamp returned by a lock operation
 * @throws java.lang.IllegalMonitorStateException if the stamp does
 * not match the current state of this lock
 * @apiSince 24
 */

public void unlock(long stamp) { throw new RuntimeException("Stub!"); }

/**
 * If the lock state matches the given stamp, atomically performs one of
 * the following actions. If the stamp represents holding a write
 * lock, returns it.  Or, if a read lock, if the write lock is
 * available, releases the read lock and returns a write stamp.
 * Or, if an optimistic read, returns a write stamp only if
 * immediately available. This method returns zero in all other
 * cases.
 *
 * @param stamp a stamp
 * @return a valid write stamp, or zero on failure
 * @apiSince 24
 */

public long tryConvertToWriteLock(long stamp) { throw new RuntimeException("Stub!"); }

/**
 * If the lock state matches the given stamp, atomically performs one of
 * the following actions. If the stamp represents holding a write
 * lock, releases it and obtains a read lock.  Or, if a read lock,
 * returns it. Or, if an optimistic read, acquires a read lock and
 * returns a read stamp only if immediately available. This method
 * returns zero in all other cases.
 *
 * @param stamp a stamp
 * @return a valid read stamp, or zero on failure
 * @apiSince 24
 */

public long tryConvertToReadLock(long stamp) { throw new RuntimeException("Stub!"); }

/**
 * If the lock state matches the given stamp then, atomically, if the stamp
 * represents holding a lock, releases it and returns an
 * observation stamp.  Or, if an optimistic read, returns it if
 * validated. This method returns zero in all other cases, and so
 * may be useful as a form of "tryUnlock".
 *
 * @param stamp a stamp
 * @return a valid optimistic read stamp, or zero on failure
 * @apiSince 24
 */

public long tryConvertToOptimisticRead(long stamp) { throw new RuntimeException("Stub!"); }

/**
 * Releases the write lock if it is held, without requiring a
 * stamp value. This method may be useful for recovery after
 * errors.
 *
 * @return {@code true} if the lock was held, else false
 * @apiSince 24
 */

public boolean tryUnlockWrite() { throw new RuntimeException("Stub!"); }

/**
 * Releases one hold of the read lock if it is held, without
 * requiring a stamp value. This method may be useful for recovery
 * after errors.
 *
 * @return {@code true} if the read lock was held, else false
 * @apiSince 24
 */

public boolean tryUnlockRead() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the lock is currently held exclusively.
 *
 * @return {@code true} if the lock is currently held exclusively
 * @apiSince 24
 */

public boolean isWriteLocked() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the lock is currently held non-exclusively.
 *
 * @return {@code true} if the lock is currently held non-exclusively
 * @apiSince 24
 */

public boolean isReadLocked() { throw new RuntimeException("Stub!"); }

/**
 * Queries the number of read locks held for this lock. This
 * method is designed for use in monitoring system state, not for
 * synchronization control.
 * @return the number of read locks held
 * @apiSince 24
 */

public int getReadLockCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string identifying this lock, as well as its lock
 * state.  The state, in brackets, includes the String {@code
 * "Unlocked"} or the String {@code "Write-locked"} or the String
 * {@code "Read-locks:"} followed by the current number of
 * read-locks held.
 *
 * @return a string identifying this lock, as well as its lock state
 * @apiSince 24
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Returns a plain {@link java.util.concurrent.locks.Lock Lock} view of this StampedLock in which
 * the {@link java.util.concurrent.locks.Lock#lock Lock#lock} method is mapped to {@link #readLock},
 * and similarly for other methods. The returned Lock does not
 * support a {@link java.util.concurrent.locks.Condition Condition}; method {@link java.util.concurrent.locks.Lock#newCondition() Lock#newCondition()} throws {@code
 * UnsupportedOperationException}.
 *
 * @return the lock
 * @apiSince 24
 */

public java.util.concurrent.locks.Lock asReadLock() { throw new RuntimeException("Stub!"); }

/**
 * Returns a plain {@link java.util.concurrent.locks.Lock Lock} view of this StampedLock in which
 * the {@link java.util.concurrent.locks.Lock#lock Lock#lock} method is mapped to {@link #writeLock},
 * and similarly for other methods. The returned Lock does not
 * support a {@link java.util.concurrent.locks.Condition Condition}; method {@link java.util.concurrent.locks.Lock#newCondition() Lock#newCondition()} throws {@code
 * UnsupportedOperationException}.
 *
 * @return the lock
 * @apiSince 24
 */

public java.util.concurrent.locks.Lock asWriteLock() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.concurrent.locks.ReadWriteLock ReadWriteLock} view of this StampedLock in
 * which the {@link java.util.concurrent.locks.ReadWriteLock#readLock() ReadWriteLock#readLock()} method is mapped to
 * {@link #asReadLock()}, and {@link java.util.concurrent.locks.ReadWriteLock#writeLock() ReadWriteLock#writeLock()} to
 * {@link #asWriteLock()}.
 *
 * @return the lock
 * @apiSince 24
 */

public java.util.concurrent.locks.ReadWriteLock asReadWriteLock() { throw new RuntimeException("Stub!"); }
}

