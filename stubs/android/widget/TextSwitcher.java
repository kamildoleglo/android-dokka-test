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


package android.widget;


/**
 * Specialized {@link android.widget.ViewSwitcher} that contains
 * only children of type {@link android.widget.TextView}.
 *
 * A TextSwitcher is useful to animate a label on screen. Whenever
 * {@link #setText(java.lang.CharSequence)} is called, TextSwitcher animates the current text
 * out and animates the new text in.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TextSwitcher extends android.widget.ViewSwitcher {

/**
 * Creates a new empty TextSwitcher.
 *
 * @param context the application's environment
 * @apiSince 1
 */

public TextSwitcher(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new empty TextSwitcher for the given context and with the
 * specified set attributes.
 *
 * @param context the application environment
 * @param attrs a collection of attributes
 * @apiSince 1
 */

public TextSwitcher(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * @throws java.lang.IllegalArgumentException if child is not an instance of
 *         {@link android.widget.TextView}
 * @apiSince 1
 */

public void addView(android.view.View child, int index, android.view.ViewGroup.LayoutParams params) { throw new RuntimeException("Stub!"); }

/**
 * Sets the text of the next view and switches to the next view. This can
 * be used to animate the old text out and animate the next text in.
 *
 * @param text the new text to display
 * @apiSince 1
 */

public void setText(java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }

/**
 * Sets the text of the text view that is currently showing.  This does
 * not perform the animations.
 *
 * @param text the new text to display
 * @apiSince 1
 */

public void setCurrentText(java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }
}

