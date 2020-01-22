/*
 * Copyright (c) 2012, 2016, Oracle and/or its affiliates. All rights reserved.
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

import java.time.Clock;
import java.time.ZoneId;
import java.time.DateTimeException;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalQuery;
import java.time.temporal.TemporalField;

/**
 * A date in the Japanese Imperial calendar system.
 * <p>
 * This date operates using the {@linkplain java.time.chrono.JapaneseChronology JapaneseChronology}.
 * This calendar system is primarily used in Japan.
 * <p>
 * The Japanese Imperial calendar system is the same as the ISO calendar system
 * apart from the era-based year numbering. The proleptic-year is defined to be
 * equal to the ISO proleptic-year.
 * <p>
 * Japan introduced the Gregorian calendar starting with Meiji 6.
 * Only Meiji and later eras are supported;
 * dates before Meiji 6, January 1 are not supported.
 * <p>
 * For example, the Japanese year "Heisei 24" corresponds to ISO year "2012".<br>
 * Calling {@code japaneseDate.get(YEAR_OF_ERA)} will return 24.<br>
 * Calling {@code japaneseDate.get(YEAR)} will return 2012.<br>
 * Calling {@code japaneseDate.get(ERA)} will return 2, corresponding to
 * {@code JapaneseChronology.ERA_HEISEI}.<br>
 *
 * @implSpec
 * This class is immutable and thread-safe.
 *
 * @since 1.8
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class JapaneseDate implements java.time.chrono.ChronoLocalDate, java.time.temporal.Temporal, java.time.temporal.TemporalAdjuster, java.io.Serializable {

JapaneseDate() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the current {@code JapaneseDate} from the system clock in the default time-zone.
 * <p>
 * This will query the {@link java.time.Clock#systemDefaultZone() Clock#systemDefaultZone()} in the default
 * time-zone to obtain the current date.
 * <p>
 * Using this method will prevent the ability to use an alternate clock for testing
 * because the clock is hard-coded.
 *
 * @return the current date using the system clock and default time-zone, not null
 * @apiSince 26
 */

