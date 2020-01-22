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
 * This is an abstract cursor class that handles a lot of the common code
 * that all cursors need to deal with and is provided for convenience reasons.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class AbstractCursor implements android.database.CrossProcessCursor {

/** @apiSince 1 */

public AbstractCursor() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public abstract int getCount();

/** @apiSince 1 */

public abstract java.lang.String[] getColumnNames();

/** @apiSince 1 */

public abstract java.lang.String getString(int column);

/** @apiSince 1 */

public abstract short getShort(int column);

/** @apiSince 1 */

public abstract int getInt(int column);

/** @apiSince 1 */

public abstract long getLong(int column);

/** @apiSince 1 */

public abstract float getFloat(int column);

/** @apiSince 1 */

public abstract double getDouble(int column);

/** @apiSince 1 */

public abstract boolean isNull(int column);

/** @apiSince 11 */

public int getType(int column) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public byte[] getBlob(int column) { throw new RuntimeException("Stub!"); }

/**
 * If the cursor is backed by a {@link android.database.CursorWindow CursorWindow}, returns a pre-filled
 * window with the contents of the cursor, otherwise null.
 *
 * @return The pre-filled window that backs this cursor, or null if none.
 * @apiSince 1
 */

public android.database.CursorWindow getWindow() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getColumnCount() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void deactivate() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean requery() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean isClosed() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * This function is called every time the cursor is successfully scrolled
 * to a new position, giving the subclass a chance to update any state it
 * may have. If it returns false the move function will also do so and the
 * cursor will scroll to the beforeFirst position.
 *
 * @param oldPosition the position that we're moving from
 * @param newPosition the position that we're moving to
 * @return true if the move is successful, false otherwise
 * @apiSince 1
 */

public boolean onMove(int oldPosition, int newPosition) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void copyStringToBuffer(int columnIndex, android.database.CharArrayBuffer buffer) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final int getPosition() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final boolean moveToPosition(int position) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void fillWindow(int position, android.database.CursorWindow window) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final boolean move(int offset) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final boolean moveToFirst() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final boolean moveToLast() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final boolean moveToNext() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final boolean moveToPrevious() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final boolean isFirst() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final boolean isLast() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final boolean isBeforeFirst() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final boolean isAfterLast() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getColumnIndex(java.lang.String columnName) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getColumnIndexOrThrow(java.lang.String columnName) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String getColumnName(int columnIndex) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void registerContentObserver(android.database.ContentObserver observer) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void unregisterContentObserver(android.database.ContentObserver observer) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void registerDataSetObserver(android.database.DataSetObserver observer) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void unregisterDataSetObserver(android.database.DataSetObserver observer) { throw new RuntimeException("Stub!"); }

/**
 * Subclasses must call this method when they finish committing updates to notify all
 * observers.
 *
 * @param selfChange
 * @apiSince 1
 */

protected void onChange(boolean selfChange) { throw new RuntimeException("Stub!"); }

/**
 * Specifies a content URI to watch for changes.
 *
 * @param cr The content resolver from the caller's context.
 * @param notifyUri The URI to watch for changes. This can be a
 * specific row URI, or a base URI for a whole class of content.
 * @apiSince 1
 */

public void setNotificationUri(android.content.ContentResolver cr, android.net.Uri notifyUri) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param cr This value must never be {@code null}.
 
 * @param notifyUris This value must never be {@code null}.
 * @apiSince 29
 */

public void setNotificationUris(@androidx.annotation.NonNull android.content.ContentResolver cr, @androidx.annotation.NonNull java.util.List<android.net.Uri> notifyUris) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public android.net.Uri getNotificationUri() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public java.util.List<android.net.Uri> getNotificationUris() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean getWantsAllOnMoveCalls() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void setExtras(android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.os.Bundle respond(android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Always returns false since Cursors do not support updating rows
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
protected boolean isFieldUpdated(int columnIndex) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Always returns null since Cursors do not support updating rows
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
protected java.lang.Object getUpdatedField(int columnIndex) { throw new RuntimeException("Stub!"); }

/**
 * This function throws CursorIndexOutOfBoundsException if
 * the cursor position is out of bounds. Subclass implementations of
 * the get functions should call this before attempting
 * to retrieve data.
 *
 * @throws android.database.CursorIndexOutOfBoundsException
 * @apiSince 1
 */

protected void checkPosition() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void finalize() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #isClosed()} instead.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated protected boolean mClosed;

/**
 * @deprecated Do not use.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated protected android.content.ContentResolver mContentResolver;

/**
 * @deprecated Use {@link #getPosition()} instead.
 * @apiSince 1
 * @deprecatedSince 23
 */

@Deprecated protected int mPos;
/**
 * Cursors use this class to track changes others make to their URI.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
protected static class SelfContentObserver extends android.database.ContentObserver {

/** @apiSince 1 */

public SelfContentObserver(android.database.AbstractCursor cursor) { super(null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean deliverSelfNotifications() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void onChange(boolean selfChange) { throw new RuntimeException("Stub!"); }
}

}

