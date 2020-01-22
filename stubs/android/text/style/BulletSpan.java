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

import android.text.Spanned;

/**
 * A span which styles paragraphs as bullet points (respecting layout direction).
 * <p>
 * BulletSpans must be attached from the first character to the last character of a single
 * paragraph, otherwise the bullet point will not be displayed but the first paragraph encountered
 * will have a leading margin.
 * <p>
 * BulletSpans allow configuring the following elements:
 * <ul>
 * <li><b>gap width</b> - the distance, in pixels, between the bullet point and the paragraph.
 * Default value is 2px.</li>
 * <li><b>color</b> - the bullet point color. By default, the bullet point color is 0 - no color,
 * so it uses the TextView's text color.</li>
 * <li><b>bullet radius</b> - the radius, in pixels, of the bullet point. Default value is
 * 4px.</li>
 * </ul>
 * For example, a BulletSpan using the default values can be constructed like this:
 * <pre>{@code
 *  SpannableString string = new SpannableString("Text with\nBullet point");
 *string.setSpan(new BulletSpan(), 10, 22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);}</pre>
 * <img src="{@docRoot}reference/android/images/text/style/defaultbulletspan.png" />
 * <figcaption>BulletSpan constructed with default values.</figcaption>
 * <p>
 * <p>
 * To construct a BulletSpan with a gap width of 40px, green bullet point and bullet radius of
 * 20px:
 * <pre>{@code
 *  SpannableString string = new SpannableString("Text with\nBullet point");
 *string.setSpan(new BulletSpan(40, color, 20), 10, 22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);}</pre>
 * <img src="{@docRoot}reference/android/images/text/style/custombulletspan.png" />
 * <figcaption>Customized BulletSpan.</figcaption>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class BulletSpan implements android.text.style.LeadingMarginSpan, android.text.ParcelableSpan {

/**
 * Creates a {@link android.text.style.BulletSpan BulletSpan} with the default values.
 * @apiSince 1
 */

public BulletSpan() { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link android.text.style.BulletSpan BulletSpan} based on a gap width
 *
 * @param gapWidth the distance, in pixels, between the bullet point and the paragraph.
 * @apiSince 1
 */

public BulletSpan(int gapWidth) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link android.text.style.BulletSpan BulletSpan} based on a gap width and a color integer.
 *
 * @param gapWidth the distance, in pixels, between the bullet point and the paragraph.
 * @param color    the bullet point color, as a color integer
 * @see android.content.res.Resources#getColor(int, Resources.Theme)
 * @apiSince 1
 */

public BulletSpan(int gapWidth, int color) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link android.text.style.BulletSpan BulletSpan} based on a gap width and a color integer.
 *
 * @param gapWidth     the distance, in pixels, between the bullet point and the paragraph.
 * @param color        the bullet point color, as a color integer.
 * @param bulletRadius the radius of the bullet point, in pixels.
 * Value is 0 or greater
 * @see android.content.res.Resources#getColor(int, Resources.Theme)
 * @apiSince 28
 */

public BulletSpan(int gapWidth, int color, int bulletRadius) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link android.text.style.BulletSpan BulletSpan} from a parcel.
 
 * @param src This value must never be {@code null}.
 * @apiSince 3
 */

public BulletSpan(@androidx.annotation.NonNull android.os.Parcel src) { throw new RuntimeException("Stub!"); }

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

public int getLeadingMargin(boolean first) { throw new RuntimeException("Stub!"); }

/**
 * Get the distance, in pixels, between the bullet point and the paragraph.
 *
 * @return the distance, in pixels, between the bullet point and the paragraph.
 * @apiSince 28
 */

public int getGapWidth() { throw new RuntimeException("Stub!"); }

/**
 * Get the radius, in pixels, of the bullet point.
 *
 * @return the radius, in pixels, of the bullet point.
 * @apiSince 28
 */

public int getBulletRadius() { throw new RuntimeException("Stub!"); }

/**
 * Get the bullet point color.
 *
 * @return the bullet point color
 * @apiSince 28
 */

public int getColor() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param canvas This value must never be {@code null}.
 
 * @param paint This value must never be {@code null}.
 
 * @param text This value must never be {@code null}.
 
 * @param layout This value may be {@code null}.
 * @apiSince 1
 */

public void drawLeadingMargin(@androidx.annotation.NonNull android.graphics.Canvas canvas, @androidx.annotation.NonNull android.graphics.Paint paint, int x, int dir, int top, int baseline, int bottom, @androidx.annotation.NonNull java.lang.CharSequence text, int start, int end, boolean first, @androidx.annotation.Nullable android.text.Layout layout) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static final int STANDARD_GAP_WIDTH = 2; // 0x2
}

