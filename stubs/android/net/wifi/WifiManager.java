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


package android.net.wifi;

import android.net.ConnectivityManager;
import android.os.Build;
import android.content.Context;
import java.util.List;
import android.net.wifi.hotspot2.PasspointConfiguration;
import android.net.Network;
import android.os.Handler;
import java.net.InetAddress;

/**
 * This class provides the primary API for managing all aspects of Wi-Fi
 * connectivity.
 * <p>
 * On releases before {@link android.os.Build.VERSION_CODES#N}, this object
 * should only be obtained from an {@linkplain android.content.Context#getApplicationContext() Context#getApplicationContext()}, and not from any other derived context to avoid memory
 * leaks within the calling process.
 * <p>
 * It deals with several categories of items:
 * </p>
 * <ul>
 * <li>The list of configured networks. The list can be viewed and updated, and
 * attributes of individual entries can be modified.</li>
 * <li>The currently active Wi-Fi network, if any. Connectivity can be
 * established or torn down, and dynamic information about the state of the
 * network can be queried.</li>
 * <li>Results of access point scans, containing enough information to make
 * decisions about what access point to connect to.</li>
 * <li>It defines the names of various Intent actions that are broadcast upon
 * any sort of change in Wi-Fi state.
 * </ul>
 * <p>
 * This is the API to use when performing Wi-Fi specific operations. To perform
 * operations that pertain to network connectivity at an abstract level, use
 * {@link android.net.ConnectivityManager}.
 * </p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class WifiManager {

WifiManager() { throw new RuntimeException("Stub!"); }

/**
 * Return a list of all the networks configured for the current foreground
 * user.
 *
 * Not all fields of WifiConfiguration are returned. Only the following
 * fields are filled in:
 * <ul>
 * <li>networkId</li>
 * <li>SSID</li>
 * <li>BSSID</li>
 * <li>priority</li>
 * <li>allowedProtocols</li>
 * <li>allowedKeyManagement</li>
 * <li>allowedAuthAlgorithms</li>
 * <li>allowedPairwiseCiphers</li>
 * <li>allowedGroupCiphers</li>
 * <li>status</li>
 * </ul>
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_FINE_LOCATION} and {@link android.Manifest.permission#ACCESS_WIFI_STATE}
 * @return a list of network configurations in the form of a list
 * of {@link android.net.wifi.WifiConfiguration WifiConfiguration} objects.
 *
 * @deprecated
 * a) See {@link android.net.wifi.WifiNetworkSpecifier.Builder#build() WifiNetworkSpecifier.Builder#build()} for new
 * mechanism to trigger connection to a Wi-Fi network.
 * b) See {@link #addNetworkSuggestions(java.util.List)},
 * {@link #removeNetworkSuggestions(java.util.List)} for new API to add Wi-Fi networks for consideration
 * when auto-connecting to wifi.
 * <b>Compatibility Note:</b> For applications targeting
 * {@link android.os.Build.VERSION_CODES#Q} or above, this API will return an empty list,
 * except for:
 * <ul>
 * <li>Device Owner (DO) & Profile Owner (PO) apps will have access to the full list.
 * <li>Callers with Carrier privilege will receive a restricted list only containing
 * configurations which they created.
 * </ul>
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public java.util.List<android.net.wifi.WifiConfiguration> getConfiguredNetworks() { throw new RuntimeException("Stub!"); }

/**
 * Add a new network description to the set of configured networks.
 * The {@code networkId} field of the supplied configuration object
 * is ignored.
 * <p/>
 * The new network will be marked DISABLED by default. To enable it,
 * called {@link #enableNetwork}.
 *
 * @param config the set of variables that describe the configuration,
 *            contained in a {@link android.net.wifi.WifiConfiguration WifiConfiguration} object.
 *            If the {@link android.net.wifi.WifiConfiguration WifiConfiguration} has an Http Proxy set
 *            the calling app must be System, or be provisioned as the Profile or Device Owner.
 * @return the ID of the newly created network description. This is used in
 *         other operations to specified the network to be acted upon.
 *         Returns {@code -1} on failure.
 *
 * @deprecated
 * a) See {@link android.net.wifi.WifiNetworkSpecifier.Builder#build() WifiNetworkSpecifier.Builder#build()} for new
 * mechanism to trigger connection to a Wi-Fi network.
 * b) See {@link #addNetworkSuggestions(java.util.List)},
 * {@link #removeNetworkSuggestions(java.util.List)} for new API to add Wi-Fi networks for consideration
 * when auto-connecting to wifi.
 * <b>Compatibility Note:</b> For applications targeting
 * {@link android.os.Build.VERSION_CODES#Q} or above, this API will always return {@code -1}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public int addNetwork(android.net.wifi.WifiConfiguration config) { throw new RuntimeException("Stub!"); }

/**
 * Update the network description of an existing configured network.
 *
 * @param config the set of variables that describe the configuration,
 *            contained in a {@link android.net.wifi.WifiConfiguration WifiConfiguration} object. It may
 *            be sparse, so that only the items that are being changed
 *            are non-<code>null</code>. The {@code networkId} field
 *            must be set to the ID of the existing network being updated.
 *            If the {@link android.net.wifi.WifiConfiguration WifiConfiguration} has an Http Proxy set
 *            the calling app must be System, or be provisioned as the Profile or Device Owner.
 * @return Returns the {@code networkId} of the supplied
 *         {@code WifiConfiguration} on success.
 *         <br/>
 *         Returns {@code -1} on failure, including when the {@code networkId}
 *         field of the {@code WifiConfiguration} does not refer to an
 *         existing network.
 *
 * @deprecated
 * a) See {@link android.net.wifi.WifiNetworkSpecifier.Builder#build() WifiNetworkSpecifier.Builder#build()} for new
 * mechanism to trigger connection to a Wi-Fi network.
 * b) See {@link #addNetworkSuggestions(java.util.List)},
 * {@link #removeNetworkSuggestions(java.util.List)} for new API to add Wi-Fi networks for consideration
 * when auto-connecting to wifi.
 * <b>Compatibility Note:</b> For applications targeting
 * {@link android.os.Build.VERSION_CODES#Q} or above, this API will always return {@code -1}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public int updateNetwork(android.net.wifi.WifiConfiguration config) { throw new RuntimeException("Stub!"); }

/**
 * Provide a list of network suggestions to the device. See {@link android.net.wifi.WifiNetworkSuggestion WifiNetworkSuggestion}
 * for a detailed explanation of the parameters.
 * When the device decides to connect to one of the provided network suggestions, platform sends
 * a directed broadcast {@link #ACTION_WIFI_NETWORK_SUGGESTION_POST_CONNECTION} to the app if
 * the network was created with {@link android.net.wifi.WifiNetworkSuggestion.Builder WifiNetworkSuggestion.Builder} flag set and the app holds
 * {@link android.Manifest.permission#ACCESS_FINE_LOCATION ACCESS_FINE_LOCATION} permission.
 *<p>
 * NOTE:
 * <li> These networks are just a suggestion to the platform. The platform will ultimately
 * decide on which network the device connects to. </li>
 * <li> When an app is uninstalled, all its suggested networks are discarded. If the device is
 * currently connected to a suggested network which is being removed then the device will
 * disconnect from that network.</li>
 * <li> No in-place modification of existing suggestions are allowed. Apps are expected to
 * remove suggestions using {@link #removeNetworkSuggestions(java.util.List)} and then add the modified
 * suggestion back using this API.</li>
 *
 * <br>
 * Requires {@link android.Manifest.permission#CHANGE_WIFI_STATE}
 * @param networkSuggestions List of network suggestions provided by the app.
 * This value must never be {@code null}.
 * @return Status code for the operation. One of the STATUS_NETWORK_SUGGESTIONS_ values.
 * {@link android.net.wifi.WifiNetworkSuggestion#equals(java.lang.Object) WifiNetworkSuggestion#equals(Object)} any previously provided suggestions by the app.
 * Value is {@link android.net.wifi.WifiManager#STATUS_NETWORK_SUGGESTIONS_SUCCESS}, {@link android.net.wifi.WifiManager#STATUS_NETWORK_SUGGESTIONS_ERROR_INTERNAL}, {@link android.net.wifi.WifiManager#STATUS_NETWORK_SUGGESTIONS_ERROR_APP_DISALLOWED}, {@link android.net.wifi.WifiManager#STATUS_NETWORK_SUGGESTIONS_ERROR_ADD_DUPLICATE}, {@link android.net.wifi.WifiManager#STATUS_NETWORK_SUGGESTIONS_ERROR_ADD_EXCEEDS_MAX_PER_APP}, or {@link android.net.wifi.WifiManager#STATUS_NETWORK_SUGGESTIONS_ERROR_REMOVE_INVALID}
 * @throws {@link java.lang.SecurityException SecurityException} if the caller is missing required permissions.
 * @apiSince 29
 */

