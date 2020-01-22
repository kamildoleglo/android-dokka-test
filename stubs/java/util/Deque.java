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
 * Written by Doug Lea and Josh Bloch with assistance from members of
 * JCP JSR-166 Expert Group and released to the public domain, as explained
 * at http://creativecommons.org/publicdomain/zero/1.0/
 */



package java.util;


/**
 * A linear collection that supports element insertion and removal at
 * both ends.  The name <i>deque</i> is short for "double ended queue"
 * and is usually pronounced "deck".  Most {@code Deque}
 * implementations place no fixed limits on the number of elements
 * they may contain, but this interface supports capacity-restricted
 * deques as well as those with no fixed size limit.
 *
 * <p>This interface defines methods to access the elements at both
 * ends of the deque.  Methods are provided to insert, remove, and
 * examine the element.  Each of these methods exists in two forms:
 * one throws an exception if the operation fails, the other returns a
 * special value (either {@code null} or {@code false}, depending on
 * the operation).  The latter form of the insert operation is
 * designed specifically for use with capacity-restricted
 * {@code Deque} implementations; in most implementations, insert
 * operations cannot fail.
 *
 * <p>The twelve methods described above are summarized in the
 * following table:
 *
 * <table BORDER CELLPADDING=3 CELLSPACING=1>
 * <caption>Summary of Deque methods</caption>
 *  <tr>
 *    <td></td>
 *    <td ALIGN=CENTER COLSPAN = 2> <b>First Element (Head)</b></td>
 *    <td ALIGN=CENTER COLSPAN = 2> <b>Last Element (Tail)</b></td>
 *  </tr>
 *  <tr>
 *    <td></td>
 *    <td ALIGN=CENTER><em>Throws exception</em></td>
 *    <td ALIGN=CENTER><em>Special value</em></td>
 *    <td ALIGN=CENTER><em>Throws exception</em></td>
 *    <td ALIGN=CENTER><em>Special value</em></td>
 *  </tr>
 *  <tr>
 *    <td><b>Insert</b></td>
 *    <td>{@link java.util.Deque#addFirst Deque#addFirst}</td>
 *    <td>{@link java.util.Deque#offerFirst Deque#offerFirst}</td>
 *    <td>{@link java.util.Deque#addLast Deque#addLast}</td>
 *    <td>{@link java.util.Deque#offerLast Deque#offerLast}</td>
 *  </tr>
 *  <tr>
 *    <td><b>Remove</b></td>
 *    <td>{@link java.util.Deque#removeFirst Deque#removeFirst}</td>
 *    <td>{@link java.util.Deque#pollFirst Deque#pollFirst}</td>
 *    <td>{@link java.util.Deque#removeLast Deque#removeLast}</td>
 *    <td>{@link java.util.Deque#pollLast Deque#pollLast}</td>
 *  </tr>
 *  <tr>
 *    <td><b>Examine</b></td>
 *    <td>{@link java.util.Deque#getFirst Deque#getFirst}</td>
 *    <td>{@link java.util.Deque#peekFirst Deque#peekFirst}</td>
 *    <td>{@link java.util.Deque#getLast Deque#getLast}</td>
 *    <td>{@link java.util.Deque#peekLast Deque#peekLast}</td>
 *  </tr>
 * </table>
 *
 * <p>This interface extends the {@link java.util.Queue Queue} interface.  When a deque is
 * used as a queue, FIFO (First-In-First-Out) behavior results.  Elements are
 * added at the end of the deque and removed from the beginning.  The methods
 * inherited from the {@code Queue} interface are precisely equivalent to
 * {@code Deque} methods as indicated in the following table:
 *
 * <table BORDER CELLPADDING=3 CELLSPACING=1>
 * <caption>Comparison of Queue and Deque methods</caption>
 *  <tr>
 *    <td ALIGN=CENTER> <b>{@code Queue} Method</b></td>
 *    <td ALIGN=CENTER> <b>Equivalent {@code Deque} Method</b></td>
 *  </tr>
 *  <tr>
 *    <td>{@link java.util.Queue#add add(e)}</td>
 *    <td>{@link #addLast addLast(e)}</td>
 *  </tr>
 *  <tr>
 *    <td>{@link java.util.Queue#offer offer(e)}</td>
 *    <td>{@link #offerLast offerLast(e)}</td>
 *  </tr>
 *  <tr>
 *    <td>{@link java.util.Queue#remove remove()}</td>
 *    <td>{@link #removeFirst removeFirst()}</td>
 *  </tr>
 *  <tr>
 *    <td>{@link java.util.Queue#poll poll()}</td>
 *    <td>{@link #pollFirst pollFirst()}</td>
 *  </tr>
 *  <tr>
 *    <td>{@link java.util.Queue#element element()}</td>
 *    <td>{@link #getFirst getFirst()}</td>
 *  </tr>
 *  <tr>
 *    <td>{@link java.util.Queue#peek peek()}</td>
 *    <td>{@link #peek peekFirst()}</td>
 *  </tr>
 * </table>
 *
 * <p>Deques can also be used as LIFO (Last-In-First-Out) stacks.  This
 * interface should be used in preference to the legacy {@link java.util.Stack Stack} class.
 * When a deque is used as a stack, elements are pushed and popped from the
 * beginning of the deque.  Stack methods are precisely equivalent to
 * {@code Deque} methods as indicated in the table below:
 *
 * <table BORDER CELLPADDING=3 CELLSPACING=1>
 * <caption>Comparison of Stack and Deque methods</caption>
 *  <tr>
 *    <td ALIGN=CENTER> <b>Stack Method</b></td>
 *    <td ALIGN=CENTER> <b>Equivalent {@code Deque} Method</b></td>
 *  </tr>
 *  <tr>
 *    <td>{@link #push push(e)}</td>
 *    <td>{@link #addFirst addFirst(e)}</td>
 *  </tr>
 *  <tr>
 *    <td>{@link #pop pop()}</td>
 *    <td>{@link #removeFirst removeFirst()}</td>
 *  </tr>
 *  <tr>
 *    <td>{@link #peek peek()}</td>
 *    <td>{@link #peekFirst peekFirst()}</td>
 *  </tr>
 * </table>
 *
 * <p>Note that the {@link #peek peek} method works equally well when
 * a deque is used as a queue or a stack; in either case, elements are
 * drawn from the beginning of the deque.
 *
 * <p>This interface provides two methods to remove interior
 * elements, {@link #removeFirstOccurrence removeFirstOccurrence} and
 * {@link #removeLastOccurrence removeLastOccurrence}.
 *
 * <p>Unlike the {@link java.util.List List} interface, this interface does not
 * provide support for indexed access to elements.
 *
 * <p>While {@code Deque} implementations are not strictly required
 * to prohibit the insertion of null elements, they are strongly
 * encouraged to do so.  Users of any {@code Deque} implementations
 * that do allow null elements are strongly encouraged <i>not</i> to
 * take advantage of the ability to insert nulls.  This is so because
 * {@code null} is used as a special return value by various methods
 * to indicated that the deque is empty.
 *
 * <p>{@code Deque} implementations generally do not define
 * element-based versions of the {@code equals} and {@code hashCode}
 * methods, but instead inherit the identity-based versions from class
 * {@code Object}.
 *
 * @author Doug Lea
 * @author Josh Bloch
 * @since  1.6
 * @param <E> the type of elements held in this deque
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface Deque<E> extends java.util.Queue<E> {

/**
 * Inserts the specified element at the front of this deque if it is
 * possible to do so immediately without violating capacity restrictions,
 * throwing an {@code IllegalStateException} if no space is currently
 * available.  When using a capacity-restricted deque, it is generally
 * preferable to use method {@link #offerFirst}.
 *
 * @param e the element to add
 * @throws java.lang.IllegalStateException if the element cannot be added at this
 *         time due to capacity restrictions
 * @throws java.lang.ClassCastException if the class of the specified element
 *         prevents it from being added to this deque
 * @throws java.lang.NullPointerException if the specified element is null and this
 *         deque does not permit null elements
 * @throws java.lang.IllegalArgumentException if some property of the specified
 *         element prevents it from being added to this deque
 * @apiSince 9
 */

