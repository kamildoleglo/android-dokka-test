/*
 * Copyright (C) 2008 The Android Open Source Project
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


/**
 * Describes the status of a network interface.
 * <p>Use {@link android.net.ConnectivityManager#getActiveNetworkInfo() ConnectivityManager#getActiveNetworkInfo()} to get an instance that represents
 * the current network connection.
 *
 * @deprecated Callers should instead use the {@link android.net.ConnectivityManager.NetworkCallback ConnectivityManager.NetworkCallback} API to
 *             learn about connectivity changes, or switch to use
 *             {@link android.net.ConnectivityManager#getNetworkCapabilities ConnectivityManager#getNetworkCapabilities} or
 *             {@link android.net.ConnectivityManager#getLinkProperties ConnectivityManager#getLinkProperties} to get information synchronously. Keep
 *             in mind that while callbacks are guaranteed to be called for every event in order,
 *             synchronous calls have no such constraints, and as such it is unadvisable to use the
 *             synchronous methods inside the callbacks as they will often not offer a view of
 *             networking that is consistent (that is: they may return a past or a future state with
 *             respect to the event being processed by the callback). Instead, callers are advised
 *             to only use the arguments of the callbacks, possibly memorizing the specific bits of
 *             information they need to keep from one callback to another.
 * @apiSince 1
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class NetworkInfo implements android.os.Parcelable {

NetworkInfo() { throw new RuntimeException("Stub!"); }

/**
 * Reports the type of network to which the
 * info in this {@code NetworkInfo} pertains.
 * @return one of {@link android.net.ConnectivityManager#TYPE_MOBILE ConnectivityManager#TYPE_MOBILE}, {@link android.net.ConnectivityManager#TYPE_WIFI ConnectivityManager#TYPE_WIFI}, {@link android.net.ConnectivityManager#TYPE_WIMAX ConnectivityManager#TYPE_WIMAX}, {@link android.net.ConnectivityManager#TYPE_ETHERNET ConnectivityManager#TYPE_ETHERNET},  {@link android.net.ConnectivityManager#TYPE_BLUETOOTH ConnectivityManager#TYPE_BLUETOOTH}, or other
 * types defined by {@link android.net.ConnectivityManager ConnectivityManager}.
 * @deprecated Callers should switch to checking {@link android.net.NetworkCapabilities#hasTransport NetworkCapabilities#hasTransport}
 *             instead with one of the NetworkCapabilities#TRANSPORT_* constants :
 *             {@link #getType} and {@link #getTypeName} cannot account for networks using
 *             multiple transports. Note that generally apps should not care about transport;
 *             {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_METERED NetworkCapabilities#NET_CAPABILITY_NOT_METERED} and
 *             {@link android.net.NetworkCapabilities#getLinkDownstreamBandwidthKbps NetworkCapabilities#getLinkDownstreamBandwidthKbps} are calls that
 *             apps concerned with meteredness or bandwidth should be looking at, as they
 *             offer this information with much better accuracy.
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated
public int getType() { throw new RuntimeException("Stub!"); }

/**
 * Return a network-type-specific integer describing the subtype
 * of the network.
 * @return the network subtype
 * @deprecated Use {@link android.telephony.TelephonyManager#getDataNetworkType} instead.
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated
public int getSubtype() { throw new RuntimeException("Stub!"); }

/**
 * Return a human-readable name describe the type of the network,
 * for example "WIFI" or "MOBILE".
 * @return the name of the network type
 * @deprecated Callers should switch to checking {@link android.net.NetworkCapabilities#hasTransport NetworkCapabilities#hasTransport}
 *             instead with one of the NetworkCapabilities#TRANSPORT_* constants :
 *             {@link #getType} and {@link #getTypeName} cannot account for networks using
 *             multiple transports. Note that generally apps should not care about transport;
 *             {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_METERED NetworkCapabilities#NET_CAPABILITY_NOT_METERED} and
 *             {@link android.net.NetworkCapabilities#getLinkDownstreamBandwidthKbps NetworkCapabilities#getLinkDownstreamBandwidthKbps} are calls that
 *             apps concerned with meteredness or bandwidth should be looking at, as they
 *             offer this information with much better accuracy.
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated
public java.lang.String getTypeName() { throw new RuntimeException("Stub!"); }

/**
 * Return a human-readable name describing the subtype of the network.
 * @return the name of the network subtype
 * @deprecated Use {@link android.telephony.TelephonyManager#getDataNetworkType} instead.
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated
public java.lang.String getSubtypeName() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether network connectivity exists or is in the process
 * of being established. This is good for applications that need to
 * do anything related to the network other than read or write data.
 * For the latter, call {@link #isConnected()} instead, which guarantees
 * that the network is fully usable.
 * @return {@code true} if network connectivity exists or is in the process
 * of being established, {@code false} otherwise.
 * @deprecated Apps should instead use the
 *             {@link android.net.ConnectivityManager.NetworkCallback} API to
 *             learn about connectivity changes.
 *             {@link android.net.ConnectivityManager#registerDefaultNetworkCallback ConnectivityManager#registerDefaultNetworkCallback} and
 *             {@link android.net.ConnectivityManager#registerNetworkCallback ConnectivityManager#registerNetworkCallback}. These will
 *             give a more accurate picture of the connectivity state of
 *             the device and let apps react more easily and quickly to changes.
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated
public boolean isConnectedOrConnecting() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether network connectivity exists and it is possible to establish
 * connections and pass data.
 * <p>Always call this before attempting to perform data transactions.
 * @return {@code true} if network connectivity exists, {@code false} otherwise.
 * @deprecated Apps should instead use the
 *             {@link android.net.ConnectivityManager.NetworkCallback} API to
 *             learn about connectivity changes. See
 *             {@link android.net.ConnectivityManager#registerDefaultNetworkCallback ConnectivityManager#registerDefaultNetworkCallback} and
 *             {@link android.net.ConnectivityManager#registerNetworkCallback ConnectivityManager#registerNetworkCallback}. These will
 *             give a more accurate picture of the connectivity state of
 *             the device and let apps react more easily and quickly to changes.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public boolean isConnected() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether network connectivity is possible. A network is unavailable
 * when a persistent or semi-persistent condition prevents the possibility
 * of connecting to that network. Examples include
 * <ul>
 * <li>The device is out of the coverage area for any network of this type.</li>
 * <li>The device is on a network other than the home network (i.e., roaming), and
 * data roaming has been disabled.</li>
 * <li>The device's radio is turned off, e.g., because airplane mode is enabled.</li>
 * </ul>
 * Since Android L, this always returns {@code true}, because the system only
 * returns info for available networks.
 * @return {@code true} if the network is available, {@code false} otherwise
 * @deprecated Apps should instead use the
 *             {@link android.net.ConnectivityManager.NetworkCallback} API to
 *             learn about connectivity changes.
 *             {@link android.net.ConnectivityManager#registerDefaultNetworkCallback ConnectivityManager#registerDefaultNetworkCallback} and
 *             {@link android.net.ConnectivityManager#registerNetworkCallback ConnectivityManager#registerNetworkCallback}. These will
 *             give a more accurate picture of the connectivity state of
 *             the device and let apps react more easily and quickly to changes.
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated
public boolean isAvailable() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the current attempt to connect to the network
 * resulted from the ConnectivityManager trying to fail over to this
 * network following a disconnect from another network.
 * @return {@code true} if this is a failover attempt, {@code false}
 * otherwise.
 * @deprecated This field is not populated in recent Android releases,
 *             and does not make a lot of sense in a multi-network world.
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated
public boolean isFailover() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the device is currently roaming on this network. When
 * {@code true}, it suggests that use of data on this network may incur
 * extra costs.
 *
 * @return {@code true} if roaming is in effect, {@code false} otherwise.
 * @deprecated Callers should switch to checking
 *             {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_ROAMING NetworkCapabilities#NET_CAPABILITY_NOT_ROAMING}
 *             instead, since that handles more complex situations, such as
 *             VPNs.
 * @apiSince 3
 * @deprecatedSince 28
 */

