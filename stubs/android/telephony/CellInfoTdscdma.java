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
 * A {@link android.telephony.CellInfo CellInfo} representing a TD-SCDMA cell that provides identity and measurement info.
 *
 * @see android.telephony.CellInfo
 * @see android.telephony.CellSignalStrengthTdscdma
 * @see android.telephony.CellIdentityTdscdma
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CellInfoTdscdma extends android.telephony.CellInfo implements android.os.Parcelable {

CellInfoTdscdma() { throw new RuntimeException("Stub!"); }

/**
 * @return a {@link android.telephony.CellIdentityTdscdma CellIdentityTdscdma} instance.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.telephony.CellIdentityTdscdma getCellIdentity() { throw new RuntimeException("Stub!"); }

/**
 * @return a {@link android.telephony.CellSignalStrengthTdscdma CellSignalStrengthTdscdma} instance.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.telephony.CellSignalStrengthTdscdma getCellSignalStrength() { throw new RuntimeException("Stub!"); }

/**
 * @return hash code
 * @apiSince 29
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public boolean equals(java.lang.Object other) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface
 * @apiSince 29
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface
 * @apiSince 29
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telephony.CellInfoTdscdma> CREATOR;
static { CREATOR = null; }
}

