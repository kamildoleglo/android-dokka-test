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


package android.content.pm;

import android.os.storage.StorageManager;
import android.os.Environment;
import java.util.UUID;
import android.content.Context;
import android.os.Build;

/**
 * Information you can retrieve about a particular application.  This
 * corresponds to information collected from the AndroidManifest.xml's
 * &lt;application&gt; tag.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ApplicationInfo extends android.content.pm.PackageItemInfo implements android.os.Parcelable {

/** @apiSince 1 */

public ApplicationInfo() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public ApplicationInfo(android.content.pm.ApplicationInfo orig) { throw new RuntimeException("Stub!"); }

/**
 * Return a concise, localized title for the given
 * {@link android.content.pm.ApplicationInfo#category ApplicationInfo#category} value, or {@code null} for unknown
 * values such as {@link #CATEGORY_UNDEFINED}.
 *
 * @see #category
 
 * @param category Value is {@link android.content.pm.ApplicationInfo#CATEGORY_UNDEFINED}, {@link android.content.pm.ApplicationInfo#CATEGORY_GAME}, {@link android.content.pm.ApplicationInfo#CATEGORY_AUDIO}, {@link android.content.pm.ApplicationInfo#CATEGORY_VIDEO}, {@link android.content.pm.ApplicationInfo#CATEGORY_IMAGE}, {@link android.content.pm.ApplicationInfo#CATEGORY_SOCIAL}, {@link android.content.pm.ApplicationInfo#CATEGORY_NEWS}, {@link android.content.pm.ApplicationInfo#CATEGORY_MAPS}, or {@link android.content.pm.ApplicationInfo#CATEGORY_PRODUCTIVITY}
 * @apiSince 26
 */

public static java.lang.CharSequence getCategoryTitle(android.content.Context context, int category) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void dump(android.util.Printer pw, java.lang.String prefix) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void writeToParcel(android.os.Parcel dest, int parcelableFlags) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the textual description of the application.  This
 * will call back on the given PackageManager to load the description from
 * the application.
 *
 * @param pm A PackageManager from which the label can be loaded; usually
 * the PackageManager from which you originally retrieved this item.
 *
 * @return Returns a CharSequence containing the application's description.
 * If there is no description, null is returned.
 * @apiSince 1
 */

public java.lang.CharSequence loadDescription(android.content.pm.PackageManager pm) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether or not this application was installed as a virtual preload.
 * @apiSince 27
 */

public boolean isVirtualPreload() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether or not this application can be profiled by the shell user,
 * even when running on a device that is running in user mode.
 * @apiSince 29
 */

public boolean isProfileableByShell() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the package has declared in its manifest that it is a
 * runtime resource overlay.
 * @apiSince 29
 */

public boolean isResourceOverlay() { throw new RuntimeException("Stub!"); }

/**
 * Category for apps which primarily work with audio or music, such as music
 * players.
 *
 * @see #category
 * @apiSince 26
 */

public static final int CATEGORY_AUDIO = 1; // 0x1

/**
 * Category for apps which are primarily games.
 *
 * @see #category
 * @apiSince 26
 */

public static final int CATEGORY_GAME = 0; // 0x0

/**
 * Category for apps which primarily work with images or photos, such as
 * camera or gallery apps.
 *
 * @see #category
 * @apiSince 26
 */

public static final int CATEGORY_IMAGE = 3; // 0x3

/**
 * Category for apps which are primarily maps apps, such as navigation apps.
 *
 * @see #category
 * @apiSince 26
 */

public static final int CATEGORY_MAPS = 6; // 0x6

/**
 * Category for apps which are primarily news apps, such as newspapers,
 * magazines, or sports apps.
 *
 * @see #category
 * @apiSince 26
 */

public static final int CATEGORY_NEWS = 5; // 0x5

/**
 * Category for apps which are primarily productivity apps, such as cloud
 * storage or workplace apps.
 *
 * @see #category
 * @apiSince 26
 */

