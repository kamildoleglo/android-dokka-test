/**
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy
 * of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */


package android.app.usage;

import android.app.usage.NetworkStats.Bucket;
import android.net.ConnectivityManager;
import android.os.Handler;

/**
 * Provides access to network usage history and statistics. Usage data is collected in
 * discrete bins of time called 'Buckets'. See {@link android.app.usage.NetworkStats.Bucket NetworkStats.Bucket} for details.
 * <p />
 * Queries can define a time interval in the form of start and end timestamps (Long.MIN_VALUE and
 * Long.MAX_VALUE can be used to simulate open ended intervals). By default, apps can only obtain
 * data about themselves. See the below note for special cases in which apps can obtain data about
 * other applications.
 * <h3>
 * Summary queries
 * </h3>
 * {@link #querySummaryForDevice} <p />
 * {@link #querySummaryForUser} <p />
 * {@link #querySummary} <p />
 * These queries aggregate network usage across the whole interval. Therefore there will be only one
 * bucket for a particular key, state, metered and roaming combination. In case of the user-wide
 * and device-wide summaries a single bucket containing the totalised network usage is returned.
 * <h3>
 * History queries
 * </h3>
 * {@link #queryDetailsForUid} <p />
 * {@link #queryDetails} <p />
 * These queries do not aggregate over time but do aggregate over state, metered and roaming.
 * Therefore there can be multiple buckets for a particular key. However, all Buckets will have
 * {@code state} {@link android.app.usage.NetworkStats.Bucket#STATE_ALL NetworkStats.Bucket#STATE_ALL},
 * {@code defaultNetwork} {@link android.app.usage.NetworkStats.Bucket#DEFAULT_NETWORK_ALL NetworkStats.Bucket#DEFAULT_NETWORK_ALL},
 * {@code metered } {@link android.app.usage.NetworkStats.Bucket#METERED_ALL NetworkStats.Bucket#METERED_ALL},
 * {@code roaming} {@link android.app.usage.NetworkStats.Bucket#ROAMING_ALL NetworkStats.Bucket#ROAMING_ALL}.
 * <p />
 * <b>NOTE:</b> Calling {@link #querySummaryForDevice} or accessing stats for apps other than the
 * calling app requires the permission {@link android.Manifest.permission#PACKAGE_USAGE_STATS},
 * which is a system-level permission and will not be granted to third-party apps. However,
 * declaring the permission implies intention to use the API and the user of the device can grant
 * permission through the Settings application.
 * <p />
 * Profile owner apps are automatically granted permission to query data on the profile they manage
 * (that is, for any query except {@link #querySummaryForDevice}). Device owner apps and carrier-
 * privileged apps likewise get access to usage data for all users on the device.
 * <p />
 * In addition to tethering usage, usage by removed users and apps, and usage by the system
 * is also included in the results for callers with one of these higher levels of access.
 * <p />
 * <b>NOTE:</b> Prior to API level {@value android.os.Build.VERSION_CODES#N}, all calls to these APIs required
 * the above permission, even to access an app's own data usage, and carrier-privileged apps were
 * not included.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class NetworkStatsManager {

NetworkStatsManager() { throw new RuntimeException("Stub!"); }

/**
 * Query network usage statistics summaries. Result is summarised data usage for the whole
 * device. Result is a single Bucket aggregated over time, state, uid, tag, metered, and
 * roaming. This means the bucket's start and end timestamp are going to be the same as the
 * 'startTime' and 'endTime' parameters. State is going to be
 * {@link android.app.usage.NetworkStats.Bucket#STATE_ALL NetworkStats.Bucket#STATE_ALL}, uid {@link android.app.usage.NetworkStats.Bucket#UID_ALL NetworkStats.Bucket#UID_ALL},
 * tag {@link android.app.usage.NetworkStats.Bucket#TAG_NONE NetworkStats.Bucket#TAG_NONE},
 * default network {@link android.app.usage.NetworkStats.Bucket#DEFAULT_NETWORK_ALL NetworkStats.Bucket#DEFAULT_NETWORK_ALL},
 * metered {@link android.app.usage.NetworkStats.Bucket#METERED_ALL NetworkStats.Bucket#METERED_ALL},
 * and roaming {@link android.app.usage.NetworkStats.Bucket#ROAMING_ALL NetworkStats.Bucket#ROAMING_ALL}.
 *
 * @param networkType As defined in {@link android.net.ConnectivityManager ConnectivityManager}, e.g.
 *            {@link android.net.ConnectivityManager#TYPE_MOBILE ConnectivityManager#TYPE_MOBILE}, {@link android.net.ConnectivityManager#TYPE_WIFI ConnectivityManager#TYPE_WIFI}
 *            etc.
 * @param subscriberId If applicable, the subscriber id of the network interface.
 * @param startTime Start of period. Defined in terms of "Unix time", see
 *            {@link java.lang.System#currentTimeMillis}.
 * @param endTime End of period. Defined in terms of "Unix time", see
 *            {@link java.lang.System#currentTimeMillis}.
 * @return Bucket object or null if permissions are insufficient or error happened during
 *         statistics collection.
 * @apiSince 23
 */

