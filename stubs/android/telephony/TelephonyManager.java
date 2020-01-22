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


package android.telephony;

import android.Manifest;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.telephony.VisualVoicemailService.VisualVoicemailTask;
import android.app.PendingIntent;
import android.os.Binder;
import android.os.Build;
import java.util.List;
import java.util.concurrent.Executor;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.net.ConnectivityManager;
import android.telecom.PhoneAccount;
import android.telephony.emergency.EmergencyNumber;
import java.util.Map;
import android.os.RemoteException;
import android.content.Intent;
import android.telecom.InCallService;
import android.telecom.CallScreeningService;

/**
 * Provides access to information about the telephony services on
 * the device. Applications can use the methods in this class to
 * determine telephony services and states, as well as to access some
 * types of subscriber information. Applications can also register
 * a listener to receive notification of telephony state changes.
 * <p>
 * The returned TelephonyManager will use the default subscription for all calls.
 * To call an API for a specific subscription, use {@link #createForSubscriptionId(int)}. e.g.
 * <code>
 *   telephonyManager = defaultSubTelephonyManager.createForSubscriptionId(subId);
 * </code>
 * <p>
 * Note that access to some telephony information is
 * permission-protected. Your application cannot access the protected
 * information unless it has the appropriate permissions declared in
 * its manifest file. Where permissions apply, they are noted in the
 * the methods through which you access the protected information.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TelephonyManager {

TelephonyManager() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of phones available.
 * Returns 0 if none of voice, sms, data is not supported
 * Returns 1 for Single standby mode (Single SIM functionality).
 * Returns 2 for Dual standby mode (Dual SIM functionality).
 * Returns 3 for Tri standby mode (Tri SIM functionality).
 * @deprecated Use {@link #getActiveModemCount} instead.
 * @apiSince 23
 * @deprecatedSince R
 */

