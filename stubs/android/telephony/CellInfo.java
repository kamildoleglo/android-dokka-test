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
 * Immutable cell information from a point in time.
 * @apiSince 17
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class CellInfo implements android.os.Parcelable {

CellInfo() { throw new RuntimeException("Stub!"); }

/**
 * True if the phone is registered to a mobile network that provides service on this cell
 * and this cell is being used or would be used for network signaling.
 * @apiSince 17
 */

public boolean isRegistered() { throw new RuntimeException("Stub!"); }

/**
 * Approximate time this cell information was received from the modem.
 *
 * @return a time stamp in nanos since boot.
 * @apiSince 17
 */

public long getTimeStamp() { throw new RuntimeException("Stub!"); }

/**
 * @return a {@link android.telephony.CellIdentity CellIdentity} instance.
 
 * This value will never be {@code null}.
 * @apiSince R
 */

@androidx.annotation.NonNull
public abstract android.telephony.CellIdentity getCellIdentity();

/**
 * @return a {@link android.telephony.CellSignalStrength CellSignalStrength} instance.
 
 * This value will never be {@code null}.
 * @apiSince R
 */

@androidx.annotation.NonNull
public abstract android.telephony.CellSignalStrength getCellSignalStrength();

/**
 * Gets the connection status of this cell.
 *
 * @see #CONNECTION_NONE
 * @see #CONNECTION_PRIMARY_SERVING
 * @see #CONNECTION_SECONDARY_SERVING
 * @see #CONNECTION_UNKNOWN
 *
 * @return The connection status of the cell.
 
 * Value is {@link android.telephony.CellInfo#CONNECTION_NONE}, {@link android.telephony.CellInfo#CONNECTION_PRIMARY_SERVING}, {@link android.telephony.CellInfo#CONNECTION_SECONDARY_SERVING}, or {@link android.telephony.CellInfo#CONNECTION_UNKNOWN}
 * @apiSince 28
 */

public int getCellConnectionStatus() { throw new RuntimeException("Stub!"); }

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

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface
 * @apiSince 17
 */

public abstract void writeToParcel(android.os.Parcel dest, int flags);

/**
 * Cell is not a serving cell.
 *
 * <p>The cell has been measured but is neither a camped nor serving cell (3GPP 36.304).
 * @apiSince 28
 */

public static final int CONNECTION_NONE = 0; // 0x0

/**
 * UE is connected to cell for signalling and possibly data (3GPP 36.331, 25.331).
 * @apiSince 28
 */

public static final int CONNECTION_PRIMARY_SERVING = 1; // 0x1

/**
 * UE is connected to cell for data (3GPP 36.331, 25.331).
 * @apiSince 28
 */

public static final int CONNECTION_SECONDARY_SERVING = 2; // 0x2

/**
 * Connection status is unknown.
 * @apiSince 28
 */

public static final int CONNECTION_UNKNOWN = 2147483647; // 0x7fffffff

/**
 * Implement the Parcelable interface
 * @apiSince 17
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telephony.CellInfo> CREATOR;
static { CREATOR = null; }

/**
 * This value indicates that the integer field is unreported.
 * @apiSince 29
 */

public static final int UNAVAILABLE = 2147483647; // 0x7fffffff

/**
 * This value indicates that the long field is unreported.
 * @apiSince 29
 */

public static final long UNAVAILABLE_LONG = 9223372036854775807L; // 0x7fffffffffffffffL
}