public static final int CATEGORY_PRODUCTIVITY = 7; // 0x7

/**
 * Category for apps which are primarily social apps, such as messaging,
 * communication, email, or social network apps.
 *
 * @see #category
 * @apiSince 26
 */

public static final int CATEGORY_SOCIAL = 4; // 0x4

/**
 * Value when category is undefined.
 *
 * @see #category
 * @apiSince 26
 */

public static final int CATEGORY_UNDEFINED = -1; // 0xffffffff

/**
 * Category for apps which primarily work with video or movies, such as
 * streaming video apps.
 *
 * @see #category
 * @apiSince 26
 */

public static final int CATEGORY_VIDEO = 2; // 0x2

/** @apiSince 1 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.content.pm.ApplicationInfo> CREATOR;
static { CREATOR = null; }

/**
 * Value for {@link #flags}: set to <code>false</code> if the application does not wish
 * to permit any OS-driven backups of its data; <code>true</code> otherwise.
 *
 * <p>Comes from the
 * {@link android.R.styleable#AndroidManifestApplication_allowBackup android:allowBackup}
 * attribute of the &lt;application&gt; tag.
 * @apiSince 8
 */

public static final int FLAG_ALLOW_BACKUP = 32768; // 0x8000

/**
 * Value for {@link #flags}: default value for the corresponding ActivityInfo flag.
 * Comes from {@link android.R.styleable#AndroidManifestApplication_allowClearUserData
 * android:allowClearUserData} of the &lt;application&gt; tag.
 * @apiSince 1
 */

public static final int FLAG_ALLOW_CLEAR_USER_DATA = 64; // 0x40

/**
 * Value for {@link #flags}: default value for the corresponding ActivityInfo flag.
 * Comes from {@link android.R.styleable#AndroidManifestApplication_allowTaskReparenting
 * android:allowTaskReparenting} of the &lt;application&gt; tag.
 * @apiSince 1
 */

public static final int FLAG_ALLOW_TASK_REPARENTING = 32; // 0x20

/**
 * Value for {@link #flags}: set to true if this application would like to
 * allow debugging of its
 * code, even when installed on a non-development system.  Comes
 * from {@link android.R.styleable#AndroidManifestApplication_debuggable
 * android:debuggable} of the &lt;application&gt; tag.
 * @apiSince 1
 */

public static final int FLAG_DEBUGGABLE = 2; // 0x2

/**
 * Value for {@link #flags}: Set to true if the application is
 * currently installed on external/removable/unprotected storage.  Such
 * applications may not be available if their storage is not currently
 * mounted.  When the storage it is on is not available, it will look like
 * the application has been uninstalled (its .apk is no longer available)
 * but its persistent data is not removed.
 * @apiSince 8
 */

public static final int FLAG_EXTERNAL_STORAGE = 262144; // 0x40000

/**
 * When set installer extracts native libs from .apk files.
 * @apiSince 23
 */

public static final int FLAG_EXTRACT_NATIVE_LIBS = 268435456; // 0x10000000

/**
 * Value for {@link #flags}: set to true if this application holds the
 * {@link android.Manifest.permission#FACTORY_TEST} permission and the
 * device is running in factory test mode.
 * @apiSince 1
 */

public static final int FLAG_FACTORY_TEST = 16; // 0x10

/**
 * Value for {@link #flags}: {@code true} if the application asks that only
 * full-data streaming backups of its data be performed even though it defines
 * a {@link android.app.backup.BackupAgent BackupAgent}, which normally
 * indicates that the app will manage its backed-up data via incremental
 * key/value updates.
 * @apiSince 21
 */

public static final int FLAG_FULL_BACKUP_ONLY = 67108864; // 0x4000000

/**
 * Value for {@link #flags}: {@code true} when the application's rendering
 * should be hardware accelerated.
 * @apiSince 23
 */

public static final int FLAG_HARDWARE_ACCELERATED = 536870912; // 0x20000000

