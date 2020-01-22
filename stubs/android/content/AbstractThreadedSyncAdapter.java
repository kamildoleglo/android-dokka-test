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
import android.os.Bundle;
import android.os.IBinder;

/**
 * An abstract implementation of a SyncAdapter that spawns a thread to invoke a sync operation.
 * If a sync operation is already in progress when a sync request is received, an error will be
 * returned to the new request and the existing request will be allowed to continue.
 * However if there is no sync in progress then a thread will be spawned and {@link #onPerformSync}
 * will be invoked on that thread.
 * <p>
 * Syncs can be cancelled at any time by the framework. For example a sync that was not
 * user-initiated and lasts longer than 30 minutes will be considered timed-out and cancelled.
 * Similarly the framework will attempt to determine whether or not an adapter is making progress
 * by monitoring its network activity over the course of a minute. If the network traffic over this
 * window is close enough to zero the sync will be cancelled. You can also request the sync be
 * cancelled via {@link android.content.ContentResolver#cancelSync(android.accounts.Account,java.lang.String) ContentResolver#cancelSync(Account, String)} or
 * {@link android.content.ContentResolver#cancelSync(android.content.SyncRequest) ContentResolver#cancelSync(SyncRequest)}.
 * <p>
 * A sync is cancelled by issuing a {@link java.lang.Thread#interrupt() Thread#interrupt()} on the syncing thread. <strong>Either
 * your code in {@link #onPerformSync(android.accounts.Account,android.os.Bundle,java.lang.String,android.content.ContentProviderClient,android.content.SyncResult)}
 * must check {@link java.lang.Thread#interrupted() Thread#interrupted()}, or you you must override one of
 * {@link #onSyncCanceled(java.lang.Thread)}/{@link #onSyncCanceled()}</strong> (depending on whether or not
 * your adapter supports syncing of multiple accounts in parallel). If your adapter does not
 * respect the cancel issued by the framework you run the risk of your app's entire process being
 * killed.
 * <p>
 * In order to be a sync adapter one must extend this class, provide implementations for the
 * abstract methods and write a service that returns the result of {@link #getSyncAdapterBinder()}
 * in the service's {@link android.app.Service#onBind(android.content.Intent)} when invoked
 * with an intent with action <code>android.content.SyncAdapter</code>. This service
 * must specify the following intent filter and metadata tags in its AndroidManifest.xml file
 * <pre>
 *   &lt;intent-filter&gt;
 *     &lt;action android:name="android.content.SyncAdapter" /&gt;
 *   &lt;/intent-filter&gt;
 *   &lt;meta-data android:name="android.content.SyncAdapter"
 *             android:resource="@xml/syncadapter" /&gt;
 * </pre>
 * The <code>android:resource</code> attribute must point to a resource that looks like:
 * <pre>
 * &lt;sync-adapter xmlns:android="http://schemas.android.com/apk/res/android"
 *    android:contentAuthority="authority"
 *    android:accountType="accountType"
 *    android:userVisible="true|false"
 *    android:supportsUploading="true|false"
 *    android:allowParallelSyncs="true|false"
 *    android:isAlwaysSyncable="true|false"
 *    android:syncAdapterSettingsAction="ACTION_OF_SETTINGS_ACTIVITY"
 * /&gt;
 * </pre>
 * <ul>
 * <li>The <code>android:contentAuthority</code> and <code>android:accountType</code> attributes
 * indicate which content authority and for which account types this sync adapter serves.
 * <li><code>android:userVisible</code> defaults to true and controls whether or not this sync
 * adapter shows up in the Sync Settings screen.
 * <li><code>android:supportsUploading</code> defaults
 * to true and if true an upload-only sync will be requested for all syncadapters associated
 * with an authority whenever that authority's content provider does a
 * {@link android.content.ContentResolver#notifyChange(android.net.Uri,android.database.ContentObserver,boolean) ContentResolver#notifyChange(android.net.Uri, android.database.ContentObserver, boolean)}
 * with syncToNetwork set to true.
 * <li><code>android:allowParallelSyncs</code> defaults to false and if true indicates that
 * the sync adapter can handle syncs for multiple accounts at the same time. Otherwise
 * the SyncManager will wait until the sync adapter is not in use before requesting that
 * it sync an account's data.
 * <li><code>android:isAlwaysSyncable</code> defaults to false and if true tells the SyncManager
 * to initialize the isSyncable state to 1 for that sync adapter for each account that is added.
 * <li><code>android:syncAdapterSettingsAction</code> defaults to null and if supplied it
 * specifies an Intent action of an activity that can be used to adjust the sync adapter's
 * sync settings. The activity must live in the same package as the sync adapter.
 * </ul>
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class AbstractThreadedSyncAdapter {

/**
 * Creates an {@link android.content.AbstractThreadedSyncAdapter AbstractThreadedSyncAdapter}.
 * @param context the {@link android.content.Context} that this is running within.
 * @param autoInitialize if true then sync requests that have
 * {@link android.content.ContentResolver#SYNC_EXTRAS_INITIALIZE ContentResolver#SYNC_EXTRAS_INITIALIZE} set will be internally handled by
 * {@link android.content.AbstractThreadedSyncAdapter AbstractThreadedSyncAdapter} by calling
 * {@link android.content.ContentResolver#setIsSyncable(android.accounts.Account,java.lang.String,int) ContentResolver#setIsSyncable(android.accounts.Account, String, int)} with 1 if it
 * is currently set to <0.
 * @apiSince 5
 */

