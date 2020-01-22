/*
 * Copyright (C) 2018 The Android Open Source Project
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


/**
 * Provides automatic line breaking for a <em>single</em> paragraph.
 *
 * <p>
 * <pre>
 * <code>
 * Paint paint = new Paint();
 * Paint bigPaint = new Paint();
 * bigPaint.setTextSize(paint.getTextSize() * 2.0);
 * String text = "Hello, Android.";
 *
 * // Prepare the measured text
 * MeasuredText mt = new MeasuredText.Builder(text.toCharArray())
 *     .appendStyleRun(paint, 7, false)  // Use paint for "Hello, "
 *     .appednStyleRun(bigPaint, 8, false)  // Use bigPaint for "Hello, "
 *     .build();
 *
 * LineBreaker lb = new LineBreaker.Builder()
 *     // Use simple line breaker
 *     .setBreakStrategy(LineBreaker.BREAK_STRATEGY_SIMPLE)
 *     // Do not add hyphenation.
 *     .setHyphenationFrequency(LineBreaker.HYPHENATION_FREQUENCY_NONE)
 *     // Build the LineBreaker
 *     .build();
 *
 * ParagraphConstraints c = new ParagraphConstraints();
 * c.setWidth(240);  // Set the line wieth as 1024px
 *
 * // Do the line breaking
 * Result r = lb.computeLineBreaks(mt, c, 0);
 *
 * // Compute the total height of the text.
 * float totalHeight = 0;
 * for (int i = 0; i < r.getLineCount(); ++i) {  // iterate over the lines
 *    totalHeight += r.getLineDescent(i) - r.getLineAscent(i);
 * }
 *
 * // Draw text to the canvas
 * Bitmap bmp = Bitmap.createBitmap(240, totalHeight, Bitmap.Config.ARGB_8888);
 * Canvas c = new Canvas(bmp);
 * float yOffset = 0f;
 * int prevOffset = 0;
 * for (int i = 0; i < r.getLineCount(); ++i) {  // iterate over the lines
 *     int nextOffset = r.getLineBreakOffset(i);
 *     c.drawText(text, prevOffset, nextOffset, 0f, yOffset, paint);
 *
 *     prevOffset = nextOffset;
 *     yOffset += r.getLineDescent(i) - r.getLineAscent(i);
 * }
 * </code>
 * </pre>
 * </p>
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class LineBreaker {

private LineBreaker() { throw new RuntimeException("Stub!"); }

/**
 * Break paragraph into lines.
 *
 * The result is filled to out param.
 *
 * @param measuredPara a result of the text measurement
 * This value must never be {@code null}.
 * @param constraints for a single paragraph
 * This value must never be {@code null}.
 * @param lineNumber a line number of this paragraph
 
 * Value is 0 or greater
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.text.LineBreaker.Result computeLineBreaks(@androidx.annotation.NonNull android.graphics.text.MeasuredText measuredPara, @androidx.annotation.NonNull android.graphics.text.LineBreaker.ParagraphConstraints constraints, int lineNumber) { throw new RuntimeException("Stub!"); }

/**
 * Value for break strategy indicating balanced line breaking.
 *
 * The line breaker does whole-paragraph optimization for making all lines similar length, and
 * also applies automatic hyphenation when required. This break strategy is good for small
 * screen devices such as watch screens.
 * @apiSince 29
 */

public static final int BREAK_STRATEGY_BALANCED = 2; // 0x2

/**
 * Value for break strategy indicating high quality line breaking.
 *
 * With this option line breaker does whole-paragraph optimization for more readable text, and
 * also applies automatic hyphenation when required.
 * @apiSince 29
 */

public static final int BREAK_STRATEGY_HIGH_QUALITY = 1; // 0x1

/**
 * Value for break strategy indicating simple line breaking.
 *
 * The line breaker puts words to the line as much as possible and breaks line if no more words
 * can fit into the same line. Automatic hyphens are only added when a line has a single word
 * and that word is longer than line width. This is the fastest break strategy and ideal for
 * editor.
 * @apiSince 29
 */

public static final int BREAK_STRATEGY_SIMPLE = 0; // 0x0

/**
 * Value for hyphenation frequency indicating the full amount of automatic hyphenation.
 *
 * This hyphenation frequency is useful for running text and where it's important to put the
 * maximum amount of text in a screen with limited space.
 * @apiSince 29
 */

public static final int HYPHENATION_FREQUENCY_FULL = 2; // 0x2

