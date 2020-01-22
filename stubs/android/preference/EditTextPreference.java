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


package android.preference;

import android.widget.EditText;
import android.content.SharedPreferences;

/**
 * A {@link android.preference.Preference Preference} that allows for string
 * input.
 * <p>
 * It is a subclass of {@link android.preference.DialogPreference DialogPreference} and shows the {@link android.widget.EditText EditText}
 * in a dialog. This {@link android.widget.EditText EditText} can be modified either programmatically
 * via {@link #getEditText()}, or through XML by setting any EditText
 * attributes on the EditTextPreference.
 * <p>
 * This preference will store a string into the SharedPreferences.
 * <p>
 * See {@link android.R.styleable#EditText EditText Attributes}.
 *
 * @deprecated Use the <a href="{@docRoot}jetpack/androidx.html">AndroidX</a>
 *      <a href="{@docRoot}reference/androidx/preference/package-summary.html">
 *      Preference Library</a> for consistent behavior across all devices. For more information on
 *      using the AndroidX Preference Library see
 *      <a href="{@docRoot}guide/topics/ui/settings.html">Settings</a>.
 * @apiSince 1
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class EditTextPreference extends android.preference.DialogPreference {

/** @apiSince 21 */

@Deprecated
public EditTextPreference(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@Deprecated
public EditTextPreference(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@Deprecated
public EditTextPreference(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@Deprecated
public EditTextPreference(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Saves the text to the {@link android.content.SharedPreferences SharedPreferences}.
 *
 * @param text The text to save
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setText(java.lang.String text) { throw new RuntimeException("Stub!"); }

/**
 * Gets the text from the {@link android.content.SharedPreferences SharedPreferences}.
 *
 * @return The current preference value.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public java.lang.String getText() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected void onBindDialogView(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Adds the EditText widget of this preference to the dialog's view.
 *
 * @param dialogView The dialog view.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected void onAddEditTextToDialogView(android.view.View dialogView, android.widget.EditText editText) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected void onDialogClosed(boolean positiveResult) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected java.lang.Object onGetDefaultValue(android.content.res.TypedArray a, int index) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected void onSetInitialValue(boolean restoreValue, java.lang.Object defaultValue) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public boolean shouldDisableDependents() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.widget.EditText EditText} widget that will be shown in the dialog.
 *
 * @return The {@link android.widget.EditText EditText} widget that will be shown in the dialog.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public android.widget.EditText getEditText() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected android.os.Parcelable onSaveInstanceState() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
protected void onRestoreInstanceState(android.os.Parcelable state) { throw new RuntimeException("Stub!"); }
}

