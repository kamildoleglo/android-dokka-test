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
import android.database.Cursor;
import android.os.OperationCanceledException;
import android.os.Bundle;
import android.os.CancellationSignal;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import android.os.ParcelFileDescriptor;
import android.content.res.AssetFileDescriptor;
import android.os.RemoteException;
import android.os.DeadObjectException;
import android.database.ContentObserver;
import android.accounts.Account;
import java.util.List;
import android.graphics.Bitmap;
import java.io.IOException;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;

/**
 * This class provides applications access to the content model.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about using a ContentResolver with content providers, read the
 * <a href="{@docRoot}guide/topics/providers/content-providers.html">Content Providers</a>
 * developer guide.</p>
 * </div>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class ContentResolver {

/**
 * @param context This value may be {@code null}.
 * @apiSince 1
 */

public ContentResolver(@androidx.annotation.Nullable android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Create a {@link android.content.ContentResolver ContentResolver} instance that redirects all its methods
 * to the given {@link android.content.ContentProvider ContentProvider}.
 
 * @param wrapped This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public static android.content.ContentResolver wrap(@androidx.annotation.NonNull android.content.ContentProvider wrapped) { throw new RuntimeException("Stub!"); }

/**
 * Create a {@link android.content.ContentResolver ContentResolver} instance that redirects all its methods
 * to the given {@link android.content.ContentProviderClient ContentProviderClient}.
 
 * @param wrapped This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public static android.content.ContentResolver wrap(@androidx.annotation.NonNull android.content.ContentProviderClient wrapped) { throw new RuntimeException("Stub!"); }

/**
 * Return the MIME type of the given content URL.
 *
 * @param url A Uri identifying content (either a list or specific type),
 * using the content:// scheme.
 * This value must never be {@code null}.
 * @return A MIME type for the content, or null if the URL is invalid or the type is unknown
 * @apiSince 1
 */

@androidx.annotation.Nullable
public final java.lang.String getType(@androidx.annotation.NonNull android.net.Uri url) { throw new RuntimeException("Stub!"); }

/**
 * Query for the possible MIME types for the representations the given
 * content URL can be returned when opened as as stream with
 * {@link #openTypedAssetFileDescriptor}.  Note that the types here are
 * not necessarily a superset of the type returned by {@link #getType} --
 * many content providers cannot return a raw stream for the structured
 * data that they contain.
 *
 * @param url A Uri identifying content (either a list or specific type),
 * using the content:// scheme.
 * This value must never be {@code null}.
 * @param mimeTypeFilter The desired MIME type.  This may be a pattern,
 * such as *&#47;*, to query for all available MIME types that match the
 * pattern.
 * This value must never be {@code null}.
 * @return Returns an array of MIME type strings for all available
 * data streams that match the given mimeTypeFilter.  If there are none,
 * null is returned.
 * @apiSince 11
 */

@androidx.annotation.Nullable
public java.lang.String[] getStreamTypes(@androidx.annotation.NonNull android.net.Uri url, @androidx.annotation.NonNull java.lang.String mimeTypeFilter) { throw new RuntimeException("Stub!"); }

/**
 * Query the given URI, returning a {@link android.database.Cursor Cursor} over the result set.
 * <p>
 * For best performance, the caller should follow these guidelines:
 * <ul>
 * <li>Provide an explicit projection, to prevent
 * reading data from storage that aren't going to be used.</li>
 * <li>Use question mark parameter markers such as 'phone=?' instead of
 * explicit values in the {@code selection} parameter, so that queries
 * that differ only by those values will be recognized as the same
 * for caching purposes.</li>
 * </ul>
 * </p>
 *
 * @param uri The URI, using the content:// scheme, for the content to
 *         retrieve.
 * This value must never be {@code null}.
 * @param projection A list of which columns to return. Passing null will
 *         return all columns, which is inefficient.
 * This value may be {@code null}.
 * @param selection A filter declaring which rows to return, formatted as an
 *         SQL WHERE clause (excluding the WHERE itself). Passing null will
 *         return all rows for the given URI.
 * This value may be {@code null}.
 * @param selectionArgs You may include ?s in selection, which will be
 *         replaced by the values from selectionArgs, in the order that they
 *         appear in the selection. The values will be bound as Strings.
 * This value may be {@code null}.
 * @param sortOrder How to order the rows, formatted as an SQL ORDER BY
 *         clause (excluding the ORDER BY itself). Passing null will use the
 *         default sort order, which may be unordered.
 * This value may be {@code null}.
 * @return A Cursor object, which is positioned before the first entry. May return
 *         <code>null</code> if the underlying content provider returns <code>null</code>,
 *         or if it crashes.
 * @see android.database.Cursor
 * @apiSince 1
 */

@androidx.annotation.Nullable
public final android.database.Cursor query(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable java.lang.String[] projection, @androidx.annotation.Nullable java.lang.String selection, @androidx.annotation.Nullable java.lang.String[] selectionArgs, @androidx.annotation.Nullable java.lang.String sortOrder) { throw new RuntimeException("Stub!"); }

/**
 * Query the given URI, returning a {@link android.database.Cursor Cursor} over the result set
 * with optional support for cancellation.
 * <p>
 * For best performance, the caller should follow these guidelines:
 * <ul>
 * <li>Provide an explicit projection, to prevent
 * reading data from storage that aren't going to be used.</li>
 * <li>Use question mark parameter markers such as 'phone=?' instead of
 * explicit values in the {@code selection} parameter, so that queries
 * that differ only by those values will be recognized as the same
 * for caching purposes.</li>
 * </ul>
 * </p>
 *
 * @param uri The URI, using the content:// scheme, for the content to
 *         retrieve.
 * This value must never be {@code null}.
 * @param projection A list of which columns to return. Passing null will
 *         return all columns, which is inefficient.
 * This value may be {@code null}.
 * @param selection A filter declaring which rows to return, formatted as an
 *         SQL WHERE clause (excluding the WHERE itself). Passing null will
 *         return all rows for the given URI.
 * This value may be {@code null}.
 * @param selectionArgs You may include ?s in selection, which will be
 *         replaced by the values from selectionArgs, in the order that they
 *         appear in the selection. The values will be bound as Strings.
 * This value may be {@code null}.
 * @param sortOrder How to order the rows, formatted as an SQL ORDER BY
 *         clause (excluding the ORDER BY itself). Passing null will use the
 *         default sort order, which may be unordered.
 * This value may be {@code null}.
 * @param cancellationSignal A signal to cancel the operation in progress, or null if none.
 * If the operation is canceled, then {@link android.os.OperationCanceledException OperationCanceledException} will be thrown
 * when the query is executed.
 * This value may be {@code null}.
 * @return A Cursor object, which is positioned before the first entry. May return
 *         <code>null</code> if the underlying content provider returns <code>null</code>,
 *         or if it crashes.
 * @see android.database.Cursor
 * @apiSince 16
 */

@androidx.annotation.Nullable
public final android.database.Cursor query(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable java.lang.String[] projection, @androidx.annotation.Nullable java.lang.String selection, @androidx.annotation.Nullable java.lang.String[] selectionArgs, @androidx.annotation.Nullable java.lang.String sortOrder, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal) { throw new RuntimeException("Stub!"); }

/**
 * Query the given URI, returning a {@link android.database.Cursor Cursor} over the result set
 * with support for cancellation.
 *
 * <p>For best performance, the caller should follow these guidelines:
 *
 * <li>Provide an explicit projection, to prevent reading data from storage
 * that aren't going to be used.
 *
 * Provider must identify which QUERY_ARG_SORT* arguments were honored during
 * the preparation of the result set by including the respective argument keys
 * in the {@link android.database.Cursor Cursor} extras {@link android.os.Bundle Bundle}. See {@link #EXTRA_HONORED_ARGS}
 * for details.
 *
 * @see #QUERY_ARG_SORT_COLUMNS
 * @see #QUERY_ARG_SORT_DIRECTION
 * @see #QUERY_ARG_SORT_COLLATION
 *
 * @param uri The URI, using the content:// scheme, for the content to
 *         retrieve.
 * This value must never be {@code null}.
 * @param projection A list of which columns to return. Passing null will
 *         return all columns, which is inefficient.
 * This value may be {@code null}.
 * @param queryArgs A Bundle containing any arguments to the query.
 * This value may be {@code null}.
 * @param cancellationSignal A signal to cancel the operation in progress, or null if none.
 * If the operation is canceled, then {@link android.os.OperationCanceledException OperationCanceledException} will be thrown
 * when the query is executed.
 * This value may be {@code null}.
 * @return A Cursor object, which is positioned before the first entry. May return
 *         <code>null</code> if the underlying content provider returns <code>null</code>,
 *         or if it crashes.
 * @see android.database.Cursor
 * @apiSince 26
 */

@androidx.annotation.Nullable
public final android.database.Cursor query(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable java.lang.String[] projection, @androidx.annotation.Nullable android.os.Bundle queryArgs, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal) { throw new RuntimeException("Stub!"); }

/**
 * Transform the given <var>url</var> to a canonical representation of
 * its referenced resource, which can be used across devices, persisted,
 * backed up and restored, etc.  The returned Uri is still a fully capable
 * Uri for use with its content provider, allowing you to do all of the
 * same content provider operations as with the original Uri --
 * {@link #query}, {@link #openInputStream(android.net.Uri)}, etc.  The
 * only difference in behavior between the original and new Uris is that
 * the content provider may need to do some additional work at each call
 * using it to resolve it to the correct resource, especially if the
 * canonical Uri has been moved to a different environment.
 *
 * <p>If you are moving a canonical Uri between environments, you should
 * perform another call to {@link #canonicalize} with that original Uri to
 * re-canonicalize it for the current environment.  Alternatively, you may
 * want to use {@link #uncanonicalize} to transform it to a non-canonical
 * Uri that works only in the current environment but potentially more
 * efficiently than the canonical representation.</p>
 *
 * @param url The {@link android.net.Uri Uri} that is to be transformed to a canonical
 * representation.  Like all resolver calls, the input can be either
 * a non-canonical or canonical Uri.
 *
 * This value must never be {@code null}.
 * @return Returns the official canonical representation of <var>url</var>,
 * or null if the content provider does not support a canonical representation
 * of the given Uri.  Many providers may not support canonicalization of some
 * or all of their Uris.
 *
 * @see #uncanonicalize
 * @apiSince 19
 */

@androidx.annotation.Nullable
public final android.net.Uri canonicalize(@androidx.annotation.NonNull android.net.Uri url) { throw new RuntimeException("Stub!"); }

/**
 * Given a canonical Uri previously generated by {@link #canonicalize}, convert
 * it to its local non-canonical form.  This can be useful in some cases where
 * you know that you will only be using the Uri in the current environment and
 * want to avoid any possible overhead when using it with the content
 * provider or want to verify that the referenced data exists at all in the
 * new environment.
 *
 * @param url The canonical {@link android.net.Uri Uri} that is to be convered back to its
 * non-canonical form.
 *
 * This value must never be {@code null}.
 * @return Returns the non-canonical representation of <var>url</var>.  This will
 * return null if data identified by the canonical Uri can not be found in
 * the current environment; callers must always check for null and deal with
 * that by appropriately falling back to an alternative.
 *
 * @see #canonicalize
 * @apiSince 19
 */

@androidx.annotation.Nullable
public final android.net.Uri uncanonicalize(@androidx.annotation.NonNull android.net.Uri url) { throw new RuntimeException("Stub!"); }

/**
 * This allows clients to request an explicit refresh of content identified by {@code uri}.
 * <p>
 * Client code should only invoke this method when there is a strong indication (such as a user
 * initiated pull to refresh gesture) that the content is stale.
 * <p>
 *
 * @param url The Uri identifying the data to refresh.
 * This value must never be {@code null}.
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

public final boolean refresh(@androidx.annotation.NonNull android.net.Uri url, @androidx.annotation.Nullable android.os.Bundle args, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal) { throw new RuntimeException("Stub!"); }

/**
 * Open a stream on to the content associated with a content URI.  If there
 * is no data associated with the URI, FileNotFoundException is thrown.
 *
 * <h5>Accepts the following URI schemes:</h5>
 * <ul>
 * <li>content ({@link #SCHEME_CONTENT})</li>
 * <li>android.resource ({@link #SCHEME_ANDROID_RESOURCE})</li>
 * <li>file ({@link #SCHEME_FILE})</li>
 * </ul>
 *
 * <p>See {@link #openAssetFileDescriptor(android.net.Uri,java.lang.String)} for more information
 * on these schemes.
 *
 * @param uri The desired URI.
 * This value must never be {@code null}.
 * @return InputStream
 * This value may be {@code null}.
 * @throws java.io.FileNotFoundException if the provided URI could not be opened.
 * @see #openAssetFileDescriptor(Uri, String)
 * @apiSince 1
 */

@androidx.annotation.Nullable
public final java.io.InputStream openInputStream(@androidx.annotation.NonNull android.net.Uri uri) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Synonym for {@link #openOutputStream(android.net.Uri,java.lang.String)
 * openOutputStream(uri, "w")}.
 * @throws java.io.FileNotFoundException if the provided URI could not be opened.
 
 * @param uri This value must never be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public final java.io.OutputStream openOutputStream(@androidx.annotation.NonNull android.net.Uri uri) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Open a stream on to the content associated with a content URI.  If there
 * is no data associated with the URI, FileNotFoundException is thrown.
 *
 * <h5>Accepts the following URI schemes:</h5>
 * <ul>
 * <li>content ({@link #SCHEME_CONTENT})</li>
 * <li>file ({@link #SCHEME_FILE})</li>
 * </ul>
 *
 * <p>See {@link #openAssetFileDescriptor(android.net.Uri,java.lang.String)} for more information
 * on these schemes.
 *
 * @param uri The desired URI.
 * This value must never be {@code null}.
 * @param mode May be "w", "wa", "rw", or "rwt".
 * This value must never be {@code null}.
 * @return OutputStream
 * This value may be {@code null}.
 * @throws java.io.FileNotFoundException if the provided URI could not be opened.
 * @see #openAssetFileDescriptor(Uri, String)
 * @apiSince 3
 */

@androidx.annotation.Nullable
public final java.io.OutputStream openOutputStream(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.NonNull java.lang.String mode) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param uri This value must never be {@code null}.
 * @param mode This value must never be {@code null}.
 * @param signal This value may be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public final android.os.ParcelFileDescriptor openFile(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.NonNull java.lang.String mode, @androidx.annotation.Nullable android.os.CancellationSignal signal) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Open a raw file descriptor to access data under a URI.  This
 * is like {@link #openAssetFileDescriptor(android.net.Uri,java.lang.String)}, but uses the
 * underlying {@link android.content.ContentProvider#openFile ContentProvider#openFile}
 * ContentProvider.openFile()} method, so will <em>not</em> work with
 * providers that return sub-sections of files.  If at all possible,
 * you should use {@link #openAssetFileDescriptor(android.net.Uri,java.lang.String)}.  You
 * will receive a FileNotFoundException exception if the provider returns a
 * sub-section of a file.
 *
 * <h5>Accepts the following URI schemes:</h5>
 * <ul>
 * <li>content ({@link #SCHEME_CONTENT})</li>
 * <li>file ({@link #SCHEME_FILE})</li>
 * </ul>
 *
 * <p>See {@link #openAssetFileDescriptor(android.net.Uri,java.lang.String)} for more information
 * on these schemes.
 * <p>
 * If opening with the exclusive "r" or "w" modes, the returned
 * ParcelFileDescriptor could be a pipe or socket pair to enable streaming
 * of data. Opening with the "rw" mode implies a file on disk that supports
 * seeking. If possible, always use an exclusive mode to give the underlying
 * {@link android.content.ContentProvider ContentProvider} the most flexibility.
 * <p>
 * If you are writing a file, and need to communicate an error to the
 * provider, use {@link android.os.ParcelFileDescriptor#closeWithError(java.lang.String) ParcelFileDescriptor#closeWithError(String)}.
 *
 * @param uri The desired URI to open.
 * This value must never be {@code null}.
 * @param mode The file mode to use, as per {@link android.content.ContentProvider#openFile ContentProvider#openFile}.
 * This value must never be {@code null}.
 * @return Returns a new ParcelFileDescriptor pointing to the file.  You
 * own this descriptor and are responsible for closing it when done.
 * This value may be {@code null}.
 * @throws java.io.FileNotFoundException Throws FileNotFoundException if no
 * file exists under the URI or the mode is invalid.
 * @see #openAssetFileDescriptor(Uri, String)
 * @apiSince 1
 */

@androidx.annotation.Nullable
public final android.os.ParcelFileDescriptor openFileDescriptor(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.NonNull java.lang.String mode) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Open a raw file descriptor to access data under a URI.  This
 * is like {@link #openAssetFileDescriptor(android.net.Uri,java.lang.String)}, but uses the
 * underlying {@link android.content.ContentProvider#openFile ContentProvider#openFile}
 * ContentProvider.openFile()} method, so will <em>not</em> work with
 * providers that return sub-sections of files.  If at all possible,
 * you should use {@link #openAssetFileDescriptor(android.net.Uri,java.lang.String)}.  You
 * will receive a FileNotFoundException exception if the provider returns a
 * sub-section of a file.
 *
 * <h5>Accepts the following URI schemes:</h5>
 * <ul>
 * <li>content ({@link #SCHEME_CONTENT})</li>
 * <li>file ({@link #SCHEME_FILE})</li>
 * </ul>
 *
 * <p>See {@link #openAssetFileDescriptor(android.net.Uri,java.lang.String)} for more information
 * on these schemes.
 * <p>
 * If opening with the exclusive "r" or "w" modes, the returned
 * ParcelFileDescriptor could be a pipe or socket pair to enable streaming
 * of data. Opening with the "rw" mode implies a file on disk that supports
 * seeking. If possible, always use an exclusive mode to give the underlying
 * {@link android.content.ContentProvider ContentProvider} the most flexibility.
 * <p>
 * If you are writing a file, and need to communicate an error to the
 * provider, use {@link android.os.ParcelFileDescriptor#closeWithError(java.lang.String) ParcelFileDescriptor#closeWithError(String)}.
 *
 * @param uri The desired URI to open.
 * This value must never be {@code null}.
 * @param mode The file mode to use, as per {@link android.content.ContentProvider#openFile ContentProvider#openFile}.
 * This value must never be {@code null}.
 * @param cancellationSignal A signal to cancel the operation in progress,
 *         or null if none. If the operation is canceled, then
 *         {@link android.os.OperationCanceledException OperationCanceledException} will be thrown.
 * This value may be {@code null}.
 * @return Returns a new ParcelFileDescriptor pointing to the file.  You
 * own this descriptor and are responsible for closing it when done.
 * @throws java.io.FileNotFoundException Throws FileNotFoundException if no
 * file exists under the URI or the mode is invalid.
 * @see #openAssetFileDescriptor(Uri, String)
 * @apiSince 19
 */

@androidx.annotation.Nullable
public final android.os.ParcelFileDescriptor openFileDescriptor(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.NonNull java.lang.String mode, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param uri This value must never be {@code null}.
 * @param mode This value must never be {@code null}.
 * @param signal This value may be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public final android.content.res.AssetFileDescriptor openAssetFile(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.NonNull java.lang.String mode, @androidx.annotation.Nullable android.os.CancellationSignal signal) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Open a raw file descriptor to access data under a URI.  This
 * interacts with the underlying {@link android.content.ContentProvider#openAssetFile ContentProvider#openAssetFile}
 * method of the provider associated with the given URI, to retrieve any file stored there.
 *
 * <h5>Accepts the following URI schemes:</h5>
 * <ul>
 * <li>content ({@link #SCHEME_CONTENT})</li>
 * <li>android.resource ({@link #SCHEME_ANDROID_RESOURCE})</li>
 * <li>file ({@link #SCHEME_FILE})</li>
 * </ul>
 * <h5>The android.resource ({@link #SCHEME_ANDROID_RESOURCE}) Scheme</h5>
 * <p>
 * A Uri object can be used to reference a resource in an APK file.  The
 * Uri should be one of the following formats:
 * <ul>
 * <li><code>android.resource://package_name/id_number</code><br/>
 * <code>package_name</code> is your package name as listed in your AndroidManifest.xml.
 * For example <code>com.example.myapp</code><br/>
 * <code>id_number</code> is the int form of the ID.<br/>
 * The easiest way to construct this form is
 * <pre>Uri uri = Uri.parse("android.resource://com.example.myapp/" + R.raw.my_resource");</pre>
 * </li>
 * <li><code>android.resource://package_name/type/name</code><br/>
 * <code>package_name</code> is your package name as listed in your AndroidManifest.xml.
 * For example <code>com.example.myapp</code><br/>
 * <code>type</code> is the string form of the resource type.  For example, <code>raw</code>
 * or <code>drawable</code>.
 * <code>name</code> is the string form of the resource name.  That is, whatever the file
 * name was in your res directory, without the type extension.
 * The easiest way to construct this form is
 * <pre>Uri uri = Uri.parse("android.resource://com.example.myapp/raw/my_resource");</pre>
 * </li>
 * </ul>
 *
 * <p>Note that if this function is called for read-only input (mode is "r")
 * on a content: URI, it will instead call {@link #openTypedAssetFileDescriptor}
 * for you with a MIME type of "*&#47;*".  This allows such callers to benefit
 * from any built-in data conversion that a provider implements.
 *
 * @param uri The desired URI to open.
 * This value must never be {@code null}.
 * @param mode The file mode to use, as per {@link android.content.ContentProvider#openAssetFile ContentProvider#openAssetFile}.
 * This value must never be {@code null}.
 * @return Returns a new ParcelFileDescriptor pointing to the file.  You
 * own this descriptor and are responsible for closing it when done.
 * This value may be {@code null}.
 * @throws java.io.FileNotFoundException Throws FileNotFoundException of no
 * file exists under the URI or the mode is invalid.
 * @apiSince 3
 */

@androidx.annotation.Nullable
public final android.content.res.AssetFileDescriptor openAssetFileDescriptor(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.NonNull java.lang.String mode) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Open a raw file descriptor to access data under a URI.  This
 * interacts with the underlying {@link android.content.ContentProvider#openAssetFile ContentProvider#openAssetFile}
 * method of the provider associated with the given URI, to retrieve any file stored there.
 *
 * <h5>Accepts the following URI schemes:</h5>
 * <ul>
 * <li>content ({@link #SCHEME_CONTENT})</li>
 * <li>android.resource ({@link #SCHEME_ANDROID_RESOURCE})</li>
 * <li>file ({@link #SCHEME_FILE})</li>
 * </ul>
 * <h5>The android.resource ({@link #SCHEME_ANDROID_RESOURCE}) Scheme</h5>
 * <p>
 * A Uri object can be used to reference a resource in an APK file.  The
 * Uri should be one of the following formats:
 * <ul>
 * <li><code>android.resource://package_name/id_number</code><br/>
 * <code>package_name</code> is your package name as listed in your AndroidManifest.xml.
 * For example <code>com.example.myapp</code><br/>
 * <code>id_number</code> is the int form of the ID.<br/>
 * The easiest way to construct this form is
 * <pre>Uri uri = Uri.parse("android.resource://com.example.myapp/" + R.raw.my_resource");</pre>
 * </li>
 * <li><code>android.resource://package_name/type/name</code><br/>
 * <code>package_name</code> is your package name as listed in your AndroidManifest.xml.
 * For example <code>com.example.myapp</code><br/>
 * <code>type</code> is the string form of the resource type.  For example, <code>raw</code>
 * or <code>drawable</code>.
 * <code>name</code> is the string form of the resource name.  That is, whatever the file
 * name was in your res directory, without the type extension.
 * The easiest way to construct this form is
 * <pre>Uri uri = Uri.parse("android.resource://com.example.myapp/raw/my_resource");</pre>
 * </li>
 * </ul>
 *
 * <p>Note that if this function is called for read-only input (mode is "r")
 * on a content: URI, it will instead call {@link #openTypedAssetFileDescriptor}
 * for you with a MIME type of "*&#47;*".  This allows such callers to benefit
 * from any built-in data conversion that a provider implements.
 *
 * @param uri The desired URI to open.
 * This value must never be {@code null}.
 * @param mode The file mode to use, as per {@link android.content.ContentProvider#openAssetFile ContentProvider#openAssetFile}.
 * This value must never be {@code null}.
 * @param cancellationSignal A signal to cancel the operation in progress, or null if
 *            none. If the operation is canceled, then
 *            {@link android.os.OperationCanceledException OperationCanceledException} will be thrown.
 * This value may be {@code null}.
 * @return Returns a new ParcelFileDescriptor pointing to the file.  You
 * own this descriptor and are responsible for closing it when done.
 * @throws java.io.FileNotFoundException Throws FileNotFoundException of no
 * file exists under the URI or the mode is invalid.
 * @apiSince 19
 */

@androidx.annotation.Nullable
public final android.content.res.AssetFileDescriptor openAssetFileDescriptor(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.NonNull java.lang.String mode, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param uri This value must never be {@code null}.
 * @param mimeTypeFilter This value must never be {@code null}.
 * @param opts This value may be {@code null}.
 * @param signal This value may be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public final android.content.res.AssetFileDescriptor openTypedAssetFile(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.NonNull java.lang.String mimeTypeFilter, @androidx.annotation.Nullable android.os.Bundle opts, @androidx.annotation.Nullable android.os.CancellationSignal signal) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Open a raw file descriptor to access (potentially type transformed)
 * data from a "content:" URI.  This interacts with the underlying
 * {@link android.content.ContentProvider#openTypedAssetFile ContentProvider#openTypedAssetFile} method of the provider
 * associated with the given URI, to retrieve retrieve any appropriate
 * data stream for the data stored there.
 *
 * <p>Unlike {@link #openAssetFileDescriptor}, this function only works
 * with "content:" URIs, because content providers are the only facility
 * with an associated MIME type to ensure that the returned data stream
 * is of the desired type.
 *
 * <p>All text/* streams are encoded in UTF-8.
 *
 * @param uri The desired URI to open.
 * This value must never be {@code null}.
 * @param mimeType The desired MIME type of the returned data.  This can
 * be a pattern such as *&#47;*, which will allow the content provider to
 * select a type, though there is no way for you to determine what type
 * it is returning.
 * This value must never be {@code null}.
 * @param opts Additional provider-dependent options.
 * This value may be {@code null}.
 * @return Returns a new ParcelFileDescriptor from which you can read the
 * data stream from the provider.  Note that this may be a pipe, meaning
 * you can't seek in it.  The only seek you should do is if the
 * AssetFileDescriptor contains an offset, to move to that offset before
 * reading.  You own this descriptor and are responsible for closing it when done.
 * This value may be {@code null}.
 * @throws java.io.FileNotFoundException Throws FileNotFoundException of no
 * data of the desired type exists under the URI.
 * @apiSince 11
 */

@androidx.annotation.Nullable
public final android.content.res.AssetFileDescriptor openTypedAssetFileDescriptor(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.NonNull java.lang.String mimeType, @androidx.annotation.Nullable android.os.Bundle opts) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Open a raw file descriptor to access (potentially type transformed)
 * data from a "content:" URI.  This interacts with the underlying
 * {@link android.content.ContentProvider#openTypedAssetFile ContentProvider#openTypedAssetFile} method of the provider
 * associated with the given URI, to retrieve retrieve any appropriate
 * data stream for the data stored there.
 *
 * <p>Unlike {@link #openAssetFileDescriptor}, this function only works
 * with "content:" URIs, because content providers are the only facility
 * with an associated MIME type to ensure that the returned data stream
 * is of the desired type.
 *
 * <p>All text/* streams are encoded in UTF-8.
 *
 * @param uri The desired URI to open.
 * This value must never be {@code null}.
 * @param mimeType The desired MIME type of the returned data.  This can
 * be a pattern such as *&#47;*, which will allow the content provider to
 * select a type, though there is no way for you to determine what type
 * it is returning.
 * This value must never be {@code null}.
 * @param opts Additional provider-dependent options.
 * This value may be {@code null}.
 * @param cancellationSignal A signal to cancel the operation in progress,
 *         or null if none. If the operation is canceled, then
 *         {@link android.os.OperationCanceledException OperationCanceledException} will be thrown.
 * This value may be {@code null}.
 * @return Returns a new ParcelFileDescriptor from which you can read the
 * data stream from the provider.  Note that this may be a pipe, meaning
 * you can't seek in it.  The only seek you should do is if the
 * AssetFileDescriptor contains an offset, to move to that offset before
 * reading.  You own this descriptor and are responsible for closing it when done.
 * @throws java.io.FileNotFoundException Throws FileNotFoundException of no
 * data of the desired type exists under the URI.
 * @apiSince 19
 */

@androidx.annotation.Nullable
public final android.content.res.AssetFileDescriptor openTypedAssetFileDescriptor(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.NonNull java.lang.String mimeType, @androidx.annotation.Nullable android.os.Bundle opts, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Inserts a row into a table at the given URL.
 *
 * If the content provider supports transactions the insertion will be atomic.
 *
 * @param url The URL of the table to insert into.
 * This value must never be {@code null}.
 * @param values The initial values for the newly inserted row. The key is the column name for
 *               the field. Passing an empty ContentValues will create an empty row.
 * This value may be {@code null}.
 * @return the URL of the newly created row. May return <code>null</code> if the underlying
 *         content provider returns <code>null</code>, or if it crashes.
 * @apiSince 1
 */

@androidx.annotation.Nullable
public final android.net.Uri insert(@androidx.annotation.NonNull android.net.Uri url, @androidx.annotation.Nullable android.content.ContentValues values) { throw new RuntimeException("Stub!"); }

/**
 * Applies each of the {@link android.content.ContentProviderOperation ContentProviderOperation} objects and returns an array
 * of their results. Passes through OperationApplicationException, which may be thrown
 * by the call to {@link android.content.ContentProviderOperation#apply ContentProviderOperation#apply}.
 * If all the applications succeed then a {@link android.content.ContentProviderResult ContentProviderResult} array with the
 * same number of elements as the operations will be returned. It is implementation-specific
 * how many, if any, operations will have been successfully applied if a call to
 * apply results in a {@link android.content.OperationApplicationException OperationApplicationException}.
 * @param authority the authority of the ContentProvider to which this batch should be applied
 * This value must never be {@code null}.
 * @param operations the operations to apply
 * This value must never be {@code null}.
 * @return the results of the applications
 * This value will never be {@code null}.
 * @throws android.content.OperationApplicationException thrown if an application fails.
 * See {@link android.content.ContentProviderOperation#apply ContentProviderOperation#apply} for more information.
 * @throws android.os.RemoteException thrown if a RemoteException is encountered while attempting
 *   to communicate with a remote provider.
 * @apiSince 5
 */

@androidx.annotation.NonNull
public android.content.ContentProviderResult[] applyBatch(@androidx.annotation.NonNull java.lang.String authority, @androidx.annotation.NonNull java.util.ArrayList<android.content.ContentProviderOperation> operations) throws android.content.OperationApplicationException, android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * Inserts multiple rows into a table at the given URL.
 *
 * This function make no guarantees about the atomicity of the insertions.
 *
 * @param url The URL of the table to insert into.
 * This value must never be {@code null}.
 * @param values The initial values for the newly inserted rows. The key is the column name for
 *               the field. Passing null will create an empty row.
 * This value must never be {@code null}.
 * @return the number of newly created rows.
 * @apiSince 1
 */

public final int bulkInsert(@androidx.annotation.NonNull android.net.Uri url, @androidx.annotation.NonNull android.content.ContentValues[] values) { throw new RuntimeException("Stub!"); }

/**
 * Deletes row(s) specified by a content URI.
 *
 * If the content provider supports transactions, the deletion will be atomic.
 *
 * @param url The URL of the row to delete.
 * This value must never be {@code null}.
 * @param where A filter to apply to rows before deleting, formatted as an SQL WHERE clause
            (excluding the WHERE itself).
 * This value may be {@code null}.
 * @param selectionArgs This value may be {@code null}.
 * @return The number of rows deleted.
 * @apiSince 1
 */

public final int delete(@androidx.annotation.NonNull android.net.Uri url, @androidx.annotation.Nullable java.lang.String where, @androidx.annotation.Nullable java.lang.String[] selectionArgs) { throw new RuntimeException("Stub!"); }

/**
 * Update row(s) in a content URI.
 *
 * If the content provider supports transactions the update will be atomic.
 *
 * @param uri The URI to modify.
 * This value must never be {@code null}.
 * @param values The new field values. The key is the column name for the field.
            A null value will remove an existing field value.
 * This value may be {@code null}.
 * @param where A filter to apply to rows before updating, formatted as an SQL WHERE clause
           (excluding the WHERE itself).
 * This value may be {@code null}.
 * @param selectionArgs This value may be {@code null}.
 * @return the number of rows updated.
 * @throws java.lang.NullPointerException if uri or values are null
 * @apiSince 1
 */

public final int update(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable android.content.ContentValues values, @androidx.annotation.Nullable java.lang.String where, @androidx.annotation.Nullable java.lang.String[] selectionArgs) { throw new RuntimeException("Stub!"); }

/**
 * Call a provider-defined method.  This can be used to implement
 * read or write interfaces which are cheaper than using a Cursor and/or
 * do not fit into the traditional table model.
 *
 * @param method provider-defined method name to call.  Opaque to
 *   framework, but must be non-null.
 * This value must never be {@code null}.
 * @param arg provider-defined String argument.  May be null.
 * This value may be {@code null}.
 * @param extras provider-defined Bundle argument.  May be null.
 * This value may be {@code null}.
 * @param uri This value must never be {@code null}.
 * @return a result Bundle, possibly null.  Will be null if the ContentProvider
 *   does not implement call.
 * @throws java.lang.NullPointerException if uri or method is null
 * @throws java.lang.IllegalArgumentException if uri is not known
 * @apiSince 11
 */

@androidx.annotation.Nullable
public final android.os.Bundle call(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.NonNull java.lang.String method, @androidx.annotation.Nullable java.lang.String arg, @androidx.annotation.Nullable android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param authority This value must never be {@code null}.
 * @param method This value must never be {@code null}.
 * @param arg This value may be {@code null}.
 * @param extras This value may be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public final android.os.Bundle call(@androidx.annotation.NonNull java.lang.String authority, @androidx.annotation.NonNull java.lang.String method, @androidx.annotation.Nullable java.lang.String arg, @androidx.annotation.Nullable android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link android.content.ContentProviderClient ContentProviderClient} that is associated with the {@link android.content.ContentProvider ContentProvider}
 * that services the content at uri, starting the provider if necessary. Returns
 * null if there is no provider associated wih the uri. The caller must indicate that they are
 * done with the provider by calling {@link android.content.ContentProviderClient#release ContentProviderClient#release} which will allow
 * the system to release the provider if it determines that there is no other reason for
 * keeping it active.
 * @param uri specifies which provider should be acquired
 * This value must never be {@code null}.
 * @return a {@link android.content.ContentProviderClient ContentProviderClient} that is associated with the {@link android.content.ContentProvider ContentProvider}
 * that services the content at uri or null if there isn't one.
 * @apiSince 5
 */

@androidx.annotation.Nullable
public final android.content.ContentProviderClient acquireContentProviderClient(@androidx.annotation.NonNull android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link android.content.ContentProviderClient ContentProviderClient} that is associated with the {@link android.content.ContentProvider ContentProvider}
 * with the authority of name, starting the provider if necessary. Returns
 * null if there is no provider associated wih the uri. The caller must indicate that they are
 * done with the provider by calling {@link android.content.ContentProviderClient#release ContentProviderClient#release} which will allow
 * the system to release the provider if it determines that there is no other reason for
 * keeping it active.
 * @param name specifies which provider should be acquired
 * This value must never be {@code null}.
 * @return a {@link android.content.ContentProviderClient ContentProviderClient} that is associated with the {@link android.content.ContentProvider ContentProvider}
 * with the authority of name or null if there isn't one.
 * @apiSince 5
 */

@androidx.annotation.Nullable
public final android.content.ContentProviderClient acquireContentProviderClient(@androidx.annotation.NonNull java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Like {@link #acquireContentProviderClient(android.net.Uri)}, but for use when you do
 * not trust the stability of the target content provider.  This turns off
 * the mechanism in the platform clean up processes that are dependent on
 * a content provider if that content provider's process goes away.  Normally
 * you can safely assume that once you have acquired a provider, you can freely
 * use it as needed and it won't disappear, even if your process is in the
 * background.  If using this method, you need to take care to deal with any
 * failures when communicating with the provider, and be sure to close it
 * so that it can be re-opened later.  In particular, catching a
 * {@link android.os.DeadObjectException} from the calls there will let you
 * know that the content provider has gone away; at that point the current
 * ContentProviderClient object is invalid, and you should release it.  You
 * can acquire a new one if you would like to try to restart the provider
 * and perform new operations on it.
 
 * @param uri This value must never be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 16
 */

@androidx.annotation.Nullable
public final android.content.ContentProviderClient acquireUnstableContentProviderClient(@androidx.annotation.NonNull android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Like {@link #acquireContentProviderClient(java.lang.String)}, but for use when you do
 * not trust the stability of the target content provider.  This turns off
 * the mechanism in the platform clean up processes that are dependent on
 * a content provider if that content provider's process goes away.  Normally
 * you can safely assume that once you have acquired a provider, you can freely
 * use it as needed and it won't disappear, even if your process is in the
 * background.  If using this method, you need to take care to deal with any
 * failures when communicating with the provider, and be sure to close it
 * so that it can be re-opened later.  In particular, catching a
 * {@link android.os.DeadObjectException} from the calls there will let you
 * know that the content provider has gone away; at that point the current
 * ContentProviderClient object is invalid, and you should release it.  You
 * can acquire a new one if you would like to try to restart the provider
 * and perform new operations on it.
 
 * @param name This value must never be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 16
 */

@androidx.annotation.Nullable
public final android.content.ContentProviderClient acquireUnstableContentProviderClient(@androidx.annotation.NonNull java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Register an observer class that gets callbacks when data identified by a
 * given content URI changes.
 * <p>
 * Starting in {@link android.os.Build.VERSION_CODES#O}, all content
 * notifications must be backed by a valid {@link android.content.ContentProvider ContentProvider}.
 *
 * @param uri The URI to watch for changes. This can be a specific row URI,
 *            or a base URI for a whole class of content.
 * This value must never be {@code null}.
 * @param notifyForDescendants When false, the observer will be notified
 *            whenever a change occurs to the exact URI specified by
 *            <code>uri</code> or to one of the URI's ancestors in the path
 *            hierarchy. When true, the observer will also be notified
 *            whenever a change occurs to the URI's descendants in the path
 *            hierarchy.
 * @param observer The object that receives callbacks when changes occur.
 * This value must never be {@code null}.
 * @see #unregisterContentObserver
 * @apiSince 1
 */

public final void registerContentObserver(@androidx.annotation.NonNull android.net.Uri uri, boolean notifyForDescendants, @androidx.annotation.NonNull android.database.ContentObserver observer) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters a change observer.
 *
 * @param observer The previously registered observer that is no longer needed.
 * This value must never be {@code null}.
 * @see #registerContentObserver
 * @apiSince 1
 */

public final void unregisterContentObserver(@androidx.annotation.NonNull android.database.ContentObserver observer) { throw new RuntimeException("Stub!"); }

/**
 * Notify registered observers that a row was updated and attempt to sync
 * changes to the network.
 * <p>
 * To observe events sent through this call, use
 * {@link #registerContentObserver(android.net.Uri,boolean,android.database.ContentObserver)}.
 * <p>
 * Starting in {@link android.os.Build.VERSION_CODES#O}, all content
 * notifications must be backed by a valid {@link android.content.ContentProvider ContentProvider}.
 *
 * @param uri The uri of the content that was changed.
 * This value must never be {@code null}.
 * @param observer The observer that originated the change, may be
 *            <code>null</null>. The observer that originated the change
 *            will only receive the notification if it has requested to
 *            receive self-change notifications by implementing
 *            {@link android.database.ContentObserver#deliverSelfNotifications() ContentObserver#deliverSelfNotifications()} to return
 *            true.
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public void notifyChange(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable android.database.ContentObserver observer) { throw new RuntimeException("Stub!"); }

/**
 * Notify registered observers that a row was updated.
 * <p>
 * To observe events sent through this call, use
 * {@link #registerContentObserver(android.net.Uri,boolean,android.database.ContentObserver)}.
 * <p>
 * If syncToNetwork is true, this will attempt to schedule a local sync
 * using the sync adapter that's registered for the authority of the
 * provided uri. No account will be passed to the sync adapter, so all
 * matching accounts will be synchronized.
 * <p>
 * Starting in {@link android.os.Build.VERSION_CODES#O}, all content
 * notifications must be backed by a valid {@link android.content.ContentProvider ContentProvider}.
 *
 * @param uri The uri of the content that was changed.
 * This value must never be {@code null}.
 * @param observer The observer that originated the change, may be
 *            <code>null</null>. The observer that originated the change
 *            will only receive the notification if it has requested to
 *            receive self-change notifications by implementing
 *            {@link android.database.ContentObserver#deliverSelfNotifications() ContentObserver#deliverSelfNotifications()} to return
 *            true.
 * This value may be {@code null}.
 * @param syncToNetwork If true, same as {@link #NOTIFY_SYNC_TO_NETWORK}.
 * @see #requestSync(android.accounts.Account, String, android.os.Bundle)
 * @apiSince 1
 */

public void notifyChange(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable android.database.ContentObserver observer, boolean syncToNetwork) { throw new RuntimeException("Stub!"); }

/**
 * Notify registered observers that a row was updated.
 * <p>
 * To observe events sent through this call, use
 * {@link #registerContentObserver(android.net.Uri,boolean,android.database.ContentObserver)}.
 * <p>
 * If syncToNetwork is true, this will attempt to schedule a local sync
 * using the sync adapter that's registered for the authority of the
 * provided uri. No account will be passed to the sync adapter, so all
 * matching accounts will be synchronized.
 * <p>
 * Starting in {@link android.os.Build.VERSION_CODES#O}, all content
 * notifications must be backed by a valid {@link android.content.ContentProvider ContentProvider}.
 *
 * @param uri The uri of the content that was changed.
 * This value must never be {@code null}.
 * @param observer The observer that originated the change, may be
 *            <code>null</null>. The observer that originated the change
 *            will only receive the notification if it has requested to
 *            receive self-change notifications by implementing
 *            {@link android.database.ContentObserver#deliverSelfNotifications() ContentObserver#deliverSelfNotifications()} to return
 *            true.
 * This value may be {@code null}.
 * @param flags Additional flags: {@link #NOTIFY_SYNC_TO_NETWORK}.
 * Value is either <code>0</code> or a combination of {@link android.content.ContentResolver#NOTIFY_SYNC_TO_NETWORK}, and {@link android.content.ContentResolver#NOTIFY_SKIP_NOTIFY_FOR_DESCENDANTS}
 * @see #requestSync(android.accounts.Account, String, android.os.Bundle)
 * @apiSince 24
 */

public void notifyChange(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable android.database.ContentObserver observer, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Take a persistable URI permission grant that has been offered. Once
 * taken, the permission grant will be remembered across device reboots.
 * Only URI permissions granted with
 * {@link android.content.Intent#FLAG_GRANT_PERSISTABLE_URI_PERMISSION Intent#FLAG_GRANT_PERSISTABLE_URI_PERMISSION} can be persisted. If
 * the grant has already been persisted, taking it again will touch
 * {@link android.content.UriPermission#getPersistedTime() UriPermission#getPersistedTime()}.
 *
 * @see #getPersistedUriPermissions()
 
 * @param uri This value must never be {@code null}.
 
 * @param modeFlags Value is either <code>0</code> or a combination of {@link android.content.Intent#FLAG_GRANT_READ_URI_PERMISSION}, and {@link android.content.Intent#FLAG_GRANT_WRITE_URI_PERMISSION}
 * @apiSince 19
 */

public void takePersistableUriPermission(@androidx.annotation.NonNull android.net.Uri uri, int modeFlags) { throw new RuntimeException("Stub!"); }

/**
 * Relinquish a persisted URI permission grant. The URI must have been
 * previously made persistent with
 * {@link #takePersistableUriPermission(android.net.Uri,int)}. Any non-persistent
 * grants to the calling package will remain intact.
 *
 * @see #getPersistedUriPermissions()
 
 * @param uri This value must never be {@code null}.
 
 * @param modeFlags Value is either <code>0</code> or a combination of {@link android.content.Intent#FLAG_GRANT_READ_URI_PERMISSION}, and {@link android.content.Intent#FLAG_GRANT_WRITE_URI_PERMISSION}
 * @apiSince 19
 */

public void releasePersistableUriPermission(@androidx.annotation.NonNull android.net.Uri uri, int modeFlags) { throw new RuntimeException("Stub!"); }

/**
 * Return list of all URI permission grants that have been persisted by the
 * calling app. That is, the returned permissions have been granted
 * <em>to</em> the calling app. Only persistable grants taken with
 * {@link #takePersistableUriPermission(android.net.Uri,int)} are returned.
 * <p>Note: Some of the returned URIs may not be usable until after the user is unlocked.
 *
 * @see #takePersistableUriPermission(Uri, int)
 * @see #releasePersistableUriPermission(Uri, int)
 
 * @return This value will never be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.NonNull
public java.util.List<android.content.UriPermission> getPersistedUriPermissions() { throw new RuntimeException("Stub!"); }

/**
 * Return list of all persisted URI permission grants that are hosted by the
 * calling app. That is, the returned permissions have been granted
 * <em>from</em> the calling app. Only grants taken with
 * {@link #takePersistableUriPermission(android.net.Uri,int)} are returned.
 * <p>Note: Some of the returned URIs may not be usable until after the user is unlocked.
 
 * @return This value will never be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.NonNull
public java.util.List<android.content.UriPermission> getOutgoingPersistedUriPermissions() { throw new RuntimeException("Stub!"); }

/**
 * Start an asynchronous sync operation. If you want to monitor the progress
 * of the sync you may register a SyncObserver. Only values of the following
 * types may be used in the extras bundle:
 * <ul>
 * <li>Integer</li>
 * <li>Long</li>
 * <li>Boolean</li>
 * <li>Float</li>
 * <li>Double</li>
 * <li>String</li>
 * <li>Account</li>
 * <li>null</li>
 * </ul>
 *
 * @param uri the uri of the provider to sync or null to sync all providers.
 * @param extras any extras to pass to the SyncAdapter.
 * @deprecated instead use
 * {@link #requestSync(android.accounts.Account,java.lang.String,android.os.Bundle)}
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public void startSync(android.net.Uri uri, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Start an asynchronous sync operation. If you want to monitor the progress
 * of the sync you may register a SyncObserver. Only values of the following
 * types may be used in the extras bundle:
 * <ul>
 * <li>Integer</li>
 * <li>Long</li>
 * <li>Boolean</li>
 * <li>Float</li>
 * <li>Double</li>
 * <li>String</li>
 * <li>Account</li>
 * <li>null</li>
 * </ul>
 *
 * @param account which account should be synced
 * @param authority which authority should be synced
 * @param extras any extras to pass to the SyncAdapter.
 * @apiSince 5
 */

public static void requestSync(android.accounts.Account account, java.lang.String authority, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Register a sync with the SyncManager. These requests are built using the
 * {@link android.content.SyncRequest.Builder SyncRequest.Builder}.
 * @apiSince 19
 */

public static void requestSync(android.content.SyncRequest request) { throw new RuntimeException("Stub!"); }

/**
 * Check that only values of the following types are in the Bundle:
 * <ul>
 * <li>Integer</li>
 * <li>Long</li>
 * <li>Boolean</li>
 * <li>Float</li>
 * <li>Double</li>
 * <li>String</li>
 * <li>Account</li>
 * <li>null</li>
 * </ul>
 * @param extras the Bundle to check
 * @apiSince 1
 */

public static void validateSyncExtrasBundle(android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Cancel any active or pending syncs that match the Uri. If the uri is null then
 * all syncs will be canceled.
 *
 * @param uri the uri of the provider to sync or null to sync all providers.
 * @deprecated instead use {@link #cancelSync(android.accounts.Account,java.lang.String)}
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public void cancelSync(android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Cancel any active or pending syncs that match account and authority. The account and
 * authority can each independently be set to null, which means that syncs with any account
 * or authority, respectively, will match.
 *
 * @param account filters the syncs that match by this account
 * @param authority filters the syncs that match by this authority
 * @apiSince 5
 */

public static void cancelSync(android.accounts.Account account, java.lang.String authority) { throw new RuntimeException("Stub!"); }

/**
 * Get information about the SyncAdapters that are known to the system.
 * @return an array of SyncAdapters that have registered with the system
 * @apiSince 5
 */

public static android.content.SyncAdapterType[] getSyncAdapterTypes() { throw new RuntimeException("Stub!"); }

/**
 * Check if the provider should be synced when a network tickle is received
 * <p>This method requires the caller to hold the permission
 * {@link android.Manifest.permission#READ_SYNC_SETTINGS}.
 *
 * @param account the account whose setting we are querying
 * @param authority the provider whose setting we are querying
 * @return true if the provider should be synced when a network tickle is received
 * @apiSince 5
 */

public static boolean getSyncAutomatically(android.accounts.Account account, java.lang.String authority) { throw new RuntimeException("Stub!"); }

/**
 * Set whether or not the provider is synced when it receives a network tickle.
 * <p>This method requires the caller to hold the permission
 * {@link android.Manifest.permission#WRITE_SYNC_SETTINGS}.
 *
 * @param account the account whose setting we are querying
 * @param authority the provider whose behavior is being controlled
 * @param sync true if the provider should be synced when tickles are received for it
 * @apiSince 5
 */

public static void setSyncAutomatically(android.accounts.Account account, java.lang.String authority, boolean sync) { throw new RuntimeException("Stub!"); }

/**
 * Specifies that a sync should be requested with the specified the account, authority,
 * and extras at the given frequency. If there is already another periodic sync scheduled
 * with the account, authority and extras then a new periodic sync won't be added, instead
 * the frequency of the previous one will be updated.
 * <p>
 * These periodic syncs honor the "syncAutomatically" and "masterSyncAutomatically" settings.
 * Although these sync are scheduled at the specified frequency, it may take longer for it to
 * actually be started if other syncs are ahead of it in the sync operation queue. This means
 * that the actual start time may drift.
 * <p>
 * Periodic syncs are not allowed to have any of {@link #SYNC_EXTRAS_DO_NOT_RETRY},
 * {@link #SYNC_EXTRAS_IGNORE_BACKOFF}, {@link #SYNC_EXTRAS_IGNORE_SETTINGS},
 * {@link #SYNC_EXTRAS_INITIALIZE}, {@link #SYNC_EXTRAS_FORCE},
 * {@link #SYNC_EXTRAS_EXPEDITED}, {@link #SYNC_EXTRAS_MANUAL} set to true.
 * If any are supplied then an {@link java.lang.IllegalArgumentException IllegalArgumentException} will be thrown.
 *
 * <p>This method requires the caller to hold the permission
 * {@link android.Manifest.permission#WRITE_SYNC_SETTINGS}.
 * <p>The bundle for a periodic sync can be queried by applications with the correct
 * permissions using
 * {@link android.content.ContentResolver#getPeriodicSyncs(android.accounts.Account,java.lang.String) ContentResolver#getPeriodicSyncs(Account account, String provider)}, so no
 * sensitive data should be transferred here.
 *
 * @param account the account to specify in the sync
 * @param authority the provider to specify in the sync request
 * @param extras extra parameters to go along with the sync request
 * @param pollFrequency how frequently the sync should be performed, in seconds.
 * On Android API level 24 and above, a minmam interval of 15 minutes is enforced.
 * On previous versions, the minimum interval is 1 hour.
 * @throws java.lang.IllegalArgumentException if an illegal extra was set or if any of the parameters
 * are null.
 * @apiSince 8
 */

public static void addPeriodicSync(android.accounts.Account account, java.lang.String authority, android.os.Bundle extras, long pollFrequency) { throw new RuntimeException("Stub!"); }

/**
 * Remove a periodic sync. Has no affect if account, authority and extras don't match
 * an existing periodic sync.
 * <p>This method requires the caller to hold the permission
 * {@link android.Manifest.permission#WRITE_SYNC_SETTINGS}.
 *
 * @param account the account of the periodic sync to remove
 * @param authority the provider of the periodic sync to remove
 * @param extras the extras of the periodic sync to remove
 * @apiSince 8
 */

public static void removePeriodicSync(android.accounts.Account account, java.lang.String authority, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Remove the specified sync. This will cancel any pending or active syncs. If the request is
 * for a periodic sync, this call will remove any future occurrences.
 * <p>
 *     If a periodic sync is specified, the caller must hold the permission
 *     {@link android.Manifest.permission#WRITE_SYNC_SETTINGS}.
 *</p>
 * It is possible to cancel a sync using a SyncRequest object that is not the same object
 * with which you requested the sync. Do so by building a SyncRequest with the same
 * adapter, frequency, <b>and</b> extras bundle.
 *
 * @param request SyncRequest object containing information about sync to cancel.
 * @apiSince 21
 */

public static void cancelSync(android.content.SyncRequest request) { throw new RuntimeException("Stub!"); }

/**
 * Get the list of information about the periodic syncs for the given account and authority.
 * <p>This method requires the caller to hold the permission
 * {@link android.Manifest.permission#READ_SYNC_SETTINGS}.
 *
 * @param account the account whose periodic syncs we are querying
 * @param authority the provider whose periodic syncs we are querying
 * @return a list of PeriodicSync objects. This list may be empty but will never be null.
 * @apiSince 8
 */

public static java.util.List<android.content.PeriodicSync> getPeriodicSyncs(android.accounts.Account account, java.lang.String authority) { throw new RuntimeException("Stub!"); }

/**
 * Check if this account/provider is syncable.
 * <p>This method requires the caller to hold the permission
 * {@link android.Manifest.permission#READ_SYNC_SETTINGS}.
 * @return >0 if it is syncable, 0 if not, and <0 if the state isn't known yet.
 * @apiSince 5
 */

public static int getIsSyncable(android.accounts.Account account, java.lang.String authority) { throw new RuntimeException("Stub!"); }

/**
 * Set whether this account/provider is syncable.
 * <p>This method requires the caller to hold the permission
 * {@link android.Manifest.permission#WRITE_SYNC_SETTINGS}.
 * @param syncable >0 denotes syncable, 0 means not syncable, <0 means unknown
 * @apiSince 5
 */

public static void setIsSyncable(android.accounts.Account account, java.lang.String authority, int syncable) { throw new RuntimeException("Stub!"); }

/**
 * Gets the master auto-sync setting that applies to all the providers and accounts.
 * If this is false then the per-provider auto-sync setting is ignored.
 * <p>This method requires the caller to hold the permission
 * {@link android.Manifest.permission#READ_SYNC_SETTINGS}.
 *
 * @return the master auto-sync setting that applies to all the providers and accounts
 * @apiSince 5
 */

public static boolean getMasterSyncAutomatically() { throw new RuntimeException("Stub!"); }

/**
 * Sets the master auto-sync setting that applies to all the providers and accounts.
 * If this is false then the per-provider auto-sync setting is ignored.
 * <p>This method requires the caller to hold the permission
 * {@link android.Manifest.permission#WRITE_SYNC_SETTINGS}.
 *
 * @param sync the master auto-sync setting that applies to all the providers and accounts
 * @apiSince 5
 */

public static void setMasterSyncAutomatically(boolean sync) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if there is currently a sync operation for the given account or authority
 * actively being processed.
 * <p>This method requires the caller to hold the permission
 * {@link android.Manifest.permission#READ_SYNC_STATS}.
 * @param account the account whose setting we are querying
 * @param authority the provider whose behavior is being queried
 * @return true if a sync is active for the given account or authority.
 * @apiSince 5
 */

public static boolean isSyncActive(android.accounts.Account account, java.lang.String authority) { throw new RuntimeException("Stub!"); }

/**
 * If a sync is active returns the information about it, otherwise returns null.
 * <p>
 * This method requires the caller to hold the permission
 * {@link android.Manifest.permission#READ_SYNC_STATS}.
 * <p>
 * @return the SyncInfo for the currently active sync or null if one is not active.
 * @deprecated
 * Since multiple concurrent syncs are now supported you should use
 * {@link #getCurrentSyncs()} to get the accurate list of current syncs.
 * This method returns the first item from the list of current syncs
 * or null if there are none.
 * @apiSince 8
 * @deprecatedSince 15
 */

@Deprecated
public static android.content.SyncInfo getCurrentSync() { throw new RuntimeException("Stub!"); }

/**
 * Returns a list with information about all the active syncs. This list will be empty
 * if there are no active syncs.
 * <p>
 * This method requires the caller to hold the permission
 * {@link android.Manifest.permission#READ_SYNC_STATS}.
 * <p>
 * @return a List of SyncInfo objects for the currently active syncs.
 * @apiSince 11
 */

public static java.util.List<android.content.SyncInfo> getCurrentSyncs() { throw new RuntimeException("Stub!"); }

/**
 * Return true if the pending status is true of any matching authorities.
 * <p>This method requires the caller to hold the permission
 * {@link android.Manifest.permission#READ_SYNC_STATS}.
 * @param account the account whose setting we are querying
 * @param authority the provider whose behavior is being queried
 * @return true if there is a pending sync with the matching account and authority
 * @apiSince 5
 */

public static boolean isSyncPending(android.accounts.Account account, java.lang.String authority) { throw new RuntimeException("Stub!"); }

/**
 * Request notifications when the different aspects of the SyncManager change. The
 * different items that can be requested are:
 * <ul>
 * <li> {@link #SYNC_OBSERVER_TYPE_PENDING}
 * <li> {@link #SYNC_OBSERVER_TYPE_ACTIVE}
 * <li> {@link #SYNC_OBSERVER_TYPE_SETTINGS}
 * </ul>
 * The caller can set one or more of the status types in the mask for any
 * given listener registration.
 * @param mask the status change types that will cause the callback to be invoked
 * @param callback observer to be invoked when the status changes
 * @return a handle that can be used to remove the listener at a later time
 * @apiSince 5
 */

public static java.lang.Object addStatusChangeListener(int mask, android.content.SyncStatusObserver callback) { throw new RuntimeException("Stub!"); }

/**
 * Remove a previously registered status change listener.
 * @param handle the handle that was returned by {@link #addStatusChangeListener}
 * @apiSince 5
 */

public static void removeStatusChangeListener(java.lang.Object handle) { throw new RuntimeException("Stub!"); }

/**
 * Return a detailed description of the given MIME type, including an icon
 * and label that describe the type.
 *
 * @param mimeType Valid, concrete MIME type.
 
 * This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public final android.content.ContentResolver.MimeTypeInfo getTypeInfo(@androidx.annotation.NonNull java.lang.String mimeType) { throw new RuntimeException("Stub!"); }

/**
 * Convenience method that efficiently loads a visual thumbnail for the
 * given {@link android.net.Uri Uri}. Internally calls
 * {@link android.content.ContentProvider#openTypedAssetFile ContentProvider#openTypedAssetFile} on the remote provider, but
 * also defensively resizes any returned content to match the requested
 * target size.
 *
 * @param uri The item that should be visualized as a thumbnail.
 * This value must never be {@code null}.
 * @param size The target area on the screen where this thumbnail will be
 *            shown. This is passed to the provider as {@link #EXTRA_SIZE}
 *            to help it avoid downloading or generating heavy resources.
 * This value must never be {@code null}.
 * @param signal A signal to cancel the operation in progress.
 * This value may be {@code null}.
 * @return Valid {@link android.graphics.Bitmap Bitmap} which is a visual thumbnail.
 * This value will never be {@code null}.
 * @throws java.io.IOException If any trouble was encountered while generating or
 *             loading the thumbnail, or if
 *             {@link android.os.CancellationSignal#cancel() CancellationSignal#cancel()} was invoked.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.Bitmap loadThumbnail(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.NonNull android.util.Size size, @androidx.annotation.Nullable android.os.CancellationSignal signal) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * This is the Android platform's generic MIME type to match any MIME
 * type of the form "{@link #CURSOR_ITEM_BASE_TYPE}/{@code SUB_TYPE}".
 * {@code SUB_TYPE} is the sub-type of the application-dependent
 * content, e.g., "audio", "video", "playlist".
 * @apiSince 21
 */

public static final java.lang.String ANY_CURSOR_ITEM_TYPE = "vnd.android.cursor.item/*";

/**
 * This is the Android platform's base MIME type for a content: URI
 * containing a Cursor of zero or more items.  Applications should use this
 * as the base type along with their own sub-type of their content: URIs
 * that represent a directory of items.  For example, hypothetical IMAP email
 * client may have a URI
 * <code>content://com.company.provider.imap/inbox</code> for all of the
 * messages in its inbox, whose MIME type would be reported as
 * <code>CURSOR_DIR_BASE_TYPE + "/vnd.company.imap-msg"</code>
 *
 * <p>Note how the base MIME type varies between this and
 * {@link #CURSOR_ITEM_BASE_TYPE} depending on whether there is
 * one single item or multiple items in the data set, while the sub-type
 * remains the same because in either case the data structure contained
 * in the cursor is the same.
 * @apiSince 1
 */

public static final java.lang.String CURSOR_DIR_BASE_TYPE = "vnd.android.cursor.dir";

/**
 * This is the Android platform's base MIME type for a content: URI
 * containing a Cursor of a single item.  Applications should use this
 * as the base type along with their own sub-type of their content: URIs
 * that represent a particular item.  For example, hypothetical IMAP email
 * client may have a URI
 * <code>content://com.company.provider.imap/inbox/1</code> for a particular
 * message in the inbox, whose MIME type would be reported as
 * <code>CURSOR_ITEM_BASE_TYPE + "/vnd.company.imap-msg"</code>
 *
 * <p>Compare with {@link #CURSOR_DIR_BASE_TYPE}.
 * @apiSince 1
 */

public static final java.lang.String CURSOR_ITEM_BASE_TYPE = "vnd.android.cursor.item";

/**
 * Allows provider to report back to client which query keys are honored in a Cursor.
 *
 * <p>Key identifying a {@code String[]} containing all QUERY_ARG_SORT* arguments
 * honored by the provider. Include this in {@link android.database.Cursor Cursor} extras {@link android.os.Bundle Bundle}
 * when any QUERY_ARG_SORT* value was honored during the preparation of the
 * results {@link android.database.Cursor Cursor}.
 *
 * <p>If present, ALL honored arguments are enumerated in this extra’s payload.
 *
 * @see #QUERY_ARG_SORT_COLUMNS
 * @see #QUERY_ARG_SORT_DIRECTION
 * @see #QUERY_ARG_SORT_COLLATION
 * @apiSince 26
 */

public static final java.lang.String EXTRA_HONORED_ARGS = "android.content.extra.HONORED_ARGS";

/**
 * An extra boolean describing whether a particular provider supports refresh
 * or not. If a provider supports refresh, it should include this key in its
 * returned Cursor as part of its query call.
 *
 * @apiSince 26
 */

public static final java.lang.String EXTRA_REFRESH_SUPPORTED = "android.content.extra.REFRESH_SUPPORTED";

/**
 * An extra {@link android.graphics.Point Point} describing the optimal size for a requested image
 * resource, in pixels. If a provider has multiple sizes of the image, it
 * should return the image closest to this size.
 *
 * @see #openTypedAssetFileDescriptor(Uri, String, Bundle)
 * @see #openTypedAssetFileDescriptor(Uri, String, Bundle,
 *      CancellationSignal)
 * @apiSince 21
 */

public static final java.lang.String EXTRA_SIZE = "android.content.extra.SIZE";

/**
 * Added to {@link android.database.Cursor Cursor} extras {@link android.os.Bundle Bundle} to indicate total row count of
 * recordset when paging is supported. Providers must include this when
 * implementing paging support.
 *
 * <p>A provider may return -1 that row count of the recordset is unknown.
 *
 * <p>Providers having returned -1 in a previous query are recommended to
 * send content change notification once (if) full recordset size becomes
 * known.
 * @apiSince 26
 */

public static final java.lang.String EXTRA_TOTAL_COUNT = "android.content.extra.TOTAL_COUNT";

/**
 * Flag for {@link #notifyChange(android.net.Uri,android.database.ContentObserver,int)}: if set, this notification
 * will be skipped if it is being delivered to the root URI of a ContentObserver that is
 * using "notify for descendants."  The purpose of this is to allow the provide to send
 * a general notification of "something under X" changed that observers of that specific
 * URI can receive, while also sending a specific URI under X.  It would use this flag
 * when sending the former, so that observers of "X and descendants" only see the latter.
 * @apiSince 24
 */

public static final int NOTIFY_SKIP_NOTIFY_FOR_DESCENDANTS = 2; // 0x2

/**
 * Flag for {@link #notifyChange(android.net.Uri,android.database.ContentObserver,int)}: attempt to sync the change
 * to the network.
 * @apiSince 24
 */

public static final int NOTIFY_SYNC_TO_NETWORK = 1; // 0x1

/**
 * Specifies the max number of rows to include in a Cursor.
 * @apiSince 26
 */

public static final java.lang.String QUERY_ARG_LIMIT = "android:query-arg-limit";

/**
 * Specifies the offset row index within a Cursor.
 * @apiSince 26
 */

public static final java.lang.String QUERY_ARG_OFFSET = "android:query-arg-offset";

/**
 * Allows client to specify a hint to the provider declaring which collation
 * to use when sorting text values.
 *
 * <p>Providers may support custom collators. When specifying a custom collator
 * the value is determined by the Provider.
 *
 * <li>{@link android.content.ContentProvider ContentProvider} implementations: When preparing data in
 * {@link android.content.ContentProvider#query(android.net.Uri,java.lang.String[],android.os.Bundle,android.os.CancellationSignal) ContentProvider#query(Uri, String[], Bundle, CancellationSignal)}, if sort collation
 * is reflected in the returned Cursor, it is  strongly recommended that
 * {@link #QUERY_ARG_SORT_COLLATION} then be included in the array of honored arguments
 * reflected in {@link android.database.Cursor Cursor} extras {@link android.os.Bundle Bundle} under {@link #EXTRA_HONORED_ARGS}.
 *
 * <li>When querying a provider, where no QUERY_ARG_SQL* otherwise exists in the
 * arguments {@link android.os.Bundle Bundle}, the Content framework will attempt to synthesize
 * a QUERY_ARG_SQL* argument using the corresponding QUERY_ARG_SORT* values.
 *
 * @see java.text.Collator#PRIMARY
 * @see java.text.Collator#SECONDARY
 * @see java.text.Collator#TERTIARY
 * @see java.text.Collator#IDENTICAL
 * @apiSince 26
 */

public static final java.lang.String QUERY_ARG_SORT_COLLATION = "android:query-arg-sort-collation";

/**
 * Specifies the list of columns against which to sort results. When first column values
 * are identical, records are then sorted based on second column values, and so on.
 *
 * <p>Columns present in this list must also be included in the projection
 * supplied to {@link android.content.ContentResolver#query(android.net.Uri,java.lang.String[],android.os.Bundle,android.os.CancellationSignal) ContentResolver#query(Uri, String[], Bundle, CancellationSignal)}.
 *
 * <p>Apps targeting {@link android.os.Build.VERSION_CODES#O} or higher:
 *
 * <li>{@link android.content.ContentProvider ContentProvider} implementations: When preparing data in
 * {@link android.content.ContentProvider#query(android.net.Uri,java.lang.String[],android.os.Bundle,android.os.CancellationSignal) ContentProvider#query(Uri, String[], Bundle, CancellationSignal)}, if sort columns
 * is reflected in the returned Cursor, it is  strongly recommended that
 * {@link #QUERY_ARG_SORT_COLUMNS} then be included in the array of honored arguments
 * reflected in {@link android.database.Cursor Cursor} extras {@link android.os.Bundle Bundle} under {@link #EXTRA_HONORED_ARGS}.
 *
 * <li>When querying a provider, where no QUERY_ARG_SQL* otherwise exists in the
 * arguments {@link android.os.Bundle Bundle}, the Content framework will attempt to synthesize
 * an QUERY_ARG_SQL* argument using the corresponding QUERY_ARG_SORT* values.
 * @apiSince 26
 */

public static final java.lang.String QUERY_ARG_SORT_COLUMNS = "android:query-arg-sort-columns";

/**
 * Specifies desired sort order. When unspecified a provider may provide a default
 * sort direction, or choose to return unsorted results.
 *
 * <p>Apps targeting {@link android.os.Build.VERSION_CODES#O} or higher:
 *
 * <li>{@link android.content.ContentProvider ContentProvider} implementations: When preparing data in
 * {@link android.content.ContentProvider#query(android.net.Uri,java.lang.String[],android.os.Bundle,android.os.CancellationSignal) ContentProvider#query(Uri, String[], Bundle, CancellationSignal)}, if sort direction
 * is reflected in the returned Cursor, it is  strongly recommended that
 * {@link #QUERY_ARG_SORT_DIRECTION} then be included in the array of honored arguments
 * reflected in {@link android.database.Cursor Cursor} extras {@link android.os.Bundle Bundle} under {@link #EXTRA_HONORED_ARGS}.
 *
 * <li>When querying a provider, where no QUERY_ARG_SQL* otherwise exists in the
 * arguments {@link android.os.Bundle Bundle}, the Content framework will attempt to synthesize
 * a QUERY_ARG_SQL* argument using the corresponding QUERY_ARG_SORT* values.
 *
 * @see #QUERY_SORT_DIRECTION_ASCENDING
 * @see #QUERY_SORT_DIRECTION_DESCENDING
 * @apiSince 26
 */

public static final java.lang.String QUERY_ARG_SORT_DIRECTION = "android:query-arg-sort-direction";

/**
 * Key for an SQL style selection string that may be present in the query Bundle argument
 * passed to {@link android.content.ContentProvider#query(android.net.Uri,java.lang.String[],android.os.Bundle,android.os.CancellationSignal) ContentProvider#query(Uri, String[], Bundle, CancellationSignal)}
 * when called by a legacy client.
 *
 * <p>Clients should never include user supplied values directly in the selection string,
 * as this presents an avenue for SQL injection attacks. In lieu of this, a client
 * should use standard placeholder notation to represent values in a selection string,
 * then supply a corresponding value in {@value #QUERY_ARG_SQL_SELECTION_ARGS}.
 *
 * <p><b>Apps targeting {@link android.os.Build.VERSION_CODES#O} or higher are strongly
 * encourage to use structured query arguments in lieu of opaque SQL query clauses.</b>
 *
 * @see #QUERY_ARG_SORT_COLUMNS
 * @see #QUERY_ARG_SORT_DIRECTION
 * @see #QUERY_ARG_SORT_COLLATION
 * @apiSince 26
 */

public static final java.lang.String QUERY_ARG_SQL_SELECTION = "android:query-arg-sql-selection";

/**
 * Key for SQL selection string arguments list.
 *
 * <p>Clients should never include user supplied values directly in the selection string,
 * as this presents an avenue for SQL injection attacks. In lieu of this, a client
 * should use standard placeholder notation to represent values in a selection string,
 * then supply a corresponding value in {@value #QUERY_ARG_SQL_SELECTION_ARGS}.
 *
 * <p><b>Apps targeting {@link android.os.Build.VERSION_CODES#O} or higher are strongly
 * encourage to use structured query arguments in lieu of opaque SQL query clauses.</b>
 *
 * @see #QUERY_ARG_SORT_COLUMNS
 * @see #QUERY_ARG_SORT_DIRECTION
 * @see #QUERY_ARG_SORT_COLLATION
 * @apiSince 26
 */

public static final java.lang.String QUERY_ARG_SQL_SELECTION_ARGS = "android:query-arg-sql-selection-args";

/**
 * Key for an SQL style sort string that may be present in the query Bundle argument
 * passed to {@link android.content.ContentProvider#query(android.net.Uri,java.lang.String[],android.os.Bundle,android.os.CancellationSignal) ContentProvider#query(Uri, String[], Bundle, CancellationSignal)}
 * when called by a legacy client.
 *
 * <p><b>Apps targeting {@link android.os.Build.VERSION_CODES#O} or higher are strongly
 * encourage to use structured query arguments in lieu of opaque SQL query clauses.</b>
 *
 * @see #QUERY_ARG_SORT_COLUMNS
 * @see #QUERY_ARG_SORT_DIRECTION
 * @see #QUERY_ARG_SORT_COLLATION
 * @apiSince 26
 */

public static final java.lang.String QUERY_ARG_SQL_SORT_ORDER = "android:query-arg-sql-sort-order";

/** @apiSince 26 */

public static final int QUERY_SORT_DIRECTION_ASCENDING = 0; // 0x0

/** @apiSince 26 */

public static final int QUERY_SORT_DIRECTION_DESCENDING = 1; // 0x1

/** @apiSince 1 */

public static final java.lang.String SCHEME_ANDROID_RESOURCE = "android.resource";

/** @apiSince 1 */

public static final java.lang.String SCHEME_CONTENT = "content";

/** @apiSince 1 */

public static final java.lang.String SCHEME_FILE = "file";

/**
 * @deprecated instead use
 * {@link #requestSync(android.accounts.Account,java.lang.String,android.os.Bundle)}
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String SYNC_EXTRAS_ACCOUNT = "account";

/**
 * Indicates that the sync adapter should not proceed with the delete operations,
 * if it determines that there are too many.
 * See {@link android.content.SyncResult#tooManyDeletions SyncResult#tooManyDeletions}
 * @apiSince 1
 */

public static final java.lang.String SYNC_EXTRAS_DISCARD_LOCAL_DELETIONS = "discard_deletions";

/**
 * If this extra is set to true then the request will not be retried if it fails.
 * @apiSince 8
 */

public static final java.lang.String SYNC_EXTRAS_DO_NOT_RETRY = "do_not_retry";

/**
 * If this extra is set to true, the sync request will be scheduled
 * at the front of the sync request queue and without any delay
 * @apiSince 1
 */

public static final java.lang.String SYNC_EXTRAS_EXPEDITED = "expedited";

/**
 * @deprecated instead use
 * {@link #SYNC_EXTRAS_MANUAL}
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final java.lang.String SYNC_EXTRAS_FORCE = "force";

/**
 * If this extra is set to true then any backoffs for the initial attempt (e.g.&nbsp;due to retries)
 * are ignored by the sync scheduler. If this request fails and gets rescheduled then the
 * retries will still honor the backoff.
 * @apiSince 8
 */

public static final java.lang.String SYNC_EXTRAS_IGNORE_BACKOFF = "ignore_backoff";

/**
 * If this extra is set to true then the sync settings (like getSyncAutomatically())
 * are ignored by the sync scheduler.
 * @apiSince 8
 */

public static final java.lang.String SYNC_EXTRAS_IGNORE_SETTINGS = "ignore_settings";

/**
 * Set by the SyncManager to request that the SyncAdapter initialize itself for
 * the given account/authority pair. One required initialization step is to
 * ensure that {@link #setIsSyncable(android.accounts.Account,java.lang.String,int)} has been
 * called with a >= 0 value. When this flag is set the SyncAdapter does not need to
 * do a full sync, though it is allowed to do so.
 * @apiSince 5
 */

public static final java.lang.String SYNC_EXTRAS_INITIALIZE = "initialize";

/**
 * Setting this extra is the equivalent of setting both {@link #SYNC_EXTRAS_IGNORE_SETTINGS}
 * and {@link #SYNC_EXTRAS_IGNORE_BACKOFF}
 * @apiSince 5
 */

public static final java.lang.String SYNC_EXTRAS_MANUAL = "force";

/**
 * Indicates that the sync adapter should proceed with the delete operations,
 * even if it determines that there are too many.
 * See {@link android.content.SyncResult#tooManyDeletions SyncResult#tooManyDeletions}
 * @apiSince 1
 */

public static final java.lang.String SYNC_EXTRAS_OVERRIDE_TOO_MANY_DELETIONS = "deletions_override";

/**
 * If this extra is set to true, the sync request will be scheduled
 * only when the device is plugged in. This is equivalent to calling
 * setRequiresCharging(true) on {@link android.content.SyncRequest SyncRequest}.
 * @apiSince 24
 */

public static final java.lang.String SYNC_EXTRAS_REQUIRE_CHARGING = "require_charging";

/**
 * Indicates that this sync is intended to only upload local changes to the server.
 * For example, this will be set to true if the sync is initiated by a call to
 * {@link android.content.ContentResolver#notifyChange(android.net.Uri,android.database.ContentObserver,boolean) ContentResolver#notifyChange(android.net.Uri, android.database.ContentObserver, boolean)}
 * @apiSince 1
 */

public static final java.lang.String SYNC_EXTRAS_UPLOAD = "upload";

/** @apiSince 8 */

public static final int SYNC_OBSERVER_TYPE_ACTIVE = 4; // 0x4

/** @apiSince 8 */

public static final int SYNC_OBSERVER_TYPE_PENDING = 2; // 0x2

/** @apiSince 8 */

public static final int SYNC_OBSERVER_TYPE_SETTINGS = 1; // 0x1
/**
 * Detailed description of a specific MIME type, including an icon and label
 * that describe the type.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class MimeTypeInfo {

MimeTypeInfo() { throw new RuntimeException("Stub!"); }

/**
 * Return a visual representation of this MIME type. This can be styled
 * using {@link android.graphics.drawable.Icon#setTint(int) Icon#setTint(int)} to match surrounding UI.
 *
 * @see android.graphics.drawable.Icon#loadDrawable(Context)
 * @see android.widget.ImageView#setImageDrawable(Drawable)
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.drawable.Icon getIcon() { throw new RuntimeException("Stub!"); }

/**
 * Return a textual representation of this MIME type.
 *
 * @see android.widget.TextView#setText(CharSequence)
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.lang.CharSequence getLabel() { throw new RuntimeException("Stub!"); }

/**
 * Return a content description for this MIME type.
 *
 * @see android.view.View#setContentDescription(CharSequence)
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.lang.CharSequence getContentDescription() { throw new RuntimeException("Stub!"); }
}

}

