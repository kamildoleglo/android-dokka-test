/*
 * Copyright (c) 2002, 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.util.Locale;
import java.util.Map;

/**
 * The {@code Character} class wraps a value of the primitive
 * type {@code char} in an object. An object of type
 * {@code Character} contains a single field whose type is
 * {@code char}.
 * <p>
 * In addition, this class provides several methods for determining
 * a character's category (lowercase letter, digit, etc.) and for converting
 * characters from uppercase to lowercase and vice versa.
 * <p>
 * Character information is based on the Unicode Standard
 * <p>
 * The methods and data of class {@code Character} are defined by
 * the information in the <i>UnicodeData</i> file that is part of the
 * Unicode Character Database maintained by the Unicode
 * Consortium. This file specifies various properties including name
 * and general category for every defined Unicode code point or
 * character range.
 * <p>
 * The file and its description are available from the Unicode Consortium at:
 * <ul>
 * <li><a href="http://www.unicode.org">http://www.unicode.org</a>
 * </ul>
 *
 * <h3><a name="unicode">Unicode Character Representations</a></h3>
 *
 * <p>The {@code char} data type (and therefore the value that a
 * {@code Character} object encapsulates) are based on the
 * original Unicode specification, which defined characters as
 * fixed-width 16-bit entities. The Unicode Standard has since been
 * changed to allow for characters whose representation requires more
 * than 16 bits.  The range of legal <em>code point</em>s is now
 * U+0000 to U+10FFFF, known as <em>Unicode scalar value</em>.
 * (Refer to the <a
 * href="http://www.unicode.org/reports/tr27/#notation"><i>
 * definition</i></a> of the U+<i>n</i> notation in the Unicode
 * Standard.)
 *
 * <p><a name="BMP">The set of characters from U+0000 to U+FFFF</a> is
 * sometimes referred to as the <em>Basic Multilingual Plane (BMP)</em>.
 * <a name="supplementary">Characters</a> whose code points are greater
 * than U+FFFF are called <em>supplementary character</em>s.  The Java
 * platform uses the UTF-16 representation in {@code char} arrays and
 * in the {@code String} and {@code StringBuffer} classes. In
 * this representation, supplementary characters are represented as a pair
 * of {@code char} values, the first from the <em>high-surrogates</em>
 * range, (&#92;uD800-&#92;uDBFF), the second from the
 * <em>low-surrogates</em> range (&#92;uDC00-&#92;uDFFF).
 *
 * <p>A {@code char} value, therefore, represents Basic
 * Multilingual Plane (BMP) code points, including the surrogate
 * code points, or code units of the UTF-16 encoding. An
 * {@code int} value represents all Unicode code points,
 * including supplementary code points. The lower (least significant)
 * 21 bits of {@code int} are used to represent Unicode code
 * points and the upper (most significant) 11 bits must be zero.
 * Unless otherwise specified, the behavior with respect to
 * supplementary characters and surrogate {@code char} values is
 * as follows:
 *
 * <ul>
 * <li>The methods that only accept a {@code char} value cannot support
 * supplementary characters. They treat {@code char} values from the
 * surrogate ranges as undefined characters. For example,
 * {@code Character.isLetter('\u005CuD840')} returns {@code false}, even though
 * this specific value if followed by any low-surrogate value in a string
 * would represent a letter.
 *
 * <li>The methods that accept an {@code int} value support all
 * Unicode characters, including supplementary characters. For
 * example, {@code Character.isLetter(0x2F81A)} returns
 * {@code true} because the code point value represents a letter
 * (a CJK ideograph).
 * </ul>
 *
 * <p>In the Java SE API documentation, <em>Unicode code point</em> is
 * used for character values in the range between U+0000 and U+10FFFF,
 * and <em>Unicode code unit</em> is used for 16-bit
 * {@code char} values that are code units of the <em>UTF-16</em>
 * encoding. For more information on Unicode terminology, refer to the
 * <a href="http://www.unicode.org/glossary/">Unicode Glossary</a>.
 *
 * @author  Lee Boynton
 * @author  Guy Steele
 * @author  Akira Tanaka
 * @author  Martin Buchholz
 * @author  Ulf Zibis
 * @since   1.0
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Character implements java.io.Serializable, java.lang.Comparable<java.lang.Character> {

/**
 * Constructs a newly allocated {@code Character} object that
 * represents the specified {@code char} value.
 *
 * @param  value   the value to be represented by the
 *                  {@code Character} object.
 * @apiSince 1
 */

public Character(char value) { throw new RuntimeException("Stub!"); }

/**
 * Returns a <tt>Character</tt> instance representing the specified
 * <tt>char</tt> value.
 * If a new <tt>Character</tt> instance is not required, this method
 * should generally be used in preference to the constructor
 * {@link #Character(char)}, as this method is likely to yield
 * significantly better space and time performance by caching
 * frequently requested values.
 *
 * This method will always cache values in the range {@code
 * '\u005Cu0000'} to {@code '\u005Cu007F'}, inclusive, and may
 * cache other values outside of this range.
 *
 * @param  c a char value.
 * @return a <tt>Character</tt> instance representing <tt>c</tt>.
 * @since  1.5
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.Character valueOf(char c) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of this {@code Character} object.
 * @return  the primitive {@code char} value represented by
 *          this object.
 * @apiSince 1
 */

public char charValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code for this {@code Character}; equal to the result
 * of invoking {@code charValue()}.
 *
 * @return a hash code value for this {@code Character}
 * @apiSince 1
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code for a {@code char} value; compatible with
 * {@code Character.hashCode()}.
 *
 * @since 1.8
 *
 * @param value The {@code char} for which to return a hash code.
 * @return a hash code value for a {@code char} value.
 * @apiSince 24
 */

public static int hashCode(char value) { throw new RuntimeException("Stub!"); }

/**
 * Compares this object against the specified object.
 * The result is {@code true} if and only if the argument is not
 * {@code null} and is a {@code Character} object that
 * represents the same {@code char} value as this object.
 *
 * @param   obj   the object to compare with.
 * @return  {@code true} if the objects are the same;
 *          {@code false} otherwise.
 * @apiSince 1
 */

public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code String} object representing this
 * {@code Character}'s value.  The result is a string of
 * length 1 whose sole component is the primitive
 * {@code char} value represented by this
 * {@code Character} object.
 *
 * @return  a string representation of this object.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code String} object representing the
 * specified {@code char}.  The result is a string of length
 * 1 consisting solely of the specified {@code char}.
 *
 * @param c the {@code char} to be converted
 * @return the string representation of the specified {@code char}
 * @since 1.4
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.String toString(char c) { throw new RuntimeException("Stub!"); }

/**
 * Determines whether the specified code point is a valid
 * <a href="http://www.unicode.org/glossary/#code_point">
 * Unicode code point value</a>.
 *
 * @param  codePoint the Unicode code point to be tested
 * @return {@code true} if the specified code point value is between
 *         {@link #MIN_CODE_POINT} and
 *         {@link #MAX_CODE_POINT} inclusive;
 *         {@code false} otherwise.
 * @since  1.5
 * @apiSince 1
 */

public static boolean isValidCodePoint(int codePoint) { throw new RuntimeException("Stub!"); }

/**
 * Determines whether the specified character (Unicode code point)
 * is in the <a href="#BMP">Basic Multilingual Plane (BMP)</a>.
 * Such code points can be represented using a single {@code char}.
 *
 * @param  codePoint the character (Unicode code point) to be tested
 * @return {@code true} if the specified code point is between
 *         {@link #MIN_VALUE} and {@link #MAX_VALUE} inclusive;
 *         {@code false} otherwise.
 * @since  1.7
 * @apiSince 19
 */

public static boolean isBmpCodePoint(int codePoint) { throw new RuntimeException("Stub!"); }

/**
 * Determines whether the specified character (Unicode code point)
 * is in the <a href="#supplementary">supplementary character</a> range.
 *
 * @param  codePoint the character (Unicode code point) to be tested
 * @return {@code true} if the specified code point is between
 *         {@link #MIN_SUPPLEMENTARY_CODE_POINT} and
 *         {@link #MAX_CODE_POINT} inclusive;
 *         {@code false} otherwise.
 * @since  1.5
 * @apiSince 1
 */

