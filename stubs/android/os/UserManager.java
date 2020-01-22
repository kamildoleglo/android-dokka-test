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


package android.os;

import android.app.admin.DevicePolicyManager;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import android.content.ComponentName;
import android.app.Activity;
import android.provider.Settings;
import android.content.IntentFilter;
import android.view.WindowManager.LayoutParams;

/**
 * Manages users and user details on a multi-user system. There are two major categories of
 * users: fully customizable users with their own login, and managed profiles that share a workspace
 * with a related user.
 * <p>
 * Users are different from accounts, which are managed by
 * {@link android.accounts.AccountManager AccountManager}. Each user can have their own set of accounts.
 * <p>
 * See {@link android.app.admin.DevicePolicyManager#ACTION_PROVISION_MANAGED_PROFILE DevicePolicyManager#ACTION_PROVISION_MANAGED_PROFILE} for more on managed profiles.
 * @apiSince 17
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class UserManager {

UserManager() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether this device supports multiple users with their own login and customizable
 * space.
 * @return whether the device supports multiple users.
 * @apiSince 24
 */

public static boolean supportsMultipleUsers() { throw new RuntimeException("Stub!"); }

/**
 * Returns the user name of the user making this call.  This call is only
 * available to applications on the system image; it requires the
 * {@code android.permission.MANAGE_USERS} or {@code android.permission.GET_ACCOUNTS_PRIVILEGED}
 * permissions.
 * @return the user name
 * @apiSince 17
 */

public java.lang.String getUserName() { throw new RuntimeException("Stub!"); }

/**
 * Used to determine whether the user making this call is subject to
 * teleportations.
 *
 * <p>As of {@link android.os.Build.VERSION_CODES#LOLLIPOP}, this method can
 * now automatically identify goats using advanced goat recognition technology.</p>
 *
 * @return Returns true if the user making this call is a goat.
 * @apiSince 17
 */

public boolean isUserAGoat() { throw new RuntimeException("Stub!"); }

/**
 * Used to check if this process is running under the system user. The system user
 * is the initial user that is implicitly created on first boot and hosts most of the
 * system services.
 *
 * @return whether this process is running under the system user.
 * @apiSince 23
 */

public boolean isSystemUser() { throw new RuntimeException("Stub!"); }

/**
 * Checks if the calling app is running in a demo user. When running in a demo user,
 * apps can be more helpful to the user, or explain their features in more detail.
 *
 * @return whether the caller is a demo user.
 * @apiSince 25
 */

public boolean isDemoUser() { throw new RuntimeException("Stub!"); }

/**
 * Return whether the given user is actively running.  This means that
 * the user is in the "started" state, not "stopped" -- it is currently
 * allowed to run code through scheduled alarms, receiving broadcasts,
 * etc.  A started user may be either the current foreground user or a
 * background user; the result here does not distinguish between the two.
 *
 * <p>Note prior to Android Nougat MR1 (SDK version <= 24;
 * {@link android.os.Build.VERSION_CODES#N}, this API required a system permission
 * in order to check other profile's status.
 * Since Android Nougat MR1 (SDK version >= 25;
 * {@link android.os.Build.VERSION_CODES#N_MR1}), the restriction has been relaxed, and now
 * it'll accept any {@link android.os.UserHandle} within the same profile group as the caller.
 *
 * @param user The user to retrieve the running state for.
 * @apiSince 17
 */

public boolean isUserRunning(android.os.UserHandle user) { throw new RuntimeException("Stub!"); }

/**
 * Return whether the given user is actively running <em>or</em> stopping.
 * This is like {@link #isUserRunning(android.os.UserHandle)}, but will also return
 * true if the user had been running but is in the process of being stopped
 * (but is not yet fully stopped, and still running some code).
 *
 * <p>Note prior to Android Nougat MR1 (SDK version <= 24;
 * {@link android.os.Build.VERSION_CODES#N}, this API required a system permission
 * in order to check other profile's status.
 * Since Android Nougat MR1 (SDK version >= 25;
 * {@link android.os.Build.VERSION_CODES#N_MR1}), the restriction has been relaxed, and now
 * it'll accept any {@link android.os.UserHandle} within the same profile group as the caller.
 *
 * @param user The user to retrieve the running state for.
 * @apiSince 17
 */

public boolean isUserRunningOrStopping(android.os.UserHandle user) { throw new RuntimeException("Stub!"); }

/**
 * Return whether the calling user is running in an "unlocked" state.
 * <p>
 * On devices with direct boot, a user is unlocked only after they've
 * entered their credentials (such as a lock pattern or PIN). On devices
 * without direct boot, a user is unlocked as soon as it starts.
 * <p>
 * When a user is locked, only device-protected data storage is available.
 * When a user is unlocked, both device-protected and credential-protected
 * private app data storage is available.
 *
 * @see android.content.Intent#ACTION_USER_UNLOCKED
 * @see android.content.Context#createDeviceProtectedStorageContext()
 * @apiSince 24
 */

public boolean isUserUnlocked() { throw new RuntimeException("Stub!"); }

/**
 * Return whether the given user is running in an "unlocked" state.
 * <p>
 * On devices with direct boot, a user is unlocked only after they've
 * entered their credentials (such as a lock pattern or PIN). On devices
 * without direct boot, a user is unlocked as soon as it starts.
 * <p>
 * When a user is locked, only device-protected data storage is available.
 * When a user is unlocked, both device-protected and credential-protected
 * private app data storage is available.
 * <p>Requires {@code android.permission.MANAGE_USERS} or
 * {@code android.permission.INTERACT_ACROSS_USERS}, otherwise specified {@link android.os.UserHandle UserHandle}
 * must be the calling user or a managed profile associated with it.
 *
 * @param user to retrieve the unlocked state for.
 * @see android.content.Intent#ACTION_USER_UNLOCKED
 * @see android.content.Context#createDeviceProtectedStorageContext()
 * @apiSince 24
 */

