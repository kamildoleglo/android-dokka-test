/*
 * Copyright (C) 2007 The Android Open Source Project
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
 * Used to record various statistics about the result of a sync operation. The SyncManager
 * gets access to these via a {@link android.content.SyncResult SyncResult} and uses some of them to determine the
 * disposition of the sync. See {@link android.content.SyncResult SyncResult} for further dicussion on how the
 * SyncManager uses these values.
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SyncStats implements android.os.Parcelable {

/** @apiSince 5 */

public SyncStats() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public SyncStats(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Reset all the counters to 0.
 * @apiSince 5
 */

public void clear() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.content.SyncStats> CREATOR;
static { CREATOR = null; }

/**
 * The SyncAdapter was unable to authenticate the {@link android.accounts.Account}
 * that was specified in the request. The user needs to take some action to resolve
 * before a future request can expect to succeed. This is considered a hard error.
 * @apiSince 5
 */

public long numAuthExceptions;

/**
 * The SyncAdapter detected that there was an unrecoverable version conflict when it
 * attempted to update or delete a version of a resource on the server. This is expected
 * to clear itself automatically once the new state is retrieved from the server,
 * though it may remain until the user intervenes manually, perhaps by clearing the
 * local storage and starting over frmo scratch. This is considered a hard error.
 * @apiSince 5
 */

public long numConflictDetectedExceptions;

/**
 * Counter for tracking how many deletes were performed by the sync operation, as defined
 * by the SyncAdapter.
 * @apiSince 5
 */

public long numDeletes;

/**
 * Counter for tracking how many entries were affected by the sync operation, as defined
 * by the SyncAdapter.
 * @apiSince 5
 */

public long numEntries;

/**
 * Counter for tracking how many inserts were performed by the sync operation, as defined
 * by the SyncAdapter.
 * @apiSince 5
 */

public long numInserts;

/**
 * The SyncAdapter had a problem, most likely with the network connectivity or a timeout
 * while waiting for a network response. The request may succeed if it is tried again
 * later. This is considered a soft error.
 * @apiSince 5
 */

public long numIoExceptions;

/**
 * The SyncAdapter had a problem with the data it received from the server or the storage
 * later. This problem will likely repeat if the request is tried again. The problem
 * will need to be cleared up by either the server or the storage layer (likely with help
 * from the user). If the SyncAdapter cleans up the data itself then it typically won't
 * increment this value although it may still do so in order to record that it had to
 * perform some cleanup. E.g., if the SyncAdapter received a bad entry from the server
 * when processing a feed of entries, it may choose to drop the entry and thus make
 * progress and still increment this value just so the SyncAdapter can record that an
 * error occurred. This is considered a hard error.
 * @apiSince 5
 */

public long numParseExceptions;

/**
 * Counter for tracking how many entries, either from the server or the local store, were
 * ignored during the sync operation. This could happen if the SyncAdapter detected some
 * unparsable data but decided to skip it and move on rather than failing immediately.
 * @apiSince 5
 */

public long numSkippedEntries;

/**
 * Counter for tracking how many updates were performed by the sync operation, as defined
 * by the SyncAdapter.
 * @apiSince 5
 */

public long numUpdates;
}

