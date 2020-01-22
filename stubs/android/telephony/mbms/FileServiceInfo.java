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


/**
 * Describes a file service available from the carrier from which files can be downloaded via
 * cell-broadcast.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class FileServiceInfo extends android.telephony.mbms.ServiceInfo implements android.os.Parcelable {

FileServiceInfo() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * @return A list of files available from this service. Note that this list may not be
 * exhaustive -- the middleware may not have information on all files that are available.
 * Consult the carrier for an authoritative and exhaustive list.
 * @apiSince 28
 */

public java.util.List<android.telephony.mbms.FileInfo> getFiles() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telephony.mbms.FileServiceInfo> CREATOR;
static { CREATOR = null; }
}

