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

import android.net.IpSecManager.UdpEncapsulationSocket;
import java.util.concurrent.Executor;
import android.content.Context;
import android.net.SocketKeepalive.Callback;
import android.os.Build.VERSION_CODES;
import android.provider.Settings;
import android.os.Handler;
import android.content.Intent;
import android.app.PendingIntent;
import java.net.InetSocketAddress;
import android.os.Process;
import android.os.Build;

/**
 * Class that answers queries about the state of network connectivity. It also
 * notifies applications when network connectivity changes.
 * <p>
 * The primary responsibilities of this class are to:
 * <ol>
 * <li>Monitor network connections (Wi-Fi, GPRS, UMTS, etc.)</li>
 * <li>Send broadcast intents when network connectivity changes</li>
 * <li>Attempt to "fail over" to another network when connectivity to a network
 * is lost</li>
 * <li>Provide an API that allows applications to query the coarse-grained or fine-grained
 * state of the available networks</li>
 * <li>Provide an API that allows applications to request and select networks for their data
 * traffic</li>
 * </ol>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ConnectivityManager {

ConnectivityManager() { throw new RuntimeException("Stub!"); }

/**
 * Tests if a given integer represents a valid network type.
 * @param networkType the type to be tested
 * @return a boolean.  {@code true} if the type is valid, else {@code false}
 * @deprecated All APIs accepting a network type are deprecated. There should be no need to
 *             validate a network type.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public static boolean isNetworkTypeValid(int networkType) { throw new RuntimeException("Stub!"); }

/**
 * Specifies the preferred network type.  When the device has more
 * than one type available the preferred network type will be used.
 *
 * @param preference the network type to prefer over all others.  It is
 *         unspecified what happens to the old preferred network in the
 *         overall ordering.
 * @deprecated Functionality has been removed as it no longer makes sense,
 *             with many more than two networks - we'd need an array to express
 *             preference.  Instead we use dynamic network properties of
 *             the networks to describe their precedence.
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public void setNetworkPreference(int preference) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the current preferred network type.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
 * @return an integer representing the preferred network type
 *
 * @deprecated Functionality has been removed as it no longer makes sense,
 *             with many more than two networks - we'd need an array to express
 *             preference.  Instead we use dynamic network properties of
 *             the networks to describe their precedence.
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public int getNetworkPreference() { throw new RuntimeException("Stub!"); }

/**
 * Returns details about the currently active default data network. When
 * connected, this network is the default route for outgoing connections.
 * You should always check {@link android.net.NetworkInfo#isConnected() NetworkInfo#isConnected()} before initiating
 * network traffic. This may return {@code null} when there is no default
 * network.
 * Note that if the default network is a VPN, this method will return the
 * NetworkInfo for one of its underlying networks instead, or null if the
 * VPN agent did not specify any. Apps interested in learning about VPNs
 * should use {@link #getNetworkInfo(android.net.Network)} instead.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
 * @return a {@link android.net.NetworkInfo NetworkInfo} object for the current default network
 *        or {@code null} if no default network is currently active
 * @deprecated See {@link android.net.NetworkInfo NetworkInfo}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
@androidx.annotation.Nullable
public android.net.NetworkInfo getActiveNetworkInfo() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link android.net.Network Network} object corresponding to the currently active
 * default data network.  In the event that the current active default data
 * network disconnects, the returned {@code Network} object will no longer
 * be usable.  This will return {@code null} when there is no default
 * network.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
 * @return a {@link android.net.Network Network} object for the current default network or
 *        {@code null} if no default network is currently active
 * @apiSince 23
 */

@androidx.annotation.Nullable
public android.net.Network getActiveNetwork() { throw new RuntimeException("Stub!"); }

/**
 * Returns connection status information about a particular
 * network type.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
 * @param networkType integer specifying which networkType in
 *        which you're interested.
 * @return a {@link android.net.NetworkInfo NetworkInfo} object for the requested
 *        network type or {@code null} if the type is not
 *        supported by the device. If {@code networkType} is
 *        TYPE_VPN and a VPN is active for the calling app,
 *        then this method will try to return one of the
 *        underlying networks for the VPN or null if the
 *        VPN agent didn't specify any.
 *
 * @deprecated This method does not support multiple connected networks
 *             of the same type. Use {@link #getAllNetworks} and
 *             {@link #getNetworkInfo(android.net.Network)} instead.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
@androidx.annotation.Nullable
public android.net.NetworkInfo getNetworkInfo(int networkType) { throw new RuntimeException("Stub!"); }

/**
 * Returns connection status information about a particular
 * Network.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
 * @param network {@link android.net.Network Network} specifying which network
 *        in which you're interested.
 * This value may be {@code null}.
 * @return a {@link android.net.NetworkInfo NetworkInfo} object for the requested
 *        network or {@code null} if the {@code Network}
 *        is not valid.
 * @deprecated See {@link android.net.NetworkInfo NetworkInfo}.
 * @apiSince 21
 * @deprecatedSince 29
 */

@Deprecated
@androidx.annotation.Nullable
public android.net.NetworkInfo getNetworkInfo(@androidx.annotation.Nullable android.net.Network network) { throw new RuntimeException("Stub!"); }

/**
 * Returns connection status information about all network
 * types supported by the device.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
 * @return an array of {@link android.net.NetworkInfo NetworkInfo} objects.  Check each
 * {@link android.net.NetworkInfo#getType NetworkInfo#getType} for which type each applies.
 *
 * This value will never be {@code null}.
 * @deprecated This method does not support multiple connected networks
 *             of the same type. Use {@link #getAllNetworks} and
 *             {@link #getNetworkInfo(android.net.Network)} instead.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
@androidx.annotation.NonNull
public android.net.NetworkInfo[] getAllNetworkInfo() { throw new RuntimeException("Stub!"); }

/**
 * Returns an array of all {@link android.net.Network Network} currently tracked by the
 * framework.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
 * @return an array of {@link android.net.Network Network} objects.
 
 * This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public android.net.Network[] getAllNetworks() { throw new RuntimeException("Stub!"); }

/**
 * Get the {@link android.net.LinkProperties LinkProperties} for the given {@link android.net.Network Network}.  This
 * will return {@code null} if the network is unknown.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
 * @param network The {@link android.net.Network Network} object identifying the network in question.
 * This value may be {@code null}.
 * @return The {@link android.net.LinkProperties LinkProperties} for the network, or {@code null}.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public android.net.LinkProperties getLinkProperties(@androidx.annotation.Nullable android.net.Network network) { throw new RuntimeException("Stub!"); }

/**
 * Get the {@link android.net.NetworkCapabilities} for the given {@link android.net.Network Network}.  This
 * will return {@code null} if the network is unknown.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
 * @param network The {@link android.net.Network Network} object identifying the network in question.
 * This value may be {@code null}.
 * @return The {@link android.net.NetworkCapabilities} for the network, or {@code null}.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public android.net.NetworkCapabilities getNetworkCapabilities(@androidx.annotation.Nullable android.net.Network network) { throw new RuntimeException("Stub!"); }

/**
 * Request that keepalives be started on a IPsec NAT-T socket.
 *
 * @param network The {@link android.net.Network Network} the socket is on.
 * This value must never be {@code null}.
 * @param socket The socket that needs to be kept alive.
 * This value must never be {@code null}.
 * @param source The source address of the {@link android.net.IpSecManager.UdpEncapsulationSocket UdpEncapsulationSocket}.
 * This value must never be {@code null}.
 * @param destination The destination address of the {@link android.net.IpSecManager.UdpEncapsulationSocket UdpEncapsulationSocket}.
 * This value must never be {@code null}.
 * @param executor The executor on which callback will be invoked. The provided {@link java.util.concurrent.Executor Executor}
 *                 must run callback sequentially, otherwise the order of callbacks cannot be
 *                 guaranteed.
 * This value must never be {@code null}.
 * Callback and listener events are dispatched through this
 * {@link java.util.concurrent.Executor Executor}, providing an easy way to control which thread is
 * used. To dispatch events through the main thread of your
 * application, you can use {@link android.content.Context#getMainExecutor() Context#getMainExecutor()}. To
 * dispatch events through a shared thread pool, you can use
 * {@link android.os.AsyncTask#THREAD_POOL_EXECUTOR AsyncTask#THREAD_POOL_EXECUTOR}.
 * @param callback A {@link android.net.SocketKeepalive.Callback SocketKeepalive.Callback}. Used for notifications about keepalive
 *        changes. Must be extended by applications that use this API.
 *
 * This value must never be {@code null}.
 * @return A {@link android.net.SocketKeepalive SocketKeepalive} object that can be used to control the keepalive on the
 *         given socket.
 *
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.SocketKeepalive createSocketKeepalive(@androidx.annotation.NonNull android.net.Network network, @androidx.annotation.NonNull android.net.IpSecManager.UdpEncapsulationSocket socket, @androidx.annotation.NonNull java.net.InetAddress source, @androidx.annotation.NonNull java.net.InetAddress destination, @androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull android.net.SocketKeepalive.Callback callback) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of the setting for background data usage. If false,
 * applications should not use the network if the application is not in the
 * foreground. Developers should respect this setting, and check the value
 * of this before performing any background data operations.
 * <p>
 * All applications that have background services that use the network
 * should listen to {@link #ACTION_BACKGROUND_DATA_SETTING_CHANGED}.
 * <p>
 * @deprecated As of {@link android.os.Build.VERSION_CODES#ICE_CREAM_SANDWICH VERSION_CODES#ICE_CREAM_SANDWICH}, availability of
 * background data depends on several combined factors, and this method will
 * always return {@code true}. Instead, when background data is unavailable,
 * {@link #getActiveNetworkInfo()} will now appear disconnected.
 *
 * @return Whether background data usage is allowed.
 * @apiSince 3
 * @deprecatedSince 15
 */

