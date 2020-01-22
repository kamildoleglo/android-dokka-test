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

import android.os.Looper;
import java.util.concurrent.Executor;
import android.Manifest;
import android.telephony.ims.ImsReasonInfo;

/**
 * A listener class for monitoring changes in specific telephony states
 * on the device, including service state, signal strength, message
 * waiting indicator (voicemail), and others.
 * <p>
 * Override the methods for the state that you wish to receive updates for, and
 * pass your PhoneStateListener object, along with bitwise-or of the LISTEN_
 * flags to {@link android.telephony.TelephonyManager#listen TelephonyManager#listen}. Methods are
 * called when the state changes, as well as once on initial registration.
 * <p>
 * Note that access to some telephony information is
 * permission-protected. Your application won't receive updates for protected
 * information unless it has the appropriate permissions declared in
 * its manifest file. Where permissions apply, they are noted in the
 * appropriate LISTEN_ flags.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PhoneStateListener {

/**
 * Create a PhoneStateListener for the Phone with the default subscription.
 * This class requires Looper.myLooper() not return null.
 * @apiSince 1
 */

public PhoneStateListener() { throw new RuntimeException("Stub!"); }

/**
 * Create a PhoneStateListener for the Phone using the specified Executor
 *
 * <p>Create a PhoneStateListener with a specified Executor for handling necessary callbacks.
 * The Executor must not be null.
 *
 * @param executor a non-null Executor that will execute callbacks for the PhoneStateListener.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public PhoneStateListener(@androidx.annotation.NonNull java.util.concurrent.Executor executor) { throw new RuntimeException("Stub!"); }

/**
 * Callback invoked when device service state changes on the registered subscription.
 * Note, the registration subId comes from {@link android.telephony.TelephonyManager TelephonyManager} object which registers
 * PhoneStateListener by {@link android.telephony.TelephonyManager#listen(android.telephony.PhoneStateListener,int) TelephonyManager#listen(PhoneStateListener, int)}.
 * If this TelephonyManager object was created with
 * {@link android.telephony.TelephonyManager#createForSubscriptionId(int) TelephonyManager#createForSubscriptionId(int)}, then the callback applies to the
 * subId. Otherwise, this callback applies to
 * {@link android.telephony.SubscriptionManager#getDefaultSubscriptionId() SubscriptionManager#getDefaultSubscriptionId()}.
 *
 * @see android.telephony.ServiceState#STATE_EMERGENCY_ONLY
 * @see android.telephony.ServiceState#STATE_IN_SERVICE
 * @see android.telephony.ServiceState#STATE_OUT_OF_SERVICE
 * @see android.telephony.ServiceState#STATE_POWER_OFF
 * @apiSince 1
 */

public void onServiceStateChanged(android.telephony.ServiceState serviceState) { throw new RuntimeException("Stub!"); }

/**
 * Callback invoked when network signal strength changes on the registered subscription.
 * Note, the registration subId comes from {@link android.telephony.TelephonyManager TelephonyManager} object which registers
 * PhoneStateListener by {@link android.telephony.TelephonyManager#listen(android.telephony.PhoneStateListener,int) TelephonyManager#listen(PhoneStateListener, int)}.
 * If this TelephonyManager object was created with
 * {@link android.telephony.TelephonyManager#createForSubscriptionId(int) TelephonyManager#createForSubscriptionId(int)}, then the callback applies to the
 * subId. Otherwise, this callback applies to
 * {@link android.telephony.SubscriptionManager#getDefaultSubscriptionId() SubscriptionManager#getDefaultSubscriptionId()}.
 *
 * @see android.telephony.ServiceState#STATE_EMERGENCY_ONLY
 * @see android.telephony.ServiceState#STATE_IN_SERVICE
 * @see android.telephony.ServiceState#STATE_OUT_OF_SERVICE
 * @see android.telephony.ServiceState#STATE_POWER_OFF
 * @deprecated Use {@link #onSignalStrengthsChanged(android.telephony.SignalStrength)}
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public void onSignalStrengthChanged(int asu) { throw new RuntimeException("Stub!"); }

/**
 * Callback invoked when the message-waiting indicator changes on the registered subscription.
 * Note, the registration subId comes from {@link android.telephony.TelephonyManager TelephonyManager} object which registers
 * PhoneStateListener by {@link android.telephony.TelephonyManager#listen(android.telephony.PhoneStateListener,int) TelephonyManager#listen(PhoneStateListener, int)}.
 * If this TelephonyManager object was created with
 * {@link android.telephony.TelephonyManager#createForSubscriptionId(int) TelephonyManager#createForSubscriptionId(int)}, then the callback applies to the
 * subId. Otherwise, this callback applies to
 * {@link android.telephony.SubscriptionManager#getDefaultSubscriptionId() SubscriptionManager#getDefaultSubscriptionId()}.
 * @apiSince 1
 */

