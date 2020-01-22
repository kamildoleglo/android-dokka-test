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

import android.content.Intent;
import android.os.Build;
import android.net.Uri;
import android.content.Context;
import android.os.CancellationSignal;
import android.graphics.Point;
import android.os.Bundle;
import android.media.ExifInterface;
import android.content.IntentSender;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.content.ContentResolver;
import android.os.ParcelFileDescriptor.OnCloseListener;
import android.os.ParcelFileDescriptor;

/**
 * Defines the contract between a documents provider and the platform.
 * <p>
 * To create a document provider, extend {@link android.provider.DocumentsProvider DocumentsProvider}, which
 * provides a foundational implementation of this contract.
 * <p>
 * All client apps must hold a valid URI permission grant to access documents,
 * typically issued when a user makes a selection through
 * {@link android.content.Intent#ACTION_OPEN_DOCUMENT Intent#ACTION_OPEN_DOCUMENT}, {@link android.content.Intent#ACTION_CREATE_DOCUMENT Intent#ACTION_CREATE_DOCUMENT},
 * or {@link android.content.Intent#ACTION_OPEN_DOCUMENT_TREE Intent#ACTION_OPEN_DOCUMENT_TREE}.
 *
 * @see android.provider.DocumentsProvider
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class DocumentsContract {

private DocumentsContract() { throw new RuntimeException("Stub!"); }

/**
 * Build URI representing the roots of a document provider. When queried, a
 * provider will return one or more rows with columns defined by
 * {@link android.provider.DocumentsContract.Root Root}.
 *
 * @see android.provider.DocumentsProvider#queryRoots(String[])
 * @apiSince 19
 */

public static android.net.Uri buildRootsUri(java.lang.String authority) { throw new RuntimeException("Stub!"); }

/**
 * Build URI representing the given {@link android.provider.DocumentsContract.Root#COLUMN_ROOT_ID Root#COLUMN_ROOT_ID} in a
 * document provider.
 *
 * @see #getRootId(Uri)
 * @apiSince 19
 */

public static android.net.Uri buildRootUri(java.lang.String authority, java.lang.String rootId) { throw new RuntimeException("Stub!"); }

/**
 * Build URI representing the recently modified documents of a specific root
 * in a document provider. When queried, a provider will return zero or more
 * rows with columns defined by {@link android.provider.DocumentsContract.Document Document}.
 *
 * @see android.provider.DocumentsProvider#queryRecentDocuments(String, String[])
 * @see #getRootId(Uri)
 * @apiSince 19
 */

public static android.net.Uri buildRecentDocumentsUri(java.lang.String authority, java.lang.String rootId) { throw new RuntimeException("Stub!"); }

/**
 * Build URI representing access to descendant documents of the given
 * {@link android.provider.DocumentsContract.Document#COLUMN_DOCUMENT_ID Document#COLUMN_DOCUMENT_ID}.
 *
 * @see #getTreeDocumentId(Uri)
 * @apiSince 21
 */

public static android.net.Uri buildTreeDocumentUri(java.lang.String authority, java.lang.String documentId) { throw new RuntimeException("Stub!"); }

/**
 * Build URI representing the target {@link android.provider.DocumentsContract.Document#COLUMN_DOCUMENT_ID Document#COLUMN_DOCUMENT_ID} in
 * a document provider. When queried, a provider will return a single row
 * with columns defined by {@link android.provider.DocumentsContract.Document Document}.
 *
 * @see android.provider.DocumentsProvider#queryDocument(String, String[])
 * @see #getDocumentId(Uri)
 * @apiSince 19
 */

public static android.net.Uri buildDocumentUri(java.lang.String authority, java.lang.String documentId) { throw new RuntimeException("Stub!"); }

/**
 * Build URI representing the target {@link android.provider.DocumentsContract.Document#COLUMN_DOCUMENT_ID Document#COLUMN_DOCUMENT_ID} in
 * a document provider. When queried, a provider will return a single row
 * with columns defined by {@link android.provider.DocumentsContract.Document Document}.
 * <p>
 * However, instead of directly accessing the target document, the returned
 * URI will leverage access granted through a subtree URI, typically
 * returned by {@link android.content.Intent#ACTION_OPEN_DOCUMENT_TREE Intent#ACTION_OPEN_DOCUMENT_TREE}. The target document
 * must be a descendant (child, grandchild, etc) of the subtree.
 * <p>
 * This is typically used to access documents under a user-selected
 * directory tree, since it doesn't require the user to separately confirm
 * each new document access.
 *
 * @param treeUri the subtree to leverage to gain access to the target
 *            document. The target directory must be a descendant of this
 *            subtree.
 * @param documentId the target document, which the caller may not have
 *            direct access to.
 * @see android.content.Intent#ACTION_OPEN_DOCUMENT_TREE
 * @see android.provider.DocumentsProvider#isChildDocument(String, String)
 * @see #buildDocumentUri(String, String)
 * @apiSince 21
 */

public static android.net.Uri buildDocumentUriUsingTree(android.net.Uri treeUri, java.lang.String documentId) { throw new RuntimeException("Stub!"); }

/**
 * Build URI representing the children of the target directory in a document
 * provider. When queried, a provider will return zero or more rows with
 * columns defined by {@link android.provider.DocumentsContract.Document Document}.
 *
 * @param parentDocumentId the document to return children for, which must
 *            be a directory with MIME type of
 *            {@link android.provider.DocumentsContract.Document#MIME_TYPE_DIR Document#MIME_TYPE_DIR}.
 * @see android.provider.DocumentsProvider#queryChildDocuments(String, String[], String)
 * @see #getDocumentId(Uri)
 * @apiSince 19
 */

public static android.net.Uri buildChildDocumentsUri(java.lang.String authority, java.lang.String parentDocumentId) { throw new RuntimeException("Stub!"); }

