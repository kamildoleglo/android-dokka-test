/*
 * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
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
 * Copyright (c) 2007-2012, Stephen Colebourne & Michael Nascimento Santos
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 *  * Neither the name of JSR-310 nor the names of its contributors
 *    may be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */


package java.time;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.time.temporal.TemporalAmount;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.time.temporal.Temporal;

/**
 * A time-based amount of time, such as '34.5 seconds'.
 * <p>
 * This class models a quantity or amount of time in terms of seconds and nanoseconds.
 * It can be accessed using other duration-based units, such as minutes and hours.
 * In addition, the {@link java.time.temporal.ChronoUnit#DAYS ChronoUnit#DAYS} unit can be used and is treated as
 * exactly equal to 24 hours, thus ignoring daylight savings effects.
 * See {@link java.time.Period Period} for the date-based equivalent to this class.
 * <p>
 * A physical duration could be of infinite length.
 * For practicality, the duration is stored with constraints similar to {@link java.time.Instant Instant}.
 * The duration uses nanosecond resolution with a maximum value of the seconds that can
 * be held in a {@code long}. This is greater than the current estimated age of the universe.
 * <p>
 * The range of a duration requires the storage of a number larger than a {@code long}.
 * To achieve this, the class stores a {@code long} representing seconds and an {@code int}
 * representing nanosecond-of-second, which will always be between 0 and 999,999,999.
 * The model is of a directed duration, meaning that the duration may be negative.
 * <p>
 * The duration is measured in "seconds", but these are not necessarily identical to
 * the scientific "SI second" definition based on atomic clocks.
 * This difference only impacts durations measured near a leap-second and should not affect
 * most applications.
 * See {@link java.time.Instant Instant} for a discussion as to the meaning of the second and time-scales.
 *
 * @implSpec
 * This class is immutable and thread-safe.
 *
 * @since 1.8
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Duration implements java.time.temporal.TemporalAmount, java.lang.Comparable<java.time.Duration>, java.io.Serializable {

private Duration() { throw new RuntimeException("Stub!"); }

/**
 * Obtains a {@code Duration} representing a number of standard 24 hour days.
 * <p>
 * The seconds are calculated based on the standard definition of a day,
 * where each day is 86400 seconds which implies a 24 hour day.
 * The nanosecond in second field is set to zero.
 *
 * @param days  the number of days, positive or negative
 * @return a {@code Duration}, not null
 * @throws java.lang.ArithmeticException if the input days exceeds the capacity of {@code Duration}
 * @apiSince 26
 */

public static java.time.Duration ofDays(long days) { throw new RuntimeException("Stub!"); }

/**
 * Obtains a {@code Duration} representing a number of standard hours.
 * <p>
 * The seconds are calculated based on the standard definition of an hour,
 * where each hour is 3600 seconds.
 * The nanosecond in second field is set to zero.
 *
 * @param hours  the number of hours, positive or negative
 * @return a {@code Duration}, not null
 * @throws java.lang.ArithmeticException if the input hours exceeds the capacity of {@code Duration}
 * @apiSince 26
 */

public static java.time.Duration ofHours(long hours) { throw new RuntimeException("Stub!"); }

/**
 * Obtains a {@code Duration} representing a number of standard minutes.
 * <p>
 * The seconds are calculated based on the standard definition of a minute,
 * where each minute is 60 seconds.
 * The nanosecond in second field is set to zero.
 *
 * @param minutes  the number of minutes, positive or negative
 * @return a {@code Duration}, not null
 * @throws java.lang.ArithmeticException if the input minutes exceeds the capacity of {@code Duration}
 * @apiSince 26
 */

public static java.time.Duration ofMinutes(long minutes) { throw new RuntimeException("Stub!"); }

/**
 * Obtains a {@code Duration} representing a number of seconds.
 * <p>
 * The nanosecond in second field is set to zero.
 *
 * @param seconds  the number of seconds, positive or negative
 * @return a {@code Duration}, not null
 * @apiSince 26
 */

public static java.time.Duration ofSeconds(long seconds) { throw new RuntimeException("Stub!"); }