public boolean isUserUnlocked(android.os.UserHandle user) { throw new RuntimeException("Stub!"); }

/**
 * Returns the user-wide restrictions imposed on this user.
 * @return a Bundle containing all the restrictions.
 * @apiSince 18
 */

public android.os.Bundle getUserRestrictions() { throw new RuntimeException("Stub!"); }

/**
 * Returns the user-wide restrictions imposed on the user specified by <code>userHandle</code>.
 * @param userHandle the UserHandle of the user for whom to retrieve the restrictions.
 * @return a Bundle containing all the restrictions.
 * @apiSince 18
 */

public android.os.Bundle getUserRestrictions(android.os.UserHandle userHandle) { throw new RuntimeException("Stub!"); }

/**
 * This will no longer work.  Device owners and profile owners should use
 * {@link android.app.admin.DevicePolicyManager#addUserRestriction(android.content.ComponentName,java.lang.String) DevicePolicyManager#addUserRestriction(ComponentName, String)} instead.
 * @apiSince 18
 * @deprecatedSince 21
 */

@Deprecated
public void setUserRestrictions(android.os.Bundle restrictions) { throw new RuntimeException("Stub!"); }

/**
 * This will no longer work.  Device owners and profile owners should use
 * {@link android.app.admin.DevicePolicyManager#addUserRestriction(android.content.ComponentName,java.lang.String) DevicePolicyManager#addUserRestriction(ComponentName, String)} instead.
 * @apiSince 18
 * @deprecatedSince 21
 */

@Deprecated
public void setUserRestrictions(android.os.Bundle restrictions, android.os.UserHandle userHandle) { throw new RuntimeException("Stub!"); }

/**
 * Sets the value of a specific restriction.
 * Requires the MANAGE_USERS permission.
 * @param key the key of the restriction
 * @param value the value for the restriction
 * @deprecated use {@link android.app.admin.DevicePolicyManager#addUserRestriction(
 * android.content.ComponentName, String)} or
 * {@link android.app.admin.DevicePolicyManager#clearUserRestriction(
 * android.content.ComponentName, String)} instead.
 * @apiSince 18
 * @deprecatedSince 21
 */

@Deprecated
public void setUserRestriction(java.lang.String key, boolean value) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the current user has been disallowed from performing certain actions
 * or setting certain settings.
 *
 * @param restrictionKey The string key representing the restriction.
 * @return {@code true} if the current user has the given restriction, {@code false} otherwise.
 * @apiSince 21
 */

public boolean hasUserRestriction(java.lang.String restrictionKey) { throw new RuntimeException("Stub!"); }

/**
 * Return the serial number for a user.  This is a device-unique
 * number assigned to that user; if the user is deleted and then a new
 * user created, the new users will not be given the same serial number.
 * @param user The user whose serial number is to be retrieved.
 * @return The serial number of the given user; returns -1 if the
 * given UserHandle does not exist.
 * @see #getUserForSerialNumber(long)
 * @apiSince 17
 */

public long getSerialNumberForUser(android.os.UserHandle user) { throw new RuntimeException("Stub!"); }

/**
 * Return the user associated with a serial number previously
 * returned by {@link #getSerialNumberForUser(android.os.UserHandle)}.
 * @param serialNumber The serial number of the user that is being
 * retrieved.
 * @return Return the user associated with the serial number, or null
 * if there is not one.
 * @see #getSerialNumberForUser(UserHandle)
 * @apiSince 17
 */

public android.os.UserHandle getUserForSerialNumber(long serialNumber) { throw new RuntimeException("Stub!"); }

/**
 * Returns an intent to create a user for the provided name and account name. The name
 * and account name will be used when the setup process for the new user is started.
 * <p>
 * The intent should be launched using startActivityForResult and the return result will
 * indicate if the user consented to adding a new user and if the operation succeeded. Any
 * errors in creating the user will be returned in the result code. If the user cancels the
 * request, the return result will be {@link android.app.Activity#RESULT_CANCELED Activity#RESULT_CANCELED}. On success, the
 * result code will be {@link android.app.Activity#RESULT_OK Activity#RESULT_OK}.
 * <p>
 * Use {@link #supportsMultipleUsers()} to first check if the device supports this operation
 * at all.
 * <p>
 * The new user is created but not initialized. After switching into the user for the first
 * time, the preferred user name and account information are used by the setup process for that
 * user.
 *
 * @param userName Optional name to assign to the user.
 * This value may be {@code null}.
 * @param accountName Optional account name that will be used by the setup wizard to initialize
 *                    the user.
 * This value may be {@code null}.
 * @param accountType Optional account type for the account to be created. This is required
 *                    if the account name is specified.
 * This value may be {@code null}.
 * @param accountOptions Optional bundle of data to be passed in during account creation in the
 *                       new user via {@link android.accounts.AccountManager#addAccount(java.lang.String,java.lang.String,java.lang.String[],android.os.Bundle,android.app.Activity,android.accounts.AccountManagerCallback,android.os.Handler) AccountManager#addAccount(String, String, String[],
 *                       Bundle, android.app.Activity, android.accounts.AccountManagerCallback,
 *                       Handler)}.
 * This value may be {@code null}.
 * @return An Intent that can be launched from an Activity.
 * @see #USER_CREATION_FAILED_NOT_PERMITTED
 * @see #USER_CREATION_FAILED_NO_MORE_USERS
 * @see #supportsMultipleUsers
 * @apiSince 24
 */