/**
 * Build URI representing the children of the target directory in a document
 * provider. When queried, a provider will return zero or more rows with
 * columns defined by {@link android.provider.DocumentsContract.Document Document}.
 * <p>
 * However, instead of directly accessing the target directory, the returned
 * URI will leverage access granted through a subtree URI, typically
 * returned by {@link android.content.Intent#ACTION_OPEN_DOCUMENT_TREE Intent#ACTION_OPEN_DOCUMENT_TREE}. The target
 * directory must be a descendant (child, grandchild, etc) of the subtree.
 * <p>
 * This is typically used to access documents under a user-selected
 * directory tree, since it doesn't require the user to separately confirm
 * each new document access.
 *
 * @param treeUri the subtree to leverage to gain access to the target
 *            document. The target directory must be a descendant of this
 *            subtree.
 * @param parentDocumentId the document to return children for, which the
 *            caller may not have direct access to, and which must be a
 *            directory with MIME type of {@link android.provider.DocumentsContract.Document#MIME_TYPE_DIR Document#MIME_TYPE_DIR}.
 * @see android.content.Intent#ACTION_OPEN_DOCUMENT_TREE
 * @see android.provider.DocumentsProvider#isChildDocument(String, String)
 * @see #buildChildDocumentsUri(String, String)
 * @apiSince 21
 */

public static android.net.Uri buildChildDocumentsUriUsingTree(android.net.Uri treeUri, java.lang.String parentDocumentId) { throw new RuntimeException("Stub!"); }

/**
 * Build URI representing a search for matching documents under a specific
 * root in a document provider. When queried, a provider will return zero or
 * more rows with columns defined by {@link android.provider.DocumentsContract.Document Document}.
 *
 * @see android.provider.DocumentsProvider#querySearchDocuments(String, String, String[])
 * @see #getRootId(Uri)
 * @see #getSearchDocumentsQuery(Uri)
 * @apiSince 19
 */

public static android.net.Uri buildSearchDocumentsUri(java.lang.String authority, java.lang.String rootId, java.lang.String query) { throw new RuntimeException("Stub!"); }

/**
 * Test if the given URI represents a {@link android.provider.DocumentsContract.Document Document} backed by a
 * {@link android.provider.DocumentsProvider DocumentsProvider}.
 *
 * @see #buildDocumentUri(String, String)
 * @see #buildDocumentUriUsingTree(Uri, String)
 
 * @param uri This value may be {@code null}.
 * @apiSince 19
 */

