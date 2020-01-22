/*
 * Copyright (C) 2015 The Android Open Source Project
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


package android.app.admin;


/**
 * Determines when over-the-air system updates are installed on a device. Only a device policy
 * controller (DPC) running in device owner mode can set an update policy for the device—by calling
 * the {@code DevicePolicyManager} method
 * {@link android.app.admin.DevicePolicyManager#setSystemUpdatePolicy DevicePolicyManager#setSystemUpdatePolicy}. An update
 * policy affects the pending system update (if there is one) and any future updates for the device.
 *
 * <p>If a policy is set on a device, the system doesn't notify the user about updates.</p>
 * <h3>Example</h3>
 *
 * <p>The example below shows how a DPC might set a maintenance window for system updates:</p>
 * <pre><code>
 * private final MAINTENANCE_WINDOW_START = 1380; // 11pm
 * private final MAINTENANCE_WINDOW_END = 120; // 2am
 *
 * // ...
 *
 * // Create the system update policy
 * SystemUpdatePolicy policy = SystemUpdatePolicy.createWindowedInstallPolicy(
 *     MAINTENANCE_WINDOW_START, MAINTENANCE_WINDOW_END);
 *
 * // Get a DevicePolicyManager instance to set the policy on the device
 * DevicePolicyManager dpm =
 *     (DevicePolicyManager) context.getSystemService(Context.DEVICE_POLICY_SERVICE);
 * ComponentName adminComponent = getComponentName(context);
 * dpm.setSystemUpdatePolicy(adminComponent, policy);
 * </code></pre>
 *
 * <h3>Developer guide</h3>
 * To learn more, read <a href="{@docRoot}work/dpc/system-updates">Manage system updates</a>.
 *
 * @see android.app.admin.DevicePolicyManager#setSystemUpdatePolicy
 * @see android.app.admin.DevicePolicyManager#getSystemUpdatePolicy
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SystemUpdatePolicy implements android.os.Parcelable {

private SystemUpdatePolicy() { throw new RuntimeException("Stub!"); }

/**
 * Create a policy object and set it to install update automatically as soon as one is
 * available.
 *
 * @see #TYPE_INSTALL_AUTOMATIC
 * @apiSince 23
 */

public static android.app.admin.SystemUpdatePolicy createAutomaticInstallPolicy() { throw new RuntimeException("Stub!"); }

/**
 * Create a policy object and set it to: new system update will only be installed automatically
 * when the system clock is inside a daily maintenance window. If the start and end times are
 * the same, the window is considered to include the <i>whole 24 hours</i>. That is, updates can
 * install at any time. If start time is later than end time, the window is considered spanning
 * midnight (i.e. the end time denotes a time on the next day). The maintenance window will last
 * for 30 days for any given update, after which the window will no longer be effective and
 * the pending update will be made available for manual installation as if no system update
 * policy were set on the device. See {@link #TYPE_INSTALL_WINDOWED} for the details of this
 * policy's behavior.
 *
 * @param startTime the start of the maintenance window, measured as the number of minutes from
 *            midnight in the device's local time. Must be in the range of [0, 1440).
 * @param endTime the end of the maintenance window, measured as the number of minutes from
 *            midnight in the device's local time. Must be in the range of [0, 1440).
 * @throws java.lang.IllegalArgumentException If the {@code startTime} or {@code endTime} isn't in the
 *            accepted range.
 * @return The configured policy.
 * @see #TYPE_INSTALL_WINDOWED
 * @apiSince 23
 */

public static android.app.admin.SystemUpdatePolicy createWindowedInstallPolicy(int startTime, int endTime) { throw new RuntimeException("Stub!"); }

/**
 * Create a policy object and set it to block installation for a maximum period of 30 days.
 * To learn more about this policy's behavior, see {@link #TYPE_POSTPONE}.
 *
 * <p><b>Note: </b> security updates (e.g. monthly security patches) will <i>not</i> be affected
 * by this policy.
 *
 * @see #TYPE_POSTPONE
 * @apiSince 23
 */

