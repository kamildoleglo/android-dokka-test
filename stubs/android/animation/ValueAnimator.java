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

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.os.Looper;

/**
 * This class provides a simple timing engine for running animations
 * which calculate animated values and set them on target objects.
 *
 * <p>There is a single timing pulse that all animations use. It runs in a
 * custom handler to ensure that property changes happen on the UI thread.</p>
 *
 * <p>By default, ValueAnimator uses non-linear time interpolation, via the
 * {@link android.view.animation.AccelerateDecelerateInterpolator AccelerateDecelerateInterpolator} class, which accelerates into and decelerates
 * out of an animation. This behavior can be changed by calling
 * {@link android.animation.ValueAnimator#setInterpolator(android.animation.TimeInterpolator) ValueAnimator#setInterpolator(TimeInterpolator)}.</p>
 *
 * <p>Animators can be created from either code or resource files. Here is an example
 * of a ValueAnimator resource file:</p>
 *
 * {@sample development/samples/ApiDemos/res/anim/animator.xml ValueAnimatorResources}
 *
 * <p>Starting from API 23, it is also possible to use a combination of {@link android.animation.PropertyValuesHolder PropertyValuesHolder}
 * and {@link android.animation.Keyframe Keyframe} resource tags to create a multi-step animation.
 * Note that you can specify explicit fractional values (from 0 to 1) for
 * each keyframe to determine when, in the overall duration, the animation should arrive at that
 * value. Alternatively, you can leave the fractions off and the keyframes will be equally
 * distributed within the total duration:</p>
 *
 * {@sample development/samples/ApiDemos/res/anim/value_animator_pvh_kf.xml
 * ValueAnimatorKeyframeResources}
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about animating with {@code ValueAnimator}, read the
 * <a href="{@docRoot}guide/topics/graphics/prop-animation.html#value-animator">Property
 * Animation</a> developer guide.</p>
 * </div>
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ValueAnimator extends android.animation.Animator {

/**
 * Creates a new ValueAnimator object. This default constructor is primarily for
 * use internally; the factory methods which take parameters are more generally
 * useful.
 * @apiSince 11
 */

public ValueAnimator() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether animators are currently enabled, system-wide. By default, all
 * animators are enabled. This can change if either the user sets a Developer Option
 * to set the animator duration scale to 0 or by Battery Savery mode being enabled
 * (which disables all animations).
 *
 * <p>Developers should not typically need to call this method, but should an app wish
 * to show a different experience when animators are disabled, this return value
 * can be used as a decider of which experience to offer.
 *
 * @return boolean Whether animators are currently enabled. The default value is
 * <code>true</code>.
 * @apiSince 26
 */

public static boolean areAnimatorsEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns a ValueAnimator that animates between int values. A single
 * value implies that that value is the one being animated to. However, this is not typically
 * useful in a ValueAnimator object because there is no way for the object to determine the
 * starting value for the animation (unlike ObjectAnimator, which can derive that value
 * from the target object and property being animated). Therefore, there should typically
 * be two or more values.
 *
 * @param values A set of values that the animation will animate between over time.
 * @return A ValueAnimator object that is set up to animate between the given values.
 * @apiSince 11
 */

public static android.animation.ValueAnimator ofInt(int... values) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns a ValueAnimator that animates between color values. A single
 * value implies that that value is the one being animated to. However, this is not typically
 * useful in a ValueAnimator object because there is no way for the object to determine the
 * starting value for the animation (unlike ObjectAnimator, which can derive that value
 * from the target object and property being animated). Therefore, there should typically
 * be two or more values.
 *
 * @param values A set of values that the animation will animate between over time.
 * @return A ValueAnimator object that is set up to animate between the given values.
 * @apiSince 21
 */

public static android.animation.ValueAnimator ofArgb(int... values) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns a ValueAnimator that animates between float values. A single
 * value implies that that value is the one being animated to. However, this is not typically
 * useful in a ValueAnimator object because there is no way for the object to determine the
 * starting value for the animation (unlike ObjectAnimator, which can derive that value
 * from the target object and property being animated). Therefore, there should typically
 * be two or more values.
 *
 * @param values A set of values that the animation will animate between over time.
 * @return A ValueAnimator object that is set up to animate between the given values.
 * @apiSince 11
 */

public static android.animation.ValueAnimator ofFloat(float... values) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns a ValueAnimator that animates between the values
 * specified in the PropertyValuesHolder objects.
 *
 * @param values A set of PropertyValuesHolder objects whose values will be animated
 * between over time.
 * @return A ValueAnimator object that is set up to animate between the given values.
 * @apiSince 11
 */

