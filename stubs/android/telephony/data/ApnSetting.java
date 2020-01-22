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

package android.telephony.data;

import android.net.Uri;
import android.provider.Telephony.Carriers;
import android.provider.Telephony;
import android.telephony.TelephonyManager;
import java.net.UnknownHostException;
import java.net.InetAddress;

/**
 * An Access Point Name (APN) configuration for a carrier data connection.
 *
 * <p>The APN provides configuration to connect a cellular network device to an IP data network. A
 * carrier uses the name, type and other configuration in an {@code APNSetting} to decide which IP
 * address to assign, any security methods to apply, and how the device might be connected to
 * private networks.
 *
 * <p>Use {@link android.telephony.data.ApnSetting.Builder ApnSetting.Builder} to create new instances.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ApnSetting implements android.os.Parcelable {

private ApnSetting() { throw new RuntimeException("Stub!"); }

/**
 * Gets the human-readable name that describes the APN.
 *
 * @return the entry name for the APN
 * @apiSince 28
 */

public java.lang.String getEntryName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the name of the APN.
 *
 * @return APN name
 * @apiSince 28
 */

public java.lang.String getApnName() { throw new RuntimeException("Stub!"); }

/**
 * Gets the HTTP proxy address configured for the APN. The proxy address might be an IP address
 * or hostname. This method returns {@code null} if system networking (typically DNS) isn’t
 * available to resolve a hostname value—values set as IP addresses don’t have this restriction.
 * This is a known problem and will be addressed in a future release.
 *
 * @return the HTTP proxy address or {@code null} if DNS isn’t available to resolve a hostname
 * @deprecated use {@link #getProxyAddressAsString()} instead.
 * @apiSince 28
 * @deprecatedSince 29
 */

@Deprecated
public java.net.InetAddress getProxyAddress() { throw new RuntimeException("Stub!"); }

/**
 * Returns the proxy address of the APN.
 *
 * @return proxy address.
 * @apiSince 29
 */

public java.lang.String getProxyAddressAsString() { throw new RuntimeException("Stub!"); }

/**
 * Returns the proxy address of the APN.
 *
 * @return proxy address.
 * @apiSince 28
 */

public int getProxyPort() { throw new RuntimeException("Stub!"); }

/**
 * Returns the MMSC Uri of the APN.
 *
 * @return MMSC Uri.
 * @apiSince 28
 */

public android.net.Uri getMmsc() { throw new RuntimeException("Stub!"); }

/**
 * Gets the MMS proxy address configured for the APN. The MMS proxy address might be an IP
 * address or hostname. This method returns {@code null} if system networking (typically DNS)
 * isn’t available to resolve a hostname value—values set as IP addresses don’t have this
 * restriction. This is a known problem and will be addressed in a future release.
 *
 * @return the MMS proxy address or {@code null} if DNS isn’t available to resolve a hostname
 * @deprecated use {@link #getMmsProxyAddressAsString()} instead.
 * @apiSince 28
 * @deprecatedSince 29
 */

@Deprecated
public java.net.InetAddress getMmsProxyAddress() { throw new RuntimeException("Stub!"); }

/**
 * Returns the MMS proxy address of the APN.
 *
 * @return MMS proxy address.
 * @apiSince 29
 */

public java.lang.String getMmsProxyAddressAsString() { throw new RuntimeException("Stub!"); }

/**
 * Returns the MMS proxy port of the APN.
 *
 * @return MMS proxy port
 * @apiSince 28
 */

public int getMmsProxyPort() { throw new RuntimeException("Stub!"); }

/**
 * Returns the APN username of the APN.
 *
 * @return APN username
 * @apiSince 28
 */

public java.lang.String getUser() { throw new RuntimeException("Stub!"); }

/**
 * Returns the APN password of the APN.
 *
 * @return APN password
 * @apiSince 28
 */

