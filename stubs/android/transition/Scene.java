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

import android.view.View;
import android.view.ViewGroup;

/**
 * A scene represents the collection of values that various properties in the
 * View hierarchy will have when the scene is applied. A Scene can be
 * configured to automatically run a Transition when it is applied, which will
 * animate the various property changes that take place during the
 * scene change.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Scene {

/**
 * Constructs a Scene with no information about how values will change
 * when this scene is applied. This constructor might be used when
 * a Scene is created with the intention of being dynamically configured,
 * through setting {@link #setEnterAction(java.lang.Runnable)} and possibly
 * {@link #setExitAction(java.lang.Runnable)}.
 *
 * @param sceneRoot The root of the hierarchy in which scene changes
 * and transitions will take place.
 * @apiSince 19
 */

public Scene(android.view.ViewGroup sceneRoot) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a Scene which, when entered, will remove any
 * children from the sceneRoot container and add the layout
 * object as a new child of that container.
 *
 * @param sceneRoot The root of the hierarchy in which scene changes
 * and transitions will take place.
 * @param layout The view hierarchy of this scene, added as a child
 * of sceneRoot when this scene is entered.
 * @apiSince 21
 */

public Scene(android.view.ViewGroup sceneRoot, android.view.View layout) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated use {@link #Scene(android.view.ViewGroup,android.view.View)}.
 * @apiSince 19
 */

@Deprecated
public Scene(android.view.ViewGroup sceneRoot, android.view.ViewGroup layout) { throw new RuntimeException("Stub!"); }

/**
 * Returns a Scene described by the resource file associated with the given
 * <code>layoutId</code> parameter. If such a Scene has already been created for
 * the given <code>sceneRoot</code>, that same Scene will be returned.
 * This caching of layoutId-based scenes enables sharing of common scenes
 * between those created in code and those referenced by {@link android.transition.TransitionManager TransitionManager}
 * XML resource files.
 *
 * @param sceneRoot The root of the hierarchy in which scene changes
 * and transitions will take place.
 * @param layoutId The id of a standard layout resource file.
 * @param context The context used in the process of inflating
 * the layout resource.
 * @return The scene for the given root and layout id
 * @apiSince 19
 */

public static android.transition.Scene getSceneForLayout(android.view.ViewGroup sceneRoot, int layoutId, android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Gets the root of the scene, which is the root of the view hierarchy
 * affected by changes due to this scene, and which will be animated
 * when this scene is entered.
 *
 * @return The root of the view hierarchy affected by this scene.
 * @apiSince 19
 */

public android.view.ViewGroup getSceneRoot() { throw new RuntimeException("Stub!"); }

/**
 * Exits this scene, if it is the current scene
 * on the scene's {@link #getSceneRoot() scene root}. The current scene is
 * set when {@link #enter() entering} a scene.
 * Exiting a scene runs the {@link #setExitAction(java.lang.Runnable) exit action}
 * if there is one.
 * @apiSince 19
 */

public void exit() { throw new RuntimeException("Stub!"); }

/**
 * Enters this scene, which entails changing all values that
 * are specified by this scene. These may be values associated
 * with a layout view group or layout resource file which will
 * now be added to the scene root, or it may be values changed by
 * an {@link #setEnterAction(java.lang.Runnable)} enter action}, or a
 * combination of the these. No transition will be run when the
 * scene is entered. To get transition behavior in scene changes,
 * use one of the methods in {@link android.transition.TransitionManager TransitionManager} instead.
 * @apiSince 19
 */

public void enter() { throw new RuntimeException("Stub!"); }

/**
 * Gets the current {@link android.transition.Scene Scene} set on the given ViewGroup. A scene is set on a ViewGroup
 * only if that ViewGroup is the scene root.
 *
 * @param sceneRoot The ViewGroup on which the current scene will be returned
 * This value must never be {@code null}.
 * @return The current Scene set on this ViewGroup. A value of null indicates that
 * no Scene is currently set.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public static android.transition.Scene getCurrentScene(@androidx.annotation.NonNull android.view.ViewGroup sceneRoot) { throw new RuntimeException("Stub!"); }

/**
 * Scenes that are not defined with layout resources or
 * hierarchies, or which need to perform additional steps
 * after those hierarchies are changed to, should set an enter
 * action, and possibly an exit action as well. An enter action
 * will cause Scene to call back into application code to do
 * anything else the application needs after transitions have
 * captured pre-change values and after any other scene changes
 * have been applied, such as the layout (if any) being added to
 * the view hierarchy. After this method is called, Transitions will
 * be played.
 *
 * @param action The runnable whose {@link java.lang.Runnable#run() Runnable#run()} method will
 * be called when this scene is entered
 * @see #setExitAction(Runnable)
 * @see android.transition.Scene#Scene(ViewGroup, View)
 * @apiSince 19
 */

public void setEnterAction(java.lang.Runnable action) { throw new RuntimeException("Stub!"); }

/**
 * Scenes that are not defined with layout resources or
 * hierarchies, or which need to perform additional steps
 * after those hierarchies are changed to, should set an enter
 * action, and possibly an exit action as well. An exit action
 * will cause Scene to call back into application code to do
 * anything the application needs to do after applicable transitions have
 * captured pre-change values, but before any other scene changes
 * have been applied, such as the new layout (if any) being added to
 * the view hierarchy. After this method is called, the next scene
 * will be entered, including a call to {@link #setEnterAction(java.lang.Runnable)}
 * if an enter action is set.
 *
 * @see #setEnterAction(Runnable)
 * @see android.transition.Scene#Scene(ViewGroup, View)
 * @apiSince 19
 */

public void setExitAction(java.lang.Runnable action) { throw new RuntimeException("Stub!"); }
}

