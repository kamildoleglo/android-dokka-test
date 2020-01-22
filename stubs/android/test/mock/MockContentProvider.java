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

import android.content.ContentProvider;
import android.content.Context;
import android.content.pm.ProviderInfo;

/**
 * Mock implementation of ContentProvider.  All methods are non-functional and throw
 * {@link java.lang.UnsupportedOperationException}.  Tests can extend this class to
 * implement behavior needed for tests.
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MockContentProvider extends android.content.ContentProvider {

/**
 * A constructor using {@link android.test.mock.MockContext MockContext} instance as a Context in it.
 * @apiSince 8
 */

protected MockContentProvider() { throw new RuntimeException("Stub!"); }

/**
 * A constructor accepting a Context instance, which is supposed to be the subclasss of
 * {@link android.test.mock.MockContext MockContext}.
 * @apiSince 8
 */

public MockContentProvider(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * A constructor which initialize four member variables which
 * {@link android.content.ContentProvider} have internally.
 *
 * @param context A Context object which should be some mock instance (like the
 * instance of {@link android.test.mock.MockContext}).
 * @param readPermission The read permision you want this instance should have in the
 * test, which is available via {@link #getReadPermission()}.
 * @param writePermission The write permission you want this instance should have
 * in the test, which is available via {@link #getWritePermission()}.
 * @param pathPermissions The PathPermissions you want this instance should have
 * in the test, which is available via {@link #getPathPermissions()}.
 * @apiSince 8
 */

public MockContentProvider(android.content.Context context, java.lang.String readPermission, java.lang.String writePermission, android.content.pm.PathPermission[] pathPermissions) { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public int delete(android.net.Uri uri, java.lang.String selection, java.lang.String[] selectionArgs) { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public java.lang.String getType(android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public android.net.Uri insert(android.net.Uri uri, android.content.ContentValues values) { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public boolean onCreate() { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public android.database.Cursor query(android.net.Uri uri, java.lang.String[] projection, java.lang.String selection, java.lang.String[] selectionArgs, java.lang.String sortOrder) { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public int update(android.net.Uri uri, android.content.ContentValues values, java.lang.String selection, java.lang.String[] selectionArgs) { throw new RuntimeException("Stub!"); }

/**
 * If you're reluctant to implement this manually, please just call super.bulkInsert().
 * @apiSince 8
 */

public int bulkInsert(android.net.Uri uri, android.content.ContentValues[] values) { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public void attachInfo(android.content.Context context, android.content.pm.ProviderInfo info) { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public android.content.ContentProviderResult[] applyBatch(java.util.ArrayList<android.content.ContentProviderOperation> operations) { throw new RuntimeException("Stub!"); }

/**
 * @hide
 */

public android.os.Bundle call(java.lang.String method, java.lang.String request, android.os.Bundle args) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public java.lang.String[] getStreamTypes(android.net.Uri url, java.lang.String mimeTypeFilter) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public android.content.res.AssetFileDescriptor openTypedAssetFile(android.net.Uri url, java.lang.String mimeType, android.os.Bundle opts) { throw new RuntimeException("Stub!"); }

/**
 * Like {@link #attachInfo(android.content.Context,android.content.pm.ProviderInfo)}, but for use
 * when directly instantiating the provider for testing.
 *
 * <p>Provided for use by {@code android.test.ProviderTestCase2} and
 * {@code android.test.RenamingDelegatingContext}.
 *
 * @deprecated Use a mocking framework like <a href="https://github.com/mockito/mockito">Mockito</a>.
 * New tests should be written using the
 * <a href="{@docRoot}tools/testing-support-library/index.html">Android Testing Support Library</a>.
 * @apiSince R
 * @deprecatedSince R
 */

@Deprecated
public static void attachInfoForTesting(android.content.ContentProvider provider, android.content.Context context, android.content.pm.ProviderInfo providerInfo) { throw new RuntimeException("Stub!"); }
}

