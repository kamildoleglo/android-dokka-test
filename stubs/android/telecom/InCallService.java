/*
 * Copyright (C) 2013 The Android Open Source Project
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

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.hardware.camera2.CameraManager;
import android.view.Surface;

/**
 * This service is implemented by an app that wishes to provide functionality for managing
 * phone calls.
 * <h2>Becoming the Default Phone App</h2>
 * The default dialer/phone app is one which provides the in-call user interface while the device is
 * in a call.  A device is bundled with a system provided default dialer/phone app.  The user may
 * choose a single app to take over this role from the system app.  An app which wishes to fulfill
 * one this role uses the {@code android.app.role.RoleManager} to request that they fill the role.
 * <p>
 * An app filling the role of the default phone app provides a user interface while the device is in
 * a call, and the device is not in car mode.
 * <p>
 * Below is an example manifest registration for an {@code InCallService}. The meta-data
 * {@link android.telecom.TelecomManager#METADATA_IN_CALL_SERVICE_UI TelecomManager#METADATA_IN_CALL_SERVICE_UI} indicates that this particular
 * {@code InCallService} implementation intends to replace the built-in in-call UI.
 * The meta-data {@link android.telecom.TelecomManager#METADATA_IN_CALL_SERVICE_RINGING TelecomManager#METADATA_IN_CALL_SERVICE_RINGING} indicates that this
 * {@link android.telecom.InCallService InCallService} will play the ringtone for incoming calls.  See
 * <a href="#incomingCallNotification">below</a> for more information on showing the incoming call
 * UI and playing the ringtone in your app.
 * <pre>
 * {@code
 * <service android:name="your.package.YourInCallServiceImplementation"
 *          android:permission="android.permission.BIND_INCALL_SERVICE">
 *      <meta-data android:name="android.telecom.IN_CALL_SERVICE_UI" android:value="true" />
 *      <meta-data android:name="android.telecom.IN_CALL_SERVICE_RINGING"
 *          android:value="true" />
 *      <intent-filter>
 *          <action android:name="android.telecom.InCallService"/>
 *      </intent-filter>
 * </service>
 * }
 * </pre>
 * <p>
 * In addition to implementing the {@link android.telecom.InCallService InCallService} API, you must also declare an activity in
 * your manifest which handles the {@link android.content.Intent#ACTION_DIAL Intent#ACTION_DIAL} intent.  The example below illustrates
 * how this is done:
 * <pre>
 * {@code
 * <activity android:name="your.package.YourDialerActivity"
 *           android:label="@string/yourDialerActivityLabel">
 *      <intent-filter>
 *           <action android:name="android.intent.action.DIAL" />
 *           <category android:name="android.intent.category.DEFAULT" />
 *      </intent-filter>
 * </activity>
 * }
 * </pre>
 * <p>
 * When a user installs your application and runs it for the first time, you should use the
 * {@link android.app.role.RoleManager} to prompt the user to see if they would like your app to
 * be the new default phone app.
 * <p id="requestRole">
 * The code below shows how your app can request to become the default phone/dialer app:
 * <pre>
 * {@code
 * private static final int REQUEST_ID = 1;
 *
 * public void requestRole() {
 *     RoleManager roleManager = (RoleManager) getSystemService(ROLE_SERVICE);
 *     Intent intent = roleManager.createRequestRoleIntent(RoleManager.ROLE_DIALER);
 *     startActivityForResult(intent, REQUEST_ID);
 * }
 *
 * &#64;Override
 * public void onActivityResult(int requestCode, int resultCode, Intent data) {
 *     if (requestCode == REQUEST_ID) {
 *         if (resultCode == android.app.Activity.RESULT_OK) {
 *             // Your app is now the default dialer app
 *         } else {
 *             // Your app is not the default dialer app
 *         }
 *     }
 * }
 * </pre>
 * <p id="incomingCallNotification">
 * <h3>Showing the Incoming Call Notification</h3>
 * When your app receives a new incoming call via {@link InCallService#onCallAdded(Call)}, it is
 * responsible for displaying an incoming call UI for the incoming call.  It should do this using
 * {@link android.app.NotificationManager} APIs to post a new incoming call notification.
 * <p>
 * Where your app declares the meta-data {@link TelecomManager#METADATA_IN_CALL_SERVICE_RINGING}, it
 * is responsible for playing the ringtone for incoming calls.  Your app should create a
 * {@link android.app.NotificationChannel} which specifies the desired ringtone.  For example:
 * <pre><code>
 * NotificationChannel channel = new NotificationChannel(YOUR_CHANNEL_ID, "Incoming Calls",
 *          NotificationManager.IMPORTANCE_MAX);
 * // other channel setup stuff goes here.
 *
 * // We'll use the default system ringtone for our incoming call notification channel.  You can
 * // use your own audio resource here.
 * Uri ringtoneUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
 * channel.setSound(ringtoneUri, new AudioAttributes.Builder()
 *          // Setting the AudioAttributes is important as it identifies the purpose of your
 *          // notification sound.
 *          .setUsage(AudioAttributes.USAGE_NOTIFICATION_RINGTONE)
 *          .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
 *      .build());
 *
 * NotificationManager mgr = getSystemService(NotificationManager.class);
 * mgr.createNotificationChannel(channel);
 * </code></pre>
 * <p>
 * When your app receives a new incoming call, it creates a {@link android.app.Notification} for the
 * incoming call and associates it with your incoming call notification channel. You can specify a
 * {@link android.app.PendingIntent} on the notification which will launch your full screen
 * incoming call UI.  The notification manager framework will display your notification as a
 * heads-up notification if the user is actively using the phone.  When the user is not using the
 * phone, your full-screen incoming call UI is used instead.
 * For example:
 * <pre><code>{@code
 * // Create an intent which triggers your fullscreen incoming call user interface.
 * Intent intent = new Intent(Intent.ACTION_MAIN, null);
 * intent.setFlags(Intent.FLAG_ACTIVITY_NO_USER_ACTION | Intent.FLAG_ACTIVITY_NEW_TASK);
 * intent.setClass(context, YourIncomingCallActivity.class);
 * PendingIntent pendingIntent = PendingIntent.getActivity(context, 1, intent, 0);
 *
 * // Build the notification as an ongoing high priority item; this ensures it will show as
 * // a heads up notification which slides down over top of the current content.
 * final Notification.Builder builder = new Notification.Builder(context);
 * builder.setOngoing(true);
 * builder.setPriority(Notification.PRIORITY_HIGH);
 *
 * // Set notification content intent to take user to the fullscreen UI if user taps on the
 * // notification body.
 * builder.setContentIntent(pendingIntent);
 * // Set full screen intent to trigger display of the fullscreen UI when the notification
 * // manager deems it appropriate.
 * builder.setFullScreenIntent(pendingIntent, true);
 *
 * // Setup notification content.
 * builder.setSmallIcon( yourIconResourceId );
 * builder.setContentTitle("Your notification title");
 * builder.setContentText("Your notification content.");
 *
 * // Use builder.addAction(..) to add buttons to answer or reject the call.
 *
 * NotificationManager notificationManager = mContext.getSystemService(
 *     NotificationManager.class);
 * notificationManager.notify(YOUR_CHANNEL_ID, YOUR_TAG, YOUR_ID, builder.build());
 * }</pre>
 * <p>
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class InCallService extends android.app.Service {

/** @apiSince 23 */