public void onMessageWaitingIndicatorChanged(boolean mwi) { throw new RuntimeException("Stub!"); }

/**
 * Callback invoked when the call-forwarding indicator changes on the registered subscription.
 * Note, the registration subId comes from {@link android.telephony.TelephonyManager TelephonyManager} object which registers
 * PhoneStateListener by {@link android.telephony.TelephonyManager#listen(android.telephony.PhoneStateListener,int) TelephonyManager#listen(PhoneStateListener, int)}.
 * If this TelephonyManager object was created with
 * {@link android.telephony.TelephonyManager#createForSubscriptionId(int) TelephonyManager#createForSubscriptionId(int)}, then the callback applies to the
 * subId. Otherwise, this callback applies to
 * {@link android.telephony.SubscriptionManager#getDefaultSubscriptionId() SubscriptionManager#getDefaultSubscriptionId()}.
 * @apiSince 1
 */

public void onCallForwardingIndicatorChanged(boolean cfi) { throw new RuntimeException("Stub!"); }

/**
 * Callback invoked when device cell location changes on the registered subscription.
 * Note, the registration subId comes from {@link android.telephony.TelephonyManager TelephonyManager} object which registers
 * PhoneStateListener by {@link android.telephony.TelephonyManager#listen(android.telephony.PhoneStateListener,int) TelephonyManager#listen(PhoneStateListener, int)}.
 * If this TelephonyManager object was created with
 * {@link android.telephony.TelephonyManager#createForSubscriptionId(int) TelephonyManager#createForSubscriptionId(int)}, then the callback applies to the
 * subId. Otherwise, this callback applies to
 * {@link android.telephony.SubscriptionManager#getDefaultSubscriptionId() SubscriptionManager#getDefaultSubscriptionId()}.
 * @apiSince 1
 */

public void onCellLocationChanged(android.telephony.CellLocation location) { throw new RuntimeException("Stub!"); }

/**
 * Callback invoked when device call state changes.
 * <p>
 * Reports the state of Telephony (mobile) calls on the device for the registered subscription.
 * <p>
 * Note: the registration subId comes from {@link android.telephony.TelephonyManager TelephonyManager} object which registers
 * PhoneStateListener by {@link android.telephony.TelephonyManager#listen(android.telephony.PhoneStateListener,int) TelephonyManager#listen(PhoneStateListener, int)}.
 * If this TelephonyManager object was created with
 * {@link android.telephony.TelephonyManager#createForSubscriptionId(int) TelephonyManager#createForSubscriptionId(int)}, then the callback applies to the
 * subId. Otherwise, this callback applies to
 * {@link android.telephony.SubscriptionManager#getDefaultSubscriptionId() SubscriptionManager#getDefaultSubscriptionId()}.
 * <p>
 * Note: The state returned here may differ from that returned by
 * {@link android.telephony.TelephonyManager#getCallState() TelephonyManager#getCallState()}. Receivers of this callback should be aware that
 * calling {@link android.telephony.TelephonyManager#getCallState() TelephonyManager#getCallState()} from within this callback may return a
 * different state than the callback reports.
 *
 * @param state call state
 * Value is {@link android.telephony.TelephonyManager#CALL_STATE_IDLE}, {@link android.telephony.TelephonyManager#CALL_STATE_RINGING}, or {@link android.telephony.TelephonyManager#CALL_STATE_OFFHOOK}
 * @param phoneNumber call phone number. If application does not have
 * {@link android.Manifest.permission#READ_CALL_LOG READ_CALL_LOG} permission or carrier
 * privileges (see {@link android.telephony.TelephonyManager#hasCarrierPrivileges TelephonyManager#hasCarrierPrivileges}), an empty string will be
 * passed as an argument.
 * @apiSince 1
 */

