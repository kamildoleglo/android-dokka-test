/*
 * Copyright (C) 2017 The Android Open Source Project
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


package android.companion;


/**
 * A request for the user to select a companion device to associate with.
 *
 * You can optionally set {@link android.companion.AssociationRequest.Builder#addDeviceFilter Builder#addDeviceFilter} for which devices to show to the
 * user to select from.
 * The exact type and fields of the filter you can set depend on the
 * medium type. See {@link android.companion.AssociationRequest.Builder Builder}'s static factory methods for specific protocols that are
 * supported.
 *
 * You can also set {@link android.companion.AssociationRequest.Builder#setSingleDevice Builder#setSingleDevice} to request a popup with single
 * device to be shown instead of a list to choose from
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class AssociationRequest implements android.os.Parcelable {

private AssociationRequest() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.companion.AssociationRequest> CREATOR;
static { CREATOR = null; }
/**
 * A builder for {@link android.companion.AssociationRequest AssociationRequest}
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/** @apiSince 26 */

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * @param singleDevice if true, scanning for a device will stop as soon as at least one
 *                     fitting device is found
 
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.companion.AssociationRequest.Builder setSingleDevice(boolean singleDevice) { throw new RuntimeException("Stub!"); }

/**
 * @param deviceFilter if set, only devices matching the given filter will be shown to the
 *                     user
 
 * This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.companion.AssociationRequest.Builder addDeviceFilter(@androidx.annotation.Nullable android.companion.DeviceFilter<?> deviceFilter) { throw new RuntimeException("Stub!"); }

/**
 * @inheritDoc
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.companion.AssociationRequest build() { throw new RuntimeException("Stub!"); }
}

}

