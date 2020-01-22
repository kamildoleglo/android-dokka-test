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
 * Used to change the background of lines where the span is attached to.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface LineBackgroundSpan extends android.text.style.ParagraphStyle {

/**
 * Draw the background on the canvas.
 *
 * @param canvas      canvas on which the span should be rendered
 * This value must never be {@code null}.
 * @param paint       paint used to draw text, which should be left unchanged on exit
 * This value must never be {@code null}.
 * @param left        left position of the line relative to input canvas, in pixels
 * This units of this value are pixels.
 * @param right       right position of the line relative to input canvas, in pixels
 * This units of this value are pixels.
 * @param top         top position of the line relative to input canvas, in pixels
 * This units of this value are pixels.
 * @param baseline    baseline of the text relative to input canvas, in pixels
 * This units of this value are pixels.
 * @param bottom      bottom position of the line relative to input canvas, in pixels
 * This units of this value are pixels.
 * @param text        current text
 * This value must never be {@code null}.
 * @param start       start character index of the line
 * @param end         end character index of the line
 * @param lineNumber  line number in the current text layout
 * @apiSince 1
 */

public void drawBackground(@androidx.annotation.NonNull android.graphics.Canvas canvas, @androidx.annotation.NonNull android.graphics.Paint paint, int left, int right, int top, int baseline, int bottom, @androidx.annotation.NonNull java.lang.CharSequence text, int start, int end, int lineNumber);
/**
 * Default implementation of the {@link android.text.style.LineBackgroundSpan LineBackgroundSpan}, which changes the background
 * color of the lines to which the span is attached.
 * <p>
 * For example, an <code>LineBackgroundSpan</code> can be used like this:
 * <pre>
 * String text = "This is a multiline text. LineBackgroundSpan is applied here. This is a multiline text.";
 * SpannableString string = new SpannableString(text);
 * string.setSpan(new LineBackgroundSpan.Standard(Color.YELLOW), 26, 61, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
 * </pre>
 * <img src="{@docRoot}reference/android/images/text/style/linebackgroundspan.png" />
 * <figcaption>Text with <code>LineBackgroundSpan</code></figcaption>
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Standard implements android.text.style.LineBackgroundSpan, android.text.ParcelableSpan {

/**
 * Constructor taking a color integer.
 *
 * @param color Color integer that defines the background color.
 * @apiSince 29
 */

public Standard(int color) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link android.text.style.LineBackgroundSpan.Standard LineBackgroundSpan.Standard} from a parcel
 
 * @param src This value must never be {@code null}.
 * @apiSince 29
 */

public Standard(@androidx.annotation.NonNull android.os.Parcel src) { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int getSpanTypeId() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param dest This value must never be {@code null}.
 * @apiSince 29
 */

public void writeToParcel(@androidx.annotation.NonNull android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * @return the color of this span.
 * @see android.text.style.LineBackgroundSpan.Standard#Standard(int)
 * @apiSince 29
 */

public final int getColor() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @param canvas This value must never be {@code null}.
 
 * @param paint This value must never be {@code null}.
 
 * @param left This units of this value are pixels.
 
 * @param right This units of this value are pixels.
 
 * @param top This units of this value are pixels.
 
 * @param baseline This units of this value are pixels.
 
 * @param bottom This units of this value are pixels.
 
 * @param text This value must never be {@code null}.
 * @apiSince 29
 */

public void drawBackground(@androidx.annotation.NonNull android.graphics.Canvas canvas, @androidx.annotation.NonNull android.graphics.Paint paint, int left, int right, int top, int baseline, int bottom, @androidx.annotation.NonNull java.lang.CharSequence text, int start, int end, int lineNumber) { throw new RuntimeException("Stub!"); }
}

}

