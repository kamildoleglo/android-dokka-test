/*
 * Copyright (C) 2008 The Android Open Source Project
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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * MemoryFile is a wrapper for {@link android.os.SharedMemory SharedMemory} which can optionally be set to purgeable.
 *
 * Applications should generally prefer to use {@link android.os.SharedMemory SharedMemory} which offers more flexible
 * access & control over the shared memory region than MemoryFile does.
 *
 * Purgeable files may have their contents reclaimed by the kernel
 * in low memory conditions (only if allowPurging is set to true).
 * After a file is purged, attempts to read or write the file will
 * cause an IOException to be thrown.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MemoryFile {

/**
 * Allocates a new ashmem region. The region is initially not purgable.
 *
 * @param name optional name for the file (can be null).
 * @param length of the memory file in bytes, must be positive.
 * @throws java.io.IOException if the memory file could not be created.
 * @apiSince 1
 */

public MemoryFile(java.lang.String name, int length) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Closes the memory file. If there are no other open references to the memory
 * file, it will be deleted.
 * @apiSince 1
 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * Returns the length of the memory file.
 *
 * @return file length.
 * @apiSince 1
 */

public int length() { throw new RuntimeException("Stub!"); }

/**
 * Is memory file purging enabled?
 *
 * @return true if the file may be purged.
 *
 * @deprecated Purgable is considered generally fragile and hard to use safely. Applications
 * are recommend to instead use {@link android.content.ComponentCallbacks2#onTrimMemory(int)}
 * to react to memory events and release shared memory regions as appropriate.
 * @apiSince 1
 * @deprecatedSince 27
 */

@Deprecated
public boolean isPurgingAllowed() { throw new RuntimeException("Stub!"); }

/**
 * Enables or disables purging of the memory file.
 *
 * @param allowPurging true if the operating system can purge the contents
 * of the file in low memory situations
 * @return previous value of allowPurging
 *
 * @deprecated Purgable is considered generally fragile and hard to use safely. Applications
 * are recommend to instead use {@link android.content.ComponentCallbacks2#onTrimMemory(int)}
 * to react to memory events and release shared memory regions as appropriate.
 * @apiSince 1
 * @deprecatedSince 27
 */

@Deprecated
public synchronized boolean allowPurging(boolean allowPurging) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Creates a new InputStream for reading from the memory file.
 *
 @return InputStream
 * @apiSince 1
 */

public java.io.InputStream getInputStream() { throw new RuntimeException("Stub!"); }

/**
 * Creates a new OutputStream for writing to the memory file.
 *
 @return OutputStream
 * @apiSince 1
 */

public java.io.OutputStream getOutputStream() { throw new RuntimeException("Stub!"); }

/**
 * Reads bytes from the memory file.
 * Will throw an IOException if the file has been purged.
 *
 * @param buffer byte array to read bytes into.
 * @param srcOffset offset into the memory file to read from.
 * @param destOffset offset into the byte array buffer to read into.
 * @param count number of bytes to read.
 * @return number of bytes read.
 * @throws java.io.IOException if the memory file has been purged or deactivated.
 * @apiSince 1
 */

public int readBytes(byte[] buffer, int srcOffset, int destOffset, int count) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Write bytes to the memory file.
 * Will throw an IOException if the file has been purged.
 *
 * @param buffer byte array to write bytes from.
 * @param srcOffset offset into the byte array buffer to write from.
 * @param destOffset offset  into the memory file to write to.
 * @param count number of bytes to write.
 * @throws java.io.IOException if the memory file has been purged or deactivated.
 * @apiSince 1
 */

public void writeBytes(byte[] buffer, int srcOffset, int destOffset, int count) throws java.io.IOException { throw new RuntimeException("Stub!"); }
}

