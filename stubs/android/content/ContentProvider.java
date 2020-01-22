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


package android.content;

import android.net.Uri;
import android.os.Binder;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Bundle;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.os.storage.StorageManager;
import java.io.FileNotFoundException;
import android.os.ParcelFileDescriptor;
import java.io.File;
import android.content.res.AssetFileDescriptor;
import java.io.PrintWriter;

/**
 * Content providers are one of the primary building blocks of Android applications, providing
 * content to applications. They encapsulate data and provide it to applications through the single
 * {@link android.content.ContentResolver ContentResolver} interface. A content provider is only required if you need to share
 * data between multiple applications. For example, the contacts data is used by multiple
 * applications and must be stored in a content provider. If you don't need to share data amongst
 * multiple applications you can use a database directly via
 * {@link android.database.sqlite.SQLiteDatabase}.
 *
 * <p>When a request is made via
 * a {@link android.content.ContentResolver ContentResolver} the system inspects the authority of the given URI and passes the
 * request to the content provider registered with the authority. The content provider can interpret
 * the rest of the URI however it wants. The {@link android.content.UriMatcher UriMatcher} class is helpful for parsing
 * URIs.</p>
 *
 * <p>The primary methods that need to be implemented are:
 * <ul>
 *   <li>{@link #onCreate} which is called to initialize the provider</li>
 *   <li>{@link #query} which returns data to the caller</li>
 *   <li>{@link #insert} which inserts new data into the content provider</li>
 *   <li>{@link #update} which updates existing data in the content provider</li>
 *   <li>{@link #delete} which deletes data from the content provider</li>
 *   <li>{@link #getType} which returns the MIME type of data in the content provider</li>
 * </ul></p>
 *
 * <p class="caution">Data access methods (such as {@link #insert} and
 * {@link #update}) may be called from many threads at once, and must be thread-safe.
 * Other methods (such as {@link #onCreate}) are only called from the application
 * main thread, and must avoid performing lengthy operations.  See the method
 * descriptions for their expected thread behavior.</p>
 *
 * <p>Requests to {@link android.content.ContentResolver ContentResolver} are automatically forwarded to the appropriate
 * ContentProvider instance, so subclasses don't have to worry about the details of
 * cross-process calls.</p>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about using content providers, read the
 * <a href="{@docRoot}guide/topics/providers/content-providers.html">Content Providers</a>
 * developer guide.</p>
 * </div>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class ContentProvider implements android.content.ComponentCallbacks2 {

/**
 * Construct a ContentProvider instance.  Content providers must be
 * <a href="{@docRoot}guide/topics/manifest/provider-element.html">declared
 * in the manifest</a>, accessed with {@link android.content.ContentResolver ContentResolver}, and created
 * automatically by the system, so applications usually do not create
 * ContentProvider instances directly.
 *
 * <p>At construction time, the object is uninitialized, and most fields and
 * methods are unavailable.  Subclasses should initialize themselves in
 * {@link #onCreate}, not the constructor.
 *
 * <p>Content providers are created on the application main thread at
 * application launch time.  The constructor must not perform lengthy
 * operations, or application startup will be delayed.
 * @apiSince 1
 */

