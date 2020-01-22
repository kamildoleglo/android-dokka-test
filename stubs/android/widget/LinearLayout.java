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

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Gravity;
import android.view.ViewGroup;

/**
 * A layout that arranges other views either horizontally in a single column
 * or vertically in a single row.
 *
 * <p>The following snippet shows how to include a linear layout in your layout XML file:</p>
 *
 * <pre>&lt;LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
 *   android:layout_width="match_parent"
 *   android:layout_height="match_parent"
 *   android:paddingLeft="16dp"
 *   android:paddingRight="16dp"
 *   android:orientation="horizontal"
 *   android:gravity="center"&gt;
 *
 *   &lt;!-- Include other widget or layout tags here. These are considered
 *           "child views" or "children" of the linear layout --&gt;
 *
 * &lt;/LinearLayout&gt;</pre>
 *
 * <p>Set {@link android.R.styleable#LinearLayout_orientation android:orientation} to specify
 * whether child views are displayed in a row or column.</p>
 *
 * <p>To control how linear layout aligns all the views it contains, set a value for
 * {@link android.R.styleable#LinearLayout_gravity android:gravity}.  For example, the
 * snippet above sets android:gravity to "center".  The value you set affects
 * both horizontal and vertical alignment of all child views within the single row or column.</p>
 *
 * <p>You can set
 * {@link android.R.styleable#LinearLayout_Layout_layout_weight android:layout_weight}
 * on individual child views to specify how linear layout divides remaining space amongst
 * the views it contains. See the
 * <a href="https://developer.android.com/guide/topics/ui/layout/linear.html">Linear Layout</a>
 * guide for an example.</p>
 *
 * <p>See
 * {@link android.widget.LinearLayout.LayoutParams LinearLayout.LayoutParams}
 * to learn about other attributes you can set on a child view to affect its
 * position and size in the containing linear layout.</p>
 *
 * @attr ref android.R.styleable#LinearLayout_baselineAligned
 * @attr ref android.R.styleable#LinearLayout_baselineAlignedChildIndex
 * @attr ref android.R.styleable#LinearLayout_gravity
 * @attr ref android.R.styleable#LinearLayout_measureWithLargestChild
 * @attr ref android.R.styleable#LinearLayout_orientation
 * @attr ref android.R.styleable#LinearLayout_weightSum
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@android.widget.RemoteViews.RemoteView
public class LinearLayout extends android.view.ViewGroup {

/** @apiSince 1 */

