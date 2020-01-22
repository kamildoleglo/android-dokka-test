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


/**
 * Simple data container encapsulating a request to some entity to
 * create a new {@link android.telecom.Connection Connection}.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ConnectionRequest implements android.os.Parcelable {

/**
 * @param accountHandle The accountHandle which should be used to place the call.
 * @param handle The handle (e.g., phone number) to which the {@link android.telecom.Connection Connection} is to connect.
 * @param extras Application-specific extra data.
 * @apiSince 23
 */

public ConnectionRequest(android.telecom.PhoneAccountHandle accountHandle, android.net.Uri handle, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * @param accountHandle The accountHandle which should be used to place the call.
 * @param handle The handle (e.g., phone number) to which the {@link android.telecom.Connection Connection} is to connect.
 * @param extras Application-specific extra data.
 * @param videoState Determines the video state for the connection.
 * @apiSince 23
 */

public ConnectionRequest(android.telecom.PhoneAccountHandle accountHandle, android.net.Uri handle, android.os.Bundle extras, int videoState) { throw new RuntimeException("Stub!"); }

/**
 * The account which should be used to place the call.
 * @apiSince 23
 */

public android.telecom.PhoneAccountHandle getAccountHandle() { throw new RuntimeException("Stub!"); }

/**
 * The handle (e.g., phone number) to which the {@link android.telecom.Connection Connection} is to connect.
 * @apiSince 23
 */

public android.net.Uri getAddress() { throw new RuntimeException("Stub!"); }

/**
 * Application-specific extra data. Used for passing back information from an incoming
 * call {@code Intent}, and for any proprietary extensions arranged between a client
 * and servant {@code ConnectionService} which agree on a vocabulary for such data.
 * @apiSince 23
 */

public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * Describes the video states supported by the client requesting the connection.
 * Valid values: {@link android.telecom.VideoProfile#STATE_AUDIO_ONLY VideoProfile#STATE_AUDIO_ONLY},
 * {@link android.telecom.VideoProfile#STATE_BIDIRECTIONAL VideoProfile#STATE_BIDIRECTIONAL},
 * {@link android.telecom.VideoProfile#STATE_TX_ENABLED VideoProfile#STATE_TX_ENABLED},
 * {@link android.telecom.VideoProfile#STATE_RX_ENABLED VideoProfile#STATE_RX_ENABLED}.
 *
 * @return The video state for the connection.
 * @apiSince 23
 */

public int getVideoState() { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@link android.telecom.Connection.RttTextStream} object that should be used to
 * send and receive RTT text to/from the in-call app.
 * @return An instance of {@link android.telecom.Connection.RttTextStream}, or {@code null}
 * if this connection request is not requesting an RTT session upon connection establishment.
 * @apiSince 28
 */

public android.telecom.Connection.RttTextStream getRttTextStream() { throw new RuntimeException("Stub!"); }

/**
 * Convenience method for determining whether the ConnectionRequest is requesting an RTT session
 * @return {@code true} if RTT is requested, {@code false} otherwise.
 * @apiSince 28
 */

public boolean isRequestingRtt() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 23
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void writeToParcel(android.os.Parcel destination, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telecom.ConnectionRequest> CREATOR;
static { CREATOR = null; }
}

