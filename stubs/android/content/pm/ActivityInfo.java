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

import android.content.Intent;
import android.content.ComponentName;

/**
 * Information you can retrieve about a particular application
 * activity or receiver. This corresponds to information collected
 * from the AndroidManifest.xml's &lt;activity&gt; and
 * &lt;receiver&gt; tags.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ActivityInfo extends android.content.pm.ComponentInfo implements android.os.Parcelable {

/** @apiSince 1 */

public ActivityInfo() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public ActivityInfo(android.content.pm.ActivityInfo orig) { throw new RuntimeException("Stub!"); }

/**
 * Return the theme resource identifier to use for this activity.  If
 * the activity defines a theme, that is used; else, the application
 * theme is used.
 *
 * @return The theme associated with this activity.
 * @apiSince 1
 */

public final int getThemeResource() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void dump(android.util.Printer pw, java.lang.String prefix) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void writeToParcel(android.os.Parcel dest, int parcelableFlags) { throw new RuntimeException("Stub!"); }

/**
 * Value for {@link #colorMode} indicating that the activity should use the
 * default color mode (sRGB, low dynamic range).
 *
 * @see android.R.attr#colorMode
 * @apiSince 26
 */

public static final int COLOR_MODE_DEFAULT = 0; // 0x0

/**
 * Value of {@link #colorMode} indicating that the activity should use a
 * high dynamic range if the presentation display supports it.
 *
 * @see android.R.attr#colorMode
 * @apiSince 26
 */

public static final int COLOR_MODE_HDR = 2; // 0x2

/**
 * Value of {@link #colorMode} indicating that the activity should use a
 * wide color gamut if the presentation display supports it.
 *
 * @see android.R.attr#colorMode
 * @apiSince 26
 */

public static final int COLOR_MODE_WIDE_COLOR_GAMUT = 1; // 0x1

/**
 * Bit in {@link #configChanges} that indicates that the activity
 * can itself handle the change to the display color gamut or dynamic
 * range. Set from the {@link android.R.attr#configChanges} attribute.
 * @apiSince 26
 */

public static final int CONFIG_COLOR_MODE = 16384; // 0x4000

/**
 * Bit in {@link #configChanges} that indicates that the activity
 * can itself handle density changes. Set from the
 * {@link android.R.attr#configChanges} attribute.
 * @apiSince 17
 */

public static final int CONFIG_DENSITY = 4096; // 0x1000

/**
 * Bit in {@link #configChanges} that indicates that the activity
 * can itself handle changes to the font scaling factor.  Set from the
 * {@link android.R.attr#configChanges} attribute.  This is
 * not a core resource configuration, but a higher-level value, so its
 * constant starts at the high bits.
 * @apiSince 1
 */

public static final int CONFIG_FONT_SCALE = 1073741824; // 0x40000000

/**
 * Bit in {@link #configChanges} that indicates that the activity
 * can itself handle changes to the keyboard type.  Set from the
 * {@link android.R.attr#configChanges} attribute.
 * @apiSince 1
 */

public static final int CONFIG_KEYBOARD = 16; // 0x10

/**
 * Bit in {@link #configChanges} that indicates that the activity
 * can itself handle changes to the keyboard or navigation being hidden/exposed.
 * Note that inspite of the name, this applies to the changes to any
 * hidden states: keyboard or navigation.
 * Set from the {@link android.R.attr#configChanges} attribute.
 * @apiSince 1
 */

public static final int CONFIG_KEYBOARD_HIDDEN = 32; // 0x20

/**
 * Bit in {@link #configChanges} that indicates that the activity
 * can itself handle the change to layout direction. Set from the
 * {@link android.R.attr#configChanges} attribute.
 * @apiSince 17
 */

public static final int CONFIG_LAYOUT_DIRECTION = 8192; // 0x2000

/**
 * Bit in {@link #configChanges} that indicates that the activity
 * can itself handle changes to the locale.  Set from the
 * {@link android.R.attr#configChanges} attribute.
 * @apiSince 1
 */

public static final int CONFIG_LOCALE = 4; // 0x4

