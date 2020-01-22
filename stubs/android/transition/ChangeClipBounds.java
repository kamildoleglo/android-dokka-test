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
 * ChangeClipBounds captures the {@link android.view.View#getClipBounds()} before and after the
 * scene change and animates those changes during the transition.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ChangeClipBounds extends android.transition.Transition {

/** @apiSince 21 */

public ChangeClipBounds() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public ChangeClipBounds(android.content.Context context, android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public java.lang.String[] getTransitionProperties() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void captureStartValues(android.transition.TransitionValues transitionValues) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void captureEndValues(android.transition.TransitionValues transitionValues) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public android.animation.Animator createAnimator(android.view.ViewGroup sceneRoot, android.transition.TransitionValues startValues, android.transition.TransitionValues endValues) { throw new RuntimeException("Stub!"); }
}