public void addFirst(E e);

/**
 * Inserts the specified element at the end of this deque if it is
 * possible to do so immediately without violating capacity restrictions,
 * throwing an {@code IllegalStateException} if no space is currently
 * available.  When using a capacity-restricted deque, it is generally
 * preferable to use method {@link #offerLast}.
 *
 * <p>This method is equivalent to {@link #add}.
 *
 * @param e the element to add
 * @throws java.lang.IllegalStateException if the element cannot be added at this
 *         time due to capacity restrictions
 * @throws java.lang.ClassCastException if the class of the specified element
 *         prevents it from being added to this deque
 * @throws java.lang.NullPointerException if the specified element is null and this
 *         deque does not permit null elements
 * @throws java.lang.IllegalArgumentException if some property of the specified
 *         element prevents it from being added to this deque
 * @apiSince 9
 */

public void addLast(E e);

/**
 * Inserts the specified element at the front of this deque unless it would
 * violate capacity restrictions.  When using a capacity-restricted deque,
 * this method is generally preferable to the {@link #addFirst} method,
 * which can fail to insert an element only by throwing an exception.
 *
 * @param e the element to add
 * @return {@code true} if the element was added to this deque, else
 *         {@code false}
 * @throws java.lang.ClassCastException if the class of the specified element
 *         prevents it from being added to this deque
 * @throws java.lang.NullPointerException if the specified element is null and this
 *         deque does not permit null elements
 * @throws java.lang.IllegalArgumentException if some property of the specified
 *         element prevents it from being added to this deque
 * @apiSince 9
 */

