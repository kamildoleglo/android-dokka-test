/*
 * Copyright (C) 2014 The Android Open Source Project
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

import android.content.ComponentName;
import android.os.UserManager;
import android.os.UserHandle;
import android.util.DisplayMetrics;

/**
 * A representation of an activity that can belong to this user or a managed
 * profile associated with this user. It can be used to query the label, icon
 * and badged icon for the activity.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class LauncherActivityInfo {

LauncherActivityInfo() { throw new RuntimeException("Stub!"); }

/**
 * Returns the component name of this activity.
 *
 * @return ComponentName of the activity
 * @apiSince 21
 */

public android.content.ComponentName getComponentName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the user handle of the user profile that this activity belongs to. In order to
 * persist the identity of the profile, do not store the UserHandle. Instead retrieve its
 * serial number from UserManager. You can convert the serial number back to a UserHandle
 * for later use.
 *
 * @see android.os.UserManager#getSerialNumberForUser(UserHandle)
 * @see android.os.UserManager#getUserForSerialNumber(long)
 *
 * @return The UserHandle of the profile.
 * @apiSince 21
 */

public android.os.UserHandle getUser() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the label for the activity.
 *
 * @return The label for the activity.
 * @apiSince 21
 */

public java.lang.CharSequence getLabel() { throw new RuntimeException("Stub!"); }

/**
 * Returns the icon for this activity, without any badging for the profile.
 * @param density The preferred density of the icon, zero for default density. Use
 * density DPI values from {@link android.util.DisplayMetrics DisplayMetrics}.
 * @see #getBadgedIcon(int)
 * @see android.util.DisplayMetrics
 * @return The drawable associated with the activity.
 * @apiSince 21
 */

public android.graphics.drawable.Drawable getIcon(int density) { throw new RuntimeException("Stub!"); }

/**
 * Returns the application info for the appliction this activity belongs to.
 * @return
 * @apiSince 21
 */

public android.content.pm.ApplicationInfo getApplicationInfo() { throw new RuntimeException("Stub!"); }

/**
 * Returns the time at which the package was first installed.
 *
 * @return The time of installation of the package, in milliseconds.
 * @apiSince 21
 */

public long getFirstInstallTime() { throw new RuntimeException("Stub!"); }

/**
 * Returns the name for the acitivty from  android:name in the manifest.
 * @return the name from android:name for the acitivity.
 * @apiSince 21
 */

public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the activity icon with badging appropriate for the profile.
 * @param density Optional density for the icon, or 0 to use the default density. Use
 * {@link android.util.DisplayMetrics DisplayMetrics} for DPI values.
 * @see android.util.DisplayMetrics
 * @return A badged icon for the activity.
 * @apiSince 21
 */

public android.graphics.drawable.Drawable getBadgedIcon(int density) { throw new RuntimeException("Stub!"); }
}

