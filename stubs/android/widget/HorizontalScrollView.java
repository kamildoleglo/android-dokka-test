/*
 * Copyright (C) 2009 The Android Open Source Project
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

import android.view.View;
import android.view.ViewGroup;

/**
 * Layout container for a view hierarchy that can be scrolled by the user,
 * allowing it to be larger than the physical display.  A HorizontalScrollView
 * is a {@link android.widget.FrameLayout FrameLayout}, meaning you should place one child in it
 * containing the entire contents to scroll; this child may itself be a layout
 * manager with a complex hierarchy of objects.  A child that is often used
 * is a {@link android.widget.LinearLayout LinearLayout} in a horizontal orientation, presenting a horizontal
 * array of top-level items that the user can scroll through.
 *
 * <p>The {@link android.widget.TextView TextView} class also
 * takes care of its own scrolling, so does not require a HorizontalScrollView, but
 * using the two together is possible to achieve the effect of a text view
 * within a larger container.
 *
 * <p>HorizontalScrollView only supports horizontal scrolling. For vertical scrolling,
 * use either {@link android.widget.ScrollView ScrollView} or {@link android.widget.ListView ListView}.
 *
 * @attr ref android.R.styleable#HorizontalScrollView_fillViewport
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class HorizontalScrollView extends android.widget.FrameLayout {

/** @apiSince 3 */

