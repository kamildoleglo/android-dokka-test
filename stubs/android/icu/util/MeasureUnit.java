/* GENERATED SOURCE. DO NOT MODIFY. */
// © 2016 and later: Unicode, Inc. and others.
// License & terms of use: http://www.unicode.org/copyright.html#License
/*
 *******************************************************************************
 * Copyright (C) 2004-2016, Google Inc, International Business Machines
 * Corporation and others. All Rights Reserved.
 *******************************************************************************
 */

package android.icu.util;


/**
 * A unit such as length, mass, volume, currency, etc.  A unit is
 * coupled with a numeric amount to produce a Measure. MeasureUnit objects are immutable.
 * All subclasses must guarantee that. (However, subclassing is discouraged.)
 
 *
 * @see android.icu.util.Measure
 * @author Alan Liu
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MeasureUnit implements java.io.Serializable {

MeasureUnit() { throw new RuntimeException("Stub!"); }

/**
 * Get the type, such as "length"
 * @apiSince 24
 */

public java.lang.String getType() { throw new RuntimeException("Stub!"); }

/**
 * Get the subType, such as “foot”.
 * @apiSince 24
 */

public java.lang.String getSubtype() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 24
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 24
 */

public boolean equals(java.lang.Object rhs) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 24
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Get all of the available units' types. Returned set is unmodifiable.
 * @apiSince 24
 */

public static synchronized java.util.Set<java.lang.String> getAvailableTypes() { throw new RuntimeException("Stub!"); }

/**
 * For the given type, return the available units.
 * @param type the type
 * @return the available units for type. Returned set is unmodifiable.
 * @apiSince 24
 */

public static synchronized java.util.Set<android.icu.util.MeasureUnit> getAvailable(java.lang.String type) { throw new RuntimeException("Stub!"); }

/**
 * Get all of the available units. Returned set is unmodifiable.
 * @apiSince 24
 */

public static synchronized java.util.Set<android.icu.util.MeasureUnit> getAvailable() { throw new RuntimeException("Stub!"); }

/**
 * Constant for unit of area: acre
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit ACRE;
static { ACRE = null; }

/**
 * Constant for unit of volume: acre-foot
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit ACRE_FOOT;
static { ACRE_FOOT = null; }

/**
 * Constant for unit of electric: ampere
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit AMPERE;
static { AMPERE = null; }

/**
 * Constant for unit of angle: arc-minute
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit ARC_MINUTE;
static { ARC_MINUTE = null; }

/**
 * Constant for unit of angle: arc-second
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit ARC_SECOND;
static { ARC_SECOND = null; }

/**
 * Constant for unit of length: astronomical-unit
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit ASTRONOMICAL_UNIT;
static { ASTRONOMICAL_UNIT = null; }

/**
 * Constant for unit of pressure: atmosphere
 * @apiSince R
 */

public static final android.icu.util.MeasureUnit ATMOSPHERE;
static { ATMOSPHERE = null; }

/**
 * Constant for unit of digital: bit
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit BIT;
static { BIT = null; }

/**
 * Constant for unit of volume: bushel
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit BUSHEL;
static { BUSHEL = null; }

/**
 * Constant for unit of digital: byte
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit BYTE;
static { BYTE = null; }

/**
 * Constant for unit of energy: calorie
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit CALORIE;
static { CALORIE = null; }

/**
 * Constant for unit of mass: carat
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit CARAT;
static { CARAT = null; }

/**
 * Constant for unit of temperature: celsius
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit CELSIUS;
static { CELSIUS = null; }

/**
 * Constant for unit of volume: centiliter
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit CENTILITER;
static { CENTILITER = null; }

/**
 * Constant for unit of length: centimeter
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit CENTIMETER;
static { CENTIMETER = null; }

/**
 * Constant for unit of duration: century
 * @apiSince 26
 */

public static final android.icu.util.MeasureUnit CENTURY;
static { CENTURY = null; }

