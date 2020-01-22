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

import java.util.concurrent.Executor;

/**
 * Manages the radio access network scan requests and callbacks.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class TelephonyScanManager {

/** @apiSince 28 */

public TelephonyScanManager() { throw new RuntimeException("Stub!"); }
/**
 * The caller of
 * {@link android.telephony.TelephonyManager#requestNetworkScan(android.telephony.NetworkScanRequest,java.util.concurrent.Executor,android.telephony.TelephonyScanManager.NetworkScanCallback) TelephonyManager#requestNetworkScan(NetworkScanRequest, Executor, NetworkScanCallback)}
 * should implement and provide this callback so that the scan results or errors can be
 * returned.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class NetworkScanCallback {

public NetworkScanCallback() { throw new RuntimeException("Stub!"); }

/**
 * Returns the scan results to the user, this callback will be called multiple times.
 * @apiSince 28
 */

public void onResults(java.util.List<android.telephony.CellInfo> results) { throw new RuntimeException("Stub!"); }

/**
 * Informs the user that the scan has stopped.
 *
 * This callback will be called when the scan is finished or cancelled by the user.
 * The related NetworkScanRequest will be deleted after this callback.
 * @apiSince 28
 */

public void onComplete() { throw new RuntimeException("Stub!"); }

/**
 * Informs the user that there is some error about the scan.
 *
 * This callback will be called whenever there is any error about the scan, and the scan
 * will be terminated. onComplete() will NOT be called.
 *
 * @param error Error code when the scan is failed, as defined in {@link android.telephony.NetworkScan NetworkScan}.
 
 * Value is {@link android.telephony.NetworkScan#ERROR_MODEM_ERROR}, {@link android.telephony.NetworkScan#ERROR_INVALID_SCAN}, {@link android.telephony.NetworkScan#ERROR_MODEM_UNAVAILABLE}, {@link android.telephony.NetworkScan#ERROR_UNSUPPORTED}, {@link android.telephony.NetworkScan#ERROR_RADIO_INTERFACE_ERROR}, {@link android.telephony.NetworkScan#ERROR_INVALID_SCANID}, or {@link android.telephony.NetworkScan#ERROR_INTERRUPTED}
 * @apiSince 28
 */

public void onError(int error) { throw new RuntimeException("Stub!"); }
}

}

