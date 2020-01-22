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

import java.util.Properties;
import java.time.DateTimeException;

/**
 * The Hijrah calendar is a lunar calendar supporting Islamic calendars.
 * <p>
 * The HijrahChronology follows the rules of the Hijrah calendar system. The Hijrah
 * calendar has several variants based on differences in when the new moon is
 * determined to have occurred and where the observation is made.
 * In some variants the length of each month is
 * computed algorithmically from the astronomical data for the moon and earth and
 * in others the length of the month is determined by an authorized sighting
 * of the new moon. For the algorithmically based calendars the calendar
 * can project into the future.
 * For sighting based calendars only historical data from past
 * sightings is available.
 * <p>
 * The length of each month is 29 or 30 days.
 * Ordinary years have 354 days; leap years have 355 days.
 *
 * <p>
 * CLDR and LDML identify variants:
 * <table cellpadding="2" summary="Variants of Hijrah Calendars">
 * <thead>
 * <tr class="tableSubHeadingColor">
 * <th class="colFirst" align="left" >Chronology ID</th>
 * <th class="colFirst" align="left" >Calendar Type</th>
 * <th class="colFirst" align="left" >Locale extension, see {@link java.util.Locale}</th>
 * <th class="colLast" align="left" >Description</th>
 * </tr>
 * </thead>
 * <tbody>
 * <tr class="altColor">
 * <td>Hijrah-umalqura</td>
 * <td>islamic-umalqura</td>
 * <td>ca-islamic-umalqura</td>
 * <td>Islamic - Umm Al-Qura calendar of Saudi Arabia</td>
 * </tr>
 * </tbody>
 * </table>
 * <p>Additional variants may be available through {@link java.time.chrono.Chronology#getAvailableChronologies() Chronology#getAvailableChronologies()}.
 *
 * <p>Example</p>
 * <p>
 * Selecting the chronology from the locale uses {@link java.time.chrono.Chronology#ofLocale Chronology#ofLocale}
 * to find the Chronology based on Locale supported BCP 47 extension mechanism
 * to request a specific calendar ("ca"). For example,
 * </p>
 * <pre>
 *      Locale locale = Locale.forLanguageTag("en-US-u-ca-islamic-umalqura");
 *      Chronology chrono = Chronology.ofLocale(locale);
 * </pre>
 *
 * @implSpec
 * This class is immutable and thread-safe.
 *
 * @implNote
 * Each Hijrah variant is configured individually. Each variant is defined by a
 * property resource that defines the {@code ID}, the {@code calendar type},
 * the start of the calendar, the alignment with the
 * ISO calendar, and the length of each month for a range of years.
 * The variants are identified in the {@code calendars.properties} file.
 * The new properties are prefixed with {@code "calendars.hijrah."}:
 * <table cellpadding="2" border="0" summary="Configuration of Hijrah Calendar Variants">
 * <thead>
 * <tr class="tableSubHeadingColor">
 * <th class="colFirst" align="left">Property Name</th>
 * <th class="colFirst" align="left">Property value</th>
 * <th class="colLast" align="left">Description </th>
 * </tr>
 * </thead>
 * <tbody>
 * <tr class="altColor">
 * <td>calendars.hijrah.{ID}</td>
 * <td>The property resource defining the {@code {ID}} variant</td>
 * <td>The property resource is located with the {@code calendars.properties} file</td>
 * </tr>
 * <tr class="rowColor">
 * <td>calendars.hijrah.{ID}.type</td>
 * <td>The calendar type</td>
 * <td>LDML defines the calendar type names</td>
 * </tr>
 * </tbody>
 * </table>
 * <p>
 * The Hijrah property resource is a set of properties that describe the calendar.
 * The syntax is defined by {@code java.util.Properties#load(Reader)}.
 * <table cellpadding="2" summary="Configuration of Hijrah Calendar">
 * <thead>
 * <tr class="tableSubHeadingColor">
 * <th class="colFirst" align="left" > Property Name</th>
 * <th class="colFirst" align="left" > Property value</th>
 * <th class="colLast" align="left" > Description </th>
 * </tr>
 * </thead>
 * <tbody>
 * <tr class="altColor">
 * <td>id</td>
 * <td>Chronology Id, for example, "Hijrah-umalqura"</td>
 * <td>The Id of the calendar in common usage</td>
 * </tr>
 * <tr class="rowColor">
 * <td>type</td>
 * <td>Calendar type, for example, "islamic-umalqura"</td>
 * <td>LDML defines the calendar types</td>
 * </tr>
 * <tr class="altColor">
 * <td>version</td>
 * <td>Version, for example: "1.8.0_1"</td>
 * <td>The version of the Hijrah variant data</td>
 * </tr>
 * <tr class="rowColor">
 * <td>iso-start</td>
 * <td>ISO start date, formatted as {@code yyyy-MM-dd}, for example: "1900-04-30"</td>
 * <td>The ISO date of the first day of the minimum Hijrah year.</td>
 * </tr>
 * <tr class="altColor">
 * <td>yyyy - a numeric 4 digit year, for example "1434"</td>
 * <td>The value is a sequence of 12 month lengths,
 * for example: "29 30 29 30 29 30 30 30 29 30 29 29"</td>
 * <td>The lengths of the 12 months of the year separated by whitespace.
 * A numeric year property must be present for every year without any gaps.
 * The month lengths must be between 29-32 inclusive.
 * </td>
 * </tr>
 * </tbody>
 * </table>
 *
 * @since 1.8
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class HijrahChronology extends java.time.chrono.AbstractChronology implements java.io.Serializable {

private HijrahChronology() { throw new RuntimeException("Stub!"); }

/**
 * Gets the ID of the chronology.
 * <p>
 * The ID uniquely identifies the {@code Chronology}. It can be used to
 * lookup the {@code Chronology} using {@link java.time.chrono.Chronology#of(java.lang.String) Chronology#of(String)}.
 *
 * @return the chronology ID, non-null
 * @see #getCalendarType()
 * @apiSince 26
 */

