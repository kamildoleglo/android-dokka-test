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


package android.content.res;

import android.content.pm.ActivityInfo;
import android.os.Parcelable;
import java.util.Locale;
import android.os.LocaleList;
import android.view.View;

/**
 * This class describes all device configuration information that can
 * impact the resources the application retrieves.  This includes both
 * user-specified configuration options (locale list and scaling) as well
 * as device configurations (such as input modes, screen size and screen orientation).
 * <p>You can acquire this object from {@link android.content.res.Resources Resources}, using {@link android.content.res.Resources#getConfiguration Resources#getConfiguration}. Thus, from an activity, you can get it by chaining the request
 * with {@link android.app.Activity#getResources}:</p>
 * <pre>Configuration config = getResources().getConfiguration();</pre>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Configuration implements android.os.Parcelable, java.lang.Comparable<android.content.res.Configuration> {

/**
 * <p>Construct an invalid Configuration. This state is only suitable for constructing a
 * Configuration delta that will be applied to some valid Configuration object. In order to
 * create a valid standalone Configuration, you must call {@link #setToDefaults}. </p>
 *
 * <p>Example:</p>
 * <pre class="prettyprint">
 *     Configuration validConfig = new Configuration();
 *     validConfig.setToDefaults();
 *
 *     Configuration deltaOnlyConfig = new Configuration();
 *     deltaOnlyConfig.orientation = Configuration.ORIENTATION_LANDSCAPE;
 *
 *     validConfig.updateFrom(deltaOnlyConfig);
 * </pre>
 * @apiSince 1
 */

public Configuration() { throw new RuntimeException("Stub!"); }

/**
 * Makes a deep copy suitable for modification.
 * @apiSince 1
 */

public Configuration(android.content.res.Configuration o) { throw new RuntimeException("Stub!"); }

/**
 * Check if the Configuration's current {@link #screenLayout} is at
 * least the given size.
 *
 * @param size The desired size, either {@link #SCREENLAYOUT_SIZE_SMALL},
 * {@link #SCREENLAYOUT_SIZE_NORMAL}, {@link #SCREENLAYOUT_SIZE_LARGE}, or
 * {@link #SCREENLAYOUT_SIZE_XLARGE}.
 * @return Returns true if the current screen layout size is at least
 * the given size.
 * @apiSince 11
 */

public boolean isLayoutSizeAtLeast(int size) { throw new RuntimeException("Stub!"); }

/**
 * Sets the fields in this object to those in the given Configuration.
 *
 * @param o The Configuration object used to set the values of this Configuration's fields.
 * @apiSince 8
 */

public void setTo(android.content.res.Configuration o) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Set this object to the system defaults.
 * @apiSince 1
 */

public void setToDefaults() { throw new RuntimeException("Stub!"); }

/**
 * Copies the fields from delta into this Configuration object, keeping
 * track of which ones have changed. Any undefined fields in {@code delta}
 * are ignored and not copied in to the current Configuration.
 *
 * @param delta This value must never be {@code null}.
 * @return a bit mask of the changed fields, as per {@link #diff}
 
 * Value is either <code>0</code> or a combination of {@link android.content.pm.ActivityInfo#CONFIG_MCC}, {@link android.content.pm.ActivityInfo#CONFIG_MNC}, {@link android.content.pm.ActivityInfo#CONFIG_LOCALE}, {@link android.content.pm.ActivityInfo#CONFIG_TOUCHSCREEN}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD_HIDDEN}, {@link android.content.pm.ActivityInfo#CONFIG_NAVIGATION}, {@link android.content.pm.ActivityInfo#CONFIG_ORIENTATION}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_LAYOUT}, {@link android.content.pm.ActivityInfo#CONFIG_UI_MODE}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_SMALLEST_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_DENSITY}, {@link android.content.pm.ActivityInfo#CONFIG_LAYOUT_DIRECTION}, {@link android.content.pm.ActivityInfo#CONFIG_COLOR_MODE}, and {@link android.content.pm.ActivityInfo#CONFIG_FONT_SCALE}
 * @apiSince 1
 */

public int updateFrom(@androidx.annotation.NonNull android.content.res.Configuration delta) { throw new RuntimeException("Stub!"); }

