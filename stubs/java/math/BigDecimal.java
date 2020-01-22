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


/**
 * An immutable arbitrary-precision signed decimal.
 *
 * <p>A value is represented by an arbitrary-precision "unscaled value" and a signed 32-bit "scale",
 * combined thus: {@code unscaled * 10<sup>-scale</sup>}. See {@link #unscaledValue} and {@link #scale}.
 *
 * <p>Most operations allow you to supply a {@link java.math.MathContext MathContext} to specify a desired rounding mode.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class BigDecimal extends java.lang.Number implements java.lang.Comparable<java.math.BigDecimal>, java.io.Serializable {

/**
 * Constructs a new {@code BigDecimal} instance from a string representation
 * given as a character array.
 *
 * @param in
 *            array of characters containing the string representation of
 *            this {@code BigDecimal}.
 * @param offset
 *            first index to be copied.
 * @param len
 *            number of characters to be used.
 * @throws java.lang.NumberFormatException
 *             if {@code offset < 0 || len <= 0 || offset+len-1 < 0 ||
 *             offset+len-1 >= in.length}, or if {@code in} does not
 *             contain a valid string representation of a big decimal.
 * @apiSince 1
 */

public BigDecimal(char[] in, int offset, int len) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new {@code BigDecimal} instance from a string representation
 * given as a character array.
 *
 * @param in
 *            array of characters containing the string representation of
 *            this {@code BigDecimal}.
 * @param offset
 *            first index to be copied.
 * @param len
 *            number of characters to be used.
 * @param mc
 *            rounding mode and precision for the result of this operation.
 * @throws java.lang.NumberFormatException
 *             if {@code offset < 0 || len <= 0 || offset+len-1 < 0 ||
 *             offset+len-1 >= in.length}, or if {@code in} does not
 *             contain a valid string representation of a big decimal.
 * @throws java.lang.ArithmeticException
 *             if {@code mc.precision > 0} and {@code mc.roundingMode ==
 *             UNNECESSARY} and the new big decimal cannot be represented
 *             within the given precision without rounding.
 * @apiSince 1
 */

public BigDecimal(char[] in, int offset, int len, java.math.MathContext mc) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new {@code BigDecimal} instance from a string representation
 * given as a character array.
 *
 * @param in
 *            array of characters containing the string representation of
 *            this {@code BigDecimal}.
 * @throws java.lang.NumberFormatException
 *             if {@code in} does not contain a valid string representation
 *             of a big decimal.
 * @apiSince 1
 */

public BigDecimal(char[] in) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new {@code BigDecimal} instance from a string representation
 * given as a character array. The result is rounded according to the
 * specified math context.
 *
 * @param in
 *            array of characters containing the string representation of
 *            this {@code BigDecimal}.
 * @param mc
 *            rounding mode and precision for the result of this operation.
 * @throws java.lang.NumberFormatException
 *             if {@code in} does not contain a valid string representation
 *             of a big decimal.
 * @throws java.lang.ArithmeticException
 *             if {@code mc.precision > 0} and {@code mc.roundingMode ==
 *             UNNECESSARY} and the new big decimal cannot be represented
 *             within the given precision without rounding.
 * @apiSince 1
 */

public BigDecimal(char[] in, java.math.MathContext mc) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new {@code BigDecimal} instance from a string
 * representation.
 *
 * @throws java.lang.NumberFormatException
 *             if {@code val} does not contain a valid string representation
 *             of a big decimal.
 * @apiSince 1
 */

public BigDecimal(java.lang.String val) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new {@code BigDecimal} instance from a string
 * representation. The result is rounded according to the specified math
 * context.
 *
 * @param mc
 *            rounding mode and precision for the result of this operation.
 * @throws java.lang.NumberFormatException
 *             if {@code val} does not contain a valid string representation
 *             of a big decimal.
 * @throws java.lang.ArithmeticException
 *             if {@code mc.precision > 0} and {@code mc.roundingMode ==
 *             UNNECESSARY} and the new big decimal cannot be represented
 *             within the given precision without rounding.
 * @apiSince 1
 */

public BigDecimal(java.lang.String val, java.math.MathContext mc) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new {@code BigDecimal} instance from the 64bit double
 * {@code val}. The constructed big decimal is equivalent to the given
 * double. For example, {@code new BigDecimal(0.1)} is equal to {@code
 * 0.1000000000000000055511151231257827021181583404541015625}. This happens
 * as {@code 0.1} cannot be represented exactly in binary.
 * <p>
 * To generate a big decimal instance which is equivalent to {@code 0.1} use
 * the {@code BigDecimal(String)} constructor.
 *
 * @param val
 *            double value to be converted to a {@code BigDecimal} instance.
 * @throws java.lang.NumberFormatException
 *             if {@code val} is infinity or not a number.
 * @apiSince 1
 */

public BigDecimal(double val) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new {@code BigDecimal} instance from the 64bit double
 * {@code val}. The constructed big decimal is equivalent to the given
 * double. For example, {@code new BigDecimal(0.1)} is equal to {@code
 * 0.1000000000000000055511151231257827021181583404541015625}. This happens
 * as {@code 0.1} cannot be represented exactly in binary.
 * <p>
 * To generate a big decimal instance which is equivalent to {@code 0.1} use
 * the {@code BigDecimal(String)} constructor.
 *
 * @param val
 *            double value to be converted to a {@code BigDecimal} instance.
 * @param mc
 *            rounding mode and precision for the result of this operation.
 * @throws java.lang.NumberFormatException
 *             if {@code val} is infinity or not a number.
 * @throws java.lang.ArithmeticException
 *             if {@code mc.precision > 0} and {@code mc.roundingMode ==
 *             UNNECESSARY} and the new big decimal cannot be represented
 *             within the given precision without rounding.
 * @apiSince 1
 */

