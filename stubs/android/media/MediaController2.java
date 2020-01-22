/*
 * Copyright 2018 The Android Open Source Project
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

import android.content.Context;

/**
 * This API is not generally intended for third party application developers.
 * Use the <a href="{@docRoot}jetpack/androidx.html">AndroidX</a>
 * <a href="{@docRoot}reference/androidx/media2/session/package-summary.html">Media2 session
 * Library</a> for consistent behavior across all devices.
 *
 * Allows an app to interact with an active {@link android.media.MediaSession2 MediaSession2} or a
 * {@link android.media.MediaSession2Service MediaSession2Service} which would provide {@link android.media.MediaSession2 MediaSession2}. Media buttons and other
 * commands can be sent to the session.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MediaController2 implements java.lang.AutoCloseable {

MediaController2() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@link android.media.Session2Token Session2Token} of the connected session.
 * If it is not connected yet, it returns {@code null}.
 * <p>
 * This may differ with the {@link android.media.Session2Token Session2Token} from the constructor. For example, if the
 * controller is created with the token for {@link android.media.MediaSession2Service MediaSession2Service}, this would return
 * token for the {@link android.media.MediaSession2 MediaSession2} in the service.
 *
 * @return Session2Token of the connected session, or {@code null} if not connected
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.media.Session2Token getConnectedToken() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the session's playback is active.
 *
 * @return {@code true} if playback active. {@code false} otherwise.
 * @see android.media.MediaController2.ControllerCallback#onPlaybackActiveChanged(MediaController2, boolean)
 * @apiSince 29
 */

public boolean isPlaybackActive() { throw new RuntimeException("Stub!"); }

/**
 * Sends a session command to the session
 * <p>
 * @param command the session command
 * This value must never be {@code null}.
 * @param args optional arguments
 * This value may be {@code null}.
 * @return a token which will be sent together in {@link android.media.MediaController2.ControllerCallback#onCommandResult ControllerCallback#onCommandResult}
 *        when its result is received.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.lang.Object sendSessionCommand(@androidx.annotation.NonNull android.media.Session2Command command, @androidx.annotation.Nullable android.os.Bundle args) { throw new RuntimeException("Stub!"); }

/**
 * Cancels the session command previously sent.
 *
 * @param token the token which is returned from {@link #sendSessionCommand}.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void cancelSessionCommand(@androidx.annotation.NonNull java.lang.Object token) { throw new RuntimeException("Stub!"); }
/**
 * This API is not generally intended for third party application developers.
 * Use the <a href="{@docRoot}jetpack/androidx.html">AndroidX</a>
 * <a href="{@docRoot}reference/androidx/media2/session/package-summary.html">Media2 session
 * Library</a> for consistent behavior across all devices.
 * <p>
 * Builder for {@link android.media.MediaController2 MediaController2}.
 * <p>
 * Any incoming event from the {@link android.media.MediaSession2 MediaSession2} will be handled on the callback
 * executor. If it's not set, {@link android.content.Context#getMainExecutor() Context#getMainExecutor()} will be used by default.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Creates a builder for {@link android.media.MediaController2 MediaController2}.
 *
 * @param context context
 * This value must never be {@code null}.
 * @param token token of the session to connect to
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public Builder(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.media.Session2Token token) { throw new RuntimeException("Stub!"); }

/**
 * Set the connection hints for the controller.
 * <p>
 * {@code connectionHints} is a session-specific argument to send to the session when
 * connecting. The contents of this bundle may affect the connection result.
 * <p>
 * An {@link java.lang.IllegalArgumentException IllegalArgumentException} will be thrown if the bundle contains any
 * non-framework Parcelable objects.
 *
 * @param connectionHints a bundle which contains the connection hints
 * This value must never be {@code null}.
 * @return The Builder to allow chaining
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.media.MediaController2.Builder setConnectionHints(@androidx.annotation.NonNull android.os.Bundle connectionHints) { throw new RuntimeException("Stub!"); }

/**
 * Set callback for the controller and its executor.
 *
 * @param executor callback executor
 * This value must never be {@code null}.
 * @param callback session callback.
 * This value must never be {@code null}.
 * @return The Builder to allow chaining
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.media.MediaController2.Builder setControllerCallback(@androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull android.media.MediaController2.ControllerCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Build {@link android.media.MediaController2 MediaController2}.
 *
 * @return a new controller
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.media.MediaController2 build() { throw new RuntimeException("Stub!"); }
}

/**
 * This API is not generally intended for third party application developers.
 * Use the <a href="{@docRoot}jetpack/androidx.html">AndroidX</a>
 * <a href="{@docRoot}reference/androidx/media2/session/package-summary.html">Media2 session
 * Library</a> for consistent behavior across all devices.
 * <p>
 * Interface for listening to change in activeness of the {@link android.media.MediaSession2 MediaSession2}.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class ControllerCallback {

public ControllerCallback() { throw new RuntimeException("Stub!"); }

/**
 * Called when the controller is successfully connected to the session. The controller
 * becomes available afterwards.
 *
 * @param controller the controller for this event
 * This value must never be {@code null}.
 * @param allowedCommands commands that's allowed by the session.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void onConnected(@androidx.annotation.NonNull android.media.MediaController2 controller, @androidx.annotation.NonNull android.media.Session2CommandGroup allowedCommands) { throw new RuntimeException("Stub!"); }

/**
 * Called when the session refuses the controller or the controller is disconnected from
 * the session. The controller becomes unavailable afterwards and the callback wouldn't
 * be called.
 * <p>
 * It will be also called after the {@link #close()}, so you can put clean up code here.
 * You don't need to call {@link #close()} after this.
 *
 * @param controller the controller for this event
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void onDisconnected(@androidx.annotation.NonNull android.media.MediaController2 controller) { throw new RuntimeException("Stub!"); }

/**
 * Called when the session's playback activeness is changed.
 *
 * @param controller the controller for this event
 * This value must never be {@code null}.
 * @param playbackActive {@code true} if the session's playback is active.
 *                       {@code false} otherwise.
 * @see android.media.MediaController2#isPlaybackActive()
 * @apiSince 29
 */

public void onPlaybackActiveChanged(@androidx.annotation.NonNull android.media.MediaController2 controller, boolean playbackActive) { throw new RuntimeException("Stub!"); }

/**
 * Called when the connected session sent a session command.
 *
 * @param controller the controller for this event
 * This value must never be {@code null}.
 * @param command the session command
 * This value must never be {@code null}.
 * @param args optional arguments
 * This value may be {@code null}.
 * @return the result for the session command. If {@code null}, RESULT_INFO_SKIPPED
 *         will be sent to the session.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.media.Session2Command.Result onSessionCommand(@androidx.annotation.NonNull android.media.MediaController2 controller, @androidx.annotation.NonNull android.media.Session2Command command, @androidx.annotation.Nullable android.os.Bundle args) { throw new RuntimeException("Stub!"); }

/**
 * Called when the command sent to the connected session is finished.
 *
 * @param controller the controller for this event
 * This value must never be {@code null}.
 * @param token the token got from {@link android.media.MediaController2#sendSessionCommand MediaController2#sendSessionCommand}
 * This value must never be {@code null}.
 * @param command the session command
 * This value must never be {@code null}.
 * @param result the result of the session command
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void onCommandResult(@androidx.annotation.NonNull android.media.MediaController2 controller, @androidx.annotation.NonNull java.lang.Object token, @androidx.annotation.NonNull android.media.Session2Command command, @androidx.annotation.NonNull android.media.Session2Command.Result result) { throw new RuntimeException("Stub!"); }
}

}

