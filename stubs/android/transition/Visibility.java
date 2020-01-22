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

import android.view.ViewGroup;
import android.view.View;
import android.animation.Animator;
import android.content.Context;
import android.view.ViewGroupOverlay;

/**
 * This transition tracks changes to the visibility of target views in the
 * start and end scenes. Visibility is determined not just by the
 * {@link android.view.View#setVisibility(int) View#setVisibility(int)} state of views, but also whether
 * views exist in the current view hierarchy. The class is intended to be a
 * utility for subclasses such as {@link android.transition.Fade Fade}, which use this visibility
 * information to determine the specific animations to run when visibility
 * changes occur. Subclasses should implement one or both of the methods
 * {@link #onAppear(android.view.ViewGroup,android.transition.TransitionValues,int,android.transition.TransitionValues,int)},
 * {@link #onDisappear(android.view.ViewGroup,android.transition.TransitionValues,int,android.transition.TransitionValues,int)} or
 * {@link #onAppear(android.view.ViewGroup,android.view.View,android.transition.TransitionValues,android.transition.TransitionValues)},
 * {@link #onDisappear(android.view.ViewGroup,android.view.View,android.transition.TransitionValues,android.transition.TransitionValues)}.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class Visibility extends android.transition.Transition {

/** @apiSince 19 */

