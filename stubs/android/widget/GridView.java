/*
 * Copyright (C) 2007 The Android Open Source Project
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

/**
 * A view that shows items in two-dimensional scrolling grid. The items in the
 * grid come from the {@link android.widget.ListAdapter ListAdapter} associated with this view.
 *
 * <p>See the <a href="{@docRoot}guide/topics/ui/layout/gridview.html">Grid
 * View</a> guide.</p>
 *
 * @attr ref android.R.styleable#GridView_horizontalSpacing
 * @attr ref android.R.styleable#GridView_verticalSpacing
 * @attr ref android.R.styleable#GridView_stretchMode
 * @attr ref android.R.styleable#GridView_columnWidth
 * @attr ref android.R.styleable#GridView_numColumns
 * @attr ref android.R.styleable#GridView_gravity
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@android.widget.RemoteViews.RemoteView
public class GridView extends android.widget.AbsListView {

/** @apiSince 1 */

public GridView(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public GridView(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public GridView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public GridView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.widget.ListAdapter getAdapter() { throw new RuntimeException("Stub!"); }

/**
 * Sets up this AbsListView to use a remote views adapter which connects to a RemoteViewsService
 * through the specified intent.
 * @param intent the intent used to identify the RemoteViewsService for the adapter to connect to.
 * @apiSince 11
 */

public void setRemoteViewsAdapter(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Sets the data behind this GridView.
 *
 * @param adapter the adapter providing the grid's data
 * @apiSince 1
 */

public void setAdapter(android.widget.ListAdapter adapter) { throw new RuntimeException("Stub!"); }

/**
 * Smoothly scroll to the specified adapter position. The view will
 * scroll such that the indicated position is displayed.
 * @param position Scroll to this adapter position.
 * @apiSince 8
 */

public void smoothScrollToPosition(int position) { throw new RuntimeException("Stub!"); }

/**
 * Smoothly scroll to the specified adapter position offset. The view will
 * scroll such that the indicated position is displayed.
 * @param offset The amount to offset from the adapter position to scroll to.
 * @apiSince 11
 */

public void smoothScrollByOffset(int offset) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void attachLayoutAnimationParameters(android.view.View child, android.view.ViewGroup.LayoutParams params, int index, int count) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void layoutChildren() { throw new RuntimeException("Stub!"); }

/**
 * Sets the currently selected item
 *
 * @param position Index (starting at 0) of the data item to be selected.
 *
 * If in touch mode, the item will not be selected but it will still be positioned
 * appropriately.
 * @apiSince 1
 */

public void setSelection(int position) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean onKeyDown(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean onKeyMultiple(int keyCode, int repeatCount, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean onKeyUp(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onFocusChanged(boolean gainFocus, int direction, android.graphics.Rect previouslyFocusedRect) { throw new RuntimeException("Stub!"); }

/**
 * Set the gravity for this grid. Gravity describes how the child views
 * are horizontally aligned. Defaults to Gravity.LEFT
 *
 * @param gravity the gravity to apply to this grid's children
 *
 * @attr ref android.R.styleable#GridView_gravity
 * @apiSince 1
 */

public void setGravity(int gravity) { throw new RuntimeException("Stub!"); }

/**
 * Describes how the child views are horizontally aligned. Defaults to Gravity.LEFT
 *
 * @return the gravity that will be applied to this grid's children
 *
 * @attr ref android.R.styleable#GridView_gravity
 * @apiSince 16
 */

public int getGravity() { throw new RuntimeException("Stub!"); }

/**
 * Set the amount of horizontal (x) spacing to place between each item
 * in the grid.
 *
 * @param horizontalSpacing The amount of horizontal space between items,
 * in pixels.
 *
 * @attr ref android.R.styleable#GridView_horizontalSpacing
 * @apiSince 1
 */

public void setHorizontalSpacing(int horizontalSpacing) { throw new RuntimeException("Stub!"); }

/**
 * Returns the amount of horizontal spacing currently used between each item in the grid.
 *
 * <p>This is only accurate for the current layout. If {@link #setHorizontalSpacing(int)}
 * has been called but layout is not yet complete, this method may return a stale value.
 * To get the horizontal spacing that was explicitly requested use
 * {@link #getRequestedHorizontalSpacing()}.</p>
 *
 * @return Current horizontal spacing between each item in pixels
 *
 * @see #setHorizontalSpacing(int)
 * @see #getRequestedHorizontalSpacing()
 *
 * @attr ref android.R.styleable#GridView_horizontalSpacing
 * @apiSince 16
 */

public int getHorizontalSpacing() { throw new RuntimeException("Stub!"); }

/**
 * Returns the requested amount of horizontal spacing between each item in the grid.
 *
 * <p>The value returned may have been supplied during inflation as part of a style,
 * the default GridView style, or by a call to {@link #setHorizontalSpacing(int)}.
 * If layout is not yet complete or if GridView calculated a different horizontal spacing
 * from what was requested, this may return a different value from
 * {@link #getHorizontalSpacing()}.</p>
 *
 * @return The currently requested horizontal spacing between items, in pixels
 *
 * @see #setHorizontalSpacing(int)
 * @see #getHorizontalSpacing()
 *
 * @attr ref android.R.styleable#GridView_horizontalSpacing
 * @apiSince 16
 */

public int getRequestedHorizontalSpacing() { throw new RuntimeException("Stub!"); }

/**
 * Set the amount of vertical (y) spacing to place between each item
 * in the grid.
 *
 * @param verticalSpacing The amount of vertical space between items,
 * in pixels.
 *
 * @see #getVerticalSpacing()
 *
 * @attr ref android.R.styleable#GridView_verticalSpacing
 * @apiSince 1
 */

public void setVerticalSpacing(int verticalSpacing) { throw new RuntimeException("Stub!"); }

/**
 * Returns the amount of vertical spacing between each item in the grid.
 *
 * @return The vertical spacing between items in pixels
 *
 * @see #setVerticalSpacing(int)
 *
 * @attr ref android.R.styleable#GridView_verticalSpacing
 * @apiSince 16
 */

public int getVerticalSpacing() { throw new RuntimeException("Stub!"); }

/**
 * Control how items are stretched to fill their space.
 *
 * @param stretchMode Either {@link #NO_STRETCH},
 * {@link #STRETCH_SPACING}, {@link #STRETCH_SPACING_UNIFORM}, or {@link #STRETCH_COLUMN_WIDTH}.
 *
 * Value is {@link android.widget.GridView#NO_STRETCH}, {@link android.widget.GridView#STRETCH_SPACING}, {@link android.widget.GridView#STRETCH_COLUMN_WIDTH}, or {@link android.widget.GridView#STRETCH_SPACING_UNIFORM}
 * @attr ref android.R.styleable#GridView_stretchMode
 * @apiSince 1
 */

public void setStretchMode(int stretchMode) { throw new RuntimeException("Stub!"); }

/**
 * @return Value is {@link android.widget.GridView#NO_STRETCH}, {@link android.widget.GridView#STRETCH_SPACING}, {@link android.widget.GridView#STRETCH_COLUMN_WIDTH}, or {@link android.widget.GridView#STRETCH_SPACING_UNIFORM}
 * @apiSince 1
 */

public int getStretchMode() { throw new RuntimeException("Stub!"); }

/**
 * Set the width of columns in the grid.
 *
 * @param columnWidth The column width, in pixels.
 *
 * @attr ref android.R.styleable#GridView_columnWidth
 * @apiSince 1
 */

public void setColumnWidth(int columnWidth) { throw new RuntimeException("Stub!"); }

/**
 * Return the width of a column in the grid.
 *
 * <p>This may not be valid yet if a layout is pending.</p>
 *
 * @return The column width in pixels
 *
 * @see #setColumnWidth(int)
 * @see #getRequestedColumnWidth()
 *
 * @attr ref android.R.styleable#GridView_columnWidth
 * @apiSince 16
 */

public int getColumnWidth() { throw new RuntimeException("Stub!"); }

/**
 * Return the requested width of a column in the grid.
 *
 * <p>This may not be the actual column width used. Use {@link #getColumnWidth()}
 * to retrieve the current real width of a column.</p>
 *
 * @return The requested column width in pixels
 *
 * @see #setColumnWidth(int)
 * @see #getColumnWidth()
 *
 * @attr ref android.R.styleable#GridView_columnWidth
 * @apiSince 16
 */

public int getRequestedColumnWidth() { throw new RuntimeException("Stub!"); }

/**
 * Set the number of columns in the grid
 *
 * @param numColumns The desired number of columns.
 *
 * @attr ref android.R.styleable#GridView_numColumns
 * @apiSince 1
 */

public void setNumColumns(int numColumns) { throw new RuntimeException("Stub!"); }

/**
 * Get the number of columns in the grid.
 * Returns {@link #AUTO_FIT} if the Grid has never been laid out.
 *
 * @attr ref android.R.styleable#GridView_numColumns
 *
 * @see #setNumColumns(int)
 * @apiSince 11
 */

@android.view.ViewDebug.ExportedProperty
public int getNumColumns() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected int computeVerticalScrollExtent() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected int computeVerticalScrollOffset() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected int computeVerticalScrollRange() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public void onInitializeAccessibilityNodeInfoForItem(android.view.View view, int position, android.view.accessibility.AccessibilityNodeInfo info) { throw new RuntimeException("Stub!"); }

/**
 * Creates as many columns as can fit on screen.
 *
 * @see #setNumColumns(int)
 * @apiSince 1
 */

public static final int AUTO_FIT = -1; // 0xffffffff

/**
 * Disables stretching.
 *
 * @see #setStretchMode(int)
 * @apiSince 1
 */

public static final int NO_STRETCH = 0; // 0x0

/**
 * Stretches columns.
 *
 * @see #setStretchMode(int)
 * @apiSince 1
 */

public static final int STRETCH_COLUMN_WIDTH = 2; // 0x2

/**
 * Stretches the spacing between columns.
 *
 * @see #setStretchMode(int)
 * @apiSince 1
 */

public static final int STRETCH_SPACING = 1; // 0x1

/**
 * Stretches the spacing between columns. The spacing is uniform.
 *
 * @see #setStretchMode(int)
 * @apiSince 3
 */

public static final int STRETCH_SPACING_UNIFORM = 3; // 0x3
}

