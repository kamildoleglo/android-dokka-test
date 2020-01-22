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
import android.view.Gravity;

/**
 * A Layout where the positions of the children can be described in relation to each other or to the
 * parent.
 *
 * <p>
 * Note that you cannot have a circular dependency between the size of the RelativeLayout and the
 * position of its children. For example, you cannot have a RelativeLayout whose height is set to
 * {@link android.view.ViewGroup.LayoutParams#WRAP_CONTENT WRAP_CONTENT} and a child set to
 * {@link #ALIGN_PARENT_BOTTOM}.
 * </p>
 *
 * <p><strong>Note:</strong> In platform version 17 and lower, RelativeLayout was affected by
 * a measurement bug that could cause child views to be measured with incorrect
 * {@link android.view.View.MeasureSpec MeasureSpec} values. (See
 * {@link android.view.View.MeasureSpec#makeMeasureSpec(int, int) MeasureSpec.makeMeasureSpec}
 * for more details.) This was triggered when a RelativeLayout container was placed in
 * a scrolling container, such as a ScrollView or HorizontalScrollView. If a custom view
 * not equipped to properly measure with the MeasureSpec mode
 * {@link android.view.View.MeasureSpec#UNSPECIFIED UNSPECIFIED} was placed in a RelativeLayout,
 * this would silently work anyway as RelativeLayout would pass a very large
 * {@link android.view.View.MeasureSpec#AT_MOST AT_MOST} MeasureSpec instead.</p>
 *
 * <p>This behavior has been preserved for apps that set <code>android:targetSdkVersion="17"</code>
 * or older in their manifest's <code>uses-sdk</code> tag for compatibility. Apps targeting SDK
 * version 18 or newer will receive the correct behavior</p>
 *
 * <p>See the <a href="{@docRoot}guide/topics/ui/layout/relative.html">Relative
 * Layout</a> guide.</p>
 *
 * <p>
 * Also see {@link android.widget.RelativeLayout.LayoutParams RelativeLayout.LayoutParams} for
 * layout attributes
 * </p>
 *
 * @attr ref android.R.styleable#RelativeLayout_gravity
 * @attr ref android.R.styleable#RelativeLayout_ignoreGravity
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@android.widget.RemoteViews.RemoteView
public class RelativeLayout extends android.view.ViewGroup {

/** @apiSince 1 */

