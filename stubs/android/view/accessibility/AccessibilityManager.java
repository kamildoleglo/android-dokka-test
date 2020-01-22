/*
 * Copyright (C) 2009 The Android Open Source Project
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


package android.view.accessibility;

import android.content.Context;
import android.view.View;
import android.content.pm.ServiceInfo;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Handler;

/**
 * System level service that serves as an event dispatch for {@link android.view.accessibility.AccessibilityEvent AccessibilityEvent}s,
 * and provides facilities for querying the accessibility state of the system.
 * Accessibility events are generated when something notable happens in the user interface,
 * for example an {@link android.app.Activity} starts, the focus or selection of a
 * {@link android.view.View} changes etc. Parties interested in handling accessibility
 * events implement and register an accessibility service which extends
 * {@link android.accessibilityservice.AccessibilityService}.
 *
 * @see android.view.accessibility.AccessibilityEvent
 * @see android.view.accessibility.AccessibilityNodeInfo
 * @see android.accessibilityservice.AccessibilityService
 * @see Context#getSystemService
 * @see android.content.Context#ACCESSIBILITY_SERVICE
 * @apiSince 4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class AccessibilityManager {

AccessibilityManager() { throw new RuntimeException("Stub!"); }

/**
 * Returns if the accessibility in the system is enabled.
 *
 * @return True if accessibility is enabled, false otherwise.
 * @apiSince 4
 */

public boolean isEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Returns if the touch exploration in the system is enabled.
 *
 * @return True if touch exploration is enabled, false otherwise.
 * @apiSince 14
 */

public boolean isTouchExplorationEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Sends an {@link android.view.accessibility.AccessibilityEvent AccessibilityEvent}.
 *
 * @param event The event to send.
 *
 * @throws java.lang.IllegalStateException if accessibility is not enabled.
 *
 * <strong>Note:</strong> The preferred mechanism for sending custom accessibility
 * events is through calling
 * {@link android.view.ViewParent#requestSendAccessibilityEvent(View, AccessibilityEvent)}
 * instead of this method to allow predecessors to augment/filter events sent by
 * their descendants.
 * @apiSince 4
 */

public void sendAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Requests feedback interruption from all accessibility services.
 * @apiSince 4
 */

public void interrupt() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.content.pm.ServiceInfo ServiceInfo}s of the installed accessibility services.
 *
 * @return An unmodifiable list with {@link android.content.pm.ServiceInfo ServiceInfo}s.
 *
 * @deprecated Use {@link #getInstalledAccessibilityServiceList()}
 * @apiSince 4
 * @deprecatedSince 15
 */

@Deprecated
public java.util.List<android.content.pm.ServiceInfo> getAccessibilityServiceList() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.accessibilityservice.AccessibilityServiceInfo AccessibilityServiceInfo}s of the installed accessibility services.
 *
 * @return An unmodifiable list with {@link android.accessibilityservice.AccessibilityServiceInfo AccessibilityServiceInfo}s.
 * @apiSince 14
 */

public java.util.List<android.accessibilityservice.AccessibilityServiceInfo> getInstalledAccessibilityServiceList() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.accessibilityservice.AccessibilityServiceInfo AccessibilityServiceInfo}s of the enabled accessibility services
 * for a given feedback type.
 *
 * @param feedbackTypeFlags The feedback type flags.
 * @return An unmodifiable list with {@link android.accessibilityservice.AccessibilityServiceInfo AccessibilityServiceInfo}s.
 *
 * @see android.accessibilityservice.AccessibilityServiceInfo#FEEDBACK_AUDIBLE
 * @see android.accessibilityservice.AccessibilityServiceInfo#FEEDBACK_GENERIC
 * @see android.accessibilityservice.AccessibilityServiceInfo#FEEDBACK_HAPTIC
 * @see android.accessibilityservice.AccessibilityServiceInfo#FEEDBACK_SPOKEN
 * @see android.accessibilityservice.AccessibilityServiceInfo#FEEDBACK_VISUAL
 * @see android.accessibilityservice.AccessibilityServiceInfo#FEEDBACK_BRAILLE
 * @apiSince 14
 */

public java.util.List<android.accessibilityservice.AccessibilityServiceInfo> getEnabledAccessibilityServiceList(int feedbackTypeFlags) { throw new RuntimeException("Stub!"); }

/**
 * Registers an {@link android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener AccessibilityStateChangeListener} for changes in
 * the global accessibility state of the system. Equivalent to calling
 * {@link #addAccessibilityStateChangeListener(android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener,android.os.Handler)}
 * with a null handler.
 *
 * @param listener The listener.
 * This value must never be {@code null}.
 * @return Always returns {@code true}.
 * @apiSince 14
 */

