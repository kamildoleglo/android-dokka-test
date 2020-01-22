/*
 * Copyright (C) 2014 The Android Open Source Project
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

import java.nio.charset.Charset;
import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.StringJoiner;
import java.util.Locale;
import java.util.Formatter;
import java.util.Comparator;

/**
 * The {@code String} class represents character strings. All
 * string literals in Java programs, such as {@code "abc"}, are
 * implemented as instances of this class.
 * <p>
 * Strings are constant; their values cannot be changed after they
 * are created. String buffers support mutable strings.
 * Because String objects are immutable they can be shared. For example:
 * <blockquote><pre>
 *     String str = "abc";
 * </pre></blockquote><p>
 * is equivalent to:
 * <blockquote><pre>
 *     char data[] = {'a', 'b', 'c'};
 *     String str = new String(data);
 * </pre></blockquote><p>
 * Here are some more examples of how strings can be used:
 * <blockquote><pre>
 *     System.out.println("abc");
 *     String cde = "cde";
 *     System.out.println("abc" + cde);
 *     String c = "abc".substring(2,3);
 *     String d = cde.substring(1, 2);
 * </pre></blockquote>
 * <p>
 * The class {@code String} includes methods for examining
 * individual characters of the sequence, for comparing strings, for
 * searching strings, for extracting substrings, and for creating a
 * copy of a string with all characters translated to uppercase or to
 * lowercase. Case mapping is based on the Unicode Standard version
 * specified by the {@link java.lang.Character Character} class.
 * <p>
 * The Java language provides special support for the string
 * concatenation operator (&nbsp;+&nbsp;), and for conversion of
 * other objects to strings. String concatenation is implemented
 * through the {@code StringBuilder}(or {@code StringBuffer})
 * class and its {@code append} method.
 * String conversions are implemented through the method
 * {@code toString}, defined by {@code Object} and
 * inherited by all classes in Java. For additional information on
 * string concatenation and conversion, see Gosling, Joy, and Steele,
 * <i>The Java Language Specification</i>.
 *
 * <p> Unless otherwise noted, passing a <tt>null</tt> argument to a constructor
 * or method in this class will cause a {@link java.lang.NullPointerException NullPointerException} to be
 * thrown.
 *
 * <p>A {@code String} represents a string in the UTF-16 format
 * in which <em>supplementary characters</em> are represented by <em>surrogate
 * pairs</em> (see the section <a href="Character.html#unicode">Unicode
 * Character Representations</a> in the {@code Character} class for
 * more information).
 * Index values refer to {@code char} code units, so a supplementary
 * character uses two positions in a {@code String}.
 * <p>The {@code String} class provides methods for dealing with
 * Unicode code points (i.e., characters), in addition to those for
 * dealing with Unicode code units (i.e., {@code char} values).
 *
 * @author  Lee Boynton
 * @author  Arthur van Hoff
 * @author  Martin Buchholz
 * @author  Ulf Zibis
 * @see     java.lang.Object#toString()
 * @see     java.lang.StringBuffer
 * @see     java.lang.StringBuilder
 * @see     java.nio.charset.Charset
 * @since   JDK1.0
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class String implements java.io.Serializable, java.lang.Comparable<java.lang.String>, java.lang.CharSequence {

/**
 * Initializes a newly created {@code String} object so that it represents
 * an empty character sequence.  Note that use of this constructor is
 * unnecessary since Strings are immutable.
 * @apiSince 1
 */

public String() { throw new RuntimeException("Stub!"); }

/**
 * Initializes a newly created {@code String} object so that it represents
 * the same sequence of characters as the argument; in other words, the
 * newly created string is a copy of the argument string. Unless an
 * explicit copy of {@code original} is needed, use of this constructor is
 * unnecessary since Strings are immutable.
 *
 * @param  original
 *         A {@code String}
 * @apiSince 1
 */

public String(@androidx.annotation.NonNull java.lang.String original) { throw new RuntimeException("Stub!"); }

/**
 * Allocates a new {@code String} so that it represents the sequence of
 * characters currently contained in the character array argument. The
 * contents of the character array are copied; subsequent modification of
 * the character array does not affect the newly created string.
 *
 * @param  value
 *         The initial value of the string
 * @apiSince 1
 */

public String(char[] value) { throw new RuntimeException("Stub!"); }

/**
 * Allocates a new {@code String} that contains characters from a subarray
 * of the character array argument. The {@code offset} argument is the
 * index of the first character of the subarray and the {@code count}
 * argument specifies the length of the subarray. The contents of the
 * subarray are copied; subsequent modification of the character array does
 * not affect the newly created string.
 *
 * @param  value
 *         Array that is the source of characters
 *
 * @param  offset
 *         The initial offset
 *
 * @param  count
 *         The length
 *
 * @throws  java.lang.IndexOutOfBoundsException
 *          If the {@code offset} and {@code count} arguments index
 *          characters outside the bounds of the {@code value} array
 * @apiSince 1
 */

public String(char[] value, int offset, int count) { throw new RuntimeException("Stub!"); }

/**
 * Allocates a new {@code String} that contains characters from a subarray
 * of the <a href="Character.html#unicode">Unicode code point</a> array
 * argument.  The {@code offset} argument is the index of the first code
 * point of the subarray and the {@code count} argument specifies the
 * length of the subarray.  The contents of the subarray are converted to
 * {@code char}s; subsequent modification of the {@code int} array does not
 * affect the newly created string.
 *
 * @param  codePoints
 *         Array that is the source of Unicode code points
 *
 * @param  offset
 *         The initial offset
 *
 * @param  count
 *         The length
 *
 * @throws  java.lang.IllegalArgumentException
 *          If any invalid Unicode code point is found in {@code
 *          codePoints}
 *
 * @throws  java.lang.IndexOutOfBoundsException
 *          If the {@code offset} and {@code count} arguments index
 *          characters outside the bounds of the {@code codePoints} array
 *
 * @since  1.5
 * @apiSince 1
 */

public String(int[] codePoints, int offset, int count) { throw new RuntimeException("Stub!"); }

/**
 * Allocates a new {@code String} constructed from a subarray of an array
 * of 8-bit integer values.
 *
 * <p> The {@code offset} argument is the index of the first byte of the
 * subarray, and the {@code count} argument specifies the length of the
 * subarray.
 *
 * <p> Each {@code byte} in the subarray is converted to a {@code char} as
 * specified in the method above.
 *
 * @deprecated This method does not properly convert bytes into characters.
 * As of JDK&nbsp;1.1, the preferred way to do this is via the
 * {@code String} constructors that take a {@link
 * java.nio.charset.Charset}, charset name, or that use the platform's
 * default charset.
 *
 * @param  ascii
 *         The bytes to be converted to characters
 *
 * @param  hibyte
 *         The top 8 bits of each 16-bit Unicode code unit
 *
 * @param  offset
 *         The initial offset
 * @param  count
 *         The length
 *
 * @throws  java.lang.IndexOutOfBoundsException
 *          If the {@code offset} or {@code count} argument is invalid
 *
 * @see  #String(byte[], int)
 * @see  #String(byte[], int, int, java.lang.String)
 * @see  #String(byte[], int, int, java.nio.charset.Charset)
 * @see  #String(byte[], int, int)
 * @see  #String(byte[], java.lang.String)
 * @see  #String(byte[], java.nio.charset.Charset)
 * @see  #String(byte[])
 * @apiSince 1
 */

@Deprecated
public String(byte[] ascii, int hibyte, int offset, int count) { throw new RuntimeException("Stub!"); }

/**
 * Allocates a new {@code String} containing characters constructed from
 * an array of 8-bit integer values. Each character <i>c</i>in the
 * resulting string is constructed from the corresponding component
 * <i>b</i> in the byte array such that:
 *
 * <blockquote><pre>
 *     <b><i>c</i></b> == (char)(((hibyte &amp; 0xff) &lt;&lt; 8)
 *                         | (<b><i>b</i></b> &amp; 0xff))
 * </pre></blockquote>
 *
 * @deprecated  This method does not properly convert bytes into
 * characters.  As of JDK&nbsp;1.1, the preferred way to do this is via the
 * {@code String} constructors that take a {@link
 * java.nio.charset.Charset}, charset name, or that use the platform's
 * default charset.
 *
 * @param  ascii
 *         The bytes to be converted to characters
 *
 * @param  hibyte
 *         The top 8 bits of each 16-bit Unicode code unit
 *
 * @see  #String(byte[], int, int, java.lang.String)
 * @see  #String(byte[], int, int, java.nio.charset.Charset)
 * @see  #String(byte[], int, int)
 * @see  #String(byte[], java.lang.String)
 * @see  #String(byte[], java.nio.charset.Charset)
 * @see  #String(byte[])
 * @apiSince 1
 */

@Deprecated
public String(byte[] ascii, int hibyte) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new {@code String} by decoding the specified subarray of
 * bytes using the specified charset.  The length of the new {@code String}
 * is a function of the charset, and hence may not be equal to the length
 * of the subarray.
 *
 * <p> The behavior of this constructor when the given bytes are not valid
 * in the given charset is unspecified.  The {@link
 * java.nio.charset.CharsetDecoder} class should be used when more control
 * over the decoding process is required.
 *
 * @param  bytes
 *         The bytes to be decoded into characters
 *
 * @param  offset
 *         The index of the first byte to decode
 *
 * @param  length
 *         The number of bytes to decode
 
 * @param  charsetName
 *         The name of a supported {@linkplain java.nio.charset.Charset
 *         charset}
 *
 * @throws  java.io.UnsupportedEncodingException
 *          If the named charset is not supported
 *
 * @throws  java.lang.IndexOutOfBoundsException
 *          If the {@code offset} and {@code length} arguments index
 *          characters outside the bounds of the {@code bytes} array
 *
 * @since  JDK1.1
 * @apiSince 1
 */

