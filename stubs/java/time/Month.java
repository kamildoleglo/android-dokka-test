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
import java.time.temporal.TemporalField;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

/**
 * A month-of-year, such as 'July'.
 * <p>
 * {@code Month} is an enum representing the 12 months of the year -
 * January, February, March, April, May, June, July, August, September, October,
 * November and December.
 * <p>
 * In addition to the textual enum name, each month-of-year has an {@code int} value.
 * The {@code int} value follows normal usage and the ISO-8601 standard,
 * from 1 (January) to 12 (December). It is recommended that applications use the enum
 * rather than the {@code int} value to ensure code clarity.
 * <p>
 * <b>Do not use {@code ordinal()} to obtain the numeric representation of {@code Month}.
 * Use {@code getValue()} instead.</b>
 * <p>
 * This enum represents a common concept that is found in many calendar systems.
 * As such, this enum may be used by any calendar system that has the month-of-year
 * concept defined exactly equivalent to the ISO-8601 calendar system.
 *
 * @implSpec
 * This is an immutable and thread-safe enum.
 *
 * @since 1.8
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum Month implements java.time.temporal.TemporalAccessor, java.time.temporal.TemporalAdjuster {
/**
 * The singleton instance for the month of January with 31 days.
 * This has the numeric value of {@code 1}.
 * @apiSince 26
 */

JANUARY,
/**
 * The singleton instance for the month of February with 28 days, or 29 in a leap year.
 * This has the numeric value of {@code 2}.
 * @apiSince 26
 */

FEBRUARY,
/**
 * The singleton instance for the month of March with 31 days.
 * This has the numeric value of {@code 3}.
 * @apiSince 26
 */

MARCH,
/**
 * The singleton instance for the month of April with 30 days.
 * This has the numeric value of {@code 4}.
 * @apiSince 26
 */

APRIL,
/**
 * The singleton instance for the month of May with 31 days.
 * This has the numeric value of {@code 5}.
 * @apiSince 26
 */

MAY,
/**
 * The singleton instance for the month of June with 30 days.
 * This has the numeric value of {@code 6}.
 * @apiSince 26
 */

JUNE,
/**
 * The singleton instance for the month of July with 31 days.
 * This has the numeric value of {@code 7}.
 * @apiSince 26
 */

JULY,
/**
 * The singleton instance for the month of August with 31 days.
 * This has the numeric value of {@code 8}.
 * @apiSince 26
 */

AUGUST,
/**
 * The singleton instance for the month of September with 30 days.
 * This has the numeric value of {@code 9}.
 * @apiSince 26
 */

SEPTEMBER,
/**
 * The singleton instance for the month of October with 31 days.
 * This has the numeric value of {@code 10}.
 * @apiSince 26
 */

OCTOBER,
/**
 * The singleton instance for the month of November with 30 days.
 * This has the numeric value of {@code 11}.
 * @apiSince 26
 */

NOVEMBER,
/**
 * The singleton instance for the month of December with 31 days.
 * This has the numeric value of {@code 12}.
 * @apiSince 26
 */

DECEMBER;

/**
 * Obtains an instance of {@code Month} from an {@code int} value.
 * <p>
 * {@code Month} is an enum representing the 12 months of the year.
 * This factory allows the enum to be obtained from the {@code int} value.
 * The {@code int} value follows the ISO-8601 standard, from 1 (January) to 12 (December).
 *
 * @param month  the month-of-year to represent, from 1 (January) to 12 (December)
 * @return the month-of-year, not null
 * @throws java.time.DateTimeException if the month-of-year is invalid
 * @apiSince 26
 */

