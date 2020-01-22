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
 * Written by Doug Lea and Martin Buchholz with assistance from members of
 * JCP JSR-166 Expert Group and released to the public domain, as explained
 * at http://creativecommons.org/publicdomain/zero/1.0/
 */



package java.util.concurrent;

import java.util.Iterator;
import java.util.Queue;
import java.util.Collection;
import java.util.Spliterator;

/**
 * An unbounded thread-safe {@linkplain java.util.Queue Queue} based on linked nodes.
 * This queue orders elements FIFO (first-in-first-out).
 * The <em>head</em> of the queue is that element that has been on the
 * queue the longest time.
 * The <em>tail</em> of the queue is that element that has been on the
 * queue the shortest time. New elements
 * are inserted at the tail of the queue, and the queue retrieval
 * operations obtain elements at the head of the queue.
 * A {@code ConcurrentLinkedQueue} is an appropriate choice when
 * many threads will share access to a common collection.
 * Like most other concurrent collection implementations, this class
 * does not permit the use of {@code null} elements.
 *
 * <p>This implementation employs an efficient <em>non-blocking</em>
 * algorithm based on one described in
 * <a href="http://www.cs.rochester.edu/~scott/papers/1996_PODC_queues.pdf">
 * Simple, Fast, and Practical Non-Blocking and Blocking Concurrent Queue
 * Algorithms</a> by Maged M. Michael and Michael L. Scott.
 *
 * <p>Iterators are <i>weakly consistent</i>, returning elements
 * reflecting the state of the queue at some point at or since the
 * creation of the iterator.  They do <em>not</em> throw {@link
 * java.util.ConcurrentModificationException}, and may proceed concurrently
 * with other operations.  Elements contained in the queue since the creation
 * of the iterator will be returned exactly once.
 *
 * <p>Beware that, unlike in most collections, the {@code size} method
 * is <em>NOT</em> a constant-time operation. Because of the
 * asynchronous nature of these queues, determining the current number
 * of elements requires a traversal of the elements, and so may report
 * inaccurate results if this collection is modified during traversal.
 * Additionally, the bulk operations {@code addAll},
 * {@code removeAll}, {@code retainAll}, {@code containsAll},
 * {@code equals}, and {@code toArray} are <em>not</em> guaranteed
 * to be performed atomically. For example, an iterator operating
 * concurrently with an {@code addAll} operation might view only some
 * of the added elements.
 *
 * <p>This class and its iterator implement all of the <em>optional</em>
 * methods of the {@link java.util.Queue Queue} and {@link java.util.Iterator Iterator} interfaces.
 *
 * <p>Memory consistency effects: As with other concurrent
 * collections, actions in a thread prior to placing an object into a
 * {@code ConcurrentLinkedQueue}
 * <a href="package-summary.html#MemoryVisibility"><i>happen-before</i></a>
 * actions subsequent to the access or removal of that element from
 * the {@code ConcurrentLinkedQueue} in another thread.
 *
 * @since 1.5
 * @author Doug Lea
 * @param <E> the type of elements held in this queue
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ConcurrentLinkedQueue<E> extends java.util.AbstractQueue<E> implements java.util.Queue<E>, java.io.Serializable {

/**
 * Creates a {@code ConcurrentLinkedQueue} that is initially empty.
 * @apiSince 1
 */

public ConcurrentLinkedQueue() { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code ConcurrentLinkedQueue}
 * initially containing the elements of the given collection,
 * added in traversal order of the collection's iterator.
 *
 * @param c the collection of elements to initially contain
 * @throws java.lang.NullPointerException if the specified collection or any
 *         of its elements are null
 * @apiSince 1
 */

