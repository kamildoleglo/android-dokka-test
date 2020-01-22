/*
 * Copyright (C) 2016 The Android Open Source Project
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


package android.telephony;

import java.util.concurrent.Executor;
import android.content.Context;
import android.telephony.mbms.MbmsDownloadSessionCallback;
import java.util.List;
import android.content.SharedPreferences;
import android.telephony.mbms.DownloadRequest;
import android.telephony.mbms.MbmsErrors;
import java.io.File;
import android.telephony.mbms.DownloadStatusListener;
import android.telephony.mbms.DownloadProgressListener;
import android.os.Handler;
import android.telephony.mbms.FileInfo;
import android.content.Intent;
import android.net.Uri;

/**
 * This class provides functionality for file download over MBMS.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MbmsDownloadSession implements java.lang.AutoCloseable {

private MbmsDownloadSession() { throw new RuntimeException("Stub!"); }

/**
 * Create a new {@link android.telephony.MbmsDownloadSession MbmsDownloadSession} using the system default data subscription ID.
 * See {@link #create(android.content.Context,java.util.concurrent.Executor,int,android.telephony.mbms.MbmsDownloadSessionCallback)}
 
 * @param context This value must never be {@code null}.
 
 * @param executor This value must never be {@code null}.
 
 * @param callback This value must never be {@code null}.
 * @apiSince 28
 */

