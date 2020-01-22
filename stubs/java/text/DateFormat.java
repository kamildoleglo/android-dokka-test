/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1996, 2013, Oracle and/or its affiliates. All rights reserved.
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
 * (C) Copyright Taligent, Inc. 1996 - All Rights Reserved
 * (C) Copyright IBM Corp. 1996 - All Rights Reserved
 *
 *   The original version of this source code and documentation is copyrighted
 * and owned by Taligent, Inc., a wholly-owned subsidiary of IBM. These
 * materials are provided under terms of a License Agreement between Taligent
 * and Sun. This technology is protected by multiple US and International
 * patents. This notice and attribution to Taligent may not be removed.
 *   Taligent is a registered trademark of Taligent, Inc.
 *
 */



package java.text;

import java.util.Locale;
import java.util.TimeZone;
import java.util.Calendar;
import java.util.Date;
import java.io.InvalidObjectException;

/**
 * {@code DateFormat} is an abstract class for date/time formatting subclasses which
 * formats and parses dates or time in a language-independent manner.
 * The date/time formatting subclass, such as {@link java.text.SimpleDateFormat SimpleDateFormat}, allows for
 * formatting (i.e., date &rarr; text), parsing (text &rarr; date), and
 * normalization.  The date is represented as a <code>Date</code> object or
 * as the milliseconds since January 1, 1970, 00:00:00 GMT.
 *
 * <p>{@code DateFormat} provides many class methods for obtaining default date/time
 * formatters based on the default or a given locale and a number of formatting
 * styles. The formatting styles include {@link #FULL}, {@link #LONG}, {@link #MEDIUM}, and {@link #SHORT}. More
 * detail and examples of using these styles are provided in the method
 * descriptions.
 *
 * <p>{@code DateFormat} helps you to format and parse dates for any locale.
 * Your code can be completely independent of the locale conventions for
 * months, days of the week, or even the calendar format: lunar vs. solar.
 *
 * <p>To format a date for the current Locale, use one of the
 * static factory methods:
 * <blockquote>
 * <pre>{@code
 * myString = DateFormat.getDateInstance().format(myDate);
 * }</pre>
 * </blockquote>
 * <p>If you are formatting multiple dates, it is
 * more efficient to get the format and use it multiple times so that
 * the system doesn't have to fetch the information about the local
 * language and country conventions multiple times.
 * <blockquote>
 * <pre>{@code
 * DateFormat df = DateFormat.getDateInstance();
 * for (int i = 0; i < myDate.length; ++i) {
 *     output.println(df.format(myDate[i]) + "; ");
 * }
 * }</pre>
 * </blockquote>
 * <p>To format a date for a different Locale, specify it in the
 * call to {@link #getDateInstance(int,java.util.Locale) getDateInstance()}.
 * <blockquote>
 * <pre>{@code
 * DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.FRANCE);
 * }</pre>
 * </blockquote>
 * <p>You can use a DateFormat to parse also.
 * <blockquote>
 * <pre>{@code
 * myDate = df.parse(myString);
 * }</pre>
 * </blockquote>
 * <p>Use {@code getDateInstance} to get the normal date format for that country.
 * There are other static factory methods available.
 * Use {@code getTimeInstance} to get the time format for that country.
 * Use {@code getDateTimeInstance} to get a date and time format. You can pass in
 * different options to these factory methods to control the length of the
 * result; from {@link #SHORT} to {@link #MEDIUM} to {@link #LONG} to {@link #FULL}. The exact result depends
 * on the locale, but generally:
 * <ul><li>{@link #SHORT} is completely numeric, such as {@code 12.13.52} or {@code 3:30pm}
 * <li>{@link #MEDIUM} is longer, such as {@code Jan 12, 1952}
 * <li>{@link #LONG} is longer, such as {@code January 12, 1952} or {@code 3:30:32pm}
 * <li>{@link #FULL} is pretty completely specified, such as
 * {@code Tuesday, April 12, 1952 AD or 3:30:42pm PST}.
 * </ul>
 *
 * <p>You can also set the time zone on the format if you wish.
 * If you want even more control over the format or parsing,
 * (or want to give your users more control),
 * you can try casting the {@code DateFormat} you get from the factory methods
 * to a {@link java.text.SimpleDateFormat SimpleDateFormat}. This will work for the majority
 * of countries; just remember to put it in a {@code try} block in case you
 * encounter an unusual one.
 *
 * <p>You can also use forms of the parse and format methods with
 * {@link java.text.ParsePosition ParsePosition} and {@link java.text.FieldPosition FieldPosition} to
 * allow you to
 * <ul><li>progressively parse through pieces of a string.
 * <li>align any particular field, or find out where it is for selection
 * on the screen.
 * </ul>
 *
 * <h3><a name="synchronization">Synchronization</a></h3>
 *
 * <p>
 * Date formats are not synchronized.
 * It is recommended to create separate format instances for each thread.
 * If multiple threads access a format concurrently, it must be synchronized
 * externally.
 *
 * @see          java.text.Format
 * @see          java.text.NumberFormat
 * @see          java.text.SimpleDateFormat
 * @see          java.util.Calendar
 * @see          java.util.GregorianCalendar
 * @see          java.util.TimeZone
 * @author       Mark Davis, Chen-Lieh Huang, Alan Liu
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class DateFormat extends java.text.Format {

/**
 * Create a new date format.
 * @apiSince 1
 */

