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

import android.content.Context;
import android.content.Intent;
import android.content.BroadcastReceiver;

/**
 * A convenience class to aid in implementing an AppWidget provider.
 * Everything you can do with AppWidgetProvider, you can do with a regular {@link android.content.BroadcastReceiver BroadcastReceiver}.
 * AppWidgetProvider merely parses the relevant fields out of the Intent that is received in
 * {@link #onReceive(android.content.Context,android.content.Intent) onReceive(Context,Intent)}, and calls hook methods
 * with the received extras.
 *
 * <p>Extend this class and override one or more of the {@link #onUpdate}, {@link #onDeleted},
 * {@link #onEnabled} or {@link #onDisabled} methods to implement your own AppWidget functionality.
 * </p>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about how to write an app widget provider, read the
 * <a href="{@docRoot}guide/topics/appwidgets/index.html#AppWidgetProvider">App Widgets</a>
 * developer guide.</p>
 * </div>
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AppWidgetProvider extends android.content.BroadcastReceiver {

/**
 * Constructor to initialize AppWidgetProvider.
 * @apiSince 3
 */

public AppWidgetProvider() { throw new RuntimeException("Stub!"); }

/**
 * Implements {@link android.content.BroadcastReceiver#onReceive BroadcastReceiver#onReceive} to dispatch calls to the various
 * other methods on AppWidgetProvider.
 *
 * @param context The Context in which the receiver is running.
 * @param intent The Intent being received.
 * @apiSince 3
 */

public void onReceive(android.content.Context context, android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Called in response to the {@link android.appwidget.AppWidgetManager#ACTION_APPWIDGET_UPDATE AppWidgetManager#ACTION_APPWIDGET_UPDATE} and
 * {@link android.appwidget.AppWidgetManager#ACTION_APPWIDGET_RESTORED AppWidgetManager#ACTION_APPWIDGET_RESTORED} broadcasts when this AppWidget
 * provider is being asked to provide {@link android.widget.RemoteViews RemoteViews}
 * for a set of AppWidgets.  Override this method to implement your own AppWidget functionality.
 *
 * {@more}
 *
 * @param context   The {@link android.content.Context Context} in which this receiver is
 *                  running.
 * @param appWidgetManager A {@link android.appwidget.AppWidgetManager AppWidgetManager} object you can call {@link android.appwidget.AppWidgetManager#updateAppWidget AppWidgetManager#updateAppWidget} on.
 * @param appWidgetIds The appWidgetIds for which an update is needed.  Note that this
 *                  may be all of the AppWidget instances for this provider, or just
 *                  a subset of them.
 *
 * @see android.appwidget.AppWidgetManager#ACTION_APPWIDGET_UPDATE
 * @apiSince 3
 */

public void onUpdate(android.content.Context context, android.appwidget.AppWidgetManager appWidgetManager, int[] appWidgetIds) { throw new RuntimeException("Stub!"); }

/**
 * Called in response to the {@link android.appwidget.AppWidgetManager#ACTION_APPWIDGET_OPTIONS_CHANGED AppWidgetManager#ACTION_APPWIDGET_OPTIONS_CHANGED}
 * broadcast when this widget has been layed out at a new size.
 *
 * {@more}
 *
 * @param context   The {@link android.content.Context Context} in which this receiver is
 *                  running.
 * @param appWidgetManager A {@link android.appwidget.AppWidgetManager AppWidgetManager} object you can call {@link android.appwidget.AppWidgetManager#updateAppWidget AppWidgetManager#updateAppWidget} on.
 * @param appWidgetId The appWidgetId of the widget whose size changed.
 * @param newOptions The appWidgetId of the widget whose size changed.
 *
 * @see android.appwidget.AppWidgetManager#ACTION_APPWIDGET_OPTIONS_CHANGED
 * @apiSince 16
 */

public void onAppWidgetOptionsChanged(android.content.Context context, android.appwidget.AppWidgetManager appWidgetManager, int appWidgetId, android.os.Bundle newOptions) { throw new RuntimeException("Stub!"); }

/**
 * Called in response to the {@link android.appwidget.AppWidgetManager#ACTION_APPWIDGET_DELETED AppWidgetManager#ACTION_APPWIDGET_DELETED} broadcast when
 * one or more AppWidget instances have been deleted.  Override this method to implement
 * your own AppWidget functionality.
 *
 * {@more}
 *
 * @param context   The {@link android.content.Context Context} in which this receiver is
 *                  running.
 * @param appWidgetIds The appWidgetIds that have been deleted from their host.
 *
 * @see android.appwidget.AppWidgetManager#ACTION_APPWIDGET_DELETED
 * @apiSince 3
 */

public void onDeleted(android.content.Context context, int[] appWidgetIds) { throw new RuntimeException("Stub!"); }

/**
 * Called in response to the {@link android.appwidget.AppWidgetManager#ACTION_APPWIDGET_ENABLED AppWidgetManager#ACTION_APPWIDGET_ENABLED} broadcast when
 * the a AppWidget for this provider is instantiated.  Override this method to implement your
 * own AppWidget functionality.
 *
 * {@more}
 * When the last AppWidget for this provider is deleted,
 * {@link android.appwidget.AppWidgetManager#ACTION_APPWIDGET_DISABLED AppWidgetManager#ACTION_APPWIDGET_DISABLED} is sent by the AppWidget manager, and
 * {@link #onDisabled} is called.  If after that, an AppWidget for this provider is created
 * again, onEnabled() will be called again.
 *
 * @param context   The {@link android.content.Context Context} in which this receiver is
 *                  running.
 *
 * @see android.appwidget.AppWidgetManager#ACTION_APPWIDGET_ENABLED
 * @apiSince 3
 */

public void onEnabled(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Called in response to the {@link android.appwidget.AppWidgetManager#ACTION_APPWIDGET_DISABLED AppWidgetManager#ACTION_APPWIDGET_DISABLED} broadcast, which
 * is sent when the last AppWidget instance for this provider is deleted.  Override this method
 * to implement your own AppWidget functionality.
 *
 * {@more}
 *
 * @param context   The {@link android.content.Context Context} in which this receiver is
 *                  running.
 *
 * @see android.appwidget.AppWidgetManager#ACTION_APPWIDGET_DISABLED
 * @apiSince 3
 */

public void onDisabled(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Called in response to the {@link android.appwidget.AppWidgetManager#ACTION_APPWIDGET_RESTORED AppWidgetManager#ACTION_APPWIDGET_RESTORED} broadcast
 * when instances of this AppWidget provider have been restored from backup.  If your
 * provider maintains any persistent data about its widget instances, override this method
 * to remap the old AppWidgetIds to the new values and update any other app state that may
 * be relevant.
 *
 * <p>This callback will be followed immediately by a call to {@link #onUpdate} so your
 * provider can immediately generate new RemoteViews suitable for its newly-restored set
 * of instances.
 *
 * {@more}
 *
 * @param context
 * @param oldWidgetIds
 * @param newWidgetIds
 * @apiSince 21
 */

public void onRestored(android.content.Context context, int[] oldWidgetIds, int[] newWidgetIds) { throw new RuntimeException("Stub!"); }
}

