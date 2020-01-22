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

import android.os.SystemClock;
import android.os.Bundle;

/**
 * Playback state for a {@link android.media.session.MediaSession MediaSession}. This includes a state like
 * {@link android.media.session.PlaybackState#STATE_PLAYING PlaybackState#STATE_PLAYING}, the current playback position,
 * and the current control capabilities.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class PlaybackState implements android.os.Parcelable {

private PlaybackState() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Get the current state of playback. One of the following:
 * <ul>
 * <li> {@link android.media.session.PlaybackState#STATE_NONE PlaybackState#STATE_NONE}</li>
 * <li> {@link android.media.session.PlaybackState#STATE_STOPPED PlaybackState#STATE_STOPPED}</li>
 * <li> {@link android.media.session.PlaybackState#STATE_PLAYING PlaybackState#STATE_PLAYING}</li>
 * <li> {@link android.media.session.PlaybackState#STATE_PAUSED PlaybackState#STATE_PAUSED}</li>
 * <li> {@link android.media.session.PlaybackState#STATE_FAST_FORWARDING PlaybackState#STATE_FAST_FORWARDING}</li>
 * <li> {@link android.media.session.PlaybackState#STATE_REWINDING PlaybackState#STATE_REWINDING}</li>
 * <li> {@link android.media.session.PlaybackState#STATE_BUFFERING PlaybackState#STATE_BUFFERING}</li>
 * <li> {@link android.media.session.PlaybackState#STATE_ERROR PlaybackState#STATE_ERROR}</li>
 * <li> {@link android.media.session.PlaybackState#STATE_CONNECTING PlaybackState#STATE_CONNECTING}</li>
 * <li> {@link android.media.session.PlaybackState#STATE_SKIPPING_TO_PREVIOUS PlaybackState#STATE_SKIPPING_TO_PREVIOUS}</li>
 * <li> {@link android.media.session.PlaybackState#STATE_SKIPPING_TO_NEXT PlaybackState#STATE_SKIPPING_TO_NEXT}</li>
 * <li> {@link android.media.session.PlaybackState#STATE_SKIPPING_TO_QUEUE_ITEM PlaybackState#STATE_SKIPPING_TO_QUEUE_ITEM}</li>
 * </ul>
 
 * @return Value is {@link android.media.session.PlaybackState#STATE_NONE}, {@link android.media.session.PlaybackState#STATE_STOPPED}, {@link android.media.session.PlaybackState#STATE_PAUSED}, {@link android.media.session.PlaybackState#STATE_PLAYING}, {@link android.media.session.PlaybackState#STATE_FAST_FORWARDING}, {@link android.media.session.PlaybackState#STATE_REWINDING}, {@link android.media.session.PlaybackState#STATE_BUFFERING}, {@link android.media.session.PlaybackState#STATE_ERROR}, {@link android.media.session.PlaybackState#STATE_CONNECTING}, {@link android.media.session.PlaybackState#STATE_SKIPPING_TO_PREVIOUS}, {@link android.media.session.PlaybackState#STATE_SKIPPING_TO_NEXT}, or {@link android.media.session.PlaybackState#STATE_SKIPPING_TO_QUEUE_ITEM}
 * @apiSince 21
 */

public int getState() { throw new RuntimeException("Stub!"); }

/**
 * Get the current playback position in ms.
 * @apiSince 21
 */

public long getPosition() { throw new RuntimeException("Stub!"); }

/**
 * Get the current buffered position in ms. This is the farthest playback
 * point that can be reached from the current position using only buffered
 * content.
 * @apiSince 21
 */

public long getBufferedPosition() { throw new RuntimeException("Stub!"); }

/**
 * Get the current playback speed as a multiple of normal playback. This
 * should be negative when rewinding. A value of 1 means normal playback and
 * 0 means paused.
 *
 * @return The current speed of playback.
 * @apiSince 21
 */

public float getPlaybackSpeed() { throw new RuntimeException("Stub!"); }

