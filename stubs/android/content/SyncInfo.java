/*
 * Copyright (C) 2009 The Android Open Source Project
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

import android.accounts.Account;

/**
 * Information about the sync operation that is currently underway.
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SyncInfo implements android.os.Parcelable {

SyncInfo() { throw new RuntimeException("Stub!"); }

/** @hide */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @hide */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/**
 * The {@link android.accounts.Account Account} that is currently being synced.
 * @apiSince 8
 */

public final android.accounts.Account account;
{ account = null; }

/**
 * The authority of the provider that is currently being synced.
 * @apiSince 8
 */

public final java.lang.String authority;
{ authority = null; }

/**
 * The start time of the current sync operation in milliseconds since boot.
 * This is represented in elapsed real time.
 * See {@link android.os.SystemClock#elapsedRealtime()}.
 * @apiSince 8
 */

public final long startTime;
{ startTime = 0; }
}

