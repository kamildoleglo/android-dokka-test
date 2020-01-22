/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 2003, 2013, Oracle and/or its affiliates. All rights reserved.
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
 * A mutable sequence of characters.  This class provides an API compatible
 * with {@code StringBuffer}, but with no guarantee of synchronization.
 * This class is designed for use as a drop-in replacement for
 * {@code StringBuffer} in places where the string buffer was being
 * used by a single thread (as is generally the case).   Where possible,
 * it is recommended that this class be used in preference to
 * {@code StringBuffer} as it will be faster under most implementations.
 *
 * <p>The principal operations on a {@code StringBuilder} are the
 * {@code append} and {@code insert} methods, which are
 * overloaded so as to accept data of any type. Each effectively
 * converts a given datum to a string and then appends or inserts the
 * characters of that string to the string builder. The
 * {@code append} method always adds these characters at the end
 * of the builder; the {@code insert} method adds the characters at
 * a specified point.
 * <p>
 * For example, if {@code z} refers to a string builder object
 * whose current contents are "{@code start}", then
 * the method call {@code z.append("le")} would cause the string
 * builder to contain "{@code startle}", whereas
 * {@code z.insert(4, "le")} would alter the string builder to
 * contain "{@code starlet}".
 * <p>
 * In general, if sb refers to an instance of a {@code StringBuilder},
 * then {@code sb.append(x)} has the same effect as
 * {@code sb.insert(sb.length(), x)}.
 * <p>
 * Every string builder has a capacity. As long as the length of the
 * character sequence contained in the string builder does not exceed
 * the capacity, it is not necessary to allocate a new internal
 * buffer. If the internal buffer overflows, it is automatically made larger.
 *
 * <p>Instances of {@code StringBuilder} are not safe for
 * use by multiple threads. If such synchronization is required then it is
 * recommended that {@link java.lang.StringBuffer} be used.
 *
 * <p>Unless otherwise noted, passing a {@code null} argument to a constructor
 * or method in this class will cause a {@link java.lang.NullPointerException NullPointerException} to be
 * thrown.
 *
 * @author      Michael McCloskey
 * @see         java.lang.StringBuffer
 * @see         java.lang.String
 * @since       1.5
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class StringBuilder implements java.lang.Appendable, java.lang.CharSequence, java.io.Serializable {

/**
 * Constructs a string builder with no characters in it and an
 * initial capacity of 16 characters.
 * @apiSince 1
 */

public StringBuilder() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a string builder with no characters in it and an
 * initial capacity specified by the {@code capacity} argument.
 *
 * @param      capacity  the initial capacity.
 * @throws     java.lang.NegativeArraySizeException  if the {@code capacity}
 *               argument is less than {@code 0}.
 * @apiSince 1
 */

public StringBuilder(int capacity) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a string builder initialized to the contents of the
 * specified string. The initial capacity of the string builder is
 * {@code 16} plus the length of the string argument.
 *
 * @param   str   the initial contents of the buffer.
 * @apiSince 1
 */

public StringBuilder(@androidx.annotation.NonNull java.lang.String str) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a string builder that contains the same characters
 * as the specified {@code CharSequence}. The initial capacity of
 * the string builder is {@code 16} plus the length of the
 * {@code CharSequence} argument.
 *
 * @param      seq   the sequence to copy.
 * @apiSince 1
 */

public StringBuilder(@androidx.annotation.NonNull java.lang.CharSequence seq) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull
public java.lang.StringBuilder append(@androidx.annotation.Nullable java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull
public java.lang.StringBuilder append(@androidx.annotation.Nullable java.lang.String str) { throw new RuntimeException("Stub!"); }

/**
 * Appends the specified {@code StringBuffer} to this sequence.
 * <p>
 * The characters of the {@code StringBuffer} argument are appended,
 * in order, to this sequence, increasing the
 * length of this sequence by the length of the argument.
 * If {@code sb} is {@code null}, then the four characters
 * {@code "null"} are appended to this sequence.
 * <p>
 * Let <i>n</i> be the length of this character sequence just prior to
 * execution of the {@code append} method. Then the character at index
 * <i>k</i> in the new character sequence is equal to the character at
 * index <i>k</i> in the old character sequence, if <i>k</i> is less than
 * <i>n</i>; otherwise, it is equal to the character at index <i>k-n</i>
 * in the argument {@code sb}.
 *
 * @param   sb   the {@code StringBuffer} to append.
 * @return  a reference to this object.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.StringBuilder append(@androidx.annotation.Nullable java.lang.StringBuffer sb) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull
public java.lang.StringBuilder append(@androidx.annotation.Nullable java.lang.CharSequence s) { throw new RuntimeException("Stub!"); }

/**
 * @throws     java.lang.IndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.StringBuilder append(@androidx.annotation.Nullable java.lang.CharSequence s, int start, int end) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull
public java.lang.StringBuilder append(char[] str) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.IndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.StringBuilder append(char[] str, int offset, int len) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull
public java.lang.StringBuilder append(boolean b) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull
public java.lang.StringBuilder append(char c) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull
public java.lang.StringBuilder append(int i) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull
public java.lang.StringBuilder append(long lng) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull
public java.lang.StringBuilder append(float f) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull
public java.lang.StringBuilder append(double d) { throw new RuntimeException("Stub!"); }

/**
 * @since 1.5
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.StringBuilder appendCodePoint(int codePoint) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.StringIndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.StringBuilder delete(int start, int end) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.StringIndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.StringBuilder deleteCharAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.StringIndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.StringBuilder replace(int start, int end, @androidx.annotation.NonNull java.lang.String str) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.StringIndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.StringBuilder insert(int index, char[] str, int offset, int len) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.StringIndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.StringBuilder insert(int offset, @androidx.annotation.Nullable java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.StringIndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.StringBuilder insert(int offset, @androidx.annotation.Nullable java.lang.String str) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.StringIndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.StringBuilder insert(int offset, char[] str) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.IndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.StringBuilder insert(int dstOffset, @androidx.annotation.Nullable java.lang.CharSequence s) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.IndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.StringBuilder insert(int dstOffset, @androidx.annotation.Nullable java.lang.CharSequence s, int start, int end) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.StringIndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.StringBuilder insert(int offset, boolean b) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.IndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.StringBuilder insert(int offset, char c) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.StringIndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.StringBuilder insert(int offset, int i) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.StringIndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.StringBuilder insert(int offset, long l) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.StringIndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.StringBuilder insert(int offset, float f) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.StringIndexOutOfBoundsException {@inheritDoc}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.StringBuilder insert(int offset, double d) { throw new RuntimeException("Stub!"); }

public int indexOf(@androidx.annotation.NonNull java.lang.String str) { throw new RuntimeException("Stub!"); }

public int indexOf(@androidx.annotation.NonNull java.lang.String str, int fromIndex) { throw new RuntimeException("Stub!"); }

public int lastIndexOf(@androidx.annotation.NonNull java.lang.String str) { throw new RuntimeException("Stub!"); }

public int lastIndexOf(@androidx.annotation.NonNull java.lang.String str, int fromIndex) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull
public java.lang.StringBuilder reverse() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull
public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Attempts to reduce storage used for the character sequence.
 * If the buffer is larger than necessary to hold its current sequence of
 * characters, then it may be resized to become more space efficient.
 * Calling this method may, but is not required to, affect the value
 * returned by a subsequent call to the {@link #capacity()} method.
 */

public void trimToSize() { throw new RuntimeException("Stub!"); }

/**
 * Returns the character (Unicode code point) at the specified
 * index. The index refers to {@code char} values
 * (Unicode code units) and ranges from {@code 0} to
 * {@link #length()}{@code  - 1}.
 *
 * <p> If the {@code char} value specified at the given index
 * is in the high-surrogate range, the following index is less
 * than the length of this sequence, and the
 * {@code char} value at the following index is in the
 * low-surrogate range, then the supplementary code point
 * corresponding to this surrogate pair is returned. Otherwise,
 * the {@code char} value at the given index is returned.
 *
 * @param      index the index to the {@code char} values
 * @return     the code point value of the character at the
 *             {@code index}
 * @exception  java.lang.IndexOutOfBoundsException  if the {@code index}
 *             argument is negative or not less than the length of this
 *             sequence.
 */

public int codePointAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Characters are copied from this sequence into the
 * destination character array {@code dst}. The first character to
 * be copied is at index {@code srcBegin}; the last character to
 * be copied is at index {@code srcEnd-1}. The total number of
 * characters to be copied is {@code srcEnd-srcBegin}. The
 * characters are copied into the subarray of {@code dst} starting
 * at index {@code dstBegin} and ending at index:
 * <pre>{@code
 * dstbegin + (srcEnd-srcBegin) - 1
 * }</pre>
 *
 * @param      srcBegin   start copying at this offset.
 * @param      srcEnd     stop copying at this offset.
 * @param      dst        the array to copy the data into.
 * @param      dstBegin   offset into {@code dst}.
 * @throws     java.lang.IndexOutOfBoundsException  if any of the following is true:
 *             <ul>
 *             <li>{@code srcBegin} is negative
 *             <li>{@code dstBegin} is negative
 *             <li>the {@code srcBegin} argument is greater than
 *             the {@code srcEnd} argument.
 *             <li>{@code srcEnd} is greater than
 *             {@code this.length()}.
 *             <li>{@code dstBegin+srcEnd-srcBegin} is greater than
 *             {@code dst.length}
 *             </ul>
 */

public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) { throw new RuntimeException("Stub!"); }

/**
 * Returns the length (character count).
 *
 * @return  the length of the sequence of characters currently
 *          represented by this object
 * @apiSince 1
 */

public int length() { throw new RuntimeException("Stub!"); }

/**
 * The character at the specified index is set to {@code ch}. This
 * sequence is altered to represent a new character sequence that is
 * identical to the old character sequence, except that it contains the
 * character {@code ch} at position {@code index}.
 * <p>
 * The index argument must be greater than or equal to
 * {@code 0}, and less than the length of this sequence.
 *
 * @param      index   the index of the character to modify.
 * @param      ch      the new character.
 * @throws     java.lang.IndexOutOfBoundsException  if {@code index} is
 *             negative or greater than or equal to {@code length()}.
 */

public void setCharAt(int index, char ch) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new character sequence that is a subsequence of this sequence.
 *
 * <p> An invocation of this method of the form
 *
 * <pre>{@code
 * sb.subSequence(begin,&nbsp;end)}</pre>
 *
 * behaves in exactly the same way as the invocation
 *
 * <pre>{@code
 * sb.substring(begin,&nbsp;end)}</pre>
 *
 * This method is provided so that this class can
 * implement the {@link java.lang.CharSequence CharSequence} interface.
 *
 * @param      start   the start index, inclusive.
 * @param      end     the end index, exclusive.
 * @return     the specified subsequence.
 *
 * @throws  java.lang.IndexOutOfBoundsException
 *          if {@code start} or {@code end} are negative,
 *          if {@code end} is greater than {@code length()},
 *          or if {@code start} is greater than {@code end}
 * @spec JSR-51
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.CharSequence subSequence(int start, int end) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code String} that contains a subsequence of
 * characters currently contained in this character sequence. The
 * substring begins at the specified index and extends to the end of
 * this sequence.
 *
 * @param      start    The beginning index, inclusive.
 * @return     The new string.
 * @throws     java.lang.StringIndexOutOfBoundsException  if {@code start} is
 *             less than zero, or greater than the length of this object.
 */

