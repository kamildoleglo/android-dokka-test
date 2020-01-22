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


package android.telephony;

import android.os.Parcelable;

/**
 * Tdscdma signal strength related information.
 *
 * This class provides signal strength and signal quality information for the TD-SCDMA air
 * interface. For more information see 3gpp 25.225.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CellSignalStrengthTdscdma extends android.telephony.CellSignalStrength implements android.os.Parcelable {

CellSignalStrengthTdscdma() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @return Value is between 0 and 4 inclusive
 * @apiSince 29
 */

public int getLevel() { throw new RuntimeException("Stub!"); }

/**
 * Get the RSCP as dBm value -120..-24dBm or {@link android.telephony.CellInfo#UNAVAILABLE CellInfo#UNAVAILABLE}.
 * @apiSince 29
 */

public int getDbm() { throw new RuntimeException("Stub!"); }

/**
 * Get the RSCP as dBm value -120..-24dBm or {@link android.telephony.CellInfo#UNAVAILABLE CellInfo#UNAVAILABLE}.
 * @apiSince 29
 */

public int getRscp() { throw new RuntimeException("Stub!"); }

/**
 * Get the RSCP in ASU.
 *
 * Asu is calculated based on 3GPP RSRP. Refer to 3GPP 27.007 (Ver 10.3.0) Sec 8.69
 *
 * @return RSCP in ASU 0..96, 255, or {@link android.telephony.CellInfo#UNAVAILABLE CellInfo#UNAVAILABLE}.
 * @apiSince 29
 */

public int getAsuLevel() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * @return string representation.
 * @apiSince 29
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface
 * @apiSince 29
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface
 * @apiSince 29
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telephony.CellSignalStrengthTdscdma> CREATOR;
static { CREATOR = null; }
}

