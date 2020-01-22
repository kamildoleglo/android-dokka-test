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
 * CellIdentity to represent a unique GSM cell
 * @apiSince 17
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CellIdentityGsm extends android.telephony.CellIdentity {

CellIdentityGsm() { throw new RuntimeException("Stub!"); }

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
 * @return 16-bit Location Area Code, 0..65535,
 *         {@link android.telephony.CellInfo#UNAVAILABLE UNAVAILABLE} if unavailable.
 * @apiSince 17
 */

public int getLac() { throw new RuntimeException("Stub!"); }

/**
 * @return 16-bit GSM Cell Identity described in TS 27.007, 0..65535,
 *         {@link android.telephony.CellInfo#UNAVAILABLE UNAVAILABLE} if unavailable.
 * @apiSince 17
 */

public int getCid() { throw new RuntimeException("Stub!"); }

/**
 * @return 16-bit GSM Absolute RF Channel Number,
 *         {@link android.telephony.CellInfo#UNAVAILABLE UNAVAILABLE} if unavailable.
 * @apiSince 24
 */

public int getArfcn() { throw new RuntimeException("Stub!"); }

/**
 * @return 6-bit Base Station Identity Code,
 *         {@link android.telephony.CellInfo#UNAVAILABLE UNAVAILABLE} if unavailable.
 * @apiSince 24
 */

public int getBsic() { throw new RuntimeException("Stub!"); }

/**
 * @return a 5 or 6 character string (MCC+MNC), null if any field is unknown.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public java.lang.String getMobileNetworkOperator() { throw new RuntimeException("Stub!"); }

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
 * @deprecated Primary Scrambling Code is not applicable to GSM.
 * @return {@link android.telephony.CellInfo#UNAVAILABLE UNAVAILABLE} - undefined for GSM
 * @apiSince 17
 * @deprecatedSince 18
 */

@Deprecated
public int getPsc() { throw new RuntimeException("Stub!"); }

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

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telephony.CellIdentityGsm> CREATOR;
static { CREATOR = null; }
}