public BigDecimal(double val, java.math.MathContext mc) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new {@code BigDecimal} instance from the given big integer
 * {@code val}. The scale of the result is {@code 0}.
 * @apiSince 1
 */

public BigDecimal(java.math.BigInteger val) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new {@code BigDecimal} instance from the given big integer
 * {@code val}. The scale of the result is {@code 0}.
 *
 * @param mc
 *            rounding mode and precision for the result of this operation.
 * @throws java.lang.ArithmeticException
 *             if {@code mc.precision > 0} and {@code mc.roundingMode ==
 *             UNNECESSARY} and the new big decimal cannot be represented
 *             within the given precision without rounding.
 * @apiSince 1
 */

public BigDecimal(java.math.BigInteger val, java.math.MathContext mc) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new {@code BigDecimal} instance from a given unscaled value
 * {@code unscaledVal} and a given scale. The value of this instance is
 * {@code unscaledVal * 10<sup>-scale</sup>}).
 *
 * @throws java.lang.NullPointerException
 *             if {@code unscaledVal == null}.
 * @apiSince 1
 */

public BigDecimal(java.math.BigInteger unscaledVal, int scale) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new {@code BigDecimal} instance from a given unscaled value
 * {@code unscaledVal} and a given scale. The value of this instance is
 * {@code unscaledVal * 10<sup>-scale</sup>). The result is rounded according
 * to the specified math context.
 *
 * @param mc
 *            rounding mode and precision for the result of this operation.
 * @throws ArithmeticException
 *             if {@code mc.precision > 0} and {@code mc.roundingMode ==
 *             UNNECESSARY} and the new big decimal cannot be represented
 *             within the given precision without rounding.
 * @throws NullPointerException
 *             if {@code unscaledVal == null}.
 * @apiSince 1
 */

public BigDecimal(java.math.BigInteger unscaledVal, int scale, java.math.MathContext mc) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new {@code BigDecimal} instance from the given int
 * {@code val}. The scale of the result is 0.
 *
 * @param val
 *            int value to be converted to a {@code BigDecimal} instance.
 * @apiSince 1
 */

public BigDecimal(int val) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new {@code BigDecimal} instance from the given int {@code
 * val}. The scale of the result is {@code 0}. The result is rounded
 * according to the specified math context.
 *
 * @param val
 *            int value to be converted to a {@code BigDecimal} instance.
 * @param mc
 *            rounding mode and precision for the result of this operation.
 * @throws java.lang.ArithmeticException
 *             if {@code mc.precision > 0} and {@code c.roundingMode ==
 *             UNNECESSARY} and the new big decimal cannot be represented
 *             within the given precision without rounding.
 * @apiSince 1
 */

public BigDecimal(int val, java.math.MathContext mc) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new {@code BigDecimal} instance from the given long {@code
 * val}. The scale of the result is {@code 0}.
 *
 * @param val
 *            long value to be converted to a {@code BigDecimal} instance.
 * @apiSince 1
 */

public BigDecimal(long val) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new {@code BigDecimal} instance from the given long {@code
 * val}. The scale of the result is {@code 0}. The result is rounded
 * according to the specified math context.
 *
 * @param val
 *            long value to be converted to a {@code BigDecimal} instance.
 * @param mc
 *            rounding mode and precision for the result of this operation.
 * @throws java.lang.ArithmeticException
 *             if {@code mc.precision > 0} and {@code mc.roundingMode ==
 *             UNNECESSARY} and the new big decimal cannot be represented
 *             within the given precision without rounding.
 * @apiSince 1
 */

public BigDecimal(long val, java.math.MathContext mc) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code BigDecimal} instance whose value is equal to {@code
 * unscaledVal * 10<sup>-scale</sup>}). The scale of the result is {@code
 * scale}, and its unscaled value is {@code unscaledVal}.
 * @apiSince 1
 */

public static java.math.BigDecimal valueOf(long unscaledVal, int scale) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code BigDecimal} instance whose value is equal to {@code
 * unscaledVal}. The scale of the result is {@code 0}, and its unscaled
 * value is {@code unscaledVal}.
 *
 * @param unscaledVal
 *            value to be converted to a {@code BigDecimal}.
 * @return {@code BigDecimal} instance with the value {@code unscaledVal}.
 * @apiSince 1
 */

public static java.math.BigDecimal valueOf(long unscaledVal) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code BigDecimal} instance whose value is equal to {@code
 * val}. The new decimal is constructed as if the {@code BigDecimal(String)}
 * constructor is called with an argument which is equal to {@code
 * Double.toString(val)}. For example, {@code valueOf("0.1")} is converted to
 * (unscaled=1, scale=1), although the double {@code 0.1} cannot be
 * represented exactly as a double value. In contrast to that, a new {@code
 * BigDecimal(0.1)} instance has the value {@code
 * 0.1000000000000000055511151231257827021181583404541015625} with an
 * unscaled value {@code 1000000000000000055511151231257827021181583404541015625}
 * and the scale {@code 55}.
 *
 * @param val
 *            double value to be converted to a {@code BigDecimal}.
 * @return {@code BigDecimal} instance with the value {@code val}.
 * @throws java.lang.NumberFormatException
 *             if {@code val} is infinite or {@code val} is not a number
 * @apiSince 1
 */

public static java.math.BigDecimal valueOf(double val) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code BigDecimal} whose value is {@code this + augend}.
 * The scale of the result is the maximum of the scales of the two
 * arguments.
 *
 * @param augend
 *            value to be added to {@code this}.
 * @return {@code this + augend}.
 * @throws java.lang.NullPointerException
 *             if {@code augend == null}.
 * @apiSince 1
 */

