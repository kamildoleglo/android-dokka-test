/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */



package java.util;


/**
 * Hash table based implementation of the <tt>Map</tt> interface.  This
 * implementation provides all of the optional map operations, and permits
 * <tt>null</tt> values and the <tt>null</tt> key.  (The <tt>HashMap</tt>
 * class is roughly equivalent to <tt>Hashtable</tt>, except that it is
 * unsynchronized and permits nulls.)  This class makes no guarantees as to
 * the order of the map; in particular, it does not guarantee that the order
 * will remain constant over time.
 *
 * <p>This implementation provides constant-time performance for the basic
 * operations (<tt>get</tt> and <tt>put</tt>), assuming the hash function
 * disperses the elements properly among the buckets.  Iteration over
 * collection views requires time proportional to the "capacity" of the
 * <tt>HashMap</tt> instance (the number of buckets) plus its size (the number
 * of key-value mappings).  Thus, it's very important not to set the initial
 * capacity too high (or the load factor too low) if iteration performance is
 * important.
 *
 * <p>An instance of <tt>HashMap</tt> has two parameters that affect its
 * performance: <i>initial capacity</i> and <i>load factor</i>.  The
 * <i>capacity</i> is the number of buckets in the hash table, and the initial
 * capacity is simply the capacity at the time the hash table is created.  The
 * <i>load factor</i> is a measure of how full the hash table is allowed to
 * get before its capacity is automatically increased.  When the number of
 * entries in the hash table exceeds the product of the load factor and the
 * current capacity, the hash table is <i>rehashed</i> (that is, internal data
 * structures are rebuilt) so that the hash table has approximately twice the
 * number of buckets.
 *
 * <p>As a general rule, the default load factor (.75) offers a good
 * tradeoff between time and space costs.  Higher values decrease the
 * space overhead but increase the lookup cost (reflected in most of
 * the operations of the <tt>HashMap</tt> class, including
 * <tt>get</tt> and <tt>put</tt>).  The expected number of entries in
 * the map and its load factor should be taken into account when
 * setting its initial capacity, so as to minimize the number of
 * rehash operations.  If the initial capacity is greater than the
 * maximum number of entries divided by the load factor, no rehash
 * operations will ever occur.
 *
 * <p>If many mappings are to be stored in a <tt>HashMap</tt>
 * instance, creating it with a sufficiently large capacity will allow
 * the mappings to be stored more efficiently than letting it perform
 * automatic rehashing as needed to grow the table.  Note that using
 * many keys with the same {@code hashCode()} is a sure way to slow
 * down performance of any hash table. To ameliorate impact, when keys
 * are {@link java.lang.Comparable Comparable}, this class may use comparison order among
 * keys to help break ties.
 *
 * <p><strong>Note that this implementation is not synchronized.</strong>
 * If multiple threads access a hash map concurrently, and at least one of
 * the threads modifies the map structurally, it <i>must</i> be
 * synchronized externally.  (A structural modification is any operation
 * that adds or deletes one or more mappings; merely changing the value
 * associated with a key that an instance already contains is not a
 * structural modification.)  This is typically accomplished by
 * synchronizing on some object that naturally encapsulates the map.
 *
 * If no such object exists, the map should be "wrapped" using the
 * {@link java.util.Collections#synchronizedMap Collections#synchronizedMap}
 * method.  This is best done at creation time, to prevent accidental
 * unsynchronized access to the map:<pre>
 *   Map m = Collections.synchronizedMap(new HashMap(...));</pre>
 *
 * <p>The iterators returned by all of this class's "collection view methods"
 * are <i>fail-fast</i>: if the map is structurally modified at any time after
 * the iterator is created, in any way except through the iterator's own
 * <tt>remove</tt> method, the iterator will throw a
 * {@link java.util.ConcurrentModificationException ConcurrentModificationException}.  Thus, in the face of concurrent
 * modification, the iterator fails quickly and cleanly, rather than risking
 * arbitrary, non-deterministic behavior at an undetermined time in the
 * future.
 *
 * <p>Note that the fail-fast behavior of an iterator cannot be guaranteed
 * as it is, generally speaking, impossible to make any hard guarantees in the
 * presence of unsynchronized concurrent modification.  Fail-fast iterators
 * throw <tt>ConcurrentModificationException</tt> on a best-effort basis.
 * Therefore, it would be wrong to write a program that depended on this
 * exception for its correctness: <i>the fail-fast behavior of iterators
 * should be used only to detect bugs.</i>
 *
 * <p>This class is a member of the
 * <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 *
 * @author  Doug Lea
 * @author  Josh Bloch
 * @author  Arthur van Hoff
 * @author  Neal Gafter
 * @see     java.lang.Object#hashCode()
 * @see     java.util.Collection
 * @see     java.util.Map
 * @see     java.util.TreeMap
 * @see     java.util.Hashtable
 * @since   1.2
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class HashMap<K, V> extends java.util.AbstractMap<K,V> implements java.util.Map<K,V>, java.lang.Cloneable, java.io.Serializable {

/**
 * Constructs an empty <tt>HashMap</tt> with the specified initial
 * capacity and load factor.
 *
 * @param  initialCapacity the initial capacity
 * @param  loadFactor      the load factor
 * @throws java.lang.IllegalArgumentException if the initial capacity is negative
 *         or the load factor is nonpositive
 * @apiSince 1
 */