/**
 * Get the current actions available on this session. This should use a
 * bitmask of the available actions.
 * <ul>
 * <li> {@link android.media.session.PlaybackState#ACTION_SKIP_TO_PREVIOUS PlaybackState#ACTION_SKIP_TO_PREVIOUS}</li>
 * <li> {@link android.media.session.PlaybackState#ACTION_REWIND PlaybackState#ACTION_REWIND}</li>
 * <li> {@link android.media.session.PlaybackState#ACTION_PLAY PlaybackState#ACTION_PLAY}</li>
 * <li> {@link android.media.session.PlaybackState#ACTION_PAUSE PlaybackState#ACTION_PAUSE}</li>
 * <li> {@link android.media.session.PlaybackState#ACTION_STOP PlaybackState#ACTION_STOP}</li>
 * <li> {@link android.media.session.PlaybackState#ACTION_FAST_FORWARD PlaybackState#ACTION_FAST_FORWARD}</li>
 * <li> {@link android.media.session.PlaybackState#ACTION_SKIP_TO_NEXT PlaybackState#ACTION_SKIP_TO_NEXT}</li>
 * <li> {@link android.media.session.PlaybackState#ACTION_SEEK_TO PlaybackState#ACTION_SEEK_TO}</li>
 * <li> {@link android.media.session.PlaybackState#ACTION_SET_RATING PlaybackState#ACTION_SET_RATING}</li>
 * <li> {@link android.media.session.PlaybackState#ACTION_PLAY_PAUSE PlaybackState#ACTION_PLAY_PAUSE}</li>
 * <li> {@link android.media.session.PlaybackState#ACTION_PLAY_FROM_MEDIA_ID PlaybackState#ACTION_PLAY_FROM_MEDIA_ID}</li>
 * <li> {@link android.media.session.PlaybackState#ACTION_PLAY_FROM_SEARCH PlaybackState#ACTION_PLAY_FROM_SEARCH}</li>
 * <li> {@link android.media.session.PlaybackState#ACTION_SKIP_TO_QUEUE_ITEM PlaybackState#ACTION_SKIP_TO_QUEUE_ITEM}</li>
 * <li> {@link android.media.session.PlaybackState#ACTION_PLAY_FROM_URI PlaybackState#ACTION_PLAY_FROM_URI}</li>
 * <li> {@link android.media.session.PlaybackState#ACTION_PREPARE PlaybackState#ACTION_PREPARE}</li>
 * <li> {@link android.media.session.PlaybackState#ACTION_PREPARE_FROM_MEDIA_ID PlaybackState#ACTION_PREPARE_FROM_MEDIA_ID}</li>
 * <li> {@link android.media.session.PlaybackState#ACTION_PREPARE_FROM_SEARCH PlaybackState#ACTION_PREPARE_FROM_SEARCH}</li>
 * <li> {@link android.media.session.PlaybackState#ACTION_PREPARE_FROM_URI PlaybackState#ACTION_PREPARE_FROM_URI}</li>
 * </ul>
 
 * @return Value is either <code>0</code> or a combination of {@link android.media.session.PlaybackState#ACTION_STOP}, {@link android.media.session.PlaybackState#ACTION_PAUSE}, {@link android.media.session.PlaybackState#ACTION_PLAY}, {@link android.media.session.PlaybackState#ACTION_REWIND}, {@link android.media.session.PlaybackState#ACTION_SKIP_TO_PREVIOUS}, {@link android.media.session.PlaybackState#ACTION_SKIP_TO_NEXT}, {@link android.media.session.PlaybackState#ACTION_FAST_FORWARD}, {@link android.media.session.PlaybackState#ACTION_SET_RATING}, {@link android.media.session.PlaybackState#ACTION_SEEK_TO}, {@link android.media.session.PlaybackState#ACTION_PLAY_PAUSE}, {@link android.media.session.PlaybackState#ACTION_PLAY_FROM_MEDIA_ID}, {@link android.media.session.PlaybackState#ACTION_PLAY_FROM_SEARCH}, {@link android.media.session.PlaybackState#ACTION_SKIP_TO_QUEUE_ITEM}, {@link android.media.session.PlaybackState#ACTION_PLAY_FROM_URI}, {@link android.media.session.PlaybackState#ACTION_PREPARE}, {@link android.media.session.PlaybackState#ACTION_PREPARE_FROM_MEDIA_ID}, {@link android.media.session.PlaybackState#ACTION_PREPARE_FROM_SEARCH}, and {@link android.media.session.PlaybackState#ACTION_PREPARE_FROM_URI}
 * @apiSince 21
 */

public long getActions() { throw new RuntimeException("Stub!"); }

/**
 * Get the list of custom actions.
 * @apiSince 21
 */

public java.util.List<android.media.session.PlaybackState.CustomAction> getCustomActions() { throw new RuntimeException("Stub!"); }

/**
 * Get a user readable error message. This should be set when the state is
 * {@link android.media.session.PlaybackState#STATE_ERROR PlaybackState#STATE_ERROR}.
 * @apiSince 21
 */

public java.lang.CharSequence getErrorMessage() { throw new RuntimeException("Stub!"); }

/**
 * Get the elapsed real time at which position was last updated. If the
 * position has never been set this will return 0;
 *
 * @return The last time the position was updated.
 * @apiSince 21
 */

