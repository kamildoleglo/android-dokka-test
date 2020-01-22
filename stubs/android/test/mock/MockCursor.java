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


package android.test.mock;

import android.database.Cursor;

/**
 * A mock {@link android.database.Cursor} class that isolates the test code from real
 * Cursor implementation.
 *
 * <p>
 * All methods including ones related to querying the state of the cursor are
 * are non-functional and throw {@link java.lang.UnsupportedOperationException}.
 *
 * @deprecated Use a mocking framework like <a href="https://github.com/mockito/mockito">Mockito</a>.
 * New tests should be written using the
 * <a href="{@docRoot}tools/testing-support-library/index.html">Android Testing Support Library</a>.
 * @apiSince 8
 * @deprecatedSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class MockCursor implements android.database.Cursor {

@Deprecated
public MockCursor() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public int getColumnCount() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public int getColumnIndex(java.lang.String columnName) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public int getColumnIndexOrThrow(java.lang.String columnName) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public java.lang.String getColumnName(int columnIndex) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public java.lang.String[] getColumnNames() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public int getCount() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public boolean isNull(int columnIndex) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public int getInt(int columnIndex) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public long getLong(int columnIndex) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public short getShort(int columnIndex) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public float getFloat(int columnIndex) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public double getDouble(int columnIndex) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public byte[] getBlob(int columnIndex) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public java.lang.String getString(int columnIndex) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 23
 * @deprecatedSince 24
 */

@Deprecated
public void setExtras(android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public int getPosition() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public boolean isAfterLast() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public boolean isBeforeFirst() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public boolean isFirst() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public boolean isLast() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public boolean move(int offset) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public boolean moveToFirst() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public boolean moveToLast() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public boolean moveToNext() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public boolean moveToPrevious() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public boolean moveToPosition(int position) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public void copyStringToBuffer(int columnIndex, android.database.CharArrayBuffer buffer) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public void deactivate() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public void close() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public boolean isClosed() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public boolean requery() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public void registerContentObserver(android.database.ContentObserver observer) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public void registerDataSetObserver(android.database.DataSetObserver observer) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public android.os.Bundle respond(android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public boolean getWantsAllOnMoveCalls() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public void setNotificationUri(android.content.ContentResolver cr, android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 29
 * @deprecatedSince 24
 */

@Deprecated
public void setNotificationUris(android.content.ContentResolver cr, java.util.List<android.net.Uri> uris) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 19
 * @deprecatedSince 24
 */

@Deprecated
public android.net.Uri getNotificationUri() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 29
 * @deprecatedSince 24
 */

@Deprecated
public java.util.List<android.net.Uri> getNotificationUris() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public void unregisterContentObserver(android.database.ContentObserver observer) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 8
 * @deprecatedSince 24
 */

@Deprecated
public void unregisterDataSetObserver(android.database.DataSetObserver observer) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 11
 * @deprecatedSince 24
 */

@Deprecated
public int getType(int columnIndex) { throw new RuntimeException("Stub!"); }
}

