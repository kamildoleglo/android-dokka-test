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


package android.view.animation;

import android.view.ViewGroup;
import android.content.Context;

/**
 * A layout animation controller is used to animated a grid layout's children.
 *
 * While {@link android.view.animation.LayoutAnimationController LayoutAnimationController} relies only on the index of the child
 * in the view group to compute the animation delay, this class uses both the
 * X and Y coordinates of the child within a grid.
 *
 * In addition, the animation direction can be controlled. The default direction
 * is <code>DIRECTION_LEFT_TO_RIGHT | DIRECTION_TOP_TO_BOTTOM</code>. You can
 * also set the animation priority to columns or rows. The default priority is
 * none.
 *
 * Information used to compute the animation delay of each child are stored
 * in an instance of
 * {@link android.view.animation.GridLayoutAnimationController.AnimationParameters},
 * itself stored in the {@link android.view.ViewGroup.LayoutParams} of the view.
 *
 * @see android.view.animation.LayoutAnimationController
 * @see android.widget.GridView
 *
 * @attr ref android.R.styleable#GridLayoutAnimation_columnDelay
 * @attr ref android.R.styleable#GridLayoutAnimation_rowDelay
 * @attr ref android.R.styleable#GridLayoutAnimation_direction
 * @attr ref android.R.styleable#GridLayoutAnimation_directionPriority
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class GridLayoutAnimationController extends android.view.animation.LayoutAnimationController {

/**
 * Creates a new grid layout animation controller from external resources.
 *
 * @param context the Context the view  group is running in, through which
 *        it can access the resources
 * @param attrs the attributes of the XML tag that is inflating the
 *        layout animation controller
 * @apiSince 1
 */