public java.math.BigDecimal add(java.math.BigDecimal augend) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code BigDecimal} whose value is {@code this + augend}.
 * The result is rounded according to the passed context {@code mc}.
 *
 * @param augend
 *            value to be added to {@code this}.
 * @param mc
 *            rounding mode and precision for the result of this operation.
 * @return {@code this + augend}.
 * @throws java.lang.NullPointerException
 *             if {@code augend == null} or {@code mc == null}.
 * @apiSince 1
 */

public java.math.BigDecimal add(java.math.BigDecimal augend, java.math.MathContext mc) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code BigDecimal} whose value is {@code this - subtrahend}.
 * The scale of the result is the maximum of the scales of the two arguments.
 *
 * @param subtrahend
 *            value to be subtracted from {@code this}.
 * @return {@code this - subtrahend}.
 * @throws java.lang.NullPointerException
 *             if {@code subtrahend == null}.
 * @apiSince 1
 */

public java.math.BigDecimal subtract(java.math.BigDecimal subtrahend) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code BigDecimal} whose value is {@code this - subtrahend}.
 * The result is rounded according to the passed context {@code mc}.
 *
 * @param subtrahend
 *            value to be subtracted from {@code this}.
 * @param mc
 *            rounding mode and precision for the result of this operation.
 * @return {@code this - subtrahend}.
 * @throws java.lang.NullPointerException
 *             if {@code subtrahend == null} or {@code mc == null}.
 * @apiSince 1
 */

public java.math.BigDecimal subtract(java.math.BigDecimal subtrahend, java.math.MathContext mc) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code BigDecimal} whose value is {@code this *
 * multiplicand}. The scale of the result is the sum of the scales of the
 * two arguments.
 *
 * @param multiplicand
 *            value to be multiplied with {@code this}.
 * @return {@code this * multiplicand}.
 * @throws java.lang.NullPointerException
 *             if {@code multiplicand == null}.
 * @apiSince 1
 */

public java.math.BigDecimal multiply(java.math.BigDecimal multiplicand) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code BigDecimal} whose value is {@code this *
 * multiplicand}. The result is rounded according to the passed context
 * {@code mc}.
 *
 * @param multiplicand
 *            value to be multiplied with {@code this}.
 * @param mc
 *            rounding mode and precision for the result of this operation.
 * @return {@code this * multiplicand}.
 * @throws java.lang.NullPointerException
 *             if {@code multiplicand == null} or {@code mc == null}.
 * @apiSince 1
 */

public java.math.BigDecimal multiply(java.math.BigDecimal multiplicand, java.math.MathContext mc) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code BigDecimal} whose value is {@code this / divisor}.
 * As scale of the result the parameter {@code scale} is used. If rounding
 * is required to meet the specified scale, then the specified rounding mode
 * {@code roundingMode} is applied.
 *
 * @param divisor
 *            value by which {@code this} is divided.
 * @param scale
 *            the scale of the result returned.
 * @param roundingMode
 *            rounding mode to be used to round the result.
 * @return {@code this / divisor} rounded according to the given rounding
 *         mode.
 * @throws java.lang.NullPointerException
 *             if {@code divisor == null}.
 * @throws java.lang.IllegalArgumentException
 *             if {@code roundingMode} is not a valid rounding mode.
 * @throws java.lang.ArithmeticException
 *             if {@code divisor == 0}.
 * @throws java.lang.ArithmeticException
 *             if {@code roundingMode == ROUND_UNNECESSARY} and rounding is
 *             necessary according to the given scale.
 * @apiSince 1
 */

public java.math.BigDecimal divide(java.math.BigDecimal divisor, int scale, int roundingMode) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code BigDecimal} whose value is {@code this / divisor}.
 * As scale of the result the parameter {@code scale} is used. If rounding
 * is required to meet the specified scale, then the specified rounding mode
 * {@code roundingMode} is applied.
 *
 * @param divisor
 *            value by which {@code this} is divided.
 * @param scale
 *            the scale of the result returned.
 * @param roundingMode
 *            rounding mode to be used to round the result.
 * @return {@code this / divisor} rounded according to the given rounding
 *         mode.
 * @throws java.lang.NullPointerException
 *             if {@code divisor == null} or {@code roundingMode == null}.
 * @throws java.lang.ArithmeticException
 *             if {@code divisor == 0}.
 * @throws java.lang.ArithmeticException
 *             if {@code roundingMode == RoundingMode.UNNECESSAR}Y and
 *             rounding is necessary according to the given scale and given
 *             precision.
 * @apiSince 1
 */

public java.math.BigDecimal divide(java.math.BigDecimal divisor, int scale, java.math.RoundingMode roundingMode) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code BigDecimal} whose value is {@code this / divisor}.
 * The scale of the result is the scale of {@code this}. If rounding is
 * required to meet the specified scale, then the specified rounding mode
 * {@code roundingMode} is applied.
 *
 * @param divisor
 *            value by which {@code this} is divided.
 * @param roundingMode
 *            rounding mode to be used to round the result.
 * @return {@code this / divisor} rounded according to the given rounding
 *         mode.
 * @throws java.lang.NullPointerException
 *             if {@code divisor == null}.
 * @throws java.lang.IllegalArgumentException
 *             if {@code roundingMode} is not a valid rounding mode.
 * @throws java.lang.ArithmeticException
 *             if {@code divisor == 0}.
 * @throws java.lang.ArithmeticException
 *             if {@code roundingMode == ROUND_UNNECESSARY} and rounding is
 *             necessary according to the scale of this.
 * @apiSince 1
 */

