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
import java.util.List;

/**
 * A callback class that apps should use to receive information on file downloads over
 * cell-broadcast.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MbmsDownloadSessionCallback {

public MbmsDownloadSessionCallback() { throw new RuntimeException("Stub!"); }

/**
 * Indicates that the middleware has encountered an asynchronous error.
 * @param errorCode Any error code listed in {@link android.telephony.mbms.MbmsErrors MbmsErrors}
 * Value is {@link android.telephony.mbms.MbmsErrors#ERROR_NO_UNIQUE_MIDDLEWARE}, {@link android.telephony.mbms.MbmsErrors#ERROR_MIDDLEWARE_LOST}, {@link android.telephony.mbms.MbmsErrors#ERROR_MIDDLEWARE_NOT_BOUND}, {@link android.telephony.mbms.MbmsErrors.InitializationErrors#ERROR_APP_PERMISSIONS_NOT_GRANTED}, {@link android.telephony.mbms.MbmsErrors.InitializationErrors#ERROR_DUPLICATE_INITIALIZE}, {@link android.telephony.mbms.MbmsErrors.InitializationErrors#ERROR_UNABLE_TO_INITIALIZE}, {@link android.telephony.mbms.MbmsErrors.GeneralErrors#ERROR_MIDDLEWARE_NOT_YET_READY}, {@link android.telephony.mbms.MbmsErrors.GeneralErrors#ERROR_OUT_OF_MEMORY}, {@link android.telephony.mbms.MbmsErrors.GeneralErrors#ERROR_MIDDLEWARE_TEMPORARILY_UNAVAILABLE}, {@link android.telephony.mbms.MbmsErrors.GeneralErrors#ERROR_IN_E911}, {@link android.telephony.mbms.MbmsErrors.GeneralErrors#ERROR_NOT_CONNECTED_TO_HOME_CARRIER_LTE}, {@link android.telephony.mbms.MbmsErrors.GeneralErrors#ERROR_UNABLE_TO_READ_SIM}, {@link android.telephony.mbms.MbmsErrors.GeneralErrors#ERROR_CARRIER_CHANGE_NOT_ALLOWED}, {@link android.telephony.mbms.MbmsErrors.DownloadErrors#ERROR_CANNOT_CHANGE_TEMP_FILE_ROOT}, {@link android.telephony.mbms.MbmsErrors.DownloadErrors#ERROR_UNKNOWN_DOWNLOAD_REQUEST}, or {@link android.telephony.mbms.MbmsErrors.DownloadErrors#ERROR_UNKNOWN_FILE_INFO}
 * @param message A message, intended for debugging purposes, describing the error in further
 *                detail.
 * @apiSince 28
 */

public void onError(int errorCode, java.lang.String message) { throw new RuntimeException("Stub!"); }

/**
 * Called to indicate published File Services have changed.
 *
 * This will only be called after the application has requested a list of file services and
 * specified a service class list of interest via
 * {@link android.telephony.MbmsDownloadSession#requestUpdateFileServices(java.util.List) MbmsDownloadSession#requestUpdateFileServices(List)}. If there are subsequent calls to
 * {@link android.telephony.MbmsDownloadSession#requestUpdateFileServices(java.util.List) MbmsDownloadSession#requestUpdateFileServices(List)},
 * this method may not be called again if
 * the list of service classes would remain the same.
 *
 * @param services The most recently updated list of available file services.
 * @apiSince 28
 */

public void onFileServicesUpdated(java.util.List<android.telephony.mbms.FileServiceInfo> services) { throw new RuntimeException("Stub!"); }

/**
 * Called to indicate that the middleware has been initialized and is ready.
 *
 * Before this method is called, calling any method on an instance of
 * {@link android.telephony.MbmsDownloadSession MbmsDownloadSession} will result in an {@link java.lang.IllegalStateException IllegalStateException}
 * being thrown or {@link #onError(int,java.lang.String)} being called with error code
 * {@link android.telephony.mbms.MbmsErrors.GeneralErrors#ERROR_MIDDLEWARE_NOT_YET_READY MbmsErrors.GeneralErrors#ERROR_MIDDLEWARE_NOT_YET_READY}
 * @apiSince 28
 */

public void onMiddlewareReady() { throw new RuntimeException("Stub!"); }
}