@Deprecated
public boolean getBackgroundDataSetting() { throw new RuntimeException("Stub!"); }

/**
 * Start listening to reports when the system's default data network is active, meaning it is
 * a good time to perform network traffic.  Use {@link #isDefaultNetworkActive()}
 * to determine the current state of the system's default network after registering the
 * listener.
 * <p>
 * If the process default network has been set with
 * {@link android.net.ConnectivityManager#bindProcessToNetwork ConnectivityManager#bindProcessToNetwork} this function will not
 * reflect the process's default, but the system default.
 *
 * @param l The listener to be told when the network is active.
 * @apiSince 21
 */

public void addDefaultNetworkActiveListener(android.net.ConnectivityManager.OnNetworkActiveListener l) { throw new RuntimeException("Stub!"); }

/**
 * Remove network active listener previously registered with
 * {@link #addDefaultNetworkActiveListener}.
 *
 * @param l Previously registered listener.
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public void removeDefaultNetworkActiveListener(@androidx.annotation.NonNull android.net.ConnectivityManager.OnNetworkActiveListener l) { throw new RuntimeException("Stub!"); }

/**
 * Return whether the data network is currently active.  An active network means that
 * it is currently in a high power state for performing data transmission.  On some
 * types of networks, it may be expensive to move and stay in such a state, so it is
 * more power efficient to batch network traffic together when the radio is already in
 * this state.  This method tells you whether right now is currently a good time to
 * initiate network traffic, as the network is already active.
 * @apiSince 21
 */

public boolean isDefaultNetworkActive() { throw new RuntimeException("Stub!"); }

/**
 * Report a problem network to the framework.  This provides a hint to the system
 * that there might be connectivity problems on this network and may cause
 * the framework to re-evaluate network connectivity and/or switch to another
 * network.
 *
 * @param network The {@link android.net.Network Network} the application was attempting to use
 *                or {@code null} to indicate the current default network.
 * This value may be {@code null}.
 * @deprecated Use {@link #reportNetworkConnectivity} which allows reporting both
 *             working and non-working connectivity.
 * @apiSince 21
 * @deprecatedSince 23
 */

@Deprecated
public void reportBadNetwork(@androidx.annotation.Nullable android.net.Network network) { throw new RuntimeException("Stub!"); }

/**
 * Report to the framework whether a network has working connectivity.
 * This provides a hint to the system that a particular network is providing
 * working connectivity or not.  In response the framework may re-evaluate
 * the network's connectivity and might take further action thereafter.
 *
 * @param network The {@link android.net.Network Network} the application was attempting to use
 *                or {@code null} to indicate the current default network.
 * This value may be {@code null}.
 * @param hasConnectivity {@code true} if the application was able to successfully access the
 *                        Internet using {@code network} or {@code false} if not.
 * @apiSince 23
 */

public void reportNetworkConnectivity(@androidx.annotation.Nullable android.net.Network network, boolean hasConnectivity) { throw new RuntimeException("Stub!"); }

/**
 * Get the current default HTTP proxy settings.  If a global proxy is set it will be returned,
 * otherwise if this process is bound to a {@link android.net.Network Network} using
 * {@link #bindProcessToNetwork} then that {@code Network}'s proxy is returned, otherwise
 * the default network's proxy is returned.
 *
 * @return the {@link android.net.ProxyInfo ProxyInfo} for the current HTTP proxy, or {@code null} if no
 *        HTTP proxy is active.
 * @apiSince 23
 */

@androidx.annotation.Nullable
public android.net.ProxyInfo getDefaultProxy() { throw new RuntimeException("Stub!"); }

/**
 * Returns if the currently active data network is metered. A network is
 * classified as metered when the user is sensitive to heavy data usage on
 * that connection due to monetary costs, data limitations or
 * battery/performance issues. You should check this before doing large
 * data transfers, and warn the user or delay the operation until another
 * network is available.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
 * @return {@code true} if large transfers should be avoided, otherwise
 *        {@code false}.
 * @apiSince 16
 */

public boolean isActiveNetworkMetered() { throw new RuntimeException("Stub!"); }

/**
 * Request a network to satisfy a set of {@link android.net.NetworkCapabilities}.
 *
 * <p>This method will attempt to find the best network that matches the passed
 * {@link android.net.NetworkRequest NetworkRequest}, and to bring up one that does if none currently satisfies the
 * criteria. The platform will evaluate which network is the best at its own discretion.
 * Throughput, latency, cost per byte, policy, user preference and other considerations
 * may be factored in the decision of what is considered the best network.
 *
 * <p>As long as this request is outstanding, the platform will try to maintain the best network
 * matching this request, while always attempting to match the request to a better network if
 * possible. If a better match is found, the platform will switch this request to the now-best
 * network and inform the app of the newly best network by invoking
 * {@link android.net.ConnectivityManager.NetworkCallback#onAvailable(android.net.Network) NetworkCallback#onAvailable(Network)} on the provided callback. Note that the platform
 * will not try to maintain any other network than the best one currently matching the request:
 * a network not matching any network request may be disconnected at any time.
 *
 * <p>For example, an application could use this method to obtain a connected cellular network
 * even if the device currently has a data connection over Ethernet. This may cause the cellular
 * radio to consume additional power. Or, an application could inform the system that it wants
 * a network supporting sending MMSes and have the system let it know about the currently best
 * MMS-supporting network through the provided {@link android.net.ConnectivityManager.NetworkCallback NetworkCallback}.
 *
 * <p>The status of the request can be followed by listening to the various callbacks described
 * in {@link android.net.ConnectivityManager.NetworkCallback NetworkCallback}. The {@link android.net.Network Network} object passed to the callback methods can be
 * used to direct traffic to the network (although accessing some networks may be subject to
 * holding specific permissions). Callers will learn about the specific characteristics of the
 * network through
 * {@link android.net.ConnectivityManager.NetworkCallback#onCapabilitiesChanged(android.net.Network,android.net.NetworkCapabilities) NetworkCallback#onCapabilitiesChanged(Network, NetworkCapabilities)} and
 * {@link android.net.ConnectivityManager.NetworkCallback#onLinkPropertiesChanged(android.net.Network,android.net.LinkProperties) NetworkCallback#onLinkPropertiesChanged(Network, LinkProperties)}. The methods of the
 * provided {@link android.net.ConnectivityManager.NetworkCallback NetworkCallback} will only be invoked due to changes in the best network
 * matching the request at any given time; therefore when a better network matching the request
 * becomes available, the {@link android.net.ConnectivityManager.NetworkCallback#onAvailable(android.net.Network) NetworkCallback#onAvailable(Network)} method is called
 * with the new network after which no further updates are given about the previously-best
 * network, unless it becomes the best again at some later time. All callbacks are invoked
 * in order on the same thread, which by default is a thread created by the framework running
 * in the app.
 * {@see #requestNetwork(NetworkRequest, NetworkCallback, Handler)} to change where the
 * callbacks are invoked.
 *
 * <p>This{@link android.net.NetworkRequest NetworkRequest} will live until released via
 * {@link #unregisterNetworkCallback(android.net.ConnectivityManager.NetworkCallback)} or the calling application exits, at
 * which point the system may let go of the network at any time.
 *
 * <p>A version of this method which takes a timeout is
 * {@link #requestNetwork(android.net.NetworkRequest,android.net.ConnectivityManager.NetworkCallback,int)}, that an app can use to only
 * wait for a limited amount of time for the network to become unavailable.
 *
 * <p>It is presently unsupported to request a network with mutable
 * {@link android.net.NetworkCapabilities NetworkCapabilities} such as
 * {@link android.net.NetworkCapabilities#NET_CAPABILITY_VALIDATED NetworkCapabilities#NET_CAPABILITY_VALIDATED} or
 * {@link android.net.NetworkCapabilities#NET_CAPABILITY_CAPTIVE_PORTAL NetworkCapabilities#NET_CAPABILITY_CAPTIVE_PORTAL}
 * as these {@code NetworkCapabilities} represent states that a particular
 * network may never attain, and whether a network will attain these states
 * is unknown prior to bringing up the network so the framework does not
 * know how to go about satisfying a request with these capabilities.
 *
 * <p>This method requires the caller to hold either the
 * {@link android.Manifest.permission#CHANGE_NETWORK_STATE} permission
 * or the ability to modify system settings as determined by
 * {@link android.provider.Settings.System#canWrite}.</p>
 *
 * @param request {@link android.net.NetworkRequest NetworkRequest} describing this request.
 * This value must never be {@code null}.
 * @param networkCallback The {@link android.net.ConnectivityManager.NetworkCallback NetworkCallback} to be utilized for this request. Note
 *                        the callback must not be shared - it uniquely specifies this request.
 *                        The callback is invoked on the default internal Handler.
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if {@code request} contains invalid network capabilities.
 * @throws java.lang.SecurityException if missing the appropriate permissions.
 * @throws java.lang.RuntimeException if request limit per UID is exceeded.
 * @apiSince 21
 */

