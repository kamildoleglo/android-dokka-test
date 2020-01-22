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
import android.view.ViewGroup;

/**
 * <p>A layout that arranges its children into rows and columns.
 * A TableLayout consists of a number of {@link android.widget.TableRow} objects,
 * each defining a row (actually, you can have other children, which will be
 * explained below). TableLayout containers do not display border lines for
 * their rows, columns, or cells. Each row has zero or more cells; each cell can
 * hold one {@link android.view.View View} object. The table has as many columns
 * as the row with the most cells. A table can leave cells empty. Cells can span
 * columns, as they can in HTML.</p>
 *
 * <p>The width of a column is defined by the row with the widest cell in that
 * column. However, a TableLayout can specify certain columns as shrinkable or
 * stretchable by calling
 * {@link #setColumnShrinkable(int,boolean) setColumnShrinkable()}
 * or {@link #setColumnStretchable(int,boolean) setColumnStretchable()}. If
 * marked as shrinkable, the column width can be shrunk to fit the table into
 * its parent object. If marked as stretchable, it can expand in width to fit
 * any extra space. The total width of the table is defined by its parent
 * container. It is important to remember that a column can be both shrinkable
 * and stretchable. In such a situation, the column will change its size to
 * always use up the available space, but never more. Finally, you can hide a
 * column by calling
 * {@link #setColumnCollapsed(int,boolean) setColumnCollapsed()}.</p>
 *
 * <p>The children of a TableLayout cannot specify the <code>layout_width</code>
 * attribute. Width is always <code>MATCH_PARENT</code>. However, the
 * <code>layout_height</code> attribute can be defined by a child; default value
 * is {@link android.widget.TableLayout.LayoutParams#WRAP_CONTENT}. If the child
 * is a {@link android.widget.TableRow}, then the height is always
 * {@link android.widget.TableLayout.LayoutParams#WRAP_CONTENT}.</p>
 *
 * <p> Cells must be added to a row in increasing column order, both in code and
 * XML. Column numbers are zero-based. If you don't specify a column number for
 * a child cell, it will autoincrement to the next available column. If you skip
 * a column number, it will be considered an empty cell in that row. See the
 * TableLayout examples in ApiDemos for examples of creating tables in XML.</p>
 *
 * <p>Although the typical child of a TableLayout is a TableRow, you can
 * actually use any View subclass as a direct child of TableLayout. The View
 * will be displayed as a single row that spans all the table columns.</p>
 *
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TableLayout extends android.widget.LinearLayout {

/**
 * <p>Creates a new TableLayout for the given context.</p>
 *
 * @param context the application environment
 * @apiSince 1
 */

