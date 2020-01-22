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
 * If you would like to test sync a single provider with an
 * {@link android.test.InstrumentationTestCase InstrumentationTestCase}, this provides some of the boiler plate in {@link #setUp} and
 * {@link #tearDown}.
 *
 * @deprecated Use
 * <a href="{@docRoot}reference/android/support/test/InstrumentationRegistry.html">
 * InstrumentationRegistry</a> instead. New tests should be written using the
 * <a href="{@docRoot}tools/testing-support-library/index.html">Android Testing Support Library</a>.
 * @apiSince 1
 * @deprecatedSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class SyncBaseInstrumentation extends android.test.InstrumentationTestCase {

@Deprecated
public SyncBaseInstrumentation() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
protected void setUp() throws java.lang.Exception { throw new RuntimeException("Stub!"); }

/**
 * Syncs the specified provider.
 * @throws java.lang.Exception
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
protected void syncProvider(android.net.Uri uri, java.lang.String accountName, java.lang.String authority) throws java.lang.Exception { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
protected void cancelSyncsandDisableAutoSync() { throw new RuntimeException("Stub!"); }
}

