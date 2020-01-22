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
 * Written by Doug Lea and Josh Bloch with assistance from members of JCP
 * JSR-166 Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 */



package java.util;


/**
 * A {@link java.util.SortedMap SortedMap} extended with navigation methods returning the
 * closest matches for given search targets. Methods
 * {@link #lowerEntry}, {@link #floorEntry}, {@link #ceilingEntry},
 * and {@link #higherEntry} return {@code Map.Entry} objects
 * associated with keys respectively less than, less than or equal,
 * greater than or equal, and greater than a given key, returning
 * {@code null} if there is no such key.  Similarly, methods
 * {@link #lowerKey}, {@link #floorKey}, {@link #ceilingKey}, and
 * {@link #higherKey} return only the associated keys. All of these
 * methods are designed for locating, not traversing entries.
 *
 * <p>A {@code NavigableMap} may be accessed and traversed in either
 * ascending or descending key order.  The {@link #descendingMap}
 * method returns a view of the map with the senses of all relational
 * and directional methods inverted. The performance of ascending
 * operations and views is likely to be faster than that of descending
 * ones.  Methods
 * {@link #subMap(java.lang.Object,boolean,java.lang.Object,boolean) subMap(K, boolean, K, boolean)},
 * {@link #headMap(java.lang.Object,boolean) headMap(K, boolean)}, and
 * {@link #tailMap(java.lang.Object,boolean) tailMap(K, boolean)}
 * differ from the like-named {@code SortedMap} methods in accepting
 * additional arguments describing whether lower and upper bounds are
 * inclusive versus exclusive.  Submaps of any {@code NavigableMap}
 * must implement the {@code NavigableMap} interface.
 *
 * <p>This interface additionally defines methods {@link #firstEntry},
 * {@link #pollFirstEntry}, {@link #lastEntry}, and
 * {@link #pollLastEntry} that return and/or remove the least and
 * greatest mappings, if any exist, else returning {@code null}.
 *
 * <p>Implementations of entry-returning methods are expected to
 * return {@code Map.Entry} pairs representing snapshots of mappings
 * at the time they were produced, and thus generally do <em>not</em>
 * support the optional {@code Entry.setValue} method. Note however
 * that it is possible to change mappings in the associated map using
 * method {@code put}.
 *
 * <p>Methods
 * {@link #subMap(java.lang.Object,java.lang.Object) subMap(K, K)},
 * {@link #headMap(java.lang.Object) headMap(K)}, and
 * {@link #tailMap(java.lang.Object) tailMap(K)}
 * are specified to return {@code SortedMap} to allow existing
 * implementations of {@code SortedMap} to be compatibly retrofitted to
 * implement {@code NavigableMap}, but extensions and implementations
 * of this interface are encouraged to override these methods to return
 * {@code NavigableMap}.  Similarly,
 * {@link #keySet()} can be overridden to return {@link java.util.NavigableSet NavigableSet}.
 *
 * @author Doug Lea
 * @author Josh Bloch
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 * @since 1.6
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface NavigableMap<K, V> extends java.util.SortedMap<K,V> {

/**
 * Returns a key-value mapping associated with the greatest key
 * strictly less than the given key, or {@code null} if there is
 * no such key.
 *
 * @param key the key
 * @return an entry with the greatest key less than {@code key},
 *         or {@code null} if there is no such key
 * @throws java.lang.ClassCastException if the specified key cannot be compared
 *         with the keys currently in the map
 * @throws java.lang.NullPointerException if the specified key is null
 *         and this map does not permit null keys
 * @apiSince 9
 */

@androidx.annotation.Nullable
public java.util.Map.Entry<K,V> lowerEntry(K key);

/**
 * Returns the greatest key strictly less than the given key, or
 * {@code null} if there is no such key.
 *
 * @param key the key
 * @return the greatest key less than {@code key},
 *         or {@code null} if there is no such key
 * @throws java.lang.ClassCastException if the specified key cannot be compared
 *         with the keys currently in the map
 * @throws java.lang.NullPointerException if the specified key is null
 *         and this map does not permit null keys
 * @apiSince 9
 */

@androidx.annotation.Nullable
public K lowerKey(K key);