protected DateFormat() { throw new RuntimeException("Stub!"); }

/**
 * Overrides Format.
 * Formats a time object into a time string. Examples of time objects
 * are a time value expressed in milliseconds and a Date object.
 * @param obj must be a Number or a Date.
 * @param toAppendTo the string buffer for the returning time string.
 * @return the string buffer passed in as toAppendTo, with formatted text appended.
 * @param fieldPosition keeps track of the position of the field
 * within the returned string.
 * On input: an alignment field,
 * if desired. On output: the offsets of the alignment field. For
 * example, given a time text "1996.07.10 AD at 15:08:56 PDT",
 * if the given fieldPosition is DateFormat.YEAR_FIELD, the
 * begin index and end index of fieldPosition will be set to
 * 0 and 4, respectively.
 * Notice that if the same time field appears
 * more than once in a pattern, the fieldPosition will be set for the first
 * occurrence of that time field. For instance, formatting a Date to
 * the time string "1 PM PDT (Pacific Daylight Time)" using the pattern
 * "h a z (zzzz)" and the alignment field DateFormat.TIMEZONE_FIELD,
 * the begin index and end index of fieldPosition will be set to
 * 5 and 8, respectively, for the first occurrence of the timezone
 * pattern character 'z'.
 * @see java.text.Format
 * @apiSince 1
 */

@androidx.annotation.NonNull
public final java.lang.StringBuffer format(@androidx.annotation.NonNull java.lang.Object obj, @androidx.annotation.NonNull java.lang.StringBuffer toAppendTo, @androidx.annotation.NonNull java.text.FieldPosition fieldPosition) { throw new RuntimeException("Stub!"); }

