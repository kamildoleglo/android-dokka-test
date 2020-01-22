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

import android.app.Activity;
import android.view.ViewGroup;

/**
 * Reusable methods for generating touch events. These methods can be used with
 * InstrumentationTestCase or ActivityInstrumentationTestCase2 to simulate user interaction with
 * the application through a touch screen.
 *
 * @deprecated Use
 * <a href="{@docRoot}training/testing/ui-testing/espresso-testing.html">Espresso UI testing
 * framework</a> instead. New tests should be written using the
 * <a href="{@docRoot}tools/testing-support-library/index.html">Android Testing Support Library</a>.
 * @apiSince 1
 * @deprecatedSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class TouchUtils {

@Deprecated
public TouchUtils() { throw new RuntimeException("Stub!"); }

/**
 * Simulate touching in the center of the screen and dragging one quarter of the way down
 * @param test The test case that is being run
 *
 * @deprecated {@link android.test.ActivityInstrumentationTestCase} is deprecated in favor of
 * {@link android.test.ActivityInstrumentationTestCase2}, which provides more options for
 * configuring the Activity under test
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static void dragQuarterScreenDown(android.test.ActivityInstrumentationTestCase test) { throw new RuntimeException("Stub!"); }

/**
 * Simulate touching in the center of the screen and dragging one quarter of the way down
 * @param test The test case that is being run
 * @param activity The activity that is in the foreground of the test case
 * @apiSince 3
 * @deprecatedSince 24
 */

@Deprecated
public static void dragQuarterScreenDown(android.test.InstrumentationTestCase test, android.app.Activity activity) { throw new RuntimeException("Stub!"); }

/**
 * Simulate touching in the center of the screen and dragging one quarter of the way up
 * @param test The test case that is being run
 *
 * @deprecated {@link android.test.ActivityInstrumentationTestCase} is deprecated in favor of
 * {@link android.test.ActivityInstrumentationTestCase2}, which provides more options for
 * configuring the Activity under test
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static void dragQuarterScreenUp(android.test.ActivityInstrumentationTestCase test) { throw new RuntimeException("Stub!"); }

/**
 * Simulate touching in the center of the screen and dragging one quarter of the way up
 * @param test The test case that is being run
 * @param activity The activity that is in the foreground of the test case
 * @apiSince 3
 * @deprecatedSince 24
 */

@Deprecated
public static void dragQuarterScreenUp(android.test.InstrumentationTestCase test, android.app.Activity activity) { throw new RuntimeException("Stub!"); }

/**
 * Scroll a ViewGroup to the bottom by repeatedly calling
 * {@link #dragQuarterScreenUp(android.test.InstrumentationTestCase,android.app.Activity)}
 *
 * @param test The test case that is being run
 * @param v The ViewGroup that should be dragged
 *
 * @deprecated {@link android.test.ActivityInstrumentationTestCase} is deprecated in favor of
 * {@link android.test.ActivityInstrumentationTestCase2}, which provides more options for
 * configuring the Activity under test
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static void scrollToBottom(android.test.ActivityInstrumentationTestCase test, android.view.ViewGroup v) { throw new RuntimeException("Stub!"); }

/**
 * Scroll a ViewGroup to the bottom by repeatedly calling
 * {@link #dragQuarterScreenUp(android.test.InstrumentationTestCase,android.app.Activity)}
 *
 * @param test The test case that is being run
 * @param activity The activity that is in the foreground of the test case
 * @param v The ViewGroup that should be dragged
 * @apiSince 3
 * @deprecatedSince 24
 */

@Deprecated
public static void scrollToBottom(android.test.InstrumentationTestCase test, android.app.Activity activity, android.view.ViewGroup v) { throw new RuntimeException("Stub!"); }

/**
 * Scroll a ViewGroup to the top by repeatedly calling
 * {@link #dragQuarterScreenDown(android.test.InstrumentationTestCase,android.app.Activity)}
 *
 * @param test The test case that is being run
 * @param v The ViewGroup that should be dragged
 *
 * @deprecated {@link android.test.ActivityInstrumentationTestCase} is deprecated in favor of
 * {@link android.test.ActivityInstrumentationTestCase2}, which provides more options for
 * configuring the Activity under test
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static void scrollToTop(android.test.ActivityInstrumentationTestCase test, android.view.ViewGroup v) { throw new RuntimeException("Stub!"); }

/**
 * Scroll a ViewGroup to the top by repeatedly calling
 * {@link #dragQuarterScreenDown(android.test.InstrumentationTestCase,android.app.Activity)}
 *
 * @param test The test case that is being run
 * @param activity The activity that is in the foreground of the test case
 * @param v The ViewGroup that should be dragged
 * @apiSince 3
 * @deprecatedSince 24
 */

