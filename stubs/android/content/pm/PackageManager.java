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


package android.content.pm;

import android.content.Context;
import android.content.Intent;
import android.os.UserHandle;
import java.util.List;
import android.content.ComponentName;
import android.graphics.drawable.Drawable;
import android.graphics.Rect;
import android.content.res.Resources;
import android.content.IntentFilter;
import java.util.Set;
import android.os.Bundle;
import android.Manifest;
import android.os.UserManager;
import android.app.ActivityManager;
import android.net.wifi.WifiManager;
import android.app.admin.DevicePolicyManager;

/**
 * Class for retrieving various kinds of information related to the application
 * packages that are currently installed on the device.
 *
 * You can find this class through {@link android.content.Context#getPackageManager Context#getPackageManager}.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class PackageManager {

public PackageManager() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve overall information about an application package that is
 * installed on the system.
 *
 * @param packageName The full name (i.e. com.google.apps.contacts) of the
 *            desired package.
 * This value must never be {@code null}.
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_ACTIVITIES}, {@link android.content.pm.PackageManager#GET_CONFIGURATIONS}, {@link android.content.pm.PackageManager#GET_GIDS}, {@link android.content.pm.PackageManager#GET_INSTRUMENTATION}, {@link android.content.pm.PackageManager#GET_INTENT_FILTERS}, {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_PERMISSIONS}, {@link android.content.pm.PackageManager#GET_PROVIDERS}, {@link android.content.pm.PackageManager#GET_RECEIVERS}, {@link android.content.pm.PackageManager#GET_SERVICES}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#GET_SIGNATURES}, {@link android.content.pm.PackageManager#GET_SIGNING_CERTIFICATES}, {@link android.content.pm.PackageManager#GET_URI_PERMISSION_PATTERNS}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, android.content.pm.PackageManager.MATCH_FACTORY_ONLY, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, android.content.pm.PackageManager.MATCH_INSTANT, {@link android.content.pm.PackageManager#MATCH_APEX}, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}, and android.content.pm.PackageManager.MATCH_HIDDEN_UNTIL_INSTALLED_COMPONENTS
 * @return A PackageInfo object containing information about the package. If
 *         flag {@code MATCH_UNINSTALLED_PACKAGES} is set and if the package
 *         is not found in the list of installed applications, the package
 *         information is retrieved from the list of uninstalled
 *         applications (which includes installed applications as well as
 *         applications with data directory i.e. applications which had been
 *         deleted with {@code DONT_DELETE_DATA} flag set).
 * @throws android.content.pm.PackageManager.NameNotFoundException if a package with the given name cannot be
 *             found on the system.
 * @apiSince 1
 */

