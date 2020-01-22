/*
 * Copyright (C) 2013 The Android Open Source Project
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


package android.util;

import java.util.Set;
import java.util.Map;
import java.util.Collection;

/**
 * ArrayMap is a generic key->value mapping data structure that is
 * designed to be more memory efficient than a traditional {@link java.util.HashMap}.
 * It keeps its mappings in an array data structure -- an integer array of hash
 * codes for each item, and an Object array of the key/value pairs.  This allows it to
 * avoid having to create an extra object for every entry put in to the map, and it
 * also tries to control the growth of the size of these arrays more aggressively
 * (since growing them only requires copying the entries in the array, not rebuilding
 * a hash map).
 *
 * <p>Note that this implementation is not intended to be appropriate for data structures
 * that may contain large numbers of items.  It is generally slower than a traditional
 * HashMap, since lookups require a binary search and adds and removes require inserting
 * and deleting entries in the array.  For containers holding up to hundreds of items,
 * the performance difference is not significant, less than 50%.</p>
 *
 * <p>Because this container is intended to better balance memory use, unlike most other
 * standard Java containers it will shrink its array as items are removed from it.  Currently
 * you have no control over this shrinking -- if you set a capacity and then remove an
 * item, it may reduce the capacity to better match the current size.  In the future an
 * explicit call to set the capacity should turn off this aggressive shrinking behavior.</p>
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ArrayMap<K, V> implements java.util.Map<K,V> {

/**
 * Create a new empty ArrayMap.  The default capacity of an array map is 0, and
 * will grow once items are added to it.
 * @apiSince 19
 */

public ArrayMap() { throw new RuntimeException("Stub!"); }

/**
 * Create a new ArrayMap with a given initial capacity.
 * @apiSince 19
 */

public ArrayMap(int capacity) { throw new RuntimeException("Stub!"); }

/**
 * Create a new ArrayMap with the mappings from the given ArrayMap.
 * @apiSince 19
 */

public ArrayMap(android.util.ArrayMap<K,V> map) { throw new RuntimeException("Stub!"); }

/**
 * Make the array map empty.  All storage is released.
 * @apiSince 19
 */

public void clear() { throw new RuntimeException("Stub!"); }

/**
 * Ensure the array map can hold at least <var>minimumCapacity</var>
 * items.
 * @apiSince 19
 */

public void ensureCapacity(int minimumCapacity) { throw new RuntimeException("Stub!"); }

/**
 * Check whether a key exists in the array.
 *
 * @param key The key to search for.
 * @return Returns true if the key exists, else false.
 * @apiSince 19
 */

