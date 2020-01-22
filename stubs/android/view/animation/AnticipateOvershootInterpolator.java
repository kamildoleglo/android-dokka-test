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
 * An interpolator where the change starts backward then flings forward and overshoots
 * the target value and finally goes back to the final value.
 * @apiSince 4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AnticipateOvershootInterpolator extends android.view.animation.BaseInterpolator {

/** @apiSince 4 */

public AnticipateOvershootInterpolator() { throw new RuntimeException("Stub!"); }

/**
 * @param tension Amount of anticipation/overshoot. When tension equals 0.0f,
 *                there is no anticipation/overshoot and the interpolator becomes
 *                a simple acceleration/deceleration interpolator.
 * @apiSince 4
 */

public AnticipateOvershootInterpolator(float tension) { throw new RuntimeException("Stub!"); }

/**
 * @param tension Amount of anticipation/overshoot. When tension equals 0.0f,
 *                there is no anticipation/overshoot and the interpolator becomes
 *                a simple acceleration/deceleration interpolator.
 * @param extraTension Amount by which to multiply the tension. For instance,
 *                     to get the same overshoot as an OvershootInterpolator with
 *                     a tension of 2.0f, you would use an extraTension of 1.5f.
 * @apiSince 4
 */

public AnticipateOvershootInterpolator(float tension, float extraTension) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public AnticipateOvershootInterpolator(android.content.Context context, android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public float getInterpolation(float t) { throw new RuntimeException("Stub!"); }
}

