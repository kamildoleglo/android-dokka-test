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

import android.media.ToneGenerator;

/**
 * Describes the cause of a disconnected call. This always includes a code describing the generic
 * cause of the disconnect. Optionally, it may include a label and/or description to display to the
 * user. It is the responsibility of the {@link android.telecom.ConnectionService ConnectionService} to provide localized versions of
 * the label and description. It also may contain a reason for the disconnect, which is intended for
 * logging and not for display to the user.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class DisconnectCause implements android.os.Parcelable {

/**
 * Creates a new DisconnectCause.
 *
 * @param code The code for the disconnect cause.
 * @apiSince 23
 */

public DisconnectCause(int code) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new DisconnectCause.
 *
 * @param code The code for the disconnect cause.
 * @param reason The reason for the disconnect.
 * @apiSince 23
 */

public DisconnectCause(int code, java.lang.String reason) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new DisconnectCause.
 *
 * @param code The code for the disconnect cause.
 * @param label The localized label to show to the user to explain the disconnect.
 * @param description The localized description to show to the user to explain the disconnect.
 * @param reason The reason for the disconnect.
 * @apiSince 23
 */

public DisconnectCause(int code, java.lang.CharSequence label, java.lang.CharSequence description, java.lang.String reason) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new DisconnectCause.
 *
 * @param code The code for the disconnect cause.
 * @param label The localized label to show to the user to explain the disconnect.
 * @param description The localized description to show to the user to explain the disconnect.
 * @param reason The reason for the disconnect.
 * @param toneToPlay The tone to play on disconnect, as defined in {@link android.media.ToneGenerator ToneGenerator}.
 * @apiSince 23
 */

public DisconnectCause(int code, java.lang.CharSequence label, java.lang.CharSequence description, java.lang.String reason, int toneToPlay) { throw new RuntimeException("Stub!"); }

/**
 * Returns the code for the reason for this disconnect.
 *
 * @return The disconnect code.
 * @apiSince 23
 */

public int getCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns a short label which explains the reason for the disconnect cause and is for display
 * in the user interface. If not null, it is expected that the In-Call UI should display this
 * text where it would normally display the call state ("Dialing", "Disconnected") and is
 * therefore expected to be relatively small. The {@link android.telecom.ConnectionService ConnectionService} is responsible for
 * providing and localizing this label. If there is no string provided, returns null.
 *
 * @return The disconnect label.
 * @apiSince 23
 */

public java.lang.CharSequence getLabel() { throw new RuntimeException("Stub!"); }

/**
 * Returns a description which explains the reason for the disconnect cause and is for display
 * in the user interface. This optional text is generally a longer and more descriptive version
 * of {@link #getLabel}, however it can exist even if {@link #getLabel} is empty. The In-Call UI
 * should display this relatively prominently; the traditional implementation displays this as
 * an alert dialog. The {@link android.telecom.ConnectionService ConnectionService} is responsible for providing and localizing
 * this message. If there is no string provided, returns null.
 *
 * @return The disconnect description.
 * @apiSince 23
 */

public java.lang.CharSequence getDescription() { throw new RuntimeException("Stub!"); }

/**
 * Returns an explanation of the reason for the disconnect. This is not intended for display to
 * the user and is used mainly for logging.
 *
 * @return The disconnect reason.
 * @apiSince 23
 */

public java.lang.String getReason() { throw new RuntimeException("Stub!"); }

/**
 * Returns the tone to play when disconnected.
 *
 * @return the tone as defined in {@link android.media.ToneGenerator ToneGenerator} to play when disconnected.
 * @apiSince 23
 */

public int getTone() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void writeToParcel(android.os.Parcel destination, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Disconnected because the user did not locally answer the incoming call, but it was answered
 * on another device where the call was ringing.
 * @apiSince 25
 */

public static final int ANSWERED_ELSEWHERE = 11; // 0xb

/**
 * Disconnected because the other party was busy.
 * @apiSince 23
 */

public static final int BUSY = 7; // 0x7

/**
 * Disconnected because the call was pulled from the current device to another device.
 * @apiSince 25
 */

public static final int CALL_PULLED = 12; // 0xc

/**
 * Disconnected because it has been canceled.
 * @apiSince 23
 */

public static final int CANCELED = 4; // 0x4

/**
 * Disconnected because the connection manager did not support the call. The call will be tried
 * again without a connection manager. See {@link android.telecom.PhoneAccount#CAPABILITY_CONNECTION_MANAGER PhoneAccount#CAPABILITY_CONNECTION_MANAGER}.
 * @apiSince 23
 */

public static final int CONNECTION_MANAGER_NOT_SUPPORTED = 10; // 0xa

/** @apiSince 23 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telecom.DisconnectCause> CREATOR;
static { CREATOR = null; }

/**
 * Disconnected because there was an error, such as a problem with the network.
 * @apiSince 23
 */

public static final int ERROR = 1; // 0x1

/**
 * Disconnected because of a local user-initiated action, such as hanging up.
 * @apiSince 23
 */

public static final int LOCAL = 2; // 0x2

/**
 * Disconnected because there was no response to an incoming call.
 * @apiSince 23
 */

public static final int MISSED = 5; // 0x5

/**
 * Disconnected for reason not described by other disconnect codes.
 * @apiSince 23
 */

public static final int OTHER = 9; // 0x9

/**
 * This reason is set when a call is ended in order to place an emergency call when a
 * {@link android.telecom.PhoneAccount PhoneAccount} doesn't support holding an ongoing call to place an emergency call. This
 * reason string should only be associated with the {@link #LOCAL} disconnect code returned from
 * {@link #getCode()}.
 * @apiSince R
 */

public static final java.lang.String REASON_EMERGENCY_CALL_PLACED = "REASON_EMERGENCY_CALL_PLACED";

/**
 * Disconnected because the user rejected an incoming call.
 * @apiSince 23
 */

public static final int REJECTED = 6; // 0x6

/**
 * Disconnected because of a remote user-initiated action, such as the other party hanging up
 * up.
 * @apiSince 23
 */

public static final int REMOTE = 3; // 0x3

/**
 * Disconnected because of a restriction on placing the call, such as dialing in airplane
 * mode.
 * @apiSince 23
 */

public static final int RESTRICTED = 8; // 0x8

/**
 * Disconnected because of an unknown or unspecified reason.
 * @apiSince 23
 */

public static final int UNKNOWN = 0; // 0x0
}

