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


package android.net;

import android.net.ConnectivityManager.NetworkCallback;
import java.util.Set;

/**
 * Representation of the capabilities of an active network. Instances are
 * typically obtained through
 * {@link android.net.ConnectivityManager.NetworkCallback#onCapabilitiesChanged(android.net.Network,android.net.NetworkCapabilities) NetworkCallback#onCapabilitiesChanged(Network, NetworkCapabilities)}
 * or {@link android.net.ConnectivityManager#getNetworkCapabilities(android.net.Network) ConnectivityManager#getNetworkCapabilities(Network)}.
 * <p>
 * This replaces the old {@link android.net.ConnectivityManager#TYPE_MOBILE ConnectivityManager#TYPE_MOBILE} method of
 * network selection. Rather than indicate a need for Wi-Fi because an
 * application needs high bandwidth and risk obsolescence when a new, fast
 * network appears (like LTE), the application should specify it needs high
 * bandwidth. Similarly if an application needs an unmetered network for a bulk
 * transfer it can specify that rather than assuming all cellular based
 * connections are metered and all Wi-Fi based connections are not.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class NetworkCapabilities implements android.os.Parcelable {

/** @apiSince R */

public NetworkCapabilities() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public NetworkCapabilities(android.net.NetworkCapabilities nc) { throw new RuntimeException("Stub!"); }

/**
 * Completely clears the contents of this object, removing even the capabilities that are set
 * by default when the object is constructed.
 * @apiSince R
 */

public void clearAll() { throw new RuntimeException("Stub!"); }

/**
 * Adds the given capability to this {@code NetworkCapability} instance.
 * Multiple capabilities may be applied sequentially.  Note that when searching
 * for a network to satisfy a request, all capabilities requested must be satisfied.
 *
 * @param capability the capability to be added.
 * Value is {@link android.net.NetworkCapabilities#NET_CAPABILITY_MMS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_SUPL}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_DUN}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_FOTA}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_IMS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_CBS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_WIFI_P2P}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_IA}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_RCS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_XCAP}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_EIMS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_METERED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_INTERNET}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_RESTRICTED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_TRUSTED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_VPN}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_VALIDATED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_CAPTIVE_PORTAL}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_ROAMING}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_FOREGROUND}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_CONGESTED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_SUSPENDED}, android.net.NetworkCapabilities.NET_CAPABILITY_OEM_PAID, {@link android.net.NetworkCapabilities#NET_CAPABILITY_MCX}, or android.net.NetworkCapabilities.NET_CAPABILITY_PARTIAL_CONNECTIVITY
 * @return This NetworkCapabilities instance, to facilitate chaining.
 
 * This value will never be {@code null}.
 * @apiSince R
 */

@androidx.annotation.NonNull
public android.net.NetworkCapabilities addCapability(int capability) { throw new RuntimeException("Stub!"); }

/**
 * Removes (if found) the given capability from this {@code NetworkCapability} instance.
 *
 * @param capability the capability to be removed.
 * Value is {@link android.net.NetworkCapabilities#NET_CAPABILITY_MMS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_SUPL}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_DUN}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_FOTA}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_IMS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_CBS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_WIFI_P2P}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_IA}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_RCS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_XCAP}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_EIMS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_METERED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_INTERNET}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_RESTRICTED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_TRUSTED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_VPN}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_VALIDATED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_CAPTIVE_PORTAL}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_ROAMING}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_FOREGROUND}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_CONGESTED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_SUSPENDED}, android.net.NetworkCapabilities.NET_CAPABILITY_OEM_PAID, {@link android.net.NetworkCapabilities#NET_CAPABILITY_MCX}, or android.net.NetworkCapabilities.NET_CAPABILITY_PARTIAL_CONNECTIVITY
 * @return This NetworkCapabilities instance, to facilitate chaining.
 
 * This value will never be {@code null}.
 * @apiSince R
 */

@androidx.annotation.NonNull
public android.net.NetworkCapabilities removeCapability(int capability) { throw new RuntimeException("Stub!"); }

