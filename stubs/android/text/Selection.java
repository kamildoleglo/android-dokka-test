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


package android.text;


/**
 * Utility class for manipulating cursors and selections in CharSequences.
 * A cursor is a selection where the start and end are at the same offset.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Selection {

private Selection() { throw new RuntimeException("Stub!"); }

/**
 * Return the offset of the selection anchor or cursor, or -1 if
 * there is no selection or cursor.
 * @apiSince 1
 */

public static final int getSelectionStart(java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }

/**
 * Return the offset of the selection edge or cursor, or -1 if
 * there is no selection or cursor.
 * @apiSince 1
 */

public static final int getSelectionEnd(java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }

/**
 * Set the selection anchor to <code>start</code> and the selection edge
 * to <code>stop</code>.
 * @apiSince 1
 */

public static void setSelection(android.text.Spannable text, int start, int stop) { throw new RuntimeException("Stub!"); }

/**
 * Move the cursor to offset <code>index</code>.
 * @apiSince 1
 */

public static final void setSelection(android.text.Spannable text, int index) { throw new RuntimeException("Stub!"); }

/**
 * Select the entire text.
 * @apiSince 1
 */

public static final void selectAll(android.text.Spannable text) { throw new RuntimeException("Stub!"); }

/**
 * Move the selection edge to offset <code>index</code>.
 * @apiSince 1
 */

public static final void extendSelection(android.text.Spannable text, int index) { throw new RuntimeException("Stub!"); }

/**
 * Remove the selection or cursor, if any, from the text.
 * @apiSince 1
 */

public static final void removeSelection(android.text.Spannable text) { throw new RuntimeException("Stub!"); }

/**
 * Move the cursor to the buffer offset physically above the current
 * offset, to the beginning if it is on the top line but not at the
 * start, or return false if the cursor is already on the top line.
 * @apiSince 1
 */

public static boolean moveUp(android.text.Spannable text, android.text.Layout layout) { throw new RuntimeException("Stub!"); }

/**
 * Move the cursor to the buffer offset physically below the current
 * offset, to the end of the buffer if it is on the bottom line but
 * not at the end, or return false if the cursor is already at the
 * end of the buffer.
 * @apiSince 1
 */

public static boolean moveDown(android.text.Spannable text, android.text.Layout layout) { throw new RuntimeException("Stub!"); }

/**
 * Move the cursor to the buffer offset physically to the left of
 * the current offset, or return false if the cursor is already
 * at the left edge of the line and there is not another line to move it to.
 * @apiSince 1
 */

public static boolean moveLeft(android.text.Spannable text, android.text.Layout layout) { throw new RuntimeException("Stub!"); }

/**
 * Move the cursor to the buffer offset physically to the right of
 * the current offset, or return false if the cursor is already at
 * at the right edge of the line and there is not another line
 * to move it to.
 * @apiSince 1
 */

public static boolean moveRight(android.text.Spannable text, android.text.Layout layout) { throw new RuntimeException("Stub!"); }

/**
 * Move the selection end to the buffer offset physically above
 * the current selection end.
 * @apiSince 1
 */

public static boolean extendUp(android.text.Spannable text, android.text.Layout layout) { throw new RuntimeException("Stub!"); }

/**
 * Move the selection end to the buffer offset physically below
 * the current selection end.
 * @apiSince 1
 */

public static boolean extendDown(android.text.Spannable text, android.text.Layout layout) { throw new RuntimeException("Stub!"); }

/**
 * Move the selection end to the buffer offset physically to the left of
 * the current selection end.
 * @apiSince 1
 */

public static boolean extendLeft(android.text.Spannable text, android.text.Layout layout) { throw new RuntimeException("Stub!"); }

/**
 * Move the selection end to the buffer offset physically to the right of
 * the current selection end.
 * @apiSince 1
 */

public static boolean extendRight(android.text.Spannable text, android.text.Layout layout) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static boolean extendToLeftEdge(android.text.Spannable text, android.text.Layout layout) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static boolean extendToRightEdge(android.text.Spannable text, android.text.Layout layout) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static boolean moveToLeftEdge(android.text.Spannable text, android.text.Layout layout) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static boolean moveToRightEdge(android.text.Spannable text, android.text.Layout layout) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static final java.lang.Object SELECTION_END;
static { SELECTION_END = null; }

/** @apiSince 1 */

public static final java.lang.Object SELECTION_START;
static { SELECTION_START = null; }
}