public LinearLayout(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * @param attrs This value may be {@code null}.
 * @apiSince 1
 */

public LinearLayout(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * @param attrs This value may be {@code null}.
 * @apiSince 11
 */

public LinearLayout(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public LinearLayout(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Set how dividers should be shown between items in this layout
 *
 * @param showDividers One or more of {@link #SHOW_DIVIDER_BEGINNING},
 *                     {@link #SHOW_DIVIDER_MIDDLE}, or {@link #SHOW_DIVIDER_END}
 *                     to show dividers, or {@link #SHOW_DIVIDER_NONE} to show no dividers.
 
 * Value is either <code>0</code> or a combination of {@link android.widget.LinearLayout#SHOW_DIVIDER_NONE}, {@link android.widget.LinearLayout#SHOW_DIVIDER_BEGINNING}, {@link android.widget.LinearLayout#SHOW_DIVIDER_MIDDLE}, and {@link android.widget.LinearLayout#SHOW_DIVIDER_END}
 * @apiSince 11
 */

public void setShowDividers(int showDividers) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public boolean shouldDelayChildPressedState() { throw new RuntimeException("Stub!"); }

/**
 * @return A flag set indicating how dividers should be shown around items.
 * Value is either <code>0</code> or a combination of {@link android.widget.LinearLayout#SHOW_DIVIDER_NONE}, {@link android.widget.LinearLayout#SHOW_DIVIDER_BEGINNING}, {@link android.widget.LinearLayout#SHOW_DIVIDER_MIDDLE}, and {@link android.widget.LinearLayout#SHOW_DIVIDER_END}
 * @see #setShowDividers(int)
 * @apiSince 11
 */

public int getShowDividers() { throw new RuntimeException("Stub!"); }

/**
 * @return the divider Drawable that will divide each item.
 *
 * @see #setDividerDrawable(Drawable)
 *
 * @attr ref android.R.styleable#LinearLayout_divider
 * @apiSince 16
 */

public android.graphics.drawable.Drawable getDividerDrawable() { throw new RuntimeException("Stub!"); }

/**
 * Set a drawable to be used as a divider between items.
 *
 * @param divider Drawable that will divide each item.
 *
 * @see #setShowDividers(int)
 *
 * @attr ref android.R.styleable#LinearLayout_divider
 * @apiSince 11
 */

public void setDividerDrawable(android.graphics.drawable.Drawable divider) { throw new RuntimeException("Stub!"); }

/**
 * Set padding displayed on both ends of dividers. For a vertical layout, the padding is applied
 * to left and right end of dividers. For a horizontal layout, the padding is applied to top and
 * bottom end of dividers.
 *
 * @param padding Padding value in pixels that will be applied to each end
 *
 * @see #setShowDividers(int)
 * @see #setDividerDrawable(Drawable)
 * @see #getDividerPadding()
 * @apiSince 14
 */

public void setDividerPadding(int padding) { throw new RuntimeException("Stub!"); }

/**
 * Get the padding size used to inset dividers in pixels
 *
 * @see #setShowDividers(int)
 * @see #setDividerDrawable(Drawable)
 * @see #setDividerPadding(int)
 * @apiSince 14
 */

public int getDividerPadding() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onDraw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * <p>Indicates whether widgets contained within this layout are aligned
 * on their baseline or not.</p>
 *
 * @return true when widgets are baseline-aligned, false otherwise
 * @apiSince 1
 */

public boolean isBaselineAligned() { throw new RuntimeException("Stub!"); }

/**
 * <p>Defines whether widgets contained in this layout are
 * baseline-aligned or not.</p>
 *
 * @param baselineAligned true to align widgets on their baseline,
 *         false otherwise
 *
 * @attr ref android.R.styleable#LinearLayout_baselineAligned
 * @apiSince 1
 */

public void setBaselineAligned(boolean baselineAligned) { throw new RuntimeException("Stub!"); }

/**
 * When true, all children with a weight will be considered having
 * the minimum size of the largest child. If false, all children are
 * measured normally.
 *
 * @return True to measure children with a weight using the minimum
 *         size of the largest child, false otherwise.
 *
 * @attr ref android.R.styleable#LinearLayout_measureWithLargestChild
 * @apiSince 11
 */

public boolean isMeasureWithLargestChildEnabled() { throw new RuntimeException("Stub!"); }

/**
 * When set to true, all children with a weight will be considered having
 * the minimum size of the largest child. If false, all children are
 * measured normally.
 *
 * Disabled by default.
 *
 * @param enabled True to measure children with a weight using the
 *        minimum size of the largest child, false otherwise.
 *
 * @attr ref android.R.styleable#LinearLayout_measureWithLargestChild
 * @apiSince 11
 */

public void setMeasureWithLargestChildEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getBaseline() { throw new RuntimeException("Stub!"); }

/**
 * @return The index of the child that will be used if this layout is
 *   part of a larger layout that is baseline aligned, or -1 if none has
 *   been set.
 * @apiSince 1
 */

public int getBaselineAlignedChildIndex() { throw new RuntimeException("Stub!"); }

/**
 * @param i The index of the child that will be used if this layout is
 *          part of a larger layout that is baseline aligned.
 *
 * @attr ref android.R.styleable#LinearLayout_baselineAlignedChildIndex
 * @apiSince 1
 */

public void setBaselineAlignedChildIndex(int i) { throw new RuntimeException("Stub!"); }

/**
 * Returns the desired weights sum.
 *
 * @return A number greater than 0.0f if the weight sum is defined, or
 *         a number lower than or equals to 0.0f if not weight sum is
 *         to be used.
 * @apiSince 1
 */

public float getWeightSum() { throw new RuntimeException("Stub!"); }

/**
 * Defines the desired weights sum. If unspecified the weights sum is computed
 * at layout time by adding the layout_weight of each child.
 *
 * This can be used for instance to give a single child 50% of the total
 * available space by giving it a layout_weight of 0.5 and setting the
 * weightSum to 1.0.
 *
 * @param weightSum a number greater than 0.0f, or a number lower than or equals
 *        to 0.0f if the weight sum should be computed from the children's
 *        layout_weight
 * @apiSince 1
 */

public void setWeightSum(float weightSum) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onLayout(boolean changed, int l, int t, int r, int b) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param layoutDirection Value is {@link android.view.View#LAYOUT_DIRECTION_LTR}, or {@link android.view.View#LAYOUT_DIRECTION_RTL}
 * @apiSince 17
 */

public void onRtlPropertiesChanged(int layoutDirection) { throw new RuntimeException("Stub!"); }

/**
 * Should the layout be a column or a row.
 * @param orientation Pass {@link #HORIZONTAL} or {@link #VERTICAL}. Default
 * value is {@link #HORIZONTAL}.
 *
 * Value is {@link android.widget.LinearLayout#HORIZONTAL}, or {@link android.widget.LinearLayout#VERTICAL}
 * @attr ref android.R.styleable#LinearLayout_orientation
 * @apiSince 1
 */

public void setOrientation(int orientation) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current orientation.
 *
 * @return either {@link #HORIZONTAL} or {@link #VERTICAL}
 
 * Value is {@link android.widget.LinearLayout#HORIZONTAL}, or {@link android.widget.LinearLayout#VERTICAL}
 * @apiSince 1
 */

public int getOrientation() { throw new RuntimeException("Stub!"); }

/**
 * Describes how the child views are positioned. Defaults to GRAVITY_TOP. If
 * this layout has a VERTICAL orientation, this controls where all the child
 * views are placed if there is extra vertical space. If this layout has a
 * HORIZONTAL orientation, this controls the alignment of the children.
 *
 * @param gravity See {@link android.view.Gravity}
 *
 * @attr ref android.R.styleable#LinearLayout_gravity
 * @apiSince 1
 */

public void setGravity(int gravity) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current gravity. See {@link android.view.Gravity}
 *
 * @return the current gravity.
 * @see #setGravity
 * @apiSince 24
 */

public int getGravity() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setHorizontalGravity(int horizontalGravity) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setVerticalGravity(int verticalGravity) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.widget.LinearLayout.LayoutParams generateLayoutParams(android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/**
 * Returns a set of layout parameters with a width of
 * {@link android.view.ViewGroup.LayoutParams#MATCH_PARENT}
 * and a height of {@link android.view.ViewGroup.LayoutParams#WRAP_CONTENT}
 * when the layout's orientation is {@link #VERTICAL}. When the orientation is
 * {@link #HORIZONTAL}, the width is set to {@link android.widget.LinearLayout.LayoutParams#WRAP_CONTENT LayoutParams#WRAP_CONTENT}
 * and the height to {@link android.widget.LinearLayout.LayoutParams#WRAP_CONTENT LayoutParams#WRAP_CONTENT}.
 * @apiSince 1
 */

protected android.widget.LinearLayout.LayoutParams generateDefaultLayoutParams() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected android.widget.LinearLayout.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams lp) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams p) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static final int HORIZONTAL = 0; // 0x0

/**
 * Show a divider at the beginning of the group.
 * @apiSince 11
 */

public static final int SHOW_DIVIDER_BEGINNING = 1; // 0x1

/**
 * Show a divider at the end of the group.
 * @apiSince 11
 */

public static final int SHOW_DIVIDER_END = 4; // 0x4

/**
 * Show dividers between each item in the group.
 * @apiSince 11
 */

public static final int SHOW_DIVIDER_MIDDLE = 2; // 0x2

/**
 * Don't show any dividers.
 * @apiSince 11
 */

public static final int SHOW_DIVIDER_NONE = 0; // 0x0

/** @apiSince 1 */

public static final int VERTICAL = 1; // 0x1
/**
 * Per-child layout information associated with ViewLinearLayout.
 *
 * @attr ref android.R.styleable#LinearLayout_Layout_layout_weight
 * @attr ref android.R.styleable#LinearLayout_Layout_layout_gravity
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class LayoutParams extends android.view.ViewGroup.MarginLayoutParams {

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public LayoutParams(android.content.Context c, android.util.AttributeSet attrs) { super((android.view.ViewGroup.MarginLayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public LayoutParams(int width, int height) { super((android.view.ViewGroup.MarginLayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new set of layout parameters with the specified width, height
 * and weight.
 *
 * @param width the width, either {@link #MATCH_PARENT},
 *        {@link #WRAP_CONTENT} or a fixed size in pixels
 * @param height the height, either {@link #MATCH_PARENT},
 *        {@link #WRAP_CONTENT} or a fixed size in pixels
 * @param weight the weight
 * @apiSince 1
 */

public LayoutParams(int width, int height, float weight) { super((android.view.ViewGroup.MarginLayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public LayoutParams(android.view.ViewGroup.LayoutParams p) { super((android.view.ViewGroup.MarginLayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public LayoutParams(android.view.ViewGroup.MarginLayoutParams source) { super((android.view.ViewGroup.MarginLayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * Copy constructor. Clones the width, height, margin values, weight,
 * and gravity of the source.
 *
 * @param source The layout params to copy from.
 * @apiSince 19
 */

public LayoutParams(android.widget.LinearLayout.LayoutParams source) { super((android.view.ViewGroup.MarginLayoutParams)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String debug(java.lang.String output) { throw new RuntimeException("Stub!"); }

/**
 * Gravity for the view associated with these LayoutParams.
 *
 * @see android.view.Gravity
 * @apiSince 1
 */

@android.view.ViewDebug.ExportedProperty(category="layout", mapping={@android.view.ViewDebug.IntToString(from=0xffffffff, to="NONE"), @android.view.ViewDebug.IntToString(from=android.view.Gravity.NO_GRAVITY, to="NONE"), @android.view.ViewDebug.IntToString(from=android.view.Gravity.TOP, to="TOP"), @android.view.ViewDebug.IntToString(from=android.view.Gravity.BOTTOM, to="BOTTOM"), @android.view.ViewDebug.IntToString(from=android.view.Gravity.LEFT, to="LEFT"), @android.view.ViewDebug.IntToString(from=android.view.Gravity.RIGHT, to="RIGHT"), @android.view.ViewDebug.IntToString(from=android.view.Gravity.START, to="START"), @android.view.ViewDebug.IntToString(from=android.view.Gravity.END, to="END"), @android.view.ViewDebug.IntToString(from=android.view.Gravity.CENTER_VERTICAL, to="CENTER_VERTICAL"), @android.view.ViewDebug.IntToString(from=android.view.Gravity.FILL_VERTICAL, to="FILL_VERTICAL"), @android.view.ViewDebug.IntToString(from=android.view.Gravity.CENTER_HORIZONTAL, to="CENTER_HORIZONTAL"), @android.view.ViewDebug.IntToString(from=android.view.Gravity.FILL_HORIZONTAL, to="FILL_HORIZONTAL"), @android.view.ViewDebug.IntToString(from=android.view.Gravity.CENTER, to="CENTER"), @android.view.ViewDebug.IntToString(from=android.view.Gravity.FILL, to="FILL")}) public int gravity = -1; // 0xffffffff

/**
 * Indicates how much of the extra space in the LinearLayout will be
 * allocated to the view associated with these LayoutParams. Specify
 * 0 if the view should not be stretched. Otherwise the extra pixels
 * will be pro-rated among all views whose weight is greater than 0.
 * @apiSince 1
 */

@android.view.ViewDebug.ExportedProperty(category="layout") public float weight;
}

}

