/*
 * Copyright (C) 2007 The Android Open Source Project
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

import android.view.View;

/**
 * A widget for selecting the time of day, in either 24-hour or AM/PM mode.
 * <p>
 * For a dialog using this view, see {@link android.app.TimePickerDialog}. See
 * the <a href="{@docRoot}guide/topics/ui/controls/pickers.html">Pickers</a>
 * guide for more information.
 *
 * @attr ref android.R.styleable#TimePicker_timePickerMode
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TimePicker extends android.widget.FrameLayout {

/** @apiSince 1 */

public TimePicker(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public TimePicker(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public TimePicker(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public TimePicker(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Sets the currently selected hour using 24-hour time.
 *
 * @param hour the hour to set, in the range (0-23)
 * Value is between 0 and 23 inclusive
 * @see #getHour()
 * @apiSince 23
 */

public void setHour(int hour) { throw new RuntimeException("Stub!"); }

/**
 * Returns the currently selected hour using 24-hour time.
 *
 * @return the currently selected hour, in the range (0-23)
 * @see #setHour(int)
 * @apiSince 23
 */

public int getHour() { throw new RuntimeException("Stub!"); }

/**
 * Sets the currently selected minute.
 *
 * @param minute the minute to set, in the range (0-59)
 * Value is between 0 and 59 inclusive
 * @see #getMinute()
 * @apiSince 23
 */

public void setMinute(int minute) { throw new RuntimeException("Stub!"); }

/**
 * Returns the currently selected minute.
 *
 * @return the currently selected minute, in the range (0-59)
 * @see #setMinute(int)
 * @apiSince 23
 */

public int getMinute() { throw new RuntimeException("Stub!"); }

/**
 * Sets the currently selected hour using 24-hour time.
 *
 * @param currentHour the hour to set, in the range (0-23)
 * This value must never be {@code null}.
 * @deprecated Use {@link #setHour(int)}
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public void setCurrentHour(@androidx.annotation.NonNull java.lang.Integer currentHour) { throw new RuntimeException("Stub!"); }

/**
 * @return the currently selected hour, in the range (0-23)
 * This value will never be {@code null}.
 * @deprecated Use {@link #getHour()}
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
@androidx.annotation.NonNull
public java.lang.Integer getCurrentHour() { throw new RuntimeException("Stub!"); }

/**
 * Sets the currently selected minute.
 *
 * @param currentMinute the minute to set, in the range (0-59)
 * This value must never be {@code null}.
 * @deprecated Use {@link #setMinute(int)}
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public void setCurrentMinute(@androidx.annotation.NonNull java.lang.Integer currentMinute) { throw new RuntimeException("Stub!"); }

/**
 * @return the currently selected minute, in the range (0-59)
 * This value will never be {@code null}.
 * @deprecated Use {@link #getMinute()}
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
@androidx.annotation.NonNull
public java.lang.Integer getCurrentMinute() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this widget displays time in 24-hour mode or 12-hour mode
 * with an AM/PM picker.
 *
 * @param is24HourView {@code true} to display in 24-hour mode,
 *                     {@code false} for 12-hour mode with AM/PM
 * This value must never be {@code null}.
 * @see #is24HourView()
 * @apiSince 1
 */

public void setIs24HourView(@androidx.annotation.NonNull java.lang.Boolean is24HourView) { throw new RuntimeException("Stub!"); }

/**
 * @return {@code true} if this widget displays time in 24-hour mode,
 *         {@code false} otherwise}
 * @see #setIs24HourView(Boolean)
 * @apiSince 1
 */

public boolean is24HourView() { throw new RuntimeException("Stub!"); }

/**
 * Set the callback that indicates the time has been adjusted by the user.
 *
 * @param onTimeChangedListener the callback, should not be null.
 * @apiSince 1
 */

public void setOnTimeChangedListener(android.widget.TimePicker.OnTimeChangedListener onTimeChangedListener) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean isEnabled() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getBaseline() { throw new RuntimeException("Stub!"); }

/**
 * Validates whether current input by the user is a valid time based on the locale. TimePicker
 * will show an error message to the user if the time is not valid.
 *
 * @return {@code true} if the input is valid, {@code false} otherwise
 * @apiSince 26
 */

public boolean validateInput() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected android.os.Parcelable onSaveInstanceState() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onRestoreInstanceState(android.os.Parcelable state) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void dispatchProvideAutofillStructure(android.view.ViewStructure structure, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void autofill(android.view.autofill.AutofillValue value) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return Value is {@link android.view.View#AUTOFILL_TYPE_NONE}, {@link android.view.View#AUTOFILL_TYPE_TEXT}, {@link android.view.View#AUTOFILL_TYPE_TOGGLE}, {@link android.view.View#AUTOFILL_TYPE_LIST}, or {@link android.view.View#AUTOFILL_TYPE_DATE}
 * @apiSince 26
 */

public int getAutofillType() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public android.view.autofill.AutofillValue getAutofillValue() { throw new RuntimeException("Stub!"); }
/**
 * The callback interface used to indicate the time has been adjusted.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnTimeChangedListener {

/**
 * @param view The view associated with this listener.
 * @param hourOfDay The current hour.
 * @param minute The current minute.
 * @apiSince 1
 */

public void onTimeChanged(android.widget.TimePicker view, int hourOfDay, int minute);
}

}

