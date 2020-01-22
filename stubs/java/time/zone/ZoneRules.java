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

import java.time.LocalDateTime;
import java.util.List;
import java.time.ZoneOffset;
import java.time.Instant;

/**
 * The rules defining how the zone offset varies for a single time-zone.
 * <p>
 * The rules model all the historic and future transitions for a time-zone.
 * {@link java.time.zone.ZoneOffsetTransition ZoneOffsetTransition} is used for known transitions, typically historic.
 * {@link java.time.zone.ZoneOffsetTransitionRule ZoneOffsetTransitionRule} is used for future transitions that are based
 * on the result of an algorithm.
 * <p>
 * The same rules may be shared internally between multiple zone IDs.
 * <p>
 * Serializing an instance of {@code ZoneRules} will store the entire set of rules.
 * It does not store the zone ID as it is not part of the state of this object.
 * <p>
 * A rule implementation may or may not store full information about historic
 * and future transitions, and the information stored is only as accurate as
 * that supplied to the implementation by the rules provider.
 * Applications should treat the data provided as representing the best information
 * available to the implementation of this rule.
 *
 * @implSpec
 * This class is immutable and thread-safe.
 *
 * @since 1.8
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ZoneRules implements java.io.Serializable {

ZoneRules() { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of a ZoneRules.
 *
 * @param baseStandardOffset  the standard offset to use before legal rules were set, not null
 * @param baseWallOffset  the wall offset to use before legal rules were set, not null
 * @param standardOffsetTransitionList  the list of changes to the standard offset, not null
 * @param transitionList  the list of transitions, not null
 * @param lastRules  the recurring last rules, size 16 or less, not null
 * @return the zone rules, not null
 * @apiSince 26
 */

public static java.time.zone.ZoneRules of(java.time.ZoneOffset baseStandardOffset, java.time.ZoneOffset baseWallOffset, java.util.List<java.time.zone.ZoneOffsetTransition> standardOffsetTransitionList, java.util.List<java.time.zone.ZoneOffsetTransition> transitionList, java.util.List<java.time.zone.ZoneOffsetTransitionRule> lastRules) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of ZoneRules that has fixed zone rules.
 *
 * @param offset  the offset this fixed zone rules is based on, not null
 * @return the zone rules, not null
 * @see #isFixedOffset()
 * @apiSince 26
 */

public static java.time.zone.ZoneRules of(java.time.ZoneOffset offset) { throw new RuntimeException("Stub!"); }

/**
 * Checks of the zone rules are fixed, such that the offset never varies.
 *
 * @return true if the time-zone is fixed and the offset never changes
 * @apiSince 26
 */

public boolean isFixedOffset() { throw new RuntimeException("Stub!"); }

/**
 * Gets the offset applicable at the specified instant in these rules.
 * <p>
 * The mapping from an instant to an offset is simple, there is only
 * one valid offset for each instant.
 * This method returns that offset.
 *
 * @param instant  the instant to find the offset for, not null, but null
 *  may be ignored if the rules have a single offset for all instants
 * @return the offset, not null
 * @apiSince 26
 */

public java.time.ZoneOffset getOffset(java.time.Instant instant) { throw new RuntimeException("Stub!"); }

/**
 * Gets a suitable offset for the specified local date-time in these rules.
 * <p>
 * The mapping from a local date-time to an offset is not straightforward.
 * There are three cases:
 * <ul>
 * <li>Normal, with one valid offset. For the vast majority of the year, the normal
 *  case applies, where there is a single valid offset for the local date-time.</li>
 * <li>Gap, with zero valid offsets. This is when clocks jump forward typically
 *  due to the spring daylight savings change from "winter" to "summer".
 *  In a gap there are local date-time values with no valid offset.</li>
 * <li>Overlap, with two valid offsets. This is when clocks are set back typically
 *  due to the autumn daylight savings change from "summer" to "winter".
 *  In an overlap there are local date-time values with two valid offsets.</li>
 * </ul>
 * Thus, for any given local date-time there can be zero, one or two valid offsets.
 * This method returns the single offset in the Normal case, and in the Gap or Overlap
 * case it returns the offset before the transition.
 * <p>
 * Since, in the case of Gap and Overlap, the offset returned is a "best" value, rather
 * than the "correct" value, it should be treated with care. Applications that care
 * about the correct offset should use a combination of this method,
 * {@link #getValidOffsets(java.time.LocalDateTime)} and {@link #getTransition(java.time.LocalDateTime)}.
 *
 * @param localDateTime  the local date-time to query, not null, but null
 *  may be ignored if the rules have a single offset for all instants
 * @return the best available offset for the local date-time, not null
 * @apiSince 26
 */

public java.time.ZoneOffset getOffset(java.time.LocalDateTime localDateTime) { throw new RuntimeException("Stub!"); }

