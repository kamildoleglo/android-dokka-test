/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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



package java.nio.file.attribute;

import java.time.Instant;

/**
 * Represents the value of a file's time stamp attribute. For example, it may
 * represent the time that the file was last
 * {@link java.nio.file.attribute.BasicFileAttributes#lastModifiedTime() BasicFileAttributes#lastModifiedTime()},
 * {@link java.nio.file.attribute.BasicFileAttributes#lastAccessTime() BasicFileAttributes#lastAccessTime()},
 * or {@link java.nio.file.attribute.BasicFileAttributes#creationTime() BasicFileAttributes#creationTime()}.
 *
 * <p> Instances of this class are immutable.
 *
 * @since 1.7
 * @see java.nio.file.Files#setLastModifiedTime
 * @see java.nio.file.Files#getLastModifiedTime
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class FileTime implements java.lang.Comparable<java.nio.file.attribute.FileTime> {

private FileTime() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code FileTime} representing a value at the given unit of
 * granularity.
 *
 * @param   value
 *          the value since the epoch (1970-01-01T00:00:00Z); can be
 *          negative
 * @param   unit
 *          the unit of granularity to interpret the value
 *
 * @return  a {@code FileTime} representing the given value
 * @apiSince 26
 */

public static java.nio.file.attribute.FileTime from(long value, java.util.concurrent.TimeUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code FileTime} representing the given value in milliseconds.
 *
 * @param   value
 *          the value, in milliseconds, since the epoch
 *          (1970-01-01T00:00:00Z); can be negative
 *
 * @return  a {@code FileTime} representing the given value
 * @apiSince 26
 */

public static java.nio.file.attribute.FileTime fromMillis(long value) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code FileTime} representing the same point of time value
 * on the time-line as the provided {@code Instant} object.
 *
 * @param   instant
 *          the instant to convert
 * @return  a {@code FileTime} representing the same point on the time-line
 *          as the provided instant
 * @since 1.8
 * @apiSince 26
 */

public static java.nio.file.attribute.FileTime from(java.time.Instant instant) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value at the given unit of granularity.
 *
 * <p> Conversion from a coarser granularity that would numerically overflow
 * saturate to {@code Long.MIN_VALUE} if negative or {@code Long.MAX_VALUE}
 * if positive.
 *
 * @param   unit
 *          the unit of granularity for the return value
 *
 * @return  value in the given unit of granularity, since the epoch
 *          since the epoch (1970-01-01T00:00:00Z); can be negative
 * @apiSince 26
 */

public long to(java.util.concurrent.TimeUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value in milliseconds.
 *
 * <p> Conversion from a coarser granularity that would numerically overflow
 * saturate to {@code Long.MIN_VALUE} if negative or {@code Long.MAX_VALUE}
 * if positive.
 *
 * @return  the value in milliseconds, since the epoch (1970-01-01T00:00:00Z)
 * @apiSince 26
 */

public long toMillis() { throw new RuntimeException("Stub!"); }

/**
 * Converts this {@code FileTime} object to an {@code Instant}.
 *
 * <p> The conversion creates an {@code Instant} that represents the
 * same point on the time-line as this {@code FileTime}.
 *
 * <p> {@code FileTime} can store points on the time-line further in the
 * future and further in the past than {@code Instant}. Conversion
 * from such further time points saturates to {@link java.time.Instant#MIN Instant#MIN} if
 * earlier than {@code Instant.MIN} or {@link java.time.Instant#MAX Instant#MAX} if later
 * than {@code Instant.MAX}.
 *
 * @return  an instant representing the same point on the time-line as
 *          this {@code FileTime} object
 * @since 1.8
 * @apiSince 26
 */

public java.time.Instant toInstant() { throw new RuntimeException("Stub!"); }

/**
 * Tests this {@code FileTime} for equality with the given object.
 *
 * <p> The result is {@code true} if and only if the argument is not {@code
 * null} and is a {@code FileTime} that represents the same time. This
 * method satisfies the general contract of the {@code Object.equals} method.
 *
 * @param   obj
 *          the object to compare with
 *
 * @return  {@code true} if, and only if, the given object is a {@code
 *          FileTime} that represents the same time
 * @apiSince 26
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Computes a hash code for this file time.
 *
 * <p> The hash code is based upon the value represented, and satisfies the
 * general contract of the {@link java.lang.Object#hashCode Object#hashCode} method.
 *
 * @return  the hash-code value
 * @apiSince 26
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Compares the value of two {@code FileTime} objects for order.
 *
 * @param   other
 *          the other {@code FileTime} to be compared
 *
 * @return  {@code 0} if this {@code FileTime} is equal to {@code other}, a
 *          value less than 0 if this {@code FileTime} represents a time
 *          that is before {@code other}, and a value greater than 0 if this
 *          {@code FileTime} represents a time that is after {@code other}
 * @apiSince 26
 */

public int compareTo(java.nio.file.attribute.FileTime other) { throw new RuntimeException("Stub!"); }

/**
 * Returns the string representation of this {@code FileTime}. The string
 * is returned in the <a
 * href="http://www.w3.org/TR/NOTE-datetime">ISO&nbsp;8601</a> format:
 * <pre>
 *     YYYY-MM-DDThh:mm:ss[.s+]Z
 * </pre>
 * where "{@code [.s+]}" represents a dot followed by one of more digits
 * for the decimal fraction of a second. It is only present when the decimal
 * fraction of a second is not zero. For example, {@code
 * FileTime.fromMillis(1234567890000L).toString()} yields {@code
 * "2009-02-13T23:31:30Z"}, and {@code FileTime.fromMillis(1234567890123L).toString()}
 * yields {@code "2009-02-13T23:31:30.123Z"}.
 *
 * <p> A {@code FileTime} is primarily intended to represent the value of a
 * file's time stamp. Where used to represent <i>extreme values</i>, where
 * the year is less than "{@code 0001}" or greater than "{@code 9999}" then
 * this method deviates from ISO 8601 in the same manner as the
 * <a href="http://www.w3.org/TR/xmlschema-2/#deviantformats">XML Schema
 * language</a>. That is, the year may be expanded to more than four digits
 * and may be negative-signed. If more than four digits then leading zeros
 * are not present. The year before "{@code 0001}" is "{@code -0001}".
 *
 * @return  the string representation of this file time
 * @apiSince 26
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

