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

import java.time.temporal.TemporalAccessor;
import java.time.temporal.Temporal;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalQuery;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalField;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.time.temporal.TemporalAdjuster;

/**
 * A month-day in the ISO-8601 calendar system, such as {@code --12-03}.
 * <p>
 * {@code MonthDay} is an immutable date-time object that represents the combination
 * of a month and day-of-month. Any field that can be derived from a month and day,
 * such as quarter-of-year, can be obtained.
 * <p>
 * This class does not store or represent a year, time or time-zone.
 * For example, the value "December 3rd" can be stored in a {@code MonthDay}.
 * <p>
 * Since a {@code MonthDay} does not possess a year, the leap day of
 * February 29th is considered valid.
 * <p>
 * This class implements {@link java.time.temporal.TemporalAccessor TemporalAccessor} rather than {@link java.time.temporal.Temporal Temporal}.
 * This is because it is not possible to define whether February 29th is valid or not
 * without external information, preventing the implementation of plus/minus.
 * Related to this, {@code MonthDay} only provides access to query and set the fields
 * {@code MONTH_OF_YEAR} and {@code DAY_OF_MONTH}.
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
public final class MonthDay implements java.time.temporal.TemporalAccessor, java.time.temporal.TemporalAdjuster, java.lang.Comparable<java.time.MonthDay>, java.io.Serializable {

private MonthDay() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the current month-day from the system clock in the default time-zone.
 * <p>
 * This will query the {@link java.time.Clock#systemDefaultZone() Clock#systemDefaultZone()} in the default
 * time-zone to obtain the current month-day.
 * <p>
 * Using this method will prevent the ability to use an alternate clock for testing
 * because the clock is hard-coded.
 *
 * @return the current month-day using the system clock and default time-zone, not null
 * @apiSince 26
 */

public static java.time.MonthDay now() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the current month-day from the system clock in the specified time-zone.
 * <p>
 * This will query the {@link java.time.Clock#system(java.time.ZoneId) Clock#system(ZoneId)} to obtain the current month-day.
 * Specifying the time-zone avoids dependence on the default time-zone.
 * <p>
 * Using this method will prevent the ability to use an alternate clock for testing
 * because the clock is hard-coded.
 *
 * @param zone  the zone ID to use, not null
 * @return the current month-day using the system clock, not null
 * @apiSince 26
 */

public static java.time.MonthDay now(java.time.ZoneId zone) { throw new RuntimeException("Stub!"); }

/**
 * Obtains the current month-day from the specified clock.
 * <p>
 * This will query the specified clock to obtain the current month-day.
 * Using this method allows the use of an alternate clock for testing.
 * The alternate clock may be introduced using {@link java.time.Clock Clock}.
 *
 * @param clock  the clock to use, not null
 * @return the current month-day, not null
 * @apiSince 26
 */

public static java.time.MonthDay now(java.time.Clock clock) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code MonthDay}.
 * <p>
 * The day-of-month must be valid for the month within a leap year.
 * Hence, for February, day 29 is valid.
 * <p>
 * For example, passing in April and day 31 will throw an exception, as
 * there can never be April 31st in any year. By contrast, passing in
 * February 29th is permitted, as that month-day can sometimes be valid.
 *
 * @param month  the month-of-year to represent, not null
 * @param dayOfMonth  the day-of-month to represent, from 1 to 31
 * @return the month-day, not null
 * @throws java.time.DateTimeException if the value of any field is out of range,
 *  or if the day-of-month is invalid for the month
 * @apiSince 26
 */

public static java.time.MonthDay of(java.time.Month month, int dayOfMonth) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code MonthDay}.
 * <p>
 * The day-of-month must be valid for the month within a leap year.
 * Hence, for month 2 (February), day 29 is valid.
 * <p>
 * For example, passing in month 4 (April) and day 31 will throw an exception, as
 * there can never be April 31st in any year. By contrast, passing in
 * February 29th is permitted, as that month-day can sometimes be valid.
 *
 * @param month  the month-of-year to represent, from 1 (January) to 12 (December)
 * @param dayOfMonth  the day-of-month to represent, from 1 to 31
 * @return the month-day, not null
 * @throws java.time.DateTimeException if the value of any field is out of range,
 *  or if the day-of-month is invalid for the month
 * @apiSince 26
 */