/**
 * Bit in {@link #configChanges} that indicates that the activity
 * can itself handle changes to the IMSI MCC.  Set from the
 * {@link android.R.attr#configChanges} attribute.
 * @apiSince 1
 */

public static final int CONFIG_MCC = 1; // 0x1

/**
 * Bit in {@link #configChanges} that indicates that the activity
 * can itself handle changes to the IMSI MNC.  Set from the
 * {@link android.R.attr#configChanges} attribute.
 * @apiSince 1
 */

public static final int CONFIG_MNC = 2; // 0x2

/**
 * Bit in {@link #configChanges} that indicates that the activity
 * can itself handle changes to the navigation type.  Set from the
 * {@link android.R.attr#configChanges} attribute.
 * @apiSince 1
 */

public static final int CONFIG_NAVIGATION = 64; // 0x40

/**
 * Bit in {@link #configChanges} that indicates that the activity
 * can itself handle changes to the screen orientation.  Set from the
 * {@link android.R.attr#configChanges} attribute.
 * @apiSince 1
 */

public static final int CONFIG_ORIENTATION = 128; // 0x80

/**
 * Bit in {@link #configChanges} that indicates that the activity
 * can itself handle changes to the screen layout.  Set from the
 * {@link android.R.attr#configChanges} attribute.
 * @apiSince 4
 */

public static final int CONFIG_SCREEN_LAYOUT = 256; // 0x100

/**
 * Bit in {@link #configChanges} that indicates that the activity
 * can itself handle the screen size. Set from the
 * {@link android.R.attr#configChanges} attribute.  This will be
 * set by default for applications that target an earlier version
 * than {@link android.os.Build.VERSION_CODES#HONEYCOMB_MR2}...
 * <b>however</b>, you will not see the bit set here becomes some
 * applications incorrectly compare {@link #configChanges} against
 * an absolute value rather than correctly masking out the bits
 * they are interested in.  Please don't do that, thanks.
 * @apiSince 13
 */

public static final int CONFIG_SCREEN_SIZE = 1024; // 0x400

/**
 * Bit in {@link #configChanges} that indicates that the activity
 * can itself handle the smallest screen size. Set from the
 * {@link android.R.attr#configChanges} attribute.  This will be
 * set by default for applications that target an earlier version
 * than {@link android.os.Build.VERSION_CODES#HONEYCOMB_MR2}...
 * <b>however</b>, you will not see the bit set here becomes some
 * applications incorrectly compare {@link #configChanges} against
 * an absolute value rather than correctly masking out the bits
 * they are interested in.  Please don't do that, thanks.
 * @apiSince 13
 */

public static final int CONFIG_SMALLEST_SCREEN_SIZE = 2048; // 0x800

/**
 * Bit in {@link #configChanges} that indicates that the activity
 * can itself handle changes to the touchscreen type.  Set from the
 * {@link android.R.attr#configChanges} attribute.
 * @apiSince 1
 */

public static final int CONFIG_TOUCHSCREEN = 8; // 0x8

/**
 * Bit in {@link #configChanges} that indicates that the activity
 * can itself handle the ui mode. Set from the
 * {@link android.R.attr#configChanges} attribute.
 * @apiSince 8
 */

public static final int CONFIG_UI_MODE = 512; // 0x200

/** @apiSince 1 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.content.pm.ActivityInfo> CREATOR;
static { CREATOR = null; }

/**
 * Constant corresponding to <code>always</code> in
 * the {@link android.R.attr#documentLaunchMode} attribute.
 * @apiSince 21
 */

public static final int DOCUMENT_LAUNCH_ALWAYS = 2; // 0x2

/**
 * Constant corresponding to <code>intoExisting</code> in
 * the {@link android.R.attr#documentLaunchMode} attribute.
 * @apiSince 21
 */

public static final int DOCUMENT_LAUNCH_INTO_EXISTING = 1; // 0x1

/**
 * Constant corresponding to <code>never</code> in
 * the {@link android.R.attr#documentLaunchMode} attribute.
 * @apiSince 21
 */

public static final int DOCUMENT_LAUNCH_NEVER = 3; // 0x3

