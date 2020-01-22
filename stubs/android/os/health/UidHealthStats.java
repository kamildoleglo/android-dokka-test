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
 * {@link android.os.health.SystemHealthManager#takeUidSnapshot(int) SystemHealthManager#takeUidSnapshot(int)},
 * {@link android.os.health.SystemHealthManager#takeMyUidSnapshot() SystemHealthManager#takeMyUidSnapshot()}, and
 * {@link android.os.health.SystemHealthManager#takeUidSnapshots(int[]) SystemHealthManager#takeUidSnapshots(int[])}.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class UidHealthStats {

private UidHealthStats() { throw new RuntimeException("Stub!"); }

/**
 * Key for a measurement of number of millseconds the bluetooth controller was
 * idle but turned on on behalf of this uid.
 * @apiSince 24
 */

public static final int MEASUREMENT_BLUETOOTH_IDLE_MS = 10020; // 0x2724

/**
 * Key for a measurement of the estimated number of mA*ms used by this uid
 * for bluetooth, that is to say the number of milliseconds of activity
 * times the mA current during that period.
 * @apiSince 24
 */

public static final int MEASUREMENT_BLUETOOTH_POWER_MAMS = 10023; // 0x2727

/**
 * Key for a measurement of number of bytes received for this uid by the bluetooth radio.
 * @apiSince 24
 */

public static final int MEASUREMENT_BLUETOOTH_RX_BYTES = 10052; // 0x2744

/**
 * Key for a measurement of number of millseconds the bluetooth transmitter was
 * receiving data for this uid.
 * @apiSince 24
 */

public static final int MEASUREMENT_BLUETOOTH_RX_MS = 10021; // 0x2725

/**
 * Key for a measurement of number of packets received for this uid by the bluetooth radio.
 * @apiSince 24
 */

public static final int MEASUREMENT_BLUETOOTH_RX_PACKETS = 10058; // 0x274a

/**
 * Key for a measurement of number of bytes transmitted for this uid by the bluetooth radio.
 * @apiSince 24
 */

public static final int MEASUREMENT_BLUETOOTH_TX_BYTES = 10053; // 0x2745

/**
 * Key for a measurement of number of millseconds the bluetooth transmitter was
 * transmitting data for this uid.
 * @apiSince 24
 */

public static final int MEASUREMENT_BLUETOOTH_TX_MS = 10022; // 0x2726

/**
 * Key for a measurement of number of packets transmitted for this uid by the bluetooth radio.
 * @apiSince 24
 */

public static final int MEASUREMENT_BLUETOOTH_TX_PACKETS = 10059; // 0x274b

/**
 * Key for a measurement of number of user activity events due to physical button presses caused
 * by the UID.  Calls to userActivity() reset the user activity countdown timer and
 * keep the screen on for the user's preferred screen-on setting.
 * @apiSince 24
 */

public static final int MEASUREMENT_BUTTON_USER_ACTIVITY_COUNT = 10046; // 0x273e

/**
 * An estimate of the number of milliamp-microsends used by this uid.
 *
 * @deprecated this measurement is vendor-dependent and not reliable.
 * @apiSince 24
 * @deprecatedSince 26
 */

@Deprecated public static final int MEASUREMENT_CPU_POWER_MAMS = 10064; // 0x2750

/**
 * Key for a measurement of number of millseconds the mobile radio controller was
 * idle but turned on on behalf of this uid.
 * @apiSince 24
 */

public static final int MEASUREMENT_MOBILE_IDLE_MS = 10024; // 0x2728

/**
 * Key for a measurement of the estimated number of mA*ms used by this uid
 * for mobile data, that is to say the number of milliseconds of activity
 * times the mA current during that period.
 * @apiSince 24
 */

public static final int MEASUREMENT_MOBILE_POWER_MAMS = 10027; // 0x272b

/**
 * Key for a measurement of number of bytes received for this uid by the mobile radio.
 * @apiSince 24
 */

public static final int MEASUREMENT_MOBILE_RX_BYTES = 10048; // 0x2740

/**
 * Key for a measurement of number of millseconds the mobile radio transmitter was
 * receiving data for this uid.
 * @apiSince 24
 */

public static final int MEASUREMENT_MOBILE_RX_MS = 10025; // 0x2729

/**
 * Key for a measurement of number of packets received for this uid by the mobile radio.
 * @apiSince 24
 */

public static final int MEASUREMENT_MOBILE_RX_PACKETS = 10054; // 0x2746

/**
 * Key for a measurement of number of bytes transmitted for this uid by the mobile radio.
 * @apiSince 24
 */

public static final int MEASUREMENT_MOBILE_TX_BYTES = 10049; // 0x2741

/**
 * Key for a measurement of number of millseconds the mobile radio transmitter was
 * transmitting data for this uid.
 * @apiSince 24
 */

public static final int MEASUREMENT_MOBILE_TX_MS = 10026; // 0x272a

/**
 * Key for a measurement of number of packets transmitted for this uid by the mobile radio.
 * @apiSince 24
 */

public static final int MEASUREMENT_MOBILE_TX_PACKETS = 10055; // 0x2747

/**
 * Key for a measurement of number of software-generated user activity events caused
 * by the UID.  Calls to userActivity() reset the user activity countdown timer and
 * keep the screen on for the user's preferred screen-on setting.
 * @apiSince 24
 */

public static final int MEASUREMENT_OTHER_USER_ACTIVITY_COUNT = 10045; // 0x273d

/**
 * How many milliseconds this statistics report covers in wall-clock time while the
 * device was on battery including both screen-on and screen-off time.
 * @apiSince 24
 */

public static final int MEASUREMENT_REALTIME_BATTERY_MS = 10001; // 0x2711

/**
 * How many milliseconds this statistics report covers in wall-clock time while the
 * device was on battery including both screen-on and screen-off time.
 * @apiSince 24
 */

public static final int MEASUREMENT_REALTIME_SCREEN_OFF_BATTERY_MS = 10003; // 0x2713

/**
 * Key for a measurement of the number of milliseconds spent by the CPU running kernel
 * code for this uid.
 * @apiSince 24
 */

public static final int MEASUREMENT_SYSTEM_CPU_TIME_MS = 10063; // 0x274f

/**
 * Key for a measurement of number of user activity events due to touch events caused
 * by the UID.  Calls to userActivity() reset the user activity countdown timer and
 * keep the screen on for the user's preferred screen-on setting.
 * @apiSince 24
 */

public static final int MEASUREMENT_TOUCH_USER_ACTIVITY_COUNT = 10047; // 0x273f

/**
 * How many milliseconds this statistics report covers that the CPU was running while the
 * device was on battery including both screen-on and screen-off time.
 * @apiSince 24
 */

public static final int MEASUREMENT_UPTIME_BATTERY_MS = 10002; // 0x2712

/**
 * How many milliseconds this statistics report covers that the CPU was running while the
 * device was on battery including both screen-on and screen-off time.
 * @apiSince 24
 */

public static final int MEASUREMENT_UPTIME_SCREEN_OFF_BATTERY_MS = 10004; // 0x2714

/**
 * Key for a measurement of the number of milliseconds spent by the CPU running user space
 * code for this uid.
 * @apiSince 24
 */

public static final int MEASUREMENT_USER_CPU_TIME_MS = 10062; // 0x274e

/**
 * Key for a measurement of number of millseconds that this uid held a full wifi lock.
 * @apiSince 24
 */

public static final int MEASUREMENT_WIFI_FULL_LOCK_MS = 10029; // 0x272d

/**
 * Key for a measurement of number of millseconds the wifi controller was
 * idle but turned on on behalf of this uid.
 * @apiSince 24
 */

public static final int MEASUREMENT_WIFI_IDLE_MS = 10016; // 0x2720

/**
 * Key for a measurement of number of millseconds that this uid was performing
 * multicast wifi traffic.
 * @apiSince 24
 */

public static final int MEASUREMENT_WIFI_MULTICAST_MS = 10031; // 0x272f

/**
 * Key for a measurement of the estimated number of mA*ms used by this uid
 * for wifi, that is to say the number of milliseconds of wifi activity
 * times the mA current during that period.
 * @apiSince 24
 */

public static final int MEASUREMENT_WIFI_POWER_MAMS = 10019; // 0x2723

/**
 * Key for a measurement of number of millseconds the wifi controller was
 * active on behalf of this uid.
 * @apiSince 24
 */

public static final int MEASUREMENT_WIFI_RUNNING_MS = 10028; // 0x272c

/**
 * Key for a measurement of number of bytes received for this uid by the wifi radio.
 * @apiSince 24
 */

public static final int MEASUREMENT_WIFI_RX_BYTES = 10050; // 0x2742

/**
 * Key for a measurement of number of millseconds the wifi transmitter was
 * receiving data for this uid.
 * @apiSince 24
 */

public static final int MEASUREMENT_WIFI_RX_MS = 10017; // 0x2721

/**
 * Key for a measurement of number of packets received for this uid by the wifi radio.
 * @apiSince 24
 */

public static final int MEASUREMENT_WIFI_RX_PACKETS = 10056; // 0x2748

/**
 * Key for a measurement of number of bytes transmitted for this uid by the wifi radio.
 * @apiSince 24
 */

public static final int MEASUREMENT_WIFI_TX_BYTES = 10051; // 0x2743

/**
 * Key for a measurement of number of millseconds the wifi transmitter was
 * transmitting data for this uid.
 * @apiSince 24
 */

public static final int MEASUREMENT_WIFI_TX_MS = 10018; // 0x2722

/**
 * Key for a measurement of number of packets transmitted for this uid by the wifi radio.
 * @apiSince 24
 */

public static final int MEASUREMENT_WIFI_TX_PACKETS = 10057; // 0x2749

/**
 * Key for a HealthStats with {@link android.os.health.PackageHealthStats PackageHealthStats} keys for each of the
 * APKs that share this uid.
 * @apiSince 24
 */

public static final int STATS_PACKAGES = 10015; // 0x271f

/**
 * Key for a HealthStats with {@link android.os.health.PidHealthStats PidHealthStats} keys for each of the
 * currently running processes for this uid.
 * @apiSince 24
 */

public static final int STATS_PIDS = 10013; // 0x271d

/**
 * Key for a HealthStats with {@link android.os.health.ProcessHealthStats ProcessHealthStats} keys for each of the
 * named processes for this uid.
 * @apiSince 24
 */

public static final int STATS_PROCESSES = 10014; // 0x271e

/**
 * Key for a map of Timers for the {@link android.app.job.JobScheduler} jobs for
 * this uid.
 * @apiSince 24
 */

public static final int TIMERS_JOBS = 10010; // 0x271a

/**
 * Key for a map of the sensor usage for this uid. The keys are a
 * string representation of the handle for the sensor.
 * @apiSince 24
 */

public static final int TIMERS_SENSORS = 10012; // 0x271c

/**
 * Key for a map of Timers for the sync adapter syncs that were done for
 * this uid.
 * @apiSince 24
 */

public static final int TIMERS_SYNCS = 10009; // 0x2719

/**
 * Key for a TimerStat for the times a system-defined wakelock was acquired
 * to allow the application to draw when it otherwise would not be able to
 * (e.g.&nbsp;on the lock screen or doze screen).
 * @apiSince 24
 */

public static final int TIMERS_WAKELOCKS_DRAW = 10008; // 0x2718

/**
 * Key for a TimerStat for the times a
 * {@link android.os.PowerManager#FULL_WAKE_LOCK full wake lock}
 * was acquired for this uid.
 * @apiSince 24
 */

public static final int TIMERS_WAKELOCKS_FULL = 10005; // 0x2715

/**
 * Key for a TimerStat for the times a
 * {@link android.os.PowerManager#PARTIAL_WAKE_LOCK full wake lock}
 * was acquired for this uid.
 * @apiSince 24
 */

public static final int TIMERS_WAKELOCKS_PARTIAL = 10006; // 0x2716

/** @apiSince 24 */

public static final int TIMERS_WAKELOCKS_WINDOW = 10007; // 0x2717

/**
 * Key for a timer for the count and duration of audio playback done by this uid.
 * @apiSince 24
 */

public static final int TIMER_AUDIO = 10032; // 0x2730

/**
 * Key for a timer for the count and duration of when this uid was doing bluetooth scans.
 * @apiSince 24
 */

public static final int TIMER_BLUETOOTH_SCAN = 10037; // 0x2735

/**
 * Key for a timer for the count and duration this uid had the camera turned on.
 * @apiSince 24
 */

public static final int TIMER_CAMERA = 10035; // 0x2733

/**
 * Key for a timer for the count and duration this uid had the flashlight turned on.
 * @apiSince 24
 */

public static final int TIMER_FLASHLIGHT = 10034; // 0x2732

/**
 * Key for a timer for the count and duration of when an activity from this uid
 * was the foreground activitiy.
 * @apiSince 24
 */

public static final int TIMER_FOREGROUND_ACTIVITY = 10036; // 0x2734

/**
 * Key for a timer for the applications use of the GPS sensor.
 * @apiSince 24
 */

public static final int TIMER_GPS_SENSOR = 10011; // 0x271b

/**
 * Key for a timer for the count and duration the mobile radio was turned on for this uid.
 * @apiSince 24
 */

public static final int TIMER_MOBILE_RADIO_ACTIVE = 10061; // 0x274d

/**
 * Key for a timer for the count and duration of when this uid was in the "background"
 * process state.
 * @apiSince 24
 */

public static final int TIMER_PROCESS_STATE_BACKGROUND_MS = 10042; // 0x273a

/**
 * Key for a timer for the count and duration of when this uid was in the "cached" process
 * state.
 * @apiSince 24
 */

public static final int TIMER_PROCESS_STATE_CACHED_MS = 10043; // 0x273b

/**
 * Key for a timer for the count and duration of when this uid was in the "foreground"
 * process state.
 * @apiSince 24
 */

public static final int TIMER_PROCESS_STATE_FOREGROUND_MS = 10041; // 0x2739

/**
 * Key for a timer for the count and duration of when this uid was in the "foreground service"
 * process state.
 * @apiSince 24
 */

public static final int TIMER_PROCESS_STATE_FOREGROUND_SERVICE_MS = 10039; // 0x2737

/**
 * Key for a timer for the count and duration of when this uid was in the "top" process state.
 * @apiSince 24
 */

public static final int TIMER_PROCESS_STATE_TOP_MS = 10038; // 0x2736

/**
 * Key for a timer for the count and duration of when this uid was in the "top sleeping"
 * process state.
 * @apiSince 24
 */

public static final int TIMER_PROCESS_STATE_TOP_SLEEPING_MS = 10040; // 0x2738

/**
 * Key for a timer for the count and duration this uid had the vibrator turned on.
 * @apiSince 24
 */

public static final int TIMER_VIBRATOR = 10044; // 0x273c

/**
 * Key for a timer for the count and duration of video playback done by this uid.
 * @apiSince 24
 */

public static final int TIMER_VIDEO = 10033; // 0x2731

/**
 * Key for a timer for the count and duration of wifi scans done by this uid.
 * @apiSince 24
 */

public static final int TIMER_WIFI_SCAN = 10030; // 0x272e
}

