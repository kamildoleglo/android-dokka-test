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

package android.view.contentcapture;

import android.content.LocusId;

/**
 * Defines a condition for when content capture should be allowed.
 *
 * <p>See {@link android.view.contentcapture.ContentCaptureManager#getContentCaptureConditions() ContentCaptureManager#getContentCaptureConditions()} for more.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ContentCaptureCondition implements android.os.Parcelable {

/**
 * Default constructor.
 *
 * @param locusId id of the condition, as defined by
 * {@link android.view.contentcapture.ContentCaptureContext#getLocusId() ContentCaptureContext#getLocusId()}.
 * This value must never be {@code null}.
 * @param flags either {@link android.view.contentcapture.ContentCaptureCondition#FLAG_IS_REGEX ContentCaptureCondition#FLAG_IS_REGEX} (to use a regular
 * expression match) or {@code 0} (in which case the {@code LocusId} must be an exact match of
 * the {@code LocusId} used in the {@link android.view.contentcapture.ContentCaptureContext ContentCaptureContext}).
 
 * Value is either <code>0</code> or {@link android.view.contentcapture.ContentCaptureCondition#FLAG_IS_REGEX}
 * @apiSince 29
 */

public ContentCaptureCondition(@androidx.annotation.NonNull android.content.LocusId locusId, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@code LocusId} per se.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.content.LocusId getLocusId() { throw new RuntimeException("Stub!"); }

/**
 * Gets the flags associates with this condition.
 *
 * @return either {@link android.view.contentcapture.ContentCaptureCondition#FLAG_IS_REGEX ContentCaptureCondition#FLAG_IS_REGEX} or {@code 0}.
 
 * Value is either <code>0</code> or {@link android.view.contentcapture.ContentCaptureCondition#FLAG_IS_REGEX}
 * @apiSince 29
 */

public int getFlags() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param parcel This value must never be {@code null}.
 * @apiSince 29
 */

public void writeToParcel(@androidx.annotation.NonNull android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.contentcapture.ContentCaptureCondition> CREATOR;
static { CREATOR = null; }

/**
 * When set, package should use the {@link android.content.LocusId#getId() LocusId#getId()} as a regular expression (using the
 * {@link java.util.regex.Pattern} format).
 * @apiSince 29
 */

public static final int FLAG_IS_REGEX = 2; // 0x2
}