@Deprecated
public boolean isRoaming() { throw new RuntimeException("Stub!"); }

/**
 * Reports the current coarse-grained state of the network.
 * @return the coarse-grained state
 * @deprecated Apps should instead use the
 *             {@link android.net.ConnectivityManager.NetworkCallback} API to
 *             learn about connectivity changes.
 *             {@link android.net.ConnectivityManager#registerDefaultNetworkCallback ConnectivityManager#registerDefaultNetworkCallback} and
 *             {@link android.net.ConnectivityManager#registerNetworkCallback ConnectivityManager#registerNetworkCallback}. These will
 *             give a more accurate picture of the connectivity state of
 *             the device and let apps react more easily and quickly to changes.
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated
public android.net.NetworkInfo.State getState() { throw new RuntimeException("Stub!"); }

/**
 * Reports the current fine-grained state of the network.
 * @return the fine-grained state
 * This value will never be {@code null}.
 * @deprecated Apps should instead use the
 *             {@link android.net.ConnectivityManager.NetworkCallback} API to
 *             learn about connectivity changes. See
 *             {@link android.net.ConnectivityManager#registerDefaultNetworkCallback ConnectivityManager#registerDefaultNetworkCallback} and
 *             {@link android.net.ConnectivityManager#registerNetworkCallback ConnectivityManager#registerNetworkCallback}. These will
 *             give a more accurate picture of the connectivity state of
 *             the device and let apps react more easily and quickly to changes.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
@androidx.annotation.NonNull
public android.net.NetworkInfo.DetailedState getDetailedState() { throw new RuntimeException("Stub!"); }

/**
 * Report the reason an attempt to establish connectivity failed,
 * if one is available.
 * @return the reason for failure, or null if not available
 * @deprecated This method does not have a consistent contract that could make it useful
 *             to callers.
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated
public java.lang.String getReason() { throw new RuntimeException("Stub!"); }

/**
 * Report the extra information about the network state, if any was
 * provided by the lower networking layers.
 * @return the extra information, or null if not available
 * @deprecated Use other services e.g. WifiManager to get additional information passed up from
 *             the lower networking layers.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public java.lang.String getExtraInfo() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 24
 * @deprecatedSince 29
 */

