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


/**
 * A {@code TimeUnit} represents time durations at a given unit of
 * granularity and provides utility methods to convert across units,
 * and to perform timing and delay operations in these units.  A
 * {@code TimeUnit} does not maintain time information, but only
 * helps organize and use time representations that may be maintained
 * separately across various contexts.  A nanosecond is defined as one
 * thousandth of a microsecond, a microsecond as one thousandth of a
 * millisecond, a millisecond as one thousandth of a second, a minute
 * as sixty seconds, an hour as sixty minutes, and a day as twenty four
 * hours.
 *
 * <p>A {@code TimeUnit} is mainly used to inform time-based methods
 * how a given timing parameter should be interpreted. For example,
 * the following code will timeout in 50 milliseconds if the {@link
 * java.util.concurrent.locks.Lock lock} is not available:
 *
 * <pre> {@code
 * Lock lock = ...;
 * if (lock.tryLock(50L, TimeUnit.MILLISECONDS)) ...}</pre>
 *
 * while this code will timeout in 50 seconds:
 * <pre> {@code
 * Lock lock = ...;
 * if (lock.tryLock(50L, TimeUnit.SECONDS)) ...}</pre>
 *
 * Note however, that there is no guarantee that a particular timeout
 * implementation will be able to notice the passage of time at the
 * same granularity as the given {@code TimeUnit}.
 *
 * @since 1.5
 * @author Doug Lea
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum TimeUnit {
/**
 * Time unit representing one thousandth of a microsecond.
 * @apiSince 1
 */

NANOSECONDS,
/**
 * Time unit representing one thousandth of a millisecond.
 * @apiSince 1
 */

MICROSECONDS,
/**
 * Time unit representing one thousandth of a second.
 * @apiSince 1
 */

MILLISECONDS,
/**
 * Time unit representing one second.
 * @apiSince 1
 */

SECONDS,
/**
 * Time unit representing sixty seconds.
 * @since 1.6
 * @apiSince 9
 */

MINUTES,
/**
 * Time unit representing sixty minutes.
 * @since 1.6
 * @apiSince 9
 */

HOURS,
/**
 * Time unit representing twenty four hours.
 * @since 1.6
 * @apiSince 9
 */

DAYS;

/**
 * Converts the given time duration in the given unit to this unit.
 * Conversions from finer to coarser granularities truncate, so
 * lose precision. For example, converting {@code 999} milliseconds
 * to seconds results in {@code 0}. Conversions from coarser to
 * finer granularities with arguments that would numerically
 * overflow saturate to {@code Long.MIN_VALUE} if negative or
 * {@code Long.MAX_VALUE} if positive.
 *
 * <p>For example, to convert 10 minutes to milliseconds, use:
 * {@code TimeUnit.MILLISECONDS.convert(10L, TimeUnit.MINUTES)}
 *
 * @param sourceDuration the time duration in the given {@code sourceUnit}
 * @param sourceUnit the unit of the {@code sourceDuration} argument
 * @return the converted duration in this unit,
 * or {@code Long.MIN_VALUE} if conversion would negatively
 * overflow, or {@code Long.MAX_VALUE} if it would positively overflow.
 * @apiSince 1
 */

