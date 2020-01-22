/*
 * Copyright (C) 2018 The Android Open Source Project
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


package android.net.wifi.rtt;

import android.location.Location;
import android.location.Address;
import android.util.SparseArray;

/**
 * ResponderLocation is both a Location Configuration Information (LCI) decoder and a Location Civic
 * Report (LCR) decoder for information received from a Wi-Fi Access Point (AP) during Wi-Fi RTT
 * ranging process.
 *
 * <p>This is based on the IEEE P802.11-REVmc/D8.0 spec section 9.4.2.22, under Measurement Report
 * Element. Subelement location data-fields parsed from separate input LCI and LCR Information
 * Elements are unified in this class.</p>
 *
 * <p>Note: The information provided by this class is broadcast by a responder (usually an Access
 * Point), and passed on as-is. There is no guarantee this information is accurate or correct, and
 * as a result developers should carefully consider how this information should be used and provide
 * corresponding advice to users.</p>
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ResponderLocation implements android.os.Parcelable {

ResponderLocation() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * @return true if the LCI subelement (containing Latitude, Longitude and Altitude) is valid.
 *
 * <p> This method tells us if the responder has provided its Location Configuration
 * Information (LCI) directly, and is useful when an external database of responder locations
 * is not available</p>
 *
 * <p>If isLciSubelementValid() returns true, all the LCI values provided by the corresponding
 * getter methods will have been set as described by the responder, or else if false, they
 * should not be used and will throw an IllegalStateException.</p>
 * @apiSince 29
 */

public boolean isLciSubelementValid() { throw new RuntimeException("Stub!"); }

/**
 * @return the latitude uncertainty in degrees.
 * <p>
 * Only valid if {@link #isLciSubelementValid()} returns true, or will throw an exception.
 * </p>
 * <p> An unknown uncertainty is indicated by 0.</p>
 * @apiSince 29
 */

public double getLatitudeUncertainty() { throw new RuntimeException("Stub!"); }

/**
 * @return the latitude in degrees
 * <p>
 * Only valid if {@link #isLciSubelementValid()} returns true, or will throw an exception.
 * @apiSince 29
 */

public double getLatitude() { throw new RuntimeException("Stub!"); }

/**
 * @return the Longitude uncertainty in degrees.
 * <p>
 * Only valid if {@link #isLciSubelementValid()} returns true, or will throw an exception.
 * </p>
 * <p> An unknown uncertainty is indicated by 0.</p>
 * @apiSince 29
 */

public double getLongitudeUncertainty() { throw new RuntimeException("Stub!"); }

/**
 * @return the Longitude in degrees..
 * <p>
 * Only valid if {@link #isLciSubelementValid()} returns true, or will throw an exception.
 * @apiSince 29
 */

public double getLongitude() { throw new RuntimeException("Stub!"); }

/**
 * @return the Altitude type.
 * <p>
 * Only valid if {@link #isLciSubelementValid()} returns true, or will throw an exception.
 
 * Value is {@link android.net.wifi.rtt.ResponderLocation#ALTITUDE_UNDEFINED}, {@link android.net.wifi.rtt.ResponderLocation#ALTITUDE_METERS}, or {@link android.net.wifi.rtt.ResponderLocation#ALTITUDE_FLOORS}
 * @apiSince 29
 */

public int getAltitudeType() { throw new RuntimeException("Stub!"); }

/**
 * @return the Altitude uncertainty in meters.
 * <p>
 * Only valid if {@link #isLciSubelementValid()} returns true, or will throw an exception.
 * </p>
 * <p>An unknown uncertainty is indicated by 0.</p>
 * @apiSince 29
 */

public double getAltitudeUncertainty() { throw new RuntimeException("Stub!"); }

/**
 * @return the Altitude in units defined by the altitude type.
 * <p>
 * Only valid if {@link #isLciSubelementValid()} returns true, or will throw an exception.
 * @apiSince 29
 */

public double getAltitude() { throw new RuntimeException("Stub!"); }

/**
 * @return the Datum used for the LCI positioning information.
 * <p>
 * Only valid if {@link #isLciSubelementValid()} returns true, or will throw an exception.
 
 * Value is {@link android.net.wifi.rtt.ResponderLocation#DATUM_UNDEFINED}, {@link android.net.wifi.rtt.ResponderLocation#DATUM_WGS84}, {@link android.net.wifi.rtt.ResponderLocation#DATUM_NAD83_NAV88}, or {@link android.net.wifi.rtt.ResponderLocation#DATUM_NAD83_MLLW}
 * @apiSince 29
 */

public int getDatum() { throw new RuntimeException("Stub!"); }

/**
 * @return true if the station is operating within a national policy area or an international
 * agreement area near a national border, otherwise false
 * (see 802.11REVmc Section 11.12.3 - Registered STA Operation).
 * <p>
 * Only valid if {@link #isLciSubelementValid()} returns true, or will throw an exception.
 * @apiSince 29
 */

public boolean getRegisteredLocationAgreementIndication() { throw new RuntimeException("Stub!"); }

/**
 * @return a value greater or equal to 1, indicating the current version number
 * of the LCI protocol.
 * <p>
 * Only valid if {@link #isLciSubelementValid()} returns true, or will throw an exception.
 * @apiSince 29
 */

public int getLciVersion() { throw new RuntimeException("Stub!"); }

