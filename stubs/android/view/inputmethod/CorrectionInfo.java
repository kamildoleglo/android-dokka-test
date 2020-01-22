/*
 * Copyright (C) 2007-2010 The Android Open Source Project
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
 * Information about a single text correction that an editor has reported to
 * an input method.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CorrectionInfo implements android.os.Parcelable {

/**
 * @param offset The offset in the edited text where the old and new text start.
 * @param oldText The old text that has been replaced.
 * @param newText The replacement text.
 * @apiSince 11
 */

public CorrectionInfo(int offset, java.lang.CharSequence oldText, java.lang.CharSequence newText) { throw new RuntimeException("Stub!"); }

/**
 * Return the offset position of this correction in the text. Both the {@link #getOldText()} and
 * {@link #getNewText()} start at this offset.
 * @apiSince 11
 */

public int getOffset() { throw new RuntimeException("Stub!"); }

/**
 * Return the text that has actually been typed by the user, and which has been corrected.
 * @apiSince 11
 */

public java.lang.CharSequence getOldText() { throw new RuntimeException("Stub!"); }

/**
 * Return the new text that corrects what was typed by the user.
 * @apiSince 11
 */

public java.lang.CharSequence getNewText() { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Used to package this object into a {@link android.os.Parcel Parcel}.
 *
 * @param dest The {@link android.os.Parcel Parcel} to be written.
 * @param flags The flags used for parceling.
 * @apiSince 11
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Used to make this class parcelable.
 * @apiSince 11
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.inputmethod.CorrectionInfo> CREATOR;
static { CREATOR = null; }
}