/**
 * Sets (or clears) the given capability on this {@link android.net.NetworkCapabilities NetworkCapabilities}
 * instance.
 *
 
 * @param capability Value is {@link android.net.NetworkCapabilities#NET_CAPABILITY_MMS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_SUPL}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_DUN}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_FOTA}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_IMS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_CBS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_WIFI_P2P}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_IA}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_RCS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_XCAP}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_EIMS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_METERED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_INTERNET}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_RESTRICTED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_TRUSTED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_VPN}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_VALIDATED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_CAPTIVE_PORTAL}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_ROAMING}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_FOREGROUND}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_CONGESTED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_SUSPENDED}, android.net.NetworkCapabilities.NET_CAPABILITY_OEM_PAID, {@link android.net.NetworkCapabilities#NET_CAPABILITY_MCX}, or android.net.NetworkCapabilities.NET_CAPABILITY_PARTIAL_CONNECTIVITY
 * @return This value will never be {@code null}.
 * @apiSince R
 */

@androidx.annotation.NonNull
public android.net.NetworkCapabilities setCapability(int capability, boolean value) { throw new RuntimeException("Stub!"); }

/**
 * Tests for the presence of a capability on this instance.
 *
 * @param capability the capabilities to be tested for.
 * Value is {@link android.net.NetworkCapabilities#NET_CAPABILITY_MMS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_SUPL}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_DUN}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_FOTA}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_IMS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_CBS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_WIFI_P2P}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_IA}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_RCS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_XCAP}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_EIMS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_METERED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_INTERNET}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_RESTRICTED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_TRUSTED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_VPN}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_VALIDATED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_CAPTIVE_PORTAL}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_ROAMING}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_FOREGROUND}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_CONGESTED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_SUSPENDED}, android.net.NetworkCapabilities.NET_CAPABILITY_OEM_PAID, {@link android.net.NetworkCapabilities#NET_CAPABILITY_MCX}, or android.net.NetworkCapabilities.NET_CAPABILITY_PARTIAL_CONNECTIVITY
 * @return {@code true} if set on this instance.
 * @apiSince 21
 */

public boolean hasCapability(int capability) { throw new RuntimeException("Stub!"); }

/**
 * Adds the given transport type to this {@code NetworkCapability} instance.
 * Multiple transports may be applied sequentially.  Note that when searching
 * for a network to satisfy a request, any listed in the request will satisfy the request.
 * For example {@code TRANSPORT_WIFI} and {@code TRANSPORT_ETHERNET} added to a
 * {@code NetworkCapabilities} would cause either a Wi-Fi network or an Ethernet network
 * to be selected.  This is logically different than
 * {@code NetworkCapabilities.NET_CAPABILITY_*} listed above.
 *
 * @param transportType the transport type to be added.
 * Value is {@link android.net.NetworkCapabilities#TRANSPORT_CELLULAR}, {@link android.net.NetworkCapabilities#TRANSPORT_WIFI}, {@link android.net.NetworkCapabilities#TRANSPORT_BLUETOOTH}, {@link android.net.NetworkCapabilities#TRANSPORT_ETHERNET}, {@link android.net.NetworkCapabilities#TRANSPORT_VPN}, {@link android.net.NetworkCapabilities#TRANSPORT_WIFI_AWARE}, {@link android.net.NetworkCapabilities#TRANSPORT_LOWPAN}, or android.net.NetworkCapabilities.TRANSPORT_TEST
 * @return This NetworkCapabilities instance, to facilitate chaining.
 
 * This value will never be {@code null}.
 * @apiSince R
 */

@androidx.annotation.NonNull
public android.net.NetworkCapabilities addTransportType(int transportType) { throw new RuntimeException("Stub!"); }

/**
 * Tests for the presence of a transport on this instance.
 *
 * @param transportType the transport type to be tested for.
 * Value is {@link android.net.NetworkCapabilities#TRANSPORT_CELLULAR}, {@link android.net.NetworkCapabilities#TRANSPORT_WIFI}, {@link android.net.NetworkCapabilities#TRANSPORT_BLUETOOTH}, {@link android.net.NetworkCapabilities#TRANSPORT_ETHERNET}, {@link android.net.NetworkCapabilities#TRANSPORT_VPN}, {@link android.net.NetworkCapabilities#TRANSPORT_WIFI_AWARE}, {@link android.net.NetworkCapabilities#TRANSPORT_LOWPAN}, or android.net.NetworkCapabilities.TRANSPORT_TEST
 * @return {@code true} if set on this instance.
 * @apiSince 21
 */

