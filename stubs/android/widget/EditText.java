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

import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;

/**
 * A user interface element for entering and modifying text.
 * When you define an edit text widget, you must specify the
 * {@link android.R.styleable#TextView_inputType}
 * attribute. For example, for plain text input set inputType to "text":
 * <p>
 * <pre>
 * &lt;EditText
 *     android:id="@+id/plain_text_input"
 *     android:layout_height="wrap_content"
 *     android:layout_width="match_parent"
 *     android:inputType="text"/&gt;</pre>
 *
 * Choosing the input type configures the keyboard type that is shown, acceptable characters,
 * and appearance of the edit text.
 * For example, if you want to accept a secret number, like a unique pin or serial number,
 * you can set inputType to "numericPassword".
 * An inputType of "numericPassword" results in an edit text that accepts numbers only,
 * shows a numeric keyboard when focused, and masks the text that is entered for privacy.
 * <p>
 * See the <a href="{@docRoot}guide/topics/ui/controls/text.html">Text Fields</a>
 * guide for examples of other
 * {@link android.R.styleable#TextView_inputType} settings.
 * </p>
 * <p>You also can receive callbacks as a user changes text by
 * adding a {@link android.text.TextWatcher} to the edit text.
 * This is useful when you want to add auto-save functionality as changes are made,
 * or validate the format of user input, for example.
 * You add a text watcher using the {@link android.widget.TextView#addTextChangedListener TextView#addTextChangedListener} method.
 * </p>
 * <p>
 * This widget does not support auto-sizing text.
 * <p>
 * <b>XML attributes</b>
 * <p>
 * See {@link android.R.styleable#EditText EditText Attributes},
 * {@link android.R.styleable#TextView TextView Attributes},
 * {@link android.R.styleable#View View Attributes}
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class EditText extends android.widget.TextView {

/** @apiSince 1 */

public EditText(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public EditText(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public EditText(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public EditText(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean getFreezesText() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected boolean getDefaultEditable() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected android.text.method.MovementMethod getDefaultMovementMethod() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.text.Editable getText() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setText(java.lang.CharSequence text, android.widget.TextView.BufferType type) { throw new RuntimeException("Stub!"); }

/**
 * Convenience for {@link android.text.Selection#setSelection(android.text.Spannable,int,int) Selection#setSelection(Spannable, int, int)}.
 * @apiSince 1
 */

public void setSelection(int start, int stop) { throw new RuntimeException("Stub!"); }

/**
 * Convenience for {@link android.text.Selection#setSelection(android.text.Spannable,int) Selection#setSelection(Spannable, int)}.
 * @apiSince 1
 */

public void setSelection(int index) { throw new RuntimeException("Stub!"); }

/**
 * Convenience for {@link android.text.Selection#selectAll Selection#selectAll}.
 * @apiSince 1
 */

public void selectAll() { throw new RuntimeException("Stub!"); }

/**
 * Convenience for {@link android.text.Selection#extendSelection Selection#extendSelection}.
 * @apiSince 1
 */

public void extendSelection(int index) { throw new RuntimeException("Stub!"); }

/**
 * Causes words in the text that are longer than the view's width to be ellipsized instead of
 * broken in the middle. {@link android.text.TextUtils.TruncateAt#MARQUEE TextUtils.TruncateAt#MARQUEE} is not supported.
 *
 * @param ellipsis Type of ellipsis to be applied.
 * @throws java.lang.IllegalArgumentException When the value of <code>ellipsis</code> parameter is
 *      {@link android.text.TextUtils.TruncateAt#MARQUEE TextUtils.TruncateAt#MARQUEE}.
 * @see android.widget.TextView#setEllipsize(TextUtils.TruncateAt)
 * @apiSince 1
 */

public void setEllipsize(android.text.TextUtils.TruncateAt ellipsis) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }
}

