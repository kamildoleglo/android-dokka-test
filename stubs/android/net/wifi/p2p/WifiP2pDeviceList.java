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

import android.net.wifi.p2p.WifiP2pDevice;
import android.os.Parcelable;

/**
 * A class representing a Wi-Fi P2p device list.
 *
 * Note that the operations are not thread safe.
 * {@see WifiP2pManager}
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class WifiP2pDeviceList implements android.os.Parcelable {

/** @apiSince 14 */

public WifiP2pDeviceList() { throw new RuntimeException("Stub!"); }

/**
 * copy constructor
 * @apiSince 14
 */

public WifiP2pDeviceList(android.net.wifi.p2p.WifiP2pDeviceList source) { throw new RuntimeException("Stub!"); }

/**
 * Fetch a device from the list
 * @param deviceAddress is the address of the device
 * @return WifiP2pDevice device found, or null if none found
 * @apiSince 18
 */

public android.net.wifi.p2p.WifiP2pDevice get(java.lang.String deviceAddress) { throw new RuntimeException("Stub!"); }

/**
 * Get the list of devices
 * @apiSince 14
 */

public java.util.Collection<android.net.wifi.p2p.WifiP2pDevice> getDeviceList() { throw new RuntimeException("Stub!"); }

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

/**
 * Implement the Parcelable interface
 * @apiSince 14
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.net.wifi.p2p.WifiP2pDeviceList> CREATOR;
static { CREATOR = null; }
}

