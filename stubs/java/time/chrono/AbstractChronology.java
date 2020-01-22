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
 * Copyright (c) 2012, Stephen Colebourne & Michael Nascimento Santos
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


package java.time.chrono;

import java.io.Serializable;
import java.time.temporal.TemporalField;
import java.time.DateTimeException;
import java.time.temporal.ChronoField;

/**
 * An abstract implementation of a calendar system, used to organize and identify dates.
 * <p>
 * The main date and time API is built on the ISO calendar system.
 * The chronology operates behind the scenes to represent the general concept of a calendar system.
 * <p>
 * See {@link java.time.chrono.Chronology Chronology} for more details.
 *
 * @implSpec
 * This class is separated from the {@code Chronology} interface so that the static methods
 * are not inherited. While {@code Chronology} can be implemented directly, it is strongly
 * recommended to extend this abstract class instead.
 * <p>
 * This class must be implemented with care to ensure other classes operate correctly.
 * All implementations that can be instantiated must be final, immutable and thread-safe.
 * Subclasses should be Serializable wherever possible.
 *
 * @since 1.8
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class AbstractChronology implements java.time.chrono.Chronology {

/**
 * Creates an instance.
 * @apiSince 26
 */

protected AbstractChronology() { throw new RuntimeException("Stub!"); }

/**
 * Resolves parsed {@code ChronoField} values into a date during parsing.
 * <p>
 * Most {@code TemporalField} implementations are resolved using the
 * resolve method on the field. By contrast, the {@code ChronoField} class
 * defines fields that only have meaning relative to the chronology.
 * As such, {@code ChronoField} date fields are resolved here in the
 * context of a specific chronology.
 * <p>
 * {@code ChronoField} instances are resolved by this method, which may
 * be overridden in subclasses.
 * <ul>
 * <li>{@code EPOCH_DAY} - If present, this is converted to a date and
 *  all other date fields are then cross-checked against the date.
 * <li>{@code PROLEPTIC_MONTH} - If present, then it is split into the
 *  {@code YEAR} and {@code MONTH_OF_YEAR}. If the mode is strict or smart
 *  then the field is validated.
 * <li>{@code YEAR_OF_ERA} and {@code ERA} - If both are present, then they
 *  are combined to form a {@code YEAR}. In lenient mode, the {@code YEAR_OF_ERA}
 *  range is not validated, in smart and strict mode it is. The {@code ERA} is
 *  validated for range in all three modes. If only the {@code YEAR_OF_ERA} is
 *  present, and the mode is smart or lenient, then the last available era
 *  is assumed. In strict mode, no era is assumed and the {@code YEAR_OF_ERA} is
 *  left untouched. If only the {@code ERA} is present, then it is left untouched.
 * <li>{@code YEAR}, {@code MONTH_OF_YEAR} and {@code DAY_OF_MONTH} -
 *  If all three are present, then they are combined to form a date.
 *  In all three modes, the {@code YEAR} is validated.
 *  If the mode is smart or strict, then the month and day are validated.
 *  If the mode is lenient, then the date is combined in a manner equivalent to
 *  creating a date on the first day of the first month in the requested year,
 *  then adding the difference in months, then the difference in days.
 *  If the mode is smart, and the day-of-month is greater than the maximum for
 *  the year-month, then the day-of-month is adjusted to the last day-of-month.
 *  If the mode is strict, then the three fields must form a valid date.
 * <li>{@code YEAR} and {@code DAY_OF_YEAR} -
 *  If both are present, then they are combined to form a date.
 *  In all three modes, the {@code YEAR} is validated.
 *  If the mode is lenient, then the date is combined in a manner equivalent to
 *  creating a date on the first day of the requested year, then adding
 *  the difference in days.
 *  If the mode is smart or strict, then the two fields must form a valid date.
 * <li>{@code YEAR}, {@code MONTH_OF_YEAR}, {@code ALIGNED_WEEK_OF_MONTH} and
 *  {@code ALIGNED_DAY_OF_WEEK_IN_MONTH} -
 *  If all four are present, then they are combined to form a date.
 *  In all three modes, the {@code YEAR} is validated.
 *  If the mode is lenient, then the date is combined in a manner equivalent to
 *  creating a date on the first day of the first month in the requested year, then adding
 *  the difference in months, then the difference in weeks, then in days.
 *  If the mode is smart or strict, then the all four fields are validated to
 *  their outer ranges. The date is then combined in a manner equivalent to
 *  creating a date on the first day of the requested year and month, then adding
 *  the amount in weeks and days to reach their values. If the mode is strict,
 *  the date is additionally validated to check that the day and week adjustment
 *  did not change the month.
 * <li>{@code YEAR}, {@code MONTH_OF_YEAR}, {@code ALIGNED_WEEK_OF_MONTH} and
 *  {@code DAY_OF_WEEK} - If all four are present, then they are combined to
 *  form a date. The approach is the same as described above for
 *  years, months and weeks in {@code ALIGNED_DAY_OF_WEEK_IN_MONTH}.
 *  The day-of-week is adjusted as the next or same matching day-of-week once
 *  the years, months and weeks have been handled.
 * <li>{@code YEAR}, {@code ALIGNED_WEEK_OF_YEAR} and {@code ALIGNED_DAY_OF_WEEK_IN_YEAR} -
 *  If all three are present, then they are combined to form a date.
 *  In all three modes, the {@code YEAR} is validated.
 *  If the mode is lenient, then the date is combined in a manner equivalent to
 *  creating a date on the first day of the requested year, then adding
 *  the difference in weeks, then in days.
 *  If the mode is smart or strict, then the all three fields are validated to
 *  their outer ranges. The date is then combined in a manner equivalent to
 *  creating a date on the first day of the requested year, then adding
 *  the amount in weeks and days to reach their values. If the mode is strict,
 *  the date is additionally validated to check that the day and week adjustment
 *  did not change the year.
 * <li>{@code YEAR}, {@code ALIGNED_WEEK_OF_YEAR} and {@code DAY_OF_WEEK} -
 *  If all three are present, then they are combined to form a date.
 *  The approach is the same as described above for years and weeks in
 *  {@code ALIGNED_DAY_OF_WEEK_IN_YEAR}. The day-of-week is adjusted as the
 *  next or same matching day-of-week once the years and weeks have been handled.
 * </ul>
 * <p>
 * The default implementation is suitable for most calendar systems.
 * If {@link java.time.temporal.ChronoField#YEAR_OF_ERA} is found without an {@link java.time.temporal.ChronoField#ERA}
 * then the last era in {@link #eras()} is used.
 * The implementation assumes a 7 day week, that the first day-of-month
 * has the value 1, that first day-of-year has the value 1, and that the
 * first of the month and year always exists.
 *
 * @param fieldValues  the map of fields to values, which can be updated, not null
 * @param resolverStyle  the requested type of resolve, not null
 * @return the resolved date, null if insufficient information to create a date
 * @throws java.time.DateTimeException if the date cannot be resolved, typically
 *  because of a conflict in the input data
 * @apiSince 26
 */