public boolean addAccessibilityStateChangeListener(@androidx.annotation.NonNull android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Registers an {@link android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener AccessibilityStateChangeListener} for changes in
 * the global accessibility state of the system. If the listener has already been registered,
 * the handler used to call it back is updated.
 *
 * @param listener The listener.
 * This value must never be {@code null}.
 * @param handler The handler on which the listener should be called back, or {@code null}
 *                for a callback on the process's main handler.
 
 * This value may be {@code null}.
 * @apiSince 26
 */

public void addAccessibilityStateChangeListener(@androidx.annotation.NonNull android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener listener, @androidx.annotation.Nullable android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters an {@link android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener AccessibilityStateChangeListener}.
 *
 * @param listener The listener.
 * This value must never be {@code null}.
 * @return True if the listener was previously registered.
 * @apiSince 14
 */

public boolean removeAccessibilityStateChangeListener(@androidx.annotation.NonNull android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Registers a {@link android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener TouchExplorationStateChangeListener} for changes in
 * the global touch exploration state of the system. Equivalent to calling
 * {@link #addTouchExplorationStateChangeListener(android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener,android.os.Handler)}
 * with a null handler.
 *
 * @param listener The listener.
 * This value must never be {@code null}.
 * @return Always returns {@code true}.
 * @apiSince 19
 */

public boolean addTouchExplorationStateChangeListener(@androidx.annotation.NonNull android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Registers an {@link android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener TouchExplorationStateChangeListener} for changes in
 * the global touch exploration state of the system. If the listener has already been
 * registered, the handler used to call it back is updated.
 *
 * @param listener The listener.
 * This value must never be {@code null}.
 * @param handler The handler on which the listener should be called back, or {@code null}
 *                for a callback on the process's main handler.
 
 * This value may be {@code null}.
 * @apiSince 26
 */

public void addTouchExplorationStateChangeListener(@androidx.annotation.NonNull android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener listener, @androidx.annotation.Nullable android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters a {@link android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener TouchExplorationStateChangeListener}.
 *
 * @param listener The listener.
 * This value must never be {@code null}.
 * @return True if listener was previously registered.
 * @apiSince 19
 */

public boolean removeTouchExplorationStateChangeListener(@androidx.annotation.NonNull android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Registers a {@link android.view.accessibility.AccessibilityRequestPreparer AccessibilityRequestPreparer}.
 * @apiSince 27
 */

public void addAccessibilityRequestPreparer(android.view.accessibility.AccessibilityRequestPreparer preparer) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters a {@link android.view.accessibility.AccessibilityRequestPreparer AccessibilityRequestPreparer}.
 * @apiSince 27
 */

public void removeAccessibilityRequestPreparer(android.view.accessibility.AccessibilityRequestPreparer preparer) { throw new RuntimeException("Stub!"); }

/**
 * Get the recommended timeout for changes to the UI needed by this user. Controls should remain
 * on the screen for at least this long to give users time to react. Some users may need
 * extra time to review the controls, or to reach them, or to activate assistive technology
 * to activate the controls automatically.
 * <p>
 * Use the combination of content flags to indicate contents of UI. For example, use
 * {@code FLAG_CONTENT_ICONS | FLAG_CONTENT_TEXT} for message notification which contains
 * icons and text, or use {@code FLAG_CONTENT_TEXT | FLAG_CONTENT_CONTROLS} for button dialog
 * which contains text and button controls.
 * <p/>
 *
 * @param originalTimeout The timeout appropriate for users with no accessibility needs.
 * @param uiContentFlags The combination of flags {@link #FLAG_CONTENT_ICONS},
 *                       {@link #FLAG_CONTENT_TEXT} or {@link #FLAG_CONTENT_CONTROLS} to
 *                       indicate the contents of UI.
 * Value is either <code>0</code> or a combination of {@link android.view.accessibility.AccessibilityManager#FLAG_CONTENT_ICONS}, {@link android.view.accessibility.AccessibilityManager#FLAG_CONTENT_TEXT}, and {@link android.view.accessibility.AccessibilityManager#FLAG_CONTENT_CONTROLS}
 * @return The recommended UI timeout for the current user in milliseconds.
 * @apiSince 29
 */

public int getRecommendedTimeoutMillis(int originalTimeout, int uiContentFlags) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the accessibility button within the system navigation area is supported.
 *
 * @return {@code true} if the accessibility button is supported on this device,
 * {@code false} otherwise
 * @apiSince 27
 */

public static boolean isAccessibilityButtonSupported() { throw new RuntimeException("Stub!"); }

/**
 * Use this flag to indicate the content of a UI that times out contains interactive controls.
 *
 * @see #getRecommendedTimeoutMillis(int, int)
 * @apiSince 29
 */

public static final int FLAG_CONTENT_CONTROLS = 4; // 0x4

/**
 * Use this flag to indicate the content of a UI that times out contains icons.
 *
 * @see #getRecommendedTimeoutMillis(int, int)
 * @apiSince 29
 */

public static final int FLAG_CONTENT_ICONS = 1; // 0x1

/**
 * Use this flag to indicate the content of a UI that times out contains text.
 *
 * @see #getRecommendedTimeoutMillis(int, int)
 * @apiSince 29
 */

public static final int FLAG_CONTENT_TEXT = 2; // 0x2
/**
 * Listener for the system accessibility state. To listen for changes to the
 * accessibility state on the device, implement this interface and register
 * it with the system by calling {@link #addAccessibilityStateChangeListener}.
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface AccessibilityStateChangeListener {

/**
 * Called when the accessibility enabled state changes.
 *
 * @param enabled Whether accessibility is enabled.
 * @apiSince 14
 */

public void onAccessibilityStateChanged(boolean enabled);
}

/**
 * Listener for the system touch exploration state. To listen for changes to
 * the touch exploration state on the device, implement this interface and
 * register it with the system by calling
 * {@link #addTouchExplorationStateChangeListener}.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface TouchExplorationStateChangeListener {

/**
 * Called when the touch exploration enabled state changes.
 *
 * @param enabled Whether touch exploration is enabled.
 * @apiSince 19
 */

public void onTouchExplorationStateChanged(boolean enabled);
}

}

