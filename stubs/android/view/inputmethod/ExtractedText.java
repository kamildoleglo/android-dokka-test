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


package android.view.inputmethod;

import android.os.Parcel;

/**
 * Information about text that has been extracted for use by an input method.
 *
 * This contains information about a portion of the currently edited text,
 * that the IME should display into its own interface while in extracted mode.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ExtractedText implements android.os.Parcelable {

public ExtractedText() { throw new RuntimeException("Stub!"); }

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

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.inputmethod.ExtractedText> CREATOR;
static { CREATOR = null; }

/**
 * Bit for {@link #flags}: set if the editor is currently in selection mode.
 *
 * This happens when a hardware keyboard with latched keys is attached and
 * the shift key is currently latched.
 * @apiSince 3
 */

public static final int FLAG_SELECTING = 2; // 0x2

/**
 * Bit for {@link #flags}: set if the text being edited can only be on
 * a single line.
 * @apiSince 3
 */

public static final int FLAG_SINGLE_LINE = 1; // 0x1

/**
 * Additional bit flags of information about the edited text.
 * @apiSince 3
 */

public int flags;

/**
 * The hint that has been extracted.
 *
 * @see android.widget.TextView#getHint()
 * @apiSince 28
 */

public java.lang.CharSequence hint;

/**
 * If the content is a report of a partial text change, this is the offset
 * where the change ends.  Note that the actual text may be larger or
 * smaller than the difference between this and {@link #partialStartOffset},
 * meaning a reduction or increase, respectively, in the total text.
 * @apiSince 3
 */

public int partialEndOffset;

/**
 * If the content is a report of a partial text change, this is the
 * offset where the change starts and it runs until
 * {@link #partialEndOffset}.  If the content is the full text, this
 * field is -1.
 * @apiSince 3
 */

public int partialStartOffset;

/**
 * The offset where the selection currently ends within the extracted
 * text.  The real selection end position is at
 * <var>startOffset</var>+<var>selectionEnd</var>.
 * @apiSince 3
 */

public int selectionEnd;

/**
 * The offset where the selection currently starts within the extracted
 * text.  The real selection start position is at
 * <var>startOffset</var>+<var>selectionStart</var>.
 * @apiSince 3
 */

public int selectionStart;

/**
 * The offset in the overall text at which the extracted text starts.
 * @apiSince 3
 */

public int startOffset;

/**
 * The text that has been extracted.
 *
 * @see android.widget.TextView#getText()
 * @apiSince 3
 */

public java.lang.CharSequence text;
}