/**
 * Formats a Date into a date/time string.
 * @param date a Date to be formatted into a date/time string.
 * @param toAppendTo the string buffer for the returning date/time string.
 * @param fieldPosition keeps track of the position of the field
 * within the returned string.
 * On input: an alignment field,
 * if desired. On output: the offsets of the alignment field. For
 * example, given a time text "1996.07.10 AD at 15:08:56 PDT",
 * if the given fieldPosition is DateFormat.YEAR_FIELD, the
 * begin index and end index of fieldPosition will be set to
 * 0 and 4, respectively.
 * Notice that if the same time field appears
 * more than once in a pattern, the fieldPosition will be set for the first
 * occurrence of that time field. For instance, formatting a Date to
 * the time string "1 PM PDT (Pacific Daylight Time)" using the pattern
 * "h a z (zzzz)" and the alignment field DateFormat.TIMEZONE_FIELD,
 * the begin index and end index of fieldPosition will be set to
 * 5 and 8, respectively, for the first occurrence of the timezone
 * pattern character 'z'.
 * @return the string buffer passed in as toAppendTo, with formatted text appended.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public abstract java.lang.StringBuffer format(@androidx.annotation.NonNull java.util.Date date, @androidx.annotation.NonNull java.lang.StringBuffer toAppendTo, @androidx.annotation.NonNull java.text.FieldPosition fieldPosition);

/**
 * Formats a Date into a date/time string.
 * @param date the time value to be formatted into a time string.
 * @return the formatted time string.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public final java.lang.String format(@androidx.annotation.NonNull java.util.Date date) { throw new RuntimeException("Stub!"); }

/**
 * Parses text from the beginning of the given string to produce a date.
 * The method may not use the entire text of the given string.
 * <p>
 * See the {@link #parse(java.lang.String,java.text.ParsePosition)} method for more information
 * on date parsing.
 *
 * @param source A <code>String</code> whose beginning should be parsed.
 * @return A <code>Date</code> parsed from the string.
 * @exception java.text.ParseException if the beginning of the specified string
 *            cannot be parsed.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.util.Date parse(@androidx.annotation.NonNull java.lang.String source) throws java.text.ParseException { throw new RuntimeException("Stub!"); }

/**
 * Parse a date/time string according to the given parse position.  For
 * example, a time text {@code "07/10/96 4:5 PM, PDT"} will be parsed into a {@code Date}
 * that is equivalent to {@code Date(837039900000L)}.
 *
 * <p> By default, parsing is lenient: If the input is not in the form used
 * by this object's format method but can still be parsed as a date, then
 * the parse succeeds.  Clients may insist on strict adherence to the
 * format by calling {@link #setLenient(boolean) setLenient(false)}.
 *
 * <p>This parsing operation uses the {@link #calendar} to produce
 * a {@code Date}. As a result, the {@code calendar}'s date-time
 * fields and the {@code TimeZone} value may have been
 * overwritten, depending on subclass implementations. Any {@code
 * TimeZone} value that has previously been set by a call to
 * {@link #setTimeZone(java.util.TimeZone) setTimeZone} may need
 * to be restored for further operations.
 *
 * @param source  The date/time string to be parsed
 *
 * @param pos   On input, the position at which to start parsing; on
 *              output, the position at which parsing terminated, or the
 *              start position if the parse failed.
 *
 * @return      A {@code Date}, or {@code null} if the input could not be parsed
 * @apiSince 1
 */

@androidx.annotation.Nullable
public abstract java.util.Date parse(@androidx.annotation.NonNull java.lang.String source, @androidx.annotation.NonNull java.text.ParsePosition pos);