/**
 * Return a bit mask of the differences between this Configuration
 * object and the given one.  Does not change the values of either.  Any
 * undefined fields in <var>delta</var> are ignored.
 * @return Returns a bit mask indicating which configuration
 * values has changed, containing any combination of
 * {@link android.content.pm.ActivityInfo#CONFIG_FONT_SCALE
 * PackageManager.ActivityInfo.CONFIG_FONT_SCALE},
 * {@link android.content.pm.ActivityInfo#CONFIG_MCC
 * PackageManager.ActivityInfo.CONFIG_MCC},
 * {@link android.content.pm.ActivityInfo#CONFIG_MNC
 * PackageManager.ActivityInfo.CONFIG_MNC},
 * {@link android.content.pm.ActivityInfo#CONFIG_LOCALE
 * PackageManager.ActivityInfo.CONFIG_LOCALE},
 * {@link android.content.pm.ActivityInfo#CONFIG_TOUCHSCREEN
 * PackageManager.ActivityInfo.CONFIG_TOUCHSCREEN},
 * {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD
 * PackageManager.ActivityInfo.CONFIG_KEYBOARD},
 * {@link android.content.pm.ActivityInfo#CONFIG_NAVIGATION
 * PackageManager.ActivityInfo.CONFIG_NAVIGATION},
 * {@link android.content.pm.ActivityInfo#CONFIG_ORIENTATION
 * PackageManager.ActivityInfo.CONFIG_ORIENTATION},
 * {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_LAYOUT
 * PackageManager.ActivityInfo.CONFIG_SCREEN_LAYOUT}, or
 * {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_SIZE
 * PackageManager.ActivityInfo.CONFIG_SCREEN_SIZE}, or
 * {@link android.content.pm.ActivityInfo#CONFIG_SMALLEST_SCREEN_SIZE
 * PackageManager.ActivityInfo.CONFIG_SMALLEST_SCREEN_SIZE}.
 * {@link android.content.pm.ActivityInfo#CONFIG_LAYOUT_DIRECTION
 * PackageManager.ActivityInfo.CONFIG_LAYOUT_DIRECTION}.
 * @apiSince 1
 */

public int diff(android.content.res.Configuration delta) { throw new RuntimeException("Stub!"); }

/**
 * Determines if a new resource needs to be loaded from the bit set of
 * configuration changes returned by {@link #updateFrom(android.content.res.Configuration)}.
 *
 * @param configChanges the mask of changes configurations as returned by
 *                      {@link #updateFrom(android.content.res.Configuration)}
 * Value is either <code>0</code> or a combination of {@link android.content.pm.ActivityInfo#CONFIG_MCC}, {@link android.content.pm.ActivityInfo#CONFIG_MNC}, {@link android.content.pm.ActivityInfo#CONFIG_LOCALE}, {@link android.content.pm.ActivityInfo#CONFIG_TOUCHSCREEN}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD_HIDDEN}, {@link android.content.pm.ActivityInfo#CONFIG_NAVIGATION}, {@link android.content.pm.ActivityInfo#CONFIG_ORIENTATION}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_LAYOUT}, {@link android.content.pm.ActivityInfo#CONFIG_UI_MODE}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_SMALLEST_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_DENSITY}, {@link android.content.pm.ActivityInfo#CONFIG_LAYOUT_DIRECTION}, {@link android.content.pm.ActivityInfo#CONFIG_COLOR_MODE}, and {@link android.content.pm.ActivityInfo#CONFIG_FONT_SCALE}
 * @param interestingChanges the configuration changes that the resource
 *                           can handle as given in
 *                           {@link android.util.TypedValue#changingConfigurations}
 * Value is either <code>0</code> or a combination of {@link android.content.pm.ActivityInfo#CONFIG_MCC}, {@link android.content.pm.ActivityInfo#CONFIG_MNC}, {@link android.content.pm.ActivityInfo#CONFIG_LOCALE}, {@link android.content.pm.ActivityInfo#CONFIG_TOUCHSCREEN}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD_HIDDEN}, {@link android.content.pm.ActivityInfo#CONFIG_NAVIGATION}, {@link android.content.pm.ActivityInfo#CONFIG_ORIENTATION}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_LAYOUT}, {@link android.content.pm.ActivityInfo#CONFIG_UI_MODE}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_SMALLEST_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_DENSITY}, {@link android.content.pm.ActivityInfo#CONFIG_LAYOUT_DIRECTION}, {@link android.content.pm.ActivityInfo#CONFIG_COLOR_MODE}, and {@link android.content.pm.ActivityInfo#CONFIG_FONT_SCALE}
 * @return {@code true} if the resource needs to be loaded, {@code false}
 *         otherwise
 * @apiSince 1
 */

public static boolean needNewResources(int configChanges, int interestingChanges) { throw new RuntimeException("Stub!"); }

/**
 * Parcelable methods
 * @apiSince 1
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public void readFromParcel(android.os.Parcel source) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int compareTo(android.content.res.Configuration that) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean equals(android.content.res.Configuration that) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean equals(java.lang.Object that) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Get the locale list. This is the preferred way for getting the locales (instead of using
 * the direct accessor to {@link #locale}, which would only provide the primary locale).
 *
 * @return The locale list.
 
 * This value will never be {@code null}.
 * @apiSince 24
 */

@androidx.annotation.NonNull
public android.os.LocaleList getLocales() { throw new RuntimeException("Stub!"); }

/**
 * Set the locale list. This is the preferred way for setting up the locales (instead of using
 * the direct accessor or {@link #setLocale(java.util.Locale)}). This will also set the layout direction
 * according to the first locale in the list.
 *
 * Note that the layout direction will always come from the first locale in the locale list,
 * even if the locale is not supported by the resources (the resources may only support
 * another locale further down the list which has a different direction).
 *
 * @param locales The locale list. If null, an empty LocaleList will be assigned.
 
 * This value may be {@code null}.
 * @apiSince 24
 */

public void setLocales(@androidx.annotation.Nullable android.os.LocaleList locales) { throw new RuntimeException("Stub!"); }

