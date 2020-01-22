/*
 * Copyright (C) 2006 The Android Open Source Project
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


package android.telephony.cdma;

import android.os.Bundle;

/**
 * Represents the cell location on a CDMA phone.
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CdmaCellLocation extends android.telephony.CellLocation {

/**
 * Empty constructor.
 * Initializes the BID, SID, NID and base station latitude and longitude
 * to invalid values.
 * @apiSince 5
 */

public CdmaCellLocation() { throw new RuntimeException("Stub!"); }

/**
 * Initialize the object from a bundle.
 * @apiSince 5
 */

public CdmaCellLocation(android.os.Bundle bundle) { throw new RuntimeException("Stub!"); }

/**
 * @return cdma base station identification number, -1 if unknown
 * @apiSince 5
 */

public int getBaseStationId() { throw new RuntimeException("Stub!"); }

/**
 * Latitude is a decimal number as specified in 3GPP2 C.S0005-A v6.0.
 * (http://www.3gpp2.org/public_html/specs/C.S0005-A_v6.0.pdf)
 * It is represented in units of 0.25 seconds and ranges from -1296000
 * to 1296000, both values inclusive (corresponding to a range of -90
 * to +90 degrees). Integer.MAX_VALUE is considered invalid value.
 *
 * @return cdma base station latitude in units of 0.25 seconds, Integer.MAX_VALUE if unknown
 * @apiSince 5
 */

public int getBaseStationLatitude() { throw new RuntimeException("Stub!"); }

/**
 * Longitude is a decimal number as specified in 3GPP2 C.S0005-A v6.0.
 * (http://www.3gpp2.org/public_html/specs/C.S0005-A_v6.0.pdf)
 * It is represented in units of 0.25 seconds and ranges from -2592000
 * to 2592000, both values inclusive (corresponding to a range of -180
 * to +180 degrees). Integer.MAX_VALUE is considered invalid value.
 *
 * @return cdma base station longitude in units of 0.25 seconds, Integer.MAX_VALUE if unknown
 * @apiSince 5
 */

public int getBaseStationLongitude() { throw new RuntimeException("Stub!"); }

/**
 * @return cdma system identification number, -1 if unknown
 * @apiSince 5
 */

public int getSystemId() { throw new RuntimeException("Stub!"); }

/**
 * @return cdma network identification number, -1 if unknown
 * @apiSince 5
 */

public int getNetworkId() { throw new RuntimeException("Stub!"); }

/**
 * Invalidate this object.  The cell location data is set to invalid values.
 * @apiSince 5
 */

public void setStateInvalid() { throw new RuntimeException("Stub!"); }

/**
 * Set the cell location data.
 * @apiSince 5
 */

public void setCellLocationData(int baseStationId, int baseStationLatitude, int baseStationLongitude) { throw new RuntimeException("Stub!"); }

/**
 * Set the cell location data.
 * @apiSince 5
 */

public void setCellLocationData(int baseStationId, int baseStationLatitude, int baseStationLongitude, int systemId, int networkId) { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Fill the cell location data into the intent notifier Bundle based on service state
 *
 * @param bundleToFill intent notifier Bundle
 * @apiSince 5
 */

public void fillInNotifierBundle(android.os.Bundle bundleToFill) { throw new RuntimeException("Stub!"); }

/**
 * Converts latitude or longitude from 0.25 seconds (as defined in the
 * 3GPP2 C.S0005-A v6.0 standard) to decimal degrees
 *
 * @param quartSec latitude or longitude in 0.25 seconds units
 * @return latitude or longitude in decimal degrees units
 * @throws java.lang.IllegalArgumentException if value is less than -2592000,
 *                                  greater than 2592000, or is not a number.
 * @apiSince 17
 */

public static double convertQuartSecToDecDegrees(int quartSec) { throw new RuntimeException("Stub!"); }
}

