/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */



package java.math;

import java.util.Random;

/**
 * An immutable arbitrary-precision signed integer.
 *
 * <h3>Fast Cryptography</h3>
 * This implementation is efficient for operations traditionally used in
 * cryptography, such as the generation of large prime numbers and computation
 * of the modular inverse.
 *
 * <h3>Slow Two's Complement Bitwise Operations</h3>
 * This API includes operations for bitwise operations in two's complement
 * representation. Two's complement is not the internal representation used by
 * this implementation, so such methods may be inefficient. Use {@link
 * java.util.BitSet} for high-performance bitwise operations on
 * arbitrarily-large sequences of bits.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class BigInteger extends java.lang.Number implements java.lang.Comparable<java.math.BigInteger>, java.io.Serializable {

/**
 * Constructs a random non-negative {@code BigInteger} instance in the range
 * {@code [0, pow(2, numBits)-1]}.
 *
 * @param numBits maximum length of the new {@code BigInteger} in bits.
 * @param random is the random number generator to be used.
 * @throws java.lang.IllegalArgumentException if {@code numBits} < 0.
 * @apiSince 1
 */

public BigInteger(int numBits, @androidx.annotation.NonNull java.util.Random random) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a random {@code BigInteger} instance in the range {@code [0,
 * pow(2, bitLength)-1]} which is probably prime. The probability that the
 * returned {@code BigInteger} is prime is greater than
 * {@code 1 - 1/2<sup>certainty</sup>)}.
 *
 * <p><b>Note:</b> the {@code Random} argument is ignored if
 * {@code bitLength >= 16}, where this implementation will use OpenSSL's
 * {@code BN_generate_prime_ex} as a source of cryptographically strong pseudo-random numbers.
 *
 * @param bitLength length of the new {@code BigInteger} in bits.
 * @param certainty tolerated primality uncertainty.
 * @throws java.lang.ArithmeticException if {@code bitLength < 2}.
 * @see <a href="http://www.openssl.org/docs/crypto/BN_rand.html">
 *      Specification of random generator used from OpenSSL library</a>
 * @apiSince 1
 */

public BigInteger(int bitLength, int certainty, @androidx.annotation.NonNull java.util.Random random) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new {@code BigInteger} by parsing {@code value}. The string
 * representation consists of an optional plus or minus sign followed by a
 * non-empty sequence of decimal digits. Digits are interpreted as if by
 * {@code Character.digit(char,10)}.
 *
 * @param value string representation of the new {@code BigInteger}.
 * @throws java.lang.NullPointerException if {@code value == null}.
 * @throws java.lang.NumberFormatException if {@code value} is not a valid
 *     representation of a {@code BigInteger}.
 * @apiSince 1
 */

public BigInteger(@androidx.annotation.NonNull java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new {@code BigInteger} instance by parsing {@code value}.
 * The string representation consists of an optional plus or minus sign
 * followed by a non-empty sequence of digits in the specified radix. Digits
 * are interpreted as if by {@code Character.digit(char, radix)}.
 *
 * @param value string representation of the new {@code BigInteger}.
 * @param radix the base to be used for the conversion.
 * @throws java.lang.NullPointerException if {@code value == null}.
 * @throws java.lang.NumberFormatException if {@code value} is not a valid
 *     representation of a {@code BigInteger} or if {@code radix <
 *     Character.MIN_RADIX} or {@code radix > Character.MAX_RADIX}.
 * @apiSince 1
 */

public BigInteger(@androidx.annotation.NonNull java.lang.String value, int radix) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new {@code BigInteger} instance with the given sign and
 * magnitude.
 *
 * @param signum sign of the new {@code BigInteger} (-1 for negative, 0 for
 *     zero, 1 for positive).
 * @param magnitude magnitude of the new {@code BigInteger} with the most
 *     significant byte first.
 * @throws java.lang.NullPointerException if {@code magnitude == null}.
 * @throws java.lang.NumberFormatException if the sign is not one of -1, 0, 1 or if
 *     the sign is zero and the magnitude contains non-zero entries.
 * @apiSince 1
 */

public BigInteger(int signum, byte[] magnitude) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new {@code BigInteger} from the given two's complement
 * representation. The most significant byte is the entry at index 0. The
 * most significant bit of this entry determines the sign of the new {@code
 * BigInteger} instance. The array must be nonempty.
 *
 * @param value two's complement representation of the new {@code
 *     BigInteger}.
 * @throws java.lang.NullPointerException if {@code value == null}.
 * @throws java.lang.NumberFormatException if the length of {@code value} is zero.
 * @apiSince 1
 */

