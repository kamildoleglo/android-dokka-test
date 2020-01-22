/*
 * Copyright (C) 2010 The Android Open Source Project
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


package android.app;

import android.database.Cursor;
import java.io.FileNotFoundException;
import android.os.ParcelFileDescriptor;
import android.net.Uri;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.MediaStore;
import android.os.Environment;
import android.net.ConnectivityManager;

/**
 * The download manager is a system service that handles long-running HTTP downloads. Clients may
 * request that a URI be downloaded to a particular destination file. The download manager will
 * conduct the download in the background, taking care of HTTP interactions and retrying downloads
 * after failures or across connectivity changes and system reboots.
 * <p>
 * Apps that request downloads through this API should register a broadcast receiver for
 * {@link #ACTION_NOTIFICATION_CLICKED} to appropriately handle when the user clicks on a running
 * download in a notification or from the downloads UI.
 * <p>
 * Note that the application must have the {@link android.Manifest.permission#INTERNET}
 * permission to use this class.
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DownloadManager {

DownloadManager() { throw new RuntimeException("Stub!"); }

/**
 * Enqueue a new download.  The download will start automatically once the download manager is
 * ready to execute it and connectivity is available.
 *
 * @param request the parameters specifying this download
 * @return an ID for the download, unique across the system.  This ID is used to make future
 * calls related to this download.
 * @apiSince 9
 */

public long enqueue(android.app.DownloadManager.Request request) { throw new RuntimeException("Stub!"); }

/**
 * Cancel downloads and remove them from the download manager.  Each download will be stopped if
 * it was running, and it will no longer be accessible through the download manager.
 * If there is a downloaded file, partial or complete, it is deleted.
 *
 * @param ids the IDs of the downloads to remove
 * @return the number of downloads actually removed
 * @apiSince 9
 */

public int remove(long... ids) { throw new RuntimeException("Stub!"); }

/**
 * Query the download manager about downloads that have been requested.
 * @param query parameters specifying filters for this query
 * @return a Cursor over the result set of downloads, with columns consisting of all the
 * COLUMN_* constants.
 * @apiSince 9
 */

public android.database.Cursor query(android.app.DownloadManager.Query query) { throw new RuntimeException("Stub!"); }

/**
 * Open a downloaded file for reading.  The download must have completed.
 * @param id the ID of the download
 * @return a read-only {@link android.os.ParcelFileDescriptor ParcelFileDescriptor}
 * @throws java.io.FileNotFoundException if the destination file does not already exist
 * @apiSince 9
 */

public android.os.ParcelFileDescriptor openDownloadedFile(long id) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.net.Uri Uri} of the given downloaded file id, if the file is
 * downloaded successfully. Otherwise, null is returned.
 *
 * @param id the id of the downloaded file.
 * @return the {@link android.net.Uri Uri} of the given downloaded file id, if download was
 *         successful. null otherwise.
 * @apiSince 11
 */

public android.net.Uri getUriForDownloadedFile(long id) { throw new RuntimeException("Stub!"); }

/**
 * Returns the media type of the given downloaded file id, if the file was
 * downloaded successfully. Otherwise, null is returned.
 *
 * @param id the id of the downloaded file.
 * @return the media type of the given downloaded file id, if download was successful. null
 * otherwise.
 * @apiSince 11
 */

public java.lang.String getMimeTypeForDownloadedFile(long id) { throw new RuntimeException("Stub!"); }

/**
 * Returns maximum size, in bytes, of downloads that may go over a mobile connection; or null if
 * there's no limit
 *
 * @param context the {@link android.content.Context Context} to use for accessing the {@link android.content.ContentResolver ContentResolver}
 * @return maximum size, in bytes, of downloads that may go over a mobile connection; or null if
 * there's no limit
 * @apiSince 11
 */

