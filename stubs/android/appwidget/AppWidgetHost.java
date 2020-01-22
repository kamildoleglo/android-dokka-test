/*
 * Copyright (C) 2009 The Android Open Source Project
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

import android.app.Activity;
import android.content.ActivityNotFoundException;

/**
 * AppWidgetHost provides the interaction with the AppWidget service for apps,
 * like the home screen, that want to embed AppWidgets in their UI.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AppWidgetHost {

/** @apiSince 3 */

public AppWidgetHost(android.content.Context context, int hostId) { throw new RuntimeException("Stub!"); }

/**
 * Start receiving onAppWidgetChanged calls for your AppWidgets.  Call this when your activity
 * becomes visible, i.e. from onStart() in your Activity.
 * @apiSince 3
 */

public void startListening() { throw new RuntimeException("Stub!"); }

/**
 * Stop receiving onAppWidgetChanged calls for your AppWidgets.  Call this when your activity is
 * no longer visible, i.e. from onStop() in your Activity.
 * @apiSince 3
 */

public void stopListening() { throw new RuntimeException("Stub!"); }

/**
 * Get a appWidgetId for a host in the calling process.
 *
 * @return a appWidgetId
 * @apiSince 3
 */

public int allocateAppWidgetId() { throw new RuntimeException("Stub!"); }

/**
 * Starts an app widget provider configure activity for result on behalf of the caller.
 * Use this method if the provider is in another profile as you are not allowed to start
 * an activity in another profile. You can optionally provide a request code that is
 * returned in {@link android.app.Activity#onActivityResult(int,int,android.content.Intent) Activity#onActivityResult(int, int, android.content.Intent)} and
 * an options bundle to be passed to the started activity.
 * <p>
 * Note that the provided app widget has to be bound for this method to work.
 * </p>
 *
 * @param activity The activity from which to start the configure one.
 * This value must never be {@code null}.
 * @param appWidgetId The bound app widget whose provider's config activity to start.
 * @param requestCode Optional request code retuned with the result.
 * @param intentFlags Optional intent flags.
 *
 * @throws android.content.ActivityNotFoundException If the activity is not found.
 *
 * @see android.appwidget.AppWidgetProviderInfo#getProfile()
 
 * @param options This value may be {@code null}.
 * @apiSince 21
 */

public final void startAppWidgetConfigureActivityForResult(@androidx.annotation.NonNull android.app.Activity activity, int appWidgetId, int intentFlags, int requestCode, @androidx.annotation.Nullable android.os.Bundle options) { throw new RuntimeException("Stub!"); }

/**
 * Gets a list of all the appWidgetIds that are bound to the current host
 * @apiSince 26
 */

public int[] getAppWidgetIds() { throw new RuntimeException("Stub!"); }

/**
 * Stop listening to changes for this AppWidget.
 * @apiSince 3
 */

public void deleteAppWidgetId(int appWidgetId) { throw new RuntimeException("Stub!"); }

/**
 * Remove all records about this host from the AppWidget manager.
 * <ul>
 *   <li>Call this when initializing your database, as it might be because of a data wipe.</li>
 *   <li>Call this to have the AppWidget manager release all resources associated with your
 *   host.  Any future calls about this host will cause the records to be re-allocated.</li>
 * </ul>
 * @apiSince 3
 */

public void deleteHost() { throw new RuntimeException("Stub!"); }

/**
 * Remove all records about all hosts for your package.
 * <ul>
 *   <li>Call this when initializing your database, as it might be because of a data wipe.</li>
 *   <li>Call this to have the AppWidget manager release all resources associated with your
 *   host.  Any future calls about this host will cause the records to be re-allocated.</li>
 * </ul>
 * @apiSince 3
 */

public static void deleteAllHosts() { throw new RuntimeException("Stub!"); }

/**
 * Create the AppWidgetHostView for the given widget.
 * The AppWidgetHost retains a pointer to the newly-created View.
 * @apiSince 3
 */

public final android.appwidget.AppWidgetHostView createView(android.content.Context context, int appWidgetId, android.appwidget.AppWidgetProviderInfo appWidget) { throw new RuntimeException("Stub!"); }

/**
 * Called to create the AppWidgetHostView.  Override to return a custom subclass if you
 * need it.  {@more}
 * @apiSince 3
 */

protected android.appwidget.AppWidgetHostView onCreateView(android.content.Context context, int appWidgetId, android.appwidget.AppWidgetProviderInfo appWidget) { throw new RuntimeException("Stub!"); }

/**
 * Called when the AppWidget provider for a AppWidget has been upgraded to a new apk.
 * @apiSince 3
 */

protected void onProviderChanged(int appWidgetId, android.appwidget.AppWidgetProviderInfo appWidget) { throw new RuntimeException("Stub!"); }

/**
 * Called when the set of available widgets changes (ie. widget containing packages
 * are added, updated or removed, or widget components are enabled or disabled.)
 * @apiSince 17
 */

protected void onProvidersChanged() { throw new RuntimeException("Stub!"); }

/**
 * Clear the list of Views that have been created by this AppWidgetHost.
 * @apiSince 11
 */

protected void clearViews() { throw new RuntimeException("Stub!"); }
}

