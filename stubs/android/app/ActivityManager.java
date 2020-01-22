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


package android.app;

import android.os.Build;
import android.os.Build.VERSION_CODES;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.Manifest;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Process;

/**
 * <p>
 * This class gives information about, and interacts
 * with, activities, services, and the containing
 * process.
 * </p>
 *
 * <p>
 * A number of the methods in this class are for
 * debugging or informational purposes and they should
 * not be used to affect any runtime behavior of
 * your app. These methods are called out as such in
 * the method level documentation.
 * </p>
 *
 *<p>
 * Most application developers should not have the need to
 * use this class, most of whose methods are for specialized
 * use cases. However, a few methods are more broadly applicable.
 * For instance, {@link android.app.ActivityManager#isLowRamDevice() isLowRamDevice()}
 * enables your app to detect whether it is running on a low-memory device,
 * and behave accordingly.
 * {@link android.app.ActivityManager#clearApplicationUserData() clearApplicationUserData()}
 * is for apps with reset-data functionality.
 * </p>
 *
 * <p>
 * In some special use cases, where an app interacts with
 * its Task stack, the app may use the
 * {@link android.app.ActivityManager.AppTask} and
 * {@link android.app.ActivityManager.RecentTaskInfo} inner
 * classes. However, in general, the methods in this class should
 * be used for testing and debugging purposes only.
 * </p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ActivityManager {

ActivityManager() { throw new RuntimeException("Stub!"); }

/**
 * Return the approximate per-application memory class of the current
 * device.  This gives you an idea of how hard a memory limit you should
 * impose on your application to let the overall system work best.  The
 * returned value is in megabytes; the baseline Android memory class is
 * 16 (which happens to be the Java heap limit of those devices); some
 * devices with more memory may return 24 or even higher numbers.
 * @apiSince 5
 */

public int getMemoryClass() { throw new RuntimeException("Stub!"); }

/**
 * Return the approximate per-application memory class of the current
 * device when an application is running with a large heap.  This is the
 * space available for memory-intensive applications; most applications
 * should not need this amount of memory, and should instead stay with the
 * {@link #getMemoryClass()} limit.  The returned value is in megabytes.
 * This may be the same size as {@link #getMemoryClass()} on memory
 * constrained devices, or it may be significantly larger on devices with
 * a large amount of available RAM.
 *
 * <p>This is the size of the application's Dalvik heap if it has
 * specified <code>android:largeHeap="true"</code> in its manifest.
 * @apiSince 11
 */

public int getLargeMemoryClass() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this is a low-RAM device.  Exactly whether a device is low-RAM
 * is ultimately up to the device configuration, but currently it generally means
 * something with 1GB or less of RAM.  This is mostly intended to be used by apps
 * to determine whether they should turn off certain features that require more RAM.
 * @apiSince 19
 */

public boolean isLowRamDevice() { throw new RuntimeException("Stub!"); }

/**
 * <p></p>Return a list of the tasks that the user has recently launched, with
 * the most recent being first and older ones after in order.
 *
 * <p><b>Note: this method is only intended for debugging and presenting
 * task management user interfaces</b>.  This should never be used for
 * core logic in an application, such as deciding between different
 * behaviors based on the information found here.  Such uses are
 * <em>not</em> supported, and will likely break in the future.  For
 * example, if multiple applications can be actively running at the
 * same time, assumptions made about the meaning of the data here for
 * purposes of control flow will be incorrect.</p>
 *
 * @deprecated As of {@link android.os.Build.VERSION_CODES#LOLLIPOP}, this method is
 * no longer available to third party applications: the introduction of
 * document-centric recents means
 * it can leak personal information to the caller.  For backwards compatibility,
 * it will still return a small subset of its data: at least the caller's
 * own tasks (though see {@link #getAppTasks()} for the correct supported
 * way to retrieve that information), and possibly some other tasks
 * such as home that are known to not be sensitive.
 *
 * @param maxNum The maximum number of entries to return in the list.  The
 * actual number returned may be smaller, depending on how many tasks the
 * user has started and the maximum number the system can remember.
 * @param flags Information about what to return.  May be any combination
 * of {@link #RECENT_WITH_EXCLUDED} and {@link #RECENT_IGNORE_UNAVAILABLE}.
 *
 * @return Returns a list of RecentTaskInfo records describing each of
 * the recent tasks.
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public java.util.List<android.app.ActivityManager.RecentTaskInfo> getRecentTasks(int maxNum, int flags) throws java.lang.SecurityException { throw new RuntimeException("Stub!"); }

/**
 * Get the list of tasks associated with the calling application.
 *
 * @return The list of tasks associated with the application making this call.
 * @throws java.lang.SecurityException
 * @apiSince 21
 */

public java.util.List<android.app.ActivityManager.AppTask> getAppTasks() { throw new RuntimeException("Stub!"); }

/**
 * Return the current design dimensions for {@link android.app.ActivityManager.AppTask AppTask} thumbnails, for use
 * with {@link #addAppTask}.
 * @apiSince 21
 */

public android.util.Size getAppTaskThumbnailSize() { throw new RuntimeException("Stub!"); }

/**
 * Add a new {@link android.app.ActivityManager.AppTask AppTask} for the calling application.  This will create a new
 * recents entry that is added to the <b>end</b> of all existing recents.
 *
 * @param activity The activity that is adding the entry.   This is used to help determine
 * the context that the new recents entry will be in.
 * This value must never be {@code null}.
 * @param intent The Intent that describes the recents entry.  This is the same Intent that
 * you would have used to launch the activity for it.  In generally you will want to set
 * both {@link android.content.Intent#FLAG_ACTIVITY_NEW_DOCUMENT Intent#FLAG_ACTIVITY_NEW_DOCUMENT} and
 * {@link android.content.Intent#FLAG_ACTIVITY_RETAIN_IN_RECENTS Intent#FLAG_ACTIVITY_RETAIN_IN_RECENTS}; the latter is required since this recents
 * entry will exist without an activity, so it doesn't make sense to not retain it when
 * its activity disappears.  The given Intent here also must have an explicit ComponentName
 * set on it.
 * This value must never be {@code null}.
 * @param description Optional additional description information.
 * This value may be {@code null}.
 * @param thumbnail Thumbnail to use for the recents entry.  Should be the size given by
 * {@link #getAppTaskThumbnailSize()}.  If the bitmap is not that exact size, it will be
 * recreated in your process, probably in a way you don't like, before the recents entry
 * is added.
 *
 * This value must never be {@code null}.
 * @return Returns the task id of the newly added app task, or -1 if the add failed.  The
 * most likely cause of failure is that there is no more room for more tasks for your app.
 * @apiSince 21
 */

