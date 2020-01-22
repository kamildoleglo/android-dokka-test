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

import android.app.Instrumentation;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;

/**
 * A test case that has access to {@link android.app.Instrumentation Instrumentation}.
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
public class InstrumentationTestCase extends junit.framework.TestCase {

@Deprecated
public InstrumentationTestCase() { throw new RuntimeException("Stub!"); }

/**
 * Injects instrumentation into this test case. This method is
 * called by the test runner during test setup.
 *
 * @param instrumentation the instrumentation to use with this instance
 * @apiSince 5
 * @deprecatedSince 24
 */

@Deprecated
public void injectInstrumentation(android.app.Instrumentation instrumentation) { throw new RuntimeException("Stub!"); }

/**
 * Injects instrumentation into this test case. This method is
 * called by the test runner during test setup.
 *
 * @param instrumentation the instrumentation to use with this instance
 *
 * @deprecated Incorrect spelling,
 * use {@link #injectInstrumentation(android.app.Instrumentation)} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public void injectInsrumentation(android.app.Instrumentation instrumentation) { throw new RuntimeException("Stub!"); }

/**
 * Inheritors can access the instrumentation using this.
 * @return instrumentation
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public android.app.Instrumentation getInstrumentation() { throw new RuntimeException("Stub!"); }

/**
 * Utility method for launching an activity.
 *
 * <p>The {@link android.content.Intent Intent} used to launch the Activity is:
 *  action = {@link android.content.Intent#ACTION_MAIN Intent#ACTION_MAIN}
 *  extras = null, unless a custom bundle is provided here
 * All other fields are null or empty.
 *
 * <p><b>NOTE:</b> The parameter <i>pkg</i> must refer to the package identifier of the
 * package hosting the activity to be launched, which is specified in the AndroidManifest.xml
 * file.  This is not necessarily the same as the java package name.
 *
 * @param pkg The package hosting the activity to be launched.
 * @param activityCls The activity class to launch.
 * @param extras Optional extra stuff to pass to the activity.
 * @return The activity, or null if non launched.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public final <T extends android.app.Activity> T launchActivity(java.lang.String pkg, java.lang.Class<T> activityCls, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Utility method for launching an activity with a specific Intent.
 *
 * <p><b>NOTE:</b> The parameter <i>pkg</i> must refer to the package identifier of the
 * package hosting the activity to be launched, which is specified in the AndroidManifest.xml
 * file.  This is not necessarily the same as the java package name.
 *
 * @param pkg The package hosting the activity to be launched.
 * @param activityCls The activity class to launch.
 * @param intent The intent to launch with
 * @return The activity, or null if non launched.
 * @apiSince 3
 * @deprecatedSince 24
 */

@Deprecated
public final <T extends android.app.Activity> T launchActivityWithIntent(java.lang.String pkg, java.lang.Class<T> activityCls, android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Helper for running portions of a test on the UI thread.
 *
 * Note, in most cases it is simpler to annotate the test method with
 * {@link android.test.UiThreadTest}, which will run the entire test method on the UI thread.
 * Use this method if you need to switch in and out of the UI thread to perform your test.
 *
 * @param r runnable containing test code in the {@link java.lang.Runnable#run() Runnable#run()} method
 * @apiSince 3
 * @deprecatedSince 24
 */

@Deprecated
public void runTestOnUiThread(java.lang.Runnable r) throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Runs the current unit test. If the unit test is annotated with
 * {@link android.test.UiThreadTest}, the test is run on the UI thread.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
protected void runTest() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Sends a series of key events through instrumentation and waits for idle. The sequence
 * of keys is a string containing the key names as specified in KeyEvent, without the
 * KEYCODE_ prefix. For instance: sendKeys("DPAD_LEFT A B C DPAD_CENTER"). Each key can
 * be repeated by using the N* prefix. For instance, to send two KEYCODE_DPAD_LEFT, use
 * the following: sendKeys("2*DPAD_LEFT").
 *
 * @param keysSequence The sequence of keys.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public void sendKeys(java.lang.String keysSequence) { throw new RuntimeException("Stub!"); }

/**
 * Sends a series of key events through instrumentation and waits for idle. For instance:
 * sendKeys(KEYCODE_DPAD_LEFT, KEYCODE_DPAD_CENTER).
 *
 * @param keys The series of key codes to send through instrumentation.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public void sendKeys(int... keys) { throw new RuntimeException("Stub!"); }

/**
 * Sends a series of key events through instrumentation and waits for idle. Each key code
 * must be preceded by the number of times the key code must be sent. For instance:
 * sendRepeatedKeys(1, KEYCODE_DPAD_CENTER, 2, KEYCODE_DPAD_LEFT).
 *
 * @param keys The series of key repeats and codes to send through instrumentation.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public void sendRepeatedKeys(int... keys) { throw new RuntimeException("Stub!"); }

/**
 * Make sure all resources are cleaned up and garbage collected before moving on to the next
 * test. Subclasses that override this method should make sure they call super.tearDown()
 * at the end of the overriding method.
 *
 * @throws java.lang.Exception
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
protected void tearDown() throws java.lang.Exception { throw new RuntimeException("Stub!"); }
}

