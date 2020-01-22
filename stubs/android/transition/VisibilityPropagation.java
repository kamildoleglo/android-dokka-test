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
 * Base class for <code>TransitionPropagation</code>s that care about
 * View Visibility and the center position of the View.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class VisibilityPropagation extends android.transition.TransitionPropagation {

public VisibilityPropagation() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void captureValues(android.transition.TransitionValues values) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public java.lang.String[] getPropagationProperties() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@link android.view.View#getVisibility()} for the View at the time the values
 * were captured.
 * @param values The TransitionValues captured at the start or end of the Transition.
 * @return {@link android.view.View#getVisibility()} for the View at the time the values
 * were captured.
 * @apiSince 21
 */

public int getViewVisibility(android.transition.TransitionValues values) { throw new RuntimeException("Stub!"); }

/**
 * Returns the View's center x coordinate, relative to the screen, at the time the values
 * were captured.
 * @param values The TransitionValues captured at the start or end of the Transition.
 * @return the View's center x coordinate, relative to the screen, at the time the values
 * were captured.
 * @apiSince 21
 */

public int getViewX(android.transition.TransitionValues values) { throw new RuntimeException("Stub!"); }

/**
 * Returns the View's center y coordinate, relative to the screen, at the time the values
 * were captured.
 * @param values The TransitionValues captured at the start or end of the Transition.
 * @return the View's center y coordinate, relative to the screen, at the time the values
 * were captured.
 * @apiSince 21
 */

public int getViewY(android.transition.TransitionValues values) { throw new RuntimeException("Stub!"); }
}

