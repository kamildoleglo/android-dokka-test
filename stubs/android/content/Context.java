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


package android.content;

import android.content.res.Configuration;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.pm.PackageManager;
import android.os.Looper;
import java.util.concurrent.Executor;
import android.util.AttributeSet;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.UserManager;
import android.os.Environment;
import android.os.StatFs;
import java.io.IOException;
import android.os.storage.StorageManager;
import android.provider.MediaStore;
import android.database.sqlite.SQLiteDatabase;
import android.database.DatabaseErrorHandler;
import android.graphics.Bitmap;
import java.io.InputStream;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserHandle;
import android.os.IBinder;
import android.app.ActivityManager;
import android.view.WindowManager;
import android.net.Uri;
import android.view.Display;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.view.textclassifier.TextClassificationManager;
import android.view.View;

/**
 * Interface to global information about an application environment.  This is
 * an abstract class whose implementation is provided by
 * the Android system.  It
 * allows access to application-specific resources and classes, as well as
 * up-calls for application-level operations such as launching activities,
 * broadcasting and receiving intents, etc.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class Context {

public Context() { throw new RuntimeException("Stub!"); }

/**
 * Returns an AssetManager instance for the application's package.
 * <p>
 * <strong>Note:</strong> Implementations of this method should return
 * an AssetManager instance that is consistent with the Resources instance
 * returned by {@link #getResources()}. For example, they should share the
 * same {@link android.content.res.Configuration Configuration} object.
 *
 * @return an AssetManager instance for the application's package
 * @see #getResources()
 * @apiSince 1
 */

public abstract android.content.res.AssetManager getAssets();

/**
 * Returns a Resources instance for the application's package.
 * <p>
 * <strong>Note:</strong> Implementations of this method should return
 * a Resources instance that is consistent with the AssetManager instance
 * returned by {@link #getAssets()}. For example, they should share the
 * same {@link android.content.res.Configuration Configuration} object.
 *
 * @return a Resources instance for the application's package
 * @see #getAssets()
 * @apiSince 1
 */

public abstract android.content.res.Resources getResources();

/**
 * Return PackageManager instance to find global package information.
 * @apiSince 1
 */

public abstract android.content.pm.PackageManager getPackageManager();

/**
 * Return a ContentResolver instance for your application's package.
 * @apiSince 1
 */

public abstract android.content.ContentResolver getContentResolver();

/**
 * Return the Looper for the main thread of the current process.  This is
 * the thread used to dispatch calls to application components (activities,
 * services, etc).
 * <p>
 * By definition, this method returns the same result as would be obtained
 * by calling {@link android.os.Looper#getMainLooper() Looper#getMainLooper()}.
 * </p>
 *
 * @return The main looper.
 * @apiSince 1
 */

public abstract android.os.Looper getMainLooper();

/**
 * Return an {@link java.util.concurrent.Executor Executor} that will run enqueued tasks on the main
 * thread associated with this context. This is the thread used to dispatch
 * calls to application components (activities, services, etc).
 * @apiSince 28
 */

public java.util.concurrent.Executor getMainExecutor() { throw new RuntimeException("Stub!"); }

/**
 * Return the context of the single, global Application object of the
 * current process.  This generally should only be used if you need a
 * Context whose lifecycle is separate from the current context, that is
 * tied to the lifetime of the process rather than the current component.
 *
 * <p>Consider for example how this interacts with
 * {@link #registerReceiver(android.content.BroadcastReceiver,android.content.IntentFilter)}:
 * <ul>
 * <li> <p>If used from an Activity context, the receiver is being registered
 * within that activity.  This means that you are expected to unregister
 * before the activity is done being destroyed; in fact if you do not do
 * so, the framework will clean up your leaked registration as it removes
 * the activity and log an error.  Thus, if you use the Activity context
 * to register a receiver that is static (global to the process, not
 * associated with an Activity instance) then that registration will be
 * removed on you at whatever point the activity you used is destroyed.
 * <li> <p>If used from the Context returned here, the receiver is being
 * registered with the global state associated with your application.  Thus
 * it will never be unregistered for you.  This is necessary if the receiver
 * is associated with static data, not a particular component.  However
 * using the ApplicationContext elsewhere can easily lead to serious leaks
 * if you forget to unregister, unbind, etc.
 * </ul>
 * @apiSince 1
 */

public abstract android.content.Context getApplicationContext();

/**
 * Add a new {@link android.content.ComponentCallbacks ComponentCallbacks} to the base application of the
 * Context, which will be called at the same times as the ComponentCallbacks
 * methods of activities and other components are called.  Note that you
 * <em>must</em> be sure to use {@link #unregisterComponentCallbacks} when
 * appropriate in the future; this will not be removed for you.
 *
 * @param callback The interface to call.  This can be either a
 * {@link android.content.ComponentCallbacks ComponentCallbacks} or {@link android.content.ComponentCallbacks2 ComponentCallbacks2} interface.
 * @apiSince 14
 */

public void registerComponentCallbacks(android.content.ComponentCallbacks callback) { throw new RuntimeException("Stub!"); }

/**
 * Remove a {@link android.content.ComponentCallbacks ComponentCallbacks} object that was previously registered
 * with {@link #registerComponentCallbacks(android.content.ComponentCallbacks)}.
 * @apiSince 14
 */

public void unregisterComponentCallbacks(android.content.ComponentCallbacks callback) { throw new RuntimeException("Stub!"); }

/**
 * Return a localized, styled CharSequence from the application's package's
 * default string table.
 *
 * @param resId Resource id for the CharSequence text
 
 * @return This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public final java.lang.CharSequence getText(int resId) { throw new RuntimeException("Stub!"); }

/**
 * Returns a localized string from the application's package's
 * default string table.
 *
 * @param resId Resource id for the string
 * @return The string data associated with the resource, stripped of styled
 *         text information.
 
 * This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public final java.lang.String getString(int resId) { throw new RuntimeException("Stub!"); }

/**
 * Returns a localized formatted string from the application's package's
 * default string table, substituting the format arguments as defined in
 * {@link java.util.Formatter} and {@link java.lang.String#format}.
 *
 * @param resId Resource id for the format string
 * @param formatArgs The format arguments that will be used for
 *                   substitution.
 * @return The string data associated with the resource, formatted and
 *         stripped of styled text information.
 
 * This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public final java.lang.String getString(int resId, java.lang.Object... formatArgs) { throw new RuntimeException("Stub!"); }

/**
 * Returns a color associated with a particular resource ID and styled for
 * the current theme.
 *
 * @param id The desired resource identifier, as generated by the aapt
 *           tool. This integer encodes the package, type, and resource
 *           entry. The value 0 is an invalid identifier.
 * @return A single color value in the form 0xAARRGGBB.
 * @throws android.content.res.Resources.NotFoundException if the given ID
 *         does not exist.
 * @apiSince 23
 */

public final int getColor(int id) { throw new RuntimeException("Stub!"); }

/**
 * Returns a drawable object associated with a particular resource ID and
 * styled for the current theme.
 *
 * @param id The desired resource identifier, as generated by the aapt
 *           tool. This integer encodes the package, type, and resource
 *           entry. The value 0 is an invalid identifier.
 * @return An object that can be used to draw this resource.
 * This value may be {@code null}.
 * @throws android.content.res.Resources.NotFoundException if the given ID
 *         does not exist.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public final android.graphics.drawable.Drawable getDrawable(int id) { throw new RuntimeException("Stub!"); }

/**
 * Returns a color state list associated with a particular resource ID and
 * styled for the current theme.
 *
 * @param id The desired resource identifier, as generated by the aapt
 *           tool. This integer encodes the package, type, and resource
 *           entry. The value 0 is an invalid identifier.
 * @return A color state list.
 * This value will never be {@code null}.
 * @throws android.content.res.Resources.NotFoundException if the given ID
 *         does not exist.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public final android.content.res.ColorStateList getColorStateList(int id) { throw new RuntimeException("Stub!"); }

/**
 * Set the base theme for this context.  Note that this should be called
 * before any views are instantiated in the Context (for example before
 * calling {@link android.app.Activity#setContentView} or
 * {@link android.view.LayoutInflater#inflate}).
 *
 * @param resid The style resource describing the theme.
 * @apiSince 1
 */

public abstract void setTheme(int resid);

/**
 * Return the Theme object associated with this Context.
 * @apiSince 1
 */

@android.view.ViewDebug.ExportedProperty(deepExport=true)
public abstract android.content.res.Resources.Theme getTheme();

/**
 * Retrieve styled attribute information in this Context's theme.  See
 * {@link android.content.res.Resources.Theme#obtainStyledAttributes(int[])}
 * for more information.
 *
 * @see android.content.res.Resources.Theme#obtainStyledAttributes(int[])
 
 * @param attrs This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public final android.content.res.TypedArray obtainStyledAttributes(@androidx.annotation.NonNull int[] attrs) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve styled attribute information in this Context's theme.  See
 * {@link android.content.res.Resources.Theme#obtainStyledAttributes(int, int[])}
 * for more information.
 *
 * @see android.content.res.Resources.Theme#obtainStyledAttributes(int, int[])
 
 * @param attrs This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public final android.content.res.TypedArray obtainStyledAttributes(int resid, @androidx.annotation.NonNull int[] attrs) throws android.content.res.Resources.NotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Retrieve styled attribute information in this Context's theme.  See
 * {@link android.content.res.Resources.Theme#obtainStyledAttributes(AttributeSet, int[], int, int)}
 * for more information.
 *
 * @see android.content.res.Resources.Theme#obtainStyledAttributes(AttributeSet, int[], int, int)
 
 * @param set This value may be {@code null}.
 * @param attrs This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public final android.content.res.TypedArray obtainStyledAttributes(@androidx.annotation.Nullable android.util.AttributeSet set, @androidx.annotation.NonNull int[] attrs) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve styled attribute information in this Context's theme.  See
 * {@link android.content.res.Resources.Theme#obtainStyledAttributes(AttributeSet, int[], int, int)}
 * for more information.
 *
 * @see android.content.res.Resources.Theme#obtainStyledAttributes(AttributeSet, int[], int, int)
 
 * @param set This value may be {@code null}.
 * @param attrs This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public final android.content.res.TypedArray obtainStyledAttributes(@androidx.annotation.Nullable android.util.AttributeSet set, @androidx.annotation.NonNull int[] attrs, int defStyleAttr, int defStyleRes) { throw new RuntimeException("Stub!"); }

/**
 * Return a class loader you can use to retrieve classes in this package.
 * @apiSince 1
 */

public abstract java.lang.ClassLoader getClassLoader();

/**
 * Return the name of this application's package.
 * @apiSince 1
 */

public abstract java.lang.String getPackageName();

/**
 * Return the package name that should be used for {@link android.app.AppOpsManager} calls from
 * this context, so that app ops manager's uid verification will work with the name.
 * <p>
 * This is not generally intended for third party application developers.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.lang.String getOpPackageName() { throw new RuntimeException("Stub!"); }

/**
 * Return the full application info for this context's package.
 * @apiSince 4
 */

public abstract android.content.pm.ApplicationInfo getApplicationInfo();

/**
 * Return the full path to this context's primary Android package.
 * The Android package is a ZIP file which contains the application's
 * primary resources.
 *
 * <p>Note: this is not generally useful for applications, since they should
 * not be directly accessing the file system.
 *
 * @return String Path to the resources.
 * @apiSince 8
 */

public abstract java.lang.String getPackageResourcePath();

/**
 * Return the full path to this context's primary Android package.
 * The Android package is a ZIP file which contains application's
 * primary code and assets.
 *
 * <p>Note: this is not generally useful for applications, since they should
 * not be directly accessing the file system.
 *
 * @return String Path to the code and assets.
 * @apiSince 8
 */

public abstract java.lang.String getPackageCodePath();

/**
 * Retrieve and hold the contents of the preferences file 'name', returning
 * a SharedPreferences through which you can retrieve and modify its
 * values.  Only one instance of the SharedPreferences object is returned
 * to any callers for the same name, meaning they will see each other's
 * edits as soon as they are made.
 *
 * <p>This method is thread-safe.
 *
 * <p>If the preferences directory does not already exist, it will be created when this method
 * is called.
 *
 * <p>If a preferences file by this name does not exist, it will be created when you retrieve an
 * editor ({@link android.content.SharedPreferences#edit() SharedPreferences#edit()}) and then commit changes ({@link android.content.SharedPreferences.Editor#commit() SharedPreferences.Editor#commit()} or {@link android.content.SharedPreferences.Editor#apply() SharedPreferences.Editor#apply()}).
 *
 * @param name Desired preferences file.
 * @param mode Operating mode.
 *
 * Value is either <code>0</code> or a combination of {@link android.content.Context#MODE_PRIVATE}, {@link android.content.Context#MODE_WORLD_READABLE}, {@link android.content.Context#MODE_WORLD_WRITEABLE}, and {@link android.content.Context#MODE_MULTI_PROCESS}
 * @return The single {@link android.content.SharedPreferences SharedPreferences} instance that can be used
 *         to retrieve and modify the preference values.
 *
 * @see #MODE_PRIVATE
 * @apiSince 1
 */

public abstract android.content.SharedPreferences getSharedPreferences(java.lang.String name, int mode);

/**
 * Move an existing shared preferences file from the given source storage
 * context to this context. This is typically used to migrate data between
 * storage locations after an upgrade, such as moving to device protected
 * storage.
 *
 * @param sourceContext The source context which contains the existing
 *            shared preferences to move.
 * @param name The name of the shared preferences file.
 * @return {@code true} if the move was successful or if the shared
 *         preferences didn't exist in the source context, otherwise
 *         {@code false}.
 * @see #createDeviceProtectedStorageContext()
 * @apiSince 24
 */

public abstract boolean moveSharedPreferencesFrom(android.content.Context sourceContext, java.lang.String name);

/**
 * Delete an existing shared preferences file.
 *
 * @param name The name (unique in the application package) of the shared
 *            preferences file.
 * @return {@code true} if the shared preferences file was successfully
 *         deleted; else {@code false}.
 * @see #getSharedPreferences(String, int)
 * @apiSince 24
 */

public abstract boolean deleteSharedPreferences(java.lang.String name);

/**
 * Open a private file associated with this Context's application package
 * for reading.
 *
 * @param name The name of the file to open; can not contain path
 *             separators.
 *
 * @return The resulting {@link java.io.FileInputStream FileInputStream}.
 *
 * @see #openFileOutput
 * @see #fileList
 * @see #deleteFile
 * @see java.io.FileInputStream#FileInputStream(String)
 * @apiSince 1
 */

public abstract java.io.FileInputStream openFileInput(java.lang.String name) throws java.io.FileNotFoundException;

/**
 * Open a private file associated with this Context's application package
 * for writing. Creates the file if it doesn't already exist.
 * <p>
 * No additional permissions are required for the calling app to read or
 * write the returned file.
 *
 * @param name The name of the file to open; can not contain path
 *            separators.
 * @param mode Operating mode.
 * Value is either <code>0</code> or a combination of {@link android.content.Context#MODE_PRIVATE}, {@link android.content.Context#MODE_WORLD_READABLE}, {@link android.content.Context#MODE_WORLD_WRITEABLE}, and {@link android.content.Context#MODE_APPEND}
 * @return The resulting {@link java.io.FileOutputStream FileOutputStream}.
 * @see #MODE_APPEND
 * @see #MODE_PRIVATE
 * @see #openFileInput
 * @see #fileList
 * @see #deleteFile
 * @see java.io.FileOutputStream#FileOutputStream(String)
 * @apiSince 1
 */

public abstract java.io.FileOutputStream openFileOutput(java.lang.String name, int mode) throws java.io.FileNotFoundException;

/**
 * Delete the given private file associated with this Context's
 * application package.
 *
 * @param name The name of the file to delete; can not contain path
 *             separators.
 *
 * @return {@code true} if the file was successfully deleted; else
 *         {@code false}.
 *
 * @see #openFileInput
 * @see #openFileOutput
 * @see #fileList
 * @see java.io.File#delete()
 * @apiSince 1
 */

public abstract boolean deleteFile(java.lang.String name);

/**
 * Returns the absolute path on the filesystem where a file created with
 * {@link #openFileOutput} is stored.
 * <p>
 * The returned path may change over time if the calling app is moved to an
 * adopted storage device, so only relative paths should be persisted.
 *
 * @param name The name of the file for which you would like to get
 *          its path.
 *
 * @return An absolute path to the given file.
 *
 * @see #openFileOutput
 * @see #getFilesDir
 * @see #getDir
 * @apiSince 1
 */

public abstract java.io.File getFileStreamPath(java.lang.String name);

/**
 * Returns the absolute path to the directory on the filesystem where all
 * private files belonging to this app are stored. Apps should not use this
 * path directly; they should instead use {@link #getFilesDir()},
 * {@link #getCacheDir()}, {@link #getDir(java.lang.String,int)}, or other storage
 * APIs on this class.
 * <p>
 * The returned path may change over time if the calling app is moved to an
 * adopted storage device, so only relative paths should be persisted.
 * <p>
 * No additional permissions are required for the calling app to read or
 * write files under the returned path.
 *
 * @see android.content.pm.ApplicationInfo#dataDir
 * @apiSince 24
 */

public abstract java.io.File getDataDir();

/**
 * Returns the absolute path to the directory on the filesystem where files
 * created with {@link #openFileOutput} are stored.
 * <p>
 * The returned path may change over time if the calling app is moved to an
 * adopted storage device, so only relative paths should be persisted.
 * <p>
 * No additional permissions are required for the calling app to read or
 * write files under the returned path.
 *
 * @return The path of the directory holding application files.
 * @see #openFileOutput
 * @see #getFileStreamPath
 * @see #getDir
 * @apiSince 1
 */

public abstract java.io.File getFilesDir();

/**
 * Returns the absolute path to the directory on the filesystem similar to
 * {@link #getFilesDir()}. The difference is that files placed under this
 * directory will be excluded from automatic backup to remote storage. See
 * {@link android.app.backup.BackupAgent BackupAgent} for a full discussion
 * of the automatic backup mechanism in Android.
 * <p>
 * The returned path may change over time if the calling app is moved to an
 * adopted storage device, so only relative paths should be persisted.
 * <p>
 * No additional permissions are required for the calling app to read or
 * write files under the returned path.
 *
 * @return The path of the directory holding application files that will not
 *         be automatically backed up to remote storage.
 * @see #openFileOutput
 * @see #getFileStreamPath
 * @see #getDir
 * @see android.app.backup.BackupAgent
 * @apiSince 21
 */

public abstract java.io.File getNoBackupFilesDir();

/**
 * Returns the absolute path to the directory on the primary shared/external
 * storage device where the application can place persistent files it owns.
 * These files are internal to the applications, and not typically visible
 * to the user as media.
 * <p>
 * This is like {@link #getFilesDir()} in that these files will be deleted
 * when the application is uninstalled, however there are some important
 * differences:
 * <ul>
 * <li>Shared storage may not always be available, since removable media can
 * be ejected by the user. Media state can be checked using
 * {@link android.os.Environment#getExternalStorageState(java.io.File) Environment#getExternalStorageState(File)}.
 * <li>There is no security enforced with these files. For example, any
 * application holding
 * {@link android.Manifest.permission#WRITE_EXTERNAL_STORAGE} can write to
 * these files.
 * </ul>
 * <p>
 * If a shared storage device is emulated (as determined by
 * {@link android.os.Environment#isExternalStorageEmulated(java.io.File) Environment#isExternalStorageEmulated(File)}), it's contents are
 * backed by a private user data partition, which means there is little
 * benefit to storing data here instead of the private directories returned
 * by {@link #getFilesDir()}, etc.
 * <p>
 * Starting in {@link android.os.Build.VERSION_CODES#KITKAT}, no permissions
 * are required to read or write to the returned path; it's always
 * accessible to the calling app. This only applies to paths generated for
 * package name of the calling application. To access paths belonging to
 * other packages,
 * {@link android.Manifest.permission#WRITE_EXTERNAL_STORAGE} and/or
 * {@link android.Manifest.permission#READ_EXTERNAL_STORAGE} are required.
 * <p>
 * On devices with multiple users (as described by {@link android.os.UserManager UserManager}),
 * each user has their own isolated shared storage. Applications only have
 * access to the shared storage for the user they're running as.
 * <p>
 * The returned path may change over time if different shared storage media
 * is inserted, so only relative paths should be persisted.
 * <p>
 * Here is an example of typical code to manipulate a file in an
 * application's shared storage:
 * </p>
 * {@sample development/samples/ApiDemos/src/com/example/android/apis/content/ExternalStorage.java
 * private_file}
 * <p>
 * If you supply a non-null <var>type</var> to this function, the returned
 * file will be a path to a sub-directory of the given type. Though these
 * files are not automatically scanned by the media scanner, you can
 * explicitly add them to the media database with
 * {@link android.media.MediaScannerConnection#scanFile(Context, String[], String[], android.media.MediaScannerConnection.OnScanCompletedListener)
 * MediaScannerConnection.scanFile}. Note that this is not the same as
 * {@link android.os.Environment#getExternalStoragePublicDirectory
 * Environment.getExternalStoragePublicDirectory()}, which provides
 * directories of media shared by all applications. The directories returned
 * here are owned by the application, and their contents will be removed
 * when the application is uninstalled. Unlike
 * {@link android.os.Environment#getExternalStoragePublicDirectory
 * Environment.getExternalStoragePublicDirectory()}, the directory returned
 * here will be automatically created for you.
 * <p>
 * Here is an example of typical code to manipulate a picture in an
 * application's shared storage and add it to the media database:
 * </p>
 * {@sample development/samples/ApiDemos/src/com/example/android/apis/content/ExternalStorage.java
 * private_picture}
 *
 * @param type The type of files directory to return. May be {@code null}
 *            for the root of the files directory or one of the following
 *            constants for a subdirectory:
 *            {@link android.os.Environment#DIRECTORY_MUSIC},
 *            {@link android.os.Environment#DIRECTORY_PODCASTS},
 *            {@link android.os.Environment#DIRECTORY_RINGTONES},
 *            {@link android.os.Environment#DIRECTORY_ALARMS},
 *            {@link android.os.Environment#DIRECTORY_NOTIFICATIONS},
 *            {@link android.os.Environment#DIRECTORY_PICTURES}, or
 *            {@link android.os.Environment#DIRECTORY_MOVIES}.
 * This value may be {@code null}.
 * @return the absolute path to application-specific directory. May return
 *         {@code null} if shared storage is not currently available.
 * @see #getFilesDir
 * @see #getExternalFilesDirs(String)
 * @see android.os.Environment#getExternalStorageState(File)
 * @see android.os.Environment#isExternalStorageEmulated(File)
 * @see android.os.Environment#isExternalStorageRemovable(File)
 * @apiSince 8
 */

@androidx.annotation.Nullable
public abstract java.io.File getExternalFilesDir(@androidx.annotation.Nullable java.lang.String type);

