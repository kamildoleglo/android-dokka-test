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


package android.content.res;


/**
 * Basic information about a Opaque Binary Blob (OBB) that reflects the info
 * from the footer on the OBB file. This information may be manipulated by a
 * developer with the <code>obbtool</code> program in the Android SDK.
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ObbInfo implements android.os.Parcelable {

ObbInfo() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

public void writeToParcel(android.os.Parcel dest, int parcelableFlags) { throw new RuntimeException("Stub!"); }

/** @apiSince 9 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.content.res.ObbInfo> CREATOR;
static { CREATOR = null; }

/**
 * Flag noting that this OBB is an overlay patch for a base OBB.
 * @apiSince 9
 */

public static final int OBB_OVERLAY = 1; // 0x1

/**
 * The canonical filename of the OBB.
 * @apiSince 9
 */

public java.lang.String filename;

/**
 * The flags relating to the OBB.
 * @apiSince 9
 */

public int flags;

/**
 * The name of the package to which the OBB file belongs.
 * @apiSince 9
 */

public java.lang.String packageName;

/**
 * The version of the package to which the OBB file belongs.
 * @apiSince 9
 */

public int version;
}

