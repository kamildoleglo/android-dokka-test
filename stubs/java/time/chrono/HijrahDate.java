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

/**
 * A date in the Hijrah calendar system.
 * <p>
 * This date operates using one of several variants of the
 * {@linkplain java.time.chrono.HijrahChronology HijrahChronology}.
 * <p>
 * The Hijrah calendar has a different total of days in a year than
 * Gregorian calendar, and the length of each month is based on the period
 * of a complete revolution of the moon around the earth
 * (as between successive new moons).
 * Refer to the {@link java.time.chrono.HijrahChronology HijrahChronology} for details of supported variants.
 * <p>
 * Each HijrahDate is created bound to a particular HijrahChronology,
 * The same chronology is propagated to each HijrahDate computed from the date.
 * To use a different Hijrah variant, its HijrahChronology can be used
 * to create new HijrahDate instances.
 * Alternatively, the {@link #withVariant} method can be used to convert
 * to a new HijrahChronology.
 *
 * @implSpec
 * This class is immutable and thread-safe.
 *
 * @since 1.8
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class HijrahDate implements java.time.chrono.ChronoLocalDate, java.time.temporal.Temporal, java.time.temporal.TemporalAdjuster, java.io.Serializable {

private HijrahDate() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the current {@code HijrahDate} of the Islamic Umm Al-Qura calendar
 * in the default time-zone.
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

public static java.time.chrono.HijrahDate now() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the current {@code HijrahDate} of the Islamic Umm Al-Qura calendar
 * in the specified time-zone.
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

public static java.time.chrono.HijrahDate now(java.time.ZoneId zone) { throw new RuntimeException("Stub!"); }

/**
 * Obtains the current {@code HijrahDate} of the Islamic Umm Al-Qura calendar
 * from the specified clock.
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

public static java.time.chrono.HijrahDate now(java.time.Clock clock) { throw new RuntimeException("Stub!"); }

/**
 * Obtains a {@code HijrahDate} of the Islamic Umm Al-Qura calendar
 * from the proleptic-year, month-of-year and day-of-month fields.
 * <p>
 * This returns a {@code HijrahDate} with the specified fields.
 * The day must be valid for the year and month, otherwise an exception will be thrown.
 *
 * @param prolepticYear  the Hijrah proleptic-year
 * @param month  the Hijrah month-of-year, from 1 to 12
 * @param dayOfMonth  the Hijrah day-of-month, from 1 to 30
 * @return the date in Hijrah calendar system, not null
 * @throws java.time.DateTimeException if the value of any field is out of range,
 *  or if the day-of-month is invalid for the month-year
 * @apiSince 26
 */

public static java.time.chrono.HijrahDate of(int prolepticYear, int month, int dayOfMonth) { throw new RuntimeException("Stub!"); }

/**
 * Obtains a {@code HijrahDate} of the Islamic Umm Al-Qura calendar from a temporal object.
 * <p>
 * This obtains a date in the Hijrah calendar system based on the specified temporal.
 * A {@code TemporalAccessor} represents an arbitrary set of date and time information,
 * which this factory converts to an instance of {@code HijrahDate}.
 * <p>
 * The conversion typically uses the {@link java.time.temporal.ChronoField#EPOCH_DAY ChronoField#EPOCH_DAY}
 * field, which is standardized across calendar systems.
 * <p>
 * This method matches the signature of the functional interface {@link java.time.temporal.TemporalQuery TemporalQuery}
 * allowing it to be used as a query via method reference, {@code HijrahDate::from}.
 *
 * @param temporal  the temporal object to convert, not null
 * @return the date in Hijrah calendar system, not null
 * @throws java.time.DateTimeException if unable to convert to a {@code HijrahDate}
 * @apiSince 26
 */

public static java.time.chrono.HijrahDate from(java.time.temporal.TemporalAccessor temporal) { throw new RuntimeException("Stub!"); }

/**
 * Gets the chronology of this date, which is the Hijrah calendar system.
 * <p>
 * The {@code Chronology} represents the calendar system in use.
 * The era and other fields in {@link java.time.temporal.ChronoField ChronoField} are defined by the chronology.
 *
 * @return the Hijrah chronology, not null
 * @apiSince 26
 */

