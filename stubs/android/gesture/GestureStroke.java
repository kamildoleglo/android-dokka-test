/*
 * Copyright (C) 2009 The Android Open Source Project
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

import android.graphics.Path;

/**
 * A gesture stroke started on a touch down and ended on a touch up. A stroke
 * consists of a sequence of timed points. One or multiple strokes form a gesture.
 * @apiSince 4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class GestureStroke {

/**
 * A constructor that constructs a gesture stroke from a list of gesture points.
 *
 * @param points
 * @apiSince 4
 */

public GestureStroke(java.util.ArrayList<android.gesture.GesturePoint> points) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public java.lang.Object clone() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public android.graphics.Path getPath() { throw new RuntimeException("Stub!"); }

/**
 * Converts the stroke to a Path of a given number of points.
 *
 * @param width the width of the bounding box of the target path
 * @param height the height of the bounding box of the target path
 * @param numSample the number of points needed
 *
 * @return the path
 * @apiSince 4
 */

public android.graphics.Path toPath(float width, float height, int numSample) { throw new RuntimeException("Stub!"); }

/**
 * Invalidates the cached path that is used to render the stroke.
 * @apiSince 4
 */

public void clearPath() { throw new RuntimeException("Stub!"); }

/**
 * Computes an oriented bounding box of the stroke.
 *
 * @return OrientedBoundingBox
 * @apiSince 4
 */

public android.gesture.OrientedBoundingBox computeOrientedBoundingBox() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public final android.graphics.RectF boundingBox;
{ boundingBox = null; }

/** @apiSince 4 */

public final float length;
{ length = 0; }

/** @apiSince 4 */

public final float[] points;
{ points = new float[0]; }
}

