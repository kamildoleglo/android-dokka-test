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

/**
 * A BoringLayout is a very simple Layout implementation for text that
 * fits on a single line and is all left-to-right characters.
 * You will probably never want to make one of these yourself;
 * if you do, be sure to call {@link #isBoring} first to make sure
 * the text meets the criteria.
 * <p>This class is used by widgets to control text layout. You should not need
 * to use this class directly unless you are implementing your own widget
 * or custom display object, in which case
 * you are encouraged to use a Layout instead of calling
 * {@link android.graphics.Canvas#drawText(java.lang.CharSequence, int, int, float, float, android.graphics.Paint)
 *  Canvas.drawText()} directly.</p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class BoringLayout extends android.text.Layout implements android.text.TextUtils.EllipsizeCallback {

/**
 * @param source the text to render
 * @param paint the default paint for the layout
 * @param outerwidth the wrapping width for the text
 * @param align whether to left, right, or center the text
 * @param spacingMult this value is no longer used by BoringLayout
 * @param spacingAdd this value is no longer used by BoringLayout
 * @param metrics {@code #Metrics} instance that contains information about FontMetrics and
 *                line width
 * @param includePad set whether to include extra space beyond font ascent and descent which is
 *                   needed to avoid clipping in some scripts
 * @apiSince 1
 */

public BoringLayout(java.lang.CharSequence source, android.text.TextPaint paint, int outerwidth, android.text.Layout.Alignment align, float spacingMult, float spacingAdd, android.text.BoringLayout.Metrics metrics, boolean includePad) { super(null, null, 0, null, (float)0, (float)0); throw new RuntimeException("Stub!"); }

/**
 *
 * @param source the text to render
 * @param paint the default paint for the layout
 * @param outerWidth the wrapping width for the text
 * @param align whether to left, right, or center the text
 * @param spacingMult this value is no longer used by BoringLayout
 * @param spacingAdd this value is no longer used by BoringLayout
 * @param metrics {@code #Metrics} instance that contains information about FontMetrics and
 *                line width
 * @param includePad set whether to include extra space beyond font ascent and descent which is
 *                   needed to avoid clipping in some scripts
 * @param ellipsize whether to ellipsize the text if width of the text is longer than the
 *                  requested {@code outerwidth}
 * @param ellipsizedWidth the width to which this Layout is ellipsizing. If {@code ellipsize} is
 *                        {@code null}, or is {@link android.text.TextUtils.TruncateAt#MARQUEE TextUtils.TruncateAt#MARQUEE} this value is
 *                        not used, {@code outerwidth} is used instead
 @apiSince 1
 */

public BoringLayout(java.lang.CharSequence source, android.text.TextPaint paint, int outerWidth, android.text.Layout.Alignment align, float spacingMult, float spacingAdd, android.text.BoringLayout.Metrics metrics, boolean includePad, android.text.TextUtils.TruncateAt ellipsize, int ellipsizedWidth) { super(null, null, 0, null, (float)0, (float)0); throw new RuntimeException("Stub!"); }

/**
 * Utility function to construct a BoringLayout instance.
 *
 * @param source the text to render
 * @param paint the default paint for the layout
 * @param outerWidth the wrapping width for the text
 * @param align whether to left, right, or center the text
 * @param spacingMult this value is no longer used by BoringLayout
 * @param spacingAdd this value is no longer used by BoringLayout
 * @param metrics {@code #Metrics} instance that contains information about FontMetrics and
 *                line width
 * @param includePad set whether to include extra space beyond font ascent and descent which is
 *                   needed to avoid clipping in some scripts
 * @apiSince 1
 */

public static android.text.BoringLayout make(java.lang.CharSequence source, android.text.TextPaint paint, int outerWidth, android.text.Layout.Alignment align, float spacingMult, float spacingAdd, android.text.BoringLayout.Metrics metrics, boolean includePad) { throw new RuntimeException("Stub!"); }

/**
 * Utility function to construct a BoringLayout instance.
 *
 * @param source the text to render
 * @param paint the default paint for the layout
 * @param outerWidth the wrapping width for the text
 * @param align whether to left, right, or center the text
 * @param spacingmult this value is no longer used by BoringLayout
 * @param spacingadd this value is no longer used by BoringLayout
 * @param metrics {@code #Metrics} instance that contains information about FontMetrics and
 *                line width
 * @param includePad set whether to include extra space beyond font ascent and descent which is
 *                   needed to avoid clipping in some scripts
 * @param ellipsize whether to ellipsize the text if width of the text is longer than the
 *                  requested width
 * @param ellipsizedWidth the width to which this Layout is ellipsizing. If {@code ellipsize} is
 *                        {@code null}, or is {@link android.text.TextUtils.TruncateAt#MARQUEE TextUtils.TruncateAt#MARQUEE} this value is
 *                        not used, {@code outerWidth} is used instead
 * @apiSince 1
 */

