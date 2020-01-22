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


package android.os;

import android.content.Context;
import android.Manifest.permission;
import java.util.concurrent.Executor;

/**
 * This class gives you control of the power state of the device.
 *
 * <p>
 * <b>Device battery life will be significantly affected by the use of this API.</b>
 * Do not acquire {@link android.os.PowerManager.WakeLock WakeLock}s unless you really need them, use the minimum levels
 * possible, and be sure to release them as soon as possible.
 * </p><p>
 * The primary API you'll use is {@link #newWakeLock(int,java.lang.String) newWakeLock()}.
 * This will create a {@link android.os.PowerManager.WakeLock PowerManager.WakeLock} object.  You can then use methods
 * on the wake lock object to control the power state of the device.
 * </p><p>
 * In practice it's quite simple:
 * {@samplecode
 * PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
 * PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "My Tag");
 * wl.acquire();
 *   ..screen will stay on during this section..
 * wl.release();
 * }
 * </p><p>
 * The following wake lock levels are defined, with varying effects on system power.
 * <i>These levels are mutually exclusive - you may only specify one of them.</i>
 *
 * <table>
 *     <tr><th>Flag Value</th>
 *     <th>CPU</th> <th>Screen</th> <th>Keyboard</th></tr>
 *
 *     <tr><td>{@link #PARTIAL_WAKE_LOCK}</td>
 *         <td>On*</td> <td>Off</td> <td>Off</td>
 *     </tr>
 *
 *     <tr><td>{@link #SCREEN_DIM_WAKE_LOCK}</td>
 *         <td>On</td> <td>Dim</td> <td>Off</td>
 *     </tr>
 *
 *     <tr><td>{@link #SCREEN_BRIGHT_WAKE_LOCK}</td>
 *         <td>On</td> <td>Bright</td> <td>Off</td>
 *     </tr>
 *
 *     <tr><td>{@link #FULL_WAKE_LOCK}</td>
 *         <td>On</td> <td>Bright</td> <td>Bright</td>
 *     </tr>
 * </table>
 * </p><p>
 * *<i>If you hold a partial wake lock, the CPU will continue to run, regardless of any
 * display timeouts or the state of the screen and even after the user presses the power button.
 * In all other wake locks, the CPU will run, but the user can still put the device to sleep
 * using the power button.</i>
 * </p><p>
 * In addition, you can add two more flags, which affect behavior of the screen only.
 * <i>These flags have no effect when combined with a {@link #PARTIAL_WAKE_LOCK}.</i></p>
 *
 * <table>
 *     <tr><th>Flag Value</th> <th>Description</th></tr>
 *
 *     <tr><td>{@link #ACQUIRE_CAUSES_WAKEUP}</td>
 *         <td>Normal wake locks don't actually turn on the illumination.  Instead, they cause
 *         the illumination to remain on once it turns on (e.g. from user activity).  This flag
 *         will force the screen and/or keyboard to turn on immediately, when the WakeLock is
 *         acquired.  A typical use would be for notifications which are important for the user to
 *         see immediately.</td>
 *     </tr>
 *
 *     <tr><td>{@link #ON_AFTER_RELEASE}</td>
 *         <td>If this flag is set, the user activity timer will be reset when the WakeLock is
 *         released, causing the illumination to remain on a bit longer.  This can be used to
 *         reduce flicker if you are cycling between wake lock conditions.</td>
 *     </tr>
 * </table>
 * <p>
 * Any application using a WakeLock must request the {@code android.permission.WAKE_LOCK}
 * permission in an {@code <uses-permission>} element of the application's manifest.
 * </p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class PowerManager {

PowerManager() { throw new RuntimeException("Stub!"); }

/**
 * Creates a new wake lock with the specified level and flags.
 * <p>
 * The {@code levelAndFlags} parameter specifies a wake lock level and optional flags
 * combined using the logical OR operator.
 * </p><p>
 * The wake lock levels are: {@link #PARTIAL_WAKE_LOCK},
 * {@link #FULL_WAKE_LOCK}, {@link #SCREEN_DIM_WAKE_LOCK}
 * and {@link #SCREEN_BRIGHT_WAKE_LOCK}.  Exactly one wake lock level must be
 * specified as part of the {@code levelAndFlags} parameter.
 * </p><p>
 * The wake lock flags are: {@link #ACQUIRE_CAUSES_WAKEUP}
 * and {@link #ON_AFTER_RELEASE}.  Multiple flags can be combined as part of the
 * {@code levelAndFlags} parameters.
 * </p><p>
 * Call {@link android.os.PowerManager.WakeLock#acquire() WakeLock#acquire()} on the object to acquire the
 * wake lock, and {@link android.os.PowerManager.WakeLock#release WakeLock#release} when you are done.
 * </p><p>
 * {@samplecode
 * PowerManager pm = (PowerManager)mContext.getSystemService(
 *                                          Context.POWER_SERVICE);
 * PowerManager.WakeLock wl = pm.newWakeLock(
 *                                      PowerManager.SCREEN_DIM_WAKE_LOCK
 *                                      | PowerManager.ON_AFTER_RELEASE,
 *                                      TAG);
 * wl.acquire();
 * // ... do work...
 * wl.release();
 * }
 * </p><p>
 * Although a wake lock can be created without special permissions,
 * the {@link android.Manifest.permission#WAKE_LOCK} permission is
 * required to actually acquire or release the wake lock that is returned.
 * </p><p class="note">
 * If using this to keep the screen on, you should strongly consider using
 * {@link android.view.WindowManager.LayoutParams#FLAG_KEEP_SCREEN_ON} instead.
 * This window flag will be correctly managed by the platform
 * as the user moves between applications and doesn't require a special permission.
 * </p>
 *
 * <p>
 * Recommended naming conventions for tags to make debugging easier:
 * <ul>
 * <li>use a unique prefix delimited by a colon for your app/library (e.g.
 * gmail:mytag) to make it easier to understand where the wake locks comes
 * from. This namespace will also avoid collision for tags inside your app
 * coming from different libraries which will make debugging easier.
 * <li>use constants (e.g. do not include timestamps in the tag) to make it
 * easier for tools to aggregate similar wake locks. When collecting
 * debugging data, the platform only monitors a finite number of tags,
 * using constants will help tools to provide better debugging data.
 * <li>avoid using Class#getName() or similar method since this class name
 * can be transformed by java optimizer and obfuscator tools.
 * <li>avoid wrapping the tag or a prefix to avoid collision with wake lock
 * tags from the platform (e.g. *alarm*).
 * <li>never include personnally identifiable information for privacy
 * reasons.
 * </ul>
 * </p>
 *
 * @param levelAndFlags Combination of wake lock level and flag values defining
 * the requested behavior of the WakeLock.
 * @param tag Your class name (or other tag) for debugging purposes.
 *
 * @see android.os.PowerManager.WakeLock#acquire()
 * @see android.os.PowerManager.WakeLock#release()
 * @see #PARTIAL_WAKE_LOCK
 * @see #FULL_WAKE_LOCK
 * @see #SCREEN_DIM_WAKE_LOCK
 * @see #SCREEN_BRIGHT_WAKE_LOCK
 * @see #PROXIMITY_SCREEN_OFF_WAKE_LOCK
 * @see #ACQUIRE_CAUSES_WAKEUP
 * @see #ON_AFTER_RELEASE
 * @apiSince 1
 */