/**
 * Set the locale list to a list of just one locale. This will also set the layout direction
 * according to the locale.
 *
 * Note that after this is run, calling <code>.equals()</code> on the input locale and the
 * {@link #locale} attribute would return <code>true</code> if they are not null, but there is
 * no guarantee that they would be the same object.
 *
 * See also the note about layout direction in {@link #setLocales(android.os.LocaleList)}.
 *
 * @param loc The locale. Can be null.
 
 * This value may be {@code null}.
 * @apiSince 17
 */

public void setLocale(@androidx.annotation.Nullable java.util.Locale loc) { throw new RuntimeException("Stub!"); }

/**
 * Return the layout direction. Will be either {@link android.view.View#LAYOUT_DIRECTION_LTR View#LAYOUT_DIRECTION_LTR} or
 * {@link android.view.View#LAYOUT_DIRECTION_RTL View#LAYOUT_DIRECTION_RTL}.
 *
 * @return Returns {@link android.view.View#LAYOUT_DIRECTION_RTL View#LAYOUT_DIRECTION_RTL} if the configuration
 * is {@link #SCREENLAYOUT_LAYOUTDIR_RTL}, otherwise {@link android.view.View#LAYOUT_DIRECTION_LTR View#LAYOUT_DIRECTION_LTR}.
 * @apiSince 17
 */

public int getLayoutDirection() { throw new RuntimeException("Stub!"); }

/**
 * Set the layout direction from a Locale.
 *
 * @param loc The Locale. If null will set the layout direction to
 * {@link android.view.View#LAYOUT_DIRECTION_LTR View#LAYOUT_DIRECTION_LTR}. If not null will set it to the layout direction
 * corresponding to the Locale.
 *
 * @see android.view.View#LAYOUT_DIRECTION_LTR
 * @see android.view.View#LAYOUT_DIRECTION_RTL
 * @apiSince 17
 */

public void setLayoutDirection(java.util.Locale loc) { throw new RuntimeException("Stub!"); }

/**
 * Return whether the screen has a round shape. Apps may choose to change styling based
 * on this property, such as the alignment or layout of text or informational icons.
 *
 * @return true if the screen is rounded, false otherwise
 * @apiSince 23
 */

public boolean isScreenRound() { throw new RuntimeException("Stub!"); }

/**
 * Return whether the screen has a wide color gamut and wide color gamut rendering
 * is supported by this device.
 *
 * When true, it implies the screen is colorspace aware but not
 * necessarily color-managed. The final colors may still be changed by the
 * screen depending on user settings.
 *
 * @return true if the screen has a wide color gamut and wide color gamut rendering
 * is supported, false otherwise
 * @apiSince 26
 */

public boolean isScreenWideColorGamut() { throw new RuntimeException("Stub!"); }

/**
 * Return whether the screen has a high dynamic range.
 *
 * @return true if the screen has a high dynamic range, false otherwise
 * @apiSince 26
 */

public boolean isScreenHdr() { throw new RuntimeException("Stub!"); }

/**
 * Constant for {@link #colorMode}: bits that encode the dynamic range of the screen.
 * @apiSince 26
 */

public static final int COLOR_MODE_HDR_MASK = 12; // 0xc

/**
 * Constant for {@link #colorMode}: a {@link #COLOR_MODE_HDR_MASK} value
 * indicating that the screen is not HDR (low/standard dynamic range).
 * <p>Corresponds to the <code>-lowdr</code> resource qualifier.</p>
 * @apiSince 26
 */

public static final int COLOR_MODE_HDR_NO = 4; // 0x4

/**
 * Constant for {@link #colorMode}: bits shift to get the screen dynamic range.
 * @apiSince 26
 */

public static final int COLOR_MODE_HDR_SHIFT = 2; // 0x2

/**
 * Constant for {@link #colorMode}: a {@link #COLOR_MODE_HDR_MASK} value
 * indicating that it is unknown whether or not the screen is HDR.
 * @apiSince 26
 */

public static final int COLOR_MODE_HDR_UNDEFINED = 0; // 0x0

/**
 * Constant for {@link #colorMode}: a {@link #COLOR_MODE_HDR_MASK} value
 * indicating that the screen is HDR (dynamic range).
 * <p>Corresponds to the <code>-highdr</code> resource qualifier.</p>
 * @apiSince 26
 */

public static final int COLOR_MODE_HDR_YES = 8; // 0x8

/**
 * Constant for {@link #colorMode}: a value indicating that the color mode is undefined
 * @apiSince 26
 */

public static final int COLOR_MODE_UNDEFINED = 0; // 0x0

/**
 * Constant for {@link #colorMode}: bits that encode whether the screen is wide gamut.
 * @apiSince 26
 */

public static final int COLOR_MODE_WIDE_COLOR_GAMUT_MASK = 3; // 0x3

/**
 * Constant for {@link #colorMode}: a {@link #COLOR_MODE_WIDE_COLOR_GAMUT_MASK} value
 * indicating that the screen is not wide gamut.
 * <p>Corresponds to the <code>-nowidecg</code> resource qualifier.</p>
 * @apiSince 26
 */

public static final int COLOR_MODE_WIDE_COLOR_GAMUT_NO = 1; // 0x1

