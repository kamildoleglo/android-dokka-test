/*
 * Copyright (c) 1997, 2015, Oracle and/or its affiliates. All rights reserved.
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
 * An object that maps keys to values.  A map cannot contain duplicate keys;
 * each key can map to at most one value.
 *
 * <p>This interface takes the place of the {@code Dictionary} class, which
 * was a totally abstract class rather than an interface.
 *
 * <p>The {@code Map} interface provides three <i>collection views</i>, which
 * allow a map's contents to be viewed as a set of keys, collection of values,
 * or set of key-value mappings.  The <i>order</i> of a map is defined as
 * the order in which the iterators on the map's collection views return their
 * elements.  Some map implementations, like the {@code TreeMap} class, make
 * specific guarantees as to their order; others, like the {@code HashMap}
 * class, do not.
 *
 * <p>Note: great care must be exercised if mutable objects are used as map
 * keys.  The behavior of a map is not specified if the value of an object is
 * changed in a manner that affects {@code equals} comparisons while the
 * object is a key in the map.  A special case of this prohibition is that it
 * is not permissible for a map to contain itself as a key.  While it is
 * permissible for a map to contain itself as a value, extreme caution is
 * advised: the {@code equals} and {@code hashCode} methods are no longer
 * well defined on such a map.
 *
 * <p>All general-purpose map implementation classes should provide two
 * "standard" constructors: a void (no arguments) constructor which creates an
 * empty map, and a constructor with a single argument of type {@code Map},
 * which creates a new map with the same key-value mappings as its argument.
 * In effect, the latter constructor allows the user to copy any map,
 * producing an equivalent map of the desired class.  There is no way to
 * enforce this recommendation (as interfaces cannot contain constructors) but
 * all of the general-purpose map implementations in the JDK comply.
 *
 * <p>The "destructive" methods contained in this interface, that is, the
 * methods that modify the map on which they operate, are specified to throw
 * {@code UnsupportedOperationException} if this map does not support the
 * operation.  If this is the case, these methods may, but are not required
 * to, throw an {@code UnsupportedOperationException} if the invocation would
 * have no effect on the map.  For example, invoking the {@link #putAll(java.util.Map)}
 * method on an unmodifiable map may, but is not required to, throw the
 * exception if the map whose mappings are to be "superimposed" is empty.
 *
 * <p>Some map implementations have restrictions on the keys and values they
 * may contain.  For example, some implementations prohibit null keys and
 * values, and some have restrictions on the types of their keys.  Attempting
 * to insert an ineligible key or value throws an unchecked exception,
 * typically {@code NullPointerException} or {@code ClassCastException}.
 * Attempting to query the presence of an ineligible key or value may throw an
 * exception, or it may simply return false; some implementations will exhibit
 * the former behavior and some will exhibit the latter.  More generally,
 * attempting an operation on an ineligible key or value whose completion
 * would not result in the insertion of an ineligible element into the map may
 * throw an exception or it may succeed, at the option of the implementation.
 * Such exceptions are marked as "optional" in the specification for this
 * interface.
 *
 * <p>Many methods in Collections Framework interfaces are defined
 * in terms of the {@link java.lang.Object#equals(java.lang.Object) Object#equals(Object)} method.  For
 * example, the specification for the {@link #containsKey(java.lang.Object)
 * containsKey(Object key)} method says: "returns {@code true} if and
 * only if this map contains a mapping for a key {@code k} such that
 * {@code (key==null ? k==null : key.equals(k))}." This specification should
 * <i>not</i> be construed to imply that invoking {@code Map.containsKey}
 * with a non-null argument {@code key} will cause {@code key.equals(k)} to
 * be invoked for any key {@code k}.  Implementations are free to
 * implement optimizations whereby the {@code equals} invocation is avoided,
 * for example, by first comparing the hash codes of the two keys.  (The
 * {@link java.lang.Object#hashCode() Object#hashCode()} specification guarantees that two objects with
 * unequal hash codes cannot be equal.)  More generally, implementations of
 * the various Collections Framework interfaces are free to take advantage of
 * the specified behavior of underlying {@link java.lang.Object Object} methods wherever the
 * implementor deems it appropriate.
 *
 * <p>Some map operations which perform recursive traversal of the map may fail
 * with an exception for self-referential instances where the map directly or
 * indirectly contains itself. This includes the {@code clone()},
 * {@code equals()}, {@code hashCode()} and {@code toString()} methods.
 * Implementations may optionally handle the self-referential scenario, however
 * most current implementations do not do so.
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 *
 * @author  Josh Bloch
 * @see java.util.HashMap
 * @see java.util.TreeMap
 * @see java.util.Hashtable
 * @see java.util.SortedMap
 * @see java.util.Collection
 * @see java.util.Set
 * @since 1.2
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface Map<K, V> {

/**
 * Returns the number of key-value mappings in this map.  If the
 * map contains more than {@code Integer.MAX_VALUE} elements, returns
 * {@code Integer.MAX_VALUE}.
 *
 * @return the number of key-value mappings in this map
 * @apiSince 1
 */

public int size();

/**
 * Returns {@code true} if this map contains no key-value mappings.
 *
 * @return {@code true} if this map contains no key-value mappings
 * @apiSince 1
 */

public boolean isEmpty();

