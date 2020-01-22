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
 * Paragraph affecting span that changes the position of the tab with respect to
 * the leading margin of the line. <code>TabStopSpan</code> will only affect the first tab
 * encountered on the first line of the text.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface TabStopSpan extends android.text.style.ParagraphStyle {

/**
 * Returns the offset of the tab stop from the leading margin of the line, in pixels.
 *
 * @return the offset, in pixels
 * @apiSince 1
 */

public int getTabStop();
/**
 * The default implementation of TabStopSpan that allows setting the offset of the tab stop
 * from the leading margin of the first line of text.
 * <p>
 * Let's consider that we have the following text: <i>"\tParagraph text beginning with tab."</i>
 * and we want to move the tab stop with 100px. This can be achieved like this:
 * <pre>
 * SpannableString string = new SpannableString("\tParagraph text beginning with tab.");
 * string.setSpan(new TabStopSpan.Standard(100), 0, string.length(),
 * Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);</pre>
 * <img src="{@docRoot}reference/android/images/text/style/tabstopspan.png" />
 * <figcaption>Text with a tab stop and a <code>TabStopSpan</code></figcaption>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Standard implements android.text.style.TabStopSpan {

/**
 * Constructs a {@link android.text.style.TabStopSpan.Standard TabStopSpan.Standard} based on an offset.
 *
 * @param offset the offset of the tab stop from the leading margin of
 *               the line, in pixels
 
 * Value is 0 or greater
 * @apiSince 1
 */

public Standard(int offset) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getTabStop() { throw new RuntimeException("Stub!"); }
}

}

