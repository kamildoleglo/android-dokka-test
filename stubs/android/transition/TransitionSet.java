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


/**
 * A TransitionSet is a parent of child transitions (including other
 * TransitionSets). Using TransitionSets enables more complex
 * choreography of transitions, where some sets play {@link #ORDERING_TOGETHER} and
 * others play {@link #ORDERING_SEQUENTIAL}. For example, {@link android.transition.AutoTransition AutoTransition}
 * uses a TransitionSet to sequentially play a Fade(Fade.OUT), followed by
 * a {@link android.transition.ChangeBounds ChangeBounds}, followed by a Fade(Fade.OUT) transition.
 *
 * <p>A TransitionSet can be described in a resource file by using the
 * tag <code>transitionSet</code>, along with the standard
 * attributes of {@link android.R.styleable#TransitionSet} and
 * {@link android.R.styleable#Transition}. Child transitions of the
 * TransitionSet object can be loaded by adding those child tags inside the
 * enclosing <code>transitionSet</code> tag. For example, the following xml
 * describes a TransitionSet that plays a Fade and then a ChangeBounds
 * transition on the affected view targets:</p>
 * <pre>
 *     &lt;transitionSet xmlns:android="http://schemas.android.com/apk/res/android"
 *             android:transitionOrdering="sequential"&gt;
 *         &lt;fade/&gt;
 *         &lt;changeBounds/&gt;
 *     &lt;/transitionSet&gt;
 * </pre>
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TransitionSet extends android.transition.Transition {

/**
 * Constructs an empty transition set. Add child transitions to the
 * set by calling {@link #addTransition(android.transition.Transition)} )}. By default,
 * child transitions will play {@link #ORDERING_TOGETHER together}.
 * @apiSince 19
 */

public TransitionSet() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public TransitionSet(android.content.Context context, android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/**
 * Sets the play order of this set's child transitions.
 *
 * @param ordering {@link #ORDERING_TOGETHER} to play this set's child
 * transitions together, {@link #ORDERING_SEQUENTIAL} to play the child
 * transitions in sequence.
 * @return This transitionSet object.
 * @apiSince 19
 */

public android.transition.TransitionSet setOrdering(int ordering) { throw new RuntimeException("Stub!"); }

/**
 * Returns the ordering of this TransitionSet. By default, the value is
 * {@link #ORDERING_TOGETHER}.
 *
 * @return {@link #ORDERING_TOGETHER} if child transitions will play at the same
 * time, {@link #ORDERING_SEQUENTIAL} if they will play in sequence.
 *
 * @see #setOrdering(int)
 * @apiSince 19
 */

public int getOrdering() { throw new RuntimeException("Stub!"); }

/**
 * Adds child transition to this set. The order in which this child transition
 * is added relative to other child transitions that are added, in addition to
 * the {@link #getOrdering() ordering} property, determines the
 * order in which the transitions are started.
 *
 * <p>If this transitionSet has a {@link #getDuration() duration},
 * {@link #getInterpolator() interpolator}, {@link #getPropagation() propagation delay},
 * {@link #getPathMotion() path motion}, or
 * {@link #setEpicenterCallback(android.transition.Transition.EpicenterCallback) epicenter callback}
 * set on it, the child transition will inherit the values that are set.
 * Transitions are assumed to have a maximum of one transitionSet parent.</p>
 *
 * @param transition A non-null child transition to be added to this set.
 * @return This transitionSet object.
 * @apiSince 19
 */

public android.transition.TransitionSet addTransition(android.transition.Transition transition) { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of child transitions in the TransitionSet.
 *
 * @return The number of child transitions in the TransitionSet.
 * @see #addTransition(Transition)
 * @see #getTransitionAt(int)
 * @apiSince 21
 */

public int getTransitionCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the child Transition at the specified position in the TransitionSet.
 *
 * @param index The position of the Transition to retrieve.
 * @see #addTransition(Transition)
 * @see #getTransitionCount()
 * @apiSince 21
 */

public android.transition.Transition getTransitionAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Setting a non-negative duration on a TransitionSet causes all of the child
 * transitions (current and future) to inherit this duration.
 *
 * @param duration The length of the animation, in milliseconds.
 * @return This transitionSet object.
 * @apiSince 19
 */

public android.transition.TransitionSet setDuration(long duration) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public android.transition.TransitionSet setStartDelay(long startDelay) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public android.transition.TransitionSet setInterpolator(android.animation.TimeInterpolator interpolator) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public android.transition.TransitionSet addTarget(android.view.View target) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public android.transition.TransitionSet addTarget(int targetId) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public android.transition.TransitionSet addTarget(java.lang.String targetName) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public android.transition.TransitionSet addTarget(java.lang.Class targetType) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public android.transition.TransitionSet addListener(android.transition.Transition.TransitionListener listener) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public android.transition.TransitionSet removeTarget(int targetId) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public android.transition.TransitionSet removeTarget(android.view.View target) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public android.transition.TransitionSet removeTarget(java.lang.Class target) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public android.transition.TransitionSet removeTarget(java.lang.String target) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public android.transition.Transition excludeTarget(android.view.View target, boolean exclude) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public android.transition.Transition excludeTarget(java.lang.String targetName, boolean exclude) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public android.transition.Transition excludeTarget(int targetId, boolean exclude) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public android.transition.Transition excludeTarget(java.lang.Class type, boolean exclude) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public android.transition.TransitionSet removeListener(android.transition.Transition.TransitionListener listener) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void setPathMotion(android.transition.PathMotion pathMotion) { throw new RuntimeException("Stub!"); }

/**
 * Removes the specified child transition from this set.
 *
 * @param transition The transition to be removed.
 * @return This transitionSet object.
 * @apiSince 19
 */

public android.transition.TransitionSet removeTransition(android.transition.Transition transition) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public void captureStartValues(android.transition.TransitionValues transitionValues) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public void captureEndValues(android.transition.TransitionValues transitionValues) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void setPropagation(android.transition.TransitionPropagation propagation) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void setEpicenterCallback(android.transition.Transition.EpicenterCallback epicenterCallback) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public android.transition.TransitionSet clone() { throw new RuntimeException("Stub!"); }

/**
 * A flag used to indicate that the child transitions of this set should
 * play in sequence; when one child transition ends, the next child
 * transition begins. Note that a transition does not end until all
 * instances of it (which are playing on all applicable targets of the
 * transition) end.
 * @apiSince 19
 */

public static final int ORDERING_SEQUENTIAL = 1; // 0x1

/**
 * A flag used to indicate that the child transitions of this set
 * should all start at the same time.
 * @apiSince 19
 */

public static final int ORDERING_TOGETHER = 0; // 0x0
}

