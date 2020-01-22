/*
 * Copyright (C) 2007 The Android Open Source Project
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


package android.view.animation;

import android.view.ViewGroup;
import android.view.View;
import android.content.Context;

/**
 * A layout animation controller is used to animated a layout's, or a view
 * group's, children. Each child uses the same animation but for every one of
 * them, the animation starts at a different time. A layout animation controller
 * is used by {@link android.view.ViewGroup} to compute the delay by which each
 * child's animation start must be offset. The delay is computed by using
 * characteristics of each child, like its index in the view group.
 *
 * This standard implementation computes the delay by multiplying a fixed
 * amount of miliseconds by the index of the child in its parent view group.
 * Subclasses are supposed to override
 * {@link #getDelayForView(android.view.View)} to implement a different way
 * of computing the delay. For instance, a
 * {@link android.view.animation.GridLayoutAnimationController} will compute the
 * delay based on the column and row indices of the child in its parent view
 * group.
 *
 * Information used to compute the animation delay of each child are stored
 * in an instance of
 * {@link android.view.animation.LayoutAnimationController.AnimationParameters},
 * itself stored in the {@link android.view.ViewGroup.LayoutParams} of the view.
 *
 * @attr ref android.R.styleable#LayoutAnimation_delay
 * @attr ref android.R.styleable#LayoutAnimation_animationOrder
 * @attr ref android.R.styleable#LayoutAnimation_interpolator
 * @attr ref android.R.styleable#LayoutAnimation_animation
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class LayoutAnimationController {

/**
 * Creates a new layout animation controller from external resources.
 *
 * @param context the Context the view  group is running in, through which
 *        it can access the resources
 * @param attrs the attributes of the XML tag that is inflating the
 *        layout animation controller
 * @apiSince 1
 */