/**
 * Constant for unit of volume: cubic-centimeter
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit CUBIC_CENTIMETER;
static { CUBIC_CENTIMETER = null; }

/**
 * Constant for unit of volume: cubic-foot
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit CUBIC_FOOT;
static { CUBIC_FOOT = null; }

/**
 * Constant for unit of volume: cubic-inch
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit CUBIC_INCH;
static { CUBIC_INCH = null; }

/**
 * Constant for unit of volume: cubic-kilometer
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit CUBIC_KILOMETER;
static { CUBIC_KILOMETER = null; }

/**
 * Constant for unit of volume: cubic-meter
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit CUBIC_METER;
static { CUBIC_METER = null; }

/**
 * Constant for unit of volume: cubic-mile
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit CUBIC_MILE;
static { CUBIC_MILE = null; }

/**
 * Constant for unit of volume: cubic-yard
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit CUBIC_YARD;
static { CUBIC_YARD = null; }

/**
 * Constant for unit of volume: cup
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit CUP;
static { CUP = null; }

/**
 * Constant for unit of volume: cup-metric
 * @apiSince 26
 */

public static final android.icu.util.MeasureUnit CUP_METRIC;
static { CUP_METRIC = null; }

/**
 * Constant for unit of duration: day
 * @apiSince 24
 */

public static final android.icu.util.TimeUnit DAY;
static { DAY = null; }

/**
 * Constant for unit of volume: deciliter
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit DECILITER;
static { DECILITER = null; }

/**
 * Constant for unit of length: decimeter
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit DECIMETER;
static { DECIMETER = null; }

/**
 * Constant for unit of angle: degree
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit DEGREE;
static { DEGREE = null; }

/**
 * Constant for unit of temperature: fahrenheit
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit FAHRENHEIT;
static { FAHRENHEIT = null; }

/**
 * Constant for unit of length: fathom
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit FATHOM;
static { FATHOM = null; }

/**
 * Constant for unit of volume: fluid-ounce
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit FLUID_OUNCE;
static { FLUID_OUNCE = null; }

/**
 * Constant for unit of energy: foodcalorie
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit FOODCALORIE;
static { FOODCALORIE = null; }

/**
 * Constant for unit of length: foot
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit FOOT;
static { FOOT = null; }

/**
 * Constant for unit of length: furlong
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit FURLONG;
static { FURLONG = null; }

/**
 * Constant for unit of volume: gallon
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit GALLON;
static { GALLON = null; }

/**
 * Constant for unit of volume: gallon-imperial
 * @apiSince 28
 */

public static final android.icu.util.MeasureUnit GALLON_IMPERIAL;
static { GALLON_IMPERIAL = null; }

/**
 * Constant for unit of temperature: generic
 * @apiSince 26
 */

public static final android.icu.util.MeasureUnit GENERIC_TEMPERATURE;
static { GENERIC_TEMPERATURE = null; }

/**
 * Constant for unit of digital: gigabit
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit GIGABIT;
static { GIGABIT = null; }

/**
 * Constant for unit of digital: gigabyte
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit GIGABYTE;
static { GIGABYTE = null; }

/**
 * Constant for unit of frequency: gigahertz
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit GIGAHERTZ;
static { GIGAHERTZ = null; }

/**
 * Constant for unit of power: gigawatt
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit GIGAWATT;
static { GIGAWATT = null; }

/**
 * Constant for unit of mass: gram
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit GRAM;
static { GRAM = null; }

/**
 * Constant for unit of acceleration: g-force
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit G_FORCE;
static { G_FORCE = null; }

/**
 * Constant for unit of area: hectare
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit HECTARE;
static { HECTARE = null; }

/**
 * Constant for unit of volume: hectoliter
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit HECTOLITER;
static { HECTOLITER = null; }

/**
 * Constant for unit of pressure: hectopascal
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit HECTOPASCAL;
static { HECTOPASCAL = null; }

/**
 * Constant for unit of frequency: hertz
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit HERTZ;
static { HERTZ = null; }

/**
 * Constant for unit of power: horsepower
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit HORSEPOWER;
static { HORSEPOWER = null; }

/**
 * Constant for unit of duration: hour
 * @apiSince 24
 */

