/*
 * Copyright (c) 1994, 2013, Oracle and/or its affiliates. All rights reserved.
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



package java.lang;


/**
 * A thread-safe, mutable sequence of characters.
 * A string buffer is like a {@link java.lang.String String}, but can be modified. At any
 * point in time it contains some particular sequence of characters, but
 * the length and content of the sequence can be changed through certain
 * method calls.
 * <p>
 * String buffers are safe for use by multiple threads. The methods
 * are synchronized where necessary so that all the operations on any
 * particular instance behave as if they occur in some serial order
 * that is consistent with the order of the method calls made by each of
 * the individual threads involved.
 * <p>
 * The principal operations on a {@code StringBuffer} are the
 * {@code append} and {@code insert} methods, which are
 * overloaded so as to accept data of any type. Each effectively
 * converts a given datum to a string and then appends or inserts the
 * characters of that string to the string buffer. The
 * {@code append} method always adds these characters at the end
 * of the buffer; the {@code insert} method adds the characters at
 * a specified point.
 * <p>
 * For example, if {@code z} refers to a string buffer object
 * whose current contents are {@code "start"}, then
 * the method call {@code z.append("le")} would cause the string
 * buffer to contain {@code "startle"}, whereas
 * {@code z.insert(4, "le")} would alter the string buffer to
 * contain {@code "starlet"}.
 * <p>
 * In general, if sb refers to an instance of a {@code StringBuffer},
 * then {@code sb.append(x)} has the same effect as
 * {@code sb.insert(sb.length(), x)}.
 * <p>
 * Whenever an operation occurs involving a source sequence (such as
 * appending or inserting from a source sequence), this class synchronizes
 * only on the string buffer performing the operation, not on the source.
 * Note that while {@code StringBuffer} is designed to be safe to use
 * concurrently from multiple threads, if the constructor or the
 * {@code append} or {@code insert} operation is passed a source sequence
 * that is shared across threads, the calling code must ensure
 * that the operation has a consistent and unchanging view of the source
 * sequence for the duration of the operation.
 * This could be satisfied by the caller holding a lock during the
 * operation's call, by using an immutable source sequence, or by not
 * sharing the source sequence across threads.
 * <p>
 * Every string buffer has a capacity. As long as the length of the
 * character sequence contained in the string buffer does not exceed
 * the capacity, it is not necessary to allocate a new internal
 * buffer array. If the internal buffer overflows, it is
 * automatically made larger.
 * <p>
 * Unless otherwise noted, passing a {@code null} argument to a constructor
 * or method in this class will cause a {@link java.lang.NullPointerException NullPointerException} to be
 * thrown.
 * <p>
 * As of  release JDK 5, this class has been supplemented with an equivalent
 * class designed for use by a single thread, {@link java.lang.StringBuilder StringBuilder}.  The
 * {@code StringBuilder} class should generally be used in preference to
 * this one, as it supports all of the same operations but it is faster, as
 * it performs no synchronization.
 *
 * @author      Arthur van Hoff
 * @see     java.lang.StringBuilder
 * @see     java.lang.String
 * @since   JDK1.0
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class StringBuffer implements java.lang.Appendable, java.lang.CharSequence, java.io.Serializable {

/**
 * Constructs a string buffer with no characters in it and an
 * initial capacity of 16 characters.
 * @apiSince 1
 */

public StringBuffer() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a string buffer with no characters in it and
 * the specified initial capacity.
 *
 * @param      capacity  the initial capacity.
 * @exception  java.lang.NegativeArraySizeException  if the {@code capacity}
 *               argument is less than {@code 0}.
 * @apiSince 1
 */

public StringBuffer(int capacity) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a string buffer initialized to the contents of the
 * specified string. The initial capacity of the string buffer is
 * {@code 16} plus the length of the string argument.
 *
 * @param   str   the initial contents of the buffer.
 * @apiSince 1
 */

public StringBuffer(@androidx.annotation.NonNull java.lang.String str) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a string buffer that contains the same characters
 * as the specified {@code CharSequence}. The initial capacity of
 * the string buffer is {@code 16} plus the length of the
 * {@code CharSequence} argument.
 * <p>
 * If the length of the specified {@code CharSequence} is
 * less than or equal to zero, then an empty buffer of capacity
 * {@code 16} is returned.
 *
 * @param      seq   the sequence to copy.
 * @since 1.5
 * @apiSince 1
 */

