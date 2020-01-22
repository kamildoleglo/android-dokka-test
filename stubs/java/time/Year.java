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
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalQuery;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalField;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import java.time.temporal.ChronoUnit;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAmount;

/**
 * A year in the ISO-8601 calendar system, such as {@code 2007}.
 * <p>
 * {@code Year} is an immutable date-time object that represents a year.
 * Any field that can be derived from a year can be obtained.
 * <p>
 * <b>Note that years in the ISO chronology only align with years in the
 * Gregorian-Julian system for modern years. Parts of Russia did not switch to the
 * modern Gregorian/ISO rules until 1920.
 * As such, historical years must be treated with caution.</b>
 * <p>
 * This class does not store or represent a month, day, time or time-zone.
 * For example, the value "2007" can be stored in a {@code Year}.
 * <p>
 * Years represented by this class follow the ISO-8601 standard and use
 * the proleptic numbering system. Year 1 is preceded by year 0, then by year -1.
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
public final class Year implements java.time.temporal.Temporal, java.time.temporal.TemporalAdjuster, java.lang.Comparable<java.time.Year>, java.io.Serializable {

private Year() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the current year from the system clock in the default time-zone.
 * <p>
 * This will query the {@link java.time.Clock#systemDefaultZone() Clock#systemDefaultZone()} in the default
 * time-zone to obtain the current year.
 * <p>
 * Using this method will prevent the ability to use an alternate clock for testing
 * because the clock is hard-coded.
 *
 * @return the current year using the system clock and default time-zone, not null
 * @apiSince 26
 */

public static java.time.Year now() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the current year from the system clock in the specified time-zone.
 * <p>
 * This will query the {@link java.time.Clock#system(java.time.ZoneId) Clock#system(ZoneId)} to obtain the current year.
 * Specifying the time-zone avoids dependence on the default time-zone.
 * <p>
 * Using this method will prevent the ability to use an alternate clock for testing
 * because the clock is hard-coded.
 *
 * @param zone  the zone ID to use, not null
 * @return the current year using the system clock, not null
 * @apiSince 26
 */

public static java.time.Year now(java.time.ZoneId zone) { throw new RuntimeException("Stub!"); }

/**
 * Obtains the current year from the specified clock.
 * <p>
 * This will query the specified clock to obtain the current year.
 * Using this method allows the use of an alternate clock for testing.
 * The alternate clock may be introduced using {@link java.time.Clock Clock}.
 *
 * @param clock  the clock to use, not null
 * @return the current year, not null
 * @apiSince 26
 */

public static java.time.Year now(java.time.Clock clock) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code Year}.
 * <p>
 * This method accepts a year value from the proleptic ISO calendar system.
 * <p>
 * The year 2AD/CE is represented by 2.<br>
 * The year 1AD/CE is represented by 1.<br>
 * The year 1BC/BCE is represented by 0.<br>
 * The year 2BC/BCE is represented by -1.<br>
 *
 * @param isoYear  the ISO proleptic year to represent, from {@code MIN_VALUE} to {@code MAX_VALUE}
 * @return the year, not null
 * @throws java.time.DateTimeException if the field is invalid
 * @apiSince 26
 */

public static java.time.Year of(int isoYear) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code Year} from a temporal object.
 * <p>
 * This obtains a year based on the specified temporal.
 * A {@code TemporalAccessor} represents an arbitrary set of date and time information,
 * which this factory converts to an instance of {@code Year}.
 * <p>
 * The conversion extracts the {@link java.time.temporal.ChronoField#YEAR ChronoField#YEAR} field.
 * The extraction is only permitted if the temporal object has an ISO
 * chronology, or can be converted to a {@code LocalDate}.
 * <p>
 * This method matches the signature of the functional interface {@link java.time.temporal.TemporalQuery TemporalQuery}
 * allowing it to be used as a query via method reference, {@code Year::from}.
 *
 * @param temporal  the temporal object to convert, not null
 * @return the year, not null
 * @throws java.time.DateTimeException if unable to convert to a {@code Year}
 * @apiSince 26
 */

public static java.time.Year from(java.time.temporal.TemporalAccessor temporal) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code Year} from a text string such as {@code 2007}.
 * <p>
 * The string must represent a valid year.
 * Years outside the range 0000 to 9999 must be prefixed by the plus or minus symbol.
 *
 * @param text  the text to parse such as "2007", not null
 * @return the parsed year, not null
 * @throws java.time.format.DateTimeParseException if the text cannot be parsed
 * @apiSince 26
 */