public static final android.icu.util.TimeUnit HOUR;
static { HOUR = null; }

/**
 * Constant for unit of length: inch
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit INCH;
static { INCH = null; }

/**
 * Constant for unit of pressure: inch-hg
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit INCH_HG;
static { INCH_HG = null; }

/**
 * Constant for unit of energy: joule
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit JOULE;
static { JOULE = null; }

/**
 * Constant for unit of concentr: karat
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit KARAT;
static { KARAT = null; }

/**
 * Constant for unit of temperature: kelvin
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit KELVIN;
static { KELVIN = null; }

/**
 * Constant for unit of digital: kilobit
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit KILOBIT;
static { KILOBIT = null; }

/**
 * Constant for unit of digital: kilobyte
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit KILOBYTE;
static { KILOBYTE = null; }

/**
 * Constant for unit of energy: kilocalorie
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit KILOCALORIE;
static { KILOCALORIE = null; }

/**
 * Constant for unit of mass: kilogram
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit KILOGRAM;
static { KILOGRAM = null; }

/**
 * Constant for unit of frequency: kilohertz
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit KILOHERTZ;
static { KILOHERTZ = null; }

/**
 * Constant for unit of energy: kilojoule
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit KILOJOULE;
static { KILOJOULE = null; }

/**
 * Constant for unit of length: kilometer
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit KILOMETER;
static { KILOMETER = null; }

/**
 * Constant for unit of speed: kilometer-per-hour
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit KILOMETER_PER_HOUR;
static { KILOMETER_PER_HOUR = null; }

/**
 * Constant for unit of power: kilowatt
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit KILOWATT;
static { KILOWATT = null; }

/**
 * Constant for unit of energy: kilowatt-hour
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit KILOWATT_HOUR;
static { KILOWATT_HOUR = null; }

/**
 * Constant for unit of speed: knot
 * @apiSince 26
 */

public static final android.icu.util.MeasureUnit KNOT;
static { KNOT = null; }

/**
 * Constant for unit of length: light-year
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit LIGHT_YEAR;
static { LIGHT_YEAR = null; }

/**
 * Constant for unit of volume: liter
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit LITER;
static { LITER = null; }

/**
 * Constant for unit of consumption: liter-per-100kilometers
 * @apiSince 26
 */

public static final android.icu.util.MeasureUnit LITER_PER_100KILOMETERS;
static { LITER_PER_100KILOMETERS = null; }

/**
 * Constant for unit of consumption: liter-per-kilometer
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit LITER_PER_KILOMETER;
static { LITER_PER_KILOMETER = null; }

/**
 * Constant for unit of light: lux
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit LUX;
static { LUX = null; }

/**
 * Constant for unit of digital: megabit
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit MEGABIT;
static { MEGABIT = null; }

/**
 * Constant for unit of digital: megabyte
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit MEGABYTE;
static { MEGABYTE = null; }

/**
 * Constant for unit of frequency: megahertz
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit MEGAHERTZ;
static { MEGAHERTZ = null; }

/**
 * Constant for unit of volume: megaliter
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit MEGALITER;
static { MEGALITER = null; }

/**
 * Constant for unit of power: megawatt
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit MEGAWATT;
static { MEGAWATT = null; }

/**
 * Constant for unit of length: meter
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit METER;
static { METER = null; }

/**
 * Constant for unit of speed: meter-per-second
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit METER_PER_SECOND;
static { METER_PER_SECOND = null; }

/**
 * Constant for unit of acceleration: meter-per-second-squared
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit METER_PER_SECOND_SQUARED;
static { METER_PER_SECOND_SQUARED = null; }

/**
 * Constant for unit of mass: metric-ton
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit METRIC_TON;
static { METRIC_TON = null; }

/**
 * Constant for unit of mass: microgram
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit MICROGRAM;
static { MICROGRAM = null; }

/**
 * Constant for unit of length: micrometer
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit MICROMETER;
static { MICROMETER = null; }

/**
 * Constant for unit of duration: microsecond
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit MICROSECOND;
static { MICROSECOND = null; }

/**
 * Constant for unit of length: mile
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit MILE;
static { MILE = null; }

/**
 * Constant for unit of consumption: mile-per-gallon
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit MILE_PER_GALLON;
static { MILE_PER_GALLON = null; }

/**
 * Constant for unit of consumption: mile-per-gallon-imperial
 * @apiSince 28
 */