public java.math.BigDecimal divide(java.math.BigDecimal divisor, int roundingMode) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code BigDecimal} whose value is {@code this / divisor}.
 * The scale of the result is the scale of {@code this}. If rounding is
 * required to meet the specified scale, then the specified rounding mode
 * {@code roundingMode} is applied.
 *
 * @param divisor
 *            value by which {@code this} is divided.
 * @param roundingMode
 *            rounding mode to be used to round the result.
 * @return {@code this / divisor} rounded according to the given rounding
 *         mode.
 * @throws java.lang.NullPointerException
 *             if {@code divisor == null} or {@code roundingMode == null}.
 * @throws java.lang.ArithmeticException
 *             if {@code divisor == 0}.
 * @throws java.lang.ArithmeticException
 *             if {@code roundingMode == RoundingMode.UNNECESSARY} and
 *             rounding is necessary according to the scale of this.
 * @apiSince 1
 */

public java.math.BigDecimal divide(java.math.BigDecimal divisor, java.math.RoundingMode roundingMode) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code BigDecimal} whose value is {@code this / divisor}.
 * The scale of the result is the difference of the scales of {@code this}
 * and {@code divisor}. If the exact result requires more digits, then the
 * scale is adjusted accordingly. For example, {@code 1/128 = 0.0078125}
 * which has a scale of {@code 7} and precision {@code 5}.
 *
 * @param divisor
 *            value by which {@code this} is divided.
 * @return {@code this / divisor}.
 * @throws java.lang.NullPointerException
 *             if {@code divisor == null}.
 * @throws java.lang.ArithmeticException
 *             if {@code divisor == 0}.
 * @throws java.lang.ArithmeticException
 *             if the result cannot be represented exactly.
 * @apiSince 1
 */

public java.math.BigDecimal divide(java.math.BigDecimal divisor) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code BigDecimal} whose value is {@code this / divisor}.
 * The result is rounded according to the passed context {@code mc}. If the
 * passed math context specifies precision {@code 0}, then this call is
 * equivalent to {@code this.divide(divisor)}.
 *
 * @param divisor
 *            value by which {@code this} is divided.
 * @param mc
 *            rounding mode and precision for the result of this operation.
 * @return {@code this / divisor}.
 * @throws java.lang.NullPointerException
 *             if {@code divisor == null} or {@code mc == null}.
 * @throws java.lang.ArithmeticException
 *             if {@code divisor == 0}.
 * @throws java.lang.ArithmeticException
 *             if {@code mc.getRoundingMode() == UNNECESSARY} and rounding
 *             is necessary according {@code mc.getPrecision()}.
 * @apiSince 1
 */

public java.math.BigDecimal divide(java.math.BigDecimal divisor, java.math.MathContext mc) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code BigDecimal} whose value is the integral part of
 * {@code this / divisor}. The quotient is rounded down towards zero to the
 * next integer. For example, {@code 0.5/0.2 = 2}.
 *
 * @param divisor
 *            value by which {@code this} is divided.
 * @return integral part of {@code this / divisor}.
 * @throws java.lang.NullPointerException
 *             if {@code divisor == null}.
 * @throws java.lang.ArithmeticException
 *             if {@code divisor == 0}.
 * @apiSince 1
 */

public java.math.BigDecimal divideToIntegralValue(java.math.BigDecimal divisor) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code BigDecimal} whose value is the integral part of
 * {@code this / divisor}. The quotient is rounded down towards zero to the
 * next integer. The rounding mode passed with the parameter {@code mc} is
 * not considered. But if the precision of {@code mc > 0} and the integral
 * part requires more digits, then an {@code ArithmeticException} is thrown.
 *
 * @param divisor
 *            value by which {@code this} is divided.
 * @param mc
 *            math context which determines the maximal precision of the
 *            result.
 * @return integral part of {@code this / divisor}.
 * @throws java.lang.NullPointerException
 *             if {@code divisor == null} or {@code mc == null}.
 * @throws java.lang.ArithmeticException
 *             if {@code divisor == 0}.
 * @throws java.lang.ArithmeticException
 *             if {@code mc.getPrecision() > 0} and the result requires more
 *             digits to be represented.
 * @apiSince 1
 */

public java.math.BigDecimal divideToIntegralValue(java.math.BigDecimal divisor, java.math.MathContext mc) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code BigDecimal} whose value is {@code this % divisor}.
 * <p>
 * The remainder is defined as {@code this -
 * this.divideToIntegralValue(divisor) * divisor}.
 *
 * @param divisor
 *            value by which {@code this} is divided.
 * @return {@code this % divisor}.
 * @throws java.lang.NullPointerException
 *             if {@code divisor == null}.
 * @throws java.lang.ArithmeticException
 *             if {@code divisor == 0}.
 * @apiSince 1
 */

public java.math.BigDecimal remainder(java.math.BigDecimal divisor) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code BigDecimal} whose value is {@code this % divisor}.
 * <p>
 * The remainder is defined as {@code this -
 * this.divideToIntegralValue(divisor) * divisor}.
 * <p>
 * The specified rounding mode {@code mc} is used for the division only.
 *
 * @param divisor
 *            value by which {@code this} is divided.
 * @param mc
 *            rounding mode and precision to be used.
 * @return {@code this % divisor}.
 * @throws java.lang.NullPointerException
 *             if {@code divisor == null}.
 * @throws java.lang.ArithmeticException
 *             if {@code divisor == 0}.
 * @throws java.lang.ArithmeticException
 *             if {@code mc.getPrecision() > 0} and the result of {@code
 *             this.divideToIntegralValue(divisor, mc)} requires more digits
 *             to be represented.
 * @apiSince 1
 */

