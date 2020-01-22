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


package android.app.usage;

import android.os.storage.StorageManager;
import java.io.IOException;
import java.util.UUID;
import java.io.File;
import android.content.pm.PackageManager;
import android.content.pm.PackageInfo;
import android.content.pm.ApplicationInfo;
import android.os.UserHandle;

/**
 * Access to detailed storage statistics. This provides a summary of how apps,
 * users, and external/shared storage is utilizing disk space.
 * <p class="note">
 * Note: no permissions are required when calling these APIs for your own
 * package or UID. However, requesting details for any other package requires
 * the {@code android.Manifest.permission#PACKAGE_USAGE_STATS} permission, which
 * is a system-level permission that will not be granted to normal apps.
 * Declaring that permission expresses your intention to use this API and an end
 * user can then choose to grant this permission through the Settings
 * application.
 * </p>
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class StorageStatsManager {

StorageStatsManager() { throw new RuntimeException("Stub!"); }

/**
 * Return the total size of the underlying physical media that is hosting
 * this storage volume.
 * <p>
 * This value is best suited for visual display to end users, since it's
 * designed to reflect the total storage size advertised in a retail
 * environment.
 * <p>
 * Apps making logical decisions about disk space should always use
 * {@link java.io.File#getTotalSpace() File#getTotalSpace()} instead of this value.
 *
 * <br>
 * This method may take several seconds to complete, so it should
 * only be called from a worker thread.
 * <br>
 * Value is a non-negative number of bytes.
 * @param storageUuid the UUID of the storage volume you're interested in,
 *            such as {@link android.os.storage.StorageManager#UUID_DEFAULT StorageManager#UUID_DEFAULT}.
 * This value must never be {@code null}.
 * @throws java.io.IOException when the storage device isn't present.
 
 * @return Value is a non-negative number of bytes.
 * @apiSince 26
 */

