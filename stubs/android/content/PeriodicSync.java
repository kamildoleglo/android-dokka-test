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


package android.content;

import android.os.Bundle;

/**
 * Value type that contains information about a periodic sync.
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PeriodicSync implements android.os.Parcelable {

/**
 * Creates a new PeriodicSync, copying the Bundle. This constructor is no longer used.
 * @apiSince 8
 */

public PeriodicSync(android.accounts.Account account, java.lang.String authority, android.os.Bundle extras, long periodInSeconds) { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.content.PeriodicSync> CREATOR;
static { CREATOR = null; }

/**
 * The account to be synced. Can be null.
 * @apiSince 8
 */

public final android.accounts.Account account;
{ account = null; }

/**
 * The authority of the sync. Can be null.
 * @apiSince 8
 */

public final java.lang.String authority;
{ authority = null; }

/**
 * Any extras that parameters that are to be passed to the sync adapter.
 * @apiSince 8
 */

public final android.os.Bundle extras;
{ extras = null; }

/**
 * How frequently the sync should be scheduled, in seconds. Kept around for API purposes.
 * @apiSince 8
 */

public final long period;
{ period = 0; }
}

