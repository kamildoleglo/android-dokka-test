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


package android.text.util;

import android.webkit.WebView;
import java.util.function.Function;
import android.text.Spannable;
import android.text.style.URLSpan;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *  Linkify take a piece of text and a regular expression and turns all of the
 *  regex matches in the text into clickable links.  This is particularly
 *  useful for matching things like email addresses, web URLs, etc. and making
 *  them actionable.
 *
 *  Alone with the pattern that is to be matched, a URL scheme prefix is also
 *  required.  Any pattern match that does not begin with the supplied scheme
 *  will have the scheme prepended to the matched text when the clickable URL
 *  is created.  For instance, if you are matching web URLs you would supply
 *  the scheme <code>http://</code>. If the pattern matches example.com, which
 *  does not have a URL scheme prefix, the supplied scheme will be prepended to
 *  create <code>http://example.com</code> when the clickable URL link is
 *  created.
 *
 *  <p class="note"><b>Note:</b> When using {@link #MAP_ADDRESSES} or {@link #ALL}
 *  to match street addresses on API level {@link android.os.Build.VERSION_CODES#O_MR1}
 *  and earlier, methods in this class may throw
 *  {@link android.util.AndroidRuntimeException} or other exceptions if the
 *  device's WebView implementation is currently being updated, because
 *  {@link android.webkit.WebView#findAddress} is required to match street
 *  addresses.
 *
 * @see android.text.util.Linkify.MatchFilter
 * @see android.text.util.Linkify.TransformFilter
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Linkify {

public Linkify() { throw new RuntimeException("Stub!"); }

/**
 *  Scans the text of the provided Spannable and turns all occurrences
 *  of the link types indicated in the mask into clickable links.
 *  If the mask is nonzero, it also removes any existing URLSpans
 *  attached to the Spannable, to avoid problems if you call it
 *  repeatedly on the same text.
 *
 *  @param text Spannable whose text is to be marked-up with links
 *
 * This value must never be {@code null}.
 * @param mask Mask to define which kinds of links will be searched.
 *
 *
 * Value is either <code>0</code> or a combination of {@link android.text.util.Linkify#WEB_URLS}, {@link android.text.util.Linkify#EMAIL_ADDRESSES}, {@link android.text.util.Linkify#PHONE_NUMBERS}, {@link android.text.util.Linkify#MAP_ADDRESSES}, and {@link android.text.util.Linkify#ALL}
 * @return True if at least one link is found and applied.
 *
 * @see #addLinks(Spannable, int, Function)
 * @apiSince 1
 */

public static final boolean addLinks(@androidx.annotation.NonNull android.text.Spannable text, int mask) { throw new RuntimeException("Stub!"); }

/**
 *  Scans the text of the provided Spannable and turns all occurrences
 *  of the link types indicated in the mask into clickable links.
 *  If the mask is nonzero, it also removes any existing URLSpans
 *  attached to the Spannable, to avoid problems if you call it
 *  repeatedly on the same text.
 *
 *  @param text Spannable whose text is to be marked-up with links
 *
 * This value must never be {@code null}.
 * @param mask mask to define which kinds of links will be searched
 *
 * Value is either <code>0</code> or a combination of {@link android.text.util.Linkify#WEB_URLS}, {@link android.text.util.Linkify#EMAIL_ADDRESSES}, {@link android.text.util.Linkify#PHONE_NUMBERS}, {@link android.text.util.Linkify#MAP_ADDRESSES}, and {@link android.text.util.Linkify#ALL}
 * @param urlSpanFactory function used to create {@link android.text.style.URLSpan URLSpan}s
 *
 * This value may be {@code null}.
 * @return True if at least one link is found and applied.
 * @apiSince 29
 */

public static final boolean addLinks(@androidx.annotation.NonNull android.text.Spannable text, int mask, @androidx.annotation.Nullable java.util.function.Function<java.lang.String,android.text.style.URLSpan> urlSpanFactory) { throw new RuntimeException("Stub!"); }

/**
 *  Scans the text of the provided TextView and turns all occurrences of
 *  the link types indicated in the mask into clickable links.  If matches
 *  are found the movement method for the TextView is set to
 *  LinkMovementMethod.
 *
 *  @param text TextView whose text is to be marked-up with links
 *
 * This value must never be {@code null}.
 * @param mask Mask to define which kinds of links will be searched.
 *
 *
 * Value is either <code>0</code> or a combination of {@link android.text.util.Linkify#WEB_URLS}, {@link android.text.util.Linkify#EMAIL_ADDRESSES}, {@link android.text.util.Linkify#PHONE_NUMBERS}, {@link android.text.util.Linkify#MAP_ADDRESSES}, and {@link android.text.util.Linkify#ALL}
 * @return True if at least one link is found and applied.
 *
 *  @see #addLinks(Spannable, int, Function)
 * @apiSince 1
 */

public static final boolean addLinks(@androidx.annotation.NonNull android.widget.TextView text, int mask) { throw new RuntimeException("Stub!"); }

/**
 *  Applies a regex to the text of a TextView turning the matches into
 *  links.  If links are found then UrlSpans are applied to the link
 *  text match areas, and the movement method for the text is changed
 *  to LinkMovementMethod.
 *
 *  @param text         TextView whose text is to be marked-up with links
 *
 * This value must never be {@code null}.
 * @param pattern      Regex pattern to be used for finding links
 *
 * This value must never be {@code null}.
 * @param scheme       URL scheme string (eg <code>http://</code>) to be
 *                      prepended to the links that do not start with this scheme.
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public static final void addLinks(@androidx.annotation.NonNull android.widget.TextView text, @androidx.annotation.NonNull java.util.regex.Pattern pattern, @androidx.annotation.Nullable java.lang.String scheme) { throw new RuntimeException("Stub!"); }

/**
 *  Applies a regex to the text of a TextView turning the matches into
 *  links.  If links are found then UrlSpans are applied to the link
 *  text match areas, and the movement method for the text is changed
 *  to LinkMovementMethod.
 *
 *  @param text         TextView whose text is to be marked-up with links
 *
 * This value must never be {@code null}.
 * @param pattern      Regex pattern to be used for finding links
 *
 * This value must never be {@code null}.
 * @param scheme       URL scheme string (eg <code>http://</code>) to be
 *                      prepended to the links that do not start with this scheme.
 *
 * This value may be {@code null}.
 * @param matchFilter  The filter that is used to allow the client code
 *                      additional control over which pattern matches are
 *                      to be converted into links.
 
 * This value may be {@code null}.
 
 * @param transformFilter This value may be {@code null}.
 * @apiSince 1
 */

public static final void addLinks(@androidx.annotation.NonNull android.widget.TextView text, @androidx.annotation.NonNull java.util.regex.Pattern pattern, @androidx.annotation.Nullable java.lang.String scheme, @androidx.annotation.Nullable android.text.util.Linkify.MatchFilter matchFilter, @androidx.annotation.Nullable android.text.util.Linkify.TransformFilter transformFilter) { throw new RuntimeException("Stub!"); }

/**
 *  Applies a regex to the text of a TextView turning the matches into
 *  links.  If links are found then UrlSpans are applied to the link
 *  text match areas, and the movement method for the text is changed
 *  to LinkMovementMethod.
 *
 *  @param text TextView whose text is to be marked-up with links.
 *
 * This value must never be {@code null}.
 * @param pattern Regex pattern to be used for finding links.
 *
 * This value must never be {@code null}.
 * @param defaultScheme The default scheme to be prepended to links if the link does not
 *                       start with one of the <code>schemes</code> given.
 *
 * This value may be {@code null}.
 * @param schemes Array of schemes (eg <code>http://</code>) to check if the link found
 *                 contains a scheme. Passing a null or empty value means prepend defaultScheme
 *                 to all links.
 *
 * This value may be {@code null}.
 * @param matchFilter  The filter that is used to allow the client code additional control
 *                      over which pattern matches are to be converted into links.
 *
 * This value may be {@code null}.
 * @param transformFilter Filter to allow the client code to update the link found.
 
 * This value may be {@code null}.
 * @apiSince 24
 */

public static final void addLinks(@androidx.annotation.NonNull android.widget.TextView text, @androidx.annotation.NonNull java.util.regex.Pattern pattern, @androidx.annotation.Nullable java.lang.String defaultScheme, @androidx.annotation.Nullable java.lang.String[] schemes, @androidx.annotation.Nullable android.text.util.Linkify.MatchFilter matchFilter, @androidx.annotation.Nullable android.text.util.Linkify.TransformFilter transformFilter) { throw new RuntimeException("Stub!"); }

/**
 *  Applies a regex to a Spannable turning the matches into
 *  links.
 *
 *  @param text         Spannable whose text is to be marked-up with links
 *
 * This value must never be {@code null}.
 * @param pattern      Regex pattern to be used for finding links
 *
 * This value must never be {@code null}.
 * @param scheme       URL scheme string (eg <code>http://</code>) to be
 *                      prepended to the links that do not start with this scheme.
 * This value may be {@code null}.
 * @see #addLinks(Spannable, Pattern, String, String[], MatchFilter, TransformFilter, Function)
 * @apiSince 1
 */

public static final boolean addLinks(@androidx.annotation.NonNull android.text.Spannable text, @androidx.annotation.NonNull java.util.regex.Pattern pattern, @androidx.annotation.Nullable java.lang.String scheme) { throw new RuntimeException("Stub!"); }

/**
 * Applies a regex to a Spannable turning the matches into
 * links.
 *
 * @param spannable    Spannable whose text is to be marked-up with links
 * This value must never be {@code null}.
 * @param pattern      Regex pattern to be used for finding links
 * This value must never be {@code null}.
 * @param scheme       URL scheme string (eg <code>http://</code>) to be
 *                     prepended to the links that do not start with this scheme.
 * This value may be {@code null}.
 * @param matchFilter  The filter that is used to allow the client code
 *                     additional control over which pattern matches are
 *                     to be converted into links.
 * This value may be {@code null}.
 * @param transformFilter Filter to allow the client code to update the link found.
 *
 * This value may be {@code null}.
 * @return True if at least one link is found and applied.
 * @see #addLinks(Spannable, Pattern, String, String[], MatchFilter, TransformFilter, Function)
 * @apiSince 1
 */

public static final boolean addLinks(@androidx.annotation.NonNull android.text.Spannable spannable, @androidx.annotation.NonNull java.util.regex.Pattern pattern, @androidx.annotation.Nullable java.lang.String scheme, @androidx.annotation.Nullable android.text.util.Linkify.MatchFilter matchFilter, @androidx.annotation.Nullable android.text.util.Linkify.TransformFilter transformFilter) { throw new RuntimeException("Stub!"); }

/**
 * Applies a regex to a Spannable turning the matches into links.
 *
 * @param spannable Spannable whose text is to be marked-up with links.
 * This value must never be {@code null}.
 * @param pattern Regex pattern to be used for finding links.
 * This value must never be {@code null}.
 * @param defaultScheme The default scheme to be prepended to links if the link does not
 *                      start with one of the <code>schemes</code> given.
 * This value may be {@code null}.
 * @param schemes Array of schemes (eg <code>http://</code>) to check if the link found
 *                contains a scheme. Passing a null or empty value means prepend defaultScheme
 *                to all links.
 * This value may be {@code null}.
 * @param matchFilter  The filter that is used to allow the client code additional control
 *                     over which pattern matches are to be converted into links.
 * This value may be {@code null}.
 * @param transformFilter Filter to allow the client code to update the link found.
 *
 * This value may be {@code null}.
 * @return True if at least one link is found and applied.
 *
 * @see #addLinks(Spannable, Pattern, String, String[], MatchFilter, TransformFilter, Function)
 * @apiSince 24
 */

public static final boolean addLinks(@androidx.annotation.NonNull android.text.Spannable spannable, @androidx.annotation.NonNull java.util.regex.Pattern pattern, @androidx.annotation.Nullable java.lang.String defaultScheme, @androidx.annotation.Nullable java.lang.String[] schemes, @androidx.annotation.Nullable android.text.util.Linkify.MatchFilter matchFilter, @androidx.annotation.Nullable android.text.util.Linkify.TransformFilter transformFilter) { throw new RuntimeException("Stub!"); }

/**
 * Applies a regex to a Spannable turning the matches into links.
 *
 * @param spannable       spannable whose text is to be marked-up with links.
 * This value must never be {@code null}.
 * @param pattern         regex pattern to be used for finding links.
 * This value must never be {@code null}.
 * @param defaultScheme   the default scheme to be prepended to links if the link does not
 *                        start with one of the <code>schemes</code> given.
 * This value may be {@code null}.
 * @param schemes         array of schemes (eg <code>http://</code>) to check if the link found
 *                        contains a scheme. Passing a null or empty value means prepend
 *                        defaultScheme
 *                        to all links.
 * This value may be {@code null}.
 * @param matchFilter     the filter that is used to allow the client code additional control
 *                        over which pattern matches are to be converted into links.
 * This value may be {@code null}.
 * @param transformFilter filter to allow the client code to update the link found.
 * This value may be {@code null}.
 * @param urlSpanFactory  function used to create {@link android.text.style.URLSpan URLSpan}s
 *
 * This value may be {@code null}.
 * @return True if at least one link is found and applied.
 * @apiSince 29
 */

public static final boolean addLinks(@androidx.annotation.NonNull android.text.Spannable spannable, @androidx.annotation.NonNull java.util.regex.Pattern pattern, @androidx.annotation.Nullable java.lang.String defaultScheme, @androidx.annotation.Nullable java.lang.String[] schemes, @androidx.annotation.Nullable android.text.util.Linkify.MatchFilter matchFilter, @androidx.annotation.Nullable android.text.util.Linkify.TransformFilter transformFilter, @androidx.annotation.Nullable java.util.function.Function<java.lang.String,android.text.style.URLSpan> urlSpanFactory) { throw new RuntimeException("Stub!"); }

/**
 *  Bit mask indicating that all available patterns should be matched in
 *  methods that take an options mask
 *  <p><strong>Note:</strong></p> {@link #MAP_ADDRESSES} is deprecated.
 *  Use {@link android.view.textclassifier.TextClassifier#generateLinks(TextLinks.Request)}
 *  instead and avoid it even when targeting API levels where no alternative is available.
 * @apiSince 1
 */

public static final int ALL = 15; // 0xf

/**
 *  Bit field indicating that email addresses should be matched in methods
 *  that take an options mask
 * @apiSince 1
 */

public static final int EMAIL_ADDRESSES = 2; // 0x2

/**
 *  Bit field indicating that street addresses should be matched in methods that
 *  take an options mask. Note that this should be avoided, as it uses the
 *  {@link android.webkit.WebView#findAddress(String)} method, which has various
 *  limitations and has been deprecated: see the documentation for
 *  {@link android.webkit.WebView#findAddress(String)} for more information.
 *
 *  @deprecated use {@link android.view.textclassifier.TextClassifier#generateLinks(
 *  TextLinks.Request)} instead and avoid it even when targeting API levels where no alternative
 *  is available.
 * @apiSince 1
 * @deprecatedSince 28
 */

@Deprecated public static final int MAP_ADDRESSES = 8; // 0x8

/**
 *  Bit field indicating that phone numbers should be matched in methods that
 *  take an options mask
 * @apiSince 1
 */

public static final int PHONE_NUMBERS = 4; // 0x4

/**
 *  Bit field indicating that web URLs should be matched in methods that
 *  take an options mask
 * @apiSince 1
 */

public static final int WEB_URLS = 1; // 0x1

/**
 *  Filters out URL matches that don't have enough digits to be a
 *  phone number.
 * @apiSince 1
 */

public static final android.text.util.Linkify.MatchFilter sPhoneNumberMatchFilter;
static { sPhoneNumberMatchFilter = null; }

/**
 *  Transforms matched phone number text into something suitable
 *  to be used in a tel: URL.  It does this by removing everything
 *  but the digits and plus signs.  For instance:
 *  &apos;+1 (919) 555-1212&apos;
 *  becomes &apos;+19195551212&apos;
 * @apiSince 1
 */

public static final android.text.util.Linkify.TransformFilter sPhoneNumberTransformFilter;
static { sPhoneNumberTransformFilter = null; }

/**
 *  Filters out web URL matches that occur after an at-sign (@).  This is
 *  to prevent turning the domain name in an email address into a web link.
 * @apiSince 1
 */

public static final android.text.util.Linkify.MatchFilter sUrlMatchFilter;
static { sUrlMatchFilter = null; }
/**
 *  MatchFilter enables client code to have more control over
 *  what is allowed to match and become a link, and what is not.
 *
 *  For example:  when matching web URLs you would like things like
 *  http://www.example.com to match, as well as just example.com itelf.
 *  However, you would not want to match against the domain in
 *  support@example.com.  So, when matching against a web URL pattern you
 *  might also include a MatchFilter that disallows the match if it is
 *  immediately preceded by an at-sign (@).
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface MatchFilter {

/**
 *  Examines the character span matched by the pattern and determines
 *  if the match should be turned into an actionable link.
 *
 *  @param s        The body of text against which the pattern
 *                  was matched
 *  @param start    The index of the first character in s that was
 *                  matched by the pattern - inclusive
 *  @param end      The index of the last character in s that was
 *                  matched - exclusive
 *
 *  @return         Whether this match should be turned into a link
 * @apiSince 1
 */

public boolean acceptMatch(java.lang.CharSequence s, int start, int end);
}

/**
 *  TransformFilter enables client code to have more control over
 *  how matched patterns are represented as URLs.
 *
 *  For example:  when converting a phone number such as (919)  555-1212
 *  into a tel: URL the parentheses, white space, and hyphen need to be
 *  removed to produce tel:9195551212.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface TransformFilter {

/**
 *  Examines the matched text and either passes it through or uses the
 *  data in the Matcher state to produce a replacement.
 *
 *  @param match    The regex matcher state that found this URL text
 *  @param url      The text that was matched
 *
 *  @return         The transformed form of the URL
 * @apiSince 1
 */

public java.lang.String transformUrl(java.util.regex.Matcher match, java.lang.String url);
}

}

