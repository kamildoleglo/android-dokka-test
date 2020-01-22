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


package android.database;


/**
 * Wrapper class for Cursor that delegates all calls to the actual cursor object.  The primary
 * use for this class is to extend a cursor while overriding only a subset of its methods.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CursorWrapper implements android.database.Cursor {

/**
 * Creates a cursor wrapper.
 * @param cursor The underlying cursor to wrap.
 * @apiSince 1
 */

public CursorWrapper(android.database.Cursor cursor) { throw new RuntimeException("Stub!"); }

/**
 * Gets the underlying cursor that is wrapped by this instance.
 *
 * @return The wrapped cursor.
 * @apiSince 11
 */

public android.database.Cursor getWrappedCursor() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void close() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean isClosed() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getCount() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@Deprecated
public void deactivate() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean moveToFirst() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getColumnCount() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getColumnIndex(java.lang.String columnName) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getColumnIndexOrThrow(java.lang.String columnName) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String getColumnName(int columnIndex) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String[] getColumnNames() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public double getDouble(int columnIndex) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void setExtras(android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public float getFloat(int columnIndex) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getInt(int columnIndex) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public long getLong(int columnIndex) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public short getShort(int columnIndex) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String getString(int columnIndex) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void copyStringToBuffer(int columnIndex, android.database.CharArrayBuffer buffer) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public byte[] getBlob(int columnIndex) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean getWantsAllOnMoveCalls() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean isAfterLast() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean isBeforeFirst() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean isFirst() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean isLast() { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public int getType(int columnIndex) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean isNull(int columnIndex) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean moveToLast() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean move(int offset) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean moveToPosition(int position) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean moveToNext() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getPosition() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean moveToPrevious() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void registerContentObserver(android.database.ContentObserver observer) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void registerDataSetObserver(android.database.DataSetObserver observer) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@Deprecated
public boolean requery() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.os.Bundle respond(android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setNotificationUri(android.content.ContentResolver cr, android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void setNotificationUris(android.content.ContentResolver cr, java.util.List<android.net.Uri> uris) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public android.net.Uri getNotificationUri() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public java.util.List<android.net.Uri> getNotificationUris() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void unregisterContentObserver(android.database.ContentObserver observer) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void unregisterDataSetObserver(android.database.DataSetObserver observer) { throw new RuntimeException("Stub!"); }
}

