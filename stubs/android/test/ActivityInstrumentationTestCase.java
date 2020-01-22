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
 * This class provides functional testing of a single activity.  The activity under test will
 * be created using the system infrastructure (by calling InstrumentationTestCase.launchActivity())
 * and you will then be able to manipulate your Activity directly.  Most of the work is handled
 * automatically here by {@link #setUp} and {@link #tearDown}.
 *
 * <p>If you prefer an isolated unit test, see {@link android.test.ActivityUnitTestCase}.
 *
 * @deprecated new tests should be written using
 * {@link android.test.ActivityInstrumentationTestCase2}, which provides more options for
 * configuring the Activity under test
 * @apiSince 1
 * @deprecatedSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public abstract class ActivityInstrumentationTestCase<T extends android.app.Activity> extends android.test.ActivityTestCase {

/**
 * Creates an {@link android.test.ActivityInstrumentationTestCase ActivityInstrumentationTestCase} in non-touch mode.
 *
 * @param pkg ignored - no longer in use.
 * @param activityClass The activity to test. This must be a class in the instrumentation
 * targetPackage specified in the AndroidManifest.xml
 * @apiSince 1
 */

@Deprecated
public ActivityInstrumentationTestCase(java.lang.String pkg, java.lang.Class<T> activityClass) { throw new RuntimeException("Stub!"); }

/**
 * Creates an {@link android.test.ActivityInstrumentationTestCase ActivityInstrumentationTestCase}.
 *
 * @param pkg ignored - no longer in use.
 * @param activityClass The activity to test. This must be a class in the instrumentation
 * targetPackage specified in the AndroidManifest.xml
 * @param initialTouchMode true = in touch mode
 * @apiSince 1
 */

@Deprecated
public ActivityInstrumentationTestCase(java.lang.String pkg, java.lang.Class<T> activityClass, boolean initialTouchMode) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 3
 */

@Deprecated
public T getActivity() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 3
 */

@Deprecated
protected void setUp() throws java.lang.Exception { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 3
 */

@Deprecated
protected void tearDown() throws java.lang.Exception { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 3
 */

@Deprecated
public void testActivityTestCaseSetUpProperly() throws java.lang.Exception { throw new RuntimeException("Stub!"); }
}