public BigInteger(byte[] value) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code BigInteger} whose value is equal to {@code value}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.math.BigInteger valueOf(long value) { throw new RuntimeException("Stub!"); }

/**
 * Returns the two's complement representation of this {@code BigInteger} in
 * a byte array.
 * @apiSince 1
 */

public byte[] toByteArray() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code BigInteger} whose value is the absolute value of {@code
 * this}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.math.BigInteger abs() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code BigInteger} whose value is the {@code -this}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.math.BigInteger negate() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code BigInteger} whose value is {@code this + value}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.math.BigInteger add(@androidx.annotation.NonNull java.math.BigInteger value) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code BigInteger} whose value is {@code this - value}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.math.BigInteger subtract(@androidx.annotation.NonNull java.math.BigInteger value) { throw new RuntimeException("Stub!"); }

/**
 * Returns the sign of this {@code BigInteger}.
 *
 * @return {@code -1} if {@code this < 0}, {@code 0} if {@code this == 0},
 *     {@code 1} if {@code this > 0}.
 * @apiSince 1
 */

public int signum() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code BigInteger} whose value is {@code this >> n}. For
 * negative arguments, the result is also negative. The shift distance may
 * be negative which means that {@code this} is shifted left.
 *
 * <p><b>Implementation Note:</b> Usage of this method on negative values is
 * not recommended as the current implementation is not efficient.
 *
 * @param n shift distance
 * @return {@code this >> n} if {@code n >= 0}; {@code this << (-n)}
 *     otherwise
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.math.BigInteger shiftRight(int n) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code BigInteger} whose value is {@code this << n}. The
 * result is equivalent to {@code this * pow(2, n)} if n >= 0. The shift
 * distance may be negative which means that {@code this} is shifted right.
 * The result then corresponds to {@code floor(this / pow(2, -n))}.
 *
 * <p><b>Implementation Note:</b> Usage of this method on negative values is
 * not recommended as the current implementation is not efficient.
 *
 * @param n shift distance.
 * @return {@code this << n} if {@code n >= 0}; {@code this >> (-n)}.
 *     otherwise
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.math.BigInteger shiftLeft(int n) { throw new RuntimeException("Stub!"); }

/**
 * Returns the length of the value's two's complement representation without
 * leading zeros for positive numbers / without leading ones for negative
 * values.
 *
 * <p>The two's complement representation of {@code this} will be at least
 * {@code bitLength() + 1} bits long.
 *
 * <p>The value will fit into an {@code int} if {@code bitLength() < 32} or
 * into a {@code long} if {@code bitLength() < 64}.
 *
 * @return the length of the minimal two's complement representation for
 *     {@code this} without the sign bit.
 * @apiSince 1
 */

public int bitLength() { throw new RuntimeException("Stub!"); }

/**
 * Tests whether the bit at position n in {@code this} is set. The result is
 * equivalent to {@code this & pow(2, n) != 0}.
 *
 * <p><b>Implementation Note:</b> Usage of this method is not recommended as
 * the current implementation is not efficient.
 *
 * @param n position where the bit in {@code this} has to be inspected.
 * @throws java.lang.ArithmeticException if {@code n < 0}.
 * @apiSince 1
 */

public boolean testBit(int n) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code BigInteger} which has the same binary representation
 * as {@code this} but with the bit at position n set. The result is
 * equivalent to {@code this | pow(2, n)}.
 *
 * <p><b>Implementation Note:</b> Usage of this method is not recommended as
 * the current implementation is not efficient.
 *
 * @param n position where the bit in {@code this} has to be set.
 * @throws java.lang.ArithmeticException if {@code n < 0}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.math.BigInteger setBit(int n) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code BigInteger} which has the same binary representation
 * as {@code this} but with the bit at position n cleared. The result is
 * equivalent to {@code this & ~pow(2, n)}.
 *
 * <p><b>Implementation Note:</b> Usage of this method is not recommended as
 * the current implementation is not efficient.
 *
 * @param n position where the bit in {@code this} has to be cleared.
 * @throws java.lang.ArithmeticException if {@code n < 0}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.math.BigInteger clearBit(int n) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code BigInteger} which has the same binary representation
 * as {@code this} but with the bit at position n flipped. The result is
 * equivalent to {@code this ^ pow(2, n)}.
 *
 * <p><b>Implementation Note:</b> Usage of this method is not recommended as
 * the current implementation is not efficient.
 *
 * @param n position where the bit in {@code this} has to be flipped.
 * @throws java.lang.ArithmeticException if {@code n < 0}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.math.BigInteger flipBit(int n) { throw new RuntimeException("Stub!"); }

