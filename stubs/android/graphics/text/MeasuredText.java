/*
 * Copyright (C) 2010 The Android Open Source Project
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


package android.graphics.text;

import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Result of text shaping of the single paragraph string.
 *
 * <p>
 * <pre>
 * <code>
 * Paint paint = new Paint();
 * Paint bigPaint = new Paint();
 * bigPaint.setTextSize(paint.getTextSize() * 2.0);
 * String text = "Hello, Android.";
 * MeasuredText mt = new MeasuredText.Builder(text.toCharArray())
 *      .appendStyleRun(paint, 7, false)  // Use paint for "Hello, "
 *      .appendStyleRun(bigPaint, 8, false)  // Use bigPaint for "Android."
 *      .build();
 * </code>
 * </pre>
 * </p>
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MeasuredText {

private MeasuredText() { throw new RuntimeException("Stub!"); }

/**
 * Returns the width of a given range.
 *
 * <br>
 * This units of this value are pixels.
 * @param start an inclusive start index of the range
 * Value is 0 or greater
 * @param end an exclusive end index of the range
 
 * Value is 0 or greater
 * @return Value is 0.0 or greater
 
 * This units of this value are pixels.
 * {}
 * @apiSince 29
 */

public float getWidth(int start, int end) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the boundary box of the given range
 *
 * @param start an inclusive start index of the range
 * Value is 0 or greater
 * @param end an exclusive end index of the range
 * Value is 0 or greater
 * @param rect an output parameter
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void getBounds(int start, int end, @androidx.annotation.NonNull android.graphics.Rect rect) { throw new RuntimeException("Stub!"); }

/**
 * Returns the width of the character at the given offset.
 *
 * <br>
 * This units of this value are pixels.
 * @param offset an offset of the character.
 
 * Value is 0 or greater
 * @return Value is 0.0f or greater
 
 * This units of this value are pixels.
 * {}
 * @apiSince 29
 */

public float getCharWidthAt(int offset) { throw new RuntimeException("Stub!"); }
/**
 * Helper class for creating a {@link android.graphics.text.MeasuredText MeasuredText}.
 * <p>
 * <pre>
 * <code>
 * Paint paint = new Paint();
 * String text = "Hello, Android.";
 * MeasuredText mt = new MeasuredText.Builder(text.toCharArray())
 *      .appendStyleRun(paint, text.length, false)
 *      .build();
 * </code>
 * </pre>
 * </p>
 *
 * Note: The appendStyle and appendReplacementRun should be called to cover the text length.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Construct a builder.
 *
 * The MeasuredText returned by build method will hold a reference of the text. Developer is
 * not supposed to modify the text.
 *
 * @param text a text
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public Builder(@androidx.annotation.NonNull char[] text) { throw new RuntimeException("Stub!"); }

/**
 * Construct a builder with existing MeasuredText.
 *
 * The MeasuredText returned by build method will hold a reference of the text. Developer is
 * not supposed to modify the text.
 *
 * @param text a text
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public Builder(@androidx.annotation.NonNull android.graphics.text.MeasuredText text) { throw new RuntimeException("Stub!"); }

/**
 * Apply styles to the given length.
 *
 * Keeps an internal offset which increases at every append. The initial value for this
 * offset is zero. After the style is applied the internal offset is moved to {@code offset
 * + length}, and next call will start from this new position.
 *
 * @param paint a paint
 * This value must never be {@code null}.
 * @param length a length to be applied with a given paint, can not exceed the length of the
 *               text
 * Value is 0 or greater
 * @param isRtl true if the text is in RTL context, otherwise false.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.text.MeasuredText.Builder appendStyleRun(@androidx.annotation.NonNull android.graphics.Paint paint, int length, boolean isRtl) { throw new RuntimeException("Stub!"); }

/**
 * Used to inform the text layout that the given length is replaced with the object of given
 * width.
 *
 * Keeps an internal offset which increases at every append. The initial value for this
 * offset is zero. After the style is applied the internal offset is moved to {@code offset
 * + length}, and next call will start from this new position.
 *
 * Informs the layout engine that the given length should not be processed, instead the
 * provided width should be used for calculating the width of that range.
 *
 * @param length a length to be replaced with the object, can not exceed the length of the
 *               text
 * Value is 0 or greater
 * @param width a replacement width of the range
 
 * This units of this value are pixels.
 * Value is 0 or greater
 * @param paint This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.text.MeasuredText.Builder appendReplacementRun(@androidx.annotation.NonNull android.graphics.Paint paint, int length, float width) { throw new RuntimeException("Stub!"); }

/**
 * By passing true to this method, the build method will compute all possible hyphenation
 * pieces as well.
 *
 * If you don't want to use automatic hyphenation, you can pass false to this method and
 * save the computation time of hyphenation. The default value is false.
 *
 * Even if you pass false to this method, you can still enable automatic hyphenation of
 * LineBreaker but line break computation becomes slower.
 *
 * @param computeHyphenation true if you want to use automatic hyphenations.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.text.MeasuredText.Builder setComputeHyphenation(boolean computeHyphenation) { throw new RuntimeException("Stub!"); }

/**
 * By passing true to this method, the build method will compute all full layout
 * information.
 *
 * If you don't use {@link android.graphics.text.MeasuredText#getBounds(int,int,android.graphics.Rect) MeasuredText#getBounds(int,int,android.graphics.Rect)}, you can
 * pass false to this method and save the memory spaces. The default value is true.
 *
 * Even if you pass false to this method, you can still call getBounds but it becomes
 * slower.
 *
 * @param computeLayout true if you want to retrieve full layout info, e.g. bbox.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.text.MeasuredText.Builder setComputeLayout(boolean computeLayout) { throw new RuntimeException("Stub!"); }

/**
 * Creates a MeasuredText.
 *
 * Once you called build() method, you can't reuse the Builder class again.
 * @throws java.lang.IllegalStateException if this Builder is reused.
 * @throws java.lang.IllegalStateException if the whole text is not covered by one or more runs (style
 *                               or replacement)
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.text.MeasuredText build() { throw new RuntimeException("Stub!"); }
}

}

