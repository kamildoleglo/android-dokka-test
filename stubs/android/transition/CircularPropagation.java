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

import android.view.View;

/**
 * A propagation that varies with the distance to the epicenter of the Transition
 * or center of the scene if no epicenter exists. When a View is visible in the
 * start of the transition, Views farther from the epicenter will transition
 * sooner than Views closer to the epicenter. When a View is not in the start
 * of the transition or is not visible at the start of the transition, it will
 * transition sooner when closer to the epicenter and later when farther from
 * the epicenter. This is the default TransitionPropagation used with
 * {@link android.transition.Explode}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CircularPropagation extends android.transition.VisibilityPropagation {

public CircularPropagation() { throw new RuntimeException("Stub!"); }

/**
 * Sets the speed at which transition propagation happens, relative to the duration of the
 * Transition. A <code>propagationSpeed</code> of 1 means that a View centered farthest from
 * the epicenter and View centered at the epicenter will have a difference
 * in start delay of approximately the duration of the Transition. A speed of 2 means the
 * start delay difference will be approximately half of the duration of the transition. A
 * value of 0 is illegal, but negative values will invert the propagation.
 *
 * @param propagationSpeed The speed at which propagation occurs, relative to the duration
 *                         of the transition. A speed of 4 means it works 4 times as fast
 *                         as the duration of the transition. May not be 0.
 * @apiSince 21
 */

public void setPropagationSpeed(float propagationSpeed) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public long getStartDelay(android.view.ViewGroup sceneRoot, android.transition.Transition transition, android.transition.TransitionValues startValues, android.transition.TransitionValues endValues) { throw new RuntimeException("Stub!"); }
}

