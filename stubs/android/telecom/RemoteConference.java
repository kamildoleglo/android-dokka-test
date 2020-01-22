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
 * A conference provided to a {@link android.telecom.ConnectionService ConnectionService} by another {@code ConnectionService} through
 * {@link android.telecom.ConnectionService#conferenceRemoteConnections ConnectionService#conferenceRemoteConnections}. Once created, a {@code RemoteConference}
 * can be used to control the conference call or monitor changes through
 * {@link android.telecom.RemoteConnection.Callback RemoteConnection.Callback}.
 *
 * @see android.telecom.ConnectionService#onRemoteConferenceAdded
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class RemoteConference {

RemoteConference() { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of {@link android.telecom.RemoteConnection RemoteConnection}s contained in this conference.
 *
 * @return A list of child connections.
 * @apiSince 23
 */

public java.util.List<android.telecom.RemoteConnection> getConnections() { throw new RuntimeException("Stub!"); }

/**
 * Gets the state of the conference call. See {@link android.telecom.Connection Connection} for valid values.
 *
 * @return A constant representing the state the conference call is currently in.
 * @apiSince 23
 */

public int getState() { throw new RuntimeException("Stub!"); }

/**
 * Returns the capabilities of the conference. See {@code CAPABILITY_*} constants in class
 * {@link android.telecom.Connection Connection} for valid values.
 *
 * @return A bitmask of the capabilities of the conference call.
 * @apiSince 23
 */

public int getConnectionCapabilities() { throw new RuntimeException("Stub!"); }

/**
 * Returns the properties of the conference. See {@code PROPERTY_*} constants in class
 * {@link android.telecom.Connection Connection} for valid values.
 *
 * @return A bitmask of the properties of the conference call.
 * @apiSince 24
 */

public int getConnectionProperties() { throw new RuntimeException("Stub!"); }

/**
 * Obtain the extras associated with this {@code RemoteConnection}.
 *
 * @return The extras for this connection.
 * @apiSince 23
 */

public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * Disconnects the conference call as well as the child {@link android.telecom.RemoteConnection RemoteConnection}s.
 * @apiSince 23
 */

public void disconnect() { throw new RuntimeException("Stub!"); }

/**
 * Removes the specified {@link android.telecom.RemoteConnection RemoteConnection} from the conference. This causes the
 * {@link android.telecom.RemoteConnection RemoteConnection} to become a standalone connection. This is a no-op if the
 * {@link android.telecom.RemoteConnection RemoteConnection} does not belong to this conference.
 *
 * @param connection The remote-connection to remove.
 * @apiSince 23
 */

public void separate(android.telecom.RemoteConnection connection) { throw new RuntimeException("Stub!"); }

/**
 * Merges all {@link android.telecom.RemoteConnection RemoteConnection}s of this conference into a single call. This should be
 * invoked only if the conference contains the capability
 * {@link android.telecom.Connection#CAPABILITY_MERGE_CONFERENCE Connection#CAPABILITY_MERGE_CONFERENCE}, otherwise it is a no-op. The presence of said
 * capability indicates that the connections of this conference, despite being part of the
 * same conference object, are yet to have their audio streams merged; this is a common pattern
 * for CDMA conference calls, but the capability is not used for GSM and SIP conference calls.
 * Invoking this method will cause the unmerged child connections to merge their audio
 * streams.
 * @apiSince 23
 */

public void merge() { throw new RuntimeException("Stub!"); }

/**
 * Swaps the active audio stream between the conference's child {@link android.telecom.RemoteConnection RemoteConnection}s.
 * This should be invoked only if the conference contains the capability
 * {@link android.telecom.Connection#CAPABILITY_SWAP_CONFERENCE Connection#CAPABILITY_SWAP_CONFERENCE}, otherwise it is a no-op. This is only used by
 * {@link android.telecom.ConnectionService ConnectionService}s that create conferences for connections that do not yet have
 * their audio streams merged; this is a common pattern for CDMA conference calls, but the
 * capability is not used for GSM and SIP conference calls. Invoking this method will change the
 * active audio stream to a different child connection.
 * @apiSince 23
 */

public void swap() { throw new RuntimeException("Stub!"); }

/**
 * Puts the conference on hold.
 * @apiSince 23
 */

public void hold() { throw new RuntimeException("Stub!"); }

/**
 * Unholds the conference call.
 * @apiSince 23
 */

public void unhold() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.telecom.DisconnectCause DisconnectCause} for the conference if it is in the state
 * {@link android.telecom.Connection#STATE_DISCONNECTED Connection#STATE_DISCONNECTED}. If the conference is not disconnected, this will
 * return null.
 *
 * @return The disconnect cause.
 * @apiSince 23
 */

public android.telecom.DisconnectCause getDisconnectCause() { throw new RuntimeException("Stub!"); }

/**
 * Requests that the conference start playing the specified DTMF tone.
 *
 * @param digit The digit for which to play a DTMF tone.
 * @apiSince 23
 */

public void playDtmfTone(char digit) { throw new RuntimeException("Stub!"); }

/**
 * Stops the most recent request to play a DTMF tone.
 *
 * @see #playDtmfTone
 * @apiSince 23
 */

public void stopDtmfTone() { throw new RuntimeException("Stub!"); }

/**
 * Request to change the conference's audio routing to the specified state. The specified state
 * can include audio routing (Bluetooth, Speaker, etc) and muting state.
 * @apiSince 23
 */

public void setCallAudioState(android.telecom.CallAudioState state) { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of independent connections that can me merged with this conference.
 *
 * @return A list of conferenceable connections.
 * @apiSince 23
 */

public java.util.List<android.telecom.RemoteConnection> getConferenceableConnections() { throw new RuntimeException("Stub!"); }

/**
 * Register a callback through which to receive state updates for this conference.
 *
 * @param callback The callback to notify of state changes.
 * @apiSince 23
 */

public void registerCallback(android.telecom.RemoteConference.Callback callback) { throw new RuntimeException("Stub!"); }

/**
 * Registers a callback through which to receive state updates for this conference.
 * Callbacks will be notified using the specified handler, if provided.
 *
 * @param callback The callback to notify of state changes.
 * @param handler The handler on which to execute the callbacks.
 * @apiSince 23
 */

public void registerCallback(android.telecom.RemoteConference.Callback callback, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters a previously registered callback.
 *
 * @see #registerCallback
 *
 * @param callback The callback to unregister.
 * @apiSince 23
 */

public void unregisterCallback(android.telecom.RemoteConference.Callback callback) { throw new RuntimeException("Stub!"); }
/**
 * Callback base class for {@link android.telecom.RemoteConference RemoteConference}.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class Callback {

public Callback() { throw new RuntimeException("Stub!"); }

/**
 * Invoked when the state of this {@code RemoteConferece} has changed. See
 * {@link #getState()}.
 *
 * @param conference The {@code RemoteConference} invoking this method.
 * @param oldState The previous state of the {@code RemoteConference}.
 * @param newState The new state of the {@code RemoteConference}.
 * @apiSince 23
 */

public void onStateChanged(android.telecom.RemoteConference conference, int oldState, int newState) { throw new RuntimeException("Stub!"); }

/**
 * Invoked when this {@code RemoteConference} is disconnected.
 *
 * @param conference The {@code RemoteConference} invoking this method.
 * @param disconnectCause The ({@see DisconnectCause}) associated with this failed
 *     conference.
 * @apiSince 23
 */

public void onDisconnected(android.telecom.RemoteConference conference, android.telecom.DisconnectCause disconnectCause) { throw new RuntimeException("Stub!"); }

/**
 * Invoked when a {@link android.telecom.RemoteConnection RemoteConnection} is added to the conference call.
 *
 * @param conference The {@code RemoteConference} invoking this method.
 * @param connection The {@link android.telecom.RemoteConnection RemoteConnection} being added.
 * @apiSince 23
 */

public void onConnectionAdded(android.telecom.RemoteConference conference, android.telecom.RemoteConnection connection) { throw new RuntimeException("Stub!"); }

/**
 * Invoked when a {@link android.telecom.RemoteConnection RemoteConnection} is removed from the conference call.
 *
 * @param conference The {@code RemoteConference} invoking this method.
 * @param connection The {@link android.telecom.RemoteConnection RemoteConnection} being removed.
 * @apiSince 23
 */

public void onConnectionRemoved(android.telecom.RemoteConference conference, android.telecom.RemoteConnection connection) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that the call capabilities of this {@code RemoteConference} have changed.
 * See {@link #getConnectionCapabilities()}.
 *
 * @param conference The {@code RemoteConference} invoking this method.
 * @param connectionCapabilities The new capabilities of the {@code RemoteConference}.
 * @apiSince 23
 */

public void onConnectionCapabilitiesChanged(android.telecom.RemoteConference conference, int connectionCapabilities) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that the call properties of this {@code RemoteConference} have changed.
 * See {@link #getConnectionProperties()}.
 *
 * @param conference The {@code RemoteConference} invoking this method.
 * @param connectionProperties The new properties of the {@code RemoteConference}.
 * @apiSince 25
 */

public void onConnectionPropertiesChanged(android.telecom.RemoteConference conference, int connectionProperties) { throw new RuntimeException("Stub!"); }

/**
 * Invoked when the set of {@link android.telecom.RemoteConnection RemoteConnection}s which can be added to this conference
 * call have changed.
 *
 * @param conference The {@code RemoteConference} invoking this method.
 * @param conferenceableConnections The list of conferenceable {@link android.telecom.RemoteConnection RemoteConnection}s.
 * @apiSince 23
 */

public void onConferenceableConnectionsChanged(android.telecom.RemoteConference conference, java.util.List<android.telecom.RemoteConnection> conferenceableConnections) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that this {@code RemoteConference} has been destroyed. No further requests
 * should be made to the {@code RemoteConference}, and references to it should be cleared.
 *
 * @param conference The {@code RemoteConference} invoking this method.
 * @apiSince 23
 */

public void onDestroyed(android.telecom.RemoteConference conference) { throw new RuntimeException("Stub!"); }

/**
 * Handles changes to the {@code RemoteConference} extras.
 *
 * @param conference The {@code RemoteConference} invoking this method.
 * @param extras The extras containing other information associated with the conference.
 
 * This value may be {@code null}.
 * @apiSince 23
 */

public void onExtrasChanged(android.telecom.RemoteConference conference, @androidx.annotation.Nullable android.os.Bundle extras) { throw new RuntimeException("Stub!"); }
}

}

