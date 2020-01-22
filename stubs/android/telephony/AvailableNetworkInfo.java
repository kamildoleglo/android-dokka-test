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

import java.util.List;

/**
 * Defines available network information which includes corresponding subscription id,
 * network plmns and corresponding priority to be used for network selection by Opportunistic
 * Network Service when passed through {@link android.telephony.TelephonyManager#updateAvailableNetworks TelephonyManager#updateAvailableNetworks}
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class AvailableNetworkInfo implements android.os.Parcelable {

/**
 * @param mccMncs This value must never be {@code null}.
 
 * @param bands This value must never be {@code null}.
 * @apiSince 29
 */

public AvailableNetworkInfo(int subId, int priority, @androidx.annotation.NonNull java.util.List<java.lang.String> mccMncs, @androidx.annotation.NonNull java.util.List<java.lang.Integer> bands) { throw new RuntimeException("Stub!"); }

/**
 * Return subscription Id of the available network.
 * This value must be one of the entry retrieved from
 * {@link android.telephony.SubscriptionManager#getOpportunisticSubscriptions SubscriptionManager#getOpportunisticSubscriptions}
 * @return subscription id
 * @apiSince 29
 */

public int getSubId() { throw new RuntimeException("Stub!"); }

/**
 * Return priority for the subscription id.
 * Priorities are in the range of {@link android.telephony.AvailableNetworkInfo#PRIORITY_LOW AvailableNetworkInfo#PRIORITY_LOW} to
 * {@link android.telephony.AvailableNetworkInfo#PRIORITY_HIGH AvailableNetworkInfo#PRIORITY_HIGH}
 * Among all networks available after network scan, subId with highest priority is chosen
 * for network selection. If there are more than one subId with highest priority then the
 * network with highest RSRP is chosen.
 * @return priority level
 * @apiSince 29
 */

public int getPriority() { throw new RuntimeException("Stub!"); }

/**
 * Return List of PLMN ids (MCC-MNC) associated with the sub ID.
 * Opportunistic Network Service will scan and verify specified PLMNs are available.
 * If this entry is left empty, then the Opportunistic Network Service will not scan the network
 * to validate the network availability.
 * @return list of PLMN ids
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.util.List<java.lang.String> getMccMncs() { throw new RuntimeException("Stub!"); }

/**
 * Returns the frequency bands that need to be scanned by opportunistic network service
 *
 * The returned value is defined in either of {@link android.telephony.AccessNetworkConstants.GeranBand AccessNetworkConstants.GeranBand},
 * {@link android.telephony.AccessNetworkConstants.UtranBand AccessNetworkConstants.UtranBand} and {@link android.telephony.AccessNetworkConstants.EutranBand AccessNetworkConstants.EutranBand}
 * See {@link android.telephony.AccessNetworkConstants.AccessNetworkType AccessNetworkConstants.AccessNetworkType} for details regarding different network
 * types. When no specific bands are specified (empty array or null) CBRS band
 * {@link android.telephony.AccessNetworkConstants.EutranBand#BAND_48 AccessNetworkConstants.EutranBand#BAND_48} will be used for network scan.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.util.List<java.lang.Integer> getBands() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telephony.AvailableNetworkInfo> CREATOR;
static { CREATOR = null; }

/** @apiSince 29 */

public static final int PRIORITY_HIGH = 1; // 0x1

/** @apiSince 29 */

public static final int PRIORITY_LOW = 3; // 0x3

/** @apiSince 29 */

public static final int PRIORITY_MED = 2; // 0x2
}

