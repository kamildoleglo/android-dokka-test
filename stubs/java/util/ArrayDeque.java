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
 * Written by Josh Bloch of Google Inc. and released to the public domain,
 * as explained at http://creativecommons.org/publicdomain/zero/1.0/.
 */



package java.util;


/**
 * Resizable-array implementation of the {@link java.util.Deque Deque} interface.  Array
 * deques have no capacity restrictions; they grow as necessary to support
 * usage.  They are not thread-safe; in the absence of external
 * synchronization, they do not support concurrent access by multiple threads.
 * Null elements are prohibited.  This class is likely to be faster than
 * {@link java.util.Stack Stack} when used as a stack, and faster than {@link java.util.LinkedList LinkedList}
 * when used as a queue.
 *
 * <p>Most {@code ArrayDeque} operations run in amortized constant time.
 * Exceptions include
 * {@link #remove(java.lang.Object) remove},
 * {@link #removeFirstOccurrence removeFirstOccurrence},
 * {@link #removeLastOccurrence removeLastOccurrence},
 * {@link #contains contains},
 * {@link #iterator iterator.remove()},
 * and the bulk operations, all of which run in linear time.
 *
 * <p>The iterators returned by this class's {@link #iterator() iterator}
 * method are <em>fail-fast</em>: If the deque is modified at any time after
 * the iterator is created, in any way except through the iterator's own
 * {@code remove} method, the iterator will generally throw a {@link java.util.ConcurrentModificationException ConcurrentModificationException}.  Thus, in the face of concurrent
 * modification, the iterator fails quickly and cleanly, rather than risking
 * arbitrary, non-deterministic behavior at an undetermined time in the
 * future.
 *
 * <p>Note that the fail-fast behavior of an iterator cannot be guaranteed
 * as it is, generally speaking, impossible to make any hard guarantees in the
 * presence of unsynchronized concurrent modification.  Fail-fast iterators
 * throw {@code ConcurrentModificationException} on a best-effort basis.
 * Therefore, it would be wrong to write a program that depended on this
 * exception for its correctness: <i>the fail-fast behavior of iterators
 * should be used only to detect bugs.</i>
 *
 * <p>This class and its iterator implement all of the
 * <em>optional</em> methods of the {@link java.util.Collection Collection} and {@link java.util.Iterator Iterator} interfaces.
 *
 * @author  Josh Bloch and Doug Lea
 * @since   1.6
 * @param <E> the type of elements held in this deque
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ArrayDeque<E> extends java.util.AbstractCollection<E> implements java.util.Deque<E>, java.lang.Cloneable, java.io.Serializable {

/**
 * Constructs an empty array deque with an initial capacity
 * sufficient to hold 16 elements.
 * @apiSince 9
 */

public ArrayDeque() { throw new RuntimeException("Stub!"); }

/**
 * Constructs an empty array deque with an initial capacity
 * sufficient to hold the specified number of elements.
 *
 * @param numElements  lower bound on initial capacity of the deque
 * @apiSince 9
 */

public ArrayDeque(int numElements) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a deque containing the elements of the specified
 * collection, in the order they are returned by the collection's
 * iterator.  (The first element returned by the collection's
 * iterator becomes the first element, or <i>front</i> of the
 * deque.)
 *
 * @param c the collection whose elements are to be placed into the deque
 * @throws java.lang.NullPointerException if the specified collection is null
 * @apiSince 9
 */

