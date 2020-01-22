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

import java.util.Deque;
import java.util.NoSuchElementException;

/**
 * A {@link java.util.Deque Deque} that additionally supports blocking operations that wait
 * for the deque to become non-empty when retrieving an element, and wait for
 * space to become available in the deque when storing an element.
 *
 * <p>{@code BlockingDeque} methods come in four forms, with different ways
 * of handling operations that cannot be satisfied immediately, but may be
 * satisfied at some point in the future:
 * one throws an exception, the second returns a special value (either
 * {@code null} or {@code false}, depending on the operation), the third
 * blocks the current thread indefinitely until the operation can succeed,
 * and the fourth blocks for only a given maximum time limit before giving
 * up.  These methods are summarized in the following table:
 *
 * <table BORDER CELLPADDING=3 CELLSPACING=1>
 * <caption>Summary of BlockingDeque methods</caption>
 *  <tr>
 *    <td ALIGN=CENTER COLSPAN = 5> <b>First Element (Head)</b></td>
 *  </tr>
 *  <tr>
 *    <td></td>
 *    <td ALIGN=CENTER><em>Throws exception</em></td>
 *    <td ALIGN=CENTER><em>Special value</em></td>
 *    <td ALIGN=CENTER><em>Blocks</em></td>
 *    <td ALIGN=CENTER><em>Times out</em></td>
 *  </tr>
 *  <tr>
 *    <td><b>Insert</b></td>
 *    <td>{@link #addFirst addFirst(e)}</td>
 *    <td>{@link #offerFirst(java.lang.Object) offerFirst(e)}</td>
 *    <td>{@link #putFirst putFirst(e)}</td>
 *    <td>{@link #offerFirst(java.lang.Object,long,java.util.concurrent.TimeUnit) offerFirst(e, time, unit)}</td>
 *  </tr>
 *  <tr>
 *    <td><b>Remove</b></td>
 *    <td>{@link #removeFirst removeFirst()}</td>
 *    <td>{@link #pollFirst pollFirst()}</td>
 *    <td>{@link #takeFirst takeFirst()}</td>
 *    <td>{@link #pollFirst(long,java.util.concurrent.TimeUnit) pollFirst(time, unit)}</td>
 *  </tr>
 *  <tr>
 *    <td><b>Examine</b></td>
 *    <td>{@link #getFirst getFirst()}</td>
 *    <td>{@link #peekFirst peekFirst()}</td>
 *    <td><em>not applicable</em></td>
 *    <td><em>not applicable</em></td>
 *  </tr>
 *  <tr>
 *    <td ALIGN=CENTER COLSPAN = 5> <b>Last Element (Tail)</b></td>
 *  </tr>
 *  <tr>
 *    <td></td>
 *    <td ALIGN=CENTER><em>Throws exception</em></td>
 *    <td ALIGN=CENTER><em>Special value</em></td>
 *    <td ALIGN=CENTER><em>Blocks</em></td>
 *    <td ALIGN=CENTER><em>Times out</em></td>
 *  </tr>
 *  <tr>
 *    <td><b>Insert</b></td>
 *    <td>{@link #addLast addLast(e)}</td>
 *    <td>{@link #offerLast(java.lang.Object) offerLast(e)}</td>
 *    <td>{@link #putLast putLast(e)}</td>
 *    <td>{@link #offerLast(java.lang.Object,long,java.util.concurrent.TimeUnit) offerLast(e, time, unit)}</td>
 *  </tr>
 *  <tr>
 *    <td><b>Remove</b></td>
 *    <td>{@link #removeLast() removeLast()}</td>
 *    <td>{@link #pollLast() pollLast()}</td>
 *    <td>{@link #takeLast takeLast()}</td>
 *    <td>{@link #pollLast(long,java.util.concurrent.TimeUnit) pollLast(time, unit)}</td>
 *  </tr>
 *  <tr>
 *    <td><b>Examine</b></td>
 *    <td>{@link #getLast getLast()}</td>
 *    <td>{@link #peekLast peekLast()}</td>
 *    <td><em>not applicable</em></td>
 *    <td><em>not applicable</em></td>
 *  </tr>
 * </table>
 *
 * <p>Like any {@link java.util.concurrent.BlockingQueue BlockingQueue}, a {@code BlockingDeque} is thread safe,
 * does not permit null elements, and may (or may not) be
 * capacity-constrained.
 *
 * <p>A {@code BlockingDeque} implementation may be used directly as a FIFO
 * {@code BlockingQueue}. The methods inherited from the
 * {@code BlockingQueue} interface are precisely equivalent to
 * {@code BlockingDeque} methods as indicated in the following table:
 *
 * <table BORDER CELLPADDING=3 CELLSPACING=1>
 * <caption>Comparison of BlockingQueue and BlockingDeque methods</caption>
 *  <tr>
 *    <td ALIGN=CENTER> <b>{@code BlockingQueue} Method</b></td>
 *    <td ALIGN=CENTER> <b>Equivalent {@code BlockingDeque} Method</b></td>
 *  </tr>
 *  <tr>
 *    <td ALIGN=CENTER COLSPAN = 2> <b>Insert</b></td>
 *  </tr>
 *  <tr>
 *    <td>{@link #add(java.lang.Object) add(e)}</td>
 *    <td>{@link #addLast(java.lang.Object) addLast(e)}</td>
 *  </tr>
 *  <tr>
 *    <td>{@link #offer(java.lang.Object) offer(e)}</td>
 *    <td>{@link #offerLast(java.lang.Object) offerLast(e)}</td>
 *  </tr>
 *  <tr>
 *    <td>{@link #put(java.lang.Object) put(e)}</td>
 *    <td>{@link #putLast(java.lang.Object) putLast(e)}</td>
 *  </tr>
 *  <tr>
 *    <td>{@link #offer(java.lang.Object,long,java.util.concurrent.TimeUnit) offer(e, time, unit)}</td>
 *    <td>{@link #offerLast(java.lang.Object,long,java.util.concurrent.TimeUnit) offerLast(e, time, unit)}</td>
 *  </tr>
 *  <tr>
 *    <td ALIGN=CENTER COLSPAN = 2> <b>Remove</b></td>
 *  </tr>
 *  <tr>
 *    <td>{@link #remove() remove()}</td>
 *    <td>{@link #removeFirst() removeFirst()}</td>
 *  </tr>
 *  <tr>
 *    <td>{@link #poll() poll()}</td>
 *    <td>{@link #pollFirst() pollFirst()}</td>
 *  </tr>
 *  <tr>
 *    <td>{@link #take() take()}</td>
 *    <td>{@link #takeFirst() takeFirst()}</td>
 *  </tr>
 *  <tr>
 *    <td>{@link #poll(long,java.util.concurrent.TimeUnit) poll(time, unit)}</td>
 *    <td>{@link #pollFirst(long,java.util.concurrent.TimeUnit) pollFirst(time, unit)}</td>
 *  </tr>
 *  <tr>
 *    <td ALIGN=CENTER COLSPAN = 2> <b>Examine</b></td>
 *  </tr>
 *  <tr>
 *    <td>{@link #element() element()}</td>
 *    <td>{@link #getFirst() getFirst()}</td>
 *  </tr>
 *  <tr>
 *    <td>{@link #peek() peek()}</td>
 *    <td>{@link #peekFirst() peekFirst()}</td>
 *  </tr>
 * </table>
 *
 * <p>Memory consistency effects: As with other concurrent
 * collections, actions in a thread prior to placing an object into a
 * {@code BlockingDeque}
 * <a href="package-summary.html#MemoryVisibility"><i>happen-before</i></a>
 * actions subsequent to the access or removal of that element from
 * the {@code BlockingDeque} in another thread.
 *
 * <p>This interface is a member of the
 * <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @since 1.6
 * @author Doug Lea
 * @param <E> the type of elements held in this deque
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface BlockingDeque<E> extends java.util.concurrent.BlockingQueue<E>,  java.util.Deque<E> {

/**
 * Inserts the specified element at the front of this deque if it is
 * possible to do so immediately without violating capacity restrictions,
 * throwing an {@code IllegalStateException} if no space is currently
 * available.  When using a capacity-restricted deque, it is generally
 * preferable to use {@link #offerFirst(java.lang.Object) offerFirst}.
 *
 * @param e the element to add
 * @throws java.lang.IllegalStateException {@inheritDoc}
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if the specified element is null
 * @throws java.lang.IllegalArgumentException {@inheritDoc}
 * @apiSince 9
 */

