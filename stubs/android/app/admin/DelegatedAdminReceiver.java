/*
 * Copyright (C) 2018 The Android Open Source Project
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

import android.app.Service;
import android.security.KeyChain;

/**
 * Base class for delegated apps to handle callbacks related to their delegated capabilities.
 *
 * <p>Delegated apps are apps that receive additional capabilities from the profile owner or
 * device owner apps. Some of these capabilities involve the framework calling into the apps.
 * To receive these callbacks, delegated apps should subclass this class and override the
 * appropriate methods here. The subclassed receiver needs to be published in the app's
 * manifest, with appropriate intent filters to mark which callbacks the receiver is interested
 * in. An app can have multiple receivers as long as they listen for disjoint set of callbacks.
 * For the manifest definitions, it must be protected by the
 * {@link android.Manifest.permission#BIND_DEVICE_ADMIN} permission to ensure only
 * the system can trigger these callbacks.
 *
 * <p>The callback methods happen on the main thread of the process.  Thus long running
 * operations must be done on another thread.  Note that because a receiver
 * is done once returning from its onReceive function, such long-running operations
 * should probably be done in a {@link android.app.Service Service}.
 *
 * @see android.app.admin.DevicePolicyManager#setDelegatedScopes
 * @see android.app.admin.DeviceAdminReceiver
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DelegatedAdminReceiver extends android.content.BroadcastReceiver {

public DelegatedAdminReceiver() { throw new RuntimeException("Stub!"); }

/**
 * Allows this receiver to select the alias for a private key and certificate pair for
 * authentication.  If this method returns null, the default {@link android.app.Activity} will
 * be shown that lets the user pick a private key and certificate pair.
 *
 * <p> This callback is only applicable if the delegated app has
 * {@link android.app.admin.DevicePolicyManager#DELEGATION_CERT_SELECTION DevicePolicyManager#DELEGATION_CERT_SELECTION} capability. Additionally, it must
 * declare an intent filter for {@link android.app.admin.DeviceAdminReceiver#ACTION_CHOOSE_PRIVATE_KEY_ALIAS DeviceAdminReceiver#ACTION_CHOOSE_PRIVATE_KEY_ALIAS}
 * in the receiver's manifest in order to receive this callback. The default implementation
 * simply throws {@link java.lang.UnsupportedOperationException UnsupportedOperationException}.
 *
 * @param context The running context as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param intent The received intent as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param uid The uid of the app asking for the private key and certificate pair.
 * @param uri The URI to authenticate, may be null.
 * This value may be {@code null}.
 * @param alias The alias preselected by the client, or null.
 * This value may be {@code null}.
 * @return The private key alias to return and grant access to.
 * @see KeyChain#choosePrivateKeyAlias
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.lang.String onChoosePrivateKeyAlias(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent intent, int uid, @androidx.annotation.Nullable android.net.Uri uri, @androidx.annotation.Nullable java.lang.String alias) { throw new RuntimeException("Stub!"); }

/**
 * Called each time a new batch of network logs can be retrieved. This callback method will only
 * ever be called when network logging is enabled. The logs can only be retrieved while network
 * logging is enabled.
 *
 * <p>If a secondary user or profile is created, this callback won't be received until all users
 * become affiliated again (even if network logging is enabled). It will also no longer be
 * possible to retrieve the network logs batch with the most recent {@code batchToken} provided
 * by this callback. See {@link android.app.admin.DevicePolicyManager#setAffiliationIds DevicePolicyManager#setAffiliationIds}.
 *
 * <p> This callback is only applicable if the delegated app has
 * {@link android.app.admin.DevicePolicyManager#DELEGATION_NETWORK_LOGGING DevicePolicyManager#DELEGATION_NETWORK_LOGGING} capability. Additionally, it must
 * declare an intent filter for {@link android.app.admin.DeviceAdminReceiver#ACTION_NETWORK_LOGS_AVAILABLE DeviceAdminReceiver#ACTION_NETWORK_LOGS_AVAILABLE} in the
 * receiver's manifest in order to receive this callback. The default implementation
 * simply throws {@link java.lang.UnsupportedOperationException UnsupportedOperationException}.
 *
 * @param context The running context as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param intent The received intent as per {@link #onReceive}.
 * This value must never be {@code null}.
 * @param batchToken The token representing the current batch of network logs.
 * @param networkLogsCount The total count of events in the current batch of network logs.
 * Value is 1 or greater
 * @see android.app.admin.DevicePolicyManager#retrieveNetworkLogs
 * @apiSince 29
 */

public void onNetworkLogsAvailable(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent intent, long batchToken, int networkLogsCount) { throw new RuntimeException("Stub!"); }

/**
 * Intercept delegated device administrator broadcasts. Implementations should not override
 * this method; implement the convenience callbacks for each action instead.
 
 * @param context This value must never be {@code null}.
 
 * @param intent This value must never be {@code null}.
 * @apiSince 29
 */

public final void onReceive(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent intent) { throw new RuntimeException("Stub!"); }
}

