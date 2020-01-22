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


package android.os;

import android.content.Context;
import android.content.Intent;
import android.Manifest;
import android.provider.MediaStore;
import java.io.File;
import android.app.admin.DevicePolicyManager;

/**
 * Provides access to environment variables.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Environment {

public Environment() { throw new RuntimeException("Stub!"); }

/**
 * Return root of the "system" partition holding the core Android OS.
 * Always present and mounted read-only.
 
 * @return This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.io.File getRootDirectory() { throw new RuntimeException("Stub!"); }

/**
 * Return the user data directory.
 * @apiSince 1
 */

public static java.io.File getDataDirectory() { throw new RuntimeException("Stub!"); }

/**
 * Return the primary shared/external storage directory. This directory may
 * not currently be accessible if it has been mounted by the user on their
 * computer, has been removed from the device, or some other problem has
 * happened. You can determine its current state with
 * {@link #getExternalStorageState()}.
 * <p>
 * <em>Note: don't be confused by the word "external" here. This directory
 * can better be thought as media/shared storage. It is a filesystem that
 * can hold a relatively large amount of data and that is shared across all
 * applications (does not enforce permissions). Traditionally this is an SD
 * card, but it may also be implemented as built-in storage in a device that
 * is distinct from the protected internal storage and can be mounted as a
 * filesystem on a computer.</em>
 * <p>
 * On devices with multiple users (as described by {@link android.os.UserManager UserManager}),
 * each user has their own isolated shared storage. Applications only have
 * access to the shared storage for the user they're running as.
 * <p>
 * In devices with multiple shared/external storage directories, this
 * directory represents the primary storage that the user will interact
 * with. Access to secondary storage is available through
 * {@link android.content.Context#getExternalFilesDirs(java.lang.String) Context#getExternalFilesDirs(String)},
 * {@link android.content.Context#getExternalCacheDirs() Context#getExternalCacheDirs()}, and
 * {@link android.content.Context#getExternalMediaDirs() Context#getExternalMediaDirs()}.
 * <p>
 * Applications should not directly use this top-level directory, in order
 * to avoid polluting the user's root namespace. Any files that are private
 * to the application should be placed in a directory returned by
 * {@link android.content.Context#getExternalFilesDir
 * Context.getExternalFilesDir}, which the system will take care of deleting
 * if the application is uninstalled. Other shared files should be placed in
 * one of the directories returned by
 * {@link #getExternalStoragePublicDirectory}.
 * <p>
 * Writing to this path requires the
 * {@link android.Manifest.permission#WRITE_EXTERNAL_STORAGE} permission,
 * and starting in {@link android.os.Build.VERSION_CODES#KITKAT}, read
 * access requires the
 * {@link android.Manifest.permission#READ_EXTERNAL_STORAGE} permission,
 * which is automatically granted if you hold the write permission.
 * <p>
 * Starting in {@link android.os.Build.VERSION_CODES#KITKAT}, if your
 * application only needs to store internal data, consider using
 * {@link android.content.Context#getExternalFilesDir(java.lang.String) Context#getExternalFilesDir(String)},
 * {@link android.content.Context#getExternalCacheDir() Context#getExternalCacheDir()}, or
 * {@link android.content.Context#getExternalMediaDirs() Context#getExternalMediaDirs()}, which require no permissions to
 * read or write.
 * <p>
 * This path may change between platform versions, so applications should
 * only persist relative paths.
 * <p>
 * Here is an example of typical code to monitor the state of external
 * storage:
 * <p>
 * {@sample development/samples/ApiDemos/src/com/example/android/apis/content/ExternalStorage.java
 * monitor_storage}
 *
 * @see #getExternalStorageState()
 * @see #isExternalStorageRemovable()
 * @deprecated To improve user privacy, direct access to shared/external
 *             storage devices is deprecated. When an app targets
 *             {@link android.os.Build.VERSION_CODES#Q}, the path returned
 *             from this method is no longer directly accessible to apps.
 *             Apps can continue to access content stored on shared/external
 *             storage by migrating to alternatives such as
 *             {@link android.content.Context#getExternalFilesDir(java.lang.String) Context#getExternalFilesDir(String)},
 *             {@link android.provider.MediaStore MediaStore}, or {@link android.content.Intent#ACTION_OPEN_DOCUMENT Intent#ACTION_OPEN_DOCUMENT}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public static java.io.File getExternalStorageDirectory() { throw new RuntimeException("Stub!"); }

/**
 * Get a top-level shared/external storage directory for placing files of a
 * particular type. This is where the user will typically place and manage
 * their own files, so you should be careful about what you put here to
 * ensure you don't erase their files or get in the way of their own
 * organization.
 * <p>
 * On devices with multiple users (as described by {@link android.os.UserManager UserManager}),
 * each user has their own isolated shared storage. Applications only have
 * access to the shared storage for the user they're running as.
 * </p>
 * <p>
 * Here is an example of typical code to manipulate a picture on the public
 * shared storage:
 * </p>
 * {@sample development/samples/ApiDemos/src/com/example/android/apis/content/ExternalStorage.java
 * public_picture}
 *
 * @param type The type of storage directory to return. Should be one of
 *            {@link #DIRECTORY_MUSIC}, {@link #DIRECTORY_PODCASTS},
 *            {@link #DIRECTORY_RINGTONES}, {@link #DIRECTORY_ALARMS},
 *            {@link #DIRECTORY_NOTIFICATIONS}, {@link #DIRECTORY_PICTURES},
 *            {@link #DIRECTORY_MOVIES}, {@link #DIRECTORY_DOWNLOADS},
 *            {@link #DIRECTORY_DCIM}, or {@link #DIRECTORY_DOCUMENTS}. May not be null.
 * @return Returns the File path for the directory. Note that this directory
 *         may not yet exist, so you must make sure it exists before using
 *         it such as with {@link java.io.File#mkdirs File#mkdirs}.
 * @deprecated To improve user privacy, direct access to shared/external
 *             storage devices is deprecated. When an app targets
 *             {@link android.os.Build.VERSION_CODES#Q}, the path returned
 *             from this method is no longer directly accessible to apps.
 *             Apps can continue to access content stored on shared/external
 *             storage by migrating to alternatives such as
 *             {@link android.content.Context#getExternalFilesDir(java.lang.String) Context#getExternalFilesDir(String)},
 *             {@link android.provider.MediaStore MediaStore}, or {@link android.content.Intent#ACTION_OPEN_DOCUMENT Intent#ACTION_OPEN_DOCUMENT}.
 * @apiSince 8
 * @deprecatedSince 29
 */

