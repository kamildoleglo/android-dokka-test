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

import java.util.ArrayList;

/**
 * This is the superclass for classes which provide basic support for animations which can be
 * started, ended, and have <code>AnimatorListeners</code> added to them.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class Animator implements java.lang.Cloneable {

public Animator() { throw new RuntimeException("Stub!"); }

/**
 * Starts this animation. If the animation has a nonzero startDelay, the animation will start
 * running after that delay elapses. A non-delayed animation will have its initial
 * value(s) set immediately, followed by calls to
 * {@link android.animation.Animator.AnimatorListener#onAnimationStart(android.animation.Animator) AnimatorListener#onAnimationStart(Animator)} for any listeners of this animator.
 *
 * <p>The animation started by calling this method will be run on the thread that called
 * this method. This thread should have a Looper on it (a runtime exception will be thrown if
 * this is not the case). Also, if the animation will animate
 * properties of objects in the view hierarchy, then the calling thread should be the UI
 * thread for that view hierarchy.</p>
 *
 * @apiSince 11
 */

public void start() { throw new RuntimeException("Stub!"); }

/**
 * Cancels the animation. Unlike {@link #end()}, <code>cancel()</code> causes the animation to
 * stop in its tracks, sending an
 * {@link android.animation.Animator.AnimatorListener#onAnimationCancel(Animator)} to
 * its listeners, followed by an
 * {@link android.animation.Animator.AnimatorListener#onAnimationEnd(Animator)} message.
 *
 * <p>This method must be called on the thread that is running the animation.</p>
 * @apiSince 11
 */

public void cancel() { throw new RuntimeException("Stub!"); }

/**
 * Ends the animation. This causes the animation to assign the end value of the property being
 * animated, then calling the
 * {@link android.animation.Animator.AnimatorListener#onAnimationEnd(Animator)} method on
 * its listeners.
 *
 * <p>This method must be called on the thread that is running the animation.</p>
 * @apiSince 11
 */

public void end() { throw new RuntimeException("Stub!"); }

/**
 * Pauses a running animation. This method should only be called on the same thread on
 * which the animation was started. If the animation has not yet been {@link
 * #isStarted() started} or has since ended, then the call is ignored. Paused
 * animations can be resumed by calling {@link #resume()}.
 *
 * @see #resume()
 * @see #isPaused()
 * @see android.animation.Animator.AnimatorPauseListener
 * @apiSince 19
 */

public void pause() { throw new RuntimeException("Stub!"); }

/**
 * Resumes a paused animation, causing the animator to pick up where it left off
 * when it was paused. This method should only be called on the same thread on
 * which the animation was started. Calls to resume() on an animator that is
 * not currently paused will be ignored.
 *
 * @see #pause()
 * @see #isPaused()
 * @see android.animation.Animator.AnimatorPauseListener
 * @apiSince 19
 */

public void resume() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether this animator is currently in a paused state.
 *
 * @return True if the animator is currently paused, false otherwise.
 *
 * @see #pause()
 * @see #resume()
 * @apiSince 19
 */

public boolean isPaused() { throw new RuntimeException("Stub!"); }

/**
 * The amount of time, in milliseconds, to delay processing the animation
 * after {@link #start()} is called.
 *
 * @return the number of milliseconds to delay running the animation
 * @apiSince 11
 */

public abstract long getStartDelay();

/**
 * The amount of time, in milliseconds, to delay processing the animation
 * after {@link #start()} is called.
 
 * @param startDelay The amount of the delay, in milliseconds
 * @apiSince 11
 */

public abstract void setStartDelay(long startDelay);

/**
 * Sets the duration of the animation.
 *
 * @param duration The length of the animation, in milliseconds.
 * @apiSince 11
 */

public abstract android.animation.Animator setDuration(long duration);

/**
 * Gets the duration of the animation.
 *
 * @return The length of the animation, in milliseconds.
 * @apiSince 11
 */

public abstract long getDuration();

/**
 * Gets the total duration of the animation, accounting for animation sequences, start delay,
 * and repeating. Return {@link #DURATION_INFINITE} if the duration is infinite.
 *
 * @return  Total time an animation takes to finish, starting from the time {@link #start()}
 *          is called. {@link #DURATION_INFINITE} will be returned if the animation or any
 *          child animation repeats infinite times.
 * @apiSince 24
 */

