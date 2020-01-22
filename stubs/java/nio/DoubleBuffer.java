/*
 * Copyright (c) 2000, 2013, Oracle and/or its affiliates. All rights reserved.
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

// -- This file was mechanically generated: Do not edit! -- //



package java.nio;


/**
 * A double buffer.
 *
 * <p> This class defines four categories of operations upon
 * double buffers:
 *
 * <ul>
 *
 *   <li><p> Absolute and relative {@link #get() <i>get</i>} and
 *   {@link #put(double) <i>put</i>} methods that read and write
 *   single doubles; </p></li>
 *
 *   <li><p> Relative {@link #get(double[]) <i>bulk get</i>}
 *   methods that transfer contiguous sequences of doubles from this buffer
 *   into an array; and</p></li>
 *
 *   <li><p> Relative {@link #put(double[]) <i>bulk put</i>}
 *   methods that transfer contiguous sequences of doubles from a
 *   double array or some other double
 *   buffer into this buffer;&#32;and </p></li>
 *
 *
 *   <li><p> Methods for {@link #compact compacting}, {@link
 *   #duplicate duplicating}, and {@link #slice slicing}
 *   a double buffer.  </p></li>
 *
 * </ul>
 *
 * <p> Double buffers can be created either by {@link #allocate
 * <i>allocation</i>}, which allocates space for the buffer's
 *
 *
 * content, by {@link #wrap(double[]) <i>wrapping</i>} an existing
 * double array  into a buffer, or by creating a
 * <a href="ByteBuffer.html#views"><i>view</i></a> of an existing byte buffer.
 *
 *
 *
 *
 * <p> Like a byte buffer, a double buffer is either <a
 * href="ByteBuffer.html#direct"><i>direct</i> or <i>non-direct</i></a>.  A
 * double buffer created via the <tt>wrap</tt> methods of this class will
 * be non-direct.  A double buffer created as a view of a byte buffer will
 * be direct if, and only if, the byte buffer itself is direct.  Whether or not
 * a double buffer is direct may be determined by invoking the {@link
 * #isDirect isDirect} method.  </p>
 *
 *
 *
 *
 * <p> Methods in this class that do not otherwise have a value to return are
 * specified to return the buffer upon which they are invoked.  This allows
 * method invocations to be chained.
 *
 *
 *
 * @author Mark Reinhold
 * @author JSR-51 Expert Group
 * @since 1.4
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class DoubleBuffer extends java.nio.Buffer implements java.lang.Comparable<java.nio.DoubleBuffer> {

DoubleBuffer() { throw new RuntimeException("Stub!"); }

/**
 * Allocates a new double buffer.
 *
 * <p> The new buffer's position will be zero, its limit will be its
 * capacity, its mark will be undefined, and each of its elements will be
 * initialized to zero.  It will have a {@link #array backing array},
 * and its {@link #arrayOffset array offset} will be zero.
 *
 * @param  capacity
 *         The new buffer's capacity, in doubles
 *
 * @return  The new double buffer
 *
 * @throws  java.lang.IllegalArgumentException
 *          If the <tt>capacity</tt> is a negative integer
 * @apiSince 1
 */

public static java.nio.DoubleBuffer allocate(int capacity) { throw new RuntimeException("Stub!"); }

/**
 * Wraps a double array into a buffer.
 *
 * <p> The new buffer will be backed by the given double array;
 * that is, modifications to the buffer will cause the array to be modified
 * and vice versa.  The new buffer's capacity will be
 * <tt>array.length</tt>, its position will be <tt>offset</tt>, its limit
 * will be <tt>offset + length</tt>, and its mark will be undefined.  Its
 * {@link #array backing array} will be the given array, and
 * its {@link #arrayOffset array offset} will be zero.  </p>
 *
 * @param  array
 *         The array that will back the new buffer
 *
 * @param  offset
 *         The offset of the subarray to be used; must be non-negative and
 *         no larger than <tt>array.length</tt>.  The new buffer's position
 *         will be set to this value.
 *
 * @param  length
 *         The length of the subarray to be used;
 *         must be non-negative and no larger than
 *         <tt>array.length - offset</tt>.
 *         The new buffer's limit will be set to <tt>offset + length</tt>.
 *
 * @return  The new double buffer
 *
 * @throws  java.lang.IndexOutOfBoundsException
 *          If the preconditions on the <tt>offset</tt> and <tt>length</tt>
 *          parameters do not hold
 * @apiSince 1
 */

