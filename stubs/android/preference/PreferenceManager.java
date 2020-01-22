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

import android.content.SharedPreferences;
import android.content.Context;
import android.app.Activity;

/**
 * Used to help create {@link android.preference.Preference Preference} hierarchies
 * from activities or XML.
 * <p>
 * In most cases, clients should use
 * {@link android.preference.PreferenceActivity#addPreferencesFromIntent PreferenceActivity#addPreferencesFromIntent} or
 * {@link android.preference.PreferenceActivity#addPreferencesFromResource(int) PreferenceActivity#addPreferencesFromResource(int)}.
 *
 * @see android.preference.PreferenceActivity
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
public class PreferenceManager {

PreferenceManager() { throw new RuntimeException("Stub!"); }

/**
 * Sets a {@link android.preference.PreferenceDataStore PreferenceDataStore} to be used by all Preferences associated with this manager
 * that don't have a custom {@link android.preference.PreferenceDataStore PreferenceDataStore} assigned via
 * {@link android.preference.Preference#setPreferenceDataStore(android.preference.PreferenceDataStore) Preference#setPreferenceDataStore(PreferenceDataStore)}. Also if the data store is
 * set, the child preferences won't use {@link android.content.SharedPreferences} as long as
 * they are assigned to this manager.
 *
 * @param dataStore The {@link android.preference.PreferenceDataStore PreferenceDataStore} to be used by this manager.
 * @see android.preference.Preference#setPreferenceDataStore(PreferenceDataStore)
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated
public void setPreferenceDataStore(android.preference.PreferenceDataStore dataStore) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.preference.PreferenceDataStore PreferenceDataStore} associated with this manager or {@code null} if
 * the default {@link android.content.SharedPreferences} are used instead.
 *
 * @return The {@link android.preference.PreferenceDataStore PreferenceDataStore} associated with this manager or {@code null} if none.
 * @see #setPreferenceDataStore(PreferenceDataStore)
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated
@androidx.annotation.Nullable
public android.preference.PreferenceDataStore getPreferenceDataStore() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public android.preference.PreferenceScreen createPreferenceScreen(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current name of the SharedPreferences file that preferences managed by
 * this will use.
 *
 * @return The name that can be passed to {@link android.content.Context#getSharedPreferences(java.lang.String,int) Context#getSharedPreferences(String, int)}.
 * @see android.content.Context#getSharedPreferences(String, int)
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public java.lang.String getSharedPreferencesName() { throw new RuntimeException("Stub!"); }

/**
 * Sets the name of the SharedPreferences file that preferences managed by this
 * will use.
 *
 * <p>If custom {@link android.preference.PreferenceDataStore PreferenceDataStore} is set, this won't override its usage.
 *
 * @param sharedPreferencesName The name of the SharedPreferences file.
 * @see android.content.Context#getSharedPreferences(String, int)
 * @see #setPreferenceDataStore(PreferenceDataStore)
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setSharedPreferencesName(java.lang.String sharedPreferencesName) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current mode of the SharedPreferences file that preferences managed by
 * this will use.
 *
 * @return The mode that can be passed to {@link android.content.Context#getSharedPreferences(java.lang.String,int) Context#getSharedPreferences(String, int)}.
 * @see android.content.Context#getSharedPreferences(String, int)
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public int getSharedPreferencesMode() { throw new RuntimeException("Stub!"); }

/**
 * Sets the mode of the SharedPreferences file that preferences managed by this
 * will use.
 *
 * @param sharedPreferencesMode The mode of the SharedPreferences file.
 * @see android.content.Context#getSharedPreferences(String, int)
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void setSharedPreferencesMode(int sharedPreferencesMode) { throw new RuntimeException("Stub!"); }

/**
 * Sets the storage location used internally by this class to be the default
 * provided by the hosting {@link android.content.Context Context}.
 * @apiSince 24
 * @deprecatedSince 29
 */

@Deprecated
public void setStorageDefault() { throw new RuntimeException("Stub!"); }

