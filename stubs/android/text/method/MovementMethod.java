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

import android.widget.TextView;

/**
 * Provides cursor positioning, scrolling and text selection functionality in a {@link android.widget.TextView TextView}.
 * <p>
 * The {@link android.widget.TextView TextView} delegates handling of key events, trackball motions and touches to
 * the movement method for purposes of content navigation.  The framework automatically
 * selects an appropriate movement method based on the content of the {@link android.widget.TextView TextView}.
 * </p><p>
 * This interface is intended for use by the framework; it should not be implemented
 * directly by applications.
 * </p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface MovementMethod {

/** @apiSince 1 */

public void initialize(android.widget.TextView widget, android.text.Spannable text);

/** @apiSince 1 */

public boolean onKeyDown(android.widget.TextView widget, android.text.Spannable text, int keyCode, android.view.KeyEvent event);

/** @apiSince 1 */

public boolean onKeyUp(android.widget.TextView widget, android.text.Spannable text, int keyCode, android.view.KeyEvent event);

/**
 * If the key listener wants to other kinds of key events, return true,
 * otherwise return false and the caller (i.e. the widget host)
 * will handle the key.
 * @apiSince 3
 */

public boolean onKeyOther(android.widget.TextView view, android.text.Spannable text, android.view.KeyEvent event);

/** @apiSince 1 */

public void onTakeFocus(android.widget.TextView widget, android.text.Spannable text, int direction);

/** @apiSince 1 */

public boolean onTrackballEvent(android.widget.TextView widget, android.text.Spannable text, android.view.MotionEvent event);

/** @apiSince 1 */

public boolean onTouchEvent(android.widget.TextView widget, android.text.Spannable text, android.view.MotionEvent event);

/** @apiSince 12 */

public boolean onGenericMotionEvent(android.widget.TextView widget, android.text.Spannable text, android.view.MotionEvent event);

/**
 * Returns true if this movement method allows arbitrary selection
 * of any text; false if it has no selection (like a movement method
 * that only scrolls) or a constrained selection (for example
 * limited to links.  The "Select All" menu item is disabled
 * if arbitrary selection is not allowed.
 * @apiSince 1
 */

public boolean canSelectArbitrarily();
}

