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


package android.text;


/**
 * Annotations are simple key-value pairs that are preserved across
 * TextView save/restore cycles and can be used to keep application-specific
 * data that needs to be maintained for regions of text.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Annotation implements android.text.ParcelableSpan {

/** @apiSince 1 */

public Annotation(java.lang.String key, java.lang.String value) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public Annotation(android.os.Parcel src) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public int getSpanTypeId() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String getKey() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String getValue() { throw new RuntimeException("Stub!"); }
}

