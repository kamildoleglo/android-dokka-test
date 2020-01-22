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


package android.media;

import android.media.session.MediaController;
import android.content.Context;
import android.os.Looper;
import android.view.KeyEvent;
import android.graphics.Bitmap;

/**
 * The RemoteController class is used to control media playback, display and update media metadata
 * and playback status, published by applications using the {@link android.media.RemoteControlClient RemoteControlClient} class.
 * <p>
 * A RemoteController shall be registered through
 * {@link android.media.AudioManager#registerRemoteController(android.media.RemoteController) AudioManager#registerRemoteController(RemoteController)} in order for the system to send
 * media event updates to the {@link android.media.RemoteController.OnClientUpdateListener OnClientUpdateListener} listener set in the class constructor.
 * Implement the methods of the interface to receive the information published by the active
 * {@link android.media.RemoteControlClient RemoteControlClient} instances.
 * <br>By default an {@link android.media.RemoteController.OnClientUpdateListener OnClientUpdateListener} implementation will not receive bitmaps for
 * album art. Use {@link #setArtworkConfiguration(int,int)} to receive images as well.
 * <p>
 * Registration requires the {@link android.media.RemoteController.OnClientUpdateListener OnClientUpdateListener} listener to be one of the enabled
 * notification listeners (see {@link android.service.notification.NotificationListenerService}).
 *
 * @deprecated Use {@link android.media.session.MediaController MediaController} instead.
 * @apiSince 19
 * @deprecatedSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public final class RemoteController {

/**
 * Class constructor.
 * @param context the {@link android.content.Context Context}, must be non-null.
 * @param updateListener the listener to be called whenever new client information is available,
 *     must be non-null.
 * @throws java.lang.IllegalArgumentException
 * @apiSince 19
 */

@Deprecated
public RemoteController(android.content.Context context, android.media.RemoteController.OnClientUpdateListener updateListener) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Class constructor.
 * @param context the {@link android.content.Context Context}, must be non-null.
 * @param updateListener the listener to be called whenever new client information is available,
 *     must be non-null.
 * @param looper the {@link android.os.Looper Looper} on which to run the event loop,
 *     or null to use the current thread's looper.
 * @throws java.lang.IllegalArgumentException
 * @apiSince 19
 */

@Deprecated
public RemoteController(android.content.Context context, android.media.RemoteController.OnClientUpdateListener updateListener, android.os.Looper looper) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Return the estimated playback position of the current media track or a negative value
 * if not available.
 *
 * <p>The value returned is estimated by the current process and may not be perfect.
 * The time returned by this method is calculated from the last state change time based
 * on the current play position at that time and the last known playback speed.
 * An application may call {@link #setSynchronizationMode(int)} to apply
 * a synchronization policy that will periodically re-sync the estimated position
 * with the RemoteControlClient.</p>
 *
 * @return the current estimated playback position in milliseconds or a negative value
 *         if not available
 *
 * @see android.media.RemoteController.OnClientUpdateListener#onClientPlaybackStateUpdate(int, long, long, float)
 * @apiSince 19
 * @deprecatedSince 21
 */

@Deprecated
public long getEstimatedMediaPosition() { throw new RuntimeException("Stub!"); }

/**
 * Send a simulated key event for a media button to be received by the current client.
 * To simulate a key press, you must first send a KeyEvent built with
 * a {@link android.view.KeyEvent#ACTION_DOWN KeyEvent#ACTION_DOWN} action, then another event with the {@link android.view.KeyEvent#ACTION_UP KeyEvent#ACTION_UP}
 * action.
 * <p>The key event will be sent to the registered receiver
 * (see {@link android.media.AudioManager#registerMediaButtonEventReceiver(PendingIntent) AudioManager#registerMediaButtonEventReceiver(PendingIntent)}) whose associated
 * {@link android.media.RemoteControlClient RemoteControlClient}'s metadata and playback state is published (there may be
 * none under some circumstances).
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
 * @return true if the event was successfully sent, false otherwise.
 * @throws java.lang.IllegalArgumentException
 * @apiSince 19
 * @deprecatedSince 21
 */

@Deprecated
public boolean sendMediaKeyEvent(android.view.KeyEvent keyEvent) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Sets the new playback position.
 * This method can only be called on a registered RemoteController.
 * @param timeMs a 0 or positive value for the new playback position, expressed in ms.
 * @return true if the command to set the playback position was successfully sent.
 * @throws java.lang.IllegalArgumentException
 * @apiSince 19
 * @deprecatedSince 21
 */

@Deprecated
public boolean seekTo(long timeMs) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Set the maximum artwork image dimensions to be received in the metadata.
 * No bitmaps will be received unless this has been specified.
 * @param width the maximum width in pixels
 * @param height  the maximum height in pixels
 * @return true if the artwork dimension was successfully set.
 * @throws java.lang.IllegalArgumentException
 * @apiSince 19
 * @deprecatedSince 21
 */

@Deprecated
public boolean setArtworkConfiguration(int width, int height) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Prevents this RemoteController from receiving artwork images.
 * @return true if receiving artwork images was successfully disabled.
 * @apiSince 19
 * @deprecatedSince 21
 */

@Deprecated
public boolean clearArtworkConfiguration() { throw new RuntimeException("Stub!"); }

/**
 * Set the playback position synchronization mode.
 * Must be called on a registered RemoteController.
 * @param sync {@link #POSITION_SYNCHRONIZATION_NONE} or {@link #POSITION_SYNCHRONIZATION_CHECK}
 * @return true if the synchronization mode was successfully set.
 * @throws java.lang.IllegalArgumentException
 * @apiSince 19
 * @deprecatedSince 21
 */

@Deprecated
public boolean setSynchronizationMode(int sync) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link android.media.RemoteController.MetadataEditor MetadataEditor} for updating metadata values of the editable keys of
 * the current {@link android.media.RemoteControlClient RemoteControlClient}.
 * This method can only be called on a registered RemoteController.
 * @return a new MetadataEditor instance.
 * @apiSince 19
 * @deprecatedSince 21
 */

