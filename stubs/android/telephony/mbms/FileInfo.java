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
 * Describes a single file that is available over MBMS.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class FileInfo implements android.os.Parcelable {

FileInfo() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * @return The URI in the carrier's infrastructure which points to this file. Apps should
 * negotiate the contents of this URI separately with the carrier.
 * @apiSince 28
 */

public android.net.Uri getUri() { throw new RuntimeException("Stub!"); }

/**
 * @return The MIME type of the file.
 * @apiSince 28
 */

public java.lang.String getMimeType() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telephony.mbms.FileInfo> CREATOR;
static { CREATOR = null; }
}