/**
 * Returns a key-value mapping associated with the greatest key
 * less than or equal to the given key, or {@code null} if there
 * is no such key.
 *
 * @param key the key
 * @return an entry with the greatest key less than or equal to
 *         {@code key}, or {@code null} if there is no such key
 * @throws java.lang.ClassCastException if the specified key cannot be compared
 *         with the keys currently in the map
 * @throws java.lang.NullPointerException if the specified key is null
 *         and this map does not permit null keys
 * @apiSince 9
 */

@androidx.annotation.Nullable
public java.util.Map.Entry<K,V> floorEntry(K key);

/**
 * Returns the greatest key less than or equal to the given key,
 * or {@code null} if there is no such key.
 *
 * @param key the key
 * @return the greatest key less than or equal to {@code key},
 *         or {@code null} if there is no such key
 * @throws java.lang.ClassCastException if the specified key cannot be compared
 *         with the keys currently in the map
 * @throws java.lang.NullPointerException if the specified key is null
 *         and this map does not permit null keys
 * @apiSince 9
 */

@androidx.annotation.Nullable
public K floorKey(K key);

/**
 * Returns a key-value mapping associated with the least key
 * greater than or equal to the given key, or {@code null} if
 * there is no such key.
 *
 * @param key the key
 * @return an entry with the least key greater than or equal to
 *         {@code key}, or {@code null} if there is no such key
 * @throws java.lang.ClassCastException if the specified key cannot be compared
 *         with the keys currently in the map
 * @throws java.lang.NullPointerException if the specified key is null
 *         and this map does not permit null keys
 * @apiSince 9
 */

@androidx.annotation.Nullable
public java.util.Map.Entry<K,V> ceilingEntry(K key);

/**
 * Returns the least key greater than or equal to the given key,
 * or {@code null} if there is no such key.
 *
 * @param key the key
 * @return the least key greater than or equal to {@code key},
 *         or {@code null} if there is no such key
 * @throws java.lang.ClassCastException if the specified key cannot be compared
 *         with the keys currently in the map
 * @throws java.lang.NullPointerException if the specified key is null
 *         and this map does not permit null keys
 * @apiSince 9
 */

@androidx.annotation.Nullable
public K ceilingKey(K key);

/**
 * Returns a key-value mapping associated with the least key
 * strictly greater than the given key, or {@code null} if there
 * is no such key.
 *
 * @param key the key
 * @return an entry with the least key greater than {@code key},
 *         or {@code null} if there is no such key
 * @throws java.lang.ClassCastException if the specified key cannot be compared
 *         with the keys currently in the map
 * @throws java.lang.NullPointerException if the specified key is null
 *         and this map does not permit null keys
 * @apiSince 9
 */

@androidx.annotation.Nullable
public java.util.Map.Entry<K,V> higherEntry(K key);

/**
 * Returns the least key strictly greater than the given key, or
 * {@code null} if there is no such key.
 *
 * @param key the key
 * @return the least key greater than {@code key},
 *         or {@code null} if there is no such key
 * @throws java.lang.ClassCastException if the specified key cannot be compared
 *         with the keys currently in the map
 * @throws java.lang.NullPointerException if the specified key is null
 *         and this map does not permit null keys
 * @apiSince 9
 */

@androidx.annotation.Nullable
public K higherKey(K key);

/**
 * Returns a key-value mapping associated with the least
 * key in this map, or {@code null} if the map is empty.
 *
 * @return an entry with the least key,
 *         or {@code null} if this map is empty
 * @apiSince 9
 */

@androidx.annotation.Nullable
public java.util.Map.Entry<K,V> firstEntry();

/**
 * Returns a key-value mapping associated with the greatest
 * key in this map, or {@code null} if the map is empty.
 *
 * @return an entry with the greatest key,
 *         or {@code null} if this map is empty
 * @apiSince 9
 */

@androidx.annotation.Nullable
public java.util.Map.Entry<K,V> lastEntry();

/**
 * Removes and returns a key-value mapping associated with
 * the least key in this map, or {@code null} if the map is empty.
 *
 * @return the removed first entry of this map,
 *         or {@code null} if this map is empty
 * @apiSince 9
 */

@androidx.annotation.Nullable
public java.util.Map.Entry<K,V> pollFirstEntry();

/**
 * Removes and returns a key-value mapping associated with
 * the greatest key in this map, or {@code null} if the map is empty.
 *
 * @return the removed last entry of this map,
 *         or {@code null} if this map is empty
 * @apiSince 9
 */

@androidx.annotation.Nullable
public java.util.Map.Entry<K,V> pollLastEntry();

