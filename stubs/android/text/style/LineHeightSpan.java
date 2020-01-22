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

import android.text.TextUtils;

/**
 * The classes that affect the line height of paragraph should implement this interface.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface LineHeightSpan extends android.text.style.ParagraphStyle,  android.text.style.WrapTogetherSpan {

/**
 * Classes that implement this should define how the height is being calculated.
 *
 * @param text       the text
 * @param start      the start of the line
 * @param end        the end of the line
 * @param spanstartv the start of the span
 * @param lineHeight the line height
 * @param fm         font metrics of the paint, in integers
 * @apiSince 1
 */

public void chooseHeight(java.lang.CharSequence text, int start, int end, int spanstartv, int lineHeight, android.graphics.Paint.FontMetricsInt fm);
/**
 * Default implementation of the {@link android.text.style.LineHeightSpan LineHeightSpan}, which changes the line height of the
 * attached paragraph.
 * <p>
 * For example, a paragraph with its line height equal to 100px can be set like this:
 * <pre>
 * SpannableString string = new SpannableString("This is a multiline paragraph. This is a multiline paragraph.");
 * string.setSpan(new LineHeightSpan.Standard(100), 0, string.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
 * </pre>
 * <img src="{@docRoot}reference/android/images/text/style/lineheightspan.png" />
 * <figcaption>Text with line height set to 100 pixels.</figcaption>
 * <p>
 * Notice that LineHeightSpan will change the line height of the entire paragraph, even though it
 * covers only part of the paragraph.
 * </p>
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Standard implements android.text.style.LineHeightSpan, android.text.ParcelableSpan {

/**
 * Set the line height of the paragraph to <code>height</code> physical pixels.
 
 * @param height This units of this value are pixels.
 
 * Value is 1 or greater
 * @apiSince 29
 */

public Standard(int height) { throw new RuntimeException("Stub!"); }

/**
 * Constructor called from {@link android.text.TextUtils TextUtils} to restore the span from a parcel
 
 * @param src This value must never be {@code null}.
 * @apiSince 29
 */

public Standard(@androidx.annotation.NonNull android.os.Parcel src) { throw new RuntimeException("Stub!"); }

/**
 * Returns the line height specified by this span.
 
 * <br>
 * This units of this value are pixels.
 
 * @return This units of this value are pixels.
 * {}
 * @apiSince 29
 */

public int getHeight() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int getSpanTypeId() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param text This value must never be {@code null}.
 
 * @param fm This value must never be {@code null}.
 * @apiSince 29
 */

public void chooseHeight(@androidx.annotation.NonNull java.lang.CharSequence text, int start, int end, int spanstartv, int lineHeight, @androidx.annotation.NonNull android.graphics.Paint.FontMetricsInt fm) { throw new RuntimeException("Stub!"); }
}

/**
 * The classes that affect the line height of paragraph with respect to density,
 * should implement this interface.
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface WithDensity extends android.text.style.LineHeightSpan {

/**
 * Classes that implement this should define how the height is being calculated.
 *
 * @param text       the text
 * @param start      the start of the line
 * @param end        the end of the line
 * @param spanstartv the start of the span
 * @param lineHeight the line height
 * @param paint      the paint
 * @apiSince 5
 */

public void chooseHeight(java.lang.CharSequence text, int start, int end, int spanstartv, int lineHeight, android.graphics.Paint.FontMetricsInt fm, android.text.TextPaint paint);
}

}