public HashMap(int initialCapacity, float loadFactor) { throw new RuntimeException("Stub!"); }

/**
 * Constructs an empty <tt>HashMap</tt> with the specified initial
 * capacity and the default load factor (0.75).
 *
 * @param  initialCapacity the initial capacity.
 * @throws java.lang.IllegalArgumentException if the initial capacity is negative.
 * @apiSince 1
 */

public HashMap(int initialCapacity) { throw new RuntimeException("Stub!"); }

/**
 * Constructs an empty <tt>HashMap</tt> with the default initial capacity
 * (16) and the default load factor (0.75).
 * @apiSince 1
 */

public HashMap() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new <tt>HashMap</tt> with the same mappings as the
 * specified <tt>Map</tt>.  The <tt>HashMap</tt> is created with
 * default load factor (0.75) and an initial capacity sufficient to
 * hold the mappings in the specified <tt>Map</tt>.
 *
 * @param   m the map whose mappings are to be placed in this map
 * @throws  java.lang.NullPointerException if the specified map is null
 * @apiSince 1
 */

public HashMap(@androidx.annotation.NonNull java.util.Map<? extends K,? extends V> m) { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of key-value mappings in this map.
 *
 * @return the number of key-value mappings in this map
 * @apiSince 1
 */

public int size() { throw new RuntimeException("Stub!"); }

/**
 * Returns <tt>true</tt> if this map contains no key-value mappings.
 *
 * @return <tt>true</tt> if this map contains no key-value mappings
 * @apiSince 1
 */

public boolean isEmpty() { throw new RuntimeException("Stub!"); }

/**
 * Returns the value to which the specified key is mapped,
 * or {@code null} if this map contains no mapping for the key.
 *
 * <p>More formally, if this map contains a mapping from a key
 * {@code k} to a value {@code v} such that {@code (key==null ? k==null :
 * key.equals(k))}, then this method returns {@code v}; otherwise
 * it returns {@code null}.  (There can be at most one such mapping.)
 *
 * <p>A return value of {@code null} does not <i>necessarily</i>
 * indicate that the map contains no mapping for the key; it's also
 * possible that the map explicitly maps the key to {@code null}.
 * The {@link #containsKey containsKey} operation may be used to
 * distinguish these two cases.
 *
 * @see #put(Object, Object)
 * @apiSince 1
 */

@androidx.annotation.Nullable
public V get(@androidx.annotation.Nullable java.lang.Object key) { throw new RuntimeException("Stub!"); }

/**
 * Returns <tt>true</tt> if this map contains a mapping for the
 * specified key.
 *
 * @param   key   The key whose presence in this map is to be tested
 * @return <tt>true</tt> if this map contains a mapping for the specified
 * key.
 * @apiSince 1
 */

public boolean containsKey(@androidx.annotation.Nullable java.lang.Object key) { throw new RuntimeException("Stub!"); }

/**
 * Associates the specified value with the specified key in this map.
 * If the map previously contained a mapping for the key, the old
 * value is replaced.
 *
 * @param key key with which the specified value is to be associated
 * @param value value to be associated with the specified key
 * @return the previous value associated with <tt>key</tt>, or
 *         <tt>null</tt> if there was no mapping for <tt>key</tt>.
 *         (A <tt>null</tt> return can also indicate that the map
 *         previously associated <tt>null</tt> with <tt>key</tt>.)
 * @apiSince 1
 */

@androidx.annotation.Nullable
public V put(K key, V value) { throw new RuntimeException("Stub!"); }

/**
 * Copies all of the mappings from the specified map to this map.
 * These mappings will replace any mappings that this map had for
 * any of the keys currently in the specified map.
 *
 * @param m mappings to be stored in this map
 * @throws java.lang.NullPointerException if the specified map is null
 * @apiSince 1
 */

public void putAll(@androidx.annotation.NonNull java.util.Map<? extends K,? extends V> m) { throw new RuntimeException("Stub!"); }

/**
 * Removes the mapping for the specified key from this map if present.
 *
 * @param  key key whose mapping is to be removed from the map
 * @return the previous value associated with <tt>key</tt>, or
 *         <tt>null</tt> if there was no mapping for <tt>key</tt>.
 *         (A <tt>null</tt> return can also indicate that the map
 *         previously associated <tt>null</tt> with <tt>key</tt>.)
 * @apiSince 1
 */

@androidx.annotation.Nullable
public V remove(@androidx.annotation.Nullable java.lang.Object key) { throw new RuntimeException("Stub!"); }

/**
 * Removes all of the mappings from this map.
 * The map will be empty after this call returns.
 * @apiSince 1
 */

public void clear() { throw new RuntimeException("Stub!"); }

/**
 * Returns <tt>true</tt> if this map maps one or more keys to the
 * specified value.
 *
 * @param value value whose presence in this map is to be tested
 * @return <tt>true</tt> if this map maps one or more keys to the
 *         specified value
 * @apiSince 1
 */

public boolean containsValue(@androidx.annotation.Nullable java.lang.Object value) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.Set Set} view of the keys contained in this map.
 * The set is backed by the map, so changes to the map are
 * reflected in the set, and vice-versa.  If the map is modified
 * while an iteration over the set is in progress (except through
 * the iterator's own <tt>remove</tt> operation), the results of
 * the iteration are undefined.  The set supports element removal,
 * which removes the corresponding mapping from the map, via the
 * <tt>Iterator.remove</tt>, <tt>Set.remove</tt>,
 * <tt>removeAll</tt>, <tt>retainAll</tt>, and <tt>clear</tt>
 * operations.  It does not support the <tt>add</tt> or <tt>addAll</tt>
 * operations.
 *
 * @return a set view of the keys contained in this map
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.util.Set<K> keySet() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.Collection Collection} view of the values contained in this map.
 * The collection is backed by the map, so changes to the map are
 * reflected in the collection, and vice-versa.  If the map is
 * modified while an iteration over the collection is in progress
 * (except through the iterator's own <tt>remove</tt> operation),
 * the results of the iteration are undefined.  The collection
 * supports element removal, which removes the corresponding
 * mapping from the map, via the <tt>Iterator.remove</tt>,
 * <tt>Collection.remove</tt>, <tt>removeAll</tt>,
 * <tt>retainAll</tt> and <tt>clear</tt> operations.  It does not
 * support the <tt>add</tt> or <tt>addAll</tt> operations.
 *
 * @return a view of the values contained in this map
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.util.Collection<V> values() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.Set Set} view of the mappings contained in this map.
 * The set is backed by the map, so changes to the map are
 * reflected in the set, and vice-versa.  If the map is modified
 * while an iteration over the set is in progress (except through
 * the iterator's own <tt>remove</tt> operation, or through the
 * <tt>setValue</tt> operation on a map entry returned by the
 * iterator) the results of the iteration are undefined.  The set
 * supports element removal, which removes the corresponding
 * mapping from the map, via the <tt>Iterator.remove</tt>,
 * <tt>Set.remove</tt>, <tt>removeAll</tt>, <tt>retainAll</tt> and
 * <tt>clear</tt> operations.  It does not support the
 * <tt>add</tt> or <tt>addAll</tt> operations.
 *
 * @return a set view of the mappings contained in this map
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.util.Set<java.util.Map.Entry<K,V>> entrySet() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

