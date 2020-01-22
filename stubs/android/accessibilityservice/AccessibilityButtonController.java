/*
 * Copyright (C) 2017 The Android Open Source Project
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


package android.accessibilityservice;

import android.os.Handler;

/**
 * Controller for the accessibility button within the system's navigation area
 * <p>
 * This class may be used to query the accessibility button's state and register
 * callbacks for interactions with and state changes to the accessibility button when
 * {@link android.accessibilityservice.AccessibilityServiceInfo#FLAG_REQUEST_ACCESSIBILITY_BUTTON AccessibilityServiceInfo#FLAG_REQUEST_ACCESSIBILITY_BUTTON} is set.
 * </p>
 * <p>
 * <strong>Note:</strong> This class and
 * {@link android.accessibilityservice.AccessibilityServiceInfo#FLAG_REQUEST_ACCESSIBILITY_BUTTON AccessibilityServiceInfo#FLAG_REQUEST_ACCESSIBILITY_BUTTON} should not be used as
 * the sole means for offering functionality to users via an {@link android.accessibilityservice.AccessibilityService AccessibilityService}.
 * Some device implementations may choose not to provide a software-rendered system
 * navigation area, making this affordance permanently unavailable.
 * </p>
 * <p>
 * <strong>Note:</strong> On device implementations where the accessibility button is
 * supported, it may not be available at all times, such as when a foreground application uses
 * {@link android.view.View#SYSTEM_UI_FLAG_HIDE_NAVIGATION}. A user may also choose to assign
 * this button to another accessibility service or feature. In each of these cases, a
 * registered {@link android.accessibilityservice.AccessibilityButtonController.AccessibilityButtonCallback AccessibilityButtonCallback}'s
 * {@link android.accessibilityservice.AccessibilityButtonController.AccessibilityButtonCallback#onAvailabilityChanged(android.accessibilityservice.AccessibilityButtonController,boolean) AccessibilityButtonCallback#onAvailabilityChanged(AccessibilityButtonController, boolean)}
 * method will be invoked to provide notifications of changes in the accessibility button's
 * availability to the registering service.
 * </p>
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class AccessibilityButtonController {

AccessibilityButtonController() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves whether the accessibility button in the system's navigation area is
 * available to the calling service.
 * <p>
 * <strong>Note:</strong> If the service is not yet connected (e.g.
 * {@link android.accessibilityservice.AccessibilityService#onServiceConnected() AccessibilityService#onServiceConnected()} has not yet been called) or the
 * service has been disconnected, this method will have no effect and return {@code false}.
 * </p>
 *
 * @return {@code true} if the accessibility button in the system's navigation area is
 * available to the calling service, {@code false} otherwise
 * @apiSince 26
 */

public boolean isAccessibilityButtonAvailable() { throw new RuntimeException("Stub!"); }

/**
 * Registers the provided {@link android.accessibilityservice.AccessibilityButtonController.AccessibilityButtonCallback AccessibilityButtonCallback} for interaction and state
 * changes callbacks related to the accessibility button.
 *
 * @param callback the callback to add, must be non-null
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public void registerAccessibilityButtonCallback(@androidx.annotation.NonNull android.accessibilityservice.AccessibilityButtonController.AccessibilityButtonCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Registers the provided {@link android.accessibilityservice.AccessibilityButtonController.AccessibilityButtonCallback AccessibilityButtonCallback} for interaction and state
 * change callbacks related to the accessibility button. The callback will occur on the
 * specified {@link android.os.Handler Handler}'s thread, or on the services's main thread if the handler is
 * {@code null}.
 *
 * @param callback the callback to add, must be non-null
 * This value must never be {@code null}.
 * @param handler the handler on which the callback should execute, must be non-null
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public void registerAccessibilityButtonCallback(@androidx.annotation.NonNull android.accessibilityservice.AccessibilityButtonController.AccessibilityButtonCallback callback, @androidx.annotation.NonNull android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters the provided {@link android.accessibilityservice.AccessibilityButtonController.AccessibilityButtonCallback AccessibilityButtonCallback} for interaction and state
 * change callbacks related to the accessibility button.
 *
 * @param callback the callback to remove, must be non-null
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public void unregisterAccessibilityButtonCallback(@androidx.annotation.NonNull android.accessibilityservice.AccessibilityButtonController.AccessibilityButtonCallback callback) { throw new RuntimeException("Stub!"); }
/**
 * Callback for interaction with and changes to state of the accessibility button
 * within the system's navigation area.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class AccessibilityButtonCallback {

public AccessibilityButtonCallback() { throw new RuntimeException("Stub!"); }

/**
 * Called when the accessibility button in the system's navigation area is clicked.
 *
 * @param controller the controller used to register for this callback
 * @apiSince 26
 */

public void onClicked(android.accessibilityservice.AccessibilityButtonController controller) { throw new RuntimeException("Stub!"); }

/**
 * Called when the availability of the accessibility button in the system's
 * navigation area has changed. The accessibility button may become unavailable
 * because the device shopped showing the button, the button was assigned to another
 * service, or for other reasons.
 *
 * @param controller the controller used to register for this callback
 * @param available {@code true} if the accessibility button is available to this
 *                  service, {@code false} otherwise
 * @apiSince 26
 */

public void onAvailabilityChanged(android.accessibilityservice.AccessibilityButtonController controller, boolean available) { throw new RuntimeException("Stub!"); }
}

}

