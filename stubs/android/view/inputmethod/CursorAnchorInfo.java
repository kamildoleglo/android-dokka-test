/*
 * Copyright (C) 2014 The Android Open Source Project
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
import android.text.Layout;
import android.graphics.RectF;
import android.graphics.Matrix;

/**
 * Positional information about the text insertion point and characters in the composition string.
 *
 * <p>This class encapsulates locations of the text insertion point and the composition string in
 * the screen coordinates so that IMEs can render their UI components near where the text is
 * actually inserted.</p>
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CursorAnchorInfo implements android.os.Parcelable {

/** @apiSince 21 */

public CursorAnchorInfo(android.os.Parcel source) { throw new RuntimeException("Stub!"); }

/**
 * Used to package this object into a {@link android.os.Parcel Parcel}.
 *
 * @param dest The {@link android.os.Parcel Parcel} to be written.
 * @param flags The flags used for parceling.
 * @apiSince 21
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Returns the index where the selection starts.
 * @return {@code -1} if there is no selection.
 * @apiSince 21
 */

public int getSelectionStart() { throw new RuntimeException("Stub!"); }

/**
 * Returns the index where the selection ends.
 * @return {@code -1} if there is no selection.
 * @apiSince 21
 */

public int getSelectionEnd() { throw new RuntimeException("Stub!"); }

/**
 * Returns the index where the composing text starts.
 * @return {@code -1} if there is no composing text.
 * @apiSince 21
 */

public int getComposingTextStart() { throw new RuntimeException("Stub!"); }

/**
 * Returns the entire composing text.
 * @return {@code null} if there is no composition.
 * @apiSince 21
 */

public java.lang.CharSequence getComposingText() { throw new RuntimeException("Stub!"); }

/**
 * Returns the flag of the insertion marker.
 * @return the flag of the insertion marker. {@code 0} if no flag is specified.
 * @apiSince 21
 */

public int getInsertionMarkerFlags() { throw new RuntimeException("Stub!"); }

/**
 * Returns the horizontal start of the insertion marker, in the local coordinates that will
 * be transformed with {@link #getMatrix()} when rendered on the screen.
 * @return x coordinate that is compatible with {@link android.text.Layout#getPrimaryHorizontal(int) Layout#getPrimaryHorizontal(int)}.
 * Pay special care to RTL/LTR handling.
 * {@code java.lang.Float.NaN} if not specified.
 * @see android.text.Layout#getPrimaryHorizontal(int)
 * @apiSince 21
 */

public float getInsertionMarkerHorizontal() { throw new RuntimeException("Stub!"); }

/**
 * Returns the vertical top position of the insertion marker, in the local coordinates that
 * will be transformed with {@link #getMatrix()} when rendered on the screen.
 * @return y coordinate that is compatible with {@link android.text.Layout#getLineTop(int) Layout#getLineTop(int)}.
 * {@code java.lang.Float.NaN} if not specified.
 * @apiSince 21
 */

public float getInsertionMarkerTop() { throw new RuntimeException("Stub!"); }

/**
 * Returns the vertical baseline position of the insertion marker, in the local coordinates
 * that will be transformed with {@link #getMatrix()} when rendered on the screen.
 * @return y coordinate that is compatible with {@link android.text.Layout#getLineBaseline(int) Layout#getLineBaseline(int)}.
 * {@code java.lang.Float.NaN} if not specified.
 * @apiSince 21
 */

public float getInsertionMarkerBaseline() { throw new RuntimeException("Stub!"); }

/**
 * Returns the vertical bottom position of the insertion marker, in the local coordinates
 * that will be transformed with {@link #getMatrix()} when rendered on the screen.
 * @return y coordinate that is compatible with {@link android.text.Layout#getLineBottom(int) Layout#getLineBottom(int)}.
 * {@code java.lang.Float.NaN} if not specified.
 * @apiSince 21
 */

public float getInsertionMarkerBottom() { throw new RuntimeException("Stub!"); }

/**
 * Returns a new instance of {@link android.graphics.RectF RectF} that indicates the location of the character
 * specified with the index.
 * @param index index of the character in a Java chars.
 * @return the character bounds in local coordinates as a new instance of {@link android.graphics.RectF RectF}.
 * @apiSince 21
 */

