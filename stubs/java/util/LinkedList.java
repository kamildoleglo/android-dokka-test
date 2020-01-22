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
 * Doubly-linked list implementation of the {@code List} and {@code Deque}
 * interfaces.  Implements all optional list operations, and permits all
 * elements (including {@code null}).
 *
 * <p>All of the operations perform as could be expected for a doubly-linked
 * list.  Operations that index into the list will traverse the list from
 * the beginning or the end, whichever is closer to the specified index.
 *
 * <p><strong>Note that this implementation is not synchronized.</strong>
 * If multiple threads access a linked list concurrently, and at least
 * one of the threads modifies the list structurally, it <i>must</i> be
 * synchronized externally.  (A structural modification is any operation
 * that adds or deletes one or more elements; merely setting the value of
 * an element is not a structural modification.)  This is typically
 * accomplished by synchronizing on some object that naturally
 * encapsulates the list.
 *
 * If no such object exists, the list should be "wrapped" using the
 * {@link java.util.Collections#synchronizedList Collections#synchronizedList}
 * method.  This is best done at creation time, to prevent accidental
 * unsynchronized access to the list:<pre>
 *   List list = Collections.synchronizedList(new LinkedList(...));</pre>
 *
 * <p>The iterators returned by this class's {@code iterator} and
 * {@code listIterator} methods are <i>fail-fast</i>: if the list is
 * structurally modified at any time after the iterator is created, in
 * any way except through the Iterator's own {@code remove} or
 * {@code add} methods, the iterator will throw a {@link java.util.ConcurrentModificationException ConcurrentModificationException}.  Thus, in the face of concurrent
 * modification, the iterator fails quickly and cleanly, rather than
 * risking arbitrary, non-deterministic behavior at an undetermined
 * time in the future.
 *
 * <p>Note that the fail-fast behavior of an iterator cannot be guaranteed
 * as it is, generally speaking, impossible to make any hard guarantees in the
 * presence of unsynchronized concurrent modification.  Fail-fast iterators
 * throw {@code ConcurrentModificationException} on a best-effort basis.
 * Therefore, it would be wrong to write a program that depended on this
 * exception for its correctness:   <i>the fail-fast behavior of iterators
 * should be used only to detect bugs.</i>
 *
 * <p>This class is a member of the
 * <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @author  Josh Bloch
 * @see     java.util.List
 * @see     java.util.ArrayList
 * @since 1.2
 * @param <E> the type of elements held in this collection
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class LinkedList<E> extends java.util.AbstractSequentialList<E> implements java.util.List<E>, java.util.Deque<E>, java.lang.Cloneable, java.io.Serializable {

/**
 * Constructs an empty list.
 * @apiSince 1
 */

public LinkedList() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a list containing the elements of the specified
 * collection, in the order they are returned by the collection's
 * iterator.
 *
 * @param  c the collection whose elements are to be placed into this list
 * @throws java.lang.NullPointerException if the specified collection is null
 * @apiSince 1
 */

public LinkedList(@androidx.annotation.NonNull java.util.Collection<? extends E> c) { throw new RuntimeException("Stub!"); }

/**
 * Returns the first element in this list.
 *
 * @return the first element in this list
 * @throws java.util.NoSuchElementException if this list is empty
 * @apiSince 1
 */

public E getFirst() { throw new RuntimeException("Stub!"); }

/**
 * Returns the last element in this list.
 *
 * @return the last element in this list
 * @throws java.util.NoSuchElementException if this list is empty
 * @apiSince 1
 */

public E getLast() { throw new RuntimeException("Stub!"); }

/**
 * Removes and returns the first element from this list.
 *
 * @return the first element from this list
 * @throws java.util.NoSuchElementException if this list is empty
 * @apiSince 1
 */

public E removeFirst() { throw new RuntimeException("Stub!"); }

/**
 * Removes and returns the last element from this list.
 *
 * @return the last element from this list
 * @throws java.util.NoSuchElementException if this list is empty
 * @apiSince 1
 */

public E removeLast() { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified element at the beginning of this list.
 *
 * @param e the element to add
 * @apiSince 1
 */

public void addFirst(E e) { throw new RuntimeException("Stub!"); }

/**
 * Appends the specified element to the end of this list.
 *
 * <p>This method is equivalent to {@link #add}.
 *
 * @param e the element to add
 * @apiSince 1
 */

public void addLast(E e) { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this list contains the specified element.
 * More formally, returns {@code true} if and only if this list contains
 * at least one element {@code e} such that
 * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
 *
 * @param o element whose presence in this list is to be tested
 * @return {@code true} if this list contains the specified element
 * @apiSince 1
 */

public boolean contains(@androidx.annotation.Nullable java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of elements in this list.
 *
 * @return the number of elements in this list
 * @apiSince 1
 */

public int size() { throw new RuntimeException("Stub!"); }

/**
 * Appends the specified element to the end of this list.
 *
 * <p>This method is equivalent to {@link #addLast}.
 *
 * @param e element to be appended to this list
 * @return {@code true} (as specified by {@link java.util.Collection#add Collection#add})
 * @apiSince 1
 */

public boolean add(E e) { throw new RuntimeException("Stub!"); }

/**
 * Removes the first occurrence of the specified element from this list,
 * if it is present.  If this list does not contain the element, it is
 * unchanged.  More formally, removes the element with the lowest index
 * {@code i} such that
 * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>
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
 * Appends all of the elements in the specified collection to the end of
 * this list, in the order that they are returned by the specified
 * collection's iterator.  The behavior of this operation is undefined if
 * the specified collection is modified while the operation is in
 * progress.  (Note that this will occur if the specified collection is
 * this list, and it's nonempty.)
 *
 * @param c collection containing elements to be added to this list
 * @return {@code true} if this list changed as a result of the call
 * @throws java.lang.NullPointerException if the specified collection is null
 * @apiSince 1
 */

public boolean addAll(@androidx.annotation.NonNull java.util.Collection<? extends E> c) { throw new RuntimeException("Stub!"); }

/**
 * Inserts all of the elements in the specified collection into this
 * list, starting at the specified position.  Shifts the element
 * currently at that position (if any) and any subsequent elements to
 * the right (increases their indices).  The new elements will appear
 * in the list in the order that they are returned by the
 * specified collection's iterator.
 *
 * @param index index at which to insert the first element
 *              from the specified collection
 * @param c collection containing elements to be added to this list
 * @return {@code true} if this list changed as a result of the call
 * @throws java.lang.IndexOutOfBoundsException {@inheritDoc}
 * @throws java.lang.NullPointerException if the specified collection is null
 * @apiSince 1
 */

public boolean addAll(int index, @androidx.annotation.NonNull java.util.Collection<? extends E> c) { throw new RuntimeException("Stub!"); }

/**
 * Removes all of the elements from this list.
 * The list will be empty after this call returns.
 * @apiSince 1
 */

public void clear() { throw new RuntimeException("Stub!"); }

/**
 * Returns the element at the specified position in this list.
 *
 * @param index index of the element to return
 * @return the element at the specified position in this list
 * @throws java.lang.IndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

public E get(int index) { throw new RuntimeException("Stub!"); }

/**
 * Replaces the element at the specified position in this list with the
 * specified element.
 *
 * @param index index of the element to replace
 * @param element element to be stored at the specified position
 * @return the element previously at the specified position
 * @throws java.lang.IndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

public E set(int index, E element) { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified element at the specified position in this list.
 * Shifts the element currently at that position (if any) and any
 * subsequent elements to the right (adds one to their indices).
 *
 * @param index index at which the specified element is to be inserted
 * @param element element to be inserted
 * @throws java.lang.IndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

public void add(int index, E element) { throw new RuntimeException("Stub!"); }

/**
 * Removes the element at the specified position in this list.  Shifts any
 * subsequent elements to the left (subtracts one from their indices).
 * Returns the element that was removed from the list.
 *
 * @param index the index of the element to be removed
 * @return the element previously at the specified position
 * @throws java.lang.IndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

public E remove(int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns the index of the first occurrence of the specified element
 * in this list, or -1 if this list does not contain the element.
 * More formally, returns the lowest index {@code i} such that
 * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
 * or -1 if there is no such index.
 *
 * @param o element to search for
 * @return the index of the first occurrence of the specified element in
 *         this list, or -1 if this list does not contain the element
 * @apiSince 1
 */

public int indexOf(@androidx.annotation.Nullable java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Returns the index of the last occurrence of the specified element
 * in this list, or -1 if this list does not contain the element.
 * More formally, returns the highest index {@code i} such that
 * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
 * or -1 if there is no such index.
 *
 * @param o element to search for
 * @return the index of the last occurrence of the specified element in
 *         this list, or -1 if this list does not contain the element
 * @apiSince 1
 */

public int lastIndexOf(@androidx.annotation.Nullable java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves, but does not remove, the head (first element) of this list.
 *
 * @return the head of this list, or {@code null} if this list is empty
 * @since 1.5
 * @apiSince 1
 */

@androidx.annotation.Nullable
public E peek() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves, but does not remove, the head (first element) of this list.
 *
 * @return the head of this list
 * @throws java.util.NoSuchElementException if this list is empty
 * @since 1.5
 * @apiSince 1
 */

public E element() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves and removes the head (first element) of this list.
 *
 * @return the head of this list, or {@code null} if this list is empty
 * @since 1.5
 * @apiSince 1
 */

@androidx.annotation.Nullable
public E poll() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves and removes the head (first element) of this list.
 *
 * @return the head of this list
 * @throws java.util.NoSuchElementException if this list is empty
 * @since 1.5
 * @apiSince 1
 */

public E remove() { throw new RuntimeException("Stub!"); }

/**
 * Adds the specified element as the tail (last element) of this list.
 *
 * @param e the element to add
 * @return {@code true} (as specified by {@link java.util.Queue#offer Queue#offer})
 * @since 1.5
 * @apiSince 1
 */

public boolean offer(E e) { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified element at the front of this list.
 *
 * @param e the element to insert
 * @return {@code true} (as specified by {@link java.util.Deque#offerFirst Deque#offerFirst})
 * @since 1.6
 * @apiSince 9
 */

public boolean offerFirst(E e) { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified element at the end of this list.
 *
 * @param e the element to insert
 * @return {@code true} (as specified by {@link java.util.Deque#offerLast Deque#offerLast})
 * @since 1.6
 * @apiSince 9
 */

public boolean offerLast(E e) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves, but does not remove, the first element of this list,
 * or returns {@code null} if this list is empty.
 *
 * @return the first element of this list, or {@code null}
 *         if this list is empty
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.Nullable
public E peekFirst() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves, but does not remove, the last element of this list,
 * or returns {@code null} if this list is empty.
 *
 * @return the last element of this list, or {@code null}
 *         if this list is empty
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.Nullable
public E peekLast() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves and removes the first element of this list,
 * or returns {@code null} if this list is empty.
 *
 * @return the first element of this list, or {@code null} if
 *     this list is empty
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.Nullable
public E pollFirst() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves and removes the last element of this list,
 * or returns {@code null} if this list is empty.
 *
 * @return the last element of this list, or {@code null} if
 *     this list is empty
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.Nullable
public E pollLast() { throw new RuntimeException("Stub!"); }

/**
 * Pushes an element onto the stack represented by this list.  In other
 * words, inserts the element at the front of this list.
 *
 * <p>This method is equivalent to {@link #addFirst}.
 *
 * @param e the element to push
 * @since 1.6
 * @apiSince 9
 */

public void push(E e) { throw new RuntimeException("Stub!"); }

/**
 * Pops an element from the stack represented by this list.  In other
 * words, removes and returns the first element of this list.
 *
 * <p>This method is equivalent to {@link #removeFirst()}.
 *
 * @return the element at the front of this list (which is the top
 *         of the stack represented by this list)
 * @throws java.util.NoSuchElementException if this list is empty
 * @since 1.6
 * @apiSince 9
 */

public E pop() { throw new RuntimeException("Stub!"); }

/**
 * Removes the first occurrence of the specified element in this
 * list (when traversing the list from head to tail).  If the list
 * does not contain the element, it is unchanged.
 *
 * @param o element to be removed from this list, if present
 * @return {@code true} if the list contained the specified element
 * @since 1.6
 * @apiSince 9
 */

public boolean removeFirstOccurrence(@androidx.annotation.Nullable java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Removes the last occurrence of the specified element in this
 * list (when traversing the list from head to tail).  If the list
 * does not contain the element, it is unchanged.
 *
 * @param o element to be removed from this list, if present
 * @return {@code true} if the list contained the specified element
 * @since 1.6
 * @apiSince 9
 */

public boolean removeLastOccurrence(@androidx.annotation.Nullable java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Returns a list-iterator of the elements in this list (in proper
 * sequence), starting at the specified position in the list.
 * Obeys the general contract of {@code List.listIterator(int)}.<p>
 *
 * The list-iterator is <i>fail-fast</i>: if the list is structurally
 * modified at any time after the Iterator is created, in any way except
 * through the list-iterator's own {@code remove} or {@code add}
 * methods, the list-iterator will throw a
 * {@code ConcurrentModificationException}.  Thus, in the face of
 * concurrent modification, the iterator fails quickly and cleanly, rather
 * than risking arbitrary, non-deterministic behavior at an undetermined
 * time in the future.
 *
 * @param index index of the first element to be returned from the
 *              list-iterator (by a call to {@code next})
 * @return a ListIterator of the elements in this list (in proper
 *         sequence), starting at the specified position in the list
 * @throws java.lang.IndexOutOfBoundsException {@inheritDoc}
 * @see java.util.List#listIterator(int)
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.util.ListIterator<E> listIterator(int index) { throw new RuntimeException("Stub!"); }

/**
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.NonNull
public java.util.Iterator<E> descendingIterator() { throw new RuntimeException("Stub!"); }

/**
 * Returns a shallow copy of this {@code LinkedList}. (The elements
 * themselves are not cloned.)
 *
 * @return a shallow copy of this {@code LinkedList} instance
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
 * @return an array containing all of the elements in this list
 *         in proper sequence
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
 * <p>If the list fits in the specified array with room to spare (i.e.,
 * the array has more elements than the list), the element in the array
 * immediately following the end of the list is set to {@code null}.
 * (This is useful in determining the length of the list <i>only</i> if
 * the caller knows that the list does not contain any null elements.)
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
 * <pre>
 *     String[] y = x.toArray(new String[0]);</pre>
 *
 * Note that {@code toArray(new Object[0])} is identical in function to
 * {@code toArray()}.
 *
 * @param a the array into which the elements of the list are to
 *          be stored, if it is big enough; otherwise, a new array of the
 *          same runtime type is allocated for this purpose.
 * @return an array containing the elements of the list
 * @throws java.lang.ArrayStoreException if the runtime type of the specified array
 *         is not a supertype of the runtime type of every element in
 *         this list
 * @throws java.lang.NullPointerException if the specified array is null
 * @apiSince 1
 */

@androidx.annotation.NonNull
public <T> T[] toArray(@androidx.annotation.NonNull T[] a) { throw new RuntimeException("Stub!"); }

/**
 * Creates a <em><a href="Spliterator.html#binding">late-binding</a></em>
 * and <em>fail-fast</em> {@link java.util.Spliterator Spliterator} over the elements in this
 * list.
 *
 * <p>The {@code Spliterator} reports {@link java.util.Spliterator#SIZED Spliterator#SIZED} and
 * {@link java.util.Spliterator#ORDERED Spliterator#ORDERED}.  Overriding implementations should document
 * the reporting of additional characteristic values.
 *
 * @implNote
 * The {@code Spliterator} additionally reports {@link java.util.Spliterator#SUBSIZED Spliterator#SUBSIZED}
 * and implements {@code trySplit} to permit limited parallelism..
 *
 * @return a {@code Spliterator} over the elements in this list
 * @since 1.8
 * @apiSince 24
 */

@androidx.annotation.NonNull
public java.util.Spliterator<E> spliterator() { throw new RuntimeException("Stub!"); }
}

