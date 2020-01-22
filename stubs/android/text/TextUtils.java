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

import java.util.regex.Pattern;
import android.content.Context;
import java.util.Locale;
import android.view.View;

/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TextUtils {

private TextUtils() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static void getChars(java.lang.CharSequence s, int start, int end, char[] dest, int destoff) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static int indexOf(java.lang.CharSequence s, char ch) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static int indexOf(java.lang.CharSequence s, char ch, int start) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static int indexOf(java.lang.CharSequence s, char ch, int start, int end) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static int lastIndexOf(java.lang.CharSequence s, char ch) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static int lastIndexOf(java.lang.CharSequence s, char ch, int last) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static int lastIndexOf(java.lang.CharSequence s, char ch, int start, int last) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static int indexOf(java.lang.CharSequence s, java.lang.CharSequence needle) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static int indexOf(java.lang.CharSequence s, java.lang.CharSequence needle, int start) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static int indexOf(java.lang.CharSequence s, java.lang.CharSequence needle, int start, int end) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static boolean regionMatches(java.lang.CharSequence one, int toffset, java.lang.CharSequence two, int ooffset, int len) { throw new RuntimeException("Stub!"); }

/**
 * Create a new String object containing the given range of characters
 * from the source string.  This is different than simply calling
 * {@link java.lang.CharSequence#subSequence(int,int) CharSequence#subSequence(int, int)}
 * in that it does not preserve any style runs in the source sequence,
 * allowing a more efficient implementation.
 * @apiSince 1
 */

public static java.lang.String substring(java.lang.CharSequence source, int start, int end) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string containing the tokens joined by delimiters.
 *
 * @param delimiter a CharSequence that will be inserted between the tokens. If null, the string
 *     "null" will be used as the delimiter.
 * This value must never be {@code null}.
 * @param tokens an array objects to be joined. Strings will be formed from the objects by
 *     calling object.toString(). If tokens is null, a NullPointerException will be thrown. If
 *     tokens is an empty array, an empty string will be returned.
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public static java.lang.String join(@androidx.annotation.NonNull java.lang.CharSequence delimiter, @androidx.annotation.NonNull java.lang.Object[] tokens) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string containing the tokens joined by delimiters.
 *
 * @param delimiter a CharSequence that will be inserted between the tokens. If null, the string
 *     "null" will be used as the delimiter.
 * This value must never be {@code null}.
 * @param tokens an array objects to be joined. Strings will be formed from the objects by
 *     calling object.toString(). If tokens is null, a NullPointerException will be thrown. If
 *     tokens is empty, an empty string will be returned.
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public static java.lang.String join(@androidx.annotation.NonNull java.lang.CharSequence delimiter, @androidx.annotation.NonNull java.lang.Iterable tokens) { throw new RuntimeException("Stub!"); }

/**
 *
 * This method yields the same result as {@code text.split(expression, -1)} except that if
 * {@code text.isEmpty()} then this method returns an empty array whereas
 * {@code "".split(expression, -1)} would have returned an array with a single {@code ""}.
 *
 * The {@code -1} means that trailing empty Strings are not removed from the result; for
 * example split("a,", ","  ) returns {"a", ""}. Note that whether a leading zero-width match
 * can result in a leading {@code ""} depends on whether your app
 * {@link android.content.pm.ApplicationInfo#targetSdkVersion targets an SDK version}
 * {@code <= 28}; see {@link java.util.regex.Pattern#split(java.lang.CharSequence,int) Pattern#split(CharSequence, int)}.
 *
 * @param text the string to split
 * @param expression the regular expression to match
 * @return an array of strings. The array will be empty if text is empty
 *
 * @throws java.lang.NullPointerException if expression or text is null
 @apiSince 1
 */

public static java.lang.String[] split(java.lang.String text, java.lang.String expression) { throw new RuntimeException("Stub!"); }

/**
 * Splits a string on a pattern. This method yields the same result as
 * {@code pattern.split(text, -1)} except that if {@code text.isEmpty()} then this method
 * returns an empty array whereas {@code pattern.split("", -1)} would have returned an array
 * with a single {@code ""}.
 *
 * The {@code -1} means that trailing empty Strings are not removed from the result;
 * Note that whether a leading zero-width match can result in a leading {@code ""} depends
 * on whether your app {@link android.content.pm.ApplicationInfo#targetSdkVersion targets
 * an SDK version} {@code <= 28}; see {@link java.util.regex.Pattern#split(java.lang.CharSequence,int) Pattern#split(CharSequence, int)}.
 *
 * @param text the string to split
 * @param pattern the regular expression to match
 * @return an array of strings. The array will be empty if text is empty
 *
 * @throws java.lang.NullPointerException if expression or text is null
 * @apiSince 1
 */

public static java.lang.String[] split(java.lang.String text, java.util.regex.Pattern pattern) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static java.lang.CharSequence stringOrSpannedString(java.lang.CharSequence source) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the string is null or 0-length.
 * @param str the string to be examined
 * This value may be {@code null}.
 * @return true if str is null or zero length
 * @apiSince 1
 */

public static boolean isEmpty(@androidx.annotation.Nullable java.lang.CharSequence str) { throw new RuntimeException("Stub!"); }

/**
 * Returns the length that the specified CharSequence would have if
 * spaces and ASCII control characters were trimmed from the start and end,
 * as by {@link java.lang.String#trim String#trim}.
 * @apiSince 1
 */

public static int getTrimmedLength(java.lang.CharSequence s) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if a and b are equal, including if they are both null.
 * <p><i>Note: In platform versions 1.1 and earlier, this method only worked well if
 * both the arguments were instances of String.</i></p>
 * @param a first CharSequence to check
 * @param b second CharSequence to check
 * @return true if a and b are equal
 * @apiSince 1
 */

public static boolean equals(java.lang.CharSequence a, java.lang.CharSequence b) { throw new RuntimeException("Stub!"); }

/**
 * This function only reverses individual {@code char}s and not their associated
 * spans. It doesn't support surrogate pairs (that correspond to non-BMP code points), combining
 * sequences or conjuncts either.
 * @deprecated Do not use.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static java.lang.CharSequence getReverse(java.lang.CharSequence source, int start, int end) { throw new RuntimeException("Stub!"); }

/**
 * Flatten a CharSequence and whatever styles can be copied across processes
 * into the parcel.
 
 * @param cs This value may be {@code null}.
 
 * @param p This value must never be {@code null}.
 * @apiSince 1
 */

public static void writeToParcel(@androidx.annotation.Nullable java.lang.CharSequence cs, @androidx.annotation.NonNull android.os.Parcel p, int parcelableFlags) { throw new RuntimeException("Stub!"); }

/**
 * Debugging tool to print the spans in a CharSequence.  The output will
 * be printed one span per line.  If the CharSequence is not a Spanned,
 * then the entire string will be printed on a single line.
 * @apiSince 3
 */

public static void dumpSpans(java.lang.CharSequence cs, android.util.Printer printer, java.lang.String prefix) { throw new RuntimeException("Stub!"); }

/**
 * Return a new CharSequence in which each of the source strings is
 * replaced by the corresponding element of the destinations.
 * @apiSince 1
 */

public static java.lang.CharSequence replace(java.lang.CharSequence template, java.lang.String[] sources, java.lang.CharSequence[] destinations) { throw new RuntimeException("Stub!"); }

/**
 * Replace instances of "^1", "^2", etc. in the
 * <code>template</code> CharSequence with the corresponding
 * <code>values</code>.  "^^" is used to produce a single caret in
 * the output.  Only up to 9 replacement values are supported,
 * "^10" will be produce the first replacement value followed by a
 * '0'.
 *
 * @param template the input text containing "^1"-style
 * placeholder values.  This object is not modified; a copy is
 * returned.
 *
 * @param values CharSequences substituted into the template.  The
 * first is substituted for "^1", the second for "^2", and so on.
 *
 * @return the new CharSequence produced by doing the replacement
 *
 * @throws java.lang.IllegalArgumentException if the template requests a
 * value that was not provided, or if more than 9 values are
 * provided.
 * @apiSince 1
 */

public static java.lang.CharSequence expandTemplate(java.lang.CharSequence template, java.lang.CharSequence... values) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static int getOffsetBefore(java.lang.CharSequence text, int offset) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static int getOffsetAfter(java.lang.CharSequence text, int offset) { throw new RuntimeException("Stub!"); }

/**
 * Copies the spans from the region <code>start...end</code> in
 * <code>source</code> to the region
 * <code>destoff...destoff+end-start</code> in <code>dest</code>.
 * Spans in <code>source</code> that begin before <code>start</code>
 * or end after <code>end</code> but overlap this range are trimmed
 * as if they began at <code>start</code> or ended at <code>end</code>.
 *
 * @throws java.lang.IndexOutOfBoundsException if any of the copied spans
 * are out of range in <code>dest</code>.
 * @apiSince 1
 */

public static void copySpansFrom(android.text.Spanned source, int start, int end, java.lang.Class kind, android.text.Spannable dest, int destoff) { throw new RuntimeException("Stub!"); }

/**
 * Returns the original text if it fits in the specified width
 * given the properties of the specified Paint,
 * or, if it does not fit, a truncated
 * copy with ellipsis character added at the specified edge or center.
 * @apiSince 1
 */

public static java.lang.CharSequence ellipsize(java.lang.CharSequence text, android.text.TextPaint p, float avail, android.text.TextUtils.TruncateAt where) { throw new RuntimeException("Stub!"); }

/**
 * Returns the original text if it fits in the specified width
 * given the properties of the specified Paint,
 * or, if it does not fit, a copy with ellipsis character added
 * at the specified edge or center.
 * If <code>preserveLength</code> is specified, the returned copy
 * will be padded with zero-width spaces to preserve the original
 * length and offsets instead of truncating.
 * If <code>callback</code> is non-null, it will be called to
 * report the start and end of the ellipsized range.  TextDirection
 * is determined by the first strong directional character.
 
 * @param callback This value may be {@code null}.
 * @apiSince 1
 */

public static java.lang.CharSequence ellipsize(java.lang.CharSequence text, android.text.TextPaint paint, float avail, android.text.TextUtils.TruncateAt where, boolean preserveLength, @androidx.annotation.Nullable android.text.TextUtils.EllipsizeCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Formats a list of CharSequences by repeatedly inserting the separator between them,
 * but stopping when the resulting sequence is too wide for the specified width.
 *
 * This method actually tries to fit the maximum number of elements. So if {@code "A, 11 more"
 * fits}, {@code "A, B, 10 more"} doesn't fit, but {@code "A, B, C, 9 more"} fits again (due to
 * the glyphs for the digits being very wide, for example), it returns
 * {@code "A, B, C, 9 more"}. Because of this, this method may be inefficient for very long
 * lists.
 *
 * Note that the elements of the returned value, as well as the string for {@code moreId}, will
 * be bidi-wrapped using {@link android.text.BidiFormatter#unicodeWrap BidiFormatter#unicodeWrap} based on the locale of the input
 * Context. If the input {@code Context} is null, the default BidiFormatter from
 * {@link android.text.BidiFormatter#getInstance() BidiFormatter#getInstance()} will be used.
 *
 * @param context the {@code Context} to get the {@code moreId} resource from. If {@code null},
 *     an ellipsis (U+2026) would be used for {@code moreId}.
 * This value may be {@code null}.
 * @param elements the list to format
 * This value may be {@code null}.
 * @param separator a separator, such as {@code ", "}
 * This value must never be {@code null}.
 * @param paint the Paint with which to measure the text
 * This value must never be {@code null}.
 * @param avail the horizontal width available for the text (in pixels)
 * Value is 0.0 or greater
 * @param moreId the resource ID for the pluralized string to insert at the end of sequence when
 *     some of the elements don't fit.
 *
 * @return the formatted CharSequence. If even the shortest sequence (e.g. {@code "A, 11 more"})
 *     doesn't fit, it will return an empty string.
 * @apiSince 26
 */

public static java.lang.CharSequence listEllipsize(@androidx.annotation.Nullable android.content.Context context, @androidx.annotation.Nullable java.util.List<java.lang.CharSequence> elements, @androidx.annotation.NonNull java.lang.String separator, @androidx.annotation.NonNull android.text.TextPaint paint, float avail, int moreId) { throw new RuntimeException("Stub!"); }

/**
 * Converts a CharSequence of the comma-separated form "Andy, Bob,
 * Charles, David" that is too wide to fit into the specified width
 * into one like "Andy, Bob, 2 more".
 *
 * @param text the text to truncate
 * @param p the Paint with which to measure the text
 * @param avail the horizontal width available for the text (in pixels)
 * @param oneMore the string for "1 more" in the current locale
 * @param more the string for "%d more" in the current locale
 *
 * @deprecated Do not use. This is not internationalized, and has known issues
 * with right-to-left text, languages that have more than one plural form, languages
 * that use a different character as a comma-like separator, etc.
 * Use {@link #listEllipsize} instead.
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public static java.lang.CharSequence commaEllipsize(java.lang.CharSequence text, android.text.TextPaint p, float avail, java.lang.String oneMore, java.lang.String more) { throw new RuntimeException("Stub!"); }

/**
 * Html-encode the string.
 * @param s the string to be encoded
 * @return the encoded string
 * @apiSince 1
 */

public static java.lang.String htmlEncode(java.lang.String s) { throw new RuntimeException("Stub!"); }

/**
 * Returns a CharSequence concatenating the specified CharSequences,
 * retaining their spans if any.
 *
 * If there are no parameters, an empty string will be returned.
 *
 * If the number of parameters is exactly one, that parameter is returned as output, even if it
 * is null.
 *
 * If the number of parameters is at least two, any null CharSequence among the parameters is
 * treated as if it was the string <code>"null"</code>.
 *
 * If there are paragraph spans in the source CharSequences that satisfy paragraph boundary
 * requirements in the sources but would no longer satisfy them in the concatenated
 * CharSequence, they may get extended in the resulting CharSequence or not retained.
 * @apiSince 1
 */

public static java.lang.CharSequence concat(java.lang.CharSequence... text) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the given CharSequence contains any printable characters.
 * @apiSince 1
 */

public static boolean isGraphic(java.lang.CharSequence str) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether this character is a printable character.
 *
 * This does not support non-BMP characters and should not be used.
 *
 * @deprecated Use {@link #isGraphic(java.lang.CharSequence)} instead.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public static boolean isGraphic(char c) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the given CharSequence contains only digits.
 * @apiSince 1
 */

public static boolean isDigitsOnly(java.lang.CharSequence str) { throw new RuntimeException("Stub!"); }

/**
 * Determine what caps mode should be in effect at the current offset in
 * the text.  Only the mode bits set in <var>reqModes</var> will be
 * checked.  Note that the caps mode flags here are explicitly defined
 * to match those in {@link android.text.InputType InputType}.
 *
 * @param cs The text that should be checked for caps modes.
 * @param off Location in the text at which to check.
 * @param reqModes The modes to be checked: may be any combination of
 * {@link #CAP_MODE_CHARACTERS}, {@link #CAP_MODE_WORDS}, and
 * {@link #CAP_MODE_SENTENCES}.
 *
 * @return Returns the actual capitalization modes that can be in effect
 * at the current position, which is any combination of
 * {@link #CAP_MODE_CHARACTERS}, {@link #CAP_MODE_WORDS}, and
 * {@link #CAP_MODE_SENTENCES}.
 * @apiSince 3
 */

public static int getCapsMode(java.lang.CharSequence cs, int off, int reqModes) { throw new RuntimeException("Stub!"); }

/**
 * Return the layout direction for a given Locale
 *
 * @param locale the Locale for which we want the layout direction. Can be null.
 * @return the layout direction. This may be one of:
 * {@link android.view.View#LAYOUT_DIRECTION_LTR} or
 * {@link android.view.View#LAYOUT_DIRECTION_RTL}.
 *
 * Be careful: this code will need to be updated when vertical scripts will be supported
 * @apiSince 17
 */

public static int getLayoutDirectionFromLocale(java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Remove html, remove bad characters, and truncate string.
 *
 * <p>This method is meant to remove common mistakes and nefarious formatting from strings that
 * were loaded from untrusted sources (such as other packages).
 *
 * <p>This method first {@link android.text.Html#fromHtml Html#fromHtml} and then ...
 * <ul>
 * <li>Removes new lines or truncates at first new line
 * <li>Trims the white-space off the end
 * <li>Truncates the string
 * </ul>
 * ... if specified.
 *
 * @param unclean The input string
 * This value must never be {@code null}.
 * @param maxCharactersToConsider The maximum number of characters of {@code unclean} to
 *                                consider from the input string. {@code 0} disables this
 *                                feature.
 * Value is 0 or greater
 * @param ellipsizeDip Assuming maximum length of the string (in dip), assuming font size 42.
 *                     This is roughly 50 characters for {@code ellipsizeDip == 1000}.<br />
 *                     Usually ellipsizing should be left to the view showing the string. If a
 *                     string is used as an input to another string, it might be useful to
 *                     control the length of the input string though. {@code 0} disables this
 *                     feature.
 * Value is 0 or greater
 * @param flags Flags controlling cleaning behavior (Can be {@link #SAFE_STRING_FLAG_TRIM},
 *              {@link #SAFE_STRING_FLAG_SINGLE_LINE},
 *              and {@link #SAFE_STRING_FLAG_FIRST_LINE})
 *
 * Value is either <code>0</code> or a combination of {@link android.text.TextUtils#SAFE_STRING_FLAG_TRIM}, {@link android.text.TextUtils#SAFE_STRING_FLAG_SINGLE_LINE}, and {@link android.text.TextUtils#SAFE_STRING_FLAG_FIRST_LINE}
 * @return The cleaned string
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public static java.lang.CharSequence makeSafeForPresentation(@androidx.annotation.NonNull java.lang.String unclean, int maxCharactersToConsider, float ellipsizeDip, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Capitalization mode for {@link #getCapsMode}: capitalize all
 * characters.  This value is explicitly defined to be the same as
 * {@link android.text.InputType#TYPE_TEXT_FLAG_CAP_CHARACTERS InputType#TYPE_TEXT_FLAG_CAP_CHARACTERS}.
 * @apiSince 3
 */

public static final int CAP_MODE_CHARACTERS = 4096; // 0x1000

/**
 * Capitalization mode for {@link #getCapsMode}: capitalize the first
 * character of each sentence.  This value is explicitly defined to be the same as
 * {@link android.text.InputType#TYPE_TEXT_FLAG_CAP_SENTENCES InputType#TYPE_TEXT_FLAG_CAP_SENTENCES}.
 * @apiSince 3
 */

public static final int CAP_MODE_SENTENCES = 16384; // 0x4000

/**
 * Capitalization mode for {@link #getCapsMode}: capitalize the first
 * character of all words.  This value is explicitly defined to be the same as
 * {@link android.text.InputType#TYPE_TEXT_FLAG_CAP_WORDS InputType#TYPE_TEXT_FLAG_CAP_WORDS}.
 * @apiSince 3
 */

public static final int CAP_MODE_WORDS = 8192; // 0x2000

/** @apiSince 1 */

public static final android.os.Parcelable.Creator<java.lang.CharSequence> CHAR_SEQUENCE_CREATOR;
static { CHAR_SEQUENCE_CREATOR = null; }

/**
 * Return only first line of text (truncate at first newline). Cannot be set at the same time as
 * {@link #SAFE_STRING_FLAG_SINGLE_LINE}.
 *
 * @see #makeSafeForPresentation(String, int, float, int)
 * @apiSince 29
 */

public static final int SAFE_STRING_FLAG_FIRST_LINE = 4; // 0x4

/**
 * Force entire string into single line of text (no newlines). Cannot be set at the same time as
 * {@link #SAFE_STRING_FLAG_FIRST_LINE}.
 *
 * @see #makeSafeForPresentation(String, int, float, int)
 * @apiSince 29
 */

public static final int SAFE_STRING_FLAG_SINGLE_LINE = 2; // 0x2

/**
 * Remove {@link java.lang.Character#isWhitespace(int) Character#isWhitespace(int)} and non-breaking spaces from the edges
 * of the label.
 *
 * @see #makeSafeForPresentation(String, int, float, int)
 * @apiSince 29
 */

public static final int SAFE_STRING_FLAG_TRIM = 1; // 0x1
/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface EllipsizeCallback {

/**
 * This method is called to report that the specified region of
 * text was ellipsized away by a call to {@link #ellipsize}.
 * @apiSince 1
 */

public void ellipsized(int start, int end);
}

/**
 * A simple string splitter.
 *
 * <p>If the final character in the string to split is the delimiter then no empty string will
 * be returned for the empty string after that delimeter. That is, splitting <tt>"a,b,"</tt> on
 * comma will return <tt>"a", "b"</tt>, not <tt>"a", "b", ""</tt>.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class SimpleStringSplitter implements android.text.TextUtils.StringSplitter, java.util.Iterator<java.lang.String> {

/**
 * Initializes the splitter. setString may be called later.
 * @param delimiter the delimeter on which to split
 * @apiSince 1
 */

public SimpleStringSplitter(char delimiter) { throw new RuntimeException("Stub!"); }

/**
 * Sets the string to split
 * @param string the string to split
 * @apiSince 1
 */

public void setString(java.lang.String string) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.util.Iterator<java.lang.String> iterator() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean hasNext() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String next() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void remove() { throw new RuntimeException("Stub!"); }
}

/**
 * An interface for splitting strings according to rules that are opaque to the user of this
 * interface. This also has less overhead than split, which uses regular expressions and
 * allocates an array to hold the results.
 *
 * <p>The most efficient way to use this class is:
 *
 * <pre>
 * // Once
 * TextUtils.StringSplitter splitter = new TextUtils.SimpleStringSplitter(delimiter);
 *
 * // Once per string to split
 * splitter.setString(string);
 * for (String s : splitter) {
 *     ...
 * }
 * </pre>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface StringSplitter extends java.lang.Iterable<java.lang.String> {

/** @apiSince 1 */

public void setString(java.lang.String string);
}

/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum TruncateAt {
/** @apiSince 1 */

START,
/** @apiSince 1 */

MIDDLE,
/** @apiSince 1 */

END,
/** @apiSince 2 */

MARQUEE;
}

}

