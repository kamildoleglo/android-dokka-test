/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */


package android.telecom;

import android.content.Context;
import android.Manifest;
import android.telephony.SubscriptionManager;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.content.ComponentName;
import android.telephony.TelephonyManager;

/**
 * Provides access to information about active calls and registration/call-management functionality.
 * Apps can use methods in this class to determine the current call state.
 * <p>
 * Apps do not instantiate this class directly; instead, they retrieve a reference to an instance
 * through {@link android.content.Context#getSystemService Context#getSystemService}.
 * <p>
 * Note that access to some telecom information is permission-protected. Your app cannot access the
 * protected information or gain access to protected functionality unless it has the appropriate
 * permissions declared in its manifest file. Where permissions apply, they are noted in the method
 * descriptions.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TelecomManager {

TelecomManager() { throw new RuntimeException("Stub!"); }

/**
 * Return the {@link android.telecom.PhoneAccount PhoneAccount} which will be used to place outgoing calls to addresses with
 * the specified {@code uriScheme}. This {@link android.telecom.PhoneAccount PhoneAccount} will always be a member of the
 * list which is returned from invoking {@link #getCallCapablePhoneAccounts()}. The specific
 * account returned depends on the following priorities:
 * <ul>
 * <li> If the user-selected default {@link android.telecom.PhoneAccount PhoneAccount} supports the specified scheme, it will
 * be returned.
 * </li>
 * <li> If there exists only one {@link android.telecom.PhoneAccount PhoneAccount} that supports the specified scheme, it
 * will be returned.
 * </li>
 * </ul>
 * <p>
 * If no {@link android.telecom.PhoneAccount PhoneAccount} fits the criteria above, this method will return {@code null}.
 *
 * Requires permission: {@link android.Manifest.permission#READ_PHONE_STATE}
 *
 * <br>
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @param uriScheme The URI scheme.
 * @return The {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} corresponding to the account to be used.
 * @apiSince 23
 */

public android.telecom.PhoneAccountHandle getDefaultOutgoingPhoneAccount(java.lang.String uriScheme) { throw new RuntimeException("Stub!"); }

/**
 * Return the {@link android.telecom.PhoneAccount PhoneAccount} which is the user-chosen default for making outgoing phone
 * calls. This {@code PhoneAccount} will always be a member of the list which is returned from
 * calling {@link #getCallCapablePhoneAccounts()}
 * <p>
 * Apps must be prepared for this method to return {@code null}, indicating that there currently
 * exists no user-chosen default {@code PhoneAccount}.
 * <p>
 * The default dialer has access to use this method.
 *
 * <br>
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @return The user outgoing phone account selected by the user, or {@code null} if there is no
 * user selected outgoing {@link android.telecom.PhoneAccountHandle PhoneAccountHandle}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.telecom.PhoneAccountHandle getUserSelectedOutgoingPhoneAccount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current SIM call manager. Apps must be prepared for this method to return
 * {@code null}, indicating that there currently exists no SIM call manager {@link android.telecom.PhoneAccount PhoneAccount}
 * for the default voice subscription.
 *
 * @return The phone account handle of the current sim call manager for the default voice
 * subscription.
 * @see android.telephony.SubscriptionManager#getDefaultVoiceSubscriptionId()
 * @apiSince 23
 */

public android.telecom.PhoneAccountHandle getSimCallManager() { throw new RuntimeException("Stub!"); }

/**
 * Returns current SIM call manager for the Telephony Subscription ID specified. Apps must be
 * prepared for this method to return {@code null}, indicating that there currently exists no
 * SIM call manager {@link android.telecom.PhoneAccount PhoneAccount} for the subscription specified.
 *
 * @param subscriptionId The Telephony Subscription ID that the SIM call manager should be
 *                       queried for.
 * @return The phone account handle of the current sim call manager.
 * @see android.telephony.SubscriptionManager#getActiveSubscriptionInfoList()
 * @apiSince R
 */

