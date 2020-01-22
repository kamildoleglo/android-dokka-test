/*
 * Copyright (C) 2017 The Android Open Source Project
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

import android.net.Uri;
import android.content.Intent;
import java.io.File;

/**
 * Describes a request to download files over cell-broadcast. Instances of this class should be
 * created by the app when requesting a download, and instances of this class will be passed back
 * to the app when the middleware updates the status of the download.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class DownloadRequest implements android.os.Parcelable {

private DownloadRequest() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/**
 * @return The ID of the file service to download from.
 * @apiSince 28
 */

public java.lang.String getFileServiceId() { throw new RuntimeException("Stub!"); }

/**
 * @return The source URI to download from
 * @apiSince 28
 */

public android.net.Uri getSourceUri() { throw new RuntimeException("Stub!"); }

/**
 * @return The destination {@link android.net.Uri Uri} of the downloaded file.
 * @apiSince 28
 */

public android.net.Uri getDestinationUri() { throw new RuntimeException("Stub!"); }

/**
 * @return The subscription ID on which to perform MBMS operations.
 * @apiSince 28
 */

public int getSubscriptionId() { throw new RuntimeException("Stub!"); }

/**
 * This method returns a byte array that may be persisted to disk and restored to a
 * {@link android.telephony.mbms.DownloadRequest DownloadRequest}. The instance of {@link android.telephony.mbms.DownloadRequest DownloadRequest} persisted by this method
 * may be recovered via {@link android.telephony.mbms.DownloadRequest.Builder#fromSerializedRequest(byte[]) Builder#fromSerializedRequest(byte[])}.
 * @return A byte array of data to persist.
 * @apiSince 28
 */

public byte[] toByteArray() { throw new RuntimeException("Stub!"); }

/**
 * Maximum permissible length for the app's destination path, when serialized via
 * {@link android.net.Uri#toString() Uri#toString()}.
 * @apiSince 28
 */

public static int getMaxAppIntentSize() { throw new RuntimeException("Stub!"); }

/**
 * Maximum permissible length for the app's download-completion intent, when serialized via
 * {@link android.content.Intent#toUri(int) Intent#toUri(int)}.
 * @apiSince 28
 */

public static int getMaxDestinationUriSize() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param o This value may be {@code null}.
 * @apiSince 28
 */

public boolean equals(@androidx.annotation.Nullable java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telephony.mbms.DownloadRequest> CREATOR;
static { CREATOR = null; }
/** @apiSince 28 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

/**
 * Builds a new DownloadRequest.
 * @param sourceUri the source URI for the DownloadRequest to be built. This URI should
 *     never be null.
 * This value must never be {@code null}.
 * @param destinationUri The final location for the file(s) that are to be downloaded. It
 *     must be on the same filesystem as the temp file directory set via
 *     {@link android.telephony.MbmsDownloadSession#setTempFileRootDirectory(File)}.
 *     The provided path must be a directory that exists. An
 *     {@link java.lang.IllegalArgumentException IllegalArgumentException} will be thrown otherwise.
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public Builder(@androidx.annotation.NonNull android.net.Uri sourceUri, @androidx.annotation.NonNull android.net.Uri destinationUri) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a {@link android.telephony.mbms.DownloadRequest.Builder Builder} from a {@link android.telephony.mbms.DownloadRequest DownloadRequest}
 * @param other The {@link android.telephony.mbms.DownloadRequest DownloadRequest} from which the data for the {@link android.telephony.mbms.DownloadRequest.Builder Builder}
 *              should come.
 * @return An instance of {@link android.telephony.mbms.DownloadRequest.Builder Builder} pre-populated with data from the provided
 *         {@link android.telephony.mbms.DownloadRequest DownloadRequest}.
 * @apiSince 28
 */

public static android.telephony.mbms.DownloadRequest.Builder fromDownloadRequest(android.telephony.mbms.DownloadRequest other) { throw new RuntimeException("Stub!"); }

/**
 * This method constructs a new instance of {@link android.telephony.mbms.DownloadRequest.Builder Builder} based on the serialized data
 * passed in.
 * @param data A byte array, the contents of which should have been originally obtained
 *             from {@link android.telephony.mbms.DownloadRequest#toByteArray() DownloadRequest#toByteArray()}.
 * @apiSince 28
 */

public static android.telephony.mbms.DownloadRequest.Builder fromSerializedRequest(byte[] data) { throw new RuntimeException("Stub!"); }

/**
 * Sets the service from which the download request to be built will download from.
 * @param serviceInfo
 * @return
 * @apiSince 28
 */

public android.telephony.mbms.DownloadRequest.Builder setServiceInfo(android.telephony.mbms.FileServiceInfo serviceInfo) { throw new RuntimeException("Stub!"); }

/**
 * Set the subscription ID on which the file(s) should be downloaded.
 * @param subscriptionId
 * @apiSince 28
 */

public android.telephony.mbms.DownloadRequest.Builder setSubscriptionId(int subscriptionId) { throw new RuntimeException("Stub!"); }

/**
 * Set the {@link android.content.Intent Intent} that should be sent when the download completes or fails. This
 * should be an intent with a explicit {@link android.content.ComponentName} targeted to a
 * {@link android.content.BroadcastReceiver} in the app's package.
 *
 * The middleware should not use this method.
 * @param intent
 * @apiSince 28
 */

public android.telephony.mbms.DownloadRequest.Builder setAppIntent(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public android.telephony.mbms.DownloadRequest build() { throw new RuntimeException("Stub!"); }
}

}

