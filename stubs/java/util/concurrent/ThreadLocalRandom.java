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

import java.util.Random;

/**
 * A random number generator isolated to the current thread.  Like the
 * global {@link java.util.Random} generator used by the {@link
 * java.lang.Math} class, a {@code ThreadLocalRandom} is initialized
 * with an internally generated seed that may not otherwise be
 * modified. When applicable, use of {@code ThreadLocalRandom} rather
 * than shared {@code Random} objects in concurrent programs will
 * typically encounter much less overhead and contention.  Use of
 * {@code ThreadLocalRandom} is particularly appropriate when multiple
 * tasks (for example, each a {@link java.util.concurrent.ForkJoinTask ForkJoinTask}) use random numbers
 * in parallel in thread pools.
 *
 * <p>Usages of this class should typically be of the form:
 * {@code ThreadLocalRandom.current().nextX(...)} (where
 * {@code X} is {@code Int}, {@code Long}, etc).
 * When all usages are of this form, it is never possible to
 * accidently share a {@code ThreadLocalRandom} across multiple threads.
 *
 * <p>This class also provides additional commonly used bounded random
 * generation methods.
 *
 * <p>Instances of {@code ThreadLocalRandom} are not cryptographically
 * secure.  Consider instead using {@link java.security.SecureRandom}
 * in security-sensitive applications. Additionally,
 * default-constructed instances do not use a cryptographically random
 * seed unless the {@linkplain java.lang.System#getProperty System#getProperty}
 * {@code java.util.secureRandomSeed} is set to {@code true}.
 *
 * @since 1.7
 * @author Doug Lea
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ThreadLocalRandom extends java.util.Random {

private ThreadLocalRandom() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current thread's {@code ThreadLocalRandom}.
 *
 * @return the current thread's {@code ThreadLocalRandom}
 * @apiSince 21
 */

public static java.util.concurrent.ThreadLocalRandom current() { throw new RuntimeException("Stub!"); }

/**
 * Throws {@code UnsupportedOperationException}.  Setting seeds in
 * this generator is not supported.
 *
 * @throws java.lang.UnsupportedOperationException always
 * @apiSince 21
 */

public void setSeed(long seed) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

protected int next(int bits) { throw new RuntimeException("Stub!"); }

/**
 * Returns a pseudorandom {@code int} value.
 *
 * @return a pseudorandom {@code int} value
 * @apiSince 21
 */

public int nextInt() { throw new RuntimeException("Stub!"); }

/**
 * Returns a pseudorandom {@code int} value between zero (inclusive)
 * and the specified bound (exclusive).
 *
 * @param bound the upper bound (exclusive).  Must be positive.
 * @return a pseudorandom {@code int} value between zero
 *         (inclusive) and the bound (exclusive)
 * @throws java.lang.IllegalArgumentException if {@code bound} is not positive
 * @apiSince 21
 */

public int nextInt(int bound) { throw new RuntimeException("Stub!"); }

/**
 * Returns a pseudorandom {@code int} value between the specified
 * origin (inclusive) and the specified bound (exclusive).
 *
 * @param origin the least value returned
 * @param bound the upper bound (exclusive)
 * @return a pseudorandom {@code int} value between the origin
 *         (inclusive) and the bound (exclusive)
 * @throws java.lang.IllegalArgumentException if {@code origin} is greater than
 *         or equal to {@code bound}
 * @apiSince 21
 */

public int nextInt(int origin, int bound) { throw new RuntimeException("Stub!"); }

/**
 * Returns a pseudorandom {@code long} value.
 *
 * @return a pseudorandom {@code long} value
 * @apiSince 21
 */

public long nextLong() { throw new RuntimeException("Stub!"); }

/**
 * Returns a pseudorandom {@code long} value between zero (inclusive)
 * and the specified bound (exclusive).
 *
 * @param bound the upper bound (exclusive).  Must be positive.
 * @return a pseudorandom {@code long} value between zero
 *         (inclusive) and the bound (exclusive)
 * @throws java.lang.IllegalArgumentException if {@code bound} is not positive
 * @apiSince 21
 */

public long nextLong(long bound) { throw new RuntimeException("Stub!"); }

/**
 * Returns a pseudorandom {@code long} value between the specified
 * origin (inclusive) and the specified bound (exclusive).
 *
 * @param origin the least value returned
 * @param bound the upper bound (exclusive)
 * @return a pseudorandom {@code long} value between the origin
 *         (inclusive) and the bound (exclusive)
 * @throws java.lang.IllegalArgumentException if {@code origin} is greater than
 *         or equal to {@code bound}
 * @apiSince 21
 */

public long nextLong(long origin, long bound) { throw new RuntimeException("Stub!"); }

/**
 * Returns a pseudorandom {@code double} value between zero
 * (inclusive) and one (exclusive).
 *
 * @return a pseudorandom {@code double} value between zero
 *         (inclusive) and one (exclusive)
 * @apiSince 21
 */