public static java.nio.DoubleBuffer wrap(double[] array, int offset, int length) { throw new RuntimeException("Stub!"); }

/**
 * Wraps a double array into a buffer.
 *
 * <p> The new buffer will be backed by the given double array;
 * that is, modifications to the buffer will cause the array to be modified
 * and vice versa.  The new buffer's capacity and limit will be
 * <tt>array.length</tt>, its position will be zero, and its mark will be
 * undefined.  Its {@link #array backing array} will be the
 * given array, and its {@link #arrayOffset array offset>} will
 * be zero.  </p>
 *
 * @param  array
 *         The array that will back this buffer
 *
 * @return  The new double buffer
 * @apiSince 1
 */

public static java.nio.DoubleBuffer wrap(double[] array) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new double buffer whose content is a shared subsequence of
 * this buffer's content.
 *
 * <p> The content of the new buffer will start at this buffer's current
 * position.  Changes to this buffer's content will be visible in the new
 * buffer, and vice versa; the two buffers' position, limit, and mark
 * values will be independent.
 *
 * <p> The new buffer's position will be zero, its capacity and its limit
 * will be the number of doubles remaining in this buffer, and its mark
 * will be undefined.  The new buffer will be direct if, and only if, this
 * buffer is direct, and it will be read-only if, and only if, this buffer
 * is read-only.  </p>
 *
 * @return  The new double buffer
 * @apiSince 1
 */

public abstract java.nio.DoubleBuffer slice();

/**
 * Creates a new double buffer that shares this buffer's content.
 *
 * <p> The content of the new buffer will be that of this buffer.  Changes
 * to this buffer's content will be visible in the new buffer, and vice
 * versa; the two buffers' position, limit, and mark values will be
 * independent.
 *
 * <p> The new buffer's capacity, limit, position, and mark values will be
 * identical to those of this buffer.  The new buffer will be direct if,
 * and only if, this buffer is direct, and it will be read-only if, and
 * only if, this buffer is read-only.  </p>
 *
 * @return  The new double buffer
 * @apiSince 1
 */

public abstract java.nio.DoubleBuffer duplicate();

/**
 * Creates a new, read-only double buffer that shares this buffer's
 * content.
 *
 * <p> The content of the new buffer will be that of this buffer.  Changes
 * to this buffer's content will be visible in the new buffer; the new
 * buffer itself, however, will be read-only and will not allow the shared
 * content to be modified.  The two buffers' position, limit, and mark
 * values will be independent.
 *
 * <p> The new buffer's capacity, limit, position, and mark values will be
 * identical to those of this buffer.
 *
 * <p> If this buffer is itself read-only then this method behaves in
 * exactly the same way as the {@link #duplicate duplicate} method.  </p>
 *
 * @return  The new, read-only double buffer
 * @apiSince 1
 */

public abstract java.nio.DoubleBuffer asReadOnlyBuffer();

/**
 * Relative <i>get</i> method.  Reads the double at this buffer's
 * current position, and then increments the position.
 *
 * @return  The double at the buffer's current position
 *
 * @throws  java.nio.BufferUnderflowException
 *          If the buffer's current position is not smaller than its limit
 * @apiSince 1
 */

public abstract double get();

/**
 * Relative <i>put</i> method&nbsp;&nbsp;<i>(optional operation)</i>.
 *
 * <p> Writes the given double into this buffer at the current
 * position, and then increments the position. </p>
 *
 * @param  d
 *         The double to be written
 *
 * @return  This buffer
 *
 * @throws  java.nio.BufferOverflowException
 *          If this buffer's current position is not smaller than its limit
 *
 * @throws  java.nio.ReadOnlyBufferException
 *          If this buffer is read-only
 * @apiSince 1
 */

