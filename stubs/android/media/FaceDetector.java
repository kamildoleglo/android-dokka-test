/*
 * Copyright (C) 2006 The Android Open Source Project
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


package android.media;

import android.graphics.Bitmap;
import java.lang.IllegalArgumentException;
import android.graphics.PointF;

/**
 * Identifies the faces of people in a
 * {@link android.graphics.Bitmap} graphic object.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class FaceDetector {

/**
 * Creates a FaceDetector, configured with the size of the images to
 * be analysed and the maximum number of faces that can be detected.
 * These parameters cannot be changed once the object is constructed.
 * Note that the width of the image must be even.
 *
 * @param width  the width of the image
 * @param height the height of the image
 * @param maxFaces the maximum number of faces to identify
 *
 * @apiSince 1
 */

public FaceDetector(int width, int height, int maxFaces) { throw new RuntimeException("Stub!"); }

/**
 * Finds all the faces found in a given {@link android.graphics.Bitmap}.
 * The supplied array is populated with {@link android.media.FaceDetector.Face FaceDetector.Face}s for each
 * face found. The bitmap must be in 565 format (for now).
 *
 * @param bitmap the {@link android.graphics.Bitmap} graphic to be analyzed
 * @param faces  an array in which to place all found
 *               {@link android.media.FaceDetector.Face FaceDetector.Face}s. The array must be sized equal
 *               to the <var>maxFaces</var> value set at initialization
 * @return the number of faces found
 * @throws java.lang.IllegalArgumentException if the Bitmap dimensions don't match
 *               the dimensions defined at initialization or the given array
 *               is not sized equal to the <var>maxFaces</var> value defined
 *               at initialization
 * @apiSince 1
 */

public int findFaces(android.graphics.Bitmap bitmap, android.media.FaceDetector.Face[] faces) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }
/**
 * A Face contains all the information identifying the location
 * of a face in a bitmap.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Face {

private Face() { throw new RuntimeException("Stub!"); }

/** 
 * Returns a confidence factor between 0 and 1. This indicates how
 * certain what has been found is actually a face. A confidence
 * factor above 0.3 is usually good enough.
 * @apiSince 1
 */

public float confidence() { throw new RuntimeException("Stub!"); }

/**
 * Sets the position of the mid-point between the eyes.
 * @param point the PointF coordinates (float values) of the
 *              face's mid-point
 * @apiSince 1
 */

public void getMidPoint(android.graphics.PointF point) { throw new RuntimeException("Stub!"); }

/**
 * Returns the distance between the eyes.
 * @apiSince 1
 */

public float eyesDistance() { throw new RuntimeException("Stub!"); }

/**
 * Returns the face's pose. That is, the rotations around either
 * the X, Y or Z axis (the positions in 3-dimensional Euclidean space).
 *
 * @param euler the Euler axis to retrieve an angle from
 *              (<var>EULER_X</var>, <var>EULER_Y</var> or
 *              <var>EULER_Z</var>)
 * @return the Euler angle of the of the face, for the given axis
 * @apiSince 1
 */

public float pose(int euler) { throw new RuntimeException("Stub!"); }

/**
 * The minimum confidence factor of good face recognition
 * @apiSince 1
 */

public static final float CONFIDENCE_THRESHOLD = 0.4f;

/**
 * The x-axis Euler angle of a face.
 * @apiSince 1
 */

public static final int EULER_X = 0; // 0x0

/**
 * The y-axis Euler angle of a face.
 * @apiSince 1
 */

public static final int EULER_Y = 1; // 0x1

/**
 * The z-axis Euler angle of a face.
 * @apiSince 1
 */

public static final int EULER_Z = 2; // 0x2
}

}

