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


package android.view;

import android.graphics.Rect;

/**
 * Standard constants and tools for placing an object within a potentially
 * larger container.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Gravity {

public Gravity() { throw new RuntimeException("Stub!"); }

/**
 * Apply a gravity constant to an object. This supposes that the layout direction is LTR.
 *
 * @param gravity The desired placement of the object, as defined by the
 *                constants in this class.
 * @param w The horizontal size of the object.
 * @param h The vertical size of the object.
 * @param container The frame of the containing space, in which the object
 *                  will be placed.  Should be large enough to contain the
 *                  width and height of the object.
 * @param outRect Receives the computed frame of the object in its
 *                container.
 * @apiSince 1
 */

public static void apply(int gravity, int w, int h, android.graphics.Rect container, android.graphics.Rect outRect) { throw new RuntimeException("Stub!"); }

/**
 * Apply a gravity constant to an object and take care if layout direction is RTL or not.
 *
 * @param gravity The desired placement of the object, as defined by the
 *                constants in this class.
 * @param w The horizontal size of the object.
 * @param h The vertical size of the object.
 * @param container The frame of the containing space, in which the object
 *                  will be placed.  Should be large enough to contain the
 *                  width and height of the object.
 * @param outRect Receives the computed frame of the object in its
 *                container.
 * @param layoutDirection The layout direction.
 *
 * @see android.view.View#LAYOUT_DIRECTION_LTR
 * @see android.view.View#LAYOUT_DIRECTION_RTL
 * @apiSince 17
 */

public static void apply(int gravity, int w, int h, android.graphics.Rect container, android.graphics.Rect outRect, int layoutDirection) { throw new RuntimeException("Stub!"); }

/**
 * Apply a gravity constant to an object.
 *
 * @param gravity The desired placement of the object, as defined by the
 *                constants in this class.
 * @param w The horizontal size of the object.
 * @param h The vertical size of the object.
 * @param container The frame of the containing space, in which the object
 *                  will be placed.  Should be large enough to contain the
 *                  width and height of the object.
 * @param xAdj Offset to apply to the X axis.  If gravity is LEFT this
 *             pushes it to the right; if gravity is RIGHT it pushes it to
 *             the left; if gravity is CENTER_HORIZONTAL it pushes it to the
 *             right or left; otherwise it is ignored.
 * @param yAdj Offset to apply to the Y axis.  If gravity is TOP this pushes
 *             it down; if gravity is BOTTOM it pushes it up; if gravity is
 *             CENTER_VERTICAL it pushes it down or up; otherwise it is
 *             ignored.
 * @param outRect Receives the computed frame of the object in its
 *                container.
 * @apiSince 1
 */

public static void apply(int gravity, int w, int h, android.graphics.Rect container, int xAdj, int yAdj, android.graphics.Rect outRect) { throw new RuntimeException("Stub!"); }

/**
 * Apply a gravity constant to an object.
 *
 * @param gravity The desired placement of the object, as defined by the
 *                constants in this class.
 * @param w The horizontal size of the object.
 * @param h The vertical size of the object.
 * @param container The frame of the containing space, in which the object
 *                  will be placed.  Should be large enough to contain the
 *                  width and height of the object.
 * @param xAdj Offset to apply to the X axis.  If gravity is LEFT this
 *             pushes it to the right; if gravity is RIGHT it pushes it to
 *             the left; if gravity is CENTER_HORIZONTAL it pushes it to the
 *             right or left; otherwise it is ignored.
 * @param yAdj Offset to apply to the Y axis.  If gravity is TOP this pushes
 *             it down; if gravity is BOTTOM it pushes it up; if gravity is
 *             CENTER_VERTICAL it pushes it down or up; otherwise it is
 *             ignored.
 * @param outRect Receives the computed frame of the object in its
 *                container.
 * @param layoutDirection The layout direction.
 *
 * @see android.view.View#LAYOUT_DIRECTION_LTR
 * @see android.view.View#LAYOUT_DIRECTION_RTL
 * @apiSince 17
 */

