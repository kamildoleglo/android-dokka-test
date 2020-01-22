/*
 * Copyright (C) 2015 The Android Open Source Project
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

package android.os;


/**
 * The HardwarePropertiesManager class provides a mechanism of accessing hardware state of a
 * device: CPU, GPU and battery temperatures, CPU usage per core, fan speed, etc.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class HardwarePropertiesManager {

HardwarePropertiesManager() { throw new RuntimeException("Stub!"); }

/**
 * Return an array of device temperatures in Celsius.
 *
 * @param type type of requested device temperature, one of {@link #DEVICE_TEMPERATURE_CPU},
 * {@link #DEVICE_TEMPERATURE_GPU}, {@link #DEVICE_TEMPERATURE_BATTERY} or {@link
 * #DEVICE_TEMPERATURE_SKIN}.
 * Value is {@link android.os.HardwarePropertiesManager#DEVICE_TEMPERATURE_CPU}, {@link android.os.HardwarePropertiesManager#DEVICE_TEMPERATURE_GPU}, {@link android.os.HardwarePropertiesManager#DEVICE_TEMPERATURE_BATTERY}, or {@link android.os.HardwarePropertiesManager#DEVICE_TEMPERATURE_SKIN}
 * @param source source of requested device temperature, one of {@link #TEMPERATURE_CURRENT},
 * {@link #TEMPERATURE_THROTTLING}, {@link #TEMPERATURE_THROTTLING_BELOW_VR_MIN} or
 * {@link #TEMPERATURE_SHUTDOWN}.
 * Value is {@link android.os.HardwarePropertiesManager#TEMPERATURE_CURRENT}, {@link android.os.HardwarePropertiesManager#TEMPERATURE_THROTTLING}, {@link android.os.HardwarePropertiesManager#TEMPERATURE_SHUTDOWN}, or {@link android.os.HardwarePropertiesManager#TEMPERATURE_THROTTLING_BELOW_VR_MIN}
 * @return an array of requested float device temperatures. Temperature equals to
 *         {@link #UNDEFINED_TEMPERATURE} if undefined.
 *         Empty if platform doesn't provide the queried temperature.
 *
 * This value will never be {@code null}.
 * @throws java.lang.SecurityException if something other than the device owner or the current VR service
 *         tries to retrieve information provided by this service.
 * @apiSince 24
 */

@androidx.annotation.NonNull
public float[] getDeviceTemperatures(int type, int source) { throw new RuntimeException("Stub!"); }

/**
 * Return an array of CPU usage info for each core.
 *
 * @return an array of {@link android.os.CpuUsageInfo} for each core. Return {@code null} for
 *         each unplugged core.
 *         Empty if CPU usage is not supported on this system.
 *
 * @throws java.lang.SecurityException if something other than the device owner or the current VR service
 *         tries to retrieve information provided by this service.
 * @apiSince 24
 */

@androidx.annotation.NonNull
public android.os.CpuUsageInfo[] getCpuUsages() { throw new RuntimeException("Stub!"); }

/**
 * Return an array of fan speeds in RPM.
 *
 * @return an array of float fan speeds in RPM. Empty if there are no fans or fan speed is not
 * supported on this system.
 *
 * This value will never be {@code null}.
 * @throws java.lang.SecurityException if something other than the device owner or the current VR service
 *         tries to retrieve information provided by this service.
 * @apiSince 24
 */

@androidx.annotation.NonNull
public float[] getFanSpeeds() { throw new RuntimeException("Stub!"); }

/**
 * Temperature of battery in Celsius.
 * @apiSince 24
 */

public static final int DEVICE_TEMPERATURE_BATTERY = 2; // 0x2

/**
 * Temperature of CPUs in Celsius.
 * @apiSince 24
 */

public static final int DEVICE_TEMPERATURE_CPU = 0; // 0x0

/**
 * Temperature of GPUs in Celsius.
 * @apiSince 24
 */

public static final int DEVICE_TEMPERATURE_GPU = 1; // 0x1

/**
 * Temperature of device skin in Celsius.
 * @apiSince 24
 */

public static final int DEVICE_TEMPERATURE_SKIN = 3; // 0x3

/**
 * Get current temperature.
 * @apiSince 24
 */

public static final int TEMPERATURE_CURRENT = 0; // 0x0

/**
 * Get shutdown temperature threshold.
 * @apiSince 24
 */

public static final int TEMPERATURE_SHUTDOWN = 2; // 0x2

/**
 * Get throttling temperature threshold.
 * @apiSince 24
 */

public static final int TEMPERATURE_THROTTLING = 1; // 0x1

/**
 * Get throttling temperature threshold above which minimum clockrates for VR mode will not be
 * met.
 * @apiSince 24
 */

public static final int TEMPERATURE_THROTTLING_BELOW_VR_MIN = 3; // 0x3

/**
 * Undefined temperature constant.
 * @apiSince 24
 */

public static final float UNDEFINED_TEMPERATURE = -3.4028235E38f;
}

