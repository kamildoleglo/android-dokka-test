/*
 * Copyright (C) 2013 The Android Open Source Project
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


package android.provider;

import android.provider.DocumentsContract.Document;
import android.os.CancellationSignal;
import android.provider.DocumentsContract.Root;
import android.content.Intent;
import android.graphics.Point;
import android.Manifest;
import android.app.AuthenticationRequiredException;
import android.net.Uri;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.content.Context;

/**
 * Base class for a document provider. A document provider offers read and write
 * access to durable files, such as files stored on a local disk, or files in a
 * cloud storage service. To create a document provider, extend this class,
 * implement the abstract methods, and add it to your manifest like this:
 *
 * <pre class="prettyprint">&lt;manifest&gt;
 *    ...
 *    &lt;application&gt;
 *        ...
 *        &lt;provider
 *            android:name="com.example.MyCloudProvider"
 *            android:authorities="com.example.mycloudprovider"
 *            android:exported="true"
 *            android:grantUriPermissions="true"
 *            android:permission="android.permission.MANAGE_DOCUMENTS"
 *            android:enabled="@bool/isAtLeastKitKat"&gt;
 *            &lt;intent-filter&gt;
 *                &lt;action android:name="android.content.action.DOCUMENTS_PROVIDER" /&gt;
 *            &lt;/intent-filter&gt;
 *        &lt;/provider&gt;
 *        ...
 *    &lt;/application&gt;
 *&lt;/manifest&gt;</pre>
 * <p>
 * When defining your provider, you must protect it with
 * {@link android.Manifest.permission#MANAGE_DOCUMENTS}, which is a permission
 * only the system can obtain. Applications cannot use a documents provider
 * directly; they must go through {@link android.content.Intent#ACTION_OPEN_DOCUMENT Intent#ACTION_OPEN_DOCUMENT} or
 * {@link android.content.Intent#ACTION_CREATE_DOCUMENT Intent#ACTION_CREATE_DOCUMENT} which requires a user to actively
 * navigate and select documents. When a user selects documents through that UI,
 * the system issues narrow URI permission grants to the requesting application.
 * </p>
 * <h3>Documents</h3>
 * <p>
 * A document can be either an openable stream (with a specific MIME type), or a
 * directory containing additional documents (with the
 * {@link android.provider.DocumentsContract.Document#MIME_TYPE_DIR Document#MIME_TYPE_DIR} MIME type). Each directory represents the top
 * of a subtree containing zero or more documents, which can recursively contain
 * even more documents and directories.
 * </p>
 * <p>
 * Each document can have different capabilities, as described by
 * {@link android.provider.DocumentsContract.Document#COLUMN_FLAGS Document#COLUMN_FLAGS}. For example, if a document can be represented
 * as a thumbnail, your provider can set
 * {@link android.provider.DocumentsContract.Document#FLAG_SUPPORTS_THUMBNAIL Document#FLAG_SUPPORTS_THUMBNAIL} and implement
 * {@link #openDocumentThumbnail(java.lang.String,android.graphics.Point,android.os.CancellationSignal)} to return
 * that thumbnail.
 * </p>
 * <p>
 * Each document under a provider is uniquely referenced by its
 * {@link android.provider.DocumentsContract.Document#COLUMN_DOCUMENT_ID Document#COLUMN_DOCUMENT_ID}, which must not change once returned. A
 * single document can be included in multiple directories when responding to
 * {@link #queryChildDocuments(java.lang.String,java.lang.String[],java.lang.String)}. For example, a
 * provider might surface a single photo in multiple locations: once in a
 * directory of geographic locations, and again in a directory of dates.
 * </p>
 * <h3>Roots</h3>
 * <p>
 * All documents are surfaced through one or more "roots." Each root represents
 * the top of a document tree that a user can navigate. For example, a root
 * could represent an account or a physical storage device. Similar to
 * documents, each root can have capabilities expressed through
 * {@link android.provider.DocumentsContract.Root#COLUMN_FLAGS Root#COLUMN_FLAGS}.
 * </p>
 *
 * @see android.content.Intent#ACTION_OPEN_DOCUMENT
 * @see android.content.Intent#ACTION_OPEN_DOCUMENT_TREE
 * @see android.content.Intent#ACTION_CREATE_DOCUMENT
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class DocumentsProvider extends android.content.ContentProvider {

public DocumentsProvider() { throw new RuntimeException("Stub!"); }

/**
 * Implementation is provided by the parent class.
 * @apiSince 19
 */

public void attachInfo(android.content.Context context, android.content.pm.ProviderInfo info) { throw new RuntimeException("Stub!"); }

/**
 * Test if a document is descendant (child, grandchild, etc) from the given
 * parent. For example, providers must implement this to support
 * {@link android.content.Intent#ACTION_OPEN_DOCUMENT_TREE Intent#ACTION_OPEN_DOCUMENT_TREE}. You should avoid making network
 * requests to keep this request fast.
 *
 * @param parentDocumentId parent to verify against.
 * @param documentId child to verify.
 * @return if given document is a descendant of the given parent.
 * @see android.provider.DocumentsContract.Root#FLAG_SUPPORTS_IS_CHILD
 * @apiSince 21
 */

public boolean isChildDocument(java.lang.String parentDocumentId, java.lang.String documentId) { throw new RuntimeException("Stub!"); }

