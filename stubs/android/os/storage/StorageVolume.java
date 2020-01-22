/*
 * Copyright (C) 2011 The Android Open Source Project
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


package android.os.storage;

import android.os.Environment;
import android.content.Intent;
import android.content.Context;
import android.provider.DocumentsContract;
import android.os.Build;
import android.net.Uri;
import android.os.Parcelable;

/**
 * Information about a shared/external storage volume for a specific user.
 *
 * <p>
 * A device always has one (and one only) primary storage volume, but it could have extra volumes,
 * like SD cards and USB drives. This object represents the logical view of a storage
 * volume for a specific user: different users might have different views for the same physical
 * volume (for example, if the volume is a built-in emulated storage).
 *
 * <p>
 * The storage volume is not necessarily mounted, applications should use {@link #getState()} to
 * verify its state.
 *
 * <p>
 * Applications willing to read or write to this storage volume needs to get a permission from the
 * user first, which can be achieved in the following ways:
 *
 * <ul>
 * <li>To get access to standard directories (like the {@link android.os.Environment#DIRECTORY_PICTURES Environment#DIRECTORY_PICTURES}), they
 * can use the {@link #createAccessIntent(java.lang.String)}. This is the recommend way, since it provides a
 * simpler API and narrows the access to the given directory (and its descendants).
 * <li>To get access to any directory (and its descendants), they can use the Storage Acess
 * Framework APIs (such as {@link android.content.Intent#ACTION_OPEN_DOCUMENT Intent#ACTION_OPEN_DOCUMENT} and
 * {@link android.content.Intent#ACTION_OPEN_DOCUMENT_TREE Intent#ACTION_OPEN_DOCUMENT_TREE}, although these APIs do not guarantee the user will
 * select this specific volume.
 * <li>To get read and write access to the primary storage volume, applications can declare the
 * {@link android.Manifest.permission#READ_EXTERNAL_STORAGE} and
 * {@link android.Manifest.permission#WRITE_EXTERNAL_STORAGE} permissions respectively, with the
 * latter including the former. This approach is discouraged, since users may be hesitant to grant
 * broad access to all files contained on a storage device.
 * </ul>
 *
 * <p>It can be obtained through {@link android.os.storage.StorageManager#getStorageVolumes() StorageManager#getStorageVolumes()} and
 * {@link android.os.storage.StorageManager#getPrimaryStorageVolume() StorageManager#getPrimaryStorageVolume()} and also as an extra in some broadcasts
 * (see {@link #EXTRA_STORAGE_VOLUME}).
 *
 * <p>
 * See {@link android.os.Environment#getExternalStorageDirectory() Environment#getExternalStorageDirectory()} for more info about shared/external
 * storage semantics.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class StorageVolume implements android.os.Parcelable {

StorageVolume() { throw new RuntimeException("Stub!"); }

/**
 * Returns a user-visible description of the volume.
 *
 * @return the volume description
 * @apiSince 24
 */

