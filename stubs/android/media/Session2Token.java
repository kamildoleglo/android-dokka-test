/*
 * Copyright 2018 The Android Open Source Project
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


package android.media;

import android.os.Bundle;

/**
 * This API is not generally intended for third party application developers.
 * Use the <a href="{@docRoot}jetpack/androidx.html">AndroidX</a>
 * <a href="{@docRoot}reference/androidx/media2/session/package-summary.html">Media2 session
 * Library</a> for consistent behavior across all devices.
 * <p>
 * Represents an ongoing {@link android.media.MediaSession2 MediaSession2} or a {@link android.media.MediaSession2Service MediaSession2Service}.
 * If it's representing a session service, it may not be ongoing.
 * <p>
 * This may be passed to apps by the session owner to allow them to create a
 * {@link android.media.MediaController2 MediaController2} to communicate with the session.
 * <p>
 * It can be also obtained by {@link android.media.session.MediaSessionManager}.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Session2Token implements android.os.Parcelable {

/**
 * Constructor for the token with type {@link #TYPE_SESSION_SERVICE}.
 *
 * @param context The context.
 * This value must never be {@code null}.
 * @param serviceComponent The component name of the service.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public Session2Token(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.ComponentName serviceComponent) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * @return uid of the session
 * @apiSince 29
 */

public int getUid() { throw new RuntimeException("Stub!"); }

/**
 * @return package name of the session
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.lang.String getPackageName() { throw new RuntimeException("Stub!"); }

/**
 * @return service name of the session. Can be {@code null} for {@link #TYPE_SESSION}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.lang.String getServiceName() { throw new RuntimeException("Stub!"); }

/**
 * @return type of the token
 * Value is {@link android.media.Session2Token#TYPE_SESSION}, or {@link android.media.Session2Token#TYPE_SESSION_SERVICE}
 * @see #TYPE_SESSION
 * @see #TYPE_SESSION_SERVICE
 * @apiSince 29
 */

public int getType() { throw new RuntimeException("Stub!"); }

/**
 * @return extras of the token
 * This value will never be {@code null}.
 * @see android.media.MediaSession2.Builder#setExtras(Bundle)
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.media.Session2Token> CREATOR;
static { CREATOR = null; }

/**
 * Type for {@link android.media.MediaSession2 MediaSession2}.
 * @apiSince 29
 */

public static final int TYPE_SESSION = 0; // 0x0

/**
 * Type for {@link android.media.MediaSession2Service MediaSession2Service}.
 * @apiSince 29
 */

public static final int TYPE_SESSION_SERVICE = 1; // 0x1
}

