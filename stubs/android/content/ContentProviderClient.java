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

import android.os.Bundle;

/**
 * The public interface object used to interact with a specific
 * {@link android.content.ContentProvider ContentProvider}.
 * <p>
 * Instances can be obtained by calling
 * {@link android.content.ContentResolver#acquireContentProviderClient ContentResolver#acquireContentProviderClient} or
 * {@link android.content.ContentResolver#acquireUnstableContentProviderClient ContentResolver#acquireUnstableContentProviderClient}. Instances must
 * be released using {@link #close()} in order to indicate to the system that
 * the underlying {@link android.content.ContentProvider ContentProvider} is no longer needed and can be killed
 * to free up resources.
 * <p>
 * Note that you should generally create a new ContentProviderClient instance
 * for each thread that will be performing operations. Unlike
 * {@link android.content.ContentResolver ContentResolver}, the methods here such as {@link #query} and
 * {@link #openFile} are not thread safe -- you must not call {@link #close()}
 * on the ContentProviderClient those calls are made from until you are finished
 * with the data they have returned.
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ContentProviderClient implements java.lang.AutoCloseable {

ContentProviderClient() { throw new RuntimeException("Stub!"); }

/**
 * See {@link android.content.ContentProvider#query ContentProvider#query}
 * @param url This value must never be {@code null}.
 * @param projection This value may be {@code null}.
 * @param selection This value may be {@code null}.
 * @param selectionArgs This value may be {@code null}.
 * @param sortOrder This value may be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 5
 */

@androidx.annotation.Nullable
public android.database.Cursor query(@androidx.annotation.NonNull android.net.Uri url, @androidx.annotation.Nullable java.lang.String[] projection, @androidx.annotation.Nullable java.lang.String selection, @androidx.annotation.Nullable java.lang.String[] selectionArgs, @androidx.annotation.Nullable java.lang.String sortOrder) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link android.content.ContentProvider#query ContentProvider#query}
 * @param uri This value must never be {@code null}.
 * @param projection This value may be {@code null}.
 * @param selection This value may be {@code null}.
 * @param selectionArgs This value may be {@code null}.
 * @param sortOrder This value may be {@code null}.
 * @param cancellationSignal This value may be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 16
 */

