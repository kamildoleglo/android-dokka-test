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


package android.content;

import android.net.Uri;

/**
 * A helper class to help make handling asynchronous {@link android.content.ContentResolver ContentResolver}
 * queries easier.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class AsyncQueryHandler extends android.os.Handler {

/** @apiSince 1 */

public AsyncQueryHandler(android.content.ContentResolver cr) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected android.os.Handler createHandler(android.os.Looper looper) { throw new RuntimeException("Stub!"); }

/**
 * This method begins an asynchronous query. When the query is done
 * {@link #onQueryComplete} is called.
 *
 * @param token A token passed into {@link #onQueryComplete} to identify
 *  the query.
 * @param cookie An object that gets passed into {@link #onQueryComplete}
 * @param uri The URI, using the content:// scheme, for the content to
 *         retrieve.
 * @param projection A list of which columns to return. Passing null will
 *         return all columns, which is discouraged to prevent reading data
 *         from storage that isn't going to be used.
 * @param selection A filter declaring which rows to return, formatted as an
 *         SQL WHERE clause (excluding the WHERE itself). Passing null will
 *         return all rows for the given URI.
 * @param selectionArgs You may include ?s in selection, which will be
 *         replaced by the values from selectionArgs, in the order that they
 *         appear in the selection. The values will be bound as Strings.
 * @param orderBy How to order the rows, formatted as an SQL ORDER BY
 *         clause (excluding the ORDER BY itself). Passing null will use the
 *         default sort order, which may be unordered.
 * @apiSince 1
 */

public void startQuery(int token, java.lang.Object cookie, android.net.Uri uri, java.lang.String[] projection, java.lang.String selection, java.lang.String[] selectionArgs, java.lang.String orderBy) { throw new RuntimeException("Stub!"); }

/**
 * Attempts to cancel operation that has not already started. Note that
 * there is no guarantee that the operation will be canceled. They still may
 * result in a call to on[Query/Insert/Update/Delete]Complete after this
 * call has completed.
 *
 * @param token The token representing the operation to be canceled.
 *  If multiple operations have the same token they will all be canceled.
 * @apiSince 1
 */

public final void cancelOperation(int token) { throw new RuntimeException("Stub!"); }

/**
 * This method begins an asynchronous insert. When the insert operation is
 * done {@link #onInsertComplete} is called.
 *
 * @param token A token passed into {@link #onInsertComplete} to identify
 *  the insert operation.
 * @param cookie An object that gets passed into {@link #onInsertComplete}
 * @param uri the Uri passed to the insert operation.
 * @param initialValues the ContentValues parameter passed to the insert operation.
 * @apiSince 1
 */

public final void startInsert(int token, java.lang.Object cookie, android.net.Uri uri, android.content.ContentValues initialValues) { throw new RuntimeException("Stub!"); }

/**
 * This method begins an asynchronous update. When the update operation is
 * done {@link #onUpdateComplete} is called.
 *
 * @param token A token passed into {@link #onUpdateComplete} to identify
 *  the update operation.
 * @param cookie An object that gets passed into {@link #onUpdateComplete}
 * @param uri the Uri passed to the update operation.
 * @param values the ContentValues parameter passed to the update operation.
 * @apiSince 1
 */

public final void startUpdate(int token, java.lang.Object cookie, android.net.Uri uri, android.content.ContentValues values, java.lang.String selection, java.lang.String[] selectionArgs) { throw new RuntimeException("Stub!"); }

/**
 * This method begins an asynchronous delete. When the delete operation is
 * done {@link #onDeleteComplete} is called.
 *
 * @param token A token passed into {@link #onDeleteComplete} to identify
 *  the delete operation.
 * @param cookie An object that gets passed into {@link #onDeleteComplete}
 * @param uri the Uri passed to the delete operation.
 * @param selection the where clause.
 * @apiSince 1
 */

public final void startDelete(int token, java.lang.Object cookie, android.net.Uri uri, java.lang.String selection, java.lang.String[] selectionArgs) { throw new RuntimeException("Stub!"); }

/**
 * Called when an asynchronous query is completed.
 *
 * @param token the token to identify the query, passed in from
 *            {@link #startQuery}.
 * @param cookie the cookie object passed in from {@link #startQuery}.
 * @param cursor The cursor holding the results from the query.
 * @apiSince 1
 */

protected void onQueryComplete(int token, java.lang.Object cookie, android.database.Cursor cursor) { throw new RuntimeException("Stub!"); }

/**
 * Called when an asynchronous insert is completed.
 *
 * @param token the token to identify the query, passed in from
 *        {@link #startInsert}.
 * @param cookie the cookie object that's passed in from
 *        {@link #startInsert}.
 * @param uri the uri returned from the insert operation.
 * @apiSince 1
 */

protected void onInsertComplete(int token, java.lang.Object cookie, android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Called when an asynchronous update is completed.
 *
 * @param token the token to identify the query, passed in from
 *        {@link #startUpdate}.
 * @param cookie the cookie object that's passed in from
 *        {@link #startUpdate}.
 * @param result the result returned from the update operation
 * @apiSince 1
 */

protected void onUpdateComplete(int token, java.lang.Object cookie, int result) { throw new RuntimeException("Stub!"); }

/**
 * Called when an asynchronous delete is completed.
 *
 * @param token the token to identify the query, passed in from
 *        {@link #startDelete}.
 * @param cookie the cookie object that's passed in from
 *        {@link #startDelete}.
 * @param result the result returned from the delete operation
 * @apiSince 1
 */

protected void onDeleteComplete(int token, java.lang.Object cookie, int result) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void handleMessage(android.os.Message msg) { throw new RuntimeException("Stub!"); }
/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
protected static final class WorkerArgs {

protected WorkerArgs() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.Object cookie;

/** @apiSince 1 */

public android.os.Handler handler;

/** @apiSince 1 */

public java.lang.String orderBy;

/** @apiSince 1 */

public java.lang.String[] projection;

/** @apiSince 1 */

public java.lang.Object result;

/** @apiSince 1 */

public java.lang.String selection;

/** @apiSince 1 */

public java.lang.String[] selectionArgs;

/** @apiSince 1 */

public android.net.Uri uri;

/** @apiSince 1 */

public android.content.ContentValues values;
}

/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
protected class WorkerHandler extends android.os.Handler {

public WorkerHandler(android.os.Looper looper) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void handleMessage(android.os.Message msg) { throw new RuntimeException("Stub!"); }
}

}