public TableLayout(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * <p>Creates a new TableLayout for the given context and with the
 * specified set attributes.</p>
 *
 * @param context the application environment
 * @param attrs a collection of attributes
 * @apiSince 1
 */

public TableLayout(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public void setOnHierarchyChangeListener(android.view.ViewGroup.OnHierarchyChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public void requestLayout() { throw new RuntimeException("Stub!"); }

/**
 * <p>Indicates whether all columns are shrinkable or not.</p>
 *
 * @return true if all columns are shrinkable, false otherwise
 *
 * @attr ref android.R.styleable#TableLayout_shrinkColumns
 * @apiSince 1
 */

public boolean isShrinkAllColumns() { throw new RuntimeException("Stub!"); }

/**
 * <p>Convenience method to mark all columns as shrinkable.</p>
 *
 * @param shrinkAllColumns true to mark all columns shrinkable
 *
 * @attr ref android.R.styleable#TableLayout_shrinkColumns
 * @apiSince 1
 */

public void setShrinkAllColumns(boolean shrinkAllColumns) { throw new RuntimeException("Stub!"); }

/**
 * <p>Indicates whether all columns are stretchable or not.</p>
 *
 * @return true if all columns are stretchable, false otherwise
 *
 * @attr ref android.R.styleable#TableLayout_stretchColumns
 * @apiSince 1
 */

public boolean isStretchAllColumns() { throw new RuntimeException("Stub!"); }

/**
 * <p>Convenience method to mark all columns as stretchable.</p>
 *
 * @param stretchAllColumns true to mark all columns stretchable
 *
 * @attr ref android.R.styleable#TableLayout_stretchColumns
 * @apiSince 1
 */

public void setStretchAllColumns(boolean stretchAllColumns) { throw new RuntimeException("Stub!"); }

/**
 * <p>Collapses or restores a given column. When collapsed, a column
 * does not appear on screen and the extra space is reclaimed by the
 * other columns. A column is collapsed/restored only when it belongs to
 * a {@link android.widget.TableRow}.</p>
 *
 * <p>Calling this method requests a layout operation.</p>
 *
 * @param columnIndex the index of the column
 * @param isCollapsed true if the column must be collapsed, false otherwise
 *
 * @attr ref android.R.styleable#TableLayout_collapseColumns
 * @apiSince 1
 */

public void setColumnCollapsed(int columnIndex, boolean isCollapsed) { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the collapsed state of the specified column.</p>
 *
 * @param columnIndex the index of the column
 * @return true if the column is collapsed, false otherwise
 * @apiSince 1
 */

public boolean isColumnCollapsed(int columnIndex) { throw new RuntimeException("Stub!"); }

/**
 * <p>Makes the given column stretchable or not. When stretchable, a column
 * takes up as much as available space as possible in its row.</p>
 *
 * <p>Calling this method requests a layout operation.</p>
 *
 * @param columnIndex the index of the column
 * @param isStretchable true if the column must be stretchable,
 *                      false otherwise. Default is false.
 *
 * @attr ref android.R.styleable#TableLayout_stretchColumns
 * @apiSince 1
 */

public void setColumnStretchable(int columnIndex, boolean isStretchable) { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns whether the specified column is stretchable or not.</p>
 *
 * @param columnIndex the index of the column
 * @return true if the column is stretchable, false otherwise
 * @apiSince 1
 */

public boolean isColumnStretchable(int columnIndex) { throw new RuntimeException("Stub!"); }

/**
 * <p>Makes the given column shrinkable or not. When a row is too wide, the
 * table can reclaim extra space from shrinkable columns.</p>
 *
 * <p>Calling this method requests a layout operation.</p>
 *
 * @param columnIndex the index of the column
 * @param isShrinkable true if the column must be shrinkable,
 *                     false otherwise. Default is false.
 *
 * @attr ref android.R.styleable#TableLayout_shrinkColumns
 * @apiSince 1
 */

public void setColumnShrinkable(int columnIndex, boolean isShrinkable) { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns whether the specified column is shrinkable or not.</p>
 *
 * @param columnIndex the index of the column
 * @return true if the column is shrinkable, false otherwise. Default is false.
 * @apiSince 1
 */

public boolean isColumnShrinkable(int columnIndex) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public void addView(android.view.View child) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public void addView(android.view.View child, int index) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public void addView(android.view.View child, android.view.ViewGroup.LayoutParams params) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public void addView(android.view.View child, int index, android.view.ViewGroup.LayoutParams params) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

protected void onLayout(boolean changed, int l, int t, int r, int b) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public android.widget.TableLayout.LayoutParams generateLayoutParams(android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/**
 * Returns a set of layout parameters with a width of
 * {@link android.view.ViewGroup.LayoutParams#MATCH_PARENT},
 * and a height of {@link android.view.ViewGroup.LayoutParams#WRAP_CONTENT}.
 * @apiSince 1
 */

protected android.widget.LinearLayout.LayoutParams generateDefaultLayoutParams() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams p) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

protected android.widget.LinearLayout.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams p) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }
/**
 * <p>This set of layout parameters enforces the width of each child to be
 * {@link #MATCH_PARENT} and the height of each child to be
 * {@link #WRAP_CONTENT}, but only if the height is not specified.</p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class LayoutParams extends android.widget.LinearLayout.LayoutParams {

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public LayoutParams(android.content.Context c, android.util.AttributeSet attrs) { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public LayoutParams(int w, int h) { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public LayoutParams(int w, int h, float initWeight) { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * <p>Sets the child width to
 * {@link android.view.ViewGroup.LayoutParams} and the child height to
 * {@link android.view.ViewGroup.LayoutParams#WRAP_CONTENT}.</p>
 * @apiSince 1
 */

public LayoutParams() { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public LayoutParams(android.view.ViewGroup.LayoutParams p) { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public LayoutParams(android.view.ViewGroup.MarginLayoutParams source) { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * <p>Fixes the row's width to
 * {@link android.view.ViewGroup.LayoutParams#MATCH_PARENT}; the row's
 * height is fixed to
 * {@link android.view.ViewGroup.LayoutParams#WRAP_CONTENT} if no layout
 * height is specified.</p>
 *
 * @param a the styled attributes set
 * @param widthAttr the width attribute to fetch
 * @param heightAttr the height attribute to fetch
 * @apiSince 1
 */

protected void setBaseAttributes(android.content.res.TypedArray a, int widthAttr, int heightAttr) { throw new RuntimeException("Stub!"); }
}

}