public String(byte[] bytes, int offset, int length, @androidx.annotation.NonNull java.lang.String charsetName) throws java.io.UnsupportedEncodingException { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new {@code String} by decoding the specified subarray of
 * bytes using the specified {@linkplain java.nio.charset.Charset charset}.
 * The length of the new {@code String} is a function of the charset, and
 * hence may not be equal to the length of the subarray.
 *
 * <p> This method always replaces malformed-input and unmappable-character
 * sequences with this charset's default replacement string.  The {@link
 * java.nio.charset.CharsetDecoder} class should be used when more control
 * over the decoding process is required.
 *
 * @param  bytes
 *         The bytes to be decoded into characters
 *
 * @param  offset
 *         The index of the first byte to decode
 *
 * @param  length
 *         The number of bytes to decode
 *
 * @param  charset
 *         The {@linkplain java.nio.charset.Charset charset} to be used to
 *         decode the {@code bytes}
 *
 * @throws  java.lang.IndexOutOfBoundsException
 *          If the {@code offset} and {@code length} arguments index
 *          characters outside the bounds of the {@code bytes} array
 *
 * @since  1.6
 * @apiSince 9
 */

public String(byte[] bytes, int offset, int length, @androidx.annotation.NonNull java.nio.charset.Charset charset) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new {@code String} by decoding the specified array of bytes
 * using the specified {@linkplain java.nio.charset.Charset charset}.  The
 * length of the new {@code String} is a function of the charset, and hence
 * may not be equal to the length of the byte array.
 *
 * <p> The behavior of this constructor when the given bytes are not valid
 * in the given charset is unspecified.  The {@link
 * java.nio.charset.CharsetDecoder} class should be used when more control
 * over the decoding process is required.
 *
 * @param  bytes
 *         The bytes to be decoded into characters
 *
 * @param  charsetName
 *         The name of a supported {@linkplain java.nio.charset.Charset
 *         charset}
 *
 * @throws  java.io.UnsupportedEncodingException
 *          If the named charset is not supported
 *
 * @since  JDK1.1
 * @apiSince 1
 */

public String(byte[] bytes, @androidx.annotation.NonNull java.lang.String charsetName) throws java.io.UnsupportedEncodingException { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new {@code String} by decoding the specified array of
 * bytes using the specified {@linkplain java.nio.charset.Charset charset}.
 * The length of the new {@code String} is a function of the charset, and
 * hence may not be equal to the length of the byte array.
 *
 * <p> This method always replaces malformed-input and unmappable-character
 * sequences with this charset's default replacement string.  The {@link
 * java.nio.charset.CharsetDecoder} class should be used when more control
 * over the decoding process is required.
 *
 * @param  bytes
 *         The bytes to be decoded into characters
 *
 * @param  charset
 *         The {@linkplain java.nio.charset.Charset charset} to be used to
 *         decode the {@code bytes}
 *
 * @since  1.6
 * @apiSince 9
 */

public String(byte[] bytes, @androidx.annotation.NonNull java.nio.charset.Charset charset) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new {@code String} by decoding the specified subarray of
 * bytes using the platform's default charset.  The length of the new
 * {@code String} is a function of the charset, and hence may not be equal
 * to the length of the subarray.
 *
 * <p> The behavior of this constructor when the given bytes are not valid
 * in the default charset is unspecified.  The {@link
 * java.nio.charset.CharsetDecoder} class should be used when more control
 * over the decoding process is required.
 *
 * @param  bytes
 *         The bytes to be decoded into characters
 *
 * @param  offset
 *         The index of the first byte to decode
 *
 * @param  length
 *         The number of bytes to decode
 *
 * @throws  java.lang.IndexOutOfBoundsException
 *          If the {@code offset} and the {@code length} arguments index
 *          characters outside the bounds of the {@code bytes} array
 *
 * @since  JDK1.1
 * @apiSince 1
 */

public String(byte[] bytes, int offset, int length) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new {@code String} by decoding the specified array of bytes
 * using the platform's default charset.  The length of the new {@code
 * String} is a function of the charset, and hence may not be equal to the
 * length of the byte array.
 *
 * <p> The behavior of this constructor when the given bytes are not valid
 * in the default charset is unspecified.  The {@link
 * java.nio.charset.CharsetDecoder} class should be used when more control
 * over the decoding process is required.
 *
 * @param  bytes
 *         The bytes to be decoded into characters
 *
 * @since  JDK1.1
 * @apiSince 1
 */

public String(byte[] bytes) { throw new RuntimeException("Stub!"); }

/**
 * Allocates a new string that contains the sequence of characters
 * currently contained in the string buffer argument. The contents of the
 * string buffer are copied; subsequent modification of the string buffer
 * does not affect the newly created string.
 *
 * @param  buffer
 *         A {@code StringBuffer}
 * @apiSince 1
 */

public String(@androidx.annotation.NonNull java.lang.StringBuffer buffer) { throw new RuntimeException("Stub!"); }

/**
 * Allocates a new string that contains the sequence of characters
 * currently contained in the string builder argument. The contents of the
 * string builder are copied; subsequent modification of the string builder
 * does not affect the newly created string.
 *
 * <p> This constructor is provided to ease migration to {@code
 * StringBuilder}. Obtaining a string from a string builder via the {@code
 * toString} method is likely to run faster and is generally preferred.
 *
 * @param   builder
 *          A {@code StringBuilder}
 *
 * @since  1.5
 * @apiSince 1
 */

public String(@androidx.annotation.NonNull java.lang.StringBuilder builder) { throw new RuntimeException("Stub!"); }

/**
 * Returns the length of this string.
 * The length is equal to the number of <a href="Character.html#unicode">Unicode
 * code units</a> in the string.
 *
 * @return  the length of the sequence of characters represented by this
 *          object.
 * @apiSince 1
 */

