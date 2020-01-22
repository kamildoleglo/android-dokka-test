/*
 * Copyright (C) 2016 The Android Open Source Project
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
 * limitations under the License
 */


package android.preference;

import java.util.Set;

/**
 * A data store interface to be implemented and provided to the Preferences framework. This can be
 * used to replace the default {@link android.content.SharedPreferences}, if needed.
 *
 * <p>In most cases you want to use {@link android.content.SharedPreferences} as it is automatically
 * backed up and migrated to new devices. However, providing custom data store to preferences can be
 * useful if your app stores its preferences in a local db, cloud or they are device specific like
 * "Developer settings". It might be also useful when you want to use the preferences UI but
 * the data are not supposed to be stored at all because they are valid per session only.
 *
 * <p>Once a put method is called it is full responsibility of the data store implementation to
 * safely store the given values. Time expensive operations need to be done in the background to
 * prevent from blocking the UI. You also need to have a plan on how to serialize the data in case
 * the activity holding this object gets destroyed.
 *
 * <p>By default, all "put" methods throw {@link java.lang.UnsupportedOperationException UnsupportedOperationException}.
 *
 * @see android.preference.Preference#setPreferenceDataStore(PreferenceDataStore)
 * @see android.preference.PreferenceManager#setPreferenceDataStore(PreferenceDataStore)
 *
 * @deprecated Use the <a href="{@docRoot}jetpack/androidx.html">AndroidX</a>
 *      <a href="{@docRoot}reference/androidx/preference/package-summary.html">
 *      Preference Library</a> for consistent behavior across all devices. For more information on
 *      using the AndroidX Preference Library see
 *      <a href="{@docRoot}guide/topics/ui/settings.html">Settings</a>.
 * @apiSince 26
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public interface PreferenceDataStore {

/**
 * Set a String value to the data store.
 *
 * <p>Once the value is set the data store is responsible for holding it.
 *
 * @param key The name of the preference to modify.
 * @param value The new value for the preference.
 * This value may be {@code null}.
 * @see #getString(String, String)
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated
public default void putString(java.lang.String key, @androidx.annotation.Nullable java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Set a set of String value to the data store.
 *
 * <p>Once the value is set the data store is responsible for holding it.
 *
 * @param key The name of the preference to modify.
 * @param values The set of new values for the preference.
 * This value may be {@code null}.
 * @see #getStringSet(String, Set)
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated
public default void putStringSet(java.lang.String key, @androidx.annotation.Nullable java.util.Set<java.lang.String> values) { throw new RuntimeException("Stub!"); }

/**
 * Set an int value to the data store.
 *
 * <p>Once the value is set the data store is responsible for holding it.
 *
 * @param key The name of the preference to modify.
 * @param value The new value for the preference.
 * @see #getInt(String, int)
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated
public default void putInt(java.lang.String key, int value) { throw new RuntimeException("Stub!"); }

/**
 * Set a long value to the data store.
 *
 * <p>Once the value is set the data store is responsible for holding it.
 *
 * @param key The name of the preference to modify.
 * @param value The new value for the preference.
 * @see #getLong(String, long)
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated
public default void putLong(java.lang.String key, long value) { throw new RuntimeException("Stub!"); }

/**
 * Set a float value to the data store.
 *
 * <p>Once the value is set the data store is responsible for holding it.
 *
 * @param key The name of the preference to modify.
 * @param value The new value for the preference.
 * @see #getFloat(String, float)
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated
public default void putFloat(java.lang.String key, float value) { throw new RuntimeException("Stub!"); }

/**
 * Set a boolean value to the data store.
 *
 * <p>Once the value is set the data store is responsible for holding it.
 *
 * @param key The name of the preference to modify.
 * @param value The new value for the preference.
 * @see #getBoolean(String, boolean)
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated
public default void putBoolean(java.lang.String key, boolean value) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a String value from the data store.
 *
 * @param key The name of the preference to retrieve.
 * @param defValue Value to return if this preference does not exist.
 * This value may be {@code null}.
 * @see #putString(String, String)
 
 * @return This value may be {@code null}.
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated
@androidx.annotation.Nullable
public default java.lang.String getString(java.lang.String key, @androidx.annotation.Nullable java.lang.String defValue) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a set of String values from the data store.
 *
 * @param key The name of the preference to retrieve.
 * @param defValues Values to return if this preference does not exist.
 * This value may be {@code null}.
 * @see #putStringSet(String, Set)
 
 * @return This value may be {@code null}.
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated
@androidx.annotation.Nullable
public default java.util.Set<java.lang.String> getStringSet(java.lang.String key, @androidx.annotation.Nullable java.util.Set<java.lang.String> defValues) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve an int value from the data store.
 *
 * @param key The name of the preference to retrieve.
 * @param defValue Value to return if this preference does not exist.
 * @see #putInt(String, int)
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated
public default int getInt(java.lang.String key, int defValue) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a long value from the data store.
 *
 * @param key The name of the preference to retrieve.
 * @param defValue Value to return if this preference does not exist.
 * @see #putLong(String, long)
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated
public default long getLong(java.lang.String key, long defValue) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a float value from the data store.
 *
 * @param key The name of the preference to retrieve.
 * @param defValue Value to return if this preference does not exist.
 * @see #putFloat(String, float)
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated
public default float getFloat(java.lang.String key, float defValue) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a boolean value from the data store.
 *
 * @param key The name of the preference to retrieve.
 * @param defValue Value to return if this preference does not exist.
 * @see #getBoolean(String, boolean)
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated
public default boolean getBoolean(java.lang.String key, boolean defValue) { throw new RuntimeException("Stub!"); }
}