public abstract java.nio.DoubleBuffer put(double d);

/**
 * Absolute <i>get</i> method.  Reads the double at the given
 * index.
 *
 * @param  index
 *         The index from which the double will be read
 *
 * @return  The double at the given index
 *
 * @throws  java.lang.IndexOutOfBoundsException
 *          If <tt>index</tt> is negative
 *          or not smaller than the buffer's limit
 * @apiSince 1
 */

public abstract double get(int index);

/**
 * Absolute <i>put</i> method&nbsp;&nbsp;<i>(optional operation)</i>.
 *
 * <p> Writes the given double into this buffer at the given
 * index. </p>
 *
 * @param  index
 *         The index at which the double will be written
 *
 * @param  d
 *         The double value to be written
 *
 * @return  This buffer
 *
 * @throws  java.lang.IndexOutOfBoundsException
 *          If <tt>index</tt> is negative
 *          or not smaller than the buffer's limit
 *
 * @throws  java.nio.ReadOnlyBufferException
 *          If this buffer is read-only
 * @apiSince 1
 */

public abstract java.nio.DoubleBuffer put(int index, double d);

/**
 * Relative bulk <i>get</i> method.
 *
 * <p> This method transfers doubles from this buffer into the given
 * destination array.  If there are fewer doubles remaining in the
 * buffer than are required to satisfy the request, that is, if
 * <tt>length</tt>&nbsp;<tt>&gt;</tt>&nbsp;<tt>remaining()</tt>, then no
 * doubles are transferred and a {@link java.nio.BufferUnderflowException BufferUnderflowException} is
 * thrown.
 *
 * <p> Otherwise, this method copies <tt>length</tt> doubles from this
 * buffer into the given array, starting at the current position of this
 * buffer and at the given offset in the array.  The position of this
 * buffer is then incremented by <tt>length</tt>.
 *
 * <p> In other words, an invocation of this method of the form
 * <tt>src.get(dst,&nbsp;off,&nbsp;len)</tt> has exactly the same effect as
 * the loop
 *
 * <pre>{@code
 *     for (int i = off; i < off + len; i++)
 *         dst[i] = src.get();
 * }</pre>
 *
 * except that it first checks that there are sufficient doubles in
 * this buffer and it is potentially much more efficient.
 *
 * @param  dst
 *         The array into which doubles are to be written
 *
 * @param  offset
 *         The offset within the array of the first double to be
 *         written; must be non-negative and no larger than
 *         <tt>dst.length</tt>
 *
 * @param  length
 *         The maximum number of doubles to be written to the given
 *         array; must be non-negative and no larger than
 *         <tt>dst.length - offset</tt>
 *
 * @return  This buffer
 *
 * @throws  java.nio.BufferUnderflowException
 *          If there are fewer than <tt>length</tt> doubles
 *          remaining in this buffer
 *
 * @throws  java.lang.IndexOutOfBoundsException
 *          If the preconditions on the <tt>offset</tt> and <tt>length</tt>
 *          parameters do not hold
 * @apiSince 1
 */

public java.nio.DoubleBuffer get(double[] dst, int offset, int length) { throw new RuntimeException("Stub!"); }

/**
 * Relative bulk <i>get</i> method.
 *
 * <p> This method transfers doubles from this buffer into the given
 * destination array.  An invocation of this method of the form
 * <tt>src.get(a)</tt> behaves in exactly the same way as the invocation
 *
 * <pre>
 *     src.get(a, 0, a.length) </pre>
 *
 * @param   dst
 *          The destination array
 *
 * @return  This buffer
 *
 * @throws  java.nio.BufferUnderflowException
 *          If there are fewer than <tt>length</tt> doubles
 *          remaining in this buffer
 * @apiSince 1
 */