public static android.telephony.MbmsDownloadSession create(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull android.telephony.mbms.MbmsDownloadSessionCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Create a new MbmsDownloadManager using the given subscription ID.
 *
 * Note that this call will bind a remote service and that may take a bit. The instance of
 * {@link android.telephony.MbmsDownloadSession MbmsDownloadSession} that is returned will not be ready for use until
 * {@link android.telephony.mbms.MbmsDownloadSessionCallback#onMiddlewareReady() MbmsDownloadSessionCallback#onMiddlewareReady()} is called on the provided callback.
 * If you attempt to use the instance before it is ready, an {@link java.lang.IllegalStateException IllegalStateException}
 * will be thrown or an error will be delivered through
 * {@link android.telephony.mbms.MbmsDownloadSessionCallback#onError(int,java.lang.String) MbmsDownloadSessionCallback#onError(int, String)}.
 *
 * This also may throw an {@link java.lang.IllegalArgumentException IllegalArgumentException}.
 *
 * You may only have one instance of {@link android.telephony.MbmsDownloadSession MbmsDownloadSession} per UID. If you call this
 * method while there is an active instance of {@link android.telephony.MbmsDownloadSession MbmsDownloadSession} in your process
 * (in other words, one that has not had {@link #close()} called on it), this method will
 * throw an {@link java.lang.IllegalStateException IllegalStateException}. If you call this method in a different process
 * running under the same UID, an error will be indicated via
 * {@link android.telephony.mbms.MbmsDownloadSessionCallback#onError(int,java.lang.String) MbmsDownloadSessionCallback#onError(int, String)}.
 *
 * Note that initialization may fail asynchronously. If you wish to try again after you
 * receive such an asynchronous error, you must call {@link #close()} on the instance of
 * {@link android.telephony.MbmsDownloadSession MbmsDownloadSession} that you received before calling this method again.
 *
 * @param context The instance of {@link android.content.Context Context} to use
 * This value must never be {@code null}.
 * @param executor The executor on which you wish to execute callbacks.
 * This value must never be {@code null}.
 * @param subscriptionId The data subscription ID to use
 * @param callback A callback to get asynchronous error messages and file service updates.
 * This value must never be {@code null}.
 * @return A new instance of {@link android.telephony.MbmsDownloadSession MbmsDownloadSession}, or null if an error occurred during
 * setup.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public static android.telephony.MbmsDownloadSession create(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.util.concurrent.Executor executor, int subscriptionId, @androidx.annotation.NonNull android.telephony.mbms.MbmsDownloadSessionCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * An inspection API to retrieve the list of available
 * {@link android.telephony.mbms.FileServiceInfo}s currently being advertised.
 * The results are returned asynchronously via a call to
 * {@link android.telephony.mbms.MbmsDownloadSessionCallback#onFileServicesUpdated(java.util.List) MbmsDownloadSessionCallback#onFileServicesUpdated(List)}
 *
 * Asynchronous error codes via the {@link android.telephony.mbms.MbmsDownloadSessionCallback#onError(int,java.lang.String) MbmsDownloadSessionCallback#onError(int, String)}
 * callback may include any of the errors that are not specific to the streaming use-case.
 *
 * May throw an {@link java.lang.IllegalStateException IllegalStateException} or {@link java.lang.IllegalArgumentException IllegalArgumentException}.
 *
 * @param classList A list of service classes which the app wishes to receive
 *                  {@link android.telephony.mbms.MbmsDownloadSessionCallback#onFileServicesUpdated(java.util.List) MbmsDownloadSessionCallback#onFileServicesUpdated(List)} callbacks
 *                  about. Subsequent calls to this method will replace this list of service
 *                  classes (i.e. the middleware will no longer send updates for services
 *                  matching classes only in the old list).
 *                  Values in this list should be negotiated with the wireless carrier prior
 *                  to using this API.
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public void requestUpdateFileServices(@androidx.annotation.NonNull java.util.List<java.lang.String> classList) { throw new RuntimeException("Stub!"); }

/**
 * Sets the temp file root for downloads.
 * All temp files created for the middleware to write to will be contained in the specified
 * directory. Applications that wish to specify a location only need to call this method once
 * as long their data is persisted in storage -- the argument will be stored both in a
 * local instance of {@link android.content.SharedPreferences} and by the middleware.
 *
 * If this method is not called at least once before calling
 * {@link #download(android.telephony.mbms.DownloadRequest)}, the framework
 * will default to a directory formed by the concatenation of the app's files directory and
 * {@link android.telephony.MbmsDownloadSession#DEFAULT_TOP_LEVEL_TEMP_DIRECTORY MbmsDownloadSession#DEFAULT_TOP_LEVEL_TEMP_DIRECTORY}.
 *
 * Before calling this method, the app must cancel all of its pending
 * {@link android.telephony.mbms.DownloadRequest DownloadRequest}s via {@link #cancelDownload(android.telephony.mbms.DownloadRequest)}. If this is not done,
 * you will receive an asynchronous error with code
 * {@link android.telephony.mbms.MbmsErrors.DownloadErrors#ERROR_CANNOT_CHANGE_TEMP_FILE_ROOT MbmsErrors.DownloadErrors#ERROR_CANNOT_CHANGE_TEMP_FILE_ROOT} unless the
 * provided directory is the same as what has been previously configured.
 *
 * The {@link java.io.File File} supplied as a root temp file directory must already exist. If not, an
 * {@link java.lang.IllegalArgumentException IllegalArgumentException} will be thrown. In addition, as an additional sanity
 * check, an {@link java.lang.IllegalArgumentException IllegalArgumentException} will be thrown if you attempt to set the temp
 * file root directory to one of your data roots (the value of {@link android.content.Context#getDataDir() Context#getDataDir()},
 * {@link android.content.Context#getFilesDir() Context#getFilesDir()}, or {@link android.content.Context#getCacheDir() Context#getCacheDir()}).
 * @param tempFileRootDirectory A directory to place temp files in.
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public void setTempFileRootDirectory(@androidx.annotation.NonNull java.io.File tempFileRootDirectory) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the currently configured temp file root directory. Returns the file that was
 * configured via {@link #setTempFileRootDirectory(java.io.File)} or the default directory
 * {@link #download(android.telephony.mbms.DownloadRequest)} was called without ever
 * setting the temp file root. If neither method has been called since the last time the app's
 * shared preferences were reset, returns {@code null}.
 *
 * @return A {@link java.io.File File} pointing to the configured temp file directory, or null if not yet
 *         configured.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public java.io.File getTempFileRootDirectory() { throw new RuntimeException("Stub!"); }

/**
 * Requests the download of a file or set of files that the carrier has indicated to be
 * available.
 *
 * May throw an {@link java.lang.IllegalArgumentException IllegalArgumentException}
 *
 * If {@link #setTempFileRootDirectory(java.io.File)} has not called after the app has been installed,
 * this method will create a directory at the default location defined at
 * {@link android.telephony.MbmsDownloadSession#DEFAULT_TOP_LEVEL_TEMP_DIRECTORY MbmsDownloadSession#DEFAULT_TOP_LEVEL_TEMP_DIRECTORY} and store that as the temp
 * file root directory.
 *
 * If the {@link android.telephony.mbms.DownloadRequest DownloadRequest} has a destination that is not on the same filesystem as the
 * temp file directory provided via {@link #getTempFileRootDirectory()}, an
 * {@link java.lang.IllegalArgumentException IllegalArgumentException} will be thrown.
 *
 * Asynchronous errors through the callback may include any error not specific to the
 * streaming use-case.
 *
 * If no error is delivered via the callback after calling this method, that means that the
 * middleware has successfully started the download or scheduled the download, if the download
 * is at a future time.
 * @param request The request that specifies what should be downloaded.
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public void download(@androidx.annotation.NonNull android.telephony.mbms.DownloadRequest request) { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of pending {@link android.telephony.mbms.DownloadRequest DownloadRequest}s that originated from this application.
 * A pending request is one that was issued via
 * {@link #download(android.telephony.mbms.DownloadRequest)} but not cancelled through
 * {@link #cancelDownload(android.telephony.mbms.DownloadRequest)}.
 * @return A list, possibly empty, of {@link android.telephony.mbms.DownloadRequest DownloadRequest}s
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.util.List<android.telephony.mbms.DownloadRequest> listPendingDownloads() { throw new RuntimeException("Stub!"); }

/**
 * Registers a download status listener for a {@link android.telephony.mbms.DownloadRequest DownloadRequest} previously requested via
 * {@link #download(android.telephony.mbms.DownloadRequest)}. This callback will only be called as long as both this
 * app and the middleware are both running -- if either one stops, no further calls on the
 * provided {@link android.telephony.mbms.DownloadStatusListener DownloadStatusListener} will be enqueued.
 *
 * If the middleware is not aware of the specified download request,
 * this method will throw an {@link java.lang.IllegalArgumentException IllegalArgumentException}.
 *
 * If the operation encountered an error, the error code will be delivered via
 * {@link android.telephony.mbms.MbmsDownloadSessionCallback#onError MbmsDownloadSessionCallback#onError}.
 *
 * Repeated calls to this method for the same {@link android.telephony.mbms.DownloadRequest DownloadRequest} will replace the
 * previously registered listener.
 *
 * @param request The {@link android.telephony.mbms.DownloadRequest DownloadRequest} that you want updates on.
 * This value must never be {@code null}.
 * @param executor The {@link java.util.concurrent.Executor Executor} on which calls to {@code listener } should be executed.
 * This value must never be {@code null}.
 * @param listener The listener that should be called when the middleware has information to
 *                 share on the status download.
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public void addStatusListener(@androidx.annotation.NonNull android.telephony.mbms.DownloadRequest request, @androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull android.telephony.mbms.DownloadStatusListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Un-register a listener previously registered via
 * {@link #addStatusListener(android.telephony.mbms.DownloadRequest,java.util.concurrent.Executor,android.telephony.mbms.DownloadStatusListener)}. After
 * this method is called, no further calls will be enqueued on the {@link java.util.concurrent.Executor Executor}
 * provided upon registration, even if this method throws an exception.
 *
 * If the middleware is not aware of the specified download request,
 * this method will throw an {@link java.lang.IllegalArgumentException IllegalArgumentException}.
 *
 * If the operation encountered an error, the error code will be delivered via
 * {@link android.telephony.mbms.MbmsDownloadSessionCallback#onError MbmsDownloadSessionCallback#onError}.
 *
 * @param request The {@link android.telephony.mbms.DownloadRequest DownloadRequest} provided during registration
 * This value must never be {@code null}.
 * @param listener The listener provided during registration.
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public void removeStatusListener(@androidx.annotation.NonNull android.telephony.mbms.DownloadRequest request, @androidx.annotation.NonNull android.telephony.mbms.DownloadStatusListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Registers a progress listener for a {@link android.telephony.mbms.DownloadRequest DownloadRequest} previously requested via
 * {@link #download(android.telephony.mbms.DownloadRequest)}. This listener will only be called as long as both this
 * app and the middleware are both running -- if either one stops, no further calls on the
 * provided {@link android.telephony.mbms.DownloadProgressListener DownloadProgressListener} will be enqueued.
 *
 * If the middleware is not aware of the specified download request,
 * this method will throw an {@link java.lang.IllegalArgumentException IllegalArgumentException}.
 *
 * If the operation encountered an error, the error code will be delivered via
 * {@link android.telephony.mbms.MbmsDownloadSessionCallback#onError MbmsDownloadSessionCallback#onError}.
 *
 * Repeated calls to this method for the same {@link android.telephony.mbms.DownloadRequest DownloadRequest} will replace the
 * previously registered listener.
 *
 * @param request The {@link android.telephony.mbms.DownloadRequest DownloadRequest} that you want updates on.
 * This value must never be {@code null}.
 * @param executor The {@link java.util.concurrent.Executor Executor} on which calls to {@code listener} should be executed.
 * This value must never be {@code null}.
 * @param listener The listener that should be called when the middleware has information to
 *                 share on the progress of the download.
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public void addProgressListener(@androidx.annotation.NonNull android.telephony.mbms.DownloadRequest request, @androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull android.telephony.mbms.DownloadProgressListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Un-register a listener previously registered via
 * {@link #addProgressListener(android.telephony.mbms.DownloadRequest,java.util.concurrent.Executor,android.telephony.mbms.DownloadProgressListener)}. After
 * this method is called, no further callbacks will be enqueued on the {@link android.os.Handler Handler}
 * provided upon registration, even if this method throws an exception.
 *
 * If the middleware is not aware of the specified download request,
 * this method will throw an {@link java.lang.IllegalArgumentException IllegalArgumentException}.
 *
 * If the operation encountered an error, the error code will be delivered via
 * {@link android.telephony.mbms.MbmsDownloadSessionCallback#onError MbmsDownloadSessionCallback#onError}.
 *
 * @param request The {@link android.telephony.mbms.DownloadRequest DownloadRequest} provided during registration
 * This value must never be {@code null}.
 * @param listener The listener provided during registration.
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public void removeProgressListener(@androidx.annotation.NonNull android.telephony.mbms.DownloadRequest request, @androidx.annotation.NonNull android.telephony.mbms.DownloadProgressListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Attempts to cancel the specified {@link android.telephony.mbms.DownloadRequest DownloadRequest}.
 *
 * If the operation encountered an error, the error code will be delivered via
 * {@link android.telephony.mbms.MbmsDownloadSessionCallback#onError MbmsDownloadSessionCallback#onError}.
 *
 * @param downloadRequest The download request that you wish to cancel.
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public void cancelDownload(@androidx.annotation.NonNull android.telephony.mbms.DownloadRequest downloadRequest) { throw new RuntimeException("Stub!"); }

/**
 * Requests information about the state of a file pending download.
 *
 * The state will be delivered as a callback via
 * {@link android.telephony.mbms.DownloadStatusListener#onStatusUpdated(android.telephony.mbms.DownloadRequest,android.telephony.mbms.FileInfo,int) DownloadStatusListener#onStatusUpdated(DownloadRequest, FileInfo, int)}. If no such
 * callback has been registered via
 * {@link #addProgressListener(android.telephony.mbms.DownloadRequest,java.util.concurrent.Executor,android.telephony.mbms.DownloadProgressListener)}, this
 * method will be a no-op.
 *
 * If the middleware has no record of the
 * file indicated by {@code fileInfo} being associated with {@code downloadRequest},
 * an {@link java.lang.IllegalArgumentException IllegalArgumentException} will be thrown.
 *
 * @param downloadRequest The download request to query.
 * @param fileInfo The particular file within the request to get information on.
 * @apiSince 28
 */

public void requestDownloadState(android.telephony.mbms.DownloadRequest downloadRequest, android.telephony.mbms.FileInfo fileInfo) { throw new RuntimeException("Stub!"); }

/**
 * Resets the middleware's knowledge of previously-downloaded files in this download request.
 *
 * Normally, the middleware keeps track of the hashes of downloaded files and won't re-download
 * files whose server-reported hash matches one of the already-downloaded files. This means
 * that if the file is accidentally deleted by the user or by the app, the middleware will
 * not try to download it again.
 * This method will reset the middleware's cache of hashes for the provided
 * {@link android.telephony.mbms.DownloadRequest DownloadRequest}, so that previously downloaded content will be downloaded again
 * when available.
 * This will not interrupt in-progress downloads.
 *
 * This is distinct from cancelling and re-issuing the download request -- if you cancel and
 * re-issue, the middleware will not clear its cache of download state information.
 *
 * If the middleware is not aware of the specified download request, an
 * {@link java.lang.IllegalArgumentException IllegalArgumentException} will be thrown.
 *
 * @param downloadRequest The request to re-download files for.
 * @apiSince 28
 */

public void resetDownloadKnowledge(android.telephony.mbms.DownloadRequest downloadRequest) { throw new RuntimeException("Stub!"); }

/**
 * Terminates this instance.
 *
 * After this method returns,
 * no further callbacks originating from the middleware will be enqueued on the provided
 * instance of {@link android.telephony.mbms.MbmsDownloadSessionCallback MbmsDownloadSessionCallback}, but callbacks that have already been
 * enqueued will still be delivered.
 *
 * It is safe to call {@link #create(android.content.Context,java.util.concurrent.Executor,int,android.telephony.mbms.MbmsDownloadSessionCallback)} to
 * obtain another instance of {@link android.telephony.MbmsDownloadSession MbmsDownloadSession} immediately after this method
 * returns.
 *
 * May throw an {@link java.lang.IllegalStateException IllegalStateException}
 * @apiSince 28
 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * The default directory name for all MBMS temp files. If you call
 * {@link #download(android.telephony.mbms.DownloadRequest)} without first calling
 * {@link #setTempFileRootDirectory(java.io.File)}, this directory will be created for you under the
 * path returned by {@link android.content.Context#getFilesDir() Context#getFilesDir()}.
 * @apiSince 28
 */

public static final java.lang.String DEFAULT_TOP_LEVEL_TEMP_DIRECTORY = "androidMbmsTempFileRoot";

/**
 * {@link android.net.Uri Uri} extra that Android will attach to the intent supplied via
 * {@link android.telephony.mbms.DownloadRequest.Builder#setAppIntent(Intent)}
 * Indicates the location of the successfully downloaded file within the directory that the
 * app provided via the builder.
 *
 * Will always be set to a non-null value if
 * {@link #EXTRA_MBMS_DOWNLOAD_RESULT} is set to {@link #RESULT_SUCCESSFUL}.
 * @apiSince 28
 */

public static final java.lang.String EXTRA_MBMS_COMPLETED_FILE_URI = "android.telephony.extra.MBMS_COMPLETED_FILE_URI";

/**
 * Extra containing the {@link android.telephony.mbms.DownloadRequest DownloadRequest} for which the download result or file
 * descriptor request is for. Must not be null.
 * @apiSince 28
 */

public static final java.lang.String EXTRA_MBMS_DOWNLOAD_REQUEST = "android.telephony.extra.MBMS_DOWNLOAD_REQUEST";

/**
 * Integer extra that Android will attach to the intent supplied via
 * {@link android.telephony.mbms.DownloadRequest.Builder#setAppIntent(Intent)}
 * Indicates the result code of the download. One of
 * {@link #RESULT_SUCCESSFUL}, {@link #RESULT_EXPIRED}, {@link #RESULT_CANCELLED},
 * {@link #RESULT_IO_ERROR}, {@link #RESULT_DOWNLOAD_FAILURE}, {@link #RESULT_OUT_OF_STORAGE},
 * {@link #RESULT_SERVICE_ID_NOT_DEFINED}, or {@link #RESULT_FILE_ROOT_UNREACHABLE}.
 *
 * This extra may also be used by the middleware when it is sending intents to the app.
 * @apiSince 28
 */

public static final java.lang.String EXTRA_MBMS_DOWNLOAD_RESULT = "android.telephony.extra.MBMS_DOWNLOAD_RESULT";

/**
 * {@link android.telephony.mbms.FileInfo FileInfo} extra that Android will attach to the intent supplied via
 * {@link android.telephony.mbms.DownloadRequest.Builder#setAppIntent(Intent)}
 * Indicates the file for which the download result is for. Never null.
 *
 * This extra may also be used by the middleware when it is sending intents to the app.
 * @apiSince 28
 */

public static final java.lang.String EXTRA_MBMS_FILE_INFO = "android.telephony.extra.MBMS_FILE_INFO";

/**
 * Indicates that the download was cancelled via {@link #cancelDownload(android.telephony.mbms.DownloadRequest)}.
 * @apiSince 28
 */

public static final int RESULT_CANCELLED = 2; // 0x2

/**
 * Indicates that there was an error while processing downloaded files, such as a file repair or
 * file decoding error and is not due to a file I/O error.
 *
 * This is likely a transient error and another {@link android.telephony.mbms.DownloadRequest DownloadRequest} should be sent to try
 * the download again.
 * @apiSince 28
 */

public static final int RESULT_DOWNLOAD_FAILURE = 6; // 0x6

/**
 * Indicates that the download will not be completed due to the expiration of its download
 * window on the carrier's network.
 * @apiSince 28
 */

public static final int RESULT_EXPIRED = 3; // 0x3

/**
 * Indicates that the file root that was set is currently unreachable. This can happen if the
 * temp files are set to be stored on external storage and the SD card was removed, for example.
 * The temp file root should be changed before sending another DownloadRequest.
 * @apiSince 28
 */

public static final int RESULT_FILE_ROOT_UNREACHABLE = 8; // 0x8

/**
 * Indicates that the download will not be completed due to an I/O error incurred while
 * writing to temp files.
 *
 * This is likely a transient error and another {@link android.telephony.mbms.DownloadRequest DownloadRequest} should be sent to try
 * the download again.
 * @apiSince 28
 */

public static final int RESULT_IO_ERROR = 4; // 0x4

/**
 * Indicates that the file system is full and the {@link android.telephony.mbms.DownloadRequest DownloadRequest} can not complete.
 * Either space must be made on the current file system or the temp file root location must be
 * changed to a location that is not full to download the temp files.
 * @apiSince 28
 */

public static final int RESULT_OUT_OF_STORAGE = 7; // 0x7

/**
 * Indicates that the Service ID specified in the {@link android.telephony.mbms.DownloadRequest DownloadRequest} is incorrect due to
 * the Id being incorrect, stale, expired, or similar.
 * @apiSince 28
 */

public static final int RESULT_SERVICE_ID_NOT_DEFINED = 5; // 0x5

/**
 * Indicates that the download was successful.
 * @apiSince 28
 */

public static final int RESULT_SUCCESSFUL = 1; // 0x1

/**
 * Indicates that the file is actively being downloaded.
 * @apiSince 28
 */

public static final int STATUS_ACTIVELY_DOWNLOADING = 1; // 0x1

/**
 * Indicates that the file is awaiting the next download or repair operations. When a more
 * precise status is known, the status will change to either {@link #STATUS_PENDING_REPAIR} or
 * {@link #STATUS_PENDING_DOWNLOAD_WINDOW}.
 * @apiSince 28
 */

public static final int STATUS_PENDING_DOWNLOAD = 2; // 0x2

/**
 * Indicates that the file is waiting to download because its download window has not yet
 * started and is scheduled for a future time.
 * @apiSince 28
 */

public static final int STATUS_PENDING_DOWNLOAD_WINDOW = 4; // 0x4

/**
 * Indicates that the file is awaiting file repair after the download has ended.
 * @apiSince 28
 */

public static final int STATUS_PENDING_REPAIR = 3; // 0x3

/**
 * Indicates that the middleware has no information on the file.
 * @apiSince 28
 */

public static final int STATUS_UNKNOWN = 0; // 0x0
}

