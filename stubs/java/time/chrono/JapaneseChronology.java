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
 * Copyright (c) 2012, Stephen Colebourne & Michael Nascimento Santos
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


package java.time.chrono;

import java.time.temporal.ChronoField;
import java.util.Locale;
import java.time.DateTimeException;

/**
 * The Japanese Imperial calendar system.
 * <p>
 * This chronology defines the rules of the Japanese Imperial calendar system.
 * This calendar system is primarily used in Japan.
 * The Japanese Imperial calendar system is the same as the ISO calendar system
 * apart from the era-based year numbering.
 * <p>
 * Japan introduced the Gregorian calendar starting with Meiji 6.
 * Only Meiji and later eras are supported;
 * dates before Meiji 6, January 1 are not supported.
 * <p>
 * The supported {@code ChronoField} instances are:
 * <ul>
 * <li>{@code DAY_OF_WEEK}
 * <li>{@code DAY_OF_MONTH}
 * <li>{@code DAY_OF_YEAR}
 * <li>{@code EPOCH_DAY}
 * <li>{@code MONTH_OF_YEAR}
 * <li>{@code PROLEPTIC_MONTH}
 * <li>{@code YEAR_OF_ERA}
 * <li>{@code YEAR}
 * <li>{@code ERA}
 * </ul>
 *
 * @implSpec
 * This class is immutable and thread-safe.
 *
 * @since 1.8
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class JapaneseChronology extends java.time.chrono.AbstractChronology implements java.io.Serializable {

private JapaneseChronology() { throw new RuntimeException("Stub!"); }

/**
 * Gets the ID of the chronology - 'Japanese'.
 * <p>
 * The ID uniquely identifies the {@code Chronology}.
 * It can be used to lookup the {@code Chronology} using {@link java.time.chrono.Chronology#of(java.lang.String) Chronology#of(String)}.
 *
 * @return the chronology ID - 'Japanese'
 * @see #getCalendarType()
 * @apiSince 26
 */

public java.lang.String getId() { throw new RuntimeException("Stub!"); }

/**
 * Gets the calendar type of the underlying calendar system - 'japanese'.
 * <p>
 * The calendar type is an identifier defined by the
 * <em>Unicode Locale Data Markup Language (LDML)</em> specification.
 * It can be used to lookup the {@code Chronology} using {@link java.time.chrono.Chronology#of(java.lang.String) Chronology#of(String)}.
 * It can also be used as part of a locale, accessible via
 * {@link java.util.Locale#getUnicodeLocaleType(java.lang.String) Locale#getUnicodeLocaleType(String)} with the key 'ca'.
 *
 * @return the calendar system type - 'japanese'
 * @see #getId()
 * @apiSince 26
 */

public java.lang.String getCalendarType() { throw new RuntimeException("Stub!"); }

/**
 * Obtains a local date in Japanese calendar system from the
 * era, year-of-era, month-of-year and day-of-month fields.
 * <p>
 * The Japanese month and day-of-month are the same as those in the
 * ISO calendar system. They are not reset when the era changes.
 * For example:
 * <pre>
 *  6th Jan Showa 64 = ISO 1989-01-06
 *  7th Jan Showa 64 = ISO 1989-01-07
 *  8th Jan Heisei 1 = ISO 1989-01-08
 *  9th Jan Heisei 1 = ISO 1989-01-09
 * </pre>
 *
 * @param era  the Japanese era, not null
 * @param yearOfEra  the year-of-era
 * @param month  the month-of-year
 * @param dayOfMonth  the day-of-month
 * @return the Japanese local date, not null
 * @throws java.time.DateTimeException if unable to create the date
 * @throws java.lang.ClassCastException if the {@code era} is not a {@code JapaneseEra}
 * @apiSince 26
 */

public java.time.chrono.JapaneseDate date(java.time.chrono.Era era, int yearOfEra, int month, int dayOfMonth) { throw new RuntimeException("Stub!"); }

/**
 * Obtains a local date in Japanese calendar system from the
 * proleptic-year, month-of-year and day-of-month fields.
 * <p>
 * The Japanese proleptic year, month and day-of-month are the same as those
 * in the ISO calendar system. They are not reset when the era changes.
 *
 * @param prolepticYear  the proleptic-year
 * @param month  the month-of-year
 * @param dayOfMonth  the day-of-month
 * @return the Japanese local date, not null
 * @throws java.time.DateTimeException if unable to create the date
 * @apiSince 26
 */

public java.time.chrono.JapaneseDate date(int prolepticYear, int month, int dayOfMonth) { throw new RuntimeException("Stub!"); }

