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
 * A {@link android.telephony.CellInfo CellInfo} representing a CDMA cell that provides identity and measurement info.
 * @apiSince 17
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CellInfoCdma extends android.telephony.CellInfo implements android.os.Parcelable {

CellInfoCdma() { throw new RuntimeException("Stub!"); }

/**
 * @return a {@link android.telephony.CellIdentityCdma CellIdentityCdma} instance.
 
 * This value will never be {@code null}.
 * @apiSince 17
 */

@androidx.annotation.NonNull
public android.telephony.CellIdentityCdma getCellIdentity() { throw new RuntimeException("Stub!"); }

/**
 * @return a {@link android.telephony.CellSignalStrengthCdma CellSignalStrengthCdma} instance.
 
 * This value will never be {@code null}.
 * @apiSince 17
 */

@androidx.annotation.NonNull
public android.telephony.CellSignalStrengthCdma getCellSignalStrength() { throw new RuntimeException("Stub!"); }

/**
 * @return hash code
 * @apiSince 17
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 17 */

public boolean equals(java.lang.Object other) { throw new RuntimeException("Stub!"); }

/** @apiSince 17 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface
 * @apiSince 17
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface
 * @apiSince 17
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface
 * @apiSince 17
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telephony.CellInfoCdma> CREATOR;
static { CREATOR = null; }
}