public static void apply(int gravity, int w, int h, android.graphics.Rect container, int xAdj, int yAdj, android.graphics.Rect outRect, int layoutDirection) { throw new RuntimeException("Stub!"); }

/**
 * Apply additional gravity behavior based on the overall "display" that an
 * object exists in.  This can be used after
 * {@link #apply(int,int,int,android.graphics.Rect,int,int,android.graphics.Rect)} to place the object
 * within a visible display.  By default this moves or clips the object
 * to be visible in the display; the gravity flags
 * {@link #DISPLAY_CLIP_HORIZONTAL} and {@link #DISPLAY_CLIP_VERTICAL}
 * can be used to change this behavior.
 *
 * @param gravity Gravity constants to modify the placement within the
 * display.
 * @param display The rectangle of the display in which the object is
 * being placed.
 * @param inoutObj Supplies the current object position; returns with it
 * modified if needed to fit in the display.
 * @apiSince 3
 */

public static void applyDisplay(int gravity, android.graphics.Rect display, android.graphics.Rect inoutObj) { throw new RuntimeException("Stub!"); }

/**
 * Apply additional gravity behavior based on the overall "display" that an
 * object exists in.  This can be used after
 * {@link #apply(int,int,int,android.graphics.Rect,int,int,android.graphics.Rect)} to place the object
 * within a visible display.  By default this moves or clips the object
 * to be visible in the display; the gravity flags
 * {@link #DISPLAY_CLIP_HORIZONTAL} and {@link #DISPLAY_CLIP_VERTICAL}
 * can be used to change this behavior.
 *
 * @param gravity Gravity constants to modify the placement within the
 * display.
 * @param display The rectangle of the display in which the object is
 * being placed.
 * @param inoutObj Supplies the current object position; returns with it
 * modified if needed to fit in the display.
 * @param layoutDirection The layout direction.
 *
 * @see android.view.View#LAYOUT_DIRECTION_LTR
 * @see android.view.View#LAYOUT_DIRECTION_RTL
 * @apiSince 17
 */

public static void applyDisplay(int gravity, android.graphics.Rect display, android.graphics.Rect inoutObj, int layoutDirection) { throw new RuntimeException("Stub!"); }

/**
 * <p>Indicate whether the supplied gravity has a vertical pull.</p>
 *
 * @param gravity the gravity to check for vertical pull
 * @return true if the supplied gravity has a vertical pull
 * @apiSince 1
 */

public static boolean isVertical(int gravity) { throw new RuntimeException("Stub!"); }

/**
 * <p>Indicate whether the supplied gravity has an horizontal pull.</p>
 *
 * @param gravity the gravity to check for horizontal pull
 * @return true if the supplied gravity has an horizontal pull
 * @apiSince 1
 */

public static boolean isHorizontal(int gravity) { throw new RuntimeException("Stub!"); }

/**
 * <p>Convert script specific gravity to absolute horizontal value.</p>
 *
 * if horizontal direction is LTR, then START will set LEFT and END will set RIGHT.
 * if horizontal direction is RTL, then START will set RIGHT and END will set LEFT.
 *
 *
 * @param gravity The gravity to convert to absolute (horizontal) values.
 * @param layoutDirection The layout direction.
 * @return gravity converted to absolute (horizontal) values.
 * @apiSince 14
 */

public static int getAbsoluteGravity(int gravity, int layoutDirection) { throw new RuntimeException("Stub!"); }

/** Raw bit controlling whether the right/bottom edge is clipped to its
 * container, based on the gravity direction being applied.     * @apiSince 3
 */

public static final int AXIS_CLIP = 8; // 0x8

/**
 * Raw bit controlling how the right/bottom edge is placed.
 * @apiSince 1
 */

public static final int AXIS_PULL_AFTER = 4; // 0x4

/**
 * Raw bit controlling how the left/top edge is placed.
 * @apiSince 1
 */

public static final int AXIS_PULL_BEFORE = 2; // 0x2

/**
 * Raw bit indicating the gravity for an axis has been specified.
 * @apiSince 1
 */

public static final int AXIS_SPECIFIED = 1; // 0x1

/**
 * Bits defining the horizontal axis.
 * @apiSince 1
 */

