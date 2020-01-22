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

import android.content.Context;
import android.view.ViewGroup;
import android.view.View;

/**
 * This transition tracks changes to the visibility of target views in the
 * start and end scenes and fades views in or out when they become visible
 * or non-visible. Visibility is determined by both the
 * {@link android.view.View#setVisibility(int) View#setVisibility(int)} state of the view as well as whether it
 * is parented in the current view hierarchy.
 *
 * <p>The ability of this transition to fade out a particular view, and the
 * way that that fading operation takes place, is based on
 * the situation of the view in the view hierarchy. For example, if a view was
 * simply removed from its parent, then the view will be added into a {@link
 * android.view.ViewGroupOverlay} while fading. If a visible view is
 * changed to be {@link android.view.View#GONE View#GONE} or {@link android.view.View#INVISIBLE View#INVISIBLE}, then the
 * visibility will be changed to {@link android.view.View#VISIBLE View#VISIBLE} for the duration of
 * the animation. However, if a view is in a hierarchy which is also altering
 * its visibility, the situation can be more complicated. In general, if a
 * view that is no longer in the hierarchy in the end scene still has a
 * parent (so its parent hierarchy was removed, but it was not removed from
 * its parent), then it will be left alone to avoid side-effects from
 * improperly removing it from its parent. The only exception to this is if
 * the previous {@link android.transition.Scene Scene} was
 * {@link android.transition.Scene#getSceneForLayout(android.view.ViewGroup,int,android.content.Context) Scene#getSceneForLayout(android.view.ViewGroup, int, android.content.Context)}, then it is considered safe to un-parent
 * the starting scene view in order to fade it out.</p>
 *
 * <p>A Fade transition can be described in a resource file by using the
 * tag <code>fade</code>, along with the standard
 * attributes of {@link android.R.styleable#Fade} and
 * {@link android.R.styleable#Transition}.</p>
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Fade extends android.transition.Visibility {

/**
 * Constructs a Fade transition that will fade targets in and out.
 * @apiSince 19
 */

public Fade() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a Fade transition that will fade targets in
 * and/or out, according to the value of fadingMode.
 *
 * @param fadingMode The behavior of this transition, a combination of
 * {@link #IN} and {@link #OUT}.
 
 * Value is either <code>0</code> or a combination of {@link android.transition.Visibility#MODE_IN}, {@link android.transition.Visibility#MODE_OUT}, {@link android.transition.Fade#IN}, and {@link android.transition.Fade#OUT}
 * @apiSince 19
 */

public Fade(int fadingMode) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public Fade(android.content.Context context, android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public void captureStartValues(android.transition.TransitionValues transitionValues) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public android.animation.Animator onAppear(android.view.ViewGroup sceneRoot, android.view.View view, android.transition.TransitionValues startValues, android.transition.TransitionValues endValues) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public android.animation.Animator onDisappear(android.view.ViewGroup sceneRoot, android.view.View view, android.transition.TransitionValues startValues, android.transition.TransitionValues endValues) { throw new RuntimeException("Stub!"); }

/**
 * Fading mode used in {@link #Fade(int)} to make the transition
 * operate on targets that are appearing. Maybe be combined with
 * {@link #OUT} to fade both in and out. Equivalent to
 * {@link android.transition.Visibility#MODE_IN Visibility#MODE_IN}.
 * @apiSince 19
 */

public static final int IN = 1; // 0x1

/**
 * Fading mode used in {@link #Fade(int)} to make the transition
 * operate on targets that are disappearing. Maybe be combined with
 * {@link #IN} to fade both in and out. Equivalent to
 * {@link android.transition.Visibility#MODE_OUT Visibility#MODE_OUT}.
 * @apiSince 19
 */

public static final int OUT = 2; // 0x2
}

