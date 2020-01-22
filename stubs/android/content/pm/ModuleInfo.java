/*
 * Copyright (C) 2018 The Android Open Source Project
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


package android.content.pm;

import android.os.Parcel;

/**
 * Information you can retrieve about a particular system
 * module.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ModuleInfo implements android.os.Parcelable {

ModuleInfo() { throw new RuntimeException("Stub!"); }

/**
 * Gets the public name of this module.
 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.lang.CharSequence getName() { throw new RuntimeException("Stub!"); }

/**
 * Gets the package name of this module.
 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.lang.String getPackageName() { throw new RuntimeException("Stub!"); }

/**
 * Gets whether or not this package is hidden.
 * @apiSince 29
 */

public boolean isHidden() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of this object.
 * @apiSince 29
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Describes the kinds of special objects contained in this object.
 * @apiSince 29
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Flattens this object into the given {@link android.os.Parcel Parcel}.
 * @apiSince 29
 */

public void writeToParcel(android.os.Parcel dest, int parcelableFlags) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.content.pm.ModuleInfo> CREATOR;
static { CREATOR = null; }
}

