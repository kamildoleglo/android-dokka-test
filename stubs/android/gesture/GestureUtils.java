/*
 * Copyright (C) 2008-2009 The Android Open Source Project
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


package android.gesture;


/**
 * Utility functions for gesture processing & analysis, including methods for:
 * <ul>
 * <li>feature extraction (e.g., samplers and those for calculating bounding
 * boxes and gesture path lengths);
 * <li>geometric transformation (e.g., translation, rotation and scaling);
 * <li>gesture similarity comparison (e.g., calculating Euclidean or Cosine
 * distances between two gestures).
 * </ul>
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class GestureUtils {

private GestureUtils() { throw new RuntimeException("Stub!"); }

/**
 * Samples the gesture spatially by rendering the gesture into a 2D
 * grayscale bitmap. Scales the gesture to fit the size of the bitmap.
 * The scaling does not necessarily keep the aspect ratio of the gesture.
 *
 * @param gesture the gesture to be sampled
 * @param bitmapSize the size of the bitmap
 * @return a bitmapSize x bitmapSize grayscale bitmap that is represented
 *         as a 1D array. The float at index i represents the grayscale
 *         value at pixel [i%bitmapSize, i/bitmapSize]
 * @apiSince 8
 */

public static float[] spatialSampling(android.gesture.Gesture gesture, int bitmapSize) { throw new RuntimeException("Stub!"); }

/**
 * Samples the gesture spatially by rendering the gesture into a 2D
 * grayscale bitmap. Scales the gesture to fit the size of the bitmap.
 *
 * @param gesture the gesture to be sampled
 * @param bitmapSize the size of the bitmap
 * @param keepAspectRatio if the scaling should keep the gesture's
 *        aspect ratio
 *
 * @return a bitmapSize x bitmapSize grayscale bitmap that is represented
 *         as a 1D array. The float at index i represents the grayscale
 *         value at pixel [i%bitmapSize, i/bitmapSize]
 * @apiSince 8
 */

public static float[] spatialSampling(android.gesture.Gesture gesture, int bitmapSize, boolean keepAspectRatio) { throw new RuntimeException("Stub!"); }

/**
 * Samples a stroke temporally into a given number of evenly-distributed
 * points.
 *
 * @param stroke the gesture stroke to be sampled
 * @param numPoints the number of points
 * @return the sampled points in the form of [x1, y1, x2, y2, ..., xn, yn]
 * @apiSince 8
 */

public static float[] temporalSampling(android.gesture.GestureStroke stroke, int numPoints) { throw new RuntimeException("Stub!"); }

/**
 * Computes an oriented, minimum bounding box of a set of points.
 *
 * @param originalPoints
 * @return an oriented bounding box
 * @apiSince 8
 */

public static android.gesture.OrientedBoundingBox computeOrientedBoundingBox(java.util.ArrayList<android.gesture.GesturePoint> originalPoints) { throw new RuntimeException("Stub!"); }

/**
 * Computes an oriented, minimum bounding box of a set of points.
 *
 * @param originalPoints
 * @return an oriented bounding box
 * @apiSince 8
 */

public static android.gesture.OrientedBoundingBox computeOrientedBoundingBox(float[] originalPoints) { throw new RuntimeException("Stub!"); }
}

