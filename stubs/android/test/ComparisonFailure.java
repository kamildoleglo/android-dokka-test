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


/**
 * Thrown when an assert equals for Strings failed.
 *
 * @deprecated use org.junit.ComparisonFailure
 * @apiSince 1
 * @deprecatedSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class ComparisonFailure extends android.test.AssertionFailedError {

/** @apiSince 1 */

@Deprecated
public ComparisonFailure(java.lang.String message, java.lang.String expected, java.lang.String actual) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 16
 */

@Deprecated
public java.lang.String getMessage() { throw new RuntimeException("Stub!"); }
}

