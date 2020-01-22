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
 * Copyright (c) 2009-2012, Stephen Colebourne & Michael Nascimento Santos
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


package java.time.zone;


/**
 * A rule expressing how to create a transition.
 * <p>
 * This class allows rules for identifying future transitions to be expressed.
 * A rule might be written in many forms:
 * <ul>
 * <li>the 16th March
 * <li>the Sunday on or after the 16th March
 * <li>the Sunday on or before the 16th March
 * <li>the last Sunday in February
 * </ul>
 * These different rule types can be expressed and queried.
 *
 * @implSpec
 * This class is immutable and thread-safe.
 *
 * @since 1.8
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ZoneOffsetTransitionRule implements java.io.Serializable {

ZoneOffsetTransitionRule() { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance defining the yearly rule to create transitions between two offsets.
 * <p>
 * Applications should normally obtain an instance from {@link java.time.zone.ZoneRules ZoneRules}.
 * This factory is only intended for use when creating {@link java.time.zone.ZoneRules ZoneRules}.
 *
 * @param month  the month of the month-day of the first day of the cutover week, not null
 * @param dayOfMonthIndicator  the day of the month-day of the cutover week, positive if the week is that
 *  day or later, negative if the week is that day or earlier, counting from the last day of the month,
 *  from -28 to 31 excluding 0
 * @param dayOfWeek  the required day-of-week, null if the month-day should not be changed
 * @param time  the cutover time in the 'before' offset, not null
 * @param timeEndOfDay  whether the time is midnight at the end of day
 * @param timeDefnition  how to interpret the cutover
 * @param standardOffset  the standard offset in force at the cutover, not null
 * @param offsetBefore  the offset before the cutover, not null
 * @param offsetAfter  the offset after the cutover, not null
 * @return the rule, not null
 * @throws java.lang.IllegalArgumentException if the day of month indicator is invalid
 * @throws java.lang.IllegalArgumentException if the end of day flag is true when the time is not midnight
 * @apiSince 26
 */

public static java.time.zone.ZoneOffsetTransitionRule of(java.time.Month month, int dayOfMonthIndicator, java.time.DayOfWeek dayOfWeek, java.time.LocalTime time, boolean timeEndOfDay, java.time.zone.ZoneOffsetTransitionRule.TimeDefinition timeDefnition, java.time.ZoneOffset standardOffset, java.time.ZoneOffset offsetBefore, java.time.ZoneOffset offsetAfter) { throw new RuntimeException("Stub!"); }

/**
 * Gets the month of the transition.
 * <p>
 * If the rule defines an exact date then the month is the month of that date.
 * <p>
 * If the rule defines a week where the transition might occur, then the month
 * if the month of either the earliest or latest possible date of the cutover.
 *
 * @return the month of the transition, not null
 * @apiSince 26
 */

public java.time.Month getMonth() { throw new RuntimeException("Stub!"); }

/**
 * Gets the indicator of the day-of-month of the transition.
 * <p>
 * If the rule defines an exact date then the day is the month of that date.
 * <p>
 * If the rule defines a week where the transition might occur, then the day
 * defines either the start of the end of the transition week.
 * <p>
 * If the value is positive, then it represents a normal day-of-month, and is the
 * earliest possible date that the transition can be.
 * The date may refer to 29th February which should be treated as 1st March in non-leap years.
 * <p>
 * If the value is negative, then it represents the number of days back from the
 * end of the month where {@code -1} is the last day of the month.
 * In this case, the day identified is the latest possible date that the transition can be.
 *
 * @return the day-of-month indicator, from -28 to 31 excluding 0
 * @apiSince 26
 */

public int getDayOfMonthIndicator() { throw new RuntimeException("Stub!"); }

/**
 * Gets the day-of-week of the transition.
 * <p>
 * If the rule defines an exact date then this returns null.
 * <p>
 * If the rule defines a week where the cutover might occur, then this method
 * returns the day-of-week that the month-day will be adjusted to.
 * If the day is positive then the adjustment is later.
 * If the day is negative then the adjustment is earlier.
 *
 * @return the day-of-week that the transition occurs, null if the rule defines an exact date
 * @apiSince 26
 */

