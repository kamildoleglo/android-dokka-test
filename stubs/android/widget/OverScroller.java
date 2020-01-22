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


package android.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.view.ViewConfiguration;

/**
 * This class encapsulates scrolling with the ability to overshoot the bounds
 * of a scrolling operation. This class is a drop-in replacement for
 * {@link android.widget.Scroller} in most cases.
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class OverScroller {

/**
 * Creates an OverScroller with a viscous fluid scroll interpolator and flywheel.
 * @param context
 * @apiSince 9
 */

public OverScroller(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Creates an OverScroller with flywheel enabled.
 * @param context The context of this application.
 * @param interpolator The scroll interpolator. If null, a default (viscous) interpolator will
 * be used.
 * @apiSince 9
 */

public OverScroller(android.content.Context context, android.view.animation.Interpolator interpolator) { throw new RuntimeException("Stub!"); }

/**
 * Creates an OverScroller with flywheel enabled.
 * @param context The context of this application.
 * @param interpolator The scroll interpolator. If null, a default (viscous) interpolator will
 * be used.
 * @param bounceCoefficientX A value between 0 and 1 that will determine the proportion of the
 * velocity which is preserved in the bounce when the horizontal edge is reached. A null value
 * means no bounce. This behavior is no longer supported and this coefficient has no effect.
 * @param bounceCoefficientY Same as bounceCoefficientX but for the vertical direction. This
 * behavior is no longer supported and this coefficient has no effect.
 * @deprecated Use {@link #OverScroller(android.content.Context,android.view.animation.Interpolator)} instead.
 * @apiSince 9
 */

@Deprecated
public OverScroller(android.content.Context context, android.view.animation.Interpolator interpolator, float bounceCoefficientX, float bounceCoefficientY) { throw new RuntimeException("Stub!"); }

/**
 * Creates an OverScroller.
 * @param context The context of this application.
 * @param interpolator The scroll interpolator. If null, a default (viscous) interpolator will
 * be used.
 * @param bounceCoefficientX A value between 0 and 1 that will determine the proportion of the
 * velocity which is preserved in the bounce when the horizontal edge is reached. A null value
 * means no bounce. This behavior is no longer supported and this coefficient has no effect.
 * @param bounceCoefficientY Same as bounceCoefficientX but for the vertical direction. This
 * behavior is no longer supported and this coefficient has no effect.
 * @param flywheel If true, successive fling motions will keep on increasing scroll speed.
 * @deprecated Use {@link #OverScroller(android.content.Context,android.view.animation.Interpolator)} instead.
 * @apiSince 11
 */

@Deprecated
public OverScroller(android.content.Context context, android.view.animation.Interpolator interpolator, float bounceCoefficientX, float bounceCoefficientY, boolean flywheel) { throw new RuntimeException("Stub!"); }

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
 @apiSince 9
 */

public final boolean isFinished() { throw new RuntimeException("Stub!"); }

/**
 * Force the finished field to a particular value. Contrary to
 * {@link #abortAnimation()}, forcing the animation to finished
 * does NOT cause the scroller to move to the final x and y
 * position.
 *
 * @param finished The new finished value.
 * @apiSince 9
 */

public final void forceFinished(boolean finished) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current X offset in the scroll.
 *
 * @return The new X offset as an absolute distance from the origin.
 * @apiSince 9
 */

public final int getCurrX() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current Y offset in the scroll.
 *
 * @return The new Y offset as an absolute distance from the origin.
 * @apiSince 9
 */

public final int getCurrY() { throw new RuntimeException("Stub!"); }

/**
 * Returns the absolute value of the current velocity.
 *
 * @return The original velocity less the deceleration, norm of the X and Y velocity vector.
 * @apiSince 14
 */

public float getCurrVelocity() { throw new RuntimeException("Stub!"); }

/**
 * Returns the start X offset in the scroll.
 *
 * @return The start X offset as an absolute distance from the origin.
 * @apiSince 9
 */

public final int getStartX() { throw new RuntimeException("Stub!"); }

/**
 * Returns the start Y offset in the scroll.
 *
 * @return The start Y offset as an absolute distance from the origin.
 * @apiSince 9
 */

public final int getStartY() { throw new RuntimeException("Stub!"); }

/**
 * Returns where the scroll will end. Valid only for "fling" scrolls.
 *
 * @return The final X offset as an absolute distance from the origin.
 * @apiSince 9
 */

public final int getFinalX() { throw new RuntimeException("Stub!"); }

/**
 * Returns where the scroll will end. Valid only for "fling" scrolls.
 *
 * @return The final Y offset as an absolute distance from the origin.
 * @apiSince 9
 */

public final int getFinalY() { throw new RuntimeException("Stub!"); }

/**
 * Call this when you want to know the new location. If it returns true, the
 * animation is not yet finished.
 * @apiSince 9
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
 * @apiSince 9
 */

public void startScroll(int startX, int startY, int dx, int dy) { throw new RuntimeException("Stub!"); }

/**
 * Start scrolling by providing a starting point and the distance to travel.
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
 * @apiSince 9
 */

public void startScroll(int startX, int startY, int dx, int dy, int duration) { throw new RuntimeException("Stub!"); }

/**
 * Call this when you want to 'spring back' into a valid coordinate range.
 *
 * @param startX Starting X coordinate
 * @param startY Starting Y coordinate
 * @param minX Minimum valid X value
 * @param maxX Maximum valid X value
 * @param minY Minimum valid Y value
 * @param maxY Minimum valid Y value
 * @return true if a springback was initiated, false if startX and startY were
 *          already within the valid range.
 * @apiSince 9
 */

public boolean springBack(int startX, int startY, int minX, int maxX, int minY, int maxY) { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public void fling(int startX, int startY, int velocityX, int velocityY, int minX, int maxX, int minY, int maxY) { throw new RuntimeException("Stub!"); }

/**
 * Start scrolling based on a fling gesture. The distance traveled will
 * depend on the initial velocity of the fling.
 *
 * @param startX Starting point of the scroll (X)
 * @param startY Starting point of the scroll (Y)
 * @param velocityX Initial velocity of the fling (X) measured in pixels per
 *            second.
 * @param velocityY Initial velocity of the fling (Y) measured in pixels per
 *            second
 * @param minX Minimum X value. The scroller will not scroll past this point
 *            unless overX > 0. If overfling is allowed, it will use minX as
 *            a springback boundary.
 * @param maxX Maximum X value. The scroller will not scroll past this point
 *            unless overX > 0. If overfling is allowed, it will use maxX as
 *            a springback boundary.
 * @param minY Minimum Y value. The scroller will not scroll past this point
 *            unless overY > 0. If overfling is allowed, it will use minY as
 *            a springback boundary.
 * @param maxY Maximum Y value. The scroller will not scroll past this point
 *            unless overY > 0. If overfling is allowed, it will use maxY as
 *            a springback boundary.
 * @param overX Overfling range. If > 0, horizontal overfling in either
 *            direction will be possible.
 * @param overY Overfling range. If > 0, vertical overfling in either
 *            direction will be possible.
 * @apiSince 9
 */

public void fling(int startX, int startY, int velocityX, int velocityY, int minX, int maxX, int minY, int maxY, int overX, int overY) { throw new RuntimeException("Stub!"); }

/**
 * Notify the scroller that we've reached a horizontal boundary.
 * Normally the information to handle this will already be known
 * when the animation is started, such as in a call to one of the
 * fling functions. However there are cases where this cannot be known
 * in advance. This function will transition the current motion and
 * animate from startX to finalX as appropriate.
 *
 * @param startX Starting/current X position
 * @param finalX Desired final X position
 * @param overX Magnitude of overscroll allowed. This should be the maximum
 *              desired distance from finalX. Absolute value - must be positive.
 * @apiSince 9
 */

public void notifyHorizontalEdgeReached(int startX, int finalX, int overX) { throw new RuntimeException("Stub!"); }

/**
 * Notify the scroller that we've reached a vertical boundary.
 * Normally the information to handle this will already be known
 * when the animation is started, such as in a call to one of the
 * fling functions. However there are cases where this cannot be known
 * in advance. This function will animate a parabolic motion from
 * startY to finalY.
 *
 * @param startY Starting/current Y position
 * @param finalY Desired final Y position
 * @param overY Magnitude of overscroll allowed. This should be the maximum
 *              desired distance from finalY. Absolute value - must be positive.
 * @apiSince 9
 */

public void notifyVerticalEdgeReached(int startY, int finalY, int overY) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the current Scroller is currently returning to a valid position.
 * Valid bounds were provided by the
 * {@link #fling(int,int,int,int,int,int,int,int,int,int)} method.
 *
 * One should check this value before calling
 * {@link #startScroll(int,int,int,int)} as the interpolation currently in progress
 * to restore a valid position will then be stopped. The caller has to take into account
 * the fact that the started scroll will start from an overscrolled position.
 *
 * @return true when the current position is overscrolled and in the process of
 *         interpolating back to a valid value.
 * @apiSince 9
 */

public boolean isOverScrolled() { throw new RuntimeException("Stub!"); }

/**
 * Stops the animation. Contrary to {@link #forceFinished(boolean)},
 * aborting the animating causes the scroller to move to the final x and y
 * positions.
 *
 * @see #forceFinished(boolean)
 * @apiSince 9
 */

public void abortAnimation() { throw new RuntimeException("Stub!"); }
}

