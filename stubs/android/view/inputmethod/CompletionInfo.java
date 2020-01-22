/*
 * Copyright (C) 2007-2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */


package android.view.inputmethod;

import android.os.Parcel;

/**
 * Information about a single text completion that an editor has reported to
 * an input method.
 *
 * <p>This class encapsulates a completion offered by an application
 * that wants it to be presented to the user by the IME. Usually, apps
 * present their completions directly in a scrolling list for example
 * (UI developers will usually use or extend
 * {@see android.widget.AutoCompleteTextView} to implement this).
 * However, in some cases, the editor may not be visible, as in the
 * case in extract mode where the IME has taken over the full
 * screen. In this case, the editor can choose to send their
 * completions to the IME for display.
 *
 * <p>Most applications who want to send completions to an IME should use
 * {@link android.widget.AutoCompleteTextView} as this class makes this
 * process easy. In this case, the application would not have to deal directly
 * with this class.
 *
 * <p>An application who implements its own editor and wants direct control
 * over this would create an array of CompletionInfo objects, and send it to the IME using
 * {@link android.view.inputmethod.InputMethodManager#displayCompletions(View,android.view.inputmethod.CompletionInfo[]) InputMethodManager#displayCompletions(View, CompletionInfo[])}.
 * The IME would present the completions however they see fit, and
 * call back to the editor through
 * {@link android.view.inputmethod.InputConnection#commitCompletion(android.view.inputmethod.CompletionInfo) InputConnection#commitCompletion(CompletionInfo)}.
 * The application can then pick up the commit event by overriding
 * {@link android.widget.TextView#onCommitCompletion(CompletionInfo)}.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CompletionInfo implements android.os.Parcelable {

/**
 * Create a simple completion with just text, no label.
 *
 * @param id An id that get passed as is (to the editor's discretion)
 * @param index An index that get passed as is. Typically this is the
 * index in the list of completions inside the editor.
 * @param text The text that should be inserted into the editor when
 * this completion is chosen.
 * @apiSince 3
 */

public CompletionInfo(long id, int index, java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }

/**
 * Create a full completion with both text and label. The text is
 * what will get inserted into the editor, while the label is what
 * the IME should display. If they are the same, use the version
 * of the constructor without a `label' argument.
 *
 * @param id An id that get passed as is (to the editor's discretion)
 * @param index An index that get passed as is. Typically this is the
 * index in the list of completions inside the editor.
 * @param text The text that should be inserted into the editor when
 * this completion is chosen.
 * @param label The text that the IME should be showing among the
 * completions list.
 * @apiSince 3
 */

public CompletionInfo(long id, int index, java.lang.CharSequence text, java.lang.CharSequence label) { throw new RuntimeException("Stub!"); }

/**
 * Return the abstract identifier for this completion, typically
 * corresponding to the id associated with it in the original adapter.
 * @apiSince 3
 */

public long getId() { throw new RuntimeException("Stub!"); }

/**
 * Return the original position of this completion, typically
 * corresponding to its position in the original adapter.
 * @apiSince 3
 */

public int getPosition() { throw new RuntimeException("Stub!"); }

/**
 * Return the actual text associated with this completion.  This is the
 * real text that will be inserted into the editor if the user selects it.
 * @apiSince 3
 */

public java.lang.CharSequence getText() { throw new RuntimeException("Stub!"); }

/**
 * Return the user-visible label for the completion, or null if the plain
 * text should be shown.  If non-null, this will be what the user sees as
 * the completion option instead of the actual text.
 * @apiSince 3
 */

public java.lang.CharSequence getLabel() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Used to package this object into a {@link android.os.Parcel Parcel}.
 *
 * @param dest The {@link android.os.Parcel Parcel} to be written.
 * @param flags The flags used for parceling.
 * @apiSince 3
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Used to make this class parcelable.
 * @apiSince 3
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.inputmethod.CompletionInfo> CREATOR;
static { CREATOR = null; }
}