public StringBuffer(@androidx.annotation.NonNull java.lang.CharSequence seq) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public synchronized int length() { throw new RuntimeException("Stub!"); }

public synchronized int capacity() { throw new RuntimeException("Stub!"); }

public synchronized void ensureCapacity(int minimumCapacity) { throw new RuntimeException("Stub!"); }

/**
 * @since      1.5
 */

public synchronized void trimToSize() { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.IndexOutOfBoundsException {@inheritDoc}
 * @see        #length()
 */

public synchronized void setLength(int newLength) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.IndexOutOfBoundsException {@inheritDoc}
 * @see        #length()
 * @apiSince 1
 */

public synchronized char charAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * @since      1.5
 */

public synchronized int codePointAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * @since     1.5
 */

public synchronized int codePointBefore(int index) { throw new RuntimeException("Stub!"); }

/**
 * @since     1.5
 */

public synchronized int codePointCount(int beginIndex, int endIndex) { throw new RuntimeException("Stub!"); }

/**
 * @since     1.5
 */

public synchronized int offsetByCodePoints(int index, int codePointOffset) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.IndexOutOfBoundsException {@inheritDoc}
 */

public synchronized void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.IndexOutOfBoundsException {@inheritDoc}
 * @see        #length()
 */

public synchronized void setCharAt(int index, char ch) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull
public synchronized java.lang.StringBuffer append(@androidx.annotation.Nullable java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull
public synchronized java.lang.StringBuffer append(@androidx.annotation.Nullable java.lang.String str) { throw new RuntimeException("Stub!"); }

/**
 * Appends the specified {@code StringBuffer} to this sequence.
 * <p>
 * The characters of the {@code StringBuffer} argument are appended,
 * in order, to the contents of this {@code StringBuffer}, increasing the
 * length of this {@code StringBuffer} by the length of the argument.
 * If {@code sb} is {@code null}, then the four characters
 * {@code "null"} are appended to this {@code StringBuffer}.
 * <p>
 * Let <i>n</i> be the length of the old character sequence, the one
 * contained in the {@code StringBuffer} just prior to execution of the
 * {@code append} method. Then the character at index <i>k</i> in
 * the new character sequence is equal to the character at index <i>k</i>
 * in the old character sequence, if <i>k</i> is less than <i>n</i>;
 * otherwise, it is equal to the character at index <i>k-n</i> in the
 * argument {@code sb}.
 * <p>
 * This method synchronizes on {@code this}, the destination
 * object, but does not synchronize on the source ({@code sb}).
 *
 * @param   sb   the {@code StringBuffer} to append.
 * @return  a reference to this object.
 * @since 1.4
 * @apiSince 1
 */

@androidx.annotation.NonNull
public synchronized java.lang.StringBuffer append(@androidx.annotation.Nullable java.lang.StringBuffer sb) { throw new RuntimeException("Stub!"); }

/**
 * Appends the specified {@code CharSequence} to this
 * sequence.
 * <p>
 * The characters of the {@code CharSequence} argument are appended,
 * in order, increasing the length of this sequence by the length of the
 * argument.
 *
 * <p>The result of this method is exactly the same as if it were an
 * invocation of this.append(s, 0, s.length());
 *
 * <p>This method synchronizes on {@code this}, the destination
 * object, but does not synchronize on the source ({@code s}).
 *
 * <p>If {@code s} is {@code null}, then the four characters
 * {@code "null"} are appended.
 *
 * @param   s the {@code CharSequence} to append.
 * @return  a reference to this object.
 * @since 1.5
 * @apiSince 1
 */

@androidx.annotation.NonNull
public synchronized java.lang.StringBuffer append(@androidx.annotation.Nullable java.lang.CharSequence s) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.IndexOutOfBoundsException {@inheritDoc}
 * @since      1.5
 * @apiSince 1
 */

@androidx.annotation.NonNull
public synchronized java.lang.StringBuffer append(@androidx.annotation.Nullable java.lang.CharSequence s, int start, int end) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull
public synchronized java.lang.StringBuffer append(char[] str) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.IndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public synchronized java.lang.StringBuffer append(char[] str, int offset, int len) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull
public synchronized java.lang.StringBuffer append(boolean b) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull
public synchronized java.lang.StringBuffer append(char c) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull
public synchronized java.lang.StringBuffer append(int i) { throw new RuntimeException("Stub!"); }

/**
 * @since 1.5
 * @apiSince 1
 */

@androidx.annotation.NonNull
public synchronized java.lang.StringBuffer appendCodePoint(int codePoint) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull
public synchronized java.lang.StringBuffer append(long lng) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull
public synchronized java.lang.StringBuffer append(float f) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull
public synchronized java.lang.StringBuffer append(double d) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.StringIndexOutOfBoundsException {@inheritDoc}
 * @since      1.2
 * @apiSince 1
 */

@androidx.annotation.NonNull
public synchronized java.lang.StringBuffer delete(int start, int end) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.StringIndexOutOfBoundsException {@inheritDoc}
 * @since      1.2
 * @apiSince 1
 */

@androidx.annotation.NonNull
public synchronized java.lang.StringBuffer deleteCharAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.StringIndexOutOfBoundsException {@inheritDoc}
 * @since      1.2
 * @apiSince 1
 */

@androidx.annotation.NonNull
public synchronized java.lang.StringBuffer replace(int start, int end, @androidx.annotation.NonNull java.lang.String str) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.StringIndexOutOfBoundsException {@inheritDoc}
 * @since      1.2
 */

@androidx.annotation.NonNull
public synchronized java.lang.String substring(int start) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.IndexOutOfBoundsException {@inheritDoc}
 * @since      1.4
 * @apiSince 1
 */

@androidx.annotation.NonNull
public synchronized java.lang.CharSequence subSequence(int start, int end) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.StringIndexOutOfBoundsException {@inheritDoc}
 * @since      1.2
 */

@androidx.annotation.NonNull
public synchronized java.lang.String substring(int start, int end) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.StringIndexOutOfBoundsException {@inheritDoc}
 * @since      1.2
 * @apiSince 1
 */

@androidx.annotation.NonNull
public synchronized java.lang.StringBuffer insert(int index, char[] str, int offset, int len) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.StringIndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public synchronized java.lang.StringBuffer insert(int offset, @androidx.annotation.Nullable java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.StringIndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public synchronized java.lang.StringBuffer insert(int offset, @androidx.annotation.Nullable java.lang.String str) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.StringIndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public synchronized java.lang.StringBuffer insert(int offset, char[] str) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.IndexOutOfBoundsException {@inheritDoc}
 * @since      1.5
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.StringBuffer insert(int dstOffset, @androidx.annotation.Nullable java.lang.CharSequence s) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.IndexOutOfBoundsException {@inheritDoc}
 * @since      1.5
 * @apiSince 1
 */

@androidx.annotation.NonNull
public synchronized java.lang.StringBuffer insert(int dstOffset, @androidx.annotation.Nullable java.lang.CharSequence s, int start, int end) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.StringIndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.StringBuffer insert(int offset, boolean b) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.IndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public synchronized java.lang.StringBuffer insert(int offset, char c) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.StringIndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.StringBuffer insert(int offset, int i) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.StringIndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.StringBuffer insert(int offset, long l) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.StringIndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.StringBuffer insert(int offset, float f) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.StringIndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.StringBuffer insert(int offset, double d) { throw new RuntimeException("Stub!"); }

/**
 * @since      1.4
 */

public int indexOf(@androidx.annotation.NonNull java.lang.String str) { throw new RuntimeException("Stub!"); }

/**
 * @since      1.4
 */

public synchronized int indexOf(@androidx.annotation.NonNull java.lang.String str, int fromIndex) { throw new RuntimeException("Stub!"); }

/**
 * @since      1.4
 */

public int lastIndexOf(@androidx.annotation.NonNull java.lang.String str) { throw new RuntimeException("Stub!"); }

/**
 * @since      1.4
 */

public synchronized int lastIndexOf(@androidx.annotation.NonNull java.lang.String str, int fromIndex) { throw new RuntimeException("Stub!"); }

/**
 * @since   JDK1.0.2
 * @apiSince 1
 */

@androidx.annotation.NonNull
public synchronized java.lang.StringBuffer reverse() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull
public synchronized java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

