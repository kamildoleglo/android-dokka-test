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


package android.net.wifi.rtt;

import java.util.List;

/**
 * Base class for ranging result callbacks. Should be extended by applications and set when calling
 * {@link android.net.wifi.rtt.WifiRttManager#startRanging(android.net.wifi.rtt.RangingRequest,java.util.concurrent.Executor,android.net.wifi.rtt.RangingResultCallback) WifiRttManager#startRanging(RangingRequest, java.util.concurrent.Executor, RangingResultCallback)}.
 * If the ranging operation fails in whole (not attempted) then {@link #onRangingFailure(int)}
 * will be called with a failure code. If the ranging operation is performed for each of the
 * requested peers then the {@link #onRangingResults(java.util.List)} will be called with the set of
 * results (@link {@link android.net.wifi.rtt.RangingResult RangingResult}, each of which has its own success/failure code
 * {@link android.net.wifi.rtt.RangingResult#getStatus() RangingResult#getStatus()}.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class RangingResultCallback {

public RangingResultCallback() { throw new RuntimeException("Stub!"); }

/**
 * Called when a ranging operation failed in whole - i.e. no ranging operation to any of the
 * devices specified in the request was attempted.
 *
 * @param code A status code indicating the type of failure.
 
 * Value is {@link android.net.wifi.rtt.RangingResultCallback#STATUS_CODE_FAIL}, or {@link android.net.wifi.rtt.RangingResultCallback#STATUS_CODE_FAIL_RTT_NOT_AVAILABLE}
 * @apiSince 28
 */

public abstract void onRangingFailure(int code);

/**
 * Called when a ranging operation was executed. The list of results corresponds to devices
 * specified in the ranging request.
 *
 * @param results List of range measurements, one per requested device.
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public abstract void onRangingResults(@androidx.annotation.NonNull java.util.List<android.net.wifi.rtt.RangingResult> results);

/**
 * A failure code for the whole ranging request operation. Indicates a failure.
 * @apiSince 28
 */

public static final int STATUS_CODE_FAIL = 1; // 0x1

/**
 * A failure code for the whole ranging request operation. Indicates that the request failed due
 * to RTT not being available - e.g. Wi-Fi was disabled. Use the
 * {@link android.net.wifi.rtt.WifiRttManager#isAvailable() WifiRttManager#isAvailable()} and {@link android.net.wifi.rtt.WifiRttManager#ACTION_WIFI_RTT_STATE_CHANGED WifiRttManager#ACTION_WIFI_RTT_STATE_CHANGED}
 * to track RTT availability.
 * @apiSince 28
 */

public static final int STATUS_CODE_FAIL_RTT_NOT_AVAILABLE = 2; // 0x2
}

