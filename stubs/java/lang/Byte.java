/*
 * Copyright (c) 1996, 2013, Oracle and/or its affiliates. All rights reserved.
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
 *
 * The {@code Byte} class wraps a value of primitive type {@code byte}
 * in an object.  An object of type {@code Byte} contains a single
 * field whose type is {@code byte}.
 *
 * <p>In addition, this class provides several methods for converting
 * a {@code byte} to a {@code String} and a {@code String} to a {@code
 * byte}, as well as other constants and methods useful when dealing
 * with a {@code byte}.
 *
 * @author  Nakul Saraiya
 * @author  Joseph D. Darcy
 * @see     java.lang.Number
 * @since   JDK1.1
 @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Byte extends java.lang.Number implements java.lang.Comparable<java.lang.Byte> {

/**
 * Constructs a newly allocated {@code Byte} object that
 * represents the specified {@code byte} value.
 *
 * @param value     the value to be represented by the
 *                  {@code Byte}.
 * @apiSince 1
 */

public Byte(byte value) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a newly allocated {@code Byte} object that
 * represents the {@code byte} value indicated by the
 * {@code String} parameter. The string is converted to a
 * {@code byte} value in exactly the manner used by the
 * {@code parseByte} method for radix 10.
 *
 * @param s         the {@code String} to be converted to a
 *                  {@code Byte}
 * @throws           java.lang.NumberFormatException If the {@code String}
 *                  does not contain a parsable {@code byte}.
 * @see        java.lang.Byte#parseByte(java.lang.String, int)
 * @apiSince 1
 */

