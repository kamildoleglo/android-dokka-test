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

import android.view.View;
import android.view.Gravity;
import android.view.ViewGroup;

/**
 * FrameLayout is designed to block out an area on the screen to display
 * a single item. Generally, FrameLayout should be used to hold a single child view, because it can
 * be difficult to organize child views in a way that's scalable to different screen sizes without
 * the children overlapping each other. You can, however, add multiple children to a FrameLayout
 * and control their position within the FrameLayout by assigning gravity to each child, using the
 * <a href="FrameLayout.LayoutParams.html#attr_android:layout_gravity">{@code
 * android:layout_gravity}</a> attribute.
 * <p>Child views are drawn in a stack, with the most recently added child on top.
 * The size of the FrameLayout is the size of its largest child (plus padding), visible
 * or not (if the FrameLayout's parent permits). Views that are {@link android.view.View#GONE} are
 * used for sizing
 * only if {@link #setMeasureAllChildren(boolean) setConsiderGoneChildrenWhenMeasuring()}
 * is set to true.
 *
 * @attr ref android.R.styleable#FrameLayout_measureAllChildren
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@android.widget.RemoteViews.RemoteView
public class FrameLayout extends android.view.ViewGroup {

/**
 * @param context This value must never be {@code null}.
 * @apiSince 1
 */

public FrameLayout(@androidx.annotation.NonNull android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * @param context This value must never be {@code null}.
 
 * @param attrs This value may be {@code null}.
 * @apiSince 1
 */

public FrameLayout(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * @param context This value must never be {@code null}.
 
 * @param attrs This value may be {@code null}.
 * @apiSince 1
 */

public FrameLayout(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * @param context This value must never be {@code null}.
 
 * @param attrs This value may be {@code null}.
 * @apiSince 21
 */

public FrameLayout(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Describes how the foreground is positioned. Defaults to START and TOP.
 *
 * @param foregroundGravity See {@link android.view.Gravity}
 *
 * @see #getForegroundGravity()
 *
 * @attr ref android.R.styleable#View_foregroundGravity
 * @apiSince 1
 */

public void setForegroundGravity(int foregroundGravity) { throw new RuntimeException("Stub!"); }

/**
 * Returns a set of layout parameters with a width of
 * {@link android.view.ViewGroup.LayoutParams#MATCH_PARENT},
 * and a height of {@link android.view.ViewGroup.LayoutParams#MATCH_PARENT}.
 * @apiSince 1
 */

protected android.widget.FrameLayout.LayoutParams generateDefaultLayoutParams() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onLayout(boolean changed, int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether to consider all children, or just those in
 * the VISIBLE or INVISIBLE state, when measuring. Defaults to false.
 *
 * @param measureAll true to consider children marked GONE, false otherwise.
 * Default value is false.
 *
 * @attr ref android.R.styleable#FrameLayout_measureAllChildren
 * @apiSince 1
 */

public void setMeasureAllChildren(boolean measureAll) { throw new RuntimeException("Stub!"); }

/**
 * Determines whether all children, or just those in the VISIBLE or
 * INVISIBLE state, are considered when measuring.
 *
 * @return Whether all children are considered when measuring.
 *
 * @deprecated This method is deprecated in favor of
 * {@link #getMeasureAllChildren() getMeasureAllChildren()}, which was
 * renamed for consistency with
 * {@link #setMeasureAllChildren(boolean) setMeasureAllChildren()}.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public boolean getConsiderGoneChildrenWhenMeasuring() { throw new RuntimeException("Stub!"); }

/**
 * Determines whether all children, or just those in the VISIBLE or
 * INVISIBLE state, are considered when measuring.
 *
 * @return Whether all children are considered when measuring.
 * @apiSince 14
 */

public boolean getMeasureAllChildren() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.widget.FrameLayout.LayoutParams generateLayoutParams(android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public boolean shouldDelayChildPressedState() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams p) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams lp) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }
/**
 * Per-child layout information for layouts that support margins.
 * See {@link android.R.styleable#FrameLayout_Layout FrameLayout Layout Attributes}
 * for a list of all child view attributes that this class supports.
 *
 * @attr ref android.R.styleable#FrameLayout_Layout_layout_gravity
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class LayoutParams extends android.view.ViewGroup.MarginLayoutParams {

/**
 * @param c This value must never be {@code null}.
 
 * @param attrs This value may be {@code null}.
 * @apiSince 1
 */

public LayoutParams(@androidx.annotation.NonNull android.content.Context c, @androidx.annotation.Nullable android.util.AttributeSet attrs) { super((android.view.ViewGroup.MarginLayoutParams)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public LayoutParams(int width, int height) { super((android.view.ViewGroup.MarginLayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new set of layout parameters with the specified width, height
 * and weight.
 *
 * @param width the width, either {@link #MATCH_PARENT},
 *              {@link #WRAP_CONTENT} or a fixed size in pixels
 * @param height the height, either {@link #MATCH_PARENT},
 *               {@link #WRAP_CONTENT} or a fixed size in pixels
 * @param gravity the gravity
 *
 * @see android.view.Gravity
 * @apiSince 1
 */

public LayoutParams(int width, int height, int gravity) { super((android.view.ViewGroup.MarginLayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * @param source This value must never be {@code null}.
 * @apiSince 1
 */

public LayoutParams(@androidx.annotation.NonNull android.view.ViewGroup.LayoutParams source) { super((android.view.ViewGroup.MarginLayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * @param source This value must never be {@code null}.
 * @apiSince 1
 */

public LayoutParams(@androidx.annotation.NonNull android.view.ViewGroup.MarginLayoutParams source) { super((android.view.ViewGroup.MarginLayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * Copy constructor. Clones the width, height, margin values, and
 * gravity of the source.
 *
 * @param source The layout params to copy from.
 
 * This value must never be {@code null}.
 * @apiSince 19
 */

public LayoutParams(@androidx.annotation.NonNull android.widget.FrameLayout.LayoutParams source) { super((android.view.ViewGroup.MarginLayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * Value for {@link #gravity} indicating that a gravity has not been
 * explicitly specified.
 * @apiSince 24
 */

public static final int UNSPECIFIED_GRAVITY = -1; // 0xffffffff

/**
 * The gravity to apply with the View to which these layout parameters
 * are associated.
 * <p>
 * The default value is {@link #UNSPECIFIED_GRAVITY}, which is treated
 * by FrameLayout as {@code Gravity.TOP | Gravity.START}.
 *
 * @see android.view.Gravity
 * @attr ref android.R.styleable#FrameLayout_Layout_layout_gravity
 * @apiSince 1
 */

public int gravity = -1; // 0xffffffff
}

}