/**
 * Returns {@code true} if this map contains a mapping for the specified
 * key.  More formally, returns {@code true} if and only if
 * this map contains a mapping for a key {@code k} such that
 * {@code Objects.equals(key, k)}.  (There can be
 * at most one such mapping.)
 *
 * @param key key whose presence in this map is to be tested
 * @return {@code true} if this map contains a mapping for the specified
 *         key
 * @throws java.lang.ClassCastException if the key is of an inappropriate type for
 *         this map
 * (<a href="Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.NullPointerException if the specified key is null and this map
 *         does not permit null keys
 * (<a href="Collection.html#optional-restrictions">optional</a>)
 * @apiSince 1
 */

public boolean containsKey(@androidx.annotation.Nullable java.lang.Object key);

/**
 * Returns {@code true} if this map maps one or more keys to the
 * specified value.  More formally, returns {@code true} if and only if
 * this map contains at least one mapping to a value {@code v} such that
 * {@code Objects.equals(value, v)}.  This operation
 * will probably require time linear in the map size for most
 * implementations of the {@code Map} interface.
 *
 * @param value value whose presence in this map is to be tested
 * @return {@code true} if this map maps one or more keys to the
 *         specified value
 * @throws java.lang.ClassCastException if the value is of an inappropriate type for
 *         this map
 * (<a href="Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.NullPointerException if the specified value is null and this
 *         map does not permit null values
 * (<a href="Collection.html#optional-restrictions">optional</a>)
 * @apiSince 1
 */

public boolean containsValue(@androidx.annotation.Nullable java.lang.Object value);

/**
 * Returns the value to which the specified key is mapped,
 * or {@code null} if this map contains no mapping for the key.
 *
 * <p>More formally, if this map contains a mapping from a key
 * {@code k} to a value {@code v} such that
 * {@code Objects.equals(key, k)},
 * then this method returns {@code v}; otherwise
 * it returns {@code null}.  (There can be at most one such mapping.)
 *
 * <p>If this map permits null values, then a return value of
 * {@code null} does not <i>necessarily</i> indicate that the map
 * contains no mapping for the key; it's also possible that the map
 * explicitly maps the key to {@code null}.  The {@link #containsKey
 * containsKey} operation may be used to distinguish these two cases.
 *
 * @param key the key whose associated value is to be returned
 * @return the value to which the specified key is mapped, or
 *         {@code null} if this map contains no mapping for the key
 * @throws java.lang.ClassCastException if the key is of an inappropriate type for
 *         this map
 * (<a href="Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.NullPointerException if the specified key is null and this map
 *         does not permit null keys
 * (<a href="Collection.html#optional-restrictions">optional</a>)
 * @apiSince 1
 */

@androidx.annotation.Nullable
public V get(@androidx.annotation.Nullable java.lang.Object key);

/**
 * Associates the specified value with the specified key in this map
 * (optional operation).  If the map previously contained a mapping for
 * the key, the old value is replaced by the specified value.  (A map
 * {@code m} is said to contain a mapping for a key {@code k} if and only
 * if {@link #containsKey(java.lang.Object) m.containsKey(k)} would return
 * {@code true}.)
 *
 * @param key key with which the specified value is to be associated
 * @param value value to be associated with the specified key
 * @return the previous value associated with {@code key}, or
 *         {@code null} if there was no mapping for {@code key}.
 *         (A {@code null} return can also indicate that the map
 *         previously associated {@code null} with {@code key},
 *         if the implementation supports {@code null} values.)
 * @throws java.lang.UnsupportedOperationException if the {@code put} operation
 *         is not supported by this map
 * @throws java.lang.ClassCastException if the class of the specified key or value
 *         prevents it from being stored in this map
 * @throws java.lang.NullPointerException if the specified key or value is null
 *         and this map does not permit null keys or values
 * @throws java.lang.IllegalArgumentException if some property of the specified key
 *         or value prevents it from being stored in this map
 * @apiSince 1
 */

@androidx.annotation.Nullable
public V put(K key, V value);

/**
 * Removes the mapping for a key from this map if it is present
 * (optional operation).   More formally, if this map contains a mapping
 * from key {@code k} to value {@code v} such that
 * {@code Objects.equals(key, k)}, that mapping
 * is removed.  (The map can contain at most one such mapping.)
 *
 * <p>Returns the value to which this map previously associated the key,
 * or {@code null} if the map contained no mapping for the key.
 *
 * <p>If this map permits null values, then a return value of
 * {@code null} does not <i>necessarily</i> indicate that the map
 * contained no mapping for the key; it's also possible that the map
 * explicitly mapped the key to {@code null}.
 *
 * <p>The map will not contain a mapping for the specified key once the
 * call returns.
 *
 * @param key key whose mapping is to be removed from the map
 * @return the previous value associated with {@code key}, or
 *         {@code null} if there was no mapping for {@code key}.
 * @throws java.lang.UnsupportedOperationException if the {@code remove} operation
 *         is not supported by this map
 * @throws java.lang.ClassCastException if the key is of an inappropriate type for
 *         this map
 * (<a href="Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.NullPointerException if the specified key is null and this
 *         map does not permit null keys
 * (<a href="Collection.html#optional-restrictions">optional</a>)
 * @apiSince 1
 */

@androidx.annotation.Nullable
public V remove(@androidx.annotation.Nullable java.lang.Object key);

