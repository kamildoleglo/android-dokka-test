/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */


package android.view.inputmethod;

import android.content.ClipDescription;
import java.security.InvalidParameterException;
import android.os.Parcel;

/**
 * A container object with which input methods can send content files to the target application.
 * @apiSince 25
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class InputContentInfo implements android.os.Parcelable {

/**
 * Constructs {@link android.view.inputmethod.InputContentInfo InputContentInfo} object only with mandatory data.
 *
 * @param contentUri Content URI to be exported from the input method.
 * This cannot be {@code null}.
 * This value must never be {@code null}.
 * @param description A {@link android.content.ClipDescription ClipDescription} object that contains the metadata of
 * {@code contentUri} such as MIME type(s). This object cannot be {@code null}. Also
 * {@link android.content.ClipDescription#getLabel() ClipDescription#getLabel()} should be describing the content specified by
 * {@code contentUri} for accessibility reasons.
 
 * This value must never be {@code null}.
 * @apiSince 25
 */

public InputContentInfo(@androidx.annotation.NonNull android.net.Uri contentUri, @androidx.annotation.NonNull android.content.ClipDescription description) { throw new RuntimeException("Stub!"); }

/**
 * Constructs {@link android.view.inputmethod.InputContentInfo InputContentInfo} object with additional link URI.
 *
 * @param contentUri Content URI to be exported from the input method.
 * This cannot be {@code null}.
 * This value must never be {@code null}.
 * @param description A {@link android.content.ClipDescription ClipDescription} object that contains the metadata of
 * {@code contentUri} such as MIME type(s). This object cannot be {@code null}. Also
 * {@link android.content.ClipDescription#getLabel() ClipDescription#getLabel()} should be describing the content specified by
 * {@code contentUri} for accessibility reasons.
 * This value must never be {@code null}.
 * @param linkUri An optional {@code http} or {@code https} URI. The editor author may provide
 * a way to navigate the user to the specified web page if this is not {@code null}.
 * This value may be {@code null}.
 * @throws java.security.InvalidParameterException if any invalid parameter is specified.
 * @apiSince 25
 */

public InputContentInfo(@androidx.annotation.NonNull android.net.Uri contentUri, @androidx.annotation.NonNull android.content.ClipDescription description, @androidx.annotation.Nullable android.net.Uri linkUri) { throw new RuntimeException("Stub!"); }

/**
 * @return Content URI with which the content can be obtained.
 
 * This value will never be {@code null}.
 * @apiSince 25
 */

@androidx.annotation.NonNull
public android.net.Uri getContentUri() { throw new RuntimeException("Stub!"); }

/**
 * @return {@link android.content.ClipDescription ClipDescription} object that contains the metadata of {@code #getContentUri()}
 * such as MIME type(s). {@link android.content.ClipDescription#getLabel() ClipDescription#getLabel()} can be used for accessibility
 * purpose.
 
 * This value will never be {@code null}.
 * @apiSince 25
 */

@androidx.annotation.NonNull
public android.content.ClipDescription getDescription() { throw new RuntimeException("Stub!"); }

/**
 * @return An optional {@code http} or {@code https} URI that is related to this content.
 
 * This value may be {@code null}.
 * @apiSince 25
 */

@androidx.annotation.Nullable
public android.net.Uri getLinkUri() { throw new RuntimeException("Stub!"); }

/**
 * Requests a temporary read-only access permission for content URI associated with this object.
 *
 * <p>Does nothing if the temporary permission is already granted.</p>
 * @apiSince 25
 */

public void requestPermission() { throw new RuntimeException("Stub!"); }

/**
 * Releases a temporary read-only access permission for content URI associated with this object.
 *
 * <p>Does nothing if the temporary permission is not granted.</p>
 * @apiSince 25
 */

public void releasePermission() { throw new RuntimeException("Stub!"); }

/**
 * Used to package this object into a {@link android.os.Parcel Parcel}.
 *
 * @param dest The {@link android.os.Parcel Parcel} to be written.
 * @param flags The flags used for parceling.
 * @apiSince 25
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 25
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Used to make this class parcelable.
 * @apiSince 25
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.inputmethod.InputContentInfo> CREATOR;
static { CREATOR = null; }
}

