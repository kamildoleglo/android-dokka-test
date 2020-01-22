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
 * This class implements the <tt>Set</tt> interface, backed by a hash table
 * (actually a <tt>HashMap</tt> instance).  It makes no guarantees as to the
 * iteration order of the set; in particular, it does not guarantee that the
 * order will remain constant over time.  This class permits the <tt>null</tt>
 * element.
 *
 * <p>This class offers constant time performance for the basic operations
 * (<tt>add</tt>, <tt>remove</tt>, <tt>contains</tt> and <tt>size</tt>),
 * assuming the hash function disperses the elements properly among the
 * buckets.  Iterating over this set requires time proportional to the sum of
 * the <tt>HashSet</tt> instance's size (the number of elements) plus the
 * "capacity" of the backing <tt>HashMap</tt> instance (the number of
 * buckets).  Thus, it's very important not to set the initial capacity too
 * high (or the load factor too low) if iteration performance is important.
 *
 * <p><strong>Note that this implementation is not synchronized.</strong>
 * If multiple threads access a hash set concurrently, and at least one of
 * the threads modifies the set, it <i>must</i> be synchronized externally.
 * This is typically accomplished by synchronizing on some object that
 * naturally encapsulates the set.
 *
 * If no such object exists, the set should be "wrapped" using the
 * {@link java.util.Collections#synchronizedSet Collections#synchronizedSet}
 * method.  This is best done at creation time, to prevent accidental
 * unsynchronized access to the set:<pre>
 *   Set s = Collections.synchronizedSet(new HashSet(...));</pre>
 *
 * <p>The iterators returned by this class's <tt>iterator</tt> method are
 * <i>fail-fast</i>: if the set is modified at any time after the iterator is
 * created, in any way except through the iterator's own <tt>remove</tt>
 * method, the Iterator throws a {@link java.util.ConcurrentModificationException ConcurrentModificationException}.
 * Thus, in the face of concurrent modification, the iterator fails quickly
 * and cleanly, rather than risking arbitrary, non-deterministic behavior at
 * an undetermined time in the future.
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
 * @param <E> the type of elements maintained by this set
 *
 * @author  Josh Bloch
 * @author  Neal Gafter
 * @see     java.util.Collection
 * @see     java.util.Set
 * @see     java.util.TreeSet
 * @see     java.util.HashMap
 * @since   1.2
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class HashSet<E> extends java.util.AbstractSet<E> implements java.util.Set<E>, java.lang.Cloneable, java.io.Serializable {

/**
 * Constructs a new, empty set; the backing <tt>HashMap</tt> instance has
 * default initial capacity (16) and load factor (0.75).
 * @apiSince 1
 */

public HashSet() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new set containing the elements in the specified
 * collection.  The <tt>HashMap</tt> is created with default load factor
 * (0.75) and an initial capacity sufficient to contain the elements in
 * the specified collection.
 *
 * @param c the collection whose elements are to be placed into this set
 * @throws java.lang.NullPointerException if the specified collection is null
 * @apiSince 1
 */

public HashSet(@androidx.annotation.NonNull java.util.Collection<? extends E> c) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new, empty set; the backing <tt>HashMap</tt> instance has
 * the specified initial capacity and the specified load factor.
 *
 * @param      initialCapacity   the initial capacity of the hash map
 * @param      loadFactor        the load factor of the hash map
 * @throws     java.lang.IllegalArgumentException if the initial capacity is less
 *             than zero, or if the load factor is nonpositive
 * @apiSince 1
 */

public HashSet(int initialCapacity, float loadFactor) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new, empty set; the backing <tt>HashMap</tt> instance has
 * the specified initial capacity and default load factor (0.75).
 *
 * @param      initialCapacity   the initial capacity of the hash table
 * @throws     java.lang.IllegalArgumentException if the initial capacity is less
 *             than zero
 * @apiSince 1
 */

public HashSet(int initialCapacity) { throw new RuntimeException("Stub!"); }

/**
 * Returns an iterator over the elements in this set.  The elements
 * are returned in no particular order.
 *
 * @return an Iterator over the elements in this set
 * @see java.util.ConcurrentModificationException
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.util.Iterator<E> iterator() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of elements in this set (its cardinality).
 *
 * @return the number of elements in this set (its cardinality)
 * @apiSince 1
 */

public int size() { throw new RuntimeException("Stub!"); }

/**
 * Returns <tt>true</tt> if this set contains no elements.
 *
 * @return <tt>true</tt> if this set contains no elements
 * @apiSince 1
 */

public boolean isEmpty() { throw new RuntimeException("Stub!"); }

/**
 * Returns <tt>true</tt> if this set contains the specified element.
 * More formally, returns <tt>true</tt> if and only if this set
 * contains an element <tt>e</tt> such that
 * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
 *
 * @param o element whose presence in this set is to be tested
 * @return <tt>true</tt> if this set contains the specified element
 * @apiSince 1
 */

public boolean contains(@androidx.annotation.Nullable java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Adds the specified element to this set if it is not already present.
 * More formally, adds the specified element <tt>e</tt> to this set if
 * this set contains no element <tt>e2</tt> such that
 * <tt>(e==null&nbsp;?&nbsp;e2==null&nbsp;:&nbsp;e.equals(e2))</tt>.
 * If this set already contains the element, the call leaves the set
 * unchanged and returns <tt>false</tt>.
 *
 * @param e element to be added to this set
 * @return <tt>true</tt> if this set did not already contain the specified
 * element
 * @apiSince 1
 */

public boolean add(E e) { throw new RuntimeException("Stub!"); }

/**
 * Removes the specified element from this set if it is present.
 * More formally, removes an element <tt>e</tt> such that
 * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>,
 * if this set contains such an element.  Returns <tt>true</tt> if
 * this set contained the element (or equivalently, if this set
 * changed as a result of the call).  (This set will not contain the
 * element once the call returns.)
 *
 * @param o object to be removed from this set, if present
 * @return <tt>true</tt> if the set contained the specified element
 * @apiSince 1
 */

public boolean remove(@androidx.annotation.Nullable java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Removes all of the elements from this set.
 * The set will be empty after this call returns.
 * @apiSince 1
 */

public void clear() { throw new RuntimeException("Stub!"); }

/**
 * Returns a shallow copy of this <tt>HashSet</tt> instance: the elements
 * themselves are not cloned.
 *
 * @return a shallow copy of this set
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.Object clone() { throw new RuntimeException("Stub!"); }

/**
 * Creates a <em><a href="Spliterator.html#binding">late-binding</a></em>
 * and <em>fail-fast</em> {@link java.util.Spliterator Spliterator} over the elements in this
 * set.
 *
 * <p>The {@code Spliterator} reports {@link java.util.Spliterator#SIZED Spliterator#SIZED} and
 * {@link java.util.Spliterator#DISTINCT Spliterator#DISTINCT}.  Overriding implementations should document
 * the reporting of additional characteristic values.
 *
 * @return a {@code Spliterator} over the elements in this set
 * @since 1.8
 * @apiSince 24
 */

@androidx.annotation.NonNull
public java.util.Spliterator<E> spliterator() { throw new RuntimeException("Stub!"); }
}

