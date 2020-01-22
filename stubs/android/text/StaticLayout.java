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


package android.text;

import android.graphics.Paint;
import android.graphics.text.LineBreaker;
import android.os.Build;

/**
 * StaticLayout is a Layout for text that will not be edited after it
 * is laid out.  Use {@link android.text.DynamicLayout DynamicLayout} for text that may change.
 * <p>This is used by widgets to control text layout. You should not need
 * to use this class directly unless you are implementing your own widget
 * or custom display object, or would be tempted to call
 * {@link android.graphics.Canvas#drawText(java.lang.CharSequence, int, int,
 * float, float, android.graphics.Paint)
 * Canvas.drawText()} directly.</p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class StaticLayout extends android.text.Layout {

/**
 * @deprecated Use {@link android.text.StaticLayout.Builder Builder} instead.
 * @apiSince 1
 */

@Deprecated
public StaticLayout(java.lang.CharSequence source, android.text.TextPaint paint, int width, android.text.Layout.Alignment align, float spacingmult, float spacingadd, boolean includepad) { super(null, null, 0, null, (float)0, (float)0); throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link android.text.StaticLayout.Builder Builder} instead.
 * @apiSince 1
 */

@Deprecated
public StaticLayout(java.lang.CharSequence source, int bufstart, int bufend, android.text.TextPaint paint, int outerwidth, android.text.Layout.Alignment align, float spacingmult, float spacingadd, boolean includepad) { super(null, null, 0, null, (float)0, (float)0); throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link android.text.StaticLayout.Builder Builder} instead.
 * @apiSince 1
 */

