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

/**
 * This Transition captures scale and rotation for Views before and after the
 * scene change and animates those changes during the transition.
 *
 * A change in parent is handled as well by capturing the transforms from
 * the parent before and after the scene change and animating those during the
 * transition.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ChangeTransform extends android.transition.Transition {

/** @apiSince 21 */

public ChangeTransform() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public ChangeTransform(android.content.Context context, android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether changes to parent should use an overlay or not. When the parent
 * change doesn't use an overlay, it affects the transforms of the child. The
 * default value is <code>true</code>.
 *
 * <p>Note: when Overlays are not used when a parent changes, a view can be clipped when
 * it moves outside the bounds of its parent. Setting
 * {@link android.view.ViewGroup#setClipChildren(boolean)} and
 * {@link android.view.ViewGroup#setClipToPadding(boolean)} can help. Also, when
 * Overlays are not used and the parent is animating its location, the position of the
 * child view will be relative to its parent's final position, so it may appear to "jump"
 * at the beginning.</p>
 *
 * @return <code>true</code> when a changed parent should execute the transition
 * inside the scene root's overlay or <code>false</code> if a parent change only
 * affects the transform of the transitioning view.
 * @attr ref android.R.styleable#ChangeTransform_reparentWithOverlay
 * @apiSince 21
 */

public boolean getReparentWithOverlay() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether changes to parent should use an overlay or not. When the parent
 * change doesn't use an overlay, it affects the transforms of the child. The
 * default value is <code>true</code>.
 *
 * <p>Note: when Overlays are not used when a parent changes, a view can be clipped when
 * it moves outside the bounds of its parent. Setting
 * {@link android.view.ViewGroup#setClipChildren(boolean)} and
 * {@link android.view.ViewGroup#setClipToPadding(boolean)} can help. Also, when
 * Overlays are not used and the parent is animating its location, the position of the
 * child view will be relative to its parent's final position, so it may appear to "jump"
 * at the beginning.</p>
 *
 * @param reparentWithOverlay <code>true</code> when a changed parent should execute the
 *                            transition inside the scene root's overlay or <code>false</code>
 *                            if a parent change only affects the transform of the transitioning
 *                            view.
 * @attr ref android.R.styleable#ChangeTransform_reparentWithOverlay
 * @apiSince 21
 */

public void setReparentWithOverlay(boolean reparentWithOverlay) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether parent changes will be tracked by the ChangeTransform. If parent
 * changes are tracked, then the transform will adjust to the transforms of the
 * different parents. If they aren't tracked, only the transforms of the transitioning
 * view will be tracked. Default is true.
 *
 * @return whether parent changes will be tracked by the ChangeTransform.
 * @attr ref android.R.styleable#ChangeTransform_reparent
 * @apiSince 21
 */

public boolean getReparent() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether parent changes will be tracked by the ChangeTransform. If parent
 * changes are tracked, then the transform will adjust to the transforms of the
 * different parents. If they aren't tracked, only the transforms of the transitioning
 * view will be tracked. Default is true.
 *
 * @param reparent Set to true to track parent changes or false to only track changes
 *                 of the transitioning view without considering the parent change.
 * @attr ref android.R.styleable#ChangeTransform_reparent
 * @apiSince 21
 */

public void setReparent(boolean reparent) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public java.lang.String[] getTransitionProperties() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void captureStartValues(android.transition.TransitionValues transitionValues) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void captureEndValues(android.transition.TransitionValues transitionValues) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public android.animation.Animator createAnimator(android.view.ViewGroup sceneRoot, android.transition.TransitionValues startValues, android.transition.TransitionValues endValues) { throw new RuntimeException("Stub!"); }
}

