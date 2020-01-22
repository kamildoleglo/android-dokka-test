/*
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

/*
 * This file is available under and governed by the GNU General Public
 * License version 2 only, as published by the Free Software Foundation.
 * However, the following notice accompanied the original version of this
 * file:
 *
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 */



package java.util.concurrent;

import java.util.Iterator;
import java.util.Map;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.Spliterator;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * A scalable concurrent {@link java.util.concurrent.ConcurrentNavigableMap ConcurrentNavigableMap} implementation.
 * The map is sorted according to the {@linkplain java.lang.Comparable Comparable} of its keys, or by a {@link java.util.Comparator Comparator} provided at map
 * creation time, depending on which constructor is used.
 *
 * <p>This class implements a concurrent variant of <a
 * href="http://en.wikipedia.org/wiki/Skip_list" target="_top">SkipLists</a>
 * providing expected average <i>log(n)</i> time cost for the
 * {@code containsKey}, {@code get}, {@code put} and
 * {@code remove} operations and their variants.  Insertion, removal,
 * update, and access operations safely execute concurrently by
 * multiple threads.
 *
 * <p>Iterators and spliterators are
 * <a href="package-summary.html#Weakly"><i>weakly consistent</i></a>.
 *
 * <p>Ascending key ordered views and their iterators are faster than
 * descending ones.
 *
 * <p>All {@code Map.Entry} pairs returned by methods in this class
 * and its views represent snapshots of mappings at the time they were
 * produced. They do <em>not</em> support the {@code Entry.setValue}
 * method. (Note however that it is possible to change mappings in the
 * associated map using {@code put}, {@code putIfAbsent}, or
 * {@code replace}, depending on exactly which effect you need.)
 *
 * <p>Beware that, unlike in most collections, the {@code size}
 * method is <em>not</em> a constant-time operation. Because of the
 * asynchronous nature of these maps, determining the current number
 * of elements requires a traversal of the elements, and so may report
 * inaccurate results if this collection is modified during traversal.
 * Additionally, the bulk operations {@code putAll}, {@code equals},
 * {@code toArray}, {@code containsValue}, and {@code clear} are
 * <em>not</em> guaranteed to be performed atomically. For example, an
 * iterator operating concurrently with a {@code putAll} operation
 * might view only some of the added elements.
 *
 * <p>This class and its views and iterators implement all of the
 * <em>optional</em> methods of the {@link java.util.Map Map} and {@link java.util.Iterator Iterator}
 * interfaces. Like most other concurrent collections, this class does
 * <em>not</em> permit the use of {@code null} keys or values because some
 * null return values cannot be reliably distinguished from the absence of
 * elements.
 *
 * @author Doug Lea
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 * @since 1.6
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ConcurrentSkipListMap<K, V> extends java.util.AbstractMap<K,V> implements java.util.concurrent.ConcurrentNavigableMap<K,V>, java.lang.Cloneable, java.io.Serializable {

/**
 * Constructs a new, empty map, sorted according to the
 * {@linkplain java.lang.Comparable Comparable} of the keys.
 * @apiSince 9
 */

public ConcurrentSkipListMap() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new, empty map, sorted according to the specified
 * comparator.
 *
 * @param comparator the comparator that will be used to order this map.
 *        If {@code null}, the {@linkplain java.lang.Comparable Comparable} of the keys will be used.
 * @apiSince 9
 */

public ConcurrentSkipListMap(java.util.Comparator<? super K> comparator) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new map containing the same mappings as the given map,
 * sorted according to the {@linkplain java.lang.Comparable Comparable} of
 * the keys.
 *
 * @param  m the map whose mappings are to be placed in this map
 * @throws java.lang.ClassCastException if the keys in {@code m} are not
 *         {@link java.lang.Comparable Comparable}, or are not mutually comparable
 * @throws java.lang.NullPointerException if the specified map or any of its keys
 *         or values are null
 * @apiSince 9
 */

public ConcurrentSkipListMap(java.util.Map<? extends K,? extends V> m) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new map containing the same mappings and using the
 * same ordering as the specified sorted map.
 *
 * @param m the sorted map whose mappings are to be placed in this
 *        map, and whose comparator is to be used to sort this map
 * @throws java.lang.NullPointerException if the specified sorted map or any of
 *         its keys or values are null
 * @apiSince 9
 */

public ConcurrentSkipListMap(java.util.SortedMap<K,? extends V> m) { throw new RuntimeException("Stub!"); }

/**
 * Returns a shallow copy of this {@code ConcurrentSkipListMap}
 * instance. (The keys and values themselves are not cloned.)
 *
 * @return a shallow copy of this map
 * @apiSince 9
 */

public java.util.concurrent.ConcurrentSkipListMap<K,V> clone() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this map contains a mapping for the specified
 * key.
 *
 * @param key key whose presence in this map is to be tested
 * @return {@code true} if this map contains a mapping for the specified key
 * @throws java.lang.ClassCastException if the specified key cannot be compared
 *         with the keys currently in the map
 * @throws java.lang.NullPointerException if the specified key is null
 * @apiSince 9
 */

public boolean containsKey(java.lang.Object key) { throw new RuntimeException("Stub!"); }

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
 * @throws java.lang.ClassCastException if the specified key cannot be compared
 *         with the keys currently in the map
 * @throws java.lang.NullPointerException if the specified key is null
 * @apiSince 9
 */

public V get(java.lang.Object key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value to which the specified key is mapped,
 * or the given defaultValue if this map contains no mapping for the key.
 *
 * @param key the key
 * @param defaultValue the value to return if this map contains
 * no mapping for the given key
 * @return the mapping for the key, if present; else the defaultValue
 * @throws java.lang.NullPointerException if the specified key is null
 * @since 1.8
 * @apiSince 24
 */

public V getOrDefault(java.lang.Object key, V defaultValue) { throw new RuntimeException("Stub!"); }

/**
 * Associates the specified value with the specified key in this map.
 * If the map previously contained a mapping for the key, the old
 * value is replaced.
 *
 * @param key key with which the specified value is to be associated
 * @param value value to be associated with the specified key
 * @return the previous value associated with the specified key, or
 *         {@code null} if there was no mapping for the key
 * @throws java.lang.ClassCastException if the specified key cannot be compared
 *         with the keys currently in the map
 * @throws java.lang.NullPointerException if the specified key or value is null
 * @apiSince 9
 */

public V put(K key, V value) { throw new RuntimeException("Stub!"); }

/**
 * Removes the mapping for the specified key from this map if present.
 *
 * @param  key key for which mapping should be removed
 * @return the previous value associated with the specified key, or
 *         {@code null} if there was no mapping for the key
 * @throws java.lang.ClassCastException if the specified key cannot be compared
 *         with the keys currently in the map
 * @throws java.lang.NullPointerException if the specified key is null
 * @apiSince 9
 */

public V remove(java.lang.Object key) { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this map maps one or more keys to the
 * specified value.  This operation requires time linear in the
 * map size. Additionally, it is possible for the map to change
 * during execution of this method, in which case the returned
 * result may be inaccurate.
 *
 * @param value value whose presence in this map is to be tested
 * @return {@code true} if a mapping to {@code value} exists;
 *         {@code false} otherwise
 * @throws java.lang.NullPointerException if the specified value is null
 * @apiSince 9
 */

public boolean containsValue(java.lang.Object value) { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of key-value mappings in this map.  If this map
 * contains more than {@code Integer.MAX_VALUE} elements, it
 * returns {@code Integer.MAX_VALUE}.
 *
 * <p>Beware that, unlike in most collections, this method is
 * <em>NOT</em> a constant-time operation. Because of the
 * asynchronous nature of these maps, determining the current
 * number of elements requires traversing them all to count them.
 * Additionally, it is possible for the size to change during
 * execution of this method, in which case the returned result
 * will be inaccurate. Thus, this method is typically not very
 * useful in concurrent applications.
 *
 * @return the number of elements in this map
 * @apiSince 9
 */

public int size() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this map contains no key-value mappings.
 * @return {@code true} if this map contains no key-value mappings
 * @apiSince 9
 */

public boolean isEmpty() { throw new RuntimeException("Stub!"); }

/**
 * Removes all of the mappings from this map.
 * @apiSince 9
 */

public void clear() { throw new RuntimeException("Stub!"); }

/**
 * If the specified key is not already associated with a value,
 * attempts to compute its value using the given mapping function
 * and enters it into this map unless {@code null}.  The function
 * is <em>NOT</em> guaranteed to be applied once atomically only
 * if the value is not present.
 *
 * @param key key with which the specified value is to be associated
 * @param mappingFunction the function to compute a value
 * @return the current (existing or computed) value associated with
 *         the specified key, or null if the computed value is null
 * @throws java.lang.NullPointerException if the specified key is null
 *         or the mappingFunction is null
 * @since 1.8
 * @apiSince 24
 */

public V computeIfAbsent(K key, java.util.function.Function<? super K,? extends V> mappingFunction) { throw new RuntimeException("Stub!"); }

/**
 * If the value for the specified key is present, attempts to
 * compute a new mapping given the key and its current mapped
 * value. The function is <em>NOT</em> guaranteed to be applied
 * once atomically.
 *
 * @param key key with which a value may be associated
 * @param remappingFunction the function to compute a value
 * @return the new value associated with the specified key, or null if none
 * @throws java.lang.NullPointerException if the specified key is null
 *         or the remappingFunction is null
 * @since 1.8
 * @apiSince 24
 */

public V computeIfPresent(K key, java.util.function.BiFunction<? super K,? super V,? extends V> remappingFunction) { throw new RuntimeException("Stub!"); }

/**
 * Attempts to compute a mapping for the specified key and its
 * current mapped value (or {@code null} if there is no current
 * mapping). The function is <em>NOT</em> guaranteed to be applied
 * once atomically.
 *
 * @param key key with which the specified value is to be associated
 * @param remappingFunction the function to compute a value
 * @return the new value associated with the specified key, or null if none
 * @throws java.lang.NullPointerException if the specified key is null
 *         or the remappingFunction is null
 * @since 1.8
 * @apiSince 24
 */

public V compute(K key, java.util.function.BiFunction<? super K,? super V,? extends V> remappingFunction) { throw new RuntimeException("Stub!"); }

/**
 * If the specified key is not already associated with a value,
 * associates it with the given value.  Otherwise, replaces the
 * value with the results of the given remapping function, or
 * removes if {@code null}. The function is <em>NOT</em>
 * guaranteed to be applied once atomically.
 *
 * @param key key with which the specified value is to be associated
 * @param value the value to use if absent
 * @param remappingFunction the function to recompute a value if present
 * @return the new value associated with the specified key, or null if none
 * @throws java.lang.NullPointerException if the specified key or value is null
 *         or the remappingFunction is null
 * @since 1.8
 * @apiSince 24
 */

public V merge(K key, V value, java.util.function.BiFunction<? super V,? super V,? extends V> remappingFunction) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.NavigableSet NavigableSet} view of the keys contained in this map.
 *
 * <p>The set's iterator returns the keys in ascending order.
 * The set's spliterator additionally reports {@link java.util.Spliterator#CONCURRENT Spliterator#CONCURRENT},
 * {@link java.util.Spliterator#NONNULL Spliterator#NONNULL}, {@link java.util.Spliterator#SORTED Spliterator#SORTED} and
 * {@link java.util.Spliterator#ORDERED Spliterator#ORDERED}, with an encounter order that is ascending
 * key order.  The spliterator's comparator (see
 * {@link java.util.Spliterator#getComparator()}) is {@code null} if
 * the map's comparator (see {@link #comparator()}) is {@code null}.
 * Otherwise, the spliterator's comparator is the same as or imposes the
 * same total ordering as the map's comparator.
 *
 * <p>The set is backed by the map, so changes to the map are
 * reflected in the set, and vice-versa.  The set supports element
 * removal, which removes the corresponding mapping from the map,
 * via the {@code Iterator.remove}, {@code Set.remove},
 * {@code removeAll}, {@code retainAll}, and {@code clear}
 * operations.  It does not support the {@code add} or {@code addAll}
 * operations.
 *
 * <p>The view's iterators and spliterators are
 * <a href="package-summary.html#Weakly"><i>weakly consistent</i></a>.
 *
 * <p>This method is equivalent to method {@code navigableKeySet}.
 *
 * @return a navigable set view of the keys in this map
 * @apiSince 9
 */

public java.util.NavigableSet<K> keySet() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public java.util.NavigableSet<K> navigableKeySet() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.Collection Collection} view of the values contained in this map.
 * <p>The collection's iterator returns the values in ascending order
 * of the corresponding keys. The collections's spliterator additionally
 * reports {@link java.util.Spliterator#CONCURRENT Spliterator#CONCURRENT}, {@link java.util.Spliterator#NONNULL Spliterator#NONNULL} and
 * {@link java.util.Spliterator#ORDERED Spliterator#ORDERED}, with an encounter order that is ascending
 * order of the corresponding keys.
 *
 * <p>The collection is backed by the map, so changes to the map are
 * reflected in the collection, and vice-versa.  The collection
 * supports element removal, which removes the corresponding
 * mapping from the map, via the {@code Iterator.remove},
 * {@code Collection.remove}, {@code removeAll},
 * {@code retainAll} and {@code clear} operations.  It does not
 * support the {@code add} or {@code addAll} operations.
 *
 * <p>The view's iterators and spliterators are
 * <a href="package-summary.html#Weakly"><i>weakly consistent</i></a>.
 * @apiSince 9
 */

public java.util.Collection<V> values() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.Set Set} view of the mappings contained in this map.
 *
 * <p>The set's iterator returns the entries in ascending key order.  The
 * set's spliterator additionally reports {@link java.util.Spliterator#CONCURRENT Spliterator#CONCURRENT},
 * {@link java.util.Spliterator#NONNULL Spliterator#NONNULL}, {@link java.util.Spliterator#SORTED Spliterator#SORTED} and
 * {@link java.util.Spliterator#ORDERED Spliterator#ORDERED}, with an encounter order that is ascending
 * key order.
 *
 * <p>The set is backed by the map, so changes to the map are
 * reflected in the set, and vice-versa.  The set supports element
 * removal, which removes the corresponding mapping from the map,
 * via the {@code Iterator.remove}, {@code Set.remove},
 * {@code removeAll}, {@code retainAll} and {@code clear}
 * operations.  It does not support the {@code add} or
 * {@code addAll} operations.
 *
 * <p>The view's iterators and spliterators are
 * <a href="package-summary.html#Weakly"><i>weakly consistent</i></a>.
 *
 * <p>The {@code Map.Entry} elements traversed by the {@code iterator}
 * or {@code spliterator} do <em>not</em> support the {@code setValue}
 * operation.
 *
 * @return a set view of the mappings contained in this map,
 *         sorted in ascending key order
 * @apiSince 9
 */

public java.util.Set<java.util.Map.Entry<K,V>> entrySet() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public java.util.concurrent.ConcurrentNavigableMap<K,V> descendingMap() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public java.util.NavigableSet<K> descendingKeySet() { throw new RuntimeException("Stub!"); }

/**
 * Compares the specified object with this map for equality.
 * Returns {@code true} if the given object is also a map and the
 * two maps represent the same mappings.  More formally, two maps
 * {@code m1} and {@code m2} represent the same mappings if
 * {@code m1.entrySet().equals(m2.entrySet())}.  This
 * operation may return misleading results if either map is
 * concurrently modified during execution of this method.
 *
 * @param o object to be compared for equality with this map
 * @return {@code true} if the specified object is equal to this map
 * @apiSince 9
 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * @return the previous value associated with the specified key,
 *         or {@code null} if there was no mapping for the key
 * @throws java.lang.ClassCastException if the specified key cannot be compared
 *         with the keys currently in the map
 * @throws java.lang.NullPointerException if the specified key or value is null
 * @apiSince 9
 */

public V putIfAbsent(K key, V value) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * @throws java.lang.ClassCastException if the specified key cannot be compared
 *         with the keys currently in the map
 * @throws java.lang.NullPointerException if the specified key is null
 * @apiSince 9
 */

public boolean remove(java.lang.Object key, java.lang.Object value) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * @throws java.lang.ClassCastException if the specified key cannot be compared
 *         with the keys currently in the map
 * @throws java.lang.NullPointerException if any of the arguments are null
 * @apiSince 9
 */

public boolean replace(K key, V oldValue, V newValue) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * @return the previous value associated with the specified key,
 *         or {@code null} if there was no mapping for the key
 * @throws java.lang.ClassCastException if the specified key cannot be compared
 *         with the keys currently in the map
 * @throws java.lang.NullPointerException if the specified key or value is null
 * @apiSince 9
 */

public V replace(K key, V value) { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public java.util.Comparator<? super K> comparator() { throw new RuntimeException("Stub!"); }

/**
 * @throws java.util.NoSuchElementException {@inheritDoc}
 * @apiSince 9
 */

public K firstKey() { throw new RuntimeException("Stub!"); }

/**
 * @throws java.util.NoSuchElementException {@inheritDoc}
 * @apiSince 9
 */

public K lastKey() { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if {@code fromKey} or {@code toKey} is null
 * @throws java.lang.IllegalArgumentException {@inheritDoc}
 * @apiSince 9
 */

public java.util.concurrent.ConcurrentNavigableMap<K,V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if {@code toKey} is null
 * @throws java.lang.IllegalArgumentException {@inheritDoc}
 * @apiSince 9
 */

public java.util.concurrent.ConcurrentNavigableMap<K,V> headMap(K toKey, boolean inclusive) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if {@code fromKey} is null
 * @throws java.lang.IllegalArgumentException {@inheritDoc}
 * @apiSince 9
 */

public java.util.concurrent.ConcurrentNavigableMap<K,V> tailMap(K fromKey, boolean inclusive) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if {@code fromKey} or {@code toKey} is null
 * @throws java.lang.IllegalArgumentException {@inheritDoc}
 * @apiSince 9
 */

public java.util.concurrent.ConcurrentNavigableMap<K,V> subMap(K fromKey, K toKey) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if {@code toKey} is null
 * @throws java.lang.IllegalArgumentException {@inheritDoc}
 * @apiSince 9
 */

public java.util.concurrent.ConcurrentNavigableMap<K,V> headMap(K toKey) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if {@code fromKey} is null
 * @throws java.lang.IllegalArgumentException {@inheritDoc}
 * @apiSince 9
 */

public java.util.concurrent.ConcurrentNavigableMap<K,V> tailMap(K fromKey) { throw new RuntimeException("Stub!"); }

/**
 * Returns a key-value mapping associated with the greatest key
 * strictly less than the given key, or {@code null} if there is
 * no such key. The returned entry does <em>not</em> support the
 * {@code Entry.setValue} method.
 *
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if the specified key is null
 * @apiSince 9
 */

public java.util.Map.Entry<K,V> lowerEntry(K key) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if the specified key is null
 * @apiSince 9
 */

public K lowerKey(K key) { throw new RuntimeException("Stub!"); }

/**
 * Returns a key-value mapping associated with the greatest key
 * less than or equal to the given key, or {@code null} if there
 * is no such key. The returned entry does <em>not</em> support
 * the {@code Entry.setValue} method.
 *
 * @param key the key
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if the specified key is null
 * @apiSince 9
 */

public java.util.Map.Entry<K,V> floorEntry(K key) { throw new RuntimeException("Stub!"); }

/**
 * @param key the key
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if the specified key is null
 * @apiSince 9
 */

public K floorKey(K key) { throw new RuntimeException("Stub!"); }

/**
 * Returns a key-value mapping associated with the least key
 * greater than or equal to the given key, or {@code null} if
 * there is no such entry. The returned entry does <em>not</em>
 * support the {@code Entry.setValue} method.
 *
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if the specified key is null
 * @apiSince 9
 */

public java.util.Map.Entry<K,V> ceilingEntry(K key) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if the specified key is null
 * @apiSince 9
 */

public K ceilingKey(K key) { throw new RuntimeException("Stub!"); }

/**
 * Returns a key-value mapping associated with the least key
 * strictly greater than the given key, or {@code null} if there
 * is no such key. The returned entry does <em>not</em> support
 * the {@code Entry.setValue} method.
 *
 * @param key the key
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if the specified key is null
 * @apiSince 9
 */

public java.util.Map.Entry<K,V> higherEntry(K key) { throw new RuntimeException("Stub!"); }

/**
 * @param key the key
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if the specified key is null
 * @apiSince 9
 */

public K higherKey(K key) { throw new RuntimeException("Stub!"); }

/**
 * Returns a key-value mapping associated with the least
 * key in this map, or {@code null} if the map is empty.
 * The returned entry does <em>not</em> support
 * the {@code Entry.setValue} method.
 * @apiSince 9
 */

public java.util.Map.Entry<K,V> firstEntry() { throw new RuntimeException("Stub!"); }

/**
 * Returns a key-value mapping associated with the greatest
 * key in this map, or {@code null} if the map is empty.
 * The returned entry does <em>not</em> support
 * the {@code Entry.setValue} method.
 * @apiSince 9
 */

public java.util.Map.Entry<K,V> lastEntry() { throw new RuntimeException("Stub!"); }

/**
 * Removes and returns a key-value mapping associated with
 * the least key in this map, or {@code null} if the map is empty.
 * The returned entry does <em>not</em> support
 * the {@code Entry.setValue} method.
 * @apiSince 9
 */

public java.util.Map.Entry<K,V> pollFirstEntry() { throw new RuntimeException("Stub!"); }

/**
 * Removes and returns a key-value mapping associated with
 * the greatest key in this map, or {@code null} if the map is empty.
 * The returned entry does <em>not</em> support
 * the {@code Entry.setValue} method.
 * @apiSince 9
 */

public java.util.Map.Entry<K,V> pollLastEntry() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public void forEach(java.util.function.BiConsumer<? super K,? super V> action) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public void replaceAll(java.util.function.BiFunction<? super K,? super V,? extends V> function) { throw new RuntimeException("Stub!"); }
}