public static android.app.admin.SystemUpdatePolicy createPostponeInstallPolicy() { throw new RuntimeException("Stub!"); }

/**
 * Returns the type of system update policy, or -1 if no policy has been set.
 *
 @return The policy type or -1 if the type isn't set.
 
 * Value is {@link android.app.admin.SystemUpdatePolicy#TYPE_INSTALL_AUTOMATIC}, {@link android.app.admin.SystemUpdatePolicy#TYPE_INSTALL_WINDOWED}, or {@link android.app.admin.SystemUpdatePolicy#TYPE_POSTPONE}
 * @apiSince 23
 */

public int getPolicyType() { throw new RuntimeException("Stub!"); }

/**
 * Get the start of the maintenance window.
 *
 * @return the start of the maintenance window measured as the number of minutes from midnight,
 * or -1 if the policy does not have a maintenance window.
 * @apiSince 23
 */

public int getInstallWindowStart() { throw new RuntimeException("Stub!"); }

/**
 * Get the end of the maintenance window.
 *
 * @return the end of the maintenance window measured as the number of minutes from midnight,
 * or -1 if the policy does not have a maintenance window.
 * @apiSince 23
 */

public int getInstallWindowEnd() { throw new RuntimeException("Stub!"); }

/**
 * Configure a list of freeze periods on top of the current policy. When the device's clock is
 * within any of the freeze periods, all incoming system updates including security patches will
 * be blocked and cannot be installed. When the device is outside the freeze periods, the normal
 * policy behavior will apply.
 * <p>
 * Each individual freeze period is allowed to be at most 90 days long, and adjacent freeze
 * periods need to be at least 60 days apart. Also, the list of freeze periods should not
 * contain duplicates or overlap with each other. If any of these conditions is not met, a
 * {@link android.app.admin.SystemUpdatePolicy.ValidationFailedException ValidationFailedException} will be thrown.
 * <p>
 * Handling of leap year: we ignore leap years in freeze period calculations, in particular,
 * <ul>
 * <li>When a freeze period is defined, February 29th is disregarded so even though a freeze
 * period can be specified to start or end on February 29th, it will be treated as if the period
 * started or ended on February 28th.</li>
 * <li>When applying freeze period behavior to the device, a system clock of February 29th is
 * treated as if it were February 28th</li>
 * <li>When calculating the number of days of a freeze period or separation between two freeze
 * periods, February 29th is also ignored and not counted as one day.</li>
 * </ul>
 *
 * @param freezePeriods the list of freeze periods
 * @throws android.app.admin.SystemUpdatePolicy.ValidationFailedException if the supplied freeze periods do not meet the
 *         requirement set above
 * @return this instance
 * @apiSince 28
 */