/**
 * Value for {@link #flags}: set to true if this application has code
 * associated with it.  Comes
 * from {@link android.R.styleable#AndroidManifestApplication_hasCode
 * android:hasCode} of the &lt;application&gt; tag.
 * @apiSince 1
 */

public static final int FLAG_HAS_CODE = 4; // 0x4

/**
 * Value for {@link #flags}: true if the application is currently
 * installed for the calling user.
 * @apiSince 17
 */

public static final int FLAG_INSTALLED = 8388608; // 0x800000

/**
 * Value for {@link #flags}: true if the application only has its
 * data installed; the application package itself does not currently
 * exist on the device.
 * @apiSince 17
 */

public static final int FLAG_IS_DATA_ONLY = 16777216; // 0x1000000

/**
 * Value for {@link #flags}: true if the application was declared to be a
 * game, or false if it is a non-game application.
 *
 * @deprecated use {@link #CATEGORY_GAME} instead.
 * @apiSince 21
 * @deprecatedSince 26
 */

@Deprecated public static final int FLAG_IS_GAME = 33554432; // 0x2000000

/**
 * Value for {@link #flags}: set to <code>false</code> if the application must be kept
 * in memory following a full-system restore operation; <code>true</code> otherwise.
 * Ordinarily, during a full system restore operation each application is shut down
 * following execution of its agent's onRestore() method.  Setting this attribute to
 * <code>false</code> prevents this.  Most applications will not need to set this attribute.
 *
 * <p>If
 * {@link android.R.styleable#AndroidManifestApplication_allowBackup android:allowBackup}
 * is set to <code>false</code> or no
 * {@link android.R.styleable#AndroidManifestApplication_backupAgent android:backupAgent}
 * is specified, this flag will be ignored.
 *
 * <p>Comes from the
 * {@link android.R.styleable#AndroidManifestApplication_killAfterRestore android:killAfterRestore}
 * attribute of the &lt;application&gt; tag.
 * @apiSince 8
 */

public static final int FLAG_KILL_AFTER_RESTORE = 65536; // 0x10000

/**
 * Value for {@link #flags}: true when the application has requested a
 * large heap for its processes.  Corresponds to
 * {@link android.R.styleable#AndroidManifestApplication_largeHeap
 * android:largeHeap}.
 * @apiSince 11
 */

public static final int FLAG_LARGE_HEAP = 1048576; // 0x100000

/**
 * Value for {@link #flags}: true if code from this application will need to be
 * loaded into other applications' processes. On devices that support multiple
 * instruction sets, this implies the code might be loaded into a process that's
 * using any of the devices supported instruction sets.
 *
 * <p> The system might treat such applications specially, for eg., by
 * extracting the application's native libraries for all supported instruction
 * sets or by compiling the application's dex code for all supported instruction
 * sets.
 * @apiSince 21
 */

public static final int FLAG_MULTIARCH = -2147483648; // 0x80000000

/**
 * Value for {@link #flags}: set to true if this application is persistent.
 * Comes from {@link android.R.styleable#AndroidManifestApplication_persistent
 * android:persistent} of the &lt;application&gt; tag.
 * @apiSince 1
 */

public static final int FLAG_PERSISTENT = 8; // 0x8

/**
 * Value for {@link #flags}: true when the application knows how to adjust
 * its UI for different screen sizes.  Corresponds to
 * {@link android.R.styleable#AndroidManifestSupportsScreens_resizeable
 * android:resizeable}.
 * @apiSince 4
 */

public static final int FLAG_RESIZEABLE_FOR_SCREENS = 4096; // 0x1000

