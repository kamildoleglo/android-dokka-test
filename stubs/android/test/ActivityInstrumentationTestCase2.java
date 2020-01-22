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
import android.content.Intent;

/**
 * This class provides functional testing of a single activity.  The activity under test will
 * be created using the system infrastructure (by calling InstrumentationTestCase.launchActivity())
 * and you will then be able to manipulate your Activity directly.
 *
 * <p>Other options supported by this test case include:
 * <ul>
 * <li>You can run any test method on the UI thread (see {@link android.test.UiThreadTest}).</li>
 * <li>You can inject custom Intents into your Activity (see
 * {@link #setActivityIntent(android.content.Intent)}).</li>
 * </ul>
 *
 * <p>This class replaces {@link android.test.ActivityInstrumentationTestCase}, which is deprecated.
 * New tests should be written using this base class.
 *
 * <p>If you prefer an isolated unit test, see {@link android.test.ActivityUnitTestCase}.
 *
 * @deprecated Use
 * <a href="{@docRoot}reference/android/support/test/rule/ActivityTestRule.html">
 * ActivityTestRule</a> instead. New tests should be written using the
 * <a href="{@docRoot}tools/testing-support-library/index.html">Android Testing Support Library</a>.
 * @apiSince 3
 * @deprecatedSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public abstract class ActivityInstrumentationTestCase2<T extends android.app.Activity> extends android.test.ActivityTestCase {

/**
 * Creates an {@link android.test.ActivityInstrumentationTestCase2 ActivityInstrumentationTestCase2}.
 *
 * @param pkg ignored - no longer in use.
 * @param activityClass The activity to test. This must be a class in the instrumentation
 * targetPackage specified in the AndroidManifest.xml
 *
 * @deprecated use {@link #ActivityInstrumentationTestCase2(java.lang.Class)} instead
 * @apiSince 3
 */

@Deprecated
public ActivityInstrumentationTestCase2(java.lang.String pkg, java.lang.Class<T> activityClass) { throw new RuntimeException("Stub!"); }

/**
 * Creates an {@link android.test.ActivityInstrumentationTestCase2 ActivityInstrumentationTestCase2}.
 *
 * @param activityClass The activity to test. This must be a class in the instrumentation
 * targetPackage specified in the AndroidManifest.xml
 * @apiSince 8
 */

@Deprecated
public ActivityInstrumentationTestCase2(java.lang.Class<T> activityClass) { throw new RuntimeException("Stub!"); }

/**
 * Get the Activity under test, starting it if necessary.
 *
 * For each test method invocation, the Activity will not actually be created until the first
 * time this method is called.
 *
 * <p>If you wish to provide custom setup values to your Activity, you may call
 * {@link #setActivityIntent(android.content.Intent)} and/or {@link #setActivityInitialTouchMode(boolean)}
 * before your first call to getActivity().  Calling them after your Activity has
 * started will have no effect.
 *
 * <p><b>NOTE:</b> Activities under test may not be started from within the UI thread.
 * If your test method is annotated with {@link android.test.UiThreadTest}, then your Activity
 * will be started automatically just before your test method is run.  You still call this
 * method in order to get the Activity under test.
 *
 * @return the Activity under test
 * @apiSince 3
 * @deprecatedSince 24
 */

@Deprecated
public T getActivity() { throw new RuntimeException("Stub!"); }

/**
 * Call this method before the first call to {@link #getActivity} to inject a customized Intent
 * into the Activity under test.
 *
 * <p>If you do not call this, the default intent will be provided.  If you call this after
 * your Activity has been started, it will have no effect.
 *
 * <p><b>NOTE:</b> Activities under test may not be started from within the UI thread.
 * If your test method is annotated with {@link android.test.UiThreadTest}, then you must call
 * {@link #setActivityIntent(android.content.Intent)} from {@link #setUp()}.
 *
 * <p>The default Intent (if this method is not called) is:
 *  action = {@link android.content.Intent#ACTION_MAIN Intent#ACTION_MAIN}
 *  flags = {@link android.content.Intent#FLAG_ACTIVITY_NEW_TASK Intent#FLAG_ACTIVITY_NEW_TASK}
 * All other fields are null or empty.
 *
 * @param i The Intent to start the Activity with, or null to reset to the default Intent.
 * @apiSince 3
 * @deprecatedSince 24
 */

@Deprecated
public void setActivityIntent(android.content.Intent i) { throw new RuntimeException("Stub!"); }

/**
 * Call this method before the first call to {@link #getActivity} to set the initial touch
 * mode for the Activity under test.
 *
 * <p>If you do not call this, the touch mode will be false.  If you call this after
 * your Activity has been started, it will have no effect.
 *
 * <p><b>NOTE:</b> Activities under test may not be started from within the UI thread.
 * If your test method is annotated with {@link android.test.UiThreadTest}, then you must call
 * {@link #setActivityInitialTouchMode(boolean)} from {@link #setUp()}.
 *
 * @param initialTouchMode true if the Activity should be placed into "touch mode" when started
 * @apiSince 3
 * @deprecatedSince 24
 */

@Deprecated
public void setActivityInitialTouchMode(boolean initialTouchMode) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 3
 * @deprecatedSince 24
 */

@Deprecated
protected void setUp() throws java.lang.Exception { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 3
 * @deprecatedSince 24
 */

@Deprecated
protected void tearDown() throws java.lang.Exception { throw new RuntimeException("Stub!"); }

/**
 * Runs the current unit test. If the unit test is annotated with
 * {@link android.test.UiThreadTest}, force the Activity to be created before switching to
 * the UI thread.
 * @apiSince 3
 * @deprecatedSince 24
 */

@Deprecated
protected void runTest() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }
}

