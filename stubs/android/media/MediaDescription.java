/*
 * Copyright 2019 The Android Open Source Project
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


package android.media;

import android.net.Uri;
import android.media.browse.MediaBrowser;
import android.graphics.Bitmap;

/**
 * A simple set of metadata for a media item suitable for display. This can be
 * created using the Builder or retrieved from existing metadata using
 * {@link android.media.MediaMetadata#getDescription() MediaMetadata#getDescription()}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MediaDescription implements android.os.Parcelable {

private MediaDescription() { throw new RuntimeException("Stub!"); }

/**
 * Returns the media id or null. See
 * {@link android.media.MediaMetadata#METADATA_KEY_MEDIA_ID MediaMetadata#METADATA_KEY_MEDIA_ID}.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public java.lang.String getMediaId() { throw new RuntimeException("Stub!"); }

/**
 * Returns a title suitable for display or null.
 *
 * @return A title or null.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public java.lang.CharSequence getTitle() { throw new RuntimeException("Stub!"); }

/**
 * Returns a subtitle suitable for display or null.
 *
 * @return A subtitle or null.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public java.lang.CharSequence getSubtitle() { throw new RuntimeException("Stub!"); }

/**
 * Returns a description suitable for display or null.
 *
 * @return A description or null.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public java.lang.CharSequence getDescription() { throw new RuntimeException("Stub!"); }

/**
 * Returns a bitmap icon suitable for display or null.
 *
 * @return An icon or null.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public android.graphics.Bitmap getIconBitmap() { throw new RuntimeException("Stub!"); }

/**
 * Returns a Uri for an icon suitable for display or null.
 *
 * @return An icon uri or null.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public android.net.Uri getIconUri() { throw new RuntimeException("Stub!"); }

/**
 * Returns any extras that were added to the description.
 *
 * @return A bundle of extras or null.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * Returns a Uri representing this content or null.
 *
 * @return A media Uri or null.
 * @apiSince 23
 */

@androidx.annotation.Nullable
public android.net.Uri getMediaUri() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * The type of folder that contains folders categorized by album as specified in the section
 * 6.10.2.2 of the Bluetooth AVRCP 1.5.
 * @apiSince 26
 */

public static final long BT_FOLDER_TYPE_ALBUMS = 2L; // 0x2L

/**
 * The type of folder that contains folders categorized by artist as specified in the section
 * 6.10.2.2 of the Bluetooth AVRCP 1.5.
 * @apiSince 26
 */

public static final long BT_FOLDER_TYPE_ARTISTS = 3L; // 0x3L

/**
 * The type of folder that contains folders categorized by genre as specified in the section
 * 6.10.2.2 of the Bluetooth AVRCP 1.5.
 * @apiSince 26
 */

public static final long BT_FOLDER_TYPE_GENRES = 4L; // 0x4L

/**
 * The type of folder that is unknown or contains media elements of mixed types as specified in
 * the section 6.10.2.2 of the Bluetooth AVRCP 1.5.
 * @apiSince 26
 */

public static final long BT_FOLDER_TYPE_MIXED = 0L; // 0x0L

/**
 * The type of folder that contains folders categorized by playlist as specified in the section
 * 6.10.2.2 of the Bluetooth AVRCP 1.5.
 * @apiSince 26
 */

public static final long BT_FOLDER_TYPE_PLAYLISTS = 5L; // 0x5L

/**
 * The type of folder that contains media elements only as specified in the section 6.10.2.2 of
 * the Bluetooth AVRCP 1.5.
 * @apiSince 26
 */

public static final long BT_FOLDER_TYPE_TITLES = 1L; // 0x1L

/**
 * The type of folder that contains folders categorized by year as specified in the section
 * 6.10.2.2 of the Bluetooth AVRCP 1.5.
 * @apiSince 26
 */

public static final long BT_FOLDER_TYPE_YEARS = 6L; // 0x6L