/**
 * Constant corresponding to <code>none</code> in
 * the {@link android.R.attr#documentLaunchMode} attribute.
 * @apiSince 21
 */

public static final int DOCUMENT_LAUNCH_NONE = 0; // 0x0

/**
 * Bit in {@link #flags} that indicates that the activity can be moved
 * between tasks based on its task affinity.  Set from the
 * {@link android.R.attr#allowTaskReparenting} attribute.
 * @apiSince 1
 */

public static final int FLAG_ALLOW_TASK_REPARENTING = 64; // 0x40

/**
 * Bit in {@link #flags} indicating that, when the activity is the root
 * of a task, that task's stack should never be cleared when it is
 * relaunched from home.  Set from the
 * {@link android.R.attr#alwaysRetainTaskState} attribute.
 * @apiSince 1
 */

public static final int FLAG_ALWAYS_RETAIN_TASK_STATE = 8; // 0x8

/**
 * Bit in {@link #flags} indicating that tasks started with this activity are to be
 * removed from the recent list of tasks when the last activity in the task is finished.
 * Corresponds to {@link android.R.attr#autoRemoveFromRecents}
 * @apiSince 21
 */

public static final int FLAG_AUTO_REMOVE_FROM_RECENTS = 8192; // 0x2000

/**
 * Bit in {@link #flags} indicating that, when the activity is the root
 * of a task, that task's stack should be cleared each time the user
 * re-launches it from home.  As a result, the user will always
 * return to the original activity at the top of the task.
 * This flag only applies to activities that
 * are used to start the root of a new task.  Set from the
 * {@link android.R.attr#clearTaskOnLaunch} attribute.
 * @apiSince 1
 */

public static final int FLAG_CLEAR_TASK_ON_LAUNCH = 4; // 0x4

/**
 * Bit in {@link #flags} indicating that this activity should be run with VR mode enabled.
 *
 * @see android.app.Activity#setVrModeEnabled(boolean, ComponentName)
 * @apiSince 24
 */

public static final int FLAG_ENABLE_VR_MODE = 32768; // 0x8000

/**
 * Bit in {@link #flags} that indicates that the activity should not
 * appear in the list of recently launched activities.  Set from the
 * {@link android.R.attr#excludeFromRecents} attribute.
 * @apiSince 1
 */

public static final int FLAG_EXCLUDE_FROM_RECENTS = 32; // 0x20

/**
 * Bit in {@link #flags} indicating that, when a request to close system
 * windows happens, this activity is finished.
 * Set from the
 * {@link android.R.attr#finishOnCloseSystemDialogs} attribute.
 * @apiSince 5
 */

public static final int FLAG_FINISH_ON_CLOSE_SYSTEM_DIALOGS = 256; // 0x100

/**
 * Bit in {@link #flags} indicating that, when the activity's task is
 * relaunched from home, this activity should be finished.
 * Set from the
 * {@link android.R.attr#finishOnTaskLaunch} attribute.
 * @apiSince 1
 */

public static final int FLAG_FINISH_ON_TASK_LAUNCH = 2; // 0x2

/**
 * Value for {@link #flags}: true when the application's rendering should
 * be hardware accelerated.
 * @apiSince 11
 */

public static final int FLAG_HARDWARE_ACCELERATED = 512; // 0x200

/**
 * Bit in {@link #flags} corresponding to an immersive activity
 * that wishes not to be interrupted by notifications.
 * Applications that hide the system notification bar with
 * {@link android.view.WindowManager.LayoutParams#FLAG_FULLSCREEN}
 * may still be interrupted by high-priority notifications; for example, an
 * incoming phone call may use
 * {@link android.app.Notification#fullScreenIntent fullScreenIntent}
 * to present a full-screen in-call activity to the user, pausing the
 * current activity as a side-effect. An activity with
 * {@link #FLAG_IMMERSIVE} set, however, will not be interrupted; the
 * notification may be shown in some other way (such as a small floating
 * "toast" window).
 *
 * Note that this flag will always reflect the Activity's
 * <code>android:immersive</code> manifest definition, even if the Activity's
 * immersive state is changed at runtime via
 * {@link android.app.Activity#setImmersive(boolean)}.
 *
 * @see android.app.Notification#FLAG_HIGH_PRIORITY
 * @see android.app.Activity#setImmersive(boolean)
 * @apiSince 18
 */

