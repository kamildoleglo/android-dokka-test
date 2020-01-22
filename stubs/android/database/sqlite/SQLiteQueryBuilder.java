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

import java.util.Map;
import java.util.Set;
import android.os.Build;
import android.os.OperationCanceledException;

/**
 * This is a convenience class that helps build SQL queries to be sent to
 * {@link android.database.sqlite.SQLiteDatabase SQLiteDatabase} objects.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SQLiteQueryBuilder {

/** @apiSince 1 */

public SQLiteQueryBuilder() { throw new RuntimeException("Stub!"); }

/**
 * Mark the query as {@code DISTINCT}.
 *
 * @param distinct if true the query is {@code DISTINCT}, otherwise it isn't
 * @apiSince 1
 */

public void setDistinct(boolean distinct) { throw new RuntimeException("Stub!"); }

/**
 * Get if the query is marked as {@code DISTINCT}, as last configured by
 * {@link #setDistinct(boolean)}.
 * @apiSince 29
 */

public boolean isDistinct() { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of tables being queried
 *
 * @return the list of tables being queried
 
 * This value may be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.lang.String getTables() { throw new RuntimeException("Stub!"); }

/**
 * Sets the list of tables to query. Multiple tables can be specified to perform a join.
 * For example:
 *   setTables("foo, bar")
 *   setTables("foo LEFT OUTER JOIN bar ON (foo.id = bar.foo_id)")
 *
 * @param inTables the list of tables to query on
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void setTables(@androidx.annotation.Nullable java.lang.String inTables) { throw new RuntimeException("Stub!"); }

/**
 * Append a chunk to the {@code WHERE} clause of the query. All chunks appended are surrounded
 * by parenthesis and {@code AND}ed with the selection passed to {@link #query}. The final
 * {@code WHERE} clause looks like:
 * <p>
 * WHERE (&lt;append chunk 1>&lt;append chunk2>) AND (&lt;query() selection parameter>)
 *
 * @param inWhere the chunk of text to append to the {@code WHERE} clause.
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public void appendWhere(@androidx.annotation.NonNull java.lang.CharSequence inWhere) { throw new RuntimeException("Stub!"); }

/**
 * Append a chunk to the {@code WHERE} clause of the query. All chunks appended are surrounded
 * by parenthesis and ANDed with the selection passed to {@link #query}. The final
 * {@code WHERE} clause looks like:
 * <p>
 * WHERE (&lt;append chunk 1>&lt;append chunk2>) AND (&lt;query() selection parameter>)
 *
 * @param inWhere the chunk of text to append to the {@code WHERE} clause. it will be escaped
 * to avoid SQL injection attacks
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public void appendWhereEscapeString(@androidx.annotation.NonNull java.lang.String inWhere) { throw new RuntimeException("Stub!"); }

/**
 * Add a standalone chunk to the {@code WHERE} clause of this query.
 * <p>
 * This method differs from {@link #appendWhere(java.lang.CharSequence)} in that it
 * automatically appends {@code AND} to any existing {@code WHERE} clause
 * already under construction before appending the given standalone
 * expression wrapped in parentheses.
 *
 * @param inWhere the standalone expression to append to the {@code WHERE}
 *            clause. It will be wrapped in parentheses when it's appended.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void appendWhereStandalone(@androidx.annotation.NonNull java.lang.CharSequence inWhere) { throw new RuntimeException("Stub!"); }

/**
 * Sets the projection map for the query.  The projection map maps
 * from column names that the caller passes into query to database
 * column names. This is useful for renaming columns as well as
 * disambiguating column names when doing joins. For example you
 * could map "name" to "people.name".  If a projection map is set
 * it must contain all column names the user may request, even if
 * the key and value are the same.
 *
 * @param columnMap maps from the user column names to the database column names
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void setProjectionMap(@androidx.annotation.Nullable java.util.Map<java.lang.String,java.lang.String> columnMap) { throw new RuntimeException("Stub!"); }

/**
 * Gets the projection map for the query, as last configured by
 * {@link #setProjectionMap(java.util.Map)}.
 
 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.util.Map<java.lang.String,java.lang.String> getProjectionMap() { throw new RuntimeException("Stub!"); }

/**
 * Sets the cursor factory to be used for the query.  You can use
 * one factory for all queries on a database but it is normally
 * easier to specify the factory when doing this query.
 *
 * @param factory the factory to use.
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void setCursorFactory(@androidx.annotation.Nullable android.database.sqlite.SQLiteDatabase.CursorFactory factory) { throw new RuntimeException("Stub!"); }

/**
 * Gets the cursor factory to be used for the query, as last configured by
 * {@link #setCursorFactory(android.database.sqlite.SQLiteDatabase.CursorFactory)}.
 
 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.database.sqlite.SQLiteDatabase.CursorFactory getCursorFactory() { throw new RuntimeException("Stub!"); }

/**
 * When set, the selection is verified against malicious arguments.
 * When using this class to create a statement using
 * {@link #buildQueryString(boolean,java.lang.String,java.lang.String[],java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String)},
 * non-numeric limits will raise an exception. If a projection map is specified, fields
 * not in that map will be ignored.
 * If this class is used to execute the statement directly using
 * {@link #query(android.database.sqlite.SQLiteDatabase,java.lang.String[],java.lang.String,java.lang.String[],java.lang.String,java.lang.String,java.lang.String)}
 * or
 * {@link #query(android.database.sqlite.SQLiteDatabase,java.lang.String[],java.lang.String,java.lang.String[],java.lang.String,java.lang.String,java.lang.String,java.lang.String)},
 * additionally also parenthesis escaping selection are caught.
 *
 * To summarize: To get maximum protection against malicious third party apps (for example
 * content provider consumers), make sure to do the following:
 * <ul>
 * <li>Set this value to true</li>
 * <li>Use a projection map</li>
 * <li>Use one of the query overloads instead of getting the statement as a sql string</li>
 * </ul>
 * By default, this value is false.
 * @apiSince 14
 */

public void setStrict(boolean strict) { throw new RuntimeException("Stub!"); }

/**
 * Get if the query is marked as strict, as last configured by
 * {@link #setStrict(boolean)}.
 * @apiSince 29
 */

public boolean isStrict() { throw new RuntimeException("Stub!"); }

/**
 * Build an SQL query string from the given clauses.
 *
 * @param distinct true if you want each row to be unique, false otherwise.
 * @param tables The table names to compile the query against.
 * @param columns A list of which columns to return. Passing null will
 *            return all columns, which is discouraged to prevent reading
 *            data from storage that isn't going to be used.
 * @param where A filter declaring which rows to return, formatted as an SQL
 *            {@code WHERE} clause (excluding the {@code WHERE} itself). Passing {@code null} will
 *            return all rows for the given URL.
 * @param groupBy A filter declaring how to group rows, formatted as an SQL
 *            {@code GROUP BY} clause (excluding the {@code GROUP BY} itself). Passing {@code null}
 *            will cause the rows to not be grouped.
 * @param having A filter declare which row groups to include in the cursor,
 *            if row grouping is being used, formatted as an SQL {@code HAVING}
 *            clause (excluding the {@code HAVING} itself). Passing null will cause
 *            all row groups to be included, and is required when row
 *            grouping is not being used.
 * @param orderBy How to order the rows, formatted as an SQL {@code ORDER BY} clause
 *            (excluding the {@code ORDER BY} itself). Passing null will use the
 *            default sort order, which may be unordered.
 * @param limit Limits the number of rows returned by the query,
 *            formatted as {@code LIMIT} clause. Passing null denotes no {@code LIMIT} clause.
 * @return the SQL query string
 * @apiSince 1
 */

public static java.lang.String buildQueryString(boolean distinct, java.lang.String tables, java.lang.String[] columns, java.lang.String where, java.lang.String groupBy, java.lang.String having, java.lang.String orderBy, java.lang.String limit) { throw new RuntimeException("Stub!"); }

/**
 * Add the names that are non-null in columns to s, separating
 * them with commas.
 * @apiSince 1
 */

public static void appendColumns(java.lang.StringBuilder s, java.lang.String[] columns) { throw new RuntimeException("Stub!"); }

/**
 * Perform a query by combining all current settings and the
 * information passed into this method.
 *
 * @param db the database to query on
 * @param projectionIn A list of which columns to return. Passing
 *   null will return all columns, which is discouraged to prevent
 *   reading data from storage that isn't going to be used.
 * @param selection A filter declaring which rows to return,
 *   formatted as an SQL {@code WHERE} clause (excluding the {@code WHERE}
 *   itself). Passing null will return all rows for the given URL.
 * @param selectionArgs You may include ?s in selection, which
 *   will be replaced by the values from selectionArgs, in order
 *   that they appear in the selection. The values will be bound
 *   as Strings.
 * @param groupBy A filter declaring how to group rows, formatted
 *   as an SQL {@code GROUP BY} clause (excluding the {@code GROUP BY}
 *   itself). Passing null will cause the rows to not be grouped.
 * @param having A filter declare which row groups to include in
 *   the cursor, if row grouping is being used, formatted as an
 *   SQL {@code HAVING} clause (excluding the {@code HAVING} itself).  Passing
 *   null will cause all row groups to be included, and is
 *   required when row grouping is not being used.
 * @param sortOrder How to order the rows, formatted as an SQL
 *   {@code ORDER BY} clause (excluding the {@code ORDER BY} itself). Passing null
 *   will use the default sort order, which may be unordered.
 * @return a cursor over the result set
 * @see android.content.ContentResolver#query(android.net.Uri, String[],
 *      String, String[], String)
 * @apiSince 1
 */

public android.database.Cursor query(android.database.sqlite.SQLiteDatabase db, java.lang.String[] projectionIn, java.lang.String selection, java.lang.String[] selectionArgs, java.lang.String groupBy, java.lang.String having, java.lang.String sortOrder) { throw new RuntimeException("Stub!"); }

/**
 * Perform a query by combining all current settings and the
 * information passed into this method.
 *
 * @param db the database to query on
 * @param projectionIn A list of which columns to return. Passing
 *   null will return all columns, which is discouraged to prevent
 *   reading data from storage that isn't going to be used.
 * @param selection A filter declaring which rows to return,
 *   formatted as an SQL {@code WHERE} clause (excluding the {@code WHERE}
 *   itself). Passing null will return all rows for the given URL.
 * @param selectionArgs You may include ?s in selection, which
 *   will be replaced by the values from selectionArgs, in order
 *   that they appear in the selection. The values will be bound
 *   as Strings.
 * @param groupBy A filter declaring how to group rows, formatted
 *   as an SQL {@code GROUP BY} clause (excluding the {@code GROUP BY}
 *   itself). Passing null will cause the rows to not be grouped.
 * @param having A filter declare which row groups to include in
 *   the cursor, if row grouping is being used, formatted as an
 *   SQL {@code HAVING} clause (excluding the {@code HAVING} itself).  Passing
 *   null will cause all row groups to be included, and is
 *   required when row grouping is not being used.
 * @param sortOrder How to order the rows, formatted as an SQL
 *   {@code ORDER BY} clause (excluding the {@code ORDER BY} itself). Passing null
 *   will use the default sort order, which may be unordered.
 * @param limit Limits the number of rows returned by the query,
 *   formatted as {@code LIMIT} clause. Passing null denotes no {@code LIMIT} clause.
 * @return a cursor over the result set
 * @see android.content.ContentResolver#query(android.net.Uri, String[],
 *      String, String[], String)
 * @apiSince 1
 */

public android.database.Cursor query(android.database.sqlite.SQLiteDatabase db, java.lang.String[] projectionIn, java.lang.String selection, java.lang.String[] selectionArgs, java.lang.String groupBy, java.lang.String having, java.lang.String sortOrder, java.lang.String limit) { throw new RuntimeException("Stub!"); }

/**
 * Perform a query by combining all current settings and the
 * information passed into this method.
 *
 * @param db the database to query on
 * @param projectionIn A list of which columns to return. Passing
 *   null will return all columns, which is discouraged to prevent
 *   reading data from storage that isn't going to be used.
 * @param selection A filter declaring which rows to return,
 *   formatted as an SQL {@code WHERE} clause (excluding the {@code WHERE}
 *   itself). Passing null will return all rows for the given URL.
 * @param selectionArgs You may include ?s in selection, which
 *   will be replaced by the values from selectionArgs, in order
 *   that they appear in the selection. The values will be bound
 *   as Strings.
 * @param groupBy A filter declaring how to group rows, formatted
 *   as an SQL {@code GROUP BY} clause (excluding the {@code GROUP BY}
 *   itself). Passing null will cause the rows to not be grouped.
 * @param having A filter declare which row groups to include in
 *   the cursor, if row grouping is being used, formatted as an
 *   SQL {@code HAVING} clause (excluding the {@code HAVING} itself).  Passing
 *   null will cause all row groups to be included, and is
 *   required when row grouping is not being used.
 * @param sortOrder How to order the rows, formatted as an SQL
 *   {@code ORDER BY} clause (excluding the {@code ORDER BY} itself). Passing null
 *   will use the default sort order, which may be unordered.
 * @param limit Limits the number of rows returned by the query,
 *   formatted as {@code LIMIT} clause. Passing null denotes no {@code LIMIT} clause.
 * @param cancellationSignal A signal to cancel the operation in progress, or null if none.
 * If the operation is canceled, then {@link android.os.OperationCanceledException OperationCanceledException} will be thrown
 * when the query is executed.
 * @return a cursor over the result set
 * @see android.content.ContentResolver#query(android.net.Uri, String[],
 *      String, String[], String)
 * @apiSince 16
 */

public android.database.Cursor query(android.database.sqlite.SQLiteDatabase db, java.lang.String[] projectionIn, java.lang.String selection, java.lang.String[] selectionArgs, java.lang.String groupBy, java.lang.String having, java.lang.String sortOrder, java.lang.String limit, android.os.CancellationSignal cancellationSignal) { throw new RuntimeException("Stub!"); }

/**
 * Perform an update by combining all current settings and the
 * information passed into this method.
 *
 * @param db the database to update on
 * This value must never be {@code null}.
 * @param selection A filter declaring which rows to return,
 *   formatted as an SQL {@code WHERE} clause (excluding the {@code WHERE}
 *   itself). Passing null will return all rows for the given URL.
 * This value may be {@code null}.
 * @param selectionArgs You may include ?s in selection, which
 *   will be replaced by the values from selectionArgs, in order
 *   that they appear in the selection. The values will be bound
 *   as Strings.
 * This value may be {@code null}.
 * @param values This value must never be {@code null}.
 * @return the number of rows updated
 * @apiSince 29
 */

public int update(@androidx.annotation.NonNull android.database.sqlite.SQLiteDatabase db, @androidx.annotation.NonNull android.content.ContentValues values, @androidx.annotation.Nullable java.lang.String selection, @androidx.annotation.Nullable java.lang.String[] selectionArgs) { throw new RuntimeException("Stub!"); }

/**
 * Perform a delete by combining all current settings and the
 * information passed into this method.
 *
 * @param db the database to delete on
 * This value must never be {@code null}.
 * @param selection A filter declaring which rows to return,
 *   formatted as an SQL {@code WHERE} clause (excluding the {@code WHERE}
 *   itself). Passing null will return all rows for the given URL.
 * This value may be {@code null}.
 * @param selectionArgs You may include ?s in selection, which
 *   will be replaced by the values from selectionArgs, in order
 *   that they appear in the selection. The values will be bound
 *   as Strings.
 * This value may be {@code null}.
 * @return the number of rows deleted
 * @apiSince 29
 */

public int delete(@androidx.annotation.NonNull android.database.sqlite.SQLiteDatabase db, @androidx.annotation.Nullable java.lang.String selection, @androidx.annotation.Nullable java.lang.String[] selectionArgs) { throw new RuntimeException("Stub!"); }

/**
 * Construct a {@code SELECT} statement suitable for use in a group of
 * {@code SELECT} statements that will be joined through {@code UNION} operators
 * in buildUnionQuery.
 *
 * @param projectionIn A list of which columns to return. Passing
 *    null will return all columns, which is discouraged to
 *    prevent reading data from storage that isn't going to be
 *    used.
 * @param selection A filter declaring which rows to return,
 *   formatted as an SQL {@code WHERE} clause (excluding the {@code WHERE}
 *   itself).  Passing null will return all rows for the given
 *   URL.
 * @param groupBy A filter declaring how to group rows, formatted
 *   as an SQL {@code GROUP BY} clause (excluding the {@code GROUP BY} itself).
 *   Passing null will cause the rows to not be grouped.
 * @param having A filter declare which row groups to include in
 *   the cursor, if row grouping is being used, formatted as an
 *   SQL {@code HAVING} clause (excluding the {@code HAVING} itself).  Passing
 *   null will cause all row groups to be included, and is
 *   required when row grouping is not being used.
 * @param sortOrder How to order the rows, formatted as an SQL
 *   {@code ORDER BY} clause (excluding the {@code ORDER BY} itself). Passing null
 *   will use the default sort order, which may be unordered.
 * @param limit Limits the number of rows returned by the query,
 *   formatted as {@code LIMIT} clause. Passing null denotes no {@code LIMIT} clause.
 * @return the resulting SQL {@code SELECT} statement
 * @apiSince 11
 */

public java.lang.String buildQuery(java.lang.String[] projectionIn, java.lang.String selection, java.lang.String groupBy, java.lang.String having, java.lang.String sortOrder, java.lang.String limit) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated This method's signature is misleading since no SQL parameter
 * substitution is carried out.  The selection arguments parameter does not get
 * used at all.  To avoid confusion, call
 * {@link #buildQuery(java.lang.String[],java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String)} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public java.lang.String buildQuery(java.lang.String[] projectionIn, java.lang.String selection, java.lang.String[] selectionArgs, java.lang.String groupBy, java.lang.String having, java.lang.String sortOrder, java.lang.String limit) { throw new RuntimeException("Stub!"); }

/**
 * Construct a {@code SELECT} statement suitable for use in a group of
 * {@code SELECT} statements that will be joined through {@code UNION} operators
 * in buildUnionQuery.
 *
 * @param typeDiscriminatorColumn the name of the result column
 *   whose cells will contain the name of the table from which
 *   each row was drawn.
 * @param unionColumns the names of the columns to appear in the
 *   result.  This may include columns that do not appear in the
 *   table this {@code SELECT} is querying (i.e. mTables), but that do
 *   appear in one of the other tables in the {@code UNION} query that we
 *   are constructing.
 * @param columnsPresentInTable a Set of the names of the columns
 *   that appear in this table (i.e. in the table whose name is
 *   mTables).  Since columns in unionColumns include columns that
 *   appear only in other tables, we use this array to distinguish
 *   which ones actually are present.  Other columns will have
 *   NULL values for results from this subquery.
 * @param computedColumnsOffset all columns in unionColumns before
 *   this index are included under the assumption that they're
 *   computed and therefore won't appear in columnsPresentInTable,
 *   e.g. "date * 1000 as normalized_date"
 * @param typeDiscriminatorValue the value used for the
 *   type-discriminator column in this subquery
 * @param selection A filter declaring which rows to return,
 *   formatted as an SQL {@code WHERE} clause (excluding the {@code WHERE}
 *   itself).  Passing null will return all rows for the given
 *   URL.
 * @param groupBy A filter declaring how to group rows, formatted
 *   as an SQL {@code GROUP BY} clause (excluding the {@code GROUP BY} itself).
 *   Passing null will cause the rows to not be grouped.
 * @param having A filter declare which row groups to include in
 *   the cursor, if row grouping is being used, formatted as an
 *   SQL {@code HAVING} clause (excluding the {@code HAVING} itself).  Passing
 *   null will cause all row groups to be included, and is
 *   required when row grouping is not being used.
 * @return the resulting SQL {@code SELECT} statement
 * @apiSince 11
 */

public java.lang.String buildUnionSubQuery(java.lang.String typeDiscriminatorColumn, java.lang.String[] unionColumns, java.util.Set<java.lang.String> columnsPresentInTable, int computedColumnsOffset, java.lang.String typeDiscriminatorValue, java.lang.String selection, java.lang.String groupBy, java.lang.String having) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated This method's signature is misleading since no SQL parameter
 * substitution is carried out.  The selection arguments parameter does not get
 * used at all.  To avoid confusion, call
 * {@link #buildUnionSubQuery}
 * instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public java.lang.String buildUnionSubQuery(java.lang.String typeDiscriminatorColumn, java.lang.String[] unionColumns, java.util.Set<java.lang.String> columnsPresentInTable, int computedColumnsOffset, java.lang.String typeDiscriminatorValue, java.lang.String selection, java.lang.String[] selectionArgs, java.lang.String groupBy, java.lang.String having) { throw new RuntimeException("Stub!"); }

/**
 * Given a set of subqueries, all of which are {@code SELECT} statements,
 * construct a query that returns the union of what those
 * subqueries return.
 * @param subQueries an array of SQL {@code SELECT} statements, all of
 *   which must have the same columns as the same positions in
 *   their results
 * @param sortOrder How to order the rows, formatted as an SQL
 *   {@code ORDER BY} clause (excluding the {@code ORDER BY} itself).  Passing
 *   null will use the default sort order, which may be unordered.
 * @param limit The limit clause, which applies to the entire union result set
 *
 * @return the resulting SQL {@code SELECT} statement
 * @apiSince 1
 */

public java.lang.String buildUnionQuery(java.lang.String[] subQueries, java.lang.String sortOrder, java.lang.String limit) { throw new RuntimeException("Stub!"); }
}

