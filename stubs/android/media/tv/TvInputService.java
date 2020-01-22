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

import android.graphics.PixelFormat;
import android.net.Uri;
import android.view.accessibility.CaptioningManager;
import android.media.PlaybackParams;
import android.view.KeyEvent;
import android.view.View;

/**
 * The TvInputService class represents a TV input or source such as HDMI or built-in tuner which
 * provides pass-through video or broadcast TV programs.
 *
 * <p>Applications will not normally use this service themselves, instead relying on the standard
 * interaction provided by {@link android.media.tv.TvView TvView}. Those implementing TV input services should normally do
 * so by deriving from this class and providing their own session implementation based on
 * {@link android.media.tv.TvInputService.Session TvInputService.Session}. All TV input services must require that clients hold the
 * {@link android.Manifest.permission#BIND_TV_INPUT} in order to interact with the service; if this
 * permission is not specified in the manifest, the system will refuse to bind to that TV input
 * service.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class TvInputService extends android.app.Service {

public TvInputService() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public final android.os.IBinder onBind(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Returns a concrete implementation of {@link android.media.tv.TvInputService.Session Session}.
 *
 * <p>May return {@code null} if this TV input service fails to create a session for some
 * reason. If TV input represents an external device connected to a hardware TV input,
 * {@link android.media.tv.TvInputService.HardwareSession HardwareSession} should be returned.
 *
 * @param inputId The ID of the TV input associated with the session.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public abstract android.media.tv.TvInputService.Session onCreateSession(java.lang.String inputId);

/**
 * Returns a concrete implementation of {@link android.media.tv.TvInputService.RecordingSession RecordingSession}.
 *
 * <p>May return {@code null} if this TV input service fails to create a recording session for
 * some reason.
 *
 * @param inputId The ID of the TV input associated with the recording session.
 * @apiSince 24
 */

@androidx.annotation.Nullable
public android.media.tv.TvInputService.RecordingSession onCreateRecordingSession(java.lang.String inputId) { throw new RuntimeException("Stub!"); }

/**
 * This is the interface name that a service implementing a TV input should say that it support
 * -- that is, this is the action it uses for its intent filter. To be supported, the service
 * must also require the {@link android.Manifest.permission#BIND_TV_INPUT} permission so that
 * other applications cannot abuse it.
 * @apiSince 21
 */

public static final java.lang.String SERVICE_INTERFACE = "android.media.tv.TvInputService";

/**
 * Name under which a TvInputService component publishes information about itself.
 * This meta-data must reference an XML resource containing an
 * <code>&lt;{@link android.R.styleable#TvInputService tv-input}&gt;</code>
 * tag.
 * @apiSince 21
 */

public static final java.lang.String SERVICE_META_DATA = "android.media.tv.input";
/**
 * Base class for a TV input session which represents an external device connected to a
 * hardware TV input.
 *
 * <p>This class is for an input which provides channels for the external set-top box to the
 * application. Once a TV input returns an implementation of this class on
 * {@link #onCreateSession(java.lang.String)}, the framework will create a separate session for
 * a hardware TV Input (e.g. HDMI 1) and forward the application's surface to the session so
 * that the user can see the screen of the hardware TV Input when she tunes to a channel from
 * this TV input. The implementation of this class is expected to change the channel of the
 * external set-top box via a proprietary protocol when {@link android.media.tv.TvInputService.HardwareSession#onTune HardwareSession#onTune} is
 * requested by the application.
 *
 * <p>Note that this class is not for inputs for internal hardware like built-in tuner and HDMI
 * 1.
 *
 * @see #onCreateSession(String)
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class HardwareSession extends android.media.tv.TvInputService.Session {

/**
 * Creates a new HardwareSession.
 *
 * @param context The context of the application
 * @apiSince 21
 */

public HardwareSession(android.content.Context context) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Returns the hardware TV input ID the external device is connected to.
 *
 * <p>TV input is expected to provide {@link android.R.attr#setupActivity} so that
 * the application can launch it before using this TV input. The setup activity may let
 * the user select the hardware TV input to which the external device is connected. The ID
 * of the selected one should be stored in the TV input so that it can be returned here.
 * @apiSince 21
 */

public abstract java.lang.String getHardwareInputId();

/**
 * This method will not be called in {@link android.media.tv.TvInputService.HardwareSession HardwareSession}. Framework will
 * forward the application's surface to the hardware TV input.
 * @apiSince 21
 */

public final boolean onSetSurface(android.view.Surface surface) { throw new RuntimeException("Stub!"); }

/**
 * Called when the underlying hardware TV input session calls
 * {@link android.media.tv.TvInputService.Session#notifyVideoAvailable() TvInputService.Session#notifyVideoAvailable()}.
 * @apiSince 21
 */

public void onHardwareVideoAvailable() { throw new RuntimeException("Stub!"); }

/**
 * Called when the underlying hardware TV input session calls
 * {@link android.media.tv.TvInputService.Session#notifyVideoUnavailable(int) TvInputService.Session#notifyVideoUnavailable(int)}.
 *
 * @param reason The reason that the hardware TV input stopped the playback:
 * <ul>
 * <li>{@link android.media.tv.TvInputManager#VIDEO_UNAVAILABLE_REASON_UNKNOWN TvInputManager#VIDEO_UNAVAILABLE_REASON_UNKNOWN}
 * <li>{@link android.media.tv.TvInputManager#VIDEO_UNAVAILABLE_REASON_TUNING TvInputManager#VIDEO_UNAVAILABLE_REASON_TUNING}
 * <li>{@link android.media.tv.TvInputManager#VIDEO_UNAVAILABLE_REASON_WEAK_SIGNAL TvInputManager#VIDEO_UNAVAILABLE_REASON_WEAK_SIGNAL}
 * <li>{@link android.media.tv.TvInputManager#VIDEO_UNAVAILABLE_REASON_BUFFERING TvInputManager#VIDEO_UNAVAILABLE_REASON_BUFFERING}
 * <li>{@link android.media.tv.TvInputManager#VIDEO_UNAVAILABLE_REASON_AUDIO_ONLY TvInputManager#VIDEO_UNAVAILABLE_REASON_AUDIO_ONLY}
 * </ul>
 * @apiSince 21
 */

public void onHardwareVideoUnavailable(int reason) { throw new RuntimeException("Stub!"); }
}