public static final int FLAG_IMMERSIVE = 2048; // 0x800

/**
 * Bit in {@link #flags} indicating whether this activity is able to
 * run in multiple processes.  If
 * true, the system may instantiate it in the some process as the
 * process starting it in order to conserve resources.  If false, the
 * default, it always runs in {@link #processName}.  Set from the
 * {@link android.R.attr#multiprocess} attribute.
 * @apiSince 1
 */

public static final int FLAG_MULTIPROCESS = 1; // 0x1

/**
 * Bit in {@link #flags} indicating that, when the user navigates away
 * from an activity, it should be finished.
 * Set from the
 * {@link android.R.attr#noHistory} attribute.
 * @apiSince 3
 */

public static final int FLAG_NO_HISTORY = 128; // 0x80

/**
 * Bit in {@link #flags}: If set, a task rooted at this activity will have its
 * baseIntent replaced by the activity immediately above this. Each activity may further
 * relinquish its identity to the activity above it using this flag. Set from the
 * {@link android.R.attr#relinquishTaskIdentity} attribute.
 * @apiSince 21
 */

public static final int FLAG_RELINQUISH_TASK_IDENTITY = 4096; // 0x1000

/**
 * Bit in {@link #flags} indicating that this activity can start is creation/resume
 * while the previous activity is still pausing.  Corresponds to
 * {@link android.R.attr#resumeWhilePausing}
 * @apiSince 21
 */

public static final int FLAG_RESUME_WHILE_PAUSING = 16384; // 0x4000

/**
 * Bit in {@link #flags}: If set, a single instance of the receiver will
 * run for all users on the device.  Set from the
 * {@link android.R.attr#singleUser} attribute.  Note that this flag is
 * only relevant for ActivityInfo structures that are describing receiver
 * components; it is not applied to activities.
 * @apiSince 17
 */

public static final int FLAG_SINGLE_USER = 1073741824; // 0x40000000

/**
 * Bit in {@link #flags} indicating that the activity's state
 * is not required to be saved, so that if there is a failure the
 * activity will not be removed from the activity stack.  Set from the
 * {@link android.R.attr#stateNotNeeded} attribute.
 * @apiSince 1
 */

public static final int FLAG_STATE_NOT_NEEDED = 16; // 0x10

/**
 * Constant corresponding to <code>standard</code> in
 * the {@link android.R.attr#launchMode} attribute.
 * @apiSince 1
 */

public static final int LAUNCH_MULTIPLE = 0; // 0x0

/**
 * Constant corresponding to <code>singleInstance</code> in
 * the {@link android.R.attr#launchMode} attribute.
 * @apiSince 1
 */

public static final int LAUNCH_SINGLE_INSTANCE = 3; // 0x3

/**
 * Constant corresponding to <code>singleTask</code> in
 * the {@link android.R.attr#launchMode} attribute.
 * @apiSince 1
 */

public static final int LAUNCH_SINGLE_TASK = 2; // 0x2

/**
 * Constant corresponding to <code>singleTop</code> in
 * the {@link android.R.attr#launchMode} attribute.
 * @apiSince 1
 */

public static final int LAUNCH_SINGLE_TOP = 1; // 0x1

/**
 * Constant corresponding to <code>persistAcrossReboots</code> in
 * the {@link android.R.attr#persistableMode} attribute.
 * @apiSince 21
 */

public static final int PERSIST_ACROSS_REBOOTS = 2; // 0x2

/**
 * Constant corresponding to <code>doNotPersist</code> in
 * the {@link android.R.attr#persistableMode} attribute.
 * @apiSince 21
 */

public static final int PERSIST_NEVER = 1; // 0x1

/**
 * Constant corresponding to <code>persistRootOnly</code> in
 * the {@link android.R.attr#persistableMode} attribute.
 * @apiSince 21
 */