public void onCallStateChanged(int state, java.lang.String phoneNumber) { throw new RuntimeException("Stub!"); }

/**
 * Callback invoked when connection state changes on the registered subscription.
 * Note, the registration subId comes from {@link android.telephony.TelephonyManager TelephonyManager} object which registers
 * PhoneStateListener by {@link android.telephony.TelephonyManager#listen(android.telephony.PhoneStateListener,int) TelephonyManager#listen(PhoneStateListener, int)}.
 * If this TelephonyManager object was created with
 * {@link android.telephony.TelephonyManager#createForSubscriptionId(int) TelephonyManager#createForSubscriptionId(int)}, then the callback applies to the
 * subId. Otherwise, this callback applies to
 * {@link android.telephony.SubscriptionManager#getDefaultSubscriptionId() SubscriptionManager#getDefaultSubscriptionId()}.
 *
 * @see android.telephony.TelephonyManager#DATA_DISCONNECTED
 * @see android.telephony.TelephonyManager#DATA_CONNECTING
 * @see android.telephony.TelephonyManager#DATA_CONNECTED
 * @see android.telephony.TelephonyManager#DATA_SUSPENDED
 * @apiSince 1
 */

public void onDataConnectionStateChanged(int state) { throw new RuntimeException("Stub!"); }

/**
 * same as above, but with the network type.  Both called.
 * @apiSince 7
 */

public void onDataConnectionStateChanged(int state, int networkType) { throw new RuntimeException("Stub!"); }

/**
 * Callback invoked when data activity state changes on the registered subscription.
 * Note, the registration subId comes from {@link android.telephony.TelephonyManager TelephonyManager} object which registers
 * PhoneStateListener by {@link android.telephony.TelephonyManager#listen(android.telephony.PhoneStateListener,int) TelephonyManager#listen(PhoneStateListener, int)}.
 * If this TelephonyManager object was created with
 * {@link android.telephony.TelephonyManager#createForSubscriptionId(int) TelephonyManager#createForSubscriptionId(int)}, then the callback applies to the
 * subId. Otherwise, this callback applies to
 * {@link android.telephony.SubscriptionManager#getDefaultSubscriptionId() SubscriptionManager#getDefaultSubscriptionId()}.
 *
 * @see android.telephony.TelephonyManager#DATA_ACTIVITY_NONE
 * @see android.telephony.TelephonyManager#DATA_ACTIVITY_IN
 * @see android.telephony.TelephonyManager#DATA_ACTIVITY_OUT
 * @see android.telephony.TelephonyManager#DATA_ACTIVITY_INOUT
 * @see android.telephony.TelephonyManager#DATA_ACTIVITY_DORMANT
 * @apiSince 1
 */

public void onDataActivity(int direction) { throw new RuntimeException("Stub!"); }

/**
 * Callback invoked when network signal strengths changes on the registered subscription.
 * Note, the registration subId comes from {@link android.telephony.TelephonyManager TelephonyManager} object which registers
 * PhoneStateListener by {@link android.telephony.TelephonyManager#listen(android.telephony.PhoneStateListener,int) TelephonyManager#listen(PhoneStateListener, int)}.
 * If this TelephonyManager object was created with
 * {@link android.telephony.TelephonyManager#createForSubscriptionId(int) TelephonyManager#createForSubscriptionId(int)}, then the callback applies to the
 * subId. Otherwise, this callback applies to
 * {@link android.telephony.SubscriptionManager#getDefaultSubscriptionId() SubscriptionManager#getDefaultSubscriptionId()}.
 * @apiSince 7
 */

public void onSignalStrengthsChanged(android.telephony.SignalStrength signalStrength) { throw new RuntimeException("Stub!"); }

