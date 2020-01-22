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

package android.animation;

import android.graphics.PointF;

/**
 * This evaluator can be used to perform type interpolation between <code>PointF</code> values.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PointFEvaluator implements android.animation.TypeEvaluator<android.graphics.PointF> {

/**
 * Construct a PointFEvaluator that returns a new PointF on every evaluate call.
 * To avoid creating an object for each evaluate call,
 * {@link android.animation.PointFEvaluator#PointFEvaluator(android.graphics.PointF) PointFEvaluator#PointFEvaluator(android.graphics.PointF)} should be used
 * whenever possible.
 * @apiSince 21
 */

public PointFEvaluator() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a PointFEvaluator that modifies and returns <code>reuse</code>
 * in {@link #evaluate(float,android.graphics.PointF,android.graphics.PointF)} calls.
 * The value returned from
 * {@link #evaluate(float,android.graphics.PointF,android.graphics.PointF)} should
 * not be cached because it will change over time as the object is reused on each
 * call.
 *
 * @param reuse A PointF to be modified and returned by evaluate.
 * @apiSince 21
 */

public PointFEvaluator(android.graphics.PointF reuse) { throw new RuntimeException("Stub!"); }

/**
 * This function returns the result of linearly interpolating the start and
 * end PointF values, with <code>fraction</code> representing the proportion
 * between the start and end values. The calculation is a simple parametric
 * calculation on each of the separate components in the PointF objects
 * (x, y).
 *
 * <p>If {@link #PointFEvaluator(android.graphics.PointF)} was used to construct
 * this PointFEvaluator, the object returned will be the <code>reuse</code>
 * passed into the constructor.</p>
 *
 * @param fraction   The fraction from the starting to the ending values
 * @param startValue The start PointF
 * @param endValue   The end PointF
 * @return A linear interpolation between the start and end values, given the
 *         <code>fraction</code> parameter.
 * @apiSince 21
 */

public android.graphics.PointF evaluate(float fraction, android.graphics.PointF startValue, android.graphics.PointF endValue) { throw new RuntimeException("Stub!"); }
}