public long getTotalBytes(@androidx.annotation.NonNull java.util.UUID storageUuid) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Return the free space on the requested storage volume.
 * <p>
 * This value is best suited for visual display to end users, since it's
 * designed to reflect both unused space <em>and</em> and cached space that
 * could be reclaimed by the system.
 * <p>
 * Apps making logical decisions about disk space should always use
 * {@link android.os.storage.StorageManager#getAllocatableBytes(java.util.UUID) StorageManager#getAllocatableBytes(UUID)} instead of this value.
 *
 * <br>
 * This method may take several seconds to complete, so it should
 * only be called from a worker thread.
 * <br>
 * Value is a non-negative number of bytes.
 * @param storageUuid the UUID of the storage volume you're interested in,
 *            such as {@link android.os.storage.StorageManager#UUID_DEFAULT StorageManager#UUID_DEFAULT}.
 * This value must never be {@code null}.
 * @throws java.io.IOException when the storage device isn't present.
 
 * @return Value is a non-negative number of bytes.
 * @apiSince 26
 */

public long getFreeBytes(@androidx.annotation.NonNull java.util.UUID storageUuid) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Return storage statistics for a specific package on the requested storage
 * volume.
 * <p class="note">
 * Note: no permissions are required when calling this API for your own
 * package. However, requesting details for any other package requires the
 * {@code android.Manifest.permission#PACKAGE_USAGE_STATS} permission, which
 * is a system-level permission that will not be granted to normal apps.
 * Declaring that permission expresses your intention to use this API and an
 * end user can then choose to grant this permission through the Settings
 * application.
 * </p>
 * <p class="note">
 * Note: if the requested package uses the {@code android:sharedUserId}
 * manifest feature, this call will be forced into a slower manual
 * calculation path. If possible, consider always using
 * {@link #queryStatsForUid(java.util.UUID,int)}, which is typically faster.
 * </p>
 *
 * <br>
 * This method may take several seconds to complete, so it should
 * only be called from a worker thread.
 * @param storageUuid the UUID of the storage volume you're interested in,
 *            such as {@link android.os.storage.StorageManager#UUID_DEFAULT StorageManager#UUID_DEFAULT}.
 * This value must never be {@code null}.
 * @param packageName the package name you're interested in.
 * This value must never be {@code null}.
 * @param user the user you're interested in.
 * This value must never be {@code null}.
 * @throws android.content.pm.PackageManager.NameNotFoundException when the requested package
 *             name isn't installed for the requested user.
 * @throws java.io.IOException when the storage device isn't present.
 * @see android.content.pm.ApplicationInfo#storageUuid
 * @see android.content.pm.PackageInfo#packageName
 
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.app.usage.StorageStats queryStatsForPackage(@androidx.annotation.NonNull java.util.UUID storageUuid, @androidx.annotation.NonNull java.lang.String packageName, @androidx.annotation.NonNull android.os.UserHandle user) throws java.io.IOException, android.content.pm.PackageManager.NameNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Return storage statistics for a specific UID on the requested storage
 * volume.
 * <p class="note">
 * Note: no permissions are required when calling this API for your own UID.
 * However, requesting details for any other UID requires the
 * {@code android.Manifest.permission#PACKAGE_USAGE_STATS} permission, which
 * is a system-level permission that will not be granted to normal apps.
 * Declaring that permission expresses your intention to use this API and an
 * end user can then choose to grant this permission through the Settings
 * application.
 * </p>
 *
 * <br>
 * This method may take several seconds to complete, so it should
 * only be called from a worker thread.
 * @param storageUuid the UUID of the storage volume you're interested in,
 *            such as {@link android.os.storage.StorageManager#UUID_DEFAULT StorageManager#UUID_DEFAULT}.
 * This value must never be {@code null}.
 * @param uid the UID you're interested in.
 * @throws java.io.IOException when the storage device isn't present.
 * @see android.content.pm.ApplicationInfo#storageUuid
 * @see android.content.pm.ApplicationInfo#uid
 
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.app.usage.StorageStats queryStatsForUid(@androidx.annotation.NonNull java.util.UUID storageUuid, int uid) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Return storage statistics for a specific {@link android.os.UserHandle UserHandle} on the
 * requested storage volume.
 * <p class="note">
 * Note: this API requires the
 * {@code android.Manifest.permission#PACKAGE_USAGE_STATS} permission, which
 * is a system-level permission that will not be granted to normal apps.
 * Declaring that permission expresses your intention to use this API and an
 * end user can then choose to grant this permission through the Settings
 * application.
 * </p>
 *
 * <br>
 * This method may take several seconds to complete, so it should
 * only be called from a worker thread.
 * @param storageUuid the UUID of the storage volume you're interested in,
 *            such as {@link android.os.storage.StorageManager#UUID_DEFAULT StorageManager#UUID_DEFAULT}.
 * This value must never be {@code null}.
 * @param user the user you're interested in.
 * This value must never be {@code null}.
 * @throws java.io.IOException when the storage device isn't present.
 * @see android.os.Process#myUserHandle()
 
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.app.usage.StorageStats queryStatsForUser(@androidx.annotation.NonNull java.util.UUID storageUuid, @androidx.annotation.NonNull android.os.UserHandle user) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Return shared/external storage statistics for a specific
 * {@link android.os.UserHandle UserHandle} on the requested storage volume.
 * <p class="note">
 * Note: this API requires the
 * {@code android.Manifest.permission#PACKAGE_USAGE_STATS} permission, which
 * is a system-level permission that will not be granted to normal apps.
 * Declaring that permission expresses your intention to use this API and an
 * end user can then choose to grant this permission through the Settings
 * application.
 * </p>
 *
 * <br>
 * This method may take several seconds to complete, so it should
 * only be called from a worker thread.
 * @param storageUuid the UUID of the storage volume you're interested in,
 *            such as {@link android.os.storage.StorageManager#UUID_DEFAULT StorageManager#UUID_DEFAULT}.
 * This value must never be {@code null}.
 * @throws java.io.IOException when the storage device isn't present.
 * @see android.os.Process#myUserHandle()
 
 * @param user This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.app.usage.ExternalStorageStats queryExternalStatsForUser(@androidx.annotation.NonNull java.util.UUID storageUuid, @androidx.annotation.NonNull android.os.UserHandle user) throws java.io.IOException { throw new RuntimeException("Stub!"); }
}