/**
 * Returns absolute paths to application-specific directories on all
 * shared/external storage devices where the application can place
 * persistent files it owns. These files are internal to the application,
 * and not typically visible to the user as media.
 * <p>
 * This is like {@link #getFilesDir()} in that these files will be deleted
 * when the application is uninstalled, however there are some important
 * differences:
 * <ul>
 * <li>Shared storage may not always be available, since removable media can
 * be ejected by the user. Media state can be checked using
 * {@link android.os.Environment#getExternalStorageState(java.io.File) Environment#getExternalStorageState(File)}.
 * <li>There is no security enforced with these files. For example, any
 * application holding
 * {@link android.Manifest.permission#WRITE_EXTERNAL_STORAGE} can write to
 * these files.
 * </ul>
 * <p>
 * If a shared storage device is emulated (as determined by
 * {@link android.os.Environment#isExternalStorageEmulated(java.io.File) Environment#isExternalStorageEmulated(File)}), it's contents are
 * backed by a private user data partition, which means there is little
 * benefit to storing data here instead of the private directories returned
 * by {@link #getFilesDir()}, etc.
 * <p>
 * Shared storage devices returned here are considered a stable part of the
 * device, including physical media slots under a protective cover. The
 * returned paths do not include transient devices, such as USB flash drives
 * connected to handheld devices.
 * <p>
 * An application may store data on any or all of the returned devices. For
 * example, an app may choose to store large files on the device with the
 * most available space, as measured by {@link android.os.StatFs StatFs}.
 * <p>
 * No additional permissions are required for the calling app to read or
 * write files under the returned path. Write access outside of these paths
 * on secondary external storage devices is not available.
 * <p>
 * The returned path may change over time if different shared storage media
 * is inserted, so only relative paths should be persisted.
 *
 * @param type The type of files directory to return. May be {@code null}
 *            for the root of the files directory or one of the following
 *            constants for a subdirectory:
 *            {@link android.os.Environment#DIRECTORY_MUSIC},
 *            {@link android.os.Environment#DIRECTORY_PODCASTS},
 *            {@link android.os.Environment#DIRECTORY_RINGTONES},
 *            {@link android.os.Environment#DIRECTORY_ALARMS},
 *            {@link android.os.Environment#DIRECTORY_NOTIFICATIONS},
 *            {@link android.os.Environment#DIRECTORY_PICTURES}, or
 *            {@link android.os.Environment#DIRECTORY_MOVIES}.
 * @return the absolute paths to application-specific directories. Some
 *         individual paths may be {@code null} if that shared storage is
 *         not currently available. The first path returned is the same as
 *         {@link #getExternalFilesDir(java.lang.String)}.
 * @see #getExternalFilesDir(String)
 * @see android.os.Environment#getExternalStorageState(File)
 * @see android.os.Environment#isExternalStorageEmulated(File)
 * @see android.os.Environment#isExternalStorageRemovable(File)
 * @apiSince 19
 */

public abstract java.io.File[] getExternalFilesDirs(java.lang.String type);

/**
 * Return the primary shared/external storage directory where this
 * application's OBB files (if there are any) can be found. Note if the
 * application does not have any OBB files, this directory may not exist.
 * <p>
 * This is like {@link #getFilesDir()} in that these files will be deleted
 * when the application is uninstalled, however there are some important
 * differences:
 * <ul>
 * <li>Shared storage may not always be available, since removable media can
 * be ejected by the user. Media state can be checked using
 * {@link android.os.Environment#getExternalStorageState(java.io.File) Environment#getExternalStorageState(File)}.
 * <li>There is no security enforced with these files. For example, any
 * application holding
 * {@link android.Manifest.permission#WRITE_EXTERNAL_STORAGE} can write to
 * these files.
 * </ul>
 * <p>
 * Starting in {@link android.os.Build.VERSION_CODES#KITKAT}, no permissions
 * are required to read or write to the path that this method returns.
 * However, starting from {@link android.os.Build.VERSION_CODES#M},
 * to read the OBB expansion files, you must declare the
 * {@link android.Manifest.permission#READ_EXTERNAL_STORAGE} permission in the app manifest and ask for
 * permission at runtime as follows:
 * </p>
 * <p>
 * {@code <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"
 * android:maxSdkVersion="23" />}
 * </p>
 * <p>
 * Starting from {@link android.os.Build.VERSION_CODES#N},
 * {@link android.Manifest.permission#READ_EXTERNAL_STORAGE}
 * permission is not required, so don’t ask for this
 * permission at runtime. To handle both cases, your app must first try to read the OBB file,
 * and if it fails, you must request
 * {@link android.Manifest.permission#READ_EXTERNAL_STORAGE} permission at runtime.
 * </p>
 *
 * <p>
 * The following code snippet shows how to do this:
 * </p>
 *
 * <pre>
 * File obb = new File(obb_filename);
 * boolean open_failed = false;
 *
 * try {
 *     BufferedReader br = new BufferedReader(new FileReader(obb));
 *     open_failed = false;
 *     ReadObbFile(br);
 * } catch (IOException e) {
 *     open_failed = true;
 * }
 *
 * if (open_failed) {
 *     // request READ_EXTERNAL_STORAGE permission before reading OBB file
 *     ReadObbFileWithPermission();
 * }
 * </pre>
 *
 * On devices with multiple users (as described by {@link android.os.UserManager UserManager}),
 * multiple users may share the same OBB storage location. Applications
 * should ensure that multiple instances running under different users don't
 * interfere with each other.
 *
 * @return the absolute path to application-specific directory. May return
 *         {@code null} if shared storage is not currently available.
 * @see #getObbDirs()
 * @see android.os.Environment#getExternalStorageState(File)
 * @see android.os.Environment#isExternalStorageEmulated(File)
 * @see android.os.Environment#isExternalStorageRemovable(File)
 * @apiSince 11
 */

public abstract java.io.File getObbDir();

/**
 * Returns absolute paths to application-specific directories on all
 * shared/external storage devices where the application's OBB files (if
 * there are any) can be found. Note if the application does not have any
 * OBB files, these directories may not exist.
 * <p>
 * This is like {@link #getFilesDir()} in that these files will be deleted
 * when the application is uninstalled, however there are some important
 * differences:
 * <ul>
 * <li>Shared storage may not always be available, since removable media can
 * be ejected by the user. Media state can be checked using
 * {@link android.os.Environment#getExternalStorageState(java.io.File) Environment#getExternalStorageState(File)}.
 * <li>There is no security enforced with these files. For example, any
 * application holding
 * {@link android.Manifest.permission#WRITE_EXTERNAL_STORAGE} can write to
 * these files.
 * </ul>
 * <p>
 * Shared storage devices returned here are considered a stable part of the
 * device, including physical media slots under a protective cover. The
 * returned paths do not include transient devices, such as USB flash drives
 * connected to handheld devices.
 * <p>
 * An application may store data on any or all of the returned devices. For
 * example, an app may choose to store large files on the device with the
 * most available space, as measured by {@link android.os.StatFs StatFs}.
 * <p>
 * No additional permissions are required for the calling app to read or
 * write files under the returned path. Write access outside of these paths
 * on secondary external storage devices is not available.
 *
 * @return the absolute paths to application-specific directories. Some
 *         individual paths may be {@code null} if that shared storage is
 *         not currently available. The first path returned is the same as
 *         {@link #getObbDir()}
 * @see #getObbDir()
 * @see android.os.Environment#getExternalStorageState(File)
 * @see android.os.Environment#isExternalStorageEmulated(File)
 * @see android.os.Environment#isExternalStorageRemovable(File)
 * @apiSince 19
 */

public abstract java.io.File[] getObbDirs();

/**
 * Returns the absolute path to the application specific cache directory on
 * the filesystem.
 * <p>
 * The system will automatically delete files in this directory as disk
 * space is needed elsewhere on the device. The system will always delete
 * older files first, as reported by {@link java.io.File#lastModified() File#lastModified()}. If
 * desired, you can exert more control over how files are deleted using
 * {@link android.os.storage.StorageManager#setCacheBehaviorGroup(java.io.File,boolean) StorageManager#setCacheBehaviorGroup(File, boolean)} and
 * {@link android.os.storage.StorageManager#setCacheBehaviorTombstone(java.io.File,boolean) StorageManager#setCacheBehaviorTombstone(File, boolean)}.
 * <p>
 * Apps are strongly encouraged to keep their usage of cache space below the
 * quota returned by
 * {@link android.os.storage.StorageManager#getCacheQuotaBytes(java.util.UUID) StorageManager#getCacheQuotaBytes(java.util.UUID)}. If your app
 * goes above this quota, your cached files will be some of the first to be
 * deleted when additional disk space is needed. Conversely, if your app
 * stays under this quota, your cached files will be some of the last to be
 * deleted when additional disk space is needed.
 * <p>
 * Note that your cache quota will change over time depending on how
 * frequently the user interacts with your app, and depending on how much
 * system-wide disk space is used.
 * <p>
 * The returned path may change over time if the calling app is moved to an
 * adopted storage device, so only relative paths should be persisted.
 * <p>
 * Apps require no extra permissions to read or write to the returned path,
 * since this path lives in their private storage.
 *
 * @return The path of the directory holding application cache files.
 * @see #openFileOutput
 * @see #getFileStreamPath
 * @see #getDir
 * @see #getExternalCacheDir
 * @apiSince 1
 */

public abstract java.io.File getCacheDir();

/**
 * Returns the absolute path to the application specific cache directory on
 * the filesystem designed for storing cached code.
 * <p>
 * The system will delete any files stored in this location both when your
 * specific application is upgraded, and when the entire platform is
 * upgraded.
 * <p>
 * This location is optimal for storing compiled or optimized code generated
 * by your application at runtime.
 * <p>
 * The returned path may change over time if the calling app is moved to an
 * adopted storage device, so only relative paths should be persisted.
 * <p>
 * Apps require no extra permissions to read or write to the returned path,
 * since this path lives in their private storage.
 *
 * @return The path of the directory holding application code cache files.
 * @apiSince 21
 */

public abstract java.io.File getCodeCacheDir();

/**
 * Returns absolute path to application-specific directory on the primary
 * shared/external storage device where the application can place cache
 * files it owns. These files are internal to the application, and not
 * typically visible to the user as media.
 * <p>
 * This is like {@link #getCacheDir()} in that these files will be deleted
 * when the application is uninstalled, however there are some important
 * differences:
 * <ul>
 * <li>The platform does not always monitor the space available in shared
 * storage, and thus may not automatically delete these files. Apps should
 * always manage the maximum space used in this location. Currently the only
 * time files here will be deleted by the platform is when running on
 * {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR1} or later and
 * {@link android.os.Environment#isExternalStorageEmulated(java.io.File) Environment#isExternalStorageEmulated(File)} returns true.
 * <li>Shared storage may not always be available, since removable media can
 * be ejected by the user. Media state can be checked using
 * {@link android.os.Environment#getExternalStorageState(java.io.File) Environment#getExternalStorageState(File)}.
 * <li>There is no security enforced with these files. For example, any
 * application holding
 * {@link android.Manifest.permission#WRITE_EXTERNAL_STORAGE} can write to
 * these files.
 * </ul>
 * <p>
 * If a shared storage device is emulated (as determined by
 * {@link android.os.Environment#isExternalStorageEmulated(java.io.File) Environment#isExternalStorageEmulated(File)}), its contents are
 * backed by a private user data partition, which means there is little
 * benefit to storing data here instead of the private directory returned by
 * {@link #getCacheDir()}.
 * <p>
 * Starting in {@link android.os.Build.VERSION_CODES#KITKAT}, no permissions
 * are required to read or write to the returned path; it's always
 * accessible to the calling app. This only applies to paths generated for
 * package name of the calling application. To access paths belonging to
 * other packages,
 * {@link android.Manifest.permission#WRITE_EXTERNAL_STORAGE} and/or
 * {@link android.Manifest.permission#READ_EXTERNAL_STORAGE} are required.
 * <p>
 * On devices with multiple users (as described by {@link android.os.UserManager UserManager}),
 * each user has their own isolated shared storage. Applications only have
 * access to the shared storage for the user they're running as.
 * <p>
 * The returned path may change over time if different shared storage media
 * is inserted, so only relative paths should be persisted.
 *
 * @return the absolute path to application-specific directory. May return
 *         {@code null} if shared storage is not currently available.
 * @see #getCacheDir
 * @see #getExternalCacheDirs()
 * @see android.os.Environment#getExternalStorageState(File)
 * @see android.os.Environment#isExternalStorageEmulated(File)
 * @see android.os.Environment#isExternalStorageRemovable(File)
 * @apiSince 8
 */

@androidx.annotation.Nullable
public abstract java.io.File getExternalCacheDir();

/**
 * Returns absolute paths to application-specific directories on all
 * shared/external storage devices where the application can place cache
 * files it owns. These files are internal to the application, and not
 * typically visible to the user as media.
 * <p>
 * This is like {@link #getCacheDir()} in that these files will be deleted
 * when the application is uninstalled, however there are some important
 * differences:
 * <ul>
 * <li>The platform does not always monitor the space available in shared
 * storage, and thus may not automatically delete these files. Apps should
 * always manage the maximum space used in this location. Currently the only
 * time files here will be deleted by the platform is when running on
 * {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR1} or later and
 * {@link android.os.Environment#isExternalStorageEmulated(java.io.File) Environment#isExternalStorageEmulated(File)} returns true.
 * <li>Shared storage may not always be available, since removable media can
 * be ejected by the user. Media state can be checked using
 * {@link android.os.Environment#getExternalStorageState(java.io.File) Environment#getExternalStorageState(File)}.
 * <li>There is no security enforced with these files. For example, any
 * application holding
 * {@link android.Manifest.permission#WRITE_EXTERNAL_STORAGE} can write to
 * these files.
 * </ul>
 * <p>
 * If a shared storage device is emulated (as determined by
 * {@link android.os.Environment#isExternalStorageEmulated(java.io.File) Environment#isExternalStorageEmulated(File)}), it's contents are
 * backed by a private user data partition, which means there is little
 * benefit to storing data here instead of the private directory returned by
 * {@link #getCacheDir()}.
 * <p>
 * Shared storage devices returned here are considered a stable part of the
 * device, including physical media slots under a protective cover. The
 * returned paths do not include transient devices, such as USB flash drives
 * connected to handheld devices.
 * <p>
 * An application may store data on any or all of the returned devices. For
 * example, an app may choose to store large files on the device with the
 * most available space, as measured by {@link android.os.StatFs StatFs}.
 * <p>
 * No additional permissions are required for the calling app to read or
 * write files under the returned path. Write access outside of these paths
 * on secondary external storage devices is not available.
 * <p>
 * The returned paths may change over time if different shared storage media
 * is inserted, so only relative paths should be persisted.
 *
 * @return the absolute paths to application-specific directories. Some
 *         individual paths may be {@code null} if that shared storage is
 *         not currently available. The first path returned is the same as
 *         {@link #getExternalCacheDir()}.
 * @see #getExternalCacheDir()
 * @see android.os.Environment#getExternalStorageState(File)
 * @see android.os.Environment#isExternalStorageEmulated(File)
 * @see android.os.Environment#isExternalStorageRemovable(File)
 * @apiSince 19
 */

public abstract java.io.File[] getExternalCacheDirs();

/**
 * Returns absolute paths to application-specific directories on all
 * shared/external storage devices where the application can place media
 * files. These files are scanned and made available to other apps through
 * {@link android.provider.MediaStore MediaStore}.
 * <p>
 * This is like {@link #getExternalFilesDirs} in that these files will be
 * deleted when the application is uninstalled, however there are some
 * important differences:
 * <ul>
 * <li>Shared storage may not always be available, since removable media can
 * be ejected by the user. Media state can be checked using
 * {@link android.os.Environment#getExternalStorageState(java.io.File) Environment#getExternalStorageState(File)}.
 * <li>There is no security enforced with these files. For example, any
 * application holding
 * {@link android.Manifest.permission#WRITE_EXTERNAL_STORAGE} can write to
 * these files.
 * </ul>
 * <p>
 * Shared storage devices returned here are considered a stable part of the
 * device, including physical media slots under a protective cover. The
 * returned paths do not include transient devices, such as USB flash drives
 * connected to handheld devices.
 * <p>
 * An application may store data on any or all of the returned devices. For
 * example, an app may choose to store large files on the device with the
 * most available space, as measured by {@link android.os.StatFs StatFs}.
 * <p>
 * No additional permissions are required for the calling app to read or
 * write files under the returned path. Write access outside of these paths
 * on secondary external storage devices is not available.
 * <p>
 * The returned paths may change over time if different shared storage media
 * is inserted, so only relative paths should be persisted.
 *
 * @return the absolute paths to application-specific directories. Some
 *         individual paths may be {@code null} if that shared storage is
 *         not currently available.
 * @see android.os.Environment#getExternalStorageState(File)
 * @see android.os.Environment#isExternalStorageEmulated(File)
 * @see android.os.Environment#isExternalStorageRemovable(File)
 * @apiSince 21
 */

public abstract java.io.File[] getExternalMediaDirs();

/**
 * Returns an array of strings naming the private files associated with
 * this Context's application package.
 *
 * @return Array of strings naming the private files.
 *
 * @see #openFileInput
 * @see #openFileOutput
 * @see #deleteFile
 * @apiSince 1
 */

public abstract java.lang.String[] fileList();

/**
 * Retrieve, creating if needed, a new directory in which the application
 * can place its own custom data files.  You can use the returned File
 * object to create and access files in this directory.  Note that files
 * created through a File object will only be accessible by your own
 * application; you can only set the mode of the entire directory, not
 * of individual files.
 * <p>
 * The returned path may change over time if the calling app is moved to an
 * adopted storage device, so only relative paths should be persisted.
 * <p>
 * Apps require no extra permissions to read or write to the returned path,
 * since this path lives in their private storage.
 *
 * @param name Name of the directory to retrieve.  This is a directory
 * that is created as part of your application data.
 * @param mode Operating mode.
 *
 * Value is either <code>0</code> or a combination of {@link android.content.Context#MODE_PRIVATE}, {@link android.content.Context#MODE_WORLD_READABLE}, {@link android.content.Context#MODE_WORLD_WRITEABLE}, and {@link android.content.Context#MODE_APPEND}
 * @return A {@link java.io.File File} object for the requested directory.  The directory
 * will have been created if it does not already exist.
 *
 * @see #openFileOutput(String, int)
 * @apiSince 1
 */

public abstract java.io.File getDir(java.lang.String name, int mode);

/**
 * Open a new private SQLiteDatabase associated with this Context's
 * application package. Create the database file if it doesn't exist.
 *
 * @param name The name (unique in the application package) of the database.
 * @param mode Operating mode.
 * Value is either <code>0</code> or a combination of {@link android.content.Context#MODE_PRIVATE}, {@link android.content.Context#MODE_WORLD_READABLE}, {@link android.content.Context#MODE_WORLD_WRITEABLE}, {@link android.content.Context#MODE_ENABLE_WRITE_AHEAD_LOGGING}, and {@link android.content.Context#MODE_NO_LOCALIZED_COLLATORS}
 * @param factory An optional factory class that is called to instantiate a
 *            cursor when query is called.
 * @return The contents of a newly created database with the given name.
 * @throws android.database.sqlite.SQLiteException if the database file
 *             could not be opened.
 * @see #MODE_PRIVATE
 * @see #MODE_ENABLE_WRITE_AHEAD_LOGGING
 * @see #MODE_NO_LOCALIZED_COLLATORS
 * @see #deleteDatabase
 * @apiSince 1
 */

public abstract android.database.sqlite.SQLiteDatabase openOrCreateDatabase(java.lang.String name, int mode, android.database.sqlite.SQLiteDatabase.CursorFactory factory);

/**
 * Open a new private SQLiteDatabase associated with this Context's
 * application package. Creates the database file if it doesn't exist.
 * <p>
 * Accepts input param: a concrete instance of {@link android.database.DatabaseErrorHandler DatabaseErrorHandler}
 * to be used to handle corruption when sqlite reports database corruption.
 * </p>
 *
 * @param name The name (unique in the application package) of the database.
 * @param mode Operating mode.
 * Value is either <code>0</code> or a combination of {@link android.content.Context#MODE_PRIVATE}, {@link android.content.Context#MODE_WORLD_READABLE}, {@link android.content.Context#MODE_WORLD_WRITEABLE}, {@link android.content.Context#MODE_ENABLE_WRITE_AHEAD_LOGGING}, and {@link android.content.Context#MODE_NO_LOCALIZED_COLLATORS}
 * @param factory An optional factory class that is called to instantiate a
 *            cursor when query is called.
 * @param errorHandler the {@link android.database.DatabaseErrorHandler DatabaseErrorHandler} to be used when
 *            sqlite reports database corruption. if null,
 *            {@link android.database.DefaultDatabaseErrorHandler} is
 *            assumed.
 * This value may be {@code null}.
 * @return The contents of a newly created database with the given name.
 * @throws android.database.sqlite.SQLiteException if the database file
 *             could not be opened.
 * @see #MODE_PRIVATE
 * @see #MODE_ENABLE_WRITE_AHEAD_LOGGING
 * @see #MODE_NO_LOCALIZED_COLLATORS
 * @see #deleteDatabase
 * @apiSince 11
 */

public abstract android.database.sqlite.SQLiteDatabase openOrCreateDatabase(java.lang.String name, int mode, android.database.sqlite.SQLiteDatabase.CursorFactory factory, @androidx.annotation.Nullable android.database.DatabaseErrorHandler errorHandler);

/**
 * Move an existing database file from the given source storage context to
 * this context. This is typically used to migrate data between storage
 * locations after an upgrade, such as migrating to device protected
 * storage.
 * <p>
 * The database must be closed before being moved.
 *
 * @param sourceContext The source context which contains the existing
 *            database to move.
 * @param name The name of the database file.
 * @return {@code true} if the move was successful or if the database didn't
 *         exist in the source context, otherwise {@code false}.
 * @see #createDeviceProtectedStorageContext()
 * @apiSince 24
 */

public abstract boolean moveDatabaseFrom(android.content.Context sourceContext, java.lang.String name);

/**
 * Delete an existing private SQLiteDatabase associated with this Context's
 * application package.
 *
 * @param name The name (unique in the application package) of the
 *             database.
 *
 * @return {@code true} if the database was successfully deleted; else {@code false}.
 *
 * @see #openOrCreateDatabase
 * @apiSince 1
 */

public abstract boolean deleteDatabase(java.lang.String name);

/**
 * Returns the absolute path on the filesystem where a database created with
 * {@link #openOrCreateDatabase} is stored.
 * <p>
 * The returned path may change over time if the calling app is moved to an
 * adopted storage device, so only relative paths should be persisted.
 *
 * @param name The name of the database for which you would like to get
 *          its path.
 *
 * @return An absolute path to the given database.
 *
 * @see #openOrCreateDatabase
 * @apiSince 1
 */

public abstract java.io.File getDatabasePath(java.lang.String name);

/**
 * Returns an array of strings naming the private databases associated with
 * this Context's application package.
 *
 * @return Array of strings naming the private databases.
 *
 * @see #openOrCreateDatabase
 * @see #deleteDatabase
 * @apiSince 1
 */

public abstract java.lang.String[] databaseList();

