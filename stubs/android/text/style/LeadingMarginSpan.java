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


/**
 * A paragraph style affecting the leading margin. There can be multiple leading
 * margin spans on a single paragraph; they will be rendered in order, each
 * adding its margin to the ones before it. The leading margin is on the right
 * for lines in a right-to-left paragraph.
 * <p>
 * LeadingMarginSpans should be attached from the first character to the last
 * character of a single paragraph.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface LeadingMarginSpan extends android.text.style.ParagraphStyle {

/**
 * Returns the amount by which to adjust the leading margin. Positive values
 * move away from the leading edge of the paragraph, negative values move
 * towards it.
 *
 * @param first true if the request is for the first line of a paragraph,
 * false for subsequent lines
 * @return the offset for the margin.
 * @apiSince 1
 */

public int getLeadingMargin(boolean first);

/**
 * Renders the leading margin.  This is called before the margin has been
 * adjusted by the value returned by {@link #getLeadingMargin(boolean)}.
 *
 * @param c the canvas
 * @param p the paint. The this should be left unchanged on exit.
 * @param x the current position of the margin
 * @param dir the base direction of the paragraph; if negative, the margin
 * is to the right of the text, otherwise it is to the left.
 * @param top the top of the line
 * @param baseline the baseline of the line
 * @param bottom the bottom of the line
 * @param text the text
 * @param start the start of the line
 * @param end the end of the line
 * @param first true if this is the first line of its paragraph
 * @param layout the layout containing this line
 * @apiSince 1
 */

public void drawLeadingMargin(android.graphics.Canvas c, android.graphics.Paint p, int x, int dir, int top, int baseline, int bottom, java.lang.CharSequence text, int start, int end, boolean first, android.text.Layout layout);
/**
 * An extended version of {@link android.text.style.LeadingMarginSpan LeadingMarginSpan}, which allows the
 * implementor to specify the number of lines of the paragraph to which
 * this object is attached that the "first line of paragraph" margin width
 * will be applied to.
 * <p>
 * There should only be one LeadingMarginSpan2 per paragraph. The leading
 * margin line count affects all LeadingMarginSpans in the paragraph,
 * adjusting the number of lines to which the first line margin is applied.
 * <p>
 * As with LeadingMarginSpans, LeadingMarginSpan2s should be attached from
 * the beginning to the end of a paragraph.
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface LeadingMarginSpan2 extends android.text.style.LeadingMarginSpan,  android.text.style.WrapTogetherSpan {

/**
 * Returns the number of lines of the paragraph to which this object is
 * attached that the "first line" margin will apply to.
 * @apiSince 8
 */

public int getLeadingMarginLineCount();
}

/**
 * The standard implementation of LeadingMarginSpan, which adjusts the
 * margin but does not do any rendering.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Standard implements android.text.style.LeadingMarginSpan, android.text.ParcelableSpan {

/**
 * Constructor taking separate indents for the first and subsequent
 * lines.
 *
 * @param first the indent for the first line of the paragraph
 * @param rest the indent for the remaining lines of the paragraph
 * @apiSince 1
 */

public Standard(int first, int rest) { throw new RuntimeException("Stub!"); }

/**
 * Constructor taking an indent for all lines.
 * @param every the indent of each line
 * @apiSince 1
 */

public Standard(int every) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public Standard(android.os.Parcel src) { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public int getSpanTypeId() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getLeadingMargin(boolean first) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void drawLeadingMargin(android.graphics.Canvas c, android.graphics.Paint p, int x, int dir, int top, int baseline, int bottom, java.lang.CharSequence text, int start, int end, boolean first, android.text.Layout layout) { throw new RuntimeException("Stub!"); }
}

}

