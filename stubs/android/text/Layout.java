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

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

/**
 * A base class that manages text layout in visual elements on
 * the screen.
 * <p>For text that will be edited, use a {@link android.text.DynamicLayout DynamicLayout},
 * which will be updated as the text changes.
 * For text that will not change, use a {@link android.text.StaticLayout StaticLayout}.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class Layout {

/**
 * Subclasses of Layout use this constructor to set the display text,
 * width, and other standard properties.
 * @param text the text to render
 * @param paint the default paint for the layout.  Styles can override
 * various attributes of the paint.
 * @param width the wrapping width for the text.
 * @param align whether to left, right, or center the text.  Styles can
 * override the alignment.
 * @param spacingMult factor by which to scale the font size to get the
 * default line spacing
 * @param spacingAdd amount to add to the default line spacing
 * @apiSince 1
 */

protected Layout(java.lang.CharSequence text, android.text.TextPaint paint, int width, android.text.Layout.Alignment align, float spacingMult, float spacingAdd) { throw new RuntimeException("Stub!"); }

/**
 * Return how wide a layout must be in order to display the specified text with one line per
 * paragraph.
 *
 * <p>As of O, Uses
 * {@link android.text.TextDirectionHeuristics#FIRSTSTRONG_LTR TextDirectionHeuristics#FIRSTSTRONG_LTR} as the default text direction heuristics. In
 * the earlier versions uses {@link android.text.TextDirectionHeuristics#LTR TextDirectionHeuristics#LTR} as the default.</p>
 * @apiSince 1
 */

public static float getDesiredWidth(java.lang.CharSequence source, android.text.TextPaint paint) { throw new RuntimeException("Stub!"); }

/**
 * Return how wide a layout must be in order to display the specified text slice with one
 * line per paragraph.
 *
 * <p>As of O, Uses
 * {@link android.text.TextDirectionHeuristics#FIRSTSTRONG_LTR TextDirectionHeuristics#FIRSTSTRONG_LTR} as the default text direction heuristics. In
 * the earlier versions uses {@link android.text.TextDirectionHeuristics#LTR TextDirectionHeuristics#LTR} as the default.</p>
 * @apiSince 1
 */

public static float getDesiredWidth(java.lang.CharSequence source, int start, int end, android.text.TextPaint paint) { throw new RuntimeException("Stub!"); }

/**
 * Draw this Layout on the specified Canvas.
 * @apiSince 1
 */

public void draw(android.graphics.Canvas c) { throw new RuntimeException("Stub!"); }

/**
 * Draw this Layout on the specified canvas, with the highlight path drawn
 * between the background and the text.
 *
 * @param canvas the canvas
 * @param highlight the path of the highlight or cursor; can be null
 * @param highlightPaint the paint for the highlight
 * @param cursorOffsetVertical the amount to temporarily translate the
 *        canvas while rendering the highlight
 * @apiSince 1
 */

public void draw(android.graphics.Canvas canvas, android.graphics.Path highlight, android.graphics.Paint highlightPaint, int cursorOffsetVertical) { throw new RuntimeException("Stub!"); }

/**
 * Return the text that is displayed by this Layout.
 * @apiSince 1
 */

public final java.lang.CharSequence getText() { throw new RuntimeException("Stub!"); }

/**
 * Return the base Paint properties for this layout.
 * Do NOT change the paint, which may result in funny
 * drawing for this layout.
 * @apiSince 1
 */

public final android.text.TextPaint getPaint() { throw new RuntimeException("Stub!"); }

/**
 * Return the width of this layout.
 * @apiSince 1
 */

public final int getWidth() { throw new RuntimeException("Stub!"); }

/**
 * Return the width to which this Layout is ellipsizing, or
 * {@link #getWidth} if it is not doing anything special.
 * @apiSince 1
 */

public int getEllipsizedWidth() { throw new RuntimeException("Stub!"); }

