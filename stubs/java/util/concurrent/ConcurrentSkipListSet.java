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

import java.util.NavigableSet;
import java.util.Set;
import java.util.Iterator;
import java.util.Comparator;
import java.util.Collection;
import java.util.Collections;
import java.util.Spliterator;

/**
 * A scalable concurrent {@link java.util.NavigableSet NavigableSet} implementation based on
 * a {@link java.util.concurrent.ConcurrentSkipListMap ConcurrentSkipListMap}.  The elements of the set are kept
 * sorted according to their {@linkplain java.lang.Comparable Comparable},
 * or by a {@link java.util.Comparator Comparator} provided at set creation time, depending
 * on which constructor is used.
 *
 * <p>This implementation provides expected average <i>log(n)</i> time
 * cost for the {@code contains}, {@code add}, and {@code remove}
 * operations and their variants.  Insertion, removal, and access
 * operations safely execute concurrently by multiple threads.
 *
 * <p>Iterators and spliterators are
 * <a href="package-summary.html#Weakly"><i>weakly consistent</i></a>.
 *
 * <p>Ascending ordered views and their iterators are faster than
 * descending ones.
 *
 * <p>Beware that, unlike in most collections, the {@code size}
 * method is <em>not</em> a constant-time operation. Because of the
 * asynchronous nature of these sets, determining the current number
 * of elements requires a traversal of the elements, and so may report
 * inaccurate results if this collection is modified during traversal.
 * Additionally, the bulk operations {@code addAll},
 * {@code removeAll}, {@code retainAll}, {@code containsAll},
 * {@code equals}, and {@code toArray} are <em>not</em> guaranteed
 * to be performed atomically. For example, an iterator operating
 * concurrently with an {@code addAll} operation might view only some
 * of the added elements.
 *
 * <p>This class and its iterators implement all of the
 * <em>optional</em> methods of the {@link java.util.Set Set} and {@link java.util.Iterator Iterator}
 * interfaces. Like most other concurrent collection implementations,
 * this class does not permit the use of {@code null} elements,
 * because {@code null} arguments and return values cannot be reliably
 * distinguished from the absence of elements.
 *
 * @author Doug Lea
 * @param <E> the type of elements maintained by this set
 * @since 1.6
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ConcurrentSkipListSet<E> extends java.util.AbstractSet<E> implements java.util.NavigableSet<E>, java.lang.Cloneable, java.io.Serializable {

/**
 * Constructs a new, empty set that orders its elements according to
 * their {@linkplain java.lang.Comparable Comparable}.
 * @apiSince 9
 */

public ConcurrentSkipListSet() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new, empty set that orders its elements according to
 * the specified comparator.
 *
 * @param comparator the comparator that will be used to order this set.
 *        If {@code null}, the {@linkplain java.lang.Comparable Comparable} of the elements will be used.
 * @apiSince 9
 */

public ConcurrentSkipListSet(java.util.Comparator<? super E> comparator) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new set containing the elements in the specified
 * collection, that orders its elements according to their
 * {@linkplain java.lang.Comparable Comparable}.
 *
 * @param c The elements that will comprise the new set
 * @throws java.lang.ClassCastException if the elements in {@code c} are
 *         not {@link java.lang.Comparable Comparable}, or are not mutually comparable
 * @throws java.lang.NullPointerException if the specified collection or any
 *         of its elements are null
 * @apiSince 9
 */

public ConcurrentSkipListSet(java.util.Collection<? extends E> c) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new set containing the same elements and using the
 * same ordering as the specified sorted set.
 *
 * @param s sorted set whose elements will comprise the new set
 * @throws java.lang.NullPointerException if the specified sorted set or any
 *         of its elements are null
 * @apiSince 9
 */

public ConcurrentSkipListSet(java.util.SortedSet<E> s) { throw new RuntimeException("Stub!"); }

/**
 * Returns a shallow copy of this {@code ConcurrentSkipListSet}
 * instance. (The elements themselves are not cloned.)
 *
 * @return a shallow copy of this set
 * @apiSince 9
 */

