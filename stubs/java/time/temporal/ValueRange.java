/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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

/*
 * This file is available under and governed by the GNU General Public
 * License version 2 only, as published by the Free Software Foundation.
 * However, the following notice accompanied the original version of this
 * file:
 *
 * Copyright (c) 2011-2012, Stephen Colebourne & Michael Nascimento Santos
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 *  * Neither the name of JSR-310 nor the names of its contributors
 *    may be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */


package java.time.temporal;


/**
 * The range of valid values for a date-time field.
 * <p>
 * All {@link java.time.temporal.TemporalField TemporalField} instances have a valid range of values.
 * For example, the ISO day-of-month runs from 1 to somewhere between 28 and 31.
 * This class captures that valid range.
 * <p>
 * It is important to be aware of the limitations of this class.
 * Only the minimum and maximum values are provided.
 * It is possible for there to be invalid values within the outer range.
 * For example, a weird field may have valid values of 1, 2, 4, 6, 7, thus
 * have a range of '1 - 7', despite that fact that values 3 and 5 are invalid.
 * <p>
 * Instances of this class are not tied to a specific field.
 *
 * @implSpec
 * This class is immutable and thread-safe.
 *
 * @since 1.8
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ValueRange implements java.io.Serializable {

private ValueRange() { throw new RuntimeException("Stub!"); }

/**
 * Obtains a fixed value range.
 * <p>
 * This factory obtains a range where the minimum and maximum values are fixed.
 * For example, the ISO month-of-year always runs from 1 to 12.
 *
 * @param min  the minimum value
 * @param max  the maximum value
 * @return the ValueRange for min, max, not null
 * @throws java.lang.IllegalArgumentException if the minimum is greater than the maximum
 * @apiSince 26
 */

public static java.time.temporal.ValueRange of(long min, long max) { throw new RuntimeException("Stub!"); }

/**
 * Obtains a variable value range.
 * <p>
 * This factory obtains a range where the minimum value is fixed and the maximum value may vary.
 * For example, the ISO day-of-month always starts at 1, but ends between 28 and 31.
 *
 * @param min  the minimum value
 * @param maxSmallest  the smallest maximum value
 * @param maxLargest  the largest maximum value
 * @return the ValueRange for min, smallest max, largest max, not null
 * @throws java.lang.IllegalArgumentException if
 *     the minimum is greater than the smallest maximum,
 *  or the smallest maximum is greater than the largest maximum
 * @apiSince 26
 */

public static java.time.temporal.ValueRange of(long min, long maxSmallest, long maxLargest) { throw new RuntimeException("Stub!"); }

/**
 * Obtains a fully variable value range.
 * <p>
 * This factory obtains a range where both the minimum and maximum value may vary.
 *
 * @param minSmallest  the smallest minimum value
 * @param minLargest  the largest minimum value
 * @param maxSmallest  the smallest maximum value
 * @param maxLargest  the largest maximum value
 * @return the ValueRange for smallest min, largest min, smallest max, largest max, not null
 * @throws java.lang.IllegalArgumentException if
 *     the smallest minimum is greater than the smallest maximum,
 *  or the smallest maximum is greater than the largest maximum
 *  or the largest minimum is greater than the largest maximum
 * @apiSince 26
 */

public static java.time.temporal.ValueRange of(long minSmallest, long minLargest, long maxSmallest, long maxLargest) { throw new RuntimeException("Stub!"); }

/**
 * Is the value range fixed and fully known.
 * <p>
 * For example, the ISO day-of-month runs from 1 to between 28 and 31.
 * Since there is uncertainty about the maximum value, the range is not fixed.
 * However, for the month of January, the range is always 1 to 31, thus it is fixed.
 *
 * @return true if the set of values is fixed
 * @apiSince 26
 */

public boolean isFixed() { throw new RuntimeException("Stub!"); }

/**
 * Gets the minimum value that the field can take.
 * <p>
 * For example, the ISO day-of-month always starts at 1.
 * The minimum is therefore 1.
 *
 * @return the minimum value for this field
 * @apiSince 26
 */