/**
 * Increase the width of this layout to the specified width.
 * Be careful to use this only when you know it is appropriate&mdash;
 * it does not cause the text to reflow to use the full new width.
 * @apiSince 1
 */

public final void increaseWidthTo(int wid) { throw new RuntimeException("Stub!"); }

/**
 * Return the total height of this layout.
 * @apiSince 1
 */

public int getHeight() { throw new RuntimeException("Stub!"); }

/**
 * Return the base alignment of this layout.
 * @apiSince 1
 */

public final android.text.Layout.Alignment getAlignment() { throw new RuntimeException("Stub!"); }

/**
 * Return what the text height is multiplied by to get the line height.
 * @apiSince 1
 */

public final float getSpacingMultiplier() { throw new RuntimeException("Stub!"); }

/**
 * Return the number of units of leading that are added to each line.
 * @apiSince 1
 */

public final float getSpacingAdd() { throw new RuntimeException("Stub!"); }

/**
 * Return the number of lines of text in this layout.
 * @apiSince 1
 */

public abstract int getLineCount();

/**
 * Return the baseline for the specified line (0&hellip;getLineCount() - 1)
 * If bounds is not null, return the top, left, right, bottom extents
 * of the specified line in it.
 * @param line which line to examine (0..getLineCount() - 1)
 * @param bounds Optional. If not null, it returns the extent of the line
 * @return the Y-coordinate of the baseline
 * @apiSince 1
 */

public int getLineBounds(int line, android.graphics.Rect bounds) { throw new RuntimeException("Stub!"); }

/**
 * Return the vertical position of the top of the specified line
 * (0&hellip;getLineCount()).
 * If the specified line is equal to the line count, returns the
 * bottom of the last line.
 * @apiSince 1
 */

public abstract int getLineTop(int line);

/**
 * Return the descent of the specified line(0&hellip;getLineCount() - 1).
 * @apiSince 1
 */

public abstract int getLineDescent(int line);

/**
 * Return the text offset of the beginning of the specified line (
 * 0&hellip;getLineCount()). If the specified line is equal to the line
 * count, returns the length of the text.
 * @apiSince 1
 */

public abstract int getLineStart(int line);

/**
 * Returns the primary directionality of the paragraph containing the
 * specified line, either 1 for left-to-right lines, or -1 for right-to-left
 * lines (see {@link #DIR_LEFT_TO_RIGHT}, {@link #DIR_RIGHT_TO_LEFT}).
 * @apiSince 1
 */

public abstract int getParagraphDirection(int line);

/**
 * Returns whether the specified line contains one or more
 * characters that need to be handled specially, like tabs.
 * @apiSince 1
 */

public abstract boolean getLineContainsTab(int line);

/**
 * Returns the directional run information for the specified line.
 * The array alternates counts of characters in left-to-right
 * and right-to-left segments of the line.
 *
 * <p>NOTE: this is inadequate to support bidirectional text, and will change.
 * @apiSince 1
 */

public abstract android.text.Layout.Directions getLineDirections(int line);

/**
 * Returns the (negative) number of extra pixels of ascent padding in the
 * top line of the Layout.
 * @apiSince 1
 */

public abstract int getTopPadding();

/**
 * Returns the number of extra pixels of descent padding in the
 * bottom line of the Layout.
 * @apiSince 1
 */

public abstract int getBottomPadding();

/**
 * Returns true if the character at offset is right to left (RTL).
 * @param offset the offset
 * @return true if the character is RTL, false if it is LTR
 * @apiSince 14
 */

public boolean isRtlCharAt(int offset) { throw new RuntimeException("Stub!"); }

/**
 * Get the primary horizontal position for the specified text offset.
 * This is the location where a new character would be inserted in
 * the paragraph's primary direction.
 * @apiSince 1
 */

public float getPrimaryHorizontal(int offset) { throw new RuntimeException("Stub!"); }

/**
 * Get the secondary horizontal position for the specified text offset.
 * This is the location where a new character would be inserted in
 * the direction other than the paragraph's primary direction.
 * @apiSince 1
 */

