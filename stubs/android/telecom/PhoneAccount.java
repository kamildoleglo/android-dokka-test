/*
 * Copyright (C) 2014 The Android Open Source Project
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


package android.telecom;

import android.net.Uri;
import android.content.Intent;

/**
 * Represents a distinct method to place or receive a phone call. Apps which can place calls and
 * want those calls to be integrated into the dialer and in-call UI should build an instance of
 * this class and register it with the system using {@link android.telecom.TelecomManager TelecomManager}.
 * <p>
 * {@link android.telecom.TelecomManager TelecomManager} uses registered {@link android.telecom.PhoneAccount PhoneAccount}s to present the user with
 * alternative options when placing a phone call. When building a {@link android.telecom.PhoneAccount PhoneAccount}, the app
 * should supply a valid {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} that references the connection service
 * implementation Telecom will use to interact with the app.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class PhoneAccount implements android.os.Parcelable {

private PhoneAccount() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public static android.telecom.PhoneAccount.Builder builder(android.telecom.PhoneAccountHandle accountHandle, java.lang.CharSequence label) { throw new RuntimeException("Stub!"); }

/**
 * Returns a builder initialized with the current {@link android.telecom.PhoneAccount PhoneAccount} instance.
 *
 * @return The builder.
 * @apiSince 23
 */

public android.telecom.PhoneAccount.Builder toBuilder() { throw new RuntimeException("Stub!"); }

/**
 * The unique identifier of this {@code PhoneAccount}.
 *
 * @return A {@code PhoneAccountHandle}.
 * @apiSince 23
 */

public android.telecom.PhoneAccountHandle getAccountHandle() { throw new RuntimeException("Stub!"); }

/**
 * The address (e.g., a phone number) associated with this {@code PhoneAccount}. This
 * represents the destination from which outgoing calls using this {@code PhoneAccount}
 * will appear to come, if applicable, and the destination to which incoming calls using this
 * {@code PhoneAccount} may be addressed.
 *
 * @return A address expressed as a {@code Uri}, for example, a phone number.
 * @apiSince 23
 */

public android.net.Uri getAddress() { throw new RuntimeException("Stub!"); }

/**
 * The raw callback number used for this {@code PhoneAccount}, as distinct from
 * {@link #getAddress()}. For the majority of {@code PhoneAccount}s this should be registered
 * as {@code null}.  It is used by the system for SIM-based {@code PhoneAccount} registration
 * where {@link android.telephony.TelephonyManager#setLine1NumberForDisplay(String, String)}
 * has been used to alter the callback number.
 * <p>
 *
 * @return The subscription number, suitable for display to the user.
 * @apiSince 23
 */

public android.net.Uri getSubscriptionAddress() { throw new RuntimeException("Stub!"); }

/**
 * The capabilities of this {@code PhoneAccount}.
 *
 * @return A bit field of flags describing this {@code PhoneAccount}'s capabilities.
 * @apiSince 23
 */

public int getCapabilities() { throw new RuntimeException("Stub!"); }

/**
 * Determines if this {@code PhoneAccount} has a capabilities specified by the passed in
 * bit mask.
 *
 * @param capability The capabilities to check.
 * @return {@code true} if the phone account has the capability.
 * @apiSince 23
 */

public boolean hasCapabilities(int capability) { throw new RuntimeException("Stub!"); }

/**
 * A short label describing a {@code PhoneAccount}.
 *
 * @return A label for this {@code PhoneAccount}.
 * @apiSince 23
 */

public java.lang.CharSequence getLabel() { throw new RuntimeException("Stub!"); }

/**
 * A short paragraph describing this {@code PhoneAccount}.
 *
 * @return A description for this {@code PhoneAccount}.
 * @apiSince 23
 */

public java.lang.CharSequence getShortDescription() { throw new RuntimeException("Stub!"); }

/**
 * The URI schemes supported by this {@code PhoneAccount}.
 *
 * @return The URI schemes.
 * @apiSince 23
 */

public java.util.List<java.lang.String> getSupportedUriSchemes() { throw new RuntimeException("Stub!"); }

/**
 * The extras associated with this {@code PhoneAccount}.
 * <p>
 * A {@link android.telecom.ConnectionService ConnectionService} may provide implementation specific information about the
 * {@link android.telecom.PhoneAccount PhoneAccount} via the extras.
 *
 * @return The extras.
 * @apiSince 24
 */

public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * The icon to represent this {@code PhoneAccount}.
 *
 * @return The icon.
 * @apiSince 23
 */

