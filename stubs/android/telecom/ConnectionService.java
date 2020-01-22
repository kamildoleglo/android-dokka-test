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

import android.os.Bundle;
import android.net.Uri;
import android.content.Intent;

/**
 * An abstract service that should be implemented by any apps which either:
 * <ol>
 *     <li>Can make phone calls (VoIP or otherwise) and want those calls to be integrated into the
 *     built-in phone app.  Referred to as a <b>system managed</b> {@link android.telecom.ConnectionService ConnectionService}.</li>
 *     <li>Are a standalone calling app and don't want their calls to be integrated into the
 *     built-in phone app.  Referred to as a <b>self managed</b> {@link android.telecom.ConnectionService ConnectionService}.</li>
 * </ol>
 * Once implemented, the {@link android.telecom.ConnectionService ConnectionService} needs to take the following steps so that Telecom
 * will bind to it:
 * <p>
 * 1. <i>Registration in AndroidManifest.xml</i>
 * <br/>
 * <pre>
 * &lt;service android:name="com.example.package.MyConnectionService"
 *    android:label="@string/some_label_for_my_connection_service"
 *    android:permission="android.permission.BIND_TELECOM_CONNECTION_SERVICE"&gt;
 *  &lt;intent-filter&gt;
 *   &lt;action android:name="android.telecom.ConnectionService" /&gt;
 *  &lt;/intent-filter&gt;
 * &lt;/service&gt;
 * </pre>
 * <p>
 * 2. <i> Registration of {@link android.telecom.PhoneAccount PhoneAccount} with {@link android.telecom.TelecomManager TelecomManager}.</i>
 * <br/>
 * See {@link android.telecom.PhoneAccount PhoneAccount} and {@link android.telecom.TelecomManager#registerPhoneAccount TelecomManager#registerPhoneAccount} for more information.
 * <p>
 * System managed {@link android.telecom.ConnectionService ConnectionService}s must be enabled by the user in the phone app settings
 * before Telecom will bind to them.  Self-managed {@link android.telecom.ConnectionService ConnectionService}s must be granted the
 * appropriate permission before Telecom will bind to them.
 * <p>
 * Once registered and enabled by the user in the phone app settings or granted permission, telecom
 * will bind to a {@link android.telecom.ConnectionService ConnectionService} implementation when it wants that
 * {@link android.telecom.ConnectionService ConnectionService} to place a call or the service has indicated that is has an incoming
 * call through {@link android.telecom.TelecomManager#addNewIncomingCall TelecomManager#addNewIncomingCall}. The {@link android.telecom.ConnectionService ConnectionService} can then
 * expect a call to {@link #onCreateIncomingConnection} or {@link #onCreateOutgoingConnection}
 * wherein it should provide a new instance of a {@link android.telecom.Connection Connection} object.  It is through this
 * {@link android.telecom.Connection Connection} object that telecom receives state updates and the {@link android.telecom.ConnectionService ConnectionService}
 * receives call-commands such as answer, reject, hold and disconnect.
 * <p>
 * When there are no more live calls, telecom will unbind from the {@link android.telecom.ConnectionService ConnectionService}.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class ConnectionService extends android.app.Service {

public ConnectionService() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 23
 */