public float getSecondaryHorizontal(int offset) { throw new RuntimeException("Stub!"); }

/**
 * Get the leftmost position that should be exposed for horizontal
 * scrolling on the specified line.
 * @apiSince 1
 */

public float getLineLeft(int line) { throw new RuntimeException("Stub!"); }

/**
 * Get the rightmost position that should be exposed for horizontal
 * scrolling on the specified line.
 * @apiSince 1
 */

public float getLineRight(int line) { throw new RuntimeException("Stub!"); }

/**
 * Gets the unsigned horizontal extent of the specified line, including
 * leading margin indent, but excluding trailing whitespace.
 * @apiSince 1
 */

public float getLineMax(int line) { throw new RuntimeException("Stub!"); }

/**
 * Gets the unsigned horizontal extent of the specified line, including
 * leading margin indent and trailing whitespace.
 * @apiSince 1
 */

public float getLineWidth(int line) { throw new RuntimeException("Stub!"); }

/**
 * Get the line number corresponding to the specified vertical position.
 * If you ask for a position above 0, you get 0; if you ask for a position
 * below the bottom of the text, you get the last line.
 * @apiSince 1
 */

public int getLineForVertical(int vertical) { throw new RuntimeException("Stub!"); }

/**
 * Get the line number on which the specified text offset appears.
 * If you ask for a position before 0, you get 0; if you ask for a position
 * beyond the end of the text, you get the last line.
 * @apiSince 1
 */

public int getLineForOffset(int offset) { throw new RuntimeException("Stub!"); }

/**
 * Get the character offset on the specified line whose position is
 * closest to the specified horizontal position.
 * @apiSince 1
 */

public int getOffsetForHorizontal(int line, float horiz) { throw new RuntimeException("Stub!"); }

/**
 * Return the text offset after the last character on the specified line.
 * @apiSince 1
 */

public final int getLineEnd(int line) { throw new RuntimeException("Stub!"); }

/**
 * Return the text offset after the last visible character (so whitespace
 * is not counted) on the specified line.
 * @apiSince 1
 */

public int getLineVisibleEnd(int line) { throw new RuntimeException("Stub!"); }

/**
 * Return the vertical position of the bottom of the specified line.
 * @apiSince 1
 */

public final int getLineBottom(int line) { throw new RuntimeException("Stub!"); }

/**
 * Return the vertical position of the baseline of the specified line.
 * @apiSince 1
 */

public final int getLineBaseline(int line) { throw new RuntimeException("Stub!"); }

/**
 * Get the ascent of the text on the specified line.
 * The return value is negative to match the Paint.ascent() convention.
 * @apiSince 1
 */

public final int getLineAscent(int line) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getOffsetToLeftOf(int offset) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getOffsetToRightOf(int offset) { throw new RuntimeException("Stub!"); }

/**
 * Fills in the specified Path with a representation of a cursor
 * at the specified offset.  This will often be a vertical line
 * but can be multiple discontinuous lines in text with multiple
 * directionalities.
 * @apiSince 1
 */

public void getCursorPath(int point, android.graphics.Path dest, java.lang.CharSequence editingBuffer) { throw new RuntimeException("Stub!"); }

/**
 * Fills in the specified Path with a representation of a highlight
 * between the specified offsets.  This will often be a rectangle
 * or a potentially discontinuous set of rectangles.  If the start
 * and end are the same, the returned path is empty.
 * @apiSince 1
 */

public void getSelectionPath(int start, int end, android.graphics.Path dest) { throw new RuntimeException("Stub!"); }

/**
 * Get the alignment of the specified paragraph, taking into account
 * markup attached to it.
 * @apiSince 1
 */

public final android.text.Layout.Alignment getParagraphAlignment(int line) { throw new RuntimeException("Stub!"); }

/**
 * Get the left edge of the specified paragraph, inset by left margins.
 * @apiSince 1
 */

