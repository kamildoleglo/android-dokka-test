/* GENERATED SOURCE. DO NOT MODIFY. */
// © 2016 and later: Unicode, Inc. and others.
// License & terms of use: http://www.unicode.org/copyright.html#License
/*
 *******************************************************************************
 * Copyright (C) 2013-2016, International Business Machines Corporation and
 * others. All Rights Reserved.
 *******************************************************************************
 */

package android.icu.text;

import java.util.Locale;
import java.text.Format;

/**
 * Formats simple relative dates. There are two types of relative dates that
 * it handles:
 * <ul>
 *   <li>relative dates with a quantity e.g "in 5 days"</li>
 *   <li>relative dates without a quantity e.g "next Tuesday"</li>
 * </ul>
 * <p>
 * This API is very basic and is intended to be a building block for more
 * fancy APIs. The caller tells it exactly what to display in a locale
 * independent way. While this class automatically provides the correct plural
 * forms, the grammatical form is otherwise as neutral as possible. It is the
 * caller's responsibility to handle cut-off logic such as deciding between
 * displaying "in 7 days" or "in 1 week." This API supports relative dates
 * involving one single unit. This API does not support relative dates
 * involving compound units.
 * e.g "in 5 days and 4 hours" nor does it support parsing.
 * This class is both immutable and thread-safe.
 * <p>
 * Here are some examples of use:
 * <blockquote>
 * <pre>
 * RelativeDateTimeFormatter fmt = RelativeDateTimeFormatter.getInstance();
 * fmt.format(1, Direction.NEXT, RelativeUnit.DAYS); // "in 1 day"
 * fmt.format(3, Direction.NEXT, RelativeUnit.DAYS); // "in 3 days"
 * fmt.format(3.2, Direction.LAST, RelativeUnit.YEARS); // "3.2 years ago"
 *
 * fmt.format(Direction.LAST, AbsoluteUnit.SUNDAY); // "last Sunday"
 * fmt.format(Direction.THIS, AbsoluteUnit.SUNDAY); // "this Sunday"
 * fmt.format(Direction.NEXT, AbsoluteUnit.SUNDAY); // "next Sunday"
 * fmt.format(Direction.PLAIN, AbsoluteUnit.SUNDAY); // "Sunday"
 *
 * fmt.format(Direction.LAST, AbsoluteUnit.DAY); // "yesterday"
 * fmt.format(Direction.THIS, AbsoluteUnit.DAY); // "today"
 * fmt.format(Direction.NEXT, AbsoluteUnit.DAY); // "tomorrow"
 *
 * fmt.format(Direction.PLAIN, AbsoluteUnit.NOW); // "now"
 * </pre>
 * </blockquote>
 * <p>
 * In the future, we may add more forms, such as abbreviated/short forms
 * (3 secs ago), and relative day periods ("yesterday afternoon"), etc.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class RelativeDateTimeFormatter {

private RelativeDateTimeFormatter() { throw new RuntimeException("Stub!"); }

/**
 * Returns a RelativeDateTimeFormatter for the default locale.
 * @apiSince 24
 */

public static android.icu.text.RelativeDateTimeFormatter getInstance() { throw new RuntimeException("Stub!"); }

/**
 * Returns a RelativeDateTimeFormatter for a particular locale.
 *
 * @param locale the locale.
 * @return An instance of RelativeDateTimeFormatter.
 * @apiSince 24
 */

public static android.icu.text.RelativeDateTimeFormatter getInstance(android.icu.util.ULocale locale) { throw new RuntimeException("Stub!"); }

/**
 * Returns a RelativeDateTimeFormatter for a particular {@link java.util.Locale}.
 *
 * @param locale the {@link java.util.Locale}.
 * @return An instance of RelativeDateTimeFormatter.
 * @apiSince 24
 */

