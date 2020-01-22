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
import android.os.Build;

/**
 * DynamicLayout is a text layout that updates itself as the text is edited.
 * <p>This is used by widgets to control text layout. You should not need
 * to use this class directly unless you are implementing your own widget
 * or custom display object, or need to call
 * {@link android.graphics.Canvas#drawText(java.lang.CharSequence, int, int, float, float, android.graphics.Paint)
 *  Canvas.drawText()} directly.</p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DynamicLayout extends android.text.Layout {

/**
 * @deprecated Use {@link android.text.DynamicLayout.Builder Builder} instead.
 
 * @param base This value must never be {@code null}.
 
 * @param paint This value must never be {@code null}.
 
 * @param width Value is 0 or greater
 
 * @param align This value must never be {@code null}.
 
 * @param spacingmult Value is 0.0 or greater
 * @apiSince 1
 */

@Deprecated
public DynamicLayout(@androidx.annotation.NonNull java.lang.CharSequence base, @androidx.annotation.NonNull android.text.TextPaint paint, int width, @androidx.annotation.NonNull android.text.Layout.Alignment align, float spacingmult, float spacingadd, boolean includepad) { super(null, null, 0, null, (float)0, (float)0); throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link android.text.DynamicLayout.Builder Builder} instead.
 
 * @param base This value must never be {@code null}.
 
 * @param display This value must never be {@code null}.
 
 * @param paint This value must never be {@code null}.
 
 * @param width Value is 0 or greater
 
 * @param align This value must never be {@code null}.
 
 * @param spacingmult Value is 0.0 or greater
 * @apiSince 1
 */

@Deprecated
public DynamicLayout(@androidx.annotation.NonNull java.lang.CharSequence base, @androidx.annotation.NonNull java.lang.CharSequence display, @androidx.annotation.NonNull android.text.TextPaint paint, int width, @androidx.annotation.NonNull android.text.Layout.Alignment align, float spacingmult, float spacingadd, boolean includepad) { super(null, null, 0, null, (float)0, (float)0); throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link android.text.DynamicLayout.Builder Builder} instead.
 
 * @param base This value must never be {@code null}.
 
 * @param display This value must never be {@code null}.
 
 * @param paint This value must never be {@code null}.
 
 * @param width Value is 0 or greater
 
 * @param align This value must never be {@code null}.
 
 * @param spacingmult Value is 0.0 or greater
 
 * @param ellipsize This value may be {@code null}.
 
 * @param ellipsizedWidth Value is 0 or greater
 * @apiSince 1
 */

