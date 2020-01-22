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

import android.accounts.Account;
import android.os.Build;
import android.os.Bundle;

/**
 * Convenience class to construct sync requests. See {@link android.content.SyncRequest.Builder}
 * for an explanation of the various functions. The resulting object is passed through to the
 * framework via {@link android.content.ContentResolver#requestSync(SyncRequest)}.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SyncRequest implements android.os.Parcelable {

SyncRequest() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.content.SyncRequest> CREATOR;
static { CREATOR = null; }
/**
 * Builder class for a {@link android.content.SyncRequest SyncRequest}. As you build your SyncRequest this class will also
 * perform validation.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

/** @apiSince 19 */

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Request that a sync occur immediately.
 *
 * Example
 * <pre>
 *     SyncRequest.Builder builder = (new SyncRequest.Builder()).syncOnce();
 * </pre>
 * @apiSince 19
 */

public android.content.SyncRequest.Builder syncOnce() { throw new RuntimeException("Stub!"); }

/**
 * Build a periodic sync. Either this or syncOnce() <b>must</b> be called for this builder.
 * Syncs are identified by target {@link android.provider} and by the
 * contents of the extras bundle.
 * You cannot reuse the same builder for one-time syncs after having specified a periodic
 * sync (by calling this function). If you do, an <code>IllegalArgumentException</code>
 * will be thrown.
 * <p>The bundle for a periodic sync can be queried by applications with the correct
 * permissions using
 * {@link android.content.ContentResolver#getPeriodicSyncs(android.accounts.Account,java.lang.String) ContentResolver#getPeriodicSyncs(Account account, String provider)}, so no
 * sensitive data should be transferred here.
 *
 * Example usage.
 *
 * <pre>
 *     Request a periodic sync every 5 hours with 20 minutes of flex.
 *     SyncRequest.Builder builder =
 *         (new SyncRequest.Builder()).syncPeriodic(5 * HOUR_IN_SECS, 20 * MIN_IN_SECS);
 *
 *     Schedule a periodic sync every hour at any point in time during that hour.
 *     SyncRequest.Builder builder =
 *         (new SyncRequest.Builder()).syncPeriodic(1 * HOUR_IN_SECS, 1 * HOUR_IN_SECS);
 * </pre>
 *
 * N.B.: Periodic syncs are not allowed to have any of
 * {@link android.content.ContentResolver#SYNC_EXTRAS_DO_NOT_RETRY ContentResolver#SYNC_EXTRAS_DO_NOT_RETRY},
 * {@link android.content.ContentResolver#SYNC_EXTRAS_IGNORE_BACKOFF ContentResolver#SYNC_EXTRAS_IGNORE_BACKOFF},
 * {@link android.content.ContentResolver#SYNC_EXTRAS_IGNORE_SETTINGS ContentResolver#SYNC_EXTRAS_IGNORE_SETTINGS},
 * {@link android.content.ContentResolver#SYNC_EXTRAS_INITIALIZE ContentResolver#SYNC_EXTRAS_INITIALIZE},
 * {@link android.content.ContentResolver#SYNC_EXTRAS_FORCE ContentResolver#SYNC_EXTRAS_FORCE},
 * {@link android.content.ContentResolver#SYNC_EXTRAS_EXPEDITED ContentResolver#SYNC_EXTRAS_EXPEDITED},
 * {@link android.content.ContentResolver#SYNC_EXTRAS_MANUAL ContentResolver#SYNC_EXTRAS_MANUAL}
 * set to true. If any are supplied then an <code>IllegalArgumentException</code> will
 * be thrown.
 *
 * @param pollFrequency the amount of time in seconds that you wish
 *            to elapse between periodic syncs. A minimum period of 1 hour is enforced.
 * @param beforeSeconds the amount of flex time in seconds before
 *            {@code pollFrequency} that you permit for the sync to take
 *            place. Must be less than {@code pollFrequency} and greater than
 *            MAX(5% of {@code pollFrequency}, 5 minutes)
 * @apiSince 19
 */

public android.content.SyncRequest.Builder syncPeriodic(long pollFrequency, long beforeSeconds) { throw new RuntimeException("Stub!"); }

/**
 * Will throw an <code>IllegalArgumentException</code> if called and
 * {@link #setIgnoreSettings(boolean ignoreSettings)} has already been called.
 * @param disallow true to allow this transfer on metered networks. Default false.
 *
 * @apiSince 19
 */

public android.content.SyncRequest.Builder setDisallowMetered(boolean disallow) { throw new RuntimeException("Stub!"); }

/**
 * Specify whether the sync requires the phone to be plugged in.
 * @param requiresCharging true if sync requires the phone to be plugged in. Default false.
 * @apiSince 24
 */

public android.content.SyncRequest.Builder setRequiresCharging(boolean requiresCharging) { throw new RuntimeException("Stub!"); }