public boolean offerFirst(E e);

/**
 * Inserts the specified element at the end of this deque unless it would
 * violate capacity restrictions.  When using a capacity-restricted deque,
 * this method is generally preferable to the {@link #addLast} method,
 * which can fail to insert an element only by throwing an exception.
 *
 * @param e the element to add
 * @return {@code true} if the element was added to this deque, else
 *         {@code false}
 * @throws java.lang.ClassCastException if the class of the specified element
 *         prevents it from being added to this deque
 * @throws java.lang.NullPointerException if the specified element is null and this
 *         deque does not permit null elements
 * @throws java.lang.IllegalArgumentException if some property of the specified
 *         element prevents it from being added to this deque
 * @apiSince 9
 */

public boolean offerLast(E e);

/**
 * Retrieves and removes the first element of this deque.  This method
 * differs from {@link #pollFirst pollFirst} only in that it throws an
 * exception if this deque is empty.
 *
 * @return the head of this deque
 * @throws java.util.NoSuchElementException if this deque is empty
 * @apiSince 9
 */

public E removeFirst();

/**
 * Retrieves and removes the last element of this deque.  This method
 * differs from {@link #pollLast pollLast} only in that it throws an
 * exception if this deque is empty.
 *
 * @return the tail of this deque
 * @throws java.util.NoSuchElementException if this deque is empty
 * @apiSince 9
 */

public E removeLast();

/**
 * Retrieves and removes the first element of this deque,
 * or returns {@code null} if this deque is empty.
 *
 * @return the head of this deque, or {@code null} if this deque is empty
 * @apiSince 9
 */

@androidx.annotation.Nullable
public E pollFirst();

/**
 * Retrieves and removes the last element of this deque,
 * or returns {@code null} if this deque is empty.
 *
 * @return the tail of this deque, or {@code null} if this deque is empty
 * @apiSince 9
 */

@androidx.annotation.Nullable
public E pollLast();

/**
 * Retrieves, but does not remove, the first element of this deque.
 *
 * This method differs from {@link #peekFirst peekFirst} only in that it
 * throws an exception if this deque is empty.
 *
 * @return the head of this deque
 * @throws java.util.NoSuchElementException if this deque is empty
 * @apiSince 9
 */

public E getFirst();

/**
 * Retrieves, but does not remove, the last element of this deque.
 * This method differs from {@link #peekLast peekLast} only in that it
 * throws an exception if this deque is empty.
 *
 * @return the tail of this deque
 * @throws java.util.NoSuchElementException if this deque is empty
 * @apiSince 9
 */