public java.lang.String getDescription(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the volume is the primary shared/external storage, which is the volume
 * backed by {@link android.os.Environment#getExternalStorageDirectory() Environment#getExternalStorageDirectory()}.
 * @apiSince 24
 */

public boolean isPrimary() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the volume is removable.
 *
 * @return is removable
 * @apiSince 24
 */

public boolean isRemovable() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the volume is emulated.
 *
 * @return is removable
 * @apiSince 24
 */

public boolean isEmulated() { throw new RuntimeException("Stub!"); }

/**
 * Gets the volume UUID, if any.
 
 * @return This value may be {@code null}.
 * @apiSince 24
 */

@androidx.annotation.Nullable
public java.lang.String getUuid() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current state of the volume.
 *
 * @return one of {@link android.os.Environment#MEDIA_UNKNOWN Environment#MEDIA_UNKNOWN}, {@link android.os.Environment#MEDIA_REMOVED Environment#MEDIA_REMOVED},
 *         {@link android.os.Environment#MEDIA_UNMOUNTED Environment#MEDIA_UNMOUNTED}, {@link android.os.Environment#MEDIA_CHECKING Environment#MEDIA_CHECKING},
 *         {@link android.os.Environment#MEDIA_NOFS Environment#MEDIA_NOFS}, {@link android.os.Environment#MEDIA_MOUNTED Environment#MEDIA_MOUNTED},
 *         {@link android.os.Environment#MEDIA_MOUNTED_READ_ONLY Environment#MEDIA_MOUNTED_READ_ONLY}, {@link android.os.Environment#MEDIA_SHARED Environment#MEDIA_SHARED},
 *         {@link android.os.Environment#MEDIA_BAD_REMOVAL Environment#MEDIA_BAD_REMOVAL}, or {@link android.os.Environment#MEDIA_UNMOUNTABLE Environment#MEDIA_UNMOUNTABLE}.
 * @apiSince 24
 */

public java.lang.String getState() { throw new RuntimeException("Stub!"); }

/**
 * Builds an intent to give access to a standard storage directory or entire volume after
 * obtaining the user's approval.
 * <p>
 * When invoked, the system will ask the user to grant access to the requested directory (and
 * its descendants). The result of the request will be returned to the activity through the
 * {@code onActivityResult} method.
 * <p>
 * To gain access to descendants (child, grandchild, etc) documents, use
 * {@link android.provider.DocumentsContract#buildDocumentUriUsingTree(android.net.Uri,java.lang.String) DocumentsContract#buildDocumentUriUsingTree(Uri, String)}, or
 * {@link android.provider.DocumentsContract#buildChildDocumentsUriUsingTree(android.net.Uri,java.lang.String) DocumentsContract#buildChildDocumentsUriUsingTree(Uri, String)} with the returned URI.
 * <p>
 * If your application only needs to store internal data, consider using
 * {@link android.content.Context#getExternalFilesDirs(java.lang.String) Context#getExternalFilesDirs(String)},
 * {@link android.content.Context#getExternalCacheDirs() Context#getExternalCacheDirs()}, or {@link android.content.Context#getExternalMediaDirs() Context#getExternalMediaDirs()}, which
 * require no permissions to read or write.
 * <p>
 * Access to the entire volume is only available for non-primary volumes (for the primary
 * volume, apps can use the {@link android.Manifest.permission#READ_EXTERNAL_STORAGE} and
 * {@link android.Manifest.permission#WRITE_EXTERNAL_STORAGE} permissions) and should be used
 * with caution, since users are more likely to deny access when asked for entire volume access
 * rather than specific directories.
 *
 * @param directoryName must be one of {@link android.os.Environment#DIRECTORY_MUSIC Environment#DIRECTORY_MUSIC},
 *            {@link android.os.Environment#DIRECTORY_PODCASTS Environment#DIRECTORY_PODCASTS}, {@link android.os.Environment#DIRECTORY_RINGTONES Environment#DIRECTORY_RINGTONES},
 *            {@link android.os.Environment#DIRECTORY_ALARMS Environment#DIRECTORY_ALARMS}, {@link android.os.Environment#DIRECTORY_NOTIFICATIONS Environment#DIRECTORY_NOTIFICATIONS},
 *            {@link android.os.Environment#DIRECTORY_PICTURES Environment#DIRECTORY_PICTURES}, {@link android.os.Environment#DIRECTORY_MOVIES Environment#DIRECTORY_MOVIES},
 *            {@link android.os.Environment#DIRECTORY_DOWNLOADS Environment#DIRECTORY_DOWNLOADS}, {@link android.os.Environment#DIRECTORY_DCIM Environment#DIRECTORY_DCIM}, or
 *            {@link android.os.Environment#DIRECTORY_DOCUMENTS Environment#DIRECTORY_DOCUMENTS}, or {@code null} to request access to the
 *            entire volume.
 * @return intent to request access, or {@code null} if the requested directory is invalid for
 *         that volume.
 * @see android.provider.DocumentsContract
 * @deprecated Callers should migrate to using {@link android.content.Intent#ACTION_OPEN_DOCUMENT_TREE Intent#ACTION_OPEN_DOCUMENT_TREE} instead.
 *             Launching this {@link android.content.Intent Intent} on devices running
 *             {@link android.os.Build.VERSION_CODES#Q} or higher, will immediately finish
 *             with a result code of {@link android.app.Activity#RESULT_CANCELED}.
 * @apiSince 24
 * @deprecatedSince 29
 */

@Deprecated
@androidx.annotation.Nullable
public android.content.Intent createAccessIntent(java.lang.String directoryName) { throw new RuntimeException("Stub!"); }

/**
 * Builds an {@link android.content.Intent#ACTION_OPEN_DOCUMENT_TREE Intent#ACTION_OPEN_DOCUMENT_TREE} to allow the user to grant access to any
 * directory subtree (or entire volume) from the {@link android.provider.DocumentsProvider}s
 * available on the device. The initial location of the document navigation will be the root of
 * this {@link android.os.storage.StorageVolume StorageVolume}.
 *
 * Note that the returned {@link android.content.Intent Intent} simply suggests that the user picks this {@link android.os.storage.StorageVolume StorageVolume} by default, but the user may select a different location. Callers must respect
 * the user's chosen location, even if it is different from the originally requested location.
 *
 * @return intent to {@link android.content.Intent#ACTION_OPEN_DOCUMENT_TREE Intent#ACTION_OPEN_DOCUMENT_TREE} initially showing the contents
 *         of this {@link android.os.storage.StorageVolume StorageVolume}
 * This value will never be {@code null}.
 * @see android.content.Intent#ACTION_OPEN_DOCUMENT_TREE
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.content.Intent createOpenDocumentTreeIntent() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.os.storage.StorageVolume> CREATOR;
static { CREATOR = null; }

/**
 * Name of the {@link android.os.Parcelable Parcelable} extra in the {@link android.content.Intent#ACTION_MEDIA_REMOVED Intent#ACTION_MEDIA_REMOVED},
 * {@link android.content.Intent#ACTION_MEDIA_UNMOUNTED Intent#ACTION_MEDIA_UNMOUNTED}, {@link android.content.Intent#ACTION_MEDIA_CHECKING Intent#ACTION_MEDIA_CHECKING},
 * {@link android.content.Intent#ACTION_MEDIA_NOFS Intent#ACTION_MEDIA_NOFS}, {@link android.content.Intent#ACTION_MEDIA_MOUNTED Intent#ACTION_MEDIA_MOUNTED},
 * {@link android.content.Intent#ACTION_MEDIA_SHARED Intent#ACTION_MEDIA_SHARED}, {@link android.content.Intent#ACTION_MEDIA_BAD_REMOVAL Intent#ACTION_MEDIA_BAD_REMOVAL},
 * {@link android.content.Intent#ACTION_MEDIA_UNMOUNTABLE Intent#ACTION_MEDIA_UNMOUNTABLE}, and {@link android.content.Intent#ACTION_MEDIA_EJECT Intent#ACTION_MEDIA_EJECT} broadcast that
 * contains a {@link android.os.storage.StorageVolume StorageVolume}.
 * @apiSince 24
 */

public static final java.lang.String EXTRA_STORAGE_VOLUME = "android.os.storage.extra.STORAGE_VOLUME";
}