public static final int PERSIST_ROOT_ONLY = 0; // 0x0

/**
 * Constant corresponding to <code>behind</code> in
 * the {@link android.R.attr#screenOrientation} attribute.
 * @apiSince 1
 */

public static final int SCREEN_ORIENTATION_BEHIND = 3; // 0x3

/**
 * Constant corresponding to <code>fullSensor</code> in
 * the {@link android.R.attr#screenOrientation} attribute.
 * @apiSince 9
 */

public static final int SCREEN_ORIENTATION_FULL_SENSOR = 10; // 0xa

/**
 * Constant corresponding to <code>fullUser</code> in
 * the {@link android.R.attr#screenOrientation} attribute.
 * @apiSince 18
 */

public static final int SCREEN_ORIENTATION_FULL_USER = 13; // 0xd

/**
 * Constant corresponding to <code>landscape</code> in
 * the {@link android.R.attr#screenOrientation} attribute.
 * @apiSince 1
 */

public static final int SCREEN_ORIENTATION_LANDSCAPE = 0; // 0x0

/**
 * Constant corresponding to <code>locked</code> in
 * the {@link android.R.attr#screenOrientation} attribute.
 * @apiSince 18
 */

public static final int SCREEN_ORIENTATION_LOCKED = 14; // 0xe

/**
 * Constant corresponding to <code>nosensor</code> in
 * the {@link android.R.attr#screenOrientation} attribute.
 * @apiSince 1
 */

public static final int SCREEN_ORIENTATION_NOSENSOR = 5; // 0x5

/**
 * Constant corresponding to <code>portrait</code> in
 * the {@link android.R.attr#screenOrientation} attribute.
 * @apiSince 1
 */

public static final int SCREEN_ORIENTATION_PORTRAIT = 1; // 0x1

/**
 * Constant corresponding to <code>reverseLandscape</code> in
 * the {@link android.R.attr#screenOrientation} attribute.
 * @apiSince 9
 */

public static final int SCREEN_ORIENTATION_REVERSE_LANDSCAPE = 8; // 0x8

/**
 * Constant corresponding to <code>reversePortrait</code> in
 * the {@link android.R.attr#screenOrientation} attribute.
 * @apiSince 9
 */

public static final int SCREEN_ORIENTATION_REVERSE_PORTRAIT = 9; // 0x9

/**
 * Constant corresponding to <code>sensor</code> in
 * the {@link android.R.attr#screenOrientation} attribute.
 * @apiSince 1
 */

public static final int SCREEN_ORIENTATION_SENSOR = 4; // 0x4

/**
 * Constant corresponding to <code>sensorLandscape</code> in
 * the {@link android.R.attr#screenOrientation} attribute.
 * @apiSince 9
 */

public static final int SCREEN_ORIENTATION_SENSOR_LANDSCAPE = 6; // 0x6

/**
 * Constant corresponding to <code>sensorPortrait</code> in
 * the {@link android.R.attr#screenOrientation} attribute.
 * @apiSince 9
 */

public static final int SCREEN_ORIENTATION_SENSOR_PORTRAIT = 7; // 0x7

/**
 * Constant corresponding to <code>unspecified</code> in
 * the {@link android.R.attr#screenOrientation} attribute.
 * @apiSince 1
 */

public static final int SCREEN_ORIENTATION_UNSPECIFIED = -1; // 0xffffffff

/**
 * Constant corresponding to <code>user</code> in
 * the {@link android.R.attr#screenOrientation} attribute.
 * @apiSince 1
 */

public static final int SCREEN_ORIENTATION_USER = 2; // 0x2

/**
 * Constant corresponding to <code>userLandscape</code> in
 * the {@link android.R.attr#screenOrientation} attribute.
 * @apiSince 18
 */

public static final int SCREEN_ORIENTATION_USER_LANDSCAPE = 11; // 0xb

/**
 * Constant corresponding to <code>userPortrait</code> in
 * the {@link android.R.attr#screenOrientation} attribute.
 * @apiSince 18
 */