/**
 * Constant for {@link #colorMode}: a {@link #COLOR_MODE_WIDE_COLOR_GAMUT_MASK} value
 * indicating that it is unknown whether or not the screen is wide gamut.
 * @apiSince 26
 */

public static final int COLOR_MODE_WIDE_COLOR_GAMUT_UNDEFINED = 0; // 0x0

/**
 * Constant for {@link #colorMode}: a {@link #COLOR_MODE_WIDE_COLOR_GAMUT_MASK} value
 * indicating that the screen is wide gamut.
 * <p>Corresponds to the <code>-widecg</code> resource qualifier.</p>
 * @apiSince 26
 */

public static final int COLOR_MODE_WIDE_COLOR_GAMUT_YES = 2; // 0x2

/** @apiSince 1 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.content.res.Configuration> CREATOR;
static { CREATOR = null; }

/**
 * Default value for {@link #densityDpi} indicating that no width
 * has been specified.
 * @apiSince 17
 */

public static final int DENSITY_DPI_UNDEFINED = 0; // 0x0

/** Constant for {@link #hardKeyboardHidden}, value corresponding to the
 * physical keyboard being exposed.     * @apiSince 3
 */

public static final int HARDKEYBOARDHIDDEN_NO = 1; // 0x1

/**
 * Constant for {@link #hardKeyboardHidden}: a value indicating that no value has been set.
 * @apiSince 3
 */

public static final int HARDKEYBOARDHIDDEN_UNDEFINED = 0; // 0x0

/** Constant for {@link #hardKeyboardHidden}, value corresponding to the
 * physical keyboard being hidden.     * @apiSince 3
 */

public static final int HARDKEYBOARDHIDDEN_YES = 2; // 0x2

/** Constant for {@link #keyboardHidden}, value corresponding to the
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#KeyboardAvailQualifier">keysexposed</a>
 * resource qualifier.     * @apiSince 1
 */

public static final int KEYBOARDHIDDEN_NO = 1; // 0x1

/**
 * Constant for {@link #keyboardHidden}: a value indicating that no value has been set.
 * @apiSince 1
 */

public static final int KEYBOARDHIDDEN_UNDEFINED = 0; // 0x0

/** Constant for {@link #keyboardHidden}, value corresponding to the
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#KeyboardAvailQualifier">keyshidden</a>
 * resource qualifier.     * @apiSince 1
 */

public static final int KEYBOARDHIDDEN_YES = 2; // 0x2

/** Constant for {@link #keyboard}, value corresponding to the
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#ImeQualifier">12key</a>
 * resource qualifier.     * @apiSince 1
 */

public static final int KEYBOARD_12KEY = 3; // 0x3

/** Constant for {@link #keyboard}, value corresponding to the
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#ImeQualifier">nokeys</a>
 * resource qualifier.     * @apiSince 1
 */

public static final int KEYBOARD_NOKEYS = 1; // 0x1

/** Constant for {@link #keyboard}, value corresponding to the
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#ImeQualifier">qwerty</a>
 * resource qualifier.     * @apiSince 1
 */

public static final int KEYBOARD_QWERTY = 2; // 0x2

/**
 * Constant for {@link #keyboard}: a value indicating that no value has been set.
 * @apiSince 1
 */

public static final int KEYBOARD_UNDEFINED = 0; // 0x0

/**
 * Constant used to to represent MNC (Mobile Network Code) zero.
 * 0 cannot be used, since it is used to represent an undefined MNC.
 * @apiSince 19
 */

public static final int MNC_ZERO = 65535; // 0xffff

/** Constant for {@link #navigationHidden}, value corresponding to the
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#NavAvailQualifier">navexposed</a>
 * resource qualifier.     * @apiSince 5
 */

public static final int NAVIGATIONHIDDEN_NO = 1; // 0x1

/**
 * Constant for {@link #navigationHidden}: a value indicating that no value has been set.
 * @apiSince 5
 */

public static final int NAVIGATIONHIDDEN_UNDEFINED = 0; // 0x0

/** Constant for {@link #navigationHidden}, value corresponding to the
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#NavAvailQualifier">navhidden</a>
 * resource qualifier.     * @apiSince 5
 */

public static final int NAVIGATIONHIDDEN_YES = 2; // 0x2

/** Constant for {@link #navigation}, value corresponding to the
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#NavigationQualifier">dpad</a>
 * resource qualifier.     * @apiSince 1
 */

public static final int NAVIGATION_DPAD = 2; // 0x2

/** Constant for {@link #navigation}, value corresponding to the
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#NavigationQualifier">nonav</a>
 * resource qualifier.     * @apiSince 1
 */

public static final int NAVIGATION_NONAV = 1; // 0x1

/** Constant for {@link #navigation}, value corresponding to the
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#NavigationQualifier">trackball</a>
 * resource qualifier.     * @apiSince 1
 */

public static final int NAVIGATION_TRACKBALL = 3; // 0x3

/**
 * Constant for {@link #navigation}: a value indicating that no value has been set.
 * @apiSince 1
 */

public static final int NAVIGATION_UNDEFINED = 0; // 0x0

/** Constant for {@link #navigation}, value corresponding to the
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#NavigationQualifier">wheel</a>
 * resource qualifier.     * @apiSince 1
 */

