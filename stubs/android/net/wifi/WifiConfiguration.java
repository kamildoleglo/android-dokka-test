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

import android.net.NetworkSpecifier;
import android.net.ProxyInfo;

/**
 * A class representing a configured Wi-Fi network, including the
 * security configuration.
 *
 * @deprecated Use {@link android.net.wifi.WifiNetworkSpecifier.Builder WifiNetworkSpecifier.Builder} to create {@link android.net.NetworkSpecifier NetworkSpecifier} and
 * {@link android.net.wifi.WifiNetworkSuggestion.Builder WifiNetworkSuggestion.Builder} to create {@link android.net.wifi.WifiNetworkSuggestion WifiNetworkSuggestion}. This will become a
 * system use only object in the future.
 * @apiSince 1
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class WifiConfiguration implements android.os.Parcelable {

/** @apiSince 1 */

@Deprecated
public WifiConfiguration() { throw new RuntimeException("Stub!"); }

/**
 * Returns MAC address set to be the local randomized MAC address.
 * Depending on user preference, the device may or may not use the returned MAC address for
 * connections to this network.
 * <p>
 * Information is restricted to Device Owner, Profile Owner, and Carrier apps
 * (which will only obtain addresses for configurations which they create). Other callers
 * will receive a default "02:00:00:00:00:00" MAC address.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 * @deprecatedSince 29
 */

@Deprecated
@androidx.annotation.NonNull
public android.net.MacAddress getRandomizedMacAddress() { throw new RuntimeException("Stub!"); }

/**
 * Identify if this configuration represents a Passpoint network
 * @apiSince 23
 * @deprecatedSince 29
 */

@Deprecated
public boolean isPasspoint() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Returns the HTTP proxy used by this object.
 * @return a {@link android.net.ProxyInfo ProxyInfo} representing the proxy specified by this
 *                  WifiConfiguration, or {@code null} if no proxy is specified.
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated
public android.net.ProxyInfo getHttpProxy() { throw new RuntimeException("Stub!"); }

/**
 * Set the {@link android.net.ProxyInfo ProxyInfo} for this WifiConfiguration. This method should only be used by a
 * device owner or profile owner. When other apps attempt to save a {@link android.net.wifi.WifiConfiguration WifiConfiguration}
 * with modified proxy settings, the methods {@link android.net.wifi.WifiManager#addNetwork WifiManager#addNetwork} and
 * {@link android.net.wifi.WifiManager#updateNetwork WifiManager#updateNetwork} fail and return {@code -1}.
 *
 * @param httpProxy {@link android.net.ProxyInfo ProxyInfo} representing the httpProxy to be used by this
 *                  WifiConfiguration. Setting this to {@code null} will explicitly set no
 *                  proxy, removing any proxy that was previously set.
 * @exception java.lang.IllegalArgumentException for invalid httpProxy
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated
public void setHttpProxy(android.net.ProxyInfo httpProxy) { throw new RuntimeException("Stub!"); }

/** Implement the Parcelable interface {@hide} */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** Implement the Parcelable interface {@hide} */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * When set, this network configuration entry should only be used when
 * associating with the AP having the specified BSSID. The value is
 * a string in the format of an Ethernet MAC address, e.g.,
 * <code>XX:XX:XX:XX:XX:XX</code> where each <code>X</code> is a hex digit.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public java.lang.String BSSID;

/**
 * Fully qualified domain name of a Passpoint configuration
 * @apiSince 21
 * @deprecatedSince 29
 */

@Deprecated public java.lang.String FQDN;