public java.time.chrono.ChronoLocalDate resolveDate(java.util.Map<java.time.temporal.TemporalField,java.lang.Long> fieldValues, java.time.format.ResolverStyle resolverStyle) { throw new RuntimeException("Stub!"); }

/**
 * Compares this chronology to another chronology.
 * <p>
 * The comparison order first by the chronology ID string, then by any
 * additional information specific to the subclass.
 * It is "consistent with equals", as defined by {@link java.lang.Comparable Comparable}.
 *
 * @implSpec
 * This implementation compares the chronology ID.
 * Subclasses must compare any additional state that they store.
 *
 * @param other  the other chronology to compare to, not null
 * @return the comparator value, negative if less, positive if greater
 * @apiSince 26
 */

public int compareTo(java.time.chrono.Chronology other) { throw new RuntimeException("Stub!"); }

/**
 * Checks if this chronology is equal to another chronology.
 * <p>
 * The comparison is based on the entire state of the object.
 *
 * @implSpec
 * This implementation checks the type and calls
 * {@link #compareTo(java.time.chrono.Chronology)}.
 *
 * @param obj  the object to check, null returns false
 * @return true if this is equal to the other chronology
 * @apiSince 26
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * A hash code for this chronology.
 * <p>
 * The hash code should be based on the entire state of the object.
 *
 * @implSpec
 * This implementation is based on the chronology ID and class.
 * Subclasses should add any additional state that they store.
 *
 * @return a suitable hash code
 * @apiSince 26
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Outputs this chronology as a {@code String}, using the chronology ID.
 *
 * @return a string representation of this chronology, not null
 * @apiSince 26
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