/**
 * Base class for derived classes to implement to provide a TV input recording session.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class RecordingSession {

/**
 * Creates a new RecordingSession.
 *
 * @param context The context of the application
 * @apiSince 24
 */

public RecordingSession(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Informs the application that this recording session has been tuned to the given channel
 * and is ready to start recording.
 *
 * <p>Upon receiving a call to {@link #onTune(android.net.Uri)}, the session is expected to tune to the
 * passed channel and call this method to indicate that it is now available for immediate
 * recording. When {@link #onStartRecording(android.net.Uri)} is called, recording must start with
 * minimal delay.
 *
 * @param channelUri The URI of a channel.
 * @apiSince 24
 */

public void notifyTuned(android.net.Uri channelUri) { throw new RuntimeException("Stub!"); }

/**
 * Informs the application that this recording session has stopped recording and created a
 * new data entry in the {@link android.media.tv.TvContract.RecordedPrograms TvContract.RecordedPrograms} table that describes the newly
 * recorded program.
 *
 * <p>The recording session must call this method in response to {@link #onStopRecording()}.
 * The session may call it even before receiving a call to {@link #onStopRecording()} if a
 * partially recorded program is available when there is an error.
 *
 * @param recordedProgramUri The URI of the newly recorded program.
 * @apiSince 24
 */

public void notifyRecordingStopped(android.net.Uri recordedProgramUri) { throw new RuntimeException("Stub!"); }

/**
 * Informs the application that there is an error and this recording session is no longer
 * able to start or continue recording. It may be called at any time after the recording
 * session is created until {@link #onRelease()} is called.
 *
 * <p>The application may release the current session upon receiving the error code through
 * {@link android.media.tv.TvRecordingClient.RecordingCallback#onError(int) TvRecordingClient.RecordingCallback#onError(int)}. The session may call
 * {@link #notifyRecordingStopped(android.net.Uri)} if a partially recorded but still playable program
 * is available, before calling this method.
 *
 * @param error The error code. Should be one of the followings.
 * <ul>
 * <li>{@link android.media.tv.TvInputManager#RECORDING_ERROR_UNKNOWN TvInputManager#RECORDING_ERROR_UNKNOWN}
 * <li>{@link android.media.tv.TvInputManager#RECORDING_ERROR_INSUFFICIENT_SPACE TvInputManager#RECORDING_ERROR_INSUFFICIENT_SPACE}
 * <li>{@link android.media.tv.TvInputManager#RECORDING_ERROR_RESOURCE_BUSY TvInputManager#RECORDING_ERROR_RESOURCE_BUSY}
 * </ul>
 
 * Value is {@link android.media.tv.TvInputManager#RECORDING_ERROR_UNKNOWN}, {@link android.media.tv.TvInputManager#RECORDING_ERROR_INSUFFICIENT_SPACE}, or {@link android.media.tv.TvInputManager#RECORDING_ERROR_RESOURCE_BUSY}
 * @apiSince 24
 */

public void notifyError(int error) { throw new RuntimeException("Stub!"); }

/**
 * Called when the application requests to tune to a given channel for TV program recording.
 *
 * <p>The application may call this method before starting or after stopping recording, but
 * not during recording.
 *
 * <p>The session must call {@link #notifyTuned(android.net.Uri)} if the tune request was fulfilled, or
 * {@link #notifyError(int)} otherwise.
 *
 * @param channelUri The URI of a channel.
 * @apiSince 24
 */

public abstract void onTune(android.net.Uri channelUri);

/**
 * Called when the application requests to tune to a given channel for TV program recording.
 * Override this method in order to handle domain-specific features that are only known
 * between certain TV inputs and their clients.
 *
 * <p>The application may call this method before starting or after stopping recording, but
 * not during recording. The default implementation calls {@link #onTune(android.net.Uri)}.
 *
 * <p>The session must call {@link #notifyTuned(android.net.Uri)} if the tune request was fulfilled, or
 * {@link #notifyError(int)} otherwise.
 *
 * @param channelUri The URI of a channel.
 * @param params Domain-specific data for this tune request. Keys <em>must</em> be a scoped
 *            name, i.e. prefixed with a package name you own, so that different developers
 *            will not create conflicting keys.
 * @apiSince 24
 */

public void onTune(android.net.Uri channelUri, android.os.Bundle params) { throw new RuntimeException("Stub!"); }

/**
 * Called when the application requests to start TV program recording. Recording must start
 * immediately when this method is called.
 *
 * <p>The application may supply the URI for a TV program for filling in program specific
 * data fields in the {@link android.media.tv.TvContract.RecordedPrograms} table.
 * A non-null {@code programUri} implies the started recording should be of that specific
 * program, whereas null {@code programUri} does not impose such a requirement and the
 * recording can span across multiple TV programs. In either case, the application must call
 * {@link android.media.tv.TvRecordingClient#stopRecording() TvRecordingClient#stopRecording()} to stop the recording.
 *
 * <p>The session must call {@link #notifyError(int)} if the start request cannot be
 * fulfilled.
 *
 * @param programUri The URI for the TV program to record, built by
 *            {@link android.media.tv.TvContract#buildProgramUri(long) TvContract#buildProgramUri(long)}. Can be {@code null}.
 
 * This value may be {@code null}.
 * @apiSince 24
 */

public abstract void onStartRecording(@androidx.annotation.Nullable android.net.Uri programUri);

/**
 * Called when the application requests to stop TV program recording. Recording must stop
 * immediately when this method is called.
 *
 * <p>The session must create a new data entry in the
 * {@link android.media.tv.TvContract.RecordedPrograms} table that describes the newly
 * recorded program and call {@link #notifyRecordingStopped(android.net.Uri)} with the URI to that
 * entry.
 * If the stop request cannot be fulfilled, the session must call {@link #notifyError(int)}.
 *
 * @apiSince 24
 */

public abstract void onStopRecording();

/**
 * Called when the application requests to release all the resources held by this recording
 * session.
 * @apiSince 24
 */

public abstract void onRelease();

/**
 * Processes a private command sent from the application to the TV input. This can be used
 * to provide domain-specific features that are only known between certain TV inputs and
 * their clients.
 *
 * @param action Name of the command to be performed. This <em>must</em> be a scoped name,
 *            i.e. prefixed with a package name you own, so that different developers will
 *            not create conflicting commands.
 * This value must never be {@code null}.
 * @param data Any data to include with the command.
 * @apiSince 24
 */

public void onAppPrivateCommand(@androidx.annotation.NonNull java.lang.String action, android.os.Bundle data) { throw new RuntimeException("Stub!"); }
}

/**
 * Base class for derived classes to implement to provide a TV input session.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class Session implements android.view.KeyEvent.Callback {

/**
 * Creates a new Session.
 *
 * @param context The context of the application
 * @apiSince 21
 */

public Session(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Enables or disables the overlay view.
 *
 * <p>By default, the overlay view is disabled. Must be called explicitly after the
 * session is created to enable the overlay view.
 *
 * <p>The TV input service can disable its overlay view when the size of the overlay view is
 * insufficient to display the whole information, such as when used in Picture-in-picture.
 * Override {@link #onOverlayViewSizeChanged} to get the size of the overlay view, which
 * then can be used to determine whether to enable/disable the overlay view.
 *
 * @param enable {@code true} if you want to enable the overlay view. {@code false}
 *            otherwise.
 * @apiSince 21
 */

public void setOverlayViewEnabled(boolean enable) { throw new RuntimeException("Stub!"); }

/**
 * Informs the application that the current channel is re-tuned for some reason and the
 * session now displays the content from a new channel. This is used to handle special cases
 * such as when the current channel becomes unavailable, it is necessary to send the user to
 * a certain channel or the user changes channel in some other way (e.g. by using a
 * dedicated remote).
 *
 * @param channelUri The URI of the new channel.
 * @apiSince 21
 */

public void notifyChannelRetuned(android.net.Uri channelUri) { throw new RuntimeException("Stub!"); }

/**
 * Sends the list of all audio/video/subtitle tracks. The is used by the framework to
 * maintain the track information for a given session, which in turn is used by
 * {@link android.media.tv.TvView#getTracks TvView#getTracks} for the application to retrieve metadata for a given track type.
 * The TV input service must call this method as soon as the track information becomes
 * available or is updated. Note that in a case where a part of the information for a
 * certain track is updated, it is not necessary to create a new {@link android.media.tv.TvTrackInfo TvTrackInfo} object
 * with a different track ID.
 *
 * @param tracks A list which includes track information.
 * @apiSince 21
 */

public void notifyTracksChanged(java.util.List<android.media.tv.TvTrackInfo> tracks) { throw new RuntimeException("Stub!"); }

/**
 * Sends the type and ID of a selected track. This is used to inform the application that a
 * specific track is selected. The TV input service must call this method as soon as a track
 * is selected either by default or in response to a call to {@link #onSelectTrack}. The
 * selected track ID for a given type is maintained in the framework until the next call to
 * this method even after the entire track list is updated (but is reset when the session is
 * tuned to a new channel), so care must be taken not to result in an obsolete track ID.
 *
 * @param type The type of the selected track. The type can be
 *            {@link android.media.tv.TvTrackInfo#TYPE_AUDIO TvTrackInfo#TYPE_AUDIO}, {@link android.media.tv.TvTrackInfo#TYPE_VIDEO TvTrackInfo#TYPE_VIDEO} or
 *            {@link android.media.tv.TvTrackInfo#TYPE_SUBTITLE TvTrackInfo#TYPE_SUBTITLE}.
 * @param trackId The ID of the selected track.
 * @see #onSelectTrack
 * @apiSince 21
 */

public void notifyTrackSelected(int type, java.lang.String trackId) { throw new RuntimeException("Stub!"); }

/**
 * Informs the application that the video is now available for watching. Video is blocked
 * until this method is called.
 *
 * <p>The TV input service must call this method as soon as the content rendered onto its
 * surface is ready for viewing. This method must be called each time {@link #onTune}
 * is called.
 *
 * @see #notifyVideoUnavailable
 * @apiSince 21
 */

public void notifyVideoAvailable() { throw new RuntimeException("Stub!"); }

/**
 * Informs the application that the video became unavailable for some reason. This is
 * primarily used to signal the application to block the screen not to show any intermittent
 * video artifacts.
 *
 * @param reason The reason why the video became unavailable:
 *            <ul>
 *            <li>{@link android.media.tv.TvInputManager#VIDEO_UNAVAILABLE_REASON_UNKNOWN TvInputManager#VIDEO_UNAVAILABLE_REASON_UNKNOWN}
 *            <li>{@link android.media.tv.TvInputManager#VIDEO_UNAVAILABLE_REASON_TUNING TvInputManager#VIDEO_UNAVAILABLE_REASON_TUNING}
 *            <li>{@link android.media.tv.TvInputManager#VIDEO_UNAVAILABLE_REASON_WEAK_SIGNAL TvInputManager#VIDEO_UNAVAILABLE_REASON_WEAK_SIGNAL}
 *            <li>{@link android.media.tv.TvInputManager#VIDEO_UNAVAILABLE_REASON_BUFFERING TvInputManager#VIDEO_UNAVAILABLE_REASON_BUFFERING}
 *            <li>{@link android.media.tv.TvInputManager#VIDEO_UNAVAILABLE_REASON_AUDIO_ONLY TvInputManager#VIDEO_UNAVAILABLE_REASON_AUDIO_ONLY}
 *            </ul>
 * Value is {@link android.media.tv.TvInputManager#VIDEO_UNAVAILABLE_REASON_UNKNOWN}, {@link android.media.tv.TvInputManager#VIDEO_UNAVAILABLE_REASON_TUNING}, {@link android.media.tv.TvInputManager#VIDEO_UNAVAILABLE_REASON_WEAK_SIGNAL}, {@link android.media.tv.TvInputManager#VIDEO_UNAVAILABLE_REASON_BUFFERING}, or {@link android.media.tv.TvInputManager#VIDEO_UNAVAILABLE_REASON_AUDIO_ONLY}
 * @see #notifyVideoAvailable
 * @apiSince 21
 */

public void notifyVideoUnavailable(int reason) { throw new RuntimeException("Stub!"); }

/**
 * Informs the application that the user is allowed to watch the current program content.
 *
 * <p>Each TV input service is required to query the system whether the user is allowed to
 * watch the current program before showing it to the user if the parental controls is
 * enabled (i.e. {@link android.media.tv.TvInputManager#isParentalControlsEnabled TvInputManager#isParentalControlsEnabled} returns {@code true}). Whether the TV input
 * service should block the content or not is determined by invoking
 * {@link android.media.tv.TvInputManager#isRatingBlocked TvInputManager#isRatingBlocked}
 * with the content rating for the current program. Then the {@link android.media.tv.TvInputManager TvInputManager} makes a
 * judgment based on the user blocked ratings stored in the secure settings and returns the
 * result. If the rating in question turns out to be allowed by the user, the TV input
 * service must call this method to notify the application that is permitted to show the
 * content.
 *
 * <p>Each TV input service also needs to continuously listen to any changes made to the
 * parental controls settings by registering a broadcast receiver to receive
 * {@link android.media.tv.TvInputManager#ACTION_BLOCKED_RATINGS_CHANGED TvInputManager#ACTION_BLOCKED_RATINGS_CHANGED} and
 * {@link android.media.tv.TvInputManager#ACTION_PARENTAL_CONTROLS_ENABLED_CHANGED TvInputManager#ACTION_PARENTAL_CONTROLS_ENABLED_CHANGED} and immediately
 * reevaluate the current program with the new parental controls settings.
 *
 * @see #notifyContentBlocked
 * @see android.media.tv.TvInputManager
 * @apiSince 21
 */

public void notifyContentAllowed() { throw new RuntimeException("Stub!"); }

/**
 * Informs the application that the current program content is blocked by parent controls.
 *
 * <p>Each TV input service is required to query the system whether the user is allowed to
 * watch the current program before showing it to the user if the parental controls is
 * enabled (i.e. {@link android.media.tv.TvInputManager#isParentalControlsEnabled TvInputManager#isParentalControlsEnabled} returns {@code true}). Whether the TV input
 * service should block the content or not is determined by invoking
 * {@link android.media.tv.TvInputManager#isRatingBlocked TvInputManager#isRatingBlocked}
 * with the content rating for the current program or {@link android.media.tv.TvContentRating#UNRATED TvContentRating#UNRATED} in
 * case the rating information is missing. Then the {@link android.media.tv.TvInputManager TvInputManager} makes a judgment
 * based on the user blocked ratings stored in the secure settings and returns the result.
 * If the rating in question turns out to be blocked, the TV input service must immediately
 * block the content and call this method with the content rating of the current program to
 * prompt the PIN verification screen.
 *
 * <p>Each TV input service also needs to continuously listen to any changes made to the
 * parental controls settings by registering a broadcast receiver to receive
 * {@link android.media.tv.TvInputManager#ACTION_BLOCKED_RATINGS_CHANGED TvInputManager#ACTION_BLOCKED_RATINGS_CHANGED} and
 * {@link android.media.tv.TvInputManager#ACTION_PARENTAL_CONTROLS_ENABLED_CHANGED TvInputManager#ACTION_PARENTAL_CONTROLS_ENABLED_CHANGED} and immediately
 * reevaluate the current program with the new parental controls settings.
 *
 * @param rating The content rating for the current TV program. Can be
 *            {@link android.media.tv.TvContentRating#UNRATED TvContentRating#UNRATED}.
 * This value must never be {@code null}.
 * @see #notifyContentAllowed
 * @see android.media.tv.TvInputManager
 * @apiSince 21
 */

public void notifyContentBlocked(@androidx.annotation.NonNull android.media.tv.TvContentRating rating) { throw new RuntimeException("Stub!"); }

/**
 * Informs the application that the time shift status is changed.
 *
 * <p>Prior to calling this method, the application assumes the status
 * {@link android.media.tv.TvInputManager#TIME_SHIFT_STATUS_UNKNOWN TvInputManager#TIME_SHIFT_STATUS_UNKNOWN}. Right after the session is created, it
 * is important to invoke the method with the status
 * {@link android.media.tv.TvInputManager#TIME_SHIFT_STATUS_AVAILABLE TvInputManager#TIME_SHIFT_STATUS_AVAILABLE} if the implementation does support
 * time shifting, or {@link android.media.tv.TvInputManager#TIME_SHIFT_STATUS_UNSUPPORTED TvInputManager#TIME_SHIFT_STATUS_UNSUPPORTED} otherwise. Failure
 * to notifying the current status change immediately might result in an undesirable
 * behavior in the application such as hiding the play controls.
 *
 * <p>If the status {@link android.media.tv.TvInputManager#TIME_SHIFT_STATUS_AVAILABLE TvInputManager#TIME_SHIFT_STATUS_AVAILABLE} is reported, the
 * application assumes it can pause/resume playback, seek to a specified time position and
 * set playback rate and audio mode. The implementation should override
 * {@link #onTimeShiftPause}, {@link #onTimeShiftResume}, {@link #onTimeShiftSeekTo},
 * {@link #onTimeShiftGetStartPosition}, {@link #onTimeShiftGetCurrentPosition} and
 * {@link #onTimeShiftSetPlaybackParams}.
 *
 * @param status The current time shift status. Should be one of the followings.
 * <ul>
 * <li>{@link android.media.tv.TvInputManager#TIME_SHIFT_STATUS_UNSUPPORTED TvInputManager#TIME_SHIFT_STATUS_UNSUPPORTED}
 * <li>{@link android.media.tv.TvInputManager#TIME_SHIFT_STATUS_UNAVAILABLE TvInputManager#TIME_SHIFT_STATUS_UNAVAILABLE}
 * <li>{@link android.media.tv.TvInputManager#TIME_SHIFT_STATUS_AVAILABLE TvInputManager#TIME_SHIFT_STATUS_AVAILABLE}
 * </ul>
 
 * Value is {@link android.media.tv.TvInputManager#TIME_SHIFT_STATUS_UNKNOWN}, {@link android.media.tv.TvInputManager#TIME_SHIFT_STATUS_UNSUPPORTED}, {@link android.media.tv.TvInputManager#TIME_SHIFT_STATUS_UNAVAILABLE}, or {@link android.media.tv.TvInputManager#TIME_SHIFT_STATUS_AVAILABLE}
 * @apiSince 23
 */

public void notifyTimeShiftStatusChanged(int status) { throw new RuntimeException("Stub!"); }

/**
 * Assigns a size and position to the surface passed in {@link #onSetSurface}. The position
 * is relative to the overlay view that sits on top of this surface.
 *
 * @param left Left position in pixels, relative to the overlay view.
 * @param top Top position in pixels, relative to the overlay view.
 * @param right Right position in pixels, relative to the overlay view.
 * @param bottom Bottom position in pixels, relative to the overlay view.
 * @see #onOverlayViewSizeChanged
 * @apiSince 23
 */

public void layoutSurface(int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * Called when the session is released.
 * @apiSince 21
 */

public abstract void onRelease();

/**
 * Called when the application sets the surface.
 *
 * <p>The TV input service should render video onto the given surface. When called with
 * {@code null}, the input service should immediately free any references to the
 * currently set surface and stop using it.
 *
 * @param surface The surface to be used for video rendering. Can be {@code null}.
 * This value may be {@code null}.
 * @return {@code true} if the surface was set successfully, {@code false} otherwise.
 * @apiSince 21
 */

public abstract boolean onSetSurface(@androidx.annotation.Nullable android.view.Surface surface);

/**
 * Called after any structural changes (format or size) have been made to the surface passed
 * in {@link #onSetSurface}. This method is always called at least once, after
 * {@link #onSetSurface} is called with non-null surface.
 *
 * @param format The new PixelFormat of the surface.
 * @param width The new width of the surface.
 * @param height The new height of the surface.
 * @apiSince 21
 */

public void onSurfaceChanged(int format, int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * Called when the size of the overlay view is changed by the application.
 *
 * <p>This is always called at least once when the session is created regardless of whether
 * the overlay view is enabled or not. The overlay view size is the same as the containing
 * {@link android.media.tv.TvView TvView}. Note that the size of the underlying surface can be different if the
 * surface was changed by calling {@link #layoutSurface}.
 *
 * @param width The width of the overlay view.
 * @param height The height of the overlay view.
 * @apiSince 23
 */

public void onOverlayViewSizeChanged(int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * Sets the relative stream volume of the current TV input session.
 *
 * <p>The implementation should honor this request in order to handle audio focus changes or
 * mute the current session when multiple sessions, possibly from different inputs are
 * active. If the method has not yet been called, the implementation should assume the
 * default value of {@code 1.0f}.
 *
 * @param volume A volume value between {@code 0.0f} to {@code 1.0f}.
 
 * Value is between 0.0 and 1.0 inclusive
 * @apiSince 21
 */

public abstract void onSetStreamVolume(float volume);

/**
 * Tunes to a given channel.
 *
 * <p>No video will be displayed until {@link #notifyVideoAvailable()} is called.
 * Also, {@link #notifyVideoUnavailable(int)} should be called when the TV input cannot
 * continue playing the given channel.
 *
 * @param channelUri The URI of the channel.
 * @return {@code true} if the tuning was successful, {@code false} otherwise.
 * @apiSince 21
 */

public abstract boolean onTune(android.net.Uri channelUri);

/**
 * Tunes to a given channel. Override this method in order to handle domain-specific
 * features that are only known between certain TV inputs and their clients.
 *
 * <p>The default implementation calls {@link #onTune(android.net.Uri)}.
 *
 * @param channelUri The URI of the channel.
 * @param params Domain-specific data for this tune request. Keys <em>must</em> be a scoped
 *            name, i.e. prefixed with a package name you own, so that different developers
 *            will not create conflicting keys.
 * @return {@code true} if the tuning was successful, {@code false} otherwise.
 * @apiSince 24
 */

public boolean onTune(android.net.Uri channelUri, android.os.Bundle params) { throw new RuntimeException("Stub!"); }

/**
 * Enables or disables the caption.
 *
 * <p>The locale for the user's preferred captioning language can be obtained by calling
 * {@link android.view.accessibility.CaptioningManager#getLocale CaptioningManager#getLocale}.
 *
 * @param enabled {@code true} to enable, {@code false} to disable.
 * @see android.view.accessibility.CaptioningManager
 * @apiSince 21
 */

public abstract void onSetCaptionEnabled(boolean enabled);

/**
 * Requests to unblock the content according to the given rating.
 *
 * <p>The implementation should unblock the content.
 * TV input service has responsibility to decide when/how the unblock expires
 * while it can keep previously unblocked ratings in order not to ask a user
 * to unblock whenever a content rating is changed.
 * Therefore an unblocked rating can be valid for a channel, a program,
 * or certain amount of time depending on the implementation.
 *
 * @param unblockedRating An unblocked content rating
 * @apiSince 21
 */

public void onUnblockContent(android.media.tv.TvContentRating unblockedRating) { throw new RuntimeException("Stub!"); }

/**
 * Selects a given track.
 *
 * <p>If this is done successfully, the implementation should call
 * {@link #notifyTrackSelected} to help applications maintain the up-to-date list of the
 * selected tracks.
 *
 * @param trackId The ID of the track to select. {@code null} means to unselect the current
 *            track for a given type.
 * This value may be {@code null}.
 * @param type The type of the track to select. The type can be
 *            {@link android.media.tv.TvTrackInfo#TYPE_AUDIO TvTrackInfo#TYPE_AUDIO}, {@link android.media.tv.TvTrackInfo#TYPE_VIDEO TvTrackInfo#TYPE_VIDEO} or
 *            {@link android.media.tv.TvTrackInfo#TYPE_SUBTITLE TvTrackInfo#TYPE_SUBTITLE}.
 * @return {@code true} if the track selection was successful, {@code false} otherwise.
 * @see #notifyTrackSelected
 * @apiSince 21
 */

public boolean onSelectTrack(int type, @androidx.annotation.Nullable java.lang.String trackId) { throw new RuntimeException("Stub!"); }

/**
 * Processes a private command sent from the application to the TV input. This can be used
 * to provide domain-specific features that are only known between certain TV inputs and
 * their clients.
 *
 * @param action Name of the command to be performed. This <em>must</em> be a scoped name,
 *            i.e. prefixed with a package name you own, so that different developers will
 *            not create conflicting commands.
 * This value must never be {@code null}.
 * @param data Any data to include with the command.
 * @apiSince 24
 */

public void onAppPrivateCommand(@androidx.annotation.NonNull java.lang.String action, android.os.Bundle data) { throw new RuntimeException("Stub!"); }

/**
 * Called when the application requests to create an overlay view. Each session
 * implementation can override this method and return its own view.
 *
 * @return a view attached to the overlay window
 * @apiSince 21
 */

public android.view.View onCreateOverlayView() { throw new RuntimeException("Stub!"); }

/**
 * Called when the application requests to play a given recorded TV program.
 *
 * @param recordedProgramUri The URI of a recorded TV program.
 * @see #onTimeShiftResume()
 * @see #onTimeShiftPause()
 * @see #onTimeShiftSeekTo(long)
 * @see #onTimeShiftSetPlaybackParams(PlaybackParams)
 * @see #onTimeShiftGetStartPosition()
 * @see #onTimeShiftGetCurrentPosition()
 * @apiSince 24
 */

public void onTimeShiftPlay(android.net.Uri recordedProgramUri) { throw new RuntimeException("Stub!"); }

/**
 * Called when the application requests to pause playback.
 *
 * @see #onTimeShiftPlay(Uri)
 * @see #onTimeShiftResume()
 * @see #onTimeShiftSeekTo(long)
 * @see #onTimeShiftSetPlaybackParams(PlaybackParams)
 * @see #onTimeShiftGetStartPosition()
 * @see #onTimeShiftGetCurrentPosition()
 * @apiSince 23
 */

public void onTimeShiftPause() { throw new RuntimeException("Stub!"); }

/**
 * Called when the application requests to resume playback.
 *
 * @see #onTimeShiftPlay(Uri)
 * @see #onTimeShiftPause()
 * @see #onTimeShiftSeekTo(long)
 * @see #onTimeShiftSetPlaybackParams(PlaybackParams)
 * @see #onTimeShiftGetStartPosition()
 * @see #onTimeShiftGetCurrentPosition()
 * @apiSince 23
 */

public void onTimeShiftResume() { throw new RuntimeException("Stub!"); }

/**
 * Called when the application requests to seek to a specified time position. Normally, the
 * position is given within range between the start and the current time, inclusively. The
 * implementation is expected to seek to the nearest time position if the given position is
 * not in the range.
 *
 * @param timeMs The time position to seek to, in milliseconds since the epoch.
 * @see #onTimeShiftPlay(Uri)
 * @see #onTimeShiftResume()
 * @see #onTimeShiftPause()
 * @see #onTimeShiftSetPlaybackParams(PlaybackParams)
 * @see #onTimeShiftGetStartPosition()
 * @see #onTimeShiftGetCurrentPosition()
 * @apiSince 23
 */

public void onTimeShiftSeekTo(long timeMs) { throw new RuntimeException("Stub!"); }

/**
 * Called when the application sets playback parameters containing the speed and audio mode.
 *
 * <p>Once the playback parameters are set, the implementation should honor the current
 * settings until the next tune request. Pause/resume/seek request does not reset the
 * parameters previously set.
 *
 * @param params The playback params.
 * @see #onTimeShiftPlay(Uri)
 * @see #onTimeShiftResume()
 * @see #onTimeShiftPause()
 * @see #onTimeShiftSeekTo(long)
 * @see #onTimeShiftGetStartPosition()
 * @see #onTimeShiftGetCurrentPosition()
 * @apiSince 23
 */

public void onTimeShiftSetPlaybackParams(android.media.PlaybackParams params) { throw new RuntimeException("Stub!"); }

/**
 * Returns the start position for time shifting, in milliseconds since the epoch.
 * Returns {@link android.media.tv.TvInputManager#TIME_SHIFT_INVALID_TIME TvInputManager#TIME_SHIFT_INVALID_TIME} if the position is unknown at the
 * moment.
 *
 * <p>The start position for time shifting indicates the earliest possible time the user can
 * seek to. Initially this is equivalent to the time when the implementation starts
 * recording. Later it may be adjusted because there is insufficient space or the duration
 * of recording is limited by the implementation. The application does not allow the user to
 * seek to a position earlier than the start position.
 *
 * <p>For playback of a recorded program initiated by {@link #onTimeShiftPlay(android.net.Uri)}, the
 * start position should be 0 and does not change.
 *
 * @see #onTimeShiftPlay(Uri)
 * @see #onTimeShiftResume()
 * @see #onTimeShiftPause()
 * @see #onTimeShiftSeekTo(long)
 * @see #onTimeShiftSetPlaybackParams(PlaybackParams)
 * @see #onTimeShiftGetCurrentPosition()
 * @apiSince 23
 */

public long onTimeShiftGetStartPosition() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current position for time shifting, in milliseconds since the epoch.
 * Returns {@link android.media.tv.TvInputManager#TIME_SHIFT_INVALID_TIME TvInputManager#TIME_SHIFT_INVALID_TIME} if the position is unknown at the
 * moment.
 *
 * <p>The current position for time shifting is the same as the current position of
 * playback. It should be equal to or greater than the start position reported by
 * {@link #onTimeShiftGetStartPosition()}. When playback is completed, the current position
 * should stay where the playback ends, in other words, the returned value of this mehtod
 * should be equal to the start position plus the duration of the program.
 *
 * @see #onTimeShiftPlay(Uri)
 * @see #onTimeShiftResume()
 * @see #onTimeShiftPause()
 * @see #onTimeShiftSeekTo(long)
 * @see #onTimeShiftSetPlaybackParams(PlaybackParams)
 * @see #onTimeShiftGetStartPosition()
 * @apiSince 23
 */

public long onTimeShiftGetCurrentPosition() { throw new RuntimeException("Stub!"); }

/**
 * Default implementation of {@link android.view.KeyEvent.Callback#onKeyDown(int, KeyEvent)
 * KeyEvent.Callback.onKeyDown()}: always returns false (doesn't handle the event).
 *
 * <p>Override this to intercept key down events before they are processed by the
 * application. If you return true, the application will not process the event itself. If
 * you return false, the normal application processing will occur as if the TV input had not
 * seen the event at all.
 *
 * @param keyCode The value in event.getKeyCode().
 * @param event Description of the key event.
 * @return If you handled the event, return {@code true}. If you want to allow the event to
 *         be handled by the next receiver, return {@code false}.
 * @apiSince 21
 */

public boolean onKeyDown(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Default implementation of
 * {@link android.view.KeyEvent.Callback#onKeyLongPress(int, KeyEvent)
 * KeyEvent.Callback.onKeyLongPress()}: always returns false (doesn't handle the event).
 *
 * <p>Override this to intercept key long press events before they are processed by the
 * application. If you return true, the application will not process the event itself. If
 * you return false, the normal application processing will occur as if the TV input had not
 * seen the event at all.
 *
 * @param keyCode The value in event.getKeyCode().
 * @param event Description of the key event.
 * @return If you handled the event, return {@code true}. If you want to allow the event to
 *         be handled by the next receiver, return {@code false}.
 * @apiSince 21
 */

public boolean onKeyLongPress(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Default implementation of
 * {@link android.view.KeyEvent.Callback#onKeyMultiple(int, int, KeyEvent)
 * KeyEvent.Callback.onKeyMultiple()}: always returns false (doesn't handle the event).
 *
 * <p>Override this to intercept special key multiple events before they are processed by
 * the application. If you return true, the application will not itself process the event.
 * If you return false, the normal application processing will occur as if the TV input had
 * not seen the event at all.
 *
 * @param keyCode The value in event.getKeyCode().
 * @param count The number of times the action was made.
 * @param event Description of the key event.
 * @return If you handled the event, return {@code true}. If you want to allow the event to
 *         be handled by the next receiver, return {@code false}.
 * @apiSince 21
 */

public boolean onKeyMultiple(int keyCode, int count, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Default implementation of {@link android.view.KeyEvent.Callback#onKeyUp(int, KeyEvent)
 * KeyEvent.Callback.onKeyUp()}: always returns false (doesn't handle the event).
 *
 * <p>Override this to intercept key up events before they are processed by the application.
 * If you return true, the application will not itself process the event. If you return false,
 * the normal application processing will occur as if the TV input had not seen the event at
 * all.
 *
 * @param keyCode The value in event.getKeyCode().
 * @param event Description of the key event.
 * @return If you handled the event, return {@code true}. If you want to allow the event to
 *         be handled by the next receiver, return {@code false}.
 * @apiSince 21
 */

public boolean onKeyUp(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Implement this method to handle touch screen motion events on the current input session.
 *
 * @param event The motion event being received.
 * @return If you handled the event, return {@code true}. If you want to allow the event to
 *         be handled by the next receiver, return {@code false}.
 * @see android.view.View#onTouchEvent
 * @apiSince 21
 */

public boolean onTouchEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Implement this method to handle trackball events on the current input session.
 *
 * @param event The motion event being received.
 * @return If you handled the event, return {@code true}. If you want to allow the event to
 *         be handled by the next receiver, return {@code false}.
 * @see android.view.View#onTrackballEvent
 * @apiSince 21
 */

public boolean onTrackballEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Implement this method to handle generic motion events on the current input session.
 *
 * @param event The motion event being received.
 * @return If you handled the event, return {@code true}. If you want to allow the event to
 *         be handled by the next receiver, return {@code false}.
 * @see android.view.View#onGenericMotionEvent
 * @apiSince 21
 */

public boolean onGenericMotionEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }
}

}

