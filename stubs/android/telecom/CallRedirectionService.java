/*
 * Copyright (C) 2018 The Android Open Source Project
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
 * limitations under the License
 */


package android.telecom;

import android.net.Uri;
import android.content.Intent;

/**
 * This service can be implemented to interact between Telecom and its implementor
 * for making outgoing call with optional redirection/cancellation purposes.
 *
 * <p>
 * Below is an example manifest registration for a {@code CallRedirectionService}.
 * <pre>
 * {@code
 * <service android:name="your.package.YourCallRedirectionServiceImplementation"
 *          android:permission="android.permission.BIND_REDIRECTION_SERVICE">
 *      <intent-filter>
 *          <action android:name="android.telecom.CallRedirectionService"/>
 *      </intent-filter>
 * </service>
 * }
 * </pre>
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class CallRedirectionService extends android.app.Service {

public CallRedirectionService() { throw new RuntimeException("Stub!"); }

/**
 * Telecom calls this method once upon binding to a {@link android.telecom.CallRedirectionService CallRedirectionService} to inform
 * it of a new outgoing call which is being placed. Telecom does not request to redirect
 * emergency calls and does not request to redirect calls with gateway information.
 *
 * <p>Telecom will cancel the call if Telecom does not receive a response in 5 seconds from
 * the implemented {@link android.telecom.CallRedirectionService CallRedirectionService} set by users.
 *
 * <p>The implemented {@link android.telecom.CallRedirectionService CallRedirectionService} can call {@link #placeCallUnmodified()},
 * {@link #redirectCall(android.net.Uri,android.telecom.PhoneAccountHandle,boolean)}, and {@link #cancelCall()} only
 * from here. Calls to these methods are assumed by the Telecom framework to be the response
 * for the phone call for which {@link #onPlaceCall(android.net.Uri,android.telecom.PhoneAccountHandle,boolean)} was
 * invoked by Telecom. The Telecom framework will only invoke
 * {@link #onPlaceCall(android.net.Uri,android.telecom.PhoneAccountHandle,boolean)} once each time it binds to a
 * {@link android.telecom.CallRedirectionService CallRedirectionService}.
 *
 * @param handle the phone number dialed by the user, represented in E.164 format if possible
 * This value must never be {@code null}.
 * @param initialPhoneAccount the {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} on which the call will be placed.
 * This value must never be {@code null}.
 * @param allowInteractiveResponse a boolean to tell if the implemented
 *                                 {@link android.telecom.CallRedirectionService CallRedirectionService} should allow interactive
 *                                 responses with users. Will be {@code false} if, for example
 *                                 the device is in car mode and the user would not be able to
 *                                 interact with their device.
 * @apiSince 29
 */

public abstract void onPlaceCall(@androidx.annotation.NonNull android.net.Uri handle, @androidx.annotation.NonNull android.telecom.PhoneAccountHandle initialPhoneAccount, boolean allowInteractiveResponse);

/**
 * The implemented {@link android.telecom.CallRedirectionService CallRedirectionService} calls this method to response a request
 * received via {@link #onPlaceCall(android.net.Uri,android.telecom.PhoneAccountHandle,boolean)} to inform Telecom that
 * no changes are required to the outgoing call, and that the call should be placed as-is.
 *
 * <p>This can only be called from implemented
 * {@link #onPlaceCall(android.net.Uri,android.telecom.PhoneAccountHandle,boolean)}. The response corresponds to the
 * latest request via {@link #onPlaceCall(android.net.Uri,android.telecom.PhoneAccountHandle,boolean)}.
 *
 * @apiSince 29
 */

public final void placeCallUnmodified() { throw new RuntimeException("Stub!"); }

/**
 * The implemented {@link android.telecom.CallRedirectionService CallRedirectionService} calls this method to response a request
 * received via {@link #onPlaceCall(android.net.Uri,android.telecom.PhoneAccountHandle,boolean)} to inform Telecom that
 * changes are required to the phone number or/and {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} for the outgoing
 * call. Telecom will cancel the call if the implemented {@link android.telecom.CallRedirectionService CallRedirectionService}
 * replies Telecom a handle for an emergency number.
 *
 * <p>This can only be called from implemented
 * {@link #onPlaceCall(android.net.Uri,android.telecom.PhoneAccountHandle,boolean)}. The response corresponds to the
 * latest request via {@link #onPlaceCall(android.net.Uri,android.telecom.PhoneAccountHandle,boolean)}.
 *
 * @param gatewayUri the gateway uri for call redirection.
 * This value must never be {@code null}.
 * @param targetPhoneAccount the {@link android.telecom.PhoneAccountHandle PhoneAccountHandle} to use when placing the call.
 * This value must never be {@code null}.
 * @param confirmFirst Telecom will ask users to confirm the redirection via a yes/no dialog
 *                     if the confirmFirst is true, and if the redirection request of this
 *                     response was sent with a true flag of allowInteractiveResponse via
 *                     {@link #onPlaceCall(android.net.Uri,android.telecom.PhoneAccountHandle,boolean)}
 * @apiSince 29
 */

public final void redirectCall(@androidx.annotation.NonNull android.net.Uri gatewayUri, @androidx.annotation.NonNull android.telecom.PhoneAccountHandle targetPhoneAccount, boolean confirmFirst) { throw new RuntimeException("Stub!"); }

/**
 * The implemented {@link android.telecom.CallRedirectionService CallRedirectionService} calls this method to response a request
 * received via {@link #onPlaceCall(android.net.Uri,android.telecom.PhoneAccountHandle,boolean)} to inform Telecom that
 * an outgoing call should be canceled entirely.
 *
 * <p>This can only be called from implemented
 * {@link #onPlaceCall(android.net.Uri,android.telecom.PhoneAccountHandle,boolean)}. The response corresponds to the
 * latest request via {@link #onPlaceCall(android.net.Uri,android.telecom.PhoneAccountHandle,boolean)}.
 *
 * @apiSince 29
 */

public final void cancelCall() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param intent This value must never be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public final android.os.IBinder onBind(@androidx.annotation.NonNull android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param intent This value must never be {@code null}.
 * @apiSince 29
 */

public final boolean onUnbind(@androidx.annotation.NonNull android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * The {@link android.content.Intent Intent} that must be declared as handled by the service.
 * @apiSince 29
 */

public static final java.lang.String SERVICE_INTERFACE = "android.telecom.CallRedirectionService";
}