/**
 * Gets the offset applicable at the specified local date-time in these rules.
 * <p>
 * The mapping from a local date-time to an offset is not straightforward.
 * There are three cases:
 * <ul>
 * <li>Normal, with one valid offset. For the vast majority of the year, the normal
 *  case applies, where there is a single valid offset for the local date-time.</li>
 * <li>Gap, with zero valid offsets. This is when clocks jump forward typically
 *  due to the spring daylight savings change from "winter" to "summer".
 *  In a gap there are local date-time values with no valid offset.</li>
 * <li>Overlap, with two valid offsets. This is when clocks are set back typically
 *  due to the autumn daylight savings change from "summer" to "winter".
 *  In an overlap there are local date-time values with two valid offsets.</li>
 * </ul>
 * Thus, for any given local date-time there can be zero, one or two valid offsets.
 * This method returns that list of valid offsets, which is a list of size 0, 1 or 2.
 * In the case where there are two offsets, the earlier offset is returned at index 0
 * and the later offset at index 1.
 * <p>
 * There are various ways to handle the conversion from a {@code LocalDateTime}.
 * One technique, using this method, would be:
 * <pre>
 *  List&lt;ZoneOffset&gt; validOffsets = rules.getOffset(localDT);
 *  if (validOffsets.size() == 1) {
 *    // Normal case: only one valid offset
 *    zoneOffset = validOffsets.get(0);
 *  } else {
 *    // Gap or Overlap: determine what to do from transition (which will be non-null)
 *    ZoneOffsetTransition trans = rules.getTransition(localDT);
 *  }
 * </pre>
 * <p>
 * In theory, it is possible for there to be more than two valid offsets.
 * This would happen if clocks to be put back more than once in quick succession.
 * This has never happened in the history of time-zones and thus has no special handling.
 * However, if it were to happen, then the list would return more than 2 entries.
 *
 * @param localDateTime  the local date-time to query for valid offsets, not null, but null
 *  may be ignored if the rules have a single offset for all instants
 * @return the list of valid offsets, may be immutable, not null
 * @apiSince 26
 */

public java.util.List<java.time.ZoneOffset> getValidOffsets(java.time.LocalDateTime localDateTime) { throw new RuntimeException("Stub!"); }

/**
 * Gets the offset transition applicable at the specified local date-time in these rules.
 * <p>
 * The mapping from a local date-time to an offset is not straightforward.
 * There are three cases:
 * <ul>
 * <li>Normal, with one valid offset. For the vast majority of the year, the normal
 *  case applies, where there is a single valid offset for the local date-time.</li>
 * <li>Gap, with zero valid offsets. This is when clocks jump forward typically
 *  due to the spring daylight savings change from "winter" to "summer".
 *  In a gap there are local date-time values with no valid offset.</li>
 * <li>Overlap, with two valid offsets. This is when clocks are set back typically
 *  due to the autumn daylight savings change from "summer" to "winter".
 *  In an overlap there are local date-time values with two valid offsets.</li>
 * </ul>
 * A transition is used to model the cases of a Gap or Overlap.
 * The Normal case will return null.
 * <p>
 * There are various ways to handle the conversion from a {@code LocalDateTime}.
 * One technique, using this method, would be:
 * <pre>
 *  ZoneOffsetTransition trans = rules.getTransition(localDT);
 *  if (trans == null) {
 *    // Gap or Overlap: determine what to do from transition
 *  } else {
 *    // Normal case: only one valid offset
 *    zoneOffset = rule.getOffset(localDT);
 *  }
 * </pre>
 *
 * @param localDateTime  the local date-time to query for offset transition, not null, but null
 *  may be ignored if the rules have a single offset for all instants
 * @return the offset transition, null if the local date-time is not in transition
 * @apiSince 26
 */

public java.time.zone.ZoneOffsetTransition getTransition(java.time.LocalDateTime localDateTime) { throw new RuntimeException("Stub!"); }

/**
 * Gets the standard offset for the specified instant in this zone.
 * <p>
 * This provides access to historic information on how the standard offset
 * has changed over time.
 * The standard offset is the offset before any daylight saving time is applied.
 * This is typically the offset applicable during winter.
 *
 * @param instant  the instant to find the offset information for, not null, but null
 *  may be ignored if the rules have a single offset for all instants
 * @return the standard offset, not null
 * @apiSince 26
 */

public java.time.ZoneOffset getStandardOffset(java.time.Instant instant) { throw new RuntimeException("Stub!"); }

/**
 * Gets the amount of daylight savings in use for the specified instant in this zone.
 * <p>
 * This provides access to historic information on how the amount of daylight
 * savings has changed over time.
 * This is the difference between the standard offset and the actual offset.
 * Typically the amount is zero during winter and one hour during summer.
 * Time-zones are second-based, so the nanosecond part of the duration will be zero.
 * <p>
 * This default implementation calculates the duration from the
 * {@link #getOffset(java.time.Instant) actual} and
 * {@link #getStandardOffset(java.time.Instant) standard} offsets.
 *
 * @param instant  the instant to find the daylight savings for, not null, but null
 *  may be ignored if the rules have a single offset for all instants
 * @return the difference between the standard and actual offset, not null
 * @apiSince 26
 */

