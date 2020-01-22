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
 * This class represents the unique id of a printer.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class PrinterId implements android.os.Parcelable {

PrinterId() { throw new RuntimeException("Stub!"); }

/**
 * Gets the id of this printer which is unique in the context
 * of the print service that manages it.
 *
 * @return The printer name.
 
 * This value will never be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.NonNull
public java.lang.String getLocalId() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public boolean equals(java.lang.Object object) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.print.PrinterId> CREATOR;
static { CREATOR = null; }
}

