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

import java.util.TimeZone;
import android.util.TimeFormatException;

/**
 * An alternative to the {@link java.util.Calendar} and
 * {@link java.util.GregorianCalendar} classes. An instance of the Time class represents
 * a moment in time, specified with second precision. It is modelled after
 * struct tm. This class is not thread-safe and does not consider leap seconds.
 *
 * <p>This class has a number of issues and it is recommended that
 * {@link java.util.GregorianCalendar} is used instead.
 *
 * <p>Known issues:
 * <ul>
 *     <li>For historical reasons when performing time calculations all arithmetic currently takes
 *     place using 32-bit integers. This limits the reliable time range representable from 1902
 *     until 2037.See the wikipedia article on the
 *     <a href="http://en.wikipedia.org/wiki/Year_2038_problem">Year 2038 problem</a> for details.
 *     Do not rely on this behavior; it may change in the future.
 *     </li>
 *     <li>Calling {@link #switchTimezone(java.lang.String)} on a date that cannot exist, such as a wall time
 *     that was skipped due to a DST transition, will result in a date in 1969 (i.e. -1, or 1 second
 *     before 1st Jan 1970 UTC).</li>
 *     <li>Much of the formatting / parsing assumes ASCII text and is therefore not suitable for
 *     use with non-ASCII scripts.</li>
 *     <li>No support for pseudo-zones like "GMT-07:00".</li>
 * </ul>
 *
 * @deprecated Use {@link java.util.GregorianCalendar} instead.
 * @apiSince 3
 * @deprecatedSince 22
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class Time {

/**
 * Construct a Time object in the timezone named by the string
 * argument "timezone". The time is initialized to Jan 1, 1970.
 * @param timezoneId string containing the timezone to use.
 * @see java.util.TimeZone
 * @apiSince 3
 */

@Deprecated
public Time(java.lang.String timezoneId) { throw new RuntimeException("Stub!"); }

/**
 * Construct a Time object in the default timezone. The time is initialized to
 * Jan 1, 1970.
 * @apiSince 3
 */

@Deprecated
public Time() { throw new RuntimeException("Stub!"); }

/**
 * A copy constructor.  Construct a Time object by copying the given
 * Time object.  No normalization occurs.
 *
 * @param other
 * @apiSince 3
 */

@Deprecated
public Time(android.text.format.Time other) { throw new RuntimeException("Stub!"); }