@Deprecated
public int getPhoneCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of logical modems currently configured to be activated.
 *
 * Returns 0 if none of voice, sms, data is not supported
 * Returns 1 for Single standby mode (Single SIM functionality).
 * Returns 2 for Dual standby mode (Dual SIM functionality).
 * Returns 3 for Tri standby mode (Tri SIM functionality).
 
 * @return Value is {@link android.telephony.TelephonyManager#MODEM_COUNT_NO_MODEM}, {@link android.telephony.TelephonyManager#MODEM_COUNT_SINGLE_MODEM}, {@link android.telephony.TelephonyManager#MODEM_COUNT_DUAL_MODEM}, or {@link android.telephony.TelephonyManager#MODEM_COUNT_TRI_MODEM}
 * @apiSince R
 */

public int getActiveModemCount() { throw new RuntimeException("Stub!"); }

/**
 * Return how many logical modem can be potentially active simultaneously, in terms of hardware
 * capability.
 * It might return different value from {@link #getActiveModemCount}. For example, for a
 * dual-SIM capable device operating in single SIM mode (only one logical modem is turned on),
 * {@link #getActiveModemCount} returns 1 while this API returns 2.
 
 * @return Value is {@link android.telephony.TelephonyManager#MODEM_COUNT_NO_MODEM}, {@link android.telephony.TelephonyManager#MODEM_COUNT_SINGLE_MODEM}, {@link android.telephony.TelephonyManager#MODEM_COUNT_DUAL_MODEM}, or {@link android.telephony.TelephonyManager#MODEM_COUNT_TRI_MODEM}
 * @apiSince R
 */

public int getSupportedModemCount() { throw new RuntimeException("Stub!"); }

/**
 * Create a new TelephonyManager object pinned to the given subscription ID.
 *
 * @return a TelephonyManager that uses the given subId for all calls.
 * @apiSince 24
 */

public android.telephony.TelephonyManager createForSubscriptionId(int subId) { throw new RuntimeException("Stub!"); }

/**
 * Create a new TelephonyManager object pinned to the subscription ID associated with the given
 * phone account.
 *
 * @return a TelephonyManager that uses the given phone account for all calls, or {@code null}
 * if the phone account does not correspond to a valid subscription ID.
 * @apiSince 26
 */

@androidx.annotation.Nullable
public android.telephony.TelephonyManager createForPhoneAccountHandle(android.telecom.PhoneAccountHandle phoneAccountHandle) { throw new RuntimeException("Stub!"); }

/**
 * Returns the software version number for the device, for example,
 * the IMEI/SV for GSM phones. Return null if the software version is
 * not available.
 * <p>
 * Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}.
 
 * <br>
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.lang.String getDeviceSoftwareVersion() { throw new RuntimeException("Stub!"); }

/**
 * Returns the unique device ID, for example, the IMEI for GSM and the MEID
 * or ESN for CDMA phones. Return null if device ID is not available.
 *
 * <p>Requires Permission: READ_PRIVILEGED_PHONE_STATE, for the calling app to be the device or
 * profile owner and have the READ_PHONE_STATE permission, or that the calling app has carrier
 * privileges (see {@link #hasCarrierPrivileges}) on any active subscription. The profile owner
 * is an app that owns a managed profile on the device; for more details see <a
 * href="https://developer.android.com/work/managed-profiles">Work profiles</a>. Profile owner
 * access is deprecated and will be removed in a future release.
 *
 * <p>If the calling app does not meet one of these requirements then this method will behave
 * as follows:
 *
 * <ul>
 *     <li>If the calling app's target SDK is API level 28 or lower and the app has the
 *     READ_PHONE_STATE permission then null is returned.</li>
 *     <li>If the calling app's target SDK is API level 28 or lower and the app does not have
 *     the READ_PHONE_STATE permission, or if the calling app is targeting API level 29 or
 *     higher, then a SecurityException is thrown.</li>
 * </ul>
 *
 * <br>
 * Requires android.Manifest.permission.READ_PRIVILEGED_PHONE_STATE
 * @deprecated Use {@link #getImei} which returns IMEI for GSM or {@link #getMeid} which returns
 * MEID for CDMA.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public java.lang.String getDeviceId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the unique device ID of a subscription, for example, the IMEI for
 * GSM and the MEID for CDMA phones. Return null if device ID is not available.
 *
 * <p>Requires Permission: READ_PRIVILEGED_PHONE_STATE, for the calling app to be the device or
 * profile owner and have the READ_PHONE_STATE permission, or that the calling app has carrier
 * privileges (see {@link #hasCarrierPrivileges}) on any active subscription. The profile owner
 * is an app that owns a managed profile on the device; for more details see <a
 * href="https://developer.android.com/work/managed-profiles">Work profiles</a>. Profile owner
 * access is deprecated and will be removed in a future release.
 *
 * <p>If the calling app does not meet one of these requirements then this method will behave
 * as follows:
 *
 * <ul>
 *     <li>If the calling app's target SDK is API level 28 or lower and the app has the
 *     READ_PHONE_STATE permission then null is returned.</li>
 *     <li>If the calling app's target SDK is API level 28 or lower and the app does not have
 *     the READ_PHONE_STATE permission, or if the calling app is targeting API level 29 or
 *     higher, then a SecurityException is thrown.</li>
 * </ul>
 *
 * <br>
 * Requires android.Manifest.permission.READ_PRIVILEGED_PHONE_STATE
 * @param slotIndex of which deviceID is returned
 *
 * @deprecated Use {@link #getImei} which returns IMEI for GSM or {@link #getMeid} which returns
 * MEID for CDMA.
 * @apiSince 23
 * @deprecatedSince 26
 */

@Deprecated
public java.lang.String getDeviceId(int slotIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns the IMEI (International Mobile Equipment Identity). Return null if IMEI is not
 * available.
 *
 * See {@link #getImei(int)} for details on the required permissions and behavior
 * when the caller does not hold sufficient permissions.
 
 * <br>
 * Requires android.Manifest.permission.READ_PRIVILEGED_PHONE_STATE
 * @apiSince 26
 */

public java.lang.String getImei() { throw new RuntimeException("Stub!"); }

/**
 * Returns the IMEI (International Mobile Equipment Identity). Return null if IMEI is not
 * available.
 *
 * <p>This API requires one of the following:
 * <ul>
 *     <li>The caller holds the READ_PRIVILEGED_PHONE_STATE permission.</li>
 *     <li>If the caller is the device or profile owner, the caller holds the
 *     {@link android.Manifest.permission#READ_PHONE_STATE Manifest.permission#READ_PHONE_STATE} permission.</li>
 *     <li>The caller has carrier privileges (see {@link #hasCarrierPrivileges()} on any
 *     active subscription.</li>
 *     <li>The caller is the default SMS app for the device.</li>
 * </ul>
 * <p>The profile owner is an app that owns a managed profile on the device; for more details
 * see <a href="https://developer.android.com/work/managed-profiles">Work profiles</a>.
 * Access by profile owners is deprecated and will be removed in a future release.
 *
 * <p>If the calling app does not meet one of these requirements then this method will behave
 * as follows:
 *
 * <ul>
 *     <li>If the calling app's target SDK is API level 28 or lower and the app has the
 *     READ_PHONE_STATE permission then null is returned.</li>
 *     <li>If the calling app's target SDK is API level 28 or lower and the app does not have
 *     the READ_PHONE_STATE permission, or if the calling app is targeting API level 29 or
 *     higher, then a SecurityException is thrown.</li>
 * </ul>
 *
 * <br>
 * Requires android.Manifest.permission.READ_PRIVILEGED_PHONE_STATE
 * @param slotIndex of which IMEI is returned
 * @apiSince 26
 */

public java.lang.String getImei(int slotIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns the Type Allocation Code from the IMEI. Return null if Type Allocation Code is not
 * available.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.lang.String getTypeAllocationCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns the Type Allocation Code from the IMEI. Return null if Type Allocation Code is not
 * available.
 *
 * @param slotIndex of which Type Allocation Code is returned
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.lang.String getTypeAllocationCode(int slotIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns the MEID (Mobile Equipment Identifier). Return null if MEID is not available.
 *
 * <p>Requires Permission: READ_PRIVILEGED_PHONE_STATE, for the calling app to be the device or
 * profile owner and have the READ_PHONE_STATE permission, or that the calling app has carrier
 * privileges (see {@link #hasCarrierPrivileges}) on any active subscription. The profile owner
 * is an app that owns a managed profile on the device; for more details see <a
 * href="https://developer.android.com/work/managed-profiles">Work profiles</a>. Profile owner
 * access is deprecated and will be removed in a future release.
 *
 * <p>If the calling app does not meet one of these requirements then this method will behave
 * as follows:
 *
 * <ul>
 *     <li>If the calling app's target SDK is API level 28 or lower and the app has the
 *     READ_PHONE_STATE permission then null is returned.</li>
 *     <li>If the calling app's target SDK is API level 28 or lower and the app does not have
 *     the READ_PHONE_STATE permission, or if the calling app is targeting API level 29 or
 *     higher, then a SecurityException is thrown.</li>
 * </ul>
 
 * <br>
 * Requires android.Manifest.permission.READ_PRIVILEGED_PHONE_STATE
 * @apiSince 26
 */

public java.lang.String getMeid() { throw new RuntimeException("Stub!"); }

/**
 * Returns the MEID (Mobile Equipment Identifier). Return null if MEID is not available.
 *
 * <p>Requires Permission: READ_PRIVILEGED_PHONE_STATE, for the calling app to be the device or
 * profile owner and have the READ_PHONE_STATE permission, or that the calling app has carrier
 * privileges (see {@link #hasCarrierPrivileges}) on any active subscription. The profile owner
 * is an app that owns a managed profile on the device; for more details see <a
 * href="https://developer.android.com/work/managed-profiles">Work profiles</a>. Profile owner
 * access is deprecated and will be removed in a future release.
 *
 * <p>If the calling app does not meet one of these requirements then this method will behave
 * as follows:
 *
 * <ul>
 *     <li>If the calling app's target SDK is API level 28 or lower and the app has the
 *     READ_PHONE_STATE permission then null is returned.</li>
 *     <li>If the calling app's target SDK is API level 28 or lower and the app does not have
 *     the READ_PHONE_STATE permission, or if the calling app is targeting API level 29 or
 *     higher, then a SecurityException is thrown.</li>
 * </ul>
 *
 * <br>
 * Requires android.Manifest.permission.READ_PRIVILEGED_PHONE_STATE
 * @param slotIndex of which MEID is returned
 * @apiSince 26
 */

public java.lang.String getMeid(int slotIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns the Manufacturer Code from the MEID. Return null if Manufacturer Code is not
 * available.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.lang.String getManufacturerCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns the Manufacturer Code from the MEID. Return null if Manufacturer Code is not
 * available.
 *
 * @param slotIndex of which Type Allocation Code is returned
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.lang.String getManufacturerCode(int slotIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns the Network Access Identifier (NAI). Return null if NAI is not available.
 *
 * <p>Requires Permission: READ_PRIVILEGED_PHONE_STATE, for the calling app to be the device or
 * profile owner and have the READ_PHONE_STATE permission, or that the calling app has carrier
 * privileges (see {@link #hasCarrierPrivileges}). The profile owner is an app that owns a
 * managed profile on the device; for more details see <a
 * href="https://developer.android.com/work/managed-profiles">Work profiles</a>. Profile owner
 * access is deprecated and will be removed in a future release.
 *
 * <ul>
 *     <li>If the calling app's target SDK is API level 28 or lower and the app has the
 *     READ_PHONE_STATE permission then null is returned.</li>
 *     <li>If the calling app's target SDK is API level 28 or lower and the app does not have
 *     the READ_PHONE_STATE permission, or if the calling app is targeting API level 29 or
 *     higher, then a SecurityException is thrown.</li>
 * </ul>
 
 * <br>
 * Requires android.Manifest.permission.READ_PRIVILEGED_PHONE_STATE
 * @apiSince 28
 */

public java.lang.String getNai() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current location of the device.
 *<p>
 * If there is only one radio in the device and that radio has an LTE connection,
 * this method will return null. The implementation must not to try add LTE
 * identifiers into the existing cdma/gsm classes.
 *<p>
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @return Current location of the device or null if not available.
 *
 * @deprecated use {@link #getAllCellInfo} instead, which returns a superset of this API.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public android.telephony.CellLocation getCellLocation() { throw new RuntimeException("Stub!"); }

/**
 * Returns a constant indicating the device phone type.  This
 * indicates the type of radio used to transmit voice calls.
 *
 * @see #PHONE_TYPE_NONE
 * @see #PHONE_TYPE_GSM
 * @see #PHONE_TYPE_CDMA
 * @see #PHONE_TYPE_SIP
 * @apiSince 1
 */

public int getPhoneType() { throw new RuntimeException("Stub!"); }

/**
 * Returns the alphabetic name of current registered operator.
 * <p>
 * Availability: Only when user is registered to a network. Result may be
 * unreliable on CDMA networks (use {@link #getPhoneType()} to determine if
 * on a CDMA network).
 * @apiSince 1
 */

public java.lang.String getNetworkOperatorName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the numeric name (MCC+MNC) of current registered operator.
 * <p>
 * Availability: Only when user is registered to a network. Result may be
 * unreliable on CDMA networks (use {@link #getPhoneType()} to determine if
 * on a CDMA network).
 * @apiSince 1
 */

public java.lang.String getNetworkOperator() { throw new RuntimeException("Stub!"); }

/**
 * Returns the network specifier of the subscription ID pinned to the TelephonyManager. The
 * network specifier is used by {@link
 * android.net.NetworkRequest.Builder#setNetworkSpecifier(String)} to create a {@link
 * android.net.NetworkRequest} that connects through the subscription.
 *
 * @see android.net.NetworkRequest.Builder#setNetworkSpecifier(String)
 * @see #createForSubscriptionId(int)
 * @see #createForPhoneAccountHandle(PhoneAccountHandle)
 * @apiSince 26
 */

public java.lang.String getNetworkSpecifier() { throw new RuntimeException("Stub!"); }

/**
 * Returns the carrier config of the subscription ID pinned to the TelephonyManager. If an
 * invalid subscription ID is pinned to the TelephonyManager, the returned config will contain
 * default values.
 *
 * <p>This method may take several seconds to complete, so it should only be called from a
 * worker thread.
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * <br>
 * This method may take several seconds to complete, so it should
 * only be called from a worker thread.
 * <br>
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @see android.telephony.CarrierConfigManager#getConfigForSubId(int)
 * @see #createForSubscriptionId(int)
 * @see #createForPhoneAccountHandle(PhoneAccountHandle)
 * @apiSince 26
 */

public android.os.PersistableBundle getCarrierConfig() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the device is considered roaming on the current
 * network, for GSM purposes.
 * <p>
 * Availability: Only when user registered to a network.
 * @apiSince 1
 */

public boolean isNetworkRoaming() { throw new RuntimeException("Stub!"); }

/**
 * Returns the ISO-3166 country code equivalent of the MCC (Mobile Country Code) of the current
 * registered operator or the cell nearby, if available.
 * <p>
 * The ISO-3166 country code is provided in lowercase 2 character format.
 * <p>
 * Note: In multi-sim, this returns a shared emergency network country iso from other
 * subscription if the subscription used to create the TelephonyManager doesn't camp on
 * a network due to some reason (e.g. pin/puk locked), or sim is absent in the corresponding
 * slot.
 * Note: Result may be unreliable on CDMA networks (use {@link #getPhoneType()} to determine
 * if on a CDMA network).
 * <p>
 * @return the lowercase 2 character ISO-3166 country code, or empty string if not available.
 * @apiSince 1
 */

public java.lang.String getNetworkCountryIso() { throw new RuntimeException("Stub!"); }

/**
 * Return a collection of all network types
 * @return network types
 
 * This value will never be {@code null}.
 
 * Value is {@link android.telephony.TelephonyManager#NETWORK_TYPE_UNKNOWN}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_GPRS}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_EDGE}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_UMTS}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_CDMA}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_EVDO_0}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_EVDO_A}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_1xRTT}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_HSDPA}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_HSUPA}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_HSPA}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_IDEN}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_EVDO_B}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_LTE}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_EHRPD}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_HSPAP}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_GSM}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_TD_SCDMA}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_IWLAN}, or {@link android.telephony.TelephonyManager#NETWORK_TYPE_NR}
 * @apiSince R
 */

@androidx.annotation.NonNull
public static int[] getAllNetworkTypes() { throw new RuntimeException("Stub!"); }

/**
 * Return the current data network type.
 *
 * <br>
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @deprecated use {@link #getDataNetworkType()}
 * @return the NETWORK_TYPE_xxxx for current data connection.
 
 * Value is {@link android.telephony.TelephonyManager#NETWORK_TYPE_UNKNOWN}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_GPRS}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_EDGE}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_UMTS}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_CDMA}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_EVDO_0}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_EVDO_A}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_1xRTT}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_HSDPA}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_HSUPA}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_HSPA}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_IDEN}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_EVDO_B}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_LTE}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_EHRPD}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_HSPAP}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_GSM}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_TD_SCDMA}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_IWLAN}, or {@link android.telephony.TelephonyManager#NETWORK_TYPE_NR}
 * @apiSince 1
 * @deprecatedSince R
 */

@Deprecated
public int getNetworkType() { throw new RuntimeException("Stub!"); }

/**
 * Returns a constant indicating the radio technology (network type)
 * currently in use on the device for data transmission.
 *
 * If this object has been created with {@link #createForSubscriptionId}, applies to the given
 * subId. Otherwise, applies to {@link android.telephony.SubscriptionManager#getDefaultDataSubscriptionId() SubscriptionManager#getDefaultDataSubscriptionId()}
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * <br>
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @return the network type
 *
 * Value is {@link android.telephony.TelephonyManager#NETWORK_TYPE_UNKNOWN}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_GPRS}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_EDGE}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_UMTS}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_CDMA}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_EVDO_0}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_EVDO_A}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_1xRTT}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_HSDPA}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_HSUPA}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_HSPA}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_IDEN}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_EVDO_B}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_LTE}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_EHRPD}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_HSPAP}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_GSM}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_TD_SCDMA}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_IWLAN}, or {@link android.telephony.TelephonyManager#NETWORK_TYPE_NR}
 * @see #NETWORK_TYPE_UNKNOWN
 * @see #NETWORK_TYPE_GPRS
 * @see #NETWORK_TYPE_EDGE
 * @see #NETWORK_TYPE_UMTS
 * @see #NETWORK_TYPE_HSDPA
 * @see #NETWORK_TYPE_HSUPA
 * @see #NETWORK_TYPE_HSPA
 * @see #NETWORK_TYPE_CDMA
 * @see #NETWORK_TYPE_EVDO_0
 * @see #NETWORK_TYPE_EVDO_A
 * @see #NETWORK_TYPE_EVDO_B
 * @see #NETWORK_TYPE_1xRTT
 * @see #NETWORK_TYPE_IDEN
 * @see #NETWORK_TYPE_LTE
 * @see #NETWORK_TYPE_EHRPD
 * @see #NETWORK_TYPE_HSPAP
 * @see #NETWORK_TYPE_NR
 * @apiSince 24
 */

public int getDataNetworkType() { throw new RuntimeException("Stub!"); }

/**
 * Returns the NETWORK_TYPE_xxxx for voice
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).
 
 * <br>
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 
 * @return Value is {@link android.telephony.TelephonyManager#NETWORK_TYPE_UNKNOWN}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_GPRS}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_EDGE}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_UMTS}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_CDMA}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_EVDO_0}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_EVDO_A}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_1xRTT}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_HSDPA}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_HSUPA}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_HSPA}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_IDEN}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_EVDO_B}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_LTE}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_EHRPD}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_HSPAP}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_GSM}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_TD_SCDMA}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_IWLAN}, or {@link android.telephony.TelephonyManager#NETWORK_TYPE_NR}
 * @apiSince 24
 */

public int getVoiceNetworkType() { throw new RuntimeException("Stub!"); }

/**
 * @return true if a ICC card is present
 * @apiSince 5
 */

public boolean hasIccCard() { throw new RuntimeException("Stub!"); }

/**
 * Returns a constant indicating the state of the default SIM card.
 *
 * @see #SIM_STATE_UNKNOWN
 * @see #SIM_STATE_ABSENT
 * @see #SIM_STATE_PIN_REQUIRED
 * @see #SIM_STATE_PUK_REQUIRED
 * @see #SIM_STATE_NETWORK_LOCKED
 * @see #SIM_STATE_READY
 * @see #SIM_STATE_NOT_READY
 * @see #SIM_STATE_PERM_DISABLED
 * @see #SIM_STATE_CARD_IO_ERROR
 * @see #SIM_STATE_CARD_RESTRICTED
 
 * @return Value is {@link android.telephony.TelephonyManager#SIM_STATE_UNKNOWN}, {@link android.telephony.TelephonyManager#SIM_STATE_ABSENT}, {@link android.telephony.TelephonyManager#SIM_STATE_PIN_REQUIRED}, {@link android.telephony.TelephonyManager#SIM_STATE_PUK_REQUIRED}, {@link android.telephony.TelephonyManager#SIM_STATE_NETWORK_LOCKED}, {@link android.telephony.TelephonyManager#SIM_STATE_READY}, {@link android.telephony.TelephonyManager#SIM_STATE_NOT_READY}, {@link android.telephony.TelephonyManager#SIM_STATE_PERM_DISABLED}, {@link android.telephony.TelephonyManager#SIM_STATE_CARD_IO_ERROR}, {@link android.telephony.TelephonyManager#SIM_STATE_CARD_RESTRICTED}, android.telephony.TelephonyManager.SIM_STATE_LOADED, or android.telephony.TelephonyManager.SIM_STATE_PRESENT
 * @apiSince 1
 */

public int getSimState() { throw new RuntimeException("Stub!"); }

/**
 * Returns a constant indicating the state of the device SIM card in a logical slot.
 *
 * @param slotIndex logical slot index
 *
 * @see #SIM_STATE_UNKNOWN
 * @see #SIM_STATE_ABSENT
 * @see #SIM_STATE_PIN_REQUIRED
 * @see #SIM_STATE_PUK_REQUIRED
 * @see #SIM_STATE_NETWORK_LOCKED
 * @see #SIM_STATE_READY
 * @see #SIM_STATE_NOT_READY
 * @see #SIM_STATE_PERM_DISABLED
 * @see #SIM_STATE_CARD_IO_ERROR
 * @see #SIM_STATE_CARD_RESTRICTED
 
 * @return Value is {@link android.telephony.TelephonyManager#SIM_STATE_UNKNOWN}, {@link android.telephony.TelephonyManager#SIM_STATE_ABSENT}, {@link android.telephony.TelephonyManager#SIM_STATE_PIN_REQUIRED}, {@link android.telephony.TelephonyManager#SIM_STATE_PUK_REQUIRED}, {@link android.telephony.TelephonyManager#SIM_STATE_NETWORK_LOCKED}, {@link android.telephony.TelephonyManager#SIM_STATE_READY}, {@link android.telephony.TelephonyManager#SIM_STATE_NOT_READY}, {@link android.telephony.TelephonyManager#SIM_STATE_PERM_DISABLED}, {@link android.telephony.TelephonyManager#SIM_STATE_CARD_IO_ERROR}, {@link android.telephony.TelephonyManager#SIM_STATE_CARD_RESTRICTED}, android.telephony.TelephonyManager.SIM_STATE_LOADED, or android.telephony.TelephonyManager.SIM_STATE_PRESENT
 * @apiSince 26
 */

public int getSimState(int slotIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns the MCC+MNC (mobile country code + mobile network code) of the
 * provider of the SIM. 5 or 6 decimal digits.
 * <p>
 * Availability: SIM state must be {@link #SIM_STATE_READY}
 *
 * @see #getSimState
 * @apiSince 1
 */

public java.lang.String getSimOperator() { throw new RuntimeException("Stub!"); }

/**
 * Returns the Service Provider Name (SPN).
 * <p>
 * Availability: SIM state must be {@link #SIM_STATE_READY}
 *
 * @see #getSimState
 * @apiSince 1
 */

public java.lang.String getSimOperatorName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the ISO-3166 country code equivalent for the SIM provider's country code.
 * <p>
 * The ISO-3166 country code is provided in lowercase 2 character format.
 * @return the lowercase 2 character ISO-3166 country code, or empty string is not available.
 * @apiSince 1
 */

public java.lang.String getSimCountryIso() { throw new RuntimeException("Stub!"); }

/**
 * Returns the serial number of the SIM, if applicable. Return null if it is
 * unavailable.
 *
 * <p>Requires Permission: READ_PRIVILEGED_PHONE_STATE, for the calling app to be the device or
 * profile owner and have the READ_PHONE_STATE permission, or that the calling app has carrier
 * privileges (see {@link #hasCarrierPrivileges}). The profile owner is an app that owns a
 * managed profile on the device; for more details see <a
 * href="https://developer.android.com/work/managed-profiles">Work profiles</a>. Profile owner
 * access is deprecated and will be removed in a future release.
 *
 * <p>If the calling app does not meet one of these requirements then this method will behave
 * as follows:
 *
 * <ul>
 *     <li>If the calling app's target SDK is API level 28 or lower and the app has the
 *     READ_PHONE_STATE permission then null is returned.</li>
 *     <li>If the calling app's target SDK is API level 28 or lower and the app does not have
 *     the READ_PHONE_STATE permission, or if the calling app is targeting API level 29 or
 *     higher, then a SecurityException is thrown.</li>
 * </ul>
 
 * <br>
 * Requires android.Manifest.permission.READ_PRIVILEGED_PHONE_STATE
 * @apiSince 1
 */

public java.lang.String getSimSerialNumber() { throw new RuntimeException("Stub!"); }

/**
 * Get the card ID of the default eUICC card. If the eUICCs have not yet been loaded, returns
 * {@link #UNINITIALIZED_CARD_ID}. If there is no eUICC or the device does not support card IDs
 * for eUICCs, returns {@link #UNSUPPORTED_CARD_ID}.
 *
 * <p>The card ID is a unique identifier associated with a UICC or eUICC card. Card IDs are
 * unique to a device, and always refer to the same UICC or eUICC card unless the device goes
 * through a factory reset.
 *
 * @return card ID of the default eUICC card, if loaded.
 * @apiSince 29
 */

public int getCardIdForDefaultEuicc() { throw new RuntimeException("Stub!"); }

/**
 * Gets information about currently inserted UICCs and eUICCs.
 * <p>
 * Requires that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).
 * <p>
 * If the caller has carrier priviliges on any active subscription, then they have permission to
 * get simple information like the card ID ({@link android.telephony.UiccCardInfo#getCardId() UiccCardInfo#getCardId()}), whether the card
 * is an eUICC ({@link android.telephony.UiccCardInfo#isEuicc() UiccCardInfo#isEuicc()}), and the slot index where the card is inserted
 * ({@link android.telephony.UiccCardInfo#getSlotIndex() UiccCardInfo#getSlotIndex()}).
 * <p>
 * To get private information such as the EID ({@link android.telephony.UiccCardInfo#getEid() UiccCardInfo#getEid()}) or ICCID
 * ({@link android.telephony.UiccCardInfo#getIccId() UiccCardInfo#getIccId()}), the caller must have carrier priviliges on that specific
 * UICC or eUICC card.
 * <p>
 * See {@link android.telephony.UiccCardInfo UiccCardInfo} for more details on the kind of information available.
 *
 * <br>
 * Requires android.Manifest.permission.READ_PRIVILEGED_PHONE_STATE
 * @return a list of UiccCardInfo objects, representing information on the currently inserted
 * UICCs and eUICCs. Each UiccCardInfo in the list will have private information filtered out if
 * the caller does not have adequate permissions for that card.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.util.List<android.telephony.UiccCardInfo> getUiccCardsInfo() { throw new RuntimeException("Stub!"); }

/**
 * Returns the unique subscriber ID, for example, the IMSI for a GSM phone.
 * Return null if it is unavailable.
 *
 * <p>Requires Permission: READ_PRIVILEGED_PHONE_STATE, for the calling app to be the device or
 * profile owner and have the READ_PHONE_STATE permission, or that the calling app has carrier
 * privileges (see {@link #hasCarrierPrivileges}). The profile owner is an app that owns a
 * managed profile on the device; for more details see <a
 * href="https://developer.android.com/work/managed-profiles">Work profiles</a>. Profile owner
 * access is deprecated and will be removed in a future release.
 *
 * <p>If the calling app does not meet one of these requirements then this method will behave
 * as follows:
 *
 * <ul>
 *     <li>If the calling app's target SDK is API level 28 or lower and the app has the
 *     READ_PHONE_STATE permission then null is returned.</li>
 *     <li>If the calling app's target SDK is API level 28 or lower and the app does not have
 *     the READ_PHONE_STATE permission, or if the calling app is targeting API level 29 or
 *     higher, then a SecurityException is thrown.</li>
 * </ul>
 
 * <br>
 * Requires android.Manifest.permission.READ_PRIVILEGED_PHONE_STATE
 * @apiSince 1
 */

public java.lang.String getSubscriberId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the Group Identifier Level1 for a GSM phone.
 * Return null if it is unavailable.
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).
 
 * <br>
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @apiSince 18
 */

public java.lang.String getGroupIdLevel1() { throw new RuntimeException("Stub!"); }

/**
 * Returns the phone number string for line 1, for example, the MSISDN
 * for a GSM phone. Return null if it is unavailable.
 *
 * <p>Requires Permission:
 *     {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE},
 *     {@link android.Manifest.permission#READ_SMS READ_SMS},
 *     {@link android.Manifest.permission#READ_PHONE_NUMBERS READ_PHONE_NUMBERS},
 *     that the caller is the default SMS app,
 *     or that the caller has carrier privileges (see {@link #hasCarrierPrivileges}).
 
 * <br>
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE} or {@link android.Manifest.permission#READ_SMS} or {@link android.Manifest.permission#READ_PHONE_NUMBERS}
 * @apiSince 1
 */

public java.lang.String getLine1Number() { throw new RuntimeException("Stub!"); }

/**
 * Set the line 1 phone number string and its alphatag for the current ICCID
 * for display purpose only, for example, displayed in Phone Status. It won't
 * change the actual MSISDN/MDN. To unset alphatag or number, pass in a null
 * value.
 *
 * <p>Requires that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * @param alphaTag alpha-tagging of the dailing nubmer
 * @param number The dialing number
 * @return true if the operation was executed correctly.
 * @apiSince 22
 */

public boolean setLine1NumberForDisplay(java.lang.String alphaTag, java.lang.String number) { throw new RuntimeException("Stub!"); }

/**
 * Returns the voice mail number. Return null if it is unavailable.
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).
 
 * <br>
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @apiSince 1
 */

public java.lang.String getVoiceMailNumber() { throw new RuntimeException("Stub!"); }

/**
 * Sets the voice mail number.
 *
 * <p>Requires that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * @param alphaTag The alpha tag to display.
 * @param number The voicemail number.
 * @apiSince 22
 */

public boolean setVoiceMailNumber(java.lang.String alphaTag, java.lang.String number) { throw new RuntimeException("Stub!"); }

/**
 * Returns the package responsible of processing visual voicemail for the subscription ID pinned
 * to the TelephonyManager. Returns {@code null} when there is no package responsible for
 * processing visual voicemail for the subscription.
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * <br>
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @see #createForSubscriptionId(int)
 * @see #createForPhoneAccountHandle(PhoneAccountHandle)
 * @see android.telephony.VisualVoicemailService
 * @apiSince 26
 */

@androidx.annotation.Nullable
public java.lang.String getVisualVoicemailPackageName() { throw new RuntimeException("Stub!"); }

/**
 * Set the visual voicemail SMS filter settings for the subscription ID pinned
 * to the TelephonyManager.
 * When the filter is enabled, {@link android.telephony.VisualVoicemailService#onSmsReceived(android.telephony.VisualVoicemailService.VisualVoicemailTask,android.telephony.VisualVoicemailSms) VisualVoicemailService#onSmsReceived(VisualVoicemailTask, VisualVoicemailSms)} will be
 * called when a SMS matching the settings is received. Caller must be the default dialer,
 * system dialer, or carrier visual voicemail app.
 *
 * @param settings The settings for the filter, or {@code null} to disable the filter.
 *
 * @see android.telecom.TelecomManager#getDefaultDialerPackage()
 * @see android.telephony.CarrierConfigManager#KEY_CARRIER_VVM_PACKAGE_NAME_STRING_ARRAY
 * @apiSince 26
 */

public void setVisualVoicemailSmsFilterSettings(android.telephony.VisualVoicemailSmsFilterSettings settings) { throw new RuntimeException("Stub!"); }

/**
 * Send a visual voicemail SMS. The caller must be the current default dialer.
 * A {@link android.telephony.VisualVoicemailService VisualVoicemailService} uses this method to send a command via SMS to the carrier's
 * visual voicemail server.  Some examples for carriers using the OMTP standard include
 * activating and deactivating visual voicemail, or requesting the current visual voicemail
 * provisioning status.  See the OMTP Visual Voicemail specification for more information on the
 * format of these SMS messages.
 *
 * <p>Requires Permission:
 * {@link android.Manifest.permission#SEND_SMS SEND_SMS}
 *
 * @param number The destination number.
 * @param port The destination port for data SMS, or 0 for text SMS.
 * @param text The message content. For data sms, it will be encoded as a UTF-8 byte stream.
 * @param sentIntent The sent intent passed to the {@link android.telephony.SmsManager SmsManager}
 *
 * @throws java.lang.SecurityException if the caller is not the current default dialer
 *
 * @see android.telephony.SmsManager#sendDataMessage(String, String, short, byte[], PendingIntent, PendingIntent)
 * @see android.telephony.SmsManager#sendTextMessage(String, String, String, PendingIntent, PendingIntent)
 * @apiSince 26
 */

public void sendVisualVoicemailSms(java.lang.String number, int port, java.lang.String text, android.app.PendingIntent sentIntent) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the alphabetic identifier associated with the voice
 * mail number.
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).
 
 * <br>
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @apiSince 1
 */

public java.lang.String getVoiceMailAlphaTag() { throw new RuntimeException("Stub!"); }

/**
 * Send the special dialer code. The IPC caller must be the current default dialer or have
 * carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * @param inputCode The special dialer code to send
 *
 * @throws java.lang.SecurityException if the caller does not have carrier privileges or is not the
 *         current default dialer
 * @apiSince 26
 */

public void sendDialerSpecialCode(java.lang.String inputCode) { throw new RuntimeException("Stub!"); }

/**
 * Returns the state of all calls on the device.
 * <p>
 * This method considers not only calls in the Telephony stack, but also calls via other
 * {@link android.telecom.ConnectionService} implementations.
 * <p>
 * Note: The call state returned via this method may differ from what is reported by
 * {@link android.telephony.PhoneStateListener#onCallStateChanged(int,java.lang.String) PhoneStateListener#onCallStateChanged(int, String)}, as that callback only considers
 * Telephony (mobile) calls.
 *
 * @return the current call state.
 
 * Value is {@link android.telephony.TelephonyManager#CALL_STATE_IDLE}, {@link android.telephony.TelephonyManager#CALL_STATE_RINGING}, or {@link android.telephony.TelephonyManager#CALL_STATE_OFFHOOK}
 * @apiSince 1
 */

public int getCallState() { throw new RuntimeException("Stub!"); }

/**
 * Returns a constant indicating the type of activity on a data connection
 * (cellular).
 *
 * @see #DATA_ACTIVITY_NONE
 * @see #DATA_ACTIVITY_IN
 * @see #DATA_ACTIVITY_OUT
 * @see #DATA_ACTIVITY_INOUT
 * @see #DATA_ACTIVITY_DORMANT
 * @apiSince 1
 */

public int getDataActivity() { throw new RuntimeException("Stub!"); }

/**
 * Returns a constant indicating the current data connection state
 * (cellular).
 *
 * @see #DATA_DISCONNECTED
 * @see #DATA_CONNECTING
 * @see #DATA_CONNECTED
 * @see #DATA_SUSPENDED
 * @see #DATA_DISCONNECTING
 * @apiSince 1
 */

public int getDataState() { throw new RuntimeException("Stub!"); }

/**
 * Registers a listener object to receive notification of changes
 * in specified telephony states.
 * <p>
 * To register a listener, pass a {@link android.telephony.PhoneStateListener PhoneStateListener} and specify at least one telephony
 * state of interest in the events argument.
 *
 * At registration, and when a specified telephony state changes, the telephony manager invokes
 * the appropriate callback method on the listener object and passes the current (updated)
 * values.
 * <p>
 * To un-register a listener, pass the listener object and set the events argument to
 * {@link android.telephony.PhoneStateListener#LISTEN_NONE PhoneStateListener#LISTEN_NONE} (0).
 *
 * If this TelephonyManager object has been created with {@link #createForSubscriptionId},
 * applies to the given subId. Otherwise, applies to
 * {@link android.telephony.SubscriptionManager#getDefaultSubscriptionId() SubscriptionManager#getDefaultSubscriptionId()}. To listen events for multiple subIds,
 * pass a separate listener object to each TelephonyManager object created with
 * {@link #createForSubscriptionId}.
 *
 * Note: if you call this method while in the middle of a binder transaction, you <b>must</b>
 * call {@link android.os.Binder#clearCallingIdentity()} before calling this method. A
 * {@link java.lang.SecurityException SecurityException} will be thrown otherwise.
 *
 * @param listener The {@link android.telephony.PhoneStateListener PhoneStateListener} object to register
 *                 (or unregister)
 * @param events The telephony state(s) of interest to the listener,
 *               as a bitwise-OR combination of {@link android.telephony.PhoneStateListener PhoneStateListener}
 *               LISTEN_ flags.
 * @apiSince 1
 */

public void listen(android.telephony.PhoneStateListener listener, int events) { throw new RuntimeException("Stub!"); }

/**
 * @return true if the current device is "voice capable".
 * <p>
 * "Voice capable" means that this device supports circuit-switched
 * (i.e. voice) phone calls over the telephony network, and is allowed
 * to display the in-call UI while a cellular voice call is active.
 * This will be false on "data only" devices which can't make voice
 * calls and don't support any in-call UI.
 * <p>
 * Note: the meaning of this flag is subtly different from the
 * PackageManager.FEATURE_TELEPHONY system feature, which is available
 * on any device with a telephony radio, even if the device is
 * data-only.
 * @apiSince 22
 */

public boolean isVoiceCapable() { throw new RuntimeException("Stub!"); }

/**
 * @return true if the current device supports sms service.
 * <p>
 * If true, this means that the device supports both sending and
 * receiving sms via the telephony network.
 * <p>
 * Note: Voicemail waiting sms, cell broadcasting sms, and MMS are
 *       disabled when device doesn't support sms.
 * @apiSince 21
 */

public boolean isSmsCapable() { throw new RuntimeException("Stub!"); }

/**
 * Requests all available cell information from all radios on the device including the
 * camped/registered, serving, and neighboring cells.
 *
 * <p>The response can include one or more {@link android.telephony.CellInfoGsm CellInfoGsm},
 * {@link android.telephony.CellInfoCdma CellInfoCdma},
 * {@link android.telephony.CellInfoTdscdma CellInfoTdscdma},
 * {@link android.telephony.CellInfoLte CellInfoLte}, and
 * {@link android.telephony.CellInfoWcdma CellInfoWcdma} objects, in any combination.
 * It is typical to see instances of one or more of any these in the list. In addition, zero
 * or more of the returned objects may be considered registered; that is, their
 * {@link android.telephony.CellInfo#isRegistered CellInfo.isRegistered()}
 * methods may return true, indicating that the cell is being used or would be used for
 * signaling communication if necessary.
 *
 * <p>Beginning with {@link android.os.Build.VERSION_CODES#Q Android Q},
 * if this API results in a change of the cached CellInfo, that change will be reported via
 * {@link android.telephony.PhoneStateListener#onCellInfoChanged onCellInfoChanged()}.
 *
 * <p>Apps targeting {@link android.os.Build.VERSION_CODES#Q Android Q} or higher will no
 * longer trigger a refresh of the cached CellInfo by invoking this API. Instead, those apps
 * will receive the latest cached results, which may not be current. Apps targeting
 * {@link android.os.Build.VERSION_CODES#Q Android Q} or higher that wish to request updated
 * CellInfo should call
 * {@link android.telephony.TelephonyManager#requestCellInfoUpdate requestCellInfoUpdate()};
 * however, in all cases, updates will be rate-limited and are not guaranteed. To determine the
 * recency of CellInfo data, callers should check
 * {@link android.telephony.CellInfo#getTimeStamp CellInfo#getTimeStamp()}.
 *
 * <p>This method returns valid data for devices with
 * {@link android.content.pm.PackageManager#FEATURE_TELEPHONY FEATURE_TELEPHONY}. In cases
 * where only partial information is available for a particular CellInfo entry, unavailable
 * fields will be reported as {@link android.telephony.CellInfo#UNAVAILABLE}. All reported
 * cells will include at least a valid set of technology-specific identification info and a
 * power level measurement.
 *
 * <p>This method is preferred over using {@link
 * android.telephony.TelephonyManager#getCellLocation getCellLocation()}.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @return List of {@link android.telephony.CellInfo}; null if cell
 * information is unavailable.
 * @apiSince 17
 */

public java.util.List<android.telephony.CellInfo> getAllCellInfo() { throw new RuntimeException("Stub!"); }

/**
 * Requests all available cell information from the current subscription for observed
 * camped/registered, serving, and neighboring cells.
 *
 * <p>Any available results from this request will be provided by calls to
 * {@link android.telephony.PhoneStateListener#onCellInfoChanged onCellInfoChanged()}
 * for each active subscription.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @param executor the executor on which callback will be invoked.
 * This value must never be {@code null}.
 * Callback and listener events are dispatched through this
 * {@link java.util.concurrent.Executor Executor}, providing an easy way to control which thread is
 * used. To dispatch events through the main thread of your
 * application, you can use {@link android.content.Context#getMainExecutor() Context#getMainExecutor()}. To
 * dispatch events through a shared thread pool, you can use
 * {@link android.os.AsyncTask#THREAD_POOL_EXECUTOR AsyncTask#THREAD_POOL_EXECUTOR}.
 * @param callback a callback to receive CellInfo.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void requestCellInfoUpdate(@androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull android.telephony.TelephonyManager.CellInfoCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Returns the MMS user agent.
 * @apiSince 19
 */

public java.lang.String getMmsUserAgent() { throw new RuntimeException("Stub!"); }

/**
 * Returns the MMS user agent profile URL.
 * @apiSince 19
 */

public java.lang.String getMmsUAProfUrl() { throw new RuntimeException("Stub!"); }

/**
 * Opens a logical channel to the ICC card.
 *
 * Input parameters equivalent to TS 27.007 AT+CCHO command.
 *
 * <p>Requires Permission:
 * {@link android.Manifest.permission#MODIFY_PHONE_STATE MODIFY_PHONE_STATE} or that the calling
 * app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * @param AID Application id. See ETSI 102.221 and 101.220.
 * @return an IccOpenLogicalChannelResponse object.
 * @deprecated Replaced by {@link #iccOpenLogicalChannel(java.lang.String,int)}
 * @apiSince 21
 * @deprecatedSince 26
 */

@Deprecated
public android.telephony.IccOpenLogicalChannelResponse iccOpenLogicalChannel(java.lang.String AID) { throw new RuntimeException("Stub!"); }

/**
 * Opens a logical channel to the ICC card.
 *
 * This operation wraps two APDU instructions:
 * <ul>
 *     <li>MANAGE CHANNEL to open a logical channel</li>
 *     <li>SELECT the given {@code AID} using the given {@code p2}</li>
 * </ul>
 *
 * Per Open Mobile API Specification v3.2 section 6.2.7.h, only p2 values of 0x00, 0x04, 0x08,
 * and 0x0C are guaranteed to be supported.
 *
 * If the SELECT command's status word is not '9000', '62xx', or '63xx', the status word will be
 * considered an error and the channel shall not be opened.
 *
 * Input parameters equivalent to TS 27.007 AT+CCHO command.
 *
 * <p>Requires Permission:
 * {@link android.Manifest.permission#MODIFY_PHONE_STATE MODIFY_PHONE_STATE} or that the calling
 * app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * @param AID Application id. See ETSI 102.221 and 101.220.
 * @param p2 P2 parameter (described in ISO 7816-4).
 * @return an IccOpenLogicalChannelResponse object.
 * @apiSince 26
 */

public android.telephony.IccOpenLogicalChannelResponse iccOpenLogicalChannel(java.lang.String AID, int p2) { throw new RuntimeException("Stub!"); }

/**
 * Closes a previously opened logical channel to the ICC card.
 *
 * Input parameters equivalent to TS 27.007 AT+CCHC command.
 *
 * <p>Requires Permission:
 * {@link android.Manifest.permission#MODIFY_PHONE_STATE MODIFY_PHONE_STATE} or that the calling
 * app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * @param channel is the channel id to be closed as returned by a successful
 *            iccOpenLogicalChannel.
 * @return true if the channel was closed successfully.
 * @apiSince 21
 */

public boolean iccCloseLogicalChannel(int channel) { throw new RuntimeException("Stub!"); }

/**
 * Transmit an APDU to the ICC card over a logical channel.
 *
 * Input parameters equivalent to TS 27.007 AT+CGLA command.
 *
 * <p>Requires Permission:
 * {@link android.Manifest.permission#MODIFY_PHONE_STATE MODIFY_PHONE_STATE} or that the calling
 * app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * @param channel is the channel id to be closed as returned by a successful
 *            iccOpenLogicalChannel.
 * @param cla Class of the APDU command.
 * @param instruction Instruction of the APDU command.
 * @param p1 P1 value of the APDU command.
 * @param p2 P2 value of the APDU command.
 * @param p3 P3 value of the APDU command. If p3 is negative a 4 byte APDU
 *            is sent to the SIM.
 * @param data Data to be sent with the APDU.
 * @return The APDU response from the ICC card with the status appended at
 *            the end.
 * @apiSince 21
 */

public java.lang.String iccTransmitApduLogicalChannel(int channel, int cla, int instruction, int p1, int p2, int p3, java.lang.String data) { throw new RuntimeException("Stub!"); }

/**
 * Transmit an APDU to the ICC card over the basic channel.
 *
 * Input parameters equivalent to TS 27.007 AT+CSIM command.
 *
 * <p>Requires Permission:
 * {@link android.Manifest.permission#MODIFY_PHONE_STATE MODIFY_PHONE_STATE} or that the calling
 * app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * @param cla Class of the APDU command.
 * @param instruction Instruction of the APDU command.
 * @param p1 P1 value of the APDU command.
 * @param p2 P2 value of the APDU command.
 * @param p3 P3 value of the APDU command. If p3 is negative a 4 byte APDU
 *            is sent to the SIM.
 * @param data Data to be sent with the APDU.
 * @return The APDU response from the ICC card with the status appended at
 *            the end.
 * @apiSince 21
 */

public java.lang.String iccTransmitApduBasicChannel(int cla, int instruction, int p1, int p2, int p3, java.lang.String data) { throw new RuntimeException("Stub!"); }

/**
 * Returns the response APDU for a command APDU sent through SIM_IO.
 *
 * <p>Requires Permission:
 * {@link android.Manifest.permission#MODIFY_PHONE_STATE MODIFY_PHONE_STATE} or that the calling
 * app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * @param fileID
 * @param command
 * @param p1 P1 value of the APDU command.
 * @param p2 P2 value of the APDU command.
 * @param p3 P3 value of the APDU command.
 * @param filePath
 * @return The APDU response.
 * @apiSince 21
 */

public byte[] iccExchangeSimIO(int fileID, int command, int p1, int p2, int p3, java.lang.String filePath) { throw new RuntimeException("Stub!"); }

/**
 * Send ENVELOPE to the SIM and return the response.
 *
 * <p>Requires Permission:
 * {@link android.Manifest.permission#MODIFY_PHONE_STATE MODIFY_PHONE_STATE} or that the calling
 * app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * @param content String containing SAT/USAT response in hexadecimal
 *                format starting with command tag. See TS 102 223 for
 *                details.
 * @return The APDU response from the ICC card in hexadecimal format
 *         with the last 4 bytes being the status word. If the command fails,
 *         returns an empty string.
 * @apiSince 21
 */

public java.lang.String sendEnvelopeWithStatus(java.lang.String content) { throw new RuntimeException("Stub!"); }

/**
 * Returns the response of authentication for the default subscription.
 * Returns null if the authentication hasn't been successful
 *
 * <p>Requires Permission: READ_PRIVILEGED_PHONE_STATE or that the calling
 * app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * @param appType the icc application type, like {@link #APPTYPE_USIM}
 * @param authType the authentication type, {@link #AUTHTYPE_EAP_AKA} or
 * {@link #AUTHTYPE_EAP_SIM}
 * @param data authentication challenge data, base64 encoded.
 * See 3GPP TS 31.102 7.1.2 for more details.
 * @return the response of authentication. This value will be null in the following cases:
 *   Authentication error, incorrect MAC
 *   Authentication error, security context not supported
 *   Key freshness failure
 *   Authentication error, no memory space available
 *   Authentication error, no memory space available in EFMUK
 * @apiSince 24
 */

public java.lang.String getIccAuthentication(int appType, int authType, java.lang.String data) { throw new RuntimeException("Stub!"); }

/**
 * Returns an array of Forbidden PLMNs from the USIM App
 * Returns null if the query fails.
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * <br>
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @return an array of forbidden PLMNs or null if not available
 * @apiSince 26
 */

public java.lang.String[] getForbiddenPlmns() { throw new RuntimeException("Stub!"); }

/**
 * Replace the contents of the forbidden PLMN SIM file with the provided values.
 * Passing an empty list will clear the contents of the EFfplmn file.
 * If the provided list is shorter than the size of EFfplmn, then the list will be padded
 * up to the file size with 'FFFFFF'. (required by 3GPP TS 31.102 spec 4.2.16)
 * If the list is longer than the size of EFfplmn, then the file will be written from the
 * beginning of the list up to the file size.
 *
 * <p>Requires Permission: {@link android.Manifest.permission#MODIFY_PHONE_STATE
 * MODIFY_PHONE_STATE}
 * or that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * <br>
 * Requires {@link android.Manifest.permission#MODIFY_PHONE_STATE}
 * @param fplmns a list of PLMNs to be forbidden.
 *
 * This value must never be {@code null}.
 * @return number of PLMNs that were successfully written to the SIM FPLMN list.
 * This may be less than the number of PLMNs passed in where the SIM file does not have enough
 * room for all of the values passed in. Return -1 in the event of an unexpected failure
 * @apiSince R
 */

public int setForbiddenPlmns(@androidx.annotation.NonNull java.util.List<java.lang.String> fplmns) { throw new RuntimeException("Stub!"); }

/**
 * Sets the network selection mode to automatic.
 *
 * <p>If this object has been created with {@link #createForSubscriptionId}, applies to the
 * given subId. Otherwise, applies to {@link android.telephony.SubscriptionManager#getDefaultSubscriptionId() SubscriptionManager#getDefaultSubscriptionId()}
 *
 * <p>Requires Permission:
 * {@link android.Manifest.permission#MODIFY_PHONE_STATE MODIFY_PHONE_STATE} or that the calling
 * app has carrier privileges (see {@link #hasCarrierPrivileges}).
 
 * <br>
 * Requires {@link android.Manifest.permission#MODIFY_PHONE_STATE}
 * @apiSince 28
 */

public void setNetworkSelectionModeAutomatic() { throw new RuntimeException("Stub!"); }

/**
 * Request a network scan.
 *
 * This method is asynchronous, so the network scan results will be returned by callback.
 * The returned NetworkScan will contain a callback method which can be used to stop the scan.
 *
 * <p>Requires Permission:
 * {@link android.Manifest.permission#MODIFY_PHONE_STATE MODIFY_PHONE_STATE} or that the calling
 * app has carrier privileges (see {@link #hasCarrierPrivileges})
 * and {@link android.Manifest.permission#ACCESS_FINE_LOCATION}.
 *
 * If the system-wide location switch is off, apps may still call this API, with the
 * following constraints:
 * <ol>
 *     <li>The app must hold the {@code android.permission.NETWORK_SCAN} permission.</li>
 *     <li>The app must not supply any specific bands or channels to scan.</li>
 *     <li>The app must only specify MCC/MNC pairs that are
 *     associated to a SIM in the device.</li>
 *     <li>Returned results will have no meaningful info other than signal strength
 *     and MCC/MNC info.</li>
 * </ol>
 *
 * <br>
 * Requires {@link android.Manifest.permission#MODIFY_PHONE_STATE} and {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @param request Contains all the RAT with bands/channels that need to be scanned.
 * @param executor The executor through which the callback should be invoked. Since the scan
 *        request may trigger multiple callbacks and they must be invoked in the same order as
 *        they are received by the platform, the user should provide an executor which executes
 *        tasks one at a time in serial order. For example AsyncTask.SERIAL_EXECUTOR.
 * @param callback Returns network scan results or errors.
 * @return A NetworkScan obj which contains a callback which can be used to stop the scan.
 * @apiSince 28
 */

public android.telephony.NetworkScan requestNetworkScan(android.telephony.NetworkScanRequest request, java.util.concurrent.Executor executor, android.telephony.TelephonyScanManager.NetworkScanCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Ask the radio to connect to the input network and change selection mode to manual.
 *
 * <p>If this object has been created with {@link #createForSubscriptionId}, applies to the
 * given subId. Otherwise, applies to {@link android.telephony.SubscriptionManager#getDefaultSubscriptionId() SubscriptionManager#getDefaultSubscriptionId()}
 *
 * <p>Requires Permission:
 * {@link android.Manifest.permission#MODIFY_PHONE_STATE MODIFY_PHONE_STATE} or that the calling
 * app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * <br>
 * Requires {@link android.Manifest.permission#MODIFY_PHONE_STATE}
 * @param operatorNumeric the PLMN ID of the network to select.
 * @param persistSelection whether the selection will persist until reboot. If true, only allows
 * attaching to the selected PLMN until reboot; otherwise, attach to the chosen PLMN and resume
 * normal network selection next time.
 * @return {@code true} on success; {@code false} on any failure.
 * @apiSince 28
 */

public boolean setNetworkSelectionModeManual(java.lang.String operatorNumeric, boolean persistSelection) { throw new RuntimeException("Stub!"); }

/**
 * Set the preferred network type to global mode which includes LTE, CDMA, EvDo and GSM/WCDMA.
 *
 * <p>Requires that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * @return true on success; false on any failure.
 * @apiSince 22
 */

public boolean setPreferredNetworkTypeToGlobal() { throw new RuntimeException("Stub!"); }

/**
 * Has the calling application been granted carrier privileges by the carrier.
 *
 * If any of the packages in the calling UID has carrier privileges, the
 * call will return true. This access is granted by the owner of the UICC
 * card and does not depend on the registered carrier.
 *
 * @return true if the app has carrier privileges.
 * @apiSince 22
 */

public boolean hasCarrierPrivileges() { throw new RuntimeException("Stub!"); }

/**
 * Override the branding for the current ICCID.
 *
 * Once set, whenever the SIM is present in the device, the service
 * provider name (SPN) and the operator name will both be replaced by the
 * brand value input. To unset the value, the same function should be
 * called with a null brand value.
 *
 * <p>Requires that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * @param brand The brand name to display/set.
 * @return true if the operation was executed correctly.
 * @apiSince 22
 */

public boolean setOperatorBrandOverride(java.lang.String brand) { throw new RuntimeException("Stub!"); }

/**
 * Sends an Unstructured Supplementary Service Data (USSD) request to the mobile network and
 * informs the caller of the response via the supplied {@code callback}.
 * <p>Carriers define USSD codes which can be sent by the user to request information such as
 * the user's current data balance or minutes balance.
 * <p>Requires permission:
 * {@link android.Manifest.permission#CALL_PHONE}
 * <br>
 * Requires {@link android.Manifest.permission#CALL_PHONE}
 * @param ussdRequest the USSD command to be executed.
 * @param callback called by the framework to inform the caller of the result of executing the
 *                 USSD request (see {@link android.telephony.TelephonyManager.UssdResponseCallback UssdResponseCallback}).
 * @param handler the {@link android.os.Handler Handler} to run the request on.
 * @apiSince 26
 */

public void sendUssdRequest(java.lang.String ussdRequest, android.telephony.TelephonyManager.UssdResponseCallback callback, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Whether the device is currently on a technology (e.g.&nbsp;UMTS or LTE) which can support
 * voice and data simultaneously. This can change based on location or network condition.
 *
 * @return {@code true} if simultaneous voice and data supported, and {@code false} otherwise.
 * @apiSince 26
 */

public boolean isConcurrentVoiceAndDataSupported() { throw new RuntimeException("Stub!"); }

/**
 * Turns mobile data on or off.
 * If this object has been created with {@link #createForSubscriptionId}, applies to the given
 * subId. Otherwise, applies to {@link android.telephony.SubscriptionManager#getDefaultDataSubscriptionId() SubscriptionManager#getDefaultDataSubscriptionId()}
 *
 * <p>Requires Permission:
 * {@link android.Manifest.permission#MODIFY_PHONE_STATE MODIFY_PHONE_STATE} or that the calling
 * app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * <br>
 * Requires {@link android.Manifest.permission#MODIFY_PHONE_STATE}
 * @param enable Whether to enable mobile data.
 *
 * @apiSince 26
 */

public void setDataEnabled(boolean enable) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether mobile data is enabled or not per user setting. There are other factors
 * that could disable mobile data, but they are not considered here.
 *
 * If this object has been created with {@link #createForSubscriptionId}, applies to the given
 * subId. Otherwise, applies to {@link android.telephony.SubscriptionManager#getDefaultDataSubscriptionId() SubscriptionManager#getDefaultDataSubscriptionId()}
 *
 * <p>Requires one of the following permissions:
 * {@link android.Manifest.permission#ACCESS_NETWORK_STATE},
 * {@link android.Manifest.permission#MODIFY_PHONE_STATE}, or that the calling app has carrier
 * privileges (see {@link #hasCarrierPrivileges}).
 *
 * <p>Note that this does not take into account any data restrictions that may be present on the
 * calling app. Such restrictions may be inspected with
 * {@link android.net.ConnectivityManager#getRestrictBackgroundStatus ConnectivityManager#getRestrictBackgroundStatus}.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_NETWORK_STATE} or {@link android.Manifest.permission#MODIFY_PHONE_STATE}
 * @return true if mobile data is enabled.
 * @apiSince 26
 */

public boolean isDataEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether mobile data roaming is enabled on the subscription.
 *
 * <p>If this object has been created with {@link #createForSubscriptionId}, applies to the
 * given subId. Otherwise, applies to {@link android.telephony.SubscriptionManager#getDefaultDataSubscriptionId() SubscriptionManager#getDefaultDataSubscriptionId()}
 *
 * <p>Requires one of the following permissions:
 * {@link android.Manifest.permission#ACCESS_NETWORK_STATE},
 * {@link android.Manifest.permission#READ_PHONE_STATE} or that the calling app
 * has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * <br>
 * Requires {@link android.Manifest.permission#ACCESS_NETWORK_STATE} or {@link android.Manifest.permission#READ_PHONE_STATE}
 * @return {@code true} if the data roaming is enabled on the subscription, otherwise return
 * {@code false}.
 * @apiSince 29
 */

public boolean isDataRoamingEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Whether the device supports configuring the DTMF tone length.
 *
 * @return {@code true} if the DTMF tone length can be changed, and {@code false} otherwise.
 * @apiSince 23
 */

public boolean canChangeDtmfToneLength() { throw new RuntimeException("Stub!"); }

/**
 * Whether the device is a world phone.
 *
 * @return {@code true} if the device is a world phone, and {@code false} otherwise.
 * @apiSince 23
 */

public boolean isWorldPhone() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link android.telecom.TelecomManager#isTtySupported() TelecomManager#isTtySupported()} instead
 * Whether the phone supports TTY mode.
 *
 * @return {@code true} if the device supports TTY mode, and {@code false} otherwise.
 *
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated
public boolean isTtyModeSupported() { throw new RuntimeException("Stub!"); }

/**
 * Determines whether the device currently supports RTT (Real-time text). Based both on carrier
 * support for the feature and device firmware support.
 *
 * @return {@code true} if the device and carrier both support RTT, {@code false} otherwise.
 * @apiSince 29
 */

public boolean isRttSupported() { throw new RuntimeException("Stub!"); }

/**
 * Whether the phone supports hearing aid compatibility.
 *
 * @return {@code true} if the device supports hearing aid compatibility, and {@code false}
 * otherwise.
 * @apiSince 23
 */

public boolean isHearingAidCompatibilitySupported() { throw new RuntimeException("Stub!"); }

/**
 * Returns the subscription ID for the given phone account handle.
 *
 * <br>
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @param phoneAccountHandle the phone account handle for outgoing calls
 * This value must never be {@code null}.
 * @return subscription ID for the given phone account handle; or
 *         {@link android.telephony.SubscriptionManager#INVALID_SUBSCRIPTION_ID SubscriptionManager#INVALID_SUBSCRIPTION_ID}
 *         if not available; or throw a SecurityException if the caller doesn't have the
 *         permission.
 * @apiSince R
 */

public int getSubscriptionId(@androidx.annotation.NonNull android.telecom.PhoneAccountHandle phoneAccountHandle) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current {@link android.telephony.ServiceState ServiceState} information.
 *
 * <p>If this object has been created with {@link #createForSubscriptionId}, applies to the
 * given subId. Otherwise, applies to {@link android.telephony.SubscriptionManager#getDefaultSubscriptionId() SubscriptionManager#getDefaultSubscriptionId()}
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see {@link #hasCarrierPrivileges})
 * and {@link android.Manifest.permission#ACCESS_COARSE_LOCATION}.
 
 * <br>
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE} and {@link android.Manifest.permission#ACCESS_COARSE_LOCATION}
 * @apiSince 26
 */

public android.telephony.ServiceState getServiceState() { throw new RuntimeException("Stub!"); }

/**
 * Returns the URI for the per-account voicemail ringtone set in Phone settings.
 *
 * @param accountHandle The handle for the {@link android.telecom.PhoneAccount PhoneAccount} for which to retrieve the
 * voicemail ringtone.
 * @return The URI for the ringtone to play when receiving a voicemail from a specific
 * PhoneAccount.
 * @apiSince 24
 */

public android.net.Uri getVoicemailRingtoneUri(android.telecom.PhoneAccountHandle accountHandle) { throw new RuntimeException("Stub!"); }

/**
 * Sets the per-account voicemail ringtone.
 *
 * <p>Requires that the calling app is the default dialer, or has carrier privileges (see
 * {@link #hasCarrierPrivileges}, or has permission
 * {@link android.Manifest.permission#MODIFY_PHONE_STATE MODIFY_PHONE_STATE}.
 *
 * @param phoneAccountHandle The handle for the {@link android.telecom.PhoneAccount PhoneAccount} for which to set the
 * voicemail ringtone.
 * @param uri The URI for the ringtone to play when receiving a voicemail from a specific
 * PhoneAccount.
 *
 * @deprecated Use {@link android.provider.Settings#ACTION_CHANNEL_NOTIFICATION_SETTINGS}
 * instead.
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
public void setVoicemailRingtoneUri(android.telecom.PhoneAccountHandle phoneAccountHandle, android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether vibration is set for voicemail notification in Phone settings.
 *
 * @param accountHandle The handle for the {@link android.telecom.PhoneAccount PhoneAccount} for which to retrieve the
 * voicemail vibration setting.
 * @return {@code true} if the vibration is set for this PhoneAccount, {@code false} otherwise.
 * @apiSince 24
 */

public boolean isVoicemailVibrationEnabled(android.telecom.PhoneAccountHandle accountHandle) { throw new RuntimeException("Stub!"); }

/**
 * Sets the per-account preference whether vibration is enabled for voicemail notifications.
 *
 * <p>Requires that the calling app is the default dialer, or has carrier privileges (see
 * {@link #hasCarrierPrivileges}, or has permission
 * {@link android.Manifest.permission#MODIFY_PHONE_STATE MODIFY_PHONE_STATE}.
 *
 * @param phoneAccountHandle The handle for the {@link android.telecom.PhoneAccount PhoneAccount} for which to set the
 * voicemail vibration setting.
 * @param enabled Whether to enable or disable vibration for voicemail notifications from a
 * specific PhoneAccount.
 *
 * @deprecated Use {@link android.provider.Settings#ACTION_CHANNEL_NOTIFICATION_SETTINGS}
 * instead.
 * @apiSince 26
 * @deprecatedSince 28
 */

@Deprecated
public void setVoicemailVibrationEnabled(android.telecom.PhoneAccountHandle phoneAccountHandle, boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Returns carrier id of the current subscription.
 * <p>To recognize a carrier (including MVNO) as a first-class identity, Android assigns each
 * carrier with a canonical integer a.k.a. carrier id. The carrier ID is an Android
 * platform-wide identifier for a carrier. AOSP maintains carrier ID assignments in
 * <a href="https://android.googlesource.com/platform/packages/providers/TelephonyProvider/+/master/assets/carrier_list.textpb">here</a>
 *
 * <p>Apps which have carrier-specific configurations or business logic can use the carrier id
 * as an Android platform-wide identifier for carriers.
 *
 * @return Carrier id of the current subscription. Return {@link #UNKNOWN_CARRIER_ID} if the
 * subscription is unavailable or the carrier cannot be identified.
 * @apiSince 28
 */

public int getSimCarrierId() { throw new RuntimeException("Stub!"); }

/**
 * Returns carrier id name of the current subscription.
 * <p>Carrier id name is a user-facing name of carrier id returned by
 * {@link #getSimCarrierId()}, usually the brand name of the subsidiary
 * (e.g. T-Mobile). Each carrier could configure multiple {@link #getSimOperatorName() SPN} but
 * should have a single carrier name. Carrier name is not a canonical identity,
 * use {@link #getSimCarrierId()} instead.
 * <p>The returned carrier name is unlocalized.
 *
 * @return Carrier name of the current subscription. Return {@code null} if the subscription is
 * unavailable or the carrier cannot be identified.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public java.lang.CharSequence getSimCarrierIdName() { throw new RuntimeException("Stub!"); }

/**
 * Returns fine-grained carrier ID of the current subscription.
 *
 * A specific carrier ID can represent the fact that a carrier may be in effect an aggregation
 * of other carriers (ie in an MVNO type scenario) where each of these specific carriers which
 * are used to make up the actual carrier service may have different carrier configurations.
 * A specific carrier ID could also be used, for example, in a scenario where a carrier requires
 * different carrier configuration for different service offering such as a prepaid plan.
 *
 * the specific carrier ID would be used for configuration purposes, but apps wishing to know
 * about the carrier itself should use the regular carrier ID returned by
 * {@link #getSimCarrierId()}.
 *
 * e.g, Tracfone SIMs could return different specific carrier ID based on IMSI from current
 * subscription while carrier ID remains the same.
 *
 * <p>For carriers without fine-grained specific carrier ids, return {@link #getSimCarrierId()}
 * <p>Specific carrier ids are defined in the same way as carrier id
 * <a href="https://android.googlesource.com/platform/packages/providers/TelephonyProvider/+/master/assets/carrier_list.textpb">here</a>
 * except each with a "parent" id linking to its top-level carrier id.
 *
 * @return Returns fine-grained carrier id of the current subscription.
 * Return {@link #UNKNOWN_CARRIER_ID} if the subscription is unavailable or the carrier cannot
 * be identified.
 * @apiSince 29
 */

public int getSimSpecificCarrierId() { throw new RuntimeException("Stub!"); }

/**
 * Similar like {@link #getSimCarrierIdName()}, returns user-facing name of the
 * specific carrier id returned by {@link #getSimSpecificCarrierId()}.
 *
 * The specific carrier ID would be used for configuration purposes, but apps wishing to know
 * about the carrier itself should use the regular carrier ID returned by
 * {@link #getSimCarrierIdName()}.
 *
 * <p>The returned name is unlocalized.
 *
 * @return user-facing name of the subscription specific carrier id. Return {@code null} if the
 * subscription is unavailable or the carrier cannot be identified.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.lang.CharSequence getSimSpecificCarrierIdName() { throw new RuntimeException("Stub!"); }

/**
 * Returns carrier id based on sim MCCMNC (returned by {@link #getSimOperator()}) only.
 * This is used for fallback when configurations/logic for exact carrier id
 * {@link #getSimCarrierId()} are not found.
 *
 * Android carrier id table <a href="https://android.googlesource.com/platform/packages/providers/TelephonyProvider/+/master/assets/carrier_list.textpb">here</a>
 * can be updated out-of-band, its possible a MVNO (Mobile Virtual Network Operator) carrier
 * was not fully recognized and assigned to its MNO (Mobile Network Operator) carrier id
 * by default. After carrier id table update, a new carrier id was assigned. If apps don't
 * take the update with the new id, it might be helpful to always fallback by using carrier
 * id based on MCCMNC if there is no match.
 *
 * @return matching carrier id from sim MCCMNC. Return {@link #UNKNOWN_CARRIER_ID} if the
 * subscription is unavailable or the carrier cannot be identified.
 * @apiSince 29
 */

public int getCarrierIdFromSimMccMnc() { throw new RuntimeException("Stub!"); }

/**
 * Get the most recently available signal strength information.
 *
 * Get the most recent SignalStrength information reported by the modem. Due
 * to power saving this information may not always be current.
 * @return the most recent cached signal strength info from the modem
 
 * This value may be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public android.telephony.SignalStrength getSignalStrength() { throw new RuntimeException("Stub!"); }

/**
 * Get the emergency number list based on current locale, sim, default, modem and network.
 *
 * <p>In each returned list, the emergency number {@link android.telephony.emergency.EmergencyNumber EmergencyNumber} coming from higher
 * priority sources will be located at the smaller index; the priority order of sources are:
 * {@link android.telephony.emergency.EmergencyNumber#EMERGENCY_NUMBER_SOURCE_NETWORK_SIGNALING EmergencyNumber#EMERGENCY_NUMBER_SOURCE_NETWORK_SIGNALING} >
 * {@link android.telephony.emergency.EmergencyNumber#EMERGENCY_NUMBER_SOURCE_SIM EmergencyNumber#EMERGENCY_NUMBER_SOURCE_SIM} >
 * {@link android.telephony.emergency.EmergencyNumber#EMERGENCY_NUMBER_SOURCE_DATABASE EmergencyNumber#EMERGENCY_NUMBER_SOURCE_DATABASE} >
 * {@link android.telephony.emergency.EmergencyNumber#EMERGENCY_NUMBER_SOURCE_DEFAULT EmergencyNumber#EMERGENCY_NUMBER_SOURCE_DEFAULT} >
 * {@link android.telephony.emergency.EmergencyNumber#EMERGENCY_NUMBER_SOURCE_MODEM_CONFIG EmergencyNumber#EMERGENCY_NUMBER_SOURCE_MODEM_CONFIG}
 *
 * <p>The subscriptions which the returned list would be based on, are all the active
 * subscriptions, no matter which subscription could be used to create TelephonyManager.
 *
 * <p>Requires permission {@link android.Manifest.permission#READ_PHONE_STATE} or the calling
 * app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * <br>
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @return Map including the keys as the active subscription IDs (Note: if there is no active
 * subscription, the key is {@link android.telephony.SubscriptionManager#getDefaultSubscriptionId SubscriptionManager#getDefaultSubscriptionId}) and the value
 * as the list of {@link android.telephony.emergency.EmergencyNumber EmergencyNumber}; empty Map if this information is not available;
 * or throw a SecurityException if the caller does not have the permission.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.util.Map<java.lang.Integer,java.util.List<android.telephony.emergency.EmergencyNumber>> getEmergencyNumberList() { throw new RuntimeException("Stub!"); }

/**
 * Get the per-category emergency number list based on current locale, sim, default, modem
 * and network.
 *
 * <p>In each returned list, the emergency number {@link android.telephony.emergency.EmergencyNumber EmergencyNumber} coming from higher
 * priority sources will be located at the smaller index; the priority order of sources are:
 * {@link android.telephony.emergency.EmergencyNumber#EMERGENCY_NUMBER_SOURCE_NETWORK_SIGNALING EmergencyNumber#EMERGENCY_NUMBER_SOURCE_NETWORK_SIGNALING} >
 * {@link android.telephony.emergency.EmergencyNumber#EMERGENCY_NUMBER_SOURCE_SIM EmergencyNumber#EMERGENCY_NUMBER_SOURCE_SIM} >
 * {@link android.telephony.emergency.EmergencyNumber#EMERGENCY_NUMBER_SOURCE_DATABASE EmergencyNumber#EMERGENCY_NUMBER_SOURCE_DATABASE} >
 * {@link android.telephony.emergency.EmergencyNumber#EMERGENCY_NUMBER_SOURCE_DEFAULT EmergencyNumber#EMERGENCY_NUMBER_SOURCE_DEFAULT} >
 * {@link android.telephony.emergency.EmergencyNumber#EMERGENCY_NUMBER_SOURCE_MODEM_CONFIG EmergencyNumber#EMERGENCY_NUMBER_SOURCE_MODEM_CONFIG}
 *
 * <p>The subscriptions which the returned list would be based on, are all the active
 * subscriptions, no matter which subscription could be used to create TelephonyManager.
 *
 * <p>Requires permission {@link android.Manifest.permission#READ_PHONE_STATE} or the calling
 * app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * <br>
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @param categories the emergency service categories which are the bitwise-OR combination of
 * the following constants:
 * <ol>
 * <li>{@link android.telephony.emergency.EmergencyNumber#EMERGENCY_SERVICE_CATEGORY_UNSPECIFIED EmergencyNumber#EMERGENCY_SERVICE_CATEGORY_UNSPECIFIED} </li>
 * <li>{@link android.telephony.emergency.EmergencyNumber#EMERGENCY_SERVICE_CATEGORY_POLICE EmergencyNumber#EMERGENCY_SERVICE_CATEGORY_POLICE} </li>
 * <li>{@link android.telephony.emergency.EmergencyNumber#EMERGENCY_SERVICE_CATEGORY_AMBULANCE EmergencyNumber#EMERGENCY_SERVICE_CATEGORY_AMBULANCE} </li>
 * <li>{@link android.telephony.emergency.EmergencyNumber#EMERGENCY_SERVICE_CATEGORY_FIRE_BRIGADE EmergencyNumber#EMERGENCY_SERVICE_CATEGORY_FIRE_BRIGADE} </li>
 * <li>{@link android.telephony.emergency.EmergencyNumber#EMERGENCY_SERVICE_CATEGORY_MARINE_GUARD EmergencyNumber#EMERGENCY_SERVICE_CATEGORY_MARINE_GUARD} </li>
 * <li>{@link android.telephony.emergency.EmergencyNumber#EMERGENCY_SERVICE_CATEGORY_MOUNTAIN_RESCUE EmergencyNumber#EMERGENCY_SERVICE_CATEGORY_MOUNTAIN_RESCUE} </li>
 * <li>{@link android.telephony.emergency.EmergencyNumber#EMERGENCY_SERVICE_CATEGORY_MIEC EmergencyNumber#EMERGENCY_SERVICE_CATEGORY_MIEC} </li>
 * <li>{@link android.telephony.emergency.EmergencyNumber#EMERGENCY_SERVICE_CATEGORY_AIEC EmergencyNumber#EMERGENCY_SERVICE_CATEGORY_AIEC} </li>
 * </ol>
 * Value is either <code>0</code> or a combination of {@link android.telephony.emergency.EmergencyNumber#EMERGENCY_SERVICE_CATEGORY_UNSPECIFIED}, {@link android.telephony.emergency.EmergencyNumber#EMERGENCY_SERVICE_CATEGORY_POLICE}, {@link android.telephony.emergency.EmergencyNumber#EMERGENCY_SERVICE_CATEGORY_AMBULANCE}, {@link android.telephony.emergency.EmergencyNumber#EMERGENCY_SERVICE_CATEGORY_FIRE_BRIGADE}, {@link android.telephony.emergency.EmergencyNumber#EMERGENCY_SERVICE_CATEGORY_MARINE_GUARD}, {@link android.telephony.emergency.EmergencyNumber#EMERGENCY_SERVICE_CATEGORY_MOUNTAIN_RESCUE}, {@link android.telephony.emergency.EmergencyNumber#EMERGENCY_SERVICE_CATEGORY_MIEC}, and {@link android.telephony.emergency.EmergencyNumber#EMERGENCY_SERVICE_CATEGORY_AIEC}
 * @return Map including the keys as the active subscription IDs (Note: if there is no active
 * subscription, the key is {@link android.telephony.SubscriptionManager#getDefaultSubscriptionId SubscriptionManager#getDefaultSubscriptionId}) and the value
 * as the list of {@link android.telephony.emergency.EmergencyNumber EmergencyNumber}; empty Map if this information is not available;
 * or throw a SecurityException if the caller does not have the permission.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.util.Map<java.lang.Integer,java.util.List<android.telephony.emergency.EmergencyNumber>> getEmergencyNumberList(int categories) { throw new RuntimeException("Stub!"); }

/**
 * Identifies if the supplied phone number is an emergency number that matches a known
 * emergency number based on current locale, SIM card(s), Android database, modem, network,
 * or defaults.
 *
 * <p>This method assumes that only dialable phone numbers are passed in; non-dialable
 * numbers are not considered emergency numbers. A dialable phone number consists only
 * of characters/digits identified by {@link android.telephony.PhoneNumberUtils#isDialable(char) PhoneNumberUtils#isDialable(char)}.
 *
 * <p>The subscriptions which the identification would be based on, are all the active
 * subscriptions, no matter which subscription could be used to create TelephonyManager.
 *
 * @param number - the number to look up
 * This value must never be {@code null}.
 * @return {@code true} if the given number is an emergency number based on current locale,
 * SIM card(s), Android database, modem, network or defaults; {@code false} otherwise.
 * @apiSince 29
 */

public boolean isEmergencyNumber(@androidx.annotation.NonNull java.lang.String number) { throw new RuntimeException("Stub!"); }

/**
 * Set preferred opportunistic data subscription id.
 *
 * Switch internet data to preferred opportunistic data subscription id. This api
 * can result in lose of internet connectivity for short period of time while internet data
 * is handed over.
 * <p>Requires that the calling app has carrier privileges on both primary and
 * secondary subscriptions (see
 * {@link #hasCarrierPrivileges}), or has permission
 * {@link android.Manifest.permission#MODIFY_PHONE_STATE MODIFY_PHONE_STATE}.
 *
 * @param subId which opportunistic subscription
 * {@link android.telephony.SubscriptionManager#getOpportunisticSubscriptions SubscriptionManager#getOpportunisticSubscriptions} is preferred for cellular data.
 * Pass {@link android.telephony.SubscriptionManager#DEFAULT_SUBSCRIPTION_ID SubscriptionManager#DEFAULT_SUBSCRIPTION_ID} to unset the preference
 * @param needValidation whether validation is needed before switch happens.
 * @param executor The executor of where the callback will execute.
 * This value may be {@code null}.
 * Callback and listener events are dispatched through this
 * {@link java.util.concurrent.Executor Executor}, providing an easy way to control which thread is
 * used. To dispatch events through the main thread of your
 * application, you can use {@link android.content.Context#getMainExecutor() Context#getMainExecutor()}. To
 * dispatch events through a shared thread pool, you can use
 * {@link android.os.AsyncTask#THREAD_POOL_EXECUTOR AsyncTask#THREAD_POOL_EXECUTOR}.
 * @param callback Callback will be triggered once it succeeds or failed.
 *                 See {@link android.telephony.TelephonyManager.SetOpportunisticSubscriptionResult TelephonyManager.SetOpportunisticSubscriptionResult}
 *                 for more details. Pass null if don't care about the result.
 
 * This value may be {@code null}.
 * @apiSince 29
 */

public void setPreferredOpportunisticDataSubscription(int subId, boolean needValidation, @androidx.annotation.Nullable java.util.concurrent.Executor executor, @androidx.annotation.Nullable java.util.function.Consumer<java.lang.Integer> callback) { throw new RuntimeException("Stub!"); }

/**
 * Get preferred opportunistic data subscription Id
 *
 * <p>Requires that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}),
 * or has either READ_PRIVILEGED_PHONE_STATE
 * or {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE} permission.
 * <br>
 * Requires android.Manifest.permission.READ_PRIVILEGED_PHONE_STATE or {@link android.Manifest.permission#READ_PHONE_STATE}
 * @return subId preferred opportunistic subscription id or
 * {@link android.telephony.SubscriptionManager#DEFAULT_SUBSCRIPTION_ID SubscriptionManager#DEFAULT_SUBSCRIPTION_ID} if there are no preferred
 * subscription id
 *
 * @apiSince 29
 */

public int getPreferredOpportunisticDataSubscription() { throw new RuntimeException("Stub!"); }

/**
 * Update availability of a list of networks in the current location.
 *
 * This api should be called to inform OpportunisticNetwork Service about the availability
 * of a network at the current location. This information will be used by OpportunisticNetwork
 * service to enable modem stack and to attach to the network. If an empty list is passed,
 * it is assumed that no network is available and will result in disabling the modem stack
 * to save power. This api do not switch internet data once network attach is completed.
 * Use {@link android.telephony.TelephonyManager#setPreferredOpportunisticDataSubscription TelephonyManager#setPreferredOpportunisticDataSubscription}
 * to switch internet data after network attach is complete.
 * Requires that the calling app has carrier privileges on both primary and
 * secondary subscriptions (see {@link #hasCarrierPrivileges}), or has permission
 * {@link android.Manifest.permission#MODIFY_PHONE_STATE MODIFY_PHONE_STATE}.
 * @param availableNetworks is a list of available network information.
 * This value must never be {@code null}.
 * @param executor The executor of where the callback will execute.
 * This value may be {@code null}.
 * Callback and listener events are dispatched through this
 * {@link java.util.concurrent.Executor Executor}, providing an easy way to control which thread is
 * used. To dispatch events through the main thread of your
 * application, you can use {@link android.content.Context#getMainExecutor() Context#getMainExecutor()}. To
 * dispatch events through a shared thread pool, you can use
 * {@link android.os.AsyncTask#THREAD_POOL_EXECUTOR AsyncTask#THREAD_POOL_EXECUTOR}.
 * @param callback Callback will be triggered once it succeeds or failed.
 *
 
 * Value is {@link android.telephony.TelephonyManager#UPDATE_AVAILABLE_NETWORKS_SUCCESS}, {@link android.telephony.TelephonyManager#UPDATE_AVAILABLE_NETWORKS_UNKNOWN_FAILURE}, {@link android.telephony.TelephonyManager#UPDATE_AVAILABLE_NETWORKS_ABORTED}, {@link android.telephony.TelephonyManager#UPDATE_AVAILABLE_NETWORKS_INVALID_ARGUMENTS}, {@link android.telephony.TelephonyManager#UPDATE_AVAILABLE_NETWORKS_NO_CARRIER_PRIVILEGE}, {@link android.telephony.TelephonyManager#UPDATE_AVAILABLE_NETWORKS_DISABLE_MODEM_FAIL}, {@link android.telephony.TelephonyManager#UPDATE_AVAILABLE_NETWORKS_ENABLE_MODEM_FAIL}, {@link android.telephony.TelephonyManager#UPDATE_AVAILABLE_NETWORKS_MULTIPLE_NETWORKS_NOT_SUPPORTED}, {@link android.telephony.TelephonyManager#UPDATE_AVAILABLE_NETWORKS_NO_OPPORTUNISTIC_SUB_AVAILABLE}, {@link android.telephony.TelephonyManager#UPDATE_AVAILABLE_NETWORKS_REMOTE_SERVICE_EXCEPTION}, or {@link android.telephony.TelephonyManager#UPDATE_AVAILABLE_NETWORKS_SERVICE_IS_DISABLED}
 
 * This value may be {@code null}.
 * @apiSince 29
 */

public void updateAvailableNetworks(@androidx.annotation.NonNull java.util.List<android.telephony.AvailableNetworkInfo> availableNetworks, @androidx.annotation.Nullable java.util.concurrent.Executor executor, @androidx.annotation.Nullable java.util.function.Consumer<java.lang.Integer> callback) { throw new RuntimeException("Stub!"); }

/**
 * Returns if the usage of multiple SIM cards at the same time to register on the network
 * (e.g.&nbsp;Dual Standby or Dual Active) is supported by the device and by the carrier.
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * <br>
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @return {@link #MULTISIM_ALLOWED} if the device supports multiple SIMs.
 * {@link #MULTISIM_NOT_SUPPORTED_BY_HARDWARE} if the device does not support multiple SIMs.
 * {@link #MULTISIM_NOT_SUPPORTED_BY_CARRIER} in the device supports multiple SIMs, but the
 * functionality is restricted by the carrier.
 
 * Value is {@link android.telephony.TelephonyManager#MULTISIM_ALLOWED}, {@link android.telephony.TelephonyManager#MULTISIM_NOT_SUPPORTED_BY_HARDWARE}, or {@link android.telephony.TelephonyManager#MULTISIM_NOT_SUPPORTED_BY_CARRIER}
 * @apiSince 29
 */

public int isMultiSimSupported() { throw new RuntimeException("Stub!"); }

/**
 * Switch configs to enable multi-sim or switch back to single-sim
 * <p>Requires Permission:
 * {@link android.Manifest.permission#MODIFY_PHONE_STATE MODIFY_PHONE_STATE} or that the
 * calling app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * Note: with only carrier privileges, it is not allowed to switch from multi-sim
 * to single-sim
 *
 * <br>
 * Requires {@link android.Manifest.permission#MODIFY_PHONE_STATE}
 * @param numOfSims number of live SIMs we want to switch to
 * @throws android.os.RemoteException
 * @apiSince 29
 */

public void switchMultiSimConfig(int numOfSims) { throw new RuntimeException("Stub!"); }

/**
 * Get whether making changes to modem configurations by {@link #switchMultiSimConfig(int)} will
 * trigger device reboot.
 * The modem configuration change refers to switching from single SIM configuration to DSDS
 * or the other way around.
 *
 *  <p>Requires Permission:
 * {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE} or that the
 * calling app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * <br>
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @return {@code true} if reboot will be triggered after making changes to modem
 * configurations, otherwise return {@code false}.
 * @apiSince 29
 */

public boolean doesSwitchMultiSimConfigTriggerReboot() { throw new RuntimeException("Stub!"); }

/**
 * A service action that identifies
 * a {@link android.service.carrier.CarrierMessagingClientService} subclass in the
 * AndroidManifest.xml.
 *
 * <p>See {@link android.service.carrier.CarrierMessagingClientService} for the details.
 * @apiSince 29
 */

public static final java.lang.String ACTION_CARRIER_MESSAGING_CLIENT_SERVICE = "android.telephony.action.CARRIER_MESSAGING_CLIENT_SERVICE";

/**
 * Open the voicemail settings activity to make changes to voicemail configuration.
 *
 * <p>
 * The {@link #EXTRA_PHONE_ACCOUNT_HANDLE} extra indicates which {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} to
 * configure voicemail.
 * The {@link #EXTRA_HIDE_PUBLIC_SETTINGS} hides settings the dialer will modify through public
 * API if set.
 *
 * @see #EXTRA_PHONE_ACCOUNT_HANDLE
 * @see #EXTRA_HIDE_PUBLIC_SETTINGS
 * @apiSince 23
 */

public static final java.lang.String ACTION_CONFIGURE_VOICEMAIL = "android.telephony.action.CONFIGURE_VOICEMAIL";

/**
 * Broadcast intent that indicates multi-SIM configuration is changed. For example, it changed
 * from single SIM capable to dual-SIM capable (DSDS or DSDA) or triple-SIM mode.
 *
 * It doesn't indicate how many subscriptions are actually active, or which states SIMs are,
 * or that all steps during multi-SIM change are done. To know those information you still need
 * to listen to SIM_STATE changes or active subscription changes.
 *
 * See extra of {@link #EXTRA_NUM_OF_ACTIVE_SIM_SUPPORTED} for updated value.
 * @apiSince R
 */

public static final java.lang.String ACTION_MULTI_SIM_CONFIG_CHANGED = "android.telephony.action.MULTI_SIM_CONFIG_CHANGED";

/**
 * Broadcast intent action for network country code changes.
 *
 * <p>
 * The {@link #EXTRA_NETWORK_COUNTRY} extra indicates the country code of the current
 * network returned by {@link #getNetworkCountryIso()}.
 *
 * <p>There may be a delay of several minutes before reporting that no country is detected.
 *
 * @see #EXTRA_NETWORK_COUNTRY
 * @see #getNetworkCountryIso()
 * @apiSince 29
 */

public static final java.lang.String ACTION_NETWORK_COUNTRY_CHANGED = "android.telephony.action.NETWORK_COUNTRY_CHANGED";

/**
 * Broadcast intent action indicating that the call state
 * on the device has changed.
 *
 * <p>
 * The {@link #EXTRA_STATE} extra indicates the new call state.
 * If a receiving app has {@link android.Manifest.permission#READ_CALL_LOG} permission, a second
 * extra {@link #EXTRA_INCOMING_NUMBER} provides the phone number for incoming and outgoing
 * calls as a String.
 * <p>
 * If the receiving app has
 * {@link android.Manifest.permission#READ_CALL_LOG} and
 * {@link android.Manifest.permission#READ_PHONE_STATE} permission, it will receive the
 * broadcast twice; one with the {@link #EXTRA_INCOMING_NUMBER} populated with the phone number,
 * and another with it blank.  Due to the nature of broadcasts, you cannot assume the order
 * in which these broadcasts will arrive, however you are guaranteed to receive two in this
 * case.  Apps which are interested in the {@link #EXTRA_INCOMING_NUMBER} can ignore the
 * broadcasts where {@link #EXTRA_INCOMING_NUMBER} is not present in the extras (e.g. where
 * {@link android.content.Intent#hasExtra(java.lang.String) Intent#hasExtra(String)} returns {@code false}).
 * <p class="note">
 * This was a {@link android.content.Context#sendStickyBroadcast sticky}
 * broadcast in version 1.0, but it is no longer sticky.
 * Instead, use {@link #getCallState} to synchronously query the current call state.
 *
 * <br>
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @see #EXTRA_STATE
 * @see #EXTRA_INCOMING_NUMBER
 * @see #getCallState
 * @apiSince 3
 */

public static final java.lang.String ACTION_PHONE_STATE_CHANGED = "android.intent.action.PHONE_STATE";

/**
 * The Phone app sends this intent when a user opts to respond-via-message during an incoming
 * call. By default, the device's default SMS app consumes this message and sends a text message
 * to the caller. A third party app can also provide this functionality by consuming this Intent
 * with a {@link android.app.Service} and sending the message using its own messaging system.
 * <p>The intent contains a URI (available from {@link android.content.Intent#getData})
 * describing the recipient, using either the {@code sms:}, {@code smsto:}, {@code mms:},
 * or {@code mmsto:} URI schema. Each of these URI schema carry the recipient information the
 * same way: the path part of the URI contains the recipient's phone number or a comma-separated
 * set of phone numbers if there are multiple recipients. For example, {@code
 * smsto:2065551234}.</p>
 *
 * <p>The intent may also contain extras for the message text (in {@link
 * android.content.Intent#EXTRA_TEXT}) and a message subject
 * (in {@link android.content.Intent#EXTRA_SUBJECT}).</p>
 *
 * <p class="note"><strong>Note:</strong>
 * The intent-filter that consumes this Intent needs to be in a {@link android.app.Service}
 * that requires the
 * permission {@link android.Manifest.permission#SEND_RESPOND_VIA_MESSAGE}.</p>
 * <p>For example, the service that receives this intent can be declared in the manifest file
 * with an intent filter like this:</p>
 * <pre>
 * &lt;!-- Service that delivers SMS messages received from the phone "quick response" -->
 * &lt;service android:name=".HeadlessSmsSendService"
 *          android:permission="android.permission.SEND_RESPOND_VIA_MESSAGE"
 *          android:exported="true" >
 *   &lt;intent-filter>
 *     &lt;action android:name="android.intent.action.RESPOND_VIA_MESSAGE" />
 *     &lt;category android:name="android.intent.category.DEFAULT" />
 *     &lt;data android:scheme="sms" />
 *     &lt;data android:scheme="smsto" />
 *     &lt;data android:scheme="mms" />
 *     &lt;data android:scheme="mmsto" />
 *   &lt;/intent-filter>
 * &lt;/service></pre>
 * <p>
 * Output: nothing.
 * @apiSince 18
 */

public static final java.lang.String ACTION_RESPOND_VIA_MESSAGE = "android.intent.action.RESPOND_VIA_MESSAGE";

/**
 * Broadcast Action: A debug code has been entered in the dialer.
 * <p>
 * This intent is broadcast by the system and OEM telephony apps may need to receive these
 * broadcasts. And it requires the sender to be default dialer or has carrier privileges
 * (see {@link #hasCarrierPrivileges}).
 * <p>
 * These "secret codes" are used to activate developer menus by dialing certain codes.
 * And they are of the form {@code *#*#<code>#*#*}. The intent will have the data
 * URI: {@code android_secret_code://<code>}. It is possible that a manifest
 * receiver would be woken up even if it is not currently running.
 * <p>
 * It is supposed to replace {@link android.provider.Telephony.Sms.Intents#SECRET_CODE_ACTION}
 * in the next Android version.
 * Before that both of these two actions will be broadcast.
 * @apiSince 29
 */

public static final java.lang.String ACTION_SECRET_CODE = "android.telephony.action.SECRET_CODE";

/**
 * Broadcast intent action for letting the default dialer to know to show voicemail
 * notification.
 *
 * <p>
 * The {@link #EXTRA_PHONE_ACCOUNT_HANDLE} extra indicates which {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} the
 * voicemail is received on.
 * The {@link #EXTRA_NOTIFICATION_COUNT} extra indicates the total numbers of unheard
 * voicemails.
 * The {@link #EXTRA_VOICEMAIL_NUMBER} extra indicates the voicemail number if available.
 * The {@link #EXTRA_CALL_VOICEMAIL_INTENT} extra is a {@link android.app.PendingIntent} that
 * will call the voicemail number when sent. This extra will be empty if the voicemail number
 * is not set, and {@link #EXTRA_LAUNCH_VOICEMAIL_SETTINGS_INTENT} will be set instead.
 * The {@link #EXTRA_LAUNCH_VOICEMAIL_SETTINGS_INTENT} extra is a
 * {@link android.app.PendingIntent} that will launch the voicemail settings. This extra is only
 * available when the voicemail number is not set.
 * The {@link #EXTRA_IS_REFRESH} extra indicates whether the notification is a refresh or a new
 * notification.
 *
 * @see #EXTRA_PHONE_ACCOUNT_HANDLE
 * @see #EXTRA_NOTIFICATION_COUNT
 * @see #EXTRA_VOICEMAIL_NUMBER
 * @see #EXTRA_CALL_VOICEMAIL_INTENT
 * @see #EXTRA_LAUNCH_VOICEMAIL_SETTINGS_INTENT
 * @see #EXTRA_IS_REFRESH
 * @apiSince 26
 */

public static final java.lang.String ACTION_SHOW_VOICEMAIL_NOTIFICATION = "android.telephony.action.SHOW_VOICEMAIL_NOTIFICATION";

/**
 * Broadcast Action: The subscription carrier identity has changed.
 * This intent could be sent on the following events:
 * <ul>
 *   <li>Subscription absent. Carrier identity could change from a valid id to
 *   {@link android.telephony.TelephonyManager#UNKNOWN_CARRIER_ID TelephonyManager#UNKNOWN_CARRIER_ID}.</li>
 *   <li>Subscription loaded. Carrier identity could change from
 *   {@link android.telephony.TelephonyManager#UNKNOWN_CARRIER_ID TelephonyManager#UNKNOWN_CARRIER_ID} to a valid id.</li>
 *   <li>The subscription carrier is recognized after a remote update.</li>
 * </ul>
 * The intent will have the following extra values:
 * <ul>
 *   <li>{@link #EXTRA_CARRIER_ID} The up-to-date carrier id of the current subscription id.
 *   </li>
 *   <li>{@link #EXTRA_CARRIER_NAME} The up-to-date carrier name of the current subscription.
 *   </li>
 *   <li>{@link #EXTRA_SUBSCRIPTION_ID} The subscription id associated with the changed carrier
 *   identity.
 *   </li>
 * </ul>
 * <p class="note">This is a protected intent that can only be sent by the system.
 * @apiSince 28
 */

public static final java.lang.String ACTION_SUBSCRIPTION_CARRIER_IDENTITY_CHANGED = "android.telephony.action.SUBSCRIPTION_CARRIER_IDENTITY_CHANGED";

/**
 * Broadcast Action: The subscription specific carrier identity has changed.
 *
 * A specific carrier ID returns the fine-grained carrier ID of the current subscription.
 * It can represent the fact that a carrier may be in effect an aggregation of other carriers
 * (ie in an MVNO type scenario) where each of these specific carriers which are used to make
 * up the actual carrier service may have different carrier configurations.
 * A specific carrier ID could also be used, for example, in a scenario where a carrier requires
 * different carrier configuration for different service offering such as a prepaid plan.
 *
 * the specific carrier ID would be used for configuration purposes, but apps wishing to know
 * about the carrier itself should use the regular carrier ID returned by
 * {@link #getSimCarrierId()}.
 *
 * <p>Similar like {@link #ACTION_SUBSCRIPTION_CARRIER_IDENTITY_CHANGED}, this intent will be
 * sent on the event of {@link #ACTION_SUBSCRIPTION_CARRIER_IDENTITY_CHANGED} while its also
 * possible to be sent without {@link #ACTION_SUBSCRIPTION_CARRIER_IDENTITY_CHANGED} when
 * specific carrier ID changes while carrier ID remains the same.
 * e.g, the same subscription switches to different IMSI could potentially change its
 * specific carrier ID while carrier id remains the same.
 * @see #getSimSpecificCarrierId()
 * @see #getSimCarrierId()
 *
 * The intent will have the following extra values:
 * <ul>
 *   <li>{@link #EXTRA_SPECIFIC_CARRIER_ID} The up-to-date specific carrier id of the
 *   current subscription.
 *   </li>
 *   <li>{@link #EXTRA_SPECIFIC_CARRIER_NAME} The up-to-date name of the specific carrier id.
 *   </li>
 *   <li>{@link #EXTRA_SUBSCRIPTION_ID} The subscription id associated with the changed carrier
 *   identity.
 *   </li>
 * </ul>
 * <p class="note">This is a protected intent that can only be sent by the system.
 * @apiSince 29
 */

public static final java.lang.String ACTION_SUBSCRIPTION_SPECIFIC_CARRIER_IDENTITY_CHANGED = "android.telephony.action.SUBSCRIPTION_SPECIFIC_CARRIER_IDENTITY_CHANGED";

/**
 * UICC application type is CSIM
 * @apiSince 24
 */

public static final int APPTYPE_CSIM = 4; // 0x4

/**
 * UICC application type is ISIM
 * @apiSince 24
 */

public static final int APPTYPE_ISIM = 5; // 0x5

/**
 * UICC application type is RUIM
 * @apiSince 24
 */

public static final int APPTYPE_RUIM = 3; // 0x3

/**
 * UICC application type is SIM
 * @apiSince 24
 */

public static final int APPTYPE_SIM = 1; // 0x1

/**
 * UICC application type is USIM
 * @apiSince 24
 */

public static final int APPTYPE_USIM = 2; // 0x2

/**
 * Authentication type for UICC challenge is EAP AKA. See RFC 4187 for details.
 * @apiSince 24
 */

public static final int AUTHTYPE_EAP_AKA = 129; // 0x81

/**
 * Authentication type for UICC challenge is EAP SIM. See RFC 4186 for details.
 * @apiSince 24
 */

public static final int AUTHTYPE_EAP_SIM = 128; // 0x80

/**
 * Device call state: No activity.
 * @apiSince 1
 */

public static final int CALL_STATE_IDLE = 0; // 0x0

/**
 * Device call state: Off-hook. At least one call exists
 * that is dialing, active, or on hold, and no calls are ringing
 * or waiting.
 * @apiSince 1
 */

public static final int CALL_STATE_OFFHOOK = 2; // 0x2

/**
 * Device call state: Ringing. A new call arrived and is
 *  ringing or waiting. In the latter case, another call is
 *  already active.
 * @apiSince 1
 */

public static final int CALL_STATE_RINGING = 1; // 0x1

/**
 * Value for {@link android.telephony.CarrierConfigManager#KEY_CDMA_ROAMING_MODE_INT CarrierConfigManager#KEY_CDMA_ROAMING_MODE_INT} which permits roaming on
 * affiliated networks.
 * @apiSince 28
 */

public static final int CDMA_ROAMING_MODE_AFFILIATED = 1; // 0x1

/**
 * Value for {@link android.telephony.CarrierConfigManager#KEY_CDMA_ROAMING_MODE_INT CarrierConfigManager#KEY_CDMA_ROAMING_MODE_INT} which permits roaming on
 * any network.
 * @apiSince 28
 */

public static final int CDMA_ROAMING_MODE_ANY = 2; // 0x2

/**
 * Value for {@link android.telephony.CarrierConfigManager#KEY_CDMA_ROAMING_MODE_INT CarrierConfigManager#KEY_CDMA_ROAMING_MODE_INT} which only permits
 * connections on home networks.
 * @apiSince 28
 */

public static final int CDMA_ROAMING_MODE_HOME = 0; // 0x0

/**
 * Value for {@link android.telephony.CarrierConfigManager#KEY_CDMA_ROAMING_MODE_INT CarrierConfigManager#KEY_CDMA_ROAMING_MODE_INT} which leaves the roaming
 * mode set to the radio default or to the user's preference if they've indicated one.
 * @apiSince 28
 */

public static final int CDMA_ROAMING_MODE_RADIO_DEFAULT = -1; // 0xffffffff

/**
 * Data connection is active, but physical link is down
 * @apiSince 4
 */

public static final int DATA_ACTIVITY_DORMANT = 4; // 0x4

/**
 * Data connection activity: Currently receiving IP PPP traffic.
 * @apiSince 1
 */

public static final int DATA_ACTIVITY_IN = 1; // 0x1

/** Data connection activity: Currently both sending and receiving
 *  IP PPP traffic.     * @apiSince 1
 */

public static final int DATA_ACTIVITY_INOUT = 3; // 0x3

/**
 * Data connection activity: No traffic.
 * @apiSince 1
 */

public static final int DATA_ACTIVITY_NONE = 0; // 0x0

/**
 * Data connection activity: Currently sending IP PPP traffic.
 * @apiSince 1
 */

public static final int DATA_ACTIVITY_OUT = 2; // 0x2

/**
 * Data connection state: Connected. IP traffic should be available.
 * @apiSince 1
 */

public static final int DATA_CONNECTED = 2; // 0x2

/**
 * Data connection state: Currently setting up a data connection.
 * @apiSince 1
 */

public static final int DATA_CONNECTING = 1; // 0x1

/**
 * Data connection state: Disconnected. IP traffic not available.
 * @apiSince 1
 */

public static final int DATA_DISCONNECTED = 0; // 0x0

/**
 * Data connection state: Disconnecting.
 *
 * IP traffic may be available but will cease working imminently.
 * @apiSince R
 */

public static final int DATA_DISCONNECTING = 4; // 0x4

/** Data connection state: Suspended. The connection is up, but IP
 * traffic is temporarily unavailable. For example, in a 2G network,
 * data activity may be suspended when a voice call arrives.     * @apiSince 1
 */

public static final int DATA_SUSPENDED = 3; // 0x3

/**
 * Data connection state: Unknown.  Used before we know the state.
 * @apiSince 29
 */

public static final int DATA_UNKNOWN = -1; // 0xffffffff

/**
 * The intent to call voicemail.
 * @apiSince 26
 */

public static final java.lang.String EXTRA_CALL_VOICEMAIL_INTENT = "android.telephony.extra.CALL_VOICEMAIL_INTENT";

/**
 * An int extra used with {@link #ACTION_SUBSCRIPTION_CARRIER_IDENTITY_CHANGED} which indicates
 * the updated carrier id returned by {@link android.telephony.TelephonyManager#getSimCarrierId() TelephonyManager#getSimCarrierId()}.
 * <p>Will be {@link android.telephony.TelephonyManager#UNKNOWN_CARRIER_ID TelephonyManager#UNKNOWN_CARRIER_ID} if the subscription is unavailable or
 * the carrier cannot be identified.
 * @apiSince 28
 */

public static final java.lang.String EXTRA_CARRIER_ID = "android.telephony.extra.CARRIER_ID";

/**
 * An string extra used with {@link #ACTION_SUBSCRIPTION_CARRIER_IDENTITY_CHANGED} which
 * indicates the updated carrier name of the current subscription.
 * @see android.telephony.TelephonyManager#getSimCarrierIdName()
 * <p>Carrier name is a user-facing name of the carrier id {@link #EXTRA_CARRIER_ID},
 * usually the brand name of the subsidiary (e.g. T-Mobile).
 * @apiSince 28
 */

public static final java.lang.String EXTRA_CARRIER_NAME = "android.telephony.extra.CARRIER_NAME";

/**
 * The boolean value indicating whether the voicemail settings activity launched by {@link
 * #ACTION_CONFIGURE_VOICEMAIL} should hide settings accessible through public API. This is
 * used by dialer implementations which provides their own voicemail settings UI, but still
 * needs to expose device specific voicemail settings to the user.
 *
 * @see #ACTION_CONFIGURE_VOICEMAIL
 * @see #METADATA_HIDE_VOICEMAIL_SETTINGS_MENU
 * @apiSince 26
 */

public static final java.lang.String EXTRA_HIDE_PUBLIC_SETTINGS = "android.telephony.extra.HIDE_PUBLIC_SETTINGS";

/**
 * Extra key used with the {@link #ACTION_PHONE_STATE_CHANGED} broadcast
 * for a String containing the incoming or outgoing phone number.
 * <p>
 * This extra is only populated for receivers of the {@link #ACTION_PHONE_STATE_CHANGED}
 * broadcast which have been granted the {@link android.Manifest.permission#READ_CALL_LOG} and
 * {@link android.Manifest.permission#READ_PHONE_STATE} permissions.
 * <p>
 * For incoming calls, the phone number is only guaranteed to be populated when the
 * {@link #EXTRA_STATE} changes from {@link #EXTRA_STATE_IDLE} to {@link #EXTRA_STATE_RINGING}.
 * If the incoming caller is from an unknown number, the extra will be populated with an empty
 * string.
 * For outgoing calls, the phone number is only guaranteed to be populated when the
 * {@link #EXTRA_STATE} changes from {@link #EXTRA_STATE_IDLE} to {@link #EXTRA_STATE_OFFHOOK}.
 * <p class="note">
 * Retrieve with
 * {@link android.content.Intent#getStringExtra(String)}.
 * <p>
 *
 * @deprecated Companion apps for wearable devices should use the {@link android.telecom.InCallService InCallService} API
 * to retrieve the phone number for calls instead.  Apps performing call screening should use
 * the {@link android.telecom.CallScreeningService CallScreeningService} API instead.
 * @apiSince 3
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String EXTRA_INCOMING_NUMBER = "incoming_number";

/**
 * Boolean value representing whether the {@link android.telephony.TelephonyManager#ACTION_SHOW_VOICEMAIL_NOTIFICATION TelephonyManager#ACTION_SHOW_VOICEMAIL_NOTIFICATION} is new or a refresh of an existing
 * notification. Notification refresh happens after reboot or connectivity changes. The user has
 * already been notified for the voicemail so it should not alert the user, and should not be
 * shown again if the user has dismissed it.
 * @apiSince 27
 */

public static final java.lang.String EXTRA_IS_REFRESH = "android.telephony.extra.IS_REFRESH";

/**
 * The intent to launch voicemail settings.
 * @apiSince 26
 */

public static final java.lang.String EXTRA_LAUNCH_VOICEMAIL_SETTINGS_INTENT = "android.telephony.extra.LAUNCH_VOICEMAIL_SETTINGS_INTENT";

/**
 * The extra used with an {@link #ACTION_NETWORK_COUNTRY_CHANGED} to specify the
 * the country code in ISO 3166 format.
 * <p class="note">
 * Retrieve with {@link android.content.Intent#getStringExtra(String)}.
 * @apiSince 29
 */

public static final java.lang.String EXTRA_NETWORK_COUNTRY = "android.telephony.extra.NETWORK_COUNTRY";

/**
 * The number of voice messages associated with the notification.
 * @apiSince 26
 */

public static final java.lang.String EXTRA_NOTIFICATION_COUNT = "android.telephony.extra.NOTIFICATION_COUNT";

/**
 * The number of active SIM supported by current multi-SIM config. It's not related to how many
 * SIM/subscriptions are currently active.
 *
 * For single SIM mode, it's 1.
 * For DSDS or DSDA mode, it's 2.
 * For triple-SIM mode, it's 3.
 *
 * Extra of {@link #ACTION_MULTI_SIM_CONFIG_CHANGED}.
 *
 * type: integer
 * @apiSince R
 */

public static final java.lang.String EXTRA_NUM_OF_ACTIVE_SIM_SUPPORTED = "android.telephony.extra.NUM_OF_ACTIVE_SIM_SUPPORTED";

/**
 * The extra used with an {@link #ACTION_CONFIGURE_VOICEMAIL} and
 * {@link #ACTION_SHOW_VOICEMAIL_NOTIFICATION} {@code Intent} to specify the
 * {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} the configuration or notification is for.
 * <p class="note">
 * Retrieve with {@link android.content.Intent#getParcelableExtra(String)}.
 * @apiSince 26
 */

public static final java.lang.String EXTRA_PHONE_ACCOUNT_HANDLE = "android.telephony.extra.PHONE_ACCOUNT_HANDLE";

/**
 * An int extra used with {@link #ACTION_SUBSCRIPTION_SPECIFIC_CARRIER_IDENTITY_CHANGED} which
 * indicates the updated specific carrier id returned by
 * {@link android.telephony.TelephonyManager#getSimSpecificCarrierId() TelephonyManager#getSimSpecificCarrierId()}. Note, its possible specific carrier id
 * changes while {@link #ACTION_SUBSCRIPTION_CARRIER_IDENTITY_CHANGED} remains the same
 * e.g, when subscription switch to different IMSIs.
 * <p>Will be {@link android.telephony.TelephonyManager#UNKNOWN_CARRIER_ID TelephonyManager#UNKNOWN_CARRIER_ID} if the subscription is unavailable or
 * the carrier cannot be identified.
 * @apiSince 29
 */

public static final java.lang.String EXTRA_SPECIFIC_CARRIER_ID = "android.telephony.extra.SPECIFIC_CARRIER_ID";

/**
 * An string extra used with {@link #ACTION_SUBSCRIPTION_SPECIFIC_CARRIER_IDENTITY_CHANGED}
 * which indicates the updated specific carrier name returned by
 * {@link android.telephony.TelephonyManager#getSimSpecificCarrierIdName() TelephonyManager#getSimSpecificCarrierIdName()}.
 * <p>it's a user-facing name of the specific carrier id {@link #EXTRA_SPECIFIC_CARRIER_ID}
 * e.g, Tracfone-AT&T
 * @apiSince 29
 */

public static final java.lang.String EXTRA_SPECIFIC_CARRIER_NAME = "android.telephony.extra.SPECIFIC_CARRIER_NAME";

/**
 * The lookup key used with the {@link #ACTION_PHONE_STATE_CHANGED} broadcast
 * for a String containing the new call state.
 *
 * <p class="note">
 * Retrieve with
 * {@link android.content.Intent#getStringExtra(String)}.
 *
 * @see #EXTRA_STATE_IDLE
 * @see #EXTRA_STATE_RINGING
 * @see #EXTRA_STATE_OFFHOOK
 * @apiSince 3
 */

public static final java.lang.String EXTRA_STATE = "state";

/**
 * Value used with {@link #EXTRA_STATE} corresponding to
 * {@link #CALL_STATE_IDLE}.
 * @apiSince 3
 */

public static final java.lang.String EXTRA_STATE_IDLE;
static { EXTRA_STATE_IDLE = null; }

/**
 * Value used with {@link #EXTRA_STATE} corresponding to
 * {@link #CALL_STATE_OFFHOOK}.
 * @apiSince 3
 */

public static final java.lang.String EXTRA_STATE_OFFHOOK;
static { EXTRA_STATE_OFFHOOK = null; }

/**
 * Value used with {@link #EXTRA_STATE} corresponding to
 * {@link #CALL_STATE_RINGING}.
 * @apiSince 3
 */

public static final java.lang.String EXTRA_STATE_RINGING;
static { EXTRA_STATE_RINGING = null; }

/**
 * An int extra used with {@link #ACTION_SUBSCRIPTION_CARRIER_IDENTITY_CHANGED} to indicate the
 * subscription which has changed; or in general whenever a subscription ID needs specified.
 * @apiSince 28
 */

public static final java.lang.String EXTRA_SUBSCRIPTION_ID = "android.telephony.extra.SUBSCRIPTION_ID";

/**
 * The voicemail number.
 * @apiSince 26
 */

public static final java.lang.String EXTRA_VOICEMAIL_NUMBER = "android.telephony.extra.VOICEMAIL_NUMBER";

/**
 * A boolean meta-data value indicating whether the voicemail settings should be hidden in the
 * call settings page launched by
 * {@link android.telecom.TelecomManager#ACTION_SHOW_CALL_SETTINGS}.
 * Dialer implementations (see {@link android.telecom.TelecomManager#getDefaultDialerPackage()})
 * which would also like to manage voicemail settings should set this meta-data to {@code true}
 * in the manifest registration of their application.
 *
 * @see android.telecom.TelecomManager#ACTION_SHOW_CALL_SETTINGS
 * @see #ACTION_CONFIGURE_VOICEMAIL
 * @see #EXTRA_HIDE_PUBLIC_SETTINGS
 * @apiSince 26
 */

public static final java.lang.String METADATA_HIDE_VOICEMAIL_SETTINGS_MENU = "android.telephony.HIDE_VOICEMAIL_SETTINGS_MENU";

/** @apiSince R */

public static final int MODEM_COUNT_DUAL_MODEM = 2; // 0x2

/** @apiSince R */

public static final int MODEM_COUNT_NO_MODEM = 0; // 0x0

/** @apiSince R */

public static final int MODEM_COUNT_SINGLE_MODEM = 1; // 0x1

/** @apiSince R */

public static final int MODEM_COUNT_TRI_MODEM = 3; // 0x3

/**
 * The usage of multiple SIM cards at the same time to register on the network (e.g.&nbsp;Dual
 * Standby or Dual Active) is supported.
 * @apiSince 29
 */

public static final int MULTISIM_ALLOWED = 0; // 0x0

/**
 * The usage of multiple SIM cards at the same time to register on the network (e.g.&nbsp;Dual
 * Standby or Dual Active) is supported by the hardware, but restricted by the carrier.
 * @apiSince 29
 */

public static final int MULTISIM_NOT_SUPPORTED_BY_CARRIER = 2; // 0x2

/**
 * The usage of multiple SIM cards at the same time to register on the network (e.g.&nbsp;Dual
 * Standby or Dual Active) is not supported by the hardware.
 * @apiSince 29
 */

public static final int MULTISIM_NOT_SUPPORTED_BY_HARDWARE = 1; // 0x1

/**
 * Current network is 1xRTT
 * @apiSince 4
 */

public static final int NETWORK_TYPE_1xRTT = 7; // 0x7

/**
 * Current network is CDMA: Either IS95A or IS95B
 * @apiSince 4
 */

public static final int NETWORK_TYPE_CDMA = 4; // 0x4

/**
 * Current network is EDGE
 * @apiSince 1
 */

public static final int NETWORK_TYPE_EDGE = 2; // 0x2

/**
 * Current network is eHRPD
 * @apiSince 11
 */

public static final int NETWORK_TYPE_EHRPD = 14; // 0xe

/**
 * Current network is EVDO revision 0
 * @apiSince 4
 */

public static final int NETWORK_TYPE_EVDO_0 = 5; // 0x5

/**
 * Current network is EVDO revision A
 * @apiSince 4
 */

public static final int NETWORK_TYPE_EVDO_A = 6; // 0x6

/**
 * Current network is EVDO revision B
 * @apiSince 9
 */

public static final int NETWORK_TYPE_EVDO_B = 12; // 0xc

/**
 * Current network is GPRS
 * @apiSince 1
 */

public static final int NETWORK_TYPE_GPRS = 1; // 0x1

/**
 * Current network is GSM
 * @apiSince 25
 */

public static final int NETWORK_TYPE_GSM = 16; // 0x10

/**
 * Current network is HSDPA
 * @apiSince 5
 */

public static final int NETWORK_TYPE_HSDPA = 8; // 0x8

/**
 * Current network is HSPA
 * @apiSince 5
 */

public static final int NETWORK_TYPE_HSPA = 10; // 0xa

/**
 * Current network is HSPA+
 * @apiSince 13
 */

public static final int NETWORK_TYPE_HSPAP = 15; // 0xf

/**
 * Current network is HSUPA
 * @apiSince 5
 */

public static final int NETWORK_TYPE_HSUPA = 9; // 0x9

/**
 * Current network is iDen
 * @apiSince 8
 */

public static final int NETWORK_TYPE_IDEN = 11; // 0xb

/**
 * Current network is IWLAN
 * @apiSince 25
 */

public static final int NETWORK_TYPE_IWLAN = 18; // 0x12

/**
 * Current network is LTE
 * @apiSince 11
 */

public static final int NETWORK_TYPE_LTE = 13; // 0xd

/**
 * Current network is NR(New Radio) 5G.
 * @apiSince 29
 */

public static final int NETWORK_TYPE_NR = 20; // 0x14

/**
 * Current network is TD_SCDMA
 * @apiSince 25
 */

public static final int NETWORK_TYPE_TD_SCDMA = 17; // 0x11

/**
 * Current network is UMTS
 * @apiSince 1
 */

public static final int NETWORK_TYPE_UMTS = 3; // 0x3

/**
 * Network type is unknown
 * @apiSince 1
 */

public static final int NETWORK_TYPE_UNKNOWN = 0; // 0x0

/**
 * Phone radio is CDMA.
 * @apiSince 4
 */

public static final int PHONE_TYPE_CDMA = 2; // 0x2

/**
 * Phone radio is GSM.
 * @apiSince 1
 */

public static final int PHONE_TYPE_GSM = 1; // 0x1

/**
 * No phone radio.
 * @apiSince 1
 */

public static final int PHONE_TYPE_NONE = 0; // 0x0

/**
 * Phone is via SIP.
 * @apiSince 11
 */

public static final int PHONE_TYPE_SIP = 3; // 0x3

/**
 * The subscription is not valid. It must be an active opportunistic subscription.
 * @apiSince 29
 */

public static final int SET_OPPORTUNISTIC_SUB_INACTIVE_SUBSCRIPTION = 2; // 0x2

/**
 * The subscription is not valid. It must be an opportunistic subscription.
 * @apiSince R
 */

public static final int SET_OPPORTUNISTIC_SUB_NO_OPPORTUNISTIC_SUB_AVAILABLE = 3; // 0x3

/**
 * Subscription service happened remote exception.
 * @apiSince R
 */

public static final int SET_OPPORTUNISTIC_SUB_REMOTE_SERVICE_EXCEPTION = 4; // 0x4

/**
 * No error. Operation succeeded.
 * @apiSince 29
 */

public static final int SET_OPPORTUNISTIC_SUB_SUCCESS = 0; // 0x0

/**
 * Validation failed when trying to switch to preferred subscription.
 * @apiSince 29
 */

public static final int SET_OPPORTUNISTIC_SUB_VALIDATION_FAILED = 1; // 0x1

/**
 * SIM card state: no SIM card is available in the device
 * @apiSince 1
 */

public static final int SIM_STATE_ABSENT = 1; // 0x1

/**
 * SIM card state: SIM Card Error, present but faulty
 * @apiSince 26
 */

public static final int SIM_STATE_CARD_IO_ERROR = 8; // 0x8

/** SIM card state: SIM Card restricted, present but not usable due to
 * carrier restrictions.
 * @apiSince 26
 */

public static final int SIM_STATE_CARD_RESTRICTED = 9; // 0x9

/**
 * SIM card state: Locked: requires a network PIN to unlock
 * @apiSince 1
 */

public static final int SIM_STATE_NETWORK_LOCKED = 4; // 0x4

/**
 * SIM card state: SIM Card is NOT READY
 * @apiSince 26
 */

public static final int SIM_STATE_NOT_READY = 6; // 0x6

/**
 * SIM card state: SIM Card Error, permanently disabled
 * @apiSince 26
 */

public static final int SIM_STATE_PERM_DISABLED = 7; // 0x7

/**
 * SIM card state: Locked: requires the user's SIM PIN to unlock
 * @apiSince 1
 */

public static final int SIM_STATE_PIN_REQUIRED = 2; // 0x2

/**
 * SIM card state: Locked: requires the user's SIM PUK to unlock
 * @apiSince 1
 */

public static final int SIM_STATE_PUK_REQUIRED = 3; // 0x3

/**
 * SIM card state: Ready
 * @apiSince 1
 */

public static final int SIM_STATE_READY = 5; // 0x5

/**
 * SIM card state: Unknown. Signifies that the SIM is in transition
 * between states. For example, when the user inputs the SIM pin
 * under PIN_REQUIRED state, a query for sim status returns
 * this state before turning to SIM_STATE_READY.
 *
 * These are the ordinal value of IccCardConstants.State.
 * @apiSince 1
 */

public static final int SIM_STATE_UNKNOWN = 0; // 0x0

/**
 * A UICC card identifier used before the UICC card is loaded. See
 * {@link #getCardIdForDefaultEuicc()} and {@link android.telephony.UiccCardInfo#getCardId() UiccCardInfo#getCardId()}.
 * <p>
 * Note that once the UICC card is loaded, the card ID may become {@link #UNSUPPORTED_CARD_ID}.
 * @apiSince 29
 */

public static final int UNINITIALIZED_CARD_ID = -2; // 0xfffffffe

/**
 * An unknown carrier id. It could either be subscription unavailable or the subscription
 * carrier cannot be recognized. Unrecognized carriers here means
 * {@link #getSimOperator() MCC+MNC} cannot be identified.
 * @apiSince 28
 */

public static final int UNKNOWN_CARRIER_ID = -1; // 0xffffffff

/**
 * A UICC card identifier used if the device does not support the operation.
 * For example, {@link #getCardIdForDefaultEuicc()} returns this value if the device has no
 * eUICC, or the eUICC cannot be read.
 * @apiSince 29
 */

public static final int UNSUPPORTED_CARD_ID = -1; // 0xffffffff

/**
 * The request is aborted.
 * @apiSince 29
 */

public static final int UPDATE_AVAILABLE_NETWORKS_ABORTED = 2; // 0x2

/**
 * Disable modem fail.
 * @apiSince R
 */

public static final int UPDATE_AVAILABLE_NETWORKS_DISABLE_MODEM_FAIL = 5; // 0x5

/**
 * Enable modem fail.
 * @apiSince R
 */

public static final int UPDATE_AVAILABLE_NETWORKS_ENABLE_MODEM_FAIL = 6; // 0x6

/**
 * The parameter passed in is invalid.
 * @apiSince 29
 */

public static final int UPDATE_AVAILABLE_NETWORKS_INVALID_ARGUMENTS = 3; // 0x3

/**
 * Carrier app does not support multiple available networks.
 * @apiSince R
 */

public static final int UPDATE_AVAILABLE_NETWORKS_MULTIPLE_NETWORKS_NOT_SUPPORTED = 7; // 0x7

/**
 * No carrier privilege.
 * @apiSince 29
 */

public static final int UPDATE_AVAILABLE_NETWORKS_NO_CARRIER_PRIVILEGE = 4; // 0x4

/**
 * The subscription is not valid. It must be an opportunistic subscription.
 * @apiSince R
 */

public static final int UPDATE_AVAILABLE_NETWORKS_NO_OPPORTUNISTIC_SUB_AVAILABLE = 8; // 0x8

/**
 * There is no OpportunisticNetworkService.
 * @apiSince R
 */

public static final int UPDATE_AVAILABLE_NETWORKS_REMOTE_SERVICE_EXCEPTION = 9; // 0x9

/**
 * OpportunisticNetworkService is disabled.
 * @apiSince R
 */

public static final int UPDATE_AVAILABLE_NETWORKS_SERVICE_IS_DISABLED = 10; // 0xa

/**
 * No error. Operation succeeded.
 * @apiSince 29
 */

public static final int UPDATE_AVAILABLE_NETWORKS_SUCCESS = 0; // 0x0

/**
 * There is a unknown failure happened.
 * @apiSince 29
 */

public static final int UPDATE_AVAILABLE_NETWORKS_UNKNOWN_FAILURE = 1; // 0x1

/**
 * Failure code returned when a USSD request has failed to execute because the Telephony
 * service is unavailable.
 * <p>
 * Returned via {@link android.telephony.TelephonyManager.UssdResponseCallback#onReceiveUssdResponseFailed(android.telephony.TelephonyManager,java.lang.String,int) TelephonyManager.UssdResponseCallback#onReceiveUssdResponseFailed(
 * TelephonyManager, String, int)}.
 * @apiSince 26
 */

public static final int USSD_ERROR_SERVICE_UNAVAIL = -2; // 0xfffffffe

/**
 * Failed code returned when the mobile network has failed to complete a USSD request.
 * <p>
 * Returned via {@link android.telephony.TelephonyManager.UssdResponseCallback#onReceiveUssdResponseFailed(android.telephony.TelephonyManager,java.lang.String,int) TelephonyManager.UssdResponseCallback#onReceiveUssdResponseFailed(
 * TelephonyManager, String, int)}.
 * @apiSince 26
 */

public static final int USSD_RETURN_FAILURE = -1; // 0xffffffff

/**
 * A flavor of OMTP protocol with a different mobile originated (MO) format
 * @apiSince 23
 */

public static final java.lang.String VVM_TYPE_CVVM = "vvm_type_cvvm";

/**
 * The OMTP protocol.
 * @apiSince 23
 */

public static final java.lang.String VVM_TYPE_OMTP = "vvm_type_omtp";
/**
 * Callback for providing asynchronous {@link android.telephony.CellInfo CellInfo} on request
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class CellInfoCallback {

public CellInfoCallback() { throw new RuntimeException("Stub!"); }

/**
 * Success response to
 * {@link android.telephony.TelephonyManager#requestCellInfoUpdate requestCellInfoUpdate()}.
 *
 * Invoked when there is a response to
 * {@link android.telephony.TelephonyManager#requestCellInfoUpdate requestCellInfoUpdate()}
 * to provide a list of {@link android.telephony.CellInfo CellInfo}. If no {@link android.telephony.CellInfo CellInfo} is available then an empty
 * list will be provided. If an error occurs, null will be provided unless the onError
 * callback is overridden.
 *
 * @param cellInfo a list of {@link android.telephony.CellInfo CellInfo}, an empty list, or null.
 *
 * {@see android.telephony.TelephonyManager#getAllCellInfo getAllCellInfo()}
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public abstract void onCellInfo(@androidx.annotation.NonNull java.util.List<android.telephony.CellInfo> cellInfo);

/**
 * Error response to
 * {@link android.telephony.TelephonyManager#requestCellInfoUpdate requestCellInfoUpdate()}.
 *
 * Invoked when an error condition prevents updated {@link android.telephony.CellInfo CellInfo} from being fetched
 * and returned from the modem. Callers of requestCellInfoUpdate() should override this
 * function to receive detailed status information in the event of an error. By default,
 * this function will invoke onCellInfo() with null.
 *
 * @param errorCode an error code indicating the type of failure.
 * Value is {@link android.telephony.TelephonyManager.CellInfoCallback#ERROR_TIMEOUT}, or {@link android.telephony.TelephonyManager.CellInfoCallback#ERROR_MODEM_ERROR}
 * @param detail a Throwable object with additional detail regarding the failure if
 *     available, otherwise null.
 
 * This value may be {@code null}.
 * @apiSince 29
 */

public void onError(int errorCode, @androidx.annotation.Nullable java.lang.Throwable detail) { throw new RuntimeException("Stub!"); }

/**
 * The modem returned a failure.
 * @apiSince 29
 */

public static final int ERROR_MODEM_ERROR = 2; // 0x2

/**
 * The system timed out waiting for a response from the Radio.
 * @apiSince 29
 */

public static final int ERROR_TIMEOUT = 1; // 0x1
}

/**
 * Used to notify callers of
 * {@link android.telephony.TelephonyManager#sendUssdRequest(java.lang.String,android.telephony.TelephonyManager.UssdResponseCallback,android.os.Handler) TelephonyManager#sendUssdRequest(String, UssdResponseCallback, Handler)} when the
 * network either successfully executes a USSD request, or if there was a failure while
 * executing the request.
 * <p>
 * {@link #onReceiveUssdResponse(android.telephony.TelephonyManager,java.lang.String,java.lang.CharSequence)} will be called if the
 * USSD request has succeeded.
 * {@link #onReceiveUssdResponseFailed(android.telephony.TelephonyManager,java.lang.String,int)} will be called if the
 * USSD request has failed.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class UssdResponseCallback {

public UssdResponseCallback() { throw new RuntimeException("Stub!"); }

/**
 * Called when a USSD request has succeeded.  The {@code response} contains the USSD
 * response received from the network.  The calling app can choose to either display the
 * response to the user or perform some operation based on the response.
 * <p>
 * USSD responses are unstructured text and their content is determined by the mobile network
 * operator.
 *
 * @param telephonyManager the TelephonyManager the callback is registered to.
 * @param request the USSD request sent to the mobile network.
 * @param response the response to the USSD request provided by the mobile network.
 *        * @apiSince 26
 */

public void onReceiveUssdResponse(android.telephony.TelephonyManager telephonyManager, java.lang.String request, java.lang.CharSequence response) { throw new RuntimeException("Stub!"); }

/**
 * Called when a USSD request has failed to complete.
 *
 * @param telephonyManager the TelephonyManager the callback is registered to.
 * @param request the USSD request sent to the mobile network.
 * @param failureCode failure code indicating why the request failed.  Will be either
 *        {@link android.telephony.TelephonyManager#USSD_RETURN_FAILURE TelephonyManager#USSD_RETURN_FAILURE} or
 *        {@link android.telephony.TelephonyManager#USSD_ERROR_SERVICE_UNAVAIL TelephonyManager#USSD_ERROR_SERVICE_UNAVAIL}.
 *        * @apiSince 26
 */

public void onReceiveUssdResponseFailed(android.telephony.TelephonyManager telephonyManager, java.lang.String request, int failureCode) { throw new RuntimeException("Stub!"); }
}

}

