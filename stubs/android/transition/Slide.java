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
import android.view.Gravity;

/**
 * This transition tracks changes to the visibility of target views in the
 * start and end scenes and moves views in or out from one of the edges of the
 * scene. Visibility is determined by both the
 * {@link android.view.View#setVisibility(int) View#setVisibility(int)} state of the view as well as whether it
 * is parented in the current view hierarchy. Disappearing Views are
 * limited as described in {@link android.transition.Visibility#onDisappear(android.view.ViewGroup,android.transition.TransitionValues,int,android.transition.TransitionValues,int) Visibility#onDisappear(android.view.ViewGroup,
 * TransitionValues, int, TransitionValues, int)}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Slide extends android.transition.Visibility {

/**
 * Constructor using the default {@link android.view.Gravity#BOTTOM Gravity#BOTTOM}
 * slide edge direction.
 * @apiSince 21
 */

public Slide() { throw new RuntimeException("Stub!"); }

/**
 * Constructor using the provided slide edge direction.
 
 * @param slideEdge Value is {@link android.view.Gravity#LEFT}, {@link android.view.Gravity#TOP}, {@link android.view.Gravity#RIGHT}, {@link android.view.Gravity#BOTTOM}, {@link android.view.Gravity#START}, or {@link android.view.Gravity#END}
 * @apiSince 21
 */

public Slide(int slideEdge) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public Slide(android.content.Context context, android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void captureStartValues(android.transition.TransitionValues transitionValues) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void captureEndValues(android.transition.TransitionValues transitionValues) { throw new RuntimeException("Stub!"); }

/**
 * Change the edge that Views appear and disappear from.
 *
 * @param slideEdge The edge of the scene to use for Views appearing and disappearing. One of
 *                  {@link android.view.Gravity#LEFT}, {@link android.view.Gravity#TOP},
 *                  {@link android.view.Gravity#RIGHT}, {@link android.view.Gravity#BOTTOM},
 *                  {@link android.view.Gravity#START}, {@link android.view.Gravity#END}.
 * Value is {@link android.view.Gravity#LEFT}, {@link android.view.Gravity#TOP}, {@link android.view.Gravity#RIGHT}, {@link android.view.Gravity#BOTTOM}, {@link android.view.Gravity#START}, or {@link android.view.Gravity#END}
 * @attr ref android.R.styleable#Slide_slideEdge
 * @apiSince 21
 */

public void setSlideEdge(int slideEdge) { throw new RuntimeException("Stub!"); }

/**
 * Returns the edge that Views appear and disappear from.
 *
 * @return the edge of the scene to use for Views appearing and disappearing. One of
 *         {@link android.view.Gravity#LEFT}, {@link android.view.Gravity#TOP},
 *         {@link android.view.Gravity#RIGHT}, {@link android.view.Gravity#BOTTOM},
 *         {@link android.view.Gravity#START}, {@link android.view.Gravity#END}.
 * Value is {@link android.view.Gravity#LEFT}, {@link android.view.Gravity#TOP}, {@link android.view.Gravity#RIGHT}, {@link android.view.Gravity#BOTTOM}, {@link android.view.Gravity#START}, or {@link android.view.Gravity#END}
 * @attr ref android.R.styleable#Slide_slideEdge
 * @apiSince 21
 */

public int getSlideEdge() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public android.animation.Animator onAppear(android.view.ViewGroup sceneRoot, android.view.View view, android.transition.TransitionValues startValues, android.transition.TransitionValues endValues) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public android.animation.Animator onDisappear(android.view.ViewGroup sceneRoot, android.view.View view, android.transition.TransitionValues startValues, android.transition.TransitionValues endValues) { throw new RuntimeException("Stub!"); }
}

