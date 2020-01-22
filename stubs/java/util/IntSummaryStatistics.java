/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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


package java.util;

import java.util.stream.Collector;

/**
 * A state object for collecting statistics such as count, min, max, sum, and
 * average.
 *
 * <p>This class is designed to work with (though does not require)
 * {@linkplain java.util.stream streams}. For example, you can compute
 * summary statistics on a stream of ints with:
 * <pre> {@code
 * IntSummaryStatistics stats = intStream.collect(IntSummaryStatistics::new,
 *                                                IntSummaryStatistics::accept,
 *                                                IntSummaryStatistics::combine);
 * }</pre>
 *
 * <p>{@code IntSummaryStatistics} can be used as a
 * {@linkplain java.util.stream.Stream#collect(Collector) reduction}
 * target for a {@linkplain java.util.stream.Stream stream}. For example:
 *
 * <pre> {@code
 * IntSummaryStatistics stats = people.stream()
 *                                    .collect(Collectors.summarizingInt(Person::getDependents));
 *}</pre>
 *
 * This computes, in a single pass, the count of people, as well as the minimum,
 * maximum, sum, and average of their number of dependents.
 *
 * @implNote This implementation is not thread safe. However, it is safe to use
 * {@link java.util.stream.Collectors#summarizingInt(java.util.function.ToIntFunction)
 * Collectors.toIntStatistics()} on a parallel stream, because the parallel
 * implementation of {@link java.util.stream.Stream#collect Stream.collect()}
 * provides the necessary partitioning, isolation, and merging of results for
 * safe and efficient parallel execution.
 *
 * <p>This implementation does not check for overflow of the sum.
 * @since 1.8
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class IntSummaryStatistics implements java.util.function.IntConsumer {

/**
 * Construct an empty instance with zero count, zero sum,
 * {@code Integer.MAX_VALUE} min, {@code Integer.MIN_VALUE} max and zero
 * average.
 * @apiSince 24
 */

public IntSummaryStatistics() { throw new RuntimeException("Stub!"); }

/**
 * Records a new value into the summary information
 *
 * @param value the input value
 * @apiSince 24
 */

public void accept(int value) { throw new RuntimeException("Stub!"); }

/**
 * Combines the state of another {@code IntSummaryStatistics} into this one.
 *
 * @param other another {@code IntSummaryStatistics}
 * @throws java.lang.NullPointerException if {@code other} is null
 * @apiSince 24
 */

public void combine(java.util.IntSummaryStatistics other) { throw new RuntimeException("Stub!"); }

/**
 * Returns the count of values recorded.
 *
 * @return the count of values
 * @apiSince 24
 */

public final long getCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the sum of values recorded, or zero if no values have been
 * recorded.
 *
 * @return the sum of values, or zero if none
 * @apiSince 24
 */

public final long getSum() { throw new RuntimeException("Stub!"); }

/**
 * Returns the minimum value recorded, or {@code Integer.MAX_VALUE} if no
 * values have been recorded.
 *
 * @return the minimum value, or {@code Integer.MAX_VALUE} if none
 * @apiSince 24
 */

public final int getMin() { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum value recorded, or {@code Integer.MIN_VALUE} if no
 * values have been recorded.
 *
 * @return the maximum value, or {@code Integer.MIN_VALUE} if none
 * @apiSince 24
 */

public final int getMax() { throw new RuntimeException("Stub!"); }

/**
 * Returns the arithmetic mean of values recorded, or zero if no values have been
 * recorded.
 *
 * @return the arithmetic mean of values, or zero if none
 * @apiSince 24
 */

public final double getAverage() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

