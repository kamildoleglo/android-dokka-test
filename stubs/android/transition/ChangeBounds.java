/*
 * Copyright (C) 2013 The Android Open Source Project
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

import android.graphics.Rect;
import android.view.View;

/**
 * This transition captures the layout bounds of target views before and after
 * the scene change and animates those changes during the transition.
 *
 * <p>A ChangeBounds transition can be described in a resource file by using the
 * tag <code>changeBounds</code>, using its attributes of
 * {@link android.R.styleable#ChangeBounds} along with the other standard
 * attributes of {@link android.R.styleable#Transition}.</p>
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ChangeBounds extends android.transition.Transition {

/** @apiSince 19 */

public ChangeBounds() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public ChangeBounds(android.content.Context context, android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public java.lang.String[] getTransitionProperties() { throw new RuntimeException("Stub!"); }

/**
 * When <code>resizeClip</code> is true, ChangeBounds resizes the view using the clipBounds
 * instead of changing the dimensions of the view during the animation. When
 * <code>resizeClip</code> is false, ChangeBounds resizes the View by changing its dimensions.
 *
 * <p>When resizeClip is set to true, the clip bounds is modified by ChangeBounds. Therefore,
 * {@link android.transition.ChangeClipBounds} is not compatible with ChangeBounds
 * in this mode.</p>
 *
 * @param resizeClip Used to indicate whether the view bounds should be modified or the
 *                   clip bounds should be modified by ChangeBounds.
 * @see android.view.View#setClipBounds(android.graphics.Rect)
 * @attr ref android.R.styleable#ChangeBounds_resizeClip
 * @apiSince 19
 */

public void setResizeClip(boolean resizeClip) { throw new RuntimeException("Stub!"); }

/**
 * Returns true when the ChangeBounds will resize by changing the clip bounds during the
 * view animation or false when bounds are changed. The default value is false.
 *
 * @return true when the ChangeBounds will resize by changing the clip bounds during the
 * view animation or false when bounds are changed. The default value is false.
 * @attr ref android.R.styleable#ChangeBounds_resizeClip
 * @apiSince 22
 */

public boolean getResizeClip() { throw new RuntimeException("Stub!"); }

/**
 * Setting this flag tells ChangeBounds to track the before/after parent
 * of every view using this transition. The flag is not enabled by
 * default because it requires the parent instances to be the same
 * in the two scenes or else all parents must use ids to allow
 * the transition to determine which parents are the same.
 *
 * @param reparent true if the transition should track the parent
 * container of target views and animate parent changes.
 * @deprecated Use {@link android.transition.ChangeTransform} to handle
 * transitions between different parents.
 * @apiSince 19
 * @deprecatedSince 21
 */

@Deprecated
public void setReparent(boolean reparent) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public void captureStartValues(android.transition.TransitionValues transitionValues) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public void captureEndValues(android.transition.TransitionValues transitionValues) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public android.animation.Animator createAnimator(android.view.ViewGroup sceneRoot, android.transition.TransitionValues startValues, android.transition.TransitionValues endValues) { throw new RuntimeException("Stub!"); }
}

