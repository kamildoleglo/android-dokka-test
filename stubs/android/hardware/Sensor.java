/*
 * Copyright (C) 2008 The Android Open Source Project
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



package android.hardware;


/**
 * Class representing a sensor. Use {@link android.hardware.SensorManager#getSensorList SensorManager#getSensorList} to get
 * the list of available sensors. For more information about Android sensors,
 * read the
 * <a href="/guide/topics/sensors/sensors_motion.html">Motion Sensors guide</a>.</p>
 *
 * @see android.hardware.SensorManager
 * @see android.hardware.SensorEventListener
 * @see android.hardware.SensorEvent
 *
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Sensor {

Sensor() { throw new RuntimeException("Stub!"); }

/**
 * Each sensor has exactly one reporting mode associated with it. This method returns the
 * reporting mode constant for this sensor type.
 *
 * @return Reporting mode for the input sensor, one of REPORTING_MODE_* constants.
 * @see #REPORTING_MODE_CONTINUOUS
 * @see #REPORTING_MODE_ON_CHANGE
 * @see #REPORTING_MODE_ONE_SHOT
 * @see #REPORTING_MODE_SPECIAL_TRIGGER
 * @apiSince 21
 */

public int getReportingMode() { throw new RuntimeException("Stub!"); }

/**
 * Get the highest supported direct report mode rate level of the sensor.
 *
 * @return Highest direct report rate level of this sensor. If the sensor does not support
 * direct report mode, this returns {@link android.hardware.SensorDirectChannel#RATE_STOP SensorDirectChannel#RATE_STOP}.
 * Value is either <code>0</code> or a combination of {@link android.hardware.SensorDirectChannel#RATE_STOP}, {@link android.hardware.SensorDirectChannel#RATE_NORMAL}, {@link android.hardware.SensorDirectChannel#RATE_FAST}, and {@link android.hardware.SensorDirectChannel#RATE_VERY_FAST}
 * @see android.hardware.SensorDirectChannel#RATE_STOP
 * @see android.hardware.SensorDirectChannel#RATE_NORMAL
 * @see android.hardware.SensorDirectChannel#RATE_FAST
 * @see android.hardware.SensorDirectChannel#RATE_VERY_FAST
 * @apiSince 26
 */

public int getHighestDirectReportRateLevel() { throw new RuntimeException("Stub!"); }

/**
 * Test if a sensor supports a specified direct channel type.
 *
 * @param sharedMemType type of shared memory used by direct channel.
 * Value is either <code>0</code> or a combination of {@link android.hardware.SensorDirectChannel#TYPE_MEMORY_FILE}, and {@link android.hardware.SensorDirectChannel#TYPE_HARDWARE_BUFFER}
 * @return <code>true</code> if the specified shared memory type is supported.
 * @see android.hardware.SensorDirectChannel#TYPE_MEMORY_FILE
 * @see android.hardware.SensorDirectChannel#TYPE_HARDWARE_BUFFER
 * @apiSince 26
 */

public boolean isDirectChannelTypeSupported(int sharedMemType) { throw new RuntimeException("Stub!"); }

/**
 * @return name string of the sensor.
 * @apiSince 3
 */

public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * @return vendor string of this sensor.
 * @apiSince 3
 */

public java.lang.String getVendor() { throw new RuntimeException("Stub!"); }

/**
 * @return generic type of this sensor.
 * @apiSince 3
 */

public int getType() { throw new RuntimeException("Stub!"); }

/**
 * @return version of the sensor's module.
 * @apiSince 3
 */

public int getVersion() { throw new RuntimeException("Stub!"); }

/**
 * @return maximum range of the sensor in the sensor's unit.
 * @apiSince 3
 */

public float getMaximumRange() { throw new RuntimeException("Stub!"); }

/**
 * @return resolution of the sensor in the sensor's unit.
 * @apiSince 3
 */

public float getResolution() { throw new RuntimeException("Stub!"); }