public GridLayoutAnimationController(android.content.Context context, android.util.AttributeSet attrs) { super((android.view.animation.Animation)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new layout animation controller with a delay of 50%
 * for both rows and columns and the specified animation.
 *
 * @param animation the animation to use on each child of the view group
 * @apiSince 1
 */

public GridLayoutAnimationController(android.view.animation.Animation animation) { super((android.view.animation.Animation)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new layout animation controller with the specified delays
 * and the specified animation.
 *
 * @param animation the animation to use on each child of the view group
 * @param columnDelay the delay by which each column animation must be offset
 * @param rowDelay the delay by which each row animation must be offset
 * @apiSince 1
 */

public GridLayoutAnimationController(android.view.animation.Animation animation, float columnDelay, float rowDelay) { super((android.view.animation.Animation)null); throw new RuntimeException("Stub!"); }

/**
 * Returns the delay by which the children's animation are offset from one
 * column to the other. The delay is expressed as a fraction of the
 * animation duration.
 *
 * @return a fraction of the animation duration
 *
 * @see #setColumnDelay(float)
 * @see #getRowDelay()
 * @see #setRowDelay(float)
 * @apiSince 1
 */

public float getColumnDelay() { throw new RuntimeException("Stub!"); }

/**
 * Sets the delay, as a fraction of the animation duration, by which the
 * children's animations are offset from one column to the other.
 *
 * @param columnDelay a fraction of the animation duration
 *
 * @see #getColumnDelay()
 * @see #getRowDelay()
 * @see #setRowDelay(float)
 * @apiSince 1
 */

public void setColumnDelay(float columnDelay) { throw new RuntimeException("Stub!"); }

/**
 * Returns the delay by which the children's animation are offset from one
 * row to the other. The delay is expressed as a fraction of the
 * animation duration.
 *
 * @return a fraction of the animation duration
 *
 * @see #setRowDelay(float)
 * @see #getColumnDelay()
 * @see #setColumnDelay(float)
 * @apiSince 1
 */

public float getRowDelay() { throw new RuntimeException("Stub!"); }

/**
 * Sets the delay, as a fraction of the animation duration, by which the
 * children's animations are offset from one row to the other.
 *
 * @param rowDelay a fraction of the animation duration
 *
 * @see #getRowDelay()
 * @see #getColumnDelay()
 * @see #setColumnDelay(float)
 * @apiSince 1
 */

public void setRowDelay(float rowDelay) { throw new RuntimeException("Stub!"); }

/**
 * Returns the direction of the animation. {@link #DIRECTION_HORIZONTAL_MASK}
 * and {@link #DIRECTION_VERTICAL_MASK} can be used to retrieve the
 * horizontal and vertical components of the direction.
 *
 * @return the direction of the animation
 *
 * @see #setDirection(int)
 * @see #DIRECTION_BOTTOM_TO_TOP
 * @see #DIRECTION_TOP_TO_BOTTOM
 * @see #DIRECTION_LEFT_TO_RIGHT
 * @see #DIRECTION_RIGHT_TO_LEFT
 * @see #DIRECTION_HORIZONTAL_MASK
 * @see #DIRECTION_VERTICAL_MASK
 * @apiSince 1
 */

public int getDirection() { throw new RuntimeException("Stub!"); }

/**
 * Sets the direction of the animation. The direction is expressed as an
 * integer containing a horizontal and vertical component. For instance,
 * <code>DIRECTION_BOTTOM_TO_TOP | DIRECTION_RIGHT_TO_LEFT</code>.
 *
 * @param direction the direction of the animation
 *
 * @see #getDirection()
 * @see #DIRECTION_BOTTOM_TO_TOP
 * @see #DIRECTION_TOP_TO_BOTTOM
 * @see #DIRECTION_LEFT_TO_RIGHT
 * @see #DIRECTION_RIGHT_TO_LEFT
 * @see #DIRECTION_HORIZONTAL_MASK
 * @see #DIRECTION_VERTICAL_MASK
 * @apiSince 1
 */

public void setDirection(int direction) { throw new RuntimeException("Stub!"); }

/**
 * Returns the direction priority for the animation. The priority can
 * be either {@link #PRIORITY_NONE}, {@link #PRIORITY_COLUMN} or
 * {@link #PRIORITY_ROW}.
 *
 * @return the priority of the animation direction
 *
 * @see #setDirectionPriority(int)
 * @see #PRIORITY_COLUMN
 * @see #PRIORITY_NONE
 * @see #PRIORITY_ROW
 * @apiSince 1
 */

public int getDirectionPriority() { throw new RuntimeException("Stub!"); }

/**
 * Specifies the direction priority of the animation. For instance,
 * {@link #PRIORITY_COLUMN} will give priority to columns: the animation
 * will first play on the column, then on the rows.Z
 *
 * @param directionPriority the direction priority of the animation
 *
 * @see #getDirectionPriority()
 * @see #PRIORITY_COLUMN
 * @see #PRIORITY_NONE
 * @see #PRIORITY_ROW
 * @apiSince 1
 */

public void setDirectionPriority(int directionPriority) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

public boolean willOverlap() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 1
 */

protected long getDelayForView(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Animates the children starting from the bottom of the grid to the top.
 * @apiSince 1
 */

public static final int DIRECTION_BOTTOM_TO_TOP = 2; // 0x2

/**
 * Bitmask used to retrieve the horizontal component of the direction.
 * @apiSince 1
 */

public static final int DIRECTION_HORIZONTAL_MASK = 1; // 0x1

/**
 * Animates the children starting from the left of the grid to the right.
 * @apiSince 1
 */

public static final int DIRECTION_LEFT_TO_RIGHT = 0; // 0x0

/**
 * Animates the children starting from the right of the grid to the left.
 * @apiSince 1
 */

public static final int DIRECTION_RIGHT_TO_LEFT = 1; // 0x1

/**
 * Animates the children starting from the top of the grid to the bottom.
 * @apiSince 1
 */

public static final int DIRECTION_TOP_TO_BOTTOM = 0; // 0x0

/**
 * Bitmask used to retrieve the vertical component of the direction.
 * @apiSince 1
 */

public static final int DIRECTION_VERTICAL_MASK = 2; // 0x2

/**
 * Columns are animated first.
 * @apiSince 1
 */

public static final int PRIORITY_COLUMN = 1; // 0x1

/**
 * Rows and columns are animated at the same time.
 * @apiSince 1
 */

public static final int PRIORITY_NONE = 0; // 0x0

/**
 * Rows are animated first.
 * @apiSince 1
 */

public static final int PRIORITY_ROW = 2; // 0x2
/**
 * The set of parameters that has to be attached to each view contained in
 * the view group animated by the grid layout animation controller. These
 * parameters are used to compute the start time of each individual view's
 * animation.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class AnimationParameters extends android.view.animation.LayoutAnimationController.AnimationParameters {

public AnimationParameters() { throw new RuntimeException("Stub!"); }

/**
 * The view group's column to which the view belongs.
 * @apiSince 1
 */

public int column;

/**
 * The number of columns in the view's enclosing grid layout.
 * @apiSince 1
 */

public int columnsCount;

/**
 * The view group's row to which the view belongs.
 * @apiSince 1
 */

public int row;

/**
 * The number of rows in the view's enclosing grid layout.
 * @apiSince 1
 */

public int rowsCount;
}

}

