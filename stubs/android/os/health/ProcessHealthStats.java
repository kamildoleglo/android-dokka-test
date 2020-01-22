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
 * {@link android.os.health.UidHealthStats#STATS_PROCESSES UidHealthStats#STATS_PROCESSES} key.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ProcessHealthStats {

private ProcessHealthStats() { throw new RuntimeException("Stub!"); }

/**
 * Key for a measurement of the number of ANRs that happened in this process.
 * @apiSince 24
 */

public static final int MEASUREMENT_ANR_COUNT = 30005; // 0x7535

/**
 * Key for a measurement of the number of crashes that happened in this process.
 * @apiSince 24
 */

public static final int MEASUREMENT_CRASHES_COUNT = 30004; // 0x7534

/**
 * Key for a measurement of the number of milliseconds this process spent with
 * an activity in the foreground.
 * @apiSince 24
 */

public static final int MEASUREMENT_FOREGROUND_MS = 30006; // 0x7536

/**
 * Key for a measurement of the number of times this process was started for any reason.
 * @apiSince 24
 */

public static final int MEASUREMENT_STARTS_COUNT = 30003; // 0x7533

/**
 * Key for a measurement of number of millseconds the CPU spent running in kernel space
 * for this process.
 * @apiSince 24
 */

public static final int MEASUREMENT_SYSTEM_TIME_MS = 30002; // 0x7532

/**
 * Key for a measurement of number of millseconds the CPU spent running in user space
 * for this process.
 * @apiSince 24
 */

public static final int MEASUREMENT_USER_TIME_MS = 30001; // 0x7531
}

