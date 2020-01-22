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
 * Written by Doug Lea, Bill Scherer, and Michael Scott with
 * assistance from members of JCP JSR-166 Expert Group and released to
 * the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 */



package java.util.concurrent;

import java.util.Iterator;
import java.util.Collection;
import java.util.Spliterator;

/**
 * A {@linkplain java.util.concurrent.BlockingQueue BlockingQueue} in which each insert
 * operation must wait for a corresponding remove operation by another
 * thread, and vice versa.  A synchronous queue does not have any
 * internal capacity, not even a capacity of one.  You cannot
 * {@code peek} at a synchronous queue because an element is only
 * present when you try to remove it; you cannot insert an element
 * (using any method) unless another thread is trying to remove it;
 * you cannot iterate as there is nothing to iterate.  The
 * <em>head</em> of the queue is the element that the first queued
 * inserting thread is trying to add to the queue; if there is no such
 * queued thread then no element is available for removal and
 * {@code poll()} will return {@code null}.  For purposes of other
 * {@code Collection} methods (for example {@code contains}), a
 * {@code SynchronousQueue} acts as an empty collection.  This queue
 * does not permit {@code null} elements.
 *
 * <p>Synchronous queues are similar to rendezvous channels used in
 * CSP and Ada. They are well suited for handoff designs, in which an
 * object running in one thread must sync up with an object running
 * in another thread in order to hand it some information, event, or
 * task.
 *
 * <p>This class supports an optional fairness policy for ordering
 * waiting producer and consumer threads.  By default, this ordering
 * is not guaranteed. However, a queue constructed with fairness set
 * to {@code true} grants threads access in FIFO order.
 *
 * <p>This class and its iterator implement all of the
 * <em>optional</em> methods of the {@link java.util.Collection Collection} and {@link java.util.Iterator Iterator} interfaces.
 *
 * @since 1.5
 * @author Doug Lea and Bill Scherer and Michael Scott
 * @param <E> the type of elements held in this queue
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SynchronousQueue<E> extends java.util.AbstractQueue<E> implements java.util.concurrent.BlockingQueue<E>, java.io.Serializable {

/**
 * Creates a {@code SynchronousQueue} with nonfair access policy.
 * @apiSince 1
 */

public SynchronousQueue() { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code SynchronousQueue} with the specified fairness policy.
 *
 * @param fair if true, waiting threads contend in FIFO order for
 *        access; otherwise the order is unspecified.
 * @apiSince 1
 */

public SynchronousQueue(boolean fair) { throw new RuntimeException("Stub!"); }

/**
 * Adds the specified element to this queue, waiting if necessary for
 * another thread to receive it.
 *
 * @throws java.lang.InterruptedException {@inheritDoc}
 * @throws java.lang.NullPointerException {@inheritDoc}
 * @apiSince 1
 */

public void put(E e) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified element into this queue, waiting if necessary
 * up to the specified wait time for another thread to receive it.
 *
 * @return {@code true} if successful, or {@code false} if the
 *         specified waiting time elapses before a consumer appears
 * @throws java.lang.InterruptedException {@inheritDoc}
 * @throws java.lang.NullPointerException {@inheritDoc}
 * @apiSince 1
 */

public boolean offer(E e, long timeout, java.util.concurrent.TimeUnit unit) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified element into this queue, if another thread is
 * waiting to receive it.
 *
 * @param e the element to add
 * @return {@code true} if the element was added to this queue, else
 *         {@code false}
 * @throws java.lang.NullPointerException if the specified element is null
 * @apiSince 1
 */

public boolean offer(E e) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves and removes the head of this queue, waiting if necessary
 * for another thread to insert it.
 *
 * @return the head of this queue
 * @throws java.lang.InterruptedException {@inheritDoc}
 * @apiSince 1
 */

public E take() throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * Retrieves and removes the head of this queue, waiting
 * if necessary up to the specified wait time, for another thread
 * to insert it.
 *
 * @return the head of this queue, or {@code null} if the
 *         specified waiting time elapses before an element is present
 * @throws java.lang.InterruptedException {@inheritDoc}
 * @apiSince 1
 */

