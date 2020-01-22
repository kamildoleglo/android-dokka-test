/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package android.util;


/**
 * <p>The {@code Half} class is a wrapper and a utility class to manipulate half-precision 16-bit
 * <a href="https://en.wikipedia.org/wiki/Half-precision_floating-point_format">IEEE 754</a>
 * floating point data types (also called fp16 or binary16). A half-precision float can be
 * created from or converted to single-precision floats, and is stored in a short data type.
 * To distinguish short values holding half-precision floats from regular short values,
 * it is recommended to use the <code>@HalfFloat</code> annotation.</p>
 *
 * <p>The IEEE 754 standard specifies an fp16 as having the following format:</p>
 * <ul>
 * <li>Sign bit: 1 bit</li>
 * <li>Exponent width: 5 bits</li>
 * <li>Significand: 10 bits</li>
 * </ul>
 *
 * <p>The format is laid out as follows:</p>
 * <pre>
 * 1   11111   1111111111
 * ^   --^--   -----^----
 * sign  |          |_______ significand
 *       |
 *       -- exponent
 * </pre>
 *
 * <p>Half-precision floating points can be useful to save memory and/or
 * bandwidth at the expense of range and precision when compared to single-precision
 * floating points (fp32).</p>
 * <p>To help you decide whether fp16 is the right storage type for you need, please
 * refer to the table below that shows the available precision throughout the range of
 * possible values. The <em>precision</em> column indicates the step size between two
 * consecutive numbers in a specific part of the range.</p>
 *
 * <table summary="Precision of fp16 across the range">
 *     <tr><th>Range start</th><th>Precision</th></tr>
 *     <tr><td>0</td><td>1 &frasl; 16,777,216</td></tr>
 *     <tr><td>1 &frasl; 16,384</td><td>1 &frasl; 16,777,216</td></tr>
 *     <tr><td>1 &frasl; 8,192</td><td>1 &frasl; 8,388,608</td></tr>
 *     <tr><td>1 &frasl; 4,096</td><td>1 &frasl; 4,194,304</td></tr>
 *     <tr><td>1 &frasl; 2,048</td><td>1 &frasl; 2,097,152</td></tr>
 *     <tr><td>1 &frasl; 1,024</td><td>1 &frasl; 1,048,576</td></tr>
 *     <tr><td>1 &frasl; 512</td><td>1 &frasl; 524,288</td></tr>
 *     <tr><td>1 &frasl; 256</td><td>1 &frasl; 262,144</td></tr>
 *     <tr><td>1 &frasl; 128</td><td>1 &frasl; 131,072</td></tr>
 *     <tr><td>1 &frasl; 64</td><td>1 &frasl; 65,536</td></tr>
 *     <tr><td>1 &frasl; 32</td><td>1 &frasl; 32,768</td></tr>
 *     <tr><td>1 &frasl; 16</td><td>1 &frasl; 16,384</td></tr>
 *     <tr><td>1 &frasl; 8</td><td>1 &frasl; 8,192</td></tr>
 *     <tr><td>1 &frasl; 4</td><td>1 &frasl; 4,096</td></tr>
 *     <tr><td>1 &frasl; 2</td><td>1 &frasl; 2,048</td></tr>
 *     <tr><td>1</td><td>1 &frasl; 1,024</td></tr>
 *     <tr><td>2</td><td>1 &frasl; 512</td></tr>
 *     <tr><td>4</td><td>1 &frasl; 256</td></tr>
 *     <tr><td>8</td><td>1 &frasl; 128</td></tr>
 *     <tr><td>16</td><td>1 &frasl; 64</td></tr>
 *     <tr><td>32</td><td>1 &frasl; 32</td></tr>
 *     <tr><td>64</td><td>1 &frasl; 16</td></tr>
 *     <tr><td>128</td><td>1 &frasl; 8</td></tr>
 *     <tr><td>256</td><td>1 &frasl; 4</td></tr>
 *     <tr><td>512</td><td>1 &frasl; 2</td></tr>
 *     <tr><td>1,024</td><td>1</td></tr>
 *     <tr><td>2,048</td><td>2</td></tr>
 *     <tr><td>4,096</td><td>4</td></tr>
 *     <tr><td>8,192</td><td>8</td></tr>
 *     <tr><td>16,384</td><td>16</td></tr>
 *     <tr><td>32,768</td><td>32</td></tr>
 * </table>
 *
 * <p>This table shows that numbers higher than 1024 lose all fractional precision.</p>
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Half extends java.lang.Number implements java.lang.Comparable<android.util.Half> {

/**
 * Constructs a newly allocated {@code Half} object that represents the
 * half-precision float type argument.
 *
 * @param value The value to be represented by the {@code Half}
 * @apiSince 26
 */

