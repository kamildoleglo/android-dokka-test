/*
 * Copyright (C) 2010 The Android Open Source Project
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

import android.content.res.Configuration;

/**
 * This class provides access to the system uimode services.  These services
 * allow applications to control UI modes of the device.
 * It provides functionality to disable the car mode and it gives access to the
 * night mode settings.
 *
 * <p>These facilities are built on top of the underlying
 * {@link android.content.Intent#ACTION_DOCK_EVENT} broadcasts that are sent when the user
 * physical places the device into and out of a dock.  When that happens,
 * the UiModeManager switches the system {@link android.content.res.Configuration}
 * to the appropriate UI mode, sends broadcasts about the mode switch, and
 * starts the corresponding mode activity if appropriate.  See the
 * broadcasts {@link #ACTION_ENTER_CAR_MODE} and
 * {@link #ACTION_ENTER_DESK_MODE} for more information.
 *
 * <p>In addition, the user may manually switch the system to car mode without
 * physically being in a dock.  While in car mode -- whether by manual action
 * from the user or being physically placed in a dock -- a notification is
 * displayed allowing the user to exit dock mode.  Thus the dock mode
 * represented here may be different than the current state of the underlying
 * dock event broadcast.
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class UiModeManager {

UiModeManager() { throw new RuntimeException("Stub!"); }

/**
 * Force device into car mode, like it had been placed in the car dock.
 * This will cause the device to switch to the car home UI as part of
 * the mode switch.
 * @param flags Must be 0.
 * @apiSince 8
 */

public void enableCarMode(int flags) { throw new RuntimeException("Stub!"); }

/**
 * Turn off special mode if currently in car mode.
 * @param flags One of the disable car mode flags.
 
 * Value is {@link android.app.UiModeManager#DISABLE_CAR_MODE_GO_HOME}
 * @apiSince 8
 */

public void disableCarMode(int flags) { throw new RuntimeException("Stub!"); }

/**
 * Return the current running mode type.  May be one of
 * {@link android.content.res.Configuration#UI_MODE_TYPE_NORMAL Configuration#UI_MODE_TYPE_NORMAL},
 * {@link android.content.res.Configuration#UI_MODE_TYPE_DESK Configuration#UI_MODE_TYPE_DESK},
 * {@link android.content.res.Configuration#UI_MODE_TYPE_CAR Configuration#UI_MODE_TYPE_CAR},
 * {@link android.content.res.Configuration#UI_MODE_TYPE_TELEVISION Configuration#UI_MODE_TYPE_TELEVISION},
 * {@link android.content.res.Configuration#UI_MODE_TYPE_APPLIANCE Configuration#UI_MODE_TYPE_APPLIANCE},
 * {@link android.content.res.Configuration#UI_MODE_TYPE_WATCH Configuration#UI_MODE_TYPE_WATCH}, or
 * {@link android.content.res.Configuration#UI_MODE_TYPE_VR_HEADSET Configuration#UI_MODE_TYPE_VR_HEADSET}.
 * @apiSince 8
 */

public int getCurrentModeType() { throw new RuntimeException("Stub!"); }

/**
 * Sets the system-wide night mode.
 * <p>
 * The mode can be one of:
 * <ul>
 *   <li><em>{@link #MODE_NIGHT_NO}<em> sets the device into
 *       {@code notnight} mode</li>
 *   <li><em>{@link #MODE_NIGHT_YES}</em> sets the device into
 *       {@code night} mode</li>
 *   <li><em>{@link #MODE_NIGHT_AUTO}</em> automatically switches between
 *       {@code night} and {@code notnight} based on the device's current
 *       location and certain other sensors</li>
 * </ul>
 * <p>
 * <strong>Note:</strong> On API 22 and below, changes to the night mode
 * are only effective when the {@link android.content.res.Configuration#UI_MODE_TYPE_CAR Configuration#UI_MODE_TYPE_CAR}
 * or {@link android.content.res.Configuration#UI_MODE_TYPE_DESK Configuration#UI_MODE_TYPE_DESK} mode is enabled on a
 * device. On API 23 through API 28, changes to night mode are always effective.
 * <p>
 * Starting in API 29, when the device is in car mode and this method is called, night mode
 * will change, but the new setting is not persisted and the previously persisted setting
 * will be restored when the device exits car mode.
 * <p>
 * Changes to night mode take effect globally and will result in a configuration change
 * (and potentially an Activity lifecycle event) being applied to all running apps.
 * Developers interested in an app-local implementation of night mode should consider using
 * {@link android.support.v7.app.AppCompatDelegate#setDefaultNightMode(int)} to manage the
 * -night qualifier locally.
 *
 * @param mode the night mode to set
 * Value is {@link android.app.UiModeManager#MODE_NIGHT_AUTO}, {@link android.app.UiModeManager#MODE_NIGHT_NO}, or {@link android.app.UiModeManager#MODE_NIGHT_YES}
 * @see #getNightMode()
 * @apiSince 8
 */

public void setNightMode(int mode) { throw new RuntimeException("Stub!"); }