public android.app.usage.NetworkStats.Bucket querySummaryForDevice(int networkType, java.lang.String subscriberId, long startTime, long endTime) throws android.os.RemoteException, java.lang.SecurityException { throw new RuntimeException("Stub!"); }

/**
 * Query network usage statistics summaries. Result is summarised data usage for all uids
 * belonging to calling user. Result is a single Bucket aggregated over time, state and uid.
 * This means the bucket's start and end timestamp are going to be the same as the 'startTime'
 * and 'endTime' parameters. State is going to be {@link android.app.usage.NetworkStats.Bucket#STATE_ALL NetworkStats.Bucket#STATE_ALL},
 * uid {@link android.app.usage.NetworkStats.Bucket#UID_ALL NetworkStats.Bucket#UID_ALL}, tag {@link android.app.usage.NetworkStats.Bucket#TAG_NONE NetworkStats.Bucket#TAG_NONE},
 * metered {@link android.app.usage.NetworkStats.Bucket#METERED_ALL NetworkStats.Bucket#METERED_ALL}, and roaming
 * {@link android.app.usage.NetworkStats.Bucket#ROAMING_ALL NetworkStats.Bucket#ROAMING_ALL}.
 *
 * @param networkType As defined in {@link android.net.ConnectivityManager ConnectivityManager}, e.g.
 *            {@link android.net.ConnectivityManager#TYPE_MOBILE ConnectivityManager#TYPE_MOBILE}, {@link android.net.ConnectivityManager#TYPE_WIFI ConnectivityManager#TYPE_WIFI}
 *            etc.
 * @param subscriberId If applicable, the subscriber id of the network interface.
 * @param startTime Start of period. Defined in terms of "Unix time", see
 *            {@link java.lang.System#currentTimeMillis}.
 * @param endTime End of period. Defined in terms of "Unix time", see
 *            {@link java.lang.System#currentTimeMillis}.
 * @return Bucket object or null if permissions are insufficient or error happened during
 *         statistics collection.
 * @apiSince 23
 */

public android.app.usage.NetworkStats.Bucket querySummaryForUser(int networkType, java.lang.String subscriberId, long startTime, long endTime) throws android.os.RemoteException, java.lang.SecurityException { throw new RuntimeException("Stub!"); }

/**
 * Query network usage statistics summaries. Result filtered to include only uids belonging to
 * calling user. Result is aggregated over time, hence all buckets will have the same start and
 * end timestamps. Not aggregated over state, uid, default network, metered, or roaming. This
 * means buckets' start and end timestamps are going to be the same as the 'startTime' and
 * 'endTime' parameters. State, uid, metered, and roaming are going to vary, and tag is going to
 * be the same.
 *
 * @param networkType As defined in {@link android.net.ConnectivityManager ConnectivityManager}, e.g.
 *            {@link android.net.ConnectivityManager#TYPE_MOBILE ConnectivityManager#TYPE_MOBILE}, {@link android.net.ConnectivityManager#TYPE_WIFI ConnectivityManager#TYPE_WIFI}
 *            etc.
 * @param subscriberId If applicable, the subscriber id of the network interface.
 * @param startTime Start of period. Defined in terms of "Unix time", see
 *            {@link java.lang.System#currentTimeMillis}.
 * @param endTime End of period. Defined in terms of "Unix time", see
 *            {@link java.lang.System#currentTimeMillis}.
 * @return Statistics object or null if permissions are insufficient or error happened during
 *         statistics collection.
 * @apiSince 23
 */

