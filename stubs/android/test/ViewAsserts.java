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

import android.view.View;

/**
 * Some useful assertions about views.
 *
 * @deprecated Use
 * <a href="{@docRoot}reference/android/support/test/espresso/matcher/ViewMatchers.html">Espresso
 * View Matchers</a> instead. New test should be written using the
 * <a href="{@docRoot}tools/testing-support-library/index.html">Android Testing Support Library</a>.
 * For more information about UI testing, take the
 * <a href="{@docRoot}tools/testing-support-library/index.html">Espresso UI testing</a> training.
 * @apiSince 1
 * @deprecatedSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class ViewAsserts {

private ViewAsserts() { throw new RuntimeException("Stub!"); }

/**
 * Assert that view is on the screen.
 * @param origin The root view of the screen.
 * @param view The view.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertOnScreen(android.view.View origin, android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Assert that view is below the visible screen.
 * @param origin The root view of the screen.
 * @param view The view
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertOffScreenBelow(android.view.View origin, android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Assert that view is above the visible screen.
 * @param origin Te root view of the screen.
 * @param view The view
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertOffScreenAbove(android.view.View origin, android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Assert that a view has a particular x and y position on the visible screen.
 * @param origin The root view of the screen.
 * @param view The view.
 * @param x The expected x coordinate.
 * @param y The expected y coordinate.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertHasScreenCoordinates(android.view.View origin, android.view.View view, int x, int y) { throw new RuntimeException("Stub!"); }

/**
 * Assert that two views are aligned on their baseline, that is that their baselines
 * are on the same y location.
 *
 * @param first The first view
 * @param second The second view
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertBaselineAligned(android.view.View first, android.view.View second) { throw new RuntimeException("Stub!"); }

/**
 * Assert that two views are right aligned, that is that their right edges
 * are on the same x location.
 *
 * @param first The first view
 * @param second The second view
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertRightAligned(android.view.View first, android.view.View second) { throw new RuntimeException("Stub!"); }

/**
 * Assert that two views are right aligned, that is that their right edges
 * are on the same x location, with respect to the specified margin.
 *
 * @param first The first view
 * @param second The second view
 * @param margin The margin between the first view and the second view
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertRightAligned(android.view.View first, android.view.View second, int margin) { throw new RuntimeException("Stub!"); }

/**
 * Assert that two views are left aligned, that is that their left edges
 * are on the same x location.
 *
 * @param first The first view
 * @param second The second view
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertLeftAligned(android.view.View first, android.view.View second) { throw new RuntimeException("Stub!"); }

/**
 * Assert that two views are left aligned, that is that their left edges
 * are on the same x location, with respect to the specified margin.
 *
 * @param first The first view
 * @param second The second view
 * @param margin The margin between the first view and the second view
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertLeftAligned(android.view.View first, android.view.View second, int margin) { throw new RuntimeException("Stub!"); }

/**
 * Assert that two views are bottom aligned, that is that their bottom edges
 * are on the same y location.
 *
 * @param first The first view
 * @param second The second view
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertBottomAligned(android.view.View first, android.view.View second) { throw new RuntimeException("Stub!"); }

/**
 * Assert that two views are bottom aligned, that is that their bottom edges
 * are on the same y location, with respect to the specified margin.
 *
 * @param first The first view
 * @param second The second view
 * @param margin The margin between the first view and the second view
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertBottomAligned(android.view.View first, android.view.View second, int margin) { throw new RuntimeException("Stub!"); }

/**
 * Assert that two views are top aligned, that is that their top edges
 * are on the same y location.
 *
 * @param first The first view
 * @param second The second view
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertTopAligned(android.view.View first, android.view.View second) { throw new RuntimeException("Stub!"); }

/**
 * Assert that two views are top aligned, that is that their top edges
 * are on the same y location, with respect to the specified margin.
 *
 * @param first The first view
 * @param second The second view
 * @param margin The margin between the first view and the second view
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertTopAligned(android.view.View first, android.view.View second, int margin) { throw new RuntimeException("Stub!"); }

/**
 * Assert that the <code>test</code> view is horizontally center aligned
 * with respect to the <code>reference</code> view.
 *
 * @param reference The reference view
 * @param test The view that should be center aligned with the reference view
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertHorizontalCenterAligned(android.view.View reference, android.view.View test) { throw new RuntimeException("Stub!"); }

/**
 * Assert that the <code>test</code> view is vertically center aligned
 * with respect to the <code>reference</code> view.
 *
 * @param reference The reference view
 * @param test The view that should be center aligned with the reference view
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertVerticalCenterAligned(android.view.View reference, android.view.View test) { throw new RuntimeException("Stub!"); }

/**
 * Assert the specified group's integrity. The children count should be >= 0 and each
 * child should be non-null.
 *
 * @param parent The group whose integrity to check
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertGroupIntegrity(android.view.ViewGroup parent) { throw new RuntimeException("Stub!"); }

/**
 * Assert that the specified group contains a specific child once and only once.
 *
 * @param parent The group
 * @param child The child that should belong to group
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertGroupContains(android.view.ViewGroup parent, android.view.View child) { throw new RuntimeException("Stub!"); }

/**
 * Assert that the specified group does not contain a specific child.
 *
 * @param parent The group
 * @param child The child that should not belong to group
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void assertGroupNotContains(android.view.ViewGroup parent, android.view.View child) { throw new RuntimeException("Stub!"); }
}