public static final int SCREEN_ORIENTATION_USER_PORTRAIT = 12; // 0xc

/**
 * Flag for use with {@link #uiOptions}.
 * Indicates that the action bar should put all action items in a separate bar when
 * the screen is narrow.
 * <p>This value corresponds to "splitActionBarWhenNarrow" for the {@link #uiOptions} XML
 * attribute.
 * @apiSince 14
 */

public static final int UIOPTION_SPLIT_ACTION_BAR_WHEN_NARROW = 1; // 0x1

/**
 * The color mode requested by this activity. The target display may not be
 * able to honor the request.
 
 * <br>
 * Value is {@link android.content.pm.ActivityInfo#COLOR_MODE_DEFAULT}, {@link android.content.pm.ActivityInfo#COLOR_MODE_WIDE_COLOR_GAMUT}, or {@link android.content.pm.ActivityInfo#COLOR_MODE_HDR}
 * @apiSince 26
 */

public int colorMode = 0; // 0x0

/**
 * Bit mask of kinds of configuration changes that this activity
 * can handle itself (without being restarted by the system).
 * Contains any combination of {@link #CONFIG_FONT_SCALE},
 * {@link #CONFIG_MCC}, {@link #CONFIG_MNC},
 * {@link #CONFIG_LOCALE}, {@link #CONFIG_TOUCHSCREEN},
 * {@link #CONFIG_KEYBOARD}, {@link #CONFIG_NAVIGATION},
 * {@link #CONFIG_ORIENTATION}, {@link #CONFIG_SCREEN_LAYOUT},
 * {@link #CONFIG_DENSITY}, {@link #CONFIG_LAYOUT_DIRECTION} and
 * {@link #CONFIG_COLOR_MODE}.
 * Set from the {@link android.R.attr#configChanges} attribute.
 * @apiSince 1
 */

public int configChanges;

/**
 * The document launch mode style requested by the activity. From the
 * {@link android.R.attr#documentLaunchMode} attribute, one of
 * {@link #DOCUMENT_LAUNCH_NONE}, {@link #DOCUMENT_LAUNCH_INTO_EXISTING},
 * {@link #DOCUMENT_LAUNCH_ALWAYS}.
 *
 * <p>Modes DOCUMENT_LAUNCH_ALWAYS
 * and DOCUMENT_LAUNCH_INTO_EXISTING are equivalent to {@link
 * android.content.Intent#FLAG_ACTIVITY_NEW_DOCUMENT
 * Intent.FLAG_ACTIVITY_NEW_DOCUMENT} with and without {@link
 * android.content.Intent#FLAG_ACTIVITY_MULTIPLE_TASK
 * Intent.FLAG_ACTIVITY_MULTIPLE_TASK} respectively.
 * @apiSince 21
 */

public int documentLaunchMode;

/**
 * Options that have been set in the activity declaration in the
 * manifest.
 * These include:
 * {@link #FLAG_MULTIPROCESS},
 * {@link #FLAG_FINISH_ON_TASK_LAUNCH}, {@link #FLAG_CLEAR_TASK_ON_LAUNCH},
 * {@link #FLAG_ALWAYS_RETAIN_TASK_STATE},
 * {@link #FLAG_STATE_NOT_NEEDED}, {@link #FLAG_EXCLUDE_FROM_RECENTS},
 * {@link #FLAG_ALLOW_TASK_REPARENTING}, {@link #FLAG_NO_HISTORY},
 * {@link #FLAG_FINISH_ON_CLOSE_SYSTEM_DIALOGS},
 * {@link #FLAG_HARDWARE_ACCELERATED}, {@link #FLAG_SINGLE_USER}.
 * @apiSince 1
 */

public int flags;

/**
 * The launch mode style requested by the activity.  From the
 * {@link android.R.attr#launchMode} attribute, one of
 * {@link #LAUNCH_MULTIPLE},
 * {@link #LAUNCH_SINGLE_TOP}, {@link #LAUNCH_SINGLE_TASK}, or
 * {@link #LAUNCH_SINGLE_INSTANCE}.
 * @apiSince 1
 */

public int launchMode;