public android.app.usage.NetworkStats querySummary(int networkType, java.lang.String subscriberId, long startTime, long endTime) throws android.os.RemoteException, java.lang.SecurityException { throw new RuntimeException("Stub!"); }

/**
 * Query network usage statistics details for a given uid.
 *
 * #see queryDetailsForUidTagState(int, String, long, long, int, int, int)
 * @apiSince 23
 */

public android.app.usage.NetworkStats queryDetailsForUid(int networkType, java.lang.String subscriberId, long startTime, long endTime, int uid) throws java.lang.SecurityException { throw new RuntimeException("Stub!"); }

/**
 * Query network usage statistics details for a given uid and tag.
 *
 * #see queryDetailsForUidTagState(int, String, long, long, int, int, int)
 * @apiSince 24
 */

public android.app.usage.NetworkStats queryDetailsForUidTag(int networkType, java.lang.String subscriberId, long startTime, long endTime, int uid, int tag) throws java.lang.SecurityException { throw new RuntimeException("Stub!"); }

/**
 * Query network usage statistics details for a given uid, tag, and state. Only usable for uids
 * belonging to calling user. Result is not aggregated over time. This means buckets' start and
 * end timestamps are going to be between 'startTime' and 'endTime' parameters. The uid is going
 * to be the same as the 'uid' parameter, the tag the same as the 'tag' parameter, and the state
 * the same as the 'state' parameter.
 * defaultNetwork is going to be {@link android.app.usage.NetworkStats.Bucket#DEFAULT_NETWORK_ALL NetworkStats.Bucket#DEFAULT_NETWORK_ALL},
 * metered is going to be {@link android.app.usage.NetworkStats.Bucket#METERED_ALL NetworkStats.Bucket#METERED_ALL}, and
 * roaming is going to be {@link android.app.usage.NetworkStats.Bucket#ROAMING_ALL NetworkStats.Bucket#ROAMING_ALL}.
 * <p>Only includes buckets that atomically occur in the inclusive time range. Doesn't
 * interpolate across partial buckets. Since bucket length is in the order of hours, this
 * method cannot be used to measure data usage on a fine grained time scale.
 *
 * @param networkType As defined in {@link android.net.ConnectivityManager ConnectivityManager}, e.g.
 *            {@link android.net.ConnectivityManager#TYPE_MOBILE ConnectivityManager#TYPE_MOBILE}, {@link android.net.ConnectivityManager#TYPE_WIFI ConnectivityManager#TYPE_WIFI}
 *            etc.
 * @param subscriberId If applicable, the subscriber id of the network interface.
 * @param startTime Start of period. Defined in terms of "Unix time", see
 *            {@link java.lang.System#currentTimeMillis}.
 * @param endTime End of period. Defined in terms of "Unix time", see
 *            {@link java.lang.System#currentTimeMillis}.
 * @param uid UID of app
 * @param tag TAG of interest. Use {@link android.app.usage.NetworkStats.Bucket#TAG_NONE NetworkStats.Bucket#TAG_NONE} for no tags.
 * @param state state of interest. Use {@link android.app.usage.NetworkStats.Bucket#STATE_ALL NetworkStats.Bucket#STATE_ALL} to aggregate
 *            traffic from all states.
 * @return Statistics object or null if an error happened during statistics collection.
 * @throws java.lang.SecurityException if permissions are insufficient to read network statistics.
 * @apiSince 28
 */

public android.app.usage.NetworkStats queryDetailsForUidTagState(int networkType, java.lang.String subscriberId, long startTime, long endTime, int uid, int tag, int state) throws java.lang.SecurityException { throw new RuntimeException("Stub!"); }