/**
 * Explicitly set the storage location used internally by this class to be
 * device-protected storage.
 * <p>
 * On devices with direct boot, data stored in this location is encrypted
 * with a key tied to the physical device, and it can be accessed
 * immediately after the device has booted successfully, both
 * <em>before and after</em> the user has authenticated with their
 * credentials (such as a lock pattern or PIN).
 * <p>
 * Because device-protected data is available without user authentication,
 * you should carefully limit the data you store using this Context. For
 * example, storing sensitive authentication tokens or passwords in the
 * device-protected area is strongly discouraged.
 *
 * @see android.content.Context#createDeviceProtectedStorageContext()
 * @apiSince 24
 * @deprecatedSince 29
 */

@Deprecated
public void setStorageDeviceProtected() { throw new RuntimeException("Stub!"); }

/**
 * Indicates if the storage location used internally by this class is the
 * default provided by the hosting {@link android.content.Context Context}.
 *
 * @see #setStorageDefault()
 * @see #setStorageDeviceProtected()
 * @apiSince 24
 * @deprecatedSince 29
 */

@Deprecated
public boolean isStorageDefault() { throw new RuntimeException("Stub!"); }

/**
 * Indicates if the storage location used internally by this class is backed
 * by device-protected storage.
 *
 * @see #setStorageDefault()
 * @see #setStorageDeviceProtected()
 * @apiSince 24
 * @deprecatedSince 29
 */

@Deprecated
public boolean isStorageDeviceProtected() { throw new RuntimeException("Stub!"); }

/**
 * Gets a {@link android.content.SharedPreferences SharedPreferences} instance that preferences managed by this will use.
 *
 * @return a {@link android.content.SharedPreferences SharedPreferences} instance pointing to the file that contains the values of
 *         preferences that are managed by this PreferenceManager. If a
 *         {@link android.preference.PreferenceDataStore PreferenceDataStore} has been set, this method returns {@code null}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public android.content.SharedPreferences getSharedPreferences() { throw new RuntimeException("Stub!"); }

/**
 * Gets a {@link android.content.SharedPreferences SharedPreferences} instance that points to the default file that is used by
 * the preference framework in the given context.
 *
 * @param context The context of the preferences whose values are wanted.
 * @return A {@link android.content.SharedPreferences SharedPreferences} instance that can be used to retrieve and listen
 *         to values of the preferences.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public static android.content.SharedPreferences getDefaultSharedPreferences(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Returns the name used for storing default shared preferences.
 *
 * @see #getDefaultSharedPreferences(Context)
 * @apiSince 24
 * @deprecatedSince 29
 */

