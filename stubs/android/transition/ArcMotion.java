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

package android.transition;

import android.graphics.Path;

/**
 * A PathMotion that generates a curved path along an arc on an imaginary circle containing
 * the two points. If the horizontal distance between the points is less than the vertical
 * distance, then the circle's center point will be horizontally aligned with the end point. If the
 * vertical distance is less than the horizontal distance then the circle's center point
 * will be vertically aligned with the end point.
 * <p>
 * When the two points are near horizontal or vertical, the curve of the motion will be
 * small as the center of the circle will be far from both points. To force curvature of
 * the path, {@link #setMinimumHorizontalAngle(float)} and
 * {@link #setMinimumVerticalAngle(float)} may be used to set the minimum angle of the
 * arc between two points.
 * </p>
 * <p>This may be used in XML as an element inside a transition.</p>
 * <pre>{@code
 * <changeBounds>
 *   <arcMotion android:minimumHorizontalAngle="15"
 *              android:minimumVerticalAngle="0"
 *              android:maximumAngle="90"/>
 * </changeBounds>}
 * </pre>
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ArcMotion extends android.transition.PathMotion {

/** @apiSince 21 */

public ArcMotion() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public ArcMotion(android.content.Context context, android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/**
 * Sets the minimum arc along the circle between two points aligned near horizontally.
 * When start and end points are close to horizontal, the calculated center point of the
 * circle will be far from both points, giving a near straight path between the points.
 * By setting a minimum angle, this forces the center point to be closer and give an
 * exaggerated curve to the path.
 * <p>The default value is 0.</p>
 *
 * @param angleInDegrees The minimum angle of the arc on a circle describing the Path
 *                       between two nearly horizontally-separated points.
 * @attr ref android.R.styleable#ArcMotion_minimumHorizontalAngle
 * @apiSince 21
 */

public void setMinimumHorizontalAngle(float angleInDegrees) { throw new RuntimeException("Stub!"); }

/**
 * Returns the minimum arc along the circle between two points aligned near horizontally.
 * When start and end points are close to horizontal, the calculated center point of the
 * circle will be far from both points, giving a near straight path between the points.
 * By setting a minimum angle, this forces the center point to be closer and give an
 * exaggerated curve to the path.
 * <p>The default value is 0.</p>
 *
 * @return  The minimum arc along the circle between two points aligned near horizontally.
 * @attr ref android.R.styleable#ArcMotion_minimumHorizontalAngle
 * @apiSince 21
 */

public float getMinimumHorizontalAngle() { throw new RuntimeException("Stub!"); }

/**
 * Sets the minimum arc along the circle between two points aligned near vertically.
 * When start and end points are close to vertical, the calculated center point of the
 * circle will be far from both points, giving a near straight path between the points.
 * By setting a minimum angle, this forces the center point to be closer and give an
 * exaggerated curve to the path.
 * <p>The default value is 0.</p>
 *
 * @param angleInDegrees The minimum angle of the arc on a circle describing the Path
 *                       between two nearly vertically-separated points.
 * @attr ref android.R.styleable#ArcMotion_minimumVerticalAngle
 * @apiSince 21
 */

public void setMinimumVerticalAngle(float angleInDegrees) { throw new RuntimeException("Stub!"); }

/**
 * Returns the minimum arc along the circle between two points aligned near vertically.
 * When start and end points are close to vertical, the calculated center point of the
 * circle will be far from both points, giving a near straight path between the points.
 * By setting a minimum angle, this forces the center point to be closer and give an
 * exaggerated curve to the path.
 * <p>The default value is 0.</p>
 *
 * @return The minimum angle of the arc on a circle describing the Path
 *         between two nearly vertically-separated points.
 * @attr ref android.R.styleable#ArcMotion_minimumVerticalAngle
 * @apiSince 21
 */

public float getMinimumVerticalAngle() { throw new RuntimeException("Stub!"); }

/**
 * Sets the maximum arc along the circle between two points. When start and end points
 * have close to equal x and y differences, the curve between them is large. This forces
 * the curved path to have an arc of at most the given angle.
 * <p>The default value is 70 degrees.</p>
 *
 * @param angleInDegrees The maximum angle of the arc on a circle describing the Path
 *                       between the start and end points.
 * @attr ref android.R.styleable#ArcMotion_maximumAngle
 * @apiSince 21
 */

public void setMaximumAngle(float angleInDegrees) { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum arc along the circle between two points. When start and end points
 * have close to equal x and y differences, the curve between them is large. This forces
 * the curved path to have an arc of at most the given angle.
 * <p>The default value is 70 degrees.</p>
 *
 * @return The maximum angle of the arc on a circle describing the Path
 *         between the start and end points.
 * @attr ref android.R.styleable#ArcMotion_maximumAngle
 * @apiSince 21
 */

public float getMaximumAngle() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public android.graphics.Path getPath(float startX, float startY, float endX, float endY) { throw new RuntimeException("Stub!"); }
}