public java.util.concurrent.ConcurrentSkipListSet<E> clone() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of elements in this set.  If this set
 * contains more than {@code Integer.MAX_VALUE} elements, it
 * returns {@code Integer.MAX_VALUE}.
 *
 * <p>Beware that, unlike in most collections, this method is
 * <em>NOT</em> a constant-time operation. Because of the
 * asynchronous nature of these sets, determining the current
 * number of elements requires traversing them all to count them.
 * Additionally, it is possible for the size to change during
 * execution of this method, in which case the returned result
 * will be inaccurate. Thus, this method is typically not very
 * useful in concurrent applications.
 *
 * @return the number of elements in this set
 * @apiSince 9
 */

public int size() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this set contains no elements.
 * @return {@code true} if this set contains no elements
 * @apiSince 9
 */

public boolean isEmpty() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this set contains the specified element.
 * More formally, returns {@code true} if and only if this set
 * contains an element {@code e} such that {@code o.equals(e)}.
 *
 * @param o object to be checked for containment in this set
 * @return {@code true} if this set contains the specified element
 * @throws java.lang.ClassCastException if the specified element cannot be
 *         compared with the elements currently in this set
 * @throws java.lang.NullPointerException if the specified element is null
 * @apiSince 9
 */

public boolean contains(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Adds the specified element to this set if it is not already present.
 * More formally, adds the specified element {@code e} to this set if
 * the set contains no element {@code e2} such that {@code e.equals(e2)}.
 * If this set already contains the element, the call leaves the set
 * unchanged and returns {@code false}.
 *
 * @param e element to be added to this set
 * @return {@code true} if this set did not already contain the
 *         specified element
 * @throws java.lang.ClassCastException if {@code e} cannot be compared
 *         with the elements currently in this set
 * @throws java.lang.NullPointerException if the specified element is null
 * @apiSince 9
 */

public boolean add(E e) { throw new RuntimeException("Stub!"); }

/**
 * Removes the specified element from this set if it is present.
 * More formally, removes an element {@code e} such that
 * {@code o.equals(e)}, if this set contains such an element.
 * Returns {@code true} if this set contained the element (or
 * equivalently, if this set changed as a result of the call).
 * (This set will not contain the element once the call returns.)
 *
 * @param o object to be removed from this set, if present
 * @return {@code true} if this set contained the specified element
 * @throws java.lang.ClassCastException if {@code o} cannot be compared
 *         with the elements currently in this set
 * @throws java.lang.NullPointerException if the specified element is null
 * @apiSince 9
 */

public boolean remove(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Removes all of the elements from this set.
 * @apiSince 9
 */

public void clear() { throw new RuntimeException("Stub!"); }

/**
 * Returns an iterator over the elements in this set in ascending order.
 *
 * @return an iterator over the elements in this set in ascending order
 * @apiSince 9
 */

public java.util.Iterator<E> iterator() { throw new RuntimeException("Stub!"); }

/**
 * Returns an iterator over the elements in this set in descending order.
 *
 * @return an iterator over the elements in this set in descending order
 * @apiSince 9
 */

public java.util.Iterator<E> descendingIterator() { throw new RuntimeException("Stub!"); }

/**
 * Compares the specified object with this set for equality.  Returns
 * {@code true} if the specified object is also a set, the two sets
 * have the same size, and every member of the specified set is
 * contained in this set (or equivalently, every member of this set is
 * contained in the specified set).  This definition ensures that the
 * equals method works properly across different implementations of the
 * set interface.
 *
 * @param o the object to be compared for equality with this set
 * @return {@code true} if the specified object is equal to this set
 * @apiSince 9
 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Removes from this set all of its elements that are contained in
 * the specified collection.  If the specified collection is also
 * a set, this operation effectively modifies this set so that its
 * value is the <i>asymmetric set difference</i> of the two sets.
 *
 * @param  c collection containing elements to be removed from this set
 * @return {@code true} if this set changed as a result of the call
 * @throws java.lang.ClassCastException if the class of an element of this set
 *         is incompatible with the specified collection
 * (<a href="../Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.NullPointerException if the specified collection or any
 *         of its elements are null
 * @apiSince 9
 */

public boolean removeAll(java.util.Collection<?> c) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if the specified element is null
 * @apiSince 9
 */

public E lower(E e) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if the specified element is null
 * @apiSince 9
 */

public E floor(E e) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if the specified element is null
 * @apiSince 9
 */

public E ceiling(E e) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if the specified element is null
 * @apiSince 9
 */

public E higher(E e) { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public E pollFirst() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public E pollLast() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public java.util.Comparator<? super E> comparator() { throw new RuntimeException("Stub!"); }

/**
 * @throws java.util.NoSuchElementException {@inheritDoc}
 * @apiSince 9
 */

public E first() { throw new RuntimeException("Stub!"); }

/**
 * @throws java.util.NoSuchElementException {@inheritDoc}
 * @apiSince 9
 */

public E last() { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if {@code fromElement} or
 *         {@code toElement} is null
 * @throws java.lang.IllegalArgumentException {@inheritDoc}
 * @apiSince 9
 */

public java.util.NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if {@code toElement} is null
 * @throws java.lang.IllegalArgumentException {@inheritDoc}
 * @apiSince 9
 */

public java.util.NavigableSet<E> headSet(E toElement, boolean inclusive) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if {@code fromElement} is null
 * @throws java.lang.IllegalArgumentException {@inheritDoc}
 * @apiSince 9
 */

public java.util.NavigableSet<E> tailSet(E fromElement, boolean inclusive) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if {@code fromElement} or
 *         {@code toElement} is null
 * @throws java.lang.IllegalArgumentException {@inheritDoc}
 * @apiSince 9
 */

public java.util.NavigableSet<E> subSet(E fromElement, E toElement) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if {@code toElement} is null
 * @throws java.lang.IllegalArgumentException {@inheritDoc}
 * @apiSince 9
 */

public java.util.NavigableSet<E> headSet(E toElement) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if {@code fromElement} is null
 * @throws java.lang.IllegalArgumentException {@inheritDoc}
 * @apiSince 9
 */

public java.util.NavigableSet<E> tailSet(E fromElement) { throw new RuntimeException("Stub!"); }

/**
 * Returns a reverse order view of the elements contained in this set.
 * The descending set is backed by this set, so changes to the set are
 * reflected in the descending set, and vice-versa.
 *
 * <p>The returned set has an ordering equivalent to
 * {@link java.util.Collections#reverseOrder(java.util.Comparator) Collections#reverseOrder(Comparator)}{@code (comparator())}.
 * The expression {@code s.descendingSet().descendingSet()} returns a
 * view of {@code s} essentially equivalent to {@code s}.
 *
 * @return a reverse order view of this set
 * @apiSince 9
 */

public java.util.NavigableSet<E> descendingSet() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.Spliterator Spliterator} over the elements in this set.
 *
 * <p>The {@code Spliterator} reports {@link java.util.Spliterator#CONCURRENT Spliterator#CONCURRENT},
 * {@link java.util.Spliterator#NONNULL Spliterator#NONNULL}, {@link java.util.Spliterator#DISTINCT Spliterator#DISTINCT},
 * {@link java.util.Spliterator#SORTED Spliterator#SORTED} and {@link java.util.Spliterator#ORDERED Spliterator#ORDERED}, with an
 * encounter order that is ascending order.  Overriding implementations
 * should document the reporting of additional characteristic values.
 *
 * <p>The spliterator's comparator (see
 * {@link java.util.Spliterator#getComparator()}) is {@code null} if
 * the set's comparator (see {@link #comparator()}) is {@code null}.
 * Otherwise, the spliterator's comparator is the same as or imposes the
 * same total ordering as the set's comparator.
 *
 * @return a {@code Spliterator} over the elements in this set
 * @since 1.8
 * @apiSince 24
 */

public java.util.Spliterator<E> spliterator() { throw new RuntimeException("Stub!"); }
}