/**
 * @return the power in mA used by this sensor while in use
 * @apiSince 3
 */

public float getPower() { throw new RuntimeException("Stub!"); }

/**
 * @return the minimum delay allowed between two events in microsecond
 * or zero if this sensor only returns a value when the data it's measuring
 * changes.
 * @apiSince 9
 */

public int getMinDelay() { throw new RuntimeException("Stub!"); }

/**
 * @return Number of events reserved for this sensor in the batch mode FIFO. This gives a
 * guarantee on the minimum number of events that can be batched.
 * @apiSince 19
 */

public int getFifoReservedEventCount() { throw new RuntimeException("Stub!"); }

/**
 * @return Maximum number of events of this sensor that could be batched. If this value is zero
 * it indicates that batch mode is not supported for this sensor. If other applications
 * registered to batched sensors, the actual number of events that can be batched might be
 * smaller because the hardware FiFo will be partially used to batch the other sensors.
 * @apiSince 19
 */

public int getFifoMaxEventCount() { throw new RuntimeException("Stub!"); }

/**
 * @return The type of this sensor as a string.
 * @apiSince 20
 */

public java.lang.String getStringType() { throw new RuntimeException("Stub!"); }

/**
 * @return The sensor id that will be unique for the same app unless the device is factory
 * reset. Return value of 0 means this sensor does not support this function; return value of -1
 * means this sensor can be uniquely identified in system by combination of its type and name.
 * @apiSince 24
 */

public int getId() { throw new RuntimeException("Stub!"); }

/**
 * This value is defined only for continuous and on-change sensors. It is the delay between two
 * sensor events corresponding to the lowest frequency that this sensor supports. When lower
 * frequencies are requested through registerListener() the events will be generated at this
 * frequency instead. It can be used to estimate when the batch FIFO may be full. Older devices
 * may set this value to zero. Ignore this value in case it is negative or zero.
 *
 * @return The max delay for this sensor in microseconds.
 * @apiSince 21
 */