public long getMinimum() { throw new RuntimeException("Stub!"); }

/**
 * Gets the largest possible minimum value that the field can take.
 * <p>
 * For example, the ISO day-of-month always starts at 1.
 * The largest minimum is therefore 1.
 *
 * @return the largest possible minimum value for this field
 * @apiSince 26
 */

public long getLargestMinimum() { throw new RuntimeException("Stub!"); }

/**
 * Gets the smallest possible maximum value that the field can take.
 * <p>
 * For example, the ISO day-of-month runs to between 28 and 31 days.
 * The smallest maximum is therefore 28.
 *
 * @return the smallest possible maximum value for this field
 * @apiSince 26
 */

public long getSmallestMaximum() { throw new RuntimeException("Stub!"); }

/**
 * Gets the maximum value that the field can take.
 * <p>
 * For example, the ISO day-of-month runs to between 28 and 31 days.
 * The maximum is therefore 31.
 *
 * @return the maximum value for this field
 * @apiSince 26
 */

public long getMaximum() { throw new RuntimeException("Stub!"); }

/**
 * Checks if all values in the range fit in an {@code int}.
 * <p>
 * This checks that all valid values are within the bounds of an {@code int}.
 * <p>
 * For example, the ISO month-of-year has values from 1 to 12, which fits in an {@code int}.
 * By comparison, ISO nano-of-day runs from 1 to 86,400,000,000,000 which does not fit in an {@code int}.
 * <p>
 * This implementation uses {@link #getMinimum()} and {@link #getMaximum()}.
 *
 * @return true if a valid value always fits in an {@code int}
 * @apiSince 26
 */

public boolean isIntValue() { throw new RuntimeException("Stub!"); }

/**
 * Checks if the value is within the valid range.
 * <p>
 * This checks that the value is within the stored range of values.
 *
 * @param value  the value to check
 * @return true if the value is valid
 * @apiSince 26
 */

public boolean isValidValue(long value) { throw new RuntimeException("Stub!"); }

/**
 * Checks if the value is within the valid range and that all values
 * in the range fit in an {@code int}.
 * <p>
 * This method combines {@link #isIntValue()} and {@link #isValidValue(long)}.
 *
 * @param value  the value to check
 * @return true if the value is valid and fits in an {@code int}
 * @apiSince 26
 */

public boolean isValidIntValue(long value) { throw new RuntimeException("Stub!"); }

/**
 * Checks that the specified value is valid.
 * <p>
 * This validates that the value is within the valid range of values.
 * The field is only used to improve the error message.
 *
 * @param value  the value to check
 * @param field  the field being checked, may be null
 * @return the value that was passed in
 * @see #isValidValue(long)
 * @apiSince 26
 */

public long checkValidValue(long value, java.time.temporal.TemporalField field) { throw new RuntimeException("Stub!"); }

/**
 * Checks that the specified value is valid and fits in an {@code int}.
 * <p>
 * This validates that the value is within the valid range of values and that
 * all valid values are within the bounds of an {@code int}.
 * The field is only used to improve the error message.
 *
 * @param value  the value to check
 * @param field  the field being checked, may be null
 * @return the value that was passed in
 * @see #isValidIntValue(long)
 * @apiSince 26
 */

public int checkValidIntValue(long value, java.time.temporal.TemporalField field) { throw new RuntimeException("Stub!"); }

/**
 * Checks if this range is equal to another range.
 * <p>
 * The comparison is based on the four values, minimum, largest minimum,
 * smallest maximum and maximum.
 * Only objects of type {@code ValueRange} are compared, other types return false.
 *
 * @param obj  the object to check, null returns false
 * @return true if this is equal to the other range
 * @apiSince 26
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * A hash code for this range.
 *
 * @return a suitable hash code
 * @apiSince 26
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Outputs this range as a {@code String}.
 * <p>
 * The format will be '{min}/{largestMin} - {smallestMax}/{max}',
 * where the largestMin or smallestMax sections may be omitted, together
 * with associated slash, if they are the same as the min or max.
 *
 * @return a string representation of this range, not null
 * @apiSince 26
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

