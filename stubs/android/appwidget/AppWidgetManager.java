/*
 * Copyright (C) 2006 The Android Open Source Project
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


package android.appwidget;

import android.content.pm.PackageManager;
import android.content.Context;
import android.widget.RemoteViews;
import android.os.Bundle;
import android.content.ComponentName;
import android.os.UserHandle;
import android.app.PendingIntent;
import android.content.pm.ShortcutInfo;
import android.content.IntentSender;
import java.util.List;
import android.content.Intent;

/**
 * Updates AppWidget state; gets information about installed AppWidget providers and other
 * AppWidget related state.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about creating app widgets, read the
 * <a href="{@docRoot}guide/topics/appwidgets/index.html">App Widgets</a> developer guide.</p>
 * </div>
 
 * <br>
 * Requires the {@link android.content.pm.PackageManager#FEATURE_APP_WIDGETS PackageManager#FEATURE_APP_WIDGETS} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AppWidgetManager {

AppWidgetManager() { throw new RuntimeException("Stub!"); }

/**
 * Get the AppWidgetManager instance to use for the supplied {@link android.content.Context
 * Context} object.
 * @apiSince 3
 */

public static android.appwidget.AppWidgetManager getInstance(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Set the RemoteViews to use for the specified appWidgetIds.
 * <p>
 * Note that the RemoteViews parameter will be cached by the AppWidgetService, and hence should
 * contain a complete representation of the widget. For performing partial widget updates, see
 * {@link #partiallyUpdateAppWidget(int[],android.widget.RemoteViews)}.
 *
 * <p>
 * It is okay to call this method both inside an {@link #ACTION_APPWIDGET_UPDATE} broadcast,
 * and outside of the handler.
 * This method will only work when called from the uid that owns the AppWidget provider.
 *
 * <p>
 * The total Bitmap memory used by the RemoteViews object cannot exceed that required to
 * fill the screen 1.5 times, ie. (screen width x screen height x 4 x 1.5) bytes.
 *
 * @param appWidgetIds The AppWidget instances for which to set the RemoteViews.
 * @param views The RemoteViews object to show.
 * @apiSince 3
 */

public void updateAppWidget(int[] appWidgetIds, android.widget.RemoteViews views) { throw new RuntimeException("Stub!"); }

/**
 * Update the extras for a given widget instance.
 * <p>
 * The extras can be used to embed additional information about this widget to be accessed
 * by the associated widget's AppWidgetProvider.
 *
 * @see #getAppWidgetOptions(int)
 *
 * @param appWidgetId The AppWidget instances for which to set the RemoteViews.
 * @param options The options to associate with this widget
 * @apiSince 16
 */

public void updateAppWidgetOptions(int appWidgetId, android.os.Bundle options) { throw new RuntimeException("Stub!"); }

/**
 * Get the extras associated with a given widget instance.
 * <p>
 * The extras can be used to embed additional information about this widget to be accessed
 * by the associated widget's AppWidgetProvider.
 *
 * @see #updateAppWidgetOptions(int, Bundle)
 *
 * @param appWidgetId The AppWidget instances for which to set the RemoteViews.
 * @return The options associated with the given widget instance.
 * @apiSince 16
 */

public android.os.Bundle getAppWidgetOptions(int appWidgetId) { throw new RuntimeException("Stub!"); }

/**
 * Set the RemoteViews to use for the specified appWidgetId.
 * <p>
 * Note that the RemoteViews parameter will be cached by the AppWidgetService, and hence should
 * contain a complete representation of the widget. For performing partial widget updates, see
 * {@link #partiallyUpdateAppWidget(int,android.widget.RemoteViews)}.
 *
 * <p>
 * It is okay to call this method both inside an {@link #ACTION_APPWIDGET_UPDATE} broadcast,
 * and outside of the handler.
 * This method will only work when called from the uid that owns the AppWidget provider.
 *
 * <p>
 * The total Bitmap memory used by the RemoteViews object cannot exceed that required to
 * fill the screen 1.5 times, ie. (screen width x screen height x 4 x 1.5) bytes.
 *
 * @param appWidgetId      The AppWidget instance for which to set the RemoteViews.
 * @param views         The RemoteViews object to show.
 * @apiSince 3
 */

public void updateAppWidget(int appWidgetId, android.widget.RemoteViews views) { throw new RuntimeException("Stub!"); }

/**
 * Perform an incremental update or command on the widget(s) specified by appWidgetIds.
 * <p>
 * This update  differs from {@link #updateAppWidget(int[],android.widget.RemoteViews)} in that the
 * RemoteViews object which is passed is understood to be an incomplete representation of the
 * widget, and hence does not replace the cached representation of the widget. As of API
 * level 17, the new properties set within the views objects will be appended to the cached
 * representation of the widget, and hence will persist.
 *
 * Use with {@link android.widget.RemoteViews#showNext(int) RemoteViews#showNext(int)}, {@link android.widget.RemoteViews#showPrevious(int) RemoteViews#showPrevious(int)},
 * {@link android.widget.RemoteViews#setScrollPosition(int,int) RemoteViews#setScrollPosition(int, int)} and similar commands.
 *
 * <p>
 * It is okay to call this method both inside an {@link #ACTION_APPWIDGET_UPDATE} broadcast,
 * and outside of the handler.
 * This method will only work when called from the uid that owns the AppWidget provider.
 *
 * <p>
 * This method will be ignored if a widget has not received a full update via
 * {@link #updateAppWidget(int[],android.widget.RemoteViews)}.
 *
 * @param appWidgetIds     The AppWidget instances for which to set the RemoteViews.
 * @param views            The RemoteViews object containing the incremental update / command.
 * @apiSince 11
 */

public void partiallyUpdateAppWidget(int[] appWidgetIds, android.widget.RemoteViews views) { throw new RuntimeException("Stub!"); }

/**
 * Perform an incremental update or command on the widget specified by appWidgetId.
 * <p>
 * This update  differs from {@link #updateAppWidget(int,android.widget.RemoteViews)} in that the RemoteViews
 * object which is passed is understood to be an incomplete representation of the widget, and
 * hence is not cached by the AppWidgetService. Note that because these updates are not cached,
 * any state that they modify that is not restored by restoreInstanceState will not persist in
 * the case that the widgets are restored using the cached version in AppWidgetService.
 *
 * Use with {@link android.widget.RemoteViews#showNext(int) RemoteViews#showNext(int)}, {@link android.widget.RemoteViews#showPrevious(int) RemoteViews#showPrevious(int)},
 * {@link android.widget.RemoteViews#setScrollPosition(int,int) RemoteViews#setScrollPosition(int, int)} and similar commands.
 *
 * <p>
 * It is okay to call this method both inside an {@link #ACTION_APPWIDGET_UPDATE} broadcast,
 * and outside of the handler.
 * This method will only work when called from the uid that owns the AppWidget provider.
 *
 * <p>
 * This method will be ignored if a widget has not received a full update via
 * {@link #updateAppWidget(int[],android.widget.RemoteViews)}.
 *
 * @param appWidgetId      The AppWidget instance for which to set the RemoteViews.
 * @param views            The RemoteViews object containing the incremental update / command.
 * @apiSince 11
 */

public void partiallyUpdateAppWidget(int appWidgetId, android.widget.RemoteViews views) { throw new RuntimeException("Stub!"); }

/**
 * Set the RemoteViews to use for all AppWidget instances for the supplied AppWidget provider.
 *
 * <p>
 * It is okay to call this method both inside an {@link #ACTION_APPWIDGET_UPDATE} broadcast,
 * and outside of the handler.
 * This method will only work when called from the uid that owns the AppWidget provider.
 *
 * @param provider      The {@link android.content.ComponentName ComponentName} for the {@link
 * android.content.BroadcastReceiver BroadcastReceiver} provider
 *                      for your AppWidget.
 * @param views         The RemoteViews object to show.
 * @apiSince 3
 */

public void updateAppWidget(android.content.ComponentName provider, android.widget.RemoteViews views) { throw new RuntimeException("Stub!"); }

/**
 * Updates the info for the supplied AppWidget provider. Apps can use this to change the default
 * behavior of the widget based on the state of the app (for e.g., if the user is logged in
 * or not). Calling this API completely replaces the previous definition.
 *
 * <p>
 * The manifest entry of the provider should contain an additional meta-data tag similar to
 * {@link #META_DATA_APPWIDGET_PROVIDER} which should point to any alternative definitions for
 * the provider.
 *
 * <p>
 * This is persisted across device reboots and app updates. If this meta-data key is not
 * present in the manifest entry, the info reverts to default.
 *
 * @param provider {@link android.content.ComponentName ComponentName} for the {@link
 *    android.content.BroadcastReceiver BroadcastReceiver} provider for your AppWidget.
 * @param metaDataKey key for the meta-data tag pointing to the new provider info. Use null
 *    to reset any previously set info.
 
 * This value may be {@code null}.
 * @apiSince 28
 */

public void updateAppWidgetProviderInfo(android.content.ComponentName provider, @androidx.annotation.Nullable java.lang.String metaDataKey) { throw new RuntimeException("Stub!"); }

/**
 * Notifies the specified collection view in all the specified AppWidget instances
 * to invalidate their data.
 *
 * @param appWidgetIds  The AppWidget instances to notify of view data changes.
 * @param viewId        The collection view id.
 * @apiSince 11
 */

public void notifyAppWidgetViewDataChanged(int[] appWidgetIds, int viewId) { throw new RuntimeException("Stub!"); }

/**
 * Notifies the specified collection view in the specified AppWidget instance
 * to invalidate its data.
 *
 * @param appWidgetId  The AppWidget instance to notify of view data changes.
 * @param viewId       The collection view id.
 * @apiSince 11
 */

public void notifyAppWidgetViewDataChanged(int appWidgetId, int viewId) { throw new RuntimeException("Stub!"); }

/**
 * Gets the AppWidget providers for the given user profile. User profile can only
 * be the current user or a profile of the current user. For example, the current
 * user may have a corporate profile. In this case the parent user profile has a
 * child profile, the corporate one.
 *
 * @param profile The profile for which to get providers. Passing null is equivalent
 *        to querying for only the calling user.
 * This value may be {@code null}.
 * @return The installed providers, or an empty list if none are found for the given user.
 *
 * @see android.os.Process#myUserHandle()
 * @see android.os.UserManager#getUserProfiles()
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.util.List<android.appwidget.AppWidgetProviderInfo> getInstalledProvidersForProfile(@androidx.annotation.Nullable android.os.UserHandle profile) { throw new RuntimeException("Stub!"); }

/**
 * Gets the AppWidget providers for the given package and user profile. User
 * profile can only be the current user or a profile of the current user. For
 * example, the current user may have a corporate profile. In this case the
 * parent user profile has a child profile, the corporate one.
 *
 * @param packageName The package for which to get providers. If null, this method is
 *        equivalent to {@link #getInstalledProvidersForProfile(android.os.UserHandle)}.
 * This value must never be {@code null}.
 * @param profile The profile for which to get providers. Passing null is equivalent
 *        to querying for only the calling user.
 * This value may be {@code null}.
 * @return The installed providers, or an empty list if none are found for the given
 *         package and user.
 * @throws java.lang.NullPointerException if the provided package name is null
 *
 * @see android.os.Process#myUserHandle()
 * @see android.os.UserManager#getUserProfiles()
 * @apiSince 26
 */

@androidx.annotation.NonNull
public java.util.List<android.appwidget.AppWidgetProviderInfo> getInstalledProvidersForPackage(@androidx.annotation.NonNull java.lang.String packageName, @androidx.annotation.Nullable android.os.UserHandle profile) { throw new RuntimeException("Stub!"); }

/**
 * Return a list of the AppWidget providers that are currently installed.
 * @apiSince 3
 */

public java.util.List<android.appwidget.AppWidgetProviderInfo> getInstalledProviders() { throw new RuntimeException("Stub!"); }

/**
 * Get the available info about the AppWidget.
 *
 * @return A appWidgetId.  If the appWidgetId has not been bound to a provider yet, or
 * you don't have access to that appWidgetId, null is returned.
 * @apiSince 3
 */

public android.appwidget.AppWidgetProviderInfo getAppWidgetInfo(int appWidgetId) { throw new RuntimeException("Stub!"); }

/**
 * Set the component for a given appWidgetId.
 *
 * <p class="note">You need the BIND_APPWIDGET permission or the user must have enabled binding
 *         widgets always for your component. Should be used by apps that host widgets; if this
 *         method returns false, call {@link #ACTION_APPWIDGET_BIND} to request permission to
 *         bind
 *
 * @param appWidgetId   The AppWidget id under which to bind the provider.
 * @param provider      The {@link android.content.BroadcastReceiver} that will be the AppWidget
 *                      provider for this AppWidget.
 * @return true if this component has permission to bind the AppWidget
 * @apiSince 16
 */

public boolean bindAppWidgetIdIfAllowed(int appWidgetId, android.content.ComponentName provider) { throw new RuntimeException("Stub!"); }

/**
 * Set the component for a given appWidgetId.
 *
 * <p class="note">You need the BIND_APPWIDGET permission or the user must have enabled binding
 *         widgets always for your component. Should be used by apps that host widgets; if this
 *         method returns false, call {@link #ACTION_APPWIDGET_BIND} to request permission to
 *         bind
 *
 * @param appWidgetId The AppWidget id under which to bind the provider.
 * @param provider      The {@link android.content.BroadcastReceiver} that will be the AppWidget
 *                      provider for this AppWidget.
 * @param options       Bundle containing options for the AppWidget. See also
 *                      {@link #updateAppWidgetOptions(int,android.os.Bundle)}
 *
 * @return true if this component has permission to bind the AppWidget
 * @apiSince 17
 */

public boolean bindAppWidgetIdIfAllowed(int appWidgetId, android.content.ComponentName provider, android.os.Bundle options) { throw new RuntimeException("Stub!"); }

/**
 * Set the provider for a given appWidgetId if the caller has a permission.
 * <p>
 * <strong>Note:</strong> You need the {@link android.Manifest.permission#BIND_APPWIDGET}
 * permission or the user must have enabled binding widgets always for your component.
 * Should be used by apps that host widgets. If this method returns false, call {@link
 * #ACTION_APPWIDGET_BIND} to request permission to bind.
 * </p>
 *
 * @param appWidgetId The AppWidget id under which to bind the provider.
 * @param user The user id in which the provider resides.
 * @param provider The component name of the provider.
 * @param options An optional Bundle containing options for the AppWidget.
 *
 * @return true if this component has permission to bind the AppWidget
 * @apiSince 21
 */

public boolean bindAppWidgetIdIfAllowed(int appWidgetId, android.os.UserHandle user, android.content.ComponentName provider, android.os.Bundle options) { throw new RuntimeException("Stub!"); }

/**
 * Get the list of appWidgetIds that have been bound to the given AppWidget
 * provider.
 *
 * @param provider The {@link android.content.BroadcastReceiver} that is the
 *            AppWidget provider to find appWidgetIds for.
 * @apiSince 3
 */

public int[] getAppWidgetIds(android.content.ComponentName provider) { throw new RuntimeException("Stub!"); }

/**
 * Return {@code TRUE} if the default launcher supports
 * {@link #requestPinAppWidget(android.content.ComponentName,android.os.Bundle,android.app.PendingIntent)}
 * @apiSince 26
 */

public boolean isRequestPinAppWidgetSupported() { throw new RuntimeException("Stub!"); }

/**
 * Request to pin an app widget on the current launcher. It's up to the launcher to accept this
 * request (optionally showing a user confirmation). If the request is accepted, the caller will
 * get a confirmation with extra {@link #EXTRA_APPWIDGET_ID}.
 *
 * <p>When a request is denied by the user, the caller app will not get any response.
 *
 * <p>Only apps with a foreground activity or a foreground service can call it.  Otherwise
 * it'll throw {@link java.lang.IllegalStateException IllegalStateException}.
 *
 * <p>It's up to the launcher how to handle previous pending requests when the same package
 * calls this API multiple times in a row.  It may ignore the previous requests,
 * for example.
 *
 * <p>Launcher will not show the configuration activity associated with the provider in this
 * case. The app could either show the configuration activity as a response to the callback,
 * or show if before calling the API (various configurations can be encapsulated in
 * {@code successCallback} to avoid persisting them before the widgetId is known).
 *
 * @param provider The {@link android.content.ComponentName ComponentName} for the {@link
 *    android.content.BroadcastReceiver BroadcastReceiver} provider for your AppWidget.
 * This value must never be {@code null}.
 * @param extras In not null, this is passed to the launcher app. For eg {@link
 *    #EXTRA_APPWIDGET_PREVIEW} can be used for a custom preview.
 * This value may be {@code null}.
 * @param successCallback If not null, this intent will be sent when the widget is created.
 *
 * This value may be {@code null}.
 * @return {@code TRUE} if the launcher supports this feature. Note the API will return without
 *    waiting for the user to respond, so getting {@code TRUE} from this API does *not* mean
 *    the shortcut is pinned. {@code FALSE} if the launcher doesn't support this feature.
 *
 * @see android.content.pm.ShortcutManager#isRequestPinShortcutSupported()
 * @see android.content.pm.ShortcutManager#requestPinShortcut(ShortcutInfo, IntentSender)
 * @see #isRequestPinAppWidgetSupported()
 *
 * @throws java.lang.IllegalStateException The caller doesn't have a foreground activity or a foreground
 * service or when the user is locked.
 * @apiSince 26
 */

public boolean requestPinAppWidget(@androidx.annotation.NonNull android.content.ComponentName provider, @androidx.annotation.Nullable android.os.Bundle extras, @androidx.annotation.Nullable android.app.PendingIntent successCallback) { throw new RuntimeException("Stub!"); }

/**
 * Activity action to launch from your {@link android.appwidget.AppWidgetHost AppWidgetHost} activity when you want to bind
 * an AppWidget to display and bindAppWidgetIdIfAllowed returns false.
 * <p>
 * You must supply the following extras:
 * <table>
 *   <tr>
 *     <td>{@link #EXTRA_APPWIDGET_ID}</td>
 *     <td>A newly allocated appWidgetId, which will be bound to the AppWidget provider
 *         you provide.</td>
 *  </tr>
 *  <tr>
 *     <td>{@link #EXTRA_APPWIDGET_PROVIDER}</td>
 *     <td>The BroadcastReceiver that will be the AppWidget provider for this AppWidget.
 *     </td>
 *  </tr>
 *  <tr>
 *     <td>{@link #EXTRA_APPWIDGET_PROVIDER_PROFILE}</td>
 *     <td>An optional handle to a user profile under which runs the provider
 *     for this AppWidget.
 *     </td>
 *  </tr>
 * </table>
 *
 * <p>
 * The system will respond with an onActivityResult call with the following extras in
 * the intent:
 * <table>
 *   <tr>
 *     <td>{@link #EXTRA_APPWIDGET_ID}</td>
 *     <td>The appWidgetId that you supplied in the original intent.</td>
 *  </tr>
 * </table>
 * <p>
 * When you receive the result from the AppWidget bind activity, if the resultCode is
 * {@link android.app.Activity#RESULT_OK}, the AppWidget has been bound.  You should then
 * check the AppWidgetProviderInfo for the returned AppWidget, and if it has one, launch its
 * configuration activity.  If {@link android.app.Activity#RESULT_CANCELED} is returned, you
 * should delete the appWidgetId.
 *
 * @see #ACTION_APPWIDGET_CONFIGURE
 *
 * @apiSince 16
 */

public static final java.lang.String ACTION_APPWIDGET_BIND = "android.appwidget.action.APPWIDGET_BIND";

/**
 * Sent when it is time to configure your AppWidget while it is being added to a host.
 * This action is not sent as a broadcast to the AppWidget provider, but as a startActivity
 * to the activity specified in the {@link android.appwidget.AppWidgetProviderInfo AppWidgetProviderInfo}.
 *
 * <p>
 * The intent will contain the following extras:
 * <table>
 *   <tr>
 *     <td>{@link #EXTRA_APPWIDGET_ID}</td>
 *     <td>The appWidgetId to configure.</td>
 *  </tr>
 * </table>
 *
 * <p>If you return {@link android.app.Activity#RESULT_OK} using
 * {@link android.app.Activity#setResult Activity.setResult()}, the AppWidget will be added,
 * and you will receive an {@link #ACTION_APPWIDGET_UPDATE} broadcast for this AppWidget.
 * If you return {@link android.app.Activity#RESULT_CANCELED}, the host will cancel the add
 * and not display this AppWidget, and you will receive a {@link #ACTION_APPWIDGET_DELETED}
 * broadcast.
 * @apiSince 3
 */

public static final java.lang.String ACTION_APPWIDGET_CONFIGURE = "android.appwidget.action.APPWIDGET_CONFIGURE";

/**
 * Sent when an instance of an AppWidget is deleted from its host.
 *
 * <p class="note">This is a protected intent that can only be sent
 * by the system.
 *
 * @see android.appwidget.AppWidgetProvider#onDeleted AppWidgetProvider.onDeleted(Context context, int[] appWidgetIds)
 * @apiSince 3
 */

public static final java.lang.String ACTION_APPWIDGET_DELETED = "android.appwidget.action.APPWIDGET_DELETED";

/**
 * Sent when the last AppWidget of this provider is removed from the last host.
 *
 * <p class="note">This is a protected intent that can only be sent
 * by the system.
 *
 * @see android.appwidget.AppWidgetProvider#onEnabled AppWidgetProvider.onDisabled(Context context)
 * @apiSince 3
 */

public static final java.lang.String ACTION_APPWIDGET_DISABLED = "android.appwidget.action.APPWIDGET_DISABLED";

/**
 * Sent when an instance of an AppWidget is added to a host for the first time.
 * This broadcast is sent at boot time if there is a AppWidgetHost installed with
 * an instance for this provider.
 *
 * <p class="note">This is a protected intent that can only be sent
 * by the system.
 *
 * @see android.appwidget.AppWidgetProvider#onEnabled AppWidgetProvider.onEnabled(Context context)
 * @apiSince 3
 */

public static final java.lang.String ACTION_APPWIDGET_ENABLED = "android.appwidget.action.APPWIDGET_ENABLED";

/**
 * Sent to widget hosts after AppWidget state related to the host has been restored from
 * backup. The intent contains information about how to translate AppWidget ids from the
 * restored data to their new equivalents.  If an application maintains multiple separate
 * widget host instances, it will receive this broadcast separately for each one.
 *
 * <p>The intent will contain the following extras:
 *
 * <table>
 *   <tr>
 *     <td>{@link #EXTRA_APPWIDGET_OLD_IDS}</td>
 *     <td>The set of appWidgetIds represented in a restored backup that have been successfully
 *     incorporated into the current environment.  This may be all of the AppWidgets known
 *     to this application, or just a subset.  Each entry in this array of appWidgetIds has
 *     a corresponding entry in the {@link #EXTRA_APPWIDGET_IDS} extra.</td>
 *  </tr>
 *   <tr>
 *     <td>{@link #EXTRA_APPWIDGET_IDS}</td>
 *     <td>The set of appWidgetIds now valid for this application.  The app should look at
 *     its restored widget configuration and translate each appWidgetId in the
 *     {@link #EXTRA_APPWIDGET_OLD_IDS} array to its new value found at the corresponding
 *     index within this array.</td>
 *  </tr>
 *  <tr>
 *     <td>{@link #EXTRA_HOST_ID}</td>
 *     <td>The integer ID of the widget host instance whose state has just been restored.</td>
 *  </tr>
 * </table>
 *
 * <p class="note">This is a protected intent that can only be sent
 * by the system.
 *
 * @see #ACTION_APPWIDGET_RESTORED
 * @apiSince 21
 */

public static final java.lang.String ACTION_APPWIDGET_HOST_RESTORED = "android.appwidget.action.APPWIDGET_HOST_RESTORED";

/**
 * Sent when the custom extras for an AppWidget change.
 *
 * <p class="note">This is a protected intent that can only be sent
 * by the system.
 *
 * @see android.appwidget.AppWidgetProvider#onAppWidgetOptionsChanged
 *      AppWidgetProvider.onAppWidgetOptionsChanged(Context context,
 *      AppWidgetManager appWidgetManager, int appWidgetId, Bundle newExtras)
 * @apiSince 16
 */

public static final java.lang.String ACTION_APPWIDGET_OPTIONS_CHANGED = "android.appwidget.action.APPWIDGET_UPDATE_OPTIONS";

/**
 * Activity action to launch from your {@link android.appwidget.AppWidgetHost AppWidgetHost} activity when you want to
 * pick an AppWidget to display.  The AppWidget picker activity will be launched.
 * <p>
 * You must supply the following extras:
 * <table>
 *   <tr>
 *     <td>{@link #EXTRA_APPWIDGET_ID}</td>
 *     <td>A newly allocated appWidgetId, which will be bound to the AppWidget provider
 *         once the user has selected one.</td>
 *  </tr>
 * </table>
 *
 * <p>
 * The system will respond with an onActivityResult call with the following extras in
 * the intent:
 * <table>
 *   <tr>
 *     <td>{@link #EXTRA_APPWIDGET_ID}</td>
 *     <td>The appWidgetId that you supplied in the original intent.</td>
 *  </tr>
 * </table>
 * <p>
 * When you receive the result from the AppWidget pick activity, if the resultCode is
 * {@link android.app.Activity#RESULT_OK}, an AppWidget has been selected.  You should then
 * check the AppWidgetProviderInfo for the returned AppWidget, and if it has one, launch its
 * configuration activity.  If {@link android.app.Activity#RESULT_CANCELED} is returned, you
 * should delete the appWidgetId.
 *
 * @see #ACTION_APPWIDGET_CONFIGURE
 * @apiSince 3
 */

public static final java.lang.String ACTION_APPWIDGET_PICK = "android.appwidget.action.APPWIDGET_PICK";

/**
 * Sent to an {@link android.appwidget.AppWidgetProvider AppWidgetProvider} after AppWidget state related to that provider has
 * been restored from backup. The intent contains information about how to translate AppWidget
 * ids from the restored data to their new equivalents.
 *
 * <p>The intent will contain the following extras:
 *
 * <table>
 *   <tr>
 *     <td>{@link #EXTRA_APPWIDGET_OLD_IDS}</td>
 *     <td>The set of appWidgetIds represented in a restored backup that have been successfully
 *     incorporated into the current environment.  This may be all of the AppWidgets known
 *     to this application, or just a subset.  Each entry in this array of appWidgetIds has
 *     a corresponding entry in the {@link #EXTRA_APPWIDGET_IDS} extra.</td>
 *  </tr>
 *   <tr>
 *     <td>{@link #EXTRA_APPWIDGET_IDS}</td>
 *     <td>The set of appWidgetIds now valid for this application.  The app should look at
 *     its restored widget configuration and translate each appWidgetId in the
 *     {@link #EXTRA_APPWIDGET_OLD_IDS} array to its new value found at the corresponding
 *     index within this array.</td>
 *  </tr>
 * </table>
 *
 * <p class="note">This is a protected intent that can only be sent
 * by the system.
 *
 * @see #ACTION_APPWIDGET_HOST_RESTORED
 * @apiSince 21
 */

public static final java.lang.String ACTION_APPWIDGET_RESTORED = "android.appwidget.action.APPWIDGET_RESTORED";

/**
 * Sent when it is time to update your AppWidget.
 *
 * <p>This may be sent in response to a new instance for this AppWidget provider having
 * been instantiated, the requested {@link android.appwidget.AppWidgetProviderInfo#updatePeriodMillis AppWidgetProviderInfo#updatePeriodMillis}
 * having lapsed, or the system booting.
 *
 * <p>
 * The intent will contain the following extras:
 * <table>
 *   <tr>
 *     <td>{@link #EXTRA_APPWIDGET_IDS}</td>
 *     <td>The appWidgetIds to update.  This may be all of the AppWidgets created for this
 *     provider, or just a subset.  The system tries to send updates for as few AppWidget
 *     instances as possible.</td>
 *  </tr>
 * </table>
 *
 * @see android.appwidget.AppWidgetProvider#onUpdate AppWidgetProvider.onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds)
 * @apiSince 3
 */

public static final java.lang.String ACTION_APPWIDGET_UPDATE = "android.appwidget.action.APPWIDGET_UPDATE";

/**
 * An intent extra that contains one appWidgetId.
 * <p>
 * The value will be an int that can be retrieved like this:
 * {@sample frameworks/base/tests/appwidgets/AppWidgetHostTest/src/com/android/tests/appwidgethost/AppWidgetHostActivity.java getExtra_EXTRA_APPWIDGET_ID}
 * @apiSince 3
 */

public static final java.lang.String EXTRA_APPWIDGET_ID = "appWidgetId";

/**
 * An intent extra that contains multiple appWidgetIds.
 * <p>
 * The value will be an int array that can be retrieved like this:
 * {@sample frameworks/base/tests/appwidgets/AppWidgetHostTest/src/com/android/tests/appwidgethost/TestAppWidgetProvider.java getExtra_EXTRA_APPWIDGET_IDS}
 * @apiSince 3
 */

public static final java.lang.String EXTRA_APPWIDGET_IDS = "appWidgetIds";

/**
 * An intent extra that contains multiple appWidgetIds.  These are id values as
 * they were provided to the application during a recent restore from backup.  It is
 * attached to the {@link #ACTION_APPWIDGET_RESTORED} broadcast intent.
 *
 * <p>
 * The value will be an int array that can be retrieved like this:
 * {@sample frameworks/base/tests/appwidgets/AppWidgetHostTest/src/com/android/tests/appwidgethost/TestAppWidgetProvider.java getExtra_EXTRA_APPWIDGET_IDS}
 * @apiSince 21
 */

public static final java.lang.String EXTRA_APPWIDGET_OLD_IDS = "appWidgetOldIds";

/**
 * An intent extra which points to a bundle of extra information for a particular widget id.
 * In particular this bundle can contain {@link #OPTION_APPWIDGET_MIN_WIDTH},
 * {@link #OPTION_APPWIDGET_MIN_HEIGHT}, {@link #OPTION_APPWIDGET_MAX_WIDTH},
 * {@link #OPTION_APPWIDGET_MAX_HEIGHT}.
 * @apiSince 16
 */

public static final java.lang.String EXTRA_APPWIDGET_OPTIONS = "appWidgetOptions";

/**
 * An extra that can be passed to
 * {@link #requestPinAppWidget(android.content.ComponentName,android.os.Bundle,android.app.PendingIntent)}. This would allow the
 * launcher app to present a custom preview to the user.
 *
 * <p>
 * The value should be a {@link android.widget.RemoteViews RemoteViews} similar to what is used with
 * {@link #updateAppWidget} calls.
 * @apiSince 26
 */

public static final java.lang.String EXTRA_APPWIDGET_PREVIEW = "appWidgetPreview";

/**
 * An intent extra that contains the component name of a AppWidget provider.
 * <p>
 * The value will be an {@link android.content.ComponentName}.
 * @apiSince 16
 */

public static final java.lang.String EXTRA_APPWIDGET_PROVIDER = "appWidgetProvider";

/**
 * An intent extra that contains the user handle of the profile under
 * which an AppWidget provider is registered.
 * <p>
 * The value will be a {@link android.os.UserHandle}.
 * @apiSince 21
 */

public static final java.lang.String EXTRA_APPWIDGET_PROVIDER_PROFILE = "appWidgetProviderProfile";

/**
 * An intent extra to pass to the AppWidget picker containing a {@link java.util.List} of
 * {@link android.os.Bundle} objects to mix in to the list of AppWidgets that are
 * installed.  It will be added to the extras object on the {@link android.content.Intent}
 * that is returned from the picker activity.
 *
 * {@more}
 * @apiSince 3
 */

public static final java.lang.String EXTRA_CUSTOM_EXTRAS = "customExtras";

/**
 * An intent extra to pass to the AppWidget picker containing a {@link java.util.List} of
 * {@link android.appwidget.AppWidgetProviderInfo AppWidgetProviderInfo} objects to mix in to the list of AppWidgets that are
 * installed.  (This is how the launcher shows the search widget).
 * @apiSince 3
 */

public static final java.lang.String EXTRA_CUSTOM_INFO = "customInfo";

/**
 * An intent extra attached to the {@link #ACTION_APPWIDGET_HOST_RESTORED} broadcast,
 * indicating the integer ID of the host whose widgets have just been restored.
 * @apiSince 21
 */

public static final java.lang.String EXTRA_HOST_ID = "hostId";

/**
 * A sentinel value that the AppWidget manager will never return as a appWidgetId.
 * @apiSince 3
 */

public static final int INVALID_APPWIDGET_ID = 0; // 0x0

/**
 * Field for the manifest meta-data tag.
 *
 * @see android.appwidget.AppWidgetProviderInfo
 * @apiSince 3
 */

public static final java.lang.String META_DATA_APPWIDGET_PROVIDER = "android.appwidget.provider";

/**
 * A bundle extra that hints to the AppWidgetProvider the category of host that owns this
 * this widget. Can have the value {@link android.appwidget.AppWidgetProviderInfo#WIDGET_CATEGORY_HOME_SCREEN AppWidgetProviderInfo#WIDGET_CATEGORY_HOME_SCREEN} or {@link android.appwidget.AppWidgetProviderInfo#WIDGET_CATEGORY_KEYGUARD AppWidgetProviderInfo#WIDGET_CATEGORY_KEYGUARD} or {@link android.appwidget.AppWidgetProviderInfo#WIDGET_CATEGORY_SEARCHBOX AppWidgetProviderInfo#WIDGET_CATEGORY_SEARCHBOX}.
 * @apiSince 17
 */

public static final java.lang.String OPTION_APPWIDGET_HOST_CATEGORY = "appWidgetCategory";

/**
 * A bundle extra that contains the upper bound on the current width, in dips, of a widget instance.
 * @apiSince 16
 */

public static final java.lang.String OPTION_APPWIDGET_MAX_HEIGHT = "appWidgetMaxHeight";

/**
 * A bundle extra that contains the upper bound on the current width, in dips, of a widget instance.
 * @apiSince 16
 */

public static final java.lang.String OPTION_APPWIDGET_MAX_WIDTH = "appWidgetMaxWidth";

/**
 * A bundle extra that contains the lower bound on the current height, in dips, of a widget instance.
 * @apiSince 16
 */

public static final java.lang.String OPTION_APPWIDGET_MIN_HEIGHT = "appWidgetMinHeight";

/**
 * A bundle extra that contains the lower bound on the current width, in dips, of a widget instance.
 * @apiSince 16
 */

public static final java.lang.String OPTION_APPWIDGET_MIN_WIDTH = "appWidgetMinWidth";
}

