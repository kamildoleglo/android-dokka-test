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
 * Signal strength related information.
 * @apiSince 17
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CellSignalStrengthCdma extends android.telephony.CellSignalStrength implements android.os.Parcelable {

CellSignalStrengthCdma() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @return Value is between SIGNAL_STRENGTH_NONE_OR_UNKNOWN and SIGNAL_STRENGTH_GREAT inclusive
 * @apiSince 17
 */

public int getLevel() { throw new RuntimeException("Stub!"); }

/**
 * Get the 1xRTT Level in (Android) ASU.
 *
 * There is no standard definition of ASU for CDMA; however, Android defines it as the
 * the lesser of the following two results (for 1xRTT):
 * <table>
 *     <thead><tr><th>RSSI Range (dBm)</th><th>ASU Value</th></tr><thead>
 *     <tbody>
 *         <tr><td>-75..</td><td>16</td></tr>
 *         <tr><td>-82..-76</td><td>8</td></tr>
 *         <tr><td>-90..-83</td><td>4</td></tr>
 *         <tr><td>-95..-91</td><td>2</td></tr>
 *         <tr><td>-100..-96</td><td>1</td></tr>
 *         <tr><td>..-101</td><td>99</td></tr>
 *     </tbody>
 * </table>
 * <table>
 *     <thead><tr><th>Ec/Io Range (dB)</th><th>ASU Value</th></tr><thead>
 *     <tbody>
 *         <tr><td>-90..</td><td>16</td></tr>
 *         <tr><td>-100..-91</td><td>8</td></tr>
 *         <tr><td>-115..-101</td><td>4</td></tr>
 *         <tr><td>-130..-116</td><td>2</td></tr>
 *         <tr><td>--150..-131</td><td>1</td></tr>
 *         <tr><td>..-151</td><td>99</td></tr>
 *     </tbody>
 * </table>
 * @return 1xRTT Level in Android ASU {1,2,4,8,16,99}
 * @apiSince 17
 */

public int getAsuLevel() { throw new RuntimeException("Stub!"); }

/**
 * Get cdma as level 0..4
 * @apiSince 17
 */

public int getCdmaLevel() { throw new RuntimeException("Stub!"); }

/**
 * Get Evdo as level 0..4
 * @apiSince 17
 */

public int getEvdoLevel() { throw new RuntimeException("Stub!"); }

/**
 * Get the signal strength as dBm
 * @apiSince 17
 */

public int getDbm() { throw new RuntimeException("Stub!"); }

/**
 * Get the CDMA RSSI value in dBm
 * @apiSince 17
 */

public int getCdmaDbm() { throw new RuntimeException("Stub!"); }

/**
 * Get the CDMA Ec/Io value in dB*10
 * @apiSince 17
 */

public int getCdmaEcio() { throw new RuntimeException("Stub!"); }

/**
 * Get the EVDO RSSI value in dBm
 * @apiSince 17
 */

public int getEvdoDbm() { throw new RuntimeException("Stub!"); }

/**
 * Get the EVDO Ec/Io value in dB*10
 * @apiSince 17
 */

public int getEvdoEcio() { throw new RuntimeException("Stub!"); }

/**
 * Get the signal to noise ratio. Valid values are 0-8. 8 is the highest.
 * @apiSince 17
 */

public int getEvdoSnr() { throw new RuntimeException("Stub!"); }

/** @apiSince 17 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 17 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * @return string representation.
 * @apiSince 17
 */

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

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface
 * @apiSince 17
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telephony.CellSignalStrengthCdma> CREATOR;
static { CREATOR = null; }
}

