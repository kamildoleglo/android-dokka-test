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


package android.net.wifi.p2p;

import android.os.Parcelable;

/**
 * A class representing a Wi-Fi p2p device
 *
 * Note that the operations are not thread safe
 * {@see WifiP2pManager}
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class WifiP2pDevice implements android.os.Parcelable {

/** @apiSince 14 */

public WifiP2pDevice() { throw new RuntimeException("Stub!"); }

/**
 * copy constructor
 * @apiSince 14
 */

public WifiP2pDevice(android.net.wifi.p2p.WifiP2pDevice source) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if WPS push button configuration is supported
 * @apiSince 14
 */

public boolean wpsPbcSupported() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if WPS keypad configuration is supported
 * @apiSince 14
 */

public boolean wpsKeypadSupported() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if WPS display configuration is supported
 * @apiSince 14
 */

public boolean wpsDisplaySupported() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the device is capable of service discovery
 * @apiSince 14
 */

public boolean isServiceDiscoveryCapable() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the device is a group owner
 * @apiSince 14
 */

public boolean isGroupOwner() { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface
 * @apiSince 14
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface
 * @apiSince 14
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public static final int AVAILABLE = 3; // 0x3

/** @apiSince 14 */

public static final int CONNECTED = 0; // 0x0

/**
 * Implement the Parcelable interface
 * @apiSince 14
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.net.wifi.p2p.WifiP2pDevice> CREATOR;
static { CREATOR = null; }

/** @apiSince 14 */

public static final int FAILED = 2; // 0x2

/** @apiSince 14 */

public static final int INVITED = 1; // 0x1

/** @apiSince 14 */

public static final int UNAVAILABLE = 4; // 0x4

/**
 * The device MAC address uniquely identifies a Wi-Fi p2p device
 * @apiSince 14
 */

public java.lang.String deviceAddress = "";

/**
 * The device name is a user friendly string to identify a Wi-Fi p2p device
 * @apiSince 14
 */

public java.lang.String deviceName = "";

/**
 * Primary device type identifies the type of device. For example, an application
 * could filter the devices discovered to only display printers if the purpose is to
 * enable a printing action from the user. See the Wi-Fi Direct technical specification
 * for the full list of standard device types supported.
 * @apiSince 14
 */

public java.lang.String primaryDeviceType;

/**
 * Secondary device type is an optional attribute that can be provided by a device in
 * addition to the primary device type.
 * @apiSince 14
 */

public java.lang.String secondaryDeviceType;

/**
 * Device connection status
 * @apiSince 14
 */

public int status = 4; // 0x4
}

