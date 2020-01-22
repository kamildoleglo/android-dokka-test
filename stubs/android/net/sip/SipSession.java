/*
 * Copyright (C) 2010 The Android Open Source Project
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


package android.net.sip;


/**
 * Represents a SIP session that is associated with a SIP dialog or a standalone
 * transaction not within a dialog.
 * <p>You can get a {@link android.net.sip.SipSession SipSession} from {@link android.net.sip.SipManager SipManager} with {@link android.net.sip.SipManager#createSipSession SipManager#createSipSession} (when initiating calls) or {@link android.net.sip.SipManager#getSessionFor SipManager#getSessionFor} (when receiving calls).</p>
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SipSession {

SipSession() { throw new RuntimeException("Stub!"); }

/**
 * Gets the IP address of the local host on which this SIP session runs.
 *
 * @return the IP address of the local host
 * @apiSince 9
 */

public java.lang.String getLocalIp() { throw new RuntimeException("Stub!"); }

/**
 * Gets the SIP profile that this session is associated with.
 *
 * @return the SIP profile that this session is associated with
 * @apiSince 9
 */

public android.net.sip.SipProfile getLocalProfile() { throw new RuntimeException("Stub!"); }

/**
 * Gets the SIP profile that this session is connected to. Only available
 * when the session is associated with a SIP dialog.
 *
 * @return the SIP profile that this session is connected to
 * @apiSince 9
 */

public android.net.sip.SipProfile getPeerProfile() { throw new RuntimeException("Stub!"); }

/**
 * Gets the session state. The value returned must be one of the states in
 * {@link android.net.sip.SipSession.State State}.
 *
 * @return the session state
 * @apiSince 9
 */

public int getState() { throw new RuntimeException("Stub!"); }

/**
 * Checks if the session is in a call.
 *
 * @return true if the session is in a call
 * @apiSince 9
 */

public boolean isInCall() { throw new RuntimeException("Stub!"); }

/**
 * Gets the call ID of the session.
 *
 * @return the call ID
 * @apiSince 9
 */

