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
 * GSM signal strength related information.
 * @apiSince 17
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CellSignalStrengthGsm extends android.telephony.CellSignalStrength implements android.os.Parcelable {

CellSignalStrengthGsm() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @return Value is between SIGNAL_STRENGTH_NONE_OR_UNKNOWN and SIGNAL_STRENGTH_GREAT inclusive
 * @apiSince 17
 */

public int getLevel() { throw new RuntimeException("Stub!"); }

/**
 * Get the GSM timing advance between 0..219 symbols (normally 0..63).
 * <p>{@link android.telephony.CellInfo#UNAVAILABLE UNAVAILABLE} is reported when there is no RR
 * connection. Refer to 3GPP 45.010 Sec 5.8.
 *
 * @return the current GSM timing advance, if available.
 * @apiSince 26
 */

public int getTimingAdvance() { throw new RuntimeException("Stub!"); }

/**
 * Get the signal strength as dBm.
 * @apiSince 17
 */

public int getDbm() { throw new RuntimeException("Stub!"); }

/**
 * Get the RSSI in ASU.
 *
 * Asu is calculated based on 3GPP RSSI. Refer to 3GPP 27.007 (Ver 10.3.0) Sec 8.69
 *
 * @return RSSI in ASU 0..31, 99, or UNAVAILABLE
 * @apiSince 17
 */

public int getAsuLevel() { throw new RuntimeException("Stub!"); }

/**
 * Return the Received Signal Strength Indicator.
 *
 * @return the RSSI in dBm (-113, -51) or
 *         {@link android.telephony.CellInfo#UNAVAILABLE UNAVAILABLE}.
 * @apiSince R
 */

public int getRssi() { throw new RuntimeException("Stub!"); }

/**
 * Return the Bit Error Rate.
 *
 * @return the bit error rate (0-7, 99) as defined in TS 27.007 8.5 or
 *         {@link android.telephony.CellInfo#UNAVAILABLE UNAVAILABLE}.
 * @apiSince 29
 */

public int getBitErrorRate() { throw new RuntimeException("Stub!"); }

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

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telephony.CellSignalStrengthGsm> CREATOR;
static { CREATOR = null; }
}