public java.time.DayOfWeek getDayOfWeek() { throw new RuntimeException("Stub!"); }

/**
 * Gets the local time of day of the transition which must be checked with
 * {@link #isMidnightEndOfDay()}.
 * <p>
 * The time is converted into an instant using the time definition.
 *
 * @return the local time of day of the transition, not null
 * @apiSince 26
 */

public java.time.LocalTime getLocalTime() { throw new RuntimeException("Stub!"); }

/**
 * Is the transition local time midnight at the end of day.
 * <p>
 * The transition may be represented as occurring at 24:00.
 *
 * @return whether a local time of midnight is at the start or end of the day
 * @apiSince 26
 */

public boolean isMidnightEndOfDay() { throw new RuntimeException("Stub!"); }

/**
 * Gets the time definition, specifying how to convert the time to an instant.
 * <p>
 * The local time can be converted to an instant using the standard offset,
 * the wall offset or UTC.
 *
 * @return the time definition, not null
 * @apiSince 26
 */

public java.time.zone.ZoneOffsetTransitionRule.TimeDefinition getTimeDefinition() { throw new RuntimeException("Stub!"); }

/**
 * Gets the standard offset in force at the transition.
 *
 * @return the standard offset, not null
 * @apiSince 26
 */

public java.time.ZoneOffset getStandardOffset() { throw new RuntimeException("Stub!"); }

/**
 * Gets the offset before the transition.
 *
 * @return the offset before, not null
 * @apiSince 26
 */

public java.time.ZoneOffset getOffsetBefore() { throw new RuntimeException("Stub!"); }

/**
 * Gets the offset after the transition.
 *
 * @return the offset after, not null
 * @apiSince 26
 */

public java.time.ZoneOffset getOffsetAfter() { throw new RuntimeException("Stub!"); }

/**
 * Creates a transition instance for the specified year.
 * <p>
 * Calculations are performed using the ISO-8601 chronology.
 *
 * @param year  the year to create a transition for, not null
 * @return the transition instance, not null
 * @apiSince 26
 */

public java.time.zone.ZoneOffsetTransition createTransition(int year) { throw new RuntimeException("Stub!"); }

/**
 * Checks if this object equals another.
 * <p>
 * The entire state of the object is compared.
 *
 * @param otherRule  the other object to compare to, null returns false
 * @return true if equal
 * @apiSince 26
 */

public boolean equals(java.lang.Object otherRule) { throw new RuntimeException("Stub!"); }

/**
 * Returns a suitable hash code.
 *
 * @return the hash code
 * @apiSince 26
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string describing this object.
 *
 * @return a string for debugging, not null
 * @apiSince 26
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
/**
 * A definition of the way a local time can be converted to the actual
 * transition date-time.
 * <p>
 * Time zone rules are expressed in one of three ways:
 * <ul>
 * <li>Relative to UTC</li>
 * <li>Relative to the standard offset in force</li>
 * <li>Relative to the wall offset (what you would see on a clock on the wall)</li>
 * </ul>
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum TimeDefinition {
/**
 * The local date-time is expressed in terms of the UTC offset.
 * @apiSince 26
 */

UTC,
/**
 * The local date-time is expressed in terms of the wall offset.
 * @apiSince 26
 */

WALL,
/**
 * The local date-time is expressed in terms of the standard offset.
 * @apiSince 26
 */

STANDARD;

/**
 * Converts the specified local date-time to the local date-time actually
 * seen on a wall clock.
 * <p>
 * This method converts using the type of this enum.
 * The output is defined relative to the 'before' offset of the transition.
 * <p>
 * The UTC type uses the UTC offset.
 * The STANDARD type uses the standard offset.
 * The WALL type returns the input date-time.
 * The result is intended for use with the wall-offset.
 *
 * @param dateTime  the local date-time, not null
 * @param standardOffset  the standard offset, not null
 * @param wallOffset  the wall offset, not null
 * @return the date-time relative to the wall/before offset, not null
 * @apiSince 26
 */

public java.time.LocalDateTime createDateTime(java.time.LocalDateTime dateTime, java.time.ZoneOffset standardOffset, java.time.ZoneOffset wallOffset) { throw new RuntimeException("Stub!"); }
}

}