public HorizontalScrollView(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public HorizontalScrollView(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public HorizontalScrollView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public HorizontalScrollView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

protected float getLeftFadingEdgeStrength() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

protected float getRightFadingEdgeStrength() { throw new RuntimeException("Stub!"); }

/**
 * Sets the edge effect color for both left and right edge effects.
 *
 * @param color The color for the edge effects.
 * @see #setLeftEdgeEffectColor(int)
 * @see #setRightEdgeEffectColor(int)
 * @see #getLeftEdgeEffectColor()
 * @see #getRightEdgeEffectColor()
 * @apiSince 29
 */

public void setEdgeEffectColor(int color) { throw new RuntimeException("Stub!"); }

/**
 * Sets the right edge effect color.
 *
 * @param color The color for the right edge effect.
 * @see #setLeftEdgeEffectColor(int)
 * @see #setEdgeEffectColor(int)
 * @see #getLeftEdgeEffectColor()
 * @see #getRightEdgeEffectColor()
 * @apiSince 29
 */

public void setRightEdgeEffectColor(int color) { throw new RuntimeException("Stub!"); }

/**
 * Sets the left edge effect color.
 *
 * @param color The color for the left edge effect.
 * @see #setRightEdgeEffectColor(int)
 * @see #setEdgeEffectColor(int)
 * @see #getLeftEdgeEffectColor()
 * @see #getRightEdgeEffectColor()
 * @apiSince 29
 */

public void setLeftEdgeEffectColor(int color) { throw new RuntimeException("Stub!"); }

/**
 * Returns the left edge effect color.
 *
 * @return The left edge effect color.
 * @see #setEdgeEffectColor(int)
 * @see #setLeftEdgeEffectColor(int)
 * @see #setRightEdgeEffectColor(int)
 * @see #getRightEdgeEffectColor()
 * @apiSince 29
 */

public int getLeftEdgeEffectColor() { throw new RuntimeException("Stub!"); }

/**
 * Returns the right edge effect color.
 *
 * @return The right edge effect color.
 * @see #setEdgeEffectColor(int)
 * @see #setLeftEdgeEffectColor(int)
 * @see #setRightEdgeEffectColor(int)
 * @see #getLeftEdgeEffectColor()
 * @apiSince 29
 */

public int getRightEdgeEffectColor() { throw new RuntimeException("Stub!"); }

/**
 * @return The maximum amount this scroll view will scroll in response to
 *   an arrow event.
 * @apiSince 3
 */

public int getMaxScrollAmount() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void addView(android.view.View child) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void addView(android.view.View child, int index) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void addView(android.view.View child, android.view.ViewGroup.LayoutParams params) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void addView(android.view.View child, int index, android.view.ViewGroup.LayoutParams params) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether this HorizontalScrollView's content is stretched to
 * fill the viewport.
 *
 * @return True if the content fills the viewport, false otherwise.
 *
 * @attr ref android.R.styleable#HorizontalScrollView_fillViewport
 * @apiSince 3
 */

public boolean isFillViewport() { throw new RuntimeException("Stub!"); }

/**
 * Indicates this HorizontalScrollView whether it should stretch its content width
 * to fill the viewport or not.
 *
 * @param fillViewport True to stretch the content's width to the viewport's
 *        boundaries, false otherwise.
 *
 * @attr ref android.R.styleable#HorizontalScrollView_fillViewport
 * @apiSince 3
 */

public void setFillViewport(boolean fillViewport) { throw new RuntimeException("Stub!"); }

/**
 * @return Whether arrow scrolling will animate its transition.
 * @apiSince 3
 */

public boolean isSmoothScrollingEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Set whether arrow scrolling will animate its transition.
 * @param smoothScrollingEnabled whether arrow scrolling will animate its transition
 * @apiSince 3
 */

public void setSmoothScrollingEnabled(boolean smoothScrollingEnabled) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public boolean dispatchKeyEvent(android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * You can call this function yourself to have the scroll view perform
 * scrolling from a key event, just as if the event had been dispatched to
 * it by the view hierarchy.
 *
 * @param event The key event to execute.
 * @return Return true if the event was handled, else false.
 * @apiSince 3
 */

public boolean executeKeyEvent(android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public boolean onInterceptTouchEvent(android.view.MotionEvent ev) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public boolean onTouchEvent(android.view.MotionEvent ev) { throw new RuntimeException("Stub!"); }

/** @apiSince 12 */

public boolean onGenericMotionEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public boolean shouldDelayChildPressedState() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }

/**
 * <p>Handles scrolling in response to a "page up/down" shortcut press. This
 * method will scroll the view by one page left or right and give the focus
 * to the leftmost/rightmost component in the new visible area. If no
 * component is a good candidate for focus, this scrollview reclaims the
 * focus.</p>
 *
 * @param direction the scroll direction: {@link android.view.View#FOCUS_LEFT}
 *                  to go one page left or {@link android.view.View#FOCUS_RIGHT}
 *                  to go one page right
 * @return true if the key event is consumed by this method, false otherwise
 * @apiSince 3
 */

public boolean pageScroll(int direction) { throw new RuntimeException("Stub!"); }

/**
 * <p>Handles scrolling in response to a "home/end" shortcut press. This
 * method will scroll the view to the left or right and give the focus
 * to the leftmost/rightmost component in the new visible area. If no
 * component is a good candidate for focus, this scrollview reclaims the
 * focus.</p>
 *
 * @param direction the scroll direction: {@link android.view.View#FOCUS_LEFT}
 *                  to go the left of the view or {@link android.view.View#FOCUS_RIGHT}
 *                  to go the right
 * @return true if the key event is consumed by this method, false otherwise
 * @apiSince 3
 */

public boolean fullScroll(int direction) { throw new RuntimeException("Stub!"); }

/**
 * Handle scrolling in response to a left or right arrow click.
 *
 * @param direction The direction corresponding to the arrow key that was
 *                  pressed
 * @return True if we consumed the event, false otherwise
 * @apiSince 3
 */

public boolean arrowScroll(int direction) { throw new RuntimeException("Stub!"); }

/**
 * Like {@link android.view.View#scrollBy View#scrollBy}, but scroll smoothly instead of immediately.
 *
 * @param dx the number of pixels to scroll by on the X axis
 * @param dy the number of pixels to scroll by on the Y axis
 * @apiSince 3
 */

public final void smoothScrollBy(int dx, int dy) { throw new RuntimeException("Stub!"); }

/**
 * Like {@link #scrollTo}, but scroll smoothly instead of immediately.
 *
 * @param x the position where to scroll on the X axis
 * @param y the position where to scroll on the Y axis
 * @apiSince 3
 */

public final void smoothScrollTo(int x, int y) { throw new RuntimeException("Stub!"); }

/**
 * <p>The scroll range of a scroll view is the overall width of all of its
 * children.</p>
 * @apiSince 3
 */

protected int computeHorizontalScrollRange() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

protected int computeHorizontalScrollOffset() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

protected void measureChild(android.view.View child, int parentWidthMeasureSpec, int parentHeightMeasureSpec) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

protected void measureChildWithMargins(android.view.View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void computeScroll() { throw new RuntimeException("Stub!"); }

/**
 * Compute the amount to scroll in the X direction in order to get
 * a rectangle completely on the screen (or, if taller than the screen,
 * at least the first screen size chunk of it).
 *
 * @param rect The rect.
 * @return The scroll delta.
 * @apiSince 3
 */

protected int computeScrollDeltaToGetChildRectOnScreen(android.graphics.Rect rect) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void requestChildFocus(android.view.View child, android.view.View focused) { throw new RuntimeException("Stub!"); }

/**
 * When looking for focus in children of a scroll view, need to be a little
 * more careful not to give focus to something that is scrolled off screen.
 *
 * This is more expensive than the default {@link android.view.ViewGroup}
 * implementation, otherwise this behavior might have been made the default.
 * @apiSince 3
 */

protected boolean onRequestFocusInDescendants(int direction, android.graphics.Rect previouslyFocusedRect) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public boolean requestChildRectangleOnScreen(android.view.View child, android.graphics.Rect rectangle, boolean immediate) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void requestLayout() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

protected void onLayout(boolean changed, int l, int t, int r, int b) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

protected void onSizeChanged(int w, int h, int oldw, int oldh) { throw new RuntimeException("Stub!"); }

/**
 * Fling the scroll view
 *
 * @param velocityX The initial velocity in the X direction. Positive
 *                  numbers mean that the finger/cursor is moving down the screen,
 *                  which means we want to scroll towards the left.
 * @apiSince 3
 */

public void fling(int velocityX) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * <p>This version also clamps the scrolling to the bounds of our child.
 * @apiSince 3
 */

public void scrollTo(int x, int y) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void draw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

protected void onRestoreInstanceState(android.os.Parcelable state) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

protected android.os.Parcelable onSaveInstanceState() { throw new RuntimeException("Stub!"); }
}