public int length() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if, and only if, {@link #length()} is {@code 0}.
 *
 * @return {@code true} if {@link #length()} is {@code 0}, otherwise
 * {@code false}
 *
 * @since 1.6
 * @apiSince 9
 */

public boolean isEmpty() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@code char} value at the
 * specified index. An index ranges from {@code 0} to
 * {@code length() - 1}. The first {@code char} value of the sequence
 * is at index {@code 0}, the next at index {@code 1},
 * and so on, as for array indexing.
 *
 * <p>If the {@code char} value specified by the index is a
 * <a href="Character.html#unicode">surrogate</a>, the surrogate
 * value is returned.
 *
 * @param      index   the index of the {@code char} value.
 * @return     the {@code char} value at the specified index of this string.
 *             The first {@code char} value is at index {@code 0}.
 * @exception  java.lang.IndexOutOfBoundsException  if the {@code index}
 *             argument is negative or not less than the length of this
 *             string.
 * @apiSince 1
 */

public native char charAt(int index);

/**
 * Returns the character (Unicode code point) at the specified
 * index. The index refers to {@code char} values
 * (Unicode code units) and ranges from {@code 0} to
 * {@link #length()}{@code  - 1}.
 *
 * <p> If the {@code char} value specified at the given index
 * is in the high-surrogate range, the following index is less
 * than the length of this {@code String}, and the
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
 *             string.
 * @since      1.5
 * @apiSince 1
 */

public int codePointAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns the character (Unicode code point) before the specified
 * index. The index refers to {@code char} values
 * (Unicode code units) and ranges from {@code 1} to {@link java.lang.CharSequence#length() CharSequence#length()}.
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
 *            of this string.
 * @since     1.5
 * @apiSince 1
 */

public int codePointBefore(int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of Unicode code points in the specified text
 * range of this {@code String}. The text range begins at the
 * specified {@code beginIndex} and extends to the
 * {@code char} at index {@code endIndex - 1}. Thus the
 * length (in {@code char}s) of the text range is
 * {@code endIndex-beginIndex}. Unpaired surrogates within
 * the text range count as one code point each.
 *
 * @param beginIndex the index to the first {@code char} of
 * the text range.
 * @param endIndex the index after the last {@code char} of
 * the text range.
 * @return the number of Unicode code points in the specified text
 * range
 * @exception java.lang.IndexOutOfBoundsException if the
 * {@code beginIndex} is negative, or {@code endIndex}
 * is larger than the length of this {@code String}, or
 * {@code beginIndex} is larger than {@code endIndex}.
 * @since  1.5
 * @apiSince 1
 */

public int codePointCount(int beginIndex, int endIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns the index within this {@code String} that is
 * offset from the given {@code index} by
 * {@code codePointOffset} code points. Unpaired surrogates
 * within the text range given by {@code index} and
 * {@code codePointOffset} count as one code point each.
 *
 * @param index the index to be offset
 * @param codePointOffset the offset in code points
 * @return the index within this {@code String}
 * @exception java.lang.IndexOutOfBoundsException if {@code index}
 *   is negative or larger then the length of this
 *   {@code String}, or if {@code codePointOffset} is positive
 *   and the substring starting with {@code index} has fewer
 *   than {@code codePointOffset} code points,
 *   or if {@code codePointOffset} is negative and the substring
 *   before {@code index} has fewer than the absolute value
 *   of {@code codePointOffset} code points.
 * @since 1.5
 * @apiSince 1
 */

public int offsetByCodePoints(int index, int codePointOffset) { throw new RuntimeException("Stub!"); }

/**
 * Copies characters from this string into the destination character
 * array.
 * <p>
 * The first character to be copied is at index {@code srcBegin};
 * the last character to be copied is at index {@code srcEnd-1}
 * (thus the total number of characters to be copied is
 * {@code srcEnd-srcBegin}). The characters are copied into the
 * subarray of {@code dst} starting at index {@code dstBegin}
 * and ending at index:
 * <blockquote><pre>
 *     dstBegin + (srcEnd-srcBegin) - 1
 * </pre></blockquote>
 *
 * @param      srcBegin   index of the first character in the string
 *                        to copy.
 * @param      srcEnd     index after the last character in the string
 *                        to copy.
 * @param      dst        the destination array.
 * @param      dstBegin   the start offset in the destination array.
 * @exception java.lang.IndexOutOfBoundsException If any of the following
 *            is true:
 *            <ul><li>{@code srcBegin} is negative.
 *            <li>{@code srcBegin} is greater than {@code srcEnd}
 *            <li>{@code srcEnd} is greater than the length of this
 *                string
 *            <li>{@code dstBegin} is negative
 *            <li>{@code dstBegin+(srcEnd-srcBegin)} is larger than
 *                {@code dst.length}</ul>
 * @apiSince 1
 */

public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) { throw new RuntimeException("Stub!"); }

/**
 * Copies characters from this string into the destination byte array. Each
 * byte receives the 8 low-order bits of the corresponding character. The
 * eight high-order bits of each character are not copied and do not
 * participate in the transfer in any way.
 *
 * <p> The first character to be copied is at index {@code srcBegin}; the
 * last character to be copied is at index {@code srcEnd-1}.  The total
 * number of characters to be copied is {@code srcEnd-srcBegin}. The
 * characters, converted to bytes, are copied into the subarray of {@code
 * dst} starting at index {@code dstBegin} and ending at index:
 *
 * <blockquote><pre>
 *     dstBegin + (srcEnd-srcBegin) - 1
 * </pre></blockquote>
 *
 * @deprecated  This method does not properly convert characters into
 * bytes.  As of JDK&nbsp;1.1, the preferred way to do this is via the
 * {@link #getBytes()} method, which uses the platform's default charset.
 *
 * @param  srcBegin
 *         Index of the first character in the string to copy
 *
 * @param  srcEnd
 *         Index after the last character in the string to copy
 *
 * @param  dst
 *         The destination array
 *
 * @param  dstBegin
 *         The start offset in the destination array
 *
 * @throws  java.lang.IndexOutOfBoundsException
 *          If any of the following is true:
 *          <ul>
 *            <li> {@code srcBegin} is negative
 *            <li> {@code srcBegin} is greater than {@code srcEnd}
 *            <li> {@code srcEnd} is greater than the length of this String
 *            <li> {@code dstBegin} is negative
 *            <li> {@code dstBegin+(srcEnd-srcBegin)} is larger than {@code
 *                 dst.length}
 *          </ul>
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public void getBytes(int srcBegin, int srcEnd, byte[] dst, int dstBegin) { throw new RuntimeException("Stub!"); }

/**
 * Encodes this {@code String} into a sequence of bytes using the named
 * charset, storing the result into a new byte array.
 *
 * <p> The behavior of this method when this string cannot be encoded in
 * the given charset is unspecified.  The {@link
 * java.nio.charset.CharsetEncoder} class should be used when more control
 * over the encoding process is required.
 *
 * @param  charsetName
 *         The name of a supported {@linkplain java.nio.charset.Charset
 *         charset}
 *
 * @return  The resultant byte array
 *
 * @throws  java.io.UnsupportedEncodingException
 *          If the named charset is not supported
 *
 * @since  JDK1.1
 * @apiSince 1
 */

public byte[] getBytes(@androidx.annotation.NonNull java.lang.String charsetName) throws java.io.UnsupportedEncodingException { throw new RuntimeException("Stub!"); }

/**
 * Encodes this {@code String} into a sequence of bytes using the given
 * {@linkplain java.nio.charset.Charset charset}, storing the result into a
 * new byte array.
 *
 * <p> This method always replaces malformed-input and unmappable-character
 * sequences with this charset's default replacement byte array.  The
 * {@link java.nio.charset.CharsetEncoder} class should be used when more
 * control over the encoding process is required.
 *
 * @param  charset
 *         The {@linkplain java.nio.charset.Charset} to be used to encode
 *         the {@code String}
 *
 * @return  The resultant byte array
 *
 * @since  1.6
 * @apiSince 9
 */

public byte[] getBytes(@androidx.annotation.NonNull java.nio.charset.Charset charset) { throw new RuntimeException("Stub!"); }

/**
 * Encodes this {@code String} into a sequence of bytes using the
 * platform's default charset, storing the result into a new byte array.
 *
 * <p> The behavior of this method when this string cannot be encoded in
 * the default charset is unspecified.  The {@link
 * java.nio.charset.CharsetEncoder} class should be used when more control
 * over the encoding process is required.
 *
 * @return  The resultant byte array
 *
 * @since      JDK1.1
 * @apiSince 1
 */

public byte[] getBytes() { throw new RuntimeException("Stub!"); }

/**
 * Compares this string to the specified object.  The result is {@code
 * true} if and only if the argument is not {@code null} and is a {@code
 * String} object that represents the same sequence of characters as this
 * object.
 *
 * @param  anObject
 *         The object to compare this {@code String} against
 *
 * @return  {@code true} if the given object represents a {@code String}
 *          equivalent to this string, {@code false} otherwise
 *
 * @see  #compareTo(String)
 * @see  #equalsIgnoreCase(String)
 * @apiSince 1
 */

public boolean equals(@androidx.annotation.Nullable java.lang.Object anObject) { throw new RuntimeException("Stub!"); }

/**
 * Compares this string to the specified {@code StringBuffer}.  The result
 * is {@code true} if and only if this {@code String} represents the same
 * sequence of characters as the specified {@code StringBuffer}. This method
 * synchronizes on the {@code StringBuffer}.
 *
 * @param  sb
 *         The {@code StringBuffer} to compare this {@code String} against
 *
 * @return  {@code true} if this {@code String} represents the same
 *          sequence of characters as the specified {@code StringBuffer},
 *          {@code false} otherwise
 *
 * @since  1.4
 * @apiSince 1
 */

public boolean contentEquals(@androidx.annotation.NonNull java.lang.StringBuffer sb) { throw new RuntimeException("Stub!"); }

/**
 * Compares this string to the specified {@code CharSequence}.  The
 * result is {@code true} if and only if this {@code String} represents the
 * same sequence of char values as the specified sequence. Note that if the
 * {@code CharSequence} is a {@code StringBuffer} then the method
 * synchronizes on it.
 *
 * @param  cs
 *         The sequence to compare this {@code String} against
 *
 * @return  {@code true} if this {@code String} represents the same
 *          sequence of char values as the specified sequence, {@code
 *          false} otherwise
 *
 * @since  1.5
 * @apiSince 1
 */

public boolean contentEquals(@androidx.annotation.NonNull java.lang.CharSequence cs) { throw new RuntimeException("Stub!"); }

/**
 * Compares this {@code String} to another {@code String}, ignoring case
 * considerations.  Two strings are considered equal ignoring case if they
 * are of the same length and corresponding characters in the two strings
 * are equal ignoring case.
 *
 * <p> Two characters {@code c1} and {@code c2} are considered the same
 * ignoring case if at least one of the following is true:
 * <ul>
 *   <li> The two characters are the same (as compared by the
 *        {@code ==} operator)
 *   <li> Applying the method {@link
 *        java.lang.Character#toUpperCase(char)} to each character
 *        produces the same result
 *   <li> Applying the method {@link
 *        java.lang.Character#toLowerCase(char)} to each character
 *        produces the same result
 * </ul>
 *
 * @param  anotherString
 *         The {@code String} to compare this {@code String} against
 *
 * @return  {@code true} if the argument is not {@code null} and it
 *          represents an equivalent {@code String} ignoring case; {@code
 *          false} otherwise
 *
 * @see  #equals(Object)
 * @apiSince 1
 */

public boolean equalsIgnoreCase(@androidx.annotation.Nullable java.lang.String anotherString) { throw new RuntimeException("Stub!"); }

/**
 * Compares two strings lexicographically.
 * The comparison is based on the Unicode value of each character in
 * the strings. The character sequence represented by this
 * {@code String} object is compared lexicographically to the
 * character sequence represented by the argument string. The result is
 * a negative integer if this {@code String} object
 * lexicographically precedes the argument string. The result is a
 * positive integer if this {@code String} object lexicographically
 * follows the argument string. The result is zero if the strings
 * are equal; {@code compareTo} returns {@code 0} exactly when
 * the {@link #equals(java.lang.Object)} method would return {@code true}.
 * <p>
 * This is the definition of lexicographic ordering. If two strings are
 * different, then either they have different characters at some index
 * that is a valid index for both strings, or their lengths are different,
 * or both. If they have different characters at one or more index
 * positions, let <i>k</i> be the smallest such index; then the string
 * whose character at position <i>k</i> has the smaller value, as
 * determined by using the &lt; operator, lexicographically precedes the
 * other string. In this case, {@code compareTo} returns the
 * difference of the two character values at position {@code k} in
 * the two string -- that is, the value:
 * <blockquote><pre>
 * this.charAt(k)-anotherString.charAt(k)
 * </pre></blockquote>
 * If there is no index position at which they differ, then the shorter
 * string lexicographically precedes the longer string. In this case,
 * {@code compareTo} returns the difference of the lengths of the
 * strings -- that is, the value:
 * <blockquote><pre>
 * this.length()-anotherString.length()
 * </pre></blockquote>
 *
 * @param   anotherString   the {@code String} to be compared.
 * @return  the value {@code 0} if the argument string is equal to
 *          this string; a value less than {@code 0} if this string
 *          is lexicographically less than the string argument; and a
 *          value greater than {@code 0} if this string is
 *          lexicographically greater than the string argument.
 * @apiSince 1
 */

public native int compareTo(@androidx.annotation.NonNull java.lang.String anotherString);

/**
 * Compares two strings lexicographically, ignoring case
 * differences. This method returns an integer whose sign is that of
 * calling {@code compareTo} with normalized versions of the strings
 * where case differences have been eliminated by calling
 * {@code Character.toLowerCase(Character.toUpperCase(character))} on
 * each character.
 * <p>
 * Note that this method does <em>not</em> take locale into account,
 * and will result in an unsatisfactory ordering for certain locales.
 * The java.text package provides <em>collators</em> to allow
 * locale-sensitive ordering.
 *
 * @param   str   the {@code String} to be compared.
 * @return  a negative integer, zero, or a positive integer as the
 *          specified String is greater than, equal to, or less
 *          than this String, ignoring case considerations.
 * @see     java.text.Collator#compare(String, String)
 * @since   1.2
 * @apiSince 1
 */

public int compareToIgnoreCase(@androidx.annotation.NonNull java.lang.String str) { throw new RuntimeException("Stub!"); }

/**
 * Tests if two string regions are equal.
 * <p>
 * A substring of this {@code String} object is compared to a substring
 * of the argument other. The result is true if these substrings
 * represent identical character sequences. The substring of this
 * {@code String} object to be compared begins at index {@code toffset}
 * and has length {@code len}. The substring of other to be compared
 * begins at index {@code ooffset} and has length {@code len}. The
 * result is {@code false} if and only if at least one of the following
 * is true:
 * <ul><li>{@code toffset} is negative.
 * <li>{@code ooffset} is negative.
 * <li>{@code toffset+len} is greater than the length of this
 * {@code String} object.
 * <li>{@code ooffset+len} is greater than the length of the other
 * argument.
 * <li>There is some nonnegative integer <i>k</i> less than {@code len}
 * such that:
 * {@code this.charAt(toffset + }<i>k</i>{@code ) != other.charAt(ooffset + }
 * <i>k</i>{@code )}
 * </ul>
 *
 * @param   toffset   the starting offset of the subregion in this string.
 * @param   other     the string argument.
 * @param   ooffset   the starting offset of the subregion in the string
 *                    argument.
 * @param   len       the number of characters to compare.
 * @return  {@code true} if the specified subregion of this string
 *          exactly matches the specified subregion of the string argument;
 *          {@code false} otherwise.
 * @apiSince 1
 */

public boolean regionMatches(int toffset, @androidx.annotation.NonNull java.lang.String other, int ooffset, int len) { throw new RuntimeException("Stub!"); }

/**
 * Tests if two string regions are equal.
 * <p>
 * A substring of this {@code String} object is compared to a substring
 * of the argument {@code other}. The result is {@code true} if these
 * substrings represent character sequences that are the same, ignoring
 * case if and only if {@code ignoreCase} is true. The substring of
 * this {@code String} object to be compared begins at index
 * {@code toffset} and has length {@code len}. The substring of
 * {@code other} to be compared begins at index {@code ooffset} and
 * has length {@code len}. The result is {@code false} if and only if
 * at least one of the following is true:
 * <ul><li>{@code toffset} is negative.
 * <li>{@code ooffset} is negative.
 * <li>{@code toffset+len} is greater than the length of this
 * {@code String} object.
 * <li>{@code ooffset+len} is greater than the length of the other
 * argument.
 * <li>{@code ignoreCase} is {@code false} and there is some nonnegative
 * integer <i>k</i> less than {@code len} such that:
 * <blockquote><pre>
 * this.charAt(toffset+k) != other.charAt(ooffset+k)
 * </pre></blockquote>
 * <li>{@code ignoreCase} is {@code true} and there is some nonnegative
 * integer <i>k</i> less than {@code len} such that:
 * <blockquote><pre>
 * Character.toLowerCase(this.charAt(toffset+k)) !=
 Character.toLowerCase(other.charAt(ooffset+k))
 * </pre></blockquote>
 * and:
 * <blockquote><pre>
 * Character.toUpperCase(this.charAt(toffset+k)) !=
 *         Character.toUpperCase(other.charAt(ooffset+k))
 * </pre></blockquote>
 * </ul>
 *
 * @param   ignoreCase   if {@code true}, ignore case when comparing
 *                       characters.
 * @param   toffset      the starting offset of the subregion in this
 *                       string.
 * @param   other        the string argument.
 * @param   ooffset      the starting offset of the subregion in the string
 *                       argument.
 * @param   len          the number of characters to compare.
 * @return  {@code true} if the specified subregion of this string
 *          matches the specified subregion of the string argument;
 *          {@code false} otherwise. Whether the matching is exact
 *          or case insensitive depends on the {@code ignoreCase}
 *          argument.
 * @apiSince 1
 */

public boolean regionMatches(boolean ignoreCase, int toffset, @androidx.annotation.NonNull java.lang.String other, int ooffset, int len) { throw new RuntimeException("Stub!"); }

/**
 * Tests if the substring of this string beginning at the
 * specified index starts with the specified prefix.
 *
 * @param   prefix    the prefix.
 * @param   toffset   where to begin looking in this string.
 * @return  {@code true} if the character sequence represented by the
 *          argument is a prefix of the substring of this object starting
 *          at index {@code toffset}; {@code false} otherwise.
 *          The result is {@code false} if {@code toffset} is
 *          negative or greater than the length of this
 *          {@code String} object; otherwise the result is the same
 *          as the result of the expression
 *          <pre>
 *          this.substring(toffset).startsWith(prefix)
 *          </pre>
 * @apiSince 1
 */

public boolean startsWith(@androidx.annotation.NonNull java.lang.String prefix, int toffset) { throw new RuntimeException("Stub!"); }

/**
 * Tests if this string starts with the specified prefix.
 *
 * @param   prefix   the prefix.
 * @return  {@code true} if the character sequence represented by the
 *          argument is a prefix of the character sequence represented by
 *          this string; {@code false} otherwise.
 *          Note also that {@code true} will be returned if the
 *          argument is an empty string or is equal to this
 *          {@code String} object as determined by the
 *          {@link #equals(java.lang.Object)} method.
 * @since   1. 0
 * @apiSince 1
 */

public boolean startsWith(@androidx.annotation.NonNull java.lang.String prefix) { throw new RuntimeException("Stub!"); }

/**
 * Tests if this string ends with the specified suffix.
 *
 * @param   suffix   the suffix.
 * @return  {@code true} if the character sequence represented by the
 *          argument is a suffix of the character sequence represented by
 *          this object; {@code false} otherwise. Note that the
 *          result will be {@code true} if the argument is the
 *          empty string or is equal to this {@code String} object
 *          as determined by the {@link #equals(java.lang.Object)} method.
 * @apiSince 1
 */

public boolean endsWith(@androidx.annotation.NonNull java.lang.String suffix) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code for this string. The hash code for a
 * {@code String} object is computed as
 * <blockquote><pre>
 * s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
 * </pre></blockquote>
 * using {@code int} arithmetic, where {@code s[i]} is the
 * <i>i</i>th character of the string, {@code n} is the length of
 * the string, and {@code ^} indicates exponentiation.
 * (The hash value of the empty string is zero.)
 *
 * @return  a hash code value for this object.
 * @apiSince 1
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns the index within this string of the first occurrence of
 * the specified character. If a character with value
 * {@code ch} occurs in the character sequence represented by
 * this {@code String} object, then the index (in Unicode
 * code units) of the first such occurrence is returned. For
 * values of {@code ch} in the range from 0 to 0xFFFF
 * (inclusive), this is the smallest value <i>k</i> such that:
 * <blockquote><pre>
 * this.charAt(<i>k</i>) == ch
 * </pre></blockquote>
 * is true. For other values of {@code ch}, it is the
 * smallest value <i>k</i> such that:
 * <blockquote><pre>
 * this.codePointAt(<i>k</i>) == ch
 * </pre></blockquote>
 * is true. In either case, if no such character occurs in this
 * string, then {@code -1} is returned.
 *
 * @param   ch   a character (Unicode code point).
 * @return  the index of the first occurrence of the character in the
 *          character sequence represented by this object, or
 *          {@code -1} if the character does not occur.
 * @apiSince 1
 */

public int indexOf(int ch) { throw new RuntimeException("Stub!"); }

/**
 * Returns the index within this string of the first occurrence of the
 * specified character, starting the search at the specified index.
 * <p>
 * If a character with value {@code ch} occurs in the
 * character sequence represented by this {@code String}
 * object at an index no smaller than {@code fromIndex}, then
 * the index of the first such occurrence is returned. For values
 * of {@code ch} in the range from 0 to 0xFFFF (inclusive),
 * this is the smallest value <i>k</i> such that:
 * <blockquote><pre>
 * (this.charAt(<i>k</i>) == ch) {@code &&} (<i>k</i> &gt;= fromIndex)
 * </pre></blockquote>
 * is true. For other values of {@code ch}, it is the
 * smallest value <i>k</i> such that:
 * <blockquote><pre>
 * (this.codePointAt(<i>k</i>) == ch) {@code &&} (<i>k</i> &gt;= fromIndex)
 * </pre></blockquote>
 * is true. In either case, if no such character occurs in this
 * string at or after position {@code fromIndex}, then
 * {@code -1} is returned.
 *
 * <p>
 * There is no restriction on the value of {@code fromIndex}. If it
 * is negative, it has the same effect as if it were zero: this entire
 * string may be searched. If it is greater than the length of this
 * string, it has the same effect as if it were equal to the length of
 * this string: {@code -1} is returned.
 *
 * <p>All indices are specified in {@code char} values
 * (Unicode code units).
 *
 * @param   ch          a character (Unicode code point).
 * @param   fromIndex   the index to start the search from.
 * @return  the index of the first occurrence of the character in the
 *          character sequence represented by this object that is greater
 *          than or equal to {@code fromIndex}, or {@code -1}
 *          if the character does not occur.
 * @apiSince 1
 */

public int indexOf(int ch, int fromIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns the index within this string of the last occurrence of
 * the specified character. For values of {@code ch} in the
 * range from 0 to 0xFFFF (inclusive), the index (in Unicode code
 * units) returned is the largest value <i>k</i> such that:
 * <blockquote><pre>
 * this.charAt(<i>k</i>) == ch
 * </pre></blockquote>
 * is true. For other values of {@code ch}, it is the
 * largest value <i>k</i> such that:
 * <blockquote><pre>
 * this.codePointAt(<i>k</i>) == ch
 * </pre></blockquote>
 * is true.  In either case, if no such character occurs in this
 * string, then {@code -1} is returned.  The
 * {@code String} is searched backwards starting at the last
 * character.
 *
 * @param   ch   a character (Unicode code point).
 * @return  the index of the last occurrence of the character in the
 *          character sequence represented by this object, or
 *          {@code -1} if the character does not occur.
 * @apiSince 1
 */

public int lastIndexOf(int ch) { throw new RuntimeException("Stub!"); }

/**
 * Returns the index within this string of the last occurrence of
 * the specified character, searching backward starting at the
 * specified index. For values of {@code ch} in the range
 * from 0 to 0xFFFF (inclusive), the index returned is the largest
 * value <i>k</i> such that:
 * <blockquote><pre>
 * (this.charAt(<i>k</i>) == ch) {@code &&} (<i>k</i> &lt;= fromIndex)
 * </pre></blockquote>
 * is true. For other values of {@code ch}, it is the
 * largest value <i>k</i> such that:
 * <blockquote><pre>
 * (this.codePointAt(<i>k</i>) == ch) {@code &&} (<i>k</i> &lt;= fromIndex)
 * </pre></blockquote>
 * is true. In either case, if no such character occurs in this
 * string at or before position {@code fromIndex}, then
 * {@code -1} is returned.
 *
 * <p>All indices are specified in {@code char} values
 * (Unicode code units).
 *
 * @param   ch          a character (Unicode code point).
 * @param   fromIndex   the index to start the search from. There is no
 *          restriction on the value of {@code fromIndex}. If it is
 *          greater than or equal to the length of this string, it has
 *          the same effect as if it were equal to one less than the
 *          length of this string: this entire string may be searched.
 *          If it is negative, it has the same effect as if it were -1:
 *          -1 is returned.
 * @return  the index of the last occurrence of the character in the
 *          character sequence represented by this object that is less
 *          than or equal to {@code fromIndex}, or {@code -1}
 *          if the character does not occur before that point.
 * @apiSince 1
 */

public int lastIndexOf(int ch, int fromIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns the index within this string of the first occurrence of the
 * specified substring.
 *
 * <p>The returned index is the smallest value <i>k</i> for which:
 * <blockquote><pre>
 * this.startsWith(str, <i>k</i>)
 * </pre></blockquote>
 * If no such value of <i>k</i> exists, then {@code -1} is returned.
 *
 * @param   str   the substring to search for.
 * @return  the index of the first occurrence of the specified substring,
 *          or {@code -1} if there is no such occurrence.
 * @apiSince 1
 */

public int indexOf(@androidx.annotation.NonNull java.lang.String str) { throw new RuntimeException("Stub!"); }

/**
 * Returns the index within this string of the first occurrence of the
 * specified substring, starting at the specified index.
 *
 * <p>The returned index is the smallest value <i>k</i> for which:
 * <blockquote><pre>
 * <i>k</i> &gt;= fromIndex {@code &&} this.startsWith(str, <i>k</i>)
 * </pre></blockquote>
 * If no such value of <i>k</i> exists, then {@code -1} is returned.
 *
 * @param   str         the substring to search for.
 * @param   fromIndex   the index from which to start the search.
 * @return  the index of the first occurrence of the specified substring,
 *          starting at the specified index,
 *          or {@code -1} if there is no such occurrence.
 * @apiSince 1
 */

public int indexOf(@androidx.annotation.NonNull java.lang.String str, int fromIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns the index within this string of the last occurrence of the
 * specified substring.  The last occurrence of the empty string ""
 * is considered to occur at the index value {@code this.length()}.
 *
 * <p>The returned index is the largest value <i>k</i> for which:
 * <blockquote><pre>
 * this.startsWith(str, <i>k</i>)
 * </pre></blockquote>
 * If no such value of <i>k</i> exists, then {@code -1} is returned.
 *
 * @param   str   the substring to search for.
 * @return  the index of the last occurrence of the specified substring,
 *          or {@code -1} if there is no such occurrence.
 * @apiSince 1
 */

public int lastIndexOf(@androidx.annotation.NonNull java.lang.String str) { throw new RuntimeException("Stub!"); }

/**
 * Returns the index within this string of the last occurrence of the
 * specified substring, searching backward starting at the specified index.
 *
 * <p>The returned index is the largest value <i>k</i> for which:
 * <blockquote><pre>
 * <i>k</i> {@code <=} fromIndex {@code &&} this.startsWith(str, <i>k</i>)
 * </pre></blockquote>
 * If no such value of <i>k</i> exists, then {@code -1} is returned.
 *
 * @param   str         the substring to search for.
 * @param   fromIndex   the index to start the search from.
 * @return  the index of the last occurrence of the specified substring,
 *          searching backward from the specified index,
 *          or {@code -1} if there is no such occurrence.
 * @apiSince 1
 */

public int lastIndexOf(@androidx.annotation.NonNull java.lang.String str, int fromIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string that is a substring of this string. The
 * substring begins with the character at the specified index and
 * extends to the end of this string. <p>
 * Examples:
 * <blockquote><pre>
 * "unhappy".substring(2) returns "happy"
 * "Harbison".substring(3) returns "bison"
 * "emptiness".substring(9) returns "" (an empty string)
 * </pre></blockquote>
 *
 * @param      beginIndex   the beginning index, inclusive.
 * @return     the specified substring.
 * @exception  java.lang.IndexOutOfBoundsException  if
 *             {@code beginIndex} is negative or larger than the
 *             length of this {@code String} object.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String substring(int beginIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string that is a substring of this string. The
 * substring begins at the specified {@code beginIndex} and
 * extends to the character at index {@code endIndex - 1}.
 * Thus the length of the substring is {@code endIndex-beginIndex}.
 * <p>
 * Examples:
 * <blockquote><pre>
 * "hamburger".substring(4, 8) returns "urge"
 * "smiles".substring(1, 5) returns "mile"
 * </pre></blockquote>
 *
 * @param      beginIndex   the beginning index, inclusive.
 * @param      endIndex     the ending index, exclusive.
 * @return     the specified substring.
 * @exception  java.lang.IndexOutOfBoundsException  if the
 *             {@code beginIndex} is negative, or
 *             {@code endIndex} is larger than the length of
 *             this {@code String} object, or
 *             {@code beginIndex} is larger than
 *             {@code endIndex}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String substring(int beginIndex, int endIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns a character sequence that is a subsequence of this sequence.
 *
 * <p> An invocation of this method of the form
 *
 * <blockquote><pre>
 * str.subSequence(begin,&nbsp;end)</pre></blockquote>
 *
 * behaves in exactly the same way as the invocation
 *
 * <blockquote><pre>
 * str.substring(begin,&nbsp;end)</pre></blockquote>
 *
 * @apiNote
 * This method is defined so that the {@code String} class can implement
 * the {@link java.lang.CharSequence CharSequence} interface.
 *
 * @param   beginIndex   the begin index, inclusive.
 * @param   endIndex     the end index, exclusive.
 * @return  the specified subsequence.
 *
 * @throws  java.lang.IndexOutOfBoundsException
 *          if {@code beginIndex} or {@code endIndex} is negative,
 *          if {@code endIndex} is greater than {@code length()},
 *          or if {@code beginIndex} is greater than {@code endIndex}
 *
 * @since 1.4
 * @spec JSR-51
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.CharSequence subSequence(int beginIndex, int endIndex) { throw new RuntimeException("Stub!"); }

/**
 * Concatenates the specified string to the end of this string.
 * <p>
 * If the length of the argument string is {@code 0}, then this
 * {@code String} object is returned. Otherwise, a
 * {@code String} object is returned that represents a character
 * sequence that is the concatenation of the character sequence
 * represented by this {@code String} object and the character
 * sequence represented by the argument string.<p>
 * Examples:
 * <blockquote><pre>
 * "cares".concat("s") returns "caress"
 * "to".concat("get").concat("her") returns "together"
 * </pre></blockquote>
 *
 * @param   str   the {@code String} that is concatenated to the end
 *                of this {@code String}.
 * @return  a string that represents the concatenation of this object's
 *          characters followed by the string argument's characters.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public native java.lang.String concat(@androidx.annotation.NonNull java.lang.String str);

/**
 * Returns a string resulting from replacing all occurrences of
 * {@code oldChar} in this string with {@code newChar}.
 * <p>
 * If the character {@code oldChar} does not occur in the
 * character sequence represented by this {@code String} object,
 * then a reference to this {@code String} object is returned.
 * Otherwise, a {@code String} object is returned that
 * represents a character sequence identical to the character sequence
 * represented by this {@code String} object, except that every
 * occurrence of {@code oldChar} is replaced by an occurrence
 * of {@code newChar}.
 * <p>
 * Examples:
 * <blockquote><pre>
 * "mesquite in your cellar".replace('e', 'o')
 *         returns "mosquito in your collar"
 * "the war of baronets".replace('r', 'y')
 *         returns "the way of bayonets"
 * "sparring with a purple porpoise".replace('p', 't')
 *         returns "starring with a turtle tortoise"
 * "JonL".replace('q', 'x') returns "JonL" (no change)
 * </pre></blockquote>
 *
 * @param   oldChar   the old character.
 * @param   newChar   the new character.
 * @return  a string derived from this string by replacing every
 *          occurrence of {@code oldChar} with {@code newChar}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String replace(char oldChar, char newChar) { throw new RuntimeException("Stub!"); }

/**
 * Tells whether or not this string matches the given <a
 * href="../util/regex/Pattern.html#sum">regular expression</a>.
 *
 * <p> An invocation of this method of the form
 * <i>str</i>{@code .matches(}<i>regex</i>{@code )} yields exactly the
 * same result as the expression
 *
 * <blockquote>
 * {@link java.util.regex.Pattern}.{@link java.util.regex.Pattern#matches(String,CharSequence)
 * matches(<i>regex</i>, <i>str</i>)}
 * </blockquote>
 *
 * @param   regex
 *          the regular expression to which this string is to be matched
 *
 * @return  {@code true} if, and only if, this string matches the
 *          given regular expression
 *
 * @throws  java.util.regex.PatternSyntaxException
 *          if the regular expression's syntax is invalid
 *
 * @see java.util.regex.Pattern
 *
 * @since 1.4
 * @spec JSR-51
 * @apiSince 1
 */

public boolean matches(@androidx.annotation.NonNull java.lang.String regex) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if and only if this string contains the specified
 * sequence of char values.
 *
 * @param s the sequence to search for
 * @return true if this string contains {@code s}, false otherwise
 * @since 1.5
 * @apiSince 1
 */

public boolean contains(@androidx.annotation.NonNull java.lang.CharSequence s) { throw new RuntimeException("Stub!"); }

/**
 * Replaces the first substring of this string that matches the given <a
 * href="../util/regex/Pattern.html#sum">regular expression</a> with the
 * given replacement.
 *
 * <p> An invocation of this method of the form
 * <i>str</i>{@code .replaceFirst(}<i>regex</i>{@code ,} <i>repl</i>{@code )}
 * yields exactly the same result as the expression
 *
 * <blockquote>
 * <code>
 * {@link java.util.regex.Pattern}.{@link
 * java.util.regex.Pattern#compile compile}(<i>regex</i>).{@link
 * java.util.regex.Pattern#matcher(java.lang.CharSequence) matcher}(<i>str</i>).{@link
 * java.util.regex.Matcher#replaceFirst replaceFirst}(<i>repl</i>)
 * </code>
 * </blockquote>
 *
 *<p>
 * Note that backslashes ({@code \}) and dollar signs ({@code $}) in the
 * replacement string may cause the results to be different than if it were
 * being treated as a literal replacement string; see
 * {@link java.util.regex.Matcher#replaceFirst}.
 * Use {@link java.util.regex.Matcher#quoteReplacement} to suppress the special
 * meaning of these characters, if desired.
 *
 * @param   regex
 *          the regular expression to which this string is to be matched
 * @param   replacement
 *          the string to be substituted for the first match
 *
 * @return  The resulting {@code String}
 *
 * @throws  java.util.regex.PatternSyntaxException
 *          if the regular expression's syntax is invalid
 *
 * @see java.util.regex.Pattern
 *
 * @since 1.4
 * @spec JSR-51
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String replaceFirst(@androidx.annotation.NonNull java.lang.String regex, @androidx.annotation.NonNull java.lang.String replacement) { throw new RuntimeException("Stub!"); }

/**
 * Replaces each substring of this string that matches the given <a
 * href="../util/regex/Pattern.html#sum">regular expression</a> with the
 * given replacement.
 *
 * <p> An invocation of this method of the form
 * <i>str</i>{@code .replaceAll(}<i>regex</i>{@code ,} <i>repl</i>{@code )}
 * yields exactly the same result as the expression
 *
 * <blockquote>
 * <code>
 * {@link java.util.regex.Pattern}.{@link
 * java.util.regex.Pattern#compile compile}(<i>regex</i>).{@link
 * java.util.regex.Pattern#matcher(java.lang.CharSequence) matcher}(<i>str</i>).{@link
 * java.util.regex.Matcher#replaceAll replaceAll}(<i>repl</i>)
 * </code>
 * </blockquote>
 *
 *<p>
 * Note that backslashes ({@code \}) and dollar signs ({@code $}) in the
 * replacement string may cause the results to be different than if it were
 * being treated as a literal replacement string; see
 * {@link java.util.regex.Matcher#replaceAll Matcher.replaceAll}.
 * Use {@link java.util.regex.Matcher#quoteReplacement} to suppress the special
 * meaning of these characters, if desired.
 *
 * @param   regex
 *          the regular expression to which this string is to be matched
 * @param   replacement
 *          the string to be substituted for each match
 *
 * @return  The resulting {@code String}
 *
 * @throws  java.util.regex.PatternSyntaxException
 *          if the regular expression's syntax is invalid
 *
 * @see java.util.regex.Pattern
 *
 * @since 1.4
 * @spec JSR-51
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String replaceAll(@androidx.annotation.NonNull java.lang.String regex, @androidx.annotation.NonNull java.lang.String replacement) { throw new RuntimeException("Stub!"); }

/**
 * Replaces each substring of this string that matches the literal target
 * sequence with the specified literal replacement sequence. The
 * replacement proceeds from the beginning of the string to the end, for
 * example, replacing "aa" with "b" in the string "aaa" will result in
 * "ba" rather than "ab".
 *
 * @param  target The sequence of char values to be replaced
 * @param  replacement The replacement sequence of char values
 * @return  The resulting string
 * @since 1.5
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String replace(@androidx.annotation.NonNull java.lang.CharSequence target, @androidx.annotation.NonNull java.lang.CharSequence replacement) { throw new RuntimeException("Stub!"); }

/**
 * Splits this string around matches of the given
 * <a href="../util/regex/Pattern.html#sum">regular expression</a>.
 *
 * <p> The array returned by this method contains each substring of this
 * string that is terminated by another substring that matches the given
 * expression or is terminated by the end of the string.  The substrings in
 * the array are in the order in which they occur in this string.  If the
 * expression does not match any part of the input then the resulting array
 * has just one element, namely this string.
 *
 * <p> When there is a positive-width match at the beginning of this
 * string then an empty leading substring is included at the beginning
 * of the resulting array. A zero-width match at the beginning however
 * never produces such empty leading substring.
 *
 * <p> The {@code limit} parameter controls the number of times the
 * pattern is applied and therefore affects the length of the resulting
 * array.  If the limit <i>n</i> is greater than zero then the pattern
 * will be applied at most <i>n</i>&nbsp;-&nbsp;1 times, the array's
 * length will be no greater than <i>n</i>, and the array's last entry
 * will contain all input beyond the last matched delimiter.  If <i>n</i>
 * is non-positive then the pattern will be applied as many times as
 * possible and the array can have any length.  If <i>n</i> is zero then
 * the pattern will be applied as many times as possible, the array can
 * have any length, and trailing empty strings will be discarded.
 *
 * <p> The string {@code "boo:and:foo"}, for example, yields the
 * following results with these parameters:
 *
 * <blockquote><table cellpadding=1 cellspacing=0 summary="Split example showing regex, limit, and result">
 * <tr>
 *     <th>Regex</th>
 *     <th>Limit</th>
 *     <th>Result</th>
 * </tr>
 * <tr><td align=center>:</td>
 *     <td align=center>2</td>
 *     <td>{@code { "boo", "and:foo" }}</td></tr>
 * <tr><td align=center>:</td>
 *     <td align=center>5</td>
 *     <td>{@code { "boo", "and", "foo" }}</td></tr>
 * <tr><td align=center>:</td>
 *     <td align=center>-2</td>
 *     <td>{@code { "boo", "and", "foo" }}</td></tr>
 * <tr><td align=center>o</td>
 *     <td align=center>5</td>
 *     <td>{@code { "b", "", ":and:f", "", "" }}</td></tr>
 * <tr><td align=center>o</td>
 *     <td align=center>-2</td>
 *     <td>{@code { "b", "", ":and:f", "", "" }}</td></tr>
 * <tr><td align=center>o</td>
 *     <td align=center>0</td>
 *     <td>{@code { "b", "", ":and:f" }}</td></tr>
 * </table></blockquote>
 *
 * <p> An invocation of this method of the form
 * <i>str.</i>{@code split(}<i>regex</i>{@code ,}&nbsp;<i>n</i>{@code )}
 * yields the same result as the expression
 *
 * <blockquote>
 * <code>
 * {@link java.util.regex.Pattern}.{@link
 * java.util.regex.Pattern#compile compile}(<i>regex</i>).{@link
 * java.util.regex.Pattern#split(java.lang.CharSequence,int) split}(<i>str</i>,&nbsp;<i>n</i>)
 * </code>
 * </blockquote>
 *
 *
 * @param  regex
 *         the delimiting regular expression
 *
 * @param  limit
 *         the result threshold, as described above
 *
 * @return  the array of strings computed by splitting this string
 *          around matches of the given regular expression
 *
 * @throws  java.util.regex.PatternSyntaxException
 *          if the regular expression's syntax is invalid
 *
 * @see java.util.regex.Pattern
 *
 * @since 1.4
 * @spec JSR-51
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String[] split(@androidx.annotation.NonNull java.lang.String regex, int limit) { throw new RuntimeException("Stub!"); }

/**
 * Splits this string around matches of the given <a
 * href="../util/regex/Pattern.html#sum">regular expression</a>.
 *
 * <p> This method works as if by invoking the two-argument {@link
 * #split(java.lang.String,int) split} method with the given expression and a limit
 * argument of zero.  Trailing empty strings are therefore not included in
 * the resulting array.
 *
 * <p> The string {@code "boo:and:foo"}, for example, yields the following
 * results with these expressions:
 *
 * <blockquote><table cellpadding=1 cellspacing=0 summary="Split examples showing regex and result">
 * <tr>
 *  <th>Regex</th>
 *  <th>Result</th>
 * </tr>
 * <tr><td align=center>:</td>
 *     <td>{@code { "boo", "and", "foo" }}</td></tr>
 * <tr><td align=center>o</td>
 *     <td>{@code { "b", "", ":and:f" }}</td></tr>
 * </table></blockquote>
 *
 *
 * @param  regex
 *         the delimiting regular expression
 *
 * @return  the array of strings computed by splitting this string
 *          around matches of the given regular expression
 *
 * @throws  java.util.regex.PatternSyntaxException
 *          if the regular expression's syntax is invalid
 *
 * @see java.util.regex.Pattern
 *
 * @since 1.4
 * @spec JSR-51
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String[] split(@androidx.annotation.NonNull java.lang.String regex) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new String composed of copies of the
 * {@code CharSequence elements} joined together with a copy of
 * the specified {@code delimiter}.
 *
 * <blockquote>For example,
 * <pre>{@code
 *     String message = String.join("-", "Java", "is", "cool");
 *     // message returned is: "Java-is-cool"
 * }</pre></blockquote>
 *
 * Note that if an element is null, then {@code "null"} is added.
 *
 * @param  delimiter the delimiter that separates each element
 * @param  elements the elements to join together.
 *
 * @return a new {@code String} that is composed of the {@code elements}
 *         separated by the {@code delimiter}
 *
 * @throws java.lang.NullPointerException If {@code delimiter} or {@code elements}
 *         is {@code null}
 *
 * @see java.util.StringJoiner
 * @since 1.8
 * @apiSince 26
 */

@androidx.annotation.NonNull
public static java.lang.String join(@androidx.annotation.NonNull java.lang.CharSequence delimiter, @androidx.annotation.Nullable java.lang.CharSequence... elements) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code String} composed of copies of the
 * {@code CharSequence elements} joined together with a copy of the
 * specified {@code delimiter}.
 *
 * <blockquote>For example,
 * <pre>{@code
 *     List<String> strings = new LinkedList<>();
 *     strings.add("Java");strings.add("is");
 *     strings.add("cool");
 *     String message = String.join(" ", strings);
 *     //message returned is: "Java is cool"
 *
 *     Set<String> strings = new LinkedHashSet<>();
 *     strings.add("Java"); strings.add("is");
 *     strings.add("very"); strings.add("cool");
 *     String message = String.join("-", strings);
 *     //message returned is: "Java-is-very-cool"
 * }</pre></blockquote>
 *
 * Note that if an individual element is {@code null}, then {@code "null"} is added.
 *
 * @param  delimiter a sequence of characters that is used to separate each
 *         of the {@code elements} in the resulting {@code String}
 * @param  elements an {@code Iterable} that will have its {@code elements}
 *         joined together.
 *
 * @return a new {@code String} that is composed from the {@code elements}
 *         argument
 *
 * @throws java.lang.NullPointerException If {@code delimiter} or {@code elements}
 *         is {@code null}
 *
 * @see    #join(CharSequence,CharSequence...)
 * @see    java.util.StringJoiner
 * @since 1.8
 * @apiSince 26
 */

@androidx.annotation.NonNull
public static java.lang.String join(@androidx.annotation.NonNull java.lang.CharSequence delimiter, @androidx.annotation.NonNull java.lang.Iterable<? extends java.lang.CharSequence> elements) { throw new RuntimeException("Stub!"); }

/**
 * Converts all of the characters in this {@code String} to lower
 * case using the rules of the given {@code Locale}.  Case mapping is based
 * on the Unicode Standard version specified by the {@link java.lang.Character Character}
 * class. Since case mappings are not always 1:1 char mappings, the resulting
 * {@code String} may be a different length than the original {@code String}.
 * <p>
 * Examples of lowercase  mappings are in the following table:
 * <table border="1" summary="Lowercase mapping examples showing language code of locale, upper case, lower case, and description">
 * <tr>
 *   <th>Language Code of Locale</th>
 *   <th>Upper Case</th>
 *   <th>Lower Case</th>
 *   <th>Description</th>
 * </tr>
 * <tr>
 *   <td>tr (Turkish)</td>
 *   <td>&#92;u0130</td>
 *   <td>&#92;u0069</td>
 *   <td>capital letter I with dot above -&gt; small letter i</td>
 * </tr>
 * <tr>
 *   <td>tr (Turkish)</td>
 *   <td>&#92;u0049</td>
 *   <td>&#92;u0131</td>
 *   <td>capital letter I -&gt; small letter dotless i </td>
 * </tr>
 * <tr>
 *   <td>(all)</td>
 *   <td>French Fries</td>
 *   <td>french fries</td>
 *   <td>lowercased all chars in String</td>
 * </tr>
 * <tr>
 *   <td>(all)</td>
 *   <td><img src="doc-files/capiota.gif" alt="capiota"><img src="doc-files/capchi.gif" alt="capchi">
 *       <img src="doc-files/captheta.gif" alt="captheta"><img src="doc-files/capupsil.gif" alt="capupsil">
 *       <img src="doc-files/capsigma.gif" alt="capsigma"></td>
 *   <td><img src="doc-files/iota.gif" alt="iota"><img src="doc-files/chi.gif" alt="chi">
 *       <img src="doc-files/theta.gif" alt="theta"><img src="doc-files/upsilon.gif" alt="upsilon">
 *       <img src="doc-files/sigma1.gif" alt="sigma"></td>
 *   <td>lowercased all chars in String</td>
 * </tr>
 * </table>
 *
 * @param locale use the case transformation rules for this locale
 * @return the {@code String}, converted to lowercase.
 * @see     java.lang.String#toLowerCase()
 * @see     java.lang.String#toUpperCase()
 * @see     java.lang.String#toUpperCase(Locale)
 * @since   1.1
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String toLowerCase(@androidx.annotation.NonNull java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Converts all of the characters in this {@code String} to lower
 * case using the rules of the default locale. This is equivalent to calling
 * {@code toLowerCase(Locale.getDefault())}.
 * <p>
 * <b>Note:</b> This method is locale sensitive, and may produce unexpected
 * results if used for strings that are intended to be interpreted locale
 * independently.
 * Examples are programming language identifiers, protocol keys, and HTML
 * tags.
 * For instance, {@code "TITLE".toLowerCase()} in a Turkish locale
 * returns {@code "t\u005Cu0131tle"}, where '\u005Cu0131' is the
 * LATIN SMALL LETTER DOTLESS I character.
 * To obtain correct results for locale insensitive strings, use
 * {@code toLowerCase(Locale.ROOT)}.
 * <p>
 * @return  the {@code String}, converted to lowercase.
 * @see     java.lang.String#toLowerCase(Locale)
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String toLowerCase() { throw new RuntimeException("Stub!"); }

/**
 * Converts all of the characters in this {@code String} to upper
 * case using the rules of the given {@code Locale}. Case mapping is based
 * on the Unicode Standard version specified by the {@link java.lang.Character Character}
 * class. Since case mappings are not always 1:1 char mappings, the resulting
 * {@code String} may be a different length than the original {@code String}.
 * <p>
 * Examples of locale-sensitive and 1:M case mappings are in the following table.
 *
 * <table border="1" summary="Examples of locale-sensitive and 1:M case mappings. Shows Language code of locale, lower case, upper case, and description.">
 * <tr>
 *   <th>Language Code of Locale</th>
 *   <th>Lower Case</th>
 *   <th>Upper Case</th>
 *   <th>Description</th>
 * </tr>
 * <tr>
 *   <td>tr (Turkish)</td>
 *   <td>&#92;u0069</td>
 *   <td>&#92;u0130</td>
 *   <td>small letter i -&gt; capital letter I with dot above</td>
 * </tr>
 * <tr>
 *   <td>tr (Turkish)</td>
 *   <td>&#92;u0131</td>
 *   <td>&#92;u0049</td>
 *   <td>small letter dotless i -&gt; capital letter I</td>
 * </tr>
 * <tr>
 *   <td>(all)</td>
 *   <td>&#92;u00df</td>
 *   <td>&#92;u0053 &#92;u0053</td>
 *   <td>small letter sharp s -&gt; two letters: SS</td>
 * </tr>
 * <tr>
 *   <td>(all)</td>
 *   <td>Fahrvergn&uuml;gen</td>
 *   <td>FAHRVERGN&Uuml;GEN</td>
 *   <td></td>
 * </tr>
 * </table>
 * @param locale use the case transformation rules for this locale
 * @return the {@code String}, converted to uppercase.
 * @see     java.lang.String#toUpperCase()
 * @see     java.lang.String#toLowerCase()
 * @see     java.lang.String#toLowerCase(Locale)
 * @since   1.1
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String toUpperCase(@androidx.annotation.NonNull java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Converts all of the characters in this {@code String} to upper
 * case using the rules of the default locale. This method is equivalent to
 * {@code toUpperCase(Locale.getDefault())}.
 * <p>
 * <b>Note:</b> This method is locale sensitive, and may produce unexpected
 * results if used for strings that are intended to be interpreted locale
 * independently.
 * Examples are programming language identifiers, protocol keys, and HTML
 * tags.
 * For instance, {@code "title".toUpperCase()} in a Turkish locale
 * returns {@code "T\u005Cu0130TLE"}, where '\u005Cu0130' is the
 * LATIN CAPITAL LETTER I WITH DOT ABOVE character.
 * To obtain correct results for locale insensitive strings, use
 * {@code toUpperCase(Locale.ROOT)}.
 * <p>
 * @return  the {@code String}, converted to uppercase.
 * @see     java.lang.String#toUpperCase(Locale)
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String toUpperCase() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string whose value is this string, with any leading and trailing
 * whitespace removed.
 * <p>
 * If this {@code String} object represents an empty character
 * sequence, or the first and last characters of character sequence
 * represented by this {@code String} object both have codes
 * greater than {@code '\u005Cu0020'} (the space character), then a
 * reference to this {@code String} object is returned.
 * <p>
 * Otherwise, if there is no character with a code greater than
 * {@code '\u005Cu0020'} in the string, then a
 * {@code String} object representing an empty string is
 * returned.
 * <p>
 * Otherwise, let <i>k</i> be the index of the first character in the
 * string whose code is greater than {@code '\u005Cu0020'}, and let
 * <i>m</i> be the index of the last character in the string whose code
 * is greater than {@code '\u005Cu0020'}. A {@code String}
 * object is returned, representing the substring of this string that
 * begins with the character at index <i>k</i> and ends with the
 * character at index <i>m</i>-that is, the result of
 * {@code this.substring(k, m + 1)}.
 * <p>
 * This method may be used to trim whitespace (as defined above) from
 * the beginning and end of a string.
 *
 * @return  A string whose value is this string, with any leading and trailing white
 *          space removed, or this string if it has no leading or
 *          trailing white space.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String trim() { throw new RuntimeException("Stub!"); }

/**
 * This object (which is already a string!) is itself returned.
 *
 * @return  the string itself.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Converts this string to a new character array.
 *
 * @return  a newly allocated character array whose length is the length
 *          of this string and whose contents are initialized to contain
 *          the character sequence represented by this string.
 * @apiSince 1
 */

public native char[] toCharArray();

/**
 * Returns a formatted string using the specified format string and
 * arguments.
 *
 * <p> The locale always used is the one returned by {@link
 * java.util.Locale#getDefault() Locale.getDefault()}.
 *
 * @param  format
 *         A <a href="../util/Formatter.html#syntax">format string</a>
 *
 * @param  args
 *         Arguments referenced by the format specifiers in the format
 *         string.  If there are more arguments than format specifiers, the
 *         extra arguments are ignored.  The number of arguments is
 *         variable and may be zero.  The maximum number of arguments is
 *         limited by the maximum dimension of a Java array as defined by
 *         <cite>The Java&trade; Virtual Machine Specification</cite>.
 *         The behaviour on a
 *         {@code null} argument depends on the <a
 *         href="../util/Formatter.html#syntax">conversion</a>.
 *
 * @throws  java.util.IllegalFormatException
 *          If a format string contains an illegal syntax, a format
 *          specifier that is incompatible with the given arguments,
 *          insufficient arguments given the format string, or other
 *          illegal conditions.  For specification of all possible
 *          formatting errors, see the <a
 *          href="../util/Formatter.html#detail">Details</a> section of the
 *          formatter class specification.
 *
 * @return  A formatted string
 *
 * @see  java.util.Formatter
 * @since  1.5
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.String format(@androidx.annotation.NonNull java.lang.String format, @androidx.annotation.NonNull java.lang.Object... args) { throw new RuntimeException("Stub!"); }

/**
 * Returns a formatted string using the specified locale, format string,
 * and arguments.
 *
 * @param  l
 *         The {@linkplain java.util.Locale locale} to apply during
 *         formatting.  If {@code l} is {@code null} then no localization
 *         is applied.
 *
 * @param  format
 *         A <a href="../util/Formatter.html#syntax">format string</a>
 *
 * @param  args
 *         Arguments referenced by the format specifiers in the format
 *         string.  If there are more arguments than format specifiers, the
 *         extra arguments are ignored.  The number of arguments is
 *         variable and may be zero.  The maximum number of arguments is
 *         limited by the maximum dimension of a Java array as defined by
 *         <cite>The Java&trade; Virtual Machine Specification</cite>.
 *         The behaviour on a
 *         {@code null} argument depends on the
 *         <a href="../util/Formatter.html#syntax">conversion</a>.
 *
 * @throws  java.util.IllegalFormatException
 *          If a format string contains an illegal syntax, a format
 *          specifier that is incompatible with the given arguments,
 *          insufficient arguments given the format string, or other
 *          illegal conditions.  For specification of all possible
 *          formatting errors, see the <a
 *          href="../util/Formatter.html#detail">Details</a> section of the
 *          formatter class specification
 *
 * @return  A formatted string
 *
 * @see  java.util.Formatter
 * @since  1.5
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.String format(@androidx.annotation.NonNull java.util.Locale l, @androidx.annotation.NonNull java.lang.String format, @androidx.annotation.NonNull java.lang.Object... args) { throw new RuntimeException("Stub!"); }

/**
 * Returns the string representation of the {@code Object} argument.
 *
 * @param   obj   an {@code Object}.
 * @return  if the argument is {@code null}, then a string equal to
 *          {@code "null"}; otherwise, the value of
 *          {@code obj.toString()} is returned.
 * @see     java.lang.Object#toString()
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.String valueOf(@androidx.annotation.Nullable java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Returns the string representation of the {@code char} array
 * argument. The contents of the character array are copied; subsequent
 * modification of the character array does not affect the returned
 * string.
 *
 * @param   data     the character array.
 * @return  a {@code String} that contains the characters of the
 *          character array.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.String valueOf(char[] data) { throw new RuntimeException("Stub!"); }

/**
 * Returns the string representation of a specific subarray of the
 * {@code char} array argument.
 * <p>
 * The {@code offset} argument is the index of the first
 * character of the subarray. The {@code count} argument
 * specifies the length of the subarray. The contents of the subarray
 * are copied; subsequent modification of the character array does not
 * affect the returned string.
 *
 * @param   data     the character array.
 * @param   offset   initial offset of the subarray.
 * @param   count    length of the subarray.
 * @return  a {@code String} that contains the characters of the
 *          specified subarray of the character array.
 * @exception java.lang.IndexOutOfBoundsException if {@code offset} is
 *          negative, or {@code count} is negative, or
 *          {@code offset+count} is larger than
 *          {@code data.length}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.String valueOf(char[] data, int offset, int count) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to {@link #valueOf(char[],int,int)}.
 *
 * @param   data     the character array.
 * @param   offset   initial offset of the subarray.
 * @param   count    length of the subarray.
 * @return  a {@code String} that contains the characters of the
 *          specified subarray of the character array.
 * @exception java.lang.IndexOutOfBoundsException if {@code offset} is
 *          negative, or {@code count} is negative, or
 *          {@code offset+count} is larger than
 *          {@code data.length}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.String copyValueOf(char[] data, int offset, int count) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to {@link #valueOf(char[])}.
 *
 * @param   data   the character array.
 * @return  a {@code String} that contains the characters of the
 *          character array.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.String copyValueOf(char[] data) { throw new RuntimeException("Stub!"); }

/**
 * Returns the string representation of the {@code boolean} argument.
 *
 * @param   b   a {@code boolean}.
 * @return  if the argument is {@code true}, a string equal to
 *          {@code "true"} is returned; otherwise, a string equal to
 *          {@code "false"} is returned.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.String valueOf(boolean b) { throw new RuntimeException("Stub!"); }

/**
 * Returns the string representation of the {@code char}
 * argument.
 *
 * @param   c   a {@code char}.
 * @return  a string of length {@code 1} containing
 *          as its single character the argument {@code c}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.String valueOf(char c) { throw new RuntimeException("Stub!"); }

/**
 * Returns the string representation of the {@code int} argument.
 * <p>
 * The representation is exactly the one returned by the
 * {@code Integer.toString} method of one argument.
 *
 * @param   i   an {@code int}.
 * @return  a string representation of the {@code int} argument.
 * @see     java.lang.Integer#toString(int, int)
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.String valueOf(int i) { throw new RuntimeException("Stub!"); }

/**
 * Returns the string representation of the {@code long} argument.
 * <p>
 * The representation is exactly the one returned by the
 * {@code Long.toString} method of one argument.
 *
 * @param   l   a {@code long}.
 * @return  a string representation of the {@code long} argument.
 * @see     java.lang.Long#toString(long)
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.String valueOf(long l) { throw new RuntimeException("Stub!"); }

/**
 * Returns the string representation of the {@code float} argument.
 * <p>
 * The representation is exactly the one returned by the
 * {@code Float.toString} method of one argument.
 *
 * @param   f   a {@code float}.
 * @return  a string representation of the {@code float} argument.
 * @see     java.lang.Float#toString(float)
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.String valueOf(float f) { throw new RuntimeException("Stub!"); }

/**
 * Returns the string representation of the {@code double} argument.
 * <p>
 * The representation is exactly the one returned by the
 * {@code Double.toString} method of one argument.
 *
 * @param   d   a {@code double}.
 * @return  a  string representation of the {@code double} argument.
 * @see     java.lang.Double#toString(double)
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.String valueOf(double d) { throw new RuntimeException("Stub!"); }

/**
 * Returns a canonical representation for the string object.
 * <p>
 * A pool of strings, initially empty, is maintained privately by the
 * class {@code String}.
 * <p>
 * When the intern method is invoked, if the pool already contains a
 * string equal to this {@code String} object as determined by
 * the {@link #equals(java.lang.Object)} method, then the string from the pool is
 * returned. Otherwise, this {@code String} object is added to the
 * pool and a reference to this {@code String} object is returned.
 * <p>
 * It follows that for any two strings {@code s} and {@code t},
 * {@code s.intern() == t.intern()} is {@code true}
 * if and only if {@code s.equals(t)} is {@code true}.
 * <p>
 * All literal strings and string-valued constant expressions are
 * interned. String literals are defined in section 3.10.5 of the
 * <cite>The Java&trade; Language Specification</cite>.
 *
 * @return  a string that has the same contents as this string, but is
 *          guaranteed to be from a pool of unique strings.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public native java.lang.String intern();

/**
 * A Comparator that orders {@code String} objects as by
 * {@code compareToIgnoreCase}. This comparator is serializable.
 * <p>
 * Note that this Comparator does <em>not</em> take locale into account,
 * and will result in an unsatisfactory ordering for certain locales.
 * The java.text package provides <em>Collators</em> to allow
 * locale-sensitive ordering.
 *
 * @see     java.text.Collator#compare(String, String)
 * @since   1.2
 * @apiSince 1
 */

public static final java.util.Comparator<java.lang.String> CASE_INSENSITIVE_ORDER;
static { CASE_INSENSITIVE_ORDER = null; }
}

