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


package android.media.session;

import android.os.Parcelable;
import android.app.Activity;
import android.content.Intent;
import android.app.PendingIntent;
import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.session.MediaSessionManager.RemoteUserInfo;
import android.view.KeyEvent;
import android.service.media.MediaBrowserService;
import android.media.MediaDescription;

/**
 * Allows interaction with media controllers, volume keys, media buttons, and
 * transport controls.
 * <p>
 * A MediaSession should be created when an app wants to publish media playback
 * information or handle media keys. In general an app only needs one session
 * for all playback, though multiple sessions can be created to provide finer
 * grain controls of media.
 * <p>
 * Once a session is created the owner of the session may pass its
 * {@link #getSessionToken() session token} to other processes to allow them to
 * create a {@link android.media.session.MediaController MediaController} to interact with the session.
 * <p>
 * To receive commands, media keys, and other events a {@link android.media.session.MediaSession.Callback Callback} must be
 * set with {@link #setCallback(android.media.session.MediaSession.Callback)} and {@link #setActive(boolean)
 * setActive(true)} must be called.
 * <p>
 * When an app is finished performing playback it must call {@link #release()}
 * to clean up the session and notify any controllers.
 * <p>
 * MediaSession objects are thread safe.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MediaSession {

/**
 * Creates a new session. The session will automatically be registered with
 * the system but will not be published until {@link #setActive(boolean)
 * setActive(true)} is called. You must call {@link #release()} when
 * finished with the session.
 *
 * @param context The context to use to create the session.
 * This value must never be {@code null}.
 * @param tag A short name for debugging purposes.
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public MediaSession(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String tag) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new session. The session will automatically be registered with
 * the system but will not be published until {@link #setActive(boolean)
 * setActive(true)} is called. You must call {@link #release()} when
 * finished with the session.
 * <p>
 * The {@code sessionInfo} can include additional unchanging information about this session.
 * For example, it can include the version of the application, or the list of the custom
 * commands that this session supports.
 *
 * @param context The context to use to create the session.
 * This value must never be {@code null}.
 * @param tag A short name for debugging purposes.
 * This value must never be {@code null}.
 * @param sessionInfo A bundle for additional information about this session.
 *                    Controllers can get this information by calling
 *                    {@link android.media.session.MediaController#getSessionInfo() MediaController#getSessionInfo()}.
 *                    An {@link java.lang.IllegalArgumentException IllegalArgumentException} will be thrown if this contains
 *                    any non-framework Parcelable objects.
 
 * This value may be {@code null}.
 * @apiSince 29
 */

public MediaSession(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String tag, @androidx.annotation.Nullable android.os.Bundle sessionInfo) { throw new RuntimeException("Stub!"); }

/**
 * Set the callback to receive updates for the MediaSession. This includes
 * media button events and transport controls. The caller's thread will be
 * used to post updates.
 * <p>
 * Set the callback to null to stop receiving updates.
 *
 * @param callback The callback object
 
 * This value may be {@code null}.
 * @apiSince 21
 */

public void setCallback(@androidx.annotation.Nullable android.media.session.MediaSession.Callback callback) { throw new RuntimeException("Stub!"); }

/**
 * Set the callback to receive updates for the MediaSession. This includes
 * media button events and transport controls.
 * <p>
 * Set the callback to null to stop receiving updates.
 *
 * @param callback The callback to receive updates on.
 * This value may be {@code null}.
 * @param handler The handler that events should be posted on.
 
 * This value may be {@code null}.
 * @apiSince 21
 */

