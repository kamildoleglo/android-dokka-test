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



package java.util;

import java.time.ZoneId;

/**
 * <code>TimeZone</code> represents a time zone offset, and also figures out daylight
 * savings.
 *
 * <p>
 * Typically, you get a <code>TimeZone</code> using <code>getDefault</code>
 * which creates a <code>TimeZone</code> based on the time zone where the program
 * is running. For example, for a program running in Japan, <code>getDefault</code>
 * creates a <code>TimeZone</code> object based on Japanese Standard Time.
 *
 * <p>
 * You can also get a <code>TimeZone</code> using <code>getTimeZone</code>
 * along with a time zone ID. For instance, the time zone ID for the
 * U.S. Pacific Time zone is "America/Los_Angeles". So, you can get a
 * U.S. Pacific Time <code>TimeZone</code> object with:
 * <blockquote><pre>
 * TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
 * </pre></blockquote>
 * You can use the <code>getAvailableIDs</code> method to iterate through
 * all the supported time zone IDs. You can then choose a
 * supported ID to get a <code>TimeZone</code>.
 * If the time zone you want is not represented by one of the
 * supported IDs, then a custom time zone ID can be specified to
 * produce a TimeZone. The syntax of a custom time zone ID is:
 *
 * <blockquote><pre>
 * <a name="CustomID"><i>CustomID:</i></a>
 *         <code>GMT</code> <i>Sign</i> <i>Hours</i> <code>:</code> <i>Minutes</i>
 *         <code>GMT</code> <i>Sign</i> <i>Hours</i> <i>Minutes</i>
 *         <code>GMT</code> <i>Sign</i> <i>Hours</i>
 * <i>Sign:</i> one of
 *         <code>+ -</code>
 * <i>Hours:</i>
 *         <i>Digit</i>
 *         <i>Digit</i> <i>Digit</i>
 * <i>Minutes:</i>
 *         <i>Digit</i> <i>Digit</i>
 * <i>Digit:</i> one of
 *         <code>0 1 2 3 4 5 6 7 8 9</code>
 * </pre></blockquote>
 *
 * <i>Hours</i> must be between 0 to 23 and <i>Minutes</i> must be
 * between 00 to 59.  For example, "GMT+10" and "GMT+0010" mean ten
 * hours and ten minutes ahead of GMT, respectively.
 * <p>
 * The format is locale independent and digits must be taken from the
 * Basic Latin block of the Unicode standard. No daylight saving time
 * transition schedule can be specified with a custom time zone ID. If
 * the specified string doesn't match the syntax, <code>"GMT"</code>
 * is used.
 * <p>
 * When creating a <code>TimeZone</code>, the specified custom time
 * zone ID is normalized in the following syntax:
 * <blockquote><pre>
 * <a name="NormalizedCustomID"><i>NormalizedCustomID:</i></a>
 *         <code>GMT</code> <i>Sign</i> <i>TwoDigitHours</i> <code>:</code> <i>Minutes</i>
 * <i>Sign:</i> one of
 *         <code>+ -</code>
 * <i>TwoDigitHours:</i>
 *         <i>Digit</i> <i>Digit</i>
 * <i>Minutes:</i>
 *         <i>Digit</i> <i>Digit</i>
 * <i>Digit:</i> one of
 *         <code>0 1 2 3 4 5 6 7 8 9</code>
 * </pre></blockquote>
 * For example, TimeZone.getTimeZone("GMT-8").getID() returns "GMT-08:00".
 *
 * <h3>Three-letter time zone IDs</h3>
 *
 * For compatibility with JDK 1.1.x, some other three-letter time zone IDs
 * (such as "PST", "CTT", "AST") are also supported. However, <strong>their
 * use is deprecated</strong> because the same abbreviation is often used
 * for multiple time zones (for example, "CST" could be U.S. "Central Standard
 * Time" and "China Standard Time"), and the Java platform can then only
 * recognize one of them.
 *
 *
 * @see          java.util.Calendar
 * @see          java.util.GregorianCalendar
 * @see          java.util.SimpleTimeZone
 * @author       Mark Davis, David Goldsmith, Chen-Lieh Huang, Alan Liu
 * @since        JDK1.1
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class TimeZone implements java.io.Serializable, java.lang.Cloneable {

/**
 * Sole constructor.  (For invocation by subclass constructors, typically
 * implicit.)
 * @apiSince 1
 */

public TimeZone() { throw new RuntimeException("Stub!"); }

