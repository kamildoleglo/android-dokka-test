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



package java.util.concurrent.atomic;


/**
 * A reflection-based utility that enables atomic updates to
 * designated {@code volatile int} fields of designated classes.
 * This class is designed for use in atomic data structures in which
 * several fields of the same node are independently subject to atomic
 * updates.
 *
 * <p>Note that the guarantees of the {@code compareAndSet}
 * method in this class are weaker than in other atomic classes.
 * Because this class cannot ensure that all uses of the field
 * are appropriate for purposes of atomic access, it can
 * guarantee atomicity only with respect to other invocations of
 * {@code compareAndSet} and {@code set} on the same updater.
 *
 * @since 1.5
 * @author Doug Lea
 * @param <T> The type of the object holding the updatable field
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class AtomicIntegerFieldUpdater<T> {

/**
 * Protected do-nothing constructor for use by subclasses.
 * @apiSince 1
 */

protected AtomicIntegerFieldUpdater() { throw new RuntimeException("Stub!"); }

/**
 * Creates and returns an updater for objects with the given field.
 * The Class argument is needed to check that reflective types and
 * generic types match.
 *
 * @param tclass the class of the objects holding the field
 * @param fieldName the name of the field to be updated
 * @param <U> the type of instances of tclass
 * @return the updater
 * @throws java.lang.IllegalArgumentException if the field is not a
 * volatile integer type
 * @throws java.lang.RuntimeException with a nested reflection-based
 * exception if the class does not hold field or is the wrong type,
 * or the field is inaccessible to the caller according to Java language
 * access control
 * @apiSince 1
 */

public static <U> java.util.concurrent.atomic.AtomicIntegerFieldUpdater<U> newUpdater(java.lang.Class<U> tclass, java.lang.String fieldName) { throw new RuntimeException("Stub!"); }

/**
 * Atomically sets the field of the given object managed by this updater
 * to the given updated value if the current value {@code ==} the
 * expected value. This method is guaranteed to be atomic with respect to
 * other calls to {@code compareAndSet} and {@code set}, but not
 * necessarily with respect to other changes in the field.
 *
 * @param obj An object whose field to conditionally set
 * @param expect the expected value
 * @param update the new value
 * @return {@code true} if successful
 * @throws java.lang.ClassCastException if {@code obj} is not an instance
 * of the class possessing the field established in the constructor
 * @apiSince 1
 */

public abstract boolean compareAndSet(T obj, int expect, int update);

/**
 * Atomically sets the field of the given object managed by this updater
 * to the given updated value if the current value {@code ==} the
 * expected value. This method is guaranteed to be atomic with respect to
 * other calls to {@code compareAndSet} and {@code set}, but not
 * necessarily with respect to other changes in the field.
 *
 * <p><a href="package-summary.html#weakCompareAndSet">May fail
 * spuriously and does not provide ordering guarantees</a>, so is
 * only rarely an appropriate alternative to {@code compareAndSet}.
 *
 * @param obj An object whose field to conditionally set
 * @param expect the expected value
 * @param update the new value
 * @return {@code true} if successful
 * @throws java.lang.ClassCastException if {@code obj} is not an instance
 * of the class possessing the field established in the constructor
 * @apiSince 1
 */

public abstract boolean weakCompareAndSet(T obj, int expect, int update);

/**
 * Sets the field of the given object managed by this updater to the
 * given updated value. This operation is guaranteed to act as a volatile
 * store with respect to subsequent invocations of {@code compareAndSet}.
 *
 * @param obj An object whose field to set
 * @param newValue the new value
 * @apiSince 1
 */

public abstract void set(T obj, int newValue);

/**
 * Eventually sets the field of the given object managed by this
 * updater to the given updated value.
 *
 * @param obj An object whose field to set
 * @param newValue the new value
 * @since 1.6
 * @apiSince 9
 */

public abstract void lazySet(T obj, int newValue);

/**
 * Gets the current value held in the field of the given object managed
 * by this updater.
 *
 * @param obj An object whose field to get
 * @return the current value
 * @apiSince 1
 */

public abstract int get(T obj);

/**
 * Atomically sets the field of the given object managed by this updater
 * to the given value and returns the old value.
 *
 * @param obj An object whose field to get and set
 * @param newValue the new value
 * @return the previous value
 * @apiSince 1
 */

