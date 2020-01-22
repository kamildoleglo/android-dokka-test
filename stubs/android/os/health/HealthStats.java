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
 * A HealthStats object contains system health data about an application.
 *
 * <p>
 * <b>Data Types</b><br>
 * Each of the keys references data in one of five data types:
 *
 * <p>
 * A <b>measurement</b> metric contains a sinlge {@code long} value. That value may
 * be a count, a time, or some other type of value. The unit for a measurement
 * (COUNT, MS, etc) will always be in the name of the constant for the key to
 * retrieve it. For example, the
 * {@link android.os.health.UidHealthStats#MEASUREMENT_WIFI_TX_MS UidHealthStats.MEASUREMENT_WIFI_TX_MS}
 * value is the number of milliseconds (ms) that were spent transmitting on wifi by an
 * application.  The
 * {@link android.os.health.UidHealthStats#MEASUREMENT_MOBILE_RX_PACKETS UidHealthStats.MEASUREMENT_MOBILE_RX_PACKETS}
 * measurement is the number of packets received on behalf of an application.
 * The {@link android.os.health.UidHealthStats#MEASUREMENT_TOUCH_USER_ACTIVITY_COUNT
 *     UidHealthStats.MEASUREMENT_TOUCH_USER_ACTIVITY_COUNT}
 * measurement is the number of times the user touched the screen, causing the
 * screen to stay awake.
 *
 *
 * <p>
 * A <b>timer</b> metric contains an {@code int} count and a {@code long} time,
 * measured in milliseconds. Timers track how many times a resource was used, and
 * the total duration for that usage. For example, the
 * {@link android.os.health.UidHealthStats#TIMER_FLASHLIGHT}
 * timer tracks how many times the application turned on the flashlight, and for
 * how many milliseconds total it kept it on.
 *
 * <p>
 * A <b>measurement map</b> metric is a mapping of {@link java.lang.String} names to
 * {@link java.lang.Long} values.  The names typically are application provided names. For
 * example, the
 * {@link android.os.health.PackageHealthStats#MEASUREMENTS_WAKEUP_ALARMS_COUNT
 *         PackageHealthStats.MEASUREMENTS_WAKEUP_ALARMS_COUNT}
 * measurement map is a mapping of the tag provided to the
 * {@link android.app.AlarmManager} when the alarm is scheduled.
 *
 * <p>
 * A <b>timer map</b> metric is a mapping of {@link java.lang.String} names to
 * {@link android.os.health.TimerStat} objects. The names are typically application
 * provided names.  For example, the
 * {@link android.os.health.UidHealthStats#TIMERS_WAKELOCKS_PARTIAL UidHealthStats.TIMERS_WAKELOCKS_PARTIAL}
 * is a mapping of tag provided to the {@link android.os.PowerManager} when the
 * wakelock is created to the number of times and for how long each wakelock was
 * active.
 *
 * <p>
 * Lastly, a <b>health stats</b> metric is a mapping of {@link java.lang.String}
 * names to a recursive {@link android.os.health.HealthStats} object containing
 * more detailed information. For example, the
 * {@link android.os.health.UidHealthStats#STATS_PACKAGES UidHealthStats.STATS_PACKAGES}
 * metric is a mapping of the package names for each of the APKs sharing a uid to
 * the information recorded for that apk.  The returned HealthStats objects will
 * each be associated with a different set of constants.  For the HealthStats
 * returned for UidHealthStats.STATS_PACKAGES, the keys come from the
 * {@link android.os.health.PackageHealthStats}  class.
 *
 * <p>
 * The keys that are available are subject to change, depending on what a particular
 * device or software version is capable of recording. Applications must handle the absence of
 * data without crashing.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class HealthStats {

HealthStats() { throw new RuntimeException("Stub!"); }

/**
 * Get a name representing the contents of this object.
 *
 * @see android.os.health.UidHealthStats
 * @see android.os.health.PackageHealthStats
 * @see android.os.health.PidHealthStats
 * @see android.os.health.ProcessHealthStats
 * @see android.os.health.ServiceHealthStats
 * @apiSince 24
 */

public java.lang.String getDataType() { throw new RuntimeException("Stub!"); }

/**
 * Return whether this object contains a TimerStat for the supplied key.
 * @apiSince 24
 */

public boolean hasTimer(int key) { throw new RuntimeException("Stub!"); }

/**
 * Return a TimerStat object for the given key.
 *
 * This will allocate a new {@link android.os.health.TimerStat TimerStat} object, which may be wasteful. Instead, use
 * {@link #getTimerCount} and {@link #getTimerTime}.
 *
 * @throws java.lang.IndexOutOfBoundsException When the key is not present in this object.
 * @see #hasTimer hasTimer(int) To check if a value for the given key is present.
 * @apiSince 24
 */

public android.os.health.TimerStat getTimer(int key) { throw new RuntimeException("Stub!"); }

/**
 * Get the count for the timer for the given key.
 *
 * @throws java.lang.IndexOutOfBoundsException When the key is not present in this object.
 * @see #hasTimer hasTimer(int) To check if a value for the given key is present.
 * @apiSince 24
 */

public int getTimerCount(int key) { throw new RuntimeException("Stub!"); }

/**
 * Get the time for the timer for the given key, in milliseconds.
 *
 * @throws java.lang.IndexOutOfBoundsException When the key is not present in this object.
 * @see #hasTimer hasTimer(int) To check if a value for the given key is present.
 * @apiSince 24
 */

public long getTimerTime(int key) { throw new RuntimeException("Stub!"); }

/**
 * Get the number of timer values in this object. Can be used to iterate through
 * the available timers.
 *
 * @see #getTimerKeyAt
 * @apiSince 24
 */

public int getTimerKeyCount() { throw new RuntimeException("Stub!"); }

/**
 * Get the key for the timer at the given index.  Index must be between 0 and the result
 * of {@link #getTimerKeyCount getTimerKeyCount()}.
 *
 * @see #getTimerKeyCount
 * @apiSince 24
 */

public int getTimerKeyAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Return whether this object contains a measurement for the supplied key.
 * @apiSince 24
 */

public boolean hasMeasurement(int key) { throw new RuntimeException("Stub!"); }

/**
 * Get the measurement for the given key.
 *
 * @throws java.lang.IndexOutOfBoundsException When the key is not present in this object.
 * @see #hasMeasurement hasMeasurement(int) To check if a value for the given key is present.
 * @apiSince 24
 */

public long getMeasurement(int key) { throw new RuntimeException("Stub!"); }

/**
 * Get the number of measurement values in this object. Can be used to iterate through
 * the available measurements.
 *
 * @see #getMeasurementKeyAt
 * @apiSince 24
 */

public int getMeasurementKeyCount() { throw new RuntimeException("Stub!"); }

/**
 * Get the key for the measurement at the given index.  Index must be between 0 and the result
 * of {@link #getMeasurementKeyCount getMeasurementKeyCount()}.
 *
 * @see #getMeasurementKeyCount
 * @apiSince 24
 */

public int getMeasurementKeyAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Return whether this object contains a HealthStats map for the supplied key.
 * @apiSince 24
 */

public boolean hasStats(int key) { throw new RuntimeException("Stub!"); }

/**
 * Get the HealthStats map for the given key.
 *
 * @throws java.lang.IndexOutOfBoundsException When the key is not present in this object.
 * @see #hasStats hasStats(int) To check if a value for the given key is present.
 * @apiSince 24
 */

public java.util.Map<java.lang.String,android.os.health.HealthStats> getStats(int key) { throw new RuntimeException("Stub!"); }

/**
 * Get the number of HealthStat map values in this object. Can be used to iterate through
 * the available measurements.
 *
 * @see #getMeasurementKeyAt
 * @apiSince 24
 */

public int getStatsKeyCount() { throw new RuntimeException("Stub!"); }

/**
 * Get the key for the timer at the given index.  Index must be between 0 and the result
 * of {@link #getStatsKeyCount getStatsKeyCount()}.
 *
 * @see #getStatsKeyCount
 * @apiSince 24
 */

public int getStatsKeyAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Return whether this object contains a timers map for the supplied key.
 * @apiSince 24
 */

public boolean hasTimers(int key) { throw new RuntimeException("Stub!"); }

/**
 * Get the TimerStat map for the given key.
 *
 * @throws java.lang.IndexOutOfBoundsException When the key is not present in this object.
 * @see #hasTimers hasTimers(int) To check if a value for the given key is present.
 * @apiSince 24
 */

public java.util.Map<java.lang.String,android.os.health.TimerStat> getTimers(int key) { throw new RuntimeException("Stub!"); }

/**
 * Get the number of timer map values in this object. Can be used to iterate through
 * the available timer maps.
 *
 * @see #getTimersKeyAt
 * @apiSince 24
 */

public int getTimersKeyCount() { throw new RuntimeException("Stub!"); }

/**
 * Get the key for the timer map at the given index.  Index must be between 0 and the result
 * of {@link #getTimersKeyCount getTimersKeyCount()}.
 *
 * @see #getTimersKeyCount
 * @apiSince 24
 */

public int getTimersKeyAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Return whether this object contains a measurements map for the supplied key.
 * @apiSince 24
 */

public boolean hasMeasurements(int key) { throw new RuntimeException("Stub!"); }

/**
 * Get the measurements map for the given key.
 *
 * @throws java.lang.IndexOutOfBoundsException When the key is not present in this object.
 * @see #hasMeasurements To check if a value for the given key is present.
 * @apiSince 24
 */

public java.util.Map<java.lang.String,java.lang.Long> getMeasurements(int key) { throw new RuntimeException("Stub!"); }

/**
 * Get the number of measurement map values in this object. Can be used to iterate through
 * the available measurement maps.
 *
 * @see #getMeasurementsKeyAt
 * @apiSince 24
 */

public int getMeasurementsKeyCount() { throw new RuntimeException("Stub!"); }

/**
 * Get the key for the measurement map at the given index.
 * Index must be between 0 and the result
 * of {@link #getMeasurementsKeyCount getMeasurementsKeyCount()}.
 *
 * @see #getMeasurementsKeyCount
 * @apiSince 24
 */

public int getMeasurementsKeyAt(int index) { throw new RuntimeException("Stub!"); }
}

