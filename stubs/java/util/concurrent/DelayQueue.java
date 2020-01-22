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

/**
 * An unbounded {@linkplain java.util.concurrent.BlockingQueue BlockingQueue} of
 * {@code Delayed} elements, in which an element can only be taken
 * when its delay has expired.  The <em>head</em> of the queue is that
 * {@code Delayed} element whose delay expired furthest in the
 * past.  If no delay has expired there is no head and {@code poll}
 * will return {@code null}. Expiration occurs when an element's
 * {@code getDelay(TimeUnit.NANOSECONDS)} method returns a value less
 * than or equal to zero.  Even though unexpired elements cannot be
 * removed using {@code take} or {@code poll}, they are otherwise
 * treated as normal elements. For example, the {@code size} method
 * returns the count of both expired and unexpired elements.
 * This queue does not permit null elements.
 *
 * <p>This class and its iterator implement all of the
 * <em>optional</em> methods of the {@link java.util.Collection Collection} and {@link java.util.Iterator Iterator} interfaces.  The Iterator provided in method {@link
 * #iterator()} is <em>not</em> guaranteed to traverse the elements of
 * the DelayQueue in any particular order.
 *
 * @since 1.5
 * @author Doug Lea
 * @param <E> the type of elements held in this queue
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DelayQueue<E extends java.util.concurrent.Delayed> extends java.util.AbstractQueue<E> implements java.util.concurrent.BlockingQueue<E> {

/**
 * Creates a new {@code DelayQueue} that is initially empty.
 * @apiSince 1
 */

public DelayQueue() { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code DelayQueue} initially containing the elements of the
 * given collection of {@link java.util.concurrent.Delayed Delayed} instances.
 *
 * @param c the collection of elements to initially contain
 * @throws java.lang.NullPointerException if the specified collection or any
 *         of its elements are null
 * @apiSince 1
 */

public DelayQueue(java.util.Collection<? extends E> c) { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified element into this delay queue.
 *
 * @param e the element to add
 * @return {@code true} (as specified by {@link java.util.Collection#add Collection#add})
 * @throws java.lang.NullPointerException if the specified element is null
 * @apiSince 1
 */

public boolean add(E e) { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified element into this delay queue.
 *
 * @param e the element to add
 * @return {@code true}
 * @throws java.lang.NullPointerException if the specified element is null
 * @apiSince 1
 */

public boolean offer(E e) { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified element into this delay queue. As the queue is
 * unbounded this method will never block.
 *
 * @param e the element to add
 * @throws java.lang.NullPointerException {@inheritDoc}
 * @apiSince 1
 */

public void put(E e) { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified element into this delay queue. As the queue is
 * unbounded this method will never block.
 *
 * @param e the element to add
 * @param timeout This parameter is ignored as the method never blocks
 * @param unit This parameter is ignored as the method never blocks
 * @return {@code true}
 * @throws java.lang.NullPointerException {@inheritDoc}
 * @apiSince 1
 */

public boolean offer(E e, long timeout, java.util.concurrent.TimeUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves and removes the head of this queue, or returns {@code null}
 * if this queue has no elements with an expired delay.
 *
 * @return the head of this queue, or {@code null} if this
 *         queue has no elements with an expired delay
 * @apiSince 1
 */

public E poll() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves and removes the head of this queue, waiting if necessary
 * until an element with an expired delay is available on this queue.
 *
 * @return the head of this queue
 * @throws java.lang.InterruptedException {@inheritDoc}
 * @apiSince 1
 */

public E take() throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * Retrieves and removes the head of this queue, waiting if necessary
 * until an element with an expired delay is available on this queue,
 * or the specified wait time expires.
 *
 * @return the head of this queue, or {@code null} if the
 *         specified waiting time elapses before an element with
 *         an expired delay becomes available
 * @throws java.lang.InterruptedException {@inheritDoc}
 * @apiSince 1
 */

public E poll(long timeout, java.util.concurrent.TimeUnit unit) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * Retrieves, but does not remove, the head of this queue, or
 * returns {@code null} if this queue is empty.  Unlike
 * {@code poll}, if no expired elements are available in the queue,
 * this method returns the element that will expire next,
 * if one exists.
 *
 * @return the head of this queue, or {@code null} if this
 *         queue is empty
 * @apiSince 1
 */

public E peek() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int size() { throw new RuntimeException("Stub!"); }

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
 * Atomically removes all of the elements from this delay queue.
 * The queue will be empty after this call returns.
 * Elements with an unexpired delay are not waited for; they are
 * simply discarded from the queue.
 * @apiSince 1
 */

public void clear() { throw new RuntimeException("Stub!"); }

/**
 * Always returns {@code Integer.MAX_VALUE} because
 * a {@code DelayQueue} is not capacity constrained.
 *
 * @return {@code Integer.MAX_VALUE}
 * @apiSince 1
 */

public int remainingCapacity() { throw new RuntimeException("Stub!"); }

/**
 * Returns an array containing all of the elements in this queue.
 * The returned array elements are in no particular order.
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
 * Returns an array containing all of the elements in this queue; the
 * runtime type of the returned array is that of the specified array.
 * The returned array elements are in no particular order.
 * If the queue fits in the specified array, it is returned therein.
 * Otherwise, a new array is allocated with the runtime type of the
 * specified array and the size of this queue.
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
 * <p>The following code can be used to dump a delay queue into a newly
 * allocated array of {@code Delayed}:
 *
 * <pre> {@code Delayed[] a = q.toArray(new Delayed[0]);}</pre>
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
 * Removes a single instance of the specified element from this
 * queue, if it is present, whether or not it has expired.
 * @apiSince 1
 */

public boolean remove(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Returns an iterator over all the elements (both expired and
 * unexpired) in this queue. The iterator does not return the
 * elements in any particular order.
 *
 * <p>The returned iterator is
 * <a href="package-summary.html#Weakly"><i>weakly consistent</i></a>.
 *
 * @return an iterator over the elements in this queue
 * @apiSince 1
 */

public java.util.Iterator<E> iterator() { throw new RuntimeException("Stub!"); }
}

