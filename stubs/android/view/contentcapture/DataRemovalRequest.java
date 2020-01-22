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

package android.view.contentcapture;

import android.content.LocusId;

/**
 * Class used by apps to remove content capture data associated with {@link android.content.LocusId LocusId}.
 *
 * <p>An app which has tagged data with a LocusId can therefore delete them later. This is intended
 * to let apps propagate deletions of user data into the operating system.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class DataRemovalRequest implements android.os.Parcelable {

private DataRemovalRequest() { throw new RuntimeException("Stub!"); }

/**
 * Gets the name of the app that's making the request.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.lang.String getPackageName() { throw new RuntimeException("Stub!"); }

/**
 * Checks if app is requesting to remove content capture data associated with its package.
 * @apiSince 29
 */

public boolean isForEverything() { throw new RuntimeException("Stub!"); }

/**
 * Gets the list of {@code LousId}s the apps is requesting to remove.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.util.List<android.view.contentcapture.DataRemovalRequest.LocusIdRequest> getLocusIdRequests() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.contentcapture.DataRemovalRequest> CREATOR;
static { CREATOR = null; }

/**
 * When set, the {@link android.content.LocusId#getId() LocusId#getId()} is the prefix for the data to be removed.
 * @apiSince 29
 */

public static final int FLAG_IS_PREFIX = 1; // 0x1
/**
 * Builder for {@link android.view.contentcapture.DataRemovalRequest DataRemovalRequest} objects.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Requests to remove all content capture data associated with the app's package.
 *
 * @return this builder
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.contentcapture.DataRemovalRequest.Builder forEverything() { throw new RuntimeException("Stub!"); }

/**
 * Request service to remove data associated with a given {@link android.content.LocusId LocusId}.
 *
 * @param locusId the {@link android.content.LocusId LocusId} being requested to be removed.
 * This value must never be {@code null}.
 * @param flags either {@link android.view.contentcapture.DataRemovalRequest#FLAG_IS_PREFIX DataRemovalRequest#FLAG_IS_PREFIX} or {@code 0}
 *
 * Value is either <code>0</code> or {@link android.view.contentcapture.DataRemovalRequest#FLAG_IS_PREFIX}
 * @return this builder
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.contentcapture.DataRemovalRequest.Builder addLocusId(@androidx.annotation.NonNull android.content.LocusId locusId, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Builds the {@link android.view.contentcapture.DataRemovalRequest DataRemovalRequest}.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.contentcapture.DataRemovalRequest build() { throw new RuntimeException("Stub!"); }
}

/**
 * Representation of a request to remove data associated with a {@link android.content.LocusId LocusId}.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class LocusIdRequest {

private LocusIdRequest() { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@code LocusId} per se.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.content.LocusId getLocusId() { throw new RuntimeException("Stub!"); }

/**
 * Gets the flags associates with request.
 *
 * @return either {@link android.view.contentcapture.DataRemovalRequest#FLAG_IS_PREFIX DataRemovalRequest#FLAG_IS_PREFIX} or {@code 0}.
 
 * This value will never be {@code null}.
 
 * Value is either <code>0</code> or {@link android.view.contentcapture.DataRemovalRequest#FLAG_IS_PREFIX}
 * @apiSince 29
 */

@androidx.annotation.NonNull
public int getFlags() { throw new RuntimeException("Stub!"); }
}

}

