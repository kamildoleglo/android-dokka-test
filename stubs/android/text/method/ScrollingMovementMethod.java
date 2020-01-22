/*
 * Copyright (C) 2006 The Android Open Source Project
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


/**
 * A movement method that interprets movement keys by scrolling the text buffer.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ScrollingMovementMethod extends android.text.method.BaseMovementMethod implements android.text.method.MovementMethod {

public ScrollingMovementMethod() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected boolean left(android.widget.TextView widget, android.text.Spannable buffer) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected boolean right(android.widget.TextView widget, android.text.Spannable buffer) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected boolean up(android.widget.TextView widget, android.text.Spannable buffer) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected boolean down(android.widget.TextView widget, android.text.Spannable buffer) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

protected boolean pageUp(android.widget.TextView widget, android.text.Spannable buffer) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

protected boolean pageDown(android.widget.TextView widget, android.text.Spannable buffer) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

protected boolean top(android.widget.TextView widget, android.text.Spannable buffer) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

protected boolean bottom(android.widget.TextView widget, android.text.Spannable buffer) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

protected boolean lineStart(android.widget.TextView widget, android.text.Spannable buffer) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

protected boolean lineEnd(android.widget.TextView widget, android.text.Spannable buffer) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

protected boolean home(android.widget.TextView widget, android.text.Spannable buffer) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

protected boolean end(android.widget.TextView widget, android.text.Spannable buffer) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean onTouchEvent(android.widget.TextView widget, android.text.Spannable buffer, android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void onTakeFocus(android.widget.TextView widget, android.text.Spannable text, int dir) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static android.text.method.MovementMethod getInstance() { throw new RuntimeException("Stub!"); }
}