public ConcurrentLinkedQueue(java.util.Collection<? extends E> c) { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified element at the tail of this queue.
 * As the queue is unbounded, this method will never throw
 * {@link java.lang.IllegalStateException IllegalStateException} or return {@code false}.
 *
 * @return {@code true} (as specified by {@link java.util.Collection#add Collection#add})
 * @throws java.lang.NullPointerException if the specified element is null
 * @apiSince 1
 */

public boolean add(E e) { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified element at the tail of this queue.
 * As the queue is unbounded, this method will never return {@code false}.
 *
 * @return {@code true} (as specified by {@link java.util.Queue#offer Queue#offer})
 * @throws java.lang.NullPointerException if the specified element is null
 * @apiSince 1
 */

public boolean offer(E e) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public E poll() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public E peek() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this queue contains no elements.
 *
 * @return {@code true} if this queue contains no elements
 * @apiSince 1
 */

public boolean isEmpty() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of elements in this queue.  If this queue
 * contains more than {@code Integer.MAX_VALUE} elements, returns
 * {@code Integer.MAX_VALUE}.
 *
 * <p>Beware that, unlike in most collections, this method is
 * <em>NOT</em> a constant-time operation. Because of the
 * asynchronous nature of these queues, determining the current
 * number of elements requires an O(n) traversal.
 * Additionally, if elements are added or removed during execution
 * of this method, the returned result may be inaccurate.  Thus,
 * this method is typically not very useful in concurrent
 * applications.
 *
 * @return the number of elements in this queue
 * @apiSince 1
 */

public int size() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this queue contains the specified element.
 * More formally, returns {@code true} if and only if this queue contains
 * at least one element {@code e} such that {@code o.equals(e)}.
 *
 * @param o object to be checked for containment in this queue
 * @return {@code true} if this queue contains the specified element
 * @apiSince 1
 */

public boolean contains(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Removes a single instance of the specified element from this queue,
 * if it is present.  More formally, removes an element {@code e} such
 * that {@code o.equals(e)}, if this queue contains one or more such
 * elements.
 * Returns {@code true} if this queue contained the specified element
 * (or equivalently, if this queue changed as a result of the call).
 *
 * @param o element to be removed from this queue, if present
 * @return {@code true} if this queue changed as a result of the call
 * @apiSince 1
 */

public boolean remove(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Appends all of the elements in the specified collection to the end of
 * this queue, in the order that they are returned by the specified
 * collection's iterator.  Attempts to {@code addAll} of a queue to
 * itself result in {@code IllegalArgumentException}.
 *
 * @param c the elements to be inserted into this queue
 * @return {@code true} if this queue changed as a result of the call
 * @throws java.lang.NullPointerException if the specified collection or any
 *         of its elements are null
 * @throws java.lang.IllegalArgumentException if the collection is this queue
 * @apiSince 1
 */

public boolean addAll(java.util.Collection<? extends E> c) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Returns an array containing all of the elements in this queue, in
 * proper sequence.
 *
 * <p>The returned array will be "safe" in that no references to it are
 * maintained by this queue.  (In other words, this method must allocate
 * a new array).  The caller is thus free to modify the returned array.
 *
 * <p>This method acts as bridge between array-based and collection-based
 * APIs.
 *
 * @return an array containing all of the elements in this queue
 * @apiSince 1
 */

public java.lang.Object[] toArray() { throw new RuntimeException("Stub!"); }

/**
 * Returns an array containing all of the elements in this queue, in
 * proper sequence; the runtime type of the returned array is that of
 * the specified array.  If the queue fits in the specified array, it
 * is returned therein.  Otherwise, a new array is allocated with the
 * runtime type of the specified array and the size of this queue.
 *
 * <p>If this queue fits in the specified array with room to spare
 * (i.e., the array has more elements than this queue), the element in
 * the array immediately following the end of the queue is set to
 * {@code null}.
 *
 * <p>Like the {@link #toArray()} method, this method acts as bridge between
 * array-based and collection-based APIs.  Further, this method allows
 * precise control over the runtime type of the output array, and may,
 * under certain circumstances, be used to save allocation costs.
 *
 * <p>Suppose {@code x} is a queue known to contain only strings.
 * The following code can be used to dump the queue into a newly
 * allocated array of {@code String}:
 *
 * <pre> {@code String[] y = x.toArray(new String[0]);}</pre>
 *
 * Note that {@code toArray(new Object[0])} is identical in function to
 * {@code toArray()}.
 *
 * @param a the array into which the elements of the queue are to
 *          be stored, if it is big enough; otherwise, a new array of the
 *          same runtime type is allocated for this purpose
 * @return an array containing all of the elements in this queue
 * @throws java.lang.ArrayStoreException if the runtime type of the specified array
 *         is not a supertype of the runtime type of every element in
 *         this queue
 * @throws java.lang.NullPointerException if the specified array is null
 * @apiSince 1
 */

public <T> T[] toArray(T[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns an iterator over the elements in this queue in proper sequence.
 * The elements will be returned in order from first (head) to last (tail).
 *
 * <p>The returned iterator is
 * <a href="package-summary.html#Weakly"><i>weakly consistent</i></a>.
 *
 * @return an iterator over the elements in this queue in proper sequence
 * @apiSince 1
 */

public java.util.Iterator<E> iterator() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link java.util.Spliterator Spliterator} over the elements in this queue.
 *
 * <p>The returned spliterator is
 * <a href="package-summary.html#Weakly"><i>weakly consistent</i></a>.
 *
 * <p>The {@code Spliterator} reports {@link java.util.Spliterator#CONCURRENT Spliterator#CONCURRENT},
 * {@link java.util.Spliterator#ORDERED Spliterator#ORDERED}, and {@link java.util.Spliterator#NONNULL Spliterator#NONNULL}.
 *
 * @implNote
 * The {@code Spliterator} implements {@code trySplit} to permit limited
 * parallelism.
 *
 * @return a {@code Spliterator} over the elements in this queue
 * @since 1.8
 * @apiSince 24
 */

public java.util.Spliterator<E> spliterator() { throw new RuntimeException("Stub!"); }
}