/**
 * Parses text from a string to produce a <code>Date</code>.
 * <p>
 * The method attempts to parse text starting at the index given by
 * <code>pos</code>.
 * If parsing succeeds, then the index of <code>pos</code> is updated
 * to the index after the last character used (parsing does not necessarily
 * use all characters up to the end of the string), and the parsed
 * date is returned. The updated <code>pos</code> can be used to
 * indicate the starting point for the next call to this method.
 * If an error occurs, then the index of <code>pos</code> is not
 * changed, the error index of <code>pos</code> is set to the index of
 * the character where the error occurred, and null is returned.
 * <p>
 * See the {@link #parse(java.lang.String,java.text.ParsePosition)} method for more information
 * on date parsing.
 *
 * @param source A <code>String</code>, part of which should be parsed.
 * @param pos A <code>ParsePosition</code> object with index and error
 *            index information as described above.
 * @return A <code>Date</code> parsed from the string. In case of
 *         error, returns null.
 * @exception java.lang.NullPointerException if <code>pos</code> is null.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.lang.Object parseObject(@androidx.annotation.NonNull java.lang.String source, @androidx.annotation.NonNull java.text.ParsePosition pos) { throw new RuntimeException("Stub!"); }

/**
 * Gets the time formatter with the default formatting style
 * for the default {@link java.util.Locale.Category#FORMAT FORMAT} locale.
 * <p>This is equivalent to calling
 * {@link #getTimeInstance(int,java.util.Locale) getTimeInstance(DEFAULT,
 *     Locale.getDefault(Locale.Category.FORMAT))}.
 * @see java.util.Locale#getDefault(java.util.Locale.Category)
 * @see java.util.Locale.Category#FORMAT
 * @return a time formatter.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static final java.text.DateFormat getTimeInstance() { throw new RuntimeException("Stub!"); }

/**
 * Gets the time formatter with the given formatting style
 * for the default {@link java.util.Locale.Category#FORMAT FORMAT} locale.
 * <p>This is equivalent to calling
 * {@link #getTimeInstance(int,java.util.Locale) getTimeInstance(style,
 *     Locale.getDefault(Locale.Category.FORMAT))}.
 * @see java.util.Locale#getDefault(java.util.Locale.Category)
 * @see java.util.Locale.Category#FORMAT
 * @param style the given formatting style. For example,
 * SHORT for "h:mm a" in the US locale.
 * @return a time formatter.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static final java.text.DateFormat getTimeInstance(int style) { throw new RuntimeException("Stub!"); }

/**
 * Gets the time formatter with the given formatting style
 * for the given locale.
 * @param style the given formatting style. For example,
 * SHORT for "h:mm a" in the US locale.
 * @param aLocale the given locale.
 * @return a time formatter.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static final java.text.DateFormat getTimeInstance(int style, @androidx.annotation.NonNull java.util.Locale aLocale) { throw new RuntimeException("Stub!"); }

/**
 * Gets the date formatter with the default formatting style
 * for the default {@link java.util.Locale.Category#FORMAT FORMAT} locale.
 * <p>This is equivalent to calling
 * {@link #getDateInstance(int,java.util.Locale) getDateInstance(DEFAULT,
 *     Locale.getDefault(Locale.Category.FORMAT))}.
 * @see java.util.Locale#getDefault(java.util.Locale.Category)
 * @see java.util.Locale.Category#FORMAT
 * @return a date formatter.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static final java.text.DateFormat getDateInstance() { throw new RuntimeException("Stub!"); }

/**
 * Gets the date formatter with the given formatting style
 * for the default {@link java.util.Locale.Category#FORMAT FORMAT} locale.
 * <p>This is equivalent to calling
 * {@link #getDateInstance(int,java.util.Locale) getDateInstance(style,
 *     Locale.getDefault(Locale.Category.FORMAT))}.
 * @see java.util.Locale#getDefault(java.util.Locale.Category)
 * @see java.util.Locale.Category#FORMAT
 * @param style the given formatting style. For example,
 * SHORT for "M/d/yy" in the US locale.
 * @return a date formatter.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static final java.text.DateFormat getDateInstance(int style) { throw new RuntimeException("Stub!"); }

/**
 * Gets the date formatter with the given formatting style
 * for the given locale.
 * @param style the given formatting style. For example,
 * SHORT for "M/d/yy" in the US locale.
 * @param aLocale the given locale.
 * @return a date formatter.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static final java.text.DateFormat getDateInstance(int style, @androidx.annotation.NonNull java.util.Locale aLocale) { throw new RuntimeException("Stub!"); }

/**
 * Gets the date/time formatter with the default formatting style
 * for the default {@link java.util.Locale.Category#FORMAT FORMAT} locale.
 * <p>This is equivalent to calling
 * {@link #getDateTimeInstance(int,int,java.util.Locale) getDateTimeInstance(DEFAULT,
 *     DEFAULT, Locale.getDefault(Locale.Category.FORMAT))}.
 * @see java.util.Locale#getDefault(java.util.Locale.Category)
 * @see java.util.Locale.Category#FORMAT
 * @return a date/time formatter.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static final java.text.DateFormat getDateTimeInstance() { throw new RuntimeException("Stub!"); }

/**
 * Gets the date/time formatter with the given date and time
 * formatting styles for the default {@link java.util.Locale.Category#FORMAT FORMAT} locale.
 * <p>This is equivalent to calling
 * {@link #getDateTimeInstance(int,int,java.util.Locale) getDateTimeInstance(dateStyle,
 *     timeStyle, Locale.getDefault(Locale.Category.FORMAT))}.
 * @see java.util.Locale#getDefault(java.util.Locale.Category)
 * @see java.util.Locale.Category#FORMAT
 * @param dateStyle the given date formatting style. For example,
 * SHORT for "M/d/yy" in the US locale.
 * @param timeStyle the given time formatting style. For example,
 * SHORT for "h:mm a" in the US locale.
 * @return a date/time formatter.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static final java.text.DateFormat getDateTimeInstance(int dateStyle, int timeStyle) { throw new RuntimeException("Stub!"); }

/**
 * Gets the date/time formatter with the given formatting styles
 * for the given locale.
 * @param dateStyle the given date formatting style.
 * @param timeStyle the given time formatting style.
 * @param aLocale the given locale.
 * @return a date/time formatter.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static final java.text.DateFormat getDateTimeInstance(int dateStyle, int timeStyle, @androidx.annotation.NonNull java.util.Locale aLocale) { throw new RuntimeException("Stub!"); }

/**
 * Get a default date/time formatter that uses the SHORT style for both the
 * date and the time.
 *
 * @return a date/time formatter
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static final java.text.DateFormat getInstance() { throw new RuntimeException("Stub!"); }

/**
 * Returns an array of all locales for which the
 * <code>get*Instance</code> methods of this class can return
 * localized instances.
 *
 * @return An array of locales for which localized
 *         <code>DateFormat</code> instances are available.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.util.Locale[] getAvailableLocales() { throw new RuntimeException("Stub!"); }

/**
 * Set the calendar to be used by this date format.  Initially, the default
 * calendar for the specified or default locale is used.
 *
 * <p>Any {@link java.util.TimeZone TimeZone} and {@linkplain
 * #isLenient() leniency} values that have previously been set are
 * overwritten by {@code newCalendar}'s values.
 *
 * @param newCalendar the new {@code Calendar} to be used by the date format
 * @apiSince 1
 */

