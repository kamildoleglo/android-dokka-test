/*
 * Copyright (C) 2010 The Android Open Source Project
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


package android.mtp;


/**
 * This class encapsulates information about a storage unit on an MTP device.
 * This corresponds to the StorageInfo Dataset described in
 * section 5.2.2 of the MTP specification.
 * @apiSince 12
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MtpStorageInfo {

private MtpStorageInfo() { throw new RuntimeException("Stub!"); }

/**
 * Returns the storage ID for the storage unit.
 * The storage ID uniquely identifies the storage unit on the MTP device.
 *
 * @return the storage ID
 * @apiSince 12
 */

public int getStorageId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum storage capacity for the storage unit in bytes
 *
 * @return the maximum capacity
 * @apiSince 12
 */

public long getMaxCapacity() { throw new RuntimeException("Stub!"); }

/**
 * Returns the amount of free space in the storage unit in bytes
 *
 * @return the amount of free space
 * @apiSince 12
 */

public long getFreeSpace() { throw new RuntimeException("Stub!"); }

/**
 * Returns the description string for the storage unit.
 * This is typically displayed to the user in the user interface on the
 * MTP host.
 *
 * @return the storage unit description
 
 * This value will never be {@code null}.
 * @apiSince 12
 */

@androidx.annotation.NonNull
public java.lang.String getDescription() { throw new RuntimeException("Stub!"); }

/**
 * Returns the volume identifier for the storage unit
 *
 * @return the storage volume identifier
 
 * This value will never be {@code null}.
 * @apiSince 12
 */

@androidx.annotation.NonNull
public java.lang.String getVolumeIdentifier() { throw new RuntimeException("Stub!"); }
}