public android.graphics.drawable.Icon getIcon() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the user has enabled this {@code PhoneAccount} or not. This value is only
 * populated for {@code PhoneAccount}s returned by {@link android.telecom.TelecomManager#getPhoneAccount TelecomManager#getPhoneAccount}.
 *
 * @return {@code true} if the account is enabled by the user, {@code false} otherwise.
 * @apiSince 23
 */

public boolean isEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Determines if the {@link android.telecom.PhoneAccount PhoneAccount} supports calls to/from addresses with a specified URI
 * scheme.
 *
 * @param uriScheme The URI scheme to check.
 * @return {@code true} if the {@code PhoneAccount} supports calls to/from addresses with the
 * specified URI scheme.
 * @apiSince 23
 */

public boolean supportsUriScheme(java.lang.String uriScheme) { throw new RuntimeException("Stub!"); }

/**
 * A highlight color to use in displaying information about this {@code PhoneAccount}.
 *
 * @return A hexadecimal color value.
 * @apiSince 23
 */

public int getHighlightColor() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Flag indicating that this {@code PhoneAccount} can make phone calls in place of
 * traditional SIM-based telephony calls. This account will be treated as a distinct method
 * for placing calls alongside the traditional SIM-based telephony stack. This flag is
 * distinct from {@link #CAPABILITY_CONNECTION_MANAGER} in that it is not allowed to manage
 * or place calls from the built-in telephony stack.
 * <p>
 * See {@link #getCapabilities}
 * <p>
 * @apiSince 23
 */

public static final int CAPABILITY_CALL_PROVIDER = 2; // 0x2

/**
 * Flag indicating that this {@code PhoneAccount} supports a subject for Calls.  This means a
 * caller is able to specify a short subject line for an outgoing call.  A capable receiving
 * device displays the call subject on the incoming call screen.
 * <p>
 * See {@link #getCapabilities}
 * @apiSince 23
 */

public static final int CAPABILITY_CALL_SUBJECT = 64; // 0x40

/**
 * Flag indicating that this {@code PhoneAccount} can act as a connection manager for
 * other connections. The {@link android.telecom.ConnectionService ConnectionService} associated with this {@code PhoneAccount}
 * will be allowed to manage phone calls including using its own proprietary phone-call
 * implementation (like VoIP calling) to make calls instead of the telephony stack.
 * <p>
 * When a user opts to place a call using the SIM-based telephony stack, the
 * {@link android.telecom.ConnectionService ConnectionService} associated with this {@code PhoneAccount} will be attempted first
 * if the user has explicitly selected it to be used as the default connection manager.
 * <p>
 * See {@link #getCapabilities}
 * @apiSince 23
 */

public static final int CAPABILITY_CONNECTION_MANAGER = 1; // 0x1

/**
 * Flag indicating that this {@code PhoneAccount} is capable of placing emergency calls.
 * By default all PSTN {@code PhoneAccount}s are capable of placing emergency calls.
 * <p>
 * See {@link #getCapabilities}
 * @apiSince 23
 */

public static final int CAPABILITY_PLACE_EMERGENCY_CALLS = 16; // 0x10

/**
 * Flag indicating that this {@link android.telecom.PhoneAccount PhoneAccount} is capable of making a call with an
 * RTT (Real-time text) session.
 * When set, Telecom will attempt to open an RTT session on outgoing calls that specify
 * that they should be placed with an RTT session , and the in-call app will be displayed
 * with text entry fields for RTT. Likewise, the in-call app can request that an RTT
 * session be opened during a call if this bit is set.
 * @apiSince 26
 */

public static final int CAPABILITY_RTT = 4096; // 0x1000

/**
 * Flag indicating that this {@link android.telecom.PhoneAccount PhoneAccount} is responsible for managing its own
 * {@link android.telecom.Connection Connection}s.  This type of {@link android.telecom.PhoneAccount PhoneAccount} is ideal for use with standalone
 * calling apps which do not wish to use the default phone app for {@link android.telecom.Connection Connection} UX,
 * but which want to leverage the call and audio routing capabilities of the Telecom framework.
 * <p>
 * When set, {@link android.telecom.Connection Connection}s created by the self-managed {@link android.telecom.ConnectionService ConnectionService} will not
 * be surfaced to implementations of the {@link android.telecom.InCallService InCallService} API.  Thus it is the
 * responsibility of a self-managed {@link android.telecom.ConnectionService ConnectionService} to provide a user interface for
 * its {@link android.telecom.Connection Connection}s.
 * <p>
 * Self-managed {@link android.telecom.Connection Connection}s will, however, be displayed on connected Bluetooth devices.
 * @apiSince 26
 */

public static final int CAPABILITY_SELF_MANAGED = 2048; // 0x800

/**
 * Flag indicating that this {@code PhoneAccount} represents a built-in PSTN SIM
 * subscription.
 * <p>
 * Only the Android framework can register a {@code PhoneAccount} having this capability.
 * <p>
 * See {@link #getCapabilities}
 * @apiSince 23
 */

public static final int CAPABILITY_SIM_SUBSCRIPTION = 4; // 0x4

/**
 * Flag indicating that this {@link android.telecom.PhoneAccount PhoneAccount} supports video calling.
 * This is not an indication that the {@link android.telecom.PhoneAccount PhoneAccount} is currently able to make a video
 * call, but rather that it has the ability to make video calls (but not necessarily at this
 * time).
 * <p>
 * Whether a {@link android.telecom.PhoneAccount PhoneAccount} can make a video call is ultimately controlled by
 * {@link #CAPABILITY_VIDEO_CALLING}, which indicates whether the {@link android.telecom.PhoneAccount PhoneAccount} is
 * currently capable of making a video call.  Consider a case where, for example, a
 * {@link android.telecom.PhoneAccount PhoneAccount} supports making video calls (e.g.
 * {@link #CAPABILITY_SUPPORTS_VIDEO_CALLING}), but a current lack of network connectivity
 * prevents video calls from being made (e.g. {@link #CAPABILITY_VIDEO_CALLING}).
 * <p>
 * See {@link #getCapabilities}
 * @apiSince 26
 */

public static final int CAPABILITY_SUPPORTS_VIDEO_CALLING = 1024; // 0x400

/**
 * Flag indicating that this {@code PhoneAccount} is currently able to place video calls.
 * <p>
 * See also {@link #CAPABILITY_SUPPORTS_VIDEO_CALLING} which indicates whether the
 * {@code PhoneAccount} supports placing video calls.
 * <p>
 * See {@link #getCapabilities}
 * @apiSince 23
 */

public static final int CAPABILITY_VIDEO_CALLING = 8; // 0x8

/**
 * Flag indicating that for this {@code PhoneAccount}, the ability to make a video call to a
 * number relies on presence.  Should only be set if the {@code PhoneAccount} also has
 * {@link #CAPABILITY_VIDEO_CALLING}.
 * <p>
 * When set, the {@link android.telecom.ConnectionService ConnectionService} is responsible for toggling the
 * {@link android.provider.ContactsContract.Data#CARRIER_PRESENCE_VT_CAPABLE} bit on the
 * {@link android.provider.ContactsContract.Data#CARRIER_PRESENCE} column to indicate whether
 * a contact's phone number supports video calling.
 * <p>
 * See {@link #getCapabilities}
 * @apiSince 24
 */

public static final int CAPABILITY_VIDEO_CALLING_RELIES_ON_PRESENCE = 256; // 0x100

/** @apiSince 23 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telecom.PhoneAccount> CREATOR;
static { CREATOR = null; }

/**
 * {@link android.telecom.PhoneAccount PhoneAccount} extras key (see {@link android.telecom.PhoneAccount#getExtras() PhoneAccount#getExtras()}) which determines the
 * character encoding to be used when determining the length of messages.
 * The user interface can use this when determining the number of characters the user may type
 * in a call subject.  If empty-string, the call subject message size limit will be enforced on
 * a 1:1 basis.  That is, each character will count towards the messages size limit as a single
 * character.  If a character encoding is specified, the message size limit will be based on the
 * number of bytes in the message per the specified encoding.  See
 * {@link #EXTRA_CALL_SUBJECT_MAX_LENGTH} for more information on the call subject maximum
 * length.
 * @apiSince 24
 */

public static final java.lang.String EXTRA_CALL_SUBJECT_CHARACTER_ENCODING = "android.telecom.extra.CALL_SUBJECT_CHARACTER_ENCODING";

/**
 * {@link android.telecom.PhoneAccount PhoneAccount} extras key (see {@link android.telecom.PhoneAccount#getExtras() PhoneAccount#getExtras()}) which determines the
 * maximum permitted length of a call subject specified via the
 * {@link android.telecom.TelecomManager#EXTRA_CALL_SUBJECT TelecomManager#EXTRA_CALL_SUBJECT} extra on an
 * {@link android.content.Intent#ACTION_CALL} intent.  Ultimately a {@link android.telecom.ConnectionService ConnectionService} is
 * responsible for enforcing the maximum call subject length when sending the message, however
 * this extra is provided so that the user interface can proactively limit the length of the
 * call subject as the user types it.
 * @apiSince 24
 */

public static final java.lang.String EXTRA_CALL_SUBJECT_MAX_LENGTH = "android.telecom.extra.CALL_SUBJECT_MAX_LENGTH";

/**
 * Boolean {@link android.telecom.PhoneAccount PhoneAccount} extras key (see {@link android.telecom.PhoneAccount#getExtras() PhoneAccount#getExtras()}) which
 * indicates whether a Self-Managed {@link android.telecom.PhoneAccount PhoneAccount} should log its calls to the call log.
 * Self-Managed {@link android.telecom.PhoneAccount PhoneAccount}s are responsible for their own notifications, so the system
 * will not create a notification when a missed call is logged.
 * <p>
 * By default, Self-Managed {@link android.telecom.PhoneAccount PhoneAccount}s do not log their calls to the call log.
 * Setting this extra to {@code true} provides a means for them to log their calls.
 * <p>
 * Note: Only calls where the {@link android.telecom.Call.Details#getHandle() Call.Details#getHandle()} {@link android.net.Uri#getScheme() Uri#getScheme()} is
 * {@link #SCHEME_SIP} or {@link #SCHEME_TEL} will be logged at the current time.
 * @apiSince 28
 */

public static final java.lang.String EXTRA_LOG_SELF_MANAGED_CALLS = "android.telecom.extra.LOG_SELF_MANAGED_CALLS";

/**
 * Boolean {@link android.telecom.PhoneAccount PhoneAccount} extras key (see {@link android.telecom.PhoneAccount#getExtras() PhoneAccount#getExtras()}) which
 * indicates whether this {@link android.telecom.PhoneAccount PhoneAccount} is capable of supporting a request to handover a
 * connection from this {@link android.telecom.PhoneAccount PhoneAccount} to another {@link android.telecom.PhoneAccount PhoneAccount}.
 * (see {@code android.telecom.Call#handoverTo()}) which specifies
 * {@link #EXTRA_SUPPORTS_HANDOVER_TO}.
 * <p>
 * A handover request is initiated by the user from the default dialer app to indicate a desire
 * to handover a call from one {@link android.telecom.PhoneAccount PhoneAccount}/{@link android.telecom.ConnectionService ConnectionService} to another.
 * @apiSince 28
 */

public static final java.lang.String EXTRA_SUPPORTS_HANDOVER_FROM = "android.telecom.extra.SUPPORTS_HANDOVER_FROM";

/**
 * Boolean {@link android.telecom.PhoneAccount PhoneAccount} extras key (see {@link android.telecom.PhoneAccount#getExtras() PhoneAccount#getExtras()}) which
 * indicates whether this {@link android.telecom.PhoneAccount PhoneAccount} is capable of supporting a request to handover a
 * connection (see {@code android.telecom.Call#handoverTo()}) to this {@link android.telecom.PhoneAccount PhoneAccount} from
 * a {@link android.telecom.PhoneAccount PhoneAccount} specifying {@link #EXTRA_SUPPORTS_HANDOVER_FROM}.
 * <p>
 * A handover request is initiated by the user from the default dialer app to indicate a desire
 * to handover a call from one {@link android.telecom.PhoneAccount PhoneAccount}/{@link android.telecom.ConnectionService ConnectionService} to another.
 * @apiSince 28
 */

public static final java.lang.String EXTRA_SUPPORTS_HANDOVER_TO = "android.telecom.extra.SUPPORTS_HANDOVER_TO";

/**
 * Indicating no hightlight color is set.
 * @apiSince 23
 */

public static final int NO_HIGHLIGHT_COLOR = 0; // 0x0

/**
 * Indicating no resource ID is set.
 * @apiSince 23
 */

public static final int NO_RESOURCE_ID = -1; // 0xffffffff

/**
 * URI scheme for SIP URIs.
 * @apiSince 23
 */

public static final java.lang.String SCHEME_SIP = "sip";

/**
 * URI scheme for telephone number URIs.
 * @apiSince 23
 */

public static final java.lang.String SCHEME_TEL = "tel";

/**
 * URI scheme for voicemail URIs.
 * @apiSince 23
 */

public static final java.lang.String SCHEME_VOICEMAIL = "voicemail";
/**
 * Helper class for creating a {@link android.telecom.PhoneAccount PhoneAccount}.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

/**
 * Creates a builder with the specified {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} and label.
 * @apiSince 23
 */

public Builder(android.telecom.PhoneAccountHandle accountHandle, java.lang.CharSequence label) { throw new RuntimeException("Stub!"); }

/**
 * Creates an instance of the {@link android.telecom.PhoneAccount.Builder PhoneAccount.Builder} from an existing
 * {@link android.telecom.PhoneAccount PhoneAccount}.
 *
 * @param phoneAccount The {@link android.telecom.PhoneAccount PhoneAccount} used to initialize the builder.
 * @apiSince 23
 */

public Builder(android.telecom.PhoneAccount phoneAccount) { throw new RuntimeException("Stub!"); }

/**
 * Sets the address. See {@link android.telecom.PhoneAccount#getAddress PhoneAccount#getAddress}.
 *
 * @param value The address of the phone account.
 * @return The builder.
 * @apiSince 23
 */

public android.telecom.PhoneAccount.Builder setAddress(android.net.Uri value) { throw new RuntimeException("Stub!"); }

/**
 * Sets the subscription address. See {@link android.telecom.PhoneAccount#getSubscriptionAddress PhoneAccount#getSubscriptionAddress}.
 *
 * @param value The subscription address.
 * @return The builder.
 * @apiSince 23
 */

public android.telecom.PhoneAccount.Builder setSubscriptionAddress(android.net.Uri value) { throw new RuntimeException("Stub!"); }

/**
 * Sets the capabilities. See {@link android.telecom.PhoneAccount#getCapabilities PhoneAccount#getCapabilities}.
 *
 * @param value The capabilities to set.
 * @return The builder.
 * @apiSince 23
 */

public android.telecom.PhoneAccount.Builder setCapabilities(int value) { throw new RuntimeException("Stub!"); }

/**
 * Sets the icon. See {@link android.telecom.PhoneAccount#getIcon PhoneAccount#getIcon}.
 *
 * @param icon The icon to set.
 * @apiSince 23
 */

public android.telecom.PhoneAccount.Builder setIcon(android.graphics.drawable.Icon icon) { throw new RuntimeException("Stub!"); }

/**
 * Sets the highlight color. See {@link android.telecom.PhoneAccount#getHighlightColor PhoneAccount#getHighlightColor}.
 *
 * @param value The highlight color.
 * @return The builder.
 * @apiSince 23
 */

public android.telecom.PhoneAccount.Builder setHighlightColor(int value) { throw new RuntimeException("Stub!"); }

/**
 * Sets the short description. See {@link android.telecom.PhoneAccount#getShortDescription PhoneAccount#getShortDescription}.
 *
 * @param value The short description.
 * @return The builder.
 * @apiSince 23
 */

public android.telecom.PhoneAccount.Builder setShortDescription(java.lang.CharSequence value) { throw new RuntimeException("Stub!"); }

/**
 * Specifies an additional URI scheme supported by the {@link android.telecom.PhoneAccount PhoneAccount}.
 *
 * @param uriScheme The URI scheme.
 * @return The builder.
 * @apiSince 23
 */

public android.telecom.PhoneAccount.Builder addSupportedUriScheme(java.lang.String uriScheme) { throw new RuntimeException("Stub!"); }

/**
 * Specifies the URI schemes supported by the {@link android.telecom.PhoneAccount PhoneAccount}.
 *
 * @param uriSchemes The URI schemes.
 * @return The builder.
 * @apiSince 23
 */

public android.telecom.PhoneAccount.Builder setSupportedUriSchemes(java.util.List<java.lang.String> uriSchemes) { throw new RuntimeException("Stub!"); }

/**
 * Specifies the extras associated with the {@link android.telecom.PhoneAccount PhoneAccount}.
 * <p>
 * {@code PhoneAccount}s only support extra values of type: {@link java.lang.String String}, {@link java.lang.Integer Integer},
 * and {@link java.lang.Boolean Boolean}.  Extras which are not of these types are ignored.
 *
 * @param extras
 * @return
 * @apiSince 24
 */

public android.telecom.PhoneAccount.Builder setExtras(android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Creates an instance of a {@link android.telecom.PhoneAccount PhoneAccount} based on the current builder settings.
 *
 * @return The {@link android.telecom.PhoneAccount PhoneAccount}.
 * @apiSince 23
 */

public android.telecom.PhoneAccount build() { throw new RuntimeException("Stub!"); }
}

}

