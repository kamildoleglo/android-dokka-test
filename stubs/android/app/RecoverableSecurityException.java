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
 * Specialization of {@link java.lang.SecurityException SecurityException} that contains additional
 * information about how to involve the end user to recover from the exception.
 * <p>
 * This exception is only appropriate where there is a concrete action the user
 * can take to recover and make forward progress, such as confirming or entering
 * authentication credentials, or granting access.
 * <p>
 * If the receiving app is actively involved with the user, it should present
 * the contained recovery details to help the user make forward progress.
 * <p class="note">
 * Note: legacy code that receives this exception may treat it as a general
 * {@link java.lang.SecurityException SecurityException}, and thus there is no guarantee that the messages
 * contained will be shown to the end user.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class RecoverableSecurityException extends java.lang.SecurityException implements android.os.Parcelable {

/**
 * Create an instance ready to be thrown.
 *
 * @param cause original cause with details designed for engineering
 *            audiences.
 * This value must never be {@code null}.
 * @param userMessage short message describing the issue for end user
 *            audiences, which may be shown in a notification or dialog.
 *            This should be localized and less than 64 characters. For
 *            example: <em>PIN required to access Document.pdf</em>
 * This value must never be {@code null}.
 * @param userAction primary action that will initiate the recovery. The
 *            title should be localized and less than 24 characters. For
 *            example: <em>Enter PIN</em>. This action must launch an
 *            activity that is expected to set
 *            {@link android.app.Activity#setResult(int) Activity#setResult(int)} before finishing to
 *            communicate the final status of the recovery. For example,
 *            apps that observe {@link android.app.Activity#RESULT_OK Activity#RESULT_OK} may choose to
 *            immediately retry their operation.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public RecoverableSecurityException(@androidx.annotation.NonNull java.lang.Throwable cause, @androidx.annotation.NonNull java.lang.CharSequence userMessage, @androidx.annotation.NonNull android.app.RemoteAction userAction) { throw new RuntimeException("Stub!"); }

/**
 * Return short message describing the issue for end user audiences, which
 * may be shown in a notification or dialog.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.lang.CharSequence getUserMessage() { throw new RuntimeException("Stub!"); }

/**
 * Return primary action that will initiate the recovery.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.app.RemoteAction getUserAction() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.RecoverableSecurityException> CREATOR;
static { CREATOR = null; }
}

