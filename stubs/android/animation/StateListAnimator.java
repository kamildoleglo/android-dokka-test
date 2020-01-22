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


package android.animation;

import android.view.View;

/**
 * Lets you define a number of Animators that will run on the attached View depending on the View's
 * drawable state.
 * <p>
 * It can be defined in an XML file with the <code>&lt;selector></code> element.
 * Each State Animator is defined in a nested <code>&lt;item></code> element.
 *
 * @attr ref android.R.styleable#DrawableStates_state_focused
 * @attr ref android.R.styleable#DrawableStates_state_window_focused
 * @attr ref android.R.styleable#DrawableStates_state_enabled
 * @attr ref android.R.styleable#DrawableStates_state_checkable
 * @attr ref android.R.styleable#DrawableStates_state_checked
 * @attr ref android.R.styleable#DrawableStates_state_selected
 * @attr ref android.R.styleable#DrawableStates_state_activated
 * @attr ref android.R.styleable#DrawableStates_state_active
 * @attr ref android.R.styleable#DrawableStates_state_single
 * @attr ref android.R.styleable#DrawableStates_state_first
 * @attr ref android.R.styleable#DrawableStates_state_middle
 * @attr ref android.R.styleable#DrawableStates_state_last
 * @attr ref android.R.styleable#DrawableStates_state_pressed
 * @attr ref android.R.styleable#StateListAnimatorItem_animation
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class StateListAnimator implements java.lang.Cloneable {

/** @apiSince 21 */

public StateListAnimator() { throw new RuntimeException("Stub!"); }

/**
 * Associates the given animator with the provided drawable state specs so that it will be run
 * when the View's drawable state matches the specs.
 *
 * @param specs The drawable state specs to match against
 * @param animator The animator to run when the specs match
 * @apiSince 21
 */

public void addState(int[] specs, android.animation.Animator animator) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public android.animation.StateListAnimator clone() { throw new RuntimeException("Stub!"); }

/**
 * If there is an animation running for a recent state change, ends it.
 * <p>
 * This causes the animation to assign the end value(s) to the View.
 * @apiSince 21
 */

public void jumpToCurrentState() { throw new RuntimeException("Stub!"); }
}