public LayoutAnimationController(android.content.Context context, android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new layout animation controller with a delay of 50%
 * and the specified animation.
 *
 * @param animation the animation to use on each child of the view group
 * @apiSince 1
 */

public LayoutAnimationController(android.view.animation.Animation animation) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new layout animation controller with the specified delay
 * and the specified animation.
 *
 * @param animation the animation to use on each child of the view group
 * @param delay the delay by which each child's animation must be offset
 * @apiSince 1
 */

public LayoutAnimationController(android.view.animation.Animation animation, float delay) { throw new RuntimeException("Stub!"); }

/**
 * Returns the order used to compute the delay of each child's animation.
 *
 * @return one of {@link #ORDER_NORMAL}, {@link #ORDER_REVERSE} or
 *         {@link #ORDER_RANDOM}
 *
 * @attr ref android.R.styleable#LayoutAnimation_animationOrder
 * @apiSince 1
 */

public int getOrder() { throw new RuntimeException("Stub!"); }

/**
 * Sets the order used to compute the delay of each child's animation.
 *
 * @param order one of {@link #ORDER_NORMAL}, {@link #ORDER_REVERSE} or
 *        {@link #ORDER_RANDOM}
 *
 * @attr ref android.R.styleable#LayoutAnimation_animationOrder
 * @apiSince 1
 */

public void setOrder(int order) { throw new RuntimeException("Stub!"); }

/**
 * Sets the animation to be run on each child of the view group on which
 * this layout animation controller is .
 *
 * @param context the context from which the animation must be inflated
 * @param resourceID the resource identifier of the animation
 *
 * @see #setAnimation(Animation)
 * @see #getAnimation()
 *
 * @attr ref android.R.styleable#LayoutAnimation_animation
 * @apiSince 1
 */

public void setAnimation(android.content.Context context, int resourceID) { throw new RuntimeException("Stub!"); }

/**
 * Sets the animation to be run on each child of the view group on which
 * this layout animation controller is .
 *
 * @param animation the animation to run on each child of the view group
 
 * @see #setAnimation(android.content.Context, int)
 * @see #getAnimation()
 *
 * @attr ref android.R.styleable#LayoutAnimation_animation
 * @apiSince 1
 */

public void setAnimation(android.view.animation.Animation animation) { throw new RuntimeException("Stub!"); }

/**
 * Returns the animation applied to each child of the view group on which
 * this controller is set.
 *
 * @return an {@link android.view.animation.Animation} instance
 *
 * @see #setAnimation(android.content.Context, int)
 * @see #setAnimation(Animation)
 * @apiSince 1
 */

public android.view.animation.Animation getAnimation() { throw new RuntimeException("Stub!"); }

/**
 * Sets the interpolator used to interpolate the delays between the
 * children.
 *
 * @param context the context from which the interpolator must be inflated
 * @param resourceID the resource identifier of the interpolator
 *
 * @see #getInterpolator()
 * @see #setInterpolator(Interpolator)
 *
 * @attr ref android.R.styleable#LayoutAnimation_interpolator
 * @apiSince 1
 */

public void setInterpolator(android.content.Context context, int resourceID) { throw new RuntimeException("Stub!"); }

/**
 * Sets the interpolator used to interpolate the delays between the
 * children.
 *
 * @param interpolator the interpolator
 *
 * @see #getInterpolator()
 * @see #setInterpolator(Interpolator)
 *
 * @attr ref android.R.styleable#LayoutAnimation_interpolator
 * @apiSince 1
 */

public void setInterpolator(android.view.animation.Interpolator interpolator) { throw new RuntimeException("Stub!"); }

/**
 * Returns the interpolator used to interpolate the delays between the
 * children.
 *
 * @return an {@link android.view.animation.Interpolator}
 * @apiSince 1
 */

public android.view.animation.Interpolator getInterpolator() { throw new RuntimeException("Stub!"); }

/**
 * Returns the delay by which the children's animation are offset. The
 * delay is expressed as a fraction of the animation duration.
 *
 * @return a fraction of the animation duration
 *
 * @see #setDelay(float)
 * @apiSince 1
 */

public float getDelay() { throw new RuntimeException("Stub!"); }

/**
 * Sets the delay, as a fraction of the animation duration, by which the
 * children's animations are offset. The general formula is:
 *
 * <pre>
 * child animation delay = child index * delay * animation duration
 * </pre>
 *
 * @param delay a fraction of the animation duration
 *
 * @see #getDelay()
 * @apiSince 1
 */

public void setDelay(float delay) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether two children's animations will overlap. Animations
 * overlap when the delay is lower than 100% (or 1.0).
 *
 * @return true if animations will overlap, false otherwise
 * @apiSince 1
 */

public boolean willOverlap() { throw new RuntimeException("Stub!"); }

/**
 * Starts the animation.
 * @apiSince 1
 */

public void start() { throw new RuntimeException("Stub!"); }

/**
 * Returns the animation to be applied to the specified view. The returned
 * animation is delayed by an offset computed according to the information
 * provided by
 * {@link android.view.animation.LayoutAnimationController.AnimationParameters}.
 * This method is called by view groups to obtain the animation to set on
 * a specific child.
 *
 * @param view the view to animate
 * @return an animation delayed by the number of milliseconds returned by
 *         {@link #getDelayForView(android.view.View)}
 *
 * @see #getDelay()
 * @see #setDelay(float)
 * @see #getDelayForView(android.view.View)
 * @apiSince 1
 */

public final android.view.animation.Animation getAnimationForView(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the layout animation is over or not. A layout animation
 * is considered done when the animation with the longest delay is done.
 *
 * @return true if all of the children's animations are over, false otherwise
 * @apiSince 1
 */

public boolean isDone() { throw new RuntimeException("Stub!"); }

/**
 * Returns the amount of milliseconds by which the specified view's
 * animation must be delayed or offset. Subclasses should override this
 * method to return a suitable value.
 *
 * This implementation returns <code>child animation delay</code>
 * milliseconds where:
 *
 * <pre>
 * child animation delay = child index * delay
 * </pre>
 *
 * The index is retrieved from the
 * {@link android.view.animation.LayoutAnimationController.AnimationParameters}
 * found in the view's {@link android.view.ViewGroup.LayoutParams}.
 *
 * @param view the view for which to obtain the animation's delay
 * @return a delay in milliseconds
 *
 * @see #getAnimationForView(android.view.View)
 * @see #getDelay()
 * @see #getTransformedIndex(android.view.animation.LayoutAnimationController.AnimationParameters)
 * @see android.view.ViewGroup.LayoutParams
 * @apiSince 1
 */

protected long getDelayForView(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Transforms the index stored in
 * {@link android.view.animation.LayoutAnimationController.AnimationParameters}
 * by the order returned by {@link #getOrder()}. Subclasses should override
 * this method to provide additional support for other types of ordering.
 * This method should be invoked by
 * {@link #getDelayForView(android.view.View)} prior to any computation.
 *
 * @param params the animation parameters containing the index
 * @return a transformed index
 * @apiSince 1
 */

protected int getTransformedIndex(android.view.animation.LayoutAnimationController.AnimationParameters params) { throw new RuntimeException("Stub!"); }

/**
 * Distributes the animation delays in the order in which view were added
 * to their view group.
 * @apiSince 1
 */

public static final int ORDER_NORMAL = 0; // 0x0

/**
 * Randomly distributes the animation delays.
 * @apiSince 1
 */

public static final int ORDER_RANDOM = 2; // 0x2

/**
 * Distributes the animation delays in the reverse order in which view were
 * added to their view group.
 * @apiSince 1
 */

public static final int ORDER_REVERSE = 1; // 0x1

/**
 * The animation applied on each child of the view group on which this
 * layout animation controller is set.
 * @apiSince 1
 */

protected android.view.animation.Animation mAnimation;

/**
 * The interpolator used to interpolate the delays.
 * @apiSince 1
 */

protected android.view.animation.Interpolator mInterpolator;

/**
 * The randomizer used when the order is set to random. Subclasses should
 * use this object to avoid creating their own.
 * @apiSince 1
 */

protected java.util.Random mRandomizer;
/**
 * The set of parameters that has to be attached to each view contained in
 * the view group animated by the layout animation controller. These
 * parameters are used to compute the start time of each individual view's
 * animation.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class AnimationParameters {

public AnimationParameters() { throw new RuntimeException("Stub!"); }

/**
 * The number of children in the view group containing the view to which
 * these parameters are attached.
 * @apiSince 1
 */

public int count;

/**
 * The index of the view to which these parameters are attached in its
 * containing view group.
 * @apiSince 1
 */

public int index;
}

}

