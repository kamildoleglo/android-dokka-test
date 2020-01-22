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

import android.content.ContentProvider;

/**
 * If you would like to test a single content provider with an
 * {@link android.test.InstrumentationTestCase InstrumentationTestCase}, this provides some of the boiler plate in {@link #setUp} and
 * {@link #tearDown}.
 *
 * @deprecated this class extends InstrumentationTestCase but should extend AndroidTestCase. Use
 * ProviderTestCase2, which corrects this problem, instead.
 * @apiSince 1
 * @deprecatedSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public abstract class ProviderTestCase<T extends android.content.ContentProvider> extends android.test.InstrumentationTestCase {

/** @apiSince 1 */

@Deprecated
public ProviderTestCase(java.lang.Class<T> providerClass, java.lang.String providerAuthority) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated
public T getProvider() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated
protected void setUp() throws java.lang.Exception { throw new RuntimeException("Stub!"); }

/**
 * Tears down the environment for the test fixture.
 * <p>
 * Calls {@link android.content.ContentProvider#shutdown()} on the
 * {@link android.content.ContentProvider} represented by mProvider.
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated
protected void tearDown() throws java.lang.Exception { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated
public android.test.mock.MockContentResolver getMockContentResolver() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated
public android.test.IsolatedContext getMockContext() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 5
 */

@Deprecated
public static <T extends android.content.ContentProvider> android.content.ContentResolver newResolverWithContentProviderFromSql(android.content.Context targetContext, java.lang.Class<T> providerClass, java.lang.String authority, java.lang.String databaseName, int databaseVersion, java.lang.String sql) throws java.lang.IllegalAccessException, java.lang.InstantiationException { throw new RuntimeException("Stub!"); }
}