public static final int NAVIGATION_WHEEL = 4; // 0x4

/** Constant for {@link #orientation}, value corresponding to the
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#OrientationQualifier">land</a>
 * resource qualifier.     * @apiSince 1
 */

public static final int ORIENTATION_LANDSCAPE = 2; // 0x2

/** Constant for {@link #orientation}, value corresponding to the
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#OrientationQualifier">port</a>
 * resource qualifier.     * @apiSince 1
 */

public static final int ORIENTATION_PORTRAIT = 1; // 0x1

/**
 * @deprecated Not currently supported or used.
 * @apiSince 1
 * @deprecatedSince 16
 */

@Deprecated public static final int ORIENTATION_SQUARE = 3; // 0x3

/**
 * Constant for {@link #orientation}: a value indicating that no value has been set.
 * @apiSince 1
 */

public static final int ORIENTATION_UNDEFINED = 0; // 0x0

/** Constant for {@link #screenLayout}: a {@link #SCREENLAYOUT_LAYOUTDIR_MASK}
 * value indicating that a layout dir has been set to LTR.     * @apiSince 17
 */

public static final int SCREENLAYOUT_LAYOUTDIR_LTR = 64; // 0x40

/**
 * Constant for {@link #screenLayout}: bits that encode the layout direction.
 * @apiSince 17
 */

public static final int SCREENLAYOUT_LAYOUTDIR_MASK = 192; // 0xc0

/** Constant for {@link #screenLayout}: a {@link #SCREENLAYOUT_LAYOUTDIR_MASK}
 * value indicating that a layout dir has been set to RTL.     * @apiSince 17
 */

public static final int SCREENLAYOUT_LAYOUTDIR_RTL = 128; // 0x80

/**
 * Constant for {@link #screenLayout}: bits shift to get the layout direction.
 * @apiSince 17
 */

public static final int SCREENLAYOUT_LAYOUTDIR_SHIFT = 6; // 0x6

/** Constant for {@link #screenLayout}: a {@link #SCREENLAYOUT_LAYOUTDIR_MASK}
 * value indicating that no layout dir has been set.     * @apiSince 17
 */

public static final int SCREENLAYOUT_LAYOUTDIR_UNDEFINED = 0; // 0x0

/**
 * Constant for {@link #screenLayout}: bits that encode the aspect ratio.
 * @apiSince 4
 */

public static final int SCREENLAYOUT_LONG_MASK = 48; // 0x30

/** Constant for {@link #screenLayout}: a {@link #SCREENLAYOUT_LONG_MASK}
 * value that corresponds to the
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#ScreenAspectQualifier">notlong</a>
 * resource qualifier.     * @apiSince 4
 */

public static final int SCREENLAYOUT_LONG_NO = 16; // 0x10

/** Constant for {@link #screenLayout}: a {@link #SCREENLAYOUT_LONG_MASK}
 * value indicating that no size has been set.     * @apiSince 4
 */

public static final int SCREENLAYOUT_LONG_UNDEFINED = 0; // 0x0

/** Constant for {@link #screenLayout}: a {@link #SCREENLAYOUT_LONG_MASK}
 * value that corresponds to the
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#ScreenAspectQualifier">long</a>
 * resource qualifier.     * @apiSince 4
 */

public static final int SCREENLAYOUT_LONG_YES = 32; // 0x20

/**
 * Constant for {@link #screenLayout}: bits that encode roundness of the screen.
 * @apiSince 23
 */

public static final int SCREENLAYOUT_ROUND_MASK = 768; // 0x300

/**
 * Constant for {@link #screenLayout}: a {@link #SCREENLAYOUT_ROUND_MASK} value indicating
 * that the screen does not have a rounded shape.
 * @apiSince 23
 */

public static final int SCREENLAYOUT_ROUND_NO = 256; // 0x100

/**
 * Constant for {@link #screenLayout}: a {@link #SCREENLAYOUT_ROUND_MASK} value indicating
 * that it is unknown whether or not the screen has a round shape.
 * @apiSince 23
 */

public static final int SCREENLAYOUT_ROUND_UNDEFINED = 0; // 0x0

/**
 * Constant for {@link #screenLayout}: a {@link #SCREENLAYOUT_ROUND_MASK} value indicating
 * that the screen has a rounded shape. Corners may not be visible to the user;
 * developers should pay special attention to the {@link android.view.WindowInsets} delivered
 * to views for more information about ensuring content is not obscured.
 *
 * <p>Corresponds to the <code>-round</code> resource qualifier.</p>
 * @apiSince 23
 */

public static final int SCREENLAYOUT_ROUND_YES = 512; // 0x200

/** Constant for {@link #screenLayout}: a {@link #SCREENLAYOUT_SIZE_MASK}
 * value indicating the screen is at least approximately 480x640 dp units,
 * corresponds to the
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#ScreenSizeQualifier">large</a>
 * resource qualifier.
 * See <a href="{@docRoot}guide/practices/screens_support.html">Supporting
 * Multiple Screens</a> for more information.     * @apiSince 4
 */

public static final int SCREENLAYOUT_SIZE_LARGE = 3; // 0x3