public int addAppTask(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull android.content.Intent intent, @androidx.annotation.Nullable android.app.ActivityManager.TaskDescription description, @androidx.annotation.NonNull android.graphics.Bitmap thumbnail) { throw new RuntimeException("Stub!"); }

/**
 * Return a list of the tasks that are currently running, with
 * the most recent being first and older ones after in order.  Note that
 * "running" does not mean any of the task's code is currently loaded or
 * activity -- the task may have been frozen by the system, so that it
 * can be restarted in its previous state when next brought to the
 * foreground.
 *
 * <p><b>Note: this method is only intended for debugging and presenting
 * task management user interfaces</b>.  This should never be used for
 * core logic in an application, such as deciding between different
 * behaviors based on the information found here.  Such uses are
 * <em>not</em> supported, and will likely break in the future.  For
 * example, if multiple applications can be actively running at the
 * same time, assumptions made about the meaning of the data here for
 * purposes of control flow will be incorrect.</p>
 *
 * @deprecated As of {@link android.os.Build.VERSION_CODES#LOLLIPOP}, this method
 * is no longer available to third party
 * applications: the introduction of document-centric recents means
 * it can leak person information to the caller.  For backwards compatibility,
 * it will still return a small subset of its data: at least the caller's
 * own tasks, and possibly some other tasks
 * such as home that are known to not be sensitive.
 *
 * @param maxNum The maximum number of entries to return in the list.  The
 * actual number returned may be smaller, depending on how many tasks the
 * user has started.
 *
 * @return Returns a list of RunningTaskInfo records describing each of
 * the running tasks.
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public java.util.List<android.app.ActivityManager.RunningTaskInfo> getRunningTasks(int maxNum) throws java.lang.SecurityException { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to calling {@link #moveTaskToFront(int,int,android.os.Bundle)}
 * with a null options argument.
 *
 * <br>
 * Requires {@link android.Manifest.permission#REORDER_TASKS}
 * @param taskId The identifier of the task to be moved, as found in
 * {@link android.app.ActivityManager.RunningTaskInfo RunningTaskInfo} or {@link android.app.ActivityManager.RecentTaskInfo RecentTaskInfo}.
 * @param flags Additional operational flags.
 
 * Value is either <code>0</code> or a combination of {@link android.app.ActivityManager#MOVE_TASK_WITH_HOME}, and {@link android.app.ActivityManager#MOVE_TASK_NO_USER_ACTION}
 * @apiSince 11
 */