/**
 * Value for {@link #flags}: Set to <code>true</code> if the application's backup
 * agent claims to be able to handle restore data even "from the future,"
 * i.e. from versions of the application with a versionCode greater than
 * the one currently installed on the device.  <i>Use with caution!</i>  By default
 * this attribute is <code>false</code> and the Backup Manager will ensure that data
 * from "future" versions of the application are never supplied during a restore operation.
 *
 * <p>If
 * {@link android.R.styleable#AndroidManifestApplication_allowBackup android:allowBackup}
 * is set to <code>false</code> or no
 * {@link android.R.styleable#AndroidManifestApplication_backupAgent android:backupAgent}
 * is specified, this flag will be ignored.
 *
 * <p>Comes from the
 * {@link android.R.styleable#AndroidManifestApplication_restoreAnyVersion android:restoreAnyVersion}
 * attribute of the &lt;application&gt; tag.
 * @apiSince 8
 */

public static final int FLAG_RESTORE_ANY_VERSION = 131072; // 0x20000

/**
 * Value for {@link #flags}: true if this application's package is in
 * the stopped state.
 * @apiSince 12
 */

public static final int FLAG_STOPPED = 2097152; // 0x200000

/**
 * Value for {@link #flags}: true when the application's window can be
 * increased in size for larger screens.  Corresponds to
 * {@link android.R.styleable#AndroidManifestSupportsScreens_largeScreens
 * android:largeScreens}.
 * @apiSince 4
 */

public static final int FLAG_SUPPORTS_LARGE_SCREENS = 2048; // 0x800

/**
 * Value for {@link #flags}: true when the application's window can be
 * displayed on normal screens.  Corresponds to
 * {@link android.R.styleable#AndroidManifestSupportsScreens_normalScreens
 * android:normalScreens}.
 * @apiSince 4
 */

public static final int FLAG_SUPPORTS_NORMAL_SCREENS = 1024; // 0x400

/**
 * Value for {@link #flags}: true  when the application is willing to support
 * RTL (right to left). All activities will inherit this value.
 *
 * Set from the {@link android.R.attr#supportsRtl} attribute in the
 * activity's manifest.
 *
 * Default value is false (no support for RTL).
 * @apiSince 17
 */

public static final int FLAG_SUPPORTS_RTL = 4194304; // 0x400000

/**
 * Value for {@link #flags}: true when the application knows how to
 * accommodate different screen densities.  Corresponds to
 * {@link android.R.styleable#AndroidManifestSupportsScreens_anyDensity
 * android:anyDensity}.
 * @apiSince 4
 */

public static final int FLAG_SUPPORTS_SCREEN_DENSITIES = 8192; // 0x2000

/**
 * Value for {@link #flags}: true when the application's window can be
 * reduced in size for smaller screens.  Corresponds to
 * {@link android.R.styleable#AndroidManifestSupportsScreens_smallScreens
 * android:smallScreens}.
 * @apiSince 4
 */

public static final int FLAG_SUPPORTS_SMALL_SCREENS = 512; // 0x200

/**
 * Value for {@link #flags}: true when the application's window can be
 * increased in size for extra large screens.  Corresponds to
 * {@link android.R.styleable#AndroidManifestSupportsScreens_xlargeScreens
 * android:xlargeScreens}.
 * @apiSince 11
 */

public static final int FLAG_SUPPORTS_XLARGE_SCREENS = 524288; // 0x80000

/**
 * Value for {@link #flags}: true if this application's package is in
 * the suspended state.
 * @apiSince 24
 */

public static final int FLAG_SUSPENDED = 1073741824; // 0x40000000

/**
 * Value for {@link #flags}: if set, this application is installed in the
 * device's system image.
 * @apiSince 1
 */

public static final int FLAG_SYSTEM = 1; // 0x1

/**
 * Value for {@link #flags}: this is set if the application has specified
 * {@link android.R.styleable#AndroidManifestApplication_testOnly
 * android:testOnly} to be true.
 * @apiSince 4
 */

public static final int FLAG_TEST_ONLY = 256; // 0x100

/**
 * Value for {@link #flags}: this is set if this application has been
 * installed as an update to a built-in system application.
 * @apiSince 4
 */

