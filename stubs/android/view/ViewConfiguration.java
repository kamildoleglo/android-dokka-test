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

import android.content.Context;

/**
 * Contains methods to standard constants used in the UI for timeouts, sizes, and distances.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ViewConfiguration {

/**
 * @deprecated Use {@link android.view.ViewConfiguration#get(android.content.Context)} instead.
 * @apiSince 1
 */

@Deprecated
public ViewConfiguration() { throw new RuntimeException("Stub!"); }

/**
 * Returns a configuration for the specified context. The configuration depends on
 * various parameters of the context, like the dimension of the display or the
 * density of the display.
 *
 * @param context The application context used to initialize the view configuration.
 * @apiSince 3
 */

public static android.view.ViewConfiguration get(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * @return The width of the horizontal scrollbar and the height of the vertical
 *         scrollbar in dips
 *
 * @deprecated Use {@link #getScaledScrollBarSize()} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static int getScrollBarSize() { throw new RuntimeException("Stub!"); }

/**
 * @return The width of the horizontal scrollbar and the height of the vertical
 *         scrollbar in pixels
 * @apiSince 3
 */

public int getScaledScrollBarSize() { throw new RuntimeException("Stub!"); }

/**
 * @return Duration of the fade when scrollbars fade away in milliseconds
 * @apiSince 5
 */

public static int getScrollBarFadeDuration() { throw new RuntimeException("Stub!"); }

/**
 * @return Default delay before the scrollbars fade in milliseconds
 * @apiSince 5
 */

public static int getScrollDefaultDelay() { throw new RuntimeException("Stub!"); }

/**
 * @return the length of the fading edges in dips
 *
 * @deprecated Use {@link #getScaledFadingEdgeLength()} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static int getFadingEdgeLength() { throw new RuntimeException("Stub!"); }

/**
 * @return the length of the fading edges in pixels
 * @apiSince 3
 */

public int getScaledFadingEdgeLength() { throw new RuntimeException("Stub!"); }

/**
 * @return the duration in milliseconds of the pressed state in child
 * components.
 * @apiSince 1
 */

public static int getPressedStateDuration() { throw new RuntimeException("Stub!"); }

/**
 * @return the duration in milliseconds before a press turns into
 * a long press
 * @apiSince 1
 */

public static int getLongPressTimeout() { throw new RuntimeException("Stub!"); }

/**
 * @return the time before the first key repeat in milliseconds.
 * @apiSince 12
 */

public static int getKeyRepeatTimeout() { throw new RuntimeException("Stub!"); }

/**
 * @return the time between successive key repeats in milliseconds.
 * @apiSince 12
 */

public static int getKeyRepeatDelay() { throw new RuntimeException("Stub!"); }

/**
 * @return the duration in milliseconds we will wait to see if a touch event
 * is a tap or a scroll. If the user does not move within this interval, it is
 * considered to be a tap.
 * @apiSince 1
 */

public static int getTapTimeout() { throw new RuntimeException("Stub!"); }

/**
 * @return the duration in milliseconds we will wait to see if a touch event
 * is a jump tap. If the user does not move within this interval, it is
 * considered to be a tap.
 * @apiSince 1
 */

public static int getJumpTapTimeout() { throw new RuntimeException("Stub!"); }

/**
 * @return the duration in milliseconds between the first tap's up event and
 * the second tap's down event for an interaction to be considered a
 * double-tap.
 * @apiSince 3
 */

public static int getDoubleTapTimeout() { throw new RuntimeException("Stub!"); }

/**
 * @return Inset in dips to look for touchable content when the user touches the edge of the
 *         screen
 *
 * @deprecated Use {@link #getScaledEdgeSlop()} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static int getEdgeSlop() { throw new RuntimeException("Stub!"); }

/**
 * @return Inset in pixels to look for touchable content when the user touches the edge of the
 *         screen
 * @apiSince 3
 */

public int getScaledEdgeSlop() { throw new RuntimeException("Stub!"); }

/**
 * @return Distance in dips a touch can wander before we think the user is scrolling
 *
 * @deprecated Use {@link #getScaledTouchSlop()} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static int getTouchSlop() { throw new RuntimeException("Stub!"); }

/**
 * @return Distance in pixels a touch can wander before we think the user is scrolling
 * @apiSince 3
 */

public int getScaledTouchSlop() { throw new RuntimeException("Stub!"); }

/**
 * @return Distance in pixels a hover can wander while it is still considered "stationary".
 *
 * @apiSince 28
 */

public int getScaledHoverSlop() { throw new RuntimeException("Stub!"); }

/**
 * @return Distance in pixels a touch can wander before we think the user is scrolling a full
 * page
 * @apiSince 8
 */

public int getScaledPagingTouchSlop() { throw new RuntimeException("Stub!"); }

/**
 * @return Distance in pixels between the first touch and second touch to still be
 *         considered a double tap
 * @apiSince 3
 */

public int getScaledDoubleTapSlop() { throw new RuntimeException("Stub!"); }

/**
 * @return Distance in dips a touch must be outside the bounds of a window for it
 * to be counted as outside the window for purposes of dismissing that
 * window.
 *
 * @deprecated Use {@link #getScaledWindowTouchSlop()} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static int getWindowTouchSlop() { throw new RuntimeException("Stub!"); }

/**
 * @return Distance in pixels a touch must be outside the bounds of a window for it
 * to be counted as outside the window for purposes of dismissing that window.
 * @apiSince 3
 */

public int getScaledWindowTouchSlop() { throw new RuntimeException("Stub!"); }

/**
 * @return Minimum velocity to initiate a fling, as measured in dips per second.
 *
 * @deprecated Use {@link #getScaledMinimumFlingVelocity()} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static int getMinimumFlingVelocity() { throw new RuntimeException("Stub!"); }

/**
 * @return Minimum velocity to initiate a fling, as measured in pixels per second.
 * @apiSince 3
 */

public int getScaledMinimumFlingVelocity() { throw new RuntimeException("Stub!"); }

/**
 * @return Maximum velocity to initiate a fling, as measured in dips per second.
 *
 * @deprecated Use {@link #getScaledMaximumFlingVelocity()} instead.
 * @apiSince 4
 * @deprecatedSince 15
 */

@Deprecated
public static int getMaximumFlingVelocity() { throw new RuntimeException("Stub!"); }

/**
 * @return Maximum velocity to initiate a fling, as measured in pixels per second.
 * @apiSince 4
 */

public int getScaledMaximumFlingVelocity() { throw new RuntimeException("Stub!"); }

/**
 * @return Amount to scroll in response to a horizontal {@link android.view.MotionEvent#ACTION_SCROLL MotionEvent#ACTION_SCROLL} event.
 * Multiply this by the event's axis value to obtain the number of pixels to be scrolled.
 * @apiSince 26
 */

public float getScaledHorizontalScrollFactor() { throw new RuntimeException("Stub!"); }

/**
 * @return Amount to scroll in response to a vertical {@link android.view.MotionEvent#ACTION_SCROLL MotionEvent#ACTION_SCROLL} event.
 * Multiply this by the event's axis value to obtain the number of pixels to be scrolled.
 * @apiSince 26
 */

public float getScaledVerticalScrollFactor() { throw new RuntimeException("Stub!"); }

/**
 * The maximum drawing cache size expressed in bytes.
 *
 * @return the maximum size of View's drawing cache expressed in bytes
 *
 * @deprecated Use {@link #getScaledMaximumDrawingCacheSize()} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static int getMaximumDrawingCacheSize() { throw new RuntimeException("Stub!"); }

/**
 * The maximum drawing cache size expressed in bytes.
 *
 * @return the maximum size of View's drawing cache expressed in bytes
 * @apiSince 3
 */

public int getScaledMaximumDrawingCacheSize() { throw new RuntimeException("Stub!"); }

/**
 * @return The maximum distance a View should overscroll by when showing edge effects (in
 * pixels).
 * @apiSince 9
 */

public int getScaledOverscrollDistance() { throw new RuntimeException("Stub!"); }

/**
 * @return The maximum distance a View should overfling by when showing edge effects (in
 * pixels).
 * @apiSince 9
 */

public int getScaledOverflingDistance() { throw new RuntimeException("Stub!"); }

/**
 * The amount of time that the zoom controls should be
 * displayed on the screen expressed in milliseconds.
 *
 * @return the time the zoom controls should be visible expressed
 * in milliseconds.
 * @apiSince 1
 */

public static long getZoomControlsTimeout() { throw new RuntimeException("Stub!"); }

/**
 * The amount of time a user needs to press the relevant key to bring up
 * the global actions dialog.
 *
 * @return how long a user needs to press the relevant key to bring up
 *   the global actions dialog.
 * @deprecated This timeout should not be used by applications
 * @apiSince 1
 * @deprecatedSince 20
 */

@Deprecated
public static long getGlobalActionKeyTimeout() { throw new RuntimeException("Stub!"); }

/**
 * The amount of friction applied to scrolls and flings.
 *
 * @return A scalar dimensionless value representing the coefficient of
 *         friction.
 * @apiSince 1
 */

public static float getScrollFriction() { throw new RuntimeException("Stub!"); }

/**
 * @return the default duration in milliseconds for {@link android.view.ActionMode#hide(long) ActionMode#hide(long)}.
 * @apiSince 23
 */

public static long getDefaultActionModeHideDuration() { throw new RuntimeException("Stub!"); }

/**
 * If a MotionEvent has {@link android.view.MotionEvent#CLASSIFICATION_AMBIGUOUS_GESTURE} set,
 * then certain actions, such as scrolling, will be inhibited.
 * However, to account for the possibility of incorrect classification,
 * the default scrolling will only be inhibited if the pointer travels less than
 * (getScaledTouchSlop() * this factor).
 * Likewise, the default long press timeout will be increased by this factor for some situations
 * where the default behaviour is to cancel it.
 *
 * @return The multiplication factor for inhibiting default gestures.
 
 * Value is 1.0 or greater
 * @apiSince 29
 */

public static float getAmbiguousGestureMultiplier() { throw new RuntimeException("Stub!"); }

/**
 * Report if the device has a permanent menu key available to the user.
 *
 * <p>As of Android 3.0, devices may not have a permanent menu key available.
 * Apps should use the action bar to present menu options to users.
 * However, there are some apps where the action bar is inappropriate
 * or undesirable. This method may be used to detect if a menu key is present.
 * If not, applications should provide another on-screen affordance to access
 * functionality.
 *
 * @return true if a permanent menu key is present, false otherwise.
 * @apiSince 14
 */

public boolean hasPermanentMenuKey() { throw new RuntimeException("Stub!"); }

/**
 * Check if shortcuts should be displayed in menus.
 *
 * @return {@code True} if shortcuts should be displayed in menus.
 * @apiSince 28
 */

public boolean shouldShowMenuShortcutsWhenKeyboardPresent() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the distance in pixels between touches that must be reached for a gesture to be
 * interpreted as scaling.
 *
 * In general, scaling shouldn't start until this distance has been met or surpassed, and
 * scaling should end when the distance in pixels between touches drops below this distance.
 *
 * @return The distance in pixels
 * @throws java.lang.IllegalStateException if this method is called on a ViewConfiguration that was
 *         instantiated using a constructor with no Context parameter.
 * @apiSince 29
 */

public int getScaledMinimumScalingSpan() { throw new RuntimeException("Stub!"); }
}

