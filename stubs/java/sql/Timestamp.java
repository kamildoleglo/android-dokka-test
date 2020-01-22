/*
 * Copyright (c) 1996, 2011, Oracle and/or its affiliates. All rights reserved.
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
 * <P>A thin wrapper around <code>java.util.Date</code> that allows
 * the JDBC API to identify this as an SQL <code>TIMESTAMP</code> value.
 * It adds the ability
 * to hold the SQL <code>TIMESTAMP</code> fractional seconds value, by allowing
 * the specification of fractional seconds to a precision of nanoseconds.
 * A Timestamp also provides formatting and
 * parsing operations to support the JDBC escape syntax for timestamp values.
 *
 * <p>The precision of a Timestamp object is calculated to be either:
 * <ul>
 * <li><code>19 </code>, which is the number of characters in yyyy-mm-dd hh:mm:ss
 * <li> <code> 20 + s </code>, which is the number
 * of characters in the yyyy-mm-dd hh:mm:ss.[fff...] and <code>s</code> represents  the scale of the given Timestamp,
 * its fractional seconds precision.
 *</ul>
 *
 * <P><B>Note:</B> This type is a composite of a <code>java.util.Date</code> and a
 * separate nanoseconds value. Only integral seconds are stored in the
 * <code>java.util.Date</code> component. The fractional seconds - the nanos - are
 * separate.  The <code>Timestamp.equals(Object)</code> method never returns
 * <code>true</code> when passed an object
 * that isn't an instance of <code>java.sql.Timestamp</code>,
 * because the nanos component of a date is unknown.
 * As a result, the <code>Timestamp.equals(Object)</code>
 * method is not symmetric with respect to the
 * <code>java.util.Date.equals(Object)</code>
 * method.  Also, the <code>hashCode</code> method uses the underlying
 * <code>java.util.Date</code>
 * implementation and therefore does not include nanos in its computation.
 * <P>
 * Due to the differences between the <code>Timestamp</code> class
 * and the <code>java.util.Date</code>
 * class mentioned above, it is recommended that code not view
 * <code>Timestamp</code> values generically as an instance of
 * <code>java.util.Date</code>.  The
 * inheritance relationship between <code>Timestamp</code>
 * and <code>java.util.Date</code> really
 * denotes implementation inheritance, and not type inheritance.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Timestamp extends java.util.Date {

/**
 * Constructs a <code>Timestamp</code> object initialized
 * with the given values.
 *
 * @param year the year minus 1900
 * @param month 0 to 11
 * @param date 1 to 31
 * @param hour 0 to 23
 * @param minute 0 to 59
 * @param second 0 to 59
 * @param nano 0 to 999,999,999
 * @deprecated instead use the constructor <code>Timestamp(long millis)</code>
 * @exception java.lang.IllegalArgumentException if the nano argument is out of bounds
 * @apiSince 1
 */

@Deprecated
public Timestamp(int year, int month, int date, int hour, int minute, int second, int nano) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a <code>Timestamp</code> object
 * using a milliseconds time value. The
 * integral seconds are stored in the underlying date value; the
 * fractional seconds are stored in the <code>nanos</code> field of
 * the <code>Timestamp</code> object.
 *
 * @param time milliseconds since January 1, 1970, 00:00:00 GMT.
 *        A negative number is the number of milliseconds before
 *         January 1, 1970, 00:00:00 GMT.
 * @see java.util.Calendar
 * @apiSince 1
 */

public Timestamp(long time) { throw new RuntimeException("Stub!"); }

/**
 * Sets this <code>Timestamp</code> object to represent a point in time that is
 * <tt>time</tt> milliseconds after January 1, 1970 00:00:00 GMT.
 *
 * @param time   the number of milliseconds.
 * @see #getTime
 * @see #Timestamp(long time)
 * @see java.util.Calendar
 * @apiSince 1
 */

