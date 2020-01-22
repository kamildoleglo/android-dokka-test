/*
 * Copyright (C) 2018 The Android Open Source Project
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
 * limitations under the License
 */


package android.telephony.mbms;

import android.telephony.MbmsDownloadSession;

/**
 * A optional listener class used by download clients to track progress. Apps should extend this
 * class and pass an instance into
 * {@link android.telephony.MbmsDownloadSession#download(android.telephony.mbms.DownloadRequest) MbmsDownloadSession#download(DownloadRequest)}
 *
 * This is optionally specified when requesting a download and will only be called while the app
 * is running.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DownloadProgressListener {

public DownloadProgressListener() { throw new RuntimeException("Stub!"); }

/**
 * Called when the middleware wants to report progress for a file in a {@link android.telephony.mbms.DownloadRequest DownloadRequest}.
 *
 * @param request a {@link android.telephony.mbms.DownloadRequest DownloadRequest}, indicating which download is being referenced.
 * @param fileInfo a {@link android.telephony.mbms.FileInfo FileInfo} specifying the file to report progress on.  Note that
 *   the request may result in many files being downloaded and the client
 *   may not have been able to get a list of them in advance.
 * @param currentDownloadSize is the current amount downloaded.
 * @param fullDownloadSize is the total number of bytes that make up the downloaded content.
 *   This may be different from the decoded final size, but is useful in gauging download
 *   progress.
 * @param currentDecodedSize is the number of bytes that have been decoded.
 * @param fullDecodedSize is the total number of bytes that make up the final decoded content.
 * @apiSince 28
 */

public void onProgressUpdated(android.telephony.mbms.DownloadRequest request, android.telephony.mbms.FileInfo fileInfo, int currentDownloadSize, int fullDownloadSize, int currentDecodedSize, int fullDecodedSize) { throw new RuntimeException("Stub!"); }
}

