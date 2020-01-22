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


package android.database;

import android.os.Parcel;
import android.database.sqlite.SQLiteProgram;
import android.content.ContentValues;
import java.util.Map;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteDatabase;

/**
 * Static utility methods for dealing with databases and {@link android.database.Cursor Cursor}s.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DatabaseUtils {

public DatabaseUtils() { throw new RuntimeException("Stub!"); }

/**
 * Special function for writing an exception result at the header of
 * a parcel, to be used when returning an exception from a transaction.
 * exception will be re-thrown by the function in another process
 * @param reply Parcel to write to
 * @param e The Exception to be written.
 * @see android.os.Parcel#writeNoException
 * @see android.os.Parcel#writeException
 * @apiSince 1
 */

public static final void writeExceptionToParcel(android.os.Parcel reply, java.lang.Exception e) { throw new RuntimeException("Stub!"); }

/**
 * Special function for reading an exception result from the header of
 * a parcel, to be used after receiving the result of a transaction.  This
 * will throw the exception for you if it had been written to the Parcel,
 * otherwise return and let you read the normal result data from the Parcel.
 * @param reply Parcel to read from
 * @see android.os.Parcel#writeNoException
 * @see Parcel#readException
 * @apiSince 1
 */

public static final void readExceptionFromParcel(android.os.Parcel reply) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static void readExceptionWithFileNotFoundExceptionFromParcel(android.os.Parcel reply) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public static void readExceptionWithOperationApplicationExceptionFromParcel(android.os.Parcel reply) throws android.content.OperationApplicationException { throw new RuntimeException("Stub!"); }

/**
 * Binds the given Object to the given SQLiteProgram using the proper
 * typing. For example, bind numbers as longs/doubles, and everything else
 * as a string by call toString() on it.
 *
 * @param prog the program to bind the object to
 * @param index the 1-based index to bind at
 * @param value the value to bind
 * @apiSince 1
 */

public static void bindObjectToProgram(android.database.sqlite.SQLiteProgram prog, int index, java.lang.Object value) { throw new RuntimeException("Stub!"); }

/**
 * Appends an SQL string to the given StringBuilder, including the opening
 * and closing single quotes. Any single quotes internal to sqlString will
 * be escaped.
 *
 * This method is deprecated because we want to encourage everyone
 * to use the "?" binding form.  However, when implementing a
 * ContentProvider, one may want to add WHERE clauses that were
 * not provided by the caller.  Since "?" is a positional form,
 * using it in this case could break the caller because the
 * indexes would be shifted to accomodate the ContentProvider's
 * internal bindings.  In that case, it may be necessary to
 * construct a WHERE clause manually.  This method is useful for
 * those cases.
 *
 * @param sb the StringBuilder that the SQL string will be appended to
 * @param sqlString the raw string to be appended, which may contain single
 *                  quotes
 * @apiSince 1
 */

public static void appendEscapedSQLString(java.lang.StringBuilder sb, java.lang.String sqlString) { throw new RuntimeException("Stub!"); }

/**
 * SQL-escape a string.
 * @apiSince 1
 */