public boolean containsKey(java.lang.Object key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the index of a key in the set.
 *
 * @param key The key to search for.
 * @return Returns the index of the key if it exists, else a negative integer.
 * @apiSince 21
 */

public int indexOfKey(java.lang.Object key) { throw new RuntimeException("Stub!"); }

/**
 * Returns an index for which {@link #valueAt} would return the
 * specified value, or a negative number if no keys map to the
 * specified value.
 * Beware that this is a linear search, unlike lookups by key,
 * and that multiple keys can map to the same value and this will
 * find only one of them.
 * @apiSince 29
 */

public int indexOfValue(java.lang.Object value) { throw new RuntimeException("Stub!"); }

/**
 * Check whether a value exists in the array.  This requires a linear search
 * through the entire array.
 *
 * @param value The value to search for.
 * @return Returns true if the value exists, else false.
 * @apiSince 19
 */

public boolean containsValue(java.lang.Object value) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a value from the array.
 * @param key The key of the value to retrieve.
 * @return Returns the value associated with the given key,
 * or null if there is no such key.
 * @apiSince 19
 */

public V get(java.lang.Object key) { throw new RuntimeException("Stub!"); }

/**
 * Return the key at the given index in the array.
 *
 * <p>For indices outside of the range <code>0...size()-1</code>, the behavior is undefined for
 * apps targeting {@link android.os.Build.VERSION_CODES#P} and earlier, and an
 * {@link java.lang.ArrayIndexOutOfBoundsException ArrayIndexOutOfBoundsException} is thrown for apps targeting
 * {@link android.os.Build.VERSION_CODES#Q} and later.</p>
 *
 * @param index The desired index, must be between 0 and {@link #size()}-1.
 * @return Returns the key stored at the given index.
 * @apiSince 19
 */

public K keyAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Return the value at the given index in the array.
 *
 * <p>For indices outside of the range <code>0...size()-1</code>, the behavior is undefined for
 * apps targeting {@link android.os.Build.VERSION_CODES#P} and earlier, and an
 * {@link java.lang.ArrayIndexOutOfBoundsException ArrayIndexOutOfBoundsException} is thrown for apps targeting
 * {@link android.os.Build.VERSION_CODES#Q} and later.</p>
 *
 * @param index The desired index, must be between 0 and {@link #size()}-1.
 * @return Returns the value stored at the given index.
 * @apiSince 19
 */

public V valueAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Set the value at a given index in the array.
 *
 * <p>For indices outside of the range <code>0...size()-1</code>, the behavior is undefined for
 * apps targeting {@link android.os.Build.VERSION_CODES#P} and earlier, and an
 * {@link java.lang.ArrayIndexOutOfBoundsException ArrayIndexOutOfBoundsException} is thrown for apps targeting
 * {@link android.os.Build.VERSION_CODES#Q} and later.</p>
 *
 * @param index The desired index, must be between 0 and {@link #size()}-1.
 * @param value The new value to store at this index.
 * @return Returns the previous value at the given index.
 * @apiSince 19
 */

public V setValueAt(int index, V value) { throw new RuntimeException("Stub!"); }

/**
 * Return true if the array map contains no items.
 * @apiSince 19
 */

public boolean isEmpty() { throw new RuntimeException("Stub!"); }

/**
 * Add a new value to the array map.
 * @param key The key under which to store the value.  If
 * this key already exists in the array, its value will be replaced.
 * @param value The value to store for the given key.
 * @return Returns the old value that was stored for the given key, or null if there
 * was no such key.
 * @apiSince 19
 */

public V put(K key, V value) { throw new RuntimeException("Stub!"); }

/**
 * Perform a {@link #put(java.lang.Object,java.lang.Object)} of all key/value pairs in <var>array</var>
 * @param array The array whose contents are to be retrieved.
 * @apiSince 19
 */

public void putAll(android.util.ArrayMap<? extends K,? extends V> array) { throw new RuntimeException("Stub!"); }

/**
 * Remove an existing key from the array map.
 * @param key The key of the mapping to remove.
 * @return Returns the value that was stored under the key, or null if there
 * was no such key.
 * @apiSince 19
 */

public V remove(java.lang.Object key) { throw new RuntimeException("Stub!"); }

/**
 * Remove the key/value mapping at the given index.
 *
 * <p>For indices outside of the range <code>0...size()-1</code>, the behavior is undefined for
 * apps targeting {@link android.os.Build.VERSION_CODES#P} and earlier, and an
 * {@link java.lang.ArrayIndexOutOfBoundsException ArrayIndexOutOfBoundsException} is thrown for apps targeting
 * {@link android.os.Build.VERSION_CODES#Q} and later.</p>
 *
 * @param index The desired index, must be between 0 and {@link #size()}-1.
 * @return Returns the value that was stored at this index.
 * @apiSince 19
 */

public V removeAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Return the number of items in this array map.
 * @apiSince 19
 */

public int size() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * <p>This implementation returns false if the object is not a map, or
 * if the maps have different sizes. Otherwise, for each key in this map,
 * values of both maps are compared. If the values for any key are not
 * equal, the method returns false, otherwise it returns true.
 * @apiSince 19
 */

public boolean equals(java.lang.Object object) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 19
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * <p>This implementation composes a string by iterating over its mappings. If
 * this map contains itself as a key or a value, the string "(this Map)"
 * will appear in its place.
 * @apiSince 19
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Determine if the array map contains all of the keys in the given collection.
 * @param collection The collection whose contents are to be checked against.
 * @return Returns true if this array map contains a key for every entry
 * in <var>collection</var>, else returns false.
 * @apiSince 19
 */

public boolean containsAll(java.util.Collection<?> collection) { throw new RuntimeException("Stub!"); }

/**
 * Perform a {@link #put(java.lang.Object,java.lang.Object)} of all key/value pairs in <var>map</var>
 * @param map The map whose contents are to be retrieved.
 * @apiSince 19
 */

public void putAll(java.util.Map<? extends K,? extends V> map) { throw new RuntimeException("Stub!"); }

/**
 * Remove all keys in the array map that exist in the given collection.
 * @param collection The collection whose contents are to be used to remove keys.
 * @return Returns true if any keys were removed from the array map, else false.
 * @apiSince 19
 */

public boolean removeAll(java.util.Collection<?> collection) { throw new RuntimeException("Stub!"); }

/**
 * Remove all keys in the array map that do <b>not</b> exist in the given collection.
 * @param collection The collection whose contents are to be used to determine which
 * keys to keep.
 * @return Returns true if any keys were removed from the array map, else false.
 * @apiSince 19
 */

public boolean retainAll(java.util.Collection<?> collection) { throw new RuntimeException("Stub!"); }

/**
 * Return a {@link java.util.Set} for iterating over and interacting with all mappings
 * in the array map.
 *
 * <p><b>Note:</b> this is a very inefficient way to access the array contents, it
 * requires generating a number of temporary objects and allocates additional state
 * information associated with the container that will remain for the life of the container.</p>
 *
 * <p><b>Note:</b></p> the semantics of this
 * Set are subtly different than that of a {@link java.util.HashMap}: most important,
 * the {@link java.util.Map.Entry Map.Entry} object returned by its iterator is a single
 * object that exists for the entire iterator, so you can <b>not</b> hold on to it
 * after calling {@link java.util.Iterator#next() Iterator.next}.</p>
 * @apiSince 19
 */

public java.util.Set<java.util.Map.Entry<K,V>> entrySet() { throw new RuntimeException("Stub!"); }

/**
 * Return a {@link java.util.Set} for iterating over and interacting with all keys
 * in the array map.
 *
 * <p><b>Note:</b> this is a fairly inefficient way to access the array contents, it
 * requires generating a number of temporary objects and allocates additional state
 * information associated with the container that will remain for the life of the container.</p>
 * @apiSince 19
 */

public java.util.Set<K> keySet() { throw new RuntimeException("Stub!"); }

/**
 * Return a {@link java.util.Collection} for iterating over and interacting with all values
 * in the array map.
 *
 * <p><b>Note:</b> this is a fairly inefficient way to access the array contents, it
 * requires generating a number of temporary objects and allocates additional state
 * information associated with the container that will remain for the life of the container.</p>
 * @apiSince 19
 */

public java.util.Collection<V> values() { throw new RuntimeException("Stub!"); }
}

