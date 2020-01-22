/* GENERATED SOURCE. DO NOT MODIFY. */
// © 2016 and later: Unicode, Inc. and others.
// License & terms of use: http://www.unicode.org/copyright.html#License
/*
**********************************************************************
* Copyright (c) 2004-2013, International Business Machines
* Corporation and others.  All Rights Reserved.
**********************************************************************
* Author: Alan Liu
* Created: April 20, 2004
* Since: ICU 3.0
**********************************************************************
*/

package android.icu.util;


/**
 * An amount of a specified unit, consisting of a Number and a Unit.
 * For example, a length measure consists of a Number and a length
 * unit, such as feet or meters.
 *
 * <p>Measure objects are parsed and formatted by subclasses of
 * MeasureFormat.
 *
 * <p>Measure objects are immutable. All subclasses must guarantee that.
 * (However, subclassing is discouraged.)
 *
 * @see java.lang.Number
 * @see android.icu.util.MeasureUnit
 * @see android.icu.text.MeasureFormat
 * @author Alan Liu
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Measure {

/**
 * Constructs a new object given a number and a unit.
 * @param number the number
 * @param unit the unit
 * @apiSince 24
 */

public Measure(java.lang.Number number, android.icu.util.MeasureUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the given object is equal to this object.
 * @return true if this object is equal to the given object
 * @apiSince 24
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hashcode for this object.
 * @return a 32-bit hash
 * @apiSince 24
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of this object.
 * @return a string representation consisting of the ISO currency
 * code together with the numeric amount
 * @apiSince 24
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Returns the numeric value of this object.
 * @return this object's Number
 * @apiSince 24
 */

public java.lang.Number getNumber() { throw new RuntimeException("Stub!"); }

/**
 * Returns the unit of this object.
 * @return this object's Unit
 * @apiSince 24
 */

public android.icu.util.MeasureUnit getUnit() { throw new RuntimeException("Stub!"); }
}

