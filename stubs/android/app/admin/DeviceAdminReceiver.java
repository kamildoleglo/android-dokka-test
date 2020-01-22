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


package android.app.admin;

import android.content.Context;
import android.app.Service;
import android.content.Intent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.os.Process;
import android.accounts.AccountManager;
import android.security.KeyChain;

/**
 * Base class for implementing a device administration component.  This
 * class provides a convenience for interpreting the raw intent actions
 * that are sent by the system.
 *
 * <p>The callback methods, like the base
 * {@link android.content.BroadcastReceiver#onReceive(android.content.Context,android.content.Intent) BroadcastReceiver#onReceive(Context, Intent)}
 * method, happen on the main thread of the process.  Thus long running
 * operations must be done on another thread.  Note that because a receiver
 * is done once returning from its receive function, such long-running operations
 * should probably be done in a {@link android.app.Service Service}.
 *
 * <p>When publishing your DeviceAdmin subclass as a receiver, it must
 * handle {@link #ACTION_DEVICE_ADMIN_ENABLED} and require the
 * {@link android.Manifest.permission#BIND_DEVICE_ADMIN} permission.  A typical
 * manifest entry would look like:</p>
 *
 * {@sample development/samples/ApiDemos/AndroidManifest.xml device_admin_declaration}
 *
 * <p>The meta-data referenced here provides addition information specific
 * to the device administrator, as parsed by the {@link android.app.admin.DeviceAdminInfo DeviceAdminInfo} class.
 * A typical file would be:</p>
 *
 * {@sample development/samples/ApiDemos/res/xml/device_admin_sample.xml meta_data}
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about device administration, read the
 * <a href="{@docRoot}guide/topics/admin/device-admin.html">Device Administration</a>
 * developer guide.</p>
 * </div>
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DeviceAdminReceiver extends android.content.BroadcastReceiver {

public DeviceAdminReceiver() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the DevicePolicyManager interface for this administrator to work
 * with the system.
 
 * @param context This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 8
 */

