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
import java.io.File;
import android.content.Context;
import java.io.IOException;

/**
 * Provides the central interface between an
 * application and Android's data backup infrastructure.  An application that wishes
 * to participate in the backup and restore mechanism will declare a subclass of
 * {@link android.app.backup.BackupAgent}, implement the
 * {@link #onBackup(android.os.ParcelFileDescriptor,android.app.backup.BackupDataOutput,android.os.ParcelFileDescriptor) onBackup()}
 * and {@link #onRestore(android.app.backup.BackupDataInput,int,android.os.ParcelFileDescriptor) onRestore()} methods,
 * and provide the name of its backup agent class in its {@code AndroidManifest.xml} file via
 * the <code>
 * <a href="{@docRoot}guide/topics/manifest/application-element.html">&lt;application&gt;</a></code>
 * tag's {@code android:backupAgent} attribute.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about using BackupAgent, read the
 * <a href="{@docRoot}guide/topics/data/backup.html">Data Backup</a> developer guide.</p></div>
 *
 * <h3>Basic Operation</h3>
 * <p>
 * When the application makes changes to data that it wishes to keep backed up,
 * it should call the
 * {@link android.app.backup.BackupManager#dataChanged() BackupManager.dataChanged()} method.
 * This notifies the Android Backup Manager that the application needs an opportunity
 * to update its backup image.  The Backup Manager, in turn, schedules a
 * backup pass to be performed at an opportune time.
 * <p>
 * Restore operations are typically performed only when applications are first
 * installed on a device.  At that time, the operating system checks to see whether
 * there is a previously-saved data set available for the application being installed, and if so,
 * begins an immediate restore pass to deliver the backup data as part of the installation
 * process.
 * <p>
 * When a backup or restore pass is run, the application's process is launched
 * (if not already running), the manifest-declared backup agent class (in the {@code
 * android:backupAgent} attribute) is instantiated within
 * that process, and the agent's {@link #onCreate()} method is invoked.  This prepares the
 * agent instance to run the actual backup or restore logic.  At this point the
 * agent's
 * {@link #onBackup(android.os.ParcelFileDescriptor,android.app.backup.BackupDataOutput,android.os.ParcelFileDescriptor) onBackup()} or
 * {@link #onRestore(android.app.backup.BackupDataInput,int,android.os.ParcelFileDescriptor) onRestore()} method will be
 * invoked as appropriate for the operation being performed.
 * <p>
 * A backup data set consists of one or more "entities," flattened binary data
 * records that are each identified with a key string unique within the data set.  Adding a
 * record to the active data set or updating an existing record is done by simply
 * writing new entity data under the desired key.  Deleting an entity from the data set
 * is done by writing an entity under that key with header specifying a negative data
 * size, and no actual entity data.
 * <p>
 * <b>Helper Classes</b>
 * <p>
 * An extensible agent based on convenient helper classes is available in
 * {@link android.app.backup.BackupAgentHelper}.  That class is particularly
 * suited to handling of simple file or {@link android.content.SharedPreferences}
 * backup and restore.
 * <p>
 * <b>Threading</b>
 * <p>
 * The constructor, as well as {@link #onCreate()} and {@link #onDestroy()} lifecycle callbacks run
 * on the main thread (UI thread) of the application that implements the BackupAgent.
 * The data-handling callbacks:
 * {@link #onBackup(android.os.ParcelFileDescriptor,android.app.backup.BackupDataOutput,android.os.ParcelFileDescriptor) onBackup()},
 * {@link #onFullBackup(android.app.backup.FullBackupDataOutput)},
 * {@link #onRestore(android.app.backup.BackupDataInput,int,android.os.ParcelFileDescriptor) onRestore()},
 * {@link #onRestoreFile(android.os.ParcelFileDescriptor,long,java.io.File,int,long,long) onRestoreFile()},
 * {@link #onRestoreFinished()}, and {@link #onQuotaExceeded(long,long) onQuotaExceeded()}
 * run on binder pool threads.
 *
 * @see android.app.backup.BackupManager
 * @see android.app.backup.BackupAgentHelper
 * @see android.app.backup.BackupDataInput
 * @see android.app.backup.BackupDataOutput
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class BackupAgent extends android.content.ContextWrapper {

/** @apiSince 8 */