/**
 * Copies all of the mappings from the specified map to this map
 * (optional operation).  The effect of this call is equivalent to that
 * of calling {@link #put(java.lang.Object,java.lang.Object) put(k, v)} on this map once
 * for each mapping from key {@code k} to value {@code v} in the
 * specified map.  The behavior of this operation is undefined if the
 * specified map is modified while the operation is in progress.
 *
 * @param m mappings to be stored in this map
 * @throws java.lang.UnsupportedOperationException if the {@code putAll} operation
 *         is not supported by this map
 * @throws java.lang.ClassCastException if the class of a key or value in the
 *         specified map prevents it from being stored in this map
 * @throws java.lang.NullPointerException if the specified map is null, or if
 *         this map does not permit null keys or values, and the
 *         specified map contains null keys or values
 * @throws java.lang.IllegalArgumentException if some property of a key or value in
 *         the specified map prevents it from being stored in this map
 * @apiSince 1
 */

public void putAll(@androidx.annotation.NonNull java.util.Map<? extends K,? extends V> m);

/**
 * Removes all of the mappings from this map (optional operation).
 * The map will be empty after this call returns.
 *
 * @throws java.lang.UnsupportedOperationException if the {@code clear} operation
 *         is not supported by this map
 * @apiSince 1
 */

public void clear();

/**
 * Returns a {@link java.util.Set Set} view of the keys contained in this map.
 * The set is backed by the map, so changes to the map are
 * reflected in the set, and vice-versa.  If the map is modified
 * while an iteration over the set is in progress (except through
 * the iterator's own {@code remove} operation), the results of
 * the iteration are undefined.  The set supports element removal,
 * which removes the corresponding mapping from the map, via the
 * {@code Iterator.remove}, {@code Set.remove},
 * {@code removeAll}, {@code retainAll}, and {@code clear}
 * operations.  It does not support the {@code add} or {@code addAll}
 * operations.
 *
 * @return a set view of the keys contained in this map
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.util.Set<K> keySet();

/**
 * Returns a {@link java.util.Collection Collection} view of the values contained in this map.
 * The collection is backed by the map, so changes to the map are
 * reflected in the collection, and vice-versa.  If the map is
 * modified while an iteration over the collection is in progress
 * (except through the iterator's own {@code remove} operation),
 * the results of the iteration are undefined.  The collection
 * supports element removal, which removes the corresponding
 * mapping from the map, via the {@code Iterator.remove},
 * {@code Collection.remove}, {@code removeAll},
 * {@code retainAll} and {@code clear} operations.  It does not
 * support the {@code add} or {@code addAll} operations.
 *
 * @return a collection view of the values contained in this map
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.util.Collection<V> values();

/**
 * Returns a {@link java.util.Set Set} view of the mappings contained in this map.
 * The set is backed by the map, so changes to the map are
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
 *
 * @return a set view of the mappings contained in this map
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.util.Set<java.util.Map.Entry<K,V>> entrySet();

/**
 * Compares the specified object with this map for equality.  Returns
 * {@code true} if the given object is also a map and the two maps
 * represent the same mappings.  More formally, two maps {@code m1} and
 * {@code m2} represent the same mappings if
 * {@code m1.entrySet().equals(m2.entrySet())}.  This ensures that the
 * {@code equals} method works properly across different implementations
 * of the {@code Map} interface.
 *
 * @param o object to be compared for equality with this map
 * @return {@code true} if the specified object is equal to this map
 * @apiSince 1
 */

public boolean equals(@androidx.annotation.Nullable java.lang.Object o);

/**
 * Returns the hash code value for this map.  The hash code of a map is
 * defined to be the sum of the hash codes of each entry in the map's
 * {@code entrySet()} view.  This ensures that {@code m1.equals(m2)}
 * implies that {@code m1.hashCode()==m2.hashCode()} for any two maps
 * {@code m1} and {@code m2}, as required by the general contract of
 * {@link java.lang.Object#hashCode Object#hashCode}.
 *
 * @return the hash code value for this map
 * @see java.util.Map.Entry#hashCode()
 * @see java.lang.Object#equals(Object)
 * @see #equals(Object)
 * @apiSince 1
 */

public int hashCode();

/**
 * Returns the value to which the specified key is mapped, or
 * {@code defaultValue} if this map contains no mapping for the key.
 *
 * @implSpec
 * The default implementation makes no guarantees about synchronization
 * or atomicity properties of this method. Any implementation providing
 * atomicity guarantees must override this method and document its
 * concurrency properties.
 *
 * @param key the key whose associated value is to be returned
 * @param defaultValue the default mapping of the key
 * @return the value to which the specified key is mapped, or
 * {@code defaultValue} if this map contains no mapping for the key
 * @throws java.lang.ClassCastException if the key is of an inappropriate type for
 * this map
 * (<a href="Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.NullPointerException if the specified key is null and this map
 * does not permit null keys
 * (<a href="Collection.html#optional-restrictions">optional</a>)
 * @since 1.8
 * @apiSince 24
 */

@androidx.annotation.Nullable
public default V getOrDefault(@androidx.annotation.Nullable java.lang.Object key, @androidx.annotation.Nullable V defaultValue) { throw new RuntimeException("Stub!"); }

/**
 * Performs the given action for each entry in this map until all entries
 * have been processed or the action throws an exception.   Unless
 * otherwise specified by the implementing class, actions are performed in
 * the order of entry set iteration (if an iteration order is specified.)
 * Exceptions thrown by the action are relayed to the caller.
 *
 * @implSpec
 * The default implementation is equivalent to, for this {@code map}:
 * <pre> {@code
 * for (Map.Entry<K, V> entry : map.entrySet())
 *     action.accept(entry.getKey(), entry.getValue());
 * }</pre>
 *
 * The default implementation makes no guarantees about synchronization
 * or atomicity properties of this method. Any implementation providing
 * atomicity guarantees must override this method and document its
 * concurrency properties.
 *
 * @param action The action to be performed for each entry
 * @throws java.lang.NullPointerException if the specified action is null
 * @throws java.util.ConcurrentModificationException if an entry is found to be
 * removed during iteration
 * @since 1.8
 * @apiSince 24
 */