public static android.animation.ValueAnimator ofPropertyValuesHolder(android.animation.PropertyValuesHolder... values) { throw new RuntimeException("Stub!"); }

/**
 * Constructs and returns a ValueAnimator that animates between Object values. A single
 * value implies that that value is the one being animated to. However, this is not typically
 * useful in a ValueAnimator object because there is no way for the object to determine the
 * starting value for the animation (unlike ObjectAnimator, which can derive that value
 * from the target object and property being animated). Therefore, there should typically
 * be two or more values.
 *
 * <p><strong>Note:</strong> The Object values are stored as references to the original
 * objects, which means that changes to those objects after this method is called will
 * affect the values on the animator. If the objects will be mutated externally after
 * this method is called, callers should pass a copy of those objects instead.
 *
 * <p>Since ValueAnimator does not know how to animate between arbitrary Objects, this
 * factory method also takes a TypeEvaluator object that the ValueAnimator will use
 * to perform that interpolation.
 *
 * @param evaluator A TypeEvaluator that will be called on each animation frame to
 * provide the ncessry interpolation between the Object values to derive the animated
 * value.
 * @param values A set of values that the animation will animate between over time.
 * @return A ValueAnimator object that is set up to animate between the given values.
 * @apiSince 11
 */

public static android.animation.ValueAnimator ofObject(android.animation.TypeEvaluator evaluator, java.lang.Object... values) { throw new RuntimeException("Stub!"); }

/**
 * Sets int values that will be animated between. A single
 * value implies that that value is the one being animated to. However, this is not typically
 * useful in a ValueAnimator object because there is no way for the object to determine the
 * starting value for the animation (unlike ObjectAnimator, which can derive that value
 * from the target object and property being animated). Therefore, there should typically
 * be two or more values.
 *
 * <p>If there are already multiple sets of values defined for this ValueAnimator via more
 * than one PropertyValuesHolder object, this method will set the values for the first
 * of those objects.</p>
 *
 * @param values A set of values that the animation will animate between over time.
 * @apiSince 11
 */

public void setIntValues(int... values) { throw new RuntimeException("Stub!"); }

/**
 * Sets float values that will be animated between. A single
 * value implies that that value is the one being animated to. However, this is not typically
 * useful in a ValueAnimator object because there is no way for the object to determine the
 * starting value for the animation (unlike ObjectAnimator, which can derive that value
 * from the target object and property being animated). Therefore, there should typically
 * be two or more values.
 *
 * <p>If there are already multiple sets of values defined for this ValueAnimator via more
 * than one PropertyValuesHolder object, this method will set the values for the first
 * of those objects.</p>
 *
 * @param values A set of values that the animation will animate between over time.
 * @apiSince 11
 */

public void setFloatValues(float... values) { throw new RuntimeException("Stub!"); }

/**
 * Sets the values to animate between for this animation. A single
 * value implies that that value is the one being animated to. However, this is not typically
 * useful in a ValueAnimator object because there is no way for the object to determine the
 * starting value for the animation (unlike ObjectAnimator, which can derive that value
 * from the target object and property being animated). Therefore, there should typically
 * be two or more values.
 *
 * <p><strong>Note:</strong> The Object values are stored as references to the original
 * objects, which means that changes to those objects after this method is called will
 * affect the values on the animator. If the objects will be mutated externally after
 * this method is called, callers should pass a copy of those objects instead.
 *
 * <p>If there are already multiple sets of values defined for this ValueAnimator via more
 * than one PropertyValuesHolder object, this method will set the values for the first
 * of those objects.</p>
 *
 * <p>There should be a TypeEvaluator set on the ValueAnimator that knows how to interpolate
 * between these value objects. ValueAnimator only knows how to interpolate between the
 * primitive types specified in the other setValues() methods.</p>
 *
 * @param values The set of values to animate between.
 * @apiSince 11
 */

public void setObjectValues(java.lang.Object... values) { throw new RuntimeException("Stub!"); }

/**
 * Sets the values, per property, being animated between. This function is called internally
 * by the constructors of ValueAnimator that take a list of values. But a ValueAnimator can
 * be constructed without values and this method can be called to set the values manually
 * instead.
 *
 * @param values The set of values, per property, being animated between.
 * @apiSince 11
 */

