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
 * One or more variables that together maintain a running {@code long}
 * value updated using a supplied function.  When updates (method
 * {@link #accumulate}) are contended across threads, the set of variables
 * may grow dynamically to reduce contention.  Method {@link #get}
 * (or, equivalently, {@link #longValue}) returns the current value
 * across the variables maintaining updates.
 *
 * <p>This class is usually preferable to {@link java.util.concurrent.atomic.AtomicLong AtomicLong} when
 * multiple threads update a common value that is used for purposes such
 * as collecting statistics, not for fine-grained synchronization
 * control.  Under low update contention, the two classes have similar
 * characteristics. But under high contention, expected throughput of
 * this class is significantly higher, at the expense of higher space
 * consumption.
 *
 * <p>The order of accumulation within or across threads is not
 * guaranteed and cannot be depended upon, so this class is only
 * applicable to functions for which the order of accumulation does
 * not matter. The supplied accumulator function should be
 * side-effect-free, since it may be re-applied when attempted updates
 * fail due to contention among threads. The function is applied with
 * the current value as its first argument, and the given update as
 * the second argument.  For example, to maintain a running maximum
 * value, you could supply {@code Long::max} along with {@code
 * Long.MIN_VALUE} as the identity.
 *
 * <p>Class {@link java.util.concurrent.atomic.LongAdder LongAdder} provides analogs of the functionality of
 * this class for the common special case of maintaining counts and
 * sums.  The call {@code new LongAdder()} is equivalent to {@code new
 * LongAccumulator((x, y) -> x + y, 0L}.
 *
 * <p>This class extends {@link java.lang.Number Number}, but does <em>not</em> define
 * methods such as {@code equals}, {@code hashCode} and {@code
 * compareTo} because instances are expected to be mutated, and so are
 * not useful as collection keys.
 *
 * @since 1.8
 * @author Doug Lea
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class LongAccumulator extends java.lang.Number implements java.io.Serializable {

/**
 * Creates a new instance using the given accumulator function
 * and identity element.
 * @param accumulatorFunction a side-effect-free function of two arguments
 * @param identity identity (initial value) for the accumulator function
 * @apiSince 24
 */

public LongAccumulator(java.util.function.LongBinaryOperator accumulatorFunction, long identity) { throw new RuntimeException("Stub!"); }

/**
 * Updates with the given value.
 *
 * @param x the value
 * @apiSince 24
 */

public void accumulate(long x) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current value.  The returned value is <em>NOT</em>
 * an atomic snapshot; invocation in the absence of concurrent
 * updates returns an accurate result, but concurrent updates that
 * occur while the value is being calculated might not be
 * incorporated.
 *
 * @return the current value
 * @apiSince 24
 */

public long get() { throw new RuntimeException("Stub!"); }

/**
 * Resets variables maintaining updates to the identity value.
 * This method may be a useful alternative to creating a new
 * updater, but is only effective if there are no concurrent
 * updates.  Because this method is intrinsically racy, it should
 * only be used when it is known that no threads are concurrently
 * updating.
 * @apiSince 24
 */

public void reset() { throw new RuntimeException("Stub!"); }

/**
 * Equivalent in effect to {@link #get} followed by {@link
 * #reset}. This method may apply for example during quiescent
 * points between multithreaded computations.  If there are
 * updates concurrent with this method, the returned value is
 * <em>not</em> guaranteed to be the final value occurring before
 * the reset.
 *
 * @return the value before reset
 * @apiSince 24
 */

public long getThenReset() { throw new RuntimeException("Stub!"); }

/**
 * Returns the String representation of the current value.
 * @return the String representation of the current value
 * @apiSince 24
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to {@link #get}.
 *
 * @return the current value
 * @apiSince 24
 */

public long longValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@linkplain #get current value} as an {@code int}
 * after a narrowing primitive conversion.
 * @apiSince 24
 */

public int intValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@linkplain #get current value} as a {@code float}
 * after a widening primitive conversion.
 * @apiSince 24
 */

public float floatValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@linkplain #get current value} as a {@code double}
 * after a widening primitive conversion.
 * @apiSince 24
 */

public double doubleValue() { throw new RuntimeException("Stub!"); }
}