public java.nio.DoubleBuffer get(double[] dst) { throw new RuntimeException("Stub!"); }

/**
 * Relative bulk <i>put</i> method&nbsp;&nbsp;<i>(optional operation)</i>.
 *
 * <p> This method transfers the doubles remaining in the given source
 * buffer into this buffer.  If there are more doubles remaining in the
 * source buffer than in this buffer, that is, if
 * <tt>src.remaining()</tt>&nbsp;<tt>&gt;</tt>&nbsp;<tt>remaining()</tt>,
 * then no doubles are transferred and a {@link java.nio.BufferOverflowException BufferOverflowException} is thrown.
 *
 * <p> Otherwise, this method copies
 * <i>n</i>&nbsp;=&nbsp;<tt>src.remaining()</tt> doubles from the given
 * buffer into this buffer, starting at each buffer's current position.
 * The positions of both buffers are then incremented by <i>n</i>.
 *
 * <p> In other words, an invocation of this method of the form
 * <tt>dst.put(src)</tt> has exactly the same effect as the loop
 *
 * <pre>
 *     while (src.hasRemaining())
 *         dst.put(src.get()); </pre>
 *
 * except that it first checks that there is sufficient space in this
 * buffer and it is potentially much more efficient.
 *
 * @param  src
 *         The source buffer from which doubles are to be read;
 *         must not be this buffer
 *
 * @return  This buffer
 *
 * @throws  java.nio.BufferOverflowException
 *          If there is insufficient space in this buffer
 *          for the remaining doubles in the source buffer
 *
 * @throws  java.lang.IllegalArgumentException
 *          If the source buffer is this buffer
 *
 * @throws  java.nio.ReadOnlyBufferException
 *          If this buffer is read-only
 * @apiSince 1
 */

public java.nio.DoubleBuffer put(java.nio.DoubleBuffer src) { throw new RuntimeException("Stub!"); }

/**
 * Relative bulk <i>put</i> method&nbsp;&nbsp;<i>(optional operation)</i>.
 *
 * <p> This method transfers doubles into this buffer from the given
 * source array.  If there are more doubles to be copied from the array
 * than remain in this buffer, that is, if
 * <tt>length</tt>&nbsp;<tt>&gt;</tt>&nbsp;<tt>remaining()</tt>, then no
 * doubles are transferred and a {@link java.nio.BufferOverflowException BufferOverflowException} is
 * thrown.
 *
 * <p> Otherwise, this method copies <tt>length</tt> doubles from the
 * given array into this buffer, starting at the given offset in the array
 * and at the current position of this buffer.  The position of this buffer
 * is then incremented by <tt>length</tt>.
 *
 * <p> In other words, an invocation of this method of the form
 * <tt>dst.put(src,&nbsp;off,&nbsp;len)</tt> has exactly the same effect as
 * the loop
 *
 * <pre>{@code
 *     for (int i = off; i < off + len; i++)
 *         dst.put(a[i]);
 * }</pre>
 *
 * except that it first checks that there is sufficient space in this
 * buffer and it is potentially much more efficient.
 *
 * @param  src
 *         The array from which doubles are to be read
 *
 * @param  offset
 *         The offset within the array of the first double to be read;
 *         must be non-negative and no larger than <tt>array.length</tt>
 *
 * @param  length
 *         The number of doubles to be read from the given array;
 *         must be non-negative and no larger than
 *         <tt>array.length - offset</tt>
 *
 * @return  This buffer
 *
 * @throws  java.nio.BufferOverflowException
 *          If there is insufficient space in this buffer
 *
 * @throws  java.lang.IndexOutOfBoundsException
 *          If the preconditions on the <tt>offset</tt> and <tt>length</tt>
 *          parameters do not hold
 *
 * @throws  java.nio.ReadOnlyBufferException
 *          If this buffer is read-only
 * @apiSince 1
 */

public java.nio.DoubleBuffer put(double[] src, int offset, int length) { throw new RuntimeException("Stub!"); }

