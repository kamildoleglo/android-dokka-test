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


package android.os;

import android.system.ErrnoException;
import android.system.OsConstants;
import java.nio.ByteBuffer;
import java.io.FileDescriptor;

/**
 * SharedMemory enables the creation, mapping, and protection control over anonymous shared memory.
 * @apiSince 27
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SharedMemory implements android.os.Parcelable, java.io.Closeable {

private SharedMemory() { throw new RuntimeException("Stub!"); }

/**
 * Creates an anonymous SharedMemory instance with the provided debug name and size. The name
 * is only used for debugging purposes and can help identify what the shared memory is used
 * for when inspecting memory maps for the processes that have mapped this SharedMemory
 * instance.
 *
 * @param name The debug name to use for this SharedMemory instance. This can be null, however
 *             a debug name is recommended to help identify memory usage when using tools
 *             such as lsof or examining /proc/[pid]/maps
 * This value may be {@code null}.
 * @param size The size of the shared memory to create. Must be greater than 0.
 * @return A SharedMemory instance of the requested size
 * @throws android.system.ErrnoException if the requested allocation fails.
 * @apiSince 27
 */

@androidx.annotation.NonNull
public static android.os.SharedMemory create(@androidx.annotation.Nullable java.lang.String name, int size) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * Sets the protection on the shared memory to the combination specified in prot, which
 * is either a bitwise-or'd combination of {@link android.system.OsConstants#PROT_READ},
 * {@link android.system.OsConstants#PROT_WRITE}, {@link android.system.OsConstants#PROT_EXEC}
 * from {@link android.system.OsConstants}, or {@link android.system.OsConstants#PROT_NONE},
 * to remove all further access.
 *
 * Note that protection can only ever be removed, not added. By default shared memory
 * is created with protection set to PROT_READ | PROT_WRITE | PROT_EXEC. The protection
 * passed here also only applies to any mappings created after calling this method. Existing
 * mmaps of the shared memory retain whatever protection they had when they were created.
 *
 * A common usage of this is to share a read-only copy of the data with something else. To do
 * that first create the read/write mapping with PROT_READ | PROT_WRITE,
 * then call setProtect(PROT_READ) to remove write capability, then send the SharedMemory
 * to another process. That process will only be able to mmap with PROT_READ.
 *
 * @param prot Any bitwise-or'ed combination of
 *                  {@link android.system.OsConstants#PROT_READ},
 *                  {@link android.system.OsConstants#PROT_WRITE}, and
 *                  {@link android.system.OsConstants#PROT_EXEC}; or
 *                  {@link android.system.OsConstants#PROT_NONE}
 * @return Whether or not the requested protection was applied. Returns true on success,
 * false if the requested protection was broader than the existing protection.
 * @apiSince 27
 */

public boolean setProtect(int prot) { throw new RuntimeException("Stub!"); }

/**
 * @return The size of the SharedMemory region.
 * @apiSince 27
 */

public int getSize() { throw new RuntimeException("Stub!"); }

/**
 * Creates a read/write mapping of the entire shared memory region. This requires the the
 * protection level of the shared memory is at least PROT_READ|PROT_WRITE or the map will fail.
 *
 * Use {@link #map(int,int,int)} to have more control over the mapping if desired.
 * This is equivalent to map(OsConstants.PROT_READ | OsConstants.PROT_WRITE, 0, getSize())
 *
 * @return A ByteBuffer mapping
 * This value will never be {@code null}.
 * @throws android.system.ErrnoException if the mmap call failed.
 * @apiSince 27
 */

@androidx.annotation.NonNull
public java.nio.ByteBuffer mapReadWrite() throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * Creates a read-only mapping of the entire shared memory region. This requires the the
 * protection level of the shared memory is at least PROT_READ or the map will fail.
 *
 * Use {@link #map(int,int,int)} to have more control over the mapping if desired.
 * This is equivalent to map(OsConstants.PROT_READ, 0, getSize())
 *
 * @return A ByteBuffer mapping
 * This value will never be {@code null}.
 * @throws android.system.ErrnoException if the mmap call failed.
 * @apiSince 27
 */

@androidx.annotation.NonNull
public java.nio.ByteBuffer mapReadOnly() throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * Creates an mmap of the SharedMemory with the specified prot, offset, and length. This will
 * always produce a new ByteBuffer window to the backing shared memory region. Every call
 * to map() may be paired with a call to {@link #unmap(java.nio.ByteBuffer)} when the ByteBuffer
 * returned by map() is no longer needed.
 *
 * @param prot A bitwise-or'd combination of PROT_READ, PROT_WRITE, PROT_EXEC, or PROT_NONE.
 * @param offset The offset into the shared memory to begin mapping. Must be >= 0 and less than
 *         getSize().
 * @param length The length of the region to map. Must be > 0 and offset + length must not
 *         exceed getSize().
 * @return A ByteBuffer mapping.
 * This value will never be {@code null}.
 * @throws android.system.ErrnoException if the mmap call failed.
 * @apiSince 27
 */

@androidx.annotation.NonNull
public java.nio.ByteBuffer map(int prot, int offset, int length) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * Unmaps a buffer previously returned by {@link #map(int,int,int)}. This will immediately
 * release the backing memory of the ByteBuffer, invalidating all references to it. Only
 * call this method if there are no duplicates of the ByteBuffer in use and don't
 * access the ByteBuffer after calling this method.
 *
 * @param buffer The buffer to unmap
 
 * This value must never be {@code null}.
 * @apiSince 27
 */

public static void unmap(@androidx.annotation.NonNull java.nio.ByteBuffer buffer) { throw new RuntimeException("Stub!"); }

/**
 * Close the backing {@link java.io.FileDescriptor FileDescriptor} of this SharedMemory instance. Note that all
 * open mappings of the shared memory will remain valid and may continue to be used. The
 * shared memory will not be freed until all file descriptor handles are closed and all
 * memory mappings are unmapped.
 * @apiSince 27
 */

public void close() { throw new RuntimeException("Stub!"); }

/** @apiSince 27 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param dest This value must never be {@code null}.
 * @apiSince 27
 */

public void writeToParcel(@androidx.annotation.NonNull android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 27 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.os.SharedMemory> CREATOR;
static { CREATOR = null; }
}

