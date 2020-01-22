/*
 * Copyright (C) 2008 The Android Open Source Project
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


package android.inputmethodservice;

import android.widget.EditText;

/***
 * Specialization of {@link android.widget.EditText EditText} for showing and interacting with the
 * extracted text in a full-screen input method.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ExtractEditText extends android.widget.EditText {

/** @apiSince 3 */

public ExtractEditText(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public ExtractEditText(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public ExtractEditText(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public ExtractEditText(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Start making changes that will not be reported to the client.  That
 * is, {@link #onSelectionChanged(int,int)} will not result in sending
 * the new selection to the client
 * @apiSince 3
 */

public void startInternalChanges() { throw new RuntimeException("Stub!"); }

/**
 * Finish making changes that will not be reported to the client.  That
 * is, {@link #onSelectionChanged(int,int)} will not result in sending
 * the new selection to the client
 * @apiSince 3
 */

public void finishInternalChanges() { throw new RuntimeException("Stub!"); }

/**
 * Implement just to keep track of when we are setting text from the
 * client (vs. seeing changes in ourself from the user).
 * @apiSince 3
 */

public void setExtractedText(android.view.inputmethod.ExtractedText text) { throw new RuntimeException("Stub!"); }

/**
 * Report to the underlying text editor about selection changes.
 * @apiSince 3
 */

protected void onSelectionChanged(int selStart, int selEnd) { throw new RuntimeException("Stub!"); }

/**
 * Redirect clicks to the IME for handling there.  First allows any
 * on click handler to run, though.
 * @apiSince 3
 */

public boolean performClick() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public boolean onTextContextMenuItem(int id) { throw new RuntimeException("Stub!"); }

/**
 * We are always considered to be an input method target.
 * @apiSince 3
 */

public boolean isInputMethodTarget() { throw new RuntimeException("Stub!"); }

/**
 * Return true if the edit text is currently showing a scroll bar.
 * @apiSince 3
 */

public boolean hasVerticalScrollBar() { throw new RuntimeException("Stub!"); }

/**
 * Pretend like the window this view is in always has focus, so its
 * highlight and cursor will be displayed.
 * @apiSince 3
 */

public boolean hasWindowFocus() { throw new RuntimeException("Stub!"); }

/**
 * Pretend like this view always has focus, so its
 * highlight and cursor will be displayed.
 * @apiSince 3
 */

public boolean isFocused() { throw new RuntimeException("Stub!"); }

/**
 * Pretend like this view always has focus, so its
 * highlight and cursor will be displayed.
 * @apiSince 3
 */

public boolean hasFocus() { throw new RuntimeException("Stub!"); }
}

