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
 * Copyright (c) 2008-2012, Stephen Colebourne & Michael Nascimento Santos
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


package java.time.format;

import java.util.Locale;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.time.ZoneId;
import java.time.chrono.IsoChronology;
import java.text.Format;
import java.time.temporal.ChronoField;
import java.time.chrono.Chronology;
import java.util.Map;
import java.text.ParsePosition;
import java.time.Period;
import java.time.temporal.TemporalQuery;
import java.time.DateTimeException;
import java.util.Set;
import java.io.IOException;
import java.text.ParseException;
import java.time.ZoneOffset;
import java.time.temporal.IsoFields;

/**
 * Formatter for printing and parsing date-time objects.
 * <p>
 * This class provides the main application entry point for printing and parsing
 * and provides common implementations of {@code DateTimeFormatter}:
 * <ul>
 * <li>Using predefined constants, such as {@link #ISO_LOCAL_DATE}</li>
 * <li>Using pattern letters, such as {@code uuuu-MMM-dd}</li>
 * <li>Using localized styles, such as {@code long} or {@code medium}</li>
 * </ul>
 * <p>
 * More complex formatters are provided by
 * {@link java.time.format.DateTimeFormatterBuilder DateTimeFormatterBuilder}.
 *
 * <p>
 * The main date-time classes provide two methods - one for formatting,
 * {@code format(DateTimeFormatter formatter)}, and one for parsing,
 * {@code parse(CharSequence text, DateTimeFormatter formatter)}.
 * <p>For example:
 * <blockquote><pre>
 *  LocalDate date = LocalDate.now();
 *  String text = date.format(formatter);
 *  LocalDate parsedDate = LocalDate.parse(text, formatter);
 * </pre></blockquote>
 * <p>
 * In addition to the format, formatters can be created with desired Locale,
 * Chronology, ZoneId, and DecimalStyle.
 * <p>
 * The {@link #withLocale withLocale} method returns a new formatter that
 * overrides the locale. The locale affects some aspects of formatting and
 * parsing. For example, the {@link #ofLocalizedDate ofLocalizedDate} provides a
 * formatter that uses the locale specific date format.
 * <p>
 * The {@link #withChronology withChronology} method returns a new formatter
 * that overrides the chronology. If overridden, the date-time value is
 * converted to the chronology before formatting. During parsing the date-time
 * value is converted to the chronology before it is returned.
 * <p>
 * The {@link #withZone withZone} method returns a new formatter that overrides
 * the zone. If overridden, the date-time value is converted to a ZonedDateTime
 * with the requested ZoneId before formatting. During parsing the ZoneId is
 * applied before the value is returned.
 * <p>
 * The {@link #withDecimalStyle withDecimalStyle} method returns a new formatter that
 * overrides the {@link java.time.format.DecimalStyle DecimalStyle}. The DecimalStyle symbols are used for
 * formatting and parsing.
 * <p>
 * Some applications may need to use the older {@link java.text.Format Format}
 * class for formatting. The {@link #toFormat()} method returns an
 * implementation of {@code java.text.Format}.
 *
 * <h3 id="predefined">Predefined Formatters</h3>
 * <table summary="Predefined Formatters" cellpadding="2" cellspacing="3" border="0" >
 * <thead>
 * <tr class="tableSubHeadingColor">
 * <th class="colFirst" align="left">Formatter</th>
 * <th class="colFirst" align="left">Description</th>
 * <th class="colLast" align="left">Example</th>
 * </tr>
 * </thead>
 * <tbody>
 * <tr class="rowColor">
 * <td>{@link #ofLocalizedDate ofLocalizedDate(dateStyle)} </td>
 * <td> Formatter with date style from the locale </td>
 * <td> '2011-12-03'</td>
 * </tr>
 * <tr class="altColor">
 * <td> {@link #ofLocalizedTime ofLocalizedTime(timeStyle)} </td>
 * <td> Formatter with time style from the locale </td>
 * <td> '10:15:30'</td>
 * </tr>
 * <tr class="rowColor">
 * <td> {@link #ofLocalizedDateTime ofLocalizedDateTime(dateTimeStyle)} </td>
 * <td> Formatter with a style for date and time from the locale</td>
 * <td> '3 Jun 2008 11:05:30'</td>
 * </tr>
 * <tr class="altColor">
 * <td> {@link #ofLocalizedDateTime ofLocalizedDateTime(dateStyle,timeStyle)}
 * </td>
 * <td> Formatter with date and time styles from the locale </td>
 * <td> '3 Jun 2008 11:05'</td>
 * </tr>
 * <tr class="rowColor">
 * <td> {@link #BASIC_ISO_DATE}</td>
 * <td>Basic ISO date </td> <td>'20111203'</td>
 * </tr>
 * <tr class="altColor">
 * <td> {@link #ISO_LOCAL_DATE}</td>
 * <td> ISO Local Date </td>
 * <td>'2011-12-03'</td>
 * </tr>
 * <tr class="rowColor">
 * <td> {@link #ISO_OFFSET_DATE}</td>
 * <td> ISO Date with offset </td>
 * <td>'2011-12-03+01:00'</td>
 * </tr>
 * <tr class="altColor">
 * <td> {@link #ISO_DATE}</td>
 * <td> ISO Date with or without offset </td>
 * <td> '2011-12-03+01:00'; '2011-12-03'</td>
 * </tr>
 * <tr class="rowColor">
 * <td> {@link #ISO_LOCAL_TIME}</td>
 * <td> Time without offset </td>
 * <td>'10:15:30'</td>
 * </tr>
 * <tr class="altColor">
 * <td> {@link #ISO_OFFSET_TIME}</td>
 * <td> Time with offset </td>
 * <td>'10:15:30+01:00'</td>
 * </tr>
 * <tr class="rowColor">
 * <td> {@link #ISO_TIME}</td>
 * <td> Time with or without offset </td>
 * <td>'10:15:30+01:00'; '10:15:30'</td>
 * </tr>
 * <tr class="altColor">
 * <td> {@link #ISO_LOCAL_DATE_TIME}</td>
 * <td> ISO Local Date and Time </td>
 * <td>'2011-12-03T10:15:30'</td>
 * </tr>
 * <tr class="rowColor">
 * <td> {@link #ISO_OFFSET_DATE_TIME}</td>
 * <td> Date Time with Offset
 * </td><td>2011-12-03T10:15:30+01:00'</td>
 * </tr>
 * <tr class="altColor">
 * <td> {@link #ISO_ZONED_DATE_TIME}</td>
 * <td> Zoned Date Time </td>
 * <td>'2011-12-03T10:15:30+01:00[Europe/Paris]'</td>
 * </tr>
 * <tr class="rowColor">
 * <td> {@link #ISO_DATE_TIME}</td>
 * <td> Date and time with ZoneId </td>
 * <td>'2011-12-03T10:15:30+01:00[Europe/Paris]'</td>
 * </tr>
 * <tr class="altColor">
 * <td> {@link #ISO_ORDINAL_DATE}</td>
 * <td> Year and day of year </td>
 * <td>'2012-337'</td>
 * </tr>
 * <tr class="rowColor">
 * <td> {@link #ISO_WEEK_DATE}</td>
 * <td> Year and Week </td>
 * <td>2012-W48-6'</td></tr>
 * <tr class="altColor">
 * <td> {@link #ISO_INSTANT}</td>
 * <td> Date and Time of an Instant </td>
 * <td>'2011-12-03T10:15:30Z' </td>
 * </tr>
 * <tr class="rowColor">
 * <td> {@link #RFC_1123_DATE_TIME}</td>
 * <td> RFC 1123 / RFC 822 </td>
 * <td>'Tue, 3 Jun 2008 11:05:30 GMT'</td>
 * </tr>
 * </tbody>
 * </table>
 *
 * <h3 id="patterns">Patterns for Formatting and Parsing</h3>
 * Patterns are based on a simple sequence of letters and symbols.
 * A pattern is used to create a Formatter using the
 * {@link #ofPattern(java.lang.String)} and {@link #ofPattern(java.lang.String,java.util.Locale)} methods.
 * For example,
 * {@code "d MMM uuuu"} will format 2011-12-03 as '3&nbsp;Dec&nbsp;2011'.
 * A formatter created from a pattern can be used as many times as necessary,
 * it is immutable and is thread-safe.
 * <p>
 * For example:
 * <blockquote><pre>
 *  LocalDate date = LocalDate.now();
 *  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
 *  String text = date.format(formatter);
 *  LocalDate parsedDate = LocalDate.parse(text, formatter);
 * </pre></blockquote>
 * <p>
 * All letters 'A' to 'Z' and 'a' to 'z' are reserved as pattern letters. The
 * following pattern letters are defined:
 * <pre>
 *  Symbol  Meaning                     Presentation      Examples
 *  ------  -------                     ------------      -------
 *   G       era                         text              AD; Anno Domini; A
 *   u       year                        year              2004; 04
 *   y       year-of-era                 year              2004; 04
 *   D       day-of-year                 number            189
 *   M/L     month-of-year               number/text       7; 07; Jul; July; J
 *   d       day-of-month                number            10
 *
 *   Q/q     quarter-of-year             number/text       3; 03; Q3; 3rd quarter
 *   Y       week-based-year             year              1996; 96
 *   w       week-of-week-based-year     number            27
 *   W       week-of-month               number            4
 *   E       day-of-week                 text              Tue; Tuesday; T
 *   e/c     localized day-of-week       number/text       2; 02; Tue; Tuesday; T
 *   F       week-of-month               number            3
 *
 *   a       am-pm-of-day                text              PM
 *   h       clock-hour-of-am-pm (1-12)  number            12
 *   K       hour-of-am-pm (0-11)        number            0
 *   k       clock-hour-of-am-pm (1-24)  number            0
 *
 *   H       hour-of-day (0-23)          number            0
 *   m       minute-of-hour              number            30
 *   s       second-of-minute            number            55
 *   S       fraction-of-second          fraction          978
 *   A       milli-of-day                number            1234
 *   n       nano-of-second              number            987654321
 *   N       nano-of-day                 number            1234000000
 *
 *   V       time-zone ID                zone-id           America/Los_Angeles; Z; -08:30
 *   z       time-zone name              zone-name         Pacific Standard Time; PST
 *   O       localized zone-offset       offset-O          GMT+8; GMT+08:00; UTC-08:00;
 *   X       zone-offset 'Z' for zero    offset-X          Z; -08; -0830; -08:30; -083015; -08:30:15;
 *   x       zone-offset                 offset-x          +0000; -08; -0830; -08:30; -083015; -08:30:15;
 *   Z       zone-offset                 offset-Z          +0000; -0800; -08:00;
 *
 *   p       pad next                    pad modifier      1
 *
 *   '       escape for text             delimiter
 *   ''      single quote                literal           '
 *   [       optional section start
 *   ]       optional section end
 *   #       reserved for future use
 *   {       reserved for future use
 *   }       reserved for future use
 * </pre>
 * <p>
 * The count of pattern letters determines the format.
 * <p>
 * <b>Text</b>: The text style is determined based on the number of pattern
 * letters used. Less than 4 pattern letters will use the
 * {@link java.time.format.TextStyle#SHORT TextStyle#SHORT}. Exactly 4 pattern letters will use the
 * {@link java.time.format.TextStyle#FULL TextStyle#FULL}. Exactly 5 pattern letters will use the
 * {@link java.time.format.TextStyle#NARROW TextStyle#NARROW}.
 * Pattern letters 'L', 'c', and 'q' specify the stand-alone form of the text styles.
 * <p>
 * <b>Number</b>: If the count of letters is one, then the value is output using
 * the minimum number of digits and without padding. Otherwise, the count of digits
 * is used as the width of the output field, with the value zero-padded as necessary.
 * The following pattern letters have constraints on the count of letters.
 * Only one letter of 'c' and 'F' can be specified.
 * Up to two letters of 'd', 'H', 'h', 'K', 'k', 'm', and 's' can be specified.
 * Up to three letters of 'D' can be specified.
 * <p>
 * <b>Number/Text</b>: If the count of pattern letters is 3 or greater, use the
 * Text rules above. Otherwise use the Number rules above.
 * <p>
 * <b>Fraction</b>: Outputs the nano-of-second field as a fraction-of-second.
 * The nano-of-second value has nine digits, thus the count of pattern letters
 * is from 1 to 9. If it is less than 9, then the nano-of-second value is
 * truncated, with only the most significant digits being output.
 * <p>
 * <b>Year</b>: The count of letters determines the minimum field width below
 * which padding is used. If the count of letters is two, then a
 * {@link java.time.format.DateTimeFormatterBuilder#appendValueReduced DateTimeFormatterBuilder#appendValueReduced} two digit form is
 * used. For printing, this outputs the rightmost two digits. For parsing, this
 * will parse using the base value of 2000, resulting in a year within the range
 * 2000 to 2099 inclusive. If the count of letters is less than four (but not
 * two), then the sign is only output for negative years as per
 * {@link java.time.format.SignStyle#NORMAL SignStyle#NORMAL}. Otherwise, the sign is output if the pad width is
 * exceeded, as per {@link java.time.format.SignStyle#EXCEEDS_PAD SignStyle#EXCEEDS_PAD}.
 * <p>
 * <b>ZoneId</b>: This outputs the time-zone ID, such as 'Europe/Paris'. If the
 * count of letters is two, then the time-zone ID is output. Any other count of
 * letters throws {@code IllegalArgumentException}.
 * <p>
 * <b>Zone names</b>: This outputs the display name of the time-zone ID. If the
 * count of letters is one, two or three, then the short name is output. If the
 * count of letters is four, then the full name is output. Five or more letters
 * throws {@code IllegalArgumentException}.
 * <p>
 * <b>Offset X and x</b>: This formats the offset based on the number of pattern
 * letters. One letter outputs just the hour, such as '+01', unless the minute
 * is non-zero in which case the minute is also output, such as '+0130'. Two
 * letters outputs the hour and minute, without a colon, such as '+0130'. Three
 * letters outputs the hour and minute, with a colon, such as '+01:30'. Four
 * letters outputs the hour and minute and optional second, without a colon,
 * such as '+013015'. Five letters outputs the hour and minute and optional
 * second, with a colon, such as '+01:30:15'. Six or more letters throws
 * {@code IllegalArgumentException}. Pattern letter 'X' (upper case) will output
 * 'Z' when the offset to be output would be zero, whereas pattern letter 'x'
 * (lower case) will output '+00', '+0000', or '+00:00'.
 * <p>
 * <b>Offset O</b>: This formats the localized offset based on the number of
 * pattern letters. One letter outputs the {@linkplain java.time.format.TextStyle#SHORT TextStyle#SHORT}
 * form of the localized offset, which is localized offset text, such as 'GMT',
 * with hour without leading zero, optional 2-digit minute and second if
 * non-zero, and colon, for example 'GMT+8'. Four letters outputs the
 * {@linkplain java.time.format.TextStyle#FULL TextStyle#FULL} form, which is localized offset text,
 * such as 'GMT, with 2-digit hour and minute field, optional second field
 * if non-zero, and colon, for example 'GMT+08:00'. Any other count of letters
 * throws {@code IllegalArgumentException}.
 * <p>
 * <b>Offset Z</b>: This formats the offset based on the number of pattern
 * letters. One, two or three letters outputs the hour and minute, without a
 * colon, such as '+0130'. The output will be '+0000' when the offset is zero.
 * Four letters outputs the {@linkplain java.time.format.TextStyle#FULL TextStyle#FULL} form of localized
 * offset, equivalent to four letters of Offset-O. The output will be the
 * corresponding localized offset text if the offset is zero. Five
 * letters outputs the hour, minute, with optional second if non-zero, with
 * colon. It outputs 'Z' if the offset is zero.
 * Six or more letters throws {@code IllegalArgumentException}.
 * <p>
 * <b>Optional section</b>: The optional section markers work exactly like
 * calling {@link java.time.format.DateTimeFormatterBuilder#optionalStart() DateTimeFormatterBuilder#optionalStart()} and
 * {@link java.time.format.DateTimeFormatterBuilder#optionalEnd() DateTimeFormatterBuilder#optionalEnd()}.
 * <p>
 * <b>Pad modifier</b>: Modifies the pattern that immediately follows to be
 * padded with spaces. The pad width is determined by the number of pattern
 * letters. This is the same as calling
 * {@link java.time.format.DateTimeFormatterBuilder#padNext(int) DateTimeFormatterBuilder#padNext(int)}.
 * <p>
 * For example, 'ppH' outputs the hour-of-day padded on the left with spaces to
 * a width of 2.
 * <p>
 * Any unrecognized letter is an error. Any non-letter character, other than
 * '[', ']', '{', '}', '#' and the single quote will be output directly.
 * Despite this, it is recommended to use single quotes around all characters
 * that you want to output directly to ensure that future changes do not break
 * your application.
 *
 * <h3 id="resolving">Resolving</h3>
 * Parsing is implemented as a two-phase operation.
 * First, the text is parsed using the layout defined by the formatter, producing
 * a {@code Map} of field to value, a {@code ZoneId} and a {@code Chronology}.
 * Second, the parsed data is <em>resolved</em>, by validating, combining and
 * simplifying the various fields into more useful ones.
 * <p>
 * Five parsing methods are supplied by this class.
 * Four of these perform both the parse and resolve phases.
 * The fifth method, {@link #parseUnresolved(java.lang.CharSequence,java.text.ParsePosition)},
 * only performs the first phase, leaving the result unresolved.
 * As such, it is essentially a low-level operation.
 * <p>
 * The resolve phase is controlled by two parameters, set on this class.
 * <p>
 * The {@link java.time.format.ResolverStyle ResolverStyle} is an enum that offers three different approaches,
 * strict, smart and lenient. The smart option is the default.
 * It can be set using {@link #withResolverStyle(java.time.format.ResolverStyle)}.
 * <p>
 * The {@link #withResolverFields(java.time.temporal.TemporalField...)} parameter allows the
 * set of fields that will be resolved to be filtered before resolving starts.
 * For example, if the formatter has parsed a year, month, day-of-month
 * and day-of-year, then there are two approaches to resolve a date:
 * (year + month + day-of-month) and (year + day-of-year).
 * The resolver fields allows one of the two approaches to be selected.
 * If no resolver fields are set then both approaches must result in the same date.
 * <p>
 * Resolving separate fields to form a complete date and time is a complex
 * process with behaviour distributed across a number of classes.
 * It follows these steps:
 * <ol>
 * <li>The chronology is determined.
 * The chronology of the result is either the chronology that was parsed,
 * or if no chronology was parsed, it is the chronology set on this class,
 * or if that is null, it is {@code IsoChronology}.
 * <li>The {@code ChronoField} date fields are resolved.
 * This is achieved using {@link java.time.chrono.Chronology#resolveDate(java.util.Map,java.time.format.ResolverStyle) Chronology#resolveDate(Map, ResolverStyle)}.
 * Documentation about field resolution is located in the implementation
 * of {@code Chronology}.
 * <li>The {@code ChronoField} time fields are resolved.
 * This is documented on {@link java.time.temporal.ChronoField ChronoField} and is the same for all chronologies.
 * <li>Any fields that are not {@code ChronoField} are processed.
 * This is achieved using {@link java.time.temporal.TemporalField#resolve(java.util.Map,java.time.temporal.TemporalAccessor,java.time.format.ResolverStyle) TemporalField#resolve(Map, TemporalAccessor, ResolverStyle)}.
 * Documentation about field resolution is located in the implementation
 * of {@code TemporalField}.
 * <li>The {@code ChronoField} date and time fields are re-resolved.
 * This allows fields in step four to produce {@code ChronoField} values
 * and have them be processed into dates and times.
 * <li>A {@code LocalTime} is formed if there is at least an hour-of-day available.
 * This involves providing default values for minute, second and fraction of second.
 * <li>Any remaining unresolved fields are cross-checked against any
 * date and/or time that was resolved. Thus, an earlier stage would resolve
 * (year + month + day-of-month) to a date, and this stage would check that
 * day-of-week was valid for the date.
 * <li>If an {@linkplain #parsedExcessDays() excess number of days}
 * was parsed then it is added to the date if a date is available.
 * </ol>
 *
 * @implSpec
 * This class is immutable and thread-safe.
 *
 * @since 1.8
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class DateTimeFormatter {

DateTimeFormatter() { throw new RuntimeException("Stub!"); }

/**
 * Creates a formatter using the specified pattern.
 * <p>
 * This method will create a formatter based on a simple
 * <a href="#patterns">pattern of letters and symbols</a>
 * as described in the class documentation.
 * For example, {@code d MMM uuuu} will format 2011-12-03 as '3 Dec 2011'.
 * <p>
 * The formatter will use the {@link java.util.Locale#getDefault(java.util.Locale.Category) Locale#getDefault(Locale.Category)}.
 * This can be changed using {@link java.time.format.DateTimeFormatter#withLocale(java.util.Locale) DateTimeFormatter#withLocale(Locale)} on the returned formatter
 * Alternatively use the {@link #ofPattern(java.lang.String,java.util.Locale)} variant of this method.
 * <p>
 * The returned formatter has no override chronology or zone.
 * It uses {@link java.time.format.ResolverStyle#SMART ResolverStyle#SMART} resolver style.
 *
 * @param pattern  the pattern to use, not null
 * @return the formatter based on the pattern, not null
 * @throws java.lang.IllegalArgumentException if the pattern is invalid
 * @see java.time.format.DateTimeFormatterBuilder#appendPattern(String)
 * @apiSince 26
 */

