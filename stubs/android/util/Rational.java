/*
 * Copyright (C) 2013 The Android Open Source Project
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
 * <p>An immutable data type representation a rational number.</p>
 *
 * <p>Contains a pair of {@code int}s representing the numerator and denominator of a
 * Rational number. </p>
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Rational extends java.lang.Number implements java.lang.Comparable<android.util.Rational> {

/**
 * <p>Create a {@code Rational} with a given numerator and denominator.</p>
 *
 * <p>The signs of the numerator and the denominator may be flipped such that the denominator
 * is always positive. Both the numerator and denominator will be converted to their reduced
 * forms (see {@link #equals} for more details).</p>
 *
 * <p>For example,
 * <ul>
 * <li>a rational of {@code 2/4} will be reduced to {@code 1/2}.
 * <li>a rational of {@code 1/-1} will be flipped to {@code -1/1}
 * <li>a rational of {@code 5/0} will be reduced to {@code 1/0}
 * <li>a rational of {@code 0/5} will be reduced to {@code 0/1}
 * </ul>
 * </p>
 *
 * @param numerator the numerator of the rational
 * @param denominator the denominator of the rational
 *
 * @see #equals
 * @apiSince 21
 */

public Rational(int numerator, int denominator) { throw new RuntimeException("Stub!"); }

/**
 * Gets the numerator of the rational.
 *
 * <p>The numerator will always return {@code 1} if this rational represents
 * infinity (that is, the denominator is {@code 0}).</p>
 * @apiSince 21
 */

public int getNumerator() { throw new RuntimeException("Stub!"); }

/**
 * Gets the denominator of the rational
 *
 * <p>The denominator may return {@code 0}, in which case the rational may represent
 * positive infinity (if the numerator was positive), negative infinity (if the numerator
 * was negative), or {@code NaN} (if the numerator was {@code 0}).</p>
 *
 * <p>The denominator will always return {@code 1} if the numerator is {@code 0}.
 * @apiSince 21
 */

public int getDenominator() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether this rational is a <em>Not-a-Number (NaN)</em> value.
 *
 * <p>A {@code NaN} value occurs when both the numerator and the denominator are {@code 0}.</p>
 *
 * @return {@code true} if this rational is a <em>Not-a-Number (NaN)</em> value;
 *         {@code false} if this is a (potentially infinite) number value
 * @apiSince 21
 */

public boolean isNaN() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether this rational represents an infinite value.
 *
 * <p>An infinite value occurs when the denominator is {@code 0} (but the numerator is not).</p>
 *
 * @return {@code true} if this rational is a (positive or negative) infinite value;
 *         {@code false} if this is a finite number value (or {@code NaN})
 * @apiSince 21
 */

public boolean isInfinite() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether this rational represents a finite value.
 *
 * <p>A finite value occurs when the denominator is not {@code 0}; in other words
 * the rational is neither infinity or {@code NaN}.</p>
 *
 * @return {@code true} if this rational is a (positive or negative) infinite value;
 *         {@code false} if this is a finite number value (or {@code NaN})
 * @apiSince 21
 */