public int getMaxDelay() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the sensor is a wake-up sensor.
 * <p>
 * <b>Application Processor Power modes</b> <p>
 * Application Processor(AP), is the processor on which applications run.  When no wake lock is
 * held and the user is not interacting with the device, this processor can enter a “Suspend”
 * mode, reducing the power consumption by 10 times or more.
 * </p>
 * <p>
 * <b>Non-wake-up sensors</b> <p>
 * Non-wake-up sensors are sensors that do not wake the AP out of suspend to report data. While
 * the AP is in suspend mode, the sensors continue to function and generate events, which are
 * put in a hardware FIFO. The events in the FIFO are delivered to the application when the AP
 * wakes up. If the FIFO was too small to store all events generated while the AP was in
 * suspend mode, the older events are lost: the oldest data is dropped to accommodate the newer
 * data. In the extreme case where the FIFO is non-existent {@code maxFifoEventCount() == 0},
 * all events generated while the AP was in suspend mode are lost. Applications using
 * non-wake-up sensors should usually:
 * <ul>
 * <li>Either unregister from the sensors when they do not need them, usually in the activity’s
 * {@code onPause} method. This is the most common case.
 * <li>Or realize that the sensors are consuming some power while the AP is in suspend mode and
 * that even then, some events might be lost.
 * </ul>
 * </p>
 * <p>
 * <b>Wake-up sensors</b> <p>
 * In opposition to non-wake-up sensors, wake-up sensors ensure that their data is delivered
 * independently of the state of the AP. While the AP is awake, the wake-up sensors behave
 * like non-wake-up-sensors. When the AP is asleep, wake-up sensors wake up the AP to deliver
 * events. That is, the AP will wake up and the sensor will deliver the events before the
 * maximum reporting latency is elapsed or the hardware FIFO gets full. See {@link android.hardware.SensorManager#registerListener(android.hardware.SensorEventListener,android.hardware.Sensor,int,int) SensorManager#registerListener(SensorEventListener, Sensor, int, int)} for more details.
 * </p>
 *
 * @return <code>true</code> if this is a wake-up sensor, <code>false</code> otherwise.
 * @apiSince 21
 */

public boolean isWakeUpSensor() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the sensor is a dynamic sensor.
 *
 * @return <code>true</code> if the sensor is a dynamic sensor (sensor added at runtime).
 * @see android.hardware.SensorManager.DynamicSensorCallback
 * @apiSince 24
 */

public boolean isDynamicSensor() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the sensor supports sensor additional information API
 *
 * @return <code>true</code> if the sensor supports sensor additional information API
 * @see android.hardware.SensorAdditionalInfo
 * @apiSince 24
 */

public boolean isAdditionalInfoSupported() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Events are reported at a constant rate which is set by the rate parameter of
 * {@link android.hardware.SensorManager#registerListener(android.hardware.SensorEventListener,android.hardware.Sensor,int) SensorManager#registerListener(SensorEventListener, Sensor, int)}. Note: If other
 * applications are requesting a higher rate, the sensor data might be delivered at faster rates
 * than requested.
 * @apiSince 21
 */

public static final int REPORTING_MODE_CONTINUOUS = 0; // 0x0

/**
 * Events are reported in one-shot mode. Upon detection of an event, the sensor deactivates
 * itself and then sends a single event. Sensors of this reporting mode must be registered to
 * using {@link android.hardware.SensorManager#requestTriggerSensor(android.hardware.TriggerEventListener,android.hardware.Sensor) SensorManager#requestTriggerSensor(TriggerEventListener, Sensor)}.
 * @apiSince 21
 */

public static final int REPORTING_MODE_ONE_SHOT = 2; // 0x2

/**
 * Events are reported only when the value changes. Event delivery rate can be limited by
 * setting appropriate value for rate parameter of
 * {@link android.hardware.SensorManager#registerListener(android.hardware.SensorEventListener,android.hardware.Sensor,int) SensorManager#registerListener(SensorEventListener, Sensor, int)} Note: If other
 * applications are requesting a higher rate, the sensor data might be delivered at faster rates
 * than requested.
 * @apiSince 21
 */

public static final int REPORTING_MODE_ON_CHANGE = 1; // 0x1

/**
 * Events are reported as described in the description of the sensor. The rate passed to
 * registerListener might not have an impact on the rate of event delivery. See the sensor
 * definition for more information on when and how frequently the events are reported. For
 * example, step detectors report events when a step is detected.
 *
 * @see android.hardware.SensorManager#registerListener(SensorEventListener, Sensor, int, int)
 * @apiSince 21
 */

public static final int REPORTING_MODE_SPECIAL_TRIGGER = 3; // 0x3

/**
 * A constant string describing an accelerometer sensor type.
 *
 * @see #TYPE_ACCELEROMETER
 * @apiSince 20
 */

public static final java.lang.String STRING_TYPE_ACCELEROMETER = "android.sensor.accelerometer";

/**
 * A constant string describing an uncalibrated accelerometer sensor.
 *
 * @see #TYPE_ACCELEROMETER_UNCALIBRATED
 *
 * @apiSince 26
 */

public static final java.lang.String STRING_TYPE_ACCELEROMETER_UNCALIBRATED = "android.sensor.accelerometer_uncalibrated";

/**
 * A constant string describing an ambient temperature sensor type.
 *
 * @see #TYPE_AMBIENT_TEMPERATURE
 * @apiSince 20
 */

public static final java.lang.String STRING_TYPE_AMBIENT_TEMPERATURE = "android.sensor.ambient_temperature";

/**
 * A constant string describing an uncalibrated rotation vector sensor type.
 *
 * @see #TYPE_GAME_ROTATION_VECTOR
 * @apiSince 20
 */

public static final java.lang.String STRING_TYPE_GAME_ROTATION_VECTOR = "android.sensor.game_rotation_vector";

/**
 * A constant string describing a geo-magnetic rotation vector.
 *
 * @see #TYPE_GEOMAGNETIC_ROTATION_VECTOR
 * @apiSince 20
 */

public static final java.lang.String STRING_TYPE_GEOMAGNETIC_ROTATION_VECTOR = "android.sensor.geomagnetic_rotation_vector";

/**
 * A constant string describing a gravity sensor type.
 *
 * @see #TYPE_GRAVITY
 * @apiSince 20
 */

public static final java.lang.String STRING_TYPE_GRAVITY = "android.sensor.gravity";

/**
 * A constant string describing a gyroscope sensor type.
 *
 * @see #TYPE_GYROSCOPE
 * @apiSince 20
 */

public static final java.lang.String STRING_TYPE_GYROSCOPE = "android.sensor.gyroscope";

/**
 * A constant string describing an uncalibrated gyroscope sensor type.
 *
 * @see #TYPE_GYROSCOPE_UNCALIBRATED
 * @apiSince 20
 */

public static final java.lang.String STRING_TYPE_GYROSCOPE_UNCALIBRATED = "android.sensor.gyroscope_uncalibrated";

/**
 * A constant string describing a heart beat sensor.
 *
 * @see #TYPE_HEART_BEAT
 * @apiSince 24
 */

public static final java.lang.String STRING_TYPE_HEART_BEAT = "android.sensor.heart_beat";

/**
 * A constant string describing a heart rate monitor.
 *
 * @see #TYPE_HEART_RATE
 * @apiSince 20
 */

public static final java.lang.String STRING_TYPE_HEART_RATE = "android.sensor.heart_rate";

/**
 * A constant string describing a light sensor type.
 *
 * @see #TYPE_LIGHT
 * @apiSince 20
 */

public static final java.lang.String STRING_TYPE_LIGHT = "android.sensor.light";

/**
 * A constant string describing a linear acceleration sensor type.
 *
 * @see #TYPE_LINEAR_ACCELERATION
 * @apiSince 20
 */

public static final java.lang.String STRING_TYPE_LINEAR_ACCELERATION = "android.sensor.linear_acceleration";

/**
 * A constant string describing a low-latency offbody detector sensor.
 *
 * @see #TYPE_LOW_LATENCY_OFFBODY_DETECT
 * @apiSince 26
 */

public static final java.lang.String STRING_TYPE_LOW_LATENCY_OFFBODY_DETECT = "android.sensor.low_latency_offbody_detect";

/**
 * A constant string describing a magnetic field sensor type.
 *
 * @see #TYPE_MAGNETIC_FIELD
 * @apiSince 20
 */

public static final java.lang.String STRING_TYPE_MAGNETIC_FIELD = "android.sensor.magnetic_field";

/**
 * A constant string describing an uncalibrated magnetic field sensor type.
 *
 * @see #TYPE_MAGNETIC_FIELD_UNCALIBRATED
 * @apiSince 20
 */

public static final java.lang.String STRING_TYPE_MAGNETIC_FIELD_UNCALIBRATED = "android.sensor.magnetic_field_uncalibrated";

/**
 * A constant string describing a motion detection sensor.
 *
 * @see #TYPE_MOTION_DETECT
 * @apiSince 24
 */

public static final java.lang.String STRING_TYPE_MOTION_DETECT = "android.sensor.motion_detect";

/**
 * A constant string describing an orientation sensor type.
 *
 * @see #TYPE_ORIENTATION
 * @deprecated use {@link android.hardware.SensorManager#getOrientation
 *             SensorManager.getOrientation()} instead.
 * @apiSince 20
 * @deprecatedSince 20
 */

@Deprecated public static final java.lang.String STRING_TYPE_ORIENTATION = "android.sensor.orientation";

/**
 * A constant string describing a pose sensor with 6 degrees of freedom.
 *
 * @see #TYPE_POSE_6DOF
 * @apiSince 24
 */

public static final java.lang.String STRING_TYPE_POSE_6DOF = "android.sensor.pose_6dof";

/**
 * A constant string describing a pressure sensor type.
 *
 * @see #TYPE_PRESSURE
 * @apiSince 20
 */

public static final java.lang.String STRING_TYPE_PRESSURE = "android.sensor.pressure";

/**
 * A constant string describing a proximity sensor type.
 *
 * @see #TYPE_PROXIMITY
 * @apiSince 20
 */

public static final java.lang.String STRING_TYPE_PROXIMITY = "android.sensor.proximity";

/**
 * A constant string describing a relative humidity sensor type
 *
 * @see #TYPE_RELATIVE_HUMIDITY
 * @apiSince 20
 */

public static final java.lang.String STRING_TYPE_RELATIVE_HUMIDITY = "android.sensor.relative_humidity";

/**
 * A constant string describing a rotation vector sensor type.
 *
 * @see #TYPE_ROTATION_VECTOR
 * @apiSince 20
 */

public static final java.lang.String STRING_TYPE_ROTATION_VECTOR = "android.sensor.rotation_vector";

/**
 * A constant string describing a significant motion trigger sensor.
 *
 * @see #TYPE_SIGNIFICANT_MOTION
 * @apiSince 20
 */

public static final java.lang.String STRING_TYPE_SIGNIFICANT_MOTION = "android.sensor.significant_motion";

/**
 * A constant string describing a stationary detection sensor.
 *
 * @see #TYPE_STATIONARY_DETECT
 * @apiSince 24
 */

public static final java.lang.String STRING_TYPE_STATIONARY_DETECT = "android.sensor.stationary_detect";

/**
 * A constant string describing a step counter sensor.
 *
 * @see #TYPE_STEP_COUNTER
 * @apiSince 20
 */

public static final java.lang.String STRING_TYPE_STEP_COUNTER = "android.sensor.step_counter";

/**
 * A constant string describing a step detector sensor.
 *
 * @see #TYPE_STEP_DETECTOR
 * @apiSince 20
 */

public static final java.lang.String STRING_TYPE_STEP_DETECTOR = "android.sensor.step_detector";

/**
 * A constant string describing a temperature sensor type
 *
 * @see #TYPE_TEMPERATURE
 * @deprecated use
 *             {@link android.hardware.Sensor#STRING_TYPE_AMBIENT_TEMPERATURE
 *             Sensor.STRING_TYPE_AMBIENT_TEMPERATURE} instead.
 * @apiSince 20
 * @deprecatedSince 20
 */

@Deprecated public static final java.lang.String STRING_TYPE_TEMPERATURE = "android.sensor.temperature";

/**
 * A constant describing an accelerometer sensor type.
 * <p>See {@link android.hardware.SensorEvent#values SensorEvent.values}
 * for more details.
 * @apiSince 3
 */

public static final int TYPE_ACCELEROMETER = 1; // 0x1

/**
 * A constant describing an uncalibrated accelerometer sensor.
 *
 * See {@link android.hardware.SensorEvent#values SensorEvent.values} for more details.
 *
 * @apiSince 26
 */

public static final int TYPE_ACCELEROMETER_UNCALIBRATED = 35; // 0x23

/**
 * A constant describing all sensor types.
 * @apiSince 3
 */

public static final int TYPE_ALL = -1; // 0xffffffff

/**
 * A constant describing an ambient temperature sensor type.
 * <p>See {@link android.hardware.SensorEvent#values SensorEvent.values}
 * for more details.
 * @apiSince 14
 */

public static final int TYPE_AMBIENT_TEMPERATURE = 13; // 0xd

/**
 * The lowest sensor type vendor defined sensors can use.
 *
 * All vendor sensor types are greater than or equal to this constant.
 *
 * @apiSince 24
 */

public static final int TYPE_DEVICE_PRIVATE_BASE = 65536; // 0x10000

/**
 * A constant describing an uncalibrated rotation vector sensor type.
 * <p>Identical to {@link #TYPE_ROTATION_VECTOR} except that it doesn't
 * use the geomagnetic field. Therefore the Y axis doesn't
 * point north, but instead to some other reference, that reference is
 * allowed to drift by the same order of magnitude as the gyroscope
 * drift around the Z axis.
 * <p>
 * In the ideal case, a phone rotated and returning to the same real-world
 * orientation should report the same game rotation vector
 * (without using the earth's geomagnetic field). However, the orientation
 * may drift somewhat over time.
 * </p>
 * <p>See {@link android.hardware.SensorEvent#values SensorEvent.values} for more
 * details.
 * @apiSince 18
 */

public static final int TYPE_GAME_ROTATION_VECTOR = 15; // 0xf

/**
 * A constant describing a geo-magnetic rotation vector.
 * <p>
 * Similar to {@link #TYPE_ROTATION_VECTOR}, but using a magnetometer instead of using a
 * gyroscope. This sensor uses lower power than the other rotation vectors, because it doesn't
 * use the gyroscope. However, it is more noisy and will work best outdoors.
 * <p>
 * See {@link android.hardware.SensorEvent#values SensorEvent.values} for more details.
 * @apiSince 19
 */

public static final int TYPE_GEOMAGNETIC_ROTATION_VECTOR = 20; // 0x14

/**
 * A constant describing a gravity sensor type.
 * <p>See {@link android.hardware.SensorEvent#values SensorEvent.values}
 * for more details.
 * @apiSince 9
 */

public static final int TYPE_GRAVITY = 9; // 0x9

/**
 * A constant describing a gyroscope sensor type.
 * <p>See {@link android.hardware.SensorEvent#values SensorEvent.values}
 * for more details.     * @apiSince 3
 */

public static final int TYPE_GYROSCOPE = 4; // 0x4

/**
 * A constant describing an uncalibrated gyroscope sensor type.
 * <p>Similar to {@link #TYPE_GYROSCOPE} but no gyro-drift compensation has been performed
 * to adjust the given sensor values. However, such gyro-drift bias values
 * are returned to you separately in the result {@link android.hardware.SensorEvent#values}
 * so you may use them for custom calibrations.
 * <p>Factory calibration and temperature compensation is still applied
 * to the rate of rotation (angular speeds).
 * </p>
 * <p> See {@link android.hardware.SensorEvent#values SensorEvent.values} for more
 * details.
 * @apiSince 18
 */

public static final int TYPE_GYROSCOPE_UNCALIBRATED = 16; // 0x10

/**
 * A constant describing a motion detect sensor.
 *
 * See {@link android.hardware.SensorEvent#values SensorEvent.values} for more details.
 *
 * @apiSince 24
 */

public static final int TYPE_HEART_BEAT = 31; // 0x1f

/**
 * A constant describing a heart rate monitor.
 * <p>
 * The reported value is the heart rate in beats per minute.
 * <p>
 * The reported accuracy represents the status of the monitor during the reading. See the
 * {@code SENSOR_STATUS_*} constants in {@link android.hardware.SensorManager SensorManager}
 * for more details on accuracy/status values. In particular, when the accuracy is
 * {@code SENSOR_STATUS_UNRELIABLE} or {@code SENSOR_STATUS_NO_CONTACT}, the heart rate
 * value should be discarded.
 * <p>
 * This sensor requires permission {@code android.permission.BODY_SENSORS}.
 * It will not be returned by {@code SensorManager.getSensorsList} nor
 * {@code SensorManager.getDefaultSensor} if the application doesn't have this permission.
 * @apiSince 20
 */

public static final int TYPE_HEART_RATE = 21; // 0x15

/**
 * A constant describing a light sensor type.
 * <p>See {@link android.hardware.SensorEvent#values SensorEvent.values}
 * for more details.
 * @apiSince 3
 */

public static final int TYPE_LIGHT = 5; // 0x5

/**
 * A constant describing a linear acceleration sensor type.
 * <p>See {@link android.hardware.SensorEvent#values SensorEvent.values}
 * for more details.
 * @apiSince 9
 */

public static final int TYPE_LINEAR_ACCELERATION = 10; // 0xa

/**
 * A constant describing a low latency off-body detect sensor.
 *
 * See {@link android.hardware.SensorEvent#values SensorEvent.values} for more details.
 *
 * @apiSince 26
 */

public static final int TYPE_LOW_LATENCY_OFFBODY_DETECT = 34; // 0x22

/**
 * A constant describing a magnetic field sensor type.
 * <p>See {@link android.hardware.SensorEvent#values SensorEvent.values}
 * for more details.
 * @apiSince 3
 */

public static final int TYPE_MAGNETIC_FIELD = 2; // 0x2

/**
 * A constant describing an uncalibrated magnetic field sensor type.
 * <p>
 * Similar to {@link #TYPE_MAGNETIC_FIELD} but the hard iron calibration (device calibration
 * due to distortions that arise from magnetized iron, steel or permanent magnets on the
 * device) is not considered in the given sensor values. However, such hard iron bias values
 * are returned to you separately in the result {@link android.hardware.SensorEvent#values}
 * so you may use them for custom calibrations.
 * <p>Also, no periodic calibration is performed
 * (i.e. there are no discontinuities in the data stream while using this sensor) and
 * assumptions that the magnetic field is due to the Earth's poles is avoided, but
 * factory calibration and temperature compensation have been performed.
 * </p>
 * <p>See {@link android.hardware.SensorEvent#values SensorEvent.values} for more
 * details.
 * @apiSince 18
 */

public static final int TYPE_MAGNETIC_FIELD_UNCALIBRATED = 14; // 0xe

/**
 * A constant describing a motion detect sensor.
 *
 * See {@link android.hardware.SensorEvent#values SensorEvent.values} for more details.
 *
 * @apiSince 24
 */

public static final int TYPE_MOTION_DETECT = 30; // 0x1e

/**
 * A constant describing an orientation sensor type.
 * <p>See {@link android.hardware.SensorEvent#values SensorEvent.values}
 * for more details.
 *
 * @deprecated use {@link android.hardware.SensorManager#getOrientation
 *             SensorManager.getOrientation()} instead.
 * @apiSince 3
 * @deprecatedSince 15
 */

@Deprecated public static final int TYPE_ORIENTATION = 3; // 0x3

/**
 * A constant describing a pose sensor with 6 degrees of freedom.
 *
 * Similar to {@link #TYPE_ROTATION_VECTOR}, with additional delta
 * translation from an arbitrary reference point.
 *
 * See {@link android.hardware.SensorEvent#values SensorEvent.values} for more details.
 *
 * Can use camera, depth sensor etc to compute output value.
 *
 * This is expected to be a high power sensor and expected only to be
 * used when the screen is on.
 *
 * Expected to be more accurate than the rotation vector alone.
 *
 * @apiSince 24
 */

public static final int TYPE_POSE_6DOF = 28; // 0x1c

/**
 * A constant describing a pressure sensor type.
 * <p>See {@link android.hardware.SensorEvent#values SensorEvent.values}
 * for more details.
 * @apiSince 3
 */

public static final int TYPE_PRESSURE = 6; // 0x6

/**
 * A constant describing a proximity sensor type. This is a wake up sensor.
 * <p>See {@link android.hardware.SensorEvent#values SensorEvent.values}
 * for more details.
 * @see #isWakeUpSensor()
 * @apiSince 3
 */

public static final int TYPE_PROXIMITY = 8; // 0x8

/**
 * A constant describing a relative humidity sensor type.
 * <p>See {@link android.hardware.SensorEvent#values SensorEvent.values}
 * for more details.
 * @apiSince 14
 */

public static final int TYPE_RELATIVE_HUMIDITY = 12; // 0xc

/**
 * A constant describing a rotation vector sensor type.
 * <p>See {@link android.hardware.SensorEvent#values SensorEvent.values}
 * for more details.
 * @apiSince 9
 */

public static final int TYPE_ROTATION_VECTOR = 11; // 0xb

/**
 * A constant describing a significant motion trigger sensor.
 * <p>
 * It triggers when an event occurs and then automatically disables
 * itself. The sensor continues to operate while the device is asleep
 * and will automatically wake the device to notify when significant
 * motion is detected. The application does not need to hold any wake
 * locks for this sensor to trigger. This is a wake up sensor.
 * <p>See {@link android.hardware.TriggerEvent TriggerEvent} for more details.
 *
 * @see #isWakeUpSensor()
 * @apiSince 18
 */

public static final int TYPE_SIGNIFICANT_MOTION = 17; // 0x11

/**
 * A constant describing a stationary detect sensor.
 *
 * See {@link android.hardware.SensorEvent#values SensorEvent.values} for more details.
 *
 * @apiSince 24
 */

public static final int TYPE_STATIONARY_DETECT = 29; // 0x1d

/**
 * A constant describing a step counter sensor.
 * <p>
 * A sensor of this type returns the number of steps taken by the user since the last reboot
 * while activated. The value is returned as a float (with the fractional part set to zero) and
 * is reset to zero only on a system reboot. The timestamp of the event is set to the time when
 * the last step for that event was taken. This sensor is implemented in hardware and is
 * expected to be low power. If you want to continuously track the number of steps over a long
 * period of time, do NOT unregister for this sensor, so that it keeps counting steps in the
 * background even when the AP is in suspend mode and report the aggregate count when the AP
 * is awake. Application needs to stay registered for this sensor because step counter does not
 * count steps if it is not activated. This sensor is ideal for fitness tracking applications.
 * It is defined as an {@link android.hardware.Sensor#REPORTING_MODE_ON_CHANGE Sensor#REPORTING_MODE_ON_CHANGE} sensor.
 * <p>
 * This sensor requires permission {@code android.permission.ACTIVITY_RECOGNITION}.
 * <p>
 * See {@link android.hardware.SensorEvent#values SensorEvent.values} for more details.
 * @apiSince 19
 */

public static final int TYPE_STEP_COUNTER = 19; // 0x13

/**
 * A constant describing a step detector sensor.
 * <p>
 * A sensor of this type triggers an event each time a step is taken by the user. The only
 * allowed value to return is 1.0 and an event is generated for each step. Like with any other
 * event, the timestamp indicates when the event (here the step) occurred, this corresponds to
 * when the foot hit the ground, generating a high variation in acceleration. This sensor is
 * only for detecting every individual step as soon as it is taken, for example to perform dead
 * reckoning. If you only need aggregate number of steps taken over a period of time, register
 * for {@link #TYPE_STEP_COUNTER} instead. It is defined as a
 * {@link android.hardware.Sensor#REPORTING_MODE_SPECIAL_TRIGGER Sensor#REPORTING_MODE_SPECIAL_TRIGGER} sensor.
 * <p>
 * This sensor requires permission {@code android.permission.ACTIVITY_RECOGNITION}.
 * <p>
 * See {@link android.hardware.SensorEvent#values SensorEvent.values} for more details.
 * @apiSince 19
 */

public static final int TYPE_STEP_DETECTOR = 18; // 0x12

/**
 * A constant describing a temperature sensor type
 *
 * @deprecated use
 *             {@link android.hardware.Sensor#TYPE_AMBIENT_TEMPERATURE
 *             Sensor.TYPE_AMBIENT_TEMPERATURE} instead.
 * @apiSince 3
 * @deprecatedSince 15
 */

@Deprecated public static final int TYPE_TEMPERATURE = 7; // 0x7
}

