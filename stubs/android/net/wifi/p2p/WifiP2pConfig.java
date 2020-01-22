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
 * A class representing a Wi-Fi P2p configuration for setting up a connection
 *
 * {@see WifiP2pManager}
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class WifiP2pConfig implements android.os.Parcelable {

/** @apiSince 14 */

public WifiP2pConfig() { throw new RuntimeException("Stub!"); }

/**
 * copy constructor
 * @apiSince 14
 */

public WifiP2pConfig(android.net.wifi.p2p.WifiP2pConfig source) { throw new RuntimeException("Stub!"); }

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

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.net.wifi.p2p.WifiP2pConfig> CREATOR;
static { CREATOR = null; }

/**
 * Allow the system to pick the operating frequency from the 2.4 GHz band.
 * @apiSince 29
 */

public static final int GROUP_OWNER_BAND_2GHZ = 1; // 0x1

/**
 * Allow the system to pick the operating frequency from the 5 GHz band.
 * @apiSince 29
 */

public static final int GROUP_OWNER_BAND_5GHZ = 2; // 0x2

/**
 * Allow the system to pick the operating frequency from all supported bands.
 * @apiSince 29
 */

public static final int GROUP_OWNER_BAND_AUTO = 0; // 0x0

/**
 * The device MAC address uniquely identifies a Wi-Fi p2p device
 * @apiSince 14
 */

public java.lang.String deviceAddress = "";

/**
 * This is an integer value between 0 and 15 where 0 indicates the least
 * inclination to be a group owner and 15 indicates the highest inclination
 * to be a group owner.
 *
 * A value of -1 indicates the system can choose an appropriate value.
 * @apiSince 14
 */

public int groupOwnerIntent = -1; // 0xffffffff

/**
 * Wi-Fi Protected Setup information
 * @apiSince 14
 */

public android.net.wifi.WpsInfo wps;
/**
 * Builder used to build {@link android.net.wifi.p2p.WifiP2pConfig WifiP2pConfig} objects for
 * creating or joining a group.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Specify the peer's MAC address. If not set, the device will
 * try to find a peer whose SSID matches the network name as
 * specified by {@link #setNetworkName(java.lang.String)}. Specifying null will
 * reset the peer's MAC address to "02:00:00:00:00:00".
 * <p>
 *     Optional. "02:00:00:00:00:00" by default.
 *
 * @param deviceAddress the peer's MAC address.
 * This value may be {@code null}.
 * @return The builder to facilitate chaining
 *         {@code builder.setXXX(..).setXXX(..)}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.wifi.p2p.WifiP2pConfig.Builder setDeviceAddress(@androidx.annotation.Nullable android.net.MacAddress deviceAddress) { throw new RuntimeException("Stub!"); }

/**
 * Specify the network name, a.k.a. group name,
 * for creating or joining a group.
 * <p>
 * A network name shall begin with "DIRECT-xy". x and y are selected
 * from the following character set: upper case letters, lower case
 * letters and numbers. Any byte values allowed for an SSID according to
 * IEEE802.11-2012 [1] may be included after the string "DIRECT-xy"
 * (including none).
 * <p>
 *     Must be called - an empty network name or an network name
 *     not conforming to the P2P Group ID naming rule is not valid.
 *
 * @param networkName network name of a group.
 * This value must never be {@code null}.
 * @return The builder to facilitate chaining
 *         {@code builder.setXXX(..).setXXX(..)}.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.wifi.p2p.WifiP2pConfig.Builder setNetworkName(@androidx.annotation.NonNull java.lang.String networkName) { throw new RuntimeException("Stub!"); }

/**
 * Specify the passphrase for creating or joining a group.
 * <p>
 * The passphrase must be an ASCII string whose length is between 8
 * and 63.
 * <p>
 *     Must be called - an empty passphrase is not valid.
 *
 * @param passphrase the passphrase of a group.
 * This value must never be {@code null}.
 * @return The builder to facilitate chaining
 *         {@code builder.setXXX(..).setXXX(..)}.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.wifi.p2p.WifiP2pConfig.Builder setPassphrase(@androidx.annotation.NonNull java.lang.String passphrase) { throw new RuntimeException("Stub!"); }

/**
 * Specify the band to use for creating the group or joining the group. The band should
 * be {@link #GROUP_OWNER_BAND_2GHZ}, {@link #GROUP_OWNER_BAND_5GHZ} or
 * {@link #GROUP_OWNER_BAND_AUTO}.
 * <p>
 * When creating a group as Group Owner using {@link android.net.wifi.p2p.WifiP2pManager#createGroup(android.net.wifi.p2p.WifiP2pManager.Channel,android.net.wifi.p2p.WifiP2pConfig,android.net.wifi.p2p.WifiP2pManager.ActionListener) WifiP2pManager#createGroup(WifiP2pManager.Channel,
 * WifiP2pConfig, WifiP2pManager.ActionListener)},
 * specifying {@link #GROUP_OWNER_BAND_AUTO} allows the system to pick the operating
 * frequency from all supported bands.
 * Specifying {@link #GROUP_OWNER_BAND_2GHZ} or {@link #GROUP_OWNER_BAND_5GHZ}
 * only allows the system to pick the operating frequency in the specified band.
 * If the Group Owner cannot create a group in the specified band, the operation will fail.
 * <p>
 * When joining a group as Group Client using {@link android.net.wifi.p2p.WifiP2pManager#connect(android.net.wifi.p2p.WifiP2pManager.Channel,android.net.wifi.p2p.WifiP2pConfig,android.net.wifi.p2p.WifiP2pManager.ActionListener) WifiP2pManager#connect(WifiP2pManager.Channel, WifiP2pConfig,
 * WifiP2pManager.ActionListener)},
 * specifying {@link #GROUP_OWNER_BAND_AUTO} allows the system to scan all supported
 * frequencies to find the desired group. Specifying {@link #GROUP_OWNER_BAND_2GHZ} or
 * {@link #GROUP_OWNER_BAND_5GHZ} only allows the system to scan the specified band.
 * <p>
 *     {@link #setGroupOperatingBand(int)} and {@link #setGroupOperatingFrequency(int)} are
 *     mutually exclusive. Setting operating band and frequency both is invalid.
 * <p>
 *     Optional. {@link #GROUP_OWNER_BAND_AUTO} by default.
 *
 * @param band the operating band of the group.
 *             This should be one of {@link #GROUP_OWNER_BAND_AUTO},
 *             {@link #GROUP_OWNER_BAND_2GHZ}, {@link #GROUP_OWNER_BAND_5GHZ}.
 * Value is {@link android.net.wifi.p2p.WifiP2pConfig#GROUP_OWNER_BAND_AUTO}, {@link android.net.wifi.p2p.WifiP2pConfig#GROUP_OWNER_BAND_2GHZ}, or {@link android.net.wifi.p2p.WifiP2pConfig#GROUP_OWNER_BAND_5GHZ}
 * @return The builder to facilitate chaining
 *         {@code builder.setXXX(..).setXXX(..)}.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.wifi.p2p.WifiP2pConfig.Builder setGroupOperatingBand(int band) { throw new RuntimeException("Stub!"); }

/**
 * Specify the frequency, in MHz, to use for creating the group or joining the group.
 * <p>
 * When creating a group as Group Owner using {@link android.net.wifi.p2p.WifiP2pManager#createGroup(android.net.wifi.p2p.WifiP2pManager.Channel,android.net.wifi.p2p.WifiP2pConfig,android.net.wifi.p2p.WifiP2pManager.ActionListener) WifiP2pManager#createGroup(
 * WifiP2pManager.Channel, WifiP2pConfig, WifiP2pManager.ActionListener)},
 * specifying a frequency only allows the system to pick the specified frequency.
 * If the Group Owner cannot create a group at the specified frequency,
 * the operation will fail.
 * When not specifying a frequency, it allows the system to pick operating frequency
 * from all supported bands.
 * <p>
 * When joining a group as Group Client using {@link android.net.wifi.p2p.WifiP2pManager#connect(android.net.wifi.p2p.WifiP2pManager.Channel,android.net.wifi.p2p.WifiP2pConfig,android.net.wifi.p2p.WifiP2pManager.ActionListener) WifiP2pManager#connect(
 * WifiP2pManager.Channel, WifiP2pConfig, WifiP2pManager.ActionListener)},
 * specifying a frequency only allows the system to scan the specified frequency.
 * If the frequency is not supported or invalid, the operation will fail.
 * When not specifying a frequency, it allows the system to scan all supported
 * frequencies to find the desired group.
 * <p>
 *     {@link #setGroupOperatingBand(int)} and {@link #setGroupOperatingFrequency(int)} are
 *     mutually exclusive. Setting operating band and frequency both is invalid.
 * <p>
 *     Optional. 0 by default.
 *
 * @param frequency the operating frequency of the group.
 * @return The builder to facilitate chaining
 *         {@code builder.setXXX(..).setXXX(..)}.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.wifi.p2p.WifiP2pConfig.Builder setGroupOperatingFrequency(int frequency) { throw new RuntimeException("Stub!"); }

/**
 * Specify that the group configuration be persisted (i.e. saved).
 * By default the group configuration will not be saved.
 * <p>
 *     Optional. false by default.
 *
 * @param persistent is this group persistent group.
 * @return The builder to facilitate chaining
 *         {@code builder.setXXX(..).setXXX(..)}.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.wifi.p2p.WifiP2pConfig.Builder enablePersistentMode(boolean persistent) { throw new RuntimeException("Stub!"); }

/**
 * Build {@link android.net.wifi.p2p.WifiP2pConfig WifiP2pConfig} given the current requests made on the builder.
 * @return {@link android.net.wifi.p2p.WifiP2pConfig WifiP2pConfig} constructed based on builder method calls.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.wifi.p2p.WifiP2pConfig build() { throw new RuntimeException("Stub!"); }
}

}

