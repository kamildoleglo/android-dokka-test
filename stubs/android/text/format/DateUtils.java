/*
 * Copyright (C) 2006 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package android.text.format;

import java.util.Calendar;
import android.content.Context;
import java.util.Formatter;

/**
 * This class contains various date-related utilities for creating text for things like
 * elapsed time and date ranges, strings for days of the week and months, and AM/PM text etc.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DateUtils {

public DateUtils() { throw new RuntimeException("Stub!"); }

/**
 * Return a string for the day of the week.
 * @param dayOfWeek One of {@link java.util.Calendar#SUNDAY Calendar#SUNDAY},
 *               {@link java.util.Calendar#MONDAY Calendar#MONDAY}, etc.
 * @param abbrev One of {@link #LENGTH_LONG}, {@link #LENGTH_SHORT},
 *               {@link #LENGTH_MEDIUM}, or {@link #LENGTH_SHORTEST}.
 *               Note that in most languages, {@link #LENGTH_SHORT}
 *               will return the same as {@link #LENGTH_MEDIUM}.
 *               Undefined lengths will return {@link #LENGTH_MEDIUM}
 *               but may return something different in the future.
 * @throws java.lang.IndexOutOfBoundsException if the dayOfWeek is out of bounds.
 * @deprecated Use {@link java.text.SimpleDateFormat} instead.
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated
public static java.lang.String getDayOfWeekString(int dayOfWeek, int abbrev) { throw new RuntimeException("Stub!"); }

/**
 * Return a localized string for AM or PM.
 * @param ampm Either {@link java.util.Calendar#AM Calendar#AM} or {@link java.util.Calendar#PM Calendar#PM}.
 * @throws java.lang.IndexOutOfBoundsException if the ampm is out of bounds.
 * @return Localized version of "AM" or "PM".
 * @deprecated Use {@link java.text.SimpleDateFormat} instead.
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated
public static java.lang.String getAMPMString(int ampm) { throw new RuntimeException("Stub!"); }

/**
 * Return a localized string for the month of the year.
 * @param month One of {@link java.util.Calendar#JANUARY Calendar#JANUARY},
 *               {@link java.util.Calendar#FEBRUARY Calendar#FEBRUARY}, etc.
 * @param abbrev One of {@link #LENGTH_LONG}, {@link #LENGTH_MEDIUM},
 *               or {@link #LENGTH_SHORTEST}.
 *               Undefined lengths will return {@link #LENGTH_MEDIUM}
 *               but may return something different in the future.
 * @return Localized month of the year.
 * @deprecated Use {@link java.text.SimpleDateFormat} instead.
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated
public static java.lang.String getMonthString(int month, int abbrev) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string describing the elapsed time since startTime.
 * <p>
 * The minimum timespan to report is set to {@link #MINUTE_IN_MILLIS}.
 * @param startTime some time in the past.
 * @return a String object containing the elapsed time.
 * @see #getRelativeTimeSpanString(long, long, long)
 * @apiSince 3
 */

public static java.lang.CharSequence getRelativeTimeSpanString(long startTime) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string describing 'time' as a time relative to 'now'.
 * <p>
 * Time spans in the past are formatted like "42 minutes ago".
 * Time spans in the future are formatted like "In 42 minutes".
 *
 * @param time the time to describe, in milliseconds
 * @param now the current time in milliseconds
 * @param minResolution the minimum timespan to report. For example, a time 3 seconds in the
 *     past will be reported as "0 minutes ago" if this is set to MINUTE_IN_MILLIS. Pass one of
 *     0, MINUTE_IN_MILLIS, HOUR_IN_MILLIS, DAY_IN_MILLIS, WEEK_IN_MILLIS
 * @apiSince 3
 */

