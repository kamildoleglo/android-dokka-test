/*
 * Copyright (C) 2011 The Android Open Source Project
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


package android.net.wifi;

import android.os.Parcelable;

/**
 * A class representing Wi-Fi Protected Setup
 *
 * {@see WifiP2pConfig}
 * @apiSince 14
 * @deprecatedSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class WpsInfo implements android.os.Parcelable {

/** @apiSince 14 */

public WpsInfo() { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public WpsInfo(android.net.wifi.WpsInfo source) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 14
 * @deprecatedSince 28
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface
 * @apiSince 14
 * @deprecatedSince 28
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface
 * @apiSince 14
 * @deprecatedSince 28
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Passed with pin method KEYPAD
 * @apiSince 21
 * @deprecatedSince 28
 */

public java.lang.String BSSID;

/**
 * Implement the Parcelable interface
 * @apiSince 14
 * @deprecatedSince 28
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.net.wifi.WpsInfo> CREATOR;
static { CREATOR = null; }

/**
 * Display pin method configuration - pin is generated and displayed on device
 * @apiSince 14
 * @deprecatedSince 28
 */

public static final int DISPLAY = 1; // 0x1

/**
 * Invalid configuration
 * @apiSince 14
 * @deprecatedSince 28
 */

public static final int INVALID = 4; // 0x4

/**
 * Keypad pin method configuration - pin is entered on device
 * @apiSince 14
 * @deprecatedSince 28
 */

public static final int KEYPAD = 2; // 0x2

/**
 * Label pin method configuration - pin is labelled on device
 * @apiSince 14
 * @deprecatedSince 28
 */

public static final int LABEL = 3; // 0x3

/**
 * Push button configuration
 * @apiSince 14
 * @deprecatedSince 28
 */

public static final int PBC = 0; // 0x0

/**
 * Passed with pin method configuration
 * @apiSince 14
 * @deprecatedSince 28
 */

public java.lang.String pin;

/**
 * Wi-Fi Protected Setup. www.wi-fi.org/wifi-protected-setup has details
 * @apiSince 14
 * @deprecatedSince 28
 */

public int setup;
}

