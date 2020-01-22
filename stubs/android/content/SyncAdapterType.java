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


/**
 * Value type that represents a SyncAdapterType. This object overrides {@link #equals} and
 * {@link #hashCode}, making it suitable for use as the key of a {@link java.util.Map}
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SyncAdapterType implements android.os.Parcelable {

/** @apiSince 5 */

public SyncAdapterType(java.lang.String authority, java.lang.String accountType, boolean userVisible, boolean supportsUploading) { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public SyncAdapterType(android.os.Parcel source) { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public boolean supportsUploading() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public boolean isUserVisible() { throw new RuntimeException("Stub!"); }

/**
 * @return True if this SyncAdapter supports syncing multiple accounts simultaneously.
 * If false then the SyncManager will take care to only start one sync at a time
 * using this SyncAdapter.
 * @apiSince 11
 */

public boolean allowParallelSyncs() { throw new RuntimeException("Stub!"); }

/**
 * If true then the SyncManager will never issue an initialization sync to the SyncAdapter
 * and will instead automatically call
 * {@link android.content.ContentResolver#setIsSyncable(android.accounts.Account,java.lang.String,int) ContentResolver#setIsSyncable(android.accounts.Account, String, int)} with a
 * value of 1 for each account and provider that this sync adapter supports.
 * @return true if the SyncAdapter does not require initialization and if it is ok for the
 * SyncAdapter to treat it as syncable automatically.
 * @apiSince 11
 */

public boolean isAlwaysSyncable() { throw new RuntimeException("Stub!"); }

/**
 * @return The activity to use to invoke this SyncAdapter's settings activity.
 * May be null.
 * @apiSince 14
 */

public java.lang.String getSettingsActivity() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public static android.content.SyncAdapterType newKey(java.lang.String authority, java.lang.String accountType) { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.content.SyncAdapterType> CREATOR;
static { CREATOR = null; }

/** @apiSince 5 */

public final java.lang.String accountType;
{ accountType = null; }

/** @apiSince 5 */

public final java.lang.String authority;
{ authority = null; }

/** @apiSince 5 */

public final boolean isKey;
{ isKey = false; }
}

