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
 * A base class for Cursors that store their data in {@link android.database.CursorWindow CursorWindow}s.
 * <p>
 * The cursor owns the cursor window it uses.  When the cursor is closed,
 * its window is also closed.  Likewise, when the window used by the cursor is
 * changed, its old window is closed.  This policy of strict ownership ensures
 * that cursor windows are not leaked.
 * </p><p>
 * Subclasses are responsible for filling the cursor window with data during
 * {@link #onMove(int,int)}, allocating a new cursor window if necessary.
 * During {@link #requery()}, the existing cursor window should be cleared and
 * filled with new data.
 * </p><p>
 * If the contents of the cursor change or become invalid, the old window must be closed
 * (because it is owned by the cursor) and set to null.
 * </p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class AbstractWindowedCursor extends android.database.AbstractCursor {

public AbstractWindowedCursor() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public byte[] getBlob(int columnIndex) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String getString(int columnIndex) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void copyStringToBuffer(int columnIndex, android.database.CharArrayBuffer buffer) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public short getShort(int columnIndex) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getInt(int columnIndex) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public long getLong(int columnIndex) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public float getFloat(int columnIndex) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public double getDouble(int columnIndex) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean isNull(int columnIndex) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #getType}
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public boolean isBlob(int columnIndex) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #getType}
 * @apiSince 5
 * @deprecatedSince 15
 */

@Deprecated
public boolean isString(int columnIndex) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #getType}
 * @apiSince 5
 * @deprecatedSince 15
 */

@Deprecated
public boolean isLong(int columnIndex) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #getType}
 * @apiSince 5
 * @deprecatedSince 15
 */

@Deprecated
public boolean isFloat(int columnIndex) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public int getType(int columnIndex) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void checkPosition() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.database.CursorWindow getWindow() { throw new RuntimeException("Stub!"); }

/**
 * Sets a new cursor window for the cursor to use.
 * <p>
 * The cursor takes ownership of the provided cursor window; the cursor window
 * will be closed when the cursor is closed or when the cursor adopts a new
 * cursor window.
 * </p><p>
 * If the cursor previously had a cursor window, then it is closed when the
 * new cursor window is assigned.
 * </p>
 *
 * @param window The new cursor window, typically a remote cursor window.
 * @apiSince 1
 */

public void setWindow(android.database.CursorWindow window) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the cursor has an associated cursor window.
 *
 * @return True if the cursor has an associated cursor window.
 * @apiSince 1
 */

public boolean hasWindow() { throw new RuntimeException("Stub!"); }

/**
 * The cursor window owned by this cursor.
 * @apiSince 1
 */

protected android.database.CursorWindow mWindow;
}

