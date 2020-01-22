/*
 * Copyright (C) 2012 The Android Open Source Project
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

import android.content.Context;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.transition.Transition;
import android.graphics.Rect;
import android.content.ComponentName;

/**
 * Helper class for building an options Bundle that can be used with
 * {@link android.content.Context#startActivity(android.content.Intent, android.os.Bundle)
 * Context.startActivity(Intent, Bundle)} and related methods.
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ActivityOptions {

ActivityOptions() { throw new RuntimeException("Stub!"); }

/**
 * Create an ActivityOptions specifying a custom animation to run when
 * the activity is displayed.
 *
 * @param context Who is defining this.  This is the application that the
 * animation resources will be loaded from.
 * @param enterResId A resource ID of the animation resource to use for
 * the incoming activity.  Use 0 for no animation.
 * @param exitResId A resource ID of the animation resource to use for
 * the outgoing activity.  Use 0 for no animation.
 * @return Returns a new ActivityOptions object that you can use to
 * supply these options as the options Bundle when starting an activity.
 * @apiSince 16
 */

public static android.app.ActivityOptions makeCustomAnimation(android.content.Context context, int enterResId, int exitResId) { throw new RuntimeException("Stub!"); }

/**
 * Create an ActivityOptions specifying an animation where the new
 * activity is scaled from a small originating area of the screen to
 * its final full representation.
 *
 * <p>If the Intent this is being used with has not set its
 * {@link android.content.Intent#setSourceBounds Intent.setSourceBounds},
 * those bounds will be filled in for you based on the initial
 * bounds passed in here.
 *
 * @param source The View that the new activity is animating from.  This
 * defines the coordinate space for <var>startX</var> and <var>startY</var>.
 * @param startX The x starting location of the new activity, relative to <var>source</var>.
 * @param startY The y starting location of the activity, relative to <var>source</var>.
 * @param width The initial width of the new activity.
 * @param height The initial height of the new activity.
 * @return Returns a new ActivityOptions object that you can use to
 * supply these options as the options Bundle when starting an activity.
 * @apiSince 16
 */