@Deprecated
public static void scrollToTop(android.test.InstrumentationTestCase test, android.app.Activity activity, android.view.ViewGroup v) { throw new RuntimeException("Stub!"); }

/**
 * Simulate touching the center of a view and dragging to the bottom of the screen.
 *
 * @param test The test case that is being run
 * @param v The view that should be dragged
 *
 * @deprecated {@link android.test.ActivityInstrumentationTestCase} is deprecated in favor of
 * {@link android.test.ActivityInstrumentationTestCase2}, which provides more options for
 * configuring the Activity under test
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static void dragViewToBottom(android.test.ActivityInstrumentationTestCase test, android.view.View v) { throw new RuntimeException("Stub!"); }

/**
 * Simulate touching the center of a view and dragging to the bottom of the screen.
 *
 * @param test The test case that is being run
 * @param activity The activity that is in the foreground of the test case
 * @param v The view that should be dragged
 * @apiSince 3
 * @deprecatedSince 24
 */

@Deprecated
public static void dragViewToBottom(android.test.InstrumentationTestCase test, android.app.Activity activity, android.view.View v) { throw new RuntimeException("Stub!"); }

/**
 * Simulate touching the center of a view and dragging to the bottom of the screen.
 *
 * @param test The test case that is being run
 * @param v The view that should be dragged
 * @param stepCount How many move steps to include in the drag
 *
 * @deprecated {@link android.test.ActivityInstrumentationTestCase} is deprecated in favor of
 * {@link android.test.ActivityInstrumentationTestCase2}, which provides more options for
 * configuring the Activity under test
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static void dragViewToBottom(android.test.ActivityInstrumentationTestCase test, android.view.View v, int stepCount) { throw new RuntimeException("Stub!"); }

/**
 * Simulate touching the center of a view and dragging to the bottom of the screen.
 *
 * @param test The test case that is being run
 * @param activity The activity that is in the foreground of the test case
 * @param v The view that should be dragged
 * @param stepCount How many move steps to include in the drag
 * @apiSince 3
 * @deprecatedSince 24
 */

@Deprecated
public static void dragViewToBottom(android.test.InstrumentationTestCase test, android.app.Activity activity, android.view.View v, int stepCount) { throw new RuntimeException("Stub!"); }

/**
 * Simulate touching the center of a view and releasing quickly (before the tap timeout).
 *
 * @param test The test case that is being run
 * @param v The view that should be clicked
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void tapView(android.test.InstrumentationTestCase test, android.view.View v) { throw new RuntimeException("Stub!"); }

/**
 * Simulate touching the center of a view and cancelling (so no onClick should
 * fire, etc).
 *
 * @param test The test case that is being run
 * @param v The view that should be clicked
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void touchAndCancelView(android.test.InstrumentationTestCase test, android.view.View v) { throw new RuntimeException("Stub!"); }

/**
 * Simulate touching the center of a view and releasing.
 *
 * @param test The test case that is being run
 * @param v The view that should be clicked
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static void clickView(android.test.InstrumentationTestCase test, android.view.View v) { throw new RuntimeException("Stub!"); }

/**
 * Simulate touching the center of a view, holding until it is a long press, and then releasing.
 *
 * @param test The test case that is being run
 * @param v The view that should be clicked
 *
 * @deprecated {@link android.test.ActivityInstrumentationTestCase} is deprecated in favor of
 * {@link android.test.ActivityInstrumentationTestCase2}, which provides more options for
 * configuring the Activity under test
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static void longClickView(android.test.ActivityInstrumentationTestCase test, android.view.View v) { throw new RuntimeException("Stub!"); }

/**
 * Simulate touching the center of a view, holding until it is a long press, and then releasing.
 *
 * @param test The test case that is being run
 * @param v The view that should be clicked
 * @apiSince 3
 * @deprecatedSince 24
 */

@Deprecated
public static void longClickView(android.test.InstrumentationTestCase test, android.view.View v) { throw new RuntimeException("Stub!"); }

