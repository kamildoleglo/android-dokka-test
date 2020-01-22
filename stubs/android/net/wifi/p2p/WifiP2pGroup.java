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
 * A class representing a Wi-Fi P2p group. A p2p group consists of a single group
 * owner and one or more clients. In the case of a group with only two devices, one
 * will be the group owner and the other will be a group client.
 *
 * {@see WifiP2pManager}
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class WifiP2pGroup implements android.os.Parcelable {

/** @apiSince 14 */

public WifiP2pGroup() { throw new RuntimeException("Stub!"); }

/**
 * copy constructor
 * @apiSince 14
 */

public WifiP2pGroup(android.net.wifi.p2p.WifiP2pGroup source) { throw new RuntimeException("Stub!"); }

/**
 * Get the network name (SSID) of the group. Legacy Wi-Fi clients will discover
 * the p2p group using the network name.
 * @apiSince 14
 */

public java.lang.String getNetworkName() { throw new RuntimeException("Stub!"); }

/**
 * Check whether this device is the group owner of the created p2p group
 * @apiSince 14
 */

public boolean isGroupOwner() { throw new RuntimeException("Stub!"); }

/**
 * Get the details of the group owner as a {@link android.net.wifi.p2p.WifiP2pDevice WifiP2pDevice} object
 * @apiSince 14
 */

public android.net.wifi.p2p.WifiP2pDevice getOwner() { throw new RuntimeException("Stub!"); }

/**
 * Get the list of clients currently part of the p2p group
 * @apiSince 14
 */

public java.util.Collection<android.net.wifi.p2p.WifiP2pDevice> getClientList() { throw new RuntimeException("Stub!"); }

/**
 * Get the passphrase of the group. This function will return a valid passphrase only
 * at the group owner. Legacy Wi-Fi clients will need this passphrase alongside
 * network name obtained from {@link #getNetworkName()} to join the group
 * @apiSince 14
 */

public java.lang.String getPassphrase() { throw new RuntimeException("Stub!"); }

/**
 * Get the interface name on which the group is created
 * @apiSince 14
 */

public java.lang.String getInterface() { throw new RuntimeException("Stub!"); }

/**
 * Get the operating frequency (in MHz) of the p2p group
 * @apiSince 29
 */

public int getFrequency() { throw new RuntimeException("Stub!"); }

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

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.net.wifi.p2p.WifiP2pGroup> CREATOR;
static { CREATOR = null; }
}