public boolean hasTransport(int transportType) { throw new RuntimeException("Stub!"); }

/**
 * Sets the upstream bandwidth for this network in Kbps.  This always only refers to
 * the estimated first hop transport bandwidth.
 * <p>
 * Note that when used to request a network, this specifies the minimum acceptable.
 * When received as the state of an existing network this specifies the typical
 * first hop bandwidth expected.  This is never measured, but rather is inferred
 * from technology type and other link parameters.  It could be used to differentiate
 * between very slow 1xRTT cellular links and other faster networks or even between
 * 802.11b vs 802.11AC wifi technologies.  It should not be used to differentiate between
 * fast backhauls and slow backhauls.
 *
 * @param upKbps the estimated first hop upstream (device to network) bandwidth.
 
 * @return This value will never be {@code null}.
 * @apiSince R
 */

@androidx.annotation.NonNull
public android.net.NetworkCapabilities setLinkUpstreamBandwidthKbps(int upKbps) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the upstream bandwidth for this network in Kbps.  This always only refers to
 * the estimated first hop transport bandwidth.
 *
 * @return The estimated first hop upstream (device to network) bandwidth.
 * @apiSince 21
 */

public int getLinkUpstreamBandwidthKbps() { throw new RuntimeException("Stub!"); }

/**
 * Sets the downstream bandwidth for this network in Kbps.  This always only refers to
 * the estimated first hop transport bandwidth.
 * <p>
 * Note that when used to request a network, this specifies the minimum acceptable.
 * When received as the state of an existing network this specifies the typical
 * first hop bandwidth expected.  This is never measured, but rather is inferred
 * from technology type and other link parameters.  It could be used to differentiate
 * between very slow 1xRTT cellular links and other faster networks or even between
 * 802.11b vs 802.11AC wifi technologies.  It should not be used to differentiate between
 * fast backhauls and slow backhauls.
 *
 * @param downKbps the estimated first hop downstream (network to device) bandwidth.
 
 * @return This value will never be {@code null}.
 * @apiSince R
 */

@androidx.annotation.NonNull
public android.net.NetworkCapabilities setLinkDownstreamBandwidthKbps(int downKbps) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the downstream bandwidth for this network in Kbps.  This always only refers to
 * the estimated first hop transport bandwidth.
 *
 * @return The estimated first hop downstream (network to device) bandwidth.
 * @apiSince 21
 */

public int getLinkDownstreamBandwidthKbps() { throw new RuntimeException("Stub!"); }

/**
 * Sets the optional bearer specific network specifier.
 * This has no meaning if a single transport is also not specified, so calling
 * this without a single transport set will generate an exception, as will
 * subsequently adding or removing transports after this is set.
 * </p>
 *
 * @param networkSpecifier A concrete, parcelable framework class that extends
 *                         NetworkSpecifier.
 * This value must never be {@code null}.
 * @return This NetworkCapabilities instance, to facilitate chaining.
 
 * This value will never be {@code null}.
 * @apiSince R
 */

@androidx.annotation.NonNull
public android.net.NetworkCapabilities setNetworkSpecifier(@androidx.annotation.NonNull android.net.NetworkSpecifier networkSpecifier) { throw new RuntimeException("Stub!"); }

/**
 * Gets the optional bearer specific network specifier. May be {@code null} if not set.
 *
 * @return The optional {@link android.net.NetworkSpecifier NetworkSpecifier} specifying the bearer specific network
 *         specifier or {@code null}. See {@link #setNetworkSpecifier}.
 * @apiSince R
 */

@androidx.annotation.Nullable
public android.net.NetworkSpecifier getNetworkSpecifier() { throw new RuntimeException("Stub!"); }

