/*
 * Copyright (C) 2010 The Android Open Source Project
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

import android.view.ViewGroup;
import android.view.View;

/**
 * This class enables automatic animations on layout changes in ViewGroup objects. To enable
 * transitions for a layout container, create a LayoutTransition object and set it on any
 * ViewGroup by calling {@link android.view.ViewGroup#setLayoutTransition(android.animation.LayoutTransition) ViewGroup#setLayoutTransition(LayoutTransition)}. This will cause
 * default animations to run whenever items are added to or removed from that container. To specify
 * custom animations, use the {@link android.animation.LayoutTransition#setAnimator(int,android.animation.Animator) LayoutTransition#setAnimator(int, Animator)} method.
 *
 * <p>One of the core concepts of these transition animations is that there are two types of
 * changes that cause the transition and four different animations that run because of
 * those changes. The changes that trigger the transition are items being added to a container
 * (referred to as an "appearing" transition) or removed from a container (also known as
 * "disappearing"). Setting the visibility of views (between GONE and VISIBLE) will trigger
 * the same add/remove logic. The animations that run due to those events are one that animates
 * items being added, one that animates items being removed, and two that animate the other
 * items in the container that change due to the add/remove occurrence. Users of
 * the transition may want different animations for the changing items depending on whether
 * they are changing due to an appearing or disappearing event, so there is one animation for
 * each of these variations of the changing event. Most of the API of this class is concerned
 * with setting up the basic properties of the animations used in these four situations,
 * or with setting up custom animations for any or all of the four.</p>
 *
 * <p>By default, the DISAPPEARING animation begins immediately, as does the CHANGE_APPEARING
 * animation. The other animations begin after a delay that is set to the default duration
 * of the animations. This behavior facilitates a sequence of animations in transitions as
 * follows: when an item is being added to a layout, the other children of that container will
 * move first (thus creating space for the new item), then the appearing animation will run to
 * animate the item being added. Conversely, when an item is removed from a container, the
 * animation to remove it will run first, then the animations of the other children in the
 * layout will run (closing the gap created in the layout when the item was removed). If this
 * default choreography behavior is not desired, the {@link #setDuration(int,long)} and
 * {@link #setStartDelay(int,long)} of any or all of the animations can be changed as
 * appropriate. Keep in mind, however, that if you start an APPEARING animation before a
 * DISAPPEARING animation is completed, the DISAPPEARING animation stops, and any effects from
 * the DISAPPEARING animation are reverted. If you instead start a DISAPPEARING animation
 * before an APPEARING animation is completed, a similar set of effects occurs for the
 * APPEARING animation.</p>
 *
 * <p>The animations specified for the transition, both the defaults and any custom animations
 * set on the transition object, are templates only. That is, these animations exist to hold the
 * basic animation properties, such as the duration, start delay, and properties being animated.
 * But the actual target object, as well as the start and end values for those properties, are
 * set automatically in the process of setting up the transition each time it runs. Each of the
 * animations is cloned from the original copy and the clone is then populated with the dynamic
 * values of the target being animated (such as one of the items in a layout container that is
 * moving as a result of the layout event) as well as the values that are changing (such as the
 * position and size of that object). The actual values that are pushed to each animation
 * depends on what properties are specified for the animation. For example, the default
 * CHANGE_APPEARING animation animates the <code>left</code>, <code>top</code>, <code>right</code>,
 * <code>bottom</code>, <code>scrollX</code>, and <code>scrollY</code> properties.
 * Values for these properties are updated with the pre- and post-layout
 * values when the transition begins. Custom animations will be similarly populated with
 * the target and values being animated, assuming they use ObjectAnimator objects with
 * property names that are known on the target object.</p>
 *
 * <p>This class, and the associated XML flag for containers, animateLayoutChanges="true",
 * provides a simple utility meant for automating changes in straightforward situations.
 * Using LayoutTransition at multiple levels of a nested view hierarchy may not work due to the
 * interrelationship of the various levels of layout. Also, a container that is being scrolled
 * at the same time as items are being added or removed is probably not a good candidate for
 * this utility, because the before/after locations calculated by LayoutTransition
 * may not match the actual locations when the animations finish due to the container
 * being scrolled as the animations are running. You can work around that
 * particular issue by disabling the 'changing' animations by setting the CHANGE_APPEARING
 * and CHANGE_DISAPPEARING animations to null, and setting the startDelay of the
 * other animations appropriately.</p>
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class LayoutTransition {

/**
 * Constructs a LayoutTransition object. By default, the object will listen to layout
 * events on any ViewGroup that it is set on and will run default animations for each
 * type of layout event.
 * @apiSince 11
 */