public Half(short value) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a newly allocated {@code Half} object that represents the
 * argument converted to a half-precision float.
 *
 * @param value The value to be represented by the {@code Half}
 *
 * @see #toHalf(float)
 * @apiSince 26
 */

public Half(float value) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a newly allocated {@code Half} object that
 * represents the argument converted to a half-precision float.
 *
 * @param value The value to be represented by the {@code Half}
 *
 * @see #toHalf(float)
 * @apiSince 26
 */

public Half(double value) { throw new RuntimeException("Stub!"); }

/**
 * <p>Constructs a newly allocated {@code Half} object that represents the
 * half-precision float value represented by the string.
 * The string is converted to a half-precision float value as if by the
 * {@link #valueOf(java.lang.String)} method.</p>
 *
 * <p>Calling this constructor is equivalent to calling:</p>
 * <pre>
 *     new Half(Float.parseFloat(value))
 * </pre>
 *
 * @param value A string to be converted to a {@code Half}
 * This value must never be {@code null}.
 * @throws java.lang.NumberFormatException if the string does not contain a parsable number
 *
 * @see java.lang.Float#valueOf(java.lang.String)
 * @see #toHalf(float)
 * @apiSince 26
 */

public Half(@androidx.annotation.NonNull java.lang.String value) throws java.lang.NumberFormatException { throw new RuntimeException("Stub!"); }

/**
 * Returns the half-precision value of this {@code Half} as a {@code short}
 * containing the bit representation described in {@link android.util.Half Half}.
 *
 * @return The half-precision float value represented by this object
 * @apiSince 26
 */

public short halfValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of this {@code Half} as a {@code byte} after
 * a narrowing primitive conversion.
 *
 * @return The half-precision float value represented by this object
 *         converted to type {@code byte}
 * @apiSince 26
 */

public byte byteValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of this {@code Half} as a {@code short} after
 * a narrowing primitive conversion.
 *
 * @return The half-precision float value represented by this object
 *         converted to type {@code short}
 * @apiSince 26
 */

public short shortValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of this {@code Half} as a {@code int} after
 * a narrowing primitive conversion.
 *
 * @return The half-precision float value represented by this object
 *         converted to type {@code int}
 * @apiSince 26
 */

public int intValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of this {@code Half} as a {@code long} after
 * a narrowing primitive conversion.
 *
 * @return The half-precision float value represented by this object
 *         converted to type {@code long}
 * @apiSince 26
 */

public long longValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of this {@code Half} as a {@code float} after
 * a widening primitive conversion.
 *
 * @return The half-precision float value represented by this object
 *         converted to type {@code float}
 * @apiSince 26
 */

public float floatValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of this {@code Half} as a {@code double} after
 * a widening primitive conversion.
 *
 * @return The half-precision float value represented by this object
 *         converted to type {@code double}
 * @apiSince 26
 */

public double doubleValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this {@code Half} value represents a Not-a-Number,
 * false otherwise.
 *
 * @return True if the value is a NaN, false otherwise
 * @apiSince 26
 */

public boolean isNaN() { throw new RuntimeException("Stub!"); }

/**
 * Compares this object against the specified object. The result is {@code true}
 * if and only if the argument is not {@code null} and is a {@code Half} object
 * that represents the same half-precision value as the this object. Two
 * half-precision values are considered to be the same if and only if the method
 * {@link #halfToIntBits(short)} returns an identical {@code int} value for both.
 *
 * @param o The object to compare
 * This value may be {@code null}.
 * @return True if the objects are the same, false otherwise
 *
 * @see #halfToIntBits(short)
 * @apiSince 26
 */