public static java.lang.CharSequence getRelativeTimeSpanString(long time, long now, long minResolution) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string describing 'time' as a time relative to 'now'.
 * <p>
 * Time spans in the past are formatted like "42 minutes ago". Time spans in
 * the future are formatted like "In 42 minutes".
 * <p>
 * Can use {@link #FORMAT_ABBREV_RELATIVE} flag to use abbreviated relative
 * times, like "42 mins ago".
 *
 * @param time the time to describe, in milliseconds
 * @param now the current time in milliseconds
 * @param minResolution the minimum timespan to report. For example, a time
 *            3 seconds in the past will be reported as "0 minutes ago" if
 *            this is set to MINUTE_IN_MILLIS. Pass one of 0,
 *            MINUTE_IN_MILLIS, HOUR_IN_MILLIS, DAY_IN_MILLIS,
 *            WEEK_IN_MILLIS
 * @param flags a bit mask of formatting options, such as
 *            {@link #FORMAT_NUMERIC_DATE} or
 *            {@link #FORMAT_ABBREV_RELATIVE}
 * @apiSince 3
 */

public static java.lang.CharSequence getRelativeTimeSpanString(long time, long now, long minResolution, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Return string describing the elapsed time since startTime formatted like
 * "[relative time/date], [time]".
 * <p>
 * Example output strings for the US date format.
 * <ul>
 * <li>3 min. ago, 10:15 AM</li>
 * <li>Yesterday, 12:20 PM</li>
 * <li>Dec 12, 4:12 AM</li>
 * <li>11/14/2007, 8:20 AM</li>
 * </ul>
 *
 * @param time some time in the past.
 * @param minResolution the minimum elapsed time (in milliseconds) to report
 *            when showing relative times. For example, a time 3 seconds in
 *            the past will be reported as "0 minutes ago" if this is set to
 *            {@link #MINUTE_IN_MILLIS}.
 * @param transitionResolution the elapsed time (in milliseconds) at which
 *            to stop reporting relative measurements. Elapsed times greater
 *            than this resolution will default to normal date formatting.
 *            For example, will transition from "7 days ago" to "Dec 12"
 *            when using {@link #WEEK_IN_MILLIS}.
 * @apiSince 3
 */

public static java.lang.CharSequence getRelativeDateTimeString(android.content.Context c, long time, long minResolution, long transitionResolution, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Formats an elapsed time in the form "MM:SS" or "H:MM:SS"
 * for display on the call-in-progress screen.
 * @param elapsedSeconds the elapsed time in seconds.
 * @apiSince 3
 */

public static java.lang.String formatElapsedTime(long elapsedSeconds) { throw new RuntimeException("Stub!"); }

/**
 * Formats an elapsed time in a format like "MM:SS" or "H:MM:SS" (using a form
 * suited to the current locale), similar to that used on the call-in-progress
 * screen.
 *
 * @param recycle {@link java.lang.StringBuilder StringBuilder} to recycle, or null to use a temporary one.
 * @param elapsedSeconds the elapsed time in seconds.
 * @apiSince 3
 */

public static java.lang.String formatElapsedTime(java.lang.StringBuilder recycle, long elapsedSeconds) { throw new RuntimeException("Stub!"); }

/**
 * Format a date / time such that if the then is on the same day as now, it shows
 * just the time and if it's a different day, it shows just the date.
 *
 * <p>The parameters dateFormat and timeFormat should each be one of
 * {@link java.text.DateFormat#DEFAULT},
 * {@link java.text.DateFormat#FULL},
 * {@link java.text.DateFormat#LONG},
 * {@link java.text.DateFormat#MEDIUM}
 * or
 * {@link java.text.DateFormat#SHORT}
 *
 * @param then the date to format
 * @param now the base time
 * @param dateStyle how to format the date portion.
 * @param timeStyle how to format the time portion.
 * @apiSince 3
 */

public static final java.lang.CharSequence formatSameDayTime(long then, long now, int dateStyle, int timeStyle) { throw new RuntimeException("Stub!"); }

/**
 * @return true if the supplied when is today else false
 * @apiSince 3
 */

public static boolean isToday(long when) { throw new RuntimeException("Stub!"); }

/**
 * Formats a date or a time range according to the local conventions.
 * <p>
 * Note that this is a convenience method. Using it involves creating an
 * internal {@link java.util.Formatter} instance on-the-fly, which is
 * somewhat costly in terms of memory and time. This is probably acceptable
 * if you use the method only rarely, but if you rely on it for formatting a
 * large number of dates, consider creating and reusing your own
 * {@link java.util.Formatter} instance and use the version of
 * {@link #formatDateRange(android.content.Context,long,long,int) formatDateRange}
 * that takes a {@link java.util.Formatter}.
 *
 * @param context the context is required only if the time is shown
 * @param startMillis the start time in UTC milliseconds
 * @param endMillis the end time in UTC milliseconds
 * @param flags a bit mask of options See
 * {@link #formatDateRange(android.content.Context,java.util.Formatter,long,long,int,java.lang.String) formatDateRange}
 * @return a string containing the formatted date/time range.
 * @apiSince 3
 */

public static java.lang.String formatDateRange(android.content.Context context, long startMillis, long endMillis, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Formats a date or a time range according to the local conventions.
 * <p>
 * Note that this is a convenience method for formatting the date or
 * time range in the local time zone. If you want to specify the time
 * zone please use
 * {@link #formatDateRange(android.content.Context,java.util.Formatter,long,long,int,java.lang.String) formatDateRange}.
 *
 * @param context the context is required only if the time is shown
 * @param formatter the Formatter used for formatting the date range.
 * Note: be sure to call setLength(0) on StringBuilder passed to
 * the Formatter constructor unless you want the results to accumulate.
 * @param startMillis the start time in UTC milliseconds
 * @param endMillis the end time in UTC milliseconds
 * @param flags a bit mask of options See
 * {@link #formatDateRange(android.content.Context,java.util.Formatter,long,long,int,java.lang.String) formatDateRange}
 * @return a string containing the formatted date/time range.
 * @apiSince 5
 */

public static java.util.Formatter formatDateRange(android.content.Context context, java.util.Formatter formatter, long startMillis, long endMillis, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Formats a date or a time range according to the local conventions.
 *
 * <p>
 * Example output strings (date formats in these examples are shown using
 * the US date format convention but that may change depending on the
 * local settings):
 * <ul>
 *   <li>10:15am</li>
 *   <li>3:00pm - 4:00pm</li>
 *   <li>3pm - 4pm</li>
 *   <li>3PM - 4PM</li>
 *   <li>08:00 - 17:00</li>
 *   <li>Oct 9</li>
 *   <li>Tue, Oct 9</li>
 *   <li>October 9, 2007</li>
 *   <li>Oct 9 - 10</li>
 *   <li>Oct 9 - 10, 2007</li>
 *   <li>Oct 28 - Nov 3, 2007</li>
 *   <li>Dec 31, 2007 - Jan 1, 2008</li>
 *   <li>Oct 9, 8:00am - Oct 10, 5:00pm</li>
 *   <li>12/31/2007 - 01/01/2008</li>
 * </ul>
 *
 * <p>
 * The flags argument is a bitmask of options from the following list:
 *
 * <ul>
 *   <li>FORMAT_SHOW_TIME</li>
 *   <li>FORMAT_SHOW_WEEKDAY</li>
 *   <li>FORMAT_SHOW_YEAR</li>
 *   <li>FORMAT_SHOW_DATE</li>
 *   <li>FORMAT_NO_MONTH_DAY</li>
 *   <li>FORMAT_12HOUR</li>
 *   <li>FORMAT_24HOUR</li>
 *   <li>FORMAT_CAP_AMPM</li>
 *   <li>FORMAT_NO_NOON</li>
 *   <li>FORMAT_CAP_NOON</li>
 *   <li>FORMAT_NO_MIDNIGHT</li>
 *   <li>FORMAT_CAP_MIDNIGHT</li>
 *   <li>FORMAT_UTC</li>
 *   <li>FORMAT_ABBREV_TIME</li>
 *   <li>FORMAT_ABBREV_WEEKDAY</li>
 *   <li>FORMAT_ABBREV_MONTH</li>
 *   <li>FORMAT_ABBREV_ALL</li>
 *   <li>FORMAT_NUMERIC_DATE</li>
 * </ul>
 *
 * <p>
 * If FORMAT_SHOW_TIME is set, the time is shown as part of the date range.
 * If the start and end time are the same, then just the start time is
 * shown.
 *
 * <p>
 * If FORMAT_SHOW_WEEKDAY is set, then the weekday is shown.
 *
 * <p>
 * If FORMAT_SHOW_YEAR is set, then the year is always shown.
 * If FORMAT_SHOW_YEAR is not set, then the year
 * is shown only if it is different from the current year, or if the start
 * and end dates fall on different years.
 *
 * <p>
 * Normally the date is shown unless the start and end day are the same.
 * If FORMAT_SHOW_DATE is set, then the date is always shown, even for
 * same day ranges.
 *
 * <p>
 * If FORMAT_NO_MONTH_DAY is set, then if the date is shown, just the
 * month name will be shown, not the day of the month.  For example,
 * "January, 2008" instead of "January 6 - 12, 2008".
 *
 * <p>
 * If FORMAT_CAP_AMPM is set and 12-hour time is used, then the "AM"
 * and "PM" are capitalized.  You should not use this flag
 * because in some locales these terms cannot be capitalized, and in
 * many others it doesn't make sense to do so even though it is possible.
 *
 * <p>
 * If FORMAT_NO_NOON is set and 12-hour time is used, then "12pm" is
 * shown instead of "noon".
 *
 * <p>
 * If FORMAT_CAP_NOON is set and 12-hour time is used, then "Noon" is
 * shown instead of "noon".  You should probably not use this flag
 * because in many locales it will not make sense to capitalize
 * the term.
 *
 * <p>
 * If FORMAT_NO_MIDNIGHT is set and 12-hour time is used, then "12am" is
 * shown instead of "midnight".
 *
 * <p>
 * If FORMAT_CAP_MIDNIGHT is set and 12-hour time is used, then "Midnight"
 * is shown instead of "midnight".  You should probably not use this
 * flag because in many locales it will not make sense to capitalize
 * the term.
 *
 * <p>
 * If FORMAT_12HOUR is set and the time is shown, then the time is
 * shown in the 12-hour time format. You should not normally set this.
 * Instead, let the time format be chosen automatically according to the
 * system settings. If both FORMAT_12HOUR and FORMAT_24HOUR are set, then
 * FORMAT_24HOUR takes precedence.
 *
 * <p>
 * If FORMAT_24HOUR is set and the time is shown, then the time is
 * shown in the 24-hour time format. You should not normally set this.
 * Instead, let the time format be chosen automatically according to the
 * system settings. If both FORMAT_12HOUR and FORMAT_24HOUR are set, then
 * FORMAT_24HOUR takes precedence.
 *
 * <p>
 * If FORMAT_UTC is set, then the UTC time zone is used for the start
 * and end milliseconds unless a time zone is specified. If a time zone
 * is specified it will be used regardless of the FORMAT_UTC flag.
 *
 * <p>
 * If FORMAT_ABBREV_TIME is set and 12-hour time format is used, then the
 * start and end times (if shown) are abbreviated by not showing the minutes
 * if they are zero.  For example, instead of "3:00pm" the time would be
 * abbreviated to "3pm".
 *
 * <p>
 * If FORMAT_ABBREV_WEEKDAY is set, then the weekday (if shown) is
 * abbreviated to a 3-letter string.
 *
 * <p>
 * If FORMAT_ABBREV_MONTH is set, then the month (if shown) is abbreviated
 * to a 3-letter string.
 *
 * <p>
 * If FORMAT_ABBREV_ALL is set, then the weekday and the month (if shown)
 * are abbreviated to 3-letter strings.
 *
 * <p>
 * If FORMAT_NUMERIC_DATE is set, then the date is shown in numeric format
 * instead of using the name of the month.  For example, "12/31/2008"
 * instead of "December 31, 2008".
 *
 * <p>
 * If the end date ends at 12:00am at the beginning of a day, it is
 * formatted as the end of the previous day in two scenarios:
 * <ul>
 *   <li>For single day events. This results in "8pm - midnight" instead of
 *       "Nov 10, 8pm - Nov 11, 12am".</li>
 *   <li>When the time is not displayed. This results in "Nov 10 - 11" for
 *       an event with a start date of Nov 10 and an end date of Nov 12 at
 *       00:00.</li>
 * </ul>
 *
 * @param context the context is required only if the time is shown
 * @param formatter the Formatter used for formatting the date range.
 * Note: be sure to call setLength(0) on StringBuilder passed to
 * the Formatter constructor unless you want the results to accumulate.
 * @param startMillis the start time in UTC milliseconds
 * @param endMillis the end time in UTC milliseconds
 * @param flags a bit mask of options
 * @param timeZone the time zone to compute the string in. Use null for local
 * or if the FORMAT_UTC flag is being used.
 *
 * @return the formatter with the formatted date/time range appended to the string buffer.
 * @apiSince 9
 */

public static java.util.Formatter formatDateRange(android.content.Context context, java.util.Formatter formatter, long startMillis, long endMillis, int flags, java.lang.String timeZone) { throw new RuntimeException("Stub!"); }

/**
 * Formats a date or a time according to the local conventions. There are
 * lots of options that allow the caller to control, for example, if the
 * time is shown, if the day of the week is shown, if the month name is
 * abbreviated, if noon is shown instead of 12pm, and so on. For the
 * complete list of options, see the documentation for
 * {@link #formatDateRange}.
 * <p>
 * Example output strings (date formats in these examples are shown using
 * the US date format convention but that may change depending on the
 * local settings):
 * <ul>
 *   <li>10:15am</li>
 *   <li>3:00pm</li>
 *   <li>3pm</li>
 *   <li>3PM</li>
 *   <li>08:00</li>
 *   <li>17:00</li>
 *   <li>noon</li>
 *   <li>Noon</li>
 *   <li>midnight</li>
 *   <li>Midnight</li>
 *   <li>Oct 31</li>
 *   <li>Oct 31, 2007</li>
 *   <li>October 31, 2007</li>
 *   <li>10am, Oct 31</li>
 *   <li>17:00, Oct 31</li>
 *   <li>Wed</li>
 *   <li>Wednesday</li>
 *   <li>10am, Wed, Oct 31</li>
 *   <li>Wed, Oct 31</li>
 *   <li>Wednesday, Oct 31</li>
 *   <li>Wed, Oct 31, 2007</li>
 *   <li>Wed, October 31</li>
 *   <li>10/31/2007</li>
 * </ul>
 *
 * @param context the context is required only if the time is shown
 * @param millis a point in time in UTC milliseconds
 * @param flags a bit mask of formatting options
 * @return a string containing the formatted date/time.
 * @apiSince 3
 */

public static java.lang.String formatDateTime(android.content.Context context, long millis, int flags) { throw new RuntimeException("Stub!"); }

/**
 * @return a relative time string to display the time expressed by millis.  Times
 * are counted starting at midnight, which means that assuming that the current
 * time is March 31st, 0:30:
 * <ul>
 *   <li>"millis=0:10 today" will be displayed as "0:10"</li>
 *   <li>"millis=11:30pm the day before" will be displayed as "Mar 30"</li>
 * </ul>
 * If the given millis is in a different year, then the full date is
 * returned in numeric format (e.g., "10/12/2008").
 *
 * @param withPreposition If true, the string returned will include the correct
 * preposition ("at 9:20am", "on 10/12/2008" or "on May 29").
 * @apiSince 3
 */

public static java.lang.CharSequence getRelativeTimeSpanString(android.content.Context c, long millis, boolean withPreposition) { throw new RuntimeException("Stub!"); }

/**
 * Convenience function to return relative time string without preposition.
 * @param c context for resources
 * @param millis time in milliseconds
 * @return {@link java.lang.CharSequence CharSequence} containing relative time.
 * @see #getRelativeTimeSpanString(Context, long, boolean)
 * @apiSince 3
 */

public static java.lang.CharSequence getRelativeTimeSpanString(android.content.Context c, long millis) { throw new RuntimeException("Stub!"); }

/**
 * This is not actually a useful month name in all locales.
 * @deprecated Use {@link java.text.SimpleDateFormat} instead.
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String ABBREV_MONTH_FORMAT = "%b";

/** @apiSince 3 */

public static final java.lang.String ABBREV_WEEKDAY_FORMAT = "%a";

/** @apiSince 3 */

public static final long DAY_IN_MILLIS = 86400000L; // 0x5265c00L

/**
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final int FORMAT_12HOUR = 64; // 0x40

/**
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final int FORMAT_24HOUR = 128; // 0x80

/** @apiSince 3 */

public static final int FORMAT_ABBREV_ALL = 524288; // 0x80000

/** @apiSince 3 */

public static final int FORMAT_ABBREV_MONTH = 65536; // 0x10000

/** @apiSince 3 */

public static final int FORMAT_ABBREV_RELATIVE = 262144; // 0x40000

/** @apiSince 3 */

public static final int FORMAT_ABBREV_TIME = 16384; // 0x4000

/** @apiSince 3 */

public static final int FORMAT_ABBREV_WEEKDAY = 32768; // 0x8000

/**
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final int FORMAT_CAP_AMPM = 256; // 0x100

/**
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final int FORMAT_CAP_MIDNIGHT = 4096; // 0x1000

/**
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final int FORMAT_CAP_NOON = 1024; // 0x400

/**
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final int FORMAT_CAP_NOON_MIDNIGHT = 5120; // 0x1400

/** @apiSince 3 */

public static final int FORMAT_NO_MIDNIGHT = 2048; // 0x800

/** @apiSince 3 */

public static final int FORMAT_NO_MONTH_DAY = 32; // 0x20

/** @apiSince 3 */

public static final int FORMAT_NO_NOON = 512; // 0x200

/**
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final int FORMAT_NO_NOON_MIDNIGHT = 2560; // 0xa00

/** @apiSince 3 */

public static final int FORMAT_NO_YEAR = 8; // 0x8

/** @apiSince 3 */

public static final int FORMAT_NUMERIC_DATE = 131072; // 0x20000

/** @apiSince 3 */

public static final int FORMAT_SHOW_DATE = 16; // 0x10

/** @apiSince 3 */

public static final int FORMAT_SHOW_TIME = 1; // 0x1

/** @apiSince 3 */

public static final int FORMAT_SHOW_WEEKDAY = 2; // 0x2

/** @apiSince 3 */

public static final int FORMAT_SHOW_YEAR = 4; // 0x4

/**
 * @deprecated Use
 * {@link #formatDateRange(android.content.Context,java.util.Formatter,long,long,int,java.lang.String) formatDateRange}
 * and pass in {@link android.text.format.Time#TIMEZONE_UTC Time#TIMEZONE_UTC} for the timeZone instead.
 * @apiSince 3
 * @deprecatedSince 15
 */

@Deprecated public static final int FORMAT_UTC = 8192; // 0x2000

/** @apiSince 3 */

public static final long HOUR_IN_MILLIS = 3600000L; // 0x36ee80L

/**
 * This is not actually the preferred 24-hour date format in all locales.
 * @deprecated Use {@link java.text.SimpleDateFormat} instead.
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final java.lang.String HOUR_MINUTE_24 = "%H:%M";

/**
 * Request the full spelled-out name. For use with the 'abbrev' parameter of
 * {@link #getDayOfWeekString} and {@link #getMonthString}.
 *
 * @more <p>
 *       e.g. "Sunday" or "January"
 * @deprecated Use {@link java.text.SimpleDateFormat} instead.
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final int LENGTH_LONG = 10; // 0xa

/**
 * Request an abbreviated version of the name. For use with the 'abbrev'
 * parameter of {@link #getDayOfWeekString} and {@link #getMonthString}.
 *
 * @more <p>
 *       e.g. "Sun" or "Jan"
 * @deprecated Use {@link java.text.SimpleDateFormat} instead.
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final int LENGTH_MEDIUM = 20; // 0x14

/**
 * Request a shorter abbreviated version of the name.
 * For use with the 'abbrev' parameter of {@link #getDayOfWeekString} and {@link #getMonthString}.
 * @more
 * <p>e.g. "Su" or "Jan"
 * <p>In most languages, the results returned for LENGTH_SHORT will be the same as
 * the results returned for {@link #LENGTH_MEDIUM}.
 * @deprecated Use {@link java.text.SimpleDateFormat} instead.
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final int LENGTH_SHORT = 30; // 0x1e

/**
 * Request an even shorter abbreviated version of the name.
 * Do not use this.  Currently this will always return the same result
 * as {@link #LENGTH_SHORT}.
 * @deprecated Use {@link java.text.SimpleDateFormat} instead.
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final int LENGTH_SHORTER = 40; // 0x28

/**
 * Request an even shorter abbreviated version of the name.
 * For use with the 'abbrev' parameter of {@link #getDayOfWeekString} and {@link #getMonthString}.
 * @more
 * <p>e.g. "S", "T", "T" or "J"
 * <p>In some languages, the results returned for LENGTH_SHORTEST will be the same as
 * the results returned for {@link #LENGTH_SHORT}.
 * @deprecated Use {@link java.text.SimpleDateFormat} instead.
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final int LENGTH_SHORTEST = 50; // 0x32

/** @apiSince 3 */

public static final long MINUTE_IN_MILLIS = 60000L; // 0xea60L

/** @apiSince 3 */

public static final java.lang.String MONTH_DAY_FORMAT = "%-d";

/** @apiSince 3 */

public static final java.lang.String MONTH_FORMAT = "%B";

/** @apiSince 3 */

public static final java.lang.String NUMERIC_MONTH_FORMAT = "%m";

/** @apiSince 3 */

public static final long SECOND_IN_MILLIS = 1000L; // 0x3e8L

/** @apiSince 3 */

public static final java.lang.String WEEKDAY_FORMAT = "%A";

/** @apiSince 3 */

public static final long WEEK_IN_MILLIS = 604800000L; // 0x240c8400L

/** @apiSince 3 */

public static final java.lang.String YEAR_FORMAT = "%Y";

/** @apiSince 3 */

public static final java.lang.String YEAR_FORMAT_TWO_DIGITS = "%g";

/**
 * @deprecated Not all years have the same number of days, and this constant is actually the
 * length of 364 days. Please use other date/time constructs such as
 * {@link java.util.concurrent.TimeUnit}, {@link java.util.Calendar} or
 * {@link java.time.Duration} instead.
 * @apiSince 3
 * @deprecatedSince R
 */

@Deprecated public static final long YEAR_IN_MILLIS = 31449600000L; // 0x7528ad000L

/**
 * @deprecated Do not use.
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final int[] sameMonthTable;
static { sameMonthTable = new int[0]; }

/**
 * @deprecated Do not use.
 * @apiSince 3
 * @deprecatedSince 17
 */

@Deprecated public static final int[] sameYearTable;
static { sameYearTable = new int[0]; }
}