/**
 * Returns a reverse order view of the mappings contained in this map.
 * The descending map is backed by this map, so changes to the map are
 * reflected in the descending map, and vice-versa.  If either map is
 * modified while an iteration over a collection view of either map
 * is in progress (except through the iterator's own {@code remove}
 * operation), the results of the iteration are undefined.
 *
 * <p>The returned map has an ordering equivalent to
 * {@link java.util.Collections#reverseOrder(java.util.Comparator) Collections#reverseOrder(Comparator)}{@code (comparator())}.
 * The expression {@code m.descendingMap().descendingMap()} returns a
 * view of {@code m} essentially equivalent to {@code m}.
 *
 * @return a reverse order view of this map
 * @apiSince 9
 */

@androidx.annotation.NonNull
public java.util.NavigableMap<K,V> descendingMap();

/**
 * Returns a {@link java.util.NavigableSet NavigableSet} view of the keys contained in this map.
 * The set's iterator returns the keys in ascending order.
 * The set is backed by the map, so changes to the map are reflected in
 * the set, and vice-versa.  If the map is modified while an iteration
 * over the set is in progress (except through the iterator's own {@code
 * remove} operation), the results of the iteration are undefined.  The
 * set supports element removal, which removes the corresponding mapping
 * from the map, via the {@code Iterator.remove}, {@code Set.remove},
 * {@code removeAll}, {@code retainAll}, and {@code clear} operations.
 * It does not support the {@code add} or {@code addAll} operations.
 *
 * @return a navigable set view of the keys in this map
 * @apiSince 9
 */

@androidx.annotation.NonNull
public java.util.NavigableSet<K> navigableKeySet();

/**
 * Returns a reverse order {@link java.util.NavigableSet NavigableSet} view of the keys contained in this map.
 * The set's iterator returns the keys in descending order.
 * The set is backed by the map, so changes to the map are reflected in
 * the set, and vice-versa.  If the map is modified while an iteration
 * over the set is in progress (except through the iterator's own {@code
 * remove} operation), the results of the iteration are undefined.  The
 * set supports element removal, which removes the corresponding mapping
 * from the map, via the {@code Iterator.remove}, {@code Set.remove},
 * {@code removeAll}, {@code retainAll}, and {@code clear} operations.
 * It does not support the {@code add} or {@code addAll} operations.
 *
 * @return a reverse order navigable set view of the keys in this map
 * @apiSince 9
 */

@androidx.annotation.NonNull
public java.util.NavigableSet<K> descendingKeySet();

/**
 * Returns a view of the portion of this map whose keys range from
 * {@code fromKey} to {@code toKey}.  If {@code fromKey} and
 * {@code toKey} are equal, the returned map is empty unless
 * {@code fromInclusive} and {@code toInclusive} are both true.  The
 * returned map is backed by this map, so changes in the returned map are
 * reflected in this map, and vice-versa.  The returned map supports all
 * optional map operations that this map supports.
 *
 * <p>The returned map will throw an {@code IllegalArgumentException}
 * on an attempt to insert a key outside of its range, or to construct a
 * submap either of whose endpoints lie outside its range.
 *
 * @param fromKey low endpoint of the keys in the returned map
 * @param fromInclusive {@code true} if the low endpoint
 *        is to be included in the returned view
 * @param toKey high endpoint of the keys in the returned map
 * @param toInclusive {@code true} if the high endpoint
 *        is to be included in the returned view
 * @return a view of the portion of this map whose keys range from
 *         {@code fromKey} to {@code toKey}
 * @throws java.lang.ClassCastException if {@code fromKey} and {@code toKey}
 *         cannot be compared to one another using this map's comparator
 *         (or, if the map has no comparator, using natural ordering).
 *         Implementations may, but are not required to, throw this
 *         exception if {@code fromKey} or {@code toKey}
 *         cannot be compared to keys currently in the map.
 * @throws java.lang.NullPointerException if {@code fromKey} or {@code toKey}
 *         is null and this map does not permit null keys
 * @throws java.lang.IllegalArgumentException if {@code fromKey} is greater than
 *         {@code toKey}; or if this map itself has a restricted
 *         range, and {@code fromKey} or {@code toKey} lies
 *         outside the bounds of the range
 * @apiSince 9
 */

@androidx.annotation.NonNull
public java.util.NavigableMap<K,V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive);

