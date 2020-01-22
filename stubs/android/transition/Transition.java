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

import android.view.ViewOverlay;
import android.view.TextureView;
import android.view.SurfaceView;
import android.content.Context;
import android.view.View;
import android.util.AttributeSet;
import android.animation.Animator;
import android.widget.ListView;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.graphics.Rect;

/**
 * A Transition holds information about animations that will be run on its
 * targets during a scene change. Subclasses of this abstract class may
 * choreograph several child transitions ({@link android.transition.TransitionSet TransitionSet} or they may
 * perform custom animations themselves. Any Transition has two main jobs:
 * (1) capture property values, and (2) play animations based on changes to
 * captured property values. A custom transition knows what property values
 * on View objects are of interest to it, and also knows how to animate
 * changes to those values. For example, the {@link android.transition.Fade Fade} transition tracks
 * changes to visibility-related properties and is able to construct and run
 * animations that fade items in or out based on changes to those properties.
 *
 * <p>Note: Transitions may not work correctly with either {@link android.view.SurfaceView SurfaceView}
 * or {@link android.view.TextureView TextureView}, due to the way that these views are displayed
 * on the screen. For SurfaceView, the problem is that the view is updated from
 * a non-UI thread, so changes to the view due to transitions (such as moving
 * and resizing the view) may be out of sync with the display inside those bounds.
 * TextureView is more compatible with transitions in general, but some
 * specific transitions (such as {@link android.transition.Fade Fade}) may not be compatible
 * with TextureView because they rely on {@link android.view.ViewOverlay ViewOverlay} functionality,
 * which does not currently work with TextureView.</p>
 *
 * <p>Transitions can be declared in XML resource files inside the <code>res/transition</code>
 * directory. Transition resources consist of a tag name for one of the Transition
 * subclasses along with attributes to define some of the attributes of that transition.
 * For example, here is a minimal resource file that declares a {@link android.transition.ChangeBounds ChangeBounds} transition:
 *
 * {@sample development/samples/ApiDemos/res/transition/changebounds.xml ChangeBounds}
 *
 * <p>This TransitionSet contains {@link android.transition.Explode} for visibility,
 * {@link android.transition.ChangeBounds}, {@link android.transition.ChangeTransform},
 * and {@link android.transition.ChangeClipBounds} and
 * {@link android.transition.ChangeImageTransform}:</p>
 *
 * {@sample development/samples/ApiDemos/res/transition/explode_move_together.xml MultipleTransform}
 *
 * <p>Custom transition classes may be instantiated with a <code>transition</code> tag:</p>
 * <pre>&lt;transition class="my.app.transition.CustomTransition"/></pre>
 * <p>Custom transition classes loaded from XML should have a public constructor taking
 * a {@link android.content.Context} and {@link android.util.AttributeSet}.</p>
 *
 * <p>Note that attributes for the transition are not required, just as they are
 * optional when declared in code; Transitions created from XML resources will use
 * the same defaults as their code-created equivalents. Here is a slightly more
 * elaborate example which declares a {@link android.transition.TransitionSet TransitionSet} transition with
 * {@link android.transition.ChangeBounds ChangeBounds} and {@link android.transition.Fade Fade} child transitions:</p>
 *
 * {@sample
 * development/samples/ApiDemos/res/transition/changebounds_fadeout_sequential.xml TransitionSet}
 *
 * <p>In this example, the transitionOrdering attribute is used on the TransitionSet
 * object to change from the default {@link android.transition.TransitionSet#ORDERING_TOGETHER TransitionSet#ORDERING_TOGETHER} behavior
 * to be {@link android.transition.TransitionSet#ORDERING_SEQUENTIAL TransitionSet#ORDERING_SEQUENTIAL} instead. Also, the {@link android.transition.Fade Fade}
 * transition uses a fadingMode of {@link android.transition.Fade#OUT Fade#OUT} instead of the default
 * out-in behavior. Finally, note the use of the <code>targets</code> sub-tag, which
 * takes a set of {@link android.R.styleable#TransitionTarget target} tags, each
 * of which lists a specific <code>targetId</code>, <code>targetClass</code>,
 * <code>targetName</code>, <code>excludeId</code>, <code>excludeClass</code>, or
 * <code>excludeName</code>, which this transition acts upon.
 * Use of targets is optional, but can be used to either limit the time spent checking
 * attributes on unchanging views, or limiting the types of animations run on specific views.
 * In this case, we know that only the <code>grayscaleContainer</code> will be
 * disappearing, so we choose to limit the {@link android.transition.Fade Fade} transition to only that view.</p>
 *
 * Further information on XML resource descriptions for transitions can be found for
 * {@link android.R.styleable#Transition}, {@link android.R.styleable#TransitionSet},
 * {@link android.R.styleable#TransitionTarget}, {@link android.R.styleable#Fade},
 * {@link android.R.styleable#Slide}, and {@link android.R.styleable#ChangeTransform}.
 *
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class Transition implements java.lang.Cloneable {

/**
 * Constructs a Transition object with no target objects. A transition with
 * no targets defaults to running on all target objects in the scene hierarchy
 * (if the transition is not contained in a TransitionSet), or all target
 * objects passed down from its parent (if it is in a TransitionSet).
 * @apiSince 19
 */

public Transition() { throw new RuntimeException("Stub!"); }

