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

import android.content.pm.PackageManager;
import android.content.ComponentName;
import android.Manifest.permission;
import android.os.UserManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.app.KeyguardManager;
import android.net.ProxyInfo;
import java.util.Set;
import java.util.List;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import android.security.KeyChain;
import android.security.keystore.StrongBoxUnavailableException;
import android.security.AttestedKeyPair;
import android.security.keystore.KeyGenParameterSpec;
import java.util.ArrayList;
import android.content.pm.PackageManager.NameNotFoundException;
import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.os.UserManager.UserOperationException;
import android.provider.Settings;
import android.service.restrictions.RestrictionsReceiver;
import android.telephony.TelephonyManager;
import android.app.admin.SecurityLog.SecurityEvent;
import android.content.ServiceConnection;
import java.util.concurrent.Executor;
import android.telephony.data.ApnSetting;
import android.net.Uri;
import android.os.Parcelable;
import android.content.pm.ApplicationInfo;

/**
 * Public interface for managing policies enforced on a device. Most clients of this class must be
 * registered with the system as a <a href="{@docRoot}guide/topics/admin/device-admin.html">device
 * administrator</a>. Additionally, a device administrator may be registered as either a profile or
 * device owner. A given method is accessible to all device administrators unless the documentation
 * for that method specifies that it is restricted to either device or profile owners. Any
 * application calling an api may only pass as an argument a device administrator component it
 * owns. Otherwise, a {@link java.lang.SecurityException SecurityException} will be thrown.
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>
 * For more information about managing policies for device administration, read the <a href=
 * "{@docRoot}guide/topics/admin/device-admin.html">Device Administration</a> developer
 * guide. </div>
 
 * <br>
 * Requires the {@link android.content.pm.PackageManager#FEATURE_DEVICE_ADMIN PackageManager#FEATURE_DEVICE_ADMIN} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DevicePolicyManager {

DevicePolicyManager() { throw new RuntimeException("Stub!"); }

/**
 * Return true if the given administrator component is currently active (enabled) in the system.
 *
 * @param admin The administrator component to check for.
 * This value must never be {@code null}.
 * @return {@code true} if {@code admin} is currently enabled in the system, {@code false}
 *         otherwise
 * @apiSince 8
 */