/**
 * Constant for {@link #screenLayout}: bits that encode the size.
 * @apiSince 4
 */

public static final int SCREENLAYOUT_SIZE_MASK = 15; // 0xf

/** Constant for {@link #screenLayout}: a {@link #SCREENLAYOUT_SIZE_MASK}
 * value indicating the screen is at least approximately 320x470 dp units,
 * corresponds to the
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#ScreenSizeQualifier">normal</a>
 * resource qualifier.
 * See <a href="{@docRoot}guide/practices/screens_support.html">Supporting
 * Multiple Screens</a> for more information.     * @apiSince 4
 */

public static final int SCREENLAYOUT_SIZE_NORMAL = 2; // 0x2

/** Constant for {@link #screenLayout}: a {@link #SCREENLAYOUT_SIZE_MASK}
 * value indicating the screen is at least approximately 320x426 dp units,
 * corresponds to the
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#ScreenSizeQualifier">small</a>
 * resource qualifier.
 * See <a href="{@docRoot}guide/practices/screens_support.html">Supporting
 * Multiple Screens</a> for more information.     * @apiSince 4
 */

public static final int SCREENLAYOUT_SIZE_SMALL = 1; // 0x1

/** Constant for {@link #screenLayout}: a {@link #SCREENLAYOUT_SIZE_MASK}
 * value indicating that no size has been set.     * @apiSince 4
 */

public static final int SCREENLAYOUT_SIZE_UNDEFINED = 0; // 0x0

/** Constant for {@link #screenLayout}: a {@link #SCREENLAYOUT_SIZE_MASK}
 * value indicating the screen is at least approximately 720x960 dp units,
 * corresponds to the
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#ScreenSizeQualifier">xlarge</a>
 * resource qualifier.
 * See <a href="{@docRoot}guide/practices/screens_support.html">Supporting
 * Multiple Screens</a> for more information.     * @apiSince 9
 */

public static final int SCREENLAYOUT_SIZE_XLARGE = 4; // 0x4

/**
 * Constant for {@link #screenLayout}: a value indicating that screenLayout is undefined
 * @apiSince 17
 */

public static final int SCREENLAYOUT_UNDEFINED = 0; // 0x0

/**
 * Default value for {@link #screenHeightDp} indicating that no width
 * has been specified.
 * @apiSince 13
 */

public static final int SCREEN_HEIGHT_DP_UNDEFINED = 0; // 0x0

/**
 * Default value for {@link #screenWidthDp} indicating that no width
 * has been specified.
 * @apiSince 13
 */

public static final int SCREEN_WIDTH_DP_UNDEFINED = 0; // 0x0

/**
 * Default value for {@link #smallestScreenWidthDp} indicating that no width
 * has been specified.
 * @apiSince 13
 */

public static final int SMALLEST_SCREEN_WIDTH_DP_UNDEFINED = 0; // 0x0

/** Constant for {@link #touchscreen}, value corresponding to the
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#TouchscreenQualifier">finger</a>
 * resource qualifier.     * @apiSince 1
 */

public static final int TOUCHSCREEN_FINGER = 3; // 0x3

/** Constant for {@link #touchscreen}, value corresponding to the
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#TouchscreenQualifier">notouch</a>
 * resource qualifier.     * @apiSince 1
 */

public static final int TOUCHSCREEN_NOTOUCH = 1; // 0x1

/**
 * @deprecated Not currently supported or used.
 * @apiSince 1
 * @deprecatedSince 16
 */

@Deprecated public static final int TOUCHSCREEN_STYLUS = 2; // 0x2

/**
 * Constant for {@link #touchscreen}: a value indicating that no value has been set.
 * @apiSince 1
 */

public static final int TOUCHSCREEN_UNDEFINED = 0; // 0x0

/**
 * Constant for {@link #uiMode}: bits that encode the night mode.
 * @apiSince 8
 */

public static final int UI_MODE_NIGHT_MASK = 48; // 0x30

/** Constant for {@link #uiMode}: a {@link #UI_MODE_NIGHT_MASK}
 * value that corresponds to the
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#NightQualifier">notnight</a>
 * resource qualifier.     * @apiSince 8
 */

public static final int UI_MODE_NIGHT_NO = 16; // 0x10

/** Constant for {@link #uiMode}: a {@link #UI_MODE_NIGHT_MASK}
 * value indicating that no mode type has been set.     * @apiSince 8
 */

public static final int UI_MODE_NIGHT_UNDEFINED = 0; // 0x0

/** Constant for {@link #uiMode}: a {@link #UI_MODE_NIGHT_MASK}
 * value that corresponds to the
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#NightQualifier">night</a>
 * resource qualifier.     * @apiSince 8
 */

public static final int UI_MODE_NIGHT_YES = 32; // 0x20

/** Constant for {@link #uiMode}: a {@link #UI_MODE_TYPE_MASK}
 * value that corresponds to the
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#UiModeQualifier">appliance</a>
 * resource qualifier.     * @apiSince 16
 */

public static final int UI_MODE_TYPE_APPLIANCE = 5; // 0x5