public static final android.icu.util.MeasureUnit MILE_PER_GALLON_IMPERIAL;
static { MILE_PER_GALLON_IMPERIAL = null; }

/**
 * Constant for unit of speed: mile-per-hour
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit MILE_PER_HOUR;
static { MILE_PER_HOUR = null; }

/**
 * Constant for unit of length: mile-scandinavian
 * @apiSince 26
 */

public static final android.icu.util.MeasureUnit MILE_SCANDINAVIAN;
static { MILE_SCANDINAVIAN = null; }

/**
 * Constant for unit of electric: milliampere
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit MILLIAMPERE;
static { MILLIAMPERE = null; }

/**
 * Constant for unit of pressure: millibar
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit MILLIBAR;
static { MILLIBAR = null; }

/**
 * Constant for unit of mass: milligram
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit MILLIGRAM;
static { MILLIGRAM = null; }

/**
 * Constant for unit of concentr: milligram-per-deciliter
 * @apiSince 28
 */

public static final android.icu.util.MeasureUnit MILLIGRAM_PER_DECILITER;
static { MILLIGRAM_PER_DECILITER = null; }

/**
 * Constant for unit of volume: milliliter
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit MILLILITER;
static { MILLILITER = null; }

/**
 * Constant for unit of length: millimeter
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit MILLIMETER;
static { MILLIMETER = null; }

/**
 * Constant for unit of pressure: millimeter-of-mercury
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit MILLIMETER_OF_MERCURY;
static { MILLIMETER_OF_MERCURY = null; }

/**
 * Constant for unit of concentr: millimole-per-liter
 * @apiSince 28
 */

public static final android.icu.util.MeasureUnit MILLIMOLE_PER_LITER;
static { MILLIMOLE_PER_LITER = null; }

/**
 * Constant for unit of duration: millisecond
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit MILLISECOND;
static { MILLISECOND = null; }

/**
 * Constant for unit of power: milliwatt
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit MILLIWATT;
static { MILLIWATT = null; }

/**
 * Constant for unit of duration: minute
 * @apiSince 24
 */

public static final android.icu.util.TimeUnit MINUTE;
static { MINUTE = null; }

/**
 * Constant for unit of duration: month
 * @apiSince 24
 */

public static final android.icu.util.TimeUnit MONTH;
static { MONTH = null; }

/**
 * Constant for unit of length: nanometer
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit NANOMETER;
static { NANOMETER = null; }

/**
 * Constant for unit of duration: nanosecond
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit NANOSECOND;
static { NANOSECOND = null; }

/**
 * Constant for unit of length: nautical-mile
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit NAUTICAL_MILE;
static { NAUTICAL_MILE = null; }

/**
 * Constant for unit of electric: ohm
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit OHM;
static { OHM = null; }

/**
 * Constant for unit of mass: ounce
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit OUNCE;
static { OUNCE = null; }

/**
 * Constant for unit of mass: ounce-troy
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit OUNCE_TROY;
static { OUNCE_TROY = null; }

/**
 * Constant for unit of length: parsec
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit PARSEC;
static { PARSEC = null; }

/**
 * Constant for unit of concentr: part-per-million
 * @apiSince 28
 */

public static final android.icu.util.MeasureUnit PART_PER_MILLION;
static { PART_PER_MILLION = null; }

/**
 * Constant for unit of concentr: percent
 * @apiSince R
 */

