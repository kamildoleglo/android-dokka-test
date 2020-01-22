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
 * Specifies the rounding behavior for operations whose results cannot be
 * represented exactly.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum RoundingMode {
/**
 * Rounding mode where positive values are rounded towards positive infinity
 * and negative values towards negative infinity.
 * <br>
 * Rule: {@code x.round().abs() >= x.abs()}
 * @apiSince 1
 */

UP,
/**
 * Rounding mode where the values are rounded towards zero.
 * <br>
 * Rule: {@code x.round().abs() <= x.abs()}
 * @apiSince 1
 */

DOWN,
/**
 * Rounding mode to round towards positive infinity. For positive values
 * this rounding mode behaves as {@link #UP}, for negative values as
 * {@link #DOWN}.
 * <br>
 * Rule: {@code x.round() >= x}
 * @apiSince 1
 */

CEILING,
/**
 * Rounding mode to round towards negative infinity. For positive values
 * this rounding mode behaves as {@link #DOWN}, for negative values as
 * {@link #UP}.
 * <br>
 * Rule: {@code x.round() <= x}
 * @apiSince 1
 */

FLOOR,
/**
 * Rounding mode where values are rounded towards the nearest neighbor. Ties
 * are broken by rounding up.
 * @apiSince 1
 */

HALF_UP,
/**
 * Rounding mode where values are rounded towards the nearest neighbor. Ties
 * are broken by rounding down.
 * @apiSince 1
 */

HALF_DOWN,
/**
 * Rounding mode where values are rounded towards the nearest neighbor. Ties
 * are broken by rounding to the even neighbor.
 * @apiSince 1
 */

HALF_EVEN,
/**
 * Rounding mode where the rounding operations throws an ArithmeticException
 * for the case that rounding is necessary, i.e. for the case that the value
 * cannot be represented exactly.
 * @apiSince 1
 */

UNNECESSARY;

/**
 * Converts rounding mode constants from class {@code BigDecimal} into
 * {@code RoundingMode} values.
 *
 * @param mode
 *            rounding mode constant as defined in class {@code BigDecimal}
 * @return corresponding rounding mode object
 * @apiSince 1
 */

public static java.math.RoundingMode valueOf(int mode) { throw new RuntimeException("Stub!"); }
}

