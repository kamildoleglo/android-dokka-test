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


package android.media.tv;

import android.media.PlaybackParams;
import android.net.Uri;

/**
 * Displays TV contents. The TvView class provides a high level interface for applications to show
 * TV programs from various TV sources that implement {@link android.media.tv.TvInputService TvInputService}. (Note that the list of
 * TV inputs available on the system can be obtained by calling
 * {@link android.media.tv.TvInputManager#getTvInputList() TvInputManager#getTvInputList()}.)
 *
 * <p>Once the application supplies the URI for a specific TV channel to {@link #tune}
 * method, it takes care of underlying service binding (and unbinding if the current TvView is
 * already bound to a service) and automatically allocates/deallocates resources needed. In addition
 * to a few essential methods to control how the contents are presented, it also provides a way to
 * dispatch input events to the connected TvInputService in order to enable custom key actions for
 * the TV input.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TvView extends android.view.ViewGroup {

/** @apiSince 21 */

public TvView(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public TvView(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public TvView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Sets the callback to be invoked when an event is dispatched to this TvView.
 *
 * @param callback The callback to receive events. A value of {@code null} removes the existing
 *            callback.
 
 * This value may be {@code null}.
 * @apiSince 21
 */

public void setCallback(@androidx.annotation.Nullable android.media.tv.TvView.TvInputCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Controls whether the TvView's surface is placed on top of another regular surface view in the
 * window (but still behind the window itself).
 * This is typically used to place overlays on top of an underlying TvView.
 *
 * <p>Note that this must be set before the TvView's containing window is attached to the
 * window manager.
 *
 * <p>Calling this overrides any previous call to {@link #setZOrderOnTop}.
 *
 * @param isMediaOverlay {@code true} to be on top of another regular surface, {@code false}
 *            otherwise.
 * @apiSince 24
 */

public void setZOrderMediaOverlay(boolean isMediaOverlay) { throw new RuntimeException("Stub!"); }

/**
 * Controls whether the TvView's surface is placed on top of its window. Normally it is placed
 * behind the window, to allow it to (for the most part) appear to composite with the views in
 * the hierarchy.  By setting this, you cause it to be placed above the window. This means that
 * none of the contents of the window this TvView is in will be visible on top of its surface.
 *
 * <p>Note that this must be set before the TvView's containing window is attached to the window
 * manager.
 *
 * <p>Calling this overrides any previous call to {@link #setZOrderMediaOverlay}.
 *
 * @param onTop {@code true} to be on top of its window, {@code false} otherwise.
 * @apiSince 24
 */

public void setZOrderOnTop(boolean onTop) { throw new RuntimeException("Stub!"); }

/**
 * Sets the relative stream volume of this TvView.
 *
 * <p>This method is primarily used to handle audio focus changes or mute a specific TvView when
 * multiple views are displayed. If the method has not yet been called, the TvView assumes the
 * default value of {@code 1.0f}.
 *
 * @param volume A volume value between {@code 0.0f} to {@code 1.0f}.
 
 * Value is between 0.0 and 1.0 inclusive
 * @apiSince 21
 */

public void setStreamVolume(float volume) { throw new RuntimeException("Stub!"); }

/**
 * Tunes to a given channel.
 *
 * @param inputId The ID of the TV input for the given channel.
 * This value must never be {@code null}.
 * @param channelUri The URI of a channel.
 * @apiSince 21
 */

public void tune(@androidx.annotation.NonNull java.lang.String inputId, android.net.Uri channelUri) { throw new RuntimeException("Stub!"); }

/**
 * Tunes to a given channel. This can be used to provide domain-specific features that are only
 * known between certain clients and their TV inputs.
 *
 * @param inputId The ID of TV input for the given channel.
 * @param channelUri The URI of a channel.
 * @param params Domain-specific data for this tune request. Keys <em>must</em> be a scoped
 *            name, i.e. prefixed with a package name you own, so that different developers will
 *            not create conflicting keys.
 * @apiSince 24
 */

public void tune(java.lang.String inputId, android.net.Uri channelUri, android.os.Bundle params) { throw new RuntimeException("Stub!"); }

/**
 * Resets this TvView.
 *
 * <p>This method is primarily used to un-tune the current TvView.
 * @apiSince 21
 */

public void reset() { throw new RuntimeException("Stub!"); }

/**
 * Enables or disables the caption in this TvView.
 *
 * <p>Note that this method does not take any effect unless the current TvView is tuned.
 *
 * @param enabled {@code true} to enable, {@code false} to disable.
 * @apiSince 21
 */

public void setCaptionEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Selects a track.
 *
 * @param type The type of the track to select. The type can be {@link android.media.tv.TvTrackInfo#TYPE_AUDIO TvTrackInfo#TYPE_AUDIO},
 *            {@link android.media.tv.TvTrackInfo#TYPE_VIDEO TvTrackInfo#TYPE_VIDEO} or {@link android.media.tv.TvTrackInfo#TYPE_SUBTITLE TvTrackInfo#TYPE_SUBTITLE}.
 * @param trackId The ID of the track to select. {@code null} means to unselect the current
 *            track for a given type.
 * @see #getTracks
 * @see #getSelectedTrack
 * @apiSince 21
 */

public void selectTrack(int type, java.lang.String trackId) { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of tracks. Returns {@code null} if the information is not available.
 *
 * @param type The type of the tracks. The type can be {@link android.media.tv.TvTrackInfo#TYPE_AUDIO TvTrackInfo#TYPE_AUDIO},
 *            {@link android.media.tv.TvTrackInfo#TYPE_VIDEO TvTrackInfo#TYPE_VIDEO} or {@link android.media.tv.TvTrackInfo#TYPE_SUBTITLE TvTrackInfo#TYPE_SUBTITLE}.
 * @see #selectTrack
 * @see #getSelectedTrack
 * @apiSince 21
 */

public java.util.List<android.media.tv.TvTrackInfo> getTracks(int type) { throw new RuntimeException("Stub!"); }

/**
 * Returns the ID of the selected track for a given type. Returns {@code null} if the
 * information is not available or the track is not selected.
 *
 * @param type The type of the selected tracks. The type can be {@link android.media.tv.TvTrackInfo#TYPE_AUDIO TvTrackInfo#TYPE_AUDIO},
 *            {@link android.media.tv.TvTrackInfo#TYPE_VIDEO TvTrackInfo#TYPE_VIDEO} or {@link android.media.tv.TvTrackInfo#TYPE_SUBTITLE TvTrackInfo#TYPE_SUBTITLE}.
 * @see #selectTrack
 * @see #getTracks
 * @apiSince 21
 */

public java.lang.String getSelectedTrack(int type) { throw new RuntimeException("Stub!"); }

/**
 * Plays a given recorded TV program.
 *
 * @param inputId The ID of the TV input that created the given recorded program.
 * @param recordedProgramUri The URI of a recorded program.
 * @apiSince 24
 */

public void timeShiftPlay(java.lang.String inputId, android.net.Uri recordedProgramUri) { throw new RuntimeException("Stub!"); }

/**
 * Pauses playback. No-op if it is already paused. Call {@link #timeShiftResume} to resume.
 * @apiSince 23
 */

public void timeShiftPause() { throw new RuntimeException("Stub!"); }

/**
 * Resumes playback. No-op if it is already resumed. Call {@link #timeShiftPause} to pause.
 * @apiSince 23
 */

public void timeShiftResume() { throw new RuntimeException("Stub!"); }

/**
 * Seeks to a specified time position. {@code timeMs} must be equal to or greater than the start
 * position returned by {@link android.media.tv.TvView.TimeShiftPositionCallback#onTimeShiftStartPositionChanged TimeShiftPositionCallback#onTimeShiftStartPositionChanged} and
 * equal to or less than the current time.
 *
 * @param timeMs The time position to seek to, in milliseconds since the epoch.
 * @apiSince 23
 */

public void timeShiftSeekTo(long timeMs) { throw new RuntimeException("Stub!"); }

/**
 * Sets playback rate using {@link android.media.PlaybackParams}.
 *
 * @param params The playback params.
 
 * This value must never be {@code null}.
 * @apiSince 23
 */

public void timeShiftSetPlaybackParams(@androidx.annotation.NonNull android.media.PlaybackParams params) { throw new RuntimeException("Stub!"); }

/**
 * Sets the callback to be invoked when the time shift position is changed.
 *
 * @param callback The callback to receive time shift position changes. A value of {@code null}
 *            removes the existing callback.
 
 * This value may be {@code null}.
 * @apiSince 23
 */

public void setTimeShiftPositionCallback(@androidx.annotation.Nullable android.media.tv.TvView.TimeShiftPositionCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Sends a private command to the underlying TV input. This can be used to provide
 * domain-specific features that are only known between certain clients and their TV inputs.
 *
 * @param action The name of the private command to send. This <em>must</em> be a scoped name,
 *            i.e. prefixed with a package name you own, so that different developers will not
 *            create conflicting commands.
 * This value must never be {@code null}.
 * @param data An optional bundle to send with the command.
 * @apiSince 24
 */

public void sendAppPrivateCommand(@androidx.annotation.NonNull java.lang.String action, android.os.Bundle data) { throw new RuntimeException("Stub!"); }

/**
 * Dispatches an unhandled input event to the next receiver.
 *
 * <p>Except system keys, TvView always consumes input events in the normal flow. This is called
 * asynchronously from where the event is dispatched. It gives the host application a chance to
 * dispatch the unhandled input events.
 *
 * @param event The input event.
 * @return {@code true} if the event was handled by the view, {@code false} otherwise.
 * @apiSince 21
 */

public boolean dispatchUnhandledInputEvent(android.view.InputEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Called when an unhandled input event also has not been handled by the user provided
 * callback. This is the last chance to handle the unhandled input event in the TvView.
 *
 * @param event The input event.
 * @return If you handled the event, return {@code true}. If you want to allow the event to be
 *         handled by the next receiver, return {@code false}.
 * @apiSince 21
 */

public boolean onUnhandledInputEvent(android.view.InputEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Registers a callback to be invoked when an input event is not handled by the bound TV input.
 *
 * @param listener The callback to be invoked when the unhandled input event is received.
 * @apiSince 21
 */

public void setOnUnhandledInputEventListener(android.media.tv.TvView.OnUnhandledInputEventListener listener) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean dispatchKeyEvent(android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean dispatchTouchEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean dispatchTrackballEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean dispatchGenericMotionEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void dispatchWindowFocusChanged(boolean hasFocus) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

protected void onAttachedToWindow() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

protected void onDetachedFromWindow() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

protected void onLayout(boolean changed, int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean gatherTransparentRegion(android.graphics.Region region) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void draw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

protected void dispatchDraw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

protected void onVisibilityChanged(android.view.View changedView, int visibility) { throw new RuntimeException("Stub!"); }
/**
 * Interface definition for a callback to be invoked when the unhandled input event is received.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnUnhandledInputEventListener {

/**
 * Called when an input event was not handled by the bound TV input.
 *
 * <p>This is called asynchronously from where the event is dispatched. It gives the host
 * application a chance to handle the unhandled input events.
 *
 * @param event The input event.
 * @return If you handled the event, return {@code true}. If you want to allow the event to
 *         be handled by the next receiver, return {@code false}.
 * @apiSince 21
 */

public boolean onUnhandledInputEvent(android.view.InputEvent event);
}

/**
 * Callback used to receive time shift position changes.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class TimeShiftPositionCallback {

public TimeShiftPositionCallback() { throw new RuntimeException("Stub!"); }

/**
 * This is called when the start position for time shifting has changed.
 *
 * <p>The start position for time shifting indicates the earliest possible time the user can
 * seek to. Initially this is equivalent to the time when the underlying TV input starts
 * recording. Later it may be adjusted because there is insufficient space or the duration
 * of recording is limited. The application must not allow the user to seek to a position
 * earlier than the start position.
 *
 * <p>For playback of a recorded program initiated by {@link #timeShiftPlay(java.lang.String,android.net.Uri)},
 * the start position is the time when playback starts. It does not change.
 *
 * @param inputId The ID of the TV input bound to this view.
 * @param timeMs The start position for time shifting, in milliseconds since the epoch.
 * @apiSince 23
 */

public void onTimeShiftStartPositionChanged(java.lang.String inputId, long timeMs) { throw new RuntimeException("Stub!"); }

/**
 * This is called when the current position for time shifting has changed.
 *
 * <p>The current position for time shifting is the same as the current position of
 * playback. During playback, the current position changes continuously. When paused, it
 * does not change.
 *
 * <p>Note that {@code timeMs} is wall-clock time.
 *
 * @param inputId The ID of the TV input bound to this view.
 * @param timeMs The current position for time shifting, in milliseconds since the epoch.
 * @apiSince 23
 */

public void onTimeShiftCurrentPositionChanged(java.lang.String inputId, long timeMs) { throw new RuntimeException("Stub!"); }
}

/**
 * Callback used to receive various status updates on the {@link android.media.tv.TvView TvView}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class TvInputCallback {

public TvInputCallback() { throw new RuntimeException("Stub!"); }

/**
 * This is invoked when an error occurred while establishing a connection to the underlying
 * TV input.
 *
 * @param inputId The ID of the TV input bound to this view.
 * @apiSince 21
 */

public void onConnectionFailed(java.lang.String inputId) { throw new RuntimeException("Stub!"); }

/**
 * This is invoked when the existing connection to the underlying TV input is lost.
 *
 * @param inputId The ID of the TV input bound to this view.
 * @apiSince 21
 */

public void onDisconnected(java.lang.String inputId) { throw new RuntimeException("Stub!"); }

/**
 * This is invoked when the channel of this TvView is changed by the underlying TV input
 * without any {@link android.media.tv.TvView#tune TvView#tune} request.
 *
 * @param inputId The ID of the TV input bound to this view.
 * @param channelUri The URI of a channel.
 * @apiSince 21
 */

public void onChannelRetuned(java.lang.String inputId, android.net.Uri channelUri) { throw new RuntimeException("Stub!"); }

/**
 * This is called when the track information has been changed.
 *
 * @param inputId The ID of the TV input bound to this view.
 * @param tracks A list which includes track information.
 * @apiSince 21
 */

public void onTracksChanged(java.lang.String inputId, java.util.List<android.media.tv.TvTrackInfo> tracks) { throw new RuntimeException("Stub!"); }

/**
 * This is called when there is a change on the selected tracks.
 *
 * @param inputId The ID of the TV input bound to this view.
 * @param type The type of the track selected. The type can be
 *            {@link android.media.tv.TvTrackInfo#TYPE_AUDIO TvTrackInfo#TYPE_AUDIO}, {@link android.media.tv.TvTrackInfo#TYPE_VIDEO TvTrackInfo#TYPE_VIDEO} or
 *            {@link android.media.tv.TvTrackInfo#TYPE_SUBTITLE TvTrackInfo#TYPE_SUBTITLE}.
 * @param trackId The ID of the track selected.
 * @apiSince 21
 */

public void onTrackSelected(java.lang.String inputId, int type, java.lang.String trackId) { throw new RuntimeException("Stub!"); }

/**
 * This is invoked when the video size has been changed. It is also called when the first
 * time video size information becomes available after this view is tuned to a specific
 * channel.
 *
 * @param inputId The ID of the TV input bound to this view.
 * @param width The width of the video.
 * @param height The height of the video.
 * @apiSince 21
 */

public void onVideoSizeChanged(java.lang.String inputId, int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * This is called when the video is available, so the TV input starts the playback.
 *
 * @param inputId The ID of the TV input bound to this view.
 * @apiSince 21
 */

public void onVideoAvailable(java.lang.String inputId) { throw new RuntimeException("Stub!"); }

/**
 * This is called when the video is not available, so the TV input stops the playback.
 *
 * @param inputId The ID of the TV input bound to this view.
 * @param reason The reason why the TV input stopped the playback:
 * <ul>
 * <li>{@link android.media.tv.TvInputManager#VIDEO_UNAVAILABLE_REASON_UNKNOWN TvInputManager#VIDEO_UNAVAILABLE_REASON_UNKNOWN}
 * <li>{@link android.media.tv.TvInputManager#VIDEO_UNAVAILABLE_REASON_TUNING TvInputManager#VIDEO_UNAVAILABLE_REASON_TUNING}
 * <li>{@link android.media.tv.TvInputManager#VIDEO_UNAVAILABLE_REASON_WEAK_SIGNAL TvInputManager#VIDEO_UNAVAILABLE_REASON_WEAK_SIGNAL}
 * <li>{@link android.media.tv.TvInputManager#VIDEO_UNAVAILABLE_REASON_BUFFERING TvInputManager#VIDEO_UNAVAILABLE_REASON_BUFFERING}
 * <li>{@link android.media.tv.TvInputManager#VIDEO_UNAVAILABLE_REASON_AUDIO_ONLY TvInputManager#VIDEO_UNAVAILABLE_REASON_AUDIO_ONLY}
 * </ul>
 
 * Value is {@link android.media.tv.TvInputManager#VIDEO_UNAVAILABLE_REASON_UNKNOWN}, {@link android.media.tv.TvInputManager#VIDEO_UNAVAILABLE_REASON_TUNING}, {@link android.media.tv.TvInputManager#VIDEO_UNAVAILABLE_REASON_WEAK_SIGNAL}, {@link android.media.tv.TvInputManager#VIDEO_UNAVAILABLE_REASON_BUFFERING}, or {@link android.media.tv.TvInputManager#VIDEO_UNAVAILABLE_REASON_AUDIO_ONLY}
 * @apiSince 21
 */

public void onVideoUnavailable(java.lang.String inputId, int reason) { throw new RuntimeException("Stub!"); }

/**
 * This is called when the current program content turns out to be allowed to watch since
 * its content rating is not blocked by parental controls.
 *
 * @param inputId The ID of the TV input bound to this view.
 * @apiSince 21
 */

public void onContentAllowed(java.lang.String inputId) { throw new RuntimeException("Stub!"); }

/**
 * This is called when the current program content turns out to be not allowed to watch
 * since its content rating is blocked by parental controls.
 *
 * @param inputId The ID of the TV input bound to this view.
 * @param rating The content rating of the blocked program.
 * @apiSince 21
 */

public void onContentBlocked(java.lang.String inputId, android.media.tv.TvContentRating rating) { throw new RuntimeException("Stub!"); }

/**
 * This is called when the time shift status is changed.
 *
 * @param inputId The ID of the TV input bound to this view.
 * @param status The current time shift status. Should be one of the followings.
 * <ul>
 * <li>{@link android.media.tv.TvInputManager#TIME_SHIFT_STATUS_UNSUPPORTED TvInputManager#TIME_SHIFT_STATUS_UNSUPPORTED}
 * <li>{@link android.media.tv.TvInputManager#TIME_SHIFT_STATUS_UNAVAILABLE TvInputManager#TIME_SHIFT_STATUS_UNAVAILABLE}
 * <li>{@link android.media.tv.TvInputManager#TIME_SHIFT_STATUS_AVAILABLE TvInputManager#TIME_SHIFT_STATUS_AVAILABLE}
 * </ul>
 
 * Value is {@link android.media.tv.TvInputManager#TIME_SHIFT_STATUS_UNKNOWN}, {@link android.media.tv.TvInputManager#TIME_SHIFT_STATUS_UNSUPPORTED}, {@link android.media.tv.TvInputManager#TIME_SHIFT_STATUS_UNAVAILABLE}, or {@link android.media.tv.TvInputManager#TIME_SHIFT_STATUS_AVAILABLE}
 * @apiSince 23
 */

public void onTimeShiftStatusChanged(java.lang.String inputId, int status) { throw new RuntimeException("Stub!"); }
}

}

