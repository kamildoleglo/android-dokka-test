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

import android.view.ViewGroup;
import android.view.View;

/**
 * This transition tracks changes to the visibility of target views in the
 * start and end scenes and moves views in or out from the edges of the
 * scene. Visibility is determined by both the
 * {@link android.view.View#setVisibility(int) View#setVisibility(int)} state of the view as well as whether it
 * is parented in the current view hierarchy. Disappearing Views are
 * limited as described in {@link android.transition.Visibility#onDisappear(android.view.ViewGroup,android.transition.TransitionValues,int,android.transition.TransitionValues,int) Visibility#onDisappear(android.view.ViewGroup,
 * TransitionValues, int, TransitionValues, int)}.
 * <p>Views move away from the focal View or the center of the Scene if
 * no epicenter was provided.</p>
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Explode extends android.transition.Visibility {

/** @apiSince 21 */

public Explode() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public Explode(android.content.Context context, android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void captureStartValues(android.transition.TransitionValues transitionValues) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void captureEndValues(android.transition.TransitionValues transitionValues) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public android.animation.Animator onAppear(android.view.ViewGroup sceneRoot, android.view.View view, android.transition.TransitionValues startValues, android.transition.TransitionValues endValues) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public android.animation.Animator onDisappear(android.view.ViewGroup sceneRoot, android.view.View view, android.transition.TransitionValues startValues, android.transition.TransitionValues endValues) { throw new RuntimeException("Stub!"); }
}

