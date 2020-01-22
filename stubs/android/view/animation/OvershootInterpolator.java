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


package android.view.animation;


/**
 * An interpolator where the change flings forward and overshoots the last value
 * then comes back.
 * @apiSince 4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class OvershootInterpolator extends android.view.animation.BaseInterpolator {

/** @apiSince 4 */

public OvershootInterpolator() { throw new RuntimeException("Stub!"); }

/**
 * @param tension Amount of overshoot. When tension equals 0.0f, there is
 *                no overshoot and the interpolator becomes a simple
 *                deceleration interpolator.
 * @apiSince 4
 */

public OvershootInterpolator(float tension) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public OvershootInterpolator(android.content.Context context, android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public float getInterpolation(float t) { throw new RuntimeException("Stub!"); }
}