public static final int FLAG_UPDATED_SYSTEM_APP = 128; // 0x80

/**
 * Value for {@link #flags}: {@code true} if the application may use cleartext network traffic
 * (e.g., HTTP rather than HTTPS; WebSockets rather than WebSockets Secure; XMPP, IMAP, STMP
 * without STARTTLS or TLS). If {@code false}, the app declares that it does not intend to use
 * cleartext network traffic, in which case platform components (e.g., HTTP stacks,
 * {@code DownloadManager}, {@code MediaPlayer}) will refuse app's requests to use cleartext
 * traffic. Third-party libraries are encouraged to honor this flag as well.
 *
 * <p>NOTE: {@code WebView} honors this flag for applications targeting API level 26 and up.
 *
 * <p>This flag is ignored on Android N and above if an Android Network Security Config is
 * present.
 *
 * <p>This flag comes from
 * {@link android.R.styleable#AndroidManifestApplication_usesCleartextTraffic
 * android:usesCleartextTraffic} of the &lt;application&gt; tag.
 * @apiSince 23
 */

public static final int FLAG_USES_CLEARTEXT_TRAFFIC = 134217728; // 0x8000000

/**
 * Value for {@link #flags}: set to true if this application would like to
 * request the VM to operate under the safe mode. Comes from
 * {@link android.R.styleable#AndroidManifestApplication_vmSafeMode
 * android:vmSafeMode} of the &lt;application&gt; tag.
 * @apiSince 8
 */

public static final int FLAG_VM_SAFE_MODE = 16384; // 0x4000

/**
 * The factory of this package, as specified by the &lt;manifest&gt;
 * tag's {@link android.R.styleable#AndroidManifestApplication_appComponentFactory}
 * attribute.
 * @apiSince 28
 */

public java.lang.String appComponentFactory;

/**
 * Class implementing the Application's backup functionality.  From
 * the "backupAgent" attribute.  This is an optional attribute and
 * will be null if the application does not specify it in its manifest.
 *
 * <p>If android:allowBackup is set to false, this attribute is ignored.
 * @apiSince 8
 */

public java.lang.String backupAgentName;

/**
 * The category of this app. Categories are used to cluster multiple apps
 * together into meaningful groups, such as when summarizing battery,
 * network, or disk usage. Apps should only define this value when they fit
 * well into one of the specific categories.
 * <p>
 * Set from the {@link android.R.attr#appCategory} attribute in the
 * manifest. If the manifest doesn't define a category, this value may have
 * been provided by the installer via
 * {@link android.content.pm.PackageManager#setApplicationCategoryHint(java.lang.String,int) PackageManager#setApplicationCategoryHint(String, int)}.
 
 * <br>
 * Value is {@link android.content.pm.ApplicationInfo#CATEGORY_UNDEFINED}, {@link android.content.pm.ApplicationInfo#CATEGORY_GAME}, {@link android.content.pm.ApplicationInfo#CATEGORY_AUDIO}, {@link android.content.pm.ApplicationInfo#CATEGORY_VIDEO}, {@link android.content.pm.ApplicationInfo#CATEGORY_IMAGE}, {@link android.content.pm.ApplicationInfo#CATEGORY_SOCIAL}, {@link android.content.pm.ApplicationInfo#CATEGORY_NEWS}, {@link android.content.pm.ApplicationInfo#CATEGORY_MAPS}, or {@link android.content.pm.ApplicationInfo#CATEGORY_PRODUCTIVITY}
 * @apiSince 26
 */

public int category = -1; // 0xffffffff

/**
 * Class implementing the Application object.  From the "class"
 * attribute.
 * @apiSince 1
 */

public java.lang.String className;

/**
 * The maximum smallest screen width the application is designed for.  If 0,
 * nothing has been specified.  Comes from
 * {@link android.R.styleable#AndroidManifestSupportsScreens_compatibleWidthLimitDp
 * android:compatibleWidthLimitDp} attribute of the &lt;supports-screens&gt; tag.
 * @apiSince 13
 */