public default void forEach(@androidx.annotation.NonNull java.util.function.BiConsumer<? super K,? super V> action) { throw new RuntimeException("Stub!"); }

/**
 * Replaces each entry's value with the result of invoking the given
 * function on that entry until all entries have been processed or the
 * function throws an exception.  Exceptions thrown by the function are
 * relayed to the caller.
 *
 * @implSpec
 * <p>The default implementation is equivalent to, for this {@code map}:
 * <pre> {@code
 * for (Map.Entry<K, V> entry : map.entrySet())
 *     entry.setValue(function.apply(entry.getKey(), entry.getValue()));
 * }</pre>
 *
 * <p>The default implementation makes no guarantees about synchronization
 * or atomicity properties of this method. Any implementation providing
 * atomicity guarantees must override this method and document its
 * concurrency properties.
 *
 * @param function the function to apply to each entry
 * @throws java.lang.UnsupportedOperationException if the {@code set} operation
 * is not supported by this map's entry set iterator.
 * @throws java.lang.ClassCastException if the class of a replacement value
 * prevents it from being stored in this map
 * @throws java.lang.NullPointerException if the specified function is null, or the
 * specified replacement value is null, and this map does not permit null
 * values
 * @throws java.lang.ClassCastException if a replacement value is of an inappropriate
 *         type for this map
 *         (<a href="Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.NullPointerException if function or a replacement value is null,
 *         and this map does not permit null keys or values
 *         (<a href="Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.IllegalArgumentException if some property of a replacement value
 *         prevents it from being stored in this map
 *         (<a href="Collection.html#optional-restrictions">optional</a>)
 * @throws java.util.ConcurrentModificationException if an entry is found to be
 * removed during iteration
 * @since 1.8
 * @apiSince 24
 */

public default void replaceAll(@androidx.annotation.NonNull java.util.function.BiFunction<? super K,? super V,? extends V> function) { throw new RuntimeException("Stub!"); }

/**
 * If the specified key is not already associated with a value (or is mapped
 * to {@code null}) associates it with the given value and returns
 * {@code null}, else returns the current value.
 *
 * @implSpec
 * The default implementation is equivalent to, for this {@code
 * map}:
 *
 * <pre> {@code
 * V v = map.get(key);
 * if (v == null)
 *     v = map.put(key, value);
 *
 * return v;
 * }</pre>
 *
 * <p>The default implementation makes no guarantees about synchronization
 * or atomicity properties of this method. Any implementation providing
 * atomicity guarantees must override this method and document its
 * concurrency properties.
 *
 * @param key key with which the specified value is to be associated
 * @param value value to be associated with the specified key
 * @return the previous value associated with the specified key, or
 *         {@code null} if there was no mapping for the key.
 *         (A {@code null} return can also indicate that the map
 *         previously associated {@code null} with the key,
 *         if the implementation supports null values.)
 * @throws java.lang.UnsupportedOperationException if the {@code put} operation
 *         is not supported by this map
 *         (<a href="Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.ClassCastException if the key or value is of an inappropriate
 *         type for this map
 *         (<a href="Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.NullPointerException if the specified key or value is null,
 *         and this map does not permit null keys or values
 *         (<a href="Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.IllegalArgumentException if some property of the specified key
 *         or value prevents it from being stored in this map
 *         (<a href="Collection.html#optional-restrictions">optional</a>)
 * @since 1.8
 * @apiSince 24
 */

@androidx.annotation.Nullable
public default V putIfAbsent(K key, V value) { throw new RuntimeException("Stub!"); }

/**
 * Removes the entry for the specified key only if it is currently
 * mapped to the specified value.
 *
 * @implSpec
 * The default implementation is equivalent to, for this {@code map}:
 *
 * <pre> {@code
 * if (map.containsKey(key) && Objects.equals(map.get(key), value)) {
 *     map.remove(key);
 *     return true;
 * } else
 *     return false;
 * }</pre>
 *
 * <p>The default implementation makes no guarantees about synchronization
 * or atomicity properties of this method. Any implementation providing
 * atomicity guarantees must override this method and document its
 * concurrency properties.
 *
 * @param key key with which the specified value is associated
 * @param value value expected to be associated with the specified key
 * @return {@code true} if the value was removed
 * @throws java.lang.UnsupportedOperationException if the {@code remove} operation
 *         is not supported by this map
 *         (<a href="Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.ClassCastException if the key or value is of an inappropriate
 *         type for this map
 *         (<a href="Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.NullPointerException if the specified key or value is null,
 *         and this map does not permit null keys or values
 *         (<a href="Collection.html#optional-restrictions">optional</a>)
 * @since 1.8
 * @apiSince 24
 */

public default boolean remove(@androidx.annotation.Nullable java.lang.Object key, @androidx.annotation.Nullable java.lang.Object value) { throw new RuntimeException("Stub!"); }

