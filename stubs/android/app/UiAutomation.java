/*
 * Copyright (C) 2013 The Android Open Source Project
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

import android.view.InputEvent;
import android.view.accessibility.AccessibilityEvent;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.concurrent.TimeoutException;
import android.view.accessibility.AccessibilityWindowInfo;
import android.view.WindowContentFrameStats;
import android.view.WindowAnimationFrameStats;

/**
 * Class for interacting with the device's UI by simulation user actions and
 * introspection of the screen content. It relies on the platform accessibility
 * APIs to introspect the screen and to perform some actions on the remote view
 * tree. It also allows injecting of arbitrary raw input events simulating user
 * interaction with keyboards and touch devices. One can think of a UiAutomation
 * as a special type of {@link android.accessibilityservice.AccessibilityService}
 * which does not provide hooks for the service life cycle and exposes other
 * APIs that are useful for UI test automation.
 * <p>
 * The APIs exposed by this class are low-level to maximize flexibility when
 * developing UI test automation tools and libraries. Generally, a UiAutomation
 * client should be using a higher-level library or implement high-level functions.
 * For example, performing a tap on the screen requires construction and injecting
 * of a touch down and up events which have to be delivered to the system by a
 * call to {@link #injectInputEvent(android.view.InputEvent,boolean)}.
 * </p>
 * <p>
 * The APIs exposed by this class operate across applications enabling a client
 * to write tests that cover use cases spanning over multiple applications. For
 * example, going to the settings application to change a setting and then
 * interacting with another application whose behavior depends on that setting.
 * </p>
 * @apiSince 18
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class UiAutomation {

UiAutomation() { throw new RuntimeException("Stub!"); }

/**
 * Sets a callback for observing the stream of {@link android.view.accessibility.AccessibilityEvent AccessibilityEvent}s.
 * The callbacks are delivered on the main application thread.
 *
 * @param listener The callback.
 * @apiSince 18
 */

