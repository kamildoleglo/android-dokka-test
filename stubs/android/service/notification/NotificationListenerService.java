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


package android.service.notification;

import android.app.ActivityManager;
import android.app.Notification;
import android.os.Build;
import android.content.ComponentName;
import android.app.NotificationManager;
import android.companion.CompanionDeviceManager;
import android.app.NotificationChannelGroup;
import android.os.UserHandle;
import android.app.NotificationChannel;
import android.content.Intent;

/**
 * A service that receives calls from the system when new notifications are
 * posted or removed, or their ranking changed.
 * <p>To extend this class, you must declare the service in your manifest file with
 * the {@link android.Manifest.permission#BIND_NOTIFICATION_LISTENER_SERVICE} permission
 * and include an intent filter with the {@link #SERVICE_INTERFACE} action. For example:</p>
 * <pre>
 * &lt;service android:name=".NotificationListener"
 *          android:label="&#64;string/service_name"
 *          android:permission="android.permission.BIND_NOTIFICATION_LISTENER_SERVICE">
 *     &lt;intent-filter>
 *         &lt;action android:name="android.service.notification.NotificationListenerService" />
 *     &lt;/intent-filter>
 * &lt;/service></pre>
 *
 * <p>The service should wait for the {@link #onListenerConnected()} event
 * before performing any operations. The {@link #requestRebind(android.content.ComponentName)}
 * method is the <i>only</i> one that is safe to call before {@link #onListenerConnected()}
 * or after {@link #onListenerDisconnected()}.
 * </p>
 * <p> Notification listeners cannot get notification access or be bound by the system on
 * {@linkplain android.app.ActivityManager#isLowRamDevice() ActivityManager#isLowRamDevice()} devices. The system also ignores
 * notification listeners running in a work profile. A
 * {@link android.app.admin.DevicePolicyManager} might block notifications originating from a work
 * profile.</p>
 * <p>
 *     From {@link android.os.Build.VERSION_CODES#N Build.VERSION_CODES#N} onward all callbacks are called on the main thread. Prior
 *     to N, there is no guarantee on what thread the callback will happen.
 * </p>
 * @apiSince 18
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class NotificationListenerService extends android.app.Service {

public NotificationListenerService() { throw new RuntimeException("Stub!"); }

/** @apiSince 18 */

protected void attachBaseContext(android.content.Context base) { throw new RuntimeException("Stub!"); }

/**
 * Implement this method to learn about new notifications as they are posted by apps.
 *
 * @param sbn A data structure encapsulating the original {@link android.app.Notification}
 *            object as well as its identifying information (tag and id) and source
 *            (package name).
 * @apiSince 18
 */

public void onNotificationPosted(android.service.notification.StatusBarNotification sbn) { throw new RuntimeException("Stub!"); }

/**
 * Implement this method to learn about new notifications as they are posted by apps.
 *
 * @param sbn A data structure encapsulating the original {@link android.app.Notification}
 *            object as well as its identifying information (tag and id) and source
 *            (package name).
 * @param rankingMap The current ranking map that can be used to retrieve ranking information
 *                   for active notifications, including the newly posted one.
 * @apiSince 21
 */

public void onNotificationPosted(android.service.notification.StatusBarNotification sbn, android.service.notification.NotificationListenerService.RankingMap rankingMap) { throw new RuntimeException("Stub!"); }

/**
 * Implement this method to learn when notifications are removed.
 * <p>
 * This might occur because the user has dismissed the notification using system UI (or another
 * notification listener) or because the app has withdrawn the notification.
 * <p>
 * NOTE: The {@link android.service.notification.StatusBarNotification StatusBarNotification} object you receive will be "light"; that is, the
 * result from {@link android.service.notification.StatusBarNotification#getNotification StatusBarNotification#getNotification} may be missing some heavyweight
 * fields such as {@link android.app.Notification#contentView} and
 * {@link android.app.Notification#largeIcon}. However, all other fields on
 * {@link android.service.notification.StatusBarNotification StatusBarNotification}, sufficient to match this call with a prior call to
 * {@link #onNotificationPosted(android.service.notification.StatusBarNotification)}, will be intact.
 *
 * @param sbn A data structure encapsulating at least the original information (tag and id)
 *            and source (package name) used to post the {@link android.app.Notification} that
 *            was just removed.
 * @apiSince 18
 */

public void onNotificationRemoved(android.service.notification.StatusBarNotification sbn) { throw new RuntimeException("Stub!"); }

/**
 * Implement this method to learn when notifications are removed.
 * <p>
 * This might occur because the user has dismissed the notification using system UI (or another
 * notification listener) or because the app has withdrawn the notification.
 * <p>
 * NOTE: The {@link android.service.notification.StatusBarNotification StatusBarNotification} object you receive will be "light"; that is, the
 * result from {@link android.service.notification.StatusBarNotification#getNotification StatusBarNotification#getNotification} may be missing some heavyweight
 * fields such as {@link android.app.Notification#contentView} and
 * {@link android.app.Notification#largeIcon}. However, all other fields on
 * {@link android.service.notification.StatusBarNotification StatusBarNotification}, sufficient to match this call with a prior call to
 * {@link #onNotificationPosted(android.service.notification.StatusBarNotification)}, will be intact.
 *
 * @param sbn A data structure encapsulating at least the original information (tag and id)
 *            and source (package name) used to post the {@link android.app.Notification} that
 *            was just removed.
 * @param rankingMap The current ranking map that can be used to retrieve ranking information
 *                   for active notifications.
 *
 * @apiSince 21
 */