public Byte(@androidx.annotation.NonNull java.lang.String s) throws java.lang.NumberFormatException { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code String} object representing the
 * specified {@code byte}. The radix is assumed to be 10.
 *
 * @param b the {@code byte} to be converted
 * @return the string representation of the specified {@code byte}
 * @see java.lang.Integer#toString(int)
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.String toString(byte b) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Byte} instance representing the specified
 * {@code byte} value.
 * If a new {@code Byte} instance is not required, this method
 * should generally be used in preference to the constructor
 * {@link #Byte(byte)}, as this method is likely to yield
 * significantly better space and time performance since
 * all byte values are cached.
 *
 * @param  b a byte value.
 * @return a {@code Byte} instance representing {@code b}.
 * @since  1.5
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.Byte valueOf(byte b) { throw new RuntimeException("Stub!"); }

/**
 * Parses the string argument as a signed {@code byte} in the
 * radix specified by the second argument. The characters in the
 * string must all be digits, of the specified radix (as
 * determined by whether {@link java.lang.Character#digit(char,
 * int)} returns a nonnegative value) except that the first
 * character may be an ASCII minus sign {@code '-'}
 * ({@code '\u005Cu002D'}) to indicate a negative value or an
 * ASCII plus sign {@code '+'} ({@code '\u005Cu002B'}) to
 * indicate a positive value.  The resulting {@code byte} value is
 * returned.
 *
 * <p>An exception of type {@code NumberFormatException} is
 * thrown if any of the following situations occurs:
 * <ul>
 * <li> The first argument is {@code null} or is a string of
 * length zero.
 *
 * <li> The radix is either smaller than {@link
 * java.lang.Character#MIN_RADIX} or larger than {@link
 * java.lang.Character#MAX_RADIX}.
 *
 * <li> Any character of the string is not a digit of the
 * specified radix, except that the first character may be a minus
 * sign {@code '-'} ({@code '\u005Cu002D'}) or plus sign
 * {@code '+'} ({@code '\u005Cu002B'}) provided that the
 * string is longer than length 1.
 *
 * <li> The value represented by the string is not a value of type
 * {@code byte}.
 * </ul>
 *
 * @param s         the {@code String} containing the
 *                  {@code byte}
 *                  representation to be parsed
 * @param radix     the radix to be used while parsing {@code s}
 * @return          the {@code byte} value represented by the string
 *                   argument in the specified radix
 * @throws          java.lang.NumberFormatException If the string does
 *                  not contain a parsable {@code byte}.
 * @apiSince 1
 */

public static byte parseByte(@androidx.annotation.NonNull java.lang.String s, int radix) throws java.lang.NumberFormatException { throw new RuntimeException("Stub!"); }

/**
 * Parses the string argument as a signed decimal {@code
 * byte}. The characters in the string must all be decimal digits,
 * except that the first character may be an ASCII minus sign
 * {@code '-'} ({@code '\u005Cu002D'}) to indicate a negative
 * value or an ASCII plus sign {@code '+'}
 * ({@code '\u005Cu002B'}) to indicate a positive value. The
 * resulting {@code byte} value is returned, exactly as if the
 * argument and the radix 10 were given as arguments to the {@link
 * #parseByte(java.lang.String,int)} method.
 *
 * @param s         a {@code String} containing the
 *                  {@code byte} representation to be parsed
 * @return          the {@code byte} value represented by the
 *                  argument in decimal
 * @throws          java.lang.NumberFormatException if the string does not
 *                  contain a parsable {@code byte}.
 * @apiSince 1
 */

public static byte parseByte(@androidx.annotation.NonNull java.lang.String s) throws java.lang.NumberFormatException { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Byte} object holding the value
 * extracted from the specified {@code String} when parsed
 * with the radix given by the second argument. The first argument
 * is interpreted as representing a signed {@code byte} in
 * the radix specified by the second argument, exactly as if the
 * argument were given to the {@link #parseByte(java.lang.String,int)} method. The result is a {@code Byte} object that
 * represents the {@code byte} value specified by the string.
 *
 * <p> In other words, this method returns a {@code Byte} object
 * equal to the value of:
 *
 * <blockquote>
 * {@code new Byte(Byte.parseByte(s, radix))}
 * </blockquote>
 *
 * @param s         the string to be parsed
 * @param radix     the radix to be used in interpreting {@code s}
 * @return          a {@code Byte} object holding the value
 *                  represented by the string argument in the
 *                  specified radix.
 * @throws          java.lang.NumberFormatException If the {@code String} does
 *                  not contain a parsable {@code byte}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.Byte valueOf(@androidx.annotation.NonNull java.lang.String s, int radix) throws java.lang.NumberFormatException { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Byte} object holding the value
 * given by the specified {@code String}. The argument is
 * interpreted as representing a signed decimal {@code byte},
 * exactly as if the argument were given to the {@link
 * #parseByte(java.lang.String)} method. The result is a
 * {@code Byte} object that represents the {@code byte}
 * value specified by the string.
 *
 * <p> In other words, this method returns a {@code Byte} object
 * equal to the value of:
 *
 * <blockquote>
 * {@code new Byte(Byte.parseByte(s))}
 * </blockquote>
 *
 * @param s         the string to be parsed
 * @return          a {@code Byte} object holding the value
 *                  represented by the string argument
 * @throws          java.lang.NumberFormatException If the {@code String} does
 *                  not contain a parsable {@code byte}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.Byte valueOf(@androidx.annotation.NonNull java.lang.String s) throws java.lang.NumberFormatException { throw new RuntimeException("Stub!"); }

/**
 * Decodes a {@code String} into a {@code Byte}.
 * Accepts decimal, hexadecimal, and octal numbers given by
 * the following grammar:
 *
 * <blockquote>
 * <dl>
 * <dt><i>DecodableString:</i>
 * <dd><i>Sign<sub>opt</sub> DecimalNumeral</i>
 * <dd><i>Sign<sub>opt</sub></i> {@code 0x} <i>HexDigits</i>
 * <dd><i>Sign<sub>opt</sub></i> {@code 0X} <i>HexDigits</i>
 * <dd><i>Sign<sub>opt</sub></i> {@code #} <i>HexDigits</i>
 * <dd><i>Sign<sub>opt</sub></i> {@code 0} <i>OctalDigits</i>
 *
 * <dt><i>Sign:</i>
 * <dd>{@code -}
 * <dd>{@code +}
 * </dl>
 * </blockquote>
 *
 * <i>DecimalNumeral</i>, <i>HexDigits</i>, and <i>OctalDigits</i>
 * are as defined in section 3.10.1 of
 * <cite>The Java&trade; Language Specification</cite>,
 * except that underscores are not accepted between digits.
 *
 * <p>The sequence of characters following an optional
 * sign and/or radix specifier ("{@code 0x}", "{@code 0X}",
 * "{@code #}", or leading zero) is parsed as by the {@code
 * Byte.parseByte} method with the indicated radix (10, 16, or 8).
 * This sequence of characters must represent a positive value or
 * a {@link java.lang.NumberFormatException NumberFormatException} will be thrown.  The result is
 * negated if first character of the specified {@code String} is
 * the minus sign.  No whitespace characters are permitted in the
 * {@code String}.
 *
 * @param     nm the {@code String} to decode.
 * @return   a {@code Byte} object holding the {@code byte}
 *          value represented by {@code nm}
 * @throws  java.lang.NumberFormatException  if the {@code String} does not
 *            contain a parsable {@code byte}.
 * @see java.lang.Byte#parseByte(java.lang.String, int)
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.Byte decode(@androidx.annotation.NonNull java.lang.String nm) throws java.lang.NumberFormatException { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of this {@code Byte} as a
 * {@code byte}.
 * @apiSince 1
 */

public byte byteValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of this {@code Byte} as a {@code short} after
 * a widening primitive conversion.
 * @jls 5.1.2 Widening Primitive Conversions
 * @apiSince 1
 */

public short shortValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of this {@code Byte} as an {@code int} after
 * a widening primitive conversion.
 * @jls 5.1.2 Widening Primitive Conversions
 * @apiSince 1
 */

public int intValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of this {@code Byte} as a {@code long} after
 * a widening primitive conversion.
 * @jls 5.1.2 Widening Primitive Conversions
 * @apiSince 1
 */

public long longValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of this {@code Byte} as a {@code float} after
 * a widening primitive conversion.
 * @jls 5.1.2 Widening Primitive Conversions
 * @apiSince 1
 */

public float floatValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of this {@code Byte} as a {@code double}
 * after a widening primitive conversion.
 * @jls 5.1.2 Widening Primitive Conversions
 * @apiSince 1
 */

public double doubleValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code String} object representing this
 * {@code Byte}'s value.  The value is converted to signed
 * decimal representation and returned as a string, exactly as if
 * the {@code byte} value were given as an argument to the
 * {@link java.lang.Byte#toString(byte)} method.
 *
 * @return  a string representation of the value of this object in
 *          base&nbsp;10.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code for this {@code Byte}; equal to the result
 * of invoking {@code intValue()}.
 *
 * @return a hash code value for this {@code Byte}
 * @apiSince 1
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code for a {@code byte} value; compatible with
 * {@code Byte.hashCode()}.
 *
 * @param value the value to hash
 * @return a hash code value for a {@code byte} value.
 * @since 1.8
 * @apiSince 24
 */

public static int hashCode(byte value) { throw new RuntimeException("Stub!"); }

/**
 * Compares this object to the specified object.  The result is
 * {@code true} if and only if the argument is not
 * {@code null} and is a {@code Byte} object that
 * contains the same {@code byte} value as this object.
 *
 * @param obj       the object to compare with
 * @return          {@code true} if the objects are the same;
 *                  {@code false} otherwise.
 * @apiSince 1
 */

public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Compares two {@code Byte} objects numerically.
 *
 * @param   anotherByte   the {@code Byte} to be compared.
 * @return  the value {@code 0} if this {@code Byte} is
 *          equal to the argument {@code Byte}; a value less than
 *          {@code 0} if this {@code Byte} is numerically less
 *          than the argument {@code Byte}; and a value greater than
 *           {@code 0} if this {@code Byte} is numerically
 *           greater than the argument {@code Byte} (signed
 *           comparison).
 * @since   1.2
 * @apiSince 1
 */

public int compareTo(@androidx.annotation.NonNull java.lang.Byte anotherByte) { throw new RuntimeException("Stub!"); }

/**
 * Compares two {@code byte} values numerically.
 * The value returned is identical to what would be returned by:
 * <pre>
 *    Byte.valueOf(x).compareTo(Byte.valueOf(y))
 * </pre>
 *
 * @param  x the first {@code byte} to compare
 * @param  y the second {@code byte} to compare
 * @return the value {@code 0} if {@code x == y};
 *         a value less than {@code 0} if {@code x < y}; and
 *         a value greater than {@code 0} if {@code x > y}
 * @since 1.7
 * @apiSince 19
 */

public static int compare(byte x, byte y) { throw new RuntimeException("Stub!"); }

/**
 * Converts the argument to an {@code int} by an unsigned
 * conversion.  In an unsigned conversion to an {@code int}, the
 * high-order 24 bits of the {@code int} are zero and the
 * low-order 8 bits are equal to the bits of the {@code byte} argument.
 *
 * Consequently, zero and positive {@code byte} values are mapped
 * to a numerically equal {@code int} value and negative {@code
 * byte} values are mapped to an {@code int} value equal to the
 * input plus 2<sup>8</sup>.
 *
 * @param  x the value to convert to an unsigned {@code int}
 * @return the argument converted to {@code int} by an unsigned
 *         conversion
 * @since 1.8
 * @apiSince 26
 */

public static int toUnsignedInt(byte x) { throw new RuntimeException("Stub!"); }

/**
 * Converts the argument to a {@code long} by an unsigned
 * conversion.  In an unsigned conversion to a {@code long}, the
 * high-order 56 bits of the {@code long} are zero and the
 * low-order 8 bits are equal to the bits of the {@code byte} argument.
 *
 * Consequently, zero and positive {@code byte} values are mapped
 * to a numerically equal {@code long} value and negative {@code
 * byte} values are mapped to a {@code long} value equal to the
 * input plus 2<sup>8</sup>.
 *
 * @param  x the value to convert to an unsigned {@code long}
 * @return the argument converted to {@code long} by an unsigned
 *         conversion
 * @since 1.8
 * @apiSince 26
 */

public static long toUnsignedLong(byte x) { throw new RuntimeException("Stub!"); }

/**
 * The number of bytes used to represent a {@code byte} value in two's
 * complement binary form.
 *
 * @since 1.8
 * @apiSince 24
 */

public static final int BYTES = 1; // 0x1

/**
 * A constant holding the maximum value a {@code byte} can
 * have, 2<sup>7</sup>-1.
 * @apiSince 1
 */

public static final byte MAX_VALUE = 127; // 0x7f

/**
 * A constant holding the minimum value a {@code byte} can
 * have, -2<sup>7</sup>.
 * @apiSince 1
 */

public static final byte MIN_VALUE = -128; // 0xffffff80

/**
 * The number of bits used to represent a {@code byte} value in two's
 * complement binary form.
 *
 * @since 1.5
 * @apiSince 1
 */

public static final int SIZE = 8; // 0x8

/**
 * The {@code Class} instance representing the primitive type
 * {@code byte}.
 * @apiSince 1
 */

public static final java.lang.Class<java.lang.Byte> TYPE;
static { TYPE = null; }
}