@Deprecated
public static java.lang.String getDefaultSharedPreferencesName(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Finds a {@link android.preference.Preference Preference} based on its key.
 *
 * @param key the key of the preference to retrieve
 * @return the {@link android.preference.Preference Preference} with the key, or {@code null}
 * @see android.preference.PreferenceGroup#findPreference(CharSequence)
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
@androidx.annotation.Nullable
public android.preference.Preference findPreference(java.lang.CharSequence key) { throw new RuntimeException("Stub!"); }

/**
 * Sets the default values from an XML preference file by reading the values defined
 * by each {@link android.preference.Preference Preference} item's {@code android:defaultValue} attribute. This should
 * be called by the application's main activity.
 * <p>
 *
 * @param context The context of the shared preferences.
 * @param resId The resource ID of the preference XML file.
 * @param readAgain Whether to re-read the default values.
 * If false, this method sets the default values only if this
 * method has never been called in the past (or if the
 * {@link #KEY_HAS_SET_DEFAULT_VALUES} in the default value shared
 * preferences file is false). To attempt to set the default values again
 * bypassing this check, set {@code readAgain} to true.
 *            <p class="note">
 *            Note: this will NOT reset preferences back to their default
 *            values. For that functionality, use
 *            {@link android.preference.PreferenceManager#getDefaultSharedPreferences(android.content.Context) PreferenceManager#getDefaultSharedPreferences(Context)}
 *            and clear it followed by a call to this method with this
 *            parameter set to true.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public static void setDefaultValues(android.content.Context context, int resId, boolean readAgain) { throw new RuntimeException("Stub!"); }

/**
 * Similar to {@link #setDefaultValues(android.content.Context,int,boolean)} but allows
 * the client to provide the filename and mode of the shared preferences
 * file.
 *
 * @param context The context of the shared preferences.
 * @param sharedPreferencesName A custom name for the shared preferences file.
 * @param sharedPreferencesMode The file creation mode for the shared preferences file, such
 * as {@link android.content.Context#MODE_PRIVATE} or {@link
 * android.content.Context#MODE_PRIVATE}
 * @param resId The resource ID of the preference XML file.
 * @param readAgain Whether to re-read the default values.
 * If false, this method will set the default values only if this
 * method has never been called in the past (or if the
 * {@link #KEY_HAS_SET_DEFAULT_VALUES} in the default value shared
 * preferences file is false). To attempt to set the default values again
 * bypassing this check, set {@code readAgain} to true.
 *            <p class="note">
 *            Note: this will NOT reset preferences back to their default
 *            values. For that functionality, use
 *            {@link android.preference.PreferenceManager#getDefaultSharedPreferences(android.content.Context) PreferenceManager#getDefaultSharedPreferences(Context)}
 *            and clear it followed by a call to this method with this
 *            parameter set to true.
 *
 * @see #setDefaultValues(Context, int, boolean)
 * @see #setSharedPreferencesName(String)
 * @see #setSharedPreferencesMode(int)
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public static void setDefaultValues(android.content.Context context, java.lang.String sharedPreferencesName, int sharedPreferencesMode, int resId, boolean readAgain) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String KEY_HAS_SET_DEFAULT_VALUES = "_has_set_default_values";

/**
 * The Activity meta-data key for its XML preference hierarchy.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String METADATA_KEY_PREFERENCES = "android.preference";
/**
 * Interface definition for a class that will be called when the container's activity
 * is destroyed.
 *
 * @deprecated Use the <a href="{@docRoot}jetpack/androidx.html">AndroidX</a>
 *      <a href="{@docRoot}reference/androidx/preference/package-summary.html">
 *      Preference Library</a> for consistent behavior across all devices.
 *      For more information on using the AndroidX Preference Library see
 *      <a href="{@docRoot}guide/topics/ui/settings.html">Settings</a>.
 * @apiSince 1
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface OnActivityDestroyListener {

/**
 * See Activity's onDestroy.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void onActivityDestroy();
}

/**
 * Interface definition for a class that will be called when the container's activity
 * receives an activity result.
 *
 * @deprecated Use the <a href="{@docRoot}jetpack/androidx.html">AndroidX</a>
 *      <a href="{@docRoot}reference/androidx/preference/package-summary.html">
 *      Preference Library</a> for consistent behavior across all devices.
 *      For more information on using the AndroidX Preference Library see
 *      <a href="{@docRoot}guide/topics/ui/settings.html">Settings</a>.
 * @apiSince 1
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface OnActivityResultListener {

/**
 * See Activity's onActivityResult.
 *
 * @return Whether the request code was handled (in which case
 *         subsequent listeners will not be called.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public boolean onActivityResult(int requestCode, int resultCode, android.content.Intent data);
}

/**
 * Interface definition for a class that will be called when the container's activity
 * is stopped.
 *
 * @deprecated Use the <a href="{@docRoot}jetpack/androidx.html">AndroidX</a>
 *      <a href="{@docRoot}reference/androidx/preference/package-summary.html">
 *      Preference Library</a> for consistent behavior across all devices.
 *      For more information on using the AndroidX Preference Library see
 *      <a href="{@docRoot}guide/topics/ui/settings.html">Settings</a>.
 * @apiSince 1
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface OnActivityStopListener {

/**
 * See Activity's onStop.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void onActivityStop();
}

}