@Deprecated
public DynamicLayout(@androidx.annotation.NonNull java.lang.CharSequence base, @androidx.annotation.NonNull java.lang.CharSequence display, @androidx.annotation.NonNull android.text.TextPaint paint, int width, @androidx.annotation.NonNull android.text.Layout.Alignment align, float spacingmult, float spacingadd, boolean includepad, @androidx.annotation.Nullable android.text.TextUtils.TruncateAt ellipsize, int ellipsizedWidth) { super(null, null, 0, null, (float)0, (float)0); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getLineCount() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getLineTop(int line) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getLineDescent(int line) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getLineStart(int line) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean getLineContainsTab(int line) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getParagraphDirection(int line) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final android.text.Layout.Directions getLineDirections(int line) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getTopPadding() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getBottomPadding() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getEllipsizedWidth() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getEllipsisStart(int line) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getEllipsisCount(int line) { throw new RuntimeException("Stub!"); }
/**
 * Builder for dynamic layouts. The builder is the preferred pattern for constructing
 * DynamicLayout objects and should be preferred over the constructors, particularly to access
 * newer features. To build a dynamic layout, first call {@link #obtain} with the required
 * arguments (base, paint, and width), then call setters for optional parameters, and finally
 * {@link #build} to build the DynamicLayout object. Parameters not explicitly set will get
 * default values.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

private Builder() { throw new RuntimeException("Stub!"); }

/**
 * Obtain a builder for constructing DynamicLayout objects.
 
 * @param base This value must never be {@code null}.
 * @param paint This value must never be {@code null}.
 * @param width Value is 0 or greater
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public static android.text.DynamicLayout.Builder obtain(@androidx.annotation.NonNull java.lang.CharSequence base, @androidx.annotation.NonNull android.text.TextPaint paint, int width) { throw new RuntimeException("Stub!"); }

/**
 * Set the transformed text (password transformation being the primary example of a
 * transformation) that will be updated as the base text is changed. The default is the
 * 'base' text passed to the builder's constructor.
 *
 * @param display the transformed text
 * This value must never be {@code null}.
 * @return this builder, useful for chaining
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.text.DynamicLayout.Builder setDisplayText(@androidx.annotation.NonNull java.lang.CharSequence display) { throw new RuntimeException("Stub!"); }

/**
 * Set the alignment. The default is {@link android.text.Layout.Alignment#ALIGN_NORMAL Layout.Alignment#ALIGN_NORMAL}.
 *
 * @param alignment Alignment for the resulting {@link android.text.DynamicLayout DynamicLayout}
 * This value must never be {@code null}.
 * @return this builder, useful for chaining
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.text.DynamicLayout.Builder setAlignment(@androidx.annotation.NonNull android.text.Layout.Alignment alignment) { throw new RuntimeException("Stub!"); }

/**
 * Set the text direction heuristic. The text direction heuristic is used to resolve text
 * direction per-paragraph based on the input text. The default is
 * {@link android.text.TextDirectionHeuristics#FIRSTSTRONG_LTR TextDirectionHeuristics#FIRSTSTRONG_LTR}.
 *
 * @param textDir text direction heuristic for resolving bidi behavior.
 * This value must never be {@code null}.
 * @return this builder, useful for chaining
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.text.DynamicLayout.Builder setTextDirection(@androidx.annotation.NonNull android.text.TextDirectionHeuristic textDir) { throw new RuntimeException("Stub!"); }

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
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.text.DynamicLayout.Builder setLineSpacing(float spacingAdd, float spacingMult) { throw new RuntimeException("Stub!"); }

/**
 * Set whether to include extra space beyond font ascent and descent (which is needed to
 * avoid clipping in some languages, such as Arabic and Kannada). The default is
 * {@code true}.
 *
 * @param includePad whether to include padding
 * @return this builder, useful for chaining
 * This value will never be {@code null}.
 * @see android.widget.TextView#setIncludeFontPadding
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.text.DynamicLayout.Builder setIncludePad(boolean includePad) { throw new RuntimeException("Stub!"); }

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
public android.text.DynamicLayout.Builder setUseLineSpacingFromFallbacks(boolean useLineSpacingFromFallbacks) { throw new RuntimeException("Stub!"); }

/**
 * Set the width as used for ellipsizing purposes, if it differs from the normal layout
 * width. The default is the {@code width} passed to {@link #obtain}.
 *
 * @param ellipsizedWidth width used for ellipsizing, in pixels
 * Value is 0 or greater
 * @return this builder, useful for chaining
 * This value will never be {@code null}.
 * @see android.widget.TextView#setEllipsize
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.text.DynamicLayout.Builder setEllipsizedWidth(int ellipsizedWidth) { throw new RuntimeException("Stub!"); }

/**
 * Set ellipsizing on the layout. Causes words that are longer than the view is wide, or
 * exceeding the number of lines (see #setMaxLines) in the case of
 * {@link android.text.TextUtils.TruncateAt#END} or
 * {@link android.text.TextUtils.TruncateAt#MARQUEE}, to be ellipsized instead of broken.
 * The default is {@code null}, indicating no ellipsis is to be applied.
 *
 * @param ellipsize type of ellipsis behavior
 * This value may be {@code null}.
 * @return this builder, useful for chaining
 * @see android.widget.TextView#setEllipsize
 * @apiSince 28
 */

public android.text.DynamicLayout.Builder setEllipsize(@androidx.annotation.Nullable android.text.TextUtils.TruncateAt ellipsize) { throw new RuntimeException("Stub!"); }

/**
 * Set break strategy, useful for selecting high quality or balanced paragraph layout
 * options. The default is {@link android.text.Layout#BREAK_STRATEGY_SIMPLE Layout#BREAK_STRATEGY_SIMPLE}.
 *
 * @param breakStrategy break strategy for paragraph layout
 * Value is {@link android.graphics.text.LineBreaker#BREAK_STRATEGY_SIMPLE}, {@link android.graphics.text.LineBreaker#BREAK_STRATEGY_HIGH_QUALITY}, or {@link android.graphics.text.LineBreaker#BREAK_STRATEGY_BALANCED}
 * @return this builder, useful for chaining
 * This value will never be {@code null}.
 * @see android.widget.TextView#setBreakStrategy
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.text.DynamicLayout.Builder setBreakStrategy(int breakStrategy) { throw new RuntimeException("Stub!"); }

/**
 * Set hyphenation frequency, to control the amount of automatic hyphenation used. The
 * possible values are defined in {@link android.text.Layout Layout}, by constants named with the pattern
 * {@code HYPHENATION_FREQUENCY_*}. The default is
 * {@link android.text.Layout#HYPHENATION_FREQUENCY_NONE Layout#HYPHENATION_FREQUENCY_NONE}.
 *
 * @param hyphenationFrequency hyphenation frequency for the paragraph
 * Value is {@link android.text.Layout#HYPHENATION_FREQUENCY_NORMAL}, {@link android.text.Layout#HYPHENATION_FREQUENCY_FULL}, or {@link android.text.Layout#HYPHENATION_FREQUENCY_NONE}
 * @return this builder, useful for chaining
 * This value will never be {@code null}.
 * @see android.widget.TextView#setHyphenationFrequency
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.text.DynamicLayout.Builder setHyphenationFrequency(int hyphenationFrequency) { throw new RuntimeException("Stub!"); }

/**
 * Set paragraph justification mode. The default value is
 * {@link android.text.Layout#JUSTIFICATION_MODE_NONE Layout#JUSTIFICATION_MODE_NONE}. If the last line is too short for justification,
 * the last line will be displayed with the alignment set by {@link #setAlignment}.
 *
 * @param justificationMode justification mode for the paragraph.
 * Value is {@link android.graphics.text.LineBreaker#JUSTIFICATION_MODE_NONE}, or {@link android.graphics.text.LineBreaker#JUSTIFICATION_MODE_INTER_WORD}
 * @return this builder, useful for chaining.
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.text.DynamicLayout.Builder setJustificationMode(int justificationMode) { throw new RuntimeException("Stub!"); }

/**
 * Build the {@link android.text.DynamicLayout DynamicLayout} after options have been set.
 *
 * <p>Note: the builder object must not be reused in any way after calling this method.
 * Setting parameters after calling this method, or calling it a second time on the same
 * builder object, will likely lead to unexpected results.
 *
 * @return the newly constructed {@link android.text.DynamicLayout DynamicLayout} object
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.text.DynamicLayout build() { throw new RuntimeException("Stub!"); }
}

}

