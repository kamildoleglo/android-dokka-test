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

import java.util.regex.Pattern;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.Map;

/**
 * Contains additional assertion methods not found in JUnit.
 * @deprecated Use
 * <a href="https://github.com/hamcrest">Hamcrest matchers</a> instead.
 * @apiSince 1
 * @deprecatedSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public final class MoreAsserts {

private MoreAsserts() { throw new RuntimeException("Stub!"); }

/**
 * Asserts that the class  {@code expected} is assignable from the object
 * {@code actual}. This verifies {@code expected} is a parent class or a
 * interface that {@code actual} implements.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertAssignableFrom(java.lang.Class<?> expected, java.lang.Object actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that class {@code expected} is assignable from the class
 * {@code actual}. This verifies {@code expected} is a parent class or a
 * interface that {@code actual} implements.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertAssignableFrom(java.lang.Class<?> expected, java.lang.Class<?> actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that {@code actual} is not equal {@code unexpected}, according
 * to both {@code ==} and {@link java.lang.Object#equals Object#equals}.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertNotEqual(java.lang.String message, java.lang.Object unexpected, java.lang.Object actual) { throw new RuntimeException("Stub!"); }

/**
 * Variant of {@link #assertNotEqual(java.lang.String,java.lang.Object,java.lang.Object)} using a
 * generic message.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertNotEqual(java.lang.Object unexpected, java.lang.Object actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that array {@code actual} is the same size and every element equals
 * those in array {@code expected}. On failure, message indicates specific
 * element mismatch.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertEquals(java.lang.String message, byte[] expected, byte[] actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that array {@code actual} is the same size and every element equals
 * those in array {@code expected}. On failure, message indicates specific
 * element mismatch.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertEquals(byte[] expected, byte[] actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that array {@code actual} is the same size and every element equals
 * those in array {@code expected}. On failure, message indicates first
 * specific element mismatch.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertEquals(java.lang.String message, int[] expected, int[] actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that array {@code actual} is the same size and every element equals
 * those in array {@code expected}. On failure, message indicates first
 * specific element mismatch.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertEquals(int[] expected, int[] actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that array {@code actual} is the same size and every element equals
 * those in array {@code expected}. On failure, message indicates first
 * specific element mismatch.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertEquals(java.lang.String message, double[] expected, double[] actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that array {@code actual} is the same size and every element equals
 * those in array {@code expected}. On failure, message indicates first
 * specific element mismatch.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertEquals(double[] expected, double[] actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that array {@code actual} is the same size and every element
 * is the same as those in array {@code expected}. Note that this uses
 * {@code equals()} instead of {@code ==} to compare the objects.
 * {@code null} will be considered equal to {@code null} (unlike SQL).
 * On failure, message indicates first specific element mismatch.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertEquals(java.lang.String message, java.lang.Object[] expected, java.lang.Object[] actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that array {@code actual} is the same size and every element
 * is the same as those in array {@code expected}. Note that this uses
 * {@code ==} instead of {@code equals()} to compare the objects.
 * On failure, message indicates first specific element mismatch.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertEquals(java.lang.Object[] expected, java.lang.Object[] actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that two sets contain the same elements.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertEquals(java.lang.String message, java.util.Set<?> expected, java.util.Set<?> actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that two sets contain the same elements.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertEquals(java.util.Set<?> expected, java.util.Set<?> actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that {@code expectedRegex} exactly matches {@code actual} and
 * fails with {@code message} if it does not.  The MatchResult is returned
 * in case the test needs access to any captured groups.  Note that you can
 * also use this for a literal string, by wrapping your expected string in
 * {@link java.util.regex.Pattern#quote Pattern#quote}.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static java.util.regex.MatchResult assertMatchesRegex(java.lang.String message, java.lang.String expectedRegex, java.lang.String actual) { throw new RuntimeException("Stub!"); }

/**
 * Variant of {@link #assertMatchesRegex(java.lang.String,java.lang.String,java.lang.String)} using a
 * generic message.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static java.util.regex.MatchResult assertMatchesRegex(java.lang.String expectedRegex, java.lang.String actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that {@code expectedRegex} matches any substring of {@code actual}
 * and fails with {@code message} if it does not.  The Matcher is returned in
 * case the test needs access to any captured groups.  Note that you can also
 * use this for a literal string, by wrapping your expected string in
 * {@link java.util.regex.Pattern#quote Pattern#quote}.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static java.util.regex.MatchResult assertContainsRegex(java.lang.String message, java.lang.String expectedRegex, java.lang.String actual) { throw new RuntimeException("Stub!"); }

/**
 * Variant of {@link #assertContainsRegex(java.lang.String,java.lang.String,java.lang.String)} using a
 * generic message.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static java.util.regex.MatchResult assertContainsRegex(java.lang.String expectedRegex, java.lang.String actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that {@code expectedRegex} does not exactly match {@code actual},
 * and fails with {@code message} if it does. Note that you can also use
 * this for a literal string, by wrapping your expected string in
 * {@link java.util.regex.Pattern#quote Pattern#quote}.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertNotMatchesRegex(java.lang.String message, java.lang.String expectedRegex, java.lang.String actual) { throw new RuntimeException("Stub!"); }

/**
 * Variant of {@link #assertNotMatchesRegex(java.lang.String,java.lang.String,java.lang.String)} using a
 * generic message.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertNotMatchesRegex(java.lang.String expectedRegex, java.lang.String actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that {@code expectedRegex} does not match any substring of
 * {@code actual}, and fails with {@code message} if it does.  Note that you
 * can also use this for a literal string, by wrapping your expected string
 * in {@link java.util.regex.Pattern#quote Pattern#quote}.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertNotContainsRegex(java.lang.String message, java.lang.String expectedRegex, java.lang.String actual) { throw new RuntimeException("Stub!"); }

/**
 * Variant of {@link #assertNotContainsRegex(java.lang.String,java.lang.String,java.lang.String)} using a
 * generic message.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertNotContainsRegex(java.lang.String expectedRegex, java.lang.String actual) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that {@code actual} contains precisely the elements
 * {@code expected}, and in the same order.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertContentsInOrder(java.lang.String message, java.lang.Iterable<?> actual, java.lang.Object... expected) { throw new RuntimeException("Stub!"); }

/**
 * Variant of assertContentsInOrder(String, Iterable<?>, Object...)
 * using a generic message.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertContentsInOrder(java.lang.Iterable<?> actual, java.lang.Object... expected) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that {@code actual} contains precisely the elements
 * {@code expected}, but in any order.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertContentsInAnyOrder(java.lang.String message, java.lang.Iterable<?> actual, java.lang.Object... expected) { throw new RuntimeException("Stub!"); }

/**
 * Variant of assertContentsInAnyOrder(String, Iterable<?>, Object...)
 * using a generic message.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertContentsInAnyOrder(java.lang.Iterable<?> actual, java.lang.Object... expected) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that {@code iterable} is empty.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertEmpty(java.lang.String message, java.lang.Iterable<?> iterable) { throw new RuntimeException("Stub!"); }

/**
 * Variant of {@link #assertEmpty(java.lang.String,java.lang.Iterable)} using a
 * generic message.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertEmpty(java.lang.Iterable<?> iterable) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that {@code map} is empty.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertEmpty(java.lang.String message, java.util.Map<?,?> map) { throw new RuntimeException("Stub!"); }

/**
 * Variant of {@link #assertEmpty(java.lang.String,java.util.Map)} using a generic
 * message.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertEmpty(java.util.Map<?,?> map) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that {@code iterable} is not empty.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertNotEmpty(java.lang.String message, java.lang.Iterable<?> iterable) { throw new RuntimeException("Stub!"); }

/**
 * Variant of assertNotEmpty(String, Iterable<?>)
 * using a generic message.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertNotEmpty(java.lang.Iterable<?> iterable) { throw new RuntimeException("Stub!"); }

/**
 * Asserts that {@code map} is not empty.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertNotEmpty(java.lang.String message, java.util.Map<?,?> map) { throw new RuntimeException("Stub!"); }

/**
 * Variant of {@link #assertNotEmpty(java.lang.String,java.util.Map)} using a generic
 * message.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertNotEmpty(java.util.Map<?,?> map) { throw new RuntimeException("Stub!"); }

/**
 * Utility for testing equals() and hashCode() results at once.
 * Tests that lhs.equals(rhs) matches expectedResult, as well as
 * rhs.equals(lhs).  Also tests that hashCode() return values are
 * equal if expectedResult is true.  (hashCode() is not tested if
 * expectedResult is false, as unequal objects can have equal hashCodes.)
 *
 * @param lhs An Object for which equals() and hashCode() are to be tested.
 * @param rhs As lhs.
 * @param expectedResult True if the objects should compare equal,
 *   false if not.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void checkEqualsAndHashCodeMethods(java.lang.String message, java.lang.Object lhs, java.lang.Object rhs, boolean expectedResult) { throw new RuntimeException("Stub!"); }

/**
 * Variant of
 * checkEqualsAndHashCodeMethods(String,Object,Object,boolean...)}
 * using a generic message.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void checkEqualsAndHashCodeMethods(java.lang.Object lhs, java.lang.Object rhs, boolean expectedResult) { throw new RuntimeException("Stub!"); }
}

