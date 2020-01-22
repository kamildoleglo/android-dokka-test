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

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.util.Size;
import android.graphics.Point;
import android.graphics.Rect;

/**
 * An immutable class to represent a rectangle {@code (x, y, width, height)} with an additional
 * weight component.
 * <p>
 * The rectangle is defined to be inclusive of the specified coordinates.
 * </p>
 * <p>
 * When used with a {@link android.hardware.camera2.CaptureRequest CaptureRequest}, the coordinate system is based on the active pixel
 * array, with {@code (0,0)} being the top-left pixel in the
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE}, and
 * {@code (android.sensor.info.activeArraySize.width - 1,
 * android.sensor.info.activeArraySize.height - 1)} being the bottom-right pixel in the active pixel
 * array.
 * </p>
 * <p>
 * The weight must range from {@value #METERING_WEIGHT_MIN} to {@value #METERING_WEIGHT_MAX}
 * inclusively, and represents a weight for every pixel in the area. This means that a large
 * metering area with the same weight as a smaller area will have more effect in the metering
 * result. Metering areas can partially overlap and the camera device will add the weights in the
 * overlap rectangle.
 * </p>
 * <p>
 * If all rectangles have 0 weight, then no specific metering area needs to be used by the camera
 * device. If the metering rectangle is outside the used android.scaler.cropRegion returned in
 * capture result metadata, the camera device will ignore the sections outside the rectangle and
 * output the used sections in the result metadata.
 * </p>
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MeteringRectangle {

/**
 * Create a new metering rectangle.
 *
 * @param x coordinate >= 0
 * @param y coordinate >= 0
 * @param width width >= 0
 * @param height height >= 0
 * @param meteringWeight weight between {@value #METERING_WEIGHT_MIN} and
 *        {@value #METERING_WEIGHT_MAX} inclusively
 * @throws java.lang.IllegalArgumentException if any of the parameters were negative
 * @apiSince 21
 */

public MeteringRectangle(int x, int y, int width, int height, int meteringWeight) { throw new RuntimeException("Stub!"); }

/**
 * Create a new metering rectangle.
 *
 * <p>The point {@code xy}'s data is copied; the reference is not retained.</p>
 *
 * @param xy a non-{@code null} {@link android.graphics.Point Point} with both x,y >= 0
 * @param dimensions a non-{@code null} {@link android.util.Size Size} with width, height >= 0
 * @param meteringWeight weight >= 0
 *
 * @throws java.lang.IllegalArgumentException if any of the parameters were negative
 * @throws java.lang.NullPointerException if any of the arguments were null
 * @apiSince 21
 */

public MeteringRectangle(android.graphics.Point xy, android.util.Size dimensions, int meteringWeight) { throw new RuntimeException("Stub!"); }

/**
 * Create a new metering rectangle.
 *
 * <p>The rectangle data is copied; the reference is not retained.</p>
 *
 * @param rect a non-{@code null} rectangle with all x,y,w,h dimensions >= 0
 * @param meteringWeight weight >= 0
 *
 * @throws java.lang.IllegalArgumentException if any of the parameters were negative
 * @throws java.lang.NullPointerException if any of the arguments were null
 * @apiSince 21
 */

public MeteringRectangle(android.graphics.Rect rect, int meteringWeight) { throw new RuntimeException("Stub!"); }

/**
 * Return the X coordinate of the left side of the rectangle.
 *
 * @return x coordinate >= 0
 * @apiSince 21
 */

public int getX() { throw new RuntimeException("Stub!"); }

/**
 * Return the Y coordinate of the upper side of the rectangle.
 *
 * @return y coordinate >= 0
 * @apiSince 21
 */

public int getY() { throw new RuntimeException("Stub!"); }

/**
 * Return the width of the rectangle.
 *
 * @return width >= 0
 * @apiSince 21
 */

public int getWidth() { throw new RuntimeException("Stub!"); }

/**
 * Return the height of the rectangle.
 *
 * @return height >= 0
 * @apiSince 21
 */

public int getHeight() { throw new RuntimeException("Stub!"); }

/**
 * Return the metering weight of the rectangle.
 *
 * @return weight >= 0
 * @apiSince 21
 */

public int getMeteringWeight() { throw new RuntimeException("Stub!"); }

/**
 * Convenience method to create the upper-left (X,Y) coordinate as a {@link android.graphics.Point Point}.
 *
 * @return a new {@code (x,y)} {@link android.graphics.Point Point} with both x,y >= 0
 * @apiSince 21
 */

public android.graphics.Point getUpperLeftPoint() { throw new RuntimeException("Stub!"); }

/**
 * Convenience method to create the size from this metering rectangle.
 *
 * <p>This strips away the X,Y,weight from the rectangle.</p>
 *
 * @return a new {@link android.util.Size Size} with non-negative width and height
 * @apiSince 21
 */

public android.util.Size getSize() { throw new RuntimeException("Stub!"); }

/**
 * Convenience method to create a {@link android.graphics.Rect Rect} from this metering rectangle.
 *
 * <p>This strips away the weight from the rectangle.</p>
 *
 * @return a new {@link android.graphics.Rect Rect} with non-negative x1, y1, x2, y2
 * @apiSince 21
 */

public android.graphics.Rect getRect() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 21
 */

public boolean equals(java.lang.Object other) { throw new RuntimeException("Stub!"); }

/**
 * Compare two metering rectangles to see if they are equal.
 *
 * Two weighted rectangles are only considered equal if each of their components
 * (x, y, width, height, weight) is respectively equal.
 *
 * @param other Another MeteringRectangle
 *
 * @return {@code true} if the metering rectangles are equal, {@code false} otherwise
 * @apiSince 21
 */

public boolean equals(android.hardware.camera2.params.MeteringRectangle other) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 21
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Return the metering rectangle as a string representation
 * {@code "(x:%d, y:%d, w:%d, h:%d, wt:%d)"} where each {@code %d} respectively represents
 * the x, y, width, height, and weight points.
 *
 * @return string representation of the metering rectangle
 * @apiSince 21
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Weights set to this value will cause the camera device to ignore this rectangle.
 * If all metering rectangles are weighed with 0, the camera device will choose its own metering
 * rectangles.
 * @apiSince 21
 */

public static final int METERING_WEIGHT_DONT_CARE = 0; // 0x0

/**
 * The maximum value of valid metering weight.
 * @apiSince 21
 */

public static final int METERING_WEIGHT_MAX = 1000; // 0x3e8

/**
 * The minimum value of valid metering weight.
 * @apiSince 21
 */

public static final int METERING_WEIGHT_MIN = 0; // 0x0
}

