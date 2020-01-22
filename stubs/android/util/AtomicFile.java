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


package android.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;

/**
 * Helper class for performing atomic operations on a file by creating a
 * backup file until a write has successfully completed.  If you need this
 * on older versions of the platform you can use
 * {@link android.support.v4.util.AtomicFile} in the v4 support library.
 * <p>
 * Atomic file guarantees file integrity by ensuring that a file has
 * been completely written and sync'd to disk before removing its backup.
 * As long as the backup file exists, the original file is considered
 * to be invalid (left over from a previous attempt to write the file).
 * </p><p>
 * Atomic file does not confer any file locking semantics.
 * Do not use this class when the file may be accessed or modified concurrently
 * by multiple threads or processes.  The caller is responsible for ensuring
 * appropriate mutual exclusion invariants whenever it accesses the file.
 * </p>
 * @apiSince 17
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AtomicFile {

/**
 * Create a new AtomicFile for a file located at the given File path.
 * The secondary backup file will be the same file path with ".bak" appended.
 * @apiSince 17
 */

public AtomicFile(java.io.File baseName) { throw new RuntimeException("Stub!"); }

/**
 * Return the path to the base file.  You should not generally use this,
 * as the data at that path may not be valid.
 * @apiSince 17
 */

public java.io.File getBaseFile() { throw new RuntimeException("Stub!"); }

/**
 * Delete the atomic file.  This deletes both the base and backup files.
 * @apiSince 17
 */

public void delete() { throw new RuntimeException("Stub!"); }

/**
 * Start a new write operation on the file.  This returns a FileOutputStream
 * to which you can write the new file data.  The existing file is replaced
 * with the new data.  You <em>must not</em> directly close the given
 * FileOutputStream; instead call either {@link #finishWrite(java.io.FileOutputStream)}
 * or {@link #failWrite(java.io.FileOutputStream)}.
 *
 * <p>Note that if another thread is currently performing
 * a write, this will simply replace whatever that thread is writing
 * with the new file being written by this thread, and when the other
 * thread finishes the write the new write operation will no longer be
 * safe (or will be lost).  You must do your own threading protection for
 * access to AtomicFile.
 * @apiSince 17
 */

public java.io.FileOutputStream startWrite() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Call when you have successfully finished writing to the stream
 * returned by {@link #startWrite()}.  This will close, sync, and
 * commit the new data.  The next attempt to read the atomic file
 * will return the new file stream.
 * @apiSince 17
 */

public void finishWrite(java.io.FileOutputStream str) { throw new RuntimeException("Stub!"); }

/**
 * Call when you have failed for some reason at writing to the stream
 * returned by {@link #startWrite()}.  This will close the current
 * write stream, and roll back to the previous state of the file.
 * @apiSince 17
 */

public void failWrite(java.io.FileOutputStream str) { throw new RuntimeException("Stub!"); }

/**
 * Open the atomic file for reading.  If there previously was an
 * incomplete write, this will roll back to the last good data before
 * opening for read.  You should call close() on the FileInputStream when
 * you are done reading from it.
 *
 * <p>Note that if another thread is currently performing
 * a write, this will incorrectly consider it to be in the state of a bad
 * write and roll back, causing the new data currently being written to
 * be dropped.  You must do your own threading protection for access to
 * AtomicFile.
 * @apiSince 17
 */

public java.io.FileInputStream openRead() throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * A convenience for {@link #openRead()} that also reads all of the
 * file contents into a byte array which is returned.
 * @apiSince 17
 */

public byte[] readFully() throws java.io.IOException { throw new RuntimeException("Stub!"); }
}