public java.lang.String getCallId() { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener to listen to the session events. A {@code SipSession}
 * can only hold one listener at a time. Subsequent calls to this method
 * override the previous listener.
 *
 * @param listener to listen to the session events of this object
 * @apiSince 9
 */

public void setListener(android.net.sip.SipSession.Listener listener) { throw new RuntimeException("Stub!"); }

/**
 * Performs registration to the server specified by the associated local
 * profile. The session listener is called back upon success or failure of
 * registration. The method is only valid to call when the session state is
 * in {@link android.net.sip.SipSession.State#READY_TO_CALL State#READY_TO_CALL}.
 *
 * @param duration duration in second before the registration expires
 * @see android.net.sip.SipSession.Listener
 * @apiSince 9
 */

public void register(int duration) { throw new RuntimeException("Stub!"); }

/**
 * Performs unregistration to the server specified by the associated local
 * profile. Unregistration is technically the same as registration with zero
 * expiration duration. The session listener is called back upon success or
 * failure of unregistration. The method is only valid to call when the
 * session state is in {@link android.net.sip.SipSession.State#READY_TO_CALL State#READY_TO_CALL}.
 *
 * @see android.net.sip.SipSession.Listener
 * @apiSince 9
 */

public void unregister() { throw new RuntimeException("Stub!"); }

/**
 * Initiates a call to the specified profile. The session listener is called
 * back upon defined session events. The method is only valid to call when
 * the session state is in {@link android.net.sip.SipSession.State#READY_TO_CALL State#READY_TO_CALL}.
 *
 * @param callee the SIP profile to make the call to
 * @param sessionDescription the session description of this call
 * @param timeout the session will be timed out if the call is not
 *        established within {@code timeout} seconds. Default value (defined
 *        by SIP protocol) is used if {@code timeout} is zero or negative.
 * @see android.net.sip.SipSession.Listener
 * @apiSince 9
 */

public void makeCall(android.net.sip.SipProfile callee, java.lang.String sessionDescription, int timeout) { throw new RuntimeException("Stub!"); }

/**
 * Answers an incoming call with the specified session description. The
 * method is only valid to call when the session state is in
 * {@link android.net.sip.SipSession.State#INCOMING_CALL State#INCOMING_CALL}.
 *
 * @param sessionDescription the session description to answer this call
 * @param timeout the session will be timed out if the call is not
 *        established within {@code timeout} seconds. Default value (defined
 *        by SIP protocol) is used if {@code timeout} is zero or negative.
 * @apiSince 9
 */

public void answerCall(java.lang.String sessionDescription, int timeout) { throw new RuntimeException("Stub!"); }

/**
 * Ends an established call, terminates an outgoing call or rejects an
 * incoming call. The method is only valid to call when the session state is
 * in {@link android.net.sip.SipSession.State#IN_CALL State#IN_CALL},
 * {@link android.net.sip.SipSession.State#INCOMING_CALL State#INCOMING_CALL},
 * {@link android.net.sip.SipSession.State#OUTGOING_CALL State#OUTGOING_CALL} or
 * {@link android.net.sip.SipSession.State#OUTGOING_CALL_RING_BACK State#OUTGOING_CALL_RING_BACK}.
 * @apiSince 9
 */

public void endCall() { throw new RuntimeException("Stub!"); }

/**
 * Changes the session description during a call. The method is only valid
 * to call when the session state is in {@link android.net.sip.SipSession.State#IN_CALL State#IN_CALL}.
 *
 * @param sessionDescription the new session description
 * @param timeout the session will be timed out if the call is not
 *        established within {@code timeout} seconds. Default value (defined
 *        by SIP protocol) is used if {@code timeout} is zero or negative.
 * @apiSince 9
 */

public void changeCall(java.lang.String sessionDescription, int timeout) { throw new RuntimeException("Stub!"); }
/**
 * Listener for events relating to a SIP session, such as when a session is being registered
 * ("on registering") or a call is outgoing ("on calling").
 * <p>Many of these events are also received by {@link android.net.sip.SipAudioCall.Listener SipAudioCall.Listener}.</p>
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Listener {

public Listener() { throw new RuntimeException("Stub!"); }

/**
 * Called when an INVITE request is sent to initiate a new call.
 *
 * @param session the session object that carries out the transaction
 * @apiSince 9
 */

public void onCalling(android.net.sip.SipSession session) { throw new RuntimeException("Stub!"); }

/**
 * Called when an INVITE request is received.
 *
 * @param session the session object that carries out the transaction
 * @param caller the SIP profile of the caller
 * @param sessionDescription the caller's session description
 * @apiSince 9
 */

public void onRinging(android.net.sip.SipSession session, android.net.sip.SipProfile caller, java.lang.String sessionDescription) { throw new RuntimeException("Stub!"); }

/**
 * Called when a RINGING response is received for the INVITE request sent
 *
 * @param session the session object that carries out the transaction
 * @apiSince 9
 */

public void onRingingBack(android.net.sip.SipSession session) { throw new RuntimeException("Stub!"); }

/**
 * Called when the session is established.
 *
 * @param session the session object that is associated with the dialog
 * @param sessionDescription the peer's session description
 * @apiSince 9
 */

public void onCallEstablished(android.net.sip.SipSession session, java.lang.String sessionDescription) { throw new RuntimeException("Stub!"); }

/**
 * Called when the session is terminated.
 *
 * @param session the session object that is associated with the dialog
 * @apiSince 9
 */

public void onCallEnded(android.net.sip.SipSession session) { throw new RuntimeException("Stub!"); }

/**
 * Called when the peer is busy during session initialization.
 *
 * @param session the session object that carries out the transaction
 * @apiSince 9
 */

public void onCallBusy(android.net.sip.SipSession session) { throw new RuntimeException("Stub!"); }

/**
 * Called when an error occurs during session initialization and
 * termination.
 *
 * @param session the session object that carries out the transaction
 * @param errorCode error code defined in {@link android.net.sip.SipErrorCode SipErrorCode}
 * @param errorMessage error message
 * @apiSince 9
 */

public void onError(android.net.sip.SipSession session, int errorCode, java.lang.String errorMessage) { throw new RuntimeException("Stub!"); }

/**
 * Called when an error occurs during session modification negotiation.
 *
 * @param session the session object that carries out the transaction
 * @param errorCode error code defined in {@link android.net.sip.SipErrorCode SipErrorCode}
 * @param errorMessage error message
 * @apiSince 9
 */

public void onCallChangeFailed(android.net.sip.SipSession session, int errorCode, java.lang.String errorMessage) { throw new RuntimeException("Stub!"); }

/**
 * Called when a registration request is sent.
 *
 * @param session the session object that carries out the transaction
 * @apiSince 9
 */

public void onRegistering(android.net.sip.SipSession session) { throw new RuntimeException("Stub!"); }

/**
 * Called when registration is successfully done.
 *
 * @param session the session object that carries out the transaction
 * @param duration duration in second before the registration expires
 * @apiSince 9
 */

public void onRegistrationDone(android.net.sip.SipSession session, int duration) { throw new RuntimeException("Stub!"); }

/**
 * Called when the registration fails.
 *
 * @param session the session object that carries out the transaction
 * @param errorCode error code defined in {@link android.net.sip.SipErrorCode SipErrorCode}
 * @param errorMessage error message
 * @apiSince 9
 */

public void onRegistrationFailed(android.net.sip.SipSession session, int errorCode, java.lang.String errorMessage) { throw new RuntimeException("Stub!"); }

/**
 * Called when the registration gets timed out.
 *
 * @param session the session object that carries out the transaction
 * @apiSince 9
 */

public void onRegistrationTimeout(android.net.sip.SipSession session) { throw new RuntimeException("Stub!"); }
}