@androidx.annotation.Nullable
public android.database.Cursor query(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable java.lang.String[] projection, @androidx.annotation.Nullable java.lang.String selection, @androidx.annotation.Nullable java.lang.String[] selectionArgs, @androidx.annotation.Nullable java.lang.String sortOrder, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link android.content.ContentProvider#query ContentProvider#query}
 * @param uri This value must never be {@code null}.
 * @param projection This value may be {@code null}.
 * @param cancellationSignal This value may be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.Nullable
public android.database.Cursor query(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable java.lang.String[] projection, android.os.Bundle queryArgs, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link android.content.ContentProvider#getType ContentProvider#getType}
 * @param url This value must never be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 5
 */

@androidx.annotation.Nullable
public java.lang.String getType(@androidx.annotation.NonNull android.net.Uri url) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link android.content.ContentProvider#getStreamTypes ContentProvider#getStreamTypes}
 * @param url This value must never be {@code null}.
 * @param mimeTypeFilter This value must never be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 11
 */

@androidx.annotation.Nullable
public java.lang.String[] getStreamTypes(@androidx.annotation.NonNull android.net.Uri url, @androidx.annotation.NonNull java.lang.String mimeTypeFilter) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link android.content.ContentProvider#canonicalize ContentProvider#canonicalize}
 * @param url This value must never be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.Nullable
public final android.net.Uri canonicalize(@androidx.annotation.NonNull android.net.Uri url) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link android.content.ContentProvider#uncanonicalize ContentProvider#uncanonicalize}
 * @param url This value must never be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.Nullable
public final android.net.Uri uncanonicalize(@androidx.annotation.NonNull android.net.Uri url) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link android.content.ContentProvider#refresh ContentProvider#refresh}
 * @param args This value may be {@code null}.
 
 * @param cancellationSignal This value may be {@code null}.
 * @apiSince 26
 */

public boolean refresh(android.net.Uri url, @androidx.annotation.Nullable android.os.Bundle args, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link android.content.ContentProvider#insert ContentProvider#insert}
 * @param url This value must never be {@code null}.
 * @param initialValues This value may be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 5
 */

@androidx.annotation.Nullable
public android.net.Uri insert(@androidx.annotation.NonNull android.net.Uri url, @androidx.annotation.Nullable android.content.ContentValues initialValues) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link android.content.ContentProvider#bulkInsert ContentProvider#bulkInsert}
 * @param url This value must never be {@code null}.
 
 * @param initialValues This value must never be {@code null}.
 * @apiSince 5
 */

public int bulkInsert(@androidx.annotation.NonNull android.net.Uri url, @androidx.annotation.NonNull android.content.ContentValues[] initialValues) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link android.content.ContentProvider#delete ContentProvider#delete}
 * @param url This value must never be {@code null}.
 
 * @param selection This value may be {@code null}.
 
 * @param selectionArgs This value may be {@code null}.
 * @apiSince 5
 */

public int delete(@androidx.annotation.NonNull android.net.Uri url, @androidx.annotation.Nullable java.lang.String selection, @androidx.annotation.Nullable java.lang.String[] selectionArgs) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link android.content.ContentProvider#update ContentProvider#update}
 * @param url This value must never be {@code null}.
 
 * @param values This value may be {@code null}.
 
 * @param selection This value may be {@code null}.
 
 * @param selectionArgs This value may be {@code null}.
 * @apiSince 5
 */

public int update(@androidx.annotation.NonNull android.net.Uri url, @androidx.annotation.Nullable android.content.ContentValues values, @androidx.annotation.Nullable java.lang.String selection, @androidx.annotation.Nullable java.lang.String[] selectionArgs) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link android.content.ContentProvider#openFile ContentProvider#openFile}.  Note that
 * this <em>does not</em>
 * take care of non-content: URIs such as file:.  It is strongly recommended
 * you use the {@link android.content.ContentResolver#openFileDescriptor ContentResolver#openFileDescriptor} API instead.
 
 * @param url This value must never be {@code null}.
 * @param mode This value must never be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 5
 */

@androidx.annotation.Nullable
public android.os.ParcelFileDescriptor openFile(@androidx.annotation.NonNull android.net.Uri url, @androidx.annotation.NonNull java.lang.String mode) throws java.io.FileNotFoundException, android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link android.content.ContentProvider#openFile ContentProvider#openFile}.  Note that
 * this <em>does not</em>
 * take care of non-content: URIs such as file:.  It is strongly recommended
 * you use the {@link android.content.ContentResolver#openFileDescriptor ContentResolver#openFileDescriptor} API instead.
 
 * @param url This value must never be {@code null}.
 * @param mode This value must never be {@code null}.
 * @param signal This value may be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.Nullable
public android.os.ParcelFileDescriptor openFile(@androidx.annotation.NonNull android.net.Uri url, @androidx.annotation.NonNull java.lang.String mode, @androidx.annotation.Nullable android.os.CancellationSignal signal) throws java.io.FileNotFoundException, android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link android.content.ContentProvider#openAssetFile ContentProvider#openAssetFile}.
 * Note that this <em>does not</em>
 * take care of non-content: URIs such as file:.  It is strongly recommended
 * you use the {@link android.content.ContentResolver#openAssetFileDescriptor ContentResolver#openAssetFileDescriptor} API instead.
 
 * @param url This value must never be {@code null}.
 * @param mode This value must never be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 5
 */

@androidx.annotation.Nullable
public android.content.res.AssetFileDescriptor openAssetFile(@androidx.annotation.NonNull android.net.Uri url, @androidx.annotation.NonNull java.lang.String mode) throws java.io.FileNotFoundException, android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link android.content.ContentProvider#openAssetFile ContentProvider#openAssetFile}.
 * Note that this <em>does not</em>
 * take care of non-content: URIs such as file:.  It is strongly recommended
 * you use the {@link android.content.ContentResolver#openAssetFileDescriptor ContentResolver#openAssetFileDescriptor} API instead.
 
 * @param url This value must never be {@code null}.
 * @param mode This value must never be {@code null}.
 * @param signal This value may be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.Nullable
public android.content.res.AssetFileDescriptor openAssetFile(@androidx.annotation.NonNull android.net.Uri url, @androidx.annotation.NonNull java.lang.String mode, @androidx.annotation.Nullable android.os.CancellationSignal signal) throws java.io.FileNotFoundException, android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link android.content.ContentProvider#openTypedAssetFile ContentProvider#openTypedAssetFile}
 * @param uri This value must never be {@code null}.
 * @param mimeType This value must never be {@code null}.
 * @param opts This value may be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 11
 */

@androidx.annotation.Nullable
public final android.content.res.AssetFileDescriptor openTypedAssetFileDescriptor(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.NonNull java.lang.String mimeType, @androidx.annotation.Nullable android.os.Bundle opts) throws java.io.FileNotFoundException, android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link android.content.ContentProvider#openTypedAssetFile ContentProvider#openTypedAssetFile}
 * @param uri This value must never be {@code null}.
 * @param mimeType This value must never be {@code null}.
 * @param opts This value may be {@code null}.
 * @param signal This value may be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.Nullable
public final android.content.res.AssetFileDescriptor openTypedAssetFileDescriptor(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.NonNull java.lang.String mimeType, @androidx.annotation.Nullable android.os.Bundle opts, @androidx.annotation.Nullable android.os.CancellationSignal signal) throws java.io.FileNotFoundException, android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param uri This value must never be {@code null}.
 * @param mimeTypeFilter This value must never be {@code null}.
 * @param opts This value may be {@code null}.
 * @param signal This value may be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public final android.content.res.AssetFileDescriptor openTypedAssetFile(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.NonNull java.lang.String mimeTypeFilter, @androidx.annotation.Nullable android.os.Bundle opts, @androidx.annotation.Nullable android.os.CancellationSignal signal) throws java.io.FileNotFoundException, android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link android.content.ContentProvider#applyBatch ContentProvider#applyBatch}
 * @param operations This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 5
 */

@androidx.annotation.NonNull
public android.content.ContentProviderResult[] applyBatch(@androidx.annotation.NonNull java.util.ArrayList<android.content.ContentProviderOperation> operations) throws android.content.OperationApplicationException, android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link android.content.ContentProvider#applyBatch ContentProvider#applyBatch}
 * @param authority This value must never be {@code null}.
 * @param operations This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.content.ContentProviderResult[] applyBatch(@androidx.annotation.NonNull java.lang.String authority, @androidx.annotation.NonNull java.util.ArrayList<android.content.ContentProviderOperation> operations) throws android.content.OperationApplicationException, android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link android.content.ContentProvider#call(java.lang.String,java.lang.String,android.os.Bundle) ContentProvider#call(String, String, Bundle)}
 * @param method This value must never be {@code null}.
 * @param arg This value may be {@code null}.
 * @param extras This value may be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 17
 */

@androidx.annotation.Nullable
public android.os.Bundle call(@androidx.annotation.NonNull java.lang.String method, @androidx.annotation.Nullable java.lang.String arg, @androidx.annotation.Nullable android.os.Bundle extras) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link android.content.ContentProvider#call(java.lang.String,java.lang.String,android.os.Bundle) ContentProvider#call(String, String, Bundle)}
 * @param authority This value must never be {@code null}.
 * @param method This value must never be {@code null}.
 * @param arg This value may be {@code null}.
 * @param extras This value may be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.os.Bundle call(@androidx.annotation.NonNull java.lang.String authority, @androidx.annotation.NonNull java.lang.String method, @androidx.annotation.Nullable java.lang.String arg, @androidx.annotation.Nullable android.os.Bundle extras) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * Closes this client connection, indicating to the system that the
 * underlying {@link android.content.ContentProvider ContentProvider} is no longer needed.
 * @apiSince 24
 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated replaced by {@link #close()}.
 * @apiSince 5
 * @deprecatedSince 24
 */

@Deprecated
public boolean release() { throw new RuntimeException("Stub!"); }

/** @apiSince 5 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Get a reference to the {@link android.content.ContentProvider ContentProvider} that is associated with this
 * client. If the {@link android.content.ContentProvider ContentProvider} is running in a different process then
 * null will be returned. This can be used if you know you are running in the same
 * process as a provider, and want to get direct access to its implementation details.
 *
 * @return If the associated {@link android.content.ContentProvider ContentProvider} is local, returns it.
 * Otherwise returns null.
 * @apiSince 5
 */

@androidx.annotation.Nullable
public android.content.ContentProvider getLocalContentProvider() { throw new RuntimeException("Stub!"); }
}

