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

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/**
 * Context associated with a {@link android.view.contentcapture.ContentCaptureSession ContentCaptureSession} - see {@link android.view.contentcapture.ContentCaptureManager ContentCaptureManager} for
 * more info.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ContentCaptureContext implements android.os.Parcelable {

ContentCaptureContext() { throw new RuntimeException("Stub!"); }

/**
 * Gets the (optional) extras set by the app (through {@link android.view.contentcapture.ContentCaptureContext.Builder#setExtras(android.os.Bundle) Builder#setExtras(Bundle)}).
 *
 * <p>It can be used to provide vendor-specific data that can be modified and examined.
 
 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * Gets the context id.
 
 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.content.LocusId getLocusId() { throw new RuntimeException("Stub!"); }

/**
 * Helper that creates a {@link android.view.contentcapture.ContentCaptureContext ContentCaptureContext} associated with the given {@code id}.
 
 * @param id This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public static android.view.contentcapture.ContentCaptureContext forLocusId(@androidx.annotation.NonNull java.lang.String id) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.contentcapture.ContentCaptureContext> CREATOR;
static { CREATOR = null; }
/**
 * Builder for {@link android.view.contentcapture.ContentCaptureContext ContentCaptureContext} objects.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Creates a new builder.
 *
 * <p>The context must have an id, which is usually one of the following:
 *
 * <ul>
 *   <li>A URL representing a web page (or {@code IFRAME}) that's being rendered by the
 *   activity (See {@link android.view.View#setContentCaptureSession(android.view.contentcapture.ContentCaptureSession) View#setContentCaptureSession(ContentCaptureSession)} for an
 *   example).
 *   <li>A unique identifier of the application state (for example, a conversation between
 *   2 users in a chat app).
 * </ul>
 *
 * <p>See {@link android.view.contentcapture.ContentCaptureManager ContentCaptureManager} for more info about the content capture context.
 *
 * @param id id associated with this context.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public Builder(@androidx.annotation.NonNull android.content.LocusId id) { throw new RuntimeException("Stub!"); }

/**
 * Sets extra options associated with this context.
 *
 * <p>It can be used to provide vendor-specific data that can be modified and examined.
 *
 * @param extras extra options.
 * This value must never be {@code null}.
 * @return this builder.
 *
 * This value will never be {@code null}.
 * @throws java.lang.IllegalStateException if {@link #build()} was already called.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.contentcapture.ContentCaptureContext.Builder setExtras(@androidx.annotation.NonNull android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Builds the {@link android.view.contentcapture.ContentCaptureContext ContentCaptureContext}.
 *
 * @throws java.lang.IllegalStateException if {@link #build()} was already called.
 *
 * @return the built {@code ContentCaptureContext}
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.view.contentcapture.ContentCaptureContext build() { throw new RuntimeException("Stub!"); }
}

}