/**
 * The network's SSID. Can either be a UTF-8 string,
 * which must be enclosed in double quotation marks
 * (e.g., {@code "MyNetwork"}), or a string of
 * hex digits, which are not enclosed in quotes
 * (e.g., {@code 01a243f405}).
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public java.lang.String SSID;

/**
 * The set of authentication protocols supported by this configuration.
 * See {@link android.net.wifi.WifiConfiguration.AuthAlgorithm AuthAlgorithm} for descriptions of the values.
 * Defaults to automatic selection.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated @androidx.annotation.NonNull public java.util.BitSet allowedAuthAlgorithms;

/**
 * The set of group ciphers supported by this configuration.
 * See {@link android.net.wifi.WifiConfiguration.GroupCipher GroupCipher} for descriptions of the values.
 * Defaults to CCMP TKIP WEP104 WEP40.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated @androidx.annotation.NonNull public java.util.BitSet allowedGroupCiphers;

/**
 * The set of group management ciphers supported by this configuration.
 * See {@link android.net.wifi.WifiConfiguration.GroupMgmtCipher GroupMgmtCipher} for descriptions of the values.
 * @apiSince 29
 * @deprecatedSince 29
 */

@Deprecated @androidx.annotation.NonNull public java.util.BitSet allowedGroupManagementCiphers;

/**
 * The set of key management protocols supported by this configuration.
 * See {@link android.net.wifi.WifiConfiguration.KeyMgmt KeyMgmt} for descriptions of the values.
 * Defaults to WPA-PSK WPA-EAP.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated @androidx.annotation.NonNull public java.util.BitSet allowedKeyManagement;

/**
 * The set of pairwise ciphers for WPA supported by this configuration.
 * See {@link android.net.wifi.WifiConfiguration.PairwiseCipher PairwiseCipher} for descriptions of the values.
 * Defaults to CCMP TKIP.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated @androidx.annotation.NonNull public java.util.BitSet allowedPairwiseCiphers;

/**
 * The set of security protocols supported by this configuration.
 * See {@link android.net.wifi.WifiConfiguration.Protocol Protocol} for descriptions of the values.
 * Defaults to WPA RSN.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated @androidx.annotation.NonNull public java.util.BitSet allowedProtocols;

/**
 * The set of SuiteB ciphers supported by this configuration.
 * To be used for WPA3-Enterprise mode.
 * See {@link android.net.wifi.WifiConfiguration.SuiteBCipher SuiteBCipher} for descriptions of the values.
 * @apiSince 29
 * @deprecatedSince 29
 */

@Deprecated @androidx.annotation.NonNull public java.util.BitSet allowedSuiteBCiphers;

/**
 * The enterprise configuration details specifying the EAP method,
 * certificates and other settings associated with the EAP.
 * @apiSince 18
 * @deprecatedSince 29
 */

@Deprecated public android.net.wifi.WifiEnterpriseConfig enterpriseConfig;

/**
 * This is a network that does not broadcast its SSID, so an
 * SSID-specific probe request must be used for scans.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public boolean hiddenSSID;

/**
 * Flag indicating if this network is provided by a home Passpoint provider or a roaming
 * Passpoint provider.  This flag will be {@code true} if this network is provided by
 * a home Passpoint provider and {@code false} if is provided by a roaming Passpoint provider
 * or is a non-Passpoint network.
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated public boolean isHomeProviderNetwork;

/**
 * The ID number that the supplicant uses to identify this
 * network configuration entry. This must be passed as an argument
 * to most calls into the supplicant.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public int networkId;

/**
 * Pre-shared key for use with WPA-PSK. Either an ASCII string enclosed in
 * double quotation marks (e.g., {@code "abcdefghij"} for PSK passphrase or
 * a string of 64 hex digits for raw PSK.
 * <p/>
 * When the value of this key is read, the actual key is
 * not returned, just a "*" if the key has a value, or the null
 * string otherwise.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public java.lang.String preSharedKey;

/**
 * Priority determines the preference given to a network by {@code wpa_supplicant}
 * when choosing an access point with which to associate.
 * @deprecated This field does not exist anymore.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated public int priority;

/**
 * Name of Passpoint credential provider
 * @apiSince 23
 * @deprecatedSince 29
 */

@Deprecated public java.lang.String providerFriendlyName;

