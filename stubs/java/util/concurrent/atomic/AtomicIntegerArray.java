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
 * An {@code int} array in which elements may be updated atomically.
 * See the {@link java.util.concurrent.atomic} package
 * specification for description of the properties of atomic
 * variables.
 * @since 1.5
 * @author Doug Lea
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AtomicIntegerArray implements java.io.Serializable {

/**
 * Creates a new AtomicIntegerArray of the given length, with all
 * elements initially zero.
 *
 * @param length the length of the array
 * @apiSince 1
 */

public AtomicIntegerArray(int length) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new AtomicIntegerArray with the same length as, and
 * all elements copied from, the given array.
 *
 * @param array the array to copy elements from
 * @throws java.lang.NullPointerException if array is null
 * @apiSince 1
 */

public AtomicIntegerArray(int[] array) { throw new RuntimeException("Stub!"); }

/**
 * Returns the length of the array.
 *
 * @return the length of the array
 * @apiSince 1
 */

public final int length() { throw new RuntimeException("Stub!"); }

/**
 * Gets the current value at position {@code i}.
 *
 * @param i the index
 * @return the current value
 * @apiSince 1
 */

public final int get(int i) { throw new RuntimeException("Stub!"); }

/**
 * Sets the element at position {@code i} to the given value.
 *
 * @param i the index
 * @param newValue the new value
 * @apiSince 1
 */

public final void set(int i, int newValue) { throw new RuntimeException("Stub!"); }

/**
 * Eventually sets the element at position {@code i} to the given value.
 *
 * @param i the index
 * @param newValue the new value
 * @since 1.6
 * @apiSince 9
 */

public final void lazySet(int i, int newValue) { throw new RuntimeException("Stub!"); }

/**
 * Atomically sets the element at position {@code i} to the given
 * value and returns the old value.
 *
 * @param i the index
 * @param newValue the new value
 * @return the previous value
 * @apiSince 1
 */

public final int getAndSet(int i, int newValue) { throw new RuntimeException("Stub!"); }

/**
 * Atomically sets the element at position {@code i} to the given
 * updated value if the current value {@code ==} the expected value.
 *
 * @param i the index
 * @param expect the expected value
 * @param update the new value
 * @return {@code true} if successful. False return indicates that
 * the actual value was not equal to the expected value.
 * @apiSince 1
 */

public final boolean compareAndSet(int i, int expect, int update) { throw new RuntimeException("Stub!"); }

/**
 * Atomically sets the element at position {@code i} to the given
 * updated value if the current value {@code ==} the expected value.
 *
 * <p><a href="package-summary.html#weakCompareAndSet">May fail
 * spuriously and does not provide ordering guarantees</a>, so is
 * only rarely an appropriate alternative to {@code compareAndSet}.
 *
 * @param i the index
 * @param expect the expected value
 * @param update the new value
 * @return {@code true} if successful
 * @apiSince 1
 */

public final boolean weakCompareAndSet(int i, int expect, int update) { throw new RuntimeException("Stub!"); }

/**
 * Atomically increments by one the element at index {@code i}.
 *
 * @param i the index
 * @return the previous value
 * @apiSince 1
 */

public final int getAndIncrement(int i) { throw new RuntimeException("Stub!"); }

/**
 * Atomically decrements by one the element at index {@code i}.
 *
 * @param i the index
 * @return the previous value
 * @apiSince 1
 */

public final int getAndDecrement(int i) { throw new RuntimeException("Stub!"); }

/**
 * Atomically adds the given value to the element at index {@code i}.
 *
 * @param i the index
 * @param delta the value to add
 * @return the previous value
 * @apiSince 1
 */

public final int getAndAdd(int i, int delta) { throw new RuntimeException("Stub!"); }

/**
 * Atomically increments by one the element at index {@code i}.
 *
 * @param i the index
 * @return the updated value
 * @apiSince 1
 */

public final int incrementAndGet(int i) { throw new RuntimeException("Stub!"); }

/**
 * Atomically decrements by one the element at index {@code i}.
 *
 * @param i the index
 * @return the updated value
 * @apiSince 1
 */

public final int decrementAndGet(int i) { throw new RuntimeException("Stub!"); }

/**
 * Atomically adds the given value to the element at index {@code i}.
 *
 * @param i the index
 * @param delta the value to add
 * @return the updated value
 * @apiSince 1
 */

public final int addAndGet(int i, int delta) { throw new RuntimeException("Stub!"); }

/**
 * Atomically updates the element at index {@code i} with the results
 * of applying the given function, returning the previous value. The
 * function should be side-effect-free, since it may be re-applied
 * when attempted updates fail due to contention among threads.
 *
 * @param i the index
 * @param updateFunction a side-effect-free function
 * @return the previous value
 * @since 1.8
 * @apiSince 24
 */

public final int getAndUpdate(int i, java.util.function.IntUnaryOperator updateFunction) { throw new RuntimeException("Stub!"); }

/**
 * Atomically updates the element at index {@code i} with the results
 * of applying the given function, returning the updated value. The
 * function should be side-effect-free, since it may be re-applied
 * when attempted updates fail due to contention among threads.
 *
 * @param i the index
 * @param updateFunction a side-effect-free function
 * @return the updated value
 * @since 1.8
 * @apiSince 24
 */

public final int updateAndGet(int i, java.util.function.IntUnaryOperator updateFunction) { throw new RuntimeException("Stub!"); }

/**
 * Atomically updates the element at index {@code i} with the
 * results of applying the given function to the current and
 * given values, returning the previous value. The function should
 * be side-effect-free, since it may be re-applied when attempted
 * updates fail due to contention among threads.  The function is
 * applied with the current value at index {@code i} as its first
 * argument, and the given update as the second argument.
 *
 * @param i the index
 * @param x the update value
 * @param accumulatorFunction a side-effect-free function of two arguments
 * @return the previous value
 * @since 1.8
 * @apiSince 24
 */

public final int getAndAccumulate(int i, int x, java.util.function.IntBinaryOperator accumulatorFunction) { throw new RuntimeException("Stub!"); }

/**
 * Atomically updates the element at index {@code i} with the
 * results of applying the given function to the current and
 * given values, returning the updated value. The function should
 * be side-effect-free, since it may be re-applied when attempted
 * updates fail due to contention among threads.  The function is
 * applied with the current value at index {@code i} as its first
 * argument, and the given update as the second argument.
 *
 * @param i the index
 * @param x the update value
 * @param accumulatorFunction a side-effect-free function of two arguments
 * @return the updated value
 * @since 1.8
 * @apiSince 24
 */

public final int accumulateAndGet(int i, int x, java.util.function.IntBinaryOperator accumulatorFunction) { throw new RuntimeException("Stub!"); }

/**
 * Returns the String representation of the current values of array.
 * @return the String representation of the current values of array
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

