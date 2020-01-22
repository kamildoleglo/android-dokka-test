/*
 * Copyright (C) 2013 The Android Open Source Project
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


/**
 * Utility class for formatting text for display in a potentially opposite-directionality context
 * without garbling. The directionality of the context is set at formatter creation and the
 * directionality of the text can be either estimated or passed in when known.
 *
 * <p>To support versions lower than {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR2},
 * you can use the support library's {@link android.support.v4.text.BidiFormatter} class.
 *
 * <p>These APIs provides the following functionality:
 * <p>
 * 1. Bidi Wrapping
 * When text in one language is mixed into a document in another, opposite-directionality language,
 * e.g. when an English business name is embedded in some Hebrew text, both the inserted string
 * and the text surrounding it may be displayed incorrectly unless the inserted string is explicitly
 * separated from the surrounding text in a "wrapper" that:
 * <p>
 * - Declares its directionality so that the string is displayed correctly. This can be done in
 *   Unicode bidi formatting codes by {@link #unicodeWrap} and similar methods.
 * <p>
 * - Isolates the string's directionality, so it does not unduly affect the surrounding content.
 *   Currently, this can only be done using invisible Unicode characters of the same direction as
 *   the context (LRM or RLM) in addition to the directionality declaration above, thus "resetting"
 *   the directionality to that of the context. The "reset" may need to be done at both ends of the
 *   string. Without "reset" after the string, the string will "stick" to a number or logically
 *   separate opposite-direction text that happens to follow it in-line (even if separated by
 *   neutral content like spaces and punctuation). Without "reset" before the string, the same can
 *   happen there, but only with more opposite-direction text, not a number. One approach is to
 *   "reset" the direction only after each string, on the theory that if the preceding opposite-
 *   direction text is itself bidi-wrapped, the "reset" after it will prevent the sticking. (Doing
 *   the "reset" only before each string definitely does not work because we do not want to require
 *   bidi-wrapping numbers, and a bidi-wrapped opposite-direction string could be followed by a
 *   number.) Still, the safest policy is to do the "reset" on both ends of each string, since RTL
 *   message translations often contain untranslated Latin-script brand names and technical terms,
 *   and one of these can be followed by a bidi-wrapped inserted value. On the other hand, when one
 *   has such a message, it is best to do the "reset" manually in the message translation itself,
 *   since the message's opposite-direction text could be followed by an inserted number, which we
 *   would not bidi-wrap anyway. Thus, "reset" only after the string is the current default. In an
 *   alternative to "reset", recent additions to the HTML, CSS, and Unicode standards allow the
 *   isolation to be part of the directionality declaration. This form of isolation is better than
 *   "reset" because it takes less space, does not require knowing the context directionality, has a
 *   gentler effect than "reset", and protects both ends of the string. However, we do not yet allow
 *   using it because required platforms do not yet support it.
 * <p>
 * Providing these wrapping services is the basic purpose of the bidi formatter.
 * <p>
 * 2. Directionality estimation
 * How does one know whether a string about to be inserted into surrounding text has the same
 * directionality? Well, in many cases, one knows that this must be the case when writing the code
 * doing the insertion, e.g. when a localized message is inserted into a localized page. In such
 * cases there is no need to involve the bidi formatter at all. In some other cases, it need not be
 * the same as the context, but is either constant (e.g. urls are always LTR) or otherwise known.
 * In the remaining cases, e.g. when the string is user-entered or comes from a database, the
 * language of the string (and thus its directionality) is not known a priori, and must be
 * estimated at run-time. The bidi formatter can do this automatically using the default
 * first-strong estimation algorithm. It can also be configured to use a custom directionality
 * estimation object.
 * @apiSince 18
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class BidiFormatter {

private BidiFormatter() { throw new RuntimeException("Stub!"); }

/**
 * Factory for creating an instance of BidiFormatter for the default locale directionality.
 *
 * This does not create any new objects, and returns already existing static instances.
 *
 * @apiSince 18
 */

public static android.text.BidiFormatter getInstance() { throw new RuntimeException("Stub!"); }

/**
 * Factory for creating an instance of BidiFormatter given the context directionality.
 *
 * This does not create any new objects, and returns already existing static instances.
 *
 * @param rtlContext Whether the context directionality is RTL.
 * @apiSince 18
 */

public static android.text.BidiFormatter getInstance(boolean rtlContext) { throw new RuntimeException("Stub!"); }

