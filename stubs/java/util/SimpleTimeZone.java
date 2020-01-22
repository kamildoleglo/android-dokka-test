/*
 * Copyright (c) 1996, 2011, Oracle and/or its affiliates. All rights reserved.
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


/**
 * <code>SimpleTimeZone</code> is a concrete subclass of <code>TimeZone</code>
 * that represents a time zone for use with a Gregorian calendar.
 * The class holds an offset from GMT, called <em>raw offset</em>, and start
 * and end rules for a daylight saving time schedule.  Since it only holds
 * single values for each, it cannot handle historical changes in the offset
 * from GMT and the daylight saving schedule, except that the {@link
 * #setStartYear setStartYear} method can specify the year when the daylight
 * saving time schedule starts in effect.
 * <p>
 * To construct a <code>SimpleTimeZone</code> with a daylight saving time
 * schedule, the schedule can be described with a set of rules,
 * <em>start-rule</em> and <em>end-rule</em>. A day when daylight saving time
 * starts or ends is specified by a combination of <em>month</em>,
 * <em>day-of-month</em>, and <em>day-of-week</em> values. The <em>month</em>
 * value is represented by a Calendar {@link java.util.Calendar#MONTH Calendar#MONTH} field
 * value, such as {@link java.util.Calendar#MARCH Calendar#MARCH}. The <em>day-of-week</em> value is
 * represented by a Calendar {@link java.util.Calendar#DAY_OF_WEEK Calendar#DAY_OF_WEEK} value,
 * such as {@link java.util.Calendar#SUNDAY Calendar#SUNDAY}. The meanings of value combinations
 * are as follows.
 *
 * <ul>
 * <li><b>Exact day of month</b><br>
 * To specify an exact day of month, set the <em>month</em> and
 * <em>day-of-month</em> to an exact value, and <em>day-of-week</em> to zero. For
 * example, to specify March 1, set the <em>month</em> to {@link java.util.Calendar#MARCH Calendar#MARCH}, <em>day-of-month</em> to 1, and <em>day-of-week</em> to 0.</li>
 *
 * <li><b>Day of week on or after day of month</b><br>
 * To specify a day of week on or after an exact day of month, set the
 * <em>month</em> to an exact month value, <em>day-of-month</em> to the day on
 * or after which the rule is applied, and <em>day-of-week</em> to a negative {@link java.util.Calendar#DAY_OF_WEEK Calendar#DAY_OF_WEEK} field value. For example, to specify the
 * second Sunday of April, set <em>month</em> to {@link java.util.Calendar#APRIL Calendar#APRIL},
 * <em>day-of-month</em> to 8, and <em>day-of-week</em> to <code>-</code>{@link java.util.Calendar#SUNDAY Calendar#SUNDAY}.</li>
 *
 * <li><b>Day of week on or before day of month</b><br>
 * To specify a day of the week on or before an exact day of the month, set
 * <em>day-of-month</em> and <em>day-of-week</em> to a negative value. For
 * example, to specify the last Wednesday on or before the 21st of March, set
 * <em>month</em> to {@link java.util.Calendar#MARCH Calendar#MARCH}, <em>day-of-month</em> is -21
 * and <em>day-of-week</em> is <code>-</code>{@link java.util.Calendar#WEDNESDAY Calendar#WEDNESDAY}. </li>
 *
 * <li><b>Last day-of-week of month</b><br>
 * To specify, the last day-of-week of the month, set <em>day-of-week</em> to a
 * {@link java.util.Calendar#DAY_OF_WEEK Calendar#DAY_OF_WEEK} value and <em>day-of-month</em> to
 * -1. For example, to specify the last Sunday of October, set <em>month</em>
 * to {@link java.util.Calendar#OCTOBER Calendar#OCTOBER}, <em>day-of-week</em> to {@link java.util.Calendar#SUNDAY Calendar#SUNDAY} and <em>day-of-month</em> to -1.  </li>
 *
 * </ul>
 * The time of the day at which daylight saving time starts or ends is
 * specified by a millisecond value within the day. There are three kinds of
 * <em>mode</em>s to specify the time: {@link #WALL_TIME}, {@link
 * #STANDARD_TIME} and {@link #UTC_TIME}. For example, if daylight
 * saving time ends
 * at 2:00 am in the wall clock time, it can be specified by 7200000
 * milliseconds in the {@link #WALL_TIME} mode. In this case, the wall clock time
 * for an <em>end-rule</em> means the same thing as the daylight time.
 * <p>
 * The following are examples of parameters for constructing time zone objects.
 * <pre><code>
 *      // Base GMT offset: -8:00
 *      // DST starts:      at 2:00am in standard time
 *      //                  on the first Sunday in April
 *      // DST ends:        at 2:00am in daylight time
 *      //                  on the last Sunday in October
 *      // Save:            1 hour
 *      SimpleTimeZone(-28800000,
 *                     "America/Los_Angeles",
 *                     Calendar.APRIL, 1, -Calendar.SUNDAY,
 *                     7200000,
 *                     Calendar.OCTOBER, -1, Calendar.SUNDAY,
 *                     7200000,
 *                     3600000)
 *
 *      // Base GMT offset: +1:00
 *      // DST starts:      at 1:00am in UTC time
 *      //                  on the last Sunday in March
 *      // DST ends:        at 1:00am in UTC time
 *      //                  on the last Sunday in October
 *      // Save:            1 hour
 *      SimpleTimeZone(3600000,
 *                     "Europe/Paris",
 *                     Calendar.MARCH, -1, Calendar.SUNDAY,
 *                     3600000, SimpleTimeZone.UTC_TIME,
 *                     Calendar.OCTOBER, -1, Calendar.SUNDAY,
 *                     3600000, SimpleTimeZone.UTC_TIME,
 *                     3600000)
 * </code></pre>
 * These parameter rules are also applicable to the set rule methods, such as
 * <code>setStartRule</code>.
 *
 * @since 1.1
 * @see      java.util.Calendar
 * @see      java.util.GregorianCalendar
 * @see      java.util.TimeZone
 * @author   David Goldsmith, Mark Davis, Chen-Lieh Huang, Alan Liu
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SimpleTimeZone extends java.util.TimeZone {

/**
 * Constructs a SimpleTimeZone with the given base time zone offset from GMT
 * and time zone ID with no daylight saving time schedule.
 *
 * @param rawOffset  The base time zone offset in milliseconds to GMT.
 * @param ID         The time zone name that is given to this instance.
 * @apiSince 1
 */