public void addFirst(E e);

/**
 * Inserts the specified element at the end of this deque if it is
 * possible to do so immediately without violating capacity restrictions,
 * throwing an {@code IllegalStateException} if no space is currently
 * available.  When using a capacity-restricted deque, it is generally
 * preferable to use {@link #offerLast(java.lang.Object) offerLast}.
 *
 * @param e the element to add
 * @throws java.lang.IllegalStateException {@inheritDoc}
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if the specified element is null
 * @throws java.lang.IllegalArgumentException {@inheritDoc}
 * @apiSince 9
 */

public void addLast(E e);

/**
 * Inserts the specified element at the front of this deque if it is
 * possible to do so immediately without violating capacity restrictions,
 * returning {@code true} upon success and {@code false} if no space is
 * currently available.
 * When using a capacity-restricted deque, this method is generally
 * preferable to the {@link #addFirst(java.lang.Object) addFirst} method, which can
 * fail to insert an element only by throwing an exception.
 *
 * @param e the element to add
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if the specified element is null
 * @throws java.lang.IllegalArgumentException {@inheritDoc}
 * @apiSince 9
 */

public boolean offerFirst(E e);

/**
 * Inserts the specified element at the end of this deque if it is
 * possible to do so immediately without violating capacity restrictions,
 * returning {@code true} upon success and {@code false} if no space is
 * currently available.
 * When using a capacity-restricted deque, this method is generally
 * preferable to the {@link #addLast(java.lang.Object) addLast} method, which can
 * fail to insert an element only by throwing an exception.
 *
 * @param e the element to add
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if the specified element is null
 * @throws java.lang.IllegalArgumentException {@inheritDoc}
 * @apiSince 9
 */