/**
 * Ensures the values in each field are in range. For example if the
 * current value of this calendar is March 32, normalize() will convert it
 * to April 1. It also fills in weekDay, yearDay, isDst and gmtoff.
 *
 * <p>
 * If "ignoreDst" is true, then this method sets the "isDst" field to -1
 * (the "unknown" value) before normalizing.  It then computes the
 * time in milliseconds and sets the correct value for "isDst" if the
 * fields resolve to a valid date / time.
 *
 * <p>
 * See {@link #toMillis(boolean)} for more information about when to
 * use <tt>true</tt> or <tt>false</tt> for "ignoreDst" and when {@code -1}
 * might be returned.
 *
 * @return the UTC milliseconds since the epoch, or {@code -1}
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated
public long normalize(boolean ignoreDst) { throw new RuntimeException("Stub!"); }

/**
 * Convert this time object so the time represented remains the same, but is
 * instead located in a different timezone. This method automatically calls
 * normalize() in some cases.
 *
 * <p>This method can return incorrect results if the date / time cannot be normalized.
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated
public void switchTimezone(java.lang.String timezone) { throw new RuntimeException("Stub!"); }

/**
 * Return the maximum possible value for the given field given the value of
 * the other fields. Requires that it be normalized for MONTH_DAY and
 * YEAR_DAY.
 * @param field one of the constants for HOUR, MINUTE, SECOND, etc.
 * @return the maximum value for the field.
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated
public int getActualMaximum(int field) { throw new RuntimeException("Stub!"); }

/**
 * Clears all values, setting the timezone to the given timezone. Sets isDst
 * to a negative value to mean "unknown".
 * @param timezoneId the timezone to use.
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated
public void clear(java.lang.String timezoneId) { throw new RuntimeException("Stub!"); }

/**
 * Compare two {@code Time} objects and return a negative number if {@code
 * a} is less than {@code b}, a positive number if {@code a} is greater than
 * {@code b}, or 0 if they are equal.
 *
 * <p>
 * This method can return an incorrect answer when the date / time fields of
 * either {@code Time} have been set to a local time that contradicts the
 * available timezone information.
 *
 * @param a first {@code Time} instance to compare
 * @param b second {@code Time} instance to compare
 * @throws java.lang.NullPointerException if either argument is {@code null}
 * @throws java.lang.IllegalArgumentException if {@link #allDay} is true but {@code
 *             hour}, {@code minute}, and {@code second} are not 0.
 * @return a negative result if {@code a} is earlier, a positive result if
 *         {@code b} is earlier, or 0 if they are equal.
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated
public static int compare(android.text.format.Time a, android.text.format.Time b) { throw new RuntimeException("Stub!"); }

/**
 * Print the current value given the format string provided. See man
 * strftime for what means what. The final string must be less than 256
 * characters.
 * @param format a string containing the desired format.
 * @return a String containing the current time expressed in the current locale.
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated
public java.lang.String format(java.lang.String format) { throw new RuntimeException("Stub!"); }

/**
 * Return the current time in YYYYMMDDTHHMMSS&lt;tz&gt; format
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated
public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Parses a date-time string in either the RFC 2445 format or an abbreviated
 * format that does not include the "time" field.  For example, all of the
 * following strings are valid:
 *
 * <ul>
 *   <li>"20081013T160000Z"</li>
 *   <li>"20081013T160000"</li>
 *   <li>"20081013"</li>
 * </ul>
 *
 * Returns whether or not the time is in UTC (ends with Z).  If the string
 * ends with "Z" then the timezone is set to UTC.  If the date-time string
 * included only a date and no time field, then the <code>allDay</code>
 * field of this Time class is set to true and the <code>hour</code>,
 * <code>minute</code>, and <code>second</code> fields are set to zero;
 * otherwise (a time field was included in the date-time string)
 * <code>allDay</code> is set to false. The fields <code>weekDay</code>,
 * <code>yearDay</code>, and <code>gmtoff</code> are always set to zero,
 * and the field <code>isDst</code> is set to -1 (unknown).  To set those
 * fields, call {@link #normalize(boolean)} after parsing.
 *
 * To parse a date-time string and convert it to UTC milliseconds, do
 * something like this:
 *
 * <pre>
 *   Time time = new Time();
 *   String date = "20081013T160000Z";
 *   time.parse(date);
 *   long millis = time.normalize(false);
 * </pre>
 *
 * @param s the string to parse
 * @return true if the resulting time value is in UTC time
 * @throws android.util.TimeFormatException if s cannot be parsed.
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated
public boolean parse(java.lang.String s) { throw new RuntimeException("Stub!"); }

/**
 * Parse a time in RFC 3339 format.  This method also parses simple dates
 * (that is, strings that contain no time or time offset).  For example,
 * all of the following strings are valid:
 *
 * <ul>
 *   <li>"2008-10-13T16:00:00.000Z"</li>
 *   <li>"2008-10-13T16:00:00.000+07:00"</li>
 *   <li>"2008-10-13T16:00:00.000-07:00"</li>
 *   <li>"2008-10-13"</li>
 * </ul>
 *
 * <p>
 * If the string contains a time and time offset, then the time offset will
 * be used to convert the time value to UTC.
 * </p>
 *
 * <p>
 * If the given string contains just a date (with no time field), then
 * the {@link #allDay} field is set to true and the {@link #hour},
 * {@link #minute}, and  {@link #second} fields are set to zero.
 * </p>
 *
 * <p>
 * Returns true if the resulting time value is in UTC time.
 * </p>
 *
 * @param s the string to parse
 * @return true if the resulting time value is in UTC time
 * @throws android.util.TimeFormatException if s cannot be parsed.
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated
public boolean parse3339(java.lang.String s) { throw new RuntimeException("Stub!"); }

/**
 * Returns the timezone string that is currently set for the device.
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated
public static java.lang.String getCurrentTimezone() { throw new RuntimeException("Stub!"); }

/**
 * Sets the time of the given Time object to the current time.
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated
public void setToNow() { throw new RuntimeException("Stub!"); }

/**
 * Converts this time to milliseconds. Suitable for interacting with the
 * standard java libraries. The time is in UTC milliseconds since the epoch.
 * This does an implicit normalization to compute the milliseconds but does
 * <em>not</em> change any of the fields in this Time object.  If you want
 * to normalize the fields in this Time object and also get the milliseconds
 * then use {@link #normalize(boolean)}.
 *
 * <p>
 * If "ignoreDst" is false, then this method uses the current setting of the
 * "isDst" field and will adjust the returned time if the "isDst" field is
 * wrong for the given time.  See the sample code below for an example of
 * this.
 *
 * <p>
 * If "ignoreDst" is true, then this method ignores the current setting of
 * the "isDst" field in this Time object and will instead figure out the
 * correct value of "isDst" (as best it can) from the fields in this
 * Time object.  The only case where this method cannot figure out the
 * correct value of the "isDst" field is when the time is inherently
 * ambiguous because it falls in the hour that is repeated when switching
 * from Daylight-Saving Time to Standard Time.
 *
 * <p>
 * Here is an example where <tt>toMillis(true)</tt> adjusts the time,
 * assuming that DST changes at 2am on Sunday, Nov 4, 2007.
 *
 * <pre>
 * Time time = new Time();
 * time.set(4, 10, 2007);  // set the date to Nov 4, 2007, 12am
 * time.normalize(false);       // this sets isDst = 1
 * time.monthDay += 1;     // changes the date to Nov 5, 2007, 12am
 * millis = time.toMillis(false);   // millis is Nov 4, 2007, 11pm
 * millis = time.toMillis(true);    // millis is Nov 5, 2007, 12am
 * </pre>
 *
 * <p>
 * To avoid this problem, use <tt>toMillis(true)</tt>
 * after adding or subtracting days or explicitly setting the "monthDay"
 * field.  On the other hand, if you are adding
 * or subtracting hours or minutes, then you should use
 * <tt>toMillis(false)</tt>.
 *
 * <p>
 * You should also use <tt>toMillis(false)</tt> if you want
 * to read back the same milliseconds that you set with {@link #set(long)}
 * or {@link #set(android.text.format.Time)} or after parsing a date string.
 *
 * <p>
 * This method can return {@code -1} when the date / time fields have been
 * set to a local time that conflicts with available timezone information.
 * For example, when daylight savings transitions cause an hour to be
 * skipped: times within that hour will return {@code -1} if isDst =
 * {@code -1}.
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated
public long toMillis(boolean ignoreDst) { throw new RuntimeException("Stub!"); }

/**
 * Sets the fields in this Time object given the UTC milliseconds.  After
 * this method returns, all the fields are normalized.
 * This also sets the "isDst" field to the correct value.
 *
 * @param millis the time in UTC milliseconds since the epoch.
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated
public void set(long millis) { throw new RuntimeException("Stub!"); }

/**
 * Format according to RFC 2445 DATE-TIME type.
 *
 * <p>The same as format("%Y%m%dT%H%M%S"), or format("%Y%m%dT%H%M%SZ") for a Time with a
 * timezone set to "UTC".
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated
public java.lang.String format2445() { throw new RuntimeException("Stub!"); }

/**
 * Copy the value of that to this Time object. No normalization happens.
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated
public void set(android.text.format.Time that) { throw new RuntimeException("Stub!"); }

/**
 * Sets the fields. Sets weekDay, yearDay and gmtoff to 0, and isDst to -1.
 * Call {@link #normalize(boolean)} if you need those.
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated
public void set(int second, int minute, int hour, int monthDay, int month, int year) { throw new RuntimeException("Stub!"); }

/**
 * Sets the date from the given fields.  Also sets allDay to true.
 * Sets weekDay, yearDay and gmtoff to 0, and isDst to -1.
 * Call {@link #normalize(boolean)} if you need those.
 *
 * @param monthDay the day of the month (in the range [1,31])
 * @param month the zero-based month number (in the range [0,11])
 * @param year the year
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated
public void set(int monthDay, int month, int year) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the time represented by this Time object occurs before
 * the given time.
 *
 * <p>
 * Equivalent to {@code Time.compare(this, that) < 0}. See
 * {@link #compare(android.text.format.Time,android.text.format.Time)} for details.
 *
 * @param that a given Time object to compare against
 * @return true if this time is less than the given time
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated
public boolean before(android.text.format.Time that) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the time represented by this Time object occurs after
 * the given time.
 *
 * <p>
 * Equivalent to {@code Time.compare(this, that) > 0}. See
 * {@link #compare(android.text.format.Time,android.text.format.Time)} for details.
 *
 * @param that a given Time object to compare against
 * @return true if this time is greater than the given time
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated
public boolean after(android.text.format.Time that) { throw new RuntimeException("Stub!"); }

/**
 * Computes the week number according to ISO 8601.  The current Time
 * object must already be normalized because this method uses the
 * yearDay and weekDay fields.
 *
 * <p>
 * In IS0 8601, weeks start on Monday.
 * The first week of the year (week 1) is defined by ISO 8601 as the
 * first week with four or more of its days in the starting year.
 * Or equivalently, the week containing January 4.  Or equivalently,
 * the week with the year's first Thursday in it.
 * </p>
 *
 * <p>
 * The week number can be calculated by counting Thursdays.  Week N
 * contains the Nth Thursday of the year.
 * </p>
 *
 * @return the ISO week number.
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated
public int getWeekNumber() { throw new RuntimeException("Stub!"); }

/**
 * Return a string in the RFC 3339 format.
 * <p>
 * If allDay is true, expresses the time as Y-M-D</p>
 * <p>
 * Otherwise, if the timezone is UTC, expresses the time as Y-M-D-T-H-M-S UTC</p>
 * <p>
 * Otherwise the time is expressed the time as Y-M-D-T-H-M-S +- GMT</p>
 * @return string in the RFC 3339 format.
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated
public java.lang.String format3339(boolean allDay) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the day of the given time is the epoch on the Julian Calendar
 * (January 1, 1970 on the Gregorian calendar).
 *
 * <p>
 * This method can return an incorrect answer when the date / time fields have
 * been set to a local time that contradicts the available timezone information.
 *
 * @param time the time to test
 * @return true if epoch.
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated
public static boolean isEpoch(android.text.format.Time time) { throw new RuntimeException("Stub!"); }

/**
 * Computes the Julian day number for a point in time in a particular
 * timezone. The Julian day for a given date is the same for every
 * timezone. For example, the Julian day for July 1, 2008 is 2454649.
 *
 * <p>Callers must pass the time in UTC millisecond (as can be returned
 * by {@link #toMillis(boolean)} or {@link #normalize(boolean)})
 * and the offset from UTC of the timezone in seconds (as might be in
 * {@link #gmtoff}).
 *
 * <p>The Julian day is useful for testing if two events occur on the
 * same calendar date and for determining the relative time of an event
 * from the present ("yesterday", "3 days ago", etc.).
 *
 * @param millis the time in UTC milliseconds
 * @param gmtoff the offset from UTC in seconds
 * @return the Julian day
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated
public static int getJulianDay(long millis, long gmtoff) { throw new RuntimeException("Stub!"); }

/**
 * <p>Sets the time from the given Julian day number, which must be based on
 * the same timezone that is set in this Time object.  The "gmtoff" field
 * need not be initialized because the given Julian day may have a different
 * GMT offset than whatever is currently stored in this Time object anyway.
 * After this method returns all the fields will be normalized and the time
 * will be set to 12am at the beginning of the given Julian day.
 * </p>
 *
 * <p>
 * The only exception to this is if 12am does not exist for that day because
 * of daylight saving time.  For example, Cairo, Eqypt moves time ahead one
 * hour at 12am on April 25, 2008 and there are a few other places that
 * also change daylight saving time at 12am.  In those cases, the time
 * will be set to 1am.
 * </p>
 *
 * @param julianDay the Julian day in the timezone for this Time object
 * @return the UTC milliseconds for the beginning of the Julian day
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated
public long setJulianDay(int julianDay) { throw new RuntimeException("Stub!"); }

/**
 * Returns the week since {@link #EPOCH_JULIAN_DAY} (Jan 1, 1970) adjusted
 * for first day of week. This takes a julian day and the week start day and
 * calculates which week since {@link #EPOCH_JULIAN_DAY} that day occurs in,
 * starting at 0. *Do not* use this to compute the ISO week number for the
 * year.
 *
 * @param julianDay The julian day to calculate the week number for
 * @param firstDayOfWeek Which week day is the first day of the week, see
 *            {@link #SUNDAY}
 * @return Weeks since the epoch
 * @apiSince 11
 * @deprecatedSince 22
 */