/**
 * Obtains a local date in Japanese calendar system from the
 * era, year-of-era and day-of-year fields.
 * <p>
 * The day-of-year in this factory is expressed relative to the start of the year-of-era.
 * This definition changes the normal meaning of day-of-year only in those years
 * where the year-of-era is reset to one due to a change in the era.
 * For example:
 * <pre>
 *  6th Jan Showa 64 = day-of-year 6
 *  7th Jan Showa 64 = day-of-year 7
 *  8th Jan Heisei 1 = day-of-year 1
 *  9th Jan Heisei 1 = day-of-year 2
 * </pre>
 *
 * @param era  the Japanese era, not null
 * @param yearOfEra  the year-of-era
 * @param dayOfYear  the day-of-year
 * @return the Japanese local date, not null
 * @throws java.time.DateTimeException if unable to create the date
 * @throws java.lang.ClassCastException if the {@code era} is not a {@code JapaneseEra}
 * @apiSince 26
 */

public java.time.chrono.JapaneseDate dateYearDay(java.time.chrono.Era era, int yearOfEra, int dayOfYear) { throw new RuntimeException("Stub!"); }

/**
 * Obtains a local date in Japanese calendar system from the
 * proleptic-year and day-of-year fields.
 * <p>
 * The day-of-year in this factory is expressed relative to the start of the proleptic year.
 * The Japanese proleptic year and day-of-year are the same as those in the ISO calendar system.
 * They are not reset when the era changes.
 *
 * @param prolepticYear  the proleptic-year
 * @param dayOfYear  the day-of-year
 * @return the Japanese local date, not null
 * @throws java.time.DateTimeException if unable to create the date
 * @apiSince 26
 */

public java.time.chrono.JapaneseDate dateYearDay(int prolepticYear, int dayOfYear) { throw new RuntimeException("Stub!"); }

/**
 * Obtains a local date in the Japanese calendar system from the epoch-day.
 *
 * @param epochDay  the epoch day
 * @return the Japanese local date, not null
 * @throws java.time.DateTimeException if unable to create the date
 * @apiSince 26
 */

public java.time.chrono.JapaneseDate dateEpochDay(long epochDay) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.time.chrono.JapaneseDate dateNow() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.time.chrono.JapaneseDate dateNow(java.time.ZoneId zone) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.time.chrono.JapaneseDate dateNow(java.time.Clock clock) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.time.chrono.JapaneseDate date(java.time.temporal.TemporalAccessor temporal) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.time.chrono.ChronoLocalDateTime<java.time.chrono.JapaneseDate> localDateTime(java.time.temporal.TemporalAccessor temporal) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.time.chrono.ChronoZonedDateTime<java.time.chrono.JapaneseDate> zonedDateTime(java.time.temporal.TemporalAccessor temporal) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.time.chrono.ChronoZonedDateTime<java.time.chrono.JapaneseDate> zonedDateTime(java.time.Instant instant, java.time.ZoneId zone) { throw new RuntimeException("Stub!"); }

/**
 * Checks if the specified year is a leap year.
 * <p>
 * Japanese calendar leap years occur exactly in line with ISO leap years.
 * This method does not validate the year passed in, and only has a
 * well-defined result for years in the supported range.
 *
 * @param prolepticYear  the proleptic-year to check, not validated for range
 * @return true if the year is a leap year
 * @apiSince 26
 */

public boolean isLeapYear(long prolepticYear) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int prolepticYear(java.time.chrono.Era era, int yearOfEra) { throw new RuntimeException("Stub!"); }

/**
 * Returns the calendar system era object from the given numeric value.
 *
 * See the description of each Era for the numeric values of:
 * {@link java.time.chrono.JapaneseEra#HEISEI JapaneseEra#HEISEI}, {@link java.time.chrono.JapaneseEra#SHOWA JapaneseEra#SHOWA},{@link java.time.chrono.JapaneseEra#TAISHO JapaneseEra#TAISHO},
 * {@link java.time.chrono.JapaneseEra#MEIJI JapaneseEra#MEIJI}), only Meiji and later eras are supported.
 *
 * @param eraValue  the era value
 * @return the Japanese {@code Era} for the given numeric era value
 * @throws java.time.DateTimeException if {@code eraValue} is invalid
 * @apiSince 26
 */

public java.time.chrono.JapaneseEra eraOf(int eraValue) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.util.List<java.time.chrono.Era> eras() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.time.temporal.ValueRange range(java.time.temporal.ChronoField field) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.time.chrono.JapaneseDate resolveDate(java.util.Map<java.time.temporal.TemporalField,java.lang.Long> fieldValues, java.time.format.ResolverStyle resolverStyle) { throw new RuntimeException("Stub!"); }

/**
 * Singleton instance for Japanese chronology.
 * @apiSince 26
 */

public static final java.time.chrono.JapaneseChronology INSTANCE;
static { INSTANCE = null; }
}

