/*
 * Copyright (C) 2010 The Android Open Source Project
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

import android.view.KeyEvent;
import android.widget.TextView;
import android.text.Spannable;

/**
 * Base classes for movement methods.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class BaseMovementMethod implements android.text.method.MovementMethod {

public BaseMovementMethod() { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public boolean canSelectArbitrarily() { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public void initialize(android.widget.TextView widget, android.text.Spannable text) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public boolean onKeyDown(android.widget.TextView widget, android.text.Spannable text, int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public boolean onKeyOther(android.widget.TextView widget, android.text.Spannable text, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public boolean onKeyUp(android.widget.TextView widget, android.text.Spannable text, int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public void onTakeFocus(android.widget.TextView widget, android.text.Spannable text, int direction) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public boolean onTouchEvent(android.widget.TextView widget, android.text.Spannable text, android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public boolean onTrackballEvent(android.widget.TextView widget, android.text.Spannable text, android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 12 */

public boolean onGenericMotionEvent(android.widget.TextView widget, android.text.Spannable text, android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Gets the meta state used for movement using the modifiers tracked by the text
 * buffer as well as those present in the key event.
 *
 * The movement meta state excludes the state of locked modifiers or the SHIFT key
 * since they are not used by movement actions (but they may be used for selection).
 *
 * @param buffer The text buffer.
 * @param event The key event.
 * @return The keyboard meta states used for movement.
 * @apiSince 11
 */

protected int getMovementMetaState(android.text.Spannable buffer, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Performs a movement key action.
 * The default implementation decodes the key down and invokes movement actions
 * such as {@link #down} and {@link #up}.
 * {@link #onKeyDown(android.widget.TextView,android.text.Spannable,int,android.view.KeyEvent)} calls this method once
 * to handle an {@link android.view.KeyEvent#ACTION_DOWN KeyEvent#ACTION_DOWN}.
 * {@link #onKeyOther(android.widget.TextView,android.text.Spannable,android.view.KeyEvent)} calls this method repeatedly
 * to handle each repetition of an {@link android.view.KeyEvent#ACTION_MULTIPLE KeyEvent#ACTION_MULTIPLE}.
 *
 * @param widget The text view.
 * @param buffer The text buffer.
 * @param event The key event.
 * @param keyCode The key code.
 * @param movementMetaState The keyboard meta states used for movement.
 * @param event The key event.
 * @return True if the event was handled.
 * @apiSince 11
 */

protected boolean handleMovementKey(android.widget.TextView widget, android.text.Spannable buffer, int keyCode, int movementMetaState, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Performs a left movement action.
 * Moves the cursor or scrolls left by one character.
 *
 * @param widget The text view.
 * @param buffer The text buffer.
 * @return True if the event was handled.
 * @apiSince 11
 */

protected boolean left(android.widget.TextView widget, android.text.Spannable buffer) { throw new RuntimeException("Stub!"); }

/**
 * Performs a right movement action.
 * Moves the cursor or scrolls right by one character.
 *
 * @param widget The text view.
 * @param buffer The text buffer.
 * @return True if the event was handled.
 * @apiSince 11
 */

protected boolean right(android.widget.TextView widget, android.text.Spannable buffer) { throw new RuntimeException("Stub!"); }

/**
 * Performs an up movement action.
 * Moves the cursor or scrolls up by one line.
 *
 * @param widget The text view.
 * @param buffer The text buffer.
 * @return True if the event was handled.
 * @apiSince 11
 */

protected boolean up(android.widget.TextView widget, android.text.Spannable buffer) { throw new RuntimeException("Stub!"); }

/**
 * Performs a down movement action.
 * Moves the cursor or scrolls down by one line.
 *
 * @param widget The text view.
 * @param buffer The text buffer.
 * @return True if the event was handled.
 * @apiSince 11
 */

protected boolean down(android.widget.TextView widget, android.text.Spannable buffer) { throw new RuntimeException("Stub!"); }

/**
 * Performs a page-up movement action.
 * Moves the cursor or scrolls up by one page.
 *
 * @param widget The text view.
 * @param buffer The text buffer.
 * @return True if the event was handled.
 * @apiSince 11
 */

protected boolean pageUp(android.widget.TextView widget, android.text.Spannable buffer) { throw new RuntimeException("Stub!"); }

/**
 * Performs a page-down movement action.
 * Moves the cursor or scrolls down by one page.
 *
 * @param widget The text view.
 * @param buffer The text buffer.
 * @return True if the event was handled.
 * @apiSince 11
 */

protected boolean pageDown(android.widget.TextView widget, android.text.Spannable buffer) { throw new RuntimeException("Stub!"); }

/**
 * Performs a top movement action.
 * Moves the cursor or scrolls to the top of the buffer.
 *
 * @param widget The text view.
 * @param buffer The text buffer.
 * @return True if the event was handled.
 * @apiSince 11
 */

protected boolean top(android.widget.TextView widget, android.text.Spannable buffer) { throw new RuntimeException("Stub!"); }

/**
 * Performs a bottom movement action.
 * Moves the cursor or scrolls to the bottom of the buffer.
 *
 * @param widget The text view.
 * @param buffer The text buffer.
 * @return True if the event was handled.
 * @apiSince 11
 */

protected boolean bottom(android.widget.TextView widget, android.text.Spannable buffer) { throw new RuntimeException("Stub!"); }

/**
 * Performs a line-start movement action.
 * Moves the cursor or scrolls to the start of the line.
 *
 * @param widget The text view.
 * @param buffer The text buffer.
 * @return True if the event was handled.
 * @apiSince 11
 */

protected boolean lineStart(android.widget.TextView widget, android.text.Spannable buffer) { throw new RuntimeException("Stub!"); }

/**
 * Performs a line-end movement action.
 * Moves the cursor or scrolls to the end of the line.
 *
 * @param widget The text view.
 * @param buffer The text buffer.
 * @return True if the event was handled.
 * @apiSince 11
 */

protected boolean lineEnd(android.widget.TextView widget, android.text.Spannable buffer) { throw new RuntimeException("Stub!"); }

/**
 * Performs a home movement action.
 * Moves the cursor or scrolls to the start of the line or to the top of the
 * document depending on whether the insertion point is being moved or
 * the document is being scrolled.
 *
 * @param widget The text view.
 * @param buffer The text buffer.
 * @return True if the event was handled.
 * @apiSince 11
 */

protected boolean home(android.widget.TextView widget, android.text.Spannable buffer) { throw new RuntimeException("Stub!"); }

/**
 * Performs an end movement action.
 * Moves the cursor or scrolls to the start of the line or to the top of the
 * document depending on whether the insertion point is being moved or
 * the document is being scrolled.
 *
 * @param widget The text view.
 * @param buffer The text buffer.
 * @return True if the event was handled.
 * @apiSince 11
 */

protected boolean end(android.widget.TextView widget, android.text.Spannable buffer) { throw new RuntimeException("Stub!"); }
}