public android.os.PowerManager.WakeLock newWakeLock(int levelAndFlags, java.lang.String tag) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the specified wake lock level is supported.
 *
 * @param level The wake lock level to check.
 * @return True if the specified wake lock level is supported.
 * @apiSince 21
 */

public boolean isWakeLockLevelSupported(int level) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the device is in an interactive state.
 * <p>
 * For historical reasons, the name of this method refers to the power state of
 * the screen but it actually describes the overall interactive state of
 * the device.  This method has been replaced by {@link #isInteractive}.
 * </p><p>
 * The value returned by this method only indicates whether the device is
 * in an interactive state which may have nothing to do with the screen being
 * on or off.  To determine the actual state of the screen,
 * use {@link android.view.Display#getState}.
 * </p>
 *
 * @return True if the device is in an interactive state.
 *
 * @deprecated Use {@link #isInteractive} instead.
 * @apiSince 7
 * @deprecatedSince 20
 */

@Deprecated
public boolean isScreenOn() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the device is in an interactive state.
 * <p>
 * When this method returns true, the device is awake and ready to interact
 * with the user (although this is not a guarantee that the user is actively
 * interacting with the device just this moment).  The main screen is usually
 * turned on while in this state.  Certain features, such as the proximity
 * sensor, may temporarily turn off the screen while still leaving the device in an
 * interactive state.  Note in particular that the device is still considered
 * to be interactive while dreaming (since dreams can be interactive) but not
 * when it is dozing or asleep.
 * </p><p>
 * When this method returns false, the device is dozing or asleep and must
 * be awoken before it will become ready to interact with the user again.  The
 * main screen is usually turned off while in this state.  Certain features,
 * such as "ambient mode" may cause the main screen to remain on (albeit in a
 * low power state) to display system-provided content while the device dozes.
 * </p><p>
 * The system will send a {@link android.content.Intent#ACTION_SCREEN_ON screen on}
 * or {@link android.content.Intent#ACTION_SCREEN_OFF screen off} broadcast
 * whenever the interactive state of the device changes.  For historical reasons,
 * the names of these broadcasts refer to the power state of the screen
 * but they are actually sent in response to changes in the overall interactive
 * state of the device, as described by this method.
 * </p><p>
 * Services may use the non-interactive state as a hint to conserve power
 * since the user is not present.
 * </p>
 *
 * @return True if the device is in an interactive state.
 *
 * @see android.content.Intent#ACTION_SCREEN_ON
 * @see android.content.Intent#ACTION_SCREEN_OFF
 * @apiSince 20
 */

public boolean isInteractive() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this device supports rebooting userspace.
 * @apiSince R
 */

public boolean isRebootingUserspaceSupported() { throw new RuntimeException("Stub!"); }

/**
 * Reboot the device.  Will not return if the reboot is successful.
 * <p>
 * Requires the {@link android.Manifest.permission#REBOOT} permission.
 * </p>
 *
 * @param reason code to pass to the kernel (e.g., "recovery") to
 *               request special boot modes, or null.
 * This value may be {@code null}.
 * @throws java.lang.UnsupportedOperationException if userspace reboot was requested on a device that
 *                                       doesn't support it.
 * @apiSince 8
 */

public void reboot(@androidx.annotation.Nullable java.lang.String reason) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the device is currently in power save mode.  When in this mode,
 * applications should reduce their functionality in order to conserve battery as
 * much as possible.  You can monitor for changes to this state with
 * {@link #ACTION_POWER_SAVE_MODE_CHANGED}.
 *
 * @return Returns true if currently in low power mode, else false.
 * @apiSince 21
 */

public boolean isPowerSaveMode() { throw new RuntimeException("Stub!"); }

/**
 * Returns how location features should behave when battery saver is on. When battery saver
 * is off, this will always return {@link #LOCATION_MODE_NO_CHANGE}.
 *
 * <p>This API is normally only useful for components that provide location features.
 *
 * @see #isPowerSaveMode()
 * @see #ACTION_POWER_SAVE_MODE_CHANGED
 
 * @return Value is {@link android.os.PowerManager#LOCATION_MODE_NO_CHANGE}, {@link android.os.PowerManager#LOCATION_MODE_GPS_DISABLED_WHEN_SCREEN_OFF}, {@link android.os.PowerManager#LOCATION_MODE_ALL_DISABLED_WHEN_SCREEN_OFF}, {@link android.os.PowerManager#LOCATION_MODE_FOREGROUND_ONLY}, or {@link android.os.PowerManager#LOCATION_MODE_THROTTLE_REQUESTS_WHEN_SCREEN_OFF}
 * @apiSince 28
 */

public int getLocationPowerSaveMode() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the device is currently in idle mode.  This happens when a device
 * has been sitting unused and unmoving for a sufficiently long period of time, so that
 * it decides to go into a lower power-use state.  This may involve things like turning
 * off network access to apps.  You can monitor for changes to this state with
 * {@link #ACTION_DEVICE_IDLE_MODE_CHANGED}.
 *
 * @return Returns true if currently in active device idle mode, else false.  This is
 * when idle mode restrictions are being actively applied; it will return false if the
 * device is in a long-term idle mode but currently running a maintenance window where
 * restrictions have been lifted.
 * @apiSince 23
 */

public boolean isDeviceIdleMode() { throw new RuntimeException("Stub!"); }

/**
 * Return whether the given application package name is on the device's power whitelist.
 * Apps can be placed on the whitelist through the settings UI invoked by
 * {@link android.provider.Settings#ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS}.
 * @apiSince 23
 */

public boolean isIgnoringBatteryOptimizations(java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * This function checks if the device has implemented Sustained Performance
 * Mode. This needs to be checked only once and is constant for a particular
 * device/release.
 *
 * Sustained Performance Mode is intended to provide a consistent level of
 * performance for prolonged amount of time.
 *
 * Applications should check if the device supports this mode, before using
 * {@link android.view.Window#setSustainedPerformanceMode}.
 *
 * @return Returns True if the device supports it, false otherwise.
 *
 * @see android.view.Window#setSustainedPerformanceMode
 * @apiSince 24
 */

public boolean isSustainedPerformanceModeSupported() { throw new RuntimeException("Stub!"); }

/**
 * This function returns the current thermal status of the device.
 *
 * @return thermal status as int, {@link #THERMAL_STATUS_NONE} if device in not under
 * thermal throttling.
 
 * Value is {@link android.os.PowerManager#THERMAL_STATUS_NONE}, {@link android.os.PowerManager#THERMAL_STATUS_LIGHT}, {@link android.os.PowerManager#THERMAL_STATUS_MODERATE}, {@link android.os.PowerManager#THERMAL_STATUS_SEVERE}, {@link android.os.PowerManager#THERMAL_STATUS_CRITICAL}, {@link android.os.PowerManager#THERMAL_STATUS_EMERGENCY}, or {@link android.os.PowerManager#THERMAL_STATUS_SHUTDOWN}
 * @apiSince 29
 */

public int getCurrentThermalStatus() { throw new RuntimeException("Stub!"); }

/**
 * This function adds a listener for thermal status change, listen call back will be
 * enqueued tasks on the main thread
 *
 * @param listener listener to be added,
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void addThermalStatusListener(@androidx.annotation.NonNull android.os.PowerManager.OnThermalStatusChangedListener listener) { throw new RuntimeException("Stub!"); }

/**
 * This function adds a listener for thermal status change.
 *
 * @param executor {@link java.util.concurrent.Executor Executor} to handle listener callback.
 * This value must never be {@code null}.
 * Callback and listener events are dispatched through this
 * {@link java.util.concurrent.Executor Executor}, providing an easy way to control which thread is
 * used. To dispatch events through the main thread of your
 * application, you can use {@link android.content.Context#getMainExecutor() Context#getMainExecutor()}. To
 * dispatch events through a shared thread pool, you can use
 * {@link android.os.AsyncTask#THREAD_POOL_EXECUTOR AsyncTask#THREAD_POOL_EXECUTOR}.
 * @param listener listener to be added.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void addThermalStatusListener(@androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull android.os.PowerManager.OnThermalStatusChangedListener listener) { throw new RuntimeException("Stub!"); }

/**
 * This function removes a listener for thermal status change
 *
 * @param listener listener to be removed
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void removeThermalStatusListener(@androidx.annotation.NonNull android.os.PowerManager.OnThermalStatusChangedListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Wake lock flag: Turn the screen on when the wake lock is acquired.
 * <p>
 * Normally wake locks don't actually wake the device, they just cause
 * the screen to remain on once it's already on.  Think of the video player
 * application as the normal behavior.  Notifications that pop up and want
 * the device to be on are the exception; use this flag to be like them.
 * </p><p>
 * Cannot be used with {@link #PARTIAL_WAKE_LOCK}.
 * </p>
 * @apiSince 1
 */

public static final int ACQUIRE_CAUSES_WAKEUP = 268435456; // 0x10000000

/**
 * Intent that is broadcast when the state of {@link #isDeviceIdleMode()} changes.
 * This broadcast is only sent to registered receivers.
 * @apiSince 23
 */

public static final java.lang.String ACTION_DEVICE_IDLE_MODE_CHANGED = "android.os.action.DEVICE_IDLE_MODE_CHANGED";

/**
 * Intent that is broadcast when the state of {@link #isPowerSaveMode()} changes.
 * This broadcast is only sent to registered receivers.
 * @apiSince 21
 */

public static final java.lang.String ACTION_POWER_SAVE_MODE_CHANGED = "android.os.action.POWER_SAVE_MODE_CHANGED";

/**
 * Wake lock level: Ensures that the screen and keyboard backlight are on at
 * full brightness.
 * <p>
 * If the user presses the power button, then the {@link #FULL_WAKE_LOCK} will be
 * implicitly released by the system, causing both the screen and the CPU to be turned off.
 * Contrast with {@link #PARTIAL_WAKE_LOCK}.
 * </p>
 *
 * @deprecated Most applications should use
 * {@link android.view.WindowManager.LayoutParams#FLAG_KEEP_SCREEN_ON} instead
 * of this type of wake lock, as it will be correctly managed by the platform
 * as the user moves between applications and doesn't require a special permission.
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated public static final int FULL_WAKE_LOCK = 26; // 0x1a

/**
 * All location providers should be disabled when battery saver is on and
 * the device is non-interactive.
 * @apiSince 28
 */

public static final int LOCATION_MODE_ALL_DISABLED_WHEN_SCREEN_OFF = 2; // 0x2

/**
 * In this mode, all the location providers will be kept available, but location fixes
 * should only be provided to foreground apps.
 * @apiSince 28
 */

public static final int LOCATION_MODE_FOREGROUND_ONLY = 3; // 0x3

/**
 * In this mode, the GPS based location provider should be disabled when battery saver is on and
 * the device is non-interactive.
 * @apiSince 28
 */

public static final int LOCATION_MODE_GPS_DISABLED_WHEN_SCREEN_OFF = 1; // 0x1

/**
 * Either the location providers shouldn't be affected by battery saver,
 * or battery saver is off.
 * @apiSince 28
 */

public static final int LOCATION_MODE_NO_CHANGE = 0; // 0x0

/**
 * In this mode, location will not be turned off, but LocationManager will throttle all
 * requests to providers when the device is non-interactive.
 * @apiSince 29
 */

public static final int LOCATION_MODE_THROTTLE_REQUESTS_WHEN_SCREEN_OFF = 4; // 0x4

/**
 * Wake lock flag: When this wake lock is released, poke the user activity timer
 * so the screen stays on for a little longer.
 * <p>
 * Will not turn the screen on if it is not already on.
 * See {@link #ACQUIRE_CAUSES_WAKEUP} if you want that.
 * </p><p>
 * Cannot be used with {@link #PARTIAL_WAKE_LOCK}.
 * </p>
 * @apiSince 1
 */

public static final int ON_AFTER_RELEASE = 536870912; // 0x20000000

/**
 * Wake lock level: Ensures that the CPU is running; the screen and keyboard
 * backlight will be allowed to go off.
 * <p>
 * If the user presses the power button, then the screen will be turned off
 * but the CPU will be kept on until all partial wake locks have been released.
 * </p>
 * @apiSince 1
 */

public static final int PARTIAL_WAKE_LOCK = 1; // 0x1

/**
 * Wake lock level: Turns the screen off when the proximity sensor activates.
 * <p>
 * If the proximity sensor detects that an object is nearby, the screen turns off
 * immediately.  Shortly after the object moves away, the screen turns on again.
 * </p><p>
 * A proximity wake lock does not prevent the device from falling asleep
 * unlike {@link #FULL_WAKE_LOCK}, {@link #SCREEN_BRIGHT_WAKE_LOCK} and
 * {@link #SCREEN_DIM_WAKE_LOCK}.  If there is no user activity and no other
 * wake locks are held, then the device will fall asleep (and lock) as usual.
 * However, the device will not fall asleep while the screen has been turned off
 * by the proximity sensor because it effectively counts as ongoing user activity.
 * </p><p>
 * Since not all devices have proximity sensors, use {@link #isWakeLockLevelSupported}
 * to determine whether this wake lock level is supported.
 * </p><p>
 * Cannot be used with {@link #ACQUIRE_CAUSES_WAKEUP}.
 * </p>
 * @apiSince 21
 */

public static final int PROXIMITY_SCREEN_OFF_WAKE_LOCK = 32; // 0x20

/**
 * Flag for {@link android.os.PowerManager.WakeLock#release WakeLock#release}: Defer releasing a
 * {@link #PROXIMITY_SCREEN_OFF_WAKE_LOCK} wake lock until the proximity sensor
 * indicates that an object is not in close proximity.
 * @apiSince 21
 */

public static final int RELEASE_FLAG_WAIT_FOR_NO_PROXIMITY = 1; // 0x1

/**
 * Wake lock level: Ensures that the screen is on at full brightness;
 * the keyboard backlight will be allowed to go off.
 * <p>
 * If the user presses the power button, then the {@link #SCREEN_BRIGHT_WAKE_LOCK} will be
 * implicitly released by the system, causing both the screen and the CPU to be turned off.
 * Contrast with {@link #PARTIAL_WAKE_LOCK}.
 * </p>
 *
 * @deprecated Most applications should use
 * {@link android.view.WindowManager.LayoutParams#FLAG_KEEP_SCREEN_ON} instead
 * of this type of wake lock, as it will be correctly managed by the platform
 * as the user moves between applications and doesn't require a special permission.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int SCREEN_BRIGHT_WAKE_LOCK = 10; // 0xa

/**
 * Wake lock level: Ensures that the screen is on (but may be dimmed);
 * the keyboard backlight will be allowed to go off.
 * <p>
 * If the user presses the power button, then the {@link #SCREEN_DIM_WAKE_LOCK} will be
 * implicitly released by the system, causing both the screen and the CPU to be turned off.
 * Contrast with {@link #PARTIAL_WAKE_LOCK}.
 * </p>
 *
 * @deprecated Most applications should use
 * {@link android.view.WindowManager.LayoutParams#FLAG_KEEP_SCREEN_ON} instead
 * of this type of wake lock, as it will be correctly managed by the platform
 * as the user moves between applications and doesn't require a special permission.
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated public static final int SCREEN_DIM_WAKE_LOCK = 6; // 0x6

/**
 * Thermal status code: Platform has done everything to reduce power.
 * @apiSince 29
 */

public static final int THERMAL_STATUS_CRITICAL = 4; // 0x4

/**
 * Thermal status code: Key components in platform are shutting down due to thermal condition.
 * Device functionalities will be limited.
 * @apiSince 29
 */

public static final int THERMAL_STATUS_EMERGENCY = 5; // 0x5

/**
 * Thermal status code: Light throttling where UX is not impacted.
 * @apiSince 29
 */

public static final int THERMAL_STATUS_LIGHT = 1; // 0x1

/**
 * Thermal status code: Moderate throttling where UX is not largely impacted.
 * @apiSince 29
 */

public static final int THERMAL_STATUS_MODERATE = 2; // 0x2

/**
 * Thermal status code: Not under throttling.
 * @apiSince 29
 */

public static final int THERMAL_STATUS_NONE = 0; // 0x0

/**
 * Thermal status code: Severe throttling where UX is largely impacted.
 * @apiSince 29
 */

public static final int THERMAL_STATUS_SEVERE = 3; // 0x3

/**
 * Thermal status code: Need shutdown immediately.
 * @apiSince 29
 */

public static final int THERMAL_STATUS_SHUTDOWN = 6; // 0x6
/**
 * Listener passed to
 * {@link android.os.PowerManager#addThermalStatusListener PowerManager#addThermalStatusListener} and
 * {@link android.os.PowerManager#removeThermalStatusListener PowerManager#removeThermalStatusListener}
 * to notify caller of thermal status has changed.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnThermalStatusChangedListener {

/**
 * Called when overall thermal throttling status changed.
 * @param status defined in {@link android.os.Temperature}.
 
 * Value is {@link android.os.PowerManager#THERMAL_STATUS_NONE}, {@link android.os.PowerManager#THERMAL_STATUS_LIGHT}, {@link android.os.PowerManager#THERMAL_STATUS_MODERATE}, {@link android.os.PowerManager#THERMAL_STATUS_SEVERE}, {@link android.os.PowerManager#THERMAL_STATUS_CRITICAL}, {@link android.os.PowerManager#THERMAL_STATUS_EMERGENCY}, or {@link android.os.PowerManager#THERMAL_STATUS_SHUTDOWN}
 * @apiSince 29
 */

public void onThermalStatusChanged(int status);
}

/**
 * A wake lock is a mechanism to indicate that your application needs
 * to have the device stay on.
 * <p>
 * Any application using a WakeLock must request the {@code android.permission.WAKE_LOCK}
 * permission in an {@code <uses-permission>} element of the application's manifest.
 * Obtain a wake lock by calling {@link android.os.PowerManager#newWakeLock(int,java.lang.String) PowerManager#newWakeLock(int, String)}.
 * </p><p>
 * Call {@link #acquire()} to acquire the wake lock and force the device to stay
 * on at the level that was requested when the wake lock was created.
 * </p><p>
 * Call {@link #release()} when you are done and don't need the lock anymore.
 * It is very important to do this as soon as possible to avoid running down the
 * device's battery excessively.
 * </p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class WakeLock {

WakeLock() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this WakeLock is reference counted.
 * <p>
 * Wake locks are reference counted by default.  If a wake lock is
 * reference counted, then each call to {@link #acquire()} must be
 * balanced by an equal number of calls to {@link #release()}.  If a wake
 * lock is not reference counted, then one call to {@link #release()} is
 * sufficient to undo the effect of all previous calls to {@link #acquire()}.
 * </p>
 *
 * @param value True to make the wake lock reference counted, false to
 * make the wake lock non-reference counted.
 * @apiSince 1
 */

public void setReferenceCounted(boolean value) { throw new RuntimeException("Stub!"); }

/**
 * Acquires the wake lock.
 * <p>
 * Ensures that the device is on at the level requested when
 * the wake lock was created.
 * </p>
 * @apiSince 1
 */

public void acquire() { throw new RuntimeException("Stub!"); }

/**
 * Acquires the wake lock with a timeout.
 * <p>
 * Ensures that the device is on at the level requested when
 * the wake lock was created.  The lock will be released after the given timeout
 * expires.
 * </p>
 *
 * @param timeout The timeout after which to release the wake lock, in milliseconds.
 * @apiSince 1
 */

public void acquire(long timeout) { throw new RuntimeException("Stub!"); }

/**
 * Releases the wake lock.
 * <p>
 * This method releases your claim to the CPU or screen being on.
 * The screen may turn off shortly after you release the wake lock, or it may
 * not if there are other wake locks still held.
 * </p>
 * @apiSince 1
 */

public void release() { throw new RuntimeException("Stub!"); }

/**
 * Releases the wake lock with flags to modify the release behavior.
 * <p>
 * This method releases your claim to the CPU or screen being on.
 * The screen may turn off shortly after you release the wake lock, or it may
 * not if there are other wake locks still held.
 * </p>
 *
 * @param flags Combination of flag values to modify the release behavior.
 * Currently only {@link #RELEASE_FLAG_WAIT_FOR_NO_PROXIMITY} is supported.
 * Passing 0 is equivalent to calling {@link #release()}.
 * @apiSince 21
 */

public void release(int flags) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the wake lock has been acquired but not yet released.
 *
 * @return True if the wake lock is held.
 * @apiSince 1
 */

public boolean isHeld() { throw new RuntimeException("Stub!"); }

/**
 * Sets the work source associated with the wake lock.
 * <p>
 * The work source is used to determine on behalf of which application
 * the wake lock is being held.  This is useful in the case where a
 * service is performing work on behalf of an application so that the
 * cost of that work can be accounted to the application.
 * </p>
 *
 * <p>
 * Make sure to follow the tag naming convention when using WorkSource
 * to make it easier for app developers to understand wake locks
 * attributed to them. See {@link android.os.PowerManager#newWakeLock(int,java.lang.String) PowerManager#newWakeLock(int, String)}
 * documentation.
 * </p>
 *
 * @param ws The work source, or null if none.
 * @apiSince 9
 */

public void setWorkSource(android.os.WorkSource ws) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

}

