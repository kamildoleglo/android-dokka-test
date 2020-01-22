/*
 * Copyright (C) 2010 The Android Open Source Project
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

import android.icu.util.TimeZone;
import android.icu.util.Calendar;

/**
 * This class is a calendar widget for displaying and selecting dates. The
 * range of dates supported by this calendar is configurable.
 * <p>
 * The exact appearance and interaction model of this widget may vary between
 * OS versions and themes (e.g. Holo versus Material), but in general a user
 * can select a date by tapping on it and can scroll or fling the calendar to a
 * desired date.
 *
 * @attr ref android.R.styleable#CalendarView_showWeekNumber
 * @attr ref android.R.styleable#CalendarView_firstDayOfWeek
 * @attr ref android.R.styleable#CalendarView_minDate
 * @attr ref android.R.styleable#CalendarView_maxDate
 * @attr ref android.R.styleable#CalendarView_shownWeekCount
 * @attr ref android.R.styleable#CalendarView_selectedWeekBackgroundColor
 * @attr ref android.R.styleable#CalendarView_focusedMonthDateColor
 * @attr ref android.R.styleable#CalendarView_unfocusedMonthDateColor
 * @attr ref android.R.styleable#CalendarView_weekNumberColor
 * @attr ref android.R.styleable#CalendarView_weekSeparatorLineColor
 * @attr ref android.R.styleable#CalendarView_selectedDateVerticalBar
 * @attr ref android.R.styleable#CalendarView_weekDayTextAppearance
 * @attr ref android.R.styleable#CalendarView_dateTextAppearance
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CalendarView extends android.widget.FrameLayout {

/**
 * @param context This value must never be {@code null}.
 * @apiSince 11
 */