/**
 * Replaces the entry for the specified key only if currently
 * mapped to the specified value.
 *
 * @implSpec
 * The default implementation is equivalent to, for this {@code map}:
 *
 * <pre> {@code
 * if (map.containsKey(key) && Objects.equals(map.get(key), value)) {
 *     map.put(key, newValue);
 *     return true;
 * } else
 *     return false;
 * }</pre>
 *
 * The default implementation does not throw NullPointerException
 * for maps that do not support null values if oldValue is null unless
 * newValue is also null.
 *
 * <p>The default implementation makes no guarantees about synchronization
 * or atomicity properties of this method. Any implementation providing
 * atomicity guarantees must override this method and document its
 * concurrency properties.
 *
 * @param key key with which the specified value is associated
 * @param oldValue value expected to be associated with the specified key
 * @param newValue value to be associated with the specified key
 * @return {@code true} if the value was replaced
 * @throws java.lang.UnsupportedOperationException if the {@code put} operation
 *         is not supported by this map
 *         (<a href="Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.ClassCastException if the class of a specified key or value
 *         prevents it from being stored in this map
 * @throws java.lang.NullPointerException if a specified key or newValue is null,
 *         and this map does not permit null keys or values
 * @throws java.lang.NullPointerException if oldValue is null and this map does not
 *         permit null values
 *         (<a href="Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.IllegalArgumentException if some property of a specified key
 *         or value prevents it from being stored in this map
 * @since 1.8
 * @apiSince 24
 */

public default boolean replace(K key, @androidx.annotation.Nullable V oldValue, V newValue) { throw new RuntimeException("Stub!"); }

/**
 * Replaces the entry for the specified key only if it is
 * currently mapped to some value.
 *
 * @implSpec
 * The default implementation is equivalent to, for this {@code map}:
 *
 * <pre> {@code
 * if (map.containsKey(key)) {
 *     return map.put(key, value);
 * } else
 *     return null;
 * }</pre>
 *
 * <p>The default implementation makes no guarantees about synchronization
 * or atomicity properties of this method. Any implementation providing
 * atomicity guarantees must override this method and document its
 * concurrency properties.
 *
 * @param key key with which the specified value is associated
 * @param value value to be associated with the specified key
 * @return the previous value associated with the specified key, or
 *         {@code null} if there was no mapping for the key.
 *         (A {@code null} return can also indicate that the map
 *         previously associated {@code null} with the key,
 *         if the implementation supports null values.)
 * @throws java.lang.UnsupportedOperationException if the {@code put} operation
 *         is not supported by this map
 *         (<a href="Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.ClassCastException if the class of the specified key or value
 *         prevents it from being stored in this map
 *         (<a href="Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.NullPointerException if the specified key or value is null,
 *         and this map does not permit null keys or values
 * @throws java.lang.IllegalArgumentException if some property of the specified key
 *         or value prevents it from being stored in this map
 * @since 1.8
 * @apiSince 24
 */

@androidx.annotation.Nullable
public default V replace(K key, V value) { throw new RuntimeException("Stub!"); }

/**
 * If the specified key is not already associated with a value (or is mapped
 * to {@code null}), attempts to compute its value using the given mapping
 * function and enters it into this map unless {@code null}.
 *
 * <p>If the mapping function returns {@code null}, no mapping is recorded.
 * If the mapping function itself throws an (unchecked) exception, the
 * exception is rethrown, and no mapping is recorded.  The most
 * common usage is to construct a new object serving as an initial
 * mapped value or memoized result, as in:
 *
 * <pre> {@code
 * map.computeIfAbsent(key, k -> new Value(f(k)));
 * }</pre>
 *
 * <p>Or to implement a multi-value map, {@code Map<K,Collection<V>>},
 * supporting multiple values per key:
 *
 * <pre> {@code
 * map.computeIfAbsent(key, k -> new HashSet<V>()).add(v);
 * }</pre>
 *
 * <p>The mapping function should not modify this map during computation.
 *
 * @implSpec
 * The default implementation is equivalent to the following steps for this
 * {@code map}, then returning the current value or {@code null} if now
 * absent:
 *
 * <pre> {@code
 * if (map.get(key) == null) {
 *     V newValue = mappingFunction.apply(key);
 *     if (newValue != null)
 *         map.put(key, newValue);
 * }
 * }</pre>
 *
 * <p>The default implementation makes no guarantees about detecting if the
 * mapping function modifies this map during computation and, if
 * appropriate, reporting an error. Non-concurrent implementations should
 * override this method and, on a best-effort basis, throw a
 * {@code ConcurrentModificationException} if it is detected that the
 * mapping function modifies this map during computation. Concurrent
 * implementations should override this method and, on a best-effort basis,
 * throw an {@code IllegalStateException} if it is detected that the
 * mapping function modifies this map during computation and as a result
 * computation would never complete.
 *
 * <p>The default implementation makes no guarantees about synchronization
 * or atomicity properties of this method. Any implementation providing
 * atomicity guarantees must override this method and document its
 * concurrency properties. In particular, all implementations of
 * subinterface {@link java.util.concurrent.ConcurrentMap} must document
 * whether the mapping function is applied once atomically only if the value
 * is not present.
 *
 * @param key key with which the specified value is to be associated
 * @param mappingFunction the mapping function to compute a value
 * @return the current (existing or computed) value associated with
 *         the specified key, or null if the computed value is null
 * @throws java.lang.NullPointerException if the specified key is null and
 *         this map does not support null keys, or the mappingFunction
 *         is null
 * @throws java.lang.UnsupportedOperationException if the {@code put} operation
 *         is not supported by this map
 *         (<a href="Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.ClassCastException if the class of the specified key or value
 *         prevents it from being stored in this map
 *         (<a href="Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.IllegalArgumentException if some property of the specified key
 *         or value prevents it from being stored in this map
 *         (<a href="Collection.html#optional-restrictions">optional</a>)
 * @since 1.8
 * @apiSince 24
 */

