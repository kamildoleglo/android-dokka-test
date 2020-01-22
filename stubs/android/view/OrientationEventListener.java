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


package android.view;

import android.hardware.SensorManager;

/**
 * Helper class for receiving notifications from the SensorManager when
 * the orientation of the device has changed.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class OrientationEventListener {

/**
 * Creates a new OrientationEventListener.
 *
 * @param context for the OrientationEventListener.
 * @apiSince 3
 */

public OrientationEventListener(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new OrientationEventListener.
 *
 * @param context for the OrientationEventListener.
 * @param rate at which sensor events are processed (see also
 * {@link android.hardware.SensorManager SensorManager}). Use the default
 * value of {@link android.hardware.SensorManager#SENSOR_DELAY_NORMAL
 * SENSOR_DELAY_NORMAL} for simple screen orientation change detection.
 * @apiSince 3
 */

public OrientationEventListener(android.content.Context context, int rate) { throw new RuntimeException("Stub!"); }

/**
 * Enables the OrientationEventListener so it will monitor the sensor and call
 * {@link #onOrientationChanged} when the device orientation changes.
 * @apiSince 3
 */

public void enable() { throw new RuntimeException("Stub!"); }

/**
 * Disables the OrientationEventListener.
 * @apiSince 3
 */

public void disable() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public boolean canDetectOrientation() { throw new RuntimeException("Stub!"); }

/**
 * Called when the orientation of the device has changed.
 * orientation parameter is in degrees, ranging from 0 to 359.
 * orientation is 0 degrees when the device is oriented in its natural position,
 * 90 degrees when its left side is at the top, 180 degrees when it is upside down,
 * and 270 degrees when its right side is to the top.
 * {@link #ORIENTATION_UNKNOWN} is returned when the device is close to flat
 * and the orientation cannot be determined.
 *
 * @param orientation The new orientation of the device.
 *
 *  @see #ORIENTATION_UNKNOWN
 * @apiSince 3
 */

public abstract void onOrientationChanged(int orientation);

/**
 * Returned from onOrientationChanged when the device orientation cannot be determined
 * (typically when the device is in a close to flat position).
 *
 *  @see #onOrientationChanged
 * @apiSince 3
 */

public static final int ORIENTATION_UNKNOWN = -1; // 0xffffffff
}

