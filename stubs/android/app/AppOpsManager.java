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


package android.app;

import android.os.Binder;
import android.app.usage.UsageStatsManager;

/**
 * API for interacting with "application operation" tracking.
 *
 * <p>This API is not generally intended for third party application developers; most
 * features are only available to system applications.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AppOpsManager {

AppOpsManager() { throw new RuntimeException("Stub!"); }

/**
 * Gets the app op name associated with a given permission.
 * The app op name is one of the public constants defined
 * in this class such as {@link #OPSTR_COARSE_LOCATION}.
 * This API is intended to be used for mapping runtime
 * permissions to the corresponding app op.
 *
 * @param permission The permission.
 * @return The app op associated with the permission or null.
 * @apiSince 23
 */

public static java.lang.String permissionToOp(java.lang.String permission) { throw new RuntimeException("Stub!"); }

/**
 * Monitor for changes to the operating mode for the given op in the given app package.
 * You can watch op changes only for your UID.
 *
 * @param op The operation to monitor, one of OPSTR_*.
 * This value must never be {@code null}.
 * @param packageName The name of the application to monitor.
 * This value may be {@code null}.
 * @param callback Where to report changes.
 
 * This value must never be {@code null}.
 * @apiSince 19
 */

public void startWatchingMode(@androidx.annotation.NonNull java.lang.String op, @androidx.annotation.Nullable java.lang.String packageName, @androidx.annotation.NonNull android.app.AppOpsManager.OnOpChangedListener callback) { throw new RuntimeException("Stub!"); }

/**
 * Monitor for changes to the operating mode for the given op in the given app package.
 * You can watch op changes only for your UID.
 *
 * @param op The operation to monitor, one of OPSTR_*.
 * This value must never be {@code null}.
 * @param packageName The name of the application to monitor.
 * This value may be {@code null}.
 * @param flags Option flags: any combination of {@link #WATCH_FOREGROUND_CHANGES} or 0.
 * @param callback Where to report changes.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void startWatchingMode(@androidx.annotation.NonNull java.lang.String op, @androidx.annotation.Nullable java.lang.String packageName, int flags, @androidx.annotation.NonNull android.app.AppOpsManager.OnOpChangedListener callback) { throw new RuntimeException("Stub!"); }

/**
 * Stop monitoring that was previously started with {@link #startWatchingMode}.  All
 * monitoring associated with this callback will be removed.
 
 * @param callback This value must never be {@code null}.
 * @apiSince 19
 */

public void stopWatchingMode(@androidx.annotation.NonNull android.app.AppOpsManager.OnOpChangedListener callback) { throw new RuntimeException("Stub!"); }

/**
 * Do a quick check for whether an application might be able to perform an operation.
 * This is <em>not</em> a security check; you must use {@link #noteOp(java.lang.String,int,java.lang.String)}
 * or {@link #startOp(java.lang.String,int,java.lang.String)} for your actual security checks, which also
 * ensure that the given uid and package name are consistent.  This function can just be
 * used for a quick check to see if an operation has been disabled for the application,
 * as an early reject of some work.  This does not modify the time stamp or other data
 * about the operation.
 *
 * <p>Important things this will not do (which you need to ultimate use
 * {@link #noteOp(java.lang.String,int,java.lang.String)} or {@link #startOp(java.lang.String,int,java.lang.String)} to cover):</p>
 * <ul>
 *     <li>Verifying the uid and package are consistent, so callers can't spoof
 *     their identity.</li>
 *     <li>Taking into account the current foreground/background state of the
 *     app; apps whose mode varies by this state will always be reported
 *     as {@link #MODE_ALLOWED}.</li>
 * </ul>
 *
 * @param op The operation to check.  One of the OPSTR_* constants.
 * This value must never be {@code null}.
 * @param uid The user id of the application attempting to perform the operation.
 * @param packageName The name of the application attempting to perform the operation.
 * This value must never be {@code null}.
 * @return Returns {@link #MODE_ALLOWED} if the operation is allowed, or
 * {@link #MODE_IGNORED} if it is not allowed and should be silently ignored (without
 * causing the app to crash).
 * @throws java.lang.SecurityException If the app has been configured to crash on this op.
 * @apiSince 29
 */