public boolean offerLast(E e);

/**
 * Inserts the specified element at the front of this deque,
 * waiting if necessary for space to become available.
 *
 * @param e the element to add
 * @throws java.lang.InterruptedException if interrupted while waiting
 * @throws java.lang.ClassCastException if the class of the specified element
 *         prevents it from being added to this deque
 * @throws java.lang.NullPointerException if the specified element is null
 * @throws java.lang.IllegalArgumentException if some property of the specified
 *         element prevents it from being added to this deque
 * @apiSince 9
 */

public void putFirst(E e) throws java.lang.InterruptedException;

/**
 * Inserts the specified element at the end of this deque,
 * waiting if necessary for space to become available.
 *
 * @param e the element to add
 * @throws java.lang.InterruptedException if interrupted while waiting
 * @throws java.lang.ClassCastException if the class of the specified element
 *         prevents it from being added to this deque
 * @throws java.lang.NullPointerException if the specified element is null
 * @throws java.lang.IllegalArgumentException if some property of the specified
 *         element prevents it from being added to this deque
 * @apiSince 9
 */

public void putLast(E e) throws java.lang.InterruptedException;

/**
 * Inserts the specified element at the front of this deque,
 * waiting up to the specified wait time if necessary for space to
 * become available.
 *
 * @param e the element to add
 * @param timeout how long to wait before giving up, in units of
 *        {@code unit}
 * @param unit a {@code TimeUnit} determining how to interpret the
 *        {@code timeout} parameter
 * @return {@code true} if successful, or {@code false} if
 *         the specified waiting time elapses before space is available
 * @throws java.lang.InterruptedException if interrupted while waiting
 * @throws java.lang.ClassCastException if the class of the specified element
 *         prevents it from being added to this deque
 * @throws java.lang.NullPointerException if the specified element is null
 * @throws java.lang.IllegalArgumentException if some property of the specified
 *         element prevents it from being added to this deque
 * @apiSince 9
 */

public boolean offerFirst(E e, long timeout, java.util.concurrent.TimeUnit unit) throws java.lang.InterruptedException;