@androidx.annotation.NonNull
public java.lang.String substring(int start) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code String} that contains a subsequence of
 * characters currently contained in this sequence. The
 * substring begins at the specified {@code start} and
 * extends to the character at index {@code end - 1}.
 *
 * @param      start    The beginning index, inclusive.
 * @param      end      The ending index, exclusive.
 * @return     The new string.
 * @throws     java.lang.StringIndexOutOfBoundsException  if {@code start}
 *             or {@code end} are negative or greater than
 *             {@code length()}, or {@code start} is
 *             greater than {@code end}.
 */

@androidx.annotation.NonNull
public java.lang.String substring(int start, int end) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current capacity. The capacity is the amount of storage
 * available for newly inserted characters, beyond which an allocation
 * will occur.
 *
 * @return  the current capacity
 */

public int capacity() { throw new RuntimeException("Stub!"); }

/**
 * Sets the length of the character sequence.
 * The sequence is changed to a new character sequence
 * whose length is specified by the argument. For every nonnegative
 * index <i>k</i> less than {@code newLength}, the character at
 * index <i>k</i> in the new character sequence is the same as the
 * character at index <i>k</i> in the old sequence if <i>k</i> is less
 * than the length of the old character sequence; otherwise, it is the
 * null character {@code '\u005Cu0000'}.
 *
 * In other words, if the {@code newLength} argument is less than
 * the current length, the length is changed to the specified length.
 * <p>
 * If the {@code newLength} argument is greater than or equal
 * to the current length, sufficient null characters
 * ({@code '\u005Cu0000'}) are appended so that
 * length becomes the {@code newLength} argument.
 * <p>
 * The {@code newLength} argument must be greater than or equal
 * to {@code 0}.
 *
 * @param      newLength   the new length
 * @throws     java.lang.IndexOutOfBoundsException  if the
 *               {@code newLength} argument is negative.
 */

