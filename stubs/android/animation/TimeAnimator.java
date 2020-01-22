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


/**
 * This class provides a simple callback mechanism to listeners that is synchronized with all
 * other animators in the system. There is no duration, interpolation, or object value-setting
 * with this Animator. Instead, it is simply started, after which it proceeds to send out events
 * on every animation frame to its TimeListener (if set), with information about this animator,
 * the total elapsed time, and the elapsed time since the previous animation frame.
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TimeAnimator extends android.animation.ValueAnimator {

public TimeAnimator() { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public void start() { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public void setCurrentPlayTime(long playTime) { throw new RuntimeException("Stub!"); }

/**
 * Sets a listener that is sent update events throughout the life of
 * an animation.
 *
 * @param listener the listener to be set.
 * @apiSince 16
 */

public void setTimeListener(android.animation.TimeAnimator.TimeListener listener) { throw new RuntimeException("Stub!"); }
/**
 * Implementors of this interface can set themselves as update listeners
 * to a <code>TimeAnimator</code> instance to receive callbacks on every animation
 * frame to receive the total time since the animator started and the delta time
 * since the last frame. The first time the listener is called,
 * deltaTime will be zero. The same is true for totalTime, unless the animator was
 * set to a specific {@link android.animation.ValueAnimator#setCurrentPlayTime(long) ValueAnimator#setCurrentPlayTime(long)}
 * prior to starting.
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface TimeListener {

/**
 * <p>Notifies listeners of the occurrence of another frame of the animation,
 * along with information about the elapsed time.</p>
 *
 * @param animation The animator sending out the notification.
 * @param totalTime The total time elapsed since the animator started, in milliseconds.
 * @param deltaTime The time elapsed since the previous frame, in milliseconds.
 * @apiSince 16
 */

public void onTimeUpdate(android.animation.TimeAnimator animation, long totalTime, long deltaTime);
}

}

