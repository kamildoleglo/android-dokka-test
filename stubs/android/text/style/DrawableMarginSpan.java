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

import android.graphics.drawable.Drawable;
import android.text.Spanned;

/**
 * A span which adds a drawable and a padding to the paragraph it's attached to.
 * <p>
 * If the height of the drawable is bigger than the height of the line it's attached to then the
 * line height is increased to fit the drawable. <code>DrawableMarginSpan</code> allows setting a
 * padding between the drawable and the text. The default value is 0. The span must be set from the
 * beginning of the text, otherwise either the span won't be rendered or it will be rendered
 * incorrectly.
 * <p>
 * For example, a drawable and a padding of 20px can be added like this:
 * <pre>{@code SpannableString string = new SpannableString("Text with a drawable.");
 * string.setSpan(new DrawableMarginSpan(drawable, 20), 0, string.length(),
 * Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);}</pre>
 * <img src="{@docRoot}reference/android/images/text/style/drawablemarginspan.png" />
 * <figcaption>Text with a drawable and a padding.</figcaption>
 * <p>
 *
 * @see android.text.style.IconMarginSpan for working with a {@link android.graphics.Bitmap} instead of
 * a {@link android.graphics.drawable.Drawable Drawable}.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DrawableMarginSpan implements android.text.style.LeadingMarginSpan, android.text.style.LineHeightSpan {

/**
 * Creates a {@link android.text.style.DrawableMarginSpan DrawableMarginSpan} from a {@link android.graphics.drawable.Drawable Drawable}. The pad width will be 0.
 *
 * @param drawable the drawable to be added
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public DrawableMarginSpan(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link android.text.style.DrawableMarginSpan DrawableMarginSpan} from a {@link android.graphics.drawable.Drawable Drawable} and a padding, in pixels.
 *
 * @param drawable the drawable to be added
 * This value must never be {@code null}.
 * @param pad      the distance between the drawable and the text
 * @apiSince 1
 */

public DrawableMarginSpan(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable, int pad) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getLeadingMargin(boolean first) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param c This value must never be {@code null}.
 
 * @param p This value must never be {@code null}.
 
 * @param text This value must never be {@code null}.
 
 * @param layout This value must never be {@code null}.
 * @apiSince 1
 */

public void drawLeadingMargin(@androidx.annotation.NonNull android.graphics.Canvas c, @androidx.annotation.NonNull android.graphics.Paint p, int x, int dir, int top, int baseline, int bottom, @androidx.annotation.NonNull java.lang.CharSequence text, int start, int end, boolean first, @androidx.annotation.NonNull android.text.Layout layout) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param text This value must never be {@code null}.
 
 * @param fm This value must never be {@code null}.
 * @apiSince 1
 */

public void chooseHeight(@androidx.annotation.NonNull java.lang.CharSequence text, int start, int end, int istartv, int v, @androidx.annotation.NonNull android.graphics.Paint.FontMetricsInt fm) { throw new RuntimeException("Stub!"); }
}