/**
 * Value for hyphenation frequency indicating no automatic hyphenation.
 *
 * Using this option disables auto hyphenation which results in better text layout performance.
 * A word may be broken without hyphens when a line has a single word and that word is longer
 * than line width. Soft hyphens are ignored and will not be used as suggestions for potential
 * line breaks.
 * @apiSince 29
 */

public static final int HYPHENATION_FREQUENCY_NONE = 0; // 0x0

/**
 * Value for hyphenation frequency indicating a light amount of automatic hyphenation.
 *
 * This hyphenation frequency is useful for informal cases, such as short sentences or chat
 * messages.
 * @apiSince 29
 */

public static final int HYPHENATION_FREQUENCY_NORMAL = 1; // 0x1

/**
 * Value for justification mode indicating the text is justified by stretching word spacing.
 * @apiSince 29
 */

public static final int JUSTIFICATION_MODE_INTER_WORD = 1; // 0x1

/**
 * Value for justification mode indicating no justification.
 * @apiSince 29
 */

public static final int JUSTIFICATION_MODE_NONE = 0; // 0x0
/**
 * Helper class for creating a {@link android.graphics.text.LineBreaker LineBreaker}.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Set break strategy.
 *
 * You can change the line breaking behavior by setting break strategy. The default value is
 * {@link #BREAK_STRATEGY_SIMPLE}.
 
 * @param breakStrategy Value is {@link android.graphics.text.LineBreaker#BREAK_STRATEGY_SIMPLE}, {@link android.graphics.text.LineBreaker#BREAK_STRATEGY_HIGH_QUALITY}, or {@link android.graphics.text.LineBreaker#BREAK_STRATEGY_BALANCED}
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.text.LineBreaker.Builder setBreakStrategy(int breakStrategy) { throw new RuntimeException("Stub!"); }

/**
 * Set hyphenation frequency.
 *
 * You can change the amount of automatic hyphenation used. The default value is
 * {@link #HYPHENATION_FREQUENCY_NONE}.
 
 * @param hyphenationFrequency Value is {@link android.graphics.text.LineBreaker#HYPHENATION_FREQUENCY_NORMAL}, {@link android.graphics.text.LineBreaker#HYPHENATION_FREQUENCY_FULL}, or {@link android.graphics.text.LineBreaker#HYPHENATION_FREQUENCY_NONE}
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.text.LineBreaker.Builder setHyphenationFrequency(int hyphenationFrequency) { throw new RuntimeException("Stub!"); }

/**
 * Set whether the text is justified.
 *
 * By setting {@link #JUSTIFICATION_MODE_INTER_WORD}, the line breaker will change the
 * internal parameters for justification.
 * The default value is {@link #JUSTIFICATION_MODE_NONE}
 
 * @param justificationMode Value is {@link android.graphics.text.LineBreaker#JUSTIFICATION_MODE_NONE}, or {@link android.graphics.text.LineBreaker#JUSTIFICATION_MODE_INTER_WORD}
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.text.LineBreaker.Builder setJustificationMode(int justificationMode) { throw new RuntimeException("Stub!"); }

/**
 * Set indents.
 *
 * The supplied array provides the total amount of indentation per line, in pixel. This
 * amount is the sum of both left and right indentations. For lines past the last element in
 * the array, the indentation amount of the last element is used.
 
 * @param indents This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.text.LineBreaker.Builder setIndents(@androidx.annotation.Nullable int[] indents) { throw new RuntimeException("Stub!"); }

/**
 * Build a new LineBreaker with given parameters.
 *
 * You can reuse the Builder instance even after calling this method.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.text.LineBreaker build() { throw new RuntimeException("Stub!"); }
}

/**
 * Line breaking constraints for single paragraph.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class ParagraphConstraints {

/** @apiSince 29 */

public ParagraphConstraints() { throw new RuntimeException("Stub!"); }

/**
 * Set width for this paragraph.
 *
 * @see #getWidth()
 
 * @param width This units of this value are pixels.
 
 * Value is 0.0f or greater
 * @apiSince 29
 */

public void setWidth(float width) { throw new RuntimeException("Stub!"); }

/**
 * Set indent for this paragraph.
 *
 * @param firstWidth the line width of the starting of the paragraph
 * This units of this value are pixels.
 * Value is 0.0f or greater
 * @param firstWidthLineCount the number of lines that applies the firstWidth
 * This units of this value are pixels.
 * Value is 0 or greater
 * @see #getFirstWidth()
 * @see #getFirstWidthLineCount()
 * @apiSince 29
 */

public void setIndent(float firstWidth, int firstWidthLineCount) { throw new RuntimeException("Stub!"); }

