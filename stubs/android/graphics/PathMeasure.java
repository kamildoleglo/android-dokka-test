/*
 * Copyright (C) 2007 The Android Open Source Project
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


package android.graphics;


/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PathMeasure {

/**
 * Create an empty PathMeasure object. To uses this to measure the length
 * of a path, and/or to find the position and tangent along it, call
 * setPath.
 *
 * Note that once a path is associated with the measure object, it is
 * undefined if the path is subsequently modified and the the measure object
 * is used. If the path is modified, you must call setPath with the path.
 * @apiSince 1
 */

public PathMeasure() { throw new RuntimeException("Stub!"); }

/**
 * Create a PathMeasure object associated with the specified path object
 * (already created and specified). The measure object can now return the
 * path's length, and the position and tangent of any position along the
 * path.
 *
 * Note that once a path is associated with the measure object, it is
 * undefined if the path is subsequently modified and the the measure object
 * is used. If the path is modified, you must call setPath with the path.
 *
 * @param path The path that will be measured by this object
 * @param forceClosed If true, then the path will be considered as "closed"
 *        even if its contour was not explicitly closed.
 * @apiSince 1
 */

public PathMeasure(android.graphics.Path path, boolean forceClosed) { throw new RuntimeException("Stub!"); }

/**
 * Assign a new path, or null to have none.
 * @apiSince 1
 */

public void setPath(android.graphics.Path path, boolean forceClosed) { throw new RuntimeException("Stub!"); }

/**
 * Return the total length of the current contour, or 0 if no path is
 * associated with this measure object.
 * @apiSince 1
 */

public float getLength() { throw new RuntimeException("Stub!"); }

/**
 * Pins distance to 0 <= distance <= getLength(), and then computes the
 * corresponding position and tangent. Returns false if there is no path,
 * or a zero-length path was specified, in which case position and tangent
 * are unchanged.
 *
 * @param distance The distance along the current contour to sample
 * @param pos If not null, returns the sampled position (x==[0], y==[1])
 * @param tan If not null, returns the sampled tangent (x==[0], y==[1])
 * @return false if there was no path associated with this measure object
 * @apiSince 1
 */

public boolean getPosTan(float distance, float[] pos, float[] tan) { throw new RuntimeException("Stub!"); }

/**
 * Pins distance to 0 <= distance <= getLength(), and then computes the
 * corresponding matrix. Returns false if there is no path, or a zero-length
 * path was specified, in which case matrix is unchanged.
 *
 * @param distance The distance along the associated path
 * @param matrix Allocated by the caller, this is set to the transformation
 *        associated with the position and tangent at the specified distance
 * @param flags Specified what aspects should be returned in the matrix.
 * @apiSince 1
 */

public boolean getMatrix(float distance, android.graphics.Matrix matrix, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Given a start and stop distance, return in dst the intervening
 * segment(s). If the segment is zero-length, return false, else return
 * true. startD and stopD are pinned to legal values (0..getLength()).
 * If startD >= stopD then return false (and leave dst untouched).
 * Begin the segment with a moveTo if startWithMoveTo is true.
 *
 * <p>On {@link android.os.Build.VERSION_CODES#KITKAT} and earlier
 * releases, the resulting path may not display on a hardware-accelerated
 * Canvas. A simple workaround is to add a single operation to this path,
 * such as <code>dst.rLineTo(0, 0)</code>.</p>
 * @apiSince 1
 */

public boolean getSegment(float startD, float stopD, android.graphics.Path dst, boolean startWithMoveTo) { throw new RuntimeException("Stub!"); }

/**
 * Return true if the current contour is closed()
 * @apiSince 1
 */

public boolean isClosed() { throw new RuntimeException("Stub!"); }

/**
 * Move to the next contour in the path. Return true if one exists, or
 * false if we're done with the path.
 * @apiSince 1
 */

public boolean nextContour() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static final int POSITION_MATRIX_FLAG = 1; // 0x1

/** @apiSince 1 */

public static final int TANGENT_MATRIX_FLAG = 2; // 0x2
}