public java.math.BigDecimal remainder(java.math.BigDecimal divisor, java.math.MathContext mc) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code BigDecimal} array which contains the integral part of
 * {@code this / divisor} at index 0 and the remainder {@code this %
 * divisor} at index 1. The quotient is rounded down towards zero to the
 * next integer.
 *
 * @param divisor
 *            value by which {@code this} is divided.
 * @return {@code [this.divideToIntegralValue(divisor),
 *         this.remainder(divisor)]}.
 * @throws java.lang.NullPointerException
 *             if {@code divisor == null}.
 * @throws java.lang.ArithmeticException
 *             if {@code divisor == 0}.
 * @see #divideToIntegralValue
 * @see #remainder
 * @apiSince 1
 */

public java.math.BigDecimal[] divideAndRemainder(java.math.BigDecimal divisor) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code BigDecimal} array which contains the integral part of
 * {@code this / divisor} at index 0 and the remainder {@code this %
 * divisor} at index 1. The quotient is rounded down towards zero to the
 * next integer. The rounding mode passed with the parameter {@code mc} is
 * not considered. But if the precision of {@code mc > 0} and the integral
 * part requires more digits, then an {@code ArithmeticException} is thrown.
 *
 * @param divisor
 *            value by which {@code this} is divided.
 * @param mc
 *            math context which determines the maximal precision of the
 *            result.
 * @return {@code [this.divideToIntegralValue(divisor),
 *         this.remainder(divisor)]}.
 * @throws java.lang.NullPointerException
 *             if {@code divisor == null}.
 * @throws java.lang.ArithmeticException
 *             if {@code divisor == 0}.
 * @see #divideToIntegralValue
 * @see #remainder
 * @apiSince 1
 */

public java.math.BigDecimal[] divideAndRemainder(java.math.BigDecimal divisor, java.math.MathContext mc) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code BigDecimal} whose value is {@code this<sup>n</sup>}. The
 * scale of the result is {@code n * this.scale()}.
 *
 * <p>{@code x.pow(0)} returns {@code 1}, even if {@code x == 0}.
 *
 * <p>Implementation Note: The implementation is based on the ANSI standard
 * X3.274-1996 algorithm.
 *
 * @throws java.lang.ArithmeticException
 *             if {@code n < 0} or {@code n > 999999999}.
 * @apiSince 1
 */

public java.math.BigDecimal pow(int n) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code BigDecimal} whose value is {@code this<sup>n</sup>}. The
 * result is rounded according to the passed context {@code mc}.
 *
 * <p>Implementation Note: The implementation is based on the ANSI standard
 * X3.274-1996 algorithm.
 *
 * @param mc
 *            rounding mode and precision for the result of this operation.
 * @throws java.lang.ArithmeticException
 *             if {@code n < 0} or {@code n > 999999999}.
 * @apiSince 1
 */

public java.math.BigDecimal pow(int n, java.math.MathContext mc) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code BigDecimal} whose value is the absolute value of
 * {@code this}. The scale of the result is the same as the scale of this.
 * @apiSince 1
 */

public java.math.BigDecimal abs() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code BigDecimal} whose value is the absolute value of
 * {@code this}. The result is rounded according to the passed context
 * {@code mc}.
 * @apiSince 1
 */

public java.math.BigDecimal abs(java.math.MathContext mc) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code BigDecimal} whose value is the {@code -this}. The
 * scale of the result is the same as the scale of this.
 *
 * @return {@code -this}
 * @apiSince 1
 */

public java.math.BigDecimal negate() { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code BigDecimal} whose value is the {@code -this}. The
 * result is rounded according to the passed context {@code mc}.
 *
 * @param mc
 *            rounding mode and precision for the result of this operation.
 * @return {@code -this}
 * @apiSince 1
 */

public java.math.BigDecimal negate(java.math.MathContext mc) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code BigDecimal} whose value is {@code +this}. The scale
 * of the result is the same as the scale of this.
 *
 * @return {@code this}
 * @apiSince 1
 */

public java.math.BigDecimal plus() { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code BigDecimal} whose value is {@code +this}. The result
 * is rounded according to the passed context {@code mc}.
 *
 * @param mc
 *            rounding mode and precision for the result of this operation.
 * @return {@code this}, rounded
 * @apiSince 1
 */

public java.math.BigDecimal plus(java.math.MathContext mc) { throw new RuntimeException("Stub!"); }

/**
 * Returns the sign of this {@code BigDecimal}.
 *
 * @return {@code -1} if {@code this < 0},
 *         {@code 0} if {@code this == 0},
 *         {@code 1} if {@code this > 0}.
 * @apiSince 1
 */

public int signum() { throw new RuntimeException("Stub!"); }

/**
 * Returns the scale of this {@code BigDecimal}. The scale is the number of
 * digits behind the decimal point. The value of this {@code BigDecimal} is
 * the {@code unsignedValue * 10<sup>-scale</sup>}. If the scale is negative,
 * then this {@code BigDecimal} represents a big integer.
 *
 * @return the scale of this {@code BigDecimal}.
 * @apiSince 1
 */

public int scale() { throw new RuntimeException("Stub!"); }

/**
 * Returns the precision of this {@code BigDecimal}. The precision is the
 * number of decimal digits used to represent this decimal. It is equivalent
 * to the number of digits of the unscaled value. The precision of {@code 0}
 * is {@code 1} (independent of the scale).
 *
 * @return the precision of this {@code BigDecimal}.
 * @apiSince 1
 */

public int precision() { throw new RuntimeException("Stub!"); }

/**
 * Returns the unscaled value (mantissa) of this {@code BigDecimal} instance
 * as a {@code BigInteger}. The unscaled value can be computed as
 * {@code this * 10<sup>scale</sup>}.
 * @apiSince 1
 */