/**
 * Roaming Consortium Id list for Passpoint credential; identifies a set of networks where
 * Passpoint credential will be considered valid
 * @apiSince 23
 * @deprecatedSince 29
 */

@Deprecated public long[] roamingConsortiumIds;

/**
 * The current status of this network configuration entry.
 * @see android.net.wifi.WifiConfiguration.Status
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public int status;

/**
 * Four WEP keys. For each of the four values, provide either an ASCII
 * string enclosed in double quotation marks (e.g., {@code "abcdef"}),
 * a string of hex digits (e.g., {@code 0102030405}), or an empty string
 * (e.g., {@code ""}).
 * <p/>
 * When the value of one of these keys is read, the actual key is
 * not returned, just a "*" if the key has a value, or the null
 * string otherwise.
 * @deprecated Due to security and performance limitations, use of WEP networks
 * is discouraged.
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated public java.lang.String[] wepKeys;

/** Default WEP key index, ranging from 0 to 3.
 * @deprecated Due to security and performance limitations, use of WEP networks
 * is discouraged.     * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated public int wepTxKeyIndex;
/**
 * Recognized IEEE 802.11 authentication algorithms.
 * @apiSince 1
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static class AuthAlgorithm {

private AuthAlgorithm() { throw new RuntimeException("Stub!"); }

/**
 * LEAP/Network EAP (only used with LEAP)
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final int LEAP = 2; // 0x2

/**
 * Open System authentication (required for WPA/WPA2)
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final int OPEN = 0; // 0x0

/** Shared Key authentication (requires static WEP keys)
 * @deprecated Due to security and performance limitations, use of WEP networks
 * is discouraged.         * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated public static final int SHARED = 1; // 0x1

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String[] strings;
static { strings = new java.lang.String[0]; }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String varName = "auth_alg";
}

/**
 * Recognized group ciphers.
 * <pre>
 * CCMP = AES in Counter mode with CBC-MAC [RFC 3610, IEEE 802.11i/D7.0]
 * TKIP = Temporal Key Integrity Protocol [IEEE 802.11i/D7.0]
 * WEP104 = WEP (Wired Equivalent Privacy) with 104-bit key
 * WEP40 = WEP (Wired Equivalent Privacy) with 40-bit key (original 802.11)
 * GCMP_256 = AES in Galois/Counter Mode
 * </pre>
 * @apiSince 1
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static class GroupCipher {

private GroupCipher() { throw new RuntimeException("Stub!"); }

/**
 * AES in Counter mode with CBC-MAC [RFC 3610, IEEE 802.11i/D7.0]
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final int CCMP = 3; // 0x3

/**
 * AES in Galois/Counter Mode
 * @apiSince 29
 * @deprecatedSince 29
 */

@Deprecated public static final int GCMP_256 = 5; // 0x5

/**
 * Temporal Key Integrity Protocol [IEEE 802.11i/D7.0]
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final int TKIP = 2; // 0x2

/** WEP104 = WEP (Wired Equivalent Privacy) with 104-bit key
 * @deprecated Due to security and performance limitations, use of WEP networks
 * is discouraged.         * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated public static final int WEP104 = 1; // 0x1

/** WEP40 = WEP (Wired Equivalent Privacy) with 40-bit key (original 802.11)
 * @deprecated Due to security and performance limitations, use of WEP networks
 * is discouraged.         * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated public static final int WEP40 = 0; // 0x0

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String[] strings;
static { strings = new java.lang.String[0]; }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String varName = "group";
}

/**
 * Recognized group management ciphers.
 * <pre>
 * BIP_CMAC_256 = Cipher-based Message Authentication Code 256 bits
 * BIP_GMAC_128 = Galois Message Authentication Code 128 bits
 * BIP_GMAC_256 = Galois Message Authentication Code 256 bits
 * </pre>
 * @apiSince 29
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static class GroupMgmtCipher {

private GroupMgmtCipher() { throw new RuntimeException("Stub!"); }

/**
 * CMAC-256 = Cipher-based Message Authentication Code
 * @apiSince 29
 * @deprecatedSince 29
 */

