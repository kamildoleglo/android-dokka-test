/*
 * Copyright (C) 2017 The Android Open Source Project
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

import android.text.style.MetricAffectingSpan;

/**
 * A text which has the character metrics data.
 *
 * A text object that contains the character metrics data and can be used to improve the performance
 * of text layout operations. When a PrecomputedText is created with a given {@link java.lang.CharSequence CharSequence},
 * it will measure the text metrics during the creation. This PrecomputedText instance can be set on
 * {@link android.widget.TextView} or {@link android.text.StaticLayout StaticLayout}. Since the text layout information will
 * be included in this instance, {@link android.widget.TextView} or {@link android.text.StaticLayout StaticLayout} will not
 * have to recalculate this information.
 *
 * Note that the {@link android.text.PrecomputedText PrecomputedText} created from different parameters of the target {@link
 * android.widget.TextView} will be rejected internally and compute the text layout again with the
 * current {@link android.widget.TextView} parameters.
 *
 * <pre>
 * An example usage is:
 * <code>
 *  static void asyncSetText(TextView textView, final String longString, Executor bgExecutor) {
 *      // construct precompute related parameters using the TextView that we will set the text on.
 *      final PrecomputedText.Params params = textView.getTextMetricsParams();
 *      final Reference textViewRef = new WeakReference<>(textView);
 *      bgExecutor.submit(() -> {
 *          TextView textView = textViewRef.get();
 *          if (textView == null) return;
 *          final PrecomputedText precomputedText = PrecomputedText.create(longString, params);
 *          textView.post(() -> {
 *              TextView textView = textViewRef.get();
 *              if (textView == null) return;
 *              textView.setText(precomputedText);
 *          });
 *      });
 *  }
 * </code>
 * </pre>
 *
 * Note that the {@link android.text.PrecomputedText PrecomputedText} created from different parameters of the target
 * {@link android.widget.TextView} will be rejected.
 *
 * Note that any {@link android.text.NoCopySpan} attached to the original text won't be passed to
 * PrecomputedText.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PrecomputedText implements android.text.Spannable {

private PrecomputedText() { throw new RuntimeException("Stub!"); }

/**
 * Create a new {@link android.text.PrecomputedText PrecomputedText} which will pre-compute text measurement and glyph
 * positioning information.
 * <p>
 * This can be expensive, so computing this on a background thread before your text will be
 * presented can save work on the UI thread.
 * </p>
 *
 * Note that any {@link android.text.NoCopySpan} attached to the text won't be passed to the
 * created PrecomputedText.
 *
 * @param text the text to be measured
 * This value must never be {@code null}.
 * @param params parameters that define how text will be precomputed
 * This value must never be {@code null}.
 * @return A {@link android.text.PrecomputedText PrecomputedText}
 * @apiSince 28
 */

public static android.text.PrecomputedText create(@androidx.annotation.NonNull java.lang.CharSequence text, @androidx.annotation.NonNull android.text.PrecomputedText.Params params) { throw new RuntimeException("Stub!"); }

/**
 * Returns the layout parameters used to measure this text.
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.text.PrecomputedText.Params getParams() { throw new RuntimeException("Stub!"); }

/**
 * Returns the count of paragraphs.
 
 * @return Value is 0 or greater
 * @apiSince 28
 */

public int getParagraphCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the paragraph start offset of the text.
 
 * @param paraIndex Value is 0 or greater
 * @return Value is 0 or greater
 * @apiSince 28
 */