public ContentProvider() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the Context this provider is running in.  Only available once
 * {@link #onCreate} has been called -- this will return {@code null} in the
 * constructor.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public final android.content.Context getContext() { throw new RuntimeException("Stub!"); }

/**
 * Return the package name of the caller that initiated the request being
 * processed on the current thread. The returned package will have been
 * verified to belong to the calling UID. Returns {@code null} if not
 * currently processing a request.
 * <p>
 * This will always return {@code null} when processing
 * {@link #getType(android.net.Uri)} or {@link #getStreamTypes(android.net.Uri,java.lang.String)} requests.
 *
 * @see android.os.Binder#getCallingUid()
 * @see android.content.Context#grantUriPermission(String, Uri, int)
 * @throws java.lang.SecurityException if the calling package doesn't belong to the
 *             calling UID.
 * @apiSince 19
 */

@androidx.annotation.Nullable
public final java.lang.String getCallingPackage() { throw new RuntimeException("Stub!"); }

/**
 * Reset the identity of the incoming IPC on the current thread.
 * <p>
 * Internally this calls {@link android.os.Binder#clearCallingIdentity() Binder#clearCallingIdentity()} and also
 * clears any value stored in {@link #getCallingPackage()}.
 *
 * @return Returns an opaque token that can be used to restore the original
 *         calling identity by passing it to
 *         {@link #restoreCallingIdentity}.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public final android.content.ContentProvider.CallingIdentity clearCallingIdentity() { throw new RuntimeException("Stub!"); }

/**
 * Restore the identity of the incoming IPC on the current thread back to a
 * previously identity that was returned by {@link #clearCallingIdentity}.
 * <p>
 * Internally this calls {@link android.os.Binder#restoreCallingIdentity(long) Binder#restoreCallingIdentity(long)} and
 * also restores any value stored in {@link #getCallingPackage()}.
 
 * @param identity This value must never be {@code null}.
 * @apiSince 29
 */

public final void restoreCallingIdentity(@androidx.annotation.NonNull android.content.ContentProvider.CallingIdentity identity) { throw new RuntimeException("Stub!"); }

/**
 * Change the permission required to read data from the content
 * provider.  This is normally set for you from its manifest information
 * when the provider is first created.
 *
 * @param permission Name of the permission required for read-only access.
 
 * This value may be {@code null}.
 * @apiSince 1
 */

protected final void setReadPermission(@androidx.annotation.Nullable java.lang.String permission) { throw new RuntimeException("Stub!"); }

/**
 * Return the name of the permission required for read-only access to
 * this content provider.  This method can be called from multiple
 * threads, as described in
 * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html#Threads">Processes
 * and Threads</a>.
 
 * @return This value may be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public final java.lang.String getReadPermission() { throw new RuntimeException("Stub!"); }

/**
 * Change the permission required to read and write data in the content
 * provider.  This is normally set for you from its manifest information
 * when the provider is first created.
 *
 * @param permission Name of the permission required for read/write access.
 
 * This value may be {@code null}.
 * @apiSince 1
 */

protected final void setWritePermission(@androidx.annotation.Nullable java.lang.String permission) { throw new RuntimeException("Stub!"); }

/**
 * Return the name of the permission required for read/write access to
 * this content provider.  This method can be called from multiple
 * threads, as described in
 * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html#Threads">Processes
 * and Threads</a>.
 
 * @return This value may be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public final java.lang.String getWritePermission() { throw new RuntimeException("Stub!"); }

/**
 * Change the path-based permission required to read and/or write data in
 * the content provider.  This is normally set for you from its manifest
 * information when the provider is first created.
 *
 * @param permissions Array of path permission descriptions.
 
 * This value may be {@code null}.
 * @apiSince 4
 */

protected final void setPathPermissions(@androidx.annotation.Nullable android.content.pm.PathPermission[] permissions) { throw new RuntimeException("Stub!"); }

/**
 * Return the path-based permissions required for read and/or write access to
 * this content provider.  This method can be called from multiple
 * threads, as described in
 * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html#Threads">Processes
 * and Threads</a>.
 
 * @return This value may be {@code null}.
 * @apiSince 4
 */

@androidx.annotation.Nullable
public final android.content.pm.PathPermission[] getPathPermissions() { throw new RuntimeException("Stub!"); }

/**
 * Implement this to initialize your content provider on startup.
 * This method is called for all registered content providers on the
 * application main thread at application launch time.  It must not perform
 * lengthy operations, or application startup will be delayed.
 *
 * <p>You should defer nontrivial initialization (such as opening,
 * upgrading, and scanning databases) until the content provider is used
 * (via {@link #query}, {@link #insert}, etc).  Deferred initialization
 * keeps application startup fast, avoids unnecessary work if the provider
 * turns out not to be needed, and stops database errors (such as a full
 * disk) from halting application launch.
 *
 * <p>If you use SQLite, {@link android.database.sqlite.SQLiteOpenHelper}
 * is a helpful utility class that makes it easy to manage databases,
 * and will automatically defer opening until first use.  If you do use
 * SQLiteOpenHelper, make sure to avoid calling
 * {@link android.database.sqlite.SQLiteOpenHelper#getReadableDatabase} or
 * {@link android.database.sqlite.SQLiteOpenHelper#getWritableDatabase}
 * from this method.  (Instead, override
 * {@link android.database.sqlite.SQLiteOpenHelper#onOpen} to initialize the
 * database when it is first opened.)
 *
 * @return true if the provider was successfully loaded, false otherwise
 * @apiSince 1
 */

public abstract boolean onCreate();

/**
 * {@inheritDoc}
 * This method is always called on the application main thread, and must
 * not perform lengthy operations.
 *
 * <p>The default content provider implementation does nothing.
 * Override this method to take appropriate action.
 * (Content providers do not usually care about things like screen
 * orientation, but may want to know about locale changes.)
 * @apiSince 1
 */

public void onConfigurationChanged(android.content.res.Configuration newConfig) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * This method is always called on the application main thread, and must
 * not perform lengthy operations.
 *
 * <p>The default content provider implementation does nothing.
 * Subclasses may override this method to take appropriate action.
 * @apiSince 1
 */

public void onLowMemory() { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public void onTrimMemory(int level) { throw new RuntimeException("Stub!"); }

/**
 * Implement this to handle query requests from clients.
 *
 * <p>Apps targeting {@link android.os.Build.VERSION_CODES#O} or higher should override
 * {@link #query(android.net.Uri,java.lang.String[],android.os.Bundle,android.os.CancellationSignal)} and provide a stub
 * implementation of this method.
 *
 * <p>This method can be called from multiple threads, as described in
 * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html#Threads">Processes
 * and Threads</a>.
 * <p>
 * Example client call:<p>
 * <pre>// Request a specific record.
 * Cursor managedCursor = managedQuery(
      ContentUris.withAppendedId(Contacts.People.CONTENT_URI, 2),
      projection,    // Which columns to return.
      null,          // WHERE clause.
      null,          // WHERE clause value substitution
      People.NAME + " ASC");   // Sort order.</pre>
 * Example implementation:<p>
 * <pre>// SQLiteQueryBuilder is a helper class that creates the
 // proper SQL syntax for us.
 SQLiteQueryBuilder qBuilder = new SQLiteQueryBuilder();
 
 // Set the table we're querying.
 qBuilder.setTables(DATABASE_TABLE_NAME);
 
 // If the query ends in a specific record number, we're
 // being asked for a specific record, so set the
 // WHERE clause in our query.
 if((URI_MATCHER.match(uri)) == SPECIFIC_MESSAGE){
  qBuilder.appendWhere("_id=" + uri.getPathLeafId());
 }
 
 // Make the query.
 Cursor c = qBuilder.query(mDb,
      projection,
      selection,
      selectionArgs,
      groupBy,
      having,
      sortOrder);
 c.setNotificationUri(getContext().getContentResolver(), uri);
 return c;</pre>
 *
 * @param uri The URI to query. This will be the full URI sent by the client;
 *      if the client is requesting a specific record, the URI will end in a record number
 *      that the implementation should parse and add to a WHERE or HAVING clause, specifying
 *      that _id value.
 * This value must never be {@code null}.
 * @param projection The list of columns to put into the cursor. If
 *      {@code null} all columns are included.
 * This value may be {@code null}.
 * @param selection A selection criteria to apply when filtering rows.
 *      If {@code null} then all rows are included.
 * This value may be {@code null}.
 * @param selectionArgs You may include ?s in selection, which will be replaced by
 *      the values from selectionArgs, in order that they appear in the selection.
 *      The values will be bound as Strings.
 * This value may be {@code null}.
 * @param sortOrder How the rows in the cursor should be sorted.
 *      If {@code null} then the provider is free to define the sort order.
 * This value may be {@code null}.
 * @return a Cursor or {@code null}.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public abstract android.database.Cursor query(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable java.lang.String[] projection, @androidx.annotation.Nullable java.lang.String selection, @androidx.annotation.Nullable java.lang.String[] selectionArgs, @androidx.annotation.Nullable java.lang.String sortOrder);

/**
 * Implement this to handle query requests from clients with support for cancellation.
 *
 * <p>Apps targeting {@link android.os.Build.VERSION_CODES#O} or higher should override
 * {@link #query(android.net.Uri,java.lang.String[],android.os.Bundle,android.os.CancellationSignal)} instead of this method.
 *
 * <p>This method can be called from multiple threads, as described in
 * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html#Threads">Processes
 * and Threads</a>.
 * <p>
 * Example client call:<p>
 * <pre>// Request a specific record.
 * Cursor managedCursor = managedQuery(
     ContentUris.withAppendedId(Contacts.People.CONTENT_URI, 2),
     projection,    // Which columns to return.
     null,          // WHERE clause.
     null,          // WHERE clause value substitution
     People.NAME + " ASC");   // Sort order.</pre>
 * Example implementation:<p>
 * <pre>// SQLiteQueryBuilder is a helper class that creates the
 // proper SQL syntax for us.
 SQLiteQueryBuilder qBuilder = new SQLiteQueryBuilder();
 
 // Set the table we're querying.
 qBuilder.setTables(DATABASE_TABLE_NAME);
 
 // If the query ends in a specific record number, we're
 // being asked for a specific record, so set the
 // WHERE clause in our query.
 if((URI_MATCHER.match(uri)) == SPECIFIC_MESSAGE){
 qBuilder.appendWhere("_id=" + uri.getPathLeafId());
 }
 
 // Make the query.
 Cursor c = qBuilder.query(mDb,
     projection,
     selection,
     selectionArgs,
     groupBy,
     having,
     sortOrder);
 c.setNotificationUri(getContext().getContentResolver(), uri);
 return c;</pre>
 * <p>
 * If you implement this method then you must also implement the version of
 * {@link #query(android.net.Uri,java.lang.String[],java.lang.String,java.lang.String[],java.lang.String)} that does not take a cancellation
 * signal to ensure correct operation on older versions of the Android Framework in
 * which the cancellation signal overload was not available.
 *
 * @param uri The URI to query. This will be the full URI sent by the client;
 *      if the client is requesting a specific record, the URI will end in a record number
 *      that the implementation should parse and add to a WHERE or HAVING clause, specifying
 *      that _id value.
 * This value must never be {@code null}.
 * @param projection The list of columns to put into the cursor. If
 *      {@code null} all columns are included.
 * This value may be {@code null}.
 * @param selection A selection criteria to apply when filtering rows.
 *      If {@code null} then all rows are included.
 * This value may be {@code null}.
 * @param selectionArgs You may include ?s in selection, which will be replaced by
 *      the values from selectionArgs, in order that they appear in the selection.
 *      The values will be bound as Strings.
 * This value may be {@code null}.
 * @param sortOrder How the rows in the cursor should be sorted.
 *      If {@code null} then the provider is free to define the sort order.
 * This value may be {@code null}.
 * @param cancellationSignal A signal to cancel the operation in progress, or {@code null} if none.
 * If the operation is canceled, then {@link android.os.OperationCanceledException} will be thrown
 * when the query is executed.
 * This value may be {@code null}.
 * @return a Cursor or {@code null}.
 * @apiSince 16
 */

@androidx.annotation.Nullable
public android.database.Cursor query(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable java.lang.String[] projection, @androidx.annotation.Nullable java.lang.String selection, @androidx.annotation.Nullable java.lang.String[] selectionArgs, @androidx.annotation.Nullable java.lang.String sortOrder, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal) { throw new RuntimeException("Stub!"); }

/**
 * Implement this to handle query requests where the arguments are packed into a {@link android.os.Bundle Bundle}.
 * Arguments may include traditional SQL style query arguments. When present these
 * should be handled  according to the contract established in
 * {@link #query(android.net.Uri,java.lang.String[],java.lang.String,java.lang.String[],java.lang.String,android.os.CancellationSignal)}.
 *
 * <p>Traditional SQL arguments can be found in the bundle using the following keys:
 * <li>{@link android.content.ContentResolver#QUERY_ARG_SQL_SELECTION}
 * <li>{@link android.content.ContentResolver#QUERY_ARG_SQL_SELECTION_ARGS}
 * <li>{@link android.content.ContentResolver#QUERY_ARG_SQL_SORT_ORDER}
 *
 * <p>This method can be called from multiple threads, as described in
 * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html#Threads">Processes
 * and Threads</a>.
 *
 * <p>
 * Example client call:<p>
 * <pre>// Request 20 records starting at row index 30.
 Bundle queryArgs = new Bundle();
 queryArgs.putInt(ContentResolver.QUERY_ARG_OFFSET, 30);
 queryArgs.putInt(ContentResolver.QUERY_ARG_LIMIT, 20);
 
 Cursor cursor = getContentResolver().query(
       contentUri,    // Content Uri is specific to individual content providers.
       projection,    // String[] describing which columns to return.
       queryArgs,     // Query arguments.
       null);         // Cancellation signal.</pre>
 *
 * Example implementation:<p>
 * <pre>
 
 int recordsetSize = 0x1000;  // Actual value is implementation specific.
 queryArgs = queryArgs != null ? queryArgs : Bundle.EMPTY;  // ensure queryArgs is non-null
 
 int offset = queryArgs.getInt(ContentResolver.QUERY_ARG_OFFSET, 0);
 int limit = queryArgs.getInt(ContentResolver.QUERY_ARG_LIMIT, Integer.MIN_VALUE);
 
 MatrixCursor c = new MatrixCursor(PROJECTION, limit);
 
 // Calculate the number of items to include in the cursor.
 int numItems = MathUtils.constrain(recordsetSize - offset, 0, limit);
 
 // Build the paged result set....
 for (int i = offset; i < offset + numItems; i++) {
   // populate row from your data.
 }
 
 Bundle extras = new Bundle();
 c.setExtras(extras);
 
 // Any QUERY_ARG_* key may be included if honored.
 // In an actual implementation, include only keys that are both present in queryArgs
 // and reflected in the Cursor output. For example, if QUERY_ARG_OFFSET were included
 // in queryArgs, but was ignored because it contained an invalid value (like –273),
 // then QUERY_ARG_OFFSET should be omitted.
 extras.putStringArray(ContentResolver.EXTRA_HONORED_ARGS, new String[] {
   ContentResolver.QUERY_ARG_OFFSET,
   ContentResolver.QUERY_ARG_LIMIT
 });
 
 extras.putInt(ContentResolver.EXTRA_TOTAL_COUNT, recordsetSize);
 
 cursor.setNotificationUri(getContext().getContentResolver(), uri);
 
 return cursor;</pre>
 * <p>
 * See {@link #query(android.net.Uri,java.lang.String[],java.lang.String,java.lang.String[],java.lang.String,android.os.CancellationSignal)}
 * for implementation details.
 *
 * @param uri The URI to query. This will be the full URI sent by the client.
 * This value must never be {@code null}.
 * @param projection The list of columns to put into the cursor.
 *            If {@code null} provide a default set of columns.
 * This value may be {@code null}.
 * @param queryArgs A Bundle containing all additional information necessary for the query.
 *            Values in the Bundle may include SQL style arguments.
 * This value may be {@code null}.
 * @param cancellationSignal A signal to cancel the operation in progress,
 *            or {@code null}.
 * This value may be {@code null}.
 * @return a Cursor or {@code null}.
 * @apiSince 26
 */

@androidx.annotation.Nullable
public android.database.Cursor query(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable java.lang.String[] projection, @androidx.annotation.Nullable android.os.Bundle queryArgs, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal) { throw new RuntimeException("Stub!"); }

/**
 * Implement this to handle requests for the MIME type of the data at the
 * given URI.  The returned MIME type should start with
 * <code>vnd.android.cursor.item</code> for a single record,
 * or <code>vnd.android.cursor.dir/</code> for multiple items.
 * This method can be called from multiple threads, as described in
 * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html#Threads">Processes
 * and Threads</a>.
 *
 * <p>Note that there are no permissions needed for an application to
 * access this information; if your content provider requires read and/or
 * write permissions, or is not exported, all applications can still call
 * this method regardless of their access permissions.  This allows them
 * to retrieve the MIME type for a URI when dispatching intents.
 *
 * @param uri the URI to query.
 * This value must never be {@code null}.
 * @return a MIME type string, or {@code null} if there is no type.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public abstract java.lang.String getType(@androidx.annotation.NonNull android.net.Uri uri);

/**
 * Implement this to support canonicalization of URIs that refer to your
 * content provider.  A canonical URI is one that can be transported across
 * devices, backup/restore, and other contexts, and still be able to refer
 * to the same data item.  Typically this is implemented by adding query
 * params to the URI allowing the content provider to verify that an incoming
 * canonical URI references the same data as it was originally intended for and,
 * if it doesn't, to find that data (if it exists) in the current environment.
 *
 * <p>For example, if the content provider holds people and a normal URI in it
 * is created with a row index into that people database, the cananical representation
 * may have an additional query param at the end which specifies the name of the
 * person it is intended for.  Later calls into the provider with that URI will look
 * up the row of that URI's base index and, if it doesn't match or its entry's
 * name doesn't match the name in the query param, perform a query on its database
 * to find the correct row to operate on.</p>
 *
 * <p>If you implement support for canonical URIs, <b>all</b> incoming calls with
 * URIs (including this one) must perform this verification and recovery of any
 * canonical URIs they receive.  In addition, you must also implement
 * {@link #uncanonicalize} to strip the canonicalization of any of these URIs.</p>
 *
 * <p>The default implementation of this method returns null, indicating that
 * canonical URIs are not supported.</p>
 *
 * @param url The Uri to canonicalize.
 *
 * This value must never be {@code null}.
 * @return Return the canonical representation of <var>url</var>, or null if
 * canonicalization of that Uri is not supported.
 * @apiSince 19
 */

@androidx.annotation.Nullable
public android.net.Uri canonicalize(@androidx.annotation.NonNull android.net.Uri url) { throw new RuntimeException("Stub!"); }

/**
 * Remove canonicalization from canonical URIs previously returned by
 * {@link #canonicalize}.  For example, if your implementation is to add
 * a query param to canonicalize a URI, this method can simply trip any
 * query params on the URI.  The default implementation always returns the
 * same <var>url</var> that was passed in.
 *
 * @param url The Uri to remove any canonicalization from.
 *
 * This value must never be {@code null}.
 * @return Return the non-canonical representation of <var>url</var>, return
 * the <var>url</var> as-is if there is nothing to do, or return null if
 * the data identified by the canonical representation can not be found in
 * the current environment.
 * @apiSince 19
 */

@androidx.annotation.Nullable
public android.net.Uri uncanonicalize(@androidx.annotation.NonNull android.net.Uri url) { throw new RuntimeException("Stub!"); }

/**
 * Implement this to support refresh of content identified by {@code uri}. By default, this
 * method returns false; providers who wish to implement this should return true to signal the
 * client that the provider has tried refreshing with its own implementation.
 * <p>
 * This allows clients to request an explicit refresh of content identified by {@code uri}.
 * <p>
 * Client code should only invoke this method when there is a strong indication (such as a user
 * initiated pull to refresh gesture) that the content is stale.
 * <p>
 * Remember to send {@link android.content.ContentResolver#notifyChange(android.net.Uri,android.database.ContentObserver) ContentResolver#notifyChange(Uri, android.database.ContentObserver)}
 * notifications when content changes.
 *
 * @param uri The Uri identifying the data to refresh.
 * @param args Additional options from the client. The definitions of these are specific to the
 *            content provider being called.
 * This value may be {@code null}.
 * @param cancellationSignal A signal to cancel the operation in progress, or {@code null} if
 *            none. For example, if you called refresh on a particular uri, you should call
 *            {@link android.os.CancellationSignal#throwIfCanceled() CancellationSignal#throwIfCanceled()} to check whether the client has
 *            canceled the refresh request.
 * This value may be {@code null}.
 * @return true if the provider actually tried refreshing.
 * @apiSince 26
 */

public boolean refresh(android.net.Uri uri, @androidx.annotation.Nullable android.os.Bundle args, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal) { throw new RuntimeException("Stub!"); }

/**
 * Implement this to handle requests to insert a new row.
 * As a courtesy, call {@link android.content.ContentResolver#notifyChange(android.net.Uri,android.database.ContentObserver) ContentResolver#notifyChange(android.net.Uri ,android.database.ContentObserver)}
 * after inserting.
 * This method can be called from multiple threads, as described in
 * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html#Threads">Processes
 * and Threads</a>.
 * @param uri The content:// URI of the insertion request. This must not be {@code null}.
 * This value must never be {@code null}.
 * @param values A set of column_name/value pairs to add to the database.
 *     This must not be {@code null}.
 * This value may be {@code null}.
 * @return The URI for the newly inserted item.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public abstract android.net.Uri insert(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable android.content.ContentValues values);

/**
 * Override this to handle requests to insert a set of new rows, or the
 * default implementation will iterate over the values and call
 * {@link #insert} on each of them.
 * As a courtesy, call {@link android.content.ContentResolver#notifyChange(android.net.Uri,android.database.ContentObserver) ContentResolver#notifyChange(android.net.Uri ,android.database.ContentObserver)}
 * after inserting.
 * This method can be called from multiple threads, as described in
 * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html#Threads">Processes
 * and Threads</a>.
 *
 * @param uri The content:// URI of the insertion request.
 * This value must never be {@code null}.
 * @param values An array of sets of column_name/value pairs to add to the database.
 *    This must not be {@code null}.
 * This value must never be {@code null}.
 * @return The number of values that were inserted.
 * @apiSince 1
 */

public int bulkInsert(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.NonNull android.content.ContentValues[] values) { throw new RuntimeException("Stub!"); }

/**
 * Implement this to handle requests to delete one or more rows.
 * The implementation should apply the selection clause when performing
 * deletion, allowing the operation to affect multiple rows in a directory.
 * As a courtesy, call {@link android.content.ContentResolver#notifyChange(android.net.Uri,android.database.ContentObserver) ContentResolver#notifyChange(android.net.Uri ,android.database.ContentObserver)}
 * after deleting.
 * This method can be called from multiple threads, as described in
 * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html#Threads">Processes
 * and Threads</a>.
 *
 * <p>The implementation is responsible for parsing out a row ID at the end
 * of the URI, if a specific row is being deleted. That is, the client would
 * pass in <code>content://contacts/people/22</code> and the implementation is
 * responsible for parsing the record number (22) when creating a SQL statement.
 *
 * @param uri The full URI to query, including a row ID (if a specific record is requested).
 * This value must never be {@code null}.
 * @param selection An optional restriction to apply to rows when deleting.
 * This value may be {@code null}.
 * @param selectionArgs This value may be {@code null}.
 * @return The number of rows affected.
 * @throws android.database.SQLException
 * @apiSince 1
 */

public abstract int delete(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable java.lang.String selection, @androidx.annotation.Nullable java.lang.String[] selectionArgs);

/**
 * Implement this to handle requests to update one or more rows.
 * The implementation should update all rows matching the selection
 * to set the columns according to the provided values map.
 * As a courtesy, call {@link android.content.ContentResolver#notifyChange(android.net.Uri,android.database.ContentObserver) ContentResolver#notifyChange(android.net.Uri ,android.database.ContentObserver)}
 * after updating.
 * This method can be called from multiple threads, as described in
 * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html#Threads">Processes
 * and Threads</a>.
 *
 * @param uri The URI to query. This can potentially have a record ID if this
 * is an update request for a specific record.
 * This value must never be {@code null}.
 * @param values A set of column_name/value pairs to update in the database.
 *     This must not be {@code null}.
 * This value may be {@code null}.
 * @param selection An optional filter to match rows to update.
 * This value may be {@code null}.
 * @param selectionArgs This value may be {@code null}.
 * @return the number of rows affected.
 * @apiSince 1
 */

public abstract int update(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable android.content.ContentValues values, @androidx.annotation.Nullable java.lang.String selection, @androidx.annotation.Nullable java.lang.String[] selectionArgs);

/**
 * Override this to handle requests to open a file blob.
 * The default implementation always throws {@link java.io.FileNotFoundException FileNotFoundException}.
 * This method can be called from multiple threads, as described in
 * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html#Threads">Processes
 * and Threads</a>.
 *
 * <p>This method returns a ParcelFileDescriptor, which is returned directly
 * to the caller.  This way large data (such as images and documents) can be
 * returned without copying the content.
 *
 * <p>The returned ParcelFileDescriptor is owned by the caller, so it is
 * their responsibility to close it when done.  That is, the implementation
 * of this method should create a new ParcelFileDescriptor for each call.
 * <p>
 * If opened with the exclusive "r" or "w" modes, the returned
 * ParcelFileDescriptor can be a pipe or socket pair to enable streaming
 * of data. Opening with the "rw" or "rwt" modes implies a file on disk that
 * supports seeking.
 * <p>
 * If you need to detect when the returned ParcelFileDescriptor has been
 * closed, or if the remote process has crashed or encountered some other
 * error, you can use {@link android.os.ParcelFileDescriptor#open(java.io.File,int,android.os.Handler,android.os.ParcelFileDescriptor.OnCloseListener) ParcelFileDescriptor#open(File, int,
 * android.os.Handler, android.os.ParcelFileDescriptor.OnCloseListener)},
 * {@link android.os.ParcelFileDescriptor#createReliablePipe() ParcelFileDescriptor#createReliablePipe()}, or
 * {@link android.os.ParcelFileDescriptor#createReliableSocketPair() ParcelFileDescriptor#createReliableSocketPair()}.
 * <p>
 * If you need to return a large file that isn't backed by a real file on
 * disk, such as a file on a network share or cloud storage service,
 * consider using
 * {@link android.os.storage.StorageManager#openProxyFileDescriptor(int,android.os.ProxyFileDescriptorCallback,android.os.Handler) StorageManager#openProxyFileDescriptor(int, android.os.ProxyFileDescriptorCallback, android.os.Handler)}
 * which will let you to stream the content on-demand.
 *
 * <p class="note">For use in Intents, you will want to implement {@link #getType}
 * to return the appropriate MIME type for the data returned here with
 * the same URI.  This will allow intent resolution to automatically determine the data MIME
 * type and select the appropriate matching targets as part of its operation.</p>
 *
 * <p class="note">For better interoperability with other applications, it is recommended
 * that for any URIs that can be opened, you also support queries on them
 * containing at least the columns specified by {@link android.provider.OpenableColumns}.
 * You may also want to support other common columns if you have additional meta-data
 * to supply, such as {@link android.provider.MediaStore.MediaColumns#DATE_ADDED}
 * in {@link android.provider.MediaStore.MediaColumns}.</p>
 *
 * @param uri The URI whose file is to be opened.
 * This value must never be {@code null}.
 * @param mode Access mode for the file.  May be "r" for read-only access,
 * "rw" for read and write access, or "rwt" for read and write access
 * that truncates any existing file.
 *
 * This value must never be {@code null}.
 * @return Returns a new ParcelFileDescriptor which you can use to access
 * the file.
 *
 * This value may be {@code null}.
 * @throws java.io.FileNotFoundException Throws FileNotFoundException if there is
 * no file associated with the given URI or the mode is invalid.
 * @throws java.lang.SecurityException Throws SecurityException if the caller does
 * not have permission to access the file.
 *
 * @see #openAssetFile(Uri, String)
 * @see #openFileHelper(Uri, String)
 * @see #getType(android.net.Uri)
 * @see android.os.ParcelFileDescriptor#parseMode(String)
 * @apiSince 1
 */

@androidx.annotation.Nullable
public android.os.ParcelFileDescriptor openFile(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.NonNull java.lang.String mode) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Override this to handle requests to open a file blob.
 * The default implementation always throws {@link java.io.FileNotFoundException FileNotFoundException}.
 * This method can be called from multiple threads, as described in
 * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html#Threads">Processes
 * and Threads</a>.
 *
 * <p>This method returns a ParcelFileDescriptor, which is returned directly
 * to the caller.  This way large data (such as images and documents) can be
 * returned without copying the content.
 *
 * <p>The returned ParcelFileDescriptor is owned by the caller, so it is
 * their responsibility to close it when done.  That is, the implementation
 * of this method should create a new ParcelFileDescriptor for each call.
 * <p>
 * If opened with the exclusive "r" or "w" modes, the returned
 * ParcelFileDescriptor can be a pipe or socket pair to enable streaming
 * of data. Opening with the "rw" or "rwt" modes implies a file on disk that
 * supports seeking.
 * <p>
 * If you need to detect when the returned ParcelFileDescriptor has been
 * closed, or if the remote process has crashed or encountered some other
 * error, you can use {@link android.os.ParcelFileDescriptor#open(java.io.File,int,android.os.Handler,android.os.ParcelFileDescriptor.OnCloseListener) ParcelFileDescriptor#open(File, int,
 * android.os.Handler, android.os.ParcelFileDescriptor.OnCloseListener)},
 * {@link android.os.ParcelFileDescriptor#createReliablePipe() ParcelFileDescriptor#createReliablePipe()}, or
 * {@link android.os.ParcelFileDescriptor#createReliableSocketPair() ParcelFileDescriptor#createReliableSocketPair()}.
 *
 * <p class="note">For use in Intents, you will want to implement {@link #getType}
 * to return the appropriate MIME type for the data returned here with
 * the same URI.  This will allow intent resolution to automatically determine the data MIME
 * type and select the appropriate matching targets as part of its operation.</p>
 *
 * <p class="note">For better interoperability with other applications, it is recommended
 * that for any URIs that can be opened, you also support queries on them
 * containing at least the columns specified by {@link android.provider.OpenableColumns}.
 * You may also want to support other common columns if you have additional meta-data
 * to supply, such as {@link android.provider.MediaStore.MediaColumns#DATE_ADDED}
 * in {@link android.provider.MediaStore.MediaColumns}.</p>
 *
 * @param uri The URI whose file is to be opened.
 * This value must never be {@code null}.
 * @param mode Access mode for the file. May be "r" for read-only access,
 *            "w" for write-only access, "rw" for read and write access, or
 *            "rwt" for read and write access that truncates any existing
 *            file.
 * This value must never be {@code null}.
 * @param signal A signal to cancel the operation in progress, or
 *            {@code null} if none. For example, if you are downloading a
 *            file from the network to service a "rw" mode request, you
 *            should periodically call
 *            {@link android.os.CancellationSignal#throwIfCanceled() CancellationSignal#throwIfCanceled()} to check whether
 *            the client has canceled the request and abort the download.
 *
 * This value may be {@code null}.
 * @return Returns a new ParcelFileDescriptor which you can use to access
 * the file.
 *
 * @throws java.io.FileNotFoundException Throws FileNotFoundException if there is
 * no file associated with the given URI or the mode is invalid.
 * @throws java.lang.SecurityException Throws SecurityException if the caller does
 * not have permission to access the file.
 *
 * @see #openAssetFile(Uri, String)
 * @see #openFileHelper(Uri, String)
 * @see #getType(android.net.Uri)
 * @see android.os.ParcelFileDescriptor#parseMode(String)
 * @apiSince 19
 */

@androidx.annotation.Nullable
public android.os.ParcelFileDescriptor openFile(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.NonNull java.lang.String mode, @androidx.annotation.Nullable android.os.CancellationSignal signal) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * This is like {@link #openFile}, but can be implemented by providers
 * that need to be able to return sub-sections of files, often assets
 * inside of their .apk.
 * This method can be called from multiple threads, as described in
 * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html#Threads">Processes
 * and Threads</a>.
 *
 * <p>If you implement this, your clients must be able to deal with such
 * file slices, either directly with
 * {@link android.content.ContentResolver#openAssetFileDescriptor ContentResolver#openAssetFileDescriptor}, or by using the higher-level
 * {@link android.content.ContentResolver#openInputStream ContentResolver#openInputStream}
 * or {@link android.content.ContentResolver#openOutputStream ContentResolver#openOutputStream}
 * methods.
 * <p>
 * The returned AssetFileDescriptor can be a pipe or socket pair to enable
 * streaming of data.
 *
 * <p class="note">If you are implementing this to return a full file, you
 * should create the AssetFileDescriptor with
 * {@link android.content.res.AssetFileDescriptor#UNKNOWN_LENGTH AssetFileDescriptor#UNKNOWN_LENGTH} to be compatible with
 * applications that cannot handle sub-sections of files.</p>
 *
 * <p class="note">For use in Intents, you will want to implement {@link #getType}
 * to return the appropriate MIME type for the data returned here with
 * the same URI.  This will allow intent resolution to automatically determine the data MIME
 * type and select the appropriate matching targets as part of its operation.</p>
 *
 * <p class="note">For better interoperability with other applications, it is recommended
 * that for any URIs that can be opened, you also support queries on them
 * containing at least the columns specified by {@link android.provider.OpenableColumns}.</p>
 *
 * @param uri The URI whose file is to be opened.
 * This value must never be {@code null}.
 * @param mode Access mode for the file.  May be "r" for read-only access,
 * "w" for write-only access (erasing whatever data is currently in
 * the file), "wa" for write-only access to append to any existing data,
 * "rw" for read and write access on any existing data, and "rwt" for read
 * and write access that truncates any existing file.
 *
 * This value must never be {@code null}.
 * @return Returns a new AssetFileDescriptor which you can use to access
 * the file.
 *
 * This value may be {@code null}.
 * @throws java.io.FileNotFoundException Throws FileNotFoundException if there is
 * no file associated with the given URI or the mode is invalid.
 * @throws java.lang.SecurityException Throws SecurityException if the caller does
 * not have permission to access the file.
 *
 * @see #openFile(Uri, String)
 * @see #openFileHelper(Uri, String)
 * @see #getType(android.net.Uri)
 * @apiSince 3
 */

@androidx.annotation.Nullable
public android.content.res.AssetFileDescriptor openAssetFile(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.NonNull java.lang.String mode) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * This is like {@link #openFile}, but can be implemented by providers
 * that need to be able to return sub-sections of files, often assets
 * inside of their .apk.
 * This method can be called from multiple threads, as described in
 * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html#Threads">Processes
 * and Threads</a>.
 *
 * <p>If you implement this, your clients must be able to deal with such
 * file slices, either directly with
 * {@link android.content.ContentResolver#openAssetFileDescriptor ContentResolver#openAssetFileDescriptor}, or by using the higher-level
 * {@link android.content.ContentResolver#openInputStream ContentResolver#openInputStream}
 * or {@link android.content.ContentResolver#openOutputStream ContentResolver#openOutputStream}
 * methods.
 * <p>
 * The returned AssetFileDescriptor can be a pipe or socket pair to enable
 * streaming of data.
 *
 * <p class="note">If you are implementing this to return a full file, you
 * should create the AssetFileDescriptor with
 * {@link android.content.res.AssetFileDescriptor#UNKNOWN_LENGTH AssetFileDescriptor#UNKNOWN_LENGTH} to be compatible with
 * applications that cannot handle sub-sections of files.</p>
 *
 * <p class="note">For use in Intents, you will want to implement {@link #getType}
 * to return the appropriate MIME type for the data returned here with
 * the same URI.  This will allow intent resolution to automatically determine the data MIME
 * type and select the appropriate matching targets as part of its operation.</p>
 *
 * <p class="note">For better interoperability with other applications, it is recommended
 * that for any URIs that can be opened, you also support queries on them
 * containing at least the columns specified by {@link android.provider.OpenableColumns}.</p>
 *
 * @param uri The URI whose file is to be opened.
 * This value must never be {@code null}.
 * @param mode Access mode for the file.  May be "r" for read-only access,
 * "w" for write-only access (erasing whatever data is currently in
 * the file), "wa" for write-only access to append to any existing data,
 * "rw" for read and write access on any existing data, and "rwt" for read
 * and write access that truncates any existing file.
 * This value must never be {@code null}.
 * @param signal A signal to cancel the operation in progress, or
 *            {@code null} if none. For example, if you are downloading a
 *            file from the network to service a "rw" mode request, you
 *            should periodically call
 *            {@link android.os.CancellationSignal#throwIfCanceled() CancellationSignal#throwIfCanceled()} to check whether
 *            the client has canceled the request and abort the download.
 *
 * This value may be {@code null}.
 * @return Returns a new AssetFileDescriptor which you can use to access
 * the file.
 *
 * @throws java.io.FileNotFoundException Throws FileNotFoundException if there is
 * no file associated with the given URI or the mode is invalid.
 * @throws java.lang.SecurityException Throws SecurityException if the caller does
 * not have permission to access the file.
 *
 * @see #openFile(Uri, String)
 * @see #openFileHelper(Uri, String)
 * @see #getType(android.net.Uri)
 * @apiSince 19
 */

@androidx.annotation.Nullable
public android.content.res.AssetFileDescriptor openAssetFile(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.NonNull java.lang.String mode, @androidx.annotation.Nullable android.os.CancellationSignal signal) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Convenience for subclasses that wish to implement {@link #openFile}
 * by looking up a column named "_data" at the given URI.
 *
 * @param uri The URI to be opened.
 * This value must never be {@code null}.
 * @param mode The file mode.  May be "r" for read-only access,
 * "w" for write-only access (erasing whatever data is currently in
 * the file), "wa" for write-only access to append to any existing data,
 * "rw" for read and write access on any existing data, and "rwt" for read
 * and write access that truncates any existing file.
 *
 * This value must never be {@code null}.
 * @return Returns a new ParcelFileDescriptor that can be used by the
 * client to access the file.
 
 * This value will never be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.NonNull
protected final android.os.ParcelFileDescriptor openFileHelper(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.NonNull java.lang.String mode) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Called by a client to determine the types of data streams that this
 * content provider supports for the given URI.  The default implementation
 * returns {@code null}, meaning no types.  If your content provider stores data
 * of a particular type, return that MIME type if it matches the given
 * mimeTypeFilter.  If it can perform type conversions, return an array
 * of all supported MIME types that match mimeTypeFilter.
 *
 * @param uri The data in the content provider being queried.
 * This value must never be {@code null}.
 * @param mimeTypeFilter The type of data the client desires.  May be
 * a pattern, such as *&#47;* to retrieve all possible data types.
 * This value must never be {@code null}.
 * @return Returns {@code null} if there are no possible data streams for the
 * given mimeTypeFilter.  Otherwise returns an array of all available
 * concrete MIME types.
 *
 * @see #getType(Uri)
 * @see #openTypedAssetFile(Uri, String, Bundle)
 * @see android.content.ClipDescription#compareMimeTypes(String, String)
 * @apiSince 11
 */

@androidx.annotation.Nullable
public java.lang.String[] getStreamTypes(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.NonNull java.lang.String mimeTypeFilter) { throw new RuntimeException("Stub!"); }

/**
 * Called by a client to open a read-only stream containing data of a
 * particular MIME type.  This is like {@link #openAssetFile(android.net.Uri,java.lang.String)},
 * except the file can only be read-only and the content provider may
 * perform data conversions to generate data of the desired type.
 *
 * <p>The default implementation compares the given mimeType against the
 * result of {@link #getType(android.net.Uri)} and, if they match, simply calls
 * {@link #openAssetFile(android.net.Uri,java.lang.String)}.
 *
 * <p>See {@link android.content.ClipData ClipData} for examples of the use and implementation
 * of this method.
 * <p>
 * The returned AssetFileDescriptor can be a pipe or socket pair to enable
 * streaming of data.
 *
 * <p class="note">For better interoperability with other applications, it is recommended
 * that for any URIs that can be opened, you also support queries on them
 * containing at least the columns specified by {@link android.provider.OpenableColumns}.
 * You may also want to support other common columns if you have additional meta-data
 * to supply, such as {@link android.provider.MediaStore.MediaColumns#DATE_ADDED}
 * in {@link android.provider.MediaStore.MediaColumns}.</p>
 *
 * @param uri The data in the content provider being queried.
 * This value must never be {@code null}.
 * @param mimeTypeFilter The type of data the client desires.  May be
 * a pattern, such as *&#47;*, if the caller does not have specific type
 * requirements; in this case the content provider will pick its best
 * type matching the pattern.
 * This value must never be {@code null}.
 * @param opts Additional options from the client.  The definitions of
 * these are specific to the content provider being called.
 *
 * This value may be {@code null}.
 * @return Returns a new AssetFileDescriptor from which the client can
 * read data of the desired type.
 *
 * This value may be {@code null}.
 * @throws java.io.FileNotFoundException Throws FileNotFoundException if there is
 * no file associated with the given URI or the mode is invalid.
 * @throws java.lang.SecurityException Throws SecurityException if the caller does
 * not have permission to access the data.
 * @throws java.lang.IllegalArgumentException Throws IllegalArgumentException if the
 * content provider does not support the requested MIME type.
 *
 * @see #getStreamTypes(Uri, String)
 * @see #openAssetFile(Uri, String)
 * @see android.content.ClipDescription#compareMimeTypes(String, String)
 * @apiSince 11
 */

@androidx.annotation.Nullable
public android.content.res.AssetFileDescriptor openTypedAssetFile(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.NonNull java.lang.String mimeTypeFilter, @androidx.annotation.Nullable android.os.Bundle opts) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Called by a client to open a read-only stream containing data of a
 * particular MIME type.  This is like {@link #openAssetFile(android.net.Uri,java.lang.String)},
 * except the file can only be read-only and the content provider may
 * perform data conversions to generate data of the desired type.
 *
 * <p>The default implementation compares the given mimeType against the
 * result of {@link #getType(android.net.Uri)} and, if they match, simply calls
 * {@link #openAssetFile(android.net.Uri,java.lang.String)}.
 *
 * <p>See {@link android.content.ClipData ClipData} for examples of the use and implementation
 * of this method.
 * <p>
 * The returned AssetFileDescriptor can be a pipe or socket pair to enable
 * streaming of data.
 *
 * <p class="note">For better interoperability with other applications, it is recommended
 * that for any URIs that can be opened, you also support queries on them
 * containing at least the columns specified by {@link android.provider.OpenableColumns}.
 * You may also want to support other common columns if you have additional meta-data
 * to supply, such as {@link android.provider.MediaStore.MediaColumns#DATE_ADDED}
 * in {@link android.provider.MediaStore.MediaColumns}.</p>
 *
 * @param uri The data in the content provider being queried.
 * This value must never be {@code null}.
 * @param mimeTypeFilter The type of data the client desires.  May be
 * a pattern, such as *&#47;*, if the caller does not have specific type
 * requirements; in this case the content provider will pick its best
 * type matching the pattern.
 * This value must never be {@code null}.
 * @param opts Additional options from the client.  The definitions of
 * these are specific to the content provider being called.
 * This value may be {@code null}.
 * @param signal A signal to cancel the operation in progress, or
 *            {@code null} if none. For example, if you are downloading a
 *            file from the network to service a "rw" mode request, you
 *            should periodically call
 *            {@link android.os.CancellationSignal#throwIfCanceled() CancellationSignal#throwIfCanceled()} to check whether
 *            the client has canceled the request and abort the download.
 *
 * This value may be {@code null}.
 * @return Returns a new AssetFileDescriptor from which the client can
 * read data of the desired type.
 *
 * @throws java.io.FileNotFoundException Throws FileNotFoundException if there is
 * no file associated with the given URI or the mode is invalid.
 * @throws java.lang.SecurityException Throws SecurityException if the caller does
 * not have permission to access the data.
 * @throws java.lang.IllegalArgumentException Throws IllegalArgumentException if the
 * content provider does not support the requested MIME type.
 *
 * @see #getStreamTypes(Uri, String)
 * @see #openAssetFile(Uri, String)
 * @see android.content.ClipDescription#compareMimeTypes(String, String)
 * @apiSince 19
 */

@androidx.annotation.Nullable
public android.content.res.AssetFileDescriptor openTypedAssetFile(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.NonNull java.lang.String mimeTypeFilter, @androidx.annotation.Nullable android.os.Bundle opts, @androidx.annotation.Nullable android.os.CancellationSignal signal) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * A helper function for implementing {@link #openTypedAssetFile}, for
 * creating a data pipe and background thread allowing you to stream
 * generated data back to the client.  This function returns a new
 * ParcelFileDescriptor that should be returned to the caller (the caller
 * is responsible for closing it).
 *
 * @param uri The URI whose data is to be written.
 * This value must never be {@code null}.
 * @param mimeType The desired type of data to be written.
 * This value must never be {@code null}.
 * @param opts Options supplied by caller.
 * This value may be {@code null}.
 * @param args Your own custom arguments.
 * This value may be {@code null}.
 * @param func Interface implementing the function that will actually
 * stream the data.
 * This value must never be {@code null}.
 * @return Returns a new ParcelFileDescriptor holding the read side of
 * the pipe.  This should be returned to the caller for reading; the caller
 * is responsible for closing it when done.
 
 * This value will never be {@code null}.
 * @apiSince 11
 */

@androidx.annotation.NonNull
public <T> android.os.ParcelFileDescriptor openPipeHelper(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.NonNull java.lang.String mimeType, @androidx.annotation.Nullable android.os.Bundle opts, @androidx.annotation.Nullable T args, @androidx.annotation.NonNull android.content.ContentProvider.PipeDataWriter<T> func) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this instance is a temporary content provider.
 * @return true if this instance is a temporary content provider
 * @apiSince 1
 */

protected boolean isTemporary() { throw new RuntimeException("Stub!"); }

/**
 * After being instantiated, this is called to tell the content provider
 * about itself.
 *
 * @param context The context this provider is running in
 * @param info Registered information about this content provider
 * @apiSince 1
 */

public void attachInfo(android.content.Context context, android.content.pm.ProviderInfo info) { throw new RuntimeException("Stub!"); }

/**
 * Override this to handle requests to perform a batch of operations, or the
 * default implementation will iterate over the operations and call
 * {@link android.content.ContentProviderOperation#apply ContentProviderOperation#apply} on each of them.
 * If all calls to {@link android.content.ContentProviderOperation#apply ContentProviderOperation#apply} succeed
 * then a {@link android.content.ContentProviderResult ContentProviderResult} array with as many
 * elements as there were operations will be returned.  If any of the calls
 * fail, it is up to the implementation how many of the others take effect.
 * This method can be called from multiple threads, as described in
 * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html#Threads">Processes
 * and Threads</a>.
 *
 * @param operations the operations to apply
 * This value must never be {@code null}.
 * @param authority This value must never be {@code null}.
 * @return the results of the applications
 * This value will never be {@code null}.
 * @throws android.content.OperationApplicationException thrown if any operation fails.
 * @see android.content.ContentProviderOperation#apply
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.content.ContentProviderResult[] applyBatch(@androidx.annotation.NonNull java.lang.String authority, @androidx.annotation.NonNull java.util.ArrayList<android.content.ContentProviderOperation> operations) throws android.content.OperationApplicationException { throw new RuntimeException("Stub!"); }

/**
 * @param operations This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 5
 */

@androidx.annotation.NonNull
public android.content.ContentProviderResult[] applyBatch(@androidx.annotation.NonNull java.util.ArrayList<android.content.ContentProviderOperation> operations) throws android.content.OperationApplicationException { throw new RuntimeException("Stub!"); }

/**
 * Call a provider-defined method.  This can be used to implement
 * interfaces that are cheaper and/or unnatural for a table-like
 * model.
 *
 * <p class="note"><strong>WARNING:</strong> The framework does no permission checking
 * on this entry into the content provider besides the basic ability for the application
 * to get access to the provider at all.  For example, it has no idea whether the call
 * being executed may read or write data in the provider, so can't enforce those
 * individual permissions.  Any implementation of this method <strong>must</strong>
 * do its own permission checks on incoming calls to make sure they are allowed.</p>
 *
 * @param method method name to call.  Opaque to framework, but should not be {@code null}.
 * This value must never be {@code null}.
 * @param arg provider-defined String argument.  May be {@code null}.
 * This value may be {@code null}.
 * @param extras provider-defined Bundle argument.  May be {@code null}.
 * This value may be {@code null}.
 * @param authority This value must never be {@code null}.
 * @return provider-defined return value.  May be {@code null}, which is also
 *   the default for providers which don't implement any call methods.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.os.Bundle call(@androidx.annotation.NonNull java.lang.String authority, @androidx.annotation.NonNull java.lang.String method, @androidx.annotation.Nullable java.lang.String arg, @androidx.annotation.Nullable android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * @param method This value must never be {@code null}.
 * @param arg This value may be {@code null}.
 * @param extras This value may be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 11
 */

@androidx.annotation.Nullable
public android.os.Bundle call(@androidx.annotation.NonNull java.lang.String method, @androidx.annotation.Nullable java.lang.String arg, @androidx.annotation.Nullable android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Implement this to shut down the ContentProvider instance. You can then
 * invoke this method in unit tests.
 *
 * <p>
 * Android normally handles ContentProvider startup and shutdown
 * automatically. You do not need to start up or shut down a
 * ContentProvider. When you invoke a test method on a ContentProvider,
 * however, a ContentProvider instance is started and keeps running after
 * the test finishes, even if a succeeding test instantiates another
 * ContentProvider. A conflict develops because the two instances are
 * usually running against the same underlying data source (for example, an
 * sqlite database).
 * </p>
 * <p>
 * Implementing shutDown() avoids this conflict by providing a way to
 * terminate the ContentProvider. This method can also prevent memory leaks
 * from multiple instantiations of the ContentProvider, and it can ensure
 * unit test isolation by allowing you to completely clean up the test
 * fixture before moving on to the next test.
 * </p>
 * @apiSince 11
 */

public void shutdown() { throw new RuntimeException("Stub!"); }

/**
 * Print the Provider's state into the given stream.  This gets invoked if
 * you run "adb shell dumpsys activity provider &lt;provider_component_name&gt;".
 *
 * @param fd The raw file descriptor that the dump is being sent to.
 * @param writer The PrintWriter to which you should dump your state.  This will be
 * closed for you after you return.
 * @param args additional arguments to the dump request.
 * @apiSince 18
 */

public void dump(java.io.FileDescriptor fd, java.io.PrintWriter writer, java.lang.String[] args) { throw new RuntimeException("Stub!"); }
/**
 * Opaque token representing the identity of an incoming IPC.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CallingIdentity {

CallingIdentity() { throw new RuntimeException("Stub!"); }
}

/**
 * Interface to write a stream of data to a pipe.  Use with
 * {@link android.content.ContentProvider#openPipeHelper ContentProvider#openPipeHelper}.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface PipeDataWriter<T> {

/**
 * Called from a background thread to stream data out to a pipe.
 * Note that the pipe is blocking, so this thread can block on
 * writes for an arbitrary amount of time if the client is slow
 * at reading.
 *
 * @param output The pipe where data should be written.  This will be
 * closed for you upon returning from this function.
 * This value must never be {@code null}.
 * @param uri The URI whose data is to be written.
 * This value must never be {@code null}.
 * @param mimeType The desired type of data to be written.
 * This value must never be {@code null}.
 * @param opts Options supplied by caller.
 * This value may be {@code null}.
 * @param args Your own custom arguments.
 
 * This value may be {@code null}.
 * @apiSince 11
 */

public void writeDataToPipe(@androidx.annotation.NonNull android.os.ParcelFileDescriptor output, @androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.NonNull java.lang.String mimeType, @androidx.annotation.Nullable android.os.Bundle opts, @androidx.annotation.Nullable T args);
}

}

