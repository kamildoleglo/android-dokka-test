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
 * 5G NR signal strength related information.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CellSignalStrengthNr extends android.telephony.CellSignalStrength implements android.os.Parcelable {

CellSignalStrengthNr() { throw new RuntimeException("Stub!"); }

/**
 * Reference: 3GPP TS 38.215.
 * Range: -140 dBm to -44 dBm.
 * @return SS reference signal received power, {@link android.telephony.CellInfo#UNAVAILABLE CellInfo#UNAVAILABLE} means unreported
 * value.
 * @apiSince 29
 */

public int getSsRsrp() { throw new RuntimeException("Stub!"); }

/**
 * Reference: 3GPP TS 38.215.
 * Range: -20 dB to -3 dB.
 * @return SS reference signal received quality, {@link android.telephony.CellInfo#UNAVAILABLE CellInfo#UNAVAILABLE} means unreported
 * value.
 * @apiSince 29
 */

public int getSsRsrq() { throw new RuntimeException("Stub!"); }

/**
 * Reference: 3GPP TS 38.215 Sec 5.1.*, 3GPP TS 38.133 10.1.16.1
 * Range: -23 dB to 40 dB
 * @return SS signal-to-noise and interference ratio, {@link android.telephony.CellInfo#UNAVAILABLE CellInfo#UNAVAILABLE} means
 * unreported value.
 * @apiSince 29
 */

public int getSsSinr() { throw new RuntimeException("Stub!"); }

/**
 * Reference: 3GPP TS 38.215.
 * Range: -140 dBm to -44 dBm.
 * @return CSI reference signal received power, {@link android.telephony.CellInfo#UNAVAILABLE CellInfo#UNAVAILABLE} means unreported
 * value.
 * @apiSince 29
 */

public int getCsiRsrp() { throw new RuntimeException("Stub!"); }

/**
 * Reference: 3GPP TS 38.215.
 * Range: -20 dB to -3 dB.
 * @return CSI reference signal received quality, {@link android.telephony.CellInfo#UNAVAILABLE CellInfo#UNAVAILABLE} means unreported
 * value.
 * @apiSince 29
 */

public int getCsiRsrq() { throw new RuntimeException("Stub!"); }

/**
 * Reference: 3GPP TS 38.215 Sec 5.1.*, 3GPP TS 38.133 10.1.16.1
 * Range: -23 dB to 23 dB
 * @return CSI signal-to-noise and interference ratio, {@link android.telephony.CellInfo#UNAVAILABLE CellInfo#UNAVAILABLE} means
 * unreported value.
 * @apiSince 29
 */

public int getCsiSinr() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @hide */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @return Value is between SIGNAL_STRENGTH_NONE_OR_UNKNOWN and SIGNAL_STRENGTH_GREAT inclusive
 * @apiSince 29
 */

public int getLevel() { throw new RuntimeException("Stub!"); }

/**
 * Get the RSRP in ASU.
 *
 * Asu is calculated based on 3GPP RSRP. Refer to 3GPP 27.007 (Ver 10.3.0) Sec 8.69
 *
 * @return RSRP in ASU 0..97, 255, or UNAVAILABLE
 * @apiSince 29
 */

public int getAsuLevel() { throw new RuntimeException("Stub!"); }

/**
 * Get the SS-RSRP as dBm value -140..-44dBm or {@link android.telephony.CellInfo#UNAVAILABLE CellInfo#UNAVAILABLE}.
 * @apiSince 29
 */

public int getDbm() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telephony.CellSignalStrengthNr> CREATOR;
static { CREATOR = null; }
}

