/*
 * Copyright (C) 2018 The Android Open Source Project
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


package android.app.role;

import android.content.Intent;

/**
 * This class provides information about and manages roles.
 * <p>
 * A role is a unique name within the system associated with certain privileges. The list of
 * available roles might change with a system app update, so apps should not make assumption about
 * the availability of roles. Instead, they should always query if the role is available using
 * {@link #isRoleAvailable(java.lang.String)} before trying to do anything with it. Some predefined role names
 * are available as constants in this class, and a list of possibly available roles can be found in
 * the <a href="{@docRoot}reference/androidx/core/role/package-summary.html">AndroidX Role
 * library</a>.
 * <p>
 * There can be multiple applications qualifying for a role, but only a subset of them can become
 * role holders. To qualify for a role, an application must meet certain requirements, including
 * defining certain components in its manifest. These requirements can be found in the AndroidX
 * Libraries. Then the application will need user consent to become a role holder, which can be
 * requested using {@link android.app.Activity#startActivityForResult(Intent, int)} with the
 * {@code Intent} obtained from {@link #createRequestRoleIntent(java.lang.String)}.
 * <p>
 * Upon becoming a role holder, the application may be granted certain privileges that are role
 * specific. When the application loses its role, these privileges will also be revoked.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class RoleManager {

RoleManager() { throw new RuntimeException("Stub!"); }

/**
 * Returns an {@code Intent} suitable for passing to
 * {@link android.app.Activity#startActivityForResult(Intent, int)} which prompts the user to
 * grant a role to this application.
 * <p>
 * If the role is granted, the {@code resultCode} will be
 * {@link android.app.Activity#RESULT_OK}, otherwise it will be
 * {@link android.app.Activity#RESULT_CANCELED}.
 *
 * @param roleName the name of requested role
 *
 * This value must never be {@code null}.
 * @return the {@code Intent} to prompt user to grant the role
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.content.Intent createRequestRoleIntent(@androidx.annotation.NonNull java.lang.String roleName) { throw new RuntimeException("Stub!"); }

/**
 * Check whether a role is available in the system.
 *
 * @param roleName the name of role to checking for
 *
 * This value must never be {@code null}.
 * @return whether the role is available in the system
 * @apiSince 29
 */

public boolean isRoleAvailable(@androidx.annotation.NonNull java.lang.String roleName) { throw new RuntimeException("Stub!"); }

/**
 * Check whether the calling application is holding a particular role.
 *
 * @param roleName the name of the role to check for
 *
 * This value must never be {@code null}.
 * @return whether the calling application is holding the role
 * @apiSince 29
 */

public boolean isRoleHeld(@androidx.annotation.NonNull java.lang.String roleName) { throw new RuntimeException("Stub!"); }

/**
 * The name of the assistant app role.
 *
 * @see android.service.voice.VoiceInteractionService
 * @apiSince 29
 */

public static final java.lang.String ROLE_ASSISTANT = "android.app.role.ASSISTANT";

/**
 * The name of the browser role.
 *
 * @see android.content.Intent#CATEGORY_APP_BROWSER
 * @apiSince 29
 */

public static final java.lang.String ROLE_BROWSER = "android.app.role.BROWSER";

/**
 * The name of the call redirection role.
 * <p>
 * A call redirection app provides a means to re-write the phone number for an outgoing call to
 * place the call through a call redirection service.
 *
 * @see android.telecom.CallRedirectionService
 * @apiSince 29
 */

public static final java.lang.String ROLE_CALL_REDIRECTION = "android.app.role.CALL_REDIRECTION";

/**
 * The name of the call screening and caller id role.
 *
 * @see android.telecom.CallScreeningService
 * @apiSince 29
 */

public static final java.lang.String ROLE_CALL_SCREENING = "android.app.role.CALL_SCREENING";

/**
 * The name of the dialer role.
 *
 * @see android.content.Intent#ACTION_DIAL
 * @apiSince 29
 */

public static final java.lang.String ROLE_DIALER = "android.app.role.DIALER";

/**
 * The name of the emergency role
 *
 * @see android.telephony.TelephonyManager#ACTION_EMERGENCY_ASSISTANCE
 * @apiSince 29
 */

public static final java.lang.String ROLE_EMERGENCY = "android.app.role.EMERGENCY";

/**
 * The name of the home role.
 *
 * @see android.content.Intent#CATEGORY_HOME
 * @apiSince 29
 */

public static final java.lang.String ROLE_HOME = "android.app.role.HOME";

/**
 * The name of the SMS role.
 *
 * @see android.content.Intent#CATEGORY_APP_MESSAGING
 * @apiSince 29
 */

public static final java.lang.String ROLE_SMS = "android.app.role.SMS";
}