public static java.lang.String sqlEscapeString(java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Appends an Object to an SQL string with the proper escaping, etc.
 * @apiSince 1
 */

public static final void appendValueToSql(java.lang.StringBuilder sql, java.lang.Object value) { throw new RuntimeException("Stub!"); }

/**
 * Concatenates two SQL WHERE clauses, handling empty or null values.
 * @apiSince 11
 */

public static java.lang.String concatenateWhere(java.lang.String a, java.lang.String b) { throw new RuntimeException("Stub!"); }

/**
 * return the collation key
 * @param name
 * @return the collation key
 * @apiSince 1
 */

public static java.lang.String getCollationKey(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * return the collation key in hex format
 * @param name
 * @return the collation key in hex format
 * @apiSince 1
 */

public static java.lang.String getHexCollationKey(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Prints the contents of a Cursor to System.out. The position is restored
 * after printing.
 *
 * @param cursor the cursor to print
 * @apiSince 1
 */

public static void dumpCursor(android.database.Cursor cursor) { throw new RuntimeException("Stub!"); }

/**
 * Prints the contents of a Cursor to a PrintSteam. The position is restored
 * after printing.
 *
 * @param cursor the cursor to print
 * @param stream the stream to print to
 * @apiSince 1
 */

public static void dumpCursor(android.database.Cursor cursor, java.io.PrintStream stream) { throw new RuntimeException("Stub!"); }

/**
 * Prints the contents of a Cursor to a StringBuilder. The position
 * is restored after printing.
 *
 * @param cursor the cursor to print
 * @param sb the StringBuilder to print to
 * @apiSince 1
 */

public static void dumpCursor(android.database.Cursor cursor, java.lang.StringBuilder sb) { throw new RuntimeException("Stub!"); }

/**
 * Prints the contents of a Cursor to a String. The position is restored
 * after printing.
 *
 * @param cursor the cursor to print
 * @return a String that contains the dumped cursor
 * @apiSince 1
 */

public static java.lang.String dumpCursorToString(android.database.Cursor cursor) { throw new RuntimeException("Stub!"); }

/**
 * Prints the contents of a Cursor's current row to System.out.
 *
 * @param cursor the cursor to print from
 * @apiSince 1
 */

public static void dumpCurrentRow(android.database.Cursor cursor) { throw new RuntimeException("Stub!"); }

/**
 * Prints the contents of a Cursor's current row to a PrintSteam.
 *
 * @param cursor the cursor to print
 * @param stream the stream to print to
 * @apiSince 1
 */

public static void dumpCurrentRow(android.database.Cursor cursor, java.io.PrintStream stream) { throw new RuntimeException("Stub!"); }

/**
 * Prints the contents of a Cursor's current row to a StringBuilder.
 *
 * @param cursor the cursor to print
 * @param sb the StringBuilder to print to
 * @apiSince 1
 */

public static void dumpCurrentRow(android.database.Cursor cursor, java.lang.StringBuilder sb) { throw new RuntimeException("Stub!"); }

/**
 * Dump the contents of a Cursor's current row to a String.
 *
 * @param cursor the cursor to print
 * @return a String that contains the dumped cursor row
 * @apiSince 1
 */

public static java.lang.String dumpCurrentRowToString(android.database.Cursor cursor) { throw new RuntimeException("Stub!"); }

/**
 * Reads a String out of a field in a Cursor and writes it to a Map.
 *
 * @param cursor The cursor to read from
 * @param field The TEXT field to read
 * @param values The {@link android.content.ContentValues ContentValues} to put the value into, with the field as the key
 * @apiSince 1
 */

public static void cursorStringToContentValues(android.database.Cursor cursor, java.lang.String field, android.content.ContentValues values) { throw new RuntimeException("Stub!"); }

/**
 * Reads a String out of a field in a Cursor and writes it to an InsertHelper.
 *
 * @param cursor The cursor to read from
 * @param field The TEXT field to read
 * @param inserter The InsertHelper to bind into
 * @param index the index of the bind entry in the InsertHelper
 * @apiSince 1
 */

public static void cursorStringToInsertHelper(android.database.Cursor cursor, java.lang.String field, android.database.DatabaseUtils.InsertHelper inserter, int index) { throw new RuntimeException("Stub!"); }

/**
 * Reads a String out of a field in a Cursor and writes it to a Map.
 *
 * @param cursor The cursor to read from
 * @param field The TEXT field to read
 * @param values The {@link android.content.ContentValues ContentValues} to put the value into, with the field as the key
 * @param key The key to store the value with in the map
 * @apiSince 1
 */

public static void cursorStringToContentValues(android.database.Cursor cursor, java.lang.String field, android.content.ContentValues values, java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Reads an Integer out of a field in a Cursor and writes it to a Map.
 *
 * @param cursor The cursor to read from
 * @param field The INTEGER field to read
 * @param values The {@link android.content.ContentValues ContentValues} to put the value into, with the field as the key
 * @apiSince 1
 */

public static void cursorIntToContentValues(android.database.Cursor cursor, java.lang.String field, android.content.ContentValues values) { throw new RuntimeException("Stub!"); }

/**
 * Reads a Integer out of a field in a Cursor and writes it to a Map.
 *
 * @param cursor The cursor to read from
 * @param field The INTEGER field to read
 * @param values The {@link android.content.ContentValues ContentValues} to put the value into, with the field as the key
 * @param key The key to store the value with in the map
 * @apiSince 1
 */

public static void cursorIntToContentValues(android.database.Cursor cursor, java.lang.String field, android.content.ContentValues values, java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Reads a Long out of a field in a Cursor and writes it to a Map.
 *
 * @param cursor The cursor to read from
 * @param field The INTEGER field to read
 * @param values The {@link android.content.ContentValues ContentValues} to put the value into, with the field as the key
 * @apiSince 1
 */

public static void cursorLongToContentValues(android.database.Cursor cursor, java.lang.String field, android.content.ContentValues values) { throw new RuntimeException("Stub!"); }

/**
 * Reads a Long out of a field in a Cursor and writes it to a Map.
 *
 * @param cursor The cursor to read from
 * @param field The INTEGER field to read
 * @param values The {@link android.content.ContentValues ContentValues} to put the value into
 * @param key The key to store the value with in the map
 * @apiSince 1
 */

public static void cursorLongToContentValues(android.database.Cursor cursor, java.lang.String field, android.content.ContentValues values, java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Reads a Double out of a field in a Cursor and writes it to a Map.
 *
 * @param cursor The cursor to read from
 * @param field The REAL field to read
 * @param values The {@link android.content.ContentValues ContentValues} to put the value into
 * @apiSince 1
 */

public static void cursorDoubleToCursorValues(android.database.Cursor cursor, java.lang.String field, android.content.ContentValues values) { throw new RuntimeException("Stub!"); }

/**
 * Reads a Double out of a field in a Cursor and writes it to a Map.
 *
 * @param cursor The cursor to read from
 * @param field The REAL field to read
 * @param values The {@link android.content.ContentValues ContentValues} to put the value into
 * @param key The key to store the value with in the map
 * @apiSince 1
 */

public static void cursorDoubleToContentValues(android.database.Cursor cursor, java.lang.String field, android.content.ContentValues values, java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Read the entire contents of a cursor row and store them in a ContentValues.
 *
 * @param cursor the cursor to read from.
 * @param values the {@link android.content.ContentValues ContentValues} to put the row into.
 * @apiSince 1
 */

public static void cursorRowToContentValues(android.database.Cursor cursor, android.content.ContentValues values) { throw new RuntimeException("Stub!"); }

/**
 * Query the table for the number of rows in the table.
 * @param db the database the table is in
 * @param table the name of the table to query
 * @return the number of rows in the table
 * @apiSince 1
 */

public static long queryNumEntries(android.database.sqlite.SQLiteDatabase db, java.lang.String table) { throw new RuntimeException("Stub!"); }

/**
 * Query the table for the number of rows in the table.
 * @param db the database the table is in
 * @param table the name of the table to query
 * @param selection A filter declaring which rows to return,
 *              formatted as an SQL WHERE clause (excluding the WHERE itself).
 *              Passing null will count all rows for the given table
 * @return the number of rows in the table filtered by the selection
 * @apiSince 11
 */

public static long queryNumEntries(android.database.sqlite.SQLiteDatabase db, java.lang.String table, java.lang.String selection) { throw new RuntimeException("Stub!"); }

/**
 * Query the table for the number of rows in the table.
 * @param db the database the table is in
 * @param table the name of the table to query
 * @param selection A filter declaring which rows to return,
 *              formatted as an SQL WHERE clause (excluding the WHERE itself).
 *              Passing null will count all rows for the given table
 * @param selectionArgs You may include ?s in selection,
 *              which will be replaced by the values from selectionArgs,
 *              in order that they appear in the selection.
 *              The values will be bound as Strings.
 * @return the number of rows in the table filtered by the selection
 * @apiSince 11
 */

public static long queryNumEntries(android.database.sqlite.SQLiteDatabase db, java.lang.String table, java.lang.String selection, java.lang.String[] selectionArgs) { throw new RuntimeException("Stub!"); }

/**
 * Utility method to run the query on the db and return the value in the
 * first column of the first row.
 * @apiSince 1
 */

public static long longForQuery(android.database.sqlite.SQLiteDatabase db, java.lang.String query, java.lang.String[] selectionArgs) { throw new RuntimeException("Stub!"); }

/**
 * Utility method to run the pre-compiled query and return the value in the
 * first column of the first row.
 * @apiSince 1
 */

public static long longForQuery(android.database.sqlite.SQLiteStatement prog, java.lang.String[] selectionArgs) { throw new RuntimeException("Stub!"); }

/**
 * Utility method to run the query on the db and return the value in the
 * first column of the first row.
 * @apiSince 1
 */

public static java.lang.String stringForQuery(android.database.sqlite.SQLiteDatabase db, java.lang.String query, java.lang.String[] selectionArgs) { throw new RuntimeException("Stub!"); }

/**
 * Utility method to run the pre-compiled query and return the value in the
 * first column of the first row.
 * @apiSince 1
 */

public static java.lang.String stringForQuery(android.database.sqlite.SQLiteStatement prog, java.lang.String[] selectionArgs) { throw new RuntimeException("Stub!"); }

/**
 * Utility method to run the query on the db and return the blob value in the
 * first column of the first row.
 *
 * @return A read-only file descriptor for a copy of the blob value.
 * @apiSince 11
 */

public static android.os.ParcelFileDescriptor blobFileDescriptorForQuery(android.database.sqlite.SQLiteDatabase db, java.lang.String query, java.lang.String[] selectionArgs) { throw new RuntimeException("Stub!"); }

/**
 * Utility method to run the pre-compiled query and return the blob value in the
 * first column of the first row.
 *
 * @return A read-only file descriptor for a copy of the blob value.
 * @apiSince 11
 */

public static android.os.ParcelFileDescriptor blobFileDescriptorForQuery(android.database.sqlite.SQLiteStatement prog, java.lang.String[] selectionArgs) { throw new RuntimeException("Stub!"); }

/**
 * Reads a String out of a column in a Cursor and writes it to a ContentValues.
 * Adds nothing to the ContentValues if the column isn't present or if its value is null.
 *
 * @param cursor The cursor to read from
 * @param column The column to read
 * @param values The {@link android.content.ContentValues ContentValues} to put the value into
 * @apiSince 8
 */

public static void cursorStringToContentValuesIfPresent(android.database.Cursor cursor, android.content.ContentValues values, java.lang.String column) { throw new RuntimeException("Stub!"); }

/**
 * Reads a Long out of a column in a Cursor and writes it to a ContentValues.
 * Adds nothing to the ContentValues if the column isn't present or if its value is null.
 *
 * @param cursor The cursor to read from
 * @param column The column to read
 * @param values The {@link android.content.ContentValues ContentValues} to put the value into
 * @apiSince 8
 */

public static void cursorLongToContentValuesIfPresent(android.database.Cursor cursor, android.content.ContentValues values, java.lang.String column) { throw new RuntimeException("Stub!"); }

/**
 * Reads a Short out of a column in a Cursor and writes it to a ContentValues.
 * Adds nothing to the ContentValues if the column isn't present or if its value is null.
 *
 * @param cursor The cursor to read from
 * @param column The column to read
 * @param values The {@link android.content.ContentValues ContentValues} to put the value into
 * @apiSince 8
 */

public static void cursorShortToContentValuesIfPresent(android.database.Cursor cursor, android.content.ContentValues values, java.lang.String column) { throw new RuntimeException("Stub!"); }

/**
 * Reads a Integer out of a column in a Cursor and writes it to a ContentValues.
 * Adds nothing to the ContentValues if the column isn't present or if its value is null.
 *
 * @param cursor The cursor to read from
 * @param column The column to read
 * @param values The {@link android.content.ContentValues ContentValues} to put the value into
 * @apiSince 8
 */

public static void cursorIntToContentValuesIfPresent(android.database.Cursor cursor, android.content.ContentValues values, java.lang.String column) { throw new RuntimeException("Stub!"); }

/**
 * Reads a Float out of a column in a Cursor and writes it to a ContentValues.
 * Adds nothing to the ContentValues if the column isn't present or if its value is null.
 *
 * @param cursor The cursor to read from
 * @param column The column to read
 * @param values The {@link android.content.ContentValues ContentValues} to put the value into
 * @apiSince 8
 */

public static void cursorFloatToContentValuesIfPresent(android.database.Cursor cursor, android.content.ContentValues values, java.lang.String column) { throw new RuntimeException("Stub!"); }

/**
 * Reads a Double out of a column in a Cursor and writes it to a ContentValues.
 * Adds nothing to the ContentValues if the column isn't present or if its value is null.
 *
 * @param cursor The cursor to read from
 * @param column The column to read
 * @param values The {@link android.content.ContentValues ContentValues} to put the value into
 * @apiSince 8
 */

public static void cursorDoubleToContentValuesIfPresent(android.database.Cursor cursor, android.content.ContentValues values, java.lang.String column) { throw new RuntimeException("Stub!"); }

/**
 * Creates a db and populates it with the sql statements in sqlStatements.
 *
 * @param context the context to use to create the db
 * @param dbName the name of the db to create
 * @param dbVersion the version to set on the db
 * @param sqlStatements the statements to use to populate the db. This should be a single string
 *   of the form returned by sqlite3's <tt>.dump</tt> command (statements separated by
 *   semicolons)
 * @apiSince 1
 */

public static void createDbFromSqlStatements(android.content.Context context, java.lang.String dbName, int dbVersion, java.lang.String sqlStatements) { throw new RuntimeException("Stub!"); }

/**
 * Returns one of the following which represent the type of the given SQL statement.
 * <ol>
 *   <li>{@link #STATEMENT_SELECT}</li>
 *   <li>{@link #STATEMENT_UPDATE}</li>
 *   <li>{@link #STATEMENT_ATTACH}</li>
 *   <li>{@link #STATEMENT_BEGIN}</li>
 *   <li>{@link #STATEMENT_COMMIT}</li>
 *   <li>{@link #STATEMENT_ABORT}</li>
 *   <li>{@link #STATEMENT_OTHER}</li>
 * </ol>
 * @param sql the SQL statement whose type is returned by this method
 * @return one of the values listed above
 * @apiSince 11
 */

public static int getSqlStatementType(java.lang.String sql) { throw new RuntimeException("Stub!"); }

/**
 * Appends one set of selection args to another. This is useful when adding a selection
 * argument to a user provided set.
 * @apiSince 11
 */

public static java.lang.String[] appendSelectionArgs(java.lang.String[] originalValues, java.lang.String[] newValues) { throw new RuntimeException("Stub!"); }

/**
 * One of the values returned by {@link #getSqlStatementType(java.lang.String)}.
 * @apiSince 11
 */

public static final int STATEMENT_ABORT = 6; // 0x6

/**
 * One of the values returned by {@link #getSqlStatementType(java.lang.String)}.
 * @apiSince 11
 */

public static final int STATEMENT_ATTACH = 3; // 0x3

/**
 * One of the values returned by {@link #getSqlStatementType(java.lang.String)}.
 * @apiSince 11
 */

public static final int STATEMENT_BEGIN = 4; // 0x4

/**
 * One of the values returned by {@link #getSqlStatementType(java.lang.String)}.
 * @apiSince 11
 */

public static final int STATEMENT_COMMIT = 5; // 0x5

/**
 * One of the values returned by {@link #getSqlStatementType(java.lang.String)}.
 * @apiSince 11
 */

public static final int STATEMENT_DDL = 8; // 0x8

/**
 * One of the values returned by {@link #getSqlStatementType(java.lang.String)}.
 * @apiSince 11
 */

public static final int STATEMENT_OTHER = 99; // 0x63

/**
 * One of the values returned by {@link #getSqlStatementType(java.lang.String)}.
 * @apiSince 11
 */

public static final int STATEMENT_PRAGMA = 7; // 0x7

/**
 * One of the values returned by {@link #getSqlStatementType(java.lang.String)}.
 * @apiSince 11
 */

public static final int STATEMENT_SELECT = 1; // 0x1

/**
 * One of the values returned by {@link #getSqlStatementType(java.lang.String)}.
 * @apiSince 11
 */

public static final int STATEMENT_UNPREPARED = 9; // 0x9

/**
 * One of the values returned by {@link #getSqlStatementType(java.lang.String)}.
 * @apiSince 11
 */

public static final int STATEMENT_UPDATE = 2; // 0x2
/**
 * This class allows users to do multiple inserts into a table using
 * the same statement.
 * <p>
 * This class is not thread-safe.
 * </p>
 *
 * @deprecated Use {@link android.database.sqlite.SQLiteStatement SQLiteStatement} instead.
 * @apiSince 1
 * @deprecatedSince 17
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static class InsertHelper {

/**
 * @param db the SQLiteDatabase to insert into
 * @param tableName the name of the table to insert into
 * @apiSince 1
 */

@Deprecated
public InsertHelper(android.database.sqlite.SQLiteDatabase db, java.lang.String tableName) { throw new RuntimeException("Stub!"); }

/**
 * Returns the index of the specified column. This is index is suitagble for use
 * in calls to bind().
 * @param key the column name
 * @return the index of the column
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated
public int getColumnIndex(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Bind the value to an index. A prepareForInsert() or prepareForReplace()
 * without a matching execute() must have already have been called.
 * @param index the index of the slot to which to bind
 * @param value the value to bind
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated
public void bind(int index, double value) { throw new RuntimeException("Stub!"); }

/**
 * Bind the value to an index. A prepareForInsert() or prepareForReplace()
 * without a matching execute() must have already have been called.
 * @param index the index of the slot to which to bind
 * @param value the value to bind
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated
public void bind(int index, float value) { throw new RuntimeException("Stub!"); }

/**
 * Bind the value to an index. A prepareForInsert() or prepareForReplace()
 * without a matching execute() must have already have been called.
 * @param index the index of the slot to which to bind
 * @param value the value to bind
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated
public void bind(int index, long value) { throw new RuntimeException("Stub!"); }

/**
 * Bind the value to an index. A prepareForInsert() or prepareForReplace()
 * without a matching execute() must have already have been called.
 * @param index the index of the slot to which to bind
 * @param value the value to bind
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated
public void bind(int index, int value) { throw new RuntimeException("Stub!"); }

/**
 * Bind the value to an index. A prepareForInsert() or prepareForReplace()
 * without a matching execute() must have already have been called.
 * @param index the index of the slot to which to bind
 * @param value the value to bind
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated
public void bind(int index, boolean value) { throw new RuntimeException("Stub!"); }

/**
 * Bind null to an index. A prepareForInsert() or prepareForReplace()
 * without a matching execute() must have already have been called.
 * @param index the index of the slot to which to bind
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated
public void bindNull(int index) { throw new RuntimeException("Stub!"); }

/**
 * Bind the value to an index. A prepareForInsert() or prepareForReplace()
 * without a matching execute() must have already have been called.
 * @param index the index of the slot to which to bind
 * @param value the value to bind
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated
public void bind(int index, byte[] value) { throw new RuntimeException("Stub!"); }

/**
 * Bind the value to an index. A prepareForInsert() or prepareForReplace()
 * without a matching execute() must have already have been called.
 * @param index the index of the slot to which to bind
 * @param value the value to bind
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated
public void bind(int index, java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Performs an insert, adding a new row with the given values.
 * If the table contains conflicting rows, an error is
 * returned.
 *
 * @param values the set of values with which to populate the
 * new row
 *
 * @return the row ID of the newly inserted row, or -1 if an
 * error occurred
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated
public long insert(android.content.ContentValues values) { throw new RuntimeException("Stub!"); }

/**
 * Execute the previously prepared insert or replace using the bound values
 * since the last call to prepareForInsert or prepareForReplace.
 *
 * <p>Note that calling bind() and then execute() is not thread-safe. The only thread-safe
 * way to use this class is to call insert() or replace().
 *
 * @return the row ID of the newly inserted row, or -1 if an
 * error occurred
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated
public long execute() { throw new RuntimeException("Stub!"); }

/**
 * Prepare the InsertHelper for an insert. The pattern for this is:
 * <ul>
 * <li>prepareForInsert()
 * <li>bind(index, value);
 * <li>bind(index, value);
 * <li>...
 * <li>bind(index, value);
 * <li>execute();
 * </ul>
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated
public void prepareForInsert() { throw new RuntimeException("Stub!"); }

/**
 * Prepare the InsertHelper for a replace. The pattern for this is:
 * <ul>
 * <li>prepareForReplace()
 * <li>bind(index, value);
 * <li>bind(index, value);
 * <li>...
 * <li>bind(index, value);
 * <li>execute();
 * </ul>
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated
public void prepareForReplace() { throw new RuntimeException("Stub!"); }

/**
 * Performs an insert, adding a new row with the given values.
 * If the table contains conflicting rows, they are deleted
 * and replaced with the new row.
 *
 * @param values the set of values with which to populate the
 * new row
 *
 * @return the row ID of the newly inserted row, or -1 if an
 * error occurred
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated
public long replace(android.content.ContentValues values) { throw new RuntimeException("Stub!"); }

/**
 * Close this object and release any resources associated with
 * it.  The behavior of calling <code>insert()</code> after
 * calling this method is undefined.
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated
public void close() { throw new RuntimeException("Stub!"); }
}

}