public static java.time.MonthDay of(int month, int dayOfMonth) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code MonthDay} from a temporal object.
 * <p>
 * This obtains a month-day based on the specified temporal.
 * A {@code TemporalAccessor} represents an arbitrary set of date and time information,
 * which this factory converts to an instance of {@code MonthDay}.
 * <p>
 * The conversion extracts the {@link java.time.temporal.ChronoField#MONTH_OF_YEAR ChronoField#MONTH_OF_YEAR} and
 * {@link java.time.temporal.ChronoField#DAY_OF_MONTH ChronoField#DAY_OF_MONTH} fields.
 * The extraction is only permitted if the temporal object has an ISO
 * chronology, or can be converted to a {@code LocalDate}.
 * <p>
 * This method matches the signature of the functional interface {@link java.time.temporal.TemporalQuery TemporalQuery}
 * allowing it to be used as a query via method reference, {@code MonthDay::from}.
 *
 * @param temporal  the temporal object to convert, not null
 * @return the month-day, not null
 * @throws java.time.DateTimeException if unable to convert to a {@code MonthDay}
 * @apiSince 26
 */

public static java.time.MonthDay from(java.time.temporal.TemporalAccessor temporal) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code MonthDay} from a text string such as {@code --12-03}.
 * <p>
 * The string must represent a valid month-day.
 * The format is {@code --MM-dd}.
 *
 * @param text  the text to parse such as "--12-03", not null
 * @return the parsed month-day, not null
 * @throws java.time.format.DateTimeParseException if the text cannot be parsed
 * @apiSince 26
 */

public static java.time.MonthDay parse(java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code MonthDay} from a text string using a specific formatter.
 * <p>
 * The text is parsed using the formatter, returning a month-day.
 *
 * @param text  the text to parse, not null
 * @param formatter  the formatter to use, not null
 * @return the parsed month-day, not null
 * @throws java.time.format.DateTimeParseException if the text cannot be parsed
 * @apiSince 26
 */

public static java.time.MonthDay parse(java.lang.CharSequence text, java.time.format.DateTimeFormatter formatter) { throw new RuntimeException("Stub!"); }

/**
 * Checks if the specified field is supported.
 * <p>
 * This checks if this month-day can be queried for the specified field.
 * If false, then calling the {@link #range(java.time.temporal.TemporalField) range} and
 * {@link #get(java.time.temporal.TemporalField) get} methods will throw an exception.
 * <p>
 * If the field is a {@link java.time.temporal.ChronoField ChronoField} then the query is implemented here.
 * The supported fields are:
 * <ul>
 * <li>{@code MONTH_OF_YEAR}
 * <li>{@code YEAR}
 * </ul>
 * All other {@code ChronoField} instances will return false.
 * <p>
 * If the field is not a {@code ChronoField}, then the result of this method
 * is obtained by invoking {@code TemporalField.isSupportedBy(TemporalAccessor)}
 * passing {@code this} as the argument.
 * Whether the field is supported is determined by the field.
 *
 * @param field  the field to check, null returns false
 * @return true if the field is supported on this month-day, false if not
 * @apiSince 26
 */

public boolean isSupported(java.time.temporal.TemporalField field) { throw new RuntimeException("Stub!"); }

/**
 * Gets the range of valid values for the specified field.
 * <p>
 * The range object expresses the minimum and maximum valid values for a field.
 * This month-day is used to enhance the accuracy of the returned range.
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
 * Gets the value of the specified field from this month-day as an {@code int}.
 * <p>
 * This queries this month-day for the value of the specified field.
 * The returned value will always be within the valid range of values for the field.
 * If it is not possible to return the value, because the field is not supported
 * or for some other reason, an exception is thrown.
 * <p>
 * If the field is a {@link java.time.temporal.ChronoField ChronoField} then the query is implemented here.
 * The {@link #isSupported(java.time.temporal.TemporalField) supported fields} will return valid
 * values based on this month-day.
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
 * Gets the value of the specified field from this month-day as a {@code long}.
 * <p>
 * This queries this month-day for the value of the specified field.
 * If it is not possible to return the value, because the field is not supported
 * or for some other reason, an exception is thrown.
 * <p>
 * If the field is a {@link java.time.temporal.ChronoField ChronoField} then the query is implemented here.
 * The {@link #isSupported(java.time.temporal.TemporalField) supported fields} will return valid
 * values based on this month-day.
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
 * Checks if the year is valid for this month-day.
 * <p>
 * This method checks whether this month and day and the input year form
 * a valid date. This can only return false for February 29th.
 *
 * @param year  the year to validate
 * @return true if the year is valid for this month-day
 * @see java.time.Year#isValidMonthDay(MonthDay)
 * @apiSince 26
 */

public boolean isValidYear(int year) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this {@code MonthDay} with the month-of-year altered.
 * <p>
 * This returns a month-day with the specified month.
 * If the day-of-month is invalid for the specified month, the day will
 * be adjusted to the last valid day-of-month.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param month  the month-of-year to set in the returned month-day, from 1 (January) to 12 (December)
 * @return a {@code MonthDay} based on this month-day with the requested month, not null
 * @throws java.time.DateTimeException if the month-of-year value is invalid
 * @apiSince 26
 */

public java.time.MonthDay withMonth(int month) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this {@code MonthDay} with the month-of-year altered.
 * <p>
 * This returns a month-day with the specified month.
 * If the day-of-month is invalid for the specified month, the day will
 * be adjusted to the last valid day-of-month.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param month  the month-of-year to set in the returned month-day, not null
 * @return a {@code MonthDay} based on this month-day with the requested month, not null
 * @apiSince 26
 */

public java.time.MonthDay with(java.time.Month month) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this {@code MonthDay} with the day-of-month altered.
 * <p>
 * This returns a month-day with the specified day-of-month.
 * If the day-of-month is invalid for the month, an exception is thrown.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param dayOfMonth  the day-of-month to set in the return month-day, from 1 to 31
 * @return a {@code MonthDay} based on this month-day with the requested day, not null
 * @throws java.time.DateTimeException if the day-of-month value is invalid,
 *  or if the day-of-month is invalid for the month
 * @apiSince 26
 */

public java.time.MonthDay withDayOfMonth(int dayOfMonth) { throw new RuntimeException("Stub!"); }

/**
 * Queries this month-day using the specified query.
 * <p>
 * This queries this month-day using the specified query strategy object.
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
 * Adjusts the specified temporal object to have this month-day.
 * <p>
 * This returns a temporal object of the same observable type as the input
 * with the month and day-of-month changed to be the same as this.
 * <p>
 * The adjustment is equivalent to using {@link java.time.temporal.Temporal#with(java.time.temporal.TemporalField,long) Temporal#with(TemporalField, long)}
 * twice, passing {@link java.time.temporal.ChronoField#MONTH_OF_YEAR ChronoField#MONTH_OF_YEAR} and
 * {@link java.time.temporal.ChronoField#DAY_OF_MONTH ChronoField#DAY_OF_MONTH} as the fields.
 * If the specified temporal object does not use the ISO calendar system then
 * a {@code DateTimeException} is thrown.
 * <p>
 * In most cases, it is clearer to reverse the calling pattern by using
 * {@link java.time.temporal.Temporal#with(java.time.temporal.TemporalAdjuster) Temporal#with(TemporalAdjuster)}:
 * <pre>
 *   // these two lines are equivalent, but the second approach is recommended
 *   temporal = thisMonthDay.adjustInto(temporal);
 *   temporal = temporal.with(thisMonthDay);
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
 * Formats this month-day using the specified formatter.
 * <p>
 * This month-day will be passed to the formatter to produce a string.
 *
 * @param formatter  the formatter to use, not null
 * @return the formatted month-day string, not null
 * @throws java.time.DateTimeException if an error occurs during printing
 * @apiSince 26
 */

public java.lang.String format(java.time.format.DateTimeFormatter formatter) { throw new RuntimeException("Stub!"); }

/**
 * Combines this month-day with a year to create a {@code LocalDate}.
 * <p>
 * This returns a {@code LocalDate} formed from this month-day and the specified year.
 * <p>
 * A month-day of February 29th will be adjusted to February 28th in the resulting
 * date if the year is not a leap year.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param year  the year to use, from MIN_YEAR to MAX_YEAR
 * @return the local date formed from this month-day and the specified year, not null
 * @throws java.time.DateTimeException if the year is outside the valid range of years
 * @apiSince 26
 */

public java.time.LocalDate atYear(int year) { throw new RuntimeException("Stub!"); }

/**
 * Compares this month-day to another month-day.
 * <p>
 * The comparison is based first on value of the month, then on the value of the day.
 * It is "consistent with equals", as defined by {@link java.lang.Comparable Comparable}.
 *
 * @param other  the other month-day to compare to, not null
 * @return the comparator value, negative if less, positive if greater
 * @apiSince 26
 */

public int compareTo(java.time.MonthDay other) { throw new RuntimeException("Stub!"); }

/**
 * Checks if this month-day is after the specified month-day.
 *
 * @param other  the other month-day to compare to, not null
 * @return true if this is after the specified month-day
 * @apiSince 26
 */

public boolean isAfter(java.time.MonthDay other) { throw new RuntimeException("Stub!"); }

/**
 * Checks if this month-day is before the specified month-day.
 *
 * @param other  the other month-day to compare to, not null
 * @return true if this point is before the specified month-day
 * @apiSince 26
 */

public boolean isBefore(java.time.MonthDay other) { throw new RuntimeException("Stub!"); }

/**
 * Checks if this month-day is equal to another month-day.
 * <p>
 * The comparison is based on the time-line position of the month-day within a year.
 *
 * @param obj  the object to check, null returns false
 * @return true if this is equal to the other month-day
 * @apiSince 26
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * A hash code for this month-day.
 *
 * @return a suitable hash code
 * @apiSince 26
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Outputs this month-day as a {@code String}, such as {@code --12-03}.
 * <p>
 * The output will be in the format {@code --MM-dd}:
 *
 * @return a string representation of this month-day, not null
 * @apiSince 26
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

