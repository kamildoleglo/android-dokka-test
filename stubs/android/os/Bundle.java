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


package android.os;

import java.io.Serializable;
import java.util.ArrayList;
import android.util.Size;
import android.util.SizeF;
import java.util.List;
import android.util.SparseArray;

/**
 * A mapping from String keys to various {@link android.os.Parcelable Parcelable} values.
 *
 * @see android.os.PersistableBundle
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Bundle extends android.os.BaseBundle implements java.lang.Cloneable, android.os.Parcelable {

/**
 * Constructs a new, empty Bundle.
 * @apiSince 1
 */

public Bundle() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new, empty Bundle that uses a specific ClassLoader for
 * instantiating Parcelable and Serializable objects.
 *
 * @param loader An explicit ClassLoader to use when instantiating objects
 * inside of the Bundle.
 * @apiSince 1
 */

public Bundle(java.lang.ClassLoader loader) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new, empty Bundle sized to hold the given number of
 * elements. The Bundle will grow as needed.
 *
 * @param capacity the initial capacity of the Bundle
 * @apiSince 1
 */

public Bundle(int capacity) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a Bundle containing a copy of the mappings from the given
 * Bundle.  Does only a shallow copy of the original Bundle -- see
 * {@link #deepCopy()} if that is not what you want.
 *
 * @param b a Bundle to be copied.
 *
 * @see #deepCopy()
 * @apiSince 1
 */

public Bundle(android.os.Bundle b) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a Bundle containing a copy of the mappings from the given
 * PersistableBundle.  Does only a shallow copy of the PersistableBundle -- see
 * {@link android.os.PersistableBundle#deepCopy() PersistableBundle#deepCopy()} if you don't want that.
 *
 * @param b a PersistableBundle to be copied.
 * @apiSince 21
 */

public Bundle(android.os.PersistableBundle b) { throw new RuntimeException("Stub!"); }

/**
 * Changes the ClassLoader this Bundle uses when instantiating objects.
 *
 * @param loader An explicit ClassLoader to use when instantiating objects
 * inside of the Bundle.
 * @apiSince 1
 */

public void setClassLoader(java.lang.ClassLoader loader) { throw new RuntimeException("Stub!"); }

/**
 * Return the ClassLoader currently associated with this Bundle.
 * @apiSince 11
 */

public java.lang.ClassLoader getClassLoader() { throw new RuntimeException("Stub!"); }

/**
 * Clones the current Bundle. The internal map is cloned, but the keys and
 * values to which it refers are copied by reference.
 * @apiSince 1
 */

public java.lang.Object clone() { throw new RuntimeException("Stub!"); }

/**
 * Make a deep copy of the given bundle.  Traverses into inner containers and copies
 * them as well, so they are not shared across bundles.  Will traverse in to
 * {@link android.os.Bundle Bundle}, {@link android.os.PersistableBundle PersistableBundle}, {@link java.util.ArrayList ArrayList}, and all types of
 * primitive arrays.  Other types of objects (such as Parcelable or Serializable)
 * are referenced as-is and not copied in any way.
 * @apiSince 26
 */

public android.os.Bundle deepCopy() { throw new RuntimeException("Stub!"); }

/**
 * Removes all elements from the mapping of this Bundle.
 * @apiSince 1
 */

public void clear() { throw new RuntimeException("Stub!"); }

/**
 * Removes any entry with the given key from the mapping of this Bundle.
 *
 * @param key a String key
 * @apiSince 1
 */

public void remove(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Inserts all mappings from the given Bundle into this Bundle.
 *
 * @param bundle a Bundle
 * @apiSince 1
 */

public void putAll(android.os.Bundle bundle) { throw new RuntimeException("Stub!"); }

/**
 * Reports whether the bundle contains any parcelled file descriptors.
 * @apiSince 1
 */

public boolean hasFileDescriptors() { throw new RuntimeException("Stub!"); }

/**
 * Inserts a byte value into the mapping of this Bundle, replacing
 * any existing value for the given key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value a byte
 * @apiSince 1
 */

public void putByte(@androidx.annotation.Nullable java.lang.String key, byte value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts a char value into the mapping of this Bundle, replacing
 * any existing value for the given key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value a char
 * @apiSince 1
 */

public void putChar(@androidx.annotation.Nullable java.lang.String key, char value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts a short value into the mapping of this Bundle, replacing
 * any existing value for the given key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value a short
 * @apiSince 1
 */

public void putShort(@androidx.annotation.Nullable java.lang.String key, short value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts a float value into the mapping of this Bundle, replacing
 * any existing value for the given key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value a float
 * @apiSince 1
 */

public void putFloat(@androidx.annotation.Nullable java.lang.String key, float value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts a CharSequence value into the mapping of this Bundle, replacing
 * any existing value for the given key.  Either key or value may be null.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value a CharSequence, or null
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void putCharSequence(@androidx.annotation.Nullable java.lang.String key, @androidx.annotation.Nullable java.lang.CharSequence value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts a Parcelable value into the mapping of this Bundle, replacing
 * any existing value for the given key.  Either key or value may be null.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value a Parcelable object, or null
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void putParcelable(@androidx.annotation.Nullable java.lang.String key, @androidx.annotation.Nullable android.os.Parcelable value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts a Size value into the mapping of this Bundle, replacing
 * any existing value for the given key.  Either key or value may be null.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value a Size object, or null
 
 * This value may be {@code null}.
 * @apiSince 21
 */

public void putSize(@androidx.annotation.Nullable java.lang.String key, @androidx.annotation.Nullable android.util.Size value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts a SizeF value into the mapping of this Bundle, replacing
 * any existing value for the given key.  Either key or value may be null.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value a SizeF object, or null
 
 * This value may be {@code null}.
 * @apiSince 21
 */

public void putSizeF(@androidx.annotation.Nullable java.lang.String key, @androidx.annotation.Nullable android.util.SizeF value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts an array of Parcelable values into the mapping of this Bundle,
 * replacing any existing value for the given key.  Either key or value may
 * be null.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value an array of Parcelable objects, or null
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void putParcelableArray(@androidx.annotation.Nullable java.lang.String key, @androidx.annotation.Nullable android.os.Parcelable[] value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts a List of Parcelable values into the mapping of this Bundle,
 * replacing any existing value for the given key.  Either key or value may
 * be null.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value an ArrayList of Parcelable objects, or null
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void putParcelableArrayList(@androidx.annotation.Nullable java.lang.String key, @androidx.annotation.Nullable java.util.ArrayList<? extends android.os.Parcelable> value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts a SparceArray of Parcelable values into the mapping of this
 * Bundle, replacing any existing value for the given key.  Either key
 * or value may be null.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value a SparseArray of Parcelable objects, or null
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void putSparseParcelableArray(@androidx.annotation.Nullable java.lang.String key, @androidx.annotation.Nullable android.util.SparseArray<? extends android.os.Parcelable> value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts an ArrayList<Integer> value into the mapping of this Bundle, replacing
 * any existing value for the given key.  Either key or value may be null.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value an ArrayList<Integer> object, or null
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void putIntegerArrayList(@androidx.annotation.Nullable java.lang.String key, @androidx.annotation.Nullable java.util.ArrayList<java.lang.Integer> value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts an ArrayList<String> value into the mapping of this Bundle, replacing
 * any existing value for the given key.  Either key or value may be null.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value an ArrayList<String> object, or null
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void putStringArrayList(@androidx.annotation.Nullable java.lang.String key, @androidx.annotation.Nullable java.util.ArrayList<java.lang.String> value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts an ArrayList<CharSequence> value into the mapping of this Bundle, replacing
 * any existing value for the given key.  Either key or value may be null.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value an ArrayList<CharSequence> object, or null
 
 * This value may be {@code null}.
 * @apiSince 8
 */

public void putCharSequenceArrayList(@androidx.annotation.Nullable java.lang.String key, @androidx.annotation.Nullable java.util.ArrayList<java.lang.CharSequence> value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts a Serializable value into the mapping of this Bundle, replacing
 * any existing value for the given key.  Either key or value may be null.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value a Serializable object, or null
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void putSerializable(@androidx.annotation.Nullable java.lang.String key, @androidx.annotation.Nullable java.io.Serializable value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts a byte array value into the mapping of this Bundle, replacing
 * any existing value for the given key.  Either key or value may be null.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value a byte array object, or null
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void putByteArray(@androidx.annotation.Nullable java.lang.String key, @androidx.annotation.Nullable byte[] value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts a short array value into the mapping of this Bundle, replacing
 * any existing value for the given key.  Either key or value may be null.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value a short array object, or null
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void putShortArray(@androidx.annotation.Nullable java.lang.String key, @androidx.annotation.Nullable short[] value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts a char array value into the mapping of this Bundle, replacing
 * any existing value for the given key.  Either key or value may be null.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value a char array object, or null
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void putCharArray(@androidx.annotation.Nullable java.lang.String key, @androidx.annotation.Nullable char[] value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts a float array value into the mapping of this Bundle, replacing
 * any existing value for the given key.  Either key or value may be null.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value a float array object, or null
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void putFloatArray(@androidx.annotation.Nullable java.lang.String key, @androidx.annotation.Nullable float[] value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts a CharSequence array value into the mapping of this Bundle, replacing
 * any existing value for the given key.  Either key or value may be null.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value a CharSequence array object, or null
 
 * This value may be {@code null}.
 * @apiSince 8
 */

public void putCharSequenceArray(@androidx.annotation.Nullable java.lang.String key, @androidx.annotation.Nullable java.lang.CharSequence[] value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts a Bundle value into the mapping of this Bundle, replacing
 * any existing value for the given key.  Either key or value may be null.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value a Bundle object, or null
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void putBundle(@androidx.annotation.Nullable java.lang.String key, @androidx.annotation.Nullable android.os.Bundle value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts an {@link android.os.IBinder IBinder} value into the mapping of this Bundle, replacing
 * any existing value for the given key.  Either key or value may be null.
 *
 * <p class="note">You should be very careful when using this function.  In many
 * places where Bundles are used (such as inside of Intent objects), the Bundle
 * can live longer inside of another process than the process that had originally
 * created it.  In that case, the IBinder you supply here will become invalid
 * when your process goes away, and no longer usable, even if a new process is
 * created for you later on.</p>
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value an IBinder object, or null
 
 * This value may be {@code null}.
 * @apiSince 18
 */

public void putBinder(@androidx.annotation.Nullable java.lang.String key, @androidx.annotation.Nullable android.os.IBinder value) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or (byte) 0 if
 * no mapping of the desired type exists for the given key.
 *
 * @param key a String
 * @return a byte value
 * @apiSince 1
 */

public byte getByte(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or defaultValue if
 * no mapping of the desired type exists for the given key.
 *
 * @param key a String
 * @param defaultValue Value to return if key does not exist
 * @return a byte value
 * @apiSince 1
 */

public java.lang.Byte getByte(java.lang.String key, byte defaultValue) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or (char) 0 if
 * no mapping of the desired type exists for the given key.
 *
 * @param key a String
 * @return a char value
 * @apiSince 1
 */

public char getChar(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or defaultValue if
 * no mapping of the desired type exists for the given key.
 *
 * @param key a String
 * @param defaultValue Value to return if key does not exist
 * @return a char value
 * @apiSince 1
 */

public char getChar(java.lang.String key, char defaultValue) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or (short) 0 if
 * no mapping of the desired type exists for the given key.
 *
 * @param key a String
 * @return a short value
 * @apiSince 1
 */

public short getShort(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or defaultValue if
 * no mapping of the desired type exists for the given key.
 *
 * @param key a String
 * @param defaultValue Value to return if key does not exist
 * @return a short value
 * @apiSince 1
 */

public short getShort(java.lang.String key, short defaultValue) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or 0.0f if
 * no mapping of the desired type exists for the given key.
 *
 * @param key a String
 * @return a float value
 * @apiSince 1
 */

public float getFloat(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or defaultValue if
 * no mapping of the desired type exists for the given key.
 *
 * @param key a String
 * @param defaultValue Value to return if key does not exist
 * @return a float value
 * @apiSince 1
 */

public float getFloat(java.lang.String key, float defaultValue) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or null if
 * no mapping of the desired type exists for the given key or a null
 * value is explicitly associated with the key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @return a CharSequence value, or null
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.lang.CharSequence getCharSequence(@androidx.annotation.Nullable java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or defaultValue if
 * no mapping of the desired type exists for the given key or if a null
 * value is explicitly associatd with the given key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param defaultValue Value to return if key does not exist or if a null
 *     value is associated with the given key.
 * @return the CharSequence value associated with the given key, or defaultValue
 *     if no valid CharSequence object is currently mapped to that key.
 * @apiSince 12
 */

public java.lang.CharSequence getCharSequence(@androidx.annotation.Nullable java.lang.String key, java.lang.CharSequence defaultValue) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or null if
 * no mapping of the desired type exists for the given key or a null
 * value is explicitly associated with the key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @return a Size value, or null
 * @apiSince 21
 */

@androidx.annotation.Nullable
public android.util.Size getSize(@androidx.annotation.Nullable java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or null if
 * no mapping of the desired type exists for the given key or a null
 * value is explicitly associated with the key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @return a Size value, or null
 * @apiSince 21
 */

@androidx.annotation.Nullable
public android.util.SizeF getSizeF(@androidx.annotation.Nullable java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or null if
 * no mapping of the desired type exists for the given key or a null
 * value is explicitly associated with the key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @return a Bundle value, or null
 * @apiSince 1
 */

@androidx.annotation.Nullable
public android.os.Bundle getBundle(@androidx.annotation.Nullable java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or {@code null} if
 * no mapping of the desired type exists for the given key or a {@code null}
 * value is explicitly associated with the key.
 *
 * <p><b>Note: </b> if the expected value is not a class provided by the Android platform,
 * you must call {@link #setClassLoader(java.lang.ClassLoader)} with the proper {@link java.lang.ClassLoader ClassLoader} first.
 * Otherwise, this method might throw an exception or return {@code null}.
 *
 * @param key a String, or {@code null}
 * This value may be {@code null}.
 * @return a Parcelable value, or {@code null}
 * @apiSince 1
 */

@androidx.annotation.Nullable
public <T extends android.os.Parcelable> T getParcelable(@androidx.annotation.Nullable java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or {@code null} if
 * no mapping of the desired type exists for the given key or a null
 * value is explicitly associated with the key.
 *
 * <p><b>Note: </b> if the expected value is not a class provided by the Android platform,
 * you must call {@link #setClassLoader(java.lang.ClassLoader)} with the proper {@link java.lang.ClassLoader ClassLoader} first.
 * Otherwise, this method might throw an exception or return {@code null}.
 *
 * @param key a String, or {@code null}
 * This value may be {@code null}.
 * @return a Parcelable[] value, or {@code null}
 * @apiSince 1
 */

@androidx.annotation.Nullable
public android.os.Parcelable[] getParcelableArray(@androidx.annotation.Nullable java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or {@code null} if
 * no mapping of the desired type exists for the given key or a {@code null}
 * value is explicitly associated with the key.
 *
 * <p><b>Note: </b> if the expected value is not a class provided by the Android platform,
 * you must call {@link #setClassLoader(java.lang.ClassLoader)} with the proper {@link java.lang.ClassLoader ClassLoader} first.
 * Otherwise, this method might throw an exception or return {@code null}.
 *
 * @param key a String, or {@code null}
 * This value may be {@code null}.
 * @return an ArrayList<T> value, or {@code null}
 * @apiSince 1
 */

@androidx.annotation.Nullable
public <T extends android.os.Parcelable> java.util.ArrayList<T> getParcelableArrayList(@androidx.annotation.Nullable java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or null if
 * no mapping of the desired type exists for the given key or a null
 * value is explicitly associated with the key.
 *
 * @param key a String, or null
 *
 * This value may be {@code null}.
 * @return a SparseArray of T values, or null
 * @apiSince 1
 */

@androidx.annotation.Nullable
public <T extends android.os.Parcelable> android.util.SparseArray<T> getSparseParcelableArray(@androidx.annotation.Nullable java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or null if
 * no mapping of the desired type exists for the given key or a null
 * value is explicitly associated with the key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @return a Serializable value, or null
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.io.Serializable getSerializable(@androidx.annotation.Nullable java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or null if
 * no mapping of the desired type exists for the given key or a null
 * value is explicitly associated with the key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @return an ArrayList<String> value, or null
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.util.ArrayList<java.lang.Integer> getIntegerArrayList(@androidx.annotation.Nullable java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or null if
 * no mapping of the desired type exists for the given key or a null
 * value is explicitly associated with the key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @return an ArrayList<String> value, or null
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.util.ArrayList<java.lang.String> getStringArrayList(@androidx.annotation.Nullable java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or null if
 * no mapping of the desired type exists for the given key or a null
 * value is explicitly associated with the key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @return an ArrayList<CharSequence> value, or null
 * @apiSince 8
 */

@androidx.annotation.Nullable
public java.util.ArrayList<java.lang.CharSequence> getCharSequenceArrayList(@androidx.annotation.Nullable java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or null if
 * no mapping of the desired type exists for the given key or a null
 * value is explicitly associated with the key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @return a byte[] value, or null
 * @apiSince 1
 */

@androidx.annotation.Nullable
public byte[] getByteArray(@androidx.annotation.Nullable java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or null if
 * no mapping of the desired type exists for the given key or a null
 * value is explicitly associated with the key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @return a short[] value, or null
 * @apiSince 1
 */

@androidx.annotation.Nullable
public short[] getShortArray(@androidx.annotation.Nullable java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or null if
 * no mapping of the desired type exists for the given key or a null
 * value is explicitly associated with the key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @return a char[] value, or null
 * @apiSince 1
 */

@androidx.annotation.Nullable
public char[] getCharArray(@androidx.annotation.Nullable java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or null if
 * no mapping of the desired type exists for the given key or a null
 * value is explicitly associated with the key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @return a float[] value, or null
 * @apiSince 1
 */

@androidx.annotation.Nullable
public float[] getFloatArray(@androidx.annotation.Nullable java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or null if
 * no mapping of the desired type exists for the given key or a null
 * value is explicitly associated with the key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @return a CharSequence[] value, or null
 * @apiSince 8
 */

@androidx.annotation.Nullable
public java.lang.CharSequence[] getCharSequenceArray(@androidx.annotation.Nullable java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or null if
 * no mapping of the desired type exists for the given key or a null
 * value is explicitly associated with the key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @return an IBinder value, or null
 * @apiSince 18
 */

@androidx.annotation.Nullable
public android.os.IBinder getBinder(@androidx.annotation.Nullable java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Report the nature of this Parcelable's contents
 * @apiSince 1
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Writes the Bundle contents to a Parcel, typically in order for
 * it to be passed through an IBinder connection.
 * @param parcel The parcel to copy this bundle to.
 * @apiSince 1
 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Reads the Parcel contents into this Bundle, typically in order for
 * it to be passed through an IBinder connection.
 * @param parcel The parcel to overwrite this bundle from.
 * @apiSince 1
 */

public void readFromParcel(android.os.Parcel parcel) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public synchronized java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.os.Bundle> CREATOR;
static { CREATOR = null; }

/** @apiSince 1 */

public static final android.os.Bundle EMPTY;
static { EMPTY = null; }
}