public static final android.icu.util.MeasureUnit PERCENT;
static { PERCENT = null; }

/**
 * Constant for unit of concentr: permille
 * @apiSince R
 */

public static final android.icu.util.MeasureUnit PERMILLE;
static { PERMILLE = null; }

/**
 * Constant for unit of digital: petabyte
 * @apiSince R
 */

public static final android.icu.util.MeasureUnit PETABYTE;
static { PETABYTE = null; }

/**
 * Constant for unit of length: picometer
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit PICOMETER;
static { PICOMETER = null; }

/**
 * Constant for unit of volume: pint
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit PINT;
static { PINT = null; }

/**
 * Constant for unit of volume: pint-metric
 * @apiSince 26
 */

public static final android.icu.util.MeasureUnit PINT_METRIC;
static { PINT_METRIC = null; }

/**
 * Constant for unit of length: point
 * @apiSince 29
 */

public static final android.icu.util.MeasureUnit POINT;
static { POINT = null; }

/**
 * Constant for unit of mass: pound
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit POUND;
static { POUND = null; }

/**
 * Constant for unit of pressure: pound-per-square-inch
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit POUND_PER_SQUARE_INCH;
static { POUND_PER_SQUARE_INCH = null; }

/**
 * Constant for unit of volume: quart
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit QUART;
static { QUART = null; }

/**
 * Constant for unit of angle: radian
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit RADIAN;
static { RADIAN = null; }

/**
 * Constant for unit of angle: revolution
 * @apiSince 26
 */

public static final android.icu.util.MeasureUnit REVOLUTION_ANGLE;
static { REVOLUTION_ANGLE = null; }

/**
 * Constant for unit of duration: second
 * @apiSince 24
 */

public static final android.icu.util.TimeUnit SECOND;
static { SECOND = null; }

/**
 * Constant for unit of area: square-centimeter
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit SQUARE_CENTIMETER;
static { SQUARE_CENTIMETER = null; }

/**
 * Constant for unit of area: square-foot
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit SQUARE_FOOT;
static { SQUARE_FOOT = null; }

/**
 * Constant for unit of area: square-inch
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit SQUARE_INCH;
static { SQUARE_INCH = null; }

/**
 * Constant for unit of area: square-kilometer
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit SQUARE_KILOMETER;
static { SQUARE_KILOMETER = null; }

/**
 * Constant for unit of area: square-meter
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit SQUARE_METER;
static { SQUARE_METER = null; }

/**
 * Constant for unit of area: square-mile
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit SQUARE_MILE;
static { SQUARE_MILE = null; }

/**
 * Constant for unit of area: square-yard
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit SQUARE_YARD;
static { SQUARE_YARD = null; }

/**
 * Constant for unit of mass: stone
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit STONE;
static { STONE = null; }

/**
 * Constant for unit of volume: tablespoon
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit TABLESPOON;
static { TABLESPOON = null; }

/**
 * Constant for unit of volume: teaspoon
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit TEASPOON;
static { TEASPOON = null; }

/**
 * Constant for unit of digital: terabit
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit TERABIT;
static { TERABIT = null; }

/**
 * Constant for unit of digital: terabyte
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit TERABYTE;
static { TERABYTE = null; }

/**
 * Constant for unit of mass: ton
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit TON;
static { TON = null; }

/**
 * Constant for unit of electric: volt
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit VOLT;
static { VOLT = null; }

/**
 * Constant for unit of power: watt
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit WATT;
static { WATT = null; }

/**
 * Constant for unit of duration: week
 * @apiSince 24
 */

public static final android.icu.util.TimeUnit WEEK;
static { WEEK = null; }

/**
 * Constant for unit of length: yard
 * @apiSince 24
 */

public static final android.icu.util.MeasureUnit YARD;
static { YARD = null; }

/**
 * Constant for unit of duration: year
 * @apiSince 24
 */

public static final android.icu.util.TimeUnit YEAR;
static { YEAR = null; }
}

