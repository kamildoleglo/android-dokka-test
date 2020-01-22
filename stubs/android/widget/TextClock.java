/*
 * Copyright (C) 2012 The Android Open Source Project
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


package android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.text.format.DateFormat;
import java.util.TimeZone;

/**
 * <p><code>TextClock</code> can display the current date and/or time as
 * a formatted string.</p>
 *
 * <p>This view honors the 24-hour format system setting. As such, it is
 * possible and recommended to provide two different formatting patterns:
 * one to display the date/time in 24-hour mode and one to display the
 * date/time in 12-hour mode. Most callers will want to use the defaults,
 * though, which will be appropriate for the user's locale.</p>
 *
 * <p>It is possible to determine whether the system is currently in
 * 24-hour mode by calling {@link #is24HourModeEnabled()}.</p>
 *
 * <p>The rules used by this widget to decide how to format the date and
 * time are the following:</p>
 * <ul>
 *     <li>In 24-hour mode:
 *         <ul>
 *             <li>Use the value returned by {@link #getFormat24Hour()} when non-null</li>
 *             <li>Otherwise, use the value returned by {@link #getFormat12Hour()} when non-null</li>
 *             <li>Otherwise, use a default value appropriate for the user's locale, such as {@code h:mm a}</li>
 *         </ul>
 *     </li>
 *     <li>In 12-hour mode:
 *         <ul>
 *             <li>Use the value returned by {@link #getFormat12Hour()} when non-null</li>
 *             <li>Otherwise, use the value returned by {@link #getFormat24Hour()} when non-null</li>
 *             <li>Otherwise, use a default value appropriate for the user's locale, such as {@code HH:mm}</li>
 *         </ul>
 *     </li>
 * </ul>
 *
 * <p>The {@link java.lang.CharSequence CharSequence} instances used as formatting patterns when calling either
 * {@link #setFormat24Hour(java.lang.CharSequence)} or {@link #setFormat12Hour(java.lang.CharSequence)} can
 * contain styling information. To do so, use a {@link android.text.Spanned} object.
 * Note that if you customize these strings, it is your responsibility to supply strings
 * appropriate for formatting dates and/or times in the user's locale.</p>
 *
 * @attr ref android.R.styleable#TextClock_format12Hour
 * @attr ref android.R.styleable#TextClock_format24Hour
 * @attr ref android.R.styleable#TextClock_timeZone
 * @apiSince 17
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@android.widget.RemoteViews.RemoteView
public class TextClock extends android.widget.TextView {

/**
 * Creates a new clock using the default patterns for the current locale.
 *
 * @param context The Context the view is running in, through which it can
 *        access the current theme, resources, etc.
 * @apiSince 17
 */

