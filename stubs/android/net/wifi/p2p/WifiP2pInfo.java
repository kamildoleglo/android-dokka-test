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
 * A class representing connection information about a Wi-Fi p2p group
 *
 * {@see WifiP2pManager}
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class WifiP2pInfo implements android.os.Parcelable {

/** @apiSince 14 */

public WifiP2pInfo() { throw new RuntimeException("Stub!"); }

/**
 * copy constructor
 * @apiSince 14
 */

public WifiP2pInfo(android.net.wifi.p2p.WifiP2pInfo source) { throw new RuntimeException("Stub!"); }

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

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.net.wifi.p2p.WifiP2pInfo> CREATOR;
static { CREATOR = null; }

/**
 * Indicates if a p2p group has been successfully formed
 * @apiSince 14
 */

public boolean groupFormed;

/**
 * Group owner address
 * @apiSince 14
 */

public java.net.InetAddress groupOwnerAddress;

/**
 * Indicates if the current device is the group owner
 * @apiSince 14
 */

public boolean isGroupOwner;
}

