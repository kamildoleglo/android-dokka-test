/*
 * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
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
 * A transition between two offsets caused by a discontinuity in the local time-line.
 * <p>
 * A transition between two offsets is normally the result of a daylight savings cutover.
 * The discontinuity is normally a gap in spring and an overlap in autumn.
 * {@code ZoneOffsetTransition} models the transition between the two offsets.
 * <p>
 * Gaps occur where there are local date-times that simply do not exist.
 * An example would be when the offset changes from {@code +03:00} to {@code +04:00}.
 * This might be described as 'the clocks will move forward one hour tonight at 1am'.
 * <p>
 * Overlaps occur where there are local date-times that exist twice.
 * An example would be when the offset changes from {@code +04:00} to {@code +03:00}.
 * This might be described as 'the clocks will move back one hour tonight at 2am'.
 *
 * @implSpec
 * This class is immutable and thread-safe.
 *
 * @since 1.8
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ZoneOffsetTransition implements java.lang.Comparable<java.time.zone.ZoneOffsetTransition>, java.io.Serializable {

ZoneOffsetTransition() { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance defining a transition between two offsets.
 * <p>
 * Applications should normally obtain an instance from {@link java.time.zone.ZoneRules ZoneRules}.
 * This factory is only intended for use when creating {@link java.time.zone.ZoneRules ZoneRules}.
 *
 * @param transition  the transition date-time at the transition, which never
 *  actually occurs, expressed local to the before offset, not null
 * @param offsetBefore  the offset before the transition, not null
 * @param offsetAfter  the offset at and after the transition, not null
 * @return the transition, not null
 * @throws java.lang.IllegalArgumentException if {@code offsetBefore} and {@code offsetAfter}
 *         are equal, or {@code transition.getNano()} returns non-zero value
 * @apiSince 26
 */

public static java.time.zone.ZoneOffsetTransition of(java.time.LocalDateTime transition, java.time.ZoneOffset offsetBefore, java.time.ZoneOffset offsetAfter) { throw new RuntimeException("Stub!"); }

/**
 * Gets the transition instant.
 * <p>
 * This is the instant of the discontinuity, which is defined as the first
 * instant that the 'after' offset applies.
 * <p>
 * The methods {@link #getInstant()}, {@link #getDateTimeBefore()} and {@link #getDateTimeAfter()}
 * all represent the same instant.
 *
 * @return the transition instant, not null
 * @apiSince 26
 */

public java.time.Instant getInstant() { throw new RuntimeException("Stub!"); }

/**
 * Gets the transition instant as an epoch second.
 *
 * @return the transition epoch second
 * @apiSince 26
 */

public long toEpochSecond() { throw new RuntimeException("Stub!"); }

/**
 * Gets the local transition date-time, as would be expressed with the 'before' offset.
 * <p>
 * This is the date-time where the discontinuity begins expressed with the 'before' offset.
 * At this instant, the 'after' offset is actually used, therefore the combination of this
 * date-time and the 'before' offset will never occur.
 * <p>
 * The combination of the 'before' date-time and offset represents the same instant
 * as the 'after' date-time and offset.
 *
 * @return the transition date-time expressed with the before offset, not null
 * @apiSince 26
 */

public java.time.LocalDateTime getDateTimeBefore() { throw new RuntimeException("Stub!"); }

/**
 * Gets the local transition date-time, as would be expressed with the 'after' offset.
 * <p>
 * This is the first date-time after the discontinuity, when the new offset applies.
 * <p>
 * The combination of the 'before' date-time and offset represents the same instant
 * as the 'after' date-time and offset.
 *
 * @return the transition date-time expressed with the after offset, not null
 * @apiSince 26
 */

public java.time.LocalDateTime getDateTimeAfter() { throw new RuntimeException("Stub!"); }

/**
 * Gets the offset before the transition.
 * <p>
 * This is the offset in use before the instant of the transition.
 *
 * @return the offset before the transition, not null
 * @apiSince 26
 */

public java.time.ZoneOffset getOffsetBefore() { throw new RuntimeException("Stub!"); }

/**
 * Gets the offset after the transition.
 * <p>
 * This is the offset in use on and after the instant of the transition.
 *
 * @return the offset after the transition, not null
 * @apiSince 26
 */

public java.time.ZoneOffset getOffsetAfter() { throw new RuntimeException("Stub!"); }

/**
 * Gets the duration of the transition.
 * <p>
 * In most cases, the transition duration is one hour, however this is not always the case.
 * The duration will be positive for a gap and negative for an overlap.
 * Time-zones are second-based, so the nanosecond part of the duration will be zero.
 *
 * @return the duration of the transition, positive for gaps, negative for overlaps
 * @apiSince 26
 */

public java.time.Duration getDuration() { throw new RuntimeException("Stub!"); }

/**
 * Does this transition represent a gap in the local time-line.
 * <p>
 * Gaps occur where there are local date-times that simply do not exist.
 * An example would be when the offset changes from {@code +01:00} to {@code +02:00}.
 * This might be described as 'the clocks will move forward one hour tonight at 1am'.
 *
 * @return true if this transition is a gap, false if it is an overlap
 * @apiSince 26
 */

public boolean isGap() { throw new RuntimeException("Stub!"); }

/**
 * Does this transition represent an overlap in the local time-line.
 * <p>
 * Overlaps occur where there are local date-times that exist twice.
 * An example would be when the offset changes from {@code +02:00} to {@code +01:00}.
 * This might be described as 'the clocks will move back one hour tonight at 2am'.
 *
 * @return true if this transition is an overlap, false if it is a gap
 * @apiSince 26
 */

public boolean isOverlap() { throw new RuntimeException("Stub!"); }

/**
 * Checks if the specified offset is valid during this transition.
 * <p>
 * This checks to see if the given offset will be valid at some point in the transition.
 * A gap will always return false.
 * An overlap will return true if the offset is either the before or after offset.
 *
 * @param offset  the offset to check, null returns false
 * @return true if the offset is valid during the transition
 * @apiSince 26
 */

public boolean isValidOffset(java.time.ZoneOffset offset) { throw new RuntimeException("Stub!"); }

/**
 * Compares this transition to another based on the transition instant.
 * <p>
 * This compares the instants of each transition.
 * The offsets are ignored, making this order inconsistent with equals.
 *
 * @param transition  the transition to compare to, not null
 * @return the comparator value, negative if less, positive if greater
 * @apiSince 26
 */

public int compareTo(java.time.zone.ZoneOffsetTransition transition) { throw new RuntimeException("Stub!"); }

/**
 * Checks if this object equals another.
 * <p>
 * The entire state of the object is compared.
 *
 * @param other  the other object to compare to, null returns false
 * @return true if equal
 * @apiSince 26
 */

public boolean equals(java.lang.Object other) { throw new RuntimeException("Stub!"); }

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
}

