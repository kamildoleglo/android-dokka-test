/*
 * Copyright (C) 2014 The Android Open Source Project
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


package android.telephony;

import android.content.Context;
import java.util.concurrent.Executor;
import android.Manifest;
import android.net.NetworkCapabilities;
import java.util.function.Consumer;
import java.util.List;

/**
 * SubscriptionManager is the application interface to SubscriptionController
 * and provides information about the current Telephony Subscriptions.
 * @apiSince 22
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SubscriptionManager {

SubscriptionManager() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated developers should always obtain references directly from
 *             {@link android.content.Context#getSystemService(java.lang.Class) Context#getSystemService(Class)}.
 * @apiSince 22
 * @deprecatedSince 28
 */

@Deprecated
public static android.telephony.SubscriptionManager from(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Register for changes to the list of active {@link android.telephony.SubscriptionInfo SubscriptionInfo} records or to the
 * individual records themselves. When a change occurs the onSubscriptionsChanged method of
 * the listener will be invoked immediately if there has been a notification. The
 * onSubscriptionChanged method will also be triggered once initially when calling this
 * function.
 *
 * @param listener an instance of {@link android.telephony.SubscriptionManager.OnSubscriptionsChangedListener OnSubscriptionsChangedListener} with
 *                 onSubscriptionsChanged overridden.
 * @apiSince 22
 */

public void addOnSubscriptionsChangedListener(android.telephony.SubscriptionManager.OnSubscriptionsChangedListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Unregister the {@link android.telephony.SubscriptionManager.OnSubscriptionsChangedListener OnSubscriptionsChangedListener}. This is not strictly necessary
 * as the listener will automatically be unregistered if an attempt to invoke the listener
 * fails.
 *
 * @param listener that is to be unregistered.
 * @apiSince 22
 */

public void removeOnSubscriptionsChangedListener(android.telephony.SubscriptionManager.OnSubscriptionsChangedListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Register for changes to the list of opportunistic subscription records or to the
 * individual records themselves. When a change occurs the onOpportunisticSubscriptionsChanged
 * method of the listener will be invoked immediately if there has been a notification.
 *
 * @param listener an instance of {@link android.telephony.SubscriptionManager.OnOpportunisticSubscriptionsChangedListener OnOpportunisticSubscriptionsChangedListener} with
 *                 onOpportunisticSubscriptionsChanged overridden.
 
 * This value must never be {@code null}.
 * @param executor This value must never be {@code null}.
 
 * Callback and listener events are dispatched through this
 * {@link java.util.concurrent.Executor Executor}, providing an easy way to control which thread is
 * used. To dispatch events through the main thread of your
 * application, you can use {@link android.content.Context#getMainExecutor() Context#getMainExecutor()}. To
 * dispatch events through a shared thread pool, you can use
 * {@link android.os.AsyncTask#THREAD_POOL_EXECUTOR AsyncTask#THREAD_POOL_EXECUTOR}.
 * @apiSince 29
 */

public void addOnOpportunisticSubscriptionsChangedListener(@androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull android.telephony.SubscriptionManager.OnOpportunisticSubscriptionsChangedListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Unregister the {@link android.telephony.SubscriptionManager.OnOpportunisticSubscriptionsChangedListener OnOpportunisticSubscriptionsChangedListener} that is currently
 * listening opportunistic subscriptions change. This is not strictly necessary
 * as the listener will automatically be unregistered if an attempt to invoke the listener
 * fails.
 *
 * @param listener that is to be unregistered.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void removeOnOpportunisticSubscriptionsChangedListener(@androidx.annotation.NonNull android.telephony.SubscriptionManager.OnOpportunisticSubscriptionsChangedListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Get the active SubscriptionInfo with the input subId.
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see
 * {@link android.telephony.TelephonyManager#hasCarrierPrivileges TelephonyManager#hasCarrierPrivileges}).
 *
 * <br>
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @param subId The unique SubscriptionInfo key in database.
 * @return SubscriptionInfo, maybe null if its not active.
 * @apiSince 22
 */

public android.telephony.SubscriptionInfo getActiveSubscriptionInfo(int subId) { throw new RuntimeException("Stub!"); }

/**
 * Get the active SubscriptionInfo associated with the slotIndex
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see
 * {@link android.telephony.TelephonyManager#hasCarrierPrivileges TelephonyManager#hasCarrierPrivileges}).
 *
 * <br>
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @param slotIndex the slot which the subscription is inserted
 * @return SubscriptionInfo, maybe null if its not active
 * @apiSince 22
 */

public android.telephony.SubscriptionInfo getActiveSubscriptionInfoForSimSlotIndex(int slotIndex) { throw new RuntimeException("Stub!"); }

/**
 * Get the SubscriptionInfo(s) of the currently active SIM(s). The records will be sorted
 * by {@link android.telephony.SubscriptionInfo#getSimSlotIndex SubscriptionInfo#getSimSlotIndex} then by {@link android.telephony.SubscriptionInfo#getSubscriptionId SubscriptionInfo#getSubscriptionId}.
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see
 * {@link android.telephony.TelephonyManager#hasCarrierPrivileges TelephonyManager#hasCarrierPrivileges}). In the latter case, only records accessible
 * to the calling app are returned.
 *
 * <br>
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @return Sorted list of the currently {@link android.telephony.SubscriptionInfo SubscriptionInfo} records available on the device.
 * <ul>
 * <li>
 * If null is returned the current state is unknown but if a {@link android.telephony.SubscriptionManager.OnSubscriptionsChangedListener OnSubscriptionsChangedListener}
 * has been registered {@link android.telephony.SubscriptionManager.OnSubscriptionsChangedListener#onSubscriptionsChanged OnSubscriptionsChangedListener#onSubscriptionsChanged} will be
 * invoked in the future.
 * </li>
 * <li>
 * If the list is empty then there are no {@link android.telephony.SubscriptionInfo SubscriptionInfo} records currently available.
 * </li>
 * <li>
 * if the list is non-empty the list is sorted by {@link android.telephony.SubscriptionInfo#getSimSlotIndex SubscriptionInfo#getSimSlotIndex}
 * then by {@link android.telephony.SubscriptionInfo#getSubscriptionId SubscriptionInfo#getSubscriptionId}.
 * </li>
 * </ul>
 * @apiSince 22
 */

public java.util.List<android.telephony.SubscriptionInfo> getActiveSubscriptionInfoList() { throw new RuntimeException("Stub!"); }

/**
 * Get both hidden and visible SubscriptionInfo(s) of the currently active SIM(s).
 * The records will be sorted by {@link android.telephony.SubscriptionInfo#getSimSlotIndex SubscriptionInfo#getSimSlotIndex}
 * then by {@link android.telephony.SubscriptionInfo#getSubscriptionId SubscriptionInfo#getSubscriptionId}.
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see
 * {@link android.telephony.TelephonyManager#hasCarrierPrivileges TelephonyManager#hasCarrierPrivileges}). In the latter case, only records accessible
 * to the calling app are returned.
 *
 * @return Sorted list of the currently available {@link android.telephony.SubscriptionInfo SubscriptionInfo}
 * records on the device.
 * This is similar to {@link #getActiveSubscriptionInfoList} except that it will return
 * both active and hidden SubscriptionInfos.
 *
 
 * This value may be {@code null}.
 * @apiSince R
 */

@androidx.annotation.Nullable
public java.util.List<android.telephony.SubscriptionInfo> getActiveAndHiddenSubscriptionInfoList() { throw new RuntimeException("Stub!"); }

/**
 * Gets the SubscriptionInfo(s) of all embedded subscriptions accessible to the calling app, if
 * any.
 *
 * <p>Only those subscriptions for which the calling app has carrier privileges per the
 * subscription metadata, if any, will be included in the returned list.
 *
 * <p>The records will be sorted by {@link android.telephony.SubscriptionInfo#getSimSlotIndex SubscriptionInfo#getSimSlotIndex} then by
 * {@link android.telephony.SubscriptionInfo#getSubscriptionId SubscriptionInfo#getSubscriptionId}.
 *
 * @return Sorted list of the current embedded {@link android.telephony.SubscriptionInfo SubscriptionInfo} records available on the
 * device which are accessible to the caller.
 * <ul>
 * <li>
 * If null is returned the current state is unknown but if a
 * {@link android.telephony.SubscriptionManager.OnSubscriptionsChangedListener OnSubscriptionsChangedListener} has been registered
 * {@link android.telephony.SubscriptionManager.OnSubscriptionsChangedListener#onSubscriptionsChanged OnSubscriptionsChangedListener#onSubscriptionsChanged} will be invoked in the future.
 * <li>
 * If the list is empty then there are no {@link android.telephony.SubscriptionInfo SubscriptionInfo} records currently available.
 * <li>
 * if the list is non-empty the list is sorted by {@link android.telephony.SubscriptionInfo#getSimSlotIndex SubscriptionInfo#getSimSlotIndex}
 * then by {@link android.telephony.SubscriptionInfo#getSubscriptionId SubscriptionInfo#getSubscriptionId}.
 * </ul>
 * @apiSince 28
 */

public java.util.List<android.telephony.SubscriptionInfo> getAccessibleSubscriptionInfoList() { throw new RuntimeException("Stub!"); }

/**
 *
 * Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see
 * {@link android.telephony.TelephonyManager#hasCarrierPrivileges TelephonyManager#hasCarrierPrivileges}). In the latter case, the count will include
 * only those subscriptions accessible to the caller.
 *
 * <br>
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @return the current number of active subscriptions. There is no guarantee the value
 * returned by this method will be the same as the length of the list returned by
 * {@link #getActiveSubscriptionInfoList}.
 @apiSince 22
 */

public int getActiveSubscriptionInfoCount() { throw new RuntimeException("Stub!"); }

/**
 * @return the maximum number of active subscriptions that will be returned by
 * {@link #getActiveSubscriptionInfoList} and the value returned by
 * {@link #getActiveSubscriptionInfoCount}.
 * @apiSince 22
 */

public int getActiveSubscriptionInfoCountMax() { throw new RuntimeException("Stub!"); }

/**
 * Get slotIndex associated with the subscription.
 *
 * @param subscriptionId the unique SubscriptionInfo index in database
 * @return slotIndex as a positive integer or {@link #INVALID_SIM_SLOT_INDEX} if the supplied
 * subscriptionId doesn't have an associated slot index.
 * @apiSince 29
 */

public static int getSlotIndex(int subscriptionId) { throw new RuntimeException("Stub!"); }

/**
 * Get an array of Subscription Ids for specified slot Index.
 * @param slotIndex the slot index.
 * @return subscription Ids or null if the given slot Index is not valid or there are no active
 * subscriptions in the slot.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public int[] getSubscriptionIds(int slotIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns the system's default subscription id.
 *
 * For a voice capable device, it will return getDefaultVoiceSubscriptionId.
 * For a data only device, it will return the getDefaultDataSubscriptionId.
 * May return an INVALID_SUBSCRIPTION_ID on error.
 *
 * @return the "system" default subscription id.
 * @apiSince 24
 */

public static int getDefaultSubscriptionId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the system's default voice subscription id.
 *
 * On a data only device or on error, will return INVALID_SUBSCRIPTION_ID.
 *
 * @return the default voice subscription Id.
 * @apiSince 24
 */

public static int getDefaultVoiceSubscriptionId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the system's default SMS subscription id.
 *
 * On a data only device or on error, will return INVALID_SUBSCRIPTION_ID.
 *
 * @return the default SMS subscription Id.
 * @apiSince 24
 */

public static int getDefaultSmsSubscriptionId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the system's default data subscription id.
 *
 * On a voice only device or on error, will return INVALID_SUBSCRIPTION_ID.
 *
 * @return the default data subscription Id.
 * @apiSince 24
 */

public static int getDefaultDataSubscriptionId() { throw new RuntimeException("Stub!"); }

/**
 * Check if the supplied subscription ID is valid.
 *
 * <p>A valid subscription ID is not necessarily an active subscription ID
 * (see {@link #isActiveSubscriptionId(int)}) or an usable subscription ID
 * (see {@link #isUsableSubscriptionId(int)}). Unless specifically noted, subscription
 * APIs work with a valid subscription ID.
 *
 * @param subscriptionId The subscription ID.
 * @return {@code true} if the supplied subscriptionId is valid; {@code false} otherwise.
 * @apiSince 29
 */

public static boolean isValidSubscriptionId(int subscriptionId) { throw new RuntimeException("Stub!"); }

/**
 * Check if the supplied subscription ID is usable.
 *
 * <p>A usable subscription ID is a valid subscription ID, but not necessarily an active
 * subscription ID (see {@link #isActiveSubscriptionId(int)}). Some subscription APIs
 * require a usable subscription ID, and this is noted in their documentation; otherwise, a
 * subscription ID does not need to be usable for subscription functions, only valid.
 *
 * @param subscriptionId the subscription ID
 * @return {@code true} if the subscription ID is usable; {@code false} otherwise.
 * @apiSince 29
 */

public static boolean isUsableSubscriptionId(int subscriptionId) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the device is considered roaming on the current
 * network for a subscription.
 * <p>
 * Availability: Only when user registered to a network.
 *
 * @param subId The subscription ID
 * @return true if the network for the subscription is roaming, false otherwise
 * @apiSince 22
 */

public boolean isNetworkRoaming(int subId) { throw new RuntimeException("Stub!"); }

/**
 * Checks if the supplied subscription ID corresponds to a subscription which is actively in
 * use on the device. An active subscription ID is a valid and usable subscription ID.
 *
 * <br>
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @param subscriptionId the subscription ID.
 * @return {@code true} if the supplied subscription ID corresponds to an active subscription;
 * {@code false} if it does not correspond to an active subscription; or throw a
 * SecurityException if the caller hasn't got the right permission.
 * @apiSince 29
 */

public boolean isActiveSubscriptionId(int subscriptionId) { throw new RuntimeException("Stub!"); }

/**
 * Get the description of the billing relationship plan between a carrier
 * and a specific subscriber.
 * <p>
 * This method is only accessible to the following narrow set of apps:
 * <ul>
 * <li>The carrier app for this subscriberId, as determined by
 * {@link android.telephony.TelephonyManager#hasCarrierPrivileges() TelephonyManager#hasCarrierPrivileges()}.
 * <li>The carrier app explicitly delegated access through
 * {@link android.telephony.CarrierConfigManager#KEY_CONFIG_PLANS_PACKAGE_OVERRIDE_STRING CarrierConfigManager#KEY_CONFIG_PLANS_PACKAGE_OVERRIDE_STRING}.
 * </ul>
 *
 * @param subId the subscriber this relationship applies to
 * @throws java.lang.SecurityException if the caller doesn't meet the requirements
 *             outlined above.
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.util.List<android.telephony.SubscriptionPlan> getSubscriptionPlans(int subId) { throw new RuntimeException("Stub!"); }

/**
 * Set the description of the billing relationship plan between a carrier
 * and a specific subscriber.
 * <p>
 * This method is only accessible to the following narrow set of apps:
 * <ul>
 * <li>The carrier app for this subscriberId, as determined by
 * {@link android.telephony.TelephonyManager#hasCarrierPrivileges() TelephonyManager#hasCarrierPrivileges()}.
 * <li>The carrier app explicitly delegated access through
 * {@link android.telephony.CarrierConfigManager#KEY_CONFIG_PLANS_PACKAGE_OVERRIDE_STRING CarrierConfigManager#KEY_CONFIG_PLANS_PACKAGE_OVERRIDE_STRING}.
 * </ul>
 *
 * @param subId the subscriber this relationship applies to. An empty list
 *            may be sent to clear any existing plans.
 * @param plans the list of plans. The first plan is always the primary and
 *            most important plan. Any additional plans are secondary and
 *            may not be displayed or used by decision making logic.
 * This value must never be {@code null}.
 * @throws java.lang.SecurityException if the caller doesn't meet the requirements
 *             outlined above.
 * @apiSince 28
 */

public void setSubscriptionPlans(int subId, @androidx.annotation.NonNull java.util.List<android.telephony.SubscriptionPlan> plans) { throw new RuntimeException("Stub!"); }

/**
 * Temporarily override the billing relationship plan between a carrier and
 * a specific subscriber to be considered unmetered. This will be reflected
 * to apps via {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_METERED NetworkCapabilities#NET_CAPABILITY_NOT_METERED}.
 * <p>
 * This method is only accessible to the following narrow set of apps:
 * <ul>
 * <li>The carrier app for this subscriberId, as determined by
 * {@link android.telephony.TelephonyManager#hasCarrierPrivileges() TelephonyManager#hasCarrierPrivileges()}.
 * <li>The carrier app explicitly delegated access through
 * {@link android.telephony.CarrierConfigManager#KEY_CONFIG_PLANS_PACKAGE_OVERRIDE_STRING CarrierConfigManager#KEY_CONFIG_PLANS_PACKAGE_OVERRIDE_STRING}.
 * </ul>
 *
 * @param subId the subscriber this override applies to.
 * @param overrideUnmetered set if the billing relationship should be
 *            considered unmetered.
 * @param timeoutMillis the timeout after which the requested override will
 *            be automatically cleared, or {@code 0} to leave in the
 *            requested state until explicitly cleared, or the next reboot,
 *            whichever happens first.
 * Value is a non-negative duration in milliseconds.
 * @throws java.lang.SecurityException if the caller doesn't meet the requirements
 *             outlined above.
 * @apiSince 28
 */

public void setSubscriptionOverrideUnmetered(int subId, boolean overrideUnmetered, long timeoutMillis) { throw new RuntimeException("Stub!"); }

/**
 * Temporarily override the billing relationship plan between a carrier and
 * a specific subscriber to be considered congested. This will cause the
 * device to delay certain network requests when possible, such as developer
 * jobs that are willing to run in a flexible time window.
 * <p>
 * This method is only accessible to the following narrow set of apps:
 * <ul>
 * <li>The carrier app for this subscriberId, as determined by
 * {@link android.telephony.TelephonyManager#hasCarrierPrivileges() TelephonyManager#hasCarrierPrivileges()}.
 * <li>The carrier app explicitly delegated access through
 * {@link android.telephony.CarrierConfigManager#KEY_CONFIG_PLANS_PACKAGE_OVERRIDE_STRING CarrierConfigManager#KEY_CONFIG_PLANS_PACKAGE_OVERRIDE_STRING}.
 * </ul>
 *
 * @param subId the subscriber this override applies to.
 * @param overrideCongested set if the subscription should be considered
 *            congested.
 * @param timeoutMillis the timeout after which the requested override will
 *            be automatically cleared, or {@code 0} to leave in the
 *            requested state until explicitly cleared, or the next reboot,
 *            whichever happens first.
 * Value is a non-negative duration in milliseconds.
 * @throws java.lang.SecurityException if the caller doesn't meet the requirements
 *             outlined above.
 * @apiSince 28
 */

public void setSubscriptionOverrideCongested(int subId, boolean overrideCongested, long timeoutMillis) { throw new RuntimeException("Stub!"); }

/**
 * Checks whether the app with the given context is authorized to manage the given subscription
 * according to its metadata. Only supported for embedded subscriptions (if
 * {@code SubscriptionInfo#isEmbedded} returns true).
 *
 * @param info The subscription to check.
 * @return whether the app is authorized to manage this subscription per its metadata.
 * @apiSince 28
 */

public boolean canManageSubscription(android.telephony.SubscriptionInfo info) { throw new RuntimeException("Stub!"); }

/**
 * Return opportunistic subscriptions that can be visible to the caller.
 * Opportunistic subscriptions are for opportunistic networks, which are cellular
 * networks with limited capabilities and coverage, for example, CBRS.
 *
 * <p>Requires Permission:
 * {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see
 * {@link android.telephony.TelephonyManager#hasCarrierPrivileges TelephonyManager#hasCarrierPrivileges}).
 *
 * <br>
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @return the list of opportunistic subscription info. If none exists, an empty list.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.util.List<android.telephony.SubscriptionInfo> getOpportunisticSubscriptions() { throw new RuntimeException("Stub!"); }

/**
 * Switch to a certain subscription
 *
 *
 * <br>
 * Requires android.Manifest.permission.WRITE_EMBEDDED_SUBSCRIPTIONS
 * @param subId sub id
 *  @param callbackIntent pending intent that will be sent after operation is done.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void switchToSubscription(int subId, @androidx.annotation.NonNull android.app.PendingIntent callbackIntent) { throw new RuntimeException("Stub!"); }

/**
 * Set whether a subscription is opportunistic, that is, whether the network it connects
 * to has limited coverage. For example, CBRS. Setting a subscription opportunistic has
 * following impacts:
 *  1) Even if it's active, it will be dormant most of the time. The modem will not try
 *     to scan or camp until it knows an available network is nearby to save power.
 *  2) Telephony relies on system app or carrier input to notify nearby available networks.
 *     See {@link android.telephony.TelephonyManager#updateAvailableNetworks(java.util.List,java.util.concurrent.Executor,java.util.function.Consumer) TelephonyManager#updateAvailableNetworks(List, Executor, Consumer)}
 *     for more information.
 *  3) In multi-SIM devices, when the network is nearby and camped, system may automatically
 *     switch internet data between it and default data subscription, based on carrier
 *     recommendation and its signal strength and metered-ness, etc.
 *
 *
 * Caller will either have {@link android.Manifest.permission#MODIFY_PHONE_STATE} or carrier
 * privilege permission of the subscription.
 *
 * <br>
 * Requires {@link android.Manifest.permission#MODIFY_PHONE_STATE}
 * @param opportunistic whether it’s opportunistic subscription.
 * @param subId the unique SubscriptionInfo index in database
 * @return {@code true} if the operation is succeed, {@code false} otherwise.
 * @apiSince 29
 */

public boolean setOpportunistic(boolean opportunistic, int subId) { throw new RuntimeException("Stub!"); }

/**
 * Inform SubscriptionManager that subscriptions in the list are bundled
 * as a group. It can be multiple primary (non-opportunistic) subscriptions,
 * or one or more primary plus one or more opportunistic subscriptions.
 *
 * This API will always create a new immutable group and assign group UUID to all the
 * subscriptions, regardless whether they are in a group already or not.
 *
 * Grouped subscriptions will have below behaviors:
 * 1) They will share the same user settings.
 * 2) The opportunistic subscriptions in the group is considered invisible and will not
 *    return from {@link #getActiveSubscriptionInfoList()}, unless caller has carrier
 *    privilege permission of the subscriptions.
 * 3) The opportunistic subscriptions in the group can't be active by itself. If all other
 *    non-opportunistic ones are deactivated (unplugged or disabled in Settings),
 *    the opportunistic ones will be deactivated automatically.
 *
 * Caller will either have {@link android.Manifest.permission#MODIFY_PHONE_STATE}
 * permission or had carrier privilege permission on the subscriptions:
 * {@link android.telephony.TelephonyManager#hasCarrierPrivileges() TelephonyManager#hasCarrierPrivileges()} or
 * {@link #canManageSubscription(android.telephony.SubscriptionInfo)}
 *
 * <br>
 * Requires {@link android.Manifest.permission#MODIFY_PHONE_STATE}
 * @throws java.lang.SecurityException if the caller doesn't meet the requirements
 *             outlined above.
 * @throws java.lang.IllegalArgumentException if any of the subscriptions in the list doesn't exist.
 * @throws java.lang.IllegalStateException if Telephony service is in bad state.
 *
 * @param subIdList list of subId that will be in the same group
 * This value must never be {@code null}.
 * @return groupUUID a UUID assigned to the subscription group.
 *
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.os.ParcelUuid createSubscriptionGroup(@androidx.annotation.NonNull java.util.List<java.lang.Integer> subIdList) { throw new RuntimeException("Stub!"); }

/**
 * Add a list of subscriptions into a group.
 * See {@link #createSubscriptionGroup(java.util.List)} for more details.
 *
 * Caller will either have {@link android.Manifest.permission#MODIFY_PHONE_STATE}
 * permission or had carrier privilege permission on the subscriptions:
 * {@link android.telephony.TelephonyManager#hasCarrierPrivileges() TelephonyManager#hasCarrierPrivileges()} or
 * {@link #canManageSubscription(android.telephony.SubscriptionInfo)}
 *
 * <br>
 * Requires {@link android.Manifest.permission#MODIFY_PHONE_STATE}
 * @throws java.lang.SecurityException if the caller doesn't meet the requirements
 *             outlined above.
 * @throws java.lang.IllegalArgumentException if the some subscriptions in the list doesn't exist.
 * @throws java.lang.IllegalStateException if Telephony service is in bad state.
 *
 * @param subIdList list of subId that need adding into the group
 * This value must never be {@code null}.
 * @param groupUuid the groupUuid the subscriptions are being added to.
 *
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void addSubscriptionsIntoGroup(@androidx.annotation.NonNull java.util.List<java.lang.Integer> subIdList, @androidx.annotation.NonNull android.os.ParcelUuid groupUuid) { throw new RuntimeException("Stub!"); }

/**
 * Remove a list of subscriptions from their subscription group.
 * See {@link #createSubscriptionGroup(java.util.List)} for more details.
 *
 * Caller will either have {@link android.Manifest.permission#MODIFY_PHONE_STATE}
 * permission or had carrier privilege permission on the subscriptions:
 * {@link android.telephony.TelephonyManager#hasCarrierPrivileges() TelephonyManager#hasCarrierPrivileges()} or
 * {@link #canManageSubscription(android.telephony.SubscriptionInfo)}
 *
 * <br>
 * Requires {@link android.Manifest.permission#MODIFY_PHONE_STATE}
 * @throws java.lang.SecurityException if the caller doesn't meet the requirements
 *             outlined above.
 * @throws java.lang.IllegalArgumentException if the some subscriptions in the list doesn't belong
 *             the specified group.
 * @throws java.lang.IllegalStateException if Telephony service is in bad state.
 *
 * @param subIdList list of subId that need removing from their groups.
 *
 
 * This value must never be {@code null}.
 
 * @param groupUuid This value must never be {@code null}.
 * @apiSince 29
 */

public void removeSubscriptionsFromGroup(@androidx.annotation.NonNull java.util.List<java.lang.Integer> subIdList, @androidx.annotation.NonNull android.os.ParcelUuid groupUuid) { throw new RuntimeException("Stub!"); }

/**
 * Get subscriptionInfo list of subscriptions that are in the same group of given subId.
 * See {@link #createSubscriptionGroup(java.util.List)} for more details.
 *
 * Caller will either have {@link android.Manifest.permission#READ_PHONE_STATE}
 * permission or had carrier privilege permission on the subscription.
 * {@link android.telephony.TelephonyManager#hasCarrierPrivileges() TelephonyManager#hasCarrierPrivileges()}
 *
 * <br>
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @throws java.lang.IllegalStateException if Telephony service is in bad state.
 * @throws java.lang.SecurityException if the caller doesn't meet the requirements
 *             outlined above.
 *
 * @param groupUuid of which list of subInfo will be returned.
 * This value must never be {@code null}.
 * @return list of subscriptionInfo that belong to the same group, including the given
 * subscription itself. It will return an empty list if no subscription belongs to the group.
 *
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.util.List<android.telephony.SubscriptionInfo> getSubscriptionsInGroup(@androidx.annotation.NonNull android.os.ParcelUuid groupUuid) { throw new RuntimeException("Stub!"); }

/**
 * Get active data subscription id. Active data subscription refers to the subscription
 * currently chosen to provide cellular internet connection to the user. This may be
 * different from getDefaultDataSubscriptionId(). Eg. Opportunistics data
 *
 * See {@link android.telephony.PhoneStateListener#onActiveDataSubscriptionIdChanged(int) PhoneStateListener#onActiveDataSubscriptionIdChanged(int)} for the details.
 *
 * @return Active data subscription id if any is chosen, or
 * SubscriptionManager.INVALID_SUBSCRIPTION_ID if not.
 * @apiSince R
 */

public static int getActiveDataSubscriptionId() { throw new RuntimeException("Stub!"); }

/**
 * Broadcast Action: The default sms subscription has changed.  This has the following
 * extra values:</p>
 * {@link #EXTRA_SUBSCRIPTION_INDEX} extra indicates the current default sms
 * subscription index
 * @apiSince 26
 */

public static final java.lang.String ACTION_DEFAULT_SMS_SUBSCRIPTION_CHANGED = "android.telephony.action.DEFAULT_SMS_SUBSCRIPTION_CHANGED";

/**
 * Broadcast Action: The default subscription has changed.  This has the following
 * extra values:</p>
 * The {@link #EXTRA_SUBSCRIPTION_INDEX} extra indicates the current default subscription index
 * @apiSince 26
 */

public static final java.lang.String ACTION_DEFAULT_SUBSCRIPTION_CHANGED = "android.telephony.action.DEFAULT_SUBSCRIPTION_CHANGED";

/**
 * Activity Action: Display UI for managing the billing relationship plans
 * between a carrier and a specific subscriber.
 * <p>
 * Carrier apps are encouraged to implement this activity, and the OS will
 * provide an affordance to quickly enter this activity, typically via
 * Settings. This affordance will only be shown when the carrier app is
 * actively providing subscription plan information via
 * {@link #setSubscriptionPlans(int,java.util.List)}.
 * <p>
 * Contains {@link #EXTRA_SUBSCRIPTION_INDEX} to indicate which subscription
 * the user is interested in.
 * @apiSince 28
 */

public static final java.lang.String ACTION_MANAGE_SUBSCRIPTION_PLANS = "android.telephony.action.MANAGE_SUBSCRIPTION_PLANS";

/**
 * Broadcast Action: Request a refresh of the billing relationship plans
 * between a carrier and a specific subscriber.
 * <p>
 * Carrier apps are encouraged to implement this receiver, and the OS will
 * provide an affordance to request a refresh. This affordance will only be
 * shown when the carrier app is actively providing subscription plan
 * information via {@link #setSubscriptionPlans(int,java.util.List)}.
 * <p>
 * Contains {@link #EXTRA_SUBSCRIPTION_INDEX} to indicate which subscription
 * the user is interested in.
 * <p>
 * Receivers should protect themselves by checking that the sender holds the
 * {@code android.permission.MANAGE_SUBSCRIPTION_PLANS} permission.
 * @apiSince 28
 */

public static final java.lang.String ACTION_REFRESH_SUBSCRIPTION_PLANS = "android.telephony.action.REFRESH_SUBSCRIPTION_PLANS";

/**
 * Indicates that data roaming is disabled for a subscription
 * @apiSince 22
 */

public static final int DATA_ROAMING_DISABLE = 0; // 0x0

/**
 * Indicates that data roaming is enabled for a subscription
 * @apiSince 22
 */

public static final int DATA_ROAMING_ENABLE = 1; // 0x1

/**
 * Indicates the default subscription ID in Telephony.
 * @apiSince 29
 */

public static final int DEFAULT_SUBSCRIPTION_ID = 2147483647; // 0x7fffffff

/**
 * Integer extra to specify SIM slot index.
 * @apiSince R
 */

public static final java.lang.String EXTRA_SLOT_INDEX = "android.telephony.extra.SLOT_INDEX";

/**
 * Integer extra used with {@link #ACTION_DEFAULT_SUBSCRIPTION_CHANGED} and
 * {@link #ACTION_DEFAULT_SMS_SUBSCRIPTION_CHANGED} to indicate the subscription
 * which has changed.
 * @apiSince 26
 */

public static final java.lang.String EXTRA_SUBSCRIPTION_INDEX = "android.telephony.extra.SUBSCRIPTION_INDEX";

/**
 * Indicates invalid sim slot. This can be returned by {@link #getSlotIndex(int)}.
 * @apiSince 29
 */

public static final int INVALID_SIM_SLOT_INDEX = -1; // 0xffffffff

/**
 * An invalid subscription identifier
 * @apiSince 24
 */

public static final int INVALID_SUBSCRIPTION_ID = -1; // 0xffffffff

/**
 * This constant is to designate a subscription as a Local-SIM Subscription.
 * <p> A Local-SIM can be a physical SIM inserted into a sim-slot in the device, or eSIM on the
 * device.
 * </p>
 * @apiSince 29
 */

public static final int SUBSCRIPTION_TYPE_LOCAL_SIM = 0; // 0x0

/**
 * This constant is to designate a subscription as a Remote-SIM Subscription.
 * <p>
 * A Remote-SIM subscription is for a SIM on a phone connected to this device via some
 * connectivity mechanism, for example bluetooth. Similar to Local SIM, this subscription can
 * be used for SMS, Voice and data by proxying data through the connected device.
 * Certain data of the SIM, such as IMEI, are not accessible for Remote SIMs.
 * </p>
 *
 * <p>
 * A Remote-SIM is available only as long the phone stays connected to this device.
 * When the phone disconnects, Remote-SIM subscription is removed from this device and is
 * no longer known. All data associated with the subscription, such as stored SMS, call logs,
 * contacts etc, are removed from this device.
 * </p>
 *
 * <p>
 * If the phone re-connects to this device, a new Remote-SIM subscription is created for
 * the phone. The Subscription Id associated with the new subscription is different from
 * the Subscription Id of the previous Remote-SIM subscription created (and removed) for the
 * phone; i.e., new Remote-SIM subscription treats the reconnected phone as a Remote-SIM that
 * was never seen before.
 * </p>
 * @apiSince 29
 */

public static final int SUBSCRIPTION_TYPE_REMOTE_SIM = 1; // 0x1
/**
 * A listener class for monitoring changes to {@link android.telephony.SubscriptionInfo SubscriptionInfo} records of opportunistic
 * subscriptions.
 * <p>
 * Override the onOpportunisticSubscriptionsChanged method in the object that extends this
 * or {@link #addOnOpportunisticSubscriptionsChangedListener(java.util.concurrent.Executor,android.telephony.SubscriptionManager.OnOpportunisticSubscriptionsChangedListener)}
 * to register your listener and to unregister invoke
 * {@link #removeOnOpportunisticSubscriptionsChangedListener(android.telephony.SubscriptionManager.OnOpportunisticSubscriptionsChangedListener)}
 * <p>
 * Permissions android.Manifest.permission.READ_PHONE_STATE is required
 * for #onOpportunisticSubscriptionsChanged to be invoked.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class OnOpportunisticSubscriptionsChangedListener {

public OnOpportunisticSubscriptionsChangedListener() { throw new RuntimeException("Stub!"); }

/**
 * Callback invoked when there is any change to any SubscriptionInfo. Typically
 * this method would invoke {@link #getActiveSubscriptionInfoList}
 * @apiSince 29
 */

public void onOpportunisticSubscriptionsChanged() { throw new RuntimeException("Stub!"); }
}

/**
 * A listener class for monitoring changes to {@link android.telephony.SubscriptionInfo SubscriptionInfo} records.
 * <p>
 * Override the onSubscriptionsChanged method in the object that extends this
 * class and pass it to {@link #addOnSubscriptionsChangedListener(android.telephony.SubscriptionManager.OnSubscriptionsChangedListener)}
 * to register your listener and to unregister invoke
 * {@link #removeOnSubscriptionsChangedListener(android.telephony.SubscriptionManager.OnSubscriptionsChangedListener)}
 * <p>
 * Permissions android.Manifest.permission.READ_PHONE_STATE is required
 * for #onSubscriptionsChanged to be invoked.
 * @apiSince 22
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class OnSubscriptionsChangedListener {

/** @apiSince 22 */

public OnSubscriptionsChangedListener() { throw new RuntimeException("Stub!"); }

/**
 * Callback invoked when there is any change to any SubscriptionInfo, as well as once on
 * registering for changes with {@link #addOnSubscriptionsChangedListener}. Typically
 * this method would invoke {@link #getActiveSubscriptionInfoList}
 * @apiSince 22
 */

public void onSubscriptionsChanged() { throw new RuntimeException("Stub!"); }
}

}