public boolean isFinite() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether this rational represents a zero value.
 *
 * <p>A zero value is a {@link #isFinite finite} rational with a numerator of {@code 0}.</p>
 *
 * @return {@code true} if this rational is finite zero value;
 *         {@code false} otherwise
 * @apiSince 21
 */

public boolean isZero() { throw new RuntimeException("Stub!"); }

/**
 * <p>Compare this Rational to another object and see if they are equal.</p>
 *
 * <p>A Rational object can only be equal to another Rational object (comparing against any
 * other type will return {@code false}).</p>
 *
 * <p>A Rational object is considered equal to another Rational object if and only if one of
 * the following holds:</p>
 * <ul><li>Both are {@code NaN}</li>
 *     <li>Both are infinities of the same sign</li>
 *     <li>Both have the same numerator and denominator in their reduced form</li>
 * </ul>
 *
 * <p>A reduced form of a Rational is calculated by dividing both the numerator and the
 * denominator by their greatest common divisor.</p>
 *
 * <pre>{@code
 * (new Rational(1, 2)).equals(new Rational(1, 2)) == true   // trivially true
 * (new Rational(2, 3)).equals(new Rational(1, 2)) == false  // trivially false
 * (new Rational(1, 2)).equals(new Rational(2, 4)) == true   // true after reduction
 * (new Rational(0, 0)).equals(new Rational(0, 0)) == true   // NaN.equals(NaN)
 * (new Rational(1, 0)).equals(new Rational(5, 0)) == true   // both are +infinity
 * (new Rational(1, 0)).equals(new Rational(-1, 0)) == false // +infinity != -infinity
 * }</pre>
 *
 * @param obj a reference to another object
 *
 * @return A boolean that determines whether or not the two Rational objects are equal.
 * @apiSince 21
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Return a string representation of this rational, e.g.&nbsp;{@code "1/2"}.
 *
 * <p>The following rules of conversion apply:
 * <ul>
 * <li>{@code NaN} values will return {@code "NaN"}
 * <li>Positive infinity values will return {@code "Infinity"}
 * <li>Negative infinity values will return {@code "-Infinity"}
 * <li>All other values will return {@code "numerator/denominator"} where {@code numerator}
 * and {@code denominator} are substituted with the appropriate numerator and denominator
 * values.
 * </ul></p>
 * @apiSince 21
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 21
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of the specified number as a {@code double}.
 *
 * <p>The {@code double} is calculated by converting both the numerator and denominator
 * to a {@code double}; then returning the result of dividing the numerator by the
 * denominator.</p>
 *
 * @return the divided value of the numerator and denominator as a {@code double}.
 * @apiSince 21
 */

public double doubleValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of the specified number as a {@code float}.
 *
 * <p>The {@code float} is calculated by converting both the numerator and denominator
 * to a {@code float}; then returning the result of dividing the numerator by the
 * denominator.</p>
 *
 * @return the divided value of the numerator and denominator as a {@code float}.
 * @apiSince 21
 */

public float floatValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of the specified number as a {@code int}.
 *
 * <p>{@link #isInfinite Finite} rationals are converted to an {@code int} value
 * by dividing the numerator by the denominator; conversion for non-finite values happens
 * identically to casting a floating point value to an {@code int}, in particular:
 *
 * <p>
 * <ul>
 * <li>Positive infinity saturates to the largest maximum integer
 * {@link java.lang.Integer#MAX_VALUE Integer#MAX_VALUE}</li>
 * <li>Negative infinity saturates to the smallest maximum integer
 * {@link java.lang.Integer#MIN_VALUE Integer#MIN_VALUE}</li>
 * <li><em>Not-A-Number (NaN)</em> returns {@code 0}.</li>
 * </ul>
 * </p>
 *
 * @return the divided value of the numerator and denominator as a {@code int}.
 * @apiSince 21
 */

public int intValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of the specified number as a {@code long}.
 *
 * <p>{@link #isInfinite Finite} rationals are converted to an {@code long} value
 * by dividing the numerator by the denominator; conversion for non-finite values happens
 * identically to casting a floating point value to a {@code long}, in particular:
 *
 * <p>
 * <ul>
 * <li>Positive infinity saturates to the largest maximum long
 * {@link java.lang.Long#MAX_VALUE Long#MAX_VALUE}</li>
 * <li>Negative infinity saturates to the smallest maximum long
 * {@link java.lang.Long#MIN_VALUE Long#MIN_VALUE}</li>
 * <li><em>Not-A-Number (NaN)</em> returns {@code 0}.</li>
 * </ul>
 * </p>
 *
 * @return the divided value of the numerator and denominator as a {@code long}.
 * @apiSince 21
 */

public long longValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of the specified number as a {@code short}.
 *
 * <p>{@link #isInfinite Finite} rationals are converted to a {@code short} value
 * identically to {@link #intValue}; the {@code int} result is then truncated to a
 * {@code short} before returning the value.</p>
 *
 * @return the divided value of the numerator and denominator as a {@code short}.
 * @apiSince 21
 */

public short shortValue() { throw new RuntimeException("Stub!"); }

/**
 * Compare this rational to the specified rational to determine their natural order.
 *
 * <p>{@link #NaN} is considered to be equal to itself and greater than all other
 * {@code Rational} values. Otherwise, if the objects are not {@link #equals equal}, then
 * the following rules apply:</p>
 *
 * <ul>
 * <li>Positive infinity is greater than any other finite number (or negative infinity)
 * <li>Negative infinity is less than any other finite number (or positive infinity)
 * <li>The finite number represented by this rational is checked numerically
 * against the other finite number by converting both rationals to a common denominator multiple
 * and comparing their numerators.
 * </ul>
 *
 * @param another the rational to be compared
 *
 * @return a negative integer, zero, or a positive integer as this object is less than,
 *         equal to, or greater than the specified rational.
 *
 * @throws java.lang.NullPointerException if {@code another} was {@code null}
 * @apiSince 21
 */

public int compareTo(android.util.Rational another) { throw new RuntimeException("Stub!"); }

/**
 * Parses the specified string as a rational value.
 * <p>The ASCII characters {@code \}{@code u003a} (':') and
 * {@code \}{@code u002f} ('/') are recognized as separators between
 * the numerator and denumerator.</p>
 * <p>
 * For any {@code Rational r}: {@code Rational.parseRational(r.toString()).equals(r)}.
 * However, the method also handles rational numbers expressed in the
 * following forms:</p>
 * <p>
 * "<i>num</i>{@code /}<i>den</i>" or
 * "<i>num</i>{@code :}<i>den</i>" {@code => new Rational(num, den);},
 * where <i>num</i> and <i>den</i> are string integers potentially
 * containing a sign, such as "-10", "+7" or "5".</p>
 *
 * <pre>{@code
 * Rational.parseRational("3:+6").equals(new Rational(1, 2)) == true
 * Rational.parseRational("-3/-6").equals(new Rational(1, 2)) == true
 * Rational.parseRational("4.56") => throws NumberFormatException
 * }</pre>
 *
 * @param string the string representation of a rational value.
 * @return the rational value represented by {@code string}.
 *
 * @throws java.lang.NumberFormatException if {@code string} cannot be parsed
 * as a rational value.
 * @throws java.lang.NullPointerException if {@code string} was {@code null}
 * @apiSince 21
 */

public static android.util.Rational parseRational(java.lang.String string) throws java.lang.NumberFormatException { throw new RuntimeException("Stub!"); }

/**
 * Constant for the negative infinity value of the {@code Rational} type.
 *
 * <p>Equivalent to constructing a new rational with a negative numerator and a denominator
 * equal to {@code 0}.</p>
 * @apiSince 21
 */

public static final android.util.Rational NEGATIVE_INFINITY;
static { NEGATIVE_INFINITY = null; }

/**
 * Constant for the <em>Not-a-Number (NaN)</em> value of the {@code Rational} type.
 *
 * <p>A {@code NaN} value is considered to be equal to itself (that is {@code NaN.equals(NaN)}
 * will return {@code true}; it is always greater than any non-{@code NaN} value (that is
 * {@code NaN.compareTo(notNaN)} will return a number greater than {@code 0}).</p>
 *
 * <p>Equivalent to constructing a new rational with both the numerator and denominator
 * equal to {@code 0}.</p>
 * @apiSince 21
 */

public static final android.util.Rational NaN;
static { NaN = null; }

/**
 * Constant for the positive infinity value of the {@code Rational} type.
 *
 * <p>Equivalent to constructing a new rational with a positive numerator and a denominator
 * equal to {@code 0}.</p>
 * @apiSince 21
 */

public static final android.util.Rational POSITIVE_INFINITY;
static { POSITIVE_INFINITY = null; }

/**
 * Constant for the zero value of the {@code Rational} type.
 *
 * <p>Equivalent to constructing a new rational with a numerator equal to {@code 0} and
 * any non-zero denominator.</p>
 * @apiSince 21
 */

public static final android.util.Rational ZERO;
static { ZERO = null; }
}

