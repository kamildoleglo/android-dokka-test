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

import android.os.ParcelFileDescriptor;
import java.io.IOException;

/**
 * Provides the structured interface through which a {@link android.app.backup.BackupAgent BackupAgent} commits
 * information to the backup data set, via its {@link android.app.backup.BackupAgent#onBackup(android.os.ParcelFileDescriptor,android.app.backup.BackupDataOutput,android.os.ParcelFileDescriptor) BackupAgent#onBackup(ParcelFileDescriptor,BackupDataOutput,ParcelFileDescriptor)} method.  Data written for backup is presented
 * as a set of "entities," key/value pairs in which each binary data record "value" is
 * named with a string "key."
 * <p>
 * To commit a data record to the backup transport, the agent's
 * {@link android.app.backup.BackupAgent#onBackup(android.os.ParcelFileDescriptor,android.app.backup.BackupDataOutput,android.os.ParcelFileDescriptor) BackupAgent#onBackup(ParcelFileDescriptor,BackupDataOutput,ParcelFileDescriptor)} method first writes an "entity header" that supplies the key string for the record
 * and the total size of the binary value for the record.  After the header has been
 * written, the agent then writes the binary entity value itself.  The entity value can
 * be written in multiple chunks if desired, as long as the total count of bytes written
 * matches what was supplied to {@link #writeEntityHeader(java.lang.String,int) writeEntityHeader()}.
 * <p>
 * Entity key strings are considered to be unique within a given application's backup
 * data set. If a backup agent writes a new entity under an existing key string, its value will
 * replace any previous value in the transport's remote data store.  You can remove a record
 * entirely from the remote data set by writing a new entity header using the
 * existing record's key, but supplying a negative <code>dataSize</code> parameter.
 * When you do so, the agent does not need to call {@link #writeEntityData(byte[],int)}.
 * <h3>Example</h3>
 * <p>
 * Here is an example illustrating a way to back up the value of a String variable
 * called <code>mStringToBackUp</code>:
 * <pre>
 * static final String MY_STRING_KEY = "storedstring";
 *
 * public void {@link android.app.backup.BackupAgent#onBackup(android.os.ParcelFileDescriptor,android.app.backup.BackupDataOutput,android.os.ParcelFileDescriptor) BackupAgent#onBackup(ParcelFileDescriptor, BackupDataOutput, ParcelFileDescriptor)}
 *         throws IOException {
 *     ...
 *     byte[] stringBytes = mStringToBackUp.getBytes();
 *     data.writeEntityHeader(MY_STRING_KEY, stringBytes.length);
 *     data.writeEntityData(stringBytes, stringBytes.length);
 *     ...
 * }</pre>
 *
 * @see android.app.backup.BackupAgent
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class BackupDataOutput {

BackupDataOutput() { throw new RuntimeException("Stub!"); }

/**
 * Returns the quota in bytes for the application's current backup operation.  The
 * value can vary for each operation.
 *
 * @see android.app.backup.FullBackupDataOutput#getQuota()
 * @apiSince 26
 */

public long getQuota() { throw new RuntimeException("Stub!"); }

/**
 * Returns flags with additional information about the backup transport. For supported flags see
 * {@link android.app.backup.BackupAgent}
 *
 * @see android.app.backup.FullBackupDataOutput#getTransportFlags()
 * @apiSince 28
 */

public int getTransportFlags() { throw new RuntimeException("Stub!"); }

/**
 * Mark the beginning of one record in the backup data stream. This must be called before
 * {@link #writeEntityData}.
 * @param key A string key that uniquely identifies the data record within the application.
 *    Keys whose first character is \uFF00 or higher are not valid.
 * @param dataSize The size in bytes of this record's data.  Passing a dataSize
 *    of -1 indicates that the record under this key should be deleted.
 * @return The number of bytes written to the backup stream
 * @throws java.io.IOException if the write failed
 * @apiSince 8
 */

public int writeEntityHeader(java.lang.String key, int dataSize) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Write a chunk of data under the current entity to the backup transport.
 * @param data A raw data buffer to send
 * @param size The number of bytes to be sent in this chunk
 * @return the number of bytes written
 * @throws java.io.IOException if the write failed
 * @apiSince 8
 */

public int writeEntityData(byte[] data, int size) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @hide */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }
}

