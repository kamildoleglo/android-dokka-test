/*
 * Copyright (C) 2007 The Android Open Source Project
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


package android.media;

import android.view.KeyEvent;
import android.app.PendingIntent;
import android.app.NotificationManager;
import android.os.Build;
import android.media.session.MediaSession;
import android.content.ComponentName;
import android.content.Intent;
import android.media.session.MediaController;
import android.media.session.MediaSessionManager;
import android.os.Handler;
import android.os.Looper;
import java.io.IOException;
import android.content.Context;

/**
 * AudioManager provides access to volume and ringer mode control.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AudioManager {

AudioManager() { throw new RuntimeException("Stub!"); }

/**
 * Sends a simulated key event for a media button.
 * To simulate a key press, you must first send a KeyEvent built with a
 * {@link android.view.KeyEvent#ACTION_DOWN KeyEvent#ACTION_DOWN} action, then another event with the {@link android.view.KeyEvent#ACTION_UP KeyEvent#ACTION_UP}
 * action.
 * <p>The key event will be sent to the current media key event consumer which registered with
 * {@link android.media.AudioManager#registerMediaButtonEventReceiver(android.app.PendingIntent) AudioManager#registerMediaButtonEventReceiver(PendingIntent)}.
 * @param keyEvent a {@link android.view.KeyEvent KeyEvent} instance whose key code is one of
 *     {@link android.view.KeyEvent#KEYCODE_MUTE KeyEvent#KEYCODE_MUTE},
 *     {@link android.view.KeyEvent#KEYCODE_HEADSETHOOK KeyEvent#KEYCODE_HEADSETHOOK},
 *     {@link android.view.KeyEvent#KEYCODE_MEDIA_PLAY KeyEvent#KEYCODE_MEDIA_PLAY},
 *     {@link android.view.KeyEvent#KEYCODE_MEDIA_PAUSE KeyEvent#KEYCODE_MEDIA_PAUSE},
 *     {@link android.view.KeyEvent#KEYCODE_MEDIA_PLAY_PAUSE KeyEvent#KEYCODE_MEDIA_PLAY_PAUSE},
 *     {@link android.view.KeyEvent#KEYCODE_MEDIA_STOP KeyEvent#KEYCODE_MEDIA_STOP},
 *     {@link android.view.KeyEvent#KEYCODE_MEDIA_NEXT KeyEvent#KEYCODE_MEDIA_NEXT},
 *     {@link android.view.KeyEvent#KEYCODE_MEDIA_PREVIOUS KeyEvent#KEYCODE_MEDIA_PREVIOUS},
 *     {@link android.view.KeyEvent#KEYCODE_MEDIA_REWIND KeyEvent#KEYCODE_MEDIA_REWIND},
 *     {@link android.view.KeyEvent#KEYCODE_MEDIA_RECORD KeyEvent#KEYCODE_MEDIA_RECORD},
 *     {@link android.view.KeyEvent#KEYCODE_MEDIA_FAST_FORWARD KeyEvent#KEYCODE_MEDIA_FAST_FORWARD},
 *     {@link android.view.KeyEvent#KEYCODE_MEDIA_CLOSE KeyEvent#KEYCODE_MEDIA_CLOSE},
 *     {@link android.view.KeyEvent#KEYCODE_MEDIA_EJECT KeyEvent#KEYCODE_MEDIA_EJECT},
 *     or {@link android.view.KeyEvent#KEYCODE_MEDIA_AUDIO_TRACK KeyEvent#KEYCODE_MEDIA_AUDIO_TRACK}.
 * @apiSince 19
 */

public void dispatchMediaKeyEvent(android.view.KeyEvent keyEvent) { throw new RuntimeException("Stub!"); }

/**
 * Indicates if the device implements a fixed volume policy.
 * <p>Some devices may not have volume control and may operate at a fixed volume,
 * and may not enable muting or changing the volume of audio streams.
 * This method will return true on such devices.
 * <p>The following APIs have no effect when volume is fixed:
 * <ul>
 *   <li> {@link #adjustVolume(int,int)}
 *   <li> {@link #adjustSuggestedStreamVolume(int,int,int)}
 *   <li> {@link #adjustStreamVolume(int,int,int)}
 *   <li> {@link #setStreamVolume(int,int,int)}
 *   <li> {@link #setRingerMode(int)}
 *   <li> {@link #setStreamSolo(int,boolean)}
 *   <li> {@link #setStreamMute(int,boolean)}
 * </ul>
 * @apiSince 21
 */

public boolean isVolumeFixed() { throw new RuntimeException("Stub!"); }

/**
 * Adjusts the volume of a particular stream by one step in a direction.
 * <p>
 * This method should only be used by applications that replace the platform-wide
 * management of audio settings or the main telephony application.
 * <p>This method has no effect if the device implements a fixed volume policy
 * as indicated by {@link #isVolumeFixed()}.
 * <p>From N onward, ringer mode adjustments that would toggle Do Not Disturb are not allowed
 * unless the app has been granted Do Not Disturb Access.
 * See {@link android.app.NotificationManager#isNotificationPolicyAccessGranted() NotificationManager#isNotificationPolicyAccessGranted()}.
 *
 * @param streamType The stream type to adjust. One of {@link #STREAM_VOICE_CALL},
 * {@link #STREAM_SYSTEM}, {@link #STREAM_RING}, {@link #STREAM_MUSIC},
 * {@link #STREAM_ALARM} or {@link #STREAM_ACCESSIBILITY}.
 * @param direction The direction to adjust the volume. One of
 *            {@link #ADJUST_LOWER}, {@link #ADJUST_RAISE}, or
 *            {@link #ADJUST_SAME}.
 * @param flags One or more flags.
 * @see #adjustVolume(int, int)
 * @see #setStreamVolume(int, int, int)
 * @throws java.lang.SecurityException if the adjustment triggers a Do Not Disturb change
 *   and the caller is not granted notification policy access.
 * @apiSince 1
 */