/**
 * Obtains a {@code Duration} representing a number of seconds and an
 * adjustment in nanoseconds.
 * <p>
 * This method allows an arbitrary number of nanoseconds to be passed in.
 * The factory will alter the values of the second and nanosecond in order
 * to ensure that the stored nanosecond is in the range 0 to 999,999,999.
 * For example, the following will result in the exactly the same duration:
 * <pre>
 *  Duration.ofSeconds(3, 1);
 *  Duration.ofSeconds(4, -999_999_999);
 *  Duration.ofSeconds(2, 1000_000_001);
 * </pre>
 *
 * @param seconds  the number of seconds, positive or negative
 * @param nanoAdjustment  the nanosecond adjustment to the number of seconds, positive or negative
 * @return a {@code Duration}, not null
 * @throws java.lang.ArithmeticException if the adjustment causes the seconds to exceed the capacity of {@code Duration}
 * @apiSince 26
 */

public static java.time.Duration ofSeconds(long seconds, long nanoAdjustment) { throw new RuntimeException("Stub!"); }

/**
 * Obtains a {@code Duration} representing a number of milliseconds.
 * <p>
 * The seconds and nanoseconds are extracted from the specified milliseconds.
 *
 * @param millis  the number of milliseconds, positive or negative
 * @return a {@code Duration}, not null
 * @apiSince 26
 */

public static java.time.Duration ofMillis(long millis) { throw new RuntimeException("Stub!"); }

/**
 * Obtains a {@code Duration} representing a number of nanoseconds.
 * <p>
 * The seconds and nanoseconds are extracted from the specified nanoseconds.
 *
 * @param nanos  the number of nanoseconds, positive or negative
 * @return a {@code Duration}, not null
 * @apiSince 26
 */

public static java.time.Duration ofNanos(long nanos) { throw new RuntimeException("Stub!"); }

/**
 * Obtains a {@code Duration} representing an amount in the specified unit.
 * <p>
 * The parameters represent the two parts of a phrase like '6 Hours'. For example:
 * <pre>
 *  Duration.of(3, SECONDS);
 *  Duration.of(465, HOURS);
 * </pre>
 * Only a subset of units are accepted by this method.
 * The unit must either have an {@linkplain java.time.temporal.TemporalUnit#isDurationEstimated() TemporalUnit#isDurationEstimated()} or
 * be {@link java.time.temporal.ChronoUnit#DAYS ChronoUnit#DAYS} which is treated as 24 hours. Other units throw an exception.
 *
 * @param amount  the amount of the duration, measured in terms of the unit, positive or negative
 * @param unit  the unit that the duration is measured in, must have an exact duration, not null
 * @return a {@code Duration}, not null
 * @throws java.time.DateTimeException if the period unit has an estimated duration
 * @throws java.lang.ArithmeticException if a numeric overflow occurs
 * @apiSince 26
 */

