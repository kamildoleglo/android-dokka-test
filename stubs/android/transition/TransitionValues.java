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

/**
 * Data structure which holds cached values for the transition.
 * The view field is the target which all of the values pertain to.
 * The values field is a map which holds information for fields
 * according to names selected by the transitions. These names should
 * be unique to avoid clobbering values stored by other transitions,
 * such as the convention project:transition_name:property_name. For
 * example, the platform might store a property "alpha" in a transition
 * "Fader" as "android:fader:alpha".
 *
 * <p>These values are cached during the
 * {@link android.transition.Transition#captureStartValues(android.transition.TransitionValues) Transition#captureStartValues(TransitionValues)}
 * capture} phases of a scene change, once when the start values are captured
 * and again when the end values are captured. These start/end values are then
 * passed into the transitions via the
 * for {@link android.transition.Transition#createAnimator(android.view.ViewGroup,android.transition.TransitionValues,android.transition.TransitionValues) Transition#createAnimator(ViewGroup, TransitionValues, TransitionValues)}
 * method.</p>
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TransitionValues {

/**
 * @deprecated Use {@link #TransitionValues(android.view.View)} instead
 * @apiSince 19
 */

@Deprecated
public TransitionValues() { throw new RuntimeException("Stub!"); }

/**
 * @param view This value must never be {@code null}.
 * @apiSince 29
 */

public TransitionValues(@androidx.annotation.NonNull android.view.View view) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public boolean equals(java.lang.Object other) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * The set of values tracked by transitions for this scene
 * @apiSince 19
 */

@androidx.annotation.NonNull public final java.util.Map<java.lang.String,java.lang.Object> values;
{ values = null; }

/**
 * The View with these values
 * @apiSince 19
 */

@androidx.annotation.NonNull public android.view.View view;
}

