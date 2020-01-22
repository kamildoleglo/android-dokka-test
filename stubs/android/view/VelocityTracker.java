/*
 * Copyright (C) 2006 The Android Open Source Project
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


package android.view;


/**
 * Helper for tracking the velocity of touch events, for implementing
 * flinging and other such gestures.
 *
 * Use {@link #obtain} to retrieve a new instance of the class when you are going
 * to begin tracking.  Put the motion events you receive into it with
 * {@link #addMovement(android.view.MotionEvent)}.  When you want to determine the velocity call
 * {@link #computeCurrentVelocity(int)} and then call {@link #getXVelocity(int)}
 * and {@link #getYVelocity(int)} to retrieve the velocity for each pointer id.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class VelocityTracker {

private VelocityTracker() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a new VelocityTracker object to watch the velocity of a
 * motion.  Be sure to call {@link #recycle} when done.  You should
 * generally only maintain an active object while tracking a movement,
 * so that the VelocityTracker can be re-used elsewhere.
 *
 * @return Returns a new VelocityTracker.
 * @apiSince 1
 */

public static android.view.VelocityTracker obtain() { throw new RuntimeException("Stub!"); }

/**
 * Return a VelocityTracker object back to be re-used by others.  You must
 * not touch the object after calling this function.
 * @apiSince 1
 */

public void recycle() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Reset the velocity tracker back to its initial state.
 * @apiSince 1
 */

public void clear() { throw new RuntimeException("Stub!"); }

/**
 * Add a user's movement to the tracker.  You should call this for the
 * initial {@link android.view.MotionEvent#ACTION_DOWN MotionEvent#ACTION_DOWN}, the following
 * {@link android.view.MotionEvent#ACTION_MOVE MotionEvent#ACTION_MOVE} events that you receive, and the
 * final {@link android.view.MotionEvent#ACTION_UP MotionEvent#ACTION_UP}.  You can, however, call this
 * for whichever events you desire.
 *
 * @param event The MotionEvent you received and would like to track.
 * @apiSince 1
 */

public void addMovement(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to invoking {@link #computeCurrentVelocity(int,float)} with a maximum
 * velocity of Float.MAX_VALUE.
 *
 * @see #computeCurrentVelocity(int, float)
 * @apiSince 1
 */

public void computeCurrentVelocity(int units) { throw new RuntimeException("Stub!"); }

/**
 * Compute the current velocity based on the points that have been
 * collected.  Only call this when you actually want to retrieve velocity
 * information, as it is relatively expensive.  You can then retrieve
 * the velocity with {@link #getXVelocity()} and
 * {@link #getYVelocity()}.
 *
 * @param units The units you would like the velocity in.  A value of 1
 * provides pixels per millisecond, 1000 provides pixels per second, etc.
 * @param maxVelocity The maximum velocity that can be computed by this method.
 * This value must be declared in the same unit as the units parameter. This value
 * must be positive.
 * @apiSince 4
 */

public void computeCurrentVelocity(int units, float maxVelocity) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the last computed X velocity.  You must first call
 * {@link #computeCurrentVelocity(int)} before calling this function.
 *
 * @return The previously computed X velocity.
 * @apiSince 1
 */

public float getXVelocity() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the last computed Y velocity.  You must first call
 * {@link #computeCurrentVelocity(int)} before calling this function.
 *
 * @return The previously computed Y velocity.
 * @apiSince 1
 */

public float getYVelocity() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the last computed X velocity.  You must first call
 * {@link #computeCurrentVelocity(int)} before calling this function.
 *
 * @param id Which pointer's velocity to return.
 * @return The previously computed X velocity.
 * @apiSince 8
 */

public float getXVelocity(int id) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the last computed Y velocity.  You must first call
 * {@link #computeCurrentVelocity(int)} before calling this function.
 *
 * @param id Which pointer's velocity to return.
 * @return The previously computed Y velocity.
 * @apiSince 8
 */

public float getYVelocity(int id) { throw new RuntimeException("Stub!"); }
}

