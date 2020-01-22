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

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

/**
 * Provides APIs for SIP tasks, such as initiating SIP connections, and provides access to related
 * SIP services. This class is the starting point for any SIP actions. You can acquire an instance
 * of it with {@link #newInstance newInstance()}.</p>
 * <p>The APIs in this class allows you to:</p>
 * <ul>
 * <li>Create a {@link android.net.sip.SipSession SipSession} to get ready for making calls or listen for incoming calls. See
 * {@link #createSipSession createSipSession()} and {@link #getSessionFor getSessionFor()}.</li>
 * <li>Initiate and receive generic SIP calls or audio-only SIP calls. Generic SIP calls may
 * be video, audio, or other, and are initiated with {@link #open open()}. Audio-only SIP calls
 * should be handled with a {@link android.net.sip.SipAudioCall SipAudioCall}, which you can acquire with {@link
 * #makeAudioCall makeAudioCall()} and {@link #takeAudioCall takeAudioCall()}.</li>
 * <li>Register and unregister with a SIP service provider, with
 *      {@link #register register()} and {@link #unregister unregister()}.</li>
 * <li>Verify session connectivity, with {@link #isOpened isOpened()} and
 *      {@link #isRegistered isRegistered()}.</li>
 * </ul>
 * <p class="note"><strong>Note:</strong> Not all Android-powered devices support VOIP calls using
 * SIP. You should always call {@link android.net.sip.SipManager#isVoipSupported
 * isVoipSupported()} to verify that the device supports VOIP calling and {@link
 * android.net.sip.SipManager#isApiSupported isApiSupported()} to verify that the device supports
 * the SIP APIs. Your application must also request the {@link
 * android.Manifest.permission#INTERNET} and {@link android.Manifest.permission#USE_SIP}
 * permissions.</p>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about using SIP, read the
 * <a href="{@docRoot}guide/topics/network/sip.html">Session Initiation Protocol</a>
 * developer guide.</p>
 * </div>
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SipManager {

private SipManager() { throw new RuntimeException("Stub!"); }

/**
 * Creates a manager instance. Returns null if SIP API is not supported.
 *
 * @param context application context for creating the manager object
 * @return the manager instance or null if SIP API is not supported
 * @apiSince 9
 */

