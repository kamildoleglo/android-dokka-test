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
import android.os.UserHandle;

/**
 * The interface through which an application interacts with the Android backup service to
 * request backup and restore operations.
 * Applications instantiate it using the constructor and issue calls through that instance.
 * <p>
 * When an application has made changes to data which should be backed up, a
 * call to {@link #dataChanged()} will notify the backup service. The system
 * will then schedule a backup operation to occur in the near future. Repeated
 * calls to {@link #dataChanged()} have no further effect until the backup
 * operation actually occurs.
 * <p>
 * A backup or restore operation for your application begins when the system launches the
 * {@link android.app.backup.BackupAgent} subclass you've declared in your manifest. See the
 * documentation for {@link android.app.backup.BackupAgent} for a detailed description
 * of how the operation then proceeds.
 * <p>
 * Several attributes affecting the operation of the backup and restore mechanism
 * can be set on the <code>
 * <a href="{@docRoot}guide/topics/manifest/application-element.html">&lt;application&gt;</a></code>
 * tag in your application's AndroidManifest.xml file.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about using BackupManager, read the
 * <a href="{@docRoot}guide/topics/data/backup.html">Data Backup</a> developer guide.</p></div>
 *
 * @attr ref android.R.styleable#AndroidManifestApplication_allowBackup
 * @attr ref android.R.styleable#AndroidManifestApplication_backupAgent
 * @attr ref android.R.styleable#AndroidManifestApplication_killAfterRestore
 * @attr ref android.R.styleable#AndroidManifestApplication_restoreAnyVersion
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class BackupManager {

/**
 * Constructs a BackupManager object through which the application can
 * communicate with the Android backup system.
 *
 * @param context The {@link android.content.Context} that was provided when
 *                one of your application's {@link android.app.Activity Activities}
 *                was created.
 * @apiSince 8
 */

public BackupManager(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Notifies the Android backup system that your application wishes to back up
 * new changes to its data.  A backup operation using your application's
 * {@link android.app.backup.BackupAgent} subclass will be scheduled when you
 * call this method.
 * @apiSince 8
 */

public void dataChanged() { throw new RuntimeException("Stub!"); }

/**
 * Convenience method for callers who need to indicate that some other package
 * needs a backup pass.  This can be useful in the case of groups of packages
 * that share a uid.
 * <p>
 * This method requires that the application hold the "android.permission.BACKUP"
 * permission if the package named in the argument does not run under the same uid
 * as the caller.
 *
 * @param packageName The package name identifying the application to back up.
 * @apiSince 8
 */

public static void dataChanged(java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Applications shouldn't request a restore operation using this method. In Android
 * P and later, this method is a no-op.
 *
 * <p>Restore the calling application from backup. The data will be restored from the
 * current backup dataset if the application has stored data there, or from
 * the dataset used during the last full device setup operation if the current
 * backup dataset has no matching data.  If no backup data exists for this application
 * in either source, a non-zero value is returned.
 *
 * <p>If this method returns zero (meaning success), the OS attempts to retrieve a backed-up
 * dataset from the remote transport, instantiate the application's backup agent, and pass the
 * dataset to the agent's
 * {@link android.app.backup.BackupAgent#onRestore(BackupDataInput, int, android.os.ParcelFileDescriptor) onRestore()}
 * method.
 *
 * <p class="caution">Unlike other restore operations, this method doesn't terminate the
 * application after the restore. The application continues running to receive the
 * {@link android.app.backup.RestoreObserver RestoreObserver} callbacks on the {@code observer} argument. Full backups use an
 * {@link android.app.Application Application} base class while key-value backups use the
 * application subclass declared in the AndroidManifest.xml {@code <application>} tag.
 *
 * @param observer The {@link android.app.backup.RestoreObserver RestoreObserver} to receive callbacks during the restore
 * operation. This must not be null.
 *
 * @return Zero on success; nonzero on error.
 * @apiSince 8
 * @deprecatedSince 28
 */

@Deprecated
public int requestRestore(android.app.backup.RestoreObserver observer) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link android.os.UserHandle UserHandle} for the user that has {@code ancestralSerialNumber} as the
 * serial number of the its ancestral work profile or {@code null} if there is none.
 *
 * <p> The ancestral serial number will have a corresponding {@link android.os.UserHandle UserHandle} if the device
 * has a work profile that was restored from another work profile with serial number
 * {@code ancestralSerialNumber}.
 *
 * @see UserManager#getSerialNumberForUser(UserHandle)
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.os.UserHandle getUserForAncestralSerialNumber(long ancestralSerialNumber) { throw new RuntimeException("Stub!"); }
}