public BackupAgent() { super(null); throw new RuntimeException("Stub!"); }

/**
 * Provided as a convenience for agent implementations that need an opportunity
 * to do one-time initialization before the actual backup or restore operation
 * is begun.
 * <p>
 * @apiSince 8
 */

public void onCreate() { throw new RuntimeException("Stub!"); }

/**
 * Provided as a convenience for agent implementations that need to do some
 * sort of shutdown process after backup or restore is completed.
 * <p>
 * Agents do not need to override this method.
 * @apiSince 8
 */

public void onDestroy() { throw new RuntimeException("Stub!"); }

/**
 * The application is being asked to write any data changed since the last
 * time it performed a backup operation. The state data recorded during the
 * last backup pass is provided in the <code>oldState</code> file
 * descriptor. If <code>oldState</code> is <code>null</code>, no old state
 * is available and the application should perform a full backup. In both
 * cases, a representation of the final backup state after this pass should
 * be written to the file pointed to by the file descriptor wrapped in
 * <code>newState</code>.
 * <p>
 * Each entity written to the {@link android.app.backup.BackupDataOutput}
 * <code>data</code> stream will be transmitted
 * over the current backup transport and stored in the remote data set under
 * the key supplied as part of the entity.  Writing an entity with a negative
 * data size instructs the transport to delete whatever entity currently exists
 * under that key from the remote data set.
 *
 * @param oldState An open, read-only ParcelFileDescriptor pointing to the
 *            last backup state provided by the application. May be
 *            <code>null</code>, in which case no prior state is being
 *            provided and the application should perform a full backup.
 * @param data A structured wrapper around an open, read/write
 *            file descriptor pointing to the backup data destination.
 *            Typically the application will use backup helper classes to
 *            write to this file.
 * @param newState An open, read/write ParcelFileDescriptor pointing to an
 *            empty file. The application should record the final backup
 *            state here after writing the requested data to the <code>data</code>
 *            output stream.
 * @apiSince 8
 */

public abstract void onBackup(android.os.ParcelFileDescriptor oldState, android.app.backup.BackupDataOutput data, android.os.ParcelFileDescriptor newState) throws java.io.IOException;

/**
 * The application is being restored from backup and should replace any
 * existing data with the contents of the backup. The backup data is
 * provided through the <code>data</code> parameter. Once
 * the restore is finished, the application should write a representation of
 * the final state to the <code>newState</code> file descriptor.
 * <p>
 * The application is responsible for properly erasing its old data and
 * replacing it with the data supplied to this method. No "clear user data"
 * operation will be performed automatically by the operating system. The
 * exception to this is in the case of a failed restore attempt: if
 * onRestore() throws an exception, the OS will assume that the
 * application's data may now be in an incoherent state, and will clear it
 * before proceeding.
 *
 * @param data A structured wrapper around an open, read-only
 *            file descriptor pointing to a full snapshot of the
 *            application's data.  The application should consume every
 *            entity represented in this data stream.
 * @param appVersionCode The value of the <a
 * href="{@docRoot}guide/topics/manifest/manifest-element.html#vcode">{@code
 *            android:versionCode}</a> manifest attribute,
 *            from the application that backed up this particular data set. This
 *            makes it possible for an application's agent to distinguish among any
 *            possible older data versions when asked to perform the restore
 *            operation.
 * @param newState An open, read/write ParcelFileDescriptor pointing to an
 *            empty file. The application should record the final backup
 *            state here after restoring its data from the <code>data</code> stream.
 *            When a full-backup dataset is being restored, this will be <code>null</code>.
 * @apiSince 8
 */

public abstract void onRestore(android.app.backup.BackupDataInput data, int appVersionCode, android.os.ParcelFileDescriptor newState) throws java.io.IOException;

