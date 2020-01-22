/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1996, 2016, Oracle and/or its affiliates. All rights reserved.
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

/**
 * <code>DateFormatSymbols</code> is a public class for encapsulating
 * localizable date-time formatting data, such as the names of the
 * months, the names of the days of the week, and the time zone data.
 * <code>SimpleDateFormat</code> uses
 * <code>DateFormatSymbols</code> to encapsulate this information.
 *
 * <p>
 * Typically you shouldn't use <code>DateFormatSymbols</code> directly.
 * Rather, you are encouraged to create a date-time formatter with the
 * <code>DateFormat</code> class's factory methods: <code>getTimeInstance</code>,
 * <code>getDateInstance</code>, or <code>getDateTimeInstance</code>.
 * These methods automatically create a <code>DateFormatSymbols</code> for
 * the formatter so that you don't have to. After the
 * formatter is created, you may modify its format pattern using the
 * <code>setPattern</code> method. For more information about
 * creating formatters using <code>DateFormat</code>'s factory methods,
 * see {@link java.text.DateFormat DateFormat}.
 *
 * <p>
 * If you decide to create a date-time formatter with a specific
 * format pattern for a specific locale, you can do so with:
 * <blockquote>
 * <pre>
 * new SimpleDateFormat(aPattern, DateFormatSymbols.getInstance(aLocale)).
 * </pre>
 * </blockquote>
 *
 * <p>
 * <code>DateFormatSymbols</code> objects are cloneable. When you obtain
 * a <code>DateFormatSymbols</code> object, feel free to modify the
 * date-time formatting data. For instance, you can replace the localized
 * date-time format pattern characters with the ones that you feel easy
 * to remember. Or you can change the representative cities
 * to your favorite ones.
 *
 * <p>
 * New <code>DateFormatSymbols</code> subclasses may be added to support
 * <code>SimpleDateFormat</code> for date-time formatting for additional locales.
 
 * @see          java.text.DateFormat
 * @see          java.text.SimpleDateFormat
 * @see          java.util.SimpleTimeZone
 * @author       Chen-Lieh Huang
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DateFormatSymbols implements java.io.Serializable, java.lang.Cloneable {

/**
 * Construct a DateFormatSymbols object by loading format data from
 * resources for the default {@link java.util.Locale.Category#FORMAT FORMAT}
 * locale. It is recommended that the {@link #getInstance(java.util.Locale) getInstance} method is used
 * instead.
 * <p>This is equivalent to calling
 * {@link #DateFormatSymbols(java.util.Locale)
 *     DateFormatSymbols(Locale.getDefault(Locale.Category.FORMAT))}.
 * @see #getInstance()
 * @see java.util.Locale#getDefault(java.util.Locale.Category)
 * @see java.util.Locale.Category#FORMAT
 * @exception  java.util.MissingResourceException
 *             if the resources for the default locale cannot be
 *             found or cannot be loaded.
 * @apiSince 1
 */

public DateFormatSymbols() { throw new RuntimeException("Stub!"); }

/**
 * Construct a DateFormatSymbols object by loading format data from
 * resources for the given locale. It is recommended that the
 * {@link #getInstance(java.util.Locale) getInstance} method is used instead.
 *
 * @param locale the desired locale
 * @see #getInstance(Locale)
 * @exception  java.util.MissingResourceException
 *             if the resources for the specified locale cannot be
 *             found or cannot be loaded.
 * @apiSince 1
 */