public static android.content.Intent createUserCreationIntent(@androidx.annotation.Nullable java.lang.String userName, @androidx.annotation.Nullable java.lang.String accountName, @androidx.annotation.Nullable java.lang.String accountType, @androidx.annotation.Nullable android.os.PersistableBundle accountOptions) { throw new RuntimeException("Stub!"); }

/**
 * Return the number of users currently created on the device.
 * @apiSince 17
 */

public int getUserCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of UserHandles for profiles associated with the user that the calling process
 * is running on, including the user itself.
 *
 * @return A non-empty list of UserHandles associated with the calling user.
 * @apiSince 21
 */

public java.util.List<android.os.UserHandle> getUserProfiles() { throw new RuntimeException("Stub!"); }

/**
 * Enables or disables quiet mode for a managed profile. If quiet mode is enabled, apps in a
 * managed profile don't run, generate notifications, or consume data or battery.
 * <p>
 * If a user's credential is needed to turn off quiet mode, a confirm credential screen will be
 * shown to the user.
 * <p>
 * The change may not happen instantly, however apps can listen for
 * {@link android.content.Intent#ACTION_MANAGED_PROFILE_AVAILABLE Intent#ACTION_MANAGED_PROFILE_AVAILABLE} and
 * {@link android.content.Intent#ACTION_MANAGED_PROFILE_UNAVAILABLE Intent#ACTION_MANAGED_PROFILE_UNAVAILABLE} broadcasts in order to be notified of
 * the change of the quiet mode. Apps can also check the current state of quiet mode by
 * calling {@link #isQuietModeEnabled(android.os.UserHandle)}.
 * <p>
 * The caller must either be the foreground default launcher or have one of these permissions:
 * {@code MANAGE_USERS} or {@code MODIFY_QUIET_MODE}.
 *
 * @param enableQuietMode whether quiet mode should be enabled or disabled
 * @param userHandle user handle of the profile
 * This value must never be {@code null}.
 * @return {@code false} if user's credential is needed in order to turn off quiet mode,
 *         {@code true} otherwise
 * @throws java.lang.SecurityException if the caller is invalid
 * @throws java.lang.IllegalArgumentException if {@code userHandle} is not a managed profile
 *
 * @see #isQuietModeEnabled(UserHandle)
 * @apiSince 28
 */

public boolean requestQuietModeEnabled(boolean enableQuietMode, @androidx.annotation.NonNull android.os.UserHandle userHandle) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the given profile is in quiet mode or not.
 * Notes: Quiet mode is only supported for managed profiles.
 *
 * @param userHandle The user handle of the profile to be queried.
 * @return true if the profile is in quiet mode, false otherwise.
 * @apiSince 24
 */

