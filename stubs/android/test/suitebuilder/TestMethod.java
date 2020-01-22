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
 * Represents a test to be run. Can be constructed without instantiating the TestCase or even
 * loading the class.
 *
 * @deprecated New tests should be written using the
 * <a href="{@docRoot}tools/testing-support-library/index.html">Android Testing Support Library</a>.
 * @apiSince 1
 * @deprecatedSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class TestMethod {

/** @apiSince 1 */

@Deprecated
public TestMethod(java.lang.reflect.Method method, java.lang.Class<? extends junit.framework.TestCase> enclosingClass) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

@Deprecated
public TestMethod(java.lang.String methodName, java.lang.Class<? extends junit.framework.TestCase> enclosingClass) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

@Deprecated
public TestMethod(junit.framework.TestCase testCase) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public java.lang.String getEnclosingClassname() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public <T extends java.lang.annotation.Annotation> T getAnnotation(java.lang.Class<T> annotationClass) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public java.lang.Class<? extends junit.framework.TestCase> getEnclosingClass() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public junit.framework.TestCase createTest() throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.reflect.InvocationTargetException { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