public long getLastPositionUpdateTime() { throw new RuntimeException("Stub!"); }

/**
 * Get the id of the currently active item in the queue. If there is no
 * queue or a queue is not supported by the session this will be
 * {@link android.media.session.MediaSession.QueueItem#UNKNOWN_ID MediaSession.QueueItem#UNKNOWN_ID}.
 *
 * @return The id of the currently active item in the queue or
 *         {@link android.media.session.MediaSession.QueueItem#UNKNOWN_ID MediaSession.QueueItem#UNKNOWN_ID}.
 * @apiSince 21
 */

public long getActiveQueueItemId() { throw new RuntimeException("Stub!"); }

/**
 * Get any custom extras that were set on this playback state.
 *
 * @return The extras for this state or null.
 * @apiSince 22
 */

@androidx.annotation.Nullable
public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * Indicates this session supports the fast forward command.
 *
 * @see android.media.session.PlaybackState.Builder#setActions(long)
 * @apiSince 21
 */

public static final long ACTION_FAST_FORWARD = 64L; // 0x40L

/**
 * Indicates this session supports the pause command.
 *
 * @see android.media.session.PlaybackState.Builder#setActions(long)
 * @apiSince 21
 */

public static final long ACTION_PAUSE = 2L; // 0x2L

/**
 * Indicates this session supports the play command.
 *
 * @see android.media.session.PlaybackState.Builder#setActions(long)
 * @apiSince 21
 */

public static final long ACTION_PLAY = 4L; // 0x4L

/**
 * Indicates this session supports the play from media id command.
 *
 * @see android.media.session.PlaybackState.Builder#setActions(long)
 * @apiSince 21
 */

public static final long ACTION_PLAY_FROM_MEDIA_ID = 1024L; // 0x400L

/**
 * Indicates this session supports the play from search command.
 *
 * @see android.media.session.PlaybackState.Builder#setActions(long)
 * @apiSince 21
 */

public static final long ACTION_PLAY_FROM_SEARCH = 2048L; // 0x800L

/**
 * Indicates this session supports the play from URI command.
 *
 * @see android.media.session.PlaybackState.Builder#setActions(long)
 * @apiSince 23
 */

public static final long ACTION_PLAY_FROM_URI = 8192L; // 0x2000L

/**
 * Indicates this session supports the play/pause toggle command.
 *
 * @see android.media.session.PlaybackState.Builder#setActions(long)
 * @apiSince 21
 */

public static final long ACTION_PLAY_PAUSE = 512L; // 0x200L

/**
 * Indicates this session supports the prepare command.
 *
 * @see android.media.session.PlaybackState.Builder#setActions(long)
 * @apiSince 24
 */

public static final long ACTION_PREPARE = 16384L; // 0x4000L

/**
 * Indicates this session supports the prepare from media id command.
 *
 * @see android.media.session.PlaybackState.Builder#setActions(long)
 * @apiSince 24
 */

public static final long ACTION_PREPARE_FROM_MEDIA_ID = 32768L; // 0x8000L

/**
 * Indicates this session supports the prepare from search command.
 *
 * @see android.media.session.PlaybackState.Builder#setActions(long)
 * @apiSince 24
 */

public static final long ACTION_PREPARE_FROM_SEARCH = 65536L; // 0x10000L

/**
 * Indicates this session supports the prepare from URI command.
 *
 * @see android.media.session.PlaybackState.Builder#setActions(long)
 * @apiSince 24
 */

public static final long ACTION_PREPARE_FROM_URI = 131072L; // 0x20000L

/**
 * Indicates this session supports the rewind command.
 *
 * @see android.media.session.PlaybackState.Builder#setActions(long)
 * @apiSince 21
 */

public static final long ACTION_REWIND = 8L; // 0x8L

/**
 * Indicates this session supports the seek to command.
 *
 * @see android.media.session.PlaybackState.Builder#setActions(long)
 * @apiSince 21
 */

public static final long ACTION_SEEK_TO = 256L; // 0x100L

/**
 * Indicates this session supports the set rating command.
 *
 * @see android.media.session.PlaybackState.Builder#setActions(long)
 * @apiSince 21
 */

public static final long ACTION_SET_RATING = 128L; // 0x80L

/**
 * Indicates this session supports the next command.
 *
 * @see android.media.session.PlaybackState.Builder#setActions(long)
 * @apiSince 21
 */

public static final long ACTION_SKIP_TO_NEXT = 32L; // 0x20L

