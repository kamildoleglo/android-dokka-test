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

import android.media.Session2Token;
import android.media.MediaSession2;
import android.content.ComponentName;
import android.service.notification.NotificationListenerService;
import android.service.media.MediaBrowserService;
import android.os.Handler;

/**
 * Provides support for interacting with {@link android.media.session.MediaSession MediaSession}
 * that applications have published to express their ongoing media playback
 * state.
 *
 * @see android.media.session.MediaSession
 * @see android.media.session.MediaController
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MediaSessionManager {

MediaSessionManager() { throw new RuntimeException("Stub!"); }

/**
 * This API is not generally intended for third party application developers.
 * Use the <a href="{@docRoot}jetpack/androidx.html">AndroidX</a>
 * <a href="{@docRoot}reference/androidx/media2/session/package-summary.html">Media2 session
 * Library</a> for consistent behavior across all devices.
 * <p>
 * Notifies that a new {@link android.media.MediaSession2 MediaSession2} with type {@link android.media.Session2Token#TYPE_SESSION Session2Token#TYPE_SESSION} is
 * created.
 * <p>
 * Do not use this API directly, but create a new instance through the
 * {@link android.media.MediaSession2.Builder MediaSession2.Builder} instead.
 *
 * @param token newly created session2 token
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void notifySession2Created(@androidx.annotation.NonNull android.media.Session2Token token) { throw new RuntimeException("Stub!"); }

/**
 * Get a list of controllers for all ongoing sessions. The controllers will
 * be provided in priority order with the most important controller at index
 * 0.
 * <p>
 * This requires the android.Manifest.permission.MEDIA_CONTENT_CONTROL
 * permission be held by the calling app. You may also retrieve this list if
 * your app is an enabled notification listener using the
 * {@link android.service.notification.NotificationListenerService NotificationListenerService} APIs, in which case you must pass the
 * {@link android.content.ComponentName ComponentName} of your enabled listener.
 *
 * @param notificationListener The enabled notification listener component.
 *            May be null.
 * This value may be {@code null}.
 * @return A list of controllers for ongoing sessions.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.util.List<android.media.session.MediaController> getActiveSessions(@androidx.annotation.Nullable android.content.ComponentName notificationListener) { throw new RuntimeException("Stub!"); }

/**
 * This API is not generally intended for third party application developers.
 * Use the <a href="{@docRoot}jetpack/androidx.html">AndroidX</a>
 * <a href="{@docRoot}reference/androidx/media2/session/package-summary.html">Media2 session
 * Library</a> for consistent behavior across all devices.
 * <p>
 * Gets a list of {@link android.media.Session2Token Session2Token} with type {@link android.media.Session2Token#TYPE_SESSION Session2Token#TYPE_SESSION} for the
 * current user.
 * <p>
 * Although this API can be used without any restriction, each session owners can accept or
 * reject your uses of {@link android.media.MediaSession2 MediaSession2}.
 *
 * @return A list of {@link android.media.Session2Token Session2Token}.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.util.List<android.media.Session2Token> getSession2Tokens() { throw new RuntimeException("Stub!"); }

/**
 * Add a listener to be notified when the list of active sessions
 * changes.This requires the
 * android.Manifest.permission.MEDIA_CONTENT_CONTROL permission be held by
 * the calling app. You may also retrieve this list if your app is an
 * enabled notification listener using the
 * {@link android.service.notification.NotificationListenerService NotificationListenerService} APIs, in which case you must pass the
 * {@link android.content.ComponentName ComponentName} of your enabled listener. Updates will be posted to
 * the thread that registered the listener.
 *
 * @param sessionListener The listener to add.
 * This value must never be {@code null}.
 * @param notificationListener The enabled notification listener component.
 *            May be null.
 
 * This value may be {@code null}.
 * @apiSince 21
 */

public void addOnActiveSessionsChangedListener(@androidx.annotation.NonNull android.media.session.MediaSessionManager.OnActiveSessionsChangedListener sessionListener, @androidx.annotation.Nullable android.content.ComponentName notificationListener) { throw new RuntimeException("Stub!"); }

/**
 * Add a listener to be notified when the list of active sessions
 * changes.This requires the
 * android.Manifest.permission.MEDIA_CONTENT_CONTROL permission be held by
 * the calling app. You may also retrieve this list if your app is an
 * enabled notification listener using the
 * {@link android.service.notification.NotificationListenerService NotificationListenerService} APIs, in which case you must pass the
 * {@link android.content.ComponentName ComponentName} of your enabled listener. Updates will be posted to
 * the handler specified or to the caller's thread if the handler is null.
 *
 * @param sessionListener The listener to add.
 * This value must never be {@code null}.
 * @param notificationListener The enabled notification listener component.
 *            May be null.
 * This value may be {@code null}.
 * @param handler The handler to post events to.
 
 * This value may be {@code null}.
 * @apiSince 21
 */