public double nextDouble() { throw new RuntimeException("Stub!"); }

/**
 * Returns a pseudorandom {@code double} value between 0.0
 * (inclusive) and the specified bound (exclusive).
 *
 * @param bound the upper bound (exclusive).  Must be positive.
 * @return a pseudorandom {@code double} value between zero
 *         (inclusive) and the bound (exclusive)
 * @throws java.lang.IllegalArgumentException if {@code bound} is not positive
 * @apiSince 21
 */

public double nextDouble(double bound) { throw new RuntimeException("Stub!"); }

/**
 * Returns a pseudorandom {@code double} value between the specified
 * origin (inclusive) and bound (exclusive).
 *
 * @param origin the least value returned
 * @param bound the upper bound (exclusive)
 * @return a pseudorandom {@code double} value between the origin
 *         (inclusive) and the bound (exclusive)
 * @throws java.lang.IllegalArgumentException if {@code origin} is greater than
 *         or equal to {@code bound}
 * @apiSince 21
 */

public double nextDouble(double origin, double bound) { throw new RuntimeException("Stub!"); }

/**
 * Returns a pseudorandom {@code boolean} value.
 *
 * @return a pseudorandom {@code boolean} value
 * @apiSince 21
 */

public boolean nextBoolean() { throw new RuntimeException("Stub!"); }

/**
 * Returns a pseudorandom {@code float} value between zero
 * (inclusive) and one (exclusive).
 *
 * @return a pseudorandom {@code float} value between zero
 *         (inclusive) and one (exclusive)
 * @apiSince 21
 */

public float nextFloat() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public double nextGaussian() { throw new RuntimeException("Stub!"); }

/**
 * Returns a stream producing the given {@code streamSize} number of
 * pseudorandom {@code int} values.
 *
 * @param streamSize the number of values to generate
 * @return a stream of pseudorandom {@code int} values
 * @throws java.lang.IllegalArgumentException if {@code streamSize} is
 *         less than zero
 * @since 1.8
 * @apiSince 24
 */

public java.util.stream.IntStream ints(long streamSize) { throw new RuntimeException("Stub!"); }

/**
 * Returns an effectively unlimited stream of pseudorandom {@code int}
 * values.
 *
 * @implNote This method is implemented to be equivalent to {@code
 * ints(Long.MAX_VALUE)}.
 *
 * @return a stream of pseudorandom {@code int} values
 * @since 1.8
 * @apiSince 24
 */

public java.util.stream.IntStream ints() { throw new RuntimeException("Stub!"); }

/**
 * Returns a stream producing the given {@code streamSize} number
 * of pseudorandom {@code int} values, each conforming to the given
 * origin (inclusive) and bound (exclusive).
 *
 * @param streamSize the number of values to generate
 * @param randomNumberOrigin the origin (inclusive) of each random value
 * @param randomNumberBound the bound (exclusive) of each random value
 * @return a stream of pseudorandom {@code int} values,
 *         each with the given origin (inclusive) and bound (exclusive)
 * @throws java.lang.IllegalArgumentException if {@code streamSize} is
 *         less than zero, or {@code randomNumberOrigin}
 *         is greater than or equal to {@code randomNumberBound}
 * @since 1.8
 * @apiSince 24
 */

public java.util.stream.IntStream ints(long streamSize, int randomNumberOrigin, int randomNumberBound) { throw new RuntimeException("Stub!"); }

/**
 * Returns an effectively unlimited stream of pseudorandom {@code
 * int} values, each conforming to the given origin (inclusive) and bound
 * (exclusive).
 *
 * @implNote This method is implemented to be equivalent to {@code
 * ints(Long.MAX_VALUE, randomNumberOrigin, randomNumberBound)}.
 *
 * @param randomNumberOrigin the origin (inclusive) of each random value
 * @param randomNumberBound the bound (exclusive) of each random value
 * @return a stream of pseudorandom {@code int} values,
 *         each with the given origin (inclusive) and bound (exclusive)
 * @throws java.lang.IllegalArgumentException if {@code randomNumberOrigin}
 *         is greater than or equal to {@code randomNumberBound}
 * @since 1.8
 * @apiSince 24
 */

public java.util.stream.IntStream ints(int randomNumberOrigin, int randomNumberBound) { throw new RuntimeException("Stub!"); }

/**
 * Returns a stream producing the given {@code streamSize} number of
 * pseudorandom {@code long} values.
 *
 * @param streamSize the number of values to generate
 * @return a stream of pseudorandom {@code long} values
 * @throws java.lang.IllegalArgumentException if {@code streamSize} is
 *         less than zero
 * @since 1.8
 * @apiSince 24
 */

public java.util.stream.LongStream longs(long streamSize) { throw new RuntimeException("Stub!"); }

