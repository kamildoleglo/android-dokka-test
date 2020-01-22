/*
 * Copyright 2019 The Android Open Source Project
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

import android.app.Service;
import android.content.Intent;
import android.app.NotificationManager;
import android.app.Notification;

/**
 * This API is not generally intended for third party application developers.
 * Use the <a href="{@docRoot}jetpack/androidx.html">AndroidX</a>
 * <a href="{@docRoot}reference/androidx/media2/session/package-summary.html">Media2 session
 * Library</a> for consistent behavior across all devices.
 * <p>
 * Service containing {@link android.media.MediaSession2 MediaSession2}.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class MediaSession2Service extends android.app.Service {

public MediaSession2Service() { throw new RuntimeException("Stub!"); }

/**
 * Called by the system when the service is first created. Do not call this method directly.
 * <p>
 * Override this method if you need your own initialization. Derived classes MUST call through
 * to the super class's implementation of this method.
 
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @apiSince 29
 */

public void onCreate() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 
 * @param intent This value must never be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.os.IBinder onBind(@androidx.annotation.NonNull android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Called by the system to notify that it is no longer used and is being removed. Do not call
 * this method directly.
 * <p>
 * Override this method if you need your own clean up. Derived classes MUST call through
 * to the super class's implementation of this method.
 
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @apiSince 29
 */

public void onDestroy() { throw new RuntimeException("Stub!"); }

/**
 * Called when a {@link android.media.MediaController2 MediaController2} is created with the this service's
 * {@link android.media.Session2Token Session2Token}. Return the session for telling the controller which session to
 * connect. Return {@code null} to reject the connection from this controller.
 * <p>
 * Session returned here will be added to this service automatically. You don't need to call
 * {@link #addSession(android.media.MediaSession2)} for that.
 * <p>
 * This method is always called on the main thread.
 *
 * @param controllerInfo information of the controller which is trying to connect.
 * This value must never be {@code null}.
 * @return a {@link android.media.MediaSession2 MediaSession2} instance for the controller to connect to, or {@code null}
 *         to reject connection
 * @see android.media.MediaSession2.Builder
 * @see #getSessions()
 * @apiSince 29
 */

@androidx.annotation.Nullable
public abstract android.media.MediaSession2 onGetSession(@androidx.annotation.NonNull android.media.MediaSession2.ControllerInfo controllerInfo);

/**
 * Called when notification UI needs update. Override this method to show or cancel your own
 * notification UI.
 * <p>
 * This would be called on {@link android.media.MediaSession2 MediaSession2}'s callback executor when playback state is
 * changed.
 * <p>
 * With the notification returned here, the service becomes foreground service when the playback
 * is started. Apps must request the permission
 * {@link android.Manifest.permission#FOREGROUND_SERVICE} in order to use this API. It becomes
 * background service after the playback is stopped.
 *
 * @param session a session that needs notification update.
 * This value must never be {@code null}.
 * @return a {@link android.media.MediaSession2Service.MediaNotification MediaNotification}. Can be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public abstract android.media.MediaSession2Service.MediaNotification onUpdateNotification(@androidx.annotation.NonNull android.media.MediaSession2 session);

/**
 * Adds a session to this service.
 * <p>
 * Added session will be removed automatically when it's closed, or removed when
 * {@link #removeSession} is called.
 *
 * @param session a session to be added.
 * This value must never be {@code null}.
 * @see #removeSession(MediaSession2)
 * @apiSince 29
 */

public final void addSession(@androidx.annotation.NonNull android.media.MediaSession2 session) { throw new RuntimeException("Stub!"); }

/**
 * Removes a session from this service.
 *
 * @param session a session to be removed.
 * This value must never be {@code null}.
 * @see #addSession(MediaSession2)
 * @apiSince 29
 */

public final void removeSession(@androidx.annotation.NonNull android.media.MediaSession2 session) { throw new RuntimeException("Stub!"); }

/**
 * Gets the list of {@link android.media.MediaSession2 MediaSession2}s that you've added to this service.
 *
 * @return sessions
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public final java.util.List<android.media.MediaSession2> getSessions() { throw new RuntimeException("Stub!"); }

/**
 * The {@link android.content.Intent Intent} that must be declared as handled by the service.
 * @apiSince 29
 */

public static final java.lang.String SERVICE_INTERFACE = "android.media.MediaSession2Service";
/**
 * This API is not generally intended for third party application developers.
 * Use the <a href="{@docRoot}jetpack/androidx.html">AndroidX</a>
 * <a href="{@docRoot}reference/androidx/media2/session/package-summary.html">Media2 session
 * Library</a> for consistent behavior across all devices.
 * <p>
 * Returned by {@link #onUpdateNotification(android.media.MediaSession2)} for making session service
 * foreground service to keep playback running in the background. It's highly recommended to
 * show media style notification here.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class MediaNotification {

/**
 * Default constructor
 *
 * @param notificationId notification id to be used for
 *        {@link android.app.NotificationManager#notify(int,android.app.Notification) NotificationManager#notify(int, Notification)}.
 * @param notification a notification to make session service run in the foreground. Media
 *        style notification is recommended here.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public MediaNotification(int notificationId, @androidx.annotation.NonNull android.app.Notification notification) { throw new RuntimeException("Stub!"); }

/**
 * Gets the id of the notification.
 *
 * @return the notification id
 * @apiSince 29
 */

public int getNotificationId() { throw new RuntimeException("Stub!"); }

/**
 * Gets the notification.
 *
 * @return the notification
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.app.Notification getNotification() { throw new RuntimeException("Stub!"); }
}

}

