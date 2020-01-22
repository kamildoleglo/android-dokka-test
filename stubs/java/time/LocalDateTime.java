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

import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.time.temporal.Temporal;
import java.time.temporal.ChronoUnit;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAmount;
import java.time.zone.ZoneRules;
import java.time.chrono.ChronoLocalDateTime;

/**
 * A date-time without a time-zone in the ISO-8601 calendar system,
 * such as {@code 2007-12-03T10:15:30}.
 * <p>
 * {@code LocalDateTime} is an immutable date-time object that represents a date-time,
 * often viewed as year-month-day-hour-minute-second. Other date and time fields,
 * such as day-of-year, day-of-week and week-of-year, can also be accessed.
 * Time is represented to nanosecond precision.
 * For example, the value "2nd October 2007 at 13:45.30.123456789" can be
 * stored in a {@code LocalDateTime}.
 * <p>
 * This class does not store or represent a time-zone.
 * Instead, it is a description of the date, as used for birthdays, combined with
 * the local time as seen on a wall clock.
 * It cannot represent an instant on the time-line without additional information
 * such as an offset or time-zone.
 * <p>
 * The ISO-8601 calendar system is the modern civil calendar system used today
 * in most of the world. It is equivalent to the proleptic Gregorian calendar
 * system, in which today's rules for leap years are applied for all time.
 * For most applications written today, the ISO-8601 rules are entirely suitable.
 * However, any application that makes use of historical dates, and requires them
 * to be accurate will find the ISO-8601 approach unsuitable.
 *
 * @implSpec
 * This class is immutable and thread-safe.
 *
 * @since 1.8
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class LocalDateTime implements java.time.temporal.Temporal, java.time.temporal.TemporalAdjuster, java.time.chrono.ChronoLocalDateTime<java.time.LocalDate>, java.io.Serializable {

private LocalDateTime() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the current date-time from the system clock in the default time-zone.
 * <p>
 * This will query the {@link java.time.Clock#systemDefaultZone() Clock#systemDefaultZone()} in the default
 * time-zone to obtain the current date-time.
 * <p>
 * Using this method will prevent the ability to use an alternate clock for testing
 * because the clock is hard-coded.
 *
 * @return the current date-time using the system clock and default time-zone, not null
 * @apiSince 26
 */

public static java.time.LocalDateTime now() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the current date-time from the system clock in the specified time-zone.
 * <p>
 * This will query the {@link java.time.Clock#system(java.time.ZoneId) Clock#system(ZoneId)} to obtain the current date-time.
 * Specifying the time-zone avoids dependence on the default time-zone.
 * <p>
 * Using this method will prevent the ability to use an alternate clock for testing
 * because the clock is hard-coded.
 *
 * @param zone  the zone ID to use, not null
 * @return the current date-time using the system clock, not null
 * @apiSince 26
 */

public static java.time.LocalDateTime now(java.time.ZoneId zone) { throw new RuntimeException("Stub!"); }

/**
 * Obtains the current date-time from the specified clock.
 * <p>
 * This will query the specified clock to obtain the current date-time.
 * Using this method allows the use of an alternate clock for testing.
 * The alternate clock may be introduced using {@link java.time.Clock Clock}.
 *
 * @param clock  the clock to use, not null
 * @return the current date-time, not null
 * @apiSince 26
 */

public static java.time.LocalDateTime now(java.time.Clock clock) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code LocalDateTime} from year, month,
 * day, hour and minute, setting the second and nanosecond to zero.
 * <p>
 * This returns a {@code LocalDateTime} with the specified year, month,
 * day-of-month, hour and minute.
 * The day must be valid for the year and month, otherwise an exception will be thrown.
 * The second and nanosecond fields will be set to zero.
 *
 * @param year  the year to represent, from MIN_YEAR to MAX_YEAR
 * @param month  the month-of-year to represent, not null
 * @param dayOfMonth  the day-of-month to represent, from 1 to 31
 * @param hour  the hour-of-day to represent, from 0 to 23
 * @param minute  the minute-of-hour to represent, from 0 to 59
 * @return the local date-time, not null
 * @throws java.time.DateTimeException if the value of any field is out of range,
 *  or if the day-of-month is invalid for the month-year
 * @apiSince 26
 */

public static java.time.LocalDateTime of(int year, java.time.Month month, int dayOfMonth, int hour, int minute) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code LocalDateTime} from year, month,
 * day, hour, minute and second, setting the nanosecond to zero.
 * <p>
 * This returns a {@code LocalDateTime} with the specified year, month,
 * day-of-month, hour, minute and second.
 * The day must be valid for the year and month, otherwise an exception will be thrown.
 * The nanosecond field will be set to zero.
 *
 * @param year  the year to represent, from MIN_YEAR to MAX_YEAR
 * @param month  the month-of-year to represent, not null
 * @param dayOfMonth  the day-of-month to represent, from 1 to 31
 * @param hour  the hour-of-day to represent, from 0 to 23
 * @param minute  the minute-of-hour to represent, from 0 to 59
 * @param second  the second-of-minute to represent, from 0 to 59
 * @return the local date-time, not null
 * @throws java.time.DateTimeException if the value of any field is out of range,
 *  or if the day-of-month is invalid for the month-year
 * @apiSince 26
 */

public static java.time.LocalDateTime of(int year, java.time.Month month, int dayOfMonth, int hour, int minute, int second) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code LocalDateTime} from year, month,
 * day, hour, minute, second and nanosecond.
 * <p>
 * This returns a {@code LocalDateTime} with the specified year, month,
 * day-of-month, hour, minute, second and nanosecond.
 * The day must be valid for the year and month, otherwise an exception will be thrown.
 *
 * @param year  the year to represent, from MIN_YEAR to MAX_YEAR
 * @param month  the month-of-year to represent, not null
 * @param dayOfMonth  the day-of-month to represent, from 1 to 31
 * @param hour  the hour-of-day to represent, from 0 to 23
 * @param minute  the minute-of-hour to represent, from 0 to 59
 * @param second  the second-of-minute to represent, from 0 to 59
 * @param nanoOfSecond  the nano-of-second to represent, from 0 to 999,999,999
 * @return the local date-time, not null
 * @throws java.time.DateTimeException if the value of any field is out of range,
 *  or if the day-of-month is invalid for the month-year
 * @apiSince 26
 */

public static java.time.LocalDateTime of(int year, java.time.Month month, int dayOfMonth, int hour, int minute, int second, int nanoOfSecond) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code LocalDateTime} from year, month,
 * day, hour and minute, setting the second and nanosecond to zero.
 * <p>
 * This returns a {@code LocalDateTime} with the specified year, month,
 * day-of-month, hour and minute.
 * The day must be valid for the year and month, otherwise an exception will be thrown.
 * The second and nanosecond fields will be set to zero.
 *
 * @param year  the year to represent, from MIN_YEAR to MAX_YEAR
 * @param month  the month-of-year to represent, from 1 (January) to 12 (December)
 * @param dayOfMonth  the day-of-month to represent, from 1 to 31
 * @param hour  the hour-of-day to represent, from 0 to 23
 * @param minute  the minute-of-hour to represent, from 0 to 59
 * @return the local date-time, not null
 * @throws java.time.DateTimeException if the value of any field is out of range,
 *  or if the day-of-month is invalid for the month-year
 * @apiSince 26
 */