@Deprecated
public static int getWeeksSinceEpochFromJulianDay(int julianDay, int firstDayOfWeek) { throw new RuntimeException("Stub!"); }

/**
 * Takes a number of weeks since the epoch and calculates the Julian day of
 * the Monday for that week. This assumes that the week containing the
 * {@link #EPOCH_JULIAN_DAY} is considered week 0. It returns the Julian day
 * for the Monday week weeks after the Monday of the week containing the
 * epoch.
 *
 * @param week Number of weeks since the epoch
 * @return The julian day for the Monday of the given week since the epoch
 * @apiSince 11
 * @deprecatedSince 22
 */

@Deprecated
public static int getJulianMondayFromWeeksSinceEpoch(int week) { throw new RuntimeException("Stub!"); }

/**
 * The Julian day of the epoch, that is, January 1, 1970 on the Gregorian
 * calendar.
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated public static final int EPOCH_JULIAN_DAY = 2440588; // 0x253d8c

/**
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated public static final int FRIDAY = 5; // 0x5

/**
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated public static final int HOUR = 3; // 0x3

/**
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated public static final int MINUTE = 2; // 0x2

/**
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated public static final int MONDAY = 1; // 0x1

/**
 * The Julian day of the Monday in the week of the epoch, December 29, 1969
 * on the Gregorian calendar.
 * @apiSince 11
 * @deprecatedSince 22
 */

