/*
 * Copyright (C) 2011 The Android Open Source Project
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
 * A layout that places its children in a rectangular <em>grid</em>.
 * <p>
 * The grid is composed of a set of infinitely thin lines that separate the
 * viewing area into <em>cells</em>. Throughout the API, grid lines are referenced
 * by grid <em>indices</em>. A grid with {@code N} columns
 * has {@code N + 1} grid indices that run from {@code 0}
 * through {@code N} inclusive. Regardless of how GridLayout is
 * configured, grid index {@code 0} is fixed to the leading edge of the
 * container and grid index {@code N} is fixed to its trailing edge
 * (after padding is taken into account).
 *
 * <h4>Row and Column Specs</h4>
 *
 * Children occupy one or more contiguous cells, as defined
 * by their {@link android.widget.GridLayout.LayoutParams#rowSpec GridLayout.LayoutParams#rowSpec} and
 * {@link android.widget.GridLayout.LayoutParams#columnSpec GridLayout.LayoutParams#columnSpec} layout parameters.
 * Each spec defines the set of rows or columns that are to be
 * occupied; and how children should be aligned within the resulting group of cells.
 * Although cells do not normally overlap in a GridLayout, GridLayout does
 * not prevent children being defined to occupy the same cell or group of cells.
 * In this case however, there is no guarantee that children will not themselves
 * overlap after the layout operation completes.
 *
 * <h4>Default Cell Assignment</h4>
 *
 * If a child does not specify the row and column indices of the cell it
 * wishes to occupy, GridLayout assigns cell locations automatically using its:
 * {@link android.widget.GridLayout#setOrientation(int) GridLayout#setOrientation(int)},
 * {@link android.widget.GridLayout#setRowCount(int) GridLayout#setRowCount(int)} and
 * {@link android.widget.GridLayout#setColumnCount(int) GridLayout#setColumnCount(int)} properties.
 *
 * <h4>Space</h4>
 *
 * Space between children may be specified either by using instances of the
 * dedicated {@link android.widget.Space Space} view or by setting the
 *
 * {@link android.view.ViewGroup.MarginLayoutParams#leftMargin ViewGroup.MarginLayoutParams#leftMargin},
 * {@link android.view.ViewGroup.MarginLayoutParams#topMargin ViewGroup.MarginLayoutParams#topMargin},
 * {@link android.view.ViewGroup.MarginLayoutParams#rightMargin ViewGroup.MarginLayoutParams#rightMargin} and
 * {@link android.view.ViewGroup.MarginLayoutParams#bottomMargin ViewGroup.MarginLayoutParams#bottomMargin}
 *
 * layout parameters. When the
 * {@link android.widget.GridLayout#setUseDefaultMargins(boolean) GridLayout#setUseDefaultMargins(boolean)}
 * property is set, default margins around children are automatically
 * allocated based on the prevailing UI style guide for the platform.
 * Each of the margins so defined may be independently overridden by an assignment
 * to the appropriate layout parameter.
 * Default values will generally produce a reasonable spacing between components
 * but values may change between different releases of the platform.
 *
 * <h4>Excess Space Distribution</h4>
 *
 * As of API 21, GridLayout's distribution of excess space accomodates the principle of weight.
 * In the event that no weights are specified, the previous conventions are respected and
 * columns and rows are taken as flexible if their views specify some form of alignment
 * within their groups.
 * <p>
 * The flexibility of a view is therefore influenced by its alignment which is,
 * in turn, typically defined by setting the
 * {@link android.widget.GridLayout.LayoutParams#setGravity(int) LayoutParams#setGravity(int)} property of the child's layout parameters.
 * If either a weight or alignment were defined along a given axis then the component
 * is taken as <em>flexible</em> in that direction. If no weight or alignment was set,
 * the component is instead assumed to be <em>inflexible</em>.
 * <p>
 * Multiple components in the same row or column group are
 * considered to act in <em>parallel</em>. Such a
 * group is flexible only if <em>all</em> of the components
 * within it are flexible. Row and column groups that sit either side of a common boundary
 * are instead considered to act in <em>series</em>. The composite group made of these two
 * elements is flexible if <em>one</em> of its elements is flexible.
 * <p>
 * To make a column stretch, make sure all of the components inside it define a
 * weight or a gravity. To prevent a column from stretching, ensure that one of the components
 * in the column does not define a weight or a gravity.
 * <p>
 * When the principle of flexibility does not provide complete disambiguation,
 * GridLayout's algorithms favour rows and columns that are closer to its <em>right</em>
 * and <em>bottom</em> edges. To be more precise, GridLayout treats each of its layout
 * parameters as a constraint in the a set of variables that define the grid-lines along a
 * given axis. During layout, GridLayout solves the constraints so as to return the unique
 * solution to those constraints for which all variables are less-than-or-equal-to
 * the corresponding value in any other valid solution.
 *
 * <h4>Interpretation of GONE</h4>
 *
 * For layout purposes, GridLayout treats views whose visibility status is
 * {@link android.view.View#GONE View#GONE}, as having zero width and height. This is subtly different from
 * the policy of ignoring views that are marked as GONE outright. If, for example, a gone-marked
 * view was alone in a column, that column would itself collapse to zero width if and only if
 * no gravity was defined on the view. If gravity was defined, then the gone-marked
 * view has no effect on the layout and the container should be laid out as if the view
 * had never been added to it. GONE views are taken to have zero weight during excess space
 * distribution.
 * <p>
 * These statements apply equally to rows as well as columns, and to groups of rows or columns.
 *
 * <p>
 * See {@link android.widget.GridLayout.LayoutParams GridLayout.LayoutParams} for a full description of the
 * layout parameters used by GridLayout.
 *
 * @attr ref android.R.styleable#GridLayout_orientation
 * @attr ref android.R.styleable#GridLayout_rowCount
 * @attr ref android.R.styleable#GridLayout_columnCount
 * @attr ref android.R.styleable#GridLayout_useDefaultMargins
 * @attr ref android.R.styleable#GridLayout_rowOrderPreserved
 * @attr ref android.R.styleable#GridLayout_columnOrderPreserved
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@android.widget.RemoteViews.RemoteView
public class GridLayout extends android.view.ViewGroup {

/** @apiSince 14 */