public void setValues(android.animation.PropertyValuesHolder... values) { throw new RuntimeException("Stub!"); }

/**
 * Returns the values that this ValueAnimator animates between. These values are stored in
 * PropertyValuesHolder objects, even if the ValueAnimator was created with a simple list
 * of value objects instead.
 *
 * @return PropertyValuesHolder[] An array of PropertyValuesHolder objects which hold the
 * values, per property, that define the animation.
 * @apiSince 11
 */

public android.animation.PropertyValuesHolder[] getValues() { throw new RuntimeException("Stub!"); }

/**
 * Sets the length of the animation. The default duration is 300 milliseconds.
 *
 * @param duration The length of the animation, in milliseconds. This value cannot
 * be negative.
 * @return ValueAnimator The object called with setDuration(). This return
 * value makes it easier to compose statements together that construct and then set the
 * duration, as in <code>ValueAnimator.ofInt(0, 10).setDuration(500).start()</code>.
 * @apiSince 11
 */

public android.animation.ValueAnimator setDuration(long duration) { throw new RuntimeException("Stub!"); }

/**
 * Gets the length of the animation. The default duration is 300 milliseconds.
 *
 * @return The length of the animation, in milliseconds.
 * @apiSince 11
 */

public long getDuration() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public long getTotalDuration() { throw new RuntimeException("Stub!"); }

/**
 * Sets the position of the animation to the specified point in time. This time should
 * be between 0 and the total duration of the animation, including any repetition. If
 * the animation has not yet been started, then it will not advance forward after it is
 * set to this time; it will simply set the time to this value and perform any appropriate
 * actions based on that time. If the animation is already running, then setCurrentPlayTime()
 * will set the current playing time to this value and continue playing from that point.
 *
 * @param playTime The time, in milliseconds, to which the animation is advanced or rewound.
 * @apiSince 11
 */

public void setCurrentPlayTime(long playTime) { throw new RuntimeException("Stub!"); }

/**
 * Sets the position of the animation to the specified fraction. This fraction should
 * be between 0 and the total fraction of the animation, including any repetition. That is,
 * a fraction of 0 will position the animation at the beginning, a value of 1 at the end,
 * and a value of 2 at the end of a reversing animator that repeats once. If
 * the animation has not yet been started, then it will not advance forward after it is
 * set to this fraction; it will simply set the fraction to this value and perform any
 * appropriate actions based on that fraction. If the animation is already running, then
 * setCurrentFraction() will set the current fraction to this value and continue
 * playing from that point. {@link android.animation.Animator.AnimatorListener Animator.AnimatorListener} events are not called
 * due to changing the fraction; those events are only processed while the animation
 * is running.
 *
 * @param fraction The fraction to which the animation is advanced or rewound. Values
 * outside the range of 0 to the maximum fraction for the animator will be clamped to
 * the correct range.
 * @apiSince 22
 */

public void setCurrentFraction(float fraction) { throw new RuntimeException("Stub!"); }

/**
 * Gets the current position of the animation in time, which is equal to the current
 * time minus the time that the animation started. An animation that is not yet started will
 * return a value of zero, unless the animation has has its play time set via
 * {@link #setCurrentPlayTime(long)} or {@link #setCurrentFraction(float)}, in which case
 * it will return the time that was set.
 *
 * @return The current position in time of the animation.
 * @apiSince 11
 */

public long getCurrentPlayTime() { throw new RuntimeException("Stub!"); }

/**
 * The amount of time, in milliseconds, to delay starting the animation after
 * {@link #start()} is called.
 *
 * @return the number of milliseconds to delay running the animation
 * @apiSince 11
 */

public long getStartDelay() { throw new RuntimeException("Stub!"); }

/**
 * The amount of time, in milliseconds, to delay starting the animation after
 * {@link #start()} is called. Note that the start delay should always be non-negative. Any
 * negative start delay will be clamped to 0 on N and above.
 *
 * @param startDelay The amount of the delay, in milliseconds
 * @apiSince 11
 */

public void setStartDelay(long startDelay) { throw new RuntimeException("Stub!"); }

/**
 * The amount of time, in milliseconds, between each frame of the animation. This is a
 * requested time that the animation will attempt to honor, but the actual delay between
 * frames may be different, depending on system load and capabilities. This is a static
 * function because the same delay will be applied to all animations, since they are all
 * run off of a single timing loop.
 *
 * The frame delay may be ignored when the animation system uses an external timing
 * source, such as the display refresh rate (vsync), to govern animations.
 *
 * Note that this method should be called from the same thread that {@link #start()} is
 * called in order to check the frame delay for that animation. A runtime exception will be
 * thrown if the calling thread does not have a Looper.
 *
 * @return the requested time between frames, in milliseconds
 * @apiSince 11
 */