public java.lang.String getId() { throw new RuntimeException("Stub!"); }

/**
 * Gets the calendar type of the Islamic calendar.
 * <p>
 * The calendar type is an identifier defined by the
 * <em>Unicode Locale Data Markup Language (LDML)</em> specification.
 * It can be used to lookup the {@code Chronology} using {@link java.time.chrono.Chronology#of(java.lang.String) Chronology#of(String)}.
 *
 * @return the calendar system type; non-null if the calendar has
 *    a standard type, otherwise null
 * @see #getId()
 * @apiSince 26
 */

public java.lang.String getCalendarType() { throw new RuntimeException("Stub!"); }

/**
 * Obtains a local date in Hijrah calendar system from the
 * era, year-of-era, month-of-year and day-of-month fields.
 *
 * @param era  the Hijrah era, not null
 * @param yearOfEra  the year-of-era
 * @param month  the month-of-year
 * @param dayOfMonth  the day-of-month
 * @return the Hijrah local date, not null
 * @throws java.time.DateTimeException if unable to create the date
 * @throws java.lang.ClassCastException if the {@code era} is not a {@code HijrahEra}
 * @apiSince 26
 */

public java.time.chrono.HijrahDate date(java.time.chrono.Era era, int yearOfEra, int month, int dayOfMonth) { throw new RuntimeException("Stub!"); }

/**
 * Obtains a local date in Hijrah calendar system from the
 * proleptic-year, month-of-year and day-of-month fields.
 *
 * @param prolepticYear  the proleptic-year
 * @param month  the month-of-year
 * @param dayOfMonth  the day-of-month
 * @return the Hijrah local date, not null
 * @throws java.time.DateTimeException if unable to create the date
 * @apiSince 26
 */

public java.time.chrono.HijrahDate date(int prolepticYear, int month, int dayOfMonth) { throw new RuntimeException("Stub!"); }

/**
 * Obtains a local date in Hijrah calendar system from the
 * era, year-of-era and day-of-year fields.
 *
 * @param era  the Hijrah era, not null
 * @param yearOfEra  the year-of-era
 * @param dayOfYear  the day-of-year
 * @return the Hijrah local date, not null
 * @throws java.time.DateTimeException if unable to create the date
 * @throws java.lang.ClassCastException if the {@code era} is not a {@code HijrahEra}
 * @apiSince 26
 */

public java.time.chrono.HijrahDate dateYearDay(java.time.chrono.Era era, int yearOfEra, int dayOfYear) { throw new RuntimeException("Stub!"); }

/**
 * Obtains a local date in Hijrah calendar system from the
 * proleptic-year and day-of-year fields.
 *
 * @param prolepticYear  the proleptic-year
 * @param dayOfYear  the day-of-year
 * @return the Hijrah local date, not null
 * @throws java.time.DateTimeException if the value of the year is out of range,
 *  or if the day-of-year is invalid for the year
 * @apiSince 26
 */

public java.time.chrono.HijrahDate dateYearDay(int prolepticYear, int dayOfYear) { throw new RuntimeException("Stub!"); }

/**
 * Obtains a local date in the Hijrah calendar system from the epoch-day.
 *
 * @param epochDay  the epoch day
 * @return the Hijrah local date, not null
 * @throws java.time.DateTimeException if unable to create the date
 * @apiSince 26
 */

public java.time.chrono.HijrahDate dateEpochDay(long epochDay) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.time.chrono.HijrahDate dateNow() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.time.chrono.HijrahDate dateNow(java.time.ZoneId zone) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.time.chrono.HijrahDate dateNow(java.time.Clock clock) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.time.chrono.HijrahDate date(java.time.temporal.TemporalAccessor temporal) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.time.chrono.ChronoLocalDateTime<java.time.chrono.HijrahDate> localDateTime(java.time.temporal.TemporalAccessor temporal) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.time.chrono.ChronoZonedDateTime<java.time.chrono.HijrahDate> zonedDateTime(java.time.temporal.TemporalAccessor temporal) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.time.chrono.ChronoZonedDateTime<java.time.chrono.HijrahDate> zonedDateTime(java.time.Instant instant, java.time.ZoneId zone) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public boolean isLeapYear(long prolepticYear) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int prolepticYear(java.time.chrono.Era era, int yearOfEra) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.time.chrono.HijrahEra eraOf(int eraValue) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.util.List<java.time.chrono.Era> eras() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.time.temporal.ValueRange range(java.time.temporal.ChronoField field) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.time.chrono.HijrahDate resolveDate(java.util.Map<java.time.temporal.TemporalField,java.lang.Long> fieldValues, java.time.format.ResolverStyle resolverStyle) { throw new RuntimeException("Stub!"); }

/**
 * Singleton instance of the Islamic Umm Al-Qura calendar of Saudi Arabia.
 * Other Hijrah chronology variants may be available from
 * {@link java.time.chrono.Chronology#getAvailableChronologies Chronology#getAvailableChronologies}.
 * @apiSince 26
 */

public static final java.time.chrono.HijrahChronology INSTANCE;
static { INSTANCE = null; }
}