public GridLayout(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public GridLayout(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public GridLayout(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public GridLayout(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Returns the current orientation.
 *
 * @return either {@link #HORIZONTAL} or {@link #VERTICAL}
 *
 * Value is {@link android.widget.GridLayout#HORIZONTAL}, or {@link android.widget.GridLayout#VERTICAL}
 * @see #setOrientation(int)
 *
 * @attr ref android.R.styleable#GridLayout_orientation
 * @apiSince 14
 */

public int getOrientation() { throw new RuntimeException("Stub!"); }

/**
 *
 * GridLayout uses the orientation property for two purposes:
 * <ul>
 *  <li>
 *      To control the 'direction' in which default row/column indices are generated
 *      when they are not specified in a component's layout parameters.
 *  </li>
 *  <li>
 *      To control which axis should be processed first during the layout operation:
 *      when orientation is {@link #HORIZONTAL} the horizontal axis is laid out first.
 *  </li>
 * </ul>
 *
 * The order in which axes are laid out is important if, for example, the height of
 * one of GridLayout's children is dependent on its width - and its width is, in turn,
 * dependent on the widths of other components.
 * <p>
 * If your layout contains a {@link android.widget.TextView TextView} (or derivative:
 * {@code Button}, {@code EditText}, {@code CheckBox}, etc.) which is
 * in multi-line mode (the default) it is normally best to leave GridLayout's
 * orientation as {@code HORIZONTAL} - because {@code TextView} is capable of
 * deriving its height for a given width, but not the other way around.
 * <p>
 * Other than the effects above, orientation does not affect the actual layout operation of
 * GridLayout, so it's fine to leave GridLayout in {@code HORIZONTAL} mode even if
 * the height of the intended layout greatly exceeds its width.
 * <p>
 * The default value of this property is {@link #HORIZONTAL}.
 *
 * @param orientation either {@link #HORIZONTAL} or {@link #VERTICAL}
 *
 * Value is {@link android.widget.GridLayout#HORIZONTAL}, or {@link android.widget.GridLayout#VERTICAL}
 * @see #getOrientation()
 *
 * @attr ref android.R.styleable#GridLayout_orientation
 @apiSince 14
 */

public void setOrientation(int orientation) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current number of rows. This is either the last value that was set
 * with {@link #setRowCount(int)} or, if no such value was set, the maximum
 * value of each the upper bounds defined in {@link android.widget.GridLayout.LayoutParams#rowSpec LayoutParams#rowSpec}.
 *
 * @return the current number of rows
 *
 * @see #setRowCount(int)
 * @see android.widget.GridLayout.LayoutParams#rowSpec
 *
 * @attr ref android.R.styleable#GridLayout_rowCount
 * @apiSince 14
 */

public int getRowCount() { throw new RuntimeException("Stub!"); }

/**
 * RowCount is used only to generate default row/column indices when
 * they are not specified by a component's layout parameters.
 *
 * @param rowCount the number of rows
 *
 * @see #getRowCount()
 * @see android.widget.GridLayout.LayoutParams#rowSpec
 *
 * @attr ref android.R.styleable#GridLayout_rowCount
 * @apiSince 14
 */

public void setRowCount(int rowCount) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current number of columns. This is either the last value that was set
 * with {@link #setColumnCount(int)} or, if no such value was set, the maximum
 * value of each the upper bounds defined in {@link android.widget.GridLayout.LayoutParams#columnSpec LayoutParams#columnSpec}.
 *
 * @return the current number of columns
 *
 * @see #setColumnCount(int)
 * @see android.widget.GridLayout.LayoutParams#columnSpec
 *
 * @attr ref android.R.styleable#GridLayout_columnCount
 * @apiSince 14
 */

public int getColumnCount() { throw new RuntimeException("Stub!"); }

/**
 * ColumnCount is used only to generate default column/column indices when
 * they are not specified by a component's layout parameters.
 *
 * @param columnCount the number of columns.
 *
 * @see #getColumnCount()
 * @see android.widget.GridLayout.LayoutParams#columnSpec
 *
 * @attr ref android.R.styleable#GridLayout_columnCount
 * @apiSince 14
 */

public void setColumnCount(int columnCount) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether or not this GridLayout will allocate default margins when no
 * corresponding layout parameters are defined.
 *
 * @return {@code true} if default margins should be allocated
 *
 * @see #setUseDefaultMargins(boolean)
 *
 * @attr ref android.R.styleable#GridLayout_useDefaultMargins
 * @apiSince 14
 */

public boolean getUseDefaultMargins() { throw new RuntimeException("Stub!"); }

/**
 * When {@code true}, GridLayout allocates default margins around children
 * based on the child's visual characteristics. Each of the
 * margins so defined may be independently overridden by an assignment
 * to the appropriate layout parameter.
 * <p>
 * When {@code false}, the default value of all margins is zero.
 * <p>
 * When setting to {@code true}, consider setting the value of the
 * {@link #setAlignmentMode(int) alignmentMode}
 * property to {@link #ALIGN_BOUNDS}.
 * <p>
 * The default value of this property is {@code false}.
 *
 * @param useDefaultMargins use {@code true} to make GridLayout allocate default margins
 *
 * @see #getUseDefaultMargins()
 * @see #setAlignmentMode(int)
 *
 * @see android.view.ViewGroup.MarginLayoutParams#leftMargin
 * @see android.view.ViewGroup.MarginLayoutParams#topMargin
 * @see android.view.ViewGroup.MarginLayoutParams#rightMargin
 * @see android.view.ViewGroup.MarginLayoutParams#bottomMargin
 *
 * @attr ref android.R.styleable#GridLayout_useDefaultMargins
 * @apiSince 14
 */

public void setUseDefaultMargins(boolean useDefaultMargins) { throw new RuntimeException("Stub!"); }

/**
 * Returns the alignment mode.
 *
 * @return the alignment mode; either {@link #ALIGN_BOUNDS} or {@link #ALIGN_MARGINS}
 *
 * Value is {@link android.widget.GridLayout#ALIGN_BOUNDS}, or {@link android.widget.GridLayout#ALIGN_MARGINS}
 * @see #ALIGN_BOUNDS
 * @see #ALIGN_MARGINS
 *
 * @see #setAlignmentMode(int)
 *
 * @attr ref android.R.styleable#GridLayout_alignmentMode
 * @apiSince 14
 */

public int getAlignmentMode() { throw new RuntimeException("Stub!"); }

/**
 * Sets the alignment mode to be used for all of the alignments between the
 * children of this container.
 * <p>
 * The default value of this property is {@link #ALIGN_MARGINS}.
 *
 * @param alignmentMode either {@link #ALIGN_BOUNDS} or {@link #ALIGN_MARGINS}
 *
 * Value is {@link android.widget.GridLayout#ALIGN_BOUNDS}, or {@link android.widget.GridLayout#ALIGN_MARGINS}
 * @see #ALIGN_BOUNDS
 * @see #ALIGN_MARGINS
 *
 * @see #getAlignmentMode()
 *
 * @attr ref android.R.styleable#GridLayout_alignmentMode
 * @apiSince 14
 */

public void setAlignmentMode(int alignmentMode) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether or not row boundaries are ordered by their grid indices.
 *
 * @return {@code true} if row boundaries must appear in the order of their indices,
 *         {@code false} otherwise
 *
 * @see #setRowOrderPreserved(boolean)
 *
 * @attr ref android.R.styleable#GridLayout_rowOrderPreserved
 * @apiSince 14
 */

public boolean isRowOrderPreserved() { throw new RuntimeException("Stub!"); }

/**
 * When this property is {@code true}, GridLayout is forced to place the row boundaries
 * so that their associated grid indices are in ascending order in the view.
 * <p>
 * When this property is {@code false} GridLayout is at liberty to place the vertical row
 * boundaries in whatever order best fits the given constraints.
 * <p>
 * The default value of this property is {@code true}.
 
 * @param rowOrderPreserved {@code true} to force GridLayout to respect the order
 *        of row boundaries
 *
 * @see #isRowOrderPreserved()
 *
 * @attr ref android.R.styleable#GridLayout_rowOrderPreserved
 * @apiSince 14
 */

public void setRowOrderPreserved(boolean rowOrderPreserved) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether or not column boundaries are ordered by their grid indices.
 *
 * @return {@code true} if column boundaries must appear in the order of their indices,
 *         {@code false} otherwise
 *
 * @see #setColumnOrderPreserved(boolean)
 *
 * @attr ref android.R.styleable#GridLayout_columnOrderPreserved
 * @apiSince 14
 */

public boolean isColumnOrderPreserved() { throw new RuntimeException("Stub!"); }

/**
 * When this property is {@code true}, GridLayout is forced to place the column boundaries
 * so that their associated grid indices are in ascending order in the view.
 * <p>
 * When this property is {@code false} GridLayout is at liberty to place the horizontal column
 * boundaries in whatever order best fits the given constraints.
 * <p>
 * The default value of this property is {@code true}.
 *
 * @param columnOrderPreserved use {@code true} to force GridLayout to respect the order
 *        of column boundaries.
 *
 * @see #isColumnOrderPreserved()
 *
 * @attr ref android.R.styleable#GridLayout_columnOrderPreserved
 * @apiSince 14
 */

public void setColumnOrderPreserved(boolean columnOrderPreserved) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams p) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

protected android.widget.GridLayout.LayoutParams generateDefaultLayoutParams() { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public android.widget.GridLayout.LayoutParams generateLayoutParams(android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

protected android.widget.GridLayout.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams lp) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void onViewAdded(android.view.View child) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void onViewRemoved(android.view.View child) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

protected void onMeasure(int widthSpec, int heightSpec) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public void requestLayout() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 14
 */

protected void onLayout(boolean changed, int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }

/**
 * Return a Spec, {@code spec}, where:
 * <ul>
 *     <li> {@code spec.span = [start, start + size]} </li>
 *     <li> {@code spec.alignment = alignment} </li>
 *     <li> {@code spec.weight = weight} </li>
 * </ul>
 * <p>
 * To leave the start index undefined, use the value {@link #UNDEFINED}.
 *
 * @param start     the start
 * @param size      the size
 * @param alignment the alignment
 * @param weight    the weight
 * @apiSince 21
 */

public static android.widget.GridLayout.Spec spec(int start, int size, android.widget.GridLayout.Alignment alignment, float weight) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to: {@code spec(start, 1, alignment, weight)}.
 *
 * @param start     the start
 * @param alignment the alignment
 * @param weight    the weight
 * @apiSince 21
 */

public static android.widget.GridLayout.Spec spec(int start, android.widget.GridLayout.Alignment alignment, float weight) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to: {@code spec(start, 1, default_alignment, weight)} -
 * where {@code default_alignment} is specified in
 * {@link android.widget.GridLayout.LayoutParams}.
 *
 * @param start  the start
 * @param size   the size
 * @param weight the weight
 * @apiSince 21
 */

public static android.widget.GridLayout.Spec spec(int start, int size, float weight) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to: {@code spec(start, 1, weight)}.
 *
 * @param start  the start
 * @param weight the weight
 * @apiSince 21
 */

public static android.widget.GridLayout.Spec spec(int start, float weight) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to: {@code spec(start, size, alignment, 0f)}.
 *
 * @param start     the start
 * @param size      the size
 * @param alignment the alignment
 * @apiSince 14
 */

public static android.widget.GridLayout.Spec spec(int start, int size, android.widget.GridLayout.Alignment alignment) { throw new RuntimeException("Stub!"); }

/**
 * Return a Spec, {@code spec}, where:
 * <ul>
 *     <li> {@code spec.span = [start, start + 1]} </li>
 *     <li> {@code spec.alignment = alignment} </li>
 * </ul>
 * <p>
 * To leave the start index undefined, use the value {@link #UNDEFINED}.
 *
 * @param start     the start index
 * @param alignment the alignment
 *
 * @see #spec(int, int, Alignment)
 * @apiSince 14
 */

public static android.widget.GridLayout.Spec spec(int start, android.widget.GridLayout.Alignment alignment) { throw new RuntimeException("Stub!"); }

/**
 * Return a Spec, {@code spec}, where:
 * <ul>
 *     <li> {@code spec.span = [start, start + size]} </li>
 * </ul>
 * <p>
 * To leave the start index undefined, use the value {@link #UNDEFINED}.
 *
 * @param start     the start
 * @param size      the size
 *
 * @see #spec(int, Alignment)
 * @apiSince 14
 */

public static android.widget.GridLayout.Spec spec(int start, int size) { throw new RuntimeException("Stub!"); }

/**
 * Return a Spec, {@code spec}, where:
 * <ul>
 *     <li> {@code spec.span = [start, start + 1]} </li>
 * </ul>
 * <p>
 * To leave the start index undefined, use the value {@link #UNDEFINED}.
 *
 * @param start     the start index
 *
 * @see #spec(int, int)
 * @apiSince 14
 */

public static android.widget.GridLayout.Spec spec(int start) { throw new RuntimeException("Stub!"); }

/**
 * This constant is an {@link #setAlignmentMode(int) alignmentMode}.
 * When the {@code alignmentMode} is set to {@link #ALIGN_BOUNDS}, alignment
 * is made between the edges of each component's raw
 * view boundary: i.e. the area delimited by the component's:
 * {@link android.view.View#getTop() top},
 * {@link android.view.View#getLeft() left},
 * {@link android.view.View#getBottom() bottom} and
 * {@link android.view.View#getRight() right} properties.
 * <p>
 * For example, when {@code GridLayout} is in {@link #ALIGN_BOUNDS} mode,
 * children that belong to a row group that uses {@link #TOP} alignment will
 * all return the same value when their {@link android.view.View#getTop()}
 * method is called.
 *
 * @see #setAlignmentMode(int)
 * @apiSince 14
 */

public static final int ALIGN_BOUNDS = 0; // 0x0

/**
 * This constant is an {@link #setAlignmentMode(int) alignmentMode}.
 * When the {@code alignmentMode} is set to {@link #ALIGN_MARGINS},
 * the bounds of each view are extended outwards, according
 * to their margins, before the edges of the resulting rectangle are aligned.
 * <p>
 * For example, when {@code GridLayout} is in {@link #ALIGN_MARGINS} mode,
 * the quantity {@code top - layoutParams.topMargin} is the same for all children that
 * belong to a row group that uses {@link #TOP} alignment.
 *
 * @see #setAlignmentMode(int)
 * @apiSince 14
 */

public static final int ALIGN_MARGINS = 1; // 0x1

/**
 * Indicates that a view should be aligned with the <em>baselines</em>
 * of the other views in its cell group.
 * This constant may only be used as an alignment in {@link android.widget.GridLayout.LayoutParams#rowSpec LayoutParams#rowSpec}.
 *
 * @see android.view.View#getBaseline()
 * @apiSince 14
 */

public static final android.widget.GridLayout.Alignment BASELINE;
static { BASELINE = null; }

/**
 * Indicates that a view should be aligned with the <em>bottom</em>
 * edges of the other views in its cell group.
 * @apiSince 14
 */

public static final android.widget.GridLayout.Alignment BOTTOM;
static { BOTTOM = null; }

/**
 * Indicates that a view should be <em>centered</em> with the other views in its cell group.
 * This constant may be used in both {@link android.widget.GridLayout.LayoutParams#rowSpec LayoutParams#rowSpec} and {@link android.widget.GridLayout.LayoutParams#columnSpec LayoutParams#columnSpec}.
 * @apiSince 14
 */

public static final android.widget.GridLayout.Alignment CENTER;
static { CENTER = null; }

/**
 * Indicates that a view should be aligned with the <em>end</em>
 * edges of the other views in its cell group.
 * @apiSince 16
 */

public static final android.widget.GridLayout.Alignment END;
static { END = null; }

/**
 * Indicates that a view should expanded to fit the boundaries of its cell group.
 * This constant may be used in both {@link android.widget.GridLayout.LayoutParams#rowSpec LayoutParams#rowSpec} and
 * {@link android.widget.GridLayout.LayoutParams#columnSpec LayoutParams#columnSpec}.
 * @apiSince 14
 */

public static final android.widget.GridLayout.Alignment FILL;
static { FILL = null; }

/**
 * The horizontal orientation.
 * @apiSince 14
 */

public static final int HORIZONTAL = 0; // 0x0

/**
 * Indicates that a view should be aligned with the <em>left</em>
 * edges of the other views in its cell group.
 * @apiSince 14
 */

public static final android.widget.GridLayout.Alignment LEFT;
static { LEFT = null; }

/**
 * Indicates that a view should be aligned with the <em>right</em>
 * edges of the other views in its cell group.
 * @apiSince 14
 */

public static final android.widget.GridLayout.Alignment RIGHT;
static { RIGHT = null; }

/**
 * Indicates that a view should be aligned with the <em>start</em>
 * edges of the other views in its cell group.
 * @apiSince 16
 */

public static final android.widget.GridLayout.Alignment START;
static { START = null; }

/**
 * Indicates that a view should be aligned with the <em>top</em>
 * edges of the other views in its cell group.
 * @apiSince 14
 */

public static final android.widget.GridLayout.Alignment TOP;
static { TOP = null; }

/**
 * The constant used to indicate that a value is undefined.
 * Fields can use this value to indicate that their values
 * have not yet been set. Similarly, methods can return this value
 * to indicate that there is no suitable value that the implementation
 * can return.
 * The value used for the constant (currently {@link java.lang.Integer#MIN_VALUE Integer#MIN_VALUE}) is
 * intended to avoid confusion between valid values whose sign may not be known.
 * @apiSince 14
 */

public static final int UNDEFINED = -2147483648; // 0x80000000

/**
 * The vertical orientation.
 * @apiSince 14
 */

public static final int VERTICAL = 1; // 0x1
/**
 * Alignments specify where a view should be placed within a cell group and
 * what size it should be.
 * <p>
 * The {@link android.widget.GridLayout.LayoutParams LayoutParams} class contains a {@link android.widget.GridLayout.LayoutParams#rowSpec LayoutParams#rowSpec}
 * and a {@link android.widget.GridLayout.LayoutParams#columnSpec LayoutParams#columnSpec} each of which contains an
 * {@code alignment}. Overall placement of the view in the cell
 * group is specified by the two alignments which act along each axis independently.
 * <p>
 *  The GridLayout class defines the most common alignments used in general layout:
 * {@link #TOP}, {@link #LEFT}, {@link #BOTTOM}, {@link #RIGHT}, {@link #START},
 * {@link #END}, {@link #CENTER}, {@link #BASELINE} and {@link #FILL}.
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class Alignment {

Alignment() { throw new RuntimeException("Stub!"); }
}

/**
 * Layout information associated with each of the children of a GridLayout.
 * <p>
 * GridLayout supports both row and column spanning and arbitrary forms of alignment within
 * each cell group. The fundamental parameters associated with each cell group are
 * gathered into their vertical and horizontal components and stored
 * in the {@link #rowSpec} and {@link #columnSpec} layout parameters.
 * {@link android.widget.GridLayout.Spec GridLayout.Spec} are immutable structures
 * and may be shared between the layout parameters of different children.
 * <p>
 * The row and column specs contain the leading and trailing indices along each axis
 * and together specify the four grid indices that delimit the cells of this cell group.
 * <p>
 * The  alignment properties of the row and column specs together specify
 * both aspects of alignment within the cell group. It is also possible to specify a child's
 * alignment within its cell group by using the {@link android.widget.GridLayout.LayoutParams#setGravity(int) GridLayout.LayoutParams#setGravity(int)}
 * method.
 * <p>
 * The weight property is also included in Spec and specifies the proportion of any
 * excess space that is due to the associated view.
 *
 * <h4>WRAP_CONTENT and MATCH_PARENT</h4>
 *
 * Because the default values of the {@link #width} and {@link #height}
 * properties are both {@link #WRAP_CONTENT}, this value never needs to be explicitly
 * declared in the layout parameters of GridLayout's children. In addition,
 * GridLayout does not distinguish the special size value {@link #MATCH_PARENT} from
 * {@link #WRAP_CONTENT}. A component's ability to expand to the size of the parent is
 * instead controlled by the principle of <em>flexibility</em>,
 * as discussed in {@link android.widget.GridLayout GridLayout}.
 *
 * <h4>Summary</h4>
 *
 * You should not need to use either of the special size values:
 * {@code WRAP_CONTENT} or {@code MATCH_PARENT} when configuring the children of
 * a GridLayout.
 *
 * <h4>Default values</h4>
 *
 * <ul>
 *     <li>{@link #width} = {@link #WRAP_CONTENT}</li>
 *     <li>{@link #height} = {@link #WRAP_CONTENT}</li>
 *     <li>{@link #topMargin} = 0 when
 *          {@link android.widget.GridLayout#setUseDefaultMargins(boolean) GridLayout#setUseDefaultMargins(boolean)} is
 *          {@code false}; otherwise {@link #UNDEFINED}, to
 *          indicate that a default value should be computed on demand. </li>
 *     <li>{@link #leftMargin} = 0 when
 *          {@link android.widget.GridLayout#setUseDefaultMargins(boolean) GridLayout#setUseDefaultMargins(boolean)} is
 *          {@code false}; otherwise {@link #UNDEFINED}, to
 *          indicate that a default value should be computed on demand. </li>
 *     <li>{@link #bottomMargin} = 0 when
 *          {@link android.widget.GridLayout#setUseDefaultMargins(boolean) GridLayout#setUseDefaultMargins(boolean)} is
 *          {@code false}; otherwise {@link #UNDEFINED}, to
 *          indicate that a default value should be computed on demand. </li>
 *     <li>{@link #rightMargin} = 0 when
 *          {@link android.widget.GridLayout#setUseDefaultMargins(boolean) GridLayout#setUseDefaultMargins(boolean)} is
 *          {@code false}; otherwise {@link #UNDEFINED}, to
 *          indicate that a default value should be computed on demand. </li>
 *     <li>{@link #rowSpec}<code>.row</code> = {@link #UNDEFINED} </li>
 *     <li>{@link #rowSpec}<code>.rowSpan</code> = 1 </li>
 *     <li>{@link #rowSpec}<code>.alignment</code> = {@link #BASELINE} </li>
 *     <li>{@link #rowSpec}<code>.weight</code> = 0 </li>
 *     <li>{@link #columnSpec}<code>.column</code> = {@link #UNDEFINED} </li>
 *     <li>{@link #columnSpec}<code>.columnSpan</code> = 1 </li>
 *     <li>{@link #columnSpec}<code>.alignment</code> = {@link #START} </li>
 *     <li>{@link #columnSpec}<code>.weight</code> = 0 </li>
 * </ul>
 *
 * See {@link android.widget.GridLayout GridLayout} for a more complete description of the conventions
 * used by GridLayout in the interpretation of the properties of this class.
 *
 * @attr ref android.R.styleable#GridLayout_Layout_layout_row
 * @attr ref android.R.styleable#GridLayout_Layout_layout_rowSpan
 * @attr ref android.R.styleable#GridLayout_Layout_layout_rowWeight
 * @attr ref android.R.styleable#GridLayout_Layout_layout_column
 * @attr ref android.R.styleable#GridLayout_Layout_layout_columnSpan
 * @attr ref android.R.styleable#GridLayout_Layout_layout_columnWeight
 * @attr ref android.R.styleable#GridLayout_Layout_layout_gravity
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class LayoutParams extends android.view.ViewGroup.MarginLayoutParams {

/**
 * Constructs a new LayoutParams instance for this <code>rowSpec</code>
 * and <code>columnSpec</code>. All other fields are initialized with
 * default values as defined in {@link android.widget.GridLayout.LayoutParams LayoutParams}.
 *
 * @param rowSpec    the rowSpec
 * @param columnSpec the columnSpec
 * @apiSince 14
 */

public LayoutParams(android.widget.GridLayout.Spec rowSpec, android.widget.GridLayout.Spec columnSpec) { super((android.view.ViewGroup.MarginLayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * Constructs a new LayoutParams with default values as defined in {@link android.widget.GridLayout.LayoutParams LayoutParams}.
 * @apiSince 14
 */

public LayoutParams() { super((android.view.ViewGroup.MarginLayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 14
 */

public LayoutParams(android.view.ViewGroup.LayoutParams params) { super((android.view.ViewGroup.MarginLayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 14
 */

public LayoutParams(android.view.ViewGroup.MarginLayoutParams params) { super((android.view.ViewGroup.MarginLayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * Copy constructor. Clones the width, height, margin values, row spec,
 * and column spec of the source.
 *
 * @param source The layout params to copy from.
 * @apiSince 14
 */

public LayoutParams(android.widget.GridLayout.LayoutParams source) { super((android.view.ViewGroup.MarginLayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * Values not defined in the attribute set take the default values
 * defined in {@link android.widget.GridLayout.LayoutParams LayoutParams}.
 * @apiSince 14
 */

public LayoutParams(android.content.Context context, android.util.AttributeSet attrs) { super((android.view.ViewGroup.MarginLayoutParams)null); throw new RuntimeException("Stub!"); }

/**
 * Describes how the child views are positioned. Default is {@code LEFT | BASELINE}.
 * See {@link android.view.Gravity Gravity}.
 *
 * @param gravity the new gravity value
 *
 * @attr ref android.R.styleable#GridLayout_Layout_layout_gravity
 * @apiSince 14
 */

public void setGravity(int gravity) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

protected void setBaseAttributes(android.content.res.TypedArray attributes, int widthAttr, int heightAttr) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * The spec that defines the horizontal characteristics of the cell group
 * described by these layout parameters.
 * If an assignment is made to this field after a measurement or layout operation
 * has already taken place, a call to
 * {@link android.view.ViewGroup#setLayoutParams(android.view.ViewGroup.LayoutParams) ViewGroup#setLayoutParams(ViewGroup.LayoutParams)}
 * must be made to notify GridLayout of the change. GridLayout is normally able
 * to detect when code fails to observe this rule, issue a warning and take steps to
 * compensate for the omission. This facility is implemented on a best effort basis
 * and should not be relied upon in production code - so it is best to include the above
 * calls to remove the warnings as soon as it is practical.
 * @apiSince 14
 */

public android.widget.GridLayout.Spec columnSpec;

/**
 * The spec that defines the vertical characteristics of the cell group
 * described by these layout parameters.
 * If an assignment is made to this field after a measurement or layout operation
 * has already taken place, a call to
 * {@link android.view.ViewGroup#setLayoutParams(android.view.ViewGroup.LayoutParams) ViewGroup#setLayoutParams(ViewGroup.LayoutParams)}
 * must be made to notify GridLayout of the change. GridLayout is normally able
 * to detect when code fails to observe this rule, issue a warning and take steps to
 * compensate for the omission. This facility is implemented on a best effort basis
 * and should not be relied upon in production code - so it is best to include the above
 * calls to remove the warnings as soon as it is practical.
 * @apiSince 14
 */

public android.widget.GridLayout.Spec rowSpec;
}

/**
 * A Spec defines the horizontal or vertical characteristics of a group of
 * cells. Each spec. defines the <em>grid indices</em> and <em>alignment</em>
 * along the appropriate axis.
 * <p>
 * The <em>grid indices</em> are the leading and trailing edges of this cell group.
 * See {@link android.widget.GridLayout GridLayout} for a description of the conventions used by GridLayout
 * for grid indices.
 * <p>
 * The <em>alignment</em> property specifies how cells should be aligned in this group.
 * For row groups, this specifies the vertical alignment.
 * For column groups, this specifies the horizontal alignment.
 * <p>
 * Use the following static methods to create specs:
 * <ul>
 *   <li>{@link #spec(int)}</li>
 *   <li>{@link #spec(int,int)}</li>
 *   <li>{@link #spec(int,android.widget.GridLayout.Alignment)}</li>
 *   <li>{@link #spec(int,int,android.widget.GridLayout.Alignment)}</li>
 *   <li>{@link #spec(int,float)}</li>
 *   <li>{@link #spec(int,int,float)}</li>
 *   <li>{@link #spec(int,android.widget.GridLayout.Alignment,float)}</li>
 *   <li>{@link #spec(int,int,android.widget.GridLayout.Alignment,float)}</li>
 * </ul>
 *
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Spec {

private Spec() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the {@code class}, {@code alignment} and {@code span}
 * properties of this Spec and the supplied parameter are pairwise equal,
 * {@code false} otherwise.
 *
 * @param that the object to compare this spec with
 *
 * @return {@code true} if the specified object is equal to this
 *         {@code Spec}; {@code false} otherwise
 * @apiSince 14
 */

public boolean equals(java.lang.Object that) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public int hashCode() { throw new RuntimeException("Stub!"); }
}

}