/**
 * Gets the time zone offset, for current date, modified in case of
 * daylight savings. This is the offset to add to UTC to get local time.
 * <p>
 * This method returns a historically correct offset if an
 * underlying <code>TimeZone</code> implementation subclass
 * supports historical Daylight Saving Time schedule and GMT
 * offset changes.
 *
 * @param era the era of the given date.
 * @param year the year in the given date.
 * @param month the month in the given date.
 * Month is 0-based. e.g., 0 for January.
 * @param day the day-in-month of the given date.
 * @param dayOfWeek the day-of-week of the given date.
 * @param milliseconds the milliseconds in day in <em>standard</em>
 * local time.
 *
 * @return the offset in milliseconds to add to GMT to get local time.
 *
 * @see java.util.Calendar#ZONE_OFFSET
 * @see java.util.Calendar#DST_OFFSET
 * @apiSince 1
 */

public abstract int getOffset(int era, int year, int month, int day, int dayOfWeek, int milliseconds);

/**
 * Returns the offset of this time zone from UTC at the specified
 * date. If Daylight Saving Time is in effect at the specified
 * date, the offset value is adjusted with the amount of daylight
 * saving.
 * <p>
 * This method returns a historically correct offset value if an
 * underlying TimeZone implementation subclass supports historical
 * Daylight Saving Time schedule and GMT offset changes.
 *
 * @param date the date represented in milliseconds since January 1, 1970 00:00:00 GMT
 * @return the amount of time in milliseconds to add to UTC to get local time.
 *
 * @see java.util.Calendar#ZONE_OFFSET
 * @see java.util.Calendar#DST_OFFSET
 * @since 1.4
 * @apiSince 1
 */

public int getOffset(long date) { throw new RuntimeException("Stub!"); }

/**
 * Sets the base time zone offset to GMT.
 * This is the offset to add to UTC to get local time.
 * <p>
 * If an underlying <code>TimeZone</code> implementation subclass
 * supports historical GMT offset changes, the specified GMT
 * offset is set as the latest GMT offset and the difference from
 * the known latest GMT offset value is used to adjust all
 * historical GMT offset values.
 *
 * @param offsetMillis the given base time zone offset to GMT.
 * @apiSince 1
 */

public abstract void setRawOffset(int offsetMillis);

/**
 * Returns the amount of time in milliseconds to add to UTC to get
 * standard time in this time zone. Because this value is not
 * affected by daylight saving time, it is called <I>raw
 * offset</I>.
 * <p>
 * If an underlying <code>TimeZone</code> implementation subclass
 * supports historical GMT offset changes, the method returns the
 * raw offset value of the current date. In Honolulu, for example,
 * its raw offset changed from GMT-10:30 to GMT-10:00 in 1947, and
 * this method always returns -36000000 milliseconds (i.e., -10
 * hours).
 *
 * @return the amount of raw offset time in milliseconds to add to UTC.
 * @see java.util.Calendar#ZONE_OFFSET
 * @apiSince 1
 */

public abstract int getRawOffset();

/**
 * Gets the ID of this time zone.
 * @return the ID of this time zone.
 * @apiSince 1
 */

public java.lang.String getID() { throw new RuntimeException("Stub!"); }

/**
 * Sets the time zone ID. This does not change any other data in
 * the time zone object.
 * @param ID the new time zone ID.
 * @apiSince 1
 */

public void setID(java.lang.String ID) { throw new RuntimeException("Stub!"); }

/**
 * Returns a long standard time name of this {@code TimeZone} suitable for
 * presentation to the user in the default locale.
 *
 * <p>This method is equivalent to:
 * <blockquote><pre>
 * getDisplayName(false, {@link #LONG},
 *                Locale.getDefault({@link java.util.Locale.Category#DISPLAY Locale.Category#DISPLAY}))
 * </pre></blockquote>
 *
 * @return the human-readable name of this time zone in the default locale.
 * @since 1.2
 * @see #getDisplayName(boolean, int, Locale)
 * @see java.util.Locale#getDefault(Locale.Category)
 * @see java.util.Locale.Category
 * @apiSince 1
 */

public final java.lang.String getDisplayName() { throw new RuntimeException("Stub!"); }

/**
 * Returns a long standard time name of this {@code TimeZone} suitable for
 * presentation to the user in the specified {@code locale}.
 *
 * <p>This method is equivalent to:
 * <blockquote><pre>
 * getDisplayName(false, {@link #LONG}, locale)
 * </pre></blockquote>
 *
 * @param locale the locale in which to supply the display name.
 * @return the human-readable name of this time zone in the given locale.
 * @exception java.lang.NullPointerException if {@code locale} is {@code null}.
 * @since 1.2
 * @see #getDisplayName(boolean, int, Locale)
 * @apiSince 1
 */

