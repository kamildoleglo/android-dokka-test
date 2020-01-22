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


/**
 * Information to represent a unique NR(New Radio 5G) cell.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CellIdentityNr extends android.telephony.CellIdentity {

CellIdentityNr() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public boolean equals(java.lang.Object other) { throw new RuntimeException("Stub!"); }

/**
 * Get the NR(New Radio 5G) Cell Identity.
 *
 * @return The 36-bit NR Cell Identity in range [0, 68719476735] or
 *         {@link android.telephony.CellInfo#UNAVAILABLE_LONG CellInfo#UNAVAILABLE_LONG} if unknown.
 * @apiSince 29
 */

public long getNci() { throw new RuntimeException("Stub!"); }

/**
 * Get the New Radio Absolute Radio Frequency Channel Number.
 *
 * Reference: 3GPP TS 38.101-1 section 5.4.2.1 NR-ARFCN and channel raster.
 * Reference: 3GPP TS 38.101-2 section 5.4.2.1 NR-ARFCN and channel raster.
 *
 * @return Integer value in range [0, 3279165] or {@link android.telephony.CellInfo#UNAVAILABLE CellInfo#UNAVAILABLE} if unknown.
 
 * Value is between 0 and 3279165 inclusive
 * @apiSince 29
 */

public int getNrarfcn() { throw new RuntimeException("Stub!"); }

/**
 * Get the physical cell id.
 * @return Integer value in range [0, 1007] or {@link android.telephony.CellInfo#UNAVAILABLE CellInfo#UNAVAILABLE} if unknown.
 
 * Value is between 0 and 1007 inclusive
 * @apiSince 29
 */

public int getPci() { throw new RuntimeException("Stub!"); }

/**
 * Get the tracking area code.
 * @return a 16 bit integer or {@link android.telephony.CellInfo#UNAVAILABLE CellInfo#UNAVAILABLE} if unknown.
 
 * Value is between 0 and 65535 inclusive
 * @apiSince 29
 */

public int getTac() { throw new RuntimeException("Stub!"); }

/**
 * @return Mobile Country Code in string format, or {@code null} if unknown.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.lang.String getMccString() { throw new RuntimeException("Stub!"); }

/**
 * @return Mobile Network Code in string fomrat, or {@code null} if unknown.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.lang.String getMncString() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void writeToParcel(android.os.Parcel dest, int type) { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telephony.CellIdentityNr> CREATOR;
static { CREATOR = null; }
}

