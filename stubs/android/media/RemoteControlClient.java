/*
 * Copyright (C) 2011 The Android Open Source Project
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

import android.media.session.MediaSession;
import android.content.ComponentName;
import android.content.Intent;
import android.app.PendingIntent;
import android.os.Looper;
import android.graphics.Bitmap;

/**
 * RemoteControlClient enables exposing information meant to be consumed by remote controls
 * capable of displaying metadata, artwork and media transport control buttons.
 *
 * <p>A remote control client object is associated with a media button event receiver. This
 * event receiver must have been previously registered with
 * {@link android.media.AudioManager#registerMediaButtonEventReceiver(android.content.ComponentName) AudioManager#registerMediaButtonEventReceiver(ComponentName)} before the
 * RemoteControlClient can be registered through
 * {@link android.media.AudioManager#registerRemoteControlClient(android.media.RemoteControlClient) AudioManager#registerRemoteControlClient(RemoteControlClient)}.
 *
 * <p>Here is an example of creating a RemoteControlClient instance after registering a media
 * button event receiver:
 * <pre>ComponentName myEventReceiver = new ComponentName(getPackageName(), MyRemoteControlEventReceiver.class.getName());
 * AudioManager myAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
 * myAudioManager.registerMediaButtonEventReceiver(myEventReceiver);
 * // build the PendingIntent for the remote control client
 * Intent mediaButtonIntent = new Intent(Intent.ACTION_MEDIA_BUTTON);
 * mediaButtonIntent.setComponent(myEventReceiver);
 * PendingIntent mediaPendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, mediaButtonIntent, 0);
 * // create and register the remote control client
 * RemoteControlClient myRemoteControlClient = new RemoteControlClient(mediaPendingIntent);
 * myAudioManager.registerRemoteControlClient(myRemoteControlClient);</pre>
 *
 * @deprecated Use {@link android.media.session.MediaSession MediaSession} instead.
 * @apiSince 14
 * @deprecatedSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class RemoteControlClient {

/**
 * Class constructor.
 * @param mediaButtonIntent The intent that will be sent for the media button events sent
 *     by remote controls.
 *     This intent needs to have been constructed with the {@link android.content.Intent#ACTION_MEDIA_BUTTON Intent#ACTION_MEDIA_BUTTON}
 *     action, and have a component that will handle the intent (set with
 *     {@link android.content.Intent#setComponent(android.content.ComponentName) Intent#setComponent(ComponentName)}) registered with
 *     {@link android.media.AudioManager#registerMediaButtonEventReceiver(android.content.ComponentName) AudioManager#registerMediaButtonEventReceiver(ComponentName)}
 *     before this new RemoteControlClient can itself be registered with
 *     {@link android.media.AudioManager#registerRemoteControlClient(android.media.RemoteControlClient) AudioManager#registerRemoteControlClient(RemoteControlClient)}.
 * @see android.media.AudioManager#registerMediaButtonEventReceiver(ComponentName)
 * @see android.media.AudioManager#registerRemoteControlClient(RemoteControlClient)
 * @apiSince 14
 */

@Deprecated
public RemoteControlClient(android.app.PendingIntent mediaButtonIntent) { throw new RuntimeException("Stub!"); }

/**
 * Class constructor for a remote control client whose internal event handling
 * happens on a user-provided Looper.
 * @param mediaButtonIntent The intent that will be sent for the media button events sent
 *     by remote controls.
 *     This intent needs to have been constructed with the {@link android.content.Intent#ACTION_MEDIA_BUTTON Intent#ACTION_MEDIA_BUTTON}
 *     action, and have a component that will handle the intent (set with
 *     {@link android.content.Intent#setComponent(android.content.ComponentName) Intent#setComponent(ComponentName)}) registered with
 *     {@link android.media.AudioManager#registerMediaButtonEventReceiver(android.content.ComponentName) AudioManager#registerMediaButtonEventReceiver(ComponentName)}
 *     before this new RemoteControlClient can itself be registered with
 *     {@link android.media.AudioManager#registerRemoteControlClient(android.media.RemoteControlClient) AudioManager#registerRemoteControlClient(RemoteControlClient)}.
 * @param looper The Looper running the event loop.
 * @see android.media.AudioManager#registerMediaButtonEventReceiver(ComponentName)
 * @see android.media.AudioManager#registerRemoteControlClient(RemoteControlClient)
 * @apiSince 14
 */

@Deprecated
public RemoteControlClient(android.app.PendingIntent mediaButtonIntent, android.os.Looper looper) { throw new RuntimeException("Stub!"); }

