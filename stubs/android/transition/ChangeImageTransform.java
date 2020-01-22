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

import android.widget.ImageView;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.animation.Animator;

/**
 * This Transition captures an ImageView's matrix before and after the
 * scene change and animates it during the transition.
 *
 * <p>In combination with ChangeBounds, ChangeImageTransform allows ImageViews
 * that change size, shape, or {@link android.widget.ImageView.ScaleType} to animate contents
 * smoothly.</p>
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ChangeImageTransform extends android.transition.Transition {

/** @apiSince 21 */

public ChangeImageTransform() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public ChangeImageTransform(android.content.Context context, android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void captureStartValues(android.transition.TransitionValues transitionValues) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void captureEndValues(android.transition.TransitionValues transitionValues) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public java.lang.String[] getTransitionProperties() { throw new RuntimeException("Stub!"); }

/**
 * Creates an Animator for ImageViews moving, changing dimensions, and/or changing
 * {@link android.widget.ImageView.ScaleType}.
 *
 * @param sceneRoot   The root of the transition hierarchy.
 * @param startValues The values for a specific target in the start scene.
 * @param endValues   The values for the target in the end scene.
 * @return An Animator to move an ImageView or null if the View is not an ImageView,
 * the Drawable changed, the View is not VISIBLE, or there was no change.
 * @apiSince 21
 */

public android.animation.Animator createAnimator(android.view.ViewGroup sceneRoot, android.transition.TransitionValues startValues, android.transition.TransitionValues endValues) { throw new RuntimeException("Stub!"); }
}