public static final int AXIS_X_SHIFT = 0; // 0x0

/**
 * Bits defining the vertical axis.
 * @apiSince 1
 */

public static final int AXIS_Y_SHIFT = 4; // 0x4

/**
 * Push object to the bottom of its container, not changing its size.
 * @apiSince 1
 */

public static final int BOTTOM = 80; // 0x50

/** Place the object in the center of its container in both the vertical
 *  and horizontal axis, not changing its size.     * @apiSince 1
 */

public static final int CENTER = 17; // 0x11

/** Place object in the horizontal center of its container, not changing its
 *  size.     * @apiSince 1
 */

public static final int CENTER_HORIZONTAL = 1; // 0x1

/** Place object in the vertical center of its container, not changing its
 *  size.     * @apiSince 1
 */

public static final int CENTER_VERTICAL = 16; // 0x10

/** Flag to clip the edges of the object to its container along the
 *  horizontal axis.     * @apiSince 3
 */

public static final int CLIP_HORIZONTAL = 8; // 0x8

/** Flag to clip the edges of the object to its container along the
 *  vertical axis.     * @apiSince 3
 */

public static final int CLIP_VERTICAL = 128; // 0x80

/** Special constant to enable clipping to an overall display along the
 *  horizontal dimension.  This is not applied by default by
 *  {@link #apply(int,int,int,android.graphics.Rect,int,int,android.graphics.Rect)}; you must do so
 *  yourself by calling {@link #applyDisplay}.
 * @apiSince 3
 */

public static final int DISPLAY_CLIP_HORIZONTAL = 16777216; // 0x1000000

/** Special constant to enable clipping to an overall display along the
 *  vertical dimension.  This is not applied by default by
 *  {@link #apply(int,int,int,android.graphics.Rect,int,int,android.graphics.Rect)}; you must do so
 *  yourself by calling {@link #applyDisplay}.
 * @apiSince 3
 */

public static final int DISPLAY_CLIP_VERTICAL = 268435456; // 0x10000000

/**
 * Push object to x-axis position at the end of its container, not changing its size.
 * @apiSince 14
 */

public static final int END = 8388613; // 0x800005

/** Grow the horizontal and vertical size of the object if needed so it
 *  completely fills its container.     * @apiSince 1
 */

public static final int FILL = 119; // 0x77

/** Grow the horizontal size of the object if needed so it completely fills
 *  its container.     * @apiSince 1
 */

public static final int FILL_HORIZONTAL = 7; // 0x7

/** Grow the vertical size of the object if needed so it completely fills
 *  its container.     * @apiSince 1
 */

public static final int FILL_VERTICAL = 112; // 0x70

/**
 * Binary mask to get the absolute horizontal gravity of a gravity.
 * @apiSince 1
 */

public static final int HORIZONTAL_GRAVITY_MASK = 7; // 0x7

/**
 * Push object to the left of its container, not changing its size.
 * @apiSince 1
 */

public static final int LEFT = 3; // 0x3

/**
 * Constant indicating that no gravity has been set *
 * @apiSince 1
 */

public static final int NO_GRAVITY = 0; // 0x0

/**
 * Binary mask for the horizontal gravity and script specific direction bit.
 * @apiSince 14
 */

public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = 8388615; // 0x800007

/** Raw bit controlling whether the layout direction is relative or not (START/END instead of
 * absolute LEFT/RIGHT).
 * @apiSince 14
 */

public static final int RELATIVE_LAYOUT_DIRECTION = 8388608; // 0x800000

/**
 * Push object to the right of its container, not changing its size.
 * @apiSince 1
 */

public static final int RIGHT = 5; // 0x5

/**
 * Push object to x-axis position at the start of its container, not changing its size.
 * @apiSince 14
 */

public static final int START = 8388611; // 0x800003

/**
 * Push object to the top of its container, not changing its size.
 * @apiSince 1
 */

public static final int TOP = 48; // 0x30

/**
 * Binary mask to get the vertical gravity of a gravity.
 * @apiSince 1
 */

public static final int VERTICAL_GRAVITY_MASK = 112; // 0x70
}