public static java.time.Duration of(long amount, java.time.temporal.TemporalUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code Duration} from a temporal amount.
 * <p>
 * This obtains a duration based on the specified amount.
 * A {@code TemporalAmount} represents an  amount of time, which may be
 * date-based or time-based, which this factory extracts to a duration.
 * <p>
 * The conversion loops around the set of units from the amount and uses
 * the {@linkplain java.time.temporal.TemporalUnit#getDuration() TemporalUnit#getDuration()} of the unit to
 * calculate the total {@code Duration}.
 * Only a subset of units are accepted by this method. The unit must either
 * have an {@linkplain java.time.temporal.TemporalUnit#isDurationEstimated() TemporalUnit#isDurationEstimated()}
 * or be {@link java.time.temporal.ChronoUnit#DAYS ChronoUnit#DAYS} which is treated as 24 hours.
 * If any other units are found then an exception is thrown.
 *
 * @param amount  the temporal amount to convert, not null
 * @return the equivalent duration, not null
 * @throws java.time.DateTimeException if unable to convert to a {@code Duration}
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public static java.time.Duration from(java.time.temporal.TemporalAmount amount) { throw new RuntimeException("Stub!"); }

/**
 * Obtains a {@code Duration} from a text string such as {@code PnDTnHnMn.nS}.
 * <p>
 * This will parse a textual representation of a duration, including the
 * string produced by {@code toString()}. The formats accepted are based
 * on the ISO-8601 duration format {@code PnDTnHnMn.nS} with days
 * considered to be exactly 24 hours.
 * <p>
 * The string starts with an optional sign, denoted by the ASCII negative
 * or positive symbol. If negative, the whole period is negated.
 * The ASCII letter "P" is next in upper or lower case.
 * There are then four sections, each consisting of a number and a suffix.
 * The sections have suffixes in ASCII of "D", "H", "M" and "S" for
 * days, hours, minutes and seconds, accepted in upper or lower case.
 * The suffixes must occur in order. The ASCII letter "T" must occur before
 * the first occurrence, if any, of an hour, minute or second section.
 * At least one of the four sections must be present, and if "T" is present
 * there must be at least one section after the "T".
 * The number part of each section must consist of one or more ASCII digits.
 * The number may be prefixed by the ASCII negative or positive symbol.
 * The number of days, hours and minutes must parse to an {@code long}.
 * The number of seconds must parse to an {@code long} with optional fraction.
 * The decimal point may be either a dot or a comma.
 * The fractional part may have from zero to 9 digits.
 * <p>
 * The leading plus/minus sign, and negative values for other units are
 * not part of the ISO-8601 standard.
 * <p>
 * Examples:
 * <pre>
 *    "PT20.345S" -- parses as "20.345 seconds"
 *    "PT15M"     -- parses as "15 minutes" (where a minute is 60 seconds)
 *    "PT10H"     -- parses as "10 hours" (where an hour is 3600 seconds)
 *    "P2D"       -- parses as "2 days" (where a day is 24 hours or 86400 seconds)
 *    "P2DT3H4M"  -- parses as "2 days, 3 hours and 4 minutes"
 *    "P-6H3M"    -- parses as "-6 hours and +3 minutes"
 *    "-P6H3M"    -- parses as "-6 hours and -3 minutes"
 *    "-P-6H+3M"  -- parses as "+6 hours and -3 minutes"
 * </pre>
 *
 * @param text  the text to parse, not null
 * @return the parsed duration, not null
 * @throws java.time.format.DateTimeParseException if the text cannot be parsed to a duration
 * @apiSince 26
 */

public static java.time.Duration parse(java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }

/**
 * Obtains a {@code Duration} representing the duration between two temporal objects.
 * <p>
 * This calculates the duration between two temporal objects. If the objects
 * are of different types, then the duration is calculated based on the type
 * of the first object. For example, if the first argument is a {@code LocalTime}
 * then the second argument is converted to a {@code LocalTime}.
 * <p>
 * The specified temporal objects must support the {@link java.time.temporal.ChronoUnit#SECONDS ChronoUnit#SECONDS} unit.
 * For full accuracy, either the {@link java.time.temporal.ChronoUnit#NANOS ChronoUnit#NANOS} unit or the
 * {@link java.time.temporal.ChronoField#NANO_OF_SECOND ChronoField#NANO_OF_SECOND} field should be supported.
 * <p>
 * The result of this method can be a negative period if the end is before the start.
 * To guarantee to obtain a positive duration call {@link #abs()} on the result.
 *
 * @param startInclusive  the start instant, inclusive, not null
 * @param endExclusive  the end instant, exclusive, not null
 * @return a {@code Duration}, not null
 * @throws java.time.DateTimeException if the seconds between the temporals cannot be obtained
 * @throws java.lang.ArithmeticException if the calculation exceeds the capacity of {@code Duration}
 * @apiSince 26
 */

public static java.time.Duration between(java.time.temporal.Temporal startInclusive, java.time.temporal.Temporal endExclusive) { throw new RuntimeException("Stub!"); }

/**
 * Gets the value of the requested unit.
 * <p>
 * This returns a value for each of the two supported units,
 * {@link java.time.temporal.ChronoUnit#SECONDS ChronoUnit#SECONDS} and {@link java.time.temporal.ChronoUnit#NANOS ChronoUnit#NANOS}.
 * All other units throw an exception.
 *
 * @param unit the {@code TemporalUnit} for which to return the value
 * @return the long value of the unit
 * @throws java.time.DateTimeException if the unit is not supported
 * @throws java.time.temporal.UnsupportedTemporalTypeException if the unit is not supported
 * @apiSince 26
 */

public long get(java.time.temporal.TemporalUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * Gets the set of units supported by this duration.
 * <p>
 * The supported units are {@link java.time.temporal.ChronoUnit#SECONDS ChronoUnit#SECONDS},
 * and {@link java.time.temporal.ChronoUnit#NANOS ChronoUnit#NANOS}.
 * They are returned in the order seconds, nanos.
 * <p>
 * This set can be used in conjunction with {@link #get(java.time.temporal.TemporalUnit)}
 * to access the entire state of the duration.
 *
 * @return a list containing the seconds and nanos units, not null
 * @apiSince 26
 */

public java.util.List<java.time.temporal.TemporalUnit> getUnits() { throw new RuntimeException("Stub!"); }

/**
 * Checks if this duration is zero length.
 * <p>
 * A {@code Duration} represents a directed distance between two points on
 * the time-line and can therefore be positive, zero or negative.
 * This method checks whether the length is zero.
 *
 * @return true if this duration has a total length equal to zero
 * @apiSince 26
 */

public boolean isZero() { throw new RuntimeException("Stub!"); }

/**
 * Checks if this duration is negative, excluding zero.
 * <p>
 * A {@code Duration} represents a directed distance between two points on
 * the time-line and can therefore be positive, zero or negative.
 * This method checks whether the length is less than zero.
 *
 * @return true if this duration has a total length less than zero
 * @apiSince 26
 */

public boolean isNegative() { throw new RuntimeException("Stub!"); }

/**
 * Gets the number of seconds in this duration.
 * <p>
 * The length of the duration is stored using two fields - seconds and nanoseconds.
 * The nanoseconds part is a value from 0 to 999,999,999 that is an adjustment to
 * the length in seconds.
 * The total duration is defined by calling this method and {@link #getNano()}.
 * <p>
 * A {@code Duration} represents a directed distance between two points on the time-line.
 * A negative duration is expressed by the negative sign of the seconds part.
 * A duration of -1 nanosecond is stored as -1 seconds plus 999,999,999 nanoseconds.
 *
 * @return the whole seconds part of the length of the duration, positive or negative
 * @apiSince 26
 */

public long getSeconds() { throw new RuntimeException("Stub!"); }

/**
 * Gets the number of nanoseconds within the second in this duration.
 * <p>
 * The length of the duration is stored using two fields - seconds and nanoseconds.
 * The nanoseconds part is a value from 0 to 999,999,999 that is an adjustment to
 * the length in seconds.
 * The total duration is defined by calling this method and {@link #getSeconds()}.
 * <p>
 * A {@code Duration} represents a directed distance between two points on the time-line.
 * A negative duration is expressed by the negative sign of the seconds part.
 * A duration of -1 nanosecond is stored as -1 seconds plus 999,999,999 nanoseconds.
 *
 * @return the nanoseconds within the second part of the length of the duration, from 0 to 999,999,999
 * @apiSince 26
 */

public int getNano() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this duration with the specified amount of seconds.
 * <p>
 * This returns a duration with the specified seconds, retaining the
 * nano-of-second part of this duration.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param seconds  the seconds to represent, may be negative
 * @return a {@code Duration} based on this period with the requested seconds, not null
 * @apiSince 26
 */

public java.time.Duration withSeconds(long seconds) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this duration with the specified nano-of-second.
 * <p>
 * This returns a duration with the specified nano-of-second, retaining the
 * seconds part of this duration.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param nanoOfSecond  the nano-of-second to represent, from 0 to 999,999,999
 * @return a {@code Duration} based on this period with the requested nano-of-second, not null
 * @throws java.time.DateTimeException if the nano-of-second is invalid
 * @apiSince 26
 */

public java.time.Duration withNanos(int nanoOfSecond) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this duration with the specified duration added.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param duration  the duration to add, positive or negative, not null
 * @return a {@code Duration} based on this duration with the specified duration added, not null
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public java.time.Duration plus(java.time.Duration duration) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this duration with the specified duration added.
 * <p>
 * The duration amount is measured in terms of the specified unit.
 * Only a subset of units are accepted by this method.
 * The unit must either have an {@linkplain java.time.temporal.TemporalUnit#isDurationEstimated() TemporalUnit#isDurationEstimated()} or
 * be {@link java.time.temporal.ChronoUnit#DAYS ChronoUnit#DAYS} which is treated as 24 hours. Other units throw an exception.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param amountToAdd  the amount to add, measured in terms of the unit, positive or negative
 * @param unit  the unit that the amount is measured in, must have an exact duration, not null
 * @return a {@code Duration} based on this duration with the specified duration added, not null
 * @throws java.time.temporal.UnsupportedTemporalTypeException if the unit is not supported
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public java.time.Duration plus(long amountToAdd, java.time.temporal.TemporalUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this duration with the specified duration in standard 24 hour days added.
 * <p>
 * The number of days is multiplied by 86400 to obtain the number of seconds to add.
 * This is based on the standard definition of a day as 24 hours.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param daysToAdd  the days to add, positive or negative
 * @return a {@code Duration} based on this duration with the specified days added, not null
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public java.time.Duration plusDays(long daysToAdd) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this duration with the specified duration in hours added.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param hoursToAdd  the hours to add, positive or negative
 * @return a {@code Duration} based on this duration with the specified hours added, not null
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public java.time.Duration plusHours(long hoursToAdd) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this duration with the specified duration in minutes added.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param minutesToAdd  the minutes to add, positive or negative
 * @return a {@code Duration} based on this duration with the specified minutes added, not null
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public java.time.Duration plusMinutes(long minutesToAdd) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this duration with the specified duration in seconds added.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param secondsToAdd  the seconds to add, positive or negative
 * @return a {@code Duration} based on this duration with the specified seconds added, not null
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public java.time.Duration plusSeconds(long secondsToAdd) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this duration with the specified duration in milliseconds added.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param millisToAdd  the milliseconds to add, positive or negative
 * @return a {@code Duration} based on this duration with the specified milliseconds added, not null
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public java.time.Duration plusMillis(long millisToAdd) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this duration with the specified duration in nanoseconds added.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param nanosToAdd  the nanoseconds to add, positive or negative
 * @return a {@code Duration} based on this duration with the specified nanoseconds added, not null
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public java.time.Duration plusNanos(long nanosToAdd) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this duration with the specified duration subtracted.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param duration  the duration to subtract, positive or negative, not null
 * @return a {@code Duration} based on this duration with the specified duration subtracted, not null
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public java.time.Duration minus(java.time.Duration duration) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this duration with the specified duration subtracted.
 * <p>
 * The duration amount is measured in terms of the specified unit.
 * Only a subset of units are accepted by this method.
 * The unit must either have an {@linkplain java.time.temporal.TemporalUnit#isDurationEstimated() TemporalUnit#isDurationEstimated()} or
 * be {@link java.time.temporal.ChronoUnit#DAYS ChronoUnit#DAYS} which is treated as 24 hours. Other units throw an exception.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param amountToSubtract  the amount to subtract, measured in terms of the unit, positive or negative
 * @param unit  the unit that the amount is measured in, must have an exact duration, not null
 * @return a {@code Duration} based on this duration with the specified duration subtracted, not null
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public java.time.Duration minus(long amountToSubtract, java.time.temporal.TemporalUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this duration with the specified duration in standard 24 hour days subtracted.
 * <p>
 * The number of days is multiplied by 86400 to obtain the number of seconds to subtract.
 * This is based on the standard definition of a day as 24 hours.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param daysToSubtract  the days to subtract, positive or negative
 * @return a {@code Duration} based on this duration with the specified days subtracted, not null
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public java.time.Duration minusDays(long daysToSubtract) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this duration with the specified duration in hours subtracted.
 * <p>
 * The number of hours is multiplied by 3600 to obtain the number of seconds to subtract.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param hoursToSubtract  the hours to subtract, positive or negative
 * @return a {@code Duration} based on this duration with the specified hours subtracted, not null
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public java.time.Duration minusHours(long hoursToSubtract) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this duration with the specified duration in minutes subtracted.
 * <p>
 * The number of hours is multiplied by 60 to obtain the number of seconds to subtract.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param minutesToSubtract  the minutes to subtract, positive or negative
 * @return a {@code Duration} based on this duration with the specified minutes subtracted, not null
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public java.time.Duration minusMinutes(long minutesToSubtract) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this duration with the specified duration in seconds subtracted.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param secondsToSubtract  the seconds to subtract, positive or negative
 * @return a {@code Duration} based on this duration with the specified seconds subtracted, not null
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public java.time.Duration minusSeconds(long secondsToSubtract) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this duration with the specified duration in milliseconds subtracted.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param millisToSubtract  the milliseconds to subtract, positive or negative
 * @return a {@code Duration} based on this duration with the specified milliseconds subtracted, not null
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public java.time.Duration minusMillis(long millisToSubtract) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this duration with the specified duration in nanoseconds subtracted.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param nanosToSubtract  the nanoseconds to subtract, positive or negative
 * @return a {@code Duration} based on this duration with the specified nanoseconds subtracted, not null
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public java.time.Duration minusNanos(long nanosToSubtract) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this duration multiplied by the scalar.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param multiplicand  the value to multiply the duration by, positive or negative
 * @return a {@code Duration} based on this duration multiplied by the specified scalar, not null
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public java.time.Duration multipliedBy(long multiplicand) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this duration divided by the specified value.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param divisor  the value to divide the duration by, positive or negative, not zero
 * @return a {@code Duration} based on this duration divided by the specified divisor, not null
 * @throws java.lang.ArithmeticException if the divisor is zero or if numeric overflow occurs
 * @apiSince 26
 */

public java.time.Duration dividedBy(long divisor) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this duration with the length negated.
 * <p>
 * This method swaps the sign of the total length of this duration.
 * For example, {@code PT1.3S} will be returned as {@code PT-1.3S}.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @return a {@code Duration} based on this duration with the amount negated, not null
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public java.time.Duration negated() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this duration with a positive length.
 * <p>
 * This method returns a positive duration by effectively removing the sign from any negative total length.
 * For example, {@code PT-1.3S} will be returned as {@code PT1.3S}.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @return a {@code Duration} based on this duration with an absolute length, not null
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public java.time.Duration abs() { throw new RuntimeException("Stub!"); }

/**
 * Adds this duration to the specified temporal object.
 * <p>
 * This returns a temporal object of the same observable type as the input
 * with this duration added.
 * <p>
 * In most cases, it is clearer to reverse the calling pattern by using
 * {@link java.time.temporal.Temporal#plus(java.time.temporal.TemporalAmount) Temporal#plus(TemporalAmount)}.
 * <pre>
 *   // these two lines are equivalent, but the second approach is recommended
 *   dateTime = thisDuration.addTo(dateTime);
 *   dateTime = dateTime.plus(thisDuration);
 * </pre>
 * <p>
 * The calculation will add the seconds, then nanos.
 * Only non-zero amounts will be added.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param temporal  the temporal object to adjust, not null
 * @return an object of the same type with the adjustment made, not null
 * @throws java.time.DateTimeException if unable to add
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public java.time.temporal.Temporal addTo(java.time.temporal.Temporal temporal) { throw new RuntimeException("Stub!"); }

/**
 * Subtracts this duration from the specified temporal object.
 * <p>
 * This returns a temporal object of the same observable type as the input
 * with this duration subtracted.
 * <p>
 * In most cases, it is clearer to reverse the calling pattern by using
 * {@link java.time.temporal.Temporal#minus(java.time.temporal.TemporalAmount) Temporal#minus(TemporalAmount)}.
 * <pre>
 *   // these two lines are equivalent, but the second approach is recommended
 *   dateTime = thisDuration.subtractFrom(dateTime);
 *   dateTime = dateTime.minus(thisDuration);
 * </pre>
 * <p>
 * The calculation will subtract the seconds, then nanos.
 * Only non-zero amounts will be added.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param temporal  the temporal object to adjust, not null
 * @return an object of the same type with the adjustment made, not null
 * @throws java.time.DateTimeException if unable to subtract
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public java.time.temporal.Temporal subtractFrom(java.time.temporal.Temporal temporal) { throw new RuntimeException("Stub!"); }

/**
 * Gets the number of days in this duration.
 * <p>
 * This returns the total number of days in the duration by dividing the
 * number of seconds by 86400.
 * This is based on the standard definition of a day as 24 hours.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @return the number of days in the duration, may be negative
 * @apiSince 26
 */

public long toDays() { throw new RuntimeException("Stub!"); }

/**
 * Gets the number of hours in this duration.
 * <p>
 * This returns the total number of hours in the duration by dividing the
 * number of seconds by 3600.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @return the number of hours in the duration, may be negative
 * @apiSince 26
 */

public long toHours() { throw new RuntimeException("Stub!"); }

/**
 * Gets the number of minutes in this duration.
 * <p>
 * This returns the total number of minutes in the duration by dividing the
 * number of seconds by 60.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @return the number of minutes in the duration, may be negative
 * @apiSince 26
 */

public long toMinutes() { throw new RuntimeException("Stub!"); }

/**
 * Converts this duration to the total length in milliseconds.
 * <p>
 * If this duration is too large to fit in a {@code long} milliseconds, then an
 * exception is thrown.
 * <p>
 * If this duration has greater than millisecond precision, then the conversion
 * will drop any excess precision information as though the amount in nanoseconds
 * was subject to integer division by one million.
 *
 * @return the total length of the duration in milliseconds
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public long toMillis() { throw new RuntimeException("Stub!"); }

/**
 * Converts this duration to the total length in nanoseconds expressed as a {@code long}.
 * <p>
 * If this duration is too large to fit in a {@code long} nanoseconds, then an
 * exception is thrown.
 *
 * @return the total length of the duration in nanoseconds
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public long toNanos() { throw new RuntimeException("Stub!"); }

/**
 * Compares this duration to the specified {@code Duration}.
 * <p>
 * The comparison is based on the total length of the durations.
 * It is "consistent with equals", as defined by {@link java.lang.Comparable Comparable}.
 *
 * @param otherDuration  the other duration to compare to, not null
 * @return the comparator value, negative if less, positive if greater
 * @apiSince 26
 */

public int compareTo(java.time.Duration otherDuration) { throw new RuntimeException("Stub!"); }

/**
 * Checks if this duration is equal to the specified {@code Duration}.
 * <p>
 * The comparison is based on the total length of the durations.
 *
 * @param otherDuration  the other duration, null returns false
 * @return true if the other duration is equal to this one
 * @apiSince 26
 */

public boolean equals(java.lang.Object otherDuration) { throw new RuntimeException("Stub!"); }

/**
 * A hash code for this duration.
 *
 * @return a suitable hash code
 * @apiSince 26
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * A string representation of this duration using ISO-8601 seconds
 * based representation, such as {@code PT8H6M12.345S}.
 * <p>
 * The format of the returned string will be {@code PTnHnMnS}, where n is
 * the relevant hours, minutes or seconds part of the duration.
 * Any fractional seconds are placed after a decimal point i the seconds section.
 * If a section has a zero value, it is omitted.
 * The hours, minutes and seconds will all have the same sign.
 * <p>
 * Examples:
 * <pre>
 *    "20.345 seconds"                 -- "PT20.345S
 *    "15 minutes" (15 * 60 seconds)   -- "PT15M"
 *    "10 hours" (10 * 3600 seconds)   -- "PT10H"
 *    "2 days" (2 * 86400 seconds)     -- "PT48H"
 * </pre>
 * Note that multiples of 24 hours are not output as days to avoid confusion
 * with {@code Period}.
 *
 * @return an ISO-8601 representation of this duration, not null
 * @apiSince 26
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Constant for a duration of zero.
 * @apiSince 26
 */

public static final java.time.Duration ZERO;
static { ZERO = null; }
}