/**
 * Inserts the specified element at the end of this deque,
 * waiting up to the specified wait time if necessary for space to
 * become available.
 *
 * @param e the element to add
 * @param timeout how long to wait before giving up, in units of
 *        {@code unit}
 * @param unit a {@code TimeUnit} determining how to interpret the
 *        {@code timeout} parameter
 * @return {@code true} if successful, or {@code false} if
 *         the specified waiting time elapses before space is available
 * @throws java.lang.InterruptedException if interrupted while waiting
 * @throws java.lang.ClassCastException if the class of the specified element
 *         prevents it from being added to this deque
 * @throws java.lang.NullPointerException if the specified element is null
 * @throws java.lang.IllegalArgumentException if some property of the specified
 *         element prevents it from being added to this deque
 * @apiSince 9
 */

public boolean offerLast(E e, long timeout, java.util.concurrent.TimeUnit unit) throws java.lang.InterruptedException;

/**
 * Retrieves and removes the first element of this deque, waiting
 * if necessary until an element becomes available.
 *
 * @return the head of this deque
 * @throws java.lang.InterruptedException if interrupted while waiting
 * @apiSince 9
 */

public E takeFirst() throws java.lang.InterruptedException;

/**
 * Retrieves and removes the last element of this deque, waiting
 * if necessary until an element becomes available.
 *
 * @return the tail of this deque
 * @throws java.lang.InterruptedException if interrupted while waiting
 * @apiSince 9
 */

public E takeLast() throws java.lang.InterruptedException;

/**
 * Retrieves and removes the first element of this deque, waiting
 * up to the specified wait time if necessary for an element to
 * become available.
 *
 * @param timeout how long to wait before giving up, in units of
 *        {@code unit}
 * @param unit a {@code TimeUnit} determining how to interpret the
 *        {@code timeout} parameter
 * @return the head of this deque, or {@code null} if the specified
 *         waiting time elapses before an element is available
 * @throws java.lang.InterruptedException if interrupted while waiting
 * @apiSince 9
 */

public E pollFirst(long timeout, java.util.concurrent.TimeUnit unit) throws java.lang.InterruptedException;

/**
 * Retrieves and removes the last element of this deque, waiting
 * up to the specified wait time if necessary for an element to
 * become available.
 *
 * @param timeout how long to wait before giving up, in units of
 *        {@code unit}
 * @param unit a {@code TimeUnit} determining how to interpret the
 *        {@code timeout} parameter
 * @return the tail of this deque, or {@code null} if the specified
 *         waiting time elapses before an element is available
 * @throws java.lang.InterruptedException if interrupted while waiting
 * @apiSince 9
 */

public E pollLast(long timeout, java.util.concurrent.TimeUnit unit) throws java.lang.InterruptedException;

/**
 * Removes the first occurrence of the specified element from this deque.
 * If the deque does not contain the element, it is unchanged.
 * More formally, removes the first element {@code e} such that
 * {@code o.equals(e)} (if such an element exists).
 * Returns {@code true} if this deque contained the specified element
 * (or equivalently, if this deque changed as a result of the call).
 *
 * @param o element to be removed from this deque, if present
 * @return {@code true} if an element was removed as a result of this call
 * @throws java.lang.ClassCastException if the class of the specified element
 *         is incompatible with this deque
 * (<a href="../Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.NullPointerException if the specified element is null
 * (<a href="../Collection.html#optional-restrictions">optional</a>)
 * @apiSince 9
 */

public boolean removeFirstOccurrence(java.lang.Object o);

/**
 * Removes the last occurrence of the specified element from this deque.
 * If the deque does not contain the element, it is unchanged.
 * More formally, removes the last element {@code e} such that
 * {@code o.equals(e)} (if such an element exists).
 * Returns {@code true} if this deque contained the specified element
 * (or equivalently, if this deque changed as a result of the call).
 *
 * @param o element to be removed from this deque, if present
 * @return {@code true} if an element was removed as a result of this call
 * @throws java.lang.ClassCastException if the class of the specified element
 *         is incompatible with this deque
 * (<a href="../Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.NullPointerException if the specified element is null
 * (<a href="../Collection.html#optional-restrictions">optional</a>)
 * @apiSince 9
 */

public boolean removeLastOccurrence(java.lang.Object o);

