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

import android.graphics.Rect;

/**
 * This evaluator can be used to perform type interpolation between <code>Rect</code> values.
 * @apiSince 18
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class RectEvaluator implements android.animation.TypeEvaluator<android.graphics.Rect> {

/**
 * Construct a RectEvaluator that returns a new Rect on every evaluate call.
 * To avoid creating an object for each evaluate call,
 * {@link android.animation.RectEvaluator#RectEvaluator(android.graphics.Rect) RectEvaluator#RectEvaluator(android.graphics.Rect)} should be used
 * whenever possible.
 * @apiSince 18
 */

public RectEvaluator() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a RectEvaluator that modifies and returns <code>reuseRect</code>
 * in {@link #evaluate(float,android.graphics.Rect,android.graphics.Rect)} calls.
 * The value returned from
 * {@link #evaluate(float,android.graphics.Rect,android.graphics.Rect)} should
 * not be cached because it will change over time as the object is reused on each
 * call.
 *
 * @param reuseRect A Rect to be modified and returned by evaluate.
 * @apiSince 21
 */

public RectEvaluator(android.graphics.Rect reuseRect) { throw new RuntimeException("Stub!"); }

/**
 * This function returns the result of linearly interpolating the start and
 * end Rect values, with <code>fraction</code> representing the proportion
 * between the start and end values. The calculation is a simple parametric
 * calculation on each of the separate components in the Rect objects
 * (left, top, right, and bottom).
 *
 * <p>If {@link #RectEvaluator(android.graphics.Rect)} was used to construct
 * this RectEvaluator, the object returned will be the <code>reuseRect</code>
 * passed into the constructor.</p>
 *
 * @param fraction   The fraction from the starting to the ending values
 * @param startValue The start Rect
 * @param endValue   The end Rect
 * @return A linear interpolation between the start and end values, given the
 *         <code>fraction</code> parameter.
 * @apiSince 18
 */

public android.graphics.Rect evaluate(float fraction, android.graphics.Rect startValue, android.graphics.Rect endValue) { throw new RuntimeException("Stub!"); }
}

