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
import android.text.TextPaint;

/**
 * Span that updates the typeface of the text it's attached to. The <code>TypefaceSpan</code> can
 * be constructed either based on a font family or based on a <code>Typeface</code>. When
 * {@link #TypefaceSpan(java.lang.String)} is used, the previous style of the <code>TextView</code> is kept.
 * When {@link #TypefaceSpan(android.graphics.Typeface)} is used, the <code>Typeface</code> style replaces the
 * <code>TextView</code>'s style.
 * <p>
 * For example, let's consider a <code>TextView</code> with
 * <code>android:textStyle="italic"</code> and a typeface created based on a font from resources,
 * with a bold style. When applying a <code>TypefaceSpan</code> based the typeface, the text will
 * only keep the bold style, overriding the <code>TextView</code>'s textStyle. When applying a
 * <code>TypefaceSpan</code> based on a font family: "monospace", the resulted text will keep the
 * italic style.
 * <pre>
 * Typeface myTypeface = Typeface.create(ResourcesCompat.getFont(context, R.font.acme),
 * Typeface.BOLD);
 * SpannableString string = new SpannableString("Text with typeface span.");
 * string.setSpan(new TypefaceSpan(myTypeface), 10, 18, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
 * string.setSpan(new TypefaceSpan("monospace"), 19, 22, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
 * </pre>
 * <img src="{@docRoot}reference/android/images/text/style/typefacespan.png" />
 * <figcaption>Text with <code>TypefaceSpan</code>s constructed based on a font from resource and
 * from a font family.</figcaption>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TypefaceSpan extends android.text.style.MetricAffectingSpan implements android.text.ParcelableSpan {

/**
 * Constructs a {@link android.text.style.TypefaceSpan TypefaceSpan} based on the font family. The previous style of the
 * TextPaint is kept. If the font family is null, the text paint is not modified.
 *
 * @param family The font family for this typeface.  Examples include
 *               "monospace", "serif", and "sans-serif"
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public TypefaceSpan(@androidx.annotation.Nullable java.lang.String family) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a {@link android.text.style.TypefaceSpan TypefaceSpan} from a {@link android.graphics.Typeface Typeface}. The previous style of the
 * TextPaint is overridden and the style of the typeface is used.
 *
 * @param typeface the typeface
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public TypefaceSpan(@androidx.annotation.NonNull android.graphics.Typeface typeface) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a {@link android.text.style.TypefaceSpan TypefaceSpan} from a  parcel.
 
 * @param src This value must never be {@code null}.
 * @apiSince 3
 */

public TypefaceSpan(@androidx.annotation.NonNull android.os.Parcel src) { throw new RuntimeException("Stub!"); }

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

/**
 * Returns the font family name set in the span.
 *
 * @return the font family name
 * This value may be {@code null}.
 * @see #TypefaceSpan(String)
 * @apiSince 1
 */

@androidx.annotation.Nullable
public java.lang.String getFamily() { throw new RuntimeException("Stub!"); }

/**
 * Returns the typeface set in the span.
 *
 * @return the typeface set
 * This value may be {@code null}.
 * @see #TypefaceSpan(Typeface)
 * @apiSince 28
 */

@androidx.annotation.Nullable
public android.graphics.Typeface getTypeface() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param ds This value must never be {@code null}.
 * @apiSince 1
 */

public void updateDrawState(@androidx.annotation.NonNull android.text.TextPaint ds) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param paint This value must never be {@code null}.
 * @apiSince 1
 */

public void updateMeasureState(@androidx.annotation.NonNull android.text.TextPaint paint) { throw new RuntimeException("Stub!"); }
}

