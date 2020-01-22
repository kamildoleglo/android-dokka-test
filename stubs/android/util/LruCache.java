/*
 * Copyright (C) 2011 The Android Open Source Project
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
 * A cache that holds strong references to a limited number of values. Each time
 * a value is accessed, it is moved to the head of a queue. When a value is
 * added to a full cache, the value at the end of that queue is evicted and may
 * become eligible for garbage collection.
 *
 * <p>If your cached values hold resources that need to be explicitly released,
 * override {@link #entryRemoved}.
 *
 * <p>If a cache miss should be computed on demand for the corresponding keys,
 * override {@link #create}. This simplifies the calling code, allowing it to
 * assume a value will always be returned, even when there's a cache miss.
 *
 * <p>By default, the cache size is measured in the number of entries. Override
 * {@link #sizeOf} to size the cache in different units. For example, this cache
 * is limited to 4MiB of bitmaps:
 * <pre>   {@code
 *   int cacheSize = 4 * 1024 * 1024; // 4MiB
 *   LruCache<String, Bitmap> bitmapCache = new LruCache<String, Bitmap>(cacheSize) {
 *       protected int sizeOf(String key, Bitmap value) {
 *           return value.getByteCount();
 *       }
 *   }}</pre>
 *
 * <p>This class is thread-safe. Perform multiple cache operations atomically by
 * synchronizing on the cache: <pre>   {@code
 *   synchronized (cache) {
 *     if (cache.get(key) == null) {
 *         cache.put(key, value);
 *     }
 *   }}</pre>
 *
 * <p>This class does not allow null to be used as a key or value. A return
 * value of null from {@link #get}, {@link #put} or {@link #remove} is
 * unambiguous: the key was not in the cache.
 *
 * <p>This class appeared in Android 3.1 (Honeycomb MR1); it's available as part
 * of <a href="http://developer.android.com/sdk/compatibility-library.html">Android's
 * Support Package</a> for earlier releases.
 * @apiSince 12
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class LruCache<K, V> {

/**
 * @param maxSize for caches that do not override {@link #sizeOf}, this is
 *     the maximum number of entries in the cache. For all other caches,
 *     this is the maximum sum of the sizes of the entries in this cache.
 * @apiSince 12
 */

public LruCache(int maxSize) { throw new RuntimeException("Stub!"); }

/**
 * Sets the size of the cache.
 *
 * @param maxSize The new maximum size.
 * @apiSince 21
 */

public void resize(int maxSize) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value for {@code key} if it exists in the cache or can be
 * created by {@code #create}. If a value was returned, it is moved to the
 * head of the queue. This returns null if a value is not cached and cannot
 * be created.
 * @apiSince 12
 */

public final V get(K key) { throw new RuntimeException("Stub!"); }

/**
 * Caches {@code value} for {@code key}. The value is moved to the head of
 * the queue.
 *
 * @return the previous value mapped by {@code key}.
 * @apiSince 12
 */

public final V put(K key, V value) { throw new RuntimeException("Stub!"); }

/**
 * Remove the eldest entries until the total of remaining entries is at or
 * below the requested size.
 *
 * @param maxSize the maximum size of the cache before returning. May be -1
 *            to evict even 0-sized elements.
 * @apiSince 17
 */

public void trimToSize(int maxSize) { throw new RuntimeException("Stub!"); }

/**
 * Removes the entry for {@code key} if it exists.
 *
 * @return the previous value mapped by {@code key}.
 * @apiSince 12
 */

public final V remove(K key) { throw new RuntimeException("Stub!"); }

/**
 * Called for entries that have been evicted or removed. This method is
 * invoked when a value is evicted to make space, removed by a call to
 * {@link #remove}, or replaced by a call to {@link #put}. The default
 * implementation does nothing.
 *
 * <p>The method is called without synchronization: other threads may
 * access the cache while this method is executing.
 *
 * @param evicted true if the entry is being removed to make space, false
 *     if the removal was caused by a {@link #put} or {@link #remove}.
 * @param newValue the new value for {@code key}, if it exists. If non-null,
 *     this removal was caused by a {@link #put}. Otherwise it was caused by
 *     an eviction or a {@link #remove}.
 * @apiSince 12
 */

protected void entryRemoved(boolean evicted, K key, V oldValue, V newValue) { throw new RuntimeException("Stub!"); }

/**
 * Called after a cache miss to compute a value for the corresponding key.
 * Returns the computed value or null if no value can be computed. The
 * default implementation returns null.
 *
 * <p>The method is called without synchronization: other threads may
 * access the cache while this method is executing.
 *
 * <p>If a value for {@code key} exists in the cache when this method
 * returns, the created value will be released with {@link #entryRemoved}
 * and discarded. This can occur when multiple threads request the same key
 * at the same time (causing multiple values to be created), or when one
 * thread calls {@link #put} while another is creating a value for the same
 * key.
 * @apiSince 12
 */

protected V create(K key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the size of the entry for {@code key} and {@code value} in
 * user-defined units.  The default implementation returns 1 so that size
 * is the number of entries and max size is the maximum number of entries.
 *
 * <p>An entry's size must not change while it is in the cache.
 * @apiSince 12
 */

protected int sizeOf(K key, V value) { throw new RuntimeException("Stub!"); }

/**
 * Clear the cache, calling {@link #entryRemoved} on each removed entry.
 * @apiSince 12
 */

public final void evictAll() { throw new RuntimeException("Stub!"); }

/**
 * For caches that do not override {@link #sizeOf}, this returns the number
 * of entries in the cache. For all other caches, this returns the sum of
 * the sizes of the entries in this cache.
 * @apiSince 12
 */

public final synchronized int size() { throw new RuntimeException("Stub!"); }

/**
 * For caches that do not override {@link #sizeOf}, this returns the maximum
 * number of entries in the cache. For all other caches, this returns the
 * maximum sum of the sizes of the entries in this cache.
 * @apiSince 12
 */

public final synchronized int maxSize() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of times {@link #get} returned a value that was
 * already present in the cache.
 * @apiSince 12
 */

public final synchronized int hitCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of times {@link #get} returned null or required a new
 * value to be created.
 * @apiSince 12
 */

public final synchronized int missCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of times {@link #create(java.lang.Object)} returned a value.
 * @apiSince 12
 */

public final synchronized int createCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of times {@link #put} was called.
 * @apiSince 12
 */

public final synchronized int putCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of values that have been evicted.
 * @apiSince 12
 */

public final synchronized int evictionCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of the current contents of the cache, ordered from least
 * recently accessed to most recently accessed.
 * @apiSince 12
 */

public final synchronized java.util.Map<K,V> snapshot() { throw new RuntimeException("Stub!"); }

/** @apiSince 12 */

public final synchronized java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

