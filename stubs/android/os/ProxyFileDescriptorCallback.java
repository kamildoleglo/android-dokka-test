/*
 * Copyright (C) 2016 The Android Open Source Project
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

/**
 * Callback that handles file system requests from ProxyFileDescriptor.
 *
 * All callback methods except for onRelease should throw {@link android.system.ErrnoException}
 * with proper errno on errors. See
 * <a href="http://man7.org/linux/man-pages/man3/errno.3.html">errno(3)</a> and
 * {@link android.system.OsConstants}.
 *
 * Typical errnos are
 *
 * <ul>
 * <li>{@link android.system.OsConstants#EIO} for general I/O issues
 * <li>{@link android.system.OsConstants#ENOENT} when the file is not found
 * <li>{@link android.system.OsConstants#EBADF} if the file doesn't allow read/write operations
 *     based on how it was opened.  (For example, trying to write a file that was opened read-only.)
 * <li>{@link android.system.OsConstants#ENOSPC} if you cannot handle a write operation to
 *     space/quota limitations.
 * </ul>
 * @see android.os.storage.StorageManager#openProxyFileDescriptor(int, ProxyFileDescriptorCallback,
 *     Handler)
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class ProxyFileDescriptorCallback {

public ProxyFileDescriptorCallback() { throw new RuntimeException("Stub!"); }

/**
 * Returns size of bytes provided by the file descriptor.
 * @return Size of bytes.
 * @throws android.system.ErrnoException ErrnoException containing E constants in OsConstants.
 * @apiSince 26
 */

public long onGetSize() throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * Provides bytes read from file descriptor.
 * It needs to return exact requested size of bytes unless it reaches file end.
 * @param offset Offset in bytes from the file head specifying where to read bytes. If a seek
 *     operation is conducted on the file descriptor, then a read operation is requested, the
 *     offset refrects the proper position of requested bytes.
 * @param size Size for read bytes.
 * @param data Byte array to store read bytes.
 * @return Size of bytes returned by the function.
 * @throws android.system.ErrnoException ErrnoException containing E constants in OsConstants.
 * @apiSince 26
 */

public int onRead(long offset, int size, byte[] data) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * Handles bytes written to file descriptor.
 * @param offset Offset in bytes from the file head specifying where to write bytes. If a seek
 *     operation is conducted on the file descriptor, then a write operation is requested, the
 *     offset refrects the proper position of requested bytes.
 * @param size Size for write bytes.
 * @param data Byte array to be written to somewhere.
 * @return Size of bytes processed by the function.
 * @throws android.system.ErrnoException ErrnoException containing E constants in OsConstants.
 * @apiSince 26
 */

public int onWrite(long offset, int size, byte[] data) throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * Ensures all the written data are stored in permanent storage device.
 * For example, if it has data stored in on memory cache, it needs to flush data to storage
 * device.
 * @throws android.system.ErrnoException ErrnoException containing E constants in OsConstants.
 * @apiSince 26
 */

public void onFsync() throws android.system.ErrnoException { throw new RuntimeException("Stub!"); }

/**
 * Invoked after the file is closed.
 * @apiSince 26
 */

public abstract void onRelease();
}