public static boolean isDocumentUri(android.content.Context context, @androidx.annotation.Nullable android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Test if the given URI represents all roots of the authority
 * backed by {@link android.provider.DocumentsProvider DocumentsProvider}.
 *
 * @see #buildRootsUri(String)
 
 * @param context This value must never be {@code null}.
 
 * @param uri This value may be {@code null}.
 * @apiSince 29
 */

public static boolean isRootsUri(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Test if the given URI represents specific root backed by {@link android.provider.DocumentsProvider DocumentsProvider}.
 *
 * @see #buildRootUri(String, String)
 
 * @param context This value must never be {@code null}.
 
 * @param uri This value may be {@code null}.
 * @apiSince 29
 */

public static boolean isRootUri(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Test if the given URI represents a {@link android.provider.DocumentsContract.Document Document} tree.
 *
 * @see #buildTreeDocumentUri(String, String)
 * @see #getTreeDocumentId(Uri)
 * @apiSince 24
 */

public static boolean isTreeUri(android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Extract the {@link android.provider.DocumentsContract.Root#COLUMN_ROOT_ID Root#COLUMN_ROOT_ID} from the given URI.
 * @apiSince 19
 */

public static java.lang.String getRootId(android.net.Uri rootUri) { throw new RuntimeException("Stub!"); }

/**
 * Extract the {@link android.provider.DocumentsContract.Document#COLUMN_DOCUMENT_ID Document#COLUMN_DOCUMENT_ID} from the given URI.
 *
 * @see #isDocumentUri(Context, Uri)
 * @apiSince 19
 */

public static java.lang.String getDocumentId(android.net.Uri documentUri) { throw new RuntimeException("Stub!"); }

/**
 * Extract the via {@link android.provider.DocumentsContract.Document#COLUMN_DOCUMENT_ID Document#COLUMN_DOCUMENT_ID} from the given URI.
 * @apiSince 21
 */

public static java.lang.String getTreeDocumentId(android.net.Uri documentUri) { throw new RuntimeException("Stub!"); }

/**
 * Extract the search query from a URI built by
 * {@link #buildSearchDocumentsUri(java.lang.String,java.lang.String,java.lang.String)}.
 * @apiSince 19
 */

public static java.lang.String getSearchDocumentsQuery(android.net.Uri searchDocumentsUri) { throw new RuntimeException("Stub!"); }

/**
 * Return thumbnail representing the document at the given URI. Callers are
 * responsible for their own in-memory caching.
 *
 * @param documentUri document to return thumbnail for, which must have
 *            {@link android.provider.DocumentsContract.Document#FLAG_SUPPORTS_THUMBNAIL Document#FLAG_SUPPORTS_THUMBNAIL} set.
 * This value must never be {@code null}.
 * @param size optimal thumbnail size desired. A provider may return a
 *            thumbnail of a different size, but never more than double the
 *            requested size.
 * This value must never be {@code null}.
 * @param signal signal used to indicate if caller is no longer interested
 *            in the thumbnail.
 * This value may be {@code null}.
 * @param content This value must never be {@code null}.
 * @return decoded thumbnail, or {@code null} if problem was encountered.
 * @see android.provider.DocumentsProvider#openDocumentThumbnail(String, Point,
 *      android.os.CancellationSignal)
 * @apiSince 19
 */

@androidx.annotation.Nullable
public static android.graphics.Bitmap getDocumentThumbnail(@androidx.annotation.NonNull android.content.ContentResolver content, @androidx.annotation.NonNull android.net.Uri documentUri, @androidx.annotation.NonNull android.graphics.Point size, @androidx.annotation.Nullable android.os.CancellationSignal signal) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Create a new document with given MIME type and display name.
 *
 * @param parentDocumentUri directory with {@link android.provider.DocumentsContract.Document#FLAG_DIR_SUPPORTS_CREATE Document#FLAG_DIR_SUPPORTS_CREATE}
 * This value must never be {@code null}.
 * @param mimeType MIME type of new document
 * This value must never be {@code null}.
 * @param displayName name of new document
 * This value must never be {@code null}.
 * @param content This value must never be {@code null}.
 * @return newly created document, or {@code null} if failed
 * @apiSince 21
 */

@androidx.annotation.Nullable
public static android.net.Uri createDocument(@androidx.annotation.NonNull android.content.ContentResolver content, @androidx.annotation.NonNull android.net.Uri parentDocumentUri, @androidx.annotation.NonNull java.lang.String mimeType, @androidx.annotation.NonNull java.lang.String displayName) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Test if a document is descendant (child, grandchild, etc) from the given
 * parent.
 *
 * @param parentDocumentUri parent to verify against.
 * This value must never be {@code null}.
 * @param childDocumentUri child to verify.
 * This value must never be {@code null}.
 * @param content This value must never be {@code null}.
 * @return if given document is a descendant of the given parent.
 * @see android.provider.DocumentsContract.Root#FLAG_SUPPORTS_IS_CHILD
 * @apiSince 29
 */

public static boolean isChildDocument(@androidx.annotation.NonNull android.content.ContentResolver content, @androidx.annotation.NonNull android.net.Uri parentDocumentUri, @androidx.annotation.NonNull android.net.Uri childDocumentUri) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Change the display name of an existing document.
 * <p>
 * If the underlying provider needs to create a new
 * {@link android.provider.DocumentsContract.Document#COLUMN_DOCUMENT_ID Document#COLUMN_DOCUMENT_ID} to represent the updated display
 * name, that new document is returned and the original document is no
 * longer valid. Otherwise, the original document is returned.
 *
 * @param documentUri document with {@link android.provider.DocumentsContract.Document#FLAG_SUPPORTS_RENAME Document#FLAG_SUPPORTS_RENAME}
 * This value must never be {@code null}.
 * @param displayName updated name for document
 * This value must never be {@code null}.
 * @param content This value must never be {@code null}.
 * @return the existing or new document after the rename, or {@code null} if
 *         failed.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public static android.net.Uri renameDocument(@androidx.annotation.NonNull android.content.ContentResolver content, @androidx.annotation.NonNull android.net.Uri documentUri, @androidx.annotation.NonNull java.lang.String displayName) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Delete the given document.
 *
 * @param documentUri document with {@link android.provider.DocumentsContract.Document#FLAG_SUPPORTS_DELETE Document#FLAG_SUPPORTS_DELETE}
 * This value must never be {@code null}.
 * @param content This value must never be {@code null}.
 * @return if the document was deleted successfully.
 * @apiSince 19
 */

public static boolean deleteDocument(@androidx.annotation.NonNull android.content.ContentResolver content, @androidx.annotation.NonNull android.net.Uri documentUri) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Copies the given document.
 *
 * @param sourceDocumentUri document with {@link android.provider.DocumentsContract.Document#FLAG_SUPPORTS_COPY Document#FLAG_SUPPORTS_COPY}
 * This value must never be {@code null}.
 * @param targetParentDocumentUri document which will become a parent of the source
 *         document's copy.
 * This value must never be {@code null}.
 * @param content This value must never be {@code null}.
 * @return the copied document, or {@code null} if failed.
 * @apiSince 24
 */

@androidx.annotation.Nullable
public static android.net.Uri copyDocument(@androidx.annotation.NonNull android.content.ContentResolver content, @androidx.annotation.NonNull android.net.Uri sourceDocumentUri, @androidx.annotation.NonNull android.net.Uri targetParentDocumentUri) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Moves the given document under a new parent.
 *
 * @param sourceDocumentUri document with {@link android.provider.DocumentsContract.Document#FLAG_SUPPORTS_MOVE Document#FLAG_SUPPORTS_MOVE}
 * This value must never be {@code null}.
 * @param sourceParentDocumentUri parent document of the document to move.
 * This value must never be {@code null}.
 * @param targetParentDocumentUri document which will become a new parent of the source
 *         document.
 * This value must never be {@code null}.
 * @param content This value must never be {@code null}.
 * @return the moved document, or {@code null} if failed.
 * @apiSince 24
 */

@androidx.annotation.Nullable
public static android.net.Uri moveDocument(@androidx.annotation.NonNull android.content.ContentResolver content, @androidx.annotation.NonNull android.net.Uri sourceDocumentUri, @androidx.annotation.NonNull android.net.Uri sourceParentDocumentUri, @androidx.annotation.NonNull android.net.Uri targetParentDocumentUri) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Removes the given document from a parent directory.
 *
 * <p>In contrast to {@link #deleteDocument} it requires specifying the parent.
 * This method is especially useful if the document can be in multiple parents.
 *
 * @param documentUri document with {@link android.provider.DocumentsContract.Document#FLAG_SUPPORTS_REMOVE Document#FLAG_SUPPORTS_REMOVE}
 * This value must never be {@code null}.
 * @param parentDocumentUri parent document of the document to remove.
 * This value must never be {@code null}.
 * @param content This value must never be {@code null}.
 * @return true if the document was removed successfully.
 * @apiSince 24
 */

public static boolean removeDocument(@androidx.annotation.NonNull android.content.ContentResolver content, @androidx.annotation.NonNull android.net.Uri documentUri, @androidx.annotation.NonNull android.net.Uri parentDocumentUri) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Ejects the given root. It throws {@link java.lang.IllegalStateException IllegalStateException} when ejection failed.
 *
 * @param rootUri root with {@link android.provider.DocumentsContract.Root#FLAG_SUPPORTS_EJECT Root#FLAG_SUPPORTS_EJECT} to be ejected
 
 * This value must never be {@code null}.
 * @param content This value must never be {@code null}.
 * @apiSince 26
 */

public static void ejectRoot(@androidx.annotation.NonNull android.content.ContentResolver content, @androidx.annotation.NonNull android.net.Uri rootUri) { throw new RuntimeException("Stub!"); }

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
 * <p>Example:
 * <p><pre><code>
 *     Bundle metadata = DocumentsContract.getDocumentMetadata(client, imageDocUri, tags);
 *     if (metadata.containsKey(DocumentsContract.METADATA_EXIF)) {
 *         Bundle exif = metadata.getBundle(DocumentsContract.METADATA_EXIF);
 *         int imageLength = exif.getInt(ExifInterface.TAG_IMAGE_LENGTH);
 *     }
 * </code></pre>
 *
 * @param documentUri a Document URI
 * This value must never be {@code null}.
 * @param content This value must never be {@code null}.
 * @return a Bundle of Bundles.
 
 * This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public static android.os.Bundle getDocumentMetadata(@androidx.annotation.NonNull android.content.ContentResolver content, @androidx.annotation.NonNull android.net.Uri documentUri) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Finds the canonical path from the top of the document tree.
 *
 * The {@link android.provider.DocumentsContract.Path#getPath() Path#getPath()} of the return value contains the document ID
 * of all documents along the path from the top the document tree to the
 * requested document, both inclusive.
 *
 * The {@link android.provider.DocumentsContract.Path#getRootId() Path#getRootId()} of the return value returns {@code null}.
 *
 * @param treeUri treeUri of the document which path is requested.
 * This value must never be {@code null}.
 * @param content This value must never be {@code null}.
 * @return the path of the document, or {@code null} if failed.
 * @see android.provider.DocumentsProvider#findDocumentPath(String, String)
 * @apiSince 26
 */

@androidx.annotation.Nullable
public static android.provider.DocumentsContract.Path findDocumentPath(@androidx.annotation.NonNull android.content.ContentResolver content, @androidx.annotation.NonNull android.net.Uri treeUri) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Creates an intent for obtaining a web link for the specified document.
 *
 * <p>Note, that due to internal limitations, if there is already a web link
 * intent created for the specified document but with different options,
 * then it may be overridden.
 *
 * <p>Providers are required to show confirmation UI for all new permissions granted
 * for the linked document.
 *
 * <p>If list of recipients is known, then it should be passed in options as
 * {@link android.content.Intent#EXTRA_EMAIL Intent#EXTRA_EMAIL} as a list of email addresses. Note, that
 * this is just a hint for the provider, which can ignore the list. In either
 * case the provider is required to show a UI for letting the user confirm
 * any new permission grants.
 *
 * <p>Note, that the entire <code>options</code> bundle will be sent to the provider
 * backing the passed <code>uri</code>. Make sure that you trust the provider
 * before passing any sensitive information.
 *
 * <p>Since this API may show a UI, it cannot be called from background.
 *
 * <p>In order to obtain the Web Link use code like this:
 * <pre><code>
 * void onSomethingHappened() {
 *   IntentSender sender = DocumentsContract.createWebLinkIntent(<i>...</i>);
 *   if (sender != null) {
 *     startIntentSenderForResult(
 *         sender,
 *         WEB_LINK_REQUEST_CODE,
 *         null, 0, 0, 0, null);
 *   }
 * }
 *
 * <i>(...)</i>
 *
 * void onActivityResult(int requestCode, int resultCode, Intent data) {
 *   if (requestCode == WEB_LINK_REQUEST_CODE && resultCode == RESULT_OK) {
 *     Uri weblinkUri = data.getData();
 *     <i>...</i>
 *   }
 * }
 * </code></pre>
 *
 * @param uri uri for the document to create a link to.
 * This value must never be {@code null}.
 * @param options Extra information for generating the link.
 * This value may be {@code null}.
 * @param content This value must never be {@code null}.
 * @return an intent sender to obtain the web link, or null if the document
 *      is not linkable, or creating the intent sender failed.
 * @see android.provider.DocumentsProvider#createWebLinkIntent(String, Bundle)
 * @see android.content.Intent#EXTRA_EMAIL
 * @apiSince 26
 */

@androidx.annotation.Nullable
public static android.content.IntentSender createWebLinkIntent(@androidx.annotation.NonNull android.content.ContentResolver content, @androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable android.os.Bundle options) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Action of intent issued by DocumentsUI when user wishes to open/configure/manage a particular
 * document in the provider application.
 *
 * <p>When issued, the intent will include the URI of the document as the intent data.
 *
 * <p>A provider wishing to provide support for this action should do two things.
 * <li>Add an {@code <intent-filter>} matching this action.
 * <li>When supplying information in {@link android.provider.DocumentsProvider#queryChildDocuments DocumentsProvider#queryChildDocuments}, include
 * {@link android.provider.DocumentsContract.Document#FLAG_SUPPORTS_SETTINGS Document#FLAG_SUPPORTS_SETTINGS} in the flags for each document that supports
 * settings.
 * @apiSince 26
 */

public static final java.lang.String ACTION_DOCUMENT_SETTINGS = "android.provider.action.DOCUMENT_SETTINGS";

/**
 * Optional string included in a directory {@link android.database.Cursor#getExtras() Cursor#getExtras()}
 * providing an error message that should be shown to a user. For example, a
 * provider may wish to indicate that a network error occurred. The user may
 * choose to retry, resulting in a new query.
 * @apiSince 19
 */

public static final java.lang.String EXTRA_ERROR = "error";

/**
 * Set this in a DocumentsUI intent to cause a package's own roots to be
 * excluded from the roots list.
 * @apiSince 23
 */

public static final java.lang.String EXTRA_EXCLUDE_SELF = "android.provider.extra.EXCLUDE_SELF";

/**
 * Optional string included in a directory {@link android.database.Cursor#getExtras() Cursor#getExtras()}
 * providing an informational message that should be shown to a user. For
 * example, a provider may wish to indicate that not all documents are
 * available.
 * @apiSince 19
 */

public static final java.lang.String EXTRA_INFO = "info";

/**
 * Sets the desired initial location visible to user when file chooser is shown.
 *
 * <p>Applicable to {@link android.content.Intent Intent} with actions:
 * <ul>
 *      <li>{@link android.content.Intent#ACTION_OPEN_DOCUMENT Intent#ACTION_OPEN_DOCUMENT}</li>
 *      <li>{@link android.content.Intent#ACTION_CREATE_DOCUMENT Intent#ACTION_CREATE_DOCUMENT}</li>
 *      <li>{@link android.content.Intent#ACTION_OPEN_DOCUMENT_TREE Intent#ACTION_OPEN_DOCUMENT_TREE}</li>
 * </ul>
 *
 * <p>Location should specify a document URI or a tree URI with document ID. If
 * this URI identifies a non-directory, document navigator will attempt to use the parent
 * of the document as the initial location.
 *
 * <p>The initial location is system specific if this extra is missing or document navigator
 * failed to locate the desired initial location.
 * @apiSince 26
 */

public static final java.lang.String EXTRA_INITIAL_URI = "android.provider.extra.INITIAL_URI";

/**
 * Optional boolean flag included in a directory {@link android.database.Cursor#getExtras() Cursor#getExtras()}
 * indicating that a document provider is still loading data. For example, a
 * provider has returned some results, but is still waiting on an
 * outstanding network request. The provider must send a content changed
 * notification when loading is finished.
 *
 * @see android.content.ContentResolver#notifyChange(Uri, android.database.ContentObserver,
 *      boolean)
 * @apiSince 19
 */

public static final java.lang.String EXTRA_LOADING = "loading";

/**
 * An extra number of degrees that an image should be rotated during the
 * decode process to be presented correctly.
 *
 * @see android.content.res.AssetFileDescriptor#getExtras()
 * @see android.provider.MediaStore.Images.ImageColumns#ORIENTATION
 * @apiSince 24
 */

public static final java.lang.String EXTRA_ORIENTATION = "android.provider.extra.ORIENTATION";

/**
 * Overrides the default prompt text in DocumentsUI when set in an intent.
 * @apiSince 23
 */

public static final java.lang.String EXTRA_PROMPT = "android.provider.extra.PROMPT";

/**
 * Get Exif information using DocumentsContract#getDocumentMetadata.
 *
 * @see #getDocumentMetadata(ContentInterface, Uri)
 * @apiSince 29
 */

public static final java.lang.String METADATA_EXIF = "android:documentExif";

/**
 * Get total count of all documents currently stored under the given
 * directory tree. Only valid for {@link android.provider.DocumentsContract.Document#MIME_TYPE_DIR Document#MIME_TYPE_DIR} documents.
 *
 * @see #getDocumentMetadata(ContentInterface, Uri)
 * @apiSince 29
 */

public static final java.lang.String METADATA_TREE_COUNT = "android:metadataTreeCount";

/**
 * Get total size of all documents currently stored under the given
 * directory tree. Only valid for {@link android.provider.DocumentsContract.Document#MIME_TYPE_DIR Document#MIME_TYPE_DIR} documents.
 *
 * @see #getDocumentMetadata(ContentInterface, Uri)
 * @apiSince 29
 */

public static final java.lang.String METADATA_TREE_SIZE = "android:metadataTreeSize";

/**
 * Get string array identifies the type or types of metadata returned
 * using DocumentsContract#getDocumentMetadata.
 *
 * @see #getDocumentMetadata(ContentInterface, Uri)
 * @apiSince 29
 */

public static final java.lang.String METADATA_TYPES = "android:documentMetadataTypes";

/**
 * Intent action used to identify {@link android.provider.DocumentsProvider DocumentsProvider} instances. This
 * is used in the {@code <intent-filter>} of a {@code <provider>}.
 * @apiSince 19
 */

public static final java.lang.String PROVIDER_INTERFACE = "android.content.action.DOCUMENTS_PROVIDER";

/**
 * Key for {@link android.provider.DocumentsProvider DocumentsProvider} to query display name is matched.
 * The match of display name is partial matching and case-insensitive.
 * Ex: The value is "o", the display name of the results will contain
 * both "foo" and "Open".
 *
 * @see android.provider.DocumentsProvider#querySearchDocuments(String, String[],
 *      Bundle)
 * @apiSince 29
 */

public static final java.lang.String QUERY_ARG_DISPLAY_NAME = "android:query-arg-display-name";

/**
 * Key for {@link android.provider.DocumentsProvider DocumentsProvider} to decide whether the files that
 * have been added to MediaStore should be excluded. If the value is
 * true, exclude them. Otherwise, include them.
 *
 * @see android.provider.DocumentsProvider#querySearchDocuments(String, String[],
 *      Bundle)
 * @apiSince 29
 */

public static final java.lang.String QUERY_ARG_EXCLUDE_MEDIA = "android:query-arg-exclude-media";

/**
 * Key for {@link android.provider.DocumentsProvider DocumentsProvider} to query the file size in bytes is
 * larger than the value.
 *
 * @see android.provider.DocumentsProvider#querySearchDocuments(String, String[],
 *      Bundle)
 * @apiSince 29
 */

public static final java.lang.String QUERY_ARG_FILE_SIZE_OVER = "android:query-arg-file-size-over";

/**
 * Key for {@link android.provider.DocumentsProvider DocumentsProvider} to query the last modified time
 * is newer than the value. The unit is in milliseconds since
 * January 1, 1970 00:00:00.0 UTC.
 *
 * @see android.provider.DocumentsProvider#querySearchDocuments(String, String[],
 *      Bundle)
 * @see android.provider.DocumentsContract.Document#COLUMN_LAST_MODIFIED
 * @apiSince 29
 */

public static final java.lang.String QUERY_ARG_LAST_MODIFIED_AFTER = "android:query-arg-last-modified-after";

/**
 * Key for {@link android.provider.DocumentsProvider DocumentsProvider} to query mime types is matched.
 * The value is a string array, it can support different mime types.
 * Each items will be treated as "OR" condition. Ex: {"image/*" ,
 * "video/*"}. The mime types of the results will contain both image
 * type and video type.
 *
 * @see android.provider.DocumentsProvider#querySearchDocuments(String, String[],
 *      Bundle)
 * @apiSince 29
 */

public static final java.lang.String QUERY_ARG_MIME_TYPES = "android:query-arg-mime-types";
/**
 * Constants related to a document, including {@link android.database.Cursor Cursor} column names
 * and flags.
 * <p>
 * A document can be either an openable stream (with a specific MIME type),
 * or a directory containing additional documents (with the
 * {@link #MIME_TYPE_DIR} MIME type). A directory represents the top of a
 * subtree containing zero or more documents, which can recursively contain
 * even more documents and directories.
 * <p>
 * All columns are <em>read-only</em> to client applications.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Document {

private Document() { throw new RuntimeException("Stub!"); }

/**
 * Display name of a document, used as the primary title displayed to a
 * user. This column is required.
 * <p>
 * Type: STRING
 * @apiSince 19
 */

public static final java.lang.String COLUMN_DISPLAY_NAME = "_display_name";

/**
 * Unique ID of a document. This ID is both provided by and interpreted
 * by a {@link android.provider.DocumentsProvider DocumentsProvider}, and should be treated as an opaque
 * value by client applications. This column is required.
 * <p>
 * Each document must have a unique ID within a provider, but that
 * single document may be included as a child of multiple directories.
 * <p>
 * A provider must always return durable IDs, since they will be used to
 * issue long-term URI permission grants when an application interacts
 * with {@link android.content.Intent#ACTION_OPEN_DOCUMENT Intent#ACTION_OPEN_DOCUMENT} and
 * {@link android.content.Intent#ACTION_CREATE_DOCUMENT Intent#ACTION_CREATE_DOCUMENT}.
 * <p>
 * Type: STRING
 * @apiSince 19
 */

public static final java.lang.String COLUMN_DOCUMENT_ID = "document_id";

/**
 * Flags that apply to a document. This column is required.
 * <p>
 * Type: INTEGER (int)
 *
 * @see #FLAG_SUPPORTS_WRITE
 * @see #FLAG_SUPPORTS_DELETE
 * @see #FLAG_SUPPORTS_THUMBNAIL
 * @see #FLAG_DIR_PREFERS_GRID
 * @see #FLAG_DIR_PREFERS_LAST_MODIFIED
 * @see #FLAG_VIRTUAL_DOCUMENT
 * @see #FLAG_SUPPORTS_COPY
 * @see #FLAG_SUPPORTS_MOVE
 * @see #FLAG_SUPPORTS_REMOVE
 * @apiSince 19
 */

public static final java.lang.String COLUMN_FLAGS = "flags";

/**
 * Specific icon resource ID for a document. This column is optional,
 * and may be {@code null} to use a platform-provided default icon based
 * on {@link #COLUMN_MIME_TYPE}.
 * <p>
 * Type: INTEGER (int)
 * @apiSince 19
 */

public static final java.lang.String COLUMN_ICON = "icon";

/**
 * Timestamp when a document was last modified, in milliseconds since
 * January 1, 1970 00:00:00.0 UTC. This column is required, and may be
 * {@code null} if unknown. A {@link android.provider.DocumentsProvider DocumentsProvider} can update this
 * field using events from {@link android.os.ParcelFileDescriptor.OnCloseListener OnCloseListener} or other reliable
 * {@link android.os.ParcelFileDescriptor ParcelFileDescriptor} transports.
 * <p>
 * Type: INTEGER (long)
 *
 * @see java.lang.System#currentTimeMillis()
 * @apiSince 19
 */

public static final java.lang.String COLUMN_LAST_MODIFIED = "last_modified";

/**
 * Concrete MIME type of a document. For example, "image/png" or
 * "application/pdf" for openable files. A document can also be a
 * directory containing additional documents, which is represented with
 * the {@link #MIME_TYPE_DIR} MIME type. This column is required.
 * <p>
 * Type: STRING
 *
 * @see #MIME_TYPE_DIR
 * @apiSince 19
 */

public static final java.lang.String COLUMN_MIME_TYPE = "mime_type";

/**
 * Size of a document, in bytes, or {@code null} if unknown. This column
 * is required.
 * <p>
 * Type: INTEGER (long)
 * @apiSince 19
 */

public static final java.lang.String COLUMN_SIZE = "_size";

/**
 * Summary of a document, which may be shown to a user. This column is
 * optional, and may be {@code null}.
 * <p>
 * Type: STRING
 * @apiSince 19
 */

public static final java.lang.String COLUMN_SUMMARY = "summary";

/**
 * Flag indicating that a directory prefers its contents be shown in a
 * larger format grid. Usually suitable when a directory contains mostly
 * pictures. Only valid when {@link #COLUMN_MIME_TYPE} is
 * {@link #MIME_TYPE_DIR}.
 *
 * @see #COLUMN_FLAGS
 * @apiSince 19
 */

public static final int FLAG_DIR_PREFERS_GRID = 16; // 0x10

/**
 * Flag indicating that a directory prefers its contents be sorted by
 * {@link #COLUMN_LAST_MODIFIED}. Only valid when
 * {@link #COLUMN_MIME_TYPE} is {@link #MIME_TYPE_DIR}.
 *
 * @see #COLUMN_FLAGS
 * @apiSince 19
 */

public static final int FLAG_DIR_PREFERS_LAST_MODIFIED = 32; // 0x20

/**
 * Flag indicating that a document is a directory that supports creation
 * of new files within it. Only valid when {@link #COLUMN_MIME_TYPE} is
 * {@link #MIME_TYPE_DIR}.
 *
 * @see #COLUMN_FLAGS
 * @see android.provider.DocumentsProvider#createDocument(String, String, String)
 * @apiSince 19
 */

public static final int FLAG_DIR_SUPPORTS_CREATE = 8; // 0x8

/**
 * Flag indicating that a document is not complete, likely its
 * contents are being downloaded. Partial files cannot be opened,
 * copied, moved in the UI. But they can be deleted and retried
 * if they represent a failed download.
 *
 * @see #COLUMN_FLAGS
 * @apiSince 29
 */

public static final int FLAG_PARTIAL = 8192; // 0x2000

/**
 * Flag indicating that a document can be copied to another location
 * within the same document provider.
 *
 * @see #COLUMN_FLAGS
 * @see DocumentsContract#copyDocument(ContentInterface, Uri, Uri)
 * @see android.provider.DocumentsProvider#copyDocument(String, String)
 * @apiSince 24
 */

public static final int FLAG_SUPPORTS_COPY = 128; // 0x80

/**
 * Flag indicating that a document is deletable.
 *
 * @see #COLUMN_FLAGS
 * @see DocumentsContract#deleteDocument(ContentInterface, Uri)
 * @see android.provider.DocumentsProvider#deleteDocument(String)
 * @apiSince 19
 */

public static final int FLAG_SUPPORTS_DELETE = 4; // 0x4

/**
 * Flag indicating that a document has available metadata that can be read
 * using DocumentsContract#getDocumentMetadata
 *
 * @see #COLUMN_FLAGS
 * @see DocumentsContract#getDocumentMetadata(ContentInterface, Uri)
 * @apiSince 29
 */

public static final int FLAG_SUPPORTS_METADATA = 16384; // 0x4000

/**
 * Flag indicating that a document can be moved to another location
 * within the same document provider.
 *
 * @see #COLUMN_FLAGS
 * @see DocumentsContract#moveDocument(ContentInterface, Uri, Uri, Uri)
 * @see android.provider.DocumentsProvider#moveDocument(String, String, String)
 * @apiSince 24
 */

public static final int FLAG_SUPPORTS_MOVE = 256; // 0x100

/**
 * Flag indicating that a document can be removed from a parent.
 *
 * @see #COLUMN_FLAGS
 * @see DocumentsContract#removeDocument(ContentInterface, Uri, Uri)
 * @see android.provider.DocumentsProvider#removeDocument(String, String)
 * @apiSince 24
 */

public static final int FLAG_SUPPORTS_REMOVE = 1024; // 0x400

/**
 * Flag indicating that a document can be renamed.
 *
 * @see #COLUMN_FLAGS
 * @see DocumentsContract#renameDocument(ContentInterface, Uri, String)
 * @see android.provider.DocumentsProvider#renameDocument(String, String)
 * @apiSince 21
 */

public static final int FLAG_SUPPORTS_RENAME = 64; // 0x40

/**
 * Flag indicating that a document has settings that can be configured by user.
 *
 * @see #COLUMN_FLAGS
 * @see #ACTION_DOCUMENT_SETTINGS
 * @apiSince 26
 */

public static final int FLAG_SUPPORTS_SETTINGS = 2048; // 0x800

/**
 * Flag indicating that a document can be represented as a thumbnail.
 *
 * @see #COLUMN_FLAGS
 * @see DocumentsContract#getDocumentThumbnail(ContentInterface, Uri,
 *      Point, CancellationSignal)
 * @see android.provider.DocumentsProvider#openDocumentThumbnail(String, Point,
 *      android.os.CancellationSignal)
 * @apiSince 19
 */

public static final int FLAG_SUPPORTS_THUMBNAIL = 1; // 0x1

/**
 * Flag indicating that a document supports writing.
 * <p>
 * When a document is opened with {@link android.content.Intent#ACTION_OPEN_DOCUMENT Intent#ACTION_OPEN_DOCUMENT},
 * the calling application is granted both
 * {@link android.content.Intent#FLAG_GRANT_READ_URI_PERMISSION Intent#FLAG_GRANT_READ_URI_PERMISSION} and
 * {@link android.content.Intent#FLAG_GRANT_WRITE_URI_PERMISSION Intent#FLAG_GRANT_WRITE_URI_PERMISSION}. However, the actual
 * writability of a document may change over time, for example due to
 * remote access changes. This flag indicates that a document client can
 * expect {@link android.content.ContentResolver#openOutputStream(android.net.Uri) ContentResolver#openOutputStream(Uri)} to succeed.
 *
 * @see #COLUMN_FLAGS
 * @apiSince 19
 */

public static final int FLAG_SUPPORTS_WRITE = 2; // 0x2

/**
 * Flag indicating that a document is virtual, and doesn't have byte
 * representation in the MIME type specified as {@link #COLUMN_MIME_TYPE}.
 *
 * <p><em>Virtual documents must have at least one alternative streamable
 * format via {@link android.provider.DocumentsProvider#openTypedDocument DocumentsProvider#openTypedDocument}</em>
 *
 * @see #COLUMN_FLAGS
 * @see #COLUMN_MIME_TYPE
 * @see android.provider.DocumentsProvider#openTypedDocument(String, String, Bundle,
 *      android.os.CancellationSignal)
 * @see android.provider.DocumentsProvider#getDocumentStreamTypes(String, String)
 * @apiSince 24
 */

public static final int FLAG_VIRTUAL_DOCUMENT = 512; // 0x200

/**
 * Flag indicating that a Web link can be obtained for the document.
 *
 * @see #COLUMN_FLAGS
 * @see android.provider.DocumentsProvider#createWebLinkIntent(String, Bundle)
 * @apiSince 26
 */

public static final int FLAG_WEB_LINKABLE = 4096; // 0x1000

/**
 * MIME type of a document which is a directory that may contain
 * additional documents.
 *
 * @see #COLUMN_MIME_TYPE
 * @apiSince 19
 */

public static final java.lang.String MIME_TYPE_DIR = "vnd.android.document/directory";
}

/**
 * Holds a path from a document to a particular document under it. It
 * may also contains the root ID where the path resides.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Path implements android.os.Parcelable {

/**
 * Creates a Path.
 *
 * @param rootId the ID of the root. May be null.
 * This value may be {@code null}.
 * @param path the list of document ID from the parent document at
 *          position 0 to the child document.
 * @apiSince 26
 */

public Path(@androidx.annotation.Nullable java.lang.String rootId, java.util.List<java.lang.String> path) { throw new RuntimeException("Stub!"); }

/**
 * Returns the root id or null if the calling package doesn't have
 * permission to access root information.
 * @apiSince 26
 */

@androidx.annotation.Nullable
public java.lang.String getRootId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the path. The path is trimmed to the top of tree if
 * calling package doesn't have permission to access those
 * documents.
 * @apiSince 26
 */

public java.util.List<java.lang.String> getPath() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.provider.DocumentsContract.Path> CREATOR;
static { CREATOR = null; }
}

/**
 * Constants related to a root of documents, including {@link android.database.Cursor Cursor} column
 * names and flags. A root is the start of a tree of documents, such as a
 * physical storage device, or an account. Each root starts at the directory
 * referenced by {@link android.provider.DocumentsContract.Root#COLUMN_DOCUMENT_ID Root#COLUMN_DOCUMENT_ID}, which can recursively
 * contain both documents and directories.
 * <p>
 * All columns are <em>read-only</em> to client applications.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Root {

private Root() { throw new RuntimeException("Stub!"); }

/**
 * Number of bytes available in this root. This column is optional, and
 * may be {@code null} if unknown or unbounded.
 * <p>
 * Type: INTEGER (long)
 * @apiSince 19
 */

public static final java.lang.String COLUMN_AVAILABLE_BYTES = "available_bytes";

/**
 * Capacity of a root in bytes. This column is optional, and may be
 * {@code null} if unknown or unbounded.
 * <p>
 * Type: INTEGER (long)
 * @apiSince 24
 */

public static final java.lang.String COLUMN_CAPACITY_BYTES = "capacity_bytes";

/**
 * Document which is a directory that represents the top directory of
 * this root. This column is required.
 * <p>
 * Type: STRING
 *
 * @see android.provider.DocumentsContract.Document#COLUMN_DOCUMENT_ID
 * @apiSince 19
 */

public static final java.lang.String COLUMN_DOCUMENT_ID = "document_id";

/**
 * Flags that apply to a root. This column is required.
 * <p>
 * Type: INTEGER (int)
 *
 * @see #FLAG_LOCAL_ONLY
 * @see #FLAG_SUPPORTS_CREATE
 * @see #FLAG_SUPPORTS_RECENTS
 * @see #FLAG_SUPPORTS_SEARCH
 * @apiSince 19
 */

public static final java.lang.String COLUMN_FLAGS = "flags";

/**
 * Icon resource ID for a root. This column is required.
 * <p>
 * Type: INTEGER (int)
 * @apiSince 19
 */

public static final java.lang.String COLUMN_ICON = "icon";

/**
 * MIME types supported by this root. This column is optional, and if
 * {@code null} the root is assumed to support all MIME types. Multiple
 * MIME types can be separated by a newline. For example, a root
 * supporting audio might return "audio/*\napplication/x-flac".
 * <p>
 * Type: STRING
 * @apiSince 19
 */

public static final java.lang.String COLUMN_MIME_TYPES = "mime_types";

/**
 * Query arguments supported by this root. This column is optional
 * and related to {@link #COLUMN_FLAGS} and {@link #FLAG_SUPPORTS_SEARCH}.
 * If the flags include {@link #FLAG_SUPPORTS_SEARCH}, and the column is
 * {@code null}, the root is assumed to support {@link #QUERY_ARG_DISPLAY_NAME}
 * search of {@link android.provider.DocumentsContract.Document#COLUMN_DISPLAY_NAME Document#COLUMN_DISPLAY_NAME}. Multiple query arguments
 * can be separated by a newline. For example, a root supporting
 * {@link #QUERY_ARG_MIME_TYPES} and {@link #QUERY_ARG_DISPLAY_NAME} might
 * return "android:query-arg-mime-types\nandroid:query-arg-display-name".
 * <p>
 * Type: STRING
 * @see #COLUMN_FLAGS
 * @see #FLAG_SUPPORTS_SEARCH
 * @see #QUERY_ARG_DISPLAY_NAME
 * @see #QUERY_ARG_FILE_SIZE_OVER
 * @see #QUERY_ARG_LAST_MODIFIED_AFTER
 * @see #QUERY_ARG_MIME_TYPES
 * @see android.provider.DocumentsProvider#querySearchDocuments(String, String[],
 *      Bundle)
 * @apiSince 29
 */

public static final java.lang.String COLUMN_QUERY_ARGS = "query_args";

/**
 * Unique ID of a root. This ID is both provided by and interpreted by a
 * {@link android.provider.DocumentsProvider DocumentsProvider}, and should be treated as an opaque value
 * by client applications. This column is required.
 * <p>
 * Type: STRING
 * @apiSince 19
 */

public static final java.lang.String COLUMN_ROOT_ID = "root_id";

/**
 * Summary for this root, which may be shown to a user. This column is
 * optional, and may be {@code null}. For a single storage service
 * surfacing multiple accounts as different roots, this summary should
 * be the name of the account.
 * <p>
 * Type: STRING
 * @apiSince 19
 */

public static final java.lang.String COLUMN_SUMMARY = "summary";

/**
 * Title for a root, which will be shown to a user. This column is
 * required. For a single storage service surfacing multiple accounts as
 * different roots, this title should be the name of the service.
 * <p>
 * Type: STRING
 * @apiSince 19
 */

public static final java.lang.String COLUMN_TITLE = "title";

/**
 * Flag indicating that this root is currently empty. This may be used
 * to hide the root when opening documents, but the root will still be
 * shown when creating documents and {@link #FLAG_SUPPORTS_CREATE} is
 * also set. If the value of this flag changes, such as when a root
 * becomes non-empty, you must send a content changed notification for
 * {@link android.provider.DocumentsContract#buildRootsUri(java.lang.String) DocumentsContract#buildRootsUri(String)}.
 *
 * @see #COLUMN_FLAGS
 * @see android.content.ContentResolver#notifyChange(Uri,
 *      android.database.ContentObserver, boolean)
 * @apiSince 29
 */

public static final int FLAG_EMPTY = 64; // 0x40

/**
 * Flag indicating that this root offers content that is strictly local
 * on the device. That is, no network requests are made for the content.
 *
 * @see #COLUMN_FLAGS
 * @see android.content.Intent#EXTRA_LOCAL_ONLY
 * @apiSince 19
 */

public static final int FLAG_LOCAL_ONLY = 2; // 0x2

/**
 * Flag indicating that at least one directory under this root supports
 * creating content. Roots with this flag will be shown when an
 * application interacts with {@link android.content.Intent#ACTION_CREATE_DOCUMENT Intent#ACTION_CREATE_DOCUMENT}.
 *
 * @see #COLUMN_FLAGS
 * @apiSince 19
 */

public static final int FLAG_SUPPORTS_CREATE = 1; // 0x1

/**
 * Flag indicating that this root can be ejected.
 *
 * @see #COLUMN_FLAGS
 * @see DocumentsContract#ejectRoot(ContentInterface, Uri)
 * @see android.provider.DocumentsProvider#ejectRoot(String)
 * @apiSince 26
 */

public static final int FLAG_SUPPORTS_EJECT = 32; // 0x20

/**
 * Flag indicating that this root supports testing parent child
 * relationships.
 *
 * @see #COLUMN_FLAGS
 * @see android.provider.DocumentsProvider#isChildDocument(String, String)
 * @apiSince 21
 */

public static final int FLAG_SUPPORTS_IS_CHILD = 16; // 0x10

/**
 * Flag indicating that this root can be queried to provide recently
 * modified documents.
 *
 * @see #COLUMN_FLAGS
 * @see android.provider.DocumentsContract#buildRecentDocumentsUri(String, String)
 * @see android.provider.DocumentsProvider#queryRecentDocuments(String, String[])
 * @apiSince 19
 */

public static final int FLAG_SUPPORTS_RECENTS = 4; // 0x4

/**
 * Flag indicating that this root supports search.
 *
 * @see #COLUMN_FLAGS
 * @see android.provider.DocumentsContract#buildSearchDocumentsUri(String, String,
 *      String)
 * @see android.provider.DocumentsProvider#querySearchDocuments(String, String,
 *      String[])
 * @see android.provider.DocumentsProvider#querySearchDocuments(String, String[],
 *      Bundle)
 * @apiSince 19
 */

public static final int FLAG_SUPPORTS_SEARCH = 8; // 0x8

/**
 * MIME type for a root.
 * @apiSince 26
 */

public static final java.lang.String MIME_TYPE_ITEM = "vnd.android.document/root";
}

}