/** @apiSince 21 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.media.MediaDescription> CREATOR;
static { CREATOR = null; }

/**
 * Used as a long extra field to indicate the bluetooth folder type of the media item as
 * specified in the section 6.10.2.2 of the Bluetooth AVRCP 1.5. This is valid only for
 * {@link android.media.browse.MediaBrowser.MediaItem MediaBrowser.MediaItem} with {@link android.media.browse.MediaBrowser.MediaItem#FLAG_BROWSABLE MediaBrowser.MediaItem#FLAG_BROWSABLE}. The value
 * should be one of the following:
 * <ul>
 * <li>{@link #BT_FOLDER_TYPE_MIXED}</li>
 * <li>{@link #BT_FOLDER_TYPE_TITLES}</li>
 * <li>{@link #BT_FOLDER_TYPE_ALBUMS}</li>
 * <li>{@link #BT_FOLDER_TYPE_ARTISTS}</li>
 * <li>{@link #BT_FOLDER_TYPE_GENRES}</li>
 * <li>{@link #BT_FOLDER_TYPE_PLAYLISTS}</li>
 * <li>{@link #BT_FOLDER_TYPE_YEARS}</li>
 * </ul>
 *
 * @see #getExtras()
 * @apiSince 26
 */

public static final java.lang.String EXTRA_BT_FOLDER_TYPE = "android.media.extra.BT_FOLDER_TYPE";
/**
 * Builder for {@link android.media.MediaDescription MediaDescription} objects.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

/**
 * Creates an initially empty builder.
 * @apiSince 21
 */

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Sets the media id.
 *
 * @param mediaId The unique id for the item or null.
 * This value may be {@code null}.
 * @return this
 * @apiSince 21
 */

public android.media.MediaDescription.Builder setMediaId(@androidx.annotation.Nullable java.lang.String mediaId) { throw new RuntimeException("Stub!"); }

/**
 * Sets the title.
 *
 * @param title A title suitable for display to the user or null.
 * This value may be {@code null}.
 * @return this
 * @apiSince 21
 */

public android.media.MediaDescription.Builder setTitle(@androidx.annotation.Nullable java.lang.CharSequence title) { throw new RuntimeException("Stub!"); }

/**
 * Sets the subtitle.
 *
 * @param subtitle A subtitle suitable for display to the user or null.
 * This value may be {@code null}.
 * @return this
 * @apiSince 21
 */

public android.media.MediaDescription.Builder setSubtitle(@androidx.annotation.Nullable java.lang.CharSequence subtitle) { throw new RuntimeException("Stub!"); }

/**
 * Sets the description.
 *
 * @param description A description suitable for display to the user or
 *            null.
 * This value may be {@code null}.
 * @return this
 * @apiSince 21
 */

public android.media.MediaDescription.Builder setDescription(@androidx.annotation.Nullable java.lang.CharSequence description) { throw new RuntimeException("Stub!"); }

/**
 * Sets the icon.
 *
 * @param icon A {@link android.graphics.Bitmap Bitmap} icon suitable for display to the user or
 *            null.
 * This value may be {@code null}.
 * @return this
 * @apiSince 21
 */

public android.media.MediaDescription.Builder setIconBitmap(@androidx.annotation.Nullable android.graphics.Bitmap icon) { throw new RuntimeException("Stub!"); }

/**
 * Sets the icon uri.
 *
 * @param iconUri A {@link android.net.Uri Uri} for an icon suitable for display to the
 *            user or null.
 * This value may be {@code null}.
 * @return this
 * @apiSince 21
 */

public android.media.MediaDescription.Builder setIconUri(@androidx.annotation.Nullable android.net.Uri iconUri) { throw new RuntimeException("Stub!"); }

/**
 * Sets a bundle of extras.
 *
 * @param extras The extras to include with this description or null.
 * This value may be {@code null}.
 * @return this
 * @apiSince 21
 */

public android.media.MediaDescription.Builder setExtras(@androidx.annotation.Nullable android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Sets the media uri.
 *
 * @param mediaUri The content's {@link android.net.Uri Uri} for the item or null.
 * This value may be {@code null}.
 * @return this
 * @apiSince 23
 */

public android.media.MediaDescription.Builder setMediaUri(@androidx.annotation.Nullable android.net.Uri mediaUri) { throw new RuntimeException("Stub!"); }

/**
 * Build {@link android.media.MediaDescription MediaDescription}.
 *
 * @return a new media description.
 * @apiSince 21
 */

public android.media.MediaDescription build() { throw new RuntimeException("Stub!"); }
}

}

