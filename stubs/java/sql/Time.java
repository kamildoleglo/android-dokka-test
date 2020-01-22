/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1996, 2004, Oracle and/or its affiliates. All rights reserved.
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



package java.sql;


/**
 * <P>A thin wrapper around the <code>java.util.Date</code> class that allows the JDBC
 * API to identify this as an SQL <code>TIME</code> value. The <code>Time</code>
 * class adds formatting and
 * parsing operations to support the JDBC escape syntax for time
 * values.
 * <p>The date components should be set to the "zero epoch"
 * value of January 1, 1970 and should not be accessed.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Time extends java.util.Date {

/**
 * Constructs a <code>Time</code> object initialized with the
 * given values for the hour, minute, and second.
 * The driver sets the date components to January 1, 1970.
 * Any method that attempts to access the date components of a
 * <code>Time</code> object will throw a
 * <code>java.lang.IllegalArgumentException</code>.
 * <P>
 * The result is undefined if a given argument is out of bounds.
 *
 * @param hour 0 to 23
 * @param minute 0 to 59
 * @param second 0 to 59
 *
 * @deprecated Use the constructor that takes a milliseconds value
 *             in place of this constructor
 * @apiSince 1
 */

@Deprecated
public Time(int hour, int minute, int second) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a <code>Time</code> object using a milliseconds time value.
 *
 * @param time milliseconds since January 1, 1970, 00:00:00 GMT;
 *             a negative number is milliseconds before
 *               January 1, 1970, 00:00:00 GMT
 * @apiSince 1
 */

public Time(long time) { throw new RuntimeException("Stub!"); }

/**
 * Sets a <code>Time</code> object using a milliseconds time value.
 *
 * @param time milliseconds since January 1, 1970, 00:00:00 GMT;
 *             a negative number is milliseconds before
 *               January 1, 1970, 00:00:00 GMT
 * @apiSince 1
 */

public void setTime(long time) { throw new RuntimeException("Stub!"); }

/**
 * Converts a string in JDBC time escape format to a <code>Time</code> value.
 *
 * @param s time in format "hh:mm:ss"
 * @return a corresponding <code>Time</code> object
 * @apiSince 1
 */

public static java.sql.Time valueOf(java.lang.String s) { throw new RuntimeException("Stub!"); }

/**
 * Formats a time in JDBC time escape format.
 *
 * @return a <code>String</code> in hh:mm:ss format
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated This method is deprecated and should not be used because SQL <code>TIME</code>
 * values do not have a year component.
 *
 * @exception java.lang.IllegalArgumentException if this
 *           method is invoked
 * @see #setYear
 * @apiSince 1
 */

@Deprecated
public int getYear() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated This method is deprecated and should not be used because SQL <code>TIME</code>
 * values do not have a month component.
 *
 * @exception java.lang.IllegalArgumentException if this
 *           method is invoked
 * @see #setMonth
 * @apiSince 1
 */

@Deprecated
public int getMonth() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated This method is deprecated and should not be used because SQL <code>TIME</code>
 * values do not have a day component.
 *
 * @exception java.lang.IllegalArgumentException if this
 *           method is invoked
 * @apiSince 1
 */

@Deprecated
public int getDay() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated This method is deprecated and should not be used because SQL <code>TIME</code>
 * values do not have a date component.
 *
 * @exception java.lang.IllegalArgumentException if this
 *           method is invoked
 * @see #setDate
 * @apiSince 1
 */

@Deprecated
public int getDate() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated This method is deprecated and should not be used because SQL <code>TIME</code>
 * values do not have a year component.
 *
 * @exception java.lang.IllegalArgumentException if this
 *           method is invoked
 * @see #getYear
 * @apiSince 1
 */

@Deprecated
public void setYear(int i) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated This method is deprecated and should not be used because SQL <code>TIME</code>
 * values do not have a month component.
 *
 * @exception java.lang.IllegalArgumentException if this
 *           method is invoked
 * @see #getMonth
 * @apiSince 1
 */

@Deprecated
public void setMonth(int i) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated This method is deprecated and should not be used because SQL <code>TIME</code>
 * values do not have a date component.
 *
 * @exception java.lang.IllegalArgumentException if this
 *           method is invoked
 * @see #getDate
 * @apiSince 1
 */

@Deprecated
public void setDate(int i) { throw new RuntimeException("Stub!"); }
}

