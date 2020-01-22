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
import android.test.suitebuilder.annotation.LargeTest;
import junit.framework.TestCase;
import android.os.Bundle;

/**
 * An {@link android.app.Instrumentation Instrumentation} that runs various types of {@link junit.framework.TestCase}s against
 * an Android package (application).
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about application testing, read the
 * <a href="{@docRoot}guide/topics/testing/index.html">Testing</a> developer guide.</p>
 * </div>
 *
 * <h3>Typical Usage</h3>
 * <ol>
 * <li>Write {@link junit.framework.TestCase}s that perform unit, functional, or performance tests
 * against the classes in your package.  Typically these are subclassed from:
 *   <ul><li>{@link android.test.ActivityInstrumentationTestCase2}</li>
 *   <li>{@link android.test.ActivityUnitTestCase}</li>
 *   <li>{@link android.test.AndroidTestCase}</li>
 *   <li>{@link android.test.ApplicationTestCase}</li>
 *   <li>{@link android.test.InstrumentationTestCase}</li>
 *   <li>{@link android.test.ProviderTestCase}</li>
 *   <li>{@link android.test.ServiceTestCase}</li>
 *   <li>{@link android.test.SingleLaunchActivityTestCase}</li></ul>
 * <li>Set the <code>android:targetPackage</code> attribute of the <code>&lt;instrumentation&gt;</code>
 * element in the test package's manifest. You should set the attribute value
 * to the package name of the target application under test.
 * <li>Run the instrumentation using "adb shell am instrument -w",
 * with no optional arguments, to run all tests (except performance tests).
 * <li>Run the instrumentation using "adb shell am instrument -w",
 * with the argument '-e func true' to run all functional tests. These are tests that derive from
 * {@link android.test.InstrumentationTestCase}.
 * <li>Run the instrumentation using "adb shell am instrument -w",
 * with the argument '-e unit true' to run all unit tests. These are tests that <i>do not</i>derive
 * from {@link android.test.InstrumentationTestCase} (and are not performance tests).
 * <li>Run the instrumentation using "adb shell am instrument -w",
 * with the argument '-e class' set to run an individual {@link junit.framework.TestCase}.
 * </ol>
 * <p/>
 * <b>Running all tests:</b> adb shell am instrument -w
 * com.android.foo/android.test.InstrumentationTestRunner
 * <p/>
 * <b>Running all small tests:</b> adb shell am instrument -w
 * -e size small
 * com.android.foo/android.test.InstrumentationTestRunner
 * <p/>
 * <b>Running all medium tests:</b> adb shell am instrument -w
 * -e size medium
 * com.android.foo/android.test.InstrumentationTestRunner
 * <p/>
 * <b>Running all large tests:</b> adb shell am instrument -w
 * -e size large
 * com.android.foo/android.test.InstrumentationTestRunner
 * <p/>
 * <b>Filter test run to tests with given annotation:</b> adb shell am instrument -w
 * -e annotation com.android.foo.MyAnnotation
 * com.android.foo/android.test.InstrumentationTestRunner
 * <p/>
 * If used with other options, the resulting test run will contain the union of the two options.
 * e.g. "-e size large -e annotation com.android.foo.MyAnnotation" will run only tests with both
 * the {@link android.test.suitebuilder.annotation.LargeTest LargeTest} and "com.android.foo.MyAnnotation" annotations.
 * <p/>
 * <b>Filter test run to tests <i>without</i> given annotation:</b> adb shell am instrument -w
 * -e notAnnotation com.android.foo.MyAnnotation
 * com.android.foo/android.test.InstrumentationTestRunner
 * <p/>
 * <b>Running a single testcase:</b> adb shell am instrument -w
 * -e class com.android.foo.FooTest
 * com.android.foo/android.test.InstrumentationTestRunner
 * <p/>
 * <b>Running a single test:</b> adb shell am instrument -w
 * -e class com.android.foo.FooTest#testFoo
 * com.android.foo/android.test.InstrumentationTestRunner
 * <p/>
 * <b>Running multiple tests:</b> adb shell am instrument -w
 * -e class com.android.foo.FooTest,com.android.foo.TooTest
 * com.android.foo/android.test.InstrumentationTestRunner
 * <p/>
 * <b>Running all tests in a java package:</b> adb shell am instrument -w
 * -e package com.android.foo.subpkg
 *  com.android.foo/android.test.InstrumentationTestRunner
 * <p/>
 * <b>Including performance tests:</b> adb shell am instrument -w
 * -e perf true
 * com.android.foo/android.test.InstrumentationTestRunner
 * <p/>
 * <b>To debug your tests, set a break point in your code and pass:</b>
 * -e debug true
 * <p/>
 * <b>To run in 'log only' mode</b>
 * -e log true
 * This option will load and iterate through all test classes and methods, but will bypass actual
 * test execution. Useful for quickly obtaining info on the tests to be executed by an
 * instrumentation command.
 * <p/>
 * <b>To generate EMMA code coverage:</b>
 * -e coverage true
 * Note: this requires an emma instrumented build. By default, the code coverage results file
 * will be saved in a /data/<app>/coverage.ec file, unless overridden by coverageFile flag (see
 * below)
 * <p/>
 * <b> To specify EMMA code coverage results file path:</b>
 * -e coverageFile /sdcard/myFile.ec
 * <br/>
 * in addition to the other arguments.
 * @deprecated Use
 * <a href="{@docRoot}reference/android/support/test/runner/AndroidJUnitRunner.html">
 * AndroidJUnitRunner</a> instead. New tests should be written using the
 * <a href="{@docRoot}tools/testing-support-library/index.html">Android Testing Support Library</a>.
 * @apiSince 1
 * @deprecatedSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class InstrumentationTestRunner extends android.app.Instrumentation implements android.test.TestSuiteProvider {

@Deprecated
public InstrumentationTestRunner() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public void onCreate(android.os.Bundle arguments) { throw new RuntimeException("Stub!"); }

/**
 * Get the arguments passed to this instrumentation.
 *
 * @return the Bundle object
 * @apiSince 18
 * @deprecatedSince 24
 */