public static android.text.BoringLayout make(java.lang.CharSequence source, android.text.TextPaint paint, int outerWidth, android.text.Layout.Alignment align, float spacingmult, float spacingadd, android.text.BoringLayout.Metrics metrics, boolean includePad, android.text.TextUtils.TruncateAt ellipsize, int ellipsizedWidth) { throw new RuntimeException("Stub!"); }

/**
 * Returns a BoringLayout for the specified text, potentially reusing
 * this one if it is already suitable.  The caller must make sure that
 * no one is still using this Layout.
 *
 * @param source the text to render
 * @param paint the default paint for the layout
 * @param outerwidth the wrapping width for the text
 * @param align whether to left, right, or center the text
 * @param spacingMult this value is no longer used by BoringLayout
 * @param spacingAdd this value is no longer used by BoringLayout
 * @param metrics {@code #Metrics} instance that contains information about FontMetrics and
 *                line width
 * @param includePad set whether to include extra space beyond font ascent and descent which is
 *                   needed to avoid clipping in some scripts
 * @apiSince 1
 */

public android.text.BoringLayout replaceOrMake(java.lang.CharSequence source, android.text.TextPaint paint, int outerwidth, android.text.Layout.Alignment align, float spacingMult, float spacingAdd, android.text.BoringLayout.Metrics metrics, boolean includePad) { throw new RuntimeException("Stub!"); }

/**
 * Returns a BoringLayout for the specified text, potentially reusing
 * this one if it is already suitable.  The caller must make sure that
 * no one is still using this Layout.
 *
 * @param source the text to render
 * @param paint the default paint for the layout
 * @param outerWidth the wrapping width for the text
 * @param align whether to left, right, or center the text
 * @param spacingMult this value is no longer used by BoringLayout
 * @param spacingAdd this value is no longer used by BoringLayout
 * @param metrics {@code #Metrics} instance that contains information about FontMetrics and
 *                line width
 * @param includePad set whether to include extra space beyond font ascent and descent which is
 *                   needed to avoid clipping in some scripts
 * @param ellipsize whether to ellipsize the text if width of the text is longer than the
 *                  requested width
 * @param ellipsizedWidth the width to which this Layout is ellipsizing. If {@code ellipsize} is
 *                        {@code null}, or is {@link android.text.TextUtils.TruncateAt#MARQUEE TextUtils.TruncateAt#MARQUEE} this value is
 *                        not used, {@code outerwidth} is used instead
 * @apiSince 1
 */

public android.text.BoringLayout replaceOrMake(java.lang.CharSequence source, android.text.TextPaint paint, int outerWidth, android.text.Layout.Alignment align, float spacingMult, float spacingAdd, android.text.BoringLayout.Metrics metrics, boolean includePad, android.text.TextUtils.TruncateAt ellipsize, int ellipsizedWidth) { throw new RuntimeException("Stub!"); }

/**
 * Determine and compute metrics if given text can be handled by BoringLayout.
 *
 * @param text a text
 * @param paint a paint
 * @return layout metric for the given text. null if given text is unable to be handled by
 *         BoringLayout.
 * @apiSince 1
 */

public static android.text.BoringLayout.Metrics isBoring(java.lang.CharSequence text, android.text.TextPaint paint) { throw new RuntimeException("Stub!"); }

/**
 * Determine and compute metrics if given text can be handled by BoringLayout.
 *
 * @param text a text
 * @param paint a paint
 * @param metrics a metrics object to be recycled. If null is passed, this function creat new
 *                object.
 * @return layout metric for the given text. If metrics is not null, this method fills values
 *         to given metrics object instead of allocating new metrics object. null if given text
 *         is unable to be handled by BoringLayout.
 * @apiSince 1
 */

public static android.text.BoringLayout.Metrics isBoring(java.lang.CharSequence text, android.text.TextPaint paint, android.text.BoringLayout.Metrics metrics) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getHeight() { throw new RuntimeException("Stub!"); }

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

public float getLineMax(int line) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public float getLineWidth(int line) { throw new RuntimeException("Stub!"); }

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

/** @apiSince 1 */

public void draw(android.graphics.Canvas c, android.graphics.Path highlight, android.graphics.Paint highlightpaint, int cursorOffset) { throw new RuntimeException("Stub!"); }

/**
 * Callback for the ellipsizer to report what region it ellipsized.
 * @apiSince 1
 */

public void ellipsized(int start, int end) { throw new RuntimeException("Stub!"); }
/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Metrics extends android.graphics.Paint.FontMetricsInt {

public Metrics() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int width;
}

}

