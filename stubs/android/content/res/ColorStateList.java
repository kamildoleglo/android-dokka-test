/*
 * Copyright (C) 2007 The Android Open Source Project
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


package android.content.res;

import android.graphics.Color;
import org.xmlpull.v1.XmlPullParser;
import android.content.res.Resources.Theme;

/**
 *
 * Lets you map {@link android.view.View} state sets to colors.
 * <p>
 * {@link android.content.res.ColorStateList}s are created from XML resource files defined in the
 * "color" subdirectory directory of an application's resource directory. The XML file contains
 * a single "selector" element with a number of "item" elements inside. For example:
 * <pre>
 * &lt;selector xmlns:android="http://schemas.android.com/apk/res/android"&gt;
 *   &lt;item android:state_focused="true"
 *           android:color="@color/sample_focused" /&gt;
 *   &lt;item android:state_pressed="true"
 *           android:state_enabled="false"
 *           android:color="@color/sample_disabled_pressed" /&gt;
 *   &lt;item android:state_enabled="false"
 *           android:color="@color/sample_disabled_not_pressed" /&gt;
 *   &lt;item android:color="@color/sample_default" /&gt;
 * &lt;/selector&gt;
 * </pre>
 *
 * This defines a set of state spec / color pairs where each state spec specifies a set of
 * states that a view must either be in or not be in and the color specifies the color associated
 * with that spec.
 *
 * <a name="StateSpec"></a>
 * <h3>State specs</h3>
 * <p>
 * Each item defines a set of state spec and color pairs, where the state spec is a series of
 * attributes set to either {@code true} or {@code false} to represent inclusion or exclusion. If
 * an attribute is not specified for an item, it may be any value.
 * <p>
 * For example, the following item will be matched whenever the focused state is set; any other
 * states may be set or unset:
 * <pre>
 * &lt;item android:state_focused="true"
 *         android:color="@color/sample_focused" /&gt;
 * </pre>
 * <p>
 * Typically, a color state list will reference framework-defined state attributes such as
 * {@link android.R.attr#state_focused android:state_focused} or
 * {@link android.R.attr#state_enabled android:state_enabled}; however, app-defined attributes may
 * also be used.
 * <p>
 * <strong>Note:</strong> The list of state specs will be matched against in the order that they
 * appear in the XML file. For this reason, more-specific items should be placed earlier in the
 * file. An item with no state spec is considered to match any set of states and is generally
 * useful as a final item to be used as a default.
 * <p>
 * If an item with no state spec is placed before other items, those items
 * will be ignored.
 *
 * <a name="ItemAttributes"></a>
 * <h3>Item attributes</h3>
 * <p>
 * Each item must define an {@link android.R.attr#color android:color} attribute, which may be
 * an HTML-style hex color, a reference to a color resource, or -- in API 23 and above -- a theme
 * attribute that resolves to a color.
 * <p>
 * Starting with API 23, items may optionally define an {@link android.R.attr#alpha android:alpha}
 * attribute to modify the base color's opacity. This attribute takes a either floating-point value
 * between 0 and 1 or a theme attribute that resolves as such. The item's overall color is
 * calculated by multiplying by the base color's alpha channel by the {@code alpha} value. For
 * example, the following item represents the theme's accent color at 50% opacity:
 * <pre>
 * &lt;item android:state_enabled="false"
 *         android:color="?android:attr/colorAccent"
 *         android:alpha="0.5" /&gt;
 * </pre>
 *
 * <a name="DeveloperGuide"></a>
 * <h3>Developer guide</h3>
 * <p>
 * For more information, see the guide to
 * <a href="{@docRoot}guide/topics/resources/color-list-resource.html">Color State
 * List Resource</a>.
 *
 * @attr ref android.R.styleable#ColorStateListItem_alpha
 * @attr ref android.R.styleable#ColorStateListItem_color
 @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ColorStateList implements android.os.Parcelable {

/**
 * Creates a ColorStateList that returns the specified mapping from
 * states to colors.
 * @apiSince 1
 */

public ColorStateList(int[][] states, int[] colors) { throw new RuntimeException("Stub!"); }

