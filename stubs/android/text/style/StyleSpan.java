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

import android.graphics.Typeface;

/**
 * Span that allows setting the style of the text it's attached to.
 * Possible styles are: {@link android.graphics.Typeface#NORMAL Typeface#NORMAL}, {@link android.graphics.Typeface#BOLD Typeface#BOLD}, {@link android.graphics.Typeface#ITALIC Typeface#ITALIC} and
 * {@link android.graphics.Typeface#BOLD_ITALIC Typeface#BOLD_ITALIC}.
 * <p>
 * Note that styles are cumulative -- if both bold and italic are set in
 * separate spans, or if the base style is bold and a span calls for italic,
 * you get bold italic.  You can't turn off a style from the base style.
 * <p>
 * For example, the <code>StyleSpan</code> can be used like this:
 * <pre>
 * SpannableString string = new SpannableString("Bold and italic text");
 * string.setSpan(new StyleSpan(Typeface.BOLD), 0, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
 * string.setSpan(new StyleSpan(Typeface.ITALIC), 9, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
 * </pre>
 * <img src="{@docRoot}reference/android/images/text/style/stylespan.png" />
 * <figcaption>Text styled bold and italic with the <code>StyleSpan</code>.</figcaption>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class StyleSpan extends android.text.style.MetricAffectingSpan implements android.text.ParcelableSpan {

/**
 * Creates a {@link android.text.style.StyleSpan StyleSpan} from a style.
 *
 * @param style An integer constant describing the style for this span. Examples
 *              include bold, italic, and normal. Values are constants defined
 *              in {@link android.graphics.Typeface Typeface}.
 * @apiSince 1
 */

public StyleSpan(int style) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link android.text.style.StyleSpan StyleSpan} from a parcel.
 *
 * @param src the parcel
 
 * This value must never be {@code null}.
 * @apiSince 3
 */

public StyleSpan(@androidx.annotation.NonNull android.os.Parcel src) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public int getSpanTypeId() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Returns the style constant defined in {@link android.graphics.Typeface Typeface}.
 * @apiSince 1
 */

public int getStyle() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void updateDrawState(android.text.TextPaint ds) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void updateMeasureState(android.text.TextPaint paint) { throw new RuntimeException("Stub!"); }
}