/**
 * Callback invoked when a observed cell info has changed or new cells have been added
 * or removed on the registered subscription.
 * Note, the registration subId s from {@link android.telephony.TelephonyManager TelephonyManager} object which registers
 * PhoneStateListener by {@link android.telephony.TelephonyManager#listen(android.telephony.PhoneStateListener,int) TelephonyManager#listen(PhoneStateListener, int)}.
 * If this TelephonyManager object was created with
 * {@link android.telephony.TelephonyManager#createForSubscriptionId(int) TelephonyManager#createForSubscriptionId(int)}, then the callback applies to the
 * subId. Otherwise, this callback applies to
 * {@link android.telephony.SubscriptionManager#getDefaultSubscriptionId() SubscriptionManager#getDefaultSubscriptionId()}.
 *
 * @param cellInfo is the list of currently visible cells.
 * @apiSince 17
 */

public void onCellInfoChanged(java.util.List<android.telephony.CellInfo> cellInfo) { throw new RuntimeException("Stub!"); }

/**
 * Callback invoked when call disconnect cause changes on the registered subscription.
 * Note, the registration subId comes from {@link android.telephony.TelephonyManager TelephonyManager} object which registers
 * PhoneStateListener by {@link android.telephony.TelephonyManager#listen(android.telephony.PhoneStateListener,int) TelephonyManager#listen(PhoneStateListener, int)}.
 * If this TelephonyManager object was created with
 * {@link android.telephony.TelephonyManager#createForSubscriptionId(int) TelephonyManager#createForSubscriptionId(int)}, then the callback applies to the
 * subId. Otherwise, this callback applies to
 * {@link android.telephony.SubscriptionManager#getDefaultSubscriptionId() SubscriptionManager#getDefaultSubscriptionId()}.
 *
 * <br>
 * Requires android.Manifest.permission.READ_PRECISE_PHONE_STATE
 * @param disconnectCause {@link android.telephony.DisconnectCause DisconnectCause}.
 * @param preciseDisconnectCause {@link android.telephony.PreciseDisconnectCause PreciseDisconnectCause}.
 *
 * @apiSince R
 */

public void onCallDisconnectCauseChanged(int disconnectCause, int preciseDisconnectCause) { throw new RuntimeException("Stub!"); }

/**
 * Callback invoked when Ims call disconnect cause changes on the registered subscription.
 * Note, the registration subId comes from {@link android.telephony.TelephonyManager TelephonyManager} object which registers
 * PhoneStateListener by {@link android.telephony.TelephonyManager#listen(android.telephony.PhoneStateListener,int) TelephonyManager#listen(PhoneStateListener, int)}.
 * If this TelephonyManager object was created with
 * {@link android.telephony.TelephonyManager#createForSubscriptionId(int) TelephonyManager#createForSubscriptionId(int)}, then the callback applies to the
 * subId. Otherwise, this callback applies to
 * {@link android.telephony.SubscriptionManager#getDefaultSubscriptionId() SubscriptionManager#getDefaultSubscriptionId()}.
 *
 * <br>
 * Requires android.Manifest.permission.READ_PRECISE_PHONE_STATE
 * @param imsReasonInfo {@link android.telephony.ims.ImsReasonInfo ImsReasonInfo} contains details on why IMS call failed.
 *
 
 * This value must never be {@code null}.
 * @apiSince R
 */

public void onImsCallDisconnectCauseChanged(@androidx.annotation.NonNull android.telephony.ims.ImsReasonInfo imsReasonInfo) { throw new RuntimeException("Stub!"); }

/**
 * Callback providing update about the default/internet data connection on the registered
 * subscription.
 *
 * Note, the registration subId comes from {@link android.telephony.TelephonyManager TelephonyManager} object which registers
 * PhoneStateListener by {@link android.telephony.TelephonyManager#listen(android.telephony.PhoneStateListener,int) TelephonyManager#listen(PhoneStateListener, int)}.
 * If this TelephonyManager object was created with
 * {@link android.telephony.TelephonyManager#createForSubscriptionId(int) TelephonyManager#createForSubscriptionId(int)}, then the callback applies to the
 * subId. Otherwise, this callback applies to
 * {@link android.telephony.SubscriptionManager#getDefaultSubscriptionId() SubscriptionManager#getDefaultSubscriptionId()}.
 *
 * <p>Requires permission {@link android.Manifest.permission#MODIFY_PHONE_STATE}
 * or the calling app has carrier privileges
 * (see {@link android.telephony.TelephonyManager#hasCarrierPrivileges TelephonyManager#hasCarrierPrivileges}).
 *
 * <br>
 * Requires {@link android.Manifest.permission#MODIFY_PHONE_STATE}
 * @param dataConnectionState {@link android.telephony.PreciseDataConnectionState PreciseDataConnectionState}
 
 * This value must never be {@code null}.
 * @apiSince R
 */

