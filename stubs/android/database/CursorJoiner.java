/*
 * Copyright (C) 2008 The Android Open Source Project
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


package android.database;


/**
 * Does a join on two cursors using the specified columns. The cursors must already
 * be sorted on each of the specified columns in ascending order. This joiner only
 * supports the case where the tuple of key column values is unique.
 * <p>
 * Typical usage:
 *
 * <pre>
 * CursorJoiner joiner = new CursorJoiner(cursorA, keyColumnsofA, cursorB, keyColumnsofB);
 * for (CursorJoiner.Result joinerResult : joiner) {
 *     switch (joinerResult) {
 *         case LEFT:
 *             // handle case where a row in cursorA is unique
 *             break;
 *         case RIGHT:
 *             // handle case where a row in cursorB is unique
 *             break;
 *         case BOTH:
 *             // handle case where a row with the same key is in both cursors
 *             break;
 *     }
 * }
 * </pre>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CursorJoiner implements java.util.Iterator<android.database.CursorJoiner.Result>, java.lang.Iterable<android.database.CursorJoiner.Result> {

/**
 * Initializes the CursorJoiner and resets the cursors to the first row. The left and right
 * column name arrays must have the same number of columns.
 * @param cursorLeft The left cursor to compare
 * @param columnNamesLeft The column names to compare from the left cursor
 * @param cursorRight The right cursor to compare
 * @param columnNamesRight The column names to compare from the right cursor
 * @apiSince 1
 */

public CursorJoiner(android.database.Cursor cursorLeft, java.lang.String[] columnNamesLeft, android.database.Cursor cursorRight, java.lang.String[] columnNamesRight) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.util.Iterator<android.database.CursorJoiner.Result> iterator() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether or not there are more rows to compare using next().
 * @return true if there are more rows to compare
 * @apiSince 1
 */

public boolean hasNext() { throw new RuntimeException("Stub!"); }

/**
 * Returns the comparison result of the next row from each cursor. If one cursor
 * has no more rows but the other does then subsequent calls to this will indicate that
 * the remaining rows are unique.
 * <p>
 * The caller must check that hasNext() returns true before calling this.
 * <p>
 * Once next() has been called the cursors specified in the result of the call to
 * next() are guaranteed to point to the row that was indicated. Reading values
 * from the cursor that was not indicated in the call to next() will result in
 * undefined behavior.
 * @return LEFT, if the row pointed to by the left cursor is unique, RIGHT
 *   if the row pointed to by the right cursor is unique, BOTH if the rows in both
 *   cursors are the same.
 * @apiSince 1
 */

public android.database.CursorJoiner.Result next() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void remove() { throw new RuntimeException("Stub!"); }
/**
 * The result of a call to next().
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum Result {
/**
 * The row currently pointed to by the left cursor is unique
 * @apiSince 1
 */

RIGHT,
/**
 * The row currently pointed to by the right cursor is unique
 * @apiSince 1
 */

LEFT,
/**
 * The rows pointed to by both cursors are the same
 * @apiSince 1
 */

BOTH;
}

}