public static android.icu.text.RelativeDateTimeFormatter getInstance(java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Returns a RelativeDateTimeFormatter for a particular locale that uses a particular
 * NumberFormat object.
 *
 * @param locale the locale
 * @param nf the number format object. It is defensively copied to ensure thread-safety
 * and immutability of this class.
 * @return An instance of RelativeDateTimeFormatter.
 * @apiSince 24
 */

public static android.icu.text.RelativeDateTimeFormatter getInstance(android.icu.util.ULocale locale, android.icu.text.NumberFormat nf) { throw new RuntimeException("Stub!"); }

/**
 * Returns a RelativeDateTimeFormatter for a particular locale that uses a particular
 * NumberFormat object, style, and capitalization context
 *
 * @param locale the locale
 * @param nf the number format object. It is defensively copied to ensure thread-safety
 * and immutability of this class. May be null.
 * @param style the style.
 * @param capitalizationContext the capitalization context.
 * @apiSince 24
 */

public static android.icu.text.RelativeDateTimeFormatter getInstance(android.icu.util.ULocale locale, android.icu.text.NumberFormat nf, android.icu.text.RelativeDateTimeFormatter.Style style, android.icu.text.DisplayContext capitalizationContext) { throw new RuntimeException("Stub!"); }

/**
 * Returns a RelativeDateTimeFormatter for a particular {@link java.util.Locale} that uses a
 * particular NumberFormat object.
 *
 * @param locale the {@link java.util.Locale}
 * @param nf the number format object. It is defensively copied to ensure thread-safety
 * and immutability of this class.
 * @return An instance of RelativeDateTimeFormatter.
 * @apiSince 24
 */

public static android.icu.text.RelativeDateTimeFormatter getInstance(java.util.Locale locale, android.icu.text.NumberFormat nf) { throw new RuntimeException("Stub!"); }

/**
 * Formats a relative date with a quantity such as "in 5 days" or
 * "3 months ago".
 *
 * This method returns a String. To get more information about the
 * formatting result, use formatToValue().
 *
 * @param quantity The numerical amount e.g 5. This value is formatted
 * according to this object's {@link android.icu.text.NumberFormat NumberFormat} object.
 * @param direction NEXT means a future relative date; LAST means a past
 * relative date.
 * @param unit the unit e.g day? month? year?
 * @return the formatted string
 * @throws java.lang.IllegalArgumentException if direction is something other than
 * NEXT or LAST.
 * @apiSince 24
 */

public java.lang.String format(double quantity, android.icu.text.RelativeDateTimeFormatter.Direction direction, android.icu.text.RelativeDateTimeFormatter.RelativeUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * Format a combination of RelativeDateTimeUnit and numeric offset
 * using a numeric style, e.g.&nbsp;"1 week ago", "in 1 week",
 * "5 weeks ago", "in 5 weeks".
 *
 * This method returns a String. To get more information about the
 * formatting result, use formatNumericToValue().
 *
 * @param offset    The signed offset for the specified unit. This
 *                  will be formatted according to this object's
 *                  NumberFormat object.
 * @param unit      The unit to use when formatting the relative
 *                  date, e.g. RelativeDateTimeUnit.WEEK,
 *                  RelativeDateTimeUnit.FRIDAY.
 * @return          The formatted string (may be empty in case of error)
 * @apiSince 28
 */

public java.lang.String formatNumeric(double offset, android.icu.text.RelativeDateTimeFormatter.RelativeDateTimeUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * Formats a relative date without a quantity.
 *
 * This method returns a String. To get more information about the
 * formatting result, use formatToValue().
 *
 * @param direction NEXT, LAST, THIS, etc.
 * @param unit e.g SATURDAY, DAY, MONTH
 * @return the formatted string. If direction has a value that is documented as not being
 *  fully supported in every locale (for example NEXT_2 or LAST_2) then this function may
 *  return null to signal that no formatted string is available.
 * @throws java.lang.IllegalArgumentException if the direction is incompatible with
 * unit this can occur with NOW which can only take PLAIN.
 * @apiSince 24
 */

public java.lang.String format(android.icu.text.RelativeDateTimeFormatter.Direction direction, android.icu.text.RelativeDateTimeFormatter.AbsoluteUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * Format a combination of RelativeDateTimeUnit and numeric offset
 * using a text style if possible, e.g.&nbsp;"last week", "this week",
 * "next week", "yesterday", "tomorrow". Falls back to numeric
 * style if no appropriate text term is available for the specified
 * offset in the object’s locale.
 *
 * This method returns a String. To get more information about the
 * formatting result, use formatToValue().
 *
 * @param offset    The signed offset for the specified field.
 * @param unit      The unit to use when formatting the relative
 *                  date, e.g. RelativeDateTimeUnit.WEEK,
 *                  RelativeDateTimeUnit.FRIDAY.
 * @return          The formatted string (may be empty in case of error)
 * @apiSince 28
 */

public java.lang.String format(double offset, android.icu.text.RelativeDateTimeFormatter.RelativeDateTimeUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * Combines a relative date string and a time string in this object's
 * locale. This is done with the same date-time separator used for the
 * default calendar in this locale.
 * @param relativeDateString the relative date e.g 'yesterday'
 * @param timeString the time e.g '3:45'
 * @return the date and time concatenated according to the default
 * calendar in this locale e.g 'yesterday, 3:45'
 * @apiSince 24
 */

public java.lang.String combineDateAndTime(java.lang.String relativeDateString, java.lang.String timeString) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of the NumberFormat this object is using.
 * @return A copy of the NumberFormat.
 * @apiSince 24
 */

public android.icu.text.NumberFormat getNumberFormat() { throw new RuntimeException("Stub!"); }

/**
 * Return capitalization context.
 * @return The capitalization context.
 * @apiSince 24
 */

public android.icu.text.DisplayContext getCapitalizationContext() { throw new RuntimeException("Stub!"); }

/**
 * Return style
 * @return The formatting style.
 * @apiSince 24
 */

public android.icu.text.RelativeDateTimeFormatter.Style getFormatStyle() { throw new RuntimeException("Stub!"); }
/**
 * Represents an absolute unit.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum AbsoluteUnit {
/**
 * Sunday
 * @apiSince 24
 */

SUNDAY,
/**
 * Monday
 * @apiSince 24
 */

MONDAY,
/**
 * Tuesday
 * @apiSince 24
 */

TUESDAY,
/**
 * Wednesday
 * @apiSince 24
 */

WEDNESDAY,
/**
 * Thursday
 * @apiSince 24
 */

THURSDAY,
/**
 * Friday
 * @apiSince 24
 */

FRIDAY,
/**
 * Saturday
 * @apiSince 24
 */

SATURDAY,
/**
 * Day
 * @apiSince 24
 */

DAY,
/**
 * Week
 * @apiSince 24
 */

WEEK,
/**
 * Month
 * @apiSince 24
 */

MONTH,
/**
 * Year
 * @apiSince 24
 */

YEAR,
/**
 * Now
 * @apiSince 24
 */

NOW;
}

/**
 * Represents a direction for an absolute unit e.g "Next Tuesday"
 * or "Last Tuesday"
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum Direction {
/**
 * Two before. Not fully supported in every locale
 * @apiSince 24
 */

LAST_2,
/**
 * Last
 * @apiSince 24
 */

LAST,
/**
 * This
 * @apiSince 24
 */

THIS,
/**
 * Next
 * @apiSince 24
 */

NEXT,
/**
 * Two after. Not fully supported in every locale
 * @apiSince 24
 */

NEXT_2,
/**
 * Plain, which means the absence of a qualifier
 * @apiSince 24
 */

PLAIN;
}

/**
 * Represents the unit for formatting a relative date. e.g "in 5 days"
 * or "next year"
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum RelativeDateTimeUnit {
/**
 * Specifies that relative unit is year, e.g.&nbsp;"last year",
 * "in 5 years".
 * @apiSince 28
 */

YEAR,
/**
 * Specifies that relative unit is quarter, e.g.&nbsp;"last quarter",
 * "in 5 quarters".
 * @apiSince 28
 */

QUARTER,
/**
 * Specifies that relative unit is month, e.g.&nbsp;"last month",
 * "in 5 months".
 * @apiSince 28
 */

MONTH,
/**
 * Specifies that relative unit is week, e.g.&nbsp;"last week",
 * "in 5 weeks".
 * @apiSince 28
 */

WEEK,
/**
 * Specifies that relative unit is day, e.g.&nbsp;"yesterday",
 * "in 5 days".
 * @apiSince 28
 */

DAY,
/**
 * Specifies that relative unit is hour, e.g.&nbsp;"1 hour ago",
 * "in 5 hours".
 * @apiSince 28
 */

HOUR,
/**
 * Specifies that relative unit is minute, e.g.&nbsp;"1 minute ago",
 * "in 5 minutes".
 * @apiSince 28
 */

MINUTE,
/**
 * Specifies that relative unit is second, e.g.&nbsp;"1 second ago",
 * "in 5 seconds".
 * @apiSince 28
 */

SECOND,
/**
 * Specifies that relative unit is Sunday, e.g.&nbsp;"last Sunday",
 * "this Sunday", "next Sunday", "in 5 Sundays".
 * @apiSince 28
 */

SUNDAY,
/**
 * Specifies that relative unit is Monday, e.g.&nbsp;"last Monday",
 * "this Monday", "next Monday", "in 5 Mondays".
 * @apiSince 28
 */

MONDAY,
/**
 * Specifies that relative unit is Tuesday, e.g.&nbsp;"last Tuesday",
 * "this Tuesday", "next Tuesday", "in 5 Tuesdays".
 * @apiSince 28
 */

TUESDAY,
/**
 * Specifies that relative unit is Wednesday, e.g.&nbsp;"last Wednesday",
 * "this Wednesday", "next Wednesday", "in 5 Wednesdays".
 * @apiSince 28
 */

WEDNESDAY,
/**
 * Specifies that relative unit is Thursday, e.g.&nbsp;"last Thursday",
 * "this Thursday", "next Thursday", "in 5 Thursdays".
 * @apiSince 28
 */

THURSDAY,
/**
 * Specifies that relative unit is Friday, e.g.&nbsp;"last Friday",
 * "this Friday", "next Friday", "in 5 Fridays".
 * @apiSince 28
 */

FRIDAY,
/**
 * Specifies that relative unit is Saturday, e.g.&nbsp;"last Saturday",
 * "this Saturday", "next Saturday", "in 5 Saturdays".
 * @apiSince 28
 */

SATURDAY;
}

/**
 * Represents the unit for formatting a relative date. e.g "in 5 days"
 * or "in 3 months"
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum RelativeUnit {
/**
 * Seconds
 * @apiSince 24
 */

SECONDS,
/**
 * Minutes
 * @apiSince 24
 */

MINUTES,
/**
 * Hours
 * @apiSince 24
 */

HOURS,
/**
 * Days
 * @apiSince 24
 */

DAYS,
/**
 * Weeks
 * @apiSince 24
 */

WEEKS,
/**
 * Months
 * @apiSince 24
 */

MONTHS,
/**
 * Years
 * @apiSince 24
 */

YEARS;
}

/**
 * The formatting style
 *
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum Style {
/**
 * Everything spelled out.
 * @apiSince 24
 */

LONG,
/**
 * Abbreviations used when possible.
 * @apiSince 24
 */

SHORT,
/**
 * Use single letters when possible.
 * @apiSince 24
 */

NARROW;
}

}