public android.app.admin.SystemUpdatePolicy setFreezePeriods(java.util.List<android.app.admin.FreezePeriod> freezePeriods) { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of freeze periods previously set on this system update policy object.
 *
 * @return the list of freeze periods, or an empty list if none was set.
 * @apiSince 28
 */

public java.util.List<android.app.admin.FreezePeriod> getFreezePeriods() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.admin.SystemUpdatePolicy> CREATOR;
static { CREATOR = null; }

/**
 * Installs system updates (without user interaction) as soon as they become available. Setting
 * this policy type immediately installs any pending updates that might be postponed or waiting
 * for a maintenance window.
 * @apiSince 23
 */

public static final int TYPE_INSTALL_AUTOMATIC = 1; // 0x1

/**
 * Installs system updates (without user interaction) during a daily maintenance window. Set the
 * start and end of the daily maintenance window, as minutes of the day, when creating a new
 * {@code TYPE_INSTALL_WINDOWED} policy. See
 * {@link #createWindowedInstallPolicy createWindowedInstallPolicy()}.
 *
 * <p>No connectivity, not enough disk space, or a low battery are typical reasons Android might
 * not install a system update in the daily maintenance window. After 30 days trying to install
 * an update in the maintenance window (regardless of policy changes in this period), the system
 * prompts the device user to install the update.
 * @apiSince 23
 */

public static final int TYPE_INSTALL_WINDOWED = 2; // 0x2

/**
 * Postpones the installation of system updates for 30 days. After the 30-day period has ended,
 * the system prompts the device user to install the update.
 *
 * <p>The system limits each update to one 30-day postponement. The period begins when the
 * system first postpones the update and setting new {@code TYPE_POSTPONE} policies won’t extend
 * the period. If, after 30 days the update isn’t installed (through policy changes), the system
 * prompts the user to install the update.
 *
 * <p><strong>Note</strong>: Device manufacturers or carriers might choose to exempt important
 * security updates from a postponement policy. Exempted updates notify the device user when
 * they become available.
 * @apiSince 23
 */

public static final int TYPE_POSTPONE = 3; // 0x3
/**
 * An exception class that represents various validation errors thrown from
 * {@link android.app.admin.SystemUpdatePolicy#setFreezePeriods SystemUpdatePolicy#setFreezePeriods} and
 * {@link android.app.admin.DevicePolicyManager#setSystemUpdatePolicy DevicePolicyManager#setSystemUpdatePolicy}
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class ValidationFailedException extends java.lang.IllegalArgumentException implements android.os.Parcelable {

private ValidationFailedException() { throw new RuntimeException("Stub!"); }

/**
 * Returns the type of validation error associated with this exception.
 
 * @return Value is android.app.admin.SystemUpdatePolicy.ValidationFailedException.ERROR_NONE, {@link android.app.admin.SystemUpdatePolicy.ValidationFailedException#ERROR_DUPLICATE_OR_OVERLAP}, {@link android.app.admin.SystemUpdatePolicy.ValidationFailedException#ERROR_NEW_FREEZE_PERIOD_TOO_LONG}, {@link android.app.admin.SystemUpdatePolicy.ValidationFailedException#ERROR_NEW_FREEZE_PERIOD_TOO_CLOSE}, {@link android.app.admin.SystemUpdatePolicy.ValidationFailedException#ERROR_COMBINED_FREEZE_PERIOD_TOO_LONG}, {@link android.app.admin.SystemUpdatePolicy.ValidationFailedException#ERROR_COMBINED_FREEZE_PERIOD_TOO_CLOSE}, or {@link android.app.admin.SystemUpdatePolicy.ValidationFailedException#ERROR_UNKNOWN}
 * @apiSince 28
 */

public int getErrorCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.admin.SystemUpdatePolicy.ValidationFailedException> CREATOR;
static { CREATOR = null; }

/**
 * The device has been in a freeze period and some new freeze period to be set is less
 * than 60 days from the end of the last freeze period the device went through.
 * @apiSince 28
 */

public static final int ERROR_COMBINED_FREEZE_PERIOD_TOO_CLOSE = 6; // 0x6

/**
 * The device has been in a freeze period and when combining with the new freeze period
 * to be set, it will result in the total freeze period being longer than 90 days.
 * @apiSince 28
 */

public static final int ERROR_COMBINED_FREEZE_PERIOD_TOO_LONG = 5; // 0x5

/**
 * The freeze periods contains duplicates, periods that overlap with each
 * other or periods whose start and end joins.
 * @apiSince 28
 */

public static final int ERROR_DUPLICATE_OR_OVERLAP = 2; // 0x2

/**
 * There exists some freeze period which starts within 60 days of the preceding period's
 * end time.
 * @apiSince 28
 */

public static final int ERROR_NEW_FREEZE_PERIOD_TOO_CLOSE = 4; // 0x4

/**
 * There exists at least one freeze period whose length exceeds 90 days.
 * @apiSince 28
 */

public static final int ERROR_NEW_FREEZE_PERIOD_TOO_LONG = 3; // 0x3

/**
 * Validation failed with unknown error.
 * @apiSince 28
 */

public static final int ERROR_UNKNOWN = 1; // 0x1
}

}