public void setLength(int newLength) { throw new RuntimeException("Stub!"); }

/**
 * Ensures that the capacity is at least equal to the specified minimum.
 * If the current capacity is less than the argument, then a new internal
 * array is allocated with greater capacity. The new capacity is the
 * larger of:
 * <ul>
 * <li>The {@code minimumCapacity} argument.
 * <li>Twice the old capacity, plus {@code 2}.
 * </ul>
 * If the {@code minimumCapacity} argument is nonpositive, this
 * method takes no action and simply returns.
 * Note that subsequent operations on this object can reduce the
 * actual capacity below that requested here.
 *
 * @param   minimumCapacity   the minimum desired capacity.
 */

public void ensureCapacity(int minimumCapacity) { throw new RuntimeException("Stub!"); }

/**
 * Returns the character (Unicode code point) before the specified
 * index. The index refers to {@code char} values
 * (Unicode code units) and ranges from {@code 1} to {@link
 * #length()}.
 *
 * <p> If the {@code char} value at {@code (index - 1)}
 * is in the low-surrogate range, {@code (index - 2)} is not
 * negative, and the {@code char} value at {@code (index -
 * 2)} is in the high-surrogate range, then the
 * supplementary code point value of the surrogate pair is
 * returned. If the {@code char} value at {@code index -
 * 1} is an unpaired low-surrogate or a high-surrogate, the
 * surrogate value is returned.
 *
 * @param     index the index following the code point that should be returned
 * @return    the Unicode code point value before the given index.
 * @exception java.lang.IndexOutOfBoundsException if the {@code index}
 *            argument is less than 1 or greater than the length
 *            of this sequence.
 */