/**
 * Create a new document and return its newly generated
 * {@link android.provider.DocumentsContract.Document#COLUMN_DOCUMENT_ID Document#COLUMN_DOCUMENT_ID}. You must allocate a new
 * {@link android.provider.DocumentsContract.Document#COLUMN_DOCUMENT_ID Document#COLUMN_DOCUMENT_ID} to represent the document, which must
 * not change once returned.
 *
 * @param parentDocumentId the parent directory to create the new document
 *            under.
 * @param mimeType the concrete MIME type associated with the new document.
 *            If the MIME type is not supported, the provider must throw.
 * @param displayName the display name of the new document. The provider may
 *            alter this name to meet any internal constraints, such as
 *            avoiding conflicting names.
 
 * @throws android.app.AuthenticationRequiredException If authentication is required from the user (such as
 *             login credentials), but it is not guaranteed that the client will handle this
 *             properly.
 * @apiSince 19
 */

public java.lang.String createDocument(java.lang.String parentDocumentId, java.lang.String mimeType, java.lang.String displayName) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Rename an existing document.
 * <p>
 * If a different {@link android.provider.DocumentsContract.Document#COLUMN_DOCUMENT_ID Document#COLUMN_DOCUMENT_ID} must be used to
 * represent the renamed document, generate and return it. Any outstanding
 * URI permission grants will be updated to point at the new document. If
 * the original {@link android.provider.DocumentsContract.Document#COLUMN_DOCUMENT_ID Document#COLUMN_DOCUMENT_ID} is still valid after the
 * rename, return {@code null}.
 *
 * @param documentId the document to rename.
 * @param displayName the updated display name of the document. The provider
 *            may alter this name to meet any internal constraints, such as
 *            avoiding conflicting names.
 * @throws android.app.AuthenticationRequiredException If authentication is required from
 *            the user (such as login credentials), but it is not guaranteed
 *            that the client will handle this properly.
 * @apiSince 21
 */

public java.lang.String renameDocument(java.lang.String documentId, java.lang.String displayName) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Delete the requested document.
 * <p>
 * Upon returning, any URI permission grants for the given document will be
 * revoked. If additional documents were deleted as a side effect of this
 * call (such as documents inside a directory) the implementor is
 * responsible for revoking those permissions using
 * {@link #revokeDocumentPermission(java.lang.String)}.
 *
 * @param documentId the document to delete.
 * @throws android.app.AuthenticationRequiredException If authentication is required from
 *            the user (such as login credentials), but it is not guaranteed
 *            that the client will handle this properly.
 * @apiSince 19
 */

public void deleteDocument(java.lang.String documentId) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Copy the requested document or a document tree.
 * <p>
 * Copies a document including all child documents to another location within
 * the same document provider. Upon completion returns the document id of
 * the copied document at the target destination. {@code null} must never
 * be returned.
 *
 * @param sourceDocumentId the document to copy.
 * @param targetParentDocumentId the target document to be copied into as a child.
 * @throws android.app.AuthenticationRequiredException If authentication is required from
 *            the user (such as login credentials), but it is not guaranteed
 *            that the client will handle this properly.
 * @apiSince 24
 */

public java.lang.String copyDocument(java.lang.String sourceDocumentId, java.lang.String targetParentDocumentId) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Move the requested document or a document tree.
 *
 * <p>Moves a document including all child documents to another location within
 * the same document provider. Upon completion returns the document id of
 * the copied document at the target destination. {@code null} must never
 * be returned.
 *
 * <p>It's the responsibility of the provider to revoke grants if the document
 * is no longer accessible using <code>sourceDocumentId</code>.
 *
 * @param sourceDocumentId the document to move.
 * @param sourceParentDocumentId the parent of the document to move.
 * @param targetParentDocumentId the target document to be a new parent of the
 *     source document.
 * @throws android.app.AuthenticationRequiredException If authentication is required from
 *            the user (such as login credentials), but it is not guaranteed
 *            that the client will handle this properly.
 * @apiSince 24
 */

public java.lang.String moveDocument(java.lang.String sourceDocumentId, java.lang.String sourceParentDocumentId, java.lang.String targetParentDocumentId) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Removes the requested document or a document tree.
 *
 * <p>In contrast to {@link #deleteDocument} it requires specifying the parent.
 * This method is especially useful if the document can be in multiple parents.
 *
 * <p>It's the responsibility of the provider to revoke grants if the document is
 * removed from the last parent, and effectively the document is deleted.
 *
 * @param documentId the document to remove.
 * @param parentDocumentId the parent of the document to move.
 * @throws android.app.AuthenticationRequiredException If authentication is required from
 *            the user (such as login credentials), but it is not guaranteed
 *            that the client will handle this properly.
 * @apiSince 24
 */

public void removeDocument(java.lang.String documentId, java.lang.String parentDocumentId) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Finds the canonical path for the requested document. The path must start
 * from the parent document if parentDocumentId is not null or the root document
 * if parentDocumentId is null. If there are more than one path to this document,
 * return the most typical one. Include both the parent document or root document
 * and the requested document in the returned path.
 *
 * <p>This API assumes that document ID has enough info to infer the root.
 * Different roots should use different document ID to refer to the same
 * document.
 *
 *
 * @param parentDocumentId the document from which the path starts if not null,
 *     or null to indicate a path from the root is requested.
 * This value may be {@code null}.
 * @param childDocumentId the document which path is requested.
 * @return the path of the requested document. If parentDocumentId is null
 *     returned root ID must not be null. If parentDocumentId is not null
 *     returned root ID must be null.
 * @throws android.app.AuthenticationRequiredException If authentication is required from
 *            the user (such as login credentials), but it is not guaranteed
 *            that the client will handle this properly.
 * @apiSince 26
 */

public android.provider.DocumentsContract.Path findDocumentPath(@androidx.annotation.Nullable java.lang.String parentDocumentId, java.lang.String childDocumentId) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Creates an intent sender for a web link, if the document is web linkable.
 * <p>
 * {@link android.app.AuthenticationRequiredException AuthenticationRequiredException} can be thrown if user does not have
 * sufficient permission for the linked document. Before any new permissions
 * are granted for the linked document, a visible UI must be shown, so the
 * user can explicitly confirm whether the permission grants are expected.
 * The user must be able to cancel the operation.
 * <p>
 * Options passed as an argument may include a list of recipients, such
 * as email addresses. The provider should reflect these options if possible,
 * but it's acceptable to ignore them. In either case, confirmation UI must
 * be shown before any new permission grants are granted.
 * <p>
 * It is all right to generate a web link without granting new permissions,
 * if opening the link would result in a page for requesting permission
 * access. If it's impossible then the operation must fail by throwing an exception.
 *
 * @param documentId the document to create a web link intent for.
 * @param options additional information, such as list of recipients. Optional.
 * This value may be {@code null}.
 * @throws android.app.AuthenticationRequiredException If authentication is required from
 *            the user (such as login credentials), but it is not guaranteed
 *            that the client will handle this properly.
 *
 * @see android.provider.DocumentsContract.Document#FLAG_WEB_LINKABLE
 * @see android.app.PendingIntent#getIntentSender
 * @apiSince 26
 */

public android.content.IntentSender createWebLinkIntent(java.lang.String documentId, @androidx.annotation.Nullable android.os.Bundle options) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Return all roots currently provided. To display to users, you must define
 * at least one root. You should avoid making network requests to keep this
 * request fast.
 * <p>
 * Each root is defined by the metadata columns described in {@link android.provider.DocumentsContract.Root Root},
 * including {@link android.provider.DocumentsContract.Root#COLUMN_DOCUMENT_ID Root#COLUMN_DOCUMENT_ID} which points to a directory
 * representing a tree of documents to display under that root.
 * <p>
 * If this set of roots changes, you must call {@link android.content.ContentResolver#notifyChange(android.net.Uri,android.database.ContentObserver,boolean) ContentResolver#notifyChange(Uri,
 * android.database.ContentObserver, boolean)} with
 * {@link android.provider.DocumentsContract#buildRootsUri(java.lang.String) DocumentsContract#buildRootsUri(String)} to notify the system.
 * <p>
 *
 * @param projection list of {@link android.provider.DocumentsContract.Root Root} columns to put into the cursor. If
 *            {@code null} all supported columns should be included.
 * @apiSince 19
 */

public abstract android.database.Cursor queryRoots(java.lang.String[] projection) throws java.io.FileNotFoundException;

/**
 * Return recently modified documents under the requested root. This will
 * only be called for roots that advertise
 * {@link android.provider.DocumentsContract.Root#FLAG_SUPPORTS_RECENTS Root#FLAG_SUPPORTS_RECENTS}. The returned documents should be
 * sorted by {@link android.provider.DocumentsContract.Document#COLUMN_LAST_MODIFIED Document#COLUMN_LAST_MODIFIED} in descending order, and
 * limited to only return the 64 most recently modified documents.
 * <p>
 * Recent documents do not support change notifications.
 *
 * @param projection list of {@link android.provider.DocumentsContract.Document Document} columns to put into the
 *            cursor. If {@code null} all supported columns should be
 *            included.
 * @see android.provider.DocumentsContract#EXTRA_LOADING
 * @apiSince 19
 */

public android.database.Cursor queryRecentDocuments(java.lang.String rootId, java.lang.String[] projection) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Return recently modified documents under the requested root. This will
 * only be called for roots that advertise
 * {@link android.provider.DocumentsContract.Root#FLAG_SUPPORTS_RECENTS Root#FLAG_SUPPORTS_RECENTS}. The returned documents should be
 * sorted by {@link android.provider.DocumentsContract.Document#COLUMN_LAST_MODIFIED Document#COLUMN_LAST_MODIFIED} in descending order of
 * the most recently modified documents.
 * <p>
 * If this method is overriden by the concrete DocumentsProvider and
 * {@link android.content.ContentResolver#QUERY_ARG_LIMIT ContentResolver#QUERY_ARG_LIMIT} is specified with a nonnegative
 * int under queryArgs, the result will be limited by that number and
 * {@link android.content.ContentResolver#QUERY_ARG_LIMIT ContentResolver#QUERY_ARG_LIMIT} will be specified under
 * {@link android.content.ContentResolver#EXTRA_HONORED_ARGS ContentResolver#EXTRA_HONORED_ARGS}. Otherwise, a default 64 limit
 * will be used and no QUERY_ARG* will be specified under
 * {@link android.content.ContentResolver#EXTRA_HONORED_ARGS ContentResolver#EXTRA_HONORED_ARGS}.
 * <p>
 * Recent documents do not support change notifications.
 *
 * @param projection list of {@link android.provider.DocumentsContract.Document Document} columns to put into the
 *            cursor. If {@code null} all supported columns should be
 *            included.
 * This value may be {@code null}.
 * @param queryArgs the extra query arguments.
 * This value may be {@code null}.
 * @param signal used by the caller to signal if the request should be
 *            cancelled. May be null.
 * This value may be {@code null}.
 * @see android.provider.DocumentsContract#EXTRA_LOADING
 
 * @param rootId This value must never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.database.Cursor queryRecentDocuments(@androidx.annotation.NonNull java.lang.String rootId, @androidx.annotation.Nullable java.lang.String[] projection, @androidx.annotation.Nullable android.os.Bundle queryArgs, @androidx.annotation.Nullable android.os.CancellationSignal signal) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Return metadata for the single requested document. You should avoid
 * making network requests to keep this request fast.
 *
 * @param documentId the document to return.
 * @param projection list of {@link android.provider.DocumentsContract.Document Document} columns to put into the
 *            cursor. If {@code null} all supported columns should be
 *            included.
 * @throws android.app.AuthenticationRequiredException If authentication is required from
 *            the user (such as login credentials), but it is not guaranteed
 *            that the client will handle this properly.
 * @apiSince 19
 */

public abstract android.database.Cursor queryDocument(java.lang.String documentId, java.lang.String[] projection) throws java.io.FileNotFoundException;

/**
 * Return the children documents contained in the requested directory. This
 * must only return immediate descendants, as additional queries will be
 * issued to recursively explore the tree.
 * <p>
 * Apps targeting {@link android.os.Build.VERSION_CODES#O} or higher
 * should override {@link #queryChildDocuments(java.lang.String,java.lang.String[],android.os.Bundle)}.
 * <p>
 * If your provider is cloud-based, and you have some data cached or pinned
 * locally, you may return the local data immediately, setting
 * {@link android.provider.DocumentsContract#EXTRA_LOADING DocumentsContract#EXTRA_LOADING} on the Cursor to indicate that
 * you are still fetching additional data. Then, when the network data is
 * available, you can send a change notification to trigger a requery and
 * return the complete contents. To return a Cursor with extras, you need to
 * extend and override {@link android.database.Cursor#getExtras() Cursor#getExtras()}.
 * <p>
 * To support change notifications, you must
 * {@link android.database.Cursor#setNotificationUri(android.content.ContentResolver,android.net.Uri) Cursor#setNotificationUri(ContentResolver, Uri)} with a relevant
 * Uri, such as
 * {@link android.provider.DocumentsContract#buildChildDocumentsUri(java.lang.String,java.lang.String) DocumentsContract#buildChildDocumentsUri(String, String)}. Then
 * you can call {@link android.content.ContentResolver#notifyChange(android.net.Uri,android.database.ContentObserver,boolean) ContentResolver#notifyChange(Uri,
 * android.database.ContentObserver, boolean)} with that Uri to send change
 * notifications.
 *
 * @param parentDocumentId the directory to return children for.
 * @param projection list of {@link android.provider.DocumentsContract.Document Document} columns to put into the
 *            cursor. If {@code null} all supported columns should be
 *            included.
 * @param sortOrder how to order the rows, formatted as an SQL
 *            {@code ORDER BY} clause (excluding the ORDER BY itself).
 *            Passing {@code null} will use the default sort order, which
 *            may be unordered. This ordering is a hint that can be used to
 *            prioritize how data is fetched from the network, but UI may
 *            always enforce a specific ordering.
 * @throws android.app.AuthenticationRequiredException If authentication is required from
 *            the user (such as login credentials), but it is not guaranteed
 *            that the client will handle this properly.
 * @see android.provider.DocumentsContract#EXTRA_LOADING
 * @see android.provider.DocumentsContract#EXTRA_INFO
 * @see android.provider.DocumentsContract#EXTRA_ERROR
 * @apiSince 19
 */

public abstract android.database.Cursor queryChildDocuments(java.lang.String parentDocumentId, java.lang.String[] projection, java.lang.String sortOrder) throws java.io.FileNotFoundException;

/**
 * Override this method to return the children documents contained
 * in the requested directory. This must return immediate descendants only.
 *
 * <p>If your provider is cloud-based, and you have data cached
 * locally, you may return the local data immediately, setting
 * {@link android.provider.DocumentsContract#EXTRA_LOADING DocumentsContract#EXTRA_LOADING} on Cursor extras to indicate that
 * you are still fetching additional data. Then, when the network data is
 * available, you can send a change notification to trigger a requery and
 * return the complete contents. To return a Cursor with extras, you need to
 * extend and override {@link android.database.Cursor#getExtras() Cursor#getExtras()}.
 *
 * <p>To support change notifications, you must
 * {@link android.database.Cursor#setNotificationUri(android.content.ContentResolver,android.net.Uri) Cursor#setNotificationUri(ContentResolver, Uri)} with a relevant
 * Uri, such as
 * {@link android.provider.DocumentsContract#buildChildDocumentsUri(java.lang.String,java.lang.String) DocumentsContract#buildChildDocumentsUri(String, String)}. Then
 * you can call {@link android.content.ContentResolver#notifyChange(android.net.Uri,android.database.ContentObserver,boolean) ContentResolver#notifyChange(Uri,
 * android.database.ContentObserver, boolean)} with that Uri to send change
 * notifications.
 *
 * @param parentDocumentId the directory to return children for.
 * @param projection list of {@link android.provider.DocumentsContract.Document Document} columns to put into the
 *            cursor. If {@code null} all supported columns should be
 *            included.
 * This value may be {@code null}.
 * @param queryArgs Bundle containing sorting information or other
 *            argument useful to the provider. If no sorting
 *            information is available, default sorting
 *            will be used, which may be unordered. See
 *            {@link android.content.ContentResolver#QUERY_ARG_SORT_COLUMNS ContentResolver#QUERY_ARG_SORT_COLUMNS} for
 *            details.
 * This value may be {@code null}.
 * @throws android.app.AuthenticationRequiredException If authentication is required from
 *            the user (such as login credentials), but it is not guaranteed
 *            that the client will handle this properly.
 *
 * @see android.provider.DocumentsContract#EXTRA_LOADING
 * @see android.provider.DocumentsContract#EXTRA_INFO
 * @see android.provider.DocumentsContract#EXTRA_ERROR
 * @apiSince 26
 */

public android.database.Cursor queryChildDocuments(java.lang.String parentDocumentId, @androidx.annotation.Nullable java.lang.String[] projection, @androidx.annotation.Nullable android.os.Bundle queryArgs) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Return documents that match the given query under the requested
 * root. The returned documents should be sorted by relevance in descending
 * order. How documents are matched against the query string is an
 * implementation detail left to each provider, but it's suggested that at
 * least {@link android.provider.DocumentsContract.Document#COLUMN_DISPLAY_NAME Document#COLUMN_DISPLAY_NAME} be matched in a
 * case-insensitive fashion.
 * <p>
 * If your provider is cloud-based, and you have some data cached or pinned
 * locally, you may return the local data immediately, setting
 * {@link android.provider.DocumentsContract#EXTRA_LOADING DocumentsContract#EXTRA_LOADING} on the Cursor to indicate that
 * you are still fetching additional data. Then, when the network data is
 * available, you can send a change notification to trigger a requery and
 * return the complete contents.
 * <p>
 * To support change notifications, you must
 * {@link android.database.Cursor#setNotificationUri(android.content.ContentResolver,android.net.Uri) Cursor#setNotificationUri(ContentResolver, Uri)} with a relevant
 * Uri, such as {@link android.provider.DocumentsContract#buildSearchDocumentsUri(java.lang.String,java.lang.String,java.lang.String) DocumentsContract#buildSearchDocumentsUri(String,
 * String, String)}. Then you can call {@link android.content.ContentResolver#notifyChange(android.net.Uri,android.database.ContentObserver,boolean) ContentResolver#notifyChange(Uri,
 * android.database.ContentObserver, boolean)} with that Uri to send change
 * notifications.
 *
 * @param rootId the root to search under.
 * @param query string to match documents against.
 * @param projection list of {@link android.provider.DocumentsContract.Document Document} columns to put into the
 *            cursor. If {@code null} all supported columns should be
 *            included.
 * @throws android.app.AuthenticationRequiredException If authentication is required from
 *            the user (such as login credentials), but it is not guaranteed
 *            that the client will handle this properly.
 *
 * @see android.provider.DocumentsContract#EXTRA_LOADING
 * @see android.provider.DocumentsContract#EXTRA_INFO
 * @see android.provider.DocumentsContract#EXTRA_ERROR
 * @apiSince 19
 */

public android.database.Cursor querySearchDocuments(java.lang.String rootId, java.lang.String query, java.lang.String[] projection) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Return documents that match the given query under the requested
 * root. The returned documents should be sorted by relevance in descending
 * order. How documents are matched against the query string is an
 * implementation detail left to each provider, but it's suggested that at
 * least {@link android.provider.DocumentsContract.Document#COLUMN_DISPLAY_NAME Document#COLUMN_DISPLAY_NAME} be matched in a
 * case-insensitive fashion.
 * <p>
 * If your provider is cloud-based, and you have some data cached or pinned
 * locally, you may return the local data immediately, setting
 * {@link android.provider.DocumentsContract#EXTRA_LOADING DocumentsContract#EXTRA_LOADING} on the Cursor to indicate that
 * you are still fetching additional data. Then, when the network data is
 * available, you can send a change notification to trigger a requery and
 * return the complete contents.
 * <p>
 * To support change notifications, you must
 * {@link android.database.Cursor#setNotificationUri(android.content.ContentResolver,android.net.Uri) Cursor#setNotificationUri(ContentResolver, Uri)} with a relevant
 * Uri, such as {@link android.provider.DocumentsContract#buildSearchDocumentsUri(java.lang.String,java.lang.String,java.lang.String) DocumentsContract#buildSearchDocumentsUri(String,
 * String, String)}. Then you can call {@link android.content.ContentResolver#notifyChange(android.net.Uri,android.database.ContentObserver,boolean) ContentResolver#notifyChange(Uri,
 * android.database.ContentObserver, boolean)} with that Uri to send change
 * notifications.
 *
 * @param rootId the root to search under.
 * This value must never be {@code null}.
 * @param projection list of {@link android.provider.DocumentsContract.Document Document} columns to put into the
 *            cursor. If {@code null} all supported columns should be
 *            included.
 * This value may be {@code null}.
 * @param queryArgs the query arguments.
 *            {@link android.provider.DocumentsContract#QUERY_ARG_EXCLUDE_MEDIA DocumentsContract#QUERY_ARG_EXCLUDE_MEDIA},
 *            {@link android.provider.DocumentsContract#QUERY_ARG_DISPLAY_NAME DocumentsContract#QUERY_ARG_DISPLAY_NAME},
 *            {@link android.provider.DocumentsContract#QUERY_ARG_MIME_TYPES DocumentsContract#QUERY_ARG_MIME_TYPES},
 *            {@link android.provider.DocumentsContract#QUERY_ARG_FILE_SIZE_OVER DocumentsContract#QUERY_ARG_FILE_SIZE_OVER},
 *            {@link android.provider.DocumentsContract#QUERY_ARG_LAST_MODIFIED_AFTER DocumentsContract#QUERY_ARG_LAST_MODIFIED_AFTER}.
 * This value must never be {@code null}.
 * @return cursor containing search result. Include
 *         {@link android.content.ContentResolver#EXTRA_HONORED_ARGS ContentResolver#EXTRA_HONORED_ARGS} in {@link android.database.Cursor Cursor}
 *         extras {@link android.os.Bundle Bundle} when any QUERY_ARG_* value was honored
 *         during the preparation of the results.
 *
 * @see android.provider.DocumentsContract.Root#COLUMN_QUERY_ARGS
 * @see android.content.ContentResolver#EXTRA_HONORED_ARGS
 * @see android.provider.DocumentsContract#EXTRA_LOADING
 * @see android.provider.DocumentsContract#EXTRA_INFO
 * @see android.provider.DocumentsContract#EXTRA_ERROR
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.database.Cursor querySearchDocuments(@androidx.annotation.NonNull java.lang.String rootId, @androidx.annotation.Nullable java.lang.String[] projection, @androidx.annotation.NonNull android.os.Bundle queryArgs) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Ejects the root. Throws {@link java.lang.IllegalStateException IllegalStateException} if ejection failed.
 *
 * @param rootId the root to be ejected.
 * @see android.provider.DocumentsContract.Root#FLAG_SUPPORTS_EJECT
 * @apiSince 26
 */

public void ejectRoot(java.lang.String rootId) { throw new RuntimeException("Stub!"); }

/**
 * Returns metadata associated with the document. The type of metadata returned
 * is specific to the document type. For example the data returned for an image
 * file will likely consist primarily or solely of EXIF metadata.
 *
 * <p>The returned {@link android.os.Bundle Bundle} will contain zero or more entries depending
 * on the type of data supported by the document provider.
 *
 * <ol>
 * <li>A {@link android.provider.DocumentsContract#METADATA_TYPES DocumentsContract#METADATA_TYPES} containing a {@code String[]} value.
 *     The string array identifies the type or types of metadata returned. Each
 *     value in the can be used to access a {@link android.os.Bundle Bundle} of data
 *     containing that type of data.
 * <li>An entry each for each type of returned metadata. Each set of metadata is
 *     itself represented as a bundle and accessible via a string key naming
 *     the type of data.
 * </ol>
 *
 * @param documentId get the metadata of the document
 * This value must never be {@code null}.
 * @return a Bundle of Bundles.
 * This value may be {@code null}.
 * @see android.provider.DocumentsContract#getDocumentMetadata(ContentResolver, Uri)
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.os.Bundle getDocumentMetadata(@androidx.annotation.NonNull java.lang.String documentId) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Return concrete MIME type of the requested document. Must match the value
 * of {@link android.provider.DocumentsContract.Document#COLUMN_MIME_TYPE Document#COLUMN_MIME_TYPE} for this document. The default
 * implementation queries {@link #queryDocument(java.lang.String,java.lang.String[])}, so
 * providers may choose to override this as an optimization.
 * <p>
 * @throws android.app.AuthenticationRequiredException If authentication is required from
 *            the user (such as login credentials), but it is not guaranteed
 *            that the client will handle this properly.
 * @apiSince 19
 */

public java.lang.String getDocumentType(java.lang.String documentId) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Open and return the requested document.
 * <p>
 * Your provider should return a reliable {@link android.os.ParcelFileDescriptor ParcelFileDescriptor} to
 * detect when the remote caller has finished reading or writing the
 * document.
 * <p>
 * Mode "r" should always be supported. Provider should throw
 * {@link java.lang.UnsupportedOperationException UnsupportedOperationException} if the passing mode is not supported.
 * You may return a pipe or socket pair if the mode is exclusively "r" or
 * "w", but complex modes like "rw" imply a normal file on disk that
 * supports seeking.
 * <p>
 * If you block while downloading content, you should periodically check
 * {@link android.os.CancellationSignal#isCanceled() CancellationSignal#isCanceled()} to abort abandoned open requests.
 *
 * @param documentId the document to return.
 * @param mode the mode to open with, such as 'r', 'w', or 'rw'.
 * @param signal used by the caller to signal if the request should be
 *            cancelled. May be null.
 * This value may be {@code null}.
 * @throws android.app.AuthenticationRequiredException If authentication is required from
 *            the user (such as login credentials), but it is not guaranteed
 *            that the client will handle this properly.
 * @see ParcelFileDescriptor#open(java.io.File, int, android.os.Handler,
 *      OnCloseListener)
 * @see android.os.ParcelFileDescriptor#createReliablePipe()
 * @see android.os.ParcelFileDescriptor#createReliableSocketPair()
 * @see android.os.ParcelFileDescriptor#parseMode(String)
 * @apiSince 19
 */

public abstract android.os.ParcelFileDescriptor openDocument(java.lang.String documentId, java.lang.String mode, @androidx.annotation.Nullable android.os.CancellationSignal signal) throws java.io.FileNotFoundException;

/**
 * Open and return a thumbnail of the requested document.
 * <p>
 * A provider should return a thumbnail closely matching the hinted size,
 * attempting to serve from a local cache if possible. A provider should
 * never return images more than double the hinted size.
 * <p>
 * If you perform expensive operations to download or generate a thumbnail,
 * you should periodically check {@link android.os.CancellationSignal#isCanceled() CancellationSignal#isCanceled()} to
 * abort abandoned thumbnail requests.
 *
 * @param documentId the document to return.
 * @param sizeHint hint of the optimal thumbnail dimensions.
 * @param signal used by the caller to signal if the request should be
 *            cancelled. May be null.
 * @throws android.app.AuthenticationRequiredException If authentication is required from
 *            the user (such as login credentials), but it is not guaranteed
 *            that the client will handle this properly.
 * @see android.provider.DocumentsContract.Document#FLAG_SUPPORTS_THUMBNAIL
 * @apiSince 19
 */

public android.content.res.AssetFileDescriptor openDocumentThumbnail(java.lang.String documentId, android.graphics.Point sizeHint, android.os.CancellationSignal signal) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Open and return the document in a format matching the specified MIME
 * type filter.
 * <p>
 * A provider may perform a conversion if the documents's MIME type is not
 * matching the specified MIME type filter.
 * <p>
 * Virtual documents must have at least one streamable format.
 *
 * @param documentId the document to return.
 * @param mimeTypeFilter the MIME type filter for the requested format. May
 *            be *\/*, which matches any MIME type.
 * @param opts extra options from the client. Specific to the content
 *            provider.
 * @param signal used by the caller to signal if the request should be
 *            cancelled. May be null.
 * @throws android.app.AuthenticationRequiredException If authentication is required from
 *            the user (such as login credentials), but it is not guaranteed
 *            that the client will handle this properly.
 * @see #getDocumentStreamTypes(String, String)
 * @apiSince 24
 */

public android.content.res.AssetFileDescriptor openTypedDocument(java.lang.String documentId, java.lang.String mimeTypeFilter, android.os.Bundle opts, android.os.CancellationSignal signal) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public final android.database.Cursor query(android.net.Uri uri, java.lang.String[] projection, java.lang.String selection, java.lang.String[] selectionArgs, java.lang.String sortOrder) { throw new RuntimeException("Stub!"); }

/**
 * WARNING: Sub-classes should not override this method. This method is non-final
 * solely for the purposes of backwards compatibility.
 *
 * @see #queryChildDocuments(String, String[], Bundle),
 *      {@link #queryDocument(java.lang.String,java.lang.String[])},
 *      {@link #queryRecentDocuments(java.lang.String,java.lang.String[])},
 *      {@link #queryRoots(java.lang.String[])}, and
 *      {@link #querySearchDocuments(java.lang.String,java.lang.String[],android.os.Bundle)}.
 * @apiSince 19
 */

public android.database.Cursor query(android.net.Uri uri, java.lang.String[] projection, java.lang.String selection, java.lang.String[] selectionArgs, java.lang.String sortOrder, android.os.CancellationSignal cancellationSignal) { throw new RuntimeException("Stub!"); }

/**
 * Implementation is provided by the parent class. Cannot be overridden.
 *
 * @see #queryRoots(String[])
 * @see #queryRecentDocuments(String, String[], Bundle, CancellationSignal)
 * @see #queryDocument(String, String[])
 * @see #queryChildDocuments(String, String[], String)
 * @see #querySearchDocuments(String, String[], Bundle)
 * @apiSince 26
 */

public final android.database.Cursor query(android.net.Uri uri, java.lang.String[] projection, android.os.Bundle queryArgs, android.os.CancellationSignal cancellationSignal) { throw new RuntimeException("Stub!"); }

/**
 * Implementation is provided by the parent class. Cannot be overridden.
 *
 * @see #getDocumentType(String)
 * @apiSince 19
 */

public final java.lang.String getType(android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Implementation is provided by the parent class. Can be overridden to
 * provide additional functionality, but subclasses <em>must</em> always
 * call the superclass. If the superclass returns {@code null}, the subclass
 * may implement custom behavior.
 * <p>
 * This is typically used to resolve a subtree URI into a concrete document
 * reference, issuing a narrower single-document URI permission grant along
 * the way.
 *
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @see android.provider.DocumentsContract#buildDocumentUriUsingTree(Uri, String)
 * @apiSince 19
 */

public android.net.Uri canonicalize(android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Implementation is provided by the parent class. Throws by default, and
 * cannot be overridden.
 *
 * @see #createDocument(String, String, String)
 * @apiSince 19
 */

public final android.net.Uri insert(android.net.Uri uri, android.content.ContentValues values) { throw new RuntimeException("Stub!"); }

/**
 * Implementation is provided by the parent class. Throws by default, and
 * cannot be overridden.
 *
 * @see #deleteDocument(String)
 * @apiSince 19
 */

public final int delete(android.net.Uri uri, java.lang.String selection, java.lang.String[] selectionArgs) { throw new RuntimeException("Stub!"); }

/**
 * Implementation is provided by the parent class. Throws by default, and
 * cannot be overridden.
 * @apiSince 19
 */

public final int update(android.net.Uri uri, android.content.ContentValues values, java.lang.String selection, java.lang.String[] selectionArgs) { throw new RuntimeException("Stub!"); }

/**
 * Implementation is provided by the parent class. Can be overridden to
 * provide additional functionality, but subclasses <em>must</em> always
 * call the superclass. If the superclass returns {@code null}, the subclass
 * may implement custom behavior.
 
 * <br>
 * If you override this method you <em>must</em> call through to the
 * superclass implementation.
 * @apiSince 19
 */

public android.os.Bundle call(java.lang.String method, java.lang.String arg, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Revoke any active permission grants for the given
 * {@link android.provider.DocumentsContract.Document#COLUMN_DOCUMENT_ID Document#COLUMN_DOCUMENT_ID}, usually called when a document
 * becomes invalid. Follows the same semantics as
 * {@link android.content.Context#revokeUriPermission(android.net.Uri,int) Context#revokeUriPermission(Uri, int)}.
 * @apiSince 21
 */

public final void revokeDocumentPermission(java.lang.String documentId) { throw new RuntimeException("Stub!"); }

/**
 * Implementation is provided by the parent class. Cannot be overridden.
 *
 * @see #openDocument(String, String, CancellationSignal)
 * @apiSince 19
 */

public final android.os.ParcelFileDescriptor openFile(android.net.Uri uri, java.lang.String mode) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Implementation is provided by the parent class. Cannot be overridden.
 *
 * @see #openDocument(String, String, CancellationSignal)
 * @apiSince 19
 */

public final android.os.ParcelFileDescriptor openFile(android.net.Uri uri, java.lang.String mode, android.os.CancellationSignal signal) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Implementation is provided by the parent class. Cannot be overridden.
 *
 * @see #openDocument(String, String, CancellationSignal)
 * @apiSince 19
 */

public final android.content.res.AssetFileDescriptor openAssetFile(android.net.Uri uri, java.lang.String mode) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Implementation is provided by the parent class. Cannot be overridden.
 *
 * @see #openDocument(String, String, CancellationSignal)
 * @apiSince 19
 */

public final android.content.res.AssetFileDescriptor openAssetFile(android.net.Uri uri, java.lang.String mode, android.os.CancellationSignal signal) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Implementation is provided by the parent class. Cannot be overridden.
 *
 * @see #openDocumentThumbnail(String, Point, CancellationSignal)
 * @see #openTypedDocument(String, String, Bundle, CancellationSignal)
 * @see #getDocumentStreamTypes(String, String)
 * @apiSince 19
 */

public final android.content.res.AssetFileDescriptor openTypedAssetFile(android.net.Uri uri, java.lang.String mimeTypeFilter, android.os.Bundle opts) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Implementation is provided by the parent class. Cannot be overridden.
 *
 * @see #openDocumentThumbnail(String, Point, CancellationSignal)
 * @see #openTypedDocument(String, String, Bundle, CancellationSignal)
 * @see #getDocumentStreamTypes(String, String)
 * @apiSince 19
 */

public final android.content.res.AssetFileDescriptor openTypedAssetFile(android.net.Uri uri, java.lang.String mimeTypeFilter, android.os.Bundle opts, android.os.CancellationSignal signal) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Return a list of streamable MIME types matching the filter, which can be passed to
 * {@link #openTypedDocument(java.lang.String,java.lang.String,android.os.Bundle,android.os.CancellationSignal)}.
 *
 * <p>The default implementation returns a MIME type provided by
 * {@link #queryDocument(java.lang.String,java.lang.String[])} as long as it matches the filter and the document
 * does not have the {@link android.provider.DocumentsContract.Document#FLAG_VIRTUAL_DOCUMENT Document#FLAG_VIRTUAL_DOCUMENT} flag set.
 *
 * <p>Virtual documents must have at least one streamable format.
 *
 * @see #getStreamTypes(Uri, String)
 * @see #openTypedDocument(String, String, Bundle, CancellationSignal)
 * @apiSince 24
 */

public java.lang.String[] getDocumentStreamTypes(java.lang.String documentId, java.lang.String mimeTypeFilter) { throw new RuntimeException("Stub!"); }

/**
 * Called by a client to determine the types of data streams that this content provider
 * support for the given URI.
 *
 * <p>Overriding this method is deprecated. Override {@link #openTypedDocument} instead.
 *
 * @see #getDocumentStreamTypes(String, String)
 * @apiSince 19
 */

public java.lang.String[] getStreamTypes(android.net.Uri uri, java.lang.String mimeTypeFilter) { throw new RuntimeException("Stub!"); }
}