/**
 * Perform inflation from XML and apply a class-specific base style from a
 * theme attribute or style resource. This constructor of Transition allows
 * subclasses to use their own base style when they are inflating.
 *
 * @param context The Context the transition is running in, through which it can
 *        access the current theme, resources, etc.
 * @param attrs The attributes of the XML tag that is inflating the transition.
 * @apiSince 21
 */

public Transition(android.content.Context context, android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/**
 * Sets the duration of this transition. By default, there is no duration
 * (indicated by a negative number), which means that the Animator created by
 * the transition will have its own specified duration. If the duration of a
 * Transition is set, that duration will override the Animator duration.
 *
 * @param duration The length of the animation, in milliseconds.
 * @return This transition object.
 * @attr ref android.R.styleable#Transition_duration
 * @apiSince 19
 */

public android.transition.Transition setDuration(long duration) { throw new RuntimeException("Stub!"); }

/**
 * Returns the duration set on this transition. If no duration has been set,
 * the returned value will be negative, indicating that resulting animators will
 * retain their own durations.
 *
 * @return The duration set on this transition, in milliseconds, if one has been
 * set, otherwise returns a negative number.
 * @apiSince 19
 */

public long getDuration() { throw new RuntimeException("Stub!"); }

/**
 * Sets the startDelay of this transition. By default, there is no delay
 * (indicated by a negative number), which means that the Animator created by
 * the transition will have its own specified startDelay. If the delay of a
 * Transition is set, that delay will override the Animator delay.
 *
 * @param startDelay The length of the delay, in milliseconds.
 * @return This transition object.
 * @attr ref android.R.styleable#Transition_startDelay
 * @apiSince 19
 */

public android.transition.Transition setStartDelay(long startDelay) { throw new RuntimeException("Stub!"); }

/**
 * Returns the startDelay set on this transition. If no startDelay has been set,
 * the returned value will be negative, indicating that resulting animators will
 * retain their own startDelays.
 *
 * @return The startDelay set on this transition, in milliseconds, if one has
 * been set, otherwise returns a negative number.
 * @apiSince 19
 */

public long getStartDelay() { throw new RuntimeException("Stub!"); }

/**
 * Sets the interpolator of this transition. By default, the interpolator
 * is null, which means that the Animator created by the transition
 * will have its own specified interpolator. If the interpolator of a
 * Transition is set, that interpolator will override the Animator interpolator.
 *
 * @param interpolator The time interpolator used by the transition
 * @return This transition object.
 * @attr ref android.R.styleable#Transition_interpolator
 * @apiSince 19
 */

public android.transition.Transition setInterpolator(android.animation.TimeInterpolator interpolator) { throw new RuntimeException("Stub!"); }

/**
 * Returns the interpolator set on this transition. If no interpolator has been set,
 * the returned value will be null, indicating that resulting animators will
 * retain their own interpolators.
 *
 * @return The interpolator set on this transition, if one has been set, otherwise
 * returns null.
 * @apiSince 19
 */

public android.animation.TimeInterpolator getInterpolator() { throw new RuntimeException("Stub!"); }

/**
 * Returns the set of property names used stored in the {@link android.transition.TransitionValues TransitionValues}
 * object passed into {@link #captureStartValues(android.transition.TransitionValues)} that
 * this transition cares about for the purposes of canceling overlapping animations.
 * When any transition is started on a given scene root, all transitions
 * currently running on that same scene root are checked to see whether the
 * properties on which they based their animations agree with the end values of
 * the same properties in the new transition. If the end values are not equal,
 * then the old animation is canceled since the new transition will start a new
 * animation to these new values. If the values are equal, the old animation is
 * allowed to continue and no new animation is started for that transition.
 *
 * <p>A transition does not need to override this method. However, not doing so
 * will mean that the cancellation logic outlined in the previous paragraph
 * will be skipped for that transition, possibly leading to artifacts as
 * old transitions and new transitions on the same targets run in parallel,
 * animating views toward potentially different end values.</p>
 *
 * @return An array of property names as described in the class documentation for
 * {@link android.transition.TransitionValues TransitionValues}. The default implementation returns <code>null</code>.
 * @apiSince 19
 */

public java.lang.String[] getTransitionProperties() { throw new RuntimeException("Stub!"); }

/**
 * This method creates an animation that will be run for this transition
 * given the information in the startValues and endValues structures captured
 * earlier for the start and end scenes. Subclasses of Transition should override
 * this method. The method should only be called by the transition system; it is
 * not intended to be called from external classes.
 *
 * <p>This method is called by the transition's parent (all the way up to the
 * topmost Transition in the hierarchy) with the sceneRoot and start/end
 * values that the transition may need to set up initial target values
 * and construct an appropriate animation. For example, if an overall
 * Transition is a {@link android.transition.TransitionSet TransitionSet} consisting of several
 * child transitions in sequence, then some of the child transitions may
 * want to set initial values on target views prior to the overall
 * Transition commencing, to put them in an appropriate state for the
 * delay between that start and the child Transition start time. For
 * example, a transition that fades an item in may wish to set the starting
 * alpha value to 0, to avoid it blinking in prior to the transition
 * actually starting the animation. This is necessary because the scene
 * change that triggers the Transition will automatically set the end-scene
 * on all target views, so a Transition that wants to animate from a
 * different value should set that value prior to returning from this method.</p>
 *
 * <p>Additionally, a Transition can perform logic to determine whether
 * the transition needs to run on the given target and start/end values.
 * For example, a transition that resizes objects on the screen may wish
 * to avoid running for views which are not present in either the start
 * or end scenes.</p>
 *
 * <p>If there is an animator created and returned from this method, the
 * transition mechanism will apply any applicable duration, startDelay,
 * and interpolator to that animation and start it. A return value of
 * <code>null</code> indicates that no animation should run. The default
 * implementation returns null.</p>
 *
 * <p>The method is called for every applicable target object, which is
 * stored in the {@link android.transition.TransitionValues#view TransitionValues#view} field.</p>
 *
 *
 * @param sceneRoot The root of the transition hierarchy.
 * @param startValues The values for a specific target in the start scene.
 * @param endValues The values for the target in the end scene.
 * @return A Animator to be started at the appropriate time in the
 * overall transition for this scene change. A null value means no animation
 * should be run.
 * @apiSince 19
 */

public android.animation.Animator createAnimator(android.view.ViewGroup sceneRoot, android.transition.TransitionValues startValues, android.transition.TransitionValues endValues) { throw new RuntimeException("Stub!"); }

/**
 * Sets the order in which Transition matches View start and end values.
 * <p>
 * The default behavior is to match first by {@link android.view.View#getTransitionName()},
 * then by View instance, then by {@link android.view.View#getId()} and finally
 * by its item ID if it is in a direct child of ListView. The caller can
 * choose to have only some or all of the values of {@link #MATCH_INSTANCE},
 * {@link #MATCH_NAME}, {@link #MATCH_ITEM_ID}, and {@link #MATCH_ID}. Only
 * the match algorithms supplied will be used to determine whether Views are the
 * the same in both the start and end Scene. Views that do not match will be considered
 * as entering or leaving the Scene.
 * </p>
 * @param matches A list of zero or more of {@link #MATCH_INSTANCE},
 *                {@link #MATCH_NAME}, {@link #MATCH_ITEM_ID}, and {@link #MATCH_ID}.
 *                If none are provided, then the default match order will be set.
 * @apiSince 21
 */

public void setMatchOrder(int... matches) { throw new RuntimeException("Stub!"); }

/**
 * Captures the values in the start scene for the properties that this
 * transition monitors. These values are then passed as the startValues
 * structure in a later call to
 * {@link #createAnimator(android.view.ViewGroup,android.transition.TransitionValues,android.transition.TransitionValues)}.
 * The main concern for an implementation is what the
 * properties are that the transition cares about and what the values are
 * for all of those properties. The start and end values will be compared
 * later during the
 * {@link #createAnimator(android.view.ViewGroup,android.transition.TransitionValues,android.transition.TransitionValues)}
 * method to determine what, if any, animations, should be run.
 *
 * <p>Subclasses must implement this method. The method should only be called by the
 * transition system; it is not intended to be called from external classes.</p>
 *
 * @param transitionValues The holder for any values that the Transition
 * wishes to store. Values are stored in the <code>values</code> field
 * of this TransitionValues object and are keyed from
 * a String value. For example, to store a view's rotation value,
 * a transition might call
 * <code>transitionValues.values.put("appname:transitionname:rotation",
 * view.getRotation())</code>. The target view will already be stored in
 * the transitionValues structure when this method is called.
 *
 * @see #captureEndValues(TransitionValues)
 * @see #createAnimator(ViewGroup, TransitionValues, TransitionValues)
 * @apiSince 19
 */

public abstract void captureStartValues(android.transition.TransitionValues transitionValues);

/**
 * Captures the values in the end scene for the properties that this
 * transition monitors. These values are then passed as the endValues
 * structure in a later call to
 * {@link #createAnimator(android.view.ViewGroup,android.transition.TransitionValues,android.transition.TransitionValues)}.
 * The main concern for an implementation is what the
 * properties are that the transition cares about and what the values are
 * for all of those properties. The start and end values will be compared
 * later during the
 * {@link #createAnimator(android.view.ViewGroup,android.transition.TransitionValues,android.transition.TransitionValues)}
 * method to determine what, if any, animations, should be run.
 *
 * <p>Subclasses must implement this method. The method should only be called by the
 * transition system; it is not intended to be called from external classes.</p>
 *
 * @param transitionValues The holder for any values that the Transition
 * wishes to store. Values are stored in the <code>values</code> field
 * of this TransitionValues object and are keyed from
 * a String value. For example, to store a view's rotation value,
 * a transition might call
 * <code>transitionValues.values.put("appname:transitionname:rotation",
 * view.getRotation())</code>. The target view will already be stored in
 * the transitionValues structure when this method is called.
 *
 * @see #captureStartValues(TransitionValues)
 * @see #createAnimator(ViewGroup, TransitionValues, TransitionValues)
 * @apiSince 19
 */

public abstract void captureEndValues(android.transition.TransitionValues transitionValues);

/**
 * Adds the id of a target view that this Transition is interested in
 * animating. By default, there are no targetIds, and a Transition will
 * listen for changes on every view in the hierarchy below the sceneRoot
 * of the Scene being transitioned into. Setting targetIds constrains
 * the Transition to only listen for, and act on, views with these IDs.
 * Views with different IDs, or no IDs whatsoever, will be ignored.
 *
 * <p>Note that using ids to specify targets implies that ids should be unique
 * within the view hierarchy underneath the scene root.</p>
 *
 * @see android.view.View#getId()
 * @param targetId The id of a target view, must be a positive number.
 * @return The Transition to which the targetId is added.
 * Returning the same object makes it easier to chain calls during
 * construction, such as
 * <code>transitionSet.addTransitions(new Fade()).addTarget(someId);</code>
 * @apiSince 19
 */

public android.transition.Transition addTarget(int targetId) { throw new RuntimeException("Stub!"); }

/**
 * Adds the transitionName of a target view that this Transition is interested in
 * animating. By default, there are no targetNames, and a Transition will
 * listen for changes on every view in the hierarchy below the sceneRoot
 * of the Scene being transitioned into. Setting targetNames constrains
 * the Transition to only listen for, and act on, views with these transitionNames.
 * Views with different transitionNames, or no transitionName whatsoever, will be ignored.
 *
 * <p>Note that transitionNames should be unique within the view hierarchy.</p>
 *
 * @see android.view.View#getTransitionName()
 * @param targetName The transitionName of a target view, must be non-null.
 * @return The Transition to which the target transitionName is added.
 * Returning the same object makes it easier to chain calls during
 * construction, such as
 * <code>transitionSet.addTransitions(new Fade()).addTarget(someName);</code>
 * @apiSince 21
 */

public android.transition.Transition addTarget(java.lang.String targetName) { throw new RuntimeException("Stub!"); }

/**
 * Adds the Class of a target view that this Transition is interested in
 * animating. By default, there are no targetTypes, and a Transition will
 * listen for changes on every view in the hierarchy below the sceneRoot
 * of the Scene being transitioned into. Setting targetTypes constrains
 * the Transition to only listen for, and act on, views with these classes.
 * Views with different classes will be ignored.
 *
 * <p>Note that any View that can be cast to targetType will be included, so
 * if targetType is <code>View.class</code>, all Views will be included.</p>
 *
 * @see #addTarget(int)
 * @see #addTarget(android.view.View)
 * @see #excludeTarget(Class, boolean)
 * @see #excludeChildren(Class, boolean)
 *
 * @param targetType The type to include when running this transition.
 * @return The Transition to which the target class was added.
 * Returning the same object makes it easier to chain calls during
 * construction, such as
 * <code>transitionSet.addTransitions(new Fade()).addTarget(ImageView.class);</code>
 * @apiSince 21
 */

public android.transition.Transition addTarget(java.lang.Class targetType) { throw new RuntimeException("Stub!"); }

/**
 * Removes the given targetId from the list of ids that this Transition
 * is interested in animating.
 *
 * @param targetId The id of a target view, must be a positive number.
 * @return The Transition from which the targetId is removed.
 * Returning the same object makes it easier to chain calls during
 * construction, such as
 * <code>transitionSet.addTransitions(new Fade()).removeTargetId(someId);</code>
 * @apiSince 19
 */

public android.transition.Transition removeTarget(int targetId) { throw new RuntimeException("Stub!"); }

/**
 * Removes the given targetName from the list of transitionNames that this Transition
 * is interested in animating.
 *
 * @param targetName The transitionName of a target view, must not be null.
 * @return The Transition from which the targetName is removed.
 * Returning the same object makes it easier to chain calls during
 * construction, such as
 * <code>transitionSet.addTransitions(new Fade()).removeTargetName(someName);</code>
 * @apiSince 21
 */

public android.transition.Transition removeTarget(java.lang.String targetName) { throw new RuntimeException("Stub!"); }

/**
 * Whether to add the given id to the list of target ids to exclude from this
 * transition. The <code>exclude</code> parameter specifies whether the target
 * should be added to or removed from the excluded list.
 *
 * <p>Excluding targets is a general mechanism for allowing transitions to run on
 * a view hierarchy while skipping target views that should not be part of
 * the transition. For example, you may want to avoid animating children
 * of a specific ListView or Spinner. Views can be excluded either by their
 * id, or by their instance reference, or by the Class of that view
 * (eg, {@link android.widget.Spinner Spinner}).</p>
 *
 * @see #excludeChildren(int, boolean)
 * @see #excludeTarget(View, boolean)
 * @see #excludeTarget(Class, boolean)
 *
 * @param targetId The id of a target to ignore when running this transition.
 * @param exclude Whether to add the target to or remove the target from the
 * current list of excluded targets.
 * @return This transition object.
 * @apiSince 19
 */

public android.transition.Transition excludeTarget(int targetId, boolean exclude) { throw new RuntimeException("Stub!"); }

/**
 * Whether to add the given transitionName to the list of target transitionNames to exclude
 * from this transition. The <code>exclude</code> parameter specifies whether the target
 * should be added to or removed from the excluded list.
 *
 * <p>Excluding targets is a general mechanism for allowing transitions to run on
 * a view hierarchy while skipping target views that should not be part of
 * the transition. For example, you may want to avoid animating children
 * of a specific ListView or Spinner. Views can be excluded by their
 * id, their instance reference, their transitionName, or by the Class of that view
 * (eg, {@link android.widget.Spinner Spinner}).</p>
 *
 * @see #excludeTarget(View, boolean)
 * @see #excludeTarget(int, boolean)
 * @see #excludeTarget(Class, boolean)
 *
 * @param targetName The name of a target to ignore when running this transition.
 * @param exclude Whether to add the target to or remove the target from the
 * current list of excluded targets.
 * @return This transition object.
 * @apiSince 21
 */

public android.transition.Transition excludeTarget(java.lang.String targetName, boolean exclude) { throw new RuntimeException("Stub!"); }

/**
 * Whether to add the children of the given id to the list of targets to exclude
 * from this transition. The <code>exclude</code> parameter specifies whether
 * the children of the target should be added to or removed from the excluded list.
 * Excluding children in this way provides a simple mechanism for excluding all
 * children of specific targets, rather than individually excluding each
 * child individually.
 *
 * <p>Excluding targets is a general mechanism for allowing transitions to run on
 * a view hierarchy while skipping target views that should not be part of
 * the transition. For example, you may want to avoid animating children
 * of a specific ListView or Spinner. Views can be excluded either by their
 * id, or by their instance reference, or by the Class of that view
 * (eg, {@link android.widget.Spinner Spinner}).</p>
 *
 * @see #excludeTarget(int, boolean)
 * @see #excludeChildren(View, boolean)
 * @see #excludeChildren(Class, boolean)
 *
 * @param targetId The id of a target whose children should be ignored when running
 * this transition.
 * @param exclude Whether to add the target to or remove the target from the
 * current list of excluded-child targets.
 * @return This transition object.
 * @apiSince 19
 */

public android.transition.Transition excludeChildren(int targetId, boolean exclude) { throw new RuntimeException("Stub!"); }

/**
 * Whether to add the given target to the list of targets to exclude from this
 * transition. The <code>exclude</code> parameter specifies whether the target
 * should be added to or removed from the excluded list.
 *
 * <p>Excluding targets is a general mechanism for allowing transitions to run on
 * a view hierarchy while skipping target views that should not be part of
 * the transition. For example, you may want to avoid animating children
 * of a specific ListView or Spinner. Views can be excluded either by their
 * id, or by their instance reference, or by the Class of that view
 * (eg, {@link android.widget.Spinner Spinner}).</p>
 *
 * @see #excludeChildren(View, boolean)
 * @see #excludeTarget(int, boolean)
 * @see #excludeTarget(Class, boolean)
 *
 * @param target The target to ignore when running this transition.
 * @param exclude Whether to add the target to or remove the target from the
 * current list of excluded targets.
 * @return This transition object.
 * @apiSince 19
 */

public android.transition.Transition excludeTarget(android.view.View target, boolean exclude) { throw new RuntimeException("Stub!"); }

/**
 * Whether to add the children of given target to the list of target children
 * to exclude from this transition. The <code>exclude</code> parameter specifies
 * whether the target should be added to or removed from the excluded list.
 *
 * <p>Excluding targets is a general mechanism for allowing transitions to run on
 * a view hierarchy while skipping target views that should not be part of
 * the transition. For example, you may want to avoid animating children
 * of a specific ListView or Spinner. Views can be excluded either by their
 * id, or by their instance reference, or by the Class of that view
 * (eg, {@link android.widget.Spinner Spinner}).</p>
 *
 * @see #excludeTarget(View, boolean)
 * @see #excludeChildren(int, boolean)
 * @see #excludeChildren(Class, boolean)
 *
 * @param target The target to ignore when running this transition.
 * @param exclude Whether to add the target to or remove the target from the
 * current list of excluded targets.
 * @return This transition object.
 * @apiSince 19
 */

public android.transition.Transition excludeChildren(android.view.View target, boolean exclude) { throw new RuntimeException("Stub!"); }

/**
 * Whether to add the given type to the list of types to exclude from this
 * transition. The <code>exclude</code> parameter specifies whether the target
 * type should be added to or removed from the excluded list.
 *
 * <p>Excluding targets is a general mechanism for allowing transitions to run on
 * a view hierarchy while skipping target views that should not be part of
 * the transition. For example, you may want to avoid animating children
 * of a specific ListView or Spinner. Views can be excluded either by their
 * id, or by their instance reference, or by the Class of that view
 * (eg, {@link android.widget.Spinner Spinner}).</p>
 *
 * @see #excludeChildren(Class, boolean)
 * @see #excludeTarget(int, boolean)
 * @see #excludeTarget(View, boolean)
 *
 * @param type The type to ignore when running this transition.
 * @param exclude Whether to add the target type to or remove it from the
 * current list of excluded target types.
 * @return This transition object.
 * @apiSince 19
 */

public android.transition.Transition excludeTarget(java.lang.Class type, boolean exclude) { throw new RuntimeException("Stub!"); }

/**
 * Whether to add the given type to the list of types whose children should
 * be excluded from this transition. The <code>exclude</code> parameter
 * specifies whether the target type should be added to or removed from
 * the excluded list.
 *
 * <p>Excluding targets is a general mechanism for allowing transitions to run on
 * a view hierarchy while skipping target views that should not be part of
 * the transition. For example, you may want to avoid animating children
 * of a specific ListView or Spinner. Views can be excluded either by their
 * id, or by their instance reference, or by the Class of that view
 * (eg, {@link android.widget.Spinner Spinner}).</p>
 *
 * @see #excludeTarget(Class, boolean)
 * @see #excludeChildren(int, boolean)
 * @see #excludeChildren(View, boolean)
 *
 * @param type The type to ignore when running this transition.
 * @param exclude Whether to add the target type to or remove it from the
 * current list of excluded target types.
 * @return This transition object.
 * @apiSince 19
 */

public android.transition.Transition excludeChildren(java.lang.Class type, boolean exclude) { throw new RuntimeException("Stub!"); }

/**
 * Sets the target view instances that this Transition is interested in
 * animating. By default, there are no targets, and a Transition will
 * listen for changes on every view in the hierarchy below the sceneRoot
 * of the Scene being transitioned into. Setting targets constrains
 * the Transition to only listen for, and act on, these views.
 * All other views will be ignored.
 *
 * <p>The target list is like the {@link #addTarget(int) targetId}
 * list except this list specifies the actual View instances, not the ids
 * of the views. This is an important distinction when scene changes involve
 * view hierarchies which have been inflated separately; different views may
 * share the same id but not actually be the same instance. If the transition
 * should treat those views as the same, then {@link #addTarget(int)} should be used
 * instead of {@link #addTarget(android.view.View)}. If, on the other hand, scene changes involve
 * changes all within the same view hierarchy, among views which do not
 * necessarily have ids set on them, then the target list of views may be more
 * convenient.</p>
 *
 * @see #addTarget(int)
 * @param target A View on which the Transition will act, must be non-null.
 * @return The Transition to which the target is added.
 * Returning the same object makes it easier to chain calls during
 * construction, such as
 * <code>transitionSet.addTransitions(new Fade()).addTarget(someView);</code>
 * @apiSince 19
 */

public android.transition.Transition addTarget(android.view.View target) { throw new RuntimeException("Stub!"); }

/**
 * Removes the given target from the list of targets that this Transition
 * is interested in animating.
 *
 * @param target The target view, must be non-null.
 * @return Transition The Transition from which the target is removed.
 * Returning the same object makes it easier to chain calls during
 * construction, such as
 * <code>transitionSet.addTransitions(new Fade()).removeTarget(someView);</code>
 * @apiSince 19
 */

public android.transition.Transition removeTarget(android.view.View target) { throw new RuntimeException("Stub!"); }

/**
 * Removes the given target from the list of targets that this Transition
 * is interested in animating.
 *
 * @param target The type of the target view, must be non-null.
 * @return Transition The Transition from which the target is removed.
 * Returning the same object makes it easier to chain calls during
 * construction, such as
 * <code>transitionSet.addTransitions(new Fade()).removeTarget(someType);</code>
 * @apiSince 21
 */

public android.transition.Transition removeTarget(java.lang.Class target) { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of target IDs that this transition limits itself to
 * tracking and animating. If the list is null or empty for
 * {@link #getTargetIds()}, {@link #getTargets()}, {@link #getTargetNames()}, and
 * {@link #getTargetTypes()} then this transition is
 * not limited to specific views, and will handle changes to any views
 * in the hierarchy of a scene change.
 *
 * @return the list of target IDs
 * @apiSince 19
 */

public java.util.List<java.lang.Integer> getTargetIds() { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of target views that this transition limits itself to
 * tracking and animating. If the list is null or empty for
 * {@link #getTargetIds()}, {@link #getTargets()}, {@link #getTargetNames()}, and
 * {@link #getTargetTypes()} then this transition is
 * not limited to specific views, and will handle changes to any views
 * in the hierarchy of a scene change.
 *
 * @return the list of target views
 * @apiSince 19
 */

public java.util.List<android.view.View> getTargets() { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of target transitionNames that this transition limits itself to
 * tracking and animating. If the list is null or empty for
 * {@link #getTargetIds()}, {@link #getTargets()}, {@link #getTargetNames()}, and
 * {@link #getTargetTypes()} then this transition is
 * not limited to specific views, and will handle changes to any views
 * in the hierarchy of a scene change.
 *
 * @return the list of target transitionNames
 * @apiSince 21
 */

public java.util.List<java.lang.String> getTargetNames() { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of target transitionNames that this transition limits itself to
 * tracking and animating. If the list is null or empty for
 * {@link #getTargetIds()}, {@link #getTargets()}, {@link #getTargetNames()}, and
 * {@link #getTargetTypes()} then this transition is
 * not limited to specific views, and will handle changes to any views
 * in the hierarchy of a scene change.
 *
 * @return the list of target Types
 * @apiSince 21
 */

public java.util.List<java.lang.Class> getTargetTypes() { throw new RuntimeException("Stub!"); }

/**
 * This method can be called by transitions to get the TransitionValues for
 * any particular view during the transition-playing process. This might be
 * necessary, for example, to query the before/after state of related views
 * for a given transition.
 * @apiSince 19
 */

public android.transition.TransitionValues getTransitionValues(android.view.View view, boolean start) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether or not the transition should create an Animator, based on the values
 * captured during {@link #captureStartValues(android.transition.TransitionValues)} and
 * {@link #captureEndValues(android.transition.TransitionValues)}. The default implementation compares the
 * property values returned from {@link #getTransitionProperties()}, or all property values if
 * {@code getTransitionProperties()} returns null. Subclasses may override this method to
 * provide logic more specific to the transition implementation.
 *
 * @param startValues the values from captureStartValues, This may be {@code null} if the
 *                    View did not exist in the start state.
 * This value may be {@code null}.
 * @param endValues the values from captureEndValues. This may be {@code null} if the View
 *                  did not exist in the end state.
 
 * This value may be {@code null}.
 * @apiSince 23
 */

public boolean isTransitionRequired(@androidx.annotation.Nullable android.transition.TransitionValues startValues, @androidx.annotation.Nullable android.transition.TransitionValues endValues) { throw new RuntimeException("Stub!"); }

/**
 * Adds a listener to the set of listeners that are sent events through the
 * life of an animation, such as start, repeat, and end.
 *
 * @param listener the listener to be added to the current set of listeners
 * for this animation.
 * @return This transition object.
 * @apiSince 19
 */

public android.transition.Transition addListener(android.transition.Transition.TransitionListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Removes a listener from the set listening to this animation.
 *
 * @param listener the listener to be removed from the current set of
 * listeners for this transition.
 * @return This transition object.
 * @apiSince 19
 */

public android.transition.Transition removeListener(android.transition.Transition.TransitionListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Sets the callback to use to find the epicenter of a Transition. A null value indicates
 * that there is no epicenter in the Transition and onGetEpicenter() will return null.
 * Transitions like {@link android.transition.Explode} use a point or Rect to orient
 * the direction of travel. This is called the epicenter of the Transition and is
 * typically centered on a touched View. The
 * {@link android.transition.Transition.EpicenterCallback} allows a Transition to
 * dynamically retrieve the epicenter during a Transition.
 * @param epicenterCallback The callback to use to find the epicenter of the Transition.
 * @apiSince 21
 */

public void setEpicenterCallback(android.transition.Transition.EpicenterCallback epicenterCallback) { throw new RuntimeException("Stub!"); }

/**
 * Returns the callback used to find the epicenter of the Transition.
 * Transitions like {@link android.transition.Explode} use a point or Rect to orient
 * the direction of travel. This is called the epicenter of the Transition and is
 * typically centered on a touched View. The
 * {@link android.transition.Transition.EpicenterCallback} allows a Transition to
 * dynamically retrieve the epicenter during a Transition.
 * @return the callback used to find the epicenter of the Transition.
 * @apiSince 21
 */

public android.transition.Transition.EpicenterCallback getEpicenterCallback() { throw new RuntimeException("Stub!"); }

/**
 * Returns the epicenter as specified by the
 * {@link android.transition.Transition.EpicenterCallback} or null if no callback exists.
 * @return the epicenter as specified by the
 * {@link android.transition.Transition.EpicenterCallback} or null if no callback exists.
 * @see #setEpicenterCallback(android.transition.Transition.EpicenterCallback)
 * @apiSince 21
 */

public android.graphics.Rect getEpicenter() { throw new RuntimeException("Stub!"); }

/**
 * Sets the algorithm used to calculate two-dimensional interpolation.
 * <p>
 *     Transitions such as {@link android.transition.ChangeBounds} move Views, typically
 *     in a straight path between the start and end positions. Applications that desire to
 *     have these motions move in a curve can change how Views interpolate in two dimensions
 *     by extending PathMotion and implementing
 *     {@link android.transition.PathMotion#getPath(float, float, float, float)}.
 * </p>
 * <p>
 *     When describing in XML, use a nested XML tag for the path motion. It can be one of
 *     the built-in tags <code>arcMotion</code> or <code>patternPathMotion</code> or it can
 *     be a custom PathMotion using <code>pathMotion</code> with the <code>class</code>
 *     attributed with the fully-described class name. For example:</p>
 * <pre>
 * {@code
 * <changeBounds>
 *     <pathMotion class="my.app.transition.MyPathMotion"/>
 * </changeBounds>
 * }
 * </pre>
 * <p>or</p>
 * <pre>
 * {@code
 * <changeBounds>
 *   <arcMotion android:minimumHorizontalAngle="15"
 *     android:minimumVerticalAngle="0" android:maximumAngle="90"/>
 * </changeBounds>
 * }
 * </pre>
 *
 * @param pathMotion Algorithm object to use for determining how to interpolate in two
 *                   dimensions. If null, a straight-path algorithm will be used.
 * @see android.transition.ArcMotion
 * @see android.transition.PatternPathMotion
 * @see android.transition.PathMotion
 * @apiSince 21
 */

public void setPathMotion(android.transition.PathMotion pathMotion) { throw new RuntimeException("Stub!"); }

/**
 * Returns the algorithm object used to interpolate along two dimensions. This is typically
 * used to determine the View motion between two points.
 *
 * <p>
 *     When describing in XML, use a nested XML tag for the path motion. It can be one of
 *     the built-in tags <code>arcMotion</code> or <code>patternPathMotion</code> or it can
 *     be a custom PathMotion using <code>pathMotion</code> with the <code>class</code>
 *     attributed with the fully-described class name. For example:</p>
 * <pre>{@code
 * <changeBounds>
 *     <pathMotion class="my.app.transition.MyPathMotion"/>
 * </changeBounds>}
 * </pre>
 * <p>or</p>
 * <pre>{@code
 * <changeBounds>
 *   <arcMotion android:minimumHorizontalAngle="15"
 *              android:minimumVerticalAngle="0"
 *              android:maximumAngle="90"/>
 * </changeBounds>}
 * </pre>
 *
 * @return The algorithm object used to interpolate along two dimensions.
 * @see android.transition.ArcMotion
 * @see android.transition.PatternPathMotion
 * @see android.transition.PathMotion
 * @apiSince 21
 */

public android.transition.PathMotion getPathMotion() { throw new RuntimeException("Stub!"); }

/**
 * Sets the method for determining Animator start delays.
 * When a Transition affects several Views like {@link android.transition.Explode} or
 * {@link android.transition.Slide}, there may be a desire to have a "wave-front" effect
 * such that the Animator start delay depends on position of the View. The
 * TransitionPropagation specifies how the start delays are calculated.
 * @param transitionPropagation The class used to determine the start delay of
 *                              Animators created by this Transition. A null value
 *                              indicates that no delay should be used.
 * @apiSince 21
 */

public void setPropagation(android.transition.TransitionPropagation transitionPropagation) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.transition.TransitionPropagation} used to calculate Animator start
 * delays.
 * When a Transition affects several Views like {@link android.transition.Explode} or
 * {@link android.transition.Slide}, there may be a desire to have a "wave-front" effect
 * such that the Animator start delay depends on position of the View. The
 * TransitionPropagation specifies how the start delays are calculated.
 * @return the {@link android.transition.TransitionPropagation} used to calculate Animator start
 * delays. This is null by default.
 * @apiSince 21
 */

public android.transition.TransitionPropagation getPropagation() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean canRemoveViews() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public android.transition.Transition clone() { throw new RuntimeException("Stub!"); }

/**
 * Returns the name of this Transition. This name is used internally to distinguish
 * between different transitions to determine when interrupting transitions overlap.
 * For example, a ChangeBounds running on the same target view as another ChangeBounds
 * should determine whether the old transition is animating to different end values
 * and should be canceled in favor of the new transition.
 *
 * <p>By default, a Transition's name is simply the value of {@link java.lang.Class#getName() Class#getName()},
 * but subclasses are free to override and return something different.</p>
 *
 * @return The name of this transition.
 * @apiSince 19
 */

public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * With {@link #setMatchOrder(int...)}, chooses to match by
 * {@link android.view.View#getId()}. Negative IDs will not be matched.
 * @apiSince 21
 */

public static final int MATCH_ID = 3; // 0x3

/**
 * With {@link #setMatchOrder(int...)}, chooses to match by View instance.
 * @apiSince 21
 */

public static final int MATCH_INSTANCE = 1; // 0x1

/**
 * With {@link #setMatchOrder(int...)}, chooses to match by the {@link android.widget.Adapter}
 * item id. When {@link android.widget.Adapter#hasStableIds()} returns false, no match
 * will be made for items.
 * @apiSince 21
 */

public static final int MATCH_ITEM_ID = 4; // 0x4

/**
 * With {@link #setMatchOrder(int...)}, chooses to match by
 * {@link android.view.View#getTransitionName()}. Null names will not be matched.
 * @apiSince 21
 */

public static final int MATCH_NAME = 2; // 0x2
/**
 * Class to get the epicenter of Transition. Use
 * {@link #setEpicenterCallback(android.transition.Transition.EpicenterCallback)} to
 * set the callback used to calculate the epicenter of the Transition. Override
 * {@link #getEpicenter()} to return the rectangular region in screen coordinates of
 * the epicenter of the transition.
 * @see #setEpicenterCallback(android.transition.Transition.EpicenterCallback)
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class EpicenterCallback {

public EpicenterCallback() { throw new RuntimeException("Stub!"); }

/**
 * Implementers must override to return the epicenter of the Transition in screen
 * coordinates. Transitions like {@link android.transition.Explode} depend upon
 * an epicenter for the Transition. In Explode, Views move toward or away from the
 * center of the epicenter Rect along the vector between the epicenter and the center
 * of the View appearing and disappearing. Some Transitions, such as
 * {@link android.transition.Fade} pay no attention to the epicenter.
 *
 * @param transition The transition for which the epicenter applies.
 * @return The Rect region of the epicenter of <code>transition</code> or null if
 * there is no epicenter.
 * @apiSince 21
 */

public abstract android.graphics.Rect onGetEpicenter(android.transition.Transition transition);
}

/**
 * A transition listener receives notifications from a transition.
 * Notifications indicate transition lifecycle events.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface TransitionListener {

/**
 * Notification about the start of the transition.
 *
 * @param transition The started transition.
 * @apiSince 19
 */

public void onTransitionStart(android.transition.Transition transition);

/**
 * Notification about the end of the transition. Canceled transitions
 * will always notify listeners of both the cancellation and end
 * events. That is, {@link #onTransitionEnd(android.transition.Transition)} is always called,
 * regardless of whether the transition was canceled or played
 * through to completion.
 *
 * @param transition The transition which reached its end.
 * @apiSince 19
 */

public void onTransitionEnd(android.transition.Transition transition);

/**
 * Notification about the cancellation of the transition.
 * Note that cancel may be called by a parent {@link android.transition.TransitionSet TransitionSet} on
 * a child transition which has not yet started. This allows the child
 * transition to restore state on target objects which was set at
 * {@link #createAnimator(android.view.ViewGroup,android.transition.TransitionValues,android.transition.TransitionValues)
 * createAnimator()} time.
 *
 * @param transition The transition which was canceled.
 * @apiSince 19
 */

public void onTransitionCancel(android.transition.Transition transition);

/**
 * Notification when a transition is paused.
 * Note that createAnimator() may be called by a parent {@link android.transition.TransitionSet TransitionSet} on
 * a child transition which has not yet started. This allows the child
 * transition to restore state on target objects which was set at
 * {@link #createAnimator(android.view.ViewGroup,android.transition.TransitionValues,android.transition.TransitionValues)
 * createAnimator()} time.
 *
 * @param transition The transition which was paused.
 * @apiSince 19
 */

public void onTransitionPause(android.transition.Transition transition);

/**
 * Notification when a transition is resumed.
 * Note that resume() may be called by a parent {@link android.transition.TransitionSet TransitionSet} on
 * a child transition which has not yet started. This allows the child
 * transition to restore state which may have changed in an earlier call
 * to {@link #onTransitionPause(android.transition.Transition)}.
 *
 * @param transition The transition which was resumed.
 * @apiSince 19
 */

public void onTransitionResume(android.transition.Transition transition);
}

}