public static java.time.Year parse(java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code Year} from a text string using a specific formatter.
 * <p>
 * The text is parsed using the formatter, returning a year.
 *
 * @param text  the text to parse, not null
 * @param formatter  the formatter to use, not null
 * @return the parsed year, not null
 * @throws java.time.format.DateTimeParseException if the text cannot be parsed
 * @apiSince 26
 */

public static java.time.Year parse(java.lang.CharSequence text, java.time.format.DateTimeFormatter formatter) { throw new RuntimeException("Stub!"); }

/**
 * Checks if the year is a leap year, according to the ISO proleptic
 * calendar system rules.
 * <p>
 * This method applies the current rules for leap years across the whole time-line.
 * In general, a year is a leap year if it is divisible by four without
 * remainder. However, years divisible by 100, are not leap years, with
 * the exception of years divisible by 400 which are.
 * <p>
 * For example, 1904 is a leap year it is divisible by 4.
 * 1900 was not a leap year as it is divisible by 100, however 2000 was a
 * leap year as it is divisible by 400.
 * <p>
 * The calculation is proleptic - applying the same rules into the far future and far past.
 * This is historically inaccurate, but is correct for the ISO-8601 standard.
 *
 * @param year  the year to check
 * @return true if the year is leap, false otherwise
 * @apiSince 26
 */

public static boolean isLeap(long year) { throw new RuntimeException("Stub!"); }

/**
 * Gets the year value.
 * <p>
 * The year returned by this method is proleptic as per {@code get(YEAR)}.
 *
 * @return the year, {@code MIN_VALUE} to {@code MAX_VALUE}
 * @apiSince 26
 */

public int getValue() { throw new RuntimeException("Stub!"); }

/**
 * Checks if the specified field is supported.
 * <p>
 * This checks if this year can be queried for the specified field.
 * If false, then calling the {@link #range(java.time.temporal.TemporalField) range},
 * {@link #get(java.time.temporal.TemporalField) get} and {@link #with(java.time.temporal.TemporalField,long)}
 * methods will throw an exception.
 * <p>
 * If the field is a {@link java.time.temporal.ChronoField ChronoField} then the query is implemented here.
 * The supported fields are:
 * <ul>
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
 * @return true if the field is supported on this year, false if not
 * @apiSince 26
 */

public boolean isSupported(java.time.temporal.TemporalField field) { throw new RuntimeException("Stub!"); }