/**
 * Simulate touching the center of a view and dragging to the top of the screen.
 *
 * @param test The test case that is being run
 * @param v The view that should be dragged
 *
 * @deprecated {@link android.test.ActivityInstrumentationTestCase} is deprecated in favor of
 * {@link android.test.ActivityInstrumentationTestCase2}, which provides more options for
 * configuring the Activity under test
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static void dragViewToTop(android.test.ActivityInstrumentationTestCase test, android.view.View v) { throw new RuntimeException("Stub!"); }

/**
 * Simulate touching the center of a view and dragging to the top of the screen.
 *
 * @param test The test case that is being run
 * @param v The view that should be dragged
 * @param stepCount How many move steps to include in the drag
 *
 * @deprecated {@link android.test.ActivityInstrumentationTestCase} is deprecated in favor of
 * {@link android.test.ActivityInstrumentationTestCase2}, which provides more options for
 * configuring the Activity under test
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static void dragViewToTop(android.test.ActivityInstrumentationTestCase test, android.view.View v, int stepCount) { throw new RuntimeException("Stub!"); }

/**
 * Simulate touching the center of a view and dragging to the top of the screen.
 *
 * @param test The test case that is being run
 * @param v The view that should be dragged
 * @apiSince 3
 * @deprecatedSince 24
 */

@Deprecated
public static void dragViewToTop(android.test.InstrumentationTestCase test, android.view.View v) { throw new RuntimeException("Stub!"); }

/**
 * Simulate touching the center of a view and dragging to the top of the screen.
 *
 * @param test The test case that is being run
 * @param v The view that should be dragged
 * @param stepCount How many move steps to include in the drag
 * @apiSince 3
 * @deprecatedSince 24
 */

@Deprecated
public static void dragViewToTop(android.test.InstrumentationTestCase test, android.view.View v, int stepCount) { throw new RuntimeException("Stub!"); }

/**
 * Simulate touching a view and dragging it by the specified amount.
 *
 * @param test The test case that is being run
 * @param v The view that should be dragged
 * @param gravity Which part of the view to use for the initial down event. A combination of
 *        (TOP, CENTER_VERTICAL, BOTTOM) and (LEFT, CENTER_HORIZONTAL, RIGHT)
 * @param deltaX Amount to drag horizontally in pixels
 * @param deltaY Amount to drag vertically in pixels
 *
 * @return distance in pixels covered by the drag
 *
 * @deprecated {@link android.test.ActivityInstrumentationTestCase} is deprecated in favor of
 * {@link android.test.ActivityInstrumentationTestCase2}, which provides more options for
 * configuring the Activity under test
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static int dragViewBy(android.test.ActivityInstrumentationTestCase test, android.view.View v, int gravity, int deltaX, int deltaY) { throw new RuntimeException("Stub!"); }

/**
 * Simulate touching a view and dragging it by the specified amount.
 *
 * @param test The test case that is being run
 * @param v The view that should be dragged
 * @param gravity Which part of the view to use for the initial down event. A combination of
 *        (TOP, CENTER_VERTICAL, BOTTOM) and (LEFT, CENTER_HORIZONTAL, RIGHT)
 * @param deltaX Amount to drag horizontally in pixels
 * @param deltaY Amount to drag vertically in pixels
 *
 * @return distance in pixels covered by the drag
 *
 * @deprecated {@link android.test.ActivityInstrumentationTestCase} is deprecated in favor of
 * {@link android.test.ActivityInstrumentationTestCase2}, which provides more options for
 * configuring the Activity under test
 * @apiSince 3
 * @deprecatedSince 15
 */

@Deprecated
public static int dragViewBy(android.test.InstrumentationTestCase test, android.view.View v, int gravity, int deltaX, int deltaY) { throw new RuntimeException("Stub!"); }

/**
 * Simulate touching a view and dragging it to a specified location.
 *
 * @param test The test case that is being run
 * @param v The view that should be dragged
 * @param gravity Which part of the view to use for the initial down event. A combination of
 *        (TOP, CENTER_VERTICAL, BOTTOM) and (LEFT, CENTER_HORIZONTAL, RIGHT)
 * @param toX Final location of the view after dragging
 * @param toY Final location of the view after dragging
 *
 * @return distance in pixels covered by the drag
 *
 * @deprecated {@link android.test.ActivityInstrumentationTestCase} is deprecated in favor of
 * {@link android.test.ActivityInstrumentationTestCase2}, which provides more options for
 * configuring the Activity under test
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static int dragViewTo(android.test.ActivityInstrumentationTestCase test, android.view.View v, int gravity, int toX, int toY) { throw new RuntimeException("Stub!"); }

/**
 * Simulate touching a view and dragging it to a specified location.
 *
 * @param test The test case that is being run
 * @param v The view that should be dragged
 * @param gravity Which part of the view to use for the initial down event. A combination of
 *        (TOP, CENTER_VERTICAL, BOTTOM) and (LEFT, CENTER_HORIZONTAL, RIGHT)
 * @param toX Final location of the view after dragging
 * @param toY Final location of the view after dragging
 *
 * @return distance in pixels covered by the drag
 * @apiSince 3
 * @deprecatedSince 24
 */