@androidx.annotation.NonNull
public android.app.admin.DevicePolicyManager getManager(@androidx.annotation.NonNull android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the ComponentName describing who this device administrator is, for
 * use in {@link android.app.admin.DevicePolicyManager DevicePolicyManager} APIs that require the administrator to
 * identify itself.
 
 * @param context This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 8
 */

@androidx.annotation.NonNull
public android.content.ComponentName getWho(@androidx.annotation.NonNull android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Called after the administrator is first enabled, as a result of
 * receiving {@link #ACTION_DEVICE_ADMIN_ENABLED}.  At this point you
 * can use {@link android.app.admin.DevicePolicyManager DevicePolicyManager} to set your desired policies.
 *
 * <p> If the admin is activated by a device owner, then the intent
 * may contain private extras that are relevant to user setup.
 * {@see DevicePolicyManager#createAndManageUser(ComponentName, String, ComponentName,
 *      PersistableBundle, int)}
 *
 * @param context The running context as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param intent The received intent as per {@link #onReceive}.
 
 * This value must never be {@code null}.
 * @apiSince 8
 */

public void onEnabled(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Called when the user has asked to disable the administrator, as a result of
 * receiving {@link #ACTION_DEVICE_ADMIN_DISABLE_REQUESTED}, giving you
 * a chance to present a warning message to them.  The message is returned
 * as the result; if null is returned (the default implementation), no
 * message will be displayed.
 * @param context The running context as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param intent The received intent as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @return Return the warning message to display to the user before
 * being disabled; if null is returned, no message is displayed.
 * @apiSince 8
 */

@androidx.annotation.Nullable
public java.lang.CharSequence onDisableRequested(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Called prior to the administrator being disabled, as a result of
 * receiving {@link #ACTION_DEVICE_ADMIN_DISABLED}.  Upon return, you
 * can no longer use the protected parts of the {@link android.app.admin.DevicePolicyManager DevicePolicyManager}
 * API.
 * @param context The running context as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param intent The received intent as per {@link #onReceive}.
 
 * This value must never be {@code null}.
 * @apiSince 8
 */

public void onDisabled(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Called after the user has changed their device or profile challenge password, as a result of
 * receiving {@link #ACTION_PASSWORD_CHANGED}.  At this point you
 * can use {@link android.app.admin.DevicePolicyManager#getPasswordQuality(android.content.ComponentName) DevicePolicyManager#getPasswordQuality(android.content.ComponentName)}
 * to retrieve the active password characteristics.
 * @param context The running context as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param intent The received intent as per {@link #onReceive}.
 *
 * This value must never be {@code null}.
 * @deprecated From {@link android.os.Build.VERSION_CODES#O}, use
 *             {@link #onPasswordChanged(android.content.Context,android.content.Intent,android.os.UserHandle)} instead.
 * @apiSince 8
 * @deprecatedSince 26
 */

@Deprecated
public void onPasswordChanged(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Called after the user has changed their device or profile challenge password, as a result of
 * receiving {@link #ACTION_PASSWORD_CHANGED}.  At this point you
 * can use {@link android.app.admin.DevicePolicyManager#getPasswordQuality(android.content.ComponentName) DevicePolicyManager#getPasswordQuality(android.content.ComponentName)}
 * to retrieve the active password characteristics.
 * @param context The running context as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param intent The received intent as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param user The user or profile for whom the password changed. To see whether this
 *        user is the current profile or a parent user, check for equality with
 *        {@link android.os.Process#myUserHandle Process#myUserHandle}.
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public void onPasswordChanged(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent intent, @androidx.annotation.NonNull android.os.UserHandle user) { throw new RuntimeException("Stub!"); }

/**
 * Called after the user has failed at entering their device or profile challenge password,
 * as a result of receiving {@link #ACTION_PASSWORD_FAILED}.  At this point you can use
 * {@link android.app.admin.DevicePolicyManager#getCurrentFailedPasswordAttempts() DevicePolicyManager#getCurrentFailedPasswordAttempts()} to retrieve the number of
 * failed password attempts.
 * @param context The running context as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param intent The received intent as per {@link #onReceive}.
 *
 * This value must never be {@code null}.
 * @deprecated From {@link android.os.Build.VERSION_CODES#O}, use
 *             {@link #onPasswordFailed(android.content.Context,android.content.Intent,android.os.UserHandle)} instead.
 * @apiSince 8
 * @deprecatedSince 26
 */

@Deprecated
public void onPasswordFailed(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Called after the user has failed at entering their device or profile challenge password,
 * as a result of receiving {@link #ACTION_PASSWORD_FAILED}.  At this point you can use
 * {@link android.app.admin.DevicePolicyManager#getCurrentFailedPasswordAttempts() DevicePolicyManager#getCurrentFailedPasswordAttempts()} to retrieve the number of
 * failed password attempts.
 * @param context The running context as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param intent The received intent as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param user The user or profile for whom the password check failed. To see whether this
 *        user is the current profile or a parent user, check for equality with
 *        {@link android.os.Process#myUserHandle Process#myUserHandle}.
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public void onPasswordFailed(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent intent, @androidx.annotation.NonNull android.os.UserHandle user) { throw new RuntimeException("Stub!"); }

/**
 * Called after the user has succeeded at entering their device or profile challenge password,
 * as a result of receiving {@link #ACTION_PASSWORD_SUCCEEDED}.  This will
 * only be received the first time they succeed after having previously
 * failed.
 * @param context The running context as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param intent The received intent as per {@link #onReceive}.
 *
 * This value must never be {@code null}.
 * @deprecated From {@link android.os.Build.VERSION_CODES#O}, use
 *             {@link #onPasswordSucceeded(android.content.Context,android.content.Intent,android.os.UserHandle)} instead.
 * @apiSince 8
 * @deprecatedSince 26
 */

@Deprecated
public void onPasswordSucceeded(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Called after the user has succeeded at entering their device or profile challenge password,
 * as a result of receiving {@link #ACTION_PASSWORD_SUCCEEDED}.  This will
 * only be received the first time they succeed after having previously
 * failed.
 * @param context The running context as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param intent The received intent as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param user The user of profile for whom the password check succeeded.  To see whether this
 *        user is the current profile or a parent user, check for equality with
 *        {@link android.os.Process#myUserHandle Process#myUserHandle}.
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public void onPasswordSucceeded(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent intent, @androidx.annotation.NonNull android.os.UserHandle user) { throw new RuntimeException("Stub!"); }

/**
 * Called periodically when the device or profile challenge password is about to expire
 * or has expired.  It will typically be called at these times: on device boot, once per day
 * before the password expires, and at the time when the password expires.
 *
 * <p>If the password is not updated by the user, this method will continue to be called
 * once per day until the password is changed or the device admin disables password expiration.
 *
 * <p>The admin will typically post a notification requesting the user to change their password
 * in response to this call. The actual password expiration time can be obtained by calling
 * {@link android.app.admin.DevicePolicyManager#getPasswordExpiration(android.content.ComponentName) DevicePolicyManager#getPasswordExpiration(ComponentName)}
 *
 * <p>The admin should be sure to take down any notifications it posted in response to this call
 * when it receives {@link android.app.admin.DeviceAdminReceiver#onPasswordChanged(android.content.Context,android.content.Intent) DeviceAdminReceiver#onPasswordChanged(Context, Intent)}.
 *
 * @param context The running context as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param intent The received intent as per {@link #onReceive}.
 *
 * This value must never be {@code null}.
 * @deprecated From {@link android.os.Build.VERSION_CODES#O}, use
 *             {@link #onPasswordExpiring(android.content.Context,android.content.Intent,android.os.UserHandle)} instead.
 * @apiSince 11
 * @deprecatedSince 26
 */

@Deprecated
public void onPasswordExpiring(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Called periodically when the device or profile challenge password is about to expire
 * or has expired.  It will typically be called at these times: on device boot, once per day
 * before the password expires, and at the time when the password expires.
 *
 * <p>If the password is not updated by the user, this method will continue to be called
 * once per day until the password is changed or the device admin disables password expiration.
 *
 * <p>The admin will typically post a notification requesting the user to change their password
 * in response to this call. The actual password expiration time can be obtained by calling
 * {@link android.app.admin.DevicePolicyManager#getPasswordExpiration(android.content.ComponentName) DevicePolicyManager#getPasswordExpiration(ComponentName)}
 *
 * <p>The admin should be sure to take down any notifications it posted in response to this call
 * when it receives {@link android.app.admin.DeviceAdminReceiver#onPasswordChanged(android.content.Context,android.content.Intent,android.os.UserHandle) DeviceAdminReceiver#onPasswordChanged(Context, Intent, UserHandle)}.
 *
 * @param context The running context as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param intent The received intent as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param user The user or profile for whom the password is expiring. To see whether this
 *        user is the current profile or a parent user, check for equality with
 *        {@link android.os.Process#myUserHandle Process#myUserHandle}.
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public void onPasswordExpiring(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent intent, @androidx.annotation.NonNull android.os.UserHandle user) { throw new RuntimeException("Stub!"); }

/**
 * Called when provisioning of a managed profile or managed device has completed successfully.
 *
 * <p> As a prerequisite for the execution of this callback the {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} has
 * to declare an intent filter for {@link #ACTION_PROFILE_PROVISIONING_COMPLETE}.
 * Its component must also be specified in the {@link android.app.admin.DevicePolicyManager#EXTRA_DEVICE_ADMIN DevicePolicyManager#EXTRA_DEVICE_ADMIN}
 * of the {@link android.app.admin.DevicePolicyManager#ACTION_PROVISION_MANAGED_PROFILE DevicePolicyManager#ACTION_PROVISION_MANAGED_PROFILE} intent that started the
 * managed provisioning.
 *
 * <p>When provisioning of a managed profile is complete, the managed profile is hidden until
 * the profile owner calls {@link android.app.admin.DevicePolicyManager#setProfileEnabled(android.content.ComponentName) DevicePolicyManager#setProfileEnabled(ComponentName admin)}.
 * Typically a profile owner will enable the profile when it has finished any additional setup
 * such as adding an account by using the {@link android.accounts.AccountManager AccountManager} and calling APIs to bring the
 * profile into the desired state.
 *
 * <p> Note that provisioning completes without waiting for any server interactions, so the
 * profile owner needs to wait for data to be available if required (e.g. Android device IDs or
 * other data that is set as a result of server interactions).
 *
 * <p>From version {@link android.os.Build.VERSION_CODES#O}, when managed provisioning has
 * completed, along with this callback the activity intent
 * {@link android.app.admin.DevicePolicyManager#ACTION_PROVISIONING_SUCCESSFUL DevicePolicyManager#ACTION_PROVISIONING_SUCCESSFUL} will also be sent to the same
 * application.
 *
 * @param context The running context as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param intent The received intent as per {@link #onReceive}.
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public void onProfileProvisioningComplete(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Called during provisioning of a managed device to allow the device initializer to perform
 * user setup steps.
 *
 * @param context The running context as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param intent The received intent as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @deprecated Do not use
 * @apiSince 23
 * @deprecatedSince 24
 */

@Deprecated
public void onReadyForUserInitialization(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Called when a device is entering lock task mode.
 *
 * @param context The running context as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param intent The received intent as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param pkg The authorized package using lock task mode.
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public void onLockTaskModeEntering(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent intent, @androidx.annotation.NonNull java.lang.String pkg) { throw new RuntimeException("Stub!"); }

/**
 * Called when a device is exiting lock task mode.
 *
 * @param context The running context as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param intent The received intent as per {@link #onReceive}.
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public void onLockTaskModeExiting(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Allows this receiver to select the alias for a private key and certificate pair for
 * authentication. If this method returns null, the default {@link android.app.Activity} will be
 * shown that lets the user pick a private key and certificate pair.
 *
 * @param context The running context as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param intent The received intent as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param uid The uid of the app asking for the private key and certificate pair.
 * @param uri The URI to authenticate, may be null.
 * This value may be {@code null}.
 * @param alias The alias preselected by the client, or null.
 * This value may be {@code null}.
 * @return The private key alias to return and grant access to.
 * @see KeyChain#choosePrivateKeyAlias
 * @apiSince 23
 */

@androidx.annotation.Nullable
public java.lang.String onChoosePrivateKeyAlias(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent intent, int uid, @androidx.annotation.Nullable android.net.Uri uri, @androidx.annotation.Nullable java.lang.String alias) { throw new RuntimeException("Stub!"); }

/**
 * Called when the information about a pending system update is available.
 *
 * <p>Allows the receiver to be notified when information about a pending system update is
 * available from the system update service. The same pending system update can trigger multiple
 * calls to this method, so it is necessary to examine the incoming parameters for details about
 * the update.
 *
 * <p>This callback is only applicable to device owners and profile owners.
 *
 * <p>To get further information about a pending system update (for example, whether or not the
 * update is a security patch), the device owner or profile owner can call
 * {@link android.app.admin.DevicePolicyManager#getPendingSystemUpdate DevicePolicyManager#getPendingSystemUpdate}.
 *
 * @param context The running context as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param intent The received intent as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param receivedTime The time as given by {@link java.lang.System#currentTimeMillis() System#currentTimeMillis()} indicating when
 *        the current pending update was first available. -1 if no pending update is available.
 * @see android.app.admin.DevicePolicyManager#getPendingSystemUpdate
 * @apiSince 23
 */

public void onSystemUpdatePending(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent intent, long receivedTime) { throw new RuntimeException("Stub!"); }

/**
 * Called when sharing a bugreport has been cancelled by the user of the device.
 *
 * <p>This callback is only applicable to device owners.
 *
 * @param context The running context as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param intent The received intent as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @see android.app.admin.DevicePolicyManager#requestBugreport
 * @apiSince 24
 */

public void onBugreportSharingDeclined(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Called when the bugreport has been shared with the device administrator app.
 *
 * <p>This callback is only applicable to device owners.
 *
 * @param context The running context as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param intent The received intent as per {@link #onReceive}. Contains the URI of
 * the bugreport file (with MIME type "application/vnd.android.bugreport"), that can be accessed
 * by calling {@link android.content.Intent#getData() Intent#getData()}
 * This value must never be {@code null}.
 * @param bugreportHash SHA-256 hash of the bugreport file.
 * This value must never be {@code null}.
 * @see android.app.admin.DevicePolicyManager#requestBugreport
 * @apiSince 24
 */

public void onBugreportShared(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent intent, @androidx.annotation.NonNull java.lang.String bugreportHash) { throw new RuntimeException("Stub!"); }

/**
 * Called when the bugreport collection flow has failed.
 *
 * <p>This callback is only applicable to device owners.
 *
 * @param context The running context as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param intent The received intent as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param failureCode int containing failure code. One of
 * {@link #BUGREPORT_FAILURE_FAILED_COMPLETING}
 * or {@link #BUGREPORT_FAILURE_FILE_NO_LONGER_AVAILABLE}
 * Value is {@link android.app.admin.DeviceAdminReceiver#BUGREPORT_FAILURE_FAILED_COMPLETING}, or {@link android.app.admin.DeviceAdminReceiver#BUGREPORT_FAILURE_FILE_NO_LONGER_AVAILABLE}
 * @see android.app.admin.DevicePolicyManager#requestBugreport
 * @apiSince 24
 */

public void onBugreportFailed(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent intent, int failureCode) { throw new RuntimeException("Stub!"); }

/**
 * Called when a new batch of security logs can be retrieved.
 *
 * <p>If a secondary user or profile is created, this callback won't be received until all users
 * become affiliated again (even if security logging is enabled).
 * See {@link android.app.admin.DevicePolicyManager#setAffiliationIds DevicePolicyManager#setAffiliationIds}
 *
 * <p>This callback will be re-triggered if the logs are not retrieved.
 *
 * <p>This callback is only applicable to device owners.
 *
 * @param context The running context as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param intent The received intent as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @see android.app.admin.DevicePolicyManager#retrieveSecurityLogs(ComponentName)
 * @apiSince 24
 */

public void onSecurityLogsAvailable(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Called each time a new batch of network logs can be retrieved. This callback method will only
 * ever be called when network logging is enabled. The logs can only be retrieved while network
 * logging is enabled.
 *
 * <p>If a secondary user or profile is created, this callback won't be received until all users
 * become affiliated again (even if network logging is enabled). It will also no longer be
 * possible to retrieve the network logs batch with the most recent {@code batchToken} provided
 * by this callback. See {@link android.app.admin.DevicePolicyManager#setAffiliationIds DevicePolicyManager#setAffiliationIds}.
 *
 * <p>This callback is only applicable to device owners.
 *
 * @param context The running context as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param intent The received intent as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param batchToken The token representing the current batch of network logs.
 * @param networkLogsCount The total count of events in the current batch of network logs.
 * Value is 1 or greater
 * @see android.app.admin.DevicePolicyManager#retrieveNetworkLogs
 * @apiSince 26
 */

public void onNetworkLogsAvailable(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent intent, long batchToken, int networkLogsCount) { throw new RuntimeException("Stub!"); }

/**
 * Called when a user or profile is created.
 *
 * <p>This callback is only applicable to device owners.
 *
 * @param context The running context as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param intent The received intent as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param newUser The {@link android.os.UserHandle UserHandle} of the user that has just been added.
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public void onUserAdded(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent intent, @androidx.annotation.NonNull android.os.UserHandle newUser) { throw new RuntimeException("Stub!"); }

/**
 * Called when a user or profile is removed.
 *
 * <p>This callback is only applicable to device owners.
 *
 * @param context The running context as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param intent The received intent as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param removedUser The {@link android.os.UserHandle UserHandle} of the user that has just been removed.
 
 * This value must never be {@code null}.
 * @apiSince 26
 */

public void onUserRemoved(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent intent, @androidx.annotation.NonNull android.os.UserHandle removedUser) { throw new RuntimeException("Stub!"); }

/**
 * Called when a user or profile is started.
 *
 * <p>This callback is only applicable to device owners.
 *
 * @param context The running context as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param intent The received intent as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param startedUser The {@link android.os.UserHandle UserHandle} of the user that has just been started.
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public void onUserStarted(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent intent, @androidx.annotation.NonNull android.os.UserHandle startedUser) { throw new RuntimeException("Stub!"); }

/**
 * Called when a user or profile is stopped.
 *
 * <p>This callback is only applicable to device owners.
 *
 * @param context The running context as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param intent The received intent as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param stoppedUser The {@link android.os.UserHandle UserHandle} of the user that has just been stopped.
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public void onUserStopped(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent intent, @androidx.annotation.NonNull android.os.UserHandle stoppedUser) { throw new RuntimeException("Stub!"); }

/**
 * Called when a user or profile is switched to.
 *
 * <p>This callback is only applicable to device owners.
 *
 * @param context The running context as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param intent The received intent as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param switchedUser The {@link android.os.UserHandle UserHandle} of the user that has just been switched to.
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public void onUserSwitched(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent intent, @androidx.annotation.NonNull android.os.UserHandle switchedUser) { throw new RuntimeException("Stub!"); }

/**
 * Called on the newly assigned owner (either device owner or profile owner) when the ownership
 * transfer has completed successfully.
 *
 * <p> The {@code bundle} parameter allows the original owner to pass data
 * to the new one.
 *
 * @param context the running context as per {@link #onReceive}
 * This value must never be {@code null}.
 * @param bundle the data to be passed to the new owner
 
 * This value may be {@code null}.
 * @apiSince 28
 */

public void onTransferOwnershipComplete(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.os.PersistableBundle bundle) { throw new RuntimeException("Stub!"); }

/**
 * Called on the device owner when the ownership of one of its affiliated profiles is
 * transferred.
 *
 * <p>This can be used when transferring both device and profile ownership when using
 * work profile on a fully managed device. The process would look like this:
 * <ol>
 * <li>Transfer profile ownership</li>
 * <li>The device owner gets notified with this callback</li>
 * <li>Transfer device ownership</li>
 * <li>Both profile and device ownerships have been transferred</li>
 * </ol>
 *
 * @param context the running context as per {@link #onReceive}
 * This value must never be {@code null}.
 * @param user the {@link android.os.UserHandle UserHandle} of the affiliated user
 * This value must never be {@code null}.
 * @see android.app.admin.DevicePolicyManager#transferOwnership(ComponentName, ComponentName, PersistableBundle)
 * @apiSince 28
 */

public void onTransferAffiliatedProfileOwnershipComplete(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.os.UserHandle user) { throw new RuntimeException("Stub!"); }

/**
 * Intercept standard device administrator broadcasts.  Implementations
 * should not override this method; it is better to implement the
 * convenience callbacks for each action.
 
 * @param context This value must never be {@code null}.
 
 * @param intent This value must never be {@code null}.
 * @apiSince 8
 */

public void onReceive(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Broadcast action: notify that some app is attempting to choose a KeyChain key.
 * @see android.app.admin.DeviceAdminReceiver#onChoosePrivateKeyAlias
 * @see android.app.admin.DelegatedAdminReceiver#onChoosePrivateKeyAlias
 * @apiSince 29
 */

public static final java.lang.String ACTION_CHOOSE_PRIVATE_KEY_ALIAS = "android.app.action.CHOOSE_PRIVATE_KEY_ALIAS";

/**
 * Action sent to a device administrator when the user has disabled
 * it.  Upon return, the application no longer has access to the
 * protected device policy manager APIs.  You will generally
 * handle this in {@link android.app.admin.DeviceAdminReceiver#onDisabled(android.content.Context,android.content.Intent) DeviceAdminReceiver#onDisabled(Context, Intent)}.  Note
 * that this action will be
 * sent the receiver regardless of whether it is explicitly listed in
 * its intent filter.
 * @apiSince 8
 */

public static final java.lang.String ACTION_DEVICE_ADMIN_DISABLED = "android.app.action.DEVICE_ADMIN_DISABLED";

/**
 * Action sent to a device administrator when the user has requested to
 * disable it, but before this has actually been done.  This gives you
 * a chance to supply a message to the user about the impact of
 * disabling your admin, by setting the extra field
 * {@link #EXTRA_DISABLE_WARNING} in the result Intent.  If not set,
 * no warning will be displayed.  If set, the given text will be shown
 * to the user before they disable your admin.
 * @apiSince 8
 */

public static final java.lang.String ACTION_DEVICE_ADMIN_DISABLE_REQUESTED = "android.app.action.DEVICE_ADMIN_DISABLE_REQUESTED";

/**
 * This is the primary action that a device administrator must implement to be
 * allowed to manage a device.  This will be set to the receiver
 * when the user enables it for administration.  You will generally
 * handle this in {@link android.app.admin.DeviceAdminReceiver#onEnabled(android.content.Context,android.content.Intent) DeviceAdminReceiver#onEnabled(Context, Intent)}.  To be
 * supported, the receiver must also require the
 * {@link android.Manifest.permission#BIND_DEVICE_ADMIN} permission so
 * that other applications can not abuse it.
 * @apiSince 8
 */

public static final java.lang.String ACTION_DEVICE_ADMIN_ENABLED = "android.app.action.DEVICE_ADMIN_ENABLED";

/**
 * Action sent to a device administrator to notify that the device is entering
 * lock task mode.  The extra {@link #EXTRA_LOCK_TASK_PACKAGE}
 * will describe the package using lock task mode.
 *
 * <p>The calling device admin must be the device owner or profile
 * owner to receive this broadcast.
 *
 * @see android.app.admin.DevicePolicyManager#isLockTaskPermitted(String)
 * @apiSince 21
 */

public static final java.lang.String ACTION_LOCK_TASK_ENTERING = "android.app.action.LOCK_TASK_ENTERING";

/**
 * Action sent to a device administrator to notify that the device is exiting
 * lock task mode.
 *
 * <p>The calling device admin must be the device owner or profile
 * owner to receive this broadcast.
 *
 * @see android.app.admin.DevicePolicyManager#isLockTaskPermitted(String)
 * @apiSince 21
 */

public static final java.lang.String ACTION_LOCK_TASK_EXITING = "android.app.action.LOCK_TASK_EXITING";

/**
 * Broadcast action: notify that a new batch of network logs is ready to be collected.
 * @see android.app.admin.DeviceAdminReceiver#onNetworkLogsAvailable
 * @see android.app.admin.DelegatedAdminReceiver#onNetworkLogsAvailable
 * @apiSince 29
 */

public static final java.lang.String ACTION_NETWORK_LOGS_AVAILABLE = "android.app.action.NETWORK_LOGS_AVAILABLE";

/**
 * Action sent to a device administrator when the user has changed the password of their device
 * or profile challenge.  You can at this point check the characteristics
 * of the new password with {@link android.app.admin.DevicePolicyManager#isActivePasswordSufficient() DevicePolicyManager#isActivePasswordSufficient()}.
 * You will generally
 * handle this in {@link android.app.admin.DeviceAdminReceiver#onPasswordChanged(android.content.Context,android.content.Intent,android.os.UserHandle) DeviceAdminReceiver#onPasswordChanged(Context, Intent, UserHandle)}.
 *
 * <p>The calling device admin must have requested
 * {@link android.app.admin.DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD} to receive
 * this broadcast.
 * @apiSince 8
 */

public static final java.lang.String ACTION_PASSWORD_CHANGED = "android.app.action.ACTION_PASSWORD_CHANGED";

/**
 * Action periodically sent to a device administrator when the device or profile challenge
 * password is expiring.  You will generally
 * handle this in {@link android.app.admin.DeviceAdminReceiver#onPasswordExpiring(android.content.Context,android.content.Intent,android.os.UserHandle) DeviceAdminReceiver#onPasswordExpiring(Context, Intent, UserHandle)}.
 *
 * <p>The calling device admin must have requested
 * {@link android.app.admin.DeviceAdminInfo#USES_POLICY_EXPIRE_PASSWORD DeviceAdminInfo#USES_POLICY_EXPIRE_PASSWORD} to receive
 * this broadcast.
 * @apiSince 11
 */

public static final java.lang.String ACTION_PASSWORD_EXPIRING = "android.app.action.ACTION_PASSWORD_EXPIRING";

/**
 * Action sent to a device administrator when the user has entered an incorrect device
 * or profile challenge password.  You can at this point check the
 * number of failed password attempts there have been with
 * {@link android.app.admin.DevicePolicyManager#getCurrentFailedPasswordAttempts DevicePolicyManager#getCurrentFailedPasswordAttempts}.  You will generally
 * handle this in {@link android.app.admin.DeviceAdminReceiver#onPasswordFailed(android.content.Context,android.content.Intent,android.os.UserHandle) DeviceAdminReceiver#onPasswordFailed(Context, Intent, UserHandle)}.
 *
 * <p>The calling device admin must have requested
 * {@link android.app.admin.DeviceAdminInfo#USES_POLICY_WATCH_LOGIN DeviceAdminInfo#USES_POLICY_WATCH_LOGIN} to receive
 * this broadcast.
 * @apiSince 8
 */

public static final java.lang.String ACTION_PASSWORD_FAILED = "android.app.action.ACTION_PASSWORD_FAILED";

/**
 * Action sent to a device administrator when the user has successfully entered their device
 * or profile challenge password, after failing one or more times.  You will generally
 * handle this in {@link android.app.admin.DeviceAdminReceiver#onPasswordSucceeded(android.content.Context,android.content.Intent,android.os.UserHandle) DeviceAdminReceiver#onPasswordSucceeded(Context, Intent, UserHandle)}.
 *
 * <p>The calling device admin must have requested
 * {@link android.app.admin.DeviceAdminInfo#USES_POLICY_WATCH_LOGIN DeviceAdminInfo#USES_POLICY_WATCH_LOGIN} to receive
 * this broadcast.
 * @apiSince 8
 */

public static final java.lang.String ACTION_PASSWORD_SUCCEEDED = "android.app.action.ACTION_PASSWORD_SUCCEEDED";

/**
 * Broadcast Action: This broadcast is sent to indicate that provisioning of a managed profile
 * or managed device has completed successfully.
 *
 * <p>The broadcast is limited to the profile that will be managed by the application that
 * requested provisioning. In the device owner case the profile is the primary user.
 * The broadcast will also be limited to the {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} component
 * specified in the original intent or NFC bump that started the provisioning process
 * (see {@link android.app.admin.DevicePolicyManager#ACTION_PROVISION_MANAGED_PROFILE DevicePolicyManager#ACTION_PROVISION_MANAGED_PROFILE}).
 *
 * <p>A device admin application which listens to this intent can find out if the device was
 * provisioned for the device owner or profile owner case by calling respectively
 * {@link android.app.admin.DevicePolicyManager#isDeviceOwnerApp} and
 * {@link android.app.admin.DevicePolicyManager#isProfileOwnerApp}. You will generally handle
 * this in {@link android.app.admin.DeviceAdminReceiver#onProfileProvisioningComplete DeviceAdminReceiver#onProfileProvisioningComplete}.
 *
 * @see android.app.admin.DevicePolicyManager#ACTION_PROVISIONING_SUCCESSFUL
 * @apiSince 21
 */

public static final java.lang.String ACTION_PROFILE_PROVISIONING_COMPLETE = "android.app.action.PROFILE_PROVISIONING_COMPLETE";

/**
 * Bugreport completion process failed.
 *
 * <p>If this error code is received, the requesting of bugreport can be retried.
 * @see android.app.admin.DevicePolicyManager#requestBugreport
 * @apiSince 24
 */

public static final int BUGREPORT_FAILURE_FAILED_COMPLETING = 0; // 0x0

/**
 * Bugreport has been created, but is no longer available for collection.
 *
 * <p>This error likely occurs because the user of the device hasn't consented to share
 * the bugreport for a long period after its creation.
 *
 * <p>If this error code is received, the requesting of bugreport can be retried.
 * @see android.app.admin.DevicePolicyManager#requestBugreport
 * @apiSince 24
 */

public static final int BUGREPORT_FAILURE_FILE_NO_LONGER_AVAILABLE = 1; // 0x1

/**
 * Name under which a DevicePolicy component publishes information
 * about itself.  This meta-data must reference an XML resource containing
 * a device-admin tag.
 * @apiSince 8
 */

public static final java.lang.String DEVICE_ADMIN_META_DATA = "android.app.device_admin";

/**
 * A CharSequence that can be shown to the user informing them of the
 * impact of disabling your admin.
 *
 * @see #ACTION_DEVICE_ADMIN_DISABLE_REQUESTED
 * @apiSince 8
 */

public static final java.lang.String EXTRA_DISABLE_WARNING = "android.app.extra.DISABLE_WARNING";

/**
 * A string containing the name of the package entering lock task mode.
 *
 * @see #ACTION_LOCK_TASK_ENTERING
 * @apiSince 21
 */

public static final java.lang.String EXTRA_LOCK_TASK_PACKAGE = "android.app.extra.LOCK_TASK_PACKAGE";

/**
 * A {@link android.os.Parcelable} extra of type {@link android.os.PersistableBundle} that
 * allows a mobile device management application to pass data to the management application
 * instance after owner transfer.
 *
 * <p>If the transfer is successful, the new owner receives the data in
 * {@link android.app.admin.DeviceAdminReceiver#onTransferOwnershipComplete(android.content.Context,android.os.PersistableBundle) DeviceAdminReceiver#onTransferOwnershipComplete(Context, PersistableBundle)}.
 * The bundle is not changed during the ownership transfer.
 *
 * @see android.app.admin.DevicePolicyManager#transferOwnership(ComponentName, ComponentName, PersistableBundle)
 * @apiSince 28
 */

public static final java.lang.String EXTRA_TRANSFER_OWNERSHIP_ADMIN_EXTRAS_BUNDLE = "android.app.extra.TRANSFER_OWNERSHIP_ADMIN_EXTRAS_BUNDLE";
}

