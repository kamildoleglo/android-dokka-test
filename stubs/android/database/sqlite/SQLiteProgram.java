/*
 * Copyright (C) 2006 The Android Open Source Project
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


/**
 * A base class for compiled SQLite programs.
 * <p>
 * This class is not thread-safe.
 * </p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class SQLiteProgram extends android.database.sqlite.SQLiteClosable {

SQLiteProgram() { throw new RuntimeException("Stub!"); }

/**
 * Unimplemented.
 * @deprecated This method is deprecated and must not be used.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public final int getUniqueId() { throw new RuntimeException("Stub!"); }

/**
 * Bind a NULL value to this statement. The value remains bound until
 * {@link #clearBindings} is called.
 *
 * @param index The 1-based index to the parameter to bind null to
 * @apiSince 1
 */

public void bindNull(int index) { throw new RuntimeException("Stub!"); }

/**
 * Bind a long value to this statement. The value remains bound until
 * {@link #clearBindings} is called.
 *addToBindArgs
 * @param index The 1-based index to the parameter to bind
 * @param value The value to bind
 * @apiSince 1
 */

public void bindLong(int index, long value) { throw new RuntimeException("Stub!"); }

/**
 * Bind a double value to this statement. The value remains bound until
 * {@link #clearBindings} is called.
 *
 * @param index The 1-based index to the parameter to bind
 * @param value The value to bind
 * @apiSince 1
 */

public void bindDouble(int index, double value) { throw new RuntimeException("Stub!"); }

/**
 * Bind a String value to this statement. The value remains bound until
 * {@link #clearBindings} is called.
 *
 * @param index The 1-based index to the parameter to bind
 * @param value The value to bind, must not be null
 * @apiSince 1
 */

public void bindString(int index, java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Bind a byte array value to this statement. The value remains bound until
 * {@link #clearBindings} is called.
 *
 * @param index The 1-based index to the parameter to bind
 * @param value The value to bind, must not be null
 * @apiSince 1
 */

public void bindBlob(int index, byte[] value) { throw new RuntimeException("Stub!"); }

/**
 * Clears all existing bindings. Unset bindings are treated as NULL.
 * @apiSince 1
 */

public void clearBindings() { throw new RuntimeException("Stub!"); }

/**
 * Given an array of String bindArgs, this method binds all of them in one single call.
 *
 * @param bindArgs the String array of bind args, none of which must be null.
 * @apiSince 11
 */

public void bindAllArgsAsStrings(java.lang.String[] bindArgs) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onAllReferencesReleased() { throw new RuntimeException("Stub!"); }
}

