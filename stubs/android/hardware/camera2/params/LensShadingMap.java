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

import android.hardware.camera2.CaptureResult;

/**
 * Immutable class for describing a {@code 4 x N x M} lens shading map of floats.
 *
 * @see android.hardware.camera2.CaptureResult#STATISTICS_LENS_SHADING_CORRECTION_MAP
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class LensShadingMap {

LensShadingMap() { throw new RuntimeException("Stub!"); }

/**
 * Get the number of rows in this map.
 * @apiSince 21
 */

public int getRowCount() { throw new RuntimeException("Stub!"); }

/**
 * Get the number of columns in this map.
 * @apiSince 21
 */

public int getColumnCount() { throw new RuntimeException("Stub!"); }

/**
 * Get the total number of gain factors in this map.
 *
 * <p>A single gain factor contains exactly one color channel.
 * Use with {@link #copyGainFactors} to allocate a large-enough array.</p>
 * @apiSince 21
 */

public int getGainFactorCount() { throw new RuntimeException("Stub!"); }

/**
 * Get a single color channel gain factor from this lens shading map by its row and column.
 *
 * <p>The rows must be within the range [0, {@link #getRowCount}),
 * the column must be within the range [0, {@link #getColumnCount}),
 * and the color channel must be within the range [0, {@value android.hardware.camera2.params.RggbChannelVector#COUNT RggbChannelVector#COUNT}).</p>
 *
 * <p>The channel order is {@code [R, Geven, Godd, B]}, where
 * {@code Geven} is the green channel for the even rows of a Bayer pattern, and
 * {@code Godd} is the odd rows.
 * </p>
 *
 * @param colorChannel color channel from {@code [R, Geven, Godd, B]}
 * @param column within the range [0, {@link #getColumnCount})
 * @param row within the range [0, {@link #getRowCount})
 *
 * @return a gain factor >= {@value #MINIMUM_GAIN_FACTOR}
 *
 * @throws java.lang.IllegalArgumentException if any of the parameters was out of range
 *
 * @see android.hardware.camera2.params.RggbChannelVector#RED
 * @see android.hardware.camera2.params.RggbChannelVector#GREEN_EVEN
 * @see android.hardware.camera2.params.RggbChannelVector#GREEN_ODD
 * @see android.hardware.camera2.params.RggbChannelVector#BLUE
 * @see #getRowCount
 * @see #getColumnCount
 * @apiSince 21
 */

public float getGainFactor(int colorChannel, int column, int row) { throw new RuntimeException("Stub!"); }

/**
 * Get a gain factor vector from this lens shading map by its row and column.
 *
 * <p>The rows must be within the range [0, {@link #getRowCount}),
 * the column must be within the range [0, {@link #getColumnCount}).</p>
 *
 * @param column within the range [0, {@link #getColumnCount})
 * @param row within the range [0, {@link #getRowCount})
 *
 * @return an {@link android.hardware.camera2.params.RggbChannelVector RggbChannelVector} where each gain factor >= {@value #MINIMUM_GAIN_FACTOR}
 *
 * @throws java.lang.IllegalArgumentException if any of the parameters was out of range
 *
 * @see #getRowCount
 * @see #getColumnCount
 * @apiSince 21
 */

public android.hardware.camera2.params.RggbChannelVector getGainFactorVector(int column, int row) { throw new RuntimeException("Stub!"); }

/**
 * Copy all gain factors in row-major order from this lens shading map into the destination.
 *
 * <p>Each gain factor will be >= {@link #MINIMUM_GAIN_FACTOR}.</p>
 *
 * @param destination
 *          an array big enough to hold at least {@link android.hardware.camera2.params.RggbChannelVector#COUNT RggbChannelVector#COUNT}
 *          elements after the {@code offset}
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
 * @see android.hardware.camera2.CaptureResult#STATISTICS_LENS_SHADING_CORRECTION_MAP
 * @apiSince 21
 */

public void copyGainFactors(float[] destination, int offset) { throw new RuntimeException("Stub!"); }

/**
 * Check if this LensShadingMap is equal to another LensShadingMap.
 *
 * <p>Two lens shading maps are equal if and only if they have the same rows/columns,
 * and all of their elements are {@link java.lang.Object#equals Object#equals}.</p>
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
 * Return the LensShadingMap as a string representation.
 *
 * <p> {@code "LensShadingMap{R:([%f, %f, ... %f], ... [%f, %f, ... %f]), G_even:([%f, %f, ...
 *  %f], ... [%f, %f, ... %f]), G_odd:([%f, %f, ... %f], ... [%f, %f, ... %f]), B:([%f, %f, ...
 *  %f], ... [%f, %f, ... %f])}"},
 * where each {@code %f} represents one gain factor and each {@code [%f, %f, ... %f]} represents
 * a row of the lens shading map</p>
 *
 * @return string representation of {@link android.hardware.camera2.params.LensShadingMap LensShadingMap}
 * @apiSince 21
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * The smallest gain factor in this map.
 *
 * <p>All values in this map will be at least this large.</p>
 * @apiSince 21
 */

public static final float MINIMUM_GAIN_FACTOR = 1.0f;
}