public void addOnActiveSessionsChangedListener(@androidx.annotation.NonNull android.media.session.MediaSessionManager.OnActiveSessionsChangedListener sessionListener, @androidx.annotation.Nullable android.content.ComponentName notificationListener, @androidx.annotation.Nullable android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Stop receiving active sessions updates on the specified listener.
 *
 * @param listener The listener to remove.
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public void removeOnActiveSessionsChangedListener(@androidx.annotation.NonNull android.media.session.MediaSessionManager.OnActiveSessionsChangedListener listener) { throw new RuntimeException("Stub!"); }

/**
 * This API is not generally intended for third party application developers.
 * Use the <a href="{@docRoot}jetpack/androidx.html">AndroidX</a>
 * <a href="{@docRoot}reference/androidx/media2/session/package-summary.html">Media2 session
 * Library</a> for consistent behavior across all devices.
 * <p>
 * Adds a listener to be notified when the {@link #getSession2Tokens()} changes.
 *
 * @param listener The listener to add
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void addOnSession2TokensChangedListener(@androidx.annotation.NonNull android.media.session.MediaSessionManager.OnSession2TokensChangedListener listener) { throw new RuntimeException("Stub!"); }

/**
 * This API is not generally intended for third party application developers.
 * Use the <a href="{@docRoot}jetpack/androidx.html">AndroidX</a>
 * <a href="{@docRoot}reference/androidx/media2/session/package-summary.html">Media2 session
 * Library</a> for consistent behavior across all devices.
 * <p>
 * Adds a listener to be notified when the {@link #getSession2Tokens()} changes.
 *
 * @param listener The listener to add
 * This value must never be {@code null}.
 * @param handler The handler to call listener on.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void addOnSession2TokensChangedListener(@androidx.annotation.NonNull android.media.session.MediaSessionManager.OnSession2TokensChangedListener listener, @androidx.annotation.NonNull android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * This API is not generally intended for third party application developers.
 * Use the <a href="{@docRoot}jetpack/androidx.html">AndroidX</a>
 * <a href="{@docRoot}reference/androidx/media2/session/package-summary.html">Media2 session
 * Library</a> for consistent behavior across all devices.
 * <p>
 * Removes the {@link android.media.session.MediaSessionManager.OnSession2TokensChangedListener OnSession2TokensChangedListener} to stop receiving session token updates.
 *
 * @param listener The listener to remove.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void removeOnSession2TokensChangedListener(@androidx.annotation.NonNull android.media.session.MediaSessionManager.OnSession2TokensChangedListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Checks whether the remote user is a trusted app.
 * <p>
 * An app is trusted if the app holds the android.Manifest.permission.MEDIA_CONTENT_CONTROL
 * permission or has an enabled notification listener.
 *
 * @param userInfo The remote user info from either
 *            {@link android.media.session.MediaSession#getCurrentControllerInfo() MediaSession#getCurrentControllerInfo()} or
 *            {@link android.service.media.MediaBrowserService#getCurrentBrowserInfo() MediaBrowserService#getCurrentBrowserInfo()}.
 * This value must never be {@code null}.
 * @return {@code true} if the remote user is trusted and its package name matches with the UID.
 *            {@code false} otherwise.
 * @apiSince 28
 */

public boolean isTrustedForMediaControl(@androidx.annotation.NonNull android.media.session.MediaSessionManager.RemoteUserInfo userInfo) { throw new RuntimeException("Stub!"); }
/**
 * Listens for changes to the list of active sessions. This can be added
 * using {@link #addOnActiveSessionsChangedListener}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnActiveSessionsChangedListener {

/**
 * @param controllers This value may be {@code null}.
 * @apiSince 21
 */

public void onActiveSessionsChanged(@androidx.annotation.Nullable java.util.List<android.media.session.MediaController> controllers);
}

/**
 * This API is not generally intended for third party application developers.
 * Use the <a href="{@docRoot}jetpack/androidx.html">AndroidX</a>
 * <a href="{@docRoot}reference/androidx/media2/session/package-summary.html">Media2 session
 * Library</a> for consistent behavior across all devices.
 * <p>
 * Listens for changes to the {@link #getSession2Tokens()}. This can be added
 * using {@link #addOnSession2TokensChangedListener(android.media.session.MediaSessionManager.OnSession2TokensChangedListener,android.os.Handler)}.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnSession2TokensChangedListener {

/**
 * Called when the {@link #getSession2Tokens()} is changed.
 *
 * @param tokens list of {@link android.media.Session2Token Session2Token}
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void onSession2TokensChanged(@androidx.annotation.NonNull java.util.List<android.media.Session2Token> tokens);
}

/**
 * Information of a remote user of {@link android.media.session.MediaSession MediaSession} or {@link android.service.media.MediaBrowserService MediaBrowserService}.
 * This can be used to decide whether the remote user is trusted app, and also differentiate
 * caller of {@link android.media.session.MediaSession MediaSession} and {@link android.service.media.MediaBrowserService MediaBrowserService} callbacks.
 * <p>
 * See {@link #equals(java.lang.Object)} to take a look at how it differentiate media controller.
 *
 * @see #isTrustedForMediaControl(RemoteUserInfo)
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class RemoteUserInfo {

/**
 * Create a new remote user information.
 *
 * @param packageName The package name of the remote user
 * This value must never be {@code null}.
 * @param pid The pid of the remote user
 * @param uid The uid of the remote user
 * @apiSince 28
 */

public RemoteUserInfo(@androidx.annotation.NonNull java.lang.String packageName, int pid, int uid) { throw new RuntimeException("Stub!"); }

/**
 * @return package name of the controller
 * @apiSince 28
 */

public java.lang.String getPackageName() { throw new RuntimeException("Stub!"); }

/**
 * @return pid of the controller
 * @apiSince 28
 */

public int getPid() { throw new RuntimeException("Stub!"); }

/**
 * @return uid of the controller
 * @apiSince 28
 */

public int getUid() { throw new RuntimeException("Stub!"); }

/**
 * Returns equality of two RemoteUserInfo. Two RemoteUserInfo objects are equal
 * if and only if they have the same package name, same pid, and same uid.
 *
 * @param obj the reference object with which to compare.
 * This value may be {@code null}.
 * @return {@code true} if equals, {@code false} otherwise
 * @apiSince 28
 */

public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int hashCode() { throw new RuntimeException("Stub!"); }
}

}