public CalendarView(@androidx.annotation.NonNull android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * @param context This value must never be {@code null}.
 
 * @param attrs This value may be {@code null}.
 * @apiSince 11
 */

public CalendarView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * @param context This value must never be {@code null}.
 
 * @param attrs This value may be {@code null}.
 * @apiSince 11
 */

public CalendarView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * @param context This value must never be {@code null}.
 
 * @param attrs This value may be {@code null}.
 * @apiSince 21
 */

public CalendarView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Sets the number of weeks to be shown.
 *
 * @param count The shown week count.
 *
 * @attr ref android.R.styleable#CalendarView_shownWeekCount
 * @deprecated No longer used by Material-style CalendarView.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated
public void setShownWeekCount(int count) { throw new RuntimeException("Stub!"); }

/**
 * Gets the number of weeks to be shown.
 *
 * @return The shown week count.
 *
 * @attr ref android.R.styleable#CalendarView_shownWeekCount
 * @deprecated No longer used by Material-style CalendarView.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated
public int getShownWeekCount() { throw new RuntimeException("Stub!"); }

/**
 * Sets the background color for the selected week.
 *
 * @param color The week background color.
 *
 * @attr ref android.R.styleable#CalendarView_selectedWeekBackgroundColor
 * @deprecated No longer used by Material-style CalendarView.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated
public void setSelectedWeekBackgroundColor(int color) { throw new RuntimeException("Stub!"); }

/**
 * Gets the background color for the selected week.
 *
 * @return The week background color.
 *
 * @attr ref android.R.styleable#CalendarView_selectedWeekBackgroundColor
 * @deprecated No longer used by Material-style CalendarView.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated
public int getSelectedWeekBackgroundColor() { throw new RuntimeException("Stub!"); }

/**
 * Sets the color for the dates of the focused month.
 *
 * @param color The focused month date color.
 *
 * @attr ref android.R.styleable#CalendarView_focusedMonthDateColor
 * @deprecated No longer used by Material-style CalendarView.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated
public void setFocusedMonthDateColor(int color) { throw new RuntimeException("Stub!"); }

/**
 * Gets the color for the dates in the focused month.
 *
 * @return The focused month date color.
 *
 * @attr ref android.R.styleable#CalendarView_focusedMonthDateColor
 * @deprecated No longer used by Material-style CalendarView.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated
public int getFocusedMonthDateColor() { throw new RuntimeException("Stub!"); }

/**
 * Sets the color for the dates of a not focused month.
 *
 * @param color A not focused month date color.
 *
 * @attr ref android.R.styleable#CalendarView_unfocusedMonthDateColor
 * @deprecated No longer used by Material-style CalendarView.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated
public void setUnfocusedMonthDateColor(int color) { throw new RuntimeException("Stub!"); }

/**
 * Gets the color for the dates in a not focused month.
 *
 * @return A not focused month date color.
 *
 * @attr ref android.R.styleable#CalendarView_unfocusedMonthDateColor
 * @deprecated No longer used by Material-style CalendarView.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated
public int getUnfocusedMonthDateColor() { throw new RuntimeException("Stub!"); }

/**
 * Sets the color for the week numbers.
 *
 * @param color The week number color.
 *
 * @attr ref android.R.styleable#CalendarView_weekNumberColor
 * @deprecated No longer used by Material-style CalendarView.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated
public void setWeekNumberColor(int color) { throw new RuntimeException("Stub!"); }

/**
 * Gets the color for the week numbers.
 *
 * @return The week number color.
 *
 * @attr ref android.R.styleable#CalendarView_weekNumberColor
 * @deprecated No longer used by Material-style CalendarView.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated
public int getWeekNumberColor() { throw new RuntimeException("Stub!"); }

/**
 * Sets the color for the separator line between weeks.
 *
 * @param color The week separator color.
 *
 * @attr ref android.R.styleable#CalendarView_weekSeparatorLineColor
 * @deprecated No longer used by Material-style CalendarView.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated
public void setWeekSeparatorLineColor(int color) { throw new RuntimeException("Stub!"); }

/**
 * Gets the color for the separator line between weeks.
 *
 * @return The week separator color.
 *
 * @attr ref android.R.styleable#CalendarView_weekSeparatorLineColor
 * @deprecated No longer used by Material-style CalendarView.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated
public int getWeekSeparatorLineColor() { throw new RuntimeException("Stub!"); }

/**
 * Sets the drawable for the vertical bar shown at the beginning and at
 * the end of the selected date.
 *
 * @param resourceId The vertical bar drawable resource id.
 *
 * @attr ref android.R.styleable#CalendarView_selectedDateVerticalBar
 * @deprecated No longer used by Material-style CalendarView.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated
public void setSelectedDateVerticalBar(int resourceId) { throw new RuntimeException("Stub!"); }

/**
 * Sets the drawable for the vertical bar shown at the beginning and at
 * the end of the selected date.
 *
 * @param drawable The vertical bar drawable.
 *
 * @attr ref android.R.styleable#CalendarView_selectedDateVerticalBar
 * @deprecated No longer used by Material-style CalendarView.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated
public void setSelectedDateVerticalBar(android.graphics.drawable.Drawable drawable) { throw new RuntimeException("Stub!"); }

/**
 * Gets the drawable for the vertical bar shown at the beginning and at
 * the end of the selected date.
 *
 * @return The vertical bar drawable.
 * @deprecated No longer used by Material-style CalendarView.
 * @apiSince 16
 * @deprecatedSince 23
 */

@Deprecated
public android.graphics.drawable.Drawable getSelectedDateVerticalBar() { throw new RuntimeException("Stub!"); }

/**
 * Sets the text appearance for the week day abbreviation of the calendar header.
 *
 * @param resourceId The text appearance resource id.
 *
 * @attr ref android.R.styleable#CalendarView_weekDayTextAppearance
 * @apiSince 16
 */

public void setWeekDayTextAppearance(int resourceId) { throw new RuntimeException("Stub!"); }

/**
 * Gets the text appearance for the week day abbreviation of the calendar header.
 *
 * @return The text appearance resource id.
 *
 * @attr ref android.R.styleable#CalendarView_weekDayTextAppearance
 * @apiSince 16
 */

public int getWeekDayTextAppearance() { throw new RuntimeException("Stub!"); }

/**
 * Sets the text appearance for the calendar dates.
 *
 * @param resourceId The text appearance resource id.
 *
 * @attr ref android.R.styleable#CalendarView_dateTextAppearance
 * @apiSince 16
 */

public void setDateTextAppearance(int resourceId) { throw new RuntimeException("Stub!"); }

/**
 * Gets the text appearance for the calendar dates.
 *
 * @return The text appearance resource id.
 *
 * @attr ref android.R.styleable#CalendarView_dateTextAppearance
 * @apiSince 16
 */

public int getDateTextAppearance() { throw new RuntimeException("Stub!"); }

/**
 * Gets the minimal date supported by this {@link android.widget.CalendarView CalendarView} in milliseconds
 * since January 1, 1970 00:00:00 in {@link android.icu.util.TimeZone#getDefault() TimeZone#getDefault()} time
 * zone.
 * <p>
 * Note: The default minimal date is 01/01/1900.
 * <p>
 *
 * @return The minimal supported date.
 *
 * @attr ref android.R.styleable#CalendarView_minDate
 * @apiSince 11
 */

public long getMinDate() { throw new RuntimeException("Stub!"); }

/**
 * Sets the minimal date supported by this {@link android.widget.CalendarView CalendarView} in milliseconds
 * since January 1, 1970 00:00:00 in {@link android.icu.util.TimeZone#getDefault() TimeZone#getDefault()} time
 * zone.
 *
 * @param minDate The minimal supported date.
 *
 * @attr ref android.R.styleable#CalendarView_minDate
 * @apiSince 11
 */

public void setMinDate(long minDate) { throw new RuntimeException("Stub!"); }

/**
 * Gets the maximal date supported by this {@link android.widget.CalendarView CalendarView} in milliseconds
 * since January 1, 1970 00:00:00 in {@link android.icu.util.TimeZone#getDefault() TimeZone#getDefault()} time
 * zone.
 * <p>
 * Note: The default maximal date is 01/01/2100.
 * <p>
 *
 * @return The maximal supported date.
 *
 * @attr ref android.R.styleable#CalendarView_maxDate
 * @apiSince 11
 */

public long getMaxDate() { throw new RuntimeException("Stub!"); }

/**
 * Sets the maximal date supported by this {@link android.widget.CalendarView CalendarView} in milliseconds
 * since January 1, 1970 00:00:00 in {@link android.icu.util.TimeZone#getDefault() TimeZone#getDefault()} time
 * zone.
 *
 * @param maxDate The maximal supported date.
 *
 * @attr ref android.R.styleable#CalendarView_maxDate
 * @apiSince 11
 */

public void setMaxDate(long maxDate) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether to show the week number.
 *
 * @param showWeekNumber True to show the week number.
 * @deprecated No longer used by Material-style CalendarView.
 *
 * @attr ref android.R.styleable#CalendarView_showWeekNumber
 * @apiSince 11
 * @deprecatedSince 24
 */

@Deprecated
public void setShowWeekNumber(boolean showWeekNumber) { throw new RuntimeException("Stub!"); }

/**
 * Gets whether to show the week number.
 *
 * @return True if showing the week number.
 * @deprecated No longer used by Material-style CalendarView.
 *
 * @attr ref android.R.styleable#CalendarView_showWeekNumber
 * @apiSince 11
 * @deprecatedSince 24
 */

@Deprecated
public boolean getShowWeekNumber() { throw new RuntimeException("Stub!"); }

/**
 * Gets the first day of week.
 *
 * @return The first day of the week conforming to the {@link android.widget.CalendarView CalendarView}
 *         APIs.
 * @see android.icu.util.Calendar#MONDAY
 * @see android.icu.util.Calendar#TUESDAY
 * @see android.icu.util.Calendar#WEDNESDAY
 * @see android.icu.util.Calendar#THURSDAY
 * @see android.icu.util.Calendar#FRIDAY
 * @see android.icu.util.Calendar#SATURDAY
 * @see android.icu.util.Calendar#SUNDAY
 *
 * @attr ref android.R.styleable#CalendarView_firstDayOfWeek
 * @apiSince 11
 */

public int getFirstDayOfWeek() { throw new RuntimeException("Stub!"); }

/**
 * Sets the first day of week.
 *
 * @param firstDayOfWeek The first day of the week conforming to the
 *            {@link android.widget.CalendarView CalendarView} APIs.
 * @see android.icu.util.Calendar#MONDAY
 * @see android.icu.util.Calendar#TUESDAY
 * @see android.icu.util.Calendar#WEDNESDAY
 * @see android.icu.util.Calendar#THURSDAY
 * @see android.icu.util.Calendar#FRIDAY
 * @see android.icu.util.Calendar#SATURDAY
 * @see android.icu.util.Calendar#SUNDAY
 *
 * @attr ref android.R.styleable#CalendarView_firstDayOfWeek
 * @apiSince 11
 */

public void setFirstDayOfWeek(int firstDayOfWeek) { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener to be notified upon selected date change.
 *
 * @param listener The listener to be notified.
 * @apiSince 11
 */

public void setOnDateChangeListener(android.widget.CalendarView.OnDateChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Gets the selected date in milliseconds since January 1, 1970 00:00:00 in
 * {@link android.icu.util.TimeZone#getDefault() TimeZone#getDefault()} time zone.
 *
 * @return The selected date.
 * @apiSince 11
 */

public long getDate() { throw new RuntimeException("Stub!"); }

/**
 * Sets the selected date in milliseconds since January 1, 1970 00:00:00 in
 * {@link android.icu.util.TimeZone#getDefault() TimeZone#getDefault()} time zone.
 *
 * @param date The selected date.
 *
 * @throws java.lang.IllegalArgumentException of the provided date is before the
 *        minimal or after the maximal date.
 *
 * @see #setDate(long, boolean, boolean)
 * @see #setMinDate(long)
 * @see #setMaxDate(long)
 * @apiSince 11
 */

public void setDate(long date) { throw new RuntimeException("Stub!"); }

/**
 * Sets the selected date in milliseconds since January 1, 1970 00:00:00 in
 * {@link android.icu.util.TimeZone#getDefault() TimeZone#getDefault()} time zone.
 *
 * @param date The date.
 * @param animate Whether to animate the scroll to the current date.
 * @param center Whether to center the current date even if it is already visible.
 *
 * @throws java.lang.IllegalArgumentException of the provided date is before the
 *        minimal or after the maximal date.
 *
 * @see #setMinDate(long)
 * @see #setMaxDate(long)
 * @apiSince 11
 */

public void setDate(long date, boolean animate, boolean center) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

protected void onConfigurationChanged(android.content.res.Configuration newConfig) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }
/**
 * The callback used to indicate the user changes the date.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnDateChangeListener {

/**
 * Called upon change of the selected day.
 *
 * @param view The view associated with this listener.
 * This value must never be {@code null}.
 * @param year The year that was set.
 * @param month The month that was set [0-11].
 * @param dayOfMonth The day of the month that was set.
 * @apiSince 11
 */

public void onSelectedDayChange(@androidx.annotation.NonNull android.widget.CalendarView view, int year, int month, int dayOfMonth);
}

}

