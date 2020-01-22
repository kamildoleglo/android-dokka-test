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


package android.test;

import android.content.Context;
import junit.framework.TestCase;

/**
 * Extend this if you need to access Resources or other things that depend on Activity Context.
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
public class AndroidTestCase extends junit.framework.TestCase {

@Deprecated
public AndroidTestCase() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
protected void setUp() throws java.lang.Exception { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
protected void tearDown() throws java.lang.Exception { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public void testAndroidTestCaseSetupProperly() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public void setContext(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public android.content.Context getContext() { throw new RuntimeException("Stub!"); }

/**
 * Asserts that launching a given activity is protected by a particular permission by
 * attempting to start the activity and validating that a {@link java.lang.SecurityException SecurityException}
 * is thrown that mentions the permission in its error message.
 *
 * Note that an instrumentation isn't needed because all we are looking for is a security error
 * and we don't need to wait for the activity to launch and get a handle to the activity.
 *
 * @param packageName The package name of the activity to launch.
 * @param className The class of the activity to launch.
 * @param permission The name of the permission.
 * @apiSince 4
 * @deprecatedSince 24
 */

@Deprecated
public void assertActivityRequiresPermission(java.lang.String packageName, java.lang.String className, java.lang.String permission) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that reading from the content uri requires a particular permission by querying the
 * uri and ensuring a {@link java.lang.SecurityException SecurityException} is thrown mentioning the particular permission.
 *
 * @param uri The uri that requires a permission to query.
 * @param permission The permission that should be required.
 * @apiSince 4
 * @deprecatedSince 24
 */

@Deprecated
public void assertReadingContentUriRequiresPermission(android.net.Uri uri, java.lang.String permission) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that writing to the content uri requires a particular permission by inserting into
 * the uri and ensuring a {@link java.lang.SecurityException SecurityException} is thrown mentioning the particular
 * permission.
 *
 * @param uri The uri that requires a permission to query.
 * @param permission The permission that should be required.
 * @apiSince 4
 * @deprecatedSince 24
 */

@Deprecated
public void assertWritingContentUriRequiresPermission(android.net.Uri uri, java.lang.String permission) { throw new RuntimeException("Stub!"); }

/**
 * This function is called by various TestCase implementations, at tearDown() time, in order
 * to scrub out any class variables.  This protects against memory leaks in the case where a
 * test case creates a non-static inner class (thus referencing the test case) and gives it to
 * someone else to hold onto.
 *
 * @param testCaseClass The class of the derived TestCase implementation.
 *
 * @throws java.lang.IllegalAccessException
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
protected void scrubClass(java.lang.Class<?> testCaseClass) throws java.lang.IllegalAccessException { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated protected android.content.Context mContext;
}

