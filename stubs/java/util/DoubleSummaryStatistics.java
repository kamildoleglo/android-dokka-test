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
 * summary statistics on a stream of doubles with:
 * <pre> {@code
 * DoubleSummaryStatistics stats = doubleStream.collect(DoubleSummaryStatistics::new,
 *                                                      DoubleSummaryStatistics::accept,
 *                                                      DoubleSummaryStatistics::combine);
 * }</pre>
 *
 * <p>{@code DoubleSummaryStatistics} can be used as a
 * {@linkplain java.util.stream.Stream#collect(Collector) reduction}
 * target for a {@linkplain java.util.stream.Stream stream}. For example:
 *
 * <pre> {@code
 * DoubleSummaryStatistics stats = people.stream()
 *     .collect(Collectors.summarizingDouble(Person::getWeight));
 *}</pre>
 *
 * This computes, in a single pass, the count of people, as well as the minimum,
 * maximum, sum, and average of their weights.
 *
 * @implNote This implementation is not thread safe. However, it is safe to use
 * {@link java.util.stream.Collectors#summarizingDouble(java.util.function.ToDoubleFunction)
 * Collectors.toDoubleStatistics()} on a parallel stream, because the parallel
 * implementation of {@link java.util.stream.Stream#collect Stream.collect()}
 * provides the necessary partitioning, isolation, and merging of results for
 * safe and efficient parallel execution.
 * @since 1.8
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DoubleSummaryStatistics implements java.util.function.DoubleConsumer {

/**
 * Construct an empty instance with zero count, zero sum,
 * {@code Double.POSITIVE_INFINITY} min, {@code Double.NEGATIVE_INFINITY}
 * max and zero average.
 * @apiSince 24
 */

public DoubleSummaryStatistics() { throw new RuntimeException("Stub!"); }

/**
 * Records another value into the summary information.
 *
 * @param value the input value
 * @apiSince 24
 */

public void accept(double value) { throw new RuntimeException("Stub!"); }

/**
 * Combines the state of another {@code DoubleSummaryStatistics} into this
 * one.
 *
 * @param other another {@code DoubleSummaryStatistics}
 * @throws java.lang.NullPointerException if {@code other} is null
 * @apiSince 24
 */

public void combine(java.util.DoubleSummaryStatistics other) { throw new RuntimeException("Stub!"); }

/**
 * Return the count of values recorded.
 *
 * @return the count of values
 * @apiSince 24
 */

public final long getCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the sum of values recorded, or zero if no values have been
 * recorded.
 *
 * If any recorded value is a NaN or the sum is at any point a NaN
 * then the sum will be NaN.
 *
 * <p> The value of a floating-point sum is a function both of the
 * input values as well as the order of addition operations. The
 * order of addition operations of this method is intentionally
 * not defined to allow for implementation flexibility to improve
 * the speed and accuracy of the computed result.
 *
 * In particular, this method may be implemented using compensated
 * summation or other technique to reduce the error bound in the
 * numerical sum compared to a simple summation of {@code double}
 * values.
 *
 * @apiNote Values sorted by increasing absolute magnitude tend to yield
 * more accurate results.
 *
 * @return the sum of values, or zero if none
 * @apiSince 24
 */

public final double getSum() { throw new RuntimeException("Stub!"); }

/**
 * Returns the minimum recorded value, {@code Double.NaN} if any recorded
 * value was NaN or {@code Double.POSITIVE_INFINITY} if no values were
 * recorded. Unlike the numerical comparison operators, this method
 * considers negative zero to be strictly smaller than positive zero.
 *
 * @return the minimum recorded value, {@code Double.NaN} if any recorded
 * value was NaN or {@code Double.POSITIVE_INFINITY} if no values were
 * recorded
 * @apiSince 24
 */

public final double getMin() { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum recorded value, {@code Double.NaN} if any recorded
 * value was NaN or {@code Double.NEGATIVE_INFINITY} if no values were
 * recorded. Unlike the numerical comparison operators, this method
 * considers negative zero to be strictly smaller than positive zero.
 *
 * @return the maximum recorded value, {@code Double.NaN} if any recorded
 * value was NaN or {@code Double.NEGATIVE_INFINITY} if no values were
 * recorded
 * @apiSince 24
 */

public final double getMax() { throw new RuntimeException("Stub!"); }

/**
 * Returns the arithmetic mean of values recorded, or zero if no
 * values have been recorded.
 *
 * If any recorded value is a NaN or the sum is at any point a NaN
 * then the average will be code NaN.
 *
 * <p>The average returned can vary depending upon the order in
 * which values are recorded.
 *
 * This method may be implemented using compensated summation or
 * other technique to reduce the error bound in the {@link #getSum
 * numerical sum} used to compute the average.
 *
 * @apiNote Values sorted by increasing absolute magnitude tend to yield
 * more accurate results.
 *
 * @return the arithmetic mean of values, or zero if none
 * @apiSince 24
 */

public final double getAverage() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * Returns a non-empty string representation of this object suitable for
 * debugging. The exact presentation format is unspecified and may vary
 * between implementations and versions.
 * @apiSince 24
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