public SimpleTimeZone(int rawOffset, java.lang.String ID) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a SimpleTimeZone with the given base time zone offset from
 * GMT, time zone ID, and rules for starting and ending the daylight
 * time.
 * Both <code>startTime</code> and <code>endTime</code> are specified to be
 * represented in the wall clock time. The amount of daylight saving is
 * assumed to be 3600000 milliseconds (i.e., one hour). This constructor is
 * equivalent to:
 * <pre><code>
 *     SimpleTimeZone(rawOffset,
 *                    ID,
 *                    startMonth,
 *                    startDay,
 *                    startDayOfWeek,
 *                    startTime,
 *                    SimpleTimeZone.{@link #WALL_TIME},
 *                    endMonth,
 *                    endDay,
 *                    endDayOfWeek,
 *                    endTime,
 *                    SimpleTimeZone.{@link #WALL_TIME},
 *                    3600000)
 * </code></pre>
 *
 * @param rawOffset       The given base time zone offset from GMT.
 * @param ID              The time zone ID which is given to this object.
 * @param startMonth      The daylight saving time starting month. Month is
 *                        a {@link java.util.Calendar#MONTH Calendar#MONTH} field value (0-based. e.g., 0
 *                        for January).
 * @param startDay        The day of the month on which the daylight saving time starts.
 *                        See the class description for the special cases of this parameter.
 * @param startDayOfWeek  The daylight saving time starting day-of-week.
 *                        See the class description for the special cases of this parameter.
 * @param startTime       The daylight saving time starting time in local wall clock
 *                        time (in milliseconds within the day), which is local
 *                        standard time in this case.
 * @param endMonth        The daylight saving time ending month. Month is
 *                        a {@link java.util.Calendar#MONTH Calendar#MONTH} field
 *                        value (0-based. e.g., 9 for October).
 * @param endDay          The day of the month on which the daylight saving time ends.
 *                        See the class description for the special cases of this parameter.
 * @param endDayOfWeek    The daylight saving time ending day-of-week.
 *                        See the class description for the special cases of this parameter.
 * @param endTime         The daylight saving ending time in local wall clock time,
 *                        (in milliseconds within the day) which is local daylight
 *                        time in this case.
 * @exception java.lang.IllegalArgumentException if the month, day, dayOfWeek, or time
 * parameters are out of range for the start or end rule
 * @apiSince 1
 */

public SimpleTimeZone(int rawOffset, java.lang.String ID, int startMonth, int startDay, int startDayOfWeek, int startTime, int endMonth, int endDay, int endDayOfWeek, int endTime) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a SimpleTimeZone with the given base time zone offset from
 * GMT, time zone ID, and rules for starting and ending the daylight
 * time.
 * Both <code>startTime</code> and <code>endTime</code> are assumed to be
 * represented in the wall clock time. This constructor is equivalent to:
 * <pre><code>
 *     SimpleTimeZone(rawOffset,
 *                    ID,
 *                    startMonth,
 *                    startDay,
 *                    startDayOfWeek,
 *                    startTime,
 *                    SimpleTimeZone.{@link #WALL_TIME},
 *                    endMonth,
 *                    endDay,
 *                    endDayOfWeek,
 *                    endTime,
 *                    SimpleTimeZone.{@link #WALL_TIME},
 *                    dstSavings)
 * </code></pre>
 *
 * @param rawOffset       The given base time zone offset from GMT.
 * @param ID              The time zone ID which is given to this object.
 * @param startMonth      The daylight saving time starting month. Month is
 *                        a {@link java.util.Calendar#MONTH Calendar#MONTH} field
 *                        value (0-based. e.g., 0 for January).
 * @param startDay        The day of the month on which the daylight saving time starts.
 *                        See the class description for the special cases of this parameter.
 * @param startDayOfWeek  The daylight saving time starting day-of-week.
 *                        See the class description for the special cases of this parameter.
 * @param startTime       The daylight saving time starting time in local wall clock
 *                        time, which is local standard time in this case.
 * @param endMonth        The daylight saving time ending month. Month is
 *                        a {@link java.util.Calendar#MONTH Calendar#MONTH} field
 *                        value (0-based. e.g., 9 for October).
 * @param endDay          The day of the month on which the daylight saving time ends.
 *                        See the class description for the special cases of this parameter.
 * @param endDayOfWeek    The daylight saving time ending day-of-week.
 *                        See the class description for the special cases of this parameter.
 * @param endTime         The daylight saving ending time in local wall clock time,
 *                        which is local daylight time in this case.
 * @param dstSavings      The amount of time in milliseconds saved during
 *                        daylight saving time.
 * @exception java.lang.IllegalArgumentException if the month, day, dayOfWeek, or time
 * parameters are out of range for the start or end rule
 * @since 1.2
 * @apiSince 1
 */

public SimpleTimeZone(int rawOffset, java.lang.String ID, int startMonth, int startDay, int startDayOfWeek, int startTime, int endMonth, int endDay, int endDayOfWeek, int endTime, int dstSavings) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a SimpleTimeZone with the given base time zone offset from
 * GMT, time zone ID, and rules for starting and ending the daylight
 * time.
 * This constructor takes the full set of the start and end rules
 * parameters, including modes of <code>startTime</code> and
 * <code>endTime</code>. The mode specifies either {@link #WALL_TIME wall
 * time} or {@link #STANDARD_TIME standard time} or {@link #UTC_TIME UTC
 * time}.
 *
 * @param rawOffset       The given base time zone offset from GMT.
 * @param ID              The time zone ID which is given to this object.
 * @param startMonth      The daylight saving time starting month. Month is
 *                        a {@link java.util.Calendar#MONTH Calendar#MONTH} field
 *                        value (0-based. e.g., 0 for January).
 * @param startDay        The day of the month on which the daylight saving time starts.
 *                        See the class description for the special cases of this parameter.
 * @param startDayOfWeek  The daylight saving time starting day-of-week.
 *                        See the class description for the special cases of this parameter.
 * @param startTime       The daylight saving time starting time in the time mode
 *                        specified by <code>startTimeMode</code>.
 * @param startTimeMode   The mode of the start time specified by startTime.
 * @param endMonth        The daylight saving time ending month. Month is
 *                        a {@link java.util.Calendar#MONTH Calendar#MONTH} field
 *                        value (0-based. e.g., 9 for October).
 * @param endDay          The day of the month on which the daylight saving time ends.
 *                        See the class description for the special cases of this parameter.
 * @param endDayOfWeek    The daylight saving time ending day-of-week.
 *                        See the class description for the special cases of this parameter.
 * @param endTime         The daylight saving ending time in time time mode
 *                        specified by <code>endTimeMode</code>.
 * @param endTimeMode     The mode of the end time specified by endTime
 * @param dstSavings      The amount of time in milliseconds saved during
 *                        daylight saving time.
 *
 * @exception java.lang.IllegalArgumentException if the month, day, dayOfWeek, time more, or
 * time parameters are out of range for the start or end rule, or if a time mode
 * value is invalid.
 *
 * @see #WALL_TIME
 * @see #STANDARD_TIME
 * @see #UTC_TIME
 *
 * @since 1.4
 * @apiSince 1
 */

public SimpleTimeZone(int rawOffset, java.lang.String ID, int startMonth, int startDay, int startDayOfWeek, int startTime, int startTimeMode, int endMonth, int endDay, int endDayOfWeek, int endTime, int endTimeMode, int dstSavings) { throw new RuntimeException("Stub!"); }

/**
 * Sets the daylight saving time starting year.
 *
 * @param year  The daylight saving starting year.
 * @apiSince 1
 */

public void setStartYear(int year) { throw new RuntimeException("Stub!"); }

/**
 * Sets the daylight saving time start rule. For example, if daylight saving
 * time starts on the first Sunday in April at 2 am in local wall clock
 * time, you can set the start rule by calling:
 * <pre><code>setStartRule(Calendar.APRIL, 1, Calendar.SUNDAY, 2*60*60*1000);</code></pre>
 *
 * @param startMonth      The daylight saving time starting month. Month is
 *                        a {@link java.util.Calendar#MONTH Calendar#MONTH} field
 *                        value (0-based. e.g., 0 for January).
 * @param startDay        The day of the month on which the daylight saving time starts.
 *                        See the class description for the special cases of this parameter.
 * @param startDayOfWeek  The daylight saving time starting day-of-week.
 *                        See the class description for the special cases of this parameter.
 * @param startTime       The daylight saving time starting time in local wall clock
 *                        time, which is local standard time in this case.
 * @exception java.lang.IllegalArgumentException if the <code>startMonth</code>, <code>startDay</code>,
 * <code>startDayOfWeek</code>, or <code>startTime</code> parameters are out of range
 * @apiSince 1
 */

public void setStartRule(int startMonth, int startDay, int startDayOfWeek, int startTime) { throw new RuntimeException("Stub!"); }

/**
 * Sets the daylight saving time start rule to a fixed date within a month.
 * This method is equivalent to:
 * <pre><code>setStartRule(startMonth, startDay, 0, startTime)</code></pre>
 *
 * @param startMonth      The daylight saving time starting month. Month is
 *                        a {@link java.util.Calendar#MONTH Calendar#MONTH} field
 *                        value (0-based. e.g., 0 for January).
 * @param startDay        The day of the month on which the daylight saving time starts.
 * @param startTime       The daylight saving time starting time in local wall clock
 *                        time, which is local standard time in this case.
 *                        See the class description for the special cases of this parameter.
 * @exception java.lang.IllegalArgumentException if the <code>startMonth</code>,
 * <code>startDayOfMonth</code>, or <code>startTime</code> parameters are out of range
 * @since 1.2
 * @apiSince 1
 */

public void setStartRule(int startMonth, int startDay, int startTime) { throw new RuntimeException("Stub!"); }

/**
 * Sets the daylight saving time start rule to a weekday before or after the given date within
 * a month, e.g., the first Monday on or after the 8th.
 *
 * @param startMonth      The daylight saving time starting month. Month is
 *                        a {@link java.util.Calendar#MONTH Calendar#MONTH} field
 *                        value (0-based. e.g., 0 for January).
 * @param startDay        The day of the month on which the daylight saving time starts.
 * @param startDayOfWeek  The daylight saving time starting day-of-week.
 * @param startTime       The daylight saving time starting time in local wall clock
 *                        time, which is local standard time in this case.
 * @param after           If true, this rule selects the first <code>dayOfWeek</code> on or
 *                        <em>after</em> <code>dayOfMonth</code>.  If false, this rule
 *                        selects the last <code>dayOfWeek</code> on or <em>before</em>
 *                        <code>dayOfMonth</code>.
 * @exception java.lang.IllegalArgumentException if the <code>startMonth</code>, <code>startDay</code>,
 * <code>startDayOfWeek</code>, or <code>startTime</code> parameters are out of range
 * @since 1.2
 * @apiSince 1
 */

public void setStartRule(int startMonth, int startDay, int startDayOfWeek, int startTime, boolean after) { throw new RuntimeException("Stub!"); }

/**
 * Sets the daylight saving time end rule. For example, if daylight saving time
 * ends on the last Sunday in October at 2 am in wall clock time,
 * you can set the end rule by calling:
 * <code>setEndRule(Calendar.OCTOBER, -1, Calendar.SUNDAY, 2*60*60*1000);</code>
 *
 * @param endMonth        The daylight saving time ending month. Month is
 *                        a {@link java.util.Calendar#MONTH Calendar#MONTH} field
 *                        value (0-based. e.g., 9 for October).
 * @param endDay          The day of the month on which the daylight saving time ends.
 *                        See the class description for the special cases of this parameter.
 * @param endDayOfWeek    The daylight saving time ending day-of-week.
 *                        See the class description for the special cases of this parameter.
 * @param endTime         The daylight saving ending time in local wall clock time,
 *                        (in milliseconds within the day) which is local daylight
 *                        time in this case.
 * @exception java.lang.IllegalArgumentException if the <code>endMonth</code>, <code>endDay</code>,
 * <code>endDayOfWeek</code>, or <code>endTime</code> parameters are out of range
 * @apiSince 1
 */

public void setEndRule(int endMonth, int endDay, int endDayOfWeek, int endTime) { throw new RuntimeException("Stub!"); }

/**
 * Sets the daylight saving time end rule to a fixed date within a month.
 * This method is equivalent to:
 * <pre><code>setEndRule(endMonth, endDay, 0, endTime)</code></pre>
 *
 * @param endMonth        The daylight saving time ending month. Month is
 *                        a {@link java.util.Calendar#MONTH Calendar#MONTH} field
 *                        value (0-based. e.g., 9 for October).
 * @param endDay          The day of the month on which the daylight saving time ends.
 * @param endTime         The daylight saving ending time in local wall clock time,
 *                        (in milliseconds within the day) which is local daylight
 *                        time in this case.
 * @exception java.lang.IllegalArgumentException the <code>endMonth</code>, <code>endDay</code>,
 * or <code>endTime</code> parameters are out of range
 * @since 1.2
 * @apiSince 1
 */

public void setEndRule(int endMonth, int endDay, int endTime) { throw new RuntimeException("Stub!"); }

/**
 * Sets the daylight saving time end rule to a weekday before or after the given date within
 * a month, e.g., the first Monday on or after the 8th.
 *
 * @param endMonth        The daylight saving time ending month. Month is
 *                        a {@link java.util.Calendar#MONTH Calendar#MONTH} field
 *                        value (0-based. e.g., 9 for October).
 * @param endDay          The day of the month on which the daylight saving time ends.
 * @param endDayOfWeek    The daylight saving time ending day-of-week.
 * @param endTime         The daylight saving ending time in local wall clock time,
 *                        (in milliseconds within the day) which is local daylight
 *                        time in this case.
 * @param after           If true, this rule selects the first <code>endDayOfWeek</code> on
 *                        or <em>after</em> <code>endDay</code>.  If false, this rule
 *                        selects the last <code>endDayOfWeek</code> on or before
 *                        <code>endDay</code> of the month.
 * @exception java.lang.IllegalArgumentException the <code>endMonth</code>, <code>endDay</code>,
 * <code>endDayOfWeek</code>, or <code>endTime</code> parameters are out of range
 * @since 1.2
 * @apiSince 1
 */

public void setEndRule(int endMonth, int endDay, int endDayOfWeek, int endTime, boolean after) { throw new RuntimeException("Stub!"); }

/**
 * Returns the offset of this time zone from UTC at the given
 * time. If daylight saving time is in effect at the given time,
 * the offset value is adjusted with the amount of daylight
 * saving.
 *
 * @param date the time at which the time zone offset is found
 * @return the amount of time in milliseconds to add to UTC to get
 * local time.
 * @since 1.4
 * @apiSince 1
 */

public int getOffset(long date) { throw new RuntimeException("Stub!"); }

/**
 * Returns the difference in milliseconds between local time and
 * UTC, taking into account both the raw offset and the effect of
 * daylight saving, for the specified date and time.  This method
 * assumes that the start and end month are distinct.  It also
 * uses a default {@link java.util.GregorianCalendar GregorianCalendar} object as its
 * underlying calendar, such as for determining leap years.  Do
 * not use the result of this method with a calendar other than a
 * default <code>GregorianCalendar</code>.
 *
 * <p><em>Note:  In general, clients should use
 * <code>Calendar.get(ZONE_OFFSET) + Calendar.get(DST_OFFSET)</code>
 * instead of calling this method.</em>
 *
 * @param era       The era of the given date.
 * @param year      The year in the given date.
 * @param month     The month in the given date. Month is 0-based. e.g.,
 *                  0 for January.
 * @param day       The day-in-month of the given date.
 * @param dayOfWeek The day-of-week of the given date.
 * @param millis    The milliseconds in day in <em>standard</em> local time.
 * @return          The milliseconds to add to UTC to get local time.
 * @exception       java.lang.IllegalArgumentException the <code>era</code>,
 *                  <code>month</code>, <code>day</code>, <code>dayOfWeek</code>,
 *                  or <code>millis</code> parameters are out of range
 * @apiSince 1
 */

public int getOffset(int era, int year, int month, int day, int dayOfWeek, int millis) { throw new RuntimeException("Stub!"); }

/**
 * Gets the GMT offset for this time zone.
 * @return the GMT offset value in milliseconds
 * @see #setRawOffset
 * @apiSince 1
 */

public int getRawOffset() { throw new RuntimeException("Stub!"); }

/**
 * Sets the base time zone offset to GMT.
 * This is the offset to add to UTC to get local time.
 * @see #getRawOffset
 * @apiSince 1
 */

public void setRawOffset(int offsetMillis) { throw new RuntimeException("Stub!"); }

/**
 * Sets the amount of time in milliseconds that the clock is advanced
 * during daylight saving time.
 * @param millisSavedDuringDST the number of milliseconds the time is
 * advanced with respect to standard time when the daylight saving time rules
 * are in effect. A positive number, typically one hour (3600000).
 * @see #getDSTSavings
 * @since 1.2
 * @apiSince 1
 */

public void setDSTSavings(int millisSavedDuringDST) { throw new RuntimeException("Stub!"); }

/**
 * Returns the amount of time in milliseconds that the clock is
 * advanced during daylight saving time.
 *
 * @return the number of milliseconds the time is advanced with
 * respect to standard time when the daylight saving rules are in
 * effect, or 0 (zero) if this time zone doesn't observe daylight
 * saving time.
 *
 * @see #setDSTSavings
 * @since 1.2
 * @apiSince 1
 */

public int getDSTSavings() { throw new RuntimeException("Stub!"); }

/**
 * Queries if this time zone uses daylight saving time.
 * @return true if this time zone uses daylight saving time;
 * false otherwise.
 * @apiSince 1
 */

public boolean useDaylightTime() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this {@code SimpleTimeZone} observes
 * Daylight Saving Time. This method is equivalent to {@link
 * #useDaylightTime()}.
 *
 * @return {@code true} if this {@code SimpleTimeZone} observes
 * Daylight Saving Time; {@code false} otherwise.
 * @since 1.7
 * @apiSince 24
 */

public boolean observesDaylightTime() { throw new RuntimeException("Stub!"); }

/**
 * Queries if the given date is in daylight saving time.
 * @return true if daylight saving time is in effective at the
 * given date; false otherwise.
 * @apiSince 1
 */

public boolean inDaylightTime(java.util.Date date) { throw new RuntimeException("Stub!"); }

/**
 * Returns a clone of this <code>SimpleTimeZone</code> instance.
 * @return a clone of this instance.
 * @apiSince 1
 */

public java.lang.Object clone() { throw new RuntimeException("Stub!"); }

/**
 * Generates the hash code for the SimpleDateFormat object.
 * @return the hash code for this object
 * @apiSince 1
 */

public synchronized int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Compares the equality of two <code>SimpleTimeZone</code> objects.
 *
 * @param obj  The <code>SimpleTimeZone</code> object to be compared with.
 * @return     True if the given <code>obj</code> is the same as this
 *             <code>SimpleTimeZone</code> object; false otherwise.
 * @apiSince 1
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Returns <code>true</code> if this zone has the same rules and offset as another zone.
 * @param other the TimeZone object to be compared with
 * @return <code>true</code> if the given zone is a SimpleTimeZone and has the
 * same rules and offset as this one
 * @since 1.2
 * @apiSince 1
 */

public boolean hasSameRules(java.util.TimeZone other) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of this time zone.
 * @return a string representation of this time zone.
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Constant for a mode of start or end time specified as standard time.
 * @since 1.4
 * @apiSince 1
 */

public static final int STANDARD_TIME = 1; // 0x1

/**
 * Constant for a mode of start or end time specified as UTC. European
 * Union rules are specified as UTC time, for example.
 * @since 1.4
 * @apiSince 1
 */

public static final int UTC_TIME = 2; // 0x2

/**
 * Constant for a mode of start or end time specified as wall clock
 * time.  Wall clock time is standard time for the onset rule, and
 * daylight time for the end rule.
 * @since 1.4
 * @apiSince 1
 */

public static final int WALL_TIME = 0; // 0x0
}