/**
 * Indicates this session supports the previous command.
 *
 * @see android.media.session.PlaybackState.Builder#setActions(long)
 * @apiSince 21
 */

public static final long ACTION_SKIP_TO_PREVIOUS = 16L; // 0x10L

/**
 * Indicates this session supports the skip to queue item command.
 *
 * @see android.media.session.PlaybackState.Builder#setActions(long)
 * @apiSince 21
 */

public static final long ACTION_SKIP_TO_QUEUE_ITEM = 4096L; // 0x1000L

/**
 * Indicates this session supports the stop command.
 *
 * @see android.media.session.PlaybackState.Builder#setActions(long)
 * @apiSince 21
 */

public static final long ACTION_STOP = 1L; // 0x1L

/** @apiSince 21 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.media.session.PlaybackState> CREATOR;
static { CREATOR = null; }

/**
 * Use this value for the position to indicate the position is not known.
 * @apiSince 21
 */

public static final long PLAYBACK_POSITION_UNKNOWN = -1L; // 0xffffffffffffffffL

/**
 * State indicating this item is currently buffering and will begin playing
 * when enough data has buffered.
 *
 * @see Builder#setState
 * @apiSince 21
 */

public static final int STATE_BUFFERING = 6; // 0x6

/**
 * State indicating the class doing playback is currently connecting to a
 * new destination.  Depending on the implementation you may return to the previous
 * state when the connection finishes or enter {@link #STATE_NONE}.
 * If the connection failed {@link #STATE_ERROR} should be used.
 *
 * @see Builder#setState
 * @apiSince 21
 */

public static final int STATE_CONNECTING = 8; // 0x8

/**
 * State indicating this item is currently in an error state. The error
 * message should also be set when entering this state.
 *
 * @see Builder#setState
 * @apiSince 21
 */

public static final int STATE_ERROR = 7; // 0x7

/**
 * State indicating this item is currently fast forwarding.
 *
 * @see Builder#setState
 * @apiSince 21
 */

public static final int STATE_FAST_FORWARDING = 4; // 0x4

/**
 * This is the default playback state and indicates that no media has been
 * added yet, or the performer has been reset and has no content to play.
 *
 * @see android.media.session.PlaybackState.Builder#setState(int, long, float)
 * @see android.media.session.PlaybackState.Builder#setState(int, long, float, long)
 * @apiSince 21
 */

public static final int STATE_NONE = 0; // 0x0

/**
 * State indicating this item is currently paused.
 *
 * @see Builder#setState
 * @apiSince 21
 */

public static final int STATE_PAUSED = 2; // 0x2

/**
 * State indicating this item is currently playing.
 *
 * @see Builder#setState
 * @apiSince 21
 */

public static final int STATE_PLAYING = 3; // 0x3

/**
 * State indicating this item is currently rewinding.
 *
 * @see Builder#setState
 * @apiSince 21
 */

public static final int STATE_REWINDING = 5; // 0x5

/**
 * State indicating the player is currently skipping to the next item.
 *
 * @see Builder#setState
 * @apiSince 21
 */

public static final int STATE_SKIPPING_TO_NEXT = 10; // 0xa

/**
 * State indicating the player is currently skipping to the previous item.
 *
 * @see Builder#setState
 * @apiSince 21
 */

public static final int STATE_SKIPPING_TO_PREVIOUS = 9; // 0x9

/**
 * State indicating the player is currently skipping to a specific item in
 * the queue.
 *
 * @see Builder#setState
 * @apiSince 21
 */

public static final int STATE_SKIPPING_TO_QUEUE_ITEM = 11; // 0xb

/**
 * State indicating this item is currently stopped.
 *
 * @see Builder#setState
 * @apiSince 21
 */

public static final int STATE_STOPPED = 1; // 0x1
/**
 * Builder for {@link android.media.session.PlaybackState PlaybackState} objects.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Creates an initially empty state builder.
 * @apiSince 21
 */

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Creates a builder with the same initial values as those in the from
 * state.
 *
 * @param from The state to use for initializing the builder.
 * @apiSince 21
 */

public Builder(android.media.session.PlaybackState from) { throw new RuntimeException("Stub!"); }