/**
 * @return the LCI location represented as a {@link android.location.Location Location} object (best effort).
 * <p>
 * Only valid if {@link #isLciSubelementValid()} returns true, or will throw an exception.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.location.Location toLocation() { throw new RuntimeException("Stub!"); }

/**
 * @return if the Z subelement (containing mobility, Floor, Height above floor) is valid.
 * @apiSince 29
 */

public boolean isZaxisSubelementValid() { throw new RuntimeException("Stub!"); }

/**
 * @return an integer representing the mobility of the responder.
 * <p>
 * Only valid if {@link #isZaxisSubelementValid()} returns true, or will throw an exception.
 
 * Value is {@link android.net.wifi.rtt.ResponderLocation#LOCATION_FIXED}, {@link android.net.wifi.rtt.ResponderLocation#LOCATION_VARIABLE}, {@link android.net.wifi.rtt.ResponderLocation#LOCATION_MOVEMENT_UNKNOWN}, or {@link android.net.wifi.rtt.ResponderLocation#LOCATION_RESERVED}
 * @apiSince 29
 */

public int getExpectedToMove() { throw new RuntimeException("Stub!"); }

/**
 * @return the Z sub element Floor Number.
 * <p>
 * Only valid if {@link #isZaxisSubelementValid()} returns true, or will throw an exception.
 * </p>
 * <p>Note: this number can be positive or negative, with value increments of +/- 1/16 of a
 * floor.</p>.
 * @apiSince 29
 */

public double getFloorNumber() { throw new RuntimeException("Stub!"); }

/**
 * @return the Z subelement Height above the floor in meters.
 * <p>
 * Only valid if {@link #isZaxisSubelementValid()} returns true, or will throw an exception.
 * </p>
 * <p>This value can be positive or negative. </p>
 * @apiSince 29
 */

public double getHeightAboveFloorMeters() { throw new RuntimeException("Stub!"); }

/**
 * @return the Z subelement Height above the floor uncertainty in meters.
 * <p>
 * Only valid if {@link #isZaxisSubelementValid()} returns true, or will throw an exception.
 * </p>
 * <p>An unknown uncertainty is indicated by 0.</p>
 * @apiSince 29
 */

public double getHeightAboveFloorUncertaintyMeters() { throw new RuntimeException("Stub!"); }

/**
 * @return the Immutable list of colocated BSSIDs at the responder.
 *
 * <p> Will return an empty list when there are no bssids listed.
 * @apiSince 29
 */

public java.util.List<android.net.MacAddress> getColocatedBssids() { throw new RuntimeException("Stub!"); }

/**
 * @return the civic location represented as an {@link android.location.Address Address} object (best effort).
 *
 * <p> Will return a {@code null} when there is no Civic Location defined.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.location.Address toCivicLocationAddress() { throw new RuntimeException("Stub!"); }

/**
 * @return the civic location represented as a {@link android.util.SparseArray SparseArray}
 * <p>
 * Valid keys to access the SparseArray can be found in {@code CivicLocationKeys}.
 * </p>
 * <p> Will return a {@code null} when there is no Civic Location defined.
 *
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.util.SparseArray toCivicLocationSparseArray() { throw new RuntimeException("Stub!"); }

/**
 * @return the Map Image file Mime type, referred to by getMapImageUrl().
 
 * This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.lang.String getMapImageMimeType() { throw new RuntimeException("Stub!"); }

/**
 * @return a URI referencing a map-file showing the local floor plan.
 *
 * <p> Will return a {@code null} when there is no URI defined.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.net.Uri getMapImageUri() { throw new RuntimeException("Stub!"); }

/**
 * Responder Altitude is measured in floors.
 * @apiSince 29
 */

public static final int ALTITUDE_FLOORS = 2; // 0x2

/**
 * Responder Altitude is measured in meters.
 * @apiSince 29
 */

public static final int ALTITUDE_METERS = 1; // 0x1

/**
 * Altitude is not defined for the Responder.
 * The altitude and altitude uncertainty should not be used: see section 2.4 of IETF RFC 6225.
 * @apiSince 29
 */

public static final int ALTITUDE_UNDEFINED = 0; // 0x0

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.net.wifi.rtt.ResponderLocation> CREATOR;
static { CREATOR = null; }

/**
 * Datum used is NAD83 MLLW.
 * @apiSince 29
 */

public static final int DATUM_NAD83_MLLW = 3; // 0x3

/**
 * Datum used is NAD83 NAV88.
 * @apiSince 29
 */

public static final int DATUM_NAD83_NAV88 = 2; // 0x2

/**
 * Datum is not defined.
 * @apiSince 29
 */

public static final int DATUM_UNDEFINED = 0; // 0x0

/**
 * Datum used is WGS84.
 * @apiSince 29
 */

public static final int DATUM_WGS84 = 1; // 0x1

/**
 * Version of the LCI protocol is 1.0, the only defined protocol at this time.
 * @apiSince 29
 */

public static final int LCI_VERSION_1 = 1; // 0x1

/**
 * Location of responder is fixed (does not move)
 * @apiSince 29
 */

public static final int LOCATION_FIXED = 0; // 0x0

/**
 * Location of the responder is not known to be either fixed or variable.
 * @apiSince 29
 */

public static final int LOCATION_MOVEMENT_UNKNOWN = 2; // 0x2

/**
 * Location of the responder status is a reserved value
 * @apiSince 29
 */

public static final int LOCATION_RESERVED = 3; // 0x3

/**
 * Location of the responder is variable, and may move
 * @apiSince 29
 */

public static final int LOCATION_VARIABLE = 1; // 0x1
}