@androidx.annotation.Nullable
public V getOrDefault(@androidx.annotation.Nullable java.lang.Object key, @androidx.annotation.Nullable V defaultValue) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

@androidx.annotation.Nullable
public V putIfAbsent(K key, V value) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public boolean remove(@androidx.annotation.Nullable java.lang.Object key, @androidx.annotation.Nullable java.lang.Object value) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public boolean replace(K key, @androidx.annotation.Nullable V oldValue, V newValue) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

@androidx.annotation.Nullable
public V replace(K key, V value) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

@androidx.annotation.Nullable
public V computeIfAbsent(K key, @androidx.annotation.NonNull java.util.function.Function<? super K,? extends V> mappingFunction) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

@androidx.annotation.Nullable
public V computeIfPresent(K key, @androidx.annotation.NonNull java.util.function.BiFunction<? super K,? super V,? extends V> remappingFunction) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

@androidx.annotation.Nullable
public V compute(K key, @androidx.annotation.NonNull java.util.function.BiFunction<? super K,? super V,? extends V> remappingFunction) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

@androidx.annotation.Nullable
public V merge(K key, @androidx.annotation.NonNull V value, @androidx.annotation.NonNull java.util.function.BiFunction<? super V,? super V,? extends V> remappingFunction) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public void forEach(@androidx.annotation.NonNull java.util.function.BiConsumer<? super K,? super V> action) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public void replaceAll(@androidx.annotation.NonNull java.util.function.BiFunction<? super K,? super V,? extends V> function) { throw new RuntimeException("Stub!"); }

/**
 * Returns a shallow copy of this <tt>HashMap</tt> instance: the keys and
 * values themselves are not cloned.
 *
 * @return a shallow copy of this map
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.Object clone() { throw new RuntimeException("Stub!"); }
}

