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


package android.text.style;

import android.text.Layout;

/**
 * Span that allows defining the alignment of text at the paragraph level.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface AlignmentSpan extends android.text.style.ParagraphStyle {

/**
 * Returns the alignment of the text.
 *
 * @return the text alignment
 * @apiSince 1
 */

public android.text.Layout.Alignment getAlignment();
/**
 * Default implementation of the {@link android.text.style.AlignmentSpan AlignmentSpan}.
 * <p>
 * For example, a text written in a left to right language, like English, which is by default
 * aligned to the left, can be aligned opposite to the layout direction like this:
 * <pre>{@code SpannableString string = new SpannableString("Text with opposite alignment");
 *string.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_OPPOSITE), 0,
 *string.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);}</pre>
 * <img src="{@docRoot}reference/android/images/text/style/ltralignmentspan.png" />
 * <figcaption>Align left to right text opposite to the layout direction.</figcaption>
 * <p>
 * A text written in a right to left language, like Hebrew, which is by default aligned to the
 * right, can be aligned opposite to the layout direction like this:
 * <pre>{@code SpannableString string = new SpannableString("טקסט עם יישור הפוך");
 *string.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_OPPOSITE), 0,
 *string.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);}</pre>
 * <img src="{@docRoot}reference/android/images/text/style/rtlalignmentspan.png" />
 * <figcaption>Align right to left text opposite to the layout direction.</figcaption>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Standard implements android.text.style.AlignmentSpan, android.text.ParcelableSpan {

/**
 * Constructs a {@link android.text.style.AlignmentSpan.Standard Standard} from an alignment.
 
 * @param align This value must never be {@code null}.
 * @apiSince 1
 */

public Standard(@androidx.annotation.NonNull android.text.Layout.Alignment align) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a {@link android.text.style.AlignmentSpan.Standard Standard} from a parcel.
 
 * @param src This value must never be {@code null}.
 * @apiSince 3
 */

public Standard(@androidx.annotation.NonNull android.os.Parcel src) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public int getSpanTypeId() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param dest This value must never be {@code null}.
 * @apiSince 3
 */

public void writeToParcel(@androidx.annotation.NonNull android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public android.text.Layout.Alignment getAlignment() { throw new RuntimeException("Stub!"); }
}

}

