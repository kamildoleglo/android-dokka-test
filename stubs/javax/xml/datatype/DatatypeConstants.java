/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// $Id: DatatypeConstants.java 446598 2006-09-15 12:55:40Z jeremias $



package javax.xml.datatype;


/**
 * <p>Utility class to contain basic Datatype values as constants.</p>
 *
 * @author <a href="mailto:Jeff.Suttor@Sun.com">Jeff Suttor</a>
 * @version $Revision: 446598 $, $Date: 2006-09-15 05:55:40 -0700 (Fri, 15 Sep 2006) $
 * @since 1.5
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class DatatypeConstants {

private DatatypeConstants() { throw new RuntimeException("Stub!"); }

/**
 * Value for fourth month of year.
 * @apiSince 8
 */

public static final int APRIL = 4; // 0x4

/**
 * Value for eighth month of year.
 * @apiSince 8
 */

public static final int AUGUST = 8; // 0x8

/**
 * <p>Fully qualified name for W3C XML Schema 1.0 datatype <code>date</code>.</p>
 * @apiSince 8
 */

public static final javax.xml.namespace.QName DATE;
static { DATE = null; }

/**
 * <p>Fully qualified name for W3C XML Schema 1.0 datatype <code>dateTime</code>.</p>
 * @apiSince 8
 */

public static final javax.xml.namespace.QName DATETIME;
static { DATETIME = null; }

/**
 * <p>A constant that represents the days field.</p>
 * @apiSince 8
 */

public static final javax.xml.datatype.DatatypeConstants.Field DAYS;
static { DAYS = null; }

/**
 * Value for twelve month of year.
 * @apiSince 8
 */

public static final int DECEMBER = 12; // 0xc

/**
 * <p>Fully qualified name for W3C XML Schema datatype <code>duration</code>.</p>
 * @apiSince 8
 */

public static final javax.xml.namespace.QName DURATION;
static { DURATION = null; }

/**
 * <p>Fully qualified name for XQuery 1.0 and XPath 2.0 datatype <code>dayTimeDuration</code>.</p>
 * @apiSince 8
 */

public static final javax.xml.namespace.QName DURATION_DAYTIME;
static { DURATION_DAYTIME = null; }

/**
 * <p>Fully qualified name for XQuery 1.0 and XPath 2.0 datatype <code>yearMonthDuration</code>.</p>
 * @apiSince 8
 */

public static final javax.xml.namespace.QName DURATION_YEARMONTH;
static { DURATION_YEARMONTH = null; }

/**
 * <p>Comparison result.</p>
 * @apiSince 8
 */

public static final int EQUAL = 0; // 0x0

/**
 * Value for second month of year.
 * @apiSince 8
 */

public static final int FEBRUARY = 2; // 0x2

/**
 * Designation that an "int" field is not set.
 * @apiSince 8
 */

public static final int FIELD_UNDEFINED = -2147483648; // 0x80000000

/**
 * <p>Fully qualified name for W3C XML Schema 1.0 datatype <code>gDay</code>.</p>
 * @apiSince 8
 */

public static final javax.xml.namespace.QName GDAY;
static { GDAY = null; }

/**
 * <p>Fully qualified name for W3C XML Schema 1.0 datatype <code>gMonth</code>.</p>
 * @apiSince 8
 */

public static final javax.xml.namespace.QName GMONTH;
static { GMONTH = null; }

/**
 * <p>Fully qualified name for W3C XML Schema 1.0 datatype <code>gMonthDay</code>.</p>
 * @apiSince 8
 */

public static final javax.xml.namespace.QName GMONTHDAY;
static { GMONTHDAY = null; }

/**
 * <p>Comparison result.</p>
 * @apiSince 8
 */

public static final int GREATER = 1; // 0x1

/**
 * <p>Fully qualified name for W3C XML Schema 1.0 datatype <code>gYear</code>.</p>
 * @apiSince 8
 */

public static final javax.xml.namespace.QName GYEAR;
static { GYEAR = null; }

/**
 * <p>Fully qualified name for W3C XML Schema 1.0 datatype <code>gYearMonth</code>.</p>
 * @apiSince 8
 */

public static final javax.xml.namespace.QName GYEARMONTH;
static { GYEARMONTH = null; }

/**
 * <p>A constant that represents the hours field.</p>
 * @apiSince 8
 */

public static final javax.xml.datatype.DatatypeConstants.Field HOURS;
static { HOURS = null; }

/**
 * <p>Comparison result.</p>
 * @apiSince 8
 */

public static final int INDETERMINATE = 2; // 0x2

/**
 * Value for first month of year.
 * @apiSince 8
 */

public static final int JANUARY = 1; // 0x1

/**
 * Value for seventh month of year.
 * @apiSince 8
 */

public static final int JULY = 7; // 0x7

/**
 * Value for sixth month of year.
 * @apiSince 8
 */

public static final int JUNE = 6; // 0x6

/**
 * <p>Comparison result.</p>
 * @apiSince 8
 */

public static final int LESSER = -1; // 0xffffffff

/**
 * Value for third month of year.
 * @apiSince 8
 */

public static final int MARCH = 3; // 0x3

/**
 * W3C XML Schema max timezone offset is -14:00. Zone offset is in minutes.
 * @apiSince 8
 */

public static final int MAX_TIMEZONE_OFFSET = -840; // 0xfffffcb8

/**
 * Value for fifth month of year.
 * @apiSince 8
 */

public static final int MAY = 5; // 0x5

/**
 * <p>A constant that represents the minutes field.</p>
 * @apiSince 8
 */

public static final javax.xml.datatype.DatatypeConstants.Field MINUTES;
static { MINUTES = null; }

/**
 * W3C XML Schema min timezone offset is +14:00. Zone offset is in minutes.
 * @apiSince 8
 */

public static final int MIN_TIMEZONE_OFFSET = 840; // 0x348

/**
 * <p>A constant that represents the months field.</p>
 * @apiSince 8
 */

public static final javax.xml.datatype.DatatypeConstants.Field MONTHS;
static { MONTHS = null; }

/**
 * Value for eleven month of year.
 * @apiSince 8
 */

public static final int NOVEMBER = 11; // 0xb

/**
 * Value for tenth month of year.
 * @apiSince 8
 */

public static final int OCTOBER = 10; // 0xa

/**
 * <p>A constant that represents the seconds field.</p>
 * @apiSince 8
 */

public static final javax.xml.datatype.DatatypeConstants.Field SECONDS;
static { SECONDS = null; }

/**
 * Value for ninth month of year.
 * @apiSince 8
 */

public static final int SEPTEMBER = 9; // 0x9

/**
 * <p>Fully qualified name for W3C XML Schema 1.0 datatype <code>time</code>.</p>
 * @apiSince 8
 */

public static final javax.xml.namespace.QName TIME;
static { TIME = null; }

/**
 * <p>A constant that represents the years field.</p>
 * @apiSince 8
 */

public static final javax.xml.datatype.DatatypeConstants.Field YEARS;
static { YEARS = null; }
/**
 * Type-safe enum class that represents six fields
 * of the {@link javax.xml.datatype.Duration Duration} class.
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Field {

private Field() { throw new RuntimeException("Stub!"); }

/**
 * Returns a field name in English. This method
 * is intended to be used for debugging/diagnosis
 * and not for display to end-users.
 *
 * @return
 *      a non-null valid String constant.
 * @apiSince 8
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * <p>Get id of this Field.</p>
 *
 * @return Id of field.
 * @apiSince 8
 */

public int getId() { throw new RuntimeException("Stub!"); }
}

}

