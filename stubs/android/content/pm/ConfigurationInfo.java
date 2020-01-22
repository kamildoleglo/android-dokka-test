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


package android.content.pm;


/**
 * Information you can retrieve about hardware configuration preferences
 * declared by an application. This corresponds to information collected from the
 * AndroidManifest.xml's &lt;uses-configuration&gt; and &lt;uses-feature&gt; tags.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ConfigurationInfo implements android.os.Parcelable {

/** @apiSince 3 */

public ConfigurationInfo() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public ConfigurationInfo(android.content.pm.ConfigurationInfo orig) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void writeToParcel(android.os.Parcel dest, int parcelableFlags) { throw new RuntimeException("Stub!"); }

/**
 * This method extracts the major and minor version of reqGLEsVersion attribute
 * and returns it as a string. Say reqGlEsVersion value of 0x00010002 is returned
 * as 1.2
 * @return String representation of the reqGlEsVersion attribute
 * @apiSince 4
 */

public java.lang.String getGlEsVersion() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.content.pm.ConfigurationInfo> CREATOR;
static { CREATOR = null; }

/**
 * Default value for {@link #reqGlEsVersion};
 * @apiSince 4
 */

public static final int GL_ES_VERSION_UNDEFINED = 0; // 0x0

/**
 * Value for {@link #reqInputFeatures}: if set, indicates that the application
 * requires a five way navigation device
 * @apiSince 3
 */

public static final int INPUT_FEATURE_FIVE_WAY_NAV = 2; // 0x2

/**
 * Value for {@link #reqInputFeatures}: if set, indicates that the application
 * requires a hard keyboard
 * @apiSince 3
 */

public static final int INPUT_FEATURE_HARD_KEYBOARD = 1; // 0x1

/**
 * The GLES version used by an application. The upper order 16 bits represent the
 * major version and the lower order 16 bits the minor version.
 * @apiSince 4
 */

public int reqGlEsVersion;

/**
 * Flags associated with the input features.  Any combination of
 * {@link #INPUT_FEATURE_HARD_KEYBOARD},
 * {@link #INPUT_FEATURE_FIVE_WAY_NAV}
 * @apiSince 3
 */

public int reqInputFeatures = 0; // 0x0

/**
 * Application's input method preference.
 * One of: {@link android.content.res.Configuration#KEYBOARD_UNDEFINED},
 * {@link android.content.res.Configuration#KEYBOARD_NOKEYS},
 * {@link android.content.res.Configuration#KEYBOARD_QWERTY},
 * {@link android.content.res.Configuration#KEYBOARD_12KEY}
 * @apiSince 3
 */

public int reqKeyboardType;

/**
 * A flag indicating whether any keyboard is available.
 * one of: {@link android.content.res.Configuration#NAVIGATION_UNDEFINED},
 * {@link android.content.res.Configuration#NAVIGATION_DPAD},
 * {@link android.content.res.Configuration#NAVIGATION_TRACKBALL},
 * {@link android.content.res.Configuration#NAVIGATION_WHEEL}
 * @apiSince 3
 */

public int reqNavigation;

/**
 * The kind of touch screen attached to the device.
 * One of: {@link android.content.res.Configuration#TOUCHSCREEN_NOTOUCH},
 * {@link android.content.res.Configuration#TOUCHSCREEN_STYLUS},
 * {@link android.content.res.Configuration#TOUCHSCREEN_FINGER}.
 * @apiSince 3
 */

public int reqTouchScreen;
}