@Deprecated
public static java.io.File getExternalStoragePublicDirectory(java.lang.String type) { throw new RuntimeException("Stub!"); }

/**
 * Return the download/cache content directory.
 * @apiSince 1
 */

public static java.io.File getDownloadCacheDirectory() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current state of the primary shared/external storage media.
 *
 * @see #getExternalStorageDirectory()
 * @return one of {@link #MEDIA_UNKNOWN}, {@link #MEDIA_REMOVED},
 *         {@link #MEDIA_UNMOUNTED}, {@link #MEDIA_CHECKING},
 *         {@link #MEDIA_NOFS}, {@link #MEDIA_MOUNTED},
 *         {@link #MEDIA_MOUNTED_READ_ONLY}, {@link #MEDIA_SHARED},
 *         {@link #MEDIA_BAD_REMOVAL}, or {@link #MEDIA_UNMOUNTABLE}.
 * @apiSince 1
 */

public static java.lang.String getExternalStorageState() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated use {@link #getExternalStorageState(java.io.File)}
 * @apiSince 19
 * @deprecatedSince 21
 */

@Deprecated
public static java.lang.String getStorageState(java.io.File path) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current state of the shared/external storage media at the
 * given path.
 *
 * @return one of {@link #MEDIA_UNKNOWN}, {@link #MEDIA_REMOVED},
 *         {@link #MEDIA_UNMOUNTED}, {@link #MEDIA_CHECKING},
 *         {@link #MEDIA_NOFS}, {@link #MEDIA_MOUNTED},
 *         {@link #MEDIA_MOUNTED_READ_ONLY}, {@link #MEDIA_SHARED},
 *         {@link #MEDIA_BAD_REMOVAL}, or {@link #MEDIA_UNMOUNTABLE}.
 * @apiSince 21
 */

public static java.lang.String getExternalStorageState(java.io.File path) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the primary shared/external storage media is physically
 * removable.
 *
 * @return true if the storage device can be removed (such as an SD card),
 *         or false if the storage device is built in and cannot be
 *         physically removed.
 * @apiSince 9
 */

public static boolean isExternalStorageRemovable() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the shared/external storage media at the given path is
 * physically removable.
 *
 * @param path This value must never be {@code null}.
 * @return true if the storage device can be removed (such as an SD card),
 *         or false if the storage device is built in and cannot be
 *         physically removed.
 * @throws java.lang.IllegalArgumentException if the path is not a valid storage
 *             device.
 * @apiSince 21
 */

public static boolean isExternalStorageRemovable(@androidx.annotation.NonNull java.io.File path) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the primary shared/external storage media is emulated.
 * <p>
 * The contents of emulated storage devices are backed by a private user
 * data partition, which means there is little benefit to apps storing data
 * here instead of the private directories returned by
 * {@link android.content.Context#getFilesDir() Context#getFilesDir()}, etc.
 * <p>
 * This returns true when emulated storage is backed by either internal
 * storage or an adopted storage device.
 *
 * @see android.app.admin.DevicePolicyManager#setStorageEncryption(android.content.ComponentName,
 *      boolean)
 * @apiSince 11
 */

public static boolean isExternalStorageEmulated() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the shared/external storage media at the given path is
 * emulated.
 * <p>
 * The contents of emulated storage devices are backed by a private user
 * data partition, which means there is little benefit to apps storing data
 * here instead of the private directories returned by
 * {@link android.content.Context#getFilesDir() Context#getFilesDir()}, etc.
 * <p>
 * This returns true when emulated storage is backed by either internal
 * storage or an adopted storage device.
 *
 * @throws java.lang.IllegalArgumentException if the path is not a valid storage
 *             device.
 
 * @param path This value must never be {@code null}.
 * @apiSince 21
 */

public static boolean isExternalStorageEmulated(@androidx.annotation.NonNull java.io.File path) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the primary shared/external storage media is a legacy
 * view that includes files not owned by the app.
 * <p>
 * This value may be different from the value requested by
 * {@code requestLegacyExternalStorage} in the app's manifest, since an app
 * may inherit its legacy state based on when it was first installed.
 * <p>
 * Non-legacy apps can continue to discover and read media belonging to
 * other apps via {@link android.provider.MediaStore}.
 * @apiSince 29
 */

public static boolean isExternalStorageLegacy() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the shared/external storage media at the given path is a
 * legacy view that includes files not owned by the app.
 * <p>
 * This value may be different from the value requested by
 * {@code requestLegacyExternalStorage} in the app's manifest, since an app
 * may inherit its legacy state based on when it was first installed.
 * <p>
 * Non-legacy apps can continue to discover and read media belonging to
 * other apps via {@link android.provider.MediaStore}.
 *
 * @throws java.lang.IllegalArgumentException if the path is not a valid storage
 *             device.
 
 * @param path This value must never be {@code null}.
 * @apiSince 29
 */

public static boolean isExternalStorageLegacy(@androidx.annotation.NonNull java.io.File path) { throw new RuntimeException("Stub!"); }

/**
 * Standard directory in which to place any audio files that should be
 * in the list of alarms that the user can select (not as regular
 * music).
 * This may be combined with {@link #DIRECTORY_MUSIC},
 * {@link #DIRECTORY_PODCASTS}, {@link #DIRECTORY_NOTIFICATIONS},
 * and {@link #DIRECTORY_RINGTONES} as a series
 * of directories to categories a particular audio file as more than one
 * type.
 * @apiSince 8
 */

public static java.lang.String DIRECTORY_ALARMS = "Alarms";

/**
 * Standard directory in which to place any audio files which are
 * audiobooks.
 * @apiSince 29
 */

public static java.lang.String DIRECTORY_AUDIOBOOKS = "Audiobooks";

/**
 * The traditional location for pictures and videos when mounting the
 * device as a camera.  Note that this is primarily a convention for the
 * top-level public directory, as this convention makes no sense elsewhere.
 * @apiSince 8
 */

public static java.lang.String DIRECTORY_DCIM = "DCIM";

/**
 * Standard directory in which to place documents that have been created by
 * the user.
 * @apiSince 19
 */

public static java.lang.String DIRECTORY_DOCUMENTS = "Documents";

/**
 * Standard directory in which to place files that have been downloaded by
 * the user.  Note that this is primarily a convention for the top-level
 * public directory, you are free to download files anywhere in your own
 * private directories.  Also note that though the constant here is
 * named DIRECTORY_DOWNLOADS (plural), the actual file name is non-plural for
 * backwards compatibility reasons.
 * @apiSince 8
 */

public static java.lang.String DIRECTORY_DOWNLOADS = "Download";

/**
 * Standard directory in which to place movies that are available to
 * the user.  Note that this is primarily a convention for the top-level
 * public directory, as the media scanner will find and collect movies
 * in any directory.
 * @apiSince 8
 */

public static java.lang.String DIRECTORY_MOVIES = "Movies";

/**
 * Standard directory in which to place any audio files that should be
 * in the regular list of music for the user.
 * This may be combined with
 * {@link #DIRECTORY_PODCASTS}, {@link #DIRECTORY_NOTIFICATIONS},
 * {@link #DIRECTORY_ALARMS}, and {@link #DIRECTORY_RINGTONES} as a series
 * of directories to categories a particular audio file as more than one
 * type.
 * @apiSince 8
 */

public static java.lang.String DIRECTORY_MUSIC = "Music";

/**
 * Standard directory in which to place any audio files that should be
 * in the list of notifications that the user can select (not as regular
 * music).
 * This may be combined with {@link #DIRECTORY_MUSIC},
 * {@link #DIRECTORY_PODCASTS},
 * {@link #DIRECTORY_ALARMS}, and {@link #DIRECTORY_RINGTONES} as a series
 * of directories to categories a particular audio file as more than one
 * type.
 * @apiSince 8
 */

public static java.lang.String DIRECTORY_NOTIFICATIONS = "Notifications";

/**
 * Standard directory in which to place pictures that are available to
 * the user.  Note that this is primarily a convention for the top-level
 * public directory, as the media scanner will find and collect pictures
 * in any directory.
 * @apiSince 8
 */

public static java.lang.String DIRECTORY_PICTURES = "Pictures";

/**
 * Standard directory in which to place any audio files that should be
 * in the list of podcasts that the user can select (not as regular
 * music).
 * This may be combined with {@link #DIRECTORY_MUSIC},
 * {@link #DIRECTORY_NOTIFICATIONS},
 * {@link #DIRECTORY_ALARMS}, and {@link #DIRECTORY_RINGTONES} as a series
 * of directories to categories a particular audio file as more than one
 * type.
 * @apiSince 8
 */

public static java.lang.String DIRECTORY_PODCASTS = "Podcasts";

/**
 * Standard directory in which to place any audio files that should be
 * in the list of ringtones that the user can select (not as regular
 * music).
 * This may be combined with {@link #DIRECTORY_MUSIC},
 * {@link #DIRECTORY_PODCASTS}, {@link #DIRECTORY_NOTIFICATIONS}, and
 * {@link #DIRECTORY_ALARMS} as a series
 * of directories to categories a particular audio file as more than one
 * type.
 * @apiSince 8
 */

public static java.lang.String DIRECTORY_RINGTONES = "Ringtones";

/**
 * Standard directory in which to place screenshots that have been taken by
 * the user. Typically used as a secondary directory under
 * {@link #DIRECTORY_PICTURES}.
 * @apiSince 29
 */

public static java.lang.String DIRECTORY_SCREENSHOTS = "Screenshots";

/**
 * Storage state if the media was removed before it was unmounted.
 *
 * @see #getExternalStorageState(File)
 * @apiSince 1
 */

public static final java.lang.String MEDIA_BAD_REMOVAL = "bad_removal";

/**
 * Storage state if the media is present and being disk-checked.
 *
 * @see #getExternalStorageState(File)
 * @apiSince 3
 */

public static final java.lang.String MEDIA_CHECKING = "checking";

/**
 * Storage state if the media is in the process of being ejected.
 *
 * @see #getExternalStorageState(File)
 * @apiSince 23
 */

public static final java.lang.String MEDIA_EJECTING = "ejecting";

/**
 * Storage state if the media is present and mounted at its mount point with
 * read/write access.
 *
 * @see #getExternalStorageState(File)
 * @apiSince 1
 */

public static final java.lang.String MEDIA_MOUNTED = "mounted";

/**
 * Storage state if the media is present and mounted at its mount point with
 * read-only access.
 *
 * @see #getExternalStorageState(File)
 * @apiSince 1
 */

public static final java.lang.String MEDIA_MOUNTED_READ_ONLY = "mounted_ro";

/**
 * Storage state if the media is present but is blank or is using an
 * unsupported filesystem.
 *
 * @see #getExternalStorageState(File)
 * @apiSince 3
 */

public static final java.lang.String MEDIA_NOFS = "nofs";

/**
 * Storage state if the media is not present.
 *
 * @see #getExternalStorageState(File)
 * @apiSince 1
 */

public static final java.lang.String MEDIA_REMOVED = "removed";

/**
 * Storage state if the media is present not mounted, and shared via USB
 * mass storage.
 *
 * @see #getExternalStorageState(File)
 * @apiSince 1
 */

public static final java.lang.String MEDIA_SHARED = "shared";

/**
 * Unknown storage state, such as when a path isn't backed by known storage
 * media.
 *
 * @see #getExternalStorageState(File)
 * @apiSince 19
 */

public static final java.lang.String MEDIA_UNKNOWN = "unknown";

/**
 * Storage state if the media is present but cannot be mounted. Typically
 * this happens if the file system on the media is corrupted.
 *
 * @see #getExternalStorageState(File)
 * @apiSince 1
 */

public static final java.lang.String MEDIA_UNMOUNTABLE = "unmountable";

/**
 * Storage state if the media is present but not mounted.
 *
 * @see #getExternalStorageState(File)
 * @apiSince 1
 */

public static final java.lang.String MEDIA_UNMOUNTED = "unmounted";
}

