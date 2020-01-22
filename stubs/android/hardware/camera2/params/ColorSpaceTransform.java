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

import android.util.Rational;
import android.hardware.camera2.CameraMetadata;

/**
 * Immutable class for describing a 3x3 matrix of {@link android.util.Rational Rational} values in row-major order.
 *
 * <p>This matrix maps a transform from one color space to another. For the particular color space
 * source and target, see the appropriate camera metadata documentation for the key that provides
 * this value.</p>
 *
 * @see android.hardware.camera2.CameraMetadata
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ColorSpaceTransform {

/**
 * Create a new immutable {@link android.hardware.camera2.params.ColorSpaceTransform ColorSpaceTransform} instance from a {@link android.util.Rational Rational} array.
 *
 * <p>The elements must be stored in a row-major order.</p>
 *
 * @param elements An array of {@code 9} elements
 *
 * @throws java.lang.IllegalArgumentException
 *            if the count of {@code elements} is not {@code 9}
 * @throws java.lang.NullPointerException
 *            if {@code elements} or any sub-element is {@code null}
 * @apiSince 21
 */

public ColorSpaceTransform(android.util.Rational[] elements) { throw new RuntimeException("Stub!"); }

/**
 * Create a new immutable {@link android.hardware.camera2.params.ColorSpaceTransform ColorSpaceTransform} instance from an {@code int} array.
 *
 * <p>The elements must be stored in a row-major order. Each rational is stored
 * contiguously as a {@code (numerator, denominator)} pair.</p>
 *
 * <p>In particular:<pre>{@code
 * int[] elements = new int[
 *     N11, D11, N12, D12, N13, D13,
 *     N21, D21, N22, D22, N23, D23,
 *     N31, D31, N32, D32, N33, D33
 * ];
 *
 * new ColorSpaceTransform(elements)}</pre>
 *
 * where {@code Nij} and {@code Dij} is the numerator and denominator for row {@code i} and
 * column {@code j}.</p>
 *
 * @param elements An array of {@code 18} elements
 *
 * @throws java.lang.IllegalArgumentException
 *            if the count of {@code elements} is not {@code 18}
 * @throws java.lang.NullPointerException
 *            if {@code elements} is {@code null}
 * @apiSince 21
 */

public ColorSpaceTransform(int[] elements) { throw new RuntimeException("Stub!"); }

/**
 * Get an element of this matrix by its row and column.
 *
 * <p>The rows must be within the range [0, 3),
 * and the column must be within the range [0, 3).</p>
 *
 * @return element (non-{@code null})
 *
 * @throws java.lang.IllegalArgumentException if column or row was out of range
 * @apiSince 21
 */

public android.util.Rational getElement(int column, int row) { throw new RuntimeException("Stub!"); }

/**
 * Copy the {@link android.util.Rational Rational} elements in row-major order from this matrix into the destination.
 *
 * @param destination
 *          an array big enough to hold at least {@code 9} elements after the
 *          {@code offset}
 * @param offset
 *          a non-negative offset into the array
 * @throws java.lang.NullPointerException
 *          If {@code destination} was {@code null}
 * @throws java.lang.ArrayIndexOutOfBoundsException
 *          If there's not enough room to write the elements at the specified destination and
 *          offset.
 * @apiSince 21
 */

public void copyElements(android.util.Rational[] destination, int offset) { throw new RuntimeException("Stub!"); }

/**
 * Copy the {@link android.util.Rational Rational} elements in row-major order from this matrix into the destination.
 *
 * <p>Each element is stored as a contiguous rational packed as a
 * {@code (numerator, denominator)} pair of ints, identical to the
 * {@link android.hardware.camera2.params.ColorSpaceTransform#ColorSpaceTransform(int[]) ColorSpaceTransform#ColorSpaceTransform(int[])}.</p>
 *
 * @param destination
 *          an array big enough to hold at least {@code 18} elements after the
 *          {@code offset}
 * @param offset
 *          a non-negative offset into the array
 * @throws java.lang.NullPointerException
 *          If {@code destination} was {@code null}
 * @throws java.lang.ArrayIndexOutOfBoundsException
 *          If there's not enough room to write the elements at the specified destination and
 *          offset.
 *
 * @see android.hardware.camera2.params.ColorSpaceTransform#ColorSpaceTransform(int[])
 * @apiSince 21
 */

public void copyElements(int[] destination, int offset) { throw new RuntimeException("Stub!"); }

/**
 * Check if this {@link android.hardware.camera2.params.ColorSpaceTransform ColorSpaceTransform} is equal to another {@link android.hardware.camera2.params.ColorSpaceTransform ColorSpaceTransform}.
 *
 * <p>Two color space transforms are equal if and only if all of their elements are
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
 * Return the color space transform as a string representation.
 *
 *  <p> Example:
 * {@code "ColorSpaceTransform([1/1, 0/1, 0/1], [0/1, 1/1, 0/1], [0/1, 0/1, 1/1])"} is an
 * identity transform. Elements are printed in row major order. </p>
 *
 * @return string representation of color space transform
 * @apiSince 21
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

