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
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group.  Adapted and released, under explicit permission,
 * from JDK ArrayList.java which carries the following copyright:
 *
 * Copyright 1997 by Sun Microsystems, Inc.,
 * 901 San Antonio Road, Palo Alto, California, 94303, U.S.A.
 * All rights reserved.
 */



package java.util.concurrent;

import java.util.ConcurrentModificationException;
import java.util.Objects;
import java.util.Collection;
import java.util.List;
import java.util.Spliterator;

/**
 * A thread-safe variant of {@link java.util.ArrayList} in which all mutative
 * operations ({@code add}, {@code set}, and so on) are implemented by
 * making a fresh copy of the underlying array.
 *
 * <p>This is ordinarily too costly, but may be <em>more</em> efficient
 * than alternatives when traversal operations vastly outnumber
 * mutations, and is useful when you cannot or don't want to
 * synchronize traversals, yet need to preclude interference among
 * concurrent threads.  The "snapshot" style iterator method uses a
 * reference to the state of the array at the point that the iterator
 * was created. This array never changes during the lifetime of the
 * iterator, so interference is impossible and the iterator is
 * guaranteed not to throw {@code ConcurrentModificationException}.
 * The iterator will not reflect additions, removals, or changes to
 * the list since the iterator was created.  Element-changing
 * operations on iterators themselves ({@code remove}, {@code set}, and
 * {@code add}) are not supported. These methods throw
 * {@code UnsupportedOperationException}.
 *
 * <p>All elements are permitted, including {@code null}.
 *
 * <p>Memory consistency effects: As with other concurrent
 * collections, actions in a thread prior to placing an object into a
 * {@code CopyOnWriteArrayList}
 * <a href="package-summary.html#MemoryVisibility"><i>happen-before</i></a>
 * actions subsequent to the access or removal of that element from
 * the {@code CopyOnWriteArrayList} in another thread.
 *
 * @since 1.5
 * @author Doug Lea
 * @param <E> the type of elements held in this list
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CopyOnWriteArrayList<E> implements java.util.List<E>, java.util.RandomAccess, java.lang.Cloneable, java.io.Serializable {

/**
 * Creates an empty list.
 * @apiSince 1
 */

public CopyOnWriteArrayList() { throw new RuntimeException("Stub!"); }

/**
 * Creates a list containing the elements of the specified
 * collection, in the order they are returned by the collection's
 * iterator.
 *
 * @param c the collection of initially held elements
 * @throws java.lang.NullPointerException if the specified collection is null
 * @apiSince 1
 */

public CopyOnWriteArrayList(@androidx.annotation.NonNull java.util.Collection<? extends E> c) { throw new RuntimeException("Stub!"); }

/**
 * Creates a list holding a copy of the given array.
 *
 * @param toCopyIn the array (a copy of this array is used as the
 *        internal array)
 * @throws java.lang.NullPointerException if the specified array is null
 * @apiSince 1
 */

