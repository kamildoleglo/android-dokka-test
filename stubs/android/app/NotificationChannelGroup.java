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

import android.content.Intent;

/**
 * A grouping of related notification channels. e.g., channels that all belong to a single account.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class NotificationChannelGroup implements android.os.Parcelable {

/**
 * Creates a notification channel group.
 *
 * @param id The id of the group. Must be unique per package.  the value may be truncated if
 *           it is too long.
 * @param name The user visible name of the group. You can rename this group when the system
 *             locale changes by listening for the {@link android.content.Intent#ACTION_LOCALE_CHANGED Intent#ACTION_LOCALE_CHANGED}
 *             broadcast. <p>The recommended maximum length is 40 characters; the value may be
 *             truncated if it is too long.
 * @apiSince 26
 */

public NotificationChannelGroup(java.lang.String id, java.lang.CharSequence name) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Returns the id of this group.
 * @apiSince 26
 */

public java.lang.String getId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the user visible name of this group.
 * @apiSince 26
 */

public java.lang.CharSequence getName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the user visible description of this group.
 * @apiSince 28
 */

public java.lang.String getDescription() { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of channels that belong to this group
 * @apiSince 26
 */

public java.util.List<android.app.NotificationChannel> getChannels() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether or not notifications posted to {@link android.app.NotificationChannel NotificationChannel} belonging
 * to this group are blocked. This value is independent of
 * {@link android.app.NotificationManager#areNotificationsEnabled() NotificationManager#areNotificationsEnabled()} and
 * {@link android.app.NotificationChannel#getImportance() NotificationChannel#getImportance()}.
 * @apiSince 28
 */

public boolean isBlocked() { throw new RuntimeException("Stub!"); }

/**
 * Sets the user visible description of this group.
 *
 * <p>The recommended maximum length is 300 characters; the value may be truncated if it is too
 * long.
 * @apiSince 28
 */

public void setDescription(java.lang.String description) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public android.app.NotificationChannelGroup clone() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.NotificationChannelGroup> CREATOR;
static { CREATOR = null; }
}

