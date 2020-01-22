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

import java.util.List;
import android.os.Parcelable;

/**
 * Contains phone signal strength related information.
 * @apiSince 7
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SignalStrength implements android.os.Parcelable {

SignalStrength() { throw new RuntimeException("Stub!"); }

/**
 * Returns a List of CellSignalStrength Components of this SignalStrength Report.
 *
 * Use this API to access underlying
 * {@link android.telephony#CellSignalStrength CellSignalStrength} objects that provide more
 * granular information about the SignalStrength report. Only valid (non-empty)
 * CellSignalStrengths will be returned. The order of any returned elements is not guaranteed,
 * and the list may contain more than one instance of a CellSignalStrength type.
 *
 * @return a List of CellSignalStrength or an empty List if there are no valid measurements.
 *
 * This value will never be {@code null}.
 * @see android.telephony#CellSignalStrength
 * @see android.telephony#CellSignalStrengthNr
 * @see android.telephony#CellSignalStrengthLte
 * @see android.telephony#CellSignalStrengthTdscdma
 * @see android.telephony#CellSignalStrengthWcdma
 * @see android.telephony#CellSignalStrengthCdma
 * @see android.telephony#CellSignalStrengthGsm
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.util.List<android.telephony.CellSignalStrength> getCellSignalStrengths() { throw new RuntimeException("Stub!"); }

/**
 * Returns a List of CellSignalStrength Components of this SignalStrength Report.
 *
 * Use this API to access underlying
 * {@link android.telephony#CellSignalStrength CellSignalStrength} objects that provide more
 * granular information about the SignalStrength report. Only valid (non-empty)
 * CellSignalStrengths will be returned. The order of any returned elements is not guaranteed,
 * and the list may contain more than one instance of a CellSignalStrength type.
 *
 * @param clazz a class type that extends
 *        {@link android.telephony.CellSignalStrength CellSignalStrength} to filter possible
 *        return values.
 * This value must never be {@code null}.
 * @return a List of CellSignalStrength or an empty List if there are no valid measurements.
 *
 * This value will never be {@code null}.
 * @see android.telephony#CellSignalStrength
 * @see android.telephony#CellSignalStrengthNr
 * @see android.telephony#CellSignalStrengthLte
 * @see android.telephony#CellSignalStrengthTdscdma
 * @see android.telephony#CellSignalStrengthWcdma
 * @see android.telephony#CellSignalStrengthCdma
 * @see android.telephony#CellSignalStrengthGsm
 * @apiSince 29
 */

@androidx.annotation.NonNull
public <T extends android.telephony.CellSignalStrength> java.util.List<T> getCellSignalStrengths(@androidx.annotation.NonNull java.lang.Class<T> clazz) { throw new RuntimeException("Stub!"); }

/**
 * {@link android.os.Parcelable#writeToParcel Parcelable#writeToParcel}
 * @apiSince 7
 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/**
 * {@link android.os.Parcelable#describeContents Parcelable#describeContents}
 * @apiSince 7
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Get the GSM RSSI in ASU.
 *
 * Asu is calculated based on 3GPP RSRP. Refer to 3GPP 27.007 (Ver 10.3.0) Sec 8.69
 *
 * @return RSSI in ASU 0..31, 99, or UNAVAILABLE
 *
 * @deprecated this information should be retrieved from
 *             {@link android.telephony.CellSignalStrengthGsm#getAsuLevel CellSignalStrengthGsm#getAsuLevel}.
 * @see android.telephony#CellSignalStrengthGsm
 * @see android.telephony.SignalStrength#getCellSignalStrengths
 * @apiSince 7
 * @deprecatedSince 29
 */

@Deprecated
public int getGsmSignalStrength() { throw new RuntimeException("Stub!"); }

/**
 * Get the GSM bit error rate (0-7, 99) as defined in TS 27.007 8.5
 *
 * @deprecated this information should be retrieved from
 *             {@link android.telephony.CellSignalStrengthGsm#getBitErrorRate CellSignalStrengthGsm#getBitErrorRate}.
 *
 * @see android.telephony#CellSignalStrengthGsm
 * @see android.telephony.SignalStrength#getCellSignalStrengths()
 * @apiSince 7
 * @deprecatedSince 29
 */

