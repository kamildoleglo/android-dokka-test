/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
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
 * A Red-Black tree based {@link java.util.NavigableMap NavigableMap} implementation.
 * The map is sorted according to the {@linkplain java.lang.Comparable Comparable} of its keys, or by a {@link java.util.Comparator Comparator} provided at map
 * creation time, depending on which constructor is used.
 *
 * <p>This implementation provides guaranteed log(n) time cost for the
 * {@code containsKey}, {@code get}, {@code put} and {@code remove}
 * operations.  Algorithms are adaptations of those in Cormen, Leiserson, and
 * Rivest's <em>Introduction to Algorithms</em>.
 *
 * <p>Note that the ordering maintained by a tree map, like any sorted map, and
 * whether or not an explicit comparator is provided, must be <em>consistent
 * with {@code equals}</em> if this sorted map is to correctly implement the
 * {@code Map} interface.  (See {@code Comparable} or {@code Comparator} for a
 * precise definition of <em>consistent with equals</em>.)  This is so because
 * the {@code Map} interface is defined in terms of the {@code equals}
 * operation, but a sorted map performs all key comparisons using its {@code
 * compareTo} (or {@code compare}) method, so two keys that are deemed equal by
 * this method are, from the standpoint of the sorted map, equal.  The behavior
 * of a sorted map <em>is</em> well-defined even if its ordering is
 * inconsistent with {@code equals}; it just fails to obey the general contract
 * of the {@code Map} interface.
 *
 * <p><strong>Note that this implementation is not synchronized.</strong>
 * If multiple threads access a map concurrently, and at least one of the
 * threads modifies the map structurally, it <em>must</em> be synchronized
 * externally.  (A structural modification is any operation that adds or
 * deletes one or more mappings; merely changing the value associated
 * with an existing key is not a structural modification.)  This is
 * typically accomplished by synchronizing on some object that naturally
 * encapsulates the map.
 * If no such object exists, the map should be "wrapped" using the
 * {@link java.util.Collections#synchronizedSortedMap Collections#synchronizedSortedMap}
 * method.  This is best done at creation time, to prevent accidental
 * unsynchronized access to the map: <pre>
 *   SortedMap m = Collections.synchronizedSortedMap(new TreeMap(...));</pre>
 *
 * <p>The iterators returned by the {@code iterator} method of the collections
 * returned by all of this class's "collection view methods" are
 * <em>fail-fast</em>: if the map is structurally modified at any time after
 * the iterator is created, in any way except through the iterator's own
 * {@code remove} method, the iterator will throw a {@link java.util.ConcurrentModificationException ConcurrentModificationException}.  Thus, in the face of concurrent
 * modification, the iterator fails quickly and cleanly, rather than risking
 * arbitrary, non-deterministic behavior at an undetermined time in the future.
 *
 * <p>Note that the fail-fast behavior of an iterator cannot be guaranteed
 * as it is, generally speaking, impossible to make any hard guarantees in the
 * presence of unsynchronized concurrent modification.  Fail-fast iterators
 * throw {@code ConcurrentModificationException} on a best-effort basis.
 * Therefore, it would be wrong to write a program that depended on this
 * exception for its correctness:   <em>the fail-fast behavior of iterators
 * should be used only to detect bugs.</em>
 *
 * <p>All {@code Map.Entry} pairs returned by methods in this class
 * and its views represent snapshots of mappings at the time they were
 * produced. They do <strong>not</strong> support the {@code Entry.setValue}
 * method. (Note however that it is possible to change mappings in the
 * associated map using {@code put}.)
 *
 * <p>This class is a member of the
 * <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 *
 * @author  Josh Bloch and Doug Lea
 * @see java.util.Map
 * @see java.util.HashMap
 * @see java.util.Hashtable
 * @see java.lang.Comparable
 * @see java.util.Comparator
 * @see java.util.Collection
 * @since 1.2
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TreeMap<K, V> extends java.util.AbstractMap<K,V> implements java.util.NavigableMap<K,V>, java.lang.Cloneable, java.io.Serializable {

/**
 * Constructs a new, empty tree map, using the natural ordering of its
 * keys.  All keys inserted into the map must implement the {@link java.lang.Comparable Comparable} interface.  Furthermore, all such keys must be
 * <em>mutually comparable</em>: {@code k1.compareTo(k2)} must not throw
 * a {@code ClassCastException} for any keys {@code k1} and
 * {@code k2} in the map.  If the user attempts to put a key into the
 * map that violates this constraint (for example, the user attempts to
 * put a string key into a map whose keys are integers), the
 * {@code put(Object key, Object value)} call will throw a
 * {@code ClassCastException}.
 * @apiSince 1
 */

public TreeMap() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new, empty tree map, ordered according to the given
 * comparator.  All keys inserted into the map must be <em>mutually
 * comparable</em> by the given comparator: {@code comparator.compare(k1,
 * k2)} must not throw a {@code ClassCastException} for any keys
 * {@code k1} and {@code k2} in the map.  If the user attempts to put
 * a key into the map that violates this constraint, the {@code put(Object
 * key, Object value)} call will throw a
 * {@code ClassCastException}.
 *
 * @param comparator the comparator that will be used to order this map.
 *        If {@code null}, the {@linkplain java.lang.Comparable Comparable} of the keys will be used.
 * @apiSince 1
 */

public TreeMap(@androidx.annotation.Nullable java.util.Comparator<? super K> comparator) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new tree map containing the same mappings as the given
 * map, ordered according to the <em>natural ordering</em> of its keys.
 * All keys inserted into the new map must implement the {@link java.lang.Comparable Comparable} interface.  Furthermore, all such keys must be
 * <em>mutually comparable</em>: {@code k1.compareTo(k2)} must not throw
 * a {@code ClassCastException} for any keys {@code k1} and
 * {@code k2} in the map.  This method runs in n*log(n) time.
 *
 * @param  m the map whose mappings are to be placed in this map
 * @throws java.lang.ClassCastException if the keys in m are not {@link java.lang.Comparable Comparable},
 *         or are not mutually comparable
 * @throws java.lang.NullPointerException if the specified map is null
 * @apiSince 1
 */

public TreeMap(@androidx.annotation.NonNull java.util.Map<? extends K,? extends V> m) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new tree map containing the same mappings and
 * using the same ordering as the specified sorted map.  This
 * method runs in linear time.
 *
 * @param  m the sorted map whose mappings are to be placed in this map,
 *         and whose comparator is to be used to sort this map
 * @throws java.lang.NullPointerException if the specified map is null
 * @apiSince 1
 */

public TreeMap(@androidx.annotation.NonNull java.util.SortedMap<K,? extends V> m) { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of key-value mappings in this map.
 *
 * @return the number of key-value mappings in this map
 * @apiSince 1
 */

public int size() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this map contains a mapping for the specified
 * key.
 *
 * @param key key whose presence in this map is to be tested
 * @return {@code true} if this map contains a mapping for the
 *         specified key
 * @throws java.lang.ClassCastException if the specified key cannot be compared
 *         with the keys currently in the map
 * @throws java.lang.NullPointerException if the specified key is null
 *         and this map uses natural ordering, or its comparator
 *         does not permit null keys
 * @apiSince 1
 */

public boolean containsKey(@androidx.annotation.Nullable java.lang.Object key) { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this map maps one or more keys to the
 * specified value.  More formally, returns {@code true} if and only if
 * this map contains at least one mapping to a value {@code v} such
 * that {@code (value==null ? v==null : value.equals(v))}.  This
 * operation will probably require time linear in the map size for
 * most implementations.
 *
 * @param value value whose presence in this map is to be tested
 * @return {@code true} if a mapping to {@code value} exists;
 *         {@code false} otherwise
 * @since 1.2
 * @apiSince 1
 */

public boolean containsValue(@androidx.annotation.Nullable java.lang.Object value) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value to which the specified key is mapped,
 * or {@code null} if this map contains no mapping for the key.
 *
 * <p>More formally, if this map contains a mapping from a key
 * {@code k} to a value {@code v} such that {@code key} compares
 * equal to {@code k} according to the map's ordering, then this
 * method returns {@code v}; otherwise it returns {@code null}.
 * (There can be at most one such mapping.)
 *
 * <p>A return value of {@code null} does not <em>necessarily</em>
 * indicate that the map contains no mapping for the key; it's also
 * possible that the map explicitly maps the key to {@code null}.
 * The {@link #containsKey containsKey} operation may be used to
 * distinguish these two cases.
 *
 * @throws java.lang.ClassCastException if the specified key cannot be compared
 *         with the keys currently in the map
 * @throws java.lang.NullPointerException if the specified key is null
 *         and this map uses natural ordering, or its comparator
 *         does not permit null keys
 * @apiSince 1
 */

@androidx.annotation.Nullable
public V get(@androidx.annotation.Nullable java.lang.Object key) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.Nullable
public java.util.Comparator<? super K> comparator() { throw new RuntimeException("Stub!"); }

/**
 * @throws java.util.NoSuchElementException {@inheritDoc}
 * @apiSince 1
 */

public K firstKey() { throw new RuntimeException("Stub!"); }

/**
 * @throws java.util.NoSuchElementException {@inheritDoc}
 * @apiSince 1
 */

public K lastKey() { throw new RuntimeException("Stub!"); }

/**
 * Copies all of the mappings from the specified map to this map.
 * These mappings replace any mappings that this map had for any
 * of the keys currently in the specified map.
 *
 * @param  map mappings to be stored in this map
 * @throws java.lang.ClassCastException if the class of a key or value in
 *         the specified map prevents it from being stored in this map
 * @throws java.lang.NullPointerException if the specified map is null or
 *         the specified map contains a null key and this map does not
 *         permit null keys
 * @apiSince 1
 */

public void putAll(@androidx.annotation.NonNull java.util.Map<? extends K,? extends V> map) { throw new RuntimeException("Stub!"); }

/**
 * Associates the specified value with the specified key in this map.
 * If the map previously contained a mapping for the key, the old
 * value is replaced.
 *
 * @param key key with which the specified value is to be associated
 * @param value value to be associated with the specified key
 *
 * @return the previous value associated with {@code key}, or
 *         {@code null} if there was no mapping for {@code key}.
 *         (A {@code null} return can also indicate that the map
 *         previously associated {@code null} with {@code key}.)
 * @throws java.lang.ClassCastException if the specified key cannot be compared
 *         with the keys currently in the map
 * @throws java.lang.NullPointerException if the specified key is null
 *         and this map uses natural ordering, or its comparator
 *         does not permit null keys
 * @apiSince 1
 */

@androidx.annotation.Nullable
public V put(K key, V value) { throw new RuntimeException("Stub!"); }

/**
 * Removes the mapping for this key from this TreeMap if present.
 *
 * @param  key key for which mapping should be removed
 * @return the previous value associated with {@code key}, or
 *         {@code null} if there was no mapping for {@code key}.
 *         (A {@code null} return can also indicate that the map
 *         previously associated {@code null} with {@code key}.)
 * @throws java.lang.ClassCastException if the specified key cannot be compared
 *         with the keys currently in the map
 * @throws java.lang.NullPointerException if the specified key is null
 *         and this map uses natural ordering, or its comparator
 *         does not permit null keys
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
 * Returns a shallow copy of this {@code TreeMap} instance. (The keys and
 * values themselves are not cloned.)
 *
 * @return a shallow copy of this map
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.Object clone() { throw new RuntimeException("Stub!"); }

/**
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.Nullable
public java.util.Map.Entry<K,V> firstEntry() { throw new RuntimeException("Stub!"); }

/**
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.Nullable
public java.util.Map.Entry<K,V> lastEntry() { throw new RuntimeException("Stub!"); }

/**
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.Nullable
public java.util.Map.Entry<K,V> pollFirstEntry() { throw new RuntimeException("Stub!"); }

/**
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.Nullable
public java.util.Map.Entry<K,V> pollLastEntry() { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if the specified key is null
 *         and this map uses natural ordering, or its comparator
 *         does not permit null keys
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.Nullable
public java.util.Map.Entry<K,V> lowerEntry(K key) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if the specified key is null
 *         and this map uses natural ordering, or its comparator
 *         does not permit null keys
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.Nullable
public K lowerKey(K key) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if the specified key is null
 *         and this map uses natural ordering, or its comparator
 *         does not permit null keys
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.Nullable
public java.util.Map.Entry<K,V> floorEntry(K key) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if the specified key is null
 *         and this map uses natural ordering, or its comparator
 *         does not permit null keys
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.Nullable
public K floorKey(K key) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if the specified key is null
 *         and this map uses natural ordering, or its comparator
 *         does not permit null keys
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.Nullable
public java.util.Map.Entry<K,V> ceilingEntry(K key) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if the specified key is null
 *         and this map uses natural ordering, or its comparator
 *         does not permit null keys
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.Nullable
public K ceilingKey(K key) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if the specified key is null
 *         and this map uses natural ordering, or its comparator
 *         does not permit null keys
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.Nullable
public java.util.Map.Entry<K,V> higherEntry(K key) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if the specified key is null
 *         and this map uses natural ordering, or its comparator
 *         does not permit null keys
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.Nullable
public K higherKey(K key) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.Set Set} view of the keys contained in this map.
 *
 * <p>The set's iterator returns the keys in ascending order.
 * The set's spliterator is
 * <em><a href="Spliterator.html#binding">late-binding</a></em>,
 * <em>fail-fast</em>, and additionally reports {@link java.util.Spliterator#SORTED Spliterator#SORTED}
 * and {@link java.util.Spliterator#ORDERED Spliterator#ORDERED} with an encounter order that is ascending
 * key order.  The spliterator's comparator (see
 * {@link java.util.Spliterator#getComparator()}) is {@code null} if
 * the tree map's comparator (see {@link #comparator()}) is {@code null}.
 * Otherwise, the spliterator's comparator is the same as or imposes the
 * same total ordering as the tree map's comparator.
 *
 * <p>The set is backed by the map, so changes to the map are
 * reflected in the set, and vice-versa.  If the map is modified
 * while an iteration over the set is in progress (except through
 * the iterator's own {@code remove} operation), the results of
 * the iteration are undefined.  The set supports element removal,
 * which removes the corresponding mapping from the map, via the
 * {@code Iterator.remove}, {@code Set.remove},
 * {@code removeAll}, {@code retainAll}, and {@code clear}
 * operations.  It does not support the {@code add} or {@code addAll}
 * operations.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.util.Set<K> keySet() { throw new RuntimeException("Stub!"); }

/**
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.NonNull
public java.util.NavigableSet<K> navigableKeySet() { throw new RuntimeException("Stub!"); }

/**
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.NonNull
public java.util.NavigableSet<K> descendingKeySet() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.Collection Collection} view of the values contained in this map.
 *
 * <p>The collection's iterator returns the values in ascending order
 * of the corresponding keys. The collection's spliterator is
 * <em><a href="Spliterator.html#binding">late-binding</a></em>,
 * <em>fail-fast</em>, and additionally reports {@link java.util.Spliterator#ORDERED Spliterator#ORDERED}
 * with an encounter order that is ascending order of the corresponding
 * keys.
 *
 * <p>The collection is backed by the map, so changes to the map are
 * reflected in the collection, and vice-versa.  If the map is
 * modified while an iteration over the collection is in progress
 * (except through the iterator's own {@code remove} operation),
 * the results of the iteration are undefined.  The collection
 * supports element removal, which removes the corresponding
 * mapping from the map, via the {@code Iterator.remove},
 * {@code Collection.remove}, {@code removeAll},
 * {@code retainAll} and {@code clear} operations.  It does not
 * support the {@code add} or {@code addAll} operations.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.util.Collection<V> values() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.Set Set} view of the mappings contained in this map.
 *
 * <p>The set's iterator returns the entries in ascending key order. The
 * sets's spliterator is
 * <em><a href="Spliterator.html#binding">late-binding</a></em>,
 * <em>fail-fast</em>, and additionally reports {@link java.util.Spliterator#SORTED Spliterator#SORTED} and
 * {@link java.util.Spliterator#ORDERED Spliterator#ORDERED} with an encounter order that is ascending key
 * order.
 *
 * <p>The set is backed by the map, so changes to the map are
 * reflected in the set, and vice-versa.  If the map is modified
 * while an iteration over the set is in progress (except through
 * the iterator's own {@code remove} operation, or through the
 * {@code setValue} operation on a map entry returned by the
 * iterator) the results of the iteration are undefined.  The set
 * supports element removal, which removes the corresponding
 * mapping from the map, via the {@code Iterator.remove},
 * {@code Set.remove}, {@code removeAll}, {@code retainAll} and
 * {@code clear} operations.  It does not support the
 * {@code add} or {@code addAll} operations.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.util.Set<java.util.Map.Entry<K,V>> entrySet() { throw new RuntimeException("Stub!"); }

/**
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.NonNull
public java.util.NavigableMap<K,V> descendingMap() { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.ClassCastException       {@inheritDoc}
 * @throws java.lang.NullPointerException if {@code fromKey} or {@code toKey} is
 *         null and this map uses natural ordering, or its comparator
 *         does not permit null keys
 * @throws java.lang.IllegalArgumentException {@inheritDoc}
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.NonNull
public java.util.NavigableMap<K,V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.ClassCastException       {@inheritDoc}
 * @throws java.lang.NullPointerException if {@code toKey} is null
 *         and this map uses natural ordering, or its comparator
 *         does not permit null keys
 * @throws java.lang.IllegalArgumentException {@inheritDoc}
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.NonNull
public java.util.NavigableMap<K,V> headMap(K toKey, boolean inclusive) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.ClassCastException       {@inheritDoc}
 * @throws java.lang.NullPointerException if {@code fromKey} is null
 *         and this map uses natural ordering, or its comparator
 *         does not permit null keys
 * @throws java.lang.IllegalArgumentException {@inheritDoc}
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.NonNull
public java.util.NavigableMap<K,V> tailMap(K fromKey, boolean inclusive) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.ClassCastException       {@inheritDoc}
 * @throws java.lang.NullPointerException if {@code fromKey} or {@code toKey} is
 *         null and this map uses natural ordering, or its comparator
 *         does not permit null keys
 * @throws java.lang.IllegalArgumentException {@inheritDoc}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.util.SortedMap<K,V> subMap(K fromKey, K toKey) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.ClassCastException       {@inheritDoc}
 * @throws java.lang.NullPointerException if {@code toKey} is null
 *         and this map uses natural ordering, or its comparator
 *         does not permit null keys
 * @throws java.lang.IllegalArgumentException {@inheritDoc}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.util.SortedMap<K,V> headMap(K toKey) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.ClassCastException       {@inheritDoc}
 * @throws java.lang.NullPointerException if {@code fromKey} is null
 *         and this map uses natural ordering, or its comparator
 *         does not permit null keys
 * @throws java.lang.IllegalArgumentException {@inheritDoc}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.util.SortedMap<K,V> tailMap(K fromKey) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public boolean replace(K key, @androidx.annotation.Nullable V oldValue, V newValue) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public V replace(K key, V value) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public void forEach(@androidx.annotation.NonNull java.util.function.BiConsumer<? super K,? super V> action) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public void replaceAll(@androidx.annotation.NonNull java.util.function.BiFunction<? super K,? super V,? extends V> function) { throw new RuntimeException("Stub!"); }
}

