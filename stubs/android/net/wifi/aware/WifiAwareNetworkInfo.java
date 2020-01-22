/*
 * Copyright (C) 2018 The Android Open Source Project
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


package android.net.wifi.aware;

import android.net.NetworkCapabilities;

/**
 * Wi-Fi Aware-specific network information. The information can be extracted from the
 * {@link android.net.NetworkCapabilities} of the network using
 * {@link android.net.NetworkCapabilities#getTransportInfo() NetworkCapabilities#getTransportInfo()}.
 * The {@link android.net.NetworkCapabilities NetworkCapabilities} is provided by the connectivity service to apps, e.g. received
 * through the
 * {@link android.net.ConnectivityManager.NetworkCallback#onCapabilitiesChanged(android.net.Network,
 * android.net.NetworkCapabilities)} callback.
 * <p>
 * The Wi-Fi Aware-specific network information include the peer's scoped link-local IPv6 address
 * for the Wi-Fi Aware link, as well as (optionally) the port and transport protocol specified by
 * the peer.
 * The scoped link-local IPv6, port, and transport protocol can then be used to create a
 * {@link java.net.Socket} connection to the peer.
 * <p>
 * Note: these are the peer's IPv6 and port information - not the local device's!
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class WifiAwareNetworkInfo implements android.net.TransportInfo, android.os.Parcelable {

WifiAwareNetworkInfo() { throw new RuntimeException("Stub!"); }

/**
 * Get the scoped link-local IPv6 address of the Wi-Fi Aware peer (not of the local device!).
 *
 * @return An IPv6 address.
 
 * This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.net.Inet6Address getPeerIpv6Addr() { throw new RuntimeException("Stub!"); }

/**
 * Get the port number to be used to create a network connection to the Wi-Fi Aware peer.
 * The port information is provided by the app running on the peer which requested the
 * connection, using the {@link android.net.wifi.aware.WifiAwareNetworkSpecifier.Builder#setPort(int) WifiAwareNetworkSpecifier.Builder#setPort(int)}.
 *
 * @return A port number on the peer. A value of 0 indicates that no port was specified by the
 *         peer.
 * @apiSince 29
 */

public int getPort() { throw new RuntimeException("Stub!"); }

/**
 * Get the transport protocol to be used to communicate over a network connection to the Wi-Fi
 * Aware peer. The transport protocol is provided by the app running on the peer which requested
 * the connection, using the
 * {@link android.net.wifi.aware.WifiAwareNetworkSpecifier.Builder#setTransportProtocol(int) WifiAwareNetworkSpecifier.Builder#setTransportProtocol(int)}.
 * <p>
 * The transport protocol number is assigned by the Internet Assigned Numbers Authority
 * (IANA) https://www.iana.org/assignments/protocol-numbers/protocol-numbers.xhtml.
 *
 * @return A transport protocol id. A value of -1 indicates that no transport protocol was
 *         specified by the peer.
 * @apiSince 29
 */

public int getTransportProtocol() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @hide */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @hide */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.net.wifi.aware.WifiAwareNetworkInfo> CREATOR;
static { CREATOR = null; }
}