@Deprecated public static final int BIP_CMAC_256 = 0; // 0x0

/**
 * GMAC-128 = Galois Message Authentication Code
 * @apiSince 29
 * @deprecatedSince 29
 */

@Deprecated public static final int BIP_GMAC_128 = 1; // 0x1

/**
 * GMAC-256 = Galois Message Authentication Code
 * @apiSince 29
 * @deprecatedSince 29
 */

@Deprecated public static final int BIP_GMAC_256 = 2; // 0x2
}

/**
 * Recognized key management schemes.
 * @apiSince 1
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static class KeyMgmt {

private KeyMgmt() { throw new RuntimeException("Stub!"); }

/** IEEE 802.1X using EAP authentication and (optionally) dynamically
 * generated WEP keys.         * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final int IEEE8021X = 3; // 0x3

/**
 * WPA is not used; plaintext or static WEP could be used.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final int NONE = 0; // 0x0

/**
 * Opportunististic Wireless Encryption
 * @apiSince 29
 * @deprecatedSince 29
 */

@Deprecated public static final int OWE = 9; // 0x9

/**
 * Simultaneous Authentication of Equals
 * @apiSince 29
 * @deprecatedSince 29
 */

@Deprecated public static final int SAE = 8; // 0x8

/**
 * SUITE_B_192 192 bit level
 * @apiSince 29
 * @deprecatedSince 29
 */

@Deprecated public static final int SUITE_B_192 = 10; // 0xa

/**
 * WPA using EAP authentication. Generally used with an external authentication server.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final int WPA_EAP = 2; // 0x2

/**
 * WPA pre-shared key (requires {@code preSharedKey} to be specified).
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final int WPA_PSK = 1; // 0x1

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String[] strings;
static { strings = new java.lang.String[0]; }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String varName = "key_mgmt";
}

/**
 * Recognized pairwise ciphers for WPA.
 * @apiSince 1
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static class PairwiseCipher {

private PairwiseCipher() { throw new RuntimeException("Stub!"); }

/**
 * AES in Counter mode with CBC-MAC [RFC 3610, IEEE 802.11i/D7.0]
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final int CCMP = 2; // 0x2

/**
 * AES in Galois/Counter Mode
 * @apiSince 29
 * @deprecatedSince 29
 */

@Deprecated public static final int GCMP_256 = 3; // 0x3

/**
 * Use only Group keys (deprecated)
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final int NONE = 0; // 0x0

/** Temporal Key Integrity Protocol [IEEE 802.11i/D7.0]
 * @deprecated Due to security and performance limitations, use of WPA-1 networks
 * is discouraged. WPA-2 (RSN) should be used instead.         * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated public static final int TKIP = 1; // 0x1

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String[] strings;
static { strings = new java.lang.String[0]; }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String varName = "pairwise";
}

/**
 * Recognized security protocols.
 * @apiSince 1
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static class Protocol {

private Protocol() { throw new RuntimeException("Stub!"); }

/**
 * RSN WPA2/WPA3/IEEE 802.11i
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final int RSN = 1; // 0x1

/** WPA/IEEE 802.11i/D3.0
 * @deprecated Due to security and performance limitations, use of WPA-1 networks
 * is discouraged. WPA-2 (RSN) should be used instead.         * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated public static final int WPA = 0; // 0x0

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String[] strings;
static { strings = new java.lang.String[0]; }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String varName = "proto";
}

/**
 * Possible status of a network configuration.
 * @apiSince 1
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static class Status {

private Status() { throw new RuntimeException("Stub!"); }

/**
 * this is the network we are currently connected to
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final int CURRENT = 0; // 0x0

/**
 * supplicant will not attempt to use this network
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final int DISABLED = 1; // 0x1

/**
 * supplicant will consider this network available for association
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final int ENABLED = 2; // 0x2

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String[] strings;
static { strings = new java.lang.String[0]; }
}

}

