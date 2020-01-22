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


package android.text.method;

import android.text.Editable;

/**
 * This is the key listener for typing normal text.  It delegates to
 * other key listeners appropriate to the current keyboard and language.
 * <p></p>
 * As for all implementations of {@link android.text.method.KeyListener KeyListener}, this class is only concerned
 * with hardware keyboards.  Software input methods have no obligation to trigger
 * the methods in this class.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TextKeyListener extends android.text.method.BaseKeyListener implements android.text.SpanWatcher {

/**
 * Creates a new TextKeyListener with the specified capitalization
 * and correction properties.
 *
 * @param cap when, if ever, to automatically capitalize.
 * @param autotext whether to automatically do spelling corrections.
 * @apiSince 1
 */

public TextKeyListener(android.text.method.TextKeyListener.Capitalize cap, boolean autotext) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new or existing instance with the specified capitalization
 * and correction properties.
 *
 * @param cap when, if ever, to automatically capitalize.
 * @param autotext whether to automatically do spelling corrections.
 * @apiSince 1
 */

public static android.text.method.TextKeyListener getInstance(boolean autotext, android.text.method.TextKeyListener.Capitalize cap) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new or existing instance with no automatic capitalization
 * or correction.
 * @apiSince 1
 */

public static android.text.method.TextKeyListener getInstance() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether it makes sense to automatically capitalize at the
 * specified position in the specified text, with the specified rules.
 *
 * @param cap the capitalization rules to consider.
 * @param cs the text in which an insertion is being made.
 * @param off the offset into that text where the insertion is being made.
 *
 * @return whether the character being inserted should be capitalized.
 * @apiSince 1
 */

public static boolean shouldCap(android.text.method.TextKeyListener.Capitalize cap, java.lang.CharSequence cs, int off) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public int getInputType() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean onKeyDown(android.view.View view, android.text.Editable content, int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean onKeyUp(android.view.View view, android.text.Editable content, int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public boolean onKeyOther(android.view.View view, android.text.Editable content, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Clear all the input state (autotext, autocap, multitap, undo)
 * from the specified Editable, going beyond Editable.clear(), which
 * just clears the text but not the input state.
 *
 * @param e the buffer whose text and state are to be cleared.
 * @apiSince 1
 */

public static void clear(android.text.Editable e) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void onSpanAdded(android.text.Spannable s, java.lang.Object what, int start, int end) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void onSpanRemoved(android.text.Spannable s, java.lang.Object what, int start, int end) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void onSpanChanged(android.text.Spannable s, java.lang.Object what, int start, int end, int st, int en) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void release() { throw new RuntimeException("Stub!"); }
/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum Capitalize {
/** @apiSince 1 */

NONE,
/** @apiSince 1 */

SENTENCES,
/** @apiSince 1 */

WORDS,
/** @apiSince 1 */

CHARACTERS;
}

}

