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

import android.view.KeyEvent;

/**
 * For dialing-only text entry
 * <p></p>
 * As for all implementations of {@link android.text.method.KeyListener KeyListener}, this class is only concerned
 * with hardware keyboards.  Software input methods have no obligation to trigger
 * the methods in this class.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DialerKeyListener extends android.text.method.NumberKeyListener {

public DialerKeyListener() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected char[] getAcceptedChars() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static android.text.method.DialerKeyListener getInstance() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public int getInputType() { throw new RuntimeException("Stub!"); }

/**
 * Overrides the superclass's lookup method to prefer the number field
 * from the KeyEvent.
 * @apiSince 1
 */

protected int lookup(android.view.KeyEvent event, android.text.Spannable content) { throw new RuntimeException("Stub!"); }

/**
 * The characters that are used.
 *
 * @see KeyEvent#getMatch
 * @see #getAcceptedChars
 * @apiSince 1
 */

public static final char[] CHARACTERS;
static { CHARACTERS = new char[0]; }
}