public void requestNetwork(@androidx.annotation.NonNull android.net.NetworkRequest request, @androidx.annotation.NonNull android.net.ConnectivityManager.NetworkCallback networkCallback) { throw new RuntimeException("Stub!"); }

/**
 * Request a network to satisfy a set of {@link android.net.NetworkCapabilities}.
 *
 * This method behaves identically to {@link #requestNetwork(android.net.NetworkRequest,android.net.ConnectivityManager.NetworkCallback)}
 * but runs all the callbacks on the passed Handler.
 *
 * <p>This method has the same permission requirements as
 * {@link #requestNetwork(android.net.NetworkRequest,android.net.ConnectivityManager.NetworkCallback)} and throws the same exceptions in
 * the same conditions.
 *
 * @param request {@link android.net.NetworkRequest NetworkRequest} describing this request.
 * This value must never be {@code null}.
 * @param networkCallback The {@link android.net.ConnectivityManager.NetworkCallback NetworkCallback} to be utilized for this request. Note
 *                        the callback must not be shared - it uniquely specifies this request.
 * This value must never be {@code null}.
 * @param handler {@link android.os.Handler Handler} to specify the thread upon which the callback will be invoked.
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public void requestNetwork(@androidx.annotation.NonNull android.net.NetworkRequest request, @androidx.annotation.NonNull android.net.ConnectivityManager.NetworkCallback networkCallback, @androidx.annotation.NonNull android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Request a network to satisfy a set of {@link android.net.NetworkCapabilities}, limited
 * by a timeout.
 *
 * This function behaves identically to the non-timed-out version
 * {@link #requestNetwork(android.net.NetworkRequest,android.net.ConnectivityManager.NetworkCallback)}, but if a suitable network
 * is not found within the given time (in milliseconds) the
 * {@link android.net.ConnectivityManager.NetworkCallback#onUnavailable() NetworkCallback#onUnavailable()} callback is called. The request can still be
 * released normally by calling {@link #unregisterNetworkCallback(android.net.ConnectivityManager.NetworkCallback)} but does
 * not have to be released if timed-out (it is automatically released). Unregistering a
 * request that timed out is not an error.
 *
 * <p>Do not use this method to poll for the existence of specific networks (e.g. with a small
 * timeout) - {@link #registerNetworkCallback(android.net.NetworkRequest,android.net.ConnectivityManager.NetworkCallback)} is provided
 * for that purpose. Calling this method will attempt to bring up the requested network.
 *
 * <p>This method has the same permission requirements as
 * {@link #requestNetwork(android.net.NetworkRequest,android.net.ConnectivityManager.NetworkCallback)} and throws the same exceptions in
 * the same conditions.
 *
 * @param request {@link android.net.NetworkRequest NetworkRequest} describing this request.
 * This value must never be {@code null}.
 * @param networkCallback The {@link android.net.ConnectivityManager.NetworkCallback NetworkCallback} to be utilized for this request. Note
 *                        the callback must not be shared - it uniquely specifies this request.
 * This value must never be {@code null}.
 * @param timeoutMs The time in milliseconds to attempt looking for a suitable network
 *                  before {@link android.net.ConnectivityManager.NetworkCallback#onUnavailable() NetworkCallback#onUnavailable()} is called. The timeout must
 *                  be a positive value (i.e. >0).
 * @apiSince 26
 */

public void requestNetwork(@androidx.annotation.NonNull android.net.NetworkRequest request, @androidx.annotation.NonNull android.net.ConnectivityManager.NetworkCallback networkCallback, int timeoutMs) { throw new RuntimeException("Stub!"); }

/**
 * Request a network to satisfy a set of {@link android.net.NetworkCapabilities}, limited
 * by a timeout.
 *
 * This method behaves identically to
 * {@link #requestNetwork(android.net.NetworkRequest,android.net.ConnectivityManager.NetworkCallback,int)} but runs all the callbacks
 * on the passed Handler.
 *
 * <p>This method has the same permission requirements as
 * {@link #requestNetwork(android.net.NetworkRequest,android.net.ConnectivityManager.NetworkCallback,int)} and throws the same exceptions
 * in the same conditions.
 *
 * @param request {@link android.net.NetworkRequest NetworkRequest} describing this request.
 * This value must never be {@code null}.
 * @param networkCallback The {@link android.net.ConnectivityManager.NetworkCallback NetworkCallback} to be utilized for this request. Note
 *                        the callback must not be shared - it uniquely specifies this request.
 * This value must never be {@code null}.
 * @param handler {@link android.os.Handler Handler} to specify the thread upon which the callback will be invoked.
 * This value must never be {@code null}.
 * @param timeoutMs The time in milliseconds to attempt looking for a suitable network
 *                  before {@link android.net.ConnectivityManager.NetworkCallback#onUnavailable NetworkCallback#onUnavailable} is called.
 * @apiSince 26
 */

public void requestNetwork(@androidx.annotation.NonNull android.net.NetworkRequest request, @androidx.annotation.NonNull android.net.ConnectivityManager.NetworkCallback networkCallback, @androidx.annotation.NonNull android.os.Handler handler, int timeoutMs) { throw new RuntimeException("Stub!"); }

/**
 * Request a network to satisfy a set of {@link android.net.NetworkCapabilities}.
 *
 * This function behaves identically to the version that takes a NetworkCallback, but instead
 * of {@link android.net.ConnectivityManager.NetworkCallback NetworkCallback} a {@link android.app.PendingIntent PendingIntent} is used.  This means
 * the request may outlive the calling application and get called back when a suitable
 * network is found.
 * <p>
 * The operation is an Intent broadcast that goes to a broadcast receiver that
 * you registered with {@link android.content.Context#registerReceiver Context#registerReceiver} or through the
 * &lt;receiver&gt; tag in an AndroidManifest.xml file
 * <p>
 * The operation Intent is delivered with two extras, a {@link android.net.Network Network} typed
 * extra called {@link #EXTRA_NETWORK} and a {@link android.net.NetworkRequest NetworkRequest}
 * typed extra called {@link #EXTRA_NETWORK_REQUEST} containing
 * the original requests parameters.  It is important to create a new,
 * {@link android.net.ConnectivityManager.NetworkCallback NetworkCallback} based request before completing the processing of the
 * Intent to reserve the network or it will be released shortly after the Intent
 * is processed.
 * <p>
 * If there is already a request for this Intent registered (with the equality of
 * two Intents defined by {@link android.content.Intent#filterEquals Intent#filterEquals}), then it will be removed and
 * replaced by this one, effectively releasing the previous {@link android.net.NetworkRequest NetworkRequest}.
 * <p>
 * The request may be released normally by calling
 * {@link #releaseNetworkRequest(android.app.PendingIntent)}.
 * <p>It is presently unsupported to request a network with either
 * {@link android.net.NetworkCapabilities#NET_CAPABILITY_VALIDATED NetworkCapabilities#NET_CAPABILITY_VALIDATED} or
 * {@link android.net.NetworkCapabilities#NET_CAPABILITY_CAPTIVE_PORTAL NetworkCapabilities#NET_CAPABILITY_CAPTIVE_PORTAL}
 * as these {@code NetworkCapabilities} represent states that a particular
 * network may never attain, and whether a network will attain these states
 * is unknown prior to bringing up the network so the framework does not
 * know how to go about satisfying a request with these capabilities.
 *
 * <p>This method requires the caller to hold either the
 * {@link android.Manifest.permission#CHANGE_NETWORK_STATE} permission
 * or the ability to modify system settings as determined by
 * {@link android.provider.Settings.System#canWrite}.</p>
 *
 * @param request {@link android.net.NetworkRequest NetworkRequest} describing this request.
 * This value must never be {@code null}.
 * @param operation Action to perform when the network is available (corresponds
 *                  to the {@link android.net.ConnectivityManager.NetworkCallback#onAvailable NetworkCallback#onAvailable} call.  Typically
 *                  comes from {@link android.app.PendingIntent#getBroadcast PendingIntent#getBroadcast}. Cannot be null.
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if {@code request} contains invalid network capabilities.
 * @throws java.lang.SecurityException if missing the appropriate permissions.
 * @throws java.lang.RuntimeException if request limit per UID is exceeded.
 * @apiSince 22
 */