/**
 * Inserts the specified element into the queue represented by this deque
 * (in other words, at the tail of this deque) if it is possible to do so
 * immediately without violating capacity restrictions, returning
 * {@code true} upon success and throwing an
 * {@code IllegalStateException} if no space is currently available.
 * When using a capacity-restricted deque, it is generally preferable to
 * use {@link #offer(java.lang.Object) offer}.
 *
 * <p>This method is equivalent to {@link #addLast(java.lang.Object) addLast}.
 *
 * @param e the element to add
 * @throws java.lang.IllegalStateException {@inheritDoc}
 * @throws java.lang.ClassCastException if the class of the specified element
 *         prevents it from being added to this deque
 * @throws java.lang.NullPointerException if the specified element is null
 * @throws java.lang.IllegalArgumentException if some property of the specified
 *         element prevents it from being added to this deque
 * @apiSince 9
 */

public boolean add(E e);

/**
 * Inserts the specified element into the queue represented by this deque
 * (in other words, at the tail of this deque) if it is possible to do so
 * immediately without violating capacity restrictions, returning
 * {@code true} upon success and {@code false} if no space is currently
 * available.  When using a capacity-restricted deque, this method is
 * generally preferable to the {@link #add} method, which can fail to
 * insert an element only by throwing an exception.
 *
 * <p>This method is equivalent to {@link #offerLast(java.lang.Object) offerLast}.
 *
 * @param e the element to add
 * @throws java.lang.ClassCastException if the class of the specified element
 *         prevents it from being added to this deque
 * @throws java.lang.NullPointerException if the specified element is null
 * @throws java.lang.IllegalArgumentException if some property of the specified
 *         element prevents it from being added to this deque
 * @apiSince 9
 */

public boolean offer(E e);

/**
 * Inserts the specified element into the queue represented by this deque
 * (in other words, at the tail of this deque), waiting if necessary for
 * space to become available.
 *
 * <p>This method is equivalent to {@link #putLast(java.lang.Object) putLast}.
 *
 * @param e the element to add
 * @throws java.lang.InterruptedException {@inheritDoc}
 * @throws java.lang.ClassCastException if the class of the specified element
 *         prevents it from being added to this deque
 * @throws java.lang.NullPointerException if the specified element is null
 * @throws java.lang.IllegalArgumentException if some property of the specified
 *         element prevents it from being added to this deque
 * @apiSince 9
 */

public void put(E e) throws java.lang.InterruptedException;

/**
 * Inserts the specified element into the queue represented by this deque
 * (in other words, at the tail of this deque), waiting up to the
 * specified wait time if necessary for space to become available.
 *
 * <p>This method is equivalent to
 * {@link #offerLast(java.lang.Object,long,java.util.concurrent.TimeUnit) offerLast}.
 *
 * @param e the element to add
 * @return {@code true} if the element was added to this deque, else
 *         {@code false}
 * @throws java.lang.InterruptedException {@inheritDoc}
 * @throws java.lang.ClassCastException if the class of the specified element
 *         prevents it from being added to this deque
 * @throws java.lang.NullPointerException if the specified element is null
 * @throws java.lang.IllegalArgumentException if some property of the specified
 *         element prevents it from being added to this deque
 * @apiSince 9
 */

public boolean offer(E e, long timeout, java.util.concurrent.TimeUnit unit) throws java.lang.InterruptedException;

/**
 * Retrieves and removes the head of the queue represented by this deque
 * (in other words, the first element of this deque).
 * This method differs from {@link #poll poll} only in that it
 * throws an exception if this deque is empty.
 *
 * <p>This method is equivalent to {@link #removeFirst() removeFirst}.
 *
 * @return the head of the queue represented by this deque
 * @throws java.util.NoSuchElementException if this deque is empty
 * @apiSince 9
 */

public E remove();

/**
 * Retrieves and removes the head of the queue represented by this deque
 * (in other words, the first element of this deque), or returns
 * {@code null} if this deque is empty.
 *
 * <p>This method is equivalent to {@link #pollFirst()}.
 *
 * @return the head of this deque, or {@code null} if this deque is empty
 * @apiSince 9
 */

public E poll();

