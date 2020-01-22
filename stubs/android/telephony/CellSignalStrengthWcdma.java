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
 * Wcdma signal strength related information.
 * @apiSince 18
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CellSignalStrengthWcdma extends android.telephony.CellSignalStrength implements android.os.Parcelable {

CellSignalStrengthWcdma() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @return Value is between SIGNAL_STRENGTH_NONE_OR_UNKNOWN and SIGNAL_STRENGTH_GREAT inclusive
 * @apiSince 18
 */

public int getLevel() { throw new RuntimeException("Stub!"); }

/**
 * Get the RSCP as dBm value -120..-24dBm or {@link android.telephony.CellInfo#UNAVAILABLE CellInfo#UNAVAILABLE}.
 * @apiSince 18
 */

public int getDbm() { throw new RuntimeException("Stub!"); }

/**
 * Get the RSCP in ASU.
 *
 * Asu is calculated based on 3GPP RSCP. Refer to 3GPP 27.007 (Ver 10.3.0) Sec 8.69
 *
 * @return RSCP in ASU 0..96, 255, or UNAVAILABLE
 * @apiSince 18
 */

public int getAsuLevel() { throw new RuntimeException("Stub!"); }

/**
 * Get the Ec/No (Energy per chip over the noise spectral density) as dB.
 *
 * Reference: TS 25.133 Section 9.1.2.3
 *
 * @return the Ec/No of the measured cell in the range [-24, 1] or
 * {@link android.telephony.CellInfo#UNAVAILABLE UNAVAILABLE} if unavailable
 * @apiSince R
 */

public int getEcNo() { throw new RuntimeException("Stub!"); }

/** @apiSince 18 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 18 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * @return string representation.
 * @apiSince 18
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface
 * @apiSince 18
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface
 * @apiSince 18
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface
 * @apiSince 18
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telephony.CellSignalStrengthWcdma> CREATOR;
static { CREATOR = null; }
}

