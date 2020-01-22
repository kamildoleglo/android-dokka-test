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


/**
 * A convenient {@link android.app.backup.BackupAgent BackupAgent} wrapper class that automatically manages
 * heterogeneous data sets within the backup data, each identified by a unique
 * key prefix.  When processing a backup or restore operation, the BackupAgentHelper
 * dispatches to one or more installed {@link android.app.backup.BackupHelper BackupHelper} objects, each
 * of which is responsible for a defined subset of the data being processed.
 * <p>
 * An application will typically extend this class in its own
 * backup agent. Then, within the agent's {@link android.app.backup.BackupAgent#onCreate() BackupAgent#onCreate()}
 * method, it will call {@link #addHelper(java.lang.String,android.app.backup.BackupHelper) addHelper()} one or more times to
 * install the handlers for each kind of data it wishes to manage within its backups.
 * <p>
 * The Android framework currently provides two predefined {@link android.app.backup.BackupHelper BackupHelper} classes:</p>
 * <ul><li>{@link android.app.backup.FileBackupHelper FileBackupHelper} - Manages the backup and restore of entire files
 * within an application's data directory hierarchy.</li>
 * <li>{@link android.app.backup.SharedPreferencesBackupHelper SharedPreferencesBackupHelper} - Manages the backup and restore of an
 * application's {@link android.content.SharedPreferences} data.</li></ul>
 * <p>
 * An application can also implement its own helper classes to work within the
 * {@link android.app.backup.BackupAgentHelper BackupAgentHelper} framework.  See the {@link android.app.backup.BackupHelper BackupHelper} interface
 * documentation for details.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about using BackupAgentHelper, read the
 * <a href="{@docRoot}guide/topics/data/backup.html">Data Backup</a> developer guide.</p>
 * </div>
 *
 * @see android.app.backup.BackupHelper
 * @see android.app.backup.FileBackupHelper
 * @see android.app.backup.SharedPreferencesBackupHelper
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class BackupAgentHelper extends android.app.backup.BackupAgent {

public BackupAgentHelper() { throw new RuntimeException("Stub!"); }

/**
 * Run the backup process on each of the configured handlers.
 * @apiSince 8
 */

public void onBackup(android.os.ParcelFileDescriptor oldState, android.app.backup.BackupDataOutput data, android.os.ParcelFileDescriptor newState) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Run the restore process on each of the configured handlers.
 * @apiSince 8
 */

public void onRestore(android.app.backup.BackupDataInput data, int appVersionCode, android.os.ParcelFileDescriptor newState) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Add a helper for a given data subset to the agent's configuration.  Each helper
 * must have a prefix string that is unique within this backup agent's set of
 * helpers.
 *
 * @param keyPrefix A string used to disambiguate the various helpers within this agent
 * @param helper A backup/restore helper object to be invoked during backup and restore
 *    operations.
 * @apiSince 8
 */

public void addHelper(java.lang.String keyPrefix, android.app.backup.BackupHelper helper) { throw new RuntimeException("Stub!"); }
}