/**
 * Returns an effectively unlimited stream of pseudorandom {@code long}
 * values.
 *
 * @implNote This method is implemented to be equivalent to {@code
 * longs(Long.MAX_VALUE)}.
 *
 * @return a stream of pseudorandom {@code long} values
 * @since 1.8
 * @apiSince 24
 */

public java.util.stream.LongStream longs() { throw new RuntimeException("Stub!"); }

/**
 * Returns a stream producing the given {@code streamSize} number of
 * pseudorandom {@code long}, each conforming to the given origin
 * (inclusive) and bound (exclusive).
 *
 * @param streamSize the number of values to generate
 * @param randomNumberOrigin the origin (inclusive) of each random value
 * @param randomNumberBound the bound (exclusive) of each random value
 * @return a stream of pseudorandom {@code long} values,
 *         each with the given origin (inclusive) and bound (exclusive)
 * @throws java.lang.IllegalArgumentException if {@code streamSize} is
 *         less than zero, or {@code randomNumberOrigin}
 *         is greater than or equal to {@code randomNumberBound}
 * @since 1.8
 * @apiSince 24
 */

public java.util.stream.LongStream longs(long streamSize, long randomNumberOrigin, long randomNumberBound) { throw new RuntimeException("Stub!"); }

/**
 * Returns an effectively unlimited stream of pseudorandom {@code
 * long} values, each conforming to the given origin (inclusive) and bound
 * (exclusive).
 *
 * @implNote This method is implemented to be equivalent to {@code
 * longs(Long.MAX_VALUE, randomNumberOrigin, randomNumberBound)}.
 *
 * @param randomNumberOrigin the origin (inclusive) of each random value
 * @param randomNumberBound the bound (exclusive) of each random value
 * @return a stream of pseudorandom {@code long} values,
 *         each with the given origin (inclusive) and bound (exclusive)
 * @throws java.lang.IllegalArgumentException if {@code randomNumberOrigin}
 *         is greater than or equal to {@code randomNumberBound}
 * @since 1.8
 * @apiSince 24
 */

public java.util.stream.LongStream longs(long randomNumberOrigin, long randomNumberBound) { throw new RuntimeException("Stub!"); }

/**
 * Returns a stream producing the given {@code streamSize} number of
 * pseudorandom {@code double} values, each between zero
 * (inclusive) and one (exclusive).
 *
 * @param streamSize the number of values to generate
 * @return a stream of {@code double} values
 * @throws java.lang.IllegalArgumentException if {@code streamSize} is
 *         less than zero
 * @since 1.8
 * @apiSince 24
 */

public java.util.stream.DoubleStream doubles(long streamSize) { throw new RuntimeException("Stub!"); }

/**
 * Returns an effectively unlimited stream of pseudorandom {@code
 * double} values, each between zero (inclusive) and one
 * (exclusive).
 *
 * @implNote This method is implemented to be equivalent to {@code
 * doubles(Long.MAX_VALUE)}.
 *
 * @return a stream of pseudorandom {@code double} values
 * @since 1.8
 * @apiSince 24
 */

public java.util.stream.DoubleStream doubles() { throw new RuntimeException("Stub!"); }

/**
 * Returns a stream producing the given {@code streamSize} number of
 * pseudorandom {@code double} values, each conforming to the given origin
 * (inclusive) and bound (exclusive).
 *
 * @param streamSize the number of values to generate
 * @param randomNumberOrigin the origin (inclusive) of each random value
 * @param randomNumberBound the bound (exclusive) of each random value
 * @return a stream of pseudorandom {@code double} values,
 *         each with the given origin (inclusive) and bound (exclusive)
 * @throws java.lang.IllegalArgumentException if {@code streamSize} is
 *         less than zero
 * @throws java.lang.IllegalArgumentException if {@code randomNumberOrigin}
 *         is greater than or equal to {@code randomNumberBound}
 * @since 1.8
 * @apiSince 24
 */

public java.util.stream.DoubleStream doubles(long streamSize, double randomNumberOrigin, double randomNumberBound) { throw new RuntimeException("Stub!"); }

/**
 * Returns an effectively unlimited stream of pseudorandom {@code
 * double} values, each conforming to the given origin (inclusive) and bound
 * (exclusive).
 *
 * @implNote This method is implemented to be equivalent to {@code
 * doubles(Long.MAX_VALUE, randomNumberOrigin, randomNumberBound)}.
 *
 * @param randomNumberOrigin the origin (inclusive) of each random value
 * @param randomNumberBound the bound (exclusive) of each random value
 * @return a stream of pseudorandom {@code double} values,
 *         each with the given origin (inclusive) and bound (exclusive)
 * @throws java.lang.IllegalArgumentException if {@code randomNumberOrigin}
 *         is greater than or equal to {@code randomNumberBound}
 * @since 1.8
 * @apiSince 24
 */

public java.util.stream.DoubleStream doubles(double randomNumberOrigin, double randomNumberBound) { throw new RuntimeException("Stub!"); }
}