public void setCalendar(@androidx.annotation.NonNull java.util.Calendar newCalendar) { throw new RuntimeException("Stub!"); }

/**
 * Gets the calendar associated with this date/time formatter.
 *
 * @return the calendar associated with this date/time formatter.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.util.Calendar getCalendar() { throw new RuntimeException("Stub!"); }

/**
 * Allows you to set the number formatter.
 * @param newNumberFormat the given new NumberFormat.
 * @apiSince 1
 */

public void setNumberFormat(@androidx.annotation.NonNull java.text.NumberFormat newNumberFormat) { throw new RuntimeException("Stub!"); }

/**
 * Gets the number formatter which this date/time formatter uses to
 * format and parse a time.
 * @return the number formatter which this date/time formatter uses.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.text.NumberFormat getNumberFormat() { throw new RuntimeException("Stub!"); }

/**
 * Sets the time zone for the calendar of this {@code DateFormat} object.
 * This method is equivalent to the following call.
 * <blockquote><pre>{@code
 * getCalendar().setTimeZone(zone)
 * }</pre></blockquote>
 *
 * <p>The {@code TimeZone} set by this method is overwritten by a
 * {@link #setCalendar(java.util.Calendar) setCalendar} call.
 *
 * <p>The {@code TimeZone} set by this method may be overwritten as
 * a result of a call to the parse method.
 *
 * @param zone the given new time zone.
 * @apiSince 1
 */

public void setTimeZone(@androidx.annotation.NonNull java.util.TimeZone zone) { throw new RuntimeException("Stub!"); }

/**
 * Gets the time zone.
 * This method is equivalent to the following call.
 * <blockquote><pre>{@code
 * getCalendar().getTimeZone()
 * }</pre></blockquote>
 *
 * @return the time zone associated with the calendar of DateFormat.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.util.TimeZone getTimeZone() { throw new RuntimeException("Stub!"); }

/**
 * Specify whether or not date/time parsing is to be lenient.  With
 * lenient parsing, the parser may use heuristics to interpret inputs that
 * do not precisely match this object's format.  With strict parsing,
 * inputs must match this object's format.
 *
 * <p>This method is equivalent to the following call.
 * <blockquote><pre>{@code
 * getCalendar().setLenient(lenient)
 * }</pre></blockquote>
 *
 * <p>This leniency value is overwritten by a call to {@link
 * #setCalendar(java.util.Calendar) setCalendar()}.
 *
 * @param lenient when {@code true}, parsing is lenient
 * @see java.util.Calendar#setLenient(boolean)
 * @apiSince 1
 */

public void setLenient(boolean lenient) { throw new RuntimeException("Stub!"); }

/**
 * Tell whether date/time parsing is to be lenient.
 * This method is equivalent to the following call.
 * <blockquote><pre>{@code
 * getCalendar().isLenient()
 * }</pre></blockquote>
 *
 * @return {@code true} if the {@link #calendar} is lenient;
 *         {@code false} otherwise.
 * @see java.util.Calendar#isLenient()
 * @apiSince 1
 */