/**
 * Factory for creating an instance of BidiFormatter given the context locale.
 *
 * This does not create any new objects, and returns already existing static instances.
 *
 * @param locale The context locale.
 * @apiSince 18
 */

public static android.text.BidiFormatter getInstance(java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * @return Whether the context directionality is RTL
 * @apiSince 18
 */

public boolean isRtlContext() { throw new RuntimeException("Stub!"); }

/**
 * @return Whether directionality "reset" should also be done before a string being
 * bidi-wrapped, not just after it.
 * @apiSince 18
 */

public boolean getStereoReset() { throw new RuntimeException("Stub!"); }

/**
 * Estimates the directionality of a string using the default text direction heuristic.
 *
 * @param str String whose directionality is to be estimated.
 * @return true if {@code str}'s estimated overall directionality is RTL. Otherwise returns
 *          false.
 * @apiSince 18
 */

public boolean isRtl(java.lang.String str) { throw new RuntimeException("Stub!"); }

/**
 * Operates like {@link #isRtl(java.lang.String)}, but takes a CharSequence instead of a string
 *
 * @param str CharSequence whose directionality is to be estimated.
 * @return true if {@code str}'s estimated overall directionality is RTL. Otherwise returns
 *          false.
 * @apiSince 26
 */

public boolean isRtl(java.lang.CharSequence str) { throw new RuntimeException("Stub!"); }

/**
 * Formats a string of given directionality for use in plain-text output of the context
 * directionality, so an opposite-directionality string is neither garbled nor garbles its
 * surroundings. This makes use of Unicode bidi formatting characters.
 * <p>
 * The algorithm: In case the given directionality doesn't match the context directionality, wraps
 * the string with Unicode bidi formatting characters: RLE+{@code str}+PDF for RTL text, or
 * LRE+{@code str}+PDF for LTR text.
 * <p>
 * If {@code isolate}, directionally isolates the string so that it does not garble its
 * surroundings. Currently, this is done by "resetting" the directionality after the string by
 * appending a trailing Unicode bidi mark matching the context directionality (LRM or RLM) when
 * either the overall directionality or the exit directionality of the string is opposite to
 * that of the context. Unless the formatter was built using
 * {@link android.text.BidiFormatter.Builder#stereoReset(boolean) Builder#stereoReset(boolean)} with a {@code false} argument, also prepends a Unicode
 * bidi mark matching the context directionality when either the overall directionality or the
 * entry directionality of the string is opposite to that of the context. Note that as opposed
 * to the overall directionality, the entry and exit directionalities are determined from the
 * string itself.
 * <p>
 * Does *not* do HTML-escaping.
 *
 * @param str The input string.
 * This value may be {@code null}.
 * @param heuristic The algorithm to be used to estimate the string's overall direction.
 *        See {@link android.text.TextDirectionHeuristics TextDirectionHeuristics} for pre-defined heuristics.
 * @param isolate Whether to directionally isolate the string to prevent it from garbling the
 *     content around it
 * @return Input string after applying the above processing. {@code null} if {@code str} is
 *     {@code null}.
 * @apiSince 18
 */

@androidx.annotation.Nullable
public java.lang.String unicodeWrap(@androidx.annotation.Nullable java.lang.String str, android.text.TextDirectionHeuristic heuristic, boolean isolate) { throw new RuntimeException("Stub!"); }

/**
 * Operates like {@link #unicodeWrap(java.lang.String,android.text.TextDirectionHeuristic,boolean)}, but takes a
 * CharSequence instead of a string
 *
 * @param str The input CharSequence.
 * This value may be {@code null}.
 * @param heuristic The algorithm to be used to estimate the CharSequence's overall direction.
 *        See {@link android.text.TextDirectionHeuristics TextDirectionHeuristics} for pre-defined heuristics.
 * @param isolate Whether to directionally isolate the CharSequence to prevent it from garbling
 *     the content around it
 * @return Input CharSequence after applying the above processing. {@code null} if {@code str}
 *     is {@code null}.
 * @apiSince 26
 */

@androidx.annotation.Nullable
public java.lang.CharSequence unicodeWrap(@androidx.annotation.Nullable java.lang.CharSequence str, android.text.TextDirectionHeuristic heuristic, boolean isolate) { throw new RuntimeException("Stub!"); }

/**
 * Operates like {@link #unicodeWrap(java.lang.String,android.text.TextDirectionHeuristic,boolean)}, but assumes
 * {@code isolate} is true.
 *
 * @param str The input string.
 * @param heuristic The algorithm to be used to estimate the string's overall direction.
 *        See {@link android.text.TextDirectionHeuristics TextDirectionHeuristics} for pre-defined heuristics.
 * @return Input string after applying the above processing.
 * @apiSince 18
 */

public java.lang.String unicodeWrap(java.lang.String str, android.text.TextDirectionHeuristic heuristic) { throw new RuntimeException("Stub!"); }

/**
 * Operates like {@link #unicodeWrap(java.lang.CharSequence,android.text.TextDirectionHeuristic,boolean)}, but
 * assumes {@code isolate} is true.
 *
 * @param str The input CharSequence.
 * @param heuristic The algorithm to be used to estimate the CharSequence's overall direction.
 *        See {@link android.text.TextDirectionHeuristics TextDirectionHeuristics} for pre-defined heuristics.
 * @return Input CharSequence after applying the above processing.
 * @apiSince 26
 */

public java.lang.CharSequence unicodeWrap(java.lang.CharSequence str, android.text.TextDirectionHeuristic heuristic) { throw new RuntimeException("Stub!"); }

/**
 * Operates like {@link #unicodeWrap(java.lang.String,android.text.TextDirectionHeuristic,boolean)}, but uses the
 * formatter's default direction estimation algorithm.
 *
 * @param str The input string.
 * @param isolate Whether to directionally isolate the string to prevent it from garbling the
 *     content around it
 * @return Input string after applying the above processing.
 * @apiSince 18
 */

public java.lang.String unicodeWrap(java.lang.String str, boolean isolate) { throw new RuntimeException("Stub!"); }

/**
 * Operates like {@link #unicodeWrap(java.lang.CharSequence,android.text.TextDirectionHeuristic,boolean)}, but uses
 * the formatter's default direction estimation algorithm.
 *
 * @param str The input CharSequence.
 * @param isolate Whether to directionally isolate the CharSequence to prevent it from garbling
 *     the content around it
 * @return Input CharSequence after applying the above processing.
 * @apiSince 26
 */

public java.lang.CharSequence unicodeWrap(java.lang.CharSequence str, boolean isolate) { throw new RuntimeException("Stub!"); }

/**
 * Operates like {@link #unicodeWrap(java.lang.String,android.text.TextDirectionHeuristic,boolean)}, but uses the
 * formatter's default direction estimation algorithm and assumes {@code isolate} is true.
 *
 * @param str The input string.
 * @return Input string after applying the above processing.
 * @apiSince 18
 */

public java.lang.String unicodeWrap(java.lang.String str) { throw new RuntimeException("Stub!"); }

/**
 * Operates like {@link #unicodeWrap(java.lang.CharSequence,android.text.TextDirectionHeuristic,boolean)}, but uses
 * the formatter's default direction estimation algorithm and assumes {@code isolate} is true.
 *
 * @param str The input CharSequence.
 * @return Input CharSequence after applying the above processing.
 * @apiSince 26
 */

public java.lang.CharSequence unicodeWrap(java.lang.CharSequence str) { throw new RuntimeException("Stub!"); }
/**
 * A class for building a BidiFormatter with non-default options.
 * @apiSince 18
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Constructor.
 *
 * @apiSince 18
 */

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Constructor.
 *
 * @param rtlContext Whether the context directionality is RTL.
 * @apiSince 18
 */

public Builder(boolean rtlContext) { throw new RuntimeException("Stub!"); }

/**
 * Constructor.
 *
 * @param locale The context locale.
 * @apiSince 18
 */

public Builder(java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Specifies whether the BidiFormatter to be built should also "reset" directionality before
 * a string being bidi-wrapped, not just after it. The default is true.
 * @apiSince 18
 */

public android.text.BidiFormatter.Builder stereoReset(boolean stereoReset) { throw new RuntimeException("Stub!"); }

/**
 * Specifies the default directionality estimation algorithm to be used by the BidiFormatter.
 * By default, uses the first-strong heuristic.
 *
 * @param heuristic the {@code TextDirectionHeuristic} to use.
 * @return the builder itself.
 * @apiSince 18
 */

public android.text.BidiFormatter.Builder setTextDirectionHeuristic(android.text.TextDirectionHeuristic heuristic) { throw new RuntimeException("Stub!"); }

/**
 * @return A BidiFormatter with the specified options.
 * @apiSince 18
 */

public android.text.BidiFormatter build() { throw new RuntimeException("Stub!"); }
}

}

