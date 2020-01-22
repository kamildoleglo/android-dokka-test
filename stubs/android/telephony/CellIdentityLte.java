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


/**
 * CellIdentity is to represent a unique LTE cell
 * @apiSince 17
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CellIdentityLte extends android.telephony.CellIdentity {

CellIdentityLte() { throw new RuntimeException("Stub!"); }

/**
 * @return 3-digit Mobile Country Code, 0..999,
 *         {@link android.telephony.CellInfo#UNAVAILABLE UNAVAILABLE} if unavailable.
 * @deprecated Use {@link #getMccString} instead.
 * @apiSince 17
 * @deprecatedSince 28
 */

@Deprecated
public int getMcc() { throw new RuntimeException("Stub!"); }

/**
 * @return 2 or 3-digit Mobile Network Code, 0..999,
 *         {@link android.telephony.CellInfo#UNAVAILABLE UNAVAILABLE} if unavailable.
 * @deprecated Use {@link #getMncString} instead.
 * @apiSince 17
 * @deprecatedSince 28
 */

@Deprecated
public int getMnc() { throw new RuntimeException("Stub!"); }

/**
 * @return 28-bit Cell Identity,
 *         {@link android.telephony.CellInfo#UNAVAILABLE UNAVAILABLE} if unavailable.
 * @apiSince 17
 */

public int getCi() { throw new RuntimeException("Stub!"); }

/**
 * @return Physical Cell Id 0..503,
 *         {@link android.telephony.CellInfo#UNAVAILABLE UNAVAILABLE} if unavailable.
 * @apiSince 17
 */

public int getPci() { throw new RuntimeException("Stub!"); }

/**
 * @return 16-bit Tracking Area Code,
 *         {@link android.telephony.CellInfo#UNAVAILABLE UNAVAILABLE} if unavailable.
 * @apiSince 17
 */

public int getTac() { throw new RuntimeException("Stub!"); }

/**
 * @return 18-bit Absolute RF Channel Number,
 *         {@link android.telephony.CellInfo#UNAVAILABLE UNAVAILABLE} if unavailable.
 * @apiSince 24
 */

public int getEarfcn() { throw new RuntimeException("Stub!"); }

/**
 * @return Cell bandwidth in kHz,
 *         {@link android.telephony.CellInfo#UNAVAILABLE UNAVAILABLE} if unavailable.
 * @apiSince 28
 */

public int getBandwidth() { throw new RuntimeException("Stub!"); }

/**
 * @return Mobile Country Code in string format, null if unavailable.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public java.lang.String getMccString() { throw new RuntimeException("Stub!"); }

/**
 * @return Mobile Network Code in string format, null if unavailable.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public java.lang.String getMncString() { throw new RuntimeException("Stub!"); }

/**
 * @return a 5 or 6 character string (MCC+MNC), null if any field is unknown.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public java.lang.String getMobileNetworkOperator() { throw new RuntimeException("Stub!"); }

/** @apiSince 17 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 17 */

public boolean equals(java.lang.Object other) { throw new RuntimeException("Stub!"); }

/** @apiSince 17 */

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

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telephony.CellIdentityLte> CREATOR;
static { CREATOR = null; }
}