/**
 * @deprecated Use {@link android.app.WallpaperManager#getDrawable
 * WallpaperManager.get()} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public abstract android.graphics.drawable.Drawable getWallpaper();

/**
 * @deprecated Use {@link android.app.WallpaperManager#peekDrawable
 * WallpaperManager.peek()} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public abstract android.graphics.drawable.Drawable peekWallpaper();

/**
 * @deprecated Use {@link android.app.WallpaperManager#getDesiredMinimumWidth()
 * WallpaperManager.getDesiredMinimumWidth()} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public abstract int getWallpaperDesiredMinimumWidth();

/**
 * @deprecated Use {@link android.app.WallpaperManager#getDesiredMinimumHeight()
 * WallpaperManager.getDesiredMinimumHeight()} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public abstract int getWallpaperDesiredMinimumHeight();

/**
 * @deprecated Use {@link android.app.WallpaperManager#setBitmap(Bitmap)
 * WallpaperManager.set()} instead.
 * <p>This method requires the caller to hold the permission
 * {@link android.Manifest.permission#SET_WALLPAPER}.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public abstract void setWallpaper(android.graphics.Bitmap bitmap) throws java.io.IOException;

/**
 * @deprecated Use {@link android.app.WallpaperManager#setStream(InputStream)
 * WallpaperManager.set()} instead.
 * <p>This method requires the caller to hold the permission
 * {@link android.Manifest.permission#SET_WALLPAPER}.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public abstract void setWallpaper(java.io.InputStream data) throws java.io.IOException;

/**
 * @deprecated Use {@link android.app.WallpaperManager#clear
 * WallpaperManager.clear()} instead.
 * <p>This method requires the caller to hold the permission
 * {@link android.Manifest.permission#SET_WALLPAPER}.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public abstract void clearWallpaper() throws java.io.IOException;

/**
 * Same as {@link #startActivity(android.content.Intent,android.os.Bundle)} with no options
 * specified.
 *
 * @param intent The description of the activity to start.
 *
 * @throws android.content.ActivityNotFoundException &nbsp;
 *`
 * @see #startActivity(Intent, Bundle)
 * @see android.content.pm.PackageManager#resolveActivity
 * @apiSince 1
 */

public abstract void startActivity(android.content.Intent intent);

/**
 * Launch a new activity.  You will not receive any information about when
 * the activity exits.
 *
 * <p>Note that if this method is being called from outside of an
 * {@link android.app.Activity} Context, then the Intent must include
 * the {@link android.content.Intent#FLAG_ACTIVITY_NEW_TASK Intent#FLAG_ACTIVITY_NEW_TASK} launch flag.  This is because,
 * without being started from an existing Activity, there is no existing
 * task in which to place the new activity and thus it needs to be placed
 * in its own separate task.
 *
 * <p>This method throws {@link android.content.ActivityNotFoundException ActivityNotFoundException}
 * if there was no Activity found to run the given Intent.
 *
 * @param intent The description of the activity to start.
 * @param options Additional options for how the Activity should be started.
 * May be null if there are no options.  See {@link android.app.ActivityOptions}
 * for how to build the Bundle supplied here; there are no supported definitions
 * for building it manually.
 *
 * This value may be {@code null}.
 * @throws android.content.ActivityNotFoundException &nbsp;
 *
 * @see #startActivity(Intent)
 * @see android.content.pm.PackageManager#resolveActivity
 * @apiSince 16
 */

public abstract void startActivity(android.content.Intent intent, @androidx.annotation.Nullable android.os.Bundle options);

/**
 * Same as {@link #startActivities(android.content.Intent[],android.os.Bundle)} with no options
 * specified.
 *
 * @param intents An array of Intents to be started.
 *
 * @throws android.content.ActivityNotFoundException &nbsp;
 *
 * @see #startActivities(Intent[], Bundle)
 * @see android.content.pm.PackageManager#resolveActivity
 * @apiSince 11
 */

public abstract void startActivities(android.content.Intent[] intents);

/**
 * Launch multiple new activities.  This is generally the same as calling
 * {@link #startActivity(android.content.Intent)} for the first Intent in the array,
 * that activity during its creation calling {@link #startActivity(android.content.Intent)}
 * for the second entry, etc.  Note that unlike that approach, generally
 * none of the activities except the last in the array will be created
 * at this point, but rather will be created when the user first visits
 * them (due to pressing back from the activity on top).
 *
 * <p>This method throws {@link android.content.ActivityNotFoundException ActivityNotFoundException}
 * if there was no Activity found for <em>any</em> given Intent.  In this
 * case the state of the activity stack is undefined (some Intents in the
 * list may be on it, some not), so you probably want to avoid such situations.
 *
 * @param intents An array of Intents to be started.
 * @param options Additional options for how the Activity should be started.
 * See {@link android.content.Context#startActivity(Intent, Bundle)}
 * Context.startActivity(Intent, Bundle)} for more details.
 *
 * @throws android.content.ActivityNotFoundException &nbsp;
 *
 * @see #startActivities(Intent[])
 * @see android.content.pm.PackageManager#resolveActivity
 * @apiSince 16
 */

public abstract void startActivities(android.content.Intent[] intents, android.os.Bundle options);

/**
 * Same as {@link #startIntentSender(android.content.IntentSender,android.content.Intent,int,int,int,android.os.Bundle)}
 * with no options specified.
 *
 * @param intent The IntentSender to launch.
 * @param fillInIntent If non-null, this will be provided as the
 * intent parameter to {@link android.content.IntentSender#sendIntent IntentSender#sendIntent}.
 * This value may be {@code null}.
 * @param flagsMask Intent flags in the original IntentSender that you
 * would like to change.
 * Value is either <code>0</code> or a combination of {@link android.content.Intent#FLAG_FROM_BACKGROUND}, {@link android.content.Intent#FLAG_DEBUG_LOG_RESOLUTION}, {@link android.content.Intent#FLAG_EXCLUDE_STOPPED_PACKAGES}, {@link android.content.Intent#FLAG_INCLUDE_STOPPED_PACKAGES}, android.content.Intent.FLAG_DEBUG_TRIAGED_MISSING, android.content.Intent.FLAG_IGNORE_EPHEMERAL, {@link android.content.Intent#FLAG_ACTIVITY_MATCH_EXTERNAL}, {@link android.content.Intent#FLAG_ACTIVITY_NO_HISTORY}, {@link android.content.Intent#FLAG_ACTIVITY_SINGLE_TOP}, {@link android.content.Intent#FLAG_ACTIVITY_NEW_TASK}, {@link android.content.Intent#FLAG_ACTIVITY_MULTIPLE_TASK}, {@link android.content.Intent#FLAG_ACTIVITY_CLEAR_TOP}, {@link android.content.Intent#FLAG_ACTIVITY_FORWARD_RESULT}, {@link android.content.Intent#FLAG_ACTIVITY_PREVIOUS_IS_TOP}, {@link android.content.Intent#FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS}, {@link android.content.Intent#FLAG_ACTIVITY_BROUGHT_TO_FRONT}, {@link android.content.Intent#FLAG_ACTIVITY_RESET_TASK_IF_NEEDED}, {@link android.content.Intent#FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY}, {@link android.content.Intent#FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET}, {@link android.content.Intent#FLAG_ACTIVITY_NEW_DOCUMENT}, {@link android.content.Intent#FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET}, {@link android.content.Intent#FLAG_ACTIVITY_NO_USER_ACTION}, {@link android.content.Intent#FLAG_ACTIVITY_REORDER_TO_FRONT}, {@link android.content.Intent#FLAG_ACTIVITY_NO_ANIMATION}, {@link android.content.Intent#FLAG_ACTIVITY_CLEAR_TASK}, {@link android.content.Intent#FLAG_ACTIVITY_TASK_ON_HOME}, {@link android.content.Intent#FLAG_ACTIVITY_RETAIN_IN_RECENTS}, {@link android.content.Intent#FLAG_ACTIVITY_LAUNCH_ADJACENT}, {@link android.content.Intent#FLAG_RECEIVER_REGISTERED_ONLY}, {@link android.content.Intent#FLAG_RECEIVER_REPLACE_PENDING}, {@link android.content.Intent#FLAG_RECEIVER_FOREGROUND}, {@link android.content.Intent#FLAG_RECEIVER_NO_ABORT}, android.content.Intent.FLAG_RECEIVER_REGISTERED_ONLY_BEFORE_BOOT, android.content.Intent.FLAG_RECEIVER_BOOT_UPGRADE, android.content.Intent.FLAG_RECEIVER_INCLUDE_BACKGROUND, android.content.Intent.FLAG_RECEIVER_EXCLUDE_BACKGROUND, android.content.Intent.FLAG_RECEIVER_FROM_SHELL, {@link android.content.Intent#FLAG_RECEIVER_VISIBLE_TO_INSTANT_APPS}, and android.content.Intent.FLAG_RECEIVER_OFFLOAD
 * @param flagsValues Desired values for any bits set in
 * <var>flagsMask</var>
 * Value is either <code>0</code> or a combination of {@link android.content.Intent#FLAG_FROM_BACKGROUND}, {@link android.content.Intent#FLAG_DEBUG_LOG_RESOLUTION}, {@link android.content.Intent#FLAG_EXCLUDE_STOPPED_PACKAGES}, {@link android.content.Intent#FLAG_INCLUDE_STOPPED_PACKAGES}, android.content.Intent.FLAG_DEBUG_TRIAGED_MISSING, android.content.Intent.FLAG_IGNORE_EPHEMERAL, {@link android.content.Intent#FLAG_ACTIVITY_MATCH_EXTERNAL}, {@link android.content.Intent#FLAG_ACTIVITY_NO_HISTORY}, {@link android.content.Intent#FLAG_ACTIVITY_SINGLE_TOP}, {@link android.content.Intent#FLAG_ACTIVITY_NEW_TASK}, {@link android.content.Intent#FLAG_ACTIVITY_MULTIPLE_TASK}, {@link android.content.Intent#FLAG_ACTIVITY_CLEAR_TOP}, {@link android.content.Intent#FLAG_ACTIVITY_FORWARD_RESULT}, {@link android.content.Intent#FLAG_ACTIVITY_PREVIOUS_IS_TOP}, {@link android.content.Intent#FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS}, {@link android.content.Intent#FLAG_ACTIVITY_BROUGHT_TO_FRONT}, {@link android.content.Intent#FLAG_ACTIVITY_RESET_TASK_IF_NEEDED}, {@link android.content.Intent#FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY}, {@link android.content.Intent#FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET}, {@link android.content.Intent#FLAG_ACTIVITY_NEW_DOCUMENT}, {@link android.content.Intent#FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET}, {@link android.content.Intent#FLAG_ACTIVITY_NO_USER_ACTION}, {@link android.content.Intent#FLAG_ACTIVITY_REORDER_TO_FRONT}, {@link android.content.Intent#FLAG_ACTIVITY_NO_ANIMATION}, {@link android.content.Intent#FLAG_ACTIVITY_CLEAR_TASK}, {@link android.content.Intent#FLAG_ACTIVITY_TASK_ON_HOME}, {@link android.content.Intent#FLAG_ACTIVITY_RETAIN_IN_RECENTS}, {@link android.content.Intent#FLAG_ACTIVITY_LAUNCH_ADJACENT}, {@link android.content.Intent#FLAG_RECEIVER_REGISTERED_ONLY}, {@link android.content.Intent#FLAG_RECEIVER_REPLACE_PENDING}, {@link android.content.Intent#FLAG_RECEIVER_FOREGROUND}, {@link android.content.Intent#FLAG_RECEIVER_NO_ABORT}, android.content.Intent.FLAG_RECEIVER_REGISTERED_ONLY_BEFORE_BOOT, android.content.Intent.FLAG_RECEIVER_BOOT_UPGRADE, android.content.Intent.FLAG_RECEIVER_INCLUDE_BACKGROUND, android.content.Intent.FLAG_RECEIVER_EXCLUDE_BACKGROUND, android.content.Intent.FLAG_RECEIVER_FROM_SHELL, {@link android.content.Intent#FLAG_RECEIVER_VISIBLE_TO_INSTANT_APPS}, and android.content.Intent.FLAG_RECEIVER_OFFLOAD
 * @param extraFlags Always set to 0.
 *
 * @see #startActivity(Intent)
 * @see #startIntentSender(IntentSender, Intent, int, int, int, Bundle)
 * @apiSince 5
 */

