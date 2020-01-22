/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 2003, 2012, Oracle and/or its affiliates. All rights reserved.
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
 * A specialized {@link java.util.Map Map} implementation for use with enum type keys.  All
 * of the keys in an enum map must come from a single enum type that is
 * specified, explicitly or implicitly, when the map is created.  Enum maps
 * are represented internally as arrays.  This representation is extremely
 * compact and efficient.
 *
 * <p>Enum maps are maintained in the <i>natural order</i> of their keys
 * (the order in which the enum constants are declared).  This is reflected
 * in the iterators returned by the collections views ({@link #keySet()},
 * {@link #entrySet()}, and {@link #values()}).
 *
 * <p>Iterators returned by the collection views are <i>weakly consistent</i>:
 * they will never throw {@link java.util.ConcurrentModificationException ConcurrentModificationException} and they may
 * or may not show the effects of any modifications to the map that occur while
 * the iteration is in progress.
 *
 * <p>Null keys are not permitted.  Attempts to insert a null key will
 * throw {@link java.lang.NullPointerException NullPointerException}.  Attempts to test for the
 * presence of a null key or to remove one will, however, function properly.
 * Null values are permitted.
 
 * <P>Like most collection implementations <tt>EnumMap</tt> is not
 * synchronized. If multiple threads access an enum map concurrently, and at
 * least one of the threads modifies the map, it should be synchronized
 * externally.  This is typically accomplished by synchronizing on some
 * object that naturally encapsulates the enum map.  If no such object exists,
 * the map should be "wrapped" using the {@link java.util.Collections#synchronizedMap Collections#synchronizedMap}
 * method.  This is best done at creation time, to prevent accidental
 * unsynchronized access:
 *
 * <pre>
 *     Map&lt;EnumKey, V&gt; m
 *         = Collections.synchronizedMap(new EnumMap&lt;EnumKey, V&gt;(...));
 * </pre>
 *
 * <p>Implementation note: All basic operations execute in constant time.
 * They are likely (though not guaranteed) to be faster than their
 * {@link java.util.HashMap HashMap} counterparts.
 *
 * <p>This class is a member of the
 * <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @author Josh Bloch
 * @see java.util.EnumSet
 * @since 1.5
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class EnumMap<K extends java.lang.Enum<K>, V> extends java.util.AbstractMap<K,V> implements java.io.Serializable, java.lang.Cloneable {

/**
 * Creates an empty enum map with the specified key type.
 *
 * @param keyType the class object of the key type for this enum map
 * @throws java.lang.NullPointerException if <tt>keyType</tt> is null
 * @apiSince 1
 */

public EnumMap(java.lang.Class<K> keyType) { throw new RuntimeException("Stub!"); }

/**
 * Creates an enum map with the same key type as the specified enum
 * map, initially containing the same mappings (if any).
 *
 * @param m the enum map from which to initialize this enum map
 * @throws java.lang.NullPointerException if <tt>m</tt> is null
 * @apiSince 1
 */

public EnumMap(java.util.EnumMap<K,? extends V> m) { throw new RuntimeException("Stub!"); }

/**
 * Creates an enum map initialized from the specified map.  If the
 * specified map is an <tt>EnumMap</tt> instance, this constructor behaves
 * identically to {@link #EnumMap(java.util.EnumMap)}.  Otherwise, the specified map
 * must contain at least one mapping (in order to determine the new
 * enum map's key type).
 *
 * @param m the map from which to initialize this enum map
 * @throws java.lang.IllegalArgumentException if <tt>m</tt> is not an
 *     <tt>EnumMap</tt> instance and contains no mappings
 * @throws java.lang.NullPointerException if <tt>m</tt> is null
 * @apiSince 1
 */

public EnumMap(java.util.Map<K,? extends V> m) { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of key-value mappings in this map.
 *
 * @return the number of key-value mappings in this map
 * @apiSince 1
 */

public int size() { throw new RuntimeException("Stub!"); }

/**
 * Returns <tt>true</tt> if this map maps one or more keys to the
 * specified value.
 *
 * @param value the value whose presence in this map is to be tested
 * @return <tt>true</tt> if this map maps one or more keys to this value
 * @apiSince 1
 */

public boolean containsValue(java.lang.Object value) { throw new RuntimeException("Stub!"); }

/**
 * Returns <tt>true</tt> if this map contains a mapping for the specified
 * key.
 *
 * @param key the key whose presence in this map is to be tested
 * @return <tt>true</tt> if this map contains a mapping for the specified
 *            key
 * @apiSince 1
 */

public boolean containsKey(java.lang.Object key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value to which the specified key is mapped,
 * or {@code null} if this map contains no mapping for the key.
 *
 * <p>More formally, if this map contains a mapping from a key
 * {@code k} to a value {@code v} such that {@code (key == k)},
 * then this method returns {@code v}; otherwise it returns
 * {@code null}.  (There can be at most one such mapping.)
 *
 * <p>A return value of {@code null} does not <i>necessarily</i>
 * indicate that the map contains no mapping for the key; it's also
 * possible that the map explicitly maps the key to {@code null}.
 * The {@link #containsKey containsKey} operation may be used to
 * distinguish these two cases.
 * @apiSince 1
 */

public V get(java.lang.Object key) { throw new RuntimeException("Stub!"); }

/**
 * Associates the specified value with the specified key in this map.
 * If the map previously contained a mapping for this key, the old
 * value is replaced.
 *
 * @param key the key with which the specified value is to be associated
 * @param value the value to be associated with the specified key
 *
 * @return the previous value associated with specified key, or
 *     <tt>null</tt> if there was no mapping for key.  (A <tt>null</tt>
 *     return can also indicate that the map previously associated
 *     <tt>null</tt> with the specified key.)
 * @throws java.lang.NullPointerException if the specified key is null
 * @apiSince 1
 */

public V put(K key, V value) { throw new RuntimeException("Stub!"); }

/**
 * Removes the mapping for this key from this map if present.
 *
 * @param key the key whose mapping is to be removed from the map
 * @return the previous value associated with specified key, or
 *     <tt>null</tt> if there was no entry for key.  (A <tt>null</tt>
 *     return can also indicate that the map previously associated
 *     <tt>null</tt> with the specified key.)
 * @apiSince 1
 */

public V remove(java.lang.Object key) { throw new RuntimeException("Stub!"); }

/**
 * Copies all of the mappings from the specified map to this map.
 * These mappings will replace any mappings that this map had for
 * any of the keys currently in the specified map.
 *
 * @param m the mappings to be stored in this map
 * @throws java.lang.NullPointerException the specified map is null, or if
 *     one or more keys in the specified map are null
 * @apiSince 1
 */

public void putAll(java.util.Map<? extends K,? extends V> m) { throw new RuntimeException("Stub!"); }

/**
 * Removes all mappings from this map.
 * @apiSince 1
 */

public void clear() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.Set Set} view of the keys contained in this map.
 * The returned set obeys the general contract outlined in
 * {@link java.util.Map#keySet() Map#keySet()}.  The set's iterator will return the keys
 * in their natural order (the order in which the enum constants
 * are declared).
 *
 * @return a set view of the keys contained in this enum map
 * @apiSince 1
 */

public java.util.Set<K> keySet() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.Collection Collection} view of the values contained in this map.
 * The returned collection obeys the general contract outlined in
 * {@link java.util.Map#values() Map#values()}.  The collection's iterator will return the
 * values in the order their corresponding keys appear in map,
 * which is their natural order (the order in which the enum constants
 * are declared).
 *
 * @return a collection view of the values contained in this map
 * @apiSince 1
 */

public java.util.Collection<V> values() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.Set Set} view of the mappings contained in this map.
 * The returned set obeys the general contract outlined in
 * {@link java.util.Map#keySet() Map#keySet()}.  The set's iterator will return the
 * mappings in the order their keys appear in map, which is their
 * natural order (the order in which the enum constants are declared).
 *
 * @return a set view of the mappings contained in this enum map
 * @apiSince 1
 */

public java.util.Set<java.util.Map.Entry<K,V>> entrySet() { throw new RuntimeException("Stub!"); }

/**
 * Compares the specified object with this map for equality.  Returns
 * <tt>true</tt> if the given object is also a map and the two maps
 * represent the same mappings, as specified in the {@link java.util.Map#equals(java.lang.Object) Map#equals(Object)} contract.
 *
 * @param o the object to be compared for equality with this map
 * @return <tt>true</tt> if the specified object is equal to this map
 * @apiSince 1
 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Returns the hash code value for this map.  The hash code of a map is
 * defined to be the sum of the hash codes of each entry in the map.
 * @apiSince 1
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns a shallow copy of this enum map.  (The values themselves
 * are not cloned.
 *
 * @return a shallow copy of this enum map
 * @apiSince 1
 */

public java.util.EnumMap<K,V> clone() { throw new RuntimeException("Stub!"); }
}

