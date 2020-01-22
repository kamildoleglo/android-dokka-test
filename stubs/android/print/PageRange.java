/*
 * Copyright (C) 2013 The Android Open Source Project
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


package android.print;


/**
 * Represents a range of pages. The start and end page indices of
 * the range are zero based and inclusive.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class PageRange implements android.os.Parcelable {

/**
 * Creates a new instance.
 *
 * @param start The start page index (zero based and inclusive).
 * Value is 0 or greater
 * @param end The end page index (zero based and inclusive).
 *
 * Value is 0 or greater
 * @throws java.lang.IllegalArgumentException If start is less than zero or end
 * is less than zero or start greater than end.
 * @apiSince 19
 */

public PageRange(int start, int end) { throw new RuntimeException("Stub!"); }

/**
 * Gets the start page index (zero based and inclusive).
 *
 * @return The start page index.
 
 * Value is 0 or greater
 * @apiSince 19
 */

public int getStart() { throw new RuntimeException("Stub!"); }

/**
 * Gets the end page index (zero based and inclusive).
 *
 * @return The end page index.
 
 * Value is 0 or greater
 * @apiSince 19
 */

public int getEnd() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Constant for specifying all pages.
 * @apiSince 19
 */

public static final android.print.PageRange ALL_PAGES;
static { ALL_PAGES = null; }

/** @apiSince 19 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.print.PageRange> CREATOR;
static { CREATOR = null; }
}

