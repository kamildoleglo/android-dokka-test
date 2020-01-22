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
 * <code>SparseArray</code> maps integers to Objects and, unlike a normal array of Objects,
 * its indices can contain gaps. <code>SparseArray</code> is intended to be more memory-efficient
 * than a
 * <a href="/reference/java/util/HashMap"><code>HashMap</code></a>, because it avoids
 * auto-boxing keys and its data structure doesn't rely on an extra entry object
 * for each mapping.
 *
 * <p>Note that this container keeps its mappings in an array data structure,
 * using a binary search to find keys. The implementation is not intended to be appropriate for
 * data structures
 * that may contain large numbers of items. It is generally slower than a
 * <code>HashMap</code> because lookups require a binary search,
 * and adds and removes require inserting
 * and deleting entries in the array. For containers holding up to hundreds of items,
 * the performance difference is less than 50%.
 *
 * <p>To help with performance, the container includes an optimization when removing
 * keys: instead of compacting its array immediately, it leaves the removed entry marked
 * as deleted. The entry can then be re-used for the same key or compacted later in
 * a single garbage collection of all removed entries. This garbage collection
 * must be performed whenever the array needs to be grown, or when the map size or
 * entry values are retrieved.
 *
 * <p>It is possible to iterate over the items in this container using
 * {@link #keyAt(int)} and {@link #valueAt(int)}. Iterating over the keys using
 * <code>keyAt(int)</code> with ascending values of the index returns the
 * keys in ascending order. In the case of <code>valueAt(int)</code>, the
 * values corresponding to the keys are returned in ascending order.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SparseArray<E> implements java.lang.Cloneable {

/**
 * Creates a new SparseArray containing no mappings.
 * @apiSince 1
 */

public SparseArray() { throw new RuntimeException("Stub!"); }

/**
 * Creates a new SparseArray containing no mappings that will not
 * require any additional memory allocation to store the specified
 * number of mappings.  If you supply an initial capacity of 0, the
 * sparse array will be initialized with a light-weight representation
 * not requiring any additional array allocations.
 * @apiSince 1
 */

public SparseArray(int initialCapacity) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.util.SparseArray<E> clone() { throw new RuntimeException("Stub!"); }

/**
 * Gets the Object mapped from the specified key, or <code>null</code>
 * if no such mapping has been made.
 * @apiSince 1
 */

public E get(int key) { throw new RuntimeException("Stub!"); }

/**
 * Gets the Object mapped from the specified key, or the specified Object
 * if no such mapping has been made.
 * @apiSince 1
 */

public E get(int key, E valueIfKeyNotFound) { throw new RuntimeException("Stub!"); }

/**
 * Removes the mapping from the specified key, if there was any.
 * @apiSince 1
 */

public void delete(int key) { throw new RuntimeException("Stub!"); }

/**
 * Alias for {@link #delete(int)}.
 * @apiSince 1
 */

public void remove(int key) { throw new RuntimeException("Stub!"); }

/**
 * Removes the mapping at the specified index.
 *
 * <p>For indices outside of the range <code>0...size()-1</code>,
 * the behavior is undefined for apps targeting {@link android.os.Build.VERSION_CODES#P} and
 * earlier, and an {@link java.lang.ArrayIndexOutOfBoundsException ArrayIndexOutOfBoundsException} is thrown for apps targeting
 * {@link android.os.Build.VERSION_CODES#Q} and later.</p>
 * @apiSince 11
 */

public void removeAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Remove a range of mappings as a batch.
 *
 * @param index Index to begin at
 * @param size Number of mappings to remove
 *
 * <p>For indices outside of the range <code>0...size()-1</code>,
 * the behavior is undefined.</p>
 * @apiSince 19
 */

public void removeAtRange(int index, int size) { throw new RuntimeException("Stub!"); }

/**
 * Adds a mapping from the specified key to the specified value,
 * replacing the previous mapping from the specified key if there
 * was one.
 * @apiSince 1
 */

public void put(int key, E value) { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of key-value mappings that this SparseArray
 * currently stores.
 * @apiSince 1
 */

public int size() { throw new RuntimeException("Stub!"); }

/**
 * Given an index in the range <code>0...size()-1</code>, returns
 * the key from the <code>index</code>th key-value mapping that this
 * SparseArray stores.
 *
 * <p>The keys corresponding to indices in ascending order are guaranteed to
 * be in ascending order, e.g., <code>keyAt(0)</code> will return the
 * smallest key and <code>keyAt(size()-1)</code> will return the largest
 * key.</p>
 *
 * <p>For indices outside of the range <code>0...size()-1</code>,
 * the behavior is undefined for apps targeting {@link android.os.Build.VERSION_CODES#P} and
 * earlier, and an {@link java.lang.ArrayIndexOutOfBoundsException ArrayIndexOutOfBoundsException} is thrown for apps targeting
 * {@link android.os.Build.VERSION_CODES#Q} and later.</p>
 * @apiSince 1
 */

public int keyAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Given an index in the range <code>0...size()-1</code>, returns
 * the value from the <code>index</code>th key-value mapping that this
 * SparseArray stores.
 *
 * <p>The values corresponding to indices in ascending order are guaranteed
 * to be associated with keys in ascending order, e.g.,
 * <code>valueAt(0)</code> will return the value associated with the
 * smallest key and <code>valueAt(size()-1)</code> will return the value
 * associated with the largest key.</p>
 *
 * <p>For indices outside of the range <code>0...size()-1</code>,
 * the behavior is undefined for apps targeting {@link android.os.Build.VERSION_CODES#P} and
 * earlier, and an {@link java.lang.ArrayIndexOutOfBoundsException ArrayIndexOutOfBoundsException} is thrown for apps targeting
 * {@link android.os.Build.VERSION_CODES#Q} and later.</p>
 * @apiSince 1
 */

public E valueAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Given an index in the range <code>0...size()-1</code>, sets a new
 * value for the <code>index</code>th key-value mapping that this
 * SparseArray stores.
 *
 * <p>For indices outside of the range <code>0...size()-1</code>, the behavior is undefined for
 * apps targeting {@link android.os.Build.VERSION_CODES#P} and earlier, and an
 * {@link java.lang.ArrayIndexOutOfBoundsException ArrayIndexOutOfBoundsException} is thrown for apps targeting
 * {@link android.os.Build.VERSION_CODES#Q} and later.</p>
 * @apiSince 1
 */

public void setValueAt(int index, E value) { throw new RuntimeException("Stub!"); }

/**
 * Returns the index for which {@link #keyAt} would return the
 * specified key, or a negative number if the specified
 * key is not mapped.
 * @apiSince 1
 */

public int indexOfKey(int key) { throw new RuntimeException("Stub!"); }

/**
 * Returns an index for which {@link #valueAt} would return the
 * specified value, or a negative number if no keys map to the
 * specified value.
 * <p>Beware that this is a linear search, unlike lookups by key,
 * and that multiple keys can map to the same value and this will
 * find only one of them.
 * <p>Note also that unlike most collections' {@code indexOf} methods,
 * this method compares values using {@code ==} rather than {@code equals}.
 * @apiSince 1
 */

public int indexOfValue(E value) { throw new RuntimeException("Stub!"); }

/**
 * Removes all key-value mappings from this SparseArray.
 * @apiSince 1
 */

public void clear() { throw new RuntimeException("Stub!"); }

/**
 * Puts a key/value pair into the array, optimizing for the case where
 * the key is greater than all existing keys in the array.
 * @apiSince 1
 */

public void append(int key, E value) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * <p>This implementation composes a string by iterating over its mappings. If
 * this map contains itself as a value, the string "(this Map)"
 * will appear in its place.
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