/**
 * Returns the position of the lowest set bit in the two's complement
 * representation of this {@code BigInteger}. If all bits are zero (this==0)
 * then -1 is returned as result.
 *
 * <p><b>Implementation Note:</b> Usage of this method is not recommended as
 * the current implementation is not efficient.
 * @apiSince 1
 */

public int getLowestSetBit() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of bits in the two's complement representation of
 * {@code this} which differ from the sign bit. If {@code this} is negative,
 * the result is equivalent to the number of bits set in the two's
 * complement representation of {@code -this - 1}.
 *
 * <p>Use {@code bitLength(0)} to find the length of the binary value in
 * bits.
 *
 * <p><b>Implementation Note:</b> Usage of this method is not recommended as
 * the current implementation is not efficient.
 * @apiSince 1
 */

public int bitCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code BigInteger} whose value is {@code ~this}. The result
 * of this operation is {@code -this-1}.
 *
 * <p><b>Implementation Note:</b> Usage of this method is not recommended as
 * the current implementation is not efficient.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.math.BigInteger not() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code BigInteger} whose value is {@code this & value}.
 *
 * <p><b>Implementation Note:</b> Usage of this method is not recommended
 * as the current implementation is not efficient.
 *
 * @param value value to be and'ed with {@code this}.
 * @throws java.lang.NullPointerException if {@code value == null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.math.BigInteger and(@androidx.annotation.NonNull java.math.BigInteger value) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code BigInteger} whose value is {@code this | value}.
 *
 * <p><b>Implementation Note:</b> Usage of this method is not recommended as
 * the current implementation is not efficient.
 *
 * @param value value to be or'ed with {@code this}.
 * @throws java.lang.NullPointerException if {@code value == null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.math.BigInteger or(@androidx.annotation.NonNull java.math.BigInteger value) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code BigInteger} whose value is {@code this ^ value}.
 *
 * <p><b>Implementation Note:</b> Usage of this method is not recommended as
 * the current implementation is not efficient.
 *
 * @param value value to be xor'ed with {@code this}
 * @throws java.lang.NullPointerException if {@code value == null}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.math.BigInteger xor(@androidx.annotation.NonNull java.math.BigInteger value) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code BigInteger} whose value is {@code this & ~value}.
 * Evaluating {@code x.andNot(value)} returns the same result as {@code
 * x.and(value.not())}.
 *
 * <p><b>Implementation Note:</b> Usage of this method is not recommended
 * as the current implementation is not efficient.
 *
 * @param value value to be not'ed and then and'ed with {@code this}.
 * @throws java.lang.NullPointerException if {@code value == null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.math.BigInteger andNot(@androidx.annotation.NonNull java.math.BigInteger value) { throw new RuntimeException("Stub!"); }

/**
 * Returns this {@code BigInteger} as an int value. If {@code this} is too
 * big to be represented as an int, then {@code this % (1 << 32)} is
 * returned.
 * @apiSince 1
 */

public int intValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns this {@code BigInteger} as a long value. If {@code this} is too
 * big to be represented as a long, then {@code this % pow(2, 64)} is
 * returned.
 * @apiSince 1
 */

public long longValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns this {@code BigInteger} as a float. If {@code this} is too big to
 * be represented as a float, then {@code Float.POSITIVE_INFINITY} or
 * {@code Float.NEGATIVE_INFINITY} is returned. Note that not all integers
 * in the range {@code [-Float.MAX_VALUE, Float.MAX_VALUE]} can be exactly
 * represented as a float.
 * @apiSince 1
 */

public float floatValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns this {@code BigInteger} as a double. If {@code this} is too big
 * to be represented as a double, then {@code Double.POSITIVE_INFINITY} or
 * {@code Double.NEGATIVE_INFINITY} is returned. Note that not all integers
 * in the range {@code [-Double.MAX_VALUE, Double.MAX_VALUE]} can be exactly
 * represented as a double.
 * @apiSince 1
 */

public double doubleValue() { throw new RuntimeException("Stub!"); }

/**
 * Compares this {@code BigInteger} with {@code value}. Returns {@code -1}
 * if {@code this < value}, {@code 0} if {@code this == value} and {@code 1}
 * if {@code this > value}, .
 *
 * @param value value to be compared with {@code this}.
 * @throws java.lang.NullPointerException if {@code value == null}.
 * @apiSince 1
 */

public int compareTo(@androidx.annotation.NonNull java.math.BigInteger value) { throw new RuntimeException("Stub!"); }

/**
 * Returns the minimum of this {@code BigInteger} and {@code value}.
 *
 * @param value value to be used to compute the minimum with {@code this}.
 * @throws java.lang.NullPointerException if {@code value == null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.math.BigInteger min(@androidx.annotation.NonNull java.math.BigInteger value) { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum of this {@code BigInteger} and {@code value}.
 *
 * @param value value to be used to compute the maximum with {@code this}
 * @throws java.lang.NullPointerException if {@code value == null}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.math.BigInteger max(@androidx.annotation.NonNull java.math.BigInteger value) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean equals(@androidx.annotation.Nullable java.lang.Object x) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of this {@code BigInteger} in decimal
 * form.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string containing a string representation of this {@code
 * BigInteger} with base radix. If {@code radix < Character.MIN_RADIX} or
 * {@code radix > Character.MAX_RADIX} then a decimal representation is
 * returned. The characters of the string representation are generated with
 * method {@code Character.forDigit}.
 *
 * @param radix base to be used for the string representation.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String toString(int radix) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code BigInteger} whose value is greatest common divisor
 * of {@code this} and {@code value}. If {@code this == 0} and {@code
 * value == 0} then zero is returned, otherwise the result is positive.
 *
 * @param value value with which the greatest common divisor is computed.
 * @throws java.lang.NullPointerException if {@code value == null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.math.BigInteger gcd(@androidx.annotation.NonNull java.math.BigInteger value) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code BigInteger} whose value is {@code this * value}.
 *
 * @throws java.lang.NullPointerException if {@code value == null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.math.BigInteger multiply(@androidx.annotation.NonNull java.math.BigInteger value) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code BigInteger} whose value is {@code pow(this, exp)}.
 *
 * @throws java.lang.ArithmeticException if {@code exp < 0}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.math.BigInteger pow(int exp) { throw new RuntimeException("Stub!"); }

/**
 * Returns a two element {@code BigInteger} array containing
 * {@code this / divisor} at index 0 and {@code this % divisor} at index 1.
 *
 * @param divisor value by which {@code this} is divided.
 * @throws java.lang.NullPointerException if {@code divisor == null}.
 * @throws java.lang.ArithmeticException if {@code divisor == 0}.
 * @see #divide
 * @see #remainder
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.math.BigInteger[] divideAndRemainder(@androidx.annotation.NonNull java.math.BigInteger divisor) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code BigInteger} whose value is {@code this / divisor}.
 *
 * @param divisor value by which {@code this} is divided.
 * @return {@code this / divisor}.
 * @throws java.lang.NullPointerException if {@code divisor == null}.
 * @throws java.lang.ArithmeticException if {@code divisor == 0}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.math.BigInteger divide(@androidx.annotation.NonNull java.math.BigInteger divisor) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code BigInteger} whose value is {@code this % divisor}.
 * Regarding signs this methods has the same behavior as the % operator on
 * ints: the sign of the remainder is the same as the sign of this.
 *
 * @param divisor value by which {@code this} is divided.
 * @throws java.lang.NullPointerException if {@code divisor == null}.
 * @throws java.lang.ArithmeticException if {@code divisor == 0}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.math.BigInteger remainder(@androidx.annotation.NonNull java.math.BigInteger divisor) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code BigInteger} whose value is {@code 1/this mod m}. The
 * modulus {@code m} must be positive. The result is guaranteed to be in the
 * interval {@code [0, m)} (0 inclusive, m exclusive). If {@code this} is
 * not relatively prime to m, then an exception is thrown.
 *
 * @param m the modulus.
 * @throws java.lang.NullPointerException if {@code m == null}
 * @throws java.lang.ArithmeticException if {@code m < 0 or} if {@code this} is not
 *     relatively prime to {@code m}
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.math.BigInteger modInverse(@androidx.annotation.NonNull java.math.BigInteger m) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code BigInteger} whose value is {@code
 * pow(this, exponent) mod modulus}. The modulus must be positive. The
 * result is guaranteed to be in the interval {@code [0, modulus)}.
 * If the exponent is negative, then
 * {@code pow(this.modInverse(modulus), -exponent) mod modulus} is computed.
 * The inverse of this only exists if {@code this} is relatively prime to the modulus,
 * otherwise an exception is thrown.
 *
 * @throws java.lang.NullPointerException if {@code modulus == null} or {@code exponent == null}.
 * @throws java.lang.ArithmeticException if {@code modulus < 0} or if {@code exponent < 0} and
 *     not relatively prime to {@code modulus}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.math.BigInteger modPow(@androidx.annotation.NonNull java.math.BigInteger exponent, @androidx.annotation.NonNull java.math.BigInteger modulus) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code BigInteger} whose value is {@code this mod m}. The
 * modulus {@code m} must be positive. The result is guaranteed to be in the
 * interval {@code [0, m)} (0 inclusive, m exclusive). The behavior of this
 * function is not equivalent to the behavior of the % operator defined for
 * the built-in {@code int}'s.
 *
 * @param m the modulus.
 * @return {@code this mod m}.
 * @throws java.lang.NullPointerException if {@code m == null}.
 * @throws java.lang.ArithmeticException if {@code m < 0}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.math.BigInteger mod(@androidx.annotation.NonNull java.math.BigInteger m) { throw new RuntimeException("Stub!"); }

/**
 * Tests whether this {@code BigInteger} is probably prime. If {@code true}
 * is returned, then this is prime with a probability greater than
 * {@code 1 - 1/2<sup>certainty</sup>)}. If {@code false} is returned, then this
 * is definitely composite. If the argument {@code certainty} <= 0, then
 * this method returns true.
 *
 * @param certainty tolerated primality uncertainty.
 * @return {@code true}, if {@code this} is probably prime, {@code false}
 *     otherwise.
 * @apiSince 1
 */

public boolean isProbablePrime(int certainty) { throw new RuntimeException("Stub!"); }

/**
 * Returns the smallest integer x > {@code this} which is probably prime as
 * a {@code BigInteger} instance. The probability that the returned {@code
 * BigInteger} is prime is greater than {@code 1 - 1/2<sup>100</sup>}.
 *
 * @return smallest integer > {@code this} which is probably prime.
 * @throws java.lang.ArithmeticException if {@code this < 0}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.math.BigInteger nextProbablePrime() { throw new RuntimeException("Stub!"); }

/**
 * Returns a random positive {@code BigInteger} instance in the range {@code
 * [0, pow(2, bitLength)-1]} which is probably prime. The probability that
 * the returned {@code BigInteger} is prime is greater than {@code 1 - 1/2<sup>100</sup>)}.
 *
 * @param bitLength length of the new {@code BigInteger} in bits.
 * @return probably prime random {@code BigInteger} instance.
 * @throws java.lang.IllegalArgumentException if {@code bitLength < 2}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.math.BigInteger probablePrime(int bitLength, @androidx.annotation.NonNull java.util.Random random) { throw new RuntimeException("Stub!"); }

/**
 * The {@code BigInteger} constant 1.
 * @apiSince 1
 */

@androidx.annotation.NonNull public static final java.math.BigInteger ONE;
static { ONE = null; }

/**
 * The {@code BigInteger} constant 10.
 * @apiSince 1
 */

@androidx.annotation.NonNull public static final java.math.BigInteger TEN;
static { TEN = null; }

/**
 * The {@code BigInteger} constant 0.
 * @apiSince 1
 */

@androidx.annotation.NonNull public static final java.math.BigInteger ZERO;
static { ZERO = null; }
}

