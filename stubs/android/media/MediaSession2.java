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
import android.content.Intent;
import android.os.Bundle;

/**
 * This API is not generally intended for third party application developers.
 * Use the <a href="{@docRoot}jetpack/androidx.html">AndroidX</a>
 * <a href="{@docRoot}reference/androidx/media2/session/package-summary.html">Media2 session
 * Library</a> for consistent behavior across all devices.
 * <p>
 * Allows a media app to expose its transport controls and playback information in a process to
 * other processes including the Android framework and other apps.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MediaSession2 implements java.lang.AutoCloseable {

MediaSession2() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * Returns the session ID
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.lang.String getId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.media.Session2Token Session2Token} for creating {@link android.media.MediaController2 MediaController2}.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.media.Session2Token getToken() { throw new RuntimeException("Stub!"); }

/**
 * Broadcasts a session command to all the connected controllers
 * <p>
 * @param command the session command
 * This value must never be {@code null}.
 * @param args optional arguments
 
 * This value may be {@code null}.
 * @apiSince 29
 */

public void broadcastSessionCommand(@androidx.annotation.NonNull android.media.Session2Command command, @androidx.annotation.Nullable android.os.Bundle args) { throw new RuntimeException("Stub!"); }

/**
 * Sends a session command to a specific controller
 * <p>
 * @param controller the controller to get the session command
 * This value must never be {@code null}.
 * @param command the session command
 * This value must never be {@code null}.
 * @param args optional arguments
 * This value may be {@code null}.
 * @return a token which will be sent together in {@link android.media.MediaSession2.SessionCallback#onCommandResult SessionCallback#onCommandResult}
 *     when its result is received.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.lang.Object sendSessionCommand(@androidx.annotation.NonNull android.media.MediaSession2.ControllerInfo controller, @androidx.annotation.NonNull android.media.Session2Command command, @androidx.annotation.Nullable android.os.Bundle args) { throw new RuntimeException("Stub!"); }

/**
 * Cancels the session command previously sent.
 *
 * @param controller the controller to get the session command
 * This value must never be {@code null}.
 * @param token the token which is returned from {@link #sendSessionCommand}.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void cancelSessionCommand(@androidx.annotation.NonNull android.media.MediaSession2.ControllerInfo controller, @androidx.annotation.NonNull java.lang.Object token) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the playback is active (i.e. playing something)
 *
 * @param playbackActive {@code true} if the playback active, {@code false} otherwise.
 *     * @apiSince 29
 */

public void setPlaybackActive(boolean playbackActive) { throw new RuntimeException("Stub!"); }

/**
 * Returns whehther the playback is active (i.e. playing something)
 *
 * @return {@code true} if the playback active, {@code false} otherwise.
 * @apiSince 29
 */

public boolean isPlaybackActive() { throw new RuntimeException("Stub!"); }

/**
 * Gets the list of the connected controllers
 *
 * @return list of the connected controllers.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.util.List<android.media.MediaSession2.ControllerInfo> getConnectedControllers() { throw new RuntimeException("Stub!"); }
/**
 * This API is not generally intended for third party application developers.
 * Use the <a href="{@docRoot}jetpack/androidx.html">AndroidX</a>
 * <a href="{@docRoot}reference/androidx/media2/session/package-summary.html">Media2 session
 * Library</a> for consistent behavior across all devices.
 * <p>
 * Builder for {@link android.media.MediaSession2 MediaSession2}.
 * <p>
 * Any incoming event from the {@link android.media.MediaController2 MediaController2} will be handled on the callback
 * executor. If it's not set, {@link android.content.Context#getMainExecutor() Context#getMainExecutor()} will be used by default.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Creates a builder for {@link android.media.MediaSession2 MediaSession2}.
 *
 * @param context Context
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if context is {@code null}.
 * @apiSince 29
 */

