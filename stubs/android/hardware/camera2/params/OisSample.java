/*
 * Copyright (C) 2018 The Android Open Source Project
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


package android.hardware.camera2.params;

import android.hardware.camera2.CaptureResult;

/**
 * Immutable class to store an
 * {@link android.hardware.camera2.CaptureResult#STATISTICS_OIS_SAMPLES CaptureResult#STATISTICS_OIS_SAMPLES}.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class OisSample {

/**
 * Create a new {@link android.hardware.camera2.params.OisSample OisSample}.
 *
 * <p>{@link android.hardware.camera2.params.OisSample OisSample} contains the timestamp and the amount of shifts in x and y direction,
 * in pixels, of the OIS sample.
 *
 * <p>A positive value for a shift in x direction is a shift from left to right in active array
 * coordinate system. For example, if the optical center is {@code (1000, 500)} in active array
 * coordinates, a shift of {@code (3, 0)} puts the new optical center at {@code (1003, 500)}.
 * </p>
 *
 * <p>A positive value for a shift in y direction is a shift from top to bottom in active array
 * coordinate system. For example, if the optical center is {@code (1000, 500)} in active array
 * coordinates, a shift of {@code (0, 5)} puts the new optical center at {@code (1000, 505)}.
 * </p>
 *
 * <p>xShift and yShift must be finite; NaN and infinity is not allowed.</p>
 *
 * @param timestamp timestamp of the OIS sample.
 * @param xShift shift of the OIS sample in x direction.
 * @param yShift shift of the OIS sample in y direction.
 *
 * @throws java.lang.IllegalArgumentException if xShift or yShift is not finite
 * @apiSince 28
 */

public OisSample(long timestamp, float xShift, float yShift) { throw new RuntimeException("Stub!"); }

/**
 * Get the timestamp in nanoseconds.
 *
 *<p>The timestamps are in the same timebase as and comparable to
 *{@link android.hardware.camera2.CaptureResult#SENSOR_TIMESTAMP CaptureResult#SENSOR_TIMESTAMP}.</p>
 *
 * @return a long value (guaranteed to be finite)
 * @apiSince 28
 */

public long getTimestamp() { throw new RuntimeException("Stub!"); }

/**
 * Get the shift in x direction.
 *
 * @return a floating point value (guaranteed to be finite)
 * @apiSince 28
 */

public float getXshift() { throw new RuntimeException("Stub!"); }

/**
 * Get the shift in y direction.
 *
 * @return a floating point value (guaranteed to be finite)
 * @apiSince 28
 */

public float getYshift() { throw new RuntimeException("Stub!"); }

/**
 * Check if this {@link android.hardware.camera2.params.OisSample OisSample} is equal to another {@link android.hardware.camera2.params.OisSample OisSample}.
 *
 * <p>Two samples are only equal if and only if each of the OIS information is equal.</p>
 *
 * @return {@code true} if the objects were equal, {@code false} otherwise
 * @apiSince 28
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 28
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Return the OisSample as a string representation.
 *
 * <p> {@code "OisSample{timestamp:%l, shift_x:%f, shift_y:%f}"} represents the OIS sample's
 * timestamp, shift in x direction, and shift in y direction.</p>
 *
 * @return string representation of {@link android.hardware.camera2.params.OisSample OisSample}
 * @apiSince 28
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

