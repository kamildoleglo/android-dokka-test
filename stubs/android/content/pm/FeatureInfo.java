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


package android.content.pm;


/**
 * Definition of a single optional hardware or software feature of an Android
 * device.
 * <p>
 * This object is used to represent both features supported by a device and
 * features requested by an app. Apps can request that certain features be
 * available as a prerequisite to being installed through the
 * {@code uses-feature} tag in their manifests.
 * <p>
 * Starting in {@link android.os.Build.VERSION_CODES#N}, features can have a
 * version, which must always be backwards compatible. That is, a device
 * claiming to support version 3 of a specific feature must support apps
 * requesting version 1 of that feature.
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class FeatureInfo implements android.os.Parcelable {

/** @apiSince 5 */

public FeatureInfo() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public FeatureInfo(android.content.pm.FeatureInfo orig) { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public void writeToParcel(android.os.Parcel dest, int parcelableFlags) { throw new RuntimeException("Stub!"); }

/**
 * This method extracts the major and minor version of reqGLEsVersion attribute
 * and returns it as a string. Say reqGlEsVersion value of 0x00010002 is returned
 * as 1.2
 * @return String representation of the reqGlEsVersion attribute
 * @apiSince 5
 */

public java.lang.String getGlEsVersion() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.content.pm.FeatureInfo> CREATOR;
static { CREATOR = null; }

/**
 * Set on {@link #flags} if this feature has been required by the application.
 * @apiSince 5
 */

public static final int FLAG_REQUIRED = 1; // 0x1

/**
 * Default value for {@link #reqGlEsVersion};
 * @apiSince 5
 */

public static final int GL_ES_VERSION_UNDEFINED = 0; // 0x0

/**
 * Additional flags.  May be zero or more of {@link #FLAG_REQUIRED}.
 * @apiSince 5
 */

public int flags;

/**
 * The name of this feature, for example "android.hardware.camera".  If
 * this is null, then this is an OpenGL ES version feature as described
 * in {@link #reqGlEsVersion}.
 * @apiSince 5
 */

public java.lang.String name;

/**
 * The GLES version used by an application. The upper order 16 bits represent the
 * major version and the lower order 16 bits the minor version.  Only valid
 * if {@link #name} is null.
 * @apiSince 5
 */

public int reqGlEsVersion;

/**
 * If this object represents a feature supported by a device, this is the
 * maximum version of this feature supported by the device. The device
 * implicitly supports all older versions of this feature.
 * <p>
 * If this object represents a feature requested by an app, this is the
 * minimum version of the feature required by the app.
 * <p>
 * When a feature version is undefined by a device, it's assumed to be
 * version 0.
 * @apiSince 24
 */

public int version;
}

