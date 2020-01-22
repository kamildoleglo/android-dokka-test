/*
 * Copyright (C) 2013 The Android Open Source Project
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


package android.content;

import android.net.Uri;

/**
 * Description of a single Uri permission grant. This grants may have been
 * created via {@link android.content.Intent#FLAG_GRANT_READ_URI_PERMISSION Intent#FLAG_GRANT_READ_URI_PERMISSION}, etc when sending
 * an {@link android.content.Intent Intent}, or explicitly through
 * {@link android.content.Context#grantUriPermission(java.lang.String,android.net.Uri,int) Context#grantUriPermission(String, android.net.Uri, int)}.
 *
 * @see android.content.ContentResolver#getPersistedUriPermissions()
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class UriPermission implements android.os.Parcelable {

UriPermission() { throw new RuntimeException("Stub!"); }

/**
 * Return the Uri this permission pertains to.
 * @apiSince 19
 */

public android.net.Uri getUri() { throw new RuntimeException("Stub!"); }

/**
 * Returns if this permission offers read access.
 * @apiSince 19
 */

public boolean isReadPermission() { throw new RuntimeException("Stub!"); }

/**
 * Returns if this permission offers write access.
 * @apiSince 19
 */

public boolean isWritePermission() { throw new RuntimeException("Stub!"); }

/**
 * Return the time when this permission was first persisted, in milliseconds
 * since January 1, 1970 00:00:00.0 UTC. Returns {@link #INVALID_TIME} if
 * not persisted.
 *
 * @see android.content.ContentResolver#takePersistableUriPermission(Uri, int)
 * @see java.lang.System#currentTimeMillis()
 * @apiSince 19
 */

public long getPersistedTime() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.content.UriPermission> CREATOR;
static { CREATOR = null; }

/**
 * Value returned when a permission has not been persisted.
 * @apiSince 19
 */

public static final long INVALID_TIME = -9223372036854775808L; // 0x8000000000000000L
}