public AbstractThreadedSyncAdapter(android.content.Context context, boolean autoInitialize) { throw new RuntimeException("Stub!"); }

/**
 * Creates an {@link android.content.AbstractThreadedSyncAdapter AbstractThreadedSyncAdapter}.
 * @param context the {@link android.content.Context} that this is running within.
 * @param autoInitialize if true then sync requests that have
 * {@link android.content.ContentResolver#SYNC_EXTRAS_INITIALIZE ContentResolver#SYNC_EXTRAS_INITIALIZE} set will be internally handled by
 * {@link android.content.AbstractThreadedSyncAdapter AbstractThreadedSyncAdapter} by calling
 * {@link android.content.ContentResolver#setIsSyncable(android.accounts.Account,java.lang.String,int) ContentResolver#setIsSyncable(android.accounts.Account, String, int)} with 1 if it
 * is currently set to <0.
 * @param allowParallelSyncs if true then allow syncs for different accounts to run
 * at the same time, each in their own thread. This must be consistent with the setting
 * in the SyncAdapter's configuration file.
 * @apiSince 11
 */

public AbstractThreadedSyncAdapter(android.content.Context context, boolean autoInitialize, boolean allowParallelSyncs) { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public android.content.Context getContext() { throw new RuntimeException("Stub!"); }

/**
 * @return a reference to the IBinder of the SyncAdapter service.
 * @apiSince 5
 */

public final android.os.IBinder getSyncAdapterBinder() { throw new RuntimeException("Stub!"); }

/**
 * Allows to defer syncing until all accounts are properly set up.
 *
 * <p>Called when a account / authority pair
 * <ul>
 * <li>that can be handled by this adapter</li>
 * <li>{@link android.content.ContentResolver#requestSync(android.content.SyncRequest) ContentResolver#requestSync(SyncRequest)}</li>
 * <li>and the account/provider {@link android.content.ContentResolver#getIsSyncable(android.accounts.Account,java.lang.String) ContentResolver#getIsSyncable(Account, String)}.</li>
 * </ul>
 *
 * <p>This might be called on a different service connection as {@link #onPerformSync}.
 *
 * <p>The system expects this method to immediately return. If the call stalls the system
 * behaves as if this method returned {@code true}. If it is required to perform a longer task
 * (such as interacting with the user), return {@code false} and proceed in a difference
 * context, such as an {@link android.app.Activity}, or foreground service. The sync can then be
 * rescheduled once the account becomes syncable.
 *
 * <br>
 * This method must be called from the
 * {@linkplain android.os.Looper#getMainLooper() Looper#getMainLooper()} of your app.
 * @return If {@code false} syncing is deferred. Returns {@code true} by default, i.e. by
 *         default syncing starts immediately.
 * @apiSince 28
 */

public boolean onUnsyncableAccount() { throw new RuntimeException("Stub!"); }

/**
 * Perform a sync for this account. SyncAdapter-specific parameters may
 * be specified in extras, which is guaranteed to not be null. Invocations
 * of this method are guaranteed to be serialized.
 *
 * @param account the account that should be synced
 * @param extras SyncAdapter-specific parameters
 * @param authority the authority of this sync request
 * @param provider a ContentProviderClient that points to the ContentProvider for this
 *   authority
 * @param syncResult SyncAdapter-specific parameters
 * @apiSince 5
 */

public abstract void onPerformSync(android.accounts.Account account, android.os.Bundle extras, java.lang.String authority, android.content.ContentProviderClient provider, android.content.SyncResult syncResult);

/**
 * Report that there was a security exception when opening the content provider
 * prior to calling {@link #onPerformSync}.  This will be treated as a sync
 * database failure.
 *
 * @param account the account that attempted to sync
 * @param extras SyncAdapter-specific parameters
 * @param authority the authority of the failed sync request
 * @param syncResult SyncAdapter-specific parameters
 * @apiSince 23
 */

public void onSecurityException(android.accounts.Account account, android.os.Bundle extras, java.lang.String authority, android.content.SyncResult syncResult) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that a sync operation has been canceled. This will be invoked on a separate
 * thread than the sync thread and so you must consider the multi-threaded implications
 * of the work that you do in this method.
 * <p>
 * This will only be invoked when the SyncAdapter indicates that it doesn't support
 * parallel syncs.
 * @apiSince 8
 */

public void onSyncCanceled() { throw new RuntimeException("Stub!"); }

/**
 * Indicates that a sync operation has been canceled. This will be invoked on a separate
 * thread than the sync thread and so you must consider the multi-threaded implications
 * of the work that you do in this method.
 * <p>
 * This will only be invoked when the SyncAdapter indicates that it does support
 * parallel syncs.
 * @param thread the Thread of the sync that is to be canceled.
 * @apiSince 11
 */

public void onSyncCanceled(java.lang.Thread thread) { throw new RuntimeException("Stub!"); }

/**
 * Kernel event log tag.  Also listed in data/etc/event-log-tags.
 * @deprecated Private constant.  May go away in the next release.
 * @apiSince 5
 * @deprecatedSince 15
 */

@Deprecated public static final int LOG_SYNC_DETAILS = 2743; // 0xab7
}

