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

import android.view.ViewGroup;

/**
 * <p>A layout that arranges its children horizontally. A TableRow should
 * always be used as a child of a {@link android.widget.TableLayout}. If a
 * TableRow's parent is not a TableLayout, the TableRow will behave as
 * an horizontal {@link android.widget.LinearLayout}.</p>
 *
 * <p>The children of a TableRow do not need to specify the
 * <code>layout_width</code> and <code>layout_height</code> attributes in the
 * XML file. TableRow always enforces those values to be respectively
 * {@link android.widget.TableLayout.LayoutParams#MATCH_PARENT} and
 * {@link android.widget.TableLayout.LayoutParams#WRAP_CONTENT}.</p>
 *
 * <p>
 * Also see {@link android.widget.TableRow.LayoutParams TableRow.LayoutParams}
 * for layout attributes </p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TableRow extends android.widget.LinearLayout {

/**
 * <p>Creates a new TableRow for the given context.</p>
 *
 * @param context the application environment
 * @apiSince 1
 */

public TableRow(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * <p>Creates a new TableRow for the given context and with the
 * specified set attributes.</p>
 *
 * @param context the application environment
 * @param attrs a collection of attributes
 * @apiSince 1
 */

public TableRow(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public void setOnHierarchyChangeListener(android.view.ViewGroup.OnHierarchyChangeListener listener) { throw new RuntimeException("Stub!"); }

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

public android.view.View getVirtualChildAt(int i) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public int getVirtualChildCount() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public android.widget.TableRow.LayoutParams generateLayoutParams(android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/**
 * Returns a set of layout parameters with a width of
 * {@link android.view.ViewGroup.LayoutParams#MATCH_PARENT},
 * a height of {@link android.view.ViewGroup.LayoutParams#WRAP_CONTENT} and no spanning.
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
 * <p>Set of layout parameters used in table rows.</p>
 *
 * @see android.widget.TableLayout.LayoutParams
 *
 * @attr ref android.R.styleable#TableRow_Cell_layout_column
 * @attr ref android.R.styleable#TableRow_Cell_layout_span
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
 * <p>Sets the child width and the child height.</p>
 *
 * @param w the desired width
 * @param h the desired height
 * @apiSince 1
 */

public LayoutParams(int w, int h) { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * <p>Sets the child width, height and weight.</p>
 *
 * @param w the desired width
 * @param h the desired height
 * @param initWeight the desired weight
 * @apiSince 1
 */

public LayoutParams(int w, int h, float initWeight) { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * <p>Sets the child width to {@link android.view.ViewGroup.LayoutParams}
 * and the child height to
 * {@link android.view.ViewGroup.LayoutParams#WRAP_CONTENT}.</p>
 * @apiSince 1
 */

public LayoutParams() { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * <p>Puts the view in the specified column.</p>
 *
 * <p>Sets the child width to {@link android.view.ViewGroup.LayoutParams#MATCH_PARENT}
 * and the child height to
 * {@link android.view.ViewGroup.LayoutParams#WRAP_CONTENT}.</p>
 *
 * @param column the column index for the view
 * @apiSince 1
 */

public LayoutParams(int column) { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }

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

/** @apiSince 1 */

protected void setBaseAttributes(android.content.res.TypedArray a, int widthAttr, int heightAttr) { throw new RuntimeException("Stub!"); }

/**
 * <p>The column index of the cell represented by the widget.</p>
 * @apiSince 1
 */

@android.view.ViewDebug.ExportedProperty(category="layout") public int column;

/**
 * <p>The number of columns the widgets spans over.</p>
 * @apiSince 1
 */

@android.view.ViewDebug.ExportedProperty(category="layout") public int span;
}

}