public InCallService() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public android.os.IBinder onBind(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public boolean onUnbind(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Obtains the current list of {@code Call}s to be displayed by this in-call service.
 *
 * @return A list of the relevant {@code Call}s.
 * @apiSince 23
 */

public final java.util.List<android.telecom.Call> getCalls() { throw new RuntimeException("Stub!"); }

/**
 * Returns if the device can support additional calls.
 *
 * @return Whether the phone supports adding more calls.
 * @apiSince 23
 */

public final boolean canAddCall() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the current phone call audio state.
 *
 * @return An object encapsulating the audio state. Returns null if the service is not
 *         fully initialized.
 * @apiSince 23
 */

public final android.telecom.CallAudioState getCallAudioState() { throw new RuntimeException("Stub!"); }

/**
 * Sets the microphone mute state. When this request is honored, there will be change to
 * the {@link #getCallAudioState()}.
 *
 * @param state {@code true} if the microphone should be muted; {@code false} otherwise.
 * @apiSince 23
 */

public final void setMuted(boolean state) { throw new RuntimeException("Stub!"); }

/**
 * Sets the audio route (speaker, bluetooth, etc...).  When this request is honored, there will
 * be change to the {@link #getCallAudioState()}.
 *
 * @param route The audio route to use.
 * @apiSince 23
 */

public final void setAudioRoute(int route) { throw new RuntimeException("Stub!"); }

/**
 * Request audio routing to a specific bluetooth device. Calling this method may result in
 * the device routing audio to a different bluetooth device than the one specified if the
 * bluetooth stack is unable to route audio to the requested device.
 * A list of available devices can be obtained via
 * {@link android.telecom.CallAudioState#getSupportedBluetoothDevices() CallAudioState#getSupportedBluetoothDevices()}
 *
 * @param bluetoothDevice The bluetooth device to connect to.
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public final void requestBluetoothAudio(@androidx.annotation.NonNull android.bluetooth.BluetoothDevice bluetoothDevice) { throw new RuntimeException("Stub!"); }

/**
 * Called when the audio state changes.
 *
 * @param audioState The new {@link android.telecom.CallAudioState CallAudioState}.
 * @apiSince 23
 */

public void onCallAudioStateChanged(android.telecom.CallAudioState audioState) { throw new RuntimeException("Stub!"); }

/**
 * Called to bring the in-call screen to the foreground. The in-call experience should
 * respond immediately by coming to the foreground to inform the user of the state of
 * ongoing {@code Call}s.
 *
 * @param showDialpad If true, put up the dialpad when the screen is shown.
 * @apiSince 23
 */

public void onBringToForeground(boolean showDialpad) { throw new RuntimeException("Stub!"); }

/**
 * Called when a {@code Call} has been added to this in-call session. The in-call user
 * experience should add necessary state listeners to the specified {@code Call} and
 * immediately start to show the user information about the existence
 * and nature of this {@code Call}. Subsequent invocations of {@link #getCalls()} will
 * include this {@code Call}.
 *
 * @param call A newly added {@code Call}.
 * @apiSince 23
 */

public void onCallAdded(android.telecom.Call call) { throw new RuntimeException("Stub!"); }

/**
 * Called when a {@code Call} has been removed from this in-call session. The in-call user
 * experience should remove any state listeners from the specified {@code Call} and
 * immediately stop displaying any information about this {@code Call}.
 * Subsequent invocations of {@link #getCalls()} will no longer include this {@code Call}.
 *
 * @param call A newly removed {@code Call}.
 * @apiSince 23
 */

public void onCallRemoved(android.telecom.Call call) { throw new RuntimeException("Stub!"); }

/**
 * Called when the ability to add more calls changes.  If the phone cannot
 * support more calls then {@code canAddCall} is set to {@code false}.  If it can, then it
 * is set to {@code true}. This can be used to control the visibility of UI to add more calls.
 *
 * @param canAddCall Indicates whether an additional call can be added.
 * @apiSince 23
 */

public void onCanAddCallChanged(boolean canAddCall) { throw new RuntimeException("Stub!"); }

/**
 * Called to silence the ringer if a ringing call exists.
 * @apiSince 24
 */

public void onSilenceRinger() { throw new RuntimeException("Stub!"); }

/**
 * Unused; to handle connection events issued by a {@link android.telecom.ConnectionService ConnectionService}, implement the
 * {@link android.telecom.Call.Callback#onConnectionEvent(Call, String, Bundle)} callback.
 * <p>
 * See {@link android.telecom.Connection#sendConnectionEvent(java.lang.String,android.os.Bundle) Connection#sendConnectionEvent(String, Bundle)}.
 *
 * @param call The call the event is associated with.
 * @param event The event.
 * @param extras Any associated extras.
 * @apiSince 25
 */

public void onConnectionEvent(android.telecom.Call call, java.lang.String event, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * The {@link android.content.Intent Intent} that must be declared as handled by the service.
 * @apiSince 23
 */

public static final java.lang.String SERVICE_INTERFACE = "android.telecom.InCallService";
/**
 * Used to issue commands to the {@link android.telecom.Connection.VideoProvider Connection.VideoProvider} associated with a
 * {@link android.telecom.Call Call}.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class VideoCall {

public VideoCall() { throw new RuntimeException("Stub!"); }

/**
 * Registers a callback to receive commands and state changes for video calls.
 *
 * @param callback The video call callback.
 * @apiSince 23
 */

public abstract void registerCallback(android.telecom.InCallService.VideoCall.Callback callback);

/**
 * Registers a callback to receive commands and state changes for video calls.
 *
 * @param callback The video call callback.
 * @param handler A handler which commands and status changes will be delivered to.
 * @apiSince 23
 */

public abstract void registerCallback(android.telecom.InCallService.VideoCall.Callback callback, android.os.Handler handler);

/**
 * Clears the video call callback set via {@link #registerCallback}.
 *
 * @param callback The video call callback to clear.
 * @apiSince 23
 */

public abstract void unregisterCallback(android.telecom.InCallService.VideoCall.Callback callback);

/**
 * Sets the camera to be used for the outgoing video.
 * <p>
 * Handled by {@link android.telecom.Connection.VideoProvider#onSetCamera(java.lang.String) Connection.VideoProvider#onSetCamera(String)}.
 *
 * @param cameraId The id of the camera (use ids as reported by
 * {@link android.hardware.camera2.CameraManager#getCameraIdList() CameraManager#getCameraIdList()}).
 * @apiSince 23
 */

public abstract void setCamera(java.lang.String cameraId);

/**
 * Sets the surface to be used for displaying a preview of what the user's camera is
 * currently capturing.  When video transmission is enabled, this is the video signal which
 * is sent to the remote device.
 * <p>
 * Handled by {@link android.telecom.Connection.VideoProvider#onSetPreviewSurface(android.view.Surface) Connection.VideoProvider#onSetPreviewSurface(Surface)}.
 *
 * @param surface The {@link android.view.Surface Surface}.
 * @apiSince 23
 */

public abstract void setPreviewSurface(android.view.Surface surface);

/**
 * Sets the surface to be used for displaying the video received from the remote device.
 * <p>
 * Handled by {@link android.telecom.Connection.VideoProvider#onSetDisplaySurface(android.view.Surface) Connection.VideoProvider#onSetDisplaySurface(Surface)}.
 *
 * @param surface The {@link android.view.Surface Surface}.
 * @apiSince 23
 */

public abstract void setDisplaySurface(android.view.Surface surface);

/**
 * Sets the device orientation, in degrees.  Assumes that a standard portrait orientation of
 * the device is 0 degrees.
 * <p>
 * Handled by {@link android.telecom.Connection.VideoProvider#onSetDeviceOrientation(int) Connection.VideoProvider#onSetDeviceOrientation(int)}.
 *
 * @param rotation The device orientation, in degrees.
 * @apiSince 23
 */

public abstract void setDeviceOrientation(int rotation);

/**
 * Sets camera zoom ratio.
 * <p>
 * Handled by {@link android.telecom.Connection.VideoProvider#onSetZoom(float) Connection.VideoProvider#onSetZoom(float)}.
 *
 * @param value The camera zoom ratio.
 * @apiSince 23
 */

public abstract void setZoom(float value);

/**
 * Issues a request to modify the properties of the current video session.
 * <p>
 * Example scenarios include: requesting an audio-only call to be upgraded to a
 * bi-directional video call, turning on or off the user's camera, sending a pause signal
 * when the {@link android.telecom.InCallService InCallService} is no longer the foreground application.
 * <p>
 * Handled by
 * {@link android.telecom.Connection.VideoProvider#onSendSessionModifyRequest(android.telecom.VideoProfile,android.telecom.VideoProfile) Connection.VideoProvider#onSendSessionModifyRequest(VideoProfile, VideoProfile)}.
 *
 * @param requestProfile The requested call video properties.
 * @apiSince 23
 */

public abstract void sendSessionModifyRequest(android.telecom.VideoProfile requestProfile);

/**
 * Provides a response to a request to change the current call video session
 * properties.  This should be called in response to a request the {@link android.telecom.InCallService InCallService} has
 * received via {@link VideoCall.Callback#onSessionModifyRequestReceived}.
 * <p>
 * Handled by
 * {@link android.telecom.Connection.VideoProvider#onSendSessionModifyResponse(android.telecom.VideoProfile) Connection.VideoProvider#onSendSessionModifyResponse(VideoProfile)}.
 *
 * @param responseProfile The response call video properties.
 * @apiSince 23
 */

public abstract void sendSessionModifyResponse(android.telecom.VideoProfile responseProfile);

/**
 * Issues a request to the {@link android.telecom.Connection.VideoProvider Connection.VideoProvider} to retrieve the capabilities
 * of the current camera.  The current camera is selected using
 * {@link android.telecom.InCallService.VideoCall#setCamera(java.lang.String) VideoCall#setCamera(String)}.
 * <p>
 * Camera capabilities are reported to the caller via
 * {@link VideoCall.Callback#onCameraCapabilitiesChanged(VideoProfile.CameraCapabilities)}.
 * <p>
 * Handled by {@link android.telecom.Connection.VideoProvider#onRequestCameraCapabilities() Connection.VideoProvider#onRequestCameraCapabilities()}.
 * @apiSince 23
 */

public abstract void requestCameraCapabilities();

/**
 * Issues a request to the {@link android.telecom.Connection.VideoProvider Connection.VideoProvider} to retrieve the cumulative data
 * usage for the video component of the current call (in bytes).  Data usage is reported
 * to the caller via {@link VideoCall.Callback#onCallDataUsageChanged}.
 * <p>
 * Handled by {@link android.telecom.Connection.VideoProvider#onRequestConnectionDataUsage() Connection.VideoProvider#onRequestConnectionDataUsage()}.
 * @apiSince 23
 */

public abstract void requestCallDataUsage();

/**
 * Provides the {@link android.telecom.Connection.VideoProvider Connection.VideoProvider} with the {@link android.net.Uri Uri} of an image to be
 * displayed to the peer device when the video signal is paused.
 * <p>
 * Handled by {@link android.telecom.Connection.VideoProvider#onSetPauseImage(android.net.Uri) Connection.VideoProvider#onSetPauseImage(Uri)}.
 *
 * @param uri URI of image to display.
 * @apiSince 23
 */

public abstract void setPauseImage(android.net.Uri uri);
/**
 * The {@link android.telecom.InCallService InCallService} extends this class to provide a means of receiving callbacks
 * from the {@link android.telecom.Connection.VideoProvider Connection.VideoProvider}.
 * <p>
 * When the {@link android.telecom.InCallService InCallService} receives the
 * {@link android.telecom.Call.Callback#onVideoCallChanged(android.telecom.Call,android.telecom.InCallService.VideoCall) Call.Callback#onVideoCallChanged(Call, VideoCall)} callback, it should create an
 * instance its {@link android.telecom.InCallService.VideoCall.Callback VideoCall.Callback} implementation and set it on the
 * {@link android.telecom.InCallService.VideoCall VideoCall} using {@link android.telecom.InCallService.VideoCall#registerCallback(android.telecom.InCallService.VideoCall.Callback) VideoCall#registerCallback(Callback)}.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class Callback {

public Callback() { throw new RuntimeException("Stub!"); }

/**
 * Called when the {@link android.telecom.Connection.VideoProvider Connection.VideoProvider} receives a session modification
 * request from the peer device.
 * <p>
 * The {@link android.telecom.InCallService InCallService} may potentially prompt the user to confirm whether they
 * wish to accept the request, or decide to automatically accept the request.  In either
 * case the {@link android.telecom.InCallService InCallService} should call
 * {@link android.telecom.InCallService.VideoCall#sendSessionModifyResponse(android.telecom.VideoProfile) VideoCall#sendSessionModifyResponse(VideoProfile)} to indicate the video
 * profile agreed upon.
 * <p>
 * Callback originates from
 * {@link android.telecom.Connection.VideoProvider#receiveSessionModifyRequest(android.telecom.VideoProfile) Connection.VideoProvider#receiveSessionModifyRequest(VideoProfile)}.
 *
 * @param videoProfile The requested video profile.
 * @apiSince 23
 */

public abstract void onSessionModifyRequestReceived(android.telecom.VideoProfile videoProfile);

/**
 * Called when the {@link android.telecom.Connection.VideoProvider Connection.VideoProvider} receives a response to a session
 * modification request previously sent to the peer device.
 * <p>
 * The new video state should not be considered active by the {@link android.telecom.InCallService InCallService}
 * until the {@link android.telecom.Call Call} video state changes (the
 * {@link android.telecom.Call.Callback#onDetailsChanged(android.telecom.Call,android.telecom.Call.Details) Call.Callback#onDetailsChanged(Call, Call.Details)} callback is triggered
 * when the video state changes).
 * <p>
 * Callback originates from
 * {@link android.telecom.Connection.VideoProvider#receiveSessionModifyResponse(int,android.telecom.VideoProfile,android.telecom.VideoProfile) Connection.VideoProvider#receiveSessionModifyResponse(int, VideoProfile,
 *      VideoProfile)}.
 *
 * @param status Status of the session modify request.  Valid values are
 *      {@link android.telecom.Connection.VideoProvider#SESSION_MODIFY_REQUEST_SUCCESS Connection.VideoProvider#SESSION_MODIFY_REQUEST_SUCCESS},
 *      {@link android.telecom.Connection.VideoProvider#SESSION_MODIFY_REQUEST_FAIL Connection.VideoProvider#SESSION_MODIFY_REQUEST_FAIL},
 *      {@link android.telecom.Connection.VideoProvider#SESSION_MODIFY_REQUEST_INVALID Connection.VideoProvider#SESSION_MODIFY_REQUEST_INVALID},
 *      {@link android.telecom.Connection.VideoProvider#SESSION_MODIFY_REQUEST_TIMED_OUT Connection.VideoProvider#SESSION_MODIFY_REQUEST_TIMED_OUT},
 *      {@link android.telecom.Connection.VideoProvider#SESSION_MODIFY_REQUEST_REJECTED_BY_REMOTE Connection.VideoProvider#SESSION_MODIFY_REQUEST_REJECTED_BY_REMOTE}.
 * @param requestedProfile The original request which was sent to the peer device.
 * @param responseProfile The actual profile changes made by the peer device.
 * @apiSince 23
 */

public abstract void onSessionModifyResponseReceived(int status, android.telecom.VideoProfile requestedProfile, android.telecom.VideoProfile responseProfile);

/**
 * Handles events related to the current video session which the {@link android.telecom.InCallService InCallService}
 * may wish to handle. These are separate from requested changes to the session due to
 * the underlying protocol or connection.
 * <p>
 * Callback originates from
 * {@link android.telecom.Connection.VideoProvider#handleCallSessionEvent(int) Connection.VideoProvider#handleCallSessionEvent(int)}.
 *
 * @param event The event.  Valid values are:
 *      {@link android.telecom.Connection.VideoProvider#SESSION_EVENT_RX_PAUSE Connection.VideoProvider#SESSION_EVENT_RX_PAUSE},
 *      {@link android.telecom.Connection.VideoProvider#SESSION_EVENT_RX_RESUME Connection.VideoProvider#SESSION_EVENT_RX_RESUME},
 *      {@link android.telecom.Connection.VideoProvider#SESSION_EVENT_TX_START Connection.VideoProvider#SESSION_EVENT_TX_START},
 *      {@link android.telecom.Connection.VideoProvider#SESSION_EVENT_TX_STOP Connection.VideoProvider#SESSION_EVENT_TX_STOP},
 *      {@link android.telecom.Connection.VideoProvider#SESSION_EVENT_CAMERA_FAILURE Connection.VideoProvider#SESSION_EVENT_CAMERA_FAILURE},
 *      {@link android.telecom.Connection.VideoProvider#SESSION_EVENT_CAMERA_READY Connection.VideoProvider#SESSION_EVENT_CAMERA_READY},
 *      {@link android.telecom.Connection.VideoProvider#SESSION_EVENT_CAMERA_PERMISSION_ERROR Connection.VideoProvider#SESSION_EVENT_CAMERA_PERMISSION_ERROR}.
 * @apiSince 23
 */

public abstract void onCallSessionEvent(int event);

/**
 * Handles a change to the video dimensions from the peer device. This could happen if,
 * for example, the peer changes orientation of their device, or switches cameras.
 * <p>
 * Callback originates from
 * {@link android.telecom.Connection.VideoProvider#changePeerDimensions(int,int) Connection.VideoProvider#changePeerDimensions(int, int)}.
 *
 * @param width  The updated peer video width.
 * @param height The updated peer video height.
 * @apiSince 23
 */

public abstract void onPeerDimensionsChanged(int width, int height);

/**
 * Handles a change to the video quality.
 * <p>
 * Callback originates from {@link android.telecom.Connection.VideoProvider#changeVideoQuality(int) Connection.VideoProvider#changeVideoQuality(int)}.
 *
 * @param videoQuality  The updated peer video quality.  Valid values:
 *      {@link android.telecom.VideoProfile#QUALITY_HIGH VideoProfile#QUALITY_HIGH},
 *      {@link android.telecom.VideoProfile#QUALITY_MEDIUM VideoProfile#QUALITY_MEDIUM},
 *      {@link android.telecom.VideoProfile#QUALITY_LOW VideoProfile#QUALITY_LOW},
 *      {@link android.telecom.VideoProfile#QUALITY_DEFAULT VideoProfile#QUALITY_DEFAULT}.
 * @apiSince 23
 */

public abstract void onVideoQualityChanged(int videoQuality);

/**
 * Handles an update to the total data used for the current video session.
 * <p>
 * Used by the {@link android.telecom.Connection.VideoProvider Connection.VideoProvider} in response to
 * {@link android.telecom.InCallService.VideoCall#requestCallDataUsage() VideoCall#requestCallDataUsage()}.  May also be called periodically by the
 * {@link android.telecom.Connection.VideoProvider Connection.VideoProvider}.
 * <p>
 * Callback originates from {@link android.telecom.Connection.VideoProvider#setCallDataUsage(long) Connection.VideoProvider#setCallDataUsage(long)}.
 *
 * @param dataUsage The updated data usage (in bytes).
 * @apiSince 23
 */

public abstract void onCallDataUsageChanged(long dataUsage);

/**
 * Handles a change in the capabilities of the currently selected camera.
 * <p>
 * Used by the {@link android.telecom.Connection.VideoProvider Connection.VideoProvider} in response to
 * {@link android.telecom.InCallService.VideoCall#requestCameraCapabilities() VideoCall#requestCameraCapabilities()}.  The {@link android.telecom.Connection.VideoProvider Connection.VideoProvider}
 * may also report the camera capabilities after a call to
 * {@link android.telecom.InCallService.VideoCall#setCamera(java.lang.String) VideoCall#setCamera(String)}.
 * <p>
 * Callback originates from
 * {@link android.telecom.Connection.VideoProvider#changeCameraCapabilities(android.telecom.VideoProfile.CameraCapabilities) Connection.VideoProvider#changeCameraCapabilities(
 *      VideoProfile.CameraCapabilities)}.
 *
 * @param cameraCapabilities The changed camera capabilities.
 * @apiSince 23
 */

public abstract void onCameraCapabilitiesChanged(android.telecom.VideoProfile.CameraCapabilities cameraCapabilities);
}

}

}