public void onNotificationRemoved(android.service.notification.StatusBarNotification sbn, android.service.notification.NotificationListenerService.RankingMap rankingMap) { throw new RuntimeException("Stub!"); }

/**
 * Implement this method to learn when notifications are removed and why.
 * <p>
 * This might occur because the user has dismissed the notification using system UI (or another
 * notification listener) or because the app has withdrawn the notification.
 * <p>
 * NOTE: The {@link android.service.notification.StatusBarNotification StatusBarNotification} object you receive will be "light"; that is, the
 * result from {@link android.service.notification.StatusBarNotification#getNotification StatusBarNotification#getNotification} may be missing some heavyweight
 * fields such as {@link android.app.Notification#contentView} and
 * {@link android.app.Notification#largeIcon}. However, all other fields on
 * {@link android.service.notification.StatusBarNotification StatusBarNotification}, sufficient to match this call with a prior call to
 * {@link #onNotificationPosted(android.service.notification.StatusBarNotification)}, will be intact.
 *
 ** @param sbn A data structure encapsulating at least the original information (tag and id)
 *            and source (package name) used to post the {@link android.app.Notification} that
 *            was just removed.
 * @param rankingMap The current ranking map that can be used to retrieve ranking information
 *                   for active notifications.
 * @param reason see {@link #REASON_LISTENER_CANCEL}, etc.
 * @apiSince 26
 */

public void onNotificationRemoved(android.service.notification.StatusBarNotification sbn, android.service.notification.NotificationListenerService.RankingMap rankingMap, int reason) { throw new RuntimeException("Stub!"); }

/**
 * Implement this method to learn about when the listener is enabled and connected to
 * the notification manager.  You are safe to call {@link #getActiveNotifications()}
 * at this time.
 * @apiSince 21
 */

public void onListenerConnected() { throw new RuntimeException("Stub!"); }

/**
 * Implement this method to learn about when the listener is disconnected from the
 * notification manager.You will not receive any events after this call, and may only
 * call {@link #requestRebind(android.content.ComponentName)} at this time.
 * @apiSince 24
 */

public void onListenerDisconnected() { throw new RuntimeException("Stub!"); }

/**
 * Implement this method to be notified when the notification ranking changes.
 *
 * @param rankingMap The current ranking map that can be used to retrieve ranking information
 *                   for active notifications.
 * @apiSince 21
 */

public void onNotificationRankingUpdate(android.service.notification.NotificationListenerService.RankingMap rankingMap) { throw new RuntimeException("Stub!"); }

/**
 * Implement this method to be notified when the
 * {@link #getCurrentListenerHints() Listener hints} change.
 *
 * @param hints The current {@link #getCurrentListenerHints() listener hints}.
 * @apiSince 21
 */

public void onListenerHintsChanged(int hints) { throw new RuntimeException("Stub!"); }

/**
 * Implement this method to be notified when the behavior of silent notifications in the status
 * bar changes. See {@link android.app.NotificationManager#shouldHideSilentStatusBarIcons() NotificationManager#shouldHideSilentStatusBarIcons()}.
 *
 * @param hideSilentStatusIcons whether or not status bar icons should be hidden for silent
 *                              notifications
 * @apiSince 29
 */

public void onSilentStatusBarIconsVisibilityChanged(boolean hideSilentStatusIcons) { throw new RuntimeException("Stub!"); }

/**
 * Implement this method to learn about notification channel modifications.
 *
 * <p>The caller must have {@link android.companion.CompanionDeviceManager#getAssociations() CompanionDeviceManager#getAssociations()} in order to receive this callback.
 *
 * @param pkg The package the channel belongs to.
 * @param user The user on which the change was made.
 * @param channel The channel that has changed.
 * @param modificationType One of {@link #NOTIFICATION_CHANNEL_OR_GROUP_ADDED},
 *                   {@link #NOTIFICATION_CHANNEL_OR_GROUP_UPDATED},
 *                   {@link #NOTIFICATION_CHANNEL_OR_GROUP_DELETED}.
 
 * Value is {@link android.service.notification.NotificationListenerService#NOTIFICATION_CHANNEL_OR_GROUP_ADDED}, {@link android.service.notification.NotificationListenerService#NOTIFICATION_CHANNEL_OR_GROUP_UPDATED}, or {@link android.service.notification.NotificationListenerService#NOTIFICATION_CHANNEL_OR_GROUP_DELETED}
 * @apiSince 26
 */

public void onNotificationChannelModified(java.lang.String pkg, android.os.UserHandle user, android.app.NotificationChannel channel, int modificationType) { throw new RuntimeException("Stub!"); }

