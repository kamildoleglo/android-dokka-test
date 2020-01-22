/*
 * Copyright (C) 2006 The Android Open Source Project
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
 * Contains phone state and service related information.
 *
 * The following phone information is included in returned ServiceState:
 *
 * <ul>
 *   <li>Service state: IN_SERVICE, OUT_OF_SERVICE, EMERGENCY_ONLY, POWER_OFF
 *   <li>Duplex mode: UNKNOWN, FDD, TDD
 *   <li>Roaming indicator
 *   <li>Operator name, short name and numeric id
 *   <li>Network selection mode
 * </ul>
 *
 * For historical reasons this class is not declared as final; however,
 * it should be treated as though it were final.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ServiceState implements android.os.Parcelable {

/**
 * Empty constructor
 * @apiSince 1
 */

public ServiceState() { throw new RuntimeException("Stub!"); }

/**
 * Copy constructors
 *
 * @param s Source service state
 * @apiSince 1
 */

public ServiceState(android.telephony.ServiceState s) { throw new RuntimeException("Stub!"); }

/**
 * Construct a ServiceState object from the given parcel.
 *
 * @deprecated The constructor takes parcel should not be public at the beginning. Use
 * {@link #ServiceState()} instead.
 * @apiSince 1
 */

@Deprecated
public ServiceState(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void copyFrom(android.telephony.ServiceState s) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Get current voice service state
 * @apiSince 1
 */

public int getState() { throw new RuntimeException("Stub!"); }

/**
 * Get the current duplex mode
 *
 * @see #DUPLEX_MODE_UNKNOWN
 * @see #DUPLEX_MODE_FDD
 * @see #DUPLEX_MODE_TDD
 *
 * @return Current {@code DuplexMode} for the phone
 
 * Value is {@link android.telephony.ServiceState#DUPLEX_MODE_UNKNOWN}, {@link android.telephony.ServiceState#DUPLEX_MODE_FDD}, or {@link android.telephony.ServiceState#DUPLEX_MODE_TDD}
 * @apiSince 28
 */

public int getDuplexMode() { throw new RuntimeException("Stub!"); }

/**
 * Get the channel number of the current primary serving cell, or -1 if unknown
 *
 * <p>This is EARFCN for LTE, UARFCN for UMTS, and ARFCN for GSM.
 *
 * @return Channel number of primary serving cell
 * @apiSince 28
 */

public int getChannelNumber() { throw new RuntimeException("Stub!"); }

/**
 * Get an array of cell bandwidths (kHz) for the current serving cells
 *
 * @return Current serving cell bandwidths
 * @apiSince 28
 */

public int[] getCellBandwidths() { throw new RuntimeException("Stub!"); }

/**
 * Get current roaming indicator of phone
 * (note: not just decoding from TS 27.007 7.2)
 *
 * @return true if TS 27.007 7.2 roaming is true
 *              and ONS is different from SPN
 * @apiSince 1
 */

public boolean getRoaming() { throw new RuntimeException("Stub!"); }

/**
 * Get current registered operator name in long alphanumeric format.
 *
 * In GSM/UMTS, long format can be up to 16 characters long.
 * In CDMA, returns the ERI text, if set. Otherwise, returns the ONS.
 *
 * @return long name of operator, null if unregistered or unknown
 * @apiSince 1
 */

public java.lang.String getOperatorAlphaLong() { throw new RuntimeException("Stub!"); }

/**
 * Get current registered operator name in short alphanumeric format.
 *
 * In GSM/UMTS, short format can be up to 8 characters long.
 *
 * @return short name of operator, null if unregistered or unknown
 * @apiSince 1
 */

public java.lang.String getOperatorAlphaShort() { throw new RuntimeException("Stub!"); }

/**
 * Get current registered operator numeric id.
 *
 * In GSM/UMTS, numeric format is 3 digit country code plus 2 or 3 digit
 * network code.
 *
 * @return numeric format of operator, null if unregistered or unknown
 * @apiSince 1
 */

public java.lang.String getOperatorNumeric() { throw new RuntimeException("Stub!"); }

/**
 * Get current network selection mode.
 *
 * @return true if manual mode, false if automatic mode
 * @apiSince 1
 */

public boolean getIsManualSelection() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setStateOutOfService() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setStateOff() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setState(int state) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setRoaming(boolean roaming) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setOperatorName(java.lang.String longName, java.lang.String shortName, java.lang.String numeric) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setIsManualSelection(boolean isManual) { throw new RuntimeException("Stub!"); }

/**
 * Get the CDMA NID (Network Identification Number), a number uniquely identifying a network
 * within a wireless system. (Defined in 3GPP2 C.S0023 3.4.8)
 * @return The CDMA NID or {@link #UNKNOWN_ID} if not available.
 * @apiSince 28
 */

public int getCdmaNetworkId() { throw new RuntimeException("Stub!"); }

/**
 * Get the CDMA SID (System Identification Number), a number uniquely identifying a wireless
 * system. (Defined in 3GPP2 C.S0023 3.4.8)
 * @return The CDMA SID or {@link #UNKNOWN_ID} if not available.
 * @apiSince 28
 */

public int getCdmaSystemId() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telephony.ServiceState> CREATOR;
static { CREATOR = null; }

/**
 * Duplex mode for the phone is frequency-division duplexing.
 * @apiSince 28
 */

public static final int DUPLEX_MODE_FDD = 1; // 0x1

/**
 * Duplex mode for the phone is time-division duplexing.
 * @apiSince 28
 */

public static final int DUPLEX_MODE_TDD = 2; // 0x2

/**
 * Duplex mode for the phone is unknown.
 * @apiSince 28
 */

public static final int DUPLEX_MODE_UNKNOWN = 0; // 0x0

/**
 * The phone is registered and locked.  Only emergency numbers are allowed. {@more}
 * @apiSince 1
 */

public static final int STATE_EMERGENCY_ONLY = 2; // 0x2

/**
 * Normal operation condition, the phone is registered
 * with an operator either in home network or in roaming.
 * @apiSince 1
 */

public static final int STATE_IN_SERVICE = 0; // 0x0

/**
 * Phone is not registered with any operator, the phone
 * can be currently searching a new operator to register to, or not
 * searching to registration at all, or registration is denied, or radio
 * signal is not available.
 * @apiSince 1
 */

public static final int STATE_OUT_OF_SERVICE = 1; // 0x1

/**
 * Radio of telephony is explicitly powered off.
 * @apiSince 1
 */

public static final int STATE_POWER_OFF = 3; // 0x3

/**
 * Unknown ID. Could be returned by {@link #getCdmaNetworkId()} or {@link #getCdmaSystemId()}
 * @apiSince 28
 */

public static final int UNKNOWN_ID = -1; // 0xffffffff
}

