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


package android.text;

import android.graphics.Paint;

/**
 * This is the class for text whose content and markup can both be changed.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SpannableStringBuilder implements java.lang.CharSequence, android.text.GetChars, android.text.Spannable, android.text.Editable, java.lang.Appendable {

/**
 * Create a new SpannableStringBuilder with empty contents
 * @apiSince 1
 */

public SpannableStringBuilder() { throw new RuntimeException("Stub!"); }

/**
 * Create a new SpannableStringBuilder containing a copy of the
 * specified text, including its spans if any.
 * @apiSince 1
 */

public SpannableStringBuilder(java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }

/**
 * Create a new SpannableStringBuilder containing a copy of the
 * specified slice of the specified text, including its spans if any.
 * @apiSince 1
 */

public SpannableStringBuilder(java.lang.CharSequence text, int start, int end) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static android.text.SpannableStringBuilder valueOf(java.lang.CharSequence source) { throw new RuntimeException("Stub!"); }

/**
 * Return the char at the specified offset within the buffer.
 * @apiSince 1
 */

public char charAt(int where) { throw new RuntimeException("Stub!"); }

/**
 * Return the number of chars in the buffer.
 * @apiSince 1
 */

public int length() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.text.SpannableStringBuilder insert(int where, java.lang.CharSequence tb, int start, int end) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.text.SpannableStringBuilder insert(int where, java.lang.CharSequence tb) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.text.SpannableStringBuilder delete(int start, int end) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void clear() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void clearSpans() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.text.SpannableStringBuilder append(java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }

/**
 * Appends the character sequence {@code text} and spans {@code what} over the appended part.
 * See {@link android.text.Spanned Spanned} for an explanation of what the flags mean.
 * @param text the character sequence to append.
 * @param what the object to be spanned over the appended text.
 * @param flags see {@link android.text.Spanned Spanned}.
 * @return this {@code SpannableStringBuilder}.
 * @apiSince 21
 */

public android.text.SpannableStringBuilder append(java.lang.CharSequence text, java.lang.Object what, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.text.SpannableStringBuilder append(java.lang.CharSequence text, int start, int end) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.text.SpannableStringBuilder append(char text) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.text.SpannableStringBuilder replace(int start, int end, java.lang.CharSequence tb) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.text.SpannableStringBuilder replace(int start, int end, java.lang.CharSequence tb, int tbstart, int tbend) { throw new RuntimeException("Stub!"); }

/**
 * Mark the specified range of text with the specified object.
 * The flags determine how the span will behave when text is
 * inserted at the start or end of the span's range.
 * @apiSince 1
 */

public void setSpan(java.lang.Object what, int start, int end, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Remove the specified markup object from the buffer.
 * @apiSince 1
 */

public void removeSpan(java.lang.Object what) { throw new RuntimeException("Stub!"); }

/**
 * Return the buffer offset of the beginning of the specified
 * markup object, or -1 if it is not attached to this buffer.
 * @apiSince 1
 */

public int getSpanStart(java.lang.Object what) { throw new RuntimeException("Stub!"); }

/**
 * Return the buffer offset of the end of the specified
 * markup object, or -1 if it is not attached to this buffer.
 * @apiSince 1
 */

public int getSpanEnd(java.lang.Object what) { throw new RuntimeException("Stub!"); }

/**
 * Return the flags of the end of the specified
 * markup object, or 0 if it is not attached to this buffer.
 * @apiSince 1
 */

public int getSpanFlags(java.lang.Object what) { throw new RuntimeException("Stub!"); }

/**
 * Return an array of the spans of the specified type that overlap
 * the specified range of the buffer.  The kind may be Object.class to get
 * a list of all the spans regardless of type.
 
 * @param kind This value may be {@code null}.
 * @apiSince 1
 */

public <T> T[] getSpans(int queryStart, int queryEnd, @androidx.annotation.Nullable java.lang.Class<T> kind) { throw new RuntimeException("Stub!"); }

/**
 * Return the next offset after <code>start</code> but less than or
 * equal to <code>limit</code> where a span of the specified type
 * begins or ends.
 * @apiSince 1
 */

public int nextSpanTransition(int start, int limit, java.lang.Class kind) { throw new RuntimeException("Stub!"); }

/**
 * Return a new CharSequence containing a copy of the specified
 * range of this buffer, including the overlapping spans.
 * @apiSince 1
 */

public java.lang.CharSequence subSequence(int start, int end) { throw new RuntimeException("Stub!"); }

/**
 * Copy the specified range of chars from this buffer into the
 * specified array, beginning at the specified offset.
 * @apiSince 1
 */

public void getChars(int start, int end, char[] dest, int destoff) { throw new RuntimeException("Stub!"); }

/**
 * Return a String containing a copy of the chars in this buffer.
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Returns the depth of TextWatcher callbacks. Returns 0 when the object is not handling
 * TextWatchers. A return value greater than 1 implies that a TextWatcher caused a change that
 * recursively triggered a TextWatcher.
 * @apiSince 23
 */

public int getTextWatcherDepth() { throw new RuntimeException("Stub!"); }

/**
 * Returns the next cursor position in the run.  This avoids placing the cursor between
 * surrogates, between characters that form conjuncts, between base characters and combining
 * marks, or within a reordering cluster.
 *
 * <p>The context is the shaping context for cursor movement, generally the bounds of the metric
 * span enclosing the cursor in the direction of movement.
 * <code>contextStart</code>, <code>contextEnd</code> and <code>offset</code> are relative to
 * the start of the string.</p>
 *
 * <p>If cursorOpt is CURSOR_AT and the offset is not a valid cursor position,
 * this returns -1.  Otherwise this will never return a value before contextStart or after
 * contextEnd.</p>
 *
 * @param contextStart the start index of the context
 * @param contextEnd the (non-inclusive) end index of the context
 * @param dir 1 if the run is RTL, otherwise 0
 * @param offset the cursor position to move from
 * @param cursorOpt how to move the cursor, one of CURSOR_AFTER,
 * CURSOR_AT_OR_AFTER, CURSOR_BEFORE,
 * CURSOR_AT_OR_BEFORE, or CURSOR_AT
 * @param p the Paint object that is requesting this information
 * @return the offset of the next position, or -1
 * @deprecated This is an internal method, refrain from using it in your code
 * @apiSince 11
 * @deprecatedSince 15
 */

@Deprecated
public int getTextRunCursor(int contextStart, int contextEnd, int dir, int offset, int cursorOpt, android.graphics.Paint p) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setFilters(android.text.InputFilter[] filters) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.text.InputFilter[] getFilters() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int hashCode() { throw new RuntimeException("Stub!"); }
}