/**
 * Implement this method to learn about notification channel group modifications.
 *
 * <p>The caller must have {@link android.companion.CompanionDeviceManager#getAssociations() CompanionDeviceManager#getAssociations()} in order to receive this callback.
 *
 * @param pkg The package the group belongs to.
 * @param user The user on which the change was made.
 * @param group The group that has changed.
 * @param modificationType One of {@link #NOTIFICATION_CHANNEL_OR_GROUP_ADDED},
 *                   {@link #NOTIFICATION_CHANNEL_OR_GROUP_UPDATED},
 *                   {@link #NOTIFICATION_CHANNEL_OR_GROUP_DELETED}.
 
 * Value is {@link android.service.notification.NotificationListenerService#NOTIFICATION_CHANNEL_OR_GROUP_ADDED}, {@link android.service.notification.NotificationListenerService#NOTIFICATION_CHANNEL_OR_GROUP_UPDATED}, or {@link android.service.notification.NotificationListenerService#NOTIFICATION_CHANNEL_OR_GROUP_DELETED}
 * @apiSince 26
 */

public void onNotificationChannelGroupModified(java.lang.String pkg, android.os.UserHandle user, android.app.NotificationChannelGroup group, int modificationType) { throw new RuntimeException("Stub!"); }

/**
 * Implement this method to be notified when the
 * {@link #getCurrentInterruptionFilter() interruption filter} changed.
 *
 * @param interruptionFilter The current
 *     {@link #getCurrentInterruptionFilter() interruption filter}.
 * @apiSince 21
 */

public void onInterruptionFilterChanged(int interruptionFilter) { throw new RuntimeException("Stub!"); }

/**
 * Inform the notification manager about dismissal of a single notification.
 * <p>
 * Use this if your listener has a user interface that allows the user to dismiss individual
 * notifications, similar to the behavior of Android's status bar and notification panel.
 * It should be called after the user dismisses a single notification using your UI;
 * upon being informed, the notification manager will actually remove the notification
 * and you will get an {@link #onNotificationRemoved(android.service.notification.StatusBarNotification)} callback.
 * <p>
 * <b>Note:</b> If your listener allows the user to fire a notification's
 * {@link android.app.Notification#contentIntent} by tapping/clicking/etc., you should call
 * this method at that time <i>if</i> the Notification in question has the
 * {@link android.app.Notification#FLAG_AUTO_CANCEL} flag set.
 *
 * <p>The service should wait for the {@link #onListenerConnected()} event
 * before performing this operation.
 *
 * @param pkg Package of the notifying app.
 * @param tag Tag of the notification as specified by the notifying app in
 *     {@link android.app.NotificationManager#notify(String, int, android.app.Notification)}.
 * @param id  ID of the notification as specified by the notifying app in
 *     {@link android.app.NotificationManager#notify(String, int, android.app.Notification)}.
 * <p>
 * @deprecated Use {@link #cancelNotification(java.lang.String)}
 * instead. Beginning with {@link android.os.Build.VERSION_CODES#LOLLIPOP} this method will no longer
 * cancel the notification. It will continue to cancel the notification for applications
 * whose {@code targetSdkVersion} is earlier than {@link android.os.Build.VERSION_CODES#LOLLIPOP}.
 * @apiSince 18
 * @deprecatedSince 21
 */

@Deprecated
public final void cancelNotification(java.lang.String pkg, java.lang.String tag, int id) { throw new RuntimeException("Stub!"); }

/**
 * Inform the notification manager about dismissal of a single notification.
 * <p>
 * Use this if your listener has a user interface that allows the user to dismiss individual
 * notifications, similar to the behavior of Android's status bar and notification panel.
 * It should be called after the user dismisses a single notification using your UI;
 * upon being informed, the notification manager will actually remove the notification
 * and you will get an {@link #onNotificationRemoved(android.service.notification.StatusBarNotification)} callback.
 * <p>
 * <b>Note:</b> If your listener allows the user to fire a notification's
 * {@link android.app.Notification#contentIntent} by tapping/clicking/etc., you should call
 * this method at that time <i>if</i> the Notification in question has the
 * {@link android.app.Notification#FLAG_AUTO_CANCEL} flag set.
 * <p>
 *
 * <p>The service should wait for the {@link #onListenerConnected()} event
 * before performing this operation.
 *
 * @param key Notification to dismiss from {@link android.service.notification.StatusBarNotification#getKey() StatusBarNotification#getKey()}.
 * @apiSince 21
 */