public java.time.Duration getDaylightSavings(java.time.Instant instant) { throw new RuntimeException("Stub!"); }

/**
 * Checks if the specified instant is in daylight savings.
 * <p>
 * This checks if the standard offset and the actual offset are the same
 * for the specified instant.
 * If they are not, it is assumed that daylight savings is in operation.
 * <p>
 * This default implementation compares the {@link #getOffset(java.time.Instant) actual}
 * and {@link #getStandardOffset(java.time.Instant) standard} offsets.
 *
 * @param instant  the instant to find the offset information for, not null, but null
 *  may be ignored if the rules have a single offset for all instants
 * @return the standard offset, not null
 * @apiSince 26
 */

public boolean isDaylightSavings(java.time.Instant instant) { throw new RuntimeException("Stub!"); }

/**
 * Checks if the offset date-time is valid for these rules.
 * <p>
 * To be valid, the local date-time must not be in a gap and the offset
 * must match one of the valid offsets.
 * <p>
 * This default implementation checks if {@link #getValidOffsets(java.time.LocalDateTime)}
 * contains the specified offset.
 *
 * @param localDateTime  the date-time to check, not null, but null
 *  may be ignored if the rules have a single offset for all instants
 * @param offset  the offset to check, null returns false
 * @return true if the offset date-time is valid for these rules
 * @apiSince 26
 */

public boolean isValidOffset(java.time.LocalDateTime localDateTime, java.time.ZoneOffset offset) { throw new RuntimeException("Stub!"); }

/**
 * Gets the next transition after the specified instant.
 * <p>
 * This returns details of the next transition after the specified instant.
 * For example, if the instant represents a point where "Summer" daylight savings time
 * applies, then the method will return the transition to the next "Winter" time.
 *
 * @param instant  the instant to get the next transition after, not null, but null
 *  may be ignored if the rules have a single offset for all instants
 * @return the next transition after the specified instant, null if this is after the last transition
 * @apiSince 26
 */

public java.time.zone.ZoneOffsetTransition nextTransition(java.time.Instant instant) { throw new RuntimeException("Stub!"); }

/**
 * Gets the previous transition before the specified instant.
 * <p>
 * This returns details of the previous transition after the specified instant.
 * For example, if the instant represents a point where "summer" daylight saving time
 * applies, then the method will return the transition from the previous "winter" time.
 *
 * @param instant  the instant to get the previous transition after, not null, but null
 *  may be ignored if the rules have a single offset for all instants
 * @return the previous transition after the specified instant, null if this is before the first transition
 * @apiSince 26
 */

public java.time.zone.ZoneOffsetTransition previousTransition(java.time.Instant instant) { throw new RuntimeException("Stub!"); }

/**
 * Gets the complete list of fully defined transitions.
 * <p>
 * The complete set of transitions for this rules instance is defined by this method
 * and {@link #getTransitionRules()}. This method returns those transitions that have
 * been fully defined. These are typically historical, but may be in the future.
 * <p>
 * The list will be empty for fixed offset rules and for any time-zone where there has
 * only ever been a single offset. The list will also be empty if the transition rules are unknown.
 *
 * @return an immutable list of fully defined transitions, not null
 * @apiSince 26
 */

public java.util.List<java.time.zone.ZoneOffsetTransition> getTransitions() { throw new RuntimeException("Stub!"); }

/**
 * Gets the list of transition rules for years beyond those defined in the transition list.
 * <p>
 * The complete set of transitions for this rules instance is defined by this method
 * and {@link #getTransitions()}. This method returns instances of {@link java.time.zone.ZoneOffsetTransitionRule ZoneOffsetTransitionRule}
 * that define an algorithm for when transitions will occur.
 * <p>
 * For any given {@code ZoneRules}, this list contains the transition rules for years
 * beyond those years that have been fully defined. These rules typically refer to future
 * daylight saving time rule changes.
 * <p>
 * If the zone defines daylight savings into the future, then the list will normally
 * be of size two and hold information about entering and exiting daylight savings.
 * If the zone does not have daylight savings, or information about future changes
 * is uncertain, then the list will be empty.
 * <p>
 * The list will be empty for fixed offset rules and for any time-zone where there is no
 * daylight saving time. The list will also be empty if the transition rules are unknown.
 *
 * @return an immutable list of transition rules, not null
 * @apiSince 26
 */

public java.util.List<java.time.zone.ZoneOffsetTransitionRule> getTransitionRules() { throw new RuntimeException("Stub!"); }

/**
 * Checks if this set of rules equals another.
 * <p>
 * Two rule sets are equal if they will always result in the same output
 * for any given input instant or local date-time.
 * Rules from two different groups may return false even if they are in fact the same.
 * <p>
 * This definition should result in implementations comparing their entire state.
 *
 * @param otherRules  the other rules, null returns false
 * @return true if this rules is the same as that specified
 * @apiSince 26
 */

public boolean equals(java.lang.Object otherRules) { throw new RuntimeException("Stub!"); }

/**
 * Returns a suitable hash code given the definition of {@code #equals}.
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

