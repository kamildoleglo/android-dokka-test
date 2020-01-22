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


/**
 * Represents a statement that can be executed against a database.  The statement
 * cannot return multiple rows or columns, but single value (1 x 1) result sets
 * are supported.
 * <p>
 * This class is not thread-safe.
 * </p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SQLiteStatement extends android.database.sqlite.SQLiteProgram {

SQLiteStatement() { throw new RuntimeException("Stub!"); }

/**
 * Execute this SQL statement, if it is not a SELECT / INSERT / DELETE / UPDATE, for example
 * CREATE / DROP table, view, trigger, index etc.
 *
 * @throws android.database.SQLException If the SQL string is invalid for
 *         some reason
 * @apiSince 1
 */

public void execute() { throw new RuntimeException("Stub!"); }

/**
 * Execute this SQL statement, if the number of rows affected by execution of this SQL
 * statement is of any importance to the caller - for example, UPDATE / DELETE SQL statements.
 *
 * @return the number of rows affected by this SQL statement execution.
 * @throws android.database.SQLException If the SQL string is invalid for
 *         some reason
 * @apiSince 11
 */

public int executeUpdateDelete() { throw new RuntimeException("Stub!"); }

/**
 * Execute this SQL statement and return the ID of the row inserted due to this call.
 * The SQL statement should be an INSERT for this to be a useful call.
 *
 * @return the row ID of the last row inserted, if this insert is successful. -1 otherwise.
 *
 * @throws android.database.SQLException If the SQL string is invalid for
 *         some reason
 * @apiSince 1
 */

public long executeInsert() { throw new RuntimeException("Stub!"); }

/**
 * Execute a statement that returns a 1 by 1 table with a numeric value.
 * For example, SELECT COUNT(*) FROM table;
 *
 * @return The result of the query.
 *
 * @throws android.database.sqlite.SQLiteDoneException if the query returns zero rows
 * @apiSince 1
 */

public long simpleQueryForLong() { throw new RuntimeException("Stub!"); }

/**
 * Execute a statement that returns a 1 by 1 table with a text value.
 * For example, SELECT COUNT(*) FROM table;
 *
 * @return The result of the query.
 *
 * @throws android.database.sqlite.SQLiteDoneException if the query returns zero rows
 * @apiSince 1
 */

public java.lang.String simpleQueryForString() { throw new RuntimeException("Stub!"); }

/**
 * Executes a statement that returns a 1 by 1 table with a blob value.
 *
 * @return A read-only file descriptor for a copy of the blob value, or {@code null}
 *         if the value is null or could not be read for some reason.
 *
 * @throws android.database.sqlite.SQLiteDoneException if the query returns zero rows
 * @apiSince 11
 */

public android.os.ParcelFileDescriptor simpleQueryForBlobFileDescriptor() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