public int codePointBefore(int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@code char} value in this sequence at the specified index.
 * The first {@code char} value is at index {@code 0}, the next at index
 * {@code 1}, and so on, as in array indexing.
 * <p>
 * The index argument must be greater than or equal to
 * {@code 0}, and less than the length of this sequence.
 *
 * <p>If the {@code char} value specified by the index is a
 * <a href="Character.html#unicode">surrogate</a>, the surrogate
 * value is returned.
 *
 * @param      index   the index of the desired {@code char} value.
 * @return     the {@code char} value at the specified index.
 * @throws     java.lang.IndexOutOfBoundsException  if {@code index} is
 *             negative or greater than or equal to {@code length()}.
 * @apiSince 1
 */

public char charAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of Unicode code points in the specified text
 * range of this sequence. The text range begins at the specified
 * {@code beginIndex} and extends to the {@code char} at
 * index {@code endIndex - 1}. Thus the length (in
 * {@code char}s) of the text range is
 * {@code endIndex-beginIndex}. Unpaired surrogates within
 * this sequence count as one code point each.
 *
 * @param beginIndex the index to the first {@code char} of
 * the text range.
 * @param endIndex the index after the last {@code char} of
 * the text range.
 * @return the number of Unicode code points in the specified text
 * range
 * @exception java.lang.IndexOutOfBoundsException if the
 * {@code beginIndex} is negative, or {@code endIndex}
 * is larger than the length of this sequence, or
 * {@code beginIndex} is larger than {@code endIndex}.
 */

public int codePointCount(int beginIndex, int endIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns the index within this sequence that is offset from the
 * given {@code index} by {@code codePointOffset} code
 * points. Unpaired surrogates within the text range given by
 * {@code index} and {@code codePointOffset} count as
 * one code point each.
 *
 * @param index the index to be offset
 * @param codePointOffset the offset in code points
 * @return the index within this sequence
 * @exception java.lang.IndexOutOfBoundsException if {@code index}
 *   is negative or larger then the length of this sequence,
 *   or if {@code codePointOffset} is positive and the subsequence
 *   starting with {@code index} has fewer than
 *   {@code codePointOffset} code points,
 *   or if {@code codePointOffset} is negative and the subsequence
 *   before {@code index} has fewer than the absolute value of
 *   {@code codePointOffset} code points.
 */

public int offsetByCodePoints(int index, int codePointOffset) { throw new RuntimeException("Stub!"); }
}