public CopyOnWriteArrayList(@androidx.annotation.NonNull E[] toCopyIn) { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of elements in this list.
 *
 * @return the number of elements in this list
 * @apiSince 1
 */

public int size() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this list contains no elements.
 *
 * @return {@code true} if this list contains no elements
 * @apiSince 1
 */

public boolean isEmpty() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this list contains the specified element.
 * More formally, returns {@code true} if and only if this list contains
 * at least one element {@code e} such that {@code Objects.equals(o, e)}.
 *
 * @param o element whose presence in this list is to be tested
 * @return {@code true} if this list contains the specified element
 * @apiSince 1
 */

public boolean contains(@androidx.annotation.Nullable java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public int indexOf(@androidx.annotation.Nullable java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Returns the index of the first occurrence of the specified element in
 * this list, searching forwards from {@code index}, or returns -1 if
 * the element is not found.
 * More formally, returns the lowest index {@code i} such that
 * {@code i >= index && Objects.equals(get(i), e)},
 * or -1 if there is no such index.
 *
 * @param e element to search for
 * @param index index to start searching from
 * @return the index of the first occurrence of the element in
 *         this list at position {@code index} or later in the list;
 *         {@code -1} if the element is not found.
 * @throws java.lang.IndexOutOfBoundsException if the specified index is negative
 * @apiSince 1
 */

public int indexOf(@androidx.annotation.Nullable E e, int index) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public int lastIndexOf(@androidx.annotation.Nullable java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Returns the index of the last occurrence of the specified element in
 * this list, searching backwards from {@code index}, or returns -1 if
 * the element is not found.
 * More formally, returns the highest index {@code i} such that
 * {@code i <= index && Objects.equals(get(i), e)},
 * or -1 if there is no such index.
 *
 * @param e element to search for
 * @param index index to start searching backwards from
 * @return the index of the last occurrence of the element at position
 *         less than or equal to {@code index} in this list;
 *         -1 if the element is not found.
 * @throws java.lang.IndexOutOfBoundsException if the specified index is greater
 *         than or equal to the current size of this list
 * @apiSince 1
 */

public int lastIndexOf(@androidx.annotation.Nullable E e, int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns a shallow copy of this list.  (The elements themselves
 * are not copied.)
 *
 * @return a clone of this list
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.Object clone() { throw new RuntimeException("Stub!"); }

/**
 * Returns an array containing all of the elements in this list
 * in proper sequence (from first to last element).
 *
 * <p>The returned array will be "safe" in that no references to it are
 * maintained by this list.  (In other words, this method must allocate
 * a new array).  The caller is thus free to modify the returned array.
 *
 * <p>This method acts as bridge between array-based and collection-based
 * APIs.
 *
 * @return an array containing all the elements in this list
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.Object[] toArray() { throw new RuntimeException("Stub!"); }

/**
 * Returns an array containing all of the elements in this list in
 * proper sequence (from first to last element); the runtime type of
 * the returned array is that of the specified array.  If the list fits
 * in the specified array, it is returned therein.  Otherwise, a new
 * array is allocated with the runtime type of the specified array and
 * the size of this list.
 *
 * <p>If this list fits in the specified array with room to spare
 * (i.e., the array has more elements than this list), the element in
 * the array immediately following the end of the list is set to
 * {@code null}.  (This is useful in determining the length of this
 * list <i>only</i> if the caller knows that this list does not contain
 * any null elements.)
 *
 * <p>Like the {@link #toArray()} method, this method acts as bridge between
 * array-based and collection-based APIs.  Further, this method allows
 * precise control over the runtime type of the output array, and may,
 * under certain circumstances, be used to save allocation costs.
 *
 * <p>Suppose {@code x} is a list known to contain only strings.
 * The following code can be used to dump the list into a newly
 * allocated array of {@code String}:
 *
 * <pre> {@code String[] y = x.toArray(new String[0]);}</pre>
 *
 * Note that {@code toArray(new Object[0])} is identical in function to
 * {@code toArray()}.
 *
 * @param a the array into which the elements of the list are to
 *          be stored, if it is big enough; otherwise, a new array of the
 *          same runtime type is allocated for this purpose.
 * @return an array containing all the elements in this list
 * @throws java.lang.ArrayStoreException if the runtime type of the specified array
 *         is not a supertype of the runtime type of every element in
 *         this list
 * @throws java.lang.NullPointerException if the specified array is null
 * @apiSince 1
 */

@androidx.annotation.NonNull
public <T> T[] toArray(@androidx.annotation.NonNull T[] a) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * @throws java.lang.IndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

public E get(int index) { throw new RuntimeException("Stub!"); }

/**
 * Replaces the element at the specified position in this list with the
 * specified element.
 *
 * @throws java.lang.IndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

public E set(int index, E element) { throw new RuntimeException("Stub!"); }

/**
 * Appends the specified element to the end of this list.
 *
 * @param e element to be appended to this list
 * @return {@code true} (as specified by {@link java.util.Collection#add Collection#add})
 * @apiSince 1
 */

public boolean add(E e) { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified element at the specified position in this
 * list. Shifts the element currently at that position (if any) and
 * any subsequent elements to the right (adds one to their indices).
 *
 * @throws java.lang.IndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

public void add(int index, E element) { throw new RuntimeException("Stub!"); }

/**
 * Removes the element at the specified position in this list.
 * Shifts any subsequent elements to the left (subtracts one from their
 * indices).  Returns the element that was removed from the list.
 *
 * @throws java.lang.IndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

public E remove(int index) { throw new RuntimeException("Stub!"); }

/**
 * Removes the first occurrence of the specified element from this list,
 * if it is present.  If this list does not contain the element, it is
 * unchanged.  More formally, removes the element with the lowest index
 * {@code i} such that {@code Objects.equals(o, get(i))}
 * (if such an element exists).  Returns {@code true} if this list
 * contained the specified element (or equivalently, if this list
 * changed as a result of the call).
 *
 * @param o element to be removed from this list, if present
 * @return {@code true} if this list contained the specified element
 * @apiSince 1
 */

public boolean remove(@androidx.annotation.Nullable java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Appends the element, if not present.
 *
 * @param e element to be added to this list, if absent
 * @return {@code true} if the element was added
 * @apiSince 1
 */

public boolean addIfAbsent(E e) { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this list contains all of the elements of the
 * specified collection.
 *
 * @param c collection to be checked for containment in this list
 * @return {@code true} if this list contains all of the elements of the
 *         specified collection
 * @throws java.lang.NullPointerException if the specified collection is null
 * @see #contains(Object)
 * @apiSince 1
 */

public boolean containsAll(@androidx.annotation.NonNull java.util.Collection<?> c) { throw new RuntimeException("Stub!"); }

/**
 * Removes from this list all of its elements that are contained in
 * the specified collection. This is a particularly expensive operation
 * in this class because of the need for an internal temporary array.
 *
 * @param c collection containing elements to be removed from this list
 * @return {@code true} if this list changed as a result of the call
 * @throws java.lang.ClassCastException if the class of an element of this list
 *         is incompatible with the specified collection
 * (<a href="../Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.NullPointerException if this list contains a null element and the
 *         specified collection does not permit null elements
 * (<a href="../Collection.html#optional-restrictions">optional</a>),
 *         or if the specified collection is null
 * @see #remove(Object)
 * @apiSince 1
 */

public boolean removeAll(@androidx.annotation.NonNull java.util.Collection<?> c) { throw new RuntimeException("Stub!"); }

/**
 * Retains only the elements in this list that are contained in the
 * specified collection.  In other words, removes from this list all of
 * its elements that are not contained in the specified collection.
 *
 * @param c collection containing elements to be retained in this list
 * @return {@code true} if this list changed as a result of the call
 * @throws java.lang.ClassCastException if the class of an element of this list
 *         is incompatible with the specified collection
 * (<a href="{@docRoot}/../api/java/util/Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.NullPointerException if this list contains a null element and the
 *         specified collection does not permit null elements
 * (<a href="{@docRoot}/../api/java/util/Collection.html#optional-restrictions">optional</a>),
 *         or if the specified collection is null
 * @see #remove(Object)
 * @apiSince 1
 */

public boolean retainAll(@androidx.annotation.NonNull java.util.Collection<?> c) { throw new RuntimeException("Stub!"); }

/**
 * Appends all of the elements in the specified collection that
 * are not already contained in this list, to the end of
 * this list, in the order that they are returned by the
 * specified collection's iterator.
 *
 * @param c collection containing elements to be added to this list
 * @return the number of elements added
 * @throws java.lang.NullPointerException if the specified collection is null
 * @see #addIfAbsent(Object)
 * @apiSince 1
 */

public int addAllAbsent(@androidx.annotation.NonNull java.util.Collection<? extends E> c) { throw new RuntimeException("Stub!"); }

/**
 * Removes all of the elements from this list.
 * The list will be empty after this call returns.
 * @apiSince 1
 */

public void clear() { throw new RuntimeException("Stub!"); }

/**
 * Appends all of the elements in the specified collection to the end
 * of this list, in the order that they are returned by the specified
 * collection's iterator.
 *
 * @param c collection containing elements to be added to this list
 * @return {@code true} if this list changed as a result of the call
 * @throws java.lang.NullPointerException if the specified collection is null
 * @see #add(Object)
 * @apiSince 1
 */

public boolean addAll(@androidx.annotation.NonNull java.util.Collection<? extends E> c) { throw new RuntimeException("Stub!"); }

/**
 * Inserts all of the elements in the specified collection into this
 * list, starting at the specified position.  Shifts the element
 * currently at that position (if any) and any subsequent elements to
 * the right (increases their indices).  The new elements will appear
 * in this list in the order that they are returned by the
 * specified collection's iterator.
 *
 * @param index index at which to insert the first element
 *        from the specified collection
 * @param c collection containing elements to be added to this list
 * @return {@code true} if this list changed as a result of the call
 * @throws java.lang.IndexOutOfBoundsException {@inheritDoc}
 * @throws java.lang.NullPointerException if the specified collection is null
 * @see #add(int,Object)
 * @apiSince 1
 */

public boolean addAll(int index, @androidx.annotation.NonNull java.util.Collection<? extends E> c) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public void forEach(@androidx.annotation.NonNull java.util.function.Consumer<? super E> action) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public boolean removeIf(@androidx.annotation.NonNull java.util.function.Predicate<? super E> filter) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public void replaceAll(@androidx.annotation.NonNull java.util.function.UnaryOperator<E> operator) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public void sort(@androidx.annotation.Nullable java.util.Comparator<? super E> c) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of this list.  The string
 * representation consists of the string representations of the list's
 * elements in the order they are returned by its iterator, enclosed in
 * square brackets ({@code "[]"}).  Adjacent elements are separated by
 * the characters {@code ", "} (comma and space).  Elements are
 * converted to strings as by {@link java.lang.String#valueOf(java.lang.Object) String#valueOf(Object)}.
 *
 * @return a string representation of this list
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Compares the specified object with this list for equality.
 * Returns {@code true} if the specified object is the same object
 * as this object, or if it is also a {@link java.util.List List} and the sequence
 * of elements returned by an {@linkplain java.util.List#iterator() List#iterator()}
 * over the specified list is the same as the sequence returned by
 * an iterator over this list.  The two sequences are considered to
 * be the same if they have the same length and corresponding
 * elements at the same position in the sequence are <em>equal</em>.
 * Two elements {@code e1} and {@code e2} are considered
 * <em>equal</em> if {@code Objects.equals(e1, e2)}.
 *
 * @param o the object to be compared for equality with this list
 * @return {@code true} if the specified object is equal to this list
 * @apiSince 1
 */

public boolean equals(@androidx.annotation.Nullable java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Returns the hash code value for this list.
 *
 * <p>This implementation uses the definition in {@link java.util.List#hashCode List#hashCode}.
 *
 * @return the hash code value for this list
 * @apiSince 1
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns an iterator over the elements in this list in proper sequence.
 *
 * <p>The returned iterator provides a snapshot of the state of the list
 * when the iterator was constructed. No synchronization is needed while
 * traversing the iterator. The iterator does <em>NOT</em> support the
 * {@code remove} method.
 *
 * @return an iterator over the elements in this list in proper sequence
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.util.Iterator<E> iterator() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * <p>The returned iterator provides a snapshot of the state of the list
 * when the iterator was constructed. No synchronization is needed while
 * traversing the iterator. The iterator does <em>NOT</em> support the
 * {@code remove}, {@code set} or {@code add} methods.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.util.ListIterator<E> listIterator() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * <p>The returned iterator provides a snapshot of the state of the list
 * when the iterator was constructed. No synchronization is needed while
 * traversing the iterator. The iterator does <em>NOT</em> support the
 * {@code remove}, {@code set} or {@code add} methods.
 *
 * @throws java.lang.IndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.util.ListIterator<E> listIterator(int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.Spliterator Spliterator} over the elements in this list.
 *
 * <p>The {@code Spliterator} reports {@link java.util.Spliterator#IMMUTABLE Spliterator#IMMUTABLE},
 * {@link java.util.Spliterator#ORDERED Spliterator#ORDERED}, {@link java.util.Spliterator#SIZED Spliterator#SIZED}, and
 * {@link java.util.Spliterator#SUBSIZED Spliterator#SUBSIZED}.
 *
 * <p>The spliterator provides a snapshot of the state of the list
 * when the spliterator was constructed. No synchronization is needed while
 * operating on the spliterator.
 *
 * @return a {@code Spliterator} over the elements in this list
 * @since 1.8
 * @apiSince 24
 */

@androidx.annotation.NonNull
public java.util.Spliterator<E> spliterator() { throw new RuntimeException("Stub!"); }

/**
 * Returns a view of the portion of this list between
 * {@code fromIndex}, inclusive, and {@code toIndex}, exclusive.
 * The returned list is backed by this list, so changes in the
 * returned list are reflected in this list.
 *
 * <p>The semantics of the list returned by this method become
 * undefined if the backing list (i.e., this list) is modified in
 * any way other than via the returned list.
 *
 * @param fromIndex low endpoint (inclusive) of the subList
 * @param toIndex high endpoint (exclusive) of the subList
 * @return a view of the specified range within this list
 * @throws java.lang.IndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.util.List<E> subList(int fromIndex, int toIndex) { throw new RuntimeException("Stub!"); }
}