public abstract void startIntentSender(android.content.IntentSender intent, @androidx.annotation.Nullable android.content.Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws android.content.IntentSender.SendIntentException;

/**
 * Like {@link #startActivity(android.content.Intent,android.os.Bundle)}, but taking a IntentSender
 * to start.  If the IntentSender is for an activity, that activity will be started
 * as if you had called the regular {@link #startActivity(android.content.Intent)}
 * here; otherwise, its associated action will be executed (such as
 * sending a broadcast) as if you had called
 * {@link android.content.IntentSender#sendIntent IntentSender#sendIntent} on it.
 *
 * @param intent The IntentSender to launch.
 * @param fillInIntent If non-null, this will be provided as the
 * intent parameter to {@link android.content.IntentSender#sendIntent IntentSender#sendIntent}.
 * This value may be {@code null}.
 * @param flagsMask Intent flags in the original IntentSender that you
 * would like to change.
 * Value is either <code>0</code> or a combination of {@link android.content.Intent#FLAG_FROM_BACKGROUND}, {@link android.content.Intent#FLAG_DEBUG_LOG_RESOLUTION}, {@link android.content.Intent#FLAG_EXCLUDE_STOPPED_PACKAGES}, {@link android.content.Intent#FLAG_INCLUDE_STOPPED_PACKAGES}, android.content.Intent.FLAG_DEBUG_TRIAGED_MISSING, android.content.Intent.FLAG_IGNORE_EPHEMERAL, {@link android.content.Intent#FLAG_ACTIVITY_MATCH_EXTERNAL}, {@link android.content.Intent#FLAG_ACTIVITY_NO_HISTORY}, {@link android.content.Intent#FLAG_ACTIVITY_SINGLE_TOP}, {@link android.content.Intent#FLAG_ACTIVITY_NEW_TASK}, {@link android.content.Intent#FLAG_ACTIVITY_MULTIPLE_TASK}, {@link android.content.Intent#FLAG_ACTIVITY_CLEAR_TOP}, {@link android.content.Intent#FLAG_ACTIVITY_FORWARD_RESULT}, {@link android.content.Intent#FLAG_ACTIVITY_PREVIOUS_IS_TOP}, {@link android.content.Intent#FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS}, {@link android.content.Intent#FLAG_ACTIVITY_BROUGHT_TO_FRONT}, {@link android.content.Intent#FLAG_ACTIVITY_RESET_TASK_IF_NEEDED}, {@link android.content.Intent#FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY}, {@link android.content.Intent#FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET}, {@link android.content.Intent#FLAG_ACTIVITY_NEW_DOCUMENT}, {@link android.content.Intent#FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET}, {@link android.content.Intent#FLAG_ACTIVITY_NO_USER_ACTION}, {@link android.content.Intent#FLAG_ACTIVITY_REORDER_TO_FRONT}, {@link android.content.Intent#FLAG_ACTIVITY_NO_ANIMATION}, {@link android.content.Intent#FLAG_ACTIVITY_CLEAR_TASK}, {@link android.content.Intent#FLAG_ACTIVITY_TASK_ON_HOME}, {@link android.content.Intent#FLAG_ACTIVITY_RETAIN_IN_RECENTS}, {@link android.content.Intent#FLAG_ACTIVITY_LAUNCH_ADJACENT}, {@link android.content.Intent#FLAG_RECEIVER_REGISTERED_ONLY}, {@link android.content.Intent#FLAG_RECEIVER_REPLACE_PENDING}, {@link android.content.Intent#FLAG_RECEIVER_FOREGROUND}, {@link android.content.Intent#FLAG_RECEIVER_NO_ABORT}, android.content.Intent.FLAG_RECEIVER_REGISTERED_ONLY_BEFORE_BOOT, android.content.Intent.FLAG_RECEIVER_BOOT_UPGRADE, android.content.Intent.FLAG_RECEIVER_INCLUDE_BACKGROUND, android.content.Intent.FLAG_RECEIVER_EXCLUDE_BACKGROUND, android.content.Intent.FLAG_RECEIVER_FROM_SHELL, {@link android.content.Intent#FLAG_RECEIVER_VISIBLE_TO_INSTANT_APPS}, and android.content.Intent.FLAG_RECEIVER_OFFLOAD
 * @param flagsValues Desired values for any bits set in
 * <var>flagsMask</var>
 * Value is either <code>0</code> or a combination of {@link android.content.Intent#FLAG_FROM_BACKGROUND}, {@link android.content.Intent#FLAG_DEBUG_LOG_RESOLUTION}, {@link android.content.Intent#FLAG_EXCLUDE_STOPPED_PACKAGES}, {@link android.content.Intent#FLAG_INCLUDE_STOPPED_PACKAGES}, android.content.Intent.FLAG_DEBUG_TRIAGED_MISSING, android.content.Intent.FLAG_IGNORE_EPHEMERAL, {@link android.content.Intent#FLAG_ACTIVITY_MATCH_EXTERNAL}, {@link android.content.Intent#FLAG_ACTIVITY_NO_HISTORY}, {@link android.content.Intent#FLAG_ACTIVITY_SINGLE_TOP}, {@link android.content.Intent#FLAG_ACTIVITY_NEW_TASK}, {@link android.content.Intent#FLAG_ACTIVITY_MULTIPLE_TASK}, {@link android.content.Intent#FLAG_ACTIVITY_CLEAR_TOP}, {@link android.content.Intent#FLAG_ACTIVITY_FORWARD_RESULT}, {@link android.content.Intent#FLAG_ACTIVITY_PREVIOUS_IS_TOP}, {@link android.content.Intent#FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS}, {@link android.content.Intent#FLAG_ACTIVITY_BROUGHT_TO_FRONT}, {@link android.content.Intent#FLAG_ACTIVITY_RESET_TASK_IF_NEEDED}, {@link android.content.Intent#FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY}, {@link android.content.Intent#FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET}, {@link android.content.Intent#FLAG_ACTIVITY_NEW_DOCUMENT}, {@link android.content.Intent#FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET}, {@link android.content.Intent#FLAG_ACTIVITY_NO_USER_ACTION}, {@link android.content.Intent#FLAG_ACTIVITY_REORDER_TO_FRONT}, {@link android.content.Intent#FLAG_ACTIVITY_NO_ANIMATION}, {@link android.content.Intent#FLAG_ACTIVITY_CLEAR_TASK}, {@link android.content.Intent#FLAG_ACTIVITY_TASK_ON_HOME}, {@link android.content.Intent#FLAG_ACTIVITY_RETAIN_IN_RECENTS}, {@link android.content.Intent#FLAG_ACTIVITY_LAUNCH_ADJACENT}, {@link android.content.Intent#FLAG_RECEIVER_REGISTERED_ONLY}, {@link android.content.Intent#FLAG_RECEIVER_REPLACE_PENDING}, {@link android.content.Intent#FLAG_RECEIVER_FOREGROUND}, {@link android.content.Intent#FLAG_RECEIVER_NO_ABORT}, android.content.Intent.FLAG_RECEIVER_REGISTERED_ONLY_BEFORE_BOOT, android.content.Intent.FLAG_RECEIVER_BOOT_UPGRADE, android.content.Intent.FLAG_RECEIVER_INCLUDE_BACKGROUND, android.content.Intent.FLAG_RECEIVER_EXCLUDE_BACKGROUND, android.content.Intent.FLAG_RECEIVER_FROM_SHELL, {@link android.content.Intent#FLAG_RECEIVER_VISIBLE_TO_INSTANT_APPS}, and android.content.Intent.FLAG_RECEIVER_OFFLOAD
 * @param extraFlags Always set to 0.
 * @param options Additional options for how the Activity should be started.
 * See {@link android.content.Context#startActivity(Intent, Bundle)}
 * Context.startActivity(Intent, Bundle)} for more details.  If options
 * have also been supplied by the IntentSender, options given here will
 * override any that conflict with those given by the IntentSender.
 *
 * This value may be {@code null}.
 * @see #startActivity(Intent, Bundle)
 * @see #startIntentSender(IntentSender, Intent, int, int, int)
 * @apiSince 16
 */

public abstract void startIntentSender(android.content.IntentSender intent, @androidx.annotation.Nullable android.content.Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, @androidx.annotation.Nullable android.os.Bundle options) throws android.content.IntentSender.SendIntentException;

/**
 * Broadcast the given intent to all interested BroadcastReceivers.  This
 * call is asynchronous; it returns immediately, and you will continue
 * executing while the receivers are run.  No results are propagated from
 * receivers and receivers can not abort the broadcast. If you want
 * to allow receivers to propagate results or abort the broadcast, you must
 * send an ordered broadcast using
 * {@link #sendOrderedBroadcast(android.content.Intent,java.lang.String)}.
 *
 * <p>See {@link android.content.BroadcastReceiver BroadcastReceiver} for more information on Intent broadcasts.
 *
 * @param intent The Intent to broadcast; all receivers matching this
 *               Intent will receive the broadcast.
 *
 * @see android.content.BroadcastReceiver
 * @see #registerReceiver
 * @see #sendBroadcast(Intent, String)
 * @see #sendOrderedBroadcast(Intent, String)
 * @see #sendOrderedBroadcast(Intent, String, BroadcastReceiver, Handler, int, String, Bundle)
 * @apiSince 1
 */

public abstract void sendBroadcast(android.content.Intent intent);

/**
 * Broadcast the given intent to all interested BroadcastReceivers, allowing
 * an optional required permission to be enforced.  This
 * call is asynchronous; it returns immediately, and you will continue
 * executing while the receivers are run.  No results are propagated from
 * receivers and receivers can not abort the broadcast. If you want
 * to allow receivers to propagate results or abort the broadcast, you must
 * send an ordered broadcast using
 * {@link #sendOrderedBroadcast(android.content.Intent,java.lang.String)}.
 *
 * <p>See {@link android.content.BroadcastReceiver BroadcastReceiver} for more information on Intent broadcasts.
 *
 * @param intent The Intent to broadcast; all receivers matching this
 *               Intent will receive the broadcast.
 * @param receiverPermission (optional) String naming a permission that
 *               a receiver must hold in order to receive your broadcast.
 *               If null, no permission is required.
 *
 * This value may be {@code null}.
 * @see android.content.BroadcastReceiver
 * @see #registerReceiver
 * @see #sendBroadcast(Intent)
 * @see #sendOrderedBroadcast(Intent, String)
 * @see #sendOrderedBroadcast(Intent, String, BroadcastReceiver, Handler, int, String, Bundle)
 * @apiSince 1
 */

public abstract void sendBroadcast(android.content.Intent intent, @androidx.annotation.Nullable java.lang.String receiverPermission);

/**
 * Broadcast the given intent to all interested BroadcastReceivers, delivering
 * them one at a time to allow more preferred receivers to consume the
 * broadcast before it is delivered to less preferred receivers.  This
 * call is asynchronous; it returns immediately, and you will continue
 * executing while the receivers are run.
 *
 * <p>See {@link android.content.BroadcastReceiver BroadcastReceiver} for more information on Intent broadcasts.
 *
 * @param intent The Intent to broadcast; all receivers matching this
 *               Intent will receive the broadcast.
 * @param receiverPermission (optional) String naming a permissions that
 *               a receiver must hold in order to receive your broadcast.
 *               If null, no permission is required.
 *
 * This value may be {@code null}.
 * @see android.content.BroadcastReceiver
 * @see #registerReceiver
 * @see #sendBroadcast(Intent)
 * @see #sendOrderedBroadcast(Intent, String, BroadcastReceiver, Handler, int, String, Bundle)
 * @apiSince 1
 */

public abstract void sendOrderedBroadcast(android.content.Intent intent, @androidx.annotation.Nullable java.lang.String receiverPermission);

/**
 * Version of {@link #sendBroadcast(android.content.Intent)} that allows you to
 * receive data back from the broadcast.  This is accomplished by
 * supplying your own BroadcastReceiver when calling, which will be
 * treated as a final receiver at the end of the broadcast -- its
 * {@link android.content.BroadcastReceiver#onReceive BroadcastReceiver#onReceive} method will be called with
 * the result values collected from the other receivers.  The broadcast will
 * be serialized in the same way as calling
 * {@link #sendOrderedBroadcast(android.content.Intent,java.lang.String)}.
 *
 * <p>Like {@link #sendBroadcast(android.content.Intent)}, this method is
 * asynchronous; it will return before
 * resultReceiver.onReceive() is called.
 *
 * <p>See {@link android.content.BroadcastReceiver BroadcastReceiver} for more information on Intent broadcasts.
 *
 * @param intent The Intent to broadcast; all receivers matching this
 *               Intent will receive the broadcast.
 * This value must never be {@code null}.
 * @param receiverPermission String naming a permissions that
 *               a receiver must hold in order to receive your broadcast.
 *               If null, no permission is required.
 * This value may be {@code null}.
 * @param resultReceiver Your own BroadcastReceiver to treat as the final
 *                       receiver of the broadcast.
 * This value may be {@code null}.
 * @param scheduler A custom Handler with which to schedule the
 *                  resultReceiver callback; if null it will be
 *                  scheduled in the Context's main thread.
 * This value may be {@code null}.
 * @param initialCode An initial value for the result code.  Often
 *                    Activity.RESULT_OK.
 * @param initialData An initial value for the result data.  Often
 *                    null.
 * This value may be {@code null}.
 * @param initialExtras An initial value for the result extras.  Often
 *                      null.
 *
 * This value may be {@code null}.
 * @see #sendBroadcast(Intent)
 * @see #sendBroadcast(Intent, String)
 * @see #sendOrderedBroadcast(Intent, String)
 * @see android.content.BroadcastReceiver
 * @see #registerReceiver
 * @see android.app.Activity#RESULT_OK
 * @apiSince 1
 */

public abstract void sendOrderedBroadcast(@androidx.annotation.NonNull android.content.Intent intent, @androidx.annotation.Nullable java.lang.String receiverPermission, @androidx.annotation.Nullable android.content.BroadcastReceiver resultReceiver, @androidx.annotation.Nullable android.os.Handler scheduler, int initialCode, @androidx.annotation.Nullable java.lang.String initialData, @androidx.annotation.Nullable android.os.Bundle initialExtras);

/**
 * Version of {@link #sendBroadcast(android.content.Intent)} that allows you to specify the
 * user the broadcast will be sent to.  This is not available to applications
 * that are not pre-installed on the system image.
 * <br>
 * Requires android.Manifest.permission.INTERACT_ACROSS_USERS
 * @param intent The intent to broadcast
 * @param user UserHandle to send the intent to.
 * @see #sendBroadcast(Intent)
 * @apiSince 17
 */

public abstract void sendBroadcastAsUser(android.content.Intent intent, android.os.UserHandle user);

/**
 * Version of {@link #sendBroadcast(android.content.Intent,java.lang.String)} that allows you to specify the
 * user the broadcast will be sent to.  This is not available to applications
 * that are not pre-installed on the system image.
 *
 * <br>
 * Requires android.Manifest.permission.INTERACT_ACROSS_USERS
 * @param intent The Intent to broadcast; all receivers matching this
 *               Intent will receive the broadcast.
 * @param user UserHandle to send the intent to.
 * @param receiverPermission (optional) String naming a permission that
 *               a receiver must hold in order to receive your broadcast.
 *               If null, no permission is required.
 *
 * This value may be {@code null}.
 * @see #sendBroadcast(Intent, String)
 * @apiSince 17
 */

public abstract void sendBroadcastAsUser(android.content.Intent intent, android.os.UserHandle user, @androidx.annotation.Nullable java.lang.String receiverPermission);

/**
 * Version of
 * {@link #sendOrderedBroadcast(android.content.Intent,java.lang.String,android.content.BroadcastReceiver,android.os.Handler,int,java.lang.String,android.os.Bundle)}
 * that allows you to specify the
 * user the broadcast will be sent to.  This is not available to applications
 * that are not pre-installed on the system image.
 *
 * <p>See {@link android.content.BroadcastReceiver BroadcastReceiver} for more information on Intent broadcasts.
 *
 * <br>
 * Requires android.Manifest.permission.INTERACT_ACROSS_USERS
 * @param intent The Intent to broadcast; all receivers matching this
 *               Intent will receive the broadcast.
 * @param user UserHandle to send the intent to.
 * @param receiverPermission String naming a permissions that
 *               a receiver must hold in order to receive your broadcast.
 *               If null, no permission is required.
 * This value may be {@code null}.
 * @param resultReceiver Your own BroadcastReceiver to treat as the final
 *                       receiver of the broadcast.
 * @param scheduler A custom Handler with which to schedule the
 *                  resultReceiver callback; if null it will be
 *                  scheduled in the Context's main thread.
 * This value may be {@code null}.
 * @param initialCode An initial value for the result code.  Often
 *                    Activity.RESULT_OK.
 * @param initialData An initial value for the result data.  Often
 *                    null.
 * This value may be {@code null}.
 * @param initialExtras An initial value for the result extras.  Often
 *                      null.
 *
 * This value may be {@code null}.
 * @see #sendOrderedBroadcast(Intent, String, BroadcastReceiver, Handler, int, String, Bundle)
 * @apiSince 17
 */

public abstract void sendOrderedBroadcastAsUser(android.content.Intent intent, android.os.UserHandle user, @androidx.annotation.Nullable java.lang.String receiverPermission, android.content.BroadcastReceiver resultReceiver, @androidx.annotation.Nullable android.os.Handler scheduler, int initialCode, @androidx.annotation.Nullable java.lang.String initialData, @androidx.annotation.Nullable android.os.Bundle initialExtras);

/**
 * Version of
 * {@link #sendOrderedBroadcast(android.content.Intent,java.lang.String,android.content.BroadcastReceiver,android.os.Handler,int,java.lang.String,android.os.Bundle)} that allows you to specify the App Op to enforce restrictions on which receivers
 * the broadcast will be sent to.
 *
 * <p>See {@link android.content.BroadcastReceiver BroadcastReceiver} for more information on Intent broadcasts.
 *
 * @param intent The Intent to broadcast; all receivers matching this
 *               Intent will receive the broadcast.
 * This value must never be {@code null}.
 * @param receiverPermission String naming a permissions that
 *               a receiver must hold in order to receive your broadcast.
 *               If null, no permission is required.
 * This value may be {@code null}.
 * @param receiverAppOp The app op associated with the broadcast. If null, no appOp is
 *                      required. If both receiverAppOp and receiverPermission are non-null,
 *                      a receiver must have both of them to
 *                      receive the broadcast
 * This value may be {@code null}.
 * @param resultReceiver Your own BroadcastReceiver to treat as the final
 *                       receiver of the broadcast.
 * This value may be {@code null}.
 * @param scheduler A custom Handler with which to schedule the
 *                  resultReceiver callback; if null it will be
 *                  scheduled in the Context's main thread.
 * This value may be {@code null}.
 * @param initialCode An initial value for the result code.  Often
 *                    Activity.RESULT_OK.
 * @param initialData An initial value for the result data.  Often
 *                    null.
 * This value may be {@code null}.
 * @param initialExtras An initial value for the result extras.  Often
 *                      null.
 *
 * This value may be {@code null}.
 * @see #sendOrderedBroadcast(Intent, String, BroadcastReceiver, Handler, int, String, Bundle)
 * @apiSince R
 */

public void sendOrderedBroadcast(@androidx.annotation.NonNull android.content.Intent intent, @androidx.annotation.Nullable java.lang.String receiverPermission, @androidx.annotation.Nullable java.lang.String receiverAppOp, @androidx.annotation.Nullable android.content.BroadcastReceiver resultReceiver, @androidx.annotation.Nullable android.os.Handler scheduler, int initialCode, @androidx.annotation.Nullable java.lang.String initialData, @androidx.annotation.Nullable android.os.Bundle initialExtras) { throw new RuntimeException("Stub!"); }

/**
 * Version of
 * {@link #sendOrderedBroadcast(android.content.Intent,java.lang.String,android.content.BroadcastReceiver,android.os.Handler,int,java.lang.String,android.os.Bundle)} that allows you to specify the App Op to enforce restrictions on which receivers
 * the broadcast will be sent to as well as supply an optional sending options
 *
 * <p>See {@link android.content.BroadcastReceiver BroadcastReceiver} for more information on Intent broadcasts.
 *
 * @param intent The Intent to broadcast; all receivers matching this
 *               Intent will receive the broadcast.
 * This value must never be {@code null}.
 * @param receiverPermission String naming a permissions that
 *               a receiver must hold in order to receive your broadcast.
 *               If null, no permission is required.
 * This value may be {@code null}.
 * @param receiverAppOp The app op associated with the broadcast. If null, no appOp is
 *                      required. If both receiverAppOp and receiverPermission are non-null,
 *                      a receiver must have both of them to
 *                      receive the broadcast
 * This value may be {@code null}.
 * @param options (optional) Additional sending options, generated from a
 * {@link android.app.BroadcastOptions}.
 * This value may be {@code null}.
 * @param resultReceiver Your own BroadcastReceiver to treat as the final
 *                       receiver of the broadcast.
 * This value may be {@code null}.
 * @param scheduler A custom Handler with which to schedule the
 *                  resultReceiver callback; if null it will be
 *                  scheduled in the Context's main thread.
 * This value may be {@code null}.
 * @param initialCode An initial value for the result code.  Often
 *                    Activity.RESULT_OK.
 * @param initialData An initial value for the result data.  Often
 *                    null.
 * This value may be {@code null}.
 * @param initialExtras An initial value for the result extras.  Often
 *                      null.
 *
 * This value may be {@code null}.
 * @see #sendOrderedBroadcast(Intent, String, BroadcastReceiver, Handler, int, String, Bundle)
 * @see android.app.BroadcastOptions
 * @apiSince R
 */

public void sendOrderedBroadcast(@androidx.annotation.NonNull android.content.Intent intent, @androidx.annotation.Nullable java.lang.String receiverPermission, @androidx.annotation.Nullable java.lang.String receiverAppOp, @androidx.annotation.Nullable android.os.Bundle options, @androidx.annotation.Nullable android.content.BroadcastReceiver resultReceiver, @androidx.annotation.Nullable android.os.Handler scheduler, int initialCode, @androidx.annotation.Nullable java.lang.String initialData, @androidx.annotation.Nullable android.os.Bundle initialExtras) { throw new RuntimeException("Stub!"); }

/**
 * <p>Perform a {@link #sendBroadcast(android.content.Intent)} that is "sticky," meaning the
 * Intent you are sending stays around after the broadcast is complete,
 * so that others can quickly retrieve that data through the return
 * value of {@link #registerReceiver(android.content.BroadcastReceiver,android.content.IntentFilter)}.  In
 * all other ways, this behaves the same as
 * {@link #sendBroadcast(android.content.Intent)}.
 *
 * <br>
 * Requires {@link android.Manifest.permission#BROADCAST_STICKY}
 * @deprecated Sticky broadcasts should not be used.  They provide no security (anyone
 * can access them), no protection (anyone can modify them), and many other problems.
 * The recommended pattern is to use a non-sticky broadcast to report that <em>something</em>
 * has changed, with another mechanism for apps to retrieve the current value whenever
 * desired.
 *
 * @param intent The Intent to broadcast; all receivers matching this
 * Intent will receive the broadcast, and the Intent will be held to
 * be re-broadcast to future receivers.
 *
 * @see #sendBroadcast(Intent)
 * @see #sendStickyOrderedBroadcast(Intent, BroadcastReceiver, Handler, int, String, Bundle)
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public abstract void sendStickyBroadcast(android.content.Intent intent);

/**
 * <p>Version of {@link #sendStickyBroadcast} that allows you to
 * receive data back from the broadcast.  This is accomplished by
 * supplying your own BroadcastReceiver when calling, which will be
 * treated as a final receiver at the end of the broadcast -- its
 * {@link android.content.BroadcastReceiver#onReceive BroadcastReceiver#onReceive} method will be called with
 * the result values collected from the other receivers.  The broadcast will
 * be serialized in the same way as calling
 * {@link #sendOrderedBroadcast(android.content.Intent,java.lang.String)}.
 *
 * <p>Like {@link #sendBroadcast(android.content.Intent)}, this method is
 * asynchronous; it will return before
 * resultReceiver.onReceive() is called.  Note that the sticky data
 * stored is only the data you initially supply to the broadcast, not
 * the result of any changes made by the receivers.
 *
 * <p>See {@link android.content.BroadcastReceiver BroadcastReceiver} for more information on Intent broadcasts.
 *
 * <br>
 * Requires {@link android.Manifest.permission#BROADCAST_STICKY}
 * @deprecated Sticky broadcasts should not be used.  They provide no security (anyone
 * can access them), no protection (anyone can modify them), and many other problems.
 * The recommended pattern is to use a non-sticky broadcast to report that <em>something</em>
 * has changed, with another mechanism for apps to retrieve the current value whenever
 * desired.
 *
 * @param intent The Intent to broadcast; all receivers matching this
 *               Intent will receive the broadcast.
 * @param resultReceiver Your own BroadcastReceiver to treat as the final
 *                       receiver of the broadcast.
 * @param scheduler A custom Handler with which to schedule the
 *                  resultReceiver callback; if null it will be
 *                  scheduled in the Context's main thread.
 * This value may be {@code null}.
 * @param initialCode An initial value for the result code.  Often
 *                    Activity.RESULT_OK.
 * @param initialData An initial value for the result data.  Often
 *                    null.
 * This value may be {@code null}.
 * @param initialExtras An initial value for the result extras.  Often
 *                      null.
 *
 * This value may be {@code null}.
 * @see #sendBroadcast(Intent)
 * @see #sendBroadcast(Intent, String)
 * @see #sendOrderedBroadcast(Intent, String)
 * @see #sendStickyBroadcast(Intent)
 * @see android.content.BroadcastReceiver
 * @see #registerReceiver
 * @see android.app.Activity#RESULT_OK
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public abstract void sendStickyOrderedBroadcast(android.content.Intent intent, android.content.BroadcastReceiver resultReceiver, @androidx.annotation.Nullable android.os.Handler scheduler, int initialCode, @androidx.annotation.Nullable java.lang.String initialData, @androidx.annotation.Nullable android.os.Bundle initialExtras);

/**
 * <p>Remove the data previously sent with {@link #sendStickyBroadcast},
 * so that it is as if the sticky broadcast had never happened.
 *
 * <br>
 * Requires {@link android.Manifest.permission#BROADCAST_STICKY}
 * @deprecated Sticky broadcasts should not be used.  They provide no security (anyone
 * can access them), no protection (anyone can modify them), and many other problems.
 * The recommended pattern is to use a non-sticky broadcast to report that <em>something</em>
 * has changed, with another mechanism for apps to retrieve the current value whenever
 * desired.
 *
 * @param intent The Intent that was previously broadcast.
 *
 * @see #sendStickyBroadcast
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public abstract void removeStickyBroadcast(android.content.Intent intent);

/**
 * <p>Version of {@link #sendStickyBroadcast(android.content.Intent)} that allows you to specify the
 * user the broadcast will be sent to.  This is not available to applications
 * that are not pre-installed on the system image.
 *
 * <br>
 * Requires android.Manifest.permission.INTERACT_ACROSS_USERS and {@link android.Manifest.permission#BROADCAST_STICKY}
 * @deprecated Sticky broadcasts should not be used.  They provide no security (anyone
 * can access them), no protection (anyone can modify them), and many other problems.
 * The recommended pattern is to use a non-sticky broadcast to report that <em>something</em>
 * has changed, with another mechanism for apps to retrieve the current value whenever
 * desired.
 *
 * @param intent The Intent to broadcast; all receivers matching this
 * Intent will receive the broadcast, and the Intent will be held to
 * be re-broadcast to future receivers.
 * @param user UserHandle to send the intent to.
 *
 * @see #sendBroadcast(Intent)
 * @apiSince 17
 * @deprecatedSince 21
 */

@Deprecated
public abstract void sendStickyBroadcastAsUser(android.content.Intent intent, android.os.UserHandle user);

/**
 * <p>Version of
 * {@link #sendStickyOrderedBroadcast(android.content.Intent,android.content.BroadcastReceiver,android.os.Handler,int,java.lang.String,android.os.Bundle)}
 * that allows you to specify the
 * user the broadcast will be sent to.  This is not available to applications
 * that are not pre-installed on the system image.
 *
 * <p>See {@link android.content.BroadcastReceiver BroadcastReceiver} for more information on Intent broadcasts.
 *
 * <br>
 * Requires android.Manifest.permission.INTERACT_ACROSS_USERS and {@link android.Manifest.permission#BROADCAST_STICKY}
 * @deprecated Sticky broadcasts should not be used.  They provide no security (anyone
 * can access them), no protection (anyone can modify them), and many other problems.
 * The recommended pattern is to use a non-sticky broadcast to report that <em>something</em>
 * has changed, with another mechanism for apps to retrieve the current value whenever
 * desired.
 *
 * @param intent The Intent to broadcast; all receivers matching this
 *               Intent will receive the broadcast.
 * @param user UserHandle to send the intent to.
 * @param resultReceiver Your own BroadcastReceiver to treat as the final
 *                       receiver of the broadcast.
 * @param scheduler A custom Handler with which to schedule the
 *                  resultReceiver callback; if null it will be
 *                  scheduled in the Context's main thread.
 * This value may be {@code null}.
 * @param initialCode An initial value for the result code.  Often
 *                    Activity.RESULT_OK.
 * @param initialData An initial value for the result data.  Often
 *                    null.
 * This value may be {@code null}.
 * @param initialExtras An initial value for the result extras.  Often
 *                      null.
 *
 * This value may be {@code null}.
 * @see #sendStickyOrderedBroadcast(Intent, BroadcastReceiver, Handler, int, String, Bundle)
 * @apiSince 17
 * @deprecatedSince 21
 */

@Deprecated
public abstract void sendStickyOrderedBroadcastAsUser(android.content.Intent intent, android.os.UserHandle user, android.content.BroadcastReceiver resultReceiver, @androidx.annotation.Nullable android.os.Handler scheduler, int initialCode, @androidx.annotation.Nullable java.lang.String initialData, @androidx.annotation.Nullable android.os.Bundle initialExtras);

/**
 * <p>Version of {@link #removeStickyBroadcast(android.content.Intent)} that allows you to specify the
 * user the broadcast will be sent to.  This is not available to applications
 * that are not pre-installed on the system image.
 *
 * <p>You must hold the {@link android.Manifest.permission#BROADCAST_STICKY}
 * permission in order to use this API.  If you do not hold that
 * permission, {@link java.lang.SecurityException SecurityException} will be thrown.
 *
 * <br>
 * Requires android.Manifest.permission.INTERACT_ACROSS_USERS and {@link android.Manifest.permission#BROADCAST_STICKY}
 * @deprecated Sticky broadcasts should not be used.  They provide no security (anyone
 * can access them), no protection (anyone can modify them), and many other problems.
 * The recommended pattern is to use a non-sticky broadcast to report that <em>something</em>
 * has changed, with another mechanism for apps to retrieve the current value whenever
 * desired.
 *
 * @param intent The Intent that was previously broadcast.
 * @param user UserHandle to remove the sticky broadcast from.
 *
 * @see #sendStickyBroadcastAsUser
 * @apiSince 17
 * @deprecatedSince 21
 */

@Deprecated
public abstract void removeStickyBroadcastAsUser(android.content.Intent intent, android.os.UserHandle user);

/**
 * Register a BroadcastReceiver to be run in the main activity thread.  The
 * <var>receiver</var> will be called with any broadcast Intent that
 * matches <var>filter</var>, in the main application thread.
 *
 * <p>The system may broadcast Intents that are "sticky" -- these stay
 * around after the broadcast has finished, to be sent to any later
 * registrations. If your IntentFilter matches one of these sticky
 * Intents, that Intent will be returned by this function
 * <strong>and</strong> sent to your <var>receiver</var> as if it had just
 * been broadcast.
 *
 * <p>There may be multiple sticky Intents that match <var>filter</var>,
 * in which case each of these will be sent to <var>receiver</var>.  In
 * this case, only one of these can be returned directly by the function;
 * which of these that is returned is arbitrarily decided by the system.
 *
 * <p>If you know the Intent your are registering for is sticky, you can
 * supply null for your <var>receiver</var>.  In this case, no receiver is
 * registered -- the function simply returns the sticky Intent that
 * matches <var>filter</var>.  In the case of multiple matches, the same
 * rules as described above apply.
 *
 * <p>See {@link android.content.BroadcastReceiver BroadcastReceiver} for more information on Intent broadcasts.
 *
 * <p>As of {@link android.os.Build.VERSION_CODES#ICE_CREAM_SANDWICH}, receivers
 * registered with this method will correctly respect the
 * {@link android.content.Intent#setPackage(java.lang.String) Intent#setPackage(String)} specified for an Intent being broadcast.
 * Prior to that, it would be ignored and delivered to all matching registered
 * receivers.  Be careful if using this for security.</p>
 *
 * <p class="note">Note: this method <em>cannot be called from a
 * {@link android.content.BroadcastReceiver BroadcastReceiver} component;</em> that is, from a BroadcastReceiver
 * that is declared in an application's manifest.  It is okay, however, to call
 * this method from another BroadcastReceiver that has itself been registered
 * at run time with {@link #registerReceiver}, since the lifetime of such a
 * registered BroadcastReceiver is tied to the object that registered it.</p>
 *
 * @param receiver The BroadcastReceiver to handle the broadcast.
 * This value may be {@code null}.
 * @param filter Selects the Intent broadcasts to be received.
 *
 * @return The first sticky intent found that matches <var>filter</var>,
 *         or null if there are none.
 *
 * @see #registerReceiver(BroadcastReceiver, IntentFilter, String, Handler)
 * @see #sendBroadcast
 * @see #unregisterReceiver
 * @apiSince 1
 */

@androidx.annotation.Nullable
public abstract android.content.Intent registerReceiver(@androidx.annotation.Nullable android.content.BroadcastReceiver receiver, android.content.IntentFilter filter);

/**
 * Register to receive intent broadcasts, with the receiver optionally being
 * exposed to Instant Apps. See
 * {@link #registerReceiver(android.content.BroadcastReceiver,android.content.IntentFilter)} for more
 * information. By default Instant Apps cannot interact with receivers in other
 * applications, this allows you to expose a receiver that Instant Apps can
 * interact with.
 *
 * <p>See {@link android.content.BroadcastReceiver BroadcastReceiver} for more information on Intent broadcasts.
 *
 * <p>As of {@link android.os.Build.VERSION_CODES#ICE_CREAM_SANDWICH}, receivers
 * registered with this method will correctly respect the
 * {@link android.content.Intent#setPackage(java.lang.String) Intent#setPackage(String)} specified for an Intent being broadcast.
 * Prior to that, it would be ignored and delivered to all matching registered
 * receivers.  Be careful if using this for security.</p>
 *
 * @param receiver The BroadcastReceiver to handle the broadcast.
 * This value may be {@code null}.
 * @param filter Selects the Intent broadcasts to be received.
 * @param flags Additional options for the receiver. May be 0 or
 *      {@link #RECEIVER_VISIBLE_TO_INSTANT_APPS}.
 *
 * Value is either <code>0</code> or {@link android.content.Context#RECEIVER_VISIBLE_TO_INSTANT_APPS}
 * @return The first sticky intent found that matches <var>filter</var>,
 *         or null if there are none.
 *
 * @see #registerReceiver(BroadcastReceiver, IntentFilter)
 * @see #sendBroadcast
 * @see #unregisterReceiver
 * @apiSince 26
 */

@androidx.annotation.Nullable
public abstract android.content.Intent registerReceiver(@androidx.annotation.Nullable android.content.BroadcastReceiver receiver, android.content.IntentFilter filter, int flags);

/**
 * Register to receive intent broadcasts, to run in the context of
 * <var>scheduler</var>.  See
 * {@link #registerReceiver(android.content.BroadcastReceiver,android.content.IntentFilter)} for more
 * information.  This allows you to enforce permissions on who can
 * broadcast intents to your receiver, or have the receiver run in
 * a different thread than the main application thread.
 *
 * <p>See {@link android.content.BroadcastReceiver BroadcastReceiver} for more information on Intent broadcasts.
 *
 * <p>As of {@link android.os.Build.VERSION_CODES#ICE_CREAM_SANDWICH}, receivers
 * registered with this method will correctly respect the
 * {@link android.content.Intent#setPackage(java.lang.String) Intent#setPackage(String)} specified for an Intent being broadcast.
 * Prior to that, it would be ignored and delivered to all matching registered
 * receivers.  Be careful if using this for security.</p>
 *
 * @param receiver The BroadcastReceiver to handle the broadcast.
 * @param filter Selects the Intent broadcasts to be received.
 * @param broadcastPermission String naming a permissions that a
 *      broadcaster must hold in order to send an Intent to you.  If null,
 *      no permission is required.
 * This value may be {@code null}.
 * @param scheduler Handler identifying the thread that will receive
 *      the Intent.  If null, the main thread of the process will be used.
 *
 * This value may be {@code null}.
 * @return The first sticky intent found that matches <var>filter</var>,
 *         or null if there are none.
 *
 * @see #registerReceiver(BroadcastReceiver, IntentFilter)
 * @see #sendBroadcast
 * @see #unregisterReceiver
 * @apiSince 1
 */

@androidx.annotation.Nullable
public abstract android.content.Intent registerReceiver(android.content.BroadcastReceiver receiver, android.content.IntentFilter filter, @androidx.annotation.Nullable java.lang.String broadcastPermission, @androidx.annotation.Nullable android.os.Handler scheduler);

/**
 * Register to receive intent broadcasts, to run in the context of
 * <var>scheduler</var>. See
 * {@link #registerReceiver(android.content.BroadcastReceiver,android.content.IntentFilter,int)} and
 * {@link #registerReceiver(android.content.BroadcastReceiver,android.content.IntentFilter,java.lang.String,android.os.Handler)}
 * for more information.
 *
 * <p>See {@link android.content.BroadcastReceiver BroadcastReceiver} for more information on Intent broadcasts.
 *
 * <p>As of {@link android.os.Build.VERSION_CODES#ICE_CREAM_SANDWICH}, receivers
 * registered with this method will correctly respect the
 * {@link android.content.Intent#setPackage(java.lang.String) Intent#setPackage(String)} specified for an Intent being broadcast.
 * Prior to that, it would be ignored and delivered to all matching registered
 * receivers.  Be careful if using this for security.</p>
 *
 * @param receiver The BroadcastReceiver to handle the broadcast.
 * @param filter Selects the Intent broadcasts to be received.
 * @param broadcastPermission String naming a permissions that a
 *      broadcaster must hold in order to send an Intent to you.  If null,
 *      no permission is required.
 * This value may be {@code null}.
 * @param scheduler Handler identifying the thread that will receive
 *      the Intent.  If null, the main thread of the process will be used.
 * This value may be {@code null}.
 * @param flags Additional options for the receiver. May be 0 or
 *      {@link #RECEIVER_VISIBLE_TO_INSTANT_APPS}.
 *
 * Value is either <code>0</code> or {@link android.content.Context#RECEIVER_VISIBLE_TO_INSTANT_APPS}
 * @return The first sticky intent found that matches <var>filter</var>,
 *         or null if there are none.
 *
 * @see #registerReceiver(BroadcastReceiver, IntentFilter, int)
 * @see #registerReceiver(BroadcastReceiver, IntentFilter, String, Handler)
 * @see #sendBroadcast
 * @see #unregisterReceiver
 * @apiSince 26
 */

@androidx.annotation.Nullable
public abstract android.content.Intent registerReceiver(android.content.BroadcastReceiver receiver, android.content.IntentFilter filter, @androidx.annotation.Nullable java.lang.String broadcastPermission, @androidx.annotation.Nullable android.os.Handler scheduler, int flags);

/**
 * Unregister a previously registered BroadcastReceiver.  <em>All</em>
 * filters that have been registered for this BroadcastReceiver will be
 * removed.
 *
 * @param receiver The BroadcastReceiver to unregister.
 *
 * @see #registerReceiver
 * @apiSince 1
 */

public abstract void unregisterReceiver(android.content.BroadcastReceiver receiver);

/**
 * Request that a given application service be started.  The Intent
 * should either contain the complete class name of a specific service
 * implementation to start, or a specific package name to target.  If the
 * Intent is less specified, it logs a warning about this.  In this case any of the
 * multiple matching services may be used.  If this service
 * is not already running, it will be instantiated and started (creating a
 * process for it if needed); if it is running then it remains running.
 *
 * <p>Every call to this method will result in a corresponding call to
 * the target service's {@link android.app.Service#onStartCommand} method,
 * with the <var>intent</var> given here.  This provides a convenient way
 * to submit jobs to a service without having to bind and call on to its
 * interface.
 *
 * <p>Using startService() overrides the default service lifetime that is
 * managed by {@link #bindService}: it requires the service to remain
 * running until {@link #stopService} is called, regardless of whether
 * any clients are connected to it.  Note that calls to startService()
 * do not nest: no matter how many times you call startService(),
 * a single call to {@link #stopService} will stop it.
 *
 * <p>The system attempts to keep running services around as much as
 * possible.  The only time they should be stopped is if the current
 * foreground application is using so many resources that the service needs
 * to be killed.  If any errors happen in the service's process, it will
 * automatically be restarted.
 *
 * <p>This function will throw {@link java.lang.SecurityException SecurityException} if you do not
 * have permission to start the given service.
 *
 * <p class="note"><strong>Note:</strong> Each call to startService()
 * results in significant work done by the system to manage service
 * lifecycle surrounding the processing of the intent, which can take
 * multiple milliseconds of CPU time. Due to this cost, startService()
 * should not be used for frequent intent delivery to a service, and only
 * for scheduling significant work. Use {@link #bindService bound services}
 * for high frequency calls.
 * </p>
 *
 * @param service Identifies the service to be started.  The Intent must be
 *      fully explicit (supplying a component name).  Additional values
 *      may be included in the Intent extras to supply arguments along with
 *      this specific start call.
 *
 * @return If the service is being started or is already running, the
 * {@link android.content.ComponentName ComponentName} of the actual service that was started is
 * returned; else if the service does not exist null is returned.
 *
 * @throws java.lang.SecurityException If the caller does not have permission to access the service
 * or the service can not be found.
 * @throws java.lang.IllegalStateException If the application is in a state where the service
 * can not be started (such as not in the foreground in a state when services are allowed).
 *
 * @see #stopService
 * @see #bindService
 * @apiSince 1
 */

@androidx.annotation.Nullable
public abstract android.content.ComponentName startService(android.content.Intent service);

/**
 * Similar to {@link #startService(android.content.Intent)}, but with an implicit promise that the
 * Service will call {@link android.app.Service#startForeground(int, android.app.Notification)
 * startForeground(int, android.app.Notification)} once it begins running.  The service is given
 * an amount of time comparable to the ANR interval to do this, otherwise the system
 * will automatically stop the service and declare the app ANR.
 *
 * <p>Unlike the ordinary {@link #startService(android.content.Intent)}, this method can be used
 * at any time, regardless of whether the app hosting the service is in a foreground
 * state.
 *
 * @param service Identifies the service to be started.  The Intent must be
 *      fully explicit (supplying a component name).  Additional values
 *      may be included in the Intent extras to supply arguments along with
 *      this specific start call.
 *
 * @return If the service is being started or is already running, the
 * {@link android.content.ComponentName ComponentName} of the actual service that was started is
 * returned; else if the service does not exist null is returned.
 *
 * @throws java.lang.SecurityException If the caller does not have permission to access the service
 * or the service can not be found.
 *
 * @see #stopService
 * @see android.app.Service#startForeground(int, android.app.Notification)
 * @apiSince 26
 */

@androidx.annotation.Nullable
public abstract android.content.ComponentName startForegroundService(android.content.Intent service);

/**
 * Request that a given application service be stopped.  If the service is
 * not running, nothing happens.  Otherwise it is stopped.  Note that calls
 * to startService() are not counted -- this stops the service no matter
 * how many times it was started.
 *
 * <p>Note that if a stopped service still has {@link android.content.ServiceConnection ServiceConnection}
 * objects bound to it with the {@link #BIND_AUTO_CREATE} set, it will
 * not be destroyed until all of these bindings are removed.  See
 * the {@link android.app.Service} documentation for more details on a
 * service's lifecycle.
 *
 * <p>This function will throw {@link java.lang.SecurityException SecurityException} if you do not
 * have permission to stop the given service.
 *
 * @param service Description of the service to be stopped.  The Intent must be either
 *      fully explicit (supplying a component name) or specify a specific package
 *      name it is targeted to.
 *
 * @return If there is a service matching the given Intent that is already
 * running, then it is stopped and {@code true} is returned; else {@code false} is returned.
 *
 * @throws java.lang.SecurityException If the caller does not have permission to access the service
 * or the service can not be found.
 * @throws java.lang.IllegalStateException If the application is in a state where the service
 * can not be started (such as not in the foreground in a state when services are allowed).
 *
 * @see #startService
 * @apiSince 1
 */

public abstract boolean stopService(android.content.Intent service);

/**
 * Connect to an application service, creating it if needed.  This defines
 * a dependency between your application and the service.  The given
 * <var>conn</var> will receive the service object when it is created and be
 * told if it dies and restarts.  The service will be considered required
 * by the system only for as long as the calling context exists.  For
 * example, if this Context is an Activity that is stopped, the service will
 * not be required to continue running until the Activity is resumed.
 *
 * <p>If the service does not support binding, it may return {@code null} from
 * its {@link android.app.Service#onBind(Intent) onBind()} method.  If it does, then
 * the ServiceConnection's
 * {@link android.content.ServiceConnection#onNullBinding(android.content.ComponentName) ServiceConnection#onNullBinding(ComponentName)} method
 * will be invoked instead of
 * {@link android.content.ServiceConnection#onServiceConnected(android.content.ComponentName,android.os.IBinder) ServiceConnection#onServiceConnected(ComponentName, IBinder)}.
 *
 * <p>This method will throw {@link java.lang.SecurityException SecurityException} if the calling app does not
 * have permission to bind to the given service.
 *
 * <p class="note">Note: this method <em>cannot be called from a
 * {@link android.content.BroadcastReceiver BroadcastReceiver} component</em>.  A pattern you can use to
 * communicate from a BroadcastReceiver to a Service is to call
 * {@link #startService} with the arguments containing the command to be
 * sent, with the service calling its
 * {@link android.app.Service#stopSelf(int)} method when done executing
 * that command.  See the API demo App/Service/Service Start Arguments
 * Controller for an illustration of this.  It is okay, however, to use
 * this method from a BroadcastReceiver that has been registered with
 * {@link #registerReceiver}, since the lifetime of this BroadcastReceiver
 * is tied to another object (the one that registered it).</p>
 *
 * @param service Identifies the service to connect to.  The Intent must
 *      specify an explicit component name.
 * @param conn Receives information as the service is started and stopped.
 *      This must be a valid ServiceConnection object; it must not be null.
 * This value must never be {@code null}.
 * @param flags Operation options for the binding.  May be 0,
 *          {@link #BIND_AUTO_CREATE}, {@link #BIND_DEBUG_UNBIND},
 *          {@link #BIND_NOT_FOREGROUND}, {@link #BIND_ABOVE_CLIENT},
 *          {@link #BIND_ALLOW_OOM_MANAGEMENT}, {@link #BIND_WAIVE_PRIORITY}.
 *          {@link #BIND_IMPORTANT}, or
 *          {@link #BIND_ADJUST_WITH_ACTIVITY}.
 * Value is either <code>0</code> or a combination of {@link android.content.Context#BIND_AUTO_CREATE}, {@link android.content.Context#BIND_DEBUG_UNBIND}, {@link android.content.Context#BIND_NOT_FOREGROUND}, {@link android.content.Context#BIND_ABOVE_CLIENT}, {@link android.content.Context#BIND_ALLOW_OOM_MANAGEMENT}, {@link android.content.Context#BIND_WAIVE_PRIORITY}, {@link android.content.Context#BIND_IMPORTANT}, {@link android.content.Context#BIND_ADJUST_WITH_ACTIVITY}, {@link android.content.Context#BIND_NOT_PERCEPTIBLE}, and {@link android.content.Context#BIND_INCLUDE_CAPABILITIES}
 * @return {@code true} if the system is in the process of bringing up a
 *         service that your client has permission to bind to; {@code false}
 *         if the system couldn't find the service or if your client doesn't
 *         have permission to bind to it. If this value is {@code true}, you
 *         should later call {@link #unbindService} to release the
 *         connection.
 *
 * @throws java.lang.SecurityException If the caller does not have permission to access the service
 * or the service can not be found.
 *
 * @see #unbindService
 * @see #startService
 * @see #BIND_AUTO_CREATE
 * @see #BIND_DEBUG_UNBIND
 * @see #BIND_NOT_FOREGROUND
 * @see #BIND_ABOVE_CLIENT
 * @see #BIND_ALLOW_OOM_MANAGEMENT
 * @see #BIND_WAIVE_PRIORITY
 * @see #BIND_IMPORTANT
 * @see #BIND_ADJUST_WITH_ACTIVITY
 * @apiSince 1
 */

public abstract boolean bindService(android.content.Intent service, @androidx.annotation.NonNull android.content.ServiceConnection conn, int flags);

/**
 * Same as {@link #bindService(android.content.Intent,android.content.ServiceConnection,int)} with executor to control
 * ServiceConnection callbacks.
 * @param executor Callbacks on ServiceConnection will be called on executor. Must use same
 *      instance for the same instance of ServiceConnection.
 
 * This value must never be {@code null}.
 * Callback and listener events are dispatched through this
 * {@link java.util.concurrent.Executor Executor}, providing an easy way to control which thread is
 * used. To dispatch events through the main thread of your
 * application, you can use {@link android.content.Context#getMainExecutor() Context#getMainExecutor()}. To
 * dispatch events through a shared thread pool, you can use
 * {@link android.os.AsyncTask#THREAD_POOL_EXECUTOR AsyncTask#THREAD_POOL_EXECUTOR}.
 * @param service This value must never be {@code null}.
 
 * @param flags Value is either <code>0</code> or a combination of {@link android.content.Context#BIND_AUTO_CREATE}, {@link android.content.Context#BIND_DEBUG_UNBIND}, {@link android.content.Context#BIND_NOT_FOREGROUND}, {@link android.content.Context#BIND_ABOVE_CLIENT}, {@link android.content.Context#BIND_ALLOW_OOM_MANAGEMENT}, {@link android.content.Context#BIND_WAIVE_PRIORITY}, {@link android.content.Context#BIND_IMPORTANT}, {@link android.content.Context#BIND_ADJUST_WITH_ACTIVITY}, {@link android.content.Context#BIND_NOT_PERCEPTIBLE}, and {@link android.content.Context#BIND_INCLUDE_CAPABILITIES}
 
 * @param conn This value must never be {@code null}.
 * @apiSince 29
 */

public boolean bindService(@androidx.annotation.NonNull android.content.Intent service, int flags, @androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull android.content.ServiceConnection conn) { throw new RuntimeException("Stub!"); }

/**
 * Variation of {@link #bindService} that, in the specific case of isolated
 * services, allows the caller to generate multiple instances of a service
 * from a single component declaration.  In other words, you can use this to bind
 * to a service that has specified {@link android.R.attr#isolatedProcess} and, in
 * addition to the existing behavior of running in an isolated process, you can
 * also through the arguments here have the system bring up multiple concurrent
 * processes hosting their own instances of that service.  The <var>instanceName</var>
 * you provide here identifies the different instances, and you can use
 * {@link #updateServiceGroup(android.content.ServiceConnection,int,int)} to tell the system how it
 * should manage each of these instances.
 *
 * @param service Identifies the service to connect to.  The Intent must
 *      specify an explicit component name.
 * This value must never be {@code null}.
 * @param flags Operation options for the binding as per {@link #bindService}.
 * Value is either <code>0</code> or a combination of {@link android.content.Context#BIND_AUTO_CREATE}, {@link android.content.Context#BIND_DEBUG_UNBIND}, {@link android.content.Context#BIND_NOT_FOREGROUND}, {@link android.content.Context#BIND_ABOVE_CLIENT}, {@link android.content.Context#BIND_ALLOW_OOM_MANAGEMENT}, {@link android.content.Context#BIND_WAIVE_PRIORITY}, {@link android.content.Context#BIND_IMPORTANT}, {@link android.content.Context#BIND_ADJUST_WITH_ACTIVITY}, {@link android.content.Context#BIND_NOT_PERCEPTIBLE}, and {@link android.content.Context#BIND_INCLUDE_CAPABILITIES}
 * @param instanceName Unique identifier for the service instance.  Each unique
 *      name here will result in a different service instance being created.  Identifiers
 *      must only contain ASCII letters, digits, underscores, and periods.
 * This value must never be {@code null}.
 * @return Returns success of binding as per {@link #bindService}.
 * @param executor Callbacks on ServiceConnection will be called on executor.
 *      Must use same instance for the same instance of ServiceConnection.
 * This value must never be {@code null}.
 * Callback and listener events are dispatched through this
 * {@link java.util.concurrent.Executor Executor}, providing an easy way to control which thread is
 * used. To dispatch events through the main thread of your
 * application, you can use {@link android.content.Context#getMainExecutor() Context#getMainExecutor()}. To
 * dispatch events through a shared thread pool, you can use
 * {@link android.os.AsyncTask#THREAD_POOL_EXECUTOR AsyncTask#THREAD_POOL_EXECUTOR}.
 * @param conn Receives information as the service is started and stopped.
 *      This must be a valid ServiceConnection object; it must not be null.
 *
 * This value must never be {@code null}.
 * @throws java.lang.SecurityException If the caller does not have permission to access the service
 * @throws java.lang.IllegalArgumentException If the instanceName is invalid.
 *
 * @see #bindService
 * @see #updateServiceGroup
 * @see android.R.attr#isolatedProcess
 * @apiSince 29
 */

public boolean bindIsolatedService(@androidx.annotation.NonNull android.content.Intent service, int flags, @androidx.annotation.NonNull java.lang.String instanceName, @androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull android.content.ServiceConnection conn) { throw new RuntimeException("Stub!"); }

/**
 * For a service previously bound with {@link #bindService} or a related method, change
 * how the system manages that service's process in relation to other processes.  This
 * doesn't modify the original bind flags that were passed in when binding, but adjusts
 * how the process will be managed in some cases based on those flags.  Currently only
 * works on isolated processes (will be ignored for non-isolated processes).
 *
 * <p>Note that this call does not take immediate effect, but will be applied the next
 * time the impacted process is adjusted for some other reason.  Typically you would
 * call this before then calling a new {@link #bindIsolatedService} on the service
 * of interest, with that binding causing the process to be shuffled accordingly.</p>
 *
 * @param conn The connection interface previously supplied to bindService().  This
 *             parameter must not be null.
 * This value must never be {@code null}.
 * @param group A group to put this connection's process in.  Upon calling here, this
 *              will override any previous group that was set for that process.  The group
 *              tells the system about processes that are logically grouped together, so
 *              should be managed as one unit of importance (such as when being considered
 *              a recently used app).  All processes in the same app with the same group
 *              are considered to be related.  Supplying 0 reverts to the default behavior
 *              of not grouping.
 * @param importance Additional importance of the processes within a group.  Upon calling
 *                   here, this will override any previous importance that was set for that
 *                   process.  The most important process is 0, and higher values are
 *                   successively less important.  You can view this as describing how
 *                   to order the processes in an array, with the processes at the end of
 *                   the array being the least important.  This value has no meaning besides
 *                   indicating how processes should be ordered in that array one after the
 *                   other.  This provides a way to fine-tune the system's process killing,
 *                   guiding it to kill processes at the end of the array first.
 *
 * @see #bindIsolatedService
 * @apiSince 29
 */

public void updateServiceGroup(@androidx.annotation.NonNull android.content.ServiceConnection conn, int group, int importance) { throw new RuntimeException("Stub!"); }

/**
 * Disconnect from an application service.  You will no longer receive
 * calls as the service is restarted, and the service is now allowed to
 * stop at any time.
 *
 * @param conn The connection interface previously supplied to
 *             bindService().  This parameter must not be null.
 *
 * This value must never be {@code null}.
 * @see #bindService
 * @apiSince 1
 */

public abstract void unbindService(@androidx.annotation.NonNull android.content.ServiceConnection conn);

/**
 * Start executing an {@link android.app.Instrumentation} class.  The given
 * Instrumentation component will be run by killing its target application
 * (if currently running), starting the target process, instantiating the
 * instrumentation component, and then letting it drive the application.
 *
 * <p>This function is not synchronous -- it returns as soon as the
 * instrumentation has started and while it is running.
 *
 * <p>Instrumentation is normally only allowed to run against a package
 * that is either unsigned or signed with a signature that the
 * the instrumentation package is also signed with (ensuring the target
 * trusts the instrumentation).
 *
 * @param className Name of the Instrumentation component to be run.
 * This value must never be {@code null}.
 * @param profileFile Optional path to write profiling data as the
 * instrumentation runs, or null for no profiling.
 * This value may be {@code null}.
 * @param arguments Additional optional arguments to pass to the
 * instrumentation, or null.
 *
 * This value may be {@code null}.
 * @return {@code true} if the instrumentation was successfully started,
 * else {@code false} if it could not be found.
 * @apiSince 1
 */

public abstract boolean startInstrumentation(@androidx.annotation.NonNull android.content.ComponentName className, @androidx.annotation.Nullable java.lang.String profileFile, @androidx.annotation.Nullable android.os.Bundle arguments);

/**
 * Return the handle to a system-level service by name. The class of the
 * returned object varies by the requested name. Currently available names
 * are:
 *
 * <dl>
 *  <dt> {@link #WINDOW_SERVICE} ("window")
 *  <dd> The top-level window manager in which you can place custom
 *  windows.  The returned object is a {@link android.view.WindowManager}.
 *  <dt> {@link #LAYOUT_INFLATER_SERVICE} ("layout_inflater")
 *  <dd> A {@link android.view.LayoutInflater} for inflating layout resources
 *  in this context.
 *  <dt> {@link #ACTIVITY_SERVICE} ("activity")
 *  <dd> A {@link android.app.ActivityManager} for interacting with the
 *  global activity state of the system.
 *  <dt> {@link #POWER_SERVICE} ("power")
 *  <dd> A {@link android.os.PowerManager} for controlling power
 *  management.
 *  <dt> {@link #ALARM_SERVICE} ("alarm")
 *  <dd> A {@link android.app.AlarmManager} for receiving intents at the
 *  time of your choosing.
 *  <dt> {@link #NOTIFICATION_SERVICE} ("notification")
 *  <dd> A {@link android.app.NotificationManager} for informing the user
 *   of background events.
 *  <dt> {@link #KEYGUARD_SERVICE} ("keyguard")
 *  <dd> A {@link android.app.KeyguardManager} for controlling keyguard.
 *  <dt> {@link #LOCATION_SERVICE} ("location")
 *  <dd> A {@link android.location.LocationManager} for controlling location
 *   (e.g., GPS) updates.
 *  <dt> {@link #SEARCH_SERVICE} ("search")
 *  <dd> A {@link android.app.SearchManager} for handling search.
 *  <dt> {@link #VIBRATOR_SERVICE} ("vibrator")
 *  <dd> A {@link android.os.Vibrator} for interacting with the vibrator
 *  hardware.
 *  <dt> {@link #CONNECTIVITY_SERVICE} ("connection")
 *  <dd> A {@link android.net.ConnectivityManager ConnectivityManager} for
 *  handling management of network connections.
 *  <dt> {@link #IPSEC_SERVICE} ("ipsec")
 *  <dd> A {@link android.net.IpSecManager IpSecManager} for managing IPSec on
 *  sockets and networks.
 *  <dt> {@link #WIFI_SERVICE} ("wifi")
 *  <dd> A {@link android.net.wifi.WifiManager WifiManager} for management of Wi-Fi
 *  connectivity.  On releases before NYC, it should only be obtained from an application
 *  context, and not from any other derived context to avoid memory leaks within the calling
 *  process.
 *  <dt> {@link #WIFI_AWARE_SERVICE} ("wifiaware")
 *  <dd> A {@link android.net.wifi.aware.WifiAwareManager WifiAwareManager} for management of
 * Wi-Fi Aware discovery and connectivity.
 *  <dt> {@link #WIFI_P2P_SERVICE} ("wifip2p")
 *  <dd> A {@link android.net.wifi.p2p.WifiP2pManager WifiP2pManager} for management of
 * Wi-Fi Direct connectivity.
 * <dt> {@link #INPUT_METHOD_SERVICE} ("input_method")
 * <dd> An {@link android.view.inputmethod.InputMethodManager InputMethodManager}
 * for management of input methods.
 * <dt> {@link #UI_MODE_SERVICE} ("uimode")
 * <dd> An {@link android.app.UiModeManager} for controlling UI modes.
 * <dt> {@link #DOWNLOAD_SERVICE} ("download")
 * <dd> A {@link android.app.DownloadManager} for requesting HTTP downloads
 * <dt> {@link #BATTERY_SERVICE} ("batterymanager")
 * <dd> A {@link android.os.BatteryManager} for managing battery state
 * <dt> {@link #JOB_SCHEDULER_SERVICE} ("taskmanager")
 * <dd>  A {@link android.app.job.JobScheduler} for managing scheduled tasks
 * <dt> {@link #NETWORK_STATS_SERVICE} ("netstats")
 * <dd> A {@link android.app.usage.NetworkStatsManager NetworkStatsManager} for querying network
 * usage statistics.
 * <dt> {@link #HARDWARE_PROPERTIES_SERVICE} ("hardware_properties")
 * <dd> A {@link android.os.HardwarePropertiesManager} for accessing hardware properties.
 * </dl>
 *
 * <p>Note:  System services obtained via this API may be closely associated with
 * the Context in which they are obtained from.  In general, do not share the
 * service objects between various different contexts (Activities, Applications,
 * Services, Providers, etc.)
 *
 * <p>Note: Instant apps, for which {@link android.content.pm.PackageManager#isInstantApp() PackageManager#isInstantApp()} returns true,
 * don't have access to the following system services: {@link #DEVICE_POLICY_SERVICE},
 * {@link #FINGERPRINT_SERVICE}, {@link #KEYGUARD_SERVICE}, {@link #SHORTCUT_SERVICE},
 * {@link #USB_SERVICE}, {@link #WALLPAPER_SERVICE}, {@link #WIFI_P2P_SERVICE},
 * {@link #WIFI_SERVICE}, {@link #WIFI_AWARE_SERVICE}. For these services this method will
 * return <code>null</code>.  Generally, if you are running as an instant app you should always
 * check whether the result of this method is {@code null}.
 *
 * <p>Note: When implementing this method, keep in mind that new services can be added on newer
 * Android releases, so if you're looking for just the explicit names mentioned above, make sure
 * to return {@code null} when you don't recognize the name &mdash; if you throw a
 * {@link java.lang.RuntimeException RuntimeException} exception instead, you're app might break on new Android releases.
 *
 * @param name The name of the desired service.
 *
 * Value is {@link android.content.Context#POWER_SERVICE}, {@link android.content.Context#WINDOW_SERVICE}, {@link android.content.Context#LAYOUT_INFLATER_SERVICE}, {@link android.content.Context#ACCOUNT_SERVICE}, {@link android.content.Context#ACTIVITY_SERVICE}, {@link android.content.Context#ALARM_SERVICE}, {@link android.content.Context#NOTIFICATION_SERVICE}, {@link android.content.Context#ACCESSIBILITY_SERVICE}, {@link android.content.Context#CAPTIONING_SERVICE}, {@link android.content.Context#KEYGUARD_SERVICE}, {@link android.content.Context#LOCATION_SERVICE}, {@link android.content.Context#SEARCH_SERVICE}, {@link android.content.Context#SENSOR_SERVICE}, android.content.Context.SENSOR_PRIVACY_SERVICE, {@link android.content.Context#STORAGE_SERVICE}, {@link android.content.Context#STORAGE_STATS_SERVICE}, {@link android.content.Context#WALLPAPER_SERVICE}, android.content.Context.TIME_ZONE_RULES_MANAGER_SERVICE, {@link android.content.Context#VIBRATOR_SERVICE}, {@link android.content.Context#CONNECTIVITY_SERVICE}, {@link android.content.Context#IPSEC_SERVICE}, android.content.Context.TEST_NETWORK_SERVICE, {@link android.content.Context#NETWORK_STATS_SERVICE}, {@link android.content.Context#WIFI_SERVICE}, {@link android.content.Context#WIFI_AWARE_SERVICE}, {@link android.content.Context#WIFI_P2P_SERVICE}, android.content.Context.WIFI_SCANNING_SERVICE, {@link android.content.Context#WIFI_RTT_RANGING_SERVICE}, {@link android.content.Context#NSD_SERVICE}, {@link android.content.Context#AUDIO_SERVICE}, {@link android.content.Context#FINGERPRINT_SERVICE}, {@link android.content.Context#BIOMETRIC_SERVICE}, {@link android.content.Context#MEDIA_ROUTER_SERVICE}, {@link android.content.Context#TELEPHONY_SERVICE}, {@link android.content.Context#TELEPHONY_SUBSCRIPTION_SERVICE}, {@link android.content.Context#CARRIER_CONFIG_SERVICE}, {@link android.content.Context#EUICC_SERVICE}, {@link android.content.Context#TELECOM_SERVICE}, {@link android.content.Context#CLIPBOARD_SERVICE}, {@link android.content.Context#INPUT_METHOD_SERVICE}, {@link android.content.Context#TEXT_SERVICES_MANAGER_SERVICE}, {@link android.content.Context#TEXT_CLASSIFICATION_SERVICE}, {@link android.content.Context#APPWIDGET_SERVICE}, android.content.Context.ROLLBACK_SERVICE, {@link android.content.Context#DROPBOX_SERVICE}, {@link android.content.Context#DEVICE_POLICY_SERVICE}, {@link android.content.Context#UI_MODE_SERVICE}, {@link android.content.Context#DOWNLOAD_SERVICE}, {@link android.content.Context#NFC_SERVICE}, {@link android.content.Context#BLUETOOTH_SERVICE}, {@link android.content.Context#USB_SERVICE}, {@link android.content.Context#LAUNCHER_APPS_SERVICE}, {@link android.content.Context#INPUT_SERVICE}, {@link android.content.Context#DISPLAY_SERVICE}, {@link android.content.Context#USER_SERVICE}, {@link android.content.Context#RESTRICTIONS_SERVICE}, {@link android.content.Context#APP_OPS_SERVICE}, {@link android.content.Context#ROLE_SERVICE}, {@link android.content.Context#CAMERA_SERVICE}, {@link android.content.Context#PRINT_SERVICE}, {@link android.content.Context#CONSUMER_IR_SERVICE}, {@link android.content.Context#TV_INPUT_SERVICE}, {@link android.content.Context#USAGE_STATS_SERVICE}, {@link android.content.Context#MEDIA_SESSION_SERVICE}, {@link android.content.Context#BATTERY_SERVICE}, {@link android.content.Context#JOB_SCHEDULER_SERVICE}, {@link android.content.Context#MEDIA_PROJECTION_SERVICE}, {@link android.content.Context#MIDI_SERVICE}, android.content.Context.RADIO_SERVICE, {@link android.content.Context#HARDWARE_PROPERTIES_SERVICE}, {@link android.content.Context#SHORTCUT_SERVICE}, {@link android.content.Context#SYSTEM_HEALTH_SERVICE}, {@link android.content.Context#COMPANION_DEVICE_SERVICE}, {@link android.content.Context#CROSS_PROFILE_APPS_SERVICE}, or android.content.Context.PERMISSION_SERVICE
 * This value must never be {@code null}.
 * @return The service or {@code null} if the name does not exist.
 *
 * @see #WINDOW_SERVICE
 * @see android.view.WindowManager
 * @see #LAYOUT_INFLATER_SERVICE
 * @see android.view.LayoutInflater
 * @see #ACTIVITY_SERVICE
 * @see android.app.ActivityManager
 * @see #POWER_SERVICE
 * @see android.os.PowerManager
 * @see #ALARM_SERVICE
 * @see android.app.AlarmManager
 * @see #NOTIFICATION_SERVICE
 * @see android.app.NotificationManager
 * @see #KEYGUARD_SERVICE
 * @see android.app.KeyguardManager
 * @see #LOCATION_SERVICE
 * @see android.location.LocationManager
 * @see #SEARCH_SERVICE
 * @see android.app.SearchManager
 * @see #SENSOR_SERVICE
 * @see android.hardware.SensorManager
 * @see #STORAGE_SERVICE
 * @see android.os.storage.StorageManager
 * @see #VIBRATOR_SERVICE
 * @see android.os.Vibrator
 * @see #CONNECTIVITY_SERVICE
 * @see android.net.ConnectivityManager
 * @see #WIFI_SERVICE
 * @see android.net.wifi.WifiManager
 * @see #AUDIO_SERVICE
 * @see android.media.AudioManager
 * @see #MEDIA_ROUTER_SERVICE
 * @see android.media.MediaRouter
 * @see #TELEPHONY_SERVICE
 * @see android.telephony.TelephonyManager
 * @see #TELEPHONY_SUBSCRIPTION_SERVICE
 * @see android.telephony.SubscriptionManager
 * @see #CARRIER_CONFIG_SERVICE
 * @see android.telephony.CarrierConfigManager
 * @see #EUICC_SERVICE
 * @see android.telephony.euicc.EuiccManager
 * @see #INPUT_METHOD_SERVICE
 * @see android.view.inputmethod.InputMethodManager
 * @see #UI_MODE_SERVICE
 * @see android.app.UiModeManager
 * @see #DOWNLOAD_SERVICE
 * @see android.app.DownloadManager
 * @see #BATTERY_SERVICE
 * @see android.os.BatteryManager
 * @see #JOB_SCHEDULER_SERVICE
 * @see android.app.job.JobScheduler
 * @see #NETWORK_STATS_SERVICE
 * @see android.app.usage.NetworkStatsManager
 * @see android.os.HardwarePropertiesManager
 * @see #HARDWARE_PROPERTIES_SERVICE
 * @apiSince 1
 */

public abstract java.lang.Object getSystemService(@androidx.annotation.NonNull java.lang.String name);

/**
 * Return the handle to a system-level service by class.
 * <p>
 * Currently available classes are:
 * {@link android.view.WindowManager}, {@link android.view.LayoutInflater},
 * {@link android.app.ActivityManager}, {@link android.os.PowerManager},
 * {@link android.app.AlarmManager}, {@link android.app.NotificationManager},
 * {@link android.app.KeyguardManager}, {@link android.location.LocationManager},
 * {@link android.app.SearchManager}, {@link android.os.Vibrator},
 * {@link android.net.ConnectivityManager},
 * {@link android.net.wifi.WifiManager},
 * {@link android.media.AudioManager}, {@link android.media.MediaRouter},
 * {@link android.telephony.TelephonyManager}, {@link android.telephony.SubscriptionManager},
 * {@link android.view.inputmethod.InputMethodManager},
 * {@link android.app.UiModeManager}, {@link android.app.DownloadManager},
 * {@link android.os.BatteryManager}, {@link android.app.job.JobScheduler},
 * {@link android.app.usage.NetworkStatsManager}.
 * </p>
 *
 * <p>
 * Note: System services obtained via this API may be closely associated with
 * the Context in which they are obtained from.  In general, do not share the
 * service objects between various different contexts (Activities, Applications,
 * Services, Providers, etc.)
 * </p>
 *
 * <p>Note: Instant apps, for which {@link android.content.pm.PackageManager#isInstantApp() PackageManager#isInstantApp()} returns true,
 * don't have access to the following system services: {@link #DEVICE_POLICY_SERVICE},
 * {@link #FINGERPRINT_SERVICE}, {@link #KEYGUARD_SERVICE}, {@link #SHORTCUT_SERVICE},
 * {@link #USB_SERVICE}, {@link #WALLPAPER_SERVICE}, {@link #WIFI_P2P_SERVICE},
 * {@link #WIFI_SERVICE}, {@link #WIFI_AWARE_SERVICE}. For these services this method will
 * return {@code null}. Generally, if you are running as an instant app you should always
 * check whether the result of this method is {@code null}.
 * </p>
 *
 * @param serviceClass The class of the desired service.
 * This value must never be {@code null}.
 * @return The service or {@code null} if the class is not a supported system service. Note:
 * <b>never</b> throw a {@link java.lang.RuntimeException RuntimeException} if the name is not supported.
 * @apiSince 23
 */

public final <T> T getSystemService(@androidx.annotation.NonNull java.lang.Class<T> serviceClass) { throw new RuntimeException("Stub!"); }

/**
 * Gets the name of the system-level service that is represented by the specified class.
 *
 * @param serviceClass The class of the desired service.
 * This value must never be {@code null}.
 * @return The service name or null if the class is not a supported system service.
 * @apiSince 23
 */

@androidx.annotation.Nullable
public abstract java.lang.String getSystemServiceName(@androidx.annotation.NonNull java.lang.Class<?> serviceClass);

/**
 * Determine whether the given permission is allowed for a particular
 * process and user ID running in the system.
 *
 * @param permission The name of the permission being checked.
 * This value must never be {@code null}.
 * @param pid The process ID being checked against.  Must be > 0.
 * @param uid The user ID being checked against.  A uid of 0 is the root
 * user, which will pass every permission check.
 *
 * @return {@link android.content.pm.PackageManager#PERMISSION_GRANTED PackageManager#PERMISSION_GRANTED} if the given
 * pid/uid is allowed that permission, or
 * {@link android.content.pm.PackageManager#PERMISSION_DENIED PackageManager#PERMISSION_DENIED} if it is not.
 *
 * Value is {@link android.content.pm.PackageManager#PERMISSION_GRANTED}, or {@link android.content.pm.PackageManager#PERMISSION_DENIED}
 * @see android.content.pm.PackageManager#checkPermission(String, String)
 * @see #checkCallingPermission
 * @apiSince 1
 */

public abstract int checkPermission(@androidx.annotation.NonNull java.lang.String permission, int pid, int uid);

/**
 * Determine whether the calling process of an IPC you are handling has been
 * granted a particular permission.  This is basically the same as calling
 * {@link #checkPermission(java.lang.String,int,int)} with the pid and uid returned
 * by {@link android.os.Binder#getCallingPid} and
 * {@link android.os.Binder#getCallingUid}.  One important difference
 * is that if you are not currently processing an IPC, this function
 * will always fail.  This is done to protect against accidentally
 * leaking permissions; you can use {@link #checkCallingOrSelfPermission}
 * to avoid this protection.
 *
 * @param permission The name of the permission being checked.
 *
 * This value must never be {@code null}.
 * @return {@link android.content.pm.PackageManager#PERMISSION_GRANTED PackageManager#PERMISSION_GRANTED} if the calling
 * pid/uid is allowed that permission, or
 * {@link android.content.pm.PackageManager#PERMISSION_DENIED PackageManager#PERMISSION_DENIED} if it is not.
 *
 * Value is {@link android.content.pm.PackageManager#PERMISSION_GRANTED}, or {@link android.content.pm.PackageManager#PERMISSION_DENIED}
 * @see android.content.pm.PackageManager#checkPermission(String, String)
 * @see #checkPermission
 * @see #checkCallingOrSelfPermission
 * @apiSince 1
 */

public abstract int checkCallingPermission(@androidx.annotation.NonNull java.lang.String permission);

/**
 * Determine whether the calling process of an IPC <em>or you</em> have been
 * granted a particular permission.  This is the same as
 * {@link #checkCallingPermission}, except it grants your own permissions
 * if you are not currently processing an IPC.  Use with care!
 *
 * @param permission The name of the permission being checked.
 *
 * This value must never be {@code null}.
 * @return {@link android.content.pm.PackageManager#PERMISSION_GRANTED PackageManager#PERMISSION_GRANTED} if the calling
 * pid/uid is allowed that permission, or
 * {@link android.content.pm.PackageManager#PERMISSION_DENIED PackageManager#PERMISSION_DENIED} if it is not.
 *
 * Value is {@link android.content.pm.PackageManager#PERMISSION_GRANTED}, or {@link android.content.pm.PackageManager#PERMISSION_DENIED}
 * @see android.content.pm.PackageManager#checkPermission(String, String)
 * @see #checkPermission
 * @see #checkCallingPermission
 * @apiSince 1
 */

public abstract int checkCallingOrSelfPermission(@androidx.annotation.NonNull java.lang.String permission);

/**
 * Determine whether <em>you</em> have been granted a particular permission.
 *
 * @param permission The name of the permission being checked.
 *
 * This value must never be {@code null}.
 * @return {@link android.content.pm.PackageManager#PERMISSION_GRANTED PackageManager#PERMISSION_GRANTED} if you have the
 * permission, or {@link android.content.pm.PackageManager#PERMISSION_DENIED PackageManager#PERMISSION_DENIED} if not.
 *
 * Value is {@link android.content.pm.PackageManager#PERMISSION_GRANTED}, or {@link android.content.pm.PackageManager#PERMISSION_DENIED}
 * @see android.content.pm.PackageManager#checkPermission(String, String)
 * @see #checkCallingPermission(String)
 * @apiSince 23
 */

public abstract int checkSelfPermission(@androidx.annotation.NonNull java.lang.String permission);

/**
 * If the given permission is not allowed for a particular process
 * and user ID running in the system, throw a {@link java.lang.SecurityException SecurityException}.
 *
 * @param permission The name of the permission being checked.
 * This value must never be {@code null}.
 * @param pid The process ID being checked against.  Must be &gt; 0.
 * @param uid The user ID being checked against.  A uid of 0 is the root
 * user, which will pass every permission check.
 * @param message A message to include in the exception if it is thrown.
 *
 * This value may be {@code null}.
 * @see #checkPermission(String, int, int)
 * @apiSince 1
 */

public abstract void enforcePermission(@androidx.annotation.NonNull java.lang.String permission, int pid, int uid, @androidx.annotation.Nullable java.lang.String message);

/**
 * If the calling process of an IPC you are handling has not been
 * granted a particular permission, throw a {@link java.lang.SecurityException SecurityException}.  This is basically the same as calling
 * {@link #enforcePermission(java.lang.String,int,int,java.lang.String)} with the
 * pid and uid returned by {@link android.os.Binder#getCallingPid}
 * and {@link android.os.Binder#getCallingUid}.  One important
 * difference is that if you are not currently processing an IPC,
 * this function will always throw the SecurityException.  This is
 * done to protect against accidentally leaking permissions; you
 * can use {@link #enforceCallingOrSelfPermission} to avoid this
 * protection.
 *
 * @param permission The name of the permission being checked.
 * This value must never be {@code null}.
 * @param message A message to include in the exception if it is thrown.
 *
 * This value may be {@code null}.
 * @see #checkCallingPermission(String)
 * @apiSince 1
 */

public abstract void enforceCallingPermission(@androidx.annotation.NonNull java.lang.String permission, @androidx.annotation.Nullable java.lang.String message);

/**
 * If neither you nor the calling process of an IPC you are
 * handling has been granted a particular permission, throw a
 * {@link java.lang.SecurityException SecurityException}.  This is the same as {@link
 * #enforceCallingPermission}, except it grants your own
 * permissions if you are not currently processing an IPC.  Use
 * with care!
 *
 * @param permission The name of the permission being checked.
 * This value must never be {@code null}.
 * @param message A message to include in the exception if it is thrown.
 *
 * This value may be {@code null}.
 * @see #checkCallingOrSelfPermission(String)
 * @apiSince 1
 */

public abstract void enforceCallingOrSelfPermission(@androidx.annotation.NonNull java.lang.String permission, @androidx.annotation.Nullable java.lang.String message);

/**
 * Grant permission to access a specific Uri to another package, regardless
 * of whether that package has general permission to access the Uri's
 * content provider.  This can be used to grant specific, temporary
 * permissions, typically in response to user interaction (such as the
 * user opening an attachment that you would like someone else to
 * display).
 *
 * <p>Normally you should use {@link android.content.Intent#FLAG_GRANT_READ_URI_PERMISSION Intent#FLAG_GRANT_READ_URI_PERMISSION} or
 * {@link android.content.Intent#FLAG_GRANT_WRITE_URI_PERMISSION Intent#FLAG_GRANT_WRITE_URI_PERMISSION} with the Intent being used to
 * start an activity instead of this function directly.  If you use this
 * function directly, you should be sure to call
 * {@link #revokeUriPermission} when the target should no longer be allowed
 * to access it.
 *
 * <p>To succeed, the content provider owning the Uri must have set the
 * {@link android.R.styleable#AndroidManifestProvider_grantUriPermissions
 * grantUriPermissions} attribute in its manifest or included the
 * {@link android.R.styleable#AndroidManifestGrantUriPermission
 * &lt;grant-uri-permissions&gt;} tag.
 *
 * @param toPackage The package you would like to allow to access the Uri.
 * @param uri The Uri you would like to grant access to.
 * @param modeFlags The desired access modes.
 *
 * Value is either <code>0</code> or a combination of {@link android.content.Intent#FLAG_GRANT_READ_URI_PERMISSION}, {@link android.content.Intent#FLAG_GRANT_WRITE_URI_PERMISSION}, {@link android.content.Intent#FLAG_GRANT_PERSISTABLE_URI_PERMISSION}, and {@link android.content.Intent#FLAG_GRANT_PREFIX_URI_PERMISSION}
 * @see #revokeUriPermission
 * @apiSince 1
 */

public abstract void grantUriPermission(java.lang.String toPackage, android.net.Uri uri, int modeFlags);

/**
 * Remove all permissions to access a particular content provider Uri
 * that were previously added with {@link #grantUriPermission} or <em>any other</em> mechanism.
 * The given Uri will match all previously granted Uris that are the same or a
 * sub-path of the given Uri.  That is, revoking "content://foo/target" will
 * revoke both "content://foo/target" and "content://foo/target/sub", but not
 * "content://foo".  It will not remove any prefix grants that exist at a
 * higher level.
 *
 * <p>Prior to {@link android.os.Build.VERSION_CODES#LOLLIPOP}, if you did not have
 * regular permission access to a Uri, but had received access to it through
 * a specific Uri permission grant, you could not revoke that grant with this
 * function and a {@link java.lang.SecurityException SecurityException} would be thrown.  As of
 * {@link android.os.Build.VERSION_CODES#LOLLIPOP}, this function will not throw a security
 * exception, but will remove whatever permission grants to the Uri had been given to the app
 * (or none).</p>
 *
 * <p>Unlike {@link #revokeUriPermission(java.lang.String,android.net.Uri,int)}, this method impacts all permission
 * grants matching the given Uri, for any package they had been granted to, through any
 * mechanism this had happened (such as indirectly through the clipboard, activity launch,
 * service start, etc).  That means this can be potentially dangerous to use, as it can
 * revoke grants that another app could be strongly expecting to stick around.</p>
 *
 * @param uri The Uri you would like to revoke access to.
 * @param modeFlags The access modes to revoke.
 *
 * Value is either <code>0</code> or a combination of {@link android.content.Intent#FLAG_GRANT_READ_URI_PERMISSION}, and {@link android.content.Intent#FLAG_GRANT_WRITE_URI_PERMISSION}
 * @see #grantUriPermission
 * @apiSince 1
 */

public abstract void revokeUriPermission(android.net.Uri uri, int modeFlags);

/**
 * Remove permissions to access a particular content provider Uri
 * that were previously added with {@link #grantUriPermission} for a specific target
 * package.  The given Uri will match all previously granted Uris that are the same or a
 * sub-path of the given Uri.  That is, revoking "content://foo/target" will
 * revoke both "content://foo/target" and "content://foo/target/sub", but not
 * "content://foo".  It will not remove any prefix grants that exist at a
 * higher level.
 *
 * <p>Unlike {@link #revokeUriPermission(android.net.Uri,int)}, this method will <em>only</em>
 * revoke permissions that had been explicitly granted through {@link #grantUriPermission}
 * and only for the package specified.  Any matching grants that have happened through
 * other mechanisms (clipboard, activity launching, service starting, etc) will not be
 * removed.</p>
 *
 * @param toPackage The package you had previously granted access to.
 * @param uri The Uri you would like to revoke access to.
 * @param modeFlags The access modes to revoke.
 *
 * Value is either <code>0</code> or a combination of {@link android.content.Intent#FLAG_GRANT_READ_URI_PERMISSION}, and {@link android.content.Intent#FLAG_GRANT_WRITE_URI_PERMISSION}
 * @see #grantUriPermission
 * @apiSince 26
 */

public abstract void revokeUriPermission(java.lang.String toPackage, android.net.Uri uri, int modeFlags);

/**
 * Determine whether a particular process and user ID has been granted
 * permission to access a specific URI.  This only checks for permissions
 * that have been explicitly granted -- if the given process/uid has
 * more general access to the URI's content provider then this check will
 * always fail.
 *
 * @param uri The uri that is being checked.
 * @param pid The process ID being checked against.  Must be &gt; 0.
 * @param uid The user ID being checked against.  A uid of 0 is the root
 * user, which will pass every permission check.
 * @param modeFlags The access modes to check.
 *
 * Value is either <code>0</code> or a combination of {@link android.content.Intent#FLAG_GRANT_READ_URI_PERMISSION}, and {@link android.content.Intent#FLAG_GRANT_WRITE_URI_PERMISSION}
 * @return {@link android.content.pm.PackageManager#PERMISSION_GRANTED PackageManager#PERMISSION_GRANTED} if the given
 * pid/uid is allowed to access that uri, or
 * {@link android.content.pm.PackageManager#PERMISSION_DENIED PackageManager#PERMISSION_DENIED} if it is not.
 *
 * Value is {@link android.content.pm.PackageManager#PERMISSION_GRANTED}, or {@link android.content.pm.PackageManager#PERMISSION_DENIED}
 * @see #checkCallingUriPermission
 * @apiSince 1
 */

public abstract int checkUriPermission(android.net.Uri uri, int pid, int uid, int modeFlags);

/**
 * Determine whether the calling process and user ID has been
 * granted permission to access a specific URI.  This is basically
 * the same as calling {@link #checkUriPermission(android.net.Uri,int,int,int)} with the pid and uid returned by {@link
 * android.os.Binder#getCallingPid} and {@link
 * android.os.Binder#getCallingUid}.  One important difference is
 * that if you are not currently processing an IPC, this function
 * will always fail.
 *
 * @param uri The uri that is being checked.
 * @param modeFlags The access modes to check.
 *
 * Value is either <code>0</code> or a combination of {@link android.content.Intent#FLAG_GRANT_READ_URI_PERMISSION}, and {@link android.content.Intent#FLAG_GRANT_WRITE_URI_PERMISSION}
 * @return {@link android.content.pm.PackageManager#PERMISSION_GRANTED PackageManager#PERMISSION_GRANTED} if the caller
 * is allowed to access that uri, or
 * {@link android.content.pm.PackageManager#PERMISSION_DENIED PackageManager#PERMISSION_DENIED} if it is not.
 *
 * Value is {@link android.content.pm.PackageManager#PERMISSION_GRANTED}, or {@link android.content.pm.PackageManager#PERMISSION_DENIED}
 * @see #checkUriPermission(Uri, int, int, int)
 * @apiSince 1
 */

public abstract int checkCallingUriPermission(android.net.Uri uri, int modeFlags);

/**
 * Determine whether the calling process of an IPC <em>or you</em> has been granted
 * permission to access a specific URI.  This is the same as
 * {@link #checkCallingUriPermission}, except it grants your own permissions
 * if you are not currently processing an IPC.  Use with care!
 *
 * @param uri The uri that is being checked.
 * @param modeFlags The access modes to check.
 *
 * Value is either <code>0</code> or a combination of {@link android.content.Intent#FLAG_GRANT_READ_URI_PERMISSION}, and {@link android.content.Intent#FLAG_GRANT_WRITE_URI_PERMISSION}
 * @return {@link android.content.pm.PackageManager#PERMISSION_GRANTED PackageManager#PERMISSION_GRANTED} if the caller
 * is allowed to access that uri, or
 * {@link android.content.pm.PackageManager#PERMISSION_DENIED PackageManager#PERMISSION_DENIED} if it is not.
 *
 * Value is {@link android.content.pm.PackageManager#PERMISSION_GRANTED}, or {@link android.content.pm.PackageManager#PERMISSION_DENIED}
 * @see #checkCallingUriPermission
 * @apiSince 1
 */

public abstract int checkCallingOrSelfUriPermission(android.net.Uri uri, int modeFlags);

/**
 * Check both a Uri and normal permission.  This allows you to perform
 * both {@link #checkPermission} and {@link #checkUriPermission} in one
 * call.
 *
 * @param uri The Uri whose permission is to be checked, or null to not
 * do this check.
 * This value may be {@code null}.
 * @param readPermission The permission that provides overall read access,
 * or null to not do this check.
 * This value may be {@code null}.
 * @param writePermission The permission that provides overall write
 * access, or null to not do this check.
 * This value may be {@code null}.
 * @param pid The process ID being checked against.  Must be &gt; 0.
 * @param uid The user ID being checked against.  A uid of 0 is the root
 * user, which will pass every permission check.
 * @param modeFlags The access modes to check.
 *
 * Value is either <code>0</code> or a combination of {@link android.content.Intent#FLAG_GRANT_READ_URI_PERMISSION}, and {@link android.content.Intent#FLAG_GRANT_WRITE_URI_PERMISSION}
 * @return {@link android.content.pm.PackageManager#PERMISSION_GRANTED PackageManager#PERMISSION_GRANTED} if the caller
 * is allowed to access that uri or holds one of the given permissions, or
 * {@link android.content.pm.PackageManager#PERMISSION_DENIED PackageManager#PERMISSION_DENIED} if it is not.
 
 * Value is {@link android.content.pm.PackageManager#PERMISSION_GRANTED}, or {@link android.content.pm.PackageManager#PERMISSION_DENIED}
 * @apiSince 1
 */

public abstract int checkUriPermission(@androidx.annotation.Nullable android.net.Uri uri, @androidx.annotation.Nullable java.lang.String readPermission, @androidx.annotation.Nullable java.lang.String writePermission, int pid, int uid, int modeFlags);

/**
 * If a particular process and user ID has not been granted
 * permission to access a specific URI, throw {@link java.lang.SecurityException SecurityException}.  This only checks for permissions that have
 * been explicitly granted -- if the given process/uid has more
 * general access to the URI's content provider then this check
 * will always fail.
 *
 * @param uri The uri that is being checked.
 * @param pid The process ID being checked against.  Must be &gt; 0.
 * @param uid The user ID being checked against.  A uid of 0 is the root
 * user, which will pass every permission check.
 * @param modeFlags The access modes to enforce.
 * Value is either <code>0</code> or a combination of {@link android.content.Intent#FLAG_GRANT_READ_URI_PERMISSION}, and {@link android.content.Intent#FLAG_GRANT_WRITE_URI_PERMISSION}
 * @param message A message to include in the exception if it is thrown.
 *
 * @see #checkUriPermission(Uri, int, int, int)
 * @apiSince 1
 */

public abstract void enforceUriPermission(android.net.Uri uri, int pid, int uid, int modeFlags, java.lang.String message);

/**
 * If the calling process and user ID has not been granted
 * permission to access a specific URI, throw {@link java.lang.SecurityException SecurityException}.  This is basically the same as calling
 * {@link #enforceUriPermission(android.net.Uri,int,int,int,java.lang.String)} with
 * the pid and uid returned by {@link
 * android.os.Binder#getCallingPid} and {@link
 * android.os.Binder#getCallingUid}.  One important difference is
 * that if you are not currently processing an IPC, this function
 * will always throw a SecurityException.
 *
 * @param uri The uri that is being checked.
 * @param modeFlags The access modes to enforce.
 * Value is either <code>0</code> or a combination of {@link android.content.Intent#FLAG_GRANT_READ_URI_PERMISSION}, and {@link android.content.Intent#FLAG_GRANT_WRITE_URI_PERMISSION}
 * @param message A message to include in the exception if it is thrown.
 *
 * @see #checkCallingUriPermission(Uri, int)
 * @apiSince 1
 */

public abstract void enforceCallingUriPermission(android.net.Uri uri, int modeFlags, java.lang.String message);

/**
 * If the calling process of an IPC <em>or you</em> has not been
 * granted permission to access a specific URI, throw {@link java.lang.SecurityException SecurityException}.  This is the same as {@link
 * #enforceCallingUriPermission}, except it grants your own
 * permissions if you are not currently processing an IPC.  Use
 * with care!
 *
 * @param uri The uri that is being checked.
 * @param modeFlags The access modes to enforce.
 * Value is either <code>0</code> or a combination of {@link android.content.Intent#FLAG_GRANT_READ_URI_PERMISSION}, and {@link android.content.Intent#FLAG_GRANT_WRITE_URI_PERMISSION}
 * @param message A message to include in the exception if it is thrown.
 *
 * @see #checkCallingOrSelfUriPermission(Uri, int)
 * @apiSince 1
 */

public abstract void enforceCallingOrSelfUriPermission(android.net.Uri uri, int modeFlags, java.lang.String message);

/**
 * Enforce both a Uri and normal permission.  This allows you to perform
 * both {@link #enforcePermission} and {@link #enforceUriPermission} in one
 * call.
 *
 * @param uri The Uri whose permission is to be checked, or null to not
 * do this check.
 * This value may be {@code null}.
 * @param readPermission The permission that provides overall read access,
 * or null to not do this check.
 * This value may be {@code null}.
 * @param writePermission The permission that provides overall write
 * access, or null to not do this check.
 * This value may be {@code null}.
 * @param pid The process ID being checked against.  Must be &gt; 0.
 * @param uid The user ID being checked against.  A uid of 0 is the root
 * user, which will pass every permission check.
 * @param modeFlags The access modes to enforce.
 * Value is either <code>0</code> or a combination of {@link android.content.Intent#FLAG_GRANT_READ_URI_PERMISSION}, and {@link android.content.Intent#FLAG_GRANT_WRITE_URI_PERMISSION}
 * @param message A message to include in the exception if it is thrown.
 *
 * This value may be {@code null}.
 * @see #checkUriPermission(Uri, String, String, int, int, int)
 * @apiSince 1
 */

public abstract void enforceUriPermission(@androidx.annotation.Nullable android.net.Uri uri, @androidx.annotation.Nullable java.lang.String readPermission, @androidx.annotation.Nullable java.lang.String writePermission, int pid, int uid, int modeFlags, @androidx.annotation.Nullable java.lang.String message);

/**
 * Return a new Context object for the given application name.  This
 * Context is the same as what the named application gets when it is
 * launched, containing the same resources and class loader.  Each call to
 * this method returns a new instance of a Context object; Context objects
 * are not shared, however they share common state (Resources, ClassLoader,
 * etc) so the Context instance itself is fairly lightweight.
 *
 * <p>Throws {@link android.content.pm.PackageManager.NameNotFoundException} if there is no
 * application with the given package name.
 *
 * <p>Throws {@link java.lang.SecurityException} if the Context requested
 * can not be loaded into the caller's process for security reasons (see
 * {@link #CONTEXT_INCLUDE_CODE} for more information}.
 *
 * @param packageName Name of the application's package.
 * @param flags Option flags.
 *
 * Value is either <code>0</code> or a combination of {@link android.content.Context#CONTEXT_INCLUDE_CODE}, {@link android.content.Context#CONTEXT_IGNORE_SECURITY}, {@link android.content.Context#CONTEXT_RESTRICTED}, android.content.Context.CONTEXT_DEVICE_PROTECTED_STORAGE, android.content.Context.CONTEXT_CREDENTIAL_PROTECTED_STORAGE, and android.content.Context.CONTEXT_REGISTER_PACKAGE
 * @return A {@link android.content.Context Context} for the application.
 *
 * @throws java.lang.SecurityException &nbsp;
 * @throws android.content.pm.PackageManager.NameNotFoundException if there is no application with
 * the given package name.
 * @apiSince 1
 */

public abstract android.content.Context createPackageContext(java.lang.String packageName, int flags) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Return a new Context object for the given split name. The new Context has a ClassLoader and
 * Resources object that can access the split's and all of its dependencies' code/resources.
 * Each call to this method returns a new instance of a Context object;
 * Context objects are not shared, however common state (ClassLoader, other Resources for
 * the same split) may be so the Context itself can be fairly lightweight.
 *
 * @param splitName The name of the split to include, as declared in the split's
 *                  <code>AndroidManifest.xml</code>.
 * @return A {@link android.content.Context Context} with the given split's code and/or resources loaded.
 * @apiSince 26
 */

public abstract android.content.Context createContextForSplit(java.lang.String splitName) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Return a new Context object for the current Context but whose resources
 * are adjusted to match the given Configuration.  Each call to this method
 * returns a new instance of a Context object; Context objects are not
 * shared, however common state (ClassLoader, other Resources for the
 * same configuration) may be so the Context itself can be fairly lightweight.
 *
 * @param overrideConfiguration A {@link android.content.res.Configuration Configuration} specifying what
 * values to modify in the base Configuration of the original Context's
 * resources.  If the base configuration changes (such as due to an
 * orientation change), the resources of this context will also change except
 * for those that have been explicitly overridden with a value here.
 *
 * This value must never be {@code null}.
 * @return A {@link android.content.Context Context} with the given configuration override.
 * @apiSince 17
 */

public abstract android.content.Context createConfigurationContext(@androidx.annotation.NonNull android.content.res.Configuration overrideConfiguration);

/**
 * Return a new Context object for the current Context but whose resources
 * are adjusted to match the metrics of the given Display.  Each call to this method
 * returns a new instance of a Context object; Context objects are not
 * shared, however common state (ClassLoader, other Resources for the
 * same configuration) may be so the Context itself can be fairly lightweight.
 *
 * The returned display Context provides a {@link android.view.WindowManager WindowManager}
 * (see {@link #getSystemService(java.lang.String)}) that is configured to show windows
 * on the given display.  The WindowManager's {@link android.view.WindowManager#getDefaultDisplay WindowManager#getDefaultDisplay}
 * method can be used to retrieve the Display from the returned Context.
 *
 * @param display A {@link android.view.Display Display} object specifying the display
 * for whose metrics the Context's resources should be tailored and upon which
 * new windows should be shown.
 *
 * This value must never be {@code null}.
 * @return A {@link android.content.Context Context} for the display.
 * @apiSince 17
 */

public abstract android.content.Context createDisplayContext(@androidx.annotation.NonNull android.view.Display display);

/**
 * Return a new Context object for the current Context but whose storage
 * APIs are backed by device-protected storage.
 * <p>
 * On devices with direct boot, data stored in this location is encrypted
 * with a key tied to the physical device, and it can be accessed
 * immediately after the device has booted successfully, both
 * <em>before and after</em> the user has authenticated with their
 * credentials (such as a lock pattern or PIN).
 * <p>
 * Because device-protected data is available without user authentication,
 * you should carefully limit the data you store using this Context. For
 * example, storing sensitive authentication tokens or passwords in the
 * device-protected area is strongly discouraged.
 * <p>
 * If the underlying device does not have the ability to store
 * device-protected and credential-protected data using different keys, then
 * both storage areas will become available at the same time. They remain as
 * two distinct storage locations on disk, and only the window of
 * availability changes.
 * <p>
 * Each call to this method returns a new instance of a Context object;
 * Context objects are not shared, however common state (ClassLoader, other
 * Resources for the same configuration) may be so the Context itself can be
 * fairly lightweight.
 *
 * @see #isDeviceProtectedStorage()
 * @apiSince 24
 */

public abstract android.content.Context createDeviceProtectedStorageContext();

/**
 * Indicates whether this Context is restricted.
 *
 * @return {@code true} if this Context is restricted, {@code false} otherwise.
 *
 * @see #CONTEXT_RESTRICTED
 * @apiSince 4
 */

public boolean isRestricted() { throw new RuntimeException("Stub!"); }

/**
 * Indicates if the storage APIs of this Context are backed by
 * device-protected storage.
 *
 * @see #createDeviceProtectedStorageContext()
 * @apiSince 24
 */

public abstract boolean isDeviceProtectedStorage();

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.view.accessibility.AccessibilityManager} for giving the user
 * feedback for UI events through the registered event listeners.
 *
 * @see #getSystemService(String)
 * @see android.view.accessibility.AccessibilityManager
 * @apiSince 4
 */

