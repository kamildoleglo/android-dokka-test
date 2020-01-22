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
 * A movement method that traverses links in the text buffer and scrolls if necessary.
 * Supports clicking on links with DPad Center or Enter.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class LinkMovementMethod extends android.text.method.ScrollingMovementMethod {

public LinkMovementMethod() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean canSelectArbitrarily() { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

protected boolean handleMovementKey(android.widget.TextView widget, android.text.Spannable buffer, int keyCode, int movementMetaState, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected boolean up(android.widget.TextView widget, android.text.Spannable buffer) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected boolean down(android.widget.TextView widget, android.text.Spannable buffer) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected boolean left(android.widget.TextView widget, android.text.Spannable buffer) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected boolean right(android.widget.TextView widget, android.text.Spannable buffer) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean onTouchEvent(android.widget.TextView widget, android.text.Spannable buffer, android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void initialize(android.widget.TextView widget, android.text.Spannable text) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void onTakeFocus(android.widget.TextView view, android.text.Spannable text, int dir) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static android.text.method.MovementMethod getInstance() { throw new RuntimeException("Stub!"); }
}