public void onPreciseDataConnectionStateChanged(@androidx.annotation.NonNull android.telephony.PreciseDataConnectionState dataConnectionState) { throw new RuntimeException("Stub!"); }

/**
 * Callback invoked when the user mobile data state has changed on the registered subscription.
 * Note, the registration subId comes from {@link android.telephony.TelephonyManager TelephonyManager} object which registers
 * PhoneStateListener by {@link android.telephony.TelephonyManager#listen(android.telephony.PhoneStateListener,int) TelephonyManager#listen(PhoneStateListener, int)}.
 * If this TelephonyManager object was created with
 * {@link android.telephony.TelephonyManager#createForSubscriptionId(int) TelephonyManager#createForSubscriptionId(int)}, then the callback applies to the
 * subId. Otherwise, this callback applies to
 * {@link android.telephony.SubscriptionManager#getDefaultSubscriptionId() SubscriptionManager#getDefaultSubscriptionId()}.
 *
 * @param enabled indicates whether the current user mobile data state is enabled or disabled.
 * @apiSince 28
 */

public void onUserMobileDataStateChanged(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Callback invoked when active data subId changes.
 * Note, this callback triggers regardless of registered subscription.
 *
 * Requires the READ_PHONE_STATE permission.
 * @param subId current subscription used to setup Cellular Internet data.
 *              For example, it could be the current active opportunistic subscription in use,
 *              or the subscription user selected as default data subscription in DSDS mode.
 * @apiSince 29
 */

public void onActiveDataSubscriptionIdChanged(int subId) { throw new RuntimeException("Stub!"); }

/**
 *  Listen for changes to active data subId. Active data subscription is
 *  the current subscription used to setup Cellular Internet data. For example,
 *  it could be the current active opportunistic subscription in use, or the
 *  subscription user selected as default data subscription in DSDS mode.
 *
 *  @see #onActiveDataSubscriptionIdChanged
 * @apiSince 29
 */

public static final int LISTEN_ACTIVE_DATA_SUBSCRIPTION_ID_CHANGE = 4194304; // 0x400000

/**
 * Listen for call disconnect causes which contains {@link android.telephony.DisconnectCause DisconnectCause} and
 * {@link android.telephony.PreciseDisconnectCause PreciseDisconnectCause}.
 *
 
 * <br>
 * Requires android.Manifest.permission.READ_PRECISE_PHONE_STATE
 * @apiSince R
 */

public static final int LISTEN_CALL_DISCONNECT_CAUSES = 33554432; // 0x2000000

/**
 * Listen for changes to the call-forwarding indicator.
 * {@more}
 * Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE
 * READ_PHONE_STATE} or that the calling app has carrier privileges (see
 * {@link android.telephony.TelephonyManager#hasCarrierPrivileges TelephonyManager#hasCarrierPrivileges}).
 *
 * @see #onCallForwardingIndicatorChanged
 * @apiSince 1
 */

public static final int LISTEN_CALL_FORWARDING_INDICATOR = 8; // 0x8

/**
 * Listen for changes to the device call state.
 * {@more}
 *
 * @see #onCallStateChanged
 * @apiSince 1
 */

public static final int LISTEN_CALL_STATE = 32; // 0x20

/**
 * Listen for changes to observed cell info.
 *
 * @see #onCellInfoChanged
 * @apiSince 17
 */

public static final int LISTEN_CELL_INFO = 1024; // 0x400

/**
 * Listen for changes to the device's cell location. Note that
 * this will result in frequent callbacks to the listener.
 * {@more}
 * Requires Permission: {@link android.Manifest.permission#ACCESS_COARSE_LOCATION
 * ACCESS_COARSE_LOCATION}
 * <p>
 * If you need regular location updates but want more control over
 * the update interval or location precision, you can set up a listener
 * through the {@link android.location.LocationManager location manager}
 * instead.
 *
 * @see #onCellLocationChanged
 * @apiSince 1
 */

public static final int LISTEN_CELL_LOCATION = 16; // 0x10

/**
 * Listen for changes to the direction of data traffic on the data
 * connection (cellular).
 * {@more}
 * Example: The status bar uses this to display the appropriate
 * data-traffic icon.
 *
 * @see #onDataActivity
 * @apiSince 1
 */

public static final int LISTEN_DATA_ACTIVITY = 128; // 0x80

/**
 * Listen for changes to the data connection state (cellular).
 *
 * @see #onDataConnectionStateChanged
 * @apiSince 1
 */

public static final int LISTEN_DATA_CONNECTION_STATE = 64; // 0x40

/**
 * Listen for changes to emergency number list based on all active subscriptions.
 *
 * <p>Requires permission {@link android.Manifest.permission#READ_PHONE_STATE} or the calling
 * app has carrier privileges (see {@link android.telephony.TelephonyManager#hasCarrierPrivileges TelephonyManager#hasCarrierPrivileges}).
 *
 * @see #onEmergencyNumberListChanged
 * @apiSince 29
 */

public static final int LISTEN_EMERGENCY_NUMBER_LIST = 16777216; // 0x1000000

/**
 * Listen for IMS call disconnect causes which contains
 * {@link android.telephony.ims.ImsReasonInfo}
 *
 * <br>
 * Requires android.Manifest.permission.READ_PRECISE_PHONE_STATE
 * @see #onImsCallDisconnectCauseChanged(ImsReasonInfo)
 * @apiSince R
 */

public static final int LISTEN_IMS_CALL_DISCONNECT_CAUSES = 134217728; // 0x8000000

/**
 * Listen for changes to the message-waiting indicator.
 * {@more}
 * Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE
 * READ_PHONE_STATE} or that the calling app has carrier privileges (see
 * {@link android.telephony.TelephonyManager#hasCarrierPrivileges TelephonyManager#hasCarrierPrivileges}).
 * <p>
 * Example: The status bar uses this to determine when to display the
 * voicemail icon.
 *
 * @see #onMessageWaitingIndicatorChanged
 * @apiSince 1
 */

public static final int LISTEN_MESSAGE_WAITING_INDICATOR = 4; // 0x4

/**
 * Stop listening for updates.
 *
 * The PhoneStateListener is not tied to any subscription and unregistered for any update.
 * @apiSince 1
 */

public static final int LISTEN_NONE = 0; // 0x0

/**
 * Listen for {@link android.telephony.PreciseDataConnectionState PreciseDataConnectionState} on the data connection (cellular).
 *
 * <p>Requires permission {@link android.Manifest.permission#MODIFY_PHONE_STATE}
 * or the calling app has carrier privileges
 * (see {@link android.telephony.TelephonyManager#hasCarrierPrivileges TelephonyManager#hasCarrierPrivileges}).
 *
 * <br>
 * Requires {@link android.Manifest.permission#MODIFY_PHONE_STATE}
 * @see #onPreciseDataConnectionStateChanged
 * @apiSince R
 */

public static final int LISTEN_PRECISE_DATA_CONNECTION_STATE = 4096; // 0x1000

/**
 *  Listen for changes to the network service state (cellular).
 *
 *  @see #onServiceStateChanged
 *  @see android.telephony.ServiceState
 * @apiSince 1
 */

public static final int LISTEN_SERVICE_STATE = 1; // 0x1

/**
 * Listen for changes to the network signal strength (cellular).
 * {@more}
 *
 * @see #onSignalStrengthChanged
 *
 * @deprecated by {@link #LISTEN_SIGNAL_STRENGTHS}
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int LISTEN_SIGNAL_STRENGTH = 2; // 0x2

/**
 * Listen for changes to the network signal strengths (cellular).
 * <p>
 * Example: The status bar uses this to control the signal-strength
 * icon.
 *
 * @see #onSignalStrengthsChanged
 * @apiSince 7
 */

public static final int LISTEN_SIGNAL_STRENGTHS = 256; // 0x100

/**
 *  Listen for changes to the user mobile data state
 *
 *  @see #onUserMobileDataStateChanged
 * @apiSince 28
 */

public static final int LISTEN_USER_MOBILE_DATA_STATE = 524288; // 0x80000
}

