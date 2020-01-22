/*
 * Copyright (C) 2016 The Android Open Source Project
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

/**
 * An abstract class that represents a network event.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class NetworkEvent implements android.os.Parcelable {

NetworkEvent() { throw new RuntimeException("Stub!"); }

/**
 * Returns the package name of the UID that performed the query, as returned by
 * {@link android.content.pm.PackageManager#getNameForUid PackageManager#getNameForUid}.
 * @apiSince 26
 */

public java.lang.String getPackageName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the timestamp of the event being reported in milliseconds, the difference between
 * the time the event was reported and midnight, January 1, 1970 UTC.
 * @apiSince 26
 */

public long getTimestamp() { throw new RuntimeException("Stub!"); }

/**
 * Returns the id of the event, where the id monotonically increases for each event. The id
 * is reset when the device reboots, and when network logging is enabled.
 * @apiSince 28
 */

public long getId() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public abstract void writeToParcel(android.os.Parcel out, int flags);

/** @apiSince 26 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.admin.NetworkEvent> CREATOR;
static { CREATOR = null; }
}

