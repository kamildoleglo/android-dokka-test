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
import java.util.Collection;
import java.util.Spliterator;

/**
 * An optionally-bounded {@linkplain java.util.concurrent.BlockingQueue BlockingQueue} based on
 * linked nodes.
 * This queue orders elements FIFO (first-in-first-out).
 * The <em>head</em> of the queue is that element that has been on the
 * queue the longest time.
 * The <em>tail</em> of the queue is that element that has been on the
 * queue the shortest time. New elements
 * are inserted at the tail of the queue, and the queue retrieval
 * operations obtain elements at the head of the queue.
 * Linked queues typically have higher throughput than array-based queues but
 * less predictable performance in most concurrent applications.
 *
 * <p>The optional capacity bound constructor argument serves as a
 * way to prevent excessive queue expansion. The capacity, if unspecified,
 * is equal to {@link java.lang.Integer#MAX_VALUE Integer#MAX_VALUE}.  Linked nodes are
 * dynamically created upon each insertion unless this would bring the
 * queue above capacity.
 *
 * <p>This class and its iterator implement all of the
 * <em>optional</em> methods of the {@link java.util.Collection Collection} and {@link java.util.Iterator Iterator} interfaces.
 *
 * @since 1.5
 * @author Doug Lea
 * @param <E> the type of elements held in this queue
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class LinkedBlockingQueue<E> extends java.util.AbstractQueue<E> implements java.util.concurrent.BlockingQueue<E>, java.io.Serializable {

/**
 * Creates a {@code LinkedBlockingQueue} with a capacity of
 * {@link java.lang.Integer#MAX_VALUE Integer#MAX_VALUE}.
 * @apiSince 1
 */

public LinkedBlockingQueue() { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code LinkedBlockingQueue} with the given (fixed) capacity.
 *
 * @param capacity the capacity of this queue
 * @throws java.lang.IllegalArgumentException if {@code capacity} is not greater
 *         than zero
 * @apiSince 1
 */

public LinkedBlockingQueue(int capacity) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code LinkedBlockingQueue} with a capacity of
 * {@link java.lang.Integer#MAX_VALUE Integer#MAX_VALUE}, initially containing the elements of the
 * given collection,
 * added in traversal order of the collection's iterator.
 *
 * @param c the collection of elements to initially contain
 * @throws java.lang.NullPointerException if the specified collection or any
 *         of its elements are null
 * @apiSince 1
 */

public LinkedBlockingQueue(java.util.Collection<? extends E> c) { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of elements in this queue.
 *
 * @return the number of elements in this queue
 * @apiSince 1
 */

public int size() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of additional elements that this queue can ideally
 * (in the absence of memory or resource constraints) accept without
 * blocking. This is always equal to the initial capacity of this queue
 * less the current {@code size} of this queue.
 *
 * <p>Note that you <em>cannot</em> always tell if an attempt to insert
 * an element will succeed by inspecting {@code remainingCapacity}
 * because it may be the case that another thread is about to
 * insert or remove an element.
 * @apiSince 1
 */

public int remainingCapacity() { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified element at the tail of this queue, waiting if
 * necessary for space to become available.
 *
 * @throws java.lang.InterruptedException {@inheritDoc}
 * @throws java.lang.NullPointerException {@inheritDoc}
 * @apiSince 1
 */

public void put(E e) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified element at the tail of this queue, waiting if
 * necessary up to the specified wait time for space to become available.
 *
 * @return {@code true} if successful, or {@code false} if
 *         the specified waiting time elapses before space is available
 * @throws java.lang.InterruptedException {@inheritDoc}
 * @throws java.lang.NullPointerException {@inheritDoc}
 * @apiSince 1
 */

public boolean offer(E e, long timeout, java.util.concurrent.TimeUnit unit) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified element at the tail of this queue if it is
 * possible to do so immediately without exceeding the queue's capacity,
 * returning {@code true} upon success and {@code false} if this queue
 * is full.
 * When using a capacity-restricted queue, this method is generally
 * preferable to method {@link java.util.concurrent.BlockingQueue#add BlockingQueue#add}, which can fail to
 * insert an element only by throwing an exception.
 *
 * @throws java.lang.NullPointerException if the specified element is null
 * @apiSince 1
 */

public boolean offer(E e) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public E take() throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public E poll(long timeout, java.util.concurrent.TimeUnit unit) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public E poll() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public E peek() { throw new RuntimeException("Stub!"); }

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

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Atomically removes all of the elements from this queue.
 * The queue will be empty after this call returns.
 * @apiSince 1
 */

public void clear() { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.UnsupportedOperationException {@inheritDoc}
 * @throws java.lang.ClassCastException            {@inheritDoc}
 * @throws java.lang.NullPointerException          {@inheritDoc}
 * @throws java.lang.IllegalArgumentException      {@inheritDoc}
 * @apiSince 1
 */

public int drainTo(java.util.Collection<? super E> c) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.UnsupportedOperationException {@inheritDoc}
 * @throws java.lang.ClassCastException            {@inheritDoc}
 * @throws java.lang.NullPointerException          {@inheritDoc}
 * @throws java.lang.IllegalArgumentException      {@inheritDoc}
 * @apiSince 1
 */

public int drainTo(java.util.Collection<? super E> c, int maxElements) { throw new RuntimeException("Stub!"); }

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

