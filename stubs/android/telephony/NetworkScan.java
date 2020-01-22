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
 * The caller of
 * {@link android.telephony.TelephonyManager#requestNetworkScan(android.telephony.NetworkScanRequest,Executor,NetworkScanCallback) TelephonyManager#requestNetworkScan(NetworkScanRequest, Executor, NetworkScanCallback)}
 * will receive an instance of {@link android.telephony.NetworkScan NetworkScan}, which contains a callback method
 * {@link #stopScan()} for stopping the in-progress scan.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class NetworkScan {

NetworkScan() { throw new RuntimeException("Stub!"); }

/**
 * Stops the network scan
 *
 * Use this method to stop an ongoing scan. When user requests a new scan, a {@link android.telephony.NetworkScan NetworkScan}
 * object will be returned, and the user can stop the scan by calling this method.
 * @apiSince 28
 */

public void stopScan() { throw new RuntimeException("Stub!"); }

/**
 * The scan has been interrupted by another scan with higher priority.
 * @apiSince 28
 */

public static final int ERROR_INTERRUPTED = 10002; // 0x2712

/**
 * The parameters of the scan is invalid.
 * @apiSince 28
 */

public static final int ERROR_INVALID_SCAN = 2; // 0x2

/**
 * The scan ID is invalid. The user is either trying to stop a scan which does not exist
 * or started by others.
 * @apiSince 28
 */

public static final int ERROR_INVALID_SCANID = 10001; // 0x2711

/**
 * The scan has failed due to some modem errors.
 * @apiSince 28
 */

public static final int ERROR_MODEM_ERROR = 1; // 0x1

/**
 * The modem can not perform the scan because it is doing something else.
 * @apiSince 28
 */

public static final int ERROR_MODEM_UNAVAILABLE = 3; // 0x3

/**
 * The RIL returns nothing or exceptions.
 * @apiSince 28
 */

public static final int ERROR_RADIO_INTERFACE_ERROR = 10000; // 0x2710

/**
 * The modem does not support the request scan.
 * @apiSince 28
 */

public static final int ERROR_UNSUPPORTED = 4; // 0x4

/**
 * The RIL has successfully performed the network scan.
 * @apiSince 28
 */

public static final int SUCCESS = 0; // 0x0
}