public java.lang.String getPassword() { throw new RuntimeException("Stub!"); }

/**
 * Returns the authentication type of the APN.
 *
 * @return authentication type
 
 * Value is {@link android.telephony.data.ApnSetting#AUTH_TYPE_NONE}, {@link android.telephony.data.ApnSetting#AUTH_TYPE_PAP}, {@link android.telephony.data.ApnSetting#AUTH_TYPE_CHAP}, or {@link android.telephony.data.ApnSetting#AUTH_TYPE_PAP_OR_CHAP}
 * @apiSince 28
 */

public int getAuthType() { throw new RuntimeException("Stub!"); }

/**
 * Returns the bitmask of APN types.
 *
 * <p>Apn types are usage categories for an APN entry. One APN entry may support multiple
 * APN types, eg, a single APN may service regular internet traffic ("default") as well as
 * MMS-specific connections.
 *
 * <p>The bitmask of APN types is calculated from APN types defined in {@link android.telephony.data.ApnSetting ApnSetting}.
 *
 * @see android.telephony.data.ApnSetting.Builder#setApnTypeBitmask(int)
 * @return a bitmask describing the types of the APN
 
 * Value is either <code>0</code> or a combination of {@link android.telephony.data.ApnSetting#TYPE_DEFAULT}, {@link android.telephony.data.ApnSetting#TYPE_MMS}, {@link android.telephony.data.ApnSetting#TYPE_SUPL}, {@link android.telephony.data.ApnSetting#TYPE_DUN}, {@link android.telephony.data.ApnSetting#TYPE_HIPRI}, {@link android.telephony.data.ApnSetting#TYPE_FOTA}, {@link android.telephony.data.ApnSetting#TYPE_IMS}, {@link android.telephony.data.ApnSetting#TYPE_CBS}, {@link android.telephony.data.ApnSetting#TYPE_IA}, {@link android.telephony.data.ApnSetting#TYPE_EMERGENCY}, {@link android.telephony.data.ApnSetting#TYPE_MCX}, and {@link android.telephony.data.ApnSetting#TYPE_XCAP}
 * @apiSince 28
 */

public int getApnTypeBitmask() { throw new RuntimeException("Stub!"); }

/**
 * Returns the unique database id for this entry.
 *
 * @return the unique database id
 * @apiSince 28
 */