public static final java.lang.String ACCESSIBILITY_SERVICE = "accessibility";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.accounts.AccountManager} for receiving intents at a
 * time of your choosing.
 *
 * @see #getSystemService(String)
 * @see android.accounts.AccountManager
 * @apiSince 5
 */

public static final java.lang.String ACCOUNT_SERVICE = "account";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.app.ActivityManager} for interacting with the global
 * system state.
 *
 * @see #getSystemService(String)
 * @see android.app.ActivityManager
 * @apiSince 1
 */

public static final java.lang.String ACTIVITY_SERVICE = "activity";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.app.AlarmManager} for receiving intents at a
 * time of your choosing.
 *
 * @see #getSystemService(String)
 * @see android.app.AlarmManager
 * @apiSince 1
 */

public static final java.lang.String ALARM_SERVICE = "alarm";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.appwidget.AppWidgetManager} for accessing AppWidgets.
 *
 * @see #getSystemService(String)
 * @apiSince 21
 */

public static final java.lang.String APPWIDGET_SERVICE = "appwidget";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.app.AppOpsManager} for tracking application operations
 * on the device.
 *
 * @see #getSystemService(String)
 * @see android.app.AppOpsManager
 * @apiSince 19
 */

public static final java.lang.String APP_OPS_SERVICE = "appops";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.media.AudioManager} for handling management of volume,
 * ringer modes and audio routing.
 *
 * @see #getSystemService(String)
 * @see android.media.AudioManager
 * @apiSince 1
 */