public boolean isLenient() { throw new RuntimeException("Stub!"); }

/**
 * Overrides hashCode
 * @apiSince 1
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Overrides equals
 * @apiSince 1
 */

public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Overrides Cloneable
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.Object clone() { throw new RuntimeException("Stub!"); }

/**
 * Useful constant for AM_PM field alignment.
 * Used in FieldPosition of date/time formatting.
 * @apiSince 1
 */

public static final int AM_PM_FIELD = 14; // 0xe

/**
 * Useful constant for DATE field alignment.
 * Used in FieldPosition of date/time formatting.
 * @apiSince 1
 */

public static final int DATE_FIELD = 3; // 0x3

/**
 * Useful constant for DAY_OF_WEEK field alignment.
 * Used in FieldPosition of date/time formatting.
 * @apiSince 1
 */

public static final int DAY_OF_WEEK_FIELD = 9; // 0x9

/**
 * Useful constant for DAY_OF_WEEK_IN_MONTH field alignment.
 * Used in FieldPosition of date/time formatting.
 * @apiSince 1
 */

public static final int DAY_OF_WEEK_IN_MONTH_FIELD = 11; // 0xb

/**
 * Useful constant for DAY_OF_YEAR field alignment.
 * Used in FieldPosition of date/time formatting.
 * @apiSince 1
 */

public static final int DAY_OF_YEAR_FIELD = 10; // 0xa

/**
 * Constant for default style pattern.  Its value is MEDIUM.
 * @apiSince 1
 */

public static final int DEFAULT = 2; // 0x2

/**
 * Useful constant for ERA field alignment.
 * Used in FieldPosition of date/time formatting.
 * @apiSince 1
 */

public static final int ERA_FIELD = 0; // 0x0

/**
 * Constant for full style pattern.
 * @apiSince 1
 */

public static final int FULL = 0; // 0x0

/**
 * Useful constant for zero-based HOUR field alignment.
 * Used in FieldPosition of date/time formatting.
 * HOUR0_FIELD is used for the zero-based 12-hour clock.
 * For example, 11:30 PM + 1 hour results in 00:30 AM.
 * @apiSince 1
 */

public static final int HOUR0_FIELD = 16; // 0x10

/**
 * Useful constant for one-based HOUR field alignment.
 * Used in FieldPosition of date/time formatting.
 * HOUR1_FIELD is used for the one-based 12-hour clock.
 * For example, 11:30 PM + 1 hour results in 12:30 AM.
 * @apiSince 1
 */

public static final int HOUR1_FIELD = 15; // 0xf

/**
 * Useful constant for zero-based HOUR_OF_DAY field alignment.
 * Used in FieldPosition of date/time formatting.
 * HOUR_OF_DAY0_FIELD is used for the zero-based 24-hour clock.
 * For example, 23:59 + 01:00 results in 00:59.
 * @apiSince 1
 */

public static final int HOUR_OF_DAY0_FIELD = 5; // 0x5

/**
 * Useful constant for one-based HOUR_OF_DAY field alignment.
 * Used in FieldPosition of date/time formatting.
 * HOUR_OF_DAY1_FIELD is used for the one-based 24-hour clock.
 * For example, 23:59 + 01:00 results in 24:59.
 * @apiSince 1
 */

public static final int HOUR_OF_DAY1_FIELD = 4; // 0x4

/**
 * Constant for long style pattern.
 * @apiSince 1
 */

public static final int LONG = 1; // 0x1

/**
 * Constant for medium style pattern.
 * @apiSince 1
 */

public static final int MEDIUM = 2; // 0x2

/**
 * Useful constant for MILLISECOND field alignment.
 * Used in FieldPosition of date/time formatting.
 * @apiSince 1
 */

public static final int MILLISECOND_FIELD = 8; // 0x8

/**
 * Useful constant for MINUTE field alignment.
 * Used in FieldPosition of date/time formatting.
 * @apiSince 1
 */

public static final int MINUTE_FIELD = 6; // 0x6

/**
 * Useful constant for MONTH field alignment.
 * Used in FieldPosition of date/time formatting.
 * @apiSince 1
 */

public static final int MONTH_FIELD = 2; // 0x2