public static java.time.chrono.JapaneseDate now() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the current {@code JapaneseDate} from the system clock in the specified time-zone.
 * <p>
 * This will query the {@link java.time.Clock#system(java.time.ZoneId) Clock#system(ZoneId)} to obtain the current date.
 * Specifying the time-zone avoids dependence on the default time-zone.
 * <p>
 * Using this method will prevent the ability to use an alternate clock for testing
 * because the clock is hard-coded.
 *
 * @param zone  the zone ID to use, not null
 * @return the current date using the system clock, not null
 * @apiSince 26
 */

public static java.time.chrono.JapaneseDate now(java.time.ZoneId zone) { throw new RuntimeException("Stub!"); }

/**
 * Obtains the current {@code JapaneseDate} from the specified clock.
 * <p>
 * This will query the specified clock to obtain the current date - today.
 * Using this method allows the use of an alternate clock for testing.
 * The alternate clock may be introduced using {@linkplain java.time.Clock Clock}.
 *
 * @param clock  the clock to use, not null
 * @return the current date, not null
 * @throws java.time.DateTimeException if the current date cannot be obtained
 * @apiSince 26
 */

public static java.time.chrono.JapaneseDate now(java.time.Clock clock) { throw new RuntimeException("Stub!"); }

/**
 * Obtains a {@code JapaneseDate} representing a date in the Japanese calendar
 * system from the era, year-of-era, month-of-year and day-of-month fields.
 * <p>
 * This returns a {@code JapaneseDate} with the specified fields.
 * The day must be valid for the year and month, otherwise an exception will be thrown.
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
 * @param yearOfEra  the Japanese year-of-era
 * @param month  the Japanese month-of-year, from 1 to 12
 * @param dayOfMonth  the Japanese day-of-month, from 1 to 31
 * @return the date in Japanese calendar system, not null
 * @throws java.time.DateTimeException if the value of any field is out of range,
 *  or if the day-of-month is invalid for the month-year,
 *  or if the date is not a Japanese era
 * @apiSince 26
 */

public static java.time.chrono.JapaneseDate of(java.time.chrono.JapaneseEra era, int yearOfEra, int month, int dayOfMonth) { throw new RuntimeException("Stub!"); }

/**
 * Obtains a {@code JapaneseDate} representing a date in the Japanese calendar
 * system from the proleptic-year, month-of-year and day-of-month fields.
 * <p>
 * This returns a {@code JapaneseDate} with the specified fields.
 * The day must be valid for the year and month, otherwise an exception will be thrown.
 * <p>
 * The Japanese proleptic year, month and day-of-month are the same as those
 * in the ISO calendar system. They are not reset when the era changes.
 *
 * @param prolepticYear  the Japanese proleptic-year
 * @param month  the Japanese month-of-year, from 1 to 12
 * @param dayOfMonth  the Japanese day-of-month, from 1 to 31
 * @return the date in Japanese calendar system, not null
 * @throws java.time.DateTimeException if the value of any field is out of range,
 *  or if the day-of-month is invalid for the month-year
 * @apiSince 26
 */

public static java.time.chrono.JapaneseDate of(int prolepticYear, int month, int dayOfMonth) { throw new RuntimeException("Stub!"); }

/**
 * Obtains a {@code JapaneseDate} from a temporal object.
 * <p>
 * This obtains a date in the Japanese calendar system based on the specified temporal.
 * A {@code TemporalAccessor} represents an arbitrary set of date and time information,
 * which this factory converts to an instance of {@code JapaneseDate}.
 * <p>
 * The conversion typically uses the {@link java.time.temporal.ChronoField#EPOCH_DAY ChronoField#EPOCH_DAY}
 * field, which is standardized across calendar systems.
 * <p>
 * This method matches the signature of the functional interface {@link java.time.temporal.TemporalQuery TemporalQuery}
 * allowing it to be used as a query via method reference, {@code JapaneseDate::from}.
 *
 * @param temporal  the temporal object to convert, not null
 * @return the date in Japanese calendar system, not null
 * @throws java.time.DateTimeException if unable to convert to a {@code JapaneseDate}
 * @apiSince 26
 */

public static java.time.chrono.JapaneseDate from(java.time.temporal.TemporalAccessor temporal) { throw new RuntimeException("Stub!"); }

/**
 * Gets the chronology of this date, which is the Japanese calendar system.
 * <p>
 * The {@code Chronology} represents the calendar system in use.
 * The era and other fields in {@link java.time.temporal.ChronoField ChronoField} are defined by the chronology.
 *
 * @return the Japanese chronology, not null
 * @apiSince 26
 */

public java.time.chrono.JapaneseChronology getChronology() { throw new RuntimeException("Stub!"); }

/**
 * Gets the era applicable at this date.
 * <p>
 * The Japanese calendar system has multiple eras defined by {@link java.time.chrono.JapaneseEra JapaneseEra}.
 *
 * @return the era applicable at this date, not null
 * @apiSince 26
 */

public java.time.chrono.JapaneseEra getEra() { throw new RuntimeException("Stub!"); }

/**
 * Returns the length of the month represented by this date.
 * <p>
 * This returns the length of the month in days.
 * Month lengths match those of the ISO calendar system.
 *
 * @return the length of the month in days
 */

public int lengthOfMonth() { throw new RuntimeException("Stub!"); }

public int lengthOfYear() { throw new RuntimeException("Stub!"); }

/**
 * Checks if the specified field is supported.
 * <p>
 * This checks if this date can be queried for the specified field.
 * If false, then calling the {@link #range(java.time.temporal.TemporalField) range} and
 * {@link #get(java.time.temporal.TemporalField) get} methods will throw an exception.
 * <p>
 * If the field is a {@link java.time.temporal.ChronoField ChronoField} then the query is implemented here.
 * The supported fields are:
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
 * All other {@code ChronoField} instances will return false.
 * <p>
 * If the field is not a {@code ChronoField}, then the result of this method
 * is obtained by invoking {@code TemporalField.isSupportedBy(TemporalAccessor)}
 * passing {@code this} as the argument.
 * Whether the field is supported is determined by the field.
 *
 * @param field  the field to check, null returns false
 * @return true if the field is supported on this date, false if not
 */

public boolean isSupported(java.time.temporal.TemporalField field) { throw new RuntimeException("Stub!"); }

public java.time.temporal.ValueRange range(java.time.temporal.TemporalField field) { throw new RuntimeException("Stub!"); }

public long getLong(java.time.temporal.TemporalField field) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.time.chrono.JapaneseDate with(java.time.temporal.TemporalField field, long newValue) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws java.time.DateTimeException {@inheritDoc}
 * @throws java.lang.ArithmeticException {@inheritDoc}
 * @apiSince 26
 */

public java.time.chrono.JapaneseDate with(java.time.temporal.TemporalAdjuster adjuster) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws java.time.DateTimeException {@inheritDoc}
 * @throws java.lang.ArithmeticException {@inheritDoc}
 * @apiSince 26
 */

public java.time.chrono.JapaneseDate plus(java.time.temporal.TemporalAmount amount) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws java.time.DateTimeException {@inheritDoc}
 * @throws java.lang.ArithmeticException {@inheritDoc}
 * @apiSince 26
 */

public java.time.chrono.JapaneseDate minus(java.time.temporal.TemporalAmount amount) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.time.chrono.JapaneseDate plus(long amountToAdd, java.time.temporal.TemporalUnit unit) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.time.chrono.JapaneseDate minus(long amountToAdd, java.time.temporal.TemporalUnit unit) { throw new RuntimeException("Stub!"); }

public java.time.chrono.ChronoLocalDateTime<java.time.chrono.JapaneseDate> atTime(java.time.LocalTime localTime) { throw new RuntimeException("Stub!"); }

public java.time.chrono.ChronoPeriod until(java.time.chrono.ChronoLocalDate endDate) { throw new RuntimeException("Stub!"); }

public long toEpochDay() { throw new RuntimeException("Stub!"); }

/**
 * Compares this date to another date, including the chronology.
 * <p>
 * Compares this {@code JapaneseDate} with another ensuring that the date is the same.
 * <p>
 * Only objects of type {@code JapaneseDate} are compared, other types return false.
 * To compare the dates of two {@code TemporalAccessor} instances, including dates
 * in two different chronologies, use {@link java.time.temporal.ChronoField#EPOCH_DAY ChronoField#EPOCH_DAY} as a comparator.
 *
 * @param obj  the object to check, null returns false
 * @return true if this is equal to the other date
 * @apiSince 26
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * A hash code for this date.
 *
 * @return a suitable hash code based only on the Chronology and the date
 * @apiSince 26
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

public long until(java.time.temporal.Temporal endExclusive, java.time.temporal.TemporalUnit unit) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

