/*
 * Copyright (C) 2017 The Android Open Source Project
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
 * Defines a request to peform a network scan.
 *
 * This class defines whether the network scan will be performed only once or periodically until
 * cancelled, when the scan is performed periodically, the time interval is not controlled by the
 * user but defined by the modem vendor.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class NetworkScanRequest implements android.os.Parcelable {

/**
 * Creates a new NetworkScanRequest with mScanType and network mSpecifiers
 *
 * @param scanType The type of the scan, can be either one shot or periodic
 * @param specifiers the radio network with bands / channels to be scanned
 * @param searchPeriodicity The modem will restart the scan every searchPeriodicity seconds if
 *                          no network has been found, until it reaches the maxSearchTime. Only
 *                          valid when scan type is periodic scan.
 * @param maxSearchTime Maximum duration of the search (in seconds)
 * @param incrementalResults Indicates whether the modem should report incremental
 *                           results of the network scan to the client
 * @param incrementalResultsPeriodicity Indicates the periodicity with which the modem should
 *                                      report incremental results to the client (in seconds),
 *                                      only valid when incrementalResults is true
 * @param mccMncs Describes the list of PLMN ids (MCC-MNC), once any network in the list has
 *                been found, the scan will be terminated by the modem.
 * @apiSince 28
 */

public NetworkScanRequest(int scanType, android.telephony.RadioAccessSpecifier[] specifiers, int searchPeriodicity, int maxSearchTime, boolean incrementalResults, int incrementalResultsPeriodicity, java.util.ArrayList<java.lang.String> mccMncs) { throw new RuntimeException("Stub!"); }

/**
 * Returns the type of the scan.
 * @return Value is {@link android.telephony.NetworkScanRequest#SCAN_TYPE_ONE_SHOT}, or {@link android.telephony.NetworkScanRequest#SCAN_TYPE_PERIODIC}
 * @apiSince 28
 */

public int getScanType() { throw new RuntimeException("Stub!"); }

/**
 * Returns the search periodicity in seconds.
 * @apiSince 28
 */

public int getSearchPeriodicity() { throw new RuntimeException("Stub!"); }

/**
 * Returns maximum duration of the periodic search in seconds.
 * @apiSince 28
 */

public int getMaxSearchTime() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether incremental result is enabled.
 * FALSE – Incremental results is not enabled.
 * TRUE – Incremental results is reported.
 * @apiSince 28
 */

public boolean getIncrementalResults() { throw new RuntimeException("Stub!"); }

/**
 * Returns the periodicity in seconds of incremental results.
 * @apiSince 28
 */

public int getIncrementalResultsPeriodicity() { throw new RuntimeException("Stub!"); }

/**
 * Returns the radio access technologies with bands or channels that need to be scanned.
 * @apiSince 28
 */

public android.telephony.RadioAccessSpecifier[] getSpecifiers() { throw new RuntimeException("Stub!"); }

/**
 * Returns the List of PLMN ids (MCC-MNC) for early termination of scan.
 * If any PLMN of this list is found, search should end at that point and
 * results with all PLMN found till that point should be sent as response.
 * @apiSince 28
 */

public java.util.ArrayList<java.lang.String> getPlmns() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telephony.NetworkScanRequest> CREATOR;
static { CREATOR = null; }

/**
 * Performs the scan only once
 * @apiSince 28
 */

public static final int SCAN_TYPE_ONE_SHOT = 0; // 0x0

/**
 * Performs the scan periodically until cancelled
 *
 * The modem will start new scans periodically, and the interval between two scans is usually
 * multiple minutes.
 * @apiSince 28
 */

public static final int SCAN_TYPE_PERIODIC = 1; // 0x1
}

