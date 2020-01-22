/*
 * Copyright (C) 2012 The Android Open Source Project
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


package android.telephony;

import android.os.Parcelable;

/**
 * LTE signal strength related information.
 * @apiSince 17
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CellSignalStrengthLte extends android.telephony.CellSignalStrength implements android.os.Parcelable {

CellSignalStrengthLte() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @return Value is between SIGNAL_STRENGTH_NONE_OR_UNKNOWN and SIGNAL_STRENGTH_GREAT inclusive
 * @apiSince 17
 */

public int getLevel() { throw new RuntimeException("Stub!"); }

/**
 * Get reference signal received quality
 *
 * @return the RSRQ if available or
 *         {@link android.telephony.CellInfo#UNAVAILABLE UNAVAILABLE} if unavailable.
 * @apiSince 26
 */

public int getRsrq() { throw new RuntimeException("Stub!"); }

/**
 * Get Received Signal Strength Indication (RSSI) in dBm
 *
 * The value range is [-113, -51] inclusively or {@link android.telephony.CellInfo#UNAVAILABLE CellInfo#UNAVAILABLE} if unavailable.
 *
 * Reference: TS 27.007 8.5 Signal quality +CSQ
 *
 * @return the RSSI if available or {@link android.telephony.CellInfo#UNAVAILABLE CellInfo#UNAVAILABLE} if unavailable.
 * @apiSince 29
 */

public int getRssi() { throw new RuntimeException("Stub!"); }

/**
 * Get reference signal signal-to-noise ratio
 *
 * @return the RSSNR if available or
 *         {@link android.telephony.CellInfo#UNAVAILABLE UNAVAILABLE} if unavailable.
 * @apiSince 26
 */

public int getRssnr() { throw new RuntimeException("Stub!"); }

/**
 * Get reference signal received power in dBm
 *
 * @return the RSRP of the measured cell.
 * @apiSince 26
 */

public int getRsrp() { throw new RuntimeException("Stub!"); }

/**
 * Get channel quality indicator
 *
 * @return the CQI if available or
 *         {@link android.telephony.CellInfo#UNAVAILABLE UNAVAILABLE} if unavailable.
 * @apiSince 26
 */

public int getCqi() { throw new RuntimeException("Stub!"); }

/**
 * Get signal strength in dBm
 *
 * @return the RSRP of the measured cell.
 * @apiSince 17
 */

public int getDbm() { throw new RuntimeException("Stub!"); }

/**
 * Get the RSRP in ASU.
 *
 * Asu is calculated based on 3GPP RSRP. Refer to 3GPP 27.007 (Ver 10.3.0) Sec 8.69
 *
 * @return RSCP in ASU 0..97, 255, or UNAVAILABLE
 * @apiSince 17
 */

public int getAsuLevel() { throw new RuntimeException("Stub!"); }

/**
 * Get the timing advance value for LTE, as a value in range of 0..1282.
 * {@link android.telephony.CellInfo#UNAVAILABLE UNAVAILABLE} is reported when there is no
 * active RRC connection. Refer to 3GPP 36.213 Sec 4.2.3
 *
 * @return the LTE timing advance if available or
 *         {@link android.telephony.CellInfo#UNAVAILABLE UNAVAILABLE} if unavailable.
 * @apiSince 17
 */

public int getTimingAdvance() { throw new RuntimeException("Stub!"); }

/** @apiSince 17 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 17 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * @return string representation.
 * @apiSince 17
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface
 * @apiSince 17
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface
 * @apiSince 17
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface
 * @apiSince 17
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telephony.CellSignalStrengthLte> CREATOR;
static { CREATOR = null; }
}