public LayoutTransition() { throw new RuntimeException("Stub!"); }

/**
 * Sets the duration to be used by all animations of this transition object. If you want to
 * set the duration of just one of the animations in particular, use the
 * {@link #setDuration(int,long)} method.
 *
 * @param duration The length of time, in milliseconds, that the transition animations
 * should last.
 * @apiSince 11
 */

public void setDuration(long duration) { throw new RuntimeException("Stub!"); }

/**
 * Enables the specified transitionType for this LayoutTransition object.
 * By default, a LayoutTransition listens for changes in children being
 * added/remove/hidden/shown in the container, and runs the animations associated with
 * those events. That is, all transition types besides {@link #CHANGING} are enabled by default.
 * You can also enable {@link #CHANGING} animations by calling this method with the
 * {@link #CHANGING} transitionType.
 *
 * @param transitionType One of {@link #CHANGE_APPEARING}, {@link #CHANGE_DISAPPEARING},
 * {@link #CHANGING}, {@link #APPEARING}, or {@link #DISAPPEARING}.
 * @apiSince 16
 */

public void enableTransitionType(int transitionType) { throw new RuntimeException("Stub!"); }

/**
 * Disables the specified transitionType for this LayoutTransition object.
 * By default, all transition types except {@link #CHANGING} are enabled.
 *
 * @param transitionType One of {@link #CHANGE_APPEARING}, {@link #CHANGE_DISAPPEARING},
 * {@link #CHANGING}, {@link #APPEARING}, or {@link #DISAPPEARING}.
 * @apiSince 16
 */

