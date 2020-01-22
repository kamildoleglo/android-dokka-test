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

import android.graphics.Bitmap;
import android.text.Spanned;

/**
 * Paragraph affecting span, that draws a bitmap at the beginning of a text. The span also allows
 * setting a padding between the bitmap and the text. The default value of the padding is 0px. The
 * span should be attached from the first character of the text.
 * <p>
 * For example, an <code>IconMarginSpan</code> with a bitmap and a padding of 30px can be set
 * like this:
 * <pre>
 * SpannableString string = new SpannableString("Text with icon and padding");
 * string.setSpan(new IconMarginSpan(bitmap, 30), 0, string.length(),
 * Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
 * </pre>
 * <img src="{@docRoot}reference/android/images/text/style/iconmarginspan.png" />
 * <figcaption>Text with <code>IconMarginSpan</code></figcaption>
 * <p>
 *
 * @see android.text.style.DrawableMarginSpan for working with a {@link android.graphics.drawable.Drawable} instead of
 * a {@link android.graphics.Bitmap Bitmap}.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class IconMarginSpan implements android.text.style.LeadingMarginSpan, android.text.style.LineHeightSpan {

/**
 * Creates an {@link android.text.style.IconMarginSpan IconMarginSpan} from a {@link android.graphics.Bitmap Bitmap}.
 *
 * @param bitmap bitmap to be rendered at the beginning of the text
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public IconMarginSpan(@androidx.annotation.NonNull android.graphics.Bitmap bitmap) { throw new RuntimeException("Stub!"); }

/**
 * Creates an {@link android.text.style.IconMarginSpan IconMarginSpan} from a {@link android.graphics.Bitmap Bitmap}.
 *
 * @param bitmap bitmap to be rendered at the beginning of the text
 * This value must never be {@code null}.
 * @param pad    padding width, in pixels, between the bitmap and the text
 
 * Value is 0 or greater
 * @apiSince 1
 */

public IconMarginSpan(@androidx.annotation.NonNull android.graphics.Bitmap bitmap, int pad) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getLeadingMargin(boolean first) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void drawLeadingMargin(android.graphics.Canvas c, android.graphics.Paint p, int x, int dir, int top, int baseline, int bottom, java.lang.CharSequence text, int start, int end, boolean first, android.text.Layout layout) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void chooseHeight(java.lang.CharSequence text, int start, int end, int istartv, int v, android.graphics.Paint.FontMetricsInt fm) { throw new RuntimeException("Stub!"); }
}

