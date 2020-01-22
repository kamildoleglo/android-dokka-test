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


package android.test.suitebuilder;

import junit.framework.TestCase;

/**
 * Build suites based on a combination of included packages, excluded packages,
 * and predicates that must be satisfied.
 *
 * @deprecated New tests should be written using the
 * <a href="{@docRoot}tools/testing-support-library/index.html">Android Testing Support Library</a>.
 * @apiSince 1
 * @deprecatedSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class TestSuiteBuilder {

/**
 * The given name is automatically prefixed with the package containing the tests to be run.
 * If more than one package is specified, the first is used.
 *
 * @param clazz Use the class from your .apk. Use the class name for the test suite name.
 *              Use the class' classloader in order to load classes for testing.
 *              This is needed when running in the emulator.
 * @apiSince 1
 */

@Deprecated
public TestSuiteBuilder(java.lang.Class clazz) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@Deprecated
public TestSuiteBuilder(java.lang.String name, java.lang.ClassLoader classLoader) { throw new RuntimeException("Stub!"); }

/**
 * Include all tests that satisfy the requirements in the given packages and all sub-packages,
 * unless otherwise specified.
 *
 * @param packageNames Names of packages to add.
 * @return The builder for method chaining.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public android.test.suitebuilder.TestSuiteBuilder includePackages(java.lang.String... packageNames) { throw new RuntimeException("Stub!"); }

/**
 * Exclude all tests in the given packages and all sub-packages, unless otherwise specified.
 *
 * @param packageNames Names of packages to remove.
 * @return The builder for method chaining.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public android.test.suitebuilder.TestSuiteBuilder excludePackages(java.lang.String... packageNames) { throw new RuntimeException("Stub!"); }

/**
 * Include all junit tests that satisfy the requirements in the calling class' package and all
 * sub-packages.
 *
 * @return The builder for method chaining.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public final android.test.suitebuilder.TestSuiteBuilder includeAllPackagesUnderHere() { throw new RuntimeException("Stub!"); }

/**
 * Override the default name for the suite being built. This should generally be called if you
 * call {@code addRequirements(com.android.internal.util.Predicate[])} to make it clear which
 * tests will be included. The name you specify is automatically prefixed with the package
 * containing the tests to be run. If more than one package is specified, the first is used.
 *
 * @param newSuiteName Prefix of name to give the suite being built.
 * @return The builder for method chaining.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public android.test.suitebuilder.TestSuiteBuilder named(java.lang.String newSuiteName) { throw new RuntimeException("Stub!"); }

/**
 * Call this method once you've configured your builder as desired.
 *
 * @return The suite containing the requested tests.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public final junit.framework.TestSuite build() { throw new RuntimeException("Stub!"); }

/**
 * Subclasses use this method to determine the name of the suite.
 *
 * @return The package and suite name combined.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
protected java.lang.String getSuiteName() { throw new RuntimeException("Stub!"); }
/**
 * A special {@link junit.framework.TestCase} used to indicate a failure during the build()
 * step.
 *
 * @deprecated New tests should be written using the
 * <a href="{@docRoot}tools/testing-support-library/index.html">Android Testing Support Library</a>.
 * @apiSince 1
 * @deprecatedSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static class FailedToCreateTests extends junit.framework.TestCase {

/** @apiSince 1 */

@Deprecated
public FailedToCreateTests(java.lang.Exception exception) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public void testSuiteConstructionFailed() { throw new RuntimeException("Stub!"); }
}

}