/**
 * Specify an authority and account for this transfer.
 *
 * @param authority A String identifying the content provider to be synced.
 * @param account Account to sync. Can be null unless this is a periodic
 *            sync, for which verification by the ContentResolver will
 *            fail. If a sync is performed without an account, the
 * @apiSince 19
 */

public android.content.SyncRequest.Builder setSyncAdapter(android.accounts.Account account, java.lang.String authority) { throw new RuntimeException("Stub!"); }

/**
 * Developer-provided extras handed back when sync actually occurs. This bundle is copied
 * into the SyncRequest returned by {@link #build()}.
 *
 * Example:
 * <pre>
 *   String[] syncItems = {"dog", "cat", "frog", "child"};
 *   SyncRequest.Builder builder =
 *     new SyncRequest.Builder()
 *       .setSyncAdapter(dummyAccount, dummyProvider)
 *       .syncOnce();
 *
 *   for (String syncData : syncItems) {
 *     Bundle extras = new Bundle();
 *     extras.setString("data", syncData);
 *     builder.setExtras(extras);
 *     ContentResolver.sync(builder.build()); // Each sync() request creates a unique sync.
 *   }
 * </pre>
 * Only values of the following types may be used in the extras bundle:
 * <ul>
 * <li>Integer</li>
 * <li>Long</li>
 * <li>Boolean</li>
 * <li>Float</li>
 * <li>Double</li>
 * <li>String</li>
 * <li>Account</li>
 * <li>null</li>
 * </ul>
 * If any data is present in the bundle not of this type, build() will
 * throw a runtime exception.
 *
 * @param bundle extras bundle to set.
 * @apiSince 19
 */

public android.content.SyncRequest.Builder setExtras(android.os.Bundle bundle) { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for setting {@link android.content.ContentResolver#SYNC_EXTRAS_DO_NOT_RETRY ContentResolver#SYNC_EXTRAS_DO_NOT_RETRY}.
 *
 * A one-off sync operation that fails will be retried with exponential back-off unless
 * this is set to false. Not valid for periodic sync and will throw an
 * <code>IllegalArgumentException</code> in build().
 *
 * @param noRetry true to not retry a failed sync. Default false.
 * @apiSince 19
 */

public android.content.SyncRequest.Builder setNoRetry(boolean noRetry) { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for setting {@link android.content.ContentResolver#SYNC_EXTRAS_IGNORE_SETTINGS ContentResolver#SYNC_EXTRAS_IGNORE_SETTINGS}.
 *
 * Not valid for periodic sync and will throw an <code>IllegalArgumentException</code> in
 * {@link #build()}.
 * <p>Throws <code>IllegalArgumentException</code> if called and
 * {@link #setDisallowMetered(boolean)} has been set.
 *
 *
 * @param ignoreSettings true to ignore the sync automatically settings. Default false.
 * @apiSince 19
 */

public android.content.SyncRequest.Builder setIgnoreSettings(boolean ignoreSettings) { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for setting {@link android.content.ContentResolver#SYNC_EXTRAS_IGNORE_BACKOFF ContentResolver#SYNC_EXTRAS_IGNORE_BACKOFF}.
 *
 * Ignoring back-off will force the sync scheduling process to ignore any back-off that was
 * the result of a failed sync, as well as to invalidate any {@link android.content.SyncResult#delayUntil SyncResult#delayUntil}
 * value that may have been set by the adapter. Successive failures will not honor this
 * flag. Not valid for periodic sync and will throw an <code>IllegalArgumentException</code>
 * in {@link #build()}.
 *
 * @param ignoreBackoff ignore back off settings. Default false.
 * @apiSince 19
 */

public android.content.SyncRequest.Builder setIgnoreBackoff(boolean ignoreBackoff) { throw new RuntimeException("Stub!"); }

/**
 * Convenience function for setting {@link android.content.ContentResolver#SYNC_EXTRAS_MANUAL ContentResolver#SYNC_EXTRAS_MANUAL}.
 *
 * Not valid for periodic sync and will throw an <code>IllegalArgumentException</code> in
 * {@link #build()}.
 *
 * @param isManual User-initiated sync or not. Default false.
 * @apiSince 19
 */

public android.content.SyncRequest.Builder setManual(boolean isManual) { throw new RuntimeException("Stub!"); }

/**
 * An expedited sync runs immediately and can preempt other non-expedited running syncs.
 *
 * Not valid for periodic sync and will throw an <code>IllegalArgumentException</code> in
 * {@link #build()}.
 *
 * @param expedited whether to run expedited. Default false.
 * @apiSince 19
 */

public android.content.SyncRequest.Builder setExpedited(boolean expedited) { throw new RuntimeException("Stub!"); }

/**
 * Performs validation over the request and throws the runtime exception
 * <code>IllegalArgumentException</code> if this validation fails.
 *
 * @return a SyncRequest with the information contained within this
 *         builder.
 * @apiSince 19
 */

public android.content.SyncRequest build() { throw new RuntimeException("Stub!"); }
}

}