/**
 * The maximum number of tasks rooted at this activity that can be in the recent task list.
 * Refer to {@link android.R.attr#maxRecents}.
 * @apiSince 21
 */

public int maxRecents;

/**
 * If defined, the activity named here is the logical parent of this activity.
 * @apiSince 16
 */

public java.lang.String parentActivityName;

/**
 * Optional name of a permission required to be able to access this
 * Activity.  From the "permission" attribute.
 * @apiSince 1
 */

public java.lang.String permission;

/**
 * Value indicating how this activity is to be persisted across
 * reboots for restoring in the Recents list.
 * {@link android.R.attr#persistableMode}
 * @apiSince 21
 */

public int persistableMode;

/**
 * The preferred screen orientation this activity would like to run in.
 * From the {@link android.R.attr#screenOrientation} attribute, one of
 * {@link #SCREEN_ORIENTATION_UNSPECIFIED},
 * {@link #SCREEN_ORIENTATION_LANDSCAPE},
 * {@link #SCREEN_ORIENTATION_PORTRAIT},
 * {@link #SCREEN_ORIENTATION_USER},
 * {@link #SCREEN_ORIENTATION_BEHIND},
 * {@link #SCREEN_ORIENTATION_SENSOR},
 * {@link #SCREEN_ORIENTATION_NOSENSOR},
 * {@link #SCREEN_ORIENTATION_SENSOR_LANDSCAPE},
 * {@link #SCREEN_ORIENTATION_SENSOR_PORTRAIT},
 * {@link #SCREEN_ORIENTATION_REVERSE_LANDSCAPE},
 * {@link #SCREEN_ORIENTATION_REVERSE_PORTRAIT},
 * {@link #SCREEN_ORIENTATION_FULL_SENSOR},
 * {@link #SCREEN_ORIENTATION_USER_LANDSCAPE},
 * {@link #SCREEN_ORIENTATION_USER_PORTRAIT},
 * {@link #SCREEN_ORIENTATION_FULL_USER},
 * {@link #SCREEN_ORIENTATION_LOCKED},
 
 * <br>
 * Value is android.content.pm.ActivityInfo.SCREEN_ORIENTATION_UNSET, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_UNSPECIFIED}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_LANDSCAPE}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_PORTRAIT}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_USER}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_BEHIND}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_SENSOR}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_NOSENSOR}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_SENSOR_LANDSCAPE}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_SENSOR_PORTRAIT}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_REVERSE_LANDSCAPE}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_REVERSE_PORTRAIT}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_FULL_SENSOR}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_USER_LANDSCAPE}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_USER_PORTRAIT}, {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_FULL_USER}, or {@link android.content.pm.ActivityInfo#SCREEN_ORIENTATION_LOCKED}
 * @apiSince 1
 */

public int screenOrientation = -1; // 0xffffffff

/**
 * The desired soft input mode for this activity's main window.
 * Set from the {@link android.R.attr#windowSoftInputMode} attribute
 * in the activity's manifest.  May be any of the same values allowed
 * for {@link android.view.WindowManager.LayoutParams#softInputMode
 * WindowManager.LayoutParams.softInputMode}.  If 0 (unspecified),
 * the mode from the theme will be used.
 
 * <br>
 * Value is either <code>0</code> or a combination of {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_STATE_UNSPECIFIED}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_STATE_UNCHANGED}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_STATE_HIDDEN}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_STATE_ALWAYS_HIDDEN}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_STATE_VISIBLE}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_STATE_ALWAYS_VISIBLE}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_ADJUST_UNSPECIFIED}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_ADJUST_RESIZE}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_ADJUST_PAN}, {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_ADJUST_NOTHING}, and {@link android.view.WindowManager.LayoutParams#SOFT_INPUT_IS_FORWARD_NAVIGATION}
 * @apiSince 3
 */

public int softInputMode;

/**
 * If this is an activity alias, this is the real activity class to run
 * for it.  Otherwise, this is null.
 * @apiSince 1
 */

public java.lang.String targetActivity;