public E getLast();

/**
 * Retrieves, but does not remove, the first element of this deque,
 * or returns {@code null} if this deque is empty.
 *
 * @return the head of this deque, or {@code null} if this deque is empty
 * @apiSince 9
 */

@androidx.annotation.Nullable
public E peekFirst();

/**
 * Retrieves, but does not remove, the last element of this deque,
 * or returns {@code null} if this deque is empty.
 *
 * @return the tail of this deque, or {@code null} if this deque is empty
 * @apiSince 9
 */

@androidx.annotation.Nullable
public E peekLast();

/**
 * Removes the first occurrence of the specified element from this deque.
 * If the deque does not contain the element, it is unchanged.
 * More formally, removes the first element {@code e} such that
 * {@code Objects.equals(o, e)} (if such an element exists).
 * Returns {@code true} if this deque contained the specified element
 * (or equivalently, if this deque changed as a result of the call).
 *
 * @param o element to be removed from this deque, if present
 * @return {@code true} if an element was removed as a result of this call
 * @throws java.lang.ClassCastException if the class of the specified element
 *         is incompatible with this deque
 * (<a href="Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.NullPointerException if the specified element is null and this
 *         deque does not permit null elements
 * (<a href="Collection.html#optional-restrictions">optional</a>)
 * @apiSince 9
 */

public boolean removeFirstOccurrence(@androidx.annotation.Nullable java.lang.Object o);

/**
 * Removes the last occurrence of the specified element from this deque.
 * If the deque does not contain the element, it is unchanged.
 * More formally, removes the last element {@code e} such that
 * {@code Objects.equals(o, e)} (if such an element exists).
 * Returns {@code true} if this deque contained the specified element
 * (or equivalently, if this deque changed as a result of the call).
 *
 * @param o element to be removed from this deque, if present
 * @return {@code true} if an element was removed as a result of this call
 * @throws java.lang.ClassCastException if the class of the specified element
 *         is incompatible with this deque
 * (<a href="Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.NullPointerException if the specified element is null and this
 *         deque does not permit null elements
 * (<a href="Collection.html#optional-restrictions">optional</a>)
 * @apiSince 9
 */

public boolean removeLastOccurrence(@androidx.annotation.Nullable java.lang.Object o);

/**
 * Inserts the specified element into the queue represented by this deque
 * (in other words, at the tail of this deque) if it is possible to do so
 * immediately without violating capacity restrictions, returning
 * {@code true} upon success and throwing an
 * {@code IllegalStateException} if no space is currently available.
 * When using a capacity-restricted deque, it is generally preferable to
 * use {@link #offer(java.lang.Object) offer}.
 *
 * <p>This method is equivalent to {@link #addLast}.
 *
 * @param e the element to add
 * @return {@code true} (as specified by {@link java.util.Collection#add Collection#add})
 * @throws java.lang.IllegalStateException if the element cannot be added at this
 *         time due to capacity restrictions
 * @throws java.lang.ClassCastException if the class of the specified element
 *         prevents it from being added to this deque
 * @throws java.lang.NullPointerException if the specified element is null and this
 *         deque does not permit null elements
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
 * <p>This method is equivalent to {@link #offerLast}.
 *
 * @param e the element to add
 * @return {@code true} if the element was added to this deque, else
 *         {@code false}
 * @throws java.lang.ClassCastException if the class of the specified element
 *         prevents it from being added to this deque
 * @throws java.lang.NullPointerException if the specified element is null and this
 *         deque does not permit null elements
 * @throws java.lang.IllegalArgumentException if some property of the specified
 *         element prevents it from being added to this deque
 * @apiSince 9
 */

public boolean offer(E e);

/**
 * Retrieves and removes the head of the queue represented by this deque
 * (in other words, the first element of this deque).
 * This method differs from {@link #poll poll} only in that it throws an
 * exception if this deque is empty.
 *
 * <p>This method is equivalent to {@link #removeFirst()}.
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
 * @return the first element of this deque, or {@code null} if
 *         this deque is empty
 * @apiSince 9
 */

@androidx.annotation.Nullable
public E poll();

