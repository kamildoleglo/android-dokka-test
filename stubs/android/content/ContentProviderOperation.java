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


package android.content;

import java.util.ArrayList;
import android.net.Uri;
import java.util.Map;

/**
 * Represents a single operation to be performed as part of a batch of operations.
 *
 * @see android.content.ContentProvider#applyBatch(ArrayList)
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ContentProviderOperation implements android.os.Parcelable {

ContentProviderOperation() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Create a {@link android.content.ContentProviderOperation.Builder Builder} suitable for building an insert {@link android.content.ContentProviderOperation ContentProviderOperation}.
 * @param uri The {@link android.net.Uri Uri} that is the target of the insert.
 * @return a {@link android.content.ContentProviderOperation.Builder Builder}
 * @apiSince 5
 */

public static android.content.ContentProviderOperation.Builder newInsert(android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Create a {@link android.content.ContentProviderOperation.Builder Builder} suitable for building an update {@link android.content.ContentProviderOperation ContentProviderOperation}.
 * @param uri The {@link android.net.Uri Uri} that is the target of the update.
 * @return a {@link android.content.ContentProviderOperation.Builder Builder}
 * @apiSince 5
 */

public static android.content.ContentProviderOperation.Builder newUpdate(android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Create a {@link android.content.ContentProviderOperation.Builder Builder} suitable for building a delete {@link android.content.ContentProviderOperation ContentProviderOperation}.
 * @param uri The {@link android.net.Uri Uri} that is the target of the delete.
 * @return a {@link android.content.ContentProviderOperation.Builder Builder}
 * @apiSince 5
 */

public static android.content.ContentProviderOperation.Builder newDelete(android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Create a {@link android.content.ContentProviderOperation.Builder Builder} suitable for building a
 * {@link android.content.ContentProviderOperation ContentProviderOperation} to assert a set of values as provided
 * through {@link android.content.ContentProviderOperation.Builder#withValues(android.content.ContentValues) Builder#withValues(ContentValues)}.
 * @apiSince 5
 */

public static android.content.ContentProviderOperation.Builder newAssertQuery(android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Gets the Uri for the target of the operation.
 * @apiSince 5
 */

public android.net.Uri getUri() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the operation allows yielding the database to other transactions
 * if the database is contended.
 *
 * @see android.database.sqlite.SQLiteDatabase#yieldIfContendedSafely()
 * @apiSince 5
 */

public boolean isYieldAllowed() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the operation represents an insertion.
 *
 * @see #newInsert
 * @apiSince 23
 */

public boolean isInsert() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the operation represents a deletion.
 *
 * @see #newDelete
 * @apiSince 23
 */

public boolean isDelete() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the operation represents an update.
 *
 * @see #newUpdate
 * @apiSince 23
 */

public boolean isUpdate() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the operation represents an assert query.
 *
 * @see #newAssertQuery
 * @apiSince 23
 */

public boolean isAssertQuery() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the operation represents an insertion, deletion, or update.
 *
 * @see #isInsert
 * @see #isDelete
 * @see #isUpdate
 * @apiSince 5
 */

public boolean isWriteOperation() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the operation represents an assert query.
 *
 * @see #isAssertQuery
 * @apiSince 5
 */

public boolean isReadOperation() { throw new RuntimeException("Stub!"); }

/**
 * Applies this operation using the given provider. The backRefs array is used to resolve any
 * back references that were requested using
 * {@link android.content.ContentProviderOperation.Builder#withValueBackReferences(android.content.ContentValues) Builder#withValueBackReferences(ContentValues)} and
 * {@link android.content.ContentProviderOperation.Builder#withSelectionBackReference Builder#withSelectionBackReference}.
 * @param provider the {@link android.content.ContentProvider ContentProvider} on which this batch is applied
 * @param backRefs a {@link android.content.ContentProviderResult ContentProviderResult} array that will be consulted
 * to resolve any requested back references.
 * @param numBackRefs the number of valid results on the backRefs array.
 * @return a {@link android.content.ContentProviderResult ContentProviderResult} that contains either the {@link android.net.Uri Uri} of the inserted
 * row if this was an insert otherwise the number of rows affected.
 * @throws android.content.OperationApplicationException thrown if either the insert fails or
 * if the number of rows affected didn't match the expected count
 * @apiSince 5
 */

public android.content.ContentProviderResult apply(android.content.ContentProvider provider, android.content.ContentProviderResult[] backRefs, int numBackRefs) throws android.content.OperationApplicationException { throw new RuntimeException("Stub!"); }

/**
 * The ContentValues back references are represented as a ContentValues object where the
 * key refers to a column and the value is an index of the back reference whose
 * valued should be associated with the column.
 * <p>
 * This is intended to be a private method but it is exposed for
 * unit testing purposes
 * @param backRefs an array of previous results
 * @param numBackRefs the number of valid previous results in backRefs
 * @return the ContentValues that should be used in this operation application after
 * expansion of back references. This can be called if either mValues or mValuesBackReferences
 * is null
 * @apiSince 5
 */

public android.content.ContentValues resolveValueBackReferences(android.content.ContentProviderResult[] backRefs, int numBackRefs) { throw new RuntimeException("Stub!"); }

/**
 * The Selection Arguments back references are represented as a Map of Integer->Integer where
 * the key is an index into the selection argument array (see {@link android.content.ContentProviderOperation.Builder#withSelection Builder#withSelection})
 * and the value is the index of the previous result that should be used for that selection
 * argument array slot.
 * <p>
 * This is intended to be a private method but it is exposed for
 * unit testing purposes
 * @param backRefs an array of previous results
 * @param numBackRefs the number of valid previous results in backRefs
 * @return the ContentValues that should be used in this operation application after
 * expansion of back references. This can be called if either mValues or mValuesBackReferences
 * is null
 * @apiSince 5
 */

public java.lang.String[] resolveSelectionArgsBackReferences(android.content.ContentProviderResult[] backRefs, int numBackRefs) { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.content.ContentProviderOperation> CREATOR;
static { CREATOR = null; }
/**
 * Used to add parameters to a {@link android.content.ContentProviderOperation ContentProviderOperation}. The {@link android.content.ContentProviderOperation.Builder Builder} is
 * first created by calling {@link android.content.ContentProviderOperation#newInsert(android.net.Uri) ContentProviderOperation#newInsert(android.net.Uri)},
 * {@link android.content.ContentProviderOperation#newUpdate(android.net.Uri) ContentProviderOperation#newUpdate(android.net.Uri)},
 * {@link android.content.ContentProviderOperation#newDelete(android.net.Uri) ContentProviderOperation#newDelete(android.net.Uri)} or
 * {@link android.content.ContentProviderOperation#newAssertQuery(android.net.Uri) ContentProviderOperation#newAssertQuery(Uri)}. The withXXX methods
 * can then be used to add parameters to the builder. See the specific methods to find for
 * which {@link android.content.ContentProviderOperation.Builder Builder} type each is allowed. Call {@link #build} to create the
 * {@link android.content.ContentProviderOperation ContentProviderOperation} once all the parameters have been supplied.
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

private Builder() { throw new RuntimeException("Stub!"); }

/**
 * Create a ContentProviderOperation from this {@link android.content.ContentProviderOperation.Builder Builder}.
 * @apiSince 5
 */

public android.content.ContentProviderOperation build() { throw new RuntimeException("Stub!"); }

/**
 * Add a {@link android.content.ContentValues ContentValues} of back references. The key is the name of the column
 * and the value is an integer that is the index of the previous result whose
 * value should be used for the column. The value is added as a {@link java.lang.String String}.
 * A column value from the back references takes precedence over a value specified in
 * {@link #withValues}.
 * This can only be used with builders of type insert, update, or assert.
 * @return this builder, to allow for chaining.
 * @apiSince 5
 */

public android.content.ContentProviderOperation.Builder withValueBackReferences(android.content.ContentValues backReferences) { throw new RuntimeException("Stub!"); }

/**
 * Add a ContentValues back reference.
 * A column value from the back references takes precedence over a value specified in
 * {@link #withValues}.
 * This can only be used with builders of type insert, update, or assert.
 * @return this builder, to allow for chaining.
 * @apiSince 5
 */

public android.content.ContentProviderOperation.Builder withValueBackReference(java.lang.String key, int previousResult) { throw new RuntimeException("Stub!"); }

/**
 * Add a back references as a selection arg. Any value at that index of the selection arg
 * that was specified by {@link #withSelection} will be overwritten.
 * This can only be used with builders of type update, delete, or assert.
 * @return this builder, to allow for chaining.
 * @apiSince 5
 */

public android.content.ContentProviderOperation.Builder withSelectionBackReference(int selectionArgIndex, int previousResult) { throw new RuntimeException("Stub!"); }

/**
 * The ContentValues to use. This may be null. These values may be overwritten by
 * the corresponding value specified by {@link #withValueBackReference} or by
 * future calls to {@link #withValues} or {@link #withValue}.
 * This can only be used with builders of type insert, update, or assert.
 * @return this builder, to allow for chaining.
 * @apiSince 5
 */

public android.content.ContentProviderOperation.Builder withValues(android.content.ContentValues values) { throw new RuntimeException("Stub!"); }

/**
 * A value to insert or update. This value may be overwritten by
 * the corresponding value specified by {@link #withValueBackReference}.
 * This can only be used with builders of type insert, update, or assert.
 * @param key the name of this value
 * @param value the value itself. the type must be acceptable for insertion by
 * {@link android.content.ContentValues#put ContentValues#put}
 * @return this builder, to allow for chaining.
 * @apiSince 5
 */

public android.content.ContentProviderOperation.Builder withValue(java.lang.String key, java.lang.Object value) { throw new RuntimeException("Stub!"); }

/**
 * The selection and arguments to use. An occurrence of '?' in the selection will be
 * replaced with the corresponding occurrence of the selection argument. Any of the
 * selection arguments may be overwritten by a selection argument back reference as
 * specified by {@link #withSelectionBackReference}.
 * This can only be used with builders of type update, delete, or assert.
 * @return this builder, to allow for chaining.
 * @apiSince 5
 */

public android.content.ContentProviderOperation.Builder withSelection(java.lang.String selection, java.lang.String[] selectionArgs) { throw new RuntimeException("Stub!"); }

/**
 * If set then if the number of rows affected by this operation does not match
 * this count {@link android.content.OperationApplicationException OperationApplicationException} will be throw.
 * This can only be used with builders of type update, delete, or assert.
 * @return this builder, to allow for chaining.
 * @apiSince 5
 */

public android.content.ContentProviderOperation.Builder withExpectedCount(int count) { throw new RuntimeException("Stub!"); }

/**
 * If set to true then the operation allows yielding the database to other transactions
 * if the database is contended.
 * @return this builder, to allow for chaining.
 * @see android.database.sqlite.SQLiteDatabase#yieldIfContendedSafely()
 * @apiSince 5
 */

public android.content.ContentProviderOperation.Builder withYieldAllowed(boolean yieldAllowed) { throw new RuntimeException("Stub!"); }
}

}