public void setOnAccessibilityEventListener(android.app.UiAutomation.OnAccessibilityEventListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Adopt the permission identity of the shell UID for all permissions. This allows
 * you to call APIs protected permissions which normal apps cannot hold but are
 * granted to the shell UID. If you already adopted all shell permissions by calling
 * this method or {@link #adoptShellPermissionIdentity(java.lang.String...)} a subsequent call
 * would be a no-op. Note that your permission state becomes that of the shell UID
 * and it is not a combination of your and the shell UID permissions.
 * <p>
 * <strong>Note:<strong/> Calling this method adopts all shell permissions and overrides
 * any subset of adopted permissions via {@link #adoptShellPermissionIdentity(java.lang.String...)}.
 *
 * @see #adoptShellPermissionIdentity(String...)
 * @see #dropShellPermissionIdentity()
 * @apiSince 29
 */

public void adoptShellPermissionIdentity() { throw new RuntimeException("Stub!"); }

/**
 * Adopt the permission identity of the shell UID only for the provided permissions.
 * This allows you to call APIs protected permissions which normal apps cannot hold
 * but are granted to the shell UID. If you already adopted the specified shell
 * permissions by calling this method or {@link #adoptShellPermissionIdentity()} a
 * subsequent call would be a no-op. Note that your permission state becomes that of the
 * shell UID and it is not a combination of your and the shell UID permissions.
 * <p>
 * <strong>Note:<strong/> Calling this method adopts only the specified shell permissions
 * and overrides all adopted permissions via {@link #adoptShellPermissionIdentity()}.
 *
 * @param permissions The permissions to adopt or <code>null</code> to adopt all.
 *
 * This value may be {@code null}.
 * @see #adoptShellPermissionIdentity()
 * @see #dropShellPermissionIdentity()
 * @apiSince 29
 */

public void adoptShellPermissionIdentity(@androidx.annotation.Nullable java.lang.String... permissions) { throw new RuntimeException("Stub!"); }

/**
 * Drop the shell permission identity adopted by a previous call to
 * {@link #adoptShellPermissionIdentity()}. If you did not adopt the shell permission
 * identity this method would be a no-op.
 *
 * @see #adoptShellPermissionIdentity()
 * @apiSince 29
 */

public void dropShellPermissionIdentity() { throw new RuntimeException("Stub!"); }

/**
 * Performs a global action. Such an action can be performed at any moment
 * regardless of the current application or user location in that application.
 * For example going back, going home, opening recents, etc.
 *
 * @param action The action to perform.
 * @return Whether the action was successfully performed.
 *
 * @see android.accessibilityservice.AccessibilityService#GLOBAL_ACTION_BACK
 * @see android.accessibilityservice.AccessibilityService#GLOBAL_ACTION_HOME
 * @see android.accessibilityservice.AccessibilityService#GLOBAL_ACTION_NOTIFICATIONS
 * @see android.accessibilityservice.AccessibilityService#GLOBAL_ACTION_RECENTS
 * @apiSince 18
 */

public boolean performGlobalAction(int action) { throw new RuntimeException("Stub!"); }

/**
 * Find the view that has the specified focus type. The search is performed
 * across all windows.
 * <p>
 * <strong>Note:</strong> In order to access the windows you have to opt-in
 * to retrieve the interactive windows by setting the
 * {@link android.accessibilityservice.AccessibilityServiceInfo#FLAG_RETRIEVE_INTERACTIVE_WINDOWS AccessibilityServiceInfo#FLAG_RETRIEVE_INTERACTIVE_WINDOWS} flag.
 * Otherwise, the search will be performed only in the active window.
 * </p>
 *
 * @param focus The focus to find. One of {@link android.view.accessibility.AccessibilityNodeInfo#FOCUS_INPUT AccessibilityNodeInfo#FOCUS_INPUT} or
 *         {@link android.view.accessibility.AccessibilityNodeInfo#FOCUS_ACCESSIBILITY AccessibilityNodeInfo#FOCUS_ACCESSIBILITY}.
 * @return The node info of the focused view or null.
 *
 * @see android.view.accessibility.AccessibilityNodeInfo#FOCUS_INPUT
 * @see android.view.accessibility.AccessibilityNodeInfo#FOCUS_ACCESSIBILITY
 * @apiSince 21
 */

public android.view.accessibility.AccessibilityNodeInfo findFocus(int focus) { throw new RuntimeException("Stub!"); }

/**
 * Gets the an {@link android.accessibilityservice.AccessibilityServiceInfo AccessibilityServiceInfo} describing this UiAutomation.
 * This method is useful if one wants to change some of the dynamically
 * configurable properties at runtime.
 *
 * @return The accessibility service info.
 *
 * @see android.accessibilityservice.AccessibilityServiceInfo
 * @apiSince 18
 */

public android.accessibilityservice.AccessibilityServiceInfo getServiceInfo() { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link android.accessibilityservice.AccessibilityServiceInfo AccessibilityServiceInfo} that describes how this
 * UiAutomation will be handled by the platform accessibility layer.
 *
 * @param info The info.
 *
 * @see android.accessibilityservice.AccessibilityServiceInfo
 * @apiSince 18
 */

public void setServiceInfo(android.accessibilityservice.AccessibilityServiceInfo info) { throw new RuntimeException("Stub!"); }

/**
 * Gets the windows on the screen. This method returns only the windows
 * that a sighted user can interact with, as opposed to all windows.
 * For example, if there is a modal dialog shown and the user cannot touch
 * anything behind it, then only the modal window will be reported
 * (assuming it is the top one). For convenience the returned windows
 * are ordered in a descending layer order, which is the windows that
 * are higher in the Z-order are reported first.
 * <p>
 * <strong>Note:</strong> In order to access the windows you have to opt-in
 * to retrieve the interactive windows by setting the
 * {@link android.accessibilityservice.AccessibilityServiceInfo#FLAG_RETRIEVE_INTERACTIVE_WINDOWS AccessibilityServiceInfo#FLAG_RETRIEVE_INTERACTIVE_WINDOWS} flag.
 * </p>
 *
 * @return The windows if there are windows such, otherwise an empty list.
 * @apiSince 21
 */

public java.util.List<android.view.accessibility.AccessibilityWindowInfo> getWindows() { throw new RuntimeException("Stub!"); }

/**
 * Gets the root {@link android.view.accessibility.AccessibilityNodeInfo AccessibilityNodeInfo} in the active window.
 *
 * @return The root info.
 * @apiSince 18
 */

public android.view.accessibility.AccessibilityNodeInfo getRootInActiveWindow() { throw new RuntimeException("Stub!"); }

/**
 * A method for injecting an arbitrary input event.
 * <p>
 * <strong>Note:</strong> It is caller's responsibility to recycle the event.
 * </p>
 * @param event The event to inject.
 * @param sync Whether to inject the event synchronously.
 * @return Whether event injection succeeded.
 * @apiSince 18
 */

public boolean injectInputEvent(android.view.InputEvent event, boolean sync) { throw new RuntimeException("Stub!"); }

/**
 * Sets the device rotation. A client can freeze the rotation in
 * desired state or freeze the rotation to its current state or
 * unfreeze the rotation (rotating the device changes its rotation
 * state).
 *
 * @param rotation The desired rotation.
 * @return Whether the rotation was set successfully.
 *
 * @see #ROTATION_FREEZE_0
 * @see #ROTATION_FREEZE_90
 * @see #ROTATION_FREEZE_180
 * @see #ROTATION_FREEZE_270
 * @see #ROTATION_FREEZE_CURRENT
 * @see #ROTATION_UNFREEZE
 * @apiSince 18
 */

public boolean setRotation(int rotation) { throw new RuntimeException("Stub!"); }

/**
 * Executes a command and waits for a specific accessibility event up to a
 * given wait timeout. To detect a sequence of events one can implement a
 * filter that keeps track of seen events of the expected sequence and
 * returns true after the last event of that sequence is received.
 * <p>
 * <strong>Note:</strong> It is caller's responsibility to recycle the returned event.
 * </p>
 * @param command The command to execute.
 * @param filter Filter that recognizes the expected event.
 * @param timeoutMillis The wait timeout in milliseconds.
 *
 * @throws java.util.concurrent.TimeoutException If the expected event is not received within the timeout.
 * @apiSince 18
 */

public android.view.accessibility.AccessibilityEvent executeAndWaitForEvent(java.lang.Runnable command, android.app.UiAutomation.AccessibilityEventFilter filter, long timeoutMillis) throws java.util.concurrent.TimeoutException { throw new RuntimeException("Stub!"); }

/**
 * Waits for the accessibility event stream to become idle, which is not to
 * have received an accessibility event within <code>idleTimeoutMillis</code>.
 * The total time spent to wait for an idle accessibility event stream is bounded
 * by the <code>globalTimeoutMillis</code>.
 *
 * @param idleTimeoutMillis The timeout in milliseconds between two events
 *            to consider the device idle.
 * @param globalTimeoutMillis The maximal global timeout in milliseconds in
 *            which to wait for an idle state.
 *
 * @throws java.util.concurrent.TimeoutException If no idle state was detected within
 *            <code>globalTimeoutMillis.</code>
 * @apiSince 18
 */

public void waitForIdle(long idleTimeoutMillis, long globalTimeoutMillis) throws java.util.concurrent.TimeoutException { throw new RuntimeException("Stub!"); }

/**
 * Takes a screenshot.
 *
 * @return The screenshot bitmap on success, null otherwise.
 * @apiSince 18
 */

public android.graphics.Bitmap takeScreenshot() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this UiAutomation to run in a "monkey" mode. Applications can query whether
 * they are executed in a "monkey" mode, i.e. run by a test framework, and avoid doing
 * potentially undesirable actions such as calling 911 or posting on public forums etc.
 *
 * @param enable whether to run in a "monkey" mode or not. Default is not.
 * @see android.app.ActivityManager#isUserAMonkey()
 * @apiSince 18
 */

public void setRunAsMonkey(boolean enable) { throw new RuntimeException("Stub!"); }

/**
 * Clears the frame statistics for the content of a given window. These
 * statistics contain information about the most recently rendered content
 * frames.
 *
 * @param windowId The window id.
 * @return Whether the window is present and its frame statistics
 *         were cleared.
 *
 * @see android.view.WindowContentFrameStats
 * @see #getWindowContentFrameStats(int)
 * @see #getWindows()
 * @see android.view.accessibility.AccessibilityWindowInfo#getId() AccessibilityWindowInfo.getId()
 * @apiSince 21
 */

public boolean clearWindowContentFrameStats(int windowId) { throw new RuntimeException("Stub!"); }

/**
 * Gets the frame statistics for a given window. These statistics contain
 * information about the most recently rendered content frames.
 * <p>
 * A typical usage requires clearing the window frame statistics via {@link
 * #clearWindowContentFrameStats(int)} followed by an interaction with the UI and
 * finally getting the window frame statistics via calling this method.
 * </p>
 * <pre>
 * // Assume we have at least one window.
 * final int windowId = getWindows().get(0).getId();
 *
 * // Start with a clean slate.
 * uiAutimation.clearWindowContentFrameStats(windowId);
 *
 * // Do stuff with the UI.
 *
 * // Get the frame statistics.
 * WindowContentFrameStats stats = uiAutomation.getWindowContentFrameStats(windowId);
 * </pre>
 *
 * @param windowId The window id.
 * @return The window frame statistics, or null if the window is not present.
 *
 * @see android.view.WindowContentFrameStats
 * @see #clearWindowContentFrameStats(int)
 * @see #getWindows()
 * @see android.view.accessibility.AccessibilityWindowInfo#getId() AccessibilityWindowInfo.getId()
 * @apiSince 21
 */

public android.view.WindowContentFrameStats getWindowContentFrameStats(int windowId) { throw new RuntimeException("Stub!"); }

/**
 * Clears the window animation rendering statistics. These statistics contain
 * information about the most recently rendered window animation frames, i.e.
 * for window transition animations.
 *
 * @see android.view.WindowAnimationFrameStats
 * @see #getWindowAnimationFrameStats()
 * @see android.R.styleable#WindowAnimation
 * @apiSince 21
 */

public void clearWindowAnimationFrameStats() { throw new RuntimeException("Stub!"); }

/**
 * Gets the window animation frame statistics. These statistics contain
 * information about the most recently rendered window animation frames, i.e.
 * for window transition animations.
 *
 * <p>
 * A typical usage requires clearing the window animation frame statistics via
 * {@link #clearWindowAnimationFrameStats()} followed by an interaction that causes
 * a window transition which uses a window animation and finally getting the window
 * animation frame statistics by calling this method.
 * </p>
 * <pre>
 * // Start with a clean slate.
 * uiAutimation.clearWindowAnimationFrameStats();
 *
 * // Do stuff to trigger a window transition.
 *
 * // Get the frame statistics.
 * WindowAnimationFrameStats stats = uiAutomation.getWindowAnimationFrameStats();
 * </pre>
 *
 * @return The window animation frame statistics.
 *
 * @see android.view.WindowAnimationFrameStats
 * @see #clearWindowAnimationFrameStats()
 * @see android.R.styleable#WindowAnimation
 * @apiSince 21
 */

public android.view.WindowAnimationFrameStats getWindowAnimationFrameStats() { throw new RuntimeException("Stub!"); }

/**
 * Grants a runtime permission to a package.
 * @param packageName The package to which to grant.
 * @param permission The permission to grant.
 * @throws java.lang.SecurityException if unable to grant the permission.
 * @apiSince 28
 */

public void grantRuntimePermission(java.lang.String packageName, java.lang.String permission) { throw new RuntimeException("Stub!"); }

/**
 * Grants a runtime permission to a package for a user.
 * @param packageName The package to which to grant.
 * @param permission The permission to grant.
 * @throws java.lang.SecurityException if unable to grant the permission.
 * @apiSince 28
 */

public void grantRuntimePermissionAsUser(java.lang.String packageName, java.lang.String permission, android.os.UserHandle userHandle) { throw new RuntimeException("Stub!"); }

/**
 * Revokes a runtime permission from a package.
 * @param packageName The package to which to grant.
 * @param permission The permission to grant.
 * @throws java.lang.SecurityException if unable to revoke the permission.
 * @apiSince 28
 */

public void revokeRuntimePermission(java.lang.String packageName, java.lang.String permission) { throw new RuntimeException("Stub!"); }

/**
 * Revokes a runtime permission from a package.
 * @param packageName The package to which to grant.
 * @param permission The permission to grant.
 * @throws java.lang.SecurityException if unable to revoke the permission.
 * @apiSince 28
 */

public void revokeRuntimePermissionAsUser(java.lang.String packageName, java.lang.String permission, android.os.UserHandle userHandle) { throw new RuntimeException("Stub!"); }

/**
 * Executes a shell command. This method returns a file descriptor that points
 * to the standard output stream. The command execution is similar to running
 * "adb shell <command>" from a host connected to the device.
 * <p>
 * <strong>Note:</strong> It is your responsibility to close the returned file
 * descriptor once you are done reading.
 * </p>
 *
 * @param command The command to execute.
 * @return A file descriptor to the standard output stream.
 *
 * @see #adoptShellPermissionIdentity()
 * @apiSince 21
 */

public android.os.ParcelFileDescriptor executeShellCommand(java.lang.String command) { throw new RuntimeException("Stub!"); }

/**
 * UiAutomation supresses accessibility services by default. This flag specifies that
 * existing accessibility services should continue to run, and that new ones may start.
 * This flag is set when obtaining the UiAutomation from
 * {@link android.app.Instrumentation#getUiAutomation(int) Instrumentation#getUiAutomation(int)}.
 * @apiSince 24
 */

public static final int FLAG_DONT_SUPPRESS_ACCESSIBILITY_SERVICES = 1; // 0x1

/**
 * Rotation constant: Freeze rotation to 0 degrees (natural orientation)
 * @apiSince 18
 */

public static final int ROTATION_FREEZE_0 = 0; // 0x0

/**
 * Rotation constant: Freeze rotation to 180 degrees .
 * @apiSince 18
 */

public static final int ROTATION_FREEZE_180 = 2; // 0x2

/**
 * Rotation constant: Freeze rotation to 270 degrees .
 * @apiSince 18
 */

public static final int ROTATION_FREEZE_270 = 3; // 0x3

/**
 * Rotation constant: Freeze rotation to 90 degrees .
 * @apiSince 18
 */

public static final int ROTATION_FREEZE_90 = 1; // 0x1

/**
 * Rotation constant: Freeze rotation to its current state.
 * @apiSince 18
 */

public static final int ROTATION_FREEZE_CURRENT = -1; // 0xffffffff

/**
 * Rotation constant: Unfreeze rotation (rotating the device changes its rotation state).
 * @apiSince 18
 */

public static final int ROTATION_UNFREEZE = -2; // 0xfffffffe
/**
 * Listener for filtering accessibility events.
 * @apiSince 18
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface AccessibilityEventFilter {

/**
 * Callback for determining whether an event is accepted or
 * it is filtered out.
 *
 * @param event The event to process.
 * @return True if the event is accepted, false to filter it out.
 * @apiSince 18
 */

public boolean accept(android.view.accessibility.AccessibilityEvent event);
}

/**
 * Listener for observing the {@link android.view.accessibility.AccessibilityEvent AccessibilityEvent} stream.
 * @apiSince 18
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnAccessibilityEventListener {

/**
 * Callback for receiving an {@link android.view.accessibility.AccessibilityEvent AccessibilityEvent}.
 * <p>
 * <strong>Note:</strong> This method is <strong>NOT</strong> executed
 * on the main test thread. The client is responsible for proper
 * synchronization.
 * </p>
 * <p>
 * <strong>Note:</strong> It is responsibility of the client
 * to recycle the received events to minimize object creation.
 * </p>
 *
 * @param event The received event.
 * @apiSince 18
 */

public void onAccessibilityEvent(android.view.accessibility.AccessibilityEvent event);
}

}

