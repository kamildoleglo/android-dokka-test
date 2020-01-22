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


package android.test;


/**
 * This is a class which delegates to the given context, but performs database
 * and file operations with a renamed database/file name (prefixes default
 * names with a given prefix).
 *
 * @deprecated New tests should be written using the
 * <a href="{@docRoot}tools/testing-support-library/index.html">Android Testing Support Library</a>.
 * @apiSince 1
 * @deprecatedSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class RenamingDelegatingContext extends android.content.ContextWrapper {

/**
 * @param context : the context that will be delegated.
 * @param filePrefix : a prefix with which database and file names will be
 * prefixed.
 * @apiSince 1
 */

@Deprecated
public RenamingDelegatingContext(android.content.Context context, java.lang.String filePrefix) { super(null); throw new RuntimeException("Stub!"); }

/**
 * @param context : the context that will be delegated.
 * @param fileContext : the context that file and db methods will be delegated to
 * @param filePrefix : a prefix with which database and file names will be
 * prefixed.
 * @apiSince 1
 */

@Deprecated
public RenamingDelegatingContext(android.content.Context context, android.content.Context fileContext, java.lang.String filePrefix) { super(null); throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static <T extends android.content.ContentProvider> T providerWithRenamedContext(java.lang.Class<T> contentProvider, android.content.Context c, java.lang.String filePrefix) throws java.lang.IllegalAccessException, java.lang.InstantiationException { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static <T extends android.content.ContentProvider> T providerWithRenamedContext(java.lang.Class<T> contentProvider, android.content.Context c, java.lang.String filePrefix, boolean allowAccessToExistingFilesAndDbs) throws java.lang.IllegalAccessException, java.lang.InstantiationException { throw new RuntimeException("Stub!"); }

/**
 * Makes accessible all files and databases whose names match the filePrefix that was passed to
 * the constructor. Normally only files and databases that were created through this context are
 * accessible.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public void makeExistingFilesAndDbsAccessible() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public java.lang.String getDatabasePrefix() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public android.database.sqlite.SQLiteDatabase openOrCreateDatabase(java.lang.String name, int mode, android.database.sqlite.SQLiteDatabase.CursorFactory factory) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 11
 * @deprecatedSince 24
 */

@Deprecated
public android.database.sqlite.SQLiteDatabase openOrCreateDatabase(java.lang.String name, int mode, android.database.sqlite.SQLiteDatabase.CursorFactory factory, android.database.DatabaseErrorHandler errorHandler) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public boolean deleteDatabase(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public java.io.File getDatabasePath(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public java.lang.String[] databaseList() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public java.io.FileInputStream openFileInput(java.lang.String name) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public java.io.FileOutputStream openFileOutput(java.lang.String name, int mode) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public java.io.File getFileStreamPath(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public boolean deleteFile(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public java.lang.String[] fileList() { throw new RuntimeException("Stub!"); }

/**
 * In order to support calls to getCacheDir(), we create a temp cache dir (inside the real
 * one) and return it instead.  This code is basically getCacheDir(), except it uses the real
 * cache dir as the parent directory and creates a test cache dir inside that.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public java.io.File getCacheDir() { throw new RuntimeException("Stub!"); }
}