/**
 * Returns a view of the portion of this map whose keys are less than (or
 * equal to, if {@code inclusive} is true) {@code toKey}.  The returned
 * map is backed by this map, so changes in the returned map are reflected
 * in this map, and vice-versa.  The returned map supports all optional
 * map operations that this map supports.
 *
 * <p>The returned map will throw an {@code IllegalArgumentException}
 * on an attempt to insert a key outside its range.
 *
 * @param toKey high endpoint of the keys in the returned map
 * @param inclusive {@code true} if the high endpoint
 *        is to be included in the returned view
 * @return a view of the portion of this map whose keys are less than
 *         (or equal to, if {@code inclusive} is true) {@code toKey}
 * @throws java.lang.ClassCastException if {@code toKey} is not compatible
 *         with this map's comparator (or, if the map has no comparator,
 *         if {@code toKey} does not implement {@link java.lang.Comparable Comparable}).
 *         Implementations may, but are not required to, throw this
 *         exception if {@code toKey} cannot be compared to keys
 *         currently in the map.
 * @throws java.lang.NullPointerException if {@code toKey} is null
 *         and this map does not permit null keys
 * @throws java.lang.IllegalArgumentException if this map itself has a
 *         restricted range, and {@code toKey} lies outside the
 *         bounds of the range
 * @apiSince 9
 */

@androidx.annotation.NonNull
public java.util.NavigableMap<K,V> headMap(K toKey, boolean inclusive);

/**
 * Returns a view of the portion of this map whose keys are greater than (or
 * equal to, if {@code inclusive} is true) {@code fromKey}.  The returned
 * map is backed by this map, so changes in the returned map are reflected
 * in this map, and vice-versa.  The returned map supports all optional
 * map operations that this map supports.
 *
 * <p>The returned map will throw an {@code IllegalArgumentException}
 * on an attempt to insert a key outside its range.
 *
 * @param fromKey low endpoint of the keys in the returned map
 * @param inclusive {@code true} if the low endpoint
 *        is to be included in the returned view
 * @return a view of the portion of this map whose keys are greater than
 *         (or equal to, if {@code inclusive} is true) {@code fromKey}
 * @throws java.lang.ClassCastException if {@code fromKey} is not compatible
 *         with this map's comparator (or, if the map has no comparator,
 *         if {@code fromKey} does not implement {@link java.lang.Comparable Comparable}).
 *         Implementations may, but are not required to, throw this
 *         exception if {@code fromKey} cannot be compared to keys
 *         currently in the map.
 * @throws java.lang.NullPointerException if {@code fromKey} is null
 *         and this map does not permit null keys
 * @throws java.lang.IllegalArgumentException if this map itself has a
 *         restricted range, and {@code fromKey} lies outside the
 *         bounds of the range
 * @apiSince 9
 */

@androidx.annotation.NonNull
public java.util.NavigableMap<K,V> tailMap(K fromKey, boolean inclusive);

/**
 * {@inheritDoc}
 *
 * <p>Equivalent to {@code subMap(fromKey, true, toKey, false)}.
 *
 * @throws java.lang.ClassCastException       {@inheritDoc}
 * @throws java.lang.NullPointerException     {@inheritDoc}
 * @throws java.lang.IllegalArgumentException {@inheritDoc}
 * @apiSince 9
 */

@androidx.annotation.NonNull
public java.util.SortedMap<K,V> subMap(K fromKey, K toKey);

/**
 * {@inheritDoc}
 *
 * <p>Equivalent to {@code headMap(toKey, false)}.
 *
 * @throws java.lang.ClassCastException       {@inheritDoc}
 * @throws java.lang.NullPointerException     {@inheritDoc}
 * @throws java.lang.IllegalArgumentException {@inheritDoc}
 * @apiSince 9
 */

@androidx.annotation.NonNull
public java.util.SortedMap<K,V> headMap(K toKey);

/**
 * {@inheritDoc}
 *
 * <p>Equivalent to {@code tailMap(fromKey, true)}.
 *
 * @throws java.lang.ClassCastException       {@inheritDoc}
 * @throws java.lang.NullPointerException     {@inheritDoc}
 * @throws java.lang.IllegalArgumentException {@inheritDoc}
 * @apiSince 9
 */

@androidx.annotation.NonNull
public java.util.SortedMap<K,V> tailMap(K fromKey);
}