@Deprecated @androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.net.NetworkInfo> CREATOR;
static { CREATOR = null; }
/**
 * The fine-grained state of a network connection. This level of detail
 * is probably of interest to few applications. Most should use
 * {@link android.net.NetworkInfo.State State} instead.
 *
 * @deprecated See {@link android.net.NetworkInfo NetworkInfo}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public enum DetailedState {
/**
 * Ready to start data connection setup.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
IDLE,
/**
 * Searching for an available access point.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
SCANNING,
/**
 * Currently setting up data connection.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
CONNECTING,
/**
 * Network link established, performing authentication.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
AUTHENTICATING,
/**
 * Awaiting response from DHCP server in order to assign IP address information.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
OBTAINING_IPADDR,
/**
 * IP traffic should be available.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
CONNECTED,
/**
 * IP traffic is suspended
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
SUSPENDED,
/**
 * Currently tearing down data connection.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
DISCONNECTING,
/**
 * IP traffic not available.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
DISCONNECTED,
/**
 * Attempt to connect failed.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
FAILED,
/**
 * Access to this network is blocked.
 * @apiSince 14
 * @deprecatedSince 29
 */

@Deprecated
BLOCKED,
/**
 * Link has poor connectivity.
 * @apiSince 16
 * @deprecatedSince 29
 */

@Deprecated
VERIFYING_POOR_LINK,
/**
 * Checking if network is a captive portal
 * @apiSince 17
 * @deprecatedSince 29
 */

@Deprecated
CAPTIVE_PORTAL_CHECK;
}

/**
 * Coarse-grained network state. This is probably what most applications should
 * use, rather than {@link android.net.NetworkInfo.DetailedState DetailedState}.
 * The mapping between the two is as follows:
 * <br/><br/>
 * <table>
 * <tr><td><b>Detailed state</b></td><td><b>Coarse-grained state</b></td></tr>
 * <tr><td><code>IDLE</code></td><td><code>DISCONNECTED</code></td></tr>
 * <tr><td><code>SCANNING</code></td><td><code>DISCONNECTED</code></td></tr>
 * <tr><td><code>CONNECTING</code></td><td><code>CONNECTING</code></td></tr>
 * <tr><td><code>AUTHENTICATING</code></td><td><code>CONNECTING</code></td></tr>
 * <tr><td><code>OBTAINING_IPADDR</code></td><td><code>CONNECTING</code></td></tr>
 * <tr><td><code>VERIFYING_POOR_LINK</code></td><td><code>CONNECTING</code></td></tr>
 * <tr><td><code>CAPTIVE_PORTAL_CHECK</code></td><td><code>CONNECTING</code></td></tr>
 * <tr><td><code>CONNECTED</code></td><td><code>CONNECTED</code></td></tr>
 * <tr><td><code>SUSPENDED</code></td><td><code>SUSPENDED</code></td></tr>
 * <tr><td><code>DISCONNECTING</code></td><td><code>DISCONNECTING</code></td></tr>
 * <tr><td><code>DISCONNECTED</code></td><td><code>DISCONNECTED</code></td></tr>
 * <tr><td><code>FAILED</code></td><td><code>DISCONNECTED</code></td></tr>
 * <tr><td><code>BLOCKED</code></td><td><code>DISCONNECTED</code></td></tr>
 * </table>
 *
 * @deprecated See {@link android.net.NetworkInfo NetworkInfo}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public enum State {
/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
CONNECTING,
/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
CONNECTED,
/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
SUSPENDED,
/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
DISCONNECTING,
/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
DISCONNECTED,
/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
UNKNOWN;
}

}