public Visibility() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public Visibility(android.content.Context context, android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/**
 * Changes the transition to support appearing and/or disappearing Views, depending
 * on <code>mode</code>.
 *
 * @param mode The behavior supported by this transition, a combination of
 *             {@link #MODE_IN} and {@link #MODE_OUT}.
 * Value is either <code>0</code> or a combination of {@link android.transition.Visibility#MODE_IN}, {@link android.transition.Visibility#MODE_OUT}, {@link android.transition.Fade#IN}, and {@link android.transition.Fade#OUT}
 * @attr ref android.R.styleable#VisibilityTransition_transitionVisibilityMode
 * @apiSince 21
 */

public void setMode(int mode) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether appearing and/or disappearing Views are supported.
 *
 * Returns whether appearing and/or disappearing Views are supported. A combination of
 *         {@link #MODE_IN} and {@link #MODE_OUT}.
 * @attr ref android.R.styleable#VisibilityTransition_transitionVisibilityMode
 
 * @return Value is either <code>0</code> or a combination of {@link android.transition.Visibility#MODE_IN}, {@link android.transition.Visibility#MODE_OUT}, {@link android.transition.Fade#IN}, and {@link android.transition.Fade#OUT}
 * @apiSince 21
 */

public int getMode() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public java.lang.String[] getTransitionProperties() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public void captureStartValues(android.transition.TransitionValues transitionValues) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public void captureEndValues(android.transition.TransitionValues transitionValues) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the view is 'visible' according to the given values
 * object. This is determined by testing the same properties in the values
 * object that are used to determine whether the object is appearing or
 * disappearing in the {@link android.transition.Transition#createAnimator(android.view.ViewGroup,android.transition.TransitionValues,android.transition.TransitionValues) Transition#createAnimator(ViewGroup, TransitionValues, TransitionValues)}
 * method. This method can be called by, for example, subclasses that want
 * to know whether the object is visible in the same way that Visibility
 * determines it for the actual animation.
 *
 * @param values The TransitionValues object that holds the information by
 * which visibility is determined.
 * @return True if the view reference by <code>values</code> is visible,
 * false otherwise.
 * @apiSince 19
 */

public boolean isVisible(android.transition.TransitionValues values) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public android.animation.Animator createAnimator(android.view.ViewGroup sceneRoot, android.transition.TransitionValues startValues, android.transition.TransitionValues endValues) { throw new RuntimeException("Stub!"); }

/**
 * The default implementation of this method calls
 * {@link #onAppear(android.view.ViewGroup,android.view.View,android.transition.TransitionValues,android.transition.TransitionValues)}.
 * Subclasses should override this method or
 * {@link #onAppear(android.view.ViewGroup,android.view.View,android.transition.TransitionValues,android.transition.TransitionValues)}.
 * if they need to create an Animator when targets appear.
 * The method should only be called by the Visibility class; it is
 * not intended to be called from external classes.
 *
 * @param sceneRoot The root of the transition hierarchy
 * @param startValues The target values in the start scene
 * @param startVisibility The target visibility in the start scene
 * @param endValues The target values in the end scene
 * @param endVisibility The target visibility in the end scene
 * @return An Animator to be started at the appropriate time in the
 * overall transition for this scene change. A null value means no animation
 * should be run.
 * @apiSince 19
 */

public android.animation.Animator onAppear(android.view.ViewGroup sceneRoot, android.transition.TransitionValues startValues, int startVisibility, android.transition.TransitionValues endValues, int endVisibility) { throw new RuntimeException("Stub!"); }

/**
 * The default implementation of this method returns a null Animator. Subclasses should
 * override this method to make targets appear with the desired transition. The
 * method should only be called from
 * {@link #onAppear(android.view.ViewGroup,android.transition.TransitionValues,int,android.transition.TransitionValues,int)}.
 *
 * @param sceneRoot The root of the transition hierarchy
 * @param view The View to make appear. This will be in the target scene's View hierarchy and
 *             will be VISIBLE.
 * @param startValues The target values in the start scene
 * @param endValues The target values in the end scene
 * @return An Animator to be started at the appropriate time in the
 * overall transition for this scene change. A null value means no animation
 * should be run.
 * @apiSince 21
 */

public android.animation.Animator onAppear(android.view.ViewGroup sceneRoot, android.view.View view, android.transition.TransitionValues startValues, android.transition.TransitionValues endValues) { throw new RuntimeException("Stub!"); }

/**
 * Subclasses should override this method or
 * {@link #onDisappear(android.view.ViewGroup,android.view.View,android.transition.TransitionValues,android.transition.TransitionValues)}
 * if they need to create an Animator when targets disappear.
 * The method should only be called by the Visibility class; it is
 * not intended to be called from external classes.
 * <p>
 * The default implementation of this method attempts to find a View to use to call
 * {@link #onDisappear(android.view.ViewGroup,android.view.View,android.transition.TransitionValues,android.transition.TransitionValues)},
 * based on the situation of the View in the View hierarchy. For example,
 * if a View was simply removed from its parent, then the View will be added
 * into a {@link android.view.ViewGroupOverlay} and passed as the <code>view</code>
 * parameter in {@link #onDisappear(android.view.ViewGroup,android.view.View,android.transition.TransitionValues,android.transition.TransitionValues)}.
 * If a visible View is changed to be {@link android.view.View#GONE View#GONE} or {@link android.view.View#INVISIBLE View#INVISIBLE},
 * then it can be used as the <code>view</code> and the visibility will be changed
 * to {@link android.view.View#VISIBLE View#VISIBLE} for the duration of the animation. However, if a View
 * is in a hierarchy which is also altering its visibility, the situation can be
 * more complicated. In general, if a view that is no longer in the hierarchy in
 * the end scene still has a parent (so its parent hierarchy was removed, but it
 * was not removed from its parent), then it will be left alone to avoid side-effects from
 * improperly removing it from its parent. The only exception to this is if
 * the previous {@link android.transition.Scene Scene} was {@link android.transition.Scene#getSceneForLayout(android.view.ViewGroup,int,android.content.Context) Scene#getSceneForLayout(ViewGroup, int,
 * android.content.Context)}, then it is considered
 * safe to un-parent the starting scene view in order to make it disappear.</p>
 *
 * @param sceneRoot The root of the transition hierarchy
 * @param startValues The target values in the start scene
 * @param startVisibility The target visibility in the start scene
 * @param endValues The target values in the end scene
 * @param endVisibility The target visibility in the end scene
 * @return An Animator to be started at the appropriate time in the
 * overall transition for this scene change. A null value means no animation
 * should be run.
 * @apiSince 19
 */

public android.animation.Animator onDisappear(android.view.ViewGroup sceneRoot, android.transition.TransitionValues startValues, int startVisibility, android.transition.TransitionValues endValues, int endVisibility) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public boolean isTransitionRequired(android.transition.TransitionValues startValues, android.transition.TransitionValues newValues) { throw new RuntimeException("Stub!"); }

/**
 * The default implementation of this method returns a null Animator. Subclasses should
 * override this method to make targets disappear with the desired transition. The
 * method should only be called from
 * {@link #onDisappear(android.view.ViewGroup,android.transition.TransitionValues,int,android.transition.TransitionValues,int)}.
 *
 * @param sceneRoot The root of the transition hierarchy
 * @param view The View to make disappear. This will be in the target scene's View
 *             hierarchy or in an {@link android.view.ViewGroupOverlay} and will be
 *             VISIBLE.
 * @param startValues The target values in the start scene
 * @param endValues The target values in the end scene
 * @return An Animator to be started at the appropriate time in the
 * overall transition for this scene change. A null value means no animation
 * should be run.
 * @apiSince 21
 */

public android.animation.Animator onDisappear(android.view.ViewGroup sceneRoot, android.view.View view, android.transition.TransitionValues startValues, android.transition.TransitionValues endValues) { throw new RuntimeException("Stub!"); }

/**
 * Mode used in {@link #setMode(int)} to make the transition
 * operate on targets that are appearing. Maybe be combined with
 * {@link #MODE_OUT} to target Visibility changes both in and out.
 * @apiSince 21
 */

public static final int MODE_IN = 1; // 0x1

/**
 * Mode used in {@link #setMode(int)} to make the transition
 * operate on targets that are disappearing. Maybe be combined with
 * {@link #MODE_IN} to target Visibility changes both in and out.
 * @apiSince 21
 */

public static final int MODE_OUT = 2; // 0x2
}

