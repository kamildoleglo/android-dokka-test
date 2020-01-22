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


package android.accessibilityservice;

import android.view.accessibility.AccessibilityNodeInfo;
import android.content.Intent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityWindowInfo;
import android.content.Context;
import android.os.Handler;

/**
 * Accessibility services should only be used to assist users with disabilities in using
 * Android devices and apps. They run in the background and receive callbacks by the system
 * when {@link android.view.accessibility.AccessibilityEvent AccessibilityEvent}s are fired. Such events denote some state transition
 * in the user interface, for example, the focus has changed, a button has been clicked,
 * etc. Such a service can optionally request the capability for querying the content
 * of the active window. Development of an accessibility service requires extending this
 * class and implementing its abstract methods.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about creating AccessibilityServices, read the
 * <a href="{@docRoot}guide/topics/ui/accessibility/index.html">Accessibility</a>
 * developer guide.</p>
 * </div>
 *
 * <h3>Lifecycle</h3>
 * <p>
 * The lifecycle of an accessibility service is managed exclusively by the system and
 * follows the established service life cycle. Starting an accessibility service is triggered
 * exclusively by the user explicitly turning the service on in device settings. After the system
 * binds to a service, it calls {@link android.accessibilityservice.AccessibilityService#onServiceConnected() AccessibilityService#onServiceConnected()}. This method can
 * be overridden by clients that want to perform post binding setup.
 * </p>
 * <p>
 * An accessibility service stops either when the user turns it off in device settings or when
 * it calls {@link android.accessibilityservice.AccessibilityService#disableSelf() AccessibilityService#disableSelf()}.
 * </p>
 * <h3>Declaration</h3>
 * <p>
 * An accessibility is declared as any other service in an AndroidManifest.xml, but it
 * must do two things:
 * <ul>
 *     <ol>
 *         Specify that it handles the "android.accessibilityservice.AccessibilityService"
 *         {@link android.content.Intent}.
 *     </ol>
 *     <ol>
 *         Request the {@link android.Manifest.permission#BIND_ACCESSIBILITY_SERVICE} permission to
 *         ensure that only the system can bind to it.
 *     </ol>
 * </ul>
 * If either of these items is missing, the system will ignore the accessibility service.
 * Following is an example declaration:
 * </p>
 * <pre> &lt;service android:name=".MyAccessibilityService"
 *         android:permission="android.permission.BIND_ACCESSIBILITY_SERVICE"&gt;
 *     &lt;intent-filter&gt;
 *         &lt;action android:name="android.accessibilityservice.AccessibilityService" /&gt;
 *     &lt;/intent-filter&gt;
 *     . . .
 * &lt;/service&gt;</pre>
 * <h3>Configuration</h3>
 * <p>
 * An accessibility service can be configured to receive specific types of accessibility events,
 * listen only to specific packages, get events from each type only once in a given time frame,
 * retrieve window content, specify a settings activity, etc.
 * </p>
 * <p>
 * There are two approaches for configuring an accessibility service:
 * </p>
 * <ul>
 * <li>
 * Providing a {@link #SERVICE_META_DATA meta-data} entry in the manifest when declaring
 * the service. A service declaration with a meta-data tag is presented below:
 * <pre> &lt;service android:name=".MyAccessibilityService"&gt;
 *     &lt;intent-filter&gt;
 *         &lt;action android:name="android.accessibilityservice.AccessibilityService" /&gt;
 *     &lt;/intent-filter&gt;
 *     &lt;meta-data android:name="android.accessibilityservice" android:resource="@xml/accessibilityservice" /&gt;
 * &lt;/service&gt;</pre>
 * <p class="note">
 * <strong>Note:</strong> This approach enables setting all properties.
 * </p>
 * <p>
 * For more details refer to {@link #SERVICE_META_DATA} and
 * <code>&lt;{@link android.R.styleable#AccessibilityService accessibility-service}&gt;</code>.
 * </p>
 * </li>
 * <li>
 * Calling {@link android.accessibilityservice.AccessibilityService#setServiceInfo(android.accessibilityservice.AccessibilityServiceInfo) AccessibilityService#setServiceInfo(AccessibilityServiceInfo)}. Note
 * that this method can be called any time to dynamically change the service configuration.
 * <p class="note">
 * <strong>Note:</strong> This approach enables setting only dynamically configurable properties:
 * {@link android.accessibilityservice.AccessibilityServiceInfo#eventTypes AccessibilityServiceInfo#eventTypes},
 * {@link android.accessibilityservice.AccessibilityServiceInfo#feedbackType AccessibilityServiceInfo#feedbackType},
 * {@link android.accessibilityservice.AccessibilityServiceInfo#flags AccessibilityServiceInfo#flags},
 * {@link android.accessibilityservice.AccessibilityServiceInfo#notificationTimeout AccessibilityServiceInfo#notificationTimeout},
 * {@link android.accessibilityservice.AccessibilityServiceInfo#packageNames AccessibilityServiceInfo#packageNames}
 * </p>
 * <p>
 * For more details refer to {@link android.accessibilityservice.AccessibilityServiceInfo AccessibilityServiceInfo}.
 * </p>
 * </li>
 * </ul>
 * <h3>Retrieving window content</h3>
 * <p>
 * A service can specify in its declaration that it can retrieve window
 * content which is represented as a tree of {@link android.view.accessibility.AccessibilityWindowInfo AccessibilityWindowInfo} and
 * {@link android.view.accessibility.AccessibilityNodeInfo AccessibilityNodeInfo} objects. Note that
 * declaring this capability requires that the service declares its configuration via
 * an XML resource referenced by {@link #SERVICE_META_DATA}.
 * </p>
 * <p>
 * Window content may be retrieved with
 * {@link android.view.accessibility.AccessibilityEvent#getSource() AccessibilityEvent#getSource()},
 * {@link android.accessibilityservice.AccessibilityService#findFocus(int) AccessibilityService#findFocus(int)},
 * {@link android.accessibilityservice.AccessibilityService#getWindows() AccessibilityService#getWindows()}, or
 * {@link android.accessibilityservice.AccessibilityService#getRootInActiveWindow() AccessibilityService#getRootInActiveWindow()}.
 * </p>
 * <p class="note">
 * <strong>Note</strong> An accessibility service may have requested to be notified for
 * a subset of the event types, and thus be unaware when the node hierarchy has changed. It is also
 * possible for a node to contain outdated information because the window content may change at any
 * time.
 * </p>
 * <h3>Notification strategy</h3>
 * <p>
 * All accessibility services are notified of all events they have requested, regardless of their
 * feedback type.
 * </p>
 * <p class="note">
 * <strong>Note:</strong> The event notification timeout is useful to avoid propagating
 * events to the client too frequently since this is accomplished via an expensive
 * interprocess call. One can think of the timeout as a criteria to determine when
 * event generation has settled down.</p>
 * <h3>Event types</h3>
 * <ul>
 * <li>{@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_CLICKED AccessibilityEvent#TYPE_VIEW_CLICKED}</li>
 * <li>{@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_LONG_CLICKED AccessibilityEvent#TYPE_VIEW_LONG_CLICKED}</li>
 * <li>{@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_FOCUSED AccessibilityEvent#TYPE_VIEW_FOCUSED}</li>
 * <li>{@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_SELECTED AccessibilityEvent#TYPE_VIEW_SELECTED}</li>
 * <li>{@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_TEXT_CHANGED AccessibilityEvent#TYPE_VIEW_TEXT_CHANGED}</li>
 * <li>{@link android.view.accessibility.AccessibilityEvent#TYPE_WINDOW_STATE_CHANGED AccessibilityEvent#TYPE_WINDOW_STATE_CHANGED}</li>
 * <li>{@link android.view.accessibility.AccessibilityEvent#TYPE_NOTIFICATION_STATE_CHANGED AccessibilityEvent#TYPE_NOTIFICATION_STATE_CHANGED}</li>
 * <li>{@link android.view.accessibility.AccessibilityEvent#TYPE_TOUCH_EXPLORATION_GESTURE_START AccessibilityEvent#TYPE_TOUCH_EXPLORATION_GESTURE_START}</li>
 * <li>{@link android.view.accessibility.AccessibilityEvent#TYPE_TOUCH_EXPLORATION_GESTURE_END AccessibilityEvent#TYPE_TOUCH_EXPLORATION_GESTURE_END}</li>
 * <li>{@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_HOVER_ENTER AccessibilityEvent#TYPE_VIEW_HOVER_ENTER}</li>
 * <li>{@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_HOVER_EXIT AccessibilityEvent#TYPE_VIEW_HOVER_EXIT}</li>
 * <li>{@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_SCROLLED AccessibilityEvent#TYPE_VIEW_SCROLLED}</li>
 * <li>{@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_TEXT_SELECTION_CHANGED AccessibilityEvent#TYPE_VIEW_TEXT_SELECTION_CHANGED}</li>
 * <li>{@link android.view.accessibility.AccessibilityEvent#TYPE_WINDOW_CONTENT_CHANGED AccessibilityEvent#TYPE_WINDOW_CONTENT_CHANGED}</li>
 * <li>{@link android.view.accessibility.AccessibilityEvent#TYPE_ANNOUNCEMENT AccessibilityEvent#TYPE_ANNOUNCEMENT}</li>
 * <li>{@link android.view.accessibility.AccessibilityEvent#TYPE_GESTURE_DETECTION_START AccessibilityEvent#TYPE_GESTURE_DETECTION_START}</li>
 * <li>{@link android.view.accessibility.AccessibilityEvent#TYPE_GESTURE_DETECTION_END AccessibilityEvent#TYPE_GESTURE_DETECTION_END}</li>
 * <li>{@link android.view.accessibility.AccessibilityEvent#TYPE_TOUCH_INTERACTION_START AccessibilityEvent#TYPE_TOUCH_INTERACTION_START}</li>
 * <li>{@link android.view.accessibility.AccessibilityEvent#TYPE_TOUCH_INTERACTION_END AccessibilityEvent#TYPE_TOUCH_INTERACTION_END}</li>
 * <li>{@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_ACCESSIBILITY_FOCUSED AccessibilityEvent#TYPE_VIEW_ACCESSIBILITY_FOCUSED}</li>
 * <li>{@link android.view.accessibility.AccessibilityEvent#TYPE_WINDOWS_CHANGED AccessibilityEvent#TYPE_WINDOWS_CHANGED}</li>
 * <li>{@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED AccessibilityEvent#TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED}</li>
 * </ul>
 * <h3>Feedback types</h3>
 * <ul>
 * <li>{@link android.accessibilityservice.AccessibilityServiceInfo#FEEDBACK_AUDIBLE AccessibilityServiceInfo#FEEDBACK_AUDIBLE}</li>
 * <li>{@link android.accessibilityservice.AccessibilityServiceInfo#FEEDBACK_HAPTIC AccessibilityServiceInfo#FEEDBACK_HAPTIC}</li>
 * <li>{@link android.accessibilityservice.AccessibilityServiceInfo#FEEDBACK_AUDIBLE AccessibilityServiceInfo#FEEDBACK_AUDIBLE}</li>
 * <li>{@link android.accessibilityservice.AccessibilityServiceInfo#FEEDBACK_VISUAL AccessibilityServiceInfo#FEEDBACK_VISUAL}</li>
 * <li>{@link android.accessibilityservice.AccessibilityServiceInfo#FEEDBACK_GENERIC AccessibilityServiceInfo#FEEDBACK_GENERIC}</li>
 * <li>{@link android.accessibilityservice.AccessibilityServiceInfo#FEEDBACK_BRAILLE AccessibilityServiceInfo#FEEDBACK_BRAILLE}</li>
 * </ul>
 * @see android.view.accessibility.AccessibilityEvent
 * @see android.accessibilityservice.AccessibilityServiceInfo
 * @see android.view.accessibility.AccessibilityManager
 * @apiSince 4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class AccessibilityService extends android.app.Service {

public AccessibilityService() { throw new RuntimeException("Stub!"); }

/**
 * Callback for {@link android.view.accessibility.AccessibilityEvent}s.
 *
 * @param event The new event. This event is owned by the caller and cannot be used after
 * this method returns. Services wishing to use the event after this method returns should
 * make a copy.
 * @apiSince 4
 */