/**
 * Checks if the specified unit is supported.
 * <p>
 * This checks if the specified unit can be added to, or subtracted from, this year.
 * If false, then calling the {@link #plus(long,java.time.temporal.TemporalUnit)} and
 * {@link #minus(long,java.time.temporal.TemporalUnit) minus} methods will throw an exception.
 * <p>
 * If the unit is a {@link java.time.temporal.ChronoUnit ChronoUnit} then the query is implemented here.
 * The supported units are:
 * <ul>
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
 * This year is used to enhance the accuracy of the returned range.
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
 * Gets the value of the specified field from this year as an {@code int}.
 * <p>
 * This queries this year for the value of the specified field.
 * The returned value will always be within the valid range of values for the field.
 * If it is not possible to return the value, because the field is not supported
 * or for some other reason, an exception is thrown.
 * <p>
 * If the field is a {@link java.time.temporal.ChronoField ChronoField} then the query is implemented here.
 * The {@link #isSupported(java.time.temporal.TemporalField) supported fields} will return valid
 * values based on this year.
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
 * Gets the value of the specified field from this year as a {@code long}.
 * <p>
 * This queries this year for the value of the specified field.
 * If it is not possible to return the value, because the field is not supported
 * or for some other reason, an exception is thrown.
 * <p>
 * If the field is a {@link java.time.temporal.ChronoField ChronoField} then the query is implemented here.
 * The {@link #isSupported(java.time.temporal.TemporalField) supported fields} will return valid
 * values based on this year.
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
 * Checks if the year is a leap year, according to the ISO proleptic
 * calendar system rules.
 * <p>
 * This method applies the current rules for leap years across the whole time-line.
 * In general, a year is a leap year if it is divisible by four without
 * remainder. However, years divisible by 100, are not leap years, with
 * the exception of years divisible by 400 which are.
 * <p>
 * For example, 1904 is a leap year it is divisible by 4.
 * 1900 was not a leap year as it is divisible by 100, however 2000 was a
 * leap year as it is divisible by 400.
 * <p>
 * The calculation is proleptic - applying the same rules into the far future and far past.
 * This is historically inaccurate, but is correct for the ISO-8601 standard.
 *
 * @return true if the year is leap, false otherwise
 * @apiSince 26
 */

public boolean isLeap() { throw new RuntimeException("Stub!"); }

/**
 * Checks if the month-day is valid for this year.
 * <p>
 * This method checks whether this year and the input month and day form
 * a valid date.
 *
 * @param monthDay  the month-day to validate, null returns false
 * @return true if the month and day are valid for this year
 * @apiSince 26
 */

public boolean isValidMonthDay(java.time.MonthDay monthDay) { throw new RuntimeException("Stub!"); }

/**
 * Gets the length of this year in days.
 *
 * @return the length of this year in days, 365 or 366
 * @apiSince 26
 */

public int length() { throw new RuntimeException("Stub!"); }