/**
 * Useful constant for SECOND field alignment.
 * Used in FieldPosition of date/time formatting.
 * @apiSince 1
 */

public static final int SECOND_FIELD = 7; // 0x7

/**
 * Constant for short style pattern.
 * @apiSince 1
 */

public static final int SHORT = 3; // 0x3

/**
 * Useful constant for TIMEZONE field alignment.
 * Used in FieldPosition of date/time formatting.
 * @apiSince 1
 */

public static final int TIMEZONE_FIELD = 17; // 0x11

/**
 * Useful constant for WEEK_OF_MONTH field alignment.
 * Used in FieldPosition of date/time formatting.
 * @apiSince 1
 */

public static final int WEEK_OF_MONTH_FIELD = 13; // 0xd

/**
 * Useful constant for WEEK_OF_YEAR field alignment.
 * Used in FieldPosition of date/time formatting.
 * @apiSince 1
 */

public static final int WEEK_OF_YEAR_FIELD = 12; // 0xc

/**
 * Useful constant for YEAR field alignment.
 * Used in FieldPosition of date/time formatting.
 * @apiSince 1
 */

public static final int YEAR_FIELD = 1; // 0x1

/**
 * The {@link java.util.Calendar Calendar} instance used for calculating the date-time fields
 * and the instant of time. This field is used for both formatting and
 * parsing.
 *
 * <p>Subclasses should initialize this field to a {@link java.util.Calendar Calendar}
 * appropriate for the {@link java.util.Locale Locale} associated with this
 * <code>DateFormat</code>.
 * @serial
 * @apiSince 1
 */

@androidx.annotation.NonNull protected java.util.Calendar calendar;

/**
 * The number formatter that <code>DateFormat</code> uses to format numbers
 * in dates and times.  Subclasses should initialize this to a number format
 * appropriate for the locale associated with this <code>DateFormat</code>.
 * @serial
 * @apiSince 1
 */

@androidx.annotation.NonNull protected java.text.NumberFormat numberFormat;
/**
 * Defines constants that are used as attribute keys in the
 * <code>AttributedCharacterIterator</code> returned
 * from <code>DateFormat.formatToCharacterIterator</code> and as
 * field identifiers in <code>FieldPosition</code>.
 * <p>
 * The class also provides two methods to map
 * between its constants and the corresponding Calendar constants.
 *
 * @since 1.4
 * @see java.util.Calendar
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Field extends java.text.Format.Field {

/**
 * Creates a <code>Field</code>.
 *
 * @param name the name of the <code>Field</code>
 * @param calendarField the <code>Calendar</code> constant this
 *        <code>Field</code> corresponds to; any value, even one
 *        outside the range of legal <code>Calendar</code> values may
 *        be used, but <code>-1</code> should be used for values
 *        that don't correspond to legal <code>Calendar</code> values
 * @apiSince 1
 */

protected Field(@androidx.annotation.NonNull java.lang.String name, int calendarField) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Returns the <code>Field</code> constant that corresponds to
 * the <code>Calendar</code> constant <code>calendarField</code>.
 * If there is no direct mapping between the <code>Calendar</code>
 * constant and a <code>Field</code>, null is returned.
 *
 * @throws java.lang.IllegalArgumentException if <code>calendarField</code> is
 *         not the value of a <code>Calendar</code> field constant.
 * @param calendarField Calendar field constant
 * @return Field instance representing calendarField.
 * @see java.util.Calendar
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.text.DateFormat.Field ofCalendarField(int calendarField) { throw new RuntimeException("Stub!"); }

/**
 * Returns the <code>Calendar</code> field associated with this
 * attribute. For example, if this represents the hours field of
 * a <code>Calendar</code>, this would return
 * <code>Calendar.HOUR</code>. If there is no corresponding
 * <code>Calendar</code> constant, this will return -1.
 *
 * @return Calendar constant for this field
 * @see java.util.Calendar
 * @apiSince 1
 */

public int getCalendarField() { throw new RuntimeException("Stub!"); }

/**
 * Resolves instances being deserialized to the predefined constants.
 *
 * @throws java.io.InvalidObjectException if the constant could not be
 *         resolved.
 * @return resolved DateFormat.Field constant
 * @apiSince 1
 */

