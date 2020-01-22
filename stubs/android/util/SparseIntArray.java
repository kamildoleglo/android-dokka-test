/*
 * Copyright (C) 2006 The Android Open Source Project
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


/**
 * SparseIntArrays map integers to integers.  Unlike a normal array of integers,
 * there can be gaps in the indices.  It is intended to be more memory efficient
 * than using a HashMap to map Integers to Integers, both because it avoids
 * auto-boxing keys and values and its data structure doesn't rely on an extra entry object
 * for each mapping.
 *
 * <p>Note that this container keeps its mappings in an array data structure,
 * using a binary search to find keys.  The implementation is not intended to be appropriate for
 * data structures
 * that may contain large numbers of items.  It is generally slower than a traditional
 * HashMap, since lookups require a binary search and adds and removes require inserting
 * and deleting entries in the array.  For containers holding up to hundreds of items,
 * the performance difference is not significant, less than 50%.</p>
 *
 * <p>It is possible to iterate over the items in this container using
 * {@link #keyAt(int)} and {@link #valueAt(int)}. Iterating over the keys using
 * <code>keyAt(int)</code> with ascending values of the index will return the
 * keys in ascending order, or the values corresponding to the keys in ascending
 * order in the case of <code>valueAt(int)</code>.</p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SparseIntArray implements java.lang.Cloneable {

/**
 * Creates a new SparseIntArray containing no mappings.
 * @apiSince 1
 */

public SparseIntArray() { throw new RuntimeException("Stub!"); }

/**
 * Creates a new SparseIntArray containing no mappings that will not
 * require any additional memory allocation to store the specified
 * number of mappings.  If you supply an initial capacity of 0, the
 * sparse array will be initialized with a light-weight representation
 * not requiring any additional array allocations.
 * @apiSince 1
 */

public SparseIntArray(int initialCapacity) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.util.SparseIntArray clone() { throw new RuntimeException("Stub!"); }

/**
 * Gets the int mapped from the specified key, or <code>0</code>
 * if no such mapping has been made.
 * @apiSince 1
 */

public int get(int key) { throw new RuntimeException("Stub!"); }

/**
 * Gets the int mapped from the specified key, or the specified value
 * if no such mapping has been made.
 * @apiSince 1
 */

public int get(int key, int valueIfKeyNotFound) { throw new RuntimeException("Stub!"); }

/**
 * Removes the mapping from the specified key, if there was any.
 * @apiSince 1
 */

public void delete(int key) { throw new RuntimeException("Stub!"); }

/**
 * Removes the mapping at the given index.
 * @apiSince 3
 */

public void removeAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Adds a mapping from the specified key to the specified value,
 * replacing the previous mapping from the specified key if there
 * was one.
 * @apiSince 1
 */

public void put(int key, int value) { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of key-value mappings that this SparseIntArray
 * currently stores.
 * @apiSince 1
 */

public int size() { throw new RuntimeException("Stub!"); }

/**
 * Given an index in the range <code>0...size()-1</code>, returns
 * the key from the <code>index</code>th key-value mapping that this
 * SparseIntArray stores.
 *
 * <p>The keys corresponding to indices in ascending order are guaranteed to
 * be in ascending order, e.g., <code>keyAt(0)</code> will return the
 * smallest key and <code>keyAt(size()-1)</code> will return the largest
 * key.</p>
 *
 * <p>For indices outside of the range <code>0...size()-1</code>, the behavior is undefined for
 * apps targeting {@link android.os.Build.VERSION_CODES#P} and earlier, and an
 * {@link java.lang.ArrayIndexOutOfBoundsException ArrayIndexOutOfBoundsException} is thrown for apps targeting
 * {@link android.os.Build.VERSION_CODES#Q} and later.</p>
 * @apiSince 1
 */

public int keyAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Given an index in the range <code>0...size()-1</code>, returns
 * the value from the <code>index</code>th key-value mapping that this
 * SparseIntArray stores.
 *
 * <p>The values corresponding to indices in ascending order are guaranteed
 * to be associated with keys in ascending order, e.g.,
 * <code>valueAt(0)</code> will return the value associated with the
 * smallest key and <code>valueAt(size()-1)</code> will return the value
 * associated with the largest key.</p>
 *
 * <p>For indices outside of the range <code>0...size()-1</code>, the behavior is undefined for
 * apps targeting {@link android.os.Build.VERSION_CODES#P} and earlier, and an
 * {@link java.lang.ArrayIndexOutOfBoundsException ArrayIndexOutOfBoundsException} is thrown for apps targeting
 * {@link android.os.Build.VERSION_CODES#Q} and later.</p>
 * @apiSince 1
 */

public int valueAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Directly set the value at a particular index.
 *
 * <p>For indices outside of the range <code>0...size()-1</code>, the behavior is undefined for
 * apps targeting {@link android.os.Build.VERSION_CODES#P} and earlier, and an
 * {@link java.lang.ArrayIndexOutOfBoundsException ArrayIndexOutOfBoundsException} is thrown for apps targeting
 * {@link android.os.Build.VERSION_CODES#Q} and later.</p>
 * @apiSince 29
 */

public void setValueAt(int index, int value) { throw new RuntimeException("Stub!"); }

/**
 * Returns the index for which {@link #keyAt} would return the
 * specified key, or a negative number if the specified
 * key is not mapped.
 * @apiSince 1
 */

public int indexOfKey(int key) { throw new RuntimeException("Stub!"); }

/**
 * Returns an index for which {@link #valueAt} would return the
 * specified key, or a negative number if no keys map to the
 * specified value.
 * Beware that this is a linear search, unlike lookups by key,
 * and that multiple keys can map to the same value and this will
 * find only one of them.
 * @apiSince 1
 */

public int indexOfValue(int value) { throw new RuntimeException("Stub!"); }

/**
 * Removes all key-value mappings from this SparseIntArray.
 * @apiSince 1
 */

public void clear() { throw new RuntimeException("Stub!"); }

/**
 * Puts a key/value pair into the array, optimizing for the case where
 * the key is greater than all existing keys in the array.
 * @apiSince 1
 */

public void append(int key, int value) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * <p>This implementation composes a string by iterating over its mappings.
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