public int compatibleWidthLimitDp = 0; // 0x0

/**
 * Full path to the default directory assigned to the package for its
 * persistent data.
 * @apiSince 1
 */

public java.lang.String dataDir;

/**
 * A style resource identifier (in the package's resources) of the
 * description of an application.  From the "description" attribute
 * or, if not set, 0.
 * @apiSince 1
 */

public int descriptionRes;

/**
 * Full path to the device-protected directory assigned to the package for
 * its persistent data.
 *
 * @see android.content.Context#createDeviceProtectedStorageContext()
 * @apiSince 24
 */

public java.lang.String deviceProtectedDataDir;

/**
 * When false, indicates that all components within this application are
 * considered disabled, regardless of their individually set enabled status.
 * @apiSince 1
 */

public boolean enabled = true;

/**
 * Flags associated with the application.  Any combination of
 * {@link #FLAG_SYSTEM}, {@link #FLAG_DEBUGGABLE}, {@link #FLAG_HAS_CODE},
 * {@link #FLAG_PERSISTENT}, {@link #FLAG_FACTORY_TEST}, and
 * {@link #FLAG_ALLOW_TASK_REPARENTING}
 * {@link #FLAG_ALLOW_CLEAR_USER_DATA}, {@link #FLAG_UPDATED_SYSTEM_APP},
 * {@link #FLAG_TEST_ONLY}, {@link #FLAG_SUPPORTS_SMALL_SCREENS},
 * {@link #FLAG_SUPPORTS_NORMAL_SCREENS},
 * {@link #FLAG_SUPPORTS_LARGE_SCREENS}, {@link #FLAG_SUPPORTS_XLARGE_SCREENS},
 * {@link #FLAG_RESIZEABLE_FOR_SCREENS},
 * {@link #FLAG_SUPPORTS_SCREEN_DENSITIES}, {@link #FLAG_VM_SAFE_MODE},
 * {@link #FLAG_ALLOW_BACKUP}, {@link #FLAG_KILL_AFTER_RESTORE},
 * {@link #FLAG_RESTORE_ANY_VERSION}, {@link #FLAG_EXTERNAL_STORAGE},
 * {@link #FLAG_LARGE_HEAP}, {@link #FLAG_STOPPED},
 * {@link #FLAG_SUPPORTS_RTL}, {@link #FLAG_INSTALLED},
 * {@link #FLAG_IS_DATA_ONLY}, {@link #FLAG_IS_GAME},
 * {@link #FLAG_FULL_BACKUP_ONLY}, {@link #FLAG_USES_CLEARTEXT_TRAFFIC},
 * {@link #FLAG_MULTIARCH}.
 * @apiSince 1
 */

public int flags = 0; // 0x0

/**
 * The maximum smallest screen width the application will work on.  If 0,
 * nothing has been specified.  Comes from
 * {@link android.R.styleable#AndroidManifestSupportsScreens_largestWidthLimitDp
 * android:largestWidthLimitDp} attribute of the &lt;supports-screens&gt; tag.
 * @apiSince 13
 */

public int largestWidthLimitDp = 0; // 0x0

/**
 * Class implementing the Application's manage space
 * functionality.  From the "manageSpaceActivity"
 * attribute. This is an optional attribute and will be null if
 * applications don't specify it in their manifest
 * @apiSince 1
 */

public java.lang.String manageSpaceActivityName;

/**
 * The minimum SDK version this application can run on. It will not run
 * on earlier versions.
 * @apiSince 24
 */

public int minSdkVersion;

/**
 * Full path to the directory where native JNI libraries are stored.
 * @apiSince 9
 */

public java.lang.String nativeLibraryDir;

/**
 * Optional name of a permission required to be able to access this
 * application's components.  From the "permission" attribute.
 * @apiSince 1
 */

public java.lang.String permission;