public int getParagraphStart(int paraIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns the paragraph end offset of the text.
 
 * @param paraIndex Value is 0 or greater
 * @return Value is 0 or greater
 * @apiSince 28
 */

public int getParagraphEnd(int paraIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns text width for the given range.
 * Both {@code start} and {@code end} offset need to be in the same paragraph, otherwise
 * IllegalArgumentException will be thrown.
 *
 * @param start the inclusive start offset in the text
 * Value is 0 or greater
 * @param end the exclusive end offset in the text
 * Value is 0 or greater
 * @return the text width
 * Value is 0 or greater
 * @throws java.lang.IllegalArgumentException if start and end offset are in the different paragraph.
 * @apiSince 28
 */

public float getWidth(int start, int end) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the text bounding box for the given range.
 * Both {@code start} and {@code end} offset need to be in the same paragraph, otherwise
 * IllegalArgumentException will be thrown.
 *
 * @param start the inclusive start offset in the text
 * Value is 0 or greater
 * @param end the exclusive end offset in the text
 * Value is 0 or greater
 * @param bounds the output rectangle
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if start and end offset are in the different paragraph.
 * @apiSince 28
 */

public void getBounds(int start, int end, @androidx.annotation.NonNull android.graphics.Rect bounds) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.IllegalArgumentException if {@link android.text.style.MetricAffectingSpan MetricAffectingSpan} is specified.
 * @apiSince 28
 */

public void setSpan(java.lang.Object what, int start, int end, int flags) { throw new RuntimeException("Stub!"); }

/**
 * @throws java.lang.IllegalArgumentException if {@link android.text.style.MetricAffectingSpan MetricAffectingSpan} is specified.
 * @apiSince 28
 */

public void removeSpan(java.lang.Object what) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public <T> T[] getSpans(int start, int end, java.lang.Class<T> type) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int getSpanStart(java.lang.Object tag) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int getSpanEnd(java.lang.Object tag) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int getSpanFlags(java.lang.Object tag) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int nextSpanTransition(int start, int limit, java.lang.Class type) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int length() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public char charAt(int index) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public java.lang.CharSequence subSequence(int start, int end) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
/**
 * The information required for building {@link android.text.PrecomputedText PrecomputedText}.
 *
 * Contains information required for precomputing text measurement metadata, so it can be done
 * in isolation of a {@link android.widget.TextView} or {@link android.text.StaticLayout StaticLayout}, when final layout
 * constraints are not known.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Params {

Params() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.text.TextPaint TextPaint} for this text.
 *
 * @return A {@link android.text.TextPaint TextPaint}
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.text.TextPaint getTextPaint() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.text.TextDirectionHeuristic TextDirectionHeuristic} for this text.
 *
 * @return A {@link android.text.TextDirectionHeuristic TextDirectionHeuristic}
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.text.TextDirectionHeuristic getTextDirection() { throw new RuntimeException("Stub!"); }

/**
 * Returns the break strategy for this text.
 *
 * @return A line break strategy
 
 * Value is {@link android.graphics.text.LineBreaker#BREAK_STRATEGY_SIMPLE}, {@link android.graphics.text.LineBreaker#BREAK_STRATEGY_HIGH_QUALITY}, or {@link android.graphics.text.LineBreaker#BREAK_STRATEGY_BALANCED}
 * @apiSince 28
 */

public int getBreakStrategy() { throw new RuntimeException("Stub!"); }

/**
 * Returns the hyphenation frequency for this text.
 *
 * @return A hyphenation frequency
 
 * Value is {@link android.text.Layout#HYPHENATION_FREQUENCY_NORMAL}, {@link android.text.Layout#HYPHENATION_FREQUENCY_FULL}, or {@link android.text.Layout#HYPHENATION_FREQUENCY_NONE}
 * @apiSince 28
 */

public int getHyphenationFrequency() { throw new RuntimeException("Stub!"); }

/**
 * Check if the same text layout.
 *
 * @param o This value may be {@code null}.
 * @return true if this and the given param result in the same text layout
 * @apiSince 28
 */

public boolean equals(@androidx.annotation.Nullable java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
/**
 * A builder for creating {@link android.text.PrecomputedText.Params Params}.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

/**
 * Builder constructor.
 *
 * @param paint the paint to be used for drawing
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public Builder(@androidx.annotation.NonNull android.text.TextPaint paint) { throw new RuntimeException("Stub!"); }

/**
 * Builder constructor from existing params.
 
 * @param params This value must never be {@code null}.
 * @apiSince 29
 */

public Builder(@androidx.annotation.NonNull android.text.PrecomputedText.Params params) { throw new RuntimeException("Stub!"); }

/**
 * Set the line break strategy.
 *
 * The default value is {@link android.text.Layout#BREAK_STRATEGY_HIGH_QUALITY Layout#BREAK_STRATEGY_HIGH_QUALITY}.
 *
 * @param strategy the break strategy
 * Value is {@link android.graphics.text.LineBreaker#BREAK_STRATEGY_SIMPLE}, {@link android.graphics.text.LineBreaker#BREAK_STRATEGY_HIGH_QUALITY}, or {@link android.graphics.text.LineBreaker#BREAK_STRATEGY_BALANCED}
 * @return this builder, useful for chaining
 * @see android.text.StaticLayout.Builder#setBreakStrategy
 * @see android.widget.TextView#setBreakStrategy
 * @apiSince 28
 */

public android.text.PrecomputedText.Params.Builder setBreakStrategy(int strategy) { throw new RuntimeException("Stub!"); }

/**
 * Set the hyphenation frequency.
 *
 * The default value is {@link android.text.Layout#HYPHENATION_FREQUENCY_NORMAL Layout#HYPHENATION_FREQUENCY_NORMAL}.
 *
 * @param frequency the hyphenation frequency
 * Value is {@link android.text.Layout#HYPHENATION_FREQUENCY_NORMAL}, {@link android.text.Layout#HYPHENATION_FREQUENCY_FULL}, or {@link android.text.Layout#HYPHENATION_FREQUENCY_NONE}
 * @return this builder, useful for chaining
 * @see android.text.StaticLayout.Builder#setHyphenationFrequency
 * @see android.widget.TextView#setHyphenationFrequency
 * @apiSince 28
 */

public android.text.PrecomputedText.Params.Builder setHyphenationFrequency(int frequency) { throw new RuntimeException("Stub!"); }

/**
 * Set the text direction heuristic.
 *
 * The default value is {@link android.text.TextDirectionHeuristics#FIRSTSTRONG_LTR TextDirectionHeuristics#FIRSTSTRONG_LTR}.
 *
 * @param textDir the text direction heuristic for resolving bidi behavior
 * This value must never be {@code null}.
 * @return this builder, useful for chaining
 * @see android.text.StaticLayout.Builder#setTextDirection
 * @apiSince 28
 */

public android.text.PrecomputedText.Params.Builder setTextDirection(@androidx.annotation.NonNull android.text.TextDirectionHeuristic textDir) { throw new RuntimeException("Stub!"); }

/**
 * Build the {@link android.text.PrecomputedText.Params Params}.
 *
 * @return the layout parameter
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.text.PrecomputedText.Params build() { throw new RuntimeException("Stub!"); }
}

}

}