/**
 * New version of {@link #onRestore(android.app.backup.BackupDataInput,int,android.os.ParcelFileDescriptor)}
 * that handles a long app version code.  Default implementation casts the version code to
 * an int and calls {@link #onRestore(android.app.backup.BackupDataInput,int,android.os.ParcelFileDescriptor)}.
 * @apiSince 28
 */

public void onRestore(android.app.backup.BackupDataInput data, long appVersionCode, android.os.ParcelFileDescriptor newState) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * The application is having its entire file system contents backed up.  {@code data}
 * points to the backup destination, and the app has the opportunity to choose which
 * files are to be stored.  To commit a file as part of the backup, call the
 * {@link #fullBackupFile(java.io.File,android.app.backup.FullBackupDataOutput)} helper method.  After all file
 * data is written to the output, the agent returns from this method and the backup
 * operation concludes.
 *
 * <p>Certain parts of the app's data are never backed up even if the app explicitly
 * sends them to the output:
 *
 * <ul>
 * <li>The contents of the {@link #getCacheDir()} directory</li>
 * <li>The contents of the {@link #getCodeCacheDir()} directory</li>
 * <li>The contents of the {@link #getNoBackupFilesDir()} directory</li>
 * <li>The contents of the app's shared library directory</li>
 * </ul>
 *
 * <p>The default implementation of this method backs up the entirety of the
 * application's "owned" file system trees to the output other than the few exceptions
 * listed above.  Apps only need to override this method if they need to impose special
 * limitations on which files are being stored beyond the control that
 * {@link #getNoBackupFilesDir()} offers.
 * Alternatively they can provide an xml resource to specify what data to include or exclude.
 *
 *
 * @param data A structured wrapper pointing to the backup destination.
 * @throws java.io.IOException
 *
 * @see android.content.Context#getNoBackupFilesDir()
 * @see #fullBackupFile(File, FullBackupDataOutput)
 * @see #onRestoreFile(ParcelFileDescriptor, long, File, int, long, long)
 * @apiSince 14
 */

public void onFullBackup(android.app.backup.FullBackupDataOutput data) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Notification that the application's current backup operation causes it to exceed
 * the maximum size permitted by the transport.  The ongoing backup operation is
 * halted and rolled back: any data that had been stored by a previous backup operation
 * is still intact.  Typically the quota-exceeded state will be detected before any data
 * is actually transmitted over the network.
 *
 * <p>The {@code quotaBytes} value is the total data size currently permitted for this
 * application.  If desired, the application can use this as a hint for determining
 * how much data to store.  For example, a messaging application might choose to
 * store only the newest messages, dropping enough older content to stay under
 * the quota.
 *
 * <p class="note">Note that the maximum quota for the application can change over
 * time.  In particular, in the future the quota may grow.  Applications that adapt
 * to the quota when deciding what data to store should be aware of this and implement
 * their data storage mechanisms in a way that can take advantage of additional
 * quota.
 *
 * @param backupDataBytes The amount of data measured while initializing the backup
 *    operation, if the total exceeds the app's alloted quota.  If initial measurement
 *    suggested that the data would fit but then too much data was actually submitted
 *    as part of the operation, then this value is the amount of data that had been
 *    streamed into the transport at the time the quota was reached.
 * @param quotaBytes The maximum data size that the transport currently permits
 *    this application to store as a backup.
 * @apiSince 24
 */

public void onQuotaExceeded(long backupDataBytes, long quotaBytes) { throw new RuntimeException("Stub!"); }

/**
 * Write an entire file as part of a full-backup operation.  The file's contents
 * will be delivered to the backup destination along with the metadata necessary
 * to place it with the proper location and permissions on the device where the
 * data is restored.
 *
 * <p class="note">Attempting to back up files in directories that are ignored by
 * the backup system will have no effect.  For example, if the app calls this method
 * with a file inside the {@link #getNoBackupFilesDir()} directory, it will be ignored.
 * See {@link #onFullBackup(android.app.backup.FullBackupDataOutput)} for details on what directories
 * are excluded from backups.
 *
 * @param file The file to be backed up.  The file must exist and be readable by
 *     the caller.
 * @param output The destination to which the backed-up file data will be sent.
 * @apiSince 14
 */

public final void fullBackupFile(java.io.File file, android.app.backup.FullBackupDataOutput output) { throw new RuntimeException("Stub!"); }

/**
 * Handle the data delivered via the given file descriptor during a full restore
 * operation.  The agent is given the path to the file's original location as well
 * as its size and metadata.
 * <p>
 * The file descriptor can only be read for {@code size} bytes; attempting to read
 * more data has undefined behavior.
 * <p>
 * The default implementation creates the destination file/directory and populates it
 * with the data from the file descriptor, then sets the file's access mode and
 * modification time to match the restore arguments.
 *
 * @param data A read-only file descriptor from which the agent can read {@code size}
 *     bytes of file data.
 * @param size The number of bytes of file content to be restored to the given
 *     destination.  If the file system object being restored is a directory, {@code size}
 *     will be zero.
 * @param destination The File on disk to be restored with the given data.
 * @param type The kind of file system object being restored.  This will be either
 *     {@link android.app.backup.BackupAgent#TYPE_FILE BackupAgent#TYPE_FILE} or {@link android.app.backup.BackupAgent#TYPE_DIRECTORY BackupAgent#TYPE_DIRECTORY}.
 * @param mode The access mode to be assigned to the destination after its data is
 *     written.  This is in the standard format used by {@code chmod()}.
 * @param mtime The modification time of the file when it was backed up, suitable to
 *     be assigned to the file after its data is written.
 * @throws java.io.IOException
 * @apiSince 14
 */

public void onRestoreFile(android.os.ParcelFileDescriptor data, long size, java.io.File destination, int type, long mode, long mtime) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * The application's restore operation has completed.  This method is called after
 * all available data has been delivered to the application for restore (via either
 * the {@link #onRestore(android.app.backup.BackupDataInput,int,android.os.ParcelFileDescriptor) onRestore()} or
 * {@link #onRestoreFile(android.os.ParcelFileDescriptor,long,java.io.File,int,long,long) onRestoreFile()}
 * callbacks).  This provides the app with a stable end-of-restore opportunity to
 * perform any appropriate post-processing on the data that was just delivered.
 *
 * @see #onRestore(BackupDataInput, int, ParcelFileDescriptor)
 * @see #onRestoreFile(ParcelFileDescriptor, long, File, int, long, long)
 * @apiSince 21
 */

public void onRestoreFinished() { throw new RuntimeException("Stub!"); }

/**
 * Flag for {@link android.app.backup.BackupDataOutput#getTransportFlags() BackupDataOutput#getTransportFlags()} and
 * {@link android.app.backup.FullBackupDataOutput#getTransportFlags() FullBackupDataOutput#getTransportFlags()} only.
 *
 * <p>The transport has client-side encryption enabled. i.e., the user's backup has been
 * encrypted with a key known only to the device, and not to the remote storage solution. Even
 * if an attacker had root access to the remote storage provider they should not be able to
 * decrypt the user's backup data.
 * @apiSince 28
 */

public static final int FLAG_CLIENT_SIDE_ENCRYPTION_ENABLED = 1; // 0x1

/**
 * Flag for {@link android.app.backup.BackupDataOutput#getTransportFlags() BackupDataOutput#getTransportFlags()} and
 * {@link android.app.backup.FullBackupDataOutput#getTransportFlags() FullBackupDataOutput#getTransportFlags()} only.
 *
 * <p>The transport is for a device-to-device transfer. There is no third party or intermediate
 * storage. The user's backup data is sent directly to another device over e.g., USB or WiFi.
 * @apiSince 28
 */

public static final int FLAG_DEVICE_TO_DEVICE_TRANSFER = 2; // 0x2

/**
 * During a full restore, indicates that the file system object being restored
 * is a directory.
 * @apiSince 14
 */

public static final int TYPE_DIRECTORY = 2; // 0x2

/**
 * During a full restore, indicates that the file system object being restored
 * is an ordinary file.
 * @apiSince 14
 */

public static final int TYPE_FILE = 1; // 0x1
}

