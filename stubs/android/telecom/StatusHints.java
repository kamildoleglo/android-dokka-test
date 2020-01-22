/*
 * Copyright (C) 2014 The Android Open Source Project
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


package android.telecom;


/**
 * Contains status label and icon displayed in the in-call UI.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class StatusHints implements android.os.Parcelable {

/** @apiSince 23 */

public StatusHints(java.lang.CharSequence label, android.graphics.drawable.Icon icon, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * @return The label displayed in the in-call UI.
 * @apiSince 23
 */

public java.lang.CharSequence getLabel() { throw new RuntimeException("Stub!"); }

/**
 * @return An icon depicting the status.
 * @apiSince 23
 */

public android.graphics.drawable.Icon getIcon() { throw new RuntimeException("Stub!"); }

/**
 * @return Extra data used to display status.
 * @apiSince 23
 */

public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public boolean equals(java.lang.Object other) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telecom.StatusHints> CREATOR;
static { CREATOR = null; }
}