/**
 * Relative bulk <i>put</i> method&nbsp;&nbsp;<i>(optional operation)</i>.
 *
 * <p> This method transfers the entire content of the given source
 * double array into this buffer.  An invocation of this method of the
 * form <tt>dst.put(a)</tt> behaves in exactly the same way as the
 * invocation
 *
 * <pre>
 *     dst.put(a, 0, a.length) </pre>
 *
 * @param   src
 *          The source array
 *
 * @return  This buffer
 *
 * @throws  java.nio.BufferOverflowException
 *          If there is insufficient space in this buffer
 *
 * @throws  java.nio.ReadOnlyBufferException
 *          If this buffer is read-only
 * @apiSince 1
 */

public final java.nio.DoubleBuffer put(double[] src) { throw new RuntimeException("Stub!"); }

/**
 * Tells whether or not this buffer is backed by an accessible double
 * array.
 *
 * <p> If this method returns <tt>true</tt> then the {@link #array() array}
 * and {@link #arrayOffset() arrayOffset} methods may safely be invoked.
 * </p>
 *
 * @return  <tt>true</tt> if, and only if, this buffer
 *          is backed by an array and is not read-only
 * @apiSince 1
 */

public final boolean hasArray() { throw new RuntimeException("Stub!"); }

/**
 * Returns the double array that backs this
 * buffer&nbsp;&nbsp;<i>(optional operation)</i>.
 *
 * <p> Modifications to this buffer's content will cause the returned
 * array's content to be modified, and vice versa.
 *
 * <p> Invoke the {@link #hasArray hasArray} method before invoking this
 * method in order to ensure that this buffer has an accessible backing
 * array.  </p>
 *
 * @return  The array that backs this buffer
 *
 * @throws  java.nio.ReadOnlyBufferException
 *          If this buffer is backed by an array but is read-only
 *
 * @throws  java.lang.UnsupportedOperationException
 *          If this buffer is not backed by an accessible array
 * @apiSince 1
 */

public final double[] array() { throw new RuntimeException("Stub!"); }

/**
 * Returns the offset within this buffer's backing array of the first
 * element of the buffer&nbsp;&nbsp;<i>(optional operation)</i>.
 *
 * <p> If this buffer is backed by an array then buffer position <i>p</i>
 * corresponds to array index <i>p</i>&nbsp;+&nbsp;<tt>arrayOffset()</tt>.
 *
 * <p> Invoke the {@link #hasArray hasArray} method before invoking this
 * method in order to ensure that this buffer has an accessible backing
 * array.  </p>
 *
 * @return  The offset within this buffer's array
 *          of the first element of the buffer
 *
 * @throws  java.nio.ReadOnlyBufferException
 *          If this buffer is backed by an array but is read-only
 *
 * @throws  java.lang.UnsupportedOperationException
 *          If this buffer is not backed by an accessible array
 * @apiSince 1
 */

public final int arrayOffset() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.nio.Buffer position(int newPosition) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.nio.Buffer limit(int newLimit) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.nio.Buffer mark() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.nio.Buffer reset() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.nio.Buffer clear() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.nio.Buffer flip() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.nio.Buffer rewind() { throw new RuntimeException("Stub!"); }

/**
 * Compacts this buffer&nbsp;&nbsp;<i>(optional operation)</i>.
 *
 * <p> The doubles between the buffer's current position and its limit,
 * if any, are copied to the beginning of the buffer.  That is, the
 * double at index <i>p</i>&nbsp;=&nbsp;<tt>position()</tt> is copied
 * to index zero, the double at index <i>p</i>&nbsp;+&nbsp;1 is copied
 * to index one, and so forth until the double at index
 * <tt>limit()</tt>&nbsp;-&nbsp;1 is copied to index
 * <i>n</i>&nbsp;=&nbsp;<tt>limit()</tt>&nbsp;-&nbsp;<tt>1</tt>&nbsp;-&nbsp;<i>p</i>.
 * The buffer's position is then set to <i>n+1</i> and its limit is set to
 * its capacity.  The mark, if defined, is discarded.
 *
 * <p> The buffer's position is set to the number of doubles copied,
 * rather than to zero, so that an invocation of this method can be
 * followed immediately by an invocation of another relative <i>put</i>
 * method. </p>
 *
 
 *
 * @return  This buffer
 *
 * @throws  java.nio.ReadOnlyBufferException
 *          If this buffer is read-only
 * @apiSince 1
 */