public boolean isAdminActive(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Return a list of all currently active device administrators' component
 * names.  If there are no administrators {@code null} may be
 * returned.
 * @apiSince 8
 */

@androidx.annotation.Nullable
public java.util.List<android.content.ComponentName> getActiveAdmins() { throw new RuntimeException("Stub!"); }

/**
 * Remove a current administration component.  This can only be called
 * by the application that owns the administration component; if you
 * try to remove someone else's component, a security exception will be
 * thrown.
 *
 * <p>Note that the operation is not synchronous and the admin might still be active (as
 * indicated by {@link #getActiveAdmins()}) by the time this method returns.
 *
 * @param admin The administration compononent to remove.
 * This value must never be {@code null}.
 * @throws java.lang.SecurityException if the caller is not in the owner application of {@code admin}.
 * @apiSince 8
 */

public void removeActiveAdmin(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if an administrator has been granted a particular device policy. This can be
 * used to check whether the administrator was activated under an earlier set of policies, but
 * requires additional policies after an upgrade.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with. Must be an
 *            active administrator, or an exception will be thrown.
 * This value must never be {@code null}.
 * @param usesPolicy Which uses-policy to check, as defined in {@link android.app.admin.DeviceAdminInfo DeviceAdminInfo}.
 * @throws java.lang.SecurityException if {@code admin} is not an active administrator.
 * @apiSince 11
 */

public boolean hasGrantedPolicy(@androidx.annotation.NonNull android.content.ComponentName admin, int usesPolicy) { throw new RuntimeException("Stub!"); }

/**
 * Called by an application that is administering the device to set the password restrictions it
 * is imposing. After setting this, the user will not be able to enter a new password that is
 * not at least as restrictive as what has been set. Note that the current password will remain
 * until the user has set a new one, so the change does not take place immediately. To prompt
 * the user for a new password, use {@link #ACTION_SET_NEW_PASSWORD} or
 * {@link #ACTION_SET_NEW_PARENT_PROFILE_PASSWORD} after calling this method.
 * <p>
 * Quality constants are ordered so that higher values are more restrictive; thus the highest
 * requested quality constant (between the policy set here, the user's preference, and any other
 * considerations) is the one that is in effect.
 * <p>
 * On devices not supporting {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature, the
 * password is always treated as empty.
 * <p>
 * The calling device admin must have requested
 * {@link android.app.admin.DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD} to be able to call this method; if it has
 * not, a security exception will be thrown.
 * <p>
 * This method can be called on the {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance returned by
 * {@link #getParentProfileInstance(android.content.ComponentName)} in order to set restrictions on the parent
 * profile.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param quality The new desired quality. One of {@link #PASSWORD_QUALITY_UNSPECIFIED},
 *            {@link #PASSWORD_QUALITY_BIOMETRIC_WEAK},
 *            {@link #PASSWORD_QUALITY_SOMETHING}, {@link #PASSWORD_QUALITY_NUMERIC},
 *            {@link #PASSWORD_QUALITY_NUMERIC_COMPLEX}, {@link #PASSWORD_QUALITY_ALPHABETIC},
 *            {@link #PASSWORD_QUALITY_ALPHANUMERIC} or {@link #PASSWORD_QUALITY_COMPLEX}.
 * @throws java.lang.SecurityException if {@code admin} is not an active administrator or if {@code admin}
 *             does not use {@link android.app.admin.DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD}
 * @apiSince 8
 */

public void setPasswordQuality(@androidx.annotation.NonNull android.content.ComponentName admin, int quality) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the current minimum password quality for a particular admin or all admins that set
 * restrictions on this user and its participating profiles. Restrictions on profiles that have
 * a separate challenge are not taken into account.
 *
 * <p>This method can be called on the {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance
 * returned by {@link #getParentProfileInstance(android.content.ComponentName)} in order to retrieve
 * restrictions on the parent profile.
 *
 * <p>Note: on devices not supporting {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature,
 * the password is always treated as empty.
 *
 * @param admin The name of the admin component to check, or {@code null} to aggregate
 * all admins.
 
 * This value may be {@code null}.
 * @apiSince 8
 */

public int getPasswordQuality(@androidx.annotation.Nullable android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by an application that is administering the device to set the minimum allowed password
 * length. After setting this, the user will not be able to enter a new password that is not at
 * least as restrictive as what has been set. Note that the current password will remain until
 * the user has set a new one, so the change does not take place immediately. To prompt the user
 * for a new password, use {@link #ACTION_SET_NEW_PASSWORD} or
 * {@link #ACTION_SET_NEW_PARENT_PROFILE_PASSWORD} after setting this value. This constraint is
 * only imposed if the administrator has also requested either {@link #PASSWORD_QUALITY_NUMERIC}
 * , {@link #PASSWORD_QUALITY_NUMERIC_COMPLEX}, {@link #PASSWORD_QUALITY_ALPHABETIC},
 * {@link #PASSWORD_QUALITY_ALPHANUMERIC}, or {@link #PASSWORD_QUALITY_COMPLEX} with
 * {@link #setPasswordQuality}.
 * <p>
 * On devices not supporting {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature, the
 * password is always treated as empty.
 * <p>
 * The calling device admin must have requested
 * {@link android.app.admin.DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD} to be able to call this method; if it has
 * not, a security exception will be thrown.
 * <p>
 * This method can be called on the {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance returned by
 * {@link #getParentProfileInstance(android.content.ComponentName)} in order to set restrictions on the parent
 * profile.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param length The new desired minimum password length. A value of 0 means there is no
 *            restriction.
 * @throws java.lang.SecurityException if {@code admin} is not an active administrator or {@code admin}
 *             does not use {@link android.app.admin.DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD}
 * @apiSince 8
 */

public void setPasswordMinimumLength(@androidx.annotation.NonNull android.content.ComponentName admin, int length) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the current minimum password length for a particular admin or all admins that set
 * restrictions on this user and its participating profiles. Restrictions on profiles that have
 * a separate challenge are not taken into account.
 *
 * <p>On devices not supporting {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature, the
 * password is always treated as empty.
 *
 * <p>This method can be called on the {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance
 * returned by {@link #getParentProfileInstance(android.content.ComponentName)} in order to retrieve
 * restrictions on the parent profile.
 *
 * @param admin The name of the admin component to check, or {@code null} to aggregate
 * all admins.
 
 * This value may be {@code null}.
 * @apiSince 8
 */

public int getPasswordMinimumLength(@androidx.annotation.Nullable android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by an application that is administering the device to set the minimum number of upper
 * case letters required in the password. After setting this, the user will not be able to enter
 * a new password that is not at least as restrictive as what has been set. Note that the
 * current password will remain until the user has set a new one, so the change does not take
 * place immediately. To prompt the user for a new password, use
 * {@link #ACTION_SET_NEW_PASSWORD} or {@link #ACTION_SET_NEW_PARENT_PROFILE_PASSWORD} after
 * setting this value. This constraint is only imposed if the administrator has also requested
 * {@link #PASSWORD_QUALITY_COMPLEX} with {@link #setPasswordQuality}. The default value is 0.
 * <p>
 * On devices not supporting {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature, the
 * password is always treated as empty.
 * <p>
 * The calling device admin must have requested
 * {@link android.app.admin.DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD} to be able to call this method; if it has
 * not, a security exception will be thrown.
 * <p>
 * This method can be called on the {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance returned by
 * {@link #getParentProfileInstance(android.content.ComponentName)} in order to set restrictions on the parent
 * profile.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param length The new desired minimum number of upper case letters required in the password.
 *            A value of 0 means there is no restriction.
 * @throws java.lang.SecurityException if {@code admin} is not an active administrator or {@code admin}
 *             does not use {@link android.app.admin.DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD}
 * @apiSince 11
 */

public void setPasswordMinimumUpperCase(@androidx.annotation.NonNull android.content.ComponentName admin, int length) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the current number of upper case letters required in the password
 * for a particular admin or all admins that set restrictions on this user and
 * its participating profiles. Restrictions on profiles that have a separate challenge
 * are not taken into account.
 * This is the same value as set by
 * {@link #setPasswordMinimumUpperCase(android.content.ComponentName,int)}
 * and only applies when the password quality is
 * {@link #PASSWORD_QUALITY_COMPLEX}.
 *
 * <p>On devices not supporting {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature, the
 * password is always treated as empty.
 *
 * <p>This method can be called on the {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance
 * returned by {@link #getParentProfileInstance(android.content.ComponentName)} in order to retrieve
 * restrictions on the parent profile.
 *
 * @param admin The name of the admin component to check, or {@code null} to
 *            aggregate all admins.
 * This value may be {@code null}.
 * @return The minimum number of upper case letters required in the
 *         password.
 * @apiSince 11
 */

public int getPasswordMinimumUpperCase(@androidx.annotation.Nullable android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by an application that is administering the device to set the minimum number of lower
 * case letters required in the password. After setting this, the user will not be able to enter
 * a new password that is not at least as restrictive as what has been set. Note that the
 * current password will remain until the user has set a new one, so the change does not take
 * place immediately. To prompt the user for a new password, use
 * {@link #ACTION_SET_NEW_PASSWORD} or {@link #ACTION_SET_NEW_PARENT_PROFILE_PASSWORD} after
 * setting this value. This constraint is only imposed if the administrator has also requested
 * {@link #PASSWORD_QUALITY_COMPLEX} with {@link #setPasswordQuality}. The default value is 0.
 * <p>
 * On devices not supporting {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature, the
 * password is always treated as empty.
 * <p>
 * The calling device admin must have requested
 * {@link android.app.admin.DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD} to be able to call this method; if it has
 * not, a security exception will be thrown.
 * <p>
 * This method can be called on the {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance returned by
 * {@link #getParentProfileInstance(android.content.ComponentName)} in order to set restrictions on the parent
 * profile.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param length The new desired minimum number of lower case letters required in the password.
 *            A value of 0 means there is no restriction.
 * @throws java.lang.SecurityException if {@code admin} is not an active administrator or {@code admin}
 *             does not use {@link android.app.admin.DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD}
 * @apiSince 11
 */

public void setPasswordMinimumLowerCase(@androidx.annotation.NonNull android.content.ComponentName admin, int length) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the current number of lower case letters required in the password
 * for a particular admin or all admins that set restrictions on this user
 * and its participating profiles. Restrictions on profiles that have
 * a separate challenge are not taken into account.
 * This is the same value as set by
 * {@link #setPasswordMinimumLowerCase(android.content.ComponentName,int)}
 * and only applies when the password quality is
 * {@link #PASSWORD_QUALITY_COMPLEX}.
 *
 * <p>On devices not supporting {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature, the
 * password is always treated as empty.
 *
 * <p>This method can be called on the {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance
 * returned by {@link #getParentProfileInstance(android.content.ComponentName)} in order to retrieve
 * restrictions on the parent profile.
 *
 * @param admin The name of the admin component to check, or {@code null} to
 *            aggregate all admins.
 * This value may be {@code null}.
 * @return The minimum number of lower case letters required in the
 *         password.
 * @apiSince 11
 */

public int getPasswordMinimumLowerCase(@androidx.annotation.Nullable android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by an application that is administering the device to set the minimum number of
 * letters required in the password. After setting this, the user will not be able to enter a
 * new password that is not at least as restrictive as what has been set. Note that the current
 * password will remain until the user has set a new one, so the change does not take place
 * immediately. To prompt the user for a new password, use {@link #ACTION_SET_NEW_PASSWORD} or
 * {@link #ACTION_SET_NEW_PARENT_PROFILE_PASSWORD} after setting this value. This constraint is
 * only imposed if the administrator has also requested {@link #PASSWORD_QUALITY_COMPLEX} with
 * {@link #setPasswordQuality}. The default value is 1.
 * <p>
 * On devices not supporting {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature, the
 * password is always treated as empty.
 * <p>
 * The calling device admin must have requested
 * {@link android.app.admin.DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD} to be able to call this method; if it has
 * not, a security exception will be thrown.
 * <p>
 * This method can be called on the {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance returned by
 * {@link #getParentProfileInstance(android.content.ComponentName)} in order to set restrictions on the parent
 * profile.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param length The new desired minimum number of letters required in the password. A value of
 *            0 means there is no restriction.
 * @throws java.lang.SecurityException if {@code admin} is not an active administrator or {@code admin}
 *             does not use {@link android.app.admin.DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD}
 * @apiSince 11
 */

public void setPasswordMinimumLetters(@androidx.annotation.NonNull android.content.ComponentName admin, int length) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the current number of letters required in the password
 * for a particular admin or all admins that set restrictions on this user
 * and its participating profiles. Restrictions on profiles that have
 * a separate challenge are not taken into account.
 * This is the same value as set by
 * {@link #setPasswordMinimumLetters(android.content.ComponentName,int)}
 * and only applies when the password quality is
 * {@link #PASSWORD_QUALITY_COMPLEX}.
 *
 * <p>On devices not supporting {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature, the
 * password is always treated as empty.
 *
 * <p>This method can be called on the {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance
 * returned by {@link #getParentProfileInstance(android.content.ComponentName)} in order to retrieve
 * restrictions on the parent profile.
 *
 * @param admin The name of the admin component to check, or {@code null} to
 *            aggregate all admins.
 * This value may be {@code null}.
 * @return The minimum number of letters required in the password.
 * @apiSince 11
 */

public int getPasswordMinimumLetters(@androidx.annotation.Nullable android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by an application that is administering the device to set the minimum number of
 * numerical digits required in the password. After setting this, the user will not be able to
 * enter a new password that is not at least as restrictive as what has been set. Note that the
 * current password will remain until the user has set a new one, so the change does not take
 * place immediately. To prompt the user for a new password, use
 * {@link #ACTION_SET_NEW_PASSWORD} or {@link #ACTION_SET_NEW_PARENT_PROFILE_PASSWORD} after
 * setting this value. This constraint is only imposed if the administrator has also requested
 * {@link #PASSWORD_QUALITY_COMPLEX} with {@link #setPasswordQuality}. The default value is 1.
 * <p>
 * On devices not supporting {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature, the
 * password is always treated as empty.
 * <p>
 * The calling device admin must have requested
 * {@link android.app.admin.DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD} to be able to call this method; if it has
 * not, a security exception will be thrown.
 * <p>
 * This method can be called on the {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance returned by
 * {@link #getParentProfileInstance(android.content.ComponentName)} in order to set restrictions on the parent
 * profile.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param length The new desired minimum number of numerical digits required in the password. A
 *            value of 0 means there is no restriction.
 * @throws java.lang.SecurityException if {@code admin} is not an active administrator or {@code admin}
 *             does not use {@link android.app.admin.DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD}
 * @apiSince 11
 */

public void setPasswordMinimumNumeric(@androidx.annotation.NonNull android.content.ComponentName admin, int length) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the current number of numerical digits required in the password
 * for a particular admin or all admins that set restrictions on this user
 * and its participating profiles. Restrictions on profiles that have
 * a separate challenge are not taken into account.
 * This is the same value as set by
 * {@link #setPasswordMinimumNumeric(android.content.ComponentName,int)}
 * and only applies when the password quality is
 * {@link #PASSWORD_QUALITY_COMPLEX}.
 *
 * <p>On devices not supporting {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature, the
 * password is always treated as empty.
 *
 * <p>This method can be called on the {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance
 * returned by {@link #getParentProfileInstance(android.content.ComponentName)} in order to retrieve
 * restrictions on the parent profile.
 *
 * @param admin The name of the admin component to check, or {@code null} to
 *            aggregate all admins.
 * This value may be {@code null}.
 * @return The minimum number of numerical digits required in the password.
 * @apiSince 11
 */

public int getPasswordMinimumNumeric(@androidx.annotation.Nullable android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by an application that is administering the device to set the minimum number of
 * symbols required in the password. After setting this, the user will not be able to enter a
 * new password that is not at least as restrictive as what has been set. Note that the current
 * password will remain until the user has set a new one, so the change does not take place
 * immediately. To prompt the user for a new password, use {@link #ACTION_SET_NEW_PASSWORD} or
 * {@link #ACTION_SET_NEW_PARENT_PROFILE_PASSWORD} after setting this value. This constraint is
 * only imposed if the administrator has also requested {@link #PASSWORD_QUALITY_COMPLEX} with
 * {@link #setPasswordQuality}. The default value is 1.
 * <p>
 * On devices not supporting {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature, the
 * password is always treated as empty.
 * <p>
 * The calling device admin must have requested
 * {@link android.app.admin.DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD} to be able to call this method; if it has
 * not, a security exception will be thrown.
 * <p>
 * This method can be called on the {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance returned by
 * {@link #getParentProfileInstance(android.content.ComponentName)} in order to set restrictions on the parent
 * profile.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param length The new desired minimum number of symbols required in the password. A value of
 *            0 means there is no restriction.
 * @throws java.lang.SecurityException if {@code admin} is not an active administrator or {@code admin}
 *             does not use {@link android.app.admin.DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD}
 * @apiSince 11
 */

public void setPasswordMinimumSymbols(@androidx.annotation.NonNull android.content.ComponentName admin, int length) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the current number of symbols required in the password
 * for a particular admin or all admins that set restrictions on this user
 * and its participating profiles. Restrictions on profiles that have
 * a separate challenge are not taken into account. This is the same value as
 * set by {@link #setPasswordMinimumSymbols(android.content.ComponentName,int)}
 * and only applies when the password quality is
 * {@link #PASSWORD_QUALITY_COMPLEX}.
 *
 * <p>On devices not supporting {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature, the
 * password is always treated as empty.
 *
 * <p>This method can be called on the {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance
 * returned by {@link #getParentProfileInstance(android.content.ComponentName)} in order to retrieve
 * restrictions on the parent profile.
 *
 * @param admin The name of the admin component to check, or {@code null} to
 *            aggregate all admins.
 * This value may be {@code null}.
 * @return The minimum number of symbols required in the password.
 * @apiSince 11
 */

public int getPasswordMinimumSymbols(@androidx.annotation.Nullable android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by an application that is administering the device to set the minimum number of
 * non-letter characters (numerical digits or symbols) required in the password. After setting
 * this, the user will not be able to enter a new password that is not at least as restrictive
 * as what has been set. Note that the current password will remain until the user has set a new
 * one, so the change does not take place immediately. To prompt the user for a new password,
 * use {@link #ACTION_SET_NEW_PASSWORD} or {@link #ACTION_SET_NEW_PARENT_PROFILE_PASSWORD} after
 * setting this value. This constraint is only imposed if the administrator has also requested
 * {@link #PASSWORD_QUALITY_COMPLEX} with {@link #setPasswordQuality}. The default value is 0.
 * <p>
 * On devices not supporting {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature, the
 * password is always treated as empty.
 * <p>
 * The calling device admin must have requested
 * {@link android.app.admin.DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD} to be able to call this method; if it has
 * not, a security exception will be thrown.
 * <p>
 * This method can be called on the {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance returned by
 * {@link #getParentProfileInstance(android.content.ComponentName)} in order to set restrictions on the parent
 * profile.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param length The new desired minimum number of letters required in the password. A value of
 *            0 means there is no restriction.
 * @throws java.lang.SecurityException if {@code admin} is not an active administrator or {@code admin}
 *             does not use {@link android.app.admin.DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD}
 * @apiSince 11
 */

public void setPasswordMinimumNonLetter(@androidx.annotation.NonNull android.content.ComponentName admin, int length) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the current number of non-letter characters required in the password
 * for a particular admin or all admins that set restrictions on this user
 * and its participating profiles. Restrictions on profiles that have
 * a separate challenge are not taken into account.
 * This is the same value as set by
 * {@link #setPasswordMinimumNonLetter(android.content.ComponentName,int)}
 * and only applies when the password quality is
 * {@link #PASSWORD_QUALITY_COMPLEX}.
 *
 * <p>On devices not supporting {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature, the
 * password is always treated as empty.
 *
 * <p>This method can be called on the {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance
 * returned by {@link #getParentProfileInstance(android.content.ComponentName)} in order to retrieve
 * restrictions on the parent profile.
 *
 * @param admin The name of the admin component to check, or {@code null} to
 *            aggregate all admins.
 * This value may be {@code null}.
 * @return The minimum number of letters required in the password.
 * @apiSince 11
 */

public int getPasswordMinimumNonLetter(@androidx.annotation.Nullable android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by an application that is administering the device to set the length of the password
 * history. After setting this, the user will not be able to enter a new password that is the
 * same as any password in the history. Note that the current password will remain until the
 * user has set a new one, so the change does not take place immediately. To prompt the user for
 * a new password, use {@link #ACTION_SET_NEW_PASSWORD} or
 * {@link #ACTION_SET_NEW_PARENT_PROFILE_PASSWORD} after setting this value. This constraint is
 * only imposed if the administrator has also requested either {@link #PASSWORD_QUALITY_NUMERIC}
 * , {@link #PASSWORD_QUALITY_NUMERIC_COMPLEX} {@link #PASSWORD_QUALITY_ALPHABETIC}, or
 * {@link #PASSWORD_QUALITY_ALPHANUMERIC} with {@link #setPasswordQuality}.
 * <p>
 * On devices not supporting {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature, the
 * password history length is always 0.
 * <p>
 * The calling device admin must have requested
 * {@link android.app.admin.DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD} to be able to call this method; if it has
 * not, a security exception will be thrown.
 * <p>
 * This method can be called on the {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance returned by
 * {@link #getParentProfileInstance(android.content.ComponentName)} in order to set restrictions on the parent
 * profile.
 *
 * <br>
 * Requires the {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param length The new desired length of password history. A value of 0 means there is no
 *            restriction.
 * @throws java.lang.SecurityException if {@code admin} is not an active administrator or {@code admin}
 *             does not use {@link android.app.admin.DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD}
 * @apiSince 11
 */

public void setPasswordHistoryLength(@androidx.annotation.NonNull android.content.ComponentName admin, int length) { throw new RuntimeException("Stub!"); }

/**
 * Called by a device admin to set the password expiration timeout. Calling this method will
 * restart the countdown for password expiration for the given admin, as will changing the
 * device password (for all admins).
 * <p>
 * The provided timeout is the time delta in ms and will be added to the current time. For
 * example, to have the password expire 5 days from now, timeout would be 5 * 86400 * 1000 =
 * 432000000 ms for timeout.
 * <p>
 * To disable password expiration, a value of 0 may be used for timeout.
 * <p>
 * On devices not supporting {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature, the
 * password expiration is always disabled.
 * <p>
 * The calling device admin must have requested
 * {@link android.app.admin.DeviceAdminInfo#USES_POLICY_EXPIRE_PASSWORD DeviceAdminInfo#USES_POLICY_EXPIRE_PASSWORD} to be able to call this method; if it has
 * not, a security exception will be thrown.
 * <p>
 * Note that setting the password will automatically reset the expiration time for all active
 * admins. Active admins do not need to explicitly call this method in that case.
 * <p>
 * This method can be called on the {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance returned by
 * {@link #getParentProfileInstance(android.content.ComponentName)} in order to set restrictions on the parent
 * profile.
 *
 * <br>
 * Requires the {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param timeout The limit (in ms) that a password can remain in effect. A value of 0 means
 *            there is no restriction (unlimited).
 * @throws java.lang.SecurityException if {@code admin} is not an active administrator or {@code admin}
 *             does not use {@link android.app.admin.DeviceAdminInfo#USES_POLICY_EXPIRE_PASSWORD DeviceAdminInfo#USES_POLICY_EXPIRE_PASSWORD}
 * @apiSince 11
 */

public void setPasswordExpirationTimeout(@androidx.annotation.NonNull android.content.ComponentName admin, long timeout) { throw new RuntimeException("Stub!"); }

/**
 * Get the password expiration timeout for the given admin. The expiration timeout is the
 * recurring expiration timeout provided in the call to
 * {@link #setPasswordExpirationTimeout(android.content.ComponentName,long)} for the given admin or the
 * aggregate of all participating policy administrators if {@code admin} is null. Admins that
 * have set restrictions on profiles that have a separate challenge are not taken into account.
 *
 * <p>This method can be called on the {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance
 * returned by {@link #getParentProfileInstance(android.content.ComponentName)} in order to retrieve
 * restrictions on the parent profile.
 *
 * <p>On devices not supporting {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature, the
 * password expiration is always disabled and this method always returns 0.
 *
 * <br>
 * Requires the {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 * @param admin The name of the admin component to check, or {@code null} to aggregate all admins.
 * This value may be {@code null}.
 * @return The timeout for the given admin or the minimum of all timeouts
 * @apiSince 11
 */

public long getPasswordExpirationTimeout(@androidx.annotation.Nullable android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Get the current password expiration time for a particular admin or all admins that set
 * restrictions on this user and its participating profiles. Restrictions on profiles that have
 * a separate challenge are not taken into account. If admin is {@code null}, then a composite
 * of all expiration times is returned - which will be the minimum of all of them.
 *
 * <p>This method can be called on the {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance
 * returned by {@link #getParentProfileInstance(android.content.ComponentName)} in order to retrieve
 * the password expiration for the parent profile.
 *
 * <p>On devices not supporting {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature, the
 * password expiration is always disabled and this method always returns 0.
 *
 * <br>
 * Requires the {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 * @param admin The name of the admin component to check, or {@code null} to aggregate all admins.
 * This value may be {@code null}.
 * @return The password expiration time, in milliseconds since epoch.
 * @apiSince 11
 */

public long getPasswordExpiration(@androidx.annotation.Nullable android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the current password history length for a particular admin or all admins that
 * set restrictions on this user and its participating profiles. Restrictions on profiles that
 * have a separate challenge are not taken into account.
 *
 * <p>This method can be called on the {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance
 * returned by {@link #getParentProfileInstance(android.content.ComponentName)} in order to retrieve
 * restrictions on the parent profile.
 *
 * <p>On devices not supporting {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature, the
 * password history length is always 0.
 *
 * <br>
 * Requires the {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 * @param admin The name of the admin component to check, or {@code null} to aggregate
 * all admins.
 * This value may be {@code null}.
 * @return The length of the password history
 * @apiSince 11
 */

public int getPasswordHistoryLength(@androidx.annotation.Nullable android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Return the maximum password length that the device supports for a
 * particular password quality.
 * <p>On devices not supporting {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature, the
 * password is always empty and this method always returns 0.
 * @param quality The quality being interrogated.
 * @return Returns the maximum length that the user can enter.
 * @apiSince 8
 */

public int getPasswordMaximumLength(int quality) { throw new RuntimeException("Stub!"); }

/**
 * Determines whether the calling user's current password meets policy requirements
 * (e.g.&nbsp;quality, minimum length). The user must be unlocked to perform this check.
 *
 * <p>Policy requirements which affect this check can be set by admins of the user, but also
 * by the admin of a managed profile associated with the calling user (when the managed profile
 * doesn't have a separate work challenge). When a managed profile has a separate work
 * challenge, its policy requirements only affect the managed profile.
 *
 * <p>Depending on the user, this method checks the policy requirement against one of the
 * following passwords:
 * <ul>
 * <li>For the primary user or secondary users: the personal keyguard password.
 * <li>For managed profiles: a work challenge if set, otherwise the parent user's personal
 *     keyguard password.
 * <ul/>
 * In other words, it's always checking the requirement against the password that is protecting
 * the calling user.
 *
 * <p>Note that this method considers all policy requirements targeting the password in
 * question. For example a profile owner might set a requirement on the parent profile i.e.
 * personal keyguard but not on the profile itself. When the device has a weak personal keyguard
 * password and no separate work challenge, calling this method will return {@code false}
 * despite the profile owner not setting a policy on the profile itself. This is because the
 * profile's current password is the personal keyguard password, and it does not meet all policy
 * requirements.
 *
 * <p>Device admins must request {@link android.app.admin.DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD} before
 * calling this method. Note, this policy type is deprecated for device admins in Android 9.0
 * (API level 28) or higher.
 *
 * <p>This method can be called on the {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance returned by
 * {@link #getParentProfileInstance(android.content.ComponentName)} in order to determine if the password set on
 * the parent profile is sufficient.
 *
 * <p>On devices not supporting {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature, the
 * password is always treated as empty - i.e. this method will always return false on such
 * devices, provided any password requirements were set.
 *
 * @return {@code true} if the password meets the policy requirements, {@code false} otherwise
 * @throws java.lang.SecurityException if the calling application isn't an active admin that uses
 *     {@link android.app.admin.DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD DeviceAdminInfo#USES_POLICY_LIMIT_PASSWORD}
 * @throws java.lang.IllegalStateException if the user isn't unlocked
 * @apiSince 8
 */

public boolean isActivePasswordSufficient() { throw new RuntimeException("Stub!"); }

/**
 * Returns how complex the current user's screen lock is.
 *
 * <p>Note that when called from a profile which uses an unified challenge with its parent, the
 * screen lock complexity of the parent will be returned. However, this API does not support
 * explicitly querying the parent profile screen lock complexity via {@link
 * #getParentProfileInstance}.
 *
 * <br>
 * Requires {@link android.Manifest.permission#REQUEST_PASSWORD_COMPLEXITY}
 * @throws java.lang.IllegalStateException if the user is not unlocked.
 * @throws java.lang.SecurityException if the calling application does not have the permission
 *                           {@link android.Manifest.permission#REQUEST_PASSWORD_COMPLEXITY permission#REQUEST_PASSWORD_COMPLEXITY}
 
 * @return Value is {@link android.app.admin.DevicePolicyManager#PASSWORD_COMPLEXITY_NONE}, {@link android.app.admin.DevicePolicyManager#PASSWORD_COMPLEXITY_LOW}, {@link android.app.admin.DevicePolicyManager#PASSWORD_COMPLEXITY_MEDIUM}, or {@link android.app.admin.DevicePolicyManager#PASSWORD_COMPLEXITY_HIGH}
 * @apiSince 29
 */

public int getPasswordComplexity() { throw new RuntimeException("Stub!"); }

/**
 * When called by a profile owner of a managed profile returns true if the profile uses unified
 * challenge with its parent user.
 *
 * <strong>Note</strong>: This method is not concerned with password quality and will return
 * false if the profile has empty password as a separate challenge.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not a profile owner of a managed profile.
 * @see android.os.UserManager#DISALLOW_UNIFIED_PASSWORD
 * @apiSince 28
 */

public boolean isUsingUnifiedPassword(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the number of times the user has failed at entering a password since that last
 * successful password entry.
 * <p>
 * This method can be called on the {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance returned by
 * {@link #getParentProfileInstance(android.content.ComponentName)} in order to retrieve the number of failed
 * password attemts for the parent user.
 * <p>
 * The calling device admin must have requested {@link android.app.admin.DeviceAdminInfo#USES_POLICY_WATCH_LOGIN DeviceAdminInfo#USES_POLICY_WATCH_LOGIN}
 * to be able to call this method; if it has not, a security exception will be thrown.
 * <p>On devices not supporting {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature, the
 * password is always empty and this method always returns 0.
 *
 * <br>
 * Requires the {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 * @return The number of times user has entered an incorrect password since the last correct
 *         password entry.
 * @throws java.lang.SecurityException if the calling application does not own an active administrator
 *             that uses {@link android.app.admin.DeviceAdminInfo#USES_POLICY_WATCH_LOGIN DeviceAdminInfo#USES_POLICY_WATCH_LOGIN}
 * @apiSince 8
 */

public int getCurrentFailedPasswordAttempts() { throw new RuntimeException("Stub!"); }

/**
 * Setting this to a value greater than zero enables a built-in policy that will perform a
 * device or profile wipe after too many incorrect device-unlock passwords have been entered.
 * This built-in policy combines watching for failed passwords and wiping the device, and
 * requires that you request both {@link android.app.admin.DeviceAdminInfo#USES_POLICY_WATCH_LOGIN DeviceAdminInfo#USES_POLICY_WATCH_LOGIN} and
 * {@link android.app.admin.DeviceAdminInfo#USES_POLICY_WIPE_DATA DeviceAdminInfo#USES_POLICY_WIPE_DATA}}.
 * <p>
 * To implement any other policy (e.g. wiping data for a particular application only, erasing or
 * revoking credentials, or reporting the failure to a server), you should implement
 * {@link android.app.admin.DeviceAdminReceiver#onPasswordFailed(android.content.Context,android.content.Intent) DeviceAdminReceiver#onPasswordFailed(Context, android.content.Intent)} instead. Do not
 * use this API, because if the maximum count is reached, the device or profile will be wiped
 * immediately, and your callback will not be invoked.
 * <p>
 * This method can be called on the {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance returned by
 * {@link #getParentProfileInstance(android.content.ComponentName)} in order to set a value on the parent
 * profile.
 * <p>On devices not supporting {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature, the
 * password is always empty and this method has no effect - i.e. the policy is not set.
 *
 * <br>
 * Requires the {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param num The number of failed password attempts at which point the device or profile will
 *            be wiped.
 * @throws java.lang.SecurityException if {@code admin} is not an active administrator or does not use
 *             both {@link android.app.admin.DeviceAdminInfo#USES_POLICY_WATCH_LOGIN DeviceAdminInfo#USES_POLICY_WATCH_LOGIN} and
 *             {@link android.app.admin.DeviceAdminInfo#USES_POLICY_WIPE_DATA DeviceAdminInfo#USES_POLICY_WIPE_DATA}.
 * @apiSince 8
 */

public void setMaximumFailedPasswordsForWipe(@androidx.annotation.NonNull android.content.ComponentName admin, int num) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the current maximum number of login attempts that are allowed before the device
 * or profile is wiped, for a particular admin or all admins that set restrictions on this user
 * and its participating profiles. Restrictions on profiles that have a separate challenge are
 * not taken into account.
 *
 * <p>This method can be called on the {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance
 * returned by {@link #getParentProfileInstance(android.content.ComponentName)} in order to retrieve
 * the value for the parent profile.
 *
 * <p>On devices not supporting {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature, the
 * password is always empty and this method returns a default value (0) indicating that the
 * policy is not set.
 *
 * <br>
 * Requires the {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 * @param admin The name of the admin component to check, or {@code null} to aggregate
 * all admins.
 
 * This value may be {@code null}.
 * @apiSince 8
 */

public int getMaximumFailedPasswordsForWipe(@androidx.annotation.Nullable android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Force a new password for device unlock (the password needed to access the entire device) or
 * the work profile challenge on the current user. This takes effect immediately.
 * <p>
 * <em>For device owner and profile owners targeting SDK level
 * {@link android.os.Build.VERSION_CODES#O} or above, this API is no longer available and will
 * throw {@link java.lang.SecurityException SecurityException}. Please use the new API {@link #resetPasswordWithToken}
 * instead. </em>
 * <p>
 * <em>Note: This API has been limited as of {@link android.os.Build.VERSION_CODES#N} for
 * device admins that are not device owner and not profile owner.
 * The password can now only be changed if there is currently no password set.  Device owner
 * and profile owner can still do this when user is unlocked and does not have a managed
 * profile.</em>
 * <p>
 * The given password must be sufficient for the current password quality and length constraints
 * as returned by {@link #getPasswordQuality(android.content.ComponentName)} and
 * {@link #getPasswordMinimumLength(android.content.ComponentName)}; if it does not meet these constraints, then
 * it will be rejected and false returned. Note that the password may be a stronger quality
 * (containing alphanumeric characters when the requested quality is only numeric), in which
 * case the currently active quality will be increased to match.
 * <p>
 * Calling with a null or empty password will clear any existing PIN, pattern or password if the
 * current password constraints allow it. <em>Note: This will not work in
 * {@link android.os.Build.VERSION_CODES#N} and later for managed profiles, or for device admins
 * that are not device owner or profile owner.  Once set, the password cannot be changed to null
 * or empty except by these admins.</em>
 * <p>On devices not supporting {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature, this
 * methods does nothing.
 * <p>
 * The calling device admin must have requested
 * {@link android.app.admin.DeviceAdminInfo#USES_POLICY_RESET_PASSWORD DeviceAdminInfo#USES_POLICY_RESET_PASSWORD} to be able to call this method; if it has
 * not, a security exception will be thrown.
 *
 * <br>
 * Requires the {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 * @param password The new password for the user. Null or empty clears the password.
 * @param flags May be 0 or combination of {@link #RESET_PASSWORD_REQUIRE_ENTRY} and
 *            {@link #RESET_PASSWORD_DO_NOT_ASK_CREDENTIALS_ON_BOOT}.
 * @return Returns true if the password was applied, or false if it is not acceptable for the
 *         current constraints or if the user has not been decrypted yet.
 * @throws java.lang.SecurityException if the calling application does not own an active administrator
 *             that uses {@link android.app.admin.DeviceAdminInfo#USES_POLICY_RESET_PASSWORD DeviceAdminInfo#USES_POLICY_RESET_PASSWORD}
 * @throws java.lang.IllegalStateException if the calling user is locked or has a managed profile.
 * @apiSince 8
 */

public boolean resetPassword(java.lang.String password, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Called by a profile or device owner to provision a token which can later be used to reset the
 * device lockscreen password (if called by device owner), or managed profile challenge (if
 * called by profile owner), via {@link #resetPasswordWithToken}.
 * <p>
 * If the user currently has a lockscreen password, the provisioned token will not be
 * immediately usable; it only becomes active after the user performs a confirm credential
 * operation, which can be triggered by {@link android.app.KeyguardManager#createConfirmDeviceCredentialIntent KeyguardManager#createConfirmDeviceCredentialIntent}.
 * If the user has no lockscreen password, the token is activated immediately. In all cases,
 * the active state of the current token can be checked by {@link #isResetPasswordTokenActive}.
 * For security reasons, un-activated tokens are only stored in memory and will be lost once
 * the device reboots. In this case a new token needs to be provisioned again.
 * <p>
 * Once provisioned and activated, the token will remain effective even if the user changes
 * or clears the lockscreen password.
 * <p>
 * <em>This token is highly sensitive and should be treated at the same level as user
 * credentials. In particular, NEVER store this token on device in plaintext. Do not store
 * the plaintext token in device-encrypted storage if it will be needed to reset password on
 * file-based encryption devices before user unlocks. Consider carefully how any password token
 * will be stored on your server and who will need access to them. Tokens may be the subject of
 * legal access requests.
 * </em>
 * <p>On devices not supporting {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature, the
 * reset token is not set and this method returns false.
 *
 * <br>
 * Requires the {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * @param token a secure token a least 32-byte long, which must be generated by a
 *        cryptographically strong random number generator.
 * @return true if the operation is successful, false otherwise.
 * @throws java.lang.SecurityException if admin is not a device or profile owner.
 * @throws java.lang.IllegalArgumentException if the supplied token is invalid.
 * @apiSince 26
 */

public boolean setResetPasswordToken(android.content.ComponentName admin, byte[] token) { throw new RuntimeException("Stub!"); }

/**
 * Called by a profile or device owner to revoke the current password reset token.
 *
 * <p>On devices not supporting {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature, this
 * method has no effect - the reset token should not have been set in the first place - and
 * false is returned.
 *
 * <br>
 * Requires the {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * @return true if the operation is successful, false otherwise.
 * @throws java.lang.SecurityException if admin is not a device or profile owner.
 * @apiSince 26
 */

public boolean clearResetPasswordToken(android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by a profile or device owner to check if the current reset password token is active.
 *
 * <p>On devices not supporting {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature,
 * false is always returned.
 *
 * <br>
 * Requires the {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * @return true if the token is active, false otherwise.
 * @throws java.lang.SecurityException if admin is not a device or profile owner.
 * @throws java.lang.IllegalStateException if no token has been set.
 * @apiSince 26
 */

public boolean isResetPasswordTokenActive(android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by device or profile owner to force set a new device unlock password or a managed
 * profile challenge on current user. This takes effect immediately.
 * <p>
 * Unlike {@link #resetPassword}, this API can change the password even before the user or
 * device is unlocked or decrypted. The supplied token must have been previously provisioned via
 * {@link #setResetPasswordToken}, and in active state {@link #isResetPasswordTokenActive}.
 * <p>
 * The given password must be sufficient for the current password quality and length constraints
 * as returned by {@link #getPasswordQuality(android.content.ComponentName)} and
 * {@link #getPasswordMinimumLength(android.content.ComponentName)}; if it does not meet these constraints, then
 * it will be rejected and false returned. Note that the password may be a stronger quality, for
 * example, a password containing alphanumeric characters when the requested quality is only
 * numeric.
 * <p>
 * Calling with a {@code null} or empty password will clear any existing PIN, pattern or
 * password if the current password constraints allow it.
 * <p>On devices not supporting {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature,
 * calling this methods has no effect - the password is always empty - and false is returned.
 *
 * <br>
 * Requires the {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param password The new password for the user. {@code null} or empty clears the password.
 * @param token the password reset token previously provisioned by
 *        {@link #setResetPasswordToken}.
 * @param flags May be 0 or combination of {@link #RESET_PASSWORD_REQUIRE_ENTRY} and
 *        {@link #RESET_PASSWORD_DO_NOT_ASK_CREDENTIALS_ON_BOOT}.
 * @return Returns true if the password was applied, or false if it is not acceptable for the
 *         current constraints.
 * @throws java.lang.SecurityException if admin is not a device or profile owner.
 * @throws java.lang.IllegalStateException if the provided token is not valid.
 * @apiSince 26
 */

public boolean resetPasswordWithToken(@androidx.annotation.NonNull android.content.ComponentName admin, java.lang.String password, byte[] token, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Called by an application that is administering the device to set the maximum time for user
 * activity until the device will lock. This limits the length that the user can set. It takes
 * effect immediately.
 * <p>
 * The calling device admin must have requested {@link android.app.admin.DeviceAdminInfo#USES_POLICY_FORCE_LOCK DeviceAdminInfo#USES_POLICY_FORCE_LOCK}
 * to be able to call this method; if it has not, a security exception will be thrown.
 * <p>
 * This method can be called on the {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance returned by
 * {@link #getParentProfileInstance(android.content.ComponentName)} in order to set restrictions on the parent
 * profile.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param timeMs The new desired maximum time to lock in milliseconds. A value of 0 means there
 *            is no restriction.
 * @throws java.lang.SecurityException if {@code admin} is not an active administrator or it does not use
 *             {@link android.app.admin.DeviceAdminInfo#USES_POLICY_FORCE_LOCK DeviceAdminInfo#USES_POLICY_FORCE_LOCK}
 * @apiSince 8
 */

public void setMaximumTimeToLock(@androidx.annotation.NonNull android.content.ComponentName admin, long timeMs) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the current maximum time to unlock for a particular admin or all admins that set
 * restrictions on this user and its participating profiles. Restrictions on profiles that have
 * a separate challenge are not taken into account.
 *
 * <p>This method can be called on the {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance
 * returned by {@link #getParentProfileInstance(android.content.ComponentName)} in order to retrieve
 * restrictions on the parent profile.
 *
 * @param admin The name of the admin component to check, or {@code null} to aggregate
 * all admins.
 * This value may be {@code null}.
 * @return time in milliseconds for the given admin or the minimum value (strictest) of
 * all admins if admin is null. Returns 0 if there are no restrictions.
 * @apiSince 8
 */

public long getMaximumTimeToLock(@androidx.annotation.Nullable android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by a device/profile owner to set the timeout after which unlocking with secondary, non
 * strong auth (e.g.&nbsp;fingerprint, face, trust agents) times out, i.e. the user has to use a
 * strong authentication method like password, pin or pattern.
 *
 * <p>This timeout is used internally to reset the timer to require strong auth again after
 * specified timeout each time it has been successfully used.
 *
 * <p>Fingerprint can also be disabled altogether using {@link #KEYGUARD_DISABLE_FINGERPRINT}.
 *
 * <p>Trust agents can also be disabled altogether using {@link #KEYGUARD_DISABLE_TRUST_AGENTS}.
 *
 * <p>The calling device admin must be a device or profile owner. If it is not,
 * a {@link java.lang.SecurityException SecurityException} will be thrown.
 *
 * <p>The calling device admin can verify the value it has set by calling
 * {@link #getRequiredStrongAuthTimeout(android.content.ComponentName)} and passing in its instance.
 *
 * <p>This method can be called on the {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance returned by
 * {@link #getParentProfileInstance(android.content.ComponentName)} in order to set restrictions on the parent
 * profile.
 *
 * <p>On devices not supporting {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature,
 * calling this methods has no effect - i.e. the timeout is not set.
 *
 * <br>
 * Requires the {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param timeoutMs The new timeout in milliseconds, after which the user will have to unlock
 *         with strong authentication method. A value of 0 means the admin is not participating
 *         in controlling the timeout.
 *         The minimum and maximum timeouts are platform-defined and are typically 1 hour and
 *         72 hours, respectively. Though discouraged, the admin may choose to require strong
 *         auth at all times using {@link #KEYGUARD_DISABLE_FINGERPRINT} and/or
 *         {@link #KEYGUARD_DISABLE_TRUST_AGENTS}.
 *
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @apiSince 26
 */

public void setRequiredStrongAuthTimeout(@androidx.annotation.NonNull android.content.ComponentName admin, long timeoutMs) { throw new RuntimeException("Stub!"); }

/**
 * Determine for how long the user will be able to use secondary, non strong auth for
 * authentication, since last strong method authentication (password, pin or pattern) was used.
 * After the returned timeout the user is required to use strong authentication method.
 *
 * <p>This method can be called on the {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance
 * returned by {@link #getParentProfileInstance(android.content.ComponentName)} in order to retrieve
 * restrictions on the parent profile.
 *
 * <p>On devices not supporting {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature,
 * 0 is returned to indicate that no timeout is configured.
 *
 * <br>
 * Requires the {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 * @param admin The name of the admin component to check, or {@code null} to aggregate
 *         across all participating admins.
 * This value may be {@code null}.
 * @return The timeout in milliseconds or 0 if not configured for the provided admin.
 * @apiSince 26
 */

public long getRequiredStrongAuthTimeout(@androidx.annotation.Nullable android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Make the device lock immediately, as if the lock screen timeout has expired at the point of
 * this call.
 * <p>
 * The calling device admin must have requested {@link android.app.admin.DeviceAdminInfo#USES_POLICY_FORCE_LOCK DeviceAdminInfo#USES_POLICY_FORCE_LOCK}
 * to be able to call this method; if it has not, a security exception will be thrown.
 * <p>
 * This method can be called on the {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance returned by
 * {@link #getParentProfileInstance(android.content.ComponentName)} in order to lock the parent profile.
 * <p>
 * Equivalent to calling {@link #lockNow(int)} with no flags.
 *
 * @throws java.lang.SecurityException if the calling application does not own an active administrator
 *             that uses {@link android.app.admin.DeviceAdminInfo#USES_POLICY_FORCE_LOCK DeviceAdminInfo#USES_POLICY_FORCE_LOCK}
 * @apiSince 8
 */

public void lockNow() { throw new RuntimeException("Stub!"); }

/**
 * Make the device lock immediately, as if the lock screen timeout has expired at the point of
 * this call.
 * <p>
 * The calling device admin must have requested {@link android.app.admin.DeviceAdminInfo#USES_POLICY_FORCE_LOCK DeviceAdminInfo#USES_POLICY_FORCE_LOCK}
 * to be able to call this method; if it has not, a security exception will be thrown.
 * <p>
 * This method can be called on the {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance returned by
 * {@link #getParentProfileInstance(android.content.ComponentName)} in order to lock the parent profile.
 *
 * @param flags May be 0 or {@link #FLAG_EVICT_CREDENTIAL_ENCRYPTION_KEY}.
 * Value is either <code>0</code> or {@link android.app.admin.DevicePolicyManager#FLAG_EVICT_CREDENTIAL_ENCRYPTION_KEY}
 * @throws java.lang.SecurityException if the calling application does not own an active administrator
 *             that uses {@link android.app.admin.DeviceAdminInfo#USES_POLICY_FORCE_LOCK DeviceAdminInfo#USES_POLICY_FORCE_LOCK} or the
 *             {@link #FLAG_EVICT_CREDENTIAL_ENCRYPTION_KEY} flag is passed by an application
 *             that is not a profile
 *             owner of a managed profile.
 * @throws java.lang.IllegalArgumentException if the {@link #FLAG_EVICT_CREDENTIAL_ENCRYPTION_KEY} flag is
 *             passed when locking the parent profile.
 * @throws java.lang.UnsupportedOperationException if the {@link #FLAG_EVICT_CREDENTIAL_ENCRYPTION_KEY}
 *             flag is passed when {@link #getStorageEncryptionStatus} does not return
 *             {@link #ENCRYPTION_STATUS_ACTIVE_PER_USER}.
 * @apiSince 26
 */

public void lockNow(int flags) { throw new RuntimeException("Stub!"); }

/**
 * Ask that all user data be wiped. If called as a secondary user, the user will be removed and
 * other users will remain unaffected. Calling from the primary user will cause the device to
 * reboot, erasing all device data - including all the secondary users and their data - while
 * booting up.
 * <p>
 * The calling device admin must have requested {@link android.app.admin.DeviceAdminInfo#USES_POLICY_WIPE_DATA DeviceAdminInfo#USES_POLICY_WIPE_DATA} to
 * be able to call this method; if it has not, a security exception will be thrown.
 *
 * @param flags Bit mask of additional options: currently supported flags are
 *            {@link #WIPE_EXTERNAL_STORAGE}, {@link #WIPE_RESET_PROTECTION_DATA},
 *            {@link #WIPE_EUICC} and {@link #WIPE_SILENTLY}.
 * @throws java.lang.SecurityException if the calling application does not own an active administrator
 *            that uses {@link android.app.admin.DeviceAdminInfo#USES_POLICY_WIPE_DATA DeviceAdminInfo#USES_POLICY_WIPE_DATA}
 * @apiSince 8
 */

public void wipeData(int flags) { throw new RuntimeException("Stub!"); }

/**
 * Ask that all user data be wiped. If called as a secondary user, the user will be removed and
 * other users will remain unaffected, the provided reason for wiping data can be shown to
 * user. Calling from the primary user will cause the device to reboot, erasing all device data
 * - including all the secondary users and their data - while booting up. In this case, we don't
 * show the reason to the user since the device would be factory reset.
 * <p>
 * The calling device admin must have requested {@link android.app.admin.DeviceAdminInfo#USES_POLICY_WIPE_DATA DeviceAdminInfo#USES_POLICY_WIPE_DATA} to
 * be able to call this method; if it has not, a security exception will be thrown.
 *
 * @param flags Bit mask of additional options: currently supported flags are
 *            {@link #WIPE_EXTERNAL_STORAGE}, {@link #WIPE_RESET_PROTECTION_DATA} and
 *            {@link #WIPE_EUICC}.
 * @param reason a string that contains the reason for wiping data, which can be
 *            presented to the user.
 * This value must never be {@code null}.
 * @throws java.lang.SecurityException if the calling application does not own an active administrator
 *            that uses {@link android.app.admin.DeviceAdminInfo#USES_POLICY_WIPE_DATA DeviceAdminInfo#USES_POLICY_WIPE_DATA}
 * @throws java.lang.IllegalArgumentException if the input reason string is null or empty, or if
 *            {@link #WIPE_SILENTLY} is set.
 * @apiSince 28
 */

public void wipeData(int flags, @androidx.annotation.NonNull java.lang.CharSequence reason) { throw new RuntimeException("Stub!"); }

/**
 * Set a network-independent global HTTP proxy. This is not normally what you want for typical
 * HTTP proxies - they are generally network dependent. However if you're doing something
 * unusual like general internal filtering this may be useful. On a private network where the
 * proxy is not accessible, you may break HTTP using this.
 * <p>
 * This method requires the caller to be the device owner.
 * <p>
 * This proxy is only a recommendation and it is possible that some apps will ignore it.
 *
 * @see android.net.ProxyInfo
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param proxyInfo The a {@link android.net.ProxyInfo ProxyInfo} object defining the new global HTTP proxy. A
 *            {@code null} value will clear the global HTTP proxy.
 * This value may be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not the device owner.
 * @apiSince 21
 */

public void setRecommendedGlobalProxy(@androidx.annotation.NonNull android.content.ComponentName admin, @androidx.annotation.Nullable android.net.ProxyInfo proxyInfo) { throw new RuntimeException("Stub!"); }

/**
 * Called by an application that is administering the device to request that the storage system
 * be encrypted. Does nothing if the caller is on a secondary user or a managed profile.
 * <p>
 * When multiple device administrators attempt to control device encryption, the most secure,
 * supported setting will always be used. If any device administrator requests device
 * encryption, it will be enabled; Conversely, if a device administrator attempts to disable
 * device encryption while another device administrator has enabled it, the call to disable will
 * fail (most commonly returning {@link #ENCRYPTION_STATUS_ACTIVE}).
 * <p>
 * This policy controls encryption of the secure (application data) storage area. Data written
 * to other storage areas may or may not be encrypted, and this policy does not require or
 * control the encryption of any other storage areas. There is one exception: If
 * {@link android.os.Environment#isExternalStorageEmulated()} is {@code true}, then the
 * directory returned by {@link android.os.Environment#getExternalStorageDirectory()} must be
 * written to disk within the encrypted storage area.
 * <p>
 * Important Note: On some devices, it is possible to encrypt storage without requiring the user
 * to create a device PIN or Password. In this case, the storage is encrypted, but the
 * encryption key may not be fully secured. For maximum security, the administrator should also
 * require (and check for) a pattern, PIN, or password.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param encrypt true to request encryption, false to release any previous request
 * @return the new total request status (for all active admins), or {@link android.app.admin.DevicePolicyManager#ENCRYPTION_STATUS_UNSUPPORTED DevicePolicyManager#ENCRYPTION_STATUS_UNSUPPORTED} if called for a non-system user.
 *         Will be one of {@link #ENCRYPTION_STATUS_UNSUPPORTED}, {@link
 *         #ENCRYPTION_STATUS_INACTIVE}, or {@link #ENCRYPTION_STATUS_ACTIVE}. This is the value
 *         of the requests; use {@link #getStorageEncryptionStatus()} to query the actual device
 *         state.
 *
 * @throws java.lang.SecurityException if {@code admin} is not an active administrator or does not use
 *             {@link android.app.admin.DeviceAdminInfo#USES_ENCRYPTED_STORAGE DeviceAdminInfo#USES_ENCRYPTED_STORAGE}
 * @apiSince 11
 */

public int setStorageEncryption(@androidx.annotation.NonNull android.content.ComponentName admin, boolean encrypt) { throw new RuntimeException("Stub!"); }

/**
 * Called by an application that is administering the device to
 * determine the requested setting for secure storage.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.  If null,
 * this will return the requested encryption setting as an aggregate of all active
 * administrators.
 * This value may be {@code null}.
 * @return true if the admin(s) are requesting encryption, false if not.
 * @apiSince 11
 */

public boolean getStorageEncryption(@androidx.annotation.Nullable android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by an application that is administering the device to
 * determine the current encryption status of the device.
 * <p>
 * Depending on the returned status code, the caller may proceed in different
 * ways.  If the result is {@link #ENCRYPTION_STATUS_UNSUPPORTED}, the
 * storage system does not support encryption.  If the
 * result is {@link #ENCRYPTION_STATUS_INACTIVE}, use {@link
 * #ACTION_START_ENCRYPTION} to begin the process of encrypting or decrypting the
 * storage.  If the result is {@link #ENCRYPTION_STATUS_ACTIVE_DEFAULT_KEY}, the
 * storage system has enabled encryption but no password is set so further action
 * may be required.  If the result is {@link #ENCRYPTION_STATUS_ACTIVATING},
 * {@link #ENCRYPTION_STATUS_ACTIVE} or {@link #ENCRYPTION_STATUS_ACTIVE_PER_USER},
 * no further action is required.
 *
 * @return current status of encryption. The value will be one of
 * {@link #ENCRYPTION_STATUS_UNSUPPORTED}, {@link #ENCRYPTION_STATUS_INACTIVE},
 * {@link #ENCRYPTION_STATUS_ACTIVATING}, {@link #ENCRYPTION_STATUS_ACTIVE_DEFAULT_KEY},
 * {@link #ENCRYPTION_STATUS_ACTIVE}, or {@link #ENCRYPTION_STATUS_ACTIVE_PER_USER}.
 * @apiSince 11
 */

public int getStorageEncryptionStatus() { throw new RuntimeException("Stub!"); }

/**
 * Installs the given certificate as a user CA.
 * <p>
 * Inserted user CAs aren't automatically trusted by apps in Android 7.0 (API level 24) and
 * higher. App developers can change the default behavior for an app by adding a
 * <a href="{@docRoot}training/articles/security-config.html">Security Configuration
 * File</a> to the app manifest file.
 *
 * The caller must be a profile or device owner on that user, or a delegate package given the
 * {@link #DELEGATION_CERT_INSTALL} scope via {@link #setDelegatedScopes}; otherwise a
 * security exception will be thrown.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with, or
 *              {@code null} if calling from a delegated certificate installer.
 * This value may be {@code null}.
 * @param certBuffer encoded form of the certificate to install.
 *
 * @return false if the certBuffer cannot be parsed or installation is
 *         interrupted, true otherwise.
 * @throws java.lang.SecurityException if {@code admin} is not {@code null} and not a device or profile
 *         owner.
 * @see #setDelegatedScopes
 * @see #DELEGATION_CERT_INSTALL
 * @apiSince 21
 */

public boolean installCaCert(@androidx.annotation.Nullable android.content.ComponentName admin, byte[] certBuffer) { throw new RuntimeException("Stub!"); }

/**
 * Uninstalls the given certificate from trusted user CAs, if present.
 *
 * The caller must be a profile or device owner on that user, or a delegate package given the
 * {@link #DELEGATION_CERT_INSTALL} scope via {@link #setDelegatedScopes}; otherwise a
 * security exception will be thrown.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with, or
 *              {@code null} if calling from a delegated certificate installer.
 * This value may be {@code null}.
 * @param certBuffer encoded form of the certificate to remove.
 * @throws java.lang.SecurityException if {@code admin} is not {@code null} and not a device or profile
 *         owner.
 * @see #setDelegatedScopes
 * @see #DELEGATION_CERT_INSTALL
 * @apiSince 21
 */

public void uninstallCaCert(@androidx.annotation.Nullable android.content.ComponentName admin, byte[] certBuffer) { throw new RuntimeException("Stub!"); }

/**
 * Returns all CA certificates that are currently trusted, excluding system CA certificates.
 * If a user has installed any certificates by other means than device policy these will be
 * included too.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with, or
 *              {@code null} if calling from a delegated certificate installer.
 * This value may be {@code null}.
 * @return a List of byte[] arrays, each encoding one user CA certificate.
 * @throws java.lang.SecurityException if {@code admin} is not {@code null} and not a device or profile
 *         owner.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.util.List<byte[]> getInstalledCaCerts(@androidx.annotation.Nullable android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Uninstalls all custom trusted CA certificates from the profile. Certificates installed by
 * means other than device policy will also be removed, except for system CA certificates.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with, or
 *              {@code null} if calling from a delegated certificate installer.
 * This value may be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not {@code null} and not a device or profile
 *         owner.
 * @apiSince 21
 */

public void uninstallAllUserCaCerts(@androidx.annotation.Nullable android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether this certificate is installed as a trusted CA.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with, or
 *              {@code null} if calling from a delegated certificate installer.
 * This value may be {@code null}.
 * @param certBuffer encoded form of the certificate to look up.
 * @throws java.lang.SecurityException if {@code admin} is not {@code null} and not a device or profile
 *         owner.
 * @apiSince 21
 */

public boolean hasCaCertInstalled(@androidx.annotation.Nullable android.content.ComponentName admin, byte[] certBuffer) { throw new RuntimeException("Stub!"); }

/**
 * Called by a device or profile owner, or delegated certificate installer, to install a
 * certificate and corresponding private key. All apps within the profile will be able to access
 * the certificate and use the private key, given direct user approval.
 *
 * <p>Access to the installed credentials will not be granted to the caller of this API without
 * direct user approval. This is for security - should a certificate installer become
 * compromised, certificates it had already installed will be protected.
 *
 * <p>If the installer must have access to the credentials, call
 * {@link #installKeyPair(android.content.ComponentName,java.security.PrivateKey,java.security.cert.Certificate[],java.lang.String,boolean)} instead.
 *
 * <p>Note: If the provided {@code alias} is of an existing alias, all former grants that apps
 * have been given to access the key and certificates associated with this alias will be
 * revoked.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with, or
 *            {@code null} if calling from a delegated certificate installer.
 * This value may be {@code null}.
 * @param privKey The private key to install.
 * This value must never be {@code null}.
 * @param cert The certificate to install.
 * This value must never be {@code null}.
 * @param alias The private key alias under which to install the certificate. If a certificate
 * with that alias already exists, it will be overwritten.
 * This value must never be {@code null}.
 * @return {@code true} if the keys were installed, {@code false} otherwise.
 * @throws java.lang.SecurityException if {@code admin} is not {@code null} and not a device or profile
 *         owner.
 * @see #setDelegatedScopes
 * @see #DELEGATION_CERT_INSTALL
 * @apiSince 21
 */

public boolean installKeyPair(@androidx.annotation.Nullable android.content.ComponentName admin, @androidx.annotation.NonNull java.security.PrivateKey privKey, @androidx.annotation.NonNull java.security.cert.Certificate cert, @androidx.annotation.NonNull java.lang.String alias) { throw new RuntimeException("Stub!"); }

/**
 * Called by a device or profile owner, or delegated certificate installer, to install a
 * certificate chain and corresponding private key for the leaf certificate. All apps within the
 * profile will be able to access the certificate chain and use the private key, given direct
 * user approval.
 *
 * <p>The caller of this API may grant itself access to the certificate and private key
 * immediately, without user approval. It is a best practice not to request this unless strictly
 * necessary since it opens up additional security vulnerabilities.
 *
 * <p>Note: If the provided {@code alias} is of an existing alias, all former grants that apps
 * have been given to access the key and certificates associated with this alias will be
 * revoked.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with, or
 *        {@code null} if calling from a delegated certificate installer.
 * This value may be {@code null}.
 * @param privKey The private key to install.
 * This value must never be {@code null}.
 * @param certs The certificate chain to install. The chain should start with the leaf
 *        certificate and include the chain of trust in order. This will be returned by
 *        {@link android.security.KeyChain#getCertificateChain}.
 * This value must never be {@code null}.
 * @param alias The private key alias under which to install the certificate. If a certificate
 *        with that alias already exists, it will be overwritten.
 * This value must never be {@code null}.
 * @param requestAccess {@code true} to request that the calling app be granted access to the
 *        credentials immediately. Otherwise, access to the credentials will be gated by user
 *        approval.
 * @return {@code true} if the keys were installed, {@code false} otherwise.
 * @throws java.lang.SecurityException if {@code admin} is not {@code null} and not a device or profile
 *         owner.
 * @see android.security.KeyChain#getCertificateChain
 * @see #setDelegatedScopes
 * @see #DELEGATION_CERT_INSTALL
 * @apiSince 24
 */

public boolean installKeyPair(@androidx.annotation.Nullable android.content.ComponentName admin, @androidx.annotation.NonNull java.security.PrivateKey privKey, @androidx.annotation.NonNull java.security.cert.Certificate[] certs, @androidx.annotation.NonNull java.lang.String alias, boolean requestAccess) { throw new RuntimeException("Stub!"); }

/**
 * Called by a device or profile owner, or delegated certificate installer, to install a
 * certificate chain and corresponding private key for the leaf certificate. All apps within the
 * profile will be able to access the certificate chain and use the private key, given direct
 * user approval (if the user is allowed to select the private key).
 *
 * <p>The caller of this API may grant itself access to the certificate and private key
 * immediately, without user approval. It is a best practice not to request this unless strictly
 * necessary since it opens up additional security vulnerabilities.
 *
 * <p>Include {@link #INSTALLKEY_SET_USER_SELECTABLE} in the {@code flags} argument to allow
 * the user to select the key from a dialog.
 *
 * <p>Note: If the provided {@code alias} is of an existing alias, all former grants that apps
 * have been given to access the key and certificates associated with this alias will be
 * revoked.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with, or
 *        {@code null} if calling from a delegated certificate installer.
 * This value may be {@code null}.
 * @param privKey The private key to install.
 * This value must never be {@code null}.
 * @param certs The certificate chain to install. The chain should start with the leaf
 *        certificate and include the chain of trust in order. This will be returned by
 *        {@link android.security.KeyChain#getCertificateChain}.
 * This value must never be {@code null}.
 * @param alias The private key alias under which to install the certificate. If a certificate
 *        with that alias already exists, it will be overwritten.
 * This value must never be {@code null}.
 * @param flags Flags to request that the calling app be granted access to the credentials
 *        and set the key to be user-selectable. See {@link #INSTALLKEY_SET_USER_SELECTABLE} and
 *        {@link #INSTALLKEY_REQUEST_CREDENTIALS_ACCESS}.
 * @return {@code true} if the keys were installed, {@code false} otherwise.
 * @throws java.lang.SecurityException if {@code admin} is not {@code null} and not a device or profile
 *         owner.
 * @see android.security.KeyChain#getCertificateChain
 * @see #setDelegatedScopes
 * @see #DELEGATION_CERT_INSTALL
 * @apiSince 28
 */

public boolean installKeyPair(@androidx.annotation.Nullable android.content.ComponentName admin, @androidx.annotation.NonNull java.security.PrivateKey privKey, @androidx.annotation.NonNull java.security.cert.Certificate[] certs, @androidx.annotation.NonNull java.lang.String alias, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Called by a device or profile owner, or delegated certificate installer, to remove a
 * certificate and private key pair installed under a given alias.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with, or
 *        {@code null} if calling from a delegated certificate installer.
 * This value may be {@code null}.
 * @param alias The private key alias under which the certificate is installed.
 * This value must never be {@code null}.
 * @return {@code true} if the private key alias no longer exists, {@code false} otherwise.
 * @throws java.lang.SecurityException if {@code admin} is not {@code null} and not a device or profile
 *         owner.
 * @see #setDelegatedScopes
 * @see #DELEGATION_CERT_INSTALL
 * @apiSince 24
 */

public boolean removeKeyPair(@androidx.annotation.Nullable android.content.ComponentName admin, @androidx.annotation.NonNull java.lang.String alias) { throw new RuntimeException("Stub!"); }

/**
 * Called by a device or profile owner, or delegated certificate installer, to generate a
 * new private/public key pair. If the device supports key generation via secure hardware,
 * this method is useful for creating a key in KeyChain that never left the secure hardware.
 * Access to the key is controlled the same way as in {@link #installKeyPair}.
 *
 * <p>Because this method might take several seconds to complete, it should only be called from
 * a worker thread. This method returns {@code null} when called from the main thread.
 *
 * <p>Note: If the provided {@code alias} is of an existing alias, all former grants that apps
 * have been given to access the key and certificates associated with this alias will be
 * revoked.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with, or
 *            {@code null} if calling from a delegated certificate installer.
 * This value may be {@code null}.
 * @param algorithm The key generation algorithm, see {@link java.security.KeyPairGenerator}.
 * This value must never be {@code null}.
 * @param keySpec Specification of the key to generate, see
 * {@link java.security.KeyPairGenerator}.
 * This value must never be {@code null}.
 * @param idAttestationFlags A bitmask of all the identifiers that should be included in the
 *        attestation record ({@code ID_TYPE_BASE_INFO}, {@code ID_TYPE_SERIAL},
 *        {@code ID_TYPE_IMEI} and {@code ID_TYPE_MEID}), or {@code 0} if no device
 *        identification is required in the attestation record.
 *        Device owner, profile owner and their delegated certificate installer can use
 *        {@link #ID_TYPE_BASE_INFO} to request inclusion of the general device information
 *        including manufacturer, model, brand, device and product in the attestation record.
 *        Only device owner and their delegated certificate installer can use
 *        {@link #ID_TYPE_SERIAL}, {@link #ID_TYPE_IMEI} and {@link #ID_TYPE_MEID} to request
 *        unique device identifiers to be attested.
 *        <p>
 *        If any of {@link #ID_TYPE_SERIAL}, {@link #ID_TYPE_IMEI} and {@link #ID_TYPE_MEID}
 *        is set, it is implicitly assumed that {@link #ID_TYPE_BASE_INFO} is also set.
 *        <p>
 *        If any flag is specified, then an attestation challenge must be included in the
 *        {@code keySpec}.
 * Value is either <code>0</code> or a combination of {@link android.app.admin.DevicePolicyManager#ID_TYPE_BASE_INFO}, {@link android.app.admin.DevicePolicyManager#ID_TYPE_SERIAL}, {@link android.app.admin.DevicePolicyManager#ID_TYPE_IMEI}, and {@link android.app.admin.DevicePolicyManager#ID_TYPE_MEID}
 * @return A non-null {@code AttestedKeyPair} if the key generation succeeded, null otherwise.
 * @throws java.lang.SecurityException if {@code admin} is not {@code null} and not a device or profile
 *         owner. If Device ID attestation is requested (using {@link #ID_TYPE_SERIAL},
 *         {@link #ID_TYPE_IMEI} or {@link #ID_TYPE_MEID}), the caller must be the Device Owner
 *         or the Certificate Installer delegate.
 * @throws java.lang.IllegalArgumentException if the alias in {@code keySpec} is empty, if the
 *         algorithm specification in {@code keySpec} is not {@code RSAKeyGenParameterSpec}
 *         or {@code ECGenParameterSpec}, or if Device ID attestation was requested but the
 *         {@code keySpec} does not contain an attestation challenge.
 * @throws java.lang.UnsupportedOperationException if Device ID attestation was requested but the
 *         underlying hardware does not support it.
 * @throws android.security.keystore.StrongBoxUnavailableException if the use of StrongBox for key generation was
 *         specified in {@code keySpec} but the device does not have one.
 * @see android.security.keystore.KeyGenParameterSpec.Builder#setAttestationChallenge(byte[])
 * @apiSince 28
 */

public android.security.AttestedKeyPair generateKeyPair(@androidx.annotation.Nullable android.content.ComponentName admin, @androidx.annotation.NonNull java.lang.String algorithm, @androidx.annotation.NonNull android.security.keystore.KeyGenParameterSpec keySpec, int idAttestationFlags) { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the device supports attestation of device identifiers in addition
 * to key attestation.
 * @return {@code true} if Device ID attestation is supported.
 * @apiSince 28
 */

public boolean isDeviceIdAttestationSupported() { throw new RuntimeException("Stub!"); }

/**
 * Called by a device or profile owner, or delegated certificate installer, to associate
 * certificates with a key pair that was generated using {@link #generateKeyPair}, and
 * set whether the key is available for the user to choose in the certificate selection
 * prompt.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with, or
 *            {@code null} if calling from a delegated certificate installer.
 * This value may be {@code null}.
 * @param alias The private key alias under which to install the certificate. The {@code alias}
 *        should denote an existing private key. If a certificate with that alias already
 *        exists, it will be overwritten.
 * This value must never be {@code null}.
 * @param certs The certificate chain to install. The chain should start with the leaf
 *        certificate and include the chain of trust in order. This will be returned by
 *        {@link android.security.KeyChain#getCertificateChain}.
 * This value must never be {@code null}.
 * @param isUserSelectable {@code true} to indicate that a user can select this key via the
 *        certificate selection prompt, {@code false} to indicate that this key can only be
 *        granted access by implementing
 *        {@link android.app.admin.DeviceAdminReceiver#onChoosePrivateKeyAlias}.
 * @return {@code true} if the provided {@code alias} exists and the certificates has been
 *        successfully associated with it, {@code false} otherwise.
 * @throws java.lang.SecurityException if {@code admin} is not {@code null} and not a device or profile
 *         owner, or {@code admin} is null but the calling application is not a delegated
 *         certificate installer.
 * @apiSince 28
 */

public boolean setKeyPairCertificate(@androidx.annotation.Nullable android.content.ComponentName admin, @androidx.annotation.NonNull java.lang.String alias, @androidx.annotation.NonNull java.util.List<java.security.cert.Certificate> certs, boolean isUserSelectable) { throw new RuntimeException("Stub!"); }

/**
 * Called by a profile owner or device owner to grant access to privileged certificate
 * manipulation APIs to a third-party certificate installer app. Granted APIs include
 * {@link #getInstalledCaCerts}, {@link #hasCaCertInstalled}, {@link #installCaCert},
 * {@link #uninstallCaCert}, {@link #uninstallAllUserCaCerts} and {@link #installKeyPair}.
 * <p>
 * Delegated certificate installer is a per-user state. The delegated access is persistent until
 * it is later cleared by calling this method with a null value or uninstallling the certificate
 * installer.
 * <p>
 * <b>Note:</b>Starting from {@link android.os.Build.VERSION_CODES#N}, if the caller
 * application's target SDK version is {@link android.os.Build.VERSION_CODES#N} or newer, the
 * supplied certificate installer package must be installed when calling this API, otherwise an
 * {@link java.lang.IllegalArgumentException IllegalArgumentException} will be thrown.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param installerPackage The package name of the certificate installer which will be given
 *            access. If {@code null} is given the current package will be cleared.
 * This value may be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not a device or a profile owner.
 *
 * @deprecated From {@link android.os.Build.VERSION_CODES#O}. Use {@link #setDelegatedScopes}
 * with the {@link #DELEGATION_CERT_INSTALL} scope instead.
 * @apiSince 23
 * @deprecatedSince 26
 */

@Deprecated
public void setCertInstallerPackage(@androidx.annotation.NonNull android.content.ComponentName admin, @androidx.annotation.Nullable java.lang.String installerPackage) throws java.lang.SecurityException { throw new RuntimeException("Stub!"); }

/**
 * Called by a profile owner or device owner to retrieve the certificate installer for the user,
 * or {@code null} if none is set. If there are multiple delegates this function will return one
 * of them.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @return The package name of the current delegated certificate installer, or {@code null} if
 *         none is set.
 * @throws java.lang.SecurityException if {@code admin} is not a device or a profile owner.
 *
 * @deprecated From {@link android.os.Build.VERSION_CODES#O}. Use {@link #getDelegatePackages}
 * with the {@link #DELEGATION_CERT_INSTALL} scope instead.
 * @apiSince 23
 * @deprecatedSince 26
 */

@Deprecated
@androidx.annotation.Nullable
public java.lang.String getCertInstallerPackage(@androidx.annotation.NonNull android.content.ComponentName admin) throws java.lang.SecurityException { throw new RuntimeException("Stub!"); }

/**
 * Called by a profile owner or device owner to grant access to privileged APIs to another app.
 * Granted APIs are determined by {@code scopes}, which is a list of the {@code DELEGATION_*}
 * constants.
 * <p>
 * A broadcast with the {@link #ACTION_APPLICATION_DELEGATION_SCOPES_CHANGED} action will be
 * sent to the {@code delegatePackage} with its new scopes in an {@code ArrayList<String>} extra
 * under the {@link #EXTRA_DELEGATION_SCOPES} key. The broadcast is sent with the
 * {@link android.content.Intent#FLAG_RECEIVER_REGISTERED_ONLY Intent#FLAG_RECEIVER_REGISTERED_ONLY} flag.
 * <p>
 * Delegated scopes are a per-user state. The delegated access is persistent until it is later
 * cleared by calling this method with an empty {@code scopes} list or uninstalling the
 * {@code delegatePackage}.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param delegatePackage The package name of the app which will be given access.
 * This value must never be {@code null}.
 * @param scopes The groups of privileged APIs whose access should be granted to
 *            {@code delegatedPackage}.
 * This value must never be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not a device or a profile owner.
 * @apiSince 26
 */

public void setDelegatedScopes(@androidx.annotation.NonNull android.content.ComponentName admin, @androidx.annotation.NonNull java.lang.String delegatePackage, @androidx.annotation.NonNull java.util.List<java.lang.String> scopes) { throw new RuntimeException("Stub!"); }

/**
 * Called by a profile owner or device owner to retrieve a list of the scopes given to a
 * delegate package. Other apps can use this method to retrieve their own delegated scopes by
 * passing {@code null} for {@code admin} and their own package name as
 * {@code delegatedPackage}.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with, or
 *            {@code null} if the caller is {@code delegatedPackage}.
 * This value may be {@code null}.
 * @param delegatedPackage The package name of the app whose scopes should be retrieved.
 * This value must never be {@code null}.
 * @return A list containing the scopes given to {@code delegatedPackage}.
 * @throws java.lang.SecurityException if {@code admin} is not a device or a profile owner.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public java.util.List<java.lang.String> getDelegatedScopes(@androidx.annotation.Nullable android.content.ComponentName admin, @androidx.annotation.NonNull java.lang.String delegatedPackage) { throw new RuntimeException("Stub!"); }

/**
 * Called by a profile owner or device owner to retrieve a list of delegate packages that were
 * granted a delegation scope.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param delegationScope The scope whose delegates should be retrieved.
 * This value must never be {@code null}.
 * @return A list of package names of the current delegated packages for
       {@code delegationScope}.
 * This value may be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not a device or a profile owner.
 * @apiSince 26
 */

@androidx.annotation.Nullable
public java.util.List<java.lang.String> getDelegatePackages(@androidx.annotation.NonNull android.content.ComponentName admin, @androidx.annotation.NonNull java.lang.String delegationScope) { throw new RuntimeException("Stub!"); }

/**
 * Called by a device or profile owner to configure an always-on VPN connection through a
 * specific application for the current user. This connection is automatically granted and
 * persisted after a reboot.
 * <p> To support the always-on feature, an app must
 * <ul>
 *     <li>declare a {@link android.net.VpnService} in its manifest, guarded by
 *         {@link android.Manifest.permission#BIND_VPN_SERVICE};</li>
 *     <li>target {@link android.os.Build.VERSION_CODES#N API 24} or above; and</li>
 *     <li><i>not</i> explicitly opt out of the feature through
 *         {@link android.net.VpnService#SERVICE_META_DATA_SUPPORTS_ALWAYS_ON}.</li>
 * </ul>
 * The call will fail if called with the package name of an unsupported VPN app.
 * <p> Enabling lockdown via {@code lockdownEnabled} argument carries the risk that any failure
 * of the VPN provider could break networking for all apps. This method clears any lockdown
 * whitelist set by {@link #setAlwaysOnVpnPackage(android.content.ComponentName,java.lang.String,boolean,java.util.Set)}.
 *
 * @param vpnPackage The package name for an installed VPN app on the device, or {@code null} to
 *        remove an existing always-on VPN configuration.
 * This value may be {@code null}.
 * @param lockdownEnabled {@code true} to disallow networking when the VPN is not connected or
 *        {@code false} otherwise. This has no effect when clearing.
 * @throws java.lang.SecurityException if {@code admin} is not a device or a profile owner.
 * @throws android.content.pm.PackageManager.NameNotFoundException if {@code vpnPackage} is not installed.
 * @throws java.lang.UnsupportedOperationException if {@code vpnPackage} exists but does not support being
 *         set as always-on, or if always-on VPN is not available.
 * @see #setAlwaysOnVpnPackage(ComponentName, String, boolean, Set)
 
 * @param admin This value must never be {@code null}.
 * @apiSince 24
 */

public void setAlwaysOnVpnPackage(@androidx.annotation.NonNull android.content.ComponentName admin, @androidx.annotation.Nullable java.lang.String vpnPackage, boolean lockdownEnabled) throws android.content.pm.PackageManager.NameNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * A version of {@link #setAlwaysOnVpnPackage(android.content.ComponentName,java.lang.String,boolean)} that allows the
 * admin to specify a set of apps that should be able to access the network directly when VPN
 * is not connected. When VPN connects these apps switch over to VPN if allowed to use that VPN.
 * System apps can always bypass VPN.
 * <p> Note that the system doesn't update the whitelist when packages are installed or
 * uninstalled, the admin app must call this method to keep the list up to date.
 * <p> When {@code lockdownEnabled} is false {@code lockdownWhitelist} is ignored . When
 * {@code lockdownEnabled} is {@code true} and {@code lockdownWhitelist} is {@code null} or
 * empty, only system apps can bypass VPN.
 * <p> Setting always-on VPN package to {@code null} or using
 * {@link #setAlwaysOnVpnPackage(android.content.ComponentName,java.lang.String,boolean)} clears lockdown whitelist.
 *
 * @param vpnPackage package name for an installed VPN app on the device, or {@code null}
 *         to remove an existing always-on VPN configuration
 * This value may be {@code null}.
 * @param lockdownEnabled {@code true} to disallow networking when the VPN is not connected or
 *         {@code false} otherwise. This has no effect when clearing.
 * @param lockdownWhitelist Packages that will be able to access the network directly when VPN
 *         is in lockdown mode but not connected. Has no effect when clearing.
 * This value may be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not a device or a profile
 *         owner.
 * @throws android.content.pm.PackageManager.NameNotFoundException if {@code vpnPackage} or one of
 *         {@code lockdownWhitelist} is not installed.
 * @throws java.lang.UnsupportedOperationException if {@code vpnPackage} exists but does
 *         not support being set as always-on, or if always-on VPN is not
 *         available.
 
 * @param admin This value must never be {@code null}.
 * @apiSince 29
 */

public void setAlwaysOnVpnPackage(@androidx.annotation.NonNull android.content.ComponentName admin, @androidx.annotation.Nullable java.lang.String vpnPackage, boolean lockdownEnabled, @androidx.annotation.Nullable java.util.Set<java.lang.String> lockdownWhitelist) throws android.content.pm.PackageManager.NameNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Called by device or profile owner to query whether current always-on VPN is configured in
 * lockdown mode. Returns {@code false} when no always-on configuration is set.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 *
 * This value must never be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not a device or a profile owner.
 *
 * @see #setAlwaysOnVpnPackage(ComponentName, String, boolean)
 * @apiSince 29
 */

public boolean isAlwaysOnVpnLockdownEnabled(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by device or profile owner to query the set of packages that are allowed to access
 * the network directly when always-on VPN is in lockdown mode but not connected. Returns
 * {@code null} when always-on VPN is not active or not in lockdown mode.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 *
 * This value must never be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not a device or a profile owner.
 *
 * @see #setAlwaysOnVpnPackage(ComponentName, String, boolean, Set)
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.util.Set<java.lang.String> getAlwaysOnVpnLockdownWhitelist(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by a device or profile owner to read the name of the package administering an
 * always-on VPN connection for the current user. If there is no such package, or the always-on
 * VPN is provided by the system instead of by an application, {@code null} will be returned.
 *
 * @param admin This value must never be {@code null}.
 * @return Package name of VPN controller responsible for always-on VPN, or {@code null} if none
 *         is set.
 * @throws java.lang.SecurityException if {@code admin} is not a device or a profile owner.
 * @apiSince 24
 */

@androidx.annotation.Nullable
public java.lang.String getAlwaysOnVpnPackage(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by an application that is administering the device to disable all cameras on the
 * device, for this user. After setting this, no applications running as this user will be able
 * to access any cameras on the device.
 * <p>
 * If the caller is device owner, then the restriction will be applied to all users.
 * <p>
 * The calling device admin must have requested
 * {@link android.app.admin.DeviceAdminInfo#USES_POLICY_DISABLE_CAMERA DeviceAdminInfo#USES_POLICY_DISABLE_CAMERA} to be able to call this method; if it has
 * not, a security exception will be thrown.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param disabled Whether or not the camera should be disabled.
 * @throws java.lang.SecurityException if {@code admin} is not an active administrator or does not use
 *             {@link android.app.admin.DeviceAdminInfo#USES_POLICY_DISABLE_CAMERA DeviceAdminInfo#USES_POLICY_DISABLE_CAMERA}.
 * @apiSince 14
 */

public void setCameraDisabled(@androidx.annotation.NonNull android.content.ComponentName admin, boolean disabled) { throw new RuntimeException("Stub!"); }

/**
 * Determine whether or not the device's cameras have been disabled for this user,
 * either by the calling admin, if specified, or all admins.
 * @param admin The name of the admin component to check, or {@code null} to check whether any admins
 * have disabled the camera
 
 * This value may be {@code null}.
 * @apiSince 14
 */

public boolean getCameraDisabled(@androidx.annotation.Nullable android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by a device owner to request a bugreport.
 * <p>
 * If the device contains secondary users or profiles, they must be affiliated with the device.
 * Otherwise a {@link java.lang.SecurityException SecurityException} will be thrown. See {@link #isAffiliatedUser}.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @return {@code true} if the bugreport collection started successfully, or {@code false} if it
 *         wasn't triggered because a previous bugreport operation is still active (either the
 *         bugreport is still running or waiting for the user to share or decline)
 * @throws java.lang.SecurityException if {@code admin} is not a device owner, or there is at least one
 *         profile or secondary user that is not affiliated with the device.
 * @see #isAffiliatedUser
 * @apiSince 24
 */

public boolean requestBugreport(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by a device/profile owner to set whether the screen capture is disabled. Disabling
 * screen capture also prevents the content from being shown on display devices that do not have
 * a secure video output. See {@link android.view.Display#FLAG_SECURE} for more details about
 * secure surfaces and secure displays.
 * <p>
 * The calling device admin must be a device or profile owner. If it is not, a security
 * exception will be thrown.
 * <p>
 * From version {@link android.os.Build.VERSION_CODES#M} disabling screen capture also blocks
 * assist requests for all activities of the relevant user.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param disabled Whether screen capture is disabled or not.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @apiSince 21
 */

public void setScreenCaptureDisabled(@androidx.annotation.NonNull android.content.ComponentName admin, boolean disabled) { throw new RuntimeException("Stub!"); }

/**
 * Determine whether or not screen capture has been disabled by the calling
 * admin, if specified, or all admins.
 * @param admin The name of the admin component to check, or {@code null} to check whether any admins
 * have disabled screen capture.
 
 * This value may be {@code null}.
 * @apiSince 21
 */

public boolean getScreenCaptureDisabled(@androidx.annotation.Nullable android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by a device owner, or alternatively a profile owner from Android 8.0 (API level 26) or
 * higher, to set whether auto time is required. If auto time is required, no user will be able
 * set the date and time and network date and time will be used.
 * <p>
 * Note: if auto time is required the user can still manually set the time zone.
 * <p>
 * The calling device admin must be a device owner, or alternatively a profile owner from
 * Android 8.0 (API level 26) or higher. If it is not, a security exception will be thrown.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param required Whether auto time is set required or not.
 * @throws java.lang.SecurityException if {@code admin} is not a device owner.
 * @apiSince 21
 */

public void setAutoTimeRequired(@androidx.annotation.NonNull android.content.ComponentName admin, boolean required) { throw new RuntimeException("Stub!"); }

/**
 * @return true if auto time is required.
 * @apiSince 21
 */

public boolean getAutoTimeRequired() { throw new RuntimeException("Stub!"); }

/**
 * Called by an application that is administering the device to disable keyguard customizations,
 * such as widgets. After setting this, keyguard features will be disabled according to the
 * provided feature list.
 * <p>
 * The calling device admin must have requested
 * {@link android.app.admin.DeviceAdminInfo#USES_POLICY_DISABLE_KEYGUARD_FEATURES DeviceAdminInfo#USES_POLICY_DISABLE_KEYGUARD_FEATURES} to be able to call this method;
 * if it has not, a security exception will be thrown.
 * <p>
 * Calling this from a managed profile before version {@link android.os.Build.VERSION_CODES#M}
 * will throw a security exception. From version {@link android.os.Build.VERSION_CODES#M} the
 * profile owner of a managed profile can set:
 * <ul>
 * <li>{@link #KEYGUARD_DISABLE_TRUST_AGENTS}, which affects the parent user, but only if there
 * is no separate challenge set on the managed profile.
 * <li>{@link #KEYGUARD_DISABLE_FINGERPRINT}, {@link #KEYGUARD_DISABLE_FACE} or
 * {@link #KEYGUARD_DISABLE_IRIS} which affects the managed profile challenge if
 * there is one, or the parent user otherwise.
 * <li>{@link #KEYGUARD_DISABLE_UNREDACTED_NOTIFICATIONS} which affects notifications generated
 * by applications in the managed profile.
 * </ul>
 * {@link #KEYGUARD_DISABLE_TRUST_AGENTS}, {@link #KEYGUARD_DISABLE_FINGERPRINT},
 * {@link #KEYGUARD_DISABLE_FACE} and {@link #KEYGUARD_DISABLE_IRIS} can also be
 * set on the {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance returned by
 * {@link #getParentProfileInstance(android.content.ComponentName)} in order to set restrictions on the parent
 * profile.
 * <p>
 * Requests to disable other features on a managed profile will be ignored.
 * <p>
 * The admin can check which features have been disabled by calling
 * {@link #getKeyguardDisabledFeatures(android.content.ComponentName)}
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param which The disabled features flag which can be either
 *            {@link #KEYGUARD_DISABLE_FEATURES_NONE} (default),
 *            {@link #KEYGUARD_DISABLE_FEATURES_ALL}, or a combination of
 *            {@link #KEYGUARD_DISABLE_WIDGETS_ALL}, {@link #KEYGUARD_DISABLE_SECURE_CAMERA},
 *            {@link #KEYGUARD_DISABLE_SECURE_NOTIFICATIONS},
 *            {@link #KEYGUARD_DISABLE_TRUST_AGENTS},
 *            {@link #KEYGUARD_DISABLE_UNREDACTED_NOTIFICATIONS},
 *            {@link #KEYGUARD_DISABLE_FINGERPRINT},
 *            {@link #KEYGUARD_DISABLE_FACE},
 *            {@link #KEYGUARD_DISABLE_IRIS}.
 * @throws java.lang.SecurityException if {@code admin} is not an active administrator or does not user
 *             {@link android.app.admin.DeviceAdminInfo#USES_POLICY_DISABLE_KEYGUARD_FEATURES DeviceAdminInfo#USES_POLICY_DISABLE_KEYGUARD_FEATURES}
 * @apiSince 17
 */

public void setKeyguardDisabledFeatures(@androidx.annotation.NonNull android.content.ComponentName admin, int which) { throw new RuntimeException("Stub!"); }

/**
 * Determine whether or not features have been disabled in keyguard either by the calling
 * admin, if specified, or all admins that set restrictions on this user and its participating
 * profiles. Restrictions on profiles that have a separate challenge are not taken into account.
 *
 * <p>This method can be called on the {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance
 * returned by {@link #getParentProfileInstance(android.content.ComponentName)} in order to retrieve
 * restrictions on the parent profile.
 *
 * @param admin The name of the admin component to check, or {@code null} to check whether any
 * admins have disabled features in keyguard.
 * This value may be {@code null}.
 * @return bitfield of flags. See {@link #setKeyguardDisabledFeatures(android.content.ComponentName,int)}
 * for a list.
 * @apiSince 17
 */

public int getKeyguardDisabledFeatures(@androidx.annotation.Nullable android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Used to determine if a particular package has been registered as a Device Owner app.
 * A device owner app is a special device admin that cannot be deactivated by the user, once
 * activated as a device admin. It also cannot be uninstalled. To check whether a particular
 * package is currently registered as the device owner app, pass in the package name from
 * {@link android.content.Context#getPackageName() Context#getPackageName()} to this method.<p/>This is useful for device
 * admin apps that want to check whether they are also registered as the device owner app. The
 * exact mechanism by which a device admin app is registered as a device owner app is defined by
 * the setup process.
 * @param packageName the package name of the app, to compare with the registered device owner
 * app, if any.
 * @return whether or not the package is registered as the device owner app.
 * @apiSince 18
 */

public boolean isDeviceOwnerApp(java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * Clears the current device owner. The caller must be the device owner. This function should be
 * used cautiously as once it is called it cannot be undone. The device owner can only be set as
 * a part of device setup, before it completes.
 * <p>
 * While some policies previously set by the device owner will be cleared by this method, it is
 * a best-effort process and some other policies will still remain in place after the device
 * owner is cleared.
 *
 * @param packageName The package name of the device owner.
 * @throws java.lang.SecurityException if the caller is not in {@code packageName} or {@code packageName}
 *             does not own the current device owner component.
 *
 * @deprecated This method is expected to be used for testing purposes only. The device owner
 * will lose control of the device and its data after calling it. In order to protect any
 * sensitive data that remains on the device, it is advised that the device owner factory resets
 * the device instead of calling this method. See {@link #wipeData(int)}.
 * @apiSince 21
 * @deprecatedSince 26
 */

@Deprecated
public void clearDeviceOwnerApp(java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * Clears the active profile owner. The caller must be the profile owner of this user, otherwise
 * a SecurityException will be thrown. This method is not available to managed profile owners.
 * <p>
 * While some policies previously set by the profile owner will be cleared by this method, it is
 * a best-effort process and some other policies will still remain in place after the profile
 * owner is cleared.
 *
 * @param admin The component to remove as the profile owner.
 * This value must never be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not an active profile owner, or the method is
 * being called from a managed profile.
 *
 * @deprecated This method is expected to be used for testing purposes only. The profile owner
 * will lose control of the user and its data after calling it. In order to protect any
 * sensitive data that remains on this user, it is advised that the profile owner deletes it
 * instead of calling this method. See {@link #wipeData(int)}.
 * @apiSince 24
 * @deprecatedSince 26
 */

@Deprecated
public void clearProfileOwner(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Sets the device owner information to be shown on the lock screen.
 * <p>
 * If the device owner information is {@code null} or empty then the device owner info is
 * cleared and the user owner info is shown on the lock screen if it is set.
 * <p>
 * If the device owner information contains only whitespaces then the message on the lock screen
 * will be blank and the user will not be allowed to change it.
 * <p>
 * If the device owner information needs to be localized, it is the responsibility of the
 * {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} to listen to the {@link android.content.Intent#ACTION_LOCALE_CHANGED Intent#ACTION_LOCALE_CHANGED} broadcast
 * and set a new version of this string accordingly.
 *
 * @param admin The name of the admin component to check.
 * This value must never be {@code null}.
 * @param info Device owner information which will be displayed instead of the user owner info.
 * @throws java.lang.SecurityException if {@code admin} is not a device owner.
 * @apiSince 24
 */

public void setDeviceOwnerLockScreenInfo(@androidx.annotation.NonNull android.content.ComponentName admin, java.lang.CharSequence info) { throw new RuntimeException("Stub!"); }

/**
 * @return The device owner information. If it is not set returns {@code null}.
 * @apiSince 24
 */

public java.lang.CharSequence getDeviceOwnerLockScreenInfo() { throw new RuntimeException("Stub!"); }

/**
 * Called by device or profile owners to suspend packages for this user. This function can be
 * called by a device owner, profile owner, or by a delegate given the
 * {@link #DELEGATION_PACKAGE_ACCESS} scope via {@link #setDelegatedScopes}.
 * <p>
 * A suspended package will not be able to start activities. Its notifications will be hidden,
 * it will not show up in recents, will not be able to show toasts or dialogs or ring the
 * device.
 * <p>
 * The package must already be installed. If the package is uninstalled while suspended the
 * package will no longer be suspended. The admin can block this by using
 * {@link #setUninstallBlocked}.
 *
 * @param admin The name of the admin component to check, or {@code null} if the caller is a
 *            package access delegate.
 * This value must never be {@code null}.
 * @param packageNames The package names to suspend or unsuspend.
 * This value must never be {@code null}.
 * @param suspended If set to {@code true} than the packages will be suspended, if set to
 *            {@code false} the packages will be unsuspended.
 * @return an array of package names for which the suspended status is not set as requested in
 *         this method.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @see #setDelegatedScopes
 * @see #DELEGATION_PACKAGE_ACCESS
 * @apiSince 24
 */

@androidx.annotation.NonNull
public java.lang.String[] setPackagesSuspended(@androidx.annotation.NonNull android.content.ComponentName admin, @androidx.annotation.NonNull java.lang.String[] packageNames, boolean suspended) { throw new RuntimeException("Stub!"); }

/**
 * Determine if a package is suspended. This function can be called by a device owner, profile
 * owner, or by a delegate given the {@link #DELEGATION_PACKAGE_ACCESS} scope via
 * {@link #setDelegatedScopes}.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with, or
 *            {@code null} if the caller is a package access delegate.
 * This value must never be {@code null}.
 * @param packageName The name of the package to retrieve the suspended status of.
 * @return {@code true} if the package is suspended or {@code false} if the package is not
 *         suspended, could not be found or an error occurred.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @throws android.content.pm.PackageManager.NameNotFoundException if the package could not be found.
 * @see #setDelegatedScopes
 * @see #DELEGATION_PACKAGE_ACCESS
 * @apiSince 24
 */

public boolean isPackageSuspended(@androidx.annotation.NonNull android.content.ComponentName admin, java.lang.String packageName) throws android.content.pm.PackageManager.NameNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Sets the enabled state of the profile. A profile should be enabled only once it is ready to
 * be used. Only the profile owner can call this.
 *
 * @see #isProfileOwnerApp
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not a profile owner.
 * @apiSince 21
 */

public void setProfileEnabled(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Sets the name of the profile. In the device owner case it sets the name of the user which it
 * is called from. Only a profile owner or device owner can call this. If this is never called
 * by the profile or device owner, the name will be set to default values.
 *
 * @see #isProfileOwnerApp
 * @see #isDeviceOwnerApp
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associate with.
 * This value must never be {@code null}.
 * @param profileName The name of the profile.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @apiSince 21
 */

public void setProfileName(@androidx.annotation.NonNull android.content.ComponentName admin, java.lang.String profileName) { throw new RuntimeException("Stub!"); }

/**
 * Used to determine if a particular package is registered as the profile owner for the
 * user. A profile owner is a special device admin that has additional privileges
 * within the profile.
 *
 * @param packageName The package name of the app to compare with the registered profile owner.
 * @return Whether or not the package is registered as the profile owner.
 * @apiSince 21
 */

public boolean isProfileOwnerApp(java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * Called by a profile owner or device owner to set a default activity that the system selects
 * to handle intents that match the given {@link android.content.IntentFilter IntentFilter}. This activity will remain the
 * default intent handler even if the set of potential event handlers for the intent filter
 * changes and if the intent preferences are reset.
 * <p>
 * Note that the caller should still declare the activity in the manifest, the API just sets
 * the activity to be the default one to handle the given intent filter.
 * <p>
 * The default disambiguation mechanism takes over if the activity is not installed (anymore).
 * When the activity is (re)installed, it is automatically reset as default intent handler for
 * the filter.
 * <p>
 * The calling device admin must be a profile owner or device owner. If it is not, a security
 * exception will be thrown.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param filter The IntentFilter for which a default handler is added.
 * @param activity The Activity that is added as default intent handler.
 * This value must never be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @apiSince 21
 */

public void addPersistentPreferredActivity(@androidx.annotation.NonNull android.content.ComponentName admin, android.content.IntentFilter filter, @androidx.annotation.NonNull android.content.ComponentName activity) { throw new RuntimeException("Stub!"); }

/**
 * Called by a profile owner or device owner to remove all persistent intent handler preferences
 * associated with the given package that were set by {@link #addPersistentPreferredActivity}.
 * <p>
 * The calling device admin must be a profile owner. If it is not, a security exception will be
 * thrown.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param packageName The name of the package for which preferences are removed.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @apiSince 21
 */

public void clearPackagePersistentPreferredActivities(@androidx.annotation.NonNull android.content.ComponentName admin, java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * Called by a device owner to set the default SMS application.
 * <p>
 * The calling device admin must be a device owner. If it is not, a security exception will be
 * thrown.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param packageName The name of the package to set as the default SMS application.
 * This value must never be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not a device owner.
 * @apiSince 29
 */

public void setDefaultSmsApplication(@androidx.annotation.NonNull android.content.ComponentName admin, @androidx.annotation.NonNull java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * Called by a profile owner or device owner to grant permission to a package to manage
 * application restrictions for the calling user via {@link #setApplicationRestrictions} and
 * {@link #getApplicationRestrictions}.
 * <p>
 * This permission is persistent until it is later cleared by calling this method with a
 * {@code null} value or uninstalling the managing package.
 * <p>
 * The supplied application restriction managing package must be installed when calling this
 * API, otherwise an {@link android.content.pm.PackageManager.NameNotFoundException NameNotFoundException} will be thrown.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param packageName The package name which will be given access to application restrictions
 *            APIs. If {@code null} is given the current package will be cleared.
 * This value may be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @throws android.content.pm.PackageManager.NameNotFoundException if {@code packageName} is not found
 *
 * @deprecated From {@link android.os.Build.VERSION_CODES#O}. Use {@link #setDelegatedScopes}
 * with the {@link #DELEGATION_APP_RESTRICTIONS} scope instead.
 * @apiSince 24
 * @deprecatedSince 26
 */

@Deprecated
public void setApplicationRestrictionsManagingPackage(@androidx.annotation.NonNull android.content.ComponentName admin, @androidx.annotation.Nullable java.lang.String packageName) throws android.content.pm.PackageManager.NameNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Called by a profile owner or device owner to retrieve the application restrictions managing
 * package for the current user, or {@code null} if none is set. If there are multiple
 * delegates this function will return one of them.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @return The package name allowed to manage application restrictions on the current user, or
 *         {@code null} if none is set.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 *
 * @deprecated From {@link android.os.Build.VERSION_CODES#O}. Use {@link #getDelegatePackages}
 * with the {@link #DELEGATION_APP_RESTRICTIONS} scope instead.
 * @apiSince 24
 * @deprecatedSince 26
 */

@Deprecated
@androidx.annotation.Nullable
public java.lang.String getApplicationRestrictionsManagingPackage(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by any application to find out whether it has been granted permission via
 * {@link #setApplicationRestrictionsManagingPackage} to manage application restrictions
 * for the calling user.
 *
 * <p>This is done by comparing the calling Linux uid with the uid of the package specified by
 * that method.
 *
 * @deprecated From {@link android.os.Build.VERSION_CODES#O}. Use {@link #getDelegatedScopes}
 * instead.
 * @apiSince 24
 * @deprecatedSince 26
 */

@Deprecated
public boolean isCallerApplicationRestrictionsManagingPackage() { throw new RuntimeException("Stub!"); }

/**
 * Sets the application restrictions for a given target application running in the calling user.
 * <p>
 * The caller must be a profile or device owner on that user, or the package allowed to manage
 * application restrictions via {@link #setDelegatedScopes} with the
 * {@link #DELEGATION_APP_RESTRICTIONS} scope; otherwise a security exception will be thrown.
 * <p>
 * The provided {@link android.os.Bundle Bundle} consists of key-value pairs, where the types of values may be:
 * <ul>
 * <li>{@code boolean}
 * <li>{@code int}
 * <li>{@code String} or {@code String[]}
 * <li>From {@link android.os.Build.VERSION_CODES#M}, {@code Bundle} or {@code Bundle[]}
 * </ul>
 * <p>
 * If the restrictions are not available yet, but may be applied in the near future, the caller
 * can notify the target application of that by adding
 * {@link android.os.UserManager#KEY_RESTRICTIONS_PENDING UserManager#KEY_RESTRICTIONS_PENDING} to the settings parameter.
 * <p>
 * The application restrictions are only made visible to the target application via
 * {@link android.os.UserManager#getApplicationRestrictions(java.lang.String) UserManager#getApplicationRestrictions(String)}, in addition to the profile or device
 * owner, and the application restrictions managing package via
 * {@link #getApplicationRestrictions}.
 *
 * <p>NOTE: The method performs disk I/O and shouldn't be called on the main thread
 *
 * <br>
 * This method may take several seconds to complete, so it should
 * only be called from a worker thread.
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with, or
 *            {@code null} if called by the application restrictions managing package.
 * This value may be {@code null}.
 * @param packageName The name of the package to update restricted settings for.
 * @param settings A {@link android.os.Bundle Bundle} to be parsed by the receiving application, conveying a new
 *            set of active restrictions.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @see #setDelegatedScopes
 * @see #DELEGATION_APP_RESTRICTIONS
 * @see android.os.UserManager#KEY_RESTRICTIONS_PENDING
 * @apiSince 21
 */

public void setApplicationRestrictions(@androidx.annotation.Nullable android.content.ComponentName admin, java.lang.String packageName, android.os.Bundle settings) { throw new RuntimeException("Stub!"); }

/**
 * Sets a list of configuration features to enable for a trust agent component. This is meant to
 * be used in conjunction with {@link #KEYGUARD_DISABLE_TRUST_AGENTS}, which disables all trust
 * agents but those enabled by this function call. If flag
 * {@link #KEYGUARD_DISABLE_TRUST_AGENTS} is not set, then this call has no effect.
 * <p>
 * For any specific trust agent, whether it is disabled or not depends on the aggregated state
 * of each admin's {@link #KEYGUARD_DISABLE_TRUST_AGENTS} setting and its trust agent
 * configuration as set by this function call. In particular: if any admin sets
 * {@link #KEYGUARD_DISABLE_TRUST_AGENTS} and does not additionally set any
 * trust agent configuration, the trust agent is disabled completely. Otherwise, the trust agent
 * will receive the list of configurations from all admins who set
 * {@link #KEYGUARD_DISABLE_TRUST_AGENTS} and aggregate the configurations to determine its
 * behavior. The exact meaning of aggregation is trust-agent-specific.
 * <p>
 * The calling device admin must have requested
 * {@link android.app.admin.DeviceAdminInfo#USES_POLICY_DISABLE_KEYGUARD_FEATURES DeviceAdminInfo#USES_POLICY_DISABLE_KEYGUARD_FEATURES} to be able to call this method;
 * if not, a security exception will be thrown.
 * <p>
 * This method can be called on the {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance returned by
 * {@link #getParentProfileInstance(android.content.ComponentName)} in order to set the configuration for
 * the parent profile.
 * <p>
 * On devices not supporting {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature, calling
 * this method has no effect - no trust agent configuration will be set.
 *
 * <br>
 * Requires the {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param target Component name of the agent to be configured.
 * This value must never be {@code null}.
 * @param configuration Trust-agent-specific feature configuration bundle. Please consult
 *        documentation of the specific trust agent to determine the interpretation of this
 *        bundle.
 * @throws java.lang.SecurityException if {@code admin} is not an active administrator or does not use
 *             {@link android.app.admin.DeviceAdminInfo#USES_POLICY_DISABLE_KEYGUARD_FEATURES DeviceAdminInfo#USES_POLICY_DISABLE_KEYGUARD_FEATURES}
 * @apiSince 23
 */

public void setTrustAgentConfiguration(@androidx.annotation.NonNull android.content.ComponentName admin, @androidx.annotation.NonNull android.content.ComponentName target, android.os.PersistableBundle configuration) { throw new RuntimeException("Stub!"); }

/**
 * Gets configuration for the given trust agent based on aggregating all calls to
 * {@link #setTrustAgentConfiguration(android.content.ComponentName,android.content.ComponentName,android.os.PersistableBundle)} for
 * all device admins.
 * <p>
 * This method can be called on the {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance returned by
 * {@link #getParentProfileInstance(android.content.ComponentName)} in order to retrieve the configuration set
 * on the parent profile.
 * <p>
 * On devices not supporting {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature, null is
 * always returned.
 *
 * <br>
 * Requires the {@link android.content.pm.PackageManager#FEATURE_SECURE_LOCK_SCREEN PackageManager#FEATURE_SECURE_LOCK_SCREEN} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with. If null,
 * this function returns a list of configurations for all admins that declare
 * {@link #KEYGUARD_DISABLE_TRUST_AGENTS}. If any admin declares
 * {@link #KEYGUARD_DISABLE_TRUST_AGENTS} but doesn't call
 * {@link #setTrustAgentConfiguration(android.content.ComponentName,android.content.ComponentName,android.os.PersistableBundle)}
 * for this {@param agent} or calls it with a null configuration, null is returned.
 * This value may be {@code null}.
 * @param agent Which component to get enabled features for.
 * This value must never be {@code null}.
 * @return configuration for the given trust agent.
 * @apiSince 23
 */

@androidx.annotation.Nullable
public java.util.List<android.os.PersistableBundle> getTrustAgentConfiguration(@androidx.annotation.Nullable android.content.ComponentName admin, @androidx.annotation.NonNull android.content.ComponentName agent) { throw new RuntimeException("Stub!"); }

/**
 * Called by a profile owner of a managed profile to set whether caller-Id information from the
 * managed profile will be shown in the parent profile, for incoming calls.
 * <p>
 * The calling device admin must be a profile owner. If it is not, a security exception will be
 * thrown.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param disabled If true caller-Id information in the managed profile is not displayed.
 * @throws java.lang.SecurityException if {@code admin} is not a profile owner.
 * @apiSince 21
 */

public void setCrossProfileCallerIdDisabled(@androidx.annotation.NonNull android.content.ComponentName admin, boolean disabled) { throw new RuntimeException("Stub!"); }

/**
 * Called by a profile owner of a managed profile to determine whether or not caller-Id
 * information has been disabled.
 * <p>
 * The calling device admin must be a profile owner. If it is not, a security exception will be
 * thrown.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not a profile owner.
 * @apiSince 21
 */

public boolean getCrossProfileCallerIdDisabled(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by a profile owner of a managed profile to set whether contacts search from the
 * managed profile will be shown in the parent profile, for incoming calls.
 * <p>
 * The calling device admin must be a profile owner. If it is not, a security exception will be
 * thrown.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param disabled If true contacts search in the managed profile is not displayed.
 * @throws java.lang.SecurityException if {@code admin} is not a profile owner.
 * @apiSince 24
 */

public void setCrossProfileContactsSearchDisabled(@androidx.annotation.NonNull android.content.ComponentName admin, boolean disabled) { throw new RuntimeException("Stub!"); }

/**
 * Called by a profile owner of a managed profile to determine whether or not contacts search
 * has been disabled.
 * <p>
 * The calling device admin must be a profile owner. If it is not, a security exception will be
 * thrown.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not a profile owner.
 * @apiSince 24
 */

public boolean getCrossProfileContactsSearchDisabled(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by a profile owner of a managed profile to set whether bluetooth devices can access
 * enterprise contacts.
 * <p>
 * The calling device admin must be a profile owner. If it is not, a security exception will be
 * thrown.
 * <p>
 * This API works on managed profile only.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param disabled If true, bluetooth devices cannot access enterprise contacts.
 * @throws java.lang.SecurityException if {@code admin} is not a profile owner.
 * @apiSince 23
 */

public void setBluetoothContactSharingDisabled(@androidx.annotation.NonNull android.content.ComponentName admin, boolean disabled) { throw new RuntimeException("Stub!"); }

/**
 * Called by a profile owner of a managed profile to determine whether or not Bluetooth devices
 * cannot access enterprise contacts.
 * <p>
 * The calling device admin must be a profile owner. If it is not, a security exception will be
 * thrown.
 * <p>
 * This API works on managed profile only.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not a profile owner.
 * @apiSince 23
 */

public boolean getBluetoothContactSharingDisabled(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by the profile owner of a managed profile so that some intents sent in the managed
 * profile can also be resolved in the parent, or vice versa. Only activity intents are
 * supported.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param filter The {@link android.content.IntentFilter IntentFilter} the intent has to match to be also resolved in the
 *            other profile
 * @param flags {@link android.app.admin.DevicePolicyManager#FLAG_MANAGED_CAN_ACCESS_PARENT DevicePolicyManager#FLAG_MANAGED_CAN_ACCESS_PARENT} and
 *            {@link android.app.admin.DevicePolicyManager#FLAG_PARENT_CAN_ACCESS_MANAGED DevicePolicyManager#FLAG_PARENT_CAN_ACCESS_MANAGED} are supported.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @apiSince 21
 */

public void addCrossProfileIntentFilter(@androidx.annotation.NonNull android.content.ComponentName admin, android.content.IntentFilter filter, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Called by a profile owner of a managed profile to remove the cross-profile intent filters
 * that go from the managed profile to the parent, or from the parent to the managed profile.
 * Only removes those that have been set by the profile owner.
 * <p>
 * <em>Note</em>: A list of default cross profile intent filters are set up by the system when
 * the profile is created, some of them ensure the proper functioning of the profile, while
 * others enable sharing of data from the parent to the managed profile for user convenience.
 * These default intent filters are not cleared when this API is called. If the default cross
 * profile data sharing is not desired, they can be disabled with
 * {@link android.os.UserManager#DISALLOW_SHARE_INTO_MANAGED_PROFILE UserManager#DISALLOW_SHARE_INTO_MANAGED_PROFILE}.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not a profile owner.
 * @apiSince 21
 */

public void clearCrossProfileIntentFilters(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by a profile or device owner to set the permitted
 * {@link android.accessibilityservice.AccessibilityService}. When set by
 * a device owner or profile owner the restriction applies to all profiles of the user the
 * device owner or profile owner is an admin for. By default, the user can use any accessibility
 * service. When zero or more packages have been added, accessibility services that are not in
 * the list and not part of the system can not be enabled by the user.
 * <p>
 * Calling with a null value for the list disables the restriction so that all services can be
 * used, calling with an empty list only allows the built-in system services. Any non-system
 * accessibility service that's currently enabled must be included in the list.
 * <p>
 * System accessibility services are always available to the user the list can't modify this.
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param packageNames List of accessibility service package names.
 * @return {@code true} if the operation succeeded, or {@code false} if the list didn't
 *         contain every enabled non-system accessibility service.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @apiSince 21
 */

public boolean setPermittedAccessibilityServices(@androidx.annotation.NonNull android.content.ComponentName admin, java.util.List<java.lang.String> packageNames) { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of permitted accessibility services set by this device or profile owner.
 * <p>
 * An empty list means no accessibility services except system services are allowed. Null means
 * all accessibility services are allowed.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @return List of accessiblity service package names.
 * This value may be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public java.util.List<java.lang.String> getPermittedAccessibilityServices(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by a profile or device owner to set the permitted input methods services for this
 * user. By default, the user can use any input method.
 * <p>
 * When zero or more packages have been added, input method that are not in the list and not
 * part of the system can not be enabled by the user. This method will fail if it is called for
 * a admin that is not for the foreground user or a profile of the foreground user. Any
 * non-system input method service that's currently enabled must be included in the list.
 * <p>
 * Calling with a null value for the list disables the restriction so that all input methods can
 * be used, calling with an empty list disables all but the system's own input methods.
 * <p>
 * System input methods are always available to the user - this method can't modify this.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param packageNames List of input method package names.
 * @return {@code true} if the operation succeeded, or {@code false} if the list didn't
 *        contain every enabled non-system input method service.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @apiSince 21
 */

public boolean setPermittedInputMethods(@androidx.annotation.NonNull android.content.ComponentName admin, java.util.List<java.lang.String> packageNames) { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of permitted input methods set by this device or profile owner.
 * <p>
 * An empty list means no input methods except system input methods are allowed. Null means all
 * input methods are allowed.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @return List of input method package names.
 * This value may be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public java.util.List<java.lang.String> getPermittedInputMethods(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by a profile owner of a managed profile to set the packages that are allowed to use
 * a {@link android.service.notification.NotificationListenerService} in the primary user to
 * see notifications from the managed profile. By default all packages are permitted by this
 * policy. When zero or more packages have been added, notification listeners installed on the
 * primary user that are not in the list and are not part of the system won't receive events
 * for managed profile notifications.
 * <p>
 * Calling with a {@code null} value for the list disables the restriction so that all
 * notification listener services be used. Calling with an empty list disables all but the
 * system's own notification listeners. System notification listener services are always
 * available to the user.
 * <p>
 * If a device or profile owner want to stop notification listeners in their user from seeing
 * that user's notifications they should prevent that service from running instead (e.g. via
 * {@link #setApplicationHidden(android.content.ComponentName,java.lang.String,boolean)})
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param packageList List of package names to whitelist
 * This value may be {@code null}.
 * @return true if setting the restriction succeeded. It will fail if called outside a managed
 * profile
 * @throws java.lang.SecurityException if {@code admin} is not a profile owner.
 *
 * @see android.service.notification.NotificationListenerService
 * @apiSince 26
 */

public boolean setPermittedCrossProfileNotificationListeners(@androidx.annotation.NonNull android.content.ComponentName admin, @androidx.annotation.Nullable java.util.List<java.lang.String> packageList) { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of packages installed on the primary user that allowed to use a
 * {@link android.service.notification.NotificationListenerService} to receive
 * notifications from this managed profile, as set by the profile owner.
 * <p>
 * An empty list means no notification listener services except system ones are allowed.
 * A {@code null} return value indicates that all notification listeners are allowed.
 
 * @param admin This value must never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.Nullable
public java.util.List<java.lang.String> getPermittedCrossProfileNotificationListeners(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Get the list of apps to keep around as APKs even if no user has currently installed it. This
 * function can be called by a device owner or by a delegate given the
 * {@link #DELEGATION_KEEP_UNINSTALLED_PACKAGES} scope via {@link #setDelegatedScopes}.
 * <p>
 * Please note that packages returned in this method are not automatically pre-cached.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with, or
 *            {@code null} if the caller is a keep uninstalled packages delegate.
 * This value may be {@code null}.
 * @return List of package names to keep cached.
 * @see #setDelegatedScopes
 * @see #DELEGATION_KEEP_UNINSTALLED_PACKAGES
 * @apiSince 28
 */

@androidx.annotation.Nullable
public java.util.List<java.lang.String> getKeepUninstalledPackages(@androidx.annotation.Nullable android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Set a list of apps to keep around as APKs even if no user has currently installed it. This
 * function can be called by a device owner or by a delegate given the
 * {@link #DELEGATION_KEEP_UNINSTALLED_PACKAGES} scope via {@link #setDelegatedScopes}.
 *
 * <p>Please note that setting this policy does not imply that specified apps will be
 * automatically pre-cached.</p>
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with, or
 *            {@code null} if the caller is a keep uninstalled packages delegate.
 * This value may be {@code null}.
 * @param packageNames List of package names to keep cached.
 * This value must never be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not a device owner.
 * @see #setDelegatedScopes
 * @see #DELEGATION_KEEP_UNINSTALLED_PACKAGES
 * @apiSince 28
 */

public void setKeepUninstalledPackages(@androidx.annotation.Nullable android.content.ComponentName admin, @androidx.annotation.NonNull java.util.List<java.lang.String> packageNames) { throw new RuntimeException("Stub!"); }

/**
 * Called by a device owner to create a user with the specified name and a given component of
 * the calling package as profile owner. The UserHandle returned by this method should not be
 * persisted as user handles are recycled as users are removed and created. If you need to
 * persist an identifier for this user, use {@link android.os.UserManager#getSerialNumberForUser UserManager#getSerialNumberForUser}. The new
 * user will not be started in the background.
 * <p>
 * admin is the {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} which is the device owner. profileOwner is also a
 * DeviceAdminReceiver in the same package as admin, and will become the profile owner and will
 * be registered as an active admin on the new user. The profile owner package will be installed
 * on the new user.
 * <p>
 * If the adminExtras are not null, they will be stored on the device until the user is started
 * for the first time. Then the extras will be passed to the admin when onEnable is called.
 * <p>From {@link android.os.Build.VERSION_CODES#P} onwards, if targeting
 * {@link android.os.Build.VERSION_CODES#P}, throws {@link android.os.UserManager.UserOperationException UserOperationException} instead of
 * returning {@code null} on failure.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param name The user's name.
 * This value must never be {@code null}.
 * @param profileOwner Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} will be profile owner. Has to be in the
 *            same package as admin, otherwise no user is created and an
 *            IllegalArgumentException is thrown.
 * This value must never be {@code null}.
 * @param adminExtras Extras that will be passed to onEnable of the admin receiver on the new
 *            user.
 * This value may be {@code null}.
 * @param flags {@link #SKIP_SETUP_WIZARD}, {@link #MAKE_USER_EPHEMERAL} and
 *        {@link #LEAVE_ALL_SYSTEM_APPS_ENABLED} are supported.
 * Value is either <code>0</code> or a combination of {@link android.app.admin.DevicePolicyManager#SKIP_SETUP_WIZARD}, {@link android.app.admin.DevicePolicyManager#MAKE_USER_EPHEMERAL}, android.app.admin.DevicePolicyManager.MAKE_USER_DEMO, and {@link android.app.admin.DevicePolicyManager#LEAVE_ALL_SYSTEM_APPS_ENABLED}
 * @see android.os.UserHandle
 * @return the {@link android.os.UserHandle} object for the created user, or {@code null} if the
 *         user could not be created.
 * @throws java.lang.SecurityException if {@code admin} is not a device owner.
 * @throws android.os.UserManager.UserOperationException if the user could not be created and the calling app is
 * targeting {@link android.os.Build.VERSION_CODES#P} and running on
 * {@link android.os.Build.VERSION_CODES#P}.
 * @apiSince 24
 */

@androidx.annotation.Nullable
public android.os.UserHandle createAndManageUser(@androidx.annotation.NonNull android.content.ComponentName admin, @androidx.annotation.NonNull java.lang.String name, @androidx.annotation.NonNull android.content.ComponentName profileOwner, @androidx.annotation.Nullable android.os.PersistableBundle adminExtras, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Called by a device owner to remove a user/profile and all associated data. The primary user
 * can not be removed.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param userHandle the user to remove.
 * This value must never be {@code null}.
 * @return {@code true} if the user was removed, {@code false} otherwise.
 * @throws java.lang.SecurityException if {@code admin} is not a device owner.
 * @apiSince 21
 */

public boolean removeUser(@androidx.annotation.NonNull android.content.ComponentName admin, @androidx.annotation.NonNull android.os.UserHandle userHandle) { throw new RuntimeException("Stub!"); }

/**
 * Called by a device owner to switch the specified secondary user to the foreground.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param userHandle the user to switch to; null will switch to primary.
 * This value may be {@code null}.
 * @return {@code true} if the switch was successful, {@code false} otherwise.
 * @throws java.lang.SecurityException if {@code admin} is not a device owner.
 * @see android.content.Intent#ACTION_USER_FOREGROUND
 * @see #getSecondaryUsers(ComponentName)
 * @apiSince 21
 */

public boolean switchUser(@androidx.annotation.NonNull android.content.ComponentName admin, @androidx.annotation.Nullable android.os.UserHandle userHandle) { throw new RuntimeException("Stub!"); }

/**
 * Called by a device owner to start the specified secondary user in background.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param userHandle the user to be started in background.
 * This value must never be {@code null}.
 * @return one of the following result codes:
 * {@link android.os.UserManager#USER_OPERATION_ERROR_UNKNOWN UserManager#USER_OPERATION_ERROR_UNKNOWN},
 * {@link android.os.UserManager#USER_OPERATION_SUCCESS UserManager#USER_OPERATION_SUCCESS},
 * {@link android.os.UserManager#USER_OPERATION_ERROR_MANAGED_PROFILE UserManager#USER_OPERATION_ERROR_MANAGED_PROFILE},
 * {@link android.os.UserManager#USER_OPERATION_ERROR_MAX_RUNNING_USERS UserManager#USER_OPERATION_ERROR_MAX_RUNNING_USERS},
 * Value is {@link android.os.UserManager#USER_OPERATION_SUCCESS}, {@link android.os.UserManager#USER_OPERATION_ERROR_UNKNOWN}, {@link android.os.UserManager#USER_OPERATION_ERROR_MANAGED_PROFILE}, {@link android.os.UserManager#USER_OPERATION_ERROR_MAX_RUNNING_USERS}, {@link android.os.UserManager#USER_OPERATION_ERROR_CURRENT_USER}, {@link android.os.UserManager#USER_OPERATION_ERROR_LOW_STORAGE}, or {@link android.os.UserManager#USER_OPERATION_ERROR_MAX_USERS}
 * @throws java.lang.SecurityException if {@code admin} is not a device owner.
 * @see #getSecondaryUsers(ComponentName)
 * @apiSince 28
 */

public int startUserInBackground(@androidx.annotation.NonNull android.content.ComponentName admin, @androidx.annotation.NonNull android.os.UserHandle userHandle) { throw new RuntimeException("Stub!"); }

/**
 * Called by a device owner to stop the specified secondary user.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param userHandle the user to be stopped.
 * This value must never be {@code null}.
 * @return one of the following result codes:
 * {@link android.os.UserManager#USER_OPERATION_ERROR_UNKNOWN UserManager#USER_OPERATION_ERROR_UNKNOWN},
 * {@link android.os.UserManager#USER_OPERATION_SUCCESS UserManager#USER_OPERATION_SUCCESS},
 * {@link android.os.UserManager#USER_OPERATION_ERROR_MANAGED_PROFILE UserManager#USER_OPERATION_ERROR_MANAGED_PROFILE},
 * {@link android.os.UserManager#USER_OPERATION_ERROR_CURRENT_USER UserManager#USER_OPERATION_ERROR_CURRENT_USER}
 * Value is {@link android.os.UserManager#USER_OPERATION_SUCCESS}, {@link android.os.UserManager#USER_OPERATION_ERROR_UNKNOWN}, {@link android.os.UserManager#USER_OPERATION_ERROR_MANAGED_PROFILE}, {@link android.os.UserManager#USER_OPERATION_ERROR_MAX_RUNNING_USERS}, {@link android.os.UserManager#USER_OPERATION_ERROR_CURRENT_USER}, {@link android.os.UserManager#USER_OPERATION_ERROR_LOW_STORAGE}, or {@link android.os.UserManager#USER_OPERATION_ERROR_MAX_USERS}
 * @throws java.lang.SecurityException if {@code admin} is not a device owner.
 * @see #getSecondaryUsers(ComponentName)
 * @apiSince 28
 */

public int stopUser(@androidx.annotation.NonNull android.content.ComponentName admin, @androidx.annotation.NonNull android.os.UserHandle userHandle) { throw new RuntimeException("Stub!"); }

/**
 * Called by a profile owner of secondary user that is affiliated with the device to stop the
 * calling user and switch back to primary.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @return one of the following result codes:
 * {@link android.os.UserManager#USER_OPERATION_ERROR_UNKNOWN UserManager#USER_OPERATION_ERROR_UNKNOWN},
 * {@link android.os.UserManager#USER_OPERATION_SUCCESS UserManager#USER_OPERATION_SUCCESS},
 * {@link android.os.UserManager#USER_OPERATION_ERROR_MANAGED_PROFILE UserManager#USER_OPERATION_ERROR_MANAGED_PROFILE},
 * {@link android.os.UserManager#USER_OPERATION_ERROR_CURRENT_USER UserManager#USER_OPERATION_ERROR_CURRENT_USER}
 * Value is {@link android.os.UserManager#USER_OPERATION_SUCCESS}, {@link android.os.UserManager#USER_OPERATION_ERROR_UNKNOWN}, {@link android.os.UserManager#USER_OPERATION_ERROR_MANAGED_PROFILE}, {@link android.os.UserManager#USER_OPERATION_ERROR_MAX_RUNNING_USERS}, {@link android.os.UserManager#USER_OPERATION_ERROR_CURRENT_USER}, {@link android.os.UserManager#USER_OPERATION_ERROR_LOW_STORAGE}, or {@link android.os.UserManager#USER_OPERATION_ERROR_MAX_USERS}
 * @throws java.lang.SecurityException if {@code admin} is not a profile owner affiliated with the device.
 * @see #getSecondaryUsers(ComponentName)
 * @apiSince 28
 */

public int logoutUser(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by a device owner to list all secondary users on the device. Managed profiles are not
 * considered as secondary users.
 * <p> Used for various user management APIs, including {@link #switchUser}, {@link #removeUser}
 * and {@link #stopUser}.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @return list of other {@link android.os.UserHandle UserHandle}s on the device.
 * @throws java.lang.SecurityException if {@code admin} is not a device owner.
 * @see #removeUser(ComponentName, UserHandle)
 * @see #switchUser(ComponentName, UserHandle)
 * @see #startUserInBackground(ComponentName, UserHandle)
 * @see #stopUser(ComponentName, UserHandle)
 * @apiSince 28
 */

public java.util.List<android.os.UserHandle> getSecondaryUsers(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Checks if the profile owner is running in an ephemeral user.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @return whether the profile owner is running in an ephemeral user.
 * @apiSince 28
 */

public boolean isEphemeralUser(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the application restrictions for a given target application running in the calling
 * user.
 * <p>
 * The caller must be a profile or device owner on that user, or the package allowed to manage
 * application restrictions via {@link #setDelegatedScopes} with the
 * {@link #DELEGATION_APP_RESTRICTIONS} scope; otherwise a security exception will be thrown.
 *
 * <p>NOTE: The method performs disk I/O and shouldn't be called on the main thread
 *
 * <br>
 * This method may take several seconds to complete, so it should
 * only be called from a worker thread.
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with, or
 *            {@code null} if called by the application restrictions managing package.
 * This value may be {@code null}.
 * @param packageName The name of the package to fetch restricted settings of.
 * @return {@link android.os.Bundle Bundle} of settings corresponding to what was set last time
 *         {@link android.app.admin.DevicePolicyManager#setApplicationRestrictions DevicePolicyManager#setApplicationRestrictions} was called, or an empty
 *         {@link android.os.Bundle Bundle} if no restrictions have been set.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @see #setDelegatedScopes
 * @see #DELEGATION_APP_RESTRICTIONS
 * @apiSince 21
 */

@androidx.annotation.NonNull
public android.os.Bundle getApplicationRestrictions(@androidx.annotation.Nullable android.content.ComponentName admin, java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * Called by a profile or device owner to set a user restriction specified by the key.
 * <p>
 * The calling device admin must be a profile or device owner; if it is not, a security
 * exception will be thrown.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param key The key of the restriction. See the constants in {@link android.os.UserManager}
 *            for the list of keys.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @apiSince 21
 */

public void addUserRestriction(@androidx.annotation.NonNull android.content.ComponentName admin, java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Called by a profile or device owner to clear a user restriction specified by the key.
 * <p>
 * The calling device admin must be a profile or device owner; if it is not, a security
 * exception will be thrown.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param key The key of the restriction. See the constants in {@link android.os.UserManager}
 *            for the list of keys.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @apiSince 21
 */

public void clearUserRestriction(@androidx.annotation.NonNull android.content.ComponentName admin, java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Called by a profile or device owner to get user restrictions set with
 * {@link #addUserRestriction(android.content.ComponentName,java.lang.String)}.
 * <p>
 * The target user may have more restrictions set by the system or other device owner / profile
 * owner. To get all the user restrictions currently set, use
 * {@link android.os.UserManager#getUserRestrictions() UserManager#getUserRestrictions()}.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 
 * @return This value will never be {@code null}.
 * @apiSince 24
 */

@androidx.annotation.NonNull
public android.os.Bundle getUserRestrictions(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by any app to display a support dialog when a feature was disabled by an admin.
 * This returns an intent that can be used with {@link android.content.Context#startActivity(android.content.Intent) Context#startActivity(Intent)} to
 * display the dialog. It will tell the user that the feature indicated by {@code restriction}
 * was disabled by an admin, and include a link for more information. The default content of
 * the dialog can be changed by the restricting admin via
 * {@link #setShortSupportMessage(android.content.ComponentName,java.lang.CharSequence)}. If the restriction is not
 * set (i.e. the feature is available), then the return value will be {@code null}.
 * @param restriction Indicates for which feature the dialog should be displayed. Can be a
 *            user restriction from {@link android.os.UserManager UserManager}, e.g.
 *            {@link android.os.UserManager#DISALLOW_ADJUST_VOLUME UserManager#DISALLOW_ADJUST_VOLUME}, or one of the constants
 *            {@link #POLICY_DISABLE_CAMERA} or {@link #POLICY_DISABLE_SCREEN_CAPTURE}.
 * This value must never be {@code null}.
 * @return Intent An intent to be used to start the dialog-activity if the restriction is
 *            set by an admin, or null if the restriction does not exist or no admin set it.
 * @apiSince 26
 */

public android.content.Intent createAdminSupportIntent(@androidx.annotation.NonNull java.lang.String restriction) { throw new RuntimeException("Stub!"); }

/**
 * Hide or unhide packages. When a package is hidden it is unavailable for use, but the data and
 * actual package file remain. This function can be called by a device owner, profile owner, or
 * by a delegate given the {@link #DELEGATION_PACKAGE_ACCESS} scope via
 * {@link #setDelegatedScopes}.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with, or
 *            {@code null} if the caller is a package access delegate.
 * This value must never be {@code null}.
 * @param packageName The name of the package to hide or unhide.
 * @param hidden {@code true} if the package should be hidden, {@code false} if it should be
 *            unhidden.
 * @return boolean Whether the hidden setting of the package was successfully updated.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @see #setDelegatedScopes
 * @see #DELEGATION_PACKAGE_ACCESS
 * @apiSince 21
 */

public boolean setApplicationHidden(@androidx.annotation.NonNull android.content.ComponentName admin, java.lang.String packageName, boolean hidden) { throw new RuntimeException("Stub!"); }

/**
 * Determine if a package is hidden. This function can be called by a device owner, profile
 * owner, or by a delegate given the {@link #DELEGATION_PACKAGE_ACCESS} scope via
 * {@link #setDelegatedScopes}.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with, or
 *            {@code null} if the caller is a package access delegate.
 * This value must never be {@code null}.
 * @param packageName The name of the package to retrieve the hidden status of.
 * @return boolean {@code true} if the package is hidden, {@code false} otherwise.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @see #setDelegatedScopes
 * @see #DELEGATION_PACKAGE_ACCESS
 * @apiSince 21
 */

public boolean isApplicationHidden(@androidx.annotation.NonNull android.content.ComponentName admin, java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * Re-enable a system app that was disabled by default when the user was initialized. This
 * function can be called by a device owner, profile owner, or by a delegate given the
 * {@link #DELEGATION_ENABLE_SYSTEM_APP} scope via {@link #setDelegatedScopes}.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with, or
 *            {@code null} if the caller is an enable system app delegate.
 * This value must never be {@code null}.
 * @param packageName The package to be re-enabled in the calling profile.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @see #setDelegatedScopes
 * @see #DELEGATION_PACKAGE_ACCESS
 * @apiSince 21
 */

public void enableSystemApp(@androidx.annotation.NonNull android.content.ComponentName admin, java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * Re-enable system apps by intent that were disabled by default when the user was initialized.
 * This function can be called by a device owner, profile owner, or by a delegate given the
 * {@link #DELEGATION_ENABLE_SYSTEM_APP} scope via {@link #setDelegatedScopes}.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with, or
 *            {@code null} if the caller is an enable system app delegate.
 * This value must never be {@code null}.
 * @param intent An intent matching the app(s) to be installed. All apps that resolve for this
 *            intent will be re-enabled in the calling profile.
 * @return int The number of activities that matched the intent and were installed.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @see #setDelegatedScopes
 * @see #DELEGATION_PACKAGE_ACCESS
 * @apiSince 21
 */

public int enableSystemApp(@androidx.annotation.NonNull android.content.ComponentName admin, android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Install an existing package that has been installed in another user, or has been kept after
 * removal via {@link #setKeepUninstalledPackages}.
 * This function can be called by a device owner, profile owner or a delegate given
 * the {@link #DELEGATION_INSTALL_EXISTING_PACKAGE} scope via {@link #setDelegatedScopes}.
 * When called in a secondary user or managed profile, the user/profile must be affiliated with
 * the device. See {@link #isAffiliatedUser}.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param packageName The package to be installed in the calling profile.
 * @return {@code true} if the app is installed; {@code false} otherwise.
 * @throws java.lang.SecurityException if {@code admin} is not the device owner, or the profile owner of
 * an affiliated user or profile.
 * @see #setKeepUninstalledPackages
 * @see #setDelegatedScopes
 * @see #isAffiliatedUser
 * @see #DELEGATION_PACKAGE_ACCESS
 * @apiSince 28
 */

public boolean installExistingPackage(@androidx.annotation.NonNull android.content.ComponentName admin, java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * Called by a device owner or profile owner to disable account management for a specific type
 * of account.
 * <p>
 * The calling device admin must be a device owner or profile owner. If it is not, a security
 * exception will be thrown.
 * <p>
 * When account management is disabled for an account type, adding or removing an account of
 * that type will not be possible.
 * <p>
 * From {@link android.os.Build.VERSION_CODES#N} the profile or device owner can still use
 * {@link android.accounts.AccountManager} APIs to add or remove accounts when account
 * management for a specific type is disabled.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param accountType For which account management is disabled or enabled.
 * @param disabled The boolean indicating that account management will be disabled (true) or
 *            enabled (false).
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @apiSince 21
 */

public void setAccountManagementDisabled(@androidx.annotation.NonNull android.content.ComponentName admin, java.lang.String accountType, boolean disabled) { throw new RuntimeException("Stub!"); }

/**
 * Gets the array of accounts for which account management is disabled by the profile owner.
 *
 * <p> Account management can be disabled/enabled by calling
 * {@link #setAccountManagementDisabled}.
 *
 * @return a list of account types for which account management has been disabled.
 *
 * This value may be {@code null}.
 * @see #setAccountManagementDisabled
 * @apiSince 21
 */

@androidx.annotation.Nullable
public java.lang.String[] getAccountTypesWithManagementDisabled() { throw new RuntimeException("Stub!"); }

/**
 * Sets which packages may enter lock task mode.
 * <p>
 * Any packages that share uid with an allowed package will also be allowed to activate lock
 * task. From {@link android.os.Build.VERSION_CODES#M} removing packages from the lock task
 * package list results in locked tasks belonging to those packages to be finished.
 * <p>
 * This function can only be called by the device owner, a profile owner of an affiliated user
 * or profile, or the profile owner when no device owner is set. See {@link #isAffiliatedUser}.
 * Any package set via this method will be cleared if the user becomes unaffiliated.
 *
 * @param packages The list of packages allowed to enter lock task mode
 * This value must never be {@code null}.
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not the device owner, the profile owner of an
 * affiliated user or profile, or the profile owner when no device owner is set.
 * @see #isAffiliatedUser
 * @see android.app.Activity#startLockTask()
 * @see android.app.admin.DeviceAdminReceiver#onLockTaskModeEntering(Context, Intent, String)
 * @see android.app.admin.DeviceAdminReceiver#onLockTaskModeExiting(Context, Intent)
 * @see android.os.UserManager#DISALLOW_CREATE_WINDOWS
 * @apiSince 21
 */

public void setLockTaskPackages(@androidx.annotation.NonNull android.content.ComponentName admin, @androidx.annotation.NonNull java.lang.String[] packages) throws java.lang.SecurityException { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of packages allowed to start the lock task mode.
 *
 * @throws java.lang.SecurityException if {@code admin} is not the device owner, the profile owner of an
 * affiliated user or profile, or the profile owner when no device owner is set.
 * @see #isAffiliatedUser
 * @see #setLockTaskPackages
 
 * @param admin This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public java.lang.String[] getLockTaskPackages(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * This function lets the caller know whether the given component is allowed to start the
 * lock task mode.
 * @param pkg The package to check
 * @apiSince 21
 */

public boolean isLockTaskPermitted(java.lang.String pkg) { throw new RuntimeException("Stub!"); }

/**
 * Sets which system features are enabled when the device runs in lock task mode. This method
 * doesn't affect the features when lock task mode is inactive. Any system features not included
 * in {@code flags} are implicitly disabled when calling this method. By default, only
 * {@link #LOCK_TASK_FEATURE_GLOBAL_ACTIONS} is enabled—all the other features are disabled. To
 * disable the global actions dialog, call this method omitting
 * {@link #LOCK_TASK_FEATURE_GLOBAL_ACTIONS}.
 *
 * <p>This method can only be called by the device owner, a profile owner of an affiliated
 * user or profile, or the profile owner when no device owner is set. See
 * {@link #isAffiliatedUser}.
 * Any features set using this method are cleared if the user becomes unaffiliated.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param flags The system features enabled during lock task mode.
 * Value is either <code>0</code> or a combination of {@link android.app.admin.DevicePolicyManager#LOCK_TASK_FEATURE_NONE}, {@link android.app.admin.DevicePolicyManager#LOCK_TASK_FEATURE_SYSTEM_INFO}, {@link android.app.admin.DevicePolicyManager#LOCK_TASK_FEATURE_NOTIFICATIONS}, {@link android.app.admin.DevicePolicyManager#LOCK_TASK_FEATURE_HOME}, {@link android.app.admin.DevicePolicyManager#LOCK_TASK_FEATURE_OVERVIEW}, {@link android.app.admin.DevicePolicyManager#LOCK_TASK_FEATURE_GLOBAL_ACTIONS}, and {@link android.app.admin.DevicePolicyManager#LOCK_TASK_FEATURE_KEYGUARD}
 * @throws java.lang.SecurityException if {@code admin} is not the device owner, the profile owner of an
 * affiliated user or profile, or the profile owner when no device owner is set.
 * @see #isAffiliatedUser
 * * @apiSince 28
 */

public void setLockTaskFeatures(@androidx.annotation.NonNull android.content.ComponentName admin, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Gets which system features are enabled for LockTask mode.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @return bitfield of flags. See {@link #setLockTaskFeatures(android.content.ComponentName,int)} for a list.
 * Value is either <code>0</code> or a combination of {@link android.app.admin.DevicePolicyManager#LOCK_TASK_FEATURE_NONE}, {@link android.app.admin.DevicePolicyManager#LOCK_TASK_FEATURE_SYSTEM_INFO}, {@link android.app.admin.DevicePolicyManager#LOCK_TASK_FEATURE_NOTIFICATIONS}, {@link android.app.admin.DevicePolicyManager#LOCK_TASK_FEATURE_HOME}, {@link android.app.admin.DevicePolicyManager#LOCK_TASK_FEATURE_OVERVIEW}, {@link android.app.admin.DevicePolicyManager#LOCK_TASK_FEATURE_GLOBAL_ACTIONS}, and {@link android.app.admin.DevicePolicyManager#LOCK_TASK_FEATURE_KEYGUARD}
 * @throws java.lang.SecurityException if {@code admin} is not the device owner, the profile owner of an
 * affiliated user or profile, or the profile owner when no device owner is set.
 * @see #isAffiliatedUser
 * @see #setLockTaskFeatures
 * @apiSince 28
 */

public int getLockTaskFeatures(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by device owner to update {@link android.provider.Settings.Global} settings.
 * Validation that the value of the setting is in the correct form for the setting type should
 * be performed by the caller.
 * <p>
 * The settings that can be updated with this method are:
 * <ul>
 * <li>{@link android.provider.Settings.Global#ADB_ENABLED}</li>
 * <li>{@link android.provider.Settings.Global#AUTO_TIME}</li>
 * <li>{@link android.provider.Settings.Global#AUTO_TIME_ZONE}</li>
 * <li>{@link android.provider.Settings.Global#DATA_ROAMING}</li>
 * <li>{@link android.provider.Settings.Global#USB_MASS_STORAGE_ENABLED}</li>
 * <li>{@link android.provider.Settings.Global#WIFI_SLEEP_POLICY}</li>
 * <li>{@link android.provider.Settings.Global#STAY_ON_WHILE_PLUGGED_IN} This setting is only
 * available from {@link android.os.Build.VERSION_CODES#M} onwards and can only be set if
 * {@link #setMaximumTimeToLock} is not used to set a timeout.</li>
 * <li>{@link android.provider.Settings.Global#WIFI_DEVICE_OWNER_CONFIGS_LOCKDOWN}</li> This
 * setting is only available from {@link android.os.Build.VERSION_CODES#M} onwards.</li>
 * </ul>
 * <p>
 * Changing the following settings has no effect as of {@link android.os.Build.VERSION_CODES#M}:
 * <ul>
 * <li>{@link android.provider.Settings.Global#BLUETOOTH_ON}. Use
 * {@link android.bluetooth.BluetoothAdapter#enable()} and
 * {@link android.bluetooth.BluetoothAdapter#disable()} instead.</li>
 * <li>{@link android.provider.Settings.Global#DEVELOPMENT_SETTINGS_ENABLED}</li>
 * <li>{@link android.provider.Settings.Global#MODE_RINGER}. Use
 * {@link android.media.AudioManager#setRingerMode(int)} instead.</li>
 * <li>{@link android.provider.Settings.Global#NETWORK_PREFERENCE}</li>
 * <li>{@link android.provider.Settings.Global#WIFI_ON}. Use
 * {@link android.net.wifi.WifiManager#setWifiEnabled(boolean)} instead.</li>
 * </ul>
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param setting The name of the setting to update.
 * @param value The value to update the setting to.
 * @throws java.lang.SecurityException if {@code admin} is not a device owner.
 * @apiSince 21
 */

public void setGlobalSetting(@androidx.annotation.NonNull android.content.ComponentName admin, java.lang.String setting, java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Called by a device or profile owner to update {@link android.provider.Settings.System}
 * settings. Validation that the value of the setting is in the correct form for the setting
 * type should be performed by the caller.
 * <p>
 * The settings that can be updated by a device owner or profile owner of secondary user with
 * this method are:
 * <ul>
 * <li>{@link android.provider.Settings.System#SCREEN_BRIGHTNESS}</li>
 * <li>{@link android.provider.Settings.System#SCREEN_BRIGHTNESS_MODE}</li>
 * <li>{@link android.provider.Settings.System#SCREEN_OFF_TIMEOUT}</li>
 * </ul>
 * <p>
 *
 * @see android.provider.Settings.System#SCREEN_OFF_TIMEOUT
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param setting The name of the setting to update.
 * This value must never be {@code null}.
 * Value is {@link android.provider.Settings.System#SCREEN_BRIGHTNESS_MODE}, {@link android.provider.Settings.System#SCREEN_BRIGHTNESS}, or {@link android.provider.Settings.System#SCREEN_OFF_TIMEOUT}
 * @param value The value to update the setting to.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @apiSince 28
 */

public void setSystemSetting(@androidx.annotation.NonNull android.content.ComponentName admin, @androidx.annotation.NonNull java.lang.String setting, java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Called by device owner to set the system wall clock time. This only takes effect if called
 * when {@link android.provider.Settings.Global#AUTO_TIME} is 0, otherwise {@code false} will be
 * returned.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with
 * This value must never be {@code null}.
 * @param millis time in milliseconds since the Epoch
 * @return {@code true} if set time succeeded, {@code false} otherwise.
 * @throws java.lang.SecurityException if {@code admin} is not a device owner.
 * @apiSince 28
 */

public boolean setTime(@androidx.annotation.NonNull android.content.ComponentName admin, long millis) { throw new RuntimeException("Stub!"); }

/**
 * Called by device owner to set the system's persistent default time zone. This only takes
 * effect if called when {@link android.provider.Settings.Global#AUTO_TIME_ZONE} is 0, otherwise
 * {@code false} will be returned.
 *
 * @see android.app.AlarmManager#setTimeZone(String)
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with
 * This value must never be {@code null}.
 * @param timeZone one of the Olson ids from the list returned by
 *     {@link java.util.TimeZone#getAvailableIDs}
 * @return {@code true} if set timezone succeeded, {@code false} otherwise.
 * @throws java.lang.SecurityException if {@code admin} is not a device owner.
 * @apiSince 28
 */

public boolean setTimeZone(@androidx.annotation.NonNull android.content.ComponentName admin, java.lang.String timeZone) { throw new RuntimeException("Stub!"); }

/**
 * Called by profile or device owners to update {@link android.provider.Settings.Secure}
 * settings. Validation that the value of the setting is in the correct form for the setting
 * type should be performed by the caller.
 * <p>
 * The settings that can be updated by a profile or device owner with this method are:
 * <ul>
 * <li>{@link android.provider.Settings.Secure#DEFAULT_INPUT_METHOD}</li>
 * <li>{@link android.provider.Settings.Secure#SKIP_FIRST_USE_HINTS}</li>
 * </ul>
 * <p>
 * A device owner can additionally update the following settings:
 * <ul>
 * <li>{@link android.provider.Settings.Secure#LOCATION_MODE}</li>
 * </ul>
 *
 * <strong>Note: Starting from Android O, apps should no longer call this method with the
 * setting {@link android.provider.Settings.Secure#INSTALL_NON_MARKET_APPS}, which is
 * deprecated. Instead, device owners or profile owners should use the restriction
 * {@link android.os.UserManager#DISALLOW_INSTALL_UNKNOWN_SOURCES UserManager#DISALLOW_INSTALL_UNKNOWN_SOURCES}.
 * If any app targeting {@link android.os.Build.VERSION_CODES#O} or higher calls this method
 * with {@link android.provider.Settings.Secure#INSTALL_NON_MARKET_APPS},
 * an {@link java.lang.UnsupportedOperationException UnsupportedOperationException} is thrown.
 *
 * Starting from Android Q, the device and profile owner can also call
 * {@link android.os.UserManager#DISALLOW_INSTALL_UNKNOWN_SOURCES_GLOBALLY UserManager#DISALLOW_INSTALL_UNKNOWN_SOURCES_GLOBALLY} to restrict unknown sources for
 * all users.
 * </strong>
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param setting The name of the setting to update.
 * @param value The value to update the setting to.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @apiSince 21
 */

public void setSecureSetting(@androidx.annotation.NonNull android.content.ComponentName admin, java.lang.String setting, java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Designates a specific service component as the provider for making permission requests of a
 * local or remote administrator of the user.
 * <p/>
 * Only a profile owner can designate the restrictions provider.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param provider The component name of the service that implements
 *            {@link android.service.restrictions.RestrictionsReceiver RestrictionsReceiver}. If this param is null, it removes the restrictions
 *            provider previously assigned.
 * This value may be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @apiSince 21
 */

public void setRestrictionsProvider(@androidx.annotation.NonNull android.content.ComponentName admin, @androidx.annotation.Nullable android.content.ComponentName provider) { throw new RuntimeException("Stub!"); }

/**
 * Called by profile or device owners to set the master volume mute on or off.
 * This has no effect when set on a managed profile.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param on {@code true} to mute master volume, {@code false} to turn mute off.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @apiSince 21
 */

public void setMasterVolumeMuted(@androidx.annotation.NonNull android.content.ComponentName admin, boolean on) { throw new RuntimeException("Stub!"); }

/**
 * Called by profile or device owners to check whether the master volume mute is on or off.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @return {@code true} if master volume is muted, {@code false} if it's not.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @apiSince 21
 */

public boolean isMasterVolumeMuted(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Change whether a user can uninstall a package. This function can be called by a device owner,
 * profile owner, or by a delegate given the {@link #DELEGATION_BLOCK_UNINSTALL} scope via
 * {@link #setDelegatedScopes}.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with, or
 *             {@code null} if the caller is a block uninstall delegate.
 * This value may be {@code null}.
 * @param packageName package to change.
 * @param uninstallBlocked true if the user shouldn't be able to uninstall the package.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @see #setDelegatedScopes
 * @see #DELEGATION_BLOCK_UNINSTALL
 * @apiSince 21
 */

public void setUninstallBlocked(@androidx.annotation.Nullable android.content.ComponentName admin, java.lang.String packageName, boolean uninstallBlocked) { throw new RuntimeException("Stub!"); }

/**
 * Check whether the user has been blocked by device policy from uninstalling a package.
 * Requires the caller to be the profile owner if checking a specific admin's policy.
 * <p>
 * <strong>Note:</strong> Starting from {@link android.os.Build.VERSION_CODES#LOLLIPOP_MR1}, the
 * behavior of this API is changed such that passing {@code null} as the {@code admin} parameter
 * will return if any admin has blocked the uninstallation. Before L MR1, passing {@code null}
 * will cause a NullPointerException to be raised.
 *
 * @param admin The name of the admin component whose blocking policy will be checked, or
 *            {@code null} to check whether any admin has blocked the uninstallation.
 * This value may be {@code null}.
 * @param packageName package to check.
 * @return true if uninstallation is blocked.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @apiSince 21
 */

public boolean isUninstallBlocked(@androidx.annotation.Nullable android.content.ComponentName admin, java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * Called by the profile owner of a managed profile to enable widget providers from a given
 * package to be available in the parent profile. As a result the user will be able to add
 * widgets from the white-listed package running under the profile to a widget host which runs
 * under the parent profile, for example the home screen. Note that a package may have zero or
 * more provider components, where each component provides a different widget type.
 * <p>
 * <strong>Note:</strong> By default no widget provider package is white-listed.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param packageName The package from which widget providers are white-listed.
 * @return Whether the package was added.
 * @throws java.lang.SecurityException if {@code admin} is not a profile owner.
 * @see #removeCrossProfileWidgetProvider(android.content.ComponentName, String)
 * @see #getCrossProfileWidgetProviders(android.content.ComponentName)
 * @apiSince 21
 */

public boolean addCrossProfileWidgetProvider(@androidx.annotation.NonNull android.content.ComponentName admin, java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * Called by the profile owner of a managed profile to disable widget providers from a given
 * package to be available in the parent profile. For this method to take effect the package
 * should have been added via
 * {@link #addCrossProfileWidgetProvider(android.content.ComponentName,java.lang.String)}.
 * <p>
 * <strong>Note:</strong> By default no widget provider package is white-listed.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param packageName The package from which widget providers are no longer white-listed.
 * @return Whether the package was removed.
 * @throws java.lang.SecurityException if {@code admin} is not a profile owner.
 * @see #addCrossProfileWidgetProvider(android.content.ComponentName, String)
 * @see #getCrossProfileWidgetProviders(android.content.ComponentName)
 * @apiSince 21
 */

public boolean removeCrossProfileWidgetProvider(@androidx.annotation.NonNull android.content.ComponentName admin, java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * Called by the profile owner of a managed profile to query providers from which packages are
 * available in the parent profile.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @return The white-listed package list.
 * This value will never be {@code null}.
 * @see #addCrossProfileWidgetProvider(android.content.ComponentName, String)
 * @see #removeCrossProfileWidgetProvider(android.content.ComponentName, String)
 * @throws java.lang.SecurityException if {@code admin} is not a profile owner.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.util.List<java.lang.String> getCrossProfileWidgetProviders(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by profile or device owners to set the user's photo.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param icon the bitmap to set as the photo.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @apiSince 23
 */

public void setUserIcon(@androidx.annotation.NonNull android.content.ComponentName admin, android.graphics.Bitmap icon) { throw new RuntimeException("Stub!"); }

/**
 * Called by device owners to set a local system update policy. When a new policy is set,
 * {@link #ACTION_SYSTEM_UPDATE_POLICY_CHANGED} is broadcasted.
 * <p>
 * If the supplied system update policy has freeze periods set but the freeze periods do not
 * meet 90-day maximum length or 60-day minimum separation requirement set out in
 * {@link android.app.admin.SystemUpdatePolicy#setFreezePeriods SystemUpdatePolicy#setFreezePeriods},
 * {@link android.app.admin.SystemUpdatePolicy.ValidationFailedException SystemUpdatePolicy.ValidationFailedException} will the thrown. Note that the system
 * keeps a record of freeze periods the device experienced previously, and combines them with
 * the new freeze periods to be set when checking the maximum freeze length and minimum freeze
 * separation constraints. As a result, freeze periods that passed validation during
 * {@link android.app.admin.SystemUpdatePolicy#setFreezePeriods SystemUpdatePolicy#setFreezePeriods} might fail the additional checks here due to
 * the freeze period history. If this is causing issues during development,
 * {@code adb shell dpm clear-freeze-period-record} can be used to clear the record.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with. All
 *            components in the device owner package can set system update policies and the most
 *            recent policy takes effect.
 * This value must never be {@code null}.
 * @param policy the new policy, or {@code null} to clear the current policy.
 * @throws java.lang.SecurityException if {@code admin} is not a device owner.
 * @throws java.lang.IllegalArgumentException if the policy type or maintenance window is not valid.
 * @throws android.app.admin.SystemUpdatePolicy.ValidationFailedException if the policy's freeze period does not
 *             meet the requirement.
 * @see android.app.admin.SystemUpdatePolicy
 * @see android.app.admin.SystemUpdatePolicy#setFreezePeriods(List)
 * @apiSince 23
 */

public void setSystemUpdatePolicy(@androidx.annotation.NonNull android.content.ComponentName admin, android.app.admin.SystemUpdatePolicy policy) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a local system update policy set previously by {@link #setSystemUpdatePolicy}.
 *
 * @return The current policy object, or {@code null} if no policy is set.
 * @apiSince 23
 */

@androidx.annotation.Nullable
public android.app.admin.SystemUpdatePolicy getSystemUpdatePolicy() { throw new RuntimeException("Stub!"); }

/**
 * Called by a device owner or profile owner of secondary users that is affiliated with the
 * device to disable the keyguard altogether.
 * <p>
 * Setting the keyguard to disabled has the same effect as choosing "None" as the screen lock
 * type. However, this call has no effect if a password, pin or pattern is currently set. If a
 * password, pin or pattern is set after the keyguard was disabled, the keyguard stops being
 * disabled.
 *
 * <p>
 * As of {@link android.os.Build.VERSION_CODES#P}, this call also dismisses the
 * keyguard if it is currently shown.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param disabled {@code true} disables the keyguard, {@code false} reenables it.
 * @return {@code false} if attempting to disable the keyguard while a lock password was in
 *         place. {@code true} otherwise.
 * @throws java.lang.SecurityException if {@code admin} is not the device owner, or a profile owner of
 * secondary user that is affiliated with the device.
 * @see #isAffiliatedUser
 * @see #getSecondaryUsers
 * @apiSince 23
 */

public boolean setKeyguardDisabled(@androidx.annotation.NonNull android.content.ComponentName admin, boolean disabled) { throw new RuntimeException("Stub!"); }

/**
 * Called by device owner or profile owner of secondary users  that is affiliated with the
 * device to disable the status bar. Disabling the status bar blocks notifications, quick
 * settings and other screen overlays that allow escaping from a single use device.
 * <p>
 * <strong>Note:</strong> This method has no effect for LockTask mode. The behavior of the
 * status bar in LockTask mode can be configured with
 * {@link #setLockTaskFeatures(android.content.ComponentName,int)}. Calls to this method when the device is in
 * LockTask mode will be registered, but will only take effect when the device leaves LockTask
 * mode.
 *
 * <p>This policy does not have any effect while on the lock screen, where the status bar will
 * not be disabled. Using LockTask instead of this method is recommended.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param disabled {@code true} disables the status bar, {@code false} reenables it.
 * @return {@code false} if attempting to disable the status bar failed. {@code true} otherwise.
 * @throws java.lang.SecurityException if {@code admin} is not the device owner, or a profile owner of
 * secondary user that is affiliated with the device.
 * @see #isAffiliatedUser
 * @see #getSecondaryUsers
 * @apiSince 23
 */

public boolean setStatusBarDisabled(@androidx.annotation.NonNull android.content.ComponentName admin, boolean disabled) { throw new RuntimeException("Stub!"); }

/**
 * Called by device or profile owners to get information about a pending system update.
 *
 * @param admin Which profile or device owner this request is associated with.
 * This value must never be {@code null}.
 * @return Information about a pending system update or {@code null} if no update pending.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @see android.app.admin.DeviceAdminReceiver#onSystemUpdatePending(Context, Intent, long)
 * @apiSince 26
 */

@androidx.annotation.Nullable
public android.app.admin.SystemUpdateInfo getPendingSystemUpdate(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Set the default response for future runtime permission requests by applications. This
 * function can be called by a device owner, profile owner, or by a delegate given the
 * {@link #DELEGATION_PERMISSION_GRANT} scope via {@link #setDelegatedScopes}.
 * The policy can allow for normal operation which prompts the user to grant a permission, or
 * can allow automatic granting or denying of runtime permission requests by an application.
 * This also applies to new permissions declared by app updates. When a permission is denied or
 * granted this way, the effect is equivalent to setting the permission * grant state via
 * {@link #setPermissionGrantState}.
 * <p/>
 * As this policy only acts on runtime permission requests, it only applies to applications
 * built with a {@code targetSdkVersion} of {@link android.os.Build.VERSION_CODES#M} or later.
 *
 * @param admin Which profile or device owner this request is associated with.
 * This value must never be {@code null}.
 * @param policy One of the policy constants {@link #PERMISSION_POLICY_PROMPT},
 *            {@link #PERMISSION_POLICY_AUTO_GRANT} and {@link #PERMISSION_POLICY_AUTO_DENY}.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @see #setPermissionGrantState
 * @see #setDelegatedScopes
 * @see #DELEGATION_PERMISSION_GRANT
 * @apiSince 23
 */

public void setPermissionPolicy(@androidx.annotation.NonNull android.content.ComponentName admin, int policy) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current runtime permission policy set by the device or profile owner. The
 * default is {@link #PERMISSION_POLICY_PROMPT}.
 *
 * @param admin Which profile or device owner this request is associated with.
 * @return the current policy for future permission requests.
 * @apiSince 23
 */

public int getPermissionPolicy(android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Sets the grant state of a runtime permission for a specific application. The state can be
 * {@link #PERMISSION_GRANT_STATE_DEFAULT default} in which a user can manage it through the UI,
 * {@link #PERMISSION_GRANT_STATE_DENIED denied}, in which the permission is denied and the user
 * cannot manage it through the UI, and {@link #PERMISSION_GRANT_STATE_GRANTED granted} in which
 * the permission is granted and the user cannot manage it through the UI. This method can only
 * be called by a profile owner, device owner, or a delegate given the
 * {@link #DELEGATION_PERMISSION_GRANT} scope via {@link #setDelegatedScopes}.
 * <p/>
 * Note that user cannot manage other permissions in the affected group through the UI
 * either and their granted state will be kept as the current value. Thus, it's recommended that
 * you set the grant state of all the permissions in the affected group.
 * <p/>
 * Setting the grant state to {@link #PERMISSION_GRANT_STATE_DEFAULT default} does not revoke
 * the permission. It retains the previous grant, if any.
 * <p/>
 * Device admins with a {@code targetSdkVersion} &lt; {@link android.os.Build.VERSION_CODES#Q}
 * cannot grant and revoke permissions for applications built with a {@code targetSdkVersion}
 * &lt; {@link android.os.Build.VERSION_CODES#M}.
 * <p/>
 * Admins with a {@code targetSdkVersion} &ge; {@link android.os.Build.VERSION_CODES#Q} can
 * grant and revoke permissions of all apps. Similar to the user revoking a permission from a
 * application built with a {@code targetSdkVersion} &lt;
 * {@link android.os.Build.VERSION_CODES#M} the app-op matching the permission is set to
 * {@link android.app.AppOpsManager#MODE_IGNORED}, but the permission stays granted.
 *
 * @param admin Which profile or device owner this request is associated with.
 * This value must never be {@code null}.
 * @param packageName The application to grant or revoke a permission to.
 * This value must never be {@code null}.
 * @param permission The permission to grant or revoke.
 * This value must never be {@code null}.
 * @param grantState The permission grant state which is one of
 *            {@link #PERMISSION_GRANT_STATE_DENIED}, {@link #PERMISSION_GRANT_STATE_DEFAULT},
 *            {@link #PERMISSION_GRANT_STATE_GRANTED},
 * Value is {@link android.app.admin.DevicePolicyManager#PERMISSION_GRANT_STATE_DEFAULT}, {@link android.app.admin.DevicePolicyManager#PERMISSION_GRANT_STATE_GRANTED}, or {@link android.app.admin.DevicePolicyManager#PERMISSION_GRANT_STATE_DENIED}
 * @return whether the permission was successfully granted or revoked.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @see #PERMISSION_GRANT_STATE_DENIED
 * @see #PERMISSION_GRANT_STATE_DEFAULT
 * @see #PERMISSION_GRANT_STATE_GRANTED
 * @see #setDelegatedScopes
 * @see #DELEGATION_PERMISSION_GRANT
 * @apiSince 23
 */

public boolean setPermissionGrantState(@androidx.annotation.NonNull android.content.ComponentName admin, @androidx.annotation.NonNull java.lang.String packageName, @androidx.annotation.NonNull java.lang.String permission, int grantState) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current grant state of a runtime permission for a specific application. This
 * function can be called by a device owner, profile owner, or by a delegate given the
 * {@link #DELEGATION_PERMISSION_GRANT} scope via {@link #setDelegatedScopes}.
 *
 * @param admin Which profile or device owner this request is associated with, or {@code null}
 *            if the caller is a permission grant delegate.
 * This value may be {@code null}.
 * @param packageName The application to check the grant state for.
 * This value must never be {@code null}.
 * @param permission The permission to check for.
 * This value must never be {@code null}.
 * @return the current grant state specified by device policy. If the profile or device owner
 *         has not set a grant state, the return value is
 *         {@link #PERMISSION_GRANT_STATE_DEFAULT}. This does not indicate whether or not the
 *         permission is currently granted for the package.
 *         <p/>
 *         If a grant state was set by the profile or device owner, then the return value will
 *         be one of {@link #PERMISSION_GRANT_STATE_DENIED} or
 *         {@link #PERMISSION_GRANT_STATE_GRANTED}, which indicates if the permission is
 *         currently denied or granted.
 * Value is {@link android.app.admin.DevicePolicyManager#PERMISSION_GRANT_STATE_DEFAULT}, {@link android.app.admin.DevicePolicyManager#PERMISSION_GRANT_STATE_GRANTED}, or {@link android.app.admin.DevicePolicyManager#PERMISSION_GRANT_STATE_DENIED}
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @see #setPermissionGrantState(ComponentName, String, String, int)
 * @see android.content.pm.PackageManager#checkPermission(String, String)
 * @see #setDelegatedScopes
 * @see #DELEGATION_PERMISSION_GRANT
 * @apiSince 23
 */

public int getPermissionGrantState(@androidx.annotation.Nullable android.content.ComponentName admin, @androidx.annotation.NonNull java.lang.String packageName, @androidx.annotation.NonNull java.lang.String permission) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether it is possible for the caller to initiate provisioning of a managed profile
 * or device, setting itself as the device or profile owner.
 *
 * @param action One of {@link #ACTION_PROVISION_MANAGED_DEVICE},
 * {@link #ACTION_PROVISION_MANAGED_PROFILE}.
 * This value must never be {@code null}.
 * @return whether provisioning a managed profile or device is possible.
 * @throws java.lang.IllegalArgumentException if the supplied action is not valid.
 * @apiSince 24
 */

public boolean isProvisioningAllowed(@androidx.annotation.NonNull java.lang.String action) { throw new RuntimeException("Stub!"); }

/**
 * Return if this user is a managed profile of another user. An admin can become the profile
 * owner of a managed profile with {@link #ACTION_PROVISION_MANAGED_PROFILE} and of a managed
 * user with {@link #createAndManageUser}
 * @param admin Which profile owner this request is associated with.
 * This value must never be {@code null}.
 * @return if this user is a managed profile of another user.
 * @apiSince 24
 */

public boolean isManagedProfile(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by device owner to get the MAC address of the Wi-Fi device.
 *
 * @param admin Which device owner this request is associated with.
 * This value must never be {@code null}.
 * @return the MAC address of the Wi-Fi device, or null when the information is not available.
 *         (For example, Wi-Fi hasn't been enabled, or the device doesn't support Wi-Fi.)
 *         <p>
 *         The address will be in the {@code XX:XX:XX:XX:XX:XX} format.
 * @throws java.lang.SecurityException if {@code admin} is not a device owner.
 * @apiSince 24
 */

@androidx.annotation.Nullable
public java.lang.String getWifiMacAddress(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by device owner to reboot the device. If there is an ongoing call on the device,
 * throws an {@link java.lang.IllegalStateException IllegalStateException}.
 * @param admin Which device owner the request is associated with.
 * This value must never be {@code null}.
 * @throws java.lang.IllegalStateException if device has an ongoing call.
 * @throws java.lang.SecurityException if {@code admin} is not a device owner.
 * @see android.telephony.TelephonyManager#CALL_STATE_IDLE
 * @apiSince 24
 */

public void reboot(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by a device admin to set the short support message. This will be displayed to the user
 * in settings screens where funtionality has been disabled by the admin. The message should be
 * limited to a short statement such as "This setting is disabled by your administrator. Contact
 * someone@example.com for support." If the message is longer than 200 characters it may be
 * truncated.
 * <p>
 * If the short support message needs to be localized, it is the responsibility of the
 * {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} to listen to the {@link android.content.Intent#ACTION_LOCALE_CHANGED Intent#ACTION_LOCALE_CHANGED} broadcast
 * and set a new version of this string accordingly.
 *
 * @see #setLongSupportMessage
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param message Short message to be displayed to the user in settings or null to clear the
 *            existing message.
 * This value may be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not an active administrator.
 * @apiSince 24
 */

public void setShortSupportMessage(@androidx.annotation.NonNull android.content.ComponentName admin, @androidx.annotation.Nullable java.lang.CharSequence message) { throw new RuntimeException("Stub!"); }

/**
 * Called by a device admin to get the short support message.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @return The message set by {@link #setShortSupportMessage(android.content.ComponentName,java.lang.CharSequence)} or
 *         null if no message has been set.
 * @throws java.lang.SecurityException if {@code admin} is not an active administrator.
 * @apiSince 24
 */

public java.lang.CharSequence getShortSupportMessage(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by a device admin to set the long support message. This will be displayed to the user
 * in the device administators settings screen.
 * <p>
 * If the long support message needs to be localized, it is the responsibility of the
 * {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} to listen to the {@link android.content.Intent#ACTION_LOCALE_CHANGED Intent#ACTION_LOCALE_CHANGED} broadcast
 * and set a new version of this string accordingly.
 *
 * @see #setShortSupportMessage
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param message Long message to be displayed to the user in settings or null to clear the
 *            existing message.
 * This value may be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not an active administrator.
 * @apiSince 24
 */

public void setLongSupportMessage(@androidx.annotation.NonNull android.content.ComponentName admin, @androidx.annotation.Nullable java.lang.CharSequence message) { throw new RuntimeException("Stub!"); }

/**
 * Called by a device admin to get the long support message.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @return The message set by {@link #setLongSupportMessage(android.content.ComponentName,java.lang.CharSequence)} or
 *         null if no message has been set.
 * @throws java.lang.SecurityException if {@code admin} is not an active administrator.
 * @apiSince 24
 */

@androidx.annotation.Nullable
public java.lang.CharSequence getLongSupportMessage(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by the profile owner of a managed profile to obtain a {@link android.app.admin.DevicePolicyManager DevicePolicyManager}
 * whose calls act on the parent profile.
 *
 * <p>The following methods are supported for the parent instance, all other methods will
 * throw a SecurityException when called on the parent instance:
 * <ul>
 * <li>{@link #getPasswordQuality}</li>
 * <li>{@link #setPasswordQuality}</li>
 * <li>{@link #getPasswordMinimumLength}</li>
 * <li>{@link #setPasswordMinimumLength}</li>
 * <li>{@link #getPasswordMinimumUpperCase}</li>
 * <li>{@link #setPasswordMinimumUpperCase}</li>
 * <li>{@link #getPasswordMinimumLowerCase}</li>
 * <li>{@link #setPasswordMinimumLowerCase}</li>
 * <li>{@link #getPasswordMinimumLetters}</li>
 * <li>{@link #setPasswordMinimumLetters}</li>
 * <li>{@link #getPasswordMinimumNumeric}</li>
 * <li>{@link #setPasswordMinimumNumeric}</li>
 * <li>{@link #getPasswordMinimumSymbols}</li>
 * <li>{@link #setPasswordMinimumSymbols}</li>
 * <li>{@link #getPasswordMinimumNonLetter}</li>
 * <li>{@link #setPasswordMinimumNonLetter}</li>
 * <li>{@link #getPasswordHistoryLength}</li>
 * <li>{@link #setPasswordHistoryLength}</li>
 * <li>{@link #getPasswordExpirationTimeout}</li>
 * <li>{@link #setPasswordExpirationTimeout}</li>
 * <li>{@link #getPasswordExpiration}</li>
 * <li>{@link #getPasswordMaximumLength}</li>
 * <li>{@link #isActivePasswordSufficient}</li>
 * <li>{@link #getCurrentFailedPasswordAttempts}</li>
 * <li>{@link #getMaximumFailedPasswordsForWipe}</li>
 * <li>{@link #setMaximumFailedPasswordsForWipe}</li>
 * <li>{@link #getMaximumTimeToLock}</li>
 * <li>{@link #setMaximumTimeToLock}</li>
 * <li>{@link #lockNow}</li>
 * <li>{@link #getKeyguardDisabledFeatures}</li>
 * <li>{@link #setKeyguardDisabledFeatures}</li>
 * <li>{@link #getTrustAgentConfiguration}</li>
 * <li>{@link #setTrustAgentConfiguration}</li>
 * <li>{@link #getRequiredStrongAuthTimeout}</li>
 * <li>{@link #setRequiredStrongAuthTimeout}</li>
 * </ul>
 *
 * @param admin This value must never be {@code null}.
 * @return a new instance of {@link android.app.admin.DevicePolicyManager DevicePolicyManager} that acts on the parent profile.
 * This value will never be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not a profile owner.
 * @apiSince 24
 */

@androidx.annotation.NonNull
public android.app.admin.DevicePolicyManager getParentProfileInstance(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by device owner to control the security logging feature.
 *
 * <p> Security logs contain various information intended for security auditing purposes.
 * See {@link android.app.admin.SecurityLog.SecurityEvent SecurityEvent} for details.
 *
 * <p><strong>Note:</strong> The device owner won't be able to retrieve security logs if there
 * are unaffiliated secondary users or profiles on the device, regardless of whether the
 * feature is enabled. Logs will be discarded if the internal buffer fills up while waiting for
 * all users to become affiliated. Therefore it's recommended that affiliation ids are set for
 * new users as soon as possible after provisioning via {@link #setAffiliationIds}.
 *
 * @param admin Which device owner this request is associated with.
 * This value must never be {@code null}.
 * @param enabled whether security logging should be enabled or not.
 * @throws java.lang.SecurityException if {@code admin} is not a device owner.
 * @see #setAffiliationIds
 * @see #retrieveSecurityLogs
 * @apiSince 24
 */

public void setSecurityLoggingEnabled(@androidx.annotation.NonNull android.content.ComponentName admin, boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Return whether security logging is enabled or not by the device owner.
 *
 * <p>Can only be called by the device owner, otherwise a {@link java.lang.SecurityException SecurityException} will be
 * thrown.
 *
 * @param admin Which device owner this request is associated with.
 * This value may be {@code null}.
 * @return {@code true} if security logging is enabled by device owner, {@code false} otherwise.
 * @throws java.lang.SecurityException if {@code admin} is not a device owner.
 * @apiSince 24
 */

public boolean isSecurityLoggingEnabled(@androidx.annotation.Nullable android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by device owner to retrieve all new security logging entries since the last call to
 * this API after device boots.
 *
 * <p> Access to the logs is rate limited and it will only return new logs after the device
 * owner has been notified via {@link android.app.admin.DeviceAdminReceiver#onSecurityLogsAvailable DeviceAdminReceiver#onSecurityLogsAvailable}.
 *
 * <p>If there is any other user or profile on the device, it must be affiliated with the
 * device. Otherwise a {@link java.lang.SecurityException SecurityException} will be thrown. See {@link #isAffiliatedUser}.
 *
 * @param admin Which device owner this request is associated with.
 * This value must never be {@code null}.
 * @return the new batch of security logs which is a list of {@link android.app.admin.SecurityLog.SecurityEvent SecurityEvent},
 * or {@code null} if rate limitation is exceeded or if logging is currently disabled.
 * @throws java.lang.SecurityException if {@code admin} is not a device owner, or there is at least one
 * profile or secondary user that is not affiliated with the device.
 * @see #isAffiliatedUser
 * @see android.app.admin.DeviceAdminReceiver#onSecurityLogsAvailable
 * @apiSince 24
 */

@androidx.annotation.Nullable
public java.util.List<android.app.admin.SecurityLog.SecurityEvent> retrieveSecurityLogs(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by a device or profile owner to restrict packages from using metered data.
 *
 * @param admin which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param packageNames the list of package names to be restricted.
 * This value must never be {@code null}.
 * @return a list of package names which could not be restricted.
 * This value will never be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.util.List<java.lang.String> setMeteredDataDisabledPackages(@androidx.annotation.NonNull android.content.ComponentName admin, @androidx.annotation.NonNull java.util.List<java.lang.String> packageNames) { throw new RuntimeException("Stub!"); }

/**
 * Called by a device or profile owner to retrieve the list of packages which are restricted
 * by the admin from using metered data.
 *
 * @param admin which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @return the list of restricted package names.
 * This value will never be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.util.List<java.lang.String> getMeteredDataDisabledPackages(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by device owners to retrieve device logs from before the device's last reboot.
 * <p>
 * <strong> This API is not supported on all devices. Calling this API on unsupported devices
 * will result in {@code null} being returned. The device logs are retrieved from a RAM region
 * which is not guaranteed to be corruption-free during power cycles, as a result be cautious
 * about data corruption when parsing. </strong>
 *
 * <p>If there is any other user or profile on the device, it must be affiliated with the
 * device. Otherwise a {@link java.lang.SecurityException SecurityException} will be thrown. See {@link #isAffiliatedUser}.
 *
 * @param admin Which device owner this request is associated with.
 * This value must never be {@code null}.
 * @return Device logs from before the latest reboot of the system, or {@code null} if this API
 *         is not supported on the device.
 * @throws java.lang.SecurityException if {@code admin} is not a device owner, or there is at least one
 * profile or secondary user that is not affiliated with the device.
 * @see #isAffiliatedUser
 * @see #retrieveSecurityLogs
 * @apiSince 24
 */

@androidx.annotation.Nullable
public java.util.List<android.app.admin.SecurityLog.SecurityEvent> retrievePreRebootSecurityLogs(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by a profile owner of a managed profile to set the color used for customization. This
 * color is used as background color of the confirm credentials screen for that user. The
 * default color is teal (#00796B).
 * <p>
 * The confirm credentials screen can be created using
 * {@link android.app.KeyguardManager#createConfirmDeviceCredentialIntent}.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param color The 24bit (0xRRGGBB) representation of the color to be used.
 * @throws java.lang.SecurityException if {@code admin} is not a profile owner.
 * @apiSince 24
 */

public void setOrganizationColor(@androidx.annotation.NonNull android.content.ComponentName admin, int color) { throw new RuntimeException("Stub!"); }

/**
 * Called by a profile owner of a managed profile to retrieve the color used for customization.
 * This color is used as background color of the confirm credentials screen for that user.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @return The 24bit (0xRRGGBB) representation of the color to be used.
 * @throws java.lang.SecurityException if {@code admin} is not a profile owner.
 * @apiSince 24
 */

public int getOrganizationColor(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by the device owner (since API 26) or profile owner (since API 24) to set the name of
 * the organization under management.
 *
 * <p>If the organization name needs to be localized, it is the responsibility of the {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} to listen to the {@link android.content.Intent#ACTION_LOCALE_CHANGED Intent#ACTION_LOCALE_CHANGED} broadcast and set
 * a new version of this string accordingly.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param title The organization name or {@code null} to clear a previously set name.
 * This value may be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not a device or profile owner.
 * @apiSince 24
 */

public void setOrganizationName(@androidx.annotation.NonNull android.content.ComponentName admin, @androidx.annotation.Nullable java.lang.CharSequence title) { throw new RuntimeException("Stub!"); }

/**
 * Called by a profile owner of a managed profile to retrieve the name of the organization under
 * management.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @return The organization name or {@code null} if none is set.
 * @throws java.lang.SecurityException if {@code admin} is not a profile owner.
 * @apiSince 24
 */

@androidx.annotation.Nullable
public java.lang.CharSequence getOrganizationName(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Indicates the entity that controls the device or profile owner. Two users/profiles are
 * affiliated if the set of ids set by their device or profile owners intersect.
 *
 * <p>A user/profile that is affiliated with the device owner user is considered to be
 * affiliated with the device.
 *
 * <p><strong>Note:</strong> Features that depend on user affiliation (such as security logging
 * or {@link #bindDeviceAdminServiceAsUser}) won't be available when a secondary user or profile
 * is created, until it becomes affiliated. Therefore it is recommended that the appropriate
 * affiliation ids are set by its profile owner as soon as possible after the user/profile is
 * created.
 *
 * @param admin Which profile or device owner this request is associated with.
 * This value must never be {@code null}.
 * @param ids A set of opaque non-empty affiliation ids.
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if {@code ids} is null or contains an empty string.
 * @see #isAffiliatedUser
 * @apiSince 26
 */

public void setAffiliationIds(@androidx.annotation.NonNull android.content.ComponentName admin, @androidx.annotation.NonNull java.util.Set<java.lang.String> ids) { throw new RuntimeException("Stub!"); }

/**
 * Returns the set of affiliation ids previously set via {@link #setAffiliationIds}, or an
 * empty set if none have been set.
 
 * @param admin This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public java.util.Set<java.lang.String> getAffiliationIds(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether this user/profile is affiliated with the device.
 * <p>
 * By definition, the user that the device owner runs on is always affiliated with the device.
 * Any other user/profile is considered affiliated with the device if the set specified by its
 * profile owner via {@link #setAffiliationIds} intersects with the device owner's.
 * @see #setAffiliationIds
 * @apiSince 28
 */

public boolean isAffiliatedUser() { throw new RuntimeException("Stub!"); }

/**
 * Allows the device owner or profile owner to enable or disable the backup service.
 *
 * <p> Each user has its own backup service which manages the backup and restore mechanisms in
 * that user. Disabling the backup service will prevent data from being backed up or restored.
 *
 * <p> Device owner calls this API to control backup services across all users on the device.
 * Profile owner can use this API to enable or disable the profile's backup service. However,
 * for a managed profile its backup functionality is only enabled if both the device owner
 * and the profile owner have enabled the backup service.
 *
 * <p> By default, backup service is disabled on a device with device owner, and within a
 * managed profile.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param enabled {@code true} to enable the backup service, {@code false} to disable it.
 * @throws java.lang.SecurityException if {@code admin} is not a device owner or a profile owner.
 * @apiSince 26
 */

public void setBackupServiceEnabled(@androidx.annotation.NonNull android.content.ComponentName admin, boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Return whether the backup service is enabled by the device owner or profile owner for the
 * current user, as previously set by {@link #setBackupServiceEnabled(android.content.ComponentName,boolean)}.
 *
 * <p> Whether the backup functionality is actually enabled or not depends on settings from both
 * the current user and the device owner, please see
 * {@link #setBackupServiceEnabled(android.content.ComponentName,boolean)} for details.
 *
 * <p> Backup service manages all backup and restore mechanisms on the device.
 *
 * @param admin This value must never be {@code null}.
 * @return {@code true} if backup service is enabled, {@code false} otherwise.
 * @see #setBackupServiceEnabled
 * @apiSince 26
 */

public boolean isBackupServiceEnabled(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by a device owner or delegated app with {@link #DELEGATION_NETWORK_LOGGING} to
 * control the network logging feature.
 *
 * <p> Network logs contain DNS lookup and connect() library call events. The following library
 *     functions are recorded while network logging is active:
 *     <ul>
 *       <li>{@code getaddrinfo()}</li>
 *       <li>{@code gethostbyname()}</li>
 *       <li>{@code connect()}</li>
 *     </ul>
 *
 * <p> Network logging is a low-overhead tool for forensics but it is not guaranteed to use
 *     full system call logging; event reporting is enabled by default for all processes but not
 *     strongly enforced.
 *     Events from applications using alternative implementations of libc, making direct kernel
 *     calls, or deliberately obfuscating traffic may not be recorded.
 *
 * <p> Some common network events may not be reported. For example:
 *     <ul>
 *       <li>Applications may hardcode IP addresses to reduce the number of DNS lookups, or use
 *           an alternative system for name resolution, and so avoid calling
 *           {@code getaddrinfo()} or {@code gethostbyname}.</li>
 *       <li>Applications may use datagram sockets for performance reasons, for example
 *           for a game client. Calling {@code connect()} is unnecessary for this kind of
 *           socket, so it will not trigger a network event.</li>
 *     </ul>
 *
 * <p> It is possible to directly intercept layer 3 traffic leaving the device using an
 *     always-on VPN service.
 *     See {@link #setAlwaysOnVpnPackage(android.content.ComponentName,java.lang.String,boolean)}
 *     and {@link android.net.VpnService} for details.
 *
 * <p><strong>Note:</strong> The device owner won't be able to retrieve network logs if there
 * are unaffiliated secondary users or profiles on the device, regardless of whether the
 * feature is enabled. Logs will be discarded if the internal buffer fills up while waiting for
 * all users to become affiliated. Therefore it's recommended that affiliation ids are set for
 * new users as soon as possible after provisioning via {@link #setAffiliationIds}.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with, or
 *        {@code null} if called by a delegated app.
 * This value may be {@code null}.
 * @param enabled whether network logging should be enabled or not.
 * @throws java.lang.SecurityException if {@code admin} is not a device owner.
 * @see #setAffiliationIds
 * @see #retrieveNetworkLogs
 * @apiSince 26
 */

public void setNetworkLoggingEnabled(@androidx.annotation.Nullable android.content.ComponentName admin, boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Return whether network logging is enabled by a device owner.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with. Can only
 * be {@code null} if the caller is a delegated app with {@link #DELEGATION_NETWORK_LOGGING}
 * or has MANAGE_USERS permission.
 * This value may be {@code null}.
 * @return {@code true} if network logging is enabled by device owner, {@code false} otherwise.
 * @throws java.lang.SecurityException if {@code admin} is not a device owner and caller has
 * no MANAGE_USERS permission
 * @apiSince 26
 */

public boolean isNetworkLoggingEnabled(@androidx.annotation.Nullable android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by device owner or delegated app with {@link #DELEGATION_NETWORK_LOGGING} to retrieve
 * the most recent batch of network logging events.
 * A device owner has to provide a batchToken provided as part of
 * {@link android.app.admin.DeviceAdminReceiver#onNetworkLogsAvailable DeviceAdminReceiver#onNetworkLogsAvailable} callback. If the token doesn't match the
 * token of the most recent available batch of logs, {@code null} will be returned.
 *
 * <p> {@link android.app.admin.NetworkEvent NetworkEvent} can be one of {@link android.app.admin.DnsEvent DnsEvent} or {@link android.app.admin.ConnectEvent ConnectEvent}.
 *
 * <p> The list of network events is sorted chronologically, and contains at most 1200 events.
 *
 * <p> Access to the logs is rate limited and this method will only return a new batch of logs
 * after the device device owner has been notified via
 * {@link android.app.admin.DeviceAdminReceiver#onNetworkLogsAvailable DeviceAdminReceiver#onNetworkLogsAvailable}.
 *
 * <p>If a secondary user or profile is created, calling this method will throw a
 * {@link java.lang.SecurityException SecurityException} until all users become affiliated again. It will also no longer be
 * possible to retrieve the network logs batch with the most recent batchToken provided
 * by {@link android.app.admin.DeviceAdminReceiver#onNetworkLogsAvailable DeviceAdminReceiver#onNetworkLogsAvailable}. See
 * {@link android.app.admin.DevicePolicyManager#setAffiliationIds DevicePolicyManager#setAffiliationIds}.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with, or
 *        {@code null} if called by a delegated app.
 * This value may be {@code null}.
 * @param batchToken A token of the batch to retrieve
 * @return A new batch of network logs which is a list of {@link android.app.admin.NetworkEvent NetworkEvent}. Returns
 *        {@code null} if the batch represented by batchToken is no longer available or if
 *        logging is disabled.
 * @throws java.lang.SecurityException if {@code admin} is not a device owner, or there is at least one
 * profile or secondary user that is not affiliated with the device.
 * @see #setAffiliationIds
 * @see android.app.admin.DeviceAdminReceiver#onNetworkLogsAvailable
 * @apiSince 26
 */

@androidx.annotation.Nullable
public java.util.List<android.app.admin.NetworkEvent> retrieveNetworkLogs(@androidx.annotation.Nullable android.content.ComponentName admin, long batchToken) { throw new RuntimeException("Stub!"); }

/**
 * Called by a device owner to bind to a service from a profile owner or vice versa.
 * See {@link #getBindDeviceAdminTargetUsers} for a definition of which
 * device/profile owners are allowed to bind to services of another profile/device owner.
 * <p>
 * The service must be protected by {@link android.Manifest.permission#BIND_DEVICE_ADMIN}.
 * Note that the {@link android.content.Context Context} used to obtain this
 * {@link android.app.admin.DevicePolicyManager DevicePolicyManager} instance via {@link android.content.Context#getSystemService(java.lang.Class) Context#getSystemService(Class)} will be used
 * to bind to the {@link android.app.Service}.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param serviceIntent Identifies the service to connect to.  The Intent must specify either an
 *        explicit component name or a package name to match an
 *        {@link android.content.IntentFilter IntentFilter} published by a service.
 * @param conn Receives information as the service is started and stopped in main thread. This
 *        must be a valid {@link android.content.ServiceConnection ServiceConnection} object; it must not be {@code null}.
 * This value must never be {@code null}.
 * @param flags Operation options for the binding operation. See
 *        {@link android.content.Context#bindService(android.content.Intent,android.content.ServiceConnection,int) Context#bindService(Intent, ServiceConnection, int)}.
 * Value is either <code>0</code> or a combination of {@link android.content.Context#BIND_AUTO_CREATE}, {@link android.content.Context#BIND_DEBUG_UNBIND}, {@link android.content.Context#BIND_NOT_FOREGROUND}, {@link android.content.Context#BIND_ABOVE_CLIENT}, {@link android.content.Context#BIND_ALLOW_OOM_MANAGEMENT}, {@link android.content.Context#BIND_WAIVE_PRIORITY}, {@link android.content.Context#BIND_IMPORTANT}, {@link android.content.Context#BIND_ADJUST_WITH_ACTIVITY}, {@link android.content.Context#BIND_NOT_PERCEPTIBLE}, and {@link android.content.Context#BIND_INCLUDE_CAPABILITIES}
 * @param targetUser Which user to bind to. Must be one of the users returned by
 *        {@link #getBindDeviceAdminTargetUsers}, otherwise a {@link java.lang.SecurityException SecurityException} will
 *        be thrown.
 * This value must never be {@code null}.
 * @return If you have successfully bound to the service, {@code true} is returned;
 *         {@code false} is returned if the connection is not made and you will not
 *         receive the service object.
 *
 * @see android.content.Context#bindService(Intent, ServiceConnection, int)
 * @see #getBindDeviceAdminTargetUsers(ComponentName)
 * @apiSince 26
 */

public boolean bindDeviceAdminServiceAsUser(@androidx.annotation.NonNull android.content.ComponentName admin, android.content.Intent serviceIntent, @androidx.annotation.NonNull android.content.ServiceConnection conn, int flags, @androidx.annotation.NonNull android.os.UserHandle targetUser) { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of target users that the calling device or profile owner can use when
 * calling {@link #bindDeviceAdminServiceAsUser}.
 * <p>
 * A device owner can bind to a service from a profile owner and vice versa, provided that:
 * <ul>
 * <li>Both belong to the same package name.
 * <li>Both users are affiliated. See {@link #setAffiliationIds}.
 * </ul>
 
 * @param admin This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public java.util.List<android.os.UserHandle> getBindDeviceAdminTargetUsers(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by the device owner or profile owner to clear application user data of a given
 * package. The behaviour of this is equivalent to the target application calling
 * {@link android.app.ActivityManager#clearApplicationUserData()}.
 *
 * <p><strong>Note:</strong> an application can store data outside of its application data, e.g.
 * external storage or user dictionary. This data will not be wiped by calling this API.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param packageName The name of the package which will have its user data wiped.
 * This value must never be {@code null}.
 * @param executor The executor through which the listener should be invoked.
 * This value must never be {@code null}.
 * Callback and listener events are dispatched through this
 * {@link java.util.concurrent.Executor Executor}, providing an easy way to control which thread is
 * used. To dispatch events through the main thread of your
 * application, you can use {@link android.content.Context#getMainExecutor() Context#getMainExecutor()}. To
 * dispatch events through a shared thread pool, you can use
 * {@link android.os.AsyncTask#THREAD_POOL_EXECUTOR AsyncTask#THREAD_POOL_EXECUTOR}.
 * @param listener A callback object that will inform the caller when the clearing is done.
 * This value must never be {@code null}.
 * @throws java.lang.SecurityException if the caller is not the device owner/profile owner.
 * @apiSince 28
 */

public void clearApplicationUserData(@androidx.annotation.NonNull android.content.ComponentName admin, @androidx.annotation.NonNull java.lang.String packageName, @androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull android.app.admin.DevicePolicyManager.OnClearApplicationUserDataListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Called by a device owner to specify whether logout is enabled for all secondary users. The
 * system may show a logout button that stops the user and switches back to the primary user.
 *
 * @param admin Which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param enabled whether logout should be enabled or not.
 * @throws java.lang.SecurityException if {@code admin} is not a device owner.
 * @apiSince 28
 */

public void setLogoutEnabled(@androidx.annotation.NonNull android.content.ComponentName admin, boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether logout is enabled by a device owner.
 *
 * @return {@code true} if logout is enabled by device owner, {@code false} otherwise.
 * @apiSince 28
 */

public boolean isLogoutEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Changes the current administrator to another one. All policies from the current
 * administrator are migrated to the new administrator. The whole operation is atomic -
 * the transfer is either complete or not done at all.
 *
 * <p>Depending on the current administrator (device owner, profile owner), you have the
 * following expected behaviour:
 * <ul>
 *     <li>A device owner can only be transferred to a new device owner</li>
 *     <li>A profile owner can only be transferred to a new profile owner</li>
 * </ul>
 *
 * <p>Use the {@code bundle} parameter to pass data to the new administrator. The data
 * will be received in the
 * {@link android.app.admin.DeviceAdminReceiver#onTransferOwnershipComplete(android.content.Context,android.os.PersistableBundle) DeviceAdminReceiver#onTransferOwnershipComplete(Context, PersistableBundle)}
 * callback of the new administrator.
 *
 * <p>The transfer has failed if the original administrator is still the corresponding owner
 * after calling this method.
 *
 * <p>The incoming target administrator must have the
 * <code>&lt;support-transfer-ownership /&gt;</code> tag inside the
 * <code>&lt;device-admin&gt;&lt;/device-admin&gt;</code> tags in the xml file referenced by
 * {@link android.app.admin.DeviceAdminReceiver#DEVICE_ADMIN_META_DATA DeviceAdminReceiver#DEVICE_ADMIN_META_DATA}. Otherwise an
 * {@link java.lang.IllegalArgumentException IllegalArgumentException} will be thrown.
 *
 * @param admin which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with
 * This value must never be {@code null}.
 * @param target which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} we want the new administrator to be
 * This value must never be {@code null}.
 * @param bundle data to be sent to the new administrator
 * This value may be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not a device owner nor a profile owner
 * @throws java.lang.IllegalArgumentException if {@code admin} or {@code target} is {@code null}, they
 * are components in the same package or {@code target} is not an active admin
 * @apiSince 28
 */

public void transferOwnership(@androidx.annotation.NonNull android.content.ComponentName admin, @androidx.annotation.NonNull android.content.ComponentName target, @androidx.annotation.Nullable android.os.PersistableBundle bundle) { throw new RuntimeException("Stub!"); }

/**
 * Called by a device owner to specify the user session start message. This may be displayed
 * during a user switch.
 * <p>
 * The message should be limited to a short statement or it may be truncated.
 * <p>
 * If the message needs to be localized, it is the responsibility of the
 * {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} to listen to the {@link android.content.Intent#ACTION_LOCALE_CHANGED Intent#ACTION_LOCALE_CHANGED} broadcast
 * and set a new version of this message accordingly.
 *
 * @param admin which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param startUserSessionMessage message for starting user session, or {@code null} to use
 * system default message.
 * This value may be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not a device owner.
 * @apiSince 28
 */

public void setStartUserSessionMessage(@androidx.annotation.NonNull android.content.ComponentName admin, @androidx.annotation.Nullable java.lang.CharSequence startUserSessionMessage) { throw new RuntimeException("Stub!"); }

/**
 * Called by a device owner to specify the user session end message. This may be displayed
 * during a user switch.
 * <p>
 * The message should be limited to a short statement or it may be truncated.
 * <p>
 * If the message needs to be localized, it is the responsibility of the
 * {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} to listen to the {@link android.content.Intent#ACTION_LOCALE_CHANGED Intent#ACTION_LOCALE_CHANGED} broadcast
 * and set a new version of this message accordingly.
 *
 * @param admin which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param endUserSessionMessage message for ending user session, or {@code null} to use system
 * default message.
 * This value may be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not a device owner.
 * @apiSince 28
 */

public void setEndUserSessionMessage(@androidx.annotation.NonNull android.content.ComponentName admin, @androidx.annotation.Nullable java.lang.CharSequence endUserSessionMessage) { throw new RuntimeException("Stub!"); }

/**
 * Returns the user session start message.
 *
 * @param admin which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not a device owner.
 * @apiSince 28
 */

public java.lang.CharSequence getStartUserSessionMessage(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Returns the user session end message.
 *
 * @param admin which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not a device owner.
 * @apiSince 28
 */

public java.lang.CharSequence getEndUserSessionMessage(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by device owner to add an override APN.
 *
 * <p>This method may returns {@code -1} if {@code apnSetting} conflicts with an existing
 * override APN. Update the existing conflicted APN with
 * {@link #updateOverrideApn(android.content.ComponentName,int,android.telephony.data.ApnSetting)} instead of adding a new entry.
 * <p>Two override APNs are considered to conflict when all the following APIs return
 * the same values on both override APNs:
 * <ul>
 *   <li>{@link android.telephony.data.ApnSetting#getOperatorNumeric() ApnSetting#getOperatorNumeric()}</li>
 *   <li>{@link android.telephony.data.ApnSetting#getApnName() ApnSetting#getApnName()}</li>
 *   <li>{@link android.telephony.data.ApnSetting#getProxyAddressAsString() ApnSetting#getProxyAddressAsString()}</li>
 *   <li>{@link android.telephony.data.ApnSetting#getProxyPort() ApnSetting#getProxyPort()}</li>
 *   <li>{@link android.telephony.data.ApnSetting#getMmsProxyAddressAsString() ApnSetting#getMmsProxyAddressAsString()}</li>
 *   <li>{@link android.telephony.data.ApnSetting#getMmsProxyPort() ApnSetting#getMmsProxyPort()}</li>
 *   <li>{@link android.telephony.data.ApnSetting#getMmsc() ApnSetting#getMmsc()}</li>
 *   <li>{@link android.telephony.data.ApnSetting#isEnabled() ApnSetting#isEnabled()}</li>
 *   <li>{@link android.telephony.data.ApnSetting#getMvnoType() ApnSetting#getMvnoType()}</li>
 *   <li>{@link android.telephony.data.ApnSetting#getProtocol() ApnSetting#getProtocol()}</li>
 *   <li>{@link android.telephony.data.ApnSetting#getRoamingProtocol() ApnSetting#getRoamingProtocol()}</li>
 * </ul>
 *
 * @param admin which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with
 * This value must never be {@code null}.
 * @param apnSetting the override APN to insert
 * This value must never be {@code null}.
 * @return The {@code id} of inserted override APN. Or {@code -1} when failed to insert into
 *         the database.
 * @throws java.lang.SecurityException if {@code admin} is not a device owner.
 *
 * @see #setOverrideApnsEnabled(ComponentName, boolean)
 * @apiSince 28
 */

public int addOverrideApn(@androidx.annotation.NonNull android.content.ComponentName admin, @androidx.annotation.NonNull android.telephony.data.ApnSetting apnSetting) { throw new RuntimeException("Stub!"); }

/**
 * Called by device owner to update an override APN.
 *
 * <p>This method may returns {@code false} if there is no override APN with the given
 * {@code apnId}.
 * <p>This method may also returns {@code false} if {@code apnSetting} conflicts with an
 * existing override APN. Update the existing conflicted APN instead.
 * <p>See {@link #addOverrideApn} for the definition of conflict.
 *
 * @param admin which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with
 * This value must never be {@code null}.
 * @param apnId the {@code id} of the override APN to update
 * @param apnSetting the override APN to update
 * This value must never be {@code null}.
 * @return {@code true} if the required override APN is successfully updated,
 *         {@code false} otherwise.
 * @throws java.lang.SecurityException if {@code admin} is not a device owner.
 *
 * @see #setOverrideApnsEnabled(ComponentName, boolean)
 * @apiSince 28
 */

public boolean updateOverrideApn(@androidx.annotation.NonNull android.content.ComponentName admin, int apnId, @androidx.annotation.NonNull android.telephony.data.ApnSetting apnSetting) { throw new RuntimeException("Stub!"); }

/**
 * Called by device owner to remove an override APN.
 *
 * <p>This method may returns {@code false} if there is no override APN with the given
 * {@code apnId}.
 *
 * @param admin which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with
 * This value must never be {@code null}.
 * @param apnId the {@code id} of the override APN to remove
 * @return {@code true} if the required override APN is successfully removed, {@code false}
 *         otherwise.
 * @throws java.lang.SecurityException if {@code admin} is not a device owner.
 *
 * @see #setOverrideApnsEnabled(ComponentName, boolean)
 * @apiSince 28
 */

public boolean removeOverrideApn(@androidx.annotation.NonNull android.content.ComponentName admin, int apnId) { throw new RuntimeException("Stub!"); }

/**
 * Called by device owner to get all override APNs inserted by device owner.
 *
 * @param admin which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with
 * This value must never be {@code null}.
 * @return A list of override APNs inserted by device owner.
 * @throws java.lang.SecurityException if {@code admin} is not a device owner.
 *
 * @see #setOverrideApnsEnabled(ComponentName, boolean)
 * @apiSince 28
 */

public java.util.List<android.telephony.data.ApnSetting> getOverrideApns(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Called by device owner to set if override APNs should be enabled.
 * <p> Override APNs are separated from other APNs on the device, and can only be inserted or
 * modified by the device owner. When enabled, only override APNs are in use, any other APNs
 * are ignored.
 *
 * @param admin which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with
 * This value must never be {@code null}.
 * @param enabled {@code true} if override APNs should be enabled, {@code false} otherwise
 * @throws java.lang.SecurityException if {@code admin} is not a device owner.
 * @apiSince 28
 */

public void setOverrideApnsEnabled(@androidx.annotation.NonNull android.content.ComponentName admin, boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Called by device owner to check if override APNs are currently enabled.
 *
 * @param admin which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with
 * This value must never be {@code null}.
 * @return {@code true} if override APNs are currently enabled, {@code false} otherwise.
 * @throws java.lang.SecurityException if {@code admin} is not a device owner.
 *
 * @see #setOverrideApnsEnabled(ComponentName, boolean)
 * @apiSince 28
 */

public boolean isOverrideApnEnabled(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Returns the data passed from the current administrator to the new administrator during an
 * ownership transfer. This is the same {@code bundle} passed in
 * {@link #transferOwnership(android.content.ComponentName,android.content.ComponentName,android.os.PersistableBundle)}. The bundle is
 * persisted until the profile owner or device owner is removed.
 *
 * <p>This is the same <code>bundle</code> received in the
 * {@link android.app.admin.DeviceAdminReceiver#onTransferOwnershipComplete(android.content.Context,android.os.PersistableBundle) DeviceAdminReceiver#onTransferOwnershipComplete(Context, PersistableBundle)}.
 * Use this method to retrieve it after the transfer as long as the new administrator is the
 * active device or profile owner.
 *
 * <p>Returns <code>null</code> if no ownership transfer was started for the calling user.
 *
 * @see #transferOwnership
 * @see android.app.admin.DeviceAdminReceiver#onTransferOwnershipComplete(Context, PersistableBundle)
 * @throws java.lang.SecurityException if the caller is not a device or profile owner.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public android.os.PersistableBundle getTransferOwnershipBundle() { throw new RuntimeException("Stub!"); }

/**
 * Sets the global Private DNS mode to opportunistic.
 * May only be called by the device owner.
 *
 * <p>In this mode, the DNS subsystem will attempt a TLS handshake to the network-supplied
 * resolver prior to attempting name resolution in cleartext.
 *
 * @param admin which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 *
 * This value must never be {@code null}.
 * @return {@code PRIVATE_DNS_SET_NO_ERROR} if the mode was set successfully, or
 *         {@code PRIVATE_DNS_SET_ERROR_FAILURE_SETTING} if it could not be set.
 *
 * Value is {@link android.app.admin.DevicePolicyManager#PRIVATE_DNS_SET_NO_ERROR}, {@link android.app.admin.DevicePolicyManager#PRIVATE_DNS_SET_ERROR_HOST_NOT_SERVING}, or {@link android.app.admin.DevicePolicyManager#PRIVATE_DNS_SET_ERROR_FAILURE_SETTING}
 * @throws java.lang.SecurityException if the caller is not the device owner.
 * @apiSince 29
 */

public int setGlobalPrivateDnsModeOpportunistic(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Sets the global Private DNS host to be used.
 * May only be called by the device owner.
 *
 * <p>Note that the method is blocking as it will perform a connectivity check to the resolver,
 * to ensure it is valid. Because of that, the method should not be called on any thread that
 * relates to user interaction, such as the UI thread.
 *
 * <p>In case a VPN is used in conjunction with Private DNS resolver, the Private DNS resolver
 * must be reachable both from within and outside the VPN. Otherwise, the device may lose
 * the ability to resolve hostnames as system traffic to the resolver may not go through the
 * VPN.
 *
 * <br>
 * This method may take several seconds to complete, so it should
 * only be called from a worker thread.
 * @param admin which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @param privateDnsHost The hostname of a server that implements DNS over TLS (RFC7858).
 *
 * This value must never be {@code null}.
 * @return {@code PRIVATE_DNS_SET_NO_ERROR} if the mode was set successfully,
 *         {@code PRIVATE_DNS_SET_ERROR_FAILURE_SETTING} if it could not be set or
 *         {@code PRIVATE_DNS_SET_ERROR_HOST_NOT_SERVING} if the specified host does not
 *         implement RFC7858.
 *
 * Value is {@link android.app.admin.DevicePolicyManager#PRIVATE_DNS_SET_NO_ERROR}, {@link android.app.admin.DevicePolicyManager#PRIVATE_DNS_SET_ERROR_HOST_NOT_SERVING}, or {@link android.app.admin.DevicePolicyManager#PRIVATE_DNS_SET_ERROR_FAILURE_SETTING}
 * @throws java.lang.IllegalArgumentException if the {@code privateDnsHost} is not a valid hostname.
 *
 * @throws java.lang.SecurityException if the caller is not the device owner.
 * @apiSince 29
 */

public int setGlobalPrivateDnsModeSpecifiedHost(@androidx.annotation.NonNull android.content.ComponentName admin, @androidx.annotation.NonNull java.lang.String privateDnsHost) { throw new RuntimeException("Stub!"); }

/**
 * Called by device owner to install a system update from the given file. The device will be
 * rebooted in order to finish installing the update. Note that if the device is rebooted, this
 * doesn't necessarily mean that the update has been applied successfully. The caller should
 * additionally check the system version with {@link android.os.Build#FINGERPRINT} or {@link
 * android.os.Build.VERSION}. If an error occurs during processing the OTA before the reboot,
 * the caller will be notified by {@link android.app.admin.DevicePolicyManager.InstallSystemUpdateCallback InstallSystemUpdateCallback}. If device does not have
 * sufficient battery level, the installation will fail with error {@link android.app.admin.DevicePolicyManager.InstallSystemUpdateCallback#UPDATE_ERROR_BATTERY_LOW InstallSystemUpdateCallback#UPDATE_ERROR_BATTERY_LOW}.
 *
 * @param admin The {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} that this request is associated with.
 * This value must never be {@code null}.
 * @param updateFilePath An Uri of the file that contains the update. The file should be
 * readable by the calling app.
 * This value must never be {@code null}.
 * @param executor The executor through which the callback should be invoked.
 * This value must never be {@code null}.
 * Callback and listener events are dispatched through this
 * {@link java.util.concurrent.Executor Executor}, providing an easy way to control which thread is
 * used. To dispatch events through the main thread of your
 * application, you can use {@link android.content.Context#getMainExecutor() Context#getMainExecutor()}. To
 * dispatch events through a shared thread pool, you can use
 * {@link android.os.AsyncTask#THREAD_POOL_EXECUTOR AsyncTask#THREAD_POOL_EXECUTOR}.
 * @param callback A callback object that will inform the caller when installing an update
 * fails.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void installSystemUpdate(@androidx.annotation.NonNull android.content.ComponentName admin, @androidx.annotation.NonNull android.net.Uri updateFilePath, @androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull android.app.admin.DevicePolicyManager.InstallSystemUpdateCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Returns the system-wide Private DNS mode.
 *
 * @param admin which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @return one of {@code PRIVATE_DNS_MODE_OFF}, {@code PRIVATE_DNS_MODE_OPPORTUNISTIC},
 * {@code PRIVATE_DNS_MODE_PROVIDER_HOSTNAME} or {@code PRIVATE_DNS_MODE_UNKNOWN}.
 * @throws java.lang.SecurityException if the caller is not the device owner.
 * @apiSince 29
 */

public int getGlobalPrivateDnsMode(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Returns the system-wide Private DNS host.
 *
 * @param admin which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with.
 * This value must never be {@code null}.
 * @return The hostname used for Private DNS queries, null if none is set.
 * @throws java.lang.SecurityException if the caller is not the device owner.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.lang.String getGlobalPrivateDnsHost(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Allows a set of packages to access cross-profile calendar APIs.
 *
 * <p>Called by a profile owner of a managed profile.
 *
 * <p>Calling with a {@code null} value for the set disables the restriction so that all
 * packages are allowed to access cross-profile calendar APIs. Calling with an empty set
 * disallows all packages from accessing cross-profile calendar APIs. If this method isn't
 * called, no package is allowed to access cross-profile calendar APIs by default.
 *
 * @param admin which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with
 * This value must never be {@code null}.
 * @param packageNames set of packages to be whitelisted
 * This value may be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not a profile owner
 *
 * @see #getCrossProfileCalendarPackages(ComponentName)
 * @apiSince 29
 */

public void setCrossProfileCalendarPackages(@androidx.annotation.NonNull android.content.ComponentName admin, @androidx.annotation.Nullable java.util.Set<java.lang.String> packageNames) { throw new RuntimeException("Stub!"); }

/**
 * Gets a set of package names that are allowed to access cross-profile calendar APIs.
 *
 * <p>Called by a profile owner of a managed profile.
 *
 * @param admin which {@link android.app.admin.DeviceAdminReceiver DeviceAdminReceiver} this request is associated with
 * This value must never be {@code null}.
 * @return the set of names of packages that were previously allowed via
 * {@link #setCrossProfileCalendarPackages(android.content.ComponentName,java.util.Set)}, or an
 * empty set if none have been allowed
 * This value may be {@code null}.
 * @throws java.lang.SecurityException if {@code admin} is not a profile owner
 *
 * @see #setCrossProfileCalendarPackages(ComponentName, Set)
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.util.Set<java.lang.String> getCrossProfileCalendarPackages(@androidx.annotation.NonNull android.content.ComponentName admin) { throw new RuntimeException("Stub!"); }

/**
 * Activity action: ask the user to add a new device administrator to the system.
 * The desired policy is the ComponentName of the policy in the
 * {@link #EXTRA_DEVICE_ADMIN} extra field.  This will invoke a UI to
 * bring the user through adding the device administrator to the system (or
 * allowing them to reject it).
 *
 * <p>You can optionally include the {@link #EXTRA_ADD_EXPLANATION}
 * field to provide the user with additional explanation (in addition
 * to your component's description) about what is being added.
 *
 * <p>If your administrator is already active, this will ordinarily return immediately (without
 * user intervention).  However, if your administrator has been updated and is requesting
 * additional uses-policy flags, the user will be presented with the new list.  New policies
 * will not be available to the updated administrator until the user has accepted the new list.
 * @apiSince 8
 */

public static final java.lang.String ACTION_ADD_DEVICE_ADMIN = "android.app.action.ADD_DEVICE_ADMIN";

/**
 * Activity action: Starts the administrator to show policy compliance for the provisioning.
 * @apiSince 29
 */

public static final java.lang.String ACTION_ADMIN_POLICY_COMPLIANCE = "android.app.action.ADMIN_POLICY_COMPLIANCE";

/**
 * Broadcast Action: Sent after application delegation scopes are changed. The new delegation
 * scopes will be sent in an {@code ArrayList<String>} extra identified by the
 * {@link #EXTRA_DELEGATION_SCOPES} key.
 *
 * <p class="note"><b>Note:</b> This is a protected intent that can only be sent by the
 * system.</p>
 * @apiSince 26
 */

public static final java.lang.String ACTION_APPLICATION_DELEGATION_SCOPES_CHANGED = "android.app.action.APPLICATION_DELEGATION_SCOPES_CHANGED";

/**
 * Service action: Action for a service that device owner and profile owner can optionally
 * own.  If a device owner or a profile owner has such a service, the system tries to keep
 * a bound connection to it, in order to keep their process always running.
 * The service must be protected with the {@link android.Manifest.permission#BIND_DEVICE_ADMIN}
 * permission.
 * @apiSince 26
 */

public static final java.lang.String ACTION_DEVICE_ADMIN_SERVICE = "android.app.action.DEVICE_ADMIN_SERVICE";

/**
 * Broadcast action: sent when the device owner is set, changed or cleared.
 *
 * This broadcast is sent only to the primary user.
 * @see #ACTION_PROVISION_MANAGED_DEVICE
 * @see android.app.admin.DevicePolicyManager#transferOwnership(ComponentName, ComponentName, PersistableBundle)
 * @apiSince 23
 */

public static final java.lang.String ACTION_DEVICE_OWNER_CHANGED = "android.app.action.DEVICE_OWNER_CHANGED";

/**
 * Activity action: Starts the administrator to get the mode for the provisioning.
 * This intent may contain the following extras:
 * <ul>
 *     <li>{@link #EXTRA_PROVISIONING_ADMIN_EXTRAS_BUNDLE}</li>
 *     <li>{@link #EXTRA_PROVISIONING_IMEI}</li>
 *     <li>{@link #EXTRA_PROVISIONING_SERIAL_NUMBER}</li>
 * </ul>
 *
 * <p>The target activity should return one of the following values in
 * {@link #EXTRA_PROVISIONING_MODE} as result:
 * <ul>
 *     <li>{@link #PROVISIONING_MODE_FULLY_MANAGED_DEVICE}</li>
 *     <li>{@link #PROVISIONING_MODE_MANAGED_PROFILE}</li>
 * </ul>
 *
 * <p>If performing fully-managed device provisioning and the admin app desires to show its
 * own education screens, the target activity can additionally return
 * {@link #EXTRA_PROVISIONING_SKIP_EDUCATION_SCREENS} set to <code>true</code>.
 *
 * <p>The target activity may also return the account that needs to be migrated from primary
 * user to managed profile in case of a profile owner provisioning in
 * {@link #EXTRA_PROVISIONING_ACCOUNT_TO_MIGRATE} as result.
 * @apiSince 29
 */

public static final java.lang.String ACTION_GET_PROVISIONING_MODE = "android.app.action.GET_PROVISIONING_MODE";

/**
 * Broadcast Action: This broadcast is sent to indicate that provisioning of a managed profile
 * has completed successfully.
 *
 * <p>The broadcast is limited to the primary profile, to the app specified in the provisioning
 * intent with action {@link #ACTION_PROVISION_MANAGED_PROFILE}.
 *
 * <p>This intent will contain the following extras
 * <ul>
 * <li>{@link android.content.Intent#EXTRA_USER Intent#EXTRA_USER}, corresponds to the {@link android.os.UserHandle UserHandle} of the managed
 * profile.</li>
 * <li>{@link #EXTRA_PROVISIONING_ACCOUNT_TO_MIGRATE}, corresponds to the account requested to
 * be migrated at provisioning time, if any.</li>
 * </ul>
 * @apiSince 23
 */

public static final java.lang.String ACTION_MANAGED_PROFILE_PROVISIONED = "android.app.action.MANAGED_PROFILE_PROVISIONED";

/**
 * Broadcast action: sent when the profile owner is set, changed or cleared.
 *
 * This broadcast is sent only to the user managed by the new profile owner.
 * @see android.app.admin.DevicePolicyManager#transferOwnership(ComponentName, ComponentName, PersistableBundle)
 * @apiSince 28
 */

public static final java.lang.String ACTION_PROFILE_OWNER_CHANGED = "android.app.action.PROFILE_OWNER_CHANGED";

/**
 * Activity action: This activity action is sent to indicate that provisioning of a managed
 * profile or managed device has completed successfully. It'll be sent at the same time as
 * {@link android.app.admin.DeviceAdminReceiver#ACTION_PROFILE_PROVISIONING_COMPLETE DeviceAdminReceiver#ACTION_PROFILE_PROVISIONING_COMPLETE} broadcast but this will be
 * delivered faster as it's an activity intent.
 *
 * <p>The intent is only sent to the new device or profile owner.
 *
 * @see #ACTION_PROVISION_MANAGED_PROFILE
 * @see #ACTION_PROVISION_MANAGED_DEVICE
 * @apiSince 26
 */

public static final java.lang.String ACTION_PROVISIONING_SUCCESSFUL = "android.app.action.PROVISIONING_SUCCESSFUL";

/**
 * Activity action: Starts the provisioning flow which sets up a managed device.
 * Must be started with {@link android.app.Activity#startActivityForResult(Intent, int)}.
 *
 * <p> During device owner provisioning a device admin app is set as the owner of the device.
 * A device owner has full control over the device. The device owner can not be modified by the
 * user.
 *
 * <p> A typical use case would be a device that is owned by a company, but used by either an
 * employee or client.
 *
 * <p> An intent with this action can be sent only on an unprovisioned device.
 * It is possible to check if provisioning is allowed or not by querying the method
 * {@link #isProvisioningAllowed(java.lang.String)}.
 *
 * <p>The intent contains the following extras:
 * <ul>
 * <li>{@link #EXTRA_PROVISIONING_DEVICE_ADMIN_COMPONENT_NAME}</li>
 * <li>{@link #EXTRA_PROVISIONING_SKIP_ENCRYPTION}, optional</li>
 * <li>{@link #EXTRA_PROVISIONING_LEAVE_ALL_SYSTEM_APPS_ENABLED}, optional</li>
 * <li>{@link #EXTRA_PROVISIONING_ADMIN_EXTRAS_BUNDLE}, optional</li>
 * <li>{@link #EXTRA_PROVISIONING_LOGO_URI}, optional</li>
 * <li>{@link #EXTRA_PROVISIONING_MAIN_COLOR}, optional</li>
 * <li>{@link #EXTRA_PROVISIONING_DISCLAIMERS}, optional</li>
 * <li>{@link #EXTRA_PROVISIONING_SKIP_EDUCATION_SCREENS}, optional</li>
 * </ul>
 *
 * <p>When device owner provisioning has completed, an intent of the type
 * {@link android.app.admin.DeviceAdminReceiver#ACTION_PROFILE_PROVISIONING_COMPLETE DeviceAdminReceiver#ACTION_PROFILE_PROVISIONING_COMPLETE} is broadcast to the
 * device owner.
 *
 * <p>From version {@link android.os.Build.VERSION_CODES#O}, when device owner provisioning has
 * completed, along with the above broadcast, activity intent
 * {@link #ACTION_PROVISIONING_SUCCESSFUL} will also be sent to the device owner.
 *
 * <p>If provisioning fails, the device is factory reset.
 *
 * <p>A result code of {@link android.app.Activity#RESULT_OK} implies that the synchronous part
 * of the provisioning flow was successful, although this doesn't guarantee the full flow will
 * succeed. Conversely a result code of {@link android.app.Activity#RESULT_CANCELED} implies
 * that the user backed-out of provisioning, or some precondition for provisioning wasn't met.
 * @apiSince 23
 */

public static final java.lang.String ACTION_PROVISION_MANAGED_DEVICE = "android.app.action.PROVISION_MANAGED_DEVICE";

/**
 * Activity action: Starts the provisioning flow which sets up a managed profile.
 *
 * <p>A managed profile allows data separation for example for the usage of a
 * device as a personal and corporate device. The user which provisioning is started from and
 * the managed profile share a launcher.
 *
 * <p>This intent will typically be sent by a mobile device management application (MDM).
 * Provisioning adds a managed profile and sets the MDM as the profile owner who has full
 * control over the profile.
 *
 * <p>It is possible to check if provisioning is allowed or not by querying the method
 * {@link #isProvisioningAllowed(java.lang.String)}.
 *
 * <p>In version {@link android.os.Build.VERSION_CODES#LOLLIPOP}, this intent must contain the
 * extra {@link #EXTRA_PROVISIONING_DEVICE_ADMIN_PACKAGE_NAME}.
 * As of {@link android.os.Build.VERSION_CODES#M}, it should contain the extra
 * {@link #EXTRA_PROVISIONING_DEVICE_ADMIN_COMPONENT_NAME} instead, although specifying only
 * {@link #EXTRA_PROVISIONING_DEVICE_ADMIN_PACKAGE_NAME} is still supported.
 *
 * <p>The intent may also contain the following extras:
 * <ul>
 * <li>{@link #EXTRA_PROVISIONING_ACCOUNT_TO_MIGRATE}, optional </li>
 * <li>{@link #EXTRA_PROVISIONING_SKIP_ENCRYPTION}, optional, supported from
 * {@link android.os.Build.VERSION_CODES#N}</li>
 * <li>{@link #EXTRA_PROVISIONING_ADMIN_EXTRAS_BUNDLE}, optional</li>
 * <li>{@link #EXTRA_PROVISIONING_LOGO_URI}, optional</li>
 * <li>{@link #EXTRA_PROVISIONING_MAIN_COLOR}, optional</li>
 * <li>{@link #EXTRA_PROVISIONING_SKIP_USER_CONSENT}, optional</li>
 * <li>{@link #EXTRA_PROVISIONING_KEEP_ACCOUNT_ON_MIGRATION}, optional</li>
 * <li>{@link #EXTRA_PROVISIONING_DISCLAIMERS}, optional</li>
 * </ul>
 *
 * <p>When managed provisioning has completed, broadcasts are sent to the application specified
 * in the provisioning intent. The
 * {@link android.app.admin.DeviceAdminReceiver#ACTION_PROFILE_PROVISIONING_COMPLETE DeviceAdminReceiver#ACTION_PROFILE_PROVISIONING_COMPLETE} broadcast is sent in the
 * managed profile and the {@link #ACTION_MANAGED_PROFILE_PROVISIONED} broadcast is sent in
 * the primary profile.
 *
 * <p>From version {@link android.os.Build.VERSION_CODES#O}, when managed provisioning has
 * completed, along with the above broadcast, activity intent
 * {@link #ACTION_PROVISIONING_SUCCESSFUL} will also be sent to the profile owner.
 *
 * <p>If provisioning fails, the managedProfile is removed so the device returns to its
 * previous state.
 *
 * <p>If launched with {@link android.app.Activity#startActivityForResult(Intent, int)} a
 * result code of {@link android.app.Activity#RESULT_OK} implies that the synchronous part of
 * the provisioning flow was successful, although this doesn't guarantee the full flow will
 * succeed. Conversely a result code of {@link android.app.Activity#RESULT_CANCELED} implies
 * that the user backed-out of provisioning, or some precondition for provisioning wasn't met.
 * @apiSince 21
 */

public static final java.lang.String ACTION_PROVISION_MANAGED_PROFILE = "android.app.action.PROVISION_MANAGED_PROFILE";

/**
 * Activity action: have the user enter a new password for the parent profile.
 * If the intent is launched from within a managed profile, this will trigger
 * entering a new password for the parent of the profile. In all other cases
 * the behaviour is identical to {@link #ACTION_SET_NEW_PASSWORD}.
 * @apiSince 24
 */

public static final java.lang.String ACTION_SET_NEW_PARENT_PROFILE_PASSWORD = "android.app.action.SET_NEW_PARENT_PROFILE_PASSWORD";

/**
 * Activity action: have the user enter a new password.
 *
 * <p>For admin apps, this activity should be launched after using {@link
 * #setPasswordQuality(android.content.ComponentName,int)}, or {@link
 * #setPasswordMinimumLength(android.content.ComponentName,int)} to have the user enter a new password that
 * meets the current requirements. You can use {@link #isActivePasswordSufficient()} to
 * determine whether you need to have the user select a new password in order to meet the
 * current constraints. Upon being resumed from this activity, you can check the new
 * password characteristics to see if they are sufficient.
 *
 * <p>Non-admin apps can use {@link #getPasswordComplexity()} to check the current screen lock
 * complexity, and use this activity with extra {@link #EXTRA_PASSWORD_COMPLEXITY} to suggest
 * to users how complex the app wants the new screen lock to be. Note that both {@link
 * #getPasswordComplexity()} and the extra {@link #EXTRA_PASSWORD_COMPLEXITY} require the
 * calling app to have the permission {@link android.Manifest.permission#REQUEST_PASSWORD_COMPLEXITY permission#REQUEST_PASSWORD_COMPLEXITY}.
 *
 * <p>If the intent is launched from within a managed profile with a profile
 * owner built against {@link android.os.Build.VERSION_CODES#M} or before,
 * this will trigger entering a new password for the parent of the profile.
 * For all other cases it will trigger entering a new password for the user
 * or profile it is launched from.
 *
 * @see #ACTION_SET_NEW_PARENT_PROFILE_PASSWORD
 * @apiSince 8
 */

public static final java.lang.String ACTION_SET_NEW_PASSWORD = "android.app.action.SET_NEW_PASSWORD";

/**
 * Activity action: begin the process of encrypting data on the device.  This activity should
 * be launched after using {@link #setStorageEncryption} to request encryption be activated.
 * After resuming from this activity, use {@link #getStorageEncryption}
 * to check encryption status.  However, on some devices this activity may never return, as
 * it may trigger a reboot and in some cases a complete data wipe of the device.
 * @apiSince 11
 */

public static final java.lang.String ACTION_START_ENCRYPTION = "android.app.action.START_ENCRYPTION";

/**
 * Broadcast action: notify that a new local system update policy has been set by the device
 * owner. The new policy can be retrieved by {@link #getSystemUpdatePolicy()}.
 * @apiSince 23
 */

public static final java.lang.String ACTION_SYSTEM_UPDATE_POLICY_CHANGED = "android.app.action.SYSTEM_UPDATE_POLICY_CHANGED";

/**
 * Delegation of application restrictions management. This scope grants access to the
 * {@link #setApplicationRestrictions} and {@link #getApplicationRestrictions} APIs.
 * @apiSince 26
 */

public static final java.lang.String DELEGATION_APP_RESTRICTIONS = "delegation-app-restrictions";

/**
 * Delegation of application uninstall block. This scope grants access to the
 * {@link #setUninstallBlocked} API.
 * @apiSince 26
 */

public static final java.lang.String DELEGATION_BLOCK_UNINSTALL = "delegation-block-uninstall";

/**
 * Delegation of certificate installation and management. This scope grants access to the
 * {@link #getInstalledCaCerts}, {@link #hasCaCertInstalled}, {@link #installCaCert},
 * {@link #uninstallCaCert}, {@link #uninstallAllUserCaCerts} and {@link #installKeyPair} APIs.
 * @apiSince 26
 */

public static final java.lang.String DELEGATION_CERT_INSTALL = "delegation-cert-install";

/**
 * Grants access to selection of KeyChain certificates on behalf of requesting apps.
 * Once granted the app will start receiving
 * DelegatedAdminReceiver.onChoosePrivateKeyAlias. The caller (PO/DO) will
 * no longer receive {@link android.app.admin.DeviceAdminReceiver#onChoosePrivateKeyAlias DeviceAdminReceiver#onChoosePrivateKeyAlias}.
 * There can be at most one app that has this delegation.
 * If another app already had delegated certificate selection access,
 * it will lose the delegation when a new app is delegated.
 *
 * <p> Can be granted by Device Owner or Profile Owner.
 * @apiSince 29
 */

public static final java.lang.String DELEGATION_CERT_SELECTION = "delegation-cert-selection";

/**
 * Delegation for enabling system apps. This scope grants access to the {@link #enableSystemApp}
 * API.
 * @apiSince 26
 */

public static final java.lang.String DELEGATION_ENABLE_SYSTEM_APP = "delegation-enable-system-app";

/**
 * Delegation for installing existing packages. This scope grants access to the
 * {@link #installExistingPackage} API.
 * @apiSince 28
 */

public static final java.lang.String DELEGATION_INSTALL_EXISTING_PACKAGE = "delegation-install-existing-package";

/**
 * Delegation of management of uninstalled packages. This scope grants access to the
 * {@link #setKeepUninstalledPackages} and {@link #getKeepUninstalledPackages} APIs.
 * @apiSince 28
 */

public static final java.lang.String DELEGATION_KEEP_UNINSTALLED_PACKAGES = "delegation-keep-uninstalled-packages";

/**
 * Grants access to {@link #setNetworkLoggingEnabled}, {@link #isNetworkLoggingEnabled} and
 * {@link #retrieveNetworkLogs}. Once granted the delegated app will start receiving
 * DelegatedAdminReceiver.onNetworkLogsAvailable() callback, and Device owner will no longer
 * receive the DeviceAdminReceiver.onNetworkLogsAvailable() callback.
 * There can be at most one app that has this delegation.
 * If another app already had delegated network logging access,
 * it will lose the delegation when a new app is delegated.
 *
 * <p> Can only be granted by Device Owner.
 * @apiSince 29
 */

public static final java.lang.String DELEGATION_NETWORK_LOGGING = "delegation-network-logging";

/**
 * Delegation of package access state. This scope grants access to the
 * {@link #isApplicationHidden}, {@link #setApplicationHidden}, {@link #isPackageSuspended}, and
 * {@link #setPackagesSuspended} APIs.
 * @apiSince 26
 */

public static final java.lang.String DELEGATION_PACKAGE_ACCESS = "delegation-package-access";

/**
 * Delegation of permission policy and permission grant state. This scope grants access to the
 * {@link #setPermissionPolicy}, {@link #getPermissionGrantState},
 * and {@link #setPermissionGrantState} APIs.
 * @apiSince 26
 */

public static final java.lang.String DELEGATION_PERMISSION_GRANT = "delegation-permission-grant";

/**
 * Result code for {@link #getStorageEncryptionStatus}:
 * indicating that encryption is not currently active, but is currently
 * being activated.  This is only reported by devices that support
 * encryption of data and only when the storage is currently
 * undergoing a process of becoming encrypted.  A device that must reboot and/or wipe data
 * to become encrypted will never return this value.
 * @apiSince 11
 */

public static final int ENCRYPTION_STATUS_ACTIVATING = 2; // 0x2

/**
 * Result code for {@link #setStorageEncryption} and {@link #getStorageEncryptionStatus}:
 * indicating that encryption is active.
 * <p>
 * Also see {@link #ENCRYPTION_STATUS_ACTIVE_PER_USER}.
 * @apiSince 11
 */

public static final int ENCRYPTION_STATUS_ACTIVE = 3; // 0x3

/**
 * Result code for {@link #getStorageEncryptionStatus}:
 * indicating that encryption is active, but an encryption key has not
 * been set by the user.
 * @apiSince 23
 */

public static final int ENCRYPTION_STATUS_ACTIVE_DEFAULT_KEY = 4; // 0x4

/**
 * Result code for {@link #getStorageEncryptionStatus}:
 * indicating that encryption is active and the encryption key is tied to the user or profile.
 * <p>
 * This value is only returned to apps targeting API level 24 and above. For apps targeting
 * earlier API levels, {@link #ENCRYPTION_STATUS_ACTIVE} is returned, even if the
 * encryption key is specific to the user or profile.
 * @apiSince 24
 */

public static final int ENCRYPTION_STATUS_ACTIVE_PER_USER = 5; // 0x5

/**
 * Result code for {@link #setStorageEncryption} and {@link #getStorageEncryptionStatus}:
 * indicating that encryption is supported, but is not currently active.
 * @apiSince 11
 */

public static final int ENCRYPTION_STATUS_INACTIVE = 1; // 0x1

/**
 * Result code for {@link #setStorageEncryption} and {@link #getStorageEncryptionStatus}:
 * indicating that encryption is not supported.
 * @apiSince 11
 */

public static final int ENCRYPTION_STATUS_UNSUPPORTED = 0; // 0x0

/**
 * An optional CharSequence providing additional explanation for why the
 * admin is being added.
 *
 * @see #ACTION_ADD_DEVICE_ADMIN
 * @apiSince 8
 */

public static final java.lang.String EXTRA_ADD_EXPLANATION = "android.app.extra.ADD_EXPLANATION";

/**
 * An {@code ArrayList<String>} corresponding to the delegation scopes given to an app in the
 * {@link #ACTION_APPLICATION_DELEGATION_SCOPES_CHANGED} broadcast.
 * @apiSince 26
 */

public static final java.lang.String EXTRA_DELEGATION_SCOPES = "android.app.extra.DELEGATION_SCOPES";

/**
 * The ComponentName of the administrator component.
 *
 * @see #ACTION_ADD_DEVICE_ADMIN
 * @apiSince 8
 */

public static final java.lang.String EXTRA_DEVICE_ADMIN = "android.app.extra.DEVICE_ADMIN";

/**
 * An integer indicating the complexity level of the new password an app would like the user to
 * set when launching the action {@link #ACTION_SET_NEW_PASSWORD}.
 *
 * <p>Must be one of
 * <ul>
 *     <li>{@link #PASSWORD_COMPLEXITY_HIGH}
 *     <li>{@link #PASSWORD_COMPLEXITY_MEDIUM}
 *     <li>{@link #PASSWORD_COMPLEXITY_LOW}
 *     <li>{@link #PASSWORD_COMPLEXITY_NONE}
 * </ul>
 *
 * <p>If an invalid value is used, it will be treated as {@link #PASSWORD_COMPLEXITY_NONE}.
 
 * <br>
 * Requires {@link android.Manifest.permission#REQUEST_PASSWORD_COMPLEXITY}
 * @apiSince 29
 */

public static final java.lang.String EXTRA_PASSWORD_COMPLEXITY = "android.app.extra.PASSWORD_COMPLEXITY";

/**
 * An {@link android.accounts.Account} extra holding the account to migrate during managed
 * profile provisioning. If the account supplied is present in the primary user, it will be
 * copied, along with its credentials to the managed profile and removed from the primary user.
 *
 * Use with {@link #ACTION_PROVISION_MANAGED_PROFILE}.
 * @apiSince 22
 */

public static final java.lang.String EXTRA_PROVISIONING_ACCOUNT_TO_MIGRATE = "android.app.extra.PROVISIONING_ACCOUNT_TO_MIGRATE";

/**
 * A {@link android.os.Parcelable} extra of type {@link android.os.PersistableBundle} that
 * allows a mobile device management application or NFC programmer application which starts
 * managed provisioning to pass data to the management application instance after provisioning.
 * <p>
 * If used with {@link #ACTION_PROVISION_MANAGED_PROFILE} it can be used by the application that
 * sends the intent to pass data to itself on the newly created profile.
 * If used with {@link #ACTION_PROVISION_MANAGED_DEVICE} it allows passing data to the same
 * instance of the app on the primary user.
 * Starting from {@link android.os.Build.VERSION_CODES#M}, if used with
 * {@link #MIME_TYPE_PROVISIONING_NFC} as part of NFC managed device provisioning, the NFC
 * message should contain a stringified {@link java.util.Properties} instance, whose string
 * properties will be converted into a {@link android.os.PersistableBundle} and passed to the
 * management application after provisioning.
 *
 * <p>
 * In both cases the application receives the data in
 * {@link android.app.admin.DeviceAdminReceiver#onProfileProvisioningComplete DeviceAdminReceiver#onProfileProvisioningComplete} via an intent with the action
 * {@link android.app.admin.DeviceAdminReceiver#ACTION_PROFILE_PROVISIONING_COMPLETE DeviceAdminReceiver#ACTION_PROFILE_PROVISIONING_COMPLETE}. The bundle is not changed
 * during the managed provisioning.
 * @apiSince 21
 */

public static final java.lang.String EXTRA_PROVISIONING_ADMIN_EXTRAS_BUNDLE = "android.app.extra.PROVISIONING_ADMIN_EXTRAS_BUNDLE";

/**
 * A ComponentName extra indicating the device admin receiver of the mobile device management
 * application that will be set as the profile owner or device owner and active admin.
 *
 * <p>If an application starts provisioning directly via an intent with action
 * {@link #ACTION_PROVISION_MANAGED_PROFILE} or
 * {@link #ACTION_PROVISION_MANAGED_DEVICE} the package name of this
 * component has to match the package name of the application that started provisioning.
 *
 * <p>This component is set as device owner and active admin when device owner provisioning is
 * started by an intent with action {@link #ACTION_PROVISION_MANAGED_DEVICE} or by an NFC
 * message containing an NFC record with MIME type
 * {@link #MIME_TYPE_PROVISIONING_NFC}. For the NFC record, the component name must be
 * flattened to a string, via {@link android.content.ComponentName#flattenToShortString() ComponentName#flattenToShortString()}.
 *
 * @see android.app.admin.DeviceAdminReceiver
 * @apiSince 23
 */

public static final java.lang.String EXTRA_PROVISIONING_DEVICE_ADMIN_COMPONENT_NAME = "android.app.extra.PROVISIONING_DEVICE_ADMIN_COMPONENT_NAME";

/**
 * An int extra holding a minimum required version code for the device admin package. If the
 * device admin is already installed on the device, it will only be re-downloaded from
 * {@link #EXTRA_PROVISIONING_DEVICE_ADMIN_PACKAGE_DOWNLOAD_LOCATION} if the version of the
 * installed package is less than this version code.
 *
 * <p>Use in an NFC record with {@link #MIME_TYPE_PROVISIONING_NFC} that starts device owner
 * provisioning via an NFC bump.
 * @apiSince 23
 */

public static final java.lang.String EXTRA_PROVISIONING_DEVICE_ADMIN_MINIMUM_VERSION_CODE = "android.app.extra.PROVISIONING_DEVICE_ADMIN_MINIMUM_VERSION_CODE";

/**
 * A String extra holding the URL-safe base64 encoded SHA-256 hash of the file at download
 * location specified in {@link #EXTRA_PROVISIONING_DEVICE_ADMIN_PACKAGE_DOWNLOAD_LOCATION}.
 *
 * <p>Either this extra or {@link #EXTRA_PROVISIONING_DEVICE_ADMIN_SIGNATURE_CHECKSUM} must be
 * present. The provided checksum must match the checksum of the file at the download
 * location. If the checksum doesn't match an error will be shown to the user and the user will
 * be asked to factory reset the device.
 *
 * <p>Use in an NFC record with {@link #MIME_TYPE_PROVISIONING_NFC} that starts device owner
 * provisioning via an NFC bump.
 *
 * <p><strong>Note:</strong> for devices running {@link android.os.Build.VERSION_CODES#LOLLIPOP}
 * and {@link android.os.Build.VERSION_CODES#LOLLIPOP_MR1} only SHA-1 hash is supported.
 * Starting from {@link android.os.Build.VERSION_CODES#M}, this parameter accepts SHA-256 in
 * addition to SHA-1. From {@link android.os.Build.VERSION_CODES#Q}, only SHA-256 hash is
 * supported.
 * @apiSince 21
 */

public static final java.lang.String EXTRA_PROVISIONING_DEVICE_ADMIN_PACKAGE_CHECKSUM = "android.app.extra.PROVISIONING_DEVICE_ADMIN_PACKAGE_CHECKSUM";

/**
 * A String extra holding a http cookie header which should be used in the http request to the
 * url specified in {@link #EXTRA_PROVISIONING_DEVICE_ADMIN_PACKAGE_DOWNLOAD_LOCATION}.
 *
 * <p>Use in an NFC record with {@link #MIME_TYPE_PROVISIONING_NFC} that starts device owner
 * provisioning via an NFC bump.
 * @apiSince 21
 */

public static final java.lang.String EXTRA_PROVISIONING_DEVICE_ADMIN_PACKAGE_DOWNLOAD_COOKIE_HEADER = "android.app.extra.PROVISIONING_DEVICE_ADMIN_PACKAGE_DOWNLOAD_COOKIE_HEADER";

/**
 * A String extra holding a url that specifies the download location of the device admin
 * package. When not provided it is assumed that the device admin package is already installed.
 *
 * <p>Use in an NFC record with {@link #MIME_TYPE_PROVISIONING_NFC} that starts device owner
 * provisioning via an NFC bump.
 * @apiSince 21
 */

public static final java.lang.String EXTRA_PROVISIONING_DEVICE_ADMIN_PACKAGE_DOWNLOAD_LOCATION = "android.app.extra.PROVISIONING_DEVICE_ADMIN_PACKAGE_DOWNLOAD_LOCATION";

/**
 * A String extra holding the package name of the mobile device management application that
 * will be set as the profile owner or device owner.
 *
 * <p>If an application starts provisioning directly via an intent with action
 * {@link #ACTION_PROVISION_MANAGED_PROFILE} this package has to match the package name of the
 * application that started provisioning. The package will be set as profile owner in that case.
 *
 * <p>This package is set as device owner when device owner provisioning is started by an NFC
 * message containing an NFC record with MIME type {@link #MIME_TYPE_PROVISIONING_NFC}.
 *
 * <p> When this extra is set, the application must have exactly one device admin receiver.
 * This receiver will be set as the profile or device owner and active admin.
 *
 * @see android.app.admin.DeviceAdminReceiver
 * @deprecated Use {@link #EXTRA_PROVISIONING_DEVICE_ADMIN_COMPONENT_NAME}. This extra is still
 * supported, but only if there is only one device admin receiver in the package that requires
 * the permission {@link android.Manifest.permission#BIND_DEVICE_ADMIN}.
 * @apiSince 21
 * @deprecatedSince 23
 */

@Deprecated public static final java.lang.String EXTRA_PROVISIONING_DEVICE_ADMIN_PACKAGE_NAME = "android.app.extra.PROVISIONING_DEVICE_ADMIN_PACKAGE_NAME";

/**
 * A String extra holding the URL-safe base64 encoded SHA-256 checksum of any signature of the
 * android package archive at the download location specified in {@link
 * #EXTRA_PROVISIONING_DEVICE_ADMIN_PACKAGE_DOWNLOAD_LOCATION}.
 *
 * <p>The signatures of an android package archive can be obtained using
 * {@link android.content.pm.PackageManager#getPackageArchiveInfo} with flag
 * {@link android.content.pm.PackageManager#GET_SIGNATURES}.
 *
 * <p>Either this extra or {@link #EXTRA_PROVISIONING_DEVICE_ADMIN_PACKAGE_CHECKSUM} must be
 * present. The provided checksum must match the checksum of any signature of the file at
 * the download location. If the checksum does not match an error will be shown to the user and
 * the user will be asked to factory reset the device.
 *
 * <p>Use in an NFC record with {@link #MIME_TYPE_PROVISIONING_NFC} that starts device owner
 * provisioning via an NFC bump.
 * @apiSince 23
 */

public static final java.lang.String EXTRA_PROVISIONING_DEVICE_ADMIN_SIGNATURE_CHECKSUM = "android.app.extra.PROVISIONING_DEVICE_ADMIN_SIGNATURE_CHECKSUM";

/**
 * A {@link android.os.Bundle Bundle}[] extra consisting of list of disclaimer headers and disclaimer contents.
 * Each {@link android.os.Bundle Bundle} must have both {@link #EXTRA_PROVISIONING_DISCLAIMER_HEADER}
 * as disclaimer header, and {@link #EXTRA_PROVISIONING_DISCLAIMER_CONTENT} as disclaimer
 * content.
 *
 * <p> The extra typically contains one disclaimer from the company of mobile device
 * management application (MDM), and one disclaimer from the organization.
 *
 * <p> Call {@link android.os.Bundle#putParcelableArray(java.lang.String,android.os.Parcelable[]) Bundle#putParcelableArray(String, Parcelable[])} to put the {@link android.os.Bundle Bundle}[]
 *
 * <p> Maximum 3 key-value pairs can be specified. The rest will be ignored.
 *
 * <p> Use in an intent with action {@link #ACTION_PROVISION_MANAGED_PROFILE} or
 * {@link #ACTION_PROVISION_MANAGED_DEVICE}
 * @apiSince 26
 */

public static final java.lang.String EXTRA_PROVISIONING_DISCLAIMERS = "android.app.extra.PROVISIONING_DISCLAIMERS";

/**
 * A {@link android.net.Uri Uri} extra pointing to disclaimer content.
 *
 * <h5>The following URI schemes are accepted:</h5>
 * <ul>
 * <li>content ({@link android.content.ContentResolver#SCHEME_CONTENT})</li>
 * <li>android.resource ({@link android.content.ContentResolver#SCHEME_ANDROID_RESOURCE})</li>
 * </ul>
 *
 * <p> Styled text is supported in the disclaimer content. The content is parsed by
 * {@link android.text.Html#fromHtml(String)} and displayed in a
 * {@link android.widget.TextView}.
 *
 * <p> If a <code>content:</code> URI is passed, URI is passed, the intent should have the flag
 * {@link android.content.Intent#FLAG_GRANT_READ_URI_PERMISSION Intent#FLAG_GRANT_READ_URI_PERMISSION} and the uri should be added to the
 * {@link android.content.ClipData} of the intent too.
 *
 * <p> Use in Bundle {@link #EXTRA_PROVISIONING_DISCLAIMERS}
 *
 * <p> System app, i.e. application with {@link android.content.pm.ApplicationInfo#FLAG_SYSTEM ApplicationInfo#FLAG_SYSTEM}, can also insert a
 * disclaimer by declaring an application-level meta-data in {@code AndroidManifest.xml}.
 * Must use it with {@link #EXTRA_PROVISIONING_DISCLAIMER_HEADER}. Here is the example:
 *
 * <pre>
 *  &lt;meta-data
 *      android:name="android.app.extra.PROVISIONING_DISCLAIMER_CONTENT"
 *      android:resource="@string/disclaimer_content"
 * /&gt;</pre>
 * @apiSince 26
 */

public static final java.lang.String EXTRA_PROVISIONING_DISCLAIMER_CONTENT = "android.app.extra.PROVISIONING_DISCLAIMER_CONTENT";

/**
 * A String extra of localized disclaimer header.
 *
 * <p> The extra is typically the company name of mobile device management application (MDM)
 * or the organization name.
 *
 * <p> Use in Bundle {@link #EXTRA_PROVISIONING_DISCLAIMERS}
 *
 * <p> System app, i.e. application with {@link android.content.pm.ApplicationInfo#FLAG_SYSTEM ApplicationInfo#FLAG_SYSTEM}, can also insert a
 * disclaimer by declaring an application-level meta-data in {@code AndroidManifest.xml}.
 * Must use it with {@link #EXTRA_PROVISIONING_DISCLAIMER_CONTENT}. Here is the example:
 *
 * <pre>
 *  &lt;meta-data
 *      android:name="android.app.extra.PROVISIONING_DISCLAIMER_HEADER"
 *      android:resource="@string/disclaimer_header"
 * /&gt;</pre>
 * @apiSince 26
 */

public static final java.lang.String EXTRA_PROVISIONING_DISCLAIMER_HEADER = "android.app.extra.PROVISIONING_DISCLAIMER_HEADER";

/**
 * @deprecated From {@link android.os.Build.VERSION_CODES#O}, never used while provisioning the
 * device.
 * @apiSince 21
 * @deprecatedSince 26
 */

@Deprecated public static final java.lang.String EXTRA_PROVISIONING_EMAIL_ADDRESS = "android.app.extra.PROVISIONING_EMAIL_ADDRESS";

/**
 * A string extra holding the IMEI (International Mobile Equipment Identity) of the device.
 * @apiSince 29
 */

public static final java.lang.String EXTRA_PROVISIONING_IMEI = "android.app.extra.PROVISIONING_IMEI";

/**
 * Boolean extra to indicate that the migrated account should be kept. This is used in
 * conjunction with {@link #EXTRA_PROVISIONING_ACCOUNT_TO_MIGRATE}. If it's set to {@code true},
 * the account will not be removed from the primary user after it is migrated to the newly
 * created user or profile.
 *
 * <p> Defaults to {@code false}
 *
 * <p> Use with {@link #ACTION_PROVISION_MANAGED_PROFILE} and
 * {@link #EXTRA_PROVISIONING_ACCOUNT_TO_MIGRATE}
 * @apiSince 26
 */

public static final java.lang.String EXTRA_PROVISIONING_KEEP_ACCOUNT_ON_MIGRATION = "android.app.extra.PROVISIONING_KEEP_ACCOUNT_ON_MIGRATION";

/**
 * A Boolean extra that can be used by the mobile device management application to skip the
 * disabling of system apps during provisioning when set to {@code true}.
 *
 * <p>Use in an NFC record with {@link #MIME_TYPE_PROVISIONING_NFC} or an intent with action
 * {@link #ACTION_PROVISION_MANAGED_DEVICE} that starts device owner provisioning.
 * @apiSince 22
 */

public static final java.lang.String EXTRA_PROVISIONING_LEAVE_ALL_SYSTEM_APPS_ENABLED = "android.app.extra.PROVISIONING_LEAVE_ALL_SYSTEM_APPS_ENABLED";

/**
 * A String extra holding the {@link java.util.Locale} that the device will be set to.
 * Format: xx_yy, where xx is the language code, and yy the country code.
 *
 * <p>Use in an NFC record with {@link #MIME_TYPE_PROVISIONING_NFC} that starts device owner
 * provisioning via an NFC bump.
 * @apiSince 21
 */

public static final java.lang.String EXTRA_PROVISIONING_LOCALE = "android.app.extra.PROVISIONING_LOCALE";

/**
 * A Long extra holding the wall clock time (in milliseconds) to be set on the device's
 * {@link android.app.AlarmManager}.
 *
 * <p>Use in an NFC record with {@link #MIME_TYPE_PROVISIONING_NFC} that starts device owner
 * provisioning via an NFC bump.
 * @apiSince 21
 */

public static final java.lang.String EXTRA_PROVISIONING_LOCAL_TIME = "android.app.extra.PROVISIONING_LOCAL_TIME";

/**
 * A {@link android.net.Uri Uri} extra pointing to a logo image. This image will be shown during the
 * provisioning. If this extra is not passed, a default image will be shown.
 * <h5>The following URI schemes are accepted:</h5>
 * <ul>
 * <li>content ({@link android.content.ContentResolver#SCHEME_CONTENT})</li>
 * <li>android.resource ({@link android.content.ContentResolver#SCHEME_ANDROID_RESOURCE})</li>
 * </ul>
 *
 * <p> It is the responsibility of the caller to provide an image with a reasonable
 * pixel density for the device.
 *
 * <p> If a content: URI is passed, the intent should have the flag
 * {@link android.content.Intent#FLAG_GRANT_READ_URI_PERMISSION Intent#FLAG_GRANT_READ_URI_PERMISSION} and the uri should be added to the
 * {@link android.content.ClipData} of the intent too.
 *
 * <p>Use in an intent with action {@link #ACTION_PROVISION_MANAGED_PROFILE} or
 * {@link #ACTION_PROVISION_MANAGED_DEVICE}
 * @apiSince 24
 */

public static final java.lang.String EXTRA_PROVISIONING_LOGO_URI = "android.app.extra.PROVISIONING_LOGO_URI";

/**
 * A integer extra indicating the predominant color to show during the provisioning.
 * Refer to {@link android.graphics.Color} for how the color is represented.
 *
 * <p>Use with {@link #ACTION_PROVISION_MANAGED_PROFILE} or
 * {@link #ACTION_PROVISION_MANAGED_DEVICE}.
 * @apiSince 24
 */

public static final java.lang.String EXTRA_PROVISIONING_MAIN_COLOR = "android.app.extra.PROVISIONING_MAIN_COLOR";

/**
 * An intent extra holding the provisioning mode returned by the administrator.
 * The value for this extra should be one of the following:
 * <ul>
 *     <li>{@link #PROVISIONING_MODE_FULLY_MANAGED_DEVICE}</li>
 *     <li>{@link #PROVISIONING_MODE_MANAGED_PROFILE}</li>
 * </ul>
 * @apiSince 29
 */

public static final java.lang.String EXTRA_PROVISIONING_MODE = "android.app.extra.PROVISIONING_MODE";

/**
 * A string extra holding the serial number of the device.
 * @apiSince 29
 */

public static final java.lang.String EXTRA_PROVISIONING_SERIAL_NUMBER = "android.app.extra.PROVISIONING_SERIAL_NUMBER";

/**
 * A boolean extra indicating if the education screens from the provisioning flow should be
 * skipped. If unspecified, defaults to {@code false}.
 *
 * <p>This extra can be set in the following ways:
 * <ul>
 * <li>By the admin app when performing the admin-integrated
 * provisioning flow as a result of the {@link #ACTION_GET_PROVISIONING_MODE} activity</li>
 * <li>With intent action {@link #ACTION_PROVISION_MANAGED_DEVICE}</li>
 * </ul>
 *
 * <p>If the education screens are skipped, it is the admin application's responsibility
 * to display its own user education screens.
 * @apiSince 29
 */

public static final java.lang.String EXTRA_PROVISIONING_SKIP_EDUCATION_SCREENS = "android.app.extra.PROVISIONING_SKIP_EDUCATION_SCREENS";

/**
 * A boolean extra indicating whether device encryption can be skipped as part of device owner
 * or managed profile provisioning.
 *
 * <p>Use in an NFC record with {@link #MIME_TYPE_PROVISIONING_NFC} or an intent with action
 * {@link #ACTION_PROVISION_MANAGED_DEVICE} that starts device owner provisioning.
 *
 * <p>From {@link android.os.Build.VERSION_CODES#N} onwards, this is also supported for an
 * intent with action {@link #ACTION_PROVISION_MANAGED_PROFILE}.
 * @apiSince 23
 */

public static final java.lang.String EXTRA_PROVISIONING_SKIP_ENCRYPTION = "android.app.extra.PROVISIONING_SKIP_ENCRYPTION";

/**
 * A boolean extra indicating if the user consent steps from the provisioning flow should be
 * skipped. If unspecified, defaults to {@code false}.
 *
 * It can only be used by an existing device owner trying to create a managed profile via
 * {@link #ACTION_PROVISION_MANAGED_PROFILE}. Otherwise it is ignored.
 * @apiSince 26
 */

public static final java.lang.String EXTRA_PROVISIONING_SKIP_USER_CONSENT = "android.app.extra.PROVISIONING_SKIP_USER_CONSENT";

/**
 * A String extra holding the time zone {@link android.app.AlarmManager} that the device
 * will be set to.
 *
 * <p>Use in an NFC record with {@link #MIME_TYPE_PROVISIONING_NFC} that starts device owner
 * provisioning via an NFC bump.
 * @apiSince 21
 */

public static final java.lang.String EXTRA_PROVISIONING_TIME_ZONE = "android.app.extra.PROVISIONING_TIME_ZONE";

/**
 * The anonymous identity of the wifi network in {@link #EXTRA_PROVISIONING_WIFI_SSID}. This is
 * only used if the {@link #EXTRA_PROVISIONING_WIFI_SECURITY_TYPE} is {@code EAP}.
 *
 * <p>Use in an NFC record with {@link #MIME_TYPE_PROVISIONING_NFC} that starts device owner
 * provisioning via an NFC bump. It can also be used for QR code provisioning.
 * @apiSince 29
 */

public static final java.lang.String EXTRA_PROVISIONING_WIFI_ANONYMOUS_IDENTITY = "android.app.extra.PROVISIONING_WIFI_ANONYMOUS_IDENTITY";

/**
 * The CA certificate of the wifi network in {@link #EXTRA_PROVISIONING_WIFI_SSID}. This should
 * be an X.509 certificate Base64 encoded DER format, ie. PEM representation of a certificate
 * without header, footer and line breaks. <a href=
 * "https://tools.ietf.org/html/rfc7468"> More information</a> This is only
 * used if the {@link
 * #EXTRA_PROVISIONING_WIFI_SECURITY_TYPE} is {@code EAP}.
 *
 * <p>Use in an NFC record with {@link #MIME_TYPE_PROVISIONING_NFC} that starts device owner
 * provisioning via an NFC bump. It can also be used for QR code provisioning.
 * @apiSince 29
 */

public static final java.lang.String EXTRA_PROVISIONING_WIFI_CA_CERTIFICATE = "android.app.extra.PROVISIONING_WIFI_CA_CERTIFICATE";

/**
 * The domain of the wifi network in {@link #EXTRA_PROVISIONING_WIFI_SSID}. This is only used if
 * the {@link #EXTRA_PROVISIONING_WIFI_SECURITY_TYPE} is {@code EAP}.
 *
 * <p>Use in an NFC record with {@link #MIME_TYPE_PROVISIONING_NFC} that starts device owner
 * provisioning via an NFC bump. It can also be used for QR code provisioning.
 * @apiSince 29
 */

public static final java.lang.String EXTRA_PROVISIONING_WIFI_DOMAIN = "android.app.extra.PROVISIONING_WIFI_DOMAIN";

/**
 * The EAP method of the wifi network in {@link #EXTRA_PROVISIONING_WIFI_SSID}
 * and could be one of {@code PEAP}, {@code TLS}, {@code TTLS}, {@code PWD}, {@code SIM},
 * {@code AKA} or {@code AKA_PRIME}. This is only used if the
 * {@link #EXTRA_PROVISIONING_WIFI_SECURITY_TYPE} is {@code EAP}.
 *
 * <p>Use in an NFC record with {@link #MIME_TYPE_PROVISIONING_NFC} that starts device owner
 * provisioning via an NFC bump. It can also be used for QR code provisioning.
 * @apiSince 29
 */

public static final java.lang.String EXTRA_PROVISIONING_WIFI_EAP_METHOD = "android.app.extra.PROVISIONING_WIFI_EAP_METHOD";

/**
 * A boolean extra indicating whether the wifi network in {@link #EXTRA_PROVISIONING_WIFI_SSID}
 * is hidden or not.
 *
 * <p>Use in an NFC record with {@link #MIME_TYPE_PROVISIONING_NFC} that starts device owner
 * provisioning via an NFC bump.
 * @apiSince 21
 */

public static final java.lang.String EXTRA_PROVISIONING_WIFI_HIDDEN = "android.app.extra.PROVISIONING_WIFI_HIDDEN";

/**
 * The identity of the wifi network in {@link #EXTRA_PROVISIONING_WIFI_SSID}. This is only used
 * if the {@link #EXTRA_PROVISIONING_WIFI_SECURITY_TYPE} is {@code EAP}.
 *
 * <p>Use in an NFC record with {@link #MIME_TYPE_PROVISIONING_NFC} that starts device owner
 * provisioning via an NFC bump. It can also be used for QR code provisioning.
 * @apiSince 29
 */

public static final java.lang.String EXTRA_PROVISIONING_WIFI_IDENTITY = "android.app.extra.PROVISIONING_WIFI_IDENTITY";

/**
 * A String extra holding the proxy auto-config (PAC) URL for the wifi network in
 * {@link #EXTRA_PROVISIONING_WIFI_SSID}.
 *
 * <p>Use in an NFC record with {@link #MIME_TYPE_PROVISIONING_NFC} that starts device owner
 * provisioning via an NFC bump.
 * @apiSince 21
 */

public static final java.lang.String EXTRA_PROVISIONING_WIFI_PAC_URL = "android.app.extra.PROVISIONING_WIFI_PAC_URL";

/**
 * A String extra holding the password of the wifi network in
 * {@link #EXTRA_PROVISIONING_WIFI_SSID}.
 *
 * <p>Use in an NFC record with {@link #MIME_TYPE_PROVISIONING_NFC} that starts device owner
 * provisioning via an NFC bump.
 * @apiSince 21
 */

public static final java.lang.String EXTRA_PROVISIONING_WIFI_PASSWORD = "android.app.extra.PROVISIONING_WIFI_PASSWORD";

/**
 * The phase 2 authentication of the wifi network in {@link #EXTRA_PROVISIONING_WIFI_SSID}
 * and could be one of {@code NONE}, {@code PAP}, {@code MSCHAP}, {@code MSCHAPV2}, {@code GTC},
 * {@code SIM}, {@code AKA} or {@code AKA_PRIME}. This is only used if the
 * {@link #EXTRA_PROVISIONING_WIFI_SECURITY_TYPE} is {@code EAP}.
 *
 * <p>Use in an NFC record with {@link #MIME_TYPE_PROVISIONING_NFC} that starts device owner
 * provisioning via an NFC bump. It can also be used for QR code provisioning.
 * @apiSince 29
 */

public static final java.lang.String EXTRA_PROVISIONING_WIFI_PHASE2_AUTH = "android.app.extra.PROVISIONING_WIFI_PHASE2_AUTH";

/**
 * A String extra holding the proxy bypass for the wifi network in
 * {@link #EXTRA_PROVISIONING_WIFI_SSID}.
 *
 * <p>Use in an NFC record with {@link #MIME_TYPE_PROVISIONING_NFC} that starts device owner
 * provisioning via an NFC bump.
 * @apiSince 21
 */

public static final java.lang.String EXTRA_PROVISIONING_WIFI_PROXY_BYPASS = "android.app.extra.PROVISIONING_WIFI_PROXY_BYPASS";

/**
 * A String extra holding the proxy host for the wifi network in
 * {@link #EXTRA_PROVISIONING_WIFI_SSID}.
 *
 * <p>Use in an NFC record with {@link #MIME_TYPE_PROVISIONING_NFC} that starts device owner
 * provisioning via an NFC bump.
 * @apiSince 21
 */

public static final java.lang.String EXTRA_PROVISIONING_WIFI_PROXY_HOST = "android.app.extra.PROVISIONING_WIFI_PROXY_HOST";

/**
 * An int extra holding the proxy port for the wifi network in
 * {@link #EXTRA_PROVISIONING_WIFI_SSID}.
 *
 * <p>Use in an NFC record with {@link #MIME_TYPE_PROVISIONING_NFC} that starts device owner
 * provisioning via an NFC bump.
 * @apiSince 21
 */

public static final java.lang.String EXTRA_PROVISIONING_WIFI_PROXY_PORT = "android.app.extra.PROVISIONING_WIFI_PROXY_PORT";

/**
 * A String extra indicating the security type of the wifi network in
 * {@link #EXTRA_PROVISIONING_WIFI_SSID} and could be one of {@code NONE}, {@code WPA},
 * {@code WEP} or {@code EAP}.
 *
 * <p>Use in an NFC record with {@link #MIME_TYPE_PROVISIONING_NFC} that starts device owner
 * provisioning via an NFC bump.
 * @apiSince 21
 */

public static final java.lang.String EXTRA_PROVISIONING_WIFI_SECURITY_TYPE = "android.app.extra.PROVISIONING_WIFI_SECURITY_TYPE";

/**
 * A String extra holding the ssid of the wifi network that should be used during nfc device
 * owner provisioning for downloading the mobile device management application.
 *
 * <p>Use in an NFC record with {@link #MIME_TYPE_PROVISIONING_NFC} that starts device owner
 * provisioning via an NFC bump.
 * @apiSince 21
 */

public static final java.lang.String EXTRA_PROVISIONING_WIFI_SSID = "android.app.extra.PROVISIONING_WIFI_SSID";

/**
 * The user certificate of the wifi network in {@link #EXTRA_PROVISIONING_WIFI_SSID}. This
 * should be an X.509 certificate and private key Base64 encoded DER format, ie. PEM
 * representation of a certificate and key without header, footer and line breaks. <a href=
 * "https://tools.ietf.org/html/rfc7468"> More information</a> This is only
 * used if the {@link #EXTRA_PROVISIONING_WIFI_SECURITY_TYPE} is {@code EAP}.
 *
 * <p>Use in an NFC record with {@link #MIME_TYPE_PROVISIONING_NFC} that starts device owner
 * provisioning via an NFC bump. It can also be used for QR code provisioning.
 * @apiSince 29
 */

public static final java.lang.String EXTRA_PROVISIONING_WIFI_USER_CERTIFICATE = "android.app.extra.PROVISIONING_WIFI_USER_CERTIFICATE";

/**
 * Flag for {@link #lockNow(int)}: also evict the user's credential encryption key from the
 * keyring. The user's credential will need to be entered again in order to derive the
 * credential encryption key that will be stored back in the keyring for future use.
 * <p>
 * This flag can only be used by a profile owner when locking a managed profile when
 * {@link #getStorageEncryptionStatus} returns {@link #ENCRYPTION_STATUS_ACTIVE_PER_USER}.
 * <p>
 * In order to secure user data, the user will be stopped and restarted so apps should wait
 * until they are next run to perform further actions.
 * @apiSince 26
 */

public static final int FLAG_EVICT_CREDENTIAL_ENCRYPTION_KEY = 1; // 0x1

/**
 * Flag used by {@link #addCrossProfileIntentFilter} to allow activities in
 * the managed profile to access intents sent from the parent profile.
 * That is, when an app in the parent profile calls
 * {@link android.app.Activity#startActivity(android.content.Intent) Activity#startActivity(Intent)}, the intent can be resolved by a
 * matching activity in the managed profile.
 * @apiSince 21
 */

public static final int FLAG_MANAGED_CAN_ACCESS_PARENT = 2; // 0x2

/**
 * Flag used by {@link #addCrossProfileIntentFilter} to allow activities in
 * the parent profile to access intents sent from the managed profile.
 * That is, when an app in the managed profile calls
 * {@link android.app.Activity#startActivity(android.content.Intent) Activity#startActivity(Intent)}, the intent can be resolved by a
 * matching activity in the parent profile.
 * @apiSince 21
 */

public static final int FLAG_PARENT_CAN_ACCESS_MANAGED = 1; // 0x1

/**
 * Specifies that the device should attest its manufacturer details. For use with
 * {@link #generateKeyPair}.
 *
 * @see #generateKeyPair
 * @apiSince 28
 */

public static final int ID_TYPE_BASE_INFO = 1; // 0x1

/**
 * Specifies that the device should attest its IMEI. For use with {@link #generateKeyPair}.
 *
 * @see #generateKeyPair
 * @apiSince 28
 */

public static final int ID_TYPE_IMEI = 4; // 0x4

/**
 * Specifies that the device should attest its MEID. For use with {@link #generateKeyPair}.
 *
 * @see #generateKeyPair
 * @apiSince 28
 */

public static final int ID_TYPE_MEID = 8; // 0x8

/**
 * Specifies that the device should attest its serial number. For use with
 * {@link #generateKeyPair}.
 *
 * @see #generateKeyPair
 * @apiSince 28
 */

public static final int ID_TYPE_SERIAL = 2; // 0x2

/**
 * Specifies that the calling app should be granted access to the installed credentials
 * immediately. Otherwise, access to the credentials will be gated by user approval.
 * For use with {@link #installKeyPair(android.content.ComponentName,java.security.PrivateKey,java.security.cert.Certificate[],java.lang.String,int)}
 *
 * @see #installKeyPair(ComponentName, PrivateKey, Certificate[], String, int)
 * @apiSince 28
 */

public static final int INSTALLKEY_REQUEST_CREDENTIALS_ACCESS = 1; // 0x1

/**
 * Specifies that a user can select the key via the Certificate Selection prompt.
 * If this flag is not set when calling {@link #installKeyPair}, the key can only be granted
 * access by implementing {@link android.app.admin.DeviceAdminReceiver#onChoosePrivateKeyAlias}.
 * For use with {@link #installKeyPair(android.content.ComponentName,java.security.PrivateKey,java.security.cert.Certificate[],java.lang.String,int)}
 *
 * @see #installKeyPair(ComponentName, PrivateKey, Certificate[], String, int)
 * @apiSince 28
 */

public static final int INSTALLKEY_SET_USER_SELECTABLE = 2; // 0x2

/**
 * Disable all biometric authentication on keyguard secure screens (e.g.&nbsp;PIN/Pattern/Password).
 * @apiSince 28
 */

public static final int KEYGUARD_DISABLE_BIOMETRICS = 416; // 0x1a0

/**
 * Disable face authentication on keyguard secure screens (e.g.&nbsp;PIN/Pattern/Password).
 * @apiSince 28
 */

public static final int KEYGUARD_DISABLE_FACE = 128; // 0x80

/**
 * Disable all current and future keyguard customizations.
 * @apiSince 17
 */

public static final int KEYGUARD_DISABLE_FEATURES_ALL = 2147483647; // 0x7fffffff

/**
 * Widgets are enabled in keyguard
 * @apiSince 17
 */

public static final int KEYGUARD_DISABLE_FEATURES_NONE = 0; // 0x0

/**
 * Disable fingerprint authentication on keyguard secure screens (e.g.&nbsp;PIN/Pattern/Password).
 * @apiSince 21
 */

public static final int KEYGUARD_DISABLE_FINGERPRINT = 32; // 0x20

/**
 * Disable iris authentication on keyguard secure screens (e.g.&nbsp;PIN/Pattern/Password).
 * @apiSince 28
 */

public static final int KEYGUARD_DISABLE_IRIS = 256; // 0x100

/**
 * Disable text entry into notifications on secure keyguard screens (e.g.&nbsp;PIN/Pattern/Password).
 * This flag has no effect starting from version {@link android.os.Build.VERSION_CODES#N}
 * @apiSince 24
 */

public static final int KEYGUARD_DISABLE_REMOTE_INPUT = 64; // 0x40

/**
 * Disable the camera on secure keyguard screens (e.g.&nbsp;PIN/Pattern/Password)
 * @apiSince 17
 */

public static final int KEYGUARD_DISABLE_SECURE_CAMERA = 2; // 0x2

/**
 * Disable showing all notifications on secure keyguard screens (e.g.&nbsp;PIN/Pattern/Password)
 * @apiSince 21
 */

public static final int KEYGUARD_DISABLE_SECURE_NOTIFICATIONS = 4; // 0x4

/**
 * Disable trust agents on secure keyguard screens (e.g.&nbsp;PIN/Pattern/Password).
 * By setting this flag alone, all trust agents are disabled. If the admin then wants to
 * whitelist specific features of some trust agent, {@link #setTrustAgentConfiguration} can be
 * used in conjuction to set trust-agent-specific configurations.
 * @apiSince 21
 */

public static final int KEYGUARD_DISABLE_TRUST_AGENTS = 16; // 0x10

/**
 * Only allow redacted notifications on secure keyguard screens (e.g.&nbsp;PIN/Pattern/Password)
 * @apiSince 21
 */

public static final int KEYGUARD_DISABLE_UNREDACTED_NOTIFICATIONS = 8; // 0x8

/**
 * Disable all keyguard widgets. Has no effect starting from
 * {@link android.os.Build.VERSION_CODES#LOLLIPOP} since keyguard widget is only supported
 * on Android versions lower than 5.0.
 * @apiSince 17
 */

public static final int KEYGUARD_DISABLE_WIDGETS_ALL = 1; // 0x1

/**
 * Flag used by {@link #createAndManageUser} to specify that the newly created user should skip
 * the disabling of system apps during provisioning.
 * @apiSince 28
 */

public static final int LEAVE_ALL_SYSTEM_APPS_ENABLED = 16; // 0x10

/**
 * Enable the global actions dialog during LockTask mode. This is the dialog that shows up when
 * the user long-presses the power button, for example. Note that the user may not be able to
 * power off the device if this flag is not set.
 *
 * <p>This flag is enabled by default until {@link #setLockTaskFeatures(android.content.ComponentName,int)} is
 * called for the first time.
 *
 * @see #setLockTaskFeatures(ComponentName, int)
 * @apiSince 28
 */

public static final int LOCK_TASK_FEATURE_GLOBAL_ACTIONS = 16; // 0x10

/**
 * Enable the Home button during LockTask mode. Note that if a custom launcher is used, it has
 * to be registered as the default launcher with
 * {@link #addPersistentPreferredActivity(android.content.ComponentName,android.content.IntentFilter,android.content.ComponentName)}, and its
 * package needs to be whitelisted for LockTask with
 * {@link #setLockTaskPackages(android.content.ComponentName,java.lang.String[])}.
 *
 * @see #setLockTaskFeatures(ComponentName, int)
 * @apiSince 28
 */

public static final int LOCK_TASK_FEATURE_HOME = 4; // 0x4

/**
 * Enable the keyguard during LockTask mode. Note that if the keyguard is already disabled with
 * {@link #setKeyguardDisabled(android.content.ComponentName,boolean)}, setting this flag will have no effect.
 * If this flag is not set, the keyguard will not be shown even if the user has a lock screen
 * credential.
 *
 * @see #setLockTaskFeatures(ComponentName, int)
 * @apiSince 28
 */

public static final int LOCK_TASK_FEATURE_KEYGUARD = 32; // 0x20

/**
 * Disable all configurable SystemUI features during LockTask mode. This includes,
 * <ul>
 *     <li>system info area in the status bar (connectivity icons, clock, etc.)
 *     <li>notifications (including alerts, icons, and the notification shade)
 *     <li>Home button
 *     <li>Recents button and UI
 *     <li>global actions menu (i.e. power button menu)
 *     <li>keyguard
 * </ul>
 *
 * @see #setLockTaskFeatures(ComponentName, int)
 * @apiSince 28
 */

public static final int LOCK_TASK_FEATURE_NONE = 0; // 0x0

/**
 * Enable notifications during LockTask mode. This includes notification icons on the status
 * bar, heads-up notifications, and the expandable notification shade. Note that the Quick
 * Settings panel remains disabled. This feature flag can only be used in combination with
 * {@link #LOCK_TASK_FEATURE_HOME}. {@link #setLockTaskFeatures(android.content.ComponentName,int)}
 * throws an {@link java.lang.IllegalArgumentException IllegalArgumentException} if this feature flag is defined without
 * {@link #LOCK_TASK_FEATURE_HOME}.
 *
 * @see #setLockTaskFeatures(ComponentName, int)
 * @apiSince 28
 */

public static final int LOCK_TASK_FEATURE_NOTIFICATIONS = 2; // 0x2

/**
 * Enable the Overview button and the Overview screen during LockTask mode. This feature flag
 * can only be used in combination with {@link #LOCK_TASK_FEATURE_HOME}, and
 * {@link #setLockTaskFeatures(android.content.ComponentName,int)} will throw an
 * {@link java.lang.IllegalArgumentException IllegalArgumentException} if this feature flag is defined without
 * {@link #LOCK_TASK_FEATURE_HOME}.
 *
 * @see #setLockTaskFeatures(ComponentName, int)
 * @apiSince 28
 */

public static final int LOCK_TASK_FEATURE_OVERVIEW = 8; // 0x8

/**
 * Enable the system info area in the status bar during LockTask mode. The system info area
 * usually occupies the right side of the status bar (although this can differ across OEMs). It
 * includes all system information indicators, such as date and time, connectivity, battery,
 * vibration mode, etc.
 *
 * @see #setLockTaskFeatures(ComponentName, int)
 * @apiSince 28
 */

public static final int LOCK_TASK_FEATURE_SYSTEM_INFO = 1; // 0x1

/**
 * Flag used by {@link #createAndManageUser} to specify that the user should be created
 * ephemeral. Ephemeral users will be removed after switching to another user or rebooting the
 * device.
 * @apiSince 28
 */

public static final int MAKE_USER_EPHEMERAL = 2; // 0x2

/**
 * This MIME type is used for starting the device owner provisioning.
 *
 * <p>During device owner provisioning a device admin app is set as the owner of the device.
 * A device owner has full control over the device. The device owner can not be modified by the
 * user and the only way of resetting the device is if the device owner app calls a factory
 * reset.
 *
 * <p> A typical use case would be a device that is owned by a company, but used by either an
 * employee or client.
 *
 * <p> The NFC message must be sent to an unprovisioned device.
 *
 * <p>The NFC record must contain a serialized {@link java.util.Properties} object which
 * contains the following properties:
 * <ul>
 * <li>{@link #EXTRA_PROVISIONING_DEVICE_ADMIN_PACKAGE_NAME}</li>
 * <li>{@link #EXTRA_PROVISIONING_DEVICE_ADMIN_PACKAGE_DOWNLOAD_LOCATION}, optional</li>
 * <li>{@link #EXTRA_PROVISIONING_DEVICE_ADMIN_PACKAGE_DOWNLOAD_COOKIE_HEADER}, optional</li>
 * <li>{@link #EXTRA_PROVISIONING_DEVICE_ADMIN_PACKAGE_CHECKSUM}, optional</li>
 * <li>{@link #EXTRA_PROVISIONING_LOCAL_TIME} (convert to String), optional</li>
 * <li>{@link #EXTRA_PROVISIONING_TIME_ZONE}, optional</li>
 * <li>{@link #EXTRA_PROVISIONING_LOCALE}, optional</li>
 * <li>{@link #EXTRA_PROVISIONING_WIFI_SSID}, optional</li>
 * <li>{@link #EXTRA_PROVISIONING_WIFI_HIDDEN} (convert to String), optional</li>
 * <li>{@link #EXTRA_PROVISIONING_WIFI_SECURITY_TYPE}, optional</li>
 * <li>{@link #EXTRA_PROVISIONING_WIFI_PASSWORD}, optional</li>
 * <li>{@link #EXTRA_PROVISIONING_WIFI_PROXY_HOST}, optional</li>
 * <li>{@link #EXTRA_PROVISIONING_WIFI_PROXY_PORT} (convert to String), optional</li>
 * <li>{@link #EXTRA_PROVISIONING_WIFI_PROXY_BYPASS}, optional</li>
 * <li>{@link #EXTRA_PROVISIONING_WIFI_PAC_URL}, optional</li>
 * <li>{@link #EXTRA_PROVISIONING_ADMIN_EXTRAS_BUNDLE}, optional, supported from {@link
 * android.os.Build.VERSION_CODES#M} </li>
 * <li>{@link #EXTRA_PROVISIONING_WIFI_EAP_METHOD}, optional, supported from {@link
 * android.os.Build.VERSION_CODES#Q}</li>
 * <li>{@link #EXTRA_PROVISIONING_WIFI_PHASE2_AUTH}, optional, supported from {@link
 * android.os.Build.VERSION_CODES#Q}</li>
 * <li>{@link #EXTRA_PROVISIONING_WIFI_CA_CERTIFICATE}, optional, supported from {@link
 * android.os.Build.VERSION_CODES#Q}</li>
 * <li>{@link #EXTRA_PROVISIONING_WIFI_USER_CERTIFICATE}, optional, supported from {@link
 * android.os.Build.VERSION_CODES#Q}</li>
 * <li>{@link #EXTRA_PROVISIONING_WIFI_IDENTITY}, optional, supported from {@link
 * android.os.Build.VERSION_CODES#Q}</li>
 * <li>{@link #EXTRA_PROVISIONING_WIFI_ANONYMOUS_IDENTITY}, optional, supported from {@link
 * android.os.Build.VERSION_CODES#Q}</li>
 * <li>{@link #EXTRA_PROVISIONING_WIFI_DOMAIN}, optional, supported from {@link
 * android.os.Build.VERSION_CODES#Q}</li></ul>
 *
 * <p>
 * As of {@link android.os.Build.VERSION_CODES#M}, the properties should contain
 * {@link #EXTRA_PROVISIONING_DEVICE_ADMIN_COMPONENT_NAME} instead of
 * {@link #EXTRA_PROVISIONING_DEVICE_ADMIN_PACKAGE_NAME}, (although specifying only
 * {@link #EXTRA_PROVISIONING_DEVICE_ADMIN_PACKAGE_NAME} is still supported).
 * @apiSince 21
 */

public static final java.lang.String MIME_TYPE_PROVISIONING_NFC = "application/com.android.managedprovisioning";

/**
 * Constant for {@link #getPasswordComplexity()}: password satisfies one of the following:
 * <ul>
 * <li>PIN with <b>no</b> repeating (4444) or ordered (1234, 4321, 2468) sequences, length at
 * least 8
 * <li>alphabetic, length at least 6
 * <li>alphanumeric, length at least 6
 * </ul>
 *
 * <p>Note that these complexity constants are ordered so that higher values are more complex.
 *
 * @see #PASSWORD_QUALITY_NUMERIC_COMPLEX
 * @see #PASSWORD_QUALITY_ALPHABETIC
 * @see #PASSWORD_QUALITY_ALPHANUMERIC
 * @apiSince 29
 */

public static final int PASSWORD_COMPLEXITY_HIGH = 327680; // 0x50000

/**
 * Constant for {@link #getPasswordComplexity()}: password satisfies one of the following:
 * <ul>
 * <li>pattern
 * <li>PIN with repeating (4444) or ordered (1234, 4321, 2468) sequences
 * </ul>
 *
 * <p>Note that these complexity constants are ordered so that higher values are more complex.
 *
 * @see #PASSWORD_QUALITY_SOMETHING
 * @see #PASSWORD_QUALITY_NUMERIC
 * @apiSince 29
 */

public static final int PASSWORD_COMPLEXITY_LOW = 65536; // 0x10000

/**
 * Constant for {@link #getPasswordComplexity()}: password satisfies one of the following:
 * <ul>
 * <li>PIN with <b>no</b> repeating (4444) or ordered (1234, 4321, 2468) sequences, length at
 * least 4
 * <li>alphabetic, length at least 4
 * <li>alphanumeric, length at least 4
 * </ul>
 *
 * <p>Note that these complexity constants are ordered so that higher values are more complex.
 *
 * @see #PASSWORD_QUALITY_NUMERIC_COMPLEX
 * @see #PASSWORD_QUALITY_ALPHABETIC
 * @see #PASSWORD_QUALITY_ALPHANUMERIC
 * @apiSince 29
 */

public static final int PASSWORD_COMPLEXITY_MEDIUM = 196608; // 0x30000

/**
 * Constant for {@link #getPasswordComplexity()}: no password.
 *
 * <p>Note that these complexity constants are ordered so that higher values are more complex.
 * @apiSince 29
 */

public static final int PASSWORD_COMPLEXITY_NONE = 0; // 0x0

/**
 * Constant for {@link #setPasswordQuality}: the user must have entered a
 * password containing at least alphabetic (or other symbol) characters.
 * Note that quality constants are ordered so that higher values are more
 * restrictive.
 * @apiSince 8
 */

public static final int PASSWORD_QUALITY_ALPHABETIC = 262144; // 0x40000

/**
 * Constant for {@link #setPasswordQuality}: the user must have entered a
 * password containing at least <em>both></em> numeric <em>and</em>
 * alphabetic (or other symbol) characters.  Note that quality constants are
 * ordered so that higher values are more restrictive.
 * @apiSince 8
 */

public static final int PASSWORD_QUALITY_ALPHANUMERIC = 327680; // 0x50000

/**
 * Constant for {@link #setPasswordQuality}: the policy allows for low-security biometric
 * recognition technology.  This implies technologies that can recognize the identity of
 * an individual to about a 3 digit PIN (false detection is less than 1 in 1,000).
 * Note that quality constants are ordered so that higher values are more restrictive.
 * @apiSince 14
 */

public static final int PASSWORD_QUALITY_BIOMETRIC_WEAK = 32768; // 0x8000

/**
 * Constant for {@link #setPasswordQuality}: the user must have entered a
 * password containing at least a letter, a numerical digit and a special
 * symbol, by default. With this password quality, passwords can be
 * restricted to contain various sets of characters, like at least an
 * uppercase letter, etc. These are specified using various methods,
 * like {@link #setPasswordMinimumLowerCase(android.content.ComponentName,int)}. Note
 * that quality constants are ordered so that higher values are more
 * restrictive.
 * @apiSince 11
 */

public static final int PASSWORD_QUALITY_COMPLEX = 393216; // 0x60000

/**
 * Constant for {@link #setPasswordQuality}: the user must have entered a
 * password containing at least numeric characters.  Note that quality
 * constants are ordered so that higher values are more restrictive.
 * @apiSince 8
 */

public static final int PASSWORD_QUALITY_NUMERIC = 131072; // 0x20000

/**
 * Constant for {@link #setPasswordQuality}: the user must have entered a
 * password containing at least numeric characters with no repeating (4444)
 * or ordered (1234, 4321, 2468) sequences.  Note that quality
 * constants are ordered so that higher values are more restrictive.
 * @apiSince 21
 */

public static final int PASSWORD_QUALITY_NUMERIC_COMPLEX = 196608; // 0x30000

/**
 * Constant for {@link #setPasswordQuality}: the policy requires some kind
 * of password or pattern, but doesn't care what it is. Note that quality constants
 * are ordered so that higher values are more restrictive.
 * @apiSince 8
 */

public static final int PASSWORD_QUALITY_SOMETHING = 65536; // 0x10000

/**
 * Constant for {@link #setPasswordQuality}: the policy has no requirements
 * for the password.  Note that quality constants are ordered so that higher
 * values are more restrictive.
 * @apiSince 8
 */

public static final int PASSWORD_QUALITY_UNSPECIFIED = 0; // 0x0

/**
 * Runtime permission state: The user can manage the permission
 * through the UI.
 * @apiSince 23
 */

public static final int PERMISSION_GRANT_STATE_DEFAULT = 0; // 0x0

/**
 * Runtime permission state: The permission is denied to the app
 * and the user cannot manage the permission through the UI.
 * @apiSince 23
 */

public static final int PERMISSION_GRANT_STATE_DENIED = 2; // 0x2

/**
 * Runtime permission state: The permission is granted to the app
 * and the user cannot manage the permission through the UI.
 * @apiSince 23
 */

public static final int PERMISSION_GRANT_STATE_GRANTED = 1; // 0x1

/**
 * Permission policy to always deny new permission requests for runtime permissions.
 * Already granted or denied permissions are not affected by this.
 * @apiSince 23
 */

public static final int PERMISSION_POLICY_AUTO_DENY = 2; // 0x2

/**
 * Permission policy to always grant new permission requests for runtime permissions.
 * Already granted or denied permissions are not affected by this.
 * @apiSince 23
 */

public static final int PERMISSION_POLICY_AUTO_GRANT = 1; // 0x1

/**
 * Permission policy to prompt user for new permission requests for runtime permissions.
 * Already granted or denied permissions are not affected by this.
 * @apiSince 23
 */

public static final int PERMISSION_POLICY_PROMPT = 0; // 0x0

/**
 * Constant to indicate the feature of disabling the camera. Used as argument to
 * {@link #createAdminSupportIntent(java.lang.String)}.
 * @see #setCameraDisabled(ComponentName, boolean)
 * @apiSince 26
 */

public static final java.lang.String POLICY_DISABLE_CAMERA = "policy_disable_camera";

/**
 * Constant to indicate the feature of disabling screen captures. Used as argument to
 * {@link #createAdminSupportIntent(java.lang.String)}.
 * @see #setScreenCaptureDisabled(ComponentName, boolean)
 * @apiSince 26
 */

public static final java.lang.String POLICY_DISABLE_SCREEN_CAPTURE = "policy_disable_screen_capture";

/**
 * Specifies that Private DNS was turned off completely.
 * @apiSince 29
 */

public static final int PRIVATE_DNS_MODE_OFF = 1; // 0x1

/**
 * Specifies that the device owner requested opportunistic DNS over TLS
 * @apiSince 29
 */

public static final int PRIVATE_DNS_MODE_OPPORTUNISTIC = 2; // 0x2

/**
 * Specifies that the device owner configured a specific host to use for Private DNS.
 * @apiSince 29
 */

public static final int PRIVATE_DNS_MODE_PROVIDER_HOSTNAME = 3; // 0x3

/**
 * Specifies that the Private DNS setting is in an unknown state.
 * @apiSince 29
 */

public static final int PRIVATE_DNS_MODE_UNKNOWN = 0; // 0x0

/**
 * General failure to set the Private DNS mode, not due to one of the reasons listed above.
 * @apiSince 29
 */

public static final int PRIVATE_DNS_SET_ERROR_FAILURE_SETTING = 2; // 0x2

/**
 * If the {@code privateDnsHost} provided was of a valid hostname but that host was found
 * to not support DNS-over-TLS.
 * @apiSince 29
 */

public static final int PRIVATE_DNS_SET_ERROR_HOST_NOT_SERVING = 1; // 0x1

/**
 * The selected mode has been set successfully. If the mode is
 * {@code PRIVATE_DNS_MODE_PROVIDER_HOSTNAME} then it implies the supplied host is valid
 * and reachable.
 * @apiSince 29
 */

public static final int PRIVATE_DNS_SET_NO_ERROR = 0; // 0x0

/**
 * The provisioning mode for fully managed device.
 * @apiSince 29
 */

public static final int PROVISIONING_MODE_FULLY_MANAGED_DEVICE = 1; // 0x1

/**
 * The provisioning mode for managed profile.
 * @apiSince 29
 */

public static final int PROVISIONING_MODE_MANAGED_PROFILE = 2; // 0x2

/**
 * Flag for {@link #resetPasswordWithToken} and {@link #resetPassword}: don't ask for user
 * credentials on device boot.
 * If the flag is set, the device can be booted without asking for user password.
 * The absence of this flag does not change the current boot requirements. This flag
 * can be set by the device owner only. If the app is not the device owner, the flag
 * is ignored. Once the flag is set, it cannot be reverted back without resetting the
 * device to factory defaults.
 * @apiSince 23
 */

public static final int RESET_PASSWORD_DO_NOT_ASK_CREDENTIALS_ON_BOOT = 2; // 0x2

/**
 * Flag for {@link #resetPasswordWithToken} and {@link #resetPassword}: don't allow other admins
 * to change the password again until the user has entered it.
 * @apiSince 8
 */

public static final int RESET_PASSWORD_REQUIRE_ENTRY = 1; // 0x1

/**
 * Flag used by {@link #createAndManageUser} to skip setup wizard after creating a new user.
 * @apiSince 24
 */

public static final int SKIP_SETUP_WIZARD = 1; // 0x1

/**
 * Flag for {@link #wipeData(int)}: also erase the device's eUICC data.
 * @apiSince 28
 */

public static final int WIPE_EUICC = 4; // 0x4

/**
 * Flag for {@link #wipeData(int)}: also erase the device's external
 * storage (such as SD cards).
 * @apiSince 9
 */

public static final int WIPE_EXTERNAL_STORAGE = 1; // 0x1

/**
 * Flag for {@link #wipeData(int)}: also erase the factory reset protection
 * data.
 *
 * <p>This flag may only be set by device owner admins; if it is set by
 * other admins a {@link java.lang.SecurityException SecurityException} will be thrown.
 * @apiSince 22
 */

public static final int WIPE_RESET_PROTECTION_DATA = 2; // 0x2

/**
 * Flag for {@link #wipeData(int)}: won't show reason for wiping to the user.
 * @apiSince 29
 */

public static final int WIPE_SILENTLY = 8; // 0x8
/**
 * Callback used in {@link #installSystemUpdate} to indicate that there was an error while
 * trying to install an update.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class InstallSystemUpdateCallback {

public InstallSystemUpdateCallback() { throw new RuntimeException("Stub!"); }

/**
 * Method invoked when there was an error while installing an update.
 *
 * <p>The given error message is not intended to be user-facing. It is intended to be
 * reported back to the IT admin to be read.
 
 * @param errorCode Value is {@link android.app.admin.DevicePolicyManager.InstallSystemUpdateCallback#UPDATE_ERROR_UNKNOWN}, {@link android.app.admin.DevicePolicyManager.InstallSystemUpdateCallback#UPDATE_ERROR_INCORRECT_OS_VERSION}, {@link android.app.admin.DevicePolicyManager.InstallSystemUpdateCallback#UPDATE_ERROR_UPDATE_FILE_INVALID}, {@link android.app.admin.DevicePolicyManager.InstallSystemUpdateCallback#UPDATE_ERROR_FILE_NOT_FOUND}, or {@link android.app.admin.DevicePolicyManager.InstallSystemUpdateCallback#UPDATE_ERROR_BATTERY_LOW}
 
 * @param errorMessage This value must never be {@code null}.
 * @apiSince 29
 */

public void onInstallUpdateError(int errorCode, @androidx.annotation.NonNull java.lang.String errorMessage) { throw new RuntimeException("Stub!"); }

/**
 * Represents the battery being too low to apply an update.
 * @apiSince 29
 */

public static final int UPDATE_ERROR_BATTERY_LOW = 5; // 0x5

/**
 * Represents that the file could not be found.
 * @apiSince 29
 */

public static final int UPDATE_ERROR_FILE_NOT_FOUND = 4; // 0x4

/**
 * Represents the update file being intended for different OS version.
 * @apiSince 29
 */

public static final int UPDATE_ERROR_INCORRECT_OS_VERSION = 2; // 0x2

/**
 * Represents an unknown error while trying to install an update.
 * @apiSince 29
 */

public static final int UPDATE_ERROR_UNKNOWN = 1; // 0x1

/**
 * Represents the update file being wrong; e.g.&nbsp;payloads are mismatched, or the wrong
 * compression method is used.
 * @apiSince 29
 */

public static final int UPDATE_ERROR_UPDATE_FILE_INVALID = 3; // 0x3
}

/**
 * Callback used in {@link #clearApplicationUserData}
 * to indicate that the clearing of an application's user data is done.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnClearApplicationUserDataListener {

/**
 * Method invoked when clearing the application user data has completed.
 *
 * @param packageName The name of the package which had its user data cleared.
 * @param succeeded Whether the clearing succeeded. Clearing fails for device administrator
 *                  apps and protected system packages.
 * @apiSince 28
 */

public void onApplicationUserDataCleared(java.lang.String packageName, boolean succeeded);
}

}

