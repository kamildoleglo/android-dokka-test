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


package android.net.wifi;

import java.util.List;
import android.net.MacAddress;

/**
 * The Network Suggestion object is used to provide a Wi-Fi network for consideration when
 * auto-connecting to networks. Apps cannot directly create this object, they must use
 * {@link android.net.wifi.WifiNetworkSuggestion.Builder#build() WifiNetworkSuggestion.Builder#build()} to obtain an instance of this object.
 *<p>
 * Apps can provide a list of such networks to the platform using
 * {@link android.net.wifi.WifiManager#addNetworkSuggestions(java.util.List) WifiManager#addNetworkSuggestions(List)}.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class WifiNetworkSuggestion implements android.os.Parcelable {

WifiNetworkSuggestion() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Equals for network suggestions.
 * @apiSince 29
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.net.wifi.WifiNetworkSuggestion> CREATOR;
static { CREATOR = null; }
/**
 * Builder used to create {@link android.net.wifi.WifiNetworkSuggestion WifiNetworkSuggestion} objects.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/** @apiSince 29 */

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Set the unicode SSID for the network.
 * <p>
 * <li>Overrides any previous value set using {@link #setSsid(java.lang.String)}.</li>
 *
 * @param ssid The SSID of the network. It must be valid Unicode.
 * This value must never be {@code null}.
 * @return Instance of {@link android.net.wifi.WifiNetworkSuggestion.Builder Builder} to enable chaining of the builder method.
 * This value will never be {@code null}.
 * @throws java.lang.IllegalArgumentException if the SSID is not valid unicode.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.wifi.WifiNetworkSuggestion.Builder setSsid(@androidx.annotation.NonNull java.lang.String ssid) { throw new RuntimeException("Stub!"); }

/**
 * Set the BSSID to use for filtering networks from scan results. Will only match network
 * whose BSSID is identical to the specified value.
 * <p>
 * <li Sets a specific BSSID for the network suggestion. If set, only the specified BSSID
 * with the specified SSID will be considered for connection.
 * <li>If set, only the specified BSSID with the specified SSID will be considered for
 * connection.</li>
 * <li>If not set, all BSSIDs with the specified SSID will be considered for connection.
 * </li>
 * <li>Overrides any previous value set using {@link #setBssid(android.net.MacAddress)}.</li>
 *
 * @param bssid BSSID of the network.
 * This value must never be {@code null}.
 * @return Instance of {@link android.net.wifi.WifiNetworkSuggestion.Builder Builder} to enable chaining of the builder method.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.wifi.WifiNetworkSuggestion.Builder setBssid(@androidx.annotation.NonNull android.net.MacAddress bssid) { throw new RuntimeException("Stub!"); }

/**
 * Specifies whether this represents an Enhanced Open (OWE) network.
 *
 * @param isEnhancedOpen {@code true} to indicate that the network used enhanced open,
 *                       {@code false} otherwise.
 * @return Instance of {@link android.net.wifi.WifiNetworkSuggestion.Builder Builder} to enable chaining of the builder method.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.wifi.WifiNetworkSuggestion.Builder setIsEnhancedOpen(boolean isEnhancedOpen) { throw new RuntimeException("Stub!"); }

/**
 * Set the ASCII WPA2 passphrase for this network. Needed for authenticating to
 * WPA2-PSK networks.
 *
 * @param passphrase passphrase of the network.
 * This value must never be {@code null}.
 * @return Instance of {@link android.net.wifi.WifiNetworkSuggestion.Builder Builder} to enable chaining of the builder method.
 * This value will never be {@code null}.
 * @throws java.lang.IllegalArgumentException if the passphrase is not ASCII encodable.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.wifi.WifiNetworkSuggestion.Builder setWpa2Passphrase(@androidx.annotation.NonNull java.lang.String passphrase) { throw new RuntimeException("Stub!"); }

/**
 * Set the ASCII WPA3 passphrase for this network. Needed for authenticating to WPA3-SAE
 * networks.
 *
 * @param passphrase passphrase of the network.
 * This value must never be {@code null}.
 * @return Instance of {@link android.net.wifi.WifiNetworkSuggestion.Builder Builder} to enable chaining of the builder method.
 * This value will never be {@code null}.
 * @throws java.lang.IllegalArgumentException if the passphrase is not ASCII encodable.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.wifi.WifiNetworkSuggestion.Builder setWpa3Passphrase(@androidx.annotation.NonNull java.lang.String passphrase) { throw new RuntimeException("Stub!"); }

/**
 * Set the associated enterprise configuration for this network. Needed for authenticating
 * to WPA2-EAP networks. See {@link android.net.wifi.WifiEnterpriseConfig WifiEnterpriseConfig} for description.
 *
 * @param enterpriseConfig Instance of {@link android.net.wifi.WifiEnterpriseConfig WifiEnterpriseConfig}.
 * This value must never be {@code null}.
 * @return Instance of {@link android.net.wifi.WifiNetworkSuggestion.Builder Builder} to enable chaining of the builder method.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.wifi.WifiNetworkSuggestion.Builder setWpa2EnterpriseConfig(@androidx.annotation.NonNull android.net.wifi.WifiEnterpriseConfig enterpriseConfig) { throw new RuntimeException("Stub!"); }

/**
 * Set the associated enterprise configuration for this network. Needed for authenticating
 * to WPA3-SuiteB networks. See {@link android.net.wifi.WifiEnterpriseConfig WifiEnterpriseConfig} for description.
 *
 * @param enterpriseConfig Instance of {@link android.net.wifi.WifiEnterpriseConfig WifiEnterpriseConfig}.
 * This value must never be {@code null}.
 * @return Instance of {@link android.net.wifi.WifiNetworkSuggestion.Builder Builder} to enable chaining of the builder method.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.wifi.WifiNetworkSuggestion.Builder setWpa3EnterpriseConfig(@androidx.annotation.NonNull android.net.wifi.WifiEnterpriseConfig enterpriseConfig) { throw new RuntimeException("Stub!"); }

/**
 * Specifies whether this represents a hidden network.
 * <p>
 * <li>If not set, defaults to false (i.e not a hidden network).</li>
 *
 * @param isHiddenSsid {@code true} to indicate that the network is hidden, {@code false}
 *                     otherwise.
 * @return Instance of {@link android.net.wifi.WifiNetworkSuggestion.Builder Builder} to enable chaining of the builder method.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.wifi.WifiNetworkSuggestion.Builder setIsHiddenSsid(boolean isHiddenSsid) { throw new RuntimeException("Stub!"); }

/**
 * Specifies whether the app needs to log in to a captive portal to obtain Internet access.
 * <p>
 * This will dictate if the directed broadcast
 * {@link android.net.wifi.WifiManager#ACTION_WIFI_NETWORK_SUGGESTION_POST_CONNECTION WifiManager#ACTION_WIFI_NETWORK_SUGGESTION_POST_CONNECTION} will be sent to the
 * app after successfully connecting to the network.
 * Use this for captive portal type networks where the app needs to authenticate the user
 * before the device can access the network.
 * <p>
 * <li>If not set, defaults to false (i.e no app interaction required).</li>
 *
 * @param isAppInteractionRequired {@code true} to indicate that app interaction is
 *                                 required, {@code false} otherwise.
 * @return Instance of {@link android.net.wifi.WifiNetworkSuggestion.Builder Builder} to enable chaining of the builder method.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.wifi.WifiNetworkSuggestion.Builder setIsAppInteractionRequired(boolean isAppInteractionRequired) { throw new RuntimeException("Stub!"); }

/**
 * Specifies whether the user needs to log in to a captive portal to obtain Internet access.
 * <p>
 * <li>If not set, defaults to false (i.e no user interaction required).</li>
 *
 * @param isUserInteractionRequired {@code true} to indicate that user interaction is
 *                                  required, {@code false} otherwise.
 * @return Instance of {@link android.net.wifi.WifiNetworkSuggestion.Builder Builder} to enable chaining of the builder method.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.wifi.WifiNetworkSuggestion.Builder setIsUserInteractionRequired(boolean isUserInteractionRequired) { throw new RuntimeException("Stub!"); }

/**
 * Specify the priority of this network among other network suggestions provided by the same
 * app (priorities have no impact on suggestions by different apps). The higher the number,
 * the higher the priority (i.e value of 0 = lowest priority).
 * <p>
 * <li>If not set, defaults a lower priority than any assigned priority.</li>
 *
 * @param priority Integer number representing the priority among suggestions by the app.
 * Value is 0 or greater
 * @return Instance of {@link android.net.wifi.WifiNetworkSuggestion.Builder Builder} to enable chaining of the builder method.
 * This value will never be {@code null}.
 * @throws java.lang.IllegalArgumentException if the priority value is negative.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.wifi.WifiNetworkSuggestion.Builder setPriority(int priority) { throw new RuntimeException("Stub!"); }

/**
 * Specifies whether this network is metered.
 * <p>
 * <li>If not set, defaults to false (i.e not metered).</li>
 *
 * @param isMetered {@code true} to indicate that the network is metered, {@code false}
 *                  otherwise.
 * @return Instance of {@link android.net.wifi.WifiNetworkSuggestion.Builder Builder} to enable chaining of the builder method.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.wifi.WifiNetworkSuggestion.Builder setIsMetered(boolean isMetered) { throw new RuntimeException("Stub!"); }

/**
 * Create a network suggestion object for use in
 * {@link android.net.wifi.WifiManager#addNetworkSuggestions(java.util.List) WifiManager#addNetworkSuggestions(List)}.
 *
 *<p class="note">
 * <b>Note:</b> Apps can set a combination of SSID using {@link #setSsid(java.lang.String)} and BSSID
 * using {@link #setBssid(android.net.MacAddress)} to provide more fine grained network suggestions to
 * the platform.
 * </p>
 *
 * For example:
 * To provide credentials for one open, one WPA2 and one WPA3 network with their
 * corresponding SSID's:
 *
 * <pre>{@code
 * final WifiNetworkSuggestion suggestion1 =
 *      new Builder()
 *      .setSsid("test111111")
 *      .build()
 * final WifiNetworkSuggestion suggestion2 =
 *      new Builder()
 *      .setSsid("test222222")
 *      .setWpa2Passphrase("test123456")
 *      .build()
 * final WifiNetworkSuggestion suggestion3 =
 *      new Builder()
 *      .setSsid("test333333")
 *      .setWpa3Passphrase("test6789")
 *      .build()
 * final List<WifiNetworkSuggestion> suggestionsList =
 *      new ArrayList<WifiNetworkSuggestion> { {
 *          add(suggestion1);
 *          add(suggestion2);
 *          add(suggestion3);
 *      } };
 * final WifiManager wifiManager =
 *      context.getSystemService(Context.WIFI_SERVICE);
 * wifiManager.addNetworkSuggestions(suggestionsList);
 * // ...
 * }</pre>
 *
 * @return Instance of {@link android.net.wifi.WifiNetworkSuggestion WifiNetworkSuggestion}
 * This value will never be {@code null}.
 * @throws java.lang.IllegalStateException on invalid params set
 * @see android.net.wifi.WifiNetworkSuggestion
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.wifi.WifiNetworkSuggestion build() { throw new RuntimeException("Stub!"); }
}

}