public static java.time.format.DateTimeFormatter ofPattern(java.lang.String pattern) { throw new RuntimeException("Stub!"); }

/**
 * Creates a formatter using the specified pattern and locale.
 * <p>
 * This method will create a formatter based on a simple
 * <a href="#patterns">pattern of letters and symbols</a>
 * as described in the class documentation.
 * For example, {@code d MMM uuuu} will format 2011-12-03 as '3 Dec 2011'.
 * <p>
 * The formatter will use the specified locale.
 * This can be changed using {@link java.time.format.DateTimeFormatter#withLocale(java.util.Locale) DateTimeFormatter#withLocale(Locale)} on the returned formatter
 * <p>
 * The returned formatter has no override chronology or zone.
 * It uses {@link java.time.format.ResolverStyle#SMART ResolverStyle#SMART} resolver style.
 *
 * @param pattern  the pattern to use, not null
 * @param locale  the locale to use, not null
 * @return the formatter based on the pattern, not null
 * @throws java.lang.IllegalArgumentException if the pattern is invalid
 * @see java.time.format.DateTimeFormatterBuilder#appendPattern(String)
 * @apiSince 26
 */

public static java.time.format.DateTimeFormatter ofPattern(java.lang.String pattern, java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Returns a locale specific date format for the ISO chronology.
 * <p>
 * This returns a formatter that will format or parse a date.
 * The exact format pattern used varies by locale.
 * <p>
 * The locale is determined from the formatter. The formatter returned directly by
 * this method will use the {@link java.util.Locale#getDefault(java.util.Locale.Category) Locale#getDefault(Locale.Category)}.
 * The locale can be controlled using {@link java.time.format.DateTimeFormatter#withLocale(java.util.Locale) DateTimeFormatter#withLocale(Locale)}
 * on the result of this method.
 * <p>
 * Note that the localized pattern is looked up lazily.
 * This {@code DateTimeFormatter} holds the style required and the locale,
 * looking up the pattern required on demand.
 * <p>
 * The returned formatter has a chronology of ISO set to ensure dates in
 * other calendar systems are correctly converted.
 * It has no override zone and uses the {@link java.time.format.ResolverStyle#SMART ResolverStyle#SMART} resolver style.
 *
 * @param dateStyle  the formatter style to obtain, not null
 * @return the date formatter, not null
 * @apiSince 26
 */

public static java.time.format.DateTimeFormatter ofLocalizedDate(java.time.format.FormatStyle dateStyle) { throw new RuntimeException("Stub!"); }

/**
 * Returns a locale specific time format for the ISO chronology.
 * <p>
 * This returns a formatter that will format or parse a time.
 * The exact format pattern used varies by locale.
 * <p>
 * The locale is determined from the formatter. The formatter returned directly by
 * this method will use the {@link java.util.Locale#getDefault(java.util.Locale.Category) Locale#getDefault(Locale.Category)}.
 * The locale can be controlled using {@link java.time.format.DateTimeFormatter#withLocale(java.util.Locale) DateTimeFormatter#withLocale(Locale)}
 * on the result of this method.
 * <p>
 * Note that the localized pattern is looked up lazily.
 * This {@code DateTimeFormatter} holds the style required and the locale,
 * looking up the pattern required on demand.
 * <p>
 * The returned formatter has a chronology of ISO set to ensure dates in
 * other calendar systems are correctly converted.
 * It has no override zone and uses the {@link java.time.format.ResolverStyle#SMART ResolverStyle#SMART} resolver style.
 *
 * @param timeStyle  the formatter style to obtain, not null
 * @return the time formatter, not null
 * @apiSince 26
 */

public static java.time.format.DateTimeFormatter ofLocalizedTime(java.time.format.FormatStyle timeStyle) { throw new RuntimeException("Stub!"); }

/**
 * Returns a locale specific date-time formatter for the ISO chronology.
 * <p>
 * This returns a formatter that will format or parse a date-time.
 * The exact format pattern used varies by locale.
 * <p>
 * The locale is determined from the formatter. The formatter returned directly by
 * this method will use the {@link java.util.Locale#getDefault(java.util.Locale.Category) Locale#getDefault(Locale.Category)}.
 * The locale can be controlled using {@link java.time.format.DateTimeFormatter#withLocale(java.util.Locale) DateTimeFormatter#withLocale(Locale)}
 * on the result of this method.
 * <p>
 * Note that the localized pattern is looked up lazily.
 * This {@code DateTimeFormatter} holds the style required and the locale,
 * looking up the pattern required on demand.
 * <p>
 * The returned formatter has a chronology of ISO set to ensure dates in
 * other calendar systems are correctly converted.
 * It has no override zone and uses the {@link java.time.format.ResolverStyle#SMART ResolverStyle#SMART} resolver style.
 *
 * @param dateTimeStyle  the formatter style to obtain, not null
 * @return the date-time formatter, not null
 * @apiSince 26
 */

public static java.time.format.DateTimeFormatter ofLocalizedDateTime(java.time.format.FormatStyle dateTimeStyle) { throw new RuntimeException("Stub!"); }

/**
 * Returns a locale specific date and time format for the ISO chronology.
 * <p>
 * This returns a formatter that will format or parse a date-time.
 * The exact format pattern used varies by locale.
 * <p>
 * The locale is determined from the formatter. The formatter returned directly by
 * this method will use the {@link java.util.Locale#getDefault() Locale#getDefault()}.
 * The locale can be controlled using {@link java.time.format.DateTimeFormatter#withLocale(java.util.Locale) DateTimeFormatter#withLocale(Locale)}
 * on the result of this method.
 * <p>
 * Note that the localized pattern is looked up lazily.
 * This {@code DateTimeFormatter} holds the style required and the locale,
 * looking up the pattern required on demand.
 * <p>
 * The returned formatter has a chronology of ISO set to ensure dates in
 * other calendar systems are correctly converted.
 * It has no override zone and uses the {@link java.time.format.ResolverStyle#SMART ResolverStyle#SMART} resolver style.
 *
 * @param dateStyle  the date formatter style to obtain, not null
 * @param timeStyle  the time formatter style to obtain, not null
 * @return the date, time or date-time formatter, not null
 * @apiSince 26
 */

public static java.time.format.DateTimeFormatter ofLocalizedDateTime(java.time.format.FormatStyle dateStyle, java.time.format.FormatStyle timeStyle) { throw new RuntimeException("Stub!"); }

/**
 * A query that provides access to the excess days that were parsed.
 * <p>
 * This returns a singleton {@linkplain java.time.temporal.TemporalQuery TemporalQuery} that provides
 * access to additional information from the parse. The query always returns
 * a non-null period, with a zero period returned instead of null.
 * <p>
 * There are two situations where this query may return a non-zero period.
 * <ul>
 * <li>If the {@code ResolverStyle} is {@code LENIENT} and a time is parsed
 *  without a date, then the complete result of the parse consists of a
 *  {@code LocalTime} and an excess {@code Period} in days.
 *
 * <li>If the {@code ResolverStyle} is {@code SMART} and a time is parsed
 *  without a date where the time is 24:00:00, then the complete result of
 *  the parse consists of a {@code LocalTime} of 00:00:00 and an excess
 *  {@code Period} of one day.
 * </ul>
 * <p>
 * In both cases, if a complete {@code ChronoLocalDateTime} or {@code Instant}
 * is parsed, then the excess days are added to the date part.
 * As a result, this query will return a zero period.
 * <p>
 * The {@code SMART} behaviour handles the common "end of day" 24:00 value.
 * Processing in {@code LENIENT} mode also produces the same result:
 * <pre>
 *  Text to parse        Parsed object                         Excess days
 *  "2012-12-03T00:00"   LocalDateTime.of(2012, 12, 3, 0, 0)   ZERO
 *  "2012-12-03T24:00"   LocalDateTime.of(2012, 12, 4, 0, 0)   ZERO
 *  "00:00"              LocalTime.of(0, 0)                    ZERO
 *  "24:00"              LocalTime.of(0, 0)                    Period.ofDays(1)
 * </pre>
 * The query can be used as follows:
 * <pre>
 *  TemporalAccessor parsed = formatter.parse(str);
 *  LocalTime time = parsed.query(LocalTime::from);
 *  Period extraDays = parsed.query(DateTimeFormatter.parsedExcessDays());
 * </pre>
 * @return a query that provides access to the excess days that were parsed
 * @apiSince 26
 */

public static java.time.temporal.TemporalQuery<java.time.Period> parsedExcessDays() { throw new RuntimeException("Stub!"); }

/**
 * A query that provides access to whether a leap-second was parsed.
 * <p>
 * This returns a singleton {@linkplain java.time.temporal.TemporalQuery TemporalQuery} that provides
 * access to additional information from the parse. The query always returns
 * a non-null boolean, true if parsing saw a leap-second, false if not.
 * <p>
 * Instant parsing handles the special "leap second" time of '23:59:60'.
 * Leap seconds occur at '23:59:60' in the UTC time-zone, but at other
 * local times in different time-zones. To avoid this potential ambiguity,
 * the handling of leap-seconds is limited to
 * {@link java.time.format.DateTimeFormatterBuilder#appendInstant() DateTimeFormatterBuilder#appendInstant()}, as that method
 * always parses the instant with the UTC zone offset.
 * <p>
 * If the time '23:59:60' is received, then a simple conversion is applied,
 * replacing the second-of-minute of 60 with 59. This query can be used
 * on the parse result to determine if the leap-second adjustment was made.
 * The query will return {@code true} if it did adjust to remove the
 * leap-second, and {@code false} if not. Note that applying a leap-second
 * smoothing mechanism, such as UTC-SLS, is the responsibility of the
 * application, as follows:
 * <pre>
 *  TemporalAccessor parsed = formatter.parse(str);
 *  Instant instant = parsed.query(Instant::from);
 *  if (parsed.query(DateTimeFormatter.parsedLeapSecond())) {
 *    // validate leap-second is correct and apply correct smoothing
 *  }
 * </pre>
 * @return a query that provides access to whether a leap-second was parsed
 * @apiSince 26
 */

public static java.time.temporal.TemporalQuery<java.lang.Boolean> parsedLeapSecond() { throw new RuntimeException("Stub!"); }

/**
 * Gets the locale to be used during formatting.
 * <p>
 * This is used to lookup any part of the formatter needing specific
 * localization, such as the text or localized pattern.
 *
 * @return the locale of this formatter, not null
 * @apiSince 26
 */

public java.util.Locale getLocale() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this formatter with a new locale.
 * <p>
 * This is used to lookup any part of the formatter needing specific
 * localization, such as the text or localized pattern.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param locale  the new locale, not null
 * @return a formatter based on this formatter with the requested locale, not null
 * @apiSince 26
 */

public java.time.format.DateTimeFormatter withLocale(java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Gets the DecimalStyle to be used during formatting.
 *
 * @return the locale of this formatter, not null
 * @apiSince 26
 */

public java.time.format.DecimalStyle getDecimalStyle() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this formatter with a new DecimalStyle.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param decimalStyle  the new DecimalStyle, not null
 * @return a formatter based on this formatter with the requested DecimalStyle, not null
 * @apiSince 26
 */

public java.time.format.DateTimeFormatter withDecimalStyle(java.time.format.DecimalStyle decimalStyle) { throw new RuntimeException("Stub!"); }

/**
 * Gets the overriding chronology to be used during formatting.
 * <p>
 * This returns the override chronology, used to convert dates.
 * By default, a formatter has no override chronology, returning null.
 * See {@link #withChronology(java.time.chrono.Chronology)} for more details on overriding.
 *
 * @return the override chronology of this formatter, null if no override
 * @apiSince 26
 */

public java.time.chrono.Chronology getChronology() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this formatter with a new override chronology.
 * <p>
 * This returns a formatter with similar state to this formatter but
 * with the override chronology set.
 * By default, a formatter has no override chronology, returning null.
 * <p>
 * If an override is added, then any date that is formatted or parsed will be affected.
 * <p>
 * When formatting, if the temporal object contains a date, then it will
 * be converted to a date in the override chronology.
 * Whether the temporal contains a date is determined by querying the
 * {@link java.time.temporal.ChronoField#EPOCH_DAY ChronoField#EPOCH_DAY} field.
 * Any time or zone will be retained unaltered unless overridden.
 * <p>
 * If the temporal object does not contain a date, but does contain one
 * or more {@code ChronoField} date fields, then a {@code DateTimeException}
 * is thrown. In all other cases, the override chronology is added to the temporal,
 * replacing any previous chronology, but without changing the date/time.
 * <p>
 * When parsing, there are two distinct cases to consider.
 * If a chronology has been parsed directly from the text, perhaps because
 * {@link java.time.format.DateTimeFormatterBuilder#appendChronologyId() DateTimeFormatterBuilder#appendChronologyId()} was used, then
 * this override chronology has no effect.
 * If no zone has been parsed, then this override chronology will be used
 * to interpret the {@code ChronoField} values into a date according to the
 * date resolving rules of the chronology.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param chrono  the new chronology, null if no override
 * @return a formatter based on this formatter with the requested override chronology, not null
 * @apiSince 26
 */

public java.time.format.DateTimeFormatter withChronology(java.time.chrono.Chronology chrono) { throw new RuntimeException("Stub!"); }

/**
 * Gets the overriding zone to be used during formatting.
 * <p>
 * This returns the override zone, used to convert instants.
 * By default, a formatter has no override zone, returning null.
 * See {@link #withZone(java.time.ZoneId)} for more details on overriding.
 *
 * @return the override zone of this formatter, null if no override
 * @apiSince 26
 */

public java.time.ZoneId getZone() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this formatter with a new override zone.
 * <p>
 * This returns a formatter with similar state to this formatter but
 * with the override zone set.
 * By default, a formatter has no override zone, returning null.
 * <p>
 * If an override is added, then any instant that is formatted or parsed will be affected.
 * <p>
 * When formatting, if the temporal object contains an instant, then it will
 * be converted to a zoned date-time using the override zone.
 * Whether the temporal is an instant is determined by querying the
 * {@link java.time.temporal.ChronoField#INSTANT_SECONDS ChronoField#INSTANT_SECONDS} field.
 * If the input has a chronology then it will be retained unless overridden.
 * If the input does not have a chronology, such as {@code Instant}, then
 * the ISO chronology will be used.
 * <p>
 * If the temporal object does not contain an instant, but does contain
 * an offset then an additional check is made. If the normalized override
 * zone is an offset that differs from the offset of the temporal, then
 * a {@code DateTimeException} is thrown. In all other cases, the override
 * zone is added to the temporal, replacing any previous zone, but without
 * changing the date/time.
 * <p>
 * When parsing, there are two distinct cases to consider.
 * If a zone has been parsed directly from the text, perhaps because
 * {@link java.time.format.DateTimeFormatterBuilder#appendZoneId() DateTimeFormatterBuilder#appendZoneId()} was used, then
 * this override zone has no effect.
 * If no zone has been parsed, then this override zone will be included in
 * the result of the parse where it can be used to build instants and date-times.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param zone  the new override zone, null if no override
 * @return a formatter based on this formatter with the requested override zone, not null
 * @apiSince 26
 */

public java.time.format.DateTimeFormatter withZone(java.time.ZoneId zone) { throw new RuntimeException("Stub!"); }

/**
 * Gets the resolver style to use during parsing.
 * <p>
 * This returns the resolver style, used during the second phase of parsing
 * when fields are resolved into dates and times.
 * By default, a formatter has the {@link java.time.format.ResolverStyle#SMART ResolverStyle#SMART} resolver style.
 * See {@link #withResolverStyle(java.time.format.ResolverStyle)} for more details.
 *
 * @return the resolver style of this formatter, not null
 * @apiSince 26
 */

public java.time.format.ResolverStyle getResolverStyle() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this formatter with a new resolver style.
 * <p>
 * This returns a formatter with similar state to this formatter but
 * with the resolver style set. By default, a formatter has the
 * {@link java.time.format.ResolverStyle#SMART ResolverStyle#SMART} resolver style.
 * <p>
 * Changing the resolver style only has an effect during parsing.
 * Parsing a text string occurs in two phases.
 * Phase 1 is a basic text parse according to the fields added to the builder.
 * Phase 2 resolves the parsed field-value pairs into date and/or time objects.
 * The resolver style is used to control how phase 2, resolving, happens.
 * See {@code ResolverStyle} for more information on the options available.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param resolverStyle  the new resolver style, not null
 * @return a formatter based on this formatter with the requested resolver style, not null
 * @apiSince 26
 */

public java.time.format.DateTimeFormatter withResolverStyle(java.time.format.ResolverStyle resolverStyle) { throw new RuntimeException("Stub!"); }

/**
 * Gets the resolver fields to use during parsing.
 * <p>
 * This returns the resolver fields, used during the second phase of parsing
 * when fields are resolved into dates and times.
 * By default, a formatter has no resolver fields, and thus returns null.
 * See {@link #withResolverFields(java.util.Set)} for more details.
 *
 * @return the immutable set of resolver fields of this formatter, null if no fields
 * @apiSince 26
 */

public java.util.Set<java.time.temporal.TemporalField> getResolverFields() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this formatter with a new set of resolver fields.
 * <p>
 * This returns a formatter with similar state to this formatter but with
 * the resolver fields set. By default, a formatter has no resolver fields.
 * <p>
 * Changing the resolver fields only has an effect during parsing.
 * Parsing a text string occurs in two phases.
 * Phase 1 is a basic text parse according to the fields added to the builder.
 * Phase 2 resolves the parsed field-value pairs into date and/or time objects.
 * The resolver fields are used to filter the field-value pairs between phase 1 and 2.
 * <p>
 * This can be used to select between two or more ways that a date or time might
 * be resolved. For example, if the formatter consists of year, month, day-of-month
 * and day-of-year, then there are two ways to resolve a date.
 * Calling this method with the arguments {@link java.time.temporal.ChronoField#YEAR ChronoField#YEAR} and
 * {@link java.time.temporal.ChronoField#DAY_OF_YEAR ChronoField#DAY_OF_YEAR} will ensure that the date is
 * resolved using the year and day-of-year, effectively meaning that the month
 * and day-of-month are ignored during the resolving phase.
 * <p>
 * In a similar manner, this method can be used to ignore secondary fields that
 * would otherwise be cross-checked. For example, if the formatter consists of year,
 * month, day-of-month and day-of-week, then there is only one way to resolve a
 * date, but the parsed value for day-of-week will be cross-checked against the
 * resolved date. Calling this method with the arguments {@link java.time.temporal.ChronoField#YEAR ChronoField#YEAR},
 * {@link java.time.temporal.ChronoField#MONTH_OF_YEAR ChronoField#MONTH_OF_YEAR} and
 * {@link java.time.temporal.ChronoField#DAY_OF_MONTH ChronoField#DAY_OF_MONTH} will ensure that the date is
 * resolved correctly, but without any cross-check for the day-of-week.
 * <p>
 * In implementation terms, this method behaves as follows. The result of the
 * parsing phase can be considered to be a map of field to value. The behavior
 * of this method is to cause that map to be filtered between phase 1 and 2,
 * removing all fields other than those specified as arguments to this method.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param resolverFields  the new set of resolver fields, null if no fields
 * @return a formatter based on this formatter with the requested resolver style, not null
 * @apiSince 26
 */

public java.time.format.DateTimeFormatter withResolverFields(java.time.temporal.TemporalField... resolverFields) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this formatter with a new set of resolver fields.
 * <p>
 * This returns a formatter with similar state to this formatter but with
 * the resolver fields set. By default, a formatter has no resolver fields.
 * <p>
 * Changing the resolver fields only has an effect during parsing.
 * Parsing a text string occurs in two phases.
 * Phase 1 is a basic text parse according to the fields added to the builder.
 * Phase 2 resolves the parsed field-value pairs into date and/or time objects.
 * The resolver fields are used to filter the field-value pairs between phase 1 and 2.
 * <p>
 * This can be used to select between two or more ways that a date or time might
 * be resolved. For example, if the formatter consists of year, month, day-of-month
 * and day-of-year, then there are two ways to resolve a date.
 * Calling this method with the arguments {@link java.time.temporal.ChronoField#YEAR ChronoField#YEAR} and
 * {@link java.time.temporal.ChronoField#DAY_OF_YEAR ChronoField#DAY_OF_YEAR} will ensure that the date is
 * resolved using the year and day-of-year, effectively meaning that the month
 * and day-of-month are ignored during the resolving phase.
 * <p>
 * In a similar manner, this method can be used to ignore secondary fields that
 * would otherwise be cross-checked. For example, if the formatter consists of year,
 * month, day-of-month and day-of-week, then there is only one way to resolve a
 * date, but the parsed value for day-of-week will be cross-checked against the
 * resolved date. Calling this method with the arguments {@link java.time.temporal.ChronoField#YEAR ChronoField#YEAR},
 * {@link java.time.temporal.ChronoField#MONTH_OF_YEAR ChronoField#MONTH_OF_YEAR} and
 * {@link java.time.temporal.ChronoField#DAY_OF_MONTH ChronoField#DAY_OF_MONTH} will ensure that the date is
 * resolved correctly, but without any cross-check for the day-of-week.
 * <p>
 * In implementation terms, this method behaves as follows. The result of the
 * parsing phase can be considered to be a map of field to value. The behavior
 * of this method is to cause that map to be filtered between phase 1 and 2,
 * removing all fields other than those specified as arguments to this method.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param resolverFields  the new set of resolver fields, null if no fields
 * @return a formatter based on this formatter with the requested resolver style, not null
 * @apiSince 26
 */

public java.time.format.DateTimeFormatter withResolverFields(java.util.Set<java.time.temporal.TemporalField> resolverFields) { throw new RuntimeException("Stub!"); }

/**
 * Formats a date-time object using this formatter.
 * <p>
 * This formats the date-time to a String using the rules of the formatter.
 *
 * @param temporal  the temporal object to format, not null
 * @return the formatted string, not null
 * @throws java.time.DateTimeException if an error occurs during formatting
 * @apiSince 26
 */

public java.lang.String format(java.time.temporal.TemporalAccessor temporal) { throw new RuntimeException("Stub!"); }

/**
 * Formats a date-time object to an {@code Appendable} using this formatter.
 * <p>
 * This outputs the formatted date-time to the specified destination.
 * {@link java.lang.Appendable Appendable} is a general purpose interface that is implemented by all
 * key character output classes including {@code StringBuffer}, {@code StringBuilder},
 * {@code PrintStream} and {@code Writer}.
 * <p>
 * Although {@code Appendable} methods throw an {@code IOException}, this method does not.
 * Instead, any {@code IOException} is wrapped in a runtime exception.
 *
 * @param temporal  the temporal object to format, not null
 * @param appendable  the appendable to format to, not null
 * @throws java.time.DateTimeException if an error occurs during formatting
 * @apiSince 26
 */

public void formatTo(java.time.temporal.TemporalAccessor temporal, java.lang.Appendable appendable) { throw new RuntimeException("Stub!"); }

/**
 * Fully parses the text producing a temporal object.
 * <p>
 * This parses the entire text producing a temporal object.
 * It is typically more useful to use {@link #parse(java.lang.CharSequence,java.time.temporal.TemporalQuery)}.
 * The result of this method is {@code TemporalAccessor} which has been resolved,
 * applying basic validation checks to help ensure a valid date-time.
 * <p>
 * If the parse completes without reading the entire length of the text,
 * or a problem occurs during parsing or merging, then an exception is thrown.
 *
 * @param text  the text to parse, not null
 * @return the parsed temporal object, not null
 * @throws java.time.format.DateTimeParseException if unable to parse the requested result
 * @apiSince 26
 */

public java.time.temporal.TemporalAccessor parse(java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }

/**
 * Parses the text using this formatter, providing control over the text position.
 * <p>
 * This parses the text without requiring the parse to start from the beginning
 * of the string or finish at the end.
 * The result of this method is {@code TemporalAccessor} which has been resolved,
 * applying basic validation checks to help ensure a valid date-time.
 * <p>
 * The text will be parsed from the specified start {@code ParsePosition}.
 * The entire length of the text does not have to be parsed, the {@code ParsePosition}
 * will be updated with the index at the end of parsing.
 * <p>
 * The operation of this method is slightly different to similar methods using
 * {@code ParsePosition} on {@code java.text.Format}. That class will return
 * errors using the error index on the {@code ParsePosition}. By contrast, this
 * method will throw a {@link java.time.format.DateTimeParseException DateTimeParseException} if an error occurs, with
 * the exception containing the error index.
 * This change in behavior is necessary due to the increased complexity of
 * parsing and resolving dates/times in this API.
 * <p>
 * If the formatter parses the same field more than once with different values,
 * the result will be an error.
 *
 * @param text  the text to parse, not null
 * @param position  the position to parse from, updated with length parsed
 *  and the index of any error, not null
 * @return the parsed temporal object, not null
 * @throws java.time.format.DateTimeParseException if unable to parse the requested result
 * @throws java.lang.IndexOutOfBoundsException if the position is invalid
 * @apiSince 26
 */

public java.time.temporal.TemporalAccessor parse(java.lang.CharSequence text, java.text.ParsePosition position) { throw new RuntimeException("Stub!"); }

/**
 * Fully parses the text producing an object of the specified type.
 * <p>
 * Most applications should use this method for parsing.
 * It parses the entire text to produce the required date-time.
 * The query is typically a method reference to a {@code from(TemporalAccessor)} method.
 * For example:
 * <pre>
 *  LocalDateTime dt = parser.parse(str, LocalDateTime::from);
 * </pre>
 * If the parse completes without reading the entire length of the text,
 * or a problem occurs during parsing or merging, then an exception is thrown.
 *
 * @param <T> the type of the parsed date-time
 * @param text  the text to parse, not null
 * @param query  the query defining the type to parse to, not null
 * @return the parsed date-time, not null
 * @throws java.time.format.DateTimeParseException if unable to parse the requested result
 * @apiSince 26
 */

public <T> T parse(java.lang.CharSequence text, java.time.temporal.TemporalQuery<T> query) { throw new RuntimeException("Stub!"); }

/**
 * Fully parses the text producing an object of one of the specified types.
 * <p>
 * This parse method is convenient for use when the parser can handle optional elements.
 * For example, a pattern of 'uuuu-MM-dd HH.mm[ VV]' can be fully parsed to a {@code ZonedDateTime},
 * or partially parsed to a {@code LocalDateTime}.
 * The queries must be specified in order, starting from the best matching full-parse option
 * and ending with the worst matching minimal parse option.
 * The query is typically a method reference to a {@code from(TemporalAccessor)} method.
 * <p>
 * The result is associated with the first type that successfully parses.
 * Normally, applications will use {@code instanceof} to check the result.
 * For example:
 * <pre>
 *  TemporalAccessor dt = parser.parseBest(str, ZonedDateTime::from, LocalDateTime::from);
 *  if (dt instanceof ZonedDateTime) {
 *   ...
 *  } else {
 *   ...
 *  }
 * </pre>
 * If the parse completes without reading the entire length of the text,
 * or a problem occurs during parsing or merging, then an exception is thrown.
 *
 * @param text  the text to parse, not null
 * @param queries  the queries defining the types to attempt to parse to,
 *  must implement {@code TemporalAccessor}, not null
 * @return the parsed date-time, not null
 * @throws java.lang.IllegalArgumentException if less than 2 types are specified
 * @throws java.time.format.DateTimeParseException if unable to parse the requested result
 * @apiSince 26
 */

public java.time.temporal.TemporalAccessor parseBest(java.lang.CharSequence text, java.time.temporal.TemporalQuery<?>... queries) { throw new RuntimeException("Stub!"); }

/**
 * Parses the text using this formatter, without resolving the result, intended
 * for advanced use cases.
 * <p>
 * Parsing is implemented as a two-phase operation.
 * First, the text is parsed using the layout defined by the formatter, producing
 * a {@code Map} of field to value, a {@code ZoneId} and a {@code Chronology}.
 * Second, the parsed data is <em>resolved</em>, by validating, combining and
 * simplifying the various fields into more useful ones.
 * This method performs the parsing stage but not the resolving stage.
 * <p>
 * The result of this method is {@code TemporalAccessor} which represents the
 * data as seen in the input. Values are not validated, thus parsing a date string
 * of '2012-00-65' would result in a temporal with three fields - year of '2012',
 * month of '0' and day-of-month of '65'.
 * <p>
 * The text will be parsed from the specified start {@code ParsePosition}.
 * The entire length of the text does not have to be parsed, the {@code ParsePosition}
 * will be updated with the index at the end of parsing.
 * <p>
 * Errors are returned using the error index field of the {@code ParsePosition}
 * instead of {@code DateTimeParseException}.
 * The returned error index will be set to an index indicative of the error.
 * Callers must check for errors before using the result.
 * <p>
 * If the formatter parses the same field more than once with different values,
 * the result will be an error.
 * <p>
 * This method is intended for advanced use cases that need access to the
 * internal state during parsing. Typical application code should use
 * {@link #parse(java.lang.CharSequence,java.time.temporal.TemporalQuery)} or the parse method on the target type.
 *
 * @param text  the text to parse, not null
 * @param position  the position to parse from, updated with length parsed
 *  and the index of any error, not null
 * @return the parsed text, null if the parse results in an error
 * @throws java.time.DateTimeException if some problem occurs during parsing
 * @throws java.lang.IndexOutOfBoundsException if the position is invalid
 * @apiSince 26
 */

public java.time.temporal.TemporalAccessor parseUnresolved(java.lang.CharSequence text, java.text.ParsePosition position) { throw new RuntimeException("Stub!"); }

/**
 * Returns this formatter as a {@code java.text.Format} instance.
 * <p>
 * The returned {@link java.text.Format Format} instance will format any {@link java.time.temporal.TemporalAccessor TemporalAccessor}
 * and parses to a resolved {@link java.time.temporal.TemporalAccessor TemporalAccessor}.
 * <p>
 * Exceptions will follow the definitions of {@code Format}, see those methods
 * for details about {@code IllegalArgumentException} during formatting and
 * {@code ParseException} or null during parsing.
 * The format does not support attributing of the returned format string.
 *
 * @return this formatter as a classic format instance, not null
 * @apiSince 26
 */

public java.text.Format toFormat() { throw new RuntimeException("Stub!"); }

/**
 * Returns this formatter as a {@code java.text.Format} instance that will
 * parse using the specified query.
 * <p>
 * The returned {@link java.text.Format Format} instance will format any {@link java.time.temporal.TemporalAccessor TemporalAccessor}
 * and parses to the type specified.
 * The type must be one that is supported by {@link #parse}.
 * <p>
 * Exceptions will follow the definitions of {@code Format}, see those methods
 * for details about {@code IllegalArgumentException} during formatting and
 * {@code ParseException} or null during parsing.
 * The format does not support attributing of the returned format string.
 *
 * @param parseQuery  the query defining the type to parse to, not null
 * @return this formatter as a classic format instance, not null
 * @apiSince 26
 */

public java.text.Format toFormat(java.time.temporal.TemporalQuery<?> parseQuery) { throw new RuntimeException("Stub!"); }

/**
 * Returns a description of the underlying formatters.
 *
 * @return a description of this formatter, not null
 * @apiSince 26
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * The ISO date formatter that formats or parses a date without an
 * offset, such as '20111203'.
 * <p>
 * This returns an immutable formatter capable of formatting and parsing
 * the ISO-8601 basic local date format.
 * The format consists of:
 * <ul>
 * <li>Four digits for the {@link java.time.temporal.ChronoField#YEAR ChronoField#YEAR}.
 *  Only years in the range 0000 to 9999 are supported.
 * <li>Two digits for the {@link java.time.temporal.ChronoField#MONTH_OF_YEAR ChronoField#MONTH_OF_YEAR}.
 *  This is pre-padded by zero to ensure two digits.
 * <li>Two digits for the {@link java.time.temporal.ChronoField#DAY_OF_MONTH ChronoField#DAY_OF_MONTH}.
 *  This is pre-padded by zero to ensure two digits.
 * <li>If the offset is not available to format or parse then the format is complete.
 * <li>The {@link java.time.ZoneOffset#getId() ZoneOffset#getId()} without colons. If the offset has
 *  seconds then they will be handled even though this is not part of the ISO-8601 standard.
 *  Parsing is case insensitive.
 * </ul>
 * <p>
 * As this formatter has an optional element, it may be necessary to parse using
 * {@link java.time.format.DateTimeFormatter#parseBest DateTimeFormatter#parseBest}.
 * <p>
 * The returned formatter has a chronology of ISO set to ensure dates in
 * other calendar systems are correctly converted.
 * It has no override zone and uses the {@link java.time.format.ResolverStyle#STRICT ResolverStyle#STRICT} resolver style.
 * @apiSince 26
 */

public static final java.time.format.DateTimeFormatter BASIC_ISO_DATE;
static { BASIC_ISO_DATE = null; }

/**
 * The ISO date formatter that formats or parses a date with the
 * offset if available, such as '2011-12-03' or '2011-12-03+01:00'.
 * <p>
 * This returns an immutable formatter capable of formatting and parsing
 * the ISO-8601 extended date format.
 * The format consists of:
 * <ul>
 * <li>The {@link #ISO_LOCAL_DATE}
 * <li>If the offset is not available then the format is complete.
 * <li>The {@link java.time.ZoneOffset#getId() ZoneOffset#getId()}. If the offset has seconds then
 *  they will be handled even though this is not part of the ISO-8601 standard.
 *  Parsing is case insensitive.
 * </ul>
 * <p>
 * As this formatter has an optional element, it may be necessary to parse using
 * {@link java.time.format.DateTimeFormatter#parseBest DateTimeFormatter#parseBest}.
 * <p>
 * The returned formatter has a chronology of ISO set to ensure dates in
 * other calendar systems are correctly converted.
 * It has no override zone and uses the {@link java.time.format.ResolverStyle#STRICT ResolverStyle#STRICT} resolver style.
 * @apiSince 26
 */

public static final java.time.format.DateTimeFormatter ISO_DATE;
static { ISO_DATE = null; }

/**
 * The ISO-like date-time formatter that formats or parses a date-time with
 * the offset and zone if available, such as '2011-12-03T10:15:30',
 * '2011-12-03T10:15:30+01:00' or '2011-12-03T10:15:30+01:00[Europe/Paris]'.
 * <p>
 * This returns an immutable formatter capable of formatting and parsing
 * the ISO-8601 extended local or offset date-time format, as well as the
 * extended non-ISO form specifying the time-zone.
 * The format consists of:
 * <ul>
 * <li>The {@link #ISO_LOCAL_DATE_TIME}
 * <li>If the offset is not available to format or parse then the format is complete.
 * <li>The {@link java.time.ZoneOffset#getId() ZoneOffset#getId()}. If the offset has seconds then
 *  they will be handled even though this is not part of the ISO-8601 standard.
 * <li>If the zone ID is not available or is a {@code ZoneOffset} then the format is complete.
 * <li>An open square bracket '['.
 * <li>The {@link java.time.ZoneId#getId() ZoneId#getId()}. This is not part of the ISO-8601 standard.
 *  Parsing is case sensitive.
 * <li>A close square bracket ']'.
 * </ul>
 * <p>
 * As this formatter has an optional element, it may be necessary to parse using
 * {@link java.time.format.DateTimeFormatter#parseBest DateTimeFormatter#parseBest}.
 * <p>
 * The returned formatter has a chronology of ISO set to ensure dates in
 * other calendar systems are correctly converted.
 * It has no override zone and uses the {@link java.time.format.ResolverStyle#STRICT ResolverStyle#STRICT} resolver style.
 * @apiSince 26
 */

public static final java.time.format.DateTimeFormatter ISO_DATE_TIME;
static { ISO_DATE_TIME = null; }

/**
 * The ISO instant formatter that formats or parses an instant in UTC,
 * such as '2011-12-03T10:15:30Z'.
 * <p>
 * This returns an immutable formatter capable of formatting and parsing
 * the ISO-8601 instant format.
 * When formatting, the second-of-minute is always output.
 * The nano-of-second outputs zero, three, six or nine digits digits as necessary.
 * When parsing, time to at least the seconds field is required.
 * Fractional seconds from zero to nine are parsed.
 * The localized decimal style is not used.
 * <p>
 * This is a special case formatter intended to allow a human readable form
 * of an {@link java.time.Instant}. The {@code Instant} class is designed to
 * only represent a point in time and internally stores a value in nanoseconds
 * from a fixed epoch of 1970-01-01Z. As such, an {@code Instant} cannot be
 * formatted as a date or time without providing some form of time-zone.
 * This formatter allows the {@code Instant} to be formatted, by providing
 * a suitable conversion using {@code ZoneOffset.UTC}.
 * <p>
 * The format consists of:
 * <ul>
 * <li>The {@link #ISO_OFFSET_DATE_TIME} where the instant is converted from
 *  {@link java.time.temporal.ChronoField#INSTANT_SECONDS ChronoField#INSTANT_SECONDS} and {@link java.time.temporal.ChronoField#NANO_OF_SECOND ChronoField#NANO_OF_SECOND}
 *  using the {@code UTC} offset. Parsing is case insensitive.
 * </ul>
 * <p>
 * The returned formatter has no override chronology or zone.
 * It uses the {@link java.time.format.ResolverStyle#STRICT ResolverStyle#STRICT} resolver style.
 * @apiSince 26
 */

public static final java.time.format.DateTimeFormatter ISO_INSTANT;
static { ISO_INSTANT = null; }

/**
 * The ISO date formatter that formats or parses a date without an
 * offset, such as '2011-12-03'.
 * <p>
 * This returns an immutable formatter capable of formatting and parsing
 * the ISO-8601 extended local date format.
 * The format consists of:
 * <ul>
 * <li>Four digits or more for the {@link java.time.temporal.ChronoField#YEAR ChronoField#YEAR}.
 * Years in the range 0000 to 9999 will be pre-padded by zero to ensure four digits.
 * Years outside that range will have a prefixed positive or negative symbol.
 * <li>A dash
 * <li>Two digits for the {@link java.time.temporal.ChronoField#MONTH_OF_YEAR ChronoField#MONTH_OF_YEAR}.
 *  This is pre-padded by zero to ensure two digits.
 * <li>A dash
 * <li>Two digits for the {@link java.time.temporal.ChronoField#DAY_OF_MONTH ChronoField#DAY_OF_MONTH}.
 *  This is pre-padded by zero to ensure two digits.
 * </ul>
 * <p>
 * The returned formatter has a chronology of ISO set to ensure dates in
 * other calendar systems are correctly converted.
 * It has no override zone and uses the {@link java.time.format.ResolverStyle#STRICT ResolverStyle#STRICT} resolver style.
 * @apiSince 26
 */

public static final java.time.format.DateTimeFormatter ISO_LOCAL_DATE;
static { ISO_LOCAL_DATE = null; }

/**
 * The ISO date-time formatter that formats or parses a date-time without
 * an offset, such as '2011-12-03T10:15:30'.
 * <p>
 * This returns an immutable formatter capable of formatting and parsing
 * the ISO-8601 extended offset date-time format.
 * The format consists of:
 * <ul>
 * <li>The {@link #ISO_LOCAL_DATE}
 * <li>The letter 'T'. Parsing is case insensitive.
 * <li>The {@link #ISO_LOCAL_TIME}
 * </ul>
 * <p>
 * The returned formatter has a chronology of ISO set to ensure dates in
 * other calendar systems are correctly converted.
 * It has no override zone and uses the {@link java.time.format.ResolverStyle#STRICT ResolverStyle#STRICT} resolver style.
 * @apiSince 26
 */

public static final java.time.format.DateTimeFormatter ISO_LOCAL_DATE_TIME;
static { ISO_LOCAL_DATE_TIME = null; }

/**
 * The ISO time formatter that formats or parses a time without an
 * offset, such as '10:15' or '10:15:30'.
 * <p>
 * This returns an immutable formatter capable of formatting and parsing
 * the ISO-8601 extended local time format.
 * The format consists of:
 * <ul>
 * <li>Two digits for the {@link java.time.temporal.ChronoField#HOUR_OF_DAY ChronoField#HOUR_OF_DAY}.
 *  This is pre-padded by zero to ensure two digits.
 * <li>A colon
 * <li>Two digits for the {@link java.time.temporal.ChronoField#MINUTE_OF_HOUR ChronoField#MINUTE_OF_HOUR}.
 *  This is pre-padded by zero to ensure two digits.
 * <li>If the second-of-minute is not available then the format is complete.
 * <li>A colon
 * <li>Two digits for the {@link java.time.temporal.ChronoField#SECOND_OF_MINUTE ChronoField#SECOND_OF_MINUTE}.
 *  This is pre-padded by zero to ensure two digits.
 * <li>If the nano-of-second is zero or not available then the format is complete.
 * <li>A decimal point
 * <li>One to nine digits for the {@link java.time.temporal.ChronoField#NANO_OF_SECOND ChronoField#NANO_OF_SECOND}.
 *  As many digits will be output as required.
 * </ul>
 * <p>
 * The returned formatter has no override chronology or zone.
 * It uses the {@link java.time.format.ResolverStyle#STRICT ResolverStyle#STRICT} resolver style.
 * @apiSince 26
 */

public static final java.time.format.DateTimeFormatter ISO_LOCAL_TIME;
static { ISO_LOCAL_TIME = null; }

/**
 * The ISO date formatter that formats or parses a date with an
 * offset, such as '2011-12-03+01:00'.
 * <p>
 * This returns an immutable formatter capable of formatting and parsing
 * the ISO-8601 extended offset date format.
 * The format consists of:
 * <ul>
 * <li>The {@link #ISO_LOCAL_DATE}
 * <li>The {@link java.time.ZoneOffset#getId() ZoneOffset#getId()}. If the offset has seconds then
 *  they will be handled even though this is not part of the ISO-8601 standard.
 *  Parsing is case insensitive.
 * </ul>
 * <p>
 * The returned formatter has a chronology of ISO set to ensure dates in
 * other calendar systems are correctly converted.
 * It has no override zone and uses the {@link java.time.format.ResolverStyle#STRICT ResolverStyle#STRICT} resolver style.
 * @apiSince 26
 */

public static final java.time.format.DateTimeFormatter ISO_OFFSET_DATE;
static { ISO_OFFSET_DATE = null; }

/**
 * The ISO date-time formatter that formats or parses a date-time with an
 * offset, such as '2011-12-03T10:15:30+01:00'.
 * <p>
 * This returns an immutable formatter capable of formatting and parsing
 * the ISO-8601 extended offset date-time format.
 * The format consists of:
 * <ul>
 * <li>The {@link #ISO_LOCAL_DATE_TIME}
 * <li>The {@link java.time.ZoneOffset#getId() ZoneOffset#getId()}. If the offset has seconds then
 *  they will be handled even though this is not part of the ISO-8601 standard.
 *  Parsing is case insensitive.
 * </ul>
 * <p>
 * The returned formatter has a chronology of ISO set to ensure dates in
 * other calendar systems are correctly converted.
 * It has no override zone and uses the {@link java.time.format.ResolverStyle#STRICT ResolverStyle#STRICT} resolver style.
 * @apiSince 26
 */

public static final java.time.format.DateTimeFormatter ISO_OFFSET_DATE_TIME;
static { ISO_OFFSET_DATE_TIME = null; }

/**
 * The ISO time formatter that formats or parses a time with an
 * offset, such as '10:15+01:00' or '10:15:30+01:00'.
 * <p>
 * This returns an immutable formatter capable of formatting and parsing
 * the ISO-8601 extended offset time format.
 * The format consists of:
 * <ul>
 * <li>The {@link #ISO_LOCAL_TIME}
 * <li>The {@link java.time.ZoneOffset#getId() ZoneOffset#getId()}. If the offset has seconds then
 *  they will be handled even though this is not part of the ISO-8601 standard.
 *  Parsing is case insensitive.
 * </ul>
 * <p>
 * The returned formatter has no override chronology or zone.
 * It uses the {@link java.time.format.ResolverStyle#STRICT ResolverStyle#STRICT} resolver style.
 * @apiSince 26
 */

public static final java.time.format.DateTimeFormatter ISO_OFFSET_TIME;
static { ISO_OFFSET_TIME = null; }

/**
 * The ISO date formatter that formats or parses the ordinal date
 * without an offset, such as '2012-337'.
 * <p>
 * This returns an immutable formatter capable of formatting and parsing
 * the ISO-8601 extended ordinal date format.
 * The format consists of:
 * <ul>
 * <li>Four digits or more for the {@link java.time.temporal.ChronoField#YEAR ChronoField#YEAR}.
 * Years in the range 0000 to 9999 will be pre-padded by zero to ensure four digits.
 * Years outside that range will have a prefixed positive or negative symbol.
 * <li>A dash
 * <li>Three digits for the {@link java.time.temporal.ChronoField#DAY_OF_YEAR ChronoField#DAY_OF_YEAR}.
 *  This is pre-padded by zero to ensure three digits.
 * <li>If the offset is not available to format or parse then the format is complete.
 * <li>The {@link java.time.ZoneOffset#getId() ZoneOffset#getId()}. If the offset has seconds then
 *  they will be handled even though this is not part of the ISO-8601 standard.
 *  Parsing is case insensitive.
 * </ul>
 * <p>
 * As this formatter has an optional element, it may be necessary to parse using
 * {@link java.time.format.DateTimeFormatter#parseBest DateTimeFormatter#parseBest}.
 * <p>
 * The returned formatter has a chronology of ISO set to ensure dates in
 * other calendar systems are correctly converted.
 * It has no override zone and uses the {@link java.time.format.ResolverStyle#STRICT ResolverStyle#STRICT} resolver style.
 * @apiSince 26
 */

public static final java.time.format.DateTimeFormatter ISO_ORDINAL_DATE;
static { ISO_ORDINAL_DATE = null; }

/**
 * The ISO time formatter that formats or parses a time, with the
 * offset if available, such as '10:15', '10:15:30' or '10:15:30+01:00'.
 * <p>
 * This returns an immutable formatter capable of formatting and parsing
 * the ISO-8601 extended offset time format.
 * The format consists of:
 * <ul>
 * <li>The {@link #ISO_LOCAL_TIME}
 * <li>If the offset is not available then the format is complete.
 * <li>The {@link java.time.ZoneOffset#getId() ZoneOffset#getId()}. If the offset has seconds then
 *  they will be handled even though this is not part of the ISO-8601 standard.
 *  Parsing is case insensitive.
 * </ul>
 * <p>
 * As this formatter has an optional element, it may be necessary to parse using
 * {@link java.time.format.DateTimeFormatter#parseBest DateTimeFormatter#parseBest}.
 * <p>
 * The returned formatter has no override chronology or zone.
 * It uses the {@link java.time.format.ResolverStyle#STRICT ResolverStyle#STRICT} resolver style.
 * @apiSince 26
 */

public static final java.time.format.DateTimeFormatter ISO_TIME;
static { ISO_TIME = null; }

/**
 * The ISO date formatter that formats or parses the week-based date
 * without an offset, such as '2012-W48-6'.
 * <p>
 * This returns an immutable formatter capable of formatting and parsing
 * the ISO-8601 extended week-based date format.
 * The format consists of:
 * <ul>
 * <li>Four digits or more for the {@link java.time.temporal.IsoFields#WEEK_BASED_YEAR IsoFields#WEEK_BASED_YEAR}.
 * Years in the range 0000 to 9999 will be pre-padded by zero to ensure four digits.
 * Years outside that range will have a prefixed positive or negative symbol.
 * <li>A dash
 * <li>The letter 'W'. Parsing is case insensitive.
 * <li>Two digits for the {@link java.time.temporal.IsoFields#WEEK_OF_WEEK_BASED_YEAR IsoFields#WEEK_OF_WEEK_BASED_YEAR}.
 *  This is pre-padded by zero to ensure three digits.
 * <li>A dash
 * <li>One digit for the {@link java.time.temporal.ChronoField#DAY_OF_WEEK ChronoField#DAY_OF_WEEK}.
 *  The value run from Monday (1) to Sunday (7).
 * <li>If the offset is not available to format or parse then the format is complete.
 * <li>The {@link java.time.ZoneOffset#getId() ZoneOffset#getId()}. If the offset has seconds then
 *  they will be handled even though this is not part of the ISO-8601 standard.
 *  Parsing is case insensitive.
 * </ul>
 * <p>
 * As this formatter has an optional element, it may be necessary to parse using
 * {@link java.time.format.DateTimeFormatter#parseBest DateTimeFormatter#parseBest}.
 * <p>
 * The returned formatter has a chronology of ISO set to ensure dates in
 * other calendar systems are correctly converted.
 * It has no override zone and uses the {@link java.time.format.ResolverStyle#STRICT ResolverStyle#STRICT} resolver style.
 * @apiSince 26
 */

public static final java.time.format.DateTimeFormatter ISO_WEEK_DATE;
static { ISO_WEEK_DATE = null; }

/**
 * The ISO-like date-time formatter that formats or parses a date-time with
 * offset and zone, such as '2011-12-03T10:15:30+01:00[Europe/Paris]'.
 * <p>
 * This returns an immutable formatter capable of formatting and parsing
 * a format that extends the ISO-8601 extended offset date-time format
 * to add the time-zone.
 * The section in square brackets is not part of the ISO-8601 standard.
 * The format consists of:
 * <ul>
 * <li>The {@link #ISO_OFFSET_DATE_TIME}
 * <li>If the zone ID is not available or is a {@code ZoneOffset} then the format is complete.
 * <li>An open square bracket '['.
 * <li>The {@link java.time.ZoneId#getId() ZoneId#getId()}. This is not part of the ISO-8601 standard.
 *  Parsing is case sensitive.
 * <li>A close square bracket ']'.
 * </ul>
 * <p>
 * The returned formatter has a chronology of ISO set to ensure dates in
 * other calendar systems are correctly converted.
 * It has no override zone and uses the {@link java.time.format.ResolverStyle#STRICT ResolverStyle#STRICT} resolver style.
 * @apiSince 26
 */

public static final java.time.format.DateTimeFormatter ISO_ZONED_DATE_TIME;
static { ISO_ZONED_DATE_TIME = null; }

/**
 * The RFC-1123 date-time formatter, such as 'Tue, 3 Jun 2008 11:05:30 GMT'.
 * <p>
 * This returns an immutable formatter capable of formatting and parsing
 * most of the RFC-1123 format.
 * RFC-1123 updates RFC-822 changing the year from two digits to four.
 * This implementation requires a four digit year.
 * This implementation also does not handle North American or military zone
 * names, only 'GMT' and offset amounts.
 * <p>
 * The format consists of:
 * <ul>
 * <li>If the day-of-week is not available to format or parse then jump to day-of-month.
 * <li>Three letter {@link java.time.temporal.ChronoField#DAY_OF_WEEK ChronoField#DAY_OF_WEEK} in English.
 * <li>A comma
 * <li>A space
 * <li>One or two digits for the {@link java.time.temporal.ChronoField#DAY_OF_MONTH ChronoField#DAY_OF_MONTH}.
 * <li>A space
 * <li>Three letter {@link java.time.temporal.ChronoField#MONTH_OF_YEAR ChronoField#MONTH_OF_YEAR} in English.
 * <li>A space
 * <li>Four digits for the {@link java.time.temporal.ChronoField#YEAR ChronoField#YEAR}.
 *  Only years in the range 0000 to 9999 are supported.
 * <li>A space
 * <li>Two digits for the {@link java.time.temporal.ChronoField#HOUR_OF_DAY ChronoField#HOUR_OF_DAY}.
 *  This is pre-padded by zero to ensure two digits.
 * <li>A colon
 * <li>Two digits for the {@link java.time.temporal.ChronoField#MINUTE_OF_HOUR ChronoField#MINUTE_OF_HOUR}.
 *  This is pre-padded by zero to ensure two digits.
 * <li>If the second-of-minute is not available then jump to the next space.
 * <li>A colon
 * <li>Two digits for the {@link java.time.temporal.ChronoField#SECOND_OF_MINUTE ChronoField#SECOND_OF_MINUTE}.
 *  This is pre-padded by zero to ensure two digits.
 * <li>A space
 * <li>The {@link java.time.ZoneOffset#getId() ZoneOffset#getId()} without colons or seconds.
 *  An offset of zero uses "GMT". North American zone names and military zone names are not handled.
 * </ul>
 * <p>
 * Parsing is case insensitive.
 * <p>
 * The returned formatter has a chronology of ISO set to ensure dates in
 * other calendar systems are correctly converted.
 * It has no override zone and uses the {@link java.time.format.ResolverStyle#SMART ResolverStyle#SMART} resolver style.
 * @apiSince 26
 */

public static final java.time.format.DateTimeFormatter RFC_1123_DATE_TIME;
static { RFC_1123_DATE_TIME = null; }
}