@androidx.annotation.Nullable
public default V computeIfAbsent(K key, @androidx.annotation.NonNull java.util.function.Function<? super K,? extends V> mappingFunction) { throw new RuntimeException("Stub!"); }

/**
 * If the value for the specified key is present and non-null, attempts to
 * compute a new mapping given the key and its current mapped value.
 *
 * <p>If the remapping function returns {@code null}, the mapping is removed.
 * If the remapping function itself throws an (unchecked) exception, the
 * exception is rethrown, and the current mapping is left unchanged.
 *
 * <p>The remapping function should not modify this map during computation.
 *
 * @implSpec
 * The default implementation is equivalent to performing the following
 * steps for this {@code map}, then returning the current value or
 * {@code null} if now absent:
 *
 * <pre> {@code
 * if (map.get(key) != null) {
 *     V oldValue = map.get(key);
 *     V newValue = remappingFunction.apply(key, oldValue);
 *     if (newValue != null)
 *         map.put(key, newValue);
 *     else
 *         map.remove(key);
 * }
 * }</pre>
 *
 * <p>The default implementation makes no guarantees about detecting if the
 * remapping function modifies this map during computation and, if
 * appropriate, reporting an error. Non-concurrent implementations should
 * override this method and, on a best-effort basis, throw a
 * {@code ConcurrentModificationException} if it is detected that the
 * remapping function modifies this map during computation. Concurrent
 * implementations should override this method and, on a best-effort basis,
 * throw an {@code IllegalStateException} if it is detected that the
 * remapping function modifies this map during computation and as a result
 * computation would never complete.
 *
 * <p>The default implementation makes no guarantees about synchronization
 * or atomicity properties of this method. Any implementation providing
 * atomicity guarantees must override this method and document its
 * concurrency properties. In particular, all implementations of
 * subinterface {@link java.util.concurrent.ConcurrentMap} must document
 * whether the remapping function is applied once atomically only if the
 * value is not present.
 *
 * @param key key with which the specified value is to be associated
 * @param remappingFunction the remapping function to compute a value
 * @return the new value associated with the specified key, or null if none
 * @throws java.lang.NullPointerException if the specified key is null and
 *         this map does not support null keys, or the
 *         remappingFunction is null
 * @throws java.lang.UnsupportedOperationException if the {@code put} operation
 *         is not supported by this map
 *         (<a href="Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.ClassCastException if the class of the specified key or value
 *         prevents it from being stored in this map
 *         (<a href="Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.IllegalArgumentException if some property of the specified key
 *         or value prevents it from being stored in this map
 *         (<a href="Collection.html#optional-restrictions">optional</a>)
 * @since 1.8
 * @apiSince 24
 */

@androidx.annotation.Nullable
public default V computeIfPresent(K key, @androidx.annotation.NonNull java.util.function.BiFunction<? super K,? super V,? extends V> remappingFunction) { throw new RuntimeException("Stub!"); }

/**
 * Attempts to compute a mapping for the specified key and its current
 * mapped value (or {@code null} if there is no current mapping). For
 * example, to either create or append a {@code String} msg to a value
 * mapping:
 *
 * <pre> {@code
 * map.compute(key, (k, v) -> (v == null) ? msg : v.concat(msg))}</pre>
 * (Method {@link #merge merge()} is often simpler to use for such purposes.)
 *
 * <p>If the remapping function returns {@code null}, the mapping is removed
 * (or remains absent if initially absent).  If the remapping function
 * itself throws an (unchecked) exception, the exception is rethrown, and
 * the current mapping is left unchanged.
 *
 * <p>The remapping function should not modify this map during computation.
 *
 * @implSpec
 * The default implementation is equivalent to performing the following
 * steps for this {@code map}, then returning the current value or
 * {@code null} if absent:
 *
 * <pre> {@code
 * V oldValue = map.get(key);
 * V newValue = remappingFunction.apply(key, oldValue);
 * if (oldValue != null) {
 *    if (newValue != null)
 *       map.put(key, newValue);
 *    else
 *       map.remove(key);
 * } else {
 *    if (newValue != null)
 *       map.put(key, newValue);
 *    else
 *       return null;
 * }
 * }</pre>
 *
 * <p>The default implementation makes no guarantees about detecting if the
 * remapping function modifies this map during computation and, if
 * appropriate, reporting an error. Non-concurrent implementations should
 * override this method and, on a best-effort basis, throw a
 * {@code ConcurrentModificationException} if it is detected that the
 * remapping function modifies this map during computation. Concurrent
 * implementations should override this method and, on a best-effort basis,
 * throw an {@code IllegalStateException} if it is detected that the
 * remapping function modifies this map during computation and as a result
 * computation would never complete.
 *
 * <p>The default implementation makes no guarantees about synchronization
 * or atomicity properties of this method. Any implementation providing
 * atomicity guarantees must override this method and document its
 * concurrency properties. In particular, all implementations of
 * subinterface {@link java.util.concurrent.ConcurrentMap} must document
 * whether the remapping function is applied once atomically only if the
 * value is not present.
 *
 * @param key key with which the specified value is to be associated
 * @param remappingFunction the remapping function to compute a value
 * @return the new value associated with the specified key, or null if none
 * @throws java.lang.NullPointerException if the specified key is null and
 *         this map does not support null keys, or the
 *         remappingFunction is null
 * @throws java.lang.UnsupportedOperationException if the {@code put} operation
 *         is not supported by this map
 *         (<a href="Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.ClassCastException if the class of the specified key or value
 *         prevents it from being stored in this map
 *         (<a href="Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.IllegalArgumentException if some property of the specified key
 *         or value prevents it from being stored in this map
 *         (<a href="Collection.html#optional-restrictions">optional</a>)
 * @since 1.8
 * @apiSince 24
 */