@androidx.annotation.NonNull
protected java.lang.Object readResolve() throws java.io.InvalidObjectException { throw new RuntimeException("Stub!"); }

/**
 * Constant identifying the time of day indicator
 * (e.g.&nbsp;"a.m." or "p.m.") field.
 * @apiSince 1
 */

@androidx.annotation.NonNull public static final java.text.DateFormat.Field AM_PM;
static { AM_PM = null; }

/**
 * Constant identifying the day of month field.
 * @apiSince 1
 */

@androidx.annotation.NonNull public static final java.text.DateFormat.Field DAY_OF_MONTH;
static { DAY_OF_MONTH = null; }

/**
 * Constant identifying the day of week field.
 * @apiSince 1
 */

@androidx.annotation.NonNull public static final java.text.DateFormat.Field DAY_OF_WEEK;
static { DAY_OF_WEEK = null; }

/**
 * Constant identifying the day of week field.
 * @apiSince 1
 */

@androidx.annotation.NonNull public static final java.text.DateFormat.Field DAY_OF_WEEK_IN_MONTH;
static { DAY_OF_WEEK_IN_MONTH = null; }

/**
 * Constant identifying the day of year field.
 * @apiSince 1
 */

@androidx.annotation.NonNull public static final java.text.DateFormat.Field DAY_OF_YEAR;
static { DAY_OF_YEAR = null; }

/**
 * Constant identifying the era field.
 * @apiSince 1
 */

@androidx.annotation.NonNull public static final java.text.DateFormat.Field ERA;
static { ERA = null; }

/**
 * Constant identifying the hour field, where the legal values are
 * 0 to 11.
 * @apiSince 1
 */

@androidx.annotation.NonNull public static final java.text.DateFormat.Field HOUR0;
static { HOUR0 = null; }

/**
 * Constant identifying the hour field, where the legal values are
 * 1 to 12.
 * @apiSince 1
 */

@androidx.annotation.NonNull public static final java.text.DateFormat.Field HOUR1;
static { HOUR1 = null; }

/**
 * Constant identifying the hour of day field, where the legal values
 * are 0 to 23.
 * @apiSince 1
 */

@androidx.annotation.NonNull public static final java.text.DateFormat.Field HOUR_OF_DAY0;
static { HOUR_OF_DAY0 = null; }

/**
 * Constant identifying the hour of day field, where the legal values
 * are 1 to 24.
 * @apiSince 1
 */

@androidx.annotation.NonNull public static final java.text.DateFormat.Field HOUR_OF_DAY1;
static { HOUR_OF_DAY1 = null; }

/**
 * Constant identifying the millisecond field.
 * @apiSince 1
 */

@androidx.annotation.NonNull public static final java.text.DateFormat.Field MILLISECOND;
static { MILLISECOND = null; }

/**
 * Constant identifying the minute field.
 * @apiSince 1
 */

@androidx.annotation.NonNull public static final java.text.DateFormat.Field MINUTE;
static { MINUTE = null; }

/**
 * Constant identifying the month field.
 * @apiSince 1
 */

@androidx.annotation.NonNull public static final java.text.DateFormat.Field MONTH;
static { MONTH = null; }

/**
 * Constant identifying the second field.
 * @apiSince 1
 */

@androidx.annotation.NonNull public static final java.text.DateFormat.Field SECOND;
static { SECOND = null; }

/**
 * Constant identifying the time zone field.
 * @apiSince 1
 */

@androidx.annotation.NonNull public static final java.text.DateFormat.Field TIME_ZONE;
static { TIME_ZONE = null; }

/**
 * Constant identifying the week of month field.
 * @apiSince 1
 */

@androidx.annotation.NonNull public static final java.text.DateFormat.Field WEEK_OF_MONTH;
static { WEEK_OF_MONTH = null; }

/**
 * Constant identifying the week of year field.
 * @apiSince 1
 */

@androidx.annotation.NonNull public static final java.text.DateFormat.Field WEEK_OF_YEAR;
static { WEEK_OF_YEAR = null; }

/**
 * Constant identifying the year field.
 * @apiSince 1
 */

@androidx.annotation.NonNull public static final java.text.DateFormat.Field YEAR;
static { YEAR = null; }
}

}

