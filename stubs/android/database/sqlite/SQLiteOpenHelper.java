/*
 * Copyright (C) 2007 The Android Open Source Project
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


package android.database.sqlite;

import android.database.DatabaseErrorHandler;

/**
 * A helper class to manage database creation and version management.
 *
 * <p>You create a subclass implementing {@link #onCreate}, {@link #onUpgrade} and
 * optionally {@link #onOpen}, and this class takes care of opening the database
 * if it exists, creating it if it does not, and upgrading it as necessary.
 * Transactions are used to make sure the database is always in a sensible state.
 *
 * <p>This class makes it easy for {@link android.content.ContentProvider}
 * implementations to defer opening and upgrading the database until first use,
 * to avoid blocking application startup with long-running database upgrades.
 *
 * <p>For an example, see the NotePadProvider class in the NotePad sample application,
 * in the <em>samples/</em> directory of the SDK.</p>
 *
 * <p class="note"><strong>Note:</strong> this class assumes
 * monotonically increasing version numbers for upgrades.</p>
 *
 * <p class="note"><strong>Note:</strong> the {@link java.lang.AutoCloseable AutoCloseable} interface was
 * first added in the {@link android.os.Build.VERSION_CODES#Q} release.</p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class SQLiteOpenHelper implements java.lang.AutoCloseable {

/**
 * Create a helper object to create, open, and/or manage a database.
 * This method always returns very quickly.  The database is not actually
 * created or opened until one of {@link #getWritableDatabase} or
 * {@link #getReadableDatabase} is called.
 *
 * @param context to use for locating paths to the the database
 * This value may be {@code null}.
 * @param name of the database file, or null for an in-memory database
 * This value may be {@code null}.
 * @param factory to use for creating cursor objects, or null for the default
 * This value may be {@code null}.
 * @param version number of the database (starting at 1); if the database is older,
 *     {@link #onUpgrade} will be used to upgrade the database; if the database is
 *     newer, {@link #onDowngrade} will be used to downgrade the database
 * @apiSince 1
 */

public SQLiteOpenHelper(@androidx.annotation.Nullable android.content.Context context, @androidx.annotation.Nullable java.lang.String name, @androidx.annotation.Nullable android.database.sqlite.SQLiteDatabase.CursorFactory factory, int version) { throw new RuntimeException("Stub!"); }

/**
 * Create a helper object to create, open, and/or manage a database.
 * The database is not actually created or opened until one of
 * {@link #getWritableDatabase} or {@link #getReadableDatabase} is called.
 *
 * <p>Accepts input param: a concrete instance of {@link android.database.DatabaseErrorHandler DatabaseErrorHandler} to be
 * used to handle corruption when sqlite reports database corruption.</p>
 *
 * @param context to use for locating paths to the the database
 * This value may be {@code null}.
 * @param name of the database file, or null for an in-memory database
 * This value may be {@code null}.
 * @param factory to use for creating cursor objects, or null for the default
 * This value may be {@code null}.
 * @param version number of the database (starting at 1); if the database is older,
 *     {@link #onUpgrade} will be used to upgrade the database; if the database is
 *     newer, {@link #onDowngrade} will be used to downgrade the database
 * @param errorHandler the {@link android.database.DatabaseErrorHandler DatabaseErrorHandler} to be used when sqlite reports database
 * corruption, or null to use the default error handler.
 
 * This value may be {@code null}.
 * @apiSince 11
 */

public SQLiteOpenHelper(@androidx.annotation.Nullable android.content.Context context, @androidx.annotation.Nullable java.lang.String name, @androidx.annotation.Nullable android.database.sqlite.SQLiteDatabase.CursorFactory factory, int version, @androidx.annotation.Nullable android.database.DatabaseErrorHandler errorHandler) { throw new RuntimeException("Stub!"); }

/**
 * Create a helper object to create, open, and/or manage a database.
 * This method always returns very quickly.  The database is not actually
 * created or opened until one of {@link #getWritableDatabase} or
 * {@link #getReadableDatabase} is called.
 *
 * @param context to use for locating paths to the the database
 * This value may be {@code null}.
 * @param name of the database file, or null for an in-memory database
 * This value may be {@code null}.
 * @param version number of the database (starting at 1); if the database is older,
 *     {@link #onUpgrade} will be used to upgrade the database; if the database is
 *     newer, {@link #onDowngrade} will be used to downgrade the database
 * @param openParams configuration parameters that are used for opening {@link android.database.sqlite.SQLiteDatabase SQLiteDatabase}.
 *        Please note that {@link android.database.sqlite.SQLiteDatabase#CREATE_IF_NECESSARY SQLiteDatabase#CREATE_IF_NECESSARY} flag will always be
 *        set when the helper opens the database
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public SQLiteOpenHelper(@androidx.annotation.Nullable android.content.Context context, @androidx.annotation.Nullable java.lang.String name, int version, @androidx.annotation.NonNull android.database.sqlite.SQLiteDatabase.OpenParams openParams) { throw new RuntimeException("Stub!"); }

/**
 * Return the name of the SQLite database being opened, as given to
 * the constructor.
 * @apiSince 14
 */