@Deprecated
public static int dragViewTo(android.test.InstrumentationTestCase test, android.view.View v, int gravity, int toX, int toY) { throw new RuntimeException("Stub!"); }

/**
 * Simulate touching a view and dragging it to a specified location. Only moves horizontally.
 *
 * @param test The test case that is being run
 * @param v The view that should be dragged
 * @param gravity Which part of the view to use for the initial down event. A combination of
 *        (TOP, CENTER_VERTICAL, BOTTOM) and (LEFT, CENTER_HORIZONTAL, RIGHT)
 * @param toX Final location of the view after dragging
 *
 * @return distance in pixels covered by the drag
 *
 * @deprecated {@link android.test.ActivityInstrumentationTestCase} is deprecated in favor of
 * {@link android.test.ActivityInstrumentationTestCase2}, which provides more options for
 * configuring the Activity under test
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static int dragViewToX(android.test.ActivityInstrumentationTestCase test, android.view.View v, int gravity, int toX) { throw new RuntimeException("Stub!"); }

/**
 * Simulate touching a view and dragging it to a specified location. Only moves horizontally.
 *
 * @param test The test case that is being run
 * @param v The view that should be dragged
 * @param gravity Which part of the view to use for the initial down event. A combination of
 *        (TOP, CENTER_VERTICAL, BOTTOM) and (LEFT, CENTER_HORIZONTAL, RIGHT)
 * @param toX Final location of the view after dragging
 *
 * @return distance in pixels covered by the drag
 * @apiSince 3
 * @deprecatedSince 24
 */

@Deprecated
public static int dragViewToX(android.test.InstrumentationTestCase test, android.view.View v, int gravity, int toX) { throw new RuntimeException("Stub!"); }

/**
 * Simulate touching a view and dragging it to a specified location. Only moves vertically.
 *
 * @param test The test case that is being run
 * @param v The view that should be dragged
 * @param gravity Which part of the view to use for the initial down event. A combination of
 *        (TOP, CENTER_VERTICAL, BOTTOM) and (LEFT, CENTER_HORIZONTAL, RIGHT)
 * @param toY Final location of the view after dragging
 *
 * @return distance in pixels covered by the drag
 *
 * @deprecated {@link android.test.ActivityInstrumentationTestCase} is deprecated in favor of
 * {@link android.test.ActivityInstrumentationTestCase2}, which provides more options for
 * configuring the Activity under test
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static int dragViewToY(android.test.ActivityInstrumentationTestCase test, android.view.View v, int gravity, int toY) { throw new RuntimeException("Stub!"); }

/**
 * Simulate touching a view and dragging it to a specified location. Only moves vertically.
 *
 * @param test The test case that is being run
 * @param v The view that should be dragged
 * @param gravity Which part of the view to use for the initial down event. A combination of
 *        (TOP, CENTER_VERTICAL, BOTTOM) and (LEFT, CENTER_HORIZONTAL, RIGHT)
 * @param toY Final location of the view after dragging
 *
 * @return distance in pixels covered by the drag
 * @apiSince 3
 * @deprecatedSince 24
 */

@Deprecated
public static int dragViewToY(android.test.InstrumentationTestCase test, android.view.View v, int gravity, int toY) { throw new RuntimeException("Stub!"); }

/**
 * Simulate touching a specific location and dragging to a new location.
 *
 * @param test The test case that is being run
 * @param fromX X coordinate of the initial touch, in screen coordinates
 * @param toX Xcoordinate of the drag destination, in screen coordinates
 * @param fromY X coordinate of the initial touch, in screen coordinates
 * @param toY Y coordinate of the drag destination, in screen coordinates
 * @param stepCount How many move steps to include in the drag
 *
 * @deprecated {@link android.test.ActivityInstrumentationTestCase} is deprecated in favor of
 * {@link android.test.ActivityInstrumentationTestCase2}, which provides more options for
 * configuring the Activity under test
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public static void drag(android.test.ActivityInstrumentationTestCase test, float fromX, float toX, float fromY, float toY, int stepCount) { throw new RuntimeException("Stub!"); }

/**
 * Simulate touching a specific location and dragging to a new location.
 *
 * @param test The test case that is being run
 * @param fromX X coordinate of the initial touch, in screen coordinates
 * @param toX Xcoordinate of the drag destination, in screen coordinates
 * @param fromY X coordinate of the initial touch, in screen coordinates
 * @param toY Y coordinate of the drag destination, in screen coordinates
 * @param stepCount How many move steps to include in the drag
 * @apiSince 3
 * @deprecatedSince 24
 */

@Deprecated
public static void drag(android.test.InstrumentationTestCase test, float fromX, float toX, float fromY, float toY, int stepCount) { throw new RuntimeException("Stub!"); }
}