public android.graphics.RectF getCharacterBounds(int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns the flags associated with the character bounds specified with the index.
 * @param index index of the character in a Java chars.
 * @return {@code 0} if no flag is specified.
 * @apiSince 21
 */

public int getCharacterBoundsFlags(int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new instance of {@link android.graphics.Matrix} that indicates the transformation
 * matrix that is to be applied other positional data in this class.
 * @return a new instance (copy) of the transformation matrix.
 * @apiSince 21
 */

public android.graphics.Matrix getMatrix() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Used to make this class parcelable.
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.inputmethod.CursorAnchorInfo> CREATOR;
static { CREATOR = null; }

/**
 * Flag for {@link #getInsertionMarkerFlags()} and {@link #getCharacterBoundsFlags(int)}: the
 * insertion marker or character bounds have at least one invisible (clipped) region.
 * @apiSince 21
 */

public static final int FLAG_HAS_INVISIBLE_REGION = 2; // 0x2

/**
 * Flag for {@link #getInsertionMarkerFlags()} and {@link #getCharacterBoundsFlags(int)}: the
 * insertion marker or character bounds have at least one visible region.
 * @apiSince 21
 */

public static final int FLAG_HAS_VISIBLE_REGION = 1; // 0x1

/**
 * Flag for {@link #getInsertionMarkerFlags()} and {@link #getCharacterBoundsFlags(int)}: the
 * insertion marker or character bounds is placed at right-to-left (RTL) character.
 * @apiSince 21
 */

public static final int FLAG_IS_RTL = 4; // 0x4
/**
 * Builder for {@link android.view.inputmethod.CursorAnchorInfo CursorAnchorInfo}. This class is not designed to be thread-safe.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Sets the text range of the selection. Calling this can be skipped if there is no
 * selection.
 * @apiSince 21
 */

public android.view.inputmethod.CursorAnchorInfo.Builder setSelectionRange(int newStart, int newEnd) { throw new RuntimeException("Stub!"); }

/**
 * Sets the text range of the composing text. Calling this can be skipped if there is
 * no composing text.
 * @param composingTextStart index where the composing text starts.
 * @param composingText the entire composing text.
 * @apiSince 21
 */

public android.view.inputmethod.CursorAnchorInfo.Builder setComposingText(int composingTextStart, java.lang.CharSequence composingText) { throw new RuntimeException("Stub!"); }

/**
 * Sets the location of the text insertion point (zero width cursor) as a rectangle in
 * local coordinates. Calling this can be skipped when there is no text insertion point;
 * however if there is an insertion point, editors must call this method.
 * @param horizontalPosition horizontal position of the insertion marker, in the local
 * coordinates that will be transformed with the transformation matrix when rendered on the
 * screen. This should be calculated or compatible with
 * {@link android.text.Layout#getPrimaryHorizontal(int) Layout#getPrimaryHorizontal(int)}.
 * @param lineTop vertical position of the insertion marker, in the local coordinates that
 * will be transformed with the transformation matrix when rendered on the screen. This
 * should be calculated or compatible with {@link android.text.Layout#getLineTop(int) Layout#getLineTop(int)}.
 * @param lineBaseline vertical position of the insertion marker, in the local coordinates
 * that will be transformed with the transformation matrix when rendered on the screen. This
 * should be calculated or compatible with {@link android.text.Layout#getLineBaseline(int) Layout#getLineBaseline(int)}.
 * @param lineBottom vertical position of the insertion marker, in the local coordinates
 * that will be transformed with the transformation matrix when rendered on the screen. This
 * should be calculated or compatible with {@link android.text.Layout#getLineBottom(int) Layout#getLineBottom(int)}.
 * @param flags flags of the insertion marker. See {@link #FLAG_HAS_VISIBLE_REGION} for
 * example.
 * @apiSince 21
 */

public android.view.inputmethod.CursorAnchorInfo.Builder setInsertionMarkerLocation(float horizontalPosition, float lineTop, float lineBaseline, float lineBottom, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Adds the bounding box of the character specified with the index.
 *
 * @param index index of the character in Java chars units. Must be specified in
 * ascending order across successive calls.
 * @param left x coordinate of the left edge of the character in local coordinates.
 * @param top y coordinate of the top edge of the character in local coordinates.
 * @param right x coordinate of the right edge of the character in local coordinates.
 * @param bottom y coordinate of the bottom edge of the character in local coordinates.
 * @param flags flags for this character bounds. See {@link #FLAG_HAS_VISIBLE_REGION},
 * {@link #FLAG_HAS_INVISIBLE_REGION} and {@link #FLAG_IS_RTL}. These flags must be
 * specified when necessary.
 * @throws java.lang.IllegalArgumentException If the index is a negative value, or not greater than
 * all of the previously called indices.
 * @apiSince 21
 */

public android.view.inputmethod.CursorAnchorInfo.Builder addCharacterBounds(int index, float left, float top, float right, float bottom, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Sets the matrix that transforms local coordinates into screen coordinates.
 * @param matrix transformation matrix from local coordinates into screen coordinates. null
 * is interpreted as an identity matrix.
 * @apiSince 21
 */

public android.view.inputmethod.CursorAnchorInfo.Builder setMatrix(android.graphics.Matrix matrix) { throw new RuntimeException("Stub!"); }

/**
 * @return {@link android.view.inputmethod.CursorAnchorInfo CursorAnchorInfo} using parameters in this {@link android.view.inputmethod.CursorAnchorInfo.Builder Builder}.
 * @throws java.lang.IllegalArgumentException if one or more positional parameters are specified but
 * the coordinate transformation matrix is not provided via {@link #setMatrix(android.graphics.Matrix)}.
 * @apiSince 21
 */

public android.view.inputmethod.CursorAnchorInfo build() { throw new RuntimeException("Stub!"); }

/**
 * Resets the internal state so that this instance can be reused to build another
 * instance of {@link android.view.inputmethod.CursorAnchorInfo CursorAnchorInfo}.
 * @apiSince 21
 */

public void reset() { throw new RuntimeException("Stub!"); }
}

}

