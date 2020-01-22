/*
 * Copyright (C) 2008 The Android Open Source Project
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
 * This class is used to communicate the results of a sync operation to the SyncManager.
 * Based on the values here the SyncManager will determine the disposition of the
 * sync and whether or not a new sync operation needs to be scheduled in the future.
 *
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SyncResult implements android.os.Parcelable {

/**
 * Create a "clean" SyncResult. If this is returned without any changes then the
 * SyncManager will consider the sync to have completed successfully. The various fields
 * can be set by the SyncAdapter in order to give the SyncManager more information as to
 * the disposition of the sync.
 * <p>
 * The errors are classified into two broad categories: hard errors and soft errors.
 * Soft errors are retried with exponential backoff. Hard errors are not retried (except
 * when the hard error is for a {@link android.content.ContentResolver#SYNC_EXTRAS_UPLOAD ContentResolver#SYNC_EXTRAS_UPLOAD} request,
 * in which the request is retryed without the {@link android.content.ContentResolver#SYNC_EXTRAS_UPLOAD ContentResolver#SYNC_EXTRAS_UPLOAD}
 * extra set). The SyncManager checks the type of error by calling
 * {@link android.content.SyncResult#hasHardError() SyncResult#hasHardError()} and  {@link android.content.SyncResult#hasSoftError() SyncResult#hasSoftError()}. If both are
 * true then the SyncManager treats it as a hard error, not a soft error.
 * @apiSince 5
 */

public SyncResult() { throw new RuntimeException("Stub!"); }

/**
 * Convenience method for determining if the SyncResult indicates that a hard error
 * occurred. See {@link #SyncResult()} for an explanation of what the SyncManager does
 * when it sees a hard error.
 * <p>
 * A hard error is indicated when any of the following is true:
 * <ul>
 * <li> {@link android.content.SyncStats#numParseExceptions SyncStats#numParseExceptions} > 0
 * <li> {@link android.content.SyncStats#numConflictDetectedExceptions SyncStats#numConflictDetectedExceptions} > 0
 * <li> {@link android.content.SyncStats#numAuthExceptions SyncStats#numAuthExceptions} > 0
 * <li> {@link #tooManyDeletions}
 * <li> {@link #tooManyRetries}
 * <li> {@link #databaseError}
 * @return true if a hard error is indicated
 * @apiSince 5
 */

public boolean hasHardError() { throw new RuntimeException("Stub!"); }

/**
 * Convenience method for determining if the SyncResult indicates that a soft error
 * occurred. See {@link #SyncResult()} for an explanation of what the SyncManager does
 * when it sees a soft error.
 * <p>
 * A soft error is indicated when any of the following is true:
 * <ul>
 * <li> {@link android.content.SyncStats#numIoExceptions SyncStats#numIoExceptions} > 0
 * <li> {@link #syncAlreadyInProgress}
 * </ul>
 * @return true if a soft error is indicated
 * @apiSince 5
 */

public boolean hasSoftError() { throw new RuntimeException("Stub!"); }

/**
 * A convenience method for determining of the SyncResult indicates that an error occurred.
 * @return true if either a soft or hard error occurred
 * @apiSince 5
 */

public boolean hasError() { throw new RuntimeException("Stub!"); }

/**
 * Convenience method for determining if the Sync should be rescheduled after failing for some
 * reason.
 * @return true if the SyncManager should reschedule this sync.
 * @apiSince 5
 */

public boolean madeSomeProgress() { throw new RuntimeException("Stub!"); }

/**
 * Clears the SyncResult to a clean state. Throws an {@link java.lang.UnsupportedOperationException UnsupportedOperationException}
 * if this is called when {@link #syncAlreadyInProgress} is set.
 * @apiSince 5
 */

public void clear() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Generates a debugging string indicating the status.
 * The string consist of a sequence of code letter followed by the count.
 * Code letters are f - fullSyncRequested, r - partialSyncUnavailable,
 * X - hardError, e - numParseExceptions, c - numConflictDetectedExceptions,
 * a - numAuthExceptions, D - tooManyDeletions, R - tooManyRetries,
 * b - databaseError, x - softError, l - syncAlreadyInProgress,
 * I - numIoExceptions
 * @return debugging string.
 * @apiSince 5
 */