public RelativeLayout(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public RelativeLayout(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public RelativeLayout(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public RelativeLayout(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public boolean shouldDelayChildPressedState() { throw new RuntimeException("Stub!"); }

/**
 * Defines which View is ignored when the gravity is applied. This setting has no
 * effect if the gravity is <code>Gravity.START | Gravity.TOP</code>.
 *
 * @param viewId The id of the View to be ignored by gravity, or 0 if no View
 *        should be ignored.
 *
 * @see #setGravity(int)
 *
 * @attr ref android.R.styleable#RelativeLayout_ignoreGravity
 * @apiSince 1
 */

public void setIgnoreGravity(int viewId) { throw new RuntimeException("Stub!"); }

/**
 * Get the id of the View to be ignored by gravity
 *
 * @attr ref android.R.styleable#RelativeLayout_ignoreGravity
 * @apiSince 29
 */

public int getIgnoreGravity() { throw new RuntimeException("Stub!"); }

/**
 * Describes how the child views are positioned.
 *
 * @return the gravity.
 *
 * @see #setGravity(int)
 * @see android.view.Gravity
 *
 * @attr ref android.R.styleable#RelativeLayout_gravity
 * @apiSince 16
 */

public int getGravity() { throw new RuntimeException("Stub!"); }

/**
 * Describes how the child views are positioned. Defaults to
 * <code>Gravity.START | Gravity.TOP</code>.
 *
 * <p>Note that since RelativeLayout considers the positioning of each child
 * relative to one another to be significant, setting gravity will affect
 * the positioning of all children as a single unit within the parent.
 * This happens after children have been relatively positioned.</p>
 *
 * @param gravity See {@link android.view.Gravity}
 *
 * @see #setHorizontalGravity(int)
 * @see #setVerticalGravity(int)
 *
 * @attr ref android.R.styleable#RelativeLayout_gravity
 * @apiSince 1
 */

public void setGravity(int gravity) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setHorizontalGravity(int horizontalGravity) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setVerticalGravity(int verticalGravity) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getBaseline() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void requestLayout() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onLayout(boolean changed, int l, int t, int r, int b) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.widget.RelativeLayout.LayoutParams generateLayoutParams(android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/**
 * Returns a set of layout parameters with a width of
 * {@link android.view.ViewGroup.LayoutParams#WRAP_CONTENT},
 * a height of {@link android.view.ViewGroup.LayoutParams#WRAP_CONTENT} and no spanning.
 * @apiSince 1
 */

protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams p) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams lp) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }

/**
 * Rule that aligns a child's bottom edge with another child's top edge.
 * @apiSince 1
 */

public static final int ABOVE = 2; // 0x2

/**
 * Rule that aligns a child's baseline with another child's baseline.
 * @apiSince 1
 */

public static final int ALIGN_BASELINE = 4; // 0x4

/**
 * Rule that aligns a child's bottom edge with another child's bottom edge.
 * @apiSince 1
 */

public static final int ALIGN_BOTTOM = 8; // 0x8

/**
 * Rule that aligns a child's end edge with another child's end edge.
 * @apiSince 17
 */

public static final int ALIGN_END = 19; // 0x13

/**
 * Rule that aligns a child's left edge with another child's left edge.
 * @apiSince 1
 */

public static final int ALIGN_LEFT = 5; // 0x5

/**
 * Rule that aligns the child's bottom edge with its RelativeLayout
 * parent's bottom edge.
 * @apiSince 1
 */

public static final int ALIGN_PARENT_BOTTOM = 12; // 0xc

/**
 * Rule that aligns the child's end edge with its RelativeLayout
 * parent's end edge.
 * @apiSince 17
 */

public static final int ALIGN_PARENT_END = 21; // 0x15

/**
 * Rule that aligns the child's left edge with its RelativeLayout
 * parent's left edge.
 * @apiSince 1
 */

public static final int ALIGN_PARENT_LEFT = 9; // 0x9

/**
 * Rule that aligns the child's right edge with its RelativeLayout
 * parent's right edge.
 * @apiSince 1
 */

public static final int ALIGN_PARENT_RIGHT = 11; // 0xb

/**
 * Rule that aligns the child's start edge with its RelativeLayout
 * parent's start edge.
 * @apiSince 17
 */

public static final int ALIGN_PARENT_START = 20; // 0x14

/**
 * Rule that aligns the child's top edge with its RelativeLayout
 * parent's top edge.
 * @apiSince 1
 */

public static final int ALIGN_PARENT_TOP = 10; // 0xa

/**
 * Rule that aligns a child's right edge with another child's right edge.
 * @apiSince 1
 */

public static final int ALIGN_RIGHT = 7; // 0x7

/**
 * Rule that aligns a child's start edge with another child's start edge.
 * @apiSince 17
 */

public static final int ALIGN_START = 18; // 0x12

/**
 * Rule that aligns a child's top edge with another child's top edge.
 * @apiSince 1
 */

public static final int ALIGN_TOP = 6; // 0x6

/**
 * Rule that aligns a child's top edge with another child's bottom edge.
 * @apiSince 1
 */

public static final int BELOW = 3; // 0x3

/**
 * Rule that centers the child horizontally with respect to the
 * bounds of its RelativeLayout parent.
 * @apiSince 1
 */

public static final int CENTER_HORIZONTAL = 14; // 0xe

/**
 * Rule that centers the child with respect to the bounds of its
 * RelativeLayout parent.
 * @apiSince 1
 */

public static final int CENTER_IN_PARENT = 13; // 0xd

/**
 * Rule that centers the child vertically with respect to the
 * bounds of its RelativeLayout parent.
 * @apiSince 1
 */

public static final int CENTER_VERTICAL = 15; // 0xf

/**
 * Rule that aligns a child's start edge with another child's end edge.
 * @apiSince 17
 */

public static final int END_OF = 17; // 0x11

/**
 * Rule that aligns a child's right edge with another child's left edge.
 * @apiSince 1
 */

public static final int LEFT_OF = 0; // 0x0

/**
 * Rule that aligns a child's left edge with another child's right edge.
 * @apiSince 1
 */

public static final int RIGHT_OF = 1; // 0x1

/**
 * Rule that aligns a child's end edge with another child's start edge.
 * @apiSince 17
 */

public static final int START_OF = 16; // 0x10

/** @apiSince 1 */

public static final int TRUE = -1; // 0xffffffff
/**
 * Specifies how a view is positioned within a {@link android.widget.RelativeLayout RelativeLayout}.
 * The relative layout containing the view uses the value of these layout parameters to
 * determine where to position the view on the screen.  If the view is not contained
 * within a relative layout, these attributes are ignored.
 *
 * See the <a href="{@docRoot}guide/topics/ui/layout/relative.html">Relative
 * Layout</a> guide for example code demonstrating how to use relative layout's
 * layout parameters in a layout XML.
 *
 * To learn more about layout parameters and how they differ from typical view attributes,
 * see the <a href="{@docRoot}guide/topics/ui/declaring-layout.html#attributes">Layouts
 * guide</a>.
 *
 *
 * @attr ref android.R.styleable#RelativeLayout_Layout_layout_alignWithParentIfMissing
 * @attr ref android.R.styleable#RelativeLayout_Layout_layout_toLeftOf
 * @attr ref android.R.styleable#RelativeLayout_Layout_layout_toRightOf
 * @attr ref android.R.styleable#RelativeLayout_Layout_layout_above
 * @attr ref android.R.styleable#RelativeLayout_Layout_layout_below
 * @attr ref android.R.styleable#RelativeLayout_Layout_layout_alignBaseline
 * @attr ref android.R.styleable#RelativeLayout_Layout_layout_alignLeft
 * @attr ref android.R.styleable#RelativeLayout_Layout_layout_alignTop
 * @attr ref android.R.styleable#RelativeLayout_Layout_layout_alignRight
 * @attr ref android.R.styleable#RelativeLayout_Layout_layout_alignBottom
 * @attr ref android.R.styleable#RelativeLayout_Layout_layout_alignParentLeft
 * @attr ref android.R.styleable#RelativeLayout_Layout_layout_alignParentTop
 * @attr ref android.R.styleable#RelativeLayout_Layout_layout_alignParentRight
 * @attr ref android.R.styleable#RelativeLayout_Layout_layout_alignParentBottom
 * @attr ref android.R.styleable#RelativeLayout_Layout_layout_centerInParent
 * @attr ref android.R.styleable#RelativeLayout_Layout_layout_centerHorizontal
 * @attr ref android.R.styleable#RelativeLayout_Layout_layout_centerVertical
 * @attr ref android.R.styleable#RelativeLayout_Layout_layout_toStartOf
 * @attr ref android.R.styleable#RelativeLayout_Layout_layout_toEndOf
 * @attr ref android.R.styleable#RelativeLayout_Layout_layout_alignStart
 * @attr ref android.R.styleable#RelativeLayout_Layout_layout_alignEnd
 * @attr ref android.R.styleable#RelativeLayout_Layout_layout_alignParentStart
 * @attr ref android.R.styleable#RelativeLayout_Layout_layout_alignParentEnd
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class LayoutParams extends android.view.ViewGroup.MarginLayoutParams {

/** @apiSince 1 */

public LayoutParams(android.content.Context c, android.util.AttributeSet attrs) { super((android.view.ViewGroup.MarginLayoutParams)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public LayoutParams(int w, int h) { super((android.view.ViewGroup.MarginLayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public LayoutParams(android.view.ViewGroup.LayoutParams source) { super((android.view.ViewGroup.MarginLayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public LayoutParams(android.view.ViewGroup.MarginLayoutParams source) { super((android.view.ViewGroup.MarginLayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * Copy constructor. Clones the width, height, margin values, and rules
 * of the source.
 *
 * @param source The layout params to copy from.
 * @apiSince 19
 */

public LayoutParams(android.widget.RelativeLayout.LayoutParams source) { super((android.view.ViewGroup.MarginLayoutParams)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String debug(java.lang.String output) { throw new RuntimeException("Stub!"); }

/**
 * Adds a layout rule to be interpreted by the RelativeLayout.
 * <p>
 * This method should only be used for verbs that don't refer to a
 * sibling (ex. {@link #ALIGN_RIGHT}) or take a boolean
 * value ({@link #TRUE} for true or 0 for false). To
 * specify a verb that takes a subject, use {@link #addRule(int,int)}.
 * <p>
 * If the rule is relative to the layout direction (ex.
 * {@link #ALIGN_PARENT_START}), then the layout direction must be
 * resolved using {@link #resolveLayoutDirection(int)} before calling
 * {@link #getRule(int)} an absolute rule (ex.
 * {@link #ALIGN_PARENT_LEFT}.
 *
 * @param verb a layout verb, such as {@link #ALIGN_PARENT_LEFT}
 * @see #addRule(int, int)
 * @see #removeRule(int)
 * @see #getRule(int)
 * @apiSince 1
 */

public void addRule(int verb) { throw new RuntimeException("Stub!"); }

/**
 * Adds a layout rule to be interpreted by the RelativeLayout.
 * <p>
 * Use this for verbs that refer to a sibling (ex.
 * {@link #ALIGN_RIGHT}) or take a boolean value (ex.
 * {@link #CENTER_IN_PARENT}).
 * <p>
 * If the rule is relative to the layout direction (ex.
 * {@link #START_OF}), then the layout direction must be resolved using
 * {@link #resolveLayoutDirection(int)} before calling
 * {@link #getRule(int)} with an absolute rule (ex. {@link #LEFT_OF}.
 *
 * @param verb a layout verb, such as {@link #ALIGN_RIGHT}
 * @param subject the ID of another view to use as an anchor, or a
 *                boolean value (represented as {@link #TRUE} for true
 *                or 0 for false)
 * @see #addRule(int)
 * @see #removeRule(int)
 * @see #getRule(int)
 * @apiSince 1
 */

public void addRule(int verb, int subject) { throw new RuntimeException("Stub!"); }

/**
 * Removes a layout rule to be interpreted by the RelativeLayout.
 * <p>
 * If the rule is relative to the layout direction (ex.
 * {@link #START_OF}, {@link #ALIGN_PARENT_START}, etc.) then the
 * layout direction must be resolved using
 * {@link #resolveLayoutDirection(int)} before before calling
 * {@link #getRule(int)} with an absolute rule (ex. {@link #LEFT_OF}.
 *
 * @param verb One of the verbs defined by
 *        {@link android.widget.RelativeLayout RelativeLayout}, such as
 *         ALIGN_WITH_PARENT_LEFT.
 * @see #addRule(int)
 * @see #addRule(int, int)
 * @see #getRule(int)
 * @apiSince 17
 */

public void removeRule(int verb) { throw new RuntimeException("Stub!"); }

/**
 * Returns the layout rule associated with a specific verb.
 *
 * @param verb one of the verbs defined by {@link android.widget.RelativeLayout RelativeLayout}, such
 *             as ALIGN_WITH_PARENT_LEFT
 * @return the id of another view to use as an anchor, a boolean value
 *         (represented as {@link android.widget.RelativeLayout#TRUE RelativeLayout#TRUE} for true
 *         or 0 for false), or -1 for verbs that don't refer to another
 *         sibling (for example, ALIGN_WITH_PARENT_BOTTOM)
 * @see #addRule(int)
 * @see #addRule(int, int)
 * @apiSince 23
 */

public int getRule(int verb) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves a complete list of all supported rules, where the index is the rule
 * verb, and the element value is the value specified, or "false" if it was never
 * set. There will be no resolution of relative rules done.
 *
 * @return the supported rules
 * @see #addRule(int, int)
 * @apiSince 1
 */

public int[] getRules() { throw new RuntimeException("Stub!"); }

/**
 * This will be called by {@link android.view.View#requestLayout()} to
 * resolve layout parameters that are relative to the layout direction.
 * <p>
 * After this method is called, any rules using layout-relative verbs
 * (ex. {@link #START_OF}) previously added via {@link #addRule(int)}
 * may only be accessed via their resolved absolute verbs (ex.
 * {@link #LEFT_OF}).
 * @apiSince 17
 */

public void resolveLayoutDirection(int layoutDirection) { throw new RuntimeException("Stub!"); }

/**
 * When true, uses the parent as the anchor if the anchor doesn't exist or if
 * the anchor's visibility is GONE.
 * @apiSince 1
 */

@android.view.ViewDebug.ExportedProperty(category="layout") public boolean alignWithParent;
}

}