public Builder(@androidx.annotation.NonNull android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Set an intent for launching UI for this Session. This can be used as a
 * quick link to an ongoing media screen. The intent should be for an
 * activity that may be started using {@link android.content.Context#startActivity(android.content.Intent) Context#startActivity(Intent)}.
 *
 * @param pi The intent to launch to show UI for this session.
 * This value may be {@code null}.
 * @return The Builder to allow chaining
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.media.MediaSession2.Builder setSessionActivity(@androidx.annotation.Nullable android.app.PendingIntent pi) { throw new RuntimeException("Stub!"); }

/**
 * Set ID of the session. If it's not set, an empty string will be used to create a session.
 * <p>
 * Use this if and only if your app supports multiple playback at the same time and also
 * wants to provide external apps to have finer controls of them.
 *
 * @param id id of the session. Must be unique per package.
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if id is {@code null}.
 * @return The Builder to allow chaining
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.media.MediaSession2.Builder setId(@androidx.annotation.NonNull java.lang.String id) { throw new RuntimeException("Stub!"); }

/**
 * Set callback for the session and its executor.
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
public android.media.MediaSession2.Builder setSessionCallback(@androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull android.media.MediaSession2.SessionCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Set extras for the session token. If null or not set, {@link android.media.Session2Token#getExtras() Session2Token#getExtras()}
 * will return an empty {@link android.os.Bundle Bundle}. An {@link java.lang.IllegalArgumentException IllegalArgumentException} will be thrown
 * if the bundle contains any non-framework Parcelable objects.
 *
 * @param extras This value must never be {@code null}.
 * @return The Builder to allow chaining
 * @see android.media.Session2Token#getExtras()
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.media.MediaSession2.Builder setExtras(@androidx.annotation.NonNull android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Build {@link android.media.MediaSession2 MediaSession2}.
 *
 * @return a new session
 * This value will never be {@code null}.
 * @throws java.lang.IllegalStateException if the session with the same id is already exists for the
 *      package.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.media.MediaSession2 build() { throw new RuntimeException("Stub!"); }
}

/**
 * This API is not generally intended for third party application developers.
 * Use the <a href="{@docRoot}jetpack/androidx.html">AndroidX</a>
 * <a href="{@docRoot}reference/androidx/media2/session/package-summary.html">Media2 session
 * Library</a> for consistent behavior across all devices.
 * <p>
 * Information of a controller.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class ControllerInfo {

ControllerInfo() { throw new RuntimeException("Stub!"); }

/**
 * @return remote user info of the controller.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.media.session.MediaSessionManager.RemoteUserInfo getRemoteUserInfo() { throw new RuntimeException("Stub!"); }

/**
 * @return package name of the controller.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.lang.String getPackageName() { throw new RuntimeException("Stub!"); }

/**
 * @return uid of the controller. Can be a negative value if the uid cannot be obtained.
 * @apiSince 29
 */

public int getUid() { throw new RuntimeException("Stub!"); }

/**
 * @return connection hints sent from controller.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.os.Bundle getConnectionHints() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param obj This value may be {@code null}.
 * @apiSince 29
 */

public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

/**
 * This API is not generally intended for third party application developers.
 * Use the <a href="{@docRoot}jetpack/androidx.html">AndroidX</a>
 * <a href="{@docRoot}reference/androidx/media2/session/package-summary.html">Media2 session
 * Library</a> for consistent behavior across all devices.
 * <p>
 * Callback to be called for all incoming commands from {@link android.media.MediaController2 MediaController2}s.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class SessionCallback {

public SessionCallback() { throw new RuntimeException("Stub!"); }

/**
 * Called when a controller is created for this session. Return allowed commands for
 * controller. By default it returns {@code null}.
 * <p>
 * You can reject the connection by returning {@code null}. In that case, controller
 * receives {@link android.media.MediaController2.ControllerCallback#onDisconnected(android.media.MediaController2) MediaController2.ControllerCallback#onDisconnected(MediaController2)}
 * and cannot be used.
 * <p>
 * The controller hasn't connected yet in this method, so calls to the controller
 * (e.g. {@link #sendSessionCommand}) would be ignored. Override {@link #onPostConnect} for
 * the custom initialization for the controller instead.
 *
 * @param session the session for this event
 * This value must never be {@code null}.
 * @param controller controller information.
 * This value must never be {@code null}.
 * @return allowed commands. Can be {@code null} to reject connection.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.media.Session2CommandGroup onConnect(@androidx.annotation.NonNull android.media.MediaSession2 session, @androidx.annotation.NonNull android.media.MediaSession2.ControllerInfo controller) { throw new RuntimeException("Stub!"); }

/**
 * Called immediately after a controller is connected. This is a convenient method to add
 * custom initialization between the session and a controller.
 * <p>
 * Note that calls to the controller (e.g. {@link #sendSessionCommand}) work here but don't
 * work in {@link #onConnect} because the controller hasn't connected yet in
 * {@link #onConnect}.
 *
 * @param session the session for this event
 * This value must never be {@code null}.
 * @param controller controller information.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void onPostConnect(@androidx.annotation.NonNull android.media.MediaSession2 session, @androidx.annotation.NonNull android.media.MediaSession2.ControllerInfo controller) { throw new RuntimeException("Stub!"); }

/**
 * Called when a controller is disconnected
 *
 * @param session the session for this event
 * This value must never be {@code null}.
 * @param controller controller information
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void onDisconnected(@androidx.annotation.NonNull android.media.MediaSession2 session, @androidx.annotation.NonNull android.media.MediaSession2.ControllerInfo controller) { throw new RuntimeException("Stub!"); }

/**
 * Called when a controller sent a session command.
 *
 * @param session the session for this event
 * This value must never be {@code null}.
 * @param controller controller information
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
public android.media.Session2Command.Result onSessionCommand(@androidx.annotation.NonNull android.media.MediaSession2 session, @androidx.annotation.NonNull android.media.MediaSession2.ControllerInfo controller, @androidx.annotation.NonNull android.media.Session2Command command, @androidx.annotation.Nullable android.os.Bundle args) { throw new RuntimeException("Stub!"); }

/**
 * Called when the command sent to the controller is finished.
 *
 * @param session the session for this event
 * This value must never be {@code null}.
 * @param controller controller information
 * This value must never be {@code null}.
 * @param token the token got from {@link android.media.MediaSession2#sendSessionCommand MediaSession2#sendSessionCommand}
 * This value must never be {@code null}.
 * @param command the session command
 * This value must never be {@code null}.
 * @param result the result of the session command
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void onCommandResult(@androidx.annotation.NonNull android.media.MediaSession2 session, @androidx.annotation.NonNull android.media.MediaSession2.ControllerInfo controller, @androidx.annotation.NonNull java.lang.Object token, @androidx.annotation.NonNull android.media.Session2Command command, @androidx.annotation.NonNull android.media.Session2Command.Result result) { throw new RuntimeException("Stub!"); }
}

}