public abstract android.content.pm.PackageInfo getPackageInfo(@androidx.annotation.NonNull java.lang.String packageName, int flags) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve overall information about an application package that is
 * installed on the system. This method can be used for retrieving
 * information about packages for which multiple versions can be installed
 * at the time. Currently only packages hosting static shared libraries can
 * have multiple installed versions. The method can also be used to get info
 * for a package that has a single version installed by passing
 * {@link #VERSION_CODE_HIGHEST} in the {@link android.content.pm.VersionedPackage VersionedPackage}
 * constructor.
 *
 * @param versionedPackage The versioned package for which to query.
 * This value must never be {@code null}.
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_ACTIVITIES}, {@link android.content.pm.PackageManager#GET_CONFIGURATIONS}, {@link android.content.pm.PackageManager#GET_GIDS}, {@link android.content.pm.PackageManager#GET_INSTRUMENTATION}, {@link android.content.pm.PackageManager#GET_INTENT_FILTERS}, {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_PERMISSIONS}, {@link android.content.pm.PackageManager#GET_PROVIDERS}, {@link android.content.pm.PackageManager#GET_RECEIVERS}, {@link android.content.pm.PackageManager#GET_SERVICES}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#GET_SIGNATURES}, {@link android.content.pm.PackageManager#GET_SIGNING_CERTIFICATES}, {@link android.content.pm.PackageManager#GET_URI_PERMISSION_PATTERNS}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, android.content.pm.PackageManager.MATCH_FACTORY_ONLY, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, android.content.pm.PackageManager.MATCH_INSTANT, {@link android.content.pm.PackageManager#MATCH_APEX}, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}, and android.content.pm.PackageManager.MATCH_HIDDEN_UNTIL_INSTALLED_COMPONENTS
 * @return A PackageInfo object containing information about the package. If
 *         flag {@code MATCH_UNINSTALLED_PACKAGES} is set and if the package
 *         is not found in the list of installed applications, the package
 *         information is retrieved from the list of uninstalled
 *         applications (which includes installed applications as well as
 *         applications with data directory i.e. applications which had been
 *         deleted with {@code DONT_DELETE_DATA} flag set).
 * @throws android.content.pm.PackageManager.NameNotFoundException if a package with the given name cannot be
 *             found on the system.
 * @apiSince 26
 */

public abstract android.content.pm.PackageInfo getPackageInfo(@androidx.annotation.NonNull android.content.pm.VersionedPackage versionedPackage, int flags) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Map from the current package names in use on the device to whatever
 * the current canonical name of that package is.
 * @param packageNames Array of current names to be mapped.
 * This value must never be {@code null}.
 * @return Returns an array of the same size as the original, containing
 * the canonical name for each package.
 * @apiSince 8
 */

public abstract java.lang.String[] currentToCanonicalPackageNames(@androidx.annotation.NonNull java.lang.String[] packageNames);

/**
 * Map from a packages canonical name to the current name in use on the device.
 * @param packageNames Array of new names to be mapped.
 * This value must never be {@code null}.
 * @return Returns an array of the same size as the original, containing
 * the current name for each package.
 * @apiSince 8
 */

public abstract java.lang.String[] canonicalToCurrentPackageNames(@androidx.annotation.NonNull java.lang.String[] packageNames);

/**
 * Returns a "good" intent to launch a front-door activity in a package.
 * This is used, for example, to implement an "open" button when browsing
 * through packages.  The current implementation looks first for a main
 * activity in the category {@link android.content.Intent#CATEGORY_INFO Intent#CATEGORY_INFO}, and next for a
 * main activity in the category {@link android.content.Intent#CATEGORY_LAUNCHER Intent#CATEGORY_LAUNCHER}. Returns
 * <code>null</code> if neither are found.
 *
 * @param packageName The name of the package to inspect.
 *
 * This value must never be {@code null}.
 * @return A fully-qualified {@link android.content.Intent Intent} that can be used to launch the
 * main activity in the package. Returns <code>null</code> if the package
 * does not contain such an activity, or if <em>packageName</em> is not
 * recognized.
 * @apiSince 3
 */

@androidx.annotation.Nullable
public abstract android.content.Intent getLaunchIntentForPackage(@androidx.annotation.NonNull java.lang.String packageName);

/**
 * Return a "good" intent to launch a front-door Leanback activity in a
 * package, for use for example to implement an "open" button when browsing
 * through packages. The current implementation will look for a main
 * activity in the category {@link android.content.Intent#CATEGORY_LEANBACK_LAUNCHER Intent#CATEGORY_LEANBACK_LAUNCHER}, or
 * return null if no main leanback activities are found.
 *
 * @param packageName The name of the package to inspect.
 * This value must never be {@code null}.
 * @return Returns either a fully-qualified Intent that can be used to launch
 *         the main Leanback activity in the package, or null if the package
 *         does not contain such an activity.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public abstract android.content.Intent getLeanbackLaunchIntentForPackage(@androidx.annotation.NonNull java.lang.String packageName);

/**
 * Return an array of all of the POSIX secondary group IDs that have been
 * assigned to the given package.
 * <p>
 * Note that the same package may have different GIDs under different
 * {@link android.os.UserHandle UserHandle} on the same device.
 *
 * @param packageName The full name (i.e. com.google.apps.contacts) of the
 *            desired package.
 * This value must never be {@code null}.
 * @return Returns an int array of the assigned GIDs, or null if there are
 *         none.
 * @throws android.content.pm.PackageManager.NameNotFoundException if a package with the given name cannot be
 *             found on the system.
 * @apiSince 1
 */

public abstract int[] getPackageGids(@androidx.annotation.NonNull java.lang.String packageName) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Return an array of all of the POSIX secondary group IDs that have been
 * assigned to the given package.
 * <p>
 * Note that the same package may have different GIDs under different
 * {@link android.os.UserHandle UserHandle} on the same device.
 *
 * @param packageName The full name (i.e. com.google.apps.contacts) of the
 *            desired package.
 * This value must never be {@code null}.
 * @param flags Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_ACTIVITIES}, {@link android.content.pm.PackageManager#GET_CONFIGURATIONS}, {@link android.content.pm.PackageManager#GET_GIDS}, {@link android.content.pm.PackageManager#GET_INSTRUMENTATION}, {@link android.content.pm.PackageManager#GET_INTENT_FILTERS}, {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_PERMISSIONS}, {@link android.content.pm.PackageManager#GET_PROVIDERS}, {@link android.content.pm.PackageManager#GET_RECEIVERS}, {@link android.content.pm.PackageManager#GET_SERVICES}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#GET_SIGNATURES}, {@link android.content.pm.PackageManager#GET_SIGNING_CERTIFICATES}, {@link android.content.pm.PackageManager#GET_URI_PERMISSION_PATTERNS}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, android.content.pm.PackageManager.MATCH_FACTORY_ONLY, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, android.content.pm.PackageManager.MATCH_INSTANT, {@link android.content.pm.PackageManager#MATCH_APEX}, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}, and android.content.pm.PackageManager.MATCH_HIDDEN_UNTIL_INSTALLED_COMPONENTS
 * @return Returns an int array of the assigned gids, or null if there are
 *         none.
 * @throws android.content.pm.PackageManager.NameNotFoundException if a package with the given name cannot be
 *             found on the system.
 * @apiSince 24
 */

public abstract int[] getPackageGids(@androidx.annotation.NonNull java.lang.String packageName, int flags) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Return the UID associated with the given package name.
 * <p>
 * Note that the same package will have different UIDs under different
 * {@link android.os.UserHandle UserHandle} on the same device.
 *
 * @param packageName The full name (i.e. com.google.apps.contacts) of the
 *            desired package.
 * This value must never be {@code null}.
 * @param flags Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_ACTIVITIES}, {@link android.content.pm.PackageManager#GET_CONFIGURATIONS}, {@link android.content.pm.PackageManager#GET_GIDS}, {@link android.content.pm.PackageManager#GET_INSTRUMENTATION}, {@link android.content.pm.PackageManager#GET_INTENT_FILTERS}, {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_PERMISSIONS}, {@link android.content.pm.PackageManager#GET_PROVIDERS}, {@link android.content.pm.PackageManager#GET_RECEIVERS}, {@link android.content.pm.PackageManager#GET_SERVICES}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#GET_SIGNATURES}, {@link android.content.pm.PackageManager#GET_SIGNING_CERTIFICATES}, {@link android.content.pm.PackageManager#GET_URI_PERMISSION_PATTERNS}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, android.content.pm.PackageManager.MATCH_FACTORY_ONLY, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, android.content.pm.PackageManager.MATCH_INSTANT, {@link android.content.pm.PackageManager#MATCH_APEX}, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}, and android.content.pm.PackageManager.MATCH_HIDDEN_UNTIL_INSTALLED_COMPONENTS
 * @return Returns an integer UID who owns the given package name.
 * @throws android.content.pm.PackageManager.NameNotFoundException if a package with the given name can not be
 *             found on the system.
 * @apiSince 24
 */

public abstract int getPackageUid(@androidx.annotation.NonNull java.lang.String packageName, int flags) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve all of the information we know about a particular permission.
 *
 * @param permissionName The fully qualified name (i.e. com.google.permission.LOGIN)
 *            of the permission you are interested in.
 * This value must never be {@code null}.
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or {@link android.content.pm.PackageManager#GET_META_DATA}
 * @return Returns a {@link android.content.pm.PermissionInfo PermissionInfo} containing information about the
 *         permission.
 * @throws android.content.pm.PackageManager.NameNotFoundException if a package with the given name cannot be
 *             found on the system.
 * @apiSince 1
 */

public abstract android.content.pm.PermissionInfo getPermissionInfo(@androidx.annotation.NonNull java.lang.String permissionName, int flags) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Query for all of the permissions associated with a particular group.
 *
 * @param permissionGroup The fully qualified name (i.e. com.google.permission.LOGIN)
 *            of the permission group you are interested in. Use null to
 *            find all of the permissions not associated with a group.
 * This value must never be {@code null}.
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or {@link android.content.pm.PackageManager#GET_META_DATA}
 * @return Returns a list of {@link android.content.pm.PermissionInfo PermissionInfo} containing information
 *         about all of the permissions in the given group.
 * @throws android.content.pm.PackageManager.NameNotFoundException if a package with the given name cannot be
 *             found on the system.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public abstract java.util.List<android.content.pm.PermissionInfo> queryPermissionsByGroup(@androidx.annotation.NonNull java.lang.String permissionGroup, int flags) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve all of the information we know about a particular group of
 * permissions.
 *
 * @param permissionName The fully qualified name (i.e.
 *            com.google.permission_group.APPS) of the permission you are
 *            interested in.
 * This value must never be {@code null}.
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or {@link android.content.pm.PackageManager#GET_META_DATA}
 * @return Returns a {@link android.content.pm.PermissionGroupInfo PermissionGroupInfo} containing information
 *         about the permission.
 * This value will never be {@code null}.
 * @throws android.content.pm.PackageManager.NameNotFoundException if a package with the given name cannot be
 *             found on the system.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public abstract android.content.pm.PermissionGroupInfo getPermissionGroupInfo(@androidx.annotation.NonNull java.lang.String permissionName, int flags) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve all of the known permission groups in the system.
 *
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or {@link android.content.pm.PackageManager#GET_META_DATA}
 * @return Returns a list of {@link android.content.pm.PermissionGroupInfo PermissionGroupInfo} containing
 *         information about all of the known permission groups.
 
 * This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public abstract java.util.List<android.content.pm.PermissionGroupInfo> getAllPermissionGroups(int flags);

/**
 * Retrieve all of the information we know about a particular
 * package/application.
 *
 * @param packageName The full name (i.e. com.google.apps.contacts) of an
 *            application.
 * This value must never be {@code null}.
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, android.content.pm.PackageManager.MATCH_INSTANT, android.content.pm.PackageManager.MATCH_STATIC_SHARED_LIBRARIES, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}, and android.content.pm.PackageManager.MATCH_HIDDEN_UNTIL_INSTALLED_COMPONENTS
 * @return An {@link android.content.pm.ApplicationInfo ApplicationInfo} containing information about the
 *         package. If flag {@code MATCH_UNINSTALLED_PACKAGES} is set and if
 *         the package is not found in the list of installed applications,
 *         the application information is retrieved from the list of
 *         uninstalled applications (which includes installed applications
 *         as well as applications with data directory i.e. applications
 *         which had been deleted with {@code DONT_DELETE_DATA} flag set).
 * This value will never be {@code null}.
 * @throws android.content.pm.PackageManager.NameNotFoundException if a package with the given name cannot be
 *             found on the system.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public abstract android.content.pm.ApplicationInfo getApplicationInfo(@androidx.annotation.NonNull java.lang.String packageName, int flags) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve all of the information we know about a particular activity
 * class.
 *
 * @param component The full component name (i.e.
 *            com.google.apps.contacts/com.google.apps.contacts.
 *            ContactsList) of an Activity class.
 * This value must never be {@code null}.
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#MATCH_ALL}, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, {@link android.content.pm.PackageManager#MATCH_DEFAULT_ONLY}, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AUTO}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AWARE}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_UNAWARE}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, android.content.pm.PackageManager.MATCH_INSTANT, android.content.pm.PackageManager.MATCH_STATIC_SHARED_LIBRARIES, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, and {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}
 * @return An {@link android.content.pm.ActivityInfo ActivityInfo} containing information about the
 *         activity.
 * This value will never be {@code null}.
 * @throws android.content.pm.PackageManager.NameNotFoundException if a package with the given name cannot be
 *             found on the system.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public abstract android.content.pm.ActivityInfo getActivityInfo(@androidx.annotation.NonNull android.content.ComponentName component, int flags) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve all of the information we know about a particular receiver
 * class.
 *
 * @param component The full component name (i.e.
 *            com.google.apps.calendar/com.google.apps.calendar.
 *            CalendarAlarm) of a Receiver class.
 * This value must never be {@code null}.
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#MATCH_ALL}, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, {@link android.content.pm.PackageManager#MATCH_DEFAULT_ONLY}, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AUTO}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AWARE}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_UNAWARE}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, android.content.pm.PackageManager.MATCH_INSTANT, android.content.pm.PackageManager.MATCH_STATIC_SHARED_LIBRARIES, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, and {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}
 * @return An {@link android.content.pm.ActivityInfo ActivityInfo} containing information about the
 *         receiver.
 * This value will never be {@code null}.
 * @throws android.content.pm.PackageManager.NameNotFoundException if a package with the given name cannot be
 *             found on the system.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public abstract android.content.pm.ActivityInfo getReceiverInfo(@androidx.annotation.NonNull android.content.ComponentName component, int flags) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve all of the information we know about a particular service class.
 *
 * @param component The full component name (i.e.
 *            com.google.apps.media/com.google.apps.media.
 *            BackgroundPlayback) of a Service class.
 * This value must never be {@code null}.
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#MATCH_ALL}, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, {@link android.content.pm.PackageManager#MATCH_DEFAULT_ONLY}, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AUTO}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AWARE}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_UNAWARE}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, android.content.pm.PackageManager.MATCH_INSTANT, android.content.pm.PackageManager.MATCH_STATIC_SHARED_LIBRARIES, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, and {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}
 * @return A {@link android.content.pm.ServiceInfo ServiceInfo} object containing information about the
 *         service.
 * This value will never be {@code null}.
 * @throws android.content.pm.PackageManager.NameNotFoundException if a package with the given name cannot be
 *             found on the system.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public abstract android.content.pm.ServiceInfo getServiceInfo(@androidx.annotation.NonNull android.content.ComponentName component, int flags) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve all of the information we know about a particular content
 * provider class.
 *
 * @param component The full component name (i.e.
 *            com.google.providers.media/com.google.providers.media.
 *            MediaProvider) of a ContentProvider class.
 * This value must never be {@code null}.
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#MATCH_ALL}, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, {@link android.content.pm.PackageManager#MATCH_DEFAULT_ONLY}, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AUTO}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AWARE}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_UNAWARE}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, android.content.pm.PackageManager.MATCH_INSTANT, android.content.pm.PackageManager.MATCH_STATIC_SHARED_LIBRARIES, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, and {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}
 * @return A {@link android.content.pm.ProviderInfo ProviderInfo} object containing information about the
 *         provider.
 * This value will never be {@code null}.
 * @throws android.content.pm.PackageManager.NameNotFoundException if a package with the given name cannot be
 *             found on the system.
 * @apiSince 9
 */

@androidx.annotation.NonNull
public abstract android.content.pm.ProviderInfo getProviderInfo(@androidx.annotation.NonNull android.content.ComponentName component, int flags) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve information for a particular module.
 *
 * @param packageName The name of the module.
 * This value must never be {@code null}.
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or {@link android.content.pm.PackageManager#MATCH_ALL}
 * @return A {@link android.content.pm.ModuleInfo ModuleInfo} object containing information about the
 *         module.
 * This value will never be {@code null}.
 * @throws android.content.pm.PackageManager.NameNotFoundException if a module with the given name cannot be
 *             found on the system.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.content.pm.ModuleInfo getModuleInfo(@androidx.annotation.NonNull java.lang.String packageName, int flags) throws android.content.pm.PackageManager.NameNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Return a List of all modules that are installed.
 *
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or {@link android.content.pm.PackageManager#MATCH_ALL}
 * @return A {@link java.util.List List} of {@link android.content.pm.ModuleInfo ModuleInfo} objects, one for each installed
 *         module, containing information about the module. In the unlikely case
 *         there are no installed modules, an empty list is returned.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.util.List<android.content.pm.ModuleInfo> getInstalledModules(int flags) { throw new RuntimeException("Stub!"); }

/**
 * Return a List of all packages that are installed for the current user.
 *
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_ACTIVITIES}, {@link android.content.pm.PackageManager#GET_CONFIGURATIONS}, {@link android.content.pm.PackageManager#GET_GIDS}, {@link android.content.pm.PackageManager#GET_INSTRUMENTATION}, {@link android.content.pm.PackageManager#GET_INTENT_FILTERS}, {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_PERMISSIONS}, {@link android.content.pm.PackageManager#GET_PROVIDERS}, {@link android.content.pm.PackageManager#GET_RECEIVERS}, {@link android.content.pm.PackageManager#GET_SERVICES}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#GET_SIGNATURES}, {@link android.content.pm.PackageManager#GET_SIGNING_CERTIFICATES}, {@link android.content.pm.PackageManager#GET_URI_PERMISSION_PATTERNS}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, android.content.pm.PackageManager.MATCH_FACTORY_ONLY, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, android.content.pm.PackageManager.MATCH_INSTANT, {@link android.content.pm.PackageManager#MATCH_APEX}, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}, and android.content.pm.PackageManager.MATCH_HIDDEN_UNTIL_INSTALLED_COMPONENTS
 * @return A List of PackageInfo objects, one for each installed package,
 *         containing information about the package. In the unlikely case
 *         there are no installed packages, an empty list is returned. If
 *         flag {@code MATCH_UNINSTALLED_PACKAGES} is set, the package
 *         information is retrieved from the list of uninstalled
 *         applications (which includes installed applications as well as
 *         applications with data directory i.e. applications which had been
 *         deleted with {@code DONT_DELETE_DATA} flag set).
 
 * This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public abstract java.util.List<android.content.pm.PackageInfo> getInstalledPackages(int flags);

/**
 * Return a List of all installed packages that are currently holding any of
 * the given permissions.
 *
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_ACTIVITIES}, {@link android.content.pm.PackageManager#GET_CONFIGURATIONS}, {@link android.content.pm.PackageManager#GET_GIDS}, {@link android.content.pm.PackageManager#GET_INSTRUMENTATION}, {@link android.content.pm.PackageManager#GET_INTENT_FILTERS}, {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_PERMISSIONS}, {@link android.content.pm.PackageManager#GET_PROVIDERS}, {@link android.content.pm.PackageManager#GET_RECEIVERS}, {@link android.content.pm.PackageManager#GET_SERVICES}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#GET_SIGNATURES}, {@link android.content.pm.PackageManager#GET_SIGNING_CERTIFICATES}, {@link android.content.pm.PackageManager#GET_URI_PERMISSION_PATTERNS}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, android.content.pm.PackageManager.MATCH_FACTORY_ONLY, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, android.content.pm.PackageManager.MATCH_INSTANT, {@link android.content.pm.PackageManager#MATCH_APEX}, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}, and android.content.pm.PackageManager.MATCH_HIDDEN_UNTIL_INSTALLED_COMPONENTS
 * @param permissions This value must never be {@code null}.
 * @return A List of PackageInfo objects, one for each installed package
 *         that holds any of the permissions that were provided, containing
 *         information about the package. If no installed packages hold any
 *         of the permissions, an empty list is returned. If flag
 *         {@code MATCH_UNINSTALLED_PACKAGES} is set, the package
 *         information is retrieved from the list of uninstalled
 *         applications (which includes installed applications as well as
 *         applications with data directory i.e. applications which had been
 *         deleted with {@code DONT_DELETE_DATA} flag set).
 
 * This value will never be {@code null}.
 * @apiSince 18
 */

@androidx.annotation.NonNull
public abstract java.util.List<android.content.pm.PackageInfo> getPackagesHoldingPermissions(@androidx.annotation.NonNull java.lang.String[] permissions, int flags);

/**
 * Check whether a particular package has been granted a particular
 * permission.
 *
 * @param permissionName The name of the permission you are checking for.
 * This value must never be {@code null}.
 * @param packageName The name of the package you are checking against.
 *
 * This value must never be {@code null}.
 * @return If the package has the permission, PERMISSION_GRANTED is
 * returned.  If it does not have the permission, PERMISSION_DENIED
 * is returned.
 *
 * Value is {@link android.content.pm.PackageManager#PERMISSION_GRANTED}, or {@link android.content.pm.PackageManager#PERMISSION_DENIED}
 * @see #PERMISSION_GRANTED
 * @see #PERMISSION_DENIED
 * @apiSince 1
 */

public abstract int checkPermission(@androidx.annotation.NonNull java.lang.String permissionName, @androidx.annotation.NonNull java.lang.String packageName);

/**
 * Checks whether a particular permissions has been revoked for a
 * package by policy. Typically the device owner or the profile owner
 * may apply such a policy. The user cannot grant policy revoked
 * permissions, hence the only way for an app to get such a permission
 * is by a policy change.
 *
 * @param permissionName The name of the permission you are checking for.
 * This value must never be {@code null}.
 * @param packageName The name of the package you are checking against.
 *
 * This value must never be {@code null}.
 * @return Whether the permission is restricted by policy.
 * @apiSince 23
 */

public abstract boolean isPermissionRevokedByPolicy(@androidx.annotation.NonNull java.lang.String permissionName, @androidx.annotation.NonNull java.lang.String packageName);

/**
 * Add a new dynamic permission to the system.  For this to work, your
 * package must have defined a permission tree through the
 * {@link android.R.styleable#AndroidManifestPermissionTree
 * &lt;permission-tree&gt;} tag in its manifest.  A package can only add
 * permissions to trees that were defined by either its own package or
 * another with the same user id; a permission is in a tree if it
 * matches the name of the permission tree + ".": for example,
 * "com.foo.bar" is a member of the permission tree "com.foo".
 *
 * <p>It is good to make your permission tree name descriptive, because you
 * are taking possession of that entire set of permission names.  Thus, it
 * must be under a domain you control, with a suffix that will not match
 * any normal permissions that may be declared in any applications that
 * are part of that domain.
 *
 * <p>New permissions must be added before
 * any .apks are installed that use those permissions.  Permissions you
 * add through this method are remembered across reboots of the device.
 * If the given permission already exists, the info you supply here
 * will be used to update it.
 *
 * @param info Description of the permission to be added.
 *
 * This value must never be {@code null}.
 * @return Returns true if a new permission was created, false if an
 * existing one was updated.
 *
 * @throws java.lang.SecurityException if you are not allowed to add the
 * given permission name.
 *
 * @see #removePermission(String)
 * @apiSince 1
 */

public abstract boolean addPermission(@androidx.annotation.NonNull android.content.pm.PermissionInfo info);

/**
 * Like {@link #addPermission(android.content.pm.PermissionInfo)} but asynchronously
 * persists the package manager state after returning from the call,
 * allowing it to return quicker and batch a series of adds at the
 * expense of no guarantee the added permission will be retained if
 * the device is rebooted before it is written.
 
 * @param info This value must never be {@code null}.
 * @apiSince 8
 */

public abstract boolean addPermissionAsync(@androidx.annotation.NonNull android.content.pm.PermissionInfo info);

/**
 * Removes a permission that was previously added with
 * {@link #addPermission(android.content.pm.PermissionInfo)}.  The same ownership rules apply
 * -- you are only allowed to remove permissions that you are allowed
 * to add.
 *
 * @param permissionName The name of the permission to remove.
 *
 * This value must never be {@code null}.
 * @throws java.lang.SecurityException if you are not allowed to remove the
 * given permission name.
 *
 * @see #addPermission(PermissionInfo)
 * @apiSince 1
 */

public abstract void removePermission(@androidx.annotation.NonNull java.lang.String permissionName);

/**
 * Gets the restricted permissions that have been whitelisted and the app
 * is allowed to have them granted in their full form.
 *
 * <p> Permissions can be hard restricted which means that the app cannot hold
 * them or soft restricted where the app can hold the permission but in a weaker
 * form. Whether a permission is {@link android.content.pm.PermissionInfo#FLAG_HARD_RESTRICTED PermissionInfo#FLAG_HARD_RESTRICTED} or {@link android.content.pm.PermissionInfo#FLAG_SOFT_RESTRICTED PermissionInfo#FLAG_SOFT_RESTRICTED}
 * depends on the permission declaration. Whitelisting a hard restricted permission
 * allows for the to hold that permission and whitelisting a soft restricted
 * permission allows the app to hold the permission in its full, unrestricted form.
 *
 * <p><ol>There are three whitelists:
 *
 * <li>one for cases where the system permission policy whitelists a permission
 * This list corresponds to the{@link #FLAG_PERMISSION_WHITELIST_SYSTEM} flag.
 * Can only be accessed by pre-installed holders of a dedicated permission.
 *
 * <li>one for cases where the system whitelists the permission when upgrading
 * from an OS version in which the permission was not restricted to an OS version
 * in which the permission is restricted. This list corresponds to the {@link
 * #FLAG_PERMISSION_WHITELIST_UPGRADE} flag. Can be accessed by pre-installed
 * holders of a dedicated permission or the installer on record.
 *
 * <li>one for cases where the installer of the package whitelists a permission.
 * This list corresponds to the {@link #FLAG_PERMISSION_WHITELIST_INSTALLER} flag.
 * Can be accessed by pre-installed holders of a dedicated permission or the
 * installer on record.
 *
 * @param packageName The app for which to get whitelisted permissions.
 * This value must never be {@code null}.
 * @param whitelistFlag The flag to determine which whitelist to query. Only one flag
 * can be passed.s
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#FLAG_PERMISSION_WHITELIST_SYSTEM}, {@link android.content.pm.PackageManager#FLAG_PERMISSION_WHITELIST_INSTALLER}, and {@link android.content.pm.PackageManager#FLAG_PERMISSION_WHITELIST_UPGRADE}
 * @return The whitelisted permissions that are on any of the whitelists you query for.
 *
 * This value will never be {@code null}.
 * @see #addWhitelistedRestrictedPermission(String, String, int)
 * @see #removeWhitelistedRestrictedPermission(String, String, int)
 * @see #FLAG_PERMISSION_WHITELIST_SYSTEM
 * @see #FLAG_PERMISSION_WHITELIST_UPGRADE
 * @see #FLAG_PERMISSION_WHITELIST_INSTALLER
 *
 * @throws java.lang.SecurityException if you try to access a whitelist that you have no access to.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.util.Set<java.lang.String> getWhitelistedRestrictedPermissions(@androidx.annotation.NonNull java.lang.String packageName, int whitelistFlag) { throw new RuntimeException("Stub!"); }

/**
 * Adds a whitelisted restricted permission for an app.
 *
 * <p> Permissions can be hard restricted which means that the app cannot hold
 * them or soft restricted where the app can hold the permission but in a weaker
 * form. Whether a permission is {@link android.content.pm.PermissionInfo#FLAG_HARD_RESTRICTED PermissionInfo#FLAG_HARD_RESTRICTED} or {@link android.content.pm.PermissionInfo#FLAG_SOFT_RESTRICTED PermissionInfo#FLAG_SOFT_RESTRICTED}
 * depends on the permission declaration. Whitelisting a hard restricted permission
 * allows for the to hold that permission and whitelisting a soft restricted
 * permission allows the app to hold the permission in its full, unrestricted form.
 *
 * <p><ol>There are three whitelists:
 *
 * <li>one for cases where the system permission policy whitelists a permission
 * This list corresponds to the {@link #FLAG_PERMISSION_WHITELIST_SYSTEM} flag.
 * Can only be modified by pre-installed holders of a dedicated permission.
 *
 * <li>one for cases where the system whitelists the permission when upgrading
 * from an OS version in which the permission was not restricted to an OS version
 * in which the permission is restricted. This list corresponds to the {@link
 * #FLAG_PERMISSION_WHITELIST_UPGRADE} flag. Can be modified by pre-installed
 * holders of a dedicated permission. The installer on record can only remove
 * permissions from this whitelist.
 *
 * <li>one for cases where the installer of the package whitelists a permission.
 * This list corresponds to the {@link #FLAG_PERMISSION_WHITELIST_INSTALLER} flag.
 * Can be modified by pre-installed holders of a dedicated permission or the installer
 * on record.
 *
 * <p>You need to specify the whitelists for which to set the whitelisted permissions
 * which will clear the previous whitelisted permissions and replace them with the
 * provided ones.
 *
 * @param packageName The app for which to get whitelisted permissions.
 * This value must never be {@code null}.
 * @param permission The whitelisted permission to add.
 * This value must never be {@code null}.
 * @param whitelistFlags The whitelists to which to add. Passing multiple flags
 * updates all specified whitelists.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#FLAG_PERMISSION_WHITELIST_SYSTEM}, {@link android.content.pm.PackageManager#FLAG_PERMISSION_WHITELIST_INSTALLER}, and {@link android.content.pm.PackageManager#FLAG_PERMISSION_WHITELIST_UPGRADE}
 * @return Whether the permission was added to the whitelist.
 *
 * @see #getWhitelistedRestrictedPermissions(String, int)
 * @see #removeWhitelistedRestrictedPermission(String, String, int)
 * @see #FLAG_PERMISSION_WHITELIST_SYSTEM
 * @see #FLAG_PERMISSION_WHITELIST_UPGRADE
 * @see #FLAG_PERMISSION_WHITELIST_INSTALLER
 *
 * @throws java.lang.SecurityException if you try to modify a whitelist that you have no access to.
 * @apiSince 29
 */

public boolean addWhitelistedRestrictedPermission(@androidx.annotation.NonNull java.lang.String packageName, @androidx.annotation.NonNull java.lang.String permission, int whitelistFlags) { throw new RuntimeException("Stub!"); }

/**
 * Removes a whitelisted restricted permission for an app.
 *
 * <p> Permissions can be hard restricted which means that the app cannot hold
 * them or soft restricted where the app can hold the permission but in a weaker
 * form. Whether a permission is {@link android.content.pm.PermissionInfo#FLAG_HARD_RESTRICTED PermissionInfo#FLAG_HARD_RESTRICTED} or {@link android.content.pm.PermissionInfo#FLAG_SOFT_RESTRICTED PermissionInfo#FLAG_SOFT_RESTRICTED}
 * depends on the permission declaration. Whitelisting a hard restricted permission
 * allows for the to hold that permission and whitelisting a soft restricted
 * permission allows the app to hold the permission in its full, unrestricted form.
 *
 * <p><ol>There are three whitelists:
 *
 * <li>one for cases where the system permission policy whitelists a permission
 * This list corresponds to the {@link #FLAG_PERMISSION_WHITELIST_SYSTEM} flag.
 * Can only be modified by pre-installed holders of a dedicated permission.
 *
 * <li>one for cases where the system whitelists the permission when upgrading
 * from an OS version in which the permission was not restricted to an OS version
 * in which the permission is restricted. This list corresponds to the {@link
 * #FLAG_PERMISSION_WHITELIST_UPGRADE} flag. Can be modified by pre-installed
 * holders of a dedicated permission. The installer on record can only remove
 * permissions from this whitelist.
 *
 * <li>one for cases where the installer of the package whitelists a permission.
 * This list corresponds to the {@link #FLAG_PERMISSION_WHITELIST_INSTALLER} flag.
 * Can be modified by pre-installed holders of a dedicated permission or the installer
 * on record.
 *
 * <p>You need to specify the whitelists for which to set the whitelisted permissions
 * which will clear the previous whitelisted permissions and replace them with the
 * provided ones.
 *
 * @param packageName The app for which to get whitelisted permissions.
 * This value must never be {@code null}.
 * @param permission The whitelisted permission to remove.
 * This value must never be {@code null}.
 * @param whitelistFlags The whitelists from which to remove. Passing multiple flags
 * updates all specified whitelists.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#FLAG_PERMISSION_WHITELIST_SYSTEM}, {@link android.content.pm.PackageManager#FLAG_PERMISSION_WHITELIST_INSTALLER}, and {@link android.content.pm.PackageManager#FLAG_PERMISSION_WHITELIST_UPGRADE}
 * @return Whether the permission was removed from the whitelist.
 *
 * @see #getWhitelistedRestrictedPermissions(String, int)
 * @see #addWhitelistedRestrictedPermission(String, String, int)
 * @see #FLAG_PERMISSION_WHITELIST_SYSTEM
 * @see #FLAG_PERMISSION_WHITELIST_UPGRADE
 * @see #FLAG_PERMISSION_WHITELIST_INSTALLER
 *
 * @throws java.lang.SecurityException if you try to modify a whitelist that you have no access to.
 * @apiSince 29
 */

public boolean removeWhitelistedRestrictedPermission(@androidx.annotation.NonNull java.lang.String packageName, @androidx.annotation.NonNull java.lang.String permission, int whitelistFlags) { throw new RuntimeException("Stub!"); }

/**
 * Compare the signatures of two packages to determine if the same
 * signature appears in both of them.  If they do contain the same
 * signature, then they are allowed special privileges when working
 * with each other: they can share the same user-id, run instrumentation
 * against each other, etc.
 *
 * @param packageName1 First package name whose signature will be compared.
 * This value must never be {@code null}.
 * @param packageName2 Second package name whose signature will be compared.
 *
 * This value must never be {@code null}.
 * @return Returns an integer indicating whether all signatures on the
 * two packages match. The value is >= 0 ({@link #SIGNATURE_MATCH}) if
 * all signatures match or < 0 if there is not a match ({@link
 * #SIGNATURE_NO_MATCH} or {@link #SIGNATURE_UNKNOWN_PACKAGE}).
 *
 * Value is {@link android.content.pm.PackageManager#SIGNATURE_MATCH}, {@link android.content.pm.PackageManager#SIGNATURE_NEITHER_SIGNED}, {@link android.content.pm.PackageManager#SIGNATURE_FIRST_NOT_SIGNED}, {@link android.content.pm.PackageManager#SIGNATURE_SECOND_NOT_SIGNED}, {@link android.content.pm.PackageManager#SIGNATURE_NO_MATCH}, or {@link android.content.pm.PackageManager#SIGNATURE_UNKNOWN_PACKAGE}
 * @see #checkSignatures(int, int)
 * @apiSince 1
 */

public abstract int checkSignatures(@androidx.annotation.NonNull java.lang.String packageName1, @androidx.annotation.NonNull java.lang.String packageName2);

/**
 * Like {@link #checkSignatures(java.lang.String,java.lang.String)}, but takes UIDs of
 * the two packages to be checked.  This can be useful, for example,
 * when doing the check in an IPC, where the UID is the only identity
 * available.  It is functionally identical to determining the package
 * associated with the UIDs and checking their signatures.
 *
 * @param uid1 First UID whose signature will be compared.
 * @param uid2 Second UID whose signature will be compared.
 *
 * @return Returns an integer indicating whether all signatures on the
 * two packages match. The value is >= 0 ({@link #SIGNATURE_MATCH}) if
 * all signatures match or < 0 if there is not a match ({@link
 * #SIGNATURE_NO_MATCH} or {@link #SIGNATURE_UNKNOWN_PACKAGE}).
 *
 * Value is {@link android.content.pm.PackageManager#SIGNATURE_MATCH}, {@link android.content.pm.PackageManager#SIGNATURE_NEITHER_SIGNED}, {@link android.content.pm.PackageManager#SIGNATURE_FIRST_NOT_SIGNED}, {@link android.content.pm.PackageManager#SIGNATURE_SECOND_NOT_SIGNED}, {@link android.content.pm.PackageManager#SIGNATURE_NO_MATCH}, or {@link android.content.pm.PackageManager#SIGNATURE_UNKNOWN_PACKAGE}
 * @see #checkSignatures(String, String)
 * @apiSince 5
 */

public abstract int checkSignatures(int uid1, int uid2);

/**
 * Retrieve the names of all packages that are associated with a particular
 * user id.  In most cases, this will be a single package name, the package
 * that has been assigned that user id.  Where there are multiple packages
 * sharing the same user id through the "sharedUserId" mechanism, all
 * packages with that id will be returned.
 *
 * @param uid The user id for which you would like to retrieve the
 * associated packages.
 *
 * @return Returns an array of one or more packages assigned to the user
 * id, or null if there are no known packages with the given id.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public abstract java.lang.String[] getPackagesForUid(int uid);

/**
 * Retrieve the official name associated with a uid. This name is
 * guaranteed to never change, though it is possible for the underlying
 * uid to be changed.  That is, if you are storing information about
 * uids in persistent storage, you should use the string returned
 * by this function instead of the raw uid.
 *
 * @param uid The uid for which you would like to retrieve a name.
 * @return Returns a unique name for the given uid, or null if the
 * uid is not currently assigned.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public abstract java.lang.String getNameForUid(int uid);

/**
 * Return a List of all application packages that are installed for the
 * current user. If flag GET_UNINSTALLED_PACKAGES has been set, a list of all
 * applications including those deleted with {@code DONT_DELETE_DATA}
 * (partially installed apps with data directory) will be returned.
 *
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, android.content.pm.PackageManager.MATCH_INSTANT, android.content.pm.PackageManager.MATCH_STATIC_SHARED_LIBRARIES, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}, and android.content.pm.PackageManager.MATCH_HIDDEN_UNTIL_INSTALLED_COMPONENTS
 * @return A List of ApplicationInfo objects, one for each installed
 *         application. In the unlikely case there are no installed
 *         packages, an empty list is returned. If flag
 *         {@code MATCH_UNINSTALLED_PACKAGES} is set, the application
 *         information is retrieved from the list of uninstalled
 *         applications (which includes installed applications as well as
 *         applications with data directory i.e. applications which had been
 *         deleted with {@code DONT_DELETE_DATA} flag set).
 
 * This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public abstract java.util.List<android.content.pm.ApplicationInfo> getInstalledApplications(int flags);

/**
 * Gets whether this application is an instant app.
 *
 * @return Whether caller is an instant app.
 *
 * @see #isInstantApp(String)
 * @see #updateInstantAppCookie(byte[])
 * @see #getInstantAppCookie()
 * @see #getInstantAppCookieMaxBytes()
 * @apiSince 26
 */

public abstract boolean isInstantApp();

/**
 * Gets whether the given package is an instant app.
 *
 * @param packageName The package to check
 * This value must never be {@code null}.
 * @return Whether the given package is an instant app.
 *
 * @see #isInstantApp()
 * @see #updateInstantAppCookie(byte[])
 * @see #getInstantAppCookie()
 * @see #getInstantAppCookieMaxBytes()
 * @see #clearInstantAppCookie()
 * @apiSince 26
 */

public abstract boolean isInstantApp(@androidx.annotation.NonNull java.lang.String packageName);

/**
 * Gets the maximum size in bytes of the cookie data an instant app
 * can store on the device.
 *
 * @return The max cookie size in bytes.
 *
 * @see #isInstantApp()
 * @see #isInstantApp(String)
 * @see #updateInstantAppCookie(byte[])
 * @see #getInstantAppCookie()
 * @see #clearInstantAppCookie()
 * @apiSince 26
 */

public abstract int getInstantAppCookieMaxBytes();

/**
 * Gets the instant application cookie for this app. Non
 * instant apps and apps that were instant but were upgraded
 * to normal apps can still access this API. For instant apps
 * this cookie is cached for some time after uninstall while for
 * normal apps the cookie is deleted after the app is uninstalled.
 * The cookie is always present while the app is installed.
 *
 * @return The cookie.
 *
 * This value will never be {@code null}.
 * @see #isInstantApp()
 * @see #isInstantApp(String)
 * @see #updateInstantAppCookie(byte[])
 * @see #getInstantAppCookieMaxBytes()
 * @see #clearInstantAppCookie()
 * @apiSince 26
 */

@androidx.annotation.NonNull
public abstract byte[] getInstantAppCookie();

/**
 * Clears the instant application cookie for the calling app.
 *
 * @see #isInstantApp()
 * @see #isInstantApp(String)
 * @see #getInstantAppCookieMaxBytes()
 * @see #getInstantAppCookie()
 * @see #clearInstantAppCookie()
 * @apiSince 26
 */

public abstract void clearInstantAppCookie();

/**
 * Updates the instant application cookie for the calling app. Non
 * instant apps and apps that were instant but were upgraded
 * to normal apps can still access this API. For instant apps
 * this cookie is cached for some time after uninstall while for
 * normal apps the cookie is deleted after the app is uninstalled.
 * The cookie is always present while the app is installed. The
 * cookie size is limited by {@link #getInstantAppCookieMaxBytes()}.
 * Passing <code>null</code> or an empty array clears the cookie.
 * </p>
 *
 * @param cookie The cookie data.
 *
 * This value may be {@code null}.
 * @see #isInstantApp()
 * @see #isInstantApp(String)
 * @see #getInstantAppCookieMaxBytes()
 * @see #getInstantAppCookie()
 * @see #clearInstantAppCookie()
 *
 * @throws java.lang.IllegalArgumentException if the array exceeds max cookie size.
 * @apiSince 26
 */

public abstract void updateInstantAppCookie(@androidx.annotation.Nullable byte[] cookie);

/**
 * Get a list of shared libraries that are available on the
 * system.
 *
 * @return An array of shared library names that are
 * available on the system, or null if none are installed.
 *
 * @apiSince 3
 */

@androidx.annotation.Nullable
public abstract java.lang.String[] getSystemSharedLibraryNames();

/**
 * Get a list of shared libraries on the device.
 *
 * @param flags To filter the libraries to return.
 * Value is either <code>0</code> or a combination of android.content.pm.PackageManager.INSTALL_REPLACE_EXISTING, android.content.pm.PackageManager.INSTALL_ALLOW_TEST, android.content.pm.PackageManager.INSTALL_INTERNAL, android.content.pm.PackageManager.INSTALL_FROM_ADB, android.content.pm.PackageManager.INSTALL_ALL_USERS, android.content.pm.PackageManager.INSTALL_REQUEST_DOWNGRADE, android.content.pm.PackageManager.INSTALL_GRANT_RUNTIME_PERMISSIONS, android.content.pm.PackageManager.INSTALL_ALL_WHITELIST_RESTRICTED_PERMISSIONS, android.content.pm.PackageManager.INSTALL_FORCE_VOLUME_UUID, android.content.pm.PackageManager.INSTALL_FORCE_PERMISSION_PROMPT, android.content.pm.PackageManager.INSTALL_INSTANT_APP, android.content.pm.PackageManager.INSTALL_DONT_KILL_APP, android.content.pm.PackageManager.INSTALL_FULL_APP, android.content.pm.PackageManager.INSTALL_ALLOCATE_AGGRESSIVE, android.content.pm.PackageManager.INSTALL_VIRTUAL_PRELOAD, android.content.pm.PackageManager.INSTALL_APEX, android.content.pm.PackageManager.INSTALL_ENABLE_ROLLBACK, android.content.pm.PackageManager.INSTALL_ALLOW_DOWNGRADE, android.content.pm.PackageManager.INSTALL_STAGED, and android.content.pm.PackageManager.INSTALL_DRY_RUN
 * @return The shared library list.
 *
 * This value will never be {@code null}.
 * @see #MATCH_UNINSTALLED_PACKAGES
 * @apiSince 26
 */

@androidx.annotation.NonNull
public abstract java.util.List<android.content.pm.SharedLibraryInfo> getSharedLibraries(int flags);

/**
 * Returns the names of the packages that have been changed
 * [eg. added, removed or updated] since the given sequence
 * number.
 * <p>If no packages have been changed, returns <code>null</code>.
 * <p>The sequence number starts at <code>0</code> and is
 * reset every boot.
 * @param sequenceNumber The first sequence number for which to retrieve package changes.
 * Value is 0 or greater
 * @see android.provider.Settings.Global#BOOT_COUNT
 * @apiSince 26
 */

@androidx.annotation.Nullable
public abstract android.content.pm.ChangedPackages getChangedPackages(int sequenceNumber);

/**
 * Get a list of features that are available on the
 * system.
 *
 * @return An array of FeatureInfo classes describing the features
 * that are available on the system, or null if there are none(!!).
 * @apiSince 5
 */

@androidx.annotation.NonNull
public abstract android.content.pm.FeatureInfo[] getSystemAvailableFeatures();

/**
 * Check whether the given feature name is one of the available features as
 * returned by {@link #getSystemAvailableFeatures()}. This tests for the
 * presence of <em>any</em> version of the given feature name; use
 * {@link #hasSystemFeature(java.lang.String,int)} to check for a minimum version.
 *
 * @param featureName This value must never be {@code null}.
 * @return Returns true if the devices supports the feature, else false.
 * @apiSince 5
 */

public abstract boolean hasSystemFeature(@androidx.annotation.NonNull java.lang.String featureName);

/**
 * Check whether the given feature name and version is one of the available
 * features as returned by {@link #getSystemAvailableFeatures()}. Since
 * features are defined to always be backwards compatible, this returns true
 * if the available feature version is greater than or equal to the
 * requested version.
 *
 * @param featureName This value must never be {@code null}.
 * @return Returns true if the devices supports the feature, else false.
 * @apiSince 24
 */

public abstract boolean hasSystemFeature(@androidx.annotation.NonNull java.lang.String featureName, int version);

/**
 * Determine the best action to perform for a given Intent. This is how
 * {@link android.content.Intent#resolveActivity Intent#resolveActivity} finds an activity if a class has not been
 * explicitly specified.
 * <p>
 * <em>Note:</em> if using an implicit Intent (without an explicit
 * ComponentName specified), be sure to consider whether to set the
 * {@link #MATCH_DEFAULT_ONLY} only flag. You need to do so to resolve the
 * activity in the same way that
 * {@link android.content.Context#startActivity(Intent)} and
 * {@link android.content.Intent#resolveActivity(PackageManager)
 * Intent.resolveActivity(PackageManager)} do.
 * </p>
 *
 * @param intent An intent containing all of the desired specification
 *            (action, data, type, category, and/or component).
 * This value must never be {@code null}.
 * @param flags Additional option flags to modify the data returned. The
 *            most important is {@link #MATCH_DEFAULT_ONLY}, to limit the
 *            resolution to only those activities that support the
 *            {@link android.content.Intent#CATEGORY_DEFAULT}.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_RESOLVED_FILTER}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#MATCH_ALL}, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DEFAULT_ONLY}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AUTO}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AWARE}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_UNAWARE}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, android.content.pm.PackageManager.MATCH_INSTANT, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, and {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}
 * @return Returns a ResolveInfo object containing the final activity intent
 *         that was determined to be the best action. Returns null if no
 *         matching activity was found. If multiple matching activities are
 *         found and there is no default set, returns a ResolveInfo object
 *         containing something else, such as the activity resolver.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public abstract android.content.pm.ResolveInfo resolveActivity(@androidx.annotation.NonNull android.content.Intent intent, int flags);

/**
 * Retrieve all activities that can be performed for the given intent.
 *
 * @param intent The desired intent as per resolveActivity().
 * This value must never be {@code null}.
 * @param flags Additional option flags to modify the data returned. The
 *            most important is {@link #MATCH_DEFAULT_ONLY}, to limit the
 *            resolution to only those activities that support the
 *            {@link android.content.Intent#CATEGORY_DEFAULT}. Or, set
 *            {@link #MATCH_ALL} to prevent any filtering of the results.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_RESOLVED_FILTER}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#MATCH_ALL}, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DEFAULT_ONLY}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AUTO}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AWARE}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_UNAWARE}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, android.content.pm.PackageManager.MATCH_INSTANT, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, and {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}
 * @return Returns a List of ResolveInfo objects containing one entry for
 *         each matching activity, ordered from best to worst. In other
 *         words, the first item is what would be returned by
 *         {@link #resolveActivity}. If there are no matching activities, an
 *         empty list is returned.
 
 * This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public abstract java.util.List<android.content.pm.ResolveInfo> queryIntentActivities(@androidx.annotation.NonNull android.content.Intent intent, int flags);

/**
 * Retrieve a set of activities that should be presented to the user as
 * similar options. This is like {@link #queryIntentActivities}, except it
 * also allows you to supply a list of more explicit Intents that you would
 * like to resolve to particular options, and takes care of returning the
 * final ResolveInfo list in a reasonable order, with no duplicates, based
 * on those inputs.
 *
 * @param caller The class name of the activity that is making the request.
 *            This activity will never appear in the output list. Can be
 *            null.
 * This value may be {@code null}.
 * @param specifics An array of Intents that should be resolved to the first
 *            specific results. Can be null.
 * This value may be {@code null}.
 * @param intent The desired intent as per resolveActivity().
 * This value must never be {@code null}.
 * @param flags Additional option flags to modify the data returned. The
 *            most important is {@link #MATCH_DEFAULT_ONLY}, to limit the
 *            resolution to only those activities that support the
 *            {@link android.content.Intent#CATEGORY_DEFAULT}.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_RESOLVED_FILTER}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#MATCH_ALL}, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DEFAULT_ONLY}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AUTO}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AWARE}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_UNAWARE}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, android.content.pm.PackageManager.MATCH_INSTANT, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, and {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}
 * @return Returns a List of ResolveInfo objects containing one entry for
 *         each matching activity. The list is ordered first by all of the
 *         intents resolved in <var>specifics</var> and then any additional
 *         activities that can handle <var>intent</var> but did not get
 *         included by one of the <var>specifics</var> intents. If there are
 *         no matching activities, an empty list is returned.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public abstract java.util.List<android.content.pm.ResolveInfo> queryIntentActivityOptions(@androidx.annotation.Nullable android.content.ComponentName caller, @androidx.annotation.Nullable android.content.Intent[] specifics, @androidx.annotation.NonNull android.content.Intent intent, int flags);

/**
 * Retrieve all receivers that can handle a broadcast of the given intent.
 *
 * @param intent The desired intent as per resolveActivity().
 * This value must never be {@code null}.
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_RESOLVED_FILTER}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#MATCH_ALL}, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DEFAULT_ONLY}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AUTO}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AWARE}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_UNAWARE}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, android.content.pm.PackageManager.MATCH_INSTANT, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, and {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}
 * @return Returns a List of ResolveInfo objects containing one entry for
 *         each matching receiver, ordered from best to worst. If there are
 *         no matching receivers, an empty list or null is returned.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public abstract java.util.List<android.content.pm.ResolveInfo> queryBroadcastReceivers(@androidx.annotation.NonNull android.content.Intent intent, int flags);

/**
 * Determine the best service to handle for a given Intent.
 *
 * @param intent An intent containing all of the desired specification
 *            (action, data, type, category, and/or component).
 * This value must never be {@code null}.
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_RESOLVED_FILTER}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#MATCH_ALL}, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DEFAULT_ONLY}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AUTO}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AWARE}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_UNAWARE}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, android.content.pm.PackageManager.MATCH_INSTANT, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, and {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}
 * @return Returns a ResolveInfo object containing the final service intent
 *         that was determined to be the best action. Returns null if no
 *         matching service was found.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public abstract android.content.pm.ResolveInfo resolveService(@androidx.annotation.NonNull android.content.Intent intent, int flags);

/**
 * Retrieve all services that can match the given intent.
 *
 * @param intent The desired intent as per resolveService().
 * This value must never be {@code null}.
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_RESOLVED_FILTER}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#MATCH_ALL}, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DEFAULT_ONLY}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AUTO}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AWARE}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_UNAWARE}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, android.content.pm.PackageManager.MATCH_INSTANT, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, and {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}
 * @return Returns a List of ResolveInfo objects containing one entry for
 *         each matching service, ordered from best to worst. In other
 *         words, the first item is what would be returned by
 *         {@link #resolveService}. If there are no matching services, an
 *         empty list or null is returned.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public abstract java.util.List<android.content.pm.ResolveInfo> queryIntentServices(@androidx.annotation.NonNull android.content.Intent intent, int flags);

/**
 * Retrieve all providers that can match the given intent.
 *
 * @param intent An intent containing all of the desired specification
 *            (action, data, type, category, and/or component).
 * This value must never be {@code null}.
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_RESOLVED_FILTER}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#MATCH_ALL}, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DEFAULT_ONLY}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AUTO}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AWARE}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_UNAWARE}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, android.content.pm.PackageManager.MATCH_INSTANT, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, and {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}
 * @return Returns a List of ResolveInfo objects containing one entry for
 *         each matching provider, ordered from best to worst. If there are
 *         no matching services, an empty list or null is returned.
 * @apiSince 19
 */

@androidx.annotation.NonNull
public abstract java.util.List<android.content.pm.ResolveInfo> queryIntentContentProviders(@androidx.annotation.NonNull android.content.Intent intent, int flags);

/**
 * Find a single content provider by its authority.
 * <p>
 * Example:<p>
 * <pre>
 * Uri uri = Uri.parse("content://com.example.app.provider/table1");
 * ProviderInfo info = packageManager.resolveContentProvider(uri.getAuthority(), flags);
 * </pre>
 *
 * @param authority The authority of the provider to find.
 * This value must never be {@code null}.
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#MATCH_ALL}, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, {@link android.content.pm.PackageManager#MATCH_DEFAULT_ONLY}, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AUTO}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AWARE}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_UNAWARE}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, android.content.pm.PackageManager.MATCH_INSTANT, android.content.pm.PackageManager.MATCH_STATIC_SHARED_LIBRARIES, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, and {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}
 * @return A {@link android.content.pm.ProviderInfo ProviderInfo} object containing information about the
 *         provider. If a provider was not found, returns null.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public abstract android.content.pm.ProviderInfo resolveContentProvider(@androidx.annotation.NonNull java.lang.String authority, int flags);

/**
 * Retrieve content provider information.
 * <p>
 * <em>Note: unlike most other methods, an empty result set is indicated
 * by a null return instead of an empty list.</em>
 *
 * @param processName If non-null, limits the returned providers to only
 *            those that are hosted by the given process. If null, all
 *            content providers are returned.
 * This value may be {@code null}.
 * @param uid If <var>processName</var> is non-null, this is the required
 *            uid owning the requested content providers.
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#MATCH_ALL}, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, {@link android.content.pm.PackageManager#MATCH_DEFAULT_ONLY}, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AUTO}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AWARE}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_UNAWARE}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, android.content.pm.PackageManager.MATCH_INSTANT, android.content.pm.PackageManager.MATCH_STATIC_SHARED_LIBRARIES, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, and {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}
 * @return A list of {@link android.content.pm.ProviderInfo ProviderInfo} objects containing one entry for
 *         each provider either matching <var>processName</var> or, if
 *         <var>processName</var> is null, all known content providers.
 *         <em>If there are no matching providers, null is returned.</em>
 * @apiSince 1
 */

@androidx.annotation.NonNull
public abstract java.util.List<android.content.pm.ProviderInfo> queryContentProviders(@androidx.annotation.Nullable java.lang.String processName, int uid, int flags);

/**
 * Retrieve all of the information we know about a particular
 * instrumentation class.
 *
 * @param className The full name (i.e.
 *            com.google.apps.contacts.InstrumentList) of an Instrumentation
 *            class.
 * This value must never be {@code null}.
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or {@link android.content.pm.PackageManager#GET_META_DATA}
 * @return An {@link android.content.pm.InstrumentationInfo InstrumentationInfo} object containing information
 *         about the instrumentation.
 * This value will never be {@code null}.
 * @throws android.content.pm.PackageManager.NameNotFoundException if a package with the given name cannot be
 *             found on the system.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public abstract android.content.pm.InstrumentationInfo getInstrumentationInfo(@androidx.annotation.NonNull android.content.ComponentName className, int flags) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve information about available instrumentation code. May be used to
 * retrieve either all instrumentation code, or only the code targeting a
 * particular package.
 *
 * @param targetPackage If null, all instrumentation is returned; only the
 *            instrumentation targeting this package name is returned.
 * This value must never be {@code null}.
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or {@link android.content.pm.PackageManager#GET_META_DATA}
 * @return A list of {@link android.content.pm.InstrumentationInfo InstrumentationInfo} objects containing one
 *         entry for each matching instrumentation. If there are no
 *         instrumentation available, returns an empty list.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public abstract java.util.List<android.content.pm.InstrumentationInfo> queryInstrumentation(@androidx.annotation.NonNull java.lang.String targetPackage, int flags);

/**
 * Retrieve an image from a package.  This is a low-level API used by
 * the various package manager info structures (such as
 * {@link android.content.pm.ComponentInfo ComponentInfo} to implement retrieval of their associated
 * icon.
 *
 * @param packageName The name of the package that this icon is coming from.
 * Cannot be null.
 * This value must never be {@code null}.
 * @param resid The resource identifier of the desired image.  Cannot be 0.
 * @param appInfo Overall information about <var>packageName</var>.  This
 * may be null, in which case the application information will be retrieved
 * for you if needed; if you already have this information around, it can
 * be much more efficient to supply it here.
 *
 * This value may be {@code null}.
 * @return Returns a Drawable holding the requested image.  Returns null if
 * an image could not be found for any reason.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public abstract android.graphics.drawable.Drawable getDrawable(@androidx.annotation.NonNull java.lang.String packageName, int resid, @androidx.annotation.Nullable android.content.pm.ApplicationInfo appInfo);

/**
 * Retrieve the icon associated with an activity.  Given the full name of
 * an activity, retrieves the information about it and calls
 * {@link android.content.pm.ComponentInfo#loadIcon ComponentInfo#loadIcon} to return its icon.
 * If the activity cannot be found, NameNotFoundException is thrown.
 *
 * @param activityName Name of the activity whose icon is to be retrieved.
 *
 * This value must never be {@code null}.
 * @return Returns the image of the icon, or the default activity icon if
 * it could not be found.  Does not return null.
 * @throws android.content.pm.PackageManager.NameNotFoundException Thrown if the resources for the given
 * activity could not be loaded.
 *
 * @see #getActivityIcon(Intent)
 * @apiSince 1
 */

@androidx.annotation.NonNull
public abstract android.graphics.drawable.Drawable getActivityIcon(@androidx.annotation.NonNull android.content.ComponentName activityName) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve the icon associated with an Intent.  If intent.getClassName() is
 * set, this simply returns the result of
 * getActivityIcon(intent.getClassName()).  Otherwise it resolves the intent's
 * component and returns the icon associated with the resolved component.
 * If intent.getClassName() cannot be found or the Intent cannot be resolved
 * to a component, NameNotFoundException is thrown.
 *
 * @param intent The intent for which you would like to retrieve an icon.
 *
 * This value must never be {@code null}.
 * @return Returns the image of the icon, or the default activity icon if
 * it could not be found.  Does not return null.
 * @throws android.content.pm.PackageManager.NameNotFoundException Thrown if the resources for application
 * matching the given intent could not be loaded.
 *
 * @see #getActivityIcon(ComponentName)
 * @apiSince 1
 */

@androidx.annotation.NonNull
public abstract android.graphics.drawable.Drawable getActivityIcon(@androidx.annotation.NonNull android.content.Intent intent) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve the banner associated with an activity. Given the full name of
 * an activity, retrieves the information about it and calls
 * {@link android.content.pm.ComponentInfo#loadIcon ComponentInfo#loadIcon} to return its
 * banner. If the activity cannot be found, NameNotFoundException is thrown.
 *
 * @param activityName Name of the activity whose banner is to be retrieved.
 * This value must never be {@code null}.
 * @return Returns the image of the banner, or null if the activity has no
 *         banner specified.
 * @throws android.content.pm.PackageManager.NameNotFoundException Thrown if the resources for the given
 *             activity could not be loaded.
 * @see #getActivityBanner(Intent)
 * @apiSince 20
 */

@androidx.annotation.Nullable
public abstract android.graphics.drawable.Drawable getActivityBanner(@androidx.annotation.NonNull android.content.ComponentName activityName) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve the banner associated with an Intent. If intent.getClassName()
 * is set, this simply returns the result of
 * getActivityBanner(intent.getClassName()). Otherwise it resolves the
 * intent's component and returns the banner associated with the resolved
 * component. If intent.getClassName() cannot be found or the Intent cannot
 * be resolved to a component, NameNotFoundException is thrown.
 *
 * @param intent The intent for which you would like to retrieve a banner.
 * This value must never be {@code null}.
 * @return Returns the image of the banner, or null if the activity has no
 *         banner specified.
 * @throws android.content.pm.PackageManager.NameNotFoundException Thrown if the resources for application
 *             matching the given intent could not be loaded.
 * @see #getActivityBanner(ComponentName)
 * @apiSince 20
 */

@androidx.annotation.Nullable
public abstract android.graphics.drawable.Drawable getActivityBanner(@androidx.annotation.NonNull android.content.Intent intent) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Return the generic icon for an activity that is used when no specific
 * icon is defined.
 *
 * @return Drawable Image of the icon.
 
 * This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public abstract android.graphics.drawable.Drawable getDefaultActivityIcon();

/**
 * Retrieve the icon associated with an application.  If it has not defined
 * an icon, the default app icon is returned.  Does not return null.
 *
 * @param info Information about application being queried.
 *
 * This value must never be {@code null}.
 * @return Returns the image of the icon, or the default application icon
 * if it could not be found.
 *
 * @see #getApplicationIcon(String)
 * @apiSince 1
 */

@androidx.annotation.NonNull
public abstract android.graphics.drawable.Drawable getApplicationIcon(@androidx.annotation.NonNull android.content.pm.ApplicationInfo info);

/**
 * Retrieve the icon associated with an application.  Given the name of the
 * application's package, retrieves the information about it and calls
 * getApplicationIcon() to return its icon. If the application cannot be
 * found, NameNotFoundException is thrown.
 *
 * @param packageName Name of the package whose application icon is to be
 *                    retrieved.
 *
 * This value must never be {@code null}.
 * @return Returns the image of the icon, or the default application icon
 * if it could not be found.  Does not return null.
 * @throws android.content.pm.PackageManager.NameNotFoundException Thrown if the resources for the given
 * application could not be loaded.
 *
 * @see #getApplicationIcon(ApplicationInfo)
 * @apiSince 1
 */

@androidx.annotation.NonNull
public abstract android.graphics.drawable.Drawable getApplicationIcon(@androidx.annotation.NonNull java.lang.String packageName) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve the banner associated with an application.
 *
 * @param info Information about application being queried.
 * This value must never be {@code null}.
 * @return Returns the image of the banner or null if the application has no
 *         banner specified.
 * @see #getApplicationBanner(String)
 * @apiSince 20
 */

@androidx.annotation.Nullable
public abstract android.graphics.drawable.Drawable getApplicationBanner(@androidx.annotation.NonNull android.content.pm.ApplicationInfo info);

/**
 * Retrieve the banner associated with an application. Given the name of the
 * application's package, retrieves the information about it and calls
 * getApplicationIcon() to return its banner. If the application cannot be
 * found, NameNotFoundException is thrown.
 *
 * @param packageName Name of the package whose application banner is to be
 *            retrieved.
 * This value must never be {@code null}.
 * @return Returns the image of the banner or null if the application has no
 *         banner specified.
 * @throws android.content.pm.PackageManager.NameNotFoundException Thrown if the resources for the given
 *             application could not be loaded.
 * @see #getApplicationBanner(ApplicationInfo)
 * @apiSince 20
 */

@androidx.annotation.Nullable
public abstract android.graphics.drawable.Drawable getApplicationBanner(@androidx.annotation.NonNull java.lang.String packageName) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve the logo associated with an activity. Given the full name of an
 * activity, retrieves the information about it and calls
 * {@link android.content.pm.ComponentInfo#loadLogo ComponentInfo#loadLogo} to return its
 * logo. If the activity cannot be found, NameNotFoundException is thrown.
 *
 * @param activityName Name of the activity whose logo is to be retrieved.
 * This value must never be {@code null}.
 * @return Returns the image of the logo or null if the activity has no logo
 *         specified.
 * @throws android.content.pm.PackageManager.NameNotFoundException Thrown if the resources for the given
 *             activity could not be loaded.
 * @see #getActivityLogo(Intent)
 * @apiSince 9
 */

@androidx.annotation.Nullable
public abstract android.graphics.drawable.Drawable getActivityLogo(@androidx.annotation.NonNull android.content.ComponentName activityName) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve the logo associated with an Intent.  If intent.getClassName() is
 * set, this simply returns the result of
 * getActivityLogo(intent.getClassName()).  Otherwise it resolves the intent's
 * component and returns the logo associated with the resolved component.
 * If intent.getClassName() cannot be found or the Intent cannot be resolved
 * to a component, NameNotFoundException is thrown.
 *
 * @param intent The intent for which you would like to retrieve a logo.
 *
 * This value must never be {@code null}.
 * @return Returns the image of the logo, or null if the activity has no
 * logo specified.
 *
 * @throws android.content.pm.PackageManager.NameNotFoundException Thrown if the resources for application
 * matching the given intent could not be loaded.
 *
 * @see #getActivityLogo(ComponentName)
 * @apiSince 9
 */

@androidx.annotation.Nullable
public abstract android.graphics.drawable.Drawable getActivityLogo(@androidx.annotation.NonNull android.content.Intent intent) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve the logo associated with an application.  If it has not specified
 * a logo, this method returns null.
 *
 * @param info Information about application being queried.
 *
 * This value must never be {@code null}.
 * @return Returns the image of the logo, or null if no logo is specified
 * by the application.
 *
 * @see #getApplicationLogo(String)
 * @apiSince 9
 */

@androidx.annotation.Nullable
public abstract android.graphics.drawable.Drawable getApplicationLogo(@androidx.annotation.NonNull android.content.pm.ApplicationInfo info);

/**
 * Retrieve the logo associated with an application.  Given the name of the
 * application's package, retrieves the information about it and calls
 * getApplicationLogo() to return its logo. If the application cannot be
 * found, NameNotFoundException is thrown.
 *
 * @param packageName Name of the package whose application logo is to be
 *                    retrieved.
 *
 * This value must never be {@code null}.
 * @return Returns the image of the logo, or null if no application logo
 * has been specified.
 *
 * @throws android.content.pm.PackageManager.NameNotFoundException Thrown if the resources for the given
 * application could not be loaded.
 *
 * @see #getApplicationLogo(ApplicationInfo)
 * @apiSince 9
 */

@androidx.annotation.Nullable
public abstract android.graphics.drawable.Drawable getApplicationLogo(@androidx.annotation.NonNull java.lang.String packageName) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * If the target user is a managed profile, then this returns a badged copy of the given icon
 * to be able to distinguish it from the original icon. For badging an arbitrary drawable use
 * {@link #getUserBadgedDrawableForDensity(android.graphics.drawable.Drawable,android.os.UserHandle,android.graphics.Rect,int)}.
 * <p>
 * If the original drawable is a BitmapDrawable and the backing bitmap is
 * mutable as per {@link android.graphics.Bitmap#isMutable()}, the badging
 * is performed in place and the original drawable is returned.
 * </p>
 *
 * @param drawable The drawable to badge.
 * This value must never be {@code null}.
 * @param user The target user.
 * This value must never be {@code null}.
 * @return A drawable that combines the original icon and a badge as
 *         determined by the system.
 
 * This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public abstract android.graphics.drawable.Drawable getUserBadgedIcon(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable, @androidx.annotation.NonNull android.os.UserHandle user);

/**
 * If the target user is a managed profile of the calling user or the caller
 * is itself a managed profile, then this returns a badged copy of the given
 * drawable allowing the user to distinguish it from the original drawable.
 * The caller can specify the location in the bounds of the drawable to be
 * badged where the badge should be applied as well as the density of the
 * badge to be used.
 * <p>
 * If the original drawable is a BitmapDrawable and the backing bitmap is
 * mutable as per {@link android.graphics.Bitmap#isMutable()}, the badging
 * is performed in place and the original drawable is returned.
 * </p>
 *
 * @param drawable The drawable to badge.
 * This value must never be {@code null}.
 * @param user The target user.
 * This value must never be {@code null}.
 * @param badgeLocation Where in the bounds of the badged drawable to place
 *         the badge. If it's {@code null}, the badge is applied on top of the entire
 *         drawable being badged.
 * This value may be {@code null}.
 * @param badgeDensity The optional desired density for the badge as per
 *         {@link android.util.DisplayMetrics#densityDpi}. If it's not positive,
 *         the density of the display is used.
 * @return A drawable that combines the original drawable and a badge as
 *         determined by the system.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public abstract android.graphics.drawable.Drawable getUserBadgedDrawableForDensity(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable, @androidx.annotation.NonNull android.os.UserHandle user, @androidx.annotation.Nullable android.graphics.Rect badgeLocation, int badgeDensity);

/**
 * If the target user is a managed profile of the calling user or the caller
 * is itself a managed profile, then this returns a copy of the label with
 * badging for accessibility services like talkback. E.g. passing in "Email"
 * and it might return "Work Email" for Email in the work profile.
 *
 * @param label The label to change.
 * This value must never be {@code null}.
 * @param user The target user.
 * This value must never be {@code null}.
 * @return A label that combines the original label and a badge as
 *         determined by the system.
 
 * This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public abstract java.lang.CharSequence getUserBadgedLabel(@androidx.annotation.NonNull java.lang.CharSequence label, @androidx.annotation.NonNull android.os.UserHandle user);

/**
 * Retrieve text from a package.  This is a low-level API used by
 * the various package manager info structures (such as
 * {@link android.content.pm.ComponentInfo ComponentInfo} to implement retrieval of their associated
 * labels and other text.
 *
 * @param packageName The name of the package that this text is coming from.
 * Cannot be null.
 * This value must never be {@code null}.
 * @param resid The resource identifier of the desired text.  Cannot be 0.
 * @param appInfo Overall information about <var>packageName</var>.  This
 * may be null, in which case the application information will be retrieved
 * for you if needed; if you already have this information around, it can
 * be much more efficient to supply it here.
 *
 * This value may be {@code null}.
 * @return Returns a CharSequence holding the requested text.  Returns null
 * if the text could not be found for any reason.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public abstract java.lang.CharSequence getText(@androidx.annotation.NonNull java.lang.String packageName, int resid, @androidx.annotation.Nullable android.content.pm.ApplicationInfo appInfo);

/**
 * Retrieve an XML file from a package.  This is a low-level API used to
 * retrieve XML meta data.
 *
 * @param packageName The name of the package that this xml is coming from.
 * Cannot be null.
 * This value must never be {@code null}.
 * @param resid The resource identifier of the desired xml.  Cannot be 0.
 * @param appInfo Overall information about <var>packageName</var>.  This
 * may be null, in which case the application information will be retrieved
 * for you if needed; if you already have this information around, it can
 * be much more efficient to supply it here.
 *
 * This value may be {@code null}.
 * @return Returns an XmlPullParser allowing you to parse out the XML
 * data.  Returns null if the xml resource could not be found for any
 * reason.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public abstract android.content.res.XmlResourceParser getXml(@androidx.annotation.NonNull java.lang.String packageName, int resid, @androidx.annotation.Nullable android.content.pm.ApplicationInfo appInfo);

/**
 * Return the label to use for this application.
 *
 * @return Returns the label associated with this application, or null if
 * it could not be found for any reason.
 * @param info The application to get the label of.
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public abstract java.lang.CharSequence getApplicationLabel(@androidx.annotation.NonNull android.content.pm.ApplicationInfo info);

/**
 * Retrieve the resources associated with an activity.  Given the full
 * name of an activity, retrieves the information about it and calls
 * getResources() to return its application's resources.  If the activity
 * cannot be found, NameNotFoundException is thrown.
 *
 * @param activityName Name of the activity whose resources are to be
 *                     retrieved.
 *
 * This value must never be {@code null}.
 * @return Returns the application's Resources.
 * This value will never be {@code null}.
 * @throws android.content.pm.PackageManager.NameNotFoundException Thrown if the resources for the given
 * application could not be loaded.
 *
 * @see #getResourcesForApplication(ApplicationInfo)
 * @apiSince 1
 */

@androidx.annotation.NonNull
public abstract android.content.res.Resources getResourcesForActivity(@androidx.annotation.NonNull android.content.ComponentName activityName) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve the resources for an application.  Throws NameNotFoundException
 * if the package is no longer installed.
 *
 * @param app Information about the desired application.
 *
 * This value must never be {@code null}.
 * @return Returns the application's Resources.
 * This value will never be {@code null}.
 * @throws android.content.pm.PackageManager.NameNotFoundException Thrown if the resources for the given
 * application could not be loaded (most likely because it was uninstalled).
 * @apiSince 1
 */

@androidx.annotation.NonNull
public abstract android.content.res.Resources getResourcesForApplication(@androidx.annotation.NonNull android.content.pm.ApplicationInfo app) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve the resources associated with an application.  Given the full
 * package name of an application, retrieves the information about it and
 * calls getResources() to return its application's resources.  If the
 * appPackageName cannot be found, NameNotFoundException is thrown.
 *
 * @param packageName Package name of the application whose resources
 *                       are to be retrieved.
 *
 * This value must never be {@code null}.
 * @return Returns the application's Resources.
 * This value will never be {@code null}.
 * @throws android.content.pm.PackageManager.NameNotFoundException Thrown if the resources for the given
 * application could not be loaded.
 *
 * @see #getResourcesForApplication(ApplicationInfo)
 * @apiSince 1
 */

@androidx.annotation.NonNull
public abstract android.content.res.Resources getResourcesForApplication(@androidx.annotation.NonNull java.lang.String packageName) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve overall information about an application package defined in a
 * package archive file
 *
 * @param archiveFilePath The path to the archive file
 * This value must never be {@code null}.
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_ACTIVITIES}, {@link android.content.pm.PackageManager#GET_CONFIGURATIONS}, {@link android.content.pm.PackageManager#GET_GIDS}, {@link android.content.pm.PackageManager#GET_INSTRUMENTATION}, {@link android.content.pm.PackageManager#GET_INTENT_FILTERS}, {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_PERMISSIONS}, {@link android.content.pm.PackageManager#GET_PROVIDERS}, {@link android.content.pm.PackageManager#GET_RECEIVERS}, {@link android.content.pm.PackageManager#GET_SERVICES}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#GET_SIGNATURES}, {@link android.content.pm.PackageManager#GET_SIGNING_CERTIFICATES}, {@link android.content.pm.PackageManager#GET_URI_PERMISSION_PATTERNS}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, android.content.pm.PackageManager.MATCH_FACTORY_ONLY, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, android.content.pm.PackageManager.MATCH_INSTANT, {@link android.content.pm.PackageManager#MATCH_APEX}, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}, and android.content.pm.PackageManager.MATCH_HIDDEN_UNTIL_INSTALLED_COMPONENTS
 * @return A PackageInfo object containing information about the package
 *         archive. If the package could not be parsed, returns null.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public android.content.pm.PackageInfo getPackageArchiveInfo(@androidx.annotation.NonNull java.lang.String archiveFilePath, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Allows a package listening to the
 * {@link android.content.Intent#ACTION_PACKAGE_NEEDS_VERIFICATION Intent#ACTION_PACKAGE_NEEDS_VERIFICATION} to respond to the package manager. The response must include
 * the {@code verificationCode} which is one of
 * {@link android.content.pm.PackageManager#VERIFICATION_ALLOW PackageManager#VERIFICATION_ALLOW} or
 * {@link android.content.pm.PackageManager#VERIFICATION_REJECT PackageManager#VERIFICATION_REJECT}.
 *
 * @param id pending package identifier as passed via the
 *            {@link android.content.pm.PackageManager#EXTRA_VERIFICATION_ID PackageManager#EXTRA_VERIFICATION_ID} Intent extra.
 * @param verificationCode either {@link android.content.pm.PackageManager#VERIFICATION_ALLOW PackageManager#VERIFICATION_ALLOW}
 *            or {@link android.content.pm.PackageManager#VERIFICATION_REJECT PackageManager#VERIFICATION_REJECT}.
 * @throws java.lang.SecurityException if the caller does not have the
 *            PACKAGE_VERIFICATION_AGENT permission.
 * @apiSince 14
 */

public abstract void verifyPendingInstall(int id, int verificationCode);

/**
 * Allows a package listening to the
 * {@link android.content.Intent#ACTION_PACKAGE_NEEDS_VERIFICATION Intent#ACTION_PACKAGE_NEEDS_VERIFICATION} to extend the default timeout for a response and declare what
 * action to perform after the timeout occurs. The response must include
 * the {@code verificationCodeAtTimeout} which is one of
 * {@link android.content.pm.PackageManager#VERIFICATION_ALLOW PackageManager#VERIFICATION_ALLOW} or
 * {@link android.content.pm.PackageManager#VERIFICATION_REJECT PackageManager#VERIFICATION_REJECT}.
 *
 * This method may only be called once per package id. Additional calls
 * will have no effect.
 *
 * @param id pending package identifier as passed via the
 *            {@link android.content.pm.PackageManager#EXTRA_VERIFICATION_ID PackageManager#EXTRA_VERIFICATION_ID} Intent extra.
 * @param verificationCodeAtTimeout either
 *            {@link android.content.pm.PackageManager#VERIFICATION_ALLOW PackageManager#VERIFICATION_ALLOW} or
 *            {@link android.content.pm.PackageManager#VERIFICATION_REJECT PackageManager#VERIFICATION_REJECT}. If
 *            {@code verificationCodeAtTimeout} is neither
 *            {@link android.content.pm.PackageManager#VERIFICATION_ALLOW PackageManager#VERIFICATION_ALLOW} or
 *            {@link android.content.pm.PackageManager#VERIFICATION_REJECT PackageManager#VERIFICATION_REJECT}, then
 *            {@code verificationCodeAtTimeout} will default to
 *            {@link android.content.pm.PackageManager#VERIFICATION_REJECT PackageManager#VERIFICATION_REJECT}.
 * @param millisecondsToDelay the amount of time requested for the timeout.
 *            Must be positive and less than
 *            {@link android.content.pm.PackageManager#MAXIMUM_VERIFICATION_TIMEOUT PackageManager#MAXIMUM_VERIFICATION_TIMEOUT}. If
 *            {@code millisecondsToDelay} is out of bounds,
 *            {@code millisecondsToDelay} will be set to the closest in
 *            bounds value; namely, 0 or
 *            {@link android.content.pm.PackageManager#MAXIMUM_VERIFICATION_TIMEOUT PackageManager#MAXIMUM_VERIFICATION_TIMEOUT}.
 * @throws java.lang.SecurityException if the caller does not have the
 *            PACKAGE_VERIFICATION_AGENT permission.
 * @apiSince 17
 */

public abstract void extendVerificationTimeout(int id, int verificationCodeAtTimeout, long millisecondsToDelay);

/**
 * Change the installer associated with a given package.  There are limitations
 * on how the installer package can be changed; in particular:
 * <ul>
 * <li> A SecurityException will be thrown if <var>installerPackageName</var>
 * is not signed with the same certificate as the calling application.
 * <li> A SecurityException will be thrown if <var>targetPackage</var> already
 * has an installer package, and that installer package is not signed with
 * the same certificate as the calling application.
 * </ul>
 *
 * @param targetPackage The installed package whose installer will be changed.
 * This value must never be {@code null}.
 * @param installerPackageName The package name of the new installer.  May be
 * null to clear the association.
 
 * This value may be {@code null}.
 * @apiSince 11
 */

public abstract void setInstallerPackageName(@androidx.annotation.NonNull java.lang.String targetPackage, @androidx.annotation.Nullable java.lang.String installerPackageName);

/**
 * Retrieve the package name of the application that installed a package. This identifies
 * which market the package came from.
 *
 * @param packageName The name of the package to query
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if the given package name is not installed
 
 * @return This value may be {@code null}.
 * @apiSince 5
 */

@androidx.annotation.Nullable
public abstract java.lang.String getInstallerPackageName(@androidx.annotation.NonNull java.lang.String packageName);

/**
 * @deprecated This function no longer does anything. It is the platform's
 * responsibility to assign preferred activities and this cannot be modified
 * directly. To determine the activities resolved by the platform, use
 * {@link #resolveActivity} or {@link #queryIntentActivities}. To configure
 * an app to be responsible for a particular role and to check current role
 * holders, see {@link android.app.role.RoleManager}.
 
 * @param packageName This value must never be {@code null}.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public abstract void addPackageToPreferred(@androidx.annotation.NonNull java.lang.String packageName);

/**
 * @deprecated This function no longer does anything. It is the platform's
 * responsibility to assign preferred activities and this cannot be modified
 * directly. To determine the activities resolved by the platform, use
 * {@link #resolveActivity} or {@link #queryIntentActivities}. To configure
 * an app to be responsible for a particular role and to check current role
 * holders, see {@link android.app.role.RoleManager}.
 
 * @param packageName This value must never be {@code null}.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public abstract void removePackageFromPreferred(@androidx.annotation.NonNull java.lang.String packageName);

/**
 * Retrieve the list of all currently configured preferred packages. The
 * first package on the list is the most preferred, the last is the least
 * preferred.
 *
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_ACTIVITIES}, {@link android.content.pm.PackageManager#GET_CONFIGURATIONS}, {@link android.content.pm.PackageManager#GET_GIDS}, {@link android.content.pm.PackageManager#GET_INSTRUMENTATION}, {@link android.content.pm.PackageManager#GET_INTENT_FILTERS}, {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_PERMISSIONS}, {@link android.content.pm.PackageManager#GET_PROVIDERS}, {@link android.content.pm.PackageManager#GET_RECEIVERS}, {@link android.content.pm.PackageManager#GET_SERVICES}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#GET_SIGNATURES}, {@link android.content.pm.PackageManager#GET_SIGNING_CERTIFICATES}, {@link android.content.pm.PackageManager#GET_URI_PERMISSION_PATTERNS}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, android.content.pm.PackageManager.MATCH_FACTORY_ONLY, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, android.content.pm.PackageManager.MATCH_INSTANT, {@link android.content.pm.PackageManager#MATCH_APEX}, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}, and android.content.pm.PackageManager.MATCH_HIDDEN_UNTIL_INSTALLED_COMPONENTS
 * @return A List of PackageInfo objects, one for each preferred
 *         application, in order of preference.
 *
 * This value will never be {@code null}.
 * @deprecated This function no longer does anything. It is the platform's
 * responsibility to assign preferred activities and this cannot be modified
 * directly. To determine the activities resolved by the platform, use
 * {@link #resolveActivity} or {@link #queryIntentActivities}. To configure
 * an app to be responsible for a particular role and to check current role
 * holders, see {@link android.app.role.RoleManager}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
@androidx.annotation.NonNull
public abstract java.util.List<android.content.pm.PackageInfo> getPreferredPackages(int flags);

/**
 * Add a new preferred activity mapping to the system.  This will be used
 * to automatically select the given activity component when
 * {@link android.content.Context#startActivity(android.content.Intent) Context#startActivity(Intent)} finds
 * multiple matching activities and also matches the given filter.
 *
 * @param filter The set of intents under which this activity will be
 * made preferred.
 * This value must never be {@code null}.
 * @param match The IntentFilter match category that this preference
 * applies to.
 * @param set The set of activities that the user was picking from when
 * this preference was made.
 * This value may be {@code null}.
 * @param activity The component name of the activity that is to be
 * preferred.
 *
 * This value must never be {@code null}.
 * @deprecated This function no longer does anything. It is the platform's
 * responsibility to assign preferred activities and this cannot be modified
 * directly. To determine the activities resolved by the platform, use
 * {@link #resolveActivity} or {@link #queryIntentActivities}. To configure
 * an app to be responsible for a particular role and to check current role
 * holders, see {@link android.app.role.RoleManager}.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public abstract void addPreferredActivity(@androidx.annotation.NonNull android.content.IntentFilter filter, int match, @androidx.annotation.Nullable android.content.ComponentName[] set, @androidx.annotation.NonNull android.content.ComponentName activity);

/**
 * Remove all preferred activity mappings, previously added with
 * {@link #addPreferredActivity}, from the
 * system whose activities are implemented in the given package name.
 * An application can only clear its own package(s).
 *
 * @param packageName The name of the package whose preferred activity
 * mappings are to be removed.
 *
 * This value must never be {@code null}.
 * @deprecated This function no longer does anything. It is the platform's
 * responsibility to assign preferred activities and this cannot be modified
 * directly. To determine the activities resolved by the platform, use
 * {@link #resolveActivity} or {@link #queryIntentActivities}. To configure
 * an app to be responsible for a particular role and to check current role
 * holders, see {@link android.app.role.RoleManager}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public abstract void clearPackagePreferredActivities(@androidx.annotation.NonNull java.lang.String packageName);

/**
 * Retrieve all preferred activities, previously added with
 * {@link #addPreferredActivity}, that are
 * currently registered with the system.
 *
 * @param outFilters A required list in which to place the filters of all of the
 * preferred activities.
 * This value must never be {@code null}.
 * @param outActivities A required list in which to place the component names of
 * all of the preferred activities.
 * This value must never be {@code null}.
 * @param packageName An optional package in which you would like to limit
 * the list.  If null, all activities will be returned; if non-null, only
 * those activities in the given package are returned.
 *
 * This value may be {@code null}.
 * @return Returns the total number of registered preferred activities
 * (the number of distinct IntentFilter records, not the number of unique
 * activity components) that were found.
 *
 * @deprecated This function no longer does anything. It is the platform's
 * responsibility to assign preferred activities and this cannot be modified
 * directly. To determine the activities resolved by the platform, use
 * {@link #resolveActivity} or {@link #queryIntentActivities}. To configure
 * an app to be responsible for a particular role and to check current role
 * holders, see {@link android.app.role.RoleManager}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public abstract int getPreferredActivities(@androidx.annotation.NonNull java.util.List<android.content.IntentFilter> outFilters, @androidx.annotation.NonNull java.util.List<android.content.ComponentName> outActivities, @androidx.annotation.Nullable java.lang.String packageName);

/**
 * Set the enabled setting for a package component (activity, receiver, service, provider).
 * This setting will override any enabled state which may have been set by the component in its
 * manifest.
 *
 * @param componentName The component to enable
 * This value must never be {@code null}.
 * @param newState The new enabled state for the component.
 * Value is {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_DEFAULT}, {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_ENABLED}, {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_DISABLED}, {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_DISABLED_USER}, or {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_DISABLED_UNTIL_USED}
 * @param flags Optional behavior flags.
 
 * Value is either <code>0</code> or {@link android.content.pm.PackageManager#DONT_KILL_APP}
 * @apiSince 1
 */

public abstract void setComponentEnabledSetting(@androidx.annotation.NonNull android.content.ComponentName componentName, int newState, int flags);

/**
 * Return the enabled setting for a package component (activity,
 * receiver, service, provider).  This returns the last value set by
 * {@link #setComponentEnabledSetting(android.content.ComponentName,int,int)}; in most
 * cases this value will be {@link #COMPONENT_ENABLED_STATE_DEFAULT} since
 * the value originally specified in the manifest has not been modified.
 *
 * @param componentName The component to retrieve.
 * This value must never be {@code null}.
 * @return Returns the current enabled state for the component.
 
 * Value is {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_DEFAULT}, {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_ENABLED}, {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_DISABLED}, {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_DISABLED_USER}, or {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_DISABLED_UNTIL_USED}
 * @apiSince 1
 */

public abstract int getComponentEnabledSetting(@androidx.annotation.NonNull android.content.ComponentName componentName);

/**
 * Return whether a synthetic app details activity will be generated if the app has no enabled
 * launcher activity.
 *
 * @param packageName The package name of the app
 * This value must never be {@code null}.
 * @return Returns the enabled state for the synthetic app details activity.
 *
 *
 * @apiSince 29
 */

public boolean getSyntheticAppDetailsActivityEnabled(@androidx.annotation.NonNull java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * Set the enabled setting for an application
 * This setting will override any enabled state which may have been set by the application in
 * its manifest.  It also overrides the enabled state set in the manifest for any of the
 * application's components.  It does not override any enabled state set by
 * {@link #setComponentEnabledSetting} for any of the application's components.
 *
 * @param packageName The package name of the application to enable
 * This value must never be {@code null}.
 * @param newState The new enabled state for the application.
 * Value is {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_DEFAULT}, {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_ENABLED}, {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_DISABLED}, {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_DISABLED_USER}, or {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_DISABLED_UNTIL_USED}
 * @param flags Optional behavior flags.
 
 * Value is either <code>0</code> or {@link android.content.pm.PackageManager#DONT_KILL_APP}
 * @apiSince 1
 */

public abstract void setApplicationEnabledSetting(@androidx.annotation.NonNull java.lang.String packageName, int newState, int flags);

/**
 * Return the enabled setting for an application. This returns
 * the last value set by
 * {@link #setApplicationEnabledSetting(java.lang.String,int,int)}; in most
 * cases this value will be {@link #COMPONENT_ENABLED_STATE_DEFAULT} since
 * the value originally specified in the manifest has not been modified.
 *
 * @param packageName The package name of the application to retrieve.
 * This value must never be {@code null}.
 * @return Returns the current enabled state for the application.
 * Value is {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_DEFAULT}, {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_ENABLED}, {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_DISABLED}, {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_DISABLED_USER}, or {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_DISABLED_UNTIL_USED}
 * @throws java.lang.IllegalArgumentException if the named package does not exist.
 * @apiSince 1
 */

public abstract int getApplicationEnabledSetting(@androidx.annotation.NonNull java.lang.String packageName);

/**
 * Return whether the device has been booted into safe mode.
 * @apiSince 3
 */

public abstract boolean isSafeMode();

/**
 * Query if an app is currently suspended.
 *
 * @param packageName This value must never be {@code null}.
 * @return {@code true} if the given package is suspended, {@code false} otherwise
 * @throws android.content.pm.PackageManager.NameNotFoundException if the package could not be found.
 *
 * @see #isPackageSuspended()
 * @apiSince 29
 */

public boolean isPackageSuspended(@androidx.annotation.NonNull java.lang.String packageName) throws android.content.pm.PackageManager.NameNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Apps can query this to know if they have been suspended. A system app with the permission
 * {@code android.permission.SUSPEND_APPS} can put any app on the device into a suspended state.
 *
 * <p>While in this state, the application's notifications will be hidden, any of its started
 * activities will be stopped and it will not be able to show toasts or dialogs or play audio.
 * When the user tries to launch a suspended app, the system will, instead, show a
 * dialog to the user informing them that they cannot use this app while it is suspended.
 *
 * <p>When an app is put into this state, the broadcast action
 * {@link android.content.Intent#ACTION_MY_PACKAGE_SUSPENDED Intent#ACTION_MY_PACKAGE_SUSPENDED} will be delivered to any of its broadcast
 * receivers that included this action in their intent-filters, <em>including manifest
 * receivers.</em> Similarly, a broadcast action {@link android.content.Intent#ACTION_MY_PACKAGE_UNSUSPENDED Intent#ACTION_MY_PACKAGE_UNSUSPENDED}
 * is delivered when a previously suspended app is taken out of this state. Apps are expected to
 * use these to gracefully deal with transitions to and from this state.
 *
 * @return {@code true} if the calling package has been suspended, {@code false} otherwise.
 *
 * @see #getSuspendedPackageAppExtras()
 * @see android.content.Intent#ACTION_MY_PACKAGE_SUSPENDED
 * @see android.content.Intent#ACTION_MY_PACKAGE_UNSUSPENDED
 * @apiSince 28
 */

public boolean isPackageSuspended() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link android.os.Bundle Bundle} of extras that was meant to be sent to the calling app when it was
 * suspended. An app with the permission {@code android.permission.SUSPEND_APPS} can supply this
 * to the system at the time of suspending an app.
 *
 * <p>This is the same {@link android.os.Bundle Bundle} that is sent along with the broadcast
 * {@link android.content.Intent#ACTION_MY_PACKAGE_SUSPENDED Intent#ACTION_MY_PACKAGE_SUSPENDED}, whenever the app is suspended. The contents of
 * this {@link android.os.Bundle Bundle} are a contract between the suspended app and the suspending app.
 *
 * <p>Note: These extras are optional, so if no extras were supplied to the system, this method
 * will return {@code null}, even when the calling app has been suspended.
 *
 * @return A {@link android.os.Bundle Bundle} containing the extras for the app, or {@code null} if the
 * package is not currently suspended.
 *
 * @see #isPackageSuspended()
 * @see android.content.Intent#ACTION_MY_PACKAGE_UNSUSPENDED
 * @see android.content.Intent#ACTION_MY_PACKAGE_SUSPENDED
 * @see android.content.Intent#EXTRA_SUSPENDED_PACKAGE_EXTRAS
 * @apiSince 28
 */

@androidx.annotation.Nullable
public android.os.Bundle getSuspendedPackageAppExtras() { throw new RuntimeException("Stub!"); }

/**
 * Provide a hint of what the {@link android.content.pm.ApplicationInfo#category ApplicationInfo#category} value should
 * be for the given package.
 * <p>
 * This hint can only be set by the app which installed this package, as
 * determined by {@link #getInstallerPackageName(java.lang.String)}.
 *
 * @param packageName the package to change the category hint for.
 * This value must never be {@code null}.
 * @param categoryHint the category hint to set.
 
 * Value is {@link android.content.pm.ApplicationInfo#CATEGORY_UNDEFINED}, {@link android.content.pm.ApplicationInfo#CATEGORY_GAME}, {@link android.content.pm.ApplicationInfo#CATEGORY_AUDIO}, {@link android.content.pm.ApplicationInfo#CATEGORY_VIDEO}, {@link android.content.pm.ApplicationInfo#CATEGORY_IMAGE}, {@link android.content.pm.ApplicationInfo#CATEGORY_SOCIAL}, {@link android.content.pm.ApplicationInfo#CATEGORY_NEWS}, {@link android.content.pm.ApplicationInfo#CATEGORY_MAPS}, or {@link android.content.pm.ApplicationInfo#CATEGORY_PRODUCTIVITY}
 * @apiSince 26
 */

public abstract void setApplicationCategoryHint(@androidx.annotation.NonNull java.lang.String packageName, int categoryHint);

/**
 * Returns true if the device is upgrading, such as first boot after OTA.
 * @apiSince 29
 */

public boolean isDeviceUpgrading() { throw new RuntimeException("Stub!"); }

/**
 * Return interface that offers the ability to install, upgrade, and remove
 * applications on the device.
 
 * @return This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public abstract android.content.pm.PackageInstaller getPackageInstaller();

/**
 * Checks whether the calling package is allowed to request package installs through package
 * installer. Apps are encouraged to call this API before launching the package installer via
 * intent {@link android.content.Intent#ACTION_INSTALL_PACKAGE}. Starting from Android O, the
 * user can explicitly choose what external sources they trust to install apps on the device.
 * If this API returns false, the install request will be blocked by the package installer and
 * a dialog will be shown to the user with an option to launch settings to change their
 * preference. An application must target Android O or higher and declare permission
 * {@link android.Manifest.permission#REQUEST_INSTALL_PACKAGES} in order to use this API.
 *
 * @return true if the calling package is trusted by the user to request install packages on
 * the device, false otherwise.
 * @see android.content.Intent#ACTION_INSTALL_PACKAGE
 * @see android.provider.Settings#ACTION_MANAGE_UNKNOWN_APP_SOURCES
 * @apiSince 26
 */

public abstract boolean canRequestPackageInstalls();

/**
 * Searches the set of signing certificates by which the given package has proven to have been
 * signed.  This should be used instead of {@code getPackageInfo} with {@code GET_SIGNATURES}
 * since it takes into account the possibility of signing certificate rotation, except in the
 * case of packages that are signed by multiple certificates, for which signing certificate
 * rotation is not supported.  This method is analogous to using {@code getPackageInfo} with
 * {@code GET_SIGNING_CERTIFICATES} and then searching through the resulting {@code
 * signingInfo} field to see if the desired certificate is present.
 *
 * @param packageName package whose signing certificates to check
 * This value must never be {@code null}.
 * @param certificate signing certificate for which to search
 * This value must never be {@code null}.
 * @param type representation of the {@code certificate}
 * Value is {@link android.content.pm.PackageManager#CERT_INPUT_RAW_X509}, or {@link android.content.pm.PackageManager#CERT_INPUT_SHA256}
 * @return true if this package was or is signed by exactly the certificate {@code certificate}
 * @apiSince 28
 */

public boolean hasSigningCertificate(@androidx.annotation.NonNull java.lang.String packageName, @androidx.annotation.NonNull byte[] certificate, int type) { throw new RuntimeException("Stub!"); }

/**
 * Searches the set of signing certificates by which the package(s) for the given uid has proven
 * to have been signed.  For multiple packages sharing the same uid, this will return the
 * signing certificates found in the signing history of the "newest" package, where "newest"
 * indicates the package with the newest signing certificate in the shared uid group.  This
 * method should be used instead of {@code getPackageInfo} with {@code GET_SIGNATURES}
 * since it takes into account the possibility of signing certificate rotation, except in the
 * case of packages that are signed by multiple certificates, for which signing certificate
 * rotation is not supported. This method is analogous to using {@code getPackagesForUid}
 * followed by {@code getPackageInfo} with {@code GET_SIGNING_CERTIFICATES}, selecting the
 * {@code PackageInfo} of the newest-signed bpackage , and finally searching through the
 * resulting {@code signingInfo} field to see if the desired certificate is there.
 *
 * @param uid uid whose signing certificates to check
 * @param certificate signing certificate for which to search
 * This value must never be {@code null}.
 * @param type representation of the {@code certificate}
 * Value is {@link android.content.pm.PackageManager#CERT_INPUT_RAW_X509}, or {@link android.content.pm.PackageManager#CERT_INPUT_SHA256}
 * @return true if this package was or is signed by exactly the certificate {@code certificate}
 * @apiSince 28
 */

public boolean hasSigningCertificate(int uid, @androidx.annotation.NonNull byte[] certificate, int type) { throw new RuntimeException("Stub!"); }

/**
 * Certificate input bytes: the input bytes represent an encoded X.509 Certificate which could
 * be generated using an {@code CertificateFactory}
 * @apiSince 28
 */

public static final int CERT_INPUT_RAW_X509 = 0; // 0x0

/**
 * Certificate input bytes: the input bytes represent the SHA256 output of an encoded X.509
 * Certificate.
 * @apiSince 28
 */

public static final int CERT_INPUT_SHA256 = 1; // 0x1

/**
 * Flag for {@link #setApplicationEnabledSetting(java.lang.String,int,int)} and
 * {@link #setComponentEnabledSetting(android.content.ComponentName,int,int)}: This
 * component or application is in its default enabled state (as specified in
 * its manifest).
 * <p>
 * Explicitly setting the component state to this value restores it's
 * enabled state to whatever is set in the manifest.
 * @apiSince 1
 */

public static final int COMPONENT_ENABLED_STATE_DEFAULT = 0; // 0x0

/**
 * Flag for {@link #setApplicationEnabledSetting(java.lang.String,int,int)}
 * and {@link #setComponentEnabledSetting(android.content.ComponentName,int,int)}: This
 * component or application has been explicitly disabled, regardless of
 * what it has specified in its manifest.
 * @apiSince 1
 */

public static final int COMPONENT_ENABLED_STATE_DISABLED = 2; // 0x2

/**
 * Flag for {@link #setApplicationEnabledSetting(java.lang.String,int,int)} only: This
 * application should be considered, until the point where the user actually
 * wants to use it.  This means that it will not normally show up to the user
 * (such as in the launcher), but various parts of the user interface can
 * use {@link #GET_DISABLED_UNTIL_USED_COMPONENTS} to still see it and allow
 * the user to select it (as for example an IME, device admin, etc).  Such code,
 * once the user has selected the app, should at that point also make it enabled.
 * This option currently <strong>can not</strong> be used with
 * {@link #setComponentEnabledSetting(android.content.ComponentName,int,int)}.
 * @apiSince 18
 */

public static final int COMPONENT_ENABLED_STATE_DISABLED_UNTIL_USED = 4; // 0x4

/**
 * Flag for {@link #setApplicationEnabledSetting(java.lang.String,int,int)} only: The
 * user has explicitly disabled the application, regardless of what it has
 * specified in its manifest.  Because this is due to the user's request,
 * they may re-enable it if desired through the appropriate system UI.  This
 * option currently <strong>cannot</strong> be used with
 * {@link #setComponentEnabledSetting(android.content.ComponentName,int,int)}.
 * @apiSince 14
 */

public static final int COMPONENT_ENABLED_STATE_DISABLED_USER = 3; // 0x3

/**
 * Flag for {@link #setApplicationEnabledSetting(java.lang.String,int,int)}
 * and {@link #setComponentEnabledSetting(android.content.ComponentName,int,int)}: This
 * component or application has been explictily enabled, regardless of
 * what it has specified in its manifest.
 * @apiSince 1
 */

public static final int COMPONENT_ENABLED_STATE_ENABLED = 1; // 0x1

/**
 * Flag parameter for
 * {@link #setComponentEnabledSetting(android.content.ComponentName,int,int)} to indicate
 * that you don't want to kill the app containing the component.  Be careful when you set this
 * since changing component states can make the containing application's behavior unpredictable.
 * @apiSince 1
 */

public static final int DONT_KILL_APP = 1; // 0x1

/**
 * Extra field name for the ID of a package pending verification. Passed to
 * a package verifier and is used to call back to
 * {@link android.content.pm.PackageManager#verifyPendingInstall(int,int) PackageManager#verifyPendingInstall(int, int)}
 * @apiSince 14
 */

public static final java.lang.String EXTRA_VERIFICATION_ID = "android.content.pm.extra.VERIFICATION_ID";

/**
 * Extra field name for the result of a verification, either
 * {@link #VERIFICATION_ALLOW}, or {@link #VERIFICATION_REJECT}.
 * Passed to package verifiers after a package is verified.
 * @apiSince 17
 */

public static final java.lang.String EXTRA_VERIFICATION_RESULT = "android.content.pm.extra.VERIFICATION_RESULT";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}:
 * The device supports running activities on secondary displays.
 * @apiSince 26
 */

public static final java.lang.String FEATURE_ACTIVITIES_ON_SECONDARY_DISPLAYS = "android.software.activities_on_secondary_displays";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports app widgets.
 * @apiSince 18
 */

public static final java.lang.String FEATURE_APP_WIDGETS = "android.software.app_widgets";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}: The device's
 * audio pipeline is low-latency, more suitable for audio applications sensitive to delays or
 * lag in sound input or output.
 * @apiSince 9
 */

public static final java.lang.String FEATURE_AUDIO_LOW_LATENCY = "android.hardware.audio.low_latency";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device includes at least one form of audio
 * output, as defined in the Android Compatibility Definition Document (CDD)
 * <a href="https://source.android.com/compatibility/android-cdd#7_8_audio">section 7.8 Audio</a>.
 * @apiSince 21
 */

public static final java.lang.String FEATURE_AUDIO_OUTPUT = "android.hardware.audio.output";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}:
 * The device has professional audio level of functionality and performance.
 * @apiSince 23
 */

public static final java.lang.String FEATURE_AUDIO_PRO = "android.hardware.audio.pro";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}:
 * The device supports autofill of user credentials, addresses, credit cards, etc
 * via integration with {@link android.service.autofill.AutofillService autofill
 * providers}.
 * @apiSince 26
 */

public static final java.lang.String FEATURE_AUTOFILL = "android.software.autofill";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: This is a device dedicated to showing UI
 * on a vehicle headunit. A headunit here is defined to be inside a
 * vehicle that may or may not be moving. A headunit uses either a
 * primary display in the center console and/or additional displays in
 * the instrument cluster or elsewhere in the vehicle. Headunit display(s)
 * have limited size and resolution. The user will likely be focused on
 * driving so limiting driver distraction is a primary concern. User input
 * can be a variety of hard buttons, touch, rotary controllers and even mouse-
 * like interfaces.
 * @apiSince 23
 */

public static final java.lang.String FEATURE_AUTOMOTIVE = "android.hardware.type.automotive";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}:
 * The device can perform backup and restore operations on installed applications.
 * @apiSince 20
 */

public static final java.lang.String FEATURE_BACKUP = "android.software.backup";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device is capable of communicating with
 * other devices via Bluetooth.
 * @apiSince 8
 */

public static final java.lang.String FEATURE_BLUETOOTH = "android.hardware.bluetooth";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device is capable of communicating with
 * other devices via Bluetooth Low Energy radio.
 * @apiSince 18
 */

public static final java.lang.String FEATURE_BLUETOOTH_LE = "android.hardware.bluetooth_le";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device has a camera facing away
 * from the screen.
 * @apiSince 7
 */

public static final java.lang.String FEATURE_CAMERA = "android.hardware.camera";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device has at least one camera pointing in
 * some direction, or can support an external camera being connected to it.
 * @apiSince 17
 */

public static final java.lang.String FEATURE_CAMERA_ANY = "android.hardware.camera.any";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}: At least one
 * of the cameras on the device supports the
 * {@link android.hardware.camera2.CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_MOTION_TRACKING
 * MOTION_TRACKING} capability level.
 * @apiSince 28
 */

public static final java.lang.String FEATURE_CAMERA_AR = "android.hardware.camera.ar";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device's camera supports auto-focus.
 * @apiSince 7
 */

public static final java.lang.String FEATURE_CAMERA_AUTOFOCUS = "android.hardware.camera.autofocus";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}: At least one
 * of the cameras on the device supports the
 * {@link android.hardware.camera2.CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_MANUAL_POST_PROCESSING manual post-processing}
 * capability level.
 * @apiSince 21
 */

public static final java.lang.String FEATURE_CAMERA_CAPABILITY_MANUAL_POST_PROCESSING = "android.hardware.camera.capability.manual_post_processing";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}: At least one
 * of the cameras on the device supports the
 * {@link android.hardware.camera2.CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_MANUAL_SENSOR manual sensor}
 * capability level.
 * @apiSince 21
 */

public static final java.lang.String FEATURE_CAMERA_CAPABILITY_MANUAL_SENSOR = "android.hardware.camera.capability.manual_sensor";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}: At least one
 * of the cameras on the device supports the
 * {@link android.hardware.camera2.CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_RAW RAW}
 * capability level.
 * @apiSince 21
 */

public static final java.lang.String FEATURE_CAMERA_CAPABILITY_RAW = "android.hardware.camera.capability.raw";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device can support having an external camera connected to it.
 * The external camera may not always be connected or available to applications to use.
 * @apiSince 20
 */

public static final java.lang.String FEATURE_CAMERA_EXTERNAL = "android.hardware.camera.external";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device's camera supports flash.
 * @apiSince 7
 */

public static final java.lang.String FEATURE_CAMERA_FLASH = "android.hardware.camera.flash";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device has a front facing camera.
 * @apiSince 9
 */

public static final java.lang.String FEATURE_CAMERA_FRONT = "android.hardware.camera.front";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}: At least one
 * of the cameras on the device supports the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL full hardware}
 * capability level.
 * @apiSince 21
 */

public static final java.lang.String FEATURE_CAMERA_LEVEL_FULL = "android.hardware.camera.level.full";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports the
 * {@link android.R.attr#cantSaveState} API.
 * @apiSince 28
 */

public static final java.lang.String FEATURE_CANT_SAVE_STATE = "android.software.cant_save_state";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}:
 * The device supports {@link android.companion.CompanionDeviceManager#associate associating}
 * with devices via {@link android.companion.CompanionDeviceManager}.
 * @apiSince 26
 */

public static final java.lang.String FEATURE_COMPANION_DEVICE_SETUP = "android.software.companion_device_setup";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The Connection Service API is enabled on the device.
 * @apiSince 21
 */

public static final java.lang.String FEATURE_CONNECTION_SERVICE = "android.software.connectionservice";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device is capable of communicating with
 * consumer IR devices.
 * @apiSince 19
 */

public static final java.lang.String FEATURE_CONSUMER_IR = "android.hardware.consumerir";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports device policy enforcement via device admins.
 * @apiSince 19
 */

public static final java.lang.String FEATURE_DEVICE_ADMIN = "android.software.device_admin";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: This is a device for IoT and may not have an UI. An embedded
 * device is defined as a full stack Android device with or without a display and no
 * user-installable apps.
 * @apiSince 26
 */

public static final java.lang.String FEATURE_EMBEDDED = "android.hardware.type.embedded";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: This device supports ethernet.
 * @apiSince 24
 */

public static final java.lang.String FEATURE_ETHERNET = "android.hardware.ethernet";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device has biometric hardware to perform face authentication.
 * @apiSince 29
 */

public static final java.lang.String FEATURE_FACE = "android.hardware.biometrics.face";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device does not have a touch screen, but
 * does support touch emulation for basic events. For instance, the
 * device might use a mouse or remote control to drive a cursor, and
 * emulate basic touch pointer events like down, up, drag, etc. All
 * devices that support android.hardware.touchscreen or a sub-feature are
 * presumed to also support faketouch.
 * @apiSince 11
 */

public static final java.lang.String FEATURE_FAKETOUCH = "android.hardware.faketouch";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device does not have a touch screen, but
 * does support touch emulation for basic events that supports distinct
 * tracking of two or more fingers.  This is an extension of
 * {@link #FEATURE_FAKETOUCH} for input devices with this capability.  Note
 * that unlike a distinct multitouch screen as defined by
 * {@link #FEATURE_TOUCHSCREEN_MULTITOUCH_DISTINCT}, these kinds of input
 * devices will not actually provide full two-finger gestures since the
 * input is being transformed to cursor movement on the screen.  That is,
 * single finger gestures will move a cursor; two-finger swipes will
 * result in single-finger touch events; other two-finger gestures will
 * result in the corresponding two-finger touch event.
 * @apiSince 13
 */

public static final java.lang.String FEATURE_FAKETOUCH_MULTITOUCH_DISTINCT = "android.hardware.faketouch.multitouch.distinct";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device does not have a touch screen, but
 * does support touch emulation for basic events that supports tracking
 * a hand of fingers (5 or more fingers) fully independently.
 * This is an extension of
 * {@link #FEATURE_FAKETOUCH} for input devices with this capability.  Note
 * that unlike a multitouch screen as defined by
 * {@link #FEATURE_TOUCHSCREEN_MULTITOUCH_JAZZHAND}, not all two finger
 * gestures can be detected due to the limitations described for
 * {@link #FEATURE_FAKETOUCH_MULTITOUCH_DISTINCT}.
 * @apiSince 13
 */

public static final java.lang.String FEATURE_FAKETOUCH_MULTITOUCH_JAZZHAND = "android.hardware.faketouch.multitouch.jazzhand";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device has biometric hardware to detect a fingerprint.
 * @apiSince 23
 */

public static final java.lang.String FEATURE_FINGERPRINT = "android.hardware.fingerprint";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports freeform window management.
 * Windows have title bars and can be moved and resized.
 * @apiSince 24
 */

public static final java.lang.String FEATURE_FREEFORM_WINDOW_MANAGEMENT = "android.software.freeform_window_management";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}:
 * The device has all of the inputs necessary to be considered a compatible game controller, or
 * includes a compatible game controller in the box.
 * @apiSince 21
 */

public static final java.lang.String FEATURE_GAMEPAD = "android.hardware.gamepad";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports high fidelity sensor processing
 * capabilities.
 * @apiSince 23
 */

public static final java.lang.String FEATURE_HIFI_SENSORS = "android.hardware.sensor.hifi_sensors";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports a home screen that is replaceable
 * by third party applications.
 * @apiSince 18
 */

public static final java.lang.String FEATURE_HOME_SCREEN = "android.software.home_screen";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports adding new input methods implemented
 * with the {@link android.inputmethodservice.InputMethodService} API.
 * @apiSince 18
 */

public static final java.lang.String FEATURE_INPUT_METHODS = "android.software.input_methods";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}: The device has
 * the requisite kernel support for multinetworking-capable IPsec tunnels.
 *
 * <p>This feature implies that the device supports XFRM Interfaces (CONFIG_XFRM_INTERFACE), or
 * VTIs with kernel patches allowing updates of output/set mark via UPDSA.
 * @apiSince 29
 */

public static final java.lang.String FEATURE_IPSEC_TUNNELS = "android.software.ipsec_tunnels";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device has biometric hardware to perform iris authentication.
 * @apiSince 29
 */

public static final java.lang.String FEATURE_IRIS = "android.hardware.biometrics.iris";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports leanback UI. This is
 * typically used in a living room television experience, but is a software
 * feature unlike {@link #FEATURE_TELEVISION}. Devices running with this
 * feature will use resources associated with the "television" UI mode.
 * @apiSince 21
 */

public static final java.lang.String FEATURE_LEANBACK = "android.software.leanback";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports only leanback UI. Only
 * applications designed for this experience should be run, though this is
 * not enforced by the system.
 * @apiSince 26
 */

public static final java.lang.String FEATURE_LEANBACK_ONLY = "android.software.leanback_only";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports live TV and can display
 * contents from TV inputs implemented with the
 * {@link android.media.tv.TvInputService} API.
 * @apiSince 21
 */

public static final java.lang.String FEATURE_LIVE_TV = "android.software.live_tv";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports live wallpapers.
 * @apiSince 7
 */

public static final java.lang.String FEATURE_LIVE_WALLPAPER = "android.software.live_wallpaper";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports one or more methods of
 * reporting current location.
 * @apiSince 8
 */

public static final java.lang.String FEATURE_LOCATION = "android.hardware.location";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device has a Global Positioning System
 * receiver and can report precise location.
 * @apiSince 8
 */

public static final java.lang.String FEATURE_LOCATION_GPS = "android.hardware.location.gps";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device can report location with coarse
 * accuracy using a network-based geolocation system.
 * @apiSince 8
 */

public static final java.lang.String FEATURE_LOCATION_NETWORK = "android.hardware.location.network";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}:
 * The device supports creating secondary users and managed profiles via
 * {@link android.app.admin.DevicePolicyManager DevicePolicyManager}.
 * @apiSince 21
 */

public static final java.lang.String FEATURE_MANAGED_USERS = "android.software.managed_users";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device can record audio via a
 * microphone.
 * @apiSince 8
 */

public static final java.lang.String FEATURE_MICROPHONE = "android.hardware.microphone";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}:
 * The device has a full implementation of the android.media.midi.* APIs.
 * @apiSince 23
 */

public static final java.lang.String FEATURE_MIDI = "android.software.midi";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device can communicate using Near-Field
 * Communications (NFC).
 * @apiSince 9
 */

public static final java.lang.String FEATURE_NFC = "android.hardware.nfc";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The Beam API is enabled on the device.
 * @apiSince 29
 */

public static final java.lang.String FEATURE_NFC_BEAM = "android.sofware.nfc.beam";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports host-
 * based NFC card emulation.
 * @apiSince 19
 */

public static final java.lang.String FEATURE_NFC_HOST_CARD_EMULATION = "android.hardware.nfc.hce";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports host-
 * based NFC-F card emulation.
 * @apiSince 24
 */

public static final java.lang.String FEATURE_NFC_HOST_CARD_EMULATION_NFCF = "android.hardware.nfc.hcef";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports eSE-
 * based NFC card emulation.
 * @apiSince 29
 */

public static final java.lang.String FEATURE_NFC_OFF_HOST_CARD_EMULATION_ESE = "android.hardware.nfc.ese";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports uicc-
 * based NFC card emulation.
 * @apiSince 29
 */

public static final java.lang.String FEATURE_NFC_OFF_HOST_CARD_EMULATION_UICC = "android.hardware.nfc.uicc";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports the OpenGL ES
 * <a href="http://www.khronos.org/registry/gles/extensions/ANDROID/ANDROID_extension_pack_es31a.txt">
 * Android Extension Pack</a>.
 * @apiSince 21
 */

public static final java.lang.String FEATURE_OPENGLES_EXTENSION_PACK = "android.hardware.opengles.aep";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: This is a device dedicated to be primarily used
 * with keyboard, mouse or touchpad. This includes traditional desktop
 * computers, laptops and variants such as convertibles or detachables.
 * Due to the larger screen, the device will most likely use the
 * {@link #FEATURE_FREEFORM_WINDOW_MANAGEMENT} feature as well.
 * @apiSince 27
 */

public static final java.lang.String FEATURE_PC = "android.hardware.type.pc";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}:
 * The device supports picture-in-picture multi-window mode.
 * @apiSince 24
 */

public static final java.lang.String FEATURE_PICTURE_IN_PICTURE = "android.software.picture_in_picture";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}:
 * The device supports printing.
 * @apiSince 20
 */

public static final java.lang.String FEATURE_PRINTING = "android.software.print";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device's
 * {@link android.app.ActivityManager#isLowRamDevice() ActivityManager#isLowRamDevice()} method returns
 * true.
 * @apiSince 27
 */

public static final java.lang.String FEATURE_RAM_LOW = "android.hardware.ram.low";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device's
 * {@link android.app.ActivityManager#isLowRamDevice() ActivityManager#isLowRamDevice()} method returns
 * false.
 * @apiSince 27
 */

public static final java.lang.String FEATURE_RAM_NORMAL = "android.hardware.ram.normal";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports landscape orientation
 * screens.  For backwards compatibility, you can assume that if neither
 * this nor {@link #FEATURE_SCREEN_PORTRAIT} is set then the device supports
 * both portrait and landscape.
 * @apiSince 13
 */

public static final java.lang.String FEATURE_SCREEN_LANDSCAPE = "android.hardware.screen.landscape";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports portrait orientation
 * screens.  For backwards compatibility, you can assume that if neither
 * this nor {@link #FEATURE_SCREEN_LANDSCAPE} is set then the device supports
 * both portrait and landscape.
 * @apiSince 13
 */

public static final java.lang.String FEATURE_SCREEN_PORTRAIT = "android.hardware.screen.portrait";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}:
 * The device supports secure removal of users. When a user is deleted the data associated
 * with that user is securely deleted and no longer available.
 * @apiSince 21
 */

public static final java.lang.String FEATURE_SECURELY_REMOVES_USERS = "android.software.securely_removes_users";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device has a secure implementation of keyguard, meaning the
 * device supports PIN, pattern and password as defined in Android CDD
 * @apiSince 29
 */

public static final java.lang.String FEATURE_SECURE_LOCK_SCREEN = "android.software.secure_lock_screen";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device includes an accelerometer.
 * @apiSince 8
 */

public static final java.lang.String FEATURE_SENSOR_ACCELEROMETER = "android.hardware.sensor.accelerometer";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device includes an ambient temperature sensor.
 * @apiSince 21
 */

public static final java.lang.String FEATURE_SENSOR_AMBIENT_TEMPERATURE = "android.hardware.sensor.ambient_temperature";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device includes a barometer (air
 * pressure sensor.)
 * @apiSince 9
 */

public static final java.lang.String FEATURE_SENSOR_BAROMETER = "android.hardware.sensor.barometer";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device includes a magnetometer (compass).
 * @apiSince 8
 */

public static final java.lang.String FEATURE_SENSOR_COMPASS = "android.hardware.sensor.compass";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device includes a gyroscope.
 * @apiSince 9
 */

public static final java.lang.String FEATURE_SENSOR_GYROSCOPE = "android.hardware.sensor.gyroscope";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device includes a heart rate monitor.
 * @apiSince 20
 */

public static final java.lang.String FEATURE_SENSOR_HEART_RATE = "android.hardware.sensor.heartrate";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The heart rate sensor on this device is an Electrocardiogram.
 * @apiSince 21
 */

public static final java.lang.String FEATURE_SENSOR_HEART_RATE_ECG = "android.hardware.sensor.heartrate.ecg";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device includes a light sensor.
 * @apiSince 7
 */

public static final java.lang.String FEATURE_SENSOR_LIGHT = "android.hardware.sensor.light";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device includes a proximity sensor.
 * @apiSince 7
 */

public static final java.lang.String FEATURE_SENSOR_PROXIMITY = "android.hardware.sensor.proximity";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device includes a relative humidity sensor.
 * @apiSince 21
 */

public static final java.lang.String FEATURE_SENSOR_RELATIVE_HUMIDITY = "android.hardware.sensor.relative_humidity";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device includes a hardware step counter.
 * @apiSince 19
 */

public static final java.lang.String FEATURE_SENSOR_STEP_COUNTER = "android.hardware.sensor.stepcounter";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device includes a hardware step detector.
 * @apiSince 19
 */

public static final java.lang.String FEATURE_SENSOR_STEP_DETECTOR = "android.hardware.sensor.stepdetector";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports Open Mobile API capable eSE-based secure
 * elements.
 * @apiSince R
 */

public static final java.lang.String FEATURE_SE_OMAPI_ESE = "android.hardware.se.omapi.ese";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports Open Mobile API capable SD-based secure
 * elements.
 * @apiSince R
 */

public static final java.lang.String FEATURE_SE_OMAPI_SD = "android.hardware.se.omapi.sd";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports Open Mobile API capable UICC-based secure
 * elements.
 * @apiSince R
 */

public static final java.lang.String FEATURE_SE_OMAPI_UICC = "android.hardware.se.omapi.uicc";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The SIP API is enabled on the device.
 * @apiSince 9
 */

public static final java.lang.String FEATURE_SIP = "android.software.sip";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports SIP-based VOIP.
 * @apiSince 9
 */

public static final java.lang.String FEATURE_SIP_VOIP = "android.software.sip.voip";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}:
 * The device has a StrongBox hardware-backed Keystore.
 * @apiSince 28
 */

public static final java.lang.String FEATURE_STRONGBOX_KEYSTORE = "android.hardware.strongbox_keystore";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device has a telephony radio with data
 * communication support.
 * @apiSince 7
 */

public static final java.lang.String FEATURE_TELEPHONY = "android.hardware.telephony";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device has a CDMA telephony stack.
 * @apiSince 7
 */

public static final java.lang.String FEATURE_TELEPHONY_CDMA = "android.hardware.telephony.cdma";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}: The device
 * supports embedded subscriptions on eUICCs.
 * @apiSince 28
 */

public static final java.lang.String FEATURE_TELEPHONY_EUICC = "android.hardware.telephony.euicc";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device has a GSM telephony stack.
 * @apiSince 7
 */

public static final java.lang.String FEATURE_TELEPHONY_GSM = "android.hardware.telephony.gsm";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}: The device
 * supports attaching to IMS implementations using the ImsService API in telephony.
 * @apiSince 29
 */

public static final java.lang.String FEATURE_TELEPHONY_IMS = "android.hardware.telephony.ims";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}: The device
 * supports cell-broadcast reception using the MBMS APIs.
 * @apiSince 28
 */

public static final java.lang.String FEATURE_TELEPHONY_MBMS = "android.hardware.telephony.mbms";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: This is a device dedicated to showing UI
 * on a television.  Television here is defined to be a typical living
 * room television experience: displayed on a big screen, where the user
 * is sitting far away from it, and the dominant form of input will be
 * something like a DPAD, not through touch or mouse.
 * @deprecated use {@link #FEATURE_LEANBACK} instead.
 * @apiSince 16
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String FEATURE_TELEVISION = "android.hardware.type.television";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device's display has a touch screen.
 * @apiSince 8
 */

public static final java.lang.String FEATURE_TOUCHSCREEN = "android.hardware.touchscreen";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device's touch screen supports
 * multitouch sufficient for basic two-finger gesture detection.
 * @apiSince 7
 */

public static final java.lang.String FEATURE_TOUCHSCREEN_MULTITOUCH = "android.hardware.touchscreen.multitouch";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device's touch screen is capable of
 * tracking two or more fingers fully independently.
 * @apiSince 8
 */

public static final java.lang.String FEATURE_TOUCHSCREEN_MULTITOUCH_DISTINCT = "android.hardware.touchscreen.multitouch.distinct";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device's touch screen is capable of
 * tracking a full hand of fingers fully independently -- that is, 5 or
 * more simultaneous independent pointers.
 * @apiSince 9
 */

public static final java.lang.String FEATURE_TOUCHSCREEN_MULTITOUCH_JAZZHAND = "android.hardware.touchscreen.multitouch.jazzhand";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports connecting to USB accessories.
 * @apiSince 12
 */

public static final java.lang.String FEATURE_USB_ACCESSORY = "android.hardware.usb.accessory";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports connecting to USB devices
 * as the USB host.
 * @apiSince 12
 */

public static final java.lang.String FEATURE_USB_HOST = "android.hardware.usb.host";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}:
 * The device supports verified boot.
 * @apiSince 21
 */

public static final java.lang.String FEATURE_VERIFIED_BOOT = "android.software.verified_boot";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}:
 * The device implements headtracking suitable for a VR device.
 * @apiSince 26
 */

public static final java.lang.String FEATURE_VR_HEADTRACKING = "android.hardware.vr.headtracking";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}:
 * The device implements an optimized mode for virtual reality (VR) applications that handles
 * stereoscopic rendering of notifications, and disables most monocular system UI components
 * while a VR application has user focus.
 * Devices declaring this feature must include an application implementing a
 * {@link android.service.vr.VrListenerService} that can be targeted by VR applications via
 * {@link android.app.Activity#setVrModeEnabled}.
 * @deprecated use {@link #FEATURE_VR_MODE_HIGH_PERFORMANCE} instead.
 * @apiSince 24
 * @deprecatedSince 28
 */

@Deprecated public static final java.lang.String FEATURE_VR_MODE = "android.software.vr.mode";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}:
 * The device implements an optimized mode for virtual reality (VR) applications that handles
 * stereoscopic rendering of notifications, disables most monocular system UI components
 * while a VR application has user focus and meets extra CDD requirements to provide a
 * high-quality VR experience.
 * Devices declaring this feature must include an application implementing a
 * {@link android.service.vr.VrListenerService} that can be targeted by VR applications via
 * {@link android.app.Activity#setVrModeEnabled}.
 * and must meet CDD requirements to provide a high-quality VR experience.
 * @apiSince 24
 */

public static final java.lang.String FEATURE_VR_MODE_HIGH_PERFORMANCE = "android.hardware.vr.high_performance";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature(java.lang.String,int)}: If this feature is supported, the Vulkan
 * implementation on this device is hardware accelerated, and the Vulkan native API will
 * enumerate at least one {@code VkPhysicalDevice}, and the feature version will indicate what
 * level of optional compute features that device supports beyond the Vulkan 1.0 requirements.
 * <p>
 * Compute level 0 indicates:
 * <ul>
 * <li>The {@code VK_KHR_variable_pointers} extension and
 *     {@code VkPhysicalDeviceVariablePointerFeaturesKHR::variablePointers} feature are
      supported.</li>
 * <li>{@code VkPhysicalDeviceLimits::maxPerStageDescriptorStorageBuffers} is at least 16.</li>
 * </ul>
 * @apiSince 26
 */

public static final java.lang.String FEATURE_VULKAN_HARDWARE_COMPUTE = "android.hardware.vulkan.compute";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature(java.lang.String,int)}: If this feature is supported, the Vulkan
 * implementation on this device is hardware accelerated, and the Vulkan native API will
 * enumerate at least one {@code VkPhysicalDevice}, and the feature version will indicate what
 * level of optional hardware features limits it supports.
 * <p>
 * Level 0 includes the base Vulkan requirements as well as:
 * <ul><li>{@code VkPhysicalDeviceFeatures::textureCompressionETC2}</li></ul>
 * <p>
 * Level 1 additionally includes:
 * <ul>
 * <li>{@code VkPhysicalDeviceFeatures::fullDrawIndexUint32}</li>
 * <li>{@code VkPhysicalDeviceFeatures::imageCubeArray}</li>
 * <li>{@code VkPhysicalDeviceFeatures::independentBlend}</li>
 * <li>{@code VkPhysicalDeviceFeatures::geometryShader}</li>
 * <li>{@code VkPhysicalDeviceFeatures::tessellationShader}</li>
 * <li>{@code VkPhysicalDeviceFeatures::sampleRateShading}</li>
 * <li>{@code VkPhysicalDeviceFeatures::textureCompressionASTC_LDR}</li>
 * <li>{@code VkPhysicalDeviceFeatures::fragmentStoresAndAtomics}</li>
 * <li>{@code VkPhysicalDeviceFeatures::shaderImageGatherExtended}</li>
 * <li>{@code VkPhysicalDeviceFeatures::shaderUniformBufferArrayDynamicIndexing}</li>
 * <li>{@code VkPhysicalDeviceFeatures::shaderSampledImageArrayDynamicIndexing}</li>
 * </ul>
 * @apiSince 24
 */

public static final java.lang.String FEATURE_VULKAN_HARDWARE_LEVEL = "android.hardware.vulkan.level";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature(java.lang.String,int)}: If this feature is supported, the Vulkan
 * implementation on this device is hardware accelerated, and the feature version will indicate
 * the highest {@code VkPhysicalDeviceProperties::apiVersion} supported by the physical devices
 * that support the hardware level indicated by {@link #FEATURE_VULKAN_HARDWARE_LEVEL}. The
 * feature version uses the same encoding as Vulkan version numbers:
 * <ul>
 * <li>Major version number in bits 31-22</li>
 * <li>Minor version number in bits 21-12</li>
 * <li>Patch version number in bits 11-0</li>
 * </ul>
 * A version of 1.1.0 or higher also indicates:
 * <ul>
 * <li>The {@code VK_ANDROID_external_memory_android_hardware_buffer} extension is
 *     supported.</li>
 * <li>{@code SYNC_FD} external semaphore and fence handles are supported.</li>
 * <li>{@code VkPhysicalDeviceSamplerYcbcrConversionFeatures::samplerYcbcrConversion} is
 *     supported.</li>
 * </ul>
 * @apiSince 24
 */

public static final java.lang.String FEATURE_VULKAN_HARDWARE_VERSION = "android.hardware.vulkan.version";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: This is a device dedicated to showing UI
 * on a watch. A watch here is defined to be a device worn on the body, perhaps on
 * the wrist. The user is very close when interacting with the device.
 * @apiSince 20
 */

public static final java.lang.String FEATURE_WATCH = "android.hardware.type.watch";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}:
 * The device has a full implementation of the android.webkit.* APIs. Devices
 * lacking this feature will not have a functioning WebView implementation.
 * @apiSince 20
 */

public static final java.lang.String FEATURE_WEBVIEW = "android.software.webview";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports WiFi (802.11) networking.
 * @apiSince 8
 */

public static final java.lang.String FEATURE_WIFI = "android.hardware.wifi";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports Wi-Fi Aware.
 * @apiSince 26
 */

public static final java.lang.String FEATURE_WIFI_AWARE = "android.hardware.wifi.aware";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports Wi-Fi Direct networking.
 * @apiSince 14
 */

public static final java.lang.String FEATURE_WIFI_DIRECT = "android.hardware.wifi.direct";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports Wi-Fi Passpoint and all
 * Passpoint related APIs in {@link android.net.wifi.WifiManager WifiManager} are supported. Refer to
 * {@link android.net.wifi.WifiManager#addOrUpdatePasspointConfiguration WifiManager#addOrUpdatePasspointConfiguration} for more info.
 * @apiSince 27
 */

public static final java.lang.String FEATURE_WIFI_PASSPOINT = "android.hardware.wifi.passpoint";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports Wi-Fi RTT (IEEE 802.11mc).
 * @apiSince 28
 */

public static final java.lang.String FEATURE_WIFI_RTT = "android.hardware.wifi.rtt";

/**
 * Permission whitelist flag: permissions whitelisted by the installer.
 * Permissions can also be whitelisted by the system or on upgrade.
 * @apiSince 29
 */

public static final int FLAG_PERMISSION_WHITELIST_INSTALLER = 2; // 0x2

/**
 * Permission whitelist flag: permissions whitelisted by the system.
 * Permissions can also be whitelisted by the installer or on upgrade.
 * @apiSince 29
 */

public static final int FLAG_PERMISSION_WHITELIST_SYSTEM = 1; // 0x1

/**
 * Permission whitelist flag: permissions whitelisted by the system
 * when upgrading from an OS version where the permission was not
 * restricted to an OS version where the permission is restricted.
 * Permissions can also be whitelisted by the installer or the system.
 * @apiSince 29
 */

public static final int FLAG_PERMISSION_WHITELIST_UPGRADE = 4; // 0x4

/**
 * {@link android.content.pm.PackageInfo PackageInfo} flag: return information about
 * activities in the package in {@link android.content.pm.PackageInfo#activities PackageInfo#activities}.
 * @apiSince 1
 */

public static final int GET_ACTIVITIES = 1; // 0x1

/**
 * {@link android.content.pm.PackageInfo PackageInfo} flag: return information about
 * hardware preferences in
 * {@link android.content.pm.PackageInfo#configPreferences PackageInfo#configPreferences},
 * and requested features in {@link android.content.pm.PackageInfo#reqFeatures PackageInfo#reqFeatures} and
 * {@link android.content.pm.PackageInfo#featureGroups PackageInfo#featureGroups}.
 * @apiSince 3
 */

public static final int GET_CONFIGURATIONS = 16384; // 0x4000

/**
 * @deprecated replaced with {@link #MATCH_DISABLED_COMPONENTS}
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated public static final int GET_DISABLED_COMPONENTS = 512; // 0x200

/**
 * @deprecated replaced with {@link #MATCH_DISABLED_UNTIL_USED_COMPONENTS}.
 * @apiSince 18
 * @deprecatedSince 24
 */

@Deprecated public static final int GET_DISABLED_UNTIL_USED_COMPONENTS = 32768; // 0x8000

/**
 * {@link android.content.pm.PackageInfo PackageInfo} flag: return the
 * {@link android.content.pm.PackageInfo#gids PackageInfo#gids} that are associated with an
 * application.
 * This applies for any API returning a PackageInfo class, either
 * directly or nested inside of another.
 * @apiSince 1
 */

public static final int GET_GIDS = 256; // 0x100

/**
 * {@link android.content.pm.PackageInfo PackageInfo} flag: return information about
 * instrumentation in the package in
 * {@link android.content.pm.PackageInfo#instrumentation PackageInfo#instrumentation}.
 * @apiSince 1
 */

public static final int GET_INSTRUMENTATION = 16; // 0x10

/**
 * {@link android.content.pm.PackageInfo PackageInfo} flag: return information about the
 * intent filters supported by the activity.
 * @apiSince 1
 */

public static final int GET_INTENT_FILTERS = 32; // 0x20

/**
 * {@link android.content.pm.ComponentInfo ComponentInfo} flag: return the {@link android.content.pm.ComponentInfo#metaData ComponentInfo#metaData}
 * data {@link android.os.Bundle}s that are associated with a component.
 * This applies for any API returning a ComponentInfo subclass.
 * @apiSince 1
 */

public static final int GET_META_DATA = 128; // 0x80

/**
 * {@link android.content.pm.PackageInfo PackageInfo} flag: return information about
 * permissions in the package in
 * {@link android.content.pm.PackageInfo#permissions PackageInfo#permissions}.
 * @apiSince 1
 */

public static final int GET_PERMISSIONS = 4096; // 0x1000

/**
 * {@link android.content.pm.PackageInfo PackageInfo} flag: return information about
 * content providers in the package in
 * {@link android.content.pm.PackageInfo#providers PackageInfo#providers}.
 * @apiSince 1
 */

public static final int GET_PROVIDERS = 8; // 0x8

/**
 * {@link android.content.pm.PackageInfo PackageInfo} flag: return information about
 * intent receivers in the package in
 * {@link android.content.pm.PackageInfo#receivers PackageInfo#receivers}.
 * @apiSince 1
 */

public static final int GET_RECEIVERS = 2; // 0x2

/**
 * {@link android.content.pm.ResolveInfo ResolveInfo} flag: return the IntentFilter that
 * was matched for a particular ResolveInfo in
 * {@link android.content.pm.ResolveInfo#filter ResolveInfo#filter}.
 * @apiSince 1
 */

public static final int GET_RESOLVED_FILTER = 64; // 0x40

/**
 * {@link android.content.pm.PackageInfo PackageInfo} flag: return information about
 * services in the package in {@link android.content.pm.PackageInfo#services PackageInfo#services}.
 * @apiSince 1
 */

public static final int GET_SERVICES = 4; // 0x4

/**
 * {@link android.content.pm.ApplicationInfo ApplicationInfo} flag: return the
 * {@link android.content.pm.ApplicationInfo#sharedLibraryFiles ApplicationInfo#sharedLibraryFiles}
 * that are associated with an application.
 * This applies for any API returning an ApplicationInfo class, either
 * directly or nested inside of another.
 * @apiSince 1
 */

public static final int GET_SHARED_LIBRARY_FILES = 1024; // 0x400

/**
 * {@link android.content.pm.PackageInfo PackageInfo} flag: return information about the
 * signatures included in the package.
 *
 * @deprecated use {@code GET_SIGNING_CERTIFICATES} instead
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated public static final int GET_SIGNATURES = 64; // 0x40

/**
 * {@link android.content.pm.PackageInfo PackageInfo} flag: return the signing certificates associated with
 * this package.  Each entry is a signing certificate that the package
 * has proven it is authorized to use, usually a past signing certificate from
 * which it has rotated.
 * @apiSince 28
 */

public static final int GET_SIGNING_CERTIFICATES = 134217728; // 0x8000000

/**
 * @deprecated replaced with {@link #MATCH_UNINSTALLED_PACKAGES}
 * @apiSince 3
 * @deprecatedSince 24
 */

@Deprecated public static final int GET_UNINSTALLED_PACKAGES = 8192; // 0x2000

/**
 * {@link android.content.pm.ProviderInfo ProviderInfo} flag: return the
 * {@link android.content.pm.ProviderInfo#uriPermissionPatterns ProviderInfo#uriPermissionPatterns}
 * that are associated with a content provider.
 * This applies for any API returning a ProviderInfo class, either
 * directly or nested inside of another.
 * @apiSince 1
 */

public static final int GET_URI_PERMISSION_PATTERNS = 2048; // 0x800

/**
 * Code indicating that this package was installed as part of restoring from another device.
 * @apiSince 26
 */

public static final int INSTALL_REASON_DEVICE_RESTORE = 2; // 0x2

/**
 * Code indicating that this package was installed as part of device setup.
 * @apiSince 26
 */

public static final int INSTALL_REASON_DEVICE_SETUP = 3; // 0x3

/**
 * Code indicating that this package was installed due to enterprise policy.
 * @apiSince 26
 */

public static final int INSTALL_REASON_POLICY = 1; // 0x1

/**
 * Code indicating that the reason for installing this package is unknown.
 * @apiSince 26
 */

public static final int INSTALL_REASON_UNKNOWN = 0; // 0x0

/**
 * Code indicating that the package installation was initiated by the user.
 * @apiSince 26
 */

public static final int INSTALL_REASON_USER = 4; // 0x4

/**
 * Querying flag: if set and if the platform is doing any filtering of the
 * results, then the filtering will not happen. This is a synonym for saying
 * that all results should be returned.
 * <p>
 * <em>This flag should be used with extreme care.</em>
 * @apiSince 23
 */

public static final int MATCH_ALL = 131072; // 0x20000

/**
 * {@link android.content.pm.PackageInfo PackageInfo} flag: include APEX packages that are currently
 * installed. In APEX terminology, this corresponds to packages that are
 * currently active, i.e. mounted and available to other processes of the OS.
 * In particular, this flag alone will not match APEX files that are staged
 * for activation at next reboot.
 * @apiSince 29
 */

public static final int MATCH_APEX = 1073741824; // 0x40000000

/**
 * Resolution and querying flag: if set, only filters that support the
 * {@link android.content.Intent#CATEGORY_DEFAULT} will be considered for
 * matching.  This is a synonym for including the CATEGORY_DEFAULT in your
 * supplied Intent.
 * @apiSince 1
 */

public static final int MATCH_DEFAULT_ONLY = 65536; // 0x10000

/**
 * Querying flag: automatically match components based on their Direct Boot
 * awareness and the current user state.
 * <p>
 * Since the default behavior is to automatically apply the current user
 * state, this is effectively a sentinel value that doesn't change the
 * output of any queries based on its presence or absence.
 * <p>
 * Instead, this value can be useful in conjunction with
 * {@link android.os.StrictMode.VmPolicy.Builder#detectImplicitDirectBoot()}
 * to detect when a caller is relying on implicit automatic matching,
 * instead of confirming the explicit behavior they want, using a
 * combination of these flags:
 * <ul>
 * <li>{@link #MATCH_DIRECT_BOOT_AWARE}
 * <li>{@link #MATCH_DIRECT_BOOT_UNAWARE}
 * <li>{@link #MATCH_DIRECT_BOOT_AUTO}
 * </ul>
 * @apiSince 29
 */

public static final int MATCH_DIRECT_BOOT_AUTO = 268435456; // 0x10000000

/**
 * Querying flag: match components which are direct boot <em>aware</em> in
 * the returned info, regardless of the current user state.
 * <p>
 * When neither {@link #MATCH_DIRECT_BOOT_AWARE} nor
 * {@link #MATCH_DIRECT_BOOT_UNAWARE} are specified, the default behavior is
 * to match only runnable components based on the user state. For example,
 * when a user is started but credentials have not been presented yet, the
 * user is running "locked" and only {@link #MATCH_DIRECT_BOOT_AWARE}
 * components are returned. Once the user credentials have been presented,
 * the user is running "unlocked" and both {@link #MATCH_DIRECT_BOOT_AWARE}
 * and {@link #MATCH_DIRECT_BOOT_UNAWARE} components are returned.
 *
 * @see android.os.UserManager#isUserUnlocked()
 * @apiSince 24
 */

public static final int MATCH_DIRECT_BOOT_AWARE = 524288; // 0x80000

/**
 * Querying flag: match components which are direct boot <em>unaware</em> in
 * the returned info, regardless of the current user state.
 * <p>
 * When neither {@link #MATCH_DIRECT_BOOT_AWARE} nor
 * {@link #MATCH_DIRECT_BOOT_UNAWARE} are specified, the default behavior is
 * to match only runnable components based on the user state. For example,
 * when a user is started but credentials have not been presented yet, the
 * user is running "locked" and only {@link #MATCH_DIRECT_BOOT_AWARE}
 * components are returned. Once the user credentials have been presented,
 * the user is running "unlocked" and both {@link #MATCH_DIRECT_BOOT_AWARE}
 * and {@link #MATCH_DIRECT_BOOT_UNAWARE} components are returned.
 *
 * @see android.os.UserManager#isUserUnlocked()
 * @apiSince 24
 */

public static final int MATCH_DIRECT_BOOT_UNAWARE = 262144; // 0x40000

/**
 * {@link android.content.pm.PackageInfo PackageInfo} flag: include disabled components in the returned info.
 * @apiSince 24
 */

public static final int MATCH_DISABLED_COMPONENTS = 512; // 0x200

/**
 * {@link android.content.pm.PackageInfo PackageInfo} flag: include disabled components which are in
 * that state only because of {@link #COMPONENT_ENABLED_STATE_DISABLED_UNTIL_USED}
 * in the returned info.  Note that if you set this flag, applications
 * that are in this disabled state will be reported as enabled.
 * @apiSince 24
 */

public static final int MATCH_DISABLED_UNTIL_USED_COMPONENTS = 32768; // 0x8000

/**
 * Querying flag: include only components from applications that are marked
 * with {@link android.content.pm.ApplicationInfo#FLAG_SYSTEM ApplicationInfo#FLAG_SYSTEM}.
 * @apiSince 24
 */

public static final int MATCH_SYSTEM_ONLY = 1048576; // 0x100000

/**
 * Flag parameter to retrieve some information about all applications (even
 * uninstalled ones) which have data directories. This state could have
 * resulted if applications have been deleted with flag
 * {@code DONT_DELETE_DATA} with a possibility of being replaced or
 * reinstalled in future.
 * <p>
 * Note: this flag may cause less information about currently installed
 * applications to be returned.
 * @apiSince 24
 */

public static final int MATCH_UNINSTALLED_PACKAGES = 8192; // 0x2000

/**
 * Can be used as the {@code millisecondsToDelay} argument for
 * {@link android.content.pm.PackageManager#extendVerificationTimeout PackageManager#extendVerificationTimeout}. This is the
 * maximum time {@code PackageManager} waits for the verification
 * agent to return (in milliseconds).
 * @apiSince 17
 */

public static final long MAXIMUM_VERIFICATION_TIMEOUT = 3600000L; // 0x36ee80L

/**
 * Permission check result: this is returned by {@link #checkPermission}
 * if the permission has not been granted to the given package.
 * @apiSince 1
 */

public static final int PERMISSION_DENIED = -1; // 0xffffffff

/**
 * Permission check result: this is returned by {@link #checkPermission}
 * if the permission has been granted to the given package.
 * @apiSince 1
 */

public static final int PERMISSION_GRANTED = 0; // 0x0

/**
 * Signature check result: this is returned by {@link #checkSignatures}
 * if the first package is not signed but the second is.
 * @apiSince 1
 */

public static final int SIGNATURE_FIRST_NOT_SIGNED = -1; // 0xffffffff

/**
 * Signature check result: this is returned by {@link #checkSignatures}
 * if all signatures on the two packages match.
 * @apiSince 1
 */

public static final int SIGNATURE_MATCH = 0; // 0x0

/**
 * Signature check result: this is returned by {@link #checkSignatures}
 * if neither of the two packages is signed.
 * @apiSince 1
 */

public static final int SIGNATURE_NEITHER_SIGNED = 1; // 0x1

/**
 * Signature check result: this is returned by {@link #checkSignatures}
 * if not all signatures on both packages match.
 * @apiSince 1
 */

public static final int SIGNATURE_NO_MATCH = -3; // 0xfffffffd

/**
 * Signature check result: this is returned by {@link #checkSignatures}
 * if the second package is not signed but the first is.
 * @apiSince 1
 */

public static final int SIGNATURE_SECOND_NOT_SIGNED = -2; // 0xfffffffe

/**
 * Signature check result: this is returned by {@link #checkSignatures}
 * if either of the packages are not valid.
 * @apiSince 1
 */

public static final int SIGNATURE_UNKNOWN_PACKAGE = -4; // 0xfffffffc

/**
 * Used as the {@code verificationCode} argument for
 * {@link android.content.pm.PackageManager#verifyPendingInstall PackageManager#verifyPendingInstall} to indicate that the calling
 * package verifier allows the installation to proceed.
 * @apiSince 14
 */

public static final int VERIFICATION_ALLOW = 1; // 0x1

/**
 * Used as the {@code verificationCode} argument for
 * {@link android.content.pm.PackageManager#verifyPendingInstall PackageManager#verifyPendingInstall} to indicate the calling
 * package verifier does not vote to allow the installation to proceed.
 * @apiSince 14
 */

public static final int VERIFICATION_REJECT = -1; // 0xffffffff

/**
 * Constant for specifying the highest installed package version code.
 * @apiSince 26
 */

public static final int VERSION_CODE_HIGHEST = -1; // 0xffffffff
/**
 * This exception is thrown when a given package, application, or component
 * name cannot be found.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class NameNotFoundException extends android.util.AndroidException {

/** @apiSince 1 */

public NameNotFoundException() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public NameNotFoundException(java.lang.String name) { throw new RuntimeException("Stub!"); }
}

}