/**
 * Set the current state of playback.
 * <p>
 * The position must be in ms and indicates the current playback
 * position within the item. If the position is unknown use
 * {@link #PLAYBACK_POSITION_UNKNOWN}. When not using an unknown
 * position the time at which the position was updated must be provided.
 * It is okay to use {@link android.os.SystemClock#elapsedRealtime() SystemClock#elapsedRealtime()} if the
 * current position was just retrieved.
 * <p>
 * The speed is a multiple of normal playback and should be 0 when
 * paused and negative when rewinding. Normal playback speed is 1.0.
 * <p>
 * The state must be one of the following:
 * <ul>
 * <li> {@link android.media.session.PlaybackState#STATE_NONE PlaybackState#STATE_NONE}</li>
 * <li> {@link android.media.session.PlaybackState#STATE_STOPPED PlaybackState#STATE_STOPPED}</li>
 * <li> {@link android.media.session.PlaybackState#STATE_PLAYING PlaybackState#STATE_PLAYING}</li>
 * <li> {@link android.media.session.PlaybackState#STATE_PAUSED PlaybackState#STATE_PAUSED}</li>
 * <li> {@link android.media.session.PlaybackState#STATE_FAST_FORWARDING PlaybackState#STATE_FAST_FORWARDING}</li>
 * <li> {@link android.media.session.PlaybackState#STATE_REWINDING PlaybackState#STATE_REWINDING}</li>
 * <li> {@link android.media.session.PlaybackState#STATE_BUFFERING PlaybackState#STATE_BUFFERING}</li>
 * <li> {@link android.media.session.PlaybackState#STATE_ERROR PlaybackState#STATE_ERROR}</li>
 * <li> {@link android.media.session.PlaybackState#STATE_CONNECTING PlaybackState#STATE_CONNECTING}</li>
 * <li> {@link android.media.session.PlaybackState#STATE_SKIPPING_TO_PREVIOUS PlaybackState#STATE_SKIPPING_TO_PREVIOUS}</li>
 * <li> {@link android.media.session.PlaybackState#STATE_SKIPPING_TO_NEXT PlaybackState#STATE_SKIPPING_TO_NEXT}</li>
 * <li> {@link android.media.session.PlaybackState#STATE_SKIPPING_TO_QUEUE_ITEM PlaybackState#STATE_SKIPPING_TO_QUEUE_ITEM}</li>
 * </ul>
 *
 * @param state The current state of playback.
 * Value is {@link android.media.session.PlaybackState#STATE_NONE}, {@link android.media.session.PlaybackState#STATE_STOPPED}, {@link android.media.session.PlaybackState#STATE_PAUSED}, {@link android.media.session.PlaybackState#STATE_PLAYING}, {@link android.media.session.PlaybackState#STATE_FAST_FORWARDING}, {@link android.media.session.PlaybackState#STATE_REWINDING}, {@link android.media.session.PlaybackState#STATE_BUFFERING}, {@link android.media.session.PlaybackState#STATE_ERROR}, {@link android.media.session.PlaybackState#STATE_CONNECTING}, {@link android.media.session.PlaybackState#STATE_SKIPPING_TO_PREVIOUS}, {@link android.media.session.PlaybackState#STATE_SKIPPING_TO_NEXT}, or {@link android.media.session.PlaybackState#STATE_SKIPPING_TO_QUEUE_ITEM}
 * @param position The position in the current item in ms.
 * @param playbackSpeed The current speed of playback as a multiple of
 *            normal playback.
 * @param updateTime The time in the {@link android.os.SystemClock#elapsedRealtime SystemClock#elapsedRealtime}
 *            timebase that the position was updated at.
 * @return this
 * @apiSince 21
 */

public android.media.session.PlaybackState.Builder setState(int state, long position, float playbackSpeed, long updateTime) { throw new RuntimeException("Stub!"); }