public int unsafeCheckOp(@androidx.annotation.NonNull java.lang.String op, int uid, @androidx.annotation.NonNull java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Renamed to {@link #unsafeCheckOp(java.lang.String,int,java.lang.String)}.
 
 * @param op This value must never be {@code null}.
 
 * @param packageName This value must never be {@code null}.
 * @apiSince 19
 * @deprecatedSince 29
 */

@Deprecated
public int checkOp(@androidx.annotation.NonNull java.lang.String op, int uid, @androidx.annotation.NonNull java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * Like {@link #checkOp} but instead of throwing a {@link java.lang.SecurityException SecurityException} it
 * returns {@link #MODE_ERRORED}.
 
 * @param op This value must never be {@code null}.
 
 * @param packageName This value must never be {@code null}.
 * @apiSince 29
 */

public int unsafeCheckOpNoThrow(@androidx.annotation.NonNull java.lang.String op, int uid, @androidx.annotation.NonNull java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Renamed to {@link #unsafeCheckOpNoThrow(java.lang.String,int,java.lang.String)}.
 
 * @param op This value must never be {@code null}.
 
 * @param packageName This value must never be {@code null}.
 * @apiSince 19
 * @deprecatedSince 29
 */

@Deprecated
public int checkOpNoThrow(@androidx.annotation.NonNull java.lang.String op, int uid, @androidx.annotation.NonNull java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * Like {@link #checkOp} but returns the <em>raw</em> mode associated with the op.
 * Does not throw a security exception, does not translate {@link #MODE_FOREGROUND}.
 
 * @param op This value must never be {@code null}.
 
 * @param packageName This value must never be {@code null}.
 * @apiSince 29
 */

public int unsafeCheckOpRaw(@androidx.annotation.NonNull java.lang.String op, int uid, @androidx.annotation.NonNull java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * Like {@link #unsafeCheckOpNoThrow(java.lang.String,int,java.lang.String)} but returns the <em>raw</em>
 * mode associated with the op. Does not throw a security exception, does not translate
 * {@link #MODE_FOREGROUND}.
 
 * @param op This value must never be {@code null}.
 
 * @param packageName This value must never be {@code null}.
 * @apiSince 29
 */

public int unsafeCheckOpRawNoThrow(@androidx.annotation.NonNull java.lang.String op, int uid, @androidx.annotation.NonNull java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * Make note of an application performing an operation.  Note that you must pass
 * in both the uid and name of the application to be checked; this function will verify
 * that these two match, and if not, return {@link #MODE_IGNORED}.  If this call
 * succeeds, the last execution time of the operation for this app will be updated to
 * the current time.
 * @param op The operation to note.  One of the OPSTR_* constants.
 * This value must never be {@code null}.
 * @param uid The user id of the application attempting to perform the operation.
 * @param packageName The name of the application attempting to perform the operation.
 * This value must never be {@code null}.
 * @return Returns {@link #MODE_ALLOWED} if the operation is allowed, or
 * {@link #MODE_IGNORED} if it is not allowed and should be silently ignored (without
 * causing the app to crash).
 * @throws java.lang.SecurityException If the app has been configured to crash on this op.
 * @apiSince 19
 */

public int noteOp(@androidx.annotation.NonNull java.lang.String op, int uid, @androidx.annotation.NonNull java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * Like {@link #noteOp} but instead of throwing a {@link java.lang.SecurityException SecurityException} it
 * returns {@link #MODE_ERRORED}.
 
 * @param op This value must never be {@code null}.
 
 * @param packageName This value must never be {@code null}.
 * @apiSince 19
 */

public int noteOpNoThrow(@androidx.annotation.NonNull java.lang.String op, int uid, @androidx.annotation.NonNull java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * Make note of an application performing an operation on behalf of another
 * application when handling an IPC. Note that you must pass the package name
 * of the application that is being proxied while its UID will be inferred from
 * the IPC state; this function will verify that the calling uid and proxied
 * package name match, and if not, return {@link #MODE_IGNORED}. If this call
 * succeeds, the last execution time of the operation for the proxied app and
 * your app will be updated to the current time.
 * @param op The operation to note.  One of the OPSTR_* constants.
 * This value must never be {@code null}.
 * @param proxiedPackageName The name of the application calling into the proxy application.
 * This value must never be {@code null}.
 * @return Returns {@link #MODE_ALLOWED} if the operation is allowed, or
 * {@link #MODE_IGNORED} if it is not allowed and should be silently ignored (without
 * causing the app to crash).
 * @throws java.lang.SecurityException If the app has been configured to crash on this op.
 * @apiSince 23
 */

public int noteProxyOp(@androidx.annotation.NonNull java.lang.String op, @androidx.annotation.NonNull java.lang.String proxiedPackageName) { throw new RuntimeException("Stub!"); }

/**
 * Like {@link #noteProxyOp(java.lang.String,java.lang.String)} but instead
 * of throwing a {@link java.lang.SecurityException SecurityException} it returns {@link #MODE_ERRORED}.
 *
 * <p>This API requires the package with the {@code proxiedPackageName} to belongs to
 * {@link android.os.Binder#getCallingUid() Binder#getCallingUid()}.
 
 * @param op This value must never be {@code null}.
 
 * @param proxiedPackageName This value must never be {@code null}.
 * @apiSince 23
 */

public int noteProxyOpNoThrow(@androidx.annotation.NonNull java.lang.String op, @androidx.annotation.NonNull java.lang.String proxiedPackageName) { throw new RuntimeException("Stub!"); }

/**
 * Like {@link #noteProxyOpNoThrow(java.lang.String,java.lang.String)} but allows to specify the proxied uid.
 *
 * <p>This API requires package with the {@code proxiedPackageName} to belong to
 * {@code proxiedUid}.
 *
 * @param op The op to note
 * This value must never be {@code null}.
 * @param proxiedPackageName The package to note the op for or {@code null} if the op should be
 *                           noted for the "android" package
 * This value may be {@code null}.
 * @param proxiedUid The uid the package belongs to
 * @apiSince 29
 */

public int noteProxyOpNoThrow(@androidx.annotation.NonNull java.lang.String op, @androidx.annotation.Nullable java.lang.String proxiedPackageName, int proxiedUid) { throw new RuntimeException("Stub!"); }

/**
 * Report that an application has started executing a long-running operation.  Note that you
 * must pass in both the uid and name of the application to be checked; this function will
 * verify that these two match, and if not, return {@link #MODE_IGNORED}.  If this call
 * succeeds, the last execution time of the operation for this app will be updated to
 * the current time and the operation will be marked as "running".  In this case you must
 * later call {@link #finishOp(java.lang.String,int,java.lang.String)} to report when the application is no
 * longer performing the operation.
 * @param op The operation to start.  One of the OPSTR_* constants.
 * This value must never be {@code null}.
 * @param uid The user id of the application attempting to perform the operation.
 * @param packageName The name of the application attempting to perform the operation.
 * This value must never be {@code null}.
 * @return Returns {@link #MODE_ALLOWED} if the operation is allowed, or
 * {@link #MODE_IGNORED} if it is not allowed and should be silently ignored (without
 * causing the app to crash).
 * @throws java.lang.SecurityException If the app has been configured to crash on this op.
 * @apiSince 19
 */

public int startOp(@androidx.annotation.NonNull java.lang.String op, int uid, @androidx.annotation.NonNull java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * Like {@link #startOp} but instead of throwing a {@link java.lang.SecurityException SecurityException} it
 * returns {@link #MODE_ERRORED}.
 
 * @param op This value must never be {@code null}.
 
 * @param packageName This value must never be {@code null}.
 * @apiSince 19
 */

public int startOpNoThrow(@androidx.annotation.NonNull java.lang.String op, int uid, @androidx.annotation.NonNull java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * Report that an application is no longer performing an operation that had previously
 * been started with {@link #startOp(java.lang.String,int,java.lang.String)}.  There is no validation of input
 * or result; the parameters supplied here must be the exact same ones previously passed
 * in when starting the operation.
 
 * @param op This value must never be {@code null}.
 
 * @param packageName This value must never be {@code null}.
 * @apiSince 19
 */

public void finishOp(@androidx.annotation.NonNull java.lang.String op, int uid, @androidx.annotation.NonNull java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * Do a quick check to validate if a package name belongs to a UID.
 *
 * @throws java.lang.SecurityException if the package name doesn't belong to the given
 *             UID, or if ownership cannot be verified.
 
 * @param packageName This value must never be {@code null}.
 * @apiSince 19
 */

public void checkPackage(int uid, @androidx.annotation.NonNull java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * Result from {@link #checkOp}, {@link #noteOp}, {@link #startOp}: the given caller is
 * allowed to perform the given operation.
 * @apiSince 19
 */

public static final int MODE_ALLOWED = 0; // 0x0

/**
 * Result from {@link #checkOp}, {@link #noteOp}, {@link #startOp}: the given caller should
 * use its default security check.  This mode is not normally used; it should only be used
 * with appop permissions, and callers must explicitly check for it and deal with it.
 * @apiSince 21
 */

public static final int MODE_DEFAULT = 3; // 0x3

/**
 * Result from {@link #checkOpNoThrow}, {@link #noteOpNoThrow}, {@link #startOpNoThrow}: the
 * given caller is not allowed to perform the given operation, and this attempt should
 * cause it to have a fatal error, typically a {@link java.lang.SecurityException SecurityException}.
 * @apiSince 19
 */

public static final int MODE_ERRORED = 2; // 0x2

/**
 * Special mode that means "allow only when app is in foreground."  This is <b>not</b>
 * returned from {@link #unsafeCheckOp}, {@link #noteOp}, {@link #startOp}.  Rather,
 * {@link #unsafeCheckOp} will always return {@link #MODE_ALLOWED} (because it is always
 * possible for it to be ultimately allowed, depending on the app's background state),
 * and {@link #noteOp} and {@link #startOp} will return {@link #MODE_ALLOWED} when the app
 * being checked is currently in the foreground, otherwise {@link #MODE_IGNORED}.
 *
 * <p>The only place you will this normally see this value is through
 * {@link #unsafeCheckOpRaw}, which returns the actual raw mode of the op.  Note that because
 * you can't know the current state of the app being checked (and it can change at any
 * point), you can only treat the result here as an indication that it will vary between
 * {@link #MODE_ALLOWED} and {@link #MODE_IGNORED} depending on changes in the background
 * state of the app.  You thus must always use {@link #noteOp} or {@link #startOp} to do
 * the actual check for access to the op.</p>
 * @apiSince 29
 */

public static final int MODE_FOREGROUND = 4; // 0x4

/**
 * Result from {@link #checkOp}, {@link #noteOp}, {@link #startOp}: the given caller is
 * not allowed to perform the given operation, and this attempt should
 * <em>silently fail</em> (it should not cause the app to crash).
 * @apiSince 19
 */

public static final int MODE_IGNORED = 1; // 0x1

/**
 * Required to access phone state related information.
 * @apiSince 23
 */

public static final java.lang.String OPSTR_ADD_VOICEMAIL = "android:add_voicemail";

/**
 * Answer incoming phone calls
 * @apiSince 26
 */

public static final java.lang.String OPSTR_ANSWER_PHONE_CALLS = "android:answer_phone_calls";

/**
 * Access to body sensors such as heart rate, etc.
 * @apiSince 23
 */

public static final java.lang.String OPSTR_BODY_SENSORS = "android:body_sensors";

/**
 * Allows an application to initiate a phone call.
 * @apiSince 23
 */

public static final java.lang.String OPSTR_CALL_PHONE = "android:call_phone";

/**
 * Required to be able to access the camera device.
 * @apiSince 23
 */

public static final java.lang.String OPSTR_CAMERA = "android:camera";

/**
 * Access to coarse location information.
 * @apiSince 19
 */

public static final java.lang.String OPSTR_COARSE_LOCATION = "android:coarse_location";

/**
 * Access to fine location information.
 * @apiSince 19
 */

public static final java.lang.String OPSTR_FINE_LOCATION = "android:fine_location";

/**
 * Access to {@link android.app.usage.UsageStatsManager}.
 * @apiSince 21
 */

public static final java.lang.String OPSTR_GET_USAGE_STATS = "android:get_usage_stats";

/**
 * Inject mock location into the system.
 * @apiSince 23
 */

public static final java.lang.String OPSTR_MOCK_LOCATION = "android:mock_location";

/**
 * Continually monitoring location data with a relatively high power request.
 * @apiSince 19
 */

public static final java.lang.String OPSTR_MONITOR_HIGH_POWER_LOCATION = "android:monitor_location_high_power";

/**
 * Continually monitoring location data.
 * @apiSince 19
 */

public static final java.lang.String OPSTR_MONITOR_LOCATION = "android:monitor_location";

/**
 * Access to picture-in-picture.
 * @apiSince 26
 */

public static final java.lang.String OPSTR_PICTURE_IN_PICTURE = "android:picture_in_picture";

/**
 * Access APIs for diverting outgoing calls
 * @apiSince 26
 */

public static final java.lang.String OPSTR_PROCESS_OUTGOING_CALLS = "android:process_outgoing_calls";

/**
 * Allows an application to read the user's calendar data.
 * @apiSince 23
 */

public static final java.lang.String OPSTR_READ_CALENDAR = "android:read_calendar";

/**
 * Allows an application to read the user's call log.
 * @apiSince 23
 */

public static final java.lang.String OPSTR_READ_CALL_LOG = "android:read_call_log";

/**
 * Read previously received cell broadcast messages.
 * @apiSince 23
 */

public static final java.lang.String OPSTR_READ_CELL_BROADCASTS = "android:read_cell_broadcasts";

/**
 * Allows an application to read the user's contacts data.
 * @apiSince 23
 */

public static final java.lang.String OPSTR_READ_CONTACTS = "android:read_contacts";

/**
 * Read external storage.
 * @apiSince 23
 */

public static final java.lang.String OPSTR_READ_EXTERNAL_STORAGE = "android:read_external_storage";

/** @apiSince 26 */

public static final java.lang.String OPSTR_READ_PHONE_NUMBERS = "android:read_phone_numbers";

/**
 * Required to access phone state related information.
 * @apiSince 23
 */

public static final java.lang.String OPSTR_READ_PHONE_STATE = "android:read_phone_state";

/**
 * Allows an application to read SMS messages.
 * @apiSince 23
 */

public static final java.lang.String OPSTR_READ_SMS = "android:read_sms";

/**
 * Allows an application to receive MMS messages.
 * @apiSince 23
 */

public static final java.lang.String OPSTR_RECEIVE_MMS = "android:receive_mms";

/**
 * Allows an application to receive SMS messages.
 * @apiSince 23
 */

public static final java.lang.String OPSTR_RECEIVE_SMS = "android:receive_sms";

/**
 * Allows an application to receive WAP push messages.
 * @apiSince 23
 */

public static final java.lang.String OPSTR_RECEIVE_WAP_PUSH = "android:receive_wap_push";

/**
 * Required to be able to access the microphone device.
 * @apiSince 23
 */

public static final java.lang.String OPSTR_RECORD_AUDIO = "android:record_audio";

/**
 * Allows an application to send SMS messages.
 * @apiSince 23
 */

public static final java.lang.String OPSTR_SEND_SMS = "android:send_sms";

/**
 * Required to draw on top of other apps.
 * @apiSince 23
 */

public static final java.lang.String OPSTR_SYSTEM_ALERT_WINDOW = "android:system_alert_window";

/**
 * Use the fingerprint API.
 * @apiSince 23
 */

public static final java.lang.String OPSTR_USE_FINGERPRINT = "android:use_fingerprint";

/**
 * Access APIs for SIP calling over VOIP or WiFi
 * @apiSince 23
 */

public static final java.lang.String OPSTR_USE_SIP = "android:use_sip";

/**
 * Allows an application to write to the user's calendar data.
 * @apiSince 23
 */

public static final java.lang.String OPSTR_WRITE_CALENDAR = "android:write_calendar";

/**
 * Allows an application to write to the user's call log.
 * @apiSince 23
 */

public static final java.lang.String OPSTR_WRITE_CALL_LOG = "android:write_call_log";

/**
 * Allows an application to write to the user's contacts data.
 * @apiSince 23
 */

public static final java.lang.String OPSTR_WRITE_CONTACTS = "android:write_contacts";

/**
 * Write external storage.
 * @apiSince 23
 */

public static final java.lang.String OPSTR_WRITE_EXTERNAL_STORAGE = "android:write_external_storage";

/**
 * Required to write/modify/update system settingss.
 * @apiSince 23
 */

public static final java.lang.String OPSTR_WRITE_SETTINGS = "android:write_settings";

/**
 * Flag for {@link #startWatchingMode(java.lang.String,java.lang.String,int,android.app.AppOpsManager.OnOpChangedListener)}:
 * Also get reports if the foreground state of an op's uid changes.  This only works
 * when watching a particular op, not when watching a package.
 * @apiSince 29
 */

public static final int WATCH_FOREGROUND_CHANGES = 1; // 0x1
/**
 * Callback for notification of changes to operation state.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnOpChangedListener {

/** @apiSince 19 */

public void onOpChanged(java.lang.String op, java.lang.String packageName);
}

}

