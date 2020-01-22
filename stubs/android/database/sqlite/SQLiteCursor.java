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


package android.database.sqlite;

import android.database.CursorWindow;

/**
 * A Cursor implementation that exposes results from a query on a
 * {@link android.database.sqlite.SQLiteDatabase SQLiteDatabase}.
 *
 * SQLiteCursor is not internally synchronized so code using a SQLiteCursor from multiple
 * threads should perform its own synchronization when using the SQLiteCursor.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SQLiteCursor extends android.database.AbstractWindowedCursor {

/**
 * Execute a query and provide access to its result set through a Cursor
 * interface. For a query such as: {@code SELECT name, birth, phone FROM
 * myTable WHERE ... LIMIT 1,20 ORDER BY...} the column names (name, birth,
 * phone) would be in the projection argument and everything from
 * {@code FROM} onward would be in the params argument.
 *
 * @param db a reference to a Database object that is already constructed
 *     and opened. This param is not used any longer
 * @param editTable the name of the table used for this query
 * @param query the rest of the query terms
 *     cursor is finalized
 * @deprecated use {@link #SQLiteCursor(android.database.sqlite.SQLiteCursorDriver,java.lang.String,android.database.sqlite.SQLiteQuery)} instead
 * @apiSince 1
 */

@Deprecated
public SQLiteCursor(android.database.sqlite.SQLiteDatabase db, android.database.sqlite.SQLiteCursorDriver driver, java.lang.String editTable, android.database.sqlite.SQLiteQuery query) { throw new RuntimeException("Stub!"); }

/**
 * Execute a query and provide access to its result set through a Cursor
 * interface. For a query such as: {@code SELECT name, birth, phone FROM
 * myTable WHERE ... LIMIT 1,20 ORDER BY...} the column names (name, birth,
 * phone) would be in the projection argument and everything from
 * {@code FROM} onward would be in the params argument.
 *
 * @param editTable the name of the table used for this query
 * @param query the {@link android.database.sqlite.SQLiteQuery SQLiteQuery} object associated with this cursor object.
 * @apiSince 11
 */

public SQLiteCursor(android.database.sqlite.SQLiteCursorDriver driver, java.lang.String editTable, android.database.sqlite.SQLiteQuery query) { throw new RuntimeException("Stub!"); }

/**
 * Get the database that this cursor is associated with.
 * @return the SQLiteDatabase that this cursor is associated with.
 * @apiSince 1
 */

public android.database.sqlite.SQLiteDatabase getDatabase() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean onMove(int oldPosition, int newPosition) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getCount() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getColumnIndex(java.lang.String columnName) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String[] getColumnNames() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void deactivate() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void close() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean requery() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setWindow(android.database.CursorWindow window) { throw new RuntimeException("Stub!"); }

/**
 * Changes the selection arguments. The new values take effect after a call to requery().
 * @apiSince 1
 */

public void setSelectionArguments(java.lang.String[] selectionArgs) { throw new RuntimeException("Stub!"); }

/**
 * Controls fetching of rows relative to requested position.
 *
 * <p>Calling this method defines how rows will be loaded, but it doesn't affect rows that
 * are already in the window. This setting is preserved if a new window is
 * {@link #setWindow(android.database.CursorWindow) set}
 *
 * @param fillWindowForwardOnly if true, rows will be fetched starting from requested position
 * up to the window's capacity. Default value is false.
 * @apiSince 28
 */

public void setFillWindowForwardOnly(boolean fillWindowForwardOnly) { throw new RuntimeException("Stub!"); }

/**
 * Release the native resources, if they haven't been released yet.
 * @apiSince 1
 */

protected void finalize() { throw new RuntimeException("Stub!"); }
}