/** Constant for {@link #uiMode}: a {@link #UI_MODE_TYPE_MASK}
 * value that corresponds to the
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#UiModeQualifier">car</a>
 * resource qualifier.     * @apiSince 8
 */

public static final int UI_MODE_TYPE_CAR = 3; // 0x3

/** Constant for {@link #uiMode}: a {@link #UI_MODE_TYPE_MASK}
 * value that corresponds to the
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#UiModeQualifier">desk</a>
 * resource qualifier.     * @apiSince 8
 */

public static final int UI_MODE_TYPE_DESK = 2; // 0x2

/**
 * Constant for {@link #uiMode}: bits that encode the mode type.
 * @apiSince 8
 */

public static final int UI_MODE_TYPE_MASK = 15; // 0xf

/** Constant for {@link #uiMode}: a {@link #UI_MODE_TYPE_MASK}
 * value that corresponds to
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#UiModeQualifier">no
 * UI mode</a> resource qualifier specified.     * @apiSince 8
 */

public static final int UI_MODE_TYPE_NORMAL = 1; // 0x1

/** Constant for {@link #uiMode}: a {@link #UI_MODE_TYPE_MASK}
 * value that corresponds to the
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#UiModeQualifier">television</a>
 * resource qualifier.     * @apiSince 13
 */

public static final int UI_MODE_TYPE_TELEVISION = 4; // 0x4

/** Constant for {@link #uiMode}: a {@link #UI_MODE_TYPE_MASK}
 * value indicating that no mode type has been set.     * @apiSince 8
 */

public static final int UI_MODE_TYPE_UNDEFINED = 0; // 0x0

/** Constant for {@link #uiMode}: a {@link #UI_MODE_TYPE_MASK}
 * value that corresponds to the
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#UiModeQualifier">vrheadset</a>
 * resource qualifier.     * @apiSince 26
 */

public static final int UI_MODE_TYPE_VR_HEADSET = 7; // 0x7

/** Constant for {@link #uiMode}: a {@link #UI_MODE_TYPE_MASK}
 * value that corresponds to the
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#UiModeQualifier">watch</a>
 * resource qualifier.     * @apiSince 20
 */

public static final int UI_MODE_TYPE_WATCH = 6; // 0x6

/**
 * Bit mask of color capabilities of the screen. Currently there are two fields:
 * <p>The {@link #COLOR_MODE_WIDE_COLOR_GAMUT_MASK} bits define the color gamut of
 * the screen. They may be one of
 * {@link #COLOR_MODE_WIDE_COLOR_GAMUT_NO} or {@link #COLOR_MODE_WIDE_COLOR_GAMUT_YES}.</p>
 *
 * <p>The {@link #COLOR_MODE_HDR_MASK} defines the dynamic range of the screen. They may be
 * one of {@link #COLOR_MODE_HDR_NO} or {@link #COLOR_MODE_HDR_YES}.</p>
 *
 * <p>See <a href="{@docRoot}guide/practices/screens_support.html">Supporting
 * Multiple Screens</a> for more information.</p>
 * @apiSince 26
 */

public int colorMode;

/**
 * The target screen density being rendered to,
 * corresponding to
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#DensityQualifier">density</a>
 * resource qualifier.  Set to
 * {@link #DENSITY_DPI_UNDEFINED} if no density is specified.
 * @apiSince 17
 */

public int densityDpi;

/**
 * Current user preference for the scaling factor for fonts, relative
 * to the base density scaling.
 * @apiSince 1
 */

public float fontScale;

/**
 * A flag indicating whether the hard keyboard has been hidden.  This will
 * be set on a device with a mechanism to hide the keyboard from the
 * user, when that mechanism is closed.  One of:
 * {@link #HARDKEYBOARDHIDDEN_NO}, {@link #HARDKEYBOARDHIDDEN_YES}.
 * @apiSince 3
 */

public int hardKeyboardHidden;

/**
 * The kind of keyboard attached to the device.
 * One of: {@link #KEYBOARD_NOKEYS}, {@link #KEYBOARD_QWERTY},
 * {@link #KEYBOARD_12KEY}.
 * @apiSince 1
 */

public int keyboard;

/**
 * A flag indicating whether any keyboard is available.  Unlike
 * {@link #hardKeyboardHidden}, this also takes into account a soft
 * keyboard, so if the hard keyboard is hidden but there is soft
 * keyboard available, it will be set to NO.  Value is one of:
 * {@link #KEYBOARDHIDDEN_NO}, {@link #KEYBOARDHIDDEN_YES}.
 * @apiSince 1
 */

public int keyboardHidden;

/**
 * Current user preference for the locale, corresponding to
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#LocaleQualifier">locale</a>
 * resource qualifier.
 *
 * @deprecated Do not set or read this directly. Use {@link #getLocales()} and
 * {@link #setLocales(android.os.LocaleList)}. If only the primary locale is needed,
 * <code>getLocales().get(0)</code> is now the preferred accessor.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated public java.util.Locale locale;

/**
 * IMSI MCC (Mobile Country Code), corresponding to
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#MccQualifier">mcc</a>
 * resource qualifier.  0 if undefined.
 * @apiSince 1
 */

public int mcc;

