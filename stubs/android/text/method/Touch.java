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


package android.text.method;


/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Touch {

private Touch() { throw new RuntimeException("Stub!"); }

/**
 * Scrolls the specified widget to the specified coordinates, except
 * constrains the X scrolling position to the horizontal regions of
 * the text that will be visible after scrolling to the specified
 * Y position.
 * @apiSince 1
 */

public static void scrollTo(android.widget.TextView widget, android.text.Layout layout, int x, int y) { throw new RuntimeException("Stub!"); }

/**
 * Handles touch events for dragging.  You may want to do other actions
 * like moving the cursor on touch as well.
 * @apiSince 1
 */

public static boolean onTouchEvent(android.widget.TextView widget, android.text.Spannable buffer, android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * @param widget The text view.
 * @param buffer The text buffer.
 * @apiSince 3
 */

public static int getInitialScrollX(android.widget.TextView widget, android.text.Spannable buffer) { throw new RuntimeException("Stub!"); }

/**
 * @param widget The text view.
 * @param buffer The text buffer.
 * @apiSince 3
 */

public static int getInitialScrollY(android.widget.TextView widget, android.text.Spannable buffer) { throw new RuntimeException("Stub!"); }
}

