/*
 * Copyright (C) 2010 The Android Open Source Project
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


/**
 * This evaluator can be used to perform type interpolation between <code>int</code> values.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class IntEvaluator implements android.animation.TypeEvaluator<java.lang.Integer> {

public IntEvaluator() { throw new RuntimeException("Stub!"); }

/**
 * This function returns the result of linearly interpolating the start and end values, with
 * <code>fraction</code> representing the proportion between the start and end values. The
 * calculation is a simple parametric calculation: <code>result = x0 + t * (x1 - x0)</code>,
 * where <code>x0</code> is <code>startValue</code>, <code>x1</code> is <code>endValue</code>,
 * and <code>t</code> is <code>fraction</code>.
 *
 * @param fraction   The fraction from the starting to the ending values
 * @param startValue The start value; should be of type <code>int</code> or
 *                   <code>Integer</code>
 * @param endValue   The end value; should be of type <code>int</code> or <code>Integer</code>
 * @return A linear interpolation between the start and end values, given the
 *         <code>fraction</code> parameter.
 * @apiSince 14
 */

public java.lang.Integer evaluate(float fraction, java.lang.Integer startValue, java.lang.Integer endValue) { throw new RuntimeException("Stub!"); }
}

