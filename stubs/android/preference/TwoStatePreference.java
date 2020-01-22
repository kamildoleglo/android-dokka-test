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


package android.preference;

import android.content.SharedPreferences;

/**
 * Common base class for preferences that have two selectable states, persist a
 * boolean value in SharedPreferences, and may have dependent preferences that are
 * enabled/disabled based on the current state.
 *
 * @deprecated Use the <a href="{@docRoot}jetpack/androidx.html">AndroidX</a>
 *      <a href="{@docRoot}reference/androidx/preference/package-summary.html">
 *      Preference Library</a> for consistent behavior across all devices. For more information on
 *      using the AndroidX Preference Library see
 *      <a href="{@docRoot}guide/topics/ui/settings.html">Settings</a>.
 * @apiSince 14
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public abstract class TwoStatePreference extends android.preference.Preference {

/** @apiSince 21 */

@Deprecated
public TwoStatePreference(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

@Deprecated
public TwoStatePreference(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

@Deprecated
public TwoStatePreference(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

@Deprecated
public TwoStatePreference(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
protected void onClick() { throw new RuntimeException("Stub!"); }

/**
 * Sets the checked state and saves it to the {@link android.content.SharedPreferences SharedPreferences}.
 *
 * @param checked The checked state.
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public void setChecked(boolean checked) { throw new RuntimeException("Stub!"); }

/**
 * Returns the checked state.
 *
 * @return The checked state.
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public boolean isChecked() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public boolean shouldDisableDependents() { throw new RuntimeException("Stub!"); }

/**
 * Sets the summary to be shown when checked.
 *
 * @param summary The summary to be shown when checked.
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public void setSummaryOn(java.lang.CharSequence summary) { throw new RuntimeException("Stub!"); }

/**
 * @see #setSummaryOn(CharSequence)
 * @param summaryResId The summary as a resource.
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public void setSummaryOn(int summaryResId) { throw new RuntimeException("Stub!"); }

/**
 * Returns the summary to be shown when checked.
 * @return The summary.
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public java.lang.CharSequence getSummaryOn() { throw new RuntimeException("Stub!"); }

/**
 * Sets the summary to be shown when unchecked.
 *
 * @param summary The summary to be shown when unchecked.
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public void setSummaryOff(java.lang.CharSequence summary) { throw new RuntimeException("Stub!"); }

/**
 * @see #setSummaryOff(CharSequence)
 * @param summaryResId The summary as a resource.
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public void setSummaryOff(int summaryResId) { throw new RuntimeException("Stub!"); }

/**
 * Returns the summary to be shown when unchecked.
 * @return The summary.
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public java.lang.CharSequence getSummaryOff() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether dependents are disabled when this preference is on ({@code true})
 * or when this preference is off ({@code false}).
 *
 * @return Whether dependents are disabled when this preference is on ({@code true})
 *         or when this preference is off ({@code false}).
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public boolean getDisableDependentsState() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether dependents are disabled when this preference is on ({@code true})
 * or when this preference is off ({@code false}).
 *
 * @param disableDependentsState The preference state that should disable dependents.
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
public void setDisableDependentsState(boolean disableDependentsState) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
protected java.lang.Object onGetDefaultValue(android.content.res.TypedArray a, int index) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
protected void onSetInitialValue(boolean restoreValue, java.lang.Object defaultValue) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
protected android.os.Parcelable onSaveInstanceState() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
protected void onRestoreInstanceState(android.os.Parcelable state) { throw new RuntimeException("Stub!"); }
}