public int addNetworkSuggestions(@androidx.annotation.NonNull java.util.List<android.net.wifi.WifiNetworkSuggestion> networkSuggestions) { throw new RuntimeException("Stub!"); }

/**
 * Remove some or all of the network suggestions that were previously provided by the app.
 * See {@link android.net.wifi.WifiNetworkSuggestion WifiNetworkSuggestion} for a detailed explanation of the parameters.
 * See {@link android.net.wifi.WifiNetworkSuggestion#equals(java.lang.Object) WifiNetworkSuggestion#equals(Object)} for the equivalence evaluation used.
 *
 * <br>
 * Requires {@link android.Manifest.permission#CHANGE_WIFI_STATE}
 * @param networkSuggestions List of network suggestions to be removed. Pass an empty list
 *                           to remove all the previous suggestions provided by the app.
 * This value must never be {@code null}.
 * @return Status code for the operation. One of the STATUS_NETWORK_SUGGESTIONS_ values.
 * Any matching suggestions are removed from the device and will not be considered for any
 * further connection attempts.
 
 * Value is {@link android.net.wifi.WifiManager#STATUS_NETWORK_SUGGESTIONS_SUCCESS}, {@link android.net.wifi.WifiManager#STATUS_NETWORK_SUGGESTIONS_ERROR_INTERNAL}, {@link android.net.wifi.WifiManager#STATUS_NETWORK_SUGGESTIONS_ERROR_APP_DISALLOWED}, {@link android.net.wifi.WifiManager#STATUS_NETWORK_SUGGESTIONS_ERROR_ADD_DUPLICATE}, {@link android.net.wifi.WifiManager#STATUS_NETWORK_SUGGESTIONS_ERROR_ADD_EXCEEDS_MAX_PER_APP}, or {@link android.net.wifi.WifiManager#STATUS_NETWORK_SUGGESTIONS_ERROR_REMOVE_INVALID}
 * @apiSince 29
 */

public int removeNetworkSuggestions(@androidx.annotation.NonNull java.util.List<android.net.wifi.WifiNetworkSuggestion> networkSuggestions) { throw new RuntimeException("Stub!"); }

/**
 * Returns the max number of network suggestions that are allowed per app on the device.
 * @see #addNetworkSuggestions(List)
 * @see #removeNetworkSuggestions(List)
 * @apiSince 29
 */

public int getMaxNumberOfNetworkSuggestionsPerApp() { throw new RuntimeException("Stub!"); }

/**
 * Add or update a Passpoint configuration.  The configuration provides a credential
 * for connecting to Passpoint networks that are operated by the Passpoint
 * service provider specified in the configuration.
 *
 * Each configuration is uniquely identified by its FQDN (Fully Qualified Domain
 * Name).  In the case when there is an existing configuration with the same
 * FQDN, the new configuration will replace the existing configuration.
 *
 * @param config The Passpoint configuration to be added
 * @throws java.lang.IllegalArgumentException if configuration is invalid or Passpoint is not enabled on
 *                                  the device.
 * @apiSince 26
 */

public void addOrUpdatePasspointConfiguration(android.net.wifi.hotspot2.PasspointConfiguration config) { throw new RuntimeException("Stub!"); }

/**
 * Remove the Passpoint configuration identified by its FQDN (Fully Qualified Domain Name).
 *
 * <br>
 * Requires android.Manifest.permission.NETWORK_SETTINGS
 * @param fqdn The FQDN of the Passpoint configuration to be removed
 * @throws java.lang.IllegalArgumentException if no configuration is associated with the given FQDN or
 *                                  Passpoint is not enabled on the device.
 * @deprecated This is no longer supported.
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated
public void removePasspointConfiguration(java.lang.String fqdn) { throw new RuntimeException("Stub!"); }

/**
 * Return the list of installed Passpoint configurations.
 *
 * An empty list will be returned when no configurations are installed.
 *
 * <br>
 * Requires android.Manifest.permission.NETWORK_SETTINGS or android.Manifest.permission.NETWORK_SETUP_WIZARD
 * @return A list of {@link android.net.wifi.hotspot2.PasspointConfiguration PasspointConfiguration}
 * @deprecated This is no longer supported.
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated
public java.util.List<android.net.wifi.hotspot2.PasspointConfiguration> getPasspointConfigurations() { throw new RuntimeException("Stub!"); }

/**
 * Remove the specified network from the list of configured networks.
 * This may result in the asynchronous delivery of state change
 * events.
 *
 * Applications are not allowed to remove networks created by other
 * applications.
 *
 * @param netId the ID of the network as returned by {@link #addNetwork} or {@link
 *        #getConfiguredNetworks}.
 * @return {@code true} if the operation succeeded
 *
 * @deprecated
 * a) See {@link android.net.wifi.WifiNetworkSpecifier.Builder#build() WifiNetworkSpecifier.Builder#build()} for new
 * mechanism to trigger connection to a Wi-Fi network.
 * b) See {@link #addNetworkSuggestions(java.util.List)},
 * {@link #removeNetworkSuggestions(java.util.List)} for new API to add Wi-Fi networks for consideration
 * when auto-connecting to wifi.
 * <b>Compatibility Note:</b> For applications targeting
 * {@link android.os.Build.VERSION_CODES#Q} or above, this API will always return false.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public boolean removeNetwork(int netId) { throw new RuntimeException("Stub!"); }

/**
 * Allow a previously configured network to be associated with. If
 * <code>attemptConnect</code> is true, an attempt to connect to the selected
 * network is initiated. This may result in the asynchronous delivery
 * of state change events.
 * <p>
 * <b>Note:</b> Network communication may not use Wi-Fi even if Wi-Fi is connected;
 * traffic may instead be sent through another network, such as cellular data,
 * Bluetooth tethering, or Ethernet. For example, traffic will never use a
 * Wi-Fi network that does not provide Internet access (e.g. a wireless
 * printer), if another network that does offer Internet access (e.g.
 * cellular data) is available. Applications that need to ensure that their
 * network traffic uses Wi-Fi should use APIs such as
 * {@link android.net.Network#bindSocket(java.net.Socket) Network#bindSocket(java.net.Socket)},
 * {@link android.net.Network#openConnection(java.net.URL) Network#openConnection(java.net.URL)}, or
 * {@link android.net.ConnectivityManager#bindProcessToNetwork ConnectivityManager#bindProcessToNetwork} to do so.
 *
 * Applications are not allowed to enable networks created by other
 * applications.
 *
 * @param netId the ID of the network as returned by {@link #addNetwork} or {@link
 *        #getConfiguredNetworks}.
 * @param attemptConnect The way to select a particular network to connect to is specify
 *        {@code true} for this parameter.
 * @return {@code true} if the operation succeeded
 *
 * @deprecated
 * a) See {@link android.net.wifi.WifiNetworkSpecifier.Builder#build() WifiNetworkSpecifier.Builder#build()} for new
 * mechanism to trigger connection to a Wi-Fi network.
 * b) See {@link #addNetworkSuggestions(java.util.List)},
 * {@link #removeNetworkSuggestions(java.util.List)} for new API to add Wi-Fi networks for consideration
 * when auto-connecting to wifi.
 * <b>Compatibility Note:</b> For applications targeting
 * {@link android.os.Build.VERSION_CODES#Q} or above, this API will always return false.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public boolean enableNetwork(int netId, boolean attemptConnect) { throw new RuntimeException("Stub!"); }

/**
 * Disable a configured network. The specified network will not be
 * a candidate for associating. This may result in the asynchronous
 * delivery of state change events.
 *
 * Applications are not allowed to disable networks created by other
 * applications.
 *
 * @param netId the ID of the network as returned by {@link #addNetwork} or {@link
 *        #getConfiguredNetworks}.
 * @return {@code true} if the operation succeeded
 *
 * @deprecated
 * a) See {@link android.net.wifi.WifiNetworkSpecifier.Builder#build() WifiNetworkSpecifier.Builder#build()} for new
 * mechanism to trigger connection to a Wi-Fi network.
 * b) See {@link #addNetworkSuggestions(java.util.List)},
 * {@link #removeNetworkSuggestions(java.util.List)} for new API to add Wi-Fi networks for consideration
 * when auto-connecting to wifi.
 * <b>Compatibility Note:</b> For applications targeting
 * {@link android.os.Build.VERSION_CODES#Q} or above, this API will always return false.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public boolean disableNetwork(int netId) { throw new RuntimeException("Stub!"); }

/**
 * Disassociate from the currently active access point. This may result
 * in the asynchronous delivery of state change events.
 * @return {@code true} if the operation succeeded
 *
 * @deprecated
 * a) See {@link android.net.wifi.WifiNetworkSpecifier.Builder#build() WifiNetworkSpecifier.Builder#build()} for new
 * mechanism to trigger connection to a Wi-Fi network.
 * b) See {@link #addNetworkSuggestions(java.util.List)},
 * {@link #removeNetworkSuggestions(java.util.List)} for new API to add Wi-Fi networks for consideration
 * when auto-connecting to wifi.
 * <b>Compatibility Note:</b> For applications targeting
 * {@link android.os.Build.VERSION_CODES#Q} or above, this API will always return false.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public boolean disconnect() { throw new RuntimeException("Stub!"); }

/**
 * Reconnect to the currently active access point, if we are currently
 * disconnected. This may result in the asynchronous delivery of state
 * change events.
 * @return {@code true} if the operation succeeded
 *
 * @deprecated
 * a) See {@link android.net.wifi.WifiNetworkSpecifier.Builder#build() WifiNetworkSpecifier.Builder#build()} for new
 * mechanism to trigger connection to a Wi-Fi network.
 * b) See {@link #addNetworkSuggestions(java.util.List)},
 * {@link #removeNetworkSuggestions(java.util.List)} for new API to add Wi-Fi networks for consideration
 * when auto-connecting to wifi.
 * <b>Compatibility Note:</b> For applications targeting
 * {@link android.os.Build.VERSION_CODES#Q} or above, this API will always return false.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public boolean reconnect() { throw new RuntimeException("Stub!"); }

/**
 * Reconnect to the currently active access point, even if we are already
 * connected. This may result in the asynchronous delivery of state
 * change events.
 * @return {@code true} if the operation succeeded
 *
 * @deprecated
 * a) See {@link android.net.wifi.WifiNetworkSpecifier.Builder#build() WifiNetworkSpecifier.Builder#build()} for new
 * mechanism to trigger connection to a Wi-Fi network.
 * b) See {@link #addNetworkSuggestions(java.util.List)},
 * {@link #removeNetworkSuggestions(java.util.List)} for new API to add Wi-Fi networks for consideration
 * when auto-connecting to wifi.
 * <b>Compatibility Note:</b> For applications targeting
 * {@link android.os.Build.VERSION_CODES#Q} or above, this API will always return false.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public boolean reassociate() { throw new RuntimeException("Stub!"); }

/**
 * Check that the supplicant daemon is responding to requests.
 * @return {@code true} if we were able to communicate with the supplicant and
 * it returned the expected response to the PING message.
 * @deprecated Will return the output of {@link #isWifiEnabled()} instead.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public boolean pingSupplicant() { throw new RuntimeException("Stub!"); }

/**
 * @return true if this adapter supports 5 GHz band
 * @apiSince 21
 */