public final android.os.IBinder onBind(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 23
 */

public boolean onUnbind(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Ask some other {@code ConnectionService} to create a {@code RemoteConnection} given an
 * incoming request. This is used by {@code ConnectionService}s that are registered with
 * {@link android.telecom.PhoneAccount#CAPABILITY_CONNECTION_MANAGER PhoneAccount#CAPABILITY_CONNECTION_MANAGER} and want to be able to manage
 * SIM-based incoming calls.
 *
 * @param connectionManagerPhoneAccount See description at
 *         {@link #onCreateOutgoingConnection(android.telecom.PhoneAccountHandle,android.telecom.ConnectionRequest)}.
 * @param request Details about the incoming call.
 * @return The {@code Connection} object to satisfy this call, or {@code null} to
 *         not handle the call.
 * @apiSince 23
 */

public final android.telecom.RemoteConnection createRemoteIncomingConnection(android.telecom.PhoneAccountHandle connectionManagerPhoneAccount, android.telecom.ConnectionRequest request) { throw new RuntimeException("Stub!"); }

/**
 * Ask some other {@code ConnectionService} to create a {@code RemoteConnection} given an
 * outgoing request. This is used by {@code ConnectionService}s that are registered with
 * {@link android.telecom.PhoneAccount#CAPABILITY_CONNECTION_MANAGER PhoneAccount#CAPABILITY_CONNECTION_MANAGER} and want to be able to use the
 * SIM-based {@code ConnectionService} to place its outgoing calls.
 *
 * @param connectionManagerPhoneAccount See description at
 *         {@link #onCreateOutgoingConnection(android.telecom.PhoneAccountHandle,android.telecom.ConnectionRequest)}.
 * @param request Details about the outgoing call.
 * @return The {@code Connection} object to satisfy this call, or {@code null} to
 *         not handle the call.
 * @apiSince 23
 */

public final android.telecom.RemoteConnection createRemoteOutgoingConnection(android.telecom.PhoneAccountHandle connectionManagerPhoneAccount, android.telecom.ConnectionRequest request) { throw new RuntimeException("Stub!"); }

/**
 * Indicates to the relevant {@code RemoteConnectionService} that the specified
 * {@link android.telecom.RemoteConnection RemoteConnection}s should be merged into a conference call.
 * <p>
 * If the conference request is successful, the method {@link #onRemoteConferenceAdded} will
 * be invoked.
 *
 * @param remoteConnection1 The first of the remote connections to conference.
 * @param remoteConnection2 The second of the remote connections to conference.
 * @apiSince 23
 */

public final void conferenceRemoteConnections(android.telecom.RemoteConnection remoteConnection1, android.telecom.RemoteConnection remoteConnection2) { throw new RuntimeException("Stub!"); }

/**
 * Adds a new conference call. When a conference call is created either as a result of an
 * explicit request via {@link #onConference} or otherwise, the connection service should supply
 * an instance of {@link android.telecom.Conference Conference} by invoking this method. A conference call provided by this
 * method will persist until {@link android.telecom.Conference#destroy Conference#destroy} is invoked on the conference instance.
 *
 * @param conference The new conference object.
 * @apiSince 23
 */

public final void addConference(android.telecom.Conference conference) { throw new RuntimeException("Stub!"); }

/**
 * Adds a connection created by the {@link android.telecom.ConnectionService ConnectionService} and informs telecom of the new
 * connection.
 *
 * @param phoneAccountHandle The phone account handle for the connection.
 * @param connection The connection to add.
 * @apiSince 23
 */

public final void addExistingConnection(android.telecom.PhoneAccountHandle phoneAccountHandle, android.telecom.Connection connection) { throw new RuntimeException("Stub!"); }

/**
 * Call to inform Telecom that your {@link android.telecom.ConnectionService ConnectionService} has released call resources (e.g
 * microphone, camera).
 *
 * <p>
 * The {@link android.telecom.ConnectionService ConnectionService} will be disconnected when it failed to call this method within
 * 5 seconds after {@link #onConnectionServiceFocusLost()} is called.
 *
 * @see android.telecom.ConnectionService#onConnectionServiceFocusLost()
 * @apiSince 28
 */

public final void connectionServiceFocusReleased() { throw new RuntimeException("Stub!"); }

/**
 * Returns all the active {@code Connection}s for which this {@code ConnectionService}
 * has taken responsibility.
 *
 * @return A collection of {@code Connection}s created by this {@code ConnectionService}.
 * @apiSince 23
 */

public final java.util.Collection<android.telecom.Connection> getAllConnections() { throw new RuntimeException("Stub!"); }

/**
 * Returns all the active {@code Conference}s for which this {@code ConnectionService}
 * has taken responsibility.
 *
 * @return A collection of {@code Conference}s created by this {@code ConnectionService}.
 * @apiSince 24
 */

public final java.util.Collection<android.telecom.Conference> getAllConferences() { throw new RuntimeException("Stub!"); }

/**
 * Create a {@code Connection} given an incoming request. This is used to attach to existing
 * incoming calls.
 *
 * @param connectionManagerPhoneAccount See description at
 *         {@link #onCreateOutgoingConnection(android.telecom.PhoneAccountHandle,android.telecom.ConnectionRequest)}.
 * @param request Details about the incoming call.
 * @return The {@code Connection} object to satisfy this call, or {@code null} to
 *         not handle the call.
 * @apiSince 23
 */

public android.telecom.Connection onCreateIncomingConnection(android.telecom.PhoneAccountHandle connectionManagerPhoneAccount, android.telecom.ConnectionRequest request) { throw new RuntimeException("Stub!"); }

/**
 * Called by Telecom to inform the {@link android.telecom.ConnectionService ConnectionService} that its request to create a new
 * incoming {@link android.telecom.Connection Connection} was denied.
 * <p>
 * Used when a self-managed {@link android.telecom.ConnectionService ConnectionService} attempts to create a new incoming
 * {@link android.telecom.Connection Connection}, but Telecom has determined that the call cannot be allowed at this time.
 * The {@link android.telecom.ConnectionService ConnectionService} is responsible for silently rejecting the new incoming
 * {@link android.telecom.Connection Connection}.
 * <p>
 * See {@link android.telecom.TelecomManager#isIncomingCallPermitted(android.telecom.PhoneAccountHandle) TelecomManager#isIncomingCallPermitted(PhoneAccountHandle)} for more information.
 *
 * @param connectionManagerPhoneAccount See description at
 *         {@link #onCreateOutgoingConnection(android.telecom.PhoneAccountHandle,android.telecom.ConnectionRequest)}.
 * @param request The incoming connection request.
 * @apiSince 26
 */

public void onCreateIncomingConnectionFailed(android.telecom.PhoneAccountHandle connectionManagerPhoneAccount, android.telecom.ConnectionRequest request) { throw new RuntimeException("Stub!"); }

/**
 * Called by Telecom to inform the {@link android.telecom.ConnectionService ConnectionService} that its request to create a new
 * outgoing {@link android.telecom.Connection Connection} was denied.
 * <p>
 * Used when a self-managed {@link android.telecom.ConnectionService ConnectionService} attempts to create a new outgoing
 * {@link android.telecom.Connection Connection}, but Telecom has determined that the call cannot be placed at this time.
 * The {@link android.telecom.ConnectionService ConnectionService} is responisible for informing the user that the
 * {@link android.telecom.Connection Connection} cannot be made at this time.
 * <p>
 * See {@link android.telecom.TelecomManager#isOutgoingCallPermitted(android.telecom.PhoneAccountHandle) TelecomManager#isOutgoingCallPermitted(PhoneAccountHandle)} for more information.
 *
 * @param connectionManagerPhoneAccount See description at
 *         {@link #onCreateOutgoingConnection(android.telecom.PhoneAccountHandle,android.telecom.ConnectionRequest)}.
 * @param request The outgoing connection request.
 * @apiSince 26
 */

public void onCreateOutgoingConnectionFailed(android.telecom.PhoneAccountHandle connectionManagerPhoneAccount, android.telecom.ConnectionRequest request) { throw new RuntimeException("Stub!"); }

/**
 * Create a {@code Connection} given an outgoing request. This is used to initiate new
 * outgoing calls.
 *
 * @param connectionManagerPhoneAccount The connection manager account to use for managing
 *         this call.
 *         <p>
 *         If this parameter is not {@code null}, it means that this {@code ConnectionService}
 *         has registered one or more {@code PhoneAccount}s having
 *         {@link android.telecom.PhoneAccount#CAPABILITY_CONNECTION_MANAGER PhoneAccount#CAPABILITY_CONNECTION_MANAGER}. This parameter will contain
 *         one of these {@code PhoneAccount}s, while the {@code request} will contain another
 *         (usually but not always distinct) {@code PhoneAccount} to be used for actually
 *         making the connection.
 *         <p>
 *         If this parameter is {@code null}, it means that this {@code ConnectionService} is
 *         being asked to make a direct connection. The
 *         {@link android.telecom.ConnectionRequest#getAccountHandle() ConnectionRequest#getAccountHandle()} of parameter {@code request} will be
 *         a {@code PhoneAccount} registered by this {@code ConnectionService} to use for
 *         making the connection.
 * @param request Details about the outgoing call.
 * @return The {@code Connection} object to satisfy this call, or the result of an invocation
 *         of {@link android.telecom.Connection#createFailedConnection(android.telecom.DisconnectCause) Connection#createFailedConnection(DisconnectCause)} to not handle the call.
 * @apiSince 23
 */

public android.telecom.Connection onCreateOutgoingConnection(android.telecom.PhoneAccountHandle connectionManagerPhoneAccount, android.telecom.ConnectionRequest request) { throw new RuntimeException("Stub!"); }

/**
 * Called by Telecom to request that a {@link android.telecom.ConnectionService ConnectionService} creates an instance of an
 * outgoing handover {@link android.telecom.Connection Connection}.
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
 * This method is called on the destination {@link android.telecom.ConnectionService ConnectionService} on <em>initiating</em>
 * device when the user initiates a handover request from one app to another.  The user request
 * originates in the {@link android.telecom.InCallService InCallService} via
 * {@link android.telecom.Call#handoverTo(PhoneAccountHandle, int, Bundle)}.
 * <p>
 * For a full discussion of the handover process and the APIs involved, see
 * {@link android.telecom.Call#handoverTo(PhoneAccountHandle, int, Bundle)}.
 * <p>
 * Implementations of this method should return an instance of {@link android.telecom.Connection Connection} which
 * represents the handover.  If your app does not wish to accept a handover to it at this time,
 * you can return {@code null}.  The code below shows an example of how this is done.
 * <pre>
 * {@code
 * public Connection onCreateIncomingHandoverConnection(PhoneAccountHandle
 *     fromPhoneAccountHandle, ConnectionRequest request) {
 *   if (!isHandoverAvailable()) {
 *       return null;
 *   }
 *   MyConnection connection = new MyConnection();
 *   connection.setAddress(request.getAddress(), TelecomManager.PRESENTATION_ALLOWED);
 *   connection.setVideoState(request.getVideoState());
 *   return connection;
 * }
 * }
 * </pre>
 *
 * @param fromPhoneAccountHandle {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} associated with the
 *                               ConnectionService which needs to handover the call.
 * @param request Details about the call to handover.
 * @return {@link android.telecom.Connection Connection} instance corresponding to the handover call.
 * @apiSince 28
 */

public android.telecom.Connection onCreateOutgoingHandoverConnection(android.telecom.PhoneAccountHandle fromPhoneAccountHandle, android.telecom.ConnectionRequest request) { throw new RuntimeException("Stub!"); }

/**
 * Called by Telecom to request that a {@link android.telecom.ConnectionService ConnectionService} creates an instance of an
 * incoming handover {@link android.telecom.Connection Connection}.
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
 * This method is called on the destination app on the <em>receiving</em> device when the
 * destination app calls {@link android.telecom.TelecomManager#acceptHandover(android.net.Uri,int,android.telecom.PhoneAccountHandle) TelecomManager#acceptHandover(Uri, int, PhoneAccountHandle)} to
 * accept an incoming handover from the <em>initiating</em> device.
 * <p>
 * For a full discussion of the handover process and the APIs involved, see
 * {@link android.telecom.Call#handoverTo(PhoneAccountHandle, int, Bundle)}.
 * <p>
 * Implementations of this method should return an instance of {@link android.telecom.Connection Connection} which
 * represents the handover.  The code below shows an example of how this is done.
 * <pre>
 * {@code
 * public Connection onCreateIncomingHandoverConnection(PhoneAccountHandle
 *     fromPhoneAccountHandle, ConnectionRequest request) {
 *   // Given that your app requested to accept the handover, you should not return null here.
 *   MyConnection connection = new MyConnection();
 *   connection.setAddress(request.getAddress(), TelecomManager.PRESENTATION_ALLOWED);
 *   connection.setVideoState(request.getVideoState());
 *   return connection;
 * }
 * }
 * </pre>
 *
 * @param fromPhoneAccountHandle {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} associated with the
 *                               ConnectionService which needs to handover the call.
 * @param request Details about the call which needs to be handover.
 * @return {@link android.telecom.Connection Connection} instance corresponding to the handover call.
 * @apiSince 28
 */

public android.telecom.Connection onCreateIncomingHandoverConnection(android.telecom.PhoneAccountHandle fromPhoneAccountHandle, android.telecom.ConnectionRequest request) { throw new RuntimeException("Stub!"); }

/**
 * Called by Telecom in response to a {@code TelecomManager#acceptHandover()}
 * invocation which failed.
 * <p>
 * For a full discussion of the handover process and the APIs involved, see
 * {@link android.telecom.Call#handoverTo(PhoneAccountHandle, int, Bundle)}
 *
 * @param request Details about the call which failed to handover.
 * @param error Reason for handover failure.  Will be one of the
 
 * Value is {@link android.telecom.Call.Callback#HANDOVER_FAILURE_DEST_APP_REJECTED}, {@link android.telecom.Call.Callback#HANDOVER_FAILURE_NOT_SUPPORTED}, {@link android.telecom.Call.Callback#HANDOVER_FAILURE_USER_REJECTED}, {@link android.telecom.Call.Callback#HANDOVER_FAILURE_ONGOING_EMERGENCY_CALL}, or {@link android.telecom.Call.Callback#HANDOVER_FAILURE_UNKNOWN}
 * @apiSince 28
 */

public void onHandoverFailed(android.telecom.ConnectionRequest request, int error) { throw new RuntimeException("Stub!"); }

/**
 * Conference two specified connections. Invoked when the user has made a request to merge the
 * specified connections into a conference call. In response, the connection service should
 * create an instance of {@link android.telecom.Conference Conference} and pass it into {@link #addConference}.
 *
 * @param connection1 A connection to merge into a conference call.
 * @param connection2 A connection to merge into a conference call.
 * @apiSince 23
 */

public void onConference(android.telecom.Connection connection1, android.telecom.Connection connection2) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that a remote conference has been created for existing {@link android.telecom.RemoteConnection RemoteConnection}s.
 * When this method is invoked, this {@link android.telecom.ConnectionService ConnectionService} should create its own
 * representation of the conference call and send it to telecom using {@link #addConference}.
 * <p>
 * This is only relevant to {@link android.telecom.ConnectionService ConnectionService}s which are registered with
 * {@link android.telecom.PhoneAccount#CAPABILITY_CONNECTION_MANAGER PhoneAccount#CAPABILITY_CONNECTION_MANAGER}.
 *
 * @param conference The remote conference call.
 * @apiSince 23
 */

public void onRemoteConferenceAdded(android.telecom.RemoteConference conference) { throw new RuntimeException("Stub!"); }

/**
 * Called when an existing connection is added remotely.
 * @param connection The existing connection which was added.
 * @apiSince 23
 */

public void onRemoteExistingConnectionAdded(android.telecom.RemoteConnection connection) { throw new RuntimeException("Stub!"); }

/**
 * Called when the {@link android.telecom.ConnectionService ConnectionService} has lost the call focus.
 * The {@link android.telecom.ConnectionService ConnectionService} should release the call resources and invokes
 * {@link android.telecom.ConnectionService#connectionServiceFocusReleased() ConnectionService#connectionServiceFocusReleased()} to inform telecom that it has
 * released the call resources.
 * @apiSince 28
 */

public void onConnectionServiceFocusLost() { throw new RuntimeException("Stub!"); }

/**
 * Called when the {@link android.telecom.ConnectionService ConnectionService} has gained the call focus. The
 * {@link android.telecom.ConnectionService ConnectionService} can acquire the call resources at this time.
 * @apiSince 28
 */

public void onConnectionServiceFocusGained() { throw new RuntimeException("Stub!"); }

/**
 * The {@link android.content.Intent Intent} that must be declared as handled by the service.
 * @apiSince 23
 */

public static final java.lang.String SERVICE_INTERFACE = "android.telecom.ConnectionService";
}