/**
 * Returns the currently configured night mode.
 * <p>
 * May be one of:
 * <ul>
 *   <li>{@link #MODE_NIGHT_NO}</li>
 *   <li>{@link #MODE_NIGHT_YES}</li>
 *   <li>{@link #MODE_NIGHT_AUTO}</li>
 *   <li>{@code -1} on error</li>
 * </ul>
 *
 * @return the current night mode, or {@code -1} on error
 * Value is {@link android.app.UiModeManager#MODE_NIGHT_AUTO}, {@link android.app.UiModeManager#MODE_NIGHT_NO}, or {@link android.app.UiModeManager#MODE_NIGHT_YES}
 * @see #setNightMode(int)
 * @apiSince 8
 */

public int getNightMode() { throw new RuntimeException("Stub!"); }

/**
 * Broadcast sent when the device's UI has switched to car mode, either
 * by being placed in a car dock or explicit action of the user.  After
 * sending the broadcast, the system will start the intent
 * {@link android.content.Intent#ACTION_MAIN} with category
 * {@link android.content.Intent#CATEGORY_CAR_DOCK}
 * to display the car UI, which typically what an application would
 * implement to provide their own interface.  However, applications can
 * also monitor this Intent in order to be informed of mode changes or
 * prevent the normal car UI from being displayed by setting the result
 * of the broadcast to {@link android.app.Activity#RESULT_CANCELED Activity#RESULT_CANCELED}.
 * @apiSince 8
 */

public static java.lang.String ACTION_ENTER_CAR_MODE = "android.app.action.ENTER_CAR_MODE";

/**
 * Broadcast sent when the device's UI has switched to desk mode,
 * by being placed in a desk dock.  After
 * sending the broadcast, the system will start the intent
 * {@link android.content.Intent#ACTION_MAIN} with category
 * {@link android.content.Intent#CATEGORY_DESK_DOCK}
 * to display the desk UI, which typically what an application would
 * implement to provide their own interface.  However, applications can
 * also monitor this Intent in order to be informed of mode changes or
 * prevent the normal desk UI from being displayed by setting the result
 * of the broadcast to {@link android.app.Activity#RESULT_CANCELED Activity#RESULT_CANCELED}.
 * @apiSince 8
 */

public static java.lang.String ACTION_ENTER_DESK_MODE = "android.app.action.ENTER_DESK_MODE";

/**
 * Broadcast sent when the device's UI has switch away from car mode back
 * to normal mode.  Typically used by a car mode app, to dismiss itself
 * when the user exits car mode.
 * @apiSince 8
 */

public static java.lang.String ACTION_EXIT_CAR_MODE = "android.app.action.EXIT_CAR_MODE";

/**
 * Broadcast sent when the device's UI has switched away from desk mode back
 * to normal mode.  Typically used by a desk mode app, to dismiss itself
 * when the user exits desk mode.
 * @apiSince 8
 */

public static java.lang.String ACTION_EXIT_DESK_MODE = "android.app.action.EXIT_DESK_MODE";

/**
 * Flag for use with {@link #disableCarMode(int)}: go to the normal
 * home activity as part of the disable.  Disabling this way ensures
 * a clean transition between the current activity (in car mode) and
 * the original home activity (which was typically last running without
 * being in car mode).
 * @apiSince 8
 */

public static final int DISABLE_CAR_MODE_GO_HOME = 1; // 0x1

/**
 * Flag for use with {@link #enableCarMode(int)}: allow sleep mode while in car mode.
 * By default, when this flag is not set, the system may hold a full wake lock to keep the
 * screen turned on and prevent the system from entering sleep mode while in car mode.
 * Setting this flag disables such behavior and the system may enter sleep mode
 * if there is no other user activity and no other wake lock held.
 * Setting this flag can be relevant for a car dock application that does not require the
 * screen kept on.
 * @apiSince 21
 */

public static final int ENABLE_CAR_MODE_ALLOW_SLEEP = 2; // 0x2

/**
 * Flag for use with {@link #enableCarMode(int)}: go to the car
 * home activity as part of the enable.  Enabling this way ensures
 * a clean transition between the current activity (in non-car-mode) and
 * the car home activity that will serve as home while in car mode.  This
 * will switch to the car home activity even if we are already in car mode.
 * @apiSince 8
 */

public static final int ENABLE_CAR_MODE_GO_CAR_HOME = 1; // 0x1

/**
 * Constant for {@link #setNightMode(int)} and {@link #getNightMode()}:
 * automatically switch night mode on and off based on the time.
 * @apiSince 8
 */

public static final int MODE_NIGHT_AUTO = 0; // 0x0

/**
 * Constant for {@link #setNightMode(int)} and {@link #getNightMode()}:
 * never run in night mode.
 * @apiSince 8
 */

public static final int MODE_NIGHT_NO = 1; // 0x1

/**
 * Constant for {@link #setNightMode(int)} and {@link #getNightMode()}:
 * always run in night mode.
 * @apiSince 8
 */

public static final int MODE_NIGHT_YES = 2; // 0x2
}

