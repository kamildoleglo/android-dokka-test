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
 * Description of what an input method would like from an application when
 * extract text from its input editor.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ExtractedTextRequest implements android.os.Parcelable {

public ExtractedTextRequest() { throw new RuntimeException("Stub!"); }

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

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.inputmethod.ExtractedTextRequest> CREATOR;
static { CREATOR = null; }

/**
 * Additional request flags, having the same possible values as the
 * flags parameter of {@link android.view.inputmethod.InputConnection#getTextBeforeCursor InputConnection#getTextBeforeCursor}.
 * @apiSince 3
 */

public int flags;

/**
 * Hint for the maximum number of characters to return.
 * @apiSince 3
 */

public int hintMaxChars;

/**
 * Hint for the maximum number of lines to return.
 * @apiSince 3
 */

public int hintMaxLines;

/**
 * Arbitrary integer that can be supplied in the request, which will be
 * delivered back when reporting updates.
 * @apiSince 3
 */

public int token;
}