/**
 * Returns an adjusted copy of this year.
 * <p>
 * This returns a {@code Year}, based on this one, with the year adjusted.
 * The adjustment takes place using the specified adjuster strategy object.
 * Read the documentation of the adjuster to understand what adjustment will be made.
 * <p>
 * The result of this method is obtained by invoking the
 * {@link java.time.temporal.TemporalAdjuster#adjustInto(java.time.temporal.Temporal) TemporalAdjuster#adjustInto(Temporal)} method on the
 * specified adjuster passing {@code this} as the argument.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param adjuster the adjuster to use, not null
 * @return a {@code Year} based on {@code this} with the adjustment made, not null
 * @throws java.time.DateTimeException if the adjustment cannot be made
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public java.time.Year with(java.time.temporal.TemporalAdjuster adjuster) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this year with the specified field set to a new value.
 * <p>
 * This returns a {@code Year}, based on this one, with the value
 * for the specified field changed.
 * If it is not possible to set the value, because the field is not supported or for
 * some other reason, an exception is thrown.
 * <p>
 * If the field is a {@link java.time.temporal.ChronoField ChronoField} then the adjustment is implemented here.
 * The supported fields behave as follows:
 * <ul>
 * <li>{@code YEAR_OF_ERA} -
 *  Returns a {@code Year} with the specified year-of-era
 *  The era will be unchanged.
 * <li>{@code YEAR} -
 *  Returns a {@code Year} with the specified year.
 *  This completely replaces the date and is equivalent to {@link #of(int)}.
 * <li>{@code ERA} -
 *  Returns a {@code Year} with the specified era.
 *  The year-of-era will be unchanged.
 * </ul>
 * <p>
 * In all cases, if the new value is outside the valid range of values for the field
 * then a {@code DateTimeException} will be thrown.
 * <p>
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
 * @return a {@code Year} based on {@code this} with the specified field set, not null
 * @throws java.time.DateTimeException if the field cannot be set
 * @throws java.time.temporal.UnsupportedTemporalTypeException if the field is not supported
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public java.time.Year with(java.time.temporal.TemporalField field, long newValue) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this year with the specified amount added.
 * <p>
 * This returns a {@code Year}, based on this one, with the specified amount added.
 * The amount is typically {@link java.time.Period Period} but may be any other type implementing
 * the {@link java.time.temporal.TemporalAmount TemporalAmount} interface.
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
 * @return a {@code Year} based on this year with the addition made, not null
 * @throws java.time.DateTimeException if the addition cannot be made
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public java.time.Year plus(java.time.temporal.TemporalAmount amountToAdd) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this year with the specified amount added.
 * <p>
 * This returns a {@code Year}, based on this one, with the amount
 * in terms of the unit added. If it is not possible to add the amount, because the
 * unit is not supported or for some other reason, an exception is thrown.
 * <p>
 * If the field is a {@link java.time.temporal.ChronoUnit ChronoUnit} then the addition is implemented here.
 * The supported fields behave as follows:
 * <ul>
 * <li>{@code YEARS} -
 *  Returns a {@code Year} with the specified number of years added.
 *  This is equivalent to {@link #plusYears(long)}.
 * <li>{@code DECADES} -
 *  Returns a {@code Year} with the specified number of decades added.
 *  This is equivalent to calling {@link #plusYears(long)} with the amount
 *  multiplied by 10.
 * <li>{@code CENTURIES} -
 *  Returns a {@code Year} with the specified number of centuries added.
 *  This is equivalent to calling {@link #plusYears(long)} with the amount
 *  multiplied by 100.
 * <li>{@code MILLENNIA} -
 *  Returns a {@code Year} with the specified number of millennia added.
 *  This is equivalent to calling {@link #plusYears(long)} with the amount
 *  multiplied by 1,000.
 * <li>{@code ERAS} -
 *  Returns a {@code Year} with the specified number of eras added.
 *  Only two eras are supported so the amount must be one, zero or minus one.
 *  If the amount is non-zero then the year is changed such that the year-of-era
 *  is unchanged.
 * </ul>
 * <p>
 * All other {@code ChronoUnit} instances will throw an {@code UnsupportedTemporalTypeException}.
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
 * @return a {@code Year} based on this year with the specified amount added, not null
 * @throws java.time.DateTimeException if the addition cannot be made
 * @throws java.time.temporal.UnsupportedTemporalTypeException if the unit is not supported
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public java.time.Year plus(long amountToAdd, java.time.temporal.TemporalUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this {@code Year} with the specified number of years added.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param yearsToAdd  the years to add, may be negative
 * @return a {@code Year} based on this year with the years added, not null
 * @throws java.time.DateTimeException if the result exceeds the supported range
 * @apiSince 26
 */