public static java.time.LocalDateTime of(int year, int month, int dayOfMonth, int hour, int minute) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code LocalDateTime} from year, month,
 * day, hour, minute and second, setting the nanosecond to zero.
 * <p>
 * This returns a {@code LocalDateTime} with the specified year, month,
 * day-of-month, hour, minute and second.
 * The day must be valid for the year and month, otherwise an exception will be thrown.
 * The nanosecond field will be set to zero.
 *
 * @param year  the year to represent, from MIN_YEAR to MAX_YEAR
 * @param month  the month-of-year to represent, from 1 (January) to 12 (December)
 * @param dayOfMonth  the day-of-month to represent, from 1 to 31
 * @param hour  the hour-of-day to represent, from 0 to 23
 * @param minute  the minute-of-hour to represent, from 0 to 59
 * @param second  the second-of-minute to represent, from 0 to 59
 * @return the local date-time, not null
 * @throws java.time.DateTimeException if the value of any field is out of range,
 *  or if the day-of-month is invalid for the month-year
 * @apiSince 26
 */

public static java.time.LocalDateTime of(int year, int month, int dayOfMonth, int hour, int minute, int second) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code LocalDateTime} from year, month,
 * day, hour, minute, second and nanosecond.
 * <p>
 * This returns a {@code LocalDateTime} with the specified year, month,
 * day-of-month, hour, minute, second and nanosecond.
 * The day must be valid for the year and month, otherwise an exception will be thrown.
 *
 * @param year  the year to represent, from MIN_YEAR to MAX_YEAR
 * @param month  the month-of-year to represent, from 1 (January) to 12 (December)
 * @param dayOfMonth  the day-of-month to represent, from 1 to 31
 * @param hour  the hour-of-day to represent, from 0 to 23
 * @param minute  the minute-of-hour to represent, from 0 to 59
 * @param second  the second-of-minute to represent, from 0 to 59
 * @param nanoOfSecond  the nano-of-second to represent, from 0 to 999,999,999
 * @return the local date-time, not null
 * @throws java.time.DateTimeException if the value of any field is out of range,
 *  or if the day-of-month is invalid for the month-year
 * @apiSince 26
 */

public static java.time.LocalDateTime of(int year, int month, int dayOfMonth, int hour, int minute, int second, int nanoOfSecond) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code LocalDateTime} from a date and time.
 *
 * @param date  the local date, not null
 * @param time  the local time, not null
 * @return the local date-time, not null
 * @apiSince 26
 */

public static java.time.LocalDateTime of(java.time.LocalDate date, java.time.LocalTime time) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code LocalDateTime} from an {@code Instant} and zone ID.
 * <p>
 * This creates a local date-time based on the specified instant.
 * First, the offset from UTC/Greenwich is obtained using the zone ID and instant,
 * which is simple as there is only one valid offset for each instant.
 * Then, the instant and offset are used to calculate the local date-time.
 *
 * @param instant  the instant to create the date-time from, not null
 * @param zone  the time-zone, which may be an offset, not null
 * @return the local date-time, not null
 * @throws java.time.DateTimeException if the result exceeds the supported range
 * @apiSince 26
 */

public static java.time.LocalDateTime ofInstant(java.time.Instant instant, java.time.ZoneId zone) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code LocalDateTime} using seconds from the
 * epoch of 1970-01-01T00:00:00Z.
 * <p>
 * This allows the {@link java.time.temporal.ChronoField#INSTANT_SECONDS ChronoField#INSTANT_SECONDS} field
 * to be converted to a local date-time. This is primarily intended for
 * low-level conversions rather than general application usage.
 *
 * @param epochSecond  the number of seconds from the epoch of 1970-01-01T00:00:00Z
 * @param nanoOfSecond  the nanosecond within the second, from 0 to 999,999,999
 * @param offset  the zone offset, not null
 * @return the local date-time, not null
 * @throws java.time.DateTimeException if the result exceeds the supported range,
 *  or if the nano-of-second is invalid
 * @apiSince 26
 */

public static java.time.LocalDateTime ofEpochSecond(long epochSecond, int nanoOfSecond, java.time.ZoneOffset offset) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code LocalDateTime} from a temporal object.
 * <p>
 * This obtains a local date-time based on the specified temporal.
 * A {@code TemporalAccessor} represents an arbitrary set of date and time information,
 * which this factory converts to an instance of {@code LocalDateTime}.
 * <p>
 * The conversion extracts and combines the {@code LocalDate} and the
 * {@code LocalTime} from the temporal object.
 * Implementations are permitted to perform optimizations such as accessing
 * those fields that are equivalent to the relevant objects.
 * <p>
 * This method matches the signature of the functional interface {@link java.time.temporal.TemporalQuery TemporalQuery}
 * allowing it to be used as a query via method reference, {@code LocalDateTime::from}.
 *
 * @param temporal  the temporal object to convert, not null
 * @return the local date-time, not null
 * @throws java.time.DateTimeException if unable to convert to a {@code LocalDateTime}
 * @apiSince 26
 */