@Deprecated public static final int MONDAY_BEFORE_JULIAN_EPOCH = 2440585; // 0x253d89

/**
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated public static final int MONTH = 5; // 0x5

/**
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated public static final int MONTH_DAY = 4; // 0x4

/**
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated public static final int SATURDAY = 6; // 0x6

/**
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated public static final int SECOND = 1; // 0x1

/**
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated public static final int SUNDAY = 0; // 0x0

/**
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated public static final int THURSDAY = 4; // 0x4

/**
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated public static final java.lang.String TIMEZONE_UTC = "UTC";

/**
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated public static final int TUESDAY = 2; // 0x2

/**
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated public static final int WEDNESDAY = 3; // 0x3

/**
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated public static final int WEEK_DAY = 7; // 0x7

/**
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated public static final int WEEK_NUM = 9; // 0x9

/**
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated public static final int YEAR = 6; // 0x6

/**
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated public static final int YEAR_DAY = 8; // 0x8

/**
 * True if this is an allDay event. The hour, minute, second fields are
 * all zero, and the date is displayed the same in all time zones.
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated public boolean allDay;

/**
 * Offset in seconds from UTC including any DST offset.
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated public long gmtoff;

/**
 * Hour of day [0-23]
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated public int hour;

/**
 * This time is in daylight savings time. One of:
 * <ul>
 * <li><b>positive</b> - in dst</li>
 * <li><b>0</b> - not in dst</li>
 * <li><b>negative</b> - unknown</li>
 * </ul>
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated public int isDst;

/**
 * Minute [0-59]
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated public int minute;

/**
 * Month [0-11]
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated public int month;

/**
 * Day of month [1-31]
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated public int monthDay;

/**
 * Seconds [0-61] (2 leap seconds allowed)
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated public int second;

/**
 * The timezone for this Time.  Should not be null.
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated public java.lang.String timezone;

/**
 * Day of week [0-6]
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated public int weekDay;

/**
 * Year. For example, 1970.
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated public int year;

/**
 * Day of year [0-365]
 * @apiSince 3
 * @deprecatedSince 22
 */

@Deprecated public int yearDay;
}