@Deprecated
public android.os.Bundle getArguments() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
protected android.test.AndroidTestRunner getAndroidTestRunner() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public void onStart() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public junit.framework.TestSuite getTestSuite() { throw new RuntimeException("Stub!"); }

/**
 * Override this to define all of the tests to run in your package.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public junit.framework.TestSuite getAllTests() { throw new RuntimeException("Stub!"); }

/**
 * Override this to provide access to the class loader of your package.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public java.lang.ClassLoader getLoader() { throw new RuntimeException("Stub!"); }

/**
 * If included in the status or final bundle sent to an IInstrumentationWatcher, this key
 * identifies the name of the current test class.  This is sent with any status message
 * describing a specific test being started or completed.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated public static final java.lang.String REPORT_KEY_NAME_CLASS = "class";

/**
 * If included in the status or final bundle sent to an IInstrumentationWatcher, this key
 * identifies the name of the current test.  This is sent with any status message
 * describing a specific test being started or completed.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated public static final java.lang.String REPORT_KEY_NAME_TEST = "test";

/**
 * If included in the status or final bundle sent to an IInstrumentationWatcher, this key
 * identifies the sequence number of the current test.  This is sent with any status message
 * describing a specific test being started or completed.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated public static final java.lang.String REPORT_KEY_NUM_CURRENT = "current";

/**
 * If included in the status or final bundle sent to an IInstrumentationWatcher, this key
 * identifies the total number of tests that are being run.  This is sent with all status
 * messages.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated public static final java.lang.String REPORT_KEY_NUM_TOTAL = "numtests";

/**
 * If included in the status bundle sent to an IInstrumentationWatcher, this key
 * identifies a stack trace describing an error or failure.  This is sent with any status
 * message describing a specific test being completed.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated public static final java.lang.String REPORT_KEY_STACK = "stack";

/**
 * This value, if stored with key {@link android.app.Instrumentation#REPORT_KEY_IDENTIFIER},
 * identifies InstrumentationTestRunner as the source of the report.  This is sent with all
 * status messages.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated public static final java.lang.String REPORT_VALUE_ID = "InstrumentationTestRunner";

/**
 * The test completed with an error.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated public static final int REPORT_VALUE_RESULT_ERROR = -1; // 0xffffffff

/**
 * The test completed with a failure.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated public static final int REPORT_VALUE_RESULT_FAILURE = -2; // 0xfffffffe

/**
 * The test completed successfully.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated public static final int REPORT_VALUE_RESULT_OK = 0; // 0x0

/**
 * The test is starting.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated public static final int REPORT_VALUE_RESULT_START = 1; // 0x1
}