public long getTotalDuration() { throw new RuntimeException("Stub!"); }

/**
 * The time interpolator used in calculating the elapsed fraction of the
 * animation. The interpolator determines whether the animation runs with
 * linear or non-linear motion, such as acceleration and deceleration. The
 * default value is {@link android.view.animation.AccelerateDecelerateInterpolator}.
 *
 * @param value the interpolator to be used by this animation
 * @apiSince 11
 */

public abstract void setInterpolator(android.animation.TimeInterpolator value);

/**
 * Returns the timing interpolator that this animation uses.
 *
 * @return The timing interpolator for this animation.
 * @apiSince 18
 */

public android.animation.TimeInterpolator getInterpolator() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether this Animator is currently running (having been started and gone past any
 * initial startDelay period and not yet ended).
 *
 * @return Whether the Animator is running.
 * @apiSince 11
 */

public abstract boolean isRunning();

/**
 * Returns whether this Animator has been started and not yet ended. For reusable
 * Animators (which most Animators are, apart from the one-shot animator produced by
 * {@link android.view.ViewAnimationUtils#createCircularReveal(
 * android.view.View, int, int, float, float) createCircularReveal()}),
 * this state is a superset of {@link #isRunning()}, because an Animator with a
 * nonzero {@link #getStartDelay() startDelay} will return true for {@link #isStarted()} during
 * the delay phase, whereas {@link #isRunning()} will return true only after the delay phase
 * is complete. Non-reusable animators will always return true after they have been
 * started, because they cannot return to a non-started state.
 *
 * @return Whether the Animator has been started and not yet ended.
 * @apiSince 14
 */

public boolean isStarted() { throw new RuntimeException("Stub!"); }

/**
 * Adds a listener to the set of listeners that are sent events through the life of an
 * animation, such as start, repeat, and end.
 *
 * @param listener the listener to be added to the current set of listeners for this animation.
 * @apiSince 11
 */