public static android.app.ActivityOptions makeScaleUpAnimation(android.view.View source, int startX, int startY, int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * Create an ActivityOptions specifying an animation where the new
 * activity is revealed from a small originating area of the screen to
 * its final full representation.
 *
 * @param source The View that the new activity is animating from.  This
 * defines the coordinate space for <var>startX</var> and <var>startY</var>.
 * @param startX The x starting location of the new activity, relative to <var>source</var>.
 * @param startY The y starting location of the activity, relative to <var>source</var>.
 * @param width The initial width of the new activity.
 * @param height The initial height of the new activity.
 * @return Returns a new ActivityOptions object that you can use to
 * supply these options as the options Bundle when starting an activity.
 * @apiSince 23
 */

public static android.app.ActivityOptions makeClipRevealAnimation(android.view.View source, int startX, int startY, int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * Create an ActivityOptions specifying an animation where a thumbnail
 * is scaled from a given position to the new activity window that is
 * being started.
 *
 * <p>If the Intent this is being used with has not set its
 * {@link android.content.Intent#setSourceBounds Intent.setSourceBounds},
 * those bounds will be filled in for you based on the initial
 * thumbnail location and size provided here.
 *
 * @param source The View that this thumbnail is animating from.  This
 * defines the coordinate space for <var>startX</var> and <var>startY</var>.
 * @param thumbnail The bitmap that will be shown as the initial thumbnail
 * of the animation.
 * @param startX The x starting location of the bitmap, relative to <var>source</var>.
 * @param startY The y starting location of the bitmap, relative to <var>source</var>.
 * @return Returns a new ActivityOptions object that you can use to
 * supply these options as the options Bundle when starting an activity.
 * @apiSince 16
 */

public static android.app.ActivityOptions makeThumbnailScaleUpAnimation(android.view.View source, android.graphics.Bitmap thumbnail, int startX, int startY) { throw new RuntimeException("Stub!"); }

/**
 * Create an ActivityOptions to transition between Activities using cross-Activity scene
 * animations. This method carries the position of one shared element to the started Activity.
 * The position of <code>sharedElement</code> will be used as the epicenter for the
 * exit Transition. The position of the shared element in the launched Activity will be the
 * epicenter of its entering Transition.
 *
 * <p>This requires {@link android.view.Window#FEATURE_ACTIVITY_TRANSITIONS} to be
 * enabled on the calling Activity to cause an exit transition. The same must be in
 * the called Activity to get an entering transition.</p>
 * @param activity The Activity whose window contains the shared elements.
 * @param sharedElement The View to transition to the started Activity.
 * @param sharedElementName The shared element name as used in the target Activity. This
 *                          must not be null.
 * @return Returns a new ActivityOptions object that you can use to
 *         supply these options as the options Bundle when starting an activity.
 * @see android.transition.Transition#setEpicenterCallback(
 *          android.transition.Transition.EpicenterCallback)
 * @apiSince 21
 */

public static android.app.ActivityOptions makeSceneTransitionAnimation(android.app.Activity activity, android.view.View sharedElement, java.lang.String sharedElementName) { throw new RuntimeException("Stub!"); }

/**
 * Create an ActivityOptions to transition between Activities using cross-Activity scene
 * animations. This method carries the position of multiple shared elements to the started
 * Activity. The position of the first element in sharedElements
 * will be used as the epicenter for the exit Transition. The position of the associated
 * shared element in the launched Activity will be the epicenter of its entering Transition.
 *
 * <p>This requires {@link android.view.Window#FEATURE_ACTIVITY_TRANSITIONS} to be
 * enabled on the calling Activity to cause an exit transition. The same must be in
 * the called Activity to get an entering transition.</p>
 * @param activity The Activity whose window contains the shared elements.
 * @param sharedElements The names of the shared elements to transfer to the called
 *                       Activity and their associated Views. The Views must each have
 *                       a unique shared element name.
 * @return Returns a new ActivityOptions object that you can use to
 *         supply these options as the options Bundle when starting an activity.
 * @see android.transition.Transition#setEpicenterCallback(
 *          android.transition.Transition.EpicenterCallback)
 * @apiSince 21
 */

@java.lang.SafeVarargs
public static android.app.ActivityOptions makeSceneTransitionAnimation(android.app.Activity activity, android.util.Pair<android.view.View,java.lang.String>... sharedElements) { throw new RuntimeException("Stub!"); }

/**
 * If set along with Intent.FLAG_ACTIVITY_NEW_DOCUMENT then the task being launched will not be
 * presented to the user but will instead be only available through the recents task list.
 * In addition, the new task wil be affiliated with the launching activity's task.
 * Affiliated tasks are grouped together in the recents task list.
 *
 * <p>This behavior is not supported for activities with {@link
 * android.R.styleable#AndroidManifestActivity_launchMode launchMode} values of
 * <code>singleInstance</code> or <code>singleTask</code>.
 * @apiSince 21
 */

public static android.app.ActivityOptions makeTaskLaunchBehind() { throw new RuntimeException("Stub!"); }

/**
 * Create a basic ActivityOptions that has no special animation associated with it.
 * Other options can still be set.
 * @apiSince 23
 */

public static android.app.ActivityOptions makeBasic() { throw new RuntimeException("Stub!"); }

/**
 * Sets the bounds (window size and position) that the activity should be launched in.
 * Rect position should be provided in pixels and in screen coordinates.
 * Set to {@code null} to explicitly launch fullscreen.
 * <p>
 * <strong>NOTE:</strong> This value is ignored on devices that don't have
 * {@link android.content.pm.PackageManager#FEATURE_FREEFORM_WINDOW_MANAGEMENT} or
 * {@link android.content.pm.PackageManager#FEATURE_PICTURE_IN_PICTURE} enabled.
 * @param screenSpacePixelRect launch bounds or {@code null} for fullscreen
 * This value may be {@code null}.
 * @return {@code this} {@link android.app.ActivityOptions ActivityOptions} instance
 * @apiSince 24
 */

public android.app.ActivityOptions setLaunchBounds(@androidx.annotation.Nullable android.graphics.Rect screenSpacePixelRect) { throw new RuntimeException("Stub!"); }

/**
 * Returns the bounds that should be used to launch the activity.
 * @see #setLaunchBounds(Rect)
 * @return Bounds used to launch the activity.
 
 * This value may be {@code null}.
 * @apiSince 24
 */

@androidx.annotation.Nullable
public android.graphics.Rect getLaunchBounds() { throw new RuntimeException("Stub!"); }

/**
 * Gets whether the activity is to be launched into LockTask mode.
 * @return {@code true} if the activity is to be launched into LockTask mode.
 * @see android.app.Activity#startLockTask()
 * @see android.app.admin.DevicePolicyManager#setLockTaskPackages(ComponentName, String[])
 * @apiSince 28
 */

public boolean getLockTaskMode() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the activity is to be launched into LockTask mode.
 *
 * Use this option to start an activity in LockTask mode. Note that only apps permitted by
 * {@link android.app.admin.DevicePolicyManager} can run in LockTask mode. Therefore, if
 * {@link android.app.admin.DevicePolicyManager#isLockTaskPermitted(String)} returns
 * {@code false} for the package of the target activity, a {@link java.lang.SecurityException SecurityException} will be
 * thrown during {@link android.content.Context#startActivity(android.content.Intent,android.os.Bundle) Context#startActivity(Intent, Bundle)}. This method doesn't affect
 * activities that are already running — relaunch the activity to run in lock task mode.
 *
 * Defaults to {@code false} if not set.
 *
 * @param lockTaskMode {@code true} if the activity is to be launched into LockTask mode.
 * @return {@code this} {@link android.app.ActivityOptions ActivityOptions} instance.
 * @see android.app.Activity#startLockTask()
 * @see android.app.admin.DevicePolicyManager#setLockTaskPackages(ComponentName, String[])
 * @apiSince 28
 */

public android.app.ActivityOptions setLockTaskEnabled(boolean lockTaskMode) { throw new RuntimeException("Stub!"); }

/**
 * Gets the id of the display where activity should be launched.
 * @return The id of the display where activity should be launched,
 *         {@link android.view.Display#INVALID_DISPLAY} if not set.
 * @see #setLaunchDisplayId(int)
 * @apiSince 26
 */

public int getLaunchDisplayId() { throw new RuntimeException("Stub!"); }

/**
 * Sets the id of the display where activity should be launched.
 * An app can launch activities on public displays or private displays that are owned by the app
 * or where an app already has activities. Otherwise, trying to launch on a private display
 * or providing an invalid display id will result in an exception.
 * <p>
 * Setting launch display id will be ignored on devices that don't have
 * {@link android.content.pm.PackageManager#FEATURE_ACTIVITIES_ON_SECONDARY_DISPLAYS}.
 * @param launchDisplayId The id of the display where the activity should be launched.
 * @return {@code this} {@link android.app.ActivityOptions ActivityOptions} instance.
 * @apiSince 26
 */

public android.app.ActivityOptions setLaunchDisplayId(int launchDisplayId) { throw new RuntimeException("Stub!"); }

/**
 * Update the current values in this ActivityOptions from those supplied
 * in <var>otherOptions</var>.  Any values
 * defined in <var>otherOptions</var> replace those in the base options.
 * @apiSince 16
 */

public void update(android.app.ActivityOptions otherOptions) { throw new RuntimeException("Stub!"); }

/**
 * Returns the created options as a Bundle, which can be passed to
 * {@link android.content.Context#startActivity(android.content.Intent, android.os.Bundle)
 * Context.startActivity(Intent, Bundle)} and related methods.
 * Note that the returned Bundle is still owned by the ActivityOptions
 * object; you must not modify it, but can supply it to the startActivity
 * methods that take an options Bundle.
 * @apiSince 16
 */

public android.os.Bundle toBundle() { throw new RuntimeException("Stub!"); }

/**
 * Ask the system track that time the user spends in the app being launched, and
 * report it back once done.  The report will be sent to the given receiver, with
 * the extras {@link #EXTRA_USAGE_TIME_REPORT} and {@link #EXTRA_USAGE_TIME_REPORT_PACKAGES}
 * filled in.
 *
 * <p>The time interval tracked is from launching this activity until the user leaves
 * that activity's flow.  They are considered to stay in the flow as long as
 * new activities are being launched or returned to from the original flow,
 * even if this crosses package or task boundaries.  For example, if the originator
 * starts an activity to view an image, and while there the user selects to share,
 * which launches their email app in a new task, and they complete the share, the
 * time during that entire operation will be included until they finally hit back from
 * the original image viewer activity.</p>
 *
 * <p>The user is considered to complete a flow once they switch to another
 * activity that is not part of the tracked flow.  This may happen, for example, by
 * using the notification shade, launcher, or recents to launch or switch to another
 * app.  Simply going in to these navigation elements does not break the flow (although
 * the launcher and recents stops time tracking of the session); it is the act of
 * going somewhere else that completes the tracking.</p>
 *
 * @param receiver A broadcast receiver that willl receive the report.
 * @apiSince 23
 */

public void requestUsageTimeReport(android.app.PendingIntent receiver) { throw new RuntimeException("Stub!"); }

/**
 * Set the {@link android.os.Bundle Bundle} that is provided to the app installer for additional verification
 * if the call to {@link android.content.Context#startActivity Context#startActivity} results in an app being installed.
 *
 * This Bundle is not provided to any other app besides the installer.
 * @apiSince 26
 */

public android.app.ActivityOptions setAppVerificationBundle(android.os.Bundle bundle) { throw new RuntimeException("Stub!"); }

/** @hide */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * A long in the extras delivered by {@link #requestUsageTimeReport} that contains
 * the total time (in ms) the user spent in the app flow.
 * @apiSince 23
 */

public static final java.lang.String EXTRA_USAGE_TIME_REPORT = "android.activity.usage_time";

/**
 * A Bundle in the extras delivered by {@link #requestUsageTimeReport} that contains
 * detailed information about the time spent in each package associated with the app;
 * each key is a package name, whose value is a long containing the time (in ms).
 * @apiSince 23
 */

public static final java.lang.String EXTRA_USAGE_TIME_REPORT_PACKAGES = "android.usage_time_packages";
}