@androidx.annotation.Nullable
public default V compute(K key, @androidx.annotation.NonNull java.util.function.BiFunction<? super K,? super V,? extends V> remappingFunction) { throw new RuntimeException("Stub!"); }

/**
 * If the specified key is not already associated with a value or is
 * associated with null, associates it with the given non-null value.
 * Otherwise, replaces the associated value with the results of the given
 * remapping function, or removes if the result is {@code null}. This
 * method may be of use when combining multiple mapped values for a key.
 * For example, to either create or append a {@code String msg} to a
 * value mapping:
 *
 * <pre> {@code
 * map.merge(key, msg, String::concat)
 * }</pre>
 *
 * <p>If the remapping function returns {@code null}, the mapping is removed.
 * If the remapping function itself throws an (unchecked) exception, the
 * exception is rethrown, and the current mapping is left unchanged.
 *
 * <p>The remapping function should not modify this map during computation.
 *
 * @implSpec
 * The default implementation is equivalent to performing the following
 * steps for this {@code map}, then returning the current value or
 * {@code null} if absent:
 *
 * <pre> {@code
 * V oldValue = map.get(key);
 * V newValue = (oldValue == null) ? value :
 *              remappingFunction.apply(oldValue, value);
 * if (newValue == null)
 *     map.remove(key);
 * else
 *     map.put(key, newValue);
 * }</pre>
 *
 * <p>The default implementation makes no guarantees about detecting if the
 * remapping function modifies this map during computation and, if
 * appropriate, reporting an error. Non-concurrent implementations should
 * override this method and, on a best-effort basis, throw a
 * {@code ConcurrentModificationException} if it is detected that the
 * remapping function modifies this map during computation. Concurrent
 * implementations should override this method and, on a best-effort basis,
 * throw an {@code IllegalStateException} if it is detected that the
 * remapping function modifies this map during computation and as a result
 * computation would never complete.
 *
 * <p>The default implementation makes no guarantees about synchronization
 * or atomicity properties of this method. Any implementation providing
 * atomicity guarantees must override this method and document its
 * concurrency properties. In particular, all implementations of
 * subinterface {@link java.util.concurrent.ConcurrentMap} must document
 * whether the remapping function is applied once atomically only if the
 * value is not present.
 *
 * @param key key with which the resulting value is to be associated
 * @param value the non-null value to be merged with the existing value
 *        associated with the key or, if no existing value or a null value
 *        is associated with the key, to be associated with the key
 * @param remappingFunction the remapping function to recompute a value if
 *        present
 * @return the new value associated with the specified key, or null if no
 *         value is associated with the key
 * @throws java.lang.UnsupportedOperationException if the {@code put} operation
 *         is not supported by this map
 *         (<a href="Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.ClassCastException if the class of the specified key or value
 *         prevents it from being stored in this map
 *         (<a href="Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.IllegalArgumentException if some property of the specified key
 *         or value prevents it from being stored in this map
 *         (<a href="Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.NullPointerException if the specified key is null and this map
 *         does not support null keys or the value or remappingFunction is
 *         null
 * @since 1.8
 * @apiSince 24
 */

@androidx.annotation.Nullable
public default V merge(K key, @androidx.annotation.NonNull V value, @androidx.annotation.NonNull java.util.function.BiFunction<? super V,? super V,? extends V> remappingFunction) { throw new RuntimeException("Stub!"); }
/**
 * A map entry (key-value pair).  The {@code Map.entrySet} method returns
 * a collection-view of the map, whose elements are of this class.  The
 * <i>only</i> way to obtain a reference to a map entry is from the
 * iterator of this collection-view.  These {@code Map.Entry} objects are
 * valid <i>only</i> for the duration of the iteration; more formally,
 * the behavior of a map entry is undefined if the backing map has been
 * modified after the entry was returned by the iterator, except through
 * the {@code setValue} operation on the map entry.
 *
 * @see java.util.Map#entrySet()
 * @since 1.2
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface Entry<K, V> {

/**
 * Returns the key corresponding to this entry.
 *
 * @return the key corresponding to this entry
 * @throws java.lang.IllegalStateException implementations may, but are not
 *         required to, throw this exception if the entry has been
 *         removed from the backing map.
 * @apiSince 1
 */

public K getKey();

/**
 * Returns the value corresponding to this entry.  If the mapping
 * has been removed from the backing map (by the iterator's
 * {@code remove} operation), the results of this call are undefined.
 *
 * @return the value corresponding to this entry
 * @throws java.lang.IllegalStateException implementations may, but are not
 *         required to, throw this exception if the entry has been
 *         removed from the backing map.
 * @apiSince 1
 */

public V getValue();

