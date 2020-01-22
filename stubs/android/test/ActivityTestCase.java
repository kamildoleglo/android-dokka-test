/*
 * Copyright (C) 2008 The Android Open Source Project
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

import android.app.Activity;

/**
 * This is common code used to support Activity test cases.  For more useful classes, please see
 * {@link android.test.ActivityUnitTestCase} and
 * {@link android.test.ActivityInstrumentationTestCase}.
 *
 * @deprecated New tests should be written using the
 * <a href="{@docRoot}tools/testing-support-library/index.html">Android Testing Support Library</a>.
 * @apiSince 1
 * @deprecatedSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public abstract class ActivityTestCase extends android.test.InstrumentationTestCase {

@Deprecated
public ActivityTestCase() { throw new RuntimeException("Stub!"); }

/**
 * @return Returns the activity under test.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
protected android.app.Activity getActivity() { throw new RuntimeException("Stub!"); }

/**
 * Set the activity under test.
 * @param testActivity The activity under test
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
protected void setActivity(android.app.Activity testActivity) { throw new RuntimeException("Stub!"); }

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
}

