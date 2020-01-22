/*
 * Copyright (C) 2009 The Android Open Source Project
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


package android.hardware;


/**
 * Estimates magnetic field at a given point on
 * Earth, and in particular, to compute the magnetic declination from true
 * north.
 *
 * <p>This uses the World Magnetic Model produced by the United States National
 * Geospatial-Intelligence Agency.  More details about the model can be found at
 * <a href="http://www.ngdc.noaa.gov/geomag/WMM/DoDWMM.shtml">http://www.ngdc.noaa.gov/geomag/WMM/DoDWMM.shtml</a>.
 * This class currently uses WMM-2015 which is valid until 2020, but should
 * produce acceptable results for several years after that. Future versions of
 * Android may use a newer version of the model.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class GeomagneticField {

/**
 * Estimate the magnetic field at a given point and time.
 *
 * @param gdLatitudeDeg
 *            Latitude in WGS84 geodetic coordinates -- positive is east.
 * @param gdLongitudeDeg
 *            Longitude in WGS84 geodetic coordinates -- positive is north.
 * @param altitudeMeters
 *            Altitude in WGS84 geodetic coordinates, in meters.
 * @param timeMillis
 *            Time at which to evaluate the declination, in milliseconds
 *            since January 1, 1970. (approximate is fine -- the declination
 *            changes very slowly).
 * @apiSince 3
 */

public GeomagneticField(float gdLatitudeDeg, float gdLongitudeDeg, float altitudeMeters, long timeMillis) { throw new RuntimeException("Stub!"); }

/**
 * @return The X (northward) component of the magnetic field in nanoteslas.
 * @apiSince 3
 */

public float getX() { throw new RuntimeException("Stub!"); }

/**
 * @return The Y (eastward) component of the magnetic field in nanoteslas.
 * @apiSince 3
 */

public float getY() { throw new RuntimeException("Stub!"); }

/**
 * @return The Z (downward) component of the magnetic field in nanoteslas.
 * @apiSince 3
 */

public float getZ() { throw new RuntimeException("Stub!"); }

/**
 * @return The declination of the horizontal component of the magnetic
 *         field from true north, in degrees (i.e. positive means the
 *         magnetic field is rotated east that much from true north).
 * @apiSince 3
 */

public float getDeclination() { throw new RuntimeException("Stub!"); }

/**
 * @return The inclination of the magnetic field in degrees -- positive
 *         means the magnetic field is rotated downwards.
 * @apiSince 3
 */

public float getInclination() { throw new RuntimeException("Stub!"); }

/**
 * @return  Horizontal component of the field strength in nanoteslas.
 * @apiSince 3
 */

public float getHorizontalStrength() { throw new RuntimeException("Stub!"); }

/**
 * @return  Total field strength in nanoteslas.
 * @apiSince 3
 */

public float getFieldStrength() { throw new RuntimeException("Stub!"); }
}

