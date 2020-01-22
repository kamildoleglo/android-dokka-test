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


package android.widget;

import android.view.ViewConfiguration;

/**
 * <p>This class encapsulates scrolling. You can use scrollers ({@link android.widget.Scroller Scroller}
 * or {@link android.widget.OverScroller OverScroller}) to collect the data you need to produce a scrolling
 * animation&mdash;for example, in response to a fling gesture. Scrollers track
 * scroll offsets for you over time, but they don't automatically apply those
 * positions to your view. It's your responsibility to get and apply new
 * coordinates at a rate that will make the scrolling animation look smooth.</p>
 *
 * <p>Here is a simple example:</p>
 *
 * <pre> private Scroller mScroller = new Scroller(context);
 * ...
 * public void zoomIn() {
 *     // Revert any animation currently in progress
 *     mScroller.forceFinished(true);
 *     // Start scrolling by providing a starting point and
 *     // the distance to travel
 *     mScroller.startScroll(0, 0, 100, 0);
 *     // Invalidate to request a redraw
 *     invalidate();
 * }</pre>
 *
 * <p>To track the changing positions of the x/y coordinates, use
 * {@link #computeScrollOffset}. The method returns a boolean to indicate
 * whether the scroller is finished. If it isn't, it means that a fling or
 * programmatic pan operation is still in progress. You can use this method to
 * find the current offsets of the x and y coordinates, for example:</p>
 *
 * <pre>if (mScroller.computeScrollOffset()) {
 *     // Get current x and y positions
 *     int currX = mScroller.getCurrX();
 *     int currY = mScroller.getCurrY();
 *    ...
 * }</pre>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Scroller {

/**
 * Create a Scroller with the default duration and interpolator.
 * @apiSince 1
 */

