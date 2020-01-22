/*
 * Copyright (C) 2016 The Android Open Source Project
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

import android.content.Intent;
import android.net.Uri;

/**
 * This service can be implemented by the default dialer (see
 * {@link android.telecom.TelecomManager#getDefaultDialerPackage() TelecomManager#getDefaultDialerPackage()}) or a third party app to allow or disallow
 * incoming calls before they are shown to a user. A {@link android.telecom.CallScreeningService CallScreeningService} can also see
 * outgoing calls for the purpose of providing caller ID services for those calls.
 * <p>
 * Below is an example manifest registration for a {@code CallScreeningService}.
 * <pre>
 * {@code
 * <service android:name="your.package.YourCallScreeningServiceImplementation"
 *          android:permission="android.permission.BIND_SCREENING_SERVICE">
 *      <intent-filter>
 *          <action android:name="android.telecom.CallScreeningService"/>
 *      </intent-filter>
 * </service>
 * }
 * </pre>
 * <p>
 * A CallScreeningService performs two functions:
 * <ol>
 *     <li>Call blocking/screening - the service can choose which calls will ring on the user's
 *     device, and which will be silently sent to voicemail.</li>
 *     <li>Call identification - services which provide call identification functionality can
 *     display a user-interface of their choosing which contains identifying information for a call.
 *     </li>
 * </ol>
 * <p>
 * <h2>Becoming the {@link android.telecom.CallScreeningService CallScreeningService}</h2>
 * Telecom will bind to a single app chosen by the user which implements the
 * {@link android.telecom.CallScreeningService CallScreeningService} API when there are new incoming and outgoing calls.
 * <p>
 * The code snippet below illustrates how your app can request that it fills the call screening
 * role.
 * <pre>
 * {@code
 * private static final int REQUEST_ID = 1;
 *
 * public void requestRole() {
 *     RoleManager roleManager = (RoleManager) getSystemService(ROLE_SERVICE);
 *     Intent intent = roleManager.createRequestRoleIntent(RoleManager.ROLE_CALL_SCREENING);
 *     startActivityForResult(intent, REQUEST_ID);
 * }
 *
 * &#64;Override
 * public void onActivityResult(int requestCode, int resultCode, Intent data) {
 *     if (requestCode == REQUEST_ID) {
 *         if (resultCode == android.app.Activity.RESULT_OK) {
 *             // Your app is now the call screening app
 *         } else {
 *             // Your app is not the call screening app
 *         }
 *     }
 * }
 * </pre>
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class CallScreeningService extends android.app.Service {

/** @apiSince 24 */