/**
 * Get a {@link android.media.session.MediaSession MediaSession} associated with this RCC. It will only have a
 * session while it is registered with
 * {@link android.media.AudioManager#registerRemoteControlClient AudioManager#registerRemoteControlClient}. The session returned
 * should not be modified directly by the application but may be used with
 * other APIs that require a session.
 *
 * @return A media session object or null.
 * @apiSince 21
 * @deprecatedSince 21
 */

@Deprecated
public android.media.session.MediaSession getMediaSession() { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link android.media.RemoteControlClient.MetadataEditor MetadataEditor}.
 * @param startEmpty Set to false if you want the MetadataEditor to contain the metadata that
 *     was previously applied to the RemoteControlClient, or true if it is to be created empty.
 * @return a new MetadataEditor instance.
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated
public android.media.RemoteControlClient.MetadataEditor editMetadata(boolean startEmpty) { throw new RuntimeException("Stub!"); }

/**
 * Sets the current playback state.
 * @param state The current playback state, one of the following values:
 *       {@link #PLAYSTATE_STOPPED},
 *       {@link #PLAYSTATE_PAUSED},
 *       {@link #PLAYSTATE_PLAYING},
 *       {@link #PLAYSTATE_FAST_FORWARDING},
 *       {@link #PLAYSTATE_REWINDING},
 *       {@link #PLAYSTATE_SKIPPING_FORWARDS},
 *       {@link #PLAYSTATE_SKIPPING_BACKWARDS},
 *       {@link #PLAYSTATE_BUFFERING},
 *       {@link #PLAYSTATE_ERROR}.
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated
public void setPlaybackState(int state) { throw new RuntimeException("Stub!"); }

/**
 * Sets the current playback state and the matching media position for the current playback
 *   speed.
 * @param state The current playback state, one of the following values:
 *       {@link #PLAYSTATE_STOPPED},
 *       {@link #PLAYSTATE_PAUSED},
 *       {@link #PLAYSTATE_PLAYING},
 *       {@link #PLAYSTATE_FAST_FORWARDING},
 *       {@link #PLAYSTATE_REWINDING},
 *       {@link #PLAYSTATE_SKIPPING_FORWARDS},
 *       {@link #PLAYSTATE_SKIPPING_BACKWARDS},
 *       {@link #PLAYSTATE_BUFFERING},
 *       {@link #PLAYSTATE_ERROR}.
 * @param timeInMs a 0 or positive value for the current media position expressed in ms
 *    (same unit as for when sending the media duration, if applicable, with
 *    {@link android.media.MediaMetadataRetriever#METADATA_KEY_DURATION} in the
 *    {@link android.media.RemoteControlClient.MetadataEditor RemoteControlClient.MetadataEditor}). Negative values imply that position is not
 *    known (e.g. listening to a live stream of a radio) or not applicable (e.g. when state
 *    is {@link #PLAYSTATE_BUFFERING} and nothing had played yet).
 * @param playbackSpeed a value expressed as a ratio of 1x playback: 1.0f is normal playback,
 *    2.0f is 2x, 0.5f is half-speed, -2.0f is rewind at 2x speed. 0.0f means nothing is
 *    playing (e.g. when state is {@link #PLAYSTATE_ERROR}).
 * @apiSince 18
 * @deprecatedSince 21
 */

@Deprecated
public void setPlaybackState(int state, long timeInMs, float playbackSpeed) { throw new RuntimeException("Stub!"); }

/**
 * Sets the flags for the media transport control buttons that this client supports.
 * @param transportControlFlags A combination of the following flags:
 *      {@link #FLAG_KEY_MEDIA_PREVIOUS},
 *      {@link #FLAG_KEY_MEDIA_REWIND},
 *      {@link #FLAG_KEY_MEDIA_PLAY},
 *      {@link #FLAG_KEY_MEDIA_PLAY_PAUSE},
 *      {@link #FLAG_KEY_MEDIA_PAUSE},
 *      {@link #FLAG_KEY_MEDIA_STOP},
 *      {@link #FLAG_KEY_MEDIA_FAST_FORWARD},
 *      {@link #FLAG_KEY_MEDIA_NEXT},
 *      {@link #FLAG_KEY_MEDIA_POSITION_UPDATE},
 *      {@link #FLAG_KEY_MEDIA_RATING}.
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated
public void setTransportControlFlags(int transportControlFlags) { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener to be called whenever the metadata is updated.
 * New metadata values will be received in the same thread as the one in which
 * RemoteControlClient was created.
 * @param l the metadata update listener
 * @apiSince 19
 * @deprecatedSince 21
 */