public static java.time.LocalDateTime from(java.time.temporal.TemporalAccessor temporal) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code LocalDateTime} from a text string such as {@code 2007-12-03T10:15:30}.
 * <p>
 * The string must represent a valid date-time and is parsed using
 * {@link java.time.format.DateTimeFormatter#ISO_LOCAL_DATE_TIME}.
 *
 * @param text  the text to parse such as "2007-12-03T10:15:30", not null
 * @return the parsed local date-time, not null
 * @throws java.time.format.DateTimeParseException if the text cannot be parsed
 * @apiSince 26
 */

public static java.time.LocalDateTime parse(java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code LocalDateTime} from a text string using a specific formatter.
 * <p>
 * The text is parsed using the formatter, returning a date-time.
 *
 * @param text  the text to parse, not null
 * @param formatter  the formatter to use, not null
 * @return the parsed local date-time, not null
 * @throws java.time.format.DateTimeParseException if the text cannot be parsed
 * @apiSince 26
 */

public static java.time.LocalDateTime parse(java.lang.CharSequence text, java.time.format.DateTimeFormatter formatter) { throw new RuntimeException("Stub!"); }

/**
 * Checks if the specified field is supported.
 * <p>
 * This checks if this date-time can be queried for the specified field.
 * If false, then calling the {@link #range(java.time.temporal.TemporalField) range},
 * {@link #get(java.time.temporal.TemporalField) get} and {@link #with(java.time.temporal.TemporalField,long)}
 * methods will throw an exception.
 * <p>
 * If the field is a {@link java.time.temporal.ChronoField ChronoField} then the query is implemented here.
 * The supported fields are:
 * <ul>
 * <li>{@code NANO_OF_SECOND}
 * <li>{@code NANO_OF_DAY}
 * <li>{@code MICRO_OF_SECOND}
 * <li>{@code MICRO_OF_DAY}
 * <li>{@code MILLI_OF_SECOND}
 * <li>{@code MILLI_OF_DAY}
 * <li>{@code SECOND_OF_MINUTE}
 * <li>{@code SECOND_OF_DAY}
 * <li>{@code MINUTE_OF_HOUR}
 * <li>{@code MINUTE_OF_DAY}
 * <li>{@code HOUR_OF_AMPM}
 * <li>{@code CLOCK_HOUR_OF_AMPM}
 * <li>{@code HOUR_OF_DAY}
 * <li>{@code CLOCK_HOUR_OF_DAY}
 * <li>{@code AMPM_OF_DAY}
 * <li>{@code DAY_OF_WEEK}
 * <li>{@code ALIGNED_DAY_OF_WEEK_IN_MONTH}
 * <li>{@code ALIGNED_DAY_OF_WEEK_IN_YEAR}
 * <li>{@code DAY_OF_MONTH}
 * <li>{@code DAY_OF_YEAR}
 * <li>{@code EPOCH_DAY}
 * <li>{@code ALIGNED_WEEK_OF_MONTH}
 * <li>{@code ALIGNED_WEEK_OF_YEAR}
 * <li>{@code MONTH_OF_YEAR}
 * <li>{@code PROLEPTIC_MONTH}
 * <li>{@code YEAR_OF_ERA}
 * <li>{@code YEAR}
 * <li>{@code ERA}
 * </ul>
 * All other {@code ChronoField} instances will return false.
 * <p>
 * If the field is not a {@code ChronoField}, then the result of this method
 * is obtained by invoking {@code TemporalField.isSupportedBy(TemporalAccessor)}
 * passing {@code this} as the argument.
 * Whether the field is supported is determined by the field.
 *
 * @param field  the field to check, null returns false
 * @return true if the field is supported on this date-time, false if not
 * @apiSince 26
 */

public boolean isSupported(java.time.temporal.TemporalField field) { throw new RuntimeException("Stub!"); }

/**
 * Checks if the specified unit is supported.
 * <p>
 * This checks if the specified unit can be added to, or subtracted from, this date-time.
 * If false, then calling the {@link #plus(long,java.time.temporal.TemporalUnit)} and
 * {@link #minus(long,java.time.temporal.TemporalUnit) minus} methods will throw an exception.
 * <p>
 * If the unit is a {@link java.time.temporal.ChronoUnit ChronoUnit} then the query is implemented here.
 * The supported units are:
 * <ul>
 * <li>{@code NANOS}
 * <li>{@code MICROS}
 * <li>{@code MILLIS}
 * <li>{@code SECONDS}
 * <li>{@code MINUTES}
 * <li>{@code HOURS}
 * <li>{@code HALF_DAYS}
 * <li>{@code DAYS}
 * <li>{@code WEEKS}
 * <li>{@code MONTHS}
 * <li>{@code YEARS}
 * <li>{@code DECADES}
 * <li>{@code CENTURIES}
 * <li>{@code MILLENNIA}
 * <li>{@code ERAS}
 * </ul>
 * All other {@code ChronoUnit} instances will return false.
 * <p>
 * If the unit is not a {@code ChronoUnit}, then the result of this method
 * is obtained by invoking {@code TemporalUnit.isSupportedBy(Temporal)}
 * passing {@code this} as the argument.
 * Whether the unit is supported is determined by the unit.
 *
 * @param unit  the unit to check, null returns false
 * @return true if the unit can be added/subtracted, false if not
 * @apiSince 26
 */

public boolean isSupported(java.time.temporal.TemporalUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * Gets the range of valid values for the specified field.
 * <p>
 * The range object expresses the minimum and maximum valid values for a field.
 * This date-time is used to enhance the accuracy of the returned range.
 * If it is not possible to return the range, because the field is not supported
 * or for some other reason, an exception is thrown.
 * <p>
 * If the field is a {@link java.time.temporal.ChronoField ChronoField} then the query is implemented here.
 * The {@link #isSupported(java.time.temporal.TemporalField) supported fields} will return
 * appropriate range instances.
 * All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.
 * <p>
 * If the field is not a {@code ChronoField}, then the result of this method
 * is obtained by invoking {@code TemporalField.rangeRefinedBy(TemporalAccessor)}
 * passing {@code this} as the argument.
 * Whether the range can be obtained is determined by the field.
 *
 * @param field  the field to query the range for, not null
 * @return the range of valid values for the field, not null
 * @throws java.time.DateTimeException if the range for the field cannot be obtained
 * @throws java.time.temporal.UnsupportedTemporalTypeException if the field is not supported
 * @apiSince 26
 */

public java.time.temporal.ValueRange range(java.time.temporal.TemporalField field) { throw new RuntimeException("Stub!"); }

/**
 * Gets the value of the specified field from this date-time as an {@code int}.
 * <p>
 * This queries this date-time for the value of the specified field.
 * The returned value will always be within the valid range of values for the field.
 * If it is not possible to return the value, because the field is not supported
 * or for some other reason, an exception is thrown.
 * <p>
 * If the field is a {@link java.time.temporal.ChronoField ChronoField} then the query is implemented here.
 * The {@link #isSupported(java.time.temporal.TemporalField) supported fields} will return valid
 * values based on this date-time, except {@code NANO_OF_DAY}, {@code MICRO_OF_DAY},
 * {@code EPOCH_DAY} and {@code PROLEPTIC_MONTH} which are too large to fit in
 * an {@code int} and throw a {@code DateTimeException}.
 * All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.
 * <p>
 * If the field is not a {@code ChronoField}, then the result of this method
 * is obtained by invoking {@code TemporalField.getFrom(TemporalAccessor)}
 * passing {@code this} as the argument. Whether the value can be obtained,
 * and what the value represents, is determined by the field.
 *
 * @param field  the field to get, not null
 * @return the value for the field
 * @throws java.time.DateTimeException if a value for the field cannot be obtained or
 *         the value is outside the range of valid values for the field
 * @throws java.time.temporal.UnsupportedTemporalTypeException if the field is not supported or
 *         the range of values exceeds an {@code int}
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public int get(java.time.temporal.TemporalField field) { throw new RuntimeException("Stub!"); }

/**
 * Gets the value of the specified field from this date-time as a {@code long}.
 * <p>
 * This queries this date-time for the value of the specified field.
 * If it is not possible to return the value, because the field is not supported
 * or for some other reason, an exception is thrown.
 * <p>
 * If the field is a {@link java.time.temporal.ChronoField ChronoField} then the query is implemented here.
 * The {@link #isSupported(java.time.temporal.TemporalField) supported fields} will return valid
 * values based on this date-time.
 * All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.
 * <p>
 * If the field is not a {@code ChronoField}, then the result of this method
 * is obtained by invoking {@code TemporalField.getFrom(TemporalAccessor)}
 * passing {@code this} as the argument. Whether the value can be obtained,
 * and what the value represents, is determined by the field.
 *
 * @param field  the field to get, not null
 * @return the value for the field
 * @throws java.time.DateTimeException if a value for the field cannot be obtained
 * @throws java.time.temporal.UnsupportedTemporalTypeException if the field is not supported
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public long getLong(java.time.temporal.TemporalField field) { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@code LocalDate} part of this date-time.
 * <p>
 * This returns a {@code LocalDate} with the same year, month and day
 * as this date-time.
 *
 * @return the date part of this date-time, not null
 * @apiSince 26
 */

public java.time.LocalDate toLocalDate() { throw new RuntimeException("Stub!"); }

/**
 * Gets the year field.
 * <p>
 * This method returns the primitive {@code int} value for the year.
 * <p>
 * The year returned by this method is proleptic as per {@code get(YEAR)}.
 * To obtain the year-of-era, use {@code get(YEAR_OF_ERA)}.
 *
 * @return the year, from MIN_YEAR to MAX_YEAR
 * @apiSince 26
 */

public int getYear() { throw new RuntimeException("Stub!"); }

/**
 * Gets the month-of-year field from 1 to 12.
 * <p>
 * This method returns the month as an {@code int} from 1 to 12.
 * Application code is frequently clearer if the enum {@link java.time.Month Month}
 * is used by calling {@link #getMonth()}.
 *
 * @return the month-of-year, from 1 to 12
 * @see #getMonth()
 * @apiSince 26
 */

public int getMonthValue() { throw new RuntimeException("Stub!"); }

/**
 * Gets the month-of-year field using the {@code Month} enum.
 * <p>
 * This method returns the enum {@link java.time.Month Month} for the month.
 * This avoids confusion as to what {@code int} values mean.
 * If you need access to the primitive {@code int} value then the enum
 * provides the {@link java.time.Month#getValue() Month#getValue()}.
 *
 * @return the month-of-year, not null
 * @see #getMonthValue()
 * @apiSince 26
 */

public java.time.Month getMonth() { throw new RuntimeException("Stub!"); }

/**
 * Gets the day-of-month field.
 * <p>
 * This method returns the primitive {@code int} value for the day-of-month.
 *
 * @return the day-of-month, from 1 to 31
 * @apiSince 26
 */

public int getDayOfMonth() { throw new RuntimeException("Stub!"); }

/**
 * Gets the day-of-year field.
 * <p>
 * This method returns the primitive {@code int} value for the day-of-year.
 *
 * @return the day-of-year, from 1 to 365, or 366 in a leap year
 * @apiSince 26
 */

public int getDayOfYear() { throw new RuntimeException("Stub!"); }

/**
 * Gets the day-of-week field, which is an enum {@code DayOfWeek}.
 * <p>
 * This method returns the enum {@link java.time.DayOfWeek DayOfWeek} for the day-of-week.
 * This avoids confusion as to what {@code int} values mean.
 * If you need access to the primitive {@code int} value then the enum
 * provides the {@link java.time.DayOfWeek#getValue() DayOfWeek#getValue()}.
 * <p>
 * Additional information can be obtained from the {@code DayOfWeek}.
 * This includes textual names of the values.
 *
 * @return the day-of-week, not null
 * @apiSince 26
 */

public java.time.DayOfWeek getDayOfWeek() { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@code LocalTime} part of this date-time.
 * <p>
 * This returns a {@code LocalTime} with the same hour, minute, second and
 * nanosecond as this date-time.
 *
 * @return the time part of this date-time, not null
 * @apiSince 26
 */

public java.time.LocalTime toLocalTime() { throw new RuntimeException("Stub!"); }

/**
 * Gets the hour-of-day field.
 *
 * @return the hour-of-day, from 0 to 23
 * @apiSince 26
 */

public int getHour() { throw new RuntimeException("Stub!"); }

/**
 * Gets the minute-of-hour field.
 *
 * @return the minute-of-hour, from 0 to 59
 * @apiSince 26
 */

public int getMinute() { throw new RuntimeException("Stub!"); }

/**
 * Gets the second-of-minute field.
 *
 * @return the second-of-minute, from 0 to 59
 * @apiSince 26
 */

public int getSecond() { throw new RuntimeException("Stub!"); }

/**
 * Gets the nano-of-second field.
 *
 * @return the nano-of-second, from 0 to 999,999,999
 * @apiSince 26
 */

public int getNano() { throw new RuntimeException("Stub!"); }

/**
 * Returns an adjusted copy of this date-time.
 * <p>
 * This returns a {@code LocalDateTime}, based on this one, with the date-time adjusted.
 * The adjustment takes place using the specified adjuster strategy object.
 * Read the documentation of the adjuster to understand what adjustment will be made.
 * <p>
 * A simple adjuster might simply set the one of the fields, such as the year field.
 * A more complex adjuster might set the date to the last day of the month.
 * <p>
 * A selection of common adjustments is provided in
 * {@link java.time.temporal.TemporalAdjusters TemporalAdjusters}.
 * These include finding the "last day of the month" and "next Wednesday".
 * Key date-time classes also implement the {@code TemporalAdjuster} interface,
 * such as {@link java.time.Month Month} and {@link java.time.MonthDay MonthDay}.
 * The adjuster is responsible for handling special cases, such as the varying
 * lengths of month and leap years.
 * <p>
 * For example this code returns a date on the last day of July:
 * <pre>
 *  import static java.time.Month.*;
 *  import static java.time.temporal.TemporalAdjusters.*;
 *
 *  result = localDateTime.with(JULY).with(lastDayOfMonth());
 * </pre>
 * <p>
 * The classes {@link java.time.LocalDate LocalDate} and {@link java.time.LocalTime LocalTime} implement {@code TemporalAdjuster},
 * thus this method can be used to change the date, time or offset:
 * <pre>
 *  result = localDateTime.with(date);
 *  result = localDateTime.with(time);
 * </pre>
 * <p>
 * The result of this method is obtained by invoking the
 * {@link java.time.temporal.TemporalAdjuster#adjustInto(java.time.temporal.Temporal) TemporalAdjuster#adjustInto(Temporal)} method on the
 * specified adjuster passing {@code this} as the argument.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param adjuster the adjuster to use, not null
 * @return a {@code LocalDateTime} based on {@code this} with the adjustment made, not null
 * @throws java.time.DateTimeException if the adjustment cannot be made
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public java.time.LocalDateTime with(java.time.temporal.TemporalAdjuster adjuster) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this date-time with the specified field set to a new value.
 * <p>
 * This returns a {@code LocalDateTime}, based on this one, with the value
 * for the specified field changed.
 * This can be used to change any supported field, such as the year, month or day-of-month.
 * If it is not possible to set the value, because the field is not supported or for
 * some other reason, an exception is thrown.
 * <p>
 * In some cases, changing the specified field can cause the resulting date-time to become invalid,
 * such as changing the month from 31st January to February would make the day-of-month invalid.
 * In cases like this, the field is responsible for resolving the date. Typically it will choose
 * the previous valid date, which would be the last valid day of February in this example.
 * <p>
 * If the field is a {@link java.time.temporal.ChronoField ChronoField} then the adjustment is implemented here.
 * The {@link #isSupported(java.time.temporal.TemporalField) supported fields} will behave as per
 * the matching method on {@link java.time.LocalDate#with(java.time.temporal.TemporalField,long) LocalDate#with(TemporalField, long)}
 * or {@link java.time.LocalTime#with(java.time.temporal.TemporalField,long) LocalTime#with(TemporalField, long)}.
 * All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.
 * <p>
 * If the field is not a {@code ChronoField}, then the result of this method
 * is obtained by invoking {@code TemporalField.adjustInto(Temporal, long)}
 * passing {@code this} as the argument. In this case, the field determines
 * whether and how to adjust the instant.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param field  the field to set in the result, not null
 * @param newValue  the new value of the field in the result
 * @return a {@code LocalDateTime} based on {@code this} with the specified field set, not null
 * @throws java.time.DateTimeException if the field cannot be set
 * @throws java.time.temporal.UnsupportedTemporalTypeException if the field is not supported
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public java.time.LocalDateTime with(java.time.temporal.TemporalField field, long newValue) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this {@code LocalDateTime} with the year altered.
 * <p>
 * The time does not affect the calculation and will be the same in the result.
 * If the day-of-month is invalid for the year, it will be changed to the last valid day of the month.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param year  the year to set in the result, from MIN_YEAR to MAX_YEAR
 * @return a {@code LocalDateTime} based on this date-time with the requested year, not null
 * @throws java.time.DateTimeException if the year value is invalid
 * @apiSince 26
 */

public java.time.LocalDateTime withYear(int year) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this {@code LocalDateTime} with the month-of-year altered.
 * <p>
 * The time does not affect the calculation and will be the same in the result.
 * If the day-of-month is invalid for the year, it will be changed to the last valid day of the month.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param month  the month-of-year to set in the result, from 1 (January) to 12 (December)
 * @return a {@code LocalDateTime} based on this date-time with the requested month, not null
 * @throws java.time.DateTimeException if the month-of-year value is invalid
 * @apiSince 26
 */

public java.time.LocalDateTime withMonth(int month) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this {@code LocalDateTime} with the day-of-month altered.
 * <p>
 * If the resulting date-time is invalid, an exception is thrown.
 * The time does not affect the calculation and will be the same in the result.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param dayOfMonth  the day-of-month to set in the result, from 1 to 28-31
 * @return a {@code LocalDateTime} based on this date-time with the requested day, not null
 * @throws java.time.DateTimeException if the day-of-month value is invalid,
 *  or if the day-of-month is invalid for the month-year
 * @apiSince 26
 */

public java.time.LocalDateTime withDayOfMonth(int dayOfMonth) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this {@code LocalDateTime} with the day-of-year altered.
 * <p>
 * If the resulting date-time is invalid, an exception is thrown.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param dayOfYear  the day-of-year to set in the result, from 1 to 365-366
 * @return a {@code LocalDateTime} based on this date with the requested day, not null
 * @throws java.time.DateTimeException if the day-of-year value is invalid,
 *  or if the day-of-year is invalid for the year
 * @apiSince 26
 */

public java.time.LocalDateTime withDayOfYear(int dayOfYear) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this {@code LocalDateTime} with the hour-of-day altered.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param hour  the hour-of-day to set in the result, from 0 to 23
 * @return a {@code LocalDateTime} based on this date-time with the requested hour, not null
 * @throws java.time.DateTimeException if the hour value is invalid
 * @apiSince 26
 */

public java.time.LocalDateTime withHour(int hour) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this {@code LocalDateTime} with the minute-of-hour altered.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param minute  the minute-of-hour to set in the result, from 0 to 59
 * @return a {@code LocalDateTime} based on this date-time with the requested minute, not null
 * @throws java.time.DateTimeException if the minute value is invalid
 * @apiSince 26
 */

public java.time.LocalDateTime withMinute(int minute) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this {@code LocalDateTime} with the second-of-minute altered.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param second  the second-of-minute to set in the result, from 0 to 59
 * @return a {@code LocalDateTime} based on this date-time with the requested second, not null
 * @throws java.time.DateTimeException if the second value is invalid
 * @apiSince 26
 */

public java.time.LocalDateTime withSecond(int second) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this {@code LocalDateTime} with the nano-of-second altered.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param nanoOfSecond  the nano-of-second to set in the result, from 0 to 999,999,999
 * @return a {@code LocalDateTime} based on this date-time with the requested nanosecond, not null
 * @throws java.time.DateTimeException if the nano value is invalid
 * @apiSince 26
 */

public java.time.LocalDateTime withNano(int nanoOfSecond) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this {@code LocalDateTime} with the time truncated.
 * <p>
 * Truncation returns a copy of the original date-time with fields
 * smaller than the specified unit set to zero.
 * For example, truncating with the {@link java.time.temporal.ChronoUnit#MINUTES ChronoUnit#MINUTES} unit
 * will set the second-of-minute and nano-of-second field to zero.
 * <p>
 * The unit must have a {@linkplain java.time.temporal.TemporalUnit#getDuration() TemporalUnit#getDuration()}
 * that divides into the length of a standard day without remainder.
 * This includes all supplied time units on {@link java.time.temporal.ChronoUnit ChronoUnit} and
 * {@link java.time.temporal.ChronoUnit#DAYS ChronoUnit#DAYS}. Other units throw an exception.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param unit  the unit to truncate to, not null
 * @return a {@code LocalDateTime} based on this date-time with the time truncated, not null
 * @throws java.time.DateTimeException if unable to truncate
 * @throws java.time.temporal.UnsupportedTemporalTypeException if the unit is not supported
 * @apiSince 26
 */

public java.time.LocalDateTime truncatedTo(java.time.temporal.TemporalUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this date-time with the specified amount added.
 * <p>
 * This returns a {@code LocalDateTime}, based on this one, with the specified amount added.
 * The amount is typically {@link java.time.Period Period} or {@link java.time.Duration Duration} but may be
 * any other type implementing the {@link java.time.temporal.TemporalAmount TemporalAmount} interface.
 * <p>
 * The calculation is delegated to the amount object by calling
 * {@link java.time.temporal.TemporalAmount#addTo(java.time.temporal.Temporal) TemporalAmount#addTo(Temporal)}. The amount implementation is free
 * to implement the addition in any way it wishes, however it typically
 * calls back to {@link #plus(long,java.time.temporal.TemporalUnit)}. Consult the documentation
 * of the amount implementation to determine if it can be successfully added.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param amountToAdd  the amount to add, not null
 * @return a {@code LocalDateTime} based on this date-time with the addition made, not null
 * @throws java.time.DateTimeException if the addition cannot be made
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public java.time.LocalDateTime plus(java.time.temporal.TemporalAmount amountToAdd) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this date-time with the specified amount added.
 * <p>
 * This returns a {@code LocalDateTime}, based on this one, with the amount
 * in terms of the unit added. If it is not possible to add the amount, because the
 * unit is not supported or for some other reason, an exception is thrown.
 * <p>
 * If the field is a {@link java.time.temporal.ChronoUnit ChronoUnit} then the addition is implemented here.
 * Date units are added as per {@link java.time.LocalDate#plus(long,java.time.temporal.TemporalUnit) LocalDate#plus(long, TemporalUnit)}.
 * Time units are added as per {@link java.time.LocalTime#plus(long,java.time.temporal.TemporalUnit) LocalTime#plus(long, TemporalUnit)} with
 * any overflow in days added equivalent to using {@link #plusDays(long)}.
 * <p>
 * If the field is not a {@code ChronoUnit}, then the result of this method
 * is obtained by invoking {@code TemporalUnit.addTo(Temporal, long)}
 * passing {@code this} as the argument. In this case, the unit determines
 * whether and how to perform the addition.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param amountToAdd  the amount of the unit to add to the result, may be negative
 * @param unit  the unit of the amount to add, not null
 * @return a {@code LocalDateTime} based on this date-time with the specified amount added, not null
 * @throws java.time.DateTimeException if the addition cannot be made
 * @throws java.time.temporal.UnsupportedTemporalTypeException if the unit is not supported
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public java.time.LocalDateTime plus(long amountToAdd, java.time.temporal.TemporalUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this {@code LocalDateTime} with the specified number of years added.
 * <p>
 * This method adds the specified amount to the years field in three steps:
 * <ol>
 * <li>Add the input years to the year field</li>
 * <li>Check if the resulting date would be invalid</li>
 * <li>Adjust the day-of-month to the last valid day if necessary</li>
 * </ol>
 * <p>
 * For example, 2008-02-29 (leap year) plus one year would result in the
 * invalid date 2009-02-29 (standard year). Instead of returning an invalid
 * result, the last valid day of the month, 2009-02-28, is selected instead.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param years  the years to add, may be negative
 * @return a {@code LocalDateTime} based on this date-time with the years added, not null
 * @throws java.time.DateTimeException if the result exceeds the supported date range
 * @apiSince 26
 */

public java.time.LocalDateTime plusYears(long years) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this {@code LocalDateTime} with the specified number of months added.
 * <p>
 * This method adds the specified amount to the months field in three steps:
 * <ol>
 * <li>Add the input months to the month-of-year field</li>
 * <li>Check if the resulting date would be invalid</li>
 * <li>Adjust the day-of-month to the last valid day if necessary</li>
 * </ol>
 * <p>
 * For example, 2007-03-31 plus one month would result in the invalid date
 * 2007-04-31. Instead of returning an invalid result, the last valid day
 * of the month, 2007-04-30, is selected instead.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param months  the months to add, may be negative
 * @return a {@code LocalDateTime} based on this date-time with the months added, not null
 * @throws java.time.DateTimeException if the result exceeds the supported date range
 * @apiSince 26
 */

public java.time.LocalDateTime plusMonths(long months) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this {@code LocalDateTime} with the specified number of weeks added.
 * <p>
 * This method adds the specified amount in weeks to the days field incrementing
 * the month and year fields as necessary to ensure the result remains valid.
 * The result is only invalid if the maximum/minimum year is exceeded.
 * <p>
 * For example, 2008-12-31 plus one week would result in 2009-01-07.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param weeks  the weeks to add, may be negative
 * @return a {@code LocalDateTime} based on this date-time with the weeks added, not null
 * @throws java.time.DateTimeException if the result exceeds the supported date range
 * @apiSince 26
 */

public java.time.LocalDateTime plusWeeks(long weeks) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this {@code LocalDateTime} with the specified number of days added.
 * <p>
 * This method adds the specified amount to the days field incrementing the
 * month and year fields as necessary to ensure the result remains valid.
 * The result is only invalid if the maximum/minimum year is exceeded.
 * <p>
 * For example, 2008-12-31 plus one day would result in 2009-01-01.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param days  the days to add, may be negative
 * @return a {@code LocalDateTime} based on this date-time with the days added, not null
 * @throws java.time.DateTimeException if the result exceeds the supported date range
 * @apiSince 26
 */

public java.time.LocalDateTime plusDays(long days) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this {@code LocalDateTime} with the specified number of hours added.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param hours  the hours to add, may be negative
 * @return a {@code LocalDateTime} based on this date-time with the hours added, not null
 * @throws java.time.DateTimeException if the result exceeds the supported date range
 * @apiSince 26
 */

public java.time.LocalDateTime plusHours(long hours) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this {@code LocalDateTime} with the specified number of minutes added.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param minutes  the minutes to add, may be negative
 * @return a {@code LocalDateTime} based on this date-time with the minutes added, not null
 * @throws java.time.DateTimeException if the result exceeds the supported date range
 * @apiSince 26
 */

public java.time.LocalDateTime plusMinutes(long minutes) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this {@code LocalDateTime} with the specified number of seconds added.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param seconds  the seconds to add, may be negative
 * @return a {@code LocalDateTime} based on this date-time with the seconds added, not null
 * @throws java.time.DateTimeException if the result exceeds the supported date range
 * @apiSince 26
 */

public java.time.LocalDateTime plusSeconds(long seconds) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this {@code LocalDateTime} with the specified number of nanoseconds added.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param nanos  the nanos to add, may be negative
 * @return a {@code LocalDateTime} based on this date-time with the nanoseconds added, not null
 * @throws java.time.DateTimeException if the result exceeds the supported date range
 * @apiSince 26
 */

public java.time.LocalDateTime plusNanos(long nanos) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this date-time with the specified amount subtracted.
 * <p>
 * This returns a {@code LocalDateTime}, based on this one, with the specified amount subtracted.
 * The amount is typically {@link java.time.Period Period} or {@link java.time.Duration Duration} but may be
 * any other type implementing the {@link java.time.temporal.TemporalAmount TemporalAmount} interface.
 * <p>
 * The calculation is delegated to the amount object by calling
 * {@link java.time.temporal.TemporalAmount#subtractFrom(java.time.temporal.Temporal) TemporalAmount#subtractFrom(Temporal)}. The amount implementation is free
 * to implement the subtraction in any way it wishes, however it typically
 * calls back to {@link #minus(long,java.time.temporal.TemporalUnit)}. Consult the documentation
 * of the amount implementation to determine if it can be successfully subtracted.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param amountToSubtract  the amount to subtract, not null
 * @return a {@code LocalDateTime} based on this date-time with the subtraction made, not null
 * @throws java.time.DateTimeException if the subtraction cannot be made
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public java.time.LocalDateTime minus(java.time.temporal.TemporalAmount amountToSubtract) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this date-time with the specified amount subtracted.
 * <p>
 * This returns a {@code LocalDateTime}, based on this one, with the amount
 * in terms of the unit subtracted. If it is not possible to subtract the amount,
 * because the unit is not supported or for some other reason, an exception is thrown.
 * <p>
 * This method is equivalent to {@link #plus(long,java.time.temporal.TemporalUnit)} with the amount negated.
 * See that method for a full description of how addition, and thus subtraction, works.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param amountToSubtract  the amount of the unit to subtract from the result, may be negative
 * @param unit  the unit of the amount to subtract, not null
 * @return a {@code LocalDateTime} based on this date-time with the specified amount subtracted, not null
 * @throws java.time.DateTimeException if the subtraction cannot be made
 * @throws java.time.temporal.UnsupportedTemporalTypeException if the unit is not supported
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public java.time.LocalDateTime minus(long amountToSubtract, java.time.temporal.TemporalUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this {@code LocalDateTime} with the specified number of years subtracted.
 * <p>
 * This method subtracts the specified amount from the years field in three steps:
 * <ol>
 * <li>Subtract the input years from the year field</li>
 * <li>Check if the resulting date would be invalid</li>
 * <li>Adjust the day-of-month to the last valid day if necessary</li>
 * </ol>
 * <p>
 * For example, 2008-02-29 (leap year) minus one year would result in the
 * invalid date 2009-02-29 (standard year). Instead of returning an invalid
 * result, the last valid day of the month, 2009-02-28, is selected instead.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param years  the years to subtract, may be negative
 * @return a {@code LocalDateTime} based on this date-time with the years subtracted, not null
 * @throws java.time.DateTimeException if the result exceeds the supported date range
 * @apiSince 26
 */

public java.time.LocalDateTime minusYears(long years) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this {@code LocalDateTime} with the specified number of months subtracted.
 * <p>
 * This method subtracts the specified amount from the months field in three steps:
 * <ol>
 * <li>Subtract the input months from the month-of-year field</li>
 * <li>Check if the resulting date would be invalid</li>
 * <li>Adjust the day-of-month to the last valid day if necessary</li>
 * </ol>
 * <p>
 * For example, 2007-03-31 minus one month would result in the invalid date
 * 2007-04-31. Instead of returning an invalid result, the last valid day
 * of the month, 2007-04-30, is selected instead.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param months  the months to subtract, may be negative
 * @return a {@code LocalDateTime} based on this date-time with the months subtracted, not null
 * @throws java.time.DateTimeException if the result exceeds the supported date range
 * @apiSince 26
 */

public java.time.LocalDateTime minusMonths(long months) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this {@code LocalDateTime} with the specified number of weeks subtracted.
 * <p>
 * This method subtracts the specified amount in weeks from the days field decrementing
 * the month and year fields as necessary to ensure the result remains valid.
 * The result is only invalid if the maximum/minimum year is exceeded.
 * <p>
 * For example, 2009-01-07 minus one week would result in 2008-12-31.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param weeks  the weeks to subtract, may be negative
 * @return a {@code LocalDateTime} based on this date-time with the weeks subtracted, not null
 * @throws java.time.DateTimeException if the result exceeds the supported date range
 * @apiSince 26
 */

public java.time.LocalDateTime minusWeeks(long weeks) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this {@code LocalDateTime} with the specified number of days subtracted.
 * <p>
 * This method subtracts the specified amount from the days field decrementing the
 * month and year fields as necessary to ensure the result remains valid.
 * The result is only invalid if the maximum/minimum year is exceeded.
 * <p>
 * For example, 2009-01-01 minus one day would result in 2008-12-31.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param days  the days to subtract, may be negative
 * @return a {@code LocalDateTime} based on this date-time with the days subtracted, not null
 * @throws java.time.DateTimeException if the result exceeds the supported date range
 * @apiSince 26
 */

public java.time.LocalDateTime minusDays(long days) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this {@code LocalDateTime} with the specified number of hours subtracted.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param hours  the hours to subtract, may be negative
 * @return a {@code LocalDateTime} based on this date-time with the hours subtracted, not null
 * @throws java.time.DateTimeException if the result exceeds the supported date range
 * @apiSince 26
 */

public java.time.LocalDateTime minusHours(long hours) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this {@code LocalDateTime} with the specified number of minutes subtracted.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param minutes  the minutes to subtract, may be negative
 * @return a {@code LocalDateTime} based on this date-time with the minutes subtracted, not null
 * @throws java.time.DateTimeException if the result exceeds the supported date range
 * @apiSince 26
 */

public java.time.LocalDateTime minusMinutes(long minutes) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this {@code LocalDateTime} with the specified number of seconds subtracted.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param seconds  the seconds to subtract, may be negative
 * @return a {@code LocalDateTime} based on this date-time with the seconds subtracted, not null
 * @throws java.time.DateTimeException if the result exceeds the supported date range
 * @apiSince 26
 */

public java.time.LocalDateTime minusSeconds(long seconds) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this {@code LocalDateTime} with the specified number of nanoseconds subtracted.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param nanos  the nanos to subtract, may be negative
 * @return a {@code LocalDateTime} based on this date-time with the nanoseconds subtracted, not null
 * @throws java.time.DateTimeException if the result exceeds the supported date range
 * @apiSince 26
 */

public java.time.LocalDateTime minusNanos(long nanos) { throw new RuntimeException("Stub!"); }

/**
 * Queries this date-time using the specified query.
 * <p>
 * This queries this date-time using the specified query strategy object.
 * The {@code TemporalQuery} object defines the logic to be used to
 * obtain the result. Read the documentation of the query to understand
 * what the result of this method will be.
 * <p>
 * The result of this method is obtained by invoking the
 * {@link java.time.temporal.TemporalQuery#queryFrom(java.time.temporal.TemporalAccessor) TemporalQuery#queryFrom(TemporalAccessor)} method on the
 * specified query passing {@code this} as the argument.
 *
 * @param <R> the type of the result
 * @param query  the query to invoke, not null
 * @return the query result, null may be returned (defined by the query)
 * @throws java.time.DateTimeException if unable to query (defined by the query)
 * @throws java.lang.ArithmeticException if numeric overflow occurs (defined by the query)
 * @apiSince 26
 */

public <R> R query(java.time.temporal.TemporalQuery<R> query) { throw new RuntimeException("Stub!"); }

/**
 * Adjusts the specified temporal object to have the same date and time as this object.
 * <p>
 * This returns a temporal object of the same observable type as the input
 * with the date and time changed to be the same as this.
 * <p>
 * The adjustment is equivalent to using {@link java.time.temporal.Temporal#with(java.time.temporal.TemporalField,long) Temporal#with(TemporalField, long)}
 * twice, passing {@link java.time.temporal.ChronoField#EPOCH_DAY ChronoField#EPOCH_DAY} and
 * {@link java.time.temporal.ChronoField#NANO_OF_DAY ChronoField#NANO_OF_DAY} as the fields.
 * <p>
 * In most cases, it is clearer to reverse the calling pattern by using
 * {@link java.time.temporal.Temporal#with(java.time.temporal.TemporalAdjuster) Temporal#with(TemporalAdjuster)}:
 * <pre>
 *   // these two lines are equivalent, but the second approach is recommended
 *   temporal = thisLocalDateTime.adjustInto(temporal);
 *   temporal = temporal.with(thisLocalDateTime);
 * </pre>
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param temporal  the target object to be adjusted, not null
 * @return the adjusted object, not null
 * @throws java.time.DateTimeException if unable to make the adjustment
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public java.time.temporal.Temporal adjustInto(java.time.temporal.Temporal temporal) { throw new RuntimeException("Stub!"); }

/**
 * Calculates the amount of time until another date-time in terms of the specified unit.
 * <p>
 * This calculates the amount of time between two {@code LocalDateTime}
 * objects in terms of a single {@code TemporalUnit}.
 * The start and end points are {@code this} and the specified date-time.
 * The result will be negative if the end is before the start.
 * The {@code Temporal} passed to this method is converted to a
 * {@code LocalDateTime} using {@link #from(java.time.temporal.TemporalAccessor)}.
 * For example, the amount in days between two date-times can be calculated
 * using {@code startDateTime.until(endDateTime, DAYS)}.
 * <p>
 * The calculation returns a whole number, representing the number of
 * complete units between the two date-times.
 * For example, the amount in months between 2012-06-15T00:00 and 2012-08-14T23:59
 * will only be one month as it is one minute short of two months.
 * <p>
 * There are two equivalent ways of using this method.
 * The first is to invoke this method.
 * The second is to use {@link java.time.temporal.TemporalUnit#between(java.time.temporal.Temporal,java.time.temporal.Temporal) TemporalUnit#between(Temporal, Temporal)}:
 * <pre>
 *   // these two lines are equivalent
 *   amount = start.until(end, MONTHS);
 *   amount = MONTHS.between(start, end);
 * </pre>
 * The choice should be made based on which makes the code more readable.
 * <p>
 * The calculation is implemented in this method for {@link java.time.temporal.ChronoUnit ChronoUnit}.
 * The units {@code NANOS}, {@code MICROS}, {@code MILLIS}, {@code SECONDS},
 * {@code MINUTES}, {@code HOURS} and {@code HALF_DAYS}, {@code DAYS},
 * {@code WEEKS}, {@code MONTHS}, {@code YEARS}, {@code DECADES},
 * {@code CENTURIES}, {@code MILLENNIA} and {@code ERAS} are supported.
 * Other {@code ChronoUnit} values will throw an exception.
 * <p>
 * If the unit is not a {@code ChronoUnit}, then the result of this method
 * is obtained by invoking {@code TemporalUnit.between(Temporal, Temporal)}
 * passing {@code this} as the first argument and the converted input temporal
 * as the second argument.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param endExclusive  the end date, exclusive, which is converted to a {@code LocalDateTime}, not null
 * @param unit  the unit to measure the amount in, not null
 * @return the amount of time between this date-time and the end date-time
 * @throws java.time.DateTimeException if the amount cannot be calculated, or the end
 *  temporal cannot be converted to a {@code LocalDateTime}
 * @throws java.time.temporal.UnsupportedTemporalTypeException if the unit is not supported
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public long until(java.time.temporal.Temporal endExclusive, java.time.temporal.TemporalUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * Formats this date-time using the specified formatter.
 * <p>
 * This date-time will be passed to the formatter to produce a string.
 *
 * @param formatter  the formatter to use, not null
 * @return the formatted date-time string, not null
 * @throws java.time.DateTimeException if an error occurs during printing
 * @apiSince 26
 */

public java.lang.String format(java.time.format.DateTimeFormatter formatter) { throw new RuntimeException("Stub!"); }

/**
 * Combines this date-time with an offset to create an {@code OffsetDateTime}.
 * <p>
 * This returns an {@code OffsetDateTime} formed from this date-time at the specified offset.
 * All possible combinations of date-time and offset are valid.
 *
 * @param offset  the offset to combine with, not null
 * @return the offset date-time formed from this date-time and the specified offset, not null
 * @apiSince 26
 */

public java.time.OffsetDateTime atOffset(java.time.ZoneOffset offset) { throw new RuntimeException("Stub!"); }

/**
 * Combines this date-time with a time-zone to create a {@code ZonedDateTime}.
 * <p>
 * This returns a {@code ZonedDateTime} formed from this date-time at the
 * specified time-zone. The result will match this date-time as closely as possible.
 * Time-zone rules, such as daylight savings, mean that not every local date-time
 * is valid for the specified zone, thus the local date-time may be adjusted.
 * <p>
 * The local date-time is resolved to a single instant on the time-line.
 * This is achieved by finding a valid offset from UTC/Greenwich for the local
 * date-time as defined by the {@link java.time.zone.ZoneRules ZoneRules} of the zone ID.
 *<p>
 * In most cases, there is only one valid offset for a local date-time.
 * In the case of an overlap, where clocks are set back, there are two valid offsets.
 * This method uses the earlier offset typically corresponding to "summer".
 * <p>
 * In the case of a gap, where clocks jump forward, there is no valid offset.
 * Instead, the local date-time is adjusted to be later by the length of the gap.
 * For a typical one hour daylight savings change, the local date-time will be
 * moved one hour later into the offset typically corresponding to "summer".
 * <p>
 * To obtain the later offset during an overlap, call
 * {@link java.time.ZonedDateTime#withLaterOffsetAtOverlap() ZonedDateTime#withLaterOffsetAtOverlap()} on the result of this method.
 * To throw an exception when there is a gap or overlap, use
 * {@link java.time.ZonedDateTime#ofStrict(java.time.LocalDateTime,java.time.ZoneOffset,java.time.ZoneId) ZonedDateTime#ofStrict(LocalDateTime, ZoneOffset, ZoneId)}.
 *
 * @param zone  the time-zone to use, not null
 * @return the zoned date-time formed from this date-time, not null
 * @apiSince 26
 */

public java.time.ZonedDateTime atZone(java.time.ZoneId zone) { throw new RuntimeException("Stub!"); }

/**
 * Compares this date-time to another date-time.
 * <p>
 * The comparison is primarily based on the date-time, from earliest to latest.
 * It is "consistent with equals", as defined by {@link java.lang.Comparable Comparable}.
 * <p>
 * If all the date-times being compared are instances of {@code LocalDateTime},
 * then the comparison will be entirely based on the date-time.
 * If some dates being compared are in different chronologies, then the
 * chronology is also considered, see {@link java.time.chrono.ChronoLocalDateTime#compareTo ChronoLocalDateTime#compareTo}.
 *
 * @param other  the other date-time to compare to, not null
 * @return the comparator value, negative if less, positive if greater
 * @apiSince 26
 */

public int compareTo(java.time.chrono.ChronoLocalDateTime<?> other) { throw new RuntimeException("Stub!"); }

/**
 * Checks if this date-time is after the specified date-time.
 * <p>
 * This checks to see if this date-time represents a point on the
 * local time-line after the other date-time.
 * <pre>
 *   LocalDate a = LocalDateTime.of(2012, 6, 30, 12, 00);
 *   LocalDate b = LocalDateTime.of(2012, 7, 1, 12, 00);
 *   a.isAfter(b) == false
 *   a.isAfter(a) == false
 *   b.isAfter(a) == true
 * </pre>
 * <p>
 * This method only considers the position of the two date-times on the local time-line.
 * It does not take into account the chronology, or calendar system.
 * This is different from the comparison in {@link #compareTo(java.time.chrono.ChronoLocalDateTime)},
 * but is the same approach as {@link java.time.chrono.ChronoLocalDateTime#timeLineOrder() ChronoLocalDateTime#timeLineOrder()}.
 *
 * @param other  the other date-time to compare to, not null
 * @return true if this date-time is after the specified date-time
 * @apiSince 26
 */

public boolean isAfter(java.time.chrono.ChronoLocalDateTime<?> other) { throw new RuntimeException("Stub!"); }

/**
 * Checks if this date-time is before the specified date-time.
 * <p>
 * This checks to see if this date-time represents a point on the
 * local time-line before the other date-time.
 * <pre>
 *   LocalDate a = LocalDateTime.of(2012, 6, 30, 12, 00);
 *   LocalDate b = LocalDateTime.of(2012, 7, 1, 12, 00);
 *   a.isBefore(b) == true
 *   a.isBefore(a) == false
 *   b.isBefore(a) == false
 * </pre>
 * <p>
 * This method only considers the position of the two date-times on the local time-line.
 * It does not take into account the chronology, or calendar system.
 * This is different from the comparison in {@link #compareTo(java.time.chrono.ChronoLocalDateTime)},
 * but is the same approach as {@link java.time.chrono.ChronoLocalDateTime#timeLineOrder() ChronoLocalDateTime#timeLineOrder()}.
 *
 * @param other  the other date-time to compare to, not null
 * @return true if this date-time is before the specified date-time
 * @apiSince 26
 */

public boolean isBefore(java.time.chrono.ChronoLocalDateTime<?> other) { throw new RuntimeException("Stub!"); }

/**
 * Checks if this date-time is equal to the specified date-time.
 * <p>
 * This checks to see if this date-time represents the same point on the
 * local time-line as the other date-time.
 * <pre>
 *   LocalDate a = LocalDateTime.of(2012, 6, 30, 12, 00);
 *   LocalDate b = LocalDateTime.of(2012, 7, 1, 12, 00);
 *   a.isEqual(b) == false
 *   a.isEqual(a) == true
 *   b.isEqual(a) == false
 * </pre>
 * <p>
 * This method only considers the position of the two date-times on the local time-line.
 * It does not take into account the chronology, or calendar system.
 * This is different from the comparison in {@link #compareTo(java.time.chrono.ChronoLocalDateTime)},
 * but is the same approach as {@link java.time.chrono.ChronoLocalDateTime#timeLineOrder() ChronoLocalDateTime#timeLineOrder()}.
 *
 * @param other  the other date-time to compare to, not null
 * @return true if this date-time is equal to the specified date-time
 * @apiSince 26
 */

public boolean isEqual(java.time.chrono.ChronoLocalDateTime<?> other) { throw new RuntimeException("Stub!"); }

/**
 * Checks if this date-time is equal to another date-time.
 * <p>
 * Compares this {@code LocalDateTime} with another ensuring that the date-time is the same.
 * Only objects of type {@code LocalDateTime} are compared, other types return false.
 *
 * @param obj  the object to check, null returns false
 * @return true if this is equal to the other date-time
 * @apiSince 26
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * A hash code for this date-time.
 *
 * @return a suitable hash code
 * @apiSince 26
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Outputs this date-time as a {@code String}, such as {@code 2007-12-03T10:15:30}.
 * <p>
 * The output will be one of the following ISO-8601 formats:
 * <ul>
 * <li>{@code uuuu-MM-dd'T'HH:mm}</li>
 * <li>{@code uuuu-MM-dd'T'HH:mm:ss}</li>
 * <li>{@code uuuu-MM-dd'T'HH:mm:ss.SSS}</li>
 * <li>{@code uuuu-MM-dd'T'HH:mm:ss.SSSSSS}</li>
 * <li>{@code uuuu-MM-dd'T'HH:mm:ss.SSSSSSSSS}</li>
 * </ul>
 * The format used will be the shortest that outputs the full value of
 * the time where the omitted parts are implied to be zero.
 *
 * @return a string representation of this date-time, not null
 * @apiSince 26
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * The maximum supported {@code LocalDateTime}, '+999999999-12-31T23:59:59.999999999'.
 * This is the local date-time just before midnight at the end of the maximum date.
 * This combines {@link java.time.LocalDate#MAX LocalDate#MAX} and {@link java.time.LocalTime#MAX LocalTime#MAX}.
 * This could be used by an application as a "far future" date-time.
 * @apiSince 26
 */

public static final java.time.LocalDateTime MAX;
static { MAX = null; }

/**
 * The minimum supported {@code LocalDateTime}, '-999999999-01-01T00:00:00'.
 * This is the local date-time of midnight at the start of the minimum date.
 * This combines {@link java.time.LocalDate#MIN LocalDate#MIN} and {@link java.time.LocalTime#MIN LocalTime#MIN}.
 * This could be used by an application as a "far past" date-time.
 * @apiSince 26
 */

public static final java.time.LocalDateTime MIN;
static { MIN = null; }
}