/**
 * Query network usage statistics details. Result filtered to include only uids belonging to
 * calling user. Result is aggregated over state but not aggregated over time, uid, tag,
 * metered, nor roaming. This means buckets' start and end timestamps are going to be between
 * 'startTime' and 'endTime' parameters. State is going to be
 * {@link android.app.usage.NetworkStats.Bucket#STATE_ALL NetworkStats.Bucket#STATE_ALL}, uid will vary,
 * tag {@link android.app.usage.NetworkStats.Bucket#TAG_NONE NetworkStats.Bucket#TAG_NONE},
 * default network is going to be {@link android.app.usage.NetworkStats.Bucket#DEFAULT_NETWORK_ALL NetworkStats.Bucket#DEFAULT_NETWORK_ALL},
 * metered is going to be {@link android.app.usage.NetworkStats.Bucket#METERED_ALL NetworkStats.Bucket#METERED_ALL},
 * and roaming is going to be {@link android.app.usage.NetworkStats.Bucket#ROAMING_ALL NetworkStats.Bucket#ROAMING_ALL}.
 * <p>Only includes buckets that atomically occur in the inclusive time range. Doesn't
 * interpolate across partial buckets. Since bucket length is in the order of hours, this
 * method cannot be used to measure data usage on a fine grained time scale.
 *
 * @param networkType As defined in {@link android.net.ConnectivityManager ConnectivityManager}, e.g.
 *            {@link android.net.ConnectivityManager#TYPE_MOBILE ConnectivityManager#TYPE_MOBILE}, {@link android.net.ConnectivityManager#TYPE_WIFI ConnectivityManager#TYPE_WIFI}
 *            etc.
 * @param subscriberId If applicable, the subscriber id of the network interface.
 * @param startTime Start of period. Defined in terms of "Unix time", see
 *            {@link java.lang.System#currentTimeMillis}.
 * @param endTime End of period. Defined in terms of "Unix time", see
 *            {@link java.lang.System#currentTimeMillis}.
 * @return Statistics object or null if permissions are insufficient or error happened during
 *         statistics collection.
 * @apiSince 23
 */

public android.app.usage.NetworkStats queryDetails(int networkType, java.lang.String subscriberId, long startTime, long endTime) throws android.os.RemoteException, java.lang.SecurityException { throw new RuntimeException("Stub!"); }

/**
 * Registers to receive notifications about data usage on specified networks.
 *
 * #see registerUsageCallback(int, String[], long, UsageCallback, Handler)
 * @apiSince 24
 */

public void registerUsageCallback(int networkType, java.lang.String subscriberId, long thresholdBytes, android.app.usage.NetworkStatsManager.UsageCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Registers to receive notifications about data usage on specified networks.
 *
 * <p>The callbacks will continue to be called as long as the process is live or
 * {@link #unregisterUsageCallback} is called.
 *
 * @param networkType Type of network to monitor. Either
            {@link android.net.ConnectivityManager#TYPE_MOBILE ConnectivityManager#TYPE_MOBILE} or {@link android.net.ConnectivityManager#TYPE_WIFI ConnectivityManager#TYPE_WIFI}.
 * @param subscriberId If applicable, the subscriber id of the network interface.
 * @param thresholdBytes Threshold in bytes to be notified on.
 * @param callback The {@link android.app.usage.NetworkStatsManager.UsageCallback UsageCallback} that the system will call when data usage
 *            has exceeded the specified threshold.
 * @param handler to dispatch callback events through, otherwise if {@code null} it uses
 *            the calling thread.
 
 * This value may be {@code null}.
 * @apiSince 24
 */

public void registerUsageCallback(int networkType, java.lang.String subscriberId, long thresholdBytes, android.app.usage.NetworkStatsManager.UsageCallback callback, @androidx.annotation.Nullable android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters callbacks on data usage.
 *
 * @param callback The {@link android.app.usage.NetworkStatsManager.UsageCallback UsageCallback} used when registering.
 * @apiSince 24
 */

public void unregisterUsageCallback(android.app.usage.NetworkStatsManager.UsageCallback callback) { throw new RuntimeException("Stub!"); }
/**
 * Base class for usage callbacks. Should be extended by applications wanting notifications.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class UsageCallback {

public UsageCallback() { throw new RuntimeException("Stub!"); }

/**
 * Called when data usage has reached the given threshold.
 * @apiSince 24
 */

public abstract void onThresholdReached(int networkType, java.lang.String subscriberId);
}

}