@Deprecated
public void setMetadataUpdateListener(android.media.RemoteControlClient.OnMetadataUpdateListener l) { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener to be called whenever the media playback position is requested
 * to be updated.
 * Notifications will be received in the same thread as the one in which RemoteControlClient
 * was created.
 * @param l the position update listener to be called
 * @apiSince 18
 * @deprecatedSince 21
 */

@Deprecated
public void setPlaybackPositionUpdateListener(android.media.RemoteControlClient.OnPlaybackPositionUpdateListener l) { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener to be called whenever the media current playback position is needed.
 * Queries will be received in the same thread as the one in which RemoteControlClient
 * was created.
 * @param l the listener to be called to retrieve the playback position
 * @apiSince 18
 * @deprecatedSince 21
 */

@Deprecated
public void setOnGetPlaybackPositionListener(android.media.RemoteControlClient.OnGetPlaybackPositionListener l) { throw new RuntimeException("Stub!"); }

/**
 * Flag indicating a RemoteControlClient makes use of the "fast forward" media key.
 *
 * @see #setTransportControlFlags(int)
 * @see android.view.KeyEvent#KEYCODE_MEDIA_FAST_FORWARD
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated public static final int FLAG_KEY_MEDIA_FAST_FORWARD = 64; // 0x40

/**
 * Flag indicating a RemoteControlClient makes use of the "next" media key.
 *
 * @see #setTransportControlFlags(int)
 * @see android.view.KeyEvent#KEYCODE_MEDIA_NEXT
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated public static final int FLAG_KEY_MEDIA_NEXT = 128; // 0x80

/**
 * Flag indicating a RemoteControlClient makes use of the "pause" media key.
 *
 * @see #setTransportControlFlags(int)
 * @see android.view.KeyEvent#KEYCODE_MEDIA_PAUSE
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated public static final int FLAG_KEY_MEDIA_PAUSE = 16; // 0x10

/**
 * Flag indicating a RemoteControlClient makes use of the "play" media key.
 *
 * @see #setTransportControlFlags(int)
 * @see android.view.KeyEvent#KEYCODE_MEDIA_PLAY
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated public static final int FLAG_KEY_MEDIA_PLAY = 4; // 0x4

/**
 * Flag indicating a RemoteControlClient makes use of the "play/pause" media key.
 *
 * @see #setTransportControlFlags(int)
 * @see android.view.KeyEvent#KEYCODE_MEDIA_PLAY_PAUSE
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated public static final int FLAG_KEY_MEDIA_PLAY_PAUSE = 8; // 0x8

/**
 * Flag indicating a RemoteControlClient can receive changes in the media playback position
 * through the {@link android.media.RemoteControlClient.OnPlaybackPositionUpdateListener OnPlaybackPositionUpdateListener} interface. This flag must be set
 * in order for components that display the RemoteControlClient information, to display and
 * let the user control media playback position.
 * @see #setTransportControlFlags(int)
 * @see #setOnGetPlaybackPositionListener(OnGetPlaybackPositionListener)
 * @see #setPlaybackPositionUpdateListener(OnPlaybackPositionUpdateListener)
 * @apiSince 18
 * @deprecatedSince 21
 */

@Deprecated public static final int FLAG_KEY_MEDIA_POSITION_UPDATE = 256; // 0x100

/**
 * Flag indicating a RemoteControlClient makes use of the "previous" media key.
 *
 * @see #setTransportControlFlags(int)
 * @see android.view.KeyEvent#KEYCODE_MEDIA_PREVIOUS
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated public static final int FLAG_KEY_MEDIA_PREVIOUS = 1; // 0x1

/**
 * Flag indicating a RemoteControlClient supports ratings.
 * This flag must be set in order for components that display the RemoteControlClient
 * information, to display ratings information, and, if ratings are declared editable
 * (by calling {@link android.media.MediaMetadataEditor#addEditableKey(int) MediaMetadataEditor#addEditableKey(int)} with the
 * {@link android.media.MediaMetadataEditor#RATING_KEY_BY_USER MediaMetadataEditor#RATING_KEY_BY_USER} key), it will enable the user to rate
 * the media, with values being received through the interface set with
 * {@link #setMetadataUpdateListener(android.media.RemoteControlClient.OnMetadataUpdateListener)}.
 * @see #setTransportControlFlags(int)
 * @apiSince 19
 * @deprecatedSince 21
 */

@Deprecated public static final int FLAG_KEY_MEDIA_RATING = 512; // 0x200

/**
 * Flag indicating a RemoteControlClient makes use of the "rewind" media key.
 *
 * @see #setTransportControlFlags(int)
 * @see android.view.KeyEvent#KEYCODE_MEDIA_REWIND
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated public static final int FLAG_KEY_MEDIA_REWIND = 2; // 0x2

/**
 * Flag indicating a RemoteControlClient makes use of the "stop" media key.
 *
 * @see #setTransportControlFlags(int)
 * @see android.view.KeyEvent#KEYCODE_MEDIA_STOP
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated public static final int FLAG_KEY_MEDIA_STOP = 32; // 0x20

/**
 * Playback state of a RemoteControlClient which is buffering data to play before it can
 *    start or resume playback.
 *
 * @see #setPlaybackState(int)
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated public static final int PLAYSTATE_BUFFERING = 8; // 0x8

/**
 * Playback state of a RemoteControlClient which cannot perform any playback related
 *    operation because of an internal error. Examples of such situations are no network
 *    connectivity when attempting to stream data from a server, or expired user credentials
 *    when trying to play subscription-based content.
 *
 * @see #setPlaybackState(int)
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated public static final int PLAYSTATE_ERROR = 9; // 0x9

/**
 * Playback state of a RemoteControlClient which is fast forwarding in the media
 *    it is currently playing.
 *
 * @see #setPlaybackState(int)
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated public static final int PLAYSTATE_FAST_FORWARDING = 4; // 0x4

/**
 * Playback state of a RemoteControlClient which is paused.
 *
 * @see #setPlaybackState(int)
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated public static final int PLAYSTATE_PAUSED = 2; // 0x2

/**
 * Playback state of a RemoteControlClient which is playing media.
 *
 * @see #setPlaybackState(int)
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated public static final int PLAYSTATE_PLAYING = 3; // 0x3

/**
 * Playback state of a RemoteControlClient which is fast rewinding in the media
 *    it is currently playing.
 *
 * @see #setPlaybackState(int)
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated public static final int PLAYSTATE_REWINDING = 5; // 0x5

/**
 * Playback state of a RemoteControlClient which is skipping back to the previous
 *    logical chapter (such as a song in a playlist) in the media it is currently playing.
 *
 * @see #setPlaybackState(int)
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated public static final int PLAYSTATE_SKIPPING_BACKWARDS = 7; // 0x7

/**
 * Playback state of a RemoteControlClient which is skipping to the next
 *    logical chapter (such as a song in a playlist) in the media it is currently playing.
 *
 * @see #setPlaybackState(int)
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated public static final int PLAYSTATE_SKIPPING_FORWARDS = 6; // 0x6

/**
 * Playback state of a RemoteControlClient which is stopped.
 *
 * @see #setPlaybackState(int)
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated public static final int PLAYSTATE_STOPPED = 1; // 0x1
/**
 * Class used to modify metadata in a {@link android.media.RemoteControlClient RemoteControlClient} object.
 * Use {@link android.media.RemoteControlClient#editMetadata(boolean) RemoteControlClient#editMetadata(boolean)} to create an instance of an editor,
 * on which you set the metadata for the RemoteControlClient instance. Once all the information
 * has been set, use {@link #apply()} to make it the new metadata that should be displayed
 * for the associated client. Once the metadata has been "applied", you cannot reuse this
 * instance of the MetadataEditor.
 *
 * @deprecated Use {@link android.media.MediaMetadata MediaMetadata} and {@link android.media.session.MediaSession MediaSession} instead.
 * @apiSince 14
 * @deprecatedSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class MetadataEditor extends android.media.MediaMetadataEditor {

private MetadataEditor() { throw new RuntimeException("Stub!"); }

/**
 * @hide
 */

public java.lang.Object clone() throws java.lang.CloneNotSupportedException { throw new RuntimeException("Stub!"); }

/**
 * Adds textual information to be displayed.
 * Note that none of the information added after {@link #apply()} has been called,
 * will be displayed.
 * @param key The identifier of a the metadata field to set. Valid values are
 *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_ALBUM},
 *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_ALBUMARTIST},
 *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_TITLE},
 *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_ARTIST},
 *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_AUTHOR},
 *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_COMPILATION},
 *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_COMPOSER},
 *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_DATE},
 *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_GENRE},
 *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_TITLE},
 *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_WRITER}.
 * @param value The text for the given key, or {@code null} to signify there is no valid
 *      information for the field.
 * @return Returns a reference to the same MetadataEditor object, so you can chain put
 *      calls together.
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated
public synchronized android.media.RemoteControlClient.MetadataEditor putString(int key, java.lang.String value) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Adds numerical information to be displayed.
 * Note that none of the information added after {@link #apply()} has been called,
 * will be displayed.
 * @param key the identifier of a the metadata field to set. Valid values are
 *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_CD_TRACK_NUMBER},
 *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_DISC_NUMBER},
 *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_DURATION} (with a value
 *      expressed in milliseconds),
 *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_YEAR}.
 * @param value The long value for the given key
 * @return Returns a reference to the same MetadataEditor object, so you can chain put
 *      calls together.
 * @throws java.lang.IllegalArgumentException
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated
public synchronized android.media.RemoteControlClient.MetadataEditor putLong(int key, long value) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Sets the album / artwork picture to be displayed on the remote control.
 * @param key the identifier of the bitmap to set. The only valid value is
 *      {@link #BITMAP_KEY_ARTWORK}
 * @param bitmap The bitmap for the artwork, or null if there isn't any.
 * @return Returns a reference to the same MetadataEditor object, so you can chain put
 *      calls together.
 * @throws java.lang.IllegalArgumentException
 * @see android.graphics.Bitmap
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated
public synchronized android.media.RemoteControlClient.MetadataEditor putBitmap(int key, android.graphics.Bitmap bitmap) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 19
 * @deprecatedSince 21
 */

@Deprecated
public synchronized android.media.RemoteControlClient.MetadataEditor putObject(int key, java.lang.Object object) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Clears all the metadata that has been set since the MetadataEditor instance was created
 * (with {@link android.media.RemoteControlClient#editMetadata(boolean) RemoteControlClient#editMetadata(boolean)}).
 * Note that clearing the metadata doesn't reset the editable keys
 * (use {@link android.media.MediaMetadataEditor#removeEditableKeys() MediaMetadataEditor#removeEditableKeys()} instead).
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated
public synchronized void clear() { throw new RuntimeException("Stub!"); }

/**
 * Associates all the metadata that has been set since the MetadataEditor instance was
 *     created with {@link android.media.RemoteControlClient#editMetadata(boolean) RemoteControlClient#editMetadata(boolean)}, or since
 *     {@link #clear()} was called, with the RemoteControlClient. Once "applied",
 *     this MetadataEditor cannot be reused to edit the RemoteControlClient's metadata.
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated
public synchronized void apply() { throw new RuntimeException("Stub!"); }

/**
 * The metadata key for the content artwork / album art.
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated public static final int BITMAP_KEY_ARTWORK = 100; // 0x64
}

/**
 * Interface definition for a callback to be invoked when the media playback position is
 * queried.
 * @see android.media.RemoteControlClient#FLAG_KEY_MEDIA_POSITION_UPDATE
 * @apiSince 18
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface OnGetPlaybackPositionListener {

/**
 * Called on the implementer of the interface to query the current playback position.
 * @return a negative value if the current playback position (or the last valid playback
 *     position) is not known, or a zero or positive value expressed in ms indicating the
 *     current position, or the last valid known position.
 * @apiSince 18
 * @deprecatedSince 29
 */

@Deprecated
public long onGetPlaybackPosition();
}

/**
 * Interface definition for a callback to be invoked when one of the metadata values has
 * been updated.
 * Implement this interface to receive metadata updates after registering your listener
 * through {@link android.media.RemoteControlClient#setMetadataUpdateListener(android.media.RemoteControlClient.OnMetadataUpdateListener) RemoteControlClient#setMetadataUpdateListener(OnMetadataUpdateListener)}.
 * @apiSince 19
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface OnMetadataUpdateListener {

/**
 * Called on the implementer to notify that the metadata field for the given key has
 * been updated to the new value.
 * @param key the identifier of the updated metadata field.
 * @param newValue the Object storing the new value for the key.
 * @apiSince 19
 * @deprecatedSince 29
 */

@Deprecated
public void onMetadataUpdate(int key, java.lang.Object newValue);
}

/**
 * Interface definition for a callback to be invoked when the media playback position is
 * requested to be updated.
 * @see android.media.RemoteControlClient#FLAG_KEY_MEDIA_POSITION_UPDATE
 * @apiSince 18
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface OnPlaybackPositionUpdateListener {

/**
 * Called on the implementer to notify it that the playback head should be set at the given
 * position. If the position can be changed from its current value, the implementor of
 * the interface must also update the playback position using
 * {@link #setPlaybackState(int,long,float)} to reflect the actual new
 * position being used, regardless of whether it differs from the requested position.
 * Failure to do so would cause the system to not know the new actual playback position,
 * and user interface components would fail to show the user where playback resumed after
 * the position was updated.
 * @param newPositionMs the new requested position in the current media, expressed in ms.
 * @apiSince 18
 * @deprecatedSince 29
 */

@Deprecated
public void onPlaybackPositionUpdate(long newPositionMs);
}

}

