/**
 * Copyright (C) 2014 The Android Open Source Project
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

import java.util.Map;

/**
 * Provides access to device usage history and statistics. Usage data is aggregated into
 * time intervals: days, weeks, months, and years.
 * <p />
 * When requesting usage data since a particular time, the request might look something like this:
 * <pre>
 * PAST                   REQUEST_TIME                    TODAY                   FUTURE
 * ————————————————————————————||———————————————————————————¦-----------------------|
 *                        YEAR ||                           ¦                       |
 * ————————————————————————————||———————————————————————————¦-----------------------|
 *  MONTH            |         ||                MONTH      ¦                       |
 * ——————————————————|—————————||———————————————————————————¦-----------------------|
 *   |      WEEK     |     WEEK||    |     WEEK     |     WE¦EK     |      WEEK     |
 * ————————————————————————————||———————————————————|———————¦-----------------------|
 *                             ||           |DAY|DAY|DAY|DAY¦DAY|DAY|DAY|DAY|DAY|DAY|
 * ————————————————————————————||———————————————————————————¦-----------------------|
 * </pre>
 * A request for data in the middle of a time interval will include that interval.
 * <p/>
 * <b>NOTE:</b> Most methods on this API require the permission
 * android.permission.PACKAGE_USAGE_STATS. However, declaring the permission implies intention to
 * use the API and the user of the device still needs to grant permission through the Settings
 * application.
 * See {@link android.provider.Settings#ACTION_USAGE_ACCESS_SETTINGS}.
 * Methods which only return the information for the calling package do not require this permission.
 * E.g. {@link #getAppStandbyBucket()} and {@link #queryEventsForSelf(long,long)}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class UsageStatsManager {

UsageStatsManager() { throw new RuntimeException("Stub!"); }

/**
 * Gets application usage stats for the given time range, aggregated by the specified interval.
 *
 * <p>
 * The returned list will contain one or more {@link android.app.usage.UsageStats UsageStats} objects for each package, with
 * usage data that covers at least the given time range.
 * Note: The begin and end times of the time range may be expanded to the nearest whole interval
 * period.
 * </p>
 *
 * <p> The caller must have {@link android.Manifest.permission#PACKAGE_USAGE_STATS} </p>
 *
 * @param intervalType The time interval by which the stats are aggregated.
 * @param beginTime The inclusive beginning of the range of stats to include in the results.
 *                  Defined in terms of "Unix time", see
 *                  {@link java.lang.System#currentTimeMillis}.
 * @param endTime The exclusive end of the range of stats to include in the results. Defined
 *                in terms of "Unix time", see {@link java.lang.System#currentTimeMillis}.
 * @return A list of {@link android.app.usage.UsageStats UsageStats}
 *
 * @see #INTERVAL_DAILY
 * @see #INTERVAL_WEEKLY
 * @see #INTERVAL_MONTHLY
 * @see #INTERVAL_YEARLY
 * @see #INTERVAL_BEST
 * @apiSince 21
 */

public java.util.List<android.app.usage.UsageStats> queryUsageStats(int intervalType, long beginTime, long endTime) { throw new RuntimeException("Stub!"); }

/**
 * Gets the hardware configurations the device was in for the given time range, aggregated by
 * the specified interval. The results are ordered as in
 * {@link #queryUsageStats(int,long,long)}.
 * <p> The caller must have {@link android.Manifest.permission#PACKAGE_USAGE_STATS} </p>
 *
 * @param intervalType The time interval by which the stats are aggregated.
 * @param beginTime The inclusive beginning of the range of stats to include in the results.
 *                  Defined in terms of "Unix time", see
 *                  {@link java.lang.System#currentTimeMillis}.
 * @param endTime The exclusive end of the range of stats to include in the results. Defined
 *                in terms of "Unix time", see {@link java.lang.System#currentTimeMillis}.
 * @return A list of {@link android.app.usage.ConfigurationStats ConfigurationStats}
 * @apiSince 21
 */

public java.util.List<android.app.usage.ConfigurationStats> queryConfigurations(int intervalType, long beginTime, long endTime) { throw new RuntimeException("Stub!"); }