public Scroller(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Create a Scroller with the specified interpolator. If the interpolator is
 * null, the default (viscous) interpolator will be used. "Flywheel" behavior will
 * be in effect for apps targeting Honeycomb or newer.
 * @apiSince 1
 */

public Scroller(android.content.Context context, android.view.animation.Interpolator interpolator) { throw new RuntimeException("Stub!"); }

/**
 * Create a Scroller with the specified interpolator. If the interpolator is
 * null, the default (viscous) interpolator will be used. Specify whether or
 * not to support progressive "flywheel" behavior in flinging.
 * @apiSince 11
 */

public Scroller(android.content.Context context, android.view.animation.Interpolator interpolator, boolean flywheel) { throw new RuntimeException("Stub!"); }

/**
 * The amount of friction applied to flings. The default value
 * is {@link android.view.ViewConfiguration#getScrollFriction ViewConfiguration#getScrollFriction}.
 *
 * @param friction A scalar dimension-less value representing the coefficient of
 *         friction.
 * @apiSince 11
 */

public final void setFriction(float friction) { throw new RuntimeException("Stub!"); }

/**
 *
 * Returns whether the scroller has finished scrolling.
 *
 * @return True if the scroller has finished scrolling, false otherwise.
 * @apiSince 1
 */

public final boolean isFinished() { throw new RuntimeException("Stub!"); }

/**
 * Force the finished field to a particular value.
 *
 * @param finished The new finished value.
 * @apiSince 1
 */

public final void forceFinished(boolean finished) { throw new RuntimeException("Stub!"); }

/**
 * Returns how long the scroll event will take, in milliseconds.
 *
 * @return The duration of the scroll in milliseconds.
 * @apiSince 1
 */

public final int getDuration() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current X offset in the scroll.
 *
 * @return The new X offset as an absolute distance from the origin.
 * @apiSince 1
 */

public final int getCurrX() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current Y offset in the scroll.
 *
 * @return The new Y offset as an absolute distance from the origin.
 * @apiSince 1
 */

public final int getCurrY() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current velocity.
 *
 * @return The original velocity less the deceleration. Result may be
 * negative.
 * @apiSince 14
 */

public float getCurrVelocity() { throw new RuntimeException("Stub!"); }

/**
 * Returns the start X offset in the scroll.
 *
 * @return The start X offset as an absolute distance from the origin.
 * @apiSince 3
 */

public final int getStartX() { throw new RuntimeException("Stub!"); }

/**
 * Returns the start Y offset in the scroll.
 *
 * @return The start Y offset as an absolute distance from the origin.
 * @apiSince 3
 */

public final int getStartY() { throw new RuntimeException("Stub!"); }

/**
 * Returns where the scroll will end. Valid only for "fling" scrolls.
 *
 * @return The final X offset as an absolute distance from the origin.
 * @apiSince 1
 */

public final int getFinalX() { throw new RuntimeException("Stub!"); }

/**
 * Returns where the scroll will end. Valid only for "fling" scrolls.
 *
 * @return The final Y offset as an absolute distance from the origin.
 * @apiSince 1
 */

public final int getFinalY() { throw new RuntimeException("Stub!"); }

/**
 * Call this when you want to know the new location.  If it returns true,
 * the animation is not yet finished.
 * @apiSince 1
 */

public boolean computeScrollOffset() { throw new RuntimeException("Stub!"); }

/**
 * Start scrolling by providing a starting point and the distance to travel.
 * The scroll will use the default value of 250 milliseconds for the
 * duration.
 *
 * @param startX Starting horizontal scroll offset in pixels. Positive
 *        numbers will scroll the content to the left.
 * @param startY Starting vertical scroll offset in pixels. Positive numbers
 *        will scroll the content up.
 * @param dx Horizontal distance to travel. Positive numbers will scroll the
 *        content to the left.
 * @param dy Vertical distance to travel. Positive numbers will scroll the
 *        content up.
 * @apiSince 1
 */

public void startScroll(int startX, int startY, int dx, int dy) { throw new RuntimeException("Stub!"); }

/**
 * Start scrolling by providing a starting point, the distance to travel,
 * and the duration of the scroll.
 *
 * @param startX Starting horizontal scroll offset in pixels. Positive
 *        numbers will scroll the content to the left.
 * @param startY Starting vertical scroll offset in pixels. Positive numbers
 *        will scroll the content up.
 * @param dx Horizontal distance to travel. Positive numbers will scroll the
 *        content to the left.
 * @param dy Vertical distance to travel. Positive numbers will scroll the
 *        content up.
 * @param duration Duration of the scroll in milliseconds.
 * @apiSince 1
 */

public void startScroll(int startX, int startY, int dx, int dy, int duration) { throw new RuntimeException("Stub!"); }

/**
 * Start scrolling based on a fling gesture. The distance travelled will
 * depend on the initial velocity of the fling.
 *
 * @param startX Starting point of the scroll (X)
 * @param startY Starting point of the scroll (Y)
 * @param velocityX Initial velocity of the fling (X) measured in pixels per
 *        second.
 * @param velocityY Initial velocity of the fling (Y) measured in pixels per
 *        second
 * @param minX Minimum X value. The scroller will not scroll past this
 *        point.
 * @param maxX Maximum X value. The scroller will not scroll past this
 *        point.
 * @param minY Minimum Y value. The scroller will not scroll past this
 *        point.
 * @param maxY Maximum Y value. The scroller will not scroll past this
 *        point.
 * @apiSince 1
 */

public void fling(int startX, int startY, int velocityX, int velocityY, int minX, int maxX, int minY, int maxY) { throw new RuntimeException("Stub!"); }

/**
 * Stops the animation. Contrary to {@link #forceFinished(boolean)},
 * aborting the animating cause the scroller to move to the final x and y
 * position
 *
 * @see #forceFinished(boolean)
 * @apiSince 1
 */

public void abortAnimation() { throw new RuntimeException("Stub!"); }

/**
 * Extend the scroll animation. This allows a running animation to scroll
 * further and longer, when used with {@link #setFinalX(int)} or {@link #setFinalY(int)}.
 *
 * @param extend Additional time to scroll in milliseconds.
 * @see #setFinalX(int)
 * @see #setFinalY(int)
 * @apiSince 1
 */

public void extendDuration(int extend) { throw new RuntimeException("Stub!"); }

/**
 * Returns the time elapsed since the beginning of the scrolling.
 *
 * @return The elapsed time in milliseconds.
 * @apiSince 1
 */

public int timePassed() { throw new RuntimeException("Stub!"); }

/**
 * Sets the final position (X) for this scroller.
 *
 * @param newX The new X offset as an absolute distance from the origin.
 * @see #extendDuration(int)
 * @see #setFinalY(int)
 * @apiSince 1
 */

public void setFinalX(int newX) { throw new RuntimeException("Stub!"); }

/**
 * Sets the final position (Y) for this scroller.
 *
 * @param newY The new Y offset as an absolute distance from the origin.
 * @see #extendDuration(int)
 * @see #setFinalX(int)
 * @apiSince 1
 */

public void setFinalY(int newY) { throw new RuntimeException("Stub!"); }
}