/**
 * Defines SIP session states, such as "registering", "outgoing call", and "in call".
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class State {

private State() { throw new RuntimeException("Stub!"); }

/**
 * Converts the state to string.
 * @apiSince 9
 */

public static java.lang.String toString(int state) { throw new RuntimeException("Stub!"); }

/**
 * When the unregistration request is sent out.
 * @apiSince 9
 */

public static final int DEREGISTERING = 2; // 0x2

/**
 * When an INVITE request is received.
 * @apiSince 9
 */

public static final int INCOMING_CALL = 3; // 0x3

/**
 * When an OK response is sent for the INVITE request received.
 * @apiSince 9
 */

public static final int INCOMING_CALL_ANSWERING = 4; // 0x4

/**
 * When a call is established.
 * @apiSince 9
 */

public static final int IN_CALL = 8; // 0x8

/**
 * Not defined.
 * @apiSince 9
 */

public static final int NOT_DEFINED = 101; // 0x65

/**
 * When an INVITE request is sent.
 * @apiSince 9
 */

public static final int OUTGOING_CALL = 5; // 0x5

/**
 * When a CANCEL request is sent for the INVITE request sent.
 * @apiSince 9
 */

public static final int OUTGOING_CALL_CANCELING = 7; // 0x7

/**
 * When a RINGING response is received for the INVITE request sent.
 * @apiSince 9
 */

public static final int OUTGOING_CALL_RING_BACK = 6; // 0x6

/**
 * When an OPTIONS request is sent.
 * @apiSince 9
 */

public static final int PINGING = 9; // 0x9

/**
 * When session is ready to initiate a call or transaction.
 * @apiSince 9
 */

public static final int READY_TO_CALL = 0; // 0x0

/**
 * When the registration request is sent out.
 * @apiSince 9
 */

public static final int REGISTERING = 1; // 0x1
}

}