public static long getFrameDelay() { throw new RuntimeException("Stub!"); }

/**
 * The amount of time, in milliseconds, between each frame of the animation. This is a
 * requested time that the animation will attempt to honor, but the actual delay between
 * frames may be different, depending on system load and capabilities. This is a static
 * function because the same delay will be applied to all animations, since they are all
 * run off of a single timing loop.
 *
 * The frame delay may be ignored when the animation system uses an external timing
 * source, such as the display refresh rate (vsync), to govern animations.
 *
 * Note that this method should be called from the same thread that {@link #start()} is
 * called in order to have the new frame delay take effect on that animation. A runtime
 * exception will be thrown if the calling thread does not have a Looper.
 *
 * @param frameDelay the requested time between frames, in milliseconds
 * @apiSince 11
 */

public static void setFrameDelay(long frameDelay) { throw new RuntimeException("Stub!"); }

/**
 * The most recent value calculated by this <code>ValueAnimator</code> when there is just one
 * property being animated. This value is only sensible while the animation is running. The main
 * purpose for this read-only property is to retrieve the value from the <code>ValueAnimator</code>
 * during a call to {@link android.animation.ValueAnimator.AnimatorUpdateListener#onAnimationUpdate(android.animation.ValueAnimator) AnimatorUpdateListener#onAnimationUpdate(ValueAnimator)}, which
 * is called during each animation frame, immediately after the value is calculated.
 *
 * @return animatedValue The value most recently calculated by this <code>ValueAnimator</code> for
 * the single property being animated. If there are several properties being animated
 * (specified by several PropertyValuesHolder objects in the constructor), this function
 * returns the animated value for the first of those objects.
 * @apiSince 11
 */

public java.lang.Object getAnimatedValue() { throw new RuntimeException("Stub!"); }

/**
 * The most recent value calculated by this <code>ValueAnimator</code> for <code>propertyName</code>.
 * The main purpose for this read-only property is to retrieve the value from the
 * <code>ValueAnimator</code> during a call to
 * {@link android.animation.ValueAnimator.AnimatorUpdateListener#onAnimationUpdate(android.animation.ValueAnimator) AnimatorUpdateListener#onAnimationUpdate(ValueAnimator)}, which
 * is called during each animation frame, immediately after the value is calculated.
 *
 * @return animatedValue The value most recently calculated for the named property
 * by this <code>ValueAnimator</code>.
 * @apiSince 11
 */

public java.lang.Object getAnimatedValue(java.lang.String propertyName) { throw new RuntimeException("Stub!"); }

/**
 * Sets how many times the animation should be repeated. If the repeat
 * count is 0, the animation is never repeated. If the repeat count is
 * greater than 0 or {@link #INFINITE}, the repeat mode will be taken
 * into account. The repeat count is 0 by default.
 *
 * @param value the number of times the animation should be repeated
 * @apiSince 11
 */

public void setRepeatCount(int value) { throw new RuntimeException("Stub!"); }

/**
 * Defines how many times the animation should repeat. The default value
 * is 0.
 *
 * @return the number of times the animation should repeat, or {@link #INFINITE}
 * @apiSince 11
 */

public int getRepeatCount() { throw new RuntimeException("Stub!"); }

/**
 * Defines what this animation should do when it reaches the end. This
 * setting is applied only when the repeat count is either greater than
 * 0 or {@link #INFINITE}. Defaults to {@link #RESTART}.
 *
 * @param value {@link #RESTART} or {@link #REVERSE}
 
 * Value is {@link android.animation.ValueAnimator#RESTART}, or {@link android.animation.ValueAnimator#REVERSE}
 * @apiSince 11
 */

public void setRepeatMode(int value) { throw new RuntimeException("Stub!"); }

/**
 * Defines what this animation should do when it reaches the end.
 *
 * @return either one of {@link #REVERSE} or {@link #RESTART}
 
 * Value is {@link android.animation.ValueAnimator#RESTART}, or {@link android.animation.ValueAnimator#REVERSE}
 * @apiSince 11
 */

public int getRepeatMode() { throw new RuntimeException("Stub!"); }

