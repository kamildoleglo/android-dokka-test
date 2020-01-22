/*
 * Copyright (C) 2014 The Android Open Source Project
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


package android.bluetooth.le;

import java.util.List;

/**
 * Bluetooth LE scan callbacks. Scan results are reported using these callbacks.
 *
 * @see BluetoothLeScanner#startScan
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class ScanCallback {

public ScanCallback() { throw new RuntimeException("Stub!"); }

/**
 * Callback when a BLE advertisement has been found.
 *
 * @param callbackType Determines how this callback was triggered. Could be one of {@link android.bluetooth.le.ScanSettings#CALLBACK_TYPE_ALL_MATCHES ScanSettings#CALLBACK_TYPE_ALL_MATCHES}, {@link android.bluetooth.le.ScanSettings#CALLBACK_TYPE_FIRST_MATCH ScanSettings#CALLBACK_TYPE_FIRST_MATCH} or
 * {@link android.bluetooth.le.ScanSettings#CALLBACK_TYPE_MATCH_LOST ScanSettings#CALLBACK_TYPE_MATCH_LOST}
 * @param result A Bluetooth LE scan result.
 * @apiSince 21
 */

public void onScanResult(int callbackType, android.bluetooth.le.ScanResult result) { throw new RuntimeException("Stub!"); }

/**
 * Callback when batch results are delivered.
 *
 * @param results List of scan results that are previously scanned.
 * @apiSince 21
 */

public void onBatchScanResults(java.util.List<android.bluetooth.le.ScanResult> results) { throw new RuntimeException("Stub!"); }

/**
 * Callback when scan could not be started.
 *
 * @param errorCode Error code (one of SCAN_FAILED_*) for scan failure.
 * @apiSince 21
 */

public void onScanFailed(int errorCode) { throw new RuntimeException("Stub!"); }

/**
 * Fails to start scan as BLE scan with the same settings is already started by the app.
 * @apiSince 21
 */

public static final int SCAN_FAILED_ALREADY_STARTED = 1; // 0x1

/**
 * Fails to start scan as app cannot be registered.
 * @apiSince 21
 */

public static final int SCAN_FAILED_APPLICATION_REGISTRATION_FAILED = 2; // 0x2

/**
 * Fails to start power optimized scan as this feature is not supported.
 * @apiSince 21
 */

public static final int SCAN_FAILED_FEATURE_UNSUPPORTED = 4; // 0x4

/**
 * Fails to start scan due an internal error
 * @apiSince 21
 */

public static final int SCAN_FAILED_INTERNAL_ERROR = 3; // 0x3
}

