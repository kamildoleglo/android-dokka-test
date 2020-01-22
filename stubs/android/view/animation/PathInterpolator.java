/*
 * Copyright (C) 2013 The Android Open Source Project
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

package android.view.animation;

import android.graphics.Path;

/**
 * An interpolator that can traverse a Path that extends from <code>Point</code>
 * <code>(0, 0)</code> to <code>(1, 1)</code>. The x coordinate along the <code>Path</code>
 * is the input value and the output is the y coordinate of the line at that point.
 * This means that the Path must conform to a function <code>y = f(x)</code>.
 *
 * <p>The <code>Path</code> must not have gaps in the x direction and must not
 * loop back on itself such that there can be two points sharing the same x coordinate.
 * It is alright to have a disjoint line in the vertical direction:</p>
 * <p><blockquote><pre>
 *     Path path = new Path();
 *     path.lineTo(0.25f, 0.25f);
 *     path.moveTo(0.25f, 0.5f);
 *     path.lineTo(1f, 1f);
 * </pre></blockquote></p>
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PathInterpolator extends android.view.animation.BaseInterpolator {

/**
 * Create an interpolator for an arbitrary <code>Path</code>. The <code>Path</code>
 * must begin at <code>(0, 0)</code> and end at <code>(1, 1)</code>.
 *
 * @param path The <code>Path</code> to use to make the line representing the interpolator.
 * @apiSince 21
 */

public PathInterpolator(android.graphics.Path path) { throw new RuntimeException("Stub!"); }

/**
 * Create an interpolator for a quadratic Bezier curve. The end points
 * <code>(0, 0)</code> and <code>(1, 1)</code> are assumed.
 *
 * @param controlX The x coordinate of the quadratic Bezier control point.
 * @param controlY The y coordinate of the quadratic Bezier control point.
 * @apiSince 21
 */

public PathInterpolator(float controlX, float controlY) { throw new RuntimeException("Stub!"); }

/**
 * Create an interpolator for a cubic Bezier curve.  The end points
 * <code>(0, 0)</code> and <code>(1, 1)</code> are assumed.
 *
 * @param controlX1 The x coordinate of the first control point of the cubic Bezier.
 * @param controlY1 The y coordinate of the first control point of the cubic Bezier.
 * @param controlX2 The x coordinate of the second control point of the cubic Bezier.
 * @param controlY2 The y coordinate of the second control point of the cubic Bezier.
 * @apiSince 21
 */

public PathInterpolator(float controlX1, float controlY1, float controlX2, float controlY2) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public PathInterpolator(android.content.Context context, android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/**
 * Using the line in the Path in this interpolator that can be described as
 * <code>y = f(x)</code>, finds the y coordinate of the line given <code>t</code>
 * as the x coordinate. Values less than 0 will always return 0 and values greater
 * than 1 will always return 1.
 *
 * @param t Treated as the x coordinate along the line.
 * @return The y coordinate of the Path along the line where x = <code>t</code>.
 * @see android.view.animation.Interpolator#getInterpolation(float)
 * @apiSince 21
 */

public float getInterpolation(float t) { throw new RuntimeException("Stub!"); }
}

