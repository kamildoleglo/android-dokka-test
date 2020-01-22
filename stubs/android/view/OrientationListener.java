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


/**
 * Helper class for receiving notifications from the SensorManager when
 * the orientation of the device has changed.
 *  @deprecated use {@link android.view.OrientationEventListener} instead.
 *  This class internally uses the OrientationEventListener.
 * @apiSince 1
 * @deprecatedSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public abstract class OrientationListener implements android.hardware.SensorListener {

/**
 * Creates a new OrientationListener.
 *
 * @param context for the OrientationListener.
 * @apiSince 1
 */

@Deprecated
public OrientationListener(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new OrientationListener.
 *
 * @param context for the OrientationListener.
 * @param rate at which sensor events are processed (see also
 * {@link android.hardware.SensorManager SensorManager}). Use the default
 * value of {@link android.hardware.SensorManager#SENSOR_DELAY_NORMAL
 * SENSOR_DELAY_NORMAL} for simple screen orientation change detection.
 * @apiSince 3
 */

@Deprecated
public OrientationListener(android.content.Context context, int rate) { throw new RuntimeException("Stub!"); }

/**
 * Enables the OrientationListener so it will monitor the sensor and call
 * {@link #onOrientationChanged} when the device orientation changes.
 * @apiSince 1
 * @deprecatedSince 3
 */

@Deprecated
public void enable() { throw new RuntimeException("Stub!"); }

/**
 * Disables the OrientationListener.
 * @apiSince 1
 * @deprecatedSince 3
 */

@Deprecated
public void disable() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 3
 */

@Deprecated
public void onAccuracyChanged(int sensor, int accuracy) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 3
 */

@Deprecated
public void onSensorChanged(int sensor, float[] values) { throw new RuntimeException("Stub!"); }

/**
 * Look at {@link android.view.OrientationEventListener#onOrientationChanged}
 * for method description and usage
 * @param orientation The new orientation of the device.
 *
 *  @see #ORIENTATION_UNKNOWN
 * @apiSince 1
 * @deprecatedSince 3
 */

@Deprecated
public abstract void onOrientationChanged(int orientation);

/**
 * Returned from onOrientationChanged when the device orientation cannot be determined
 * (typically when the device is in a close to flat position).
 *
 *  @see #onOrientationChanged
 * @apiSince 1
 * @deprecatedSince 3
 */

@Deprecated public static final int ORIENTATION_UNKNOWN = -1; // 0xffffffff
}