public static final java.lang.String AUDIO_SERVICE = "audio";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.os.BatteryManager} for managing battery state.
 *
 * @see #getSystemService(String)
 * @apiSince 21
 */

public static final java.lang.String BATTERY_SERVICE = "batterymanager";

/**
 * Flag for {@link #bindService}: indicates that the client application
 * binding to this service considers the service to be more important than
 * the app itself.  When set, the platform will try to have the out of
 * memory killer kill the app before it kills the service it is bound to, though
 * this is not guaranteed to be the case.
 * @apiSince 14
 */

public static final int BIND_ABOVE_CLIENT = 8; // 0x8

/**
 * Flag for {@link #bindService}: If binding from an activity, allow the
 * target service's process importance to be raised based on whether the
 * activity is visible to the user, regardless whether another flag is
 * used to reduce the amount that the client process's overall importance
 * is used to impact it.
 * @apiSince 14
 */

public static final int BIND_ADJUST_WITH_ACTIVITY = 128; // 0x80

/**
 * Flag for {@link #bindService}: allow the process hosting the bound
 * service to go through its normal memory management.  It will be
 * treated more like a running service, allowing the system to
 * (temporarily) expunge the process if low on memory or for some other
 * whim it may have, and being more aggressive about making it a candidate
 * to be killed (and restarted) if running for a long time.
 * @apiSince 14
 */

