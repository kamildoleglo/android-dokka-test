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
import android.util.DisplayMetrics;
import android.os.Bundle;
import android.content.ComponentName;
import android.app.PendingIntent;
import android.content.pm.PackageManager;
import android.os.Parcelable;

/**
 * Describes the meta data for an installed AppWidget provider.  The fields in this class
 * correspond to the fields in the <code>&lt;appwidget-provider&gt;</code> xml tag.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AppWidgetProviderInfo implements android.os.Parcelable {

/** @apiSince 3 */

public AppWidgetProviderInfo() { throw new RuntimeException("Stub!"); }

/**
 * Unflatten the AppWidgetProviderInfo from a parcel.
 * @apiSince 3
 */

public AppWidgetProviderInfo(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/**
 * Loads the localized label to display to the user in the AppWidget picker.
 *
 * @param packageManager Package manager instance for loading resources.
 * @return The label for the current locale.
 * @apiSince 21
 */

public final java.lang.String loadLabel(android.content.pm.PackageManager packageManager) { throw new RuntimeException("Stub!"); }

/**
 * Loads the icon to display for this AppWidget in the AppWidget picker. If not
 * supplied in the xml, the application icon will be used. A client can optionally
 * provide a desired density such as {@link android.util.DisplayMetrics#DENSITY_LOW}
 * {@link android.util.DisplayMetrics#DENSITY_MEDIUM}, etc. If no density is
 * provided, the density of the current display will be used.
 * <p>
 * The loaded icon corresponds to the <code>android:icon</code> attribute in
 * the <code>&lt;receiver&gt;</code> element in the AndroidManifest.xml file.
 * </p>
 *
 * @param context Context for accessing resources.
 * This value must never be {@code null}.
 * @param density The optional desired density as per
 *         {@link android.util.DisplayMetrics#densityDpi}.
 * @return The provider icon.
 * @apiSince 21
 */

public final android.graphics.drawable.Drawable loadIcon(@androidx.annotation.NonNull android.content.Context context, int density) { throw new RuntimeException("Stub!"); }

/**
 * Loads a preview of what the AppWidget will look like after it's configured.
 * A client can optionally provide a desired density such as
 * {@link android.util.DisplayMetrics#DENSITY_LOW}
 * {@link android.util.DisplayMetrics#DENSITY_MEDIUM}, etc. If no density is
 * provided, the density of the current display will be used.
 * <p>
 * The loaded image corresponds to the <code>android:previewImage</code> attribute
 * in the <code>&lt;receiver&gt;</code> element in the AndroidManifest.xml file.
 * </p>
 *
 * @param context Context for accessing resources.
 * This value must never be {@code null}.
 * @param density The optional desired density as per
 *         {@link android.util.DisplayMetrics#densityDpi}.
 * @return The widget preview image or null if preview image is not available.
 * @apiSince 21
 */

public final android.graphics.drawable.Drawable loadPreviewImage(@androidx.annotation.NonNull android.content.Context context, int density) { throw new RuntimeException("Stub!"); }

/**
 * Gets the user profile in which the provider resides.
 *
 * @return The hosting user profile.
 * @apiSince 21
 */

public final android.os.UserHandle getProfile() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public android.appwidget.AppWidgetProviderInfo clone() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Parcelable.Creator that instantiates AppWidgetProviderInfo objects
 * @apiSince 3
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.appwidget.AppWidgetProviderInfo> CREATOR;
static { CREATOR = null; }

/**
 * Widget is resizable in both the horizontal and vertical axes.
 * @apiSince 12
 */

public static final int RESIZE_BOTH = 3; // 0x3

/**
 * Widget is resizable in the horizontal axis only.
 * @apiSince 12
 */

public static final int RESIZE_HORIZONTAL = 1; // 0x1

/**
 * Widget is not resizable.
 * @apiSince 12
 */

public static final int RESIZE_NONE = 0; // 0x0

/**
 * Widget is resizable in the vertical axis only.
 * @apiSince 12
 */

public static final int RESIZE_VERTICAL = 2; // 0x2

/**
 * Indicates that the widget can be displayed on the home screen. This is the default value.
 * @apiSince 17
 */

public static final int WIDGET_CATEGORY_HOME_SCREEN = 1; // 0x1

/**
 * Indicates that the widget can be displayed on the keyguard.
 * @apiSince 17
 */

public static final int WIDGET_CATEGORY_KEYGUARD = 2; // 0x2

/**
 * Indicates that the widget can be displayed within a space reserved for the search box.
 * @apiSince 21
 */

public static final int WIDGET_CATEGORY_SEARCHBOX = 4; // 0x4

/**
 * The widget is added directly by the app, and the host may hide this widget when providing
 * the user with the list of available widgets to choose from.
 *
 * @see android.appwidget.AppWidgetManager#requestPinAppWidget(ComponentName, Bundle, PendingIntent)
 * @see #widgetFeatures
 * @apiSince 28
 */

public static final int WIDGET_FEATURE_HIDE_FROM_PICKER = 2; // 0x2

/**
 * The widget can be reconfigured anytime after it is bound by starting the
 * {@link #configure} activity.
 *
 * @see #widgetFeatures
 * @apiSince 28
 */

public static final int WIDGET_FEATURE_RECONFIGURABLE = 1; // 0x1

/**
 * The view id of the AppWidget subview which should be auto-advanced by the widget's host.
 *
 * <p>This field corresponds to the <code>android:autoAdvanceViewId</code> attribute in
 * the AppWidget meta-data file.
 * @apiSince 11
 */

public int autoAdvanceViewId;

/**
 * The activity to launch that will configure the AppWidget.
 *
 * <p>This class name of field corresponds to the <code>android:configure</code> attribute in
 * the AppWidget meta-data file.  The package name always corresponds to the package containing
 * the AppWidget provider.
 * @apiSince 3
 */

public android.content.ComponentName configure;

/**
 * The icon to display for this AppWidget in the AppWidget picker. If not supplied in the
 * xml, the application icon will be used.
 *
 * <p>This field corresponds to the <code>android:icon</code> attribute in
 * the <code>&lt;receiver&gt;</code> element in the AndroidManifest.xml file.
 * @apiSince 3
 */

public int icon;

/**
 * The resource id of the initial layout for this AppWidget when it is displayed on keyguard.
 * This parameter only needs to be provided if the widget can be displayed on the keyguard,
 * see {@link #widgetCategory}.
 *
 * <p>This field corresponds to the <code>android:initialKeyguardLayout</code> attribute in
 * the AppWidget meta-data file.
 * @apiSince 17
 */

public int initialKeyguardLayout;

/**
 * The resource id of the initial layout for this AppWidget.  This should be
 * displayed until the RemoteViews for the AppWidget is available.
 *
 * <p>This field corresponds to the <code>android:initialLayout</code> attribute in
 * the AppWidget meta-data file.
 * @apiSince 3
 */

public int initialLayout;

/**
 * The label to display to the user in the AppWidget picker.
 *
 * @deprecated Use {@link #loadLabel(android.content.pm.PackageManager)}.
 * @apiSince 3
 * @deprecatedSince 21
 */

@Deprecated public java.lang.String label;

/**
 * The default height of the widget when added to a host, in dp. The widget will get
 * at least this height, and will often be given more, depending on the host.
 *
 * <p>This field corresponds to the <code>android:minHeight</code> attribute in
 * the AppWidget meta-data file.
 * @apiSince 3
 */

public int minHeight;

/**
 * Minimum height (in dp) which the widget can be resized to. This field has no effect if it
 * is greater than minHeight or if vertical resizing isn't enabled (see {@link #resizeMode}).
 *
 * <p>This field corresponds to the <code>android:minResizeHeight</code> attribute in
 * the AppWidget meta-data file.
 * @apiSince 14
 */

public int minResizeHeight;

/**
 * Minimum width (in dp) which the widget can be resized to. This field has no effect if it
 * is greater than minWidth or if horizontal resizing isn't enabled (see {@link #resizeMode}).
 *
 * <p>This field corresponds to the <code>android:minResizeWidth</code> attribute in
 * the AppWidget meta-data file.
 * @apiSince 14
 */

public int minResizeWidth;

/**
 * The default height of the widget when added to a host, in dp. The widget will get
 * at least this width, and will often be given more, depending on the host.
 *
 * <p>This field corresponds to the <code>android:minWidth</code> attribute in
 * the AppWidget meta-data file.
 * @apiSince 3
 */

public int minWidth;

/**
 * A preview of what the AppWidget will look like after it's configured.
 * If not supplied, the AppWidget's icon will be used.
 *
 * <p>This field corresponds to the <code>android:previewImage</code> attribute in
 * the <code>&lt;receiver&gt;</code> element in the AndroidManifest.xml file.
 * @apiSince 11
 */

public int previewImage;

/**
 * Identity of this AppWidget component.  This component should be a {@link
 * android.content.BroadcastReceiver}, and it will be sent the AppWidget intents
 * {@link android.appwidget as described in the AppWidget package documentation}.
 *
 * <p>This field corresponds to the <code>android:name</code> attribute in
 * the <code>&lt;receiver&gt;</code> element in the AndroidManifest.xml file.
 * @apiSince 3
 */

public android.content.ComponentName provider;

/**
 * The rules by which a widget can be resized. See {@link #RESIZE_NONE},
 * {@link #RESIZE_NONE}, {@link #RESIZE_HORIZONTAL},
 * {@link #RESIZE_VERTICAL}, {@link #RESIZE_BOTH}.
 *
 * <p>This field corresponds to the <code>android:resizeMode</code> attribute in
 * the AppWidget meta-data file.
 
 * <br>
 * Value is either <code>0</code> or a combination of {@link android.appwidget.AppWidgetProviderInfo#RESIZE_HORIZONTAL}, and {@link android.appwidget.AppWidgetProviderInfo#RESIZE_VERTICAL}
 * @apiSince 12
 */

public int resizeMode;

/**
 * How often, in milliseconds, that this AppWidget wants to be updated.
 * The AppWidget manager may place a limit on how often a AppWidget is updated.
 *
 * <p>This field corresponds to the <code>android:updatePeriodMillis</code> attribute in
 * the AppWidget meta-data file.
 *
 * <p class="note"><b>Note:</b> Updates requested with <code>updatePeriodMillis</code>
 * will not be delivered more than once every 30 minutes.</p>
 * @apiSince 3
 */

public int updatePeriodMillis;

/**
 * Determines whether this widget can be displayed on the home screen, the keyguard, or both.
 * A widget which is displayed on both needs to ensure that it follows the design guidelines
 * for both widget classes. This can be achieved by querying the AppWidget options in its
 * widget provider's update method.
 *
 * <p>This field corresponds to the <code>widgetCategory</code> attribute in
 * the AppWidget meta-data file.
 
 * <br>
 * Value is either <code>0</code> or a combination of {@link android.appwidget.AppWidgetProviderInfo#WIDGET_CATEGORY_HOME_SCREEN}, {@link android.appwidget.AppWidgetProviderInfo#WIDGET_CATEGORY_KEYGUARD}, and {@link android.appwidget.AppWidgetProviderInfo#WIDGET_CATEGORY_SEARCHBOX}
 * @apiSince 17
 */

public int widgetCategory;

/**
 * Flags indicating various features supported by the widget. These are hints to the widget
 * host, and do not actually change the behavior of the widget.
 *
 * <br>
 * Value is either <code>0</code> or a combination of {@link android.appwidget.AppWidgetProviderInfo#WIDGET_FEATURE_RECONFIGURABLE}, and {@link android.appwidget.AppWidgetProviderInfo#WIDGET_FEATURE_HIDE_FROM_PICKER}
 * @see #WIDGET_FEATURE_RECONFIGURABLE
 * @see #WIDGET_FEATURE_HIDE_FROM_PICKER
 * @apiSince 28
 */

public int widgetFeatures;
}

