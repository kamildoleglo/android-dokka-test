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


package android.hardware;


/**
 * This class represents a {@link android.hardware.Sensor Sensor} additional information frame,
 * which is reported through listener callback {@link
 * android.hardware.SensorEventCallback#onSensorAdditionalInfo onSensorAdditionalInfo}.
 *
 * @see android.hardware.SensorManager
 * @see android.hardware.SensorEventCallback
 * @see android.hardware.Sensor
 *
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SensorAdditionalInfo {

SensorAdditionalInfo() { throw new RuntimeException("Stub!"); }

/**
 * Mark the beginning of a set of additional info frames.
 * @apiSince 24
 */

public static final int TYPE_FRAME_BEGIN = 0; // 0x0

/**
 * Mark the end of a set of additional info frames.
 * @apiSince 24
 */

public static final int TYPE_FRAME_END = 1; // 0x1

/**
 * Internal temperature. Sensor hardware device internal temperature.
 *
 * Payload:
 *     floatValues[0]: internal temperature in Celsius.
 * @apiSince 24
 */

public static final int TYPE_INTERNAL_TEMPERATURE = 65537; // 0x10001

/**
 * Sampling parameter. Describes the raw sample period and estimated jitter of sample time in
 * terms of standard deviation.
 *
 * Payload:
 *     floatValues[0]: raw sample period in seconds.
 *     floatValues[1]: standard deviation of sampling period.
 * @apiSince 24
 */

public static final int TYPE_SAMPLING = 65540; // 0x10004

/**
 * Sensor placement.
 *
 * Provides the orientation and location of the sensor element in terms of the
 * Android coordinate system. This data is given as a 3x4 matrix consisting of a 3x3 rotation
 * matrix (R) concatenated with a 3x1 location vector (t). The rotation matrix provides the
 * orientation of the Android device coordinate frame relative to the local coordinate frame of
 * the sensor. Note that assuming the axes conventions of the sensor are the same as Android,
 * this is the inverse of the matrix applied to raw samples read from the sensor to convert them
 * into the Android representation. The location vector represents the translation from the
 * origin of the Android sensor coordinate system to the geometric center of the sensor,
 * specified in millimeters (mm).
 * <p>
 * <b>Payload</b>:
 *     <code>floatValues[0..11]</code>: 3x4 matrix in row major order [R; t]
 * </p>
 * <p>
 * <b>Example</b>:
 *     This raw buffer: <code>{0, 1, 0, 0, -1, 0, 0, 10, 0, 0, 1, -2.5}</code><br>
 *     Corresponds to this 3x4 matrix:
 *     <table>
 *      <thead>
 *       <tr><td colspan="3">Orientation</td><td>Location</tr>
 *      </thead>
 *      <tbody>
 *       <tr><td>0</td><td>1</td><td>0</td><td>0</td></tr>
 *       <tr><td>-1</td><td>0</td><td>0</td><td>10</td></tr>
 *       <tr><td>0</td><td>0</td><td>1</td><td>-2.5</td></tr>
 *      </tbody>
 *     </table>
 *     The sensor is oriented such that:
 *     <ul>
 *        <li>The device X axis corresponds to the sensor's local -Y axis
 *        <li>The device Y axis corresponds to the sensor's local X axis
 *        <li>The device Z axis and sensor's local Z axis are equivalent
 *     </ul>
 *     In other words, if viewing the origin of the Android coordinate system from the positive
 *     Z direction, the device coordinate frame is to be rotated 90° counter-clockwise about the
 *     Z axis to align with the sensor's local coordinate frame. Equivalently, a vector in the
 *     Android coordinate frame may be multiplied with R to rotate it 90° clockwise (270°
 *     counter-clockwise), yielding its representation in the sensor's coordinate frame.
 *     Relative to the origin of the Android coordinate system, the physical center of the
 *     sensor is located 10mm in the positive Y direction, and 2.5mm in the negative Z
 *     direction.
 * </p>
 * @apiSince 24
 */

public static final int TYPE_SENSOR_PLACEMENT = 65539; // 0x10003

/**
 * Untracked delay. Delays that are introduced by data processing, such as filtering, which is
 * not taken into account by sensor timestamps.
 *
 * Payload:
 *     floatValues[0]: delay estimation in seconds
 *     floatValues[1]: delay estimation standard deviation
 * @apiSince 24
 */

public static final int TYPE_UNTRACKED_DELAY = 65536; // 0x10000

/**
 * Vector calibration parameter. Calibration applied to a sensor with 3 elements vector output,
 * such as accelerometer, gyro, etc.
 *
 * Payload:
 *     floatValues[0..11]: First 3 rows of a homogeneous matrix in row major order that captures
 *     any linear transformation, including rotation, scaling, shear, shift.
 * @apiSince 24
 */

public static final int TYPE_VEC3_CALIBRATION = 65538; // 0x10002

/**
 * Additional info payload data represented in float values. Depending on the type of
 * information, this may be null.
 * @apiSince 24
 */

public final float[] floatValues;
{ floatValues = new float[0]; }

/**
 * Additional info payload data represented in int values. Depending on the type of information,
 * this may be null.
 * @apiSince 24
 */

public final int[] intValues;
{ intValues = new int[0]; }

/**
 * The sensor that generated this event. See
 * {@link android.hardware.SensorManager SensorManager} for details.
 * @apiSince 24
 */

public final android.hardware.Sensor sensor;
{ sensor = null; }

/**
 * Sequence number of frame for a certain type.
 * @apiSince 24
 */

public final int serial;
{ serial = 0; }

/**
 * Type of this additional info frame.
 * @apiSince 24
 */

public final int type;
{ type = 0; }
}