public java.lang.String getDatabaseName() { throw new RuntimeException("Stub!"); }

/**
 * Enables or disables the use of write-ahead logging for the database.
 *
 * Write-ahead logging cannot be used with read-only databases so the value of
 * this flag is ignored if the database is opened read-only.
 *
 * @param enabled True if write-ahead logging should be enabled, false if it
 * should be disabled.
 *
 * @see android.database.sqlite.SQLiteDatabase#enableWriteAheadLogging()
 * @apiSince 16
 */

public void setWriteAheadLoggingEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Configures <a href="https://sqlite.org/malloc.html#lookaside">lookaside memory allocator</a>
 *
 * <p>This method should be called from the constructor of the subclass,
 * before opening the database, since lookaside memory configuration can only be changed
 * when no connection is using it
 *
 * <p>SQLite default settings will be used, if this method isn't called.
 * Use {@code setLookasideConfig(0,0)} to disable lookaside
 *
 * <p><strong>Note:</strong> Provided slotSize/slotCount configuration is just a recommendation.
 * The system may choose different values depending on a device, e.g. lookaside allocations
 * can be disabled on low-RAM devices
 *
 * @param slotSize The size in bytes of each lookaside slot.
 * Value is 0 or greater
 * @param slotCount The total number of lookaside memory slots per database connection.
 
 * Value is 0 or greater
 * @apiSince 27
 */

public void setLookasideConfig(int slotSize, int slotCount) { throw new RuntimeException("Stub!"); }

/**
 * Sets configuration parameters that are used for opening {@link android.database.sqlite.SQLiteDatabase SQLiteDatabase}.
 * <p>Please note that {@link android.database.sqlite.SQLiteDatabase#CREATE_IF_NECESSARY SQLiteDatabase#CREATE_IF_NECESSARY} flag will always be set when
 * opening the database
 *
 * @param openParams configuration parameters that are used for opening {@link android.database.sqlite.SQLiteDatabase SQLiteDatabase}.
 * This value must never be {@code null}.
 * @throws java.lang.IllegalStateException if the database is already open
 * @apiSince 28
 */

public void setOpenParams(@androidx.annotation.NonNull android.database.sqlite.SQLiteDatabase.OpenParams openParams) { throw new RuntimeException("Stub!"); }

/**
 * Sets the maximum number of milliseconds that SQLite connection is allowed to be idle
 * before it is closed and removed from the pool.
 *
 * <p>This method should be called from the constructor of the subclass,
 * before opening the database
 *
 * <p><b>DO NOT USE</b> this method.
 * This feature has negative side effects that are very hard to foresee.
 * See the javadoc of
 * {@link android.database.sqlite.SQLiteDatabase.OpenParams.Builder#setIdleConnectionTimeout(long) SQLiteDatabase.OpenParams.Builder#setIdleConnectionTimeout(long)}
 * for the details.
 *
 * @param idleConnectionTimeoutMs timeout in milliseconds. Use {@link java.lang.Long#MAX_VALUE Long#MAX_VALUE} value
 * to allow unlimited idle connections.
 *
 * Value is 0 or greater
 * @see android.database.sqlite.SQLiteDatabase.OpenParams.Builder#setIdleConnectionTimeout(long)
 *
 * @deprecated DO NOT USE this method. See the javadoc of
 * {@link android.database.sqlite.SQLiteDatabase.OpenParams.Builder#setIdleConnectionTimeout(long) SQLiteDatabase.OpenParams.Builder#setIdleConnectionTimeout(long)}
 * for the details.
 * @apiSince 27
 * @deprecatedSince 29
 */

@Deprecated
public void setIdleConnectionTimeout(long idleConnectionTimeoutMs) { throw new RuntimeException("Stub!"); }

/**
 * Create and/or open a database that will be used for reading and writing.
 * The first time this is called, the database will be opened and
 * {@link #onCreate}, {@link #onUpgrade} and/or {@link #onOpen} will be
 * called.
 *
 * <p>Once opened successfully, the database is cached, so you can
 * call this method every time you need to write to the database.
 * (Make sure to call {@link #close} when you no longer need the database.)
 * Errors such as bad permissions or a full disk may cause this method
 * to fail, but future attempts may succeed if the problem is fixed.</p>
 *
 * <p class="caution">Database upgrade may take a long time, you
 * should not call this method from the application main thread, including
 * from {@link android.content.ContentProvider#onCreate ContentProvider.onCreate()}.
 *
 * @throws android.database.sqlite.SQLiteException if the database cannot be opened for writing
 * @return a read/write database object valid until {@link #close} is called
 * @apiSince 1
 */

