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
import android.widget.TextView;

/**
 * Abstract base class for key listeners.
 *
 * Provides a basic foundation for entering and editing text.
 * Subclasses should override {@link #onKeyDown} and {@link #onKeyUp} to insert
 * characters as keys are pressed.
 * <p></p>
 * As for all implementations of {@link android.text.method.KeyListener KeyListener}, this class is only concerned
 * with hardware keyboards.  Software input methods have no obligation to trigger
 * the methods in this class.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class BaseKeyListener extends android.text.method.MetaKeyKeyListener implements android.text.method.KeyListener {

public BaseKeyListener() { throw new RuntimeException("Stub!"); }

/**
 * Performs the action that happens when you press the {@link android.view.KeyEvent#KEYCODE_DEL KeyEvent#KEYCODE_DEL} key in
 * a {@link android.widget.TextView TextView}.  If there is a selection, deletes the selection; otherwise,
 * deletes the character before the cursor, if any; ALT+DEL deletes everything on
 * the line the cursor is on.
 *
 * @return true if anything was deleted; false otherwise.
 * @apiSince 1
 */

public boolean backspace(android.view.View view, android.text.Editable content, int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Performs the action that happens when you press the {@link android.view.KeyEvent#KEYCODE_FORWARD_DEL KeyEvent#KEYCODE_FORWARD_DEL}
 * key in a {@link android.widget.TextView TextView}.  If there is a selection, deletes the selection; otherwise,
 * deletes the character before the cursor, if any; ALT+FORWARD_DEL deletes everything on
 * the line the cursor is on.
 *
 * @return true if anything was deleted; false otherwise.
 * @apiSince 11
 */

public boolean forwardDelete(android.view.View view, android.text.Editable content, int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean onKeyDown(android.view.View view, android.text.Editable content, int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Base implementation handles ACTION_MULTIPLE KEYCODE_UNKNOWN by inserting
 * the event's text into the content.
 * @apiSince 3
 */

public boolean onKeyOther(android.view.View view, android.text.Editable content, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }
}