public void requestNetwork(@androidx.annotation.NonNull android.net.NetworkRequest request, @androidx.annotation.NonNull android.app.PendingIntent operation) { throw new RuntimeException("Stub!"); }

/**
 * Removes a request made via {@link #requestNetwork(android.net.NetworkRequest,android.app.PendingIntent)}
 * <p>
 * This method has the same behavior as
 * {@link #unregisterNetworkCallback(android.app.PendingIntent)} with respect to
 * releasing network resources and disconnecting.
 *
 * @param operation A PendingIntent equal (as defined by {@link android.content.Intent#filterEquals Intent#filterEquals}) to the
 *                  PendingIntent passed to
 *                  {@link #requestNetwork(android.net.NetworkRequest,android.app.PendingIntent)} with the
 *                  corresponding NetworkRequest you'd like to remove. Cannot be null.
 
 * This value must never be {@code null}.
 * @apiSince 22
 */

public void releaseNetworkRequest(@androidx.annotation.NonNull android.app.PendingIntent operation) { throw new RuntimeException("Stub!"); }

/**
 * Registers to receive notifications about all networks which satisfy the given
 * {@link android.net.NetworkRequest NetworkRequest}.  The callbacks will continue to be called until
 * either the application exits or {@link #unregisterNetworkCallback(android.net.ConnectivityManager.NetworkCallback)} is
 * called.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
 * @param request {@link android.net.NetworkRequest NetworkRequest} describing this request.
 * This value must never be {@code null}.
 * @param networkCallback The {@link android.net.ConnectivityManager.NetworkCallback NetworkCallback} that the system will call as suitable
 *                        networks change state.
 *                        The callback is invoked on the default internal Handler.
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public void registerNetworkCallback(@androidx.annotation.NonNull android.net.NetworkRequest request, @androidx.annotation.NonNull android.net.ConnectivityManager.NetworkCallback networkCallback) { throw new RuntimeException("Stub!"); }

/**
 * Registers to receive notifications about all networks which satisfy the given
 * {@link android.net.NetworkRequest NetworkRequest}.  The callbacks will continue to be called until
 * either the application exits or {@link #unregisterNetworkCallback(android.net.ConnectivityManager.NetworkCallback)} is
 * called.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
 * @param request {@link android.net.NetworkRequest NetworkRequest} describing this request.
 * This value must never be {@code null}.
 * @param networkCallback The {@link android.net.ConnectivityManager.NetworkCallback NetworkCallback} that the system will call as suitable
 *                        networks change state.
 * This value must never be {@code null}.
 * @param handler {@link android.os.Handler Handler} to specify the thread upon which the callback will be invoked.
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public void registerNetworkCallback(@androidx.annotation.NonNull android.net.NetworkRequest request, @androidx.annotation.NonNull android.net.ConnectivityManager.NetworkCallback networkCallback, @androidx.annotation.NonNull android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Registers a PendingIntent to be sent when a network is available which satisfies the given
 * {@link android.net.NetworkRequest NetworkRequest}.
 *
 * This function behaves identically to the version that takes a NetworkCallback, but instead
 * of {@link android.net.ConnectivityManager.NetworkCallback NetworkCallback} a {@link android.app.PendingIntent PendingIntent} is used.  This means
 * the request may outlive the calling application and get called back when a suitable
 * network is found.
 * <p>
 * The operation is an Intent broadcast that goes to a broadcast receiver that
 * you registered with {@link android.content.Context#registerReceiver Context#registerReceiver} or through the
 * &lt;receiver&gt; tag in an AndroidManifest.xml file
 * <p>
 * The operation Intent is delivered with two extras, a {@link android.net.Network Network} typed
 * extra called {@link #EXTRA_NETWORK} and a {@link android.net.NetworkRequest NetworkRequest}
 * typed extra called {@link #EXTRA_NETWORK_REQUEST} containing
 * the original requests parameters.
 * <p>
 * If there is already a request for this Intent registered (with the equality of
 * two Intents defined by {@link android.content.Intent#filterEquals Intent#filterEquals}), then it will be removed and
 * replaced by this one, effectively releasing the previous {@link android.net.NetworkRequest NetworkRequest}.
 * <p>
 * The request may be released normally by calling
 * {@link #unregisterNetworkCallback(android.app.PendingIntent)}.
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
 * @param request {@link android.net.NetworkRequest NetworkRequest} describing this request.
 * This value must never be {@code null}.
 * @param operation Action to perform when the network is available (corresponds
 *                  to the {@link android.net.ConnectivityManager.NetworkCallback#onAvailable NetworkCallback#onAvailable} call.  Typically
 *                  comes from {@link android.app.PendingIntent#getBroadcast PendingIntent#getBroadcast}. Cannot be null.
 
 * This value must never be {@code null}.
 * @apiSince 23
 */

public void registerNetworkCallback(@androidx.annotation.NonNull android.net.NetworkRequest request, @androidx.annotation.NonNull android.app.PendingIntent operation) { throw new RuntimeException("Stub!"); }

/**
 * Registers to receive notifications about changes in the system default network. The callbacks
 * will continue to be called until either the application exits or
 * {@link #unregisterNetworkCallback(android.net.ConnectivityManager.NetworkCallback)} is called.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
 * @param networkCallback The {@link android.net.ConnectivityManager.NetworkCallback NetworkCallback} that the system will call as the
 *                        system default network changes.
 *                        The callback is invoked on the default internal Handler.
 
 * This value must never be {@code null}.
 * @apiSince 24
 */

public void registerDefaultNetworkCallback(@androidx.annotation.NonNull android.net.ConnectivityManager.NetworkCallback networkCallback) { throw new RuntimeException("Stub!"); }

/**
 * Registers to receive notifications about changes in the system default network. The callbacks
 * will continue to be called until either the application exits or
 * {@link #unregisterNetworkCallback(android.net.ConnectivityManager.NetworkCallback)} is called.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
 * @param networkCallback The {@link android.net.ConnectivityManager.NetworkCallback NetworkCallback} that the system will call as the
 *                        system default network changes.
 * This value must never be {@code null}.
 * @param handler {@link android.os.Handler Handler} to specify the thread upon which the callback will be invoked.
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public void registerDefaultNetworkCallback(@androidx.annotation.NonNull android.net.ConnectivityManager.NetworkCallback networkCallback, @androidx.annotation.NonNull android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Requests bandwidth update for a given {@link android.net.Network Network} and returns whether the update request
 * is accepted by ConnectivityService. Once accepted, ConnectivityService will poll underlying
 * network connection for updated bandwidth information. The caller will be notified via
 * {@link android.net.ConnectivityManager.NetworkCallback ConnectivityManager.NetworkCallback} if there is an update. Notice that this
 * method assumes that the caller has previously called
 * {@link #registerNetworkCallback(android.net.NetworkRequest,android.net.ConnectivityManager.NetworkCallback)} to listen for network
 * changes.
 *
 * @param network {@link android.net.Network Network} specifying which network you're interested.
 * This value must never be {@code null}.
 * @return {@code true} on success, {@code false} if the {@link android.net.Network Network} is no longer valid.
 * @apiSince 23
 */