public android.database.sqlite.SQLiteDatabase getWritableDatabase() { throw new RuntimeException("Stub!"); }

/**
 * Create and/or open a database.  This will be the same object returned by
 * {@link #getWritableDatabase} unless some problem, such as a full disk,
 * requires the database to be opened read-only.  In that case, a read-only
 * database object will be returned.  If the problem is fixed, a future call
 * to {@link #getWritableDatabase} may succeed, in which case the read-only
 * database object will be closed and the read/write object will be returned
 * in the future.
 *
 * <p class="caution">Like {@link #getWritableDatabase}, this method may
 * take a long time to return, so you should not call it from the
 * application main thread, including from
 * {@link android.content.ContentProvider#onCreate ContentProvider.onCreate()}.
 *
 * @throws android.database.sqlite.SQLiteException if the database cannot be opened
 * @return a database object valid until {@link #getWritableDatabase}
 *     or {@link #close} is called.
 * @apiSince 1
 */

public android.database.sqlite.SQLiteDatabase getReadableDatabase() { throw new RuntimeException("Stub!"); }

/**
 * Close any open database object.
 * @apiSince 1
 */

public synchronized void close() { throw new RuntimeException("Stub!"); }

/**
 * Called when the database connection is being configured, to enable features such as
 * write-ahead logging or foreign key support.
 * <p>
 * This method is called before {@link #onCreate}, {@link #onUpgrade}, {@link #onDowngrade}, or
 * {@link #onOpen} are called. It should not modify the database except to configure the
 * database connection as required.
 * </p>
 * <p>
 * This method should only call methods that configure the parameters of the database
 * connection, such as {@link android.database.sqlite.SQLiteDatabase#enableWriteAheadLogging SQLiteDatabase#enableWriteAheadLogging}
 * {@link android.database.sqlite.SQLiteDatabase#setForeignKeyConstraintsEnabled SQLiteDatabase#setForeignKeyConstraintsEnabled}, {@link android.database.sqlite.SQLiteDatabase#setLocale SQLiteDatabase#setLocale},
 * {@link android.database.sqlite.SQLiteDatabase#setMaximumSize SQLiteDatabase#setMaximumSize}, or executing PRAGMA statements.
 * </p>
 *
 * @param db The database.
 * @apiSince 16
 */

public void onConfigure(android.database.sqlite.SQLiteDatabase db) { throw new RuntimeException("Stub!"); }

/**
 * Called when the database is created for the first time. This is where the
 * creation of tables and the initial population of the tables should happen.
 *
 * @param db The database.
 * @apiSince 1
 */

public abstract void onCreate(android.database.sqlite.SQLiteDatabase db);

/**
 * Called when the database needs to be upgraded. The implementation
 * should use this method to drop tables, add tables, or do anything else it
 * needs to upgrade to the new schema version.
 *
 * <p>
 * The SQLite ALTER TABLE documentation can be found
 * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
 * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
 * you can use ALTER TABLE to rename the old table, then create the new table and then
 * populate the new table with the contents of the old table.
 * </p><p>
 * This method executes within a transaction.  If an exception is thrown, all changes
 * will automatically be rolled back.
 * </p>
 *
 * @param db The database.
 * @param oldVersion The old database version.
 * @param newVersion The new database version.
 * @apiSince 1
 */

public abstract void onUpgrade(android.database.sqlite.SQLiteDatabase db, int oldVersion, int newVersion);

/**
 * Called when the database needs to be downgraded. This is strictly similar to
 * {@link #onUpgrade} method, but is called whenever current version is newer than requested one.
 * However, this method is not abstract, so it is not mandatory for a customer to
 * implement it. If not overridden, default implementation will reject downgrade and
 * throws SQLiteException
 *
 * <p>
 * This method executes within a transaction.  If an exception is thrown, all changes
 * will automatically be rolled back.
 * </p>
 *
 * @param db The database.
 * @param oldVersion The old database version.
 * @param newVersion The new database version.
 * @apiSince 11
 */

public void onDowngrade(android.database.sqlite.SQLiteDatabase db, int oldVersion, int newVersion) { throw new RuntimeException("Stub!"); }

/**
 * Called when the database has been opened.  The implementation
 * should check {@link android.database.sqlite.SQLiteDatabase#isReadOnly SQLiteDatabase#isReadOnly} before updating the
 * database.
 * <p>
 * This method is called after the database connection has been configured
 * and after the database schema has been created, upgraded or downgraded as necessary.
 * If the database connection must be configured in some way before the schema
 * is created, upgraded, or downgraded, do it in {@link #onConfigure} instead.
 * </p>
 *
 * @param db The database.
 * @apiSince 1
 */

public void onOpen(android.database.sqlite.SQLiteDatabase db) { throw new RuntimeException("Stub!"); }
}

