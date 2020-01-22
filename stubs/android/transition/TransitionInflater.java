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

import android.content.res.Resources;

/**
 * This class inflates scenes and transitions from resource files.
 *
 * Information on XML resource descriptions for transitions can be found for
 * {@link android.R.styleable#Transition}, {@link android.R.styleable#TransitionSet},
 * {@link android.R.styleable#TransitionTarget}, {@link android.R.styleable#Fade},
 * and {@link android.R.styleable#TransitionManager}.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TransitionInflater {

private TransitionInflater() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the TransitionInflater from the given context.
 * @apiSince 19
 */

public static android.transition.TransitionInflater from(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Loads a {@link android.transition.Transition Transition} object from a resource
 *
 * @param resource The resource id of the transition to load
 * @return The loaded Transition object
 * @throws android.content.res.Resources.NotFoundException when the
 * transition cannot be loaded
 * @apiSince 19
 */

public android.transition.Transition inflateTransition(int resource) { throw new RuntimeException("Stub!"); }

/**
 * Loads a {@link android.transition.TransitionManager TransitionManager} object from a resource
 *
 * @param resource The resource id of the transition manager to load
 * @return The loaded TransitionManager object
 * @throws android.content.res.Resources.NotFoundException when the
 * transition manager cannot be loaded
 * @apiSince 19
 */

public android.transition.TransitionManager inflateTransitionManager(int resource, android.view.ViewGroup sceneRoot) { throw new RuntimeException("Stub!"); }
}