/**
 * Adds a listener to the set of listeners that are sent update events through the life of
 * an animation. This method is called on all listeners for every frame of the animation,
 * after the values for the animation have been calculated.
 *
 * @param listener the listener to be added to the current set of listeners for this animation.
 * @apiSince 11
 */

public void addUpdateListener(android.animation.ValueAnimator.AnimatorUpdateListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Removes all listeners from the set listening to frame updates for this animation.
 * @apiSince 11
 */

public void removeAllUpdateListeners() { throw new RuntimeException("Stub!"); }

/**
 * Removes a listener from the set listening to frame updates for this animation.
 *
 * @param listener the listener to be removed from the current set of update listeners
 * for this animation.
 * @apiSince 11
 */

public void removeUpdateListener(android.animation.ValueAnimator.AnimatorUpdateListener listener) { throw new RuntimeException("Stub!"); }

/**
 * The time interpolator used in calculating the elapsed fraction of this animation. The
 * interpolator determines whether the animation runs with linear or non-linear motion,
 * such as acceleration and deceleration. The default value is
 * {@link android.view.animation.AccelerateDecelerateInterpolator}
 *
 * @param value the interpolator to be used by this animation. A value of <code>null</code>
 * will result in linear interpolation.
 * @apiSince 11
 */

public void setInterpolator(android.animation.TimeInterpolator value) { throw new RuntimeException("Stub!"); }

/**
 * Returns the timing interpolator that this ValueAnimator uses.
 *
 * @return The timing interpolator for this ValueAnimator.
 * @apiSince 11
 */

public android.animation.TimeInterpolator getInterpolator() { throw new RuntimeException("Stub!"); }

/**
 * The type evaluator to be used when calculating the animated values of this animation.
 * The system will automatically assign a float or int evaluator based on the type
 * of <code>startValue</code> and <code>endValue</code> in the constructor. But if these values
 * are not one of these primitive types, or if different evaluation is desired (such as is
 * necessary with int values that represent colors), a custom evaluator needs to be assigned.
 * For example, when running an animation on color values, the {@link android.animation.ArgbEvaluator ArgbEvaluator}
 * should be used to get correct RGB color interpolation.
 *
 * <p>If this ValueAnimator has only one set of values being animated between, this evaluator
 * will be used for that set. If there are several sets of values being animated, which is
 * the case if PropertyValuesHolder objects were set on the ValueAnimator, then the evaluator
 * is assigned just to the first PropertyValuesHolder object.</p>
 *
 * @param value the evaluator to be used this animation
 * @apiSince 11
 */

public void setEvaluator(android.animation.TypeEvaluator value) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public void start() { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public void cancel() { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public void end() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public void resume() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public void pause() { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public boolean isRunning() { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public boolean isStarted() { throw new RuntimeException("Stub!"); }

/**
 * Plays the ValueAnimator in reverse. If the animation is already running,
 * it will stop itself and play backwards from the point reached when reverse was called.
 * If the animation is not currently running, then it will start from the end and
 * play backwards. This behavior is only set for the current animation; future playing
 * of the animation will use the default behavior of playing forward.
 * @apiSince 11
 */

public void reverse() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current animation fraction, which is the elapsed/interpolated fraction used in
 * the most recent frame update on the animation.
 *
 * @return Elapsed/interpolated fraction of the animation.
 * @apiSince 12
 */

public float getAnimatedFraction() { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public android.animation.ValueAnimator clone() { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * This value used used with the {@link #setRepeatCount(int)} property to repeat
 * the animation indefinitely.
 * @apiSince 11
 */

public static final int INFINITE = -1; // 0xffffffff

/**
 * When the animation reaches the end and <code>repeatCount</code> is INFINITE
 * or a positive value, the animation restarts from the beginning.
 * @apiSince 11
 */

public static final int RESTART = 1; // 0x1

/**
 * When the animation reaches the end and <code>repeatCount</code> is INFINITE
 * or a positive value, the animation reverses direction on every iteration.
 * @apiSince 11
 */

public static final int REVERSE = 2; // 0x2
/**
 * Implementors of this interface can add themselves as update listeners
 * to an <code>ValueAnimator</code> instance to receive callbacks on every animation
 * frame, after the current frame's values have been calculated for that
 * <code>ValueAnimator</code>.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface AnimatorUpdateListener {

/**
 * <p>Notifies the occurrence of another frame of the animation.</p>
 *
 * @param animation The animation which was repeated.
 * @apiSince 11
 */

public void onAnimationUpdate(android.animation.ValueAnimator animation);
}

}

