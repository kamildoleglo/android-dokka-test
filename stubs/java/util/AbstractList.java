/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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
 * This class provides a skeletal implementation of the {@link java.util.List List}
 * interface to minimize the effort required to implement this interface
 * backed by a "random access" data store (such as an array).  For sequential
 * access data (such as a linked list), {@link java.util.AbstractSequentialList AbstractSequentialList} should
 * be used in preference to this class.
 *
 * <p>To implement an unmodifiable list, the programmer needs only to extend
 * this class and provide implementations for the {@link #get(int)} and
 * {@link java.util.List#size() List#size()} methods.
 *
 * <p>To implement a modifiable list, the programmer must additionally
 * override the {@link #set(int,java.lang.Object) set(int, E)} method (which otherwise
 * throws an {@code UnsupportedOperationException}).  If the list is
 * variable-size the programmer must additionally override the
 * {@link #add(int,java.lang.Object) add(int, E)} and {@link #remove(int)} methods.
 *
 * <p>The programmer should generally provide a void (no argument) and collection
 * constructor, as per the recommendation in the {@link java.util.Collection Collection} interface
 * specification.
 *
 * <p>Unlike the other abstract collection implementations, the programmer does
 * <i>not</i> have to provide an iterator implementation; the iterator and
 * list iterator are implemented by this class, on top of the "random access"
 * methods:
 * {@link #get(int)},
 * {@link #set(int,java.lang.Object) set(int, E)},
 * {@link #add(int,java.lang.Object) add(int, E)} and
 * {@link #remove(int)}.
 *
 * <p>The documentation for each non-abstract method in this class describes its
 * implementation in detail.  Each of these methods may be overridden if the
 * collection being implemented admits a more efficient implementation.
 *
 * <p>This class is a member of the
 * <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @author  Josh Bloch
 * @author  Neal Gafter
 * @since 1.2
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class AbstractList<E> extends java.util.AbstractCollection<E> implements java.util.List<E> {

/**
 * Sole constructor.  (For invocation by subclass constructors, typically
 * implicit.)
 * @apiSince 1
 */

protected AbstractList() { throw new RuntimeException("Stub!"); }

/**
 * Appends the specified element to the end of this list (optional
 * operation).
 *
 * <p>Lists that support this operation may place limitations on what
 * elements may be added to this list.  In particular, some
 * lists will refuse to add null elements, and others will impose
 * restrictions on the type of elements that may be added.  List
 * classes should clearly specify in their documentation any restrictions
 * on what elements may be added.
 *
 * <p>This implementation calls {@code add(size(), e)}.
 *
 * <p>Note that this implementation throws an
 * {@code UnsupportedOperationException} unless
 * {@link #add(int,java.lang.Object) add(int, E)} is overridden.
 *
 * @param e element to be appended to this list
 * @return {@code true} (as specified by {@link java.util.Collection#add Collection#add})
 * @throws java.lang.UnsupportedOperationException if the {@code add} operation
 *         is not supported by this list
 * @throws java.lang.ClassCastException if the class of the specified element
 *         prevents it from being added to this list
 * @throws java.lang.NullPointerException if the specified element is null and this
 *         list does not permit null elements
 * @throws java.lang.IllegalArgumentException if some property of this element
 *         prevents it from being added to this list
 * @apiSince 1
 */

public boolean add(E e) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * @throws java.lang.IndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

public abstract E get(int index);

/**
 * {@inheritDoc}
 *
 * <p>This implementation always throws an
 * {@code UnsupportedOperationException}.
 *
 * @throws java.lang.UnsupportedOperationException {@inheritDoc}
 * @throws java.lang.ClassCastException            {@inheritDoc}
 * @throws java.lang.NullPointerException          {@inheritDoc}
 * @throws java.lang.IllegalArgumentException      {@inheritDoc}
 * @throws java.lang.IndexOutOfBoundsException     {@inheritDoc}
 * @apiSince 1
 */

public E set(int index, E element) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * <p>This implementation always throws an
 * {@code UnsupportedOperationException}.
 *
 * @throws java.lang.UnsupportedOperationException {@inheritDoc}
 * @throws java.lang.ClassCastException            {@inheritDoc}
 * @throws java.lang.NullPointerException          {@inheritDoc}
 * @throws java.lang.IllegalArgumentException      {@inheritDoc}
 * @throws java.lang.IndexOutOfBoundsException     {@inheritDoc}
 * @apiSince 1
 */

public void add(int index, E element) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * <p>This implementation always throws an
 * {@code UnsupportedOperationException}.
 *
 * @throws java.lang.UnsupportedOperationException {@inheritDoc}
 * @throws java.lang.IndexOutOfBoundsException     {@inheritDoc}
 * @apiSince 1
 */

public E remove(int index) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * <p>This implementation first gets a list iterator (with
 * {@code listIterator()}).  Then, it iterates over the list until the
 * specified element is found or the end of the list is reached.
 *
 * @throws java.lang.ClassCastException   {@inheritDoc}
 * @throws java.lang.NullPointerException {@inheritDoc}
 * @apiSince 1
 */

public int indexOf(@androidx.annotation.Nullable java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * <p>This implementation first gets a list iterator that points to the end
 * of the list (with {@code listIterator(size())}).  Then, it iterates
 * backwards over the list until the specified element is found, or the
 * beginning of the list is reached.
 *
 * @throws java.lang.ClassCastException   {@inheritDoc}
 * @throws java.lang.NullPointerException {@inheritDoc}
 * @apiSince 1
 */

public int lastIndexOf(@androidx.annotation.Nullable java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Removes all of the elements from this list (optional operation).
 * The list will be empty after this call returns.
 *
 * <p>This implementation calls {@code removeRange(0, size())}.
 *
 * <p>Note that this implementation throws an
 * {@code UnsupportedOperationException} unless {@code remove(int
 * index)} or {@code removeRange(int fromIndex, int toIndex)} is
 * overridden.
 *
 * @throws java.lang.UnsupportedOperationException if the {@code clear} operation
 *         is not supported by this list
 * @apiSince 1
 */

public void clear() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * <p>This implementation gets an iterator over the specified collection
 * and iterates over it, inserting the elements obtained from the
 * iterator into this list at the appropriate position, one at a time,
 * using {@code add(int, E)}.
 * Many implementations will override this method for efficiency.
 *
 * <p>Note that this implementation throws an
 * {@code UnsupportedOperationException} unless
 * {@link #add(int,java.lang.Object) add(int, E)} is overridden.
 *
 * @throws java.lang.UnsupportedOperationException {@inheritDoc}
 * @throws java.lang.ClassCastException            {@inheritDoc}
 * @throws java.lang.NullPointerException          {@inheritDoc}
 * @throws java.lang.IllegalArgumentException      {@inheritDoc}
 * @throws java.lang.IndexOutOfBoundsException     {@inheritDoc}
 * @apiSince 1
 */

public boolean addAll(int index, @androidx.annotation.NonNull java.util.Collection<? extends E> c) { throw new RuntimeException("Stub!"); }

/**
 * Returns an iterator over the elements in this list in proper sequence.
 *
 * <p>This implementation returns a straightforward implementation of the
 * iterator interface, relying on the backing list's {@code size()},
 * {@code get(int)}, and {@code remove(int)} methods.
 *
 * <p>Note that the iterator returned by this method will throw an
 * {@link java.lang.UnsupportedOperationException UnsupportedOperationException} in response to its
 * {@code remove} method unless the list's {@code remove(int)} method is
 * overridden.
 *
 * <p>This implementation can be made to throw runtime exceptions in the
 * face of concurrent modification, as described in the specification
 * for the (protected) {@link #modCount} field.
 *
 * @return an iterator over the elements in this list in proper sequence
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.util.Iterator<E> iterator() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * <p>This implementation returns {@code listIterator(0)}.
 *
 * @see #listIterator(int)
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.util.ListIterator<E> listIterator() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * <p>This implementation returns a straightforward implementation of the
 * {@code ListIterator} interface that extends the implementation of the
 * {@code Iterator} interface returned by the {@code iterator()} method.
 * The {@code ListIterator} implementation relies on the backing list's
 * {@code get(int)}, {@code set(int, E)}, {@code add(int, E)}
 * and {@code remove(int)} methods.
 *
 * <p>Note that the list iterator returned by this implementation will
 * throw an {@link java.lang.UnsupportedOperationException UnsupportedOperationException} in response to its
 * {@code remove}, {@code set} and {@code add} methods unless the
 * list's {@code remove(int)}, {@code set(int, E)}, and
 * {@code add(int, E)} methods are overridden.
 *
 * <p>This implementation can be made to throw runtime exceptions in the
 * face of concurrent modification, as described in the specification for
 * the (protected) {@link #modCount} field.
 *
 * @throws java.lang.IndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.util.ListIterator<E> listIterator(int index) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * <p>This implementation returns a list that subclasses
 * {@code AbstractList}.  The subclass stores, in private fields, the
 * offset of the subList within the backing list, the size of the subList
 * (which can change over its lifetime), and the expected
 * {@code modCount} value of the backing list.  There are two variants
 * of the subclass, one of which implements {@code RandomAccess}.
 * If this list implements {@code RandomAccess} the returned list will
 * be an instance of the subclass that implements {@code RandomAccess}.
 *
 * <p>The subclass's {@code set(int, E)}, {@code get(int)},
 * {@code add(int, E)}, {@code remove(int)}, {@code addAll(int,
 * Collection)} and {@code removeRange(int, int)} methods all
 * delegate to the corresponding methods on the backing abstract list,
 * after bounds-checking the index and adjusting for the offset.  The
 * {@code addAll(Collection c)} method merely returns {@code addAll(size,
 * c)}.
 *
 * <p>The {@code listIterator(int)} method returns a "wrapper object"
 * over a list iterator on the backing list, which is created with the
 * corresponding method on the backing list.  The {@code iterator} method
 * merely returns {@code listIterator()}, and the {@code size} method
 * merely returns the subclass's {@code size} field.
 *
 * <p>All methods first check to see if the actual {@code modCount} of
 * the backing list is equal to its expected value, and throw a
 * {@code ConcurrentModificationException} if it is not.
 *
 * @throws java.lang.IndexOutOfBoundsException if an endpoint index value is out of range
 *         {@code (fromIndex < 0 || toIndex > size)}
 * @throws java.lang.IllegalArgumentException if the endpoint indices are out of order
 *         {@code (fromIndex > toIndex)}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.util.List<E> subList(int fromIndex, int toIndex) { throw new RuntimeException("Stub!"); }

/**
 * Compares the specified object with this list for equality.  Returns
 * {@code true} if and only if the specified object is also a list, both
 * lists have the same size, and all corresponding pairs of elements in
 * the two lists are <i>equal</i>.  (Two elements {@code e1} and
 * {@code e2} are <i>equal</i> if {@code (e1==null ? e2==null :
 * e1.equals(e2))}.)  In other words, two lists are defined to be
 * equal if they contain the same elements in the same order.<p>
 *
 * This implementation first checks if the specified object is this
 * list. If so, it returns {@code true}; if not, it checks if the
 * specified object is a list. If not, it returns {@code false}; if so,
 * it iterates over both lists, comparing corresponding pairs of elements.
 * If any comparison returns {@code false}, this method returns
 * {@code false}.  If either iterator runs out of elements before the
 * other it returns {@code false} (as the lists are of unequal length);
 * otherwise it returns {@code true} when the iterations complete.
 *
 * @param o the object to be compared for equality with this list
 * @return {@code true} if the specified object is equal to this list
 * @apiSince 1
 */

public boolean equals(@androidx.annotation.Nullable java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Returns the hash code value for this list.
 *
 * <p>This implementation uses exactly the code that is used to define the
 * list hash function in the documentation for the {@link java.util.List#hashCode List#hashCode}
 * method.
 *
 * @return the hash code value for this list
 * @apiSince 1
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Removes from this list all of the elements whose index is between
 * {@code fromIndex}, inclusive, and {@code toIndex}, exclusive.
 * Shifts any succeeding elements to the left (reduces their index).
 * This call shortens the list by {@code (toIndex - fromIndex)} elements.
 * (If {@code toIndex==fromIndex}, this operation has no effect.)
 *
 * <p>This method is called by the {@code clear} operation on this list
 * and its subLists.  Overriding this method to take advantage of
 * the internals of the list implementation can <i>substantially</i>
 * improve the performance of the {@code clear} operation on this list
 * and its subLists.
 *
 * <p>This implementation gets a list iterator positioned before
 * {@code fromIndex}, and repeatedly calls {@code ListIterator.next}
 * followed by {@code ListIterator.remove} until the entire range has
 * been removed.  <b>Note: if {@code ListIterator.remove} requires linear
 * time, this implementation requires quadratic time.</b>
 *
 * @param fromIndex index of first element to be removed
 * @param toIndex index after last element to be removed
 * @apiSince 1
 */

protected void removeRange(int fromIndex, int toIndex) { throw new RuntimeException("Stub!"); }

/**
 * The number of times this list has been <i>structurally modified</i>.
 * Structural modifications are those that change the size of the
 * list, or otherwise perturb it in such a fashion that iterations in
 * progress may yield incorrect results.
 *
 * <p>This field is used by the iterator and list iterator implementation
 * returned by the {@code iterator} and {@code listIterator} methods.
 * If the value of this field changes unexpectedly, the iterator (or list
 * iterator) will throw a {@code ConcurrentModificationException} in
 * response to the {@code next}, {@code remove}, {@code previous},
 * {@code set} or {@code add} operations.  This provides
 * <i>fail-fast</i> behavior, rather than non-deterministic behavior in
 * the face of concurrent modification during iteration.
 *
 * <p><b>Use of this field by subclasses is optional.</b> If a subclass
 * wishes to provide fail-fast iterators (and list iterators), then it
 * merely has to increment this field in its {@code add(int, E)} and
 * {@code remove(int)} methods (and any other methods that it overrides
 * that result in structural modifications to the list).  A single call to
 * {@code add(int, E)} or {@code remove(int)} must add no more than
 * one to this field, or the iterators (and list iterators) will throw
 * bogus {@code ConcurrentModificationExceptions}.  If an implementation
 * does not wish to provide fail-fast iterators, this field may be
 * ignored.
 * @apiSince 1
 */

protected transient int modCount = 0; // 0x0
}