public java.math.BigInteger unscaledValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code BigDecimal} whose value is {@code this}, rounded
 * according to the passed context {@code mc}.
 * <p>
 * If {@code mc.precision = 0}, then no rounding is performed.
 * <p>
 * If {@code mc.precision > 0} and {@code mc.roundingMode == UNNECESSARY},
 * then an {@code ArithmeticException} is thrown if the result cannot be
 * represented exactly within the given precision.
 *
 * @param mc
 *            rounding mode and precision for the result of this operation.
 * @return {@code this} rounded according to the passed context.
 * @throws java.lang.ArithmeticException
 *             if {@code mc.precision > 0} and {@code mc.roundingMode ==
 *             UNNECESSARY} and this cannot be represented within the given
 *             precision.
 * @apiSince 1
 */

public java.math.BigDecimal round(java.math.MathContext mc) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code BigDecimal} instance with the specified scale.
 * <p>
 * If the new scale is greater than the old scale, then additional zeros are
 * added to the unscaled value. In this case no rounding is necessary.
 * <p>
 * If the new scale is smaller than the old scale, then trailing digits are
 * removed. If these trailing digits are not zero, then the remaining
 * unscaled value has to be rounded. For this rounding operation the
 * specified rounding mode is used.
 *
 * @param newScale
 *            scale of the result returned.
 * @param roundingMode
 *            rounding mode to be used to round the result.
 * @return a new {@code BigDecimal} instance with the specified scale.
 * @throws java.lang.NullPointerException
 *             if {@code roundingMode == null}.
 * @throws java.lang.ArithmeticException
 *             if {@code roundingMode == ROUND_UNNECESSARY} and rounding is
 *             necessary according to the given scale.
 * @apiSince 1
 */

public java.math.BigDecimal setScale(int newScale, java.math.RoundingMode roundingMode) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code BigDecimal} instance with the specified scale.
 * <p>
 * If the new scale is greater than the old scale, then additional zeros are
 * added to the unscaled value. In this case no rounding is necessary.
 * <p>
 * If the new scale is smaller than the old scale, then trailing digits are
 * removed. If these trailing digits are not zero, then the remaining
 * unscaled value has to be rounded. For this rounding operation the
 * specified rounding mode is used.
 *
 * @param newScale
 *            scale of the result returned.
 * @param roundingMode
 *            rounding mode to be used to round the result.
 * @return a new {@code BigDecimal} instance with the specified scale.
 * @throws java.lang.IllegalArgumentException
 *             if {@code roundingMode} is not a valid rounding mode.
 * @throws java.lang.ArithmeticException
 *             if {@code roundingMode == ROUND_UNNECESSARY} and rounding is
 *             necessary according to the given scale.
 * @apiSince 1
 */

public java.math.BigDecimal setScale(int newScale, int roundingMode) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code BigDecimal} instance with the specified scale. If
 * the new scale is greater than the old scale, then additional zeros are
 * added to the unscaled value. If the new scale is smaller than the old
 * scale, then trailing zeros are removed. If the trailing digits are not
 * zeros then an ArithmeticException is thrown.
 * <p>
 * If no exception is thrown, then the following equation holds: {@code
 * x.setScale(s).compareTo(x) == 0}.
 *
 * @param newScale
 *            scale of the result returned.
 * @return a new {@code BigDecimal} instance with the specified scale.
 * @throws java.lang.ArithmeticException
 *             if rounding would be necessary.
 * @apiSince 1
 */

public java.math.BigDecimal setScale(int newScale) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code BigDecimal} instance where the decimal point has
 * been moved {@code n} places to the left. If {@code n < 0} then the
 * decimal point is moved {@code -n} places to the right.
 *
 * <p>The result is obtained by changing its scale. If the scale of the result
 * becomes negative, then its precision is increased such that the scale is
 * zero.
 *
 * <p>Note, that {@code movePointLeft(0)} returns a result which is
 * mathematically equivalent, but which has {@code scale >= 0}.
 * @apiSince 1
 */

public java.math.BigDecimal movePointLeft(int n) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code BigDecimal} instance where the decimal point has
 * been moved {@code n} places to the right. If {@code n < 0} then the
 * decimal point is moved {@code -n} places to the left.
 *
 * <p>The result is obtained by changing its scale. If the scale of the result
 * becomes negative, then its precision is increased such that the scale is
 * zero.
 *
 * <p>Note, that {@code movePointRight(0)} returns a result which is
 * mathematically equivalent, but which has scale >= 0.
 * @apiSince 1
 */

public java.math.BigDecimal movePointRight(int n) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code BigDecimal} whose value is {@code this * 10<sup>n</sup>}.
 * The scale of the result is {@code this.scale()} - {@code n}.
 * The precision of the result is the precision of {@code this}.
 *
 * <p>This method has the same effect as {@link #movePointRight}, except that
 * the precision is not changed.
 * @apiSince 1
 */

public java.math.BigDecimal scaleByPowerOfTen(int n) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@code BigDecimal} instance with the same value as {@code
 * this} but with a unscaled value where the trailing zeros have been
 * removed. If the unscaled value of {@code this} has n trailing zeros, then
 * the scale and the precision of the result has been reduced by n.
 *
 * @return a new {@code BigDecimal} instance equivalent to this where the
 *         trailing zeros of the unscaled value have been removed.
 * @apiSince 1
 */

public java.math.BigDecimal stripTrailingZeros() { throw new RuntimeException("Stub!"); }

/**
 * Compares this {@code BigDecimal} with {@code val}. Returns one of the
 * three values {@code 1}, {@code 0}, or {@code -1}. The method behaves as
 * if {@code this.subtract(val)} is computed. If this difference is > 0 then
 * 1 is returned, if the difference is < 0 then -1 is returned, and if the
 * difference is 0 then 0 is returned. This means, that if two decimal
 * instances are compared which are equal in value but differ in scale, then
 * these two instances are considered as equal.
 *
 * @param val
 *            value to be compared with {@code this}.
 * @return {@code 1} if {@code this > val}, {@code -1} if {@code this < val},
 *         {@code 0} if {@code this == val}.
 * @throws java.lang.NullPointerException
 *             if {@code val == null}.
 * @apiSince 1
 */