/**
 * Gets aggregated event stats for the given time range, aggregated by the specified interval.
 * <p>The returned list will contain a {@link android.app.usage.EventStats EventStats} object for each event type that
 * is being aggregated and has data for an interval that is a subset of the time range given.
 *
 * <p>The current event types that will be aggregated here are:</p>
 * <ul>
 *     <li>{@link android.app.usage.UsageEvents.Event#SCREEN_INTERACTIVE UsageEvents.Event#SCREEN_INTERACTIVE}</li>
 *     <li>{@link android.app.usage.UsageEvents.Event#SCREEN_NON_INTERACTIVE UsageEvents.Event#SCREEN_NON_INTERACTIVE}</li>
 *     <li>{@link android.app.usage.UsageEvents.Event#KEYGUARD_SHOWN UsageEvents.Event#KEYGUARD_SHOWN}</li>
 *     <li>{@link android.app.usage.UsageEvents.Event#KEYGUARD_HIDDEN UsageEvents.Event#KEYGUARD_HIDDEN}</li>
 * </ul>
 *
 * <p> The caller must have {@link android.Manifest.permission#PACKAGE_USAGE_STATS} </p>
 *
 * @param intervalType The time interval by which the stats are aggregated.
 * @param beginTime The inclusive beginning of the range of stats to include in the results.
 *                  Defined in terms of "Unix time", see
 *                  {@link java.lang.System#currentTimeMillis}.
 * @param endTime The exclusive end of the range of stats to include in the results. Defined
 *                in terms of "Unix time", see {@link java.lang.System#currentTimeMillis}.
 * @return A list of {@link android.app.usage.EventStats EventStats}
 *
 * @see #INTERVAL_DAILY
 * @see #INTERVAL_WEEKLY
 * @see #INTERVAL_MONTHLY
 * @see #INTERVAL_YEARLY
 * @see #INTERVAL_BEST
 * @apiSince 28
 */

public java.util.List<android.app.usage.EventStats> queryEventStats(int intervalType, long beginTime, long endTime) { throw new RuntimeException("Stub!"); }

/**
 * Query for events in the given time range. Events are only kept by the system for a few
 * days.
 * <p> The caller must have {@link android.Manifest.permission#PACKAGE_USAGE_STATS} </p>
 *
 * @param beginTime The inclusive beginning of the range of events to include in the results.
 *                 Defined in terms of "Unix time", see
 *                 {@link java.lang.System#currentTimeMillis}.
 * @param endTime The exclusive end of the range of events to include in the results. Defined
 *               in terms of "Unix time", see {@link java.lang.System#currentTimeMillis}.
 * @return A {@link android.app.usage.UsageEvents UsageEvents}.
 * @apiSince 21
 */

public android.app.usage.UsageEvents queryEvents(long beginTime, long endTime) { throw new RuntimeException("Stub!"); }

/**
 * Like {@link #queryEvents(long,long)}, but only returns events for the calling package.
 *
 * @param beginTime The inclusive beginning of the range of events to include in the results.
 *                 Defined in terms of "Unix time", see
 *                 {@link java.lang.System#currentTimeMillis}.
 * @param endTime The exclusive end of the range of events to include in the results. Defined
 *               in terms of "Unix time", see {@link java.lang.System#currentTimeMillis}.
 * @return A {@link android.app.usage.UsageEvents UsageEvents} object.
 *
 * @see #queryEvents(long, long)
 * @apiSince 28
 */

public android.app.usage.UsageEvents queryEventsForSelf(long beginTime, long endTime) { throw new RuntimeException("Stub!"); }

/**
 * A convenience method that queries for all stats in the given range (using the best interval
 * for that range), merges the resulting data, and keys it by package name.
 * See {@link #queryUsageStats(int,long,long)}.
 * <p> The caller must have {@link android.Manifest.permission#PACKAGE_USAGE_STATS} </p>
 *
 * @param beginTime The inclusive beginning of the range of stats to include in the results.
 *                  Defined in terms of "Unix time", see
 *                  {@link java.lang.System#currentTimeMillis}.
 * @param endTime The exclusive end of the range of stats to include in the results. Defined
 *                in terms of "Unix time", see {@link java.lang.System#currentTimeMillis}.
 * @return A {@link java.util.Map} keyed by package name
 * @apiSince 21
 */

public java.util.Map<java.lang.String,android.app.usage.UsageStats> queryAndAggregateUsageStats(long beginTime, long endTime) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the specified app is currently considered inactive. This will be true if the
 * app hasn't been used directly or indirectly for a period of time defined by the system. This
 * could be of the order of several hours or days.
 * @param packageName The package name of the app to query
 * @return whether the app is currently considered inactive
 * @apiSince 23
 */

