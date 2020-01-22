
package android.app.backup;


/**
 * Provides the interface through which a {@link android.app.backup.BackupAgent BackupAgent} writes entire files
 * to a full backup data set, via its {@link android.app.backup.BackupAgent#onFullBackup(android.app.backup.FullBackupDataOutput) BackupAgent#onFullBackup(FullBackupDataOutput)}
 * method.
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class FullBackupDataOutput {

FullBackupDataOutput() { throw new RuntimeException("Stub!"); }

/**
 * Returns the quota in bytes for the application's current backup operation.  The
 * value can vary for each operation.
 *
 * @see android.app.backup.BackupDataOutput#getQuota()
 * @apiSince 26
 */

public long getQuota() { throw new RuntimeException("Stub!"); }

/**
 * Returns flags with additional information about the backup transport. For supported flags see
 * {@link android.app.backup.BackupAgent}
 *
 * @see android.app.backup.BackupDataOutput#getTransportFlags()
 * @apiSince 28
 */

public int getTransportFlags() { throw new RuntimeException("Stub!"); }
}

