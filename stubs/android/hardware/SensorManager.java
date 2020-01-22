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

import android.os.Handler;
import android.os.MemoryFile;

/**
 * <p>
 * SensorManager lets you access the device's {@link android.hardware.Sensor
 * sensors}.
 * </p>
 * <p>
 * Always make sure to disable sensors you don't need, especially when your
 * activity is paused. Failing to do so can drain the battery in just a few
 * hours. Note that the system will <i>not</i> disable sensors automatically when
 * the screen turns off.
 * </p>
 * <p class="note">
 * Note: Don't use this mechanism with a Trigger Sensor, have a look
 * at {@link android.hardware.TriggerEventListener TriggerEventListener}. {@link android.hardware.Sensor#TYPE_SIGNIFICANT_MOTION Sensor#TYPE_SIGNIFICANT_MOTION}
 * is an example of a trigger sensor.
 * </p>
 * <pre class="prettyprint">
 * public class SensorActivity extends Activity implements SensorEventListener {
 *     private final SensorManager mSensorManager;
 *     private final Sensor mAccelerometer;
 *
 *     public SensorActivity() {
 *         mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
 *         mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
 *     }
 *
 *     protected void onResume() {
 *         super.onResume();
 *         mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
 *     }
 *
 *     protected void onPause() {
 *         super.onPause();
 *         mSensorManager.unregisterListener(this);
 *     }
 *
 *     public void onAccuracyChanged(Sensor sensor, int accuracy) {
 *     }
 *
 *     public void onSensorChanged(SensorEvent event) {
 *     }
 * }
 * </pre>
 *
 * @see android.hardware.SensorEventListener
 * @see android.hardware.SensorEvent
 * @see android.hardware.Sensor
 *
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class SensorManager {

SensorManager() { throw new RuntimeException("Stub!"); }

/**
 * @return available sensors.
 * @deprecated This method is deprecated, use
 *             {@link android.hardware.SensorManager#getSensorList(int) SensorManager#getSensorList(int)} instead
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public int getSensors() { throw new RuntimeException("Stub!"); }

/**
 * Use this method to get the list of available sensors of a certain type.
 * Make multiple calls to get sensors of different types or use
 * {@link android.hardware.Sensor#TYPE_ALL Sensor.TYPE_ALL} to get all the
 * sensors.
 *
 * <p class="note">
 * NOTE: Both wake-up and non wake-up sensors matching the given type are
 * returned. Check {@link android.hardware.Sensor#isWakeUpSensor() Sensor#isWakeUpSensor()} to know the wake-up properties
 * of the returned {@link android.hardware.Sensor Sensor}.
 * </p>
 *
 * @param type
 *        of sensors requested
 *
 * @return a list of sensors matching the asked type.
 *
 * @see #getDefaultSensor(int)
 * @see android.hardware.Sensor
 * @apiSince 3
 */

public java.util.List<android.hardware.Sensor> getSensorList(int type) { throw new RuntimeException("Stub!"); }

/**
 * Use this method to get a list of available dynamic sensors of a certain type.
 * Make multiple calls to get sensors of different types or use
 * {@link android.hardware.Sensor#TYPE_ALL Sensor.TYPE_ALL} to get all dynamic sensors.
 *
 * <p class="note">
 * NOTE: Both wake-up and non wake-up sensors matching the given type are
 * returned. Check {@link android.hardware.Sensor#isWakeUpSensor() Sensor#isWakeUpSensor()} to know the wake-up properties
 * of the returned {@link android.hardware.Sensor Sensor}.
 * </p>
 *
 * @param type of sensors requested
 *
 * @return a list of dynamic sensors matching the requested type.
 *
 * @see android.hardware.Sensor
 * @apiSince 24
 */

public java.util.List<android.hardware.Sensor> getDynamicSensorList(int type) { throw new RuntimeException("Stub!"); }

/**
 * Use this method to get the default sensor for a given type. Note that the
 * returned sensor could be a composite sensor, and its data could be
 * averaged or filtered. If you need to access the raw sensors use
 * {@link android.hardware.SensorManager#getSensorList(int) SensorManager#getSensorList(int)}.
 *
 * @param type
 *         of sensors requested
 *
 * @return the default sensor matching the requested type if one exists and the application
 *         has the necessary permissions, or null otherwise.
 *
 * @see #getSensorList(int)
 * @see android.hardware.Sensor
 * @apiSince 3
 */

public android.hardware.Sensor getDefaultSensor(int type) { throw new RuntimeException("Stub!"); }

/**
 * Return a Sensor with the given type and wakeUp properties. If multiple sensors of this
 * type exist, any one of them may be returned.
 * <p>
 * For example,
 * <ul>
 *     <li>getDefaultSensor({@link android.hardware.Sensor#TYPE_ACCELEROMETER Sensor#TYPE_ACCELEROMETER}, true) returns a wake-up
 *     accelerometer sensor if it exists. </li>
 *     <li>getDefaultSensor({@link android.hardware.Sensor#TYPE_PROXIMITY Sensor#TYPE_PROXIMITY}, false) returns a non wake-up
 *     proximity sensor if it exists. </li>
 *     <li>getDefaultSensor({@link android.hardware.Sensor#TYPE_PROXIMITY Sensor#TYPE_PROXIMITY}, true) returns a wake-up proximity
 *     sensor which is the same as the Sensor returned by {@link #getDefaultSensor(int)}. </li>
 * </ul>
 * </p>
 * <p class="note">
 * Note: Sensors like {@link android.hardware.Sensor#TYPE_PROXIMITY Sensor#TYPE_PROXIMITY} and {@link android.hardware.Sensor#TYPE_SIGNIFICANT_MOTION Sensor#TYPE_SIGNIFICANT_MOTION}
 * are declared as wake-up sensors by default.
 * </p>
 * @param type
 *        type of sensor requested
 * @param wakeUp
 *        flag to indicate whether the Sensor is a wake-up or non wake-up sensor.
 * @return the default sensor matching the requested type and wakeUp properties if one exists
 *         and the application has the necessary permissions, or null otherwise.
 * @see android.hardware.Sensor#isWakeUpSensor()
 * @apiSince 21
 */

public android.hardware.Sensor getDefaultSensor(int type, boolean wakeUp) { throw new RuntimeException("Stub!"); }