public int getId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the numeric operator ID for the APN. Numeric operator ID is defined as
 * {@link android.provider.Telephony.Carriers#MCC} +
 * {@link android.provider.Telephony.Carriers#MNC}.
 *
 * @return the numeric operator ID
 * @apiSince 28
 */

public java.lang.String getOperatorNumeric() { throw new RuntimeException("Stub!"); }

/**
 * Returns the protocol to use to connect to this APN.
 *
 * <p>Protocol is one of the {@code PDP_type} values in TS 27.007 section 10.1.1.
 *
 * @see android.telephony.data.ApnSetting.Builder#setProtocol(int)
 * @return the protocol
 
 * Value is {@link android.telephony.data.ApnSetting#PROTOCOL_IP}, {@link android.telephony.data.ApnSetting#PROTOCOL_IPV6}, {@link android.telephony.data.ApnSetting#PROTOCOL_IPV4V6}, {@link android.telephony.data.ApnSetting#PROTOCOL_PPP}, {@link android.telephony.data.ApnSetting#PROTOCOL_NON_IP}, or {@link android.telephony.data.ApnSetting#PROTOCOL_UNSTRUCTURED}
 * @apiSince 28
 */

public int getProtocol() { throw new RuntimeException("Stub!"); }

/**
 * Returns the protocol to use to connect to this APN while the device is roaming.
 *
 * <p>Roaming protocol is one of the {@code PDP_type} values in TS 27.007 section 10.1.1.
 *
 * @see android.telephony.data.ApnSetting.Builder#setRoamingProtocol(int)
 * @return the roaming protocol
 
 * Value is {@link android.telephony.data.ApnSetting#PROTOCOL_IP}, {@link android.telephony.data.ApnSetting#PROTOCOL_IPV6}, {@link android.telephony.data.ApnSetting#PROTOCOL_IPV4V6}, {@link android.telephony.data.ApnSetting#PROTOCOL_PPP}, {@link android.telephony.data.ApnSetting#PROTOCOL_NON_IP}, or {@link android.telephony.data.ApnSetting#PROTOCOL_UNSTRUCTURED}
 * @apiSince 28
 */

public int getRoamingProtocol() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current status of APN.
 *
 * {@code true} : enabled APN.
 * {@code false} : disabled APN.
 *
 * @return the current status
 * @apiSince 28
 */

public boolean isEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Returns a bitmask describing the Radio Technologies(Network Types) which this APN may use.
 *
 * NetworkType bitmask is calculated from NETWORK_TYPE defined in {@link android.telephony.TelephonyManager TelephonyManager}.
 *
 * Examples of Network Types include {@link android.telephony.TelephonyManager#NETWORK_TYPE_UNKNOWN TelephonyManager#NETWORK_TYPE_UNKNOWN},
 * {@link android.telephony.TelephonyManager#NETWORK_TYPE_GPRS TelephonyManager#NETWORK_TYPE_GPRS}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_EDGE TelephonyManager#NETWORK_TYPE_EDGE}.
 *
 * @return a bitmask describing the Radio Technologies(Network Types)
 * @apiSince 28
 */

public int getNetworkTypeBitmask() { throw new RuntimeException("Stub!"); }

/**
 * Returns the MVNO match type for this APN.
 *
 * @see android.telephony.data.ApnSetting.Builder#setMvnoType(int)
 * @return the MVNO match type
 
 * Value is {@link android.telephony.data.ApnSetting#MVNO_TYPE_SPN}, {@link android.telephony.data.ApnSetting#MVNO_TYPE_IMSI}, {@link android.telephony.data.ApnSetting#MVNO_TYPE_GID}, or {@link android.telephony.data.ApnSetting#MVNO_TYPE_ICCID}
 * @apiSince 28
 */

public int getMvnoType() { throw new RuntimeException("Stub!"); }

/**
 * Returns the carrier id for this APN.
 *
 * @see android.telephony.data.ApnSetting.Builder#setCarrierId(int)
 * @return the carrier id
 * @apiSince 29
 */

public int getCarrierId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the string representation of ApnSetting.
 *
 * This method prints null for unset elements. The output doesn't contain password or user.
 * @hide
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * @hide
 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param dest This value must never be {@code null}.
 * @apiSince 28
 */

public void writeToParcel(@androidx.annotation.NonNull android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Authentication type for CHAP.
 * @apiSince 28
 */

public static final int AUTH_TYPE_CHAP = 2; // 0x2

/**
 * No authentication type.
 * @apiSince 28
 */

public static final int AUTH_TYPE_NONE = 0; // 0x0

/**
 * Authentication type for PAP.
 * @apiSince 28
 */

public static final int AUTH_TYPE_PAP = 1; // 0x1

/**
 * Authentication type for PAP or CHAP.
 * @apiSince 28
 */

public static final int AUTH_TYPE_PAP_OR_CHAP = 3; // 0x3

/** @apiSince 28 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telephony.data.ApnSetting> CREATOR;
static { CREATOR = null; }

/**
 * MVNO type for group identifier level 1.
 * @apiSince 28
 */

public static final int MVNO_TYPE_GID = 2; // 0x2

/**
 * MVNO type for ICCID.
 * @apiSince 28
 */

public static final int MVNO_TYPE_ICCID = 3; // 0x3

/**
 * MVNO type for IMSI.
 * @apiSince 28
 */

public static final int MVNO_TYPE_IMSI = 1; // 0x1

/**
 * MVNO type for service provider name.
 * @apiSince 28
 */

public static final int MVNO_TYPE_SPN = 0; // 0x0

/**
 * Internet protocol.
 * @apiSince 28
 */

public static final int PROTOCOL_IP = 0; // 0x0

/**
 * Virtual PDP type introduced to handle dual IP stack UE capability.
 * @apiSince 28
 */

public static final int PROTOCOL_IPV4V6 = 2; // 0x2

/**
 * Internet protocol, version 6.
 * @apiSince 28
 */

public static final int PROTOCOL_IPV6 = 1; // 0x1

/**
 * Transfer of Non-IP data to external packet data network.
 * @apiSince 29
 */

public static final int PROTOCOL_NON_IP = 4; // 0x4

/**
 * Point to point protocol.
 * @apiSince 28
 */

public static final int PROTOCOL_PPP = 3; // 0x3

/**
 * Transfer of Unstructured data to the Data Network via N6.
 * @apiSince 29
 */

public static final int PROTOCOL_UNSTRUCTURED = 5; // 0x5

/**
 * APN type for CBS.
 * @apiSince 28
 */

public static final int TYPE_CBS = 128; // 0x80

/**
 * APN type for default data traffic.
 * @apiSince 28
 */

public static final int TYPE_DEFAULT = 17; // 0x11

/**
 * APN type for DUN traffic.
 * @apiSince 28
 */

public static final int TYPE_DUN = 8; // 0x8

/**
 * APN type for Emergency PDN. This is not an IA apn, but is used
 * for access to carrier services in an emergency call situation.
 * @apiSince 28
 */

public static final int TYPE_EMERGENCY = 512; // 0x200

/**
 * APN type for accessing the carrier's FOTA portal, used for over the air updates.
 * @apiSince 28
 */

public static final int TYPE_FOTA = 32; // 0x20

/**
 * APN type for HiPri traffic.
 * @apiSince 28
 */

public static final int TYPE_HIPRI = 16; // 0x10

/**
 * APN type for IA Initial Attach APN.
 * @apiSince 28
 */

public static final int TYPE_IA = 256; // 0x100

/**
 * APN type for IMS.
 * @apiSince 28
 */

public static final int TYPE_IMS = 64; // 0x40

/**
 * APN type for MCX (Mission Critical Service) where X can be PTT/Video/Data
 * @apiSince 29
 */

public static final int TYPE_MCX = 1024; // 0x400

/**
 * APN type for MMS traffic.
 * @apiSince 28
 */

public static final int TYPE_MMS = 2; // 0x2

/**
 * APN type for SUPL assisted GPS.
 * @apiSince 28
 */

public static final int TYPE_SUPL = 4; // 0x4

/**
 * APN type for XCAP.
 * @apiSince R
 */

public static final int TYPE_XCAP = 2048; // 0x800
/**
 * Provides a convenient way to set the fields of a {@link android.telephony.data.ApnSetting ApnSetting} when creating a new
 * instance. The following settings are required to build an {@code ApnSetting}:
 *
 * <ul><li>apnTypeBitmask</li>
 * <li>apnName</li>
 * <li>entryName</li></ul>
 *
 * <p>The example below shows how you might create a new {@code ApnSetting}:
 *
 * <pre><code>
 * // Create an MMS proxy address with a hostname. A network might not be
 * // available, so supply a dummy (0.0.0.0) IPv4 address to avoid DNS lookup.
 * String host = "mms.example.com";
 * byte[] ipAddress = new byte[4];
 * InetAddress mmsProxy;
 * try {
 *   mmsProxy = InetAddress.getByAddress(host, ipAddress);
 * } catch (UnknownHostException e) {
 *   e.printStackTrace();
 *   return;
 * }
 *
 * ApnSetting apn = new ApnSetting.Builder()
 *     .setApnTypeBitmask(ApnSetting.TYPE_DEFAULT | ApnSetting.TYPE_MMS)
 *     .setApnName("apn.example.com")
 *     .setEntryName("Example Carrier APN")
 *     .setMmsc(Uri.parse("http://mms.example.com:8002"))
 *     .setMmsProxyAddress(mmsProxy)
 *     .setMmsProxyPort(8799)
 *     .build();
 * </code></pre>
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

/**
 * Default constructor for Builder.
 * @apiSince 28
 */

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Sets a human-readable name that describes the APN.
 *
 * @param entryName the entry name to set for the APN
 
 * This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.telephony.data.ApnSetting.Builder setEntryName(@androidx.annotation.Nullable java.lang.String entryName) { throw new RuntimeException("Stub!"); }

/**
 * Sets the name of the APN.
 *
 * @param apnName the name to set for the APN
 
 * This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.telephony.data.ApnSetting.Builder setApnName(@androidx.annotation.Nullable java.lang.String apnName) { throw new RuntimeException("Stub!"); }

/**
 * Sets the address of an HTTP proxy for the APN. The proxy address can be an IP address or
 * hostname. If {@code proxy} contains both an IP address and hostname, this method ignores
 * the IP address.
 *
 * <p>The {@link java.net.InetAddress} methods
 * {@link java.net.InetAddress#getAllByName getAllByName()} require DNS for hostname
 * resolution. To avoid this requirement when setting a hostname, call
 * {@link java.net.InetAddress#getByAddress(java.lang.String, byte[])} with both the
 * hostname and a dummy IP address. See {@link android.telephony.data.ApnSetting.Builder ApnSetting.Builder} for an example.
 *
 * @param proxy the proxy address to set for the APN
 * @deprecated use {@link #setProxyAddress(java.lang.String)} instead.
 * @apiSince 28
 * @deprecatedSince 29
 */

@Deprecated
public android.telephony.data.ApnSetting.Builder setProxyAddress(java.net.InetAddress proxy) { throw new RuntimeException("Stub!"); }

/**
 * Sets the proxy address of the APN.
 *
 * @param proxy the proxy address to set for the APN
 
 * This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.telephony.data.ApnSetting.Builder setProxyAddress(@androidx.annotation.Nullable java.lang.String proxy) { throw new RuntimeException("Stub!"); }

/**
 * Sets the proxy port of the APN.
 *
 * @param port the proxy port to set for the APN
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.telephony.data.ApnSetting.Builder setProxyPort(int port) { throw new RuntimeException("Stub!"); }

/**
 * Sets the MMSC Uri of the APN.
 *
 * @param mmsc the MMSC Uri to set for the APN
 
 * This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.telephony.data.ApnSetting.Builder setMmsc(@androidx.annotation.Nullable android.net.Uri mmsc) { throw new RuntimeException("Stub!"); }

/**
 * Sets the address of an MMS proxy for the APN. The MMS proxy address can be an IP address
 * or hostname. If {@code mmsProxy} contains both an IP address and hostname, this method
 * ignores the IP address.
 *
 * <p>The {@link java.net.InetAddress} methods
 * {@link java.net.InetAddress#getByName getByName()} and
 * {@link java.net.InetAddress#getAllByName getAllByName()} require DNS for hostname
 * resolution. To avoid this requirement when setting a hostname, call
 * {@link java.net.InetAddress#getByAddress(java.lang.String, byte[])} with both the
 * hostname and a dummy IP address. See {@link android.telephony.data.ApnSetting.Builder ApnSetting.Builder} for an example.
 *
 * @param mmsProxy the MMS proxy address to set for the APN
 * @deprecated use {@link #setMmsProxyAddress(java.lang.String)} instead.
 * @apiSince 28
 * @deprecatedSince 29
 */

@Deprecated
public android.telephony.data.ApnSetting.Builder setMmsProxyAddress(java.net.InetAddress mmsProxy) { throw new RuntimeException("Stub!"); }

/**
 * Sets the MMS proxy address of the APN.
 *
 * @param mmsProxy the MMS proxy address to set for the APN
 
 * This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.telephony.data.ApnSetting.Builder setMmsProxyAddress(@androidx.annotation.Nullable java.lang.String mmsProxy) { throw new RuntimeException("Stub!"); }

/**
 * Sets the MMS proxy port of the APN.
 *
 * @param mmsPort the MMS proxy port to set for the APN
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.telephony.data.ApnSetting.Builder setMmsProxyPort(int mmsPort) { throw new RuntimeException("Stub!"); }

/**
 * Sets the APN username of the APN.
 *
 * @param user the APN username to set for the APN
 
 * This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.telephony.data.ApnSetting.Builder setUser(@androidx.annotation.Nullable java.lang.String user) { throw new RuntimeException("Stub!"); }

/**
 * Sets the APN password of the APN.
 *
 * @see android.provider.Telephony.Carriers#PASSWORD
 * @param password the APN password to set for the APN
 
 * This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.telephony.data.ApnSetting.Builder setPassword(@androidx.annotation.Nullable java.lang.String password) { throw new RuntimeException("Stub!"); }

/**
 * Sets the authentication type of the APN.
 *
 * @param authType the authentication type to set for the APN
 
 * Value is {@link android.telephony.data.ApnSetting#AUTH_TYPE_NONE}, {@link android.telephony.data.ApnSetting#AUTH_TYPE_PAP}, {@link android.telephony.data.ApnSetting#AUTH_TYPE_CHAP}, or {@link android.telephony.data.ApnSetting#AUTH_TYPE_PAP_OR_CHAP}
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.telephony.data.ApnSetting.Builder setAuthType(int authType) { throw new RuntimeException("Stub!"); }

/**
 * Sets the bitmask of APN types.
 *
 * <p>Apn types are usage categories for an APN entry. One APN entry may support multiple
 * APN types, eg, a single APN may service regular internet traffic ("default") as well as
 * MMS-specific connections.
 *
 * <p>The bitmask of APN types is calculated from APN types defined in {@link android.telephony.data.ApnSetting ApnSetting}.
 *
 * @param apnTypeBitmask a bitmask describing the types of the APN
 
 * Value is either <code>0</code> or a combination of {@link android.telephony.data.ApnSetting#TYPE_DEFAULT}, {@link android.telephony.data.ApnSetting#TYPE_MMS}, {@link android.telephony.data.ApnSetting#TYPE_SUPL}, {@link android.telephony.data.ApnSetting#TYPE_DUN}, {@link android.telephony.data.ApnSetting#TYPE_HIPRI}, {@link android.telephony.data.ApnSetting#TYPE_FOTA}, {@link android.telephony.data.ApnSetting#TYPE_IMS}, {@link android.telephony.data.ApnSetting#TYPE_CBS}, {@link android.telephony.data.ApnSetting#TYPE_IA}, {@link android.telephony.data.ApnSetting#TYPE_EMERGENCY}, {@link android.telephony.data.ApnSetting#TYPE_MCX}, and {@link android.telephony.data.ApnSetting#TYPE_XCAP}
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.telephony.data.ApnSetting.Builder setApnTypeBitmask(int apnTypeBitmask) { throw new RuntimeException("Stub!"); }

/**
 * Sets the numeric operator ID for the APN. Numeric operator ID is defined as
 * {@link android.provider.Telephony.Carriers#MCC} +
 * {@link android.provider.Telephony.Carriers#MNC}.
 *
 * @param operatorNumeric the numeric operator ID to set for this entry
 
 * This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.telephony.data.ApnSetting.Builder setOperatorNumeric(@androidx.annotation.Nullable java.lang.String operatorNumeric) { throw new RuntimeException("Stub!"); }

/**
 * Sets the protocol to use to connect to this APN.
 *
 * <p>Protocol is one of the {@code PDP_type} values in TS 27.007 section 10.1.1.
 *
 * @param protocol the protocol to set to use to connect to this APN
 
 * Value is {@link android.telephony.data.ApnSetting#PROTOCOL_IP}, {@link android.telephony.data.ApnSetting#PROTOCOL_IPV6}, {@link android.telephony.data.ApnSetting#PROTOCOL_IPV4V6}, {@link android.telephony.data.ApnSetting#PROTOCOL_PPP}, {@link android.telephony.data.ApnSetting#PROTOCOL_NON_IP}, or {@link android.telephony.data.ApnSetting#PROTOCOL_UNSTRUCTURED}
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.telephony.data.ApnSetting.Builder setProtocol(int protocol) { throw new RuntimeException("Stub!"); }

/**
 * Sets the protocol to use to connect to this APN when the device is roaming.
 *
 * <p>Roaming protocol is one of the {@code PDP_type} values in TS 27.007 section 10.1.1.
 *
 * @param roamingProtocol the protocol to set to use to connect to this APN when roaming
 
 * Value is {@link android.telephony.data.ApnSetting#PROTOCOL_IP}, {@link android.telephony.data.ApnSetting#PROTOCOL_IPV6}, {@link android.telephony.data.ApnSetting#PROTOCOL_IPV4V6}, {@link android.telephony.data.ApnSetting#PROTOCOL_PPP}, {@link android.telephony.data.ApnSetting#PROTOCOL_NON_IP}, or {@link android.telephony.data.ApnSetting#PROTOCOL_UNSTRUCTURED}
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.telephony.data.ApnSetting.Builder setRoamingProtocol(int roamingProtocol) { throw new RuntimeException("Stub!"); }

/**
 * Sets the current status for this APN.
 *
 * @param carrierEnabled the current status to set for this APN
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.telephony.data.ApnSetting.Builder setCarrierEnabled(boolean carrierEnabled) { throw new RuntimeException("Stub!"); }

/**
 * Sets Radio Technology (Network Type) info for this APN.
 *
 * @param networkTypeBitmask the Radio Technology (Network Type) info
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.telephony.data.ApnSetting.Builder setNetworkTypeBitmask(int networkTypeBitmask) { throw new RuntimeException("Stub!"); }

/**
 * Sets the MVNO match type for this APN.
 *
 * @param mvnoType the MVNO match type to set for this APN
 
 * Value is {@link android.telephony.data.ApnSetting#MVNO_TYPE_SPN}, {@link android.telephony.data.ApnSetting#MVNO_TYPE_IMSI}, {@link android.telephony.data.ApnSetting#MVNO_TYPE_GID}, or {@link android.telephony.data.ApnSetting#MVNO_TYPE_ICCID}
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.telephony.data.ApnSetting.Builder setMvnoType(int mvnoType) { throw new RuntimeException("Stub!"); }

/**
 * Sets the carrier id for this APN.
 *
 * See {@link android.telephony.TelephonyManager#getSimCarrierId() TelephonyManager#getSimCarrierId()} which provides more background for what a
 * carrier ID is.
 *
 * @param carrierId the carrier id to set for this APN
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.telephony.data.ApnSetting.Builder setCarrierId(int carrierId) { throw new RuntimeException("Stub!"); }

/**
 * Builds {@link android.telephony.data.ApnSetting ApnSetting} from this builder.
 *
 * @return {@code null} if {@link #setApnName(java.lang.String)} or {@link #setEntryName(java.lang.String)}
 * is empty, or {@link #setApnTypeBitmask(int)} doesn't contain a valid bit,
 * {@link android.telephony.data.ApnSetting ApnSetting} built from this builder otherwise.
 * @apiSince 28
 */

public android.telephony.data.ApnSetting build() { throw new RuntimeException("Stub!"); }
}

}

