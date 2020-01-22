/*
 * Copyright (C) 2017 The Android Open Source Project
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

import android.os.MemoryFile;

/**
 * Class representing a sensor direct channel. Use
 * {@link android.hardware.SensorManager#createDirectChannel(android.os.MemoryFile) SensorManager#createDirectChannel(android.os.MemoryFile)} or
 * {@link android.hardware.SensorManager#createDirectChannel(android.hardware.HardwareBuffer) SensorManager#createDirectChannel(android.hardware.HardwareBuffer)}
 * to obtain an object. The channel object can be then configured
 * (see {@link #configure(android.hardware.Sensor,int)})
 * to start delivery of sensor events into shared memory buffer.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SensorDirectChannel implements java.nio.channels.Channel {

SensorDirectChannel() { throw new RuntimeException("Stub!"); }

/**
 * Determine if a channel is still valid. A channel is invalidated after {@link #close()} is
 * called.
 *
 * @return <code>true</code> if channel is valid.
 * @apiSince 26
 */

public boolean isOpen() { throw new RuntimeException("Stub!"); }

/**
 * Close sensor direct channel.
 *
 * Stop all active sensor in the channel and free sensor system resource related to channel.
 * Shared memory used for creating the direct channel need to be closed or freed separately.
 *
 * @see android.hardware.SensorManager#createDirectChannel(MemoryFile)
 * @see android.hardware.SensorManager#createDirectChannel(HardwareBuffer)
 * @apiSince 26
 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * Configure sensor rate or stop sensor report.
 *
 * To start event report of a sensor, or change rate of existing report, call this function with
 * rateLevel other than {@link android.hardware.SensorDirectChannel#RATE_STOP}. Sensor events
 * will be added into a queue formed by the shared memory used in creation of direction channel.
 * Each element of the queue has size of 104 bytes and represents a sensor event. Data
 * structure of an element (all fields in little-endian):
 *
 * <pre>
 *   offset   type                    name
 * ------------------------------------------------------------------------
 *   0x0000   int32_t                 size (always 104)
 *   0x0004   int32_t                 sensor report token
 *   0x0008   int32_t                 type (see SensorType)
 *   0x000C   uint32_t                atomic counter
 *   0x0010   int64_t                 timestamp (see Event)
 *   0x0018   float[16]/int64_t[8]    data (data type depends on sensor type)
 *   0x0058   int32_t[4]              reserved (set to zero)
 * </pre>
 *
 * There are no head or tail pointers. The sequence and frontier of new sensor events is
 * determined by the atomic counter, which counts from 1 after creation of direct channel and
 * increments 1 for each new event. Atomic counter will wrap back to 1 after it reaches
 * UINT32_MAX, skipping value 0 to avoid confusion with uninitialized memory. The writer in
 * sensor system will wrap around from the start of shared memory region when it reaches the
 * end. If size of memory region is not a multiple of size of element (104 bytes), the residual
 * is not used at the end.  Function returns a positive sensor report token on success. This
 * token can be used to differentiate sensor events from multiple sensor of the same type. For
 * example, if there are two accelerometers in the system A and B, it is guaranteed different
 * report tokens will be returned when starting sensor A and B.
 *
 * To stop a sensor, call this function with rateLevel equal {@link
 * android.hardware.SensorDirectChannel#RATE_STOP}. If the sensor parameter is left to be null,
 * this will stop all active sensor report associated with the direct channel specified.
 * Function return 1 on success or 0 on failure.
 *
 * @param sensor A {@link android.hardware.Sensor} object to denote sensor to be operated.
 * @param rateLevel rate level defined in {@link android.hardware.SensorDirectChannel}.
 * Value is either <code>0</code> or a combination of {@link android.hardware.SensorDirectChannel#RATE_STOP}, {@link android.hardware.SensorDirectChannel#RATE_NORMAL}, {@link android.hardware.SensorDirectChannel#RATE_FAST}, and {@link android.hardware.SensorDirectChannel#RATE_VERY_FAST}
 * @return * starting report or changing rate: positive sensor report token on success,
 *                                             0 on failure;
 *         * stopping report: 1 on success, 0 on failure.
 * @throws java.lang.NullPointerException when channel is null.
 * @apiSince 26
 */

public int configure(android.hardware.Sensor sensor, int rateLevel) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Sensor operates at nominal rate of 200Hz.
 *
 * The actual rate is expected to be between 55% to 220% of nominal rate, thus between 110Hz to
 * 440Hz.
 *
 * @see #configure(Sensor, int)
 * @apiSince 26
 */

public static final int RATE_FAST = 2; // 0x2

/**
 * Sensor operates at nominal rate of 50Hz.
 *
 * The actual rate is expected to be between 55% to 220% of nominal rate, thus between 27.5Hz to
 * 110Hz.
 *
 * @see #configure(Sensor, int)
 * @apiSince 26
 */

public static final int RATE_NORMAL = 1; // 0x1

/**
 * Sensor stopped (no event output).
 *
 * @see #configure(Sensor, int)
 * @apiSince 26
 */

public static final int RATE_STOP = 0; // 0x0

/**
 * Sensor operates at nominal rate of 800Hz.
 *
 * The actual rate is expected to be between 55% to 220% of nominal rate, thus between 440Hz to
 * 1760Hz.
 *
 * @see #configure(Sensor, int)
 * @apiSince 26
 */

public static final int RATE_VERY_FAST = 3; // 0x3

/**
 * Shared memory type wrapped by HardwareBuffer object.
 *
 * @see android.hardware.SensorManager#createDirectChannel(HardwareBuffer)
 * @apiSince 26
 */

public static final int TYPE_HARDWARE_BUFFER = 2; // 0x2

/**
 * Shared memory type ashmem, wrapped in MemoryFile object.
 *
 * @see android.hardware.SensorManager#createDirectChannel(MemoryFile)
 * @apiSince 26
 */

public static final int TYPE_MEMORY_FILE = 1; // 0x1
}

