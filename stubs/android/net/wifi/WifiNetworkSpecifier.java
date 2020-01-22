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

import android.os.PatternMatcher;
import android.net.MacAddress;
import android.net.NetworkRequest;
import android.net.NetworkSpecifier;

/**
 * Network specifier object used to request a local Wi-Fi network. Apps should use the
 * {@link android.net.wifi.WifiNetworkSpecifier.Builder WifiNetworkSpecifier.Builder} class to create an instance.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class WifiNetworkSpecifier extends android.net.NetworkSpecifier implements android.os.Parcelable {

WifiNetworkSpecifier() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.net.wifi.WifiNetworkSpecifier> CREATOR;
static { CREATOR = null; }
/**
 * Builder used to create {@link android.net.wifi.WifiNetworkSpecifier WifiNetworkSpecifier} objects.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/** @apiSince 29 */

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Set the unicode SSID match pattern to use for filtering networks from scan results.
 * <p>
 * <li>Overrides any previous value set using {@link #setSsid(java.lang.String)} or
 * {@link #setSsidPattern(android.os.PatternMatcher)}.</li>
 *
 * @param ssidPattern Instance of {@link android.os.PatternMatcher PatternMatcher} containing the UTF-8 encoded
 *                    string pattern to use for matching the network's SSID.
 * This value must never be {@code null}.
 * @return Instance of {@link android.net.wifi.WifiNetworkSpecifier.Builder Builder} to enable chaining of the builder method.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.wifi.WifiNetworkSpecifier.Builder setSsidPattern(@androidx.annotation.NonNull android.os.PatternMatcher ssidPattern) { throw new RuntimeException("Stub!"); }

/**
 * Set the unicode SSID for the network.
 * <p>
 * <li>Sets the SSID to use for filtering networks from scan results. Will only match
 * networks whose SSID is identical to the UTF-8 encoding of the specified value.</li>
 * <li>Overrides any previous value set using {@link #setSsid(java.lang.String)} or
 * {@link #setSsidPattern(android.os.PatternMatcher)}.</li>
 *
 * @param ssid The SSID of the network. It must be valid Unicode.
 * This value must never be {@code null}.
 * @return Instance of {@link android.net.wifi.WifiNetworkSpecifier.Builder Builder} to enable chaining of the builder method.
 * This value will never be {@code null}.
 * @throws java.lang.IllegalArgumentException if the SSID is not valid unicode.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.wifi.WifiNetworkSpecifier.Builder setSsid(@androidx.annotation.NonNull java.lang.String ssid) { throw new RuntimeException("Stub!"); }

/**
 * Set the BSSID match pattern to use for filtering networks from scan results.
 * Will match all networks with BSSID which satisfies the following:
 * {@code BSSID & mask == baseAddress}.
 * <p>
 * <li>Overrides any previous value set using {@link #setBssid(android.net.MacAddress)} or
 * {@link #setBssidPattern(android.net.MacAddress,android.net.MacAddress)}.</li>
 *
 * @param baseAddress Base address for BSSID pattern.
 * This value must never be {@code null}.
 * @param mask Mask for BSSID pattern.
 * This value must never be {@code null}.
 * @return Instance of {@link android.net.wifi.WifiNetworkSpecifier.Builder Builder} to enable chaining of the builder method.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.wifi.WifiNetworkSpecifier.Builder setBssidPattern(@androidx.annotation.NonNull android.net.MacAddress baseAddress, @androidx.annotation.NonNull android.net.MacAddress mask) { throw new RuntimeException("Stub!"); }

/**
 * Set the BSSID to use for filtering networks from scan results. Will only match network
 * whose BSSID is identical to the specified value.
 * <p>
 * <li>Sets the BSSID to use for filtering networks from scan results. Will only match
 * networks whose BSSID is identical to specified value.</li>
 * <li>Overrides any previous value set using {@link #setBssid(android.net.MacAddress)} or
 * {@link #setBssidPattern(android.net.MacAddress,android.net.MacAddress)}.</li>
 *
 * @param bssid BSSID of the network.
 * This value must never be {@code null}.
 * @return Instance of {@link android.net.wifi.WifiNetworkSpecifier.Builder Builder} to enable chaining of the builder method.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.wifi.WifiNetworkSpecifier.Builder setBssid(@androidx.annotation.NonNull android.net.MacAddress bssid) { throw new RuntimeException("Stub!"); }

/**
 * Specifies whether this represents an Enhanced Open (OWE) network.
 *
 * @param isEnhancedOpen {@code true} to indicate that the network uses enhanced open,
 *                       {@code false} otherwise.
 * @return Instance of {@link android.net.wifi.WifiNetworkSpecifier.Builder Builder} to enable chaining of the builder method.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.wifi.WifiNetworkSpecifier.Builder setIsEnhancedOpen(boolean isEnhancedOpen) { throw new RuntimeException("Stub!"); }

/**
 * Set the ASCII WPA2 passphrase for this network. Needed for authenticating to
 * WPA2-PSK networks.
 *
 * @param passphrase passphrase of the network.
 * This value must never be {@code null}.
 * @return Instance of {@link android.net.wifi.WifiNetworkSpecifier.Builder Builder} to enable chaining of the builder method.
 * This value will never be {@code null}.
 * @throws java.lang.IllegalArgumentException if the passphrase is not ASCII encodable.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.wifi.WifiNetworkSpecifier.Builder setWpa2Passphrase(@androidx.annotation.NonNull java.lang.String passphrase) { throw new RuntimeException("Stub!"); }

/**
 * Set the ASCII WPA3 passphrase for this network. Needed for authenticating to WPA3-SAE
 * networks.
 *
 * @param passphrase passphrase of the network.
 * This value must never be {@code null}.
 * @return Instance of {@link android.net.wifi.WifiNetworkSpecifier.Builder Builder} to enable chaining of the builder method.
 * This value will never be {@code null}.
 * @throws java.lang.IllegalArgumentException if the passphrase is not ASCII encodable.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.wifi.WifiNetworkSpecifier.Builder setWpa3Passphrase(@androidx.annotation.NonNull java.lang.String passphrase) { throw new RuntimeException("Stub!"); }

/**
 * Set the associated enterprise configuration for this network. Needed for authenticating
 * to WPA2-EAP networks. See {@link android.net.wifi.WifiEnterpriseConfig WifiEnterpriseConfig} for description.
 *
 * @param enterpriseConfig Instance of {@link android.net.wifi.WifiEnterpriseConfig WifiEnterpriseConfig}.
 * This value must never be {@code null}.
 * @return Instance of {@link android.net.wifi.WifiNetworkSpecifier.Builder Builder} to enable chaining of the builder method.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.wifi.WifiNetworkSpecifier.Builder setWpa2EnterpriseConfig(@androidx.annotation.NonNull android.net.wifi.WifiEnterpriseConfig enterpriseConfig) { throw new RuntimeException("Stub!"); }

/**
 * Set the associated enterprise configuration for this network. Needed for authenticating
 * to WPA3-SuiteB networks. See {@link android.net.wifi.WifiEnterpriseConfig WifiEnterpriseConfig} for description.
 *
 * @param enterpriseConfig Instance of {@link android.net.wifi.WifiEnterpriseConfig WifiEnterpriseConfig}.
 * This value must never be {@code null}.
 * @return Instance of {@link android.net.wifi.WifiNetworkSpecifier.Builder Builder} to enable chaining of the builder method.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.wifi.WifiNetworkSpecifier.Builder setWpa3EnterpriseConfig(@androidx.annotation.NonNull android.net.wifi.WifiEnterpriseConfig enterpriseConfig) { throw new RuntimeException("Stub!"); }

/**
 * Specifies whether this represents a hidden network.
 * <p>
 * <li>Setting this disallows the usage of {@link #setSsidPattern(android.os.PatternMatcher)} since
 * hidden networks need to be explicitly probed for.</li>
 * <li>If not set, defaults to false (i.e not a hidden network).</li>
 *
 * @param isHiddenSsid {@code true} to indicate that the network is hidden, {@code false}
 *                     otherwise.
 * @return Instance of {@link android.net.wifi.WifiNetworkSpecifier.Builder Builder} to enable chaining of the builder method.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.wifi.WifiNetworkSpecifier.Builder setIsHiddenSsid(boolean isHiddenSsid) { throw new RuntimeException("Stub!"); }

/**
 * Create a specifier object used to request a local Wi-Fi network. The generated
 * {@link android.net.NetworkSpecifier NetworkSpecifier} should be used in
 * {@link android.net.NetworkRequest.Builder#setNetworkSpecifier(android.net.NetworkSpecifier) NetworkRequest.Builder#setNetworkSpecifier(NetworkSpecifier)} when building
 * the {@link android.net.NetworkRequest NetworkRequest}. These specifiers can only be used to request a local wifi
 * network (i.e no internet capability). So, the device will not switch it's default route
 * to wifi if there are other transports (cellular for example) available.
 *<p>
 * Note: Apps can set a combination of network match params:
 * <li> SSID Pattern using {@link #setSsidPattern(android.os.PatternMatcher)} OR Specific SSID using
 * {@link #setSsid(java.lang.String)}. </li>
 * AND/OR
 * <li> BSSID Pattern using {@link #setBssidPattern(android.net.MacAddress,android.net.MacAddress)} OR Specific
 * BSSID using {@link #setBssid(android.net.MacAddress)} </li>
 * to trigger connection to a network that matches the set params.
 * The system will find the set of networks matching the request and present the user
 * with a system dialog which will allow the user to select a specific Wi-Fi network to
 * connect to or to deny the request.
 *</p>
 *
 * For example:
 * To connect to an open network with a SSID prefix of "test" and a BSSID OUI of "10:03:23":
 * {@code
 * final NetworkSpecifier specifier =
 *      new Builder()
 *      .setSsidPattern(new PatternMatcher("test", PatterMatcher.PATTERN_PREFIX))
 *      .setBssidPattern(MacAddress.fromString("10:03:23:00:00:00"),
 *                       MacAddress.fromString("ff:ff:ff:00:00:00"))
 *      .build()
 * final NetworkRequest request =
 *      new NetworkRequest.Builder()
 *      .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
 *      .removeCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
 *      .setNetworkSpecifier(specifier)
 *      .build();
 * final ConnectivityManager connectivityManager =
 *      context.getSystemService(Context.CONNECTIVITY_SERVICE);
 * final NetworkCallback networkCallback = new NetworkCallback() {
 *      ...
 *      {@literal @}Override
 *      void onAvailable(...) {}
 *      // etc.
 * };
 * connectivityManager.requestNetwork(request, networkCallback);
 * }
 *
 * @return Instance of {@link android.net.NetworkSpecifier NetworkSpecifier}.
 * This value will never be {@code null}.
 * @throws java.lang.IllegalStateException on invalid params set.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.net.wifi.WifiNetworkSpecifier build() { throw new RuntimeException("Stub!"); }
}

}