public int getAndSet(T obj, int newValue) { throw new RuntimeException("Stub!"); }

/**
 * Atomically increments by one the current value of the field of the
 * given object managed by this updater.
 *
 * @param obj An object whose field to get and set
 * @return the previous value
 * @apiSince 1
 */

public int getAndIncrement(T obj) { throw new RuntimeException("Stub!"); }

/**
 * Atomically decrements by one the current value of the field of the
 * given object managed by this updater.
 *
 * @param obj An object whose field to get and set
 * @return the previous value
 * @apiSince 1
 */

public int getAndDecrement(T obj) { throw new RuntimeException("Stub!"); }

/**
 * Atomically adds the given value to the current value of the field of
 * the given object managed by this updater.
 *
 * @param obj An object whose field to get and set
 * @param delta the value to add
 * @return the previous value
 * @apiSince 1
 */

public int getAndAdd(T obj, int delta) { throw new RuntimeException("Stub!"); }

/**
 * Atomically increments by one the current value of the field of the
 * given object managed by this updater.
 *
 * @param obj An object whose field to get and set
 * @return the updated value
 * @apiSince 1
 */

public int incrementAndGet(T obj) { throw new RuntimeException("Stub!"); }

/**
 * Atomically decrements by one the current value of the field of the
 * given object managed by this updater.
 *
 * @param obj An object whose field to get and set
 * @return the updated value
 * @apiSince 1
 */

public int decrementAndGet(T obj) { throw new RuntimeException("Stub!"); }

/**
 * Atomically adds the given value to the current value of the field of
 * the given object managed by this updater.
 *
 * @param obj An object whose field to get and set
 * @param delta the value to add
 * @return the updated value
 * @apiSince 1
 */

public int addAndGet(T obj, int delta) { throw new RuntimeException("Stub!"); }

/**
 * Atomically updates the field of the given object managed by this updater
 * with the results of applying the given function, returning the previous
 * value. The function should be side-effect-free, since it may be
 * re-applied when attempted updates fail due to contention among threads.
 *
 * @param obj An object whose field to get and set
 * @param updateFunction a side-effect-free function
 * @return the previous value
 * @since 1.8
 * @apiSince 24
 */

public final int getAndUpdate(T obj, java.util.function.IntUnaryOperator updateFunction) { throw new RuntimeException("Stub!"); }

/**
 * Atomically updates the field of the given object managed by this updater
 * with the results of applying the given function, returning the updated
 * value. The function should be side-effect-free, since it may be
 * re-applied when attempted updates fail due to contention among threads.
 *
 * @param obj An object whose field to get and set
 * @param updateFunction a side-effect-free function
 * @return the updated value
 * @since 1.8
 * @apiSince 24
 */

public final int updateAndGet(T obj, java.util.function.IntUnaryOperator updateFunction) { throw new RuntimeException("Stub!"); }

/**
 * Atomically updates the field of the given object managed by this
 * updater with the results of applying the given function to the
 * current and given values, returning the previous value. The
 * function should be side-effect-free, since it may be re-applied
 * when attempted updates fail due to contention among threads.  The
 * function is applied with the current value as its first argument,
 * and the given update as the second argument.
 *
 * @param obj An object whose field to get and set
 * @param x the update value
 * @param accumulatorFunction a side-effect-free function of two arguments
 * @return the previous value
 * @since 1.8
 * @apiSince 24
 */

public final int getAndAccumulate(T obj, int x, java.util.function.IntBinaryOperator accumulatorFunction) { throw new RuntimeException("Stub!"); }

/**
 * Atomically updates the field of the given object managed by this
 * updater with the results of applying the given function to the
 * current and given values, returning the updated value. The
 * function should be side-effect-free, since it may be re-applied
 * when attempted updates fail due to contention among threads.  The
 * function is applied with the current value as its first argument,
 * and the given update as the second argument.
 *
 * @param obj An object whose field to get and set
 * @param x the update value
 * @param accumulatorFunction a side-effect-free function of two arguments
 * @return the updated value
 * @since 1.8
 * @apiSince 24
 */

public final int accumulateAndGet(T obj, int x, java.util.function.IntBinaryOperator accumulatorFunction) { throw new RuntimeException("Stub!"); }
}