public static boolean isSupplementaryCodePoint(int codePoint) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the given {@code char} value is a
 * <a href="http://www.unicode.org/glossary/#high_surrogate_code_unit">
 * Unicode high-surrogate code unit</a>
 * (also known as <i>leading-surrogate code unit</i>).
 *
 * <p>Such values do not represent characters by themselves,
 * but are used in the representation of
 * <a href="#supplementary">supplementary characters</a>
 * in the UTF-16 encoding.
 *
 * @param  ch the {@code char} value to be tested.
 * @return {@code true} if the {@code char} value is between
 *         {@link #MIN_HIGH_SURROGATE} and
 *         {@link #MAX_HIGH_SURROGATE} inclusive;
 *         {@code false} otherwise.
 * @see    java.lang.Character#isLowSurrogate(char)
 * @see    java.lang.Character.UnicodeBlock#of(int)
 * @since  1.5
 * @apiSince 1
 */

public static boolean isHighSurrogate(char ch) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the given {@code char} value is a
 * <a href="http://www.unicode.org/glossary/#low_surrogate_code_unit">
 * Unicode low-surrogate code unit</a>
 * (also known as <i>trailing-surrogate code unit</i>).
 *
 * <p>Such values do not represent characters by themselves,
 * but are used in the representation of
 * <a href="#supplementary">supplementary characters</a>
 * in the UTF-16 encoding.
 *
 * @param  ch the {@code char} value to be tested.
 * @return {@code true} if the {@code char} value is between
 *         {@link #MIN_LOW_SURROGATE} and
 *         {@link #MAX_LOW_SURROGATE} inclusive;
 *         {@code false} otherwise.
 * @see    java.lang.Character#isHighSurrogate(char)
 * @since  1.5
 * @apiSince 1
 */

public static boolean isLowSurrogate(char ch) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the given {@code char} value is a Unicode
 * <i>surrogate code unit</i>.
 *
 * <p>Such values do not represent characters by themselves,
 * but are used in the representation of
 * <a href="#supplementary">supplementary characters</a>
 * in the UTF-16 encoding.
 *
 * <p>A char value is a surrogate code unit if and only if it is either
 * a {@linkplain #isLowSurrogate(char) low-surrogate code unit} or
 * a {@linkplain #isHighSurrogate(char) high-surrogate code unit}.
 *
 * @param  ch the {@code char} value to be tested.
 * @return {@code true} if the {@code char} value is between
 *         {@link #MIN_SURROGATE} and
 *         {@link #MAX_SURROGATE} inclusive;
 *         {@code false} otherwise.
 * @since  1.7
 * @apiSince 19
 */

public static boolean isSurrogate(char ch) { throw new RuntimeException("Stub!"); }

/**
 * Determines whether the specified pair of {@code char}
 * values is a valid
 * <a href="http://www.unicode.org/glossary/#surrogate_pair">
 * Unicode surrogate pair</a>.
 
 * <p>This method is equivalent to the expression:
 * <blockquote><pre>{@code
 * isHighSurrogate(high) && isLowSurrogate(low)
 * }</pre></blockquote>
 *
 * @param  high the high-surrogate code value to be tested
 * @param  low the low-surrogate code value to be tested
 * @return {@code true} if the specified high and
 * low-surrogate code values represent a valid surrogate pair;
 * {@code false} otherwise.
 * @since  1.5
 * @apiSince 1
 */

public static boolean isSurrogatePair(char high, char low) { throw new RuntimeException("Stub!"); }

/**
 * Determines the number of {@code char} values needed to
 * represent the specified character (Unicode code point). If the
 * specified character is equal to or greater than 0x10000, then
 * the method returns 2. Otherwise, the method returns 1.
 *
 * <p>This method doesn't validate the specified character to be a
 * valid Unicode code point. The caller must validate the
 * character value using {@link #isValidCodePoint(int) isValidCodePoint}
 * if necessary.
 *
 * @param   codePoint the character (Unicode code point) to be tested.
 * @return  2 if the character is a valid supplementary character; 1 otherwise.
 * @see     java.lang.Character#isSupplementaryCodePoint(int)
 * @since   1.5
 * @apiSince 1
 */

public static int charCount(int codePoint) { throw new RuntimeException("Stub!"); }

/**
 * Converts the specified surrogate pair to its supplementary code
 * point value. This method does not validate the specified
 * surrogate pair. The caller must validate it using {@link
 * #isSurrogatePair(char,char) isSurrogatePair} if necessary.
 *
 * @param  high the high-surrogate code unit
 * @param  low the low-surrogate code unit
 * @return the supplementary code point composed from the
 *         specified surrogate pair.
 * @since  1.5
 * @apiSince 1
 */

public static int toCodePoint(char high, char low) { throw new RuntimeException("Stub!"); }

/**
 * Returns the code point at the given index of the
 * {@code CharSequence}. If the {@code char} value at
 * the given index in the {@code CharSequence} is in the
 * high-surrogate range, the following index is less than the
 * length of the {@code CharSequence}, and the
 * {@code char} value at the following index is in the
 * low-surrogate range, then the supplementary code point
 * corresponding to this surrogate pair is returned. Otherwise,
 * the {@code char} value at the given index is returned.
 *
 * @param seq a sequence of {@code char} values (Unicode code
 * units)
 * @param index the index to the {@code char} values (Unicode
 * code units) in {@code seq} to be converted
 * @return the Unicode code point at the given index
 * @exception java.lang.NullPointerException if {@code seq} is null.
 * @exception java.lang.IndexOutOfBoundsException if the value
 * {@code index} is negative or not less than
 * {@link java.lang.CharSequence#length() CharSequence#length()}.
 * @since  1.5
 * @apiSince 1
 */

public static int codePointAt(@androidx.annotation.NonNull java.lang.CharSequence seq, int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns the code point at the given index of the
 * {@code char} array. If the {@code char} value at
 * the given index in the {@code char} array is in the
 * high-surrogate range, the following index is less than the
 * length of the {@code char} array, and the
 * {@code char} value at the following index is in the
 * low-surrogate range, then the supplementary code point
 * corresponding to this surrogate pair is returned. Otherwise,
 * the {@code char} value at the given index is returned.
 *
 * @param a the {@code char} array
 * @param index the index to the {@code char} values (Unicode
 * code units) in the {@code char} array to be converted
 * @return the Unicode code point at the given index
 * @exception java.lang.NullPointerException if {@code a} is null.
 * @exception java.lang.IndexOutOfBoundsException if the value
 * {@code index} is negative or not less than
 * the length of the {@code char} array.
 * @since  1.5
 * @apiSince 1
 */

public static int codePointAt(char[] a, int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns the code point at the given index of the
 * {@code char} array, where only array elements with
 * {@code index} less than {@code limit} can be used. If
 * the {@code char} value at the given index in the
 * {@code char} array is in the high-surrogate range, the
 * following index is less than the {@code limit}, and the
 * {@code char} value at the following index is in the
 * low-surrogate range, then the supplementary code point
 * corresponding to this surrogate pair is returned. Otherwise,
 * the {@code char} value at the given index is returned.
 *
 * @param a the {@code char} array
 * @param index the index to the {@code char} values (Unicode
 * code units) in the {@code char} array to be converted
 * @param limit the index after the last array element that
 * can be used in the {@code char} array
 * @return the Unicode code point at the given index
 * @exception java.lang.NullPointerException if {@code a} is null.
 * @exception java.lang.IndexOutOfBoundsException if the {@code index}
 * argument is negative or not less than the {@code limit}
 * argument, or if the {@code limit} argument is negative or
 * greater than the length of the {@code char} array.
 * @since  1.5
 * @apiSince 1
 */

public static int codePointAt(char[] a, int index, int limit) { throw new RuntimeException("Stub!"); }

/**
 * Returns the code point preceding the given index of the
 * {@code CharSequence}. If the {@code char} value at
 * {@code (index - 1)} in the {@code CharSequence} is in
 * the low-surrogate range, {@code (index - 2)} is not
 * negative, and the {@code char} value at {@code (index - 2)}
 * in the {@code CharSequence} is in the
 * high-surrogate range, then the supplementary code point
 * corresponding to this surrogate pair is returned. Otherwise,
 * the {@code char} value at {@code (index - 1)} is
 * returned.
 *
 * @param seq the {@code CharSequence} instance
 * @param index the index following the code point that should be returned
 * @return the Unicode code point value before the given index.
 * @exception java.lang.NullPointerException if {@code seq} is null.
 * @exception java.lang.IndexOutOfBoundsException if the {@code index}
 * argument is less than 1 or greater than {@link java.lang.CharSequence#length() CharSequence#length()}.
 * @since  1.5
 * @apiSince 1
 */

public static int codePointBefore(@androidx.annotation.NonNull java.lang.CharSequence seq, int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns the code point preceding the given index of the
 * {@code char} array. If the {@code char} value at
 * {@code (index - 1)} in the {@code char} array is in
 * the low-surrogate range, {@code (index - 2)} is not
 * negative, and the {@code char} value at {@code (index - 2)}
 * in the {@code char} array is in the
 * high-surrogate range, then the supplementary code point
 * corresponding to this surrogate pair is returned. Otherwise,
 * the {@code char} value at {@code (index - 1)} is
 * returned.
 *
 * @param a the {@code char} array
 * @param index the index following the code point that should be returned
 * @return the Unicode code point value before the given index.
 * @exception java.lang.NullPointerException if {@code a} is null.
 * @exception java.lang.IndexOutOfBoundsException if the {@code index}
 * argument is less than 1 or greater than the length of the
 * {@code char} array
 * @since  1.5
 * @apiSince 1
 */

public static int codePointBefore(char[] a, int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns the code point preceding the given index of the
 * {@code char} array, where only array elements with
 * {@code index} greater than or equal to {@code start}
 * can be used. If the {@code char} value at {@code (index - 1)}
 * in the {@code char} array is in the
 * low-surrogate range, {@code (index - 2)} is not less than
 * {@code start}, and the {@code char} value at
 * {@code (index - 2)} in the {@code char} array is in
 * the high-surrogate range, then the supplementary code point
 * corresponding to this surrogate pair is returned. Otherwise,
 * the {@code char} value at {@code (index - 1)} is
 * returned.
 *
 * @param a the {@code char} array
 * @param index the index following the code point that should be returned
 * @param start the index of the first array element in the
 * {@code char} array
 * @return the Unicode code point value before the given index.
 * @exception java.lang.NullPointerException if {@code a} is null.
 * @exception java.lang.IndexOutOfBoundsException if the {@code index}
 * argument is not greater than the {@code start} argument or
 * is greater than the length of the {@code char} array, or
 * if the {@code start} argument is negative or not less than
 * the length of the {@code char} array.
 * @since  1.5
 * @apiSince 1
 */

public static int codePointBefore(char[] a, int index, int start) { throw new RuntimeException("Stub!"); }

/**
 * Returns the leading surrogate (a
 * <a href="http://www.unicode.org/glossary/#high_surrogate_code_unit">
 * high surrogate code unit</a>) of the
 * <a href="http://www.unicode.org/glossary/#surrogate_pair">
 * surrogate pair</a>
 * representing the specified supplementary character (Unicode
 * code point) in the UTF-16 encoding.  If the specified character
 * is not a
 * <a href="Character.html#supplementary">supplementary character</a>,
 * an unspecified {@code char} is returned.
 *
 * <p>If
 * {@link #isSupplementaryCodePoint isSupplementaryCodePoint(x)}
 * is {@code true}, then
 * {@link #isHighSurrogate isHighSurrogate}{@code (highSurrogate(x))} and
 * {@link #toCodePoint toCodePoint}{@code (highSurrogate(x), }{@link #lowSurrogate lowSurrogate}{@code (x)) == x}
 * are also always {@code true}.
 *
 * @param   codePoint a supplementary character (Unicode code point)
 * @return  the leading surrogate code unit used to represent the
 *          character in the UTF-16 encoding
 * @since   1.7
 * @apiSince 19
 */

public static char highSurrogate(int codePoint) { throw new RuntimeException("Stub!"); }

/**
 * Returns the trailing surrogate (a
 * <a href="http://www.unicode.org/glossary/#low_surrogate_code_unit">
 * low surrogate code unit</a>) of the
 * <a href="http://www.unicode.org/glossary/#surrogate_pair">
 * surrogate pair</a>
 * representing the specified supplementary character (Unicode
 * code point) in the UTF-16 encoding.  If the specified character
 * is not a
 * <a href="Character.html#supplementary">supplementary character</a>,
 * an unspecified {@code char} is returned.
 *
 * <p>If
 * {@link #isSupplementaryCodePoint isSupplementaryCodePoint(x)}
 * is {@code true}, then
 * {@link #isLowSurrogate isLowSurrogate}{@code (lowSurrogate(x))} and
 * {@link #toCodePoint toCodePoint}{@code (}{@link #highSurrogate highSurrogate}{@code (x), lowSurrogate(x)) == x}
 * are also always {@code true}.
 *
 * @param   codePoint a supplementary character (Unicode code point)
 * @return  the trailing surrogate code unit used to represent the
 *          character in the UTF-16 encoding
 * @since   1.7
 * @apiSince 19
 */

public static char lowSurrogate(int codePoint) { throw new RuntimeException("Stub!"); }

/**
 * Converts the specified character (Unicode code point) to its
 * UTF-16 representation. If the specified code point is a BMP
 * (Basic Multilingual Plane or Plane 0) value, the same value is
 * stored in {@code dst[dstIndex]}, and 1 is returned. If the
 * specified code point is a supplementary character, its
 * surrogate values are stored in {@code dst[dstIndex]}
 * (high-surrogate) and {@code dst[dstIndex+1]}
 * (low-surrogate), and 2 is returned.
 *
 * @param  codePoint the character (Unicode code point) to be converted.
 * @param  dst an array of {@code char} in which the
 * {@code codePoint}'s UTF-16 value is stored.
 * @param dstIndex the start index into the {@code dst}
 * array where the converted value is stored.
 * @return 1 if the code point is a BMP code point, 2 if the
 * code point is a supplementary code point.
 * @exception java.lang.IllegalArgumentException if the specified
 * {@code codePoint} is not a valid Unicode code point.
 * @exception java.lang.NullPointerException if the specified {@code dst} is null.
 * @exception java.lang.IndexOutOfBoundsException if {@code dstIndex}
 * is negative or not less than {@code dst.length}, or if
 * {@code dst} at {@code dstIndex} doesn't have enough
 * array element(s) to store the resulting {@code char}
 * value(s). (If {@code dstIndex} is equal to
 * {@code dst.length-1} and the specified
 * {@code codePoint} is a supplementary character, the
 * high-surrogate value is not stored in
 * {@code dst[dstIndex]}.)
 * @since  1.5
 * @apiSince 1
 */

public static int toChars(int codePoint, char[] dst, int dstIndex) { throw new RuntimeException("Stub!"); }

/**
 * Converts the specified character (Unicode code point) to its
 * UTF-16 representation stored in a {@code char} array. If
 * the specified code point is a BMP (Basic Multilingual Plane or
 * Plane 0) value, the resulting {@code char} array has
 * the same value as {@code codePoint}. If the specified code
 * point is a supplementary code point, the resulting
 * {@code char} array has the corresponding surrogate pair.
 *
 * @param  codePoint a Unicode code point
 * @return a {@code char} array having
 *         {@code codePoint}'s UTF-16 representation.
 * @exception java.lang.IllegalArgumentException if the specified
 * {@code codePoint} is not a valid Unicode code point.
 * @since  1.5
 * @apiSince 1
 */

public static char[] toChars(int codePoint) { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of Unicode code points in the text range of
 * the specified char sequence. The text range begins at the
 * specified {@code beginIndex} and extends to the
 * {@code char} at index {@code endIndex - 1}. Thus the
 * length (in {@code char}s) of the text range is
 * {@code endIndex-beginIndex}. Unpaired surrogates within
 * the text range count as one code point each.
 *
 * @param seq the char sequence
 * @param beginIndex the index to the first {@code char} of
 * the text range.
 * @param endIndex the index after the last {@code char} of
 * the text range.
 * @return the number of Unicode code points in the specified text
 * range
 * @exception java.lang.NullPointerException if {@code seq} is null.
 * @exception java.lang.IndexOutOfBoundsException if the
 * {@code beginIndex} is negative, or {@code endIndex}
 * is larger than the length of the given sequence, or
 * {@code beginIndex} is larger than {@code endIndex}.
 * @since  1.5
 * @apiSince 1
 */

public static int codePointCount(@androidx.annotation.NonNull java.lang.CharSequence seq, int beginIndex, int endIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of Unicode code points in a subarray of the
 * {@code char} array argument. The {@code offset}
 * argument is the index of the first {@code char} of the
 * subarray and the {@code count} argument specifies the
 * length of the subarray in {@code char}s. Unpaired
 * surrogates within the subarray count as one code point each.
 *
 * @param a the {@code char} array
 * @param offset the index of the first {@code char} in the
 * given {@code char} array
 * @param count the length of the subarray in {@code char}s
 * @return the number of Unicode code points in the specified subarray
 * @exception java.lang.NullPointerException if {@code a} is null.
 * @exception java.lang.IndexOutOfBoundsException if {@code offset} or
 * {@code count} is negative, or if {@code offset +
 * count} is larger than the length of the given array.
 * @since  1.5
 * @apiSince 1
 */

public static int codePointCount(char[] a, int offset, int count) { throw new RuntimeException("Stub!"); }

/**
 * Returns the index within the given char sequence that is offset
 * from the given {@code index} by {@code codePointOffset}
 * code points. Unpaired surrogates within the text range given by
 * {@code index} and {@code codePointOffset} count as
 * one code point each.
 *
 * @param seq the char sequence
 * @param index the index to be offset
 * @param codePointOffset the offset in code points
 * @return the index within the char sequence
 * @exception java.lang.NullPointerException if {@code seq} is null.
 * @exception java.lang.IndexOutOfBoundsException if {@code index}
 *   is negative or larger then the length of the char sequence,
 *   or if {@code codePointOffset} is positive and the
 *   subsequence starting with {@code index} has fewer than
 *   {@code codePointOffset} code points, or if
 *   {@code codePointOffset} is negative and the subsequence
 *   before {@code index} has fewer than the absolute value
 *   of {@code codePointOffset} code points.
 * @since 1.5
 * @apiSince 1
 */

public static int offsetByCodePoints(@androidx.annotation.NonNull java.lang.CharSequence seq, int index, int codePointOffset) { throw new RuntimeException("Stub!"); }

/**
 * Returns the index within the given {@code char} subarray
 * that is offset from the given {@code index} by
 * {@code codePointOffset} code points. The
 * {@code start} and {@code count} arguments specify a
 * subarray of the {@code char} array. Unpaired surrogates
 * within the text range given by {@code index} and
 * {@code codePointOffset} count as one code point each.
 *
 * @param a the {@code char} array
 * @param start the index of the first {@code char} of the
 * subarray
 * @param count the length of the subarray in {@code char}s
 * @param index the index to be offset
 * @param codePointOffset the offset in code points
 * @return the index within the subarray
 * @exception java.lang.NullPointerException if {@code a} is null.
 * @exception java.lang.IndexOutOfBoundsException
 *   if {@code start} or {@code count} is negative,
 *   or if {@code start + count} is larger than the length of
 *   the given array,
 *   or if {@code index} is less than {@code start} or
 *   larger then {@code start + count},
 *   or if {@code codePointOffset} is positive and the text range
 *   starting with {@code index} and ending with {@code start + count - 1}
 *   has fewer than {@code codePointOffset} code
 *   points,
 *   or if {@code codePointOffset} is negative and the text range
 *   starting with {@code start} and ending with {@code index - 1}
 *   has fewer than the absolute value of
 *   {@code codePointOffset} code points.
 * @since 1.5
 * @apiSince 1
 */

public static int offsetByCodePoints(char[] a, int start, int count, int index, int codePointOffset) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the specified character is a lowercase character.
 * <p>
 * A character is lowercase if its general category type, provided
 * by {@code Character.getType(ch)}, is
 * {@code LOWERCASE_LETTER}, or it has contributory property
 * Other_Lowercase as defined by the Unicode Standard.
 * <p>
 * The following are examples of lowercase characters:
 * <blockquote><pre>
 * a b c d e f g h i j k l m n o p q r s t u v w x y z
 * '&#92;u00DF' '&#92;u00E0' '&#92;u00E1' '&#92;u00E2' '&#92;u00E3' '&#92;u00E4' '&#92;u00E5' '&#92;u00E6'
 * '&#92;u00E7' '&#92;u00E8' '&#92;u00E9' '&#92;u00EA' '&#92;u00EB' '&#92;u00EC' '&#92;u00ED' '&#92;u00EE'
 * '&#92;u00EF' '&#92;u00F0' '&#92;u00F1' '&#92;u00F2' '&#92;u00F3' '&#92;u00F4' '&#92;u00F5' '&#92;u00F6'
 * '&#92;u00F8' '&#92;u00F9' '&#92;u00FA' '&#92;u00FB' '&#92;u00FC' '&#92;u00FD' '&#92;u00FE' '&#92;u00FF'
 * </pre></blockquote>
 * <p> Many other Unicode characters are lowercase too.
 *
 * <p><b>Note:</b> This method cannot handle <a
 * href="#supplementary"> supplementary characters</a>. To support
 * all Unicode characters, including supplementary characters, use
 * the {@link #isLowerCase(int)} method.
 *
 * @param   ch   the character to be tested.
 * @return  {@code true} if the character is lowercase;
 *          {@code false} otherwise.
 * @see     java.lang.Character#isLowerCase(char)
 * @see     java.lang.Character#isTitleCase(char)
 * @see     java.lang.Character#toLowerCase(char)
 * @see     java.lang.Character#getType(char)
 * @apiSince 1
 */

public static boolean isLowerCase(char ch) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the specified character (Unicode code point) is a
 * lowercase character.
 * <p>
 * A character is lowercase if its general category type, provided
 * by {@link java.lang.Character#getType Character#getType}, is
 * {@code LOWERCASE_LETTER}, or it has contributory property
 * Other_Lowercase as defined by the Unicode Standard.
 * <p>
 * The following are examples of lowercase characters:
 * <blockquote><pre>
 * a b c d e f g h i j k l m n o p q r s t u v w x y z
 * '&#92;u00DF' '&#92;u00E0' '&#92;u00E1' '&#92;u00E2' '&#92;u00E3' '&#92;u00E4' '&#92;u00E5' '&#92;u00E6'
 * '&#92;u00E7' '&#92;u00E8' '&#92;u00E9' '&#92;u00EA' '&#92;u00EB' '&#92;u00EC' '&#92;u00ED' '&#92;u00EE'
 * '&#92;u00EF' '&#92;u00F0' '&#92;u00F1' '&#92;u00F2' '&#92;u00F3' '&#92;u00F4' '&#92;u00F5' '&#92;u00F6'
 * '&#92;u00F8' '&#92;u00F9' '&#92;u00FA' '&#92;u00FB' '&#92;u00FC' '&#92;u00FD' '&#92;u00FE' '&#92;u00FF'
 * </pre></blockquote>
 * <p> Many other Unicode characters are lowercase too.
 *
 * @param   codePoint the character (Unicode code point) to be tested.
 * @return  {@code true} if the character is lowercase;
 *          {@code false} otherwise.
 * @see     java.lang.Character#isLowerCase(int)
 * @see     java.lang.Character#isTitleCase(int)
 * @see     java.lang.Character#toLowerCase(int)
 * @see     java.lang.Character#getType(int)
 * @since   1.5
 * @apiSince 1
 */

public static boolean isLowerCase(int codePoint) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the specified character is an uppercase character.
 * <p>
 * A character is uppercase if its general category type, provided by
 * {@code Character.getType(ch)}, is {@code UPPERCASE_LETTER}.
 * or it has contributory property Other_Uppercase as defined by the Unicode Standard.
 * <p>
 * The following are examples of uppercase characters:
 * <blockquote><pre>
 * A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
 * '&#92;u00C0' '&#92;u00C1' '&#92;u00C2' '&#92;u00C3' '&#92;u00C4' '&#92;u00C5' '&#92;u00C6' '&#92;u00C7'
 * '&#92;u00C8' '&#92;u00C9' '&#92;u00CA' '&#92;u00CB' '&#92;u00CC' '&#92;u00CD' '&#92;u00CE' '&#92;u00CF'
 * '&#92;u00D0' '&#92;u00D1' '&#92;u00D2' '&#92;u00D3' '&#92;u00D4' '&#92;u00D5' '&#92;u00D6' '&#92;u00D8'
 * '&#92;u00D9' '&#92;u00DA' '&#92;u00DB' '&#92;u00DC' '&#92;u00DD' '&#92;u00DE'
 * </pre></blockquote>
 * <p> Many other Unicode characters are uppercase too.
 *
 * <p><b>Note:</b> This method cannot handle <a
 * href="#supplementary"> supplementary characters</a>. To support
 * all Unicode characters, including supplementary characters, use
 * the {@link #isUpperCase(int)} method.
 *
 * @param   ch   the character to be tested.
 * @return  {@code true} if the character is uppercase;
 *          {@code false} otherwise.
 * @see     java.lang.Character#isLowerCase(char)
 * @see     java.lang.Character#isTitleCase(char)
 * @see     java.lang.Character#toUpperCase(char)
 * @see     java.lang.Character#getType(char)
 * @since   1.0
 * @apiSince 1
 */

public static boolean isUpperCase(char ch) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the specified character (Unicode code point) is an uppercase character.
 * <p>
 * A character is uppercase if its general category type, provided by
 * {@link java.lang.Character#getType(int) Character#getType(int)}, is {@code UPPERCASE_LETTER},
 * or it has contributory property Other_Uppercase as defined by the Unicode Standard.
 * <p>
 * The following are examples of uppercase characters:
 * <blockquote><pre>
 * A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
 * '&#92;u00C0' '&#92;u00C1' '&#92;u00C2' '&#92;u00C3' '&#92;u00C4' '&#92;u00C5' '&#92;u00C6' '&#92;u00C7'
 * '&#92;u00C8' '&#92;u00C9' '&#92;u00CA' '&#92;u00CB' '&#92;u00CC' '&#92;u00CD' '&#92;u00CE' '&#92;u00CF'
 * '&#92;u00D0' '&#92;u00D1' '&#92;u00D2' '&#92;u00D3' '&#92;u00D4' '&#92;u00D5' '&#92;u00D6' '&#92;u00D8'
 * '&#92;u00D9' '&#92;u00DA' '&#92;u00DB' '&#92;u00DC' '&#92;u00DD' '&#92;u00DE'
 * </pre></blockquote>
 * <p> Many other Unicode characters are uppercase too.<p>
 *
 * @param   codePoint the character (Unicode code point) to be tested.
 * @return  {@code true} if the character is uppercase;
 *          {@code false} otherwise.
 * @see     java.lang.Character#isLowerCase(int)
 * @see     java.lang.Character#isTitleCase(int)
 * @see     java.lang.Character#toUpperCase(int)
 * @see     java.lang.Character#getType(int)
 * @since   1.5
 * @apiSince 1
 */

public static boolean isUpperCase(int codePoint) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the specified character is a titlecase character.
 * <p>
 * A character is a titlecase character if its general
 * category type, provided by {@code Character.getType(ch)},
 * is {@code TITLECASE_LETTER}.
 * <p>
 * Some characters look like pairs of Latin letters. For example, there
 * is an uppercase letter that looks like "LJ" and has a corresponding
 * lowercase letter that looks like "lj". A third form, which looks like "Lj",
 * is the appropriate form to use when rendering a word in lowercase
 * with initial capitals, as for a book title.
 * <p>
 * These are some of the Unicode characters for which this method returns
 * {@code true}:
 * <ul>
 * <li>{@code LATIN CAPITAL LETTER D WITH SMALL LETTER Z WITH CARON}
 * <li>{@code LATIN CAPITAL LETTER L WITH SMALL LETTER J}
 * <li>{@code LATIN CAPITAL LETTER N WITH SMALL LETTER J}
 * <li>{@code LATIN CAPITAL LETTER D WITH SMALL LETTER Z}
 * </ul>
 * <p> Many other Unicode characters are titlecase too.
 *
 * <p><b>Note:</b> This method cannot handle <a
 * href="#supplementary"> supplementary characters</a>. To support
 * all Unicode characters, including supplementary characters, use
 * the {@link #isTitleCase(int)} method.
 *
 * @param   ch   the character to be tested.
 * @return  {@code true} if the character is titlecase;
 *          {@code false} otherwise.
 * @see     java.lang.Character#isLowerCase(char)
 * @see     java.lang.Character#isUpperCase(char)
 * @see     java.lang.Character#toTitleCase(char)
 * @see     java.lang.Character#getType(char)
 * @since   1.0.2
 * @apiSince 1
 */

public static boolean isTitleCase(char ch) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the specified character (Unicode code point) is a titlecase character.
 * <p>
 * A character is a titlecase character if its general
 * category type, provided by {@link java.lang.Character#getType(int) Character#getType(int)},
 * is {@code TITLECASE_LETTER}.
 * <p>
 * Some characters look like pairs of Latin letters. For example, there
 * is an uppercase letter that looks like "LJ" and has a corresponding
 * lowercase letter that looks like "lj". A third form, which looks like "Lj",
 * is the appropriate form to use when rendering a word in lowercase
 * with initial capitals, as for a book title.
 * <p>
 * These are some of the Unicode characters for which this method returns
 * {@code true}:
 * <ul>
 * <li>{@code LATIN CAPITAL LETTER D WITH SMALL LETTER Z WITH CARON}
 * <li>{@code LATIN CAPITAL LETTER L WITH SMALL LETTER J}
 * <li>{@code LATIN CAPITAL LETTER N WITH SMALL LETTER J}
 * <li>{@code LATIN CAPITAL LETTER D WITH SMALL LETTER Z}
 * </ul>
 * <p> Many other Unicode characters are titlecase too.<p>
 *
 * @param   codePoint the character (Unicode code point) to be tested.
 * @return  {@code true} if the character is titlecase;
 *          {@code false} otherwise.
 * @see     java.lang.Character#isLowerCase(int)
 * @see     java.lang.Character#isUpperCase(int)
 * @see     java.lang.Character#toTitleCase(int)
 * @see     java.lang.Character#getType(int)
 * @since   1.5
 * @apiSince 1
 */

public static boolean isTitleCase(int codePoint) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the specified character is a digit.
 * <p>
 * A character is a digit if its general category type, provided
 * by {@code Character.getType(ch)}, is
 * {@code DECIMAL_DIGIT_NUMBER}.
 * <p>
 * Some Unicode character ranges that contain digits:
 * <ul>
 * <li>{@code '\u005Cu0030'} through {@code '\u005Cu0039'},
 *     ISO-LATIN-1 digits ({@code '0'} through {@code '9'})
 * <li>{@code '\u005Cu0660'} through {@code '\u005Cu0669'},
 *     Arabic-Indic digits
 * <li>{@code '\u005Cu06F0'} through {@code '\u005Cu06F9'},
 *     Extended Arabic-Indic digits
 * <li>{@code '\u005Cu0966'} through {@code '\u005Cu096F'},
 *     Devanagari digits
 * <li>{@code '\u005CuFF10'} through {@code '\u005CuFF19'},
 *     Fullwidth digits
 * </ul>
 *
 * Many other character ranges contain digits as well.
 *
 * <p><b>Note:</b> This method cannot handle <a
 * href="#supplementary"> supplementary characters</a>. To support
 * all Unicode characters, including supplementary characters, use
 * the {@link #isDigit(int)} method.
 *
 * @param   ch   the character to be tested.
 * @return  {@code true} if the character is a digit;
 *          {@code false} otherwise.
 * @see     java.lang.Character#digit(char, int)
 * @see     java.lang.Character#forDigit(int, int)
 * @see     java.lang.Character#getType(char)
 * @apiSince 1
 */

public static boolean isDigit(char ch) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the specified character (Unicode code point) is a digit.
 * <p>
 * A character is a digit if its general category type, provided
 * by {@link java.lang.Character#getType(int) Character#getType(int)}, is
 * {@code DECIMAL_DIGIT_NUMBER}.
 * <p>
 * Some Unicode character ranges that contain digits:
 * <ul>
 * <li>{@code '\u005Cu0030'} through {@code '\u005Cu0039'},
 *     ISO-LATIN-1 digits ({@code '0'} through {@code '9'})
 * <li>{@code '\u005Cu0660'} through {@code '\u005Cu0669'},
 *     Arabic-Indic digits
 * <li>{@code '\u005Cu06F0'} through {@code '\u005Cu06F9'},
 *     Extended Arabic-Indic digits
 * <li>{@code '\u005Cu0966'} through {@code '\u005Cu096F'},
 *     Devanagari digits
 * <li>{@code '\u005CuFF10'} through {@code '\u005CuFF19'},
 *     Fullwidth digits
 * </ul>
 *
 * Many other character ranges contain digits as well.
 *
 * @param   codePoint the character (Unicode code point) to be tested.
 * @return  {@code true} if the character is a digit;
 *          {@code false} otherwise.
 * @see     java.lang.Character#forDigit(int, int)
 * @see     java.lang.Character#getType(int)
 * @since   1.5
 * @apiSince 1
 */

public static boolean isDigit(int codePoint) { throw new RuntimeException("Stub!"); }

/**
 * Determines if a character is defined in Unicode.
 * <p>
 * A character is defined if at least one of the following is true:
 * <ul>
 * <li>It has an entry in the UnicodeData file.
 * <li>It has a value in a range defined by the UnicodeData file.
 * </ul>
 *
 * <p><b>Note:</b> This method cannot handle <a
 * href="#supplementary"> supplementary characters</a>. To support
 * all Unicode characters, including supplementary characters, use
 * the {@link #isDefined(int)} method.
 *
 * @param   ch   the character to be tested
 * @return  {@code true} if the character has a defined meaning
 *          in Unicode; {@code false} otherwise.
 * @see     java.lang.Character#isDigit(char)
 * @see     java.lang.Character#isLetter(char)
 * @see     java.lang.Character#isLetterOrDigit(char)
 * @see     java.lang.Character#isLowerCase(char)
 * @see     java.lang.Character#isTitleCase(char)
 * @see     java.lang.Character#isUpperCase(char)
 * @since   1.0.2
 * @apiSince 1
 */

public static boolean isDefined(char ch) { throw new RuntimeException("Stub!"); }

/**
 * Determines if a character (Unicode code point) is defined in Unicode.
 * <p>
 * A character is defined if at least one of the following is true:
 * <ul>
 * <li>It has an entry in the UnicodeData file.
 * <li>It has a value in a range defined by the UnicodeData file.
 * </ul>
 *
 * @param   codePoint the character (Unicode code point) to be tested.
 * @return  {@code true} if the character has a defined meaning
 *          in Unicode; {@code false} otherwise.
 * @see     java.lang.Character#isDigit(int)
 * @see     java.lang.Character#isLetter(int)
 * @see     java.lang.Character#isLetterOrDigit(int)
 * @see     java.lang.Character#isLowerCase(int)
 * @see     java.lang.Character#isTitleCase(int)
 * @see     java.lang.Character#isUpperCase(int)
 * @since   1.5
 * @apiSince 1
 */

public static boolean isDefined(int codePoint) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the specified character is a letter.
 * <p>
 * A character is considered to be a letter if its general
 * category type, provided by {@code Character.getType(ch)},
 * is any of the following:
 * <ul>
 * <li> {@code UPPERCASE_LETTER}
 * <li> {@code LOWERCASE_LETTER}
 * <li> {@code TITLECASE_LETTER}
 * <li> {@code MODIFIER_LETTER}
 * <li> {@code OTHER_LETTER}
 * </ul>
 *
 * Not all letters have case. Many characters are
 * letters but are neither uppercase nor lowercase nor titlecase.
 *
 * <p><b>Note:</b> This method cannot handle <a
 * href="#supplementary"> supplementary characters</a>. To support
 * all Unicode characters, including supplementary characters, use
 * the {@link #isLetter(int)} method.
 *
 * @param   ch   the character to be tested.
 * @return  {@code true} if the character is a letter;
 *          {@code false} otherwise.
 * @see     java.lang.Character#isDigit(char)
 * @see     java.lang.Character#isJavaIdentifierStart(char)
 * @see     java.lang.Character#isJavaLetter(char)
 * @see     java.lang.Character#isJavaLetterOrDigit(char)
 * @see     java.lang.Character#isLetterOrDigit(char)
 * @see     java.lang.Character#isLowerCase(char)
 * @see     java.lang.Character#isTitleCase(char)
 * @see     java.lang.Character#isUnicodeIdentifierStart(char)
 * @see     java.lang.Character#isUpperCase(char)
 * @apiSince 1
 */

public static boolean isLetter(char ch) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the specified character (Unicode code point) is a letter.
 * <p>
 * A character is considered to be a letter if its general
 * category type, provided by {@link java.lang.Character#getType(int) Character#getType(int)},
 * is any of the following:
 * <ul>
 * <li> {@code UPPERCASE_LETTER}
 * <li> {@code LOWERCASE_LETTER}
 * <li> {@code TITLECASE_LETTER}
 * <li> {@code MODIFIER_LETTER}
 * <li> {@code OTHER_LETTER}
 * </ul>
 *
 * Not all letters have case. Many characters are
 * letters but are neither uppercase nor lowercase nor titlecase.
 *
 * @param   codePoint the character (Unicode code point) to be tested.
 * @return  {@code true} if the character is a letter;
 *          {@code false} otherwise.
 * @see     java.lang.Character#isDigit(int)
 * @see     java.lang.Character#isJavaIdentifierStart(int)
 * @see     java.lang.Character#isLetterOrDigit(int)
 * @see     java.lang.Character#isLowerCase(int)
 * @see     java.lang.Character#isTitleCase(int)
 * @see     java.lang.Character#isUnicodeIdentifierStart(int)
 * @see     java.lang.Character#isUpperCase(int)
 * @since   1.5
 * @apiSince 1
 */

public static boolean isLetter(int codePoint) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the specified character is a letter or digit.
 * <p>
 * A character is considered to be a letter or digit if either
 * {@code Character.isLetter(char ch)} or
 * {@code Character.isDigit(char ch)} returns
 * {@code true} for the character.
 *
 * <p><b>Note:</b> This method cannot handle <a
 * href="#supplementary"> supplementary characters</a>. To support
 * all Unicode characters, including supplementary characters, use
 * the {@link #isLetterOrDigit(int)} method.
 *
 * @param   ch   the character to be tested.
 * @return  {@code true} if the character is a letter or digit;
 *          {@code false} otherwise.
 * @see     java.lang.Character#isDigit(char)
 * @see     java.lang.Character#isJavaIdentifierPart(char)
 * @see     java.lang.Character#isJavaLetter(char)
 * @see     java.lang.Character#isJavaLetterOrDigit(char)
 * @see     java.lang.Character#isLetter(char)
 * @see     java.lang.Character#isUnicodeIdentifierPart(char)
 * @since   1.0.2
 * @apiSince 1
 */

public static boolean isLetterOrDigit(char ch) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the specified character (Unicode code point) is a letter or digit.
 * <p>
 * A character is considered to be a letter or digit if either
 * {@link #isLetter(int) isLetter(codePoint)} or
 * {@link #isDigit(int) isDigit(codePoint)} returns
 * {@code true} for the character.
 *
 * @param   codePoint the character (Unicode code point) to be tested.
 * @return  {@code true} if the character is a letter or digit;
 *          {@code false} otherwise.
 * @see     java.lang.Character#isDigit(int)
 * @see     java.lang.Character#isJavaIdentifierPart(int)
 * @see     java.lang.Character#isLetter(int)
 * @see     java.lang.Character#isUnicodeIdentifierPart(int)
 * @since   1.5
 * @apiSince 1
 */

public static boolean isLetterOrDigit(int codePoint) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the specified character is permissible as the first
 * character in a Java identifier.
 * <p>
 * A character may start a Java identifier if and only if
 * one of the following is true:
 * <ul>
 * <li> {@link #isLetter(char) isLetter(ch)} returns {@code true}
 * <li> {@link #getType(char) getType(ch)} returns {@code LETTER_NUMBER}
 * <li> {@code ch} is a currency symbol (such as {@code '$'})
 * <li> {@code ch} is a connecting punctuation character (such as {@code '_'}).
 * </ul>
 *
 * @param   ch the character to be tested.
 * @return  {@code true} if the character may start a Java
 *          identifier; {@code false} otherwise.
 * @see     java.lang.Character#isJavaLetterOrDigit(char)
 * @see     java.lang.Character#isJavaIdentifierStart(char)
 * @see     java.lang.Character#isJavaIdentifierPart(char)
 * @see     java.lang.Character#isLetter(char)
 * @see     java.lang.Character#isLetterOrDigit(char)
 * @see     java.lang.Character#isUnicodeIdentifierStart(char)
 * @since   1.02
 * @deprecated Replaced by isJavaIdentifierStart(char).
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static boolean isJavaLetter(char ch) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the specified character may be part of a Java
 * identifier as other than the first character.
 * <p>
 * A character may be part of a Java identifier if and only if any
 * of the following are true:
 * <ul>
 * <li>  it is a letter
 * <li>  it is a currency symbol (such as {@code '$'})
 * <li>  it is a connecting punctuation character (such as {@code '_'})
 * <li>  it is a digit
 * <li>  it is a numeric letter (such as a Roman numeral character)
 * <li>  it is a combining mark
 * <li>  it is a non-spacing mark
 * <li> {@code isIdentifierIgnorable} returns
 * {@code true} for the character.
 * </ul>
 *
 * @param   ch the character to be tested.
 * @return  {@code true} if the character may be part of a
 *          Java identifier; {@code false} otherwise.
 * @see     java.lang.Character#isJavaLetter(char)
 * @see     java.lang.Character#isJavaIdentifierStart(char)
 * @see     java.lang.Character#isJavaIdentifierPart(char)
 * @see     java.lang.Character#isLetter(char)
 * @see     java.lang.Character#isLetterOrDigit(char)
 * @see     java.lang.Character#isUnicodeIdentifierPart(char)
 * @see     java.lang.Character#isIdentifierIgnorable(char)
 * @since   1.02
 * @deprecated Replaced by isJavaIdentifierPart(char).
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static boolean isJavaLetterOrDigit(char ch) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the specified character (Unicode code point) is an alphabet.
 * <p>
 * A character is considered to be alphabetic if its general category type,
 * provided by {@link java.lang.Character#getType(int) Character#getType(int)}, is any of
 * the following:
 * <ul>
 * <li> <code>UPPERCASE_LETTER</code>
 * <li> <code>LOWERCASE_LETTER</code>
 * <li> <code>TITLECASE_LETTER</code>
 * <li> <code>MODIFIER_LETTER</code>
 * <li> <code>OTHER_LETTER</code>
 * <li> <code>LETTER_NUMBER</code>
 * </ul>
 * or it has contributory property Other_Alphabetic as defined by the
 * Unicode Standard.
 *
 * @param   codePoint the character (Unicode code point) to be tested.
 * @return  <code>true</code> if the character is a Unicode alphabet
 *          character, <code>false</code> otherwise.
 * @since   1.7
 * @apiSince 19
 */

public static boolean isAlphabetic(int codePoint) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the specified character (Unicode code point) is a CJKV
 * (Chinese, Japanese, Korean and Vietnamese) ideograph, as defined by
 * the Unicode Standard.
 *
 * @param   codePoint the character (Unicode code point) to be tested.
 * @return  <code>true</code> if the character is a Unicode ideograph
 *          character, <code>false</code> otherwise.
 * @since   1.7
 * @apiSince 19
 */

public static boolean isIdeographic(int codePoint) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the specified character is
 * permissible as the first character in a Java identifier.
 * <p>
 * A character may start a Java identifier if and only if
 * one of the following conditions is true:
 * <ul>
 * <li> {@link #isLetter(char) isLetter(ch)} returns {@code true}
 * <li> {@link #getType(char) getType(ch)} returns {@code LETTER_NUMBER}
 * <li> {@code ch} is a currency symbol (such as {@code '$'})
 * <li> {@code ch} is a connecting punctuation character (such as {@code '_'}).
 * </ul>
 *
 * <p><b>Note:</b> This method cannot handle <a
 * href="#supplementary"> supplementary characters</a>. To support
 * all Unicode characters, including supplementary characters, use
 * the {@link #isJavaIdentifierStart(int)} method.
 *
 * @param   ch the character to be tested.
 * @return  {@code true} if the character may start a Java identifier;
 *          {@code false} otherwise.
 * @see     java.lang.Character#isJavaIdentifierPart(char)
 * @see     java.lang.Character#isLetter(char)
 * @see     java.lang.Character#isUnicodeIdentifierStart(char)
 * @since   1.1
 * @apiSince 1
 */

public static boolean isJavaIdentifierStart(char ch) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the character (Unicode code point) is
 * permissible as the first character in a Java identifier.
 * <p>
 * A character may start a Java identifier if and only if
 * one of the following conditions is true:
 * <ul>
 * <li> {@link #isLetter(int) isLetter(codePoint)}
 *      returns {@code true}
 * <li> {@link #getType(int) getType(codePoint)}
 *      returns {@code LETTER_NUMBER}
 * <li> the referenced character is a currency symbol (such as {@code '$'})
 * <li> the referenced character is a connecting punctuation character
 *      (such as {@code '_'}).
 * </ul>
 *
 * @param   codePoint the character (Unicode code point) to be tested.
 * @return  {@code true} if the character may start a Java identifier;
 *          {@code false} otherwise.
 * @see     java.lang.Character#isJavaIdentifierPart(int)
 * @see     java.lang.Character#isLetter(int)
 * @see     java.lang.Character#isUnicodeIdentifierStart(int)
 * @since   1.5
 * @apiSince 1
 */

public static boolean isJavaIdentifierStart(int codePoint) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the specified character may be part of a Java
 * identifier as other than the first character.
 * <p>
 * A character may be part of a Java identifier if any of the following
 * are true:
 * <ul>
 * <li>  it is a letter
 * <li>  it is a currency symbol (such as {@code '$'})
 * <li>  it is a connecting punctuation character (such as {@code '_'})
 * <li>  it is a digit
 * <li>  it is a numeric letter (such as a Roman numeral character)
 * <li>  it is a combining mark
 * <li>  it is a non-spacing mark
 * <li> {@code isIdentifierIgnorable} returns
 * {@code true} for the character
 * </ul>
 *
 * <p><b>Note:</b> This method cannot handle <a
 * href="#supplementary"> supplementary characters</a>. To support
 * all Unicode characters, including supplementary characters, use
 * the {@link #isJavaIdentifierPart(int)} method.
 *
 * @param   ch      the character to be tested.
 * @return {@code true} if the character may be part of a
 *          Java identifier; {@code false} otherwise.
 * @see     java.lang.Character#isIdentifierIgnorable(char)
 * @see     java.lang.Character#isJavaIdentifierStart(char)
 * @see     java.lang.Character#isLetterOrDigit(char)
 * @see     java.lang.Character#isUnicodeIdentifierPart(char)
 * @since   1.1
 * @apiSince 1
 */

public static boolean isJavaIdentifierPart(char ch) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the character (Unicode code point) may be part of a Java
 * identifier as other than the first character.
 * <p>
 * A character may be part of a Java identifier if any of the following
 * are true:
 * <ul>
 * <li>  it is a letter
 * <li>  it is a currency symbol (such as {@code '$'})
 * <li>  it is a connecting punctuation character (such as {@code '_'})
 * <li>  it is a digit
 * <li>  it is a numeric letter (such as a Roman numeral character)
 * <li>  it is a combining mark
 * <li>  it is a non-spacing mark
 * <li> {@link #isIdentifierIgnorable(int)
 * isIdentifierIgnorable(codePoint)} returns {@code true} for
 * the character
 * </ul>
 *
 * @param   codePoint the character (Unicode code point) to be tested.
 * @return {@code true} if the character may be part of a
 *          Java identifier; {@code false} otherwise.
 * @see     java.lang.Character#isIdentifierIgnorable(int)
 * @see     java.lang.Character#isJavaIdentifierStart(int)
 * @see     java.lang.Character#isLetterOrDigit(int)
 * @see     java.lang.Character#isUnicodeIdentifierPart(int)
 * @since   1.5
 * @apiSince 1
 */

public static boolean isJavaIdentifierPart(int codePoint) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the specified character is permissible as the
 * first character in a Unicode identifier.
 * <p>
 * A character may start a Unicode identifier if and only if
 * one of the following conditions is true:
 * <ul>
 * <li> {@link #isLetter(char) isLetter(ch)} returns {@code true}
 * <li> {@link #getType(char) getType(ch)} returns
 *      {@code LETTER_NUMBER}.
 * </ul>
 *
 * <p><b>Note:</b> This method cannot handle <a
 * href="#supplementary"> supplementary characters</a>. To support
 * all Unicode characters, including supplementary characters, use
 * the {@link #isUnicodeIdentifierStart(int)} method.
 *
 * @param   ch      the character to be tested.
 * @return  {@code true} if the character may start a Unicode
 *          identifier; {@code false} otherwise.
 * @see     java.lang.Character#isJavaIdentifierStart(char)
 * @see     java.lang.Character#isLetter(char)
 * @see     java.lang.Character#isUnicodeIdentifierPart(char)
 * @since   1.1
 * @apiSince 1
 */

public static boolean isUnicodeIdentifierStart(char ch) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the specified character (Unicode code point) is permissible as the
 * first character in a Unicode identifier.
 * <p>
 * A character may start a Unicode identifier if and only if
 * one of the following conditions is true:
 * <ul>
 * <li> {@link #isLetter(int) isLetter(codePoint)}
 *      returns {@code true}
 * <li> {@link #getType(int) getType(codePoint)}
 *      returns {@code LETTER_NUMBER}.
 * </ul>
 * @param   codePoint the character (Unicode code point) to be tested.
 * @return  {@code true} if the character may start a Unicode
 *          identifier; {@code false} otherwise.
 * @see     java.lang.Character#isJavaIdentifierStart(int)
 * @see     java.lang.Character#isLetter(int)
 * @see     java.lang.Character#isUnicodeIdentifierPart(int)
 * @since   1.5
 * @apiSince 1
 */

public static boolean isUnicodeIdentifierStart(int codePoint) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the specified character may be part of a Unicode
 * identifier as other than the first character.
 * <p>
 * A character may be part of a Unicode identifier if and only if
 * one of the following statements is true:
 * <ul>
 * <li>  it is a letter
 * <li>  it is a connecting punctuation character (such as {@code '_'})
 * <li>  it is a digit
 * <li>  it is a numeric letter (such as a Roman numeral character)
 * <li>  it is a combining mark
 * <li>  it is a non-spacing mark
 * <li> {@code isIdentifierIgnorable} returns
 * {@code true} for this character.
 * </ul>
 *
 * <p><b>Note:</b> This method cannot handle <a
 * href="#supplementary"> supplementary characters</a>. To support
 * all Unicode characters, including supplementary characters, use
 * the {@link #isUnicodeIdentifierPart(int)} method.
 *
 * @param   ch      the character to be tested.
 * @return  {@code true} if the character may be part of a
 *          Unicode identifier; {@code false} otherwise.
 * @see     java.lang.Character#isIdentifierIgnorable(char)
 * @see     java.lang.Character#isJavaIdentifierPart(char)
 * @see     java.lang.Character#isLetterOrDigit(char)
 * @see     java.lang.Character#isUnicodeIdentifierStart(char)
 * @since   1.1
 * @apiSince 1
 */

public static boolean isUnicodeIdentifierPart(char ch) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the specified character (Unicode code point) may be part of a Unicode
 * identifier as other than the first character.
 * <p>
 * A character may be part of a Unicode identifier if and only if
 * one of the following statements is true:
 * <ul>
 * <li>  it is a letter
 * <li>  it is a connecting punctuation character (such as {@code '_'})
 * <li>  it is a digit
 * <li>  it is a numeric letter (such as a Roman numeral character)
 * <li>  it is a combining mark
 * <li>  it is a non-spacing mark
 * <li> {@code isIdentifierIgnorable} returns
 * {@code true} for this character.
 * </ul>
 * @param   codePoint the character (Unicode code point) to be tested.
 * @return  {@code true} if the character may be part of a
 *          Unicode identifier; {@code false} otherwise.
 * @see     java.lang.Character#isIdentifierIgnorable(int)
 * @see     java.lang.Character#isJavaIdentifierPart(int)
 * @see     java.lang.Character#isLetterOrDigit(int)
 * @see     java.lang.Character#isUnicodeIdentifierStart(int)
 * @since   1.5
 * @apiSince 1
 */

public static boolean isUnicodeIdentifierPart(int codePoint) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the specified character should be regarded as
 * an ignorable character in a Java identifier or a Unicode identifier.
 * <p>
 * The following Unicode characters are ignorable in a Java identifier
 * or a Unicode identifier:
 * <ul>
 * <li>ISO control characters that are not whitespace
 * <ul>
 * <li>{@code '\u005Cu0000'} through {@code '\u005Cu0008'}
 * <li>{@code '\u005Cu000E'} through {@code '\u005Cu001B'}
 * <li>{@code '\u005Cu007F'} through {@code '\u005Cu009F'}
 * </ul>
 *
 * <li>all characters that have the {@code FORMAT} general
 * category value
 * </ul>
 *
 * <p><b>Note:</b> This method cannot handle <a
 * href="#supplementary"> supplementary characters</a>. To support
 * all Unicode characters, including supplementary characters, use
 * the {@link #isIdentifierIgnorable(int)} method.
 *
 * @param   ch      the character to be tested.
 * @return  {@code true} if the character is an ignorable control
 *          character that may be part of a Java or Unicode identifier;
 *           {@code false} otherwise.
 * @see     java.lang.Character#isJavaIdentifierPart(char)
 * @see     java.lang.Character#isUnicodeIdentifierPart(char)
 * @since   1.1
 * @apiSince 1
 */

public static boolean isIdentifierIgnorable(char ch) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the specified character (Unicode code point) should be regarded as
 * an ignorable character in a Java identifier or a Unicode identifier.
 * <p>
 * The following Unicode characters are ignorable in a Java identifier
 * or a Unicode identifier:
 * <ul>
 * <li>ISO control characters that are not whitespace
 * <ul>
 * <li>{@code '\u005Cu0000'} through {@code '\u005Cu0008'}
 * <li>{@code '\u005Cu000E'} through {@code '\u005Cu001B'}
 * <li>{@code '\u005Cu007F'} through {@code '\u005Cu009F'}
 * </ul>
 *
 * <li>all characters that have the {@code FORMAT} general
 * category value
 * </ul>
 *
 * @param   codePoint the character (Unicode code point) to be tested.
 * @return  {@code true} if the character is an ignorable control
 *          character that may be part of a Java or Unicode identifier;
 *          {@code false} otherwise.
 * @see     java.lang.Character#isJavaIdentifierPart(int)
 * @see     java.lang.Character#isUnicodeIdentifierPart(int)
 * @since   1.5
 * @apiSince 1
 */

public static boolean isIdentifierIgnorable(int codePoint) { throw new RuntimeException("Stub!"); }

/**
 * Converts the character argument to lowercase using case
 * mapping information from the UnicodeData file.
 * <p>
 * Note that
 * {@code Character.isLowerCase(Character.toLowerCase(ch))}
 * does not always return {@code true} for some ranges of
 * characters, particularly those that are symbols or ideographs.
 *
 * <p>In general, {@link java.lang.String#toLowerCase() String#toLowerCase()} should be used to map
 * characters to lowercase. {@code String} case mapping methods
 * have several benefits over {@code Character} case mapping methods.
 * {@code String} case mapping methods can perform locale-sensitive
 * mappings, context-sensitive mappings, and 1:M character mappings, whereas
 * the {@code Character} case mapping methods cannot.
 *
 * <p><b>Note:</b> This method cannot handle <a
 * href="#supplementary"> supplementary characters</a>. To support
 * all Unicode characters, including supplementary characters, use
 * the {@link #toLowerCase(int)} method.
 *
 * @param   ch   the character to be converted.
 * @return  the lowercase equivalent of the character, if any;
 *          otherwise, the character itself.
 * @see     java.lang.Character#isLowerCase(char)
 * @see     java.lang.String#toLowerCase()
 * @apiSince 1
 */

public static char toLowerCase(char ch) { throw new RuntimeException("Stub!"); }

/**
 * Converts the character (Unicode code point) argument to
 * lowercase using case mapping information from the UnicodeData
 * file.
 *
 * <p> Note that
 * {@code Character.isLowerCase(Character.toLowerCase(codePoint))}
 * does not always return {@code true} for some ranges of
 * characters, particularly those that are symbols or ideographs.
 *
 * <p>In general, {@link java.lang.String#toLowerCase() String#toLowerCase()} should be used to map
 * characters to lowercase. {@code String} case mapping methods
 * have several benefits over {@code Character} case mapping methods.
 * {@code String} case mapping methods can perform locale-sensitive
 * mappings, context-sensitive mappings, and 1:M character mappings, whereas
 * the {@code Character} case mapping methods cannot.
 *
 * @param   codePoint   the character (Unicode code point) to be converted.
 * @return  the lowercase equivalent of the character (Unicode code
 *          point), if any; otherwise, the character itself.
 * @see     java.lang.Character#isLowerCase(int)
 * @see     java.lang.String#toLowerCase()
 *
 * @since   1.5
 * @apiSince 1
 */

public static int toLowerCase(int codePoint) { throw new RuntimeException("Stub!"); }

/**
 * Converts the character argument to uppercase using case mapping
 * information from the UnicodeData file.
 * <p>
 * Note that
 * {@code Character.isUpperCase(Character.toUpperCase(ch))}
 * does not always return {@code true} for some ranges of
 * characters, particularly those that are symbols or ideographs.
 *
 * <p>In general, {@link java.lang.String#toUpperCase() String#toUpperCase()} should be used to map
 * characters to uppercase. {@code String} case mapping methods
 * have several benefits over {@code Character} case mapping methods.
 * {@code String} case mapping methods can perform locale-sensitive
 * mappings, context-sensitive mappings, and 1:M character mappings, whereas
 * the {@code Character} case mapping methods cannot.
 *
 * <p><b>Note:</b> This method cannot handle <a
 * href="#supplementary"> supplementary characters</a>. To support
 * all Unicode characters, including supplementary characters, use
 * the {@link #toUpperCase(int)} method.
 *
 * @param   ch   the character to be converted.
 * @return  the uppercase equivalent of the character, if any;
 *          otherwise, the character itself.
 * @see     java.lang.Character#isUpperCase(char)
 * @see     java.lang.String#toUpperCase()
 * @apiSince 1
 */

public static char toUpperCase(char ch) { throw new RuntimeException("Stub!"); }

/**
 * Converts the character (Unicode code point) argument to
 * uppercase using case mapping information from the UnicodeData
 * file.
 *
 * <p>Note that
 * {@code Character.isUpperCase(Character.toUpperCase(codePoint))}
 * does not always return {@code true} for some ranges of
 * characters, particularly those that are symbols or ideographs.
 *
 * <p>In general, {@link java.lang.String#toUpperCase() String#toUpperCase()} should be used to map
 * characters to uppercase. {@code String} case mapping methods
 * have several benefits over {@code Character} case mapping methods.
 * {@code String} case mapping methods can perform locale-sensitive
 * mappings, context-sensitive mappings, and 1:M character mappings, whereas
 * the {@code Character} case mapping methods cannot.
 *
 * @param   codePoint   the character (Unicode code point) to be converted.
 * @return  the uppercase equivalent of the character, if any;
 *          otherwise, the character itself.
 * @see     java.lang.Character#isUpperCase(int)
 * @see     java.lang.String#toUpperCase()
 *
 * @since   1.5
 * @apiSince 1
 */

public static int toUpperCase(int codePoint) { throw new RuntimeException("Stub!"); }

/**
 * Converts the character argument to titlecase using case mapping
 * information from the UnicodeData file. If a character has no
 * explicit titlecase mapping and is not itself a titlecase char
 * according to UnicodeData, then the uppercase mapping is
 * returned as an equivalent titlecase mapping. If the
 * {@code char} argument is already a titlecase
 * {@code char}, the same {@code char} value will be
 * returned.
 * <p>
 * Note that
 * {@code Character.isTitleCase(Character.toTitleCase(ch))}
 * does not always return {@code true} for some ranges of
 * characters.
 *
 * <p><b>Note:</b> This method cannot handle <a
 * href="#supplementary"> supplementary characters</a>. To support
 * all Unicode characters, including supplementary characters, use
 * the {@link #toTitleCase(int)} method.
 *
 * @param   ch   the character to be converted.
 * @return  the titlecase equivalent of the character, if any;
 *          otherwise, the character itself.
 * @see     java.lang.Character#isTitleCase(char)
 * @see     java.lang.Character#toLowerCase(char)
 * @see     java.lang.Character#toUpperCase(char)
 * @since   1.0.2
 * @apiSince 1
 */

public static char toTitleCase(char ch) { throw new RuntimeException("Stub!"); }

/**
 * Converts the character (Unicode code point) argument to titlecase using case mapping
 * information from the UnicodeData file. If a character has no
 * explicit titlecase mapping and is not itself a titlecase char
 * according to UnicodeData, then the uppercase mapping is
 * returned as an equivalent titlecase mapping. If the
 * character argument is already a titlecase
 * character, the same character value will be
 * returned.
 *
 * <p>Note that
 * {@code Character.isTitleCase(Character.toTitleCase(codePoint))}
 * does not always return {@code true} for some ranges of
 * characters.
 *
 * @param   codePoint   the character (Unicode code point) to be converted.
 * @return  the titlecase equivalent of the character, if any;
 *          otherwise, the character itself.
 * @see     java.lang.Character#isTitleCase(int)
 * @see     java.lang.Character#toLowerCase(int)
 * @see     java.lang.Character#toUpperCase(int)
 * @since   1.5
 * @apiSince 1
 */

public static int toTitleCase(int codePoint) { throw new RuntimeException("Stub!"); }

/**
 * Returns the numeric value of the character {@code ch} in the
 * specified radix.
 * <p>
 * If the radix is not in the range {@code MIN_RADIX} &le;
 * {@code radix} &le; {@code MAX_RADIX} or if the
 * value of {@code ch} is not a valid digit in the specified
 * radix, {@code -1} is returned. A character is a valid digit
 * if at least one of the following is true:
 * <ul>
 * <li>The method {@code isDigit} is {@code true} of the character
 *     and the Unicode decimal digit value of the character (or its
 *     single-character decomposition) is less than the specified radix.
 *     In this case the decimal digit value is returned.
 * <li>The character is one of the uppercase Latin letters
 *     {@code 'A'} through {@code 'Z'} and its code is less than
 *     {@code radix + 'A' - 10}.
 *     In this case, {@code ch - 'A' + 10}
 *     is returned.
 * <li>The character is one of the lowercase Latin letters
 *     {@code 'a'} through {@code 'z'} and its code is less than
 *     {@code radix + 'a' - 10}.
 *     In this case, {@code ch - 'a' + 10}
 *     is returned.
 * <li>The character is one of the fullwidth uppercase Latin letters A
 *     ({@code '\u005CuFF21'}) through Z ({@code '\u005CuFF3A'})
 *     and its code is less than
 *     {@code radix + '\u005CuFF21' - 10}.
 *     In this case, {@code ch - '\u005CuFF21' + 10}
 *     is returned.
 * <li>The character is one of the fullwidth lowercase Latin letters a
 *     ({@code '\u005CuFF41'}) through z ({@code '\u005CuFF5A'})
 *     and its code is less than
 *     {@code radix + '\u005CuFF41' - 10}.
 *     In this case, {@code ch - '\u005CuFF41' + 10}
 *     is returned.
 * </ul>
 *
 * <p><b>Note:</b> This method cannot handle <a
 * href="#supplementary"> supplementary characters</a>. To support
 * all Unicode characters, including supplementary characters, use
 * the {@link #digit(int,int)} method.
 *
 * @param   ch      the character to be converted.
 * @param   radix   the radix.
 * @return  the numeric value represented by the character in the
 *          specified radix.
 * @see     java.lang.Character#forDigit(int, int)
 * @see     java.lang.Character#isDigit(char)
 * @apiSince 1
 */

public static int digit(char ch, int radix) { throw new RuntimeException("Stub!"); }

/**
 * Returns the numeric value of the specified character (Unicode
 * code point) in the specified radix.
 *
 * <p>If the radix is not in the range {@code MIN_RADIX} &le;
 * {@code radix} &le; {@code MAX_RADIX} or if the
 * character is not a valid digit in the specified
 * radix, {@code -1} is returned. A character is a valid digit
 * if at least one of the following is true:
 * <ul>
 * <li>The method {@link #isDigit(int) isDigit(codePoint)} is {@code true} of the character
 *     and the Unicode decimal digit value of the character (or its
 *     single-character decomposition) is less than the specified radix.
 *     In this case the decimal digit value is returned.
 * <li>The character is one of the uppercase Latin letters
 *     {@code 'A'} through {@code 'Z'} and its code is less than
 *     {@code radix + 'A' - 10}.
 *     In this case, {@code codePoint - 'A' + 10}
 *     is returned.
 * <li>The character is one of the lowercase Latin letters
 *     {@code 'a'} through {@code 'z'} and its code is less than
 *     {@code radix + 'a' - 10}.
 *     In this case, {@code codePoint - 'a' + 10}
 *     is returned.
 * <li>The character is one of the fullwidth uppercase Latin letters A
 *     ({@code '\u005CuFF21'}) through Z ({@code '\u005CuFF3A'})
 *     and its code is less than
 *     {@code radix + '\u005CuFF21' - 10}.
 *     In this case,
 *     {@code codePoint - '\u005CuFF21' + 10}
 *     is returned.
 * <li>The character is one of the fullwidth lowercase Latin letters a
 *     ({@code '\u005CuFF41'}) through z ({@code '\u005CuFF5A'})
 *     and its code is less than
 *     {@code radix + '\u005CuFF41'- 10}.
 *     In this case,
 *     {@code codePoint - '\u005CuFF41' + 10}
 *     is returned.
 * </ul>
 *
 * @param   codePoint the character (Unicode code point) to be converted.
 * @param   radix   the radix.
 * @return  the numeric value represented by the character in the
 *          specified radix.
 * @see     java.lang.Character#forDigit(int, int)
 * @see     java.lang.Character#isDigit(int)
 * @since   1.5
 * @apiSince 1
 */

public static int digit(int codePoint, int radix) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@code int} value that the specified Unicode
 * character represents. For example, the character
 * {@code '\u005Cu216C'} (the roman numeral fifty) will return
 * an int with a value of 50.
 * <p>
 * The letters A-Z in their uppercase ({@code '\u005Cu0041'} through
 * {@code '\u005Cu005A'}), lowercase
 * ({@code '\u005Cu0061'} through {@code '\u005Cu007A'}), and
 * full width variant ({@code '\u005CuFF21'} through
 * {@code '\u005CuFF3A'} and {@code '\u005CuFF41'} through
 * {@code '\u005CuFF5A'}) forms have numeric values from 10
 * through 35. This is independent of the Unicode specification,
 * which does not assign numeric values to these {@code char}
 * values.
 * <p>
 * If the character does not have a numeric value, then -1 is returned.
 * If the character has a numeric value that cannot be represented as a
 * nonnegative integer (for example, a fractional value), then -2
 * is returned.
 *
 * <p><b>Note:</b> This method cannot handle <a
 * href="#supplementary"> supplementary characters</a>. To support
 * all Unicode characters, including supplementary characters, use
 * the {@link #getNumericValue(int)} method.
 *
 * @param   ch      the character to be converted.
 * @return  the numeric value of the character, as a nonnegative {@code int}
 *           value; -2 if the character has a numeric value that is not a
 *          nonnegative integer; -1 if the character has no numeric value.
 * @see     java.lang.Character#forDigit(int, int)
 * @see     java.lang.Character#isDigit(char)
 * @since   1.1
 * @apiSince 1
 */

public static int getNumericValue(char ch) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@code int} value that the specified
 * character (Unicode code point) represents. For example, the character
 * {@code '\u005Cu216C'} (the Roman numeral fifty) will return
 * an {@code int} with a value of 50.
 * <p>
 * The letters A-Z in their uppercase ({@code '\u005Cu0041'} through
 * {@code '\u005Cu005A'}), lowercase
 * ({@code '\u005Cu0061'} through {@code '\u005Cu007A'}), and
 * full width variant ({@code '\u005CuFF21'} through
 * {@code '\u005CuFF3A'} and {@code '\u005CuFF41'} through
 * {@code '\u005CuFF5A'}) forms have numeric values from 10
 * through 35. This is independent of the Unicode specification,
 * which does not assign numeric values to these {@code char}
 * values.
 * <p>
 * If the character does not have a numeric value, then -1 is returned.
 * If the character has a numeric value that cannot be represented as a
 * nonnegative integer (for example, a fractional value), then -2
 * is returned.
 *
 * @param   codePoint the character (Unicode code point) to be converted.
 * @return  the numeric value of the character, as a nonnegative {@code int}
 *          value; -2 if the character has a numeric value that is not a
 *          nonnegative integer; -1 if the character has no numeric value.
 * @see     java.lang.Character#forDigit(int, int)
 * @see     java.lang.Character#isDigit(int)
 * @since   1.5
 * @apiSince 1
 */

public static int getNumericValue(int codePoint) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the specified character is ISO-LATIN-1 white space.
 * This method returns {@code true} for the following five
 * characters only:
 * <table summary="truechars">
 * <tr><td>{@code '\t'}</td>            <td>{@code U+0009}</td>
 *     <td>{@code HORIZONTAL TABULATION}</td></tr>
 * <tr><td>{@code '\n'}</td>            <td>{@code U+000A}</td>
 *     <td>{@code NEW LINE}</td></tr>
 * <tr><td>{@code '\f'}</td>            <td>{@code U+000C}</td>
 *     <td>{@code FORM FEED}</td></tr>
 * <tr><td>{@code '\r'}</td>            <td>{@code U+000D}</td>
 *     <td>{@code CARRIAGE RETURN}</td></tr>
 * <tr><td>{@code ' '}</td>             <td>{@code U+0020}</td>
 *     <td>{@code SPACE}</td></tr>
 * </table>
 *
 * @param      ch   the character to be tested.
 * @return     {@code true} if the character is ISO-LATIN-1 white
 *             space; {@code false} otherwise.
 * @see        java.lang.Character#isSpaceChar(char)
 * @see        java.lang.Character#isWhitespace(char)
 * @deprecated Replaced by isWhitespace(char).
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static boolean isSpace(char ch) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the specified character is a Unicode space character.
 * A character is considered to be a space character if and only if
 * it is specified to be a space character by the Unicode Standard. This
 * method returns true if the character's general category type is any of
 * the following:
 * <ul>
 * <li> {@code SPACE_SEPARATOR}
 * <li> {@code LINE_SEPARATOR}
 * <li> {@code PARAGRAPH_SEPARATOR}
 * </ul>
 *
 * <p><b>Note:</b> This method cannot handle <a
 * href="#supplementary"> supplementary characters</a>. To support
 * all Unicode characters, including supplementary characters, use
 * the {@link #isSpaceChar(int)} method.
 *
 * @param   ch      the character to be tested.
 * @return  {@code true} if the character is a space character;
 *          {@code false} otherwise.
 * @see     java.lang.Character#isWhitespace(char)
 * @since   1.1
 * @apiSince 1
 */

public static boolean isSpaceChar(char ch) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the specified character (Unicode code point) is a
 * Unicode space character.  A character is considered to be a
 * space character if and only if it is specified to be a space
 * character by the Unicode Standard. This method returns true if
 * the character's general category type is any of the following:
 *
 * <ul>
 * <li> {@link #SPACE_SEPARATOR}
 * <li> {@link #LINE_SEPARATOR}
 * <li> {@link #PARAGRAPH_SEPARATOR}
 * </ul>
 *
 * @param   codePoint the character (Unicode code point) to be tested.
 * @return  {@code true} if the character is a space character;
 *          {@code false} otherwise.
 * @see     java.lang.Character#isWhitespace(int)
 * @since   1.5
 * @apiSince 1
 */

public static boolean isSpaceChar(int codePoint) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the specified character is white space according to Java.
 * A character is a Java whitespace character if and only if it satisfies
 * one of the following criteria:
 * <ul>
 * <li> It is a Unicode space character ({@code SPACE_SEPARATOR},
 *      {@code LINE_SEPARATOR}, or {@code PARAGRAPH_SEPARATOR})
 *      but is not also a non-breaking space ({@code '\u005Cu00A0'},
 *      {@code '\u005Cu2007'}, {@code '\u005Cu202F'}).
 * <li> It is {@code '\u005Ct'}, U+0009 HORIZONTAL TABULATION.
 * <li> It is {@code '\u005Cn'}, U+000A LINE FEED.
 * <li> It is {@code '\u005Cu000B'}, U+000B VERTICAL TABULATION.
 * <li> It is {@code '\u005Cf'}, U+000C FORM FEED.
 * <li> It is {@code '\u005Cr'}, U+000D CARRIAGE RETURN.
 * <li> It is {@code '\u005Cu001C'}, U+001C FILE SEPARATOR.
 * <li> It is {@code '\u005Cu001D'}, U+001D GROUP SEPARATOR.
 * <li> It is {@code '\u005Cu001E'}, U+001E RECORD SEPARATOR.
 * <li> It is {@code '\u005Cu001F'}, U+001F UNIT SEPARATOR.
 * </ul>
 *
 * <p><b>Note:</b> This method cannot handle <a
 * href="#supplementary"> supplementary characters</a>. To support
 * all Unicode characters, including supplementary characters, use
 * the {@link #isWhitespace(int)} method.
 *
 * @param   ch the character to be tested.
 * @return  {@code true} if the character is a Java whitespace
 *          character; {@code false} otherwise.
 * @see     java.lang.Character#isSpaceChar(char)
 * @since   1.1
 * @apiSince 1
 */

public static boolean isWhitespace(char ch) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the specified character (Unicode code point) is
 * white space according to Java.  A character is a Java
 * whitespace character if and only if it satisfies one of the
 * following criteria:
 * <ul>
 * <li> It is a Unicode space character ({@link #SPACE_SEPARATOR},
 *      {@link #LINE_SEPARATOR}, or {@link #PARAGRAPH_SEPARATOR})
 *      but is not also a non-breaking space ({@code '\u005Cu00A0'},
 *      {@code '\u005Cu2007'}, {@code '\u005Cu202F'}).
 * <li> It is {@code '\u005Ct'}, U+0009 HORIZONTAL TABULATION.
 * <li> It is {@code '\u005Cn'}, U+000A LINE FEED.
 * <li> It is {@code '\u005Cu000B'}, U+000B VERTICAL TABULATION.
 * <li> It is {@code '\u005Cf'}, U+000C FORM FEED.
 * <li> It is {@code '\u005Cr'}, U+000D CARRIAGE RETURN.
 * <li> It is {@code '\u005Cu001C'}, U+001C FILE SEPARATOR.
 * <li> It is {@code '\u005Cu001D'}, U+001D GROUP SEPARATOR.
 * <li> It is {@code '\u005Cu001E'}, U+001E RECORD SEPARATOR.
 * <li> It is {@code '\u005Cu001F'}, U+001F UNIT SEPARATOR.
 * </ul>
 * <p>
 *
 * @param   codePoint the character (Unicode code point) to be tested.
 * @return  {@code true} if the character is a Java whitespace
 *          character; {@code false} otherwise.
 * @see     java.lang.Character#isSpaceChar(int)
 * @since   1.5
 * @apiSince 1
 */

public static boolean isWhitespace(int codePoint) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the specified character is an ISO control
 * character.  A character is considered to be an ISO control
 * character if its code is in the range {@code '\u005Cu0000'}
 * through {@code '\u005Cu001F'} or in the range
 * {@code '\u005Cu007F'} through {@code '\u005Cu009F'}.
 *
 * <p><b>Note:</b> This method cannot handle <a
 * href="#supplementary"> supplementary characters</a>. To support
 * all Unicode characters, including supplementary characters, use
 * the {@link #isISOControl(int)} method.
 *
 * @param   ch      the character to be tested.
 * @return  {@code true} if the character is an ISO control character;
 *          {@code false} otherwise.
 *
 * @see     java.lang.Character#isSpaceChar(char)
 * @see     java.lang.Character#isWhitespace(char)
 * @since   1.1
 * @apiSince 1
 */

public static boolean isISOControl(char ch) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the referenced character (Unicode code point) is an ISO control
 * character.  A character is considered to be an ISO control
 * character if its code is in the range {@code '\u005Cu0000'}
 * through {@code '\u005Cu001F'} or in the range
 * {@code '\u005Cu007F'} through {@code '\u005Cu009F'}.
 *
 * @param   codePoint the character (Unicode code point) to be tested.
 * @return  {@code true} if the character is an ISO control character;
 *          {@code false} otherwise.
 * @see     java.lang.Character#isSpaceChar(int)
 * @see     java.lang.Character#isWhitespace(int)
 * @since   1.5
 * @apiSince 1
 */

public static boolean isISOControl(int codePoint) { throw new RuntimeException("Stub!"); }

/**
 * Returns a value indicating a character's general category.
 *
 * <p><b>Note:</b> This method cannot handle <a
 * href="#supplementary"> supplementary characters</a>. To support
 * all Unicode characters, including supplementary characters, use
 * the {@link #getType(int)} method.
 *
 * @param   ch      the character to be tested.
 * @return  a value of type {@code int} representing the
 *          character's general category.
 * @see     java.lang.Character#COMBINING_SPACING_MARK
 * @see     java.lang.Character#CONNECTOR_PUNCTUATION
 * @see     java.lang.Character#CONTROL
 * @see     java.lang.Character#CURRENCY_SYMBOL
 * @see     java.lang.Character#DASH_PUNCTUATION
 * @see     java.lang.Character#DECIMAL_DIGIT_NUMBER
 * @see     java.lang.Character#ENCLOSING_MARK
 * @see     java.lang.Character#END_PUNCTUATION
 * @see     java.lang.Character#FINAL_QUOTE_PUNCTUATION
 * @see     java.lang.Character#FORMAT
 * @see     java.lang.Character#INITIAL_QUOTE_PUNCTUATION
 * @see     java.lang.Character#LETTER_NUMBER
 * @see     java.lang.Character#LINE_SEPARATOR
 * @see     java.lang.Character#LOWERCASE_LETTER
 * @see     java.lang.Character#MATH_SYMBOL
 * @see     java.lang.Character#MODIFIER_LETTER
 * @see     java.lang.Character#MODIFIER_SYMBOL
 * @see     java.lang.Character#NON_SPACING_MARK
 * @see     java.lang.Character#OTHER_LETTER
 * @see     java.lang.Character#OTHER_NUMBER
 * @see     java.lang.Character#OTHER_PUNCTUATION
 * @see     java.lang.Character#OTHER_SYMBOL
 * @see     java.lang.Character#PARAGRAPH_SEPARATOR
 * @see     java.lang.Character#PRIVATE_USE
 * @see     java.lang.Character#SPACE_SEPARATOR
 * @see     java.lang.Character#START_PUNCTUATION
 * @see     java.lang.Character#SURROGATE
 * @see     java.lang.Character#TITLECASE_LETTER
 * @see     java.lang.Character#UNASSIGNED
 * @see     java.lang.Character#UPPERCASE_LETTER
 * @since   1.1
 * @apiSince 1
 */

public static int getType(char ch) { throw new RuntimeException("Stub!"); }

/**
 * Returns a value indicating a character's general category.
 *
 * @param   codePoint the character (Unicode code point) to be tested.
 * @return  a value of type {@code int} representing the
 *          character's general category.
 * @see     java.lang.Character#COMBINING_SPACING_MARK COMBINING_SPACING_MARK
 * @see     java.lang.Character#CONNECTOR_PUNCTUATION CONNECTOR_PUNCTUATION
 * @see     java.lang.Character#CONTROL CONTROL
 * @see     java.lang.Character#CURRENCY_SYMBOL CURRENCY_SYMBOL
 * @see     java.lang.Character#DASH_PUNCTUATION DASH_PUNCTUATION
 * @see     java.lang.Character#DECIMAL_DIGIT_NUMBER DECIMAL_DIGIT_NUMBER
 * @see     java.lang.Character#ENCLOSING_MARK ENCLOSING_MARK
 * @see     java.lang.Character#END_PUNCTUATION END_PUNCTUATION
 * @see     java.lang.Character#FINAL_QUOTE_PUNCTUATION FINAL_QUOTE_PUNCTUATION
 * @see     java.lang.Character#FORMAT FORMAT
 * @see     java.lang.Character#INITIAL_QUOTE_PUNCTUATION INITIAL_QUOTE_PUNCTUATION
 * @see     java.lang.Character#LETTER_NUMBER LETTER_NUMBER
 * @see     java.lang.Character#LINE_SEPARATOR LINE_SEPARATOR
 * @see     java.lang.Character#LOWERCASE_LETTER LOWERCASE_LETTER
 * @see     java.lang.Character#MATH_SYMBOL MATH_SYMBOL
 * @see     java.lang.Character#MODIFIER_LETTER MODIFIER_LETTER
 * @see     java.lang.Character#MODIFIER_SYMBOL MODIFIER_SYMBOL
 * @see     java.lang.Character#NON_SPACING_MARK NON_SPACING_MARK
 * @see     java.lang.Character#OTHER_LETTER OTHER_LETTER
 * @see     java.lang.Character#OTHER_NUMBER OTHER_NUMBER
 * @see     java.lang.Character#OTHER_PUNCTUATION OTHER_PUNCTUATION
 * @see     java.lang.Character#OTHER_SYMBOL OTHER_SYMBOL
 * @see     java.lang.Character#PARAGRAPH_SEPARATOR PARAGRAPH_SEPARATOR
 * @see     java.lang.Character#PRIVATE_USE PRIVATE_USE
 * @see     java.lang.Character#SPACE_SEPARATOR SPACE_SEPARATOR
 * @see     java.lang.Character#START_PUNCTUATION START_PUNCTUATION
 * @see     java.lang.Character#SURROGATE SURROGATE
 * @see     java.lang.Character#TITLECASE_LETTER TITLECASE_LETTER
 * @see     java.lang.Character#UNASSIGNED UNASSIGNED
 * @see     java.lang.Character#UPPERCASE_LETTER UPPERCASE_LETTER
 * @since   1.5
 * @apiSince 1
 */

public static int getType(int codePoint) { throw new RuntimeException("Stub!"); }

/**
 * Determines the character representation for a specific digit in
 * the specified radix. If the value of {@code radix} is not a
 * valid radix, or the value of {@code digit} is not a valid
 * digit in the specified radix, the null character
 * ({@code '\u005Cu0000'}) is returned.
 * <p>
 * The {@code radix} argument is valid if it is greater than or
 * equal to {@code MIN_RADIX} and less than or equal to
 * {@code MAX_RADIX}. The {@code digit} argument is valid if
 * {@code 0 <= digit < radix}.
 * <p>
 * If the digit is less than 10, then
 * {@code '0' + digit} is returned. Otherwise, the value
 * {@code 'a' + digit - 10} is returned.
 *
 * @param   digit   the number to convert to a character.
 * @param   radix   the radix.
 * @return  the {@code char} representation of the specified digit
 *          in the specified radix.
 * @see     java.lang.Character#MIN_RADIX
 * @see     java.lang.Character#MAX_RADIX
 * @see     java.lang.Character#digit(char, int)
 * @apiSince 1
 */

public static char forDigit(int digit, int radix) { throw new RuntimeException("Stub!"); }

/**
 * Returns the Unicode directionality property for the given
 * character.  Character directionality is used to calculate the
 * visual ordering of text. The directionality value of undefined
 * {@code char} values is {@code DIRECTIONALITY_UNDEFINED}.
 *
 * <p><b>Note:</b> This method cannot handle <a
 * href="#supplementary"> supplementary characters</a>. To support
 * all Unicode characters, including supplementary characters, use
 * the {@link #getDirectionality(int)} method.
 *
 * @param  ch {@code char} for which the directionality property
 *            is requested.
 * @return the directionality property of the {@code char} value.
 *
 * @see java.lang.Character#DIRECTIONALITY_UNDEFINED
 * @see java.lang.Character#DIRECTIONALITY_LEFT_TO_RIGHT
 * @see java.lang.Character#DIRECTIONALITY_RIGHT_TO_LEFT
 * @see java.lang.Character#DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC
 * @see java.lang.Character#DIRECTIONALITY_EUROPEAN_NUMBER
 * @see java.lang.Character#DIRECTIONALITY_EUROPEAN_NUMBER_SEPARATOR
 * @see java.lang.Character#DIRECTIONALITY_EUROPEAN_NUMBER_TERMINATOR
 * @see java.lang.Character#DIRECTIONALITY_ARABIC_NUMBER
 * @see java.lang.Character#DIRECTIONALITY_COMMON_NUMBER_SEPARATOR
 * @see java.lang.Character#DIRECTIONALITY_NONSPACING_MARK
 * @see java.lang.Character#DIRECTIONALITY_BOUNDARY_NEUTRAL
 * @see java.lang.Character#DIRECTIONALITY_PARAGRAPH_SEPARATOR
 * @see java.lang.Character#DIRECTIONALITY_SEGMENT_SEPARATOR
 * @see java.lang.Character#DIRECTIONALITY_WHITESPACE
 * @see java.lang.Character#DIRECTIONALITY_OTHER_NEUTRALS
 * @see java.lang.Character#DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING
 * @see java.lang.Character#DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE
 * @see java.lang.Character#DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING
 * @see java.lang.Character#DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE
 * @see java.lang.Character#DIRECTIONALITY_POP_DIRECTIONAL_FORMAT
 * @since 1.4
 * @apiSince 1
 */

public static byte getDirectionality(char ch) { throw new RuntimeException("Stub!"); }

/**
 * Returns the Unicode directionality property for the given
 * character (Unicode code point).  Character directionality is
 * used to calculate the visual ordering of text. The
 * directionality value of undefined character is {@link
 * #DIRECTIONALITY_UNDEFINED}.
 *
 * @param   codePoint the character (Unicode code point) for which
 *          the directionality property is requested.
 * @return the directionality property of the character.
 *
 * @see java.lang.Character#DIRECTIONALITY_UNDEFINED DIRECTIONALITY_UNDEFINED
 * @see java.lang.Character#DIRECTIONALITY_LEFT_TO_RIGHT DIRECTIONALITY_LEFT_TO_RIGHT
 * @see java.lang.Character#DIRECTIONALITY_RIGHT_TO_LEFT DIRECTIONALITY_RIGHT_TO_LEFT
 * @see java.lang.Character#DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC
 * @see java.lang.Character#DIRECTIONALITY_EUROPEAN_NUMBER DIRECTIONALITY_EUROPEAN_NUMBER
 * @see java.lang.Character#DIRECTIONALITY_EUROPEAN_NUMBER_SEPARATOR DIRECTIONALITY_EUROPEAN_NUMBER_SEPARATOR
 * @see java.lang.Character#DIRECTIONALITY_EUROPEAN_NUMBER_TERMINATOR DIRECTIONALITY_EUROPEAN_NUMBER_TERMINATOR
 * @see java.lang.Character#DIRECTIONALITY_ARABIC_NUMBER DIRECTIONALITY_ARABIC_NUMBER
 * @see java.lang.Character#DIRECTIONALITY_COMMON_NUMBER_SEPARATOR DIRECTIONALITY_COMMON_NUMBER_SEPARATOR
 * @see java.lang.Character#DIRECTIONALITY_NONSPACING_MARK DIRECTIONALITY_NONSPACING_MARK
 * @see java.lang.Character#DIRECTIONALITY_BOUNDARY_NEUTRAL DIRECTIONALITY_BOUNDARY_NEUTRAL
 * @see java.lang.Character#DIRECTIONALITY_PARAGRAPH_SEPARATOR DIRECTIONALITY_PARAGRAPH_SEPARATOR
 * @see java.lang.Character#DIRECTIONALITY_SEGMENT_SEPARATOR DIRECTIONALITY_SEGMENT_SEPARATOR
 * @see java.lang.Character#DIRECTIONALITY_WHITESPACE DIRECTIONALITY_WHITESPACE
 * @see java.lang.Character#DIRECTIONALITY_OTHER_NEUTRALS DIRECTIONALITY_OTHER_NEUTRALS
 * @see java.lang.Character#DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING
 * @see java.lang.Character#DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE
 * @see java.lang.Character#DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING
 * @see java.lang.Character#DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE
 * @see java.lang.Character#DIRECTIONALITY_POP_DIRECTIONAL_FORMAT DIRECTIONALITY_POP_DIRECTIONAL_FORMAT
 * @since    1.5
 * @apiSince 1
 */

public static byte getDirectionality(int codePoint) { throw new RuntimeException("Stub!"); }

/**
 * Determines whether the character is mirrored according to the
 * Unicode specification.  Mirrored characters should have their
 * glyphs horizontally mirrored when displayed in text that is
 * right-to-left.  For example, {@code '\u005Cu0028'} LEFT
 * PARENTHESIS is semantically defined to be an <i>opening
 * parenthesis</i>.  This will appear as a "(" in text that is
 * left-to-right but as a ")" in text that is right-to-left.
 *
 * <p><b>Note:</b> This method cannot handle <a
 * href="#supplementary"> supplementary characters</a>. To support
 * all Unicode characters, including supplementary characters, use
 * the {@link #isMirrored(int)} method.
 *
 * @param  ch {@code char} for which the mirrored property is requested
 * @return {@code true} if the char is mirrored, {@code false}
 *         if the {@code char} is not mirrored or is not defined.
 * @since 1.4
 * @apiSince 1
 */

public static boolean isMirrored(char ch) { throw new RuntimeException("Stub!"); }

/**
 * Determines whether the specified character (Unicode code point)
 * is mirrored according to the Unicode specification.  Mirrored
 * characters should have their glyphs horizontally mirrored when
 * displayed in text that is right-to-left.  For example,
 * {@code '\u005Cu0028'} LEFT PARENTHESIS is semantically
 * defined to be an <i>opening parenthesis</i>.  This will appear
 * as a "(" in text that is left-to-right but as a ")" in text
 * that is right-to-left.
 *
 * @param   codePoint the character (Unicode code point) to be tested.
 * @return  {@code true} if the character is mirrored, {@code false}
 *          if the character is not mirrored or is not defined.
 * @since   1.5
 * @apiSince 1
 */

public static boolean isMirrored(int codePoint) { throw new RuntimeException("Stub!"); }

/**
 * Compares two {@code Character} objects numerically.
 *
 * @param   anotherCharacter   the {@code Character} to be compared.
 
 * @return  the value {@code 0} if the argument {@code Character}
 *          is equal to this {@code Character}; a value less than
 *          {@code 0} if this {@code Character} is numerically less
 *          than the {@code Character} argument; and a value greater than
 *          {@code 0} if this {@code Character} is numerically greater
 *          than the {@code Character} argument (unsigned comparison).
 *          Note that this is strictly a numerical comparison; it is not
 *          locale-dependent.
 * @since   1.2
 * @apiSince 1
 */

public int compareTo(@androidx.annotation.NonNull java.lang.Character anotherCharacter) { throw new RuntimeException("Stub!"); }

/**
 * Compares two {@code char} values numerically.
 * The value returned is identical to what would be returned by:
 * <pre>
 *    Character.valueOf(x).compareTo(Character.valueOf(y))
 * </pre>
 *
 * @param  x the first {@code char} to compare
 * @param  y the second {@code char} to compare
 * @return the value {@code 0} if {@code x == y};
 *         a value less than {@code 0} if {@code x < y}; and
 *         a value greater than {@code 0} if {@code x > y}
 * @since 1.7
 * @apiSince 19
 */

public static int compare(char x, char y) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value obtained by reversing the order of the bytes in the
 * specified <tt>char</tt> value.
 *
 * @param ch The {@code char} of which to reverse the byte order.
 * @return the value obtained by reversing (or, equivalently, swapping)
 *     the bytes in the specified <tt>char</tt> value.
 * @since 1.5
 * @apiSince 1
 */

public static char reverseBytes(char ch) { throw new RuntimeException("Stub!"); }

/**
 * Returns the Unicode name of the specified character
 * {@code codePoint}, or null if the code point is
 * {@link #UNASSIGNED unassigned}.
 * <p>
 * Note: if the specified character is not assigned a name by
 * the <i>UnicodeData</i> file (part of the Unicode Character
 * Database maintained by the Unicode Consortium), the returned
 * name is the same as the result of expression.
 *
 * <blockquote>{@code
 *     Character.UnicodeBlock.of(codePoint).toString().replace('_', ' ')
 *     + " "
 *     + Integer.toHexString(codePoint).toUpperCase(Locale.ENGLISH);
 *
 * }</blockquote>
 *
 * @param  codePoint the character (Unicode code point)
 *
 * @return the Unicode name of the specified character, or null if
 *         the code point is unassigned.
 *
 * @exception java.lang.IllegalArgumentException if the specified
 *            {@code codePoint} is not a valid Unicode
 *            code point.
 *
 * @since 1.7
 * @apiSince 19
 */

@androidx.annotation.Nullable
public static java.lang.String getName(int codePoint) { throw new RuntimeException("Stub!"); }

/**
 * The number of bytes used to represent a {@code char} value in unsigned
 * binary form.
 *
 * @since 1.8
 * @apiSince 24
 */

public static final int BYTES = 2; // 0x2

/**
 * General category "Mc" in the Unicode specification.
 * @since   1.1
 * @apiSince 1
 */

public static final byte COMBINING_SPACING_MARK = 8; // 0x8

/**
 * General category "Pc" in the Unicode specification.
 * @since   1.1
 * @apiSince 1
 */

public static final byte CONNECTOR_PUNCTUATION = 23; // 0x17

/**
 * General category "Cc" in the Unicode specification.
 * @since   1.1
 * @apiSince 1
 */

public static final byte CONTROL = 15; // 0xf

/**
 * General category "Sc" in the Unicode specification.
 * @since   1.1
 * @apiSince 1
 */

public static final byte CURRENCY_SYMBOL = 26; // 0x1a

/**
 * General category "Pd" in the Unicode specification.
 * @since   1.1
 * @apiSince 1
 */

public static final byte DASH_PUNCTUATION = 20; // 0x14

/**
 * General category "Nd" in the Unicode specification.
 * @since   1.1
 * @apiSince 1
 */

public static final byte DECIMAL_DIGIT_NUMBER = 9; // 0x9

/**
 * Weak bidirectional character type "AN" in the Unicode specification.
 * @since 1.4
 * @apiSince 1
 */

public static final byte DIRECTIONALITY_ARABIC_NUMBER = 6; // 0x6

/**
 * Weak bidirectional character type "BN" in the Unicode specification.
 * @since 1.4
 * @apiSince 1
 */

public static final byte DIRECTIONALITY_BOUNDARY_NEUTRAL = 9; // 0x9

/**
 * Weak bidirectional character type "CS" in the Unicode specification.
 * @since 1.4
 * @apiSince 1
 */

public static final byte DIRECTIONALITY_COMMON_NUMBER_SEPARATOR = 7; // 0x7

/**
 * Weak bidirectional character type "EN" in the Unicode specification.
 * @since 1.4
 * @apiSince 1
 */

public static final byte DIRECTIONALITY_EUROPEAN_NUMBER = 3; // 0x3

/**
 * Weak bidirectional character type "ES" in the Unicode specification.
 * @since 1.4
 * @apiSince 1
 */

public static final byte DIRECTIONALITY_EUROPEAN_NUMBER_SEPARATOR = 4; // 0x4

/**
 * Weak bidirectional character type "ET" in the Unicode specification.
 * @since 1.4
 * @apiSince 1
 */

public static final byte DIRECTIONALITY_EUROPEAN_NUMBER_TERMINATOR = 5; // 0x5

/**
 * Strong bidirectional character type "L" in the Unicode specification.
 * @since 1.4
 * @apiSince 1
 */

public static final byte DIRECTIONALITY_LEFT_TO_RIGHT = 0; // 0x0

/**
 * Strong bidirectional character type "LRE" in the Unicode specification.
 * @since 1.4
 * @apiSince 1
 */

public static final byte DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING = 14; // 0xe

/**
 * Strong bidirectional character type "LRO" in the Unicode specification.
 * @since 1.4
 * @apiSince 1
 */

public static final byte DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE = 15; // 0xf

/**
 * Weak bidirectional character type "NSM" in the Unicode specification.
 * @since 1.4
 * @apiSince 1
 */

public static final byte DIRECTIONALITY_NONSPACING_MARK = 8; // 0x8

/**
 * Neutral bidirectional character type "ON" in the Unicode specification.
 * @since 1.4
 * @apiSince 1
 */

public static final byte DIRECTIONALITY_OTHER_NEUTRALS = 13; // 0xd

/**
 * Neutral bidirectional character type "B" in the Unicode specification.
 * @since 1.4
 * @apiSince 1
 */

public static final byte DIRECTIONALITY_PARAGRAPH_SEPARATOR = 10; // 0xa

/**
 * Weak bidirectional character type "PDF" in the Unicode specification.
 * @since 1.4
 * @apiSince 1
 */

public static final byte DIRECTIONALITY_POP_DIRECTIONAL_FORMAT = 18; // 0x12

/**
 * Strong bidirectional character type "R" in the Unicode specification.
 * @since 1.4
 * @apiSince 1
 */

public static final byte DIRECTIONALITY_RIGHT_TO_LEFT = 1; // 0x1

/**
 * Strong bidirectional character type "AL" in the Unicode specification.
 * @since 1.4
 * @apiSince 1
 */

public static final byte DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC = 2; // 0x2

/**
 * Strong bidirectional character type "RLE" in the Unicode specification.
 * @since 1.4
 * @apiSince 1
 */

public static final byte DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING = 16; // 0x10

/**
 * Strong bidirectional character type "RLO" in the Unicode specification.
 * @since 1.4
 * @apiSince 1
 */

public static final byte DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE = 17; // 0x11

/**
 * Neutral bidirectional character type "S" in the Unicode specification.
 * @since 1.4
 * @apiSince 1
 */

public static final byte DIRECTIONALITY_SEGMENT_SEPARATOR = 11; // 0xb

/**
 * Undefined bidirectional character type. Undefined {@code char}
 * values have undefined directionality in the Unicode specification.
 * @since 1.4
 * @apiSince 1
 */

public static final byte DIRECTIONALITY_UNDEFINED = -1; // 0xffffffff

/**
 * Neutral bidirectional character type "WS" in the Unicode specification.
 * @since 1.4
 * @apiSince 1
 */

public static final byte DIRECTIONALITY_WHITESPACE = 12; // 0xc

/**
 * General category "Me" in the Unicode specification.
 * @since   1.1
 * @apiSince 1
 */

public static final byte ENCLOSING_MARK = 7; // 0x7

/**
 * General category "Pe" in the Unicode specification.
 * @since   1.1
 * @apiSince 1
 */

public static final byte END_PUNCTUATION = 22; // 0x16

/**
 * General category "Pf" in the Unicode specification.
 * @since   1.4
 * @apiSince 1
 */

public static final byte FINAL_QUOTE_PUNCTUATION = 30; // 0x1e

/**
 * General category "Cf" in the Unicode specification.
 * @since   1.1
 * @apiSince 1
 */

public static final byte FORMAT = 16; // 0x10

/**
 * General category "Pi" in the Unicode specification.
 * @since   1.4
 * @apiSince 1
 */

public static final byte INITIAL_QUOTE_PUNCTUATION = 29; // 0x1d

/**
 * General category "Nl" in the Unicode specification.
 * @since   1.1
 * @apiSince 1
 */

public static final byte LETTER_NUMBER = 10; // 0xa

/**
 * General category "Zl" in the Unicode specification.
 * @since   1.1
 * @apiSince 1
 */

public static final byte LINE_SEPARATOR = 13; // 0xd

/**
 * General category "Ll" in the Unicode specification.
 * @since   1.1
 * @apiSince 1
 */

public static final byte LOWERCASE_LETTER = 2; // 0x2

/**
 * General category "Sm" in the Unicode specification.
 * @since   1.1
 * @apiSince 1
 */

public static final byte MATH_SYMBOL = 25; // 0x19

/**
 * The maximum value of a
 * <a href="http://www.unicode.org/glossary/#code_point">
 * Unicode code point</a>, constant {@code U+10FFFF}.
 *
 * @since 1.5
 * @apiSince 1
 */

public static final int MAX_CODE_POINT = 1114111; // 0x10ffff

/**
 * The maximum value of a
 * <a href="http://www.unicode.org/glossary/#high_surrogate_code_unit">
 * Unicode high-surrogate code unit</a>
 * in the UTF-16 encoding, constant {@code '\u005CuDBFF'}.
 * A high-surrogate is also known as a <i>leading-surrogate</i>.
 *
 * @since 1.5
 * @apiSince 1
 */

public static final char MAX_HIGH_SURROGATE = 56319; // 0xdbff '\udbff'

/**
 * The maximum value of a
 * <a href="http://www.unicode.org/glossary/#low_surrogate_code_unit">
 * Unicode low-surrogate code unit</a>
 * in the UTF-16 encoding, constant {@code '\u005CuDFFF'}.
 * A low-surrogate is also known as a <i>trailing-surrogate</i>.
 *
 * @since 1.5
 * @apiSince 1
 */

public static final char MAX_LOW_SURROGATE = 57343; // 0xdfff '\udfff'

/**
 * The maximum radix available for conversion to and from strings.
 * The constant value of this field is the largest value permitted
 * for the radix argument in radix-conversion methods such as the
 * {@code digit} method, the {@code forDigit} method, and the
 * {@code toString} method of class {@code Integer}.
 *
 * @see     java.lang.Character#digit(char, int)
 * @see     java.lang.Character#forDigit(int, int)
 * @see     java.lang.Integer#toString(int, int)
 * @see     java.lang.Integer#valueOf(String)
 * @apiSince 1
 */

public static final int MAX_RADIX = 36; // 0x24

/**
 * The maximum value of a Unicode surrogate code unit in the
 * UTF-16 encoding, constant {@code '\u005CuDFFF'}.
 *
 * @since 1.5
 * @apiSince 1
 */

public static final char MAX_SURROGATE = 57343; // 0xdfff '\udfff'

/**
 * The constant value of this field is the largest value of type
 * {@code char}, {@code '\u005CuFFFF'}.
 *
 * @since   1.0.2
 * @apiSince 1
 */

public static final char MAX_VALUE = 65535; // 0xffff '\uffff'

/**
 * The minimum value of a
 * <a href="http://www.unicode.org/glossary/#code_point">
 * Unicode code point</a>, constant {@code U+0000}.
 *
 * @since 1.5
 * @apiSince 1
 */

public static final int MIN_CODE_POINT = 0; // 0x0

/**
 * The minimum value of a
 * <a href="http://www.unicode.org/glossary/#high_surrogate_code_unit">
 * Unicode high-surrogate code unit</a>
 * in the UTF-16 encoding, constant {@code '\u005CuD800'}.
 * A high-surrogate is also known as a <i>leading-surrogate</i>.
 *
 * @since 1.5
 * @apiSince 1
 */

public static final char MIN_HIGH_SURROGATE = 55296; // 0xd800 '\ud800'

/**
 * The minimum value of a
 * <a href="http://www.unicode.org/glossary/#low_surrogate_code_unit">
 * Unicode low-surrogate code unit</a>
 * in the UTF-16 encoding, constant {@code '\u005CuDC00'}.
 * A low-surrogate is also known as a <i>trailing-surrogate</i>.
 *
 * @since 1.5
 * @apiSince 1
 */

public static final char MIN_LOW_SURROGATE = 56320; // 0xdc00 '\udc00'

/**
 * The minimum radix available for conversion to and from strings.
 * The constant value of this field is the smallest value permitted
 * for the radix argument in radix-conversion methods such as the
 * {@code digit} method, the {@code forDigit} method, and the
 * {@code toString} method of class {@code Integer}.
 *
 * @see     java.lang.Character#digit(char, int)
 * @see     java.lang.Character#forDigit(int, int)
 * @see     java.lang.Integer#toString(int, int)
 * @see     java.lang.Integer#valueOf(String)
 * @apiSince 1
 */

public static final int MIN_RADIX = 2; // 0x2

/**
 * The minimum value of a
 * <a href="http://www.unicode.org/glossary/#supplementary_code_point">
 * Unicode supplementary code point</a>, constant {@code U+10000}.
 *
 * @since 1.5
 * @apiSince 1
 */

public static final int MIN_SUPPLEMENTARY_CODE_POINT = 65536; // 0x10000

/**
 * The minimum value of a Unicode surrogate code unit in the
 * UTF-16 encoding, constant {@code '\u005CuD800'}.
 *
 * @since 1.5
 * @apiSince 1
 */

public static final char MIN_SURROGATE = 55296; // 0xd800 '\ud800'

/**
 * The constant value of this field is the smallest value of type
 * {@code char}, {@code '\u005Cu0000'}.
 *
 * @since   1.0.2
 * @apiSince 1
 */

public static final char MIN_VALUE = 0; // 0x0000 '\u0000'

/**
 * General category "Lm" in the Unicode specification.
 * @since   1.1
 * @apiSince 1
 */

public static final byte MODIFIER_LETTER = 4; // 0x4

/**
 * General category "Sk" in the Unicode specification.
 * @since   1.1
 * @apiSince 1
 */

public static final byte MODIFIER_SYMBOL = 27; // 0x1b

/**
 * General category "Mn" in the Unicode specification.
 * @since   1.1
 * @apiSince 1
 */

public static final byte NON_SPACING_MARK = 6; // 0x6

/**
 * General category "Lo" in the Unicode specification.
 * @since   1.1
 * @apiSince 1
 */

public static final byte OTHER_LETTER = 5; // 0x5

/**
 * General category "No" in the Unicode specification.
 * @since   1.1
 * @apiSince 1
 */

public static final byte OTHER_NUMBER = 11; // 0xb

/**
 * General category "Po" in the Unicode specification.
 * @since   1.1
 * @apiSince 1
 */

public static final byte OTHER_PUNCTUATION = 24; // 0x18

/**
 * General category "So" in the Unicode specification.
 * @since   1.1
 * @apiSince 1
 */

public static final byte OTHER_SYMBOL = 28; // 0x1c

/**
 * General category "Zp" in the Unicode specification.
 * @since   1.1
 * @apiSince 1
 */

public static final byte PARAGRAPH_SEPARATOR = 14; // 0xe

/**
 * General category "Co" in the Unicode specification.
 * @since   1.1
 * @apiSince 1
 */

public static final byte PRIVATE_USE = 18; // 0x12

/**
 * The number of bits used to represent a <tt>char</tt> value in unsigned
 * binary form, constant {@code 16}.
 *
 * @since 1.5
 * @apiSince 1
 */

public static final int SIZE = 16; // 0x10

/**
 * General category "Zs" in the Unicode specification.
 * @since   1.1
 * @apiSince 1
 */

public static final byte SPACE_SEPARATOR = 12; // 0xc

/**
 * General category "Ps" in the Unicode specification.
 * @since   1.1
 * @apiSince 1
 */

public static final byte START_PUNCTUATION = 21; // 0x15

/**
 * General category "Cs" in the Unicode specification.
 * @since   1.1
 * @apiSince 1
 */

public static final byte SURROGATE = 19; // 0x13

/**
 * General category "Lt" in the Unicode specification.
 * @since   1.1
 * @apiSince 1
 */

public static final byte TITLECASE_LETTER = 3; // 0x3

/**
 * The {@code Class} instance representing the primitive type
 * {@code char}.
 *
 * @since   1.1
 * @apiSince 1
 */

public static final java.lang.Class<java.lang.Character> TYPE;
static { TYPE = null; }

/**
 * General category "Cn" in the Unicode specification.
 * @since   1.1
 * @apiSince 1
 */

public static final byte UNASSIGNED = 0; // 0x0

/**
 * General category "Lu" in the Unicode specification.
 * @since   1.1
 * @apiSince 1
 */

public static final byte UPPERCASE_LETTER = 1; // 0x1
/**
 * Instances of this class represent particular subsets of the Unicode
 * character set.  The only family of subsets defined in the
 * {@code Character} class is {@link java.lang.Character.UnicodeBlock Character.UnicodeBlock}.
 * Other portions of the Java API may define other subsets for their
 * own purposes.
 *
 * @since 1.2
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Subset {

/**
 * Constructs a new {@code Subset} instance.
 *
 * @param  name  The name of this subset
 * @exception java.lang.NullPointerException if name is {@code null}
 * @apiSince 1
 */

protected Subset(@androidx.annotation.NonNull java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Compares two {@code Subset} objects for equality.
 * This method returns {@code true} if and only if
 * {@code this} and the argument refer to the same
 * object; since this method is {@code final}, this
 * guarantee holds for all subclasses.
 * @apiSince 1
 */

public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Returns the standard hash code as defined by the
 * {@link java.lang.Object#hashCode Object#hashCode} method.  This method
 * is {@code final} in order to ensure that the
 * {@code equals} and {@code hashCode} methods will
 * be consistent in all subclasses.
 * @apiSince 1
 */

public final int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns the name of this subset.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public final java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

/**
 * A family of character subsets representing the character blocks in the
 * Unicode specification. Character blocks generally define characters
 * used for a specific script or purpose. A character is contained by
 * at most one Unicode block.
 *
 * @since 1.2
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class UnicodeBlock extends java.lang.Character.Subset {

private UnicodeBlock() { super(null); throw new RuntimeException("Stub!"); }

/**
 * Returns the object representing the Unicode block containing the
 * given character, or {@code null} if the character is not a
 * member of a defined block.
 *
 * <p><b>Note:</b> This method cannot handle
 * <a href="Character.html#supplementary"> supplementary
 * characters</a>.  To support all Unicode characters, including
 * supplementary characters, use the {@link #of(int)} method.
 *
 * @param   c  The character in question
 * @return  The {@code UnicodeBlock} instance representing the
 *          Unicode block of which this character is a member, or
 *          {@code null} if the character is not a member of any
 *          Unicode block
 * @apiSince 1
 */

@androidx.annotation.Nullable
public static java.lang.Character.UnicodeBlock of(char c) { throw new RuntimeException("Stub!"); }

/**
 * Returns the object representing the Unicode block
 * containing the given character (Unicode code point), or
 * {@code null} if the character is not a member of a
 * defined block.
 *
 * @param   codePoint the character (Unicode code point) in question.
 * @return  The {@code UnicodeBlock} instance representing the
 *          Unicode block of which this character is a member, or
 *          {@code null} if the character is not a member of any
 *          Unicode block
 * @exception java.lang.IllegalArgumentException if the specified
 * {@code codePoint} is an invalid Unicode code point.
 * @see java.lang.Character#isValidCodePoint(int)
 * @since   1.5
 * @apiSince 1
 */

@androidx.annotation.Nullable
public static java.lang.Character.UnicodeBlock of(int codePoint) { throw new RuntimeException("Stub!"); }

/**
 * Returns the UnicodeBlock with the given name. Block
 * names are determined by The Unicode Standard. The file
 * Blocks-&lt;version&gt;.txt defines blocks for a particular
 * version of the standard. The {@link java.lang.Character Character} class specifies
 * the version of the standard that it supports.
 * <p>
 * This method accepts block names in the following forms:
 * <ol>
 * <li> Canonical block names as defined by the Unicode Standard.
 * For example, the standard defines a "Basic Latin" block. Therefore, this
 * method accepts "Basic Latin" as a valid block name. The documentation of
 * each UnicodeBlock provides the canonical name.
 * <li>Canonical block names with all spaces removed. For example, "BasicLatin"
 * is a valid block name for the "Basic Latin" block.
 * <li>The text representation of each constant UnicodeBlock identifier.
 * For example, this method will return the {@link #BASIC_LATIN} block if
 * provided with the "BASIC_LATIN" name. This form replaces all spaces and
 * hyphens in the canonical name with underscores.
 * </ol>
 * Finally, character case is ignored for all of the valid block name forms.
 * For example, "BASIC_LATIN" and "basic_latin" are both valid block names.
 * The en_US locale's case mapping rules are used to provide case-insensitive
 * string comparisons for block name validation.
 * <p>
 * If the Unicode Standard changes block names, both the previous and
 * current names will be accepted.
 *
 * @param blockName A {@code UnicodeBlock} name.
 * @return The {@code UnicodeBlock} instance identified
 *         by {@code blockName}
 * @throws java.lang.IllegalArgumentException if {@code blockName} is an
 *         invalid name
 * @throws java.lang.NullPointerException if {@code blockName} is null
 * @since 1.5
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.Character.UnicodeBlock forName(@androidx.annotation.NonNull java.lang.String blockName) { throw new RuntimeException("Stub!"); }

/**
 * Constant for the "Aegean Numbers" Unicode character block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock AEGEAN_NUMBERS;
static { AEGEAN_NUMBERS = null; }

/**
 * Constant for the "Alchemical Symbols" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock ALCHEMICAL_SYMBOLS;
static { ALCHEMICAL_SYMBOLS = null; }

/**
 * Constant for the "Alphabetic Presentation Forms" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock ALPHABETIC_PRESENTATION_FORMS;
static { ALPHABETIC_PRESENTATION_FORMS = null; }

/**
 * Constant for the "Ancient Greek Musical Notation" Unicode character
 * block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock ANCIENT_GREEK_MUSICAL_NOTATION;
static { ANCIENT_GREEK_MUSICAL_NOTATION = null; }

/**
 * Constant for the "Ancient Greek Numbers" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock ANCIENT_GREEK_NUMBERS;
static { ANCIENT_GREEK_NUMBERS = null; }

/**
 * Constant for the "Ancient Symbols" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock ANCIENT_SYMBOLS;
static { ANCIENT_SYMBOLS = null; }

/**
 * Constant for the "Arabic" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock ARABIC;
static { ARABIC = null; }

/**
 * Constant for the "Arabic Extended-A" Unicode character block.
 * @since 1.8
 * @apiSince 26
 */

public static final java.lang.Character.UnicodeBlock ARABIC_EXTENDED_A;
static { ARABIC_EXTENDED_A = null; }

/**
 * Constant for the "Arabic Mathematical Alphabetic Symbols" Unicode
 * character block.
 * @since 1.8
 * @apiSince 26
 */

public static final java.lang.Character.UnicodeBlock ARABIC_MATHEMATICAL_ALPHABETIC_SYMBOLS;
static { ARABIC_MATHEMATICAL_ALPHABETIC_SYMBOLS = null; }

/**
 * Constant for the "Arabic Presentation Forms-A" Unicode character
 * block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock ARABIC_PRESENTATION_FORMS_A;
static { ARABIC_PRESENTATION_FORMS_A = null; }

/**
 * Constant for the "Arabic Presentation Forms-B" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock ARABIC_PRESENTATION_FORMS_B;
static { ARABIC_PRESENTATION_FORMS_B = null; }

/**
 * Constant for the "Arabic Supplement" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock ARABIC_SUPPLEMENT;
static { ARABIC_SUPPLEMENT = null; }

/**
 * Constant for the "Armenian" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock ARMENIAN;
static { ARMENIAN = null; }

/**
 * Constant for the "Arrows" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock ARROWS;
static { ARROWS = null; }

/**
 * Constant for the "Avestan" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock AVESTAN;
static { AVESTAN = null; }

/**
 * Constant for the "Balinese" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock BALINESE;
static { BALINESE = null; }

/**
 * Constant for the "Bamum" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock BAMUM;
static { BAMUM = null; }

/**
 * Constant for the "Bamum Supplement" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock BAMUM_SUPPLEMENT;
static { BAMUM_SUPPLEMENT = null; }

/**
 * Constant for the "Basic Latin" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock BASIC_LATIN;
static { BASIC_LATIN = null; }

/**
 * Constant for the "Batak" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock BATAK;
static { BATAK = null; }

/**
 * Constant for the "Bengali" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock BENGALI;
static { BENGALI = null; }

/**
 * Constant for the "Block Elements" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock BLOCK_ELEMENTS;
static { BLOCK_ELEMENTS = null; }

/**
 * Constant for the "Bopomofo" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock BOPOMOFO;
static { BOPOMOFO = null; }

/**
 * Constant for the "Bopomofo Extended" Unicode character block.
 * @since 1.4
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock BOPOMOFO_EXTENDED;
static { BOPOMOFO_EXTENDED = null; }

/**
 * Constant for the "Box Drawing" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock BOX_DRAWING;
static { BOX_DRAWING = null; }

/**
 * Constant for the "Brahmi" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock BRAHMI;
static { BRAHMI = null; }

/**
 * Constant for the "Braille Patterns" Unicode character block.
 * @since 1.4
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock BRAILLE_PATTERNS;
static { BRAILLE_PATTERNS = null; }

/**
 * Constant for the "Buginese" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock BUGINESE;
static { BUGINESE = null; }

/**
 * Constant for the "Buhid" Unicode character block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock BUHID;
static { BUHID = null; }

/**
 * Constant for the "Byzantine Musical Symbols" Unicode character block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock BYZANTINE_MUSICAL_SYMBOLS;
static { BYZANTINE_MUSICAL_SYMBOLS = null; }

/**
 * Constant for the "Carian" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock CARIAN;
static { CARIAN = null; }

/**
 * Constant for the "Chakma" Unicode character block.
 * @since 1.8
 * @apiSince 26
 */

public static final java.lang.Character.UnicodeBlock CHAKMA;
static { CHAKMA = null; }

/**
 * Constant for the "Cham" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock CHAM;
static { CHAM = null; }

/**
 * Constant for the "Cherokee" Unicode character block.
 * @since 1.4
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock CHEROKEE;
static { CHEROKEE = null; }

/**
 * Constant for the "CJK Compatibility" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock CJK_COMPATIBILITY;
static { CJK_COMPATIBILITY = null; }

/**
 * Constant for the "CJK Compatibility Forms" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock CJK_COMPATIBILITY_FORMS;
static { CJK_COMPATIBILITY_FORMS = null; }

/**
 * Constant for the "CJK Compatibility Ideographs" Unicode character
 * block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock CJK_COMPATIBILITY_IDEOGRAPHS;
static { CJK_COMPATIBILITY_IDEOGRAPHS = null; }

/**
 * Constant for the "CJK Compatibility Ideographs Supplement" Unicode character block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT;
static { CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT = null; }

/**
 * Constant for the "CJK Radicals Supplement" Unicode character block.
 * @since 1.4
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock CJK_RADICALS_SUPPLEMENT;
static { CJK_RADICALS_SUPPLEMENT = null; }

/**
 * Constant for the "CJK Strokes" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock CJK_STROKES;
static { CJK_STROKES = null; }

/**
 * Constant for the "CJK Symbols and Punctuation" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock CJK_SYMBOLS_AND_PUNCTUATION;
static { CJK_SYMBOLS_AND_PUNCTUATION = null; }

/**
 * Constant for the "CJK Unified Ideographs" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock CJK_UNIFIED_IDEOGRAPHS;
static { CJK_UNIFIED_IDEOGRAPHS = null; }

/**
 * Constant for the "CJK Unified Ideographs Extension A" Unicode character block.
 * @since 1.4
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A;
static { CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A = null; }

/**
 * Constant for the "CJK Unified Ideographs Extension B" Unicode
 * character block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B;
static { CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B = null; }

/**
 * Constant for the "CJK Unified Ideographs Extension C" Unicode
 * character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock CJK_UNIFIED_IDEOGRAPHS_EXTENSION_C;
static { CJK_UNIFIED_IDEOGRAPHS_EXTENSION_C = null; }

/**
 * Constant for the "CJK Unified Ideographs Extension D" Unicode
 * character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock CJK_UNIFIED_IDEOGRAPHS_EXTENSION_D;
static { CJK_UNIFIED_IDEOGRAPHS_EXTENSION_D = null; }

/**
 * Constant for the "Combining Diacritical Marks" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock COMBINING_DIACRITICAL_MARKS;
static { COMBINING_DIACRITICAL_MARKS = null; }

/**
 * Constant for the "Combining Diacritical Marks Supplement" Unicode
 * character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock COMBINING_DIACRITICAL_MARKS_SUPPLEMENT;
static { COMBINING_DIACRITICAL_MARKS_SUPPLEMENT = null; }

/**
 * Constant for the "Combining Half Marks" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock COMBINING_HALF_MARKS;
static { COMBINING_HALF_MARKS = null; }

/**
 * Constant for the "Combining Diacritical Marks for Symbols" Unicode
 * character block.
 * <p>
 * This block was previously known as "Combining Marks for Symbols".
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock COMBINING_MARKS_FOR_SYMBOLS;
static { COMBINING_MARKS_FOR_SYMBOLS = null; }

/**
 * Constant for the "Common Indic Number Forms" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock COMMON_INDIC_NUMBER_FORMS;
static { COMMON_INDIC_NUMBER_FORMS = null; }

/**
 * Constant for the "Control Pictures" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock CONTROL_PICTURES;
static { CONTROL_PICTURES = null; }

/**
 * Constant for the "Coptic" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock COPTIC;
static { COPTIC = null; }

/**
 * Constant for the "Counting Rod Numerals" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock COUNTING_ROD_NUMERALS;
static { COUNTING_ROD_NUMERALS = null; }

/**
 * Constant for the "Cuneiform" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock CUNEIFORM;
static { CUNEIFORM = null; }

/**
 * Constant for the "Cuneiform Numbers and Punctuation" Unicode
 * character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock CUNEIFORM_NUMBERS_AND_PUNCTUATION;
static { CUNEIFORM_NUMBERS_AND_PUNCTUATION = null; }

/**
 * Constant for the "Currency Symbols" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock CURRENCY_SYMBOLS;
static { CURRENCY_SYMBOLS = null; }

/**
 * Constant for the "Cypriot Syllabary" Unicode character block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock CYPRIOT_SYLLABARY;
static { CYPRIOT_SYLLABARY = null; }

/**
 * Constant for the "Cyrillic" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock CYRILLIC;
static { CYRILLIC = null; }

/**
 * Constant for the "Cyrillic Extended-A" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock CYRILLIC_EXTENDED_A;
static { CYRILLIC_EXTENDED_A = null; }

/**
 * Constant for the "Cyrillic Extended-B" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock CYRILLIC_EXTENDED_B;
static { CYRILLIC_EXTENDED_B = null; }

/**
 * Constant for the "Cyrillic Supplementary" Unicode character block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock CYRILLIC_SUPPLEMENTARY;
static { CYRILLIC_SUPPLEMENTARY = null; }

/**
 * Constant for the "Deseret" Unicode character block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock DESERET;
static { DESERET = null; }

/**
 * Constant for the "Devanagari" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock DEVANAGARI;
static { DEVANAGARI = null; }

/**
 * Constant for the "Devanagari Extended" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock DEVANAGARI_EXTENDED;
static { DEVANAGARI_EXTENDED = null; }

/**
 * Constant for the "Dingbats" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock DINGBATS;
static { DINGBATS = null; }

/**
 * Constant for the "Domino Tiles" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock DOMINO_TILES;
static { DOMINO_TILES = null; }

/**
 * Constant for the "Egyptian Hieroglyphs" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock EGYPTIAN_HIEROGLYPHS;
static { EGYPTIAN_HIEROGLYPHS = null; }

/**
 * Constant for the "Emoticons" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock EMOTICONS;
static { EMOTICONS = null; }

/**
 * Constant for the "Enclosed Alphanumerics" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock ENCLOSED_ALPHANUMERICS;
static { ENCLOSED_ALPHANUMERICS = null; }

/**
 * Constant for the "Enclosed Alphanumeric Supplement" Unicode character
 * block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock ENCLOSED_ALPHANUMERIC_SUPPLEMENT;
static { ENCLOSED_ALPHANUMERIC_SUPPLEMENT = null; }

/**
 * Constant for the "Enclosed CJK Letters and Months" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock ENCLOSED_CJK_LETTERS_AND_MONTHS;
static { ENCLOSED_CJK_LETTERS_AND_MONTHS = null; }

/**
 * Constant for the "Enclosed Ideographic Supplement" Unicode character
 * block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock ENCLOSED_IDEOGRAPHIC_SUPPLEMENT;
static { ENCLOSED_IDEOGRAPHIC_SUPPLEMENT = null; }

/**
 * Constant for the "Ethiopic" Unicode character block.
 * @since 1.4
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock ETHIOPIC;
static { ETHIOPIC = null; }

/**
 * Constant for the "Ethiopic Extended" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock ETHIOPIC_EXTENDED;
static { ETHIOPIC_EXTENDED = null; }

/**
 * Constant for the "Ethiopic Extended-A" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock ETHIOPIC_EXTENDED_A;
static { ETHIOPIC_EXTENDED_A = null; }

/**
 * Constant for the "Ethiopic Supplement" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock ETHIOPIC_SUPPLEMENT;
static { ETHIOPIC_SUPPLEMENT = null; }

/**
 * Constant for the "General Punctuation" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock GENERAL_PUNCTUATION;
static { GENERAL_PUNCTUATION = null; }

/**
 * Constant for the "Geometric Shapes" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock GEOMETRIC_SHAPES;
static { GEOMETRIC_SHAPES = null; }

/**
 * Constant for the "Georgian" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock GEORGIAN;
static { GEORGIAN = null; }

/**
 * Constant for the "Georgian Supplement" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock GEORGIAN_SUPPLEMENT;
static { GEORGIAN_SUPPLEMENT = null; }

/**
 * Constant for the "Glagolitic" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock GLAGOLITIC;
static { GLAGOLITIC = null; }

/**
 * Constant for the "Gothic" Unicode character block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock GOTHIC;
static { GOTHIC = null; }

/**
 * Constant for the "Greek and Coptic" Unicode character block.
 * <p>
 * This block was previously known as the "Greek" block.
 *
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock GREEK;
static { GREEK = null; }

/**
 * Constant for the "Greek Extended" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock GREEK_EXTENDED;
static { GREEK_EXTENDED = null; }

/**
 * Constant for the "Gujarati" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock GUJARATI;
static { GUJARATI = null; }

/**
 * Constant for the "Gurmukhi" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock GURMUKHI;
static { GURMUKHI = null; }

/**
 * Constant for the "Halfwidth and Fullwidth Forms" Unicode character
 * block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock HALFWIDTH_AND_FULLWIDTH_FORMS;
static { HALFWIDTH_AND_FULLWIDTH_FORMS = null; }

/**
 * Constant for the "Hangul Compatibility Jamo" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock HANGUL_COMPATIBILITY_JAMO;
static { HANGUL_COMPATIBILITY_JAMO = null; }

/**
 * Constant for the "Hangul Jamo" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock HANGUL_JAMO;
static { HANGUL_JAMO = null; }

/**
 * Constant for the "Hangul Jamo Extended-A" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock HANGUL_JAMO_EXTENDED_A;
static { HANGUL_JAMO_EXTENDED_A = null; }

/**
 * Constant for the "Hangul Jamo Extended-B" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock HANGUL_JAMO_EXTENDED_B;
static { HANGUL_JAMO_EXTENDED_B = null; }

/**
 * Constant for the "Hangul Syllables" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock HANGUL_SYLLABLES;
static { HANGUL_SYLLABLES = null; }

/**
 * Constant for the "Hanunoo" Unicode character block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock HANUNOO;
static { HANUNOO = null; }

/**
 * Constant for the "Hebrew" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock HEBREW;
static { HEBREW = null; }

/**
 * Constant for the "High Private Use Surrogates" Unicode character
 * block.
 * This block represents codepoint values in the private use high
 * surrogate range: U+DB80 through U+DBFF
 *
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock HIGH_PRIVATE_USE_SURROGATES;
static { HIGH_PRIVATE_USE_SURROGATES = null; }

/**
 * Constant for the "High Surrogates" Unicode character block.
 * This block represents codepoint values in the high surrogate
 * range: U+D800 through U+DB7F
 *
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock HIGH_SURROGATES;
static { HIGH_SURROGATES = null; }

/**
 * Constant for the "Hiragana" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock HIRAGANA;
static { HIRAGANA = null; }

/**
 * Constant for the "Ideographic Description Characters" Unicode character block.
 * @since 1.4
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock IDEOGRAPHIC_DESCRIPTION_CHARACTERS;
static { IDEOGRAPHIC_DESCRIPTION_CHARACTERS = null; }

/**
 * Constant for the "Imperial Aramaic" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock IMPERIAL_ARAMAIC;
static { IMPERIAL_ARAMAIC = null; }

/**
 * Constant for the "Inscriptional Pahlavi" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock INSCRIPTIONAL_PAHLAVI;
static { INSCRIPTIONAL_PAHLAVI = null; }

/**
 * Constant for the "Inscriptional Parthian" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock INSCRIPTIONAL_PARTHIAN;
static { INSCRIPTIONAL_PARTHIAN = null; }

/**
 * Constant for the "IPA Extensions" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock IPA_EXTENSIONS;
static { IPA_EXTENSIONS = null; }

/**
 * Constant for the "Javanese" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock JAVANESE;
static { JAVANESE = null; }

/**
 * Constant for the "Kaithi" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock KAITHI;
static { KAITHI = null; }

/**
 * Constant for the "Kana Supplement" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock KANA_SUPPLEMENT;
static { KANA_SUPPLEMENT = null; }

/**
 * Constant for the "Kanbun" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock KANBUN;
static { KANBUN = null; }

/**
 * Constant for the "Kangxi Radicals" Unicode character block.
 * @since 1.4
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock KANGXI_RADICALS;
static { KANGXI_RADICALS = null; }

/**
 * Constant for the "Kannada" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock KANNADA;
static { KANNADA = null; }

/**
 * Constant for the "Katakana" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock KATAKANA;
static { KATAKANA = null; }

/**
 * Constant for the "Katakana Phonetic Extensions" Unicode character
 * block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock KATAKANA_PHONETIC_EXTENSIONS;
static { KATAKANA_PHONETIC_EXTENSIONS = null; }

/**
 * Constant for the "Kayah Li" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock KAYAH_LI;
static { KAYAH_LI = null; }

/**
 * Constant for the "Kharoshthi" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock KHAROSHTHI;
static { KHAROSHTHI = null; }

/**
 * Constant for the "Khmer" Unicode character block.
 * @since 1.4
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock KHMER;
static { KHMER = null; }

/**
 * Constant for the "Khmer Symbols" Unicode character block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock KHMER_SYMBOLS;
static { KHMER_SYMBOLS = null; }

/**
 * Constant for the "Lao" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock LAO;
static { LAO = null; }

/**
 * Constant for the "Latin-1 Supplement" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock LATIN_1_SUPPLEMENT;
static { LATIN_1_SUPPLEMENT = null; }

/**
 * Constant for the "Latin Extended-A" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock LATIN_EXTENDED_A;
static { LATIN_EXTENDED_A = null; }

/**
 * Constant for the "Latin Extended Additional" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock LATIN_EXTENDED_ADDITIONAL;
static { LATIN_EXTENDED_ADDITIONAL = null; }

/**
 * Constant for the "Latin Extended-B" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock LATIN_EXTENDED_B;
static { LATIN_EXTENDED_B = null; }

/**
 * Constant for the "Latin Extended-C" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock LATIN_EXTENDED_C;
static { LATIN_EXTENDED_C = null; }

/**
 * Constant for the "Latin Extended-D" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock LATIN_EXTENDED_D;
static { LATIN_EXTENDED_D = null; }

/**
 * Constant for the "Lepcha" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock LEPCHA;
static { LEPCHA = null; }

/**
 * Constant for the "Letterlike Symbols" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock LETTERLIKE_SYMBOLS;
static { LETTERLIKE_SYMBOLS = null; }

/**
 * Constant for the "Limbu" Unicode character block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock LIMBU;
static { LIMBU = null; }

/**
 * Constant for the "Linear B Ideograms" Unicode character block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock LINEAR_B_IDEOGRAMS;
static { LINEAR_B_IDEOGRAMS = null; }

/**
 * Constant for the "Linear B Syllabary" Unicode character block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock LINEAR_B_SYLLABARY;
static { LINEAR_B_SYLLABARY = null; }

/**
 * Constant for the "Lisu" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock LISU;
static { LISU = null; }

/**
 * Constant for the "Low Surrogates" Unicode character block.
 * This block represents codepoint values in the low surrogate
 * range: U+DC00 through U+DFFF
 *
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock LOW_SURROGATES;
static { LOW_SURROGATES = null; }

/**
 * Constant for the "Lycian" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock LYCIAN;
static { LYCIAN = null; }

/**
 * Constant for the "Lydian" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock LYDIAN;
static { LYDIAN = null; }

/**
 * Constant for the "Mahjong Tiles" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock MAHJONG_TILES;
static { MAHJONG_TILES = null; }

/**
 * Constant for the "Malayalam" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock MALAYALAM;
static { MALAYALAM = null; }

/**
 * Constant for the "Mandaic" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock MANDAIC;
static { MANDAIC = null; }

/**
 * Constant for the "Mathematical Alphanumeric Symbols" Unicode
 * character block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock MATHEMATICAL_ALPHANUMERIC_SYMBOLS;
static { MATHEMATICAL_ALPHANUMERIC_SYMBOLS = null; }

/**
 * Constant for the "Mathematical Operators" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock MATHEMATICAL_OPERATORS;
static { MATHEMATICAL_OPERATORS = null; }

/**
 * Constant for the "Meetei Mayek" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock MEETEI_MAYEK;
static { MEETEI_MAYEK = null; }

/**
 * Constant for the "Meetei Mayek Extensions" Unicode character block.
 * @since 1.8
 * @apiSince 26
 */

public static final java.lang.Character.UnicodeBlock MEETEI_MAYEK_EXTENSIONS;
static { MEETEI_MAYEK_EXTENSIONS = null; }

/**
 * Constant for the "Meroitic Cursive" Unicode character block.
 * @since 1.8
 * @apiSince 26
 */

public static final java.lang.Character.UnicodeBlock MEROITIC_CURSIVE;
static { MEROITIC_CURSIVE = null; }

/**
 * Constant for the "Meroitic Hieroglyphs" Unicode character block.
 * @since 1.8
 * @apiSince 26
 */

public static final java.lang.Character.UnicodeBlock MEROITIC_HIEROGLYPHS;
static { MEROITIC_HIEROGLYPHS = null; }

/**
 * Constant for the "Miao" Unicode character block.
 * @since 1.8
 * @apiSince 26
 */

public static final java.lang.Character.UnicodeBlock MIAO;
static { MIAO = null; }

/**
 * Constant for the "Miscellaneous Mathematical Symbols-A" Unicode character block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock MISCELLANEOUS_MATHEMATICAL_SYMBOLS_A;
static { MISCELLANEOUS_MATHEMATICAL_SYMBOLS_A = null; }

/**
 * Constant for the "Miscellaneous Mathematical Symbols-B" Unicode
 * character block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock MISCELLANEOUS_MATHEMATICAL_SYMBOLS_B;
static { MISCELLANEOUS_MATHEMATICAL_SYMBOLS_B = null; }

/**
 * Constant for the "Miscellaneous Symbols" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock MISCELLANEOUS_SYMBOLS;
static { MISCELLANEOUS_SYMBOLS = null; }

/**
 * Constant for the "Miscellaneous Symbols and Arrows" Unicode character
 * block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock MISCELLANEOUS_SYMBOLS_AND_ARROWS;
static { MISCELLANEOUS_SYMBOLS_AND_ARROWS = null; }

/**
 * Constant for the "Miscellaneous Symbols And Pictographs" Unicode
 * character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock MISCELLANEOUS_SYMBOLS_AND_PICTOGRAPHS;
static { MISCELLANEOUS_SYMBOLS_AND_PICTOGRAPHS = null; }

/**
 * Constant for the "Miscellaneous Technical" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock MISCELLANEOUS_TECHNICAL;
static { MISCELLANEOUS_TECHNICAL = null; }

/**
 * Constant for the "Modifier Tone Letters" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock MODIFIER_TONE_LETTERS;
static { MODIFIER_TONE_LETTERS = null; }

/**
 * Constant for the "Mongolian" Unicode character block.
 * @since 1.4
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock MONGOLIAN;
static { MONGOLIAN = null; }

/**
 * Constant for the "Musical Symbols" Unicode character block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock MUSICAL_SYMBOLS;
static { MUSICAL_SYMBOLS = null; }

/**
 * Constant for the "Myanmar" Unicode character block.
 * @since 1.4
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock MYANMAR;
static { MYANMAR = null; }

/**
 * Constant for the "Myanmar Extended-A" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock MYANMAR_EXTENDED_A;
static { MYANMAR_EXTENDED_A = null; }

/**
 * Constant for the "New Tai Lue" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock NEW_TAI_LUE;
static { NEW_TAI_LUE = null; }

/**
 * Constant for the "NKo" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock NKO;
static { NKO = null; }

/**
 * Constant for the "Number Forms" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock NUMBER_FORMS;
static { NUMBER_FORMS = null; }

/**
 * Constant for the "Ogham" Unicode character block.
 * @since 1.4
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock OGHAM;
static { OGHAM = null; }

/**
 * Constant for the "Old Italic" Unicode character block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock OLD_ITALIC;
static { OLD_ITALIC = null; }

/**
 * Constant for the "Old Persian" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock OLD_PERSIAN;
static { OLD_PERSIAN = null; }

/**
 * Constant for the "Old South Arabian" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock OLD_SOUTH_ARABIAN;
static { OLD_SOUTH_ARABIAN = null; }

/**
 * Constant for the "Old Turkic" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock OLD_TURKIC;
static { OLD_TURKIC = null; }

/**
 * Constant for the "Ol Chiki" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock OL_CHIKI;
static { OL_CHIKI = null; }

/**
 * Constant for the "Optical Character Recognition" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock OPTICAL_CHARACTER_RECOGNITION;
static { OPTICAL_CHARACTER_RECOGNITION = null; }

/**
 * Constant for the "Oriya" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock ORIYA;
static { ORIYA = null; }

/**
 * Constant for the "Osmanya" Unicode character block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock OSMANYA;
static { OSMANYA = null; }

/**
 * Constant for the "Phags-pa" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock PHAGS_PA;
static { PHAGS_PA = null; }

/**
 * Constant for the "Phaistos Disc" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock PHAISTOS_DISC;
static { PHAISTOS_DISC = null; }

/**
 * Constant for the "Phoenician" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock PHOENICIAN;
static { PHOENICIAN = null; }

/**
 * Constant for the "Phonetic Extensions" Unicode character block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock PHONETIC_EXTENSIONS;
static { PHONETIC_EXTENSIONS = null; }

/**
 * Constant for the "Phonetic Extensions Supplement" Unicode character
 * block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock PHONETIC_EXTENSIONS_SUPPLEMENT;
static { PHONETIC_EXTENSIONS_SUPPLEMENT = null; }

/**
 * Constant for the "Playing Cards" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock PLAYING_CARDS;
static { PLAYING_CARDS = null; }

/**
 * Constant for the "Private Use Area" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock PRIVATE_USE_AREA;
static { PRIVATE_USE_AREA = null; }

/**
 * Constant for the "Rejang" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock REJANG;
static { REJANG = null; }

/**
 * Constant for the "Rumi Numeral Symbols" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock RUMI_NUMERAL_SYMBOLS;
static { RUMI_NUMERAL_SYMBOLS = null; }

/**
 * Constant for the "Runic" Unicode character block.
 * @since 1.4
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock RUNIC;
static { RUNIC = null; }

/**
 * Constant for the "Samaritan" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock SAMARITAN;
static { SAMARITAN = null; }

/**
 * Constant for the "Saurashtra" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock SAURASHTRA;
static { SAURASHTRA = null; }

/**
 * Constant for the "Sharada" Unicode character block.
 * @since 1.8
 * @apiSince 26
 */

public static final java.lang.Character.UnicodeBlock SHARADA;
static { SHARADA = null; }

/**
 * Constant for the "Shavian" Unicode character block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock SHAVIAN;
static { SHAVIAN = null; }

/**
 * Constant for the "Sinhala" Unicode character block.
 * @since 1.4
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock SINHALA;
static { SINHALA = null; }

/**
 * Constant for the "Small Form Variants" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock SMALL_FORM_VARIANTS;
static { SMALL_FORM_VARIANTS = null; }

/**
 * Constant for the "Sora Sompeng" Unicode character block.
 * @since 1.8
 * @apiSince 26
 */

public static final java.lang.Character.UnicodeBlock SORA_SOMPENG;
static { SORA_SOMPENG = null; }

/**
 * Constant for the "Spacing Modifier Letters" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock SPACING_MODIFIER_LETTERS;
static { SPACING_MODIFIER_LETTERS = null; }

/**
 * Constant for the "Specials" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock SPECIALS;
static { SPECIALS = null; }

/**
 * Constant for the "Sundanese" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock SUNDANESE;
static { SUNDANESE = null; }

/**
 * Constant for the "Sundanese Supplement" Unicode character block.
 * @since 1.8
 * @apiSince 26
 */

public static final java.lang.Character.UnicodeBlock SUNDANESE_SUPPLEMENT;
static { SUNDANESE_SUPPLEMENT = null; }

/**
 * Constant for the "Superscripts and Subscripts" Unicode character
 * block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock SUPERSCRIPTS_AND_SUBSCRIPTS;
static { SUPERSCRIPTS_AND_SUBSCRIPTS = null; }

/**
 * Constant for the "Supplemental Arrows-A" Unicode character block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock SUPPLEMENTAL_ARROWS_A;
static { SUPPLEMENTAL_ARROWS_A = null; }

/**
 * Constant for the "Supplemental Arrows-B" Unicode character block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock SUPPLEMENTAL_ARROWS_B;
static { SUPPLEMENTAL_ARROWS_B = null; }

/**
 * Constant for the "Supplemental Mathematical Operators" Unicode
 * character block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock SUPPLEMENTAL_MATHEMATICAL_OPERATORS;
static { SUPPLEMENTAL_MATHEMATICAL_OPERATORS = null; }

/**
 * Constant for the "Supplemental Punctuation" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock SUPPLEMENTAL_PUNCTUATION;
static { SUPPLEMENTAL_PUNCTUATION = null; }

/**
 * Constant for the "Supplementary Private Use Area-A" Unicode character
 * block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock SUPPLEMENTARY_PRIVATE_USE_AREA_A;
static { SUPPLEMENTARY_PRIVATE_USE_AREA_A = null; }

/**
 * Constant for the "Supplementary Private Use Area-B" Unicode character
 * block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock SUPPLEMENTARY_PRIVATE_USE_AREA_B;
static { SUPPLEMENTARY_PRIVATE_USE_AREA_B = null; }

/**
 * @deprecated As of J2SE 5, use {@link #HIGH_SURROGATES},
 *             {@link #HIGH_PRIVATE_USE_SURROGATES}, and
 *             {@link #LOW_SURROGATES}. These new constants match
 *             the block definitions of the Unicode Standard.
 *             The {@link #of(char)} and {@link #of(int)} methods
 *             return the new constants, not SURROGATES_AREA.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.Character.UnicodeBlock SURROGATES_AREA;
static { SURROGATES_AREA = null; }

/**
 * Constant for the "Syloti Nagri" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock SYLOTI_NAGRI;
static { SYLOTI_NAGRI = null; }

/**
 * Constant for the "Syriac" Unicode character block.
 * @since 1.4
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock SYRIAC;
static { SYRIAC = null; }

/**
 * Constant for the "Tagalog" Unicode character block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock TAGALOG;
static { TAGALOG = null; }

/**
 * Constant for the "Tagbanwa" Unicode character block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock TAGBANWA;
static { TAGBANWA = null; }

/**
 * Constant for the "Tags" Unicode character block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock TAGS;
static { TAGS = null; }

/**
 * Constant for the "Tai Le" Unicode character block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock TAI_LE;
static { TAI_LE = null; }

/**
 * Constant for the "Tai Tham" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock TAI_THAM;
static { TAI_THAM = null; }

/**
 * Constant for the "Tai Viet" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock TAI_VIET;
static { TAI_VIET = null; }

/**
 * Constant for the "Tai Xuan Jing Symbols" Unicode character block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock TAI_XUAN_JING_SYMBOLS;
static { TAI_XUAN_JING_SYMBOLS = null; }

/**
 * Constant for the "Takri" Unicode character block.
 * @since 1.8
 * @apiSince 26
 */

public static final java.lang.Character.UnicodeBlock TAKRI;
static { TAKRI = null; }

/**
 * Constant for the "Tamil" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock TAMIL;
static { TAMIL = null; }

/**
 * Constant for the "Telugu" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock TELUGU;
static { TELUGU = null; }

/**
 * Constant for the "Thaana" Unicode character block.
 * @since 1.4
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock THAANA;
static { THAANA = null; }

/**
 * Constant for the "Thai" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock THAI;
static { THAI = null; }

/**
 * Constant for the "Tibetan" Unicode character block.
 * @since 1.2
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock TIBETAN;
static { TIBETAN = null; }

/**
 * Constant for the "Tifinagh" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock TIFINAGH;
static { TIFINAGH = null; }

/**
 * Constant for the "Transport And Map Symbols" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock TRANSPORT_AND_MAP_SYMBOLS;
static { TRANSPORT_AND_MAP_SYMBOLS = null; }

/**
 * Constant for the "Ugaritic" Unicode character block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock UGARITIC;
static { UGARITIC = null; }

/**
 * Constant for the "Unified Canadian Aboriginal Syllabics" Unicode character block.
 * @since 1.4
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS;
static { UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS = null; }

/**
 * Constant for the "Unified Canadian Aboriginal Syllabics Extended"
 * Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS_EXTENDED;
static { UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS_EXTENDED = null; }

/**
 * Constant for the "Vai" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock VAI;
static { VAI = null; }

/**
 * Constant for the "Variation Selectors" Unicode character block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock VARIATION_SELECTORS;
static { VARIATION_SELECTORS = null; }

/**
 * Constant for the "Variation Selectors Supplement" Unicode character
 * block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock VARIATION_SELECTORS_SUPPLEMENT;
static { VARIATION_SELECTORS_SUPPLEMENT = null; }

/**
 * Constant for the "Vedic Extensions" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock VEDIC_EXTENSIONS;
static { VEDIC_EXTENSIONS = null; }

/**
 * Constant for the "Vertical Forms" Unicode character block.
 * @since 1.7
 * @apiSince 19
 */

public static final java.lang.Character.UnicodeBlock VERTICAL_FORMS;
static { VERTICAL_FORMS = null; }

/**
 * Constant for the "Yijing Hexagram Symbols" Unicode character block.
 * @since 1.5
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock YIJING_HEXAGRAM_SYMBOLS;
static { YIJING_HEXAGRAM_SYMBOLS = null; }

/**
 * Constant for the "Yi Radicals" Unicode character block.
 * @since 1.4
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock YI_RADICALS;
static { YI_RADICALS = null; }

/**
 * Constant for the "Yi Syllables" Unicode character block.
 * @since 1.4
 * @apiSince 1
 */

public static final java.lang.Character.UnicodeBlock YI_SYLLABLES;
static { YI_SYLLABLES = null; }
}

/**
 * A family of character subsets representing the character scripts
 * defined in the <a href="http://www.unicode.org/reports/tr24/">
 * <i>Unicode Standard Annex #24: Script Names</i></a>. Every Unicode
 * character is assigned to a single Unicode script, either a specific
 * script, such as {@link java.lang.Character.UnicodeScript#LATIN Character.UnicodeScript#LATIN}, or
 * one of the following three special values,
 * {@link java.lang.Character.UnicodeScript#INHERITED Character.UnicodeScript#INHERITED},
 * {@link java.lang.Character.UnicodeScript#COMMON Character.UnicodeScript#COMMON} or
 * {@link java.lang.Character.UnicodeScript#UNKNOWN Character.UnicodeScript#UNKNOWN}.
 *
 * @since 1.7
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum UnicodeScript {
/**
 * Unicode script "Common".
 * @apiSince 24
 */

COMMON,
/**
 * Unicode script "Latin".
 * @apiSince 24
 */

LATIN,
/**
 * Unicode script "Greek".
 * @apiSince 24
 */

GREEK,
/**
 * Unicode script "Cyrillic".
 * @apiSince 24
 */

CYRILLIC,
/**
 * Unicode script "Armenian".
 * @apiSince 24
 */

ARMENIAN,
/**
 * Unicode script "Hebrew".
 * @apiSince 24
 */

HEBREW,
/**
 * Unicode script "Arabic".
 * @apiSince 24
 */

ARABIC,
/**
 * Unicode script "Syriac".
 * @apiSince 24
 */

SYRIAC,
/**
 * Unicode script "Thaana".
 * @apiSince 24
 */

THAANA,
/**
 * Unicode script "Devanagari".
 * @apiSince 24
 */

DEVANAGARI,
/**
 * Unicode script "Bengali".
 * @apiSince 24
 */

BENGALI,
/**
 * Unicode script "Gurmukhi".
 * @apiSince 24
 */

GURMUKHI,
/**
 * Unicode script "Gujarati".
 * @apiSince 24
 */

GUJARATI,
/**
 * Unicode script "Oriya".
 * @apiSince 24
 */

ORIYA,
/**
 * Unicode script "Tamil".
 * @apiSince 24
 */

TAMIL,
/**
 * Unicode script "Telugu".
 * @apiSince 24
 */

TELUGU,
/**
 * Unicode script "Kannada".
 * @apiSince 24
 */

KANNADA,
/**
 * Unicode script "Malayalam".
 * @apiSince 24
 */

MALAYALAM,
/**
 * Unicode script "Sinhala".
 * @apiSince 24
 */

SINHALA,
/**
 * Unicode script "Thai".
 * @apiSince 24
 */

THAI,
/**
 * Unicode script "Lao".
 * @apiSince 24
 */

LAO,
/**
 * Unicode script "Tibetan".
 * @apiSince 24
 */

TIBETAN,
/**
 * Unicode script "Myanmar".
 * @apiSince 24
 */

MYANMAR,
/**
 * Unicode script "Georgian".
 * @apiSince 24
 */

GEORGIAN,
/**
 * Unicode script "Hangul".
 * @apiSince 24
 */

HANGUL,
/**
 * Unicode script "Ethiopic".
 * @apiSince 24
 */

ETHIOPIC,
/**
 * Unicode script "Cherokee".
 * @apiSince 24
 */

CHEROKEE,
/**
 * Unicode script "Canadian_Aboriginal".
 * @apiSince 24
 */

CANADIAN_ABORIGINAL,
/**
 * Unicode script "Ogham".
 * @apiSince 24
 */

OGHAM,
/**
 * Unicode script "Runic".
 * @apiSince 24
 */

RUNIC,
/**
 * Unicode script "Khmer".
 * @apiSince 24
 */

KHMER,
/**
 * Unicode script "Mongolian".
 * @apiSince 24
 */

MONGOLIAN,
/**
 * Unicode script "Hiragana".
 * @apiSince 24
 */

HIRAGANA,
/**
 * Unicode script "Katakana".
 * @apiSince 24
 */

KATAKANA,
/**
 * Unicode script "Bopomofo".
 * @apiSince 24
 */

BOPOMOFO,
/**
 * Unicode script "Han".
 * @apiSince 24
 */

HAN,
/**
 * Unicode script "Yi".
 * @apiSince 24
 */

YI,
/**
 * Unicode script "Old_Italic".
 * @apiSince 24
 */

OLD_ITALIC,
/**
 * Unicode script "Gothic".
 * @apiSince 24
 */

GOTHIC,
/**
 * Unicode script "Deseret".
 * @apiSince 24
 */

DESERET,
/**
 * Unicode script "Inherited".
 * @apiSince 24
 */

INHERITED,
/**
 * Unicode script "Tagalog".
 * @apiSince 24
 */

TAGALOG,
/**
 * Unicode script "Hanunoo".
 * @apiSince 24
 */

HANUNOO,
/**
 * Unicode script "Buhid".
 * @apiSince 24
 */

BUHID,
/**
 * Unicode script "Tagbanwa".
 * @apiSince 24
 */

TAGBANWA,
/**
 * Unicode script "Limbu".
 * @apiSince 24
 */

LIMBU,
/**
 * Unicode script "Tai_Le".
 * @apiSince 24
 */

TAI_LE,
/**
 * Unicode script "Linear_B".
 * @apiSince 24
 */

LINEAR_B,
/**
 * Unicode script "Ugaritic".
 * @apiSince 24
 */

UGARITIC,
/**
 * Unicode script "Shavian".
 * @apiSince 24
 */

SHAVIAN,
/**
 * Unicode script "Osmanya".
 * @apiSince 24
 */

OSMANYA,
/**
 * Unicode script "Cypriot".
 * @apiSince 24
 */

CYPRIOT,
/**
 * Unicode script "Braille".
 * @apiSince 24
 */

BRAILLE,
/**
 * Unicode script "Buginese".
 * @apiSince 24
 */

BUGINESE,
/**
 * Unicode script "Coptic".
 * @apiSince 24
 */

COPTIC,
/**
 * Unicode script "New_Tai_Lue".
 * @apiSince 24
 */

NEW_TAI_LUE,
/**
 * Unicode script "Glagolitic".
 * @apiSince 24
 */

GLAGOLITIC,
/**
 * Unicode script "Tifinagh".
 * @apiSince 24
 */

TIFINAGH,
/**
 * Unicode script "Syloti_Nagri".
 * @apiSince 24
 */

SYLOTI_NAGRI,
/**
 * Unicode script "Old_Persian".
 * @apiSince 24
 */

OLD_PERSIAN,
/**
 * Unicode script "Kharoshthi".
 * @apiSince 24
 */

KHAROSHTHI,
/**
 * Unicode script "Balinese".
 * @apiSince 24
 */

BALINESE,
/**
 * Unicode script "Cuneiform".
 * @apiSince 24
 */

CUNEIFORM,
/**
 * Unicode script "Phoenician".
 * @apiSince 24
 */

PHOENICIAN,
/**
 * Unicode script "Phags_Pa".
 * @apiSince 24
 */

PHAGS_PA,
/**
 * Unicode script "Nko".
 * @apiSince 24
 */

NKO,
/**
 * Unicode script "Sundanese".
 * @apiSince 24
 */

SUNDANESE,
/**
 * Unicode script "Batak".
 * @apiSince 24
 */

BATAK,
/**
 * Unicode script "Lepcha".
 * @apiSince 24
 */

LEPCHA,
/**
 * Unicode script "Ol_Chiki".
 * @apiSince 24
 */

OL_CHIKI,
/**
 * Unicode script "Vai".
 * @apiSince 24
 */

VAI,
/**
 * Unicode script "Saurashtra".
 * @apiSince 24
 */

SAURASHTRA,
/**
 * Unicode script "Kayah_Li".
 * @apiSince 24
 */

KAYAH_LI,
/**
 * Unicode script "Rejang".
 * @apiSince 24
 */

REJANG,
/**
 * Unicode script "Lycian".
 * @apiSince 24
 */

LYCIAN,
/**
 * Unicode script "Carian".
 * @apiSince 24
 */

CARIAN,
/**
 * Unicode script "Lydian".
 * @apiSince 24
 */

LYDIAN,
/**
 * Unicode script "Cham".
 * @apiSince 24
 */

CHAM,
/**
 * Unicode script "Tai_Tham".
 * @apiSince 24
 */

TAI_THAM,
/**
 * Unicode script "Tai_Viet".
 * @apiSince 24
 */

TAI_VIET,
/**
 * Unicode script "Avestan".
 * @apiSince 24
 */

AVESTAN,
/**
 * Unicode script "Egyptian_Hieroglyphs".
 * @apiSince 24
 */

EGYPTIAN_HIEROGLYPHS,
/**
 * Unicode script "Samaritan".
 * @apiSince 24
 */

SAMARITAN,
/**
 * Unicode script "Mandaic".
 * @apiSince 24
 */

MANDAIC,
/**
 * Unicode script "Lisu".
 * @apiSince 24
 */

LISU,
/**
 * Unicode script "Bamum".
 * @apiSince 24
 */

BAMUM,
/**
 * Unicode script "Javanese".
 * @apiSince 24
 */

JAVANESE,
/**
 * Unicode script "Meetei_Mayek".
 * @apiSince 24
 */

MEETEI_MAYEK,
/**
 * Unicode script "Imperial_Aramaic".
 * @apiSince 24
 */

IMPERIAL_ARAMAIC,
/**
 * Unicode script "Old_South_Arabian".
 * @apiSince 24
 */

OLD_SOUTH_ARABIAN,
/**
 * Unicode script "Inscriptional_Parthian".
 * @apiSince 24
 */

INSCRIPTIONAL_PARTHIAN,
/**
 * Unicode script "Inscriptional_Pahlavi".
 * @apiSince 24
 */

INSCRIPTIONAL_PAHLAVI,
/**
 * Unicode script "Old_Turkic".
 * @apiSince 24
 */

OLD_TURKIC,
/**
 * Unicode script "Brahmi".
 * @apiSince 24
 */

BRAHMI,
/**
 * Unicode script "Kaithi".
 * @apiSince 24
 */

KAITHI,
/**
 * Unicode script "Meroitic Hieroglyphs".
 * @apiSince 26
 */

MEROITIC_HIEROGLYPHS,
/**
 * Unicode script "Meroitic Cursive".
 * @apiSince 26
 */

MEROITIC_CURSIVE,
/**
 * Unicode script "Sora Sompeng".
 * @apiSince 26
 */

SORA_SOMPENG,
/**
 * Unicode script "Chakma".
 * @apiSince 26
 */

CHAKMA,
/**
 * Unicode script "Sharada".
 * @apiSince 26
 */

SHARADA,
/**
 * Unicode script "Takri".
 * @apiSince 26
 */

TAKRI,
/**
 * Unicode script "Miao".
 * @apiSince 26
 */

MIAO,
/**
 * Unicode script "Unknown".
 * @apiSince 24
 */

UNKNOWN;

/**
 * Returns the enum constant representing the Unicode script of which
 * the given character (Unicode code point) is assigned to.
 *
 * @param   codePoint the character (Unicode code point) in question.
 * @return  The {@code UnicodeScript} constant representing the
 *          Unicode script of which this character is assigned to.
 *
 * @exception java.lang.IllegalArgumentException if the specified
 * {@code codePoint} is an invalid Unicode code point.
 * @see java.lang.Character#isValidCodePoint(int)
 *
 * @apiSince 24
 */

@androidx.annotation.NonNull
public static java.lang.Character.UnicodeScript of(int codePoint) { throw new RuntimeException("Stub!"); }

/**
 * Returns the UnicodeScript constant with the given Unicode script
 * name or the script name alias. Script names and their aliases are
 * determined by The Unicode Standard. The files Scripts&lt;version&gt;.txt
 * and PropertyValueAliases&lt;version&gt;.txt define script names
 * and the script name aliases for a particular version of the
 * standard. The {@link java.lang.Character Character} class specifies the version of
 * the standard that it supports.
 * <p>
 * Character case is ignored for all of the valid script names.
 * The en_US locale's case mapping rules are used to provide
 * case-insensitive string comparisons for script name validation.
 * <p>
 *
 * @param scriptName A {@code UnicodeScript} name.
 * @return The {@code UnicodeScript} constant identified
 *         by {@code scriptName}
 * @throws java.lang.IllegalArgumentException if {@code scriptName} is an
 *         invalid name
 * @throws java.lang.NullPointerException if {@code scriptName} is null
 * @apiSince 24
 */

@androidx.annotation.NonNull
public static java.lang.Character.UnicodeScript forName(@androidx.annotation.NonNull java.lang.String scriptName) { throw new RuntimeException("Stub!"); }
}

}