public int compareTo(java.math.BigDecimal val) { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if {@code x} is a {@code BigDecimal} instance and if
 * this instance is equal to this big decimal. Two big decimals are equal if
 * their unscaled value and their scale is equal. For example, 1.0
 * (10*10<sup>-1</sup>) is not equal to 1.00 (100*10<sup>-2</sup>). Similarly, zero
 * instances are not equal if their scale differs.
 * @apiSince 1
 */

public boolean equals(java.lang.Object x) { throw new RuntimeException("Stub!"); }

/**
 * Returns the minimum of this {@code BigDecimal} and {@code val}.
 *
 * @param val
 *            value to be used to compute the minimum with this.
 * @return {@code min(this, val}.
 * @throws java.lang.NullPointerException
 *             if {@code val == null}.
 * @apiSince 1
 */

public java.math.BigDecimal min(java.math.BigDecimal val) { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum of this {@code BigDecimal} and {@code val}.
 *
 * @param val
 *            value to be used to compute the maximum with this.
 * @return {@code max(this, val}.
 * @throws java.lang.NullPointerException
 *             if {@code val == null}.
 * @apiSince 1
 */

public java.math.BigDecimal max(java.math.BigDecimal val) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code for this {@code BigDecimal}.
 *
 * @return hash code for {@code this}.
 * @apiSince 1
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns a canonical string representation of this {@code BigDecimal}. If
 * necessary, scientific notation is used. This representation always prints
 * all significant digits of this value.
 * <p>
 * If the scale is negative or if {@code scale - precision >= 6} then
 * scientific notation is used.
 *
 * @return a string representation of {@code this} in scientific notation if
 *         necessary.
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of this {@code BigDecimal}. This
 * representation always prints all significant digits of this value.
 * <p>
 * If the scale is negative or if {@code scale - precision >= 6} then
 * engineering notation is used. Engineering notation is similar to the
 * scientific notation except that the exponent is made to be a multiple of
 * 3 such that the integer part is >= 1 and < 1000.
 *
 * @return a string representation of {@code this} in engineering notation
 *         if necessary.
 * @apiSince 1
 */

public java.lang.String toEngineeringString() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of this {@code BigDecimal}. No scientific
 * notation is used. This methods adds zeros where necessary.
 * <p>
 * If this string representation is used to create a new instance, this
 * instance is generally not identical to {@code this} as the precision
 * changes.
 * <p>
 * {@code x.equals(new BigDecimal(x.toPlainString())} usually returns
 * {@code false}.
 * <p>
 * {@code x.compareTo(new BigDecimal(x.toPlainString())} returns {@code 0}.
 *
 * @return a string representation of {@code this} without exponent part.
 * @apiSince 1
 */

public java.lang.String toPlainString() { throw new RuntimeException("Stub!"); }

/**
 * Returns this {@code BigDecimal} as a big integer instance. A fractional
 * part is discarded.
 *
 * @return this {@code BigDecimal} as a big integer instance.
 * @apiSince 1
 */

public java.math.BigInteger toBigInteger() { throw new RuntimeException("Stub!"); }

/**
 * Returns this {@code BigDecimal} as a big integer instance if it has no
 * fractional part. If this {@code BigDecimal} has a fractional part, i.e.
 * if rounding would be necessary, an {@code ArithmeticException} is thrown.
 *
 * @return this {@code BigDecimal} as a big integer value.
 * @throws java.lang.ArithmeticException
 *             if rounding is necessary.
 * @apiSince 1
 */

public java.math.BigInteger toBigIntegerExact() { throw new RuntimeException("Stub!"); }

/**
 * Returns this {@code BigDecimal} as an long value. Any fractional part is
 * discarded. If the integral part of {@code this} is too big to be
 * represented as an long, then {@code this % 2<sup>64</sup>} is returned.
 * @apiSince 1
 */

public long longValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns this {@code BigDecimal} as a long value if it has no fractional
 * part and if its value fits to the int range ([-2<sup>63</sup>..2<sup>63</sup>-1]). If
 * these conditions are not met, an {@code ArithmeticException} is thrown.
 *
 * @throws java.lang.ArithmeticException
 *             if rounding is necessary or the number doesn't fit in a long.
 * @apiSince 1
 */

public long longValueExact() { throw new RuntimeException("Stub!"); }

/**
 * Returns this {@code BigDecimal} as an int value. Any fractional part is
 * discarded. If the integral part of {@code this} is too big to be
 * represented as an int, then {@code this % 2<sup>32</sup>} is returned.
 * @apiSince 1
 */

public int intValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns this {@code BigDecimal} as a int value if it has no fractional
 * part and if its value fits to the int range ([-2<sup>31</sup>..2<sup>31</sup>-1]). If
 * these conditions are not met, an {@code ArithmeticException} is thrown.
 *
 * @throws java.lang.ArithmeticException
 *             if rounding is necessary or the number doesn't fit in an int.
 * @apiSince 1
 */

public int intValueExact() { throw new RuntimeException("Stub!"); }

/**
 * Returns this {@code BigDecimal} as a short value if it has no fractional
 * part and if its value fits to the short range ([-2<sup>15</sup>..2<sup>15</sup>-1]). If
 * these conditions are not met, an {@code ArithmeticException} is thrown.
 *
 * @throws java.lang.ArithmeticException
 *             if rounding is necessary of the number doesn't fit in a short.
 * @apiSince 1
 */

public short shortValueExact() { throw new RuntimeException("Stub!"); }

/**
 * Returns this {@code BigDecimal} as a byte value if it has no fractional
 * part and if its value fits to the byte range ([-128..127]). If these
 * conditions are not met, an {@code ArithmeticException} is thrown.
 *
 * @throws java.lang.ArithmeticException
 *             if rounding is necessary or the number doesn't fit in a byte.
 * @apiSince 1
 */

public byte byteValueExact() { throw new RuntimeException("Stub!"); }

/**
 * Returns this {@code BigDecimal} as a float value. If {@code this} is too
 * big to be represented as an float, then {@code Float.POSITIVE_INFINITY}
 * or {@code Float.NEGATIVE_INFINITY} is returned.
 * <p>
 * Note, that if the unscaled value has more than 24 significant digits,
 * then this decimal cannot be represented exactly in a float variable. In
 * this case the result is rounded.
 * <p>
 * For example, if the instance {@code x1 = new BigDecimal("0.1")} cannot be
 * represented exactly as a float, and thus {@code x1.equals(new
 * BigDecimal(x1.floatValue())} returns {@code false} for this case.
 * <p>
 * Similarly, if the instance {@code new BigDecimal(16777217)} is converted
 * to a float, the result is {@code 1.6777216E}7.
 *
 * @return this {@code BigDecimal} as a float value.
 * @apiSince 1
 */

public float floatValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns this {@code BigDecimal} as a double value. If {@code this} is too
 * big to be represented as an float, then {@code Double.POSITIVE_INFINITY}
 * or {@code Double.NEGATIVE_INFINITY} is returned.
 * <p>
 * Note, that if the unscaled value has more than 53 significant digits,
 * then this decimal cannot be represented exactly in a double variable. In
 * this case the result is rounded.
 * <p>
 * For example, if the instance {@code x1 = new BigDecimal("0.1")} cannot be
 * represented exactly as a double, and thus {@code x1.equals(new
 * BigDecimal(x1.doubleValue())} returns {@code false} for this case.
 * <p>
 * Similarly, if the instance {@code new BigDecimal(9007199254740993L)} is
 * converted to a double, the result is {@code 9.007199254740992E15}.
 * <p>
 *
 * @return this {@code BigDecimal} as a double value.
 * @apiSince 1
 */

public double doubleValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns the unit in the last place (ULP) of this {@code BigDecimal}
 * instance. An ULP is the distance to the nearest big decimal with the same
 * precision.
 *
 * <p>The amount of a rounding error in the evaluation of a floating-point
 * operation is often expressed in ULPs. An error of 1 ULP is often seen as
 * a tolerable error.
 *
 * <p>For class {@code BigDecimal}, the ULP of a number is simply 10<sup>-scale</sup>.
 * For example, {@code new BigDecimal(0.1).ulp()} returns {@code 1E-55}.
 *
 * @return unit in the last place (ULP) of this {@code BigDecimal} instance.
 * @apiSince 1
 */

public java.math.BigDecimal ulp() { throw new RuntimeException("Stub!"); }

/**
 * The constant one as a {@code BigDecimal}.
 * @apiSince 1
 */

public static final java.math.BigDecimal ONE;
static { ONE = null; }

/**
 * Rounding mode to round towards positive infinity. For positive values
 * this rounding mode behaves as {@link #ROUND_UP}, for negative values as
 * {@link #ROUND_DOWN}.
 *
 * @see java.math.RoundingMode#CEILING
 * @apiSince 1
 */

public static final int ROUND_CEILING = 2; // 0x2

/**
 * Rounding mode where the values are rounded towards zero.
 *
 * @see java.math.RoundingMode#DOWN
 * @apiSince 1
 */

public static final int ROUND_DOWN = 1; // 0x1

/**
 * Rounding mode to round towards negative infinity. For positive values
 * this rounding mode behaves as {@link #ROUND_DOWN}, for negative values as
 * {@link #ROUND_UP}.
 *
 * @see java.math.RoundingMode#FLOOR
 * @apiSince 1
 */

public static final int ROUND_FLOOR = 3; // 0x3

/**
 * Rounding mode where values are rounded towards the nearest neighbor.
 * Ties are broken by rounding down.
 *
 * @see java.math.RoundingMode#HALF_DOWN
 * @apiSince 1
 */

public static final int ROUND_HALF_DOWN = 5; // 0x5

/**
 * Rounding mode where values are rounded towards the nearest neighbor.
 * Ties are broken by rounding to the even neighbor.
 *
 * @see java.math.RoundingMode#HALF_EVEN
 * @apiSince 1
 */

public static final int ROUND_HALF_EVEN = 6; // 0x6

/**
 * Rounding mode where values are rounded towards the nearest neighbor.
 * Ties are broken by rounding up.
 *
 * @see java.math.RoundingMode#HALF_UP
 * @apiSince 1
 */

public static final int ROUND_HALF_UP = 4; // 0x4

/**
 * Rounding mode where the rounding operations throws an {@code
 * ArithmeticException} for the case that rounding is necessary, i.e. for
 * the case that the value cannot be represented exactly.
 *
 * @see java.math.RoundingMode#UNNECESSARY
 * @apiSince 1
 */

public static final int ROUND_UNNECESSARY = 7; // 0x7

/**
 * Rounding mode where positive values are rounded towards positive infinity
 * and negative values towards negative infinity.
 *
 * @see java.math.RoundingMode#UP
 * @apiSince 1
 */

public static final int ROUND_UP = 0; // 0x0

/**
 * The constant ten as a {@code BigDecimal}.
 * @apiSince 1
 */

public static final java.math.BigDecimal TEN;
static { TEN = null; }

/**
 * The constant zero as a {@code BigDecimal}.
 * @apiSince 1
 */

public static final java.math.BigDecimal ZERO;
static { ZERO = null; }
}

