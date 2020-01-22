/*
 * Copyright (C) 2019 The Android Open Source Project
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

package android.app;

import android.content.LocusId;

/**
 * Represents a abstract action that can be perform on this app. This are requested from
 * outside the app's UI (eg by SystemUI or assistant). The semantics of these actions are
 * not specified by the OS. This allows open-ended and scalable approach for defining how
 * an app interacts with components that expose alternative interaction models to the user
 * such as the assistant, SystemUI, etc. You can use {@link #equals(java.lang.Object)} to compare
 * instances of this class.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class DirectAction implements android.os.Parcelable {

DirectAction() { throw new RuntimeException("Stub!"); }

/**
 * @return the ID for this action.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.lang.String getId() { throw new RuntimeException("Stub!"); }

/**
 * @return any extras associated with this action.
 
 * This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * @return the LocusId for the current state for the app
 
 * This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.content.LocusId getLocusId() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public boolean equals(java.lang.Object other) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.DirectAction> CREATOR;
static { CREATOR = null; }
/**
 * Builder for construction of DirectAction.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Creates a new instance.
 *
 * @param id The mandatory action id which must be unique in the
 *     current application state.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public Builder(@androidx.annotation.NonNull java.lang.String id) { throw new RuntimeException("Stub!"); }

/**
 * Sets the optional action extras. These extras are action specific
 * and their semantics are open-ended potentially representing how
 * the action is visualized, interpreted, what its arguments are, etc.
 *
 * @param extras The extras.
 * This value may be {@code null}.
 * @return This builder.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.app.DirectAction.Builder setExtras(@androidx.annotation.Nullable android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Sets the optional locus id. This is an identifier of the application
 * state from a user perspective. For example, a specific chat in a
 * messaging app.
 *
 * @param locusId The locus id.
 * This value may be {@code null}.
 * @return This builder.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.app.DirectAction.Builder setLocusId(@androidx.annotation.Nullable android.content.LocusId locusId) { throw new RuntimeException("Stub!"); }

/**
 * @return A newly constructed instance.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.app.DirectAction build() { throw new RuntimeException("Stub!"); }
}

}

