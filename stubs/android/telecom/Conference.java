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

import android.telecom.Connection.VideoProvider;
import java.util.Set;
import android.os.SystemClock;
import android.os.Bundle;
import java.util.List;

/**
 * Represents a conference call which can contain any number of {@link android.telecom.Connection Connection} objects.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class Conference extends android.telecom.Conferenceable {

/**
 * Constructs a new Conference with a mandatory {@link android.telecom.PhoneAccountHandle PhoneAccountHandle}
 *
 * @param phoneAccount The {@code PhoneAccountHandle} associated with the conference.
 * @apiSince 23
 */

public Conference(android.telecom.PhoneAccountHandle phoneAccount) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} the conference call is being placed through.
 *
 * @return A {@code PhoneAccountHandle} object representing the PhoneAccount of the conference.
 * @apiSince 23
 */

public final android.telecom.PhoneAccountHandle getPhoneAccountHandle() { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of connections currently associated with the conference call.
 *
 * @return A list of {@code Connection} objects which represent the children of the conference.
 * @apiSince 23
 */

public final java.util.List<android.telecom.Connection> getConnections() { throw new RuntimeException("Stub!"); }

/**
 * Gets the state of the conference call. See {@link android.telecom.Connection Connection} for valid values.
 *
 * @return A constant representing the state the conference call is currently in.
 * @apiSince 23
 */

public final int getState() { throw new RuntimeException("Stub!"); }

/**
 * Returns the capabilities of the conference. See {@code CAPABILITY_*} constants in class
 * {@link android.telecom.Connection Connection} for valid values.
 *
 * @return A bitmask of the capabilities of the conference call.
 * @apiSince 23
 */

public final int getConnectionCapabilities() { throw new RuntimeException("Stub!"); }

/**
 * Returns the properties of the conference. See {@code PROPERTY_*} constants in class
 * {@link android.telecom.Connection Connection} for valid values.
 *
 * @return A bitmask of the properties of the conference call.
 * @apiSince 25
 */

public final int getConnectionProperties() { throw new RuntimeException("Stub!"); }

/**
 * @return The audio state of the conference, describing how its audio is currently
 *         being routed by the system. This is {@code null} if this Conference
 *         does not directly know about its audio state.
 * @apiSince 23
 */

public final android.telecom.CallAudioState getCallAudioState() { throw new RuntimeException("Stub!"); }

/**
 * Returns VideoProvider of the primary call. This can be null.
 * @apiSince 23
 */

public android.telecom.Connection.VideoProvider getVideoProvider() { throw new RuntimeException("Stub!"); }

/**
 * Returns video state of the primary call.
 * @apiSince 23
 */

public int getVideoState() { throw new RuntimeException("Stub!"); }

/**
 * Notifies the {@link android.telecom.Conference Conference} when the Conference and all it's {@link android.telecom.Connection Connection}s should
 * be disconnected.
 * @apiSince 23
 */

public void onDisconnect() { throw new RuntimeException("Stub!"); }

/**
 * Notifies the {@link android.telecom.Conference Conference} when the specified {@link android.telecom.Connection Connection} should be separated
 * from the conference call.
 *
 * @param connection The connection to separate.
 * @apiSince 23
 */

public void onSeparate(android.telecom.Connection connection) { throw new RuntimeException("Stub!"); }

/**
 * Notifies the {@link android.telecom.Conference Conference} when the specified {@link android.telecom.Connection Connection} should merged with the
 * conference call.
 *
 * @param connection The {@code Connection} to merge.
 * @apiSince 23
 */

public void onMerge(android.telecom.Connection connection) { throw new RuntimeException("Stub!"); }

/**
 * Notifies the {@link android.telecom.Conference Conference} when it should be put on hold.
 * @apiSince 23
 */

public void onHold() { throw new RuntimeException("Stub!"); }

/**
 * Notifies the {@link android.telecom.Conference Conference} when it should be moved from a held to active state.
 * @apiSince 23
 */

public void onUnhold() { throw new RuntimeException("Stub!"); }

/**
 * Notifies the {@link android.telecom.Conference Conference} when the child calls should be merged.  Only invoked if the
 * conference contains the capability {@link android.telecom.Connection#CAPABILITY_MERGE_CONFERENCE Connection#CAPABILITY_MERGE_CONFERENCE}.
 * @apiSince 23
 */

public void onMerge() { throw new RuntimeException("Stub!"); }

/**
 * Notifies the {@link android.telecom.Conference Conference} when the child calls should be swapped. Only invoked if the
 * conference contains the capability {@link android.telecom.Connection#CAPABILITY_SWAP_CONFERENCE Connection#CAPABILITY_SWAP_CONFERENCE}.
 * @apiSince 23
 */

public void onSwap() { throw new RuntimeException("Stub!"); }

/**
 * Notifies the {@link android.telecom.Conference Conference} of a request to play a DTMF tone.
 *
 * @param c A DTMF character.
 * @apiSince 23
 */

public void onPlayDtmfTone(char c) { throw new RuntimeException("Stub!"); }

/**
 * Notifies the {@link android.telecom.Conference Conference} of a request to stop any currently playing DTMF tones.
 * @apiSince 23
 */

public void onStopDtmfTone() { throw new RuntimeException("Stub!"); }

/**
 * Notifies the {@link android.telecom.Conference Conference} that the {@link #getCallAudioState()} property has a new
 * value.
 *
 * @param state The new call audio state.
 * @apiSince 23
 */

public void onCallAudioStateChanged(android.telecom.CallAudioState state) { throw new RuntimeException("Stub!"); }

/**
 * Notifies the {@link android.telecom.Conference Conference} that a {@link android.telecom.Connection Connection} has been added to it.
 *
 * @param connection The newly added connection.
 * @apiSince 23
 */

public void onConnectionAdded(android.telecom.Connection connection) { throw new RuntimeException("Stub!"); }

/**
 * Sets state to be on hold.
 * @apiSince 23
 */

public final void setOnHold() { throw new RuntimeException("Stub!"); }

/**
 * Sets state to be dialing.
 * @apiSince 23
 */

public final void setDialing() { throw new RuntimeException("Stub!"); }

/**
 * Sets state to be active.
 * @apiSince 23
 */

public final void setActive() { throw new RuntimeException("Stub!"); }

/**
 * Sets state to disconnected.
 *
 * @param disconnectCause The reason for the disconnection, as described by
 *     {@link android.telecom.DisconnectCause}.
 * @apiSince 23
 */

public final void setDisconnected(android.telecom.DisconnectCause disconnectCause) { throw new RuntimeException("Stub!"); }

/**
 * @return The {@link android.telecom.DisconnectCause DisconnectCause} for this connection.
 * @apiSince 23
 */

public final android.telecom.DisconnectCause getDisconnectCause() { throw new RuntimeException("Stub!"); }

/**
 * Sets the capabilities of a conference. See {@code CAPABILITY_*} constants of class
 * {@link android.telecom.Connection Connection} for valid values.
 *
 * @param connectionCapabilities A bitmask of the {@code Capabilities} of the conference call.
 * @apiSince 23
 */

public final void setConnectionCapabilities(int connectionCapabilities) { throw new RuntimeException("Stub!"); }

/**
 * Sets the properties of a conference. See {@code PROPERTY_*} constants of class
 * {@link android.telecom.Connection Connection} for valid values.
 *
 * @param connectionProperties A bitmask of the {@code Properties} of the conference call.
 * @apiSince 25
 */

public final void setConnectionProperties(int connectionProperties) { throw new RuntimeException("Stub!"); }

/**
 * Adds the specified connection as a child of this conference.
 *
 * @param connection The connection to add.
 * @return True if the connection was successfully added.
 * @apiSince 23
 */

public final boolean addConnection(android.telecom.Connection connection) { throw new RuntimeException("Stub!"); }

/**
 * Removes the specified connection as a child of this conference.
 *
 * @param connection The connection to remove.
 * @apiSince 23
 */

public final void removeConnection(android.telecom.Connection connection) { throw new RuntimeException("Stub!"); }

/**
 * Sets the connections with which this connection can be conferenced.
 *
 * @param conferenceableConnections The set of connections this connection can conference with.
 * @apiSince 23
 */

public final void setConferenceableConnections(java.util.List<android.telecom.Connection> conferenceableConnections) { throw new RuntimeException("Stub!"); }

/**
 * Set the video state for the conference.
 * Valid values: {@link android.telecom.VideoProfile#STATE_AUDIO_ONLY VideoProfile#STATE_AUDIO_ONLY},
 * {@link android.telecom.VideoProfile#STATE_BIDIRECTIONAL VideoProfile#STATE_BIDIRECTIONAL},
 * {@link android.telecom.VideoProfile#STATE_TX_ENABLED VideoProfile#STATE_TX_ENABLED},
 * {@link android.telecom.VideoProfile#STATE_RX_ENABLED VideoProfile#STATE_RX_ENABLED}.
 *
 * @param videoState The new video state.
 * @apiSince 23
 */

public final void setVideoState(android.telecom.Connection c, int videoState) { throw new RuntimeException("Stub!"); }

/**
 * Sets the video connection provider.
 *
 * @param videoProvider The video provider.
 * @apiSince 23
 */

public final void setVideoProvider(android.telecom.Connection c, android.telecom.Connection.VideoProvider videoProvider) { throw new RuntimeException("Stub!"); }

/**
 * Returns the connections with which this connection can be conferenced.
 * @apiSince 23
 */

public final java.util.List<android.telecom.Connection> getConferenceableConnections() { throw new RuntimeException("Stub!"); }

/**
 * Tears down the conference object and any of its current connections.
 * @apiSince 23
 */

public final void destroy() { throw new RuntimeException("Stub!"); }

/**
 * Sets the connection start time of the {@code Conference}.  This is used in the call log to
 * indicate the date and time when the conference took place.
 * <p>
 * Should be specified in wall-clock time returned by {@link java.lang.System#currentTimeMillis() System#currentTimeMillis()}.
 * <p>
 * When setting the connection time, you should always set the connection elapsed time via
 * {@link #setConnectionStartElapsedRealTime(long)} to ensure the duration is reflected.
 *
 * @param connectionTimeMillis The connection time, in milliseconds, as returned by
 *                             {@link java.lang.System#currentTimeMillis() System#currentTimeMillis()}.
 * @apiSince 23
 */

public final void setConnectionTime(long connectionTimeMillis) { throw new RuntimeException("Stub!"); }

/**
 * Sets the start time of the {@link android.telecom.Conference Conference} which is the basis for the determining the
 * duration of the {@link android.telecom.Conference Conference}.
 * <p>
 * You should use a value returned by {@link android.os.SystemClock#elapsedRealtime() SystemClock#elapsedRealtime()} to ensure that time
 * zone changes do not impact the conference duration.
 * <p>
 * When setting this, you should also set the connection time via
 * {@link #setConnectionTime(long)}.
 *
 * @param connectionStartElapsedRealTime The connection time, as measured by
 * {@link android.os.SystemClock#elapsedRealtime() SystemClock#elapsedRealtime()}.
 * @apiSince 28
 */

public final void setConnectionStartElapsedRealTime(long connectionStartElapsedRealTime) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the connection start time of the {@code Conference}, if specified.  A value of
 * {@link #CONNECT_TIME_NOT_SPECIFIED} indicates that Telecom should determine the start time
 * of the conference.
 *
 * @return The time at which the {@code Conference} was connected.
 * @apiSince 23
 */

public final long getConnectionTime() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Sets the label and icon status to display in the InCall UI.
 *
 * @param statusHints The status label and icon to set.
 * @apiSince 23
 */

public final void setStatusHints(android.telecom.StatusHints statusHints) { throw new RuntimeException("Stub!"); }

/**
 * @return The status hints for this conference.
 * @apiSince 23
 */

public final android.telecom.StatusHints getStatusHints() { throw new RuntimeException("Stub!"); }

/**
 * Replaces all the extras associated with this {@code Conference}.
 * <p>
 * New or existing keys are replaced in the {@code Conference} extras.  Keys which are no longer
 * in the new extras, but were present the last time {@code setExtras} was called are removed.
 * <p>
 * Alternatively you may use the {@link #putExtras(android.os.Bundle)}, and
 * {@link #removeExtras(java.lang.String...)} methods to modify the extras.
 * <p>
 * No assumptions should be made as to how an In-Call UI or service will handle these extras.
 * Keys should be fully qualified (e.g., com.example.extras.MY_EXTRA) to avoid conflicts.
 *
 * @param extras The extras associated with this {@code Conference}.
 
 * This value may be {@code null}.
 * @apiSince 23
 */

public final void setExtras(@androidx.annotation.Nullable android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Adds some extras to this {@link android.telecom.Conference Conference}.  Existing keys are replaced and new ones are
 * added.
 * <p>
 * No assumptions should be made as to how an In-Call UI or service will handle these extras.
 * Keys should be fully qualified (e.g., com.example.MY_EXTRA) to avoid conflicts.
 *
 * @param extras The extras to add.
 
 * This value must never be {@code null}.
 * @apiSince 25
 */

public final void putExtras(@androidx.annotation.NonNull android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Removes extras from this {@link android.telecom.Conference Conference}.
 *
 * @param keys The keys of the extras to remove.
 * @apiSince 25
 */

public final void removeExtras(java.util.List<java.lang.String> keys) { throw new RuntimeException("Stub!"); }

/**
 * Removes extras from this {@link android.telecom.Conference Conference}.
 *
 * @param keys The keys of the extras to remove.
 * @apiSince 25
 */

public final void removeExtras(java.lang.String... keys) { throw new RuntimeException("Stub!"); }

/**
 * Returns the extras associated with this conference.
 * <p>
 * Extras should be updated using {@link #putExtras(android.os.Bundle)} and {@link #removeExtras(java.util.List)}.
 * <p>
 * Telecom or an {@link android.telecom.InCallService InCallService} can also update the extras via
 * {@link android.telecom.Call#putExtras(Bundle)}, and
 * {@link android.telecom.Call#removeExtras(java.util.List) Call#removeExtras(List)}.
 * <p>
 * The conference is notified of changes to the extras made by Telecom or an
 * {@link android.telecom.InCallService InCallService} by {@link #onExtrasChanged(android.os.Bundle)}.
 *
 * @return The extras associated with this connection.
 * @apiSince 23
 */

public final android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * Notifies this {@link android.telecom.Conference Conference} of a change to the extras made outside the
 * {@link android.telecom.ConnectionService ConnectionService}.
 * <p>
 * These extras changes can originate from Telecom itself, or from an {@link android.telecom.InCallService InCallService} via
 * {@link android.telecom.Call#putExtras(Bundle)}, and
 * {@link android.telecom.Call#removeExtras(java.util.List) Call#removeExtras(List)}.
 *
 * @param extras The new extras bundle.
 * @apiSince 25
 */

public void onExtrasChanged(android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Sends an event associated with this {@code Conference} with associated event extras to the
 * {@link android.telecom.InCallService InCallService} (note: this is identical in concept to
 * {@link android.telecom.Connection#sendConnectionEvent(java.lang.String,android.os.Bundle) Connection#sendConnectionEvent(String, Bundle)}).
 * @see android.telecom.Connection#sendConnectionEvent(String, Bundle)
 *
 * @param event The connection event.
 * This value must never be {@code null}.
 * @param extras Optional bundle containing extra information associated with the event.
 
 * This value may be {@code null}.
 * @apiSince R
 */

public void sendConferenceEvent(@androidx.annotation.NonNull java.lang.String event, @androidx.annotation.Nullable android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Used to indicate that the conference connection time is not specified.  If not specified,
 * Telecom will set the connect time.
 * @apiSince 23
 */

public static final long CONNECT_TIME_NOT_SPECIFIED = 0L; // 0x0L
}

