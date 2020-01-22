/*
 * Copyright (C) 2014 The Android Open Source Project
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

import android.graphics.Rect;
import android.graphics.Insets;
import android.content.Intent;

/**
 * Describes a set of insets for window content.
 *
 * <p>WindowInsets are immutable and may be expanded to include more inset types in the future.
 * To adjust insets, use one of the supplied clone methods to obtain a new WindowInsets instance
 * with the adjusted properties.</p>
 *
 * <p>Note: Before {@link android.os.Build.VERSION_CODES#P P}, WindowInsets instances were only
 * immutable during a single layout pass (i.e. would return the same values between
 * {@link android.view.View#onApplyWindowInsets View#onApplyWindowInsets} and {@link android.view.View#onLayout View#onLayout}, but could return other values
 * otherwise). Starting with {@link android.os.Build.VERSION_CODES#P P}, WindowInsets are
 * always immutable and implement equality.
 *
 * @see android.view.View.OnApplyWindowInsetsListener
 * @see android.view.View#onApplyWindowInsets(WindowInsets)
 * @apiSince 20
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class WindowInsets {

/**
 * Construct a new WindowInsets, copying all values from a source WindowInsets.
 *
 * @param src Source to copy insets from
 * @apiSince 20
 */

public WindowInsets(android.view.WindowInsets src) { throw new RuntimeException("Stub!"); }

/**
 * Returns the system window insets in pixels.
 *
 * <p>The system window inset represents the area of a full-screen window that is
 * partially or fully obscured by the status bar, navigation bar, IME or other system windows.
 * </p>
 *
 * @return The system window insets
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.Insets getSystemWindowInsets() { throw new RuntimeException("Stub!"); }

/**
 * Returns the left system window inset in pixels.
 *
 * <p>The system window inset represents the area of a full-screen window that is
 * partially or fully obscured by the status bar, navigation bar, IME or other system windows.
 * </p>
 *
 * @return The left system window inset
 * @apiSince 20
 */

public int getSystemWindowInsetLeft() { throw new RuntimeException("Stub!"); }

/**
 * Returns the top system window inset in pixels.
 *
 * <p>The system window inset represents the area of a full-screen window that is
 * partially or fully obscured by the status bar, navigation bar, IME or other system windows.
 * </p>
 *
 * @return The top system window inset
 * @apiSince 20
 */

public int getSystemWindowInsetTop() { throw new RuntimeException("Stub!"); }

/**
 * Returns the right system window inset in pixels.
 *
 * <p>The system window inset represents the area of a full-screen window that is
 * partially or fully obscured by the status bar, navigation bar, IME or other system windows.
 * </p>
 *
 * @return The right system window inset
 * @apiSince 20
 */

public int getSystemWindowInsetRight() { throw new RuntimeException("Stub!"); }

/**
 * Returns the bottom system window inset in pixels.
 *
 * <p>The system window inset represents the area of a full-screen window that is
 * partially or fully obscured by the status bar, navigation bar, IME or other system windows.
 * </p>
 *
 * @return The bottom system window inset
 * @apiSince 20
 */

public int getSystemWindowInsetBottom() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this WindowInsets has nonzero system window insets.
 *
 * <p>The system window inset represents the area of a full-screen window that is
 * partially or fully obscured by the status bar, navigation bar, IME or other system windows.
 * </p>
 *
 * @return true if any of the system window inset values are nonzero
 * @apiSince 20
 */

public boolean hasSystemWindowInsets() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this WindowInsets has any nonzero insets.
 *
 * @return true if any inset values are nonzero
 * @apiSince 20
 */

public boolean hasInsets() { throw new RuntimeException("Stub!"); }

/**
 * Returns the display cutout if there is one.
 *
 * @return the display cutout or null if there is none
 * @see android.view.DisplayCutout
 * @apiSince 28
 */

@androidx.annotation.Nullable
public android.view.DisplayCutout getDisplayCutout() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this WindowInsets with the cutout fully consumed.
 *
 * @return A modified copy of this WindowInsets
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.view.WindowInsets consumeDisplayCutout() { throw new RuntimeException("Stub!"); }