/**
 * Registers a listener for given sensors.
 *
 * @deprecated This method is deprecated, use
 *             {@link android.hardware.SensorManager#registerListener(android.hardware.SensorEventListener,android.hardware.Sensor,int) SensorManager#registerListener(SensorEventListener, Sensor, int)}
 *             instead.
 *
 * @param listener
 *        sensor listener object
 *
 * @param sensors
 *        a bit masks of the sensors to register to
 *
 * @return <code>true</code> if the sensor is supported and successfully
 *         enabled
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public boolean registerListener(android.hardware.SensorListener listener, int sensors) { throw new RuntimeException("Stub!"); }

/**
 * Registers a SensorListener for given sensors.
 *
 * @deprecated This method is deprecated, use
 *             {@link android.hardware.SensorManager#registerListener(android.hardware.SensorEventListener,android.hardware.Sensor,int) SensorManager#registerListener(SensorEventListener, Sensor, int)}
 *             instead.
 *
 * @param listener
 *        sensor listener object
 *
 * @param sensors
 *        a bit masks of the sensors to register to
 *
 * @param rate
 *        rate of events. This is only a hint to the system. events may be
 *        received faster or slower than the specified rate. Usually events
 *        are received faster. The value must be one of
 *        {@link #SENSOR_DELAY_NORMAL}, {@link #SENSOR_DELAY_UI},
 *        {@link #SENSOR_DELAY_GAME}, or {@link #SENSOR_DELAY_FASTEST}.
 *
 * @return <code>true</code> if the sensor is supported and successfully
 *         enabled
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public boolean registerListener(android.hardware.SensorListener listener, int sensors, int rate) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters a listener for all sensors.
 *
 * @deprecated This method is deprecated, use
 *             {@link android.hardware.SensorManager#unregisterListener(android.hardware.SensorEventListener) SensorManager#unregisterListener(SensorEventListener)}
 *             instead.
 *
 * @param listener
 *        a SensorListener object
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public void unregisterListener(android.hardware.SensorListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters a listener for the sensors with which it is registered.
 *
 * @deprecated This method is deprecated, use
 *             {@link android.hardware.SensorManager#unregisterListener(android.hardware.SensorEventListener,android.hardware.Sensor) SensorManager#unregisterListener(SensorEventListener, Sensor)}
 *             instead.
 *
 * @param listener
 *        a SensorListener object
 *
 * @param sensors
 *        a bit masks of the sensors to unregister from
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public void unregisterListener(android.hardware.SensorListener listener, int sensors) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters a listener for the sensors with which it is registered.
 *
 * <p class="note"></p>
 * Note: Don't use this method with a one shot trigger sensor such as
 * {@link android.hardware.Sensor#TYPE_SIGNIFICANT_MOTION Sensor#TYPE_SIGNIFICANT_MOTION}.
 * Use {@link #cancelTriggerSensor(android.hardware.TriggerEventListener,android.hardware.Sensor)} instead.
 * </p>
 *
 * @param listener
 *        a SensorEventListener object
 *
 * @param sensor
 *        the sensor to unregister from
 *
 * @see #unregisterListener(SensorEventListener)
 * @see #registerListener(SensorEventListener, Sensor, int)
 * @apiSince 3
 */

public void unregisterListener(android.hardware.SensorEventListener listener, android.hardware.Sensor sensor) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters a listener for all sensors.
 *
 * @param listener
 *        a SensorListener object
 *
 * @see #unregisterListener(SensorEventListener, Sensor)
 * @see #registerListener(SensorEventListener, Sensor, int)
 *
 * @apiSince 3
 */

