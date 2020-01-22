/*
 * Copyright (C) 2009 The Android Open Source Project
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


package android.content;


/**
 * Contains the result of the application of a {@link android.content.ContentProviderOperation ContentProviderOperation}. It is guaranteed
 * to have exactly one of {@link #uri} or {@link #count} set.
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ContentProviderResult implements android.os.Parcelable {

/** @apiSince 5 */

public ContentProviderResult(android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public ContentProviderResult(int count) { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public ContentProviderResult(android.os.Parcel source) { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.content.ContentProviderResult> CREATOR;
static { CREATOR = null; }

/** @apiSince 5 */

public final java.lang.Integer count;
{ count = null; }

/** @apiSince 5 */

public final android.net.Uri uri;
{ uri = null; }
}

