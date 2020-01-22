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


package android.app.admin;


/**
 * A class containing information about a pending system update.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SystemUpdateInfo implements android.os.Parcelable {

private SystemUpdateInfo() { throw new RuntimeException("Stub!"); }

/**
 * Gets time when the update was first available in milliseconds since midnight, January 1,
 * 1970 UTC.
 * @return Time in milliseconds as given by {@link java.lang.System#currentTimeMillis() System#currentTimeMillis()}
 * @apiSince 26
 */

public long getReceivedTime() { throw new RuntimeException("Stub!"); }

/**
 * Gets whether the update is a security patch.
 * @return {@link #SECURITY_PATCH_STATE_FALSE}, {@link #SECURITY_PATCH_STATE_TRUE}, or
 *         {@link #SECURITY_PATCH_STATE_UNKNOWN}.
 
 * Value is {@link android.app.admin.SystemUpdateInfo#SECURITY_PATCH_STATE_FALSE}, {@link android.app.admin.SystemUpdateInfo#SECURITY_PATCH_STATE_TRUE}, or {@link android.app.admin.SystemUpdateInfo#SECURITY_PATCH_STATE_UNKNOWN}
 * @apiSince 26
 */

public int getSecurityPatchState() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.admin.SystemUpdateInfo> CREATOR;
static { CREATOR = null; }

/**
 * Represents the system update is not a security patch.
 * @apiSince 26
 */

public static final int SECURITY_PATCH_STATE_FALSE = 1; // 0x1

/**
 * Represents the system update is a security patch.
 * @apiSince 26
 */

public static final int SECURITY_PATCH_STATE_TRUE = 2; // 0x2

/**
 * Represents it is unknown whether the system update is a security patch.
 * @apiSince 26
 */

public static final int SECURITY_PATCH_STATE_UNKNOWN = 0; // 0x0
}

