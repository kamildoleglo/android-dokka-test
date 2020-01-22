/*
 * Copyright (C) 2008 The Android Open Source Project
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


package android.media;

import android.net.Uri;
import android.content.Context;
import android.content.ServiceConnection;

/**
 * MediaScannerConnection provides a way for applications to pass a
 * newly created or downloaded media file to the media scanner service.
 * The media scanner service will read metadata from the file and add
 * the file to the media content provider.
 * The MediaScannerConnectionClient provides an interface for the
 * media scanner service to return the Uri for a newly scanned file
 * to the client of the MediaScannerConnection class.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MediaScannerConnection implements android.content.ServiceConnection {

/**
 * Constructs a new MediaScannerConnection object.
 * @param context the Context object, required for establishing a connection to
 * the media scanner service.
 * @param client an optional object implementing the MediaScannerConnectionClient
 * interface, for receiving notifications from the media scanner.
 * @apiSince 1
 */

public MediaScannerConnection(android.content.Context context, android.media.MediaScannerConnection.MediaScannerConnectionClient client) { throw new RuntimeException("Stub!"); }

/**
 * Initiates a connection to the media scanner service.
 * {@link android.media.MediaScannerConnection.MediaScannerConnectionClient#onMediaScannerConnected() MediaScannerConnectionClient#onMediaScannerConnected()}
 * will be called when the connection is established.
 * @apiSince 1
 */

public void connect() { throw new RuntimeException("Stub!"); }

/**
 * Releases the connection to the media scanner service.
 * @apiSince 1
 */

public void disconnect() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether we are connected to the media scanner service
 * @return true if we are connected, false otherwise
 * @apiSince 1
 */

public synchronized boolean isConnected() { throw new RuntimeException("Stub!"); }

/**
 * Requests the media scanner to scan a file.
 * Success or failure of the scanning operation cannot be determined until
 * {@link android.media.MediaScannerConnection.MediaScannerConnectionClient#onScanCompleted(java.lang.String,android.net.Uri) MediaScannerConnectionClient#onScanCompleted(String, Uri)} is called.
 *
 * @param path the path to the file to be scanned.
 * @param mimeType  an optional mimeType for the file.
 * If mimeType is null, then the mimeType will be inferred from the file extension.
 * @apiSince 1
 */

public void scanFile(java.lang.String path, java.lang.String mimeType) { throw new RuntimeException("Stub!"); }

/**
 * Convenience for constructing a {@link android.media.MediaScannerConnection MediaScannerConnection}, calling
 * {@link #connect} on it, and calling {@link #scanFile(java.lang.String,java.lang.String)} with the given
 * <var>path</var> and <var>mimeType</var> when the connection is
 * established.
 * @param context The caller's Context, required for establishing a connection to
 * the media scanner service.
 * Success or failure of the scanning operation cannot be determined until
 * {@link android.media.MediaScannerConnection.MediaScannerConnectionClient#onScanCompleted(java.lang.String,android.net.Uri) MediaScannerConnectionClient#onScanCompleted(String, Uri)} is called.
 * @param paths Array of paths to be scanned.
 * @param mimeTypes Optional array of MIME types for each path.
 * If mimeType is null, then the mimeType will be inferred from the file extension.
 * @param callback Optional callback through which you can receive the
 * scanned URI and MIME type; If null, the file will be scanned but
 * you will not get a result back.
 * @see #scanFile(String, String)
 * @apiSince 8
 */

public static void scanFile(android.content.Context context, java.lang.String[] paths, java.lang.String[] mimeTypes, android.media.MediaScannerConnection.OnScanCompletedListener callback) { throw new RuntimeException("Stub!"); }

/**
 * Part of the ServiceConnection interface.  Do not call.
 * @apiSince 1
 */

public void onServiceConnected(android.content.ComponentName className, android.os.IBinder service) { throw new RuntimeException("Stub!"); }

/**
 * Part of the ServiceConnection interface.  Do not call.
 * @apiSince 1
 */

public void onServiceDisconnected(android.content.ComponentName className) { throw new RuntimeException("Stub!"); }
/**
 * An interface for notifying clients of MediaScannerConnection
 * when a connection to the MediaScanner service has been established
 * and when the scanning of a file has completed.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface MediaScannerConnectionClient extends android.media.MediaScannerConnection.OnScanCompletedListener {

/**
 * Called to notify the client when a connection to the
 * MediaScanner service has been established.
 * @apiSince 1
 */

public void onMediaScannerConnected();

/**
 * Called to notify the client when the media scanner has finished
 * scanning a file.
 * @param path the path to the file that has been scanned.
 * @param uri the Uri for the file if the scanning operation succeeded
 * and the file was added to the media database, or null if scanning failed.
 * @apiSince 1
 */

public void onScanCompleted(java.lang.String path, android.net.Uri uri);
}

/**
 * Interface for notifying clients of the result of scanning a
 * requested media file.
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnScanCompletedListener {

/**
 * Called to notify the client when the media scanner has finished
 * scanning a file.
 * @param path the path to the file that has been scanned.
 * @param uri the Uri for the file if the scanning operation succeeded
 * and the file was added to the media database, or null if scanning failed.
 * @apiSince 8
 */

public void onScanCompleted(java.lang.String path, android.net.Uri uri);
}

}