public static final int BIND_ALLOW_OOM_MANAGEMENT = 16; // 0x10

/**
 * Flag for {@link #bindService}: automatically create the service as long
 * as the binding exists.  Note that while this will create the service,
 * its {@link android.app.Service#onStartCommand}
 * method will still only be called due to an
 * explicit call to {@link #startService}.  Even without that, though,
 * this still provides you with access to the service object while the
 * service is created.
 *
 * <p>Note that prior to {@link android.os.Build.VERSION_CODES#ICE_CREAM_SANDWICH},
 * not supplying this flag would also impact how important the system
 * consider's the target service's process to be.  When set, the only way
 * for it to be raised was by binding from a service in which case it will
 * only be important when that activity is in the foreground.  Now to
 * achieve this behavior you must explicitly supply the new flag
 * {@link #BIND_ADJUST_WITH_ACTIVITY}.  For compatibility, old applications
 * that don't specify {@link #BIND_AUTO_CREATE} will automatically have
 * the flags {@link #BIND_WAIVE_PRIORITY} and
 * {@link #BIND_ADJUST_WITH_ACTIVITY} set for them in order to achieve
 * the same result.
 * @apiSince 1
 */

public static final int BIND_AUTO_CREATE = 1; // 0x1

/**
 * Flag for {@link #bindService}: include debugging help for mismatched
 * calls to unbind.  When this flag is set, the callstack of the following
 * {@link #unbindService} call is retained, to be printed if a later
 * incorrect unbind call is made.  Note that doing this requires retaining
 * information about the binding that was made for the lifetime of the app,
 * resulting in a leak -- this should only be used for debugging.
 * @apiSince 1
 */

public static final int BIND_DEBUG_UNBIND = 2; // 0x2

/**
 * Flag for {@link #bindService}: The service being bound is an
 * {@link android.R.attr#isolatedProcess isolated},
 * {@link android.R.attr#externalService external} service.  This binds the service into the
 * calling application's package, rather than the package in which the service is declared.
 * <p>
 * When using this flag, the code for the service being bound will execute under the calling
 * application's package name and user ID.  Because the service must be an isolated process,
 * it will not have direct access to the application's data, though.
 *
 * The purpose of this flag is to allow applications to provide services that are attributed
 * to the app using the service, rather than the application providing the service.
 * </p>
 * @apiSince 24
 */

