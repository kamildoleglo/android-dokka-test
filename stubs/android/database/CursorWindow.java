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

import android.os.Parcel;
import android.database.sqlite.SQLiteException;

/**
 * A buffer containing multiple cursor rows.
 * <p>
 * A {@link android.database.CursorWindow CursorWindow} is read-write when initially created and used locally.
 * When sent to a remote process (by writing it to a {@link android.os.Parcel Parcel}), the remote process
 * receives a read-only view of the cursor window.  Typically the cursor window
 * will be allocated by the producer, filled with data, and then sent to the
 * consumer for reading.
 * </p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CursorWindow extends android.database.sqlite.SQLiteClosable implements android.os.Parcelable {

/**
 * Creates a new empty cursor window and gives it a name.
 * <p>
 * The cursor initially has no rows or columns.  Call {@link #setNumColumns(int)} to
 * set the number of columns before adding any rows to the cursor.
 * </p>
 *
 * @param name The name of the cursor window, or null if none.
 * @apiSince 15
 */

public CursorWindow(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new empty cursor window and gives it a name.
 * <p>
 * The cursor initially has no rows or columns.  Call {@link #setNumColumns(int)} to
 * set the number of columns before adding any rows to the cursor.
 * </p>
 *
 * @param name The name of the cursor window, or null if none.
 * @param windowSizeBytes Size of cursor window in bytes.
 * <p><strong>Note:</strong> Memory is dynamically allocated as data rows are added to the
 * window. Depending on the amount of data stored, the actual amount of memory allocated can be
 * lower than specified size, but cannot exceed it.
 
 * Value is a non-negative number of bytes.
 * @apiSince 28
 */

public CursorWindow(java.lang.String name, long windowSizeBytes) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new empty cursor window.
 * <p>
 * The cursor initially has no rows or columns.  Call {@link #setNumColumns(int)} to
 * set the number of columns before adding any rows to the cursor.
 * </p>
 *
 * @param localWindow True if this window will be used in this process only,
 * false if it might be sent to another processes.  This argument is ignored.
 *
 * @deprecated There is no longer a distinction between local and remote
 * cursor windows.  Use the {@link #CursorWindow(java.lang.String)} constructor instead.
 * @apiSince 1
 */

@Deprecated
public CursorWindow(boolean localWindow) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Clears out the existing contents of the window, making it safe to reuse
 * for new data.
 * <p>
 * The start position ({@link #getStartPosition()}), number of rows ({@link #getNumRows()}),
 * and number of columns in the cursor are all reset to zero.
 * </p>
 * @apiSince 1
 */

public void clear() { throw new RuntimeException("Stub!"); }

/**
 * Gets the start position of this cursor window.
 * <p>
 * The start position is the zero-based index of the first row that this window contains
 * relative to the entire result set of the {@link android.database.Cursor Cursor}.
 * </p>
 *
 * @return The zero-based start position.
 * @apiSince 1
 */

public int getStartPosition() { throw new RuntimeException("Stub!"); }

/**
 * Sets the start position of this cursor window.
 * <p>
 * The start position is the zero-based index of the first row that this window contains
 * relative to the entire result set of the {@link android.database.Cursor Cursor}.
 * </p>
 *
 * @param pos The new zero-based start position.
 * @apiSince 1
 */

public void setStartPosition(int pos) { throw new RuntimeException("Stub!"); }

/**
 * Gets the number of rows in this window.
 *
 * @return The number of rows in this cursor window.
 * @apiSince 1
 */

public int getNumRows() { throw new RuntimeException("Stub!"); }

/**
 * Sets the number of columns in this window.
 * <p>
 * This method must be called before any rows are added to the window, otherwise
 * it will fail to set the number of columns if it differs from the current number
 * of columns.
 * </p>
 *
 * @param columnNum The new number of columns.
 * @return True if successful.
 * @apiSince 1
 */

public boolean setNumColumns(int columnNum) { throw new RuntimeException("Stub!"); }

/**
 * Allocates a new row at the end of this cursor window.
 *
 * @return True if successful, false if the cursor window is out of memory.
 * @apiSince 1
 */

public boolean allocRow() { throw new RuntimeException("Stub!"); }

/**
 * Frees the last row in this cursor window.
 * @apiSince 1
 */

public void freeLastRow() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the field at the specified row and column index
 * has type {@link android.database.Cursor#FIELD_TYPE_NULL Cursor#FIELD_TYPE_NULL}.
 *
 * @param row The zero-based row index.
 * @param column The zero-based column index.
 * @return True if the field has type {@link android.database.Cursor#FIELD_TYPE_NULL Cursor#FIELD_TYPE_NULL}.
 * @deprecated Use {@link #getType(int,int)} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public boolean isNull(int row, int column) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the field at the specified row and column index
 * has type {@link android.database.Cursor#FIELD_TYPE_BLOB Cursor#FIELD_TYPE_BLOB} or {@link android.database.Cursor#FIELD_TYPE_NULL Cursor#FIELD_TYPE_NULL}.
 *
 * @param row The zero-based row index.
 * @param column The zero-based column index.
 * @return True if the field has type {@link android.database.Cursor#FIELD_TYPE_BLOB Cursor#FIELD_TYPE_BLOB} or
 * {@link android.database.Cursor#FIELD_TYPE_NULL Cursor#FIELD_TYPE_NULL}.
 * @deprecated Use {@link #getType(int,int)} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public boolean isBlob(int row, int column) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the field at the specified row and column index
 * has type {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER}.
 *
 * @param row The zero-based row index.
 * @param column The zero-based column index.
 * @return True if the field has type {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER}.
 * @deprecated Use {@link #getType(int,int)} instead.
 * @apiSince 5
 * @deprecatedSince 15
 */

@Deprecated
public boolean isLong(int row, int column) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the field at the specified row and column index
 * has type {@link android.database.Cursor#FIELD_TYPE_FLOAT Cursor#FIELD_TYPE_FLOAT}.
 *
 * @param row The zero-based row index.
 * @param column The zero-based column index.
 * @return True if the field has type {@link android.database.Cursor#FIELD_TYPE_FLOAT Cursor#FIELD_TYPE_FLOAT}.
 * @deprecated Use {@link #getType(int,int)} instead.
 * @apiSince 5
 * @deprecatedSince 15
 */

@Deprecated
public boolean isFloat(int row, int column) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the field at the specified row and column index
 * has type {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING} or {@link android.database.Cursor#FIELD_TYPE_NULL Cursor#FIELD_TYPE_NULL}.
 *
 * @param row The zero-based row index.
 * @param column The zero-based column index.
 * @return True if the field has type {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING}
 * or {@link android.database.Cursor#FIELD_TYPE_NULL Cursor#FIELD_TYPE_NULL}.
 * @deprecated Use {@link #getType(int,int)} instead.
 * @apiSince 5
 * @deprecatedSince 15
 */

@Deprecated
public boolean isString(int row, int column) { throw new RuntimeException("Stub!"); }

/**
 * Returns the type of the field at the specified row and column index.
 * <p>
 * The returned field types are:
 * <ul>
 * <li>{@link android.database.Cursor#FIELD_TYPE_NULL Cursor#FIELD_TYPE_NULL}</li>
 * <li>{@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER}</li>
 * <li>{@link android.database.Cursor#FIELD_TYPE_FLOAT Cursor#FIELD_TYPE_FLOAT}</li>
 * <li>{@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING}</li>
 * <li>{@link android.database.Cursor#FIELD_TYPE_BLOB Cursor#FIELD_TYPE_BLOB}</li>
 * </ul>
 * </p>
 *
 * @param row The zero-based row index.
 * @param column The zero-based column index.
 * @return The field type.
 * @apiSince 11
 */

public int getType(int row, int column) { throw new RuntimeException("Stub!"); }

/**
 * Gets the value of the field at the specified row and column index as a byte array.
 * <p>
 * The result is determined as follows:
 * <ul>
 * <li>If the field is of type {@link android.database.Cursor#FIELD_TYPE_NULL Cursor#FIELD_TYPE_NULL}, then the result
 * is <code>null</code>.</li>
 * <li>If the field is of type {@link android.database.Cursor#FIELD_TYPE_BLOB Cursor#FIELD_TYPE_BLOB}, then the result
 * is the blob value.</li>
 * <li>If the field is of type {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING}, then the result
 * is the array of bytes that make up the internal representation of the
 * string value.</li>
 * <li>If the field is of type {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} or
 * {@link android.database.Cursor#FIELD_TYPE_FLOAT Cursor#FIELD_TYPE_FLOAT}, then a {@link android.database.sqlite.SQLiteException SQLiteException} is thrown.</li>
 * </ul>
 * </p>
 *
 * @param row The zero-based row index.
 * @param column The zero-based column index.
 * @return The value of the field as a byte array.
 * @apiSince 1
 */

public byte[] getBlob(int row, int column) { throw new RuntimeException("Stub!"); }

/**
 * Gets the value of the field at the specified row and column index as a string.
 * <p>
 * The result is determined as follows:
 * <ul>
 * <li>If the field is of type {@link android.database.Cursor#FIELD_TYPE_NULL Cursor#FIELD_TYPE_NULL}, then the result
 * is <code>null</code>.</li>
 * <li>If the field is of type {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING}, then the result
 * is the string value.</li>
 * <li>If the field is of type {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER}, then the result
 * is a string representation of the integer in decimal, obtained by formatting the
 * value with the <code>printf</code> family of functions using
 * format specifier <code>%lld</code>.</li>
 * <li>If the field is of type {@link android.database.Cursor#FIELD_TYPE_FLOAT Cursor#FIELD_TYPE_FLOAT}, then the result
 * is a string representation of the floating-point value in decimal, obtained by
 * formatting the value with the <code>printf</code> family of functions using
 * format specifier <code>%g</code>.</li>
 * <li>If the field is of type {@link android.database.Cursor#FIELD_TYPE_BLOB Cursor#FIELD_TYPE_BLOB}, then a
 * {@link android.database.sqlite.SQLiteException SQLiteException} is thrown.</li>
 * </ul>
 * </p>
 *
 * @param row The zero-based row index.
 * @param column The zero-based column index.
 * @return The value of the field as a string.
 * @apiSince 1
 */

public java.lang.String getString(int row, int column) { throw new RuntimeException("Stub!"); }

/**
 * Copies the text of the field at the specified row and column index into
 * a {@link android.database.CharArrayBuffer CharArrayBuffer}.
 * <p>
 * The buffer is populated as follows:
 * <ul>
 * <li>If the buffer is too small for the value to be copied, then it is
 * automatically resized.</li>
 * <li>If the field is of type {@link android.database.Cursor#FIELD_TYPE_NULL Cursor#FIELD_TYPE_NULL}, then the buffer
 * is set to an empty string.</li>
 * <li>If the field is of type {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING}, then the buffer
 * is set to the contents of the string.</li>
 * <li>If the field is of type {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER}, then the buffer
 * is set to a string representation of the integer in decimal, obtained by formatting the
 * value with the <code>printf</code> family of functions using
 * format specifier <code>%lld</code>.</li>
 * <li>If the field is of type {@link android.database.Cursor#FIELD_TYPE_FLOAT Cursor#FIELD_TYPE_FLOAT}, then the buffer is
 * set to a string representation of the floating-point value in decimal, obtained by
 * formatting the value with the <code>printf</code> family of functions using
 * format specifier <code>%g</code>.</li>
 * <li>If the field is of type {@link android.database.Cursor#FIELD_TYPE_BLOB Cursor#FIELD_TYPE_BLOB}, then a
 * {@link android.database.sqlite.SQLiteException SQLiteException} is thrown.</li>
 * </ul>
 * </p>
 *
 * @param row The zero-based row index.
 * @param column The zero-based column index.
 * @param buffer The {@link android.database.CharArrayBuffer CharArrayBuffer} to hold the string.  It is automatically
 * resized if the requested string is larger than the buffer's current capacity.
 * @apiSince 1
 */

public void copyStringToBuffer(int row, int column, android.database.CharArrayBuffer buffer) { throw new RuntimeException("Stub!"); }

/**
 * Gets the value of the field at the specified row and column index as a <code>long</code>.
 * <p>
 * The result is determined as follows:
 * <ul>
 * <li>If the field is of type {@link android.database.Cursor#FIELD_TYPE_NULL Cursor#FIELD_TYPE_NULL}, then the result
 * is <code>0L</code>.</li>
 * <li>If the field is of type {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING}, then the result
 * is the value obtained by parsing the string value with <code>strtoll</code>.
 * <li>If the field is of type {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER}, then the result
 * is the <code>long</code> value.</li>
 * <li>If the field is of type {@link android.database.Cursor#FIELD_TYPE_FLOAT Cursor#FIELD_TYPE_FLOAT}, then the result
 * is the floating-point value converted to a <code>long</code>.</li>
 * <li>If the field is of type {@link android.database.Cursor#FIELD_TYPE_BLOB Cursor#FIELD_TYPE_BLOB}, then a
 * {@link android.database.sqlite.SQLiteException SQLiteException} is thrown.</li>
 * </ul>
 * </p>
 *
 * @param row The zero-based row index.
 * @param column The zero-based column index.
 * @return The value of the field as a <code>long</code>.
 * @apiSince 1
 */

public long getLong(int row, int column) { throw new RuntimeException("Stub!"); }

/**
 * Gets the value of the field at the specified row and column index as a
 * <code>double</code>.
 * <p>
 * The result is determined as follows:
 * <ul>
 * <li>If the field is of type {@link android.database.Cursor#FIELD_TYPE_NULL Cursor#FIELD_TYPE_NULL}, then the result
 * is <code>0.0</code>.</li>
 * <li>If the field is of type {@link android.database.Cursor#FIELD_TYPE_STRING Cursor#FIELD_TYPE_STRING}, then the result
 * is the value obtained by parsing the string value with <code>strtod</code>.
 * <li>If the field is of type {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER}, then the result
 * is the integer value converted to a <code>double</code>.</li>
 * <li>If the field is of type {@link android.database.Cursor#FIELD_TYPE_FLOAT Cursor#FIELD_TYPE_FLOAT}, then the result
 * is the <code>double</code> value.</li>
 * <li>If the field is of type {@link android.database.Cursor#FIELD_TYPE_BLOB Cursor#FIELD_TYPE_BLOB}, then a
 * {@link android.database.sqlite.SQLiteException SQLiteException} is thrown.</li>
 * </ul>
 * </p>
 *
 * @param row The zero-based row index.
 * @param column The zero-based column index.
 * @return The value of the field as a <code>double</code>.
 * @apiSince 1
 */

public double getDouble(int row, int column) { throw new RuntimeException("Stub!"); }

/**
 * Gets the value of the field at the specified row and column index as a
 * <code>short</code>.
 * <p>
 * The result is determined by invoking {@link #getLong} and converting the
 * result to <code>short</code>.
 * </p>
 *
 * @param row The zero-based row index.
 * @param column The zero-based column index.
 * @return The value of the field as a <code>short</code>.
 * @apiSince 1
 */

public short getShort(int row, int column) { throw new RuntimeException("Stub!"); }

/**
 * Gets the value of the field at the specified row and column index as an
 * <code>int</code>.
 * <p>
 * The result is determined by invoking {@link #getLong} and converting the
 * result to <code>int</code>.
 * </p>
 *
 * @param row The zero-based row index.
 * @param column The zero-based column index.
 * @return The value of the field as an <code>int</code>.
 * @apiSince 1
 */

public int getInt(int row, int column) { throw new RuntimeException("Stub!"); }

/**
 * Gets the value of the field at the specified row and column index as a
 * <code>float</code>.
 * <p>
 * The result is determined by invoking {@link #getDouble} and converting the
 * result to <code>float</code>.
 * </p>
 *
 * @param row The zero-based row index.
 * @param column The zero-based column index.
 * @return The value of the field as an <code>float</code>.
 * @apiSince 1
 */

public float getFloat(int row, int column) { throw new RuntimeException("Stub!"); }

/**
 * Copies a byte array into the field at the specified row and column index.
 *
 * @param value The value to store.
 * @param row The zero-based row index.
 * @param column The zero-based column index.
 * @return True if successful.
 * @apiSince 1
 */

public boolean putBlob(byte[] value, int row, int column) { throw new RuntimeException("Stub!"); }

/**
 * Copies a string into the field at the specified row and column index.
 *
 * @param value The value to store.
 * @param row The zero-based row index.
 * @param column The zero-based column index.
 * @return True if successful.
 * @apiSince 1
 */

public boolean putString(java.lang.String value, int row, int column) { throw new RuntimeException("Stub!"); }

/**
 * Puts a long integer into the field at the specified row and column index.
 *
 * @param value The value to store.
 * @param row The zero-based row index.
 * @param column The zero-based column index.
 * @return True if successful.
 * @apiSince 1
 */

public boolean putLong(long value, int row, int column) { throw new RuntimeException("Stub!"); }

/**
 * Puts a double-precision floating point value into the field at the
 * specified row and column index.
 *
 * @param value The value to store.
 * @param row The zero-based row index.
 * @param column The zero-based column index.
 * @return True if successful.
 * @apiSince 1
 */

public boolean putDouble(double value, int row, int column) { throw new RuntimeException("Stub!"); }

/**
 * Puts a null value into the field at the specified row and column index.
 *
 * @param row The zero-based row index.
 * @param column The zero-based column index.
 * @return True if successful.
 * @apiSince 1
 */

public boolean putNull(int row, int column) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static android.database.CursorWindow newFromParcel(android.os.Parcel p) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onAllReferencesReleased() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.database.CursorWindow> CREATOR;
static { CREATOR = null; }
}