public abstract void onAccessibilityEvent(android.view.accessibility.AccessibilityEvent event);

/**
 * Callback for interrupting the accessibility feedback.
 * @apiSince 4
 */

public abstract void onInterrupt();

/**
 * This method is a part of the {@link android.accessibilityservice.AccessibilityService AccessibilityService} lifecycle and is
 * called after the system has successfully bound to the service. If is
 * convenient to use this method for setting the {@link android.accessibilityservice.AccessibilityServiceInfo AccessibilityServiceInfo}.
 *
 * @see android.accessibilityservice.AccessibilityServiceInfo
 * @see #setServiceInfo(AccessibilityServiceInfo)
 * @apiSince 4
 */

protected void onServiceConnected() { throw new RuntimeException("Stub!"); }

/**
 * Called by the system when the user performs a specific gesture on the
 * touch screen.
 *
 * <strong>Note:</strong> To receive gestures an accessibility service must
 * request that the device is in touch exploration mode by setting the
 * {@link android.accessibilityservice.AccessibilityServiceInfo#FLAG_REQUEST_TOUCH_EXPLORATION_MODE}
 * flag.
 *
 * @param gestureId The unique id of the performed gesture.
 *
 * @return Whether the gesture was handled.
 *
 * @see #GESTURE_SWIPE_UP
 * @see #GESTURE_SWIPE_UP_AND_LEFT
 * @see #GESTURE_SWIPE_UP_AND_DOWN
 * @see #GESTURE_SWIPE_UP_AND_RIGHT
 * @see #GESTURE_SWIPE_DOWN
 * @see #GESTURE_SWIPE_DOWN_AND_LEFT
 * @see #GESTURE_SWIPE_DOWN_AND_UP
 * @see #GESTURE_SWIPE_DOWN_AND_RIGHT
 * @see #GESTURE_SWIPE_LEFT
 * @see #GESTURE_SWIPE_LEFT_AND_UP
 * @see #GESTURE_SWIPE_LEFT_AND_RIGHT
 * @see #GESTURE_SWIPE_LEFT_AND_DOWN
 * @see #GESTURE_SWIPE_RIGHT
 * @see #GESTURE_SWIPE_RIGHT_AND_UP
 * @see #GESTURE_SWIPE_RIGHT_AND_LEFT
 * @see #GESTURE_SWIPE_RIGHT_AND_DOWN
 * @apiSince 16
 */