public void setTime(long time) { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of milliseconds since January 1, 1970, 00:00:00 GMT
 * represented by this <code>Timestamp</code> object.
 *
 * @return  the number of milliseconds since January 1, 1970, 00:00:00 GMT
 *          represented by this date.
 * @see #setTime
 * @apiSince 1
 */

public long getTime() { throw new RuntimeException("Stub!"); }

/**
 * Converts a <code>String</code> object in JDBC timestamp escape format to a
 * <code>Timestamp</code> value.
 *
 * @param s timestamp in format <code>yyyy-[m]m-[d]d hh:mm:ss[.f...]</code>.  The
 * fractional seconds may be omitted. The leading zero for <code>mm</code>
 * and <code>dd</code> may also be omitted.
 *
 * @return corresponding <code>Timestamp</code> value
 * @exception java.lang.IllegalArgumentException if the given argument
 * does not have the format <code>yyyy-[m]m-[d]d hh:mm:ss[.f...]</code>
 * @apiSince 1
 */

public static java.sql.Timestamp valueOf(java.lang.String s) { throw new RuntimeException("Stub!"); }

/**
 * Formats a timestamp in JDBC timestamp escape format.
 *         <code>yyyy-mm-dd hh:mm:ss.fffffffff</code>,
 * where <code>ffffffffff</code> indicates nanoseconds.
 * <P>
 * @return a <code>String</code> object in
 *           <code>yyyy-mm-dd hh:mm:ss.fffffffff</code> format
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Gets this <code>Timestamp</code> object's <code>nanos</code> value.
 *
 * @return this <code>Timestamp</code> object's fractional seconds component
 * @see #setNanos
 * @apiSince 1
 */

public int getNanos() { throw new RuntimeException("Stub!"); }

/**
 * Sets this <code>Timestamp</code> object's <code>nanos</code> field
 * to the given value.
 *
 * @param n the new fractional seconds component
 * @exception java.lang.IllegalArgumentException if the given argument
 *            is greater than 999999999 or less than 0
 * @see #getNanos
 * @apiSince 1
 */

public void setNanos(int n) { throw new RuntimeException("Stub!"); }

/**
 * Tests to see if this <code>Timestamp</code> object is
 * equal to the given <code>Timestamp</code> object.
 *
 * @param ts the <code>Timestamp</code> value to compare with
 * @return <code>true</code> if the given <code>Timestamp</code>
 *         object is equal to this <code>Timestamp</code> object;
 *         <code>false</code> otherwise
 * @apiSince 1
 */

public boolean equals(java.sql.Timestamp ts) { throw new RuntimeException("Stub!"); }

/**
 * Tests to see if this <code>Timestamp</code> object is
 * equal to the given object.
 *
 * This version of the method <code>equals</code> has been added
 * to fix the incorrect
 * signature of <code>Timestamp.equals(Timestamp)</code> and to preserve backward
 * compatibility with existing class files.
 *
 * Note: This method is not symmetric with respect to the
 * <code>equals(Object)</code> method in the base class.
 *
 * @param ts the <code>Object</code> value to compare with
 * @return <code>true</code> if the given <code>Object</code> is an instance
 *         of a <code>Timestamp</code> that
 *         is equal to this <code>Timestamp</code> object;
 *         <code>false</code> otherwise
 * @apiSince 1
 */

public boolean equals(java.lang.Object ts) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether this <code>Timestamp</code> object is
 * earlier than the given <code>Timestamp</code> object.
 *
 * @param ts the <code>Timestamp</code> value to compare with
 * @return <code>true</code> if this <code>Timestamp</code> object is earlier;
 *        <code>false</code> otherwise
 * @apiSince 1
 */

public boolean before(java.sql.Timestamp ts) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether this <code>Timestamp</code> object is
 * later than the given <code>Timestamp</code> object.
 *
 * @param ts the <code>Timestamp</code> value to compare with
 * @return <code>true</code> if this <code>Timestamp</code> object is later;
 *        <code>false</code> otherwise
 * @apiSince 1
 */

public boolean after(java.sql.Timestamp ts) { throw new RuntimeException("Stub!"); }

/**
 * Compares this <code>Timestamp</code> object to the given
 * <code>Timestamp</code> object.
 *
 * @param   ts   the <code>Timestamp</code> object to be compared to
 *                this <code>Timestamp</code> object
 * @return  the value <code>0</code> if the two <code>Timestamp</code>
 *          objects are equal; a value less than <code>0</code> if this
 *          <code>Timestamp</code> object is before the given argument;
 *          and a value greater than <code>0</code> if this
 *          <code>Timestamp</code> object is after the given argument.
 * @since   1.4
 * @apiSince 1
 */

public int compareTo(java.sql.Timestamp ts) { throw new RuntimeException("Stub!"); }

/**
 * Compares this <code>Timestamp</code> object to the given
 * <code>Date</code> object.
 *
 * @param o the <code>Date</code> to be compared to
 *          this <code>Timestamp</code> object
 * @return  the value <code>0</code> if this <code>Timestamp</code> object
 *          and the given object are equal; a value less than <code>0</code>
 *          if this  <code>Timestamp</code> object is before the given argument;
 *          and a value greater than <code>0</code> if this
 *          <code>Timestamp</code> object is after the given argument.
 *
 * @since   1.5
 * @apiSince 1
 */

public int compareTo(java.util.Date o) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * The {@code hashCode} method uses the underlying {@code java.util.Date}
 * implementation and therefore does not include nanos in its computation.
 *
 * @apiSince 1
 */

public int hashCode() { throw new RuntimeException("Stub!"); }
}