public void addListener(android.animation.Animator.AnimatorListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Removes a listener from the set listening to this animation.
 *
 * @param listener the listener to be removed from the current set of listeners for this
 *                 animation.
 * @apiSince 11
 */

public void removeListener(android.animation.Animator.AnimatorListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Gets the set of {@link android.animation.Animator.AnimatorListener} objects that are currently
 * listening for events on this <code>Animator</code> object.
 *
 * @return ArrayList<AnimatorListener> The set of listeners.
 * @apiSince 11
 */

public java.util.ArrayList<android.animation.Animator.AnimatorListener> getListeners() { throw new RuntimeException("Stub!"); }

/**
 * Adds a pause listener to this animator.
 *
 * @param listener the listener to be added to the current set of pause listeners
 * for this animation.
 * @apiSince 19
 */

public void addPauseListener(android.animation.Animator.AnimatorPauseListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Removes a pause listener from the set listening to this animation.
 *
 * @param listener the listener to be removed from the current set of pause
 * listeners for this animation.
 * @apiSince 19
 */

public void removePauseListener(android.animation.Animator.AnimatorPauseListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Removes all {@link #addListener(android.animation.Animator.AnimatorListener) listeners}
 * and {@link #addPauseListener(android.animation.Animator.AnimatorPauseListener)
 * pauseListeners} from this object.
 * @apiSince 11
 */

public void removeAllListeners() { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public android.animation.Animator clone() { throw new RuntimeException("Stub!"); }

/**
 * This method tells the object to use appropriate information to extract
 * starting values for the animation. For example, a AnimatorSet object will pass
 * this call to its child objects to tell them to set up the values. A
 * ObjectAnimator object will use the information it has about its target object
 * and PropertyValuesHolder objects to get the start values for its properties.
 * A ValueAnimator object will ignore the request since it does not have enough
 * information (such as a target object) to gather these values.
 * @apiSince 11
 */

public void setupStartValues() { throw new RuntimeException("Stub!"); }

/**
 * This method tells the object to use appropriate information to extract
 * ending values for the animation. For example, a AnimatorSet object will pass
 * this call to its child objects to tell them to set up the values. A
 * ObjectAnimator object will use the information it has about its target object
 * and PropertyValuesHolder objects to get the start values for its properties.
 * A ValueAnimator object will ignore the request since it does not have enough
 * information (such as a target object) to gather these values.
 * @apiSince 11
 */

public void setupEndValues() { throw new RuntimeException("Stub!"); }

/**
 * Sets the target object whose property will be animated by this animation. Not all subclasses
 * operate on target objects (for example, {@link android.animation.ValueAnimator ValueAnimator}, but this method
 * is on the superclass for the convenience of dealing generically with those subclasses
 * that do handle targets.
 * <p>
 * <strong>Note:</strong> The target is stored as a weak reference internally to avoid leaking
 * resources by having animators directly reference old targets. Therefore, you should
 * ensure that animator targets always have a hard reference elsewhere.
 *
 * @param target The object being animated
 
 * This value may be {@code null}.
 * @apiSince 11
 */

public void setTarget(@androidx.annotation.Nullable java.lang.Object target) { throw new RuntimeException("Stub!"); }

/**
 * The value used to indicate infinite duration (e.g.&nbsp;when Animators repeat infinitely).
 * @apiSince 24
 */

public static final long DURATION_INFINITE = -1L; // 0xffffffffffffffffL
/**
 * <p>An animation listener receives notifications from an animation.
 * Notifications indicate animation related events, such as the end or the
 * repetition of the animation.</p>
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface AnimatorListener {

/**
 * <p>Notifies the start of the animation as well as the animation's overall play direction.
 * This method's default behavior is to call {@link #onAnimationStart(android.animation.Animator)}. This
 * method can be overridden, though not required, to get the additional play direction info
 * when an animation starts. Skipping calling super when overriding this method results in
 * {@link #onAnimationStart(android.animation.Animator)} not getting called.
 *
 * @param animation The started animation.
 * @param isReverse Whether the animation is playing in reverse.
 * @apiSince 26
 */

public default void onAnimationStart(android.animation.Animator animation, boolean isReverse) { throw new RuntimeException("Stub!"); }

/**
 * <p>Notifies the end of the animation. This callback is not invoked
 * for animations with repeat count set to INFINITE.</p>
 *
 * <p>This method's default behavior is to call {@link #onAnimationEnd(android.animation.Animator)}. This
 * method can be overridden, though not required, to get the additional play direction info
 * when an animation ends. Skipping calling super when overriding this method results in
 * {@link #onAnimationEnd(android.animation.Animator)} not getting called.
 *
 * @param animation The animation which reached its end.
 * @param isReverse Whether the animation is playing in reverse.
 * @apiSince 26
 */

public default void onAnimationEnd(android.animation.Animator animation, boolean isReverse) { throw new RuntimeException("Stub!"); }

/**
 * <p>Notifies the start of the animation.</p>
 *
 * @param animation The started animation.
 * @apiSince 11
 */

public void onAnimationStart(android.animation.Animator animation);

/**
 * <p>Notifies the end of the animation. This callback is not invoked
 * for animations with repeat count set to INFINITE.</p>
 *
 * @param animation The animation which reached its end.
 * @apiSince 11
 */

public void onAnimationEnd(android.animation.Animator animation);

/**
 * <p>Notifies the cancellation of the animation. This callback is not invoked
 * for animations with repeat count set to INFINITE.</p>
 *
 * @param animation The animation which was canceled.
 * @apiSince 11
 */

public void onAnimationCancel(android.animation.Animator animation);

/**
 * <p>Notifies the repetition of the animation.</p>
 *
 * @param animation The animation which was repeated.
 * @apiSince 11
 */

public void onAnimationRepeat(android.animation.Animator animation);
}

/**
 * A pause listener receives notifications from an animation when the
 * animation is {@link #pause() paused} or {@link #resume() resumed}.
 *
 * @see #addPauseListener(AnimatorPauseListener)
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface AnimatorPauseListener {

/**
 * <p>Notifies that the animation was paused.</p>
 *
 * @param animation The animaton being paused.
 * @see #pause()
 * @apiSince 19
 */

public void onAnimationPause(android.animation.Animator animation);

/**
 * <p>Notifies that the animation was resumed, after being
 * previously paused.</p>
 *
 * @param animation The animation being resumed.
 * @see #resume()
 * @apiSince 19
 */

public void onAnimationResume(android.animation.Animator animation);
}

}

