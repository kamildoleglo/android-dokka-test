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
 * An {@code int} value that may be updated atomically.  See the
 * {@link java.util.concurrent.atomic} package specification for
 * description of the properties of atomic variables. An
 * {@code AtomicInteger} is used in applications such as atomically
 * incremented counters, and cannot be used as a replacement for an
 * {@link java.lang.Integer}. However, this class does extend
 * {@code Number} to allow uniform access by tools and utilities that
 * deal with numerically-based classes.
 *
 * @since 1.5
 * @author Doug Lea
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AtomicInteger extends java.lang.Number implements java.io.Serializable {

/**
 * Creates a new AtomicInteger with the given initial value.
 *
 * @param initialValue the initial value
 * @apiSince 1
 */

public AtomicInteger(int initialValue) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new AtomicInteger with initial value {@code 0}.
 * @apiSince 1
 */

public AtomicInteger() { throw new RuntimeException("Stub!"); }

/**
 * Gets the current value.
 *
 * @return the current value
 * @apiSince 1
 */

public final int get() { throw new RuntimeException("Stub!"); }

/**
 * Sets to the given value.
 *
 * @param newValue the new value
 * @apiSince 1
 */

public final void set(int newValue) { throw new RuntimeException("Stub!"); }

/**
 * Eventually sets to the given value.
 *
 * @param newValue the new value
 * @since 1.6
 * @apiSince 9
 */

public final void lazySet(int newValue) { throw new RuntimeException("Stub!"); }

/**
 * Atomically sets to the given value and returns the old value.
 *
 * @param newValue the new value
 * @return the previous value
 * @apiSince 1
 */

public final int getAndSet(int newValue) { throw new RuntimeException("Stub!"); }

/**
 * Atomically sets the value to the given updated value
 * if the current value {@code ==} the expected value.
 *
 * @param expect the expected value
 * @param update the new value
 * @return {@code true} if successful. False return indicates that
 * the actual value was not equal to the expected value.
 * @apiSince 1
 */

public final boolean compareAndSet(int expect, int update) { throw new RuntimeException("Stub!"); }

/**
 * Atomically sets the value to the given updated value
 * if the current value {@code ==} the expected value.
 *
 * <p><a href="package-summary.html#weakCompareAndSet">May fail
 * spuriously and does not provide ordering guarantees</a>, so is
 * only rarely an appropriate alternative to {@code compareAndSet}.
 *
 * @param expect the expected value
 * @param update the new value
 * @return {@code true} if successful
 * @apiSince 1
 */

public final boolean weakCompareAndSet(int expect, int update) { throw new RuntimeException("Stub!"); }

/**
 * Atomically increments by one the current value.
 *
 * @return the previous value
 * @apiSince 1
 */

public final int getAndIncrement() { throw new RuntimeException("Stub!"); }

/**
 * Atomically decrements by one the current value.
 *
 * @return the previous value
 * @apiSince 1
 */

public final int getAndDecrement() { throw new RuntimeException("Stub!"); }

/**
 * Atomically adds the given value to the current value.
 *
 * @param delta the value to add
 * @return the previous value
 * @apiSince 1
 */

public final int getAndAdd(int delta) { throw new RuntimeException("Stub!"); }

/**
 * Atomically increments by one the current value.
 *
 * @return the updated value
 * @apiSince 1
 */

public final int incrementAndGet() { throw new RuntimeException("Stub!"); }

/**
 * Atomically decrements by one the current value.
 *
 * @return the updated value
 * @apiSince 1
 */

public final int decrementAndGet() { throw new RuntimeException("Stub!"); }

/**
 * Atomically adds the given value to the current value.
 *
 * @param delta the value to add
 * @return the updated value
 * @apiSince 1
 */

public final int addAndGet(int delta) { throw new RuntimeException("Stub!"); }

/**
 * Atomically updates the current value with the results of
 * applying the given function, returning the previous value. The
 * function should be side-effect-free, since it may be re-applied
 * when attempted updates fail due to contention among threads.
 *
 * @param updateFunction a side-effect-free function
 * @return the previous value
 * @since 1.8
 * @apiSince 24
 */

public final int getAndUpdate(java.util.function.IntUnaryOperator updateFunction) { throw new RuntimeException("Stub!"); }

/**
 * Atomically updates the current value with the results of
 * applying the given function, returning the updated value. The
 * function should be side-effect-free, since it may be re-applied
 * when attempted updates fail due to contention among threads.
 *
 * @param updateFunction a side-effect-free function
 * @return the updated value
 * @since 1.8
 * @apiSince 24
 */

public final int updateAndGet(java.util.function.IntUnaryOperator updateFunction) { throw new RuntimeException("Stub!"); }

/**
 * Atomically updates the current value with the results of
 * applying the given function to the current and given values,
 * returning the previous value. The function should be
 * side-effect-free, since it may be re-applied when attempted
 * updates fail due to contention among threads.  The function
 * is applied with the current value as its first argument,
 * and the given update as the second argument.
 *
 * @param x the update value
 * @param accumulatorFunction a side-effect-free function of two arguments
 * @return the previous value
 * @since 1.8
 * @apiSince 24
 */

public final int getAndAccumulate(int x, java.util.function.IntBinaryOperator accumulatorFunction) { throw new RuntimeException("Stub!"); }

/**
 * Atomically updates the current value with the results of
 * applying the given function to the current and given values,
 * returning the updated value. The function should be
 * side-effect-free, since it may be re-applied when attempted
 * updates fail due to contention among threads.  The function
 * is applied with the current value as its first argument,
 * and the given update as the second argument.
 *
 * @param x the update value
 * @param accumulatorFunction a side-effect-free function of two arguments
 * @return the updated value
 * @since 1.8
 * @apiSince 24
 */

public final int accumulateAndGet(int x, java.util.function.IntBinaryOperator accumulatorFunction) { throw new RuntimeException("Stub!"); }

/**
 * Returns the String representation of the current value.
 * @return the String representation of the current value
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of this {@code AtomicInteger} as an {@code int}.
 * Equivalent to {@link #get()}.
 * @apiSince 1
 */

public int intValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of this {@code AtomicInteger} as a {@code long}
 * after a widening primitive conversion.
 * @jls 5.1.2 Widening Primitive Conversions
 * @apiSince 1
 */

public long longValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of this {@code AtomicInteger} as a {@code float}
 * after a widening primitive conversion.
 * @jls 5.1.2 Widening Primitive Conversions
 * @apiSince 1
 */

public float floatValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of this {@code AtomicInteger} as a {@code double}
 * after a widening primitive conversion.
 * @jls 5.1.2 Widening Primitive Conversions
 * @apiSince 1
 */

public double doubleValue() { throw new RuntimeException("Stub!"); }
}

