/*
 * Copyright (C) 2016 The Android Open Source Project
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


package android.os.health;

import android.os.Build;
import android.os.Process;

/**
 * Provides access to data about how various system resources are used by applications.
 * @more
 * <p>
 * If you are going to be using this class to log your application's resource usage,
 * please consider the amount of resources (battery, network, etc) that will be used
 * by the logging itself.  It can be substantial.
 * <p>
 * <b>Battery Usage</b><br>
 * Since Android version {@link android.os.Build.VERSION_CODES#Q}, the statistics related to power
 * (battery) usage are recorded since the device was last considered fully charged (for previous
 * versions, it is instead since the device was last unplugged).
 * It is expected that applications schedule more work to do while the device is
 * plugged in (e.g. using {@link android.app.job.JobScheduler JobScheduler}), and
 * while that can affect charging rates, it is still preferable to actually draining
 * the battery.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SystemHealthManager {

SystemHealthManager() { throw new RuntimeException("Stub!"); }

/**
 * Return a {@link android.os.health.HealthStats HealthStats} object containing a snapshot of system health
 * metrics for the given uid (user-id, which in usually corresponds to application).
 * @more
 *
 * An application must hold the {@link android.Manifest.permission#BATTERY_STATS
 * android.permission.BATTERY_STATS} permission in order to retrieve any HealthStats
 * other than its own.
 *
 * @param uid User ID for a given application.
 * @return A {@link android.os.health.HealthStats HealthStats} object containing the metrics for the requested
 * application. The keys for this HealthStats object will be from the {@link android.os.health.UidHealthStats UidHealthStats}
 * class.
 * @see android.os.Process#myUid() Process.myUid()
 * @apiSince 24
 */

public android.os.health.HealthStats takeUidSnapshot(int uid) { throw new RuntimeException("Stub!"); }

/**
 * Return a {@link android.os.health.HealthStats HealthStats} object containing a snapshot of system health
 * metrics for the application calling this API. This method is the same as calling
 * {@code takeUidSnapshot(Process.myUid())}.
 *
 * @return A {@link android.os.health.HealthStats HealthStats} object containing the metrics for this application. The keys
 * for this HealthStats object will be from the {@link android.os.health.UidHealthStats UidHealthStats} class.
 * @apiSince 24
 */

public android.os.health.HealthStats takeMyUidSnapshot() { throw new RuntimeException("Stub!"); }

/**
 * Return a {@link android.os.health.HealthStats HealthStats} object containing a snapshot of system health
 * metrics for the given uids (user-id, which in usually corresponds to application).
 * @more
 *
 * An application must hold the {@link android.Manifest.permission#BATTERY_STATS
 * android.permission.BATTERY_STATS} permission in order to retrieve any HealthStats
 * other than its own.
 *
 * @param uids An array of User IDs to retrieve.
 * @return An array of {@link android.os.health.HealthStats HealthStats} objects containing the metrics for each of
 * the requested uids. The keys for this HealthStats object will be from the
 * {@link android.os.health.UidHealthStats UidHealthStats} class.
 * @apiSince 24
 */

public android.os.health.HealthStats[] takeUidSnapshots(int[] uids) { throw new RuntimeException("Stub!"); }
}