public boolean requestBandwidthUpdate(@androidx.annotation.NonNull android.net.Network network) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters a {@code NetworkCallback} and possibly releases networks originating from
 * {@link #requestNetwork(android.net.NetworkRequest,android.net.ConnectivityManager.NetworkCallback)} and
 * {@link #registerNetworkCallback(android.net.NetworkRequest,android.net.ConnectivityManager.NetworkCallback)} calls.
 * If the given {@code NetworkCallback} had previously been used with
 * {@code #requestNetwork}, any networks that had been connected to only to satisfy that request
 * will be disconnected.
 *
 * Notifications that would have triggered that {@code NetworkCallback} will immediately stop
 * triggering it as soon as this call returns.
 *
 * @param networkCallback The {@link android.net.ConnectivityManager.NetworkCallback NetworkCallback} used when making the request.
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public void unregisterNetworkCallback(@androidx.annotation.NonNull android.net.ConnectivityManager.NetworkCallback networkCallback) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters a callback previously registered via
 * {@link #registerNetworkCallback(android.net.NetworkRequest,android.app.PendingIntent)}.
 *
 * @param operation A PendingIntent equal (as defined by {@link android.content.Intent#filterEquals Intent#filterEquals}) to the
 *                  PendingIntent passed to
 *                  {@link #registerNetworkCallback(android.net.NetworkRequest,android.app.PendingIntent)}.
 *                  Cannot be null.
 
 * This value must never be {@code null}.
 * @apiSince 23
 */

public void unregisterNetworkCallback(@androidx.annotation.NonNull android.app.PendingIntent operation) { throw new RuntimeException("Stub!"); }

/**
 * Provides a hint to the calling application on whether it is desirable to use the
 * multinetwork APIs (e.g., {@link android.net.Network#openConnection Network#openConnection}, {@link android.net.Network#bindSocket Network#bindSocket}, etc.)
 * for multipath data transfer on this network when it is not the system default network.
 * Applications desiring to use multipath network protocols should call this method before
 * each such operation.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
 * @param network The network on which the application desires to use multipath data.
 *                If {@code null}, this method will return the a preference that will generally
 *                apply to metered networks.
 * This value may be {@code null}.
 * @return a bitwise OR of zero or more of the  {@code MULTIPATH_PREFERENCE_*} constants.
 
 * Value is either <code>0</code> or a combination of {@link android.net.ConnectivityManager#MULTIPATH_PREFERENCE_HANDOVER}, {@link android.net.ConnectivityManager#MULTIPATH_PREFERENCE_RELIABILITY}, and {@link android.net.ConnectivityManager#MULTIPATH_PREFERENCE_PERFORMANCE}
 * @apiSince 26
 */

public int getMultipathPreference(@androidx.annotation.Nullable android.net.Network network) { throw new RuntimeException("Stub!"); }

/**
 * Binds the current process to {@code network}.  All Sockets created in the future
 * (and not explicitly bound via a bound SocketFactory from
 * {@link android.net.Network#getSocketFactory() Network#getSocketFactory()}) will be bound to
 * {@code network}.  All host name resolutions will be limited to {@code network} as well.
 * Note that if {@code network} ever disconnects, all Sockets created in this way will cease to
 * work and all host name resolutions will fail.  This is by design so an application doesn't
 * accidentally use Sockets it thinks are still bound to a particular {@link android.net.Network Network}.
 * To clear binding pass {@code null} for {@code network}.  Using individually bound
 * Sockets created by Network.getSocketFactory().createSocket() and
 * performing network-specific host name resolutions via
 * {@link android.net.Network#getAllByName Network#getAllByName} is preferred to calling
 * {@code bindProcessToNetwork}.
 *
 * @param network The {@link android.net.Network Network} to bind the current process to, or {@code null} to clear
 *                the current binding.
 * This value may be {@code null}.
 * @return {@code true} on success, {@code false} if the {@link android.net.Network Network} is no longer valid.
 * @apiSince 23
 */

public boolean bindProcessToNetwork(@androidx.annotation.Nullable android.net.Network network) { throw new RuntimeException("Stub!"); }

/**
 * Binds the current process to {@code network}.  All Sockets created in the future
 * (and not explicitly bound via a bound SocketFactory from
 * {@link android.net.Network#getSocketFactory() Network#getSocketFactory()}) will be bound to
 * {@code network}.  All host name resolutions will be limited to {@code network} as well.
 * Note that if {@code network} ever disconnects, all Sockets created in this way will cease to
 * work and all host name resolutions will fail.  This is by design so an application doesn't
 * accidentally use Sockets it thinks are still bound to a particular {@link android.net.Network Network}.
 * To clear binding pass {@code null} for {@code network}.  Using individually bound
 * Sockets created by Network.getSocketFactory().createSocket() and
 * performing network-specific host name resolutions via
 * {@link android.net.Network#getAllByName Network#getAllByName} is preferred to calling
 * {@code setProcessDefaultNetwork}.
 *
 * @param network The {@link android.net.Network Network} to bind the current process to, or {@code null} to clear
 *                the current binding.
 * This value may be {@code null}.
 * @return {@code true} on success, {@code false} if the {@link android.net.Network Network} is no longer valid.
 * @deprecated This function can throw {@link java.lang.IllegalStateException IllegalStateException}.  Use
 *             {@link #bindProcessToNetwork} instead.  {@code bindProcessToNetwork}
 *             is a direct replacement.
 * @apiSince 21
 * @deprecatedSince 23
 */

@Deprecated
public static boolean setProcessDefaultNetwork(@androidx.annotation.Nullable android.net.Network network) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.net.Network Network} currently bound to this process via
 * {@link #bindProcessToNetwork}, or {@code null} if no {@link android.net.Network Network} is explicitly bound.
 *
 * @return {@code Network} to which this process is bound, or {@code null}.
 * @apiSince 23
 */

@androidx.annotation.Nullable
public android.net.Network getBoundNetworkForProcess() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.net.Network Network} currently bound to this process via
 * {@link #bindProcessToNetwork}, or {@code null} if no {@link android.net.Network Network} is explicitly bound.
 *
 * @return {@code Network} to which this process is bound, or {@code null}.
 * @deprecated Using this function can lead to other functions throwing
 *             {@link java.lang.IllegalStateException IllegalStateException}.  Use {@link #getBoundNetworkForProcess} instead.
 *             {@code getBoundNetworkForProcess} is a direct replacement.
 * @apiSince 21
 * @deprecatedSince 23
 */

@Deprecated
@androidx.annotation.Nullable
public static android.net.Network getProcessDefaultNetwork() { throw new RuntimeException("Stub!"); }

/**
 * Determines if the calling application is subject to metered network restrictions while
 * running on background.
 *
 * @return {@link #RESTRICT_BACKGROUND_STATUS_DISABLED},
 * {@link #RESTRICT_BACKGROUND_STATUS_ENABLED},
 * or {@link #RESTRICT_BACKGROUND_STATUS_WHITELISTED}
 
 * Value is {@link android.net.ConnectivityManager#RESTRICT_BACKGROUND_STATUS_DISABLED}, {@link android.net.ConnectivityManager#RESTRICT_BACKGROUND_STATUS_WHITELISTED}, or {@link android.net.ConnectivityManager#RESTRICT_BACKGROUND_STATUS_ENABLED}
 * @apiSince 24
 */

public int getRestrictBackgroundStatus() { throw new RuntimeException("Stub!"); }

/**
 * The network watchlist is a list of domains and IP addresses that are associated with
 * potentially harmful apps. This method returns the SHA-256 of the watchlist config file
 * currently used by the system for validation purposes.
 *
 * @return Hash of network watchlist config file. Null if config does not exist.
 
 * This value may be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public byte[] getNetworkWatchlistConfigHash() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@code uid} of the owner of a network connection.
 *
 * @param protocol The protocol of the connection. Only {@code IPPROTO_TCP} and
 * {@code IPPROTO_UDP} currently supported.
 * @param local The local {@link java.net.InetSocketAddress InetSocketAddress} of a connection.
 * This value must never be {@code null}.
 * @param remote The remote {@link java.net.InetSocketAddress InetSocketAddress} of a connection.
 *
 * This value must never be {@code null}.
 * @return {@code uid} if the connection is found and the app has permission to observe it
 * (e.g., if it is associated with the calling VPN app's tunnel) or
 * {@link android.os.Process#INVALID_UID} if the connection is not found.
 * Throws {@link java.lang.SecurityException SecurityException} if the caller is not the active VPN for the current user.
 * Throws {@link java.lang.IllegalArgumentException IllegalArgumentException} if an unsupported protocol is requested.
 * @apiSince 29
 */

public int getConnectionOwnerUid(int protocol, @androidx.annotation.NonNull java.net.InetSocketAddress local, @androidx.annotation.NonNull java.net.InetSocketAddress remote) { throw new RuntimeException("Stub!"); }

/**
 * Broadcast Action: The setting for background data usage has changed
 * values. Use {@link #getBackgroundDataSetting()} to get the current value.
 * <p>
 * If an application uses the network in the background, it should listen
 * for this broadcast and stop using the background data if the value is
 * {@code false}.
 * <p>
 *
 * @deprecated As of {@link android.os.Build.VERSION_CODES#ICE_CREAM_SANDWICH VERSION_CODES#ICE_CREAM_SANDWICH}, availability
 *             of background data depends on several combined factors, and
 *             this broadcast is no longer sent. Instead, when background
 *             data is unavailable, {@link #getActiveNetworkInfo()} will now
 *             appear disconnected. During first boot after a platform
 *             upgrade, this broadcast will be sent once if
 *             {@link #getBackgroundDataSetting()} was {@code false} before
 *             the upgrade.
 * @apiSince 3
 * @deprecatedSince 16
 */

@Deprecated public static final java.lang.String ACTION_BACKGROUND_DATA_SETTING_CHANGED = "android.net.conn.BACKGROUND_DATA_SETTING_CHANGED";

/**
 * The device has connected to a network that has presented a captive
 * portal, which is blocking Internet connectivity. The user was presented
 * with a notification that network sign in is required,
 * and the user invoked the notification's action indicating they
 * desire to sign in to the network. Apps handling this activity should
 * facilitate signing in to the network. This action includes a
 * {@link android.net.Network Network} typed extra called {@link #EXTRA_NETWORK} that represents
 * the network presenting the captive portal; all communication with the
 * captive portal must be done using this {@code Network} object.
 * <p/>
 * This activity includes a {@link android.net.CaptivePortal CaptivePortal} extra named
 * {@link #EXTRA_CAPTIVE_PORTAL} that can be used to indicate different
 * outcomes of the captive portal sign in to the system:
 * <ul>
 * <li> When the app handling this action believes the user has signed in to
 * the network and the captive portal has been dismissed, the app should
 * call {@link android.net.CaptivePortal#reportCaptivePortalDismissed CaptivePortal#reportCaptivePortalDismissed} so the system can
 * reevaluate the network. If reevaluation finds the network no longer
 * subject to a captive portal, the network may become the default active
 * data network.</li>
 * <li> When the app handling this action believes the user explicitly wants
 * to ignore the captive portal and the network, the app should call
 * {@link android.net.CaptivePortal#ignoreNetwork CaptivePortal#ignoreNetwork}. </li>
 * </ul>
 * @apiSince 23
 */

public static final java.lang.String ACTION_CAPTIVE_PORTAL_SIGN_IN = "android.net.conn.CAPTIVE_PORTAL";

/**
 * A change in the background metered network activity restriction has occurred.
 * <p>
 * Applications should call {@link #getRestrictBackgroundStatus()} to check if the restriction
 * applies to them.
 * <p>
 * This is only sent to registered receivers, not manifest receivers.
 * @apiSince 24
 */

public static final java.lang.String ACTION_RESTRICT_BACKGROUND_CHANGED = "android.net.conn.RESTRICT_BACKGROUND_CHANGED";

/**
 * A change in network connectivity has occurred. A default connection has either
 * been established or lost. The NetworkInfo for the affected network is
 * sent as an extra; it should be consulted to see what kind of
 * connectivity event occurred.
 * <p/>
 * Apps targeting Android 7.0 (API level 24) and higher do not receive this
 * broadcast if they declare the broadcast receiver in their manifest. Apps
 * will still receive broadcasts if they register their
 * {@link android.content.BroadcastReceiver} with
 * {@link android.content.Context#registerReceiver Context.registerReceiver()}
 * and that context is still valid.
 * <p/>
 * If this is a connection that was the result of failing over from a
 * disconnected network, then the FAILOVER_CONNECTION boolean extra is
 * set to true.
 * <p/>
 * For a loss of connectivity, if the connectivity manager is attempting
 * to connect (or has already connected) to another network, the
 * NetworkInfo for the new network is also passed as an extra. This lets
 * any receivers of the broadcast know that they should not necessarily
 * tell the user that no data traffic will be possible. Instead, the
 * receiver should expect another broadcast soon, indicating either that
 * the failover attempt succeeded (and so there is still overall data
 * connectivity), or that the failover attempt failed, meaning that all
 * connectivity has been lost.
 * <p/>
 * For a disconnect event, the boolean extra EXTRA_NO_CONNECTIVITY
 * is set to {@code true} if there are no connected networks at all.
 *
 * @deprecated apps should use the more versatile {@link #requestNetwork},
 *             {@link #registerNetworkCallback} or {@link #registerDefaultNetworkCallback}
 *             functions instead for faster and more detailed updates about the network
 *             changes they care about.
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated public static final java.lang.String CONNECTIVITY_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";

/**
 * If you want to set the default network preference,you can directly
 * change the networkAttributes array in framework's config.xml.
 *
 * @deprecated Since we support so many more networks now, the single
 *             network default network preference can't really express
 *             the hierarchy.  Instead, the default is defined by the
 *             networkAttributes in config.xml.  You can determine
 *             the current value by calling {@link #getNetworkPreference()}
 *             from an App.
 * @apiSince 1
 * @deprecatedSince 18
 */

@Deprecated public static final int DEFAULT_NETWORK_PREFERENCE = 1; // 0x1

/**
 * The lookup key for a {@link android.net.CaptivePortal CaptivePortal} object included with the
 * {@link #ACTION_CAPTIVE_PORTAL_SIGN_IN} intent.  The {@code CaptivePortal}
 * object can be used to either indicate to the system that the captive
 * portal has been dismissed or that the user does not want to pursue
 * signing in to captive portal.  Retrieve it with
 * {@link android.content.Intent#getParcelableExtra(String)}.
 * @apiSince 23
 */

public static final java.lang.String EXTRA_CAPTIVE_PORTAL = "android.net.extra.CAPTIVE_PORTAL";

/**
 * Key for passing a URL to the captive portal login activity.
 * @apiSince 24
 */

public static final java.lang.String EXTRA_CAPTIVE_PORTAL_URL = "android.net.extra.CAPTIVE_PORTAL_URL";

/**
 * The lookup key for a string that provides optionally supplied
 * extra information about the network state. The information
 * may be passed up from the lower networking layers, and its
 * meaning may be specific to a particular network type. Retrieve
 * it with {@link android.content.Intent#getStringExtra(String)}.
 *
 * @deprecated See {@link android.net.NetworkInfo#getExtraInfo() NetworkInfo#getExtraInfo()}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String EXTRA_EXTRA_INFO = "extraInfo";

/**
 * The lookup key for a boolean that indicates whether a connect event
 * is for a network to which the connectivity manager was failing over
 * following a disconnect on another network.
 * Retrieve it with {@link android.content.Intent#getBooleanExtra(String,boolean)}.
 *
 * @deprecated See {@link android.net.NetworkInfo NetworkInfo}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String EXTRA_IS_FAILOVER = "isFailover";

/**
 * The lookup key for a {@link android.net.Network Network} object included with the intent after
 * successfully finding a network for the applications request.  Retrieve it with
 * {@link android.content.Intent#getParcelableExtra(String)}.
 * <p>
 * Note that if you intend to invoke {@link android.net.Network#openConnection(java.net.URL) Network#openConnection(java.net.URL)}
 * then you must get a ConnectivityManager instance before doing so.
 * @apiSince 22
 */

public static final java.lang.String EXTRA_NETWORK = "android.net.extra.NETWORK";

/**
 * The lookup key for a {@link android.net.NetworkInfo NetworkInfo} object. Retrieve with
 * {@link android.content.Intent#getParcelableExtra(String)}.
 *
 * @deprecated The {@link android.net.NetworkInfo NetworkInfo} object is deprecated, as many of its properties
 *             can't accurately represent modern network characteristics.
 *             Please obtain information about networks from the {@link android.net.NetworkCapabilities NetworkCapabilities}
 *             or {@link android.net.LinkProperties LinkProperties} objects instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String EXTRA_NETWORK_INFO = "networkInfo";

/**
 * The lookup key for a {@link android.net.NetworkRequest NetworkRequest} object included with the intent after
 * successfully finding a network for the applications request.  Retrieve it with
 * {@link android.content.Intent#getParcelableExtra(String)}.
 * @apiSince 22
 */

public static final java.lang.String EXTRA_NETWORK_REQUEST = "android.net.extra.NETWORK_REQUEST";

/**
 * Network type which triggered a {@link #CONNECTIVITY_ACTION} broadcast.
 *
 * @see android.content.Intent#getIntExtra(String, int)
 * @deprecated The network type is not rich enough to represent the characteristics
 *             of modern networks. Please use {@link android.net.NetworkCapabilities NetworkCapabilities} instead,
 *             in particular the transports.
 * @apiSince 17
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String EXTRA_NETWORK_TYPE = "networkType";

/**
 * The lookup key for a boolean that indicates whether there is a
 * complete lack of connectivity, i.e., no network is available.
 * Retrieve it with {@link android.content.Intent#getBooleanExtra(String,boolean)}.
 * @apiSince 1
 */

public static final java.lang.String EXTRA_NO_CONNECTIVITY = "noConnectivity";

/**
 * The lookup key for a {@link android.net.NetworkInfo NetworkInfo} object. This is supplied when
 * there is another network that it may be possible to connect to. Retrieve with
 * {@link android.content.Intent#getParcelableExtra(String)}.
 *
 * @deprecated See {@link android.net.NetworkInfo NetworkInfo}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String EXTRA_OTHER_NETWORK_INFO = "otherNetwork";

/**
 * The lookup key for a string that indicates why an attempt to connect
 * to a network failed. The string has no particular structure. It is
 * intended to be used in notifications presented to users. Retrieve
 * it with {@link android.content.Intent#getStringExtra(String)}.
 * @apiSince 1
 */

public static final java.lang.String EXTRA_REASON = "reason";

/**
 * It is acceptable to briefly use multipath data to provide seamless connectivity for
 * time-sensitive user-facing operations when the system default network is temporarily
 * unresponsive. The amount of data should be limited (less than one megabyte for every call to
 * this method), and the operation should be infrequent to ensure that data usage is limited.
 *
 * An example of such an operation might be a time-sensitive foreground activity, such as a
 * voice command, that the user is performing while walking out of range of a Wi-Fi network.
 * @apiSince 26
 */

public static final int MULTIPATH_PREFERENCE_HANDOVER = 1; // 0x1

/**
 * It is acceptable to use metered data to improve network latency and performance.
 * @apiSince 26
 */

public static final int MULTIPATH_PREFERENCE_PERFORMANCE = 4; // 0x4

/**
 * It is acceptable to use small amounts of multipath data on an ongoing basis to provide
 * a backup channel for traffic that is primarily going over another network.
 *
 * An example might be maintaining backup connections to peers or servers for the purpose of
 * fast fallback if the default network is temporarily unresponsive or disconnects. The traffic
 * on backup paths should be negligible compared to the traffic on the main path.
 * @apiSince 26
 */

public static final int MULTIPATH_PREFERENCE_RELIABILITY = 2; // 0x2

/**
 * Device is not restricting metered network activity while application is running on
 * background.
 * @apiSince 24
 */

public static final int RESTRICT_BACKGROUND_STATUS_DISABLED = 1; // 0x1

/**
 * Device is restricting metered network activity while application is running on background.
 * <p>
 * In this state, application should not try to use the network while running on background,
 * because it would be denied.
 * @apiSince 24
 */

public static final int RESTRICT_BACKGROUND_STATUS_ENABLED = 3; // 0x3

/**
 * Device is restricting metered network activity while application is running on background,
 * but application is allowed to bypass it.
 * <p>
 * In this state, application should take action to mitigate metered network access.
 * For example, a music streaming application should switch to a low-bandwidth bitrate.
 * @apiSince 24
 */

public static final int RESTRICT_BACKGROUND_STATUS_WHITELISTED = 2; // 0x2

/**
 * A Bluetooth data connection.
 *
 * @deprecated Applications should instead use {@link android.net.NetworkCapabilities#hasTransport NetworkCapabilities#hasTransport} or
 *         {@link #requestNetwork(android.net.NetworkRequest,android.net.ConnectivityManager.NetworkCallback)} to request an
 *         appropriate network. {@see NetworkCapabilities} for supported transports.
 * @apiSince 13
 * @deprecatedSince 28
 */

@Deprecated public static final int TYPE_BLUETOOTH = 7; // 0x7

/**
 * Dummy data connection.  This should not be used on shipping devices.
 * @deprecated This is not used any more.
 * @apiSince 14
 * @deprecatedSince 28
 */

@Deprecated public static final int TYPE_DUMMY = 8; // 0x8

/**
 * An Ethernet data connection.
 *
 * @deprecated Applications should instead use {@link android.net.NetworkCapabilities#hasTransport NetworkCapabilities#hasTransport} or
 *         {@link #requestNetwork(android.net.NetworkRequest,android.net.ConnectivityManager.NetworkCallback)} to request an
 *         appropriate network. {@see NetworkCapabilities} for supported transports.
 * @apiSince 13
 * @deprecatedSince 28
 */

@Deprecated public static final int TYPE_ETHERNET = 9; // 0x9

/**
 * A Mobile data connection. Devices may support more than one.
 *
 * @deprecated Applications should instead use {@link android.net.NetworkCapabilities#hasTransport NetworkCapabilities#hasTransport} or
 *         {@link #requestNetwork(android.net.NetworkRequest,android.net.ConnectivityManager.NetworkCallback)} to request an
 *         appropriate network. {@see NetworkCapabilities} for supported transports.
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated public static final int TYPE_MOBILE = 0; // 0x0

/**
 * A DUN-specific Mobile data connection.  This network type may use the
 * same network interface as {@link #TYPE_MOBILE} or it may use a different
 * one.  This is sometimes by the system when setting up an upstream connection
 * for tethering so that the carrier is aware of DUN traffic.
 *
 * @deprecated Applications should instead use {@link android.net.NetworkCapabilities#hasCapability NetworkCapabilities#hasCapability} or
 *         {@link #requestNetwork(android.net.NetworkRequest,android.net.ConnectivityManager.NetworkCallback)} to request a network that
 *         provides the {@link android.net.NetworkCapabilities#NET_CAPABILITY_DUN NetworkCapabilities#NET_CAPABILITY_DUN} capability.
 * @apiSince 8
 * @deprecatedSince 28
 */

@Deprecated public static final int TYPE_MOBILE_DUN = 4; // 0x4

/**
 * A High Priority Mobile data connection.  This network type uses the
 * same network interface as {@link #TYPE_MOBILE} but the routing setup
 * is different.
 *
 * @deprecated Applications should instead use {@link android.net.NetworkCapabilities#hasTransport NetworkCapabilities#hasTransport} or
 *         {@link #requestNetwork(android.net.NetworkRequest,android.net.ConnectivityManager.NetworkCallback)} to request an
 *         appropriate network. {@see NetworkCapabilities} for supported transports.
 * @apiSince 8
 * @deprecatedSince 23
 */

@Deprecated public static final int TYPE_MOBILE_HIPRI = 5; // 0x5

/**
 * An MMS-specific Mobile data connection.  This network type may use the
 * same network interface as {@link #TYPE_MOBILE} or it may use a different
 * one.  This is used by applications needing to talk to the carrier's
 * Multimedia Messaging Service servers.
 *
 * @deprecated Applications should instead use {@link android.net.NetworkCapabilities#hasCapability NetworkCapabilities#hasCapability} or
 *         {@link #requestNetwork(android.net.NetworkRequest,android.net.ConnectivityManager.NetworkCallback)} to request a network that
 *         provides the {@link android.net.NetworkCapabilities#NET_CAPABILITY_MMS NetworkCapabilities#NET_CAPABILITY_MMS} capability.
 * @apiSince 8
 * @deprecatedSince 23
 */

@Deprecated public static final int TYPE_MOBILE_MMS = 2; // 0x2

/**
 * A SUPL-specific Mobile data connection.  This network type may use the
 * same network interface as {@link #TYPE_MOBILE} or it may use a different
 * one.  This is used by applications needing to talk to the carrier's
 * Secure User Plane Location servers for help locating the device.
 *
 * @deprecated Applications should instead use {@link android.net.NetworkCapabilities#hasCapability NetworkCapabilities#hasCapability} or
 *         {@link #requestNetwork(android.net.NetworkRequest,android.net.ConnectivityManager.NetworkCallback)} to request a network that
 *         provides the {@link android.net.NetworkCapabilities#NET_CAPABILITY_SUPL NetworkCapabilities#NET_CAPABILITY_SUPL} capability.
 * @apiSince 8
 * @deprecatedSince 23
 */

@Deprecated public static final int TYPE_MOBILE_SUPL = 3; // 0x3

/**
 * A virtual network using one or more native bearers.
 * It may or may not be providing security services.
 * @deprecated Applications should use {@link android.net.NetworkCapabilities#TRANSPORT_VPN NetworkCapabilities#TRANSPORT_VPN} instead.
 * @apiSince 21
 * @deprecatedSince 28
 */

@Deprecated public static final int TYPE_VPN = 17; // 0x11

/**
 * A WIFI data connection. Devices may support more than one.
 *
 * @deprecated Applications should instead use {@link android.net.NetworkCapabilities#hasTransport NetworkCapabilities#hasTransport} or
 *         {@link #requestNetwork(android.net.NetworkRequest,android.net.ConnectivityManager.NetworkCallback)} to request an
 *         appropriate network. {@see NetworkCapabilities} for supported transports.
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated public static final int TYPE_WIFI = 1; // 0x1

/**
 * A WiMAX data connection.
 *
 * @deprecated Applications should instead use {@link android.net.NetworkCapabilities#hasTransport NetworkCapabilities#hasTransport} or
 *         {@link #requestNetwork(android.net.NetworkRequest,android.net.ConnectivityManager.NetworkCallback)} to request an
 *         appropriate network. {@see NetworkCapabilities} for supported transports.
 * @apiSince 8
 * @deprecatedSince 28
 */

@Deprecated public static final int TYPE_WIMAX = 6; // 0x6
/**
 * Base class for {@code NetworkRequest} callbacks. Used for notifications about network
 * changes. Should be extended by applications wanting notifications.
 *
 * A {@code NetworkCallback} is registered by calling
 * {@link #requestNetwork(android.net.NetworkRequest,android.net.ConnectivityManager.NetworkCallback)},
 * {@link #registerNetworkCallback(android.net.NetworkRequest,android.net.ConnectivityManager.NetworkCallback)},
 * or {@link #registerDefaultNetworkCallback(android.net.ConnectivityManager.NetworkCallback)}. A {@code NetworkCallback} is
 * unregistered by calling {@link #unregisterNetworkCallback(android.net.ConnectivityManager.NetworkCallback)}.
 * A {@code NetworkCallback} should be registered at most once at any time.
 * A {@code NetworkCallback} that has been unregistered can be registered again.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class NetworkCallback {

public NetworkCallback() { throw new RuntimeException("Stub!"); }

/**
 * Called when the framework connects and has declared a new network ready for use.
 *
 * <p>For callbacks registered with {@link #registerNetworkCallback}, multiple networks may
 * be available at the same time, and onAvailable will be called for each of these as they
 * appear.
 *
 * <p>For callbacks registered with {@link #requestNetwork} and
 * {@link #registerDefaultNetworkCallback}, this means the network passed as an argument
 * is the new best network for this request and is now tracked by this callback ; this
 * callback will no longer receive method calls about other networks that may have been
 * passed to this method previously. The previously-best network may have disconnected, or
 * it may still be around and the newly-best network may simply be better.
 *
 * <p>Starting with {@link android.os.Build.VERSION_CODES#O}, this will always immediately
 * be followed by a call to {@link #onCapabilitiesChanged(android.net.Network,android.net.NetworkCapabilities)}
 * then by a call to {@link #onLinkPropertiesChanged(android.net.Network,android.net.LinkProperties)}, and a call
 * to {@link #onBlockedStatusChanged(android.net.Network,boolean)}.
 *
 * <p>Do NOT call {@link #getNetworkCapabilities(android.net.Network)} or
 * {@link #getLinkProperties(android.net.Network)} or other synchronous ConnectivityManager methods in
 * this callback as this is prone to race conditions (there is no guarantee the objects
 * returned by these methods will be current). Instead, wait for a call to
 * {@link #onCapabilitiesChanged(android.net.Network,android.net.NetworkCapabilities)} and
 * {@link #onLinkPropertiesChanged(android.net.Network,android.net.LinkProperties)} whose arguments are guaranteed
 * to be well-ordered with respect to other callbacks.
 *
 * @param network The {@link android.net.Network Network} of the satisfying network.
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public void onAvailable(@androidx.annotation.NonNull android.net.Network network) { throw new RuntimeException("Stub!"); }

/**
 * Called when the network is about to be lost, typically because there are no outstanding
 * requests left for it. This may be paired with a {@link android.net.ConnectivityManager.NetworkCallback#onAvailable NetworkCallback#onAvailable} call
 * with the new replacement network for graceful handover. This method is not guaranteed
 * to be called before {@link android.net.ConnectivityManager.NetworkCallback#onLost NetworkCallback#onLost} is called, for example in case a
 * network is suddenly disconnected.
 *
 * <p>Do NOT call {@link #getNetworkCapabilities(android.net.Network)} or
 * {@link #getLinkProperties(android.net.Network)} or other synchronous ConnectivityManager methods in
 * this callback as this is prone to race conditions ; calling these methods while in a
 * callback may return an outdated or even a null object.
 *
 * @param network The {@link android.net.Network Network} that is about to be lost.
 * This value must never be {@code null}.
 * @param maxMsToLive The time in milliseconds the system intends to keep the network
 *                    connected for graceful handover; note that the network may still
 *                    suffer a hard loss at any time.
 * @apiSince 21
 */

public void onLosing(@androidx.annotation.NonNull android.net.Network network, int maxMsToLive) { throw new RuntimeException("Stub!"); }

/**
 * Called when a network disconnects or otherwise no longer satisfies this request or
 * callback.
 *
 * <p>If the callback was registered with requestNetwork() or
 * registerDefaultNetworkCallback(), it will only be invoked against the last network
 * returned by onAvailable() when that network is lost and no other network satisfies
 * the criteria of the request.
 *
 * <p>If the callback was registered with registerNetworkCallback() it will be called for
 * each network which no longer satisfies the criteria of the callback.
 *
 * <p>Do NOT call {@link #getNetworkCapabilities(android.net.Network)} or
 * {@link #getLinkProperties(android.net.Network)} or other synchronous ConnectivityManager methods in
 * this callback as this is prone to race conditions ; calling these methods while in a
 * callback may return an outdated or even a null object.
 *
 * @param network The {@link android.net.Network Network} lost.
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public void onLost(@androidx.annotation.NonNull android.net.Network network) { throw new RuntimeException("Stub!"); }

/**
 * Called if no network is found within the timeout time specified in
 * {@link #requestNetwork(android.net.NetworkRequest,android.net.ConnectivityManager.NetworkCallback,int)} call or if the
 * requested network request cannot be fulfilled (whether or not a timeout was
 * specified). When this callback is invoked the associated
 * {@link android.net.NetworkRequest NetworkRequest} will have already been removed and released, as if
 * {@link #unregisterNetworkCallback(android.net.ConnectivityManager.NetworkCallback)} had been called.
 * @apiSince 26
 */

public void onUnavailable() { throw new RuntimeException("Stub!"); }

/**
 * Called when the network corresponding to this request changes capabilities but still
 * satisfies the requested criteria.
 *
 * <p>Starting with {@link android.os.Build.VERSION_CODES#O} this method is guaranteed
 * to be called immediately after {@link #onAvailable}.
 *
 * <p>Do NOT call {@link #getLinkProperties(android.net.Network)} or other synchronous
 * ConnectivityManager methods in this callback as this is prone to race conditions :
 * calling these methods while in a callback may return an outdated or even a null object.
 *
 * @param network The {@link android.net.Network Network} whose capabilities have changed.
 * This value must never be {@code null}.
 * @param networkCapabilities The new {@link android.net.NetworkCapabilities} for this
 *                            network.
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public void onCapabilitiesChanged(@androidx.annotation.NonNull android.net.Network network, @androidx.annotation.NonNull android.net.NetworkCapabilities networkCapabilities) { throw new RuntimeException("Stub!"); }

/**
 * Called when the network corresponding to this request changes {@link android.net.LinkProperties LinkProperties}.
 *
 * <p>Starting with {@link android.os.Build.VERSION_CODES#O} this method is guaranteed
 * to be called immediately after {@link #onAvailable}.
 *
 * <p>Do NOT call {@link #getNetworkCapabilities(android.net.Network)} or other synchronous
 * ConnectivityManager methods in this callback as this is prone to race conditions :
 * calling these methods while in a callback may return an outdated or even a null object.
 *
 * @param network The {@link android.net.Network Network} whose link properties have changed.
 * This value must never be {@code null}.
 * @param linkProperties The new {@link android.net.LinkProperties LinkProperties} for this network.
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public void onLinkPropertiesChanged(@androidx.annotation.NonNull android.net.Network network, @androidx.annotation.NonNull android.net.LinkProperties linkProperties) { throw new RuntimeException("Stub!"); }

/**
 * Called when access to the specified network is blocked or unblocked.
 *
 * <p>Do NOT call {@link #getNetworkCapabilities(android.net.Network)} or
 * {@link #getLinkProperties(android.net.Network)} or other synchronous ConnectivityManager methods in
 * this callback as this is prone to race conditions : calling these methods while in a
 * callback may return an outdated or even a null object.
 *
 * @param network The {@link android.net.Network Network} whose blocked status has changed.
 * This value must never be {@code null}.
 * @param blocked The blocked status of this {@link android.net.Network Network}.
 * @apiSince 29
 */

public void onBlockedStatusChanged(@androidx.annotation.NonNull android.net.Network network, boolean blocked) { throw new RuntimeException("Stub!"); }
}

/**
 * Callback for use with {@link android.net.ConnectivityManager#addDefaultNetworkActiveListener ConnectivityManager#addDefaultNetworkActiveListener}
 * to find out when the system default network has gone in to a high power state.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnNetworkActiveListener {

/**
 * Called on the main thread of the process to report that the current data network
 * has become active, and it is now a good time to perform any pending network
 * operations.  Note that this listener only tells you when the network becomes
 * active; if at any other time you want to know whether it is active (and thus okay
 * to initiate network traffic), you can retrieve its instantaneous state with
 * {@link android.net.ConnectivityManager#isDefaultNetworkActive ConnectivityManager#isDefaultNetworkActive}.
 * @apiSince 21
 */

public void onNetworkActive();
}

}

