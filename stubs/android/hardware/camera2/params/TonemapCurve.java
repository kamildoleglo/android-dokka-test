/*
 * Copyright (C) 2014 The Android Open Source Project
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

import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CameraMetadata;

/**
 * Immutable class for describing a {@code 2 x M x 3} tonemap curve of floats.
 *
 * <p>This defines red, green, and blue curves that the {@link android.hardware.camera2.CameraDevice CameraDevice} will
 * use as the tonemapping/contrast/gamma curve when {@link android.hardware.camera2.CaptureRequest#TONEMAP_MODE CaptureRequest#TONEMAP_MODE} is
 * set to {@link android.hardware.camera2.CameraMetadata#TONEMAP_MODE_CONTRAST_CURVE CameraMetadata#TONEMAP_MODE_CONTRAST_CURVE}.</p>
 *
 * <p>For a camera device with
 * {@link android.hardware.camera2.CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES_MONOCHROME
 * MONOCHROME} capability, all 3 channels will contain the same set of control points.
 *
 * <p>The total number of points {@code (Pin, Pout)} for each color channel can be no more than
 * {@link android.hardware.camera2.CameraCharacteristics#TONEMAP_MAX_CURVE_POINTS CameraCharacteristics#TONEMAP_MAX_CURVE_POINTS}.</p>
 *
 * <p>The coordinate system for each point is within the inclusive range
 * [{@value #LEVEL_BLACK}, {@value #LEVEL_WHITE}].</p>
 *
 * @see android.hardware.camera2.CameraMetadata#TONEMAP_MODE_CONTRAST_CURVE
 * @see android.hardware.camera2.CameraCharacteristics#TONEMAP_MAX_CURVE_POINTS
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class TonemapCurve {

/**
 * Create a new immutable TonemapCurve instance.
 *
 * <p>Values are stored as a contiguous array of {@code (Pin, Pout)} points.</p>
 *
 * <p>All parameters may have independent length but should have at most
 * {@link android.hardware.camera2.CameraCharacteristics#TONEMAP_MAX_CURVE_POINTS CameraCharacteristics#TONEMAP_MAX_CURVE_POINTS} * {@value #POINT_SIZE} elements and
 * at least 2 * {@value #POINT_SIZE} elements.</p>
 *
 * <p>All sub-elements must be in the inclusive range of
 * [{@value #LEVEL_BLACK}, {@value #LEVEL_WHITE}].</p>
 *
 * <p>This constructor copies the array contents and does not retain ownership of the array.</p>
 *
 * @param red An array of elements whose length is divisible by {@value #POINT_SIZE}
 * @param green An array of elements whose length is divisible by {@value #POINT_SIZE}
 * @param blue An array of elements whose length is divisible by {@value #POINT_SIZE}
 *
 * @throws java.lang.IllegalArgumentException
 *            if any of input array length is invalid,
 *            or if any of the elements in the array are not in the range of
 *            [{@value #LEVEL_BLACK}, {@value #LEVEL_WHITE}]
 * @throws java.lang.NullPointerException
 *            if any of the parameters are {@code null}
 * @apiSince 21
 */

public TonemapCurve(float[] red, float[] green, float[] blue) { throw new RuntimeException("Stub!"); }

/**
 * Get the number of points stored in this tonemap curve for the specified color channel.
 *
 * @param colorChannel one of {@link #CHANNEL_RED}, {@link #CHANNEL_GREEN}, {@link #CHANNEL_BLUE}
 * @return number of points stored in this tonemap for that color's curve (>= 0)
 *
 * @throws java.lang.IllegalArgumentException if {@code colorChannel} was out of range
 * @apiSince 21
 */

public int getPointCount(int colorChannel) { throw new RuntimeException("Stub!"); }

/**
 * Get the point for a color channel at a specified index.
 *
 * <p>The index must be at least 0 but no greater than {@link #getPointCount(int)} for
 * that {@code colorChannel}.</p>
 *
 * <p>All returned coordinates in the point are between the range of
 * [{@value #LEVEL_BLACK}, {@value #LEVEL_WHITE}].</p>
 *
 * @param colorChannel {@link #CHANNEL_RED}, {@link #CHANNEL_GREEN}, or {@link #CHANNEL_BLUE}
 * @param index at least 0 but no greater than {@code getPointCount(colorChannel)}
 * @return the {@code (Pin, Pout)} pair mapping the tone for that index
 *
 * @throws java.lang.IllegalArgumentException if {@code colorChannel} or {@code index} was out of range
 *
 * @see #LEVEL_BLACK
 * @see #LEVEL_WHITE
 * @apiSince 21
 */

public android.graphics.PointF getPoint(int colorChannel, int index) { throw new RuntimeException("Stub!"); }

/**
 * Copy the color curve for a single color channel from this tonemap curve into the destination.
 *
 * <p>
 * <!--The output is encoded the same as in the constructor -->
 * Values are stored as packed {@code (Pin, Pout}) points, and there are a total of
 * {@link #getPointCount} points for that respective channel.</p>
 *
 * <p>All returned coordinates are between the range of
 * [{@value #LEVEL_BLACK}, {@value #LEVEL_WHITE}].</p>
 *
 * @param destination
 *          an array big enough to hold at least {@link #getPointCount} {@code *}
 *          {@link #POINT_SIZE} elements after the {@code offset}
 * @param offset
 *          a non-negative offset into the array
 * @throws java.lang.NullPointerException
 *          If {@code destination} was {@code null}
 * @throws java.lang.IllegalArgumentException
 *          If offset was negative
 * @throws java.lang.ArrayIndexOutOfBoundsException
 *          If there's not enough room to write the elements at the specified destination and
 *          offset.
 *
 * @see #LEVEL_BLACK
 * @see #LEVEL_WHITE
 * @apiSince 21
 */

public void copyColorCurve(int colorChannel, float[] destination, int offset) { throw new RuntimeException("Stub!"); }

/**
 * Check if this TonemapCurve is equal to another TonemapCurve.
 *
 * <p>Two matrices are equal if and only if all of their elements are
 * {@link java.lang.Object#equals Object#equals}.</p>
 *
 * @return {@code true} if the objects were equal, {@code false} otherwise
 * @apiSince 21
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 21
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Return the TonemapCurve as a string representation.
 *
 * <p> {@code "TonemapCurve{R:[(%f, %f), (%f, %f) ... (%f, %f)], G:[(%f, %f), (%f, %f) ...
 * (%f, %f)], B:[(%f, %f), (%f, %f) ... (%f, %f)]}"},
 * where each {@code (%f, %f)} respectively represents one point of the corresponding
 * tonemap curve. </p>
 *
 * @return string representation of {@link android.hardware.camera2.params.TonemapCurve TonemapCurve}
 * @apiSince 21
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Index of the blue color channel curve.
 * @apiSince 21
 */

public static final int CHANNEL_BLUE = 2; // 0x2

/**
 * Index of the green color channel curve.
 * @apiSince 21
 */

public static final int CHANNEL_GREEN = 1; // 0x1

/**
 * Index of the red color channel curve.
 * @apiSince 21
 */

public static final int CHANNEL_RED = 0; // 0x0

/**
 * Lower bound tonemap value corresponding to pure black for a single color channel.
 * @apiSince 21
 */

public static final float LEVEL_BLACK = 0.0f;

/**
 * Upper bound tonemap value corresponding to a pure white for a single color channel.
 * @apiSince 21
 */

public static final float LEVEL_WHITE = 1.0f;

/**
 * Number of elements in a {@code (Pin, Pout)} point;
 * @apiSince 21
 */

public static final int POINT_SIZE = 2; // 0x2
}