/**
 * Set the current state of playback.
 * <p>
 * The position must be in ms and indicates the current playback
 * position within the item. If the position is unknown use
 * {@link #PLAYBACK_POSITION_UNKNOWN}. The update time will be set to
 * the current {@link android.os.SystemClock#elapsedRealtime() SystemClock#elapsedRealtime()}.
 * <p>
 * The speed is a multiple of normal playback and should be 0 when
 * paused and negative when rewinding. Normal playback speed is 1.0.
 * <p>
 * The state must be one of the following:
 * <ul>
 * <li> {@link android.media.session.PlaybackState#STATE_NONE PlaybackState#STATE_NONE}</li>
 * <li> {@link android.media.session.PlaybackState#STATE_STOPPED PlaybackState#STATE_STOPPED}</li>
 * <li> {@link android.media.session.PlaybackState#STATE_PLAYING PlaybackState#STATE_PLAYING}</li>
 * <li> {@link android.media.session.PlaybackState#STATE_PAUSED PlaybackState#STATE_PAUSED}</li>
 * <li> {@link android.media.session.PlaybackState#STATE_FAST_FORWARDING PlaybackState#STATE_FAST_FORWARDING}</li>
 * <li> {@link android.media.session.PlaybackState#STATE_REWINDING PlaybackState#STATE_REWINDING}</li>
 * <li> {@link android.media.session.PlaybackState#STATE_BUFFERING PlaybackState#STATE_BUFFERING}</li>
 * <li> {@link android.media.session.PlaybackState#STATE_ERROR PlaybackState#STATE_ERROR}</li>
 * <li> {@link android.media.session.PlaybackState#STATE_CONNECTING PlaybackState#STATE_CONNECTING}</li>
 * <li> {@link android.media.session.PlaybackState#STATE_SKIPPING_TO_PREVIOUS PlaybackState#STATE_SKIPPING_TO_PREVIOUS}</li>
 * <li> {@link android.media.session.PlaybackState#STATE_SKIPPING_TO_NEXT PlaybackState#STATE_SKIPPING_TO_NEXT}</li>
 * <li> {@link android.media.session.PlaybackState#STATE_SKIPPING_TO_QUEUE_ITEM PlaybackState#STATE_SKIPPING_TO_QUEUE_ITEM}</li>
 * </ul>
 *
 * @param state The current state of playback.
 * Value is {@link android.media.session.PlaybackState#STATE_NONE}, {@link android.media.session.PlaybackState#STATE_STOPPED}, {@link android.media.session.PlaybackState#STATE_PAUSED}, {@link android.media.session.PlaybackState#STATE_PLAYING}, {@link android.media.session.PlaybackState#STATE_FAST_FORWARDING}, {@link android.media.session.PlaybackState#STATE_REWINDING}, {@link android.media.session.PlaybackState#STATE_BUFFERING}, {@link android.media.session.PlaybackState#STATE_ERROR}, {@link android.media.session.PlaybackState#STATE_CONNECTING}, {@link android.media.session.PlaybackState#STATE_SKIPPING_TO_PREVIOUS}, {@link android.media.session.PlaybackState#STATE_SKIPPING_TO_NEXT}, or {@link android.media.session.PlaybackState#STATE_SKIPPING_TO_QUEUE_ITEM}
 * @param position The position in the current item in ms.
 * @param playbackSpeed The current speed of playback as a multiple of
 *            normal playback.
 * @return this
 * @apiSince 21
 */

public android.media.session.PlaybackState.Builder setState(int state, long position, float playbackSpeed) { throw new RuntimeException("Stub!"); }

