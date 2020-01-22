/*
 * Copyright (C) 2006 The Android Open Source Project
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


package android.view;

import android.os.Parcelable;

/**
 * A {@link android.os.Parcelable Parcelable} implementation that should be used by inheritance
 * hierarchies to ensure the state of all classes along the chain is saved.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class AbsSavedState implements android.os.Parcelable {

/**
 * Constructor called by derived classes when creating their SavedState objects
 *
 * @param superState The state of the superclass of this view
 * @apiSince 1
 */

protected AbsSavedState(android.os.Parcelable superState) { throw new RuntimeException("Stub!"); }

/**
 * Constructor used when reading from a parcel. Reads the state of the superclass.
 *
 * @param source parcel to read from
 * @apiSince 1
 */

protected AbsSavedState(android.os.Parcel source) { throw new RuntimeException("Stub!"); }

/**
 * Constructor used when reading from a parcel using a given class loader.
 * Reads the state of the superclass.
 *
 * @param source parcel to read from
 * @param loader ClassLoader to use for reading
 * @apiSince 24
 */

protected AbsSavedState(android.os.Parcel source, java.lang.ClassLoader loader) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final android.os.Parcelable getSuperState() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.AbsSavedState> CREATOR;
static { CREATOR = null; }

/** @apiSince 1 */

public static final android.view.AbsSavedState EMPTY_STATE;
static { EMPTY_STATE = null; }
}

