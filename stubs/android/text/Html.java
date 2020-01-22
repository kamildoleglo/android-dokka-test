/*
 * Copyright (C) 2007 The Android Open Source Project
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

import android.text.style.BulletSpan;
import android.text.style.ParagraphStyle;
import android.graphics.Color;
import android.graphics.drawable.Drawable;

/**
 * This class processes HTML strings into displayable styled text.
 * Not all HTML tags are supported.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Html {

private Html() { throw new RuntimeException("Stub!"); }

/**
 * Returns displayable styled text from the provided HTML string with the legacy flags
 * {@link #FROM_HTML_MODE_LEGACY}.
 *
 * @deprecated use {@link #fromHtml(java.lang.String,int)} instead.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static android.text.Spanned fromHtml(java.lang.String source) { throw new RuntimeException("Stub!"); }

/**
 * Returns displayable styled text from the provided HTML string. Any &lt;img&gt; tags in the
 * HTML will display as a generic replacement image which your program can then go through and
 * replace with real images.
 *
 * <p>This uses TagSoup to handle real HTML, including all of the brokenness found in the wild.
 * @apiSince 24
 */

public static android.text.Spanned fromHtml(java.lang.String source, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Returns displayable styled text from the provided HTML string with the legacy flags
 * {@link #FROM_HTML_MODE_LEGACY}.
 *
 * @deprecated use {@link #fromHtml(java.lang.String,int,android.text.Html.ImageGetter,android.text.Html.TagHandler)} instead.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static android.text.Spanned fromHtml(java.lang.String source, android.text.Html.ImageGetter imageGetter, android.text.Html.TagHandler tagHandler) { throw new RuntimeException("Stub!"); }

/**
 * Returns displayable styled text from the provided HTML string. Any &lt;img&gt; tags in the
 * HTML will use the specified ImageGetter to request a representation of the image (use null
 * if you don't want this) and the specified TagHandler to handle unknown tags (specify null if
 * you don't want this).
 *
 * <p>This uses TagSoup to handle real HTML, including all of the brokenness found in the wild.
 * @apiSince 24
 */

public static android.text.Spanned fromHtml(java.lang.String source, int flags, android.text.Html.ImageGetter imageGetter, android.text.Html.TagHandler tagHandler) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated use {@link #toHtml(android.text.Spanned,int)} instead.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static java.lang.String toHtml(android.text.Spanned text) { throw new RuntimeException("Stub!"); }

/**
 * Returns an HTML representation of the provided Spanned text. A best effort is
 * made to add HTML tags corresponding to spans. Also note that HTML metacharacters
 * (such as "&lt;" and "&amp;") within the input text are escaped.
 *
 * @param text input text to convert
 * @param option one of {@link #TO_HTML_PARAGRAPH_LINES_CONSECUTIVE} or
 *     {@link #TO_HTML_PARAGRAPH_LINES_INDIVIDUAL}
 * @return string containing input converted to HTML
 * @apiSince 24
 */

public static java.lang.String toHtml(android.text.Spanned text, int option) { throw new RuntimeException("Stub!"); }

/**
 * Returns an HTML escaped representation of the given plain text.
 * @apiSince 16
 */

public static java.lang.String escapeHtml(java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }

/**
 * Flags for {@link #fromHtml(java.lang.String,int,android.text.Html.ImageGetter,android.text.Html.TagHandler)}: Separate block-level
 * elements with line breaks (single newline character) in between. This inverts the
 * {@link android.text.Spanned Spanned} to HTML string conversion done with the option
 * {@link #TO_HTML_PARAGRAPH_LINES_INDIVIDUAL}.
 * @apiSince 24
 */

public static final int FROM_HTML_MODE_COMPACT = 63; // 0x3f

/**
 * Flags for {@link #fromHtml(java.lang.String,int,android.text.Html.ImageGetter,android.text.Html.TagHandler)}: Separate block-level
 * elements with blank lines (two newline characters) in between. This is the legacy behavior
 * prior to N.
 * @apiSince 24
 */

public static final int FROM_HTML_MODE_LEGACY = 0; // 0x0

/**
 * Flag indicating that CSS color values should be used instead of those defined in
 * {@link android.graphics.Color Color}.
 * @apiSince 24
 */

public static final int FROM_HTML_OPTION_USE_CSS_COLORS = 256; // 0x100

/**
 * Flag indicating that texts inside &lt;blockquote&gt; elements will be separated from other
 * texts with one newline character by default.
 * @apiSince 24
 */

public static final int FROM_HTML_SEPARATOR_LINE_BREAK_BLOCKQUOTE = 32; // 0x20

/**
 * Flag indicating that texts inside &lt;div&gt; elements will be separated from other texts
 * with one newline character by default.
 * @apiSince 24
 */

public static final int FROM_HTML_SEPARATOR_LINE_BREAK_DIV = 16; // 0x10

/**
 * Flag indicating that texts inside &lt;h1&gt;~&lt;h6&gt; elements will be separated from
 * other texts with one newline character by default.
 * @apiSince 24
 */

public static final int FROM_HTML_SEPARATOR_LINE_BREAK_HEADING = 2; // 0x2

/**
 * Flag indicating that texts inside &lt;ul&gt; elements will be separated from other texts
 * with one newline character by default.
 * @apiSince 24
 */

public static final int FROM_HTML_SEPARATOR_LINE_BREAK_LIST = 8; // 0x8

/**
 * Flag indicating that texts inside &lt;li&gt; elements will be separated from other texts
 * with one newline character by default.
 * @apiSince 24
 */

public static final int FROM_HTML_SEPARATOR_LINE_BREAK_LIST_ITEM = 4; // 0x4

/**
 * Flag indicating that texts inside &lt;p&gt; elements will be separated from other texts with
 * one newline character by default.
 * @apiSince 24
 */

public static final int FROM_HTML_SEPARATOR_LINE_BREAK_PARAGRAPH = 1; // 0x1

/**
 * Option for {@link #toHtml(android.text.Spanned,int)}: Wrap consecutive lines of text delimited by '\n'
 * inside &lt;p&gt; elements. {@link android.text.style.BulletSpan BulletSpan}s are ignored.
 * @apiSince 24
 */

public static final int TO_HTML_PARAGRAPH_LINES_CONSECUTIVE = 0; // 0x0

/**
 * Option for {@link #toHtml(android.text.Spanned,int)}: Wrap each line of text delimited by '\n' inside a
 * &lt;p&gt; or a &lt;li&gt; element. This allows {@link android.text.style.ParagraphStyle ParagraphStyle}s attached to be
 * encoded as CSS styles within the corresponding &lt;p&gt; or &lt;li&gt; element.
 * @apiSince 24
 */

public static final int TO_HTML_PARAGRAPH_LINES_INDIVIDUAL = 1; // 0x1
/**
 * Retrieves images for HTML &lt;img&gt; tags.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface ImageGetter {

/**
 * This method is called when the HTML parser encounters an
 * &lt;img&gt; tag.  The <code>source</code> argument is the
 * string from the "src" attribute; the return value should be
 * a Drawable representation of the image or <code>null</code>
 * for a generic replacement image.  Make sure you call
 * setBounds() on your Drawable if it doesn't already have
 * its bounds set.
 * @apiSince 1
 */

public android.graphics.drawable.Drawable getDrawable(java.lang.String source);
}

/**
 * Is notified when HTML tags are encountered that the parser does
 * not know how to interpret.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface TagHandler {

/**
 * This method will be called whenn the HTML parser encounters
 * a tag that it does not know how to interpret.
 * @apiSince 1
 */

public void handleTag(boolean opening, java.lang.String tag, android.text.Editable output, org.xml.sax.XMLReader xmlReader);
}

}