public void adjustStreamVolume(int streamType, int direction, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Adjusts the volume of the most relevant stream. For example, if a call is
 * active, it will have the highest priority regardless of if the in-call
 * screen is showing. Another example, if music is playing in the background
 * and a call is not active, the music stream will be adjusted.
 * <p>
 * This method should only be used by applications that replace the
 * platform-wide management of audio settings or the main telephony
 * application.
 * <p>
 * This method has no effect if the device implements a fixed volume policy
 * as indicated by {@link #isVolumeFixed()}.
 *
 * @param direction The direction to adjust the volume. One of
 *            {@link #ADJUST_LOWER}, {@link #ADJUST_RAISE},
 *            {@link #ADJUST_SAME}, {@link #ADJUST_MUTE},
 *            {@link #ADJUST_UNMUTE}, or {@link #ADJUST_TOGGLE_MUTE}.
 * @param flags One or more flags.
 * @see #adjustSuggestedStreamVolume(int, int, int)
 * @see #adjustStreamVolume(int, int, int)
 * @see #setStreamVolume(int, int, int)
 * @see #isVolumeFixed()
 * @apiSince 1
 */

public void adjustVolume(int direction, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Adjusts the volume of the most relevant stream, or the given fallback
 * stream.
 * <p>
 * This method should only be used by applications that replace the
 * platform-wide management of audio settings or the main telephony
 * application.
 * <p>
 * This method has no effect if the device implements a fixed volume policy
 * as indicated by {@link #isVolumeFixed()}.
 *
 * @param direction The direction to adjust the volume. One of
 *            {@link #ADJUST_LOWER}, {@link #ADJUST_RAISE},
 *            {@link #ADJUST_SAME}, {@link #ADJUST_MUTE},
 *            {@link #ADJUST_UNMUTE}, or {@link #ADJUST_TOGGLE_MUTE}.
 * @param suggestedStreamType The stream type that will be used if there
 *            isn't a relevant stream. {@link #USE_DEFAULT_STREAM_TYPE} is
 *            valid here.
 * @param flags One or more flags.
 * @see #adjustVolume(int, int)
 * @see #adjustStreamVolume(int, int, int)
 * @see #setStreamVolume(int, int, int)
 * @see #isVolumeFixed()
 * @apiSince 1
 */

public void adjustSuggestedStreamVolume(int direction, int suggestedStreamType, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current ringtone mode.
 *
 * @return The current ringtone mode, one of {@link #RINGER_MODE_NORMAL},
 *         {@link #RINGER_MODE_SILENT}, or {@link #RINGER_MODE_VIBRATE}.
 * @see #setRingerMode(int)
 * @apiSince 1
 */

public int getRingerMode() { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum volume index for a particular stream.
 *
 * @param streamType The stream type whose maximum volume index is returned.
 * @return The maximum valid volume index for the stream.
 * @see #getStreamVolume(int)
 * @apiSince 1
 */

public int getStreamMaxVolume(int streamType) { throw new RuntimeException("Stub!"); }

/**
 * Returns the minimum volume index for a particular stream.
 * @param streamType The stream type whose minimum volume index is returned. Must be one of
 *     {@link #STREAM_VOICE_CALL}, {@link #STREAM_SYSTEM},
 *     {@link #STREAM_RING}, {@link #STREAM_MUSIC}, {@link #STREAM_ALARM},
 *     {@link #STREAM_NOTIFICATION}, {@link #STREAM_DTMF} or {@link #STREAM_ACCESSIBILITY}.
 * @return The minimum valid volume index for the stream.
 * @see #getStreamVolume(int)
 * @apiSince 28
 */

public int getStreamMinVolume(int streamType) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current volume index for a particular stream.
 *
 * @param streamType The stream type whose volume index is returned.
 * @return The current volume index for the stream.
 * @see #getStreamMaxVolume(int)
 * @see #setStreamVolume(int, int, int)
 * @apiSince 1
 */

public int getStreamVolume(int streamType) { throw new RuntimeException("Stub!"); }

/**
 * Returns the volume in dB (decibel) for the given stream type at the given volume index, on
 * the given type of audio output device.
 * @param streamType stream type for which the volume is queried.
 * Value is {@link android.media.AudioManager#STREAM_VOICE_CALL}, {@link android.media.AudioManager#STREAM_SYSTEM}, {@link android.media.AudioManager#STREAM_RING}, {@link android.media.AudioManager#STREAM_MUSIC}, {@link android.media.AudioManager#STREAM_ALARM}, {@link android.media.AudioManager#STREAM_NOTIFICATION}, {@link android.media.AudioManager#STREAM_DTMF}, or {@link android.media.AudioManager#STREAM_ACCESSIBILITY}
 * @param index the volume index for which the volume is queried. The index value must be
 *     between the minimum and maximum index values for the given stream type (see
 *     {@link #getStreamMinVolume(int)} and {@link #getStreamMaxVolume(int)}).
 * @param deviceType the type of audio output device for which volume is queried.
 * Value is {@link android.media.AudioDeviceInfo#TYPE_BUILTIN_EARPIECE}, {@link android.media.AudioDeviceInfo#TYPE_BUILTIN_SPEAKER}, {@link android.media.AudioDeviceInfo#TYPE_WIRED_HEADSET}, {@link android.media.AudioDeviceInfo#TYPE_WIRED_HEADPHONES}, {@link android.media.AudioDeviceInfo#TYPE_BLUETOOTH_SCO}, {@link android.media.AudioDeviceInfo#TYPE_BLUETOOTH_A2DP}, {@link android.media.AudioDeviceInfo#TYPE_HDMI}, {@link android.media.AudioDeviceInfo#TYPE_DOCK}, {@link android.media.AudioDeviceInfo#TYPE_USB_ACCESSORY}, {@link android.media.AudioDeviceInfo#TYPE_USB_DEVICE}, {@link android.media.AudioDeviceInfo#TYPE_USB_HEADSET}, {@link android.media.AudioDeviceInfo#TYPE_TELEPHONY}, {@link android.media.AudioDeviceInfo#TYPE_LINE_ANALOG}, {@link android.media.AudioDeviceInfo#TYPE_HDMI_ARC}, {@link android.media.AudioDeviceInfo#TYPE_LINE_DIGITAL}, {@link android.media.AudioDeviceInfo#TYPE_FM}, {@link android.media.AudioDeviceInfo#TYPE_AUX_LINE}, {@link android.media.AudioDeviceInfo#TYPE_IP}, {@link android.media.AudioDeviceInfo#TYPE_BUS}, or {@link android.media.AudioDeviceInfo#TYPE_HEARING_AID}
 * @return a volume expressed in dB.
 *     A negative value indicates the audio signal is attenuated. A typical maximum value
 *     at the maximum volume index is 0 dB (no attenuation nor amplification). Muting is
 *     reflected by a value of {@link java.lang.Float#NEGATIVE_INFINITY Float#NEGATIVE_INFINITY}.
 * @apiSince 28
 */

public float getStreamVolumeDb(int streamType, int index, int deviceType) { throw new RuntimeException("Stub!"); }

/**
 * Sets the ringer mode.
 * <p>
 * Silent mode will mute the volume and will not vibrate. Vibrate mode will
 * mute the volume and vibrate. Normal mode will be audible and may vibrate
 * according to user settings.
 * <p>This method has no effect if the device implements a fixed volume policy
 * as indicated by {@link #isVolumeFixed()}.
 * * <p>From N onward, ringer mode adjustments that would toggle Do Not Disturb are not allowed
 * unless the app has been granted Do Not Disturb Access.
 * See {@link android.app.NotificationManager#isNotificationPolicyAccessGranted() NotificationManager#isNotificationPolicyAccessGranted()}.
 * @param ringerMode The ringer mode, one of {@link #RINGER_MODE_NORMAL},
 *            {@link #RINGER_MODE_SILENT}, or {@link #RINGER_MODE_VIBRATE}.
 * @see #getRingerMode()
 * @see #isVolumeFixed()
 * @apiSince 1
 */

public void setRingerMode(int ringerMode) { throw new RuntimeException("Stub!"); }

/**
 * Sets the volume index for a particular stream.
 * <p>This method has no effect if the device implements a fixed volume policy
 * as indicated by {@link #isVolumeFixed()}.
 * <p>From N onward, volume adjustments that would toggle Do Not Disturb are not allowed unless
 * the app has been granted Do Not Disturb Access.
 * See {@link android.app.NotificationManager#isNotificationPolicyAccessGranted() NotificationManager#isNotificationPolicyAccessGranted()}.
 * @param streamType The stream whose volume index should be set.
 * @param index The volume index to set. See
 *            {@link #getStreamMaxVolume(int)} for the largest valid value.
 * @param flags One or more flags.
 * @see #getStreamMaxVolume(int)
 * @see #getStreamVolume(int)
 * @see #isVolumeFixed()
 * @throws java.lang.SecurityException if the volume change triggers a Do Not Disturb change
 *   and the caller is not granted notification policy access.
 * @apiSince 1
 */

public void setStreamVolume(int streamType, int index, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Solo or unsolo a particular stream.
 * <p>
 * Do not use. This method has been deprecated and is now a no-op.
 * {@link #requestAudioFocus} should be used for exclusive audio playback.
 *
 * @param streamType The stream to be soloed/unsoloed.
 * @param state The required solo state: true for solo ON, false for solo
 *            OFF
 * @see #isVolumeFixed()
 * @deprecated Do not use. If you need exclusive audio playback use
 *             {@link #requestAudioFocus}.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public void setStreamSolo(int streamType, boolean state) { throw new RuntimeException("Stub!"); }

/**
 * Mute or unmute an audio stream.
 * <p>
 * This method should only be used by applications that replace the
 * platform-wide management of audio settings or the main telephony
 * application.
 * <p>
 * This method has no effect if the device implements a fixed volume policy
 * as indicated by {@link #isVolumeFixed()}.
 * <p>
 * This method was deprecated in API level 22. Prior to API level 22 this
 * method had significantly different behavior and should be used carefully.
 * The following applies only to pre-22 platforms:
 * <ul>
 * <li>The mute command is protected against client process death: if a
 * process with an active mute request on a stream dies, this stream will be
 * unmuted automatically.</li>
 * <li>The mute requests for a given stream are cumulative: the AudioManager
 * can receive several mute requests from one or more clients and the stream
 * will be unmuted only when the same number of unmute requests are
 * received.</li>
 * <li>For a better user experience, applications MUST unmute a muted stream
 * in onPause() and mute is again in onResume() if appropriate.</li>
 * </ul>
 *
 * @param streamType The stream to be muted/unmuted.
 * @param state The required mute state: true for mute ON, false for mute
 *            OFF
 * @see #isVolumeFixed()
 * @deprecated Use {@link #adjustStreamVolume(int,int,int)} with
 *             {@link #ADJUST_MUTE} or {@link #ADJUST_UNMUTE} instead.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
public void setStreamMute(int streamType, boolean state) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current mute state for a particular stream.
 *
 * @param streamType The stream to get mute state for.
 * @return The mute state for the given stream.
 * @see #adjustStreamVolume(int, int, int)
 * @apiSince 23
 */

public boolean isStreamMute(int streamType) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether a particular type should vibrate according to user
 * settings and the current ringer mode.
 * <p>
 * This shouldn't be needed by most clients that use notifications to
 * vibrate. The notification manager will not vibrate if the policy doesn't
 * allow it, so the client should always set a vibrate pattern and let the
 * notification manager control whether or not to actually vibrate.
 *
 * @param vibrateType The type of vibrate. One of
 *            {@link #VIBRATE_TYPE_NOTIFICATION} or
 *            {@link #VIBRATE_TYPE_RINGER}.
 * @return Whether the type should vibrate at the instant this method is
 *         called.
 * @see #setVibrateSetting(int, int)
 * @see #getVibrateSetting(int)
 * @deprecated Applications should maintain their own vibrate policy based on
 * current ringer mode that can be queried via {@link #getRingerMode()}.
 * @apiSince 1
 * @deprecatedSince 16
 */

@Deprecated
public boolean shouldVibrate(int vibrateType) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the user's vibrate setting for a vibrate type.
 * <p>
 * This shouldn't be needed by most clients that want to vibrate, instead
 * see {@link #shouldVibrate(int)}.
 *
 * @param vibrateType The type of vibrate. One of
 *            {@link #VIBRATE_TYPE_NOTIFICATION} or
 *            {@link #VIBRATE_TYPE_RINGER}.
 * @return The vibrate setting, one of {@link #VIBRATE_SETTING_ON},
 *         {@link #VIBRATE_SETTING_OFF}, or
 *         {@link #VIBRATE_SETTING_ONLY_SILENT}.
 * @see #setVibrateSetting(int, int)
 * @see #shouldVibrate(int)
 * @deprecated Applications should maintain their own vibrate policy based on
 * current ringer mode that can be queried via {@link #getRingerMode()}.
 * @apiSince 1
 * @deprecatedSince 16
 */

@Deprecated
public int getVibrateSetting(int vibrateType) { throw new RuntimeException("Stub!"); }

/**
 * Sets the setting for when the vibrate type should vibrate.
 * <p>
 * This method should only be used by applications that replace the platform-wide
 * management of audio settings or the main telephony application.
 *
 * @param vibrateType The type of vibrate. One of
 *            {@link #VIBRATE_TYPE_NOTIFICATION} or
 *            {@link #VIBRATE_TYPE_RINGER}.
 * @param vibrateSetting The vibrate setting, one of
 *            {@link #VIBRATE_SETTING_ON},
 *            {@link #VIBRATE_SETTING_OFF}, or
 *            {@link #VIBRATE_SETTING_ONLY_SILENT}.
 * @see #getVibrateSetting(int)
 * @see #shouldVibrate(int)
 * @deprecated Applications should maintain their own vibrate policy based on
 * current ringer mode that can be queried via {@link #getRingerMode()}.
 * @apiSince 1
 * @deprecatedSince 16
 */

@Deprecated
public void setVibrateSetting(int vibrateType, int vibrateSetting) { throw new RuntimeException("Stub!"); }

/**
 * Sets the speakerphone on or off.
 * <p>
 * This method should only be used by applications that replace the platform-wide
 * management of audio settings or the main telephony application.
 *
 * @param on set <var>true</var> to turn on speakerphone;
 *           <var>false</var> to turn it off
 * @apiSince 1
 */

public void setSpeakerphoneOn(boolean on) { throw new RuntimeException("Stub!"); }

/**
 * Checks whether the speakerphone is on or off.
 *
 * @return true if speakerphone is on, false if it's off
 * @apiSince 1
 */

public boolean isSpeakerphoneOn() { throw new RuntimeException("Stub!"); }

/**
 * Specifies whether the audio played by this app may or may not be captured by other apps or
 * the system.
 *
 * The default is {@link android.media.AudioAttributes#ALLOW_CAPTURE_BY_ALL AudioAttributes#ALLOW_CAPTURE_BY_ALL}.
 *
 * There are multiple ways to set this policy:
 * <ul>
 * <li> for each track independently, see
 *    {@link android.media.AudioAttributes.Builder#setAllowedCapturePolicy(int) AudioAttributes.Builder#setAllowedCapturePolicy(int)} </li>
 * <li> application-wide at runtime, with this method </li>
 * <li> application-wide at build time, see {@code allowAudioPlaybackCapture} in the application
 *       manifest. </li>
 * </ul>
 * The most restrictive policy is always applied.
 *
 * See {@link android.media.AudioPlaybackCaptureConfiguration AudioPlaybackCaptureConfiguration} for more details on
 * which audio signals can be captured.
 *
 * @param capturePolicy one of
 *     {@link android.media.AudioAttributes#ALLOW_CAPTURE_BY_ALL AudioAttributes#ALLOW_CAPTURE_BY_ALL},
 *     {@link android.media.AudioAttributes#ALLOW_CAPTURE_BY_SYSTEM AudioAttributes#ALLOW_CAPTURE_BY_SYSTEM},
 *     {@link android.media.AudioAttributes#ALLOW_CAPTURE_BY_NONE AudioAttributes#ALLOW_CAPTURE_BY_NONE}.
 * Value is {@link android.media.AudioAttributes#ALLOW_CAPTURE_BY_ALL}, {@link android.media.AudioAttributes#ALLOW_CAPTURE_BY_SYSTEM}, or {@link android.media.AudioAttributes#ALLOW_CAPTURE_BY_NONE}
 * @throws java.lang.IllegalArgumentException if the argument is not a valid value.
 * @apiSince 29
 */

public void setAllowedCapturePolicy(int capturePolicy) { throw new RuntimeException("Stub!"); }

/**
 * Return the capture policy.
 * @return the capture policy set by {@link #setAllowedCapturePolicy(int)} or
 *         the default if it was not called.
 
 * Value is {@link android.media.AudioAttributes#ALLOW_CAPTURE_BY_ALL}, {@link android.media.AudioAttributes#ALLOW_CAPTURE_BY_SYSTEM}, or {@link android.media.AudioAttributes#ALLOW_CAPTURE_BY_NONE}
 * @apiSince 29
 */

public int getAllowedCapturePolicy() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether offloaded playback of an audio format is supported on the device.
 * <p>Offloaded playback is the feature where the decoding and playback of an audio stream
 * is not competing with other software resources. In general, it is supported by dedicated
 * hardware, such as audio DSPs.
 * <p>Note that this query only provides information about the support of an audio format,
 * it does not indicate whether the resources necessary for the offloaded playback are
 * available at that instant.
 * @param format the audio format (codec, sample rate, channels) being checked.
 * This value must never be {@code null}.
 * @param attributes the {@link android.media.AudioAttributes AudioAttributes} to be used for playback
 * This value must never be {@code null}.
 * @return true if the given audio format can be offloaded.
 * @apiSince 29
 */

public static boolean isOffloadedPlaybackSupported(@androidx.annotation.NonNull android.media.AudioFormat format, @androidx.annotation.NonNull android.media.AudioAttributes attributes) { throw new RuntimeException("Stub!"); }

/**
 * Indicates if current platform supports use of SCO for off call use cases.
 * Application wanted to use bluetooth SCO audio when the phone is not in call
 * must first call this method to make sure that the platform supports this
 * feature.
 * @return true if bluetooth SCO can be used for audio when not in call
 *         false otherwise
 * @see #startBluetoothSco()
 * @apiSince 8
 */

public boolean isBluetoothScoAvailableOffCall() { throw new RuntimeException("Stub!"); }

/**
 * Start bluetooth SCO audio connection.
 * <p>Requires Permission:
 *   {@link android.Manifest.permission#MODIFY_AUDIO_SETTINGS}.
 * <p>This method can be used by applications wanting to send and received audio
 * to/from a bluetooth SCO headset while the phone is not in call.
 * <p>As the SCO connection establishment can take several seconds,
 * applications should not rely on the connection to be available when the method
 * returns but instead register to receive the intent {@link #ACTION_SCO_AUDIO_STATE_UPDATED}
 * and wait for the state to be {@link #SCO_AUDIO_STATE_CONNECTED}.
 * <p>As the ACTION_SCO_AUDIO_STATE_UPDATED intent is sticky, the application can check the SCO
 * audio state before calling startBluetoothSco() by reading the intent returned by the receiver
 * registration. If the state is already CONNECTED, no state change will be received via the
 * intent after calling startBluetoothSco(). It is however useful to call startBluetoothSco()
 * so that the connection stays active in case the current initiator stops the connection.
 * <p>Unless the connection is already active as described above, the state will always
 * transition from DISCONNECTED to CONNECTING and then either to CONNECTED if the connection
 * succeeds or back to DISCONNECTED if the connection fails (e.g no headset is connected).
 * <p>When finished with the SCO connection or if the establishment fails, the application must
 * call {@link #stopBluetoothSco()} to clear the request and turn down the bluetooth connection.
 * <p>Even if a SCO connection is established, the following restrictions apply on audio
 * output streams so that they can be routed to SCO headset:
 * <ul>
 *   <li> the stream type must be {@link #STREAM_VOICE_CALL} </li>
 *   <li> the format must be mono </li>
 *   <li> the sampling must be 16kHz or 8kHz </li>
 * </ul>
 * <p>The following restrictions apply on input streams:
 * <ul>
 *   <li> the format must be mono </li>
 *   <li> the sampling must be 8kHz </li>
 * </ul>
 * <p>Note that the phone application always has the priority on the usage of the SCO
 * connection for telephony. If this method is called while the phone is in call
 * it will be ignored. Similarly, if a call is received or sent while an application
 * is using the SCO connection, the connection will be lost for the application and NOT
 * returned automatically when the call ends.
 * <p>NOTE: up to and including API version
 * {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR1}, this method initiates a virtual
 * voice call to the bluetooth headset.
 * After API version {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR2} only a raw SCO audio
 * connection is established.
 * @see #stopBluetoothSco()
 * @see #ACTION_SCO_AUDIO_STATE_UPDATED
 * @apiSince 8
 */

public void startBluetoothSco() { throw new RuntimeException("Stub!"); }

/**
 * Stop bluetooth SCO audio connection.
 * <p>Requires Permission:
 *   {@link android.Manifest.permission#MODIFY_AUDIO_SETTINGS}.
 * <p>This method must be called by applications having requested the use of
 * bluetooth SCO audio with {@link #startBluetoothSco()} when finished with the SCO
 * connection or if connection fails.
 * @see #startBluetoothSco()
 * @apiSince 8
 */

public void stopBluetoothSco() { throw new RuntimeException("Stub!"); }

/**
 * Request use of Bluetooth SCO headset for communications.
 * <p>
 * This method should only be used by applications that replace the platform-wide
 * management of audio settings or the main telephony application.
 *
 * @param on set <var>true</var> to use bluetooth SCO for communications;
 *               <var>false</var> to not use bluetooth SCO for communications
 * @apiSince 1
 */

public void setBluetoothScoOn(boolean on) { throw new RuntimeException("Stub!"); }

/**
 * Checks whether communications use Bluetooth SCO.
 *
 * @return true if SCO is used for communications;
 *         false if otherwise
 * @apiSince 1
 */

public boolean isBluetoothScoOn() { throw new RuntimeException("Stub!"); }

/**
 * @param on set <var>true</var> to route A2DP audio to/from Bluetooth
 *           headset; <var>false</var> disable A2DP audio
 * @deprecated Do not use.
 * @apiSince 3
 * @deprecatedSince 15
 */

@Deprecated
public void setBluetoothA2dpOn(boolean on) { throw new RuntimeException("Stub!"); }

/**
 * Checks whether a Bluetooth A2DP audio peripheral is connected or not.
 *
 * @return true if a Bluetooth A2DP peripheral is connected
 *         false if otherwise
 * @deprecated Use {@link android.media.AudioManager#getDevices(int) AudioManager#getDevices(int)} instead to list available audio devices.
 * @apiSince 3
 * @deprecatedSince 26
 */

@Deprecated
public boolean isBluetoothA2dpOn() { throw new RuntimeException("Stub!"); }

/**
 * Sets audio routing to the wired headset on or off.
 *
 * @param on set <var>true</var> to route audio to/from wired
 *           headset; <var>false</var> disable wired headset audio
 * @deprecated Do not use.
 * @apiSince 5
 * @deprecatedSince 15
 */

@Deprecated
public void setWiredHeadsetOn(boolean on) { throw new RuntimeException("Stub!"); }

/**
 * Checks whether a wired headset is connected or not.
 * <p>This is not a valid indication that audio playback is
 * actually over the wired headset as audio routing depends on other conditions.
 *
 * @return true if a wired headset is connected.
 *         false if otherwise
 * @deprecated Use {@link android.media.AudioManager#getDevices(int) AudioManager#getDevices(int)} instead to list available audio devices.
 * @apiSince 5
 * @deprecatedSince 15
 */

@Deprecated
public boolean isWiredHeadsetOn() { throw new RuntimeException("Stub!"); }

/**
 * Sets the microphone mute on or off.
 * <p>
 * This method should only be used by applications that replace the platform-wide
 * management of audio settings or the main telephony application.
 *
 * @param on set <var>true</var> to mute the microphone;
 *           <var>false</var> to turn mute off
 * @apiSince 1
 */

public void setMicrophoneMute(boolean on) { throw new RuntimeException("Stub!"); }

/**
 * Checks whether the microphone mute is on or off.
 *
 * @return true if microphone is muted, false if it's not
 * @apiSince 1
 */

public boolean isMicrophoneMute() { throw new RuntimeException("Stub!"); }

/**
 * Sets the audio mode.
 * <p>
 * The audio mode encompasses audio routing AND the behavior of
 * the telephony layer. Therefore this method should only be used by applications that
 * replace the platform-wide management of audio settings or the main telephony application.
 * In particular, the {@link #MODE_IN_CALL} mode should only be used by the telephony
 * application when it places a phone call, as it will cause signals from the radio layer
 * to feed the platform mixer.
 *
 * @param mode  the requested audio mode ({@link #MODE_NORMAL}, {@link #MODE_RINGTONE},
 *              {@link #MODE_IN_CALL} or {@link #MODE_IN_COMMUNICATION}).
 *              Informs the HAL about the current audio state so that
 *              it can route the audio appropriately.
 * @apiSince 1
 */

public void setMode(int mode) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current audio mode.
 *
 * @return      the current audio mode ({@link #MODE_NORMAL}, {@link #MODE_RINGTONE},
 *              {@link #MODE_IN_CALL} or {@link #MODE_IN_COMMUNICATION}).
 *              Returns the current current audio state from the HAL.
 * @apiSince 1
 */

public int getMode() { throw new RuntimeException("Stub!"); }

/**
 * Sets the audio routing for a specified mode
 *
 * @param mode   audio mode to change route. E.g., MODE_RINGTONE.
 * @param routes bit vector of routes requested, created from one or
 *               more of ROUTE_xxx types. Set bits indicate that route should be on
 * @param mask   bit vector of routes to change, created from one or more of
 * ROUTE_xxx types. Unset bits indicate the route should be left unchanged
 *
 * @deprecated   Do not set audio routing directly, use setSpeakerphoneOn(),
 * setBluetoothScoOn() methods instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public void setRouting(int mode, int routes, int mask) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current audio routing bit vector for a specified mode.
 *
 * @param mode audio mode to get route (e.g., MODE_RINGTONE)
 * @return an audio route bit vector that can be compared with ROUTE_xxx
 * bits
 * @deprecated   Do not query audio routing directly, use isSpeakerphoneOn(),
 * isBluetoothScoOn(), isBluetoothA2dpOn() and isWiredHeadsetOn() methods instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public int getRouting(int mode) { throw new RuntimeException("Stub!"); }

/**
 * Checks whether any music is active.
 *
 * @return true if any music tracks are active.
 * @apiSince 1
 */

public boolean isMusicActive() { throw new RuntimeException("Stub!"); }

/**
 * Return a new audio session identifier not associated with any player or effect.
 * An audio session identifier is a system wide unique identifier for a set of audio streams
 * (one or more mixed together).
 * <p>The primary use of the audio session ID is to associate audio effects to audio players,
 * such as {@link android.media.MediaPlayer MediaPlayer} or {@link android.media.AudioTrack AudioTrack}: all audio effects sharing the same audio
 * session ID will be applied to the mixed audio content of the players that share the same
 * audio session.
 * <p>This method can for instance be used when creating one of the
 * {@link android.media.audiofx.AudioEffect} objects to define the audio session of the effect,
 * or to specify a session for a speech synthesis utterance
 * in {@link android.speech.tts.TextToSpeech.Engine}.
 * @return a new unclaimed and unused audio session identifier, or {@link #ERROR} when the
 *   system failed to generate a new session, a condition in which audio playback or recording
 *   will subsequently fail as well.
 * @apiSince 21
 */

public int generateAudioSessionId() { throw new RuntimeException("Stub!"); }

/**
 * Sets a variable number of parameter values to audio hardware.
 *
 * @param keyValuePairs list of parameters key value pairs in the form:
 *    key1=value1;key2=value2;...
 *
 * @apiSince 5
 */

public void setParameters(java.lang.String keyValuePairs) { throw new RuntimeException("Stub!"); }

/**
 * Gets a variable number of parameter values from audio hardware.
 *
 * @param keys list of parameters
 * @return list of parameters key value pairs in the form:
 *    key1=value1;key2=value2;...
 * @apiSince 5
 */

public java.lang.String getParameters(java.lang.String keys) { throw new RuntimeException("Stub!"); }

/**
 * Plays a sound effect (Key clicks, lid open/close...)
 * @param effectType The type of sound effect. One of
 *            {@link #FX_KEY_CLICK},
 *            {@link #FX_FOCUS_NAVIGATION_UP},
 *            {@link #FX_FOCUS_NAVIGATION_DOWN},
 *            {@link #FX_FOCUS_NAVIGATION_LEFT},
 *            {@link #FX_FOCUS_NAVIGATION_RIGHT},
 *            {@link #FX_KEYPRESS_STANDARD},
 *            {@link #FX_KEYPRESS_SPACEBAR},
 *            {@link #FX_KEYPRESS_DELETE},
 *            {@link #FX_KEYPRESS_RETURN},
 *            {@link #FX_KEYPRESS_INVALID},
 * NOTE: This version uses the UI settings to determine
 * whether sounds are heard or not.
 * @apiSince 1
 */

public void playSoundEffect(int effectType) { throw new RuntimeException("Stub!"); }

/**
 * Plays a sound effect (Key clicks, lid open/close...)
 * @param effectType The type of sound effect. One of
 *            {@link #FX_KEY_CLICK},
 *            {@link #FX_FOCUS_NAVIGATION_UP},
 *            {@link #FX_FOCUS_NAVIGATION_DOWN},
 *            {@link #FX_FOCUS_NAVIGATION_LEFT},
 *            {@link #FX_FOCUS_NAVIGATION_RIGHT},
 *            {@link #FX_KEYPRESS_STANDARD},
 *            {@link #FX_KEYPRESS_SPACEBAR},
 *            {@link #FX_KEYPRESS_DELETE},
 *            {@link #FX_KEYPRESS_RETURN},
 *            {@link #FX_KEYPRESS_INVALID},
 * @param volume Sound effect volume.
 * The volume value is a raw scalar so UI controls should be scaled logarithmically.
 * If a volume of -1 is specified, the AudioManager.STREAM_MUSIC stream volume minus 3dB will be used.
 * NOTE: This version is for applications that have their own
 * settings panel for enabling and controlling volume.
 * @apiSince 3
 */

public void playSoundEffect(int effectType, float volume) { throw new RuntimeException("Stub!"); }

/**
 *  Load Sound effects.
 *  This method must be called when sound effects are enabled.
 * @apiSince 1
 */

public void loadSoundEffects() { throw new RuntimeException("Stub!"); }

/**
 *  Unload Sound effects.
 *  This method can be called to free some memory when
 *  sound effects are disabled.
 * @apiSince 1
 */

public void unloadSoundEffects() { throw new RuntimeException("Stub!"); }

/**
 *  Request audio focus.
 *  Send a request to obtain the audio focus
 *  @param l the listener to be notified of audio focus changes
 *  @param streamType the main audio stream type affected by the focus request
 *  @param durationHint use {@link #AUDIOFOCUS_GAIN_TRANSIENT} to indicate this focus request
 *      is temporary, and focus will be abandonned shortly. Examples of transient requests are
 *      for the playback of driving directions, or notifications sounds.
 *      Use {@link #AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK} to indicate also that it's ok for
 *      the previous focus owner to keep playing if it ducks its audio output.
 *      Alternatively use {@link #AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE} for a temporary request
 *      that benefits from the system not playing disruptive sounds like notifications, for
 *      usecases such as voice memo recording, or speech recognition.
 *      Use {@link #AUDIOFOCUS_GAIN} for a focus request of unknown duration such
 *      as the playback of a song or a video.
 *  @return {@link #AUDIOFOCUS_REQUEST_FAILED} or {@link #AUDIOFOCUS_REQUEST_GRANTED}
 *  @deprecated use {@link #requestAudioFocus(android.media.AudioFocusRequest)}
 * @apiSince 8
 * @deprecatedSince 26
 */

@Deprecated
public int requestAudioFocus(android.media.AudioManager.OnAudioFocusChangeListener l, int streamType, int durationHint) { throw new RuntimeException("Stub!"); }

/**
 * Request audio focus.
 * See the {@link android.media.AudioFocusRequest AudioFocusRequest} for information about the options available to configure
 * your request, and notification of focus gain and loss.
 * @param focusRequest a {@link android.media.AudioFocusRequest AudioFocusRequest} instance used to configure how focus is
 *   requested.
 * This value must never be {@code null}.
 * @return {@link #AUDIOFOCUS_REQUEST_FAILED}, {@link #AUDIOFOCUS_REQUEST_GRANTED}
 *     or {@link #AUDIOFOCUS_REQUEST_DELAYED}.
 *     <br>Note that the return value is never {@link #AUDIOFOCUS_REQUEST_DELAYED} when focus
 *     is requested without building the {@link android.media.AudioFocusRequest AudioFocusRequest} with
 *     {@link android.media.AudioFocusRequest.Builder#setAcceptsDelayedFocusGain(boolean) AudioFocusRequest.Builder#setAcceptsDelayedFocusGain(boolean)} set to
 *     {@code true}.
 * @throws java.lang.NullPointerException if passed a null argument
 * @apiSince 26
 */

public int requestAudioFocus(@androidx.annotation.NonNull android.media.AudioFocusRequest focusRequest) { throw new RuntimeException("Stub!"); }

/**
 *  Abandon audio focus. Causes the previous focus owner, if any, to receive focus.
 *  @param focusRequest the {@link android.media.AudioFocusRequest AudioFocusRequest} that was used when requesting focus
 *      with {@link #requestAudioFocus(android.media.AudioFocusRequest)}.
 *
 * This value must never be {@code null}.
 * @return {@link #AUDIOFOCUS_REQUEST_FAILED} or {@link #AUDIOFOCUS_REQUEST_GRANTED}
 *  @throws java.lang.IllegalArgumentException if passed a null argument
 * @apiSince 26
 */

public int abandonAudioFocusRequest(@androidx.annotation.NonNull android.media.AudioFocusRequest focusRequest) { throw new RuntimeException("Stub!"); }

/**
 *  Abandon audio focus. Causes the previous focus owner, if any, to receive focus.
 *  @param l the listener with which focus was requested.
 *  @return {@link #AUDIOFOCUS_REQUEST_FAILED} or {@link #AUDIOFOCUS_REQUEST_GRANTED}
 *  @deprecated use {@link #abandonAudioFocusRequest(android.media.AudioFocusRequest)}
 * @apiSince 8
 * @deprecatedSince 26
 */

@Deprecated
public int abandonAudioFocus(android.media.AudioManager.OnAudioFocusChangeListener l) { throw new RuntimeException("Stub!"); }

/**
 * Register a component to be the sole receiver of MEDIA_BUTTON intents.
 * @param eventReceiver identifier of a {@link android.content.BroadcastReceiver}
 *      that will receive the media button intent. This broadcast receiver must be declared
 *      in the application manifest. The package of the component must match that of
 *      the context you're registering from.
 * @deprecated Use {@link android.media.session.MediaSession#setMediaButtonReceiver(android.app.PendingIntent) MediaSession#setMediaButtonReceiver(PendingIntent)} instead.
 * @apiSince 8
 * @deprecatedSince 21
 */

@Deprecated
public void registerMediaButtonEventReceiver(android.content.ComponentName eventReceiver) { throw new RuntimeException("Stub!"); }

/**
 * Register a component to be the sole receiver of MEDIA_BUTTON intents.  This is like
 * {@link #registerMediaButtonEventReceiver(android.content.ComponentName)}, but allows
 * the buttons to go to any PendingIntent.  Note that you should only use this form if
 * you know you will continue running for the full time until unregistering the
 * PendingIntent.
 * @param eventReceiver target that will receive media button intents.  The PendingIntent
 * will be sent an {@link android.content.Intent#ACTION_MEDIA_BUTTON Intent#ACTION_MEDIA_BUTTON} event when a media button action
 * occurs, with {@link android.content.Intent#EXTRA_KEY_EVENT Intent#EXTRA_KEY_EVENT} added and holding the key code of the
 * media button that was pressed.
 * @deprecated Use {@link android.media.session.MediaSession#setMediaButtonReceiver(android.app.PendingIntent) MediaSession#setMediaButtonReceiver(PendingIntent)} instead.
 * @apiSince 18
 * @deprecatedSince 21
 */

@Deprecated
public void registerMediaButtonEventReceiver(android.app.PendingIntent eventReceiver) { throw new RuntimeException("Stub!"); }

/**
 * Unregister the receiver of MEDIA_BUTTON intents.
 * @param eventReceiver identifier of a {@link android.content.BroadcastReceiver}
 *      that was registered with {@link #registerMediaButtonEventReceiver(android.content.ComponentName)}.
 * @deprecated Use {@link android.media.session.MediaSession MediaSession} instead.
 * @apiSince 8
 * @deprecatedSince 21
 */

@Deprecated
public void unregisterMediaButtonEventReceiver(android.content.ComponentName eventReceiver) { throw new RuntimeException("Stub!"); }

/**
 * Unregister the receiver of MEDIA_BUTTON intents.
 * @param eventReceiver same PendingIntent that was registed with
 *      {@link #registerMediaButtonEventReceiver(android.app.PendingIntent)}.
 * @deprecated Use {@link android.media.session.MediaSession MediaSession} instead.
 * @apiSince 18
 * @deprecatedSince 21
 */

@Deprecated
public void unregisterMediaButtonEventReceiver(android.app.PendingIntent eventReceiver) { throw new RuntimeException("Stub!"); }

/**
 * Registers the remote control client for providing information to display on the remote
 * controls.
 * @param rcClient The remote control client from which remote controls will receive
 *      information to display.
 * @see android.media.RemoteControlClient
 * @deprecated Use {@link android.media.session.MediaSession MediaSession} instead.
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated
public void registerRemoteControlClient(android.media.RemoteControlClient rcClient) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters the remote control client that was providing information to display on the
 * remote controls.
 * @param rcClient The remote control client to unregister.
 * @see #registerRemoteControlClient(RemoteControlClient)
 * @deprecated Use {@link android.media.session.MediaSession MediaSession} instead.
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated
public void unregisterRemoteControlClient(android.media.RemoteControlClient rcClient) { throw new RuntimeException("Stub!"); }

/**
 * Registers a {@link android.media.RemoteController RemoteController} instance for it to receive media
 * metadata updates and playback state information from applications using
 * {@link android.media.RemoteControlClient RemoteControlClient}, and control their playback.
 * <p>
 * Registration requires the {@link android.media.RemoteController.OnClientUpdateListener RemoteController.OnClientUpdateListener} listener to be
 * one of the enabled notification listeners (see
 * {@link android.service.notification.NotificationListenerService}).
 *
 * @param rctlr the object to register.
 * @return true if the {@link android.media.RemoteController RemoteController} was successfully registered,
 *         false if an error occurred, due to an internal system error, or
 *         insufficient permissions.
 * @deprecated Use
 *             {@link android.media.session.MediaSessionManager#addOnActiveSessionsChangedListener(android.media.session.MediaSessionManager.OnActiveSessionsChangedListener,android.content.ComponentName) MediaSessionManager#addOnActiveSessionsChangedListener(android.media.session.MediaSessionManager.OnActiveSessionsChangedListener, ComponentName)}
 *             and {@link android.media.session.MediaController MediaController} instead.
 * @apiSince 19
 * @deprecatedSince 21
 */

@Deprecated
public boolean registerRemoteController(android.media.RemoteController rctlr) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters a {@link android.media.RemoteController RemoteController}, causing it to no longer receive
 * media metadata and playback state information, and no longer be capable
 * of controlling playback.
 *
 * @param rctlr the object to unregister.
 * @deprecated Use
 *             {@link android.media.session.MediaSessionManager#removeOnActiveSessionsChangedListener(android.media.session.MediaSessionManager.OnActiveSessionsChangedListener) MediaSessionManager#removeOnActiveSessionsChangedListener(android.media.session.MediaSessionManager.OnActiveSessionsChangedListener)}
 *             instead.
 * @apiSince 19
 * @deprecatedSince 21
 */

@Deprecated
public void unregisterRemoteController(android.media.RemoteController rctlr) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be notified of audio playback changes through
 * {@link android.media.AudioManager.AudioPlaybackCallback AudioPlaybackCallback}
 * @param cb non-null callback to register
 * This value must never be {@code null}.
 * @param handler the {@link android.os.Handler Handler} object for the thread on which to execute
 * the callback. If <code>null</code>, the {@link android.os.Handler Handler} associated with the main
 * {@link android.os.Looper Looper} will be used.
 * @apiSince 26
 */

public void registerAudioPlaybackCallback(@androidx.annotation.NonNull android.media.AudioManager.AudioPlaybackCallback cb, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Unregister an audio playback callback previously registered with
 * {@link #registerAudioPlaybackCallback(android.media.AudioManager.AudioPlaybackCallback,android.os.Handler)}.
 * @param cb non-null callback to unregister
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public void unregisterAudioPlaybackCallback(@androidx.annotation.NonNull android.media.AudioManager.AudioPlaybackCallback cb) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current active audio playback configurations of the device
 * @return a non-null list of playback configurations. An empty list indicates there is no
 *     playback active when queried.
 * @see android.media.AudioPlaybackConfiguration
 * @apiSince 26
 */

@androidx.annotation.NonNull
public java.util.List<android.media.AudioPlaybackConfiguration> getActivePlaybackConfigurations() { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be notified of audio recording changes through
 * {@link android.media.AudioManager.AudioRecordingCallback AudioRecordingCallback}
 * @param cb non-null callback to register
 * This value must never be {@code null}.
 * @param handler the {@link android.os.Handler Handler} object for the thread on which to execute
 * the callback. If <code>null</code>, the {@link android.os.Handler Handler} associated with the main
 * {@link android.os.Looper Looper} will be used.
 * @apiSince 24
 */

public void registerAudioRecordingCallback(@androidx.annotation.NonNull android.media.AudioManager.AudioRecordingCallback cb, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Unregister an audio recording callback previously registered with
 * {@link #registerAudioRecordingCallback(android.media.AudioManager.AudioRecordingCallback,android.os.Handler)}.
 * @param cb non-null callback to unregister
 
 * This value must never be {@code null}.
 * @apiSince 24
 */

public void unregisterAudioRecordingCallback(@androidx.annotation.NonNull android.media.AudioManager.AudioRecordingCallback cb) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current active audio recording configurations of the device.
 * @return a non-null list of recording configurations. An empty list indicates there is
 *     no recording active when queried.
 * @see android.media.AudioRecordingConfiguration
 * @apiSince 24
 */

@androidx.annotation.NonNull
public java.util.List<android.media.AudioRecordingConfiguration> getActiveRecordingConfigurations() { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of the property with the specified key.
 * @param key One of the strings corresponding to a property key: either
 *            {@link #PROPERTY_OUTPUT_SAMPLE_RATE},
 *            {@link #PROPERTY_OUTPUT_FRAMES_PER_BUFFER},
 *            {@link #PROPERTY_SUPPORT_MIC_NEAR_ULTRASOUND},
 *            {@link #PROPERTY_SUPPORT_SPEAKER_NEAR_ULTRASOUND}, or
 *            {@link #PROPERTY_SUPPORT_AUDIO_SOURCE_UNPROCESSED}.
 * @return A string representing the associated value for that property key,
 *         or null if there is no value for that key.
 * @apiSince 17
 */

public java.lang.String getProperty(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns an array of {@link android.media.AudioDeviceInfo AudioDeviceInfo} objects corresponding to the audio devices
 * currently connected to the system and meeting the criteria specified in the
 * <code>flags</code> parameter.
 * @param flags A set of bitflags specifying the criteria to test.
 * @see #GET_DEVICES_OUTPUTS
 * @see #GET_DEVICES_INPUTS
 * @see #GET_DEVICES_ALL
 * @return A (possibly zero-length) array of AudioDeviceInfo objects.
 * @apiSince 23
 */

public android.media.AudioDeviceInfo[] getDevices(int flags) { throw new RuntimeException("Stub!"); }

/**
 * Registers an {@link android.media.AudioDeviceCallback AudioDeviceCallback} object to receive notifications of changes
 * to the set of connected audio devices.
 * @param callback The {@link android.media.AudioDeviceCallback AudioDeviceCallback} object to receive connect/disconnect
 * notifications.
 * @param handler Specifies the {@link android.os.Handler Handler} object for the thread on which to execute
 * the callback. If <code>null</code>, the {@link android.os.Handler Handler} associated with the main
 * {@link android.os.Looper Looper} will be used.
 * @apiSince 23
 */

public void registerAudioDeviceCallback(android.media.AudioDeviceCallback callback, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters an {@link android.media.AudioDeviceCallback AudioDeviceCallback} object which has been previously registered
 * to receive notifications of changes to the set of connected audio devices.
 * @param callback The {@link android.media.AudioDeviceCallback AudioDeviceCallback} object that was previously registered
 * with {@link android.media.AudioManager#registerAudioDeviceCallback AudioManager#registerAudioDeviceCallback} to be unregistered.
 * @apiSince 23
 */

public void unregisterAudioDeviceCallback(android.media.AudioDeviceCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of {@link android.media.MicrophoneInfo MicrophoneInfo} that corresponds to the characteristics
 * of all available microphones. The list is empty when no microphones are available
 * on the device. An error during the query will result in an IOException being thrown.
 *
 * @return a list that contains all microphones' characteristics
 * @throws java.io.IOException if an error occurs.
 * @apiSince 28
 */

public java.util.List<android.media.MicrophoneInfo> getMicrophones() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Return if audio haptic coupled playback is supported or not.
 *
 * @return whether audio haptic playback supported.
 * @apiSince 29
 */

public static boolean isHapticPlaybackSupported() { throw new RuntimeException("Stub!"); }

/**
 * Broadcast intent, a hint for applications that audio is about to become
 * 'noisy' due to a change in audio outputs. For example, this intent may
 * be sent when a wired headset is unplugged, or when an A2DP audio
 * sink is disconnected, and the audio system is about to automatically
 * switch audio route to the speaker. Applications that are controlling
 * audio streams may consider pausing, reducing volume or some other action
 * on receipt of this intent so as not to surprise the user with audio
 * from the speaker.
 * @apiSince 3
 */

public static final java.lang.String ACTION_AUDIO_BECOMING_NOISY = "android.media.AUDIO_BECOMING_NOISY";

/**
 * Broadcast Action: A sticky broadcast indicating an HDMI cable was plugged or unplugged.
 *
 * The intent will have the following extra values: {@link #EXTRA_AUDIO_PLUG_STATE},
 * {@link #EXTRA_MAX_CHANNEL_COUNT}, {@link #EXTRA_ENCODINGS}.
 * <p>It can only be received by explicitly registering for it with
 * {@link android.content.Context#registerReceiver(BroadcastReceiver,IntentFilter) Context#registerReceiver(BroadcastReceiver, IntentFilter)}.
 * @apiSince 21
 */

public static final java.lang.String ACTION_HDMI_AUDIO_PLUG = "android.media.action.HDMI_AUDIO_PLUG";

/**
 * Broadcast Action: Wired Headset plugged in or unplugged.
 *
 * You <em>cannot</em> receive this through components declared
 * in manifests, only by explicitly registering for it with
 * {@link android.content.Context#registerReceiver(BroadcastReceiver,IntentFilter) Context#registerReceiver(BroadcastReceiver, IntentFilter)}.
 *
 * <p>The intent will have the following extra values:
 * <ul>
 *   <li><em>state</em> - 0 for unplugged, 1 for plugged. </li>
 *   <li><em>name</em> - Headset type, human readable string </li>
 *   <li><em>microphone</em> - 1 if headset has a microphone, 0 otherwise </li>
 * </ul>
 * </ul>
 * @apiSince 21
 */

public static final java.lang.String ACTION_HEADSET_PLUG = "android.intent.action.HEADSET_PLUG";

/**
 * Broadcast Action: microphone muting state changed.
 *
 * You <em>cannot</em> receive this through components declared
 * in manifests, only by explicitly registering for it with
 * {@link android.content.Context#registerReceiver(BroadcastReceiver,IntentFilter) Context#registerReceiver(BroadcastReceiver, IntentFilter)}.
 *
 * <p>The intent has no extra values, use {@link #isMicrophoneMute} to check whether the
 * microphone is muted.
 * @apiSince 28
 */

public static final java.lang.String ACTION_MICROPHONE_MUTE_CHANGED = "android.media.action.MICROPHONE_MUTE_CHANGED";

/**
 * Sticky broadcast intent action indicating that the Bluetooth SCO audio
 * connection state has changed. The intent contains on extra {@link #EXTRA_SCO_AUDIO_STATE}
 * indicating the new state which is either {@link #SCO_AUDIO_STATE_DISCONNECTED}
 * or {@link #SCO_AUDIO_STATE_CONNECTED}
 *
 * @see #startBluetoothSco()
 * @deprecated Use  {@link #ACTION_SCO_AUDIO_STATE_UPDATED} instead
 * @apiSince 8
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String ACTION_SCO_AUDIO_STATE_CHANGED = "android.media.SCO_AUDIO_STATE_CHANGED";

/**
 * Sticky broadcast intent action indicating that the Bluetooth SCO audio
 * connection state has been updated.
 * <p>This intent has two extras:
 * <ul>
 *   <li> {@link #EXTRA_SCO_AUDIO_STATE} - The new SCO audio state. </li>
 *   <li> {@link #EXTRA_SCO_AUDIO_PREVIOUS_STATE}- The previous SCO audio state. </li>
 * </ul>
 * <p> EXTRA_SCO_AUDIO_STATE or EXTRA_SCO_AUDIO_PREVIOUS_STATE can be any of:
 * <ul>
 *   <li> {@link #SCO_AUDIO_STATE_DISCONNECTED}, </li>
 *   <li> {@link #SCO_AUDIO_STATE_CONNECTING} or </li>
 *   <li> {@link #SCO_AUDIO_STATE_CONNECTED}, </li>
 * </ul>
 * @see #startBluetoothSco()
 * @apiSince 14
 */

public static final java.lang.String ACTION_SCO_AUDIO_STATE_UPDATED = "android.media.ACTION_SCO_AUDIO_STATE_UPDATED";

/**
 * Broadcast Action: speakerphone state changed.
 *
 * You <em>cannot</em> receive this through components declared
 * in manifests, only by explicitly registering for it with
 * {@link android.content.Context#registerReceiver(BroadcastReceiver,IntentFilter) Context#registerReceiver(BroadcastReceiver, IntentFilter)}.
 *
 * <p>The intent has no extra values, use {@link #isSpeakerphoneOn} to check whether the
 * speakerphone functionality is enabled or not.
 * @apiSince 29
 */

public static final java.lang.String ACTION_SPEAKERPHONE_STATE_CHANGED = "android.media.action.SPEAKERPHONE_STATE_CHANGED";

/**
 * Decrease the ringer volume.
 *
 * @see #adjustVolume(int, int)
 * @see #adjustStreamVolume(int, int, int)
 * @apiSince 1
 */

public static final int ADJUST_LOWER = -1; // 0xffffffff

/**
 * Mute the volume. Has no effect if the stream is already muted.
 *
 * @see #adjustVolume(int, int)
 * @see #adjustStreamVolume(int, int, int)
 * @apiSince 23
 */

public static final int ADJUST_MUTE = -100; // 0xffffff9c

/**
 * Increase the ringer volume.
 *
 * @see #adjustVolume(int, int)
 * @see #adjustStreamVolume(int, int, int)
 * @apiSince 1
 */

public static final int ADJUST_RAISE = 1; // 0x1

/**
 * Maintain the previous ringer volume. This may be useful when needing to
 * show the volume toast without actually modifying the volume.
 *
 * @see #adjustVolume(int, int)
 * @see #adjustStreamVolume(int, int, int)
 * @apiSince 1
 */

public static final int ADJUST_SAME = 0; // 0x0

/**
 * Toggle the mute state. If muted the stream will be unmuted. If not muted
 * the stream will be muted.
 *
 * @see #adjustVolume(int, int)
 * @see #adjustStreamVolume(int, int, int)
 * @apiSince 23
 */

public static final int ADJUST_TOGGLE_MUTE = 101; // 0x65

/**
 * Unmute the volume. Has no effect if the stream is not muted.
 *
 * @see #adjustVolume(int, int)
 * @see #adjustStreamVolume(int, int, int)
 * @apiSince 23
 */

public static final int ADJUST_UNMUTE = 100; // 0x64

/**
 * Used to indicate a gain of audio focus, or a request of audio focus, of unknown duration.
 * @see android.media.AudioManager.OnAudioFocusChangeListener#onAudioFocusChange(int)
 * @see #requestAudioFocus(OnAudioFocusChangeListener, int, int)
 * @apiSince 8
 */

public static final int AUDIOFOCUS_GAIN = 1; // 0x1

/**
 * Used to indicate a temporary gain or request of audio focus, anticipated to last a short
 * amount of time. Examples of temporary changes are the playback of driving directions, or an
 * event notification.
 * @see android.media.AudioManager.OnAudioFocusChangeListener#onAudioFocusChange(int)
 * @see #requestAudioFocus(OnAudioFocusChangeListener, int, int)
 * @apiSince 8
 */

public static final int AUDIOFOCUS_GAIN_TRANSIENT = 2; // 0x2

/**
 * Used to indicate a temporary request of audio focus, anticipated to last a short
 * amount of time, during which no other applications, or system components, should play
 * anything. Examples of exclusive and transient audio focus requests are voice
 * memo recording and speech recognition, during which the system shouldn't play any
 * notifications, and media playback should have paused.
 * @see #requestAudioFocus(OnAudioFocusChangeListener, int, int)
 * @apiSince 19
 */

public static final int AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE = 4; // 0x4

/**
 * Used to indicate a temporary request of audio focus, anticipated to last a short
 * amount of time, and where it is acceptable for other audio applications to keep playing
 * after having lowered their output level (also referred to as "ducking").
 * Examples of temporary changes are the playback of driving directions where playback of music
 * in the background is acceptable.
 * @see android.media.AudioManager.OnAudioFocusChangeListener#onAudioFocusChange(int)
 * @see #requestAudioFocus(OnAudioFocusChangeListener, int, int)
 * @apiSince 8
 */

public static final int AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK = 3; // 0x3

/**
 * Used to indicate a loss of audio focus of unknown duration.
 * @see android.media.AudioManager.OnAudioFocusChangeListener#onAudioFocusChange(int)
 * @apiSince 8
 */

public static final int AUDIOFOCUS_LOSS = -1; // 0xffffffff

/**
 * Used to indicate a transient loss of audio focus.
 * @see android.media.AudioManager.OnAudioFocusChangeListener#onAudioFocusChange(int)
 * @apiSince 8
 */

public static final int AUDIOFOCUS_LOSS_TRANSIENT = -2; // 0xfffffffe

/**
 * Used to indicate a transient loss of audio focus where the loser of the audio focus can
 * lower its output volume if it wants to continue playing (also referred to as "ducking"), as
 * the new focus owner doesn't require others to be silent.
 * @see android.media.AudioManager.OnAudioFocusChangeListener#onAudioFocusChange(int)
 * @apiSince 8
 */

public static final int AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK = -3; // 0xfffffffd

/**
 * Used to indicate no audio focus has been gained or lost, or requested.
 * @apiSince 26
 */

public static final int AUDIOFOCUS_NONE = 0; // 0x0

/**
 * A focus change request whose granting is delayed: the request was successful, but the
 * requester will only be granted audio focus once the condition that prevented immediate
 * granting has ended.
 * See {@link #requestAudioFocus(android.media.AudioFocusRequest)} and
 * {@link android.media.AudioFocusRequest.Builder#setAcceptsDelayedFocusGain(boolean) AudioFocusRequest.Builder#setAcceptsDelayedFocusGain(boolean)}
 * @apiSince 26
 */

public static final int AUDIOFOCUS_REQUEST_DELAYED = 2; // 0x2

/**
 * A failed focus change request.
 * @apiSince 8
 */

public static final int AUDIOFOCUS_REQUEST_FAILED = 0; // 0x0

/**
 * A successful focus change request.
 * @apiSince 8
 */

public static final int AUDIOFOCUS_REQUEST_GRANTED = 1; // 0x1

/**
 * A special audio session ID to indicate that the audio session ID isn't known and the
 * framework should generate a new value. This can be used when building a new
 * {@link android.media.AudioTrack AudioTrack} instance with
 * {@link android.media.AudioTrack#AudioTrack(android.media.AudioAttributes,android.media.AudioFormat,int,int,int) AudioTrack#AudioTrack(AudioAttributes, AudioFormat, int, int, int)}.
 * @apiSince 21
 */

public static final int AUDIO_SESSION_ID_GENERATE = 0; // 0x0

/**
 * A default error code.
 * @apiSince 21
 */

public static final int ERROR = -1; // 0xffffffff

/**
 * An error code indicating that the object reporting it is no longer valid and needs to
 * be recreated.
 * @apiSince 21
 */

public static final int ERROR_DEAD_OBJECT = -6; // 0xfffffffa

/**
 * Extra used in {@link #ACTION_HDMI_AUDIO_PLUG} to communicate whether HDMI is plugged in
 * or unplugged.
 * An integer value of 1 indicates a plugged-in state, 0 is unplugged.
 * @apiSince 21
 */

public static final java.lang.String EXTRA_AUDIO_PLUG_STATE = "android.media.extra.AUDIO_PLUG_STATE";

/**
 * Extra used in {@link #ACTION_HDMI_AUDIO_PLUG} to define the audio encodings supported by
 * the connected HDMI device.
 * The corresponding array of encoding values is only available when the device is plugged in
 * (as expressed by {@link #EXTRA_AUDIO_PLUG_STATE}). Encoding values are defined in
 * {@link android.media.AudioFormat AudioFormat} (for instance see {@link android.media.AudioFormat#ENCODING_PCM_16BIT AudioFormat#ENCODING_PCM_16BIT}). Use
 * {@link android.content.Intent#getIntArrayExtra(String)} to retrieve the encoding values.
 * @apiSince 21
 */

public static final java.lang.String EXTRA_ENCODINGS = "android.media.extra.ENCODINGS";

/**
 * Extra used in {@link #ACTION_HDMI_AUDIO_PLUG} to define the maximum number of channels
 * supported by the HDMI device.
 * The corresponding integer value is only available when the device is plugged in (as expressed
 * by {@link #EXTRA_AUDIO_PLUG_STATE}).
 * @apiSince 21
 */

public static final java.lang.String EXTRA_MAX_CHANNEL_COUNT = "android.media.extra.MAX_CHANNEL_COUNT";

/**
 * The new ringer mode.
 *
 * @see #RINGER_MODE_CHANGED_ACTION
 * @see #RINGER_MODE_NORMAL
 * @see #RINGER_MODE_SILENT
 * @see #RINGER_MODE_VIBRATE
 * @apiSince 1
 */

public static final java.lang.String EXTRA_RINGER_MODE = "android.media.EXTRA_RINGER_MODE";

/**
 * Extra for intent {@link #ACTION_SCO_AUDIO_STATE_UPDATED} containing the previous
 * bluetooth SCO connection state.
 * @apiSince 14
 */

public static final java.lang.String EXTRA_SCO_AUDIO_PREVIOUS_STATE = "android.media.extra.SCO_AUDIO_PREVIOUS_STATE";

/**
 * Extra for intent {@link #ACTION_SCO_AUDIO_STATE_CHANGED} or
 * {@link #ACTION_SCO_AUDIO_STATE_UPDATED} containing the new bluetooth SCO connection state.
 * @apiSince 8
 */

public static final java.lang.String EXTRA_SCO_AUDIO_STATE = "android.media.extra.SCO_AUDIO_STATE";

/**
 * The new vibrate setting for a particular type.
 *
 * @see #VIBRATE_SETTING_CHANGED_ACTION
 * @see #EXTRA_VIBRATE_TYPE
 * @see #VIBRATE_SETTING_ON
 * @see #VIBRATE_SETTING_OFF
 * @see #VIBRATE_SETTING_ONLY_SILENT
 * @deprecated Applications should maintain their own vibrate policy based on
 * current ringer mode and listen to {@link #RINGER_MODE_CHANGED_ACTION} instead.
 * @apiSince 1
 * @deprecatedSince 16
 */

@Deprecated public static final java.lang.String EXTRA_VIBRATE_SETTING = "android.media.EXTRA_VIBRATE_SETTING";

/**
 * The vibrate type whose setting has changed.
 *
 * @see #VIBRATE_SETTING_CHANGED_ACTION
 * @see #VIBRATE_TYPE_NOTIFICATION
 * @see #VIBRATE_TYPE_RINGER
 * @deprecated Applications should maintain their own vibrate policy based on
 * current ringer mode and listen to {@link #RINGER_MODE_CHANGED_ACTION} instead.
 * @apiSince 1
 * @deprecatedSince 16
 */

@Deprecated public static final java.lang.String EXTRA_VIBRATE_TYPE = "android.media.EXTRA_VIBRATE_TYPE";

/**
 * Whether to include ringer modes as possible options when changing volume.
 * For example, if true and volume level is 0 and the volume is adjusted
 * with {@link #ADJUST_LOWER}, then the ringer mode may switch the silent or
 * vibrate mode.
 * <p>
 * By default this is on for the ring stream. If this flag is included,
 * this behavior will be present regardless of the stream type being
 * affected by the ringer mode.
 *
 * @see #adjustVolume(int, int)
 * @see #adjustStreamVolume(int, int, int)
 * @apiSince 1
 */

public static final int FLAG_ALLOW_RINGER_MODES = 2; // 0x2

/**
 * Whether to play a sound when changing the volume.
 * <p>
 * If this is given to {@link #adjustVolume(int,int)} or
 * {@link #adjustSuggestedStreamVolume(int,int,int)}, it may be ignored
 * in some cases (for example, the decided stream type is not
 * {@link android.media.AudioManager#STREAM_RING AudioManager#STREAM_RING}, or the volume is being adjusted
 * downward).
 *
 * @see #adjustStreamVolume(int, int, int)
 * @see #adjustVolume(int, int)
 * @see #setStreamVolume(int, int, int)
 * @apiSince 1
 */

public static final int FLAG_PLAY_SOUND = 4; // 0x4

/**
 * Removes any sounds/vibrate that may be in the queue, or are playing (related to
 * changing volume).
 * @apiSince 1
 */

public static final int FLAG_REMOVE_SOUND_AND_VIBRATE = 8; // 0x8

/**
 * Show a toast containing the current volume.
 *
 * @see #adjustStreamVolume(int, int, int)
 * @see #adjustVolume(int, int)
 * @see #setStreamVolume(int, int, int)
 * @see #setRingerMode(int)
 * @apiSince 1
 */

public static final int FLAG_SHOW_UI = 1; // 0x1

/**
 * Whether to vibrate if going into the vibrate ringer mode.
 * @apiSince 1
 */

public static final int FLAG_VIBRATE = 16; // 0x10

/**
 * Focus has moved down
 * @see #playSoundEffect(int)
 * @apiSince 1
 */

public static final int FX_FOCUS_NAVIGATION_DOWN = 2; // 0x2

/**
 * Focus has moved left
 * @see #playSoundEffect(int)
 * @apiSince 1
 */

public static final int FX_FOCUS_NAVIGATION_LEFT = 3; // 0x3

/**
 * Focus has moved right
 * @see #playSoundEffect(int)
 * @apiSince 1
 */

public static final int FX_FOCUS_NAVIGATION_RIGHT = 4; // 0x4

/**
 * Focus has moved up
 * @see #playSoundEffect(int)
 * @apiSince 1
 */

public static final int FX_FOCUS_NAVIGATION_UP = 1; // 0x1

/**
 * IME delete keypress sound
 * @see #playSoundEffect(int)
 * @apiSince 3
 */

public static final int FX_KEYPRESS_DELETE = 7; // 0x7

/**
 * Invalid keypress sound
 * @see #playSoundEffect(int)
 * @apiSince 19
 */

public static final int FX_KEYPRESS_INVALID = 9; // 0x9

/**
 * IME return_keypress sound
 * @see #playSoundEffect(int)
 * @apiSince 3
 */

public static final int FX_KEYPRESS_RETURN = 8; // 0x8

/**
 * IME spacebar keypress sound
 * @see #playSoundEffect(int)
 * @apiSince 3
 */

public static final int FX_KEYPRESS_SPACEBAR = 6; // 0x6

/**
 * IME standard keypress sound
 * @see #playSoundEffect(int)
 * @apiSince 3
 */

public static final int FX_KEYPRESS_STANDARD = 5; // 0x5

/**
 * Keyboard and direction pad click sound
 * @see #playSoundEffect(int)
 * @apiSince 1
 */

public static final int FX_KEY_CLICK = 0; // 0x0

/**
 * Specifies to the {@link android.media.AudioManager#getDevices(int) AudioManager#getDevices(int)} method to include both
 * source and sink devices.
 * @apiSince 23
 */

public static final int GET_DEVICES_ALL = 3; // 0x3

/**
 * Specifies to the {@link android.media.AudioManager#getDevices(int) AudioManager#getDevices(int)} method to include
 * source (i.e. input) audio devices.
 * @apiSince 23
 */

public static final int GET_DEVICES_INPUTS = 1; // 0x1

/**
 * Specifies to the {@link android.media.AudioManager#getDevices(int) AudioManager#getDevices(int)} method to include
 * sink (i.e. output) audio devices.
 * @apiSince 23
 */

public static final int GET_DEVICES_OUTPUTS = 2; // 0x2

/**
 * Current audio mode. Used to apply audio routing to current mode.
 * @apiSince 1
 */

public static final int MODE_CURRENT = -1; // 0xffffffff

/**
 * Invalid audio mode.
 * @apiSince 1
 */

public static final int MODE_INVALID = -2; // 0xfffffffe

/**
 * In call audio mode. A telephony call is established.
 * @apiSince 1
 */

public static final int MODE_IN_CALL = 2; // 0x2

/**
 * In communication audio mode. An audio/video chat or VoIP call is established.
 * @apiSince 11
 */

public static final int MODE_IN_COMMUNICATION = 3; // 0x3

/**
 * Normal audio mode: not ringing and no call established.
 * @apiSince 1
 */

public static final int MODE_NORMAL = 0; // 0x0

/**
 * Ringing audio mode. An incoming is being signaled.
 * @apiSince 1
 */

public static final int MODE_RINGTONE = 1; // 0x1

/**
 * @deprecated Do not iterate on volume stream type values.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int NUM_STREAMS = 5; // 0x5

/**
 * Used as a key for {@link #getProperty} to request the native or optimal output buffer size
 * for this device's low latency output stream, in decimal PCM frames.  Latency-sensitive apps
 * should use this value as a minimum, and offer the user the option to override it.
 * The low latency output stream is typically either the device's primary output stream,
 * or another output stream with smaller buffers.
 * @apiSince 17
 */

public static final java.lang.String PROPERTY_OUTPUT_FRAMES_PER_BUFFER = "android.media.property.OUTPUT_FRAMES_PER_BUFFER";

/**
 * Used as a key for {@link #getProperty} to request the native or optimal output sample rate
 * for this device's low latency output stream, in decimal Hz.  Latency-sensitive apps
 * should use this value as a default, and offer the user the option to override it.
 * The low latency output stream is typically either the device's primary output stream,
 * or another output stream with smaller buffers.
 * @apiSince 17
 */

public static final java.lang.String PROPERTY_OUTPUT_SAMPLE_RATE = "android.media.property.OUTPUT_SAMPLE_RATE";

/**
 * Used as a key for {@link #getProperty} to determine if the unprocessed audio source is
 * available and supported with the expected frequency range and level response.
 * @apiSince 24
 */

public static final java.lang.String PROPERTY_SUPPORT_AUDIO_SOURCE_UNPROCESSED = "android.media.property.SUPPORT_AUDIO_SOURCE_UNPROCESSED";

/**
 * Used as a key for {@link #getProperty} to determine if the default microphone audio source
 * supports near-ultrasound frequencies (range of 18 - 21 kHz).
 * @apiSince 23
 */

public static final java.lang.String PROPERTY_SUPPORT_MIC_NEAR_ULTRASOUND = "android.media.property.SUPPORT_MIC_NEAR_ULTRASOUND";

/**
 * Used as a key for {@link #getProperty} to determine if the default speaker audio path
 * supports near-ultrasound frequencies (range of 18 - 21 kHz).
 * @apiSince 23
 */

public static final java.lang.String PROPERTY_SUPPORT_SPEAKER_NEAR_ULTRASOUND = "android.media.property.SUPPORT_SPEAKER_NEAR_ULTRASOUND";

/**
 * Sticky broadcast intent action indicating that the ringer mode has
 * changed. Includes the new ringer mode.
 *
 * @see #EXTRA_RINGER_MODE
 * @apiSince 1
 */

public static final java.lang.String RINGER_MODE_CHANGED_ACTION = "android.media.RINGER_MODE_CHANGED";

/**
 * Ringer mode that may be audible and may vibrate. It will be audible if
 * the volume before changing out of this mode was audible. It will vibrate
 * if the vibrate setting is on.
 *
 * @see #setRingerMode(int)
 * @see #getRingerMode()
 * @apiSince 1
 */

public static final int RINGER_MODE_NORMAL = 2; // 0x2

/**
 * Ringer mode that will be silent and will not vibrate. (This overrides the
 * vibrate setting.)
 *
 * @see #setRingerMode(int)
 * @see #getRingerMode()
 * @apiSince 1
 */

public static final int RINGER_MODE_SILENT = 0; // 0x0

/**
 * Ringer mode that will be silent and will vibrate. (This will cause the
 * phone ringer to always vibrate, but the notification vibrate to only
 * vibrate if set.)
 *
 * @see #setRingerMode(int)
 * @see #getRingerMode()
 * @apiSince 1
 */

public static final int RINGER_MODE_VIBRATE = 1; // 0x1

/**
 * Used for mask parameter of {@link #setRouting(int,int,int)}.
 * @deprecated   Do not set audio routing directly, use setSpeakerphoneOn(),
 * setBluetoothScoOn() methods instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int ROUTE_ALL = -1; // 0xffffffff

/**
 * @deprecated use {@link #ROUTE_BLUETOOTH_SCO}
 * @deprecated   Do not set audio routing directly, use setSpeakerphoneOn(),
 * setBluetoothScoOn() methods instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int ROUTE_BLUETOOTH = 4; // 0x4

/**
 * Routing audio output to bluetooth A2DP
 * @deprecated   Do not set audio routing directly, use setSpeakerphoneOn(),
 * setBluetoothScoOn() methods instead.
 * @apiSince 3
 * @deprecatedSince 15
 */

@Deprecated public static final int ROUTE_BLUETOOTH_A2DP = 16; // 0x10

/**
 * Routing audio output to bluetooth SCO
 * @deprecated   Do not set audio routing directly, use setSpeakerphoneOn(),
 * setBluetoothScoOn() methods instead.
 * @apiSince 3
 * @deprecatedSince 15
 */

@Deprecated public static final int ROUTE_BLUETOOTH_SCO = 4; // 0x4

/**
 * Routing audio output to earpiece
 * @deprecated   Do not set audio routing directly, use setSpeakerphoneOn(),
 * setBluetoothScoOn() methods instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int ROUTE_EARPIECE = 1; // 0x1

/**
 * Routing audio output to headset
 * @deprecated   Do not set audio routing directly, use setSpeakerphoneOn(),
 * setBluetoothScoOn() methods instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int ROUTE_HEADSET = 8; // 0x8

/**
 * Routing audio output to speaker
 * @deprecated   Do not set audio routing directly, use setSpeakerphoneOn(),
 * setBluetoothScoOn() methods instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int ROUTE_SPEAKER = 2; // 0x2

/**
 * Value for extra {@link #EXTRA_SCO_AUDIO_STATE} or {@link #EXTRA_SCO_AUDIO_PREVIOUS_STATE}
 * indicating that the SCO audio channel is established
 * @apiSince 8
 */

public static final int SCO_AUDIO_STATE_CONNECTED = 1; // 0x1

/**
 * Value for extra EXTRA_SCO_AUDIO_STATE or EXTRA_SCO_AUDIO_PREVIOUS_STATE
 * indicating that the SCO audio channel is being established
 * @apiSince 14
 */

public static final int SCO_AUDIO_STATE_CONNECTING = 2; // 0x2

/**
 * Value for extra EXTRA_SCO_AUDIO_STATE or EXTRA_SCO_AUDIO_PREVIOUS_STATE
 * indicating that the SCO audio channel is not established
 * @apiSince 8
 */

public static final int SCO_AUDIO_STATE_DISCONNECTED = 0; // 0x0

/**
 * Value for extra EXTRA_SCO_AUDIO_STATE indicating that
 * there was an error trying to obtain the state
 * @apiSince 8
 */

public static final int SCO_AUDIO_STATE_ERROR = -1; // 0xffffffff

/**
 * Used to identify the volume of audio streams for accessibility prompts
 * @apiSince 26
 */

public static final int STREAM_ACCESSIBILITY = 10; // 0xa

/**
 * Used to identify the volume of audio streams for alarms
 * @apiSince 1
 */

public static final int STREAM_ALARM = 4; // 0x4

/**
 * Used to identify the volume of audio streams for DTMF Tones
 * @apiSince 5
 */

public static final int STREAM_DTMF = 8; // 0x8

/**
 * Used to identify the volume of audio streams for music playback
 * @apiSince 1
 */

public static final int STREAM_MUSIC = 3; // 0x3

/**
 * Used to identify the volume of audio streams for notifications
 * @apiSince 3
 */

public static final int STREAM_NOTIFICATION = 5; // 0x5

/**
 * Used to identify the volume of audio streams for the phone ring
 * @apiSince 1
 */

public static final int STREAM_RING = 2; // 0x2

/**
 * Used to identify the volume of audio streams for system sounds
 * @apiSince 1
 */

public static final int STREAM_SYSTEM = 1; // 0x1

/**
 * Used to identify the volume of audio streams for phone calls
 * @apiSince 1
 */

public static final int STREAM_VOICE_CALL = 0; // 0x0

/**
 * Suggests using the default stream type. This may not be used in all
 * places a stream type is needed.
 * @apiSince 1
 */

public static final int USE_DEFAULT_STREAM_TYPE = -2147483648; // 0x80000000

/**
 * Broadcast intent action indicating that the vibrate setting has
 * changed. Includes the vibrate type and its new setting.
 *
 * @see #EXTRA_VIBRATE_TYPE
 * @see #EXTRA_VIBRATE_SETTING
 * @deprecated Applications should maintain their own vibrate policy based on
 * current ringer mode and listen to {@link #RINGER_MODE_CHANGED_ACTION} instead.
 * @apiSince 1
 * @deprecatedSince 16
 */

@Deprecated public static final java.lang.String VIBRATE_SETTING_CHANGED_ACTION = "android.media.VIBRATE_SETTING_CHANGED";

/**
 * Vibrate setting that suggests to never vibrate.
 *
 * @see #setVibrateSetting(int, int)
 * @see #getVibrateSetting(int)
 * @deprecated Applications should maintain their own vibrate policy based on
 * current ringer mode that can be queried via {@link #getRingerMode()}.
 * @apiSince 1
 * @deprecatedSince 16
 */

@Deprecated public static final int VIBRATE_SETTING_OFF = 0; // 0x0

/**
 * Vibrate setting that suggests to vibrate when possible.
 *
 * @see #setVibrateSetting(int, int)
 * @see #getVibrateSetting(int)
 * @deprecated Applications should maintain their own vibrate policy based on
 * current ringer mode that can be queried via {@link #getRingerMode()}.
 * @apiSince 1
 * @deprecatedSince 16
 */

@Deprecated public static final int VIBRATE_SETTING_ON = 1; // 0x1

/**
 * Vibrate setting that suggests to only vibrate when in the vibrate ringer
 * mode.
 *
 * @see #setVibrateSetting(int, int)
 * @see #getVibrateSetting(int)
 * @deprecated Applications should maintain their own vibrate policy based on
 * current ringer mode that can be queried via {@link #getRingerMode()}.
 * @apiSince 1
 * @deprecatedSince 16
 */

@Deprecated public static final int VIBRATE_SETTING_ONLY_SILENT = 2; // 0x2

/**
 * Vibrate type that corresponds to notifications.
 *
 * @see #setVibrateSetting(int, int)
 * @see #getVibrateSetting(int)
 * @see #shouldVibrate(int)
 * @deprecated Applications should maintain their own vibrate policy based on
 * current ringer mode that can be queried via {@link #getRingerMode()}.
 * @apiSince 1
 * @deprecatedSince 16
 */

@Deprecated public static final int VIBRATE_TYPE_NOTIFICATION = 1; // 0x1

/**
 * Vibrate type that corresponds to the ringer.
 *
 * @see #setVibrateSetting(int, int)
 * @see #getVibrateSetting(int)
 * @see #shouldVibrate(int)
 * @deprecated Applications should maintain their own vibrate policy based on
 * current ringer mode that can be queried via {@link #getRingerMode()}.
 * @apiSince 1
 * @deprecatedSince 16
 */

@Deprecated public static final int VIBRATE_TYPE_RINGER = 0; // 0x0
/**
 * Interface for receiving update notifications about the playback activity on the system.
 * Extend this abstract class and register it with
 * {@link android.media.AudioManager#registerAudioPlaybackCallback(android.media.AudioManager.AudioPlaybackCallback,android.os.Handler) AudioManager#registerAudioPlaybackCallback(AudioPlaybackCallback, Handler)}
 * to be notified.
 * Use {@link android.media.AudioManager#getActivePlaybackConfigurations() AudioManager#getActivePlaybackConfigurations()} to query the current
 * configuration.
 * @see android.media.AudioPlaybackConfiguration
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class AudioPlaybackCallback {

public AudioPlaybackCallback() { throw new RuntimeException("Stub!"); }

/**
 * Called whenever the playback activity and configuration has changed.
 * @param configs list containing the results of
 *      {@link android.media.AudioManager#getActivePlaybackConfigurations() AudioManager#getActivePlaybackConfigurations()}.
 * @apiSince 26
 */

public void onPlaybackConfigChanged(java.util.List<android.media.AudioPlaybackConfiguration> configs) { throw new RuntimeException("Stub!"); }
}

/**
 * Interface for receiving update notifications about the recording configuration. Extend
 * this abstract class and register it with
 * {@link android.media.AudioManager#registerAudioRecordingCallback(android.media.AudioManager.AudioRecordingCallback,android.os.Handler) AudioManager#registerAudioRecordingCallback(AudioRecordingCallback, Handler)}
 * to be notified.
 * Use {@link android.media.AudioManager#getActiveRecordingConfigurations() AudioManager#getActiveRecordingConfigurations()} to query the current
 * configuration.
 * @see android.media.AudioRecordingConfiguration
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class AudioRecordingCallback {

public AudioRecordingCallback() { throw new RuntimeException("Stub!"); }

/**
 * Called whenever the device recording configuration has changed.
 * @param configs list containing the results of
 *      {@link android.media.AudioManager#getActiveRecordingConfigurations() AudioManager#getActiveRecordingConfigurations()}.
 * @apiSince 24
 */

public void onRecordingConfigChanged(java.util.List<android.media.AudioRecordingConfiguration> configs) { throw new RuntimeException("Stub!"); }
}

/**
 * Interface definition for a callback to be invoked when the audio focus of the system is
 * updated.
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnAudioFocusChangeListener {

/**
 * Called on the listener to notify it the audio focus for this listener has been changed.
 * The focusChange value indicates whether the focus was gained,
 * whether the focus was lost, and whether that loss is transient, or whether the new focus
 * holder will hold it for an unknown amount of time.
 * When losing focus, listeners can use the focus change information to decide what
 * behavior to adopt when losing focus. A music player could for instance elect to lower
 * the volume of its music stream (duck) for transient focus losses, and pause otherwise.
 * @param focusChange the type of focus change, one of {@link android.media.AudioManager#AUDIOFOCUS_GAIN AudioManager#AUDIOFOCUS_GAIN},
 *   {@link android.media.AudioManager#AUDIOFOCUS_LOSS AudioManager#AUDIOFOCUS_LOSS}, {@link android.media.AudioManager#AUDIOFOCUS_LOSS_TRANSIENT AudioManager#AUDIOFOCUS_LOSS_TRANSIENT}
 *   and {@link android.media.AudioManager#AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK AudioManager#AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK}.
 * @apiSince 8
 */

public void onAudioFocusChange(int focusChange);
}

}