public CallScreeningService() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public android.os.IBinder onBind(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public boolean onUnbind(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Called when a new incoming or outgoing call is added which is not in the user's contact list.
 * <p>
 * A {@link android.telecom.CallScreeningService CallScreeningService} must indicate whether an incoming call is allowed or not by
 * calling
 * {@link android.telecom.CallScreeningService#respondToCall(android.telecom.Call.Details,android.telecom.CallScreeningService.CallResponse) CallScreeningService#respondToCall(Call.Details, CallScreeningService.CallResponse)}.
 * Your app can tell if a call is an incoming call by checking to see if
 * {@link android.telecom.Call.Details#getCallDirection() Call.Details#getCallDirection()} is {@link android.telecom.Call.Details#DIRECTION_INCOMING Call.Details#DIRECTION_INCOMING}.
 * <p>
 * Note: The {@link android.telecom.Call.Details Call.Details} instance provided to a call screening service will only have
 * the following properties set.  The rest of the {@link android.telecom.Call.Details Call.Details} properties will be set to
 * their default value or {@code null}.
 * <ul>
 *     <li>{@link android.telecom.Call.Details#getCallDirection() Call.Details#getCallDirection()}</li>
 *     <li>{@link android.telecom.Call.Details#getConnectTimeMillis() Call.Details#getConnectTimeMillis()}</li>
 *     <li>{@link android.telecom.Call.Details#getCreationTimeMillis() Call.Details#getCreationTimeMillis()}</li>
 *     <li>{@link android.telecom.Call.Details#getHandle() Call.Details#getHandle()}</li>
 *     <li>{@link android.telecom.Call.Details#getHandlePresentation() Call.Details#getHandlePresentation()}</li>
 * </ul>
 * <p>
 * Only calls where the {@link android.telecom.Call.Details#getHandle() Call.Details#getHandle()} {@link android.net.Uri#getScheme() Uri#getScheme()}
 * is {@link android.telecom.PhoneAccount#SCHEME_TEL PhoneAccount#SCHEME_TEL} are passed for call
 * screening.  Further, only calls which are not in the user's contacts are passed for
 * screening.  For outgoing calls, no post-dial digits are passed.
 *
 * @param callDetails Information about a new call, see {@link android.telecom.Call.Details Call.Details}.
 
 * This value must never be {@code null}.
 * @apiSince 24
 */

public abstract void onScreenCall(@androidx.annotation.NonNull android.telecom.Call.Details callDetails);

/**
 * Responds to the given incoming call, either allowing it, silencing it or disallowing it.
 * <p>
 * The {@link android.telecom.CallScreeningService CallScreeningService} calls this method to inform the system whether the call
 * should be silently blocked or not. In the event that it should not be blocked, it may
 * also be requested to ring silently.
 * <p>
 * Calls to this method are ignored unless the {@link android.telecom.Call.Details#getCallDirection() Call.Details#getCallDirection()} is
 * {@link android.telecom.Call.Details#DIRECTION_INCOMING Call.Details#DIRECTION_INCOMING}.
 *
 * @param callDetails The call to allow.
 *                    <p>
 *                    Must be the same {@link android.telecom.Call.Details Call.Details} which was provided to the
 *                    {@link android.telecom.CallScreeningService CallScreeningService} via {@link #onScreenCall(android.telecom.Call.Details)}.
 * This value must never be {@code null}.
 * @param response The {@link android.telecom.CallScreeningService.CallResponse CallScreeningService.CallResponse} which contains information
 * about how to respond to a call.
 
 * This value must never be {@code null}.
 * @apiSince 24
 */

public final void respondToCall(@androidx.annotation.NonNull android.telecom.Call.Details callDetails, @androidx.annotation.NonNull android.telecom.CallScreeningService.CallResponse response) { throw new RuntimeException("Stub!"); }

/**
 * The {@link android.content.Intent Intent} that must be declared as handled by the service.
 * @apiSince 24
 */

public static final java.lang.String SERVICE_INTERFACE = "android.telecom.CallScreeningService";
/** @apiSince 24 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class CallResponse {

private CallResponse() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public boolean getDisallowCall() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public boolean getRejectCall() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public boolean getSilenceCall() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public boolean getSkipCallLog() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public boolean getSkipNotification() { throw new RuntimeException("Stub!"); }
/** @apiSince 24 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the incoming call should be blocked.
 * @apiSince 24
 */

public android.telecom.CallScreeningService.CallResponse.Builder setDisallowCall(boolean shouldDisallowCall) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the incoming call should be disconnected as if the user had manually
 * rejected it. This property should only be set to true if the call is disallowed.
 * @apiSince 24
 */

public android.telecom.CallScreeningService.CallResponse.Builder setRejectCall(boolean shouldRejectCall) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether ringing should be silenced for the incoming call.  When set
 * to {@code true}, the Telecom framework will not play a ringtone for the call.
 * The call will, however, still be sent to the default dialer app if it is not blocked.
 * A {@link android.telecom.CallScreeningService CallScreeningService} can use this to ensure a potential nuisance call is
 * still surfaced to the user, but in a less intrusive manner.
 *
 * Setting this to true only makes sense when the call has not been disallowed
 * using {@link #setDisallowCall(boolean)}.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.telecom.CallScreeningService.CallResponse.Builder setSilenceCall(boolean shouldSilenceCall) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the incoming call should not be displayed in the call log. This property
 * should only be set to true if the call is disallowed.
 * <p>
 * Note: Calls will still be logged with type
 * {@link android.provider.CallLog.Calls#BLOCKED_TYPE}, regardless of how this property
 * is set.
 * @apiSince 24
 */

public android.telecom.CallScreeningService.CallResponse.Builder setSkipCallLog(boolean shouldSkipCallLog) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether a missed call notification should not be shown for the incoming call.
 * This property should only be set to true if the call is disallowed.
 * @apiSince 24
 */

public android.telecom.CallScreeningService.CallResponse.Builder setSkipNotification(boolean shouldSkipNotification) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public android.telecom.CallScreeningService.CallResponse build() { throw new RuntimeException("Stub!"); }
}

}

}