public boolean is5GHzBandSupported() { throw new RuntimeException("Stub!"); }

/**
 * @return true if this adapter supports WifiP2pManager (Wi-Fi Direct)
 * @apiSince 21
 */

public boolean isP2pSupported() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Please use {@link android.content.pm.PackageManager#hasSystemFeature(String)}
 * with {@link android.content.pm.PackageManager#FEATURE_WIFI_RTT}.
 *
 * @return true if this adapter supports Device-to-AP RTT
 * @apiSince 21
 * @deprecatedSince 29
 */

@Deprecated
public boolean isDeviceToApRttSupported() { throw new RuntimeException("Stub!"); }

/**
 * @return true if this adapter supports offloaded connectivity scan
 * @apiSince 21
 */

public boolean isPreferredNetworkOffloadSupported() { throw new RuntimeException("Stub!"); }

/**
 * @return true if this adapter supports Tunnel Directed Link Setup
 * @apiSince 21
 */

public boolean isTdlsSupported() { throw new RuntimeException("Stub!"); }

/**
 * @return true if this adapter supports advanced power/performance counters
 * @apiSince 21
 */

public boolean isEnhancedPowerReportingSupported() { throw new RuntimeException("Stub!"); }

/**
 * Request a scan for access points. Returns immediately. The availability
 * of the results is made known later by means of an asynchronous event sent
 * on completion of the scan.
 * <p>
 * To initiate a Wi-Fi scan, declare the
 * {@link android.Manifest.permission#CHANGE_WIFI_STATE}
 * permission in the manifest, and perform these steps:
 * </p>
 * <ol style="1">
 * <li>Invoke the following method:
 * {@code ((WifiManager) getSystemService(WIFI_SERVICE)).startScan()}</li>
 * <li>
 * Register a BroadcastReceiver to listen to
 * {@code SCAN_RESULTS_AVAILABLE_ACTION}.</li>
 * <li>When a broadcast is received, call:
 * {@code ((WifiManager) getSystemService(WIFI_SERVICE)).getScanResults()}</li>
 * </ol>
 * @return {@code true} if the operation succeeded, i.e., the scan was initiated.
 * @deprecated The ability for apps to trigger scan requests will be removed in a future
 * release.
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated
public boolean startScan() { throw new RuntimeException("Stub!"); }

/**
 * Return dynamic information about the current Wi-Fi connection, if any is active.
 * <p>
 * In the connected state, access to the SSID and BSSID requires
 * the same permissions as {@link #getScanResults}. If such access is not allowed,
 * {@link android.net.wifi.WifiInfo#getSSID WifiInfo#getSSID} will return {@link #UNKNOWN_SSID} and
 * {@link android.net.wifi.WifiInfo#getBSSID WifiInfo#getBSSID} will return {@code "02:00:00:00:00:00"}.
 *
 * @return the Wi-Fi information, contained in {@link android.net.wifi.WifiInfo WifiInfo}.
 * @apiSince 1
 */

public android.net.wifi.WifiInfo getConnectionInfo() { throw new RuntimeException("Stub!"); }

/**
 * Return the results of the latest access point scan.
 * @return the list of access points found in the most recent scan. An app must hold
 * {@link android.Manifest.permission#ACCESS_FINE_LOCATION ACCESS_FINE_LOCATION} permission
 * in order to get valid results.
 * @apiSince 1
 */

public java.util.List<android.net.wifi.ScanResult> getScanResults() { throw new RuntimeException("Stub!"); }

/**
 * Check if scanning is always available.
 *
 * If this return {@code true}, apps can issue {@link #startScan} and fetch scan results
 * even when Wi-Fi is turned off.
 *
 * To change this setting, see {@link #ACTION_REQUEST_SCAN_ALWAYS_AVAILABLE}.
 * @deprecated The ability for apps to trigger scan requests will be removed in a future
 * release.
 * @apiSince 18
 * @deprecatedSince 29
 */

@Deprecated
public boolean isScanAlwaysAvailable() { throw new RuntimeException("Stub!"); }

/**
 * Tell the device to persist the current list of configured networks.
 * <p>
 * Note: It is possible for this method to change the network IDs of
 * existing networks. You should assume the network IDs can be different
 * after calling this method.
 *
 * @return {@code false}.
 * @deprecated There is no need to call this method -
 * {@link #addNetwork(android.net.wifi.WifiConfiguration)}, {@link #updateNetwork(android.net.wifi.WifiConfiguration)}
 * and {@link #removeNetwork(int)} already persist the configurations automatically.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public boolean saveConfiguration() { throw new RuntimeException("Stub!"); }

/**
 * Return the DHCP-assigned addresses from the last successful DHCP request,
 * if any.
 * @return the DHCP information
 * @apiSince 1
 */

public android.net.DhcpInfo getDhcpInfo() { throw new RuntimeException("Stub!"); }

/**
 * Enable or disable Wi-Fi.
 * <p>
 * Applications must have the {@link android.Manifest.permission#CHANGE_WIFI_STATE}
 * permission to toggle wifi.
 *
 * @param enabled {@code true} to enable, {@code false} to disable.
 * @return {@code false} if the request cannot be satisfied; {@code true} indicates that wifi is
 *         either already in the requested state, or in progress toward the requested state.
 * @throws  {@link java.lang.SecurityException} if the caller is missing required permissions.
 *
 * @deprecated Starting with Build.VERSION_CODES#Q, applications are not allowed to
 * enable/disable Wi-Fi.
 * <b>Compatibility Note:</b> For applications targeting
 * {@link android.os.Build.VERSION_CODES#Q} or above, this API will always return {@code false}
 * and will have no effect. If apps are targeting an older SDK (
 * {@link android.os.Build.VERSION_CODES#P} or below), they can continue to use this API.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public boolean setWifiEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Gets the Wi-Fi enabled state.
 * @return One of {@link #WIFI_STATE_DISABLED},
 *         {@link #WIFI_STATE_DISABLING}, {@link #WIFI_STATE_ENABLED},
 *         {@link #WIFI_STATE_ENABLING}, {@link #WIFI_STATE_UNKNOWN}
 * @see #isWifiEnabled()
 * @apiSince 1
 */

public int getWifiState() { throw new RuntimeException("Stub!"); }

/**
 * Return whether Wi-Fi is enabled or disabled.
 * @return {@code true} if Wi-Fi is enabled
 * @see #getWifiState()
 * @apiSince 1
 */

public boolean isWifiEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Calculates the level of the signal. This should be used any time a signal
 * is being shown.
 *
 * @param rssi The power of the signal measured in RSSI.
 * @param numLevels The number of levels to consider in the calculated
 *            level.
 * @return A level of the signal, given in the range of 0 to numLevels-1
 *         (both inclusive).
 * @apiSince 1
 */

public static int calculateSignalLevel(int rssi, int numLevels) { throw new RuntimeException("Stub!"); }

/**
 * Compares two signal strengths.
 *
 * @param rssiA The power of the first signal measured in RSSI.
 * @param rssiB The power of the second signal measured in RSSI.
 * @return Returns <0 if the first signal is weaker than the second signal,
 *         0 if the two signals have the same strength, and >0 if the first
 *         signal is stronger than the second signal.
 * @apiSince 1
 */

public static int compareSignalLevel(int rssiA, int rssiB) { throw new RuntimeException("Stub!"); }

/**
 * Request a local only hotspot that an application can use to communicate between co-located
 * devices connected to the created WiFi hotspot.  The network created by this method will not
 * have Internet access.  Each application can make a single request for the hotspot, but
 * multiple applications could be requesting the hotspot at the same time.  When multiple
 * applications have successfully registered concurrently, they will be sharing the underlying
 * hotspot. {@link android.net.wifi.WifiManager.LocalOnlyHotspotCallback#onStarted(android.net.wifi.WifiManager.LocalOnlyHotspotReservation) LocalOnlyHotspotCallback#onStarted(LocalOnlyHotspotReservation)} is called
 * when the hotspot is ready for use by the application.
 * <p>
 * Each application can make a single active call to this method. The {@link android.net.wifi.WifiManager.LocalOnlyHotspotCallback#onStarted(android.net.wifi.WifiManager.LocalOnlyHotspotReservation) LocalOnlyHotspotCallback#onStarted(LocalOnlyHotspotReservation)} callback supplies the
 * requestor with a {@link android.net.wifi.WifiManager.LocalOnlyHotspotReservation LocalOnlyHotspotReservation} that contains a
 * {@link android.net.wifi.WifiConfiguration WifiConfiguration} with the SSID, security type and credentials needed to connect
 * to the hotspot.  Communicating this information is up to the application.
 * <p>
 * If the LocalOnlyHotspot cannot be created, the {@link android.net.wifi.WifiManager.LocalOnlyHotspotCallback#onFailed(int) LocalOnlyHotspotCallback#onFailed(int)}
 * method will be called. Example failures include errors bringing up the network or if
 * there is an incompatible operating mode.  For example, if the user is currently using Wifi
 * Tethering to provide an upstream to another device, LocalOnlyHotspot will not start due to
 * an incompatible mode. The possible error codes include:
 * {@link android.net.wifi.WifiManager.LocalOnlyHotspotCallback#ERROR_NO_CHANNEL LocalOnlyHotspotCallback#ERROR_NO_CHANNEL},
 * {@link android.net.wifi.WifiManager.LocalOnlyHotspotCallback#ERROR_GENERIC LocalOnlyHotspotCallback#ERROR_GENERIC},
 * {@link android.net.wifi.WifiManager.LocalOnlyHotspotCallback#ERROR_INCOMPATIBLE_MODE LocalOnlyHotspotCallback#ERROR_INCOMPATIBLE_MODE} and
 * {@link android.net.wifi.WifiManager.LocalOnlyHotspotCallback#ERROR_TETHERING_DISALLOWED LocalOnlyHotspotCallback#ERROR_TETHERING_DISALLOWED}.
 * <p>
 * Internally, requests will be tracked to prevent the hotspot from being torn down while apps
 * are still using it.  The {@link android.net.wifi.WifiManager.LocalOnlyHotspotReservation LocalOnlyHotspotReservation} object passed in the  {@link android.net.wifi.WifiManager.LocalOnlyHotspotCallback#onStarted(android.net.wifi.WifiManager.LocalOnlyHotspotReservation) LocalOnlyHotspotCallback#onStarted(LocalOnlyHotspotReservation)} call should be closed when
 * the LocalOnlyHotspot is no longer needed using {@link android.net.wifi.WifiManager.LocalOnlyHotspotReservation#close() LocalOnlyHotspotReservation#close()}.
 * Since the hotspot may be shared among multiple applications, removing the final registered
 * application request will trigger the hotspot teardown.  This means that applications should
 * not listen to broadcasts containing wifi state to determine if the hotspot was stopped after
 * they are done using it. Additionally, once {@link android.net.wifi.WifiManager.LocalOnlyHotspotReservation#close() LocalOnlyHotspotReservation#close()} is
 * called, applications will not receive callbacks of any kind.
 * <p>
 * Applications should be aware that the user may also stop the LocalOnlyHotspot through the
 * Settings UI; it is not guaranteed to stay up as long as there is a requesting application.
 * The requestors will be notified of this case via
 * {@link android.net.wifi.WifiManager.LocalOnlyHotspotCallback#onStopped() LocalOnlyHotspotCallback#onStopped()}.  Other cases may arise where the hotspot is
 * torn down (Emergency mode, etc).  Application developers should be aware that it can stop
 * unexpectedly, but they will receive a notification if they have properly registered.
 * <p>
 * Applications should also be aware that this network will be shared with other applications.
 * Applications are responsible for protecting their data on this network (e.g., TLS).
 * <p>
 * Applications need to have the following permissions to start LocalOnlyHotspot: {@link
 * android.Manifest.permission#CHANGE_WIFI_STATE} and {@link
 * android.Manifest.permission#ACCESS_FINE_LOCATION ACCESS_FINE_LOCATION}.  Callers without
 * the permissions will trigger a {@link java.lang.SecurityException}.
 * <p>
 * @param callback LocalOnlyHotspotCallback for the application to receive updates about
 * operating status.
 * @param handler Handler to be used for callbacks.  If the caller passes a null Handler, the
 * main thread will be used.
 
 * This value may be {@code null}.
 * @apiSince 26
 */

public void startLocalOnlyHotspot(android.net.wifi.WifiManager.LocalOnlyHotspotCallback callback, @androidx.annotation.Nullable android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Enable/Disable TDLS on a specific local route.
 *
 * <p>
 * TDLS enables two wireless endpoints to talk to each other directly
 * without going through the access point that is managing the local
 * network. It saves bandwidth and improves quality of the link.
 * </p>
 * <p>
 * This API enables/disables the option of using TDLS. If enabled, the
 * underlying hardware is free to use TDLS or a hop through the access
 * point. If disabled, existing TDLS session is torn down and
 * hardware is restricted to use access point for transferring wireless
 * packets. Default value for all routes is 'disabled', meaning restricted
 * to use access point for transferring packets.
 * </p>
 *
 * @param remoteIPAddress IP address of the endpoint to setup TDLS with
 * @param enable true = setup and false = tear down TDLS
 * @apiSince 19
 */

public void setTdlsEnabled(java.net.InetAddress remoteIPAddress, boolean enable) { throw new RuntimeException("Stub!"); }

/**
 * Similar to {@link #setTdlsEnabled(java.net.InetAddress,boolean) }, except
 * this version allows you to specify remote endpoint with a MAC address.
 * @param remoteMacAddress MAC address of the remote endpoint such as 00:00:0c:9f:f2:ab
 * @param enable true = setup and false = tear down TDLS
 * @apiSince 19
 */

public void setTdlsEnabledWithMacAddress(java.lang.String remoteMacAddress, boolean enable) { throw new RuntimeException("Stub!"); }

/**
 * WPS suport has been deprecated from Client mode and this method will immediately trigger
 * {@link android.net.wifi.WifiManager.WpsCallback#onFailed(int) WpsCallback#onFailed(int)} with a generic error.
 *
 * @param config WPS configuration (does not support {@link android.net.wifi.WpsInfo#LABEL WpsInfo#LABEL})
 * @param listener for callbacks on success or failure. Can be null.
 * @throws java.lang.IllegalStateException if the WifiManager instance needs to be initialized again
 * @deprecated This API is deprecated
 * @apiSince 21
 * @deprecatedSince 28
 */

@Deprecated
public void startWps(android.net.wifi.WpsInfo config, android.net.wifi.WifiManager.WpsCallback listener) { throw new RuntimeException("Stub!"); }

/**
 * WPS support has been deprecated from Client mode and this method will immediately trigger
 * {@link android.net.wifi.WifiManager.WpsCallback#onFailed(int) WpsCallback#onFailed(int)} with a generic error.
 *
 * @param listener for callbacks on success or failure. Can be null.
 * @throws java.lang.IllegalStateException if the WifiManager instance needs to be initialized again
 * @deprecated This API is deprecated
 * @apiSince 21
 * @deprecatedSince 28
 */

@Deprecated
public void cancelWps(android.net.wifi.WifiManager.WpsCallback listener) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new WifiLock.
 *
 * @param lockType the type of lock to create. See {@link #WIFI_MODE_FULL_HIGH_PERF}
 * and {@link #WIFI_MODE_FULL_LOW_LATENCY} for descriptions of the types of Wi-Fi locks.
 * @param tag a tag for the WifiLock to identify it in debugging messages.  This string is
 *            never shown to the user under normal conditions, but should be descriptive
 *            enough to identify your application and the specific WifiLock within it, if it
 *            holds multiple WifiLocks.
 *
 * @return a new, unacquired WifiLock with the given tag.
 *
 * @see android.net.wifi.WifiManager.WifiLock
 * @apiSince 3
 */

public android.net.wifi.WifiManager.WifiLock createWifiLock(int lockType, java.lang.String tag) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new WifiLock.
 *
 * @param tag a tag for the WifiLock to identify it in debugging messages.  This string is
 *            never shown to the user under normal conditions, but should be descriptive
 *            enough to identify your application and the specific WifiLock within it, if it
 *            holds multiple WifiLocks.
 *
 * @return a new, unacquired WifiLock with the given tag.
 *
 * @see android.net.wifi.WifiManager.WifiLock
 *
 * @deprecated This API is non-functional.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public android.net.wifi.WifiManager.WifiLock createWifiLock(java.lang.String tag) { throw new RuntimeException("Stub!"); }

/**
 * Create a new MulticastLock
 *
 * @param tag a tag for the MulticastLock to identify it in debugging
 *            messages.  This string is never shown to the user under
 *            normal conditions, but should be descriptive enough to
 *            identify your application and the specific MulticastLock
 *            within it, if it holds multiple MulticastLocks.
 *
 * @return a new, unacquired MulticastLock with the given tag.
 *
 * @see android.net.wifi.WifiManager.MulticastLock
 * @apiSince 4
 */

public android.net.wifi.WifiManager.MulticastLock createMulticastLock(java.lang.String tag) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * @return true if this device supports WPA3-Personal SAE
 * @apiSince 29
 */

public boolean isWpa3SaeSupported() { throw new RuntimeException("Stub!"); }

/**
 * @return true if this device supports WPA3-Enterprise Suite-B-192
 * @apiSince 29
 */

public boolean isWpa3SuiteBSupported() { throw new RuntimeException("Stub!"); }

/**
 * @return true if this device supports Wi-Fi Enhanced Open (OWE)
 * @apiSince 29
 */

public boolean isEnhancedOpenSupported() { throw new RuntimeException("Stub!"); }

/**
 * Wi-Fi Easy Connect (DPP) introduces standardized mechanisms to simplify the provisioning and
 * configuration of Wi-Fi devices.
 * For more details, visit <a href="https://www.wi-fi.org/">https://www.wi-fi.org/</a> and
 * search for "Easy Connect" or "Device Provisioning Protocol specification".
 *
 * @return true if this device supports Wi-Fi Easy-connect (Device Provisioning Protocol)
 * @apiSince 29
 */

public boolean isEasyConnectSupported() { throw new RuntimeException("Stub!"); }

/**
 * Activity Action: Pick a Wi-Fi network to connect to.
 * <p>Input: Nothing.
 * <p>Output: Nothing.
 * @apiSince 1
 */

public static final java.lang.String ACTION_PICK_WIFI_NETWORK = "android.net.wifi.PICK_WIFI_NETWORK";

/**
 * Activity Action: Show a system activity that allows the user to enable
 * scans to be available even with Wi-Fi turned off.
 *
 * <p>Notification of the result of this activity is posted using the
 * {@link android.app.Activity#onActivityResult} callback. The
 * <code>resultCode</code>
 * will be {@link android.app.Activity#RESULT_OK} if scan always mode has
 * been turned on or {@link android.app.Activity#RESULT_CANCELED} if the user
 * has rejected the request or an error has occurred.
 * @apiSince 18
 */

public static final java.lang.String ACTION_REQUEST_SCAN_ALWAYS_AVAILABLE = "android.net.wifi.action.REQUEST_SCAN_ALWAYS_AVAILABLE";

/**
 * Directed broadcast intent action indicating that the device has connected to one of the
 * network suggestions provided by the app. This will be sent post connection to a network
 * which was created with {@link android.net.wifi.WifiNetworkSuggestion.Builder#setIsAppInteractionRequired(boolean) WifiNetworkSuggestion.Builder#setIsAppInteractionRequired(
 * boolean)}
 * flag set.
 * <p>
 * Note: The broadcast is sent to the app only if it holds
 * {@link android.Manifest.permission#ACCESS_FINE_LOCATION ACCESS_FINE_LOCATION} permission.
 *
 * @see #EXTRA_NETWORK_SUGGESTION
 * @apiSince 29
 */

public static final java.lang.String ACTION_WIFI_NETWORK_SUGGESTION_POST_CONNECTION = "android.net.wifi.action.WIFI_NETWORK_SUGGESTION_POST_CONNECTION";

/**
 * The error code if there was a problem authenticating.
 * @deprecated This is no longer supported.
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated public static final int ERROR_AUTHENTICATING = 1; // 0x1

/**
 * The lookup key for a String giving the BSSID of the access point to which
 * we are connected. No longer used.
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated public static final java.lang.String EXTRA_BSSID = "bssid";

/**
 * The lookup key for a {@link android.net.NetworkInfo} object associated with the
 * Wi-Fi network. Retrieve with
 * {@link android.content.Intent#getParcelableExtra(String)}.
 * @apiSince 1
 */

public static final java.lang.String EXTRA_NETWORK_INFO = "networkInfo";

/**
 * Sent as as a part of {@link #ACTION_WIFI_NETWORK_SUGGESTION_POST_CONNECTION} that holds
 * an instance of {@link android.net.wifi.WifiNetworkSuggestion WifiNetworkSuggestion} corresponding to the connected network.
 * @apiSince 29
 */

public static final java.lang.String EXTRA_NETWORK_SUGGESTION = "android.net.wifi.extra.NETWORK_SUGGESTION";

/**
 * The lookup key for an {@code int} giving the new RSSI in dBm.
 * @apiSince 1
 */

public static final java.lang.String EXTRA_NEW_RSSI = "newRssi";

/**
 * The lookup key for a {@link android.net.wifi.SupplicantState SupplicantState} describing the new state
 * Retrieve with
 * {@link android.content.Intent#getParcelableExtra(String)}.
 * @deprecated This is no longer supported.
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated public static final java.lang.String EXTRA_NEW_STATE = "newState";

/**
 * The previous Wi-Fi state.
 *
 * @see #EXTRA_WIFI_STATE
 * @apiSince 1
 */

public static final java.lang.String EXTRA_PREVIOUS_WIFI_STATE = "previous_wifi_state";

/**
 * Lookup key for a {@code boolean} extra in intent {@link #SCAN_RESULTS_AVAILABLE_ACTION}
 * representing if the scan was successful or not.
 * Scans may fail for multiple reasons, these may include:
 * <ol>
 * <li>An app requested too many scans in a certain period of time.
 * This may lead to additional scan request rejections via "scan throttling" for both
 * foreground and background apps.
 * Note: Apps holding android.Manifest.permission.NETWORK_SETTINGS permission are
 * exempted from scan throttling.
 * </li>
 * <li>The device is idle and scanning is disabled.</li>
 * <li>Wifi hardware reported a scan failure.</li>
 * </ol>
 * @return true scan was successful, results are updated
 * @return false scan was not successful, results haven't been updated since previous scan
 * @apiSince 23
 */

public static final java.lang.String EXTRA_RESULTS_UPDATED = "resultsUpdated";

/**
 * The lookup key for a boolean that indicates whether a connection to
 * the supplicant daemon has been gained or lost. {@code true} means
 * a connection now exists.
 * Retrieve it with {@link android.content.Intent#getBooleanExtra(String,boolean)}.
 * @deprecated This is no longer supported.
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated public static final java.lang.String EXTRA_SUPPLICANT_CONNECTED = "connected";

/**
 * The lookup key for a {@link android.net.wifi.SupplicantState SupplicantState} describing the supplicant
 * error code if any
 * Retrieve with
 * {@link android.content.Intent#getIntExtra(String, int)}.
 * @see #ERROR_AUTHENTICATING
 * @deprecated This is no longer supported.
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated public static final java.lang.String EXTRA_SUPPLICANT_ERROR = "supplicantError";

/**
 * The lookup key for a {@link android.net.wifi.WifiInfo} object giving the
 * information about the access point to which we are connected.
 * No longer used.
 * @apiSince 14
 * @deprecatedSince 28
 */

@Deprecated public static final java.lang.String EXTRA_WIFI_INFO = "wifiInfo";

/**
 * The lookup key for an int that indicates whether Wi-Fi is enabled,
 * disabled, enabling, disabling, or unknown.  Retrieve it with
 * {@link android.content.Intent#getIntExtra(String,int)}.
 *
 * @see #WIFI_STATE_DISABLED
 * @see #WIFI_STATE_DISABLING
 * @see #WIFI_STATE_ENABLED
 * @see #WIFI_STATE_ENABLING
 * @see #WIFI_STATE_UNKNOWN
 * @apiSince 1
 */

public static final java.lang.String EXTRA_WIFI_STATE = "wifi_state";

/**
 * The network IDs of the configured networks could have changed.
 * @apiSince 1
 */

public static final java.lang.String NETWORK_IDS_CHANGED_ACTION = "android.net.wifi.NETWORK_IDS_CHANGED";

/**
 * Broadcast intent action indicating that the state of Wi-Fi connectivity
 * has changed. An extra provides the new state
 * in the form of a {@link android.net.NetworkInfo} object.
 * @see #EXTRA_NETWORK_INFO
 * @apiSince 1
 */

public static final java.lang.String NETWORK_STATE_CHANGED_ACTION = "android.net.wifi.STATE_CHANGE";

/**
 * The RSSI (signal strength) has changed.
 *
 * Receiver Required Permission: android.Manifest.permission.ACCESS_WIFI_STATE
 * @see {@link #EXTRA_NEW_RSSI}
 * @apiSince 1
 */

public static final java.lang.String RSSI_CHANGED_ACTION = "android.net.wifi.RSSI_CHANGED";

/**
 * An access point scan has completed, and results are available.
 * Call {@link #getScanResults()} to obtain the results.
 * The broadcast intent may contain an extra field with the key {@link #EXTRA_RESULTS_UPDATED}
 * and a {@code boolean} value indicating if the scan was successful.
 * @apiSince 1
 */

public static final java.lang.String SCAN_RESULTS_AVAILABLE_ACTION = "android.net.wifi.SCAN_RESULTS";

/**
 * Reason code if one or more of the network suggestions added already exists in platform's
 * database.
 * @see android.net.wifi.WifiNetworkSuggestion#equals(Object)
 * @apiSince 29
 */

public static final int STATUS_NETWORK_SUGGESTIONS_ERROR_ADD_DUPLICATE = 3; // 0x3

/**
 * Reason code if the number of network suggestions provided by the app crosses the max
 * threshold set per app.
 * @see #getMaxNumberOfNetworkSuggestionsPerApp()
 * @apiSince 29
 */

public static final int STATUS_NETWORK_SUGGESTIONS_ERROR_ADD_EXCEEDS_MAX_PER_APP = 4; // 0x4

/**
 * Reason code if the user has disallowed "android:change_wifi_state" app-ops from the app.
 * @see android.app.AppOpsManager#unsafeCheckOp(String, int, String).
 * @apiSince 29
 */

public static final int STATUS_NETWORK_SUGGESTIONS_ERROR_APP_DISALLOWED = 2; // 0x2

/**
 * Reason code if there was an internal error in the platform while processing the addition or
 * removal of suggestions.
 * @apiSince 29
 */

public static final int STATUS_NETWORK_SUGGESTIONS_ERROR_INTERNAL = 1; // 0x1

/**
 * Reason code if one or more of the network suggestions removed does not exist in platform's
 * database.
 * @apiSince 29
 */

public static final int STATUS_NETWORK_SUGGESTIONS_ERROR_REMOVE_INVALID = 5; // 0x5

/**
 * Reason code if all of the network suggestions were successfully added or removed.
 * @apiSince 29
 */

public static final int STATUS_NETWORK_SUGGESTIONS_SUCCESS = 0; // 0x0

/**
 * Broadcast intent action indicating that a connection to the supplicant has
 * been established (and it is now possible
 * to perform Wi-Fi operations) or the connection to the supplicant has been
 * lost. One extra provides the connection state as a boolean, where {@code true}
 * means CONNECTED.
 * @deprecated This is no longer supported.
 * @see #EXTRA_SUPPLICANT_CONNECTED
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated public static final java.lang.String SUPPLICANT_CONNECTION_CHANGE_ACTION = "android.net.wifi.supplicant.CONNECTION_CHANGE";

/**
 * Broadcast intent action indicating that the state of establishing a connection to
 * an access point has changed.One extra provides the new
 * {@link android.net.wifi.SupplicantState SupplicantState}. Note that the supplicant state is Wi-Fi specific, and
 * is not generally the most useful thing to look at if you are just interested in
 * the overall state of connectivity.
 * @see #EXTRA_NEW_STATE
 * @see #EXTRA_SUPPLICANT_ERROR
 * @deprecated This is no longer supported.
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated public static final java.lang.String SUPPLICANT_STATE_CHANGED_ACTION = "android.net.wifi.supplicant.STATE_CHANGE";

/**
 * Indicates an invalid SSID.
 * @apiSince R
 */

public static final java.lang.String UNKNOWN_SSID = "<unknown ssid>";

/**
 * In this Wi-Fi lock mode, Wi-Fi will be kept active,
 * and will behave normally, i.e., it will attempt to automatically
 * establish a connection to a remembered access point that is
 * within range, and will do periodic scans if there are remembered
 * access points but none are in range.
 *
 * @deprecated This API is non-functional and will have no impact.
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public static final int WIFI_MODE_FULL = 1; // 0x1

/**
 * In this Wi-Fi lock mode, Wi-Fi will not go to power save.
 * This results in operating with low packet latency.
 * The lock is only active when the device is connected to an access point.
 * The lock is active even when the device screen is off or the acquiring application is
 * running in the background.
 * This mode will consume more power and hence should be used only
 * when there is a need for this tradeoff.
 * <p>
 * An example use case is when a voice connection needs to be
 * kept active even after the device screen goes off.
 * Holding a {@link #WIFI_MODE_FULL_HIGH_PERF} lock for the
 * duration of the voice call may improve the call quality.
 * <p>
 * When there is no support from the hardware, the {@link #WIFI_MODE_FULL_HIGH_PERF}
 * lock will have no impact.
 * @apiSince 12
 */

public static final int WIFI_MODE_FULL_HIGH_PERF = 3; // 0x3

/**
 * In this Wi-Fi lock mode, Wi-Fi will operate with a priority to achieve low latency.
 * {@link #WIFI_MODE_FULL_LOW_LATENCY} lock has the following limitations:
 * <ol>
 * <li>The lock is only active when the device is connected to an access point.</li>
 * <li>The lock is only active when the screen is on.</li>
 * <li>The lock is only active when the acquiring app is running in the foreground.</li>
 * </ol>
 * Low latency mode optimizes for reduced packet latency,
 * and as a result other performance measures may suffer when there are trade-offs to make:
 * <ol>
 * <li>Battery life may be reduced.</li>
 * <li>Throughput may be reduced.</li>
 * <li>Frequency of Wi-Fi scanning may be reduced. This may result in: </li>
 * <ul>
 * <li>The device may not roam or switch to the AP with highest signal quality.</li>
 * <li>Location accuracy may be reduced.</li>
 * </ul>
 * </ol>
 * <p>
 * Example use cases are real time gaming or virtual reality applications where
 * low latency is a key factor for user experience.
 * <p>
 * Note: For an app which acquires both {@link #WIFI_MODE_FULL_LOW_LATENCY} and
 * {@link #WIFI_MODE_FULL_HIGH_PERF} locks, {@link #WIFI_MODE_FULL_LOW_LATENCY}
 * lock will be effective when app is running in foreground and screen is on,
 * while the {@link #WIFI_MODE_FULL_HIGH_PERF} lock will take effect otherwise.
 * @apiSince 29
 */

public static final int WIFI_MODE_FULL_LOW_LATENCY = 4; // 0x4

/**
 * In this Wi-Fi lock mode, Wi-Fi will be kept active,
 * but the only operation that will be supported is initiation of
 * scans, and the subsequent reporting of scan results. No attempts
 * will be made to automatically connect to remembered access points,
 * nor will periodic scans be automatically performed looking for
 * remembered access points. Scans must be explicitly requested by
 * an application in this mode.
 *
 * @deprecated This API is non-functional and will have no impact.
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public static final int WIFI_MODE_SCAN_ONLY = 2; // 0x2

/**
 * Broadcast intent action indicating that Wi-Fi has been enabled, disabled,
 * enabling, disabling, or unknown. One extra provides this state as an int.
 * Another extra provides the previous state, if available.
 *
 * @see #EXTRA_WIFI_STATE
 * @see #EXTRA_PREVIOUS_WIFI_STATE
 * @apiSince 1
 */

public static final java.lang.String WIFI_STATE_CHANGED_ACTION = "android.net.wifi.WIFI_STATE_CHANGED";

/**
 * Wi-Fi is disabled.
 *
 * @see #WIFI_STATE_CHANGED_ACTION
 * @see #getWifiState()
 * @apiSince 1
 */

public static final int WIFI_STATE_DISABLED = 1; // 0x1

/**
 * Wi-Fi is currently being disabled. The state will change to {@link #WIFI_STATE_DISABLED} if
 * it finishes successfully.
 *
 * @see #WIFI_STATE_CHANGED_ACTION
 * @see #getWifiState()
 * @apiSince 1
 */

public static final int WIFI_STATE_DISABLING = 0; // 0x0

/**
 * Wi-Fi is enabled.
 *
 * @see #WIFI_STATE_CHANGED_ACTION
 * @see #getWifiState()
 * @apiSince 1
 */

public static final int WIFI_STATE_ENABLED = 3; // 0x3

/**
 * Wi-Fi is currently being enabled. The state will change to {@link #WIFI_STATE_ENABLED} if
 * it finishes successfully.
 *
 * @see #WIFI_STATE_CHANGED_ACTION
 * @see #getWifiState()
 * @apiSince 1
 */

public static final int WIFI_STATE_ENABLING = 2; // 0x2

/**
 * Wi-Fi is in an unknown state. This state will occur when an error happens while enabling
 * or disabling.
 *
 * @see #WIFI_STATE_CHANGED_ACTION
 * @see #getWifiState()
 * @apiSince 1
 */

public static final int WIFI_STATE_UNKNOWN = 4; // 0x4

/** Authentication failure on WPS
 * @deprecated This is deprecated
 * @apiSince 21
 * @deprecatedSince 28
 */

@Deprecated public static final int WPS_AUTH_FAILURE = 6; // 0x6

/** WPS overlap detected
 * @deprecated This is deprecated
 * @apiSince 21
 * @deprecatedSince 28
 */

@Deprecated public static final int WPS_OVERLAP_ERROR = 3; // 0x3

/** WPS timed out
 * @deprecated This is deprecated
 * @apiSince 21
 * @deprecatedSince 28
 */

@Deprecated public static final int WPS_TIMED_OUT = 7; // 0x7

/** TKIP only prohibited
 * @deprecated This is deprecated
 * @apiSince 21
 * @deprecatedSince 28
 */

@Deprecated public static final int WPS_TKIP_ONLY_PROHIBITED = 5; // 0x5

/** WEP on WPS is prohibited
 * @deprecated This is deprecated
 * @apiSince 21
 * @deprecatedSince 28
 */

@Deprecated public static final int WPS_WEP_PROHIBITED = 4; // 0x4
/**
 * Callback class for applications to receive updates about the LocalOnlyHotspot status.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class LocalOnlyHotspotCallback {

public LocalOnlyHotspotCallback() { throw new RuntimeException("Stub!"); }

/**
 * LocalOnlyHotspot start succeeded.
 * @apiSince 26
 */

public void onStarted(android.net.wifi.WifiManager.LocalOnlyHotspotReservation reservation) { throw new RuntimeException("Stub!"); }

/**
 * LocalOnlyHotspot stopped.
 * <p>
 * The LocalOnlyHotspot can be disabled at any time by the user.  When this happens,
 * applications will be notified that it was stopped. This will not be invoked when an
 * application calls {@link android.net.wifi.WifiManager.LocalOnlyHotspotReservation#close() LocalOnlyHotspotReservation#close()}.
 * @apiSince 26
 */

public void onStopped() { throw new RuntimeException("Stub!"); }

/**
 * LocalOnlyHotspot failed to start.
 * <p>
 * Applications can attempt to call
 * {@link android.net.wifi.WifiManager#startLocalOnlyHotspot(android.net.wifi.WifiManager.LocalOnlyHotspotCallback,android.os.Handler) WifiManager#startLocalOnlyHotspot(LocalOnlyHotspotCallback, Handler)} again at
 * a later time.
 * <p>
 * @param reason The reason for failure could be one of: {@link
 * #ERROR_TETHERING_DISALLOWED}, {@link #ERROR_INCOMPATIBLE_MODE},
 * {@link #ERROR_NO_CHANNEL}, or {@link #ERROR_GENERIC}.
 * @apiSince 26
 */

public void onFailed(int reason) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public static final int ERROR_GENERIC = 2; // 0x2

/** @apiSince 26 */

public static final int ERROR_INCOMPATIBLE_MODE = 3; // 0x3

/** @apiSince 26 */

public static final int ERROR_NO_CHANNEL = 1; // 0x1

/** @apiSince 26 */

public static final int ERROR_TETHERING_DISALLOWED = 4; // 0x4
}

/**
 * LocalOnlyHotspotReservation that contains the {@link android.net.wifi.WifiConfiguration WifiConfiguration} for the active
 * LocalOnlyHotspot request.
 * <p>
 * Applications requesting LocalOnlyHotspot for sharing will receive an instance of the
 * LocalOnlyHotspotReservation in the
 * {@link android.net.wifi.WifiManager.LocalOnlyHotspotCallback#onStarted(android.net.wifi.WifiManager.LocalOnlyHotspotReservation) LocalOnlyHotspotCallback#onStarted(LocalOnlyHotspotReservation)} call.  This
 * reservation contains the relevant {@link android.net.wifi.WifiConfiguration WifiConfiguration}.
 * When an application is done with the LocalOnlyHotspot, they should call {@link android.net.wifi.WifiManager.LocalOnlyHotspotReservation#close() LocalOnlyHotspotReservation#close()}.  Once this happens, the application will not receive
 * any further callbacks. If the LocalOnlyHotspot is stopped due to a
 * user triggered mode change, applications will be notified via the {@link android.net.wifi.WifiManager.LocalOnlyHotspotCallback#onStopped() LocalOnlyHotspotCallback#onStopped()} callback.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class LocalOnlyHotspotReservation implements java.lang.AutoCloseable {

LocalOnlyHotspotReservation() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public android.net.wifi.WifiConfiguration getWifiConfiguration() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void close() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }
}

/**
 * Allows an application to receive Wifi Multicast packets.
 * Normally the Wifi stack filters out packets not explicitly
 * addressed to this device.  Acquring a MulticastLock will
 * cause the stack to receive packets addressed to multicast
 * addresses.  Processing these extra packets can cause a noticeable
 * battery drain and should be disabled when not needed.
 * @apiSince 4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MulticastLock {

private MulticastLock() { throw new RuntimeException("Stub!"); }

/**
 * Locks Wifi Multicast on until {@link #release} is called.
 *
 * If this MulticastLock is reference-counted each call to
 * {@code acquire} will increment the reference count, and the
 * wifi interface will receive multicast packets as long as the
 * reference count is above zero.
 *
 * If this MulticastLock is not reference-counted, the first call to
 * {@code acquire} will turn on the multicast packets, but subsequent
 * calls will be ignored.  Only one call to {@link #release} will
 * be required, regardless of the number of times that {@code acquire}
 * is called.
 *
 * Note that other applications may also lock Wifi Multicast on.
 * Only they can relinquish their lock.
 *
 * Also note that applications cannot leave Multicast locked on.
 * When an app exits or crashes, any Multicast locks will be released.
 * @apiSince 4
 */

public void acquire() { throw new RuntimeException("Stub!"); }

/**
 * Unlocks Wifi Multicast, restoring the filter of packets
 * not addressed specifically to this device and saving power.
 *
 * If this MulticastLock is reference-counted, each call to
 * {@code release} will decrement the reference count, and the
 * multicast packets will only stop being received when the reference
 * count reaches zero.  If the reference count goes below zero (that
 * is, if {@code release} is called a greater number of times than
 * {@link #acquire}), an exception is thrown.
 *
 * If this MulticastLock is not reference-counted, the first call to
 * {@code release} (after the radio was multicast locked using
 * {@link #acquire}) will unlock the multicast, and subsequent calls
 * will be ignored.
 *
 * Note that if any other Wifi Multicast Locks are still outstanding
 * this {@code release} call will not have an immediate effect.  Only
 * when all applications have released all their Multicast Locks will
 * the Multicast filter be turned back on.
 *
 * Also note that when an app exits or crashes all of its Multicast
 * Locks will be automatically released.
 * @apiSince 4
 */

public void release() { throw new RuntimeException("Stub!"); }

/**
 * Controls whether this is a reference-counted or non-reference-
 * counted MulticastLock.
 *
 * Reference-counted MulticastLocks keep track of the number of calls
 * to {@link #acquire} and {@link #release}, and only stop the
 * reception of multicast packets when every call to {@link #acquire}
 * has been balanced with a call to {@link #release}.  Non-reference-
 * counted MulticastLocks allow the reception of multicast packets
 * whenever {@link #acquire} is called and stop accepting multicast
 * packets whenever {@link #release} is called.
 *
 * @param refCounted true if this MulticastLock should keep a reference
 * count
 * @apiSince 4
 */

public void setReferenceCounted(boolean refCounted) { throw new RuntimeException("Stub!"); }

/**
 * Checks whether this MulticastLock is currently held.
 *
 * @return true if this MulticastLock is held, false otherwise
 * @apiSince 4
 */

public boolean isHeld() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }
}

/**
 * Allows an application to keep the Wi-Fi radio awake.
 * Normally the Wi-Fi radio may turn off when the user has not used the device in a while.
 * Acquiring a WifiLock will keep the radio on until the lock is released.  Multiple
 * applications may hold WifiLocks, and the radio will only be allowed to turn off when no
 * WifiLocks are held in any application.
 * <p>
 * Before using a WifiLock, consider carefully if your application requires Wi-Fi access, or
 * could function over a mobile network, if available.  A program that needs to download large
 * files should hold a WifiLock to ensure that the download will complete, but a program whose
 * network usage is occasional or low-bandwidth should not hold a WifiLock to avoid adversely
 * affecting battery life.
 * <p>
 * Note that WifiLocks cannot override the user-level "Wi-Fi Enabled" setting, nor Airplane
 * Mode.  They simply keep the radio from turning off when Wi-Fi is already on but the device
 * is idle.
 * <p>
 * Any application using a WifiLock must request the {@code android.permission.WAKE_LOCK}
 * permission in an {@code <uses-permission>} element of the application's manifest.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class WifiLock {

private WifiLock() { throw new RuntimeException("Stub!"); }

/**
 * Locks the Wi-Fi radio on until {@link #release} is called.
 *
 * If this WifiLock is reference-counted, each call to {@code acquire} will increment the
 * reference count, and the radio will remain locked as long as the reference count is
 * above zero.
 *
 * If this WifiLock is not reference-counted, the first call to {@code acquire} will lock
 * the radio, but subsequent calls will be ignored.  Only one call to {@link #release}
 * will be required, regardless of the number of times that {@code acquire} is called.
 * @apiSince 1
 */

public void acquire() { throw new RuntimeException("Stub!"); }

/**
 * Unlocks the Wi-Fi radio, allowing it to turn off when the device is idle.
 *
 * If this WifiLock is reference-counted, each call to {@code release} will decrement the
 * reference count, and the radio will be unlocked only when the reference count reaches
 * zero.  If the reference count goes below zero (that is, if {@code release} is called
 * a greater number of times than {@link #acquire}), an exception is thrown.
 *
 * If this WifiLock is not reference-counted, the first call to {@code release} (after
 * the radio was locked using {@link #acquire}) will unlock the radio, and subsequent
 * calls will be ignored.
 * @apiSince 1
 */

public void release() { throw new RuntimeException("Stub!"); }

/**
 * Controls whether this is a reference-counted or non-reference-counted WifiLock.
 *
 * Reference-counted WifiLocks keep track of the number of calls to {@link #acquire} and
 * {@link #release}, and only allow the radio to sleep when every call to {@link #acquire}
 * has been balanced with a call to {@link #release}.  Non-reference-counted WifiLocks
 * lock the radio whenever {@link #acquire} is called and it is unlocked, and unlock the
 * radio whenever {@link #release} is called and it is locked.
 *
 * @param refCounted true if this WifiLock should keep a reference count
 * @apiSince 1
 */

public void setReferenceCounted(boolean refCounted) { throw new RuntimeException("Stub!"); }

/**
 * Checks whether this WifiLock is currently held.
 *
 * @return true if this WifiLock is held, false otherwise
 * @apiSince 1
 */

public boolean isHeld() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public void setWorkSource(android.os.WorkSource ws) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }
}

/** Interface for callback invocation on a start WPS action
 * @deprecated This is deprecated
 * @apiSince 21
 * @deprecatedSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public abstract static class WpsCallback {

@Deprecated
public WpsCallback() { throw new RuntimeException("Stub!"); }

/** WPS start succeeded
 * @deprecated This API is deprecated
 * @apiSince 21
 * @deprecatedSince 28
 */

@Deprecated
public abstract void onStarted(java.lang.String pin);

/** WPS operation completed successfully
 * @deprecated This API is deprecated
 * @apiSince 21
 * @deprecatedSince 28
 */

@Deprecated
public abstract void onSucceeded();

/**
 * WPS operation failed
 * @param reason The reason for failure could be one of
 * {@link #WPS_TKIP_ONLY_PROHIBITED}, {@link #WPS_OVERLAP_ERROR},
 * {@link #WPS_WEP_PROHIBITED}, {@link #WPS_TIMED_OUT} or {@link #WPS_AUTH_FAILURE}
 * and some generic errors.
 * @deprecated This API is deprecated
 * @apiSince 21
 * @deprecatedSince 28
 */

@Deprecated
public abstract void onFailed(int reason);
}

}