/**
 * Set the current actions available on this session. This should use a
 * bitmask of possible actions.
 * <ul>
 * <li> {@link android.media.session.PlaybackState#ACTION_SKIP_TO_PREVIOUS PlaybackState#ACTION_SKIP_TO_PREVIOUS}</li>
 * <li> {@link android.media.session.PlaybackState#ACTION_REWIND PlaybackState#ACTION_REWIND}</li>
 * <li> {@link android.media.session.PlaybackState#ACTION_PLAY PlaybackState#ACTION_PLAY}</li>
 * <li> {@link android.media.session.PlaybackState#ACTION_PAUSE PlaybackState#ACTION_PAUSE}</li>
 * <li> {@link android.media.session.PlaybackState#ACTION_STOP PlaybackState#ACTION_STOP}</li>
 * <li> {@link android.media.session.PlaybackState#ACTION_FAST_FORWARD PlaybackState#ACTION_FAST_FORWARD}</li>
 * <li> {@link android.media.session.PlaybackState#ACTION_SKIP_TO_NEXT PlaybackState#ACTION_SKIP_TO_NEXT}</li>
 * <li> {@link android.media.session.PlaybackState#ACTION_SEEK_TO PlaybackState#ACTION_SEEK_TO}</li>
 * <li> {@link android.media.session.PlaybackState#ACTION_SET_RATING PlaybackState#ACTION_SET_RATING}</li>
 * <li> {@link android.media.session.PlaybackState#ACTION_PLAY_PAUSE PlaybackState#ACTION_PLAY_PAUSE}</li>
 * <li> {@link android.media.session.PlaybackState#ACTION_PLAY_FROM_MEDIA_ID PlaybackState#ACTION_PLAY_FROM_MEDIA_ID}</li>
 * <li> {@link android.media.session.PlaybackState#ACTION_PLAY_FROM_SEARCH PlaybackState#ACTION_PLAY_FROM_SEARCH}</li>
 * <li> {@link android.media.session.PlaybackState#ACTION_SKIP_TO_QUEUE_ITEM PlaybackState#ACTION_SKIP_TO_QUEUE_ITEM}</li>
 * <li> {@link android.media.session.PlaybackState#ACTION_PLAY_FROM_URI PlaybackState#ACTION_PLAY_FROM_URI}</li>
 * <li> {@link android.media.session.PlaybackState#ACTION_PREPARE PlaybackState#ACTION_PREPARE}</li>
 * <li> {@link android.media.session.PlaybackState#ACTION_PREPARE_FROM_MEDIA_ID PlaybackState#ACTION_PREPARE_FROM_MEDIA_ID}</li>
 * <li> {@link android.media.session.PlaybackState#ACTION_PREPARE_FROM_SEARCH PlaybackState#ACTION_PREPARE_FROM_SEARCH}</li>
 * <li> {@link android.media.session.PlaybackState#ACTION_PREPARE_FROM_URI PlaybackState#ACTION_PREPARE_FROM_URI}</li>
 * </ul>
 *
 * @param actions The set of actions allowed.
 * Value is either <code>0</code> or a combination of {@link android.media.session.PlaybackState#ACTION_STOP}, {@link android.media.session.PlaybackState#ACTION_PAUSE}, {@link android.media.session.PlaybackState#ACTION_PLAY}, {@link android.media.session.PlaybackState#ACTION_REWIND}, {@link android.media.session.PlaybackState#ACTION_SKIP_TO_PREVIOUS}, {@link android.media.session.PlaybackState#ACTION_SKIP_TO_NEXT}, {@link android.media.session.PlaybackState#ACTION_FAST_FORWARD}, {@link android.media.session.PlaybackState#ACTION_SET_RATING}, {@link android.media.session.PlaybackState#ACTION_SEEK_TO}, {@link android.media.session.PlaybackState#ACTION_PLAY_PAUSE}, {@link android.media.session.PlaybackState#ACTION_PLAY_FROM_MEDIA_ID}, {@link android.media.session.PlaybackState#ACTION_PLAY_FROM_SEARCH}, {@link android.media.session.PlaybackState#ACTION_SKIP_TO_QUEUE_ITEM}, {@link android.media.session.PlaybackState#ACTION_PLAY_FROM_URI}, {@link android.media.session.PlaybackState#ACTION_PREPARE}, {@link android.media.session.PlaybackState#ACTION_PREPARE_FROM_MEDIA_ID}, {@link android.media.session.PlaybackState#ACTION_PREPARE_FROM_SEARCH}, and {@link android.media.session.PlaybackState#ACTION_PREPARE_FROM_URI}
 * @return this
 * @apiSince 21
 */

public android.media.session.PlaybackState.Builder setActions(long actions) { throw new RuntimeException("Stub!"); }

/**
 * Add a custom action to the playback state. Actions can be used to
 * expose additional functionality to {@link android.media.session.MediaController MediaController} beyond what is offered by the standard transport
 * controls.
 * <p>
 * e.g. start a radio station based on the current item or skip ahead by
 * 30 seconds.
 *
 * @param action An identifier for this action. It can be sent back to
 *            the {@link android.media.session.MediaSession MediaSession} through
 *            {@link android.media.session.MediaController.TransportControls#sendCustomAction(java.lang.String,android.os.Bundle) MediaController.TransportControls#sendCustomAction(String, Bundle)}.
 * @param name The display name for the action. If text is shown with
 *            the action or used for accessibility, this is what should
 *            be used.
 * @param icon The resource action of the icon that should be displayed
 *            for the action. The resource should be in the package of
 *            the {@link android.media.session.MediaSession MediaSession}.
 * @return this
 * @apiSince 21
 */

public android.media.session.PlaybackState.Builder addCustomAction(java.lang.String action, java.lang.String name, int icon) { throw new RuntimeException("Stub!"); }

/**
 * Add a custom action to the playback state. Actions can be used to expose additional
 * functionality to {@link android.media.session.MediaController MediaController} beyond what is offered by the
 * standard transport controls.
 * <p>
 * An example of an action would be to start a radio station based on the current item
 * or to skip ahead by 30 seconds.
 *
 * @param customAction The custom action to add to the {@link android.media.session.PlaybackState PlaybackState}.
 * @return this
 * @apiSince 21
 */

public android.media.session.PlaybackState.Builder addCustomAction(android.media.session.PlaybackState.CustomAction customAction) { throw new RuntimeException("Stub!"); }

/**
 * Set the current buffered position in ms. This is the farthest
 * playback point that can be reached from the current position using
 * only buffered content.
 *
 * @param bufferedPosition The position in ms that playback is buffered
 *            to.
 * @return this
 * @apiSince 21
 */

public android.media.session.PlaybackState.Builder setBufferedPosition(long bufferedPosition) { throw new RuntimeException("Stub!"); }

