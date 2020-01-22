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


package android.database.sqlite;

import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.Cursor;

/**
 * A driver for SQLiteCursors that is used to create them and gets notified
 * by the cursors it creates on significant events in their lifetimes.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface SQLiteCursorDriver {

/**
 * Executes the query returning a Cursor over the result set.
 *
 * @param factory The CursorFactory to use when creating the Cursors, or
 *         null if standard SQLiteCursors should be returned.
 * @return a Cursor over the result set
 * @apiSince 1
 */

public android.database.Cursor query(android.database.sqlite.SQLiteDatabase.CursorFactory factory, java.lang.String[] bindArgs);

/**
 * Called by a SQLiteCursor when it is released.
 * @apiSince 1
 */

public void cursorDeactivated();

/**
 * Called by a SQLiteCursor when it is requeried.
 * @apiSince 1
 */

public void cursorRequeried(android.database.Cursor cursor);

/**
 * Called by a SQLiteCursor when it it closed to destroy this object as well.
 * @apiSince 1
 */

public void cursorClosed();

/**
 * Set new bind arguments. These will take effect in cursorRequeried().
 * @param bindArgs the new arguments
 * @apiSince 1
 */

public void setBindArguments(java.lang.String[] bindArgs);
}