public DateFormatSymbols(java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Returns an array of all locales for which the
 * <code>getInstance</code> methods of this class can return
 * localized instances.
 *
 * @return An array of locales for which localized
 *         <code>DateFormatSymbols</code> instances are available.
 * @since 1.6
 * @apiSince 9
 */

public static java.util.Locale[] getAvailableLocales() { throw new RuntimeException("Stub!"); }

/**
 * Gets the <code>DateFormatSymbols</code> instance for the default
 * locale.
 * <p>This is equivalent to calling {@link #getInstance(java.util.Locale)
 *     getInstance(Locale.getDefault(Locale.Category.FORMAT))}.
 * @see java.util.Locale#getDefault(java.util.Locale.Category)
 * @see java.util.Locale.Category#FORMAT
 * @return a <code>DateFormatSymbols</code> instance.
 * @since 1.6
 * @apiSince 9
 */

public static final java.text.DateFormatSymbols getInstance() { throw new RuntimeException("Stub!"); }

/**
 * Gets the <code>DateFormatSymbols</code> instance for the specified
 * locale.
 * @param locale the given locale.
 * @return a <code>DateFormatSymbols</code> instance.
 * @exception java.lang.NullPointerException if <code>locale</code> is null
 * @since 1.6
 * @apiSince 9
 */

public static final java.text.DateFormatSymbols getInstance(java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Gets era strings. For example: "AD" and "BC".
 * @return the era strings.
 * @apiSince 1
 */

public java.lang.String[] getEras() { throw new RuntimeException("Stub!"); }

/**
 * Sets era strings. For example: "AD" and "BC".
 * @param newEras the new era strings.
 * @apiSince 1
 */

public void setEras(java.lang.String[] newEras) { throw new RuntimeException("Stub!"); }

/**
 * Gets month strings. For example: "January", "February", etc.
 *
 * <p>If the language requires different forms for formatting and
 * stand-alone usages, this method returns month names in the
 * formatting form. For example, the preferred month name for
 * January in the Czech language is <em>ledna</em> in the
 * formatting form, while it is <em>leden</em> in the stand-alone
 * form. This method returns {@code "ledna"} in this case. Refer
 * to the <a href="http://unicode.org/reports/tr35/#Calendar_Elements">
 * Calendar Elements in the Unicode Locale Data Markup Language
 * (LDML) specification</a> for more details.
 *
 * @return the month strings.
 * @apiSince 1
 */

public java.lang.String[] getMonths() { throw new RuntimeException("Stub!"); }

/**
 * Sets month strings. For example: "January", "February", etc.
 * @param newMonths the new month strings.
 * @apiSince 1
 */

public void setMonths(java.lang.String[] newMonths) { throw new RuntimeException("Stub!"); }

/**
 * Gets short month strings. For example: "Jan", "Feb", etc.
 *
 * <p>If the language requires different forms for formatting and
 * stand-alone usages, This method returns short month names in
 * the formatting form. For example, the preferred abbreviation
 * for January in the Catalan language is <em>de gen.</em> in the
 * formatting form, while it is <em>gen.</em> in the stand-alone
 * form. This method returns {@code "de gen."} in this case. Refer
 * to the <a href="http://unicode.org/reports/tr35/#Calendar_Elements">
 * Calendar Elements in the Unicode Locale Data Markup Language
 * (LDML) specification</a> for more details.
 *
 * @return the short month strings.
 * @apiSince 1
 */

public java.lang.String[] getShortMonths() { throw new RuntimeException("Stub!"); }

/**
 * Sets short month strings. For example: "Jan", "Feb", etc.
 * @param newShortMonths the new short month strings.
 * @apiSince 1
 */

public void setShortMonths(java.lang.String[] newShortMonths) { throw new RuntimeException("Stub!"); }

/**
 * Gets weekday strings. For example: "Sunday", "Monday", etc.
 * @return the weekday strings. Use <code>Calendar.SUNDAY</code>,
 * <code>Calendar.MONDAY</code>, etc. to index the result array.
 * @apiSince 1
 */

public java.lang.String[] getWeekdays() { throw new RuntimeException("Stub!"); }

/**
 * Sets weekday strings. For example: "Sunday", "Monday", etc.
 * @param newWeekdays the new weekday strings. The array should
 * be indexed by <code>Calendar.SUNDAY</code>,
 * <code>Calendar.MONDAY</code>, etc.
 * @apiSince 1
 */

public void setWeekdays(java.lang.String[] newWeekdays) { throw new RuntimeException("Stub!"); }

/**
 * Gets short weekday strings. For example: "Sun", "Mon", etc.
 * @return the short weekday strings. Use <code>Calendar.SUNDAY</code>,
 * <code>Calendar.MONDAY</code>, etc. to index the result array.
 * @apiSince 1
 */

public java.lang.String[] getShortWeekdays() { throw new RuntimeException("Stub!"); }

/**
 * Sets short weekday strings. For example: "Sun", "Mon", etc.
 * @param newShortWeekdays the new short weekday strings. The array should
 * be indexed by <code>Calendar.SUNDAY</code>,
 * <code>Calendar.MONDAY</code>, etc.
 * @apiSince 1
 */

public void setShortWeekdays(java.lang.String[] newShortWeekdays) { throw new RuntimeException("Stub!"); }

/**
 * Gets ampm strings. For example: "AM" and "PM".
 * @return the ampm strings.
 * @apiSince 1
 */

public java.lang.String[] getAmPmStrings() { throw new RuntimeException("Stub!"); }

/**
 * Sets ampm strings. For example: "AM" and "PM".
 * @param newAmpms the new ampm strings.
 * @apiSince 1
 */

public void setAmPmStrings(java.lang.String[] newAmpms) { throw new RuntimeException("Stub!"); }

/**
 * Gets time zone strings.  Use of this method is discouraged; use
 * {@link java.util.TimeZone#getDisplayName() TimeZone.getDisplayName()}
 * instead.
 * <p>
 * The value returned is a
 * two-dimensional array of strings of size <em>n</em> by <em>m</em>,
 * where <em>m</em> is at least 5.  Each of the <em>n</em> rows is an
 * entry containing the localized names for a single <code>TimeZone</code>.
 * Each such row contains (with <code>i</code> ranging from
 * 0..<em>n</em>-1):
 * <ul>
 * <li><code>zoneStrings[i][0]</code> - time zone ID</li>
 * <li><code>zoneStrings[i][1]</code> - long name of zone in standard
 * time</li>
 * <li><code>zoneStrings[i][2]</code> - short name of zone in
 * standard time</li>
 * <li><code>zoneStrings[i][3]</code> - long name of zone in daylight
 * saving time</li>
 * <li><code>zoneStrings[i][4]</code> - short name of zone in daylight
 * saving time</li>
 * </ul>
 * The zone ID is <em>not</em> localized; it's one of the valid IDs of
 * the {@link java.util.TimeZone TimeZone} class that are not
 * <a href="../util/TimeZone.html#CustomID">custom IDs</a>.
 * All other entries are localized names.  If a zone does not implement
 * daylight saving time, the daylight saving time names should not be used.
 * <p>
 * If {@link #setZoneStrings(java.lang.String[][]) setZoneStrings} has been called
 * on this <code>DateFormatSymbols</code> instance, then the strings
 * provided by that call are returned. Otherwise, the returned array
 * contains names provided by the runtime.
 *
 * @return the time zone strings.
 * @see #setZoneStrings(String[][])
 * @apiSince 1
 */

public java.lang.String[][] getZoneStrings() { throw new RuntimeException("Stub!"); }

/**
 * Sets time zone strings.  The argument must be a
 * two-dimensional array of strings of size <em>n</em> by <em>m</em>,
 * where <em>m</em> is at least 5.  Each of the <em>n</em> rows is an
 * entry containing the localized names for a single <code>TimeZone</code>.
 * Each such row contains (with <code>i</code> ranging from
 * 0..<em>n</em>-1):
 * <ul>
 * <li><code>zoneStrings[i][0]</code> - time zone ID</li>
 * <li><code>zoneStrings[i][1]</code> - long name of zone in standard
 * time</li>
 * <li><code>zoneStrings[i][2]</code> - short name of zone in
 * standard time</li>
 * <li><code>zoneStrings[i][3]</code> - long name of zone in daylight
 * saving time</li>
 * <li><code>zoneStrings[i][4]</code> - short name of zone in daylight
 * saving time</li>
 * </ul>
 * The zone ID is <em>not</em> localized; it's one of the valid IDs of
 * the {@link java.util.TimeZone TimeZone} class that are not
 * <a href="../util/TimeZone.html#CustomID">custom IDs</a>.
 * All other entries are localized names.
 *
 * @param newZoneStrings the new time zone strings.
 * @exception java.lang.IllegalArgumentException if the length of any row in
 *    <code>newZoneStrings</code> is less than 5
 * @exception java.lang.NullPointerException if <code>newZoneStrings</code> is null
 * @see #getZoneStrings()
 * @apiSince 1
 */

public void setZoneStrings(java.lang.String[][] newZoneStrings) { throw new RuntimeException("Stub!"); }

/**
 * Gets localized date-time pattern characters. For example: 'u', 't', etc.
 * @return the localized date-time pattern characters.
 * @apiSince 1
 */

public java.lang.String getLocalPatternChars() { throw new RuntimeException("Stub!"); }

/**
 * Sets localized date-time pattern characters. For example: 'u', 't', etc.
 * @param newLocalPatternChars the new localized date-time
 * pattern characters.
 * @apiSince 1
 */

public void setLocalPatternChars(java.lang.String newLocalPatternChars) { throw new RuntimeException("Stub!"); }

/**
 * Overrides Cloneable
 * @apiSince 1
 */

public java.lang.Object clone() { throw new RuntimeException("Stub!"); }

/**
 * Override hashCode.
 * Generates a hash code for the DateFormatSymbols object.
 * @apiSince 1
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Override equals
 * @apiSince 1
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }
}