public boolean equals(@androidx.annotation.Nullable java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code for this {@code Half} object. The result is the
 * integer bit representation, exactly as produced by the method
 * {@link #halfToIntBits(short)}, of the primitive half-precision float
 * value represented by this {@code Half} object.
 *
 * @return A hash code value for this object
 * @apiSince 26
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of the specified half-precision
 * float value. See {@link #toString(short)} for more information.
 *
 * @return A string representation of this {@code Half} object
 
 * This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * <p>Compares the two specified half-precision float values. The following
 * conditions apply during the comparison:</p>
 *
 * <ul>
 * <li>{@link #NaN} is considered by this method to be equal to itself and greater
 * than all other half-precision float values (including {@code #POSITIVE_INFINITY})</li>
 * <li>{@link #POSITIVE_ZERO} is considered by this method to be greater than
 * {@link #NEGATIVE_ZERO}.</li>
 * </ul>
 *
 * @param h The half-precision float value to compare to the half-precision value
 *          represented by this {@code Half} object
 *
 * This value must never be {@code null}.
 * @return  The value {@code 0} if {@code x} is numerically equal to {@code y}; a
 *          value less than {@code 0} if {@code x} is numerically less than {@code y};
 *          and a value greater than {@code 0} if {@code x} is numerically greater
 *          than {@code y}
 * @apiSince 26
 */

public int compareTo(@androidx.annotation.NonNull android.util.Half h) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code for a half-precision float value.
 *
 * @param h The value to hash
 *
 * @return A hash code value for a half-precision float value
 * @apiSince 26
 */

public static int hashCode(short h) { throw new RuntimeException("Stub!"); }

/**
 * <p>Compares the two specified half-precision float values. The following
 * conditions apply during the comparison:</p>
 *
 * <ul>
 * <li>{@link #NaN} is considered by this method to be equal to itself and greater
 * than all other half-precision float values (including {@code #POSITIVE_INFINITY})</li>
 * <li>{@link #POSITIVE_ZERO} is considered by this method to be greater than
 * {@link #NEGATIVE_ZERO}.</li>
 * </ul>
 *
 * @param x The first half-precision float value to compare.
 * @param y The second half-precision float value to compare
 *
 * @return  The value {@code 0} if {@code x} is numerically equal to {@code y}, a
 *          value less than {@code 0} if {@code x} is numerically less than {@code y},
 *          and a value greater than {@code 0} if {@code x} is numerically greater
 *          than {@code y}
 * @apiSince 26
 */

public static int compare(short x, short y) { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns a representation of the specified half-precision float value
 * according to the bit layout described in {@link android.util.Half Half}.</p>
 *
 * <p>Similar to {@link #halfToIntBits(short)}, this method collapses all
 * possible Not-a-Number values to a single canonical Not-a-Number value
 * defined by {@link #NaN}.</p>
 *
 * @param h A half-precision float value
 * @return The bits that represent the half-precision float value
 *
 * @see #halfToIntBits(short)
 * @apiSince 26
 */

public static short halfToShortBits(short h) { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns a representation of the specified half-precision float value
 * according to the bit layout described in {@link android.util.Half Half}.</p>
 *
 * <p>Unlike {@link #halfToRawIntBits(short)}, this method collapses all
 * possible Not-a-Number values to a single canonical Not-a-Number value
 * defined by {@link #NaN}.</p>
 *
 * @param h A half-precision float value
 * @return The bits that represent the half-precision float value
 *
 * @see #halfToRawIntBits(short)
 * @see #halfToShortBits(short)
 * @see #intBitsToHalf(int)
 * @apiSince 26
 */

public static int halfToIntBits(short h) { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns a representation of the specified half-precision float value
 * according to the bit layout described in {@link android.util.Half Half}.</p>
 *
 * <p>The argument is considered to be a representation of a half-precision
 * float value according to the bit layout described in {@link android.util.Half Half}. The 16
 * most significant bits of the returned value are set to 0.</p>
 *
 * @param h A half-precision float value
 * @return The bits that represent the half-precision float value
 *
 * @see #halfToIntBits(short)
 * @see #intBitsToHalf(int)
 * @apiSince 26
 */

public static int halfToRawIntBits(short h) { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the half-precision float value corresponding to a given
 * bit representation.</p>
 *
 * <p>The argument is considered to be a representation of a half-precision
 * float value according to the bit layout described in {@link android.util.Half Half}. The 16
 * most significant bits of the argument are ignored.</p>
 *
 * @param bits An integer
 * @return The half-precision float value with the same bit pattern
 * @apiSince 26
 */

public static short intBitsToHalf(int bits) { throw new RuntimeException("Stub!"); }

/**
 * Returns the first parameter with the sign of the second parameter.
 * This method treats NaNs as having a sign.
 *
 * @param magnitude A half-precision float value providing the magnitude of the result
 * @param sign  A half-precision float value providing the sign of the result
 * @return A value with the magnitude of the first parameter and the sign
 *         of the second parameter
 * @apiSince 26
 */

public static short copySign(short magnitude, short sign) { throw new RuntimeException("Stub!"); }

/**
 * Returns the absolute value of the specified half-precision float.
 * Special values are handled in the following ways:
 * <ul>
 * <li>If the specified half-precision float is NaN, the result is NaN</li>
 * <li>If the specified half-precision float is zero (negative or positive),
 * the result is positive zero (see {@link #POSITIVE_ZERO})</li>
 * <li>If the specified half-precision float is infinity (negative or positive),
 * the result is positive infinity (see {@link #POSITIVE_INFINITY})</li>
 * </ul>
 *
 * @param h A half-precision float value
 * @return The absolute value of the specified half-precision float
 * @apiSince 26
 */

public static short abs(short h) { throw new RuntimeException("Stub!"); }

/**
 * Returns the closest integral half-precision float value to the specified
 * half-precision float value. Special values are handled in the
 * following ways:
 * <ul>
 * <li>If the specified half-precision float is NaN, the result is NaN</li>
 * <li>If the specified half-precision float is infinity (negative or positive),
 * the result is infinity (with the same sign)</li>
 * <li>If the specified half-precision float is zero (negative or positive),
 * the result is zero (with the same sign)</li>
 * </ul>
 *
 * <p class=note>
 * <strong>Note:</strong> Unlike the identically named
 * <code class=prettyprint>int java.lang.Math.round(float)</code> method,
 * this returns a Half value stored in a short, <strong>not</strong> an
 * actual short integer result.
 *
 * @param h A half-precision float value
 * @return The value of the specified half-precision float rounded to the nearest
 *         half-precision float value
 * @apiSince 26
 */

public static short round(short h) { throw new RuntimeException("Stub!"); }

/**
 * Returns the smallest half-precision float value toward negative infinity
 * greater than or equal to the specified half-precision float value.
 * Special values are handled in the following ways:
 * <ul>
 * <li>If the specified half-precision float is NaN, the result is NaN</li>
 * <li>If the specified half-precision float is infinity (negative or positive),
 * the result is infinity (with the same sign)</li>
 * <li>If the specified half-precision float is zero (negative or positive),
 * the result is zero (with the same sign)</li>
 * </ul>
 *
 * @param h A half-precision float value
 * @return The smallest half-precision float value toward negative infinity
 *         greater than or equal to the specified half-precision float value
 * @apiSince 26
 */

public static short ceil(short h) { throw new RuntimeException("Stub!"); }

/**
 * Returns the largest half-precision float value toward positive infinity
 * less than or equal to the specified half-precision float value.
 * Special values are handled in the following ways:
 * <ul>
 * <li>If the specified half-precision float is NaN, the result is NaN</li>
 * <li>If the specified half-precision float is infinity (negative or positive),
 * the result is infinity (with the same sign)</li>
 * <li>If the specified half-precision float is zero (negative or positive),
 * the result is zero (with the same sign)</li>
 * </ul>
 *
 * @param h A half-precision float value
 * @return The largest half-precision float value toward positive infinity
 *         less than or equal to the specified half-precision float value
 * @apiSince 26
 */

public static short floor(short h) { throw new RuntimeException("Stub!"); }

/**
 * Returns the truncated half-precision float value of the specified
 * half-precision float value. Special values are handled in the following ways:
 * <ul>
 * <li>If the specified half-precision float is NaN, the result is NaN</li>
 * <li>If the specified half-precision float is infinity (negative or positive),
 * the result is infinity (with the same sign)</li>
 * <li>If the specified half-precision float is zero (negative or positive),
 * the result is zero (with the same sign)</li>
 * </ul>
 *
 * @param h A half-precision float value
 * @return The truncated half-precision float value of the specified
 *         half-precision float value
 * @apiSince 26
 */

public static short trunc(short h) { throw new RuntimeException("Stub!"); }

/**
 * Returns the smaller of two half-precision float values (the value closest
 * to negative infinity). Special values are handled in the following ways:
 * <ul>
 * <li>If either value is NaN, the result is NaN</li>
 * <li>{@link #NEGATIVE_ZERO} is smaller than {@link #POSITIVE_ZERO}</li>
 * </ul>
 *
 * @param x The first half-precision value
 * @param y The second half-precision value
 * @return The smaller of the two specified half-precision values
 * @apiSince 26
 */

public static short min(short x, short y) { throw new RuntimeException("Stub!"); }

/**
 * Returns the larger of two half-precision float values (the value closest
 * to positive infinity). Special values are handled in the following ways:
 * <ul>
 * <li>If either value is NaN, the result is NaN</li>
 * <li>{@link #POSITIVE_ZERO} is greater than {@link #NEGATIVE_ZERO}</li>
 * </ul>
 *
 * @param x The first half-precision value
 * @param y The second half-precision value
 *
 * @return The larger of the two specified half-precision values
 * @apiSince 26
 */

public static short max(short x, short y) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the first half-precision float value is less (smaller
 * toward negative infinity) than the second half-precision float value.
 * If either of the values is NaN, the result is false.
 *
 * @param x The first half-precision value
 * @param y The second half-precision value
 *
 * @return True if x is less than y, false otherwise
 * @apiSince 26
 */

public static boolean less(short x, short y) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the first half-precision float value is less (smaller
 * toward negative infinity) than or equal to the second half-precision
 * float value. If either of the values is NaN, the result is false.
 *
 * @param x The first half-precision value
 * @param y The second half-precision value
 *
 * @return True if x is less than or equal to y, false otherwise
 * @apiSince 26
 */

public static boolean lessEquals(short x, short y) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the first half-precision float value is greater (larger
 * toward positive infinity) than the second half-precision float value.
 * If either of the values is NaN, the result is false.
 *
 * @param x The first half-precision value
 * @param y The second half-precision value
 *
 * @return True if x is greater than y, false otherwise
 * @apiSince 26
 */

public static boolean greater(short x, short y) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the first half-precision float value is greater (larger
 * toward positive infinity) than or equal to the second half-precision float
 * value. If either of the values is NaN, the result is false.
 *
 * @param x The first half-precision value
 * @param y The second half-precision value
 *
 * @return True if x is greater than y, false otherwise
 * @apiSince 26
 */

public static boolean greaterEquals(short x, short y) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the two half-precision float values are equal.
 * If either of the values is NaN, the result is false. {@link #POSITIVE_ZERO}
 * and {@link #NEGATIVE_ZERO} are considered equal.
 *
 * @param x The first half-precision value
 * @param y The second half-precision value
 *
 * @return True if x is equal to y, false otherwise
 * @apiSince 26
 */

public static boolean equals(short x, short y) { throw new RuntimeException("Stub!"); }

/**
 * Returns the sign of the specified half-precision float.
 *
 * @param h A half-precision float value
 * @return 1 if the value is positive, -1 if the value is negative
 * @apiSince 26
 */

public static int getSign(short h) { throw new RuntimeException("Stub!"); }

/**
 * Returns the unbiased exponent used in the representation of
 * the specified  half-precision float value. if the value is NaN
 * or infinite, this* method returns {@link #MAX_EXPONENT} + 1.
 * If the argument is 0 or a subnormal representation, this method
 * returns {@link #MIN_EXPONENT} - 1.
 *
 * @param h A half-precision float value
 * @return The unbiased exponent of the specified value
 * @apiSince 26
 */

public static int getExponent(short h) { throw new RuntimeException("Stub!"); }

/**
 * Returns the significand, or mantissa, used in the representation
 * of the specified half-precision float value.
 *
 * @param h A half-precision float value
 * @return The significand, or significand, of the specified vlaue
 * @apiSince 26
 */

public static int getSignificand(short h) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the specified half-precision float value represents
 * infinity, false otherwise.
 *
 * @param h A half-precision float value
 * @return True if the value is positive infinity or negative infinity,
 *         false otherwise
 * @apiSince 26
 */

public static boolean isInfinite(short h) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the specified half-precision float value represents
 * a Not-a-Number, false otherwise.
 *
 * @param h A half-precision float value
 * @return True if the value is a NaN, false otherwise
 * @apiSince 26
 */

public static boolean isNaN(short h) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the specified half-precision float value is normalized
 * (does not have a subnormal representation). If the specified value is
 * {@link #POSITIVE_INFINITY}, {@link #NEGATIVE_INFINITY},
 * {@link #POSITIVE_ZERO}, {@link #NEGATIVE_ZERO}, NaN or any subnormal
 * number, this method returns false.
 *
 * @param h A half-precision float value
 * @return True if the value is normalized, false otherwise
 * @apiSince 26
 */

public static boolean isNormalized(short h) { throw new RuntimeException("Stub!"); }

/**
 * <p>Converts the specified half-precision float value into a
 * single-precision float value. The following special cases are handled:</p>
 * <ul>
 * <li>If the input is {@link #NaN}, the returned value is {@link java.lang.Float#NaN Float#NaN}</li>
 * <li>If the input is {@link #POSITIVE_INFINITY} or
 * {@link #NEGATIVE_INFINITY}, the returned value is respectively
 * {@link java.lang.Float#POSITIVE_INFINITY Float#POSITIVE_INFINITY} or {@link java.lang.Float#NEGATIVE_INFINITY Float#NEGATIVE_INFINITY}</li>
 * <li>If the input is 0 (positive or negative), the returned value is +/-0.0f</li>
 * <li>Otherwise, the returned value is a normalized single-precision float value</li>
 * </ul>
 *
 * @param h The half-precision float value to convert to single-precision
 * @return A normalized single-precision float value
 * @apiSince 26
 */

public static float toFloat(short h) { throw new RuntimeException("Stub!"); }

/**
 * <p>Converts the specified single-precision float value into a
 * half-precision float value. The following special cases are handled:</p>
 * <ul>
 * <li>If the input is NaN (see {@link java.lang.Float#isNaN(float) Float#isNaN(float)}), the returned
 * value is {@link #NaN}</li>
 * <li>If the input is {@link java.lang.Float#POSITIVE_INFINITY Float#POSITIVE_INFINITY} or
 * {@link java.lang.Float#NEGATIVE_INFINITY Float#NEGATIVE_INFINITY}, the returned value is respectively
 * {@link #POSITIVE_INFINITY} or {@link #NEGATIVE_INFINITY}</li>
 * <li>If the input is 0 (positive or negative), the returned value is
 * {@link #POSITIVE_ZERO} or {@link #NEGATIVE_ZERO}</li>
 * <li>If the input is a less than {@link #MIN_VALUE}, the returned value
 * is flushed to {@link #POSITIVE_ZERO} or {@link #NEGATIVE_ZERO}</li>
 * <li>If the input is a less than {@link #MIN_NORMAL}, the returned value
 * is a denorm half-precision float</li>
 * <li>Otherwise, the returned value is rounded to the nearest
 * representable half-precision float value</li>
 * </ul>
 *
 * @param f The single-precision float value to convert to half-precision
 * @return A half-precision float value
 * @apiSince 26
 */

public static short toHalf(float f) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Half} instance representing the specified
 * half-precision float value.
 *
 * @param h A half-precision float value
 * @return a {@code Half} instance representing {@code h}
 
 * This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public static android.util.Half valueOf(short h) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Half} instance representing the specified float value.
 *
 * @param f A float value
 * @return a {@code Half} instance representing {@code f}
 
 * This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public static android.util.Half valueOf(float f) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Half} instance representing the specified string value.
 * Calling this method is equivalent to calling
 * <code>toHalf(Float.parseString(h))</code>. See {@link java.lang.Float#valueOf(java.lang.String) Float#valueOf(String)}
 * for more information on the format of the string representation.
 *
 * @param s The string to be parsed
 * This value must never be {@code null}.
 * @return a {@code Half} instance representing {@code h}
 * This value will never be {@code null}.
 * @throws java.lang.NumberFormatException if the string does not contain a parsable
 *         half-precision float value
 * @apiSince 26
 */

@androidx.annotation.NonNull
public static android.util.Half valueOf(@androidx.annotation.NonNull java.lang.String s) { throw new RuntimeException("Stub!"); }

/**
 * Returns the half-precision float value represented by the specified string.
 * Calling this method is equivalent to calling
 * <code>toHalf(Float.parseString(h))</code>. See {@link java.lang.Float#valueOf(java.lang.String) Float#valueOf(String)}
 * for more information on the format of the string representation.
 *
 * @param s The string to be parsed
 * This value must never be {@code null}.
 * @return A half-precision float value represented by the string
 * @throws java.lang.NumberFormatException if the string does not contain a parsable
 *         half-precision float value
 * @apiSince 26
 */

public static short parseHalf(@androidx.annotation.NonNull java.lang.String s) throws java.lang.NumberFormatException { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of the specified half-precision
 * float value. Calling this method is equivalent to calling
 * <code>Float.toString(toFloat(h))</code>. See {@link java.lang.Float#toString(float) Float#toString(float)}
 * for more information on the format of the string representation.
 *
 * @param h A half-precision float value
 * @return A string representation of the specified value
 
 * This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public static java.lang.String toString(short h) { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns a hexadecimal string representation of the specified half-precision
 * float value. If the value is a NaN, the result is <code>"NaN"</code>,
 * otherwise the result follows this format:</p>
 * <ul>
 * <li>If the sign is positive, no sign character appears in the result</li>
 * <li>If the sign is negative, the first character is <code>'-'</code></li>
 * <li>If the value is inifinity, the string is <code>"Infinity"</code></li>
 * <li>If the value is 0, the string is <code>"0x0.0p0"</code></li>
 * <li>If the value has a normalized representation, the exponent and
 * significand are represented in the string in two fields. The significand
 * starts with <code>"0x1."</code> followed by its lowercase hexadecimal
 * representation. Trailing zeroes are removed unless all digits are 0, then
 * a single zero is used. The significand representation is followed by the
 * exponent, represented by <code>"p"</code>, itself followed by a decimal
 * string of the unbiased exponent</li>
 * <li>If the value has a subnormal representation, the significand starts
 * with <code>"0x0."</code> followed by its lowercase hexadecimal
 * representation. Trailing zeroes are removed unless all digits are 0, then
 * a single zero is used. The significand representation is followed by the
 * exponent, represented by <code>"p-14"</code></li>
 * </ul>
 *
 * @param h A half-precision float value
 * @return A hexadecimal string representation of the specified value
 
 * This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public static java.lang.String toHexString(short h) { throw new RuntimeException("Stub!"); }

/**
 * Epsilon is the difference between 1.0 and the next value representable
 * by a half-precision floating-point.
 * @apiSince 26
 */

public static final short EPSILON = 5120; // 0x1400

/**
 * Smallest negative value a half-precision float may have.
 * @apiSince 26
 */

public static final short LOWEST_VALUE = -1025; // 0xfffffbff

/**
 * Maximum exponent a finite half-precision float may have.
 * @apiSince 26
 */

public static final int MAX_EXPONENT = 15; // 0xf

/**
 * Maximum positive finite value a half-precision float may have.
 * @apiSince 26
 */

public static final short MAX_VALUE = 31743; // 0x7bff

/**
 * Minimum exponent a normalized half-precision float may have.
 * @apiSince 26
 */

public static final int MIN_EXPONENT = -14; // 0xfffffff2

/**
 * Smallest positive normal value a half-precision float may have.
 * @apiSince 26
 */

public static final short MIN_NORMAL = 1024; // 0x400

/**
 * Smallest positive non-zero value a half-precision float may have.
 * @apiSince 26
 */

public static final short MIN_VALUE = 1; // 0x1

/**
 * Negative infinity of type half-precision float.
 * @apiSince 26
 */

public static final short NEGATIVE_INFINITY = -1024; // 0xfffffc00

/**
 * Negative 0 of type half-precision float.
 * @apiSince 26
 */

public static final short NEGATIVE_ZERO = -32768; // 0xffff8000

/**
 * A Not-a-Number representation of a half-precision float.
 * @apiSince 26
 */

public static final short NaN = 32256; // 0x7e00

/**
 * Positive infinity of type half-precision float.
 * @apiSince 26
 */

public static final short POSITIVE_INFINITY = 31744; // 0x7c00

/**
 * Positive 0 of type half-precision float.
 * @apiSince 26
 */

public static final short POSITIVE_ZERO = 0; // 0x0

/**
 * The number of bits used to represent a half-precision float value.
 * @apiSince 26
 */

public static final int SIZE = 16; // 0x10
}