/**
 * Returns a transport-specific information container. The application may cast this
 * container to a concrete sub-class based on its knowledge of the network request. The
 * application should be able to deal with a {@code null} return value or an invalid case,
 * e.g. use {@code instanceof} operator to verify expected type.
 *
 * @return A concrete implementation of the {@link android.net.TransportInfo TransportInfo} class or null if not
 * available for the network.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.net.TransportInfo getTransportInfo() { throw new RuntimeException("Stub!"); }

/**
 * Sets the signal strength. This is a signed integer, with higher values indicating a stronger
 * signal. The exact units are bearer-dependent. For example, Wi-Fi uses the same RSSI units
 * reported by wifi code.
 * <p>
 * Note that when used to register a network callback, this specifies the minimum acceptable
 * signal strength. When received as the state of an existing network it specifies the current
 * value. A value of code SIGNAL_STRENGTH_UNSPECIFIED} means no value when received and has no
 * effect when requesting a callback.
 *
 * @param signalStrength the bearer-specific signal strength.
 
 * @return This value will never be {@code null}.
 * @apiSince R
 */

@androidx.annotation.NonNull
public android.net.NetworkCapabilities setSignalStrength(int signalStrength) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the signal strength.
 *
 * @return The bearer-specific signal strength.
 * @apiSince 29
 */

public int getSignalStrength() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param obj This value may be {@code null}.
 * @apiSince 21
 */

public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.net.NetworkCapabilities> CREATOR;
static { CREATOR = null; }

/**
 * Indicates that this network was found to have a captive portal in place last time it was
 * probed.
 * @apiSince 23
 */

public static final int NET_CAPABILITY_CAPTIVE_PORTAL = 17; // 0x11

/**
 * Indicates this is a network that has the ability to reach the carrier's
 * CBS servers, used for carrier specific services.
 * @apiSince 21
 */

public static final int NET_CAPABILITY_CBS = 5; // 0x5

/**
 * Indicates this is a network that has the ability to reach the carrier's
 * DUN or tethering gateway.
 * @apiSince 21
 */

public static final int NET_CAPABILITY_DUN = 2; // 0x2

/**
 * Indicates this is a network that has the ability to reach a carrier's
 * Emergency IMS servers or other services, used for network signaling
 * during emergency calls.
 * @apiSince 21
 */

public static final int NET_CAPABILITY_EIMS = 10; // 0xa

/**
 * Indicates that this network is available for use by apps, and not a network that is being
 * kept up in the background to facilitate fast network switching.
 * @apiSince 28
 */

public static final int NET_CAPABILITY_FOREGROUND = 19; // 0x13

/**
 * Indicates this is a network that has the ability to reach the carrier's
 * FOTA portal, used for over the air updates.
 * @apiSince 21
 */

public static final int NET_CAPABILITY_FOTA = 3; // 0x3

/**
 * Indicates this is a network that has the ability to reach a carrier's
 * Initial Attach servers.
 * @apiSince 21
 */

public static final int NET_CAPABILITY_IA = 7; // 0x7

/**
 * Indicates this is a network that has the ability to reach the carrier's
 * IMS servers, used for network registration and signaling.
 * @apiSince 21
 */

public static final int NET_CAPABILITY_IMS = 4; // 0x4

/**
 * Indicates that this network should be able to reach the internet.
 * @apiSince 21
 */

public static final int NET_CAPABILITY_INTERNET = 12; // 0xc

/**
 * Indicates this is a network that has the ability to reach a carrier's Mission Critical
 * servers.
 * @apiSince 29
 */

public static final int NET_CAPABILITY_MCX = 23; // 0x17

/**
 * Indicates this is a network that has the ability to reach the
 * carrier's MMSC for sending and receiving MMS messages.
 * @apiSince 21
 */

public static final int NET_CAPABILITY_MMS = 0; // 0x0

/**
 * Indicates that this network is not congested.
 * <p>
 * When a network is congested, applications should defer network traffic
 * that can be done at a later time, such as uploading analytics.
 * @apiSince 28
 */

public static final int NET_CAPABILITY_NOT_CONGESTED = 20; // 0x14

/**
 * Indicates that this network is unmetered.
 * @apiSince 21
 */

public static final int NET_CAPABILITY_NOT_METERED = 11; // 0xb

