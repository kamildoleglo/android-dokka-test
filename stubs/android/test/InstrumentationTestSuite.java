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

import junit.framework.TestSuite;
import android.app.Instrumentation;

/**
 * A {@link junit.framework.TestSuite} that injects {@link android.app.Instrumentation} into
 * {@link android.test.InstrumentationTestCase InstrumentationTestCase} before running them.
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
public class InstrumentationTestSuite extends junit.framework.TestSuite {

/**
 * @param instr The instrumentation that will be injected into each
 *   test before running it.
 * @apiSince 1
 */

@Deprecated
public InstrumentationTestSuite(android.app.Instrumentation instr) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@Deprecated
public InstrumentationTestSuite(java.lang.String name, android.app.Instrumentation instr) { throw new RuntimeException("Stub!"); }

/**
 * @param theClass Inspected for methods starting with 'test'
 * @param instr The instrumentation to inject into each test before
 *   running.
 * @apiSince 1
 */

@Deprecated
public InstrumentationTestSuite(java.lang.Class theClass, android.app.Instrumentation instr) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public void addTestSuite(java.lang.Class testClass) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public void runTest(junit.framework.Test test, junit.framework.TestResult result) { throw new RuntimeException("Stub!"); }
}