public void unregisterListener(android.hardware.SensorEventListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Registers a {@link android.hardware.SensorEventListener SensorEventListener} for the given
 * sensor at the given sampling frequency.
 * <p>
 * The events will be delivered to the provided {@code SensorEventListener} as soon as they are
 * available. To reduce the power consumption, applications can use
 * {@link #registerListener(android.hardware.SensorEventListener,android.hardware.Sensor,int,int)} instead and specify a
 * positive non-zero maximum reporting latency.
 * </p>
 * <p>
 * In the case of non-wake-up sensors, the events are only delivered while the Application
 * Processor (AP) is not in suspend mode. See {@link android.hardware.Sensor#isWakeUpSensor() Sensor#isWakeUpSensor()} for more details.
 * To ensure delivery of events from non-wake-up sensors even when the screen is OFF, the
 * application registering to the sensor must hold a partial wake-lock to keep the AP awake,
 * otherwise some events might be lost while the AP is asleep. Note that although events might
 * be lost while the AP is asleep, the sensor will still consume power if it is not explicitly
 * deactivated by the application. Applications must unregister their {@code
 * SensorEventListener}s in their activity's {@code onPause()} method to avoid consuming power
 * while the device is inactive.  See {@link #registerListener(android.hardware.SensorEventListener,android.hardware.Sensor,int,int)} for more details on hardware FIFO (queueing) capabilities and when some sensor events
 * might be lost.
 * </p>
 * <p>
 * In the case of wake-up sensors, each event generated by the sensor will cause the AP to
 * wake-up, ensuring that each event can be delivered. Because of this, registering to a wake-up
 * sensor has very significant power implications. Call {@link android.hardware.Sensor#isWakeUpSensor() Sensor#isWakeUpSensor()} to check
 * whether a sensor is a wake-up sensor. See
 * {@link #registerListener(android.hardware.SensorEventListener,android.hardware.Sensor,int,int)} for information on how to
 * reduce the power impact of registering to wake-up sensors.
 * </p>
 * <p class="note">
 * Note: Don't use this method with one-shot trigger sensors such as
 * {@link android.hardware.Sensor#TYPE_SIGNIFICANT_MOTION Sensor#TYPE_SIGNIFICANT_MOTION}. Use
 * {@link #requestTriggerSensor(android.hardware.TriggerEventListener,android.hardware.Sensor)} instead. Use
 * {@link android.hardware.Sensor#getReportingMode() Sensor#getReportingMode()} to obtain the reporting mode of a given sensor.
 * </p>
 *
 * @param listener A {@link android.hardware.SensorEventListener SensorEventListener} object.
 * @param sensor The {@link android.hardware.Sensor Sensor} to register to.
 * @param samplingPeriodUs The rate {@link android.hardware.SensorEvent sensor events} are
 *            delivered at. This is only a hint to the system. Events may be received faster or
 *            slower than the specified rate. Usually events are received faster. The value must
 *            be one of {@link #SENSOR_DELAY_NORMAL}, {@link #SENSOR_DELAY_UI},
 *            {@link #SENSOR_DELAY_GAME}, or {@link #SENSOR_DELAY_FASTEST} or, the desired delay
 *            between events in microseconds. Specifying the delay in microseconds only works
 *            from Android 2.3 (API level 9) onwards. For earlier releases, you must use one of
 *            the {@code SENSOR_DELAY_*} constants.
 * @return <code>true</code> if the sensor is supported and successfully enabled.
 * @see #registerListener(SensorEventListener, Sensor, int, Handler)
 * @see #unregisterListener(SensorEventListener)
 * @see #unregisterListener(SensorEventListener, Sensor)
 * @apiSince 3
 */

public boolean registerListener(android.hardware.SensorEventListener listener, android.hardware.Sensor sensor, int samplingPeriodUs) { throw new RuntimeException("Stub!"); }

/**
 * Registers a {@link android.hardware.SensorEventListener SensorEventListener} for the given
 * sensor at the given sampling frequency and the given maximum reporting latency.
 * <p>
 * This function is similar to {@link #registerListener(android.hardware.SensorEventListener,android.hardware.Sensor,int)} but
 * it allows events to stay temporarily in the hardware FIFO (queue) before being delivered. The
 * events can be stored in the hardware FIFO up to {@code maxReportLatencyUs} microseconds. Once
 * one of the events in the FIFO needs to be reported, all of the events in the FIFO are
 * reported sequentially. This means that some events will be reported before the maximum
 * reporting latency has elapsed.
 * </p><p>
 * When {@code maxReportLatencyUs} is 0, the call is equivalent to a call to
 * {@link #registerListener(android.hardware.SensorEventListener,android.hardware.Sensor,int)}, as it requires the events to be
 * delivered as soon as possible.
 * </p><p>
 * When {@code sensor.maxFifoEventCount()} is 0, the sensor does not use a FIFO, so the call
 * will also be equivalent to {@link #registerListener(android.hardware.SensorEventListener,android.hardware.Sensor,int)}.
 * </p><p>
 * Setting {@code maxReportLatencyUs} to a positive value allows to reduce the number of
 * interrupts the AP (Application Processor) receives, hence reducing power consumption, as the
 * AP can switch to a lower power state while the sensor is capturing the data. This is
 * especially important when registering to wake-up sensors, for which each interrupt causes the
 * AP to wake up if it was in suspend mode. See {@link android.hardware.Sensor#isWakeUpSensor() Sensor#isWakeUpSensor()} for more
 * information on wake-up sensors.
 * </p>
 * <p class="note">
 * </p>
 * Note: Don't use this method with one-shot trigger sensors such as
 * {@link android.hardware.Sensor#TYPE_SIGNIFICANT_MOTION Sensor#TYPE_SIGNIFICANT_MOTION}. Use
 * {@link #requestTriggerSensor(android.hardware.TriggerEventListener,android.hardware.Sensor)} instead. </p>
 *
 * @param listener A {@link android.hardware.SensorEventListener SensorEventListener} object
 *            that will receive the sensor events. If the application is interested in receiving
 *            flush complete notifications, it should register with
 *            {@link android.hardware.SensorEventListener SensorEventListener2} instead.
 * @param sensor The {@link android.hardware.Sensor Sensor} to register to.
 * @param samplingPeriodUs The desired delay between two consecutive events in microseconds.
 *            This is only a hint to the system. Events may be received faster or slower than
 *            the specified rate. Usually events are received faster. Can be one of
 *            {@link #SENSOR_DELAY_NORMAL}, {@link #SENSOR_DELAY_UI},
 *            {@link #SENSOR_DELAY_GAME}, {@link #SENSOR_DELAY_FASTEST} or the delay in
 *            microseconds.
 * @param maxReportLatencyUs Maximum time in microseconds that events can be delayed before
 *            being reported to the application. A large value allows reducing the power
 *            consumption associated with the sensor. If maxReportLatencyUs is set to zero,
 *            events are delivered as soon as they are available, which is equivalent to calling
 *            {@link #registerListener(android.hardware.SensorEventListener,android.hardware.Sensor,int)}.
 * @return <code>true</code> if the sensor is supported and successfully enabled.
 * @see #registerListener(SensorEventListener, Sensor, int)
 * @see #unregisterListener(SensorEventListener)
 * @see #flush(SensorEventListener)
 * @apiSince 19
 */

public boolean registerListener(android.hardware.SensorEventListener listener, android.hardware.Sensor sensor, int samplingPeriodUs, int maxReportLatencyUs) { throw new RuntimeException("Stub!"); }

/**
 * Registers a {@link android.hardware.SensorEventListener SensorEventListener} for the given
 * sensor. Events are delivered in continuous mode as soon as they are available. To reduce the
 * power consumption, applications can use
 * {@link #registerListener(android.hardware.SensorEventListener,android.hardware.Sensor,int,int)} instead and specify a
 * positive non-zero maximum reporting latency.
 * <p class="note">
 * </p>
 * Note: Don't use this method with a one shot trigger sensor such as
 * {@link android.hardware.Sensor#TYPE_SIGNIFICANT_MOTION Sensor#TYPE_SIGNIFICANT_MOTION}. Use
 * {@link #requestTriggerSensor(android.hardware.TriggerEventListener,android.hardware.Sensor)} instead. </p>
 *
 * @param listener A {@link android.hardware.SensorEventListener SensorEventListener} object.
 * @param sensor The {@link android.hardware.Sensor Sensor} to register to.
 * @param samplingPeriodUs The rate {@link android.hardware.SensorEvent sensor events} are
 *            delivered at. This is only a hint to the system. Events may be received faster or
 *            slower than the specified rate. Usually events are received faster. The value must
 *            be one of {@link #SENSOR_DELAY_NORMAL}, {@link #SENSOR_DELAY_UI},
 *            {@link #SENSOR_DELAY_GAME}, or {@link #SENSOR_DELAY_FASTEST} or, the desired
 *            delay between events in microseconds. Specifying the delay in microseconds only
 *            works from Android 2.3 (API level 9) onwards. For earlier releases, you must use
 *            one of the {@code SENSOR_DELAY_*} constants.
 * @param handler The {@link android.os.Handler Handler} the {@link android.hardware.SensorEvent
 *            sensor events} will be delivered to.
 * @return <code>true</code> if the sensor is supported and successfully enabled.
 * @see #registerListener(SensorEventListener, Sensor, int)
 * @see #unregisterListener(SensorEventListener)
 * @see #unregisterListener(SensorEventListener, Sensor)
 * @apiSince 3
 */

public boolean registerListener(android.hardware.SensorEventListener listener, android.hardware.Sensor sensor, int samplingPeriodUs, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Registers a {@link android.hardware.SensorEventListener SensorEventListener} for the given
 * sensor at the given sampling frequency and the given maximum reporting latency.
 *
 * @param listener A {@link android.hardware.SensorEventListener SensorEventListener} object
 *            that will receive the sensor events. If the application is interested in receiving
 *            flush complete notifications, it should register with
 *            {@link android.hardware.SensorEventListener SensorEventListener2} instead.
 * @param sensor The {@link android.hardware.Sensor Sensor} to register to.
 * @param samplingPeriodUs The desired delay between two consecutive events in microseconds.
 *            This is only a hint to the system. Events may be received faster or slower than
 *            the specified rate. Usually events are received faster. Can be one of
 *            {@link #SENSOR_DELAY_NORMAL}, {@link #SENSOR_DELAY_UI},
 *            {@link #SENSOR_DELAY_GAME}, {@link #SENSOR_DELAY_FASTEST} or the delay in
 *            microseconds.
 * @param maxReportLatencyUs Maximum time in microseconds that events can be delayed before
 *            being reported to the application. A large value allows reducing the power
 *            consumption associated with the sensor. If maxReportLatencyUs is set to zero,
 *            events are delivered as soon as they are available, which is equivalent to calling
 *            {@link #registerListener(android.hardware.SensorEventListener,android.hardware.Sensor,int)}.
 * @param handler The {@link android.os.Handler Handler} the {@link android.hardware.SensorEvent
 *            sensor events} will be delivered to.
 * @return <code>true</code> if the sensor is supported and successfully enabled.
 * @see #registerListener(SensorEventListener, Sensor, int, int)
 * @apiSince 19
 */

public boolean registerListener(android.hardware.SensorEventListener listener, android.hardware.Sensor sensor, int samplingPeriodUs, int maxReportLatencyUs, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Flushes the FIFO of all the sensors registered for this listener. If there are events
 * in the FIFO of the sensor, they are returned as if the maxReportLantecy of the FIFO has
 * expired. Events are returned in the usual way through the SensorEventListener.
 * This call doesn't affect the maxReportLantecy for this sensor. This call is asynchronous and
 * returns immediately.
 * {@link android.hardware.SensorEventListener2#onFlushCompleted onFlushCompleted} is called
 * after all the events in the batch at the time of calling this method have been delivered
 * successfully. If the hardware doesn't support flush, it still returns true and a trivial
 * flush complete event is sent after the current event for all the clients registered for this
 * sensor.
 *
 * @param listener A {@link android.hardware.SensorEventListener SensorEventListener} object
 *        which was previously used in a registerListener call.
 * @return <code>true</code> if the flush is initiated successfully on all the sensors
 *         registered for this listener, false if no sensor is previously registered for this
 *         listener or flush on one of the sensors fails.
 * @see #registerListener(SensorEventListener, Sensor, int, int)
 * @throws java.lang.IllegalArgumentException when listener is null.
 * @apiSince 19
 */

public boolean flush(android.hardware.SensorEventListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Create a sensor direct channel backed by shared memory wrapped in MemoryFile object.
 *
 * The resulting channel can be used for delivering sensor events to native code, other
 * processes, GPU/DSP or other co-processors without CPU intervention. This is the recommanded
 * for high performance sensor applications that use high sensor rates (e.g. greater than 200Hz)
 * and cares about sensor event latency.
 *
 * Use the returned {@link android.hardware.SensorDirectChannel} object to configure direct
 * report of sensor events. After use, call {@link android.hardware.SensorDirectChannel#close()}
 * to free up resource in sensor system associated with the direct channel.
 *
 * @param mem A {@link android.os.MemoryFile} shared memory object.
 * @return A {@link android.hardware.SensorDirectChannel} object.
 * @throws java.lang.NullPointerException when mem is null.
 * @throws UncheckedIOException if not able to create channel.
 * @see SensorDirectChannel#close()
 * @apiSince 26
 */

public android.hardware.SensorDirectChannel createDirectChannel(android.os.MemoryFile mem) { throw new RuntimeException("Stub!"); }

/**
 * Create a sensor direct channel backed by shared memory wrapped in HardwareBuffer object.
 *
 * The resulting channel can be used for delivering sensor events to native code, other
 * processes, GPU/DSP or other co-processors without CPU intervention. This is the recommanded
 * for high performance sensor applications that use high sensor rates (e.g. greater than 200Hz)
 * and cares about sensor event latency.
 *
 * Use the returned {@link android.hardware.SensorDirectChannel} object to configure direct
 * report of sensor events. After use, call {@link android.hardware.SensorDirectChannel#close()}
 * to free up resource in sensor system associated with the direct channel.
 *
 * @param mem A {@link android.hardware.HardwareBuffer} shared memory object.
 * @return A {@link android.hardware.SensorDirectChannel} object.
 * @throws java.lang.NullPointerException when mem is null.
 * @throws UncheckedIOException if not able to create channel.
 * @see SensorDirectChannel#close()
 * @apiSince 26
 */

public android.hardware.SensorDirectChannel createDirectChannel(android.hardware.HardwareBuffer mem) { throw new RuntimeException("Stub!"); }

/**
 * Add a {@link android.hardware.SensorManager.DynamicSensorCallback
 * DynamicSensorCallback} to receive dynamic sensor connection callbacks. Repeat
 * registration with the already registered callback object will have no additional effect.
 *
 * @param callback An object that implements the
 *        {@link android.hardware.SensorManager.DynamicSensorCallback
 *        DynamicSensorCallback}
 *        interface for receiving callbacks.
 * @see #registerDynamicSensorCallback(DynamicSensorCallback, Handler)
 *
 * @throws java.lang.IllegalArgumentException when callback is null.
 * @apiSince 24
 */

public void registerDynamicSensorCallback(android.hardware.SensorManager.DynamicSensorCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Add a {@link android.hardware.SensorManager.DynamicSensorCallback
 * DynamicSensorCallback} to receive dynamic sensor connection callbacks. Repeat
 * registration with the already registered callback object will have no additional effect.
 *
 * @param callback An object that implements the
 *        {@link android.hardware.SensorManager.DynamicSensorCallback
 *        DynamicSensorCallback} interface for receiving callbacks.
 * @param handler The {@link android.os.Handler Handler} the {@link
 *        android.hardware.SensorManager.DynamicSensorCallback
 *        sensor connection events} will be delivered to.
 *
 * @throws java.lang.IllegalArgumentException when callback is null.
 * @apiSince 24
 */

public void registerDynamicSensorCallback(android.hardware.SensorManager.DynamicSensorCallback callback, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Remove a {@link android.hardware.SensorManager.DynamicSensorCallback
 * DynamicSensorCallback} to stop sending dynamic sensor connection events to that
 * callback.
 *
 * @param callback An object that implements the
 *        {@link android.hardware.SensorManager.DynamicSensorCallback
 *        DynamicSensorCallback}
 *        interface for receiving callbacks.
 * @apiSince 24
 */

public void unregisterDynamicSensorCallback(android.hardware.SensorManager.DynamicSensorCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Tell if dynamic sensor discovery feature is supported by system.
 *
 * @return <code>true</code> if dynamic sensor discovery is supported, <code>false</code>
 * otherwise.
 * @apiSince 24
 */

public boolean isDynamicSensorDiscoverySupported() { throw new RuntimeException("Stub!"); }

/**
 * <p>
 * Computes the inclination matrix <b>I</b> as well as the rotation matrix
 * <b>R</b> transforming a vector from the device coordinate system to the
 * world's coordinate system which is defined as a direct orthonormal basis,
 * where:
 * </p>
 *
 * <ul>
 * <li>X is defined as the vector product <b>Y.Z</b> (It is tangential to
 * the ground at the device's current location and roughly points East).</li>
 * <li>Y is tangential to the ground at the device's current location and
 * points towards the magnetic North Pole.</li>
 * <li>Z points towards the sky and is perpendicular to the ground.</li>
 * </ul>
 *
 * <p>
 * <center><img src="../../../images/axis_globe.png"
 * alt="World coordinate-system diagram." border="0" /></center>
 * </p>
 *
 * <p>
 * <hr>
 * <p>
 * By definition:
 * <p>
 * [0 0 g] = <b>R</b> * <b>gravity</b> (g = magnitude of gravity)
 * <p>
 * [0 m 0] = <b>I</b> * <b>R</b> * <b>geomagnetic</b> (m = magnitude of
 * geomagnetic field)
 * <p>
 * <b>R</b> is the identity matrix when the device is aligned with the
 * world's coordinate system, that is, when the device's X axis points
 * toward East, the Y axis points to the North Pole and the device is facing
 * the sky.
 *
 * <p>
 * <b>I</b> is a rotation matrix transforming the geomagnetic vector into
 * the same coordinate space as gravity (the world's coordinate space).
 * <b>I</b> is a simple rotation around the X axis. The inclination angle in
 * radians can be computed with {@link #getInclination}.
 * <hr>
 *
 * <p>
 * Each matrix is returned either as a 3x3 or 4x4 row-major matrix depending
 * on the length of the passed array:
 * <p>
 * <u>If the array length is 16:</u>
 *
 * <pre>
 *   /  M[ 0]   M[ 1]   M[ 2]   M[ 3]  \
 *   |  M[ 4]   M[ 5]   M[ 6]   M[ 7]  |
 *   |  M[ 8]   M[ 9]   M[10]   M[11]  |
 *   \  M[12]   M[13]   M[14]   M[15]  /
 *</pre>
 *
 * This matrix is ready to be used by OpenGL ES's
 * {@link javax.microedition.khronos.opengles.GL10#glLoadMatrixf(float[], int)
 * glLoadMatrixf(float[], int)}.
 * <p>
 * Note that because OpenGL matrices are column-major matrices you must
 * transpose the matrix before using it. However, since the matrix is a
 * rotation matrix, its transpose is also its inverse, conveniently, it is
 * often the inverse of the rotation that is needed for rendering; it can
 * therefore be used with OpenGL ES directly.
 * <p>
 * Also note that the returned matrices always have this form:
 *
 * <pre>
 *   /  M[ 0]   M[ 1]   M[ 2]   0  \
 *   |  M[ 4]   M[ 5]   M[ 6]   0  |
 *   |  M[ 8]   M[ 9]   M[10]   0  |
 *   \      0       0       0   1  /
 *</pre>
 *
 * <p>
 * <u>If the array length is 9:</u>
 *
 * <pre>
 *   /  M[ 0]   M[ 1]   M[ 2]  \
 *   |  M[ 3]   M[ 4]   M[ 5]  |
 *   \  M[ 6]   M[ 7]   M[ 8]  /
 *</pre>
 *
 * <hr>
 * <p>
 * The inverse of each matrix can be computed easily by taking its
 * transpose.
 *
 * <p>
 * The matrices returned by this function are meaningful only when the
 * device is not free-falling and it is not close to the magnetic north. If
 * the device is accelerating, or placed into a strong magnetic field, the
 * returned matrices may be inaccurate.
 *
 * @param R
 *        is an array of 9 floats holding the rotation matrix <b>R</b> when
 *        this function returns. R can be null.
 *        <p>
 *
 * @param I
 *        is an array of 9 floats holding the rotation matrix <b>I</b> when
 *        this function returns. I can be null.
 *        <p>
 *
 * @param gravity
 *        is an array of 3 floats containing the gravity vector expressed in
 *        the device's coordinate. You can simply use the
 *        {@link android.hardware.SensorEvent#values values} returned by a
 *        {@link android.hardware.SensorEvent SensorEvent} of a
 *        {@link android.hardware.Sensor Sensor} of type
 *        {@link android.hardware.Sensor#TYPE_ACCELEROMETER
 *        TYPE_ACCELEROMETER}.
 *        <p>
 *
 * @param geomagnetic
 *        is an array of 3 floats containing the geomagnetic vector
 *        expressed in the device's coordinate. You can simply use the
 *        {@link android.hardware.SensorEvent#values values} returned by a
 *        {@link android.hardware.SensorEvent SensorEvent} of a
 *        {@link android.hardware.Sensor Sensor} of type
 *        {@link android.hardware.Sensor#TYPE_MAGNETIC_FIELD
 *        TYPE_MAGNETIC_FIELD}.
 *
 * @return <code>true</code> on success, <code>false</code> on failure (for
 *         instance, if the device is in free fall). Free fall is defined as
 *         condition when the magnitude of the gravity is less than 1/10 of
 *         the nominal value. On failure the output matrices are not modified.
 *
 * @see #getInclination(float[])
 * @see #getOrientation(float[], float[])
 * @see #remapCoordinateSystem(float[], int, int, float[])
 * @apiSince 3
 */

public static boolean getRotationMatrix(float[] R, float[] I, float[] gravity, float[] geomagnetic) { throw new RuntimeException("Stub!"); }

/**
 * Computes the geomagnetic inclination angle in radians from the
 * inclination matrix <b>I</b> returned by {@link #getRotationMatrix}.
 *
 * @param I
 *        inclination matrix see {@link #getRotationMatrix}.
 *
 * @return The geomagnetic inclination angle in radians.
 *
 * @see #getRotationMatrix(float[], float[], float[], float[])
 * @see #getOrientation(float[], float[])
 * @see android.hardware.GeomagneticField
 *
 * @apiSince 3
 */

public static float getInclination(float[] I) { throw new RuntimeException("Stub!"); }

/**
 * <p>
 * Rotates the supplied rotation matrix so it is expressed in a different
 * coordinate system. This is typically used when an application needs to
 * compute the three orientation angles of the device (see
 * {@link #getOrientation}) in a different coordinate system.
 * </p>
 *
 * <p>
 * When the rotation matrix is used for drawing (for instance with OpenGL
 * ES), it usually <b>doesn't need</b> to be transformed by this function,
 * unless the screen is physically rotated, in which case you can use
 * {@link android.view.Display#getRotation() Display.getRotation()} to
 * retrieve the current rotation of the screen. Note that because the user
 * is generally free to rotate their screen, you often should consider the
 * rotation in deciding the parameters to use here.
 * </p>
 *
 * <p>
 * <u>Examples:</u>
 * <p>
 *
 * <ul>
 * <li>Using the camera (Y axis along the camera's axis) for an augmented
 * reality application where the rotation angles are needed:</li>
 *
 * <p>
 * <ul>
 * <code>remapCoordinateSystem(inR, AXIS_X, AXIS_Z, outR);</code>
 * </ul>
 * </p>
 *
 * <li>Using the device as a mechanical compass when rotation is
 * {@link android.view.Surface#ROTATION_90 Surface.ROTATION_90}:</li>
 *
 * <p>
 * <ul>
 * <code>remapCoordinateSystem(inR, AXIS_Y, AXIS_MINUS_X, outR);</code>
 * </ul>
 * </p>
 *
 * Beware of the above example. This call is needed only to account for a
 * rotation from its natural orientation when calculating the rotation
 * angles (see {@link #getOrientation}). If the rotation matrix is also used
 * for rendering, it may not need to be transformed, for instance if your
 * {@link android.app.Activity Activity} is running in landscape mode.
 * </ul>
 *
 * <p>
 * Since the resulting coordinate system is orthonormal, only two axes need
 * to be specified.
 *
 * @param inR
 *        the rotation matrix to be transformed. Usually it is the matrix
 *        returned by {@link #getRotationMatrix}.
 *
 * @param X
 *        defines the axis of the new cooridinate system that coincide with the X axis of the
 *        original coordinate system.
 *
 * @param Y
 *        defines the axis of the new cooridinate system that coincide with the Y axis of the
 *        original coordinate system.
 *
 * @param outR
 *        the transformed rotation matrix. inR and outR should not be the same
 *        array.
 *
 * @return <code>true</code> on success. <code>false</code> if the input
 *         parameters are incorrect, for instance if X and Y define the same
 *         axis. Or if inR and outR don't have the same length.
 *
 * @see #getRotationMatrix(float[], float[], float[], float[])
 * @apiSince 3
 */

public static boolean remapCoordinateSystem(float[] inR, int X, int Y, float[] outR) { throw new RuntimeException("Stub!"); }

/**
 * Computes the device's orientation based on the rotation matrix.
 * <p>
 * When it returns, the array values are as follows:
 * <ul>
 * <li>values[0]: <i>Azimuth</i>, angle of rotation about the -z axis.
 *                This value represents the angle between the device's y
 *                axis and the magnetic north pole. When facing north, this
 *                angle is 0, when facing south, this angle is &pi;.
 *                Likewise, when facing east, this angle is &pi;/2, and
 *                when facing west, this angle is -&pi;/2. The range of
 *                values is -&pi; to &pi;.</li>
 * <li>values[1]: <i>Pitch</i>, angle of rotation about the x axis.
 *                This value represents the angle between a plane parallel
 *                to the device's screen and a plane parallel to the ground.
 *                Assuming that the bottom edge of the device faces the
 *                user and that the screen is face-up, tilting the top edge
 *                of the device toward the ground creates a positive pitch
 *                angle. The range of values is -&pi; to &pi;.</li>
 * <li>values[2]: <i>Roll</i>, angle of rotation about the y axis. This
 *                value represents the angle between a plane perpendicular
 *                to the device's screen and a plane perpendicular to the
 *                ground. Assuming that the bottom edge of the device faces
 *                the user and that the screen is face-up, tilting the left
 *                edge of the device toward the ground creates a positive
 *                roll angle. The range of values is -&pi;/2 to &pi;/2.</li>
 * </ul>
 * <p>
 * Applying these three rotations in the azimuth, pitch, roll order
 * transforms an identity matrix to the rotation matrix passed into this
 * method. Also, note that all three orientation angles are expressed in
 * <b>radians</b>.
 *
 * @param R
 *        rotation matrix see {@link #getRotationMatrix}.
 *
 * @param values
 *        an array of 3 floats to hold the result.
 *
 * @return The array values passed as argument.
 *
 * @see #getRotationMatrix(float[], float[], float[], float[])
 * @see android.hardware.GeomagneticField
 * @apiSince 3
 */

public static float[] getOrientation(float[] R, float[] values) { throw new RuntimeException("Stub!"); }

/**
 * Computes the Altitude in meters from the atmospheric pressure and the
 * pressure at sea level.
 * <p>
 * Typically the atmospheric pressure is read from a
 * {@link android.hardware.Sensor#TYPE_PRESSURE Sensor#TYPE_PRESSURE} sensor. The pressure at sea level must be
 * known, usually it can be retrieved from airport databases in the
 * vicinity. If unknown, you can use {@link #PRESSURE_STANDARD_ATMOSPHERE}
 * as an approximation, but absolute altitudes won't be accurate.
 * </p>
 * <p>
 * To calculate altitude differences, you must calculate the difference
 * between the altitudes at both points. If you don't know the altitude
 * as sea level, you can use {@link #PRESSURE_STANDARD_ATMOSPHERE} instead,
 * which will give good results considering the range of pressure typically
 * involved.
 * </p>
 * <p>
 * <code><ul>
 *  float altitude_difference =
 *      getAltitude(SensorManager.PRESSURE_STANDARD_ATMOSPHERE, pressure_at_point2)
 *      - getAltitude(SensorManager.PRESSURE_STANDARD_ATMOSPHERE, pressure_at_point1);
 * </ul></code>
 * </p>
 *
 * @param p0 pressure at sea level
 * @param p atmospheric pressure
 * @return Altitude in meters
 * @apiSince 9
 */

public static float getAltitude(float p0, float p) { throw new RuntimeException("Stub!"); }

/** Helper function to compute the angle change between two rotation matrices.
 *  Given a current rotation matrix (R) and a previous rotation matrix
 *  (prevR) computes the intrinsic rotation around the z, x, and y axes which
 *  transforms prevR to R.
 *  outputs a 3 element vector containing the z, x, and y angle
 *  change at indexes 0, 1, and 2 respectively.
 * <p> Each input matrix is either as a 3x3 or 4x4 row-major matrix
 * depending on the length of the passed array:
 * <p>If the array length is 9, then the array elements represent this matrix
 * <pre>
 *   /  R[ 0]   R[ 1]   R[ 2]   \
 *   |  R[ 3]   R[ 4]   R[ 5]   |
 *   \  R[ 6]   R[ 7]   R[ 8]   /
 *</pre>
 * <p>If the array length is 16, then the array elements represent this matrix
 * <pre>
 *   /  R[ 0]   R[ 1]   R[ 2]   R[ 3]  \
 *   |  R[ 4]   R[ 5]   R[ 6]   R[ 7]  |
 *   |  R[ 8]   R[ 9]   R[10]   R[11]  |
 *   \  R[12]   R[13]   R[14]   R[15]  /
 *</pre>
 *
 * See {@link #getOrientation} for more detailed definition of the output.
 *
 * @param R current rotation matrix
 * @param prevR previous rotation matrix
 * @param angleChange an an array of floats (z, x, and y) in which the angle change
 *        (in radians) is stored
 * @apiSince 9
 */

public static void getAngleChange(float[] angleChange, float[] R, float[] prevR) { throw new RuntimeException("Stub!"); }

/** Helper function to convert a rotation vector to a rotation matrix.
 *  Given a rotation vector (presumably from a ROTATION_VECTOR sensor), returns a
 *  9  or 16 element rotation matrix in the array R.  R must have length 9 or 16.
 *  If R.length == 9, the following matrix is returned:
 * <pre>
 *   /  R[ 0]   R[ 1]   R[ 2]   \
 *   |  R[ 3]   R[ 4]   R[ 5]   |
 *   \  R[ 6]   R[ 7]   R[ 8]   /
 *</pre>
 * If R.length == 16, the following matrix is returned:
 * <pre>
 *   /  R[ 0]   R[ 1]   R[ 2]   0  \
 *   |  R[ 4]   R[ 5]   R[ 6]   0  |
 *   |  R[ 8]   R[ 9]   R[10]   0  |
 *   \  0       0       0       1  /
 *</pre>
 *  @param rotationVector the rotation vector to convert
 *  @param R an array of floats in which to store the rotation matrix
 * @apiSince 9
 */

public static void getRotationMatrixFromVector(float[] R, float[] rotationVector) { throw new RuntimeException("Stub!"); }

/** Helper function to convert a rotation vector to a normalized quaternion.
 *  Given a rotation vector (presumably from a ROTATION_VECTOR sensor), returns a normalized
 *  quaternion in the array Q.  The quaternion is stored as [w, x, y, z]
 *  @param rv the rotation vector to convert
 *  @param Q an array of floats in which to store the computed quaternion
 * @apiSince 9
 */

public static void getQuaternionFromVector(float[] Q, float[] rv) { throw new RuntimeException("Stub!"); }

/**
 * Requests receiving trigger events for a trigger sensor.
 *
 * <p>
 * When the sensor detects a trigger event condition, such as significant motion in
 * the case of the {@link android.hardware.Sensor#TYPE_SIGNIFICANT_MOTION Sensor#TYPE_SIGNIFICANT_MOTION}, the provided trigger listener
 * will be invoked once and then its request to receive trigger events will be canceled.
 * To continue receiving trigger events, the application must request to receive trigger
 * events again.
 * </p>
 *
 * @param listener The listener on which the
 *        {@link android.hardware.TriggerEventListener#onTrigger(android.hardware.TriggerEvent) TriggerEventListener#onTrigger(TriggerEvent)} will be delivered.
 * @param sensor The sensor to be enabled.
 *
 * @return true if the sensor was successfully enabled.
 *
 * @throws java.lang.IllegalArgumentException when sensor is null or not a trigger sensor.
 * @apiSince 18
 */

public boolean requestTriggerSensor(android.hardware.TriggerEventListener listener, android.hardware.Sensor sensor) { throw new RuntimeException("Stub!"); }

/**
 * Cancels receiving trigger events for a trigger sensor.
 *
 * <p>
 * Note that a Trigger sensor will be auto disabled if
 * {@link android.hardware.TriggerEventListener#onTrigger(android.hardware.TriggerEvent) TriggerEventListener#onTrigger(TriggerEvent)} has triggered.
 * This method is provided in case the user wants to explicitly cancel the request
 * to receive trigger events.
 * </p>
 *
 * @param listener The listener on which the
 *        {@link android.hardware.TriggerEventListener#onTrigger(android.hardware.TriggerEvent) TriggerEventListener#onTrigger(TriggerEvent)}
 *        is delivered.It should be the same as the one used
 *        in {@link #requestTriggerSensor(android.hardware.TriggerEventListener,android.hardware.Sensor)}
 * @param sensor The sensor for which the trigger request should be canceled.
 *        If null, it cancels receiving trigger for all sensors associated
 *        with the listener.
 *
 * @return true if successfully canceled.
 *
 * @throws java.lang.IllegalArgumentException when sensor is a trigger sensor.
 * @apiSince 18
 */

public boolean cancelTriggerSensor(android.hardware.TriggerEventListener listener, android.hardware.Sensor sensor) { throw new RuntimeException("Stub!"); }

/**
 * see {@link #remapCoordinateSystem}
 * @apiSince 3
 */

public static final int AXIS_MINUS_X = 129; // 0x81

/**
 * see {@link #remapCoordinateSystem}
 * @apiSince 3
 */

public static final int AXIS_MINUS_Y = 130; // 0x82

/**
 * see {@link #remapCoordinateSystem}
 * @apiSince 3
 */

public static final int AXIS_MINUS_Z = 131; // 0x83

/**
 * see {@link #remapCoordinateSystem}
 * @apiSince 3
 */

public static final int AXIS_X = 1; // 0x1

/**
 * see {@link #remapCoordinateSystem}
 * @apiSince 3
 */

public static final int AXIS_Y = 2; // 0x2

/**
 * see {@link #remapCoordinateSystem}
 * @apiSince 3
 */

public static final int AXIS_Z = 3; // 0x3

/**
 * Index of the X value in the array returned by
 * {@link android.hardware.SensorListener#onSensorChanged}
 *
 * @deprecated use {@link android.hardware.Sensor Sensor} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int DATA_X = 0; // 0x0

/**
 * Index of the Y value in the array returned by
 * {@link android.hardware.SensorListener#onSensorChanged}
 *
 * @deprecated use {@link android.hardware.Sensor Sensor} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int DATA_Y = 1; // 0x1

/**
 * Index of the Z value in the array returned by
 * {@link android.hardware.SensorListener#onSensorChanged}
 *
 * @deprecated use {@link android.hardware.Sensor Sensor} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int DATA_Z = 2; // 0x2

/**
 * Gravity (estimate) on the first Death Star in Empire units (m/s^2)
 * @apiSince 1
 */

public static final float GRAVITY_DEATH_STAR_I = 3.5303614E-7f;

/**
 * Earth's gravity in SI units (m/s^2)
 * @apiSince 1
 */

public static final float GRAVITY_EARTH = 9.80665f;

/**
 * Jupiter's gravity in SI units (m/s^2)
 * @apiSince 1
 */

public static final float GRAVITY_JUPITER = 23.12f;

/**
 * Mars' gravity in SI units (m/s^2)
 * @apiSince 1
 */

public static final float GRAVITY_MARS = 3.71f;

/**
 * Mercury's gravity in SI units (m/s^2)
 * @apiSince 1
 */

public static final float GRAVITY_MERCURY = 3.7f;

/**
 * The Moon's gravity in SI units (m/s^2)
 * @apiSince 1
 */

public static final float GRAVITY_MOON = 1.6f;

/**
 * Neptune's gravity in SI units (m/s^2)
 * @apiSince 1
 */

public static final float GRAVITY_NEPTUNE = 11.0f;

/**
 * Pluto's gravity in SI units (m/s^2)
 * @apiSince 1
 */

public static final float GRAVITY_PLUTO = 0.6f;

/**
 * Saturn's gravity in SI units (m/s^2)
 * @apiSince 1
 */

public static final float GRAVITY_SATURN = 8.96f;

/**
 * Sun's gravity in SI units (m/s^2)
 * @apiSince 1
 */

public static final float GRAVITY_SUN = 275.0f;

/**
 * Gravity on the island
 * @apiSince 1
 */

public static final float GRAVITY_THE_ISLAND = 4.815162f;

/**
 * Uranus' gravity in SI units (m/s^2)
 * @apiSince 1
 */

public static final float GRAVITY_URANUS = 8.69f;

/**
 * Venus' gravity in SI units (m/s^2)
 * @apiSince 1
 */

public static final float GRAVITY_VENUS = 8.87f;

/**
 * luminance under a cloudy sky in lux
 * @apiSince 1
 */

public static final float LIGHT_CLOUDY = 100.0f;

/**
 * luminance at night with full moon in lux
 * @apiSince 1
 */

public static final float LIGHT_FULLMOON = 0.25f;

/**
 * luminance at night with no moon in lux
 * @apiSince 1
 */

public static final float LIGHT_NO_MOON = 0.001f;

/**
 * luminance under an overcast sky in lux
 * @apiSince 1
 */

public static final float LIGHT_OVERCAST = 10000.0f;

/**
 * luminance in shade in lux
 * @apiSince 1
 */

public static final float LIGHT_SHADE = 20000.0f;

/**
 * luminance of sunlight in lux
 * @apiSince 1
 */

public static final float LIGHT_SUNLIGHT = 110000.0f;

/**
 * Maximum luminance of sunlight in lux
 * @apiSince 1
 */

public static final float LIGHT_SUNLIGHT_MAX = 120000.0f;

/**
 * luminance at sunrise in lux
 * @apiSince 1
 */

public static final float LIGHT_SUNRISE = 400.0f;

/**
 * Maximum magnetic field on Earth's surface
 * @apiSince 1
 */

public static final float MAGNETIC_FIELD_EARTH_MAX = 60.0f;

/**
 * Minimum magnetic field on Earth's surface
 * @apiSince 1
 */

public static final float MAGNETIC_FIELD_EARTH_MIN = 30.0f;

/**
 * Standard atmosphere, or average sea-level pressure in hPa (millibar)
 * @apiSince 9
 */

public static final float PRESSURE_STANDARD_ATMOSPHERE = 1013.25f;

/**
 * Offset to the untransformed values in the array returned by
 * {@link android.hardware.SensorListener#onSensorChanged}
 *
 * @deprecated use {@link android.hardware.Sensor Sensor} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int RAW_DATA_INDEX = 3; // 0x3

/**
 * Index of the untransformed X value in the array returned by
 * {@link android.hardware.SensorListener#onSensorChanged}
 *
 * @deprecated use {@link android.hardware.Sensor Sensor} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int RAW_DATA_X = 3; // 0x3

/**
 * Index of the untransformed Y value in the array returned by
 * {@link android.hardware.SensorListener#onSensorChanged}
 *
 * @deprecated use {@link android.hardware.Sensor Sensor} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int RAW_DATA_Y = 4; // 0x4

/**
 * Index of the untransformed Z value in the array returned by
 * {@link android.hardware.SensorListener#onSensorChanged}
 *
 * @deprecated use {@link android.hardware.Sensor Sensor} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int RAW_DATA_Z = 5; // 0x5

/**
 * A constant describing an accelerometer. See
 * {@link android.hardware.SensorListener SensorListener} for more details.
 *
 * @deprecated use {@link android.hardware.Sensor Sensor} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int SENSOR_ACCELEROMETER = 2; // 0x2

/**
 * A constant that includes all sensors
 *
 * @deprecated use {@link android.hardware.Sensor Sensor} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int SENSOR_ALL = 127; // 0x7f

/**
 * get sensor data as fast as possible
 * @apiSince 1
 */

public static final int SENSOR_DELAY_FASTEST = 0; // 0x0

/**
 * rate suitable for games
 * @apiSince 1
 */

public static final int SENSOR_DELAY_GAME = 1; // 0x1

/**
 * rate (default) suitable for screen orientation changes
 * @apiSince 1
 */

public static final int SENSOR_DELAY_NORMAL = 3; // 0x3

/**
 * rate suitable for the user interface
 * @apiSince 1
 */

public static final int SENSOR_DELAY_UI = 2; // 0x2

/**
 * A constant describing an ambient light sensor See
 * {@link android.hardware.SensorListener SensorListener} for more details.
 *
 * @deprecated use {@link android.hardware.Sensor Sensor} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int SENSOR_LIGHT = 16; // 0x10

/**
 * A constant describing a magnetic sensor See
 * {@link android.hardware.SensorListener SensorListener} for more details.
 *
 * @deprecated use {@link android.hardware.Sensor Sensor} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int SENSOR_MAGNETIC_FIELD = 8; // 0x8

/**
 * Largest sensor ID
 *
 * @deprecated use {@link android.hardware.Sensor Sensor} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int SENSOR_MAX = 64; // 0x40

/**
 * Smallest sensor ID
 *
 * @deprecated use {@link android.hardware.Sensor Sensor} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int SENSOR_MIN = 1; // 0x1

/**
 * A constant describing an orientation sensor. See
 * {@link android.hardware.SensorListener SensorListener} for more details.
 *
 * @deprecated use {@link android.hardware.Sensor Sensor} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int SENSOR_ORIENTATION = 1; // 0x1

/**
 * A constant describing an orientation sensor. See
 * {@link android.hardware.SensorListener SensorListener} for more details.
 *
 * @deprecated use {@link android.hardware.Sensor Sensor} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int SENSOR_ORIENTATION_RAW = 128; // 0x80

/**
 * A constant describing a proximity sensor See
 * {@link android.hardware.SensorListener SensorListener} for more details.
 *
 * @deprecated use {@link android.hardware.Sensor Sensor} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int SENSOR_PROXIMITY = 32; // 0x20

/**
 * This sensor is reporting data with maximum accuracy
 * @apiSince 1
 */

public static final int SENSOR_STATUS_ACCURACY_HIGH = 3; // 0x3

/**
 * This sensor is reporting data with low accuracy, calibration with the
 * environment is needed
 * @apiSince 1
 */

public static final int SENSOR_STATUS_ACCURACY_LOW = 1; // 0x1

/**
 * This sensor is reporting data with an average level of accuracy,
 * calibration with the environment may improve the readings
 * @apiSince 1
 */

public static final int SENSOR_STATUS_ACCURACY_MEDIUM = 2; // 0x2

/**
 * The values returned by this sensor cannot be trusted because the sensor
 * had no contact with what it was measuring (for example, the heart rate
 * monitor is not in contact with the user).
 * @apiSince 20
 */

public static final int SENSOR_STATUS_NO_CONTACT = -1; // 0xffffffff

/**
 * The values returned by this sensor cannot be trusted, calibration is
 * needed or the environment doesn't allow readings
 * @apiSince 1
 */

public static final int SENSOR_STATUS_UNRELIABLE = 0; // 0x0

/**
 * A constant describing a temperature sensor See
 * {@link android.hardware.SensorListener SensorListener} for more details.
 *
 * @deprecated use {@link android.hardware.Sensor Sensor} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int SENSOR_TEMPERATURE = 4; // 0x4

/**
 * A constant describing a Tricorder See
 * {@link android.hardware.SensorListener SensorListener} for more details.
 *
 * @deprecated use {@link android.hardware.Sensor Sensor} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int SENSOR_TRICORDER = 64; // 0x40

/**
 * Standard gravity (g) on Earth. This value is equivalent to 1G
 * @apiSince 1
 */

public static final float STANDARD_GRAVITY = 9.80665f;
/**
 * Used for receiving notifications from the SensorManager when dynamic sensors are connected or
 * disconnected.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class DynamicSensorCallback {

public DynamicSensorCallback() { throw new RuntimeException("Stub!"); }

/**
 * Called when there is a dynamic sensor being connected to the system.
 *
 * @param sensor the newly connected sensor. See {@link android.hardware.Sensor Sensor}.
 * @apiSince 24
 */

public void onDynamicSensorConnected(android.hardware.Sensor sensor) { throw new RuntimeException("Stub!"); }

/**
 * Called when there is a dynamic sensor being disconnected from the system.
 *
 * @param sensor the disconnected sensor. See {@link android.hardware.Sensor Sensor}.
 * @apiSince 24
 */

public void onDynamicSensorDisconnected(android.hardware.Sensor sensor) { throw new RuntimeException("Stub!"); }
}

}