public java.time.chrono.HijrahChronology getChronology() { throw new RuntimeException("Stub!"); }

/**
 * Gets the era applicable at this date.
 * <p>
 * The Hijrah calendar system has one era, 'AH',
 * defined by {@link java.time.chrono.HijrahEra HijrahEra}.
 *
 * @return the era applicable at this date, not null
 * @apiSince 26
 */

public java.time.chrono.HijrahEra getEra() { throw new RuntimeException("Stub!"); }

/**
 * Returns the length of the month represented by this date.
 * <p>
 * This returns the length of the month in days.
 * Month lengths in the Hijrah calendar system vary between 29 and 30 days.
 *
 * @return the length of the month in days
 */

public int lengthOfMonth() { throw new RuntimeException("Stub!"); }

/**
 * Returns the length of the year represented by this date.
 * <p>
 * This returns the length of the year in days.
 * A Hijrah calendar system year is typically shorter than
 * that of the ISO calendar system.
 *
 * @return the length of the year in days
 */

public int lengthOfYear() { throw new RuntimeException("Stub!"); }

public java.time.temporal.ValueRange range(java.time.temporal.TemporalField field) { throw new RuntimeException("Stub!"); }

public long getLong(java.time.temporal.TemporalField field) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.time.chrono.HijrahDate with(java.time.temporal.TemporalField field, long newValue) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws java.time.DateTimeException if unable to make the adjustment.
 *     For example, if the adjuster requires an ISO chronology
 * @throws java.lang.ArithmeticException {@inheritDoc}
 * @apiSince 26
 */

public java.time.chrono.HijrahDate with(java.time.temporal.TemporalAdjuster adjuster) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code HijrahDate} with the Chronology requested.
 * <p>
 * The year, month, and day are checked against the new requested
 * HijrahChronology.  If the chronology has a shorter month length
 * for the month, the day is reduced to be the last day of the month.
 *
 * @param chronology the new HijrahChonology, non-null
 * @return a HijrahDate with the requested HijrahChronology, non-null
 * @apiSince 26
 */

public java.time.chrono.HijrahDate withVariant(java.time.chrono.HijrahChronology chronology) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws java.time.DateTimeException {@inheritDoc}
 * @throws java.lang.ArithmeticException {@inheritDoc}
 * @apiSince 26
 */

public java.time.chrono.HijrahDate plus(java.time.temporal.TemporalAmount amount) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws java.time.DateTimeException {@inheritDoc}
 * @throws java.lang.ArithmeticException {@inheritDoc}
 * @apiSince 26
 */

public java.time.chrono.HijrahDate minus(java.time.temporal.TemporalAmount amount) { throw new RuntimeException("Stub!"); }

public long toEpochDay() { throw new RuntimeException("Stub!"); }

/**
 * Checks if the year is a leap year, according to the Hijrah calendar system rules.
 *
 * @return true if this date is in a leap year
 */

public boolean isLeapYear() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.time.chrono.HijrahDate plus(long amountToAdd, java.time.temporal.TemporalUnit unit) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.time.chrono.HijrahDate minus(long amountToSubtract, java.time.temporal.TemporalUnit unit) { throw new RuntimeException("Stub!"); }

public java.time.chrono.ChronoLocalDateTime<java.time.chrono.HijrahDate> atTime(java.time.LocalTime localTime) { throw new RuntimeException("Stub!"); }

public java.time.chrono.ChronoPeriod until(java.time.chrono.ChronoLocalDate endDate) { throw new RuntimeException("Stub!"); }

/**
 * Compares this date to another date, including the chronology.
 * <p>
 * Compares this {@code HijrahDate} with another ensuring that the date is the same.
 * <p>
 * Only objects of type {@code HijrahDate} are compared, other types return false.
 * To compare the dates of two {@code TemporalAccessor} instances, including dates
 * in two different chronologies, use {@link java.time.temporal.ChronoField#EPOCH_DAY ChronoField#EPOCH_DAY} as a comparator.
 *
 * @param obj  the object to check, null returns false
 * @return true if this is equal to the other date and the Chronologies are equal
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