public TextClock(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new clock inflated from XML. This object's properties are
 * intialized from the attributes specified in XML.
 *
 * This constructor uses a default style of 0, so the only attribute values
 * applied are those in the Context's Theme and the given AttributeSet.
 *
 * @param context The Context the view is running in, through which it can
 *        access the current theme, resources, etc.
 * @param attrs The attributes of the XML tag that is inflating the view
 * @apiSince 17
 */

public TextClock(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new clock inflated from XML. This object's properties are
 * intialized from the attributes specified in XML.
 *
 * @param context The Context the view is running in, through which it can
 *        access the current theme, resources, etc.
 * @param attrs The attributes of the XML tag that is inflating the view
 * @param defStyleAttr An attribute in the current theme that contains a
 *        reference to a style resource that supplies default values for
 *        the view. Can be 0 to not look for defaults.
 * @apiSince 17
 */

public TextClock(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public TextClock(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Returns the formatting pattern used to display the date and/or time
 * in 12-hour mode. The formatting pattern syntax is described in
 * {@link android.text.format.DateFormat DateFormat}.
 *
 * @return A {@link java.lang.CharSequence CharSequence} or null.
 *
 * @see #setFormat12Hour(CharSequence)
 * @see #is24HourModeEnabled()
 * @apiSince 17
 */

@android.view.ViewDebug.ExportedProperty
public java.lang.CharSequence getFormat12Hour() { throw new RuntimeException("Stub!"); }

/**
 * <p>Specifies the formatting pattern used to display the date and/or time
 * in 12-hour mode. The formatting pattern syntax is described in
 * {@link android.text.format.DateFormat DateFormat}.</p>
 *
 * <p>If this pattern is set to null, {@link #getFormat24Hour()} will be used
 * even in 12-hour mode. If both 24-hour and 12-hour formatting patterns
 * are set to null, the default pattern for the current locale will be used
 * instead.</p>
 *
 * <p><strong>Note:</strong> if styling is not needed, it is highly recommended
 * you supply a format string generated by
 * {@link android.text.format.DateFormat#getBestDateTimePattern(java.util.Locale,java.lang.String) DateFormat#getBestDateTimePattern(java.util.Locale, String)}. This method
 * takes care of generating a format string adapted to the desired locale.</p>
 *
 *
 * @param format A date/time formatting pattern as described in {@link android.text.format.DateFormat DateFormat}
 *
 * @see #getFormat12Hour()
 * @see #is24HourModeEnabled()
 * @see android.text.format.DateFormat#getBestDateTimePattern(java.util.Locale, String)
 * @see android.text.format.DateFormat
 *
 * @attr ref android.R.styleable#TextClock_format12Hour
 * @apiSince 17
 */

public void setFormat12Hour(java.lang.CharSequence format) { throw new RuntimeException("Stub!"); }

/**
 * Returns the formatting pattern used to display the date and/or time
 * in 24-hour mode. The formatting pattern syntax is described in
 * {@link android.text.format.DateFormat DateFormat}.
 *
 * @return A {@link java.lang.CharSequence CharSequence} or null.
 *
 * @see #setFormat24Hour(CharSequence)
 * @see #is24HourModeEnabled()
 * @apiSince 17
 */

@android.view.ViewDebug.ExportedProperty
public java.lang.CharSequence getFormat24Hour() { throw new RuntimeException("Stub!"); }

/**
 * <p>Specifies the formatting pattern used to display the date and/or time
 * in 24-hour mode. The formatting pattern syntax is described in
 * {@link android.text.format.DateFormat DateFormat}.</p>
 *
 * <p>If this pattern is set to null, {@link #getFormat24Hour()} will be used
 * even in 12-hour mode. If both 24-hour and 12-hour formatting patterns
 * are set to null, the default pattern for the current locale will be used
 * instead.</p>
 *
 * <p><strong>Note:</strong> if styling is not needed, it is highly recommended
 * you supply a format string generated by
 * {@link android.text.format.DateFormat#getBestDateTimePattern(java.util.Locale,java.lang.String) DateFormat#getBestDateTimePattern(java.util.Locale, String)}. This method
 * takes care of generating a format string adapted to the desired locale.</p>
 *
 * @param format A date/time formatting pattern as described in {@link android.text.format.DateFormat DateFormat}
 *
 * @see #getFormat24Hour()
 * @see #is24HourModeEnabled()
 * @see android.text.format.DateFormat#getBestDateTimePattern(java.util.Locale, String)
 * @see android.text.format.DateFormat
 *
 * @attr ref android.R.styleable#TextClock_format24Hour
 * @apiSince 17
 */

public void setFormat24Hour(java.lang.CharSequence format) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the system is currently using the 24-hour mode.
 *
 * When the system is in 24-hour mode, this view will use the pattern
 * returned by {@link #getFormat24Hour()}. In 12-hour mode, the pattern
 * returned by {@link #getFormat12Hour()} is used instead.
 *
 * If either one of the formats is null, the other format is used. If
 * both formats are null, the default formats for the current locale are used.
 *
 * @return true if time should be displayed in 24-hour format, false if it
 *         should be displayed in 12-hour format.
 *
 * @see #setFormat12Hour(CharSequence)
 * @see #getFormat12Hour()
 * @see #setFormat24Hour(CharSequence)
 * @see #getFormat24Hour()
 * @apiSince 17
 */

public boolean is24HourModeEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Indicates which time zone is currently used by this view.
 *
 * @return The ID of the current time zone or null if the default time zone,
 *         as set by the user, must be used
 *
 * @see java.util.TimeZone
 * @see java.util.TimeZone#getAvailableIDs()
 * @see #setTimeZone(String)
 * @apiSince 17
 */

public java.lang.String getTimeZone() { throw new RuntimeException("Stub!"); }

/**
 * Sets the specified time zone to use in this clock. When the time zone
 * is set through this method, system time zone changes (when the user
 * sets the time zone in settings for instance) will be ignored.
 *
 * @param timeZone The desired time zone's ID as specified in {@link java.util.TimeZone TimeZone}
 *                 or null to user the time zone specified by the user
 *                 (system time zone)
 *
 * @see #getTimeZone()
 * @see java.util.TimeZone#getAvailableIDs()
 * @see java.util.TimeZone#getTimeZone(String)
 *
 * @attr ref android.R.styleable#TextClock_timeZone
 * @apiSince 17
 */

public void setTimeZone(java.lang.String timeZone) { throw new RuntimeException("Stub!"); }

/** @apiSince 17 */

protected void onAttachedToWindow() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public void onVisibilityAggregated(boolean isVisible) { throw new RuntimeException("Stub!"); }

/** @apiSince 17 */

protected void onDetachedFromWindow() { throw new RuntimeException("Stub!"); }

/**
 * The default formatting pattern in 12-hour mode. This pattern is used
 * if {@link #setFormat12Hour(java.lang.CharSequence)} is called with a null pattern
 * or if no pattern was specified when creating an instance of this class.
 *
 * This default pattern shows only the time, hours and minutes, and an am/pm
 * indicator.
 *
 * @see #setFormat12Hour(CharSequence)
 * @see #getFormat12Hour()
 *
 * @deprecated Let the system use locale-appropriate defaults instead.
 * @apiSince 17
 * @deprecatedSince 18
 */

@Deprecated public static final java.lang.CharSequence DEFAULT_FORMAT_12_HOUR;
static { DEFAULT_FORMAT_12_HOUR = null; }

/**
 * The default formatting pattern in 24-hour mode. This pattern is used
 * if {@link #setFormat24Hour(java.lang.CharSequence)} is called with a null pattern
 * or if no pattern was specified when creating an instance of this class.
 *
 * This default pattern shows only the time, hours and minutes.
 *
 * @see #setFormat24Hour(CharSequence)
 * @see #getFormat24Hour()
 *
 * @deprecated Let the system use locale-appropriate defaults instead.
 * @apiSince 17
 * @deprecatedSince 18
 */

@Deprecated public static final java.lang.CharSequence DEFAULT_FORMAT_24_HOUR;
static { DEFAULT_FORMAT_24_HOUR = null; }
}