public final void cancelNotification(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Inform the notification manager about dismissal of all notifications.
 * <p>
 * Use this if your listener has a user interface that allows the user to dismiss all
 * notifications, similar to the behavior of Android's status bar and notification panel.
 * It should be called after the user invokes the "dismiss all" function of your UI;
 * upon being informed, the notification manager will actually remove all active notifications
 * and you will get multiple {@link #onNotificationRemoved(android.service.notification.StatusBarNotification)} callbacks.
 *
 * <p>The service should wait for the {@link #onListenerConnected()} event
 * before performing this operation.
 *
 * {@see #cancelNotification(String, String, int)}
 * @apiSince 18
 */

public final void cancelAllNotifications() { throw new RuntimeException("Stub!"); }

/**
 * Inform the notification manager about dismissal of specific notifications.
 * <p>
 * Use this if your listener has a user interface that allows the user to dismiss
 * multiple notifications at once.
 *
 * <p>The service should wait for the {@link #onListenerConnected()} event
 * before performing this operation.
 *
 * @param keys Notifications to dismiss, or {@code null} to dismiss all.
 *
 * {@see #cancelNotification(String, String, int)}
 * @apiSince 21
 */

public final void cancelNotifications(java.lang.String[] keys) { throw new RuntimeException("Stub!"); }

/**
 * Inform the notification manager about snoozing a specific notification.
 * <p>
 * Use this if your listener has a user interface that allows the user to snooze a notification
 * for a time. It should be called after the user snoozes a single notification using
 * your UI; upon being informed, the notification manager will actually remove the notification
 * and you will get an {@link #onNotificationRemoved(android.service.notification.StatusBarNotification)} callback. When the
 * snoozing period expires, you will get a
 * {@link #onNotificationPosted(android.service.notification.StatusBarNotification,android.service.notification.NotificationListenerService.RankingMap)} callback for the
 * notification.
 * @param key The key of the notification to snooze
 * @param durationMs A duration to snooze the notification for, in milliseconds.
 * @apiSince 26
 */

public final void snoozeNotification(java.lang.String key, long durationMs) { throw new RuntimeException("Stub!"); }

/**
 * Inform the notification manager that these notifications have been viewed by the
 * user. This should only be called when there is sufficient confidence that the user is
 * looking at the notifications, such as when the notifications appear on the screen due to
 * an explicit user interaction.
 *
 * <p>The service should wait for the {@link #onListenerConnected()} event
 * before performing this operation.
 *
 * @param keys Notifications to mark as seen.
 * @apiSince 23
 */

public final void setNotificationsShown(java.lang.String[] keys) { throw new RuntimeException("Stub!"); }

/**
 * Updates a notification channel for a given package for a given user. This should only be used
 * to reflect changes a user has made to the channel via the listener's user interface.
 *
 * <p>This method will throw a security exception if you don't have access to notifications
 * for the given user.</p>
 * <p>The caller must have {@link android.companion.CompanionDeviceManager#getAssociations() CompanionDeviceManager#getAssociations()} in order to use this method.
 *
 * @param pkg The package the channel belongs to.
 * This value must never be {@code null}.
 * @param user The user the channel belongs to.
 * This value must never be {@code null}.
 * @param channel the channel to update.
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public final void updateNotificationChannel(@androidx.annotation.NonNull java.lang.String pkg, @androidx.annotation.NonNull android.os.UserHandle user, @androidx.annotation.NonNull android.app.NotificationChannel channel) { throw new RuntimeException("Stub!"); }

/**
 * Returns all notification channels belonging to the given package for a given user.
 *
 * <p>This method will throw a security exception if you don't have access to notifications
 * for the given user.</p>
 * <p>The caller must have {@link android.companion.CompanionDeviceManager#getAssociations() CompanionDeviceManager#getAssociations()} or be the {@link android.service.notification.NotificationAssistantService NotificationAssistantService} in order to
 * use this method.
 *
 * @param pkg The package to retrieve channels for.
 
 * This value must never be {@code null}.
 
 * @param user This value must never be {@code null}.
 * @apiSince 26
 */

public final java.util.List<android.app.NotificationChannel> getNotificationChannels(@androidx.annotation.NonNull java.lang.String pkg, @androidx.annotation.NonNull android.os.UserHandle user) { throw new RuntimeException("Stub!"); }

/**
 * Returns all notification channel groups belonging to the given package for a given user.
 *
 * <p>This method will throw a security exception if you don't have access to notifications
 * for the given user.</p>
 * <p>The caller must have {@link android.companion.CompanionDeviceManager#getAssociations() CompanionDeviceManager#getAssociations()} or be the {@link android.service.notification.NotificationAssistantService NotificationAssistantService} in order to
 * use this method.
 *
 * @param pkg The package to retrieve channel groups for.
 
 * This value must never be {@code null}.
 
 * @param user This value must never be {@code null}.
 * @apiSince 26
 */

public final java.util.List<android.app.NotificationChannelGroup> getNotificationChannelGroups(@androidx.annotation.NonNull java.lang.String pkg, @androidx.annotation.NonNull android.os.UserHandle user) { throw new RuntimeException("Stub!"); }

/**
 * Request the list of outstanding notifications (that is, those that are visible to the
 * current user). Useful when you don't know what's already been posted.
 *
 * <p>The service should wait for the {@link #onListenerConnected()} event
 * before performing this operation.
 *
 * @return An array of active notifications, sorted in natural order.
 * @apiSince 18
 */

public android.service.notification.StatusBarNotification[] getActiveNotifications() { throw new RuntimeException("Stub!"); }

/**
 * Like {@link #getActiveNotifications()}, but returns the list of currently snoozed
 * notifications, for all users this listener has access to.
 *
 * <p>The service should wait for the {@link #onListenerConnected()} event
 * before performing this operation.
 *
 * @return An array of snoozed notifications, sorted in natural order.
 * @apiSince 26
 */

public final android.service.notification.StatusBarNotification[] getSnoozedNotifications() { throw new RuntimeException("Stub!"); }

/**
 * Request one or more notifications by key. Useful if you have been keeping track of
 * notifications but didn't want to retain the bits, and now need to go back and extract
 * more data out of those notifications.
 *
 * <p>The service should wait for the {@link #onListenerConnected()} event
 * before performing this operation.
 *
 * @param keys the keys of the notifications to request
 * @return An array of notifications corresponding to the requested keys, in the
 * same order as the key list.
 * @apiSince 21
 */

public android.service.notification.StatusBarNotification[] getActiveNotifications(java.lang.String[] keys) { throw new RuntimeException("Stub!"); }

/**
 * Gets the set of hints representing current state.
 *
 * <p>
 * The current state may differ from the requested state if the hint represents state
 * shared across all listeners or a feature the notification host does not support or refuses
 * to grant.
 *
 * <p>The service should wait for the {@link #onListenerConnected()} event
 * before performing this operation.
 *
 * @return Zero or more of the HINT_ constants.
 * @apiSince 21
 */

public final int getCurrentListenerHints() { throw new RuntimeException("Stub!"); }

/**
 * Gets the current notification interruption filter active on the host.
 *
 * <p>
 * The interruption filter defines which notifications are allowed to interrupt the user
 * (e.g. via sound &amp; vibration) and is applied globally. Listeners can find out whether
 * a specific notification matched the interruption filter via
 * {@link android.service.notification.NotificationListenerService.Ranking#matchesInterruptionFilter() Ranking#matchesInterruptionFilter()}.
 * <p>
 * The current filter may differ from the previously requested filter if the notification host
 * does not support or refuses to apply the requested filter, or if another component changed
 * the filter in the meantime.
 * <p>
 * Listen for updates using {@link #onInterruptionFilterChanged(int)}.
 *
 * <p>The service should wait for the {@link #onListenerConnected()} event
 * before performing this operation.
 *
 * @return One of the INTERRUPTION_FILTER_ constants, or INTERRUPTION_FILTER_UNKNOWN when
 * unavailable.
 * @apiSince 21
 */

public final int getCurrentInterruptionFilter() { throw new RuntimeException("Stub!"); }

/**
 * Clears listener hints set via {@link #getCurrentListenerHints()}.
 *
 * <p>The service should wait for the {@link #onListenerConnected()} event
 * before performing this operation.
 * @apiSince 29
 */

public final void clearRequestedListenerHints() { throw new RuntimeException("Stub!"); }

/**
 * Sets the desired {@link #getCurrentListenerHints() listener hints}.
 *
 * <p>
 * This is merely a request, the host may or may not choose to take action depending
 * on other listener requests or other global state.
 * <p>
 * Listen for updates using {@link #onListenerHintsChanged(int)}.
 *
 * <p>The service should wait for the {@link #onListenerConnected()} event
 * before performing this operation.
 *
 * @param hints One or more of the HINT_ constants.
 * @apiSince 21
 */

public final void requestListenerHints(int hints) { throw new RuntimeException("Stub!"); }

/**
 * Sets the desired {@link #getCurrentInterruptionFilter() interruption filter}.
 *
 * <p>
 * This is merely a request, the host may or may not choose to apply the requested
 * interruption filter depending on other listener requests or other global state.
 * <p>
 * Listen for updates using {@link #onInterruptionFilterChanged(int)}.
 *
 * <p>The service should wait for the {@link #onListenerConnected()} event
 * before performing this operation.
 *
 * @param interruptionFilter One of the INTERRUPTION_FILTER_ constants.
 * @apiSince 21
 */

public final void requestInterruptionFilter(int interruptionFilter) { throw new RuntimeException("Stub!"); }

/**
 * Returns current ranking information.
 *
 * <p>
 * The returned object represents the current ranking snapshot and only
 * applies for currently active notifications.
 * <p>
 * Generally you should use the RankingMap that is passed with events such
 * as {@link #onNotificationPosted(android.service.notification.StatusBarNotification,android.service.notification.NotificationListenerService.RankingMap)},
 * {@link #onNotificationRemoved(android.service.notification.StatusBarNotification,android.service.notification.NotificationListenerService.RankingMap)}, and
 * so on. This method should only be used when needing access outside of
 * such events, for example to retrieve the RankingMap right after
 * initialization.
 *
 * <p>The service should wait for the {@link #onListenerConnected()} event
 * before performing this operation.
 *
 * @return A {@link android.service.notification.NotificationListenerService.RankingMap RankingMap} object providing access to ranking information
 * @apiSince 21
 */

public android.service.notification.NotificationListenerService.RankingMap getCurrentRanking() { throw new RuntimeException("Stub!"); }

/**
 * This is not the lifecycle event you are looking for.
 *
 * <p>The service should wait for the {@link #onListenerConnected()} event
 * before performing any operations.
 * @apiSince 18
 */

public android.os.IBinder onBind(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/** @apiSince 18 */

public void onDestroy() { throw new RuntimeException("Stub!"); }

/**
 * Request that the listener be rebound, after a previous call to {@link #requestUnbind}.
 *
 * <p>This method will fail for listeners that have
 * not been granted the permission by the user.
 * @apiSince 24
 */

public static void requestRebind(android.content.ComponentName componentName) { throw new RuntimeException("Stub!"); }

/**
 * Request that the service be unbound.
 *
 * <p>Once this is called, you will no longer receive updates and no method calls are
 * guaranteed to be successful, until you next receive the {@link #onListenerConnected()} event.
 * The service will likely be killed by the system after this call.
 *
 * <p>The service should wait for the {@link #onListenerConnected()} event
 * before performing this operation. I know it's tempting, but you must wait.
 * @apiSince 24
 */

public final void requestUnbind() { throw new RuntimeException("Stub!"); }

/** {@link #getCurrentListenerHints() Listener hints} constant - the primary device UI
 * should disable phone call sounds, buyt not notification sound.
 * This does not change the interruption filter, only the effects. *     * @apiSince 24
 */

public static final int HINT_HOST_DISABLE_CALL_EFFECTS = 4; // 0x4

/** {@link #getCurrentListenerHints() Listener hints} constant - the primary device UI
 * should disable notification sound, vibrating and other visual or aural effects.
 * This does not change the interruption filter, only the effects. *     * @apiSince 21
 */

public static final int HINT_HOST_DISABLE_EFFECTS = 1; // 0x1

/** {@link #getCurrentListenerHints() Listener hints} constant - the primary device UI
 * should disable notification sound, but not phone calls.
 * This does not change the interruption filter, only the effects. *     * @apiSince 24
 */

public static final int HINT_HOST_DISABLE_NOTIFICATION_EFFECTS = 2; // 0x2

/**
 * {@link #getCurrentInterruptionFilter() Interruption filter} constant -
 *     Alarms only interruption filter.
 * @apiSince 23
 */

public static final int INTERRUPTION_FILTER_ALARMS = 4; // 0x4

/**
 * {@link #getCurrentInterruptionFilter() Interruption filter} constant -
 *     Normal interruption filter.
 * @apiSince 21
 */

public static final int INTERRUPTION_FILTER_ALL = 1; // 0x1

/**
 * {@link #getCurrentInterruptionFilter() Interruption filter} constant -
 *     No interruptions filter.
 * @apiSince 21
 */

public static final int INTERRUPTION_FILTER_NONE = 3; // 0x3

/**
 * {@link #getCurrentInterruptionFilter() Interruption filter} constant -
 *     Priority interruption filter.
 * @apiSince 21
 */

public static final int INTERRUPTION_FILTER_PRIORITY = 2; // 0x2

/** {@link #getCurrentInterruptionFilter() Interruption filter} constant - returned when
 * the value is unavailable for any reason.  For example, before the notification listener
 * is connected.
 *
 * {@see #onListenerConnected()}
 * @apiSince 23
 */

public static final int INTERRUPTION_FILTER_UNKNOWN = 0; // 0x0

/**
 * Channel or group modification reason provided to
 * {@link #onNotificationChannelModified(java.lang.String,android.os.UserHandle,android.app.NotificationChannel,int)} or
 * {@link #onNotificationChannelGroupModified(java.lang.String,android.os.UserHandle,android.app.NotificationChannelGroup,int)}- the provided object was created.
 * @apiSince 26
 */

public static final int NOTIFICATION_CHANNEL_OR_GROUP_ADDED = 1; // 0x1

/**
 * Channel or group modification reason provided to
 * {@link #onNotificationChannelModified(java.lang.String,android.os.UserHandle,android.app.NotificationChannel,int)} or
 * {@link #onNotificationChannelGroupModified(java.lang.String,android.os.UserHandle,android.app.NotificationChannelGroup,int)}- the provided object was deleted.
 * @apiSince 26
 */

public static final int NOTIFICATION_CHANNEL_OR_GROUP_DELETED = 3; // 0x3

/**
 * Channel or group modification reason provided to
 * {@link #onNotificationChannelModified(java.lang.String,android.os.UserHandle,android.app.NotificationChannel,int)} or
 * {@link #onNotificationChannelGroupModified(java.lang.String,android.os.UserHandle,android.app.NotificationChannelGroup,int)}
 * - the provided object was updated.
 * @apiSince 26
 */

public static final int NOTIFICATION_CHANNEL_OR_GROUP_UPDATED = 2; // 0x2

/**
 * Notification was canceled by the app canceling this specific notification.
 * @apiSince 26
 */

public static final int REASON_APP_CANCEL = 8; // 0x8

/**
 * Notification was canceled by the app cancelling all its notifications.
 * @apiSince 26
 */

public static final int REASON_APP_CANCEL_ALL = 9; // 0x9

/**
 * Notification was canceled by the status bar reporting a user dismissal.
 * @apiSince 26
 */

public static final int REASON_CANCEL = 2; // 0x2

/**
 * Notification was canceled by the status bar reporting a user dismiss all.
 * @apiSince 26
 */

public static final int REASON_CANCEL_ALL = 3; // 0x3

/**
 * Notification was canceled by the user banning the channel.
 * @apiSince 26
 */

public static final int REASON_CHANNEL_BANNED = 17; // 0x11

/**
 * Notification was canceled by the status bar reporting a notification click.
 * @apiSince 26
 */

public static final int REASON_CLICK = 1; // 0x1

/**
 * Notification was canceled by the status bar reporting an inflation error.
 * @apiSince 26
 */

public static final int REASON_ERROR = 4; // 0x4

/**
 * Notification was canceled because it was an invisible member of a group.
 * @apiSince 26
 */

public static final int REASON_GROUP_OPTIMIZATION = 13; // 0xd

/**
 * Notification was canceled because it was a member of a canceled group.
 * @apiSince 26
 */

public static final int REASON_GROUP_SUMMARY_CANCELED = 12; // 0xc

/**
 * Notification was canceled by a listener reporting a user dismissal.
 * @apiSince 26
 */

public static final int REASON_LISTENER_CANCEL = 10; // 0xa

/**
 * Notification was canceled by a listener reporting a user dismiss all.
 * @apiSince 26
 */

public static final int REASON_LISTENER_CANCEL_ALL = 11; // 0xb

/**
 * Notification was canceled by the user banning the package.
 * @apiSince 26
 */

public static final int REASON_PACKAGE_BANNED = 7; // 0x7

/**
 * Notification was canceled by the package manager modifying the package.
 * @apiSince 26
 */

public static final int REASON_PACKAGE_CHANGED = 5; // 0x5

/**
 * Notification was canceled by the device administrator suspending the package.
 * @apiSince 26
 */

public static final int REASON_PACKAGE_SUSPENDED = 14; // 0xe

/**
 * Notification was canceled by the owning managed profile being turned off.
 * @apiSince 26
 */

public static final int REASON_PROFILE_TURNED_OFF = 15; // 0xf

/**
 * Notification was snoozed.
 * @apiSince 26
 */

public static final int REASON_SNOOZED = 18; // 0x12

/**
 * Notification was canceled due to timeout
 * @apiSince 26
 */

public static final int REASON_TIMEOUT = 19; // 0x13

/**
 * Autobundled summary notification was canceled because its group was unbundled
 * @apiSince 26
 */

public static final int REASON_UNAUTOBUNDLED = 16; // 0x10

/**
 * Notification was canceled by the owning user context being stopped.
 * @apiSince 26
 */

public static final int REASON_USER_STOPPED = 6; // 0x6

/**
 * The {@link android.content.Intent Intent} that must be declared as handled by the service.
 * @apiSince 18
 */

public static final java.lang.String SERVICE_INTERFACE = "android.service.notification.NotificationListenerService";

/**
 * Whether notification suppressed by DND should not interruption visually when the screen is
 * off.
 *
 * @deprecated Use the more specific visual effects in {@link android.app.NotificationManager.Policy NotificationManager.Policy}.
 * @apiSince 24
 * @deprecatedSince 28
 */

@Deprecated public static final int SUPPRESSED_EFFECT_SCREEN_OFF = 1; // 0x1

/**
 * Whether notification suppressed by DND should not interruption visually when the screen is
 * on.
 *
 * @deprecated Use the more specific visual effects in {@link android.app.NotificationManager.Policy NotificationManager.Policy}.
 * @apiSince 24
 * @deprecatedSince 28
 */

@Deprecated public static final int SUPPRESSED_EFFECT_SCREEN_ON = 2; // 0x2
/**
 * Stores ranking related information on a currently active notification.
 *
 * <p>
 * Ranking objects aren't automatically updated as notification events
 * occur. Instead, ranking information has to be retrieved again via the
 * current {@link android.service.notification.NotificationListenerService.RankingMap RankingMap}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Ranking {

/** @apiSince 21 */

public Ranking() { throw new RuntimeException("Stub!"); }

/**
 * Returns the key of the notification this Ranking applies to.
 * @apiSince 21
 */

public java.lang.String getKey() { throw new RuntimeException("Stub!"); }

/**
 * Returns the rank of the notification.
 *
 * @return the rank of the notification, that is the 0-based index in
 *     the list of active notifications.
 * @apiSince 21
 */

public int getRank() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the notification is an ambient notification, that is
 * a notification that doesn't require the user's immediate attention.
 * @apiSince 21
 */

public boolean isAmbient() { throw new RuntimeException("Stub!"); }

/**
 * Returns the type(s) of visual effects that should be suppressed for this notification.
 * See {@link android.app.NotificationManager.Policy NotificationManager.Policy}, e.g.
 * {@link android.app.NotificationManager.Policy#SUPPRESSED_EFFECT_LIGHTS NotificationManager.Policy#SUPPRESSED_EFFECT_LIGHTS}.
 * @apiSince 24
 */

public int getSuppressedVisualEffects() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the notification matches the user's interruption
 * filter.
 *
 * @return {@code true} if the notification is allowed by the filter, or
 * {@code false} if it is blocked.
 * @apiSince 21
 */

public boolean matchesInterruptionFilter() { throw new RuntimeException("Stub!"); }

/**
 * Returns the importance of the notification, which dictates its
 * modes of presentation, see: {@link android.app.NotificationManager#IMPORTANCE_DEFAULT NotificationManager#IMPORTANCE_DEFAULT}, etc.
 *
 * @return the importance of the notification
 
 * Value is {@link android.app.NotificationManager#IMPORTANCE_UNSPECIFIED}, {@link android.app.NotificationManager#IMPORTANCE_NONE}, {@link android.app.NotificationManager#IMPORTANCE_MIN}, {@link android.app.NotificationManager#IMPORTANCE_LOW}, {@link android.app.NotificationManager#IMPORTANCE_DEFAULT}, or {@link android.app.NotificationManager#IMPORTANCE_HIGH}
 * @apiSince 24
 */

public int getImportance() { throw new RuntimeException("Stub!"); }

/**
 * If the importance has been overridden by user preference, then this will be non-null,
 * and should be displayed to the user.
 *
 * @return the explanation for the importance, or null if it is the natural importance
 * @apiSince 24
 */

public java.lang.CharSequence getImportanceExplanation() { throw new RuntimeException("Stub!"); }

/**
 * If the system has overridden the group key, then this will be non-null, and this
 * key should be used to bundle notifications.
 * @apiSince 24
 */

public java.lang.String getOverrideGroupKey() { throw new RuntimeException("Stub!"); }

/**
 * Returns the notification channel this notification was posted to, which dictates
 * notification behavior and presentation.
 * @apiSince 26
 */

public android.app.NotificationChannel getChannel() { throw new RuntimeException("Stub!"); }

/**
 * Returns how the system thinks the user feels about notifications from the
 * channel provided by {@link #getChannel()}. You can use this information to expose
 * controls to help the user block this channel's notifications, if the sentiment is
 * {@link #USER_SENTIMENT_NEGATIVE}, or emphasize this notification if the sentiment is
 * {@link #USER_SENTIMENT_POSITIVE}.
 * @apiSince 28
 */

public int getUserSentiment() { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of smart {@link android.app.Notification.Action Notification.Action} that can be added by the
 * {@link android.service.notification.NotificationAssistantService NotificationAssistantService}
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.util.List<android.app.Notification.Action> getSmartActions() { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of smart replies that can be added by the
 * {@link android.service.notification.NotificationAssistantService NotificationAssistantService}
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.util.List<java.lang.CharSequence> getSmartReplies() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether this notification can be displayed as a badge.
 *
 * @return true if the notification can be displayed as a badge, false otherwise.
 * @apiSince 26
 */

public boolean canShowBadge() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the app that posted this notification is suspended, so this notification
 * should be hidden.
 *
 * @return true if the notification should be hidden, false otherwise.
 * @apiSince 28
 */

public boolean isSuspended() { throw new RuntimeException("Stub!"); }

/**
 * Returns the last time this notification alerted the user via sound or vibration.
 *
 * <br>
 * Value is a non-negative timestamp measured as the number of
 * milliseconds since 1970-01-01T00:00:00Z.
 * @return the time of the last alerting behavior, in milliseconds.
 
 * Value is a non-negative timestamp measured as the number of
 * milliseconds since 1970-01-01T00:00:00Z.
 * @apiSince 29
 */

public long getLastAudiblyAlertedMillis() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the user has allowed bubbles globally, at the app level, and at the
 * channel level for this notification.
 *
 * <p>This does not take into account the current importance of the notification, the
 * current DND state, or whether the posting app is foreground.</p>
 * @apiSince 29
 */

public boolean canBubble() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * The user is likely to have a negative reaction to this notification.
 * @apiSince 28
 */

public static final int USER_SENTIMENT_NEGATIVE = -1; // 0xffffffff

/**
 * It is not known how the user will react to this notification.
 * @apiSince 28
 */

public static final int USER_SENTIMENT_NEUTRAL = 0; // 0x0

/**
 * The user is likely to have a positive reaction to this notification.
 * @apiSince 28
 */

public static final int USER_SENTIMENT_POSITIVE = 1; // 0x1
}

/**
 * Provides access to ranking information on currently active
 * notifications.
 *
 * <p>
 * Note that this object represents a ranking snapshot that only applies to
 * notifications active at the time of retrieval.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class RankingMap implements android.os.Parcelable {

RankingMap() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Request the list of notification keys in their current ranking
 * order.
 *
 * @return An array of active notification keys, in their ranking order.
 * @apiSince 21
 */

public java.lang.String[] getOrderedKeys() { throw new RuntimeException("Stub!"); }

/**
 * Populates outRanking with ranking information for the notification
 * with the given key.
 *
 * @return true if a valid key has been passed and outRanking has
 * been populated; false otherwise
 * @apiSince 21
 */

public boolean getRanking(java.lang.String key, android.service.notification.NotificationListenerService.Ranking outRanking) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.service.notification.NotificationListenerService.RankingMap> CREATOR;
static { CREATOR = null; }
}

}

