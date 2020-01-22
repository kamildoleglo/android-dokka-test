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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

/**
 * Utility class for producing strings with formatted date/time.
 *
 * <p>Most callers should avoid supplying their own format strings to this
 * class' {@code format} methods and rely on the correctly localized ones
 * supplied by the system. This class' factory methods return
 * appropriately-localized {@link java.text.DateFormat} instances, suitable
 * for both formatting and parsing dates. For the canonical documentation
 * of format strings, see {@link java.text.SimpleDateFormat}.
 *
 * <p>In cases where the system does not provide a suitable pattern,
 * this class offers the {@link #getBestDateTimePattern} method.
 *
 * <p>The {@code format} methods in this class implement a subset of Unicode
 * <a href="http://www.unicode.org/reports/tr35/#Date_Format_Patterns">UTS #35</a> patterns.
 * The subset currently supported by this class includes the following format characters:
 * {@code acdEHhLKkLMmsyz}. Up to API level 17, only {@code adEhkMmszy} were supported.
 * Note that this class incorrectly implements {@code k} as if it were {@code H} for backwards
 * compatibility.
 *
 * <p>See {@link java.text.SimpleDateFormat} for more documentation
 * about patterns, or if you need a more complete or correct implementation.
 * Note that the non-{@code format} methods in this class are implemented by
 * {@code SimpleDateFormat}.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DateFormat {

public DateFormat() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if times should be formatted as 24 hour times, false if times should be
 * formatted as 12 hour (AM/PM) times. Based on the user's chosen locale and other preferences.
 * @param context the context to use for the content resolver
 * @return true if 24 hour time format is selected, false otherwise.
 * @apiSince 3
 */

public static boolean is24HourFormat(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Returns the best possible localized form of the given skeleton for the given
 * locale. A skeleton is similar to, and uses the same format characters as, a Unicode
 * <a href="http://www.unicode.org/reports/tr35/#Date_Format_Patterns">UTS #35</a>
 * pattern.
 *
 * <p>One difference is that order is irrelevant. For example, "MMMMd" will return
 * "MMMM d" in the {@code en_US} locale, but "d. MMMM" in the {@code de_CH} locale.
 *
 * <p>Note also in that second example that the necessary punctuation for German was
 * added. For the same input in {@code es_ES}, we'd have even more extra text:
 * "d 'de' MMMM".
 *
 * <p>This method will automatically correct for grammatical necessity. Given the
 * same "MMMMd" input, this method will return "d LLLL" in the {@code fa_IR} locale,
 * where stand-alone months are necessary. Lengths are preserved where meaningful,
 * so "Md" would give a different result to "MMMd", say, except in a locale such as
 * {@code ja_JP} where there is only one length of month.
 *
 * <p>This method will only return patterns that are in CLDR, and is useful whenever
 * you know what elements you want in your format string but don't want to make your
 * code specific to any one locale.
 *
 * @param locale the locale into which the skeleton should be localized
 * @param skeleton a skeleton as described above
 * @return a string pattern suitable for use with {@link java.text.SimpleDateFormat}.
 * @apiSince 18
 */

public static java.lang.String getBestDateTimePattern(java.util.Locale locale, java.lang.String skeleton) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.text.DateFormat} object that can format the time according
 * to the context's locale and the user's 12-/24-hour clock preference.
 * @param context the application context
 * @return the {@link java.text.DateFormat} object that properly formats the time.
 * @apiSince 3
 */

public static java.text.DateFormat getTimeFormat(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.text.DateFormat} object that can format the date
 * in short form according to the context's locale.
 *
 * @param context the application context
 * @return the {@link java.text.DateFormat} object that properly formats the date.
 * @apiSince 3
 */

public static java.text.DateFormat getDateFormat(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.text.DateFormat} object that can format the date
 * in long form (such as {@code Monday, January 3, 2000}) for the context's locale.
 * @param context the application context
 * @return the {@link java.text.DateFormat} object that formats the date in long form.
 * @apiSince 3
 */

public static java.text.DateFormat getLongDateFormat(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.text.DateFormat} object that can format the date
 * in medium form (such as {@code Jan 3, 2000}) for the context's locale.
 * @param context the application context
 * @return the {@link java.text.DateFormat} object that formats the date in long form.
 * @apiSince 3
 */

public static java.text.DateFormat getMediumDateFormat(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Gets the current date format stored as a char array. Returns a 3 element
 * array containing the day ({@code 'd'}), month ({@code 'M'}), and year ({@code 'y'}))
 * in the order specified by the user's format preference.  Note that this order is
 * <i>only</i> appropriate for all-numeric dates; spelled-out (MEDIUM and LONG)
 * dates will generally contain other punctuation, spaces, or words,
 * not just the day, month, and year, and not necessarily in the same
 * order returned here.
 * @apiSince 3
 */

public static char[] getDateFormatOrder(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Given a format string and a time in milliseconds since Jan 1, 1970 GMT, returns a
 * CharSequence containing the requested date.
 * @param inFormat the format string, as described in {@link android.text.format.DateFormat}
 * @param inTimeInMillis in milliseconds since Jan 1, 1970 GMT
 * @return a {@link java.lang.CharSequence CharSequence} containing the requested text
 * @apiSince 3
 */

public static java.lang.CharSequence format(java.lang.CharSequence inFormat, long inTimeInMillis) { throw new RuntimeException("Stub!"); }

/**
 * Given a format string and a {@link java.util.Date} object, returns a CharSequence containing
 * the requested date.
 * @param inFormat the format string, as described in {@link android.text.format.DateFormat}
 * @param inDate the date to format
 * @return a {@link java.lang.CharSequence CharSequence} containing the requested text
 * @apiSince 3
 */

public static java.lang.CharSequence format(java.lang.CharSequence inFormat, java.util.Date inDate) { throw new RuntimeException("Stub!"); }

/**
 * Given a format string and a {@link java.util.Calendar} object, returns a CharSequence
 * containing the requested date.
 * @param inFormat the format string, as described in {@link android.text.format.DateFormat}
 * @param inDate the date to format
 * @return a {@link java.lang.CharSequence CharSequence} containing the requested text
 * @apiSince 3
 */

public static java.lang.CharSequence format(java.lang.CharSequence inFormat, java.util.Calendar inDate) { throw new RuntimeException("Stub!"); }
}