public final java.lang.String getDisplayName(java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Returns a name in the specified {@code style} of this {@code TimeZone}
 * suitable for presentation to the user in the default locale. If the
 * specified {@code daylight} is {@code true}, a Daylight Saving Time name
 * is returned (even if this {@code TimeZone} doesn't observe Daylight Saving
 * Time). Otherwise, a Standard Time name is returned.
 *
 * <p>This method is equivalent to:
 * <blockquote><pre>
 * getDisplayName(daylight, style,
 *                Locale.getDefault({@link java.util.Locale.Category#DISPLAY Locale.Category#DISPLAY}))
 * </pre></blockquote>
 *
 * @param daylight {@code true} specifying a Daylight Saving Time name, or
 *                 {@code false} specifying a Standard Time name
 * @param style either {@link #LONG} or {@link #SHORT}
 * @return the human-readable name of this time zone in the default locale.
 * @exception java.lang.IllegalArgumentException if {@code style} is invalid.
 * @since 1.2
 * @see #getDisplayName(boolean, int, Locale)
 * @see java.util.Locale#getDefault(Locale.Category)
 * @see java.util.Locale.Category
 * @see java.text.DateFormatSymbols#getZoneStrings()
 * @apiSince 1
 */

public final java.lang.String getDisplayName(boolean daylight, int style) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link #SHORT short} or {@link #LONG long} name of this time
 * zone with either standard or daylight time, as written in {@code locale}.
 * If the name is not available, the result is in the format
 * {@code GMT[+-]hh:mm}.
 *
 * @param daylightTime true for daylight time, false for standard time.
 * @param style either {@link java.util.TimeZone#LONG TimeZone#LONG} or {@link java.util.TimeZone#SHORT TimeZone#SHORT}.
 * @param locale the display locale.
 * @apiSince 1
 */

public java.lang.String getDisplayName(boolean daylightTime, int style, java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Returns the amount of time to be added to local standard time
 * to get local wall clock time.
 *
 * <p>The default implementation returns 3600000 milliseconds
 * (i.e., one hour) if a call to {@link #useDaylightTime()}
 * returns {@code true}. Otherwise, 0 (zero) is returned.
 *
 * <p>If an underlying {@code TimeZone} implementation subclass
 * supports historical and future Daylight Saving Time schedule
 * changes, this method returns the amount of saving time of the
 * last known Daylight Saving Time rule that can be a future
 * prediction.
 *
 * <p>If the amount of saving time at any given time stamp is
 * required, construct a {@link java.util.Calendar Calendar} with this {@code
 * TimeZone} and the time stamp, and call {@link java.util.Calendar#get(int) Calendar#get(int)}{@code (}{@link java.util.Calendar#DST_OFFSET Calendar#DST_OFFSET}{@code )}.
 *
 * @return the amount of saving time in milliseconds
 * @since 1.4
 * @see #inDaylightTime(Date)
 * @see #getOffset(long)
 * @see #getOffset(int,int,int,int,int,int)
 * @see java.util.Calendar#ZONE_OFFSET
 * @apiSince 1
 */

public int getDSTSavings() { throw new RuntimeException("Stub!"); }

/**
 * Queries if this {@code TimeZone} uses Daylight Saving Time.
 *
 * <p>If an underlying {@code TimeZone} implementation subclass
 * supports historical and future Daylight Saving Time schedule
 * changes, this method refers to the last known Daylight Saving Time
 * rule that can be a future prediction and may not be the same as
 * the current rule. Consider calling {@link #observesDaylightTime()}
 * if the current rule should also be taken into account.
 *
 * @return {@code true} if this {@code TimeZone} uses Daylight Saving Time,
 *         {@code false}, otherwise.
 * @see #inDaylightTime(Date)
 * @see java.util.Calendar#DST_OFFSET
 * @apiSince 1
 */

public abstract boolean useDaylightTime();

/**
 * Returns {@code true} if this {@code TimeZone} is currently in
 * Daylight Saving Time, or if a transition from Standard Time to
 * Daylight Saving Time occurs at any future time.
 *
 * <p>The default implementation returns {@code true} if
 * {@code useDaylightTime()} or {@code inDaylightTime(new Date())}
 * returns {@code true}.
 *
 * @return {@code true} if this {@code TimeZone} is currently in
 * Daylight Saving Time, or if a transition from Standard Time to
 * Daylight Saving Time occurs at any future time; {@code false}
 * otherwise.
 * @since 1.7
 * @see #useDaylightTime()
 * @see #inDaylightTime(Date)
 * @see java.util.Calendar#DST_OFFSET
 * @apiSince 24
 */

public boolean observesDaylightTime() { throw new RuntimeException("Stub!"); }

/**
 * Queries if the given {@code date} is in Daylight Saving Time in
 * this time zone.
 *
 * @param date the given Date.
 * @return {@code true} if the given date is in Daylight Saving Time,
 *         {@code false}, otherwise.
 * @apiSince 1
 */

public abstract boolean inDaylightTime(java.util.Date date);

/**
 * Gets the <code>TimeZone</code> for the given ID.
 *
 * @param id the ID for a <code>TimeZone</code>, either an abbreviation
 * such as "PST", a full name such as "America/Los_Angeles", or a custom
 * ID such as "GMT-8:00". Note that the support of abbreviations is
 * for JDK 1.1.x compatibility only and full names should be used.
 *
 * @return the specified <code>TimeZone</code>, or the GMT zone if the given ID
 * cannot be understood.
 * @apiSince 1
 */

public static synchronized java.util.TimeZone getTimeZone(java.lang.String id) { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@code TimeZone} for the given {@code zoneId}.
 *
 * @param zoneId a {@link java.time.ZoneId ZoneId} from which the time zone ID is obtained
 * @return the specified {@code TimeZone}, or the GMT zone if the given ID
 *         cannot be understood.
 * @throws java.lang.NullPointerException if {@code zoneId} is {@code null}
 * @since 1.8
 * @apiSince 26
 */

public static java.util.TimeZone getTimeZone(java.time.ZoneId zoneId) { throw new RuntimeException("Stub!"); }

/**
 * Converts this {@code TimeZone} object to a {@code ZoneId}.
 *
 * @return a {@code ZoneId} representing the same time zone as this
 *         {@code TimeZone}
 * @since 1.8
 * @apiSince 26
 */

public java.time.ZoneId toZoneId() { throw new RuntimeException("Stub!"); }

/**
 * Gets the available IDs according to the given time zone offset in milliseconds.
 *
 * @param rawOffset the given time zone GMT offset in milliseconds.
 * @return an array of IDs, where the time zone for that ID has
 * the specified GMT offset. For example, "America/Phoenix" and "America/Denver"
 * both have GMT-07:00, but differ in daylight saving behavior.
 * @see #getRawOffset()
 * @apiSince 1
 */

public static synchronized java.lang.String[] getAvailableIDs(int rawOffset) { throw new RuntimeException("Stub!"); }

/**
 * Gets all the available IDs supported.
 * @return an array of IDs.
 * @apiSince 1
 */

public static synchronized java.lang.String[] getAvailableIDs() { throw new RuntimeException("Stub!"); }

/**
 * Gets the default <code>TimeZone</code> for this host.
 * The source of the default <code>TimeZone</code>
 * may vary with implementation.
 * @return a default <code>TimeZone</code>.
 * @see #setDefault
 * @apiSince 1
 */

public static java.util.TimeZone getDefault() { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@code TimeZone} that is returned by the {@code getDefault}
 * method. {@code timeZone} is cached. If {@code timeZone} is null, the cached
 * default {@code TimeZone} is cleared. This method doesn't change the value
 * of the {@code user.timezone} property.
 *
 * @param timeZone the new default {@code TimeZone}, or null
 * @see #getDefault
 * @apiSince 1
 */

public static synchronized void setDefault(java.util.TimeZone timeZone) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this zone has the same rule and offset as another zone.
 * That is, if this zone differs only in ID, if at all.  Returns false
 * if the other zone is null.
 * @param other the <code>TimeZone</code> object to be compared with
 * @return true if the other zone is not null and is the same as this one,
 * with the possible exception of the ID
 * @since 1.2
 * @apiSince 1
 */

public boolean hasSameRules(java.util.TimeZone other) { throw new RuntimeException("Stub!"); }

/**
 * Creates a copy of this <code>TimeZone</code>.
 *
 * @return a clone of this <code>TimeZone</code>
 * @apiSince 1
 */

public java.lang.Object clone() { throw new RuntimeException("Stub!"); }

/**
 * A style specifier for <code>getDisplayName()</code> indicating
 * a long name, such as "Pacific Standard Time."
 * @see #SHORT
 * @since 1.2
 * @apiSince 1
 */

public static final int LONG = 1; // 0x1

/**
 * A style specifier for <code>getDisplayName()</code> indicating
 * a short name, such as "PST."
 * @see #LONG
 * @since 1.2
 * @apiSince 1
 */

public static final int SHORT = 0; // 0x0
}

