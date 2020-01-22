/*
 * Copyright (C) 2008 The Android Open Source Project
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

import android.widget.RemoteViews;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.widget.FrameLayout;

/**
 * Provides the glue to show AppWidget views. This class offers automatic animation
 * between updates, and will try recycling old views for each incoming
 * {@link android.widget.RemoteViews RemoteViews}.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AppWidgetHostView extends android.widget.FrameLayout {

/**
 * Create a host view.  Uses default fade animations.
 * @apiSince 3
 */

public AppWidgetHostView(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Create a host view. Uses specified animations when pushing
 * {@link #updateAppWidget(android.widget.RemoteViews)}.
 *
 * @param animationIn Resource ID of in animation to use
 * @param animationOut Resource ID of out animation to use
 * @apiSince 3
 */

public AppWidgetHostView(android.content.Context context, int animationIn, int animationOut) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Set the AppWidget that will be displayed by this view. This method also adds default padding
 * to widgets, as described in {@link #getDefaultPaddingForWidget(android.content.Context,android.content.ComponentName,android.graphics.Rect)}
 * and can be overridden in order to add custom padding.
 * @apiSince 3
 */

public void setAppWidget(int appWidgetId, android.appwidget.AppWidgetProviderInfo info) { throw new RuntimeException("Stub!"); }

/**
 * As of ICE_CREAM_SANDWICH we are automatically adding padding to widgets targeting
 * ICE_CREAM_SANDWICH and higher. The new widget design guidelines strongly recommend
 * that widget developers do not add extra padding to their widgets. This will help
 * achieve consistency among widgets.
 *
 * Note: this method is only needed by developers of AppWidgetHosts. The method is provided in
 * order for the AppWidgetHost to account for the automatic padding when computing the number
 * of cells to allocate to a particular widget.
 *
 * @param context the current context
 * @param component the component name of the widget
 * @param padding Rect in which to place the output, if null, a new Rect will be allocated and
 *                returned
 * @return default padding for this widget, in pixels
 * @apiSince 15
 */

public static android.graphics.Rect getDefaultPaddingForWidget(android.content.Context context, android.content.ComponentName component, android.graphics.Rect padding) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public int getAppWidgetId() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public android.appwidget.AppWidgetProviderInfo getAppWidgetInfo() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

protected void dispatchSaveInstanceState(android.util.SparseArray<android.os.Parcelable> container) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

protected void dispatchRestoreInstanceState(android.util.SparseArray<android.os.Parcelable> container) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

protected void onLayout(boolean changed, int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * Provide guidance about the size of this widget to the AppWidgetManager. The widths and
 * heights should correspond to the full area the AppWidgetHostView is given. Padding added by
 * the framework will be accounted for automatically. This information gets embedded into the
 * AppWidget options and causes a callback to the AppWidgetProvider.
 * @see android.appwidget.AppWidgetProvider#onAppWidgetOptionsChanged(Context, AppWidgetManager, int, Bundle)
 *
 * @param newOptions The bundle of options, in addition to the size information,
 *          can be null.
 * @param minWidth The minimum width in dips that the widget will be displayed at.
 * @param minHeight The maximum height in dips that the widget will be displayed at.
 * @param maxWidth The maximum width in dips that the widget will be displayed at.
 * @param maxHeight The maximum height in dips that the widget will be displayed at.
 *
 * @apiSince 16
 */

public void updateAppWidgetSize(android.os.Bundle newOptions, int minWidth, int minHeight, int maxWidth, int maxHeight) { throw new RuntimeException("Stub!"); }

/**
 * Specify some extra information for the widget provider. Causes a callback to the
 * AppWidgetProvider.
 * @see android.appwidget.AppWidgetProvider#onAppWidgetOptionsChanged(Context, AppWidgetManager, int, Bundle)
 *
 * @param options The bundle of options information.
 * @apiSince 16
 */

public void updateAppWidgetOptions(android.os.Bundle options) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 3
 */

public android.widget.FrameLayout.LayoutParams generateLayoutParams(android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/**
 * Sets an executor which can be used for asynchronously inflating. CPU intensive tasks like
 * view inflation or loading images will be performed on the executor. The updates will still
 * be applied on the UI thread.
 *
 * @param executor the executor to use or null.
 * @apiSince 26
 */

public void setExecutor(java.util.concurrent.Executor executor) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the widget is being displayed on a light/white background and use an
 * alternate UI if available.
 * @see android.widget.RemoteViews#setLightBackgroundLayoutId(int)
 * @apiSince 29
 */

public void setOnLightBackground(boolean onLightBackground) { throw new RuntimeException("Stub!"); }

/**
 * Process a set of {@link android.widget.RemoteViews RemoteViews} coming in as an update from the
 * AppWidget provider. Will animate into these new views as needed
 * @apiSince 3
 */

public void updateAppWidget(android.widget.RemoteViews remoteViews) { throw new RuntimeException("Stub!"); }

/**
 * Prepare the given view to be shown. This might include adjusting
 * {@link android.widget.FrameLayout.LayoutParams FrameLayout.LayoutParams} before inserting.
 * @apiSince 3
 */

protected void prepareView(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Inflate and return the default layout requested by AppWidget provider.
 * @apiSince 3
 */

protected android.view.View getDefaultView() { throw new RuntimeException("Stub!"); }

/**
 * Inflate and return a view that represents an error state.
 * @apiSince 3
 */

protected android.view.View getErrorView() { throw new RuntimeException("Stub!"); }
}