public void setCallback(@androidx.annotation.Nullable android.media.session.MediaSession.Callback callback, @androidx.annotation.Nullable android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Set an intent for launching UI for this Session. This can be used as a
 * quick link to an ongoing media screen. The intent should be for an
 * activity that may be started using {@link android.app.Activity#startActivity(android.content.Intent) Activity#startActivity(Intent)}.
 *
 * @param pi The intent to launch to show UI for this Session.
 
 * This value may be {@code null}.
 * @apiSince 21
 */

public void setSessionActivity(@androidx.annotation.Nullable android.app.PendingIntent pi) { throw new RuntimeException("Stub!"); }

/**
 * Set a pending intent for your media button receiver to allow restarting
 * playback after the session has been stopped. If your app is started in
 * this way an {@link android.content.Intent#ACTION_MEDIA_BUTTON Intent#ACTION_MEDIA_BUTTON} intent will be sent via
 * the pending intent.
 *
 * @param mbr The {@link android.app.PendingIntent PendingIntent} to send the media button event to.
 
 * This value may be {@code null}.
 * @apiSince 21
 */

public void setMediaButtonReceiver(@androidx.annotation.Nullable android.app.PendingIntent mbr) { throw new RuntimeException("Stub!"); }

/**
 * Set any flags for the session.
 *
 * @param flags The flags to set for this session.
 
 * Value is either <code>0</code> or a combination of {@link android.media.session.MediaSession#FLAG_HANDLES_MEDIA_BUTTONS}, {@link android.media.session.MediaSession#FLAG_HANDLES_TRANSPORT_CONTROLS}, and android.media.session.MediaSession.FLAG_EXCLUSIVE_GLOBAL_PRIORITY
 * @apiSince 21
 */

public void setFlags(int flags) { throw new RuntimeException("Stub!"); }

/**
 * Set the attributes for this session's audio. This will affect the
 * system's volume handling for this session. If
 * {@link #setPlaybackToRemote} was previously called it will stop receiving
 * volume commands and the system will begin sending volume changes to the
 * appropriate stream.
 * <p>
 * By default sessions use attributes for media.
 *
 * @param attributes The {@link android.media.AudioAttributes AudioAttributes} for this session's audio.
 * @apiSince 21
 */

public void setPlaybackToLocal(android.media.AudioAttributes attributes) { throw new RuntimeException("Stub!"); }

/**
 * Configure this session to use remote volume handling. This must be called
 * to receive volume button events, otherwise the system will adjust the
 * appropriate stream volume for this session. If
 * {@link #setPlaybackToLocal} was previously called the system will stop
 * handling volume changes for this session and pass them to the volume
 * provider instead.
 *
 * @param volumeProvider The provider that will handle volume changes. May
 *            not be null.
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public void setPlaybackToRemote(@androidx.annotation.NonNull android.media.VolumeProvider volumeProvider) { throw new RuntimeException("Stub!"); }

/**
 * Set if this session is currently active and ready to receive commands. If
 * set to false your session's controller may not be discoverable. You must
 * set the session to active before it can start receiving media button
 * events or transport commands.
 *
 * @param active Whether this session is active or not.
 * @apiSince 21
 */

public void setActive(boolean active) { throw new RuntimeException("Stub!"); }

/**
 * Get the current active state of this session.
 *
 * @return True if the session is active, false otherwise.
 * @apiSince 21
 */

public boolean isActive() { throw new RuntimeException("Stub!"); }

/**
 * Send a proprietary event to all MediaControllers listening to this
 * Session. It's up to the Controller/Session owner to determine the meaning
 * of any events.
 *
 * @param event The name of the event to send
 * This value must never be {@code null}.
 * @param extras Any extras included with the event
 
 * This value may be {@code null}.
 * @apiSince 21
 */

public void sendSessionEvent(@androidx.annotation.NonNull java.lang.String event, @androidx.annotation.Nullable android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * This must be called when an app has finished performing playback. If
 * playback is expected to start again shortly the session can be left open,
 * but it must be released if your activity or service is being destroyed.
 * @apiSince 21
 */

public void release() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a token object that can be used by apps to create a
 * {@link android.media.session.MediaController MediaController} for interacting with this session. The owner of
 * the session is responsible for deciding how to distribute these tokens.
 *
 * @return A token that can be used to create a MediaController for this
 *         session
 
 * This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public android.media.session.MediaSession.Token getSessionToken() { throw new RuntimeException("Stub!"); }

/**
 * Get a controller for this session. This is a convenience method to avoid
 * having to cache your own controller in process.
 *
 * @return A controller for this session.
 
 * This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public android.media.session.MediaController getController() { throw new RuntimeException("Stub!"); }

/**
 * Update the current playback state.
 *
 * @param state The current state of playback
 
 * This value may be {@code null}.
 * @apiSince 21
 */

public void setPlaybackState(@androidx.annotation.Nullable android.media.session.PlaybackState state) { throw new RuntimeException("Stub!"); }

/**
 * Update the current metadata. New metadata can be created using
 * {@link android.media.MediaMetadata.Builder}. This operation may take time proportional to
 * the size of the bitmap to replace large bitmaps with a scaled down copy.
 *
 * @param metadata The new metadata
 * This value may be {@code null}.
 * @see android.media.MediaMetadata.Builder#putBitmap
 * @apiSince 21
 */

public void setMetadata(@androidx.annotation.Nullable android.media.MediaMetadata metadata) { throw new RuntimeException("Stub!"); }

/**
 * Update the list of items in the play queue. It is an ordered list and
 * should contain the current item, and previous or upcoming items if they
 * exist. Specify null if there is no current play queue.
 * <p>
 * The queue should be of reasonable size. If the play queue is unbounded
 * within your app, it is better to send a reasonable amount in a sliding
 * window instead.
 *
 * @param queue A list of items in the play queue.
 
 * This value may be {@code null}.
 * @apiSince 21
 */

public void setQueue(@androidx.annotation.Nullable java.util.List<android.media.session.MediaSession.QueueItem> queue) { throw new RuntimeException("Stub!"); }

/**
 * Set the title of the play queue. The UI should display this title along
 * with the play queue itself.
 * e.g. "Play Queue", "Now Playing", or an album name.
 *
 * @param title The title of the play queue.
 
 * This value may be {@code null}.
 * @apiSince 21
 */

public void setQueueTitle(@androidx.annotation.Nullable java.lang.CharSequence title) { throw new RuntimeException("Stub!"); }

/**
 * Set the style of rating used by this session. Apps trying to set the
 * rating should use this style. Must be one of the following:
 * <ul>
 * <li>{@link android.media.Rating#RATING_NONE Rating#RATING_NONE}</li>
 * <li>{@link android.media.Rating#RATING_3_STARS Rating#RATING_3_STARS}</li>
 * <li>{@link android.media.Rating#RATING_4_STARS Rating#RATING_4_STARS}</li>
 * <li>{@link android.media.Rating#RATING_5_STARS Rating#RATING_5_STARS}</li>
 * <li>{@link android.media.Rating#RATING_HEART Rating#RATING_HEART}</li>
 * <li>{@link android.media.Rating#RATING_PERCENTAGE Rating#RATING_PERCENTAGE}</li>
 * <li>{@link android.media.Rating#RATING_THUMB_UP_DOWN Rating#RATING_THUMB_UP_DOWN}</li>
 * </ul>
 
 * @param type Value is {@link android.media.Rating#RATING_NONE}, {@link android.media.Rating#RATING_HEART}, {@link android.media.Rating#RATING_THUMB_UP_DOWN}, {@link android.media.Rating#RATING_3_STARS}, {@link android.media.Rating#RATING_4_STARS}, {@link android.media.Rating#RATING_5_STARS}, or {@link android.media.Rating#RATING_PERCENTAGE}
 * @apiSince 22
 */

public void setRatingType(int type) { throw new RuntimeException("Stub!"); }

/**
 * Set some extras that can be associated with the {@link android.media.session.MediaSession MediaSession}. No assumptions should
 * be made as to how a {@link android.media.session.MediaController MediaController} will handle these extras.
 * Keys should be fully qualified (e.g. com.example.MY_EXTRA) to avoid conflicts.
 *
 * @param extras The extras associated with the {@link android.media.session.MediaSession MediaSession}.
 
 * This value may be {@code null}.
 * @apiSince 21
 */

public void setExtras(@androidx.annotation.Nullable android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Gets the controller information who sent the current request.
 * <p>
 * Note: This is only valid while in a request callback, such as {@link android.media.session.MediaSession.Callback#onPlay Callback#onPlay}.
 *
 * @throws java.lang.IllegalStateException If this method is called outside of {@link android.media.session.MediaSession.Callback Callback} methods.
 * @see android.media.session.MediaSessionManager#isTrustedForMediaControl(RemoteUserInfo)
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.media.session.MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() { throw new RuntimeException("Stub!"); }

/**
 * Set this flag on the session to indicate that it can handle media button
 * events.
 * @deprecated This flag is no longer used. All media sessions are expected to handle media
 * button events now.
 * @apiSince 21
 * @deprecatedSince 26
 */

@Deprecated public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1; // 0x1

/**
 * Set this flag on the session to indicate that it handles transport
 * control commands through its {@link android.media.session.MediaSession.Callback Callback}.
 * @deprecated This flag is no longer used. All media sessions are expected to handle transport
 * controls now.
 * @apiSince 21
 * @deprecatedSince 26
 */

@Deprecated public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2; // 0x2
/**
 * Receives media buttons, transport controls, and commands from controllers
 * and the system. A callback may be set using {@link #setCallback}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class Callback {

/** @apiSince 21 */

public Callback() { throw new RuntimeException("Stub!"); }

/**
 * Called when a controller has sent a command to this session.
 * The owner of the session may handle custom commands but is not
 * required to.
 *
 * @param command The command name.
 * This value must never be {@code null}.
 * @param args Optional parameters for the command, may be null.
 * This value may be {@code null}.
 * @param cb A result receiver to which a result may be sent by the command, may be null.
 
 * This value may be {@code null}.
 * @apiSince 21
 */

public void onCommand(@androidx.annotation.NonNull java.lang.String command, @androidx.annotation.Nullable android.os.Bundle args, @androidx.annotation.Nullable android.os.ResultReceiver cb) { throw new RuntimeException("Stub!"); }

/**
 * Called when a media button is pressed and this session has the
 * highest priority or a controller sends a media button event to the
 * session. The default behavior will call the relevant method if the
 * action for it was set.
 * <p>
 * The intent will be of type {@link android.content.Intent#ACTION_MEDIA_BUTTON Intent#ACTION_MEDIA_BUTTON} with a
 * KeyEvent in {@link android.content.Intent#EXTRA_KEY_EVENT Intent#EXTRA_KEY_EVENT}
 *
 * @param mediaButtonIntent an intent containing the KeyEvent as an
 *            extra
 * This value must never be {@code null}.
 * @return True if the event was handled, false otherwise.
 * @apiSince 21
 */

public boolean onMediaButtonEvent(@androidx.annotation.NonNull android.content.Intent mediaButtonIntent) { throw new RuntimeException("Stub!"); }

/**
 * Override to handle requests to prepare playback. During the preparation, a session should
 * not hold audio focus in order to allow other sessions play seamlessly. The state of
 * playback should be updated to {@link android.media.session.PlaybackState#STATE_PAUSED PlaybackState#STATE_PAUSED} after the preparation is
 * done.
 * @apiSince 24
 */

public void onPrepare() { throw new RuntimeException("Stub!"); }

/**
 * Override to handle requests to prepare for playing a specific mediaId that was provided
 * by your app's {@link android.service.media.MediaBrowserService MediaBrowserService}. During the preparation, a session should not
 * hold audio focus in order to allow other sessions play seamlessly. The state of playback
 * should be updated to {@link android.media.session.PlaybackState#STATE_PAUSED PlaybackState#STATE_PAUSED} after the preparation is done.
 * The playback of the prepared content should start in the implementation of
 * {@link #onPlay}. Override {@link #onPlayFromMediaId} to handle requests for starting
 * playback without preparation.
 * @apiSince 24
 */

public void onPrepareFromMediaId(java.lang.String mediaId, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Override to handle requests to prepare playback from a search query. An empty query
 * indicates that the app may prepare any music. The implementation should attempt to make a
 * smart choice about what to play. During the preparation, a session should not hold audio
 * focus in order to allow other sessions play seamlessly. The state of playback should be
 * updated to {@link android.media.session.PlaybackState#STATE_PAUSED PlaybackState#STATE_PAUSED} after the preparation is done. The playback
 * of the prepared content should start in the implementation of {@link #onPlay}. Override
 * {@link #onPlayFromSearch} to handle requests for starting playback without preparation.
 * @apiSince 24
 */

public void onPrepareFromSearch(java.lang.String query, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Override to handle requests to prepare a specific media item represented by a URI.
 * During the preparation, a session should not hold audio focus in order to allow
 * other sessions play seamlessly. The state of playback should be updated to
 * {@link android.media.session.PlaybackState#STATE_PAUSED PlaybackState#STATE_PAUSED} after the preparation is done.
 * The playback of the prepared content should start in the implementation of
 * {@link #onPlay}. Override {@link #onPlayFromUri} to handle requests
 * for starting playback without preparation.
 * @apiSince 24
 */

public void onPrepareFromUri(android.net.Uri uri, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Override to handle requests to begin playback.
 * @apiSince 21
 */

public void onPlay() { throw new RuntimeException("Stub!"); }

/**
 * Override to handle requests to begin playback from a search query. An
 * empty query indicates that the app may play any music. The
 * implementation should attempt to make a smart choice about what to
 * play.
 * @apiSince 21
 */

public void onPlayFromSearch(java.lang.String query, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Override to handle requests to play a specific mediaId that was
 * provided by your app's {@link android.service.media.MediaBrowserService MediaBrowserService}.
 * @apiSince 21
 */

public void onPlayFromMediaId(java.lang.String mediaId, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Override to handle requests to play a specific media item represented by a URI.
 * @apiSince 23
 */

public void onPlayFromUri(android.net.Uri uri, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Override to handle requests to play an item with a given id from the
 * play queue.
 * @apiSince 21
 */

public void onSkipToQueueItem(long id) { throw new RuntimeException("Stub!"); }

/**
 * Override to handle requests to pause playback.
 * @apiSince 21
 */

public void onPause() { throw new RuntimeException("Stub!"); }

/**
 * Override to handle requests to skip to the next media item.
 * @apiSince 21
 */

public void onSkipToNext() { throw new RuntimeException("Stub!"); }

/**
 * Override to handle requests to skip to the previous media item.
 * @apiSince 21
 */

public void onSkipToPrevious() { throw new RuntimeException("Stub!"); }

/**
 * Override to handle requests to fast forward.
 * @apiSince 21
 */

public void onFastForward() { throw new RuntimeException("Stub!"); }

/**
 * Override to handle requests to rewind.
 * @apiSince 21
 */

public void onRewind() { throw new RuntimeException("Stub!"); }

/**
 * Override to handle requests to stop playback.
 * @apiSince 21
 */

public void onStop() { throw new RuntimeException("Stub!"); }

/**
 * Override to handle requests to seek to a specific position in ms.
 *
 * @param pos New position to move to, in milliseconds.
 * @apiSince 21
 */

public void onSeekTo(long pos) { throw new RuntimeException("Stub!"); }

/**
 * Override to handle the item being rated.
 *
 * @param rating
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public void onSetRating(@androidx.annotation.NonNull android.media.Rating rating) { throw new RuntimeException("Stub!"); }

/**
 * Override to handle the playback speed change.
 * To update the new playback speed, create a new {@link android.media.session.PlaybackState PlaybackState} by using {@link android.media.session.PlaybackState.Builder#setState(int,long,float) PlaybackState.Builder#setState(int, long, float)}, and set it with
 * {@link #setPlaybackState(android.media.session.PlaybackState)}.
 * <p>
 * A value of {@code 1.0f} is the default playback value, and a negative value indicates
 * reverse playback. The {@code speed} will not be equal to zero.
 *
 * @param speed the playback speed
 * @see #setPlaybackState(PlaybackState)
 * @see android.media.session.PlaybackState.Builder#setState(int, long, float)
 * @apiSince 29
 */

public void onSetPlaybackSpeed(float speed) { throw new RuntimeException("Stub!"); }

/**
 * Called when a {@link android.media.session.MediaController MediaController} wants a {@link android.media.session.PlaybackState.CustomAction PlaybackState.CustomAction} to be
 * performed.
 *
 * @param action The action that was originally sent in the
 *               {@link android.media.session.PlaybackState.CustomAction PlaybackState.CustomAction}.
 * This value must never be {@code null}.
 * @param extras Optional extras specified by the {@link android.media.session.MediaController MediaController}.
 
 * This value may be {@code null}.
 * @apiSince 21
 */

public void onCustomAction(@androidx.annotation.NonNull java.lang.String action, @androidx.annotation.Nullable android.os.Bundle extras) { throw new RuntimeException("Stub!"); }
}

/**
 * A single item that is part of the play queue. It contains a description
 * of the item and its id in the queue.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class QueueItem implements android.os.Parcelable {

/**
 * Create a new {@link android.media.session.MediaSession.QueueItem MediaSession.QueueItem}.
 *
 * @param description The {@link android.media.MediaDescription MediaDescription} for this item.
 * @param id An identifier for this item. It must be unique within the
 *            play queue and cannot be {@link #UNKNOWN_ID}.
 * @apiSince 21
 */

public QueueItem(android.media.MediaDescription description, long id) { throw new RuntimeException("Stub!"); }

/**
 * Get the description for this item.
 * @apiSince 21
 */

public android.media.MediaDescription getDescription() { throw new RuntimeException("Stub!"); }

/**
 * Get the queue id for this item.
 * @apiSince 21
 */

public long getQueueId() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.media.session.MediaSession.QueueItem> CREATOR;
static { CREATOR = null; }

/**
 * This id is reserved. No items can be explicitly assigned this id.
 * @apiSince 21
 */

public static final int UNKNOWN_ID = -1; // 0xffffffff
}

/**
 * Represents an ongoing session. This may be passed to apps by the session
 * owner to allow them to create a {@link android.media.session.MediaController MediaController} to communicate with
 * the session.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Token implements android.os.Parcelable {

Token() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.media.session.MediaSession.Token> CREATOR;
static { CREATOR = null; }
}

}