public static java.time.Month of(int month) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code Month} from a temporal object.
 * <p>
 * This obtains a month based on the specified temporal.
 * A {@code TemporalAccessor} represents an arbitrary set of date and time information,
 * which this factory converts to an instance of {@code Month}.
 * <p>
 * The conversion extracts the {@link java.time.temporal.ChronoField#MONTH_OF_YEAR ChronoField#MONTH_OF_YEAR} field.
 * The extraction is only permitted if the temporal object has an ISO
 * chronology, or can be converted to a {@code LocalDate}.
 * <p>
 * This method matches the signature of the functional interface {@link java.time.temporal.TemporalQuery TemporalQuery}
 * allowing it to be used as a query via method reference, {@code Month::from}.
 *
 * @param temporal  the temporal object to convert, not null
 * @return the month-of-year, not null
 * @throws java.time.DateTimeException if unable to convert to a {@code Month}
 * @apiSince 26
 */

public static java.time.Month from(java.time.temporal.TemporalAccessor temporal) { throw new RuntimeException("Stub!"); }

/**
 * Gets the month-of-year {@code int} value.
 * <p>
 * The values are numbered following the ISO-8601 standard,
 * from 1 (January) to 12 (December).
 *
 * @return the month-of-year, from 1 (January) to 12 (December)
 * @apiSince 26
 */

public int getValue() { throw new RuntimeException("Stub!"); }

/**
 * Gets the textual representation, such as 'Jan' or 'December'.
 * <p>
 * This returns the textual name used to identify the month-of-year,
 * suitable for presentation to the user.
 * The parameters control the style of the returned text and the locale.
 * <p>
 * If no textual mapping is found then the {@link #getValue() numeric value} is returned.
 *
 * @param style  the length of the text required, not null
 * @param locale  the locale to use, not null
 * @return the text value of the month-of-year, not null
 * @apiSince 26
 */

public java.lang.String getDisplayName(java.time.format.TextStyle style, java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Checks if the specified field is supported.
 * <p>
 * This checks if this month-of-year can be queried for the specified field.
 * If false, then calling the {@link #range(java.time.temporal.TemporalField) range} and
 * {@link #get(java.time.temporal.TemporalField) get} methods will throw an exception.
 * <p>
 * If the field is {@link java.time.temporal.ChronoField#MONTH_OF_YEAR ChronoField#MONTH_OF_YEAR} then
 * this method returns true.
 * All other {@code ChronoField} instances will return false.
 * <p>
 * If the field is not a {@code ChronoField}, then the result of this method
 * is obtained by invoking {@code TemporalField.isSupportedBy(TemporalAccessor)}
 * passing {@code this} as the argument.
 * Whether the field is supported is determined by the field.
 *
 * @param field  the field to check, null returns false
 * @return true if the field is supported on this month-of-year, false if not
 * @apiSince 26
 */

public boolean isSupported(java.time.temporal.TemporalField field) { throw new RuntimeException("Stub!"); }

/**
 * Gets the range of valid values for the specified field.
 * <p>
 * The range object expresses the minimum and maximum valid values for a field.
 * This month is used to enhance the accuracy of the returned range.
 * If it is not possible to return the range, because the field is not supported
 * or for some other reason, an exception is thrown.
 * <p>
 * If the field is {@link java.time.temporal.ChronoField#MONTH_OF_YEAR ChronoField#MONTH_OF_YEAR} then the
 * range of the month-of-year, from 1 to 12, will be returned.
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
 * Gets the value of the specified field from this month-of-year as an {@code int}.
 * <p>
 * This queries this month for the value of the specified field.
 * The returned value will always be within the valid range of values for the field.
 * If it is not possible to return the value, because the field is not supported
 * or for some other reason, an exception is thrown.
 * <p>
 * If the field is {@link java.time.temporal.ChronoField#MONTH_OF_YEAR ChronoField#MONTH_OF_YEAR} then the
 * value of the month-of-year, from 1 to 12, will be returned.
 * All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.
 * <p>
 * If the field is not a {@code ChronoField}, then the result of this method
 * is obtained by invoking {@code TemporalField.getFrom(TemporalAccessor)}
 * passing {@code this} as the argument. Whether the value can be obtained,
 * and what the value represents, is determined by the field.
 *
 * @param field  the field to get, not null
 * @return the value for the field, within the valid range of values
 * @throws java.time.DateTimeException if a value for the field cannot be obtained or
 *         the value is outside the range of valid values for the field
 * @throws java.time.temporal.UnsupportedTemporalTypeException if the field is not supported or
 *         the range of values exceeds an {@code int}
 * @throws java.lang.ArithmeticException if numeric overflow occurs
 * @apiSince 26
 */

public int get(java.time.temporal.TemporalField field) { throw new RuntimeException("Stub!"); }

/**
 * Gets the value of the specified field from this month-of-year as a {@code long}.
 * <p>
 * This queries this month for the value of the specified field.
 * If it is not possible to return the value, because the field is not supported
 * or for some other reason, an exception is thrown.
 * <p>
 * If the field is {@link java.time.temporal.ChronoField#MONTH_OF_YEAR ChronoField#MONTH_OF_YEAR} then the
 * value of the month-of-year, from 1 to 12, will be returned.
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
 * Returns the month-of-year that is the specified number of quarters after this one.
 * <p>
 * The calculation rolls around the end of the year from December to January.
 * The specified period may be negative.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param months  the months to add, positive or negative
 * @return the resulting month, not null
 * @apiSince 26
 */

public java.time.Month plus(long months) { throw new RuntimeException("Stub!"); }

/**
 * Returns the month-of-year that is the specified number of months before this one.
 * <p>
 * The calculation rolls around the start of the year from January to December.
 * The specified period may be negative.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param months  the months to subtract, positive or negative
 * @return the resulting month, not null
 * @apiSince 26
 */

public java.time.Month minus(long months) { throw new RuntimeException("Stub!"); }

/**
 * Gets the length of this month in days.
 * <p>
 * This takes a flag to determine whether to return the length for a leap year or not.
 * <p>
 * February has 28 days in a standard year and 29 days in a leap year.
 * April, June, September and November have 30 days.
 * All other months have 31 days.
 *
 * @param leapYear  true if the length is required for a leap year
 * @return the length of this month in days, from 28 to 31
 * @apiSince 26
 */

public int length(boolean leapYear) { throw new RuntimeException("Stub!"); }

/**
 * Gets the minimum length of this month in days.
 * <p>
 * February has a minimum length of 28 days.
 * April, June, September and November have 30 days.
 * All other months have 31 days.
 *
 * @return the minimum length of this month in days, from 28 to 31
 * @apiSince 26
 */

public int minLength() { throw new RuntimeException("Stub!"); }

/**
 * Gets the maximum length of this month in days.
 * <p>
 * February has a maximum length of 29 days.
 * April, June, September and November have 30 days.
 * All other months have 31 days.
 *
 * @return the maximum length of this month in days, from 29 to 31
 * @apiSince 26
 */

public int maxLength() { throw new RuntimeException("Stub!"); }

/**
 * Gets the day-of-year corresponding to the first day of this month.
 * <p>
 * This returns the day-of-year that this month begins on, using the leap
 * year flag to determine the length of February.
 *
 * @param leapYear  true if the length is required for a leap year
 * @return the day of year corresponding to the first day of this month, from 1 to 336
 * @apiSince 26
 */

public int firstDayOfYear(boolean leapYear) { throw new RuntimeException("Stub!"); }

/**
 * Gets the month corresponding to the first month of this quarter.
 * <p>
 * The year can be divided into four quarters.
 * This method returns the first month of the quarter for the base month.
 * January, February and March return January.
 * April, May and June return April.
 * July, August and September return July.
 * October, November and December return October.
 *
 * @return the first month of the quarter corresponding to this month, not null
 * @apiSince 26
 */

public java.time.Month firstMonthOfQuarter() { throw new RuntimeException("Stub!"); }

/**
 * Queries this month-of-year using the specified query.
 * <p>
 * This queries this month-of-year using the specified query strategy object.
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
 * Adjusts the specified temporal object to have this month-of-year.
 * <p>
 * This returns a temporal object of the same observable type as the input
 * with the month-of-year changed to be the same as this.
 * <p>
 * The adjustment is equivalent to using {@link java.time.temporal.Temporal#with(java.time.temporal.TemporalField,long) Temporal#with(TemporalField, long)}
 * passing {@link java.time.temporal.ChronoField#MONTH_OF_YEAR ChronoField#MONTH_OF_YEAR} as the field.
 * If the specified temporal object does not use the ISO calendar system then
 * a {@code DateTimeException} is thrown.
 * <p>
 * In most cases, it is clearer to reverse the calling pattern by using
 * {@link java.time.temporal.Temporal#with(java.time.temporal.TemporalAdjuster) Temporal#with(TemporalAdjuster)}:
 * <pre>
 *   // these two lines are equivalent, but the second approach is recommended
 *   temporal = thisMonth.adjustInto(temporal);
 *   temporal = temporal.with(thisMonth);
 * </pre>
 * <p>
 * For example, given a date in May, the following are output:
 * <pre>
 *   dateInMay.with(JANUARY);    // four months earlier
 *   dateInMay.with(APRIL);      // one months earlier
 *   dateInMay.with(MAY);        // same date
 *   dateInMay.with(JUNE);       // one month later
 *   dateInMay.with(DECEMBER);   // seven months later
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
}