/**
 * Retrieves, but does not remove, the head of the queue represented by
 * this deque (in other words, the first element of this deque).
 * This method differs from {@link #peek peek} only in that it throws an
 * exception if this deque is empty.
 *
 * <p>This method is equivalent to {@link #getFirst()}.
 *
 * @return the head of the queue represented by this deque
 * @throws java.util.NoSuchElementException if this deque is empty
 * @apiSince 9
 */

public E element();

/**
 * Retrieves, but does not remove, the head of the queue represented by
 * this deque (in other words, the first element of this deque), or
 * returns {@code null} if this deque is empty.
 *
 * <p>This method is equivalent to {@link #peekFirst()}.
 *
 * @return the head of the queue represented by this deque, or
 *         {@code null} if this deque is empty
 * @apiSince 9
 */

@androidx.annotation.Nullable
public E peek();

/**
 * Pushes an element onto the stack represented by this deque (in other
 * words, at the head of this deque) if it is possible to do so
 * immediately without violating capacity restrictions, throwing an
 * {@code IllegalStateException} if no space is currently available.
 *
 * <p>This method is equivalent to {@link #addFirst}.
 *
 * @param e the element to push
 * @throws java.lang.IllegalStateException if the element cannot be added at this
 *         time due to capacity restrictions
 * @throws java.lang.ClassCastException if the class of the specified element
 *         prevents it from being added to this deque
 * @throws java.lang.NullPointerException if the specified element is null and this
 *         deque does not permit null elements
 * @throws java.lang.IllegalArgumentException if some property of the specified
 *         element prevents it from being added to this deque
 * @apiSince 9
 */

public void push(E e);

/**
 * Pops an element from the stack represented by this deque.  In other
 * words, removes and returns the first element of this deque.
 *
 * <p>This method is equivalent to {@link #removeFirst()}.
 *
 * @return the element at the front of this deque (which is the top
 *         of the stack represented by this deque)
 * @throws java.util.NoSuchElementException if this deque is empty
 * @apiSince 9
 */

public E pop();

/**
 * Removes the first occurrence of the specified element from this deque.
 * If the deque does not contain the element, it is unchanged.
 * More formally, removes the first element {@code e} such that
 * {@code Objects.equals(o, e)} (if such an element exists).
 * Returns {@code true} if this deque contained the specified element
 * (or equivalently, if this deque changed as a result of the call).
 *
 * <p>This method is equivalent to {@link #removeFirstOccurrence(java.lang.Object)}.
 *
 * @param o element to be removed from this deque, if present
 * @return {@code true} if an element was removed as a result of this call
 * @throws java.lang.ClassCastException if the class of the specified element
 *         is incompatible with this deque
 * (<a href="Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.NullPointerException if the specified element is null and this
 *         deque does not permit null elements
 * (<a href="Collection.html#optional-restrictions">optional</a>)
 * @apiSince 9
 */

public boolean remove(@androidx.annotation.Nullable java.lang.Object o);

/**
 * Returns {@code true} if this deque contains the specified element.
 * More formally, returns {@code true} if and only if this deque contains
 * at least one element {@code e} such that {@code Objects.equals(o, e)}.
 *
 * @param o element whose presence in this deque is to be tested
 * @return {@code true} if this deque contains the specified element
 * @throws java.lang.ClassCastException if the class of the specified element
 *         is incompatible with this deque
 * (<a href="Collection.html#optional-restrictions">optional</a>)
 * @throws java.lang.NullPointerException if the specified element is null and this
 *         deque does not permit null elements
 * (<a href="Collection.html#optional-restrictions">optional</a>)
 * @apiSince 9
 */

public boolean contains(@androidx.annotation.Nullable java.lang.Object o);

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

@androidx.annotation.NonNull
public java.util.Iterator<E> iterator();

/**
 * Returns an iterator over the elements in this deque in reverse
 * sequential order.  The elements will be returned in order from
 * last (tail) to first (head).
 *
 * @return an iterator over the elements in this deque in reverse
 * sequence
 * @apiSince 9
 */

@androidx.annotation.NonNull
public java.util.Iterator<E> descendingIterator();
}