public abstract java.nio.DoubleBuffer compact();

/**
 * Tells whether or not this double buffer is direct.
 *
 * @return  <tt>true</tt> if, and only if, this buffer is direct
 * @apiSince 1
 */

public abstract boolean isDirect();

/**
 * Returns a string summarizing the state of this buffer.
 *
 * @return  A summary string
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current hash code of this buffer.
 *
 * <p> The hash code of a double buffer depends only upon its remaining
 * elements; that is, upon the elements from <tt>position()</tt> up to, and
 * including, the element at <tt>limit()</tt>&nbsp;-&nbsp;<tt>1</tt>.
 *
 * <p> Because buffer hash codes are content-dependent, it is inadvisable
 * to use buffers as keys in hash maps or similar data structures unless it
 * is known that their contents will not change.  </p>
 *
 * @return  The current hash code of this buffer
 * @apiSince 1
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Tells whether or not this buffer is equal to another object.
 *
 * <p> Two double buffers are equal if, and only if,
 *
 * <ol>
 *
 *   <li><p> They have the same element type,  </p></li>
 *
 *   <li><p> They have the same number of remaining elements, and
 *   </p></li>
 *
 *   <li><p> The two sequences of remaining elements, considered
 *   independently of their starting positions, are pointwise equal.
 
 *   This method considers two double elements {@code a} and {@code b}
 *   to be equal if
 *   {@code (a == b) || (Double.isNaN(a) && Double.isNaN(b))}.
 *   The values {@code -0.0} and {@code +0.0} are considered to be
 *   equal, unlike {@link java.lang.Double#equals(java.lang.Object) Double#equals(Object)}.
 
 *   </p></li>
 *
 * </ol>
 *
 * <p> A double buffer is not equal to any other type of object.  </p>
 *
 * @param  ob  The object to which this buffer is to be compared
 *
 * @return  <tt>true</tt> if, and only if, this buffer is equal to the
 *           given object
 * @apiSince 1
 */

public boolean equals(java.lang.Object ob) { throw new RuntimeException("Stub!"); }

/**
 * Compares this buffer to another.
 *
 * <p> Two double buffers are compared by comparing their sequences of
 * remaining elements lexicographically, without regard to the starting
 * position of each sequence within its corresponding buffer.
 
 * Pairs of {@code double} elements are compared as if by invoking
 * {@link java.lang.Double#compare(double,double) Double#compare(double,double)}, except that
 * {@code -0.0} and {@code 0.0} are considered to be equal.
 * {@code Double.NaN} is considered by this method to be equal
 * to itself and greater than all other {@code double} values
 * (including {@code Double.POSITIVE_INFINITY}).
 
 *
 * <p> A double buffer is not comparable to any other type of object.
 *
 * @return  A negative integer, zero, or a positive integer as this buffer
 *          is less than, equal to, or greater than the given buffer
 * @apiSince 1
 */

public int compareTo(java.nio.DoubleBuffer that) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves this buffer's byte order.
 *
 * <p> The byte order of a double buffer created by allocation or by
 * wrapping an existing <tt>double</tt> array is the {@link java.nio.ByteOrder#nativeOrder ByteOrder#nativeOrder} of the underlying
 * hardware.  The byte order of a double buffer created as a <a
 * href="ByteBuffer.html#views">view</a> of a byte buffer is that of the
 * byte buffer at the moment that the view is created.  </p>
 *
 * @return  This buffer's byte order
 * @apiSince 1
 */

public abstract java.nio.ByteOrder order();
}