/**
 * Check if these insets have been fully consumed.
 *
 * <p>Insets are considered "consumed" if the applicable <code>consume*</code> methods
 * have been called such that all insets have been set to zero. This affects propagation of
 * insets through the view hierarchy; insets that have not been fully consumed will continue
 * to propagate down to child views.</p>
 *
 * <p>The result of this method is equivalent to the return value of
 * {@link android.view.View#fitSystemWindows(android.graphics.Rect) View#fitSystemWindows(android.graphics.Rect)}.</p>
 *
 * @return true if the insets have been fully consumed.
 * @apiSince 21
 */

public boolean isConsumed() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the associated window has a round shape.
 *
 * <p>A round window's left, top, right and bottom edges reach all the way to the
 * associated edges of the window but the corners may not be visible. Views responding
 * to round insets should take care to not lay out critical elements within the corners
 * where they may not be accessible.</p>
 *
 * @return True if the window is round
 * @apiSince 20
 */

public boolean isRound() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this WindowInsets with the system window insets fully consumed.
 *
 * @return A modified copy of this WindowInsets
 
 * This value will never be {@code null}.
 * @apiSince 20
 */

@androidx.annotation.NonNull
public android.view.WindowInsets consumeSystemWindowInsets() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this WindowInsets with selected system window insets replaced
 * with new values.
 *
 * <p>Note: If the system window insets are already consumed, this method will return them
 * unchanged on {@link android.os.Build.VERSION_CODES#Q Q} and later. Prior to
 * {@link android.os.Build.VERSION_CODES#Q Q}, the new values were applied regardless of
 * whether they were consumed, and this method returns invalid non-zero consumed insets.
 *
 * @param left New left inset in pixels
 * @param top New top inset in pixels
 * @param right New right inset in pixels
 * @param bottom New bottom inset in pixels
 * @return A modified copy of this WindowInsets
 * This value will never be {@code null}.
 * @deprecated use {@code Builder#Builder(WindowInsets)} with
 *             {@link android.view.WindowInsets.Builder#setSystemWindowInsets(android.graphics.Insets) Builder#setSystemWindowInsets(Insets)} instead.
 * @apiSince 20
 * @deprecatedSince 29
 */

@Deprecated
@androidx.annotation.NonNull
public android.view.WindowInsets replaceSystemWindowInsets(int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this WindowInsets with selected system window insets replaced
 * with new values.
 *
 * <p>Note: If the system window insets are already consumed, this method will return them
 * unchanged on {@link android.os.Build.VERSION_CODES#Q Q} and later. Prior to
 * {@link android.os.Build.VERSION_CODES#Q Q}, the new values were applied regardless of
 * whether they were consumed, and this method returns invalid non-zero consumed insets.
 *
 * @param systemWindowInsets New system window insets. Each field is the inset in pixels
 *                           for that edge
 * @return A modified copy of this WindowInsets
 * This value will never be {@code null}.
 * @deprecated use {@code Builder#Builder(WindowInsets)} with
 *             {@link android.view.WindowInsets.Builder#setSystemWindowInsets(android.graphics.Insets) Builder#setSystemWindowInsets(Insets)} instead.
 * @apiSince 21
 * @deprecatedSince 29
 */

@Deprecated
@androidx.annotation.NonNull
public android.view.WindowInsets replaceSystemWindowInsets(android.graphics.Rect systemWindowInsets) { throw new RuntimeException("Stub!"); }

/**
 * Returns the stable insets in pixels.
 *
 * <p>The stable inset represents the area of a full-screen window that <b>may</b> be
 * partially or fully obscured by the system UI elements.  This value does not change
 * based on the visibility state of those elements; for example, if the status bar is
 * normally shown, but temporarily hidden, the stable inset will still provide the inset
 * associated with the status bar being shown.</p>
 *
 * @return The stable insets
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.Insets getStableInsets() { throw new RuntimeException("Stub!"); }

/**
 * Returns the top stable inset in pixels.
 *
 * <p>The stable inset represents the area of a full-screen window that <b>may</b> be
 * partially or fully obscured by the system UI elements.  This value does not change
 * based on the visibility state of those elements; for example, if the status bar is
 * normally shown, but temporarily hidden, the stable inset will still provide the inset
 * associated with the status bar being shown.</p>
 *
 * @return The top stable inset
 * @apiSince 21
 */

public int getStableInsetTop() { throw new RuntimeException("Stub!"); }

/**
 * Returns the left stable inset in pixels.
 *
 * <p>The stable inset represents the area of a full-screen window that <b>may</b> be
 * partially or fully obscured by the system UI elements.  This value does not change
 * based on the visibility state of those elements; for example, if the status bar is
 * normally shown, but temporarily hidden, the stable inset will still provide the inset
 * associated with the status bar being shown.</p>
 *
 * @return The left stable inset
 * @apiSince 21
 */

public int getStableInsetLeft() { throw new RuntimeException("Stub!"); }

/**
 * Returns the right stable inset in pixels.
 *
 * <p>The stable inset represents the area of a full-screen window that <b>may</b> be
 * partially or fully obscured by the system UI elements.  This value does not change
 * based on the visibility state of those elements; for example, if the status bar is
 * normally shown, but temporarily hidden, the stable inset will still provide the inset
 * associated with the status bar being shown.</p>
 *
 * @return The right stable inset
 * @apiSince 21
 */

public int getStableInsetRight() { throw new RuntimeException("Stub!"); }

/**
 * Returns the bottom stable inset in pixels.
 *
 * <p>The stable inset represents the area of a full-screen window that <b>may</b> be
 * partially or fully obscured by the system UI elements.  This value does not change
 * based on the visibility state of those elements; for example, if the status bar is
 * normally shown, but temporarily hidden, the stable inset will still provide the inset
 * associated with the status bar being shown.</p>
 *
 * @return The bottom stable inset
 * @apiSince 21
 */

public int getStableInsetBottom() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this WindowInsets has nonzero stable insets.
 *
 * <p>The stable inset represents the area of a full-screen window that <b>may</b> be
 * partially or fully obscured by the system UI elements.  This value does not change
 * based on the visibility state of those elements; for example, if the status bar is
 * normally shown, but temporarily hidden, the stable inset will still provide the inset
 * associated with the status bar being shown.</p>
 *
 * @return true if any of the stable inset values are nonzero
 * @apiSince 21
 */

public boolean hasStableInsets() { throw new RuntimeException("Stub!"); }

/**
 * Returns the system gesture insets.
 *
 * <p>The system gesture insets represent the area of a window where system gestures have
 * priority and may consume some or all touch input, e.g. due to the a system bar
 * occupying it, or it being reserved for touch-only gestures.
 *
 * <p>An app can declare priority over system gestures with
 * {@link android.view.View#setSystemGestureExclusionRects View#setSystemGestureExclusionRects} outside of the
 * {@link #getMandatorySystemGestureInsets() mandatory system gesture insets}.
 *
 * <p>Note: the system will put a limit of <code>200dp</code> on the vertical extent of the
 * exclusions it takes into account. The limit does not apply while the navigation
 * bar is {@link android.view.View#SYSTEM_UI_FLAG_IMMERSIVE_STICKY View#SYSTEM_UI_FLAG_IMMERSIVE_STICKY} hidden, nor to the
 * {@link android.inputmethodservice.InputMethodService input method} and
 * {@link android.content.Intent#CATEGORY_HOME Intent#CATEGORY_HOME}.
 * </p>
 *
 *
 * <p>Simple taps are guaranteed to reach the window even within the system gesture insets,
 * as long as they are outside the {@link #getTappableElementInsets() system window insets}.
 *
 * <p>When {@link android.view.View#SYSTEM_UI_FLAG_LAYOUT_STABLE View#SYSTEM_UI_FLAG_LAYOUT_STABLE} is requested, an inset will be returned
 * even when the system gestures are inactive due to
 * {@link android.view.View#SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN View#SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN} or
 * {@link android.view.View#SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION View#SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION}.
 *
 * <p>This inset is consumed together with the {@link #getSystemWindowInsets()
 * system window insets} by {@link #consumeSystemWindowInsets()}.
 *
 * @see #getMandatorySystemGestureInsets
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.Insets getSystemGestureInsets() { throw new RuntimeException("Stub!"); }

/**
 * Returns the mandatory system gesture insets.
 *
 * <p>The mandatory system gesture insets represent the area of a window where mandatory system
 * gestures have priority and may consume some or all touch input, e.g. due to the a system bar
 * occupying it, or it being reserved for touch-only gestures.
 *
 * <p>In contrast to {@link #getSystemGestureInsets regular system gestures}, <b>mandatory</b>
 * system gestures cannot be overriden by {@link android.view.View#setSystemGestureExclusionRects View#setSystemGestureExclusionRects}.
 *
 * <p>Simple taps are guaranteed to reach the window even within the system gesture insets,
 * as long as they are outside the {@link #getTappableElementInsets() system window insets}.
 *
 * <p>When {@link android.view.View#SYSTEM_UI_FLAG_LAYOUT_STABLE View#SYSTEM_UI_FLAG_LAYOUT_STABLE} is requested, an inset will be returned
 * even when the system gestures are inactive due to
 * {@link android.view.View#SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN View#SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN} or
 * {@link android.view.View#SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION View#SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION}.
 *
 * <p>This inset is consumed together with the {@link #getSystemWindowInsets()
 * system window insets} by {@link #consumeSystemWindowInsets()}.
 *
 * @see #getSystemGestureInsets
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.Insets getMandatorySystemGestureInsets() { throw new RuntimeException("Stub!"); }

/**
 * Returns the tappable element insets.
 *
 * <p>The tappable element insets represent how much tappable elements <b>must at least</b> be
 * inset to remain both tappable and visually unobstructed by persistent system windows.
 *
 * <p>This may be smaller than {@link #getSystemWindowInsets()} if the system window is
 * largely transparent and lets through simple taps (but not necessarily more complex gestures).
 *
 * <p>Note that generally, tappable elements <strong>should</strong> be aligned with the
 * {@link #getSystemWindowInsets() system window insets} instead to avoid overlapping with the
 * system bars.
 *
 * <p>When {@link android.view.View#SYSTEM_UI_FLAG_LAYOUT_STABLE View#SYSTEM_UI_FLAG_LAYOUT_STABLE} is requested, an inset will be returned
 * even when the area covered by the inset would be tappable due to
 * {@link android.view.View#SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN View#SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN} or
 * {@link android.view.View#SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION View#SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION}.
 *
 * <p>This inset is consumed together with the {@link #getSystemWindowInsets()
 * system window insets} by {@link #consumeSystemWindowInsets()}.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.Insets getTappableElementInsets() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this WindowInsets with the stable insets fully consumed.
 *
 * @return A modified copy of this WindowInsets
 
 * This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public android.view.WindowInsets consumeStableInsets() { throw new RuntimeException("Stub!"); }

/** @apiSince 20 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this instance inset in the given directions.
 *
 * This is intended for dispatching insets to areas of the window that are smaller than the
 * current area.
 *
 * <p>Example:
 * <pre>
 * childView.dispatchApplyWindowInsets(insets.inset(
 *         childMarginLeft, childMarginTop, childMarginBottom, childMarginRight));
 * </pre>
 *
 * @param left the amount of insets to remove from the left. Must be non-negative.
 * Value is 0 or greater
 * @param top the amount of insets to remove from the top. Must be non-negative.
 * Value is 0 or greater
 * @param right the amount of insets to remove from the right. Must be non-negative.
 * Value is 0 or greater
 * @param bottom the amount of insets to remove from the bottom. Must be non-negative.
 *
 * Value is 0 or greater
 * @return the inset insets
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.WindowInsets inset(int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/** @apiSince 20 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 20 */

public int hashCode() { throw new RuntimeException("Stub!"); }
/**
 * Builder for WindowInsets.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Creates a builder where all insets are initially consumed.
 * @apiSince 29
 */

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Creates a builder where all insets are initialized from {@link android.view.WindowInsets WindowInsets}.
 *
 * @param insets the instance to initialize from.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public Builder(@androidx.annotation.NonNull android.view.WindowInsets insets) { throw new RuntimeException("Stub!"); }

/**
 * Sets system window insets in pixels.
 *
 * <p>The system window inset represents the area of a full-screen window that is
 * partially or fully obscured by the status bar, navigation bar, IME or other system
 * windows.</p>
 *
 * @see #getSystemWindowInsets()
 * @param systemWindowInsets This value must never be {@code null}.
 * @return itself
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.WindowInsets.Builder setSystemWindowInsets(@androidx.annotation.NonNull android.graphics.Insets systemWindowInsets) { throw new RuntimeException("Stub!"); }

/**
 * Sets system gesture insets in pixels.
 *
 * <p>The system gesture insets represent the area of a window where system gestures have
 * priority and may consume some or all touch input, e.g. due to the a system bar
 * occupying it, or it being reserved for touch-only gestures.
 *
 * @see #getSystemGestureInsets()
 * @param insets This value must never be {@code null}.
 * @return itself
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.WindowInsets.Builder setSystemGestureInsets(@androidx.annotation.NonNull android.graphics.Insets insets) { throw new RuntimeException("Stub!"); }

/**
 * Sets mandatory system gesture insets in pixels.
 *
 * <p>The mandatory system gesture insets represent the area of a window where mandatory
 * system gestures have priority and may consume some or all touch input, e.g. due to the a
 * system bar occupying it, or it being reserved for touch-only gestures.
 *
 * <p>In contrast to {@link #setSystemGestureInsets regular system gestures},
 * <b>mandatory</b> system gestures cannot be overriden by
 * {@link android.view.View#setSystemGestureExclusionRects View#setSystemGestureExclusionRects}.
 *
 * @see #getMandatorySystemGestureInsets()
 * @param insets This value must never be {@code null}.
 * @return itself
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.WindowInsets.Builder setMandatorySystemGestureInsets(@androidx.annotation.NonNull android.graphics.Insets insets) { throw new RuntimeException("Stub!"); }

/**
 * Sets tappable element insets in pixels.
 *
 * <p>The tappable element insets represent how much tappable elements <b>must at least</b>
 * be inset to remain both tappable and visually unobstructed by persistent system windows.
 *
 * @see #getTappableElementInsets()
 * @param insets This value must never be {@code null}.
 * @return itself
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.WindowInsets.Builder setTappableElementInsets(@androidx.annotation.NonNull android.graphics.Insets insets) { throw new RuntimeException("Stub!"); }

/**
 * Sets the stable insets in pixels.
 *
 * <p>The stable inset represents the area of a full-screen window that <b>may</b> be
 * partially or fully obscured by the system UI elements.  This value does not change
 * based on the visibility state of those elements; for example, if the status bar is
 * normally shown, but temporarily hidden, the stable inset will still provide the inset
 * associated with the status bar being shown.</p>
 *
 * @see #getStableInsets()
 * @param stableInsets This value must never be {@code null}.
 * @return itself
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.WindowInsets.Builder setStableInsets(@androidx.annotation.NonNull android.graphics.Insets stableInsets) { throw new RuntimeException("Stub!"); }

/**
 * Sets the display cutout.
 *
 * @see #getDisplayCutout()
 * @param displayCutout the display cutout or null if there is none
 * This value may be {@code null}.
 * @return itself
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.WindowInsets.Builder setDisplayCutout(@androidx.annotation.Nullable android.view.DisplayCutout displayCutout) { throw new RuntimeException("Stub!"); }

/**
 * Builds a {@link android.view.WindowInsets WindowInsets} instance.
 *
 * @return the {@link android.view.WindowInsets WindowInsets} instance.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.WindowInsets build() { throw new RuntimeException("Stub!"); }
}

}