/**
 * Set tab stops for this paragraph.
 *
 * @param tabStops the array of pixels of tap stopping position
 * This value may be {@code null}.
 * @param defaultTabStop pixels of the default tab stopping position
 * This units of this value are pixels.
 * Value is 0 or greater
 * @see #getTabStops()
 * @see #getDefaultTabStop()
 * @apiSince 29
 */

public void setTabStops(@androidx.annotation.Nullable float[] tabStops, float defaultTabStop) { throw new RuntimeException("Stub!"); }

/**
 * Return the width for this paragraph in pixels.
 *
 * <br>
 * This units of this value are pixels.
 * @see #setWidth(float)
 
 * @return This units of this value are pixels.
 * {}
 
 * Value is 0.0f or greater
 * @apiSince 29
 */

public float getWidth() { throw new RuntimeException("Stub!"); }

/**
 * Return the first line's width for this paragraph in pixel.
 *
 * <br>
 * This units of this value are pixels.
 * @see #setIndent(float, int)
 
 * @return This units of this value are pixels.
 * {}
 
 * Value is 0.0f or greater
 * @apiSince 29
 */

public float getFirstWidth() { throw new RuntimeException("Stub!"); }

/**
 * Return the number of lines to apply the first line's width.
 *
 * <br>
 * This units of this value are pixels.
 * @see #setIndent(float, int)
 
 * @return This units of this value are pixels.
 * {}
 
 * Value is 0 or greater
 * @apiSince 29
 */

public int getFirstWidthLineCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the array of tab stops in pixels.
 *
 * @see #setTabStops(float[], int)
 
 * @return This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public float[] getTabStops() { throw new RuntimeException("Stub!"); }

/**
 * Returns the default tab stops in pixels.
 *
 * <br>
 * This units of this value are pixels.
 * @see #setTabStop(float[], int)
 
 * @return This units of this value are pixels.
 * {}
 
 * Value is 0 or greater
 * @apiSince 29
 */

public float getDefaultTabStop() { throw new RuntimeException("Stub!"); }
}

/**
 * Holds the result of the {@link android.graphics.text.LineBreaker#computeLineBreaks LineBreaker#computeLineBreaks}.
 * @see android.graphics.text.LineBreaker#computeLineBreaks
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Result {

private Result() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of lines in the paragraph.
 *
 * @return number of lines
 
 * Value is 0 or greater
 * @apiSince 29
 */

public int getLineCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns character offset of the break for a given line.
 *
 * @param lineIndex an index of the line.
 * Value is 0 or greater
 * @return the break offset.
 
 * Value is 0 or greater
 * @apiSince 29
 */

public int getLineBreakOffset(int lineIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns width of a given line in pixels.
 *
 * <br>
 * This units of this value are pixels.
 * @param lineIndex an index of the line.
 * Value is 0 or greater
 * @return width of the line in pixels
 
 * This units of this value are pixels.
 * {}
 * @apiSince 29
 */

public float getLineWidth(int lineIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns font ascent of the line in pixels.
 *
 * <br>
 * This units of this value are pixels.
 * @param lineIndex an index of the line.
 * Value is 0 or greater
 * @return an entier font ascent of the line in pixels.
 
 * This units of this value are pixels.
 * {}
 * @apiSince 29
 */

public float getLineAscent(int lineIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns font descent of the line in pixels.
 *
 * <br>
 * This units of this value are pixels.
 * @param lineIndex an index of the line.
 * Value is 0 or greater
 * @return an entier font descent of the line in pixels.
 
 * This units of this value are pixels.
 * {}
 * @apiSince 29
 */

public float getLineDescent(int lineIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the line has a TAB character.
 *
 * @param lineIndex an index of the line.
 * @return true if the line has a TAB character
 * @apiSince 29
 */

public boolean hasLineTab(int lineIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns a start hyphen edit for the line.
 *
 * @param lineIndex an index of the line.
 * @return a start hyphen edit for the line.
 *
 * @see android.graphics.Paint#setStartHyphenEdit
 * @see android.graphics.Paint#getStartHyphenEdit
 * @apiSince 29
 */

public int getStartLineHyphenEdit(int lineIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns an end hyphen edit for the line.
 *
 * @param lineIndex an index of the line.
 * @return an end hyphen edit for the line.
 *
 * @see android.graphics.Paint#setEndHyphenEdit
 * @see android.graphics.Paint#getEndHyphenEdit
 * @apiSince 29
 */

public int getEndLineHyphenEdit(int lineIndex) { throw new RuntimeException("Stub!"); }
}

}