public void moveTaskToFront(int taskId, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Ask that the task associated with a given task ID be moved to the
 * front of the stack, so it is now visible to the user.
 *
 * <br>
 * Requires {@link android.Manifest.permission#REORDER_TASKS}
 * @param taskId The identifier of the task to be moved, as found in
 * {@link android.app.ActivityManager.RunningTaskInfo RunningTaskInfo} or {@link android.app.ActivityManager.RecentTaskInfo RecentTaskInfo}.
 * @param flags Additional operational flags.
 * Value is either <code>0</code> or a combination of {@link android.app.ActivityManager#MOVE_TASK_WITH_HOME}, and {@link android.app.ActivityManager#MOVE_TASK_NO_USER_ACTION}
 * @param options Additional options for the operation, either null or
 * as per {@link android.content.Context#startActivity(android.content.Intent,android.os.Bundle) Context#startActivity(Intent, android.os.Bundle)}.
 * @apiSince 16
 */

public void moveTaskToFront(int taskId, int flags, android.os.Bundle options) { throw new RuntimeException("Stub!"); }

/**
 * Check if the context is allowed to start an activity on specified display. Some launch
 * restrictions may apply to secondary displays that are private, virtual, or owned by the
 * system, in which case an activity start may throw a {@link java.lang.SecurityException SecurityException}. Call this
 * method prior to starting an activity on a secondary display to check if the current context
 * has access to it.
 *
 * @see android.app.ActivityOptions#setLaunchDisplayId(int)
 * @see android.view.Display.FLAG_PRIVATE
 * @see android.view.Display.TYPE_VIRTUAL
 *
 * @param context Source context, from which an activity will be started.
 * This value must never be {@code null}.
 * @param displayId Target display id.
 * @param intent Intent used to launch an activity.
 * This value must never be {@code null}.
 * @return {@code true} if a call to start an activity on the target display is allowed for the
 * provided context and no {@link java.lang.SecurityException SecurityException} will be thrown, {@code false} otherwise.
 * @apiSince 29
 */

public boolean isActivityStartAllowedOnDisplay(@androidx.annotation.NonNull android.content.Context context, int displayId, @androidx.annotation.NonNull android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Return a list of the services that are currently running.
 *
 * <p><b>Note: this method is only intended for debugging or implementing
 * service management type user interfaces.</b></p>
 *
 * @deprecated As of {@link android.os.Build.VERSION_CODES#O}, this method
 * is no longer available to third party applications.  For backwards compatibility,
 * it will still return the caller's own services.
 *
 * @param maxNum The maximum number of entries to return in the list.  The
 * actual number returned may be smaller, depending on how many services
 * are running.
 *
 * @return Returns a list of RunningServiceInfo records describing each of
 * the running tasks.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public java.util.List<android.app.ActivityManager.RunningServiceInfo> getRunningServices(int maxNum) throws java.lang.SecurityException { throw new RuntimeException("Stub!"); }

/**
 * Returns a PendingIntent you can start to show a control panel for the
 * given running service.  If the service does not have a control panel,
 * null is returned.
 * @apiSince 5
 */

public android.app.PendingIntent getRunningServiceControlPanel(android.content.ComponentName service) throws java.lang.SecurityException { throw new RuntimeException("Stub!"); }

/**
 * Return general information about the memory state of the system.  This
 * can be used to help decide how to manage your own memory, though note
 * that polling is not recommended and
 * {@link android.content.ComponentCallbacks2#onTrimMemory(int)
 * ComponentCallbacks2.onTrimMemory(int)} is the preferred way to do this.
 * Also see {@link #getMyMemoryState} for how to retrieve the current trim
 * level of your process as needed, which gives a better hint for how to
 * manage its memory.
 * @apiSince 1
 */

public void getMemoryInfo(android.app.ActivityManager.MemoryInfo outInfo) { throw new RuntimeException("Stub!"); }

/**
 * Permits an application to erase its own data from disk.  This is equivalent to
 * the user choosing to clear the app's data from within the device settings UI.  It
 * erases all dynamic data associated with the app -- its private data and data in its
 * private area on external storage -- but does not remove the installed application
 * itself, nor any OBB files. It also revokes all runtime permissions that the app has acquired,
 * clears all notifications and removes all Uri grants related to this application.
 *
 * @return {@code true} if the application successfully requested that the application's
 *     data be erased; {@code false} otherwise.
 * @apiSince 19
 */

public boolean clearApplicationUserData() { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of any processes that are currently in an error condition.  The result
 * will be null if all processes are running properly at this time.
 *
 * @return Returns a list of ProcessErrorStateInfo records, or null if there are no
 * current error conditions (it will not return an empty list).  This list ordering is not
 * specified.
 * @apiSince 1
 */

public java.util.List<android.app.ActivityManager.ProcessErrorStateInfo> getProcessesInErrorState() { throw new RuntimeException("Stub!"); }

/**
 * Query whether the user has enabled background restrictions for this app.
 *
 * <p> The user may chose to do this, if they see that an app is consuming an unreasonable
 * amount of battery while in the background. </p>
 *
 * <p> If true, any work that the app tries to do will be aggressively restricted while it is in
 * the background. At a minimum, jobs and alarms will not execute and foreground services
 * cannot be started unless an app activity is in the foreground. </p>
 *
 * <p><b> Note that these restrictions stay in effect even when the device is charging.</b></p>
 *
 * @return true if user has enforced background restrictions for this app, false otherwise.
 * @apiSince 28
 */

public boolean isBackgroundRestricted() { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of application processes that are running on the device.
 *
 * <p><b>Note: this method is only intended for debugging or building
 * a user-facing process management UI.</b></p>
 *
 * @return Returns a list of RunningAppProcessInfo records, or null if there are no
 * running processes (it will not return an empty list).  This list ordering is not
 * specified.
 * @apiSince 3
 */

public java.util.List<android.app.ActivityManager.RunningAppProcessInfo> getRunningAppProcesses() { throw new RuntimeException("Stub!"); }

/**
 * Return global memory state information for the calling process.  This
 * does not fill in all fields of the {@link android.app.ActivityManager.RunningAppProcessInfo RunningAppProcessInfo}.  The
 * only fields that will be filled in are
 * {@link android.app.ActivityManager.RunningAppProcessInfo#pid RunningAppProcessInfo#pid},
 * {@link android.app.ActivityManager.RunningAppProcessInfo#uid RunningAppProcessInfo#uid},
 * {@link android.app.ActivityManager.RunningAppProcessInfo#lastTrimLevel RunningAppProcessInfo#lastTrimLevel},
 * {@link android.app.ActivityManager.RunningAppProcessInfo#importance RunningAppProcessInfo#importance},
 * {@link android.app.ActivityManager.RunningAppProcessInfo#lru RunningAppProcessInfo#lru}, and
 * {@link android.app.ActivityManager.RunningAppProcessInfo#importanceReasonCode RunningAppProcessInfo#importanceReasonCode}.
 * @apiSince 16
 */

public static void getMyMemoryState(android.app.ActivityManager.RunningAppProcessInfo outState) { throw new RuntimeException("Stub!"); }

/**
 * Return information about the memory usage of one or more processes.
 *
 * <p><b>Note: this method is only intended for debugging or building
 * a user-facing process management UI.</b></p>
 *
 * <p>As of {@link android.os.Build.VERSION_CODES#Q Android Q}, for regular apps this method
 * will only return information about the memory info for the processes running as the
 * caller's uid; no other process memory info is available and will be zero.
 * Also of {@link android.os.Build.VERSION_CODES#Q Android Q} the sample rate allowed
 * by this API is significantly limited, if called faster the limit you will receive the
 * same data as the previous call.</p>
 *
 * @param pids The pids of the processes whose memory usage is to be
 * retrieved.
 * @return Returns an array of memory information, one for each
 * requested pid.
 * @apiSince 5
 */

public android.os.Debug.MemoryInfo[] getProcessMemoryInfo(int[] pids) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated This is now just a wrapper for
 * {@link #killBackgroundProcesses(java.lang.String)}; the previous behavior here
 * is no longer available to applications because it allows them to
 * break other applications by removing their alarms, stopping their
 * services, etc.
 * @apiSince 3
 * @deprecatedSince 15
 */

@Deprecated
public void restartPackage(java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * Have the system immediately kill all background processes associated
 * with the given package.  This is the same as the kernel killing those
 * processes to reclaim memory; the system will take care of restarting
 * these processes in the future as needed.
 *
 * <br>
 * Requires {@link android.Manifest.permission#KILL_BACKGROUND_PROCESSES}
 * @param packageName The name of the package whose processes are to
 * be killed.
 * @apiSince 8
 */

public void killBackgroundProcesses(java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * Get the device configuration attributes.
 * @apiSince 3
 */

public android.content.pm.ConfigurationInfo getDeviceConfigurationInfo() { throw new RuntimeException("Stub!"); }

/**
 * Get the preferred density of icons for the launcher. This is used when
 * custom drawables are created (e.g., for shortcuts).
 *
 * @return density in terms of DPI
 * @apiSince 11
 */

public int getLauncherLargeIconDensity() { throw new RuntimeException("Stub!"); }

/**
 * Get the preferred launcher icon size. This is used when custom drawables
 * are created (e.g., for shortcuts).
 *
 * @return dimensions of square icons in terms of pixels
 * @apiSince 11
 */

public int getLauncherLargeIconSize() { throw new RuntimeException("Stub!"); }

/**
 * Returns "true" if the user interface is currently being messed with
 * by a monkey.
 * @apiSince 8
 */

public static boolean isUserAMonkey() { throw new RuntimeException("Stub!"); }

/**
 * Returns "true" if device is running in a test harness.
 *
 * @deprecated this method is false for all user builds. Users looking to check if their device
 * is running in a device farm should see {@link #isRunningInUserTestHarness()}.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public static boolean isRunningInTestHarness() { throw new RuntimeException("Stub!"); }

/**
 * Returns "true" if the device is running in Test Harness Mode.
 *
 * <p>Test Harness Mode is a feature that allows devices to run without human interaction in a
 * device farm/testing harness (such as Firebase Test Lab). You should check this method if you
 * want your app to behave differently when running in a test harness to skip setup screens that
 * would impede UI testing. e.g. a keyboard application that has a full screen setup page for
 * the first time it is launched.
 *
 * <p>Note that you should <em>not</em> use this to determine whether or not your app is running
 * an instrumentation test, as it is not set for a standard device running a test.
 * @apiSince 29
 */

public static boolean isRunningInUserTestHarness() { throw new RuntimeException("Stub!"); }

/**
 * Perform a system dump of various state associated with the given application
 * package name.  This call blocks while the dump is being performed, so should
 * not be done on a UI thread.  The data will be written to the given file
 * descriptor as text.
 * <br>
 * Requires {@link android.Manifest.permission#DUMP}
 * @param fd The file descriptor that the dump should be written to.  The file
 * descriptor is <em>not</em> closed by this function; the caller continues to
 * own it.
 * @param packageName The name of the package that is to be dumped.
 * @apiSince 19
 */

public void dumpPackageState(java.io.FileDescriptor fd, java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * Request that the system start watching for the calling process to exceed a pss
 * size as given here.  Once called, the system will look for any occasions where it
 * sees the associated process with a larger pss size and, when this happens, automatically
 * pull a heap dump from it and allow the user to share the data.  Note that this request
 * continues running even if the process is killed and restarted.  To remove the watch,
 * use {@link #clearWatchHeapLimit()}.
 *
 * <p>This API only works if the calling process has been marked as
 * {@link android.content.pm.ApplicationInfo#FLAG_DEBUGGABLE ApplicationInfo#FLAG_DEBUGGABLE} or this is running on a debuggable
 * (userdebug or eng) build.</p>
 *
 * <p>Callers can optionally implement {@link #ACTION_REPORT_HEAP_LIMIT} to directly
 * handle heap limit reports themselves.</p>
 *
 * @param pssSize The size in bytes to set the limit at.
 * @apiSince 23
 */

public void setWatchHeapLimit(long pssSize) { throw new RuntimeException("Stub!"); }

/**
 * Clear a heap watch limit previously set by {@link #setWatchHeapLimit(long)}.
 * @apiSince 23
 */

public void clearWatchHeapLimit() { throw new RuntimeException("Stub!"); }

/**
 * Return whether currently in lock task mode.  When in this mode
 * no new tasks can be created or switched to.
 *
 * @see android.app.Activity#startLockTask()
 *
 * @deprecated Use {@link #getLockTaskModeState} instead.
 * @apiSince 21
 * @deprecatedSince 23
 */

@Deprecated
public boolean isInLockTaskMode() { throw new RuntimeException("Stub!"); }

/**
 * Return the current state of task locking. The three possible outcomes
 * are {@link #LOCK_TASK_MODE_NONE}, {@link #LOCK_TASK_MODE_LOCKED}
 * and {@link #LOCK_TASK_MODE_PINNED}.
 *
 * @see android.app.Activity#startLockTask()
 * @apiSince 23
 */

public int getLockTaskModeState() { throw new RuntimeException("Stub!"); }

/**
 * Enable more aggressive scheduling for latency-sensitive low-runtime VR threads. Only one
 * thread can be a VR thread in a process at a time, and that thread may be subject to
 * restrictions on the amount of time it can run.
 *
 * If persistent VR mode is set, whatever thread has been granted aggressive scheduling via this
 * method will return to normal operation, and calling this method will do nothing while
 * persistent VR mode is enabled.
 *
 * To reset the VR thread for an application, a tid of 0 can be passed.
 *
 * @see android.os.Process#myTid()
 * @param tid tid of the VR thread
 * @apiSince 25
 */

public static void setVrThread(int tid) { throw new RuntimeException("Stub!"); }

/**
 * Action an app can implement to handle reports from {@link #setWatchHeapLimit(long)}.
 * If your package has an activity handling this action, it will be launched with the
 * heap data provided to it the same way as {@link android.content.Intent#ACTION_SEND Intent#ACTION_SEND}.  Note that to
 * match the activty must support this action and a MIME type of "*&#47;*".
 * @apiSince 23
 */

public static final java.lang.String ACTION_REPORT_HEAP_LIMIT = "android.app.action.REPORT_HEAP_LIMIT";

/**
 * Full lock task mode is active.
 * @apiSince 23
 */

public static final int LOCK_TASK_MODE_LOCKED = 1; // 0x1

/**
 * Lock task mode is not active.
 * @apiSince 23
 */

public static final int LOCK_TASK_MODE_NONE = 0; // 0x0

/**
 * App pinning mode is active.
 * @apiSince 23
 */

public static final int LOCK_TASK_MODE_PINNED = 2; // 0x2

/**
 * <a href="{@docRoot}guide/topics/manifest/meta-data-element.html">{@code
 * <meta-data>}</a> name for a 'home' Activity that declares a package that is to be
 * uninstalled in lieu of the declaring one.  The package named here must be
 * signed with the same certificate as the one declaring the {@code <meta-data>}.
 * @apiSince 19
 */

public static final java.lang.String META_HOME_ALTERNATE = "android.app.home.alternate";

/**
 * Flag for {@link #moveTaskToFront(int,int)}: don't count this as a
 * user-instigated action, so the current activity will not receive a
 * hint that the user is leaving.
 * @apiSince 12
 */

public static final int MOVE_TASK_NO_USER_ACTION = 2; // 0x2

/**
 * Flag for {@link #moveTaskToFront(int,int)}: also move the "home"
 * activity along with the task, so it is positioned immediately behind
 * the task.
 * @apiSince 11
 */

public static final int MOVE_TASK_WITH_HOME = 1; // 0x1

/**
 * Provides a list that does not contain any
 * recent tasks that currently are not available to the user.
 * @apiSince 11
 */

public static final int RECENT_IGNORE_UNAVAILABLE = 2; // 0x2

/**
 * Flag for use with {@link #getRecentTasks}: return all tasks, even those
 * that have set their
 * {@link android.content.Intent#FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS} flag.
 * @apiSince 1
 */

public static final int RECENT_WITH_EXCLUDED = 1; // 0x1
/**
 * The AppTask allows you to manage your own application's tasks.
 * See {@link android.app.ActivityManager#getAppTasks()}
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class AppTask {

AppTask() { throw new RuntimeException("Stub!"); }

/**
 * Finishes all activities in this task and removes it from the recent tasks list.
 * @apiSince 21
 */

public void finishAndRemoveTask() { throw new RuntimeException("Stub!"); }

/**
 * Get the RecentTaskInfo associated with this task.
 *
 * @return The RecentTaskInfo for this task, or null if the task no longer exists.
 * @apiSince 21
 */

public android.app.ActivityManager.RecentTaskInfo getTaskInfo() { throw new RuntimeException("Stub!"); }

/**
 * Bring this task to the foreground.  If it contains activities, they will be
 * brought to the foreground with it and their instances re-created if needed.
 * If it doesn't contain activities, the root activity of the task will be
 * re-launched.
 * @apiSince 21
 */

public void moveToFront() { throw new RuntimeException("Stub!"); }

/**
 * Start an activity in this task.  Brings the task to the foreground.  If this task
 * is not currently active (that is, its id < 0), then a new activity for the given
 * Intent will be launched as the root of the task and the task brought to the
 * foreground.  Otherwise, if this task is currently active and the Intent does not specify
 * an activity to launch in a new task, then a new activity for the given Intent will
 * be launched on top of the task and the task brought to the foreground.  If this
 * task is currently active and the Intent specifies {@link android.content.Intent#FLAG_ACTIVITY_NEW_TASK Intent#FLAG_ACTIVITY_NEW_TASK}
 * or would otherwise be launched in to a new task, then the activity not launched but
 * this task be brought to the foreground and a new intent delivered to the top
 * activity if appropriate.
 *
 * <p>In other words, you generally want to use an Intent here that does not specify
 * {@link android.content.Intent#FLAG_ACTIVITY_NEW_TASK Intent#FLAG_ACTIVITY_NEW_TASK} or {@link android.content.Intent#FLAG_ACTIVITY_NEW_DOCUMENT Intent#FLAG_ACTIVITY_NEW_DOCUMENT},
 * and let the system do the right thing.</p>
 *
 * @param intent The Intent describing the new activity to be launched on the task.
 * @param options Optional launch options.
 *
 * @see Activity#startActivity(android.content.Intent, android.os.Bundle)
 * @apiSince 21
 */

public void startActivity(android.content.Context context, android.content.Intent intent, android.os.Bundle options) { throw new RuntimeException("Stub!"); }

/**
 * Modify the {@link android.content.Intent#FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS Intent#FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS} flag in the root
 * Intent of this AppTask.
 *
 * @param exclude If true, {@link android.content.Intent#FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS Intent#FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS} will
 * be set; otherwise, it will be cleared.
 * @apiSince 21
 */

public void setExcludeFromRecents(boolean exclude) { throw new RuntimeException("Stub!"); }
}

/**
 * Information you can retrieve about the available memory through
 * {@link android.app.ActivityManager#getMemoryInfo ActivityManager#getMemoryInfo}.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class MemoryInfo implements android.os.Parcelable {

/** @apiSince 1 */

public MemoryInfo() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void readFromParcel(android.os.Parcel source) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.ActivityManager.MemoryInfo> CREATOR;
static { CREATOR = null; }

/**
 * The available memory on the system.  This number should not
 * be considered absolute: due to the nature of the kernel, a significant
 * portion of this memory is actually in use and needed for the overall
 * system to run well.
 * @apiSince 1
 */

public long availMem;

/**
 * Set to true if the system considers itself to currently be in a low
 * memory situation.
 * @apiSince 1
 */

public boolean lowMemory;

/**
 * The threshold of {@link #availMem} at which we consider memory to be
 * low and start killing background services and other non-extraneous
 * processes.
 * @apiSince 1
 */

public long threshold;

/**
 * The total memory accessible by the kernel.  This is basically the
 * RAM size of the device, not including below-kernel fixed allocations
 * like DMA buffers, RAM for the baseband CPU, etc.
 * @apiSince 16
 */

public long totalMem;
}

/**
 * Information you can retrieve about any processes that are in an error condition.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class ProcessErrorStateInfo implements android.os.Parcelable {

/** @apiSince 1 */

public ProcessErrorStateInfo() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void readFromParcel(android.os.Parcel source) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static final int CRASHED = 1; // 0x1

/** @apiSince 1 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.ActivityManager.ProcessErrorStateInfo> CREATOR;
static { CREATOR = null; }

/** @apiSince 1 */

public static final int NOT_RESPONDING = 2; // 0x2

/**
 * Condition codes
 * @apiSince 1
 */

public static final int NO_ERROR = 0; // 0x0

/**
 * The condition that the process is in.
 * @apiSince 1
 */

public int condition;

/**
 * to be deprecated: This value will always be null.
 * @apiSince 1
 */

public byte[] crashData;

/**
 * A long message describing the error condition.
 * @apiSince 1
 */

public java.lang.String longMsg;

/**
 * The pid of this process; 0 if none
 * @apiSince 1
 */

public int pid;

/**
 * The process name in which the crash or error occurred.
 * @apiSince 1
 */

public java.lang.String processName;

/**
 * A short message describing the error condition.
 * @apiSince 1
 */

public java.lang.String shortMsg;

/**
 * The stack trace where the error originated.  May be null.
 * @apiSince 8
 */

public java.lang.String stackTrace;

/**
 * The activity name associated with the error, if known.  May be null.
 * @apiSince 1
 */

public java.lang.String tag;

/**
 * The kernel user-ID that has been assigned to this process;
 * currently this is not a unique ID (multiple applications can have
 * the same uid).
 * @apiSince 1
 */

public int uid;
}

/**
 * Information you can retrieve about tasks that the user has most recently
 * started or visited.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class RecentTaskInfo extends android.app.TaskInfo implements android.os.Parcelable {

/** @apiSince 1 */

public RecentTaskInfo() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void readFromParcel(android.os.Parcel source) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.ActivityManager.RecentTaskInfo> CREATOR;
static { CREATOR = null; }

/**
 * Task affiliation for grouping with other tasks.
 *
 * @deprecated As of {@link android.os.Build.VERSION_CODES#Q}, currently always 0.
 * @apiSince 21
 * @deprecatedSince 29
 */

@Deprecated public int affiliatedTaskId;

/**
 * Description of the task's last state.
 *
 * @deprecated As of {@link android.os.Build.VERSION_CODES#Q}, currently always null.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated public java.lang.CharSequence description;

/**
 * If this task is currently running, this is the identifier for it.
 * If it is not running, this will be -1.
 *
 * @deprecated As of {@link android.os.Build.VERSION_CODES#Q}, use
 * {@link android.app.ActivityManager.RecentTaskInfo#taskId RecentTaskInfo#taskId} to get the task id and {@link android.app.ActivityManager.RecentTaskInfo#isRunning RecentTaskInfo#isRunning}
 * to determine if it is running.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public int id;

/**
 * The true identifier of this task, valid even if it is not running.
 *
 * @deprecated As of {@link android.os.Build.VERSION_CODES#Q}, use
 * {@link android.app.ActivityManager.RecentTaskInfo#taskId RecentTaskInfo#taskId}.
 * @apiSince 12
 * @deprecatedSince 29
 */

@Deprecated public int persistentId;
}

/**
 * Information you can retrieve about a running process.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class RunningAppProcessInfo implements android.os.Parcelable {

/** @apiSince 3 */

public RunningAppProcessInfo() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public RunningAppProcessInfo(java.lang.String pProcessName, int pPid, java.lang.String[] pArr) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void readFromParcel(android.os.Parcel source) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.ActivityManager.RunningAppProcessInfo> CREATOR;
static { CREATOR = null; }

/**
 * @deprecated Renamed to {@link #IMPORTANCE_CACHED}.
 * @apiSince 3
 * @deprecatedSince 26
 */

@Deprecated public static final int IMPORTANCE_BACKGROUND = 400; // 0x190

/**
 * Constant for {@link #importance}: This process process contains
 * cached code that is expendable, not actively running any app components
 * we care about.
 * @apiSince 26
 */

public static final int IMPORTANCE_CACHED = 400; // 0x190

/**
 * Constant for {@link #importance}: This process is running an
 * application that can not save its state, and thus can't be killed
 * while in the background.  This will be used with apps that have
 * {@link android.R.attr#cantSaveState} set on their application tag.
 * @apiSince 28
 */

public static final int IMPORTANCE_CANT_SAVE_STATE = 350; // 0x15e

/**
 * Constant for {@link #importance}: This process is empty of any
 * actively running code.
 * @deprecated This value is no longer reported, use {@link #IMPORTANCE_CACHED} instead.
 * @apiSince 3
 * @deprecatedSince 26
 */

@Deprecated public static final int IMPORTANCE_EMPTY = 500; // 0x1f4

/**
 * Constant for {@link #importance}: This process is running the
 * foreground UI; that is, it is the thing currently at the top of the screen
 * that the user is interacting with.
 * @apiSince 3
 */

public static final int IMPORTANCE_FOREGROUND = 100; // 0x64

/**
 * Constant for {@link #importance}: This process is running a foreground
 * service, for example to perform music playback even while the user is
 * not immediately in the app.  This generally indicates that the process
 * is doing something the user actively cares about.
 * @apiSince 23
 */

public static final int IMPORTANCE_FOREGROUND_SERVICE = 125; // 0x7d

/**
 * Constant for {@link #importance}: This process does not exist.
 * @apiSince 21
 */

public static final int IMPORTANCE_GONE = 1000; // 0x3e8

/**
 * Constant for {@link #importance}: This process is not something the user
 * is directly aware of, but is otherwise perceptible to them to some degree.
 * @apiSince 9
 */

public static final int IMPORTANCE_PERCEPTIBLE = 230; // 0xe6

/**
 * Constant for {@link #importance}: {@link #IMPORTANCE_PERCEPTIBLE} had this wrong value
 * before {@link android.os.Build.VERSION_CODES#O Build.VERSION_CODES#O}.  Since the {@link android.os.Build.VERSION_CODES#O Build.VERSION_CODES#O} SDK,
 * the value of {@link #IMPORTANCE_PERCEPTIBLE} has been fixed.
 *
 * <p>The system will return this value instead of {@link #IMPORTANCE_PERCEPTIBLE}
 * on Android versions below {@link android.os.Build.VERSION_CODES#O Build.VERSION_CODES#O}.
 *
 * <p>On Android version {@link android.os.Build.VERSION_CODES#O Build.VERSION_CODES#O} and later, this value will still be
 * returned for apps with the target API level below {@link android.os.Build.VERSION_CODES#O Build.VERSION_CODES#O}.
 * For apps targeting version {@link android.os.Build.VERSION_CODES#O Build.VERSION_CODES#O} and later,
 * the correct value {@link #IMPORTANCE_PERCEPTIBLE} will be returned.
 * @apiSince 26
 */

public static final int IMPORTANCE_PERCEPTIBLE_PRE_26 = 130; // 0x82

/**
 * Constant for {@link #importance}: This process is contains services
 * that should remain running.  These are background services apps have
 * started, not something the user is aware of, so they may be killed by
 * the system relatively freely (though it is generally desired that they
 * stay running as long as they want to).
 * @apiSince 3
 */

public static final int IMPORTANCE_SERVICE = 300; // 0x12c

/**
 * Constant for {@link #importance}: This process is running the foreground
 * UI, but the device is asleep so it is not visible to the user.  Though the
 * system will try hard to keep its process from being killed, in all other
 * ways we consider it a kind of cached process, with the limitations that go
 * along with that state: network access, running background services, etc.
 * @apiSince 23
 */

public static final int IMPORTANCE_TOP_SLEEPING = 325; // 0x145

/**
 * @deprecated Pre-{@link android.os.Build.VERSION_CODES#P} version of
 * {@link #IMPORTANCE_TOP_SLEEPING}.  As of Android
 * {@link android.os.Build.VERSION_CODES#P}, this is considered much less
 * important since we want to reduce what apps can do when the screen is off.
 * @apiSince 28
 * @deprecatedSince 28
 */

@Deprecated public static final int IMPORTANCE_TOP_SLEEPING_PRE_28 = 150; // 0x96

/**
 * Constant for {@link #importance}: This process is running something
 * that is actively visible to the user, though not in the immediate
 * foreground.  This may be running a window that is behind the current
 * foreground (so paused and with its state saved, not interacting with
 * the user, but visible to them to some degree); it may also be running
 * other services under the system's control that it inconsiders important.
 * @apiSince 3
 */

public static final int IMPORTANCE_VISIBLE = 200; // 0xc8

/**
 * Constant for {@link #importanceReasonCode}: one of the application's
 * content providers is being used by another process.  The pid of
 * the client process is in {@link #importanceReasonPid} and the
 * target provider in this process is in
 * {@link #importanceReasonComponent}.
 * @apiSince 5
 */

public static final int REASON_PROVIDER_IN_USE = 1; // 0x1

/**
 * Constant for {@link #importanceReasonCode}: one of the application's
 * content providers is being used by another process.  The pid of
 * the client process is in {@link #importanceReasonPid} and the
 * target provider in this process is in
 * {@link #importanceReasonComponent}.
 * @apiSince 5
 */

public static final int REASON_SERVICE_IN_USE = 2; // 0x2

/**
 * Constant for {@link #importanceReasonCode}: nothing special has
 * been specified for the reason for this level.
 * @apiSince 5
 */

public static final int REASON_UNKNOWN = 0; // 0x0

/**
 * The relative importance level that the system places on this process.
 * These constants are numbered so that "more important" values are
 * always smaller than "less important" values.
 
 * <br>
 * Value is {@link android.app.ActivityManager.RunningAppProcessInfo#IMPORTANCE_FOREGROUND}, {@link android.app.ActivityManager.RunningAppProcessInfo#IMPORTANCE_FOREGROUND_SERVICE}, {@link android.app.ActivityManager.RunningAppProcessInfo#IMPORTANCE_TOP_SLEEPING}, {@link android.app.ActivityManager.RunningAppProcessInfo#IMPORTANCE_VISIBLE}, {@link android.app.ActivityManager.RunningAppProcessInfo#IMPORTANCE_PERCEPTIBLE}, {@link android.app.ActivityManager.RunningAppProcessInfo#IMPORTANCE_CANT_SAVE_STATE}, {@link android.app.ActivityManager.RunningAppProcessInfo#IMPORTANCE_SERVICE}, {@link android.app.ActivityManager.RunningAppProcessInfo#IMPORTANCE_CACHED}, or {@link android.app.ActivityManager.RunningAppProcessInfo#IMPORTANCE_GONE}
 * @apiSince 3
 */

public int importance;

/**
 * The reason for {@link #importance}, if any.
 * @apiSince 5
 */

public int importanceReasonCode;

/**
 * For the specified values of {@link #importanceReasonCode}, this
 * is the name of the component that is being used in this process.
 * @apiSince 5
 */

public android.content.ComponentName importanceReasonComponent;

/**
 * For the specified values of {@link #importanceReasonCode}, this
 * is the process ID of the other process that is a client of this
 * process.  This will be 0 if no other process is using this one.
 * @apiSince 5
 */

public int importanceReasonPid;

/**
 * Last memory trim level reported to the process: corresponds to
 * the values supplied to {@link android.content.ComponentCallbacks2#onTrimMemory(int)
 * ComponentCallbacks2.onTrimMemory(int)}.
 * @apiSince 16
 */

public int lastTrimLevel;

/**
 * An additional ordering within a particular {@link #importance}
 * category, providing finer-grained information about the relative
 * utility of processes within a category.  This number means nothing
 * except that a smaller values are more recently used (and thus
 * more important).  Currently an LRU value is only maintained for
 * the {@link #IMPORTANCE_CACHED} category, though others may
 * be maintained in the future.
 * @apiSince 3
 */

public int lru;

/**
 * The pid of this process; 0 if none
 * @apiSince 3
 */

public int pid;

/**
 * All packages that have been loaded into the process.
 * @apiSince 3
 */

public java.lang.String[] pkgList;

/**
 * The name of the process that this object is associated with
 * @apiSince 3
 */

public java.lang.String processName;

/**
 * The user id of this process.
 * @apiSince 5
 */

public int uid;
}

/**
 * Information you can retrieve about a particular Service that is
 * currently running in the system.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class RunningServiceInfo implements android.os.Parcelable {

/** @apiSince 1 */

public RunningServiceInfo() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void readFromParcel(android.os.Parcel source) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.ActivityManager.RunningServiceInfo> CREATOR;
static { CREATOR = null; }

/**
 * Bit for {@link #flags}: set if the service has asked to
 * run as a foreground process.
 * @apiSince 5
 */

public static final int FLAG_FOREGROUND = 2; // 0x2

/**
 * Bit for {@link #flags}: set if the service is running in a
 * persistent process.
 * @apiSince 5
 */

public static final int FLAG_PERSISTENT_PROCESS = 8; // 0x8

/**
 * Bit for {@link #flags}: set if this service has been
 * explicitly started.
 * @apiSince 5
 */

public static final int FLAG_STARTED = 1; // 0x1

/**
 * Bit for {@link #flags}: set if the service is running in a
 * core system process.
 * @apiSince 5
 */

public static final int FLAG_SYSTEM_PROCESS = 4; // 0x4

/**
 * The time when the service was first made active, either by someone
 * starting or binding to it.  This
 * is in units of {@link android.os.SystemClock#elapsedRealtime()}.
 * @apiSince 1
 */

public long activeSince;

/**
 * Number of clients connected to the service.
 * @apiSince 1
 */

public int clientCount;

/**
 * For special services that are bound to by system code, this is
 * a string resource providing a user-visible label for who the
 * client is.
 * @apiSince 5
 */

public int clientLabel;

/**
 * For special services that are bound to by system code, this is
 * the package that holds the binding.
 * @apiSince 5
 */

public java.lang.String clientPackage;

/**
 * Number of times the service's process has crashed while the service
 * is running.
 * @apiSince 1
 */

public int crashCount;

/**
 * Running flags.
 * @apiSince 5
 */

public int flags;

/**
 * Set to true if the service has asked to run as a foreground process.
 * @apiSince 1
 */

public boolean foreground;

/**
 * The time when there was last activity in the service (either
 * explicit requests to start it or clients binding to it).  This
 * is in units of {@link android.os.SystemClock#uptimeMillis()}.
 * @apiSince 1
 */

public long lastActivityTime;

/**
 * If non-zero, this is the process the service is running in.
 * @apiSince 1
 */

public int pid;

/**
 * The name of the process this service runs in.
 * @apiSince 1
 */

public java.lang.String process;

/**
 * If non-zero, this service is not currently running, but scheduled to
 * restart at the given time.
 * @apiSince 1
 */

public long restarting;

/**
 * The service component.
 * @apiSince 1
 */

public android.content.ComponentName service;

/**
 * Set to true if this service has been explicitly started.
 * @apiSince 1
 */

public boolean started;

/**
 * The UID that owns this service.
 * @apiSince 5
 */

public int uid;
}

/**
 * Information you can retrieve about a particular task that is currently
 * "running" in the system.  Note that a running task does not mean the
 * given task actually has a process it is actively running in; it simply
 * means that the user has gone to it and never closed it, but currently
 * the system may have killed its process and is only holding on to its
 * last state in order to restart it when the user returns.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class RunningTaskInfo extends android.app.TaskInfo implements android.os.Parcelable {

/** @apiSince 1 */

public RunningTaskInfo() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void readFromParcel(android.os.Parcel source) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.ActivityManager.RunningTaskInfo> CREATOR;
static { CREATOR = null; }

/**
 * Description of the task's current state.
 *
 * @deprecated As of {@link android.os.Build.VERSION_CODES#Q}, currently always null.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public java.lang.CharSequence description;

/**
 * A unique identifier for this task.
 *
 * @deprecated As of {@link android.os.Build.VERSION_CODES#Q}, use
 * {@link android.app.ActivityManager.RunningTaskInfo#taskId RunningTaskInfo#taskId}.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public int id;

/**
 * Number of activities that are currently running (not stopped and persisted) in this task.
 *
 * @deprecated As of {@link android.os.Build.VERSION_CODES#Q}, currently always 0.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public int numRunning;

/**
 * Thumbnail representation of the task's current state.
 *
 * @deprecated As of {@link android.os.Build.VERSION_CODES#Q}, currently always null.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public android.graphics.Bitmap thumbnail;
}

/**
 * Information you can set and retrieve about the current activity within the recent task list.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class TaskDescription implements android.os.Parcelable {

/**
 * Creates the TaskDescription to the specified values.
 *
 * @param label A label and description of the current state of this task.
 * @param icon An icon that represents the current state of this task.
 * @param colorPrimary A color to override the theme's primary color.  This color must be
 *                     opaque.
 * @deprecated use TaskDescription constructor with icon resource instead
 * @apiSince 21
 */

@Deprecated
public TaskDescription(java.lang.String label, android.graphics.Bitmap icon, int colorPrimary) { throw new RuntimeException("Stub!"); }

/**
 * Creates the TaskDescription to the specified values.
 *
 * @param label A label and description of the current state of this task.
 * @param iconRes A drawable resource of an icon that represents the current state of this
 *                activity.
 * @param colorPrimary A color to override the theme's primary color.  This color must be
 *                     opaque.
 * @apiSince 28
 */

public TaskDescription(java.lang.String label, int iconRes, int colorPrimary) { throw new RuntimeException("Stub!"); }

/**
 * Creates the TaskDescription to the specified values.
 *
 * @param label A label and description of the current state of this activity.
 * @param icon An icon that represents the current state of this activity.
 * @deprecated use TaskDescription constructor with icon resource instead
 * @apiSince 21
 */

@Deprecated
public TaskDescription(java.lang.String label, android.graphics.Bitmap icon) { throw new RuntimeException("Stub!"); }

/**
 * Creates the TaskDescription to the specified values.
 *
 * @param label A label and description of the current state of this activity.
 * @param iconRes A drawable resource of an icon that represents the current state of this
 *                activity.
 * @apiSince 28
 */

public TaskDescription(java.lang.String label, int iconRes) { throw new RuntimeException("Stub!"); }

/**
 * Creates the TaskDescription to the specified values.
 *
 * @param label A label and description of the current state of this activity.
 * @apiSince 21
 */

public TaskDescription(java.lang.String label) { throw new RuntimeException("Stub!"); }

/**
 * Creates an empty TaskDescription.
 * @apiSince 21
 */

public TaskDescription() { throw new RuntimeException("Stub!"); }

/**
 * Creates a copy of another TaskDescription.
 * @apiSince 21
 */

public TaskDescription(android.app.ActivityManager.TaskDescription td) { throw new RuntimeException("Stub!"); }

/**
 * @return The label and description of the current state of this task.
 * @apiSince 21
 */

public java.lang.String getLabel() { throw new RuntimeException("Stub!"); }

/**
 * @return The icon that represents the current state of this task.
 * @apiSince 21
 */

public android.graphics.Bitmap getIcon() { throw new RuntimeException("Stub!"); }

/**
 * @return The color override on the theme's primary color.
 * @apiSince 21
 */

public int getPrimaryColor() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void readFromParcel(android.os.Parcel source) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.ActivityManager.TaskDescription> CREATOR;
static { CREATOR = null; }
}

}