/**
 * The affinity this activity has for another task in the system.  The
 * string here is the name of the task, often the package name of the
 * overall package.  If null, the activity has no affinity.  Set from the
 * {@link android.R.attr#taskAffinity} attribute.
 * @apiSince 1
 */

public java.lang.String taskAffinity;

/**
 * A style resource identifier (in the package's resources) of this
 * activity's theme.  From the "theme" attribute or, if not set, 0.
 * @apiSince 1
 */

public int theme;

/**
 * The desired extra UI options for this activity and its main window.
 * Set from the {@link android.R.attr#uiOptions} attribute in the
 * activity's manifest.
 * @apiSince 14
 */

public int uiOptions = 0; // 0x0

/**
 * Information about desired position and size of activity on the display when
 * it is first started.
 * @apiSince 24
 */

public android.content.pm.ActivityInfo.WindowLayout windowLayout;
/**
 * Contains information about position and size of the activity on the display.
 *
 * Used in freeform mode to set desired position when activity is first launched.
 * It describes how big the activity wants to be in both width and height,
 * the minimal allowed size, and the gravity to be applied.
 *
 * @attr ref android.R.styleable#AndroidManifestLayout_defaultWidth
 * @attr ref android.R.styleable#AndroidManifestLayout_defaultHeight
 * @attr ref android.R.styleable#AndroidManifestLayout_gravity
 * @attr ref android.R.styleable#AndroidManifestLayout_minWidth
 * @attr ref android.R.styleable#AndroidManifestLayout_minHeight
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class WindowLayout {

/** @apiSince 24 */

public WindowLayout(int width, float widthFraction, int height, float heightFraction, int gravity, int minWidth, int minHeight) { throw new RuntimeException("Stub!"); }

/**
 * Gravity of activity.
 * Currently {@link android.view.Gravity#TOP}, {@link android.view.Gravity#BOTTOM},
 * {@link android.view.Gravity#LEFT} and {@link android.view.Gravity#RIGHT} are supported.
 *
 * @attr ref android.R.styleable#AndroidManifestLayout_gravity
 * @apiSince 24
 */

public final int gravity;
{ gravity = 0; }

/**
 * Height of activity in pixels.
 *
 * @attr ref android.R.styleable#AndroidManifestLayout_defaultHeight
 * @apiSince 24
 */

public final int height;
{ height = 0; }

/**
 * Height of activity as a fraction of available display height.
 * If both {@link #height} and this value are set this one will be preferred.
 *
 * @attr ref android.R.styleable#AndroidManifestLayout_defaultHeight
 * @apiSince 24
 */

public final float heightFraction;
{ heightFraction = 0; }

/**
 * Minimal height of activity in pixels to be able to display its content.
 *
 * <p><strong>NOTE:</strong> A task's root activity value is applied to all additional
 * activities launched in the task. That is if the root activity of a task set minimal
 * height, then the system will set the same minimal height on all other activities in the
 * task. It will also ignore any other minimal height attributes of non-root activities.
 *
 * @attr ref android.R.styleable#AndroidManifestLayout_minHeight
 * @apiSince 24
 */

public final int minHeight;
{ minHeight = 0; }

/**
 * Minimal width of activity in pixels to be able to display its content.
 *
 * <p><strong>NOTE:</strong> A task's root activity value is applied to all additional
 * activities launched in the task. That is if the root activity of a task set minimal
 * width, then the system will set the same minimal width on all other activities in the
 * task. It will also ignore any other minimal width attributes of non-root activities.
 *
 * @attr ref android.R.styleable#AndroidManifestLayout_minWidth
 * @apiSince 24
 */

public final int minWidth;
{ minWidth = 0; }

/**
 * Width of activity in pixels.
 *
 * @attr ref android.R.styleable#AndroidManifestLayout_defaultWidth
 * @apiSince 24
 */

public final int width;
{ width = 0; }

/**
 * Width of activity as a fraction of available display width.
 * If both {@link #width} and this value are set this one will be preferred.
 *
 * @attr ref android.R.styleable#AndroidManifestLayout_defaultWidth
 * @apiSince 24
 */

public final float widthFraction;
{ widthFraction = 0; }
}

}