public static android.net.sip.SipManager newInstance(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the SIP API is supported by the system.
 * @apiSince 9
 */

public static boolean isApiSupported(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the system supports SIP-based VOIP API.
 * @apiSince 9
 */

public static boolean isVoipSupported(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if SIP is only available on WIFI.
 * @apiSince 9
 */

public static boolean isSipWifiOnly(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Opens the profile for making generic SIP calls. The caller may make subsequent calls
 * through {@link #makeAudioCall}. If one also wants to receive calls on the
 * profile, use
 * {@link #open(android.net.sip.SipProfile,android.app.PendingIntent,android.net.sip.SipRegistrationListener)}
 * instead.
 *
 * @param localProfile the SIP profile to make calls from
 * @throws android.net.sip.SipException if the profile contains incorrect settings or
 *      calling the SIP service results in an error
 * @apiSince 9
 */

public void open(android.net.sip.SipProfile localProfile) throws android.net.sip.SipException { throw new RuntimeException("Stub!"); }

/**
 * Opens the profile for making calls and/or receiving generic SIP calls. The caller may
 * make subsequent calls through {@link #makeAudioCall}. If the
 * auto-registration option is enabled in the profile, the SIP service
 * will register the profile to the corresponding SIP provider periodically
 * in order to receive calls from the provider. When the SIP service
 * receives a new call, it will send out an intent with the provided action
 * string. The intent contains a call ID extra and an offer session
 * description string extra. Use {@link #getCallId} and
 * {@link #getOfferSessionDescription} to retrieve those extras.
 *
 * @param localProfile the SIP profile to receive incoming calls for
 * @param incomingCallPendingIntent When an incoming call is received, the
 *      SIP service will call
 *      {@link android.app.PendingIntent#send(android.content.Context,int,android.content.Intent) PendingIntent#send(Context, int, Intent)} to send back the
 *      intent to the caller with {@link #INCOMING_CALL_RESULT_CODE} as the
 *      result code and the intent to fill in the call ID and session
 *      description information. It cannot be null.
 * @param listener to listen to registration events; can be null
 * @see #getCallId
 * @see #getOfferSessionDescription
 * @see #takeAudioCall
 * @throws java.lang.NullPointerException if {@code incomingCallPendingIntent} is null
 * @throws android.net.sip.SipException if the profile contains incorrect settings or
 *      calling the SIP service results in an error
 * @see #isIncomingCallIntent
 * @see #getCallId
 * @see #getOfferSessionDescription
 * @apiSince 9
 */

public void open(android.net.sip.SipProfile localProfile, android.app.PendingIntent incomingCallPendingIntent, android.net.sip.SipRegistrationListener listener) throws android.net.sip.SipException { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener to listen to registration events. No effect if the
 * profile has not been opened to receive calls (see
 * {@link #open(android.net.sip.SipProfile,android.app.PendingIntent,android.net.sip.SipRegistrationListener)}).
 *
 * @param localProfileUri the URI of the profile
 * @param listener to listen to registration events; can be null
 * @throws android.net.sip.SipException if calling the SIP service results in an error
 * @apiSince 9
 */

public void setRegistrationListener(java.lang.String localProfileUri, android.net.sip.SipRegistrationListener listener) throws android.net.sip.SipException { throw new RuntimeException("Stub!"); }

/**
 * Closes the specified profile to not make/receive calls. All the resources
 * that were allocated to the profile are also released.
 *
 * @param localProfileUri the URI of the profile to close
 * @throws android.net.sip.SipException if calling the SIP service results in an error
 * @apiSince 9
 */

public void close(java.lang.String localProfileUri) throws android.net.sip.SipException { throw new RuntimeException("Stub!"); }

/**
 * Checks if the specified profile is opened in the SIP service for
 * making and/or receiving calls.
 *
 * @param localProfileUri the URI of the profile in question
 * @return true if the profile is enabled to receive calls
 * @throws android.net.sip.SipException if calling the SIP service results in an error
 * @apiSince 9
 */

public boolean isOpened(java.lang.String localProfileUri) throws android.net.sip.SipException { throw new RuntimeException("Stub!"); }

/**
 * Checks if the SIP service has successfully registered the profile to the
 * SIP provider (specified in the profile) for receiving calls. Returning
 * true from this method also implies the profile is opened
 * ({@link #isOpened}).
 *
 * @param localProfileUri the URI of the profile in question
 * @return true if the profile is registered to the SIP provider; false if
 *        the profile has not been opened in the SIP service or the SIP
 *        service has not yet successfully registered the profile to the SIP
 *        provider
 * @throws android.net.sip.SipException if calling the SIP service results in an error
 * @apiSince 9
 */

public boolean isRegistered(java.lang.String localProfileUri) throws android.net.sip.SipException { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link android.net.sip.SipAudioCall SipAudioCall} to make a call. The attempt will be timed
 * out if the call is not established within {@code timeout} seconds and
 * {@link android.net.sip.SipAudioCall.Listener#onError SipAudioCall.Listener#onError}
 * will be called.
 *
 * @param localProfile the SIP profile to make the call from
 * @param peerProfile the SIP profile to make the call to
 * @param listener to listen to the call events from {@link android.net.sip.SipAudioCall SipAudioCall};
 *      can be null
 * @param timeout the timeout value in seconds. Default value (defined by
 *        SIP protocol) is used if {@code timeout} is zero or negative.
 * @return a {@link android.net.sip.SipAudioCall SipAudioCall} object
 * @throws android.net.sip.SipException if calling the SIP service results in an error or
 *      VOIP API is not supported by the device
 * @see android.net.sip.SipAudioCall.Listener#onError
 * @see #isVoipSupported
 * @apiSince 9
 */

public android.net.sip.SipAudioCall makeAudioCall(android.net.sip.SipProfile localProfile, android.net.sip.SipProfile peerProfile, android.net.sip.SipAudioCall.Listener listener, int timeout) throws android.net.sip.SipException { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link android.net.sip.SipAudioCall SipAudioCall} to make an audio call. The attempt will be
 * timed out if the call is not established within {@code timeout} seconds
 * and
 * {@link android.net.sip.SipAudioCall.Listener#onError SipAudioCall.Listener#onError}
 * will be called.
 *
 * @param localProfileUri URI of the SIP profile to make the call from
 * @param peerProfileUri URI of the SIP profile to make the call to
 * @param listener to listen to the call events from {@link android.net.sip.SipAudioCall SipAudioCall};
 *      can be null
 * @param timeout the timeout value in seconds. Default value (defined by
 *        SIP protocol) is used if {@code timeout} is zero or negative.
 * @return a {@link android.net.sip.SipAudioCall SipAudioCall} object
 * @throws android.net.sip.SipException if calling the SIP service results in an error or
 *      VOIP API is not supported by the device
 * @see android.net.sip.SipAudioCall.Listener#onError
 * @see #isVoipSupported
 * @apiSince 9
 */

public android.net.sip.SipAudioCall makeAudioCall(java.lang.String localProfileUri, java.lang.String peerProfileUri, android.net.sip.SipAudioCall.Listener listener, int timeout) throws android.net.sip.SipException { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link android.net.sip.SipAudioCall SipAudioCall} to take an incoming call. Before the call
 * is returned, the listener will receive a
 * {@link android.net.sip.SipAudioCall.Listener#onRinging SipAudioCall.Listener#onRinging}
 * callback.
 *
 * @param incomingCallIntent the incoming call broadcast intent
 * @param listener to listen to the call events from {@link android.net.sip.SipAudioCall SipAudioCall};
 *      can be null
 * @return a {@link android.net.sip.SipAudioCall SipAudioCall} object
 * @throws android.net.sip.SipException if calling the SIP service results in an error
 * @apiSince 9
 */

public android.net.sip.SipAudioCall takeAudioCall(android.content.Intent incomingCallIntent, android.net.sip.SipAudioCall.Listener listener) throws android.net.sip.SipException { throw new RuntimeException("Stub!"); }

/**
 * Checks if the intent is an incoming call broadcast intent.
 *
 * @param intent the intent in question
 * @return true if the intent is an incoming call broadcast intent
 * @apiSince 9
 */

public static boolean isIncomingCallIntent(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Gets the call ID from the specified incoming call broadcast intent.
 *
 * @param incomingCallIntent the incoming call broadcast intent
 * @return the call ID or null if the intent does not contain it
 * @apiSince 9
 */

public static java.lang.String getCallId(android.content.Intent incomingCallIntent) { throw new RuntimeException("Stub!"); }

/**
 * Gets the offer session description from the specified incoming call
 * broadcast intent.
 *
 * @param incomingCallIntent the incoming call broadcast intent
 * @return the offer session description or null if the intent does not
 *      have it
 * @apiSince 9
 */

public static java.lang.String getOfferSessionDescription(android.content.Intent incomingCallIntent) { throw new RuntimeException("Stub!"); }

/**
 * Manually registers the profile to the corresponding SIP provider for
 * receiving calls.
 * {@link #open(android.net.sip.SipProfile,android.app.PendingIntent,android.net.sip.SipRegistrationListener)} is
 * still needed to be called at least once in order for the SIP service to
 * notify the caller with the {@link android.app.PendingIntent} when an incoming call is
 * received.
 *
 * @param localProfile the SIP profile to register with
 * @param expiryTime registration expiration time (in seconds)
 * @param listener to listen to the registration events
 * @throws android.net.sip.SipException if calling the SIP service results in an error
 * @apiSince 9
 */

public void register(android.net.sip.SipProfile localProfile, int expiryTime, android.net.sip.SipRegistrationListener listener) throws android.net.sip.SipException { throw new RuntimeException("Stub!"); }

/**
 * Manually unregisters the profile from the corresponding SIP provider for
 * stop receiving further calls. This may interference with the auto
 * registration process in the SIP service if the auto-registration option
 * in the profile is enabled.
 *
 * @param localProfile the SIP profile to register with
 * @param listener to listen to the registration events
 * @throws android.net.sip.SipException if calling the SIP service results in an error
 * @apiSince 9
 */

public void unregister(android.net.sip.SipProfile localProfile, android.net.sip.SipRegistrationListener listener) throws android.net.sip.SipException { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@link android.net.sip.SipSession SipSession} that handles the incoming call. For audio
 * calls, consider to use {@link android.net.sip.SipAudioCall SipAudioCall} to handle the incoming call.
 * See {@link #takeAudioCall}. Note that the method may be called only once
 * for the same intent. For subsequent calls on the same intent, the method
 * returns null.
 *
 * @param incomingCallIntent the incoming call broadcast intent
 * @return the session object that handles the incoming call
 * @apiSince 9
 */

public android.net.sip.SipSession getSessionFor(android.content.Intent incomingCallIntent) throws android.net.sip.SipException { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link android.net.sip.SipSession SipSession} with the specified profile. Use other
 * methods, if applicable, instead of interacting with {@link android.net.sip.SipSession SipSession}
 * directly.
 *
 * @param localProfile the SIP profile the session is associated with
 * @param listener to listen to SIP session events
 * @apiSince 9
 */

public android.net.sip.SipSession createSipSession(android.net.sip.SipProfile localProfile, android.net.sip.SipSession.Listener listener) throws android.net.sip.SipException { throw new RuntimeException("Stub!"); }

/**
 * Key to retrieve the call ID from an incoming call intent.
 * @see #open(SipProfile, PendingIntent, SipRegistrationListener)
 * @apiSince 9
 */

public static final java.lang.String EXTRA_CALL_ID = "android:sipCallID";

/**
 * Key to retrieve the offered session description from an incoming call
 * intent.
 * @see #open(SipProfile, PendingIntent, SipRegistrationListener)
 * @apiSince 9
 */

public static final java.lang.String EXTRA_OFFER_SD = "android:sipOfferSD";

/**
 * The result code to be sent back with the incoming call
 * {@link android.app.PendingIntent PendingIntent}.
 * @see #open(SipProfile, PendingIntent, SipRegistrationListener)
 * @apiSince 9
 */

public static final int INCOMING_CALL_RESULT_CODE = 101; // 0x65
}