@Deprecated
public StaticLayout(java.lang.CharSequence source, int bufstart, int bufend, android.text.TextPaint paint, int outerwidth, android.text.Layout.Alignment align, float spacingmult, float spacingadd, boolean includepad, android.text.TextUtils.TruncateAt ellipsize, int ellipsizedWidth) { super(null, null, 0, null, (float)0, (float)0); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getLineForVertical(int vertical) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getLineCount() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getLineTop(int line) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getLineDescent(int line) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getLineStart(int line) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getParagraphDirection(int line) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean getLineContainsTab(int line) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final android.text.Layout.Directions getLineDirections(int line) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getTopPadding() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getBottomPadding() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getEllipsisCount(int line) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getEllipsisStart(int line) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getEllipsizedWidth() { throw new RuntimeException("Stub!"); }
/**
 * Builder for static layouts. The builder is the preferred pattern for constructing
 * StaticLayout objects and should be preferred over the constructors, particularly to access
 * newer features. To build a static layout, first call {@link #obtain} with the required
 * arguments (text, paint, and width), then call setters for optional parameters, and finally
 * {@link #build} to build the StaticLayout object. Parameters not explicitly set will get
 * default values.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

private Builder() { throw new RuntimeException("Stub!"); }

/**
 * Obtain a builder for constructing StaticLayout objects.
 *
 * @param source The text to be laid out, optionally with spans
 * This value must never be {@code null}.
 * @param start The index of the start of the text
 * Value is 0 or greater
 * @param end The index + 1 of the end of the text
 * Value is 0 or greater
 * @param paint The base paint used for layout
 * This value must never be {@code null}.
 * @param width The width in pixels
 * Value is 0 or greater
 * @return a builder object used for constructing the StaticLayout
 
 * This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public static android.text.StaticLayout.Builder obtain(@androidx.annotation.NonNull java.lang.CharSequence source, int start, int end, @androidx.annotation.NonNull android.text.TextPaint paint, int width) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public android.text.StaticLayout.Builder setText(java.lang.CharSequence source) { throw new RuntimeException("Stub!"); }

/**
 * Set the alignment. The default is {@link android.text.Layout.Alignment#ALIGN_NORMAL Layout.Alignment#ALIGN_NORMAL}.
 *
 * @param alignment Alignment for the resulting {@link android.text.StaticLayout StaticLayout}
 * This value must never be {@code null}.
 * @return this builder, useful for chaining
 
 * This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.text.StaticLayout.Builder setAlignment(@androidx.annotation.NonNull android.text.Layout.Alignment alignment) { throw new RuntimeException("Stub!"); }

/**
 * Set the text direction heuristic. The text direction heuristic is used to
 * resolve text direction per-paragraph based on the input text. The default is
 * {@link android.text.TextDirectionHeuristics#FIRSTSTRONG_LTR TextDirectionHeuristics#FIRSTSTRONG_LTR}.
 *
 * @param textDir text direction heuristic for resolving bidi behavior.
 * This value must never be {@code null}.
 * @return this builder, useful for chaining
 
 * This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.text.StaticLayout.Builder setTextDirection(@androidx.annotation.NonNull android.text.TextDirectionHeuristic textDir) { throw new RuntimeException("Stub!"); }

/**
 * Set line spacing parameters. Each line will have its line spacing multiplied by
 * {@code spacingMult} and then increased by {@code spacingAdd}. The default is 0.0 for
 * {@code spacingAdd} and 1.0 for {@code spacingMult}.
 *
 * @param spacingAdd the amount of line spacing addition
 * @param spacingMult the line spacing multiplier
 * Value is 0.0 or greater
 * @return this builder, useful for chaining
 * This value will never be {@code null}.
 * @see android.widget.TextView#setLineSpacing
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.text.StaticLayout.Builder setLineSpacing(float spacingAdd, float spacingMult) { throw new RuntimeException("Stub!"); }

/**
 * Set whether to include extra space beyond font ascent and descent (which is
 * needed to avoid clipping in some languages, such as Arabic and Kannada). The
 * default is {@code true}.
 *
 * @param includePad whether to include padding
 * @return this builder, useful for chaining
 * This value will never be {@code null}.
 * @see android.widget.TextView#setIncludeFontPadding
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.text.StaticLayout.Builder setIncludePad(boolean includePad) { throw new RuntimeException("Stub!"); }

/**
 * Set whether to respect the ascent and descent of the fallback fonts that are used in
 * displaying the text (which is needed to avoid text from consecutive lines running into
 * each other). If set, fallback fonts that end up getting used can increase the ascent
 * and descent of the lines that they are used on.
 *
 * <p>For backward compatibility reasons, the default is {@code false}, but setting this to
 * true is strongly recommended. It is required to be true if text could be in languages
 * like Burmese or Tibetan where text is typically much taller or deeper than Latin text.
 *
 * @param useLineSpacingFromFallbacks whether to expand linespacing based on fallback fonts
 * @return this builder, useful for chaining
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.text.StaticLayout.Builder setUseLineSpacingFromFallbacks(boolean useLineSpacingFromFallbacks) { throw new RuntimeException("Stub!"); }

/**
 * Set the width as used for ellipsizing purposes, if it differs from the
 * normal layout width. The default is the {@code width}
 * passed to {@link #obtain}.
 *
 * @param ellipsizedWidth width used for ellipsizing, in pixels
 * Value is 0 or greater
 * @return this builder, useful for chaining
 * This value will never be {@code null}.
 * @see android.widget.TextView#setEllipsize
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.text.StaticLayout.Builder setEllipsizedWidth(int ellipsizedWidth) { throw new RuntimeException("Stub!"); }

/**
 * Set ellipsizing on the layout. Causes words that are longer than the view
 * is wide, or exceeding the number of lines (see #setMaxLines) in the case
 * of {@link android.text.TextUtils.TruncateAt#END} or
 * {@link android.text.TextUtils.TruncateAt#MARQUEE}, to be ellipsized instead
 * of broken. The default is {@code null}, indicating no ellipsis is to be applied.
 *
 * @param ellipsize type of ellipsis behavior
 * This value may be {@code null}.
 * @return this builder, useful for chaining
 * @see android.widget.TextView#setEllipsize
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.text.StaticLayout.Builder setEllipsize(@androidx.annotation.Nullable android.text.TextUtils.TruncateAt ellipsize) { throw new RuntimeException("Stub!"); }

/**
 * Set maximum number of lines. This is particularly useful in the case of
 * ellipsizing, where it changes the layout of the last line. The default is
 * unlimited.
 *
 * @param maxLines maximum number of lines in the layout
 * Value is 0 or greater
 * @return this builder, useful for chaining
 * This value will never be {@code null}.
 * @see android.widget.TextView#setMaxLines
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.text.StaticLayout.Builder setMaxLines(int maxLines) { throw new RuntimeException("Stub!"); }

/**
 * Set break strategy, useful for selecting high quality or balanced paragraph
 * layout options. The default is {@link android.text.Layout#BREAK_STRATEGY_SIMPLE Layout#BREAK_STRATEGY_SIMPLE}.
 * <p/>
 * Enabling hyphenation with either using {@link android.text.Layout#HYPHENATION_FREQUENCY_NORMAL Layout#HYPHENATION_FREQUENCY_NORMAL} or
 * {@link android.text.Layout#HYPHENATION_FREQUENCY_FULL Layout#HYPHENATION_FREQUENCY_FULL} while line breaking is set to one of
 * {@link android.text.Layout#BREAK_STRATEGY_BALANCED Layout#BREAK_STRATEGY_BALANCED}, {@link android.text.Layout#BREAK_STRATEGY_HIGH_QUALITY Layout#BREAK_STRATEGY_HIGH_QUALITY}
 * improves the structure of text layout however has performance impact and requires more
 * time to do the text layout.
 *
 * @param breakStrategy break strategy for paragraph layout
 * Value is {@link android.graphics.text.LineBreaker#BREAK_STRATEGY_SIMPLE}, {@link android.graphics.text.LineBreaker#BREAK_STRATEGY_HIGH_QUALITY}, or {@link android.graphics.text.LineBreaker#BREAK_STRATEGY_BALANCED}
 * @return this builder, useful for chaining
 * This value will never be {@code null}.
 * @see android.widget.TextView#setBreakStrategy
 * @see #setHyphenationFrequency(int)
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.text.StaticLayout.Builder setBreakStrategy(int breakStrategy) { throw new RuntimeException("Stub!"); }

/**
 * Set hyphenation frequency, to control the amount of automatic hyphenation used. The
 * possible values are defined in {@link android.text.Layout Layout}, by constants named with the pattern
 * {@code HYPHENATION_FREQUENCY_*}. The default is
 * {@link android.text.Layout#HYPHENATION_FREQUENCY_NONE Layout#HYPHENATION_FREQUENCY_NONE}.
 * <p/>
 * Enabling hyphenation with either using {@link android.text.Layout#HYPHENATION_FREQUENCY_NORMAL Layout#HYPHENATION_FREQUENCY_NORMAL} or
 * {@link android.text.Layout#HYPHENATION_FREQUENCY_FULL Layout#HYPHENATION_FREQUENCY_FULL} while line breaking is set to one of
 * {@link android.text.Layout#BREAK_STRATEGY_BALANCED Layout#BREAK_STRATEGY_BALANCED}, {@link android.text.Layout#BREAK_STRATEGY_HIGH_QUALITY Layout#BREAK_STRATEGY_HIGH_QUALITY}
 * improves the structure of text layout however has performance impact and requires more
 * time to do the text layout.
 *
 * @param hyphenationFrequency hyphenation frequency for the paragraph
 * Value is {@link android.text.Layout#HYPHENATION_FREQUENCY_NORMAL}, {@link android.text.Layout#HYPHENATION_FREQUENCY_FULL}, or {@link android.text.Layout#HYPHENATION_FREQUENCY_NONE}
 * @return this builder, useful for chaining
 * This value will never be {@code null}.
 * @see android.widget.TextView#setHyphenationFrequency
 * @see #setBreakStrategy(int)
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.text.StaticLayout.Builder setHyphenationFrequency(int hyphenationFrequency) { throw new RuntimeException("Stub!"); }

/**
 * Set indents. Arguments are arrays holding an indent amount, one per line, measured in
 * pixels. For lines past the last element in the array, the last element repeats.
 *
 * @param leftIndents array of indent values for left margin, in pixels
 * This value may be {@code null}.
 * @param rightIndents array of indent values for right margin, in pixels
 * This value may be {@code null}.
 * @return this builder, useful for chaining
 
 * This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.text.StaticLayout.Builder setIndents(@androidx.annotation.Nullable int[] leftIndents, @androidx.annotation.Nullable int[] rightIndents) { throw new RuntimeException("Stub!"); }

/**
 * Set paragraph justification mode. The default value is
 * {@link android.text.Layout#JUSTIFICATION_MODE_NONE Layout#JUSTIFICATION_MODE_NONE}. If the last line is too short for justification,
 * the last line will be displayed with the alignment set by {@link #setAlignment}.
 * When Justification mode is JUSTIFICATION_MODE_INTER_WORD, wordSpacing on the given
 * {@link android.graphics.Paint Paint} will be ignored. This behavior also affects Spans which change the
 * wordSpacing.
 *
 * @param justificationMode justification mode for the paragraph.
 * Value is {@link android.graphics.text.LineBreaker#JUSTIFICATION_MODE_NONE}, or {@link android.graphics.text.LineBreaker#JUSTIFICATION_MODE_INTER_WORD}
 * @return this builder, useful for chaining.
 * This value will never be {@code null}.
 * @see android.graphics.Paint#setWordSpacing(float)
 * @apiSince 26
 */

@androidx.annotation.NonNull
public android.text.StaticLayout.Builder setJustificationMode(int justificationMode) { throw new RuntimeException("Stub!"); }

/**
 * Build the {@link android.text.StaticLayout StaticLayout} after options have been set.
 *
 * <p>Note: the builder object must not be reused in any way after calling this
 * method. Setting parameters after calling this method, or calling it a second
 * time on the same builder object, will likely lead to unexpected results.
 *
 * @return the newly constructed {@link android.text.StaticLayout StaticLayout} object
 
 * This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.text.StaticLayout build() { throw new RuntimeException("Stub!"); }
}

}