/**
 * Replaces the value corresponding to this entry with the specified
 * value (optional operation).  (Writes through to the map.)  The
 * behavior of this call is undefined if the mapping has already been
 * removed from the map (by the iterator's {@code remove} operation).
 *
 * @param value new value to be stored in this entry
 * @return old value corresponding to the entry
 * @throws java.lang.UnsupportedOperationException if the {@code put} operation
 *         is not supported by the backing map
 * @throws java.lang.ClassCastException if the class of the specified value
 *         prevents it from being stored in the backing map
 * @throws java.lang.NullPointerException if the backing map does not permit
 *         null values, and the specified value is null
 * @throws java.lang.IllegalArgumentException if some property of this value
 *         prevents it from being stored in the backing map
 * @throws java.lang.IllegalStateException implementations may, but are not
 *         required to, throw this exception if the entry has been
 *         removed from the backing map.
 * @apiSince 1
 */

public V setValue(V value);

/**
 * Compares the specified object with this entry for equality.
 * Returns {@code true} if the given object is also a map entry and
 * the two entries represent the same mapping.  More formally, two
 * entries {@code e1} and {@code e2} represent the same mapping
 * if<pre>
 *     (e1.getKey()==null ?
 *      e2.getKey()==null : e1.getKey().equals(e2.getKey()))  &amp;&amp;
 *     (e1.getValue()==null ?
 *      e2.getValue()==null : e1.getValue().equals(e2.getValue()))
 * </pre>
 * This ensures that the {@code equals} method works properly across
 * different implementations of the {@code Map.Entry} interface.
 *
 * @param o object to be compared for equality with this map entry
 * @return {@code true} if the specified object is equal to this map
 *         entry
 * @apiSince 1
 */

public boolean equals(@androidx.annotation.Nullable java.lang.Object o);

/**
 * Returns the hash code value for this map entry.  The hash code
 * of a map entry {@code e} is defined to be: <pre>
 *     (e.getKey()==null   ? 0 : e.getKey().hashCode()) ^
 *     (e.getValue()==null ? 0 : e.getValue().hashCode())
 * </pre>
 * This ensures that {@code e1.equals(e2)} implies that
 * {@code e1.hashCode()==e2.hashCode()} for any two Entries
 * {@code e1} and {@code e2}, as required by the general
 * contract of {@code Object.hashCode}.
 *
 * @return the hash code value for this map entry
 * @see java.lang.Object#hashCode()
 * @see java.lang.Object#equals(Object)
 * @see #equals(Object)
 * @apiSince 1
 */

public int hashCode();

/**
 * Returns a comparator that compares {@link java.util.Map.Entry Map.Entry} in natural order on key.
 *
 * <p>The returned comparator is serializable and throws {@link java.lang.NullPointerException NullPointerException} when comparing an entry with a null key.
 *
 * @param  <K> the {@link java.lang.Comparable Comparable} type of then map keys
 * @param  <V> the type of the map values
 * @return a comparator that compares {@link java.util.Map.Entry Map.Entry} in natural order on key.
 * @see java.lang.Comparable
 * @since 1.8
 * @apiSince 24
 */

@androidx.annotation.NonNull
public static <K extends java.lang.Comparable<? super K>, V> java.util.Comparator<java.util.Map.Entry<K,V>> comparingByKey() { throw new RuntimeException("Stub!"); }

/**
 * Returns a comparator that compares {@link java.util.Map.Entry Map.Entry} in natural order on value.
 *
 * <p>The returned comparator is serializable and throws {@link java.lang.NullPointerException NullPointerException} when comparing an entry with null values.
 *
 * @param <K> the type of the map keys
 * @param <V> the {@link java.lang.Comparable Comparable} type of the map values
 * @return a comparator that compares {@link java.util.Map.Entry Map.Entry} in natural order on value.
 * @see java.lang.Comparable
 * @since 1.8
 * @apiSince 24
 */

@androidx.annotation.NonNull
public static <K, V extends java.lang.Comparable<? super V>> java.util.Comparator<java.util.Map.Entry<K,V>> comparingByValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns a comparator that compares {@link java.util.Map.Entry Map.Entry} by key using the given
 * {@link java.util.Comparator Comparator}.
 *
 * <p>The returned comparator is serializable if the specified comparator
 * is also serializable.
 *
 * @param  <K> the type of the map keys
 * @param  <V> the type of the map values
 * @param  cmp the key {@link java.util.Comparator Comparator}
 * @return a comparator that compares {@link java.util.Map.Entry Map.Entry} by the key.
 * @since 1.8
 * @apiSince 24
 */

@androidx.annotation.NonNull
public static <K, V> java.util.Comparator<java.util.Map.Entry<K,V>> comparingByKey(@androidx.annotation.NonNull java.util.Comparator<? super K> cmp) { throw new RuntimeException("Stub!"); }

/**
 * Returns a comparator that compares {@link java.util.Map.Entry Map.Entry} by value using the given
 * {@link java.util.Comparator Comparator}.
 *
 * <p>The returned comparator is serializable if the specified comparator
 * is also serializable.
 *
 * @param  <K> the type of the map keys
 * @param  <V> the type of the map values
 * @param  cmp the value {@link java.util.Comparator Comparator}
 * @return a comparator that compares {@link java.util.Map.Entry Map.Entry} by the value.
 * @since 1.8
 * @apiSince 24
 */

@androidx.annotation.NonNull
public static <K, V> java.util.Comparator<java.util.Map.Entry<K,V>> comparingByValue(@androidx.annotation.NonNull java.util.Comparator<? super V> cmp) { throw new RuntimeException("Stub!"); }
}

}