public boolean isQuietModeEnabled(android.os.UserHandle userHandle) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link android.os.Bundle Bundle} containing any saved application restrictions for this user, for the
 * given package name. Only an application with this package name can call this method.
 *
 * <p>The returned {@link android.os.Bundle Bundle} consists of key-value pairs, as defined by the application,
 * where the types of values may be:
 * <ul>
 * <li>{@code boolean}
 * <li>{@code int}
 * <li>{@code String} or {@code String[]}
 * <li>From {@link android.os.Build.VERSION_CODES#M}, {@code Bundle} or {@code Bundle[]}
 * </ul>
 *
 * <p>NOTE: The method performs disk I/O and shouldn't be called on the main thread
 *
 * <br>
 * This method may take several seconds to complete, so it should
 * only be called from a worker thread.
 * @param packageName the package name of the calling application
 * @return a {@link android.os.Bundle Bundle} with the restrictions for that package, or an empty {@link android.os.Bundle Bundle}
 * if there are no saved restrictions.
 *
 * @see #KEY_RESTRICTIONS_PENDING
 * @apiSince 18
 */

public android.os.Bundle getApplicationRestrictions(java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * Sets a new challenge PIN for restrictions. This is only for use by pre-installed
 * apps and requires the MANAGE_USERS permission.
 * @param newPin the PIN to use for challenge dialogs.
 * @return Returns true if the challenge PIN was set successfully.
 * @deprecated The restrictions PIN functionality is no longer provided by the system.
 * This method is preserved for backwards compatibility reasons and always returns false.
 * @apiSince 19
 * @deprecatedSince 23
 */

@Deprecated
public boolean setRestrictionsChallenge(java.lang.String newPin) { throw new RuntimeException("Stub!"); }

/**
 * Returns creation time of the user or of a managed profile associated with the calling user.
 * @param userHandle user handle of the user or a managed profile associated with the
 *                   calling user.
 * @return creation time in milliseconds since Epoch time.
 * @apiSince 23
 */

public long getUserCreationTime(android.os.UserHandle userHandle) { throw new RuntimeException("Stub!"); }

/**
 * Allows apps in the parent profile to handle web links from the managed profile.
 *
 * This user restriction has an effect only in a managed profile.
 * If set:
 * Intent filters of activities in the parent profile with action
 * {@link android.content.Intent#ACTION_VIEW},
 * category {@link android.content.Intent#CATEGORY_BROWSABLE}, scheme http or https, and which
 * define a host can handle intents from the managed profile.
 * The default value is <code>false</code>.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 23
 */

public static final java.lang.String ALLOW_PARENT_PROFILE_APP_LINKING = "allow_parent_profile_app_linking";

/**
 * Specifies if a user is disallowed from adding managed profiles.
 * <p>The default value for an unmanaged user is <code>false</code>.
 * For users with a device owner set, the default is <code>true</code>.
 * <p>This restriction has no effect on managed profiles.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 26
 */

public static final java.lang.String DISALLOW_ADD_MANAGED_PROFILE = "no_add_managed_profile";

/**
 * Specifies if a user is disallowed from adding new users. This can only be set by device
 * owners and profile owners on the primary user.
 * The default value is <code>false</code>.
 * <p>This restriction has no effect on secondary users and managed profiles since only the
 * primary user can add other users.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 21
 */

public static final java.lang.String DISALLOW_ADD_USER = "no_add_user";

/**
 * Specifies if a user is disallowed from adjusting the master volume. If set, the master volume
 * will be muted. This can be set by device owners from API 21 and profile owners from API 24.
 * The default value is <code>false</code>.
 *
 * <p>When the restriction is set by profile owners, then it only applies to relevant
 * profiles.
 *
 * <p>This restriction has no effect on managed profiles.
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 21
 */

public static final java.lang.String DISALLOW_ADJUST_VOLUME = "no_adjust_volume";

/**
 * Specifies if airplane mode is disallowed on the device.
 *
 * <p> This restriction can only be set by the device owner and the profile owner on the
 * primary user and it applies globally - i.e. it disables airplane mode on the entire device.
 * <p>The default value is <code>false</code>.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 28
 */

public static final java.lang.String DISALLOW_AIRPLANE_MODE = "no_airplane_mode";

/**
 * Specifies if ambient display is disallowed for the user.
 *
 * <p>The default value is <code>false</code>.
 *
 * <p>This user restriction has no effect on managed profiles.
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 28
 */

public static final java.lang.String DISALLOW_AMBIENT_DISPLAY = "no_ambient_display";

/**
 * Specifies if a user is disallowed from modifying
 * applications in Settings or launchers. The following actions will not be allowed when this
 * restriction is enabled:
 * <li>uninstalling apps</li>
 * <li>disabling apps</li>
 * <li>clearing app caches</li>
 * <li>clearing app data</li>
 * <li>force stopping apps</li>
 * <li>clearing app defaults</li>
 * <p>
 * The default value is <code>false</code>.
 *
 * <p><strong>Note:</strong> The user will still be able to perform those actions via other
 * means (such as adb). Third party apps will also be able to uninstall apps via the
 * {@link android.content.pm.PackageInstaller}. {@link #DISALLOW_UNINSTALL_APPS} or
 * {@link android.app.admin.DevicePolicyManager#setUninstallBlocked(android.content.ComponentName,java.lang.String,boolean) DevicePolicyManager#setUninstallBlocked(ComponentName, String, boolean)} should be
 * used to prevent the user from uninstalling apps completely, and
 * {@link android.app.admin.DevicePolicyManager#addPersistentPreferredActivity(android.content.ComponentName,android.content.IntentFilter,android.content.ComponentName) DevicePolicyManager#addPersistentPreferredActivity(ComponentName, IntentFilter, ComponentName)}
 * to add a default intent handler for a given intent filter.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 21
 */

public static final java.lang.String DISALLOW_APPS_CONTROL = "no_control_apps";

/**
 * Specifies if a user is not allowed to use Autofill Services.
 *
 * <p>Device owner and profile owner can set this restriction. When it is set by device owner,
 * only the target user will be affected.
 *
 * <p>The default value is <code>false</code>.
 *
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 26
 */

public static final java.lang.String DISALLOW_AUTOFILL = "no_autofill";

/**
 * Specifies if bluetooth is disallowed on the device.
 *
 * <p> This restriction can only be set by the device owner and the profile owner on the
 * primary user and it applies globally - i.e. it disables bluetooth on the entire device.
 * <p>The default value is <code>false</code>.
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 26
 */

public static final java.lang.String DISALLOW_BLUETOOTH = "no_bluetooth";

/**
 * Specifies if outgoing bluetooth sharing is disallowed on the device. Device owner and profile
 * owner can set this restriction. When it is set by device owner, all users on this device will
 * be affected.
 *
 * <p>Default is <code>true</code> for managed profiles and false for otherwise. When a device
 * upgrades to {@link android.os.Build.VERSION_CODES#O}, the system sets it for all existing
 * managed profiles.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 26
 */

public static final java.lang.String DISALLOW_BLUETOOTH_SHARING = "no_bluetooth_sharing";

/**
 * Specifies if a user is disallowed from configuring bluetooth.
 * This does <em>not</em> restrict the user from turning bluetooth on or off.
 * The default value is <code>false</code>.
 * <p>This restriction doesn't prevent the user from using bluetooth. For disallowing usage of
 * bluetooth completely on the device, use {@link #DISALLOW_BLUETOOTH}.
 * <p>This restriction has no effect in a managed profile.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 18
 */

public static final java.lang.String DISALLOW_CONFIG_BLUETOOTH = "no_config_bluetooth";

/**
 * Specifies if a user is disallowed from configuring brightness. When device owner sets it,
 * it'll only be applied on the target(system) user.
 *
 * <p>The default value is <code>false</code>.
 *
 * <p>This user restriction has no effect on managed profiles.
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 28
 */

public static final java.lang.String DISALLOW_CONFIG_BRIGHTNESS = "no_config_brightness";

/**
 * Specifies if a user is disallowed from configuring cell
 * broadcasts. This can only be set by device owners and profile owners on the primary user.
 * The default value is <code>false</code>.
 * <p>This restriction has no effect on secondary users and managed profiles since only the
 * primary user can configure cell broadcasts.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 21
 */

public static final java.lang.String DISALLOW_CONFIG_CELL_BROADCASTS = "no_config_cell_broadcasts";

/**
 * Specifies if a user is disallowed from configuring user
 * credentials. The default value is <code>false</code>.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 18
 */

public static final java.lang.String DISALLOW_CONFIG_CREDENTIALS = "no_config_credentials";

/**
 * Specifies if date, time and timezone configuring is disallowed.
 *
 * <p>When restriction is set by device owners, it applies globally - i.e., it disables date,
 * time and timezone setting on the entire device and all users will be affected. When it's set
 * by profile owners, it's only applied to the managed user.
 * <p>The default value is <code>false</code>.
 *
 * <p>This user restriction has no effect on managed profiles.
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 28
 */

public static final java.lang.String DISALLOW_CONFIG_DATE_TIME = "no_config_date_time";

/**
 * Specifies if a user is disallowed from changing the device
 * language. The default value is <code>false</code>.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 28
 */

public static final java.lang.String DISALLOW_CONFIG_LOCALE = "no_config_locale";

/**
 * Specifies if a user is disallowed from enabling or disabling location providers. As a
 * result, user is disallowed from turning on or off location. Device owner and profile owners
 * can set this restriction and it only applies on the managed user.
 *
 * <p>In a managed profile, location sharing is forced off when it's off on primary user, so
 * user can still turn off location sharing on managed profile when the restriction is set by
 * profile owner on managed profile.
 *
 * <p>This user restriction is different from {@link #DISALLOW_SHARE_LOCATION},
 * as the device owner or profile owner can still enable or disable location mode via
 * {@link android.app.admin.DevicePolicyManager#setSecureSetting DevicePolicyManager#setSecureSetting} when this restriction is on.
 *
 * <p>The default value is <code>false</code>.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.location.LocationManager#isProviderEnabled(String)
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 28
 */

public static final java.lang.String DISALLOW_CONFIG_LOCATION = "no_config_location";

/**
 * Specifies if a user is disallowed from configuring mobile
 * networks. This can only be set by device owners and profile owners on the primary user.
 * The default value is <code>false</code>.
 * <p>This restriction has no effect on secondary users and managed profiles since only the
 * primary user can configure mobile networks.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 21
 */

public static final java.lang.String DISALLOW_CONFIG_MOBILE_NETWORKS = "no_config_mobile_networks";

/**
 * Specifies whether the user is allowed to modify private DNS settings.
 *
 * <p>The default value is <code>false</code>.
 *
 * <p>This user restriction can only be applied by the Device Owner.
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 29
 */

public static final java.lang.String DISALLOW_CONFIG_PRIVATE_DNS = "disallow_config_private_dns";

/**
 * Specifies if a user is disallowed from changing screen off timeout.
 *
 * <p>The default value is <code>false</code>.
 *
 * <p>This user restriction has no effect on managed profiles.
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 28
 */

public static final java.lang.String DISALLOW_CONFIG_SCREEN_TIMEOUT = "no_config_screen_timeout";

/**
 * Specifies if a user is disallowed from configuring Tethering
 * & portable hotspots. This can only be set by device owners and profile owners on the
 * primary user. The default value is <code>false</code>.
 * <p>In Android 9.0 or higher, if tethering is enabled when this restriction is set,
 * tethering will be automatically turned off.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 21
 */

public static final java.lang.String DISALLOW_CONFIG_TETHERING = "no_config_tethering";

/**
 * Specifies if a user is disallowed from configuring a VPN. The default value is
 * <code>false</code>. This restriction has an effect when set by device owners and, in Android
 * 6.0 ({@linkplain android.os.Build.VERSION_CODES#M API level 23}) or higher, profile owners.
 * <p>This restriction also prevents VPNs from starting. However, in Android 7.0
 * ({@linkplain android.os.Build.VERSION_CODES#N API level 24}) or higher, the system does
 * start always-on VPNs created by the device or profile owner.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 21
 */

public static final java.lang.String DISALLOW_CONFIG_VPN = "no_config_vpn";

/**
 * Specifies if a user is disallowed from changing Wi-Fi
 * access points. The default value is <code>false</code>.
 * <p>This restriction has no effect in a managed profile.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 18
 */

public static final java.lang.String DISALLOW_CONFIG_WIFI = "no_config_wifi";

/**
 * Specifies if the contents of a user's screen is not allowed to be captured for artificial
 * intelligence purposes.
 *
 * <p>Device owner and profile owner can set this restriction. When it is set by device owner,
 * only the target user will be affected.
 *
 * <p>The default value is <code>false</code>.
 *
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 29
 */

public static final java.lang.String DISALLOW_CONTENT_CAPTURE = "no_content_capture";

/**
 * Specifies if the current user is able to receive content suggestions for selections based on
 * the contents of their screen.
 *
 * <p>Device owner and profile owner can set this restriction. When it is set by device owner,
 * only the target user will be affected.
 *
 * <p>The default value is <code>false</code>.
 *
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 29
 */

public static final java.lang.String DISALLOW_CONTENT_SUGGESTIONS = "no_content_suggestions";

/**
 * Specifies that windows besides app windows should not be
 * created. This will block the creation of the following types of windows.
 * <li>{@link android.view.WindowManager.LayoutParams#TYPE_TOAST LayoutParams#TYPE_TOAST}</li>
 * <li>{@link android.view.WindowManager.LayoutParams#TYPE_PHONE LayoutParams#TYPE_PHONE}</li>
 * <li>{@link android.view.WindowManager.LayoutParams#TYPE_PRIORITY_PHONE LayoutParams#TYPE_PRIORITY_PHONE}</li>
 * <li>{@link android.view.WindowManager.LayoutParams#TYPE_SYSTEM_ALERT LayoutParams#TYPE_SYSTEM_ALERT}</li>
 * <li>{@link android.view.WindowManager.LayoutParams#TYPE_SYSTEM_ERROR LayoutParams#TYPE_SYSTEM_ERROR}</li>
 * <li>{@link android.view.WindowManager.LayoutParams#TYPE_SYSTEM_OVERLAY LayoutParams#TYPE_SYSTEM_OVERLAY}</li>
 * <li>{@link android.view.WindowManager.LayoutParams#TYPE_APPLICATION_OVERLAY LayoutParams#TYPE_APPLICATION_OVERLAY}</li>
 *
 * <p>This can only be set by device owners and profile owners on the primary user.
 * The default value is <code>false</code>.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 21
 */

public static final java.lang.String DISALLOW_CREATE_WINDOWS = "no_create_windows";

/**
 * Specifies if the clipboard contents can be exported by pasting the data into other users or
 * profiles. This restriction doesn't prevent import, such as someone pasting clipboard data
 * from other profiles or users. The default value is {@code false}.
 *
 * <p><strong>Note</strong>: Because it's possible to extract data from screenshots using
 * optical character recognition (OCR), we strongly recommend combining this user restriction
 * with {@link android.app.admin.DevicePolicyManager#setScreenCaptureDisabled(android.content.ComponentName,boolean) DevicePolicyManager#setScreenCaptureDisabled(ComponentName, boolean)}.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 21
 */

public static final java.lang.String DISALLOW_CROSS_PROFILE_COPY_PASTE = "no_cross_profile_copy_paste";

/**
 * Specifies if a user is not allowed to use cellular data when roaming. This can only be set by
 * device owners. The default value is <code>false</code>.
 *
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 24
 */

public static final java.lang.String DISALLOW_DATA_ROAMING = "no_data_roaming";

/**
 * Specifies if a user is disallowed from enabling or accessing debugging features. When set on
 * the primary user, disables debugging features altogether, including USB debugging. When set
 * on a managed profile or a secondary user, blocks debugging for that user only, including
 * starting activities, making service calls, accessing content providers, sending broadcasts,
 * installing/uninstalling packages, clearing user data, etc.
 * The default value is <code>false</code>.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 21
 */

public static final java.lang.String DISALLOW_DEBUGGING_FEATURES = "no_debugging_features";

/**
 * Specifies if a user is disallowed from factory resetting
 * from Settings. This can only be set by device owners and profile owners on the primary user.
 * The default value is <code>false</code>.
 * <p>This restriction has no effect on secondary users and managed profiles since only the
 * primary user can factory reset the device.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 21
 */

public static final java.lang.String DISALLOW_FACTORY_RESET = "no_factory_reset";

/**
 * Specifies if the user is not allowed to have fun. In some cases, the
 * device owner may wish to prevent the user from experiencing amusement or
 * joy while using the device. The default value is <code>false</code>.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 23
 */

public static final java.lang.String DISALLOW_FUN = "no_fun";

/**
 * Specifies if a user is disallowed from installing applications. This user restriction also
 * prevents device owners and profile owners installing apps. The default value is
 * {@code false}.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 18
 */

public static final java.lang.String DISALLOW_INSTALL_APPS = "no_install_apps";

/**
 * Specifies if a user is disallowed from enabling the
 * "Unknown Sources" setting, that allows installation of apps from unknown sources.
 * Unknown sources exclude adb and special apps such as trusted app stores.
 * The default value is <code>false</code>.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 18
 */

public static final java.lang.String DISALLOW_INSTALL_UNKNOWN_SOURCES = "no_install_unknown_sources";

/**
 * This restriction is a device-wide version of {@link #DISALLOW_INSTALL_UNKNOWN_SOURCES}.
 *
 * Specifies if all users on the device are disallowed from enabling the
 * "Unknown Sources" setting, that allows installation of apps from unknown sources.
 *
 * This restriction can be enabled by the profile owner, in which case all accounts and
 * profiles will be affected.
 *
 * The default value is <code>false</code>.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 29
 */

public static final java.lang.String DISALLOW_INSTALL_UNKNOWN_SOURCES_GLOBALLY = "no_install_unknown_sources_globally";

/**
 * Specifies if a user is disallowed from adding and removing accounts, unless they are
 * {@link android.accounts.AccountManager#addAccountExplicitly programmatically} added by
 * Authenticator.
 * The default value is <code>false</code>.
 *
 * <p>From {@link android.os.Build.VERSION_CODES#N} a profile or device owner app can still
 * use {@link android.accounts.AccountManager} APIs to add or remove accounts when account
 * management is disallowed.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 18
 */

public static final java.lang.String DISALLOW_MODIFY_ACCOUNTS = "no_modify_accounts";

/**
 * Specifies if a user is disallowed from mounting
 * physical external media. This can only be set by device owners and profile owners on the
 * primary user. The default value is <code>false</code>.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 21
 */

public static final java.lang.String DISALLOW_MOUNT_PHYSICAL_MEDIA = "no_physical_media";

/**
 * Specifies if a user is disallowed from resetting network settings
 * from Settings. This can only be set by device owners and profile owners on the primary user.
 * The default value is <code>false</code>.
 * <p>This restriction has no effect on secondary users and managed profiles since only the
 * primary user can reset the network settings of the device.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 23
 */

public static final java.lang.String DISALLOW_NETWORK_RESET = "no_network_reset";

/**
 * Specifies if the user is not allowed to use NFC to beam out data from apps.
 * The default value is <code>false</code>.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 22
 */

public static final java.lang.String DISALLOW_OUTGOING_BEAM = "no_outgoing_beam";

/**
 * Specifies that the user is not allowed to make outgoing
 * phone calls. Emergency calls are still permitted.
 * The default value is <code>false</code>.
 * <p>This restriction has no effect on managed profiles.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 21
 */

public static final java.lang.String DISALLOW_OUTGOING_CALLS = "no_outgoing_calls";

/**
 * Specifies whether the user is allowed to print.
 *
 * This restriction can be set by device or profile owner.
 *
 * The default value is {@code false}.
 *
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 28
 */

public static final java.lang.String DISALLOW_PRINTING = "no_printing";

/**
 * Specifies if managed profiles of this user can be removed, other than by its profile owner.
 * The default value is <code>false</code>.
 * <p>
 * This restriction has no effect on managed profiles.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 26
 */

public static final java.lang.String DISALLOW_REMOVE_MANAGED_PROFILE = "no_remove_managed_profile";

/**
 * When set on the primary user this specifies if the user can remove other users.
 * When set on a secondary user, this specifies if the user can remove itself.
 * This restriction has no effect on managed profiles.
 * The default value is <code>false</code>.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 18
 */

public static final java.lang.String DISALLOW_REMOVE_USER = "no_remove_user";

/**
 * Specifies if the user is not allowed to reboot the device into safe boot mode.
 * This can only be set by device owners and profile owners on the primary user.
 * The default value is <code>false</code>.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 23
 */

public static final java.lang.String DISALLOW_SAFE_BOOT = "no_safe_boot";

/**
 * Specifies if a user is not allowed to change their icon. Device owner and profile owner
 * can set this restriction. When it is set by device owner, only the target user will be
 * affected. The default value is <code>false</code>.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 24
 */

public static final java.lang.String DISALLOW_SET_USER_ICON = "no_set_user_icon";

/**
 * User restriction to disallow setting a wallpaper. Profile owner and device owner
 * are able to set wallpaper regardless of this restriction.
 * The default value is <code>false</code>.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 24
 */

public static final java.lang.String DISALLOW_SET_WALLPAPER = "no_set_wallpaper";

/**
 * Specifies whether the user can share file / picture / data from the primary user into the
 * managed profile, either by sending them from the primary side, or by picking up data within
 * an app in the managed profile.
 * <p>
 * When a managed profile is created, the system allows the user to send data from the primary
 * side to the profile by setting up certain default cross profile intent filters. If
 * this is undesired, this restriction can be set to disallow it. Note that this restriction
 * will not block any sharing allowed by explicit
 * {@link android.app.admin.DevicePolicyManager#addCrossProfileIntentFilter DevicePolicyManager#addCrossProfileIntentFilter} calls by the profile owner.
 * <p>
 * This restriction is only meaningful when set by profile owner. When it is set by device
 * owner, it does not have any effect.
 * <p>
 * The default value is <code>false</code>.
 *
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 28
 */

public static final java.lang.String DISALLOW_SHARE_INTO_MANAGED_PROFILE = "no_sharing_into_profile";

/**
 * Specifies if a user is disallowed from turning on location sharing.
 * The default value is <code>false</code>.
 * <p>In a managed profile, location sharing always reflects the primary user's setting, but
 * can be overridden and forced off by setting this restriction to true in the managed profile.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 18
 */

public static final java.lang.String DISALLOW_SHARE_LOCATION = "no_share_location";

/**
 * Specifies that the user is not allowed to send or receive
 * SMS messages. The default value is <code>false</code>.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 21
 */

public static final java.lang.String DISALLOW_SMS = "no_sms";

/**
 * Specifies that system error dialogs for crashed or unresponsive apps should not be shown.
 * In this case, the system will force-stop the app as if the user chooses the "close app"
 * option on the UI. A feedback report isn't collected as there is no way for the user to
 * provide explicit consent. The default value is <code>false</code>.
 *
 * <p>When this user restriction is set by device owners, it's applied to all users. When set by
 * the profile owner of the primary user or a secondary user, the restriction affects only the
 * calling user. This user restriction has no effect on managed profiles.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 28
 */

public static final java.lang.String DISALLOW_SYSTEM_ERROR_DIALOGS = "no_system_error_dialogs";

/**
 * Specifies that the managed profile is not allowed to have unified lock screen challenge with
 * the primary user.
 *
 * <p><strong>Note:</strong> Setting this restriction alone doesn't automatically set a
 * separate challenge. Profile owner can ask the user to set a new password using
 * {@link android.app.admin.DevicePolicyManager#ACTION_SET_NEW_PASSWORD DevicePolicyManager#ACTION_SET_NEW_PASSWORD} and verify it using
 * {@link android.app.admin.DevicePolicyManager#isUsingUnifiedPassword(android.content.ComponentName) DevicePolicyManager#isUsingUnifiedPassword(ComponentName)}.
 *
 * <p>Can be set by profile owners. It only has effect on managed profiles when set by managed
 * profile owner. Has no effect on non-managed profiles or users.
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 28
 */

public static final java.lang.String DISALLOW_UNIFIED_PASSWORD = "no_unified_password";

/**
 * Specifies if a user is disallowed from uninstalling applications.
 * The default value is <code>false</code>.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 18
 */

public static final java.lang.String DISALLOW_UNINSTALL_APPS = "no_uninstall_apps";

/**
 * Specifies if a user is disallowed from adjusting microphone volume. If set, the microphone
 * will be muted. This can be set by device owners and profile owners. The default value is
 * <code>false</code>.
 *
 * <p>This restriction has no effect on managed profiles.
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 21
 */

public static final java.lang.String DISALLOW_UNMUTE_MICROPHONE = "no_unmute_microphone";

/**
 * Specifies if a user is disallowed from transferring files over
 * USB. This can only be set by device owners and profile owners on the primary user.
 * The default value is <code>false</code>.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 18
 */

public static final java.lang.String DISALLOW_USB_FILE_TRANSFER = "no_usb_file_transfer";

/**
 * Specifies if user switching is blocked on the current user.
 *
 * <p> This restriction can only be set by the device owner, it will be applied to all users.
 * Device owner can still switch user via
 * {@link android.app.admin.DevicePolicyManager#switchUser(android.content.ComponentName,android.os.UserHandle) DevicePolicyManager#switchUser(ComponentName, UserHandle)} when this restriction is
 * set.
 *
 * <p>The default value is <code>false</code>.
 *
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 28
 */

public static final java.lang.String DISALLOW_USER_SWITCH = "no_user_switch";

/**
 * Specifies if a user is disallowed from disabling application verification. The default
 * value is <code>false</code>.
 *
 * <p>In Android 8.0 ({@linkplain android.os.Build.VERSION_CODES#O API level 26}) and higher,
 * this is a global user restriction. If a device owner or profile owner sets this restriction,
 * the system enforces app verification across all users on the device. Running in earlier
 * Android versions, this restriction affects only the profile that sets it.
 *
 * <p>Key for user restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#addUserRestriction(ComponentName, String)
 * @see android.app.admin.DevicePolicyManager#clearUserRestriction(ComponentName, String)
 * @see #getUserRestrictions()
 * @apiSince 21
 */

public static final java.lang.String ENSURE_VERIFY_APPS = "ensure_verify_apps";

/**
 * Application restriction key that is used to indicate the pending arrival
 * of real restrictions for the app.
 *
 * <p>
 * Applications that support restrictions should check for the presence of this key.
 * A <code>true</code> value indicates that restrictions may be applied in the near
 * future but are not available yet. It is the responsibility of any
 * management application that sets this flag to update it when the final
 * restrictions are enforced.
 *
 * <p>Key for application restrictions.
 * <p>Type: Boolean
 * @see android.app.admin.DevicePolicyManager#setApplicationRestrictions(
 *      android.content.ComponentName, String, Bundle)
 * @see android.app.admin.DevicePolicyManager#getApplicationRestrictions(
 *      android.content.ComponentName, String)
 * @apiSince 22
 */

public static final java.lang.String KEY_RESTRICTIONS_PENDING = "restrictions_pending";

/**
 * Error result indicating that this user is not allowed to add other users on this device.
 * This is a result code returned from the activity created by the intent
 * {@link #createUserCreationIntent(java.lang.String,java.lang.String,java.lang.String,android.os.PersistableBundle)}.
 * @apiSince 24
 */

public static final int USER_CREATION_FAILED_NOT_PERMITTED = 1; // 0x1

/**
 * Error result indicating that no more users can be created on this device.
 * This is a result code returned from the activity created by the intent
 * {@link #createUserCreationIntent(java.lang.String,java.lang.String,java.lang.String,android.os.PersistableBundle)}.
 * @apiSince 24
 */

public static final int USER_CREATION_FAILED_NO_MORE_USERS = 2; // 0x2

/**
 * Indicates user operation failed because the target user is in the foreground.
 * @apiSince 28
 */

public static final int USER_OPERATION_ERROR_CURRENT_USER = 4; // 0x4

/**
 * Indicates user operation failed because device has low data storage.
 * @apiSince 28
 */

public static final int USER_OPERATION_ERROR_LOW_STORAGE = 5; // 0x5

/**
 * Indicates user operation failed because target user is a managed profile.
 * @apiSince 28
 */

public static final int USER_OPERATION_ERROR_MANAGED_PROFILE = 2; // 0x2

/**
 * Indicates user operation failed because maximum running user limit has been reached.
 * @apiSince 28
 */

public static final int USER_OPERATION_ERROR_MAX_RUNNING_USERS = 3; // 0x3

/**
 * Indicates user operation failed because maximum user limit has been reached.
 * @apiSince 28
 */

public static final int USER_OPERATION_ERROR_MAX_USERS = 6; // 0x6

/**
 * Indicates user operation failed for unknown reason.
 * @apiSince 28
 */

public static final int USER_OPERATION_ERROR_UNKNOWN = 1; // 0x1

/**
 * Indicates user operation is successful.
 * @apiSince 28
 */

public static final int USER_OPERATION_SUCCESS = 0; // 0x0
/**
 * Thrown to indicate user operation failed.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class UserOperationException extends java.lang.RuntimeException {

UserOperationException() { throw new RuntimeException("Stub!"); }

/**
 * Returns the operation result code.
 
 * @return Value is {@link android.os.UserManager#USER_OPERATION_SUCCESS}, {@link android.os.UserManager#USER_OPERATION_ERROR_UNKNOWN}, {@link android.os.UserManager#USER_OPERATION_ERROR_MANAGED_PROFILE}, {@link android.os.UserManager#USER_OPERATION_ERROR_MAX_RUNNING_USERS}, {@link android.os.UserManager#USER_OPERATION_ERROR_CURRENT_USER}, {@link android.os.UserManager#USER_OPERATION_ERROR_LOW_STORAGE}, or {@link android.os.UserManager#USER_OPERATION_ERROR_MAX_USERS}
 * @apiSince 28
 */

public int getUserOperationResult() { throw new RuntimeException("Stub!"); }
}

}

