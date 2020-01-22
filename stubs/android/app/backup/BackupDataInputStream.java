/*
 * Copyright (C) 2009 The Android Open Source Project
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


package android.app.backup;

import java.io.InputStream;

/**
 * Provides an {@link java.io.InputStream}-like interface for accessing an
 * entity's data during a restore operation. Used by {@link android.app.backup.BackupHelper BackupHelper} classes within the {@link android.app.backup.BackupAgentHelper BackupAgentHelper} mechanism.
 * <p>
 * When {@link android.app.backup.BackupHelper#restoreEntity(android.app.backup.BackupDataInputStream) BackupHelper#restoreEntity(BackupDataInputStream)}
 * is called, the current entity's header has already been read from the underlying
 * {@link android.app.backup.BackupDataInput BackupDataInput}.  The entity's key string and total data size are available
 * through this class's {@link #getKey()} and {@link #size()} methods, respectively.
 * <p class="note">
 * <strong>Note:</strong> The caller should take care not to seek or close the underlying data
 * source, nor read more than {@link #size()} bytes from the stream.</p>
 *
 * @see android.app.backup.BackupAgentHelper
 * @see android.app.backup.BackupHelper
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class BackupDataInputStream extends java.io.InputStream {

BackupDataInputStream() { throw new RuntimeException("Stub!"); }

/**
 * Read one byte of entity data from the stream, returning it as
 * an integer value.  If more than {@link #size()} bytes of data
 * are read from the stream, the output of this method is undefined.
 *
 * @return The byte read, or undefined if the end of the stream has been reached.
 * @apiSince 8
 */

public int read() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Read up to {@code size} bytes of data into a byte array, beginning at position
 * {@code offset} within the array.
 *
 * @param b Byte array into which the data will be read
 * @param offset The data will be stored in {@code b} beginning at this index
 *   within the array.
 * @param size The number of bytes to read in this operation.  If insufficient
 *   data exists within the entity to fulfill this request, only as much data
 *   will be read as is available.
 * @return The number of bytes of data read, or zero if all of the entity's
 *   data has already been read.
 * @apiSince 8
 */

public int read(byte[] b, int offset, int size) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Read enough entity data into a byte array to fill the array.
 *
 * @param b Byte array to fill with data from the stream.  If the stream does not
 *   have sufficient data to fill the array, then the contents of the remainder of
 *   the array will be undefined.
 * @return The number of bytes of data read, or zero if all of the entity's
 *   data has already been read.
 * @apiSince 8
 */

public int read(byte[] b) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Report the key string associated with this entity within the backup data set.
 *
 * @return The key string for this entity, equivalent to calling
 *   {@link android.app.backup.BackupDataInput#getKey() BackupDataInput#getKey()} on the underlying {@link android.app.backup.BackupDataInput BackupDataInput}.
 * @apiSince 8
 */

public java.lang.String getKey() { throw new RuntimeException("Stub!"); }

/**
 * Report the total number of bytes of data available for the current entity.
 *
 * @return The number of data bytes available, equivalent to calling
 *   {@link android.app.backup.BackupDataInput#getDataSize() BackupDataInput#getDataSize()} on the underlying {@link android.app.backup.BackupDataInput BackupDataInput}.
 * @apiSince 8
 */

public int size() { throw new RuntimeException("Stub!"); }
}