/**
 * @return A ColorStateList containing a single color.
 
 * This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static android.content.res.ColorStateList valueOf(int color) { throw new RuntimeException("Stub!"); }

/**
 * Creates a ColorStateList from an XML document.
 *
 * @param r Resources against which the ColorStateList should be inflated.
 * @param parser Parser for the XML document defining the ColorStateList.
 * @return A new color state list.
 *
 * This value will never be {@code null}.
 * @deprecated Use #createFromXml(Resources, XmlPullParser parser, Theme)
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated
@androidx.annotation.NonNull
public static android.content.res.ColorStateList createFromXml(android.content.res.Resources r, org.xmlpull.v1.XmlPullParser parser) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/**
 * Creates a ColorStateList from an XML document using given a set of
 * {@link android.content.res.Resources Resources} and a {@link android.content.res.Resources.Theme Theme}.
 *
 * @param r Resources against which the ColorStateList should be inflated.
 * This value must never be {@code null}.
 * @param parser Parser for the XML document defining the ColorStateList.
 * This value must never be {@code null}.
 * @param theme Optional theme to apply to the color state list, may be
 *              {@code null}.
 * This value may be {@code null}.
 * @return A new color state list.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public static android.content.res.ColorStateList createFromXml(@androidx.annotation.NonNull android.content.res.Resources r, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser parser, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/**
 * Creates a new ColorStateList that has the same states and colors as this
 * one but where each color has the specified alpha value (0-255).
 *
 * @param alpha The new alpha channel value (0-255).
 * @return A new color state list.
 
 * This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public android.content.res.ColorStateList withAlpha(int alpha) { throw new RuntimeException("Stub!"); }

/**
 * Returns a mask of the configuration parameters for which this color
 * state list may change, requiring that it be re-created.
 *
 * @return a mask of the changing configuration parameters, as defined by
 *         {@link android.content.pm.ActivityInfo}
 *
 * Value is either <code>0</code> or a combination of {@link android.content.pm.ActivityInfo#CONFIG_MCC}, {@link android.content.pm.ActivityInfo#CONFIG_MNC}, {@link android.content.pm.ActivityInfo#CONFIG_LOCALE}, {@link android.content.pm.ActivityInfo#CONFIG_TOUCHSCREEN}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD_HIDDEN}, {@link android.content.pm.ActivityInfo#CONFIG_NAVIGATION}, {@link android.content.pm.ActivityInfo#CONFIG_ORIENTATION}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_LAYOUT}, {@link android.content.pm.ActivityInfo#CONFIG_UI_MODE}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_SMALLEST_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_DENSITY}, {@link android.content.pm.ActivityInfo#CONFIG_LAYOUT_DIRECTION}, {@link android.content.pm.ActivityInfo#CONFIG_COLOR_MODE}, and {@link android.content.pm.ActivityInfo#CONFIG_FONT_SCALE}
 * @see android.content.pm.ActivityInfo
 * @apiSince 23
 */

public int getChangingConfigurations() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether this color state list contains at least one state spec
 * and the first spec is not empty (e.g.&nbsp;match-all).
 *
 * @return True if this color state list changes color based on state, false
 *         otherwise.
 * @see #getColorForState(int[], int)
 * @apiSince 1
 */

public boolean isStateful() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether this color state list is opaque, which means that every
 * color returned from {@link #getColorForState(int[],int)} has an alpha
 * value of 255.
 *
 * @return True if this color state list is opaque.
 * @apiSince 21
 */

public boolean isOpaque() { throw new RuntimeException("Stub!"); }

/**
 * Return the color associated with the given set of
 * {@link android.view.View} states.
 *
 * @param stateSet an array of {@link android.view.View} states
 * This value may be {@code null}.
 * @param defaultColor the color to return if there's no matching state
 *                     spec in this {@link android.content.res.ColorStateList ColorStateList} that matches the
 *                     stateSet.
 *
 * @return the color associated with that set of states in this {@link android.content.res.ColorStateList ColorStateList}.
 * @apiSince 1
 */

public int getColorForState(@androidx.annotation.Nullable int[] stateSet, int defaultColor) { throw new RuntimeException("Stub!"); }

/**
 * Return the default color in this {@link android.content.res.ColorStateList ColorStateList}.
 *
 * @return the default color in this {@link android.content.res.ColorStateList ColorStateList}.
 * @apiSince 1
 */

public int getDefaultColor() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.content.res.ColorStateList> CREATOR;
static { CREATOR = null; }
}

