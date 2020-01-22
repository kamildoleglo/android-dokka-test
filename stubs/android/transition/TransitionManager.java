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
 * This class manages the set of transitions that fire when there is a
 * change of {@link android.transition.Scene Scene}. To use the manager, add scenes along with
 * transition objects with calls to {@link #setTransition(android.transition.Scene,android.transition.Transition)}
 * or {@link #setTransition(android.transition.Scene,android.transition.Scene,android.transition.Transition)}. Setting specific
 * transitions for scene changes is not required; by default, a Scene change
 * will use {@link android.transition.AutoTransition AutoTransition} to do something reasonable for most
 * situations. Specifying other transitions for particular scene changes is
 * only necessary if the application wants different transition behavior
 * in these situations.
 *
 * <p>TransitionManagers can be declared in XML resource files inside the
 * <code>res/transition</code> directory. TransitionManager resources consist of
 * the <code>transitionManager</code>tag name, containing one or more
 * <code>transition</code> tags, each of which describe the relationship of
 * that transition to the from/to scene information in that tag.
 * For example, here is a resource file that declares several scene
 * transitions:</p>
 *
 * {@sample development/samples/ApiDemos/res/transition/transitions_mgr.xml TransitionManager}
 *
 * <p>For each of the <code>fromScene</code> and <code>toScene</code> attributes,
 * there is a reference to a standard XML layout file. This is equivalent to
 * creating a scene from a layout in code by calling
 * {@link android.transition.Scene#getSceneForLayout(android.view.ViewGroup,int,android.content.Context) Scene#getSceneForLayout(ViewGroup, int, Context)}. For the
 * <code>transition</code> attribute, there is a reference to a resource
 * file in the <code>res/transition</code> directory which describes that
 * transition.</p>
 *
 * Information on XML resource descriptions for transitions can be found for
 * {@link android.R.styleable#Transition}, {@link android.R.styleable#TransitionSet},
 * {@link android.R.styleable#TransitionTarget}, {@link android.R.styleable#Fade},
 * and {@link android.R.styleable#TransitionManager}.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TransitionManager {

public TransitionManager() { throw new RuntimeException("Stub!"); }

/**
 * Sets a specific transition to occur when the given scene is entered.
 *
 * @param scene The scene which, when applied, will cause the given
 * transition to run.
 * @param transition The transition that will play when the given scene is
 * entered. A value of null will result in the default behavior of
 * using the default transition instead.
 * @apiSince 19
 */

public void setTransition(android.transition.Scene scene, android.transition.Transition transition) { throw new RuntimeException("Stub!"); }

/**
 * Sets a specific transition to occur when the given pair of scenes is
 * exited/entered.
 *
 * @param fromScene The scene being exited when the given transition will
 * be run
 * @param toScene The scene being entered when the given transition will
 * be run
 * @param transition The transition that will play when the given scene is
 * entered. A value of null will result in the default behavior of
 * using the default transition instead.
 * @apiSince 19
 */

public void setTransition(android.transition.Scene fromScene, android.transition.Scene toScene, android.transition.Transition transition) { throw new RuntimeException("Stub!"); }

/**
 * Change to the given scene, using the
 * appropriate transition for this particular scene change
 * (as specified to the TransitionManager, or the default
 * if no such transition exists).
 *
 * @param scene The Scene to change to
 * @apiSince 19
 */

public void transitionTo(android.transition.Scene scene) { throw new RuntimeException("Stub!"); }

/**
 * Convenience method to simply change to the given scene using
 * the default transition for TransitionManager.
 *
 * @param scene The Scene to change to
 * @apiSince 19
 */

public static void go(android.transition.Scene scene) { throw new RuntimeException("Stub!"); }

/**
 * Convenience method to simply change to the given scene using
 * the given transition.
 *
 * <p>Passing in <code>null</code> for the transition parameter will
 * result in the scene changing without any transition running, and is
 * equivalent to calling {@link android.transition.Scene#exit() Scene#exit()} on the scene root's
 * current scene, followed by {@link android.transition.Scene#enter() Scene#enter()} on the scene
 * specified by the <code>scene</code> parameter.</p>
 *
 * @param scene The Scene to change to
 * @param transition The transition to use for this scene change. A
 * value of null causes the scene change to happen with no transition.
 * @apiSince 19
 */

public static void go(android.transition.Scene scene, android.transition.Transition transition) { throw new RuntimeException("Stub!"); }

/**
 * Convenience method to animate, using the default transition,
 * to a new scene defined by all changes within the given scene root between
 * calling this method and the next rendering frame.
 * Equivalent to calling {@link #beginDelayedTransition(android.view.ViewGroup,android.transition.Transition)}
 * with a value of <code>null</code> for the <code>transition</code> parameter.
 *
 * @param sceneRoot The root of the View hierarchy to run the transition on.
 * @apiSince 19
 */

public static void beginDelayedTransition(android.view.ViewGroup sceneRoot) { throw new RuntimeException("Stub!"); }

/**
 * Convenience method to animate to a new scene defined by all changes within
 * the given scene root between calling this method and the next rendering frame.
 * Calling this method causes TransitionManager to capture current values in the
 * scene root and then post a request to run a transition on the next frame.
 * At that time, the new values in the scene root will be captured and changes
 * will be animated. There is no need to create a Scene; it is implied by
 * changes which take place between calling this method and the next frame when
 * the transition begins.
 *
 * <p>Calling this method several times before the next frame (for example, if
 * unrelated code also wants to make dynamic changes and run a transition on
 * the same scene root), only the first call will trigger capturing values
 * and exiting the current scene. Subsequent calls to the method with the
 * same scene root during the same frame will be ignored.</p>
 *
 * <p>Passing in <code>null</code> for the transition parameter will
 * cause the TransitionManager to use its default transition.</p>
 *
 * @param sceneRoot The root of the View hierarchy to run the transition on.
 * @param transition The transition to use for this change. A
 * value of null causes the TransitionManager to use the default transition.
 * @apiSince 19
 */

public static void beginDelayedTransition(android.view.ViewGroup sceneRoot, android.transition.Transition transition) { throw new RuntimeException("Stub!"); }

/**
 * Ends all pending and ongoing transitions on the specified scene root.
 *
 * @param sceneRoot The root of the View hierarchy to end transitions on.
 * @apiSince 23
 */

public static void endTransitions(android.view.ViewGroup sceneRoot) { throw new RuntimeException("Stub!"); }
}