/**
 * Indicates that this network is available for general use.  If this is not set
 * applications should not attempt to communicate on this network.  Note that this
 * is simply informative and not enforcement - enforcement is handled via other means.
 * Set by default.
 * @apiSince 21
 */

public static final int NET_CAPABILITY_NOT_RESTRICTED = 13; // 0xd

/**
 * Indicates that this network is not roaming.
 * @apiSince 28
 */

public static final int NET_CAPABILITY_NOT_ROAMING = 18; // 0x12

/**
 * Indicates that this network is not currently suspended.
 * <p>
 * When a network is suspended, the network's IP addresses and any connections
 * established on the network remain valid, but the network is temporarily unable
 * to transfer data. This can happen, for example, if a cellular network experiences
 * a temporary loss of signal, such as when driving through a tunnel, etc.
 * A network with this capability is not suspended, so is expected to be able to
 * transfer data.
 * @apiSince 28
 */

public static final int NET_CAPABILITY_NOT_SUSPENDED = 21; // 0x15

/**
 * Indicates that this network is not a VPN.  This capability is set by default and should be
 * explicitly cleared for VPN networks.
 * @apiSince 21
 */

public static final int NET_CAPABILITY_NOT_VPN = 15; // 0xf

/**
 * Indicates this is a network that has the ability to reach a carrier's
 * RCS servers, used for Rich Communication Services.
 * @apiSince 21
 */

public static final int NET_CAPABILITY_RCS = 8; // 0x8

/**
 * Indicates this is a network that has the ability to reach the carrier's
 * SUPL server, used to retrieve GPS information.
 * @apiSince 21
 */

public static final int NET_CAPABILITY_SUPL = 1; // 0x1

/**
 * Indicates that the user has indicated implicit trust of this network.  This
 * generally means it's a sim-selected carrier, a plugged in ethernet, a paired
 * BT device or a wifi the user asked to connect to.  Untrusted networks
 * are probably limited to unknown wifi AP.  Set by default.
 * @apiSince 21
 */

public static final int NET_CAPABILITY_TRUSTED = 14; // 0xe

/**
 * Indicates that connectivity on this network was successfully validated. For example, for a
 * network with NET_CAPABILITY_INTERNET, it means that Internet connectivity was successfully
 * detected.
 * @apiSince 23
 */

public static final int NET_CAPABILITY_VALIDATED = 16; // 0x10

/**
 * Indicates this is a network that has the ability to reach a Wi-Fi direct
 * peer.
 * @apiSince 21
 */

public static final int NET_CAPABILITY_WIFI_P2P = 6; // 0x6

/**
 * Indicates this is a network that has the ability to reach a carrier's
 * XCAP servers, used for configuration and control.
 * @apiSince 21
 */

public static final int NET_CAPABILITY_XCAP = 9; // 0x9

/**
 * Magic value that indicates no signal strength provided. A request specifying this value is
 * always satisfied.
 * @apiSince 29
 */

public static final int SIGNAL_STRENGTH_UNSPECIFIED = -2147483648; // 0x80000000

/**
 * Indicates this network uses a Bluetooth transport.
 * @apiSince 21
 */

public static final int TRANSPORT_BLUETOOTH = 2; // 0x2

/**
 * Indicates this network uses a Cellular transport.
 * @apiSince 21
 */

public static final int TRANSPORT_CELLULAR = 0; // 0x0

/**
 * Indicates this network uses an Ethernet transport.
 * @apiSince 21
 */

public static final int TRANSPORT_ETHERNET = 3; // 0x3

/**
 * Indicates this network uses a LoWPAN transport.
 * @apiSince 27
 */

public static final int TRANSPORT_LOWPAN = 6; // 0x6

/**
 * Indicates this network uses a VPN transport.
 * @apiSince 21
 */

public static final int TRANSPORT_VPN = 4; // 0x4

/**
 * Indicates this network uses a Wi-Fi transport.
 * @apiSince 21
 */

public static final int TRANSPORT_WIFI = 1; // 0x1

/**
 * Indicates this network uses a Wi-Fi Aware transport.
 * @apiSince 26
 */

public static final int TRANSPORT_WIFI_AWARE = 5; // 0x5
}