public boolean isAppInactive(java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current standby bucket of the calling app. The system determines the standby
 * state of the app based on app usage patterns. Standby buckets determine how much an app will
 * be restricted from running background tasks such as jobs and alarms.
 * <p>Restrictions increase progressively from {@link #STANDBY_BUCKET_ACTIVE} to
 * {@link #STANDBY_BUCKET_RARE}, with {@link #STANDBY_BUCKET_ACTIVE} being the least
 * restrictive. The battery level of the device might also affect the restrictions.
 * <p>Apps in buckets &le; {@link #STANDBY_BUCKET_ACTIVE} have no standby restrictions imposed.
 * Apps in buckets &gt; {@link #STANDBY_BUCKET_FREQUENT} may have network access restricted when
 * running in the background.
 * <p>The standby state of an app can change at any time either due to a user interaction or a
 * system interaction or some algorithm determining that the app can be restricted for a period
 * of time before the user has a need for it.
 * <p>You can also query the recent history of standby bucket changes by calling
 * {@link #queryEventsForSelf(long,long)} and searching for
 * {@link android.app.usage.UsageEvents.Event#STANDBY_BUCKET_CHANGED UsageEvents.Event#STANDBY_BUCKET_CHANGED}.
 *
 * @return the current standby bucket of the calling app. One of STANDBY_BUCKET_* constants.
 
 * Value is android.app.usage.UsageStatsManager.STANDBY_BUCKET_EXEMPTED, {@link android.app.usage.UsageStatsManager#STANDBY_BUCKET_ACTIVE}, {@link android.app.usage.UsageStatsManager#STANDBY_BUCKET_WORKING_SET}, {@link android.app.usage.UsageStatsManager#STANDBY_BUCKET_FREQUENT}, {@link android.app.usage.UsageStatsManager#STANDBY_BUCKET_RARE}, or android.app.usage.UsageStatsManager.STANDBY_BUCKET_NEVER
 * @apiSince 28
 */

public int getAppStandbyBucket() { throw new RuntimeException("Stub!"); }

/**
 * An interval type that will use the best fit interval for the given time range.
 * See {@link #queryUsageStats(int,long,long)}.
 * @apiSince 21
 */

public static final int INTERVAL_BEST = 4; // 0x4

/**
 * An interval type that spans a day. See {@link #queryUsageStats(int,long,long)}.
 * @apiSince 21
 */

public static final int INTERVAL_DAILY = 0; // 0x0

/**
 * An interval type that spans a month. See {@link #queryUsageStats(int,long,long)}.
 * @apiSince 21
 */

public static final int INTERVAL_MONTHLY = 2; // 0x2

/**
 * An interval type that spans a week. See {@link #queryUsageStats(int,long,long)}.
 * @apiSince 21
 */

public static final int INTERVAL_WEEKLY = 1; // 0x1

/**
 * An interval type that spans a year. See {@link #queryUsageStats(int,long,long)}.
 * @apiSince 21
 */

public static final int INTERVAL_YEARLY = 3; // 0x3

/**
 * The app was used very recently, currently in use or likely to be used very soon. Standby
 * bucket values that are &le; {@link #STANDBY_BUCKET_ACTIVE} will not be throttled by the
 * system while they are in this bucket. Buckets &gt; {@link #STANDBY_BUCKET_ACTIVE} will most
 * likely be restricted in some way. For instance, jobs and alarms may be deferred.
 * @see #getAppStandbyBucket()
 * @apiSince 28
 */

public static final int STANDBY_BUCKET_ACTIVE = 10; // 0xa

/**
 * The app was used in the last few days and/or likely to be used in the next few days.
 * Restrictions will apply to these apps, such as deferral of jobs and alarms. The delays may be
 * greater than for apps in higher buckets (lower bucket value). Bucket values &gt;
 * {@link #STANDBY_BUCKET_FREQUENT} may additionally have network access limited.
 * @see #getAppStandbyBucket()
 * @apiSince 28
 */

public static final int STANDBY_BUCKET_FREQUENT = 30; // 0x1e

/**
 * The app has not be used for several days and/or is unlikely to be used for several days.
 * Apps in this bucket will have the most restrictions, including network restrictions, except
 * during certain short periods (at a minimum, once a day) when they are allowed to execute
 * jobs, access the network, etc.
 * @see #getAppStandbyBucket()
 * @apiSince 28
 */

public static final int STANDBY_BUCKET_RARE = 40; // 0x28

/**
 * The app was used recently and/or likely to be used in the next few hours. Restrictions will
 * apply to these apps, such as deferral of jobs and alarms.
 * @see #getAppStandbyBucket()
 * @apiSince 28
 */

public static final int STANDBY_BUCKET_WORKING_SET = 20; // 0x14
}

