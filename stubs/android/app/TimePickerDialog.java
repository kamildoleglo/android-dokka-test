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


package android.app;

import android.widget.TimePicker;

/**
 * A dialog that prompts the user for the time of day using a
 * {@link android.widget.TimePicker TimePicker}.
 *
 * <p>
 * See the <a href="{@docRoot}guide/topics/ui/controls/pickers.html">Pickers</a>
 * guide.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TimePickerDialog extends android.app.AlertDialog implements android.content.DialogInterface.OnClickListener, android.widget.TimePicker.OnTimeChangedListener {

/**
 * Creates a new time picker dialog.
 *
 * @param context the parent context
 * @param listener the listener to call when the time is set
 * @param hourOfDay the initial hour
 * @param minute the initial minute
 * @param is24HourView whether this is a 24 hour view or AM/PM
 * @apiSince 1
 */

public TimePickerDialog(android.content.Context context, android.app.TimePickerDialog.OnTimeSetListener listener, int hourOfDay, int minute, boolean is24HourView) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new time picker dialog with the specified theme.
 * <p>
 * The theme is overlaid on top of the theme of the parent {@code context}.
 * If {@code themeResId} is 0, the dialog will be inflated using the theme
 * specified by the
 * {@link android.R.attr#timePickerDialogTheme android:timePickerDialogTheme}
 * attribute on the parent {@code context}'s theme.
 *
 * @param context the parent context
 * @param themeResId the resource ID of the theme to apply to this dialog
 * @param listener the listener to call when the time is set
 * @param hourOfDay the initial hour
 * @param minute the initial minute
 * @param is24HourView Whether this is a 24 hour view, or AM/PM.
 * @apiSince 1
 */

public TimePickerDialog(android.content.Context context, int themeResId, android.app.TimePickerDialog.OnTimeSetListener listener, int hourOfDay, int minute, boolean is24HourView) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void onTimeChanged(android.widget.TimePicker view, int hourOfDay, int minute) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void show() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void onClick(android.content.DialogInterface dialog, int which) { throw new RuntimeException("Stub!"); }

/**
 * Sets the current time.
 *
 * @param hourOfDay The current hour within the day.
 * @param minuteOfHour The current minute within the hour.
 * @apiSince 1
 */

public void updateTime(int hourOfDay, int minuteOfHour) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.os.Bundle onSaveInstanceState() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void onRestoreInstanceState(android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }
/**
 * The callback interface used to indicate the user is done filling in
 * the time (e.g.&nbsp;they clicked on the 'OK' button).
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnTimeSetListener {

/**
 * Called when the user is done setting a new time and the dialog has
 * closed.
 *
 * @param view the view associated with this listener
 * @param hourOfDay the hour that was set
 * @param minute the minute that was set
 * @apiSince 1
 */

public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute);
}

}

