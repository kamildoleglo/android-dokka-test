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
public class DownloadStatusListener {

public DownloadStatusListener() { throw new RuntimeException("Stub!"); }

/**
 * Gives download status callbacks for a file in a {@link android.telephony.mbms.DownloadRequest DownloadRequest}.
 *
 * @param request a {@link android.telephony.mbms.DownloadRequest DownloadRequest}, indicating which download is being referenced.
 * @param fileInfo a {@link android.telephony.mbms.FileInfo FileInfo} specifying the file to report progress on.  Note that
 *   the request may result in many files being downloaded and the client
 *   may not have been able to get a list of them in advance.
 * @param status The current status of the download.
 
 * Value is {@link android.telephony.MbmsDownloadSession#STATUS_UNKNOWN}, {@link android.telephony.MbmsDownloadSession#STATUS_ACTIVELY_DOWNLOADING}, {@link android.telephony.MbmsDownloadSession#STATUS_PENDING_DOWNLOAD}, {@link android.telephony.MbmsDownloadSession#STATUS_PENDING_REPAIR}, or {@link android.telephony.MbmsDownloadSession#STATUS_PENDING_DOWNLOAD_WINDOW}
 * @apiSince 28
 */

public void onStatusUpdated(android.telephony.mbms.DownloadRequest request, android.telephony.mbms.FileInfo fileInfo, int status) { throw new RuntimeException("Stub!"); }
}

