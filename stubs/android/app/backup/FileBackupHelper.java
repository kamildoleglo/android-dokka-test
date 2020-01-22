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

import android.content.Context;
import android.os.ParcelFileDescriptor;

/**
 * A helper class that can be used in conjunction with
 * {@link android.app.backup.BackupAgentHelper} to manage the backup of a set of
 * files. Whenever backup is performed, all files changed since the last backup
 * will be saved in their entirety. When backup first occurs,
 * every file in the list provided to {@link #FileBackupHelper} will be backed up.
 * <p>
 * During restore, if the helper encounters data for a file that was not
 * specified when the FileBackupHelper object was constructed, that data
 * will be ignored.
 * <p class="note"><strong>Note:</strong> This should be
 * used only with small configuration files, not large binary files.
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class FileBackupHelper implements android.app.backup.BackupHelper {

/**
 * Construct a helper to manage backup/restore of entire files within the
 * application's data directory hierarchy.
 *
 * @param context The backup agent's Context object
 * @param files A list of the files to be backed up or restored.
 * @apiSince 8
 */

public FileBackupHelper(android.content.Context context, java.lang.String... files) { throw new RuntimeException("Stub!"); }

/**
 * Based on <code>oldState</code>, determine which of the files from the
 * application's data directory need to be backed up, write them to the data
 * stream, and fill in <code>newState</code> with the state as it exists
 * now. When <code>oldState</code> is <code>null</code>, all the files will
 * be backed up.
 * <p>
 * This should only be called directly from within the {@link android.app.backup.BackupAgentHelper BackupAgentHelper}
 * implementation. See
 * {@link android.app.backup.BackupAgent#onBackup(ParcelFileDescriptor, BackupDataOutput, ParcelFileDescriptor)}
 * for a description of parameter meanings.
 * @apiSince 8
 */

public void performBackup(android.os.ParcelFileDescriptor oldState, android.app.backup.BackupDataOutput data, android.os.ParcelFileDescriptor newState) { throw new RuntimeException("Stub!"); }

/**
 * Restore one record [representing a single file] from the restore dataset.
 * <p>
 * This should only be called directly from within the {@link android.app.backup.BackupAgentHelper BackupAgentHelper}
 * implementation.
 * @apiSince 8
 */

public void restoreEntity(android.app.backup.BackupDataInputStream data) { throw new RuntimeException("Stub!"); }

public void writeNewStateDescription(android.os.ParcelFileDescriptor fd) { throw new RuntimeException("Stub!"); }
}