/**
 * Set the active item in the play queue by specifying its id. The
 * default value is {@link android.media.session.MediaSession.QueueItem#UNKNOWN_ID MediaSession.QueueItem#UNKNOWN_ID}
 *
 * @param id The id of the active item.
 * @return this
 * @apiSince 21
 */

public android.media.session.PlaybackState.Builder setActiveQueueItemId(long id) { throw new RuntimeException("Stub!"); }

/**
 * Set a user readable error message. This should be set when the state
 * is {@link android.media.session.PlaybackState#STATE_ERROR PlaybackState#STATE_ERROR}.
 *
 * @param error The error message for display to the user.
 * @return this
 * @apiSince 21
 */

public android.media.session.PlaybackState.Builder setErrorMessage(java.lang.CharSequence error) { throw new RuntimeException("Stub!"); }

/**
 * Set any custom extras to be included with the playback state.
 *
 * @param extras The extras to include.
 * @return this
 * @apiSince 22
 */

public android.media.session.PlaybackState.Builder setExtras(android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Build and return the {@link android.media.session.PlaybackState PlaybackState} instance with these
 * values.
 *
 * @return A new state instance.
 * @apiSince 21
 */

public android.media.session.PlaybackState build() { throw new RuntimeException("Stub!"); }
}

/**
 * {@link android.media.session.PlaybackState.CustomAction PlaybackState.CustomAction} can be used to extend the capabilities of
 * the standard transport controls by exposing app specific actions to
 * {@link android.media.session.MediaController MediaController}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class CustomAction implements android.os.Parcelable {

private CustomAction() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Returns the action of the {@link android.media.session.PlaybackState.CustomAction CustomAction}.
 *
 * @return The action of the {@link android.media.session.PlaybackState.CustomAction CustomAction}.
 * @apiSince 21
 */

public java.lang.String getAction() { throw new RuntimeException("Stub!"); }

/**
 * Returns the display name of this action. e.g. "Favorite"
 *
 * @return The display name of this {@link android.media.session.PlaybackState.CustomAction CustomAction}.
 * @apiSince 21
 */

public java.lang.CharSequence getName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the resource id of the icon in the {@link android.media.session.MediaSession MediaSession} package.
 *
 * @return The resource id of the icon in the {@link android.media.session.MediaSession MediaSession} package.
 * @apiSince 21
 */

public int getIcon() { throw new RuntimeException("Stub!"); }

/**
 * Returns extras which provide additional application-specific information about the
 * action, or null if none. These arguments are meant to be consumed by a
 * {@link android.media.session.MediaController MediaController} if it knows how to handle them.
 *
 * @return Optional arguments for the {@link android.media.session.PlaybackState.CustomAction CustomAction}.
 * @apiSince 21
 */

public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.media.session.PlaybackState.CustomAction> CREATOR;
static { CREATOR = null; }
/**
 * Builder for {@link android.media.session.PlaybackState.CustomAction CustomAction} objects.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Creates a {@link android.media.session.PlaybackState.CustomAction CustomAction} builder with the id, name, and icon set.
 *
 * @param action The action of the {@link android.media.session.PlaybackState.CustomAction CustomAction}.
 * @param name The display name of the {@link android.media.session.PlaybackState.CustomAction CustomAction}. This name will be displayed
 *             along side the action if the UI supports it.
 * @param icon The icon resource id of the {@link android.media.session.PlaybackState.CustomAction CustomAction}. This resource id
 *             must be in the same package as the {@link android.media.session.MediaSession MediaSession}. It will be
 *             displayed with the custom action if the UI supports it.
 * @apiSince 21
 */

public Builder(java.lang.String action, java.lang.CharSequence name, int icon) { throw new RuntimeException("Stub!"); }

/**
 * Set optional extras for the {@link android.media.session.PlaybackState.CustomAction CustomAction}. These extras are meant to be
 * consumed by a {@link android.media.session.MediaController MediaController} if it knows how to handle them.
 * Keys should be fully qualified (e.g. "com.example.MY_ARG") to avoid collisions.
 *
 * @param extras Optional extras for the {@link android.media.session.PlaybackState.CustomAction CustomAction}.
 * @return this.
 * @apiSince 21
 */

public android.media.session.PlaybackState.CustomAction.Builder setExtras(android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Build and return the {@link android.media.session.PlaybackState.CustomAction CustomAction} instance with the specified values.
 *
 * @return A new {@link android.media.session.PlaybackState.CustomAction CustomAction} instance.
 * @apiSince 21
 */

public android.media.session.PlaybackState.CustomAction build() { throw new RuntimeException("Stub!"); }
}

}

}