public java.lang.String toDebugString() { throw new RuntimeException("Stub!"); }

/**
 * This instance of a SyncResult is returned by the SyncAdapter in response to a
 * sync request when a sync is already underway. The SyncManager will reschedule the
 * sync request to try again later.
 * @apiSince 5
 */

public static final android.content.SyncResult ALREADY_IN_PROGRESS;
static { ALREADY_IN_PROGRESS = null; }

/** @apiSince 5 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.content.SyncResult> CREATOR;
static { CREATOR = null; }

/**
 * Used to indicate that the SyncAdapter experienced a hard error due to an error it
 * received from interacting with the storage layer. The SyncManager will record that
 * the sync request failed and it will not reschedule the request.
 * @apiSince 5
 */

public boolean databaseError;

/**
 * Used to indicate to the SyncManager that future sync requests that match the request's
 * Account and authority should be delayed until a time in seconds since Java epoch.
 *
 * <p>For example, if you want to delay the next sync for at least 5 minutes, then:
 * <pre>
 * result.delayUntil = (System.currentTimeMillis() / 1000) + 5 * 60;
 * </pre>
 *
 * <p>By default, when a sync fails, the system retries later with an exponential back-off
 * with the system default initial delay time, which always wins over {@link #delayUntil} --
 * i.e. if the system back-off time is larger than {@link #delayUntil}, {@link #delayUntil}
 * will essentially be ignored.
 * @apiSince 8
 */

public long delayUntil;

/**
 * If set the SyncManager will request an immediate sync with the same Account and authority
 * (but empty extras Bundle) as was used in the sync request.
 * @apiSince 5
 */

public boolean fullSyncRequested;

/**
 * This field is ignored by the SyncManager.
 * @apiSince 5
 */

public boolean moreRecordsToGet;

/**
 * This field is ignored by the SyncManager.
 * @apiSince 5
 */

public boolean partialSyncUnavailable;

/**
 * Used to hold extras statistics about the sync operation. Some of these indicate that
 * the sync request resulted in a hard or soft error, others are for purely informational
 * purposes.
 * @apiSince 5
 */

public final android.content.SyncStats stats;
{ stats = null; }

/**
 * Used to indicate that the SyncAdapter is already performing a sync operation, though
 * not necessarily for the requested account and authority and that it wasn't able to
 * process this request. The SyncManager will reschedule the request to run later.
 * @apiSince 5
 */

public final boolean syncAlreadyInProgress;
{ syncAlreadyInProgress = false; }

/**
 * Used to indicate that the SyncAdapter determined that it would need to issue
 * too many delete operations to the server in order to satisfy the request
 * (as defined by the SyncAdapter). The SyncManager will record
 * that the sync request failed and will cause a System Notification to be created
 * asking the user what they want to do about this. It will give the user a chance to
 * choose between (1) go ahead even with those deletes, (2) revert the deletes,
 * or (3) take no action. If the user decides (1) or (2) the SyncManager will issue another
 * sync request with either {@link android.content.ContentResolver#SYNC_EXTRAS_OVERRIDE_TOO_MANY_DELETIONS ContentResolver#SYNC_EXTRAS_OVERRIDE_TOO_MANY_DELETIONS}
 * or {@link android.content.ContentResolver#SYNC_EXTRAS_DISCARD_LOCAL_DELETIONS ContentResolver#SYNC_EXTRAS_DISCARD_LOCAL_DELETIONS} set in the extras.
 * It is then up to the SyncAdapter to decide how to honor that request.
 * @apiSince 5
 */

public boolean tooManyDeletions;

/**
 * Used to indicate that the SyncAdapter experienced a hard error due to trying the same
 * operation too many times (as defined by the SyncAdapter). The SyncManager will record
 * that the sync request failed and it will not reschedule the request.
 * @apiSince 5
 */

public boolean tooManyRetries;
}

