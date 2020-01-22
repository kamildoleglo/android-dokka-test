/*
 * Copyright (C) 2014 The Android Open Source Project
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


package android.os;

import java.util.Set;

/**
 * A mapping from String keys to values of various types. In most cases, you
 * should work directly with either the {@link android.os.Bundle Bundle} or
 * {@link android.os.PersistableBundle PersistableBundle} subclass.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class BaseBundle {

BaseBundle() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of mappings contained in this Bundle.
 *
 * @return the number of mappings as an int.
 * @apiSince 21
 */

public int size() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the mapping of this Bundle is empty, false otherwise.
 * @apiSince 21
 */

public boolean isEmpty() { throw new RuntimeException("Stub!"); }

/**
 * Removes all elements from the mapping of this Bundle.
 * @apiSince 21
 */

public void clear() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the given key is contained in the mapping
 * of this Bundle.
 *
 * @param key a String key
 * @return true if the key is part of the mapping, false otherwise
 * @apiSince 21
 */

public boolean containsKey(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the entry with the given key as an object.
 *
 * @param key a String key
 * @return an Object, or null
 * @apiSince 21
 */

@androidx.annotation.Nullable
public java.lang.Object get(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Removes any entry with the given key from the mapping of this Bundle.
 *
 * @param key a String key
 * @apiSince 21
 */

public void remove(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Inserts all mappings from the given PersistableBundle into this BaseBundle.
 *
 * @param bundle a PersistableBundle
 * @apiSince 21
 */

public void putAll(android.os.PersistableBundle bundle) { throw new RuntimeException("Stub!"); }

/**
 * Returns a Set containing the Strings used as keys in this Bundle.
 *
 * @return a Set of String keys
 * @apiSince 21
 */

public java.util.Set<java.lang.String> keySet() { throw new RuntimeException("Stub!"); }

/**
 * Inserts a Boolean value into the mapping of this Bundle, replacing
 * any existing value for the given key.  Either key or value may be null.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value a boolean
 * @apiSince 22
 */

public void putBoolean(@androidx.annotation.Nullable java.lang.String key, boolean value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts an int value into the mapping of this Bundle, replacing
 * any existing value for the given key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value an int
 * @apiSince 21
 */

public void putInt(@androidx.annotation.Nullable java.lang.String key, int value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts a long value into the mapping of this Bundle, replacing
 * any existing value for the given key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value a long
 * @apiSince 21
 */

public void putLong(@androidx.annotation.Nullable java.lang.String key, long value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts a double value into the mapping of this Bundle, replacing
 * any existing value for the given key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value a double
 * @apiSince 21
 */

public void putDouble(@androidx.annotation.Nullable java.lang.String key, double value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts a String value into the mapping of this Bundle, replacing
 * any existing value for the given key.  Either key or value may be null.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value a String, or null
 
 * This value may be {@code null}.
 * @apiSince 21
 */

public void putString(@androidx.annotation.Nullable java.lang.String key, @androidx.annotation.Nullable java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts a boolean array value into the mapping of this Bundle, replacing
 * any existing value for the given key.  Either key or value may be null.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value a boolean array object, or null
 
 * This value may be {@code null}.
 * @apiSince 22
 */

public void putBooleanArray(@androidx.annotation.Nullable java.lang.String key, @androidx.annotation.Nullable boolean[] value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts an int array value into the mapping of this Bundle, replacing
 * any existing value for the given key.  Either key or value may be null.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value an int array object, or null
 
 * This value may be {@code null}.
 * @apiSince 21
 */

public void putIntArray(@androidx.annotation.Nullable java.lang.String key, @androidx.annotation.Nullable int[] value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts a long array value into the mapping of this Bundle, replacing
 * any existing value for the given key.  Either key or value may be null.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value a long array object, or null
 
 * This value may be {@code null}.
 * @apiSince 21
 */

public void putLongArray(@androidx.annotation.Nullable java.lang.String key, @androidx.annotation.Nullable long[] value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts a double array value into the mapping of this Bundle, replacing
 * any existing value for the given key.  Either key or value may be null.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value a double array object, or null
 
 * This value may be {@code null}.
 * @apiSince 21
 */

public void putDoubleArray(@androidx.annotation.Nullable java.lang.String key, @androidx.annotation.Nullable double[] value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts a String array value into the mapping of this Bundle, replacing
 * any existing value for the given key.  Either key or value may be null.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value a String array object, or null
 
 * This value may be {@code null}.
 * @apiSince 21
 */

public void putStringArray(@androidx.annotation.Nullable java.lang.String key, @androidx.annotation.Nullable java.lang.String[] value) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or false if
 * no mapping of the desired type exists for the given key.
 *
 * @param key a String
 * @return a boolean value
 * @apiSince 22
 */

public boolean getBoolean(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or defaultValue if
 * no mapping of the desired type exists for the given key.
 *
 * @param key a String
 * @param defaultValue Value to return if key does not exist
 * @return a boolean value
 * @apiSince 22
 */

public boolean getBoolean(java.lang.String key, boolean defaultValue) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or 0 if
 * no mapping of the desired type exists for the given key.
 *
 * @param key a String
 * @return an int value
 * @apiSince 21
 */

public int getInt(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or defaultValue if
 * no mapping of the desired type exists for the given key.
 *
 * @param key a String
 * @param defaultValue Value to return if key does not exist
 * @return an int value
 * @apiSince 21
 */

public int getInt(java.lang.String key, int defaultValue) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or 0L if
 * no mapping of the desired type exists for the given key.
 *
 * @param key a String
 * @return a long value
 * @apiSince 21
 */

public long getLong(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or defaultValue if
 * no mapping of the desired type exists for the given key.
 *
 * @param key a String
 * @param defaultValue Value to return if key does not exist
 * @return a long value
 * @apiSince 21
 */

public long getLong(java.lang.String key, long defaultValue) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or 0.0 if
 * no mapping of the desired type exists for the given key.
 *
 * @param key a String
 * @return a double value
 * @apiSince 21
 */

public double getDouble(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or defaultValue if
 * no mapping of the desired type exists for the given key.
 *
 * @param key a String
 * @param defaultValue Value to return if key does not exist
 * @return a double value
 * @apiSince 21
 */

public double getDouble(java.lang.String key, double defaultValue) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or null if
 * no mapping of the desired type exists for the given key or a null
 * value is explicitly associated with the key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @return a String value, or null
 * @apiSince 21
 */

@androidx.annotation.Nullable
public java.lang.String getString(@androidx.annotation.Nullable java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or defaultValue if
 * no mapping of the desired type exists for the given key or if a null
 * value is explicitly associated with the given key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param defaultValue Value to return if key does not exist or if a null
 *     value is associated with the given key.
 * @return the String value associated with the given key, or defaultValue
 *     if no valid String object is currently mapped to that key.
 * @apiSince 21
 */

public java.lang.String getString(@androidx.annotation.Nullable java.lang.String key, java.lang.String defaultValue) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or null if
 * no mapping of the desired type exists for the given key or a null
 * value is explicitly associated with the key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @return a boolean[] value, or null
 * @apiSince 22
 */

@androidx.annotation.Nullable
public boolean[] getBooleanArray(@androidx.annotation.Nullable java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or null if
 * no mapping of the desired type exists for the given key or a null
 * value is explicitly associated with the key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @return an int[] value, or null
 * @apiSince 21
 */

@androidx.annotation.Nullable
public int[] getIntArray(@androidx.annotation.Nullable java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or null if
 * no mapping of the desired type exists for the given key or a null
 * value is explicitly associated with the key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @return a long[] value, or null
 * @apiSince 21
 */

@androidx.annotation.Nullable
public long[] getLongArray(@androidx.annotation.Nullable java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or null if
 * no mapping of the desired type exists for the given key or a null
 * value is explicitly associated with the key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @return a double[] value, or null
 * @apiSince 21
 */

@androidx.annotation.Nullable
public double[] getDoubleArray(@androidx.annotation.Nullable java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or null if
 * no mapping of the desired type exists for the given key or a null
 * value is explicitly associated with the key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @return a String[] value, or null
 * @apiSince 21
 */

@androidx.annotation.Nullable
public java.lang.String[] getStringArray(@androidx.annotation.Nullable java.lang.String key) { throw new RuntimeException("Stub!"); }
}

