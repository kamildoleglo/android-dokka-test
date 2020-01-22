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


package android.net.wifi.aware;

import android.net.NetworkSpecifier;

/**
 * Network specifier object used to request a Wi-Fi Aware network. Apps should use the
 * {@link android.net.wifi.aware.WifiAwareNetworkSpecifier.Builder WifiAwareNetworkSpecifier.Builder} class to create an instance.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class WifiAwareNetworkSpecifier extends android.net.NetworkSpecifier implements android.os.Parcelable {

WifiAwareNetworkSpecifier() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @hide */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @hide */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @hide */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.net.wifi.aware.WifiAwareNetworkSpecifier> CREATOR;
static { CREATOR = null; }
/**
 * A builder class for a Wi-Fi Aware network specifier to set up an Aware connection with a
 * peer.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Create a builder for {@link android.net.wifi.aware.WifiAwareNetworkSpecifier WifiAwareNetworkSpecifier} used in requests to set up a
 * Wi-Fi Aware connection with a peer.
 *
 * @param discoverySession A Wi-Fi Aware discovery session in whose context the connection
 *                         is created.
 * This value must never be {@code null}.
 * @param peerHandle The handle of the peer to which the Wi-Fi Aware connection is
 *                   requested. The peer is discovered through Wi-Fi Aware discovery. The
 *                   handle can be obtained through
 * {@link android.net.wifi.aware.DiscoverySessionCallback#onServiceDiscovered(android.net.wifi.aware.PeerHandle,byte[],java.util.List) DiscoverySessionCallback#onServiceDiscovered(PeerHandle, byte[], java.util.List)}
 *                   or
 *                   {@link android.net.wifi.aware.DiscoverySessionCallback#onMessageReceived(android.net.wifi.aware.PeerHandle,byte[]) DiscoverySessionCallback#onMessageReceived(PeerHandle, byte[])}.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public Builder(@androidx.annotation.NonNull android.net.wifi.aware.DiscoverySession discoverySession, @androidx.annotation.NonNull android.net.wifi.aware.PeerHandle peerHandle) { throw new RuntimeException("Stub!"); }

/**
 * Configure the PSK Passphrase for the Wi-Fi Aware connection being requested. This method
 * is optional - if not called, then an Open (unencrypted) connection will be created.
 *
 * @param pskPassphrase The (optional) passphrase to be used to encrypt the link.
 * This value must never be {@code null}.
 * @return the current {@link android.net.wifi.aware.WifiAwareNetworkSpecifier.Builder Builder} builder, enabling chaining of builder
 *         methods.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.wifi.aware.WifiAwareNetworkSpecifier.Builder setPskPassphrase(@androidx.annotation.NonNull java.lang.String pskPassphrase) { throw new RuntimeException("Stub!"); }

/**
 * Configure the port number which will be used to create a connection over this link. This
 * configuration should only be done on the server device, e.g. the device creating the
 * {@link java.net.ServerSocket}.
 * <p>Notes:
 * <ul>
 *     <li>The server device must be the Publisher device!
 *     <li>The port information can only be specified on secure links, specified using
 *     {@link #setPskPassphrase(java.lang.String)}.
 * </ul>
 *
 * @param port A positive integer indicating the port to be used for communication.
 * Value is between 0 and 65535 inclusive
 * @return the current {@link android.net.wifi.aware.WifiAwareNetworkSpecifier.Builder Builder} builder, enabling chaining of builder
 *         methods.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.wifi.aware.WifiAwareNetworkSpecifier.Builder setPort(int port) { throw new RuntimeException("Stub!"); }

/**
 * Configure the transport protocol which will be used to create a connection over this
 * link. This configuration should only be done on the server device, e.g. the device
 * creating the {@link java.net.ServerSocket} for TCP.
 * <p>Notes:
 * <ul>
 *     <li>The server device must be the Publisher device!
 *     <li>The transport protocol information can only be specified on secure links,
 *     specified using {@link #setPskPassphrase(java.lang.String)}.
 * </ul>
 * The transport protocol number is assigned by the Internet Assigned Numbers Authority
 * (IANA) https://www.iana.org/assignments/protocol-numbers/protocol-numbers.xhtml.
 *
 * @param transportProtocol The transport protocol to be used for communication.
 * Value is between 0 and 255 inclusive
 * @return the current {@link android.net.wifi.aware.WifiAwareNetworkSpecifier.Builder Builder} builder, enabling chaining of builder
 *         methods.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.wifi.aware.WifiAwareNetworkSpecifier.Builder setTransportProtocol(int transportProtocol) { throw new RuntimeException("Stub!"); }

/**
 * Create a {@link android.net.NetworkRequest.Builder#setNetworkSpecifier(NetworkSpecifier)}
 * for a WiFi Aware connection (link) to the specified peer. The
 * {@link android.net.NetworkRequest.Builder#addTransportType(int)} should be set to
 * {@link android.net.NetworkCapabilities#TRANSPORT_WIFI_AWARE}.
 * <p> The default builder constructor will initialize a NetworkSpecifier which requests an
 * open (non-encrypted) link. To request an encrypted link use the
 * {@link #setPskPassphrase(java.lang.String)} builder method.
 *
 * @return A {@link android.net.NetworkSpecifier NetworkSpecifier} to be used to construct
 * {@link android.net.NetworkRequest.Builder#setNetworkSpecifier(NetworkSpecifier)} to pass
 * to {@link android.net.ConnectivityManager#requestNetwork(android.net.NetworkRequest,
 * android.net.ConnectivityManager.NetworkCallback)}
 * [or other varieties of that API].
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.wifi.aware.WifiAwareNetworkSpecifier build() { throw new RuntimeException("Stub!"); }
}

}