@Deprecated
public android.media.RemoteController.MetadataEditor editMetadata() { throw new RuntimeException("Stub!"); }

/**
 * The playback position synchronization mode where the RemoteControlClient instances which
 * expose their playback position to the framework, will be regularly polled to check
 * whether any drift has been noticed between their estimated position and the one they report.
 * Note that this mode should only ever be used when needing to display very accurate playback
 * position, as regularly polling a RemoteControlClient for its position may have an impact
 * on battery life (if applicable) when this query will trigger network transactions in the
 * case of remote playback.
 * @apiSince 19
 * @deprecatedSince 21
 */

@Deprecated public static final int POSITION_SYNCHRONIZATION_CHECK = 1; // 0x1

/**
 * Default playback position synchronization mode where the RemoteControlClient is not
 * asked regularly for its playback position to see if it has drifted from the estimated
 * position.
 * @apiSince 19
 * @deprecatedSince 21
 */

@Deprecated public static final int POSITION_SYNCHRONIZATION_NONE = 0; // 0x0
/**
 * A class to read the metadata published by a {@link android.media.RemoteControlClient RemoteControlClient}, or send a
 * {@link android.media.RemoteControlClient RemoteControlClient} new values for keys that can be edited.
 * @apiSince 19
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class MetadataEditor extends android.media.MediaMetadataEditor {

MetadataEditor() { throw new RuntimeException("Stub!"); }

/**
 * Applies all of the metadata changes that have been set since the MediaMetadataEditor
 * instance was created with {@link android.media.RemoteController#editMetadata() RemoteController#editMetadata()}
 * or since {@link #clear()} was called.
 * @apiSince 19
 * @deprecatedSince 29
 */

@Deprecated
public synchronized void apply() { throw new RuntimeException("Stub!"); }
}

/**
 * Interface definition for the callbacks to be invoked whenever media events, metadata
 * and playback status are available.
 * @apiSince 19
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface OnClientUpdateListener {

/**
 * Called whenever all information, previously received through the other
 * methods of the listener, is no longer valid and is about to be refreshed.
 * This is typically called whenever a new {@link android.media.RemoteControlClient RemoteControlClient} has been selected
 * by the system to have its media information published.
 * @param clearing true if there is no selected RemoteControlClient and no information
 *     is available.
 * @apiSince 19
 * @deprecatedSince 29
 */

@Deprecated
public void onClientChange(boolean clearing);

/**
 * Called whenever the playback state has changed.
 * It is called when no information is known about the playback progress in the media and
 * the playback speed.
 * @param state one of the playback states authorized
 *     in {@link android.media.RemoteControlClient#setPlaybackState(int) RemoteControlClient#setPlaybackState(int)}.
 * @apiSince 19
 * @deprecatedSince 29
 */

@Deprecated
public void onClientPlaybackStateUpdate(int state);

/**
 * Called whenever the playback state has changed, and playback position
 * and speed are known.
 * @param state one of the playback states authorized
 *     in {@link android.media.RemoteControlClient#setPlaybackState(int) RemoteControlClient#setPlaybackState(int)}.
 * @param stateChangeTimeMs the system time at which the state change was reported,
 *     expressed in ms. Based on {@link android.os.SystemClock#elapsedRealtime()}.
 * @param currentPosMs a positive value for the current media playback position expressed
 *     in ms, a negative value if the position is temporarily unknown.
 * @param speed  a value expressed as a ratio of 1x playback: 1.0f is normal playback,
 *    2.0f is 2x, 0.5f is half-speed, -2.0f is rewind at 2x speed. 0.0f means nothing is
 *    playing (e.g. when state is {@link android.media.RemoteControlClient#PLAYSTATE_ERROR RemoteControlClient#PLAYSTATE_ERROR}).
 * @apiSince 19
 * @deprecatedSince 29
 */

@Deprecated
public void onClientPlaybackStateUpdate(int state, long stateChangeTimeMs, long currentPosMs, float speed);

/**
 * Called whenever the transport control flags have changed.
 * @param transportControlFlags one of the flags authorized
 *     in {@link android.media.RemoteControlClient#setTransportControlFlags(int) RemoteControlClient#setTransportControlFlags(int)}.
 * @apiSince 19
 * @deprecatedSince 29
 */

@Deprecated
public void onClientTransportControlUpdate(int transportControlFlags);

/**
 * Called whenever new metadata is available.
 * See the {@link android.media.MediaMetadataEditor#putLong(int,long) MediaMetadataEditor#putLong(int, long)},
 *  {@link android.media.MediaMetadataEditor#putString(int,java.lang.String) MediaMetadataEditor#putString(int, String)},
 *  {@link android.media.MediaMetadataEditor#putBitmap(int,android.graphics.Bitmap) MediaMetadataEditor#putBitmap(int, Bitmap)}, and
 *  {@link android.media.MediaMetadataEditor#putObject(int,java.lang.Object) MediaMetadataEditor#putObject(int, Object)} methods for the various keys that
 *  can be queried.
 * @param metadataEditor the container of the new metadata.
 * @apiSince 19
 * @deprecatedSince 29
 */

@Deprecated
public void onClientMetadataUpdate(android.media.RemoteController.MetadataEditor metadataEditor);
}

}