public long convert(long sourceDuration, java.util.concurrent.TimeUnit sourceUnit) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to
 * {@link #convert(long,java.util.concurrent.TimeUnit) NANOSECONDS.convert(duration, this)}.
 * @param duration the duration
 * @return the converted duration,
 * or {@code Long.MIN_VALUE} if conversion would negatively
 * overflow, or {@code Long.MAX_VALUE} if it would positively overflow.
 * @apiSince 1
 */

public long toNanos(long duration) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to
 * {@link #convert(long,java.util.concurrent.TimeUnit) MICROSECONDS.convert(duration, this)}.
 * @param duration the duration
 * @return the converted duration,
 * or {@code Long.MIN_VALUE} if conversion would negatively
 * overflow, or {@code Long.MAX_VALUE} if it would positively overflow.
 * @apiSince 1
 */

public long toMicros(long duration) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to
 * {@link #convert(long,java.util.concurrent.TimeUnit) MILLISECONDS.convert(duration, this)}.
 * @param duration the duration
 * @return the converted duration,
 * or {@code Long.MIN_VALUE} if conversion would negatively
 * overflow, or {@code Long.MAX_VALUE} if it would positively overflow.
 * @apiSince 1
 */

public long toMillis(long duration) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to
 * {@link #convert(long,java.util.concurrent.TimeUnit) SECONDS.convert(duration, this)}.
 * @param duration the duration
 * @return the converted duration,
 * or {@code Long.MIN_VALUE} if conversion would negatively
 * overflow, or {@code Long.MAX_VALUE} if it would positively overflow.
 * @apiSince 1
 */

public long toSeconds(long duration) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to
 * {@link #convert(long,java.util.concurrent.TimeUnit) MINUTES.convert(duration, this)}.
 * @param duration the duration
 * @return the converted duration,
 * or {@code Long.MIN_VALUE} if conversion would negatively
 * overflow, or {@code Long.MAX_VALUE} if it would positively overflow.
 * @since 1.6
 * @apiSince 9
 */

public long toMinutes(long duration) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to
 * {@link #convert(long,java.util.concurrent.TimeUnit) HOURS.convert(duration, this)}.
 * @param duration the duration
 * @return the converted duration,
 * or {@code Long.MIN_VALUE} if conversion would negatively
 * overflow, or {@code Long.MAX_VALUE} if it would positively overflow.
 * @since 1.6
 * @apiSince 9
 */

public long toHours(long duration) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to
 * {@link #convert(long,java.util.concurrent.TimeUnit) DAYS.convert(duration, this)}.
 * @param duration the duration
 * @return the converted duration
 * @since 1.6
 * @apiSince 9
 */

public long toDays(long duration) { throw new RuntimeException("Stub!"); }

/**
 * Performs a timed {@link java.lang.Object#wait(long,int) Object#wait(long, int)}
 * using this time unit.
 * This is a convenience method that converts timeout arguments
 * into the form required by the {@code Object.wait} method.
 *
 * <p>For example, you could implement a blocking {@code poll}
 * method (see {@link java.util.concurrent.BlockingQueue#poll BlockingQueue#poll})
 * using:
 *
 * <pre> {@code
 * public synchronized Object poll(long timeout, TimeUnit unit)
 *     throws InterruptedException {
 *   while (empty) {
 *     unit.timedWait(this, timeout);
 *     ...
 *   }
 * }}</pre>
 *
 * @param obj the object to wait on
 * @param timeout the maximum time to wait. If less than
 * or equal to zero, do not wait at all.
 * @throws java.lang.InterruptedException if interrupted while waiting
 * @apiSince 1
 */

public void timedWait(java.lang.Object obj, long timeout) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * Performs a timed {@link java.lang.Thread#join(long,int) Thread#join(long, int)}
 * using this time unit.
 * This is a convenience method that converts time arguments into the
 * form required by the {@code Thread.join} method.
 *
 * @param thread the thread to wait for
 * @param timeout the maximum time to wait. If less than
 * or equal to zero, do not wait at all.
 * @throws java.lang.InterruptedException if interrupted while waiting
 * @apiSince 1
 */

public void timedJoin(java.lang.Thread thread, long timeout) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * Performs a {@link java.lang.Thread#sleep(long,int) Thread#sleep(long, int)} using
 * this time unit.
 * This is a convenience method that converts time arguments into the
 * form required by the {@code Thread.sleep} method.
 *
 * @param timeout the minimum time to sleep. If less than
 * or equal to zero, do not sleep at all.
 * @throws java.lang.InterruptedException if interrupted while sleeping
 * @apiSince 1
 */

public void sleep(long timeout) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }
}