public void disableTransitionType(int transitionType) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the specified transitionType is enabled for this LayoutTransition object.
 * By default, all transition types except {@link #CHANGING} are enabled.
 *
 * @param transitionType One of {@link #CHANGE_APPEARING}, {@link #CHANGE_DISAPPEARING},
 * {@link #CHANGING}, {@link #APPEARING}, or {@link #DISAPPEARING}.
 * @return true if the specified transitionType is currently enabled, false otherwise.
 * @apiSince 16
 */

public boolean isTransitionTypeEnabled(int transitionType) { throw new RuntimeException("Stub!"); }

/**
 * Sets the start delay on one of the animation objects used by this transition. The
 * <code>transitionType</code> parameter determines the animation whose start delay
 * is being set.
 *
 * @param transitionType One of {@link #CHANGE_APPEARING}, {@link #CHANGE_DISAPPEARING},
 * {@link #CHANGING}, {@link #APPEARING}, or {@link #DISAPPEARING}, which determines
 * the animation whose start delay is being set.
 * @param delay The length of time, in milliseconds, to delay before starting the animation.
 * @see android.animation.Animator#setStartDelay(long)
 * @apiSince 11
 */

public void setStartDelay(int transitionType, long delay) { throw new RuntimeException("Stub!"); }

/**
 * Gets the start delay on one of the animation objects used by this transition. The
 * <code>transitionType</code> parameter determines the animation whose start delay
 * is returned.
 *
 * @param transitionType One of {@link #CHANGE_APPEARING}, {@link #CHANGE_DISAPPEARING},
 * {@link #CHANGING}, {@link #APPEARING}, or {@link #DISAPPEARING}, which determines
 * the animation whose start delay is returned.
 * @return long The start delay of the specified animation.
 * @see android.animation.Animator#getStartDelay()
 * @apiSince 11
 */

public long getStartDelay(int transitionType) { throw new RuntimeException("Stub!"); }

/**
 * Sets the duration on one of the animation objects used by this transition. The
 * <code>transitionType</code> parameter determines the animation whose duration
 * is being set.
 *
 * @param transitionType One of {@link #CHANGE_APPEARING}, {@link #CHANGE_DISAPPEARING},
 * {@link #CHANGING}, {@link #APPEARING}, or {@link #DISAPPEARING}, which determines
 * the animation whose duration is being set.
 * @param duration The length of time, in milliseconds, that the specified animation should run.
 * @see android.animation.Animator#setDuration(long)
 * @apiSince 11
 */

public void setDuration(int transitionType, long duration) { throw new RuntimeException("Stub!"); }

/**
 * Gets the duration on one of the animation objects used by this transition. The
 * <code>transitionType</code> parameter determines the animation whose duration
 * is returned.
 *
 * @param transitionType One of {@link #CHANGE_APPEARING}, {@link #CHANGE_DISAPPEARING},
 * {@link #CHANGING}, {@link #APPEARING}, or {@link #DISAPPEARING}, which determines
 * the animation whose duration is returned.
 * @return long The duration of the specified animation.
 * @see android.animation.Animator#getDuration()
 * @apiSince 11
 */

public long getDuration(int transitionType) { throw new RuntimeException("Stub!"); }

/**
 * Sets the length of time to delay between starting each animation during one of the
 * change animations.
 *
 * @param transitionType A value of {@link #CHANGE_APPEARING}, {@link #CHANGE_DISAPPEARING}, or
 * {@link #CHANGING}.
 * @param duration The length of time, in milliseconds, to delay before launching the next
 * animation in the sequence.
 * @apiSince 11
 */

public void setStagger(int transitionType, long duration) { throw new RuntimeException("Stub!"); }

/**
 * Gets the length of time to delay between starting each animation during one of the
 * change animations.
 *
 * @param transitionType A value of {@link #CHANGE_APPEARING}, {@link #CHANGE_DISAPPEARING}, or
 * {@link #CHANGING}.
 * @return long The length of time, in milliseconds, to delay before launching the next
 * animation in the sequence.
 * @apiSince 11
 */

public long getStagger(int transitionType) { throw new RuntimeException("Stub!"); }

/**
 * Sets the interpolator on one of the animation objects used by this transition. The
 * <code>transitionType</code> parameter determines the animation whose interpolator
 * is being set.
 *
 * @param transitionType One of {@link #CHANGE_APPEARING}, {@link #CHANGE_DISAPPEARING},
 * {@link #CHANGING}, {@link #APPEARING}, or {@link #DISAPPEARING}, which determines
 * the animation whose interpolator is being set.
 * @param interpolator The interpolator that the specified animation should use.
 * @see android.animation.Animator#setInterpolator(TimeInterpolator)
 * @apiSince 11
 */

public void setInterpolator(int transitionType, android.animation.TimeInterpolator interpolator) { throw new RuntimeException("Stub!"); }

/**
 * Gets the interpolator on one of the animation objects used by this transition. The
 * <code>transitionType</code> parameter determines the animation whose interpolator
 * is returned.
 *
 * @param transitionType One of {@link #CHANGE_APPEARING}, {@link #CHANGE_DISAPPEARING},
 * {@link #CHANGING}, {@link #APPEARING}, or {@link #DISAPPEARING}, which determines
 * the animation whose interpolator is being returned.
 * @return TimeInterpolator The interpolator that the specified animation uses.
 * @see android.animation.Animator#setInterpolator(TimeInterpolator)
 * @apiSince 11
 */

public android.animation.TimeInterpolator getInterpolator(int transitionType) { throw new RuntimeException("Stub!"); }

/**
 * Sets the animation used during one of the transition types that may run. Any
 * Animator object can be used, but to be most useful in the context of layout
 * transitions, the animation should either be a ObjectAnimator or a AnimatorSet
 * of animations including PropertyAnimators. Also, these ObjectAnimator objects
 * should be able to get and set values on their target objects automatically. For
 * example, a ObjectAnimator that animates the property "left" is able to set and get the
 * <code>left</code> property from the View objects being animated by the layout
 * transition. The transition works by setting target objects and properties
 * dynamically, according to the pre- and post-layoout values of those objects, so
 * having animations that can handle those properties appropriately will work best
 * for custom animation. The dynamic setting of values is only the case for the
 * CHANGE animations; the APPEARING and DISAPPEARING animations are simply run with
 * the values they have.
 *
 * <p>It is also worth noting that any and all animations (and their underlying
 * PropertyValuesHolder objects) will have their start and end values set according
 * to the pre- and post-layout values. So, for example, a custom animation on "alpha"
 * as the CHANGE_APPEARING animation will inherit the real value of alpha on the target
 * object (presumably 1) as its starting and ending value when the animation begins.
 * Animations which need to use values at the beginning and end that may not match the
 * values queried when the transition begins may need to use a different mechanism
 * than a standard ObjectAnimator object.</p>
 *
 * @param transitionType One of {@link #CHANGE_APPEARING}, {@link #CHANGE_DISAPPEARING},
 * {@link #CHANGING}, {@link #APPEARING}, or {@link #DISAPPEARING}, which determines the
 * animation whose animator is being set.
 * @param animator The animation being assigned. A value of <code>null</code> means that no
 * animation will be run for the specified transitionType.
 * @apiSince 11
 */

public void setAnimator(int transitionType, android.animation.Animator animator) { throw new RuntimeException("Stub!"); }

/**
 * Gets the animation used during one of the transition types that may run.
 *
 * @param transitionType One of {@link #CHANGE_APPEARING}, {@link #CHANGE_DISAPPEARING},
 * {@link #CHANGING}, {@link #APPEARING}, or {@link #DISAPPEARING}, which determines
 * the animation whose animator is being returned.
 * @return Animator The animation being used for the given transition type.
 * @see #setAnimator(int, Animator)
 * @apiSince 11
 */

public android.animation.Animator getAnimator(int transitionType) { throw new RuntimeException("Stub!"); }

/**
 * This flag controls whether CHANGE_APPEARING or CHANGE_DISAPPEARING animations will
 * cause the default changing animation to be run on the parent hierarchy as well. This allows
 * containers of transitioning views to also transition, which may be necessary in situations
 * where the containers bounds change between the before/after states and may clip their
 * children during the transition animations. For example, layouts with wrap_content will
 * adjust their bounds according to the dimensions of their children.
 *
 * <p>The default changing transitions animate the bounds and scroll positions of the
 * target views. These are the animations that will run on the parent hierarchy, not
 * the custom animations that happen to be set on the transition. This allows custom
 * behavior for the children of the transitioning container, but uses standard behavior
 * of resizing/rescrolling on any changing parents.
 *
 * @param animateParentHierarchy A boolean value indicating whether the parents of
 * transitioning views should also be animated during the transition. Default value is true.
 * @apiSince 14
 */

public void setAnimateParentHierarchy(boolean animateParentHierarchy) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if animations are running which animate layout-related properties. This
 * essentially means that either CHANGE_APPEARING or CHANGE_DISAPPEARING animations
 * are running, since these animations operate on layout-related properties.
 *
 * @return true if CHANGE_APPEARING or CHANGE_DISAPPEARING animations are currently
 * running.
 * @apiSince 11
 */

public boolean isChangingLayout() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if any of the animations in this transition are currently running.
 *
 * @return true if any animations in the transition are running.
 * @apiSince 11
 */

public boolean isRunning() { throw new RuntimeException("Stub!"); }

/**
 * This method is called by ViewGroup when a child view is about to be added to the
 * container. This callback starts the process of a transition; we grab the starting
 * values, listen for changes to all of the children of the container, and start appropriate
 * animations.
 *
 * @param parent The ViewGroup to which the View is being added.
 * @param child The View being added to the ViewGroup.
 * @apiSince 11
 */

public void addChild(android.view.ViewGroup parent, android.view.View child) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #showChild(android.view.ViewGroup,android.view.View,int)}.
 * @apiSince 11
 * @deprecatedSince 16
 */

@Deprecated
public void showChild(android.view.ViewGroup parent, android.view.View child) { throw new RuntimeException("Stub!"); }

/**
 * This method is called by ViewGroup when a child view is about to be made visible in the
 * container. This callback starts the process of a transition; we grab the starting
 * values, listen for changes to all of the children of the container, and start appropriate
 * animations.
 *
 * @param parent The ViewGroup in which the View is being made visible.
 * @param child The View being made visible.
 * @param oldVisibility The previous visibility value of the child View, either
 * {@link android.view.View#GONE View#GONE} or {@link android.view.View#INVISIBLE View#INVISIBLE}.
 * @apiSince 16
 */

public void showChild(android.view.ViewGroup parent, android.view.View child, int oldVisibility) { throw new RuntimeException("Stub!"); }

/**
 * This method is called by ViewGroup when a child view is about to be removed from the
 * container. This callback starts the process of a transition; we grab the starting
 * values, listen for changes to all of the children of the container, and start appropriate
 * animations.
 *
 * @param parent The ViewGroup from which the View is being removed.
 * @param child The View being removed from the ViewGroup.
 * @apiSince 11
 */

public void removeChild(android.view.ViewGroup parent, android.view.View child) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #hideChild(android.view.ViewGroup,android.view.View,int)}.
 * @apiSince 11
 * @deprecatedSince 16
 */

@Deprecated
public void hideChild(android.view.ViewGroup parent, android.view.View child) { throw new RuntimeException("Stub!"); }

/**
 * This method is called by ViewGroup when a child view is about to be hidden in
 * container. This callback starts the process of a transition; we grab the starting
 * values, listen for changes to all of the children of the container, and start appropriate
 * animations.
 *
 * @param parent The parent ViewGroup of the View being hidden.
 * @param child The View being hidden.
 * @param newVisibility The new visibility value of the child View, either
 * {@link android.view.View#GONE View#GONE} or {@link android.view.View#INVISIBLE View#INVISIBLE}.
 * @apiSince 16
 */

public void hideChild(android.view.ViewGroup parent, android.view.View child, int newVisibility) { throw new RuntimeException("Stub!"); }

/**
 * Add a listener that will be called when the bounds of the view change due to
 * layout processing.
 *
 * @param listener The listener that will be called when layout bounds change.
 * @apiSince 11
 */

public void addTransitionListener(android.animation.LayoutTransition.TransitionListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Remove a listener for layout changes.
 *
 * @param listener The listener for layout bounds change.
 * @apiSince 11
 */

public void removeTransitionListener(android.animation.LayoutTransition.TransitionListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Gets the current list of listeners for layout changes.
 * @return
 * @apiSince 11
 */

public java.util.List<android.animation.LayoutTransition.TransitionListener> getTransitionListeners() { throw new RuntimeException("Stub!"); }

/**
 * A flag indicating the animation that runs on those items that are appearing
 * in the container.
 * @apiSince 11
 */

public static final int APPEARING = 2; // 0x2

/**
 * A flag indicating the animation that runs on those items that are changing
 * due to a new item appearing in the container.
 * @apiSince 11
 */

public static final int CHANGE_APPEARING = 0; // 0x0

/**
 * A flag indicating the animation that runs on those items that are changing
 * due to an item disappearing from the container.
 * @apiSince 11
 */

public static final int CHANGE_DISAPPEARING = 1; // 0x1

/**
 * A flag indicating the animation that runs on those items that are changing
 * due to a layout change not caused by items being added to or removed
 * from the container. This transition type is not enabled by default; it can be
 * enabled via {@link #enableTransitionType(int)}.
 * @apiSince 16
 */

public static final int CHANGING = 4; // 0x4

/**
 * A flag indicating the animation that runs on those items that are disappearing
 * from the container.
 * @apiSince 11
 */

public static final int DISAPPEARING = 3; // 0x3
/**
 * This interface is used for listening to starting and ending events for transitions.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface TransitionListener {

/**
 * This event is sent to listeners when any type of transition animation begins.
 *
 * @param transition The LayoutTransition sending out the event.
 * @param container The ViewGroup on which the transition is playing.
 * @param view The View object being affected by the transition animation.
 * @param transitionType The type of transition that is beginning,
 * {@link android.animation.LayoutTransition#APPEARING},
 * {@link android.animation.LayoutTransition#DISAPPEARING},
 * {@link android.animation.LayoutTransition#CHANGE_APPEARING}, or
 * {@link android.animation.LayoutTransition#CHANGE_DISAPPEARING}.
 * @apiSince 11
 */

public void startTransition(android.animation.LayoutTransition transition, android.view.ViewGroup container, android.view.View view, int transitionType);

/**
 * This event is sent to listeners when any type of transition animation ends.
 *
 * @param transition The LayoutTransition sending out the event.
 * @param container The ViewGroup on which the transition is playing.
 * @param view The View object being affected by the transition animation.
 * @param transitionType The type of transition that is ending,
 * {@link android.animation.LayoutTransition#APPEARING},
 * {@link android.animation.LayoutTransition#DISAPPEARING},
 * {@link android.animation.LayoutTransition#CHANGE_APPEARING}, or
 * {@link android.animation.LayoutTransition#CHANGE_DISAPPEARING}.
 * @apiSince 11
 */

public void endTransition(android.animation.LayoutTransition transition, android.view.ViewGroup container, android.view.View view, int transitionType);
}

}