public static final int BIND_EXTERNAL_SERVICE = -2147483648; // 0x80000000

/**
 * Flag for {@link #bindService}: this service is very important to
 * the client, so should be brought to the foreground process level
 * when the client is.  Normally a process can only be raised to the
 * visibility level by a client, even if that client is in the foreground.
 * @apiSince 14
 */

public static final int BIND_IMPORTANT = 64; // 0x40

/**
 * Flag for {@link #bindService}: If binding from an app that has specific capabilities
 * due to its foreground state such as an activity or foreground service, then this flag will
 * allow the bound app to get the same capabilities, as long as it has the required permissions
 * as well.
 * @apiSince 29
 */

public static final int BIND_INCLUDE_CAPABILITIES = 4096; // 0x1000

/**
 * Flag for {@link #bindService}: don't allow this binding to raise
 * the target service's process to the foreground scheduling priority.
 * It will still be raised to at least the same memory priority
 * as the client (so that its process will not be killable in any
 * situation where the client is not killable), but for CPU scheduling
 * purposes it may be left in the background.  This only has an impact
 * in the situation where the binding client is a foreground process
 * and the target service is in a background process.
 * @apiSince 8
 */

public static final int BIND_NOT_FOREGROUND = 4; // 0x4

/**
 * Flag for {@link #bindService}: If binding from an app that is visible or user-perceptible,
 * lower the target service's importance to below the perceptible level. This allows
 * the system to (temporarily) expunge the bound process from memory to make room for more
 * important user-perceptible processes.
 * @apiSince 29
 */

public static final int BIND_NOT_PERCEPTIBLE = 256; // 0x100

/**
 * Flag for {@link #bindService}: don't impact the scheduling or
 * memory management priority of the target service's hosting process.
 * Allows the service's process to be managed on the background LRU list
 * just like a regular application process in the background.
 * @apiSince 14
 */

public static final int BIND_WAIVE_PRIORITY = 32; // 0x20

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.hardware.biometrics.BiometricManager} for handling management
 * of face authentication.
 *
 * @see #getSystemService
 * @see android.hardware.biometrics.BiometricManager
 * @apiSince 29
 */

public static final java.lang.String BIOMETRIC_SERVICE = "biometric";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.bluetooth.BluetoothManager} for using Bluetooth.
 *
 * @see #getSystemService(String)
 * @apiSince 18
 */

public static final java.lang.String BLUETOOTH_SERVICE = "bluetooth";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.hardware.camera2.CameraManager} for interacting with
 * camera devices.
 *
 * @see #getSystemService(String)
 * @see android.hardware.camera2.CameraManager
 * @apiSince 21
 */

public static final java.lang.String CAMERA_SERVICE = "camera";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.view.accessibility.CaptioningManager} for obtaining
 * captioning properties and listening for changes in captioning
 * preferences.
 *
 * @see #getSystemService(String)
 * @see android.view.accessibility.CaptioningManager
 * @apiSince 19
 */

public static final java.lang.String CAPTIONING_SERVICE = "captioning";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.telephony.CarrierConfigManager} for reading carrier configuration values.
 *
 * @see #getSystemService(String)
 * @see android.telephony.CarrierConfigManager
 * @apiSince 23
 */

public static final java.lang.String CARRIER_CONFIG_SERVICE = "carrier_config";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.content.ClipboardManager} for accessing and modifying
 * the contents of the global clipboard.
 *
 * @see #getSystemService(String)
 * @see android.content.ClipboardManager
 * @apiSince 1
 */

public static final java.lang.String CLIPBOARD_SERVICE = "clipboard";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.companion.CompanionDeviceManager} for managing companion devices
 *
 * @see #getSystemService(String)
 * @see android.companion.CompanionDeviceManager
 * @apiSince 26
 */

public static final java.lang.String COMPANION_DEVICE_SERVICE = "companiondevice";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a {@link
 * android.net.ConnectivityManager} for handling management of
 * network connections.
 *
 * @see #getSystemService(String)
 * @see android.net.ConnectivityManager
 * @apiSince 1
 */

public static final java.lang.String CONNECTIVITY_SERVICE = "connectivity";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.hardware.ConsumerIrManager} for transmitting infrared
 * signals from the device.
 *
 * @see #getSystemService(String)
 * @see android.hardware.ConsumerIrManager
 * @apiSince 19
 */

public static final java.lang.String CONSUMER_IR_SERVICE = "consumer_ir";

/**
 * Flag for use with {@link #createPackageContext}: ignore any security
 * restrictions on the Context being requested, allowing it to always
 * be loaded.  For use with {@link #CONTEXT_INCLUDE_CODE} to allow code
 * to be loaded into a process even when it isn't safe to do so.  Use
 * with extreme care!
 * @apiSince 1
 */

public static final int CONTEXT_IGNORE_SECURITY = 2; // 0x2

/**
 * Flag for use with {@link #createPackageContext}: include the application
 * code with the context.  This means loading code into the caller's
 * process, so that {@link #getClassLoader()} can be used to instantiate
 * the application's classes.  Setting this flags imposes security
 * restrictions on what application context you can access; if the
 * requested application can not be safely loaded into your process,
 * java.lang.SecurityException will be thrown.  If this flag is not set,
 * there will be no restrictions on the packages that can be loaded,
 * but {@link #getClassLoader} will always return the default system
 * class loader.
 * @apiSince 1
 */

public static final int CONTEXT_INCLUDE_CODE = 1; // 0x1

/**
 * Flag for use with {@link #createPackageContext}: a restricted context may
 * disable specific features. For instance, a View associated with a restricted
 * context would ignore particular XML attributes.
 * @apiSince 4
 */

public static final int CONTEXT_RESTRICTED = 4; // 0x4

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.content.pm.CrossProfileApps} for cross profile operations.
 *
 * @see #getSystemService(String)
 * @apiSince 28
 */

public static final java.lang.String CROSS_PROFILE_APPS_SERVICE = "crossprofileapps";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.app.admin.DevicePolicyManager} for working with global
 * device policy management.
 *
 * @see #getSystemService(String)
 * @apiSince 8
 */

public static final java.lang.String DEVICE_POLICY_SERVICE = "device_policy";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.hardware.display.DisplayManager} for interacting with display devices.
 *
 * @see #getSystemService(String)
 * @see android.hardware.display.DisplayManager
 * @apiSince 17
 */

public static final java.lang.String DISPLAY_SERVICE = "display";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.app.DownloadManager} for requesting HTTP downloads.
 *
 * @see #getSystemService(String)
 * @apiSince 9
 */

public static final java.lang.String DOWNLOAD_SERVICE = "download";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.os.DropBoxManager} instance for recording
 * diagnostic logs.
 * @see #getSystemService(String)
 * @apiSince 8
 */

public static final java.lang.String DROPBOX_SERVICE = "dropbox";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.telephony.euicc.EuiccManager} to manage the device eUICC (embedded SIM).
 *
 * @see #getSystemService(String)
 * @see android.telephony.euicc.EuiccManager
 * @apiSince 28
 */

public static final java.lang.String EUICC_SERVICE = "euicc";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.hardware.fingerprint.FingerprintManager} for handling management
 * of fingerprints.
 *
 * @see #getSystemService(String)
 * @see android.hardware.fingerprint.FingerprintManager
 * @apiSince 23
 */

public static final java.lang.String FINGERPRINT_SERVICE = "fingerprint";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.os.HardwarePropertiesManager} for accessing the hardware properties service.
 *
 * @see #getSystemService(String)
 * @apiSince 24
 */

public static final java.lang.String HARDWARE_PROPERTIES_SERVICE = "hardware_properties";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.view.inputmethod.InputMethodManager} for accessing input
 * methods.
 *
 * @see #getSystemService(String)
 * @apiSince 3
 */

public static final java.lang.String INPUT_METHOD_SERVICE = "input_method";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.hardware.input.InputManager} for interacting with input devices.
 *
 * @see #getSystemService(String)
 * @see android.hardware.input.InputManager
 * @apiSince 16
 */

public static final java.lang.String INPUT_SERVICE = "input";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.net.IpSecManager} for encrypting Sockets or Networks with
 * IPSec.
 *
 * @see #getSystemService(String)
 * @apiSince 28
 */

public static final java.lang.String IPSEC_SERVICE = "ipsec";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a {@link
 * android.app.job.JobScheduler} instance for managing occasional
 * background tasks.
 * @see #getSystemService(String)
 * @see android.app.job.JobScheduler
 * @apiSince 21
 */

public static final java.lang.String JOB_SCHEDULER_SERVICE = "jobscheduler";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.app.KeyguardManager} for controlling keyguard.
 *
 * @see #getSystemService(String)
 * @see android.app.KeyguardManager
 * @apiSince 1
 */

public static final java.lang.String KEYGUARD_SERVICE = "keyguard";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.content.pm.LauncherApps} for querying and monitoring launchable apps across
 * profiles of a user.
 *
 * @see #getSystemService(String)
 * @see android.content.pm.LauncherApps
 * @apiSince 21
 */

public static final java.lang.String LAUNCHER_APPS_SERVICE = "launcherapps";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.view.LayoutInflater} for inflating layout resources in this
 * context.
 *
 * @see #getSystemService(String)
 * @see android.view.LayoutInflater
 * @apiSince 1
 */

public static final java.lang.String LAYOUT_INFLATER_SERVICE = "layout_inflater";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a {@link
 * android.location.LocationManager} for controlling location
 * updates.
 *
 * @see #getSystemService(String)
 * @see android.location.LocationManager
 * @apiSince 1
 */

public static final java.lang.String LOCATION_SERVICE = "location";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a {@link
 * android.media.projection.MediaProjectionManager} instance for managing
 * media projection sessions.
 * @see #getSystemService(String)
 * @see android.media.projection.MediaProjectionManager
 * @apiSince 21
 */

public static final java.lang.String MEDIA_PROJECTION_SERVICE = "media_projection";

/**
 * Use with {@link #getSystemService} to retrieve a
 * {@link android.media.MediaRouter} for controlling and managing
 * routing of media.
 *
 * @see #getSystemService(String)
 * @see android.media.MediaRouter
 * @apiSince 16
 */

public static final java.lang.String MEDIA_ROUTER_SERVICE = "media_router";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.media.session.MediaSessionManager} for managing media Sessions.
 *
 * @see #getSystemService(String)
 * @see android.media.session.MediaSessionManager
 * @apiSince 21
 */

public static final java.lang.String MEDIA_SESSION_SERVICE = "media_session";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.media.midi.MidiManager} for accessing the MIDI service.
 *
 * @see #getSystemService(String)
 * @apiSince 23
 */

public static final java.lang.String MIDI_SERVICE = "midi";

/**
 * File creation mode: for use with {@link #openFileOutput}, if the file
 * already exists then write data to the end of the existing file
 * instead of erasing it.
 * @see #openFileOutput
 * @apiSince 1
 */

public static final int MODE_APPEND = 32768; // 0x8000

/**
 * Database open flag: when set, the database is opened with write-ahead
 * logging enabled by default.
 *
 * @see #openOrCreateDatabase(String, int, CursorFactory)
 * @see #openOrCreateDatabase(String, int, CursorFactory, DatabaseErrorHandler)
 * @see android.database.sqlite.SQLiteDatabase#enableWriteAheadLogging
 * @apiSince 16
 */

public static final int MODE_ENABLE_WRITE_AHEAD_LOGGING = 8; // 0x8

/**
 * SharedPreference loading flag: when set, the file on disk will
 * be checked for modification even if the shared preferences
 * instance is already loaded in this process.  This behavior is
 * sometimes desired in cases where the application has multiple
 * processes, all writing to the same SharedPreferences file.
 * Generally there are better forms of communication between
 * processes, though.
 *
 * <p>This was the legacy (but undocumented) behavior in and
 * before Gingerbread (Android 2.3) and this flag is implied when
 * targeting such releases.  For applications targeting SDK
 * versions <em>greater than</em> Android 2.3, this flag must be
 * explicitly set if desired.
 *
 * @see #getSharedPreferences
 *
 * @deprecated MODE_MULTI_PROCESS does not work reliably in
 * some versions of Android, and furthermore does not provide any
 * mechanism for reconciling concurrent modifications across
 * processes.  Applications should not attempt to use it.  Instead,
 * they should use an explicit cross-process data management
 * approach such as {@link android.content.ContentProvider ContentProvider}.
 * @apiSince 11
 * @deprecatedSince 23
 */

@Deprecated public static final int MODE_MULTI_PROCESS = 4; // 0x4

/**
 * Database open flag: when set, the database is opened without support for
 * localized collators.
 *
 * @see #openOrCreateDatabase(String, int, CursorFactory)
 * @see #openOrCreateDatabase(String, int, CursorFactory, DatabaseErrorHandler)
 * @see android.database.sqlite.SQLiteDatabase#NO_LOCALIZED_COLLATORS
 * @apiSince 24
 */

public static final int MODE_NO_LOCALIZED_COLLATORS = 16; // 0x10

/**
 * File creation mode: the default mode, where the created file can only
 * be accessed by the calling application (or all applications sharing the
 * same user ID).
 * @apiSince 1
 */

public static final int MODE_PRIVATE = 0; // 0x0

/**
 * File creation mode: allow all other applications to have read access to
 * the created file.
 * <p>
 * Starting from {@link android.os.Build.VERSION_CODES#N}, attempting to use this
 * mode throws a {@link java.lang.SecurityException SecurityException}.
 *
 * @deprecated Creating world-readable files is very dangerous, and likely
 *             to cause security holes in applications. It is strongly
 *             discouraged; instead, applications should use more formal
 *             mechanism for interactions such as {@link android.content.ContentProvider ContentProvider},
 *             {@link android.content.BroadcastReceiver BroadcastReceiver}, and {@link android.app.Service}.
 *             There are no guarantees that this access mode will remain on
 *             a file, such as when it goes through a backup and restore.
 * @see android.support.v4.content.FileProvider
 * @see android.content.Intent#FLAG_GRANT_WRITE_URI_PERMISSION
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated public static final int MODE_WORLD_READABLE = 1; // 0x1

/**
 * File creation mode: allow all other applications to have write access to
 * the created file.
 * <p>
 * Starting from {@link android.os.Build.VERSION_CODES#N}, attempting to use this
 * mode will throw a {@link java.lang.SecurityException SecurityException}.
 *
 * @deprecated Creating world-writable files is very dangerous, and likely
 *             to cause security holes in applications. It is strongly
 *             discouraged; instead, applications should use more formal
 *             mechanism for interactions such as {@link android.content.ContentProvider ContentProvider},
 *             {@link android.content.BroadcastReceiver BroadcastReceiver}, and {@link android.app.Service}.
 *             There are no guarantees that this access mode will remain on
 *             a file, such as when it goes through a backup and restore.
 * @see android.support.v4.content.FileProvider
 * @see android.content.Intent#FLAG_GRANT_WRITE_URI_PERMISSION
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated public static final int MODE_WORLD_WRITEABLE = 2; // 0x2

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a {@link
 * android.app.usage.NetworkStatsManager} for querying network usage stats.
 *
 * @see #getSystemService(String)
 * @see android.app.usage.NetworkStatsManager
 * @apiSince 23
 */

public static final java.lang.String NETWORK_STATS_SERVICE = "netstats";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.nfc.NfcManager} for using NFC.
 *
 * @see #getSystemService(String)
 * @apiSince 10
 */

public static final java.lang.String NFC_SERVICE = "nfc";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.app.NotificationManager} for informing the user of
 * background events.
 *
 * @see #getSystemService(String)
 * @see android.app.NotificationManager
 * @apiSince 1
 */

public static final java.lang.String NOTIFICATION_SERVICE = "notification";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a {@link
 * android.net.nsd.NsdManager} for handling management of network service
 * discovery
 *
 * @see #getSystemService(String)
 * @see android.net.nsd.NsdManager
 * @apiSince 16
 */

public static final java.lang.String NSD_SERVICE = "servicediscovery";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.os.PowerManager} for controlling power management,
 * including "wake locks," which let you keep the device on while
 * you're running long tasks.
 * @apiSince 1
 */

public static final java.lang.String POWER_SERVICE = "power";

/**
 * {@link android.print.PrintManager} for printing and managing
 * printers and print tasks.
 *
 * @see #getSystemService(String)
 * @see android.print.PrintManager
 * @apiSince 19
 */

public static final java.lang.String PRINT_SERVICE = "print";

/**
 * Flag for {@link #registerReceiver}: The receiver can receive broadcasts from Instant Apps.
 * @apiSince 26
 */

public static final int RECEIVER_VISIBLE_TO_INSTANT_APPS = 1; // 0x1

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.content.RestrictionsManager} for retrieving application restrictions
 * and requesting permissions for restricted operations.
 * @see #getSystemService(String)
 * @see android.content.RestrictionsManager
 * @apiSince 21
 */

public static final java.lang.String RESTRICTIONS_SERVICE = "restrictions";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a {@link android.app.role.RoleManager}
 * for managing roles.
 *
 * @see #getSystemService(String)
 * @see android.app.role.RoleManager
 * @apiSince 29
 */

public static final java.lang.String ROLE_SERVICE = "role";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a {@link
 * android.app.SearchManager} for handling searches.
 *
 * <p>
 * {@link android.content.res.Configuration#UI_MODE_TYPE_WATCH Configuration#UI_MODE_TYPE_WATCH} does not support
 * {@link android.app.SearchManager}.
 *
 * @see #getSystemService
 * @see android.app.SearchManager
 * @apiSince 1
 */

public static final java.lang.String SEARCH_SERVICE = "search";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a {@link
 * android.hardware.SensorManager} for accessing sensors.
 *
 * @see #getSystemService(String)
 * @see android.hardware.SensorManager
 * @apiSince 1
 */

public static final java.lang.String SENSOR_SERVICE = "sensor";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.content.pm.ShortcutManager} for accessing the launcher shortcut service.
 *
 * @see #getSystemService(String)
 * @see android.content.pm.ShortcutManager
 * @apiSince 25
 */

public static final java.lang.String SHORTCUT_SERVICE = "shortcut";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a {@link
 * android.os.storage.StorageManager} for accessing system storage
 * functions.
 *
 * @see #getSystemService(String)
 * @see android.os.storage.StorageManager
 * @apiSince 9
 */

public static final java.lang.String STORAGE_SERVICE = "storage";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a {@link
 * android.app.usage.StorageStatsManager} for accessing system storage
 * statistics.
 *
 * @see #getSystemService(String)
 * @see android.app.usage.StorageStatsManager
 * @apiSince 26
 */

public static final java.lang.String STORAGE_STATS_SERVICE = "storagestats";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.os.health.SystemHealthManager} for accessing system health (battery, power,
 * memory, etc) metrics.
 *
 * @see #getSystemService(String)
 * @apiSince 24
 */

public static final java.lang.String SYSTEM_HEALTH_SERVICE = "systemhealth";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.telecom.TelecomManager} to manage telecom-related features
 * of the device.
 *
 * @see #getSystemService(String)
 * @see android.telecom.TelecomManager
 * @apiSince 21
 */

public static final java.lang.String TELECOM_SERVICE = "telecom";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.telephony.TelephonyManager} for handling management the
 * telephony features of the device.
 *
 * @see #getSystemService(String)
 * @see android.telephony.TelephonyManager
 * @apiSince 1
 */

public static final java.lang.String TELEPHONY_SERVICE = "phone";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.telephony.SubscriptionManager} for handling management the
 * telephony subscriptions of the device.
 *
 * @see #getSystemService(String)
 * @see android.telephony.SubscriptionManager
 * @apiSince 22
 */

public static final java.lang.String TELEPHONY_SUBSCRIPTION_SERVICE = "telephony_subscription_service";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.view.textclassifier.TextClassificationManager TextClassificationManager} for text classification services.
 *
 * @see #getSystemService(String)
 * @see android.view.textclassifier.TextClassificationManager
 * @apiSince 26
 */

public static final java.lang.String TEXT_CLASSIFICATION_SERVICE = "textclassification";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.view.textservice.TextServicesManager} for accessing
 * text services.
 *
 * @see #getSystemService(String)
 * @apiSince 14
 */

public static final java.lang.String TEXT_SERVICES_MANAGER_SERVICE = "textservices";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.media.tv.TvInputManager} for interacting with TV inputs
 * on the device.
 *
 * @see #getSystemService(String)
 * @see android.media.tv.TvInputManager
 * @apiSince 21
 */

public static final java.lang.String TV_INPUT_SERVICE = "tv_input";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.app.UiModeManager} for controlling UI modes.
 *
 * @see #getSystemService(String)
 * @apiSince 8
 */

public static final java.lang.String UI_MODE_SERVICE = "uimode";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a {@link
 * android.app.usage.UsageStatsManager} for querying device usage stats.
 *
 * @see #getSystemService(String)
 * @see android.app.usage.UsageStatsManager
 * @apiSince 22
 */

public static final java.lang.String USAGE_STATS_SERVICE = "usagestats";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a {@link
 * android.hardware.usb.UsbManager} for access to USB devices (as a USB host)
 * and for controlling this device's behavior as a USB device.
 *
 * @see #getSystemService(String)
 * @see android.hardware.usb.UsbManager
 * @apiSince 12
 */

public static final java.lang.String USB_SERVICE = "usb";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.os.UserManager} for managing users on devices that support multiple users.
 *
 * @see #getSystemService(String)
 * @see android.os.UserManager
 * @apiSince 17
 */

public static final java.lang.String USER_SERVICE = "user";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a {@link
 * android.os.Vibrator} for interacting with the vibration hardware.
 *
 * @see #getSystemService(String)
 * @see android.os.Vibrator
 * @apiSince 1
 */

public static final java.lang.String VIBRATOR_SERVICE = "vibrator";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * com.android.server.WallpaperService for accessing wallpapers.
 *
 * @see #getSystemService(String)
 * @apiSince 1
 */

public static final java.lang.String WALLPAPER_SERVICE = "wallpaper";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.net.wifi.aware.WifiAwareManager} for handling management of
 * Wi-Fi Aware.
 *
 * @see #getSystemService(String)
 * @see android.net.wifi.aware.WifiAwareManager
 * @apiSince 26
 */

public static final java.lang.String WIFI_AWARE_SERVICE = "wifiaware";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a {@link
 * android.net.wifi.p2p.WifiP2pManager} for handling management of
 * Wi-Fi peer-to-peer connections.
 *
 * @see #getSystemService(String)
 * @see android.net.wifi.p2p.WifiP2pManager
 * @apiSince 14
 */

public static final java.lang.String WIFI_P2P_SERVICE = "wifip2p";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a {@link
 * android.net.wifi.rtt.WifiRttManager} for ranging devices with wifi.
 *
 * @see #getSystemService(String)
 * @see android.net.wifi.rtt.WifiRttManager
 * @apiSince 28
 */

public static final java.lang.String WIFI_RTT_RANGING_SERVICE = "wifirtt";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a {@link
 * android.net.wifi.WifiManager} for handling management of
 * Wi-Fi access.
 *
 * @see #getSystemService(String)
 * @see android.net.wifi.WifiManager
 * @apiSince 1
 */

public static final java.lang.String WIFI_SERVICE = "wifi";

/**
 * Use with {@link #getSystemService(java.lang.String)} to retrieve a
 * {@link android.view.WindowManager} for accessing the system's window
 * manager.
 *
 * @see #getSystemService(String)
 * @see android.view.WindowManager
 * @apiSince 1
 */

public static final java.lang.String WINDOW_SERVICE = "window";
}