protected boolean onGesture(int gestureId) { throw new RuntimeException("Stub!"); }

/**
 * Callback that allows an accessibility service to observe the key events
 * before they are passed to the rest of the system. This means that the events
 * are first delivered here before they are passed to the device policy, the
 * input method, or applications.
 * <p>
 * <strong>Note:</strong> It is important that key events are handled in such
 * a way that the event stream that would be passed to the rest of the system
 * is well-formed. For example, handling the down event but not the up event
 * and vice versa would generate an inconsistent event stream.
 * </p>
 * <p>
 * <strong>Note:</strong> The key events delivered in this method are copies
 * and modifying them will have no effect on the events that will be passed
 * to the system. This method is intended to perform purely filtering
 * functionality.
 * <p>
 *
 * @param event The event to be processed. This event is owned by the caller and cannot be used
 * after this method returns. Services wishing to use the event after this method returns should
 * make a copy.
 * @return If true then the event will be consumed and not delivered to
 *         applications, otherwise it will be delivered as usual.
 * @apiSince 18
 */

protected boolean onKeyEvent(android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Gets the windows on the screen. This method returns only the windows
 * that a sighted user can interact with, as opposed to all windows.
 * For example, if there is a modal dialog shown and the user cannot touch
 * anything behind it, then only the modal window will be reported
 * (assuming it is the top one). For convenience the returned windows
 * are ordered in a descending layer order, which is the windows that
 * are on top are reported first. Since the user can always
 * interact with the window that has input focus by typing, the focused
 * window is always returned (even if covered by a modal window).
 * <p>
 * <strong>Note:</strong> In order to access the windows your service has
 * to declare the capability to retrieve window content by setting the
 * {@link android.R.styleable#AccessibilityService_canRetrieveWindowContent}
 * property in its meta-data. For details refer to {@link #SERVICE_META_DATA}.
 * Also the service has to opt-in to retrieve the interactive windows by
 * setting the {@link android.accessibilityservice.AccessibilityServiceInfo#FLAG_RETRIEVE_INTERACTIVE_WINDOWS AccessibilityServiceInfo#FLAG_RETRIEVE_INTERACTIVE_WINDOWS}
 * flag.
 * </p>
 *
 * @return The windows if there are windows and the service is can retrieve
 *         them, otherwise an empty list.
 * @apiSince 21
 */

public java.util.List<android.view.accessibility.AccessibilityWindowInfo> getWindows() { throw new RuntimeException("Stub!"); }

/**
 * Gets the root node in the currently active window if this service
 * can retrieve window content. The active window is the one that the user
 * is currently touching or the window with input focus, if the user is not
 * touching any window.
 * <p>
 * The currently active window is defined as the window that most recently fired one
 * of the following events:
 * {@link android.view.accessibility.AccessibilityEvent#TYPE_WINDOW_STATE_CHANGED AccessibilityEvent#TYPE_WINDOW_STATE_CHANGED},
 * {@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_HOVER_ENTER AccessibilityEvent#TYPE_VIEW_HOVER_ENTER},
 * {@link android.view.accessibility.AccessibilityEvent#TYPE_VIEW_HOVER_EXIT AccessibilityEvent#TYPE_VIEW_HOVER_EXIT}.
 * In other words, the last window shown that also has input focus.
 * </p>
 * <p>
 * <strong>Note:</strong> In order to access the root node your service has
 * to declare the capability to retrieve window content by setting the
 * {@link android.R.styleable#AccessibilityService_canRetrieveWindowContent}
 * property in its meta-data. For details refer to {@link #SERVICE_META_DATA}.
 * </p>
 *
 * @return The root node if this service can retrieve window content.
 * @apiSince 16
 */

public android.view.accessibility.AccessibilityNodeInfo getRootInActiveWindow() { throw new RuntimeException("Stub!"); }

/**
 * Disables the service. After calling this method, the service will be disabled and settings
 * will show that it is turned off.
 * @apiSince 24
 */

public final void disableSelf() { throw new RuntimeException("Stub!"); }

/**
 * Returns the magnification controller, which may be used to query and
 * modify the state of display magnification.
 * <p>
 * <strong>Note:</strong> In order to control magnification, your service
 * must declare the capability by setting the
 * {@link android.R.styleable#AccessibilityService_canControlMagnification}
 * property in its meta-data. For more information, see
 * {@link #SERVICE_META_DATA}.
 *
 * @return the magnification controller
 
 * This value will never be {@code null}.
 * @apiSince 24
 */

@androidx.annotation.NonNull
public final android.accessibilityservice.AccessibilityService.MagnificationController getMagnificationController() { throw new RuntimeException("Stub!"); }

/**
 * Get the controller for fingerprint gestures. This feature requires {@link android.accessibilityservice.AccessibilityServiceInfo#CAPABILITY_CAN_REQUEST_FINGERPRINT_GESTURES AccessibilityServiceInfo#CAPABILITY_CAN_REQUEST_FINGERPRINT_GESTURES}.
 *
 *<strong>Note: </strong> The service must be connected before this method is called.
 *
 * <br>
 * Requires {@link android.Manifest.permission#USE_FINGERPRINT}
 * @return The controller for fingerprint gestures, or {@code null} if gestures are unavailable.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public final android.accessibilityservice.FingerprintGestureController getFingerprintGestureController() { throw new RuntimeException("Stub!"); }

/**
 * Dispatch a gesture to the touch screen. Any gestures currently in progress, whether from
 * the user, this service, or another service, will be cancelled.
 * <p>
 * The gesture will be dispatched as if it were performed directly on the screen by a user, so
 * the events may be affected by features such as magnification and explore by touch.
 * </p>
 * <p>
 * <strong>Note:</strong> In order to dispatch gestures, your service
 * must declare the capability by setting the
 * {@link android.R.styleable#AccessibilityService_canPerformGestures}
 * property in its meta-data. For more information, see
 * {@link #SERVICE_META_DATA}.
 * </p>
 *
 * @param gesture The gesture to dispatch
 * This value must never be {@code null}.
 * @param callback The object to call back when the status of the gesture is known. If
 * {@code null}, no status is reported.
 * This value may be {@code null}.
 * @param handler The handler on which to call back the {@code callback} object. If
 * {@code null}, the object is called back on the service's main thread.
 *
 * This value may be {@code null}.
 * @return {@code true} if the gesture is dispatched, {@code false} if not.
 * @apiSince 24
 */

public final boolean dispatchGesture(@androidx.annotation.NonNull android.accessibilityservice.GestureDescription gesture, @androidx.annotation.Nullable android.accessibilityservice.AccessibilityService.GestureResultCallback callback, @androidx.annotation.Nullable android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Returns the soft keyboard controller, which may be used to query and modify the soft keyboard
 * show mode.
 *
 * @return the soft keyboard controller
 
 * This value will never be {@code null}.
 * @apiSince 24
 */

@androidx.annotation.NonNull
public final android.accessibilityservice.AccessibilityService.SoftKeyboardController getSoftKeyboardController() { throw new RuntimeException("Stub!"); }

/**
 * Returns the controller for the accessibility button within the system's navigation area.
 * This instance may be used to query the accessibility button's state and register listeners
 * for interactions with and state changes for the accessibility button when
 * {@link android.accessibilityservice.AccessibilityServiceInfo#FLAG_REQUEST_ACCESSIBILITY_BUTTON AccessibilityServiceInfo#FLAG_REQUEST_ACCESSIBILITY_BUTTON} is set.
 * <p>
 * <strong>Note:</strong> Not all devices are capable of displaying the accessibility button
 * within a navigation area, and as such, use of this class should be considered only as an
 * optional feature or shortcut on supported device implementations.
 * </p>
 *
 * @return the accessibility button controller for this {@link android.accessibilityservice.AccessibilityService AccessibilityService}
 
 * This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public final android.accessibilityservice.AccessibilityButtonController getAccessibilityButtonController() { throw new RuntimeException("Stub!"); }

/**
 * Performs a global action. Such an action can be performed
 * at any moment regardless of the current application or user
 * location in that application. For example going back, going
 * home, opening recents, etc.
 *
 * @param action The action to perform.
 * @return Whether the action was successfully performed.
 *
 * @see #GLOBAL_ACTION_BACK
 * @see #GLOBAL_ACTION_HOME
 * @see #GLOBAL_ACTION_NOTIFICATIONS
 * @see #GLOBAL_ACTION_RECENTS
 * @apiSince 16
 */

public final boolean performGlobalAction(int action) { throw new RuntimeException("Stub!"); }

/**
 * Find the view that has the specified focus type. The search is performed
 * across all windows.
 * <p>
 * <strong>Note:</strong> In order to access the windows your service has
 * to declare the capability to retrieve window content by setting the
 * {@link android.R.styleable#AccessibilityService_canRetrieveWindowContent}
 * property in its meta-data. For details refer to {@link #SERVICE_META_DATA}.
 * Also the service has to opt-in to retrieve the interactive windows by
 * setting the {@link android.accessibilityservice.AccessibilityServiceInfo#FLAG_RETRIEVE_INTERACTIVE_WINDOWS AccessibilityServiceInfo#FLAG_RETRIEVE_INTERACTIVE_WINDOWS}
 * flag. Otherwise, the search will be performed only in the active window.
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
 * Gets the an {@link android.accessibilityservice.AccessibilityServiceInfo AccessibilityServiceInfo} describing this
 * {@link android.accessibilityservice.AccessibilityService AccessibilityService}. This method is useful if one wants
 * to change some of the dynamically configurable properties at
 * runtime.
 *
 * @return The accessibility service info.
 *
 * @see android.accessibilityservice.AccessibilityServiceInfo
 * @apiSince 16
 */

public final android.accessibilityservice.AccessibilityServiceInfo getServiceInfo() { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link android.accessibilityservice.AccessibilityServiceInfo AccessibilityServiceInfo} that describes this service.
 * <p>
 * Note: You can call this method any time but the info will be picked up after
 *       the system has bound to this service and when this method is called thereafter.
 *
 * @param info The info.
 * @apiSince 4
 */

public final void setServiceInfo(android.accessibilityservice.AccessibilityServiceInfo info) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param name Value is {@link android.content.Context#POWER_SERVICE}, {@link android.content.Context#WINDOW_SERVICE}, {@link android.content.Context#LAYOUT_INFLATER_SERVICE}, {@link android.content.Context#ACCOUNT_SERVICE}, {@link android.content.Context#ACTIVITY_SERVICE}, {@link android.content.Context#ALARM_SERVICE}, {@link android.content.Context#NOTIFICATION_SERVICE}, {@link android.content.Context#ACCESSIBILITY_SERVICE}, {@link android.content.Context#CAPTIONING_SERVICE}, {@link android.content.Context#KEYGUARD_SERVICE}, {@link android.content.Context#LOCATION_SERVICE}, {@link android.content.Context#SEARCH_SERVICE}, {@link android.content.Context#SENSOR_SERVICE}, android.content.Context.SENSOR_PRIVACY_SERVICE, {@link android.content.Context#STORAGE_SERVICE}, {@link android.content.Context#STORAGE_STATS_SERVICE}, {@link android.content.Context#WALLPAPER_SERVICE}, android.content.Context.TIME_ZONE_RULES_MANAGER_SERVICE, {@link android.content.Context#VIBRATOR_SERVICE}, {@link android.content.Context#CONNECTIVITY_SERVICE}, {@link android.content.Context#IPSEC_SERVICE}, android.content.Context.TEST_NETWORK_SERVICE, {@link android.content.Context#NETWORK_STATS_SERVICE}, {@link android.content.Context#WIFI_SERVICE}, {@link android.content.Context#WIFI_AWARE_SERVICE}, {@link android.content.Context#WIFI_P2P_SERVICE}, android.content.Context.WIFI_SCANNING_SERVICE, {@link android.content.Context#WIFI_RTT_RANGING_SERVICE}, {@link android.content.Context#NSD_SERVICE}, {@link android.content.Context#AUDIO_SERVICE}, {@link android.content.Context#FINGERPRINT_SERVICE}, {@link android.content.Context#BIOMETRIC_SERVICE}, {@link android.content.Context#MEDIA_ROUTER_SERVICE}, {@link android.content.Context#TELEPHONY_SERVICE}, {@link android.content.Context#TELEPHONY_SUBSCRIPTION_SERVICE}, {@link android.content.Context#CARRIER_CONFIG_SERVICE}, {@link android.content.Context#EUICC_SERVICE}, {@link android.content.Context#TELECOM_SERVICE}, {@link android.content.Context#CLIPBOARD_SERVICE}, {@link android.content.Context#INPUT_METHOD_SERVICE}, {@link android.content.Context#TEXT_SERVICES_MANAGER_SERVICE}, {@link android.content.Context#TEXT_CLASSIFICATION_SERVICE}, {@link android.content.Context#APPWIDGET_SERVICE}, android.content.Context.ROLLBACK_SERVICE, {@link android.content.Context#DROPBOX_SERVICE}, {@link android.content.Context#DEVICE_POLICY_SERVICE}, {@link android.content.Context#UI_MODE_SERVICE}, {@link android.content.Context#DOWNLOAD_SERVICE}, {@link android.content.Context#NFC_SERVICE}, {@link android.content.Context#BLUETOOTH_SERVICE}, {@link android.content.Context#USB_SERVICE}, {@link android.content.Context#LAUNCHER_APPS_SERVICE}, {@link android.content.Context#INPUT_SERVICE}, {@link android.content.Context#DISPLAY_SERVICE}, {@link android.content.Context#USER_SERVICE}, {@link android.content.Context#RESTRICTIONS_SERVICE}, {@link android.content.Context#APP_OPS_SERVICE}, {@link android.content.Context#ROLE_SERVICE}, {@link android.content.Context#CAMERA_SERVICE}, {@link android.content.Context#PRINT_SERVICE}, {@link android.content.Context#CONSUMER_IR_SERVICE}, {@link android.content.Context#TV_INPUT_SERVICE}, {@link android.content.Context#USAGE_STATS_SERVICE}, {@link android.content.Context#MEDIA_SESSION_SERVICE}, {@link android.content.Context#BATTERY_SERVICE}, {@link android.content.Context#JOB_SCHEDULER_SERVICE}, {@link android.content.Context#MEDIA_PROJECTION_SERVICE}, {@link android.content.Context#MIDI_SERVICE}, android.content.Context.RADIO_SERVICE, {@link android.content.Context#HARDWARE_PROPERTIES_SERVICE}, {@link android.content.Context#SHORTCUT_SERVICE}, {@link android.content.Context#SYSTEM_HEALTH_SERVICE}, {@link android.content.Context#COMPANION_DEVICE_SERVICE}, {@link android.content.Context#CROSS_PROFILE_APPS_SERVICE}, or android.content.Context.PERMISSION_SERVICE
 
 * This value must never be {@code null}.
 * @apiSince 4
 */

public java.lang.Object getSystemService(@androidx.annotation.NonNull java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Implement to return the implementation of the internal accessibility
 * service interface.
 * @apiSince 4
 */

public final android.os.IBinder onBind(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * The user has performed a swipe down gesture on the touch screen.
 * @apiSince 16
 */

public static final int GESTURE_SWIPE_DOWN = 2; // 0x2

/**
 * The user has performed an down and left gesture on the touch screen.
 * @apiSince 16
 */

public static final int GESTURE_SWIPE_DOWN_AND_LEFT = 15; // 0xf

/**
 * The user has performed an down and right gesture on the touch screen.
 * @apiSince 16
 */

public static final int GESTURE_SWIPE_DOWN_AND_RIGHT = 16; // 0x10

/**
 * The user has performed a swipe down and up gesture on the touch screen.
 * @apiSince 16
 */

public static final int GESTURE_SWIPE_DOWN_AND_UP = 8; // 0x8

/**
 * The user has performed a swipe left gesture on the touch screen.
 * @apiSince 16
 */

public static final int GESTURE_SWIPE_LEFT = 3; // 0x3

/**
 * The user has performed a left and down gesture on the touch screen.
 * @apiSince 16
 */

public static final int GESTURE_SWIPE_LEFT_AND_DOWN = 10; // 0xa

/**
 * The user has performed a swipe left and right gesture on the touch screen.
 * @apiSince 16
 */

public static final int GESTURE_SWIPE_LEFT_AND_RIGHT = 5; // 0x5

/**
 * The user has performed a left and up gesture on the touch screen.
 * @apiSince 16
 */

public static final int GESTURE_SWIPE_LEFT_AND_UP = 9; // 0x9

/**
 * The user has performed a swipe right gesture on the touch screen.
 * @apiSince 16
 */

public static final int GESTURE_SWIPE_RIGHT = 4; // 0x4

/**
 * The user has performed a right and down gesture on the touch screen.
 * @apiSince 16
 */

public static final int GESTURE_SWIPE_RIGHT_AND_DOWN = 12; // 0xc

/**
 * The user has performed a swipe right and left gesture on the touch screen.
 * @apiSince 16
 */

public static final int GESTURE_SWIPE_RIGHT_AND_LEFT = 6; // 0x6

/**
 * The user has performed a right and up gesture on the touch screen.
 * @apiSince 16
 */

public static final int GESTURE_SWIPE_RIGHT_AND_UP = 11; // 0xb

/**
 * The user has performed a swipe up gesture on the touch screen.
 * @apiSince 16
 */

public static final int GESTURE_SWIPE_UP = 1; // 0x1

/**
 * The user has performed a swipe up and down gesture on the touch screen.
 * @apiSince 16
 */

public static final int GESTURE_SWIPE_UP_AND_DOWN = 7; // 0x7

/**
 * The user has performed an up and left gesture on the touch screen.
 * @apiSince 16
 */

public static final int GESTURE_SWIPE_UP_AND_LEFT = 13; // 0xd

/**
 * The user has performed an up and right gesture on the touch screen.
 * @apiSince 16
 */

public static final int GESTURE_SWIPE_UP_AND_RIGHT = 14; // 0xe

/**
 * Action to go back.
 * @apiSince 16
 */

public static final int GLOBAL_ACTION_BACK = 1; // 0x1

/**
 * Action to go home.
 * @apiSince 16
 */

public static final int GLOBAL_ACTION_HOME = 2; // 0x2

/**
 * Action to lock the screen
 * @apiSince 28
 */

public static final int GLOBAL_ACTION_LOCK_SCREEN = 8; // 0x8

/**
 * Action to open the notifications.
 * @apiSince 16
 */

public static final int GLOBAL_ACTION_NOTIFICATIONS = 4; // 0x4

/**
 * Action to open the power long-press dialog.
 * @apiSince 21
 */

public static final int GLOBAL_ACTION_POWER_DIALOG = 6; // 0x6

/**
 * Action to open the quick settings.
 * @apiSince 17
 */

public static final int GLOBAL_ACTION_QUICK_SETTINGS = 5; // 0x5

/**
 * Action to toggle showing the overview of recent apps. Will fail on platforms that don't
 * show recent apps.
 * @apiSince 16
 */

public static final int GLOBAL_ACTION_RECENTS = 3; // 0x3

/**
 * Action to take a screenshot
 * @apiSince 28
 */

public static final int GLOBAL_ACTION_TAKE_SCREENSHOT = 9; // 0x9

/**
 * Action to toggle docking the current app's window
 * @apiSince 24
 */

public static final int GLOBAL_ACTION_TOGGLE_SPLIT_SCREEN = 7; // 0x7

/**
 * The {@link android.content.Intent Intent} that must be declared as handled by the service.
 * @apiSince 4
 */

public static final java.lang.String SERVICE_INTERFACE = "android.accessibilityservice.AccessibilityService";

/**
 * Name under which an AccessibilityService component publishes information
 * about itself. This meta-data must reference an XML resource containing an
 * <code>&lt;{@link android.R.styleable#AccessibilityService accessibility-service}&gt;</code>
 * tag. This is a sample XML file configuring an accessibility service:
 * <pre> &lt;accessibility-service
 *     android:accessibilityEventTypes="typeViewClicked|typeViewFocused"
 *     android:packageNames="foo.bar, foo.baz"
 *     android:accessibilityFeedbackType="feedbackSpoken"
 *     android:notificationTimeout="100"
 *     android:accessibilityFlags="flagDefault"
 *     android:settingsActivity="foo.bar.TestBackActivity"
 *     android:canRetrieveWindowContent="true"
 *     android:canRequestTouchExplorationMode="true"
 *     . . .
 * /&gt;</pre>
 * @apiSince 14
 */

public static final java.lang.String SERVICE_META_DATA = "android.accessibilityservice";

/**
 * Allow the system to control when the soft keyboard is shown.
 * @see android.accessibilityservice.AccessibilityService.SoftKeyboardController
 * @apiSince 24
 */

public static final int SHOW_MODE_AUTO = 0; // 0x0

/**
 * Never show the soft keyboard.
 * @see android.accessibilityservice.AccessibilityService.SoftKeyboardController
 * @apiSince 24
 */

public static final int SHOW_MODE_HIDDEN = 1; // 0x1

/**
 * Allow the soft keyboard to be shown, even if a hard keyboard is connected
 * @see android.accessibilityservice.AccessibilityService.SoftKeyboardController
 * @apiSince 29
 */

public static final int SHOW_MODE_IGNORE_HARD_KEYBOARD = 2; // 0x2
/**
 * Class used to report status of dispatched gestures
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class GestureResultCallback {

public GestureResultCallback() { throw new RuntimeException("Stub!"); }

/** Called when the gesture has completed successfully
 *
 * @param gestureDescription The description of the gesture that completed.
 @apiSince 24
 */

public void onCompleted(android.accessibilityservice.GestureDescription gestureDescription) { throw new RuntimeException("Stub!"); }

/** Called when the gesture was cancelled
 *
 * @param gestureDescription The description of the gesture that was cancelled.
 @apiSince 24
 */

public void onCancelled(android.accessibilityservice.GestureDescription gestureDescription) { throw new RuntimeException("Stub!"); }
}

/**
 * Used to control and query the state of display magnification.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class MagnificationController {

MagnificationController() { throw new RuntimeException("Stub!"); }

/**
 * Adds the specified change listener to the list of magnification
 * change listeners. The callback will occur on the service's main
 * thread.
 *
 * @param listener the listener to add, must be non-{@code null}
 
 * This value must never be {@code null}.
 * @apiSince 24
 */

public void addListener(@androidx.annotation.NonNull android.accessibilityservice.AccessibilityService.MagnificationController.OnMagnificationChangedListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Adds the specified change listener to the list of magnification
 * change listeners. The callback will occur on the specified
 * {@link android.os.Handler Handler}'s thread, or on the service's main thread if the
 * handler is {@code null}.
 *
 * @param listener the listener to add, must be non-null
 * This value must never be {@code null}.
 * @param handler the handler on which the callback should execute, or
 *        {@code null} to execute on the service's main thread
 
 * This value may be {@code null}.
 * @apiSince 24
 */

public void addListener(@androidx.annotation.NonNull android.accessibilityservice.AccessibilityService.MagnificationController.OnMagnificationChangedListener listener, @androidx.annotation.Nullable android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Removes the specified change listener from the list of magnification change listeners.
 *
 * @param listener the listener to remove, must be non-null
 * This value must never be {@code null}.
 * @return {@code true} if the listener was removed, {@code false} otherwise
 * @apiSince 24
 */

public boolean removeListener(@androidx.annotation.NonNull android.accessibilityservice.AccessibilityService.MagnificationController.OnMagnificationChangedListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current magnification scale.
 * <p>
 * <strong>Note:</strong> If the service is not yet connected (e.g.
 * {@link android.accessibilityservice.AccessibilityService#onServiceConnected() AccessibilityService#onServiceConnected()} has not yet been
 * called) or the service has been disconnected, this method will
 * return a default value of {@code 1.0f}.
 *
 * @return the current magnification scale
 * @apiSince 24
 */

public float getScale() { throw new RuntimeException("Stub!"); }

/**
 * Returns the unscaled screen-relative X coordinate of the focal
 * center of the magnified region. This is the point around which
 * zooming occurs and is guaranteed to lie within the magnified
 * region.
 * <p>
 * <strong>Note:</strong> If the service is not yet connected (e.g.
 * {@link android.accessibilityservice.AccessibilityService#onServiceConnected() AccessibilityService#onServiceConnected()} has not yet been
 * called) or the service has been disconnected, this method will
 * return a default value of {@code 0.0f}.
 *
 * @return the unscaled screen-relative X coordinate of the center of
 *         the magnified region
 * @apiSince 24
 */

public float getCenterX() { throw new RuntimeException("Stub!"); }

/**
 * Returns the unscaled screen-relative Y coordinate of the focal
 * center of the magnified region. This is the point around which
 * zooming occurs and is guaranteed to lie within the magnified
 * region.
 * <p>
 * <strong>Note:</strong> If the service is not yet connected (e.g.
 * {@link android.accessibilityservice.AccessibilityService#onServiceConnected() AccessibilityService#onServiceConnected()} has not yet been
 * called) or the service has been disconnected, this method will
 * return a default value of {@code 0.0f}.
 *
 * @return the unscaled screen-relative Y coordinate of the center of
 *         the magnified region
 * @apiSince 24
 */

public float getCenterY() { throw new RuntimeException("Stub!"); }

/**
 * Returns the region of the screen currently active for magnification. Changes to
 * magnification scale and center only affect this portion of the screen. The rest of the
 * screen, for example input methods, cannot be magnified. This region is relative to the
 * unscaled screen and is independent of the scale and center point.
 * <p>
 * The returned region will be empty if magnification is not active. Magnification is active
 * if magnification gestures are enabled or if a service is running that can control
 * magnification.
 * <p>
 * <strong>Note:</strong> If the service is not yet connected (e.g.
 * {@link android.accessibilityservice.AccessibilityService#onServiceConnected() AccessibilityService#onServiceConnected()} has not yet been
 * called) or the service has been disconnected, this method will
 * return an empty region.
 *
 * @return the region of the screen currently active for magnification, or an empty region
 * if magnification is not active.
 
 * This value will never be {@code null}.
 * @apiSince 24
 */

@androidx.annotation.NonNull
public android.graphics.Region getMagnificationRegion() { throw new RuntimeException("Stub!"); }

/**
 * Resets magnification scale and center to their default (e.g.&nbsp;no
 * magnification) values.
 * <p>
 * <strong>Note:</strong> If the service is not yet connected (e.g.
 * {@link android.accessibilityservice.AccessibilityService#onServiceConnected() AccessibilityService#onServiceConnected()} has not yet been
 * called) or the service has been disconnected, this method will have
 * no effect and return {@code false}.
 *
 * @param animate {@code true} to animate from the current scale and
 *                center or {@code false} to reset the scale and center
 *                immediately
 * @return {@code true} on success, {@code false} on failure
 * @apiSince 24
 */

public boolean reset(boolean animate) { throw new RuntimeException("Stub!"); }

/**
 * Sets the magnification scale.
 * <p>
 * <strong>Note:</strong> If the service is not yet connected (e.g.
 * {@link android.accessibilityservice.AccessibilityService#onServiceConnected() AccessibilityService#onServiceConnected()} has not yet been
 * called) or the service has been disconnected, this method will have
 * no effect and return {@code false}.
 *
 * @param scale the magnification scale to set, must be >= 1 and <= 8
 * @param animate {@code true} to animate from the current scale or
 *                {@code false} to set the scale immediately
 * @return {@code true} on success, {@code false} on failure
 * @apiSince 24
 */

public boolean setScale(float scale, boolean animate) { throw new RuntimeException("Stub!"); }

/**
 * Sets the center of the magnified viewport.
 * <p>
 * <strong>Note:</strong> If the service is not yet connected (e.g.
 * {@link android.accessibilityservice.AccessibilityService#onServiceConnected() AccessibilityService#onServiceConnected()} has not yet been
 * called) or the service has been disconnected, this method will have
 * no effect and return {@code false}.
 *
 * @param centerX the unscaled screen-relative X coordinate on which to
 *                center the viewport
 * @param centerY the unscaled screen-relative Y coordinate on which to
 *                center the viewport
 * @param animate {@code true} to animate from the current viewport
 *                center or {@code false} to set the center immediately
 * @return {@code true} on success, {@code false} on failure
 * @apiSince 24
 */

public boolean setCenter(float centerX, float centerY, boolean animate) { throw new RuntimeException("Stub!"); }
/**
 * Listener for changes in the state of magnification.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnMagnificationChangedListener {

/**
 * Called when the magnified region, scale, or center changes.
 *
 * @param controller the magnification controller
 * This value must never be {@code null}.
 * @param region the magnification region
 * This value must never be {@code null}.
 * @param scale the new scale
 * @param centerX the new X coordinate, in unscaled coordinates, around which
 * magnification is focused
 * @param centerY the new Y coordinate, in unscaled coordinates, around which
 * magnification is focused
 * @apiSince 24
 */

public void onMagnificationChanged(@androidx.annotation.NonNull android.accessibilityservice.AccessibilityService.MagnificationController controller, @androidx.annotation.NonNull android.graphics.Region region, float scale, float centerX, float centerY);
}

}

/**
 * Used to control, query, and listen for changes to the soft keyboard show mode.
 * <p>
 * Accessibility services may request to override the decisions normally made about whether or
 * not the soft keyboard is shown.
 * <p>
 * If multiple services make conflicting requests, the last request is honored. A service may
 * register a listener to find out if the mode has changed under it.
 * <p>
 * If the user takes action to override the behavior behavior requested by an accessibility
 * service, the user's request takes precendence, the show mode will be reset to
 * {@link android.accessibilityservice.AccessibilityService#SHOW_MODE_AUTO AccessibilityService#SHOW_MODE_AUTO}, and services will no longer be able to control
 * that aspect of the soft keyboard's behavior.
 * <p>
 * Note: Because soft keyboards are independent apps, the framework does not have total control
 * over their behavior. They may choose to show themselves, or not, without regard to requests
 * made here. So the framework will make a best effort to deliver the behavior requested, but
 * cannot guarantee success.
 *
 * @see android.accessibilityservice.AccessibilityService#SHOW_MODE_AUTO
 * @see android.accessibilityservice.AccessibilityService#SHOW_MODE_HIDDEN
 * @see android.accessibilityservice.AccessibilityService#SHOW_MODE_IGNORE_HARD_KEYBOARD
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class SoftKeyboardController {

SoftKeyboardController() { throw new RuntimeException("Stub!"); }

/**
 * Adds the specified change listener to the list of show mode change listeners. The
 * callback will occur on the service's main thread. Listener is not called on registration.
 
 * @param listener This value must never be {@code null}.
 * @apiSince 24
 */

public void addOnShowModeChangedListener(@androidx.annotation.NonNull android.accessibilityservice.AccessibilityService.SoftKeyboardController.OnShowModeChangedListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Adds the specified change listener to the list of soft keyboard show mode change
 * listeners. The callback will occur on the specified {@link android.os.Handler Handler}'s thread, or on the
 * services's main thread if the handler is {@code null}.
 *
 * @param listener the listener to add, must be non-null
 * This value must never be {@code null}.
 * @param handler the handler on which to callback should execute, or {@code null} to
 *        execute on the service's main thread
 
 * This value may be {@code null}.
 * @apiSince 24
 */

public void addOnShowModeChangedListener(@androidx.annotation.NonNull android.accessibilityservice.AccessibilityService.SoftKeyboardController.OnShowModeChangedListener listener, @androidx.annotation.Nullable android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Removes the specified change listener from the list of keyboard show mode change
 * listeners.
 *
 * @param listener the listener to remove, must be non-null
 * This value must never be {@code null}.
 * @return {@code true} if the listener was removed, {@code false} otherwise
 * @apiSince 24
 */

public boolean removeOnShowModeChangedListener(@androidx.annotation.NonNull android.accessibilityservice.AccessibilityService.SoftKeyboardController.OnShowModeChangedListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Returns the show mode of the soft keyboard.
 *
 * @return the current soft keyboard show mode
 *
 * Value is {@link android.accessibilityservice.AccessibilityService#SHOW_MODE_AUTO}, {@link android.accessibilityservice.AccessibilityService#SHOW_MODE_HIDDEN}, or {@link android.accessibilityservice.AccessibilityService#SHOW_MODE_IGNORE_HARD_KEYBOARD}
 * @see android.accessibilityservice.AccessibilityService#SHOW_MODE_AUTO
 * @see android.accessibilityservice.AccessibilityService#SHOW_MODE_HIDDEN
 * @see android.accessibilityservice.AccessibilityService#SHOW_MODE_IGNORE_HARD_KEYBOARD
 * @apiSince 24
 */

public int getShowMode() { throw new RuntimeException("Stub!"); }

/**
 * Sets the soft keyboard show mode.
 * <p>
 * <strong>Note:</strong> If the service is not yet connected (e.g.
 * {@link android.accessibilityservice.AccessibilityService#onServiceConnected() AccessibilityService#onServiceConnected()} has not yet been called) or the
 * service has been disconnected, this method will have no effect and return {@code false}.
 *
 * @param showMode the new show mode for the soft keyboard
 * Value is {@link android.accessibilityservice.AccessibilityService#SHOW_MODE_AUTO}, {@link android.accessibilityservice.AccessibilityService#SHOW_MODE_HIDDEN}, or {@link android.accessibilityservice.AccessibilityService#SHOW_MODE_IGNORE_HARD_KEYBOARD}
 * @return {@code true} on success
 *
 * @see android.accessibilityservice.AccessibilityService#SHOW_MODE_AUTO
 * @see android.accessibilityservice.AccessibilityService#SHOW_MODE_HIDDEN
 * @see android.accessibilityservice.AccessibilityService#SHOW_MODE_IGNORE_HARD_KEYBOARD
 * @apiSince 24
 */

public boolean setShowMode(int showMode) { throw new RuntimeException("Stub!"); }
/**
 * Listener for changes in the soft keyboard show mode.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnShowModeChangedListener {

/**
 * Called when the soft keyboard behavior changes. The default show mode is
 * {@code SHOW_MODE_AUTO}, where the soft keyboard is shown when a text input field is
 * focused. An AccessibilityService can also request the show mode
 * {@code SHOW_MODE_HIDDEN}, where the soft keyboard is never shown.
 *
 * @param controller the soft keyboard controller
 * This value must never be {@code null}.
 * @param showMode the current soft keyboard show mode
 
 * Value is {@link android.accessibilityservice.AccessibilityService#SHOW_MODE_AUTO}, {@link android.accessibilityservice.AccessibilityService#SHOW_MODE_HIDDEN}, or {@link android.accessibilityservice.AccessibilityService#SHOW_MODE_IGNORE_HARD_KEYBOARD}
 * @apiSince 24
 */

public void onShowModeChanged(@androidx.annotation.NonNull android.accessibilityservice.AccessibilityService.SoftKeyboardController controller, int showMode);
}

}

}