/**
 * The name of the process this application should run in.  From the
 * "process" attribute or, if not set, the same as
 * <var>packageName</var>.
 * @apiSince 1
 */

public java.lang.String processName;

/**
 * Full path to the publicly available parts of {@link #sourceDir},
 * including resources and manifest. This may be different from
 * {@link #sourceDir} if an application is forward locked.
 * @apiSince 1
 */

public java.lang.String publicSourceDir;

/**
 * The required smallest screen width the application can run on.  If 0,
 * nothing has been specified.  Comes from
 * {@link android.R.styleable#AndroidManifestSupportsScreens_requiresSmallestWidthDp
 * android:requiresSmallestWidthDp} attribute of the &lt;supports-screens&gt; tag.
 * @apiSince 13
 */

public int requiresSmallestWidthDp = 0; // 0x0

/**
 * Paths to all shared libraries this application is linked against.  This
 * field is only set if the {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES PackageManager#GET_SHARED_LIBRARY_FILES} flag was used when retrieving
 * the structure.
 * @apiSince 1
 */

public java.lang.String[] sharedLibraryFiles;

/**
 * Full path to the base APK for this application.
 * @apiSince 1
 */

public java.lang.String sourceDir;

/**
 * The names of all installed split APKs, ordered lexicographically.
 * @apiSince 26
 */

public java.lang.String[] splitNames;

/**
 * Full path to the publicly available parts of {@link #splitSourceDirs},
 * including resources and manifest. This may be different from
 * {@link #splitSourceDirs} if an application is forward locked.
 *
 * @see #splitSourceDirs
 * @apiSince 21
 */

public java.lang.String[] splitPublicSourceDirs;

/**
 * Full paths to zero or more split APKs, indexed by the same order as {@link #splitNames}.
 * @apiSince 21
 */

public java.lang.String[] splitSourceDirs;

/**
 * UUID of the storage volume on which this application is being hosted. For
 * apps hosted on the default internal storage at
 * {@link android.os.Environment#getDataDirectory() Environment#getDataDirectory()}, the UUID value is
 * {@link android.os.storage.StorageManager#UUID_DEFAULT StorageManager#UUID_DEFAULT}.
 * @apiSince 26
 */

public java.util.UUID storageUuid;

/**
 * The minimum SDK version this application targets.  It may run on earlier
 * versions, but it knows how to work with any new behavior added at this
 * version.  Will be {@link android.os.Build.VERSION_CODES#CUR_DEVELOPMENT}
 * if this is a development build and the app is targeting that.  You should
 * compare that this number is >= the SDK version number at which your
 * behavior was introduced.
 * @apiSince 4
 */

public int targetSdkVersion;

/**
 * Default task affinity of all activities in this application. See
 * {@link android.content.pm.ActivityInfo#taskAffinity ActivityInfo#taskAffinity} for more information.  This comes
 * from the "taskAffinity" attribute.
 * @apiSince 1
 */

public java.lang.String taskAffinity;

/**
 * A style resource identifier (in the package's resources) of the
 * default visual theme of the application.  From the "theme" attribute
 * or, if not set, 0.
 * @apiSince 1
 */

public int theme;

/**
 * The default extra UI options for activities in this application.
 * Set from the {@link android.R.attr#uiOptions} attribute in the
 * activity's manifest.
 * @apiSince 14
 */

public int uiOptions = 0; // 0x0

/**
 * The kernel user-ID that has been assigned to this application;
 * currently this is not a unique ID (multiple applications can have
 * the same uid).
 * @apiSince 1
 */

public int uid;
/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class DisplayNameComparator implements java.util.Comparator<android.content.pm.ApplicationInfo> {

/** @apiSince 1 */

public DisplayNameComparator(android.content.pm.PackageManager pm) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final int compare(android.content.pm.ApplicationInfo aa, android.content.pm.ApplicationInfo ab) { throw new RuntimeException("Stub!"); }
}

}

