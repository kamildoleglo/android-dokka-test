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


package android.app;


/**
 * Specialization of {@link java.lang.SecurityException SecurityException} that is thrown when authentication is needed from the
 * end user before viewing the content.
 * <p>
 * This exception is only appropriate where there is a concrete action the user can take to
 * authorize and make forward progress, such as confirming or entering authentication credentials,
 * or granting access via other means.
 * <p class="note">
 * Note: legacy code that receives this exception may treat it as a general
 * {@link java.lang.SecurityException SecurityException}, and thus there is no guarantee that the action contained will be
 * invoked by the user.
 * </p>
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class AuthenticationRequiredException extends java.lang.SecurityException implements android.os.Parcelable {

/**
 * Create an instance ready to be thrown.
 *
 * @param cause original cause with details designed for engineering
 *            audiences.
 * @param userAction primary action that will initiate the recovery. This
 *            must launch an activity that is expected to set
 *            {@link android.app.Activity#setResult(int) Activity#setResult(int)} before finishing to
 *            communicate the final status of the recovery. For example,
 *            apps that observe {@link android.app.Activity#RESULT_OK Activity#RESULT_OK} may choose to
 *            immediately retry their operation.
 * @apiSince 26
 */

public AuthenticationRequiredException(java.lang.Throwable cause, android.app.PendingIntent userAction) { throw new RuntimeException("Stub!"); }

/**
 * Return primary action that will initiate the authorization.
 * @apiSince 26
 */

public android.app.PendingIntent getUserAction() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.AuthenticationRequiredException> CREATOR;
static { CREATOR = null; }
}

