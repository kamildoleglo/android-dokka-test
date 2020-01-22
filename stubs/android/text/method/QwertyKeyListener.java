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

import android.text.AutoText;
import android.text.Editable;

/**
 * This is the standard key listener for alphabetic input on qwerty
 * keyboards.  You should generally not need to instantiate this yourself;
 * TextKeyListener will do it for you.
 * <p></p>
 * As for all implementations of {@link android.text.method.KeyListener KeyListener}, this class is only concerned
 * with hardware keyboards.  Software input methods have no obligation to trigger
 * the methods in this class.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class QwertyKeyListener extends android.text.method.BaseKeyListener {

/** @apiSince 1 */

public QwertyKeyListener(android.text.method.TextKeyListener.Capitalize cap, boolean autoText) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new or existing instance with the specified capitalization
 * and correction properties.
 * @apiSince 1
 */

public static android.text.method.QwertyKeyListener getInstance(boolean autoText, android.text.method.TextKeyListener.Capitalize cap) { throw new RuntimeException("Stub!"); }

/**
 * Gets an instance of the listener suitable for use with full keyboards.
 * Disables auto-capitalization, auto-text and long-press initiated on-screen
 * character pickers.
 * @apiSince 11
 */

public static android.text.method.QwertyKeyListener getInstanceForFullKeyboard() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public int getInputType() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean onKeyDown(android.view.View view, android.text.Editable content, int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Marks the specified region of <code>content</code> as having
 * contained <code>original</code> prior to AutoText replacement.
 * Call this method when you have done or are about to do an
 * AutoText-style replacement on a region of text and want to let
 * the same mechanism (the user pressing DEL immediately after the
 * change) undo the replacement.
 *
 * @param content the Editable text where the replacement was made
 * @param start the start of the replaced region
 * @param end the end of the replaced region; the location of the cursor
 * @param original the text to be restored if the user presses DEL
 * @apiSince 1
 */

public static void markAsReplaced(android.text.Spannable content, int start, int end, java.lang.String original) { throw new RuntimeException("Stub!"); }
}

