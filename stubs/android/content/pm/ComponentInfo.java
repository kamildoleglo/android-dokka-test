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

import android.os.Parcelable;

/**
 * Base class containing information common to all application components
 * ({@link android.content.pm.ActivityInfo ActivityInfo}, {@link android.content.pm.ServiceInfo ServiceInfo}).  This class is not intended
 * to be used by itself; it is simply here to share common definitions
 * between all application components.  As such, it does not itself
 * implement Parcelable, but does provide convenience methods to assist
 * in the implementation of Parcelable in subclasses.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ComponentInfo extends android.content.pm.PackageItemInfo {

/** @apiSince 1 */

public ComponentInfo() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public ComponentInfo(android.content.pm.ComponentInfo orig) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected ComponentInfo(android.os.Parcel source) { throw new RuntimeException("Stub!"); }

/**
 * Return whether this component and its enclosing application are enabled.
 * @apiSince 11
 */

public boolean isEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Return the icon resource identifier to use for this component.  If
 * the component defines an icon, that is used; else, the application
 * icon is used.
 *
 * @return The icon associated with this component.
 * @apiSince 1
 */

public final int getIconResource() { throw new RuntimeException("Stub!"); }

/**
 * Return the logo resource identifier to use for this component.  If
 * the component defines a logo, that is used; else, the application
 * logo is used.
 *
 * @return The logo associated with this component.
 * @apiSince 19
 */

public final int getLogoResource() { throw new RuntimeException("Stub!"); }

/**
 * Return the banner resource identifier to use for this component. If the
 * component defines a banner, that is used; else, the application banner is
 * used.
 *
 * @return The banner associated with this component.
 * @apiSince 20
 */

public final int getBannerResource() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void dumpFront(android.util.Printer pw, java.lang.String prefix) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void dumpBack(android.util.Printer pw, java.lang.String prefix) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void writeToParcel(android.os.Parcel dest, int parcelableFlags) { throw new RuntimeException("Stub!"); }

/**
 * Global information about the application/package this component is a
 * part of.
 * @apiSince 1
 */

public android.content.pm.ApplicationInfo applicationInfo;

/**
 * A string resource identifier (in the package's resources) containing
 * a user-readable description of the component.  From the "description"
 * attribute or, if not set, 0.
 * @apiSince 8
 */

public int descriptionRes;

/**
 * Indicates if this component is aware of direct boot lifecycle, and can be
 * safely run before the user has entered their credentials (such as a lock
 * pattern or PIN).
 * @apiSince 24
 */

public boolean directBootAware = false;

/**
 * Indicates whether or not this component may be instantiated.  Note that this value can be
 * overridden by the one in its parent {@link android.content.pm.ApplicationInfo ApplicationInfo}.
 * @apiSince 1
 */

public boolean enabled = true;

/**
 * Set to true if this component is available for use by other applications.
 * Comes from {@link android.R.attr#exported android:exported} of the
 * &lt;activity&gt;, &lt;receiver&gt;, &lt;service&gt;, or
 * &lt;provider&gt; tag.
 * @apiSince 1
 */

public boolean exported = false;

/**
 * The name of the process this component should run in.
 * From the "android:process" attribute or, if not set, the same
 * as <var>applicationInfo.processName</var>.
 * @apiSince 1
 */

public java.lang.String processName;

/**
 * The name of the split in which this component is declared.
 * Null if the component was declared in the base APK.
 * @apiSince 26
 */

public java.lang.String splitName;
}

