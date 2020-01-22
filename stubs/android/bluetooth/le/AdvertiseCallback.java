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


/**
 * Bluetooth LE advertising callbacks, used to deliver advertising operation status.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class AdvertiseCallback {

public AdvertiseCallback() { throw new RuntimeException("Stub!"); }

/**
 * Callback triggered in response to {@link android.bluetooth.le.BluetoothLeAdvertiser#startAdvertising BluetoothLeAdvertiser#startAdvertising} indicating
 * that the advertising has been started successfully.
 *
 * @param settingsInEffect The actual settings used for advertising, which may be different from
 * what has been requested.
 * @apiSince 21
 */

public void onStartSuccess(android.bluetooth.le.AdvertiseSettings settingsInEffect) { throw new RuntimeException("Stub!"); }

/**
 * Callback when advertising could not be started.
 *
 * @param errorCode Error code (see ADVERTISE_FAILED_* constants) for advertising start
 * failures.
 * @apiSince 21
 */

public void onStartFailure(int errorCode) { throw new RuntimeException("Stub!"); }

/**
 * Failed to start advertising as the advertising is already started.
 * @apiSince 21
 */

public static final int ADVERTISE_FAILED_ALREADY_STARTED = 3; // 0x3

/**
 * Failed to start advertising as the advertise data to be broadcasted is larger than 31 bytes.
 * @apiSince 21
 */

public static final int ADVERTISE_FAILED_DATA_TOO_LARGE = 1; // 0x1

/**
 * This feature is not supported on this platform.
 * @apiSince 21
 */

public static final int ADVERTISE_FAILED_FEATURE_UNSUPPORTED = 5; // 0x5

/**
 * Operation failed due to an internal error.
 * @apiSince 21
 */

public static final int ADVERTISE_FAILED_INTERNAL_ERROR = 4; // 0x4

/**
 * Failed to start advertising because no advertising instance is available.
 * @apiSince 21
 */

public static final int ADVERTISE_FAILED_TOO_MANY_ADVERTISERS = 2; // 0x2
}

