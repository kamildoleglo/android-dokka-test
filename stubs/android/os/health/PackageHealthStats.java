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


/**
 * Keys for {@link android.os.health.HealthStats HealthStats} returned from
 * {@link android.os.health.HealthStats#getStats(int) HealthStats#getStats(int)} with the
 * {@link android.os.health.UidHealthStats#STATS_PACKAGES UidHealthStats#STATS_PACKAGES} key.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class PackageHealthStats {

private PackageHealthStats() { throw new RuntimeException("Stub!"); }

/**
 * Key for a map of the number of times that a package's wakeup alarms have fired
 * while the device was on battery.
 *
 * @see android.app.AlarmManager
 * @apiSince 24
 */

public static final int MEASUREMENTS_WAKEUP_ALARMS_COUNT = 40002; // 0x9c42

/**
 * Key for a HealthStats with {@link android.os.health.ServiceHealthStats ServiceHealthStats} keys for each of the
 * services defined in this apk.
 * @apiSince 24
 */

public static final int STATS_SERVICES = 40001; // 0x9c41
}