@androidx.annotation.Nullable
public android.telecom.PhoneAccountHandle getSimCallManagerForSubscription(int subscriptionId) { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of {@link android.telecom.PhoneAccountHandle PhoneAccountHandle}s which can be used to make and receive phone
 * calls. The returned list includes only those accounts which have been explicitly enabled
 * by the user.
 *
 * Requires permission: {@link android.Manifest.permission#READ_PHONE_STATE}
 *
 * <br>
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @see #EXTRA_PHONE_ACCOUNT_HANDLE
 * @return A list of {@code PhoneAccountHandle} objects.
 * @apiSince 23
 */

public java.util.List<android.telecom.PhoneAccountHandle> getCallCapablePhoneAccounts() { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of {@link android.telecom.PhoneAccountHandle PhoneAccountHandle}s for self-managed {@link android.telecom.ConnectionService ConnectionService}s.
 * <p>
 * Self-Managed {@link android.telecom.ConnectionService ConnectionService}s have a {@link android.telecom.PhoneAccount PhoneAccount} with
 * {@link android.telecom.PhoneAccount#CAPABILITY_SELF_MANAGED PhoneAccount#CAPABILITY_SELF_MANAGED}.
 * <p>
 * Requires permission {@link android.Manifest.permission#READ_PHONE_STATE}, or that the caller
 * is the default dialer app.
 * <p>
 * A {@link java.lang.SecurityException SecurityException} will be thrown if a called is not the default dialer, or lacks
 * the {@link android.Manifest.permission#READ_PHONE_STATE} permission.
 *
 * <br>
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @return A list of {@code PhoneAccountHandle} objects.
 * @apiSince 26
 */

public java.util.List<android.telecom.PhoneAccountHandle> getSelfManagedPhoneAccounts() { throw new RuntimeException("Stub!"); }

/**
 * Return the {@link android.telecom.PhoneAccount PhoneAccount} for a specified {@link android.telecom.PhoneAccountHandle PhoneAccountHandle}. Object includes
 * resources which can be used in a user interface.
 *
 * @param account The {@link android.telecom.PhoneAccountHandle PhoneAccountHandle}.
 * @return The {@link android.telecom.PhoneAccount PhoneAccount} object.
 * @apiSince 23
 */

public android.telecom.PhoneAccount getPhoneAccount(android.telecom.PhoneAccountHandle account) { throw new RuntimeException("Stub!"); }

/**
 * Register a {@link android.telecom.PhoneAccount PhoneAccount} for use by the system that will be stored in Device Encrypted
 * storage. When registering {@link android.telecom.PhoneAccount PhoneAccount}s, existing registrations will be overwritten
 * if the {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} matches that of a {@link android.telecom.PhoneAccount PhoneAccount} which is already
 * registered. Once registered, the {@link android.telecom.PhoneAccount PhoneAccount} is listed to the user as an option
 * when placing calls. The user may still need to enable the {@link android.telecom.PhoneAccount PhoneAccount} within
 * the phone app settings before the account is usable.
 * <p>
 * A {@link java.lang.SecurityException SecurityException} will be thrown if an app tries to register a
 * {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} where the package name specified within
 * {@link android.telecom.PhoneAccountHandle#getComponentName() PhoneAccountHandle#getComponentName()} does not match the package name of the app.
 *
 * @param account The complete {@link android.telecom.PhoneAccount PhoneAccount}.
 * @apiSince 23
 */

public void registerPhoneAccount(android.telecom.PhoneAccount account) { throw new RuntimeException("Stub!"); }

/**
 * Remove a {@link android.telecom.PhoneAccount PhoneAccount} registration from the system.
 *
 * @param accountHandle A {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} for the {@link android.telecom.PhoneAccount PhoneAccount} to unregister.
 * @apiSince 23
 */

public void unregisterPhoneAccount(android.telecom.PhoneAccountHandle accountHandle) { throw new RuntimeException("Stub!"); }

/**
 * Used to determine the currently selected default dialer package.
 *
 * @return package name for the default dialer package or null if no package has been
 *         selected as the default dialer.
 * @apiSince 23
 */

public java.lang.String getDefaultDialerPackage() { throw new RuntimeException("Stub!"); }

/**
 * Determines the package name of the system-provided default phone app.
 *
 * @return package name for the system dialer package or {@code null} if no system dialer is
 *         preloaded.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.lang.String getSystemDialerPackage() { throw new RuntimeException("Stub!"); }

/**
 * Return whether a given phone number is the configured voicemail number for a
 * particular phone account.
 *
 * Requires permission: {@link android.Manifest.permission#READ_PHONE_STATE}
 *
 * <br>
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @param accountHandle The handle for the account to check the voicemail number against
 * @param number The number to look up.
 * @apiSince 23
 */

public boolean isVoiceMailNumber(android.telecom.PhoneAccountHandle accountHandle, java.lang.String number) { throw new RuntimeException("Stub!"); }

/**
 * Return the voicemail number for a given phone account.
 *
 * Requires permission: {@link android.Manifest.permission#READ_PHONE_STATE}
 *
 * <br>
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @param accountHandle The handle for the phone account.
 * @return The voicemail number for the phone account, and {@code null} if one has not been
 *         configured.
 * @apiSince 23
 */

public java.lang.String getVoiceMailNumber(android.telecom.PhoneAccountHandle accountHandle) { throw new RuntimeException("Stub!"); }

/**
 * Return the line 1 phone number for given phone account.
 *
 * Requires permission: {@link android.Manifest.permission#READ_PHONE_STATE}
 *
 * <br>
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @param accountHandle The handle for the account retrieve a number for.
 * @return A string representation of the line 1 phone number.
 * @apiSince 23
 */

public java.lang.String getLine1Number(android.telecom.PhoneAccountHandle accountHandle) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether there is an ongoing phone call (can be in dialing, ringing, active or holding
 * states) originating from either a manager or self-managed {@link android.telecom.ConnectionService ConnectionService}.
 * <p>
 * Requires permission: {@link android.Manifest.permission#READ_PHONE_STATE}
 *
 * <br>
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @return {@code true} if there is an ongoing call in either a managed or self-managed
 *      {@link android.telecom.ConnectionService ConnectionService}, {@code false} otherwise.
 * @apiSince 21
 */

public boolean isInCall() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether there is an ongoing call originating from a managed
 * {@link android.telecom.ConnectionService ConnectionService}.  An ongoing call can be in dialing, ringing, active or holding
 * states.
 * <p>
 * If you also need to know if there are ongoing self-managed calls, use {@link #isInCall()}
 * instead.
 * <p>
 * Requires permission: {@link android.Manifest.permission#READ_PHONE_STATE}
 *
 * <br>
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @return {@code true} if there is an ongoing call in a managed {@link android.telecom.ConnectionService ConnectionService},
 *      {@code false} otherwise.
 * @apiSince 26
 */

public boolean isInManagedCall() { throw new RuntimeException("Stub!"); }

/**
 * Ends the foreground call on the device.
 * <p>
 * If there is a ringing call, calling this method rejects the ringing call.  Otherwise the
 * foreground call is ended.
 * <p>
 * Requires permission {@link android.Manifest.permission#ANSWER_PHONE_CALLS}.
 * <p>
 * Note: this method CANNOT be used to end ongoing emergency calls and will return {@code false}
 * if an attempt is made to end an emergency call.
 *
 * <br>
 * Requires {@link android.Manifest.permission#ANSWER_PHONE_CALLS}
 * @return {@code true} if there is a call which will be rejected or terminated, {@code false}
 * otherwise.
 * @deprecated Companion apps for wearable devices should use the {@link android.telecom.InCallService InCallService} API
 * instead.  Apps performing call screening should use the {@link android.telecom.CallScreeningService CallScreeningService} API
 * instead.
 * @apiSince 28
 * @deprecatedSince 29
 */

@Deprecated
public boolean endCall() { throw new RuntimeException("Stub!"); }

/**
 * If there is a ringing incoming call, this method accepts the call on behalf of the user.
 *
 * If the incoming call is a video call, the call will be answered with the same video state as
 * the incoming call requests.  This means, for example, that an incoming call requesting
 * {@link android.telecom.VideoProfile#STATE_BIDIRECTIONAL VideoProfile#STATE_BIDIRECTIONAL} will be answered, accepting that state.
 *
 * Requires permission: {@link android.Manifest.permission#MODIFY_PHONE_STATE} or
 * {@link android.Manifest.permission#ANSWER_PHONE_CALLS}
 *
 * <br>
 * Requires {@link android.Manifest.permission#ANSWER_PHONE_CALLS} or {@link android.Manifest.permission#MODIFY_PHONE_STATE}
 * @deprecated Companion apps for wearable devices should use the {@link android.telecom.InCallService InCallService} API
 * instead.
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated
public void acceptRingingCall() { throw new RuntimeException("Stub!"); }

/**
 * If there is a ringing incoming call, this method accepts the call on behalf of the user,
 * with the specified video state.
 *
 * Requires permission: {@link android.Manifest.permission#MODIFY_PHONE_STATE} or
 * {@link android.Manifest.permission#ANSWER_PHONE_CALLS}
 *
 * <br>
 * Requires {@link android.Manifest.permission#ANSWER_PHONE_CALLS} or {@link android.Manifest.permission#MODIFY_PHONE_STATE}
 * @param videoState The desired video state to answer the call with.
 * @deprecated Companion apps for wearable devices should use the {@link android.telecom.InCallService InCallService} API
 * instead.
 * @apiSince 26
 * @deprecatedSince 29
 */

@Deprecated
public void acceptRingingCall(int videoState) { throw new RuntimeException("Stub!"); }

/**
 * Silences the ringer if a ringing call exists.
 * <p>
 * This method can only be relied upon to stop the ringtone for a call if the ringtone has
 * already started playing.  It is intended to handle use-cases such as silencing a ringing call
 * when the user presses the volume button during ringing.
 * <p>
 * If this method is called prior to when the ringtone begins playing, the ringtone will not be
 * silenced.  As such it is not intended as a means to avoid playing of a ringtone.
 * <p>
 * A dialer app which wants to have more control over ringtone playing should declare
 * {@link android.telecom.TelecomManager#METADATA_IN_CALL_SERVICE_RINGING TelecomManager#METADATA_IN_CALL_SERVICE_RINGING} in the manifest entry for their
 * {@link android.telecom.InCallService InCallService} implementation to indicate that the app wants to be responsible for
 * playing the ringtone for all incoming calls.
 * <p>
 * Requires permission: {@link android.Manifest.permission#MODIFY_PHONE_STATE} or that the
 * app fills the dialer role (see {@link #getDefaultDialerPackage()}).
 
 * <br>
 * Requires {@link android.Manifest.permission#MODIFY_PHONE_STATE}
 * @apiSince 23
 */

public void silenceRinger() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether TTY is supported on this device.
 
 * <br>
 * Requires android.Manifest.permission.READ_PRIVILEGED_PHONE_STATE or {@link android.Manifest.permission#READ_PHONE_STATE}
 * @apiSince 28
 */

public boolean isTtySupported() { throw new RuntimeException("Stub!"); }

/**
 * Registers a new incoming call. A {@link android.telecom.ConnectionService ConnectionService} should invoke this method when it
 * has an incoming call. For managed {@link android.telecom.ConnectionService ConnectionService}s, the specified
 * {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} must have been registered with {@link #registerPhoneAccount} and
 * the user must have enabled the corresponding {@link android.telecom.PhoneAccount PhoneAccount}.  This can be checked using
 * {@link #getPhoneAccount}. Self-managed {@link android.telecom.ConnectionService ConnectionService}s must have
 * {@link android.Manifest.permission#MANAGE_OWN_CALLS} to add a new incoming call.
 * <p>
 * The incoming call you are adding is assumed to have a video state of
 * {@link android.telecom.VideoProfile#STATE_AUDIO_ONLY VideoProfile#STATE_AUDIO_ONLY}, unless the extra value
 * {@link #EXTRA_INCOMING_VIDEO_STATE} is specified.
 * <p>
 * Once invoked, this method will cause the system to bind to the {@link android.telecom.ConnectionService ConnectionService}
 * associated with the {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} and request additional information about the
 * call (See {@link android.telecom.ConnectionService#onCreateIncomingConnection ConnectionService#onCreateIncomingConnection}) before starting the incoming
 * call UI.
 * <p>
 * For a managed {@link android.telecom.ConnectionService ConnectionService}, a {@link java.lang.SecurityException SecurityException} will be thrown if either
 * the {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} does not correspond to a registered {@link android.telecom.PhoneAccount PhoneAccount} or
 * the associated {@link android.telecom.PhoneAccount PhoneAccount} is not currently enabled by the user.
 * <p>
 * For a self-managed {@link android.telecom.ConnectionService ConnectionService}, a {@link java.lang.SecurityException SecurityException} will be thrown if
 * the {@link android.telecom.PhoneAccount PhoneAccount} has {@link android.telecom.PhoneAccount#CAPABILITY_SELF_MANAGED PhoneAccount#CAPABILITY_SELF_MANAGED} and the calling app
 * does not have {@link android.Manifest.permission#MANAGE_OWN_CALLS}.
 *
 * @param phoneAccount A {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} registered with
 *            {@link #registerPhoneAccount}.
 * @param extras A bundle that will be passed through to
 *            {@link android.telecom.ConnectionService#onCreateIncomingConnection ConnectionService#onCreateIncomingConnection}.
 * @apiSince 23
 */

public void addNewIncomingCall(android.telecom.PhoneAccountHandle phoneAccount, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Processes the specified dial string as an MMI code.
 * MMI codes are any sequence of characters entered into the dialpad that contain a "*" or "#".
 * Some of these sequences launch special behavior through handled by Telephony.
 * This method uses the default subscription.
 * <p>
 * Requires that the method-caller be set as the system dialer app.
 * </p>
 *
 * Requires permission: {@link android.Manifest.permission#MODIFY_PHONE_STATE}
 *
 * <br>
 * Requires {@link android.Manifest.permission#MODIFY_PHONE_STATE}
 * @param dialString The digits to dial.
 * @return True if the digits were processed as an MMI code, false otherwise.
 * @apiSince 21
 */

public boolean handleMmi(java.lang.String dialString) { throw new RuntimeException("Stub!"); }

/**
 * Processes the specified dial string as an MMI code.
 * MMI codes are any sequence of characters entered into the dialpad that contain a "*" or "#".
 * Some of these sequences launch special behavior through handled by Telephony.
 * <p>
 * Requires that the method-caller be set as the system dialer app.
 * </p>
 *
 * Requires permission: {@link android.Manifest.permission#MODIFY_PHONE_STATE}
 *
 * <br>
 * Requires {@link android.Manifest.permission#MODIFY_PHONE_STATE}
 * @param accountHandle The handle for the account the MMI code should apply to.
 * @param dialString The digits to dial.
 * @return True if the digits were processed as an MMI code, false otherwise.
 * @apiSince 23
 */

public boolean handleMmi(java.lang.String dialString, android.telecom.PhoneAccountHandle accountHandle) { throw new RuntimeException("Stub!"); }

/**
 * Requires permission: {@link android.Manifest.permission#MODIFY_PHONE_STATE}
 *
 * <br>
 * Requires {@link android.Manifest.permission#MODIFY_PHONE_STATE}
 * @param accountHandle The handle for the account to derive an adn query URI for or
 * {@code null} to return a URI which will use the default account.
 * @return The URI (with the content:// scheme) specific to the specified {@link android.telecom.PhoneAccount PhoneAccount}
 * for the the content retrieve.
 * @apiSince 23
 */

public android.net.Uri getAdnUriForPhoneAccount(android.telecom.PhoneAccountHandle accountHandle) { throw new RuntimeException("Stub!"); }

/**
 * Removes the missed-call notification if one is present.
 * <p>
 * Requires that the method-caller be set as the system dialer app.
 * </p>
 *
 * Requires permission: {@link android.Manifest.permission#MODIFY_PHONE_STATE}
 
 * <br>
 * Requires {@link android.Manifest.permission#MODIFY_PHONE_STATE}
 * @apiSince 21
 */

public void cancelMissedCallsNotification() { throw new RuntimeException("Stub!"); }

/**
 * Brings the in-call screen to the foreground if there is an ongoing call. If there is
 * currently no ongoing call, then this method does nothing.
 * <p>
 * Requires that the method-caller be set as the system dialer app or have the
 * {@link android.Manifest.permission#READ_PHONE_STATE} permission.
 * </p>
 *
 * <br>
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @param showDialpad Brings up the in-call dialpad as part of showing the in-call screen.
 * @apiSince 21
 */

public void showInCallScreen(boolean showDialpad) { throw new RuntimeException("Stub!"); }

/**
 * Places a new outgoing call to the provided address using the system telecom service with
 * the specified extras.
 *
 * This method is equivalent to placing an outgoing call using {@link android.content.Intent#ACTION_CALL Intent#ACTION_CALL},
 * except that the outgoing call will always be sent via the system telecom service. If
 * method-caller is either the user selected default dialer app or preloaded system dialer
 * app, then emergency calls will also be allowed.
 *
 * Placing a call via a managed {@link android.telecom.ConnectionService ConnectionService} requires permission:
 * {@link android.Manifest.permission#CALL_PHONE}
 *
 * Usage example:
 * <pre>
 * Uri uri = Uri.fromParts("tel", "12345", null);
 * Bundle extras = new Bundle();
 * extras.putBoolean(TelecomManager.EXTRA_START_CALL_WITH_SPEAKERPHONE, true);
 * telecomManager.placeCall(uri, extras);
 * </pre>
 *
 * The following keys are supported in the supplied extras.
 * <ul>
 *   <li>{@link #EXTRA_OUTGOING_CALL_EXTRAS}</li>
 *   <li>{@link #EXTRA_PHONE_ACCOUNT_HANDLE}</li>
 *   <li>{@link #EXTRA_START_CALL_WITH_SPEAKERPHONE}</li>
 *   <li>{@link #EXTRA_START_CALL_WITH_VIDEO_STATE}</li>
 * </ul>
 * <p>
 * An app which implements the self-managed {@link android.telecom.ConnectionService ConnectionService} API uses
 * {@link #placeCall(android.net.Uri,android.os.Bundle)} to inform Telecom of a new outgoing call.  A self-managed
 * {@link android.telecom.ConnectionService ConnectionService} must include {@link #EXTRA_PHONE_ACCOUNT_HANDLE} to specify its
 * associated {@link android.telecom.PhoneAccountHandle}.
 *
 * Self-managed {@link android.telecom.ConnectionService ConnectionService}s require permission
 * {@link android.Manifest.permission#MANAGE_OWN_CALLS}.
 *
 * <p class="note"><strong>Note:</strong> If this method is used to place an emergency call, it
 * is not guaranteed that the call will be placed on the {@link android.telecom.PhoneAccount PhoneAccount} provided in
 * the {@link #EXTRA_PHONE_ACCOUNT_HANDLE} extra (if specified) and may be placed on another
 * {@link android.telecom.PhoneAccount PhoneAccount} with the {@link android.telecom.PhoneAccount#CAPABILITY_PLACE_EMERGENCY_CALLS PhoneAccount#CAPABILITY_PLACE_EMERGENCY_CALLS}
 * capability, depending on external factors, such as network conditions and Modem/SIM status.
 * </p>
 *
 * <br>
 * Requires {@link android.Manifest.permission#CALL_PHONE} or {@link android.Manifest.permission#MANAGE_OWN_CALLS}
 * @param address The address to make the call to.
 * @param extras Bundle of extras to use with the call.
 * @apiSince 23
 */

public void placeCall(android.net.Uri address, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Creates the {@link android.content.Intent Intent} which can be used with {@link android.content.Context#startActivity(android.content.Intent) Context#startActivity(Intent)} to
 * launch the activity to manage blocked numbers.
 * <p> The activity will display the UI to manage blocked numbers only if
 * {@link android.provider.BlockedNumberContract#canCurrentUserBlockNumbers(Context)} returns
 * {@code true} for the current user.
 * @apiSince 24
 */

public android.content.Intent createManageBlockedNumbersIntent() { throw new RuntimeException("Stub!"); }

/**
 * Determines whether Telecom would permit an incoming call to be added via the
 * {@link #addNewIncomingCall(android.telecom.PhoneAccountHandle,android.os.Bundle)} API for the specified
 * {@link android.telecom.PhoneAccountHandle PhoneAccountHandle}.
 * <p>
 * A {@link android.telecom.ConnectionService ConnectionService} may not add a call for the specified {@link android.telecom.PhoneAccountHandle PhoneAccountHandle}
 * in the following situations:
 * <ul>
 *     <li>{@link android.telecom.PhoneAccount PhoneAccount} does not have property
 *     {@link android.telecom.PhoneAccount#CAPABILITY_SELF_MANAGED PhoneAccount#CAPABILITY_SELF_MANAGED} set (i.e. it is a managed
 *     {@link android.telecom.ConnectionService ConnectionService}), and the active or held call limit has
 *     been reached.</li>
 *     <li>There is an ongoing emergency call.</li>
 * </ul>
 *
 * @param phoneAccountHandle The {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} the call will be added for.
 * @return {@code true} if telecom will permit an incoming call to be added, {@code false}
 *      otherwise.
 * @apiSince 26
 */

public boolean isIncomingCallPermitted(android.telecom.PhoneAccountHandle phoneAccountHandle) { throw new RuntimeException("Stub!"); }

/**
 * Determines whether Telecom would permit an outgoing call to be placed via the
 * {@link #placeCall(android.net.Uri,android.os.Bundle)} API for the specified {@link android.telecom.PhoneAccountHandle PhoneAccountHandle}.
 * <p>
 * A {@link android.telecom.ConnectionService ConnectionService} may not place a call for the specified {@link android.telecom.PhoneAccountHandle PhoneAccountHandle}
 * in the following situations:
 * <ul>
 *     <li>{@link android.telecom.PhoneAccount PhoneAccount} does not have property
 *     {@link android.telecom.PhoneAccount#CAPABILITY_SELF_MANAGED PhoneAccount#CAPABILITY_SELF_MANAGED} set (i.e. it is a managed
 *     {@link android.telecom.ConnectionService ConnectionService}), and the active, held or ringing call limit has
 *     been reached.</li>
 *     <li>{@link android.telecom.PhoneAccount PhoneAccount} has property {@link android.telecom.PhoneAccount#CAPABILITY_SELF_MANAGED PhoneAccount#CAPABILITY_SELF_MANAGED} set
 *     (i.e. it is a self-managed {@link android.telecom.ConnectionService ConnectionService} and there is an ongoing call in
 *     another {@link android.telecom.ConnectionService ConnectionService}.</li>
 *     <li>There is an ongoing emergency call.</li>
 * </ul>
 *
 * @param phoneAccountHandle The {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} the call will be added for.
 * @return {@code true} if telecom will permit an outgoing call to be placed, {@code false}
 *      otherwise.
 * @apiSince 26
 */

public boolean isOutgoingCallPermitted(android.telecom.PhoneAccountHandle phoneAccountHandle) { throw new RuntimeException("Stub!"); }

/**
 * Called by an app to indicate that it wishes to accept the handover of an ongoing call to a
 * {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} it defines.
 * <p>
 * A call handover is the process where an ongoing call is transferred from one app (i.e.
 * {@link android.telecom.ConnectionService ConnectionService} to another app.  The user could, for example, choose to continue a
 * mobile network call in a video calling app.  The mobile network call via the Telephony stack
 * is referred to as the source of the handover, and the video calling app is referred to as the
 * destination.
 * <p>
 * When considering a handover scenario the <em>initiating</em> device is where a user initiated
 * the handover process (e.g. by calling {@link android.telecom.Call#handoverTo(
 * PhoneAccountHandle, int, Bundle)}, and the other device is considered the <em>receiving</em>
 * device.
 * <p>
 * For a full discussion of the handover process and the APIs involved, see
 * {@link android.telecom.Call#handoverTo(PhoneAccountHandle, int, Bundle)}.
 * <p>
 * This method is called from the <em>receiving</em> side of a handover to indicate a desire to
 * accept the handover of an ongoing call to another {@link android.telecom.ConnectionService ConnectionService} identified by
 * {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} destAcct. For managed {@link android.telecom.ConnectionService ConnectionService}s, the specified
 * {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} must have been registered with {@link #registerPhoneAccount} and
 * the user must have enabled the corresponding {@link android.telecom.PhoneAccount PhoneAccount}.  This can be checked using
 * {@link #getPhoneAccount}. Self-managed {@link android.telecom.ConnectionService ConnectionService}s must have
 * {@link android.Manifest.permission#MANAGE_OWN_CALLS} to handover a call to it.
 * <p>
 * Once invoked, this method will cause the system to bind to the {@link android.telecom.ConnectionService ConnectionService}
 * associated with the {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} destAcct and call
 * (See {@link android.telecom.ConnectionService#onCreateIncomingHandoverConnection ConnectionService#onCreateIncomingHandoverConnection}).
 * <p>
 * For a managed {@link android.telecom.ConnectionService ConnectionService}, a {@link java.lang.SecurityException SecurityException} will be thrown if either
 * the {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} destAcct does not correspond to a registered
 * {@link android.telecom.PhoneAccount PhoneAccount} or the associated {@link android.telecom.PhoneAccount PhoneAccount} is not currently enabled by the
 * user.
 * <p>
 * For a self-managed {@link android.telecom.ConnectionService ConnectionService}, a {@link java.lang.SecurityException SecurityException} will be thrown if
 * the calling app does not have {@link android.Manifest.permission#MANAGE_OWN_CALLS}.
 *
 * @param srcAddr The {@link android.net.Uri} of the ongoing call to handover to the caller’s
 *                {@link android.telecom.ConnectionService ConnectionService}.
 * @param videoState Video state after the handover.
 * Value is either <code>0</code> or a combination of {@link android.telecom.VideoProfile#STATE_AUDIO_ONLY}, {@link android.telecom.VideoProfile#STATE_TX_ENABLED}, {@link android.telecom.VideoProfile#STATE_RX_ENABLED}, {@link android.telecom.VideoProfile#STATE_BIDIRECTIONAL}, and {@link android.telecom.VideoProfile#STATE_PAUSED}
 * @param destAcct The {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} registered to the calling package.
 * @apiSince 28
 */

public void acceptHandover(android.net.Uri srcAddr, int videoState, android.telecom.PhoneAccountHandle destAcct) { throw new RuntimeException("Stub!"); }

/**
 * Activity action: Shows a dialog asking the user whether or not they want to replace the
 * current default Dialer with the one specified in
 * {@link #EXTRA_CHANGE_DEFAULT_DIALER_PACKAGE_NAME}.
 *
 * Usage example:
 * <pre>
 * Intent intent = new Intent(TelecomManager.ACTION_CHANGE_DEFAULT_DIALER);
 * intent.putExtra(TelecomManager.EXTRA_CHANGE_DEFAULT_DIALER_PACKAGE_NAME,
 *         getActivity().getPackageName());
 * startActivity(intent);
 * </pre>
 * <p>
 * This is no longer supported since Q, please use
 * {@link android.app.role.RoleManager#createRequestRoleIntent(String)} with
 * {@link android.app.role.RoleManager#ROLE_DIALER} instead.
 * @apiSince 23
 */

public static final java.lang.String ACTION_CHANGE_DEFAULT_DIALER = "android.telecom.action.CHANGE_DEFAULT_DIALER";

/**
 * The {@link android.content.Intent} action used to show the settings page used to configure
 * {@link android.telecom.PhoneAccount PhoneAccount} preferences.
 * @apiSince 23
 */

public static final java.lang.String ACTION_CHANGE_PHONE_ACCOUNTS = "android.telecom.action.CHANGE_PHONE_ACCOUNTS";

/**
 * An {@link android.content.Intent} action sent by the telecom framework to start a
 * configuration dialog for a registered {@link android.telecom.PhoneAccount PhoneAccount}. There is no default dialog
 * and each app that registers a {@link android.telecom.PhoneAccount PhoneAccount} should provide one if desired.
 * <p>
 * A user can access the list of enabled {@link android.telecom.PhoneAccount}s through the Phone
 * app's settings menu. For each entry, the settings app will add a click action. When
 * triggered, the click-action will start this intent along with the extra
 * {@link #EXTRA_PHONE_ACCOUNT_HANDLE} to indicate the {@link android.telecom.PhoneAccount PhoneAccount} to configure. If the
 * {@link android.telecom.PhoneAccount PhoneAccount} package does not register an {@link android.app.Activity} for this
 * intent, then it will not be sent.
 * @apiSince 23
 */

public static final java.lang.String ACTION_CONFIGURE_PHONE_ACCOUNT = "android.telecom.action.CONFIGURE_PHONE_ACCOUNT";

/**
 * Broadcast intent action indicating that the current default call screening app has changed.
 *
 * The string extra {@link #EXTRA_DEFAULT_CALL_SCREENING_APP_COMPONENT_NAME} will contain the
 * name of the Component of the previous or the new call screening app.
 *
 * The boolean extra {@link #EXTRA_IS_DEFAULT_CALL_SCREENING_APP} will indicate the component
 * name in the String extra {@link #EXTRA_DEFAULT_CALL_SCREENING_APP_COMPONENT_NAME} is default
 * call screening app or not.
 * @apiSince 29
 */

public static final java.lang.String ACTION_DEFAULT_CALL_SCREENING_APP_CHANGED = "android.telecom.action.DEFAULT_CALL_SCREENING_APP_CHANGED";

/**
 * Broadcast intent action indicating that the current default dialer has changed.
 * The string extra {@link #EXTRA_CHANGE_DEFAULT_DIALER_PACKAGE_NAME} will contain the
 * name of the package that the default dialer was changed to.
 *
 * @see #EXTRA_CHANGE_DEFAULT_DIALER_PACKAGE_NAME
 * @apiSince 23
 */

public static final java.lang.String ACTION_DEFAULT_DIALER_CHANGED = "android.telecom.action.DEFAULT_DIALER_CHANGED";

/**
 * Activity action: Starts the UI for handing an incoming call. This intent starts the in-call
 * UI by notifying the Telecom system that an incoming call exists for a specific call service
 * (see {@link android.telecom.ConnectionService}). Telecom reads the Intent extras to find
 * and bind to the appropriate {@link android.telecom.ConnectionService} which Telecom will
 * ultimately use to control and get information about the call.
 * <p>
 * Input: get*Extra field {@link #EXTRA_PHONE_ACCOUNT_HANDLE} contains the component name of the
 * {@link android.telecom.ConnectionService} that Telecom should bind to. Telecom will then
 * ask the connection service for more information about the call prior to showing any UI.
 *
 * @deprecated Use {@link #addNewIncomingCall} instead.
 * @apiSince 23
 * @deprecatedSince 26
 */

@Deprecated public static final java.lang.String ACTION_INCOMING_CALL = "android.telecom.action.INCOMING_CALL";

/**
 * {@link android.content.Intent} action used indicate that a new phone account was just
 * registered.
 * <p>
 * The Intent {@link android.content.Intent#getExtras() Intent#getExtras()} will contain {@link #EXTRA_PHONE_ACCOUNT_HANDLE}
 * to indicate which {@link android.telecom.PhoneAccount PhoneAccount} was registered.
 * <p>
 * Will only be sent to the default dialer app (see {@link #getDefaultDialerPackage()}).
 * @apiSince 26
 */

public static final java.lang.String ACTION_PHONE_ACCOUNT_REGISTERED = "android.telecom.action.PHONE_ACCOUNT_REGISTERED";

/**
 * {@link android.content.Intent} action used indicate that a phone account was just
 * unregistered.
 * <p>
 * The Intent {@link android.content.Intent#getExtras() Intent#getExtras()} will contain {@link #EXTRA_PHONE_ACCOUNT_HANDLE}
 * to indicate which {@link android.telecom.PhoneAccount PhoneAccount} was unregistered.
 * <p>
 * Will only be sent to the default dialer app (see {@link #getDefaultDialerPackage()}).
 * @apiSince 26
 */

public static final java.lang.String ACTION_PHONE_ACCOUNT_UNREGISTERED = "android.telecom.action.PHONE_ACCOUNT_UNREGISTERED";

/**
 * Start an activity indicating that the completion of an outgoing call or an incoming call
 * which was not blocked by the {@link android.telecom.CallScreeningService CallScreeningService}, and which was NOT terminated
 * while the call was in {@link android.telecom.Call#STATE_AUDIO_PROCESSING Call#STATE_AUDIO_PROCESSING}.
 *
 * The {@link android.net.Uri Uri} extra {@link #EXTRA_HANDLE} will contain the uri handle(phone number) for the
 * call which completed.
 *
 * The integer extra {@link #EXTRA_DISCONNECT_CAUSE} will indicate the reason for the call
 * disconnection. See {@link #EXTRA_DISCONNECT_CAUSE} for more information.
 *
 * The integer extra {@link #EXTRA_CALL_DURATION} will indicate the duration of the call. See
 * {@link #EXTRA_CALL_DURATION} for more information.
 * @apiSince R
 */

public static final java.lang.String ACTION_POST_CALL = "android.telecom.action.POST_CALL";

/**
 * The {@link android.content.Intent} action used to show the call accessibility settings page.
 * @apiSince 23
 */

public static final java.lang.String ACTION_SHOW_CALL_ACCESSIBILITY_SETTINGS = "android.telecom.action.SHOW_CALL_ACCESSIBILITY_SETTINGS";

/**
 * The {@link android.content.Intent} action used to show the call settings page.
 * @apiSince 21
 */

public static final java.lang.String ACTION_SHOW_CALL_SETTINGS = "android.telecom.action.SHOW_CALL_SETTINGS";

/**
 * Broadcast intent action for letting custom component know to show the missed call
 * notification. If no custom component exists then this is sent to the default dialer which
 * should post a missed-call notification.
 * @apiSince 24
 */

public static final java.lang.String ACTION_SHOW_MISSED_CALLS_NOTIFICATION = "android.telecom.action.SHOW_MISSED_CALLS_NOTIFICATION";

/**
 * The {@link android.content.Intent} action used to show the respond via SMS settings page.
 * @apiSince 23
 */

public static final java.lang.String ACTION_SHOW_RESPOND_VIA_SMS_SETTINGS = "android.telecom.action.SHOW_RESPOND_VIA_SMS_SETTINGS";

/**
 * The dual tone multi-frequency signaling character sent to indicate the dialing system should
 * pause for a predefined period.
 * @apiSince 21
 */

public static final char DTMF_CHARACTER_PAUSE = 44; // 0x002c ','

/**
 * The dual-tone multi-frequency signaling character sent to indicate the dialing system should
 * wait for user confirmation before proceeding.
 * @apiSince 21
 */

public static final char DTMF_CHARACTER_WAIT = 59; // 0x003b ';'

/**
 * A integer value for {@link #EXTRA_CALL_DURATION}, indicates the duration of the completed
 * call was >= 120 seconds.
 * @apiSince R
 */

public static final int DURATION_LONG = 3; // 0x3

/**
 * A integer value for {@link #EXTRA_CALL_DURATION}, indicates the duration of the completed
 * call was >= 60 seconds and < 120 seconds.
 * @apiSince R
 */

public static final int DURATION_MEDIUM = 2; // 0x2

/**
 * A integer value for {@link #EXTRA_CALL_DURATION}, indicates the duration of the completed
 * call was >= 3 seconds and < 60 seconds.
 * @apiSince R
 */

public static final int DURATION_SHORT = 1; // 0x1

/**
 * A integer value for {@link #EXTRA_CALL_DURATION}, indicates the duration of the completed
 * call was < 3 seconds.
 * @apiSince R
 */

public static final int DURATION_VERY_SHORT = 0; // 0x0

/**
 * The number which the party on the other side of the line will see (and use to return the
 * call).
 * <p>
 * {@link android.telecom.ConnectionService ConnectionService}s which interact with {@link android.telecom.RemoteConnection RemoteConnection}s should only populate
 * this if the {@link android.telephony.TelephonyManager#getLine1Number()} value, as that is the
 * user's expected caller ID.
 * @apiSince 23
 */

public static final java.lang.String EXTRA_CALL_BACK_NUMBER = "android.telecom.extra.CALL_BACK_NUMBER";

/**
 * Optional extra for {@link android.telephony.TelephonyManager#ACTION_PHONE_STATE_CHANGED}
 * containing the disconnect code.
 * @apiSince 21
 */

public static final java.lang.String EXTRA_CALL_DISCONNECT_CAUSE = "android.telecom.extra.CALL_DISCONNECT_CAUSE";

/**
 * Optional extra for {@link android.telephony.TelephonyManager#ACTION_PHONE_STATE_CHANGED}
 * containing the disconnect message.
 * @apiSince 21
 */

public static final java.lang.String EXTRA_CALL_DISCONNECT_MESSAGE = "android.telecom.extra.CALL_DISCONNECT_MESSAGE";

/**
 * A integer value provided for completed calls to indicate the duration of the call.
 * <p>
 * Allowed values:
 * <ul>
 * <li>{@link #DURATION_VERY_SHORT}</li>
 * <li>{@link #DURATION_SHORT}</li>
 * <li>{@link #DURATION_MEDIUM}</li>
 * <li>{@link #DURATION_LONG}</li>
 * </ul>
 * </p>
 * @apiSince R
 */

public static final java.lang.String EXTRA_CALL_DURATION = "android.telecom.extra.CALL_DURATION";

/**
 * Optional extra for communicating the call network technology used by a
 * {@link android.telecom.Connection} to Telecom and InCallUI.
 *
 * @see {@code NETWORK_TYPE_*} in {@link android.telephony.TelephonyManager}.
 * @apiSince 29
 */

public static final java.lang.String EXTRA_CALL_NETWORK_TYPE = "android.telecom.extra.CALL_NETWORK_TYPE";

/**
 * Optional extra for {@link android.content.Intent#ACTION_CALL} containing a string call
 * subject which will be associated with an outgoing call.  Should only be specified if the
 * {@link android.telecom.PhoneAccount PhoneAccount} supports the capability {@link android.telecom.PhoneAccount#CAPABILITY_CALL_SUBJECT PhoneAccount#CAPABILITY_CALL_SUBJECT}.
 * @apiSince 23
 */

public static final java.lang.String EXTRA_CALL_SUBJECT = "android.telecom.extra.CALL_SUBJECT";

/**
 * Extra value used to provide the package name for {@link #ACTION_CHANGE_DEFAULT_DIALER}.
 * @apiSince 23
 */

public static final java.lang.String EXTRA_CHANGE_DEFAULT_DIALER_PACKAGE_NAME = "android.telecom.extra.CHANGE_DEFAULT_DIALER_PACKAGE_NAME";

/**
 * Extra value used with {@link #ACTION_DEFAULT_CALL_SCREENING_APP_CHANGED} broadcast to
 * indicate the ComponentName of the call screening app which has changed.
 * @apiSince 29
 */

public static final java.lang.String EXTRA_DEFAULT_CALL_SCREENING_APP_COMPONENT_NAME = "android.telecom.extra.DEFAULT_CALL_SCREENING_APP_COMPONENT_NAME";

/**
 * A integer value provided for completed calls to indicate the reason for the call
 * disconnection.
 * <p>
 * Allowed values:
 * <ul>
 * <li>{@link android.telecom.DisconnectCause#UNKNOWN DisconnectCause#UNKNOWN}</li>
 * <li>{@link android.telecom.DisconnectCause#LOCAL DisconnectCause#LOCAL}</li>
 * <li>{@link android.telecom.DisconnectCause#REMOTE DisconnectCause#REMOTE}</li>
 * <li>{@link android.telecom.DisconnectCause#REJECTED DisconnectCause#REJECTED}</li>
 * <li>{@link android.telecom.DisconnectCause#MISSED DisconnectCause#MISSED}</li>
 * </ul>
 * </p>
 * @apiSince R
 */

public static final java.lang.String EXTRA_DISCONNECT_CAUSE = "android.telecom.extra.DISCONNECT_CAUSE";

/**
 * A {@link android.net.Uri Uri} extra, which when set on the {@link #ACTION_POST_CALL} intent, indicates the
 * uri handle(phone number) of the completed call.
 * @apiSince R
 */

public static final java.lang.String EXTRA_HANDLE = "android.telecom.extra.HANDLE";

/**
 * The extra used by a {@link android.telecom.ConnectionService ConnectionService} to provide the handle of the caller that
 * has initiated a new incoming call.
 * @apiSince 23
 */

public static final java.lang.String EXTRA_INCOMING_CALL_ADDRESS = "android.telecom.extra.INCOMING_CALL_ADDRESS";

/**
 * Optional extra for {@link #ACTION_INCOMING_CALL} containing a {@link android.os.Bundle Bundle} which contains
 * metadata about the call. This {@link android.os.Bundle Bundle} will be returned to the
 * {@link android.telecom.ConnectionService ConnectionService}.
 * @apiSince 23
 */

public static final java.lang.String EXTRA_INCOMING_CALL_EXTRAS = "android.telecom.extra.INCOMING_CALL_EXTRAS";

/**
 * Optional extra for {@link #addNewIncomingCall(android.telecom.PhoneAccountHandle,android.os.Bundle)} containing an
 * integer that determines the requested video state for an incoming call.
 * Valid options:
 * {@link android.telecom.VideoProfile#STATE_AUDIO_ONLY VideoProfile#STATE_AUDIO_ONLY},
 * {@link android.telecom.VideoProfile#STATE_BIDIRECTIONAL VideoProfile#STATE_BIDIRECTIONAL},
 * {@link android.telecom.VideoProfile#STATE_RX_ENABLED VideoProfile#STATE_RX_ENABLED},
 * {@link android.telecom.VideoProfile#STATE_TX_ENABLED VideoProfile#STATE_TX_ENABLED}.
 * @apiSince 26
 */

public static final java.lang.String EXTRA_INCOMING_VIDEO_STATE = "android.telecom.extra.INCOMING_VIDEO_STATE";

/**
 * Extra value used with {@link #ACTION_DEFAULT_CALL_SCREENING_APP_CHANGED} broadcast to
 * indicate whether an app is the default call screening app.
 * @apiSince 29
 */

public static final java.lang.String EXTRA_IS_DEFAULT_CALL_SCREENING_APP = "android.telecom.extra.IS_DEFAULT_CALL_SCREENING_APP";

/**
 * The number of calls associated with the notification. If the number is zero then the missed
 * call notification should be dismissed.
 * @apiSince 24
 */

public static final java.lang.String EXTRA_NOTIFICATION_COUNT = "android.telecom.extra.NOTIFICATION_COUNT";

/**
 * The number associated with the missed calls. This number is only relevant
 * when EXTRA_NOTIFICATION_COUNT is 1.
 * @apiSince 24
 */

public static final java.lang.String EXTRA_NOTIFICATION_PHONE_NUMBER = "android.telecom.extra.NOTIFICATION_PHONE_NUMBER";

/**
 * Optional extra for {@link android.content.Intent#ACTION_CALL} and
 * {@link android.content.Intent#ACTION_DIAL} {@code Intent} containing a {@link android.os.Bundle Bundle}
 * which contains metadata about the call. This {@link android.os.Bundle Bundle} will be saved into
 * {@code Call.Details} and passed to the {@link android.telecom.ConnectionService ConnectionService} when placing the call.
 * @apiSince 23
 */

public static final java.lang.String EXTRA_OUTGOING_CALL_EXTRAS = "android.telecom.extra.OUTGOING_CALL_EXTRAS";

/**
 * The extra used with an {@link android.content.Intent#ACTION_CALL} and
 * {@link android.content.Intent#ACTION_DIAL} {@code Intent} to specify a
 * {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} to use when making the call.
 * <p class="note">
 * Retrieve with {@link android.content.Intent#getParcelableExtra(String)}.
 * @apiSince 23
 */

public static final java.lang.String EXTRA_PHONE_ACCOUNT_HANDLE = "android.telecom.extra.PHONE_ACCOUNT_HANDLE";

/**
 * A boolean extra, which when set on the {@link android.content.Intent#ACTION_CALL Intent#ACTION_CALL} intent or on the bundle
 * passed into {@link #placeCall(android.net.Uri,android.os.Bundle)}, indicates that the call should be initiated with
 * an RTT session open. See {@link android.telecom.Call.RttCall} for more information on RTT.
 * @apiSince 26
 */

public static final java.lang.String EXTRA_START_CALL_WITH_RTT = "android.telecom.extra.START_CALL_WITH_RTT";

/**
 * Optional extra for {@link android.content.Intent#ACTION_CALL} containing a boolean that
 * determines whether the speakerphone should be automatically turned on for an outgoing call.
 * @apiSince 21
 */

public static final java.lang.String EXTRA_START_CALL_WITH_SPEAKERPHONE = "android.telecom.extra.START_CALL_WITH_SPEAKERPHONE";

/**
 * Optional extra for {@link android.content.Intent#ACTION_CALL} containing an integer that
 * determines the desired video state for an outgoing call.
 * Valid options:
 * {@link android.telecom.VideoProfile#STATE_AUDIO_ONLY VideoProfile#STATE_AUDIO_ONLY},
 * {@link android.telecom.VideoProfile#STATE_BIDIRECTIONAL VideoProfile#STATE_BIDIRECTIONAL},
 * {@link android.telecom.VideoProfile#STATE_RX_ENABLED VideoProfile#STATE_RX_ENABLED},
 * {@link android.telecom.VideoProfile#STATE_TX_ENABLED VideoProfile#STATE_TX_ENABLED}.
 * @apiSince 23
 */

public static final java.lang.String EXTRA_START_CALL_WITH_VIDEO_STATE = "android.telecom.extra.START_CALL_WITH_VIDEO_STATE";

/**
 * The boolean indicated by this extra controls whether or not a call is eligible to undergo
 * assisted dialing. This extra is stored under {@link #EXTRA_OUTGOING_CALL_EXTRAS}.
 * <p>
 * The call initiator can use this extra to indicate that a call used assisted dialing to help
 * place the call.  This is most commonly used by a Dialer app which provides the ability to
 * automatically add dialing prefixes when placing international calls.
 * <p>
 * Setting this extra on the outgoing call extras will cause the
 * {@link android.telecom.Connection#PROPERTY_ASSISTED_DIALING_USED Connection#PROPERTY_ASSISTED_DIALING_USED} property and
 * {@link android.telecom.Call.Details#PROPERTY_ASSISTED_DIALING_USED Call.Details#PROPERTY_ASSISTED_DIALING_USED} property to be set on the
 * {@link android.telecom.Connection Connection}/{@link android.telecom.Call Call} in question.  When the call is logged to the call log, the
 * {@link android.provider.CallLog.Calls#FEATURES_ASSISTED_DIALING_USED} call feature is set to
 * indicate that assisted dialing was used for the call.
 * @apiSince R
 */

public static final java.lang.String EXTRA_USE_ASSISTED_DIALING = "android.telecom.extra.USE_ASSISTED_DIALING";

/**
 * An optional {@link android.content.Intent#ACTION_CALL} intent extra corresponding to the
 * original address to dial for the call. This is used when an alternative gateway address is
 * provided to recall the original address.
 * The value is a {@link android.net.Uri}.
 *
 * (See {@link #GATEWAY_PROVIDER_PACKAGE} for details)
 * @apiSince 21
 */

public static final java.lang.String GATEWAY_ORIGINAL_ADDRESS = "android.telecom.extra.GATEWAY_ORIGINAL_ADDRESS";

/**
 * An optional {@link android.content.Intent#ACTION_CALL} intent extra denoting the
 * package name of the app specifying an alternative gateway for the call.
 * The value is a string.
 *
 * (The following comment corresponds to the all GATEWAY_* extras)
 * An app which sends the {@link android.content.Intent#ACTION_CALL} intent can specify an
 * alternative address to dial which is different from the one specified and displayed to
 * the user. This alternative address is referred to as the gateway address.
 * @apiSince 21
 */

public static final java.lang.String GATEWAY_PROVIDER_PACKAGE = "android.telecom.extra.GATEWAY_PROVIDER_PACKAGE";

/**
 * A boolean meta-data value indicating whether an {@link android.telecom.InCallService InCallService} wants to be informed of
 * calls which have the {@link android.telecom.Call.Details#PROPERTY_IS_EXTERNAL_CALL Call.Details#PROPERTY_IS_EXTERNAL_CALL} property.  An external
 * call is one which a {@link android.telecom.ConnectionService ConnectionService} knows about, but is not connected to directly.
 * Dialer implementations (see {@link #getDefaultDialerPackage()}) which would like to be
 * informed of external calls should set this meta-data to {@code true} in the manifest
 * registration of their {@link android.telecom.InCallService InCallService}.  By default, the {@link android.telecom.InCallService InCallService} will NOT
 * be informed of external calls.
 * @apiSince 25
 */

public static final java.lang.String METADATA_INCLUDE_EXTERNAL_CALLS = "android.telecom.INCLUDE_EXTERNAL_CALLS";

/**
 * A boolean meta-data value indicating whether an {@link android.telecom.InCallService InCallService} wants to be informed of
 * calls which have the {@link android.telecom.Call.Details#PROPERTY_SELF_MANAGED Call.Details#PROPERTY_SELF_MANAGED} property.  A self-managed
 * call is one which originates from a self-managed {@link android.telecom.ConnectionService ConnectionService} which has chosen
 * to implement its own call user interface.  An {@link android.telecom.InCallService InCallService} implementation which
 * would like to be informed of external calls should set this meta-data to {@code true} in the
 * manifest registration of their {@link android.telecom.InCallService InCallService}.  By default, the {@link android.telecom.InCallService InCallService}
 * will NOT be informed about self-managed calls.
 * <p>
 * An {@link android.telecom.InCallService InCallService} which receives self-managed calls is free to view and control the
 * state of calls in the self-managed {@link android.telecom.ConnectionService ConnectionService}.  An example use-case is
 * exposing these calls to an automotive device via its companion app.
 * <p>
 * This meta-data can only be set for an {@link android.telecom.InCallService InCallService} which also sets
 * {@link #METADATA_IN_CALL_SERVICE_UI}. Only the default phone/dialer app, or a car-mode
 * {@link android.telecom.InCallService InCallService} can see self-managed calls.
 * <p>
 * See also {@link android.telecom.Connection#PROPERTY_SELF_MANAGED Connection#PROPERTY_SELF_MANAGED}.
 * @apiSince 26
 */

public static final java.lang.String METADATA_INCLUDE_SELF_MANAGED_CALLS = "android.telecom.INCLUDE_SELF_MANAGED_CALLS";

/**
 * A boolean meta-data value indicating whether an {@link android.telecom.InCallService InCallService} implements an
 * in-call user interface to be used while the device is in car-mode (see
 * {@link android.content.res.Configuration#UI_MODE_TYPE_CAR}).
 * @apiSince 29
 */

public static final java.lang.String METADATA_IN_CALL_SERVICE_CAR_MODE_UI = "android.telecom.IN_CALL_SERVICE_CAR_MODE_UI";

/**
 * A boolean meta-data value indicating whether an {@link android.telecom.InCallService InCallService} implements ringing.
 * Dialer implementations (see {@link #getDefaultDialerPackage()}) which would also like to
 * override the system provided ringing should set this meta-data to {@code true} in the
 * manifest registration of their {@link android.telecom.InCallService InCallService}.
 * <p>
 * When {@code true}, it is the {@link android.telecom.InCallService InCallService}'s responsibility to play a ringtone for
 * all incoming calls.
 * @apiSince 24
 */

public static final java.lang.String METADATA_IN_CALL_SERVICE_RINGING = "android.telecom.IN_CALL_SERVICE_RINGING";

/**
 * A boolean meta-data value indicating whether an {@link android.telecom.InCallService InCallService} implements an
 * in-call user interface. Dialer implementations (see {@link #getDefaultDialerPackage()}) which
 * would also like to replace the in-call interface should set this meta-data to {@code true} in
 * the manifest registration of their {@link android.telecom.InCallService InCallService}.
 * @apiSince 23
 */

public static final java.lang.String METADATA_IN_CALL_SERVICE_UI = "android.telecom.IN_CALL_SERVICE_UI";

/**
 * Indicates that the address or number of a call is allowed to be displayed for caller ID.
 * @apiSince 21
 */

public static final int PRESENTATION_ALLOWED = 1; // 0x1

/**
 * Indicates that the address or number of a call belongs to a pay phone.
 * @apiSince 21
 */

public static final int PRESENTATION_PAYPHONE = 4; // 0x4

/**
 * Indicates that the address or number of a call is blocked by the other party.
 * @apiSince 21
 */

public static final int PRESENTATION_RESTRICTED = 2; // 0x2

/**
 * Indicates that the address or number of a call is not specified or known by the carrier.
 * @apiSince 21
 */

public static final int PRESENTATION_UNKNOWN = 3; // 0x3
}