@Deprecated
public int getGsmBitErrorRate() { throw new RuntimeException("Stub!"); }

/**
 * Get the CDMA RSSI value in dBm
 *
 * @return the CDMA RSSI value or {@link #INVALID} if invalid
 *
 * @deprecated this information should be retrieved from
 *             {@link android.telephony.CellSignalStrengthCdma#getCdmaDbm CellSignalStrengthCdma#getCdmaDbm}.
 *
 * @see android.telephony#CellSignalStrengthCdma
 * @see android.telephony.SignalStrength#getCellSignalStrengths()
 * @apiSince 7
 * @deprecatedSince 29
 */

@Deprecated
public int getCdmaDbm() { throw new RuntimeException("Stub!"); }

/**
 * Get the CDMA Ec/Io value in dB*10
 *
 * @deprecated this information should be retrieved from
 *             {@link android.telephony.CellSignalStrengthCdma#getCdmaEcio CellSignalStrengthCdma#getCdmaEcio}.
 *
 * @see android.telephony#CellSignalStrengthCdma
 * @see android.telephony.SignalStrength#getCellSignalStrengths()
 * @apiSince 7
 * @deprecatedSince 29
 */

@Deprecated
public int getCdmaEcio() { throw new RuntimeException("Stub!"); }

/**
 * Get the EVDO RSSI value in dBm
 *
 * @return the EVDO RSSI value or {@link #INVALID} if invalid
 *
 * @deprecated this information should be retrieved from
 *             {@link android.telephony.CellSignalStrengthCdma#getEvdoDbm CellSignalStrengthCdma#getEvdoDbm}.
 *
 * @see android.telephony#CellSignalStrengthCdma
 * @see android.telephony.SignalStrength#getCellSignalStrengths()
 * @apiSince 7
 * @deprecatedSince 29
 */

@Deprecated
public int getEvdoDbm() { throw new RuntimeException("Stub!"); }

/**
 * Get the EVDO Ec/Io value in dB*10
 *
 * @deprecated this information should be retrieved from
 *             {@link android.telephony.CellSignalStrengthCdma#getEvdoEcio CellSignalStrengthCdma#getEvdoEcio}.
 *
 * @see android.telephony#CellSignalStrengthCdma
 * @see android.telephony.SignalStrength#getCellSignalStrengths()
 * @apiSince 7
 * @deprecatedSince 29
 */

@Deprecated
public int getEvdoEcio() { throw new RuntimeException("Stub!"); }

/**
 * Get the signal to noise ratio. Valid values are 0-8. 8 is the highest.
 *
 * @deprecated this information should be retrieved from
 *             {@link android.telephony.CellSignalStrengthCdma#getEvdoSnr CellSignalStrengthCdma#getEvdoSnr}.
 *
 * @see android.telephony#CellSignalStrengthCdma
 * @see android.telephony.SignalStrength#getCellSignalStrengths()
 * @apiSince 7
 * @deprecatedSince 29
 */

@Deprecated
public int getEvdoSnr() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve an abstract level value for the overall signal strength.
 *
 * @return a single integer from 0 to 4 representing the general signal quality.
 *     This may take into account many different radio technology inputs.
 *     0 represents very poor signal strength
 *     while 4 represents a very strong signal strength.
 * @apiSince 23
 */

public int getLevel() { throw new RuntimeException("Stub!"); }

/**
 * @return true if this is for GSM
 *
 * @deprecated This method returns true if there are any 3gpp type SignalStrength elements in
 *             this SignalStrength report or if the report contains no valid SignalStrength
 *             information. Instead callers should use
 *             {@link android.telephony.SignalStrength#getCellSignalStrengths
 *             getCellSignalStrengths()} to determine which types of information are contained
 *             in the SignalStrength report.
 * @apiSince 7
 * @deprecatedSince 29
 */

@Deprecated
public boolean isGsm() { throw new RuntimeException("Stub!"); }

/**
 * @return hash code
 * @apiSince 7
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * @return true if the signal strengths are the same
 * @apiSince 7
 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * @return string representation.
 * @apiSince 7
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Indicates the invalid measures of signal strength.
 *
 * For example, this can be returned by {@link #getEvdoDbm()} or {@link #getCdmaDbm()}
 * @apiSince 29
 */

public static final int INVALID = 2147483647; // 0x7fffffff
}