/**
 * IMSI MNC (Mobile Network Code), corresponding to
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#MccQualifier">mnc</a>
 * resource qualifier.  0 if undefined. Note that the actual MNC may be 0; in order to check
 * for this use the {@link #MNC_ZERO} symbol.
 * @apiSince 1
 */

public int mnc;

/**
 * The kind of navigation method available on the device.
 * One of: {@link #NAVIGATION_NONAV}, {@link #NAVIGATION_DPAD},
 * {@link #NAVIGATION_TRACKBALL}, {@link #NAVIGATION_WHEEL}.
 * @apiSince 1
 */

public int navigation;

/**
 * A flag indicating whether any 5-way or DPAD navigation available.
 * This will be set on a device with a mechanism to hide the navigation
 * controls from the user, when that mechanism is closed.  One of:
 * {@link #NAVIGATIONHIDDEN_NO}, {@link #NAVIGATIONHIDDEN_YES}.
 * @apiSince 5
 */

public int navigationHidden;

/**
 * Overall orientation of the screen.  May be one of
 * {@link #ORIENTATION_LANDSCAPE}, {@link #ORIENTATION_PORTRAIT}.
 * @apiSince 1
 */

public int orientation;

/**
 * The current height of the available screen space, in dp units,
 * corresponding to
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#ScreenHeightQualifier">screen
 * height</a> resource qualifier.  Set to
 * {@link #SCREEN_HEIGHT_DP_UNDEFINED} if no height is specified.
 * @apiSince 13
 */

public int screenHeightDp;

/**
 * Bit mask of overall layout of the screen.  Currently there are four
 * fields:
 * <p>The {@link #SCREENLAYOUT_SIZE_MASK} bits define the overall size
 * of the screen.  They may be one of
 * {@link #SCREENLAYOUT_SIZE_SMALL}, {@link #SCREENLAYOUT_SIZE_NORMAL},
 * {@link #SCREENLAYOUT_SIZE_LARGE}, or {@link #SCREENLAYOUT_SIZE_XLARGE}.</p>
 *
 * <p>The {@link #SCREENLAYOUT_LONG_MASK} defines whether the screen
 * is wider/taller than normal.  They may be one of
 * {@link #SCREENLAYOUT_LONG_NO} or {@link #SCREENLAYOUT_LONG_YES}.</p>
 *
 * <p>The {@link #SCREENLAYOUT_LAYOUTDIR_MASK} defines whether the screen layout
 * is either LTR or RTL.  They may be one of
 * {@link #SCREENLAYOUT_LAYOUTDIR_LTR} or {@link #SCREENLAYOUT_LAYOUTDIR_RTL}.</p>
 *
 * <p>The {@link #SCREENLAYOUT_ROUND_MASK} defines whether the screen has a rounded
 * shape. They may be one of {@link #SCREENLAYOUT_ROUND_NO} or {@link #SCREENLAYOUT_ROUND_YES}.
 * </p>
 *
 * <p>See <a href="{@docRoot}guide/practices/screens_support.html">Supporting
 * Multiple Screens</a> for more information.</p>
 * @apiSince 4
 */

public int screenLayout;

/**
 * The current width of the available screen space, in dp units,
 * corresponding to
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#ScreenWidthQualifier">screen
 * width</a> resource qualifier.  Set to
 * {@link #SCREEN_WIDTH_DP_UNDEFINED} if no width is specified.
 * @apiSince 13
 */

public int screenWidthDp;

/**
 * The smallest screen size an application will see in normal operation,
 * corresponding to
 * <a href="{@docRoot}guide/topics/resources/providing-resources.html#SmallestScreenWidthQualifier">smallest
 * screen width</a> resource qualifier.
 * This is the smallest value of both screenWidthDp and screenHeightDp
 * in both portrait and landscape.  Set to
 * {@link #SMALLEST_SCREEN_WIDTH_DP_UNDEFINED} if no width is specified.
 * @apiSince 13
 */

public int smallestScreenWidthDp;

/**
 * The kind of touch screen attached to the device.
 * One of: {@link #TOUCHSCREEN_NOTOUCH}, {@link #TOUCHSCREEN_FINGER}.
 * @apiSince 1
 */

public int touchscreen;

/**
 * Bit mask of the ui mode.  Currently there are two fields:
 * <p>The {@link #UI_MODE_TYPE_MASK} bits define the overall ui mode of the
 * device. They may be one of {@link #UI_MODE_TYPE_UNDEFINED},
 * {@link #UI_MODE_TYPE_NORMAL}, {@link #UI_MODE_TYPE_DESK},
 * {@link #UI_MODE_TYPE_CAR}, {@link #UI_MODE_TYPE_TELEVISION},
 * {@link #UI_MODE_TYPE_APPLIANCE}, {@link #UI_MODE_TYPE_WATCH},
 * or {@link #UI_MODE_TYPE_VR_HEADSET}.
 *
 * <p>The {@link #UI_MODE_NIGHT_MASK} defines whether the screen
 * is in a special mode. They may be one of {@link #UI_MODE_NIGHT_UNDEFINED},
 * {@link #UI_MODE_NIGHT_NO} or {@link #UI_MODE_NIGHT_YES}.
 * @apiSince 8
 */

public int uiMode;
}