public static java.lang.Long getMaxBytesOverMobile(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Returns recommended maximum size, in bytes, of downloads that may go over a mobile
 * connection; or null if there's no recommended limit.  The user will have the option to bypass
 * this limit.
 *
 * @param context the {@link android.content.Context Context} to use for accessing the {@link android.content.ContentResolver ContentResolver}
 * @return recommended maximum size, in bytes, of downloads that may go over a mobile
 * connection; or null if there's no recommended limit.
 * @apiSince 11
 */

public static java.lang.Long getRecommendedMaxBytesOverMobile(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Adds a file to the downloads database system, so it could appear in Downloads App
 * (and thus become eligible for management by the Downloads App).
 * <p>
 * It is helpful to make the file scannable by MediaScanner by setting the param
 * isMediaScannerScannable to true. It makes the file visible in media managing
 * applications such as Gallery App, which could be a useful purpose of using this API.
 *
 * <p> For applications targeting {@link android.os.Build.VERSION_CODES#Q} or above,
 * {@code path} must be within directories owned by the application
 * {e.g. {@link android.content.Context#getExternalFilesDir(java.lang.String) Context#getExternalFilesDir(String)}} or if the application is running under
 * the legacy storage model (see
 * {@link android.R.styleable#AndroidManifestApplication_requestLegacyExternalStorage
 * android:requestLegacyExternalStorage}), {@code path} can also be within the top-level
 * Downloads directory (as returned by
 * {@link android.os.Environment#getExternalStoragePublicDirectory(java.lang.String) Environment#getExternalStoragePublicDirectory(String)} with
 * {@link android.os.Environment#DIRECTORY_DOWNLOADS Environment#DIRECTORY_DOWNLOADS}).
 *
 * @param title the title that would appear for this file in Downloads App.
 * @param description the description that would appear for this file in Downloads App.
 * @param isMediaScannerScannable true if the file is to be scanned by MediaScanner. Files
 * scanned by MediaScanner appear in the applications used to view media (for example,
 * Gallery app).
 * @param mimeType mimetype of the file.
 * @param path absolute pathname to the file. The file should be world-readable, so that it can
 * be managed by the Downloads App and any other app that is used to read it (for example,
 * Gallery app to display the file, if the file contents represent a video/image).
 * @param length length of the downloaded file
 * @param showNotification true if a notification is to be sent, false otherwise
 * @return  an ID for the download entry added to the downloads app, unique across the system
 * This ID is used to make future calls related to this download.
 *
 * @deprecated Apps should instead contribute files to
 * {@link android.provider.MediaStore.Downloads} collection to make them available to user
 * as part of Downloads.
 * @apiSince 12
 * @deprecatedSince 29
 */

@Deprecated
public long addCompletedDownload(java.lang.String title, java.lang.String description, boolean isMediaScannerScannable, java.lang.String mimeType, java.lang.String path, long length, boolean showNotification) { throw new RuntimeException("Stub!"); }

/**
 * Adds a file to the downloads database system, so it could appear in Downloads App
 * (and thus become eligible for management by the Downloads App).
 * <p>
 * It is helpful to make the file scannable by MediaScanner by setting the param
 * isMediaScannerScannable to true. It makes the file visible in media managing
 * applications such as Gallery App, which could be a useful purpose of using this API.
 *
 * <p> For applications targeting {@link android.os.Build.VERSION_CODES#Q} or above,
 * {@code path} must be within directories owned by the application
 * {e.g. {@link android.content.Context#getExternalFilesDir(java.lang.String) Context#getExternalFilesDir(String)}} or if the application is running under
 * the legacy storage model (see
 * {@link android.R.styleable#AndroidManifestApplication_requestLegacyExternalStorage
 * android:requestLegacyExternalStorage}), {@code path} can also be within the top-level
 * Downloads directory (as returned by
 * {@link android.os.Environment#getExternalStoragePublicDirectory(java.lang.String) Environment#getExternalStoragePublicDirectory(String)} with
 * {@link android.os.Environment#DIRECTORY_DOWNLOADS Environment#DIRECTORY_DOWNLOADS}).
 *
 * @param title the title that would appear for this file in Downloads App.
 * @param description the description that would appear for this file in Downloads App.
 * @param isMediaScannerScannable true if the file is to be scanned by MediaScanner. Files
 * scanned by MediaScanner appear in the applications used to view media (for example,
 * Gallery app).
 * @param mimeType mimetype of the file.
 * @param path absolute pathname to the file. The file should be world-readable, so that it can
 * be managed by the Downloads App and any other app that is used to read it (for example,
 * Gallery app to display the file, if the file contents represent a video/image).
 * @param length length of the downloaded file
 * @param showNotification true if a notification is to be sent, false otherwise
 * @param uri the original HTTP URI of the download
 * @param referer the HTTP Referer for the download
 * @return  an ID for the download entry added to the downloads app, unique across the system
 * This ID is used to make future calls related to this download.
 *
 * @deprecated Apps should instead contribute files to
 * {@link android.provider.MediaStore.Downloads} collection to make them available to user
 * as part of Downloads.
 * @apiSince 24
 * @deprecatedSince 29
 */

@Deprecated
public long addCompletedDownload(java.lang.String title, java.lang.String description, boolean isMediaScannerScannable, java.lang.String mimeType, java.lang.String path, long length, boolean showNotification, android.net.Uri uri, android.net.Uri referer) { throw new RuntimeException("Stub!"); }

/**
 * Broadcast intent action sent by the download manager when a download completes.
 * @apiSince 9
 */

public static final java.lang.String ACTION_DOWNLOAD_COMPLETE = "android.intent.action.DOWNLOAD_COMPLETE";

/**
 * Broadcast intent action sent by the download manager when the user clicks on a running
 * download, either from a system notification or from the downloads UI.
 * @apiSince 9
 */

public static final java.lang.String ACTION_NOTIFICATION_CLICKED = "android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED";

/**
 * Intent action to launch an activity to display all downloads.
 * @apiSince 9
 */

public static final java.lang.String ACTION_VIEW_DOWNLOADS = "android.intent.action.VIEW_DOWNLOADS";

/**
 * Number of bytes download so far.
 * @apiSince 9
 */

public static final java.lang.String COLUMN_BYTES_DOWNLOADED_SO_FAR = "bytes_so_far";

/**
 * The client-supplied description of this download.  This will be displayed in system
 * notifications.  Defaults to the empty string.
 * @apiSince 9
 */

public static final java.lang.String COLUMN_DESCRIPTION = "description";

/**
 * An identifier for a particular download, unique across the system.  Clients use this ID to
 * make subsequent calls related to the download.
 * @apiSince 9
 */

public static final java.lang.String COLUMN_ID = "_id";

/**
 * Timestamp when the download was last modified, in {@link java.lang.System#currentTimeMillis System#currentTimeMillis} (wall clock time in UTC).
 * @apiSince 9
 */

public static final java.lang.String COLUMN_LAST_MODIFIED_TIMESTAMP = "last_modified_timestamp";

/**
 * Path to the downloaded file on disk.
 * <p>
 * Note that apps may not have filesystem permissions to directly access
 * this path. Instead of trying to open this path directly, apps should use
 * {@link android.content.ContentResolver#openFileDescriptor(android.net.Uri,java.lang.String) ContentResolver#openFileDescriptor(Uri, String)} to gain access.
 *
 * @deprecated apps should transition to using
 *             {@link android.content.ContentResolver#openFileDescriptor(android.net.Uri,java.lang.String) ContentResolver#openFileDescriptor(Uri, String)}
 *             instead.
 * @apiSince 11
 * @deprecatedSince 24
 */

@Deprecated public static final java.lang.String COLUMN_LOCAL_FILENAME = "local_filename";

/**
 * Uri where downloaded file will be stored.  If a destination is supplied by client, that URI
 * will be used here.  Otherwise, the value will initially be null and will be filled in with a
 * generated URI once the download has started.
 * @apiSince 9
 */

public static final java.lang.String COLUMN_LOCAL_URI = "local_uri";

/**
 * The URI to the corresponding entry in MediaProvider for this downloaded entry. It is
 * used to delete the entries from MediaProvider database when it is deleted from the
 * downloaded list.
 * @apiSince 9
 */

public static final java.lang.String COLUMN_MEDIAPROVIDER_URI = "mediaprovider_uri";

/**
 * Internet Media Type of the downloaded file.  If no value is provided upon creation, this will
 * initially be null and will be filled in based on the server's response once the download has
 * started.
 *
 * @see <a href="http://www.ietf.org/rfc/rfc1590.txt">RFC 1590, defining Media Types</a>
 * @apiSince 9
 */

public static final java.lang.String COLUMN_MEDIA_TYPE = "media_type";

/**
 * Provides more detail on the status of the download.  Its meaning depends on the value of
 * {@link #COLUMN_STATUS}.
 *
 * When {@link #COLUMN_STATUS} is {@link #STATUS_FAILED}, this indicates the type of error that
 * occurred.  If an HTTP error occurred, this will hold the HTTP status code as defined in RFC
 * 2616.  Otherwise, it will hold one of the ERROR_* constants.
 *
 * When {@link #COLUMN_STATUS} is {@link #STATUS_PAUSED}, this indicates why the download is
 * paused.  It will hold one of the PAUSED_* constants.
 *
 * If {@link #COLUMN_STATUS} is neither {@link #STATUS_FAILED} nor {@link #STATUS_PAUSED}, this
 * column's value is undefined.
 *
 * @see <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec6.html#sec6.1.1">RFC 2616
 * status codes</a>
 * @apiSince 9
 */

public static final java.lang.String COLUMN_REASON = "reason";

/**
 * Current status of the download, as one of the STATUS_* constants.
 * @apiSince 9
 */

public static final java.lang.String COLUMN_STATUS = "status";

/**
 * The client-supplied title for this download.  This will be displayed in system notifications.
 * Defaults to the empty string.
 * @apiSince 9
 */

public static final java.lang.String COLUMN_TITLE = "title";

/**
 * Total size of the download in bytes.  This will initially be -1 and will be filled in once
 * the download starts.
 * @apiSince 9
 */

public static final java.lang.String COLUMN_TOTAL_SIZE_BYTES = "total_size";

/**
 * URI to be downloaded.
 * @apiSince 9
 */

public static final java.lang.String COLUMN_URI = "uri";

/**
 * Value of {@link #COLUMN_REASON} when some possibly transient error occurred but we can't
 * resume the download.
 * @apiSince 9
 */

public static final int ERROR_CANNOT_RESUME = 1008; // 0x3f0

/**
 * Value of {@link #COLUMN_REASON} when no external storage device was found. Typically,
 * this is because the SD card is not mounted.
 * @apiSince 9
 */

public static final int ERROR_DEVICE_NOT_FOUND = 1007; // 0x3ef

/**
 * Value of {@link #COLUMN_REASON} when the requested destination file already exists (the
 * download manager will not overwrite an existing file).
 * @apiSince 9
 */

public static final int ERROR_FILE_ALREADY_EXISTS = 1009; // 0x3f1

/**
 * Value of {@link #COLUMN_REASON} when a storage issue arises which doesn't fit under any
 * other error code. Use the more specific {@link #ERROR_INSUFFICIENT_SPACE} and
 * {@link #ERROR_DEVICE_NOT_FOUND} when appropriate.
 * @apiSince 9
 */

public static final int ERROR_FILE_ERROR = 1001; // 0x3e9

/**
 * Value of {@link #COLUMN_REASON} when an error receiving or processing data occurred at
 * the HTTP level.
 * @apiSince 9
 */

public static final int ERROR_HTTP_DATA_ERROR = 1004; // 0x3ec

/**
 * Value of {@link #COLUMN_REASON} when there was insufficient storage space. Typically,
 * this is because the SD card is full.
 * @apiSince 9
 */

public static final int ERROR_INSUFFICIENT_SPACE = 1006; // 0x3ee

/**
 * Value of {@link #COLUMN_REASON} when there were too many redirects.
 * @apiSince 9
 */

public static final int ERROR_TOO_MANY_REDIRECTS = 1005; // 0x3ed

/**
 * Value of {@link #COLUMN_REASON} when an HTTP code was received that download manager
 * can't handle.
 * @apiSince 9
 */

public static final int ERROR_UNHANDLED_HTTP_CODE = 1002; // 0x3ea

/**
 * Value of COLUMN_ERROR_CODE when the download has completed with an error that doesn't fit
 * under any other error code.
 * @apiSince 9
 */

public static final int ERROR_UNKNOWN = 1000; // 0x3e8

/**
 * Intent extra included with {@link #ACTION_DOWNLOAD_COMPLETE} intents, indicating the ID (as a
 * long) of the download that just completed.
 * @apiSince 9
 */

public static final java.lang.String EXTRA_DOWNLOAD_ID = "extra_download_id";

/**
 * When clicks on multiple notifications are received, the following
 * provides an array of download ids corresponding to the download notification that was
 * clicked. It can be retrieved by the receiver of this
 * Intent using {@link android.content.Intent#getLongArrayExtra(String)}.
 * @apiSince 11
 */

public static final java.lang.String EXTRA_NOTIFICATION_CLICK_DOWNLOAD_IDS = "extra_click_download_ids";

/**
 * Intent extra included with {@link #ACTION_VIEW_DOWNLOADS} to start DownloadApp in
 * sort-by-size mode.
 * @apiSince 12
 */

public static final java.lang.String INTENT_EXTRAS_SORT_BY_SIZE = "android.app.DownloadManager.extra_sortBySize";

/**
 * Value of {@link #COLUMN_REASON} when the download exceeds a size limit for downloads over
 * the mobile network and the download manager is waiting for a Wi-Fi connection to proceed.
 * @apiSince 9
 */

public static final int PAUSED_QUEUED_FOR_WIFI = 3; // 0x3

/**
 * Value of {@link #COLUMN_REASON} when the download is paused for some other reason.
 * @apiSince 9
 */

public static final int PAUSED_UNKNOWN = 4; // 0x4

/**
 * Value of {@link #COLUMN_REASON} when the download is waiting for network connectivity to
 * proceed.
 * @apiSince 9
 */

public static final int PAUSED_WAITING_FOR_NETWORK = 2; // 0x2

/**
 * Value of {@link #COLUMN_REASON} when the download is paused because some network error
 * occurred and the download manager is waiting before retrying the request.
 * @apiSince 9
 */

public static final int PAUSED_WAITING_TO_RETRY = 1; // 0x1

/**
 * Value of {@link #COLUMN_STATUS} when the download has failed (and will not be retried).
 * @apiSince 9
 */

public static final int STATUS_FAILED = 16; // 0x10

/**
 * Value of {@link #COLUMN_STATUS} when the download is waiting to retry or resume.
 * @apiSince 9
 */

public static final int STATUS_PAUSED = 4; // 0x4

/**
 * Value of {@link #COLUMN_STATUS} when the download is waiting to start.
 * @apiSince 9
 */

public static final int STATUS_PENDING = 1; // 0x1

/**
 * Value of {@link #COLUMN_STATUS} when the download is currently running.
 * @apiSince 9
 */

public static final int STATUS_RUNNING = 2; // 0x2

/**
 * Value of {@link #COLUMN_STATUS} when the download has successfully completed.
 * @apiSince 9
 */

public static final int STATUS_SUCCESSFUL = 8; // 0x8
/**
 * This class may be used to filter download manager queries.
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Query {

public Query() { throw new RuntimeException("Stub!"); }

/**
 * Include only the downloads with the given IDs.
 * @return this object
 * @apiSince 9
 */

public android.app.DownloadManager.Query setFilterById(long... ids) { throw new RuntimeException("Stub!"); }

/**
 * Include only downloads with status matching any the given status flags.
 * @param flags any combination of the STATUS_* bit flags
 * @return this object
 * @apiSince 9
 */

public android.app.DownloadManager.Query setFilterByStatus(int flags) { throw new RuntimeException("Stub!"); }
}

/**
 * This class contains all the information necessary to request a new download. The URI is the
 * only required parameter.
 *
 * Note that the default download destination is a shared volume where the system might delete
 * your file if it needs to reclaim space for system use. If this is a problem, use a location
 * on external storage (see {@link #setDestinationUri(android.net.Uri)}.
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Request {

/**
 * @param uri the HTTP or HTTPS URI to download.
 * @apiSince 9
 */

public Request(android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Set the local destination for the downloaded file. Must be a file URI to a path on
 * external storage, and the calling application must have the WRITE_EXTERNAL_STORAGE
 * permission.
 * <p>
 * The downloaded file is not scanned by MediaScanner.
 * But it can be made scannable by calling {@link #allowScanningByMediaScanner()}.
 * <p>
 * By default, downloads are saved to a generated filename in the shared download cache and
 * may be deleted by the system at any time to reclaim space.
 *
 * <p> For applications targeting {@link android.os.Build.VERSION_CODES#Q} or above,
 * {@link android.Manifest.permission#WRITE_EXTERNAL_STORAGE WRITE EXTERNAL_STORAGE}
 * permission is not needed and the {@code uri} must refer to a path within the
 * directories owned by the application (e.g. {@link android.content.Context#getExternalFilesDir(java.lang.String) Context#getExternalFilesDir(String)})
 * or a path within the top-level Downloads directory (as returned by
 * {@link android.os.Environment#getExternalStoragePublicDirectory(java.lang.String) Environment#getExternalStoragePublicDirectory(String)} with
 * {@link android.os.Environment#DIRECTORY_DOWNLOADS Environment#DIRECTORY_DOWNLOADS}).
 *
 * @param uri a file {@link android.net.Uri Uri} indicating the destination for the downloaded file.
 * @return this object
 * @apiSince 9
 */

public android.app.DownloadManager.Request setDestinationUri(android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Set the local destination for the downloaded file to a path within
 * the application's external files directory (as returned by
 * {@link android.content.Context#getExternalFilesDir(java.lang.String) Context#getExternalFilesDir(String)}.
 * <p>
 * The downloaded file is not scanned by MediaScanner. But it can be
 * made scannable by calling {@link #allowScanningByMediaScanner()}.
 *
 * @param context the {@link android.content.Context Context} to use in determining the external
 *            files directory
 * @param dirType the directory type to pass to
 *            {@link android.content.Context#getExternalFilesDir(java.lang.String) Context#getExternalFilesDir(String)}
 * @param subPath the path within the external directory, including the
 *            destination filename
 * @return this object
 * @throws java.lang.IllegalStateException If the external storage directory
 *             cannot be found or created.
 * @apiSince 9
 */

public android.app.DownloadManager.Request setDestinationInExternalFilesDir(android.content.Context context, java.lang.String dirType, java.lang.String subPath) { throw new RuntimeException("Stub!"); }

/**
 * Set the local destination for the downloaded file to a path within
 * the public external storage directory (as returned by
 * {@link android.os.Environment#getExternalStoragePublicDirectory(java.lang.String) Environment#getExternalStoragePublicDirectory(String)}).
 * <p>
 * The downloaded file is not scanned by MediaScanner. But it can be
 * made scannable by calling {@link #allowScanningByMediaScanner()}.
 *
 * <p> For applications targeting {@link android.os.Build.VERSION_CODES#Q} or above,
 * {@link android.Manifest.permission#WRITE_EXTERNAL_STORAGE WRITE_EXTERNAL_STORAGE}
 * permission is not needed and the {@code dirType} must be one of the known public
 * directories like {@link android.os.Environment#DIRECTORY_DOWNLOADS Environment#DIRECTORY_DOWNLOADS},
 * {@link android.os.Environment#DIRECTORY_PICTURES Environment#DIRECTORY_PICTURES}, {@link android.os.Environment#DIRECTORY_MOVIES Environment#DIRECTORY_MOVIES}, etc.
 *
 * @param dirType the directory type to pass to {@link android.os.Environment#getExternalStoragePublicDirectory(java.lang.String) Environment#getExternalStoragePublicDirectory(String)}
 * @param subPath the path within the external directory, including the
 *            destination filename
 * @return this object
 * @throws java.lang.IllegalStateException If the external storage directory
 *             cannot be found or created.
 * @apiSince 9
 */

public android.app.DownloadManager.Request setDestinationInExternalPublicDir(java.lang.String dirType, java.lang.String subPath) { throw new RuntimeException("Stub!"); }

/**
 * If the file to be downloaded is to be scanned by MediaScanner, this method
 * should be called before {@link android.app.DownloadManager#enqueue(android.app.DownloadManager.Request) DownloadManager#enqueue(Request)} is called.
 *
 * @deprecated Starting in Q, this value is ignored. Files downloaded to
 * directories owned by applications (e.g. {@link android.content.Context#getExternalFilesDir(java.lang.String) Context#getExternalFilesDir(String)})
 * will not be scanned by MediaScanner and the rest will be scanned.
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
public void allowScanningByMediaScanner() { throw new RuntimeException("Stub!"); }

/**
 * Add an HTTP header to be included with the download request.  The header will be added to
 * the end of the list.
 * @param header HTTP header name
 * @param value header value
 * @return this object
 * @see <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec4.html#sec4.2">HTTP/1.1
 *      Message Headers</a>
 * @apiSince 9
 */

public android.app.DownloadManager.Request addRequestHeader(java.lang.String header, java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Set the title of this download, to be displayed in notifications (if enabled).  If no
 * title is given, a default one will be assigned based on the download filename, once the
 * download starts.
 * @return this object
 * @apiSince 9
 */

public android.app.DownloadManager.Request setTitle(java.lang.CharSequence title) { throw new RuntimeException("Stub!"); }

/**
 * Set a description of this download, to be displayed in notifications (if enabled)
 * @return this object
 * @apiSince 9
 */

public android.app.DownloadManager.Request setDescription(java.lang.CharSequence description) { throw new RuntimeException("Stub!"); }

/**
 * Set the MIME content type of this download.  This will override the content type declared
 * in the server's response.
 * @see <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec3.html#sec3.7">HTTP/1.1
 *      Media Types</a>
 * @return this object
 * @apiSince 9
 */

public android.app.DownloadManager.Request setMimeType(java.lang.String mimeType) { throw new RuntimeException("Stub!"); }

/**
 * Control whether a system notification is posted by the download manager while this
 * download is running. If enabled, the download manager posts notifications about downloads
 * through the system {@link android.app.NotificationManager}. By default, a notification is
 * shown.
 *
 * If set to false, this requires the permission
 * android.permission.DOWNLOAD_WITHOUT_NOTIFICATION.
 *
 * @param show whether the download manager should show a notification for this download.
 * @return this object
 * @deprecated use {@link #setNotificationVisibility(int)}
 * @apiSince 9
 * @deprecatedSince 15
 */

@Deprecated
public android.app.DownloadManager.Request setShowRunningNotification(boolean show) { throw new RuntimeException("Stub!"); }

/**
 * Control whether a system notification is posted by the download manager while this
 * download is running or when it is completed.
 * If enabled, the download manager posts notifications about downloads
 * through the system {@link android.app.NotificationManager}.
 * By default, a notification is shown only when the download is in progress.
 *<p>
 * It can take the following values: {@link #VISIBILITY_HIDDEN},
 * {@link #VISIBILITY_VISIBLE},
 * {@link #VISIBILITY_VISIBLE_NOTIFY_COMPLETED}.
 *<p>
 * If set to {@link #VISIBILITY_HIDDEN}, this requires the permission
 * android.permission.DOWNLOAD_WITHOUT_NOTIFICATION.
 *
 * @param visibility the visibility setting value
 * @return this object
 * @apiSince 11
 */

public android.app.DownloadManager.Request setNotificationVisibility(int visibility) { throw new RuntimeException("Stub!"); }

/**
 * Restrict the types of networks over which this download may proceed.
 * By default, all network types are allowed. Consider using
 * {@link #setAllowedOverMetered(boolean)} instead, since it's more
 * flexible.
 * <p>
 * As of {@link android.os.Build.VERSION_CODES#N}, setting only the
 * {@link #NETWORK_WIFI} flag here is equivalent to calling
 * {@link #setAllowedOverMetered(boolean)} with {@code false}.
 *
 * @param flags any combination of the NETWORK_* bit flags.
 * @return this object
 * @apiSince 9
 */

public android.app.DownloadManager.Request setAllowedNetworkTypes(int flags) { throw new RuntimeException("Stub!"); }

/**
 * Set whether this download may proceed over a roaming connection.  By default, roaming is
 * allowed.
 * @param allowed whether to allow a roaming connection to be used
 * @return this object
 * @apiSince 9
 */

public android.app.DownloadManager.Request setAllowedOverRoaming(boolean allowed) { throw new RuntimeException("Stub!"); }

/**
 * Set whether this download may proceed over a metered network
 * connection. By default, metered networks are allowed.
 *
 * @see android.net.ConnectivityManager#isActiveNetworkMetered()
 * @apiSince 16
 */

public android.app.DownloadManager.Request setAllowedOverMetered(boolean allow) { throw new RuntimeException("Stub!"); }

/**
 * Specify that to run this download, the device needs to be plugged in.
 * This defaults to false.
 *
 * @param requiresCharging Whether or not the device is plugged in.
 * @see android.app.job.JobInfo.Builder#setRequiresCharging(boolean)
 * @apiSince 24
 */

public android.app.DownloadManager.Request setRequiresCharging(boolean requiresCharging) { throw new RuntimeException("Stub!"); }

/**
 * Specify that to run, the download needs the device to be in idle
 * mode. This defaults to false.
 * <p>
 * Idle mode is a loose definition provided by the system, which means
 * that the device is not in use, and has not been in use for some time.
 *
 * @param requiresDeviceIdle Whether or not the device need be within an
 *            idle maintenance window.
 * @see android.app.job.JobInfo.Builder#setRequiresDeviceIdle(boolean)
 * @apiSince 24
 */

public android.app.DownloadManager.Request setRequiresDeviceIdle(boolean requiresDeviceIdle) { throw new RuntimeException("Stub!"); }

/**
 * Set whether this download should be displayed in the system's Downloads UI. True by
 * default.
 * @param isVisible whether to display this download in the Downloads UI
 * @return this object
 *
 * @deprecated Starting in Q, this value is ignored. Only files downloaded to
 * public Downloads directory (as returned by
 * {@link android.os.Environment#getExternalStoragePublicDirectory(java.lang.String) Environment#getExternalStoragePublicDirectory(String)} with
 * {@link android.os.Environment#DIRECTORY_DOWNLOADS Environment#DIRECTORY_DOWNLOADS}) will be visible in system's Downloads UI
 * and the rest will not be visible.
 * (e.g. {@link android.content.Context#getExternalFilesDir(java.lang.String) Context#getExternalFilesDir(String)}) will not be visible.
 * @apiSince 9
 * @deprecatedSince 29
 */

@Deprecated
public android.app.DownloadManager.Request setVisibleInDownloadsUi(boolean isVisible) { throw new RuntimeException("Stub!"); }

/**
 * Bit flag for {@link #setAllowedNetworkTypes} corresponding to
 * {@link android.net.ConnectivityManager#TYPE_MOBILE ConnectivityManager#TYPE_MOBILE}.
 * @apiSince 9
 */

public static final int NETWORK_MOBILE = 1; // 0x1

/**
 * Bit flag for {@link #setAllowedNetworkTypes} corresponding to
 * {@link android.net.ConnectivityManager#TYPE_WIFI ConnectivityManager#TYPE_WIFI}.
 * @apiSince 9
 */

public static final int NETWORK_WIFI = 2; // 0x2

/**
 * This download doesn't show in the UI or in the notifications.
 * @apiSince 11
 */

public static final int VISIBILITY_HIDDEN = 2; // 0x2

/**
 * This download is visible but only shows in the notifications
 * while it's in progress.
 * @apiSince 11
 */

public static final int VISIBILITY_VISIBLE = 0; // 0x0

/**
 * This download is visible and shows in the notifications while
 * in progress and after completion.
 * @apiSince 11
 */

public static final int VISIBILITY_VISIBLE_NOTIFY_COMPLETED = 1; // 0x1

/**
 * This download shows in the notifications after completion ONLY.
 * It is usuable only with
 * {@link android.app.DownloadManager#addCompletedDownload(java.lang.String,java.lang.String,boolean,java.lang.String,java.lang.String,long,boolean) DownloadManager#addCompletedDownload(String, String,
 * boolean, String, String, long, boolean)}.
 * @apiSince 12
 */

public static final int VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION = 3; // 0x3
}

}

