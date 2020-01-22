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

import android.os.Handler;
import java.util.Set;
import android.os.Bundle;
import android.hardware.camera2.CameraManager;
import android.view.Surface;
import android.net.Uri;

/**
 * A connection provided to a {@link android.telecom.ConnectionService ConnectionService} by another {@code ConnectionService}
 * running in a different process.
 *
 * @see android.telecom.ConnectionService#createRemoteOutgoingConnection(PhoneAccountHandle, ConnectionRequest)
 * @see android.telecom.ConnectionService#createRemoteIncomingConnection(PhoneAccountHandle, ConnectionRequest)
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class RemoteConnection {

RemoteConnection() { throw new RuntimeException("Stub!"); }

/**
 * Adds a callback to this {@code RemoteConnection}.
 *
 * @param callback A {@code Callback}.
 * @apiSince 23
 */

public void registerCallback(android.telecom.RemoteConnection.Callback callback) { throw new RuntimeException("Stub!"); }

/**
 * Adds a callback to this {@code RemoteConnection}.
 *
 * @param callback A {@code Callback}.
 * @param handler A {@code Handler} which command and status changes will be delivered to.
 * @apiSince 23
 */

public void registerCallback(android.telecom.RemoteConnection.Callback callback, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Removes a callback from this {@code RemoteConnection}.
 *
 * @param callback A {@code Callback}.
 * @apiSince 23
 */

public void unregisterCallback(android.telecom.RemoteConnection.Callback callback) { throw new RuntimeException("Stub!"); }

/**
 * Obtains the state of this {@code RemoteConnection}.
 *
 * @return A state value, chosen from the {@code STATE_*} constants.
 * @apiSince 23
 */

public int getState() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the reason why this {@code RemoteConnection} may have been disconnected.
 *
 * @return For a {@link android.telecom.Connection#STATE_DISCONNECTED Connection#STATE_DISCONNECTED} {@code RemoteConnection}, the
 *         disconnect cause expressed as a code chosen from among those declared in
 *         {@link android.telecom.DisconnectCause DisconnectCause}.
 * @apiSince 23
 */

public android.telecom.DisconnectCause getDisconnectCause() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the capabilities of this {@code RemoteConnection}.
 *
 * @return A bitmask of the capabilities of the {@code RemoteConnection}, as defined in
 *         the {@code CAPABILITY_*} constants in class {@link android.telecom.Connection Connection}.
 * @apiSince 23
 */

public int getConnectionCapabilities() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the properties of this {@code RemoteConnection}.
 *
 * @return A bitmask of the properties of the {@code RemoteConnection}, as defined in the
 *         {@code PROPERTY_*} constants in class {@link android.telecom.Connection Connection}.
 * @apiSince 25
 */

public int getConnectionProperties() { throw new RuntimeException("Stub!"); }

/**
 * Determines if the audio mode of this {@code RemoteConnection} is VOIP.
 *
 * @return {@code true} if the {@code RemoteConnection}'s current audio mode is VOIP.
 * @apiSince 23
 */

public boolean isVoipAudioMode() { throw new RuntimeException("Stub!"); }

/**
 * Obtains status hints pertaining to this {@code RemoteConnection}.
 *
 * @return The current {@link android.telecom.StatusHints StatusHints} of this {@code RemoteConnection},
 *         or {@code null} if none have been set.
 * @apiSince 23
 */

public android.telecom.StatusHints getStatusHints() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the address of this {@code RemoteConnection}.
 *
 * @return The address (e.g., phone number) to which the {@code RemoteConnection}
 *         is currently connected.
 * @apiSince 23
 */

public android.net.Uri getAddress() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the presentation requirements for the address of this {@code RemoteConnection}.
 *
 * @return The presentation requirements for the address. See
 *         {@link android.telecom.TelecomManager TelecomManager} for valid values.
 * @apiSince 23
 */

public int getAddressPresentation() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the display name for this {@code RemoteConnection}'s caller.
 *
 * @return The display name for the caller.
 * @apiSince 23
 */

public java.lang.CharSequence getCallerDisplayName() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the presentation requirements for this {@code RemoteConnection}'s
 * caller's display name.
 *
 * @return The presentation requirements for the caller display name. See
 *         {@link android.telecom.TelecomManager TelecomManager} for valid values.
 * @apiSince 23
 */

public int getCallerDisplayNamePresentation() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the video state of this {@code RemoteConnection}.
 *
 * @return The video state of the {@code RemoteConnection}. See {@link android.telecom.VideoProfile VideoProfile}.
 * @apiSince 23
 */

public int getVideoState() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the video provider of this {@code RemoteConnection}.
 * @return The video provider associated with this {@code RemoteConnection}.
 * @apiSince 23
 */

public android.telecom.RemoteConnection.VideoProvider getVideoProvider() { throw new RuntimeException("Stub!"); }

/**
 * Obtain the extras associated with this {@code RemoteConnection}.
 *
 * @return The extras for this connection.
 * @apiSince 23
 */

public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * Determines whether this {@code RemoteConnection} is requesting ringback.
 *
 * @return Whether the {@code RemoteConnection} is requesting that the framework play a
 *         ringback tone on its behalf.
 * @apiSince 23
 */

public boolean isRingbackRequested() { throw new RuntimeException("Stub!"); }

/**
 * Instructs this {@code RemoteConnection} to abort.
 * @apiSince 23
 */

public void abort() { throw new RuntimeException("Stub!"); }

/**
 * Instructs this {@link android.telecom.Connection#STATE_RINGING Connection#STATE_RINGING} {@code RemoteConnection} to answer.
 * @apiSince 23
 */

public void answer() { throw new RuntimeException("Stub!"); }

/**
 * Instructs this {@link android.telecom.Connection#STATE_RINGING Connection#STATE_RINGING} {@code RemoteConnection} to reject.
 * @apiSince 23
 */

public void reject() { throw new RuntimeException("Stub!"); }

/**
 * Instructs this {@code RemoteConnection} to go on hold.
 * @apiSince 23
 */

public void hold() { throw new RuntimeException("Stub!"); }

/**
 * Instructs this {@link android.telecom.Connection#STATE_HOLDING Connection#STATE_HOLDING} call to release from hold.
 * @apiSince 23
 */

public void unhold() { throw new RuntimeException("Stub!"); }

/**
 * Instructs this {@code RemoteConnection} to disconnect.
 * @apiSince 23
 */

public void disconnect() { throw new RuntimeException("Stub!"); }

/**
 * Instructs this {@code RemoteConnection} to play a dual-tone multi-frequency signaling
 * (DTMF) tone.
 *
 * Any other currently playing DTMF tone in the specified call is immediately stopped.
 *
 * @param digit A character representing the DTMF digit for which to play the tone. This
 *         value must be one of {@code '0'} through {@code '9'}, {@code '*'} or {@code '#'}.
 * @apiSince 23
 */

public void playDtmfTone(char digit) { throw new RuntimeException("Stub!"); }

/**
 * Instructs this {@code RemoteConnection} to stop any dual-tone multi-frequency signaling
 * (DTMF) tone currently playing.
 *
 * DTMF tones are played by calling {@link #playDtmfTone(char)}. If no DTMF tone is
 * currently playing, this method will do nothing.
 * @apiSince 23
 */

public void stopDtmfTone() { throw new RuntimeException("Stub!"); }

/**
 * Instructs this {@code RemoteConnection} to continue playing a post-dial DTMF string.
 *
 * A post-dial DTMF string is a string of digits following the first instance of either
 * {@link android.telecom.TelecomManager#DTMF_CHARACTER_WAIT TelecomManager#DTMF_CHARACTER_WAIT} or {@link android.telecom.TelecomManager#DTMF_CHARACTER_PAUSE TelecomManager#DTMF_CHARACTER_PAUSE}.
 * These digits are immediately sent as DTMF tones to the recipient as soon as the
 * connection is made.
 *
 * If the DTMF string contains a {@link android.telecom.TelecomManager#DTMF_CHARACTER_PAUSE TelecomManager#DTMF_CHARACTER_PAUSE} symbol, this
 * {@code RemoteConnection} will temporarily pause playing the tones for a pre-defined period
 * of time.
 *
 * If the DTMF string contains a {@link android.telecom.TelecomManager#DTMF_CHARACTER_WAIT TelecomManager#DTMF_CHARACTER_WAIT} symbol, this
 * {@code RemoteConnection} will pause playing the tones and notify callbacks via
 * {@link android.telecom.RemoteConnection.Callback#onPostDialWait(android.telecom.RemoteConnection,java.lang.String) Callback#onPostDialWait(RemoteConnection, String)}. At this point, the in-call app
 * should display to the user an indication of this state and an affordance to continue
 * the postdial sequence. When the user decides to continue the postdial sequence, the in-call
 * app should invoke the {@link #postDialContinue(boolean)} method.
 *
 * @param proceed Whether or not to continue with the post-dial sequence.
 * @apiSince 23
 */

public void postDialContinue(boolean proceed) { throw new RuntimeException("Stub!"); }

/**
 * Instructs this {@link android.telecom.RemoteConnection RemoteConnection} to pull itself to the local device.
 * <p>
 * See {@link android.telecom.Call#pullExternalCall() Call#pullExternalCall()} for more information.
 * @apiSince 25
 */

public void pullExternalCall() { throw new RuntimeException("Stub!"); }

/**
 * Set the audio state of this {@code RemoteConnection}.
 *
 * @param state The audio state of this {@code RemoteConnection}.
 * @apiSince 23
 */

public void setCallAudioState(android.telecom.CallAudioState state) { throw new RuntimeException("Stub!"); }

/**
 * Obtain the {@code RemoteConnection}s with which this {@code RemoteConnection} may be
 * successfully asked to create a conference with.
 *
 * @return The {@code RemoteConnection}s with which this {@code RemoteConnection} may be
 *         merged into a {@link android.telecom.RemoteConference RemoteConference}.
 * @apiSince 23
 */

public java.util.List<android.telecom.RemoteConnection> getConferenceableConnections() { throw new RuntimeException("Stub!"); }

/**
 * Obtain the {@code RemoteConference} that this {@code RemoteConnection} may be a part
 * of, or {@code null} if there is no such {@code RemoteConference}.
 *
 * @return A {@code RemoteConference} or {@code null};
 * @apiSince 23
 */

public android.telecom.RemoteConference getConference() { throw new RuntimeException("Stub!"); }
/**
 * Callback base class for {@link android.telecom.RemoteConnection RemoteConnection}.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class Callback {

public Callback() { throw new RuntimeException("Stub!"); }

/**
 * Invoked when the state of this {@code RemoteConnection} has changed. See
 * {@link #getState()}.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 * @param state The new state of the {@code RemoteConnection}.
 * @apiSince 23
 */

public void onStateChanged(android.telecom.RemoteConnection connection, int state) { throw new RuntimeException("Stub!"); }

/**
 * Invoked when this {@code RemoteConnection} is disconnected.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 * @param disconnectCause The ({@see DisconnectCause}) associated with this failed
 *     connection.
 * @apiSince 23
 */

public void onDisconnected(android.telecom.RemoteConnection connection, android.telecom.DisconnectCause disconnectCause) { throw new RuntimeException("Stub!"); }

/**
 * Invoked when this {@code RemoteConnection} is requesting ringback. See
 * {@link #isRingbackRequested()}.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 * @param ringback Whether the {@code RemoteConnection} is requesting ringback.
 * @apiSince 23
 */

public void onRingbackRequested(android.telecom.RemoteConnection connection, boolean ringback) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that the call capabilities of this {@code RemoteConnection} have changed.
 * See {@link #getConnectionCapabilities()}.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 * @param connectionCapabilities The new capabilities of the {@code RemoteConnection}.
 * @apiSince 23
 */

public void onConnectionCapabilitiesChanged(android.telecom.RemoteConnection connection, int connectionCapabilities) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that the call properties of this {@code RemoteConnection} have changed.
 * See {@link #getConnectionProperties()}.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 * @param connectionProperties The new properties of the {@code RemoteConnection}.
 * @apiSince 25
 */

public void onConnectionPropertiesChanged(android.telecom.RemoteConnection connection, int connectionProperties) { throw new RuntimeException("Stub!"); }

/**
 * Invoked when the post-dial sequence in the outgoing {@code Connection} has reached a
 * pause character. This causes the post-dial signals to stop pending user confirmation. An
 * implementation should present this choice to the user and invoke
 * {@link android.telecom.RemoteConnection#postDialContinue(boolean) RemoteConnection#postDialContinue(boolean)} when the user makes the choice.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 * @param remainingPostDialSequence The post-dial characters that remain to be sent.
 * @apiSince 23
 */

public void onPostDialWait(android.telecom.RemoteConnection connection, java.lang.String remainingPostDialSequence) { throw new RuntimeException("Stub!"); }

/**
 * Invoked when the post-dial sequence in the outgoing {@code Connection} has processed
 * a character.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 * @param nextChar The character being processed.
 * @apiSince 23
 */

public void onPostDialChar(android.telecom.RemoteConnection connection, char nextChar) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that the VOIP audio status of this {@code RemoteConnection} has changed.
 * See {@link #isVoipAudioMode()}.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 * @param isVoip Whether the new audio state of the {@code RemoteConnection} is VOIP.
 * @apiSince 23
 */

public void onVoipAudioChanged(android.telecom.RemoteConnection connection, boolean isVoip) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that the status hints of this {@code RemoteConnection} have changed. See
 * {@link #getStatusHints()} ()}.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 * @param statusHints The new status hints of the {@code RemoteConnection}.
 * @apiSince 23
 */

public void onStatusHintsChanged(android.telecom.RemoteConnection connection, android.telecom.StatusHints statusHints) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that the address (e.g., phone number) of this {@code RemoteConnection} has
 * changed. See {@link #getAddress()} and {@link #getAddressPresentation()}.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 * @param address The new address of the {@code RemoteConnection}.
 * @param presentation The presentation requirements for the address.
 *        See {@link android.telecom.TelecomManager TelecomManager} for valid values.
 * @apiSince 23
 */

public void onAddressChanged(android.telecom.RemoteConnection connection, android.net.Uri address, int presentation) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that the caller display name of this {@code RemoteConnection} has changed.
 * See {@link #getCallerDisplayName()} and {@link #getCallerDisplayNamePresentation()}.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 * @param callerDisplayName The new caller display name of the {@code RemoteConnection}.
 * @param presentation The presentation requirements for the handle.
 *        See {@link android.telecom.TelecomManager TelecomManager} for valid values.
 * @apiSince 23
 */

public void onCallerDisplayNameChanged(android.telecom.RemoteConnection connection, java.lang.String callerDisplayName, int presentation) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that the video state of this {@code RemoteConnection} has changed.
 * See {@link #getVideoState()}.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 * @param videoState The new video state of the {@code RemoteConnection}.
 * @apiSince 23
 */

public void onVideoStateChanged(android.telecom.RemoteConnection connection, int videoState) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that this {@code RemoteConnection} has been destroyed. No further requests
 * should be made to the {@code RemoteConnection}, and references to it should be cleared.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 * @apiSince 23
 */

public void onDestroyed(android.telecom.RemoteConnection connection) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that the {@code RemoteConnection}s with which this {@code RemoteConnection}
 * may be asked to create a conference has changed.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 * @param conferenceableConnections The {@code RemoteConnection}s with which this
 *         {@code RemoteConnection} may be asked to create a conference.
 * @apiSince 23
 */

public void onConferenceableConnectionsChanged(android.telecom.RemoteConnection connection, java.util.List<android.telecom.RemoteConnection> conferenceableConnections) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that the {@code VideoProvider} associated with this {@code RemoteConnection}
 * has changed.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 * @param videoProvider The new {@code VideoProvider} associated with this
 *         {@code RemoteConnection}.
 * @apiSince 23
 */

public void onVideoProviderChanged(android.telecom.RemoteConnection connection, android.telecom.RemoteConnection.VideoProvider videoProvider) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that the {@code RemoteConference} that this {@code RemoteConnection} is a part
 * of has changed.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 * @param conference The {@code RemoteConference} of which this {@code RemoteConnection} is
 *         a part, which may be {@code null}.
 * @apiSince 23
 */

public void onConferenceChanged(android.telecom.RemoteConnection connection, android.telecom.RemoteConference conference) { throw new RuntimeException("Stub!"); }

/**
 * Handles changes to the {@code RemoteConnection} extras.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 * @param extras The extras containing other information associated with the connection.
 
 * This value may be {@code null}.
 * @apiSince 23
 */

public void onExtrasChanged(android.telecom.RemoteConnection connection, @androidx.annotation.Nullable android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Handles a connection event propagated to this {@link android.telecom.RemoteConnection RemoteConnection}.
 * <p>
 * Connection events originate from {@link android.telecom.Connection#sendConnectionEvent(java.lang.String,android.os.Bundle) Connection#sendConnectionEvent(String, Bundle)}.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 * @param event The connection event.
 * @param extras Extras associated with the event.
 * @apiSince 25
 */

public void onConnectionEvent(android.telecom.RemoteConnection connection, java.lang.String event, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }
}

/**
 * {@link android.telecom.RemoteConnection.VideoProvider RemoteConnection.VideoProvider} associated with a {@link android.telecom.RemoteConnection RemoteConnection}.  Used to
 * receive video related events and control the video associated with a
 * {@link android.telecom.RemoteConnection RemoteConnection}.
 *
 * @see android.telecom.Connection.VideoProvider
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class VideoProvider {

VideoProvider() { throw new RuntimeException("Stub!"); }

/**
 * Registers a callback to receive commands and state changes for video calls.
 *
 * @param l The video call callback.
 * @apiSince 23
 */

public void registerCallback(android.telecom.RemoteConnection.VideoProvider.Callback l) { throw new RuntimeException("Stub!"); }

/**
 * Clears the video call callback set via {@link #registerCallback}.
 *
 * @param l The video call callback to clear.
 * @apiSince 23
 */

public void unregisterCallback(android.telecom.RemoteConnection.VideoProvider.Callback l) { throw new RuntimeException("Stub!"); }

/**
 * Sets the camera to be used for the outgoing video for the
 * {@link android.telecom.RemoteConnection.VideoProvider RemoteConnection.VideoProvider}.
 *
 * @param cameraId The id of the camera (use ids as reported by
 * {@link android.hardware.camera2.CameraManager#getCameraIdList() CameraManager#getCameraIdList()}).
 * @see android.telecom.Connection.VideoProvider#onSetCamera(String)
 * @apiSince 23
 */

public void setCamera(java.lang.String cameraId) { throw new RuntimeException("Stub!"); }

/**
 * Sets the surface to be used for displaying a preview of what the user's camera is
 * currently capturing for the {@link android.telecom.RemoteConnection.VideoProvider RemoteConnection.VideoProvider}.
 *
 * @param surface The {@link android.view.Surface Surface}.
 * @see android.telecom.Connection.VideoProvider#onSetPreviewSurface(Surface)
 * @apiSince 23
 */

public void setPreviewSurface(android.view.Surface surface) { throw new RuntimeException("Stub!"); }

/**
 * Sets the surface to be used for displaying the video received from the remote device for
 * the {@link android.telecom.RemoteConnection.VideoProvider RemoteConnection.VideoProvider}.
 *
 * @param surface The {@link android.view.Surface Surface}.
 * @see android.telecom.Connection.VideoProvider#onSetDisplaySurface(Surface)
 * @apiSince 23
 */

public void setDisplaySurface(android.view.Surface surface) { throw new RuntimeException("Stub!"); }

/**
 * Sets the device orientation, in degrees, for the {@link android.telecom.RemoteConnection.VideoProvider RemoteConnection.VideoProvider}.
 * Assumes that a standard portrait orientation of the device is 0 degrees.
 *
 * @param rotation The device orientation, in degrees.
 * @see android.telecom.Connection.VideoProvider#onSetDeviceOrientation(int)
 * @apiSince 23
 */

public void setDeviceOrientation(int rotation) { throw new RuntimeException("Stub!"); }

/**
 * Sets camera zoom ratio for the {@link android.telecom.RemoteConnection.VideoProvider RemoteConnection.VideoProvider}.
 *
 * @param value The camera zoom ratio.
 * @see android.telecom.Connection.VideoProvider#onSetZoom(float)
 * @apiSince 23
 */

public void setZoom(float value) { throw new RuntimeException("Stub!"); }

/**
 * Issues a request to modify the properties of the current video session for the
 * {@link android.telecom.RemoteConnection.VideoProvider RemoteConnection.VideoProvider}.
 *
 * @param fromProfile The video profile prior to the request.
 * @param toProfile The video profile with the requested changes made.
 * @see android.telecom.Connection.VideoProvider#onSendSessionModifyRequest(VideoProfile, VideoProfile)
 * @apiSince 23
 */

public void sendSessionModifyRequest(android.telecom.VideoProfile fromProfile, android.telecom.VideoProfile toProfile) { throw new RuntimeException("Stub!"); }

/**
 * Provides a response to a request to change the current call video session
 * properties for the {@link android.telecom.RemoteConnection.VideoProvider RemoteConnection.VideoProvider}.
 *
 * @param responseProfile The response call video properties.
 * @see android.telecom.Connection.VideoProvider#onSendSessionModifyResponse(VideoProfile)
 * @apiSince 23
 */

public void sendSessionModifyResponse(android.telecom.VideoProfile responseProfile) { throw new RuntimeException("Stub!"); }

/**
 * Issues a request to retrieve the capabilities of the current camera for the
 * {@link android.telecom.RemoteConnection.VideoProvider RemoteConnection.VideoProvider}.
 *
 * @see android.telecom.Connection.VideoProvider#onRequestCameraCapabilities()
 * @apiSince 23
 */

public void requestCameraCapabilities() { throw new RuntimeException("Stub!"); }

/**
 * Issues a request to retrieve the data usage (in bytes) of the video portion of the
 * {@link android.telecom.RemoteConnection RemoteConnection} for the {@link android.telecom.RemoteConnection.VideoProvider RemoteConnection.VideoProvider}.
 *
 * @see android.telecom.Connection.VideoProvider#onRequestConnectionDataUsage()
 * @apiSince 23
 */

public void requestCallDataUsage() { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link android.net.Uri Uri} of an image to be displayed to the peer device when the video signal
 * is paused, for the {@link android.telecom.RemoteConnection.VideoProvider RemoteConnection.VideoProvider}.
 *
 * @see android.telecom.Connection.VideoProvider#onSetPauseImage(Uri)
 * @apiSince 23
 */

public void setPauseImage(android.net.Uri uri) { throw new RuntimeException("Stub!"); }
/**
 * Callback class used by the {@link android.telecom.RemoteConnection.VideoProvider RemoteConnection.VideoProvider} to relay events from
 * the {@link android.telecom.Connection.VideoProvider Connection.VideoProvider}.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class Callback {

public Callback() { throw new RuntimeException("Stub!"); }

/**
 * Reports a session modification request received from the
 * {@link android.telecom.Connection.VideoProvider Connection.VideoProvider} associated with a {@link android.telecom.RemoteConnection RemoteConnection}.
 *
 * @param videoProvider The {@link android.telecom.RemoteConnection.VideoProvider RemoteConnection.VideoProvider} invoking this method.
 * @param videoProfile The requested video call profile.
 * @see android.telecom.InCallService.VideoCall.Callback#onSessionModifyRequestReceived(VideoProfile)
 * @see android.telecom.Connection.VideoProvider#receiveSessionModifyRequest(VideoProfile)
 * @apiSince 23
 */

public void onSessionModifyRequestReceived(android.telecom.RemoteConnection.VideoProvider videoProvider, android.telecom.VideoProfile videoProfile) { throw new RuntimeException("Stub!"); }

/**
 * Reports a session modification response received from the
 * {@link android.telecom.Connection.VideoProvider Connection.VideoProvider} associated with a {@link android.telecom.RemoteConnection RemoteConnection}.
 *
 * @param videoProvider The {@link android.telecom.RemoteConnection.VideoProvider RemoteConnection.VideoProvider} invoking this method.
 * @param status Status of the session modify request.
 * @param requestedProfile The original request which was sent to the peer device.
 * @param responseProfile The actual profile changes made by the peer device.
 * @see android.telecom.InCallService.VideoCall.Callback#onSessionModifyResponseReceived(int,
 *      VideoProfile, VideoProfile)
 * @see android.telecom.Connection.VideoProvider#receiveSessionModifyResponse(int, VideoProfile,
 *      VideoProfile)
 * @apiSince 23
 */

public void onSessionModifyResponseReceived(android.telecom.RemoteConnection.VideoProvider videoProvider, int status, android.telecom.VideoProfile requestedProfile, android.telecom.VideoProfile responseProfile) { throw new RuntimeException("Stub!"); }

/**
 * Reports a call session event received from the {@link android.telecom.Connection.VideoProvider Connection.VideoProvider}
 * associated with a {@link android.telecom.RemoteConnection RemoteConnection}.
 *
 * @param videoProvider The {@link android.telecom.RemoteConnection.VideoProvider RemoteConnection.VideoProvider} invoking this method.
 * @param event The event.
 * @see android.telecom.InCallService.VideoCall.Callback#onCallSessionEvent(int)
 * @see android.telecom.Connection.VideoProvider#handleCallSessionEvent(int)
 * @apiSince 23
 */

public void onCallSessionEvent(android.telecom.RemoteConnection.VideoProvider videoProvider, int event) { throw new RuntimeException("Stub!"); }

/**
 * Reports a change in the peer video dimensions received from the
 * {@link android.telecom.Connection.VideoProvider Connection.VideoProvider} associated with a {@link android.telecom.RemoteConnection RemoteConnection}.
 *
 * @param videoProvider The {@link android.telecom.RemoteConnection.VideoProvider RemoteConnection.VideoProvider} invoking this method.
 * @param width  The updated peer video width.
 * @param height The updated peer video height.
 * @see android.telecom.InCallService.VideoCall.Callback#onPeerDimensionsChanged(int, int)
 * @see android.telecom.Connection.VideoProvider#changePeerDimensions(int, int)
 * @apiSince 23
 */

public void onPeerDimensionsChanged(android.telecom.RemoteConnection.VideoProvider videoProvider, int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * Reports a change in the data usage (in bytes) received from the
 * {@link android.telecom.Connection.VideoProvider Connection.VideoProvider} associated with a {@link android.telecom.RemoteConnection RemoteConnection}.
 *
 * @param videoProvider The {@link android.telecom.RemoteConnection.VideoProvider RemoteConnection.VideoProvider} invoking this method.
 * @param dataUsage The updated data usage (in bytes).
 * @see android.telecom.InCallService.VideoCall.Callback#onCallDataUsageChanged(long)
 * @see android.telecom.Connection.VideoProvider#setCallDataUsage(long)
 * @apiSince 23
 */

public void onCallDataUsageChanged(android.telecom.RemoteConnection.VideoProvider videoProvider, long dataUsage) { throw new RuntimeException("Stub!"); }

/**
 * Reports a change in the capabilities of the current camera, received from the
 * {@link android.telecom.Connection.VideoProvider Connection.VideoProvider} associated with a {@link android.telecom.RemoteConnection RemoteConnection}.
 *
 * @param videoProvider The {@link android.telecom.RemoteConnection.VideoProvider RemoteConnection.VideoProvider} invoking this method.
 * @param cameraCapabilities The changed camera capabilities.
 * @see android.telecom.InCallService.VideoCall.Callback#onCameraCapabilitiesChanged(
 *      VideoProfile.CameraCapabilities)
 * @see android.telecom.Connection.VideoProvider#changeCameraCapabilities(
 *      VideoProfile.CameraCapabilities)
 * @apiSince 23
 */

public void onCameraCapabilitiesChanged(android.telecom.RemoteConnection.VideoProvider videoProvider, android.telecom.VideoProfile.CameraCapabilities cameraCapabilities) { throw new RuntimeException("Stub!"); }

/**
 * Reports a change in the video quality received from the
 * {@link android.telecom.Connection.VideoProvider Connection.VideoProvider} associated with a {@link android.telecom.RemoteConnection RemoteConnection}.
 *
 * @param videoProvider The {@link android.telecom.RemoteConnection.VideoProvider RemoteConnection.VideoProvider} invoking this method.
 * @param videoQuality  The updated peer video quality.
 * @see android.telecom.InCallService.VideoCall.Callback#onVideoQualityChanged(int)
 * @see android.telecom.Connection.VideoProvider#changeVideoQuality(int)
 * @apiSince 23
 */

public void onVideoQualityChanged(android.telecom.RemoteConnection.VideoProvider videoProvider, int videoQuality) { throw new RuntimeException("Stub!"); }
}

}

}