public final int getParagraphLeft(int line) { throw new RuntimeException("Stub!"); }

/**
 * Get the right edge of the specified paragraph, inset by right margins.
 * @apiSince 1
 */

public final int getParagraphRight(int line) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected final boolean isSpanned() { throw new RuntimeException("Stub!"); }

/**
 * Return the offset of the first character to be ellipsized away,
 * relative to the start of the line.  (So 0 if the beginning of the
 * line is ellipsized, not getLineStart().)
 * @apiSince 1
 */

public abstract int getEllipsisStart(int line);

/**
 * Returns the number of characters to be ellipsized away, or 0 if
 * no ellipsis is to take place.
 * @apiSince 1
 */

public abstract int getEllipsisCount(int line);

/**
 * Value for break strategy indicating balanced line breaking. The breaks are chosen to
 * make all lines as close to the same length as possible, including automatic hyphenation.
 * @apiSince 23
 */

public static final int BREAK_STRATEGY_BALANCED = 2; // 0x2

/**
 * Value for break strategy indicating high quality line breaking, including automatic
 * hyphenation and doing whole-paragraph optimization of line breaks.
 * @apiSince 23
 */

public static final int BREAK_STRATEGY_HIGH_QUALITY = 1; // 0x1

/**
 * Value for break strategy indicating simple line breaking. Automatic hyphens are not added
 * (though soft hyphens are respected), and modifying text generally doesn't affect the layout
 * before it (which yields a more consistent user experience when editing), but layout may not
 * be the highest quality.
 * @apiSince 23
 */

public static final int BREAK_STRATEGY_SIMPLE = 0; // 0x0

/** @apiSince 28 */

public static final float DEFAULT_LINESPACING_ADDITION = 0.0f;

/** @apiSince 28 */

public static final float DEFAULT_LINESPACING_MULTIPLIER = 1.0f;

/** @apiSince 1 */

public static final int DIR_LEFT_TO_RIGHT = 1; // 0x1

/** @apiSince 1 */

public static final int DIR_RIGHT_TO_LEFT = -1; // 0xffffffff

/**
 * Value for hyphenation frequency indicating the full amount of automatic hyphenation, typical
 * in typography. Useful for running text and where it's important to put the maximum amount of
 * text in a screen with limited space.
 * @apiSince 23
 */

public static final int HYPHENATION_FREQUENCY_FULL = 2; // 0x2

/**
 * Value for hyphenation frequency indicating no automatic hyphenation. Useful
 * for backward compatibility, and for cases where the automatic hyphenation algorithm results
 * in incorrect hyphenation. Mid-word breaks may still happen when a word is wider than the
 * layout and there is otherwise no valid break. Soft hyphens are ignored and will not be used
 * as suggestions for potential line breaks.
 * @apiSince 23
 */

public static final int HYPHENATION_FREQUENCY_NONE = 0; // 0x0

/**
 * Value for hyphenation frequency indicating a light amount of automatic hyphenation, which
 * is a conservative default. Useful for informal cases, such as short sentences or chat
 * messages.
 * @apiSince 23
 */

public static final int HYPHENATION_FREQUENCY_NORMAL = 1; // 0x1

/**
 * Value for justification mode indicating the text is justified by stretching word spacing.
 * @apiSince 26
 */

public static final int JUSTIFICATION_MODE_INTER_WORD = 1; // 0x1

/**
 * Value for justification mode indicating no justification.
 * @apiSince 26
 */

public static final int JUSTIFICATION_MODE_NONE = 0; // 0x0
/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum Alignment {
/** @apiSince 1 */

ALIGN_NORMAL,
/** @apiSince 1 */

ALIGN_OPPOSITE,
/** @apiSince 1 */

ALIGN_CENTER;
}

/**
 * Stores information about bidirectional (left-to-right or right-to-left)
 * text within the layout of a line.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Directions {

Directions() { throw new RuntimeException("Stub!"); }
}

}