public ArrayDeque(@androidx.annotation.NonNull java.util.Collection<? extends E> c) { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified element at the front of this deque.
 *
 * @param e the element to add
 * @throws java.lang.NullPointerException if the specified element is null
 * @apiSince 9
 */

public void addFirst(E e) { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified element at the end of this deque.
 *
 * <p>This method is equivalent to {@link #add}.
 *
 * @param e the element to add
 * @throws java.lang.NullPointerException if the specified element is null
 * @apiSince 9
 */

public void addLast(E e) { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified element at the front of this deque.
 *
 * @param e the element to add
 * @return {@code true} (as specified by {@link java.util.Deque#offerFirst Deque#offerFirst})
 * @throws java.lang.NullPointerException if the specified element is null
 * @apiSince 9
 */

public boolean offerFirst(E e) { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified element at the end of this deque.
 *
 * @param e the element to add
 * @return {@code true} (as specified by {@link java.util.Deque#offerLast Deque#offerLast})
 * @throws java.lang.NullPointerException if the specified element is null
 * @apiSince 9
 */

public boolean offerLast(E e) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.util.NoSuchElementException {@inheritDoc}
 * @apiSince 9
 */

public E removeFirst() { throw new RuntimeException("Stub!"); }

/**
 * @throws java.util.NoSuchElementException {@inheritDoc}
 * @apiSince 9
 */

public E removeLast() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

@androidx.annotation.Nullable
public E pollFirst() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

@androidx.annotation.Nullable
public E pollLast() { throw new RuntimeException("Stub!"); }

/**
 * @throws java.util.NoSuchElementException {@inheritDoc}
 * @apiSince 9
 */

public E getFirst() { throw new RuntimeException("Stub!"); }

/**
 * @throws java.util.NoSuchElementException {@inheritDoc}
 * @apiSince 9
 */

public E getLast() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

@androidx.annotation.Nullable
public E peekFirst() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

@androidx.annotation.Nullable
public E peekLast() { throw new RuntimeException("Stub!"); }

/**
 * Removes the first occurrence of the specified element in this
 * deque (when traversing the deque from head to tail).
 * If the deque does not contain the element, it is unchanged.
 * More formally, removes the first element {@code e} such that
 * {@code o.equals(e)} (if such an element exists).
 * Returns {@code true} if this deque contained the specified element
 * (or equivalently, if this deque changed as a result of the call).
 *
 * @param o element to be removed from this deque, if present
 * @return {@code true} if the deque contained the specified element
 * @apiSince 9
 */

public boolean removeFirstOccurrence(@androidx.annotation.Nullable java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Removes the last occurrence of the specified element in this
 * deque (when traversing the deque from head to tail).
 * If the deque does not contain the element, it is unchanged.
 * More formally, removes the last element {@code e} such that
 * {@code o.equals(e)} (if such an element exists).
 * Returns {@code true} if this deque contained the specified element
 * (or equivalently, if this deque changed as a result of the call).
 *
 * @param o element to be removed from this deque, if present
 * @return {@code true} if the deque contained the specified element
 * @apiSince 9
 */

public boolean removeLastOccurrence(@androidx.annotation.Nullable java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified element at the end of this deque.
 *
 * <p>This method is equivalent to {@link #addLast}.
 *
 * @param e the element to add
 * @return {@code true} (as specified by {@link java.util.Collection#add Collection#add})
 * @throws java.lang.NullPointerException if the specified element is null
 * @apiSince 9
 */

public boolean add(E e) { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified element at the end of this deque.
 *
 * <p>This method is equivalent to {@link #offerLast}.
 *
 * @param e the element to add
 * @return {@code true} (as specified by {@link java.util.Queue#offer Queue#offer})
 * @throws java.lang.NullPointerException if the specified element is null
 * @apiSince 9
 */

public boolean offer(E e) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves and removes the head of the queue represented by this deque.
 *
 * This method differs from {@link #poll poll} only in that it throws an
 * exception if this deque is empty.
 *
 * <p>This method is equivalent to {@link #removeFirst}.
 *
 * @return the head of the queue represented by this deque
 * @throws java.util.NoSuchElementException {@inheritDoc}
 * @apiSince 9
 */

public E remove() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves and removes the head of the queue represented by this deque
 * (in other words, the first element of this deque), or returns
 * {@code null} if this deque is empty.
 *
 * <p>This method is equivalent to {@link #pollFirst}.
 *
 * @return the head of the queue represented by this deque, or
 *         {@code null} if this deque is empty
 * @apiSince 9
 */

@androidx.annotation.Nullable
public E poll() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves, but does not remove, the head of the queue represented by
 * this deque.  This method differs from {@link #peek peek} only in
 * that it throws an exception if this deque is empty.
 *
 * <p>This method is equivalent to {@link #getFirst}.
 *
 * @return the head of the queue represented by this deque
 * @throws java.util.NoSuchElementException {@inheritDoc}
 * @apiSince 9
 */

public E element() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves, but does not remove, the head of the queue represented by
 * this deque, or returns {@code null} if this deque is empty.
 *
 * <p>This method is equivalent to {@link #peekFirst}.
 *
 * @return the head of the queue represented by this deque, or
 *         {@code null} if this deque is empty
 * @apiSince 9
 */

@androidx.annotation.Nullable
public E peek() { throw new RuntimeException("Stub!"); }

/**
 * Pushes an element onto the stack represented by this deque.  In other
 * words, inserts the element at the front of this deque.
 *
 * <p>This method is equivalent to {@link #addFirst}.
 *
 * @param e the element to push
 * @throws java.lang.NullPointerException if the specified element is null
 * @apiSince 9
 */

public void push(E e) { throw new RuntimeException("Stub!"); }

/**
 * Pops an element from the stack represented by this deque.  In other
 * words, removes and returns the first element of this deque.
 *
 * <p>This method is equivalent to {@link #removeFirst()}.
 *
 * @return the element at the front of this deque (which is the top
 *         of the stack represented by this deque)
 * @throws java.util.NoSuchElementException {@inheritDoc}
 * @apiSince 9
 */

public E pop() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of elements in this deque.
 *
 * @return the number of elements in this deque
 * @apiSince 9
 */

public int size() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this deque contains no elements.
 *
 * @return {@code true} if this deque contains no elements
 * @apiSince 9
 */

public boolean isEmpty() { throw new RuntimeException("Stub!"); }

/**
 * Returns an iterator over the elements in this deque.  The elements
 * will be ordered from first (head) to last (tail).  This is the same
 * order that elements would be dequeued (via successive calls to
 * {@link #remove} or popped (via successive calls to {@link #pop}).
 *
 * @return an iterator over the elements in this deque
 * @apiSince 9
 */

@androidx.annotation.NonNull
public java.util.Iterator<E> iterator() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

@androidx.annotation.NonNull
public java.util.Iterator<E> descendingIterator() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this deque contains the specified element.
 * More formally, returns {@code true} if and only if this deque contains
 * at least one element {@code e} such that {@code o.equals(e)}.
 *
 * @param o object to be checked for containment in this deque
 * @return {@code true} if this deque contains the specified element
 * @apiSince 9
 */

public boolean contains(@androidx.annotation.Nullable java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Removes a single instance of the specified element from this deque.
 * If the deque does not contain the element, it is unchanged.
 * More formally, removes the first element {@code e} such that
 * {@code o.equals(e)} (if such an element exists).
 * Returns {@code true} if this deque contained the specified element
 * (or equivalently, if this deque changed as a result of the call).
 *
 * <p>This method is equivalent to {@link #removeFirstOccurrence(java.lang.Object)}.
 *
 * @param o element to be removed from this deque, if present
 * @return {@code true} if this deque contained the specified element
 * @apiSince 9
 */

public boolean remove(@androidx.annotation.Nullable java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Removes all of the elements from this deque.
 * The deque will be empty after this call returns.
 * @apiSince 9
 */

public void clear() { throw new RuntimeException("Stub!"); }

/**
 * Returns an array containing all of the elements in this deque
 * in proper sequence (from first to last element).
 *
 * <p>The returned array will be "safe" in that no references to it are
 * maintained by this deque.  (In other words, this method must allocate
 * a new array).  The caller is thus free to modify the returned array.
 *
 * <p>This method acts as bridge between array-based and collection-based
 * APIs.
 *
 * @return an array containing all of the elements in this deque
 * @apiSince 9
 */

@androidx.annotation.NonNull
public java.lang.Object[] toArray() { throw new RuntimeException("Stub!"); }

/**
 * Returns an array containing all of the elements in this deque in
 * proper sequence (from first to last element); the runtime type of the
 * returned array is that of the specified array.  If the deque fits in
 * the specified array, it is returned therein.  Otherwise, a new array
 * is allocated with the runtime type of the specified array and the
 * size of this deque.
 *
 * <p>If this deque fits in the specified array with room to spare
 * (i.e., the array has more elements than this deque), the element in
 * the array immediately following the end of the deque is set to
 * {@code null}.
 *
 * <p>Like the {@link #toArray()} method, this method acts as bridge between
 * array-based and collection-based APIs.  Further, this method allows
 * precise control over the runtime type of the output array, and may,
 * under certain circumstances, be used to save allocation costs.
 *
 * <p>Suppose {@code x} is a deque known to contain only strings.
 * The following code can be used to dump the deque into a newly
 * allocated array of {@code String}:
 *
 * <pre> {@code String[] y = x.toArray(new String[0]);}</pre>
 *
 * Note that {@code toArray(new Object[0])} is identical in function to
 * {@code toArray()}.
 *
 * @param a the array into which the elements of the deque are to
 *          be stored, if it is big enough; otherwise, a new array of the
 *          same runtime type is allocated for this purpose
 * @return an array containing all of the elements in this deque
 * @throws java.lang.ArrayStoreException if the runtime type of the specified array
 *         is not a supertype of the runtime type of every element in
 *         this deque
 * @throws java.lang.NullPointerException if the specified array is null
 * @apiSince 9
 */

@androidx.annotation.NonNull
public <T> T[] toArray(@androidx.annotation.NonNull T[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this deque.
 *
 * @return a copy of this deque
 * @apiSince 9
 */

@androidx.annotation.NonNull
public java.util.ArrayDeque<E> clone() { throw new RuntimeException("Stub!"); }

/**
 * Creates a <em><a href="Spliterator.html#binding">late-binding</a></em>
 * and <em>fail-fast</em> {@link java.util.Spliterator Spliterator} over the elements in this
 * deque.
 *
 * <p>The {@code Spliterator} reports {@link java.util.Spliterator#SIZED Spliterator#SIZED},
 * {@link java.util.Spliterator#SUBSIZED Spliterator#SUBSIZED}, {@link java.util.Spliterator#ORDERED Spliterator#ORDERED}, and
 * {@link java.util.Spliterator#NONNULL Spliterator#NONNULL}.  Overriding implementations should document
 * the reporting of additional characteristic values.
 *
 * @return a {@code Spliterator} over the elements in this deque
 * @since 1.8
 * @apiSince 24
 */

@androidx.annotation.NonNull
public java.util.Spliterator<E> spliterator() { throw new RuntimeException("Stub!"); }
}