public java.time.Year plusYears(long yearsToAdd) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this year with the specified amount subtracted.
 * <p>
 * This returns a {@code Year}, based on this one, with the specified amount subtracted.
 * The amount is typically {@link java.time.Period Period} but may be any other type implementing
 * the {@link java.time.temporal.TemporalAmount TemporalAmount} interface.
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
 * @return a {@code Year} based on this year with the subtraction made, not null
 * @throws java.time.DateTimeException if the subtraction cannot be made
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public java.time.Year minus(java.time.temporal.TemporalAmount amountToSubtract) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this year with the specified amount subtracted.
 * <p>
 * This returns a {@code Year}, based on this one, with the amount
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
 * @return a {@code Year} based on this year with the specified amount subtracted, not null
 * @throws java.time.DateTimeException if the subtraction cannot be made
 * @throws java.time.temporal.UnsupportedTemporalTypeException if the unit is not supported
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public java.time.Year minus(long amountToSubtract, java.time.temporal.TemporalUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this {@code Year} with the specified number of years subtracted.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param yearsToSubtract  the years to subtract, may be negative
 * @return a {@code Year} based on this year with the year subtracted, not null
 * @throws java.time.DateTimeException if the result exceeds the supported range
 * @apiSince 26
 */

public java.time.Year minusYears(long yearsToSubtract) { throw new RuntimeException("Stub!"); }

/**
 * Queries this year using the specified query.
 * <p>
 * This queries this year using the specified query strategy object.
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
 * Adjusts the specified temporal object to have this year.
 * <p>
 * This returns a temporal object of the same observable type as the input
 * with the year changed to be the same as this.
 * <p>
 * The adjustment is equivalent to using {@link java.time.temporal.Temporal#with(java.time.temporal.TemporalField,long) Temporal#with(TemporalField, long)}
 * passing {@link java.time.temporal.ChronoField#YEAR ChronoField#YEAR} as the field.
 * If the specified temporal object does not use the ISO calendar system then
 * a {@code DateTimeException} is thrown.
 * <p>
 * In most cases, it is clearer to reverse the calling pattern by using
 * {@link java.time.temporal.Temporal#with(java.time.temporal.TemporalAdjuster) Temporal#with(TemporalAdjuster)}:
 * <pre>
 *   // these two lines are equivalent, but the second approach is recommended
 *   temporal = thisYear.adjustInto(temporal);
 *   temporal = temporal.with(thisYear);
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
 * Calculates the amount of time until another year in terms of the specified unit.
 * <p>
 * This calculates the amount of time between two {@code Year}
 * objects in terms of a single {@code TemporalUnit}.
 * The start and end points are {@code this} and the specified year.
 * The result will be negative if the end is before the start.
 * The {@code Temporal} passed to this method is converted to a
 * {@code Year} using {@link #from(java.time.temporal.TemporalAccessor)}.
 * For example, the amount in decades between two year can be calculated
 * using {@code startYear.until(endYear, DECADES)}.
 * <p>
 * The calculation returns a whole number, representing the number of
 * complete units between the two years.
 * For example, the amount in decades between 2012 and 2031
 * will only be one decade as it is one year short of two decades.
 * <p>
 * There are two equivalent ways of using this method.
 * The first is to invoke this method.
 * The second is to use {@link java.time.temporal.TemporalUnit#between(java.time.temporal.Temporal,java.time.temporal.Temporal) TemporalUnit#between(Temporal, Temporal)}:
 * <pre>
 *   // these two lines are equivalent
 *   amount = start.until(end, YEARS);
 *   amount = YEARS.between(start, end);
 * </pre>
 * The choice should be made based on which makes the code more readable.
 * <p>
 * The calculation is implemented in this method for {@link java.time.temporal.ChronoUnit ChronoUnit}.
 * The units {@code YEARS}, {@code DECADES}, {@code CENTURIES},
 * {@code MILLENNIA} and {@code ERAS} are supported.
 * Other {@code ChronoUnit} values will throw an exception.
 * <p>
 * If the unit is not a {@code ChronoUnit}, then the result of this method
 * is obtained by invoking {@code TemporalUnit.between(Temporal, Temporal)}
 * passing {@code this} as the first argument and the converted input temporal
 * as the second argument.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param endExclusive  the end date, exclusive, which is converted to a {@code Year}, not null
 * @param unit  the unit to measure the amount in, not null
 * @return the amount of time between this year and the end year
 * @throws java.time.DateTimeException if the amount cannot be calculated, or the end
 *  temporal cannot be converted to a {@code Year}
 * @throws java.time.temporal.UnsupportedTemporalTypeException if the unit is not supported
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public long until(java.time.temporal.Temporal endExclusive, java.time.temporal.TemporalUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * Formats this year using the specified formatter.
 * <p>
 * This year will be passed to the formatter to produce a string.
 *
 * @param formatter  the formatter to use, not null
 * @return the formatted year string, not null
 * @throws java.time.DateTimeException if an error occurs during printing
 * @apiSince 26
 */

public java.lang.String format(java.time.format.DateTimeFormatter formatter) { throw new RuntimeException("Stub!"); }

/**
 * Combines this year with a day-of-year to create a {@code LocalDate}.
 * <p>
 * This returns a {@code LocalDate} formed from this year and the specified day-of-year.
 * <p>
 * The day-of-year value 366 is only valid in a leap year.
 *
 * @param dayOfYear  the day-of-year to use, from 1 to 365-366
 * @return the local date formed from this year and the specified date of year, not null
 * @throws java.time.DateTimeException if the day of year is zero or less, 366 or greater or equal
 *  to 366 and this is not a leap year
 * @apiSince 26
 */

public java.time.LocalDate atDay(int dayOfYear) { throw new RuntimeException("Stub!"); }

/**
 * Combines this year with a month to create a {@code YearMonth}.
 * <p>
 * This returns a {@code YearMonth} formed from this year and the specified month.
 * All possible combinations of year and month are valid.
 * <p>
 * This method can be used as part of a chain to produce a date:
 * <pre>
 *  LocalDate date = year.atMonth(month).atDay(day);
 * </pre>
 *
 * @param month  the month-of-year to use, not null
 * @return the year-month formed from this year and the specified month, not null
 * @apiSince 26
 */

public java.time.YearMonth atMonth(java.time.Month month) { throw new RuntimeException("Stub!"); }

/**
 * Combines this year with a month to create a {@code YearMonth}.
 * <p>
 * This returns a {@code YearMonth} formed from this year and the specified month.
 * All possible combinations of year and month are valid.
 * <p>
 * This method can be used as part of a chain to produce a date:
 * <pre>
 *  LocalDate date = year.atMonth(month).atDay(day);
 * </pre>
 *
 * @param month  the month-of-year to use, from 1 (January) to 12 (December)
 * @return the year-month formed from this year and the specified month, not null
 * @throws java.time.DateTimeException if the month is invalid
 * @apiSince 26
 */

public java.time.YearMonth atMonth(int month) { throw new RuntimeException("Stub!"); }

/**
 * Combines this year with a month-day to create a {@code LocalDate}.
 * <p>
 * This returns a {@code LocalDate} formed from this year and the specified month-day.
 * <p>
 * A month-day of February 29th will be adjusted to February 28th in the resulting
 * date if the year is not a leap year.
 *
 * @param monthDay  the month-day to use, not null
 * @return the local date formed from this year and the specified month-day, not null
 * @apiSince 26
 */

public java.time.LocalDate atMonthDay(java.time.MonthDay monthDay) { throw new RuntimeException("Stub!"); }

/**
 * Compares this year to another year.
 * <p>
 * The comparison is based on the value of the year.
 * It is "consistent with equals", as defined by {@link java.lang.Comparable Comparable}.
 *
 * @param other  the other year to compare to, not null
 * @return the comparator value, negative if less, positive if greater
 * @apiSince 26
 */

public int compareTo(java.time.Year other) { throw new RuntimeException("Stub!"); }

/**
 * Checks if this year is after the specified year.
 *
 * @param other  the other year to compare to, not null
 * @return true if this is after the specified year
 * @apiSince 26
 */

public boolean isAfter(java.time.Year other) { throw new RuntimeException("Stub!"); }

/**
 * Checks if this year is before the specified year.
 *
 * @param other  the other year to compare to, not null
 * @return true if this point is before the specified year
 * @apiSince 26
 */

public boolean isBefore(java.time.Year other) { throw new RuntimeException("Stub!"); }

/**
 * Checks if this year is equal to another year.
 * <p>
 * The comparison is based on the time-line position of the years.
 *
 * @param obj  the object to check, null returns false
 * @return true if this is equal to the other year
 * @apiSince 26
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * A hash code for this year.
 *
 * @return a suitable hash code
 * @apiSince 26
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Outputs this year as a {@code String}.
 *
 * @return a string representation of this year, not null
 * @apiSince 26
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * The maximum supported year, '+999,999,999'.
 * @apiSince 26
 */

public static final int MAX_VALUE = 999999999; // 0x3b9ac9ff

/**
 * The minimum supported year, '-999,999,999'.
 * @apiSince 26
 */

public static final int MIN_VALUE = -999999999; // 0xc4653601
}

