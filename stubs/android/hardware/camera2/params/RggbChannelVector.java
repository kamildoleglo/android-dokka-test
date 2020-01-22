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


/**
 * Immutable class to store a 4-element vector of floats indexable by a bayer RAW 2x2 pixel block.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class RggbChannelVector {

/**
 * Create a new {@link android.hardware.camera2.params.RggbChannelVector RggbChannelVector} from an RGGB 2x2 pixel.
 *
 * <p>All pixel values are considered normalized within {@code [0.0f, 1.0f]}
 * (i.e. {@code 1.0f} could be linearized to {@code 255} if converting to a
 * non-floating point pixel representation).</p>
 *
 * <p>All arguments must be finite; NaN and infinity is not allowed.</p>
 *
 * @param red red pixel
 * @param greenEven green pixel (even row)
 * @param greenOdd green pixel (odd row)
 * @param blue blue pixel
 *
 * @throws java.lang.IllegalArgumentException if any of the arguments were not finite
 * @apiSince 21
 */

public RggbChannelVector(float red, float greenEven, float greenOdd, float blue) { throw new RuntimeException("Stub!"); }

/**
 * Get the red component.
 *
 * @return a floating point value (guaranteed to be finite)
 * @apiSince 21
 */

public float getRed() { throw new RuntimeException("Stub!"); }

/**
 * Get the green (even rows) component.
 *
 * @return a floating point value (guaranteed to be finite)
 * @apiSince 21
 */

public float getGreenEven() { throw new RuntimeException("Stub!"); }

/**
 * Get the green (odd rows) component.
 *
 * @return a floating point value (guaranteed to be finite)
 * @apiSince 21
 */

public float getGreenOdd() { throw new RuntimeException("Stub!"); }

/**
 * Get the blue component.
 *
 * @return a floating point value (guaranteed to be finite)
 * @apiSince 21
 */

public float getBlue() { throw new RuntimeException("Stub!"); }

/**
 * Get the component by the color channel index.
 *
 * <p>{@code colorChannel} must be one of {@link #RED}, {@link #GREEN_EVEN}, {@link #GREEN_ODD},
 * {@link #BLUE}.</p>
 *
 * @param colorChannel greater or equal to {@code 0} and less than {@link #COUNT}
 * @return a floating point value (guaranteed to be finite)
 *
 * @throws java.lang.IllegalArgumentException if {@code colorChannel} was out of range
 * @apiSince 21
 */

public float getComponent(int colorChannel) { throw new RuntimeException("Stub!"); }

/**
 * Copy the vector into the destination in the order {@code [R, Geven, Godd, B]}.
 *
 * @param destination
 *          an array big enough to hold at least {@value #COUNT} elements after the
 *          {@code offset}
 * @param offset
 *          a non-negative offset into the array
 *
 * @throws java.lang.NullPointerException
 *          If {@code destination} was {@code null}
 * @throws java.lang.ArrayIndexOutOfBoundsException
 *          If there's not enough room to write the elements at the specified destination and
 *          offset.
 * @apiSince 21
 */

public void copyTo(float[] destination, int offset) { throw new RuntimeException("Stub!"); }

/**
 * Check if this {@link android.hardware.camera2.params.RggbChannelVector RggbChannelVector} is equal to another {@link android.hardware.camera2.params.RggbChannelVector RggbChannelVector}.
 *
 * <p>Two vectors are only equal if and only if each of the respective elements is equal.</p>
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
 * Return the RggbChannelVector as a string representation.
 *
 * <p> {@code "RggbChannelVector{R:%f, G_even:%f, G_odd:%f, B:%f}"}, where each
 * {@code %f} respectively represents one of the the four color channels. </p>
 *
 * @return string representation of {@link android.hardware.camera2.params.RggbChannelVector RggbChannelVector}
 * @apiSince 21
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Blue color channel in a bayer Raw pattern.
 * @apiSince 21
 */

public static final int BLUE = 3; // 0x3

/**
 * The number of color channels in this vector.
 * @apiSince 21
 */

public static final int COUNT = 4; // 0x4

/**
 * Green color channel in a bayer Raw pattern used by the even rows.
 * @apiSince 21
 */

public static final int GREEN_EVEN = 1; // 0x1

/**
 * Green color channel in a bayer Raw pattern used by the odd rows.
 * @apiSince 21
 */

public static final int GREEN_ODD = 2; // 0x2

/**
 * Red color channel in a bayer Raw pattern.
 * @apiSince 21
 */

public static final int RED = 0; // 0x0
}

