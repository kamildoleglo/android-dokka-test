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


package android.database;


/**
 * A mutable cursor implementation backed by an array of {@code Object}s. Use
 * {@link #newRow()} to add rows. Automatically expands internal capacity
 * as needed.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MatrixCursor extends android.database.AbstractCursor {

/**
 * Constructs a new cursor with the given initial capacity.
 *
 * @param columnNames names of the columns, the ordering of which
 *  determines column ordering elsewhere in this cursor
 * @param initialCapacity in rows
 * @apiSince 1
 */

public MatrixCursor(java.lang.String[] columnNames, int initialCapacity) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new cursor.
 *
 * @param columnNames names of the columns, the ordering of which
 *  determines column ordering elsewhere in this cursor
 * @apiSince 1
 */

public MatrixCursor(java.lang.String[] columnNames) { throw new RuntimeException("Stub!"); }

/**
 * Adds a new row to the end and returns a builder for that row. Not safe
 * for concurrent use.
 *
 * @return builder which can be used to set the column values for the new
 *  row
 * @apiSince 1
 */

public android.database.MatrixCursor.RowBuilder newRow() { throw new RuntimeException("Stub!"); }

/**
 * Adds a new row to the end with the given column values. Not safe
 * for concurrent use.
 *
 * @throws java.lang.IllegalArgumentException if {@code columnValues.length !=
 *  columnNames.length}
 * @param columnValues in the same order as the the column names specified
 *  at cursor construction time
 * @apiSince 1
 */

public void addRow(java.lang.Object[] columnValues) { throw new RuntimeException("Stub!"); }

/**
 * Adds a new row to the end with the given column values. Not safe
 * for concurrent use.
 *
 * @throws java.lang.IllegalArgumentException if {@code columnValues.size() !=
 *  columnNames.length}
 * @param columnValues in the same order as the the column names specified
 *  at cursor construction time
 * @apiSince 1
 */

public void addRow(java.lang.Iterable<?> columnValues) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getCount() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String[] getColumnNames() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String getString(int column) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public short getShort(int column) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getInt(int column) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public long getLong(int column) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public float getFloat(int column) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public double getDouble(int column) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public byte[] getBlob(int column) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public int getType(int column) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean isNull(int column) { throw new RuntimeException("Stub!"); }
/**
 * Builds a row of values using either of these approaches:
 * <ul>
 * <li>Values can be added with explicit column ordering using
 * {@link #add(java.lang.Object)}, which starts from the left-most column and adds one
 * column value at a time. This follows the same ordering as the column
 * names specified at cursor construction time.
 * <li>Column and value pairs can be offered for possible inclusion using
 * {@link #add(java.lang.String,java.lang.Object)}. If the cursor includes the given column,
 * the value will be set for that column, otherwise the value is ignored.
 * This approach is useful when matching data to a custom projection.
 * </ul>
 * Undefined values are left as {@code null}.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class RowBuilder {

RowBuilder() { throw new RuntimeException("Stub!"); }

/**
 * Sets the next column value in this row.
 *
 * @throws android.database.CursorIndexOutOfBoundsException if you try to add too many
 *  values
 * @return this builder to support chaining
 * @apiSince 1
 */

public android.database.MatrixCursor.RowBuilder add(java.lang.Object columnValue) { throw new RuntimeException("Stub!"); }

/**
 * Offer value for possible inclusion if this cursor defines the given
 * column. Columns not defined by the cursor are silently ignored.
 *
 * @return this builder to support chaining
 * @apiSince 19
 */

public android.database.MatrixCursor.RowBuilder add(java.lang.String columnName, java.lang.Object value) { throw new RuntimeException("Stub!"); }
}

}

