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


package android.view.animation;


/**
 * An interpolator where the rate of change starts out quickly and
 * and then decelerates.
 *
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DecelerateInterpolator extends android.view.animation.BaseInterpolator {

/** @apiSince 1 */

public DecelerateInterpolator() { throw new RuntimeException("Stub!"); }

/**
 * Constructor
 *
 * @param factor Degree to which the animation should be eased. Setting factor to 1.0f produces
 *        an upside-down y=x^2 parabola. Increasing factor above 1.0f exaggerates the
 *        ease-out effect (i.e., it starts even faster and ends evens slower).
 * @apiSince 1
 */

public DecelerateInterpolator(float factor) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public DecelerateInterpolator(android.content.Context context, android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public float getInterpolation(float input) { throw new RuntimeException("Stub!"); }
}

