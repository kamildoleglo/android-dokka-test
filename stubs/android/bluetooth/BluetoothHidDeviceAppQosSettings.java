/*
 * Copyright (C) 2016 The Android Open Source Project
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


package android.bluetooth;


/**
 * Represents the Quality of Service (QoS) settings for a Bluetooth HID Device application.
 *
 * <p>The BluetoothHidDevice framework will update the L2CAP QoS settings for the app during
 * registration.
 *
 * <p>{@see BluetoothHidDevice}
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class BluetoothHidDeviceAppQosSettings implements android.os.Parcelable {

/**
 * Create a BluetoothHidDeviceAppQosSettings object for the Bluetooth L2CAP channel. The QoS
 * Settings is optional. Please refer to Bluetooth HID Specfication v1.1.1 Section 5.2 and
 * Appendix D for parameters.
 *
 * @param serviceType L2CAP service type, default = SERVICE_BEST_EFFORT
 * @param tokenRate L2CAP token rate, default = 0
 * @param tokenBucketSize L2CAP token bucket size, default = 0
 * @param peakBandwidth L2CAP peak bandwidth, default = 0
 * @param latency L2CAP latency, default = MAX
 * @param delayVariation L2CAP delay variation, default = MAX
 * @apiSince 28
 */

public BluetoothHidDeviceAppQosSettings(int serviceType, int tokenRate, int tokenBucketSize, int peakBandwidth, int latency, int delayVariation) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int getServiceType() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int getTokenRate() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int getTokenBucketSize() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int getPeakBandwidth() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int getLatency() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int getDelayVariation() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.bluetooth.BluetoothHidDeviceAppQosSettings> CREATOR;
static { CREATOR = null; }

/** @apiSince 28 */

public static final int MAX = -1; // 0xffffffff

/** @apiSince 28 */

public static final int SERVICE_BEST_EFFORT = 1; // 0x1

/** @apiSince 28 */

public static final int SERVICE_GUARANTEED = 2; // 0x2

/** @apiSince 28 */

public static final int SERVICE_NO_TRAFFIC = 0; // 0x0
}

