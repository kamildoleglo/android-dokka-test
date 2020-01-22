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

import android.view.ViewGroup;
import android.view.View;

/**
 * A layout that lets you specify exact locations (x/y coordinates) of its
 * children. Absolute layouts are less flexible and harder to maintain than
 * other types of layouts without absolute positioning.
 *
 * <p><strong>XML attributes</strong></p> <p> See {@link
 * android.R.styleable#ViewGroup ViewGroup Attributes}, {@link
 * android.R.styleable#View View Attributes}</p>
 *
 * @deprecated Use {@link android.widget.FrameLayout}, {@link android.widget.RelativeLayout}
 *             or a custom layout instead.
 * @apiSince 1
 * @deprecatedSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
@android.widget.RemoteViews.RemoteView
public class AbsoluteLayout extends android.view.ViewGroup {

/** @apiSince 1 */

@Deprecated
public AbsoluteLayout(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@Deprecated
public AbsoluteLayout(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@Deprecated
public AbsoluteLayout(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

@Deprecated
public AbsoluteLayout(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 3
 */

@Deprecated
protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { throw new RuntimeException("Stub!"); }

/**
 * Returns a set of layout parameters with a width of
 * {@link android.view.ViewGroup.LayoutParams#WRAP_CONTENT},
 * a height of {@link android.view.ViewGroup.LayoutParams#WRAP_CONTENT}
 * and with the coordinates (0, 0).
 * @apiSince 1
 * @deprecatedSince 3
 */

@Deprecated
protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 3
 */

@Deprecated
protected void onLayout(boolean changed, int l, int t, int r, int b) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 3
 */

@Deprecated
public android.view.ViewGroup.LayoutParams generateLayoutParams(android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 3
 */

@Deprecated
protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams p) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 3
 */

@Deprecated
protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams p) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 14
 * @deprecatedSince 3
 */

@Deprecated
public boolean shouldDelayChildPressedState() { throw new RuntimeException("Stub!"); }
/**
 * Per-child layout information associated with AbsoluteLayout.
 * See
 * {@link android.R.styleable#AbsoluteLayout_Layout Absolute Layout Attributes}
 * for a list of all child view attributes that this class supports.
 * @apiSince 1
 * @deprecatedSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static class LayoutParams extends android.view.ViewGroup.LayoutParams {

/**
 * Creates a new set of layout parameters with the specified width,
 * height and location.
 *
 * @param width the width, either {@link #MATCH_PARENT},
         {@link #WRAP_CONTENT} or a fixed size in pixels
 * @param height the height, either {@link #MATCH_PARENT},
         {@link #WRAP_CONTENT} or a fixed size in pixels
 * @param x the X location of the child
 * @param y the Y location of the child
 * @apiSince 1
 */

@Deprecated
public LayoutParams(int width, int height, int x, int y) { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new set of layout parameters. The values are extracted from
 * the supplied attributes set and context. The XML attributes mapped
 * to this set of layout parameters are:
 *
 * <ul>
 *   <li><code>layout_x</code>: the X location of the child</li>
 *   <li><code>layout_y</code>: the Y location of the child</li>
 *   <li>All the XML attributes from
 *   {@link android.view.ViewGroup.LayoutParams}</li>
 * </ul>
 *
 * @param c the application environment
 * @param attrs the set of attributes from which to extract the layout
 *              parameters values
 * @apiSince 1
 */

@Deprecated
public LayoutParams(android.content.Context c, android.util.AttributeSet attrs) { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

@Deprecated
public LayoutParams(android.view.ViewGroup.LayoutParams source) { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
public java.lang.String debug(java.lang.String output) { throw new RuntimeException("Stub!"); }

/**
 * The horizontal, or X, location of the child within the view group.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public int x;

/**
 * The vertical, or Y, location of the child within the view group.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated public int y;
}

}

