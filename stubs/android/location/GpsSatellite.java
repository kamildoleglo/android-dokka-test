/*
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package android.location;


/**
 * This class represents the current state of a GPS satellite.
 *
 * This class is used in conjunction with the {@link android.location.GpsStatus GpsStatus} class.
 *
 * @deprecated use {@link android.location.GnssStatus GnssStatus} and {@link android.location.GnssStatus.Callback GnssStatus.Callback}.
 * @apiSince 3
 * @deprecatedSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public final class GpsSatellite {

GpsSatellite() { throw new RuntimeException("Stub!"); }

/**
 * Returns the PRN (pseudo-random number) for the satellite.
 *
 * @return PRN number
 * @apiSince 3
 * @deprecatedSince 24
 */

@Deprecated
public int getPrn() { throw new RuntimeException("Stub!"); }

/**
 * Returns the signal to noise ratio for the satellite.
 *
 * @return the signal to noise ratio
 * @apiSince 3
 * @deprecatedSince 24
 */

@Deprecated
public float getSnr() { throw new RuntimeException("Stub!"); }

/**
 * Returns the elevation of the satellite in degrees.
 * The elevation can vary between 0 and 90.
 *
 * @return the elevation in degrees
 * @apiSince 3
 * @deprecatedSince 24
 */

@Deprecated
public float getElevation() { throw new RuntimeException("Stub!"); }

/**
 * Returns the azimuth of the satellite in degrees.
 * The azimuth can vary between 0 and 360.
 *
 * @return the azimuth in degrees
 * @apiSince 3
 * @deprecatedSince 24
 */

@Deprecated
public float getAzimuth() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the GPS engine has ephemeris data for the satellite.
 *
 * @return true if the satellite has ephemeris data
 * @apiSince 3
 * @deprecatedSince 24
 */

@Deprecated
public boolean hasEphemeris() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the GPS engine has almanac data for the satellite.
 *
 * @return true if the satellite has almanac data
 * @apiSince 3
 * @deprecatedSince 24
 */

@Deprecated
public boolean hasAlmanac() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the satellite was used by the GPS engine when
 * calculating the most recent GPS fix.
 *
 * @return true if the satellite was used to compute the most recent fix.
 * @apiSince 3
 * @deprecatedSince 24
 */

@Deprecated
public boolean usedInFix() { throw new RuntimeException("Stub!"); }
}