/**
 * Retrieves and removes the head of the queue represented by this deque
 * (in other words, the first element of this deque), waiting if
 * necessary until an element becomes available.
 *
 * <p>This method is equivalent to {@link #takeFirst() takeFirst}.
 *
 * @return the head of this deque
 * @throws java.lang.InterruptedException if interrupted while waiting
 * @apiSince 9
 */

public E take() throws java.lang.InterruptedException;

/**
 * Retrieves and removes the head of the queue represented by this deque
 * (in other words, the first element of this deque), waiting up to the
 * specified wait time if necessary for an element to become available.
 *
 * <p>This method is equivalent to
 * {@link #pollFirst(long,java.util.concurrent.TimeUnit) pollFirst}.
 *
 * @return the head of this deque, or {@code null} if the
 *         specified waiting time elapses before an element is available
 * @throws java.lang.InterruptedException if interrupted while waiting
 * @apiSince 9
 */

public E poll(long timeout, java.util.concurrent.TimeUnit unit) throws java.lang.InterruptedException;

/**
 * Retrieves, but does not remove, the head of the queue represented by
 * this deque (in other words, the first element of this deque).
 * This method differs from {@link #peek peek} only in that it throws an
 * exception if this deque is empty.
 *
 * <p>This method is equivalent to {@link #getFirst() getFirst}.
 *
 * @return the head of this deque
 * @throws java.util.NoSuchElementException if this deque is empty
 * @apiSince 9
 */

public E element();

/**
 * Retrieves, but does not remove, the head of the queue represented by
 * this deque (in other words, the first element of this deque), or
 * returns {@code null} if this deque is empty.
 *
 * <p>This method is equivalent to {@link #peekFirst() peekFirst}.
 *
 * @return the head of this deque, or {@code null} if this deque is empty
 * @apiSince 9
 */

public E peek();

/**
 * Removes the first occurrence of the specified element from this deque.
 * If the deque does not contain the element, it is unchanged.
 * More formally, removes the first element {@code e} such that
 * {@code o.equals(e)} (if such an element exists).
 * Returns {@code true} if this deque contained the specified element
 * (or equivalently, if this deque changed as a result of the call).
 *
 * <p>This method is equivalent to
 * {@link #removeFirstOccurrence(java.lang.Object) removeFirstOccurrence}.
 *
 * @param o element to be removed from this deque, if present
 * @return {@code true} if this deque changed as a result of the call
 * @throws java.lang.ClassCastException if the class of the specified element
 *         is incompatible with this deque
 * (<a href="../Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.NullPointerException if the specified element is null
 * (<a href="../Collection.html#optional-restrictions">optional</a>)
 * @apiSince 9
 */

public boolean remove(java.lang.Object o);

/**
 * Returns {@code true} if this deque contains the specified element.
 * More formally, returns {@code true} if and only if this deque contains
 * at least one element {@code e} such that {@code o.equals(e)}.
 *
 * @param o object to be checked for containment in this deque
 * @return {@code true} if this deque contains the specified element
 * @throws java.lang.ClassCastException if the class of the specified element
 *         is incompatible with this deque
 * (<a href="../Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.NullPointerException if the specified element is null
 * (<a href="../Collection.html#optional-restrictions">optional</a>)
 * @apiSince 9
 */

public boolean contains(java.lang.Object o);

/**
 * Returns the number of elements in this deque.
 *
 * @return the number of elements in this deque
 * @apiSince 9
 */

public int size();

/**
 * Returns an iterator over the elements in this deque in proper sequence.
 * The elements will be returned in order from first (head) to last (tail).
 *
 * @return an iterator over the elements in this deque in proper sequence
 * @apiSince 9
 */

public java.util.Iterator<E> iterator();

/**
 * Pushes an element onto the stack represented by this deque (in other
 * words, at the head of this deque) if it is possible to do so
 * immediately without violating capacity restrictions, throwing an
 * {@code IllegalStateException} if no space is currently available.
 *
 * <p>This method is equivalent to {@link #addFirst(java.lang.Object) addFirst}.
 *
 * @throws java.lang.IllegalStateException {@inheritDoc}
 * @throws java.lang.ClassCastException {@inheritDoc}
 * @throws java.lang.NullPointerException if the specified element is null
 * @throws java.lang.IllegalArgumentException {@inheritDoc}
 * @apiSince 9
 */

public void push(E e);
}