public E poll(long timeout, java.util.concurrent.TimeUnit unit) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * Retrieves and removes the head of this queue, if another thread
 * is currently making an element available.
 *
 * @return the head of this queue, or {@code null} if no
 *         element is available
 * @apiSince 1
 */

public E poll() { throw new RuntimeException("Stub!"); }

/**
 * Always returns {@code true}.
 * A {@code SynchronousQueue} has no internal capacity.
 *
 * @return {@code true}
 * @apiSince 1
 */

public boolean isEmpty() { throw new RuntimeException("Stub!"); }

/**
 * Always returns zero.
 * A {@code SynchronousQueue} has no internal capacity.
 *
 * @return zero
 * @apiSince 1
 */

public int size() { throw new RuntimeException("Stub!"); }

/**
 * Always returns zero.
 * A {@code SynchronousQueue} has no internal capacity.
 *
 * @return zero
 * @apiSince 1
 */

public int remainingCapacity() { throw new RuntimeException("Stub!"); }

/**
 * Does nothing.
 * A {@code SynchronousQueue} has no internal capacity.
 * @apiSince 1
 */

public void clear() { throw new RuntimeException("Stub!"); }

/**
 * Always returns {@code false}.
 * A {@code SynchronousQueue} has no internal capacity.
 *
 * @param o the element
 * @return {@code false}
 * @apiSince 1
 */

public boolean contains(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Always returns {@code false}.
 * A {@code SynchronousQueue} has no internal capacity.
 *
 * @param o the element to remove
 * @return {@code false}
 * @apiSince 1
 */

public boolean remove(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code false} unless the given collection is empty.
 * A {@code SynchronousQueue} has no internal capacity.
 *
 * @param c the collection
 * @return {@code false} unless given collection is empty
 * @apiSince 1
 */

public boolean containsAll(java.util.Collection<?> c) { throw new RuntimeException("Stub!"); }

/**
 * Always returns {@code false}.
 * A {@code SynchronousQueue} has no internal capacity.
 *
 * @param c the collection
 * @return {@code false}
 * @apiSince 1
 */

public boolean removeAll(java.util.Collection<?> c) { throw new RuntimeException("Stub!"); }

/**
 * Always returns {@code false}.
 * A {@code SynchronousQueue} has no internal capacity.
 *
 * @param c the collection
 * @return {@code false}
 * @apiSince 1
 */

public boolean retainAll(java.util.Collection<?> c) { throw new RuntimeException("Stub!"); }

/**
 * Always returns {@code null}.
 * A {@code SynchronousQueue} does not return elements
 * unless actively waited on.
 *
 * @return {@code null}
 * @apiSince 1
 */

public E peek() { throw new RuntimeException("Stub!"); }

/**
 * Returns an empty iterator in which {@code hasNext} always returns
 * {@code false}.
 *
 * @return an empty iterator
 * @apiSince 1
 */

public java.util.Iterator<E> iterator() { throw new RuntimeException("Stub!"); }

/**
 * Returns an empty spliterator in which calls to
 * {@link java.util.Spliterator#trySplit()} always return {@code null}.
 *
 * @return an empty spliterator
 * @since 1.8
 * @apiSince 24
 */

public java.util.Spliterator<E> spliterator() { throw new RuntimeException("Stub!"); }

/**
 * Returns a zero-length array.
 * @return a zero-length array
 * @apiSince 1
 */

public java.lang.Object[] toArray() { throw new RuntimeException("Stub!"); }

/**
 * Sets the zeroth element of the specified array to {@code null}
 * (if the array has non-zero length) and returns it.
 *
 * @param a the array
 * @return the specified array
 * @throws java.lang.NullPointerException if the specified array is null
 * @apiSince 1
 */

public <T> T[] toArray(T[] a) { throw new RuntimeException("Stub!"); }

/**
 * Always returns {@code "[]"}.
 * @return {@code "[]"}
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

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
}

