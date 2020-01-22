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
import android.view.Gravity;

/**
 * A <code>TransitionPropagation</code> that propagates based on the distance to the side
 * and, orthogonally, the distance to epicenter. If the transitioning View is visible in
 * the start of the transition, then it will transition sooner when closer to the side and
 * later when farther. If the view is not visible in the start of the transition, then
 * it will transition later when closer to the side and sooner when farther from the edge.
 * This is the default TransitionPropagation used with {@link android.transition.Slide}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SidePropagation extends android.transition.VisibilityPropagation {

public SidePropagation() { throw new RuntimeException("Stub!"); }

/**
 * Sets the side that is used to calculate the transition propagation. If the transitioning
 * View is visible in the start of the transition, then it will transition sooner when
 * closer to the side and later when farther. If the view is not visible in the start of
 * the transition, then it will transition later when closer to the side and sooner when
 * farther from the edge. The default is {@link android.view.Gravity#BOTTOM Gravity#BOTTOM}.
 *
 * @param side The side that is used to calculate the transition propagation. Must be one of
 *             {@link android.view.Gravity#LEFT Gravity#LEFT}, {@link android.view.Gravity#TOP Gravity#TOP}, {@link android.view.Gravity#RIGHT Gravity#RIGHT},
 *             {@link android.view.Gravity#BOTTOM Gravity#BOTTOM}, {@link android.view.Gravity#START Gravity#START}, or {@link android.view.Gravity#END Gravity#END}.
 
 * Value is {@link android.view.Gravity#LEFT}, {@link android.view.Gravity#TOP}, {@link android.view.Gravity#RIGHT}, {@link android.view.Gravity#BOTTOM}, {@link android.view.Gravity#START}, or {@link android.view.Gravity#END}
 * @apiSince 21
 */

public void setSide(int side) { throw new RuntimeException("Stub!"); }

/**
 * Sets the speed at which transition propagation happens, relative to the duration of the
 * Transition. A <code>propagationSpeed</code> of 1 means that a View centered at the side
 * set in {@link #setSide(int)} and View centered at the opposite edge will have a difference
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

