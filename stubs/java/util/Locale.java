/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1996, 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

/*
 * (C) Copyright Taligent, Inc. 1996, 1997 - All Rights Reserved
 * (C) Copyright IBM Corp. 1996 - 1998 - All Rights Reserved
 *
 * The original version of this source code and documentation
 * is copyrighted and owned by Taligent, Inc., a wholly-owned
 * subsidiary of IBM. These materials are provided under terms
 * of a License Agreement between Taligent and Sun. This technology
 * is protected by multiple US and International patents.
 *
 * This notice and attribution to Taligent may not be removed.
 * Taligent is a registered trademark of Taligent, Inc.
 *
 */



package java.util;


/**
 * A <code>Locale</code> object represents a specific geographical, political,
 * or cultural region. An operation that requires a <code>Locale</code> to perform
 * its task is called <em>locale-sensitive</em> and uses the <code>Locale</code>
 * to tailor information for the user. For example, displaying a number
 * is a locale-sensitive operation&mdash; the number should be formatted
 * according to the customs and conventions of the user's native country,
 * region, or culture.
 *
 * <p> The {@code Locale} class implements IETF BCP 47 which is composed of
 * <a href="http://tools.ietf.org/html/rfc4647">RFC 4647 "Matching of Language
 * Tags"</a> and <a href="http://tools.ietf.org/html/rfc5646">RFC 5646 "Tags
 * for Identifying Languages"</a> with support for the LDML (UTS#35, "Unicode
 * Locale Data Markup Language") BCP 47-compatible extensions for locale data
 * exchange.
 *
 * <p> A <code>Locale</code> object logically consists of the fields
 * described below.
 *
 * <dl>
 *   <dt><a name="def_language"><b>language</b></a></dt>
 *
 *   <dd>ISO 639 alpha-2 or alpha-3 language code, or registered
 *   language subtags up to 8 alpha letters (for future enhancements).
 *   When a language has both an alpha-2 code and an alpha-3 code, the
 *   alpha-2 code must be used.  You can find a full list of valid
 *   language codes in the IANA Language Subtag Registry (search for
 *   "Type: language").  The language field is case insensitive, but
 *   <code>Locale</code> always canonicalizes to lower case.</dd>
 *
 *   <dd>Well-formed language values have the form
 *   <code>[a-zA-Z]{2,8}</code>.  Note that this is not the the full
 *   BCP47 language production, since it excludes extlang.  They are
 *   not needed since modern three-letter language codes replace
 *   them.</dd>
 *
 *   <dd>Example: "en" (English), "ja" (Japanese), "kok" (Konkani)</dd>
 *
 *   <dt><a name="def_script"><b>script</b></a></dt>
 *
 *   <dd>ISO 15924 alpha-4 script code.  You can find a full list of
 *   valid script codes in the IANA Language Subtag Registry (search
 *   for "Type: script").  The script field is case insensitive, but
 *   <code>Locale</code> always canonicalizes to title case (the first
 *   letter is upper case and the rest of the letters are lower
 *   case).</dd>
 *
 *   <dd>Well-formed script values have the form
 *   <code>[a-zA-Z]{4}</code></dd>
 *
 *   <dd>Example: "Latn" (Latin), "Cyrl" (Cyrillic)</dd>
 *
 *   <dt><a name="def_region"><b>country (region)</b></a></dt>
 *
 *   <dd>ISO 3166 alpha-2 country code or UN M.49 numeric-3 area code.
 *   You can find a full list of valid country and region codes in the
 *   IANA Language Subtag Registry (search for "Type: region").  The
 *   country (region) field is case insensitive, but
 *   <code>Locale</code> always canonicalizes to upper case.</dd>
 *
 *   <dd>Well-formed country/region values have
 *   the form <code>[a-zA-Z]{2} | [0-9]{3}</code></dd>
 *
 *   <dd>Example: "US" (United States), "FR" (France), "029"
 *   (Caribbean)</dd>
 *
 *   <dt><a name="def_variant"><b>variant</b></a></dt>
 *
 *   <dd>Any arbitrary value used to indicate a variation of a
 *   <code>Locale</code>.  Where there are two or more variant values
 *   each indicating its own semantics, these values should be ordered
 *   by importance, with most important first, separated by
 *   underscore('_').  The variant field is case sensitive.</dd>
 *
 *   <dd>Note: IETF BCP 47 places syntactic restrictions on variant
 *   subtags.  Also BCP 47 subtags are strictly used to indicate
 *   additional variations that define a language or its dialects that
 *   are not covered by any combinations of language, script and
 *   region subtags.  You can find a full list of valid variant codes
 *   in the IANA Language Subtag Registry (search for "Type: variant").
 *
 *   <p>However, the variant field in <code>Locale</code> has
 *   historically been used for any kind of variation, not just
 *   language variations.  For example, some supported variants
 *   available in Java SE Runtime Environments indicate alternative
 *   cultural behaviors such as calendar type or number script.  In
 *   BCP 47 this kind of information, which does not identify the
 *   language, is supported by extension subtags or private use
 *   subtags.</dd>
 *
 *   <dd>Well-formed variant values have the form <code>SUBTAG
 *   (('_'|'-') SUBTAG)*</code> where <code>SUBTAG =
 *   [0-9][0-9a-zA-Z]{3} | [0-9a-zA-Z]{5,8}</code>. (Note: BCP 47 only
 *   uses hyphen ('-') as a delimiter, this is more lenient).</dd>
 *
 *   <dd>Example: "polyton" (Polytonic Greek), "POSIX"</dd>
 *
 *   <dt><a name="def_extensions"><b>extensions</b></a></dt>
 *
 *   <dd>A map from single character keys to string values, indicating
 *   extensions apart from language identification.  The extensions in
 *   <code>Locale</code> implement the semantics and syntax of BCP 47
 *   extension subtags and private use subtags. The extensions are
 *   case insensitive, but <code>Locale</code> canonicalizes all
 *   extension keys and values to lower case. Note that extensions
 *   cannot have empty values.</dd>
 *
 *   <dd>Well-formed keys are single characters from the set
 *   <code>[0-9a-zA-Z]</code>.  Well-formed values have the form
 *   <code>SUBTAG ('-' SUBTAG)*</code> where for the key 'x'
 *   <code>SUBTAG = [0-9a-zA-Z]{1,8}</code> and for other keys
 *   <code>SUBTAG = [0-9a-zA-Z]{2,8}</code> (that is, 'x' allows
 *   single-character subtags).</dd>
 *
 *   <dd>Example: key="u"/value="ca-japanese" (Japanese Calendar),
 *   key="x"/value="java-1-7"</dd>
 * </dl>
 *
 * <b>Note:</b> Although BCP 47 requires field values to be registered
 * in the IANA Language Subtag Registry, the <code>Locale</code> class
 * does not provide any validation features.  The <code>Builder</code>
 * only checks if an individual field satisfies the syntactic
 * requirement (is well-formed), but does not validate the value
 * itself.  See {@link java.util.Locale.Builder Builder} for details.
 *
 * <h3><a name="def_locale_extension">Unicode locale/language extension</a></h3>
 *
 * <p>UTS#35, "Unicode Locale Data Markup Language" defines optional
 * attributes and keywords to override or refine the default behavior
 * associated with a locale.  A keyword is represented by a pair of
 * key and type.  For example, "nu-thai" indicates that Thai local
 * digits (value:"thai") should be used for formatting numbers
 * (key:"nu").
 *
 * <p>The keywords are mapped to a BCP 47 extension value using the
 * extension key 'u' ({@link #UNICODE_LOCALE_EXTENSION}).  The above
 * example, "nu-thai", becomes the extension "u-nu-thai".code
 *
 * <p>Thus, when a <code>Locale</code> object contains Unicode locale
 * attributes and keywords,
 * <code>getExtension(UNICODE_LOCALE_EXTENSION)</code> will return a
 * String representing this information, for example, "nu-thai".  The
 * <code>Locale</code> class also provides {@link
 * #getUnicodeLocaleAttributes}, {@link #getUnicodeLocaleKeys}, and
 * {@link #getUnicodeLocaleType} which allow you to access Unicode
 * locale attributes and key/type pairs directly.  When represented as
 * a string, the Unicode Locale Extension lists attributes
 * alphabetically, followed by key/type sequences with keys listed
 * alphabetically (the order of subtags comprising a key's type is
 * fixed when the type is defined)
 *
 * <p>A well-formed locale key has the form
 * <code>[0-9a-zA-Z]{2}</code>.  A well-formed locale type has the
 * form <code>"" | [0-9a-zA-Z]{3,8} ('-' [0-9a-zA-Z]{3,8})*</code> (it
 * can be empty, or a series of subtags 3-8 alphanums in length).  A
 * well-formed locale attribute has the form
 * <code>[0-9a-zA-Z]{3,8}</code> (it is a single subtag with the same
 * form as a locale type subtag).
 *
 * <p>The Unicode locale extension specifies optional behavior in
 * locale-sensitive services.  Although the LDML specification defines
 * various keys and values, actual locale-sensitive service
 * implementations in a Java Runtime Environment might not support any
 * particular Unicode locale attributes or key/type pairs.
 *
 * <h4>Creating a Locale</h4>
 *
 * <p>There are several different ways to create a <code>Locale</code>
 * object.
 *
 * <h5>Builder</h5>
 *
 * <p>Using {@link java.util.Locale.Builder Builder} you can construct a <code>Locale</code> object
 * that conforms to BCP 47 syntax.
 *
 * <h5>Constructors</h5>
 *
 * <p>The <code>Locale</code> class provides three constructors:
 * <blockquote>
 * <pre>
 *     {@link #Locale(java.lang.String)}
 *     {@link #Locale(java.lang.String,java.lang.String)}
 *     {@link #Locale(java.lang.String,java.lang.String,java.lang.String)}
 * </pre>
 * </blockquote>
 * These constructors allow you to create a <code>Locale</code> object
 * with language, country and variant, but you cannot specify
 * script or extensions.
 *
 * <h5>Factory Methods</h5>
 *
 * <p>The method {@link #forLanguageTag} creates a <code>Locale</code>
 * object for a well-formed BCP 47 language tag.
 *
 * <h5>Locale Constants</h5>
 *
 * <p>The <code>Locale</code> class provides a number of convenient constants
 * that you can use to create <code>Locale</code> objects for commonly used
 * locales. For example, the following creates a <code>Locale</code> object
 * for the United States:
 * <blockquote>
 * <pre>
 *     Locale.US
 * </pre>
 * </blockquote>
 *
 * <h4><a name="LocaleMatching">Locale Matching</a></h4>
 *
 * <p>If an application or a system is internationalized and provides localized
 * resources for multiple locales, it sometimes needs to find one or more
 * locales (or language tags) which meet each user's specific preferences. Note
 * that a term "language tag" is used interchangeably with "locale" in this
 * locale matching documentation.
 *
 * <p>In order to do matching a user's preferred locales to a set of language
 * tags, <a href="http://tools.ietf.org/html/rfc4647">RFC 4647 Matching of
 * Language Tags</a> defines two mechanisms: filtering and lookup.
 * <em>Filtering</em> is used to get all matching locales, whereas
 * <em>lookup</em> is to choose the best matching locale.
 * Matching is done case-insensitively. These matching mechanisms are described
 * in the following sections.
 *
 * <p>A user's preference is called a <em>Language Priority List</em> and is
 * expressed as a list of language ranges. There are syntactically two types of
 * language ranges: basic and extended. See
 * {@link java.util.Locale.LanguageRange Locale.LanguageRange} for details.
 *
 * <h5>Filtering</h5>
 *
 * <p>The filtering operation returns all matching language tags. It is defined
 * in RFC 4647 as follows:
 * "In filtering, each language range represents the least specific language
 * tag (that is, the language tag with fewest number of subtags) that is an
 * acceptable match. All of the language tags in the matching set of tags will
 * have an equal or greater number of subtags than the language range. Every
 * non-wildcard subtag in the language range will appear in every one of the
 * matching language tags."
 *
 * <p>There are two types of filtering: filtering for basic language ranges
 * (called "basic filtering") and filtering for extended language ranges
 * (called "extended filtering"). They may return different results by what
 * kind of language ranges are included in the given Language Priority List.
 * {@link java.util.Locale.FilteringMode Locale.FilteringMode} is a parameter to specify how filtering should
 * be done.
 *
 * <h5>Lookup</h5>
 *
 * <p>The lookup operation returns the best matching language tags. It is
 * defined in RFC 4647 as follows:
 * "By contrast with filtering, each language range represents the most
 * specific tag that is an acceptable match.  The first matching tag found,
 * according to the user's priority, is considered the closest match and is the
 * item returned."
 *
 * <p>For example, if a Language Priority List consists of two language ranges,
 * {@code "zh-Hant-TW"} and {@code "en-US"}, in prioritized order, lookup
 * method progressively searches the language tags below in order to find the
 * best matching language tag.
 * <blockquote>
 * <pre>
 *    1. zh-Hant-TW
 *    2. zh-Hant
 *    3. zh
 *    4. en-US
 *    5. en
 * </pre>
 * </blockquote>
 * If there is a language tag which matches completely to a language range
 * above, the language tag is returned.
 *
 * <p>{@code "*"} is the special language range, and it is ignored in lookup.
 *
 * <p>If multiple language tags match as a result of the subtag {@code '*'}
 * included in a language range, the first matching language tag returned by
 * an {@link java.util.Iterator Iterator} over a {@link java.util.Collection Collection} of language tags is treated as
 * the best matching one.
 *
 * <h4>Use of Locale</h4>
 *
 * <p>Once you've created a <code>Locale</code> you can query it for information
 * about itself. Use <code>getCountry</code> to get the country (or region)
 * code and <code>getLanguage</code> to get the language code.
 * You can use <code>getDisplayCountry</code> to get the
 * name of the country suitable for displaying to the user. Similarly,
 * you can use <code>getDisplayLanguage</code> to get the name of
 * the language suitable for displaying to the user. Interestingly,
 * the <code>getDisplayXXX</code> methods are themselves locale-sensitive
 * and have two versions: one that uses the default
 * {@link java.util.Locale.Category#DISPLAY Locale.Category#DISPLAY} locale and one
 * that uses the locale specified as an argument.
 *
 * <p>The Java Platform provides a number of classes that perform locale-sensitive
 * operations. For example, the <code>NumberFormat</code> class formats
 * numbers, currency, and percentages in a locale-sensitive manner. Classes
 * such as <code>NumberFormat</code> have several convenience methods
 * for creating a default object of that type. For example, the
 * <code>NumberFormat</code> class provides these three convenience methods
 * for creating a default <code>NumberFormat</code> object:
 * <blockquote>
 * <pre>
 *     NumberFormat.getInstance()
 *     NumberFormat.getCurrencyInstance()
 *     NumberFormat.getPercentInstance()
 * </pre>
 * </blockquote>
 * Each of these methods has two variants; one with an explicit locale
 * and one without; the latter uses the default
 * {@link java.util.Locale.Category#FORMAT Locale.Category#FORMAT} locale:
 * <blockquote>
 * <pre>
 *     NumberFormat.getInstance(myLocale)
 *     NumberFormat.getCurrencyInstance(myLocale)
 *     NumberFormat.getPercentInstance(myLocale)
 * </pre>
 * </blockquote>
 * A <code>Locale</code> is the mechanism for identifying the kind of object
 * (<code>NumberFormat</code>) that you would like to get. The locale is
 * <STRONG>just</STRONG> a mechanism for identifying objects,
 * <STRONG>not</STRONG> a container for the objects themselves.
 *
 * <h4>Compatibility</h4>
 *
 * <p>In order to maintain compatibility with existing usage, Locale's
 * constructors retain their behavior prior to the Java Runtime
 * Environment version 1.7.  The same is largely true for the
 * <code>toString</code> method. Thus Locale objects can continue to
 * be used as they were. In particular, clients who parse the output
 * of toString into language, country, and variant fields can continue
 * to do so (although this is strongly discouraged), although the
 * variant field will have additional information in it if script or
 * extensions are present.
 *
 * <p>In addition, BCP 47 imposes syntax restrictions that are not
 * imposed by Locale's constructors. This means that conversions
 * between some Locales and BCP 47 language tags cannot be made without
 * losing information. Thus <code>toLanguageTag</code> cannot
 * represent the state of locales whose language, country, or variant
 * do not conform to BCP 47.
 *
 * <p>Because of these issues, it is recommended that clients migrate
 * away from constructing non-conforming locales and use the
 * <code>forLanguageTag</code> and <code>Locale.Builder</code> APIs instead.
 * Clients desiring a string representation of the complete locale can
 * then always rely on <code>toLanguageTag</code> for this purpose.
 *
 * <h5><a name="special_cases_constructor">Special cases</a></h5>
 *
 * <p>For compatibility reasons, two
 * non-conforming locales are treated as special cases.  These are
 * <b><tt>ja_JP_JP</tt></b> and <b><tt>th_TH_TH</tt></b>. These are ill-formed
 * in BCP 47 since the variants are too short. To ease migration to BCP 47,
 * these are treated specially during construction.  These two cases (and only
 * these) cause a constructor to generate an extension, all other values behave
 * exactly as they did prior to Java 7.
 *
 * <p>Java has used <tt>ja_JP_JP</tt> to represent Japanese as used in
 * Japan together with the Japanese Imperial calendar. This is now
 * representable using a Unicode locale extension, by specifying the
 * Unicode locale key <tt>ca</tt> (for "calendar") and type
 * <tt>japanese</tt>. When the Locale constructor is called with the
 * arguments "ja", "JP", "JP", the extension "u-ca-japanese" is
 * automatically added.
 *
 * <p>Java has used <tt>th_TH_TH</tt> to represent Thai as used in
 * Thailand together with Thai digits. This is also now representable using
 * a Unicode locale extension, by specifying the Unicode locale key
 * <tt>nu</tt> (for "number") and value <tt>thai</tt>. When the Locale
 * constructor is called with the arguments "th", "TH", "TH", the
 * extension "u-nu-thai" is automatically added.
 *
 * <h5>Serialization</h5>
 *
 * <p>During serialization, writeObject writes all fields to the output
 * stream, including extensions.
 *
 * <p>During deserialization, readResolve adds extensions as described
 * in <a href="#special_cases_constructor">Special Cases</a>, only
 * for the two cases th_TH_TH and ja_JP_JP.
 *
 * <h5>Legacy language codes</h5>
 *
 * <p>Locale's constructor has always converted three language codes to
 * their earlier, obsoleted forms: <tt>he</tt> maps to <tt>iw</tt>,
 * <tt>yi</tt> maps to <tt>ji</tt>, and <tt>id</tt> maps to
 * <tt>in</tt>.  This continues to be the case, in order to not break
 * backwards compatibility.
 *
 * <p>The APIs added in 1.7 map between the old and new language codes,
 * maintaining the old codes internal to Locale (so that
 * <code>getLanguage</code> and <code>toString</code> reflect the old
 * code), but using the new codes in the BCP 47 language tag APIs (so
 * that <code>toLanguageTag</code> reflects the new one). This
 * preserves the equivalence between Locales no matter which code or
 * API is used to construct them. Java's default resource bundle
 * lookup mechanism also implements this mapping, so that resources
 * can be named using either convention, see {@link java.util.ResourceBundle.Control ResourceBundle.Control}.
 *
 * <h5>Three-letter language/country(region) codes</h5>
 *
 * <p>The Locale constructors have always specified that the language
 * and the country param be two characters in length, although in
 * practice they have accepted any length.  The specification has now
 * been relaxed to allow language codes of two to eight characters and
 * country (region) codes of two to three characters, and in
 * particular, three-letter language codes and three-digit region
 * codes as specified in the IANA Language Subtag Registry.  For
 * compatibility, the implementation still does not impose a length
 * constraint.
 *
 * <a name="locale_data"></a><h4>Locale data</h4>
 * <p>Note that locale data comes solely from ICU. User-supplied locale service providers (using
 * the {@code java.text.spi} or {@code java.util.spi} mechanisms) are not supported.
 *
 * <p>Here are the versions of ICU (and the corresponding CLDR and Unicode versions) used in
 * various Android releases:
 * <table BORDER="1" WIDTH="100%" CELLPADDING="3" CELLSPACING="0" SUMMARY="">
 * <tr><td>Android 1.5 (Cupcake)/Android 1.6 (Donut)/Android 2.0 (Eclair)</td>
 *     <td>ICU 3.8</td>
 *     <td><a href="http://cldr.unicode.org/index/downloads/cldr-1-5">CLDR 1.5</a></td>
 *     <td><a href="http://www.unicode.org/versions/Unicode5.0.0/">Unicode 5.0</a></td></tr>
 * <tr><td>Android 2.2 (Froyo)</td>
 *     <td>ICU 4.2</td>
 *     <td><a href="http://cldr.unicode.org/index/downloads/cldr-1-7">CLDR 1.7</a></td>
 *     <td><a href="http://www.unicode.org/versions/Unicode5.1.0/">Unicode 5.1</a></td></tr>
 * <tr><td>Android 2.3 (Gingerbread)/Android 3.0 (Honeycomb)</td>
 *     <td>ICU 4.4</td>
 *     <td><a href="http://cldr.unicode.org/index/downloads/cldr-1-8">CLDR 1.8</a></td>
 *     <td><a href="http://www.unicode.org/versions/Unicode5.2.0/">Unicode 5.2</a></td></tr>
 * <tr><td>Android 4.0 (Ice Cream Sandwich)</td>
 *     <td><a href="http://site.icu-project.org/download/46">ICU 4.6</a></td>
 *     <td><a href="http://cldr.unicode.org/index/downloads/cldr-1-9">CLDR 1.9</a></td>
 *     <td><a href="http://www.unicode.org/versions/Unicode6.0.0/">Unicode 6.0</a></td></tr>
 * <tr><td>Android 4.1 (Jelly Bean)</td>
 *     <td><a href="http://site.icu-project.org/download/48">ICU 4.8</a></td>
 *     <td><a href="http://cldr.unicode.org/index/downloads/cldr-2-0">CLDR 2.0</a></td>
 *     <td><a href="http://www.unicode.org/versions/Unicode6.0.0/">Unicode 6.0</a></td></tr>
 * <tr><td>Android 4.3 (Jelly Bean MR2)</td>
 *     <td><a href="http://site.icu-project.org/download/50">ICU 50</a></td>
 *     <td><a href="http://cldr.unicode.org/index/downloads/cldr-22-1">CLDR 22.1</a></td>
 *     <td><a href="http://www.unicode.org/versions/Unicode6.2.0/">Unicode 6.2</a></td></tr>
 * <tr><td>Android 4.4 (KitKat)</td>
 *     <td><a href="http://site.icu-project.org/download/51">ICU 51</a></td>
 *     <td><a href="http://cldr.unicode.org/index/downloads/cldr-23">CLDR 23</a></td>
 *     <td><a href="http://www.unicode.org/versions/Unicode6.2.0/">Unicode 6.2</a></td></tr>
 * <tr><td>Android 5.0 (Lollipop)</td>
 *     <td><a href="http://site.icu-project.org/download/53">ICU 53</a></td>
 *     <td><a href="http://cldr.unicode.org/index/downloads/cldr-25">CLDR 25</a></td>
 *     <td><a href="http://www.unicode.org/versions/Unicode6.3.0/">Unicode 6.3</a></td></tr>
 * <tr><td>Android 6.0 (Marshmallow)</td>
 *     <td><a href="http://site.icu-project.org/download/55">ICU 55.1</a></td>
 *     <td><a href="http://cldr.unicode.org/index/downloads/cldr-27">CLDR 27.0.1</a></td>
 *     <td><a href="http://www.unicode.org/versions/Unicode7.0.0/">Unicode 7.0</a></td></tr>
 * <tr><td>Android 7.0 (Nougat)</td>
 *     <td><a href="http://site.icu-project.org/download/56">ICU 56.1</a></td>
 *     <td><a href="http://cldr.unicode.org/index/downloads/cldr-28">CLDR 28</a></td>
 *     <td><a href="http://www.unicode.org/versions/Unicode8.0.0/">Unicode 8.0</a></td></tr>
 * <tr><td>Android 8.0 (Oreo)</td>
 *     <td><a href="http://site.icu-project.org/download/58">ICU 58.2</a></td>
 *     <td><a href="http://cldr.unicode.org/index/downloads/cldr-30">CLDR 30.0.3</a></td>
 *     <td><a href="http://www.unicode.org/versions/Unicode9.0.0/">Unicode 9.0</a></td></tr>
 * <tr><td>Android 9.0 (Pie)</td>
 *     <td><a href="http://site.icu-project.org/download/60">ICU 60.2</a></td>
 *     <td><a href="http://cldr.unicode.org/index/downloads/cldr-32">CLDR 32.0.1</a></td>
 *     <td><a href="http://www.unicode.org/versions/Unicode10.0.0/">Unicode 10.0</a></td></tr>
 * <tr><td>Android 10.0 (Q)</td>
 *     <td><a href="http://site.icu-project.org/download/63">ICU 63.2</a></td>
 *     <td><a href="http://cldr.unicode.org/index/downloads/cldr-34">CLDR 34</a></td>
 *     <td><a href="http://www.unicode.org/versions/Unicode11.0.0/">Unicode 11.0</a></td></tr>
 * </table>
 *
 * <a name="default_locale"></a><h4>Be wary of the default locale</h3>
 * <p>Note that there are many convenience methods that automatically use the default locale, but
 * using them may lead to subtle bugs.
 *
 * <p>The default locale is appropriate for tasks that involve presenting data to the user. In
 * this case, you want to use the user's date/time formats, number
 * formats, rules for conversion to lowercase, and so on. In this case, it's safe to use the
 * convenience methods.
 *
 * <p>The default locale is <i>not</i> appropriate for machine-readable output. The best choice
 * there is usually {@code Locale.US}&nbsp;&ndash; this locale is guaranteed to be available on all
 * devices, and the fact that it has no surprising special cases and is frequently used (especially
 * for computer-computer communication) means that it tends to be the most efficient choice too.
 *
 * <p>A common mistake is to implicitly use the default locale when producing output meant to be
 * machine-readable. This tends to work on the developer's test devices (especially because so many
 * developers use en_US), but fails when run on a device whose user is in a more complex locale.
 *
 * <p>For example, if you're formatting integers some locales will use non-ASCII decimal
 * digits. As another example, if you're formatting floating-point numbers some locales will use
 * {@code ','} as the decimal point and {@code '.'} for digit grouping. That's correct for
 * human-readable output, but likely to cause problems if presented to another
 * computer ({@link java.lang.Double#parseDouble Double#parseDouble} can't parse such a number, for example).
 * You should also be wary of the {@link java.lang.String#toLowerCase String#toLowerCase} and
 * {@link java.lang.String#toUpperCase String#toUpperCase} overloads that don't take a {@code Locale}: in Turkey, for example,
 * the characters {@code 'i'} and {@code 'I'} won't be converted to {@code 'I'} and {@code 'i'}.
 * This is the correct behavior for Turkish text (such as user input), but inappropriate for, say,
 * HTTP headers.
 *
 * @see java.util.Locale.Builder
 * @see java.util.ResourceBundle
 * @see java.text.Format
 * @see java.text.NumberFormat
 * @see java.text.Collator
 * @author Mark Davis
 * @since 1.1
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Locale implements java.lang.Cloneable, java.io.Serializable {

/**
 * Construct a locale from language, country and variant.
 * This constructor normalizes the language value to lowercase and
 * the country value to uppercase.
 * <p>
 * <b>Note:</b>
 * <ul>
 * <li>ISO 639 is not a stable standard; some of the language codes it defines
 * (specifically "iw", "ji", and "in") have changed.  This constructor accepts both the
 * old codes ("iw", "ji", and "in") and the new codes ("he", "yi", and "id"), but all other
 * API on Locale will return only the OLD codes.
 * <li>For backward compatibility reasons, this constructor does not make
 * any syntactic checks on the input.
 * <li>The two cases ("ja", "JP", "JP") and ("th", "TH", "TH") are handled specially,
 * see <a href="#special_cases_constructor">Special Cases</a> for more information.
 * </ul>
 *
 * @param language An ISO 639 alpha-2 or alpha-3 language code, or a language subtag
 * up to 8 characters in length.  See the <code>Locale</code> class description about
 * valid language values.
 * @param country An ISO 3166 alpha-2 country code or a UN M.49 numeric-3 area code.
 * See the <code>Locale</code> class description about valid country values.
 * @param variant Any arbitrary value used to indicate a variation of a <code>Locale</code>.
 * See the <code>Locale</code> class description for the details.
 * @exception java.lang.NullPointerException thrown if any argument is null.
 * @apiSince 1
 */

public Locale(@androidx.annotation.NonNull java.lang.String language, @androidx.annotation.NonNull java.lang.String country, @androidx.annotation.NonNull java.lang.String variant) { throw new RuntimeException("Stub!"); }

/**
 * Construct a locale from language and country.
 * This constructor normalizes the language value to lowercase and
 * the country value to uppercase.
 * <p>
 * <b>Note:</b>
 * <ul>
 * <li>ISO 639 is not a stable standard; some of the language codes it defines
 * (specifically "iw", "ji", and "in") have changed.  This constructor accepts both the
 * old codes ("iw", "ji", and "in") and the new codes ("he", "yi", and "id"), but all other
 * API on Locale will return only the OLD codes.
 * <li>For backward compatibility reasons, this constructor does not make
 * any syntactic checks on the input.
 * </ul>
 *
 * @param language An ISO 639 alpha-2 or alpha-3 language code, or a language subtag
 * up to 8 characters in length.  See the <code>Locale</code> class description about
 * valid language values.
 * @param country An ISO 3166 alpha-2 country code or a UN M.49 numeric-3 area code.
 * See the <code>Locale</code> class description about valid country values.
 * @exception java.lang.NullPointerException thrown if either argument is null.
 * @apiSince 1
 */

public Locale(@androidx.annotation.NonNull java.lang.String language, @androidx.annotation.NonNull java.lang.String country) { throw new RuntimeException("Stub!"); }

/**
 * Construct a locale from a language code.
 * This constructor normalizes the language value to lowercase.
 * <p>
 * <b>Note:</b>
 * <ul>
 * <li>ISO 639 is not a stable standard; some of the language codes it defines
 * (specifically "iw", "ji", and "in") have changed.  This constructor accepts both the
 * old codes ("iw", "ji", and "in") and the new codes ("he", "yi", and "id"), but all other
 * API on Locale will return only the OLD codes.
 * <li>For backward compatibility reasons, this constructor does not make
 * any syntactic checks on the input.
 * </ul>
 *
 * @param language An ISO 639 alpha-2 or alpha-3 language code, or a language subtag
 * up to 8 characters in length.  See the <code>Locale</code> class description about
 * valid language values.
 * @exception java.lang.NullPointerException thrown if argument is null.
 * @since 1.4
 * @apiSince 1
 */

public Locale(@androidx.annotation.NonNull java.lang.String language) { throw new RuntimeException("Stub!"); }

/**
 * Gets the current value of the default locale for this instance
 * of the Java Virtual Machine.
 * <p>
 * The Java Virtual Machine sets the default locale during startup
 * based on the host environment. It is used by many locale-sensitive
 * methods if no locale is explicitly specified.
 * It can be changed using the
 * {@link #setDefault(java.util.Locale) setDefault} method.
 *
 * @return the default locale for this instance of the Java Virtual Machine
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.util.Locale getDefault() { throw new RuntimeException("Stub!"); }

/**
 * Gets the current value of the default locale for the specified Category
 * for this instance of the Java Virtual Machine.
 * <p>
 * The Java Virtual Machine sets the default locale during startup based
 * on the host environment. It is used by many locale-sensitive methods
 * if no locale is explicitly specified. It can be changed using the
 * setDefault(Locale.Category, Locale) method.
 *
 * @param category - the specified category to get the default locale
 * @throws java.lang.NullPointerException - if category is null
 * @return the default locale for the specified Category for this instance
 *     of the Java Virtual Machine
 * @see #setDefault(Locale.Category, Locale)
 * @since 1.7
 * @apiSince 24
 */

@androidx.annotation.NonNull
public static java.util.Locale getDefault(@androidx.annotation.NonNull java.util.Locale.Category category) { throw new RuntimeException("Stub!"); }

/**
 * Sets the default locale for this instance of the Java Virtual Machine.
 * This does not affect the host locale.
 * <p>
 * If there is a security manager, its <code>checkPermission</code>
 * method is called with a <code>PropertyPermission("user.language", "write")</code>
 * permission before the default locale is changed.
 * <p>
 * The Java Virtual Machine sets the default locale during startup
 * based on the host environment. It is used by many locale-sensitive
 * methods if no locale is explicitly specified.
 * <p>
 * Since changing the default locale may affect many different areas
 * of functionality, this method should only be used if the caller
 * is prepared to reinitialize locale-sensitive code running
 * within the same Java Virtual Machine.
 * <p>
 * By setting the default locale with this method, all of the default
 * locales for each Category are also set to the specified default locale.
 *
 * @throws java.lang.SecurityException
 *        if a security manager exists and its
 *        <code>checkPermission</code> method doesn't allow the operation.
 * @throws java.lang.NullPointerException if <code>newLocale</code> is null
 * @param newLocale the new default locale
 * @see SecurityManager#checkPermission
 * @see java.util.PropertyPermission
 * @apiSince 1
 */

public static synchronized void setDefault(@androidx.annotation.NonNull java.util.Locale newLocale) { throw new RuntimeException("Stub!"); }

/**
 * Sets the default locale for the specified Category for this instance
 * of the Java Virtual Machine. This does not affect the host locale.
 * <p>
 * If there is a security manager, its checkPermission method is called
 * with a PropertyPermission("user.language", "write") permission before
 * the default locale is changed.
 * <p>
 * The Java Virtual Machine sets the default locale during startup based
 * on the host environment. It is used by many locale-sensitive methods
 * if no locale is explicitly specified.
 * <p>
 * Since changing the default locale may affect many different areas of
 * functionality, this method should only be used if the caller is
 * prepared to reinitialize locale-sensitive code running within the
 * same Java Virtual Machine.
 * <p>
 *
 * @param category - the specified category to set the default locale
 * @param newLocale - the new default locale
 * @throws java.lang.SecurityException - if a security manager exists and its
 *     checkPermission method doesn't allow the operation.
 * @throws java.lang.NullPointerException - if category and/or newLocale is null
 * @see java.lang.SecurityManager#checkPermission(java.security.Permission)
 * @see java.util.PropertyPermission
 * @see #getDefault(Locale.Category)
 * @since 1.7
 * @apiSince 24
 */

public static synchronized void setDefault(@androidx.annotation.NonNull java.util.Locale.Category category, @androidx.annotation.NonNull java.util.Locale newLocale) { throw new RuntimeException("Stub!"); }

/**
 * Returns an array of all installed locales.
 *
 * @return An array of installed locales.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.util.Locale[] getAvailableLocales() { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of all 2-letter country codes defined in ISO 3166.
 * Can be used to create Locales.
 * <p>
 * <b>Note:</b> The <code>Locale</code> class also supports other codes for
 * country (region), such as 3-letter numeric UN M.49 area codes.
 * Therefore, the list returned by this method does not contain ALL valid
 * codes that can be used to create Locales.
 *
 * @return An array of ISO 3166 two-letter country codes.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.String[] getISOCountries() { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of all 2-letter language codes defined in ISO 639.
 * Can be used to create Locales.
 * <p>
 * <b>Note:</b>
 * <ul>
 * <li>ISO 639 is not a stable standard&mdash; some languages' codes have changed.
 * The list this function returns includes both the new and the old codes for the
 * languages whose codes have changed.
 * <li>The <code>Locale</code> class also supports language codes up to
 * 8 characters in length.  Therefore, the list returned by this method does
 * not contain ALL valid codes that can be used to create Locales.
 * </ul>
 *
 * @return Am array of ISO 639 two-letter language codes.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public static java.lang.String[] getISOLanguages() { throw new RuntimeException("Stub!"); }

/**
 * Returns the language code of this Locale.
 *
 * <p><b>Note:</b> ISO 639 is not a stable standard&mdash; some languages' codes have changed.
 * Locale's constructor recognizes both the new and the old codes for the languages
 * whose codes have changed, but this function always returns the old code.  If you
 * want to check for a specific language whose code has changed, don't do
 * <pre>
 * if (locale.getLanguage().equals("he")) // BAD!
 *    ...
 * </pre>
 * Instead, do
 * <pre>
 * if (locale.getLanguage().equals(new Locale("he").getLanguage()))
 *    ...
 * </pre>
 * @return The language code, or the empty string if none is defined.
 * @see #getDisplayLanguage
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String getLanguage() { throw new RuntimeException("Stub!"); }

/**
 * Returns the script for this locale, which should
 * either be the empty string or an ISO 15924 4-letter script
 * code. The first letter is uppercase and the rest are
 * lowercase, for example, 'Latn', 'Cyrl'.
 *
 * @return The script code, or the empty string if none is defined.
 * @see #getDisplayScript
 * @since 1.7
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.lang.String getScript() { throw new RuntimeException("Stub!"); }

/**
 * Returns the country/region code for this locale, which should
 * either be the empty string, an uppercase ISO 3166 2-letter code,
 * or a UN M.49 3-digit code.
 *
 * @return The country/region code, or the empty string if none is defined.
 * @see #getDisplayCountry
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String getCountry() { throw new RuntimeException("Stub!"); }

/**
 * Returns the variant code for this locale.
 *
 * @return The variant code, or the empty string if none is defined.
 * @see #getDisplayVariant
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String getVariant() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this {@code Locale} has any <a href="#def_extensions">
 * extensions</a>.
 *
 * @return {@code true} if this {@code Locale} has any extensions
 * @since 1.8
 * @apiSince 26
 */

public boolean hasExtensions() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this {@code Locale} with no <a href="#def_extensions">
 * extensions</a>. If this {@code Locale} has no extensions, this {@code Locale}
 * is returned.
 *
 * @return a copy of this {@code Locale} with no extensions, or {@code this}
 *         if {@code this} has no extensions
 * @since 1.8
 * @apiSince 26
 */

@androidx.annotation.NonNull
public java.util.Locale stripExtensions() { throw new RuntimeException("Stub!"); }

/**
 * Returns the extension (or private use) value associated with
 * the specified key, or null if there is no extension
 * associated with the key. To be well-formed, the key must be one
 * of <code>[0-9A-Za-z]</code>. Keys are case-insensitive, so
 * for example 'z' and 'Z' represent the same extension.
 *
 * @param key the extension key
 * @return The extension, or null if this locale defines no
 * extension for the specified key.
 * @throws java.lang.IllegalArgumentException if key is not well-formed
 * @see #PRIVATE_USE_EXTENSION
 * @see #UNICODE_LOCALE_EXTENSION
 * @since 1.7
 * @apiSince 21
 */

@androidx.annotation.Nullable
public java.lang.String getExtension(char key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the set of extension keys associated with this locale, or the
 * empty set if it has no extensions. The returned set is unmodifiable.
 * The keys will all be lower-case.
 *
 * @return The set of extension keys, or the empty set if this locale has
 * no extensions.
 * @since 1.7
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.util.Set<java.lang.Character> getExtensionKeys() { throw new RuntimeException("Stub!"); }

/**
 * Returns the set of unicode locale attributes associated with
 * this locale, or the empty set if it has no attributes. The
 * returned set is unmodifiable.
 *
 * @return The set of attributes.
 * @since 1.7
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.util.Set<java.lang.String> getUnicodeLocaleAttributes() { throw new RuntimeException("Stub!"); }

/**
 * Returns the Unicode locale type associated with the specified Unicode locale key
 * for this locale. Returns the empty string for keys that are defined with no type.
 * Returns null if the key is not defined. Keys are case-insensitive. The key must
 * be two alphanumeric characters ([0-9a-zA-Z]), or an IllegalArgumentException is
 * thrown.
 *
 * @param key the Unicode locale key
 * @return The Unicode locale type associated with the key, or null if the
 * locale does not define the key.
 * @throws java.lang.IllegalArgumentException if the key is not well-formed
 * @throws java.lang.NullPointerException if <code>key</code> is null
 * @since 1.7
 * @apiSince 21
 */

@androidx.annotation.Nullable
public java.lang.String getUnicodeLocaleType(@androidx.annotation.NonNull java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the set of Unicode locale keys defined by this locale, or the empty set if
 * this locale has none.  The returned set is immutable.  Keys are all lower case.
 *
 * @return The set of Unicode locale keys, or the empty set if this locale has
 * no Unicode locale keywords.
 * @since 1.7
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.util.Set<java.lang.String> getUnicodeLocaleKeys() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of this <code>Locale</code>
 * object, consisting of language, country, variant, script,
 * and extensions as below:
 * <blockquote>
 * language + "_" + country + "_" + (variant + "_#" | "#") + script + "-" + extensions
 * </blockquote>
 *
 * Language is always lower case, country is always upper case, script is always title
 * case, and extensions are always lower case.  Extensions and private use subtags
 * will be in canonical order as explained in {@link #toLanguageTag}.
 *
 * <p>When the locale has neither script nor extensions, the result is the same as in
 * Java 6 and prior.
 *
 * <p>If both the language and country fields are missing, this function will return
 * the empty string, even if the variant, script, or extensions field is present (you
 * can't have a locale with just a variant, the variant must accompany a well-formed
 * language or country code).
 *
 * <p>If script or extensions are present and variant is missing, no underscore is
 * added before the "#".
 *
 * <p>This behavior is designed to support debugging and to be compatible with
 * previous uses of <code>toString</code> that expected language, country, and variant
 * fields only.  To represent a Locale as a String for interchange purposes, use
 * {@link #toLanguageTag}.
 *
 * <p>Examples: <ul>
 * <li><tt>en</tt></li>
 * <li><tt>de_DE</tt></li>
 * <li><tt>_GB</tt></li>
 * <li><tt>en_US_WIN</tt></li>
 * <li><tt>de__POSIX</tt></li>
 * <li><tt>zh_CN_#Hans</tt></li>
 * <li><tt>zh_TW_#Hant-x-java</tt></li>
 * <li><tt>th_TH_TH_#u-nu-thai</tt></li></ul>
 *
 * @return A string representation of the Locale, for debugging.
 * @see #getDisplayName
 * @see #toLanguageTag
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Returns a well-formed IETF BCP 47 language tag representing
 * this locale.
 *
 * <p>If this <code>Locale</code> has a language, country, or
 * variant that does not satisfy the IETF BCP 47 language tag
 * syntax requirements, this method handles these fields as
 * described below:
 *
 * <p><b>Language:</b> If language is empty, or not <a
 * href="#def_language" >well-formed</a> (for example "a" or
 * "e2"), it will be emitted as "und" (Undetermined).
 *
 * <p><b>Country:</b> If country is not <a
 * href="#def_region">well-formed</a> (for example "12" or "USA"),
 * it will be omitted.
 *
 * <p><b>Variant:</b> If variant <b>is</b> <a
 * href="#def_variant">well-formed</a>, each sub-segment
 * (delimited by '-' or '_') is emitted as a subtag.  Otherwise:
 * <ul>
 *
 * <li>if all sub-segments match <code>[0-9a-zA-Z]{1,8}</code>
 * (for example "WIN" or "Oracle_JDK_Standard_Edition"), the first
 * ill-formed sub-segment and all following will be appended to
 * the private use subtag.  The first appended subtag will be
 * "lvariant", followed by the sub-segments in order, separated by
 * hyphen. For example, "x-lvariant-WIN",
 * "Oracle-x-lvariant-JDK-Standard-Edition".
 *
 * <li>if any sub-segment does not match
 * <code>[0-9a-zA-Z]{1,8}</code>, the variant will be truncated
 * and the problematic sub-segment and all following sub-segments
 * will be omitted.  If the remainder is non-empty, it will be
 * emitted as a private use subtag as above (even if the remainder
 * turns out to be well-formed).  For example,
 * "Solaris_isjustthecoolestthing" is emitted as
 * "x-lvariant-Solaris", not as "solaris".</li></ul>
 *
 * <p><b>Special Conversions:</b> Java supports some old locale
 * representations, including deprecated ISO language codes,
 * for compatibility. This method performs the following
 * conversions:
 * <ul>
 *
 * <li>Deprecated ISO language codes "iw", "ji", and "in" are
 * converted to "he", "yi", and "id", respectively.
 *
 * <li>A locale with language "no", country "NO", and variant
 * "NY", representing Norwegian Nynorsk (Norway), is converted
 * to a language tag "nn-NO".</li></ul>
 *
 * <p><b>Note:</b> Although the language tag created by this
 * method is well-formed (satisfies the syntax requirements
 * defined by the IETF BCP 47 specification), it is not
 * necessarily a valid BCP 47 language tag.  For example,
 * <pre>
 *   new Locale("xx", "YY").toLanguageTag();</pre>
 *
 * will return "xx-YY", but the language subtag "xx" and the
 * region subtag "YY" are invalid because they are not registered
 * in the IANA Language Subtag Registry.
 *
 * @return a BCP47 language tag representing the locale
 * @see #forLanguageTag(String)
 * @since 1.7
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.lang.String toLanguageTag() { throw new RuntimeException("Stub!"); }

/**
 * Returns a locale for the specified IETF BCP 47 language tag string.
 *
 * <p>If the specified language tag contains any ill-formed subtags,
 * the first such subtag and all following subtags are ignored.  Compare
 * to {@link java.util.Locale.Builder#setLanguageTag Locale.Builder#setLanguageTag} which throws an exception
 * in this case.
 *
 * <p>The following <b>conversions</b> are performed:<ul>
 *
 * <li>The language code "und" is mapped to language "".
 *
 * <li>The language codes "he", "yi", and "id" are mapped to "iw",
 * "ji", and "in" respectively. (This is the same canonicalization
 * that's done in Locale's constructors.)
 *
 * <li>The portion of a private use subtag prefixed by "lvariant",
 * if any, is removed and appended to the variant field in the
 * result locale (without case normalization).  If it is then
 * empty, the private use subtag is discarded:
 *
 * <pre>
 *     Locale loc;
 *     loc = Locale.forLanguageTag("en-US-x-lvariant-POSIX");
 *     loc.getVariant(); // returns "POSIX"
 *     loc.getExtension('x'); // returns null
 *
 *     loc = Locale.forLanguageTag("de-POSIX-x-URP-lvariant-Abc-Def");
 *     loc.getVariant(); // returns "POSIX_Abc_Def"
 *     loc.getExtension('x'); // returns "urp"
 * </pre>
 *
 * <li>When the languageTag argument contains an extlang subtag,
 * the first such subtag is used as the language, and the primary
 * language subtag and other extlang subtags are ignored:
 *
 * <pre>
 *     Locale.forLanguageTag("ar-aao").getLanguage(); // returns "aao"
 *     Locale.forLanguageTag("en-abc-def-us").toString(); // returns "abc_US"
 * </pre>
 *
 * <li>Case is normalized except for variant tags, which are left
 * unchanged.  Language is normalized to lower case, script to
 * title case, country to upper case, and extensions to lower
 * case.
 *
 * <li>If, after processing, the locale would exactly match either
 * ja_JP_JP or th_TH_TH with no extensions, the appropriate
 * extensions are added as though the constructor had been called:
 *
 * <pre>
 *    Locale.forLanguageTag("ja-JP-x-lvariant-JP").toLanguageTag();
 *    // returns "ja-JP-u-ca-japanese-x-lvariant-JP"
 *    Locale.forLanguageTag("th-TH-x-lvariant-TH").toLanguageTag();
 *    // returns "th-TH-u-nu-thai-x-lvariant-TH"
 * </pre></ul>
 *
 * <p>This implements the 'Language-Tag' production of BCP47, and
 * so supports grandfathered (regular and irregular) as well as
 * private use language tags.  Stand alone private use tags are
 * represented as empty language and extension 'x-whatever',
 * and grandfathered tags are converted to their canonical replacements
 * where they exist.
 *
 * <p>Grandfathered tags with canonical replacements are as follows:
 *
 * <table summary="Grandfathered tags with canonical replacements">
 * <tbody align="center">
 * <tr><th>grandfathered tag</th><th>&nbsp;</th><th>modern replacement</th></tr>
 * <tr><td>art-lojban</td><td>&nbsp;</td><td>jbo</td></tr>
 * <tr><td>i-ami</td><td>&nbsp;</td><td>ami</td></tr>
 * <tr><td>i-bnn</td><td>&nbsp;</td><td>bnn</td></tr>
 * <tr><td>i-hak</td><td>&nbsp;</td><td>hak</td></tr>
 * <tr><td>i-klingon</td><td>&nbsp;</td><td>tlh</td></tr>
 * <tr><td>i-lux</td><td>&nbsp;</td><td>lb</td></tr>
 * <tr><td>i-navajo</td><td>&nbsp;</td><td>nv</td></tr>
 * <tr><td>i-pwn</td><td>&nbsp;</td><td>pwn</td></tr>
 * <tr><td>i-tao</td><td>&nbsp;</td><td>tao</td></tr>
 * <tr><td>i-tay</td><td>&nbsp;</td><td>tay</td></tr>
 * <tr><td>i-tsu</td><td>&nbsp;</td><td>tsu</td></tr>
 * <tr><td>no-bok</td><td>&nbsp;</td><td>nb</td></tr>
 * <tr><td>no-nyn</td><td>&nbsp;</td><td>nn</td></tr>
 * <tr><td>sgn-BE-FR</td><td>&nbsp;</td><td>sfb</td></tr>
 * <tr><td>sgn-BE-NL</td><td>&nbsp;</td><td>vgt</td></tr>
 * <tr><td>sgn-CH-DE</td><td>&nbsp;</td><td>sgg</td></tr>
 * <tr><td>zh-guoyu</td><td>&nbsp;</td><td>cmn</td></tr>
 * <tr><td>zh-hakka</td><td>&nbsp;</td><td>hak</td></tr>
 * <tr><td>zh-min-nan</td><td>&nbsp;</td><td>nan</td></tr>
 * <tr><td>zh-xiang</td><td>&nbsp;</td><td>hsn</td></tr>
 * </tbody>
 * </table>
 *
 * <p>Grandfathered tags with no modern replacement will be
 * converted as follows:
 *
 * <table summary="Grandfathered tags with no modern replacement">
 * <tbody align="center">
 * <tr><th>grandfathered tag</th><th>&nbsp;</th><th>converts to</th></tr>
 * <tr><td>cel-gaulish</td><td>&nbsp;</td><td>xtg-x-cel-gaulish</td></tr>
 * <tr><td>en-GB-oed</td><td>&nbsp;</td><td>en-GB-x-oed</td></tr>
 * <tr><td>i-default</td><td>&nbsp;</td><td>en-x-i-default</td></tr>
 * <tr><td>i-enochian</td><td>&nbsp;</td><td>und-x-i-enochian</td></tr>
 * <tr><td>i-mingo</td><td>&nbsp;</td><td>see-x-i-mingo</td></tr>
 * <tr><td>zh-min</td><td>&nbsp;</td><td>nan-x-zh-min</td></tr>
 * </tbody>
 * </table>
 *
 * <p>For a list of all grandfathered tags, see the
 * IANA Language Subtag Registry (search for "Type: grandfathered").
 *
 * <p><b>Note</b>: there is no guarantee that <code>toLanguageTag</code>
 * and <code>forLanguageTag</code> will round-trip.
 *
 * @param languageTag the language tag
 * @return The locale that best represents the language tag.
 * @throws java.lang.NullPointerException if <code>languageTag</code> is <code>null</code>
 * @see #toLanguageTag()
 * @see java.util.Locale.Builder#setLanguageTag(String)
 * @since 1.7
 * @apiSince 21
 */

@androidx.annotation.NonNull
public static java.util.Locale forLanguageTag(@androidx.annotation.NonNull java.lang.String languageTag) { throw new RuntimeException("Stub!"); }

/**
 * Returns a three-letter abbreviation of this locale's language.
 * If the language matches an ISO 639-1 two-letter code, the
 * corresponding ISO 639-2/T three-letter lowercase code is
 * returned.  The ISO 639-2 language codes can be found on-line,
 * see "Codes for the Representation of Names of Languages Part 2:
 * Alpha-3 Code".  If the locale specifies a three-letter
 * language, the language is returned as is.  If the locale does
 * not specify a language the empty string is returned.
 *
 * @return A three-letter abbreviation of this locale's language.
 * @exception java.util.MissingResourceException Throws MissingResourceException if
 * three-letter language abbreviation is not available for this locale.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String getISO3Language() throws java.util.MissingResourceException { throw new RuntimeException("Stub!"); }

/**
 * Returns a three-letter abbreviation for this locale's country.
 * If the country matches an ISO 3166-1 alpha-2 code, the
 * corresponding ISO 3166-1 alpha-3 uppercase code is returned.
 * If the locale doesn't specify a country, this will be the empty
 * string.
 *
 * <p>The ISO 3166-1 codes can be found on-line.
 *
 * @return A three-letter abbreviation of this locale's country.
 * @exception java.util.MissingResourceException Throws MissingResourceException if the
 * three-letter country abbreviation is not available for this locale.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String getISO3Country() throws java.util.MissingResourceException { throw new RuntimeException("Stub!"); }

/**
 * Returns a name for the locale's language that is appropriate for display to the
 * user.
 * If possible, the name returned will be localized for the default
 * {@link java.util.Locale.Category#DISPLAY Locale.Category#DISPLAY} locale.
 * For example, if the locale is fr_FR and the default
 * {@link java.util.Locale.Category#DISPLAY Locale.Category#DISPLAY} locale
 * is en_US, getDisplayLanguage() will return "French"; if the locale is en_US and
 * the default {@link java.util.Locale.Category#DISPLAY Locale.Category#DISPLAY} locale is fr_FR,
 * getDisplayLanguage() will return "anglais".
 * If the name returned cannot be localized for the default
 * {@link java.util.Locale.Category#DISPLAY Locale.Category#DISPLAY} locale,
 * (say, we don't have a Japanese name for Croatian),
 * this function falls back on the English name, and uses the ISO code as a last-resort
 * value.  If the locale doesn't specify a language, this function returns the empty string.
 *
 * @return The name of the display language.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String getDisplayLanguage() { throw new RuntimeException("Stub!"); }

/**
 * Returns the name of this locale's language, localized to {@code locale}.
 * If the language name is unknown, the language code is returned.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String getDisplayLanguage(@androidx.annotation.NonNull java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Returns a name for the the locale's script that is appropriate for display to
 * the user. If possible, the name will be localized for the default
 * {@link java.util.Locale.Category#DISPLAY Locale.Category#DISPLAY} locale.  Returns
 * the empty string if this locale doesn't specify a script code.
 *
 * @return the display name of the script code for the current default
 *     {@link java.util.Locale.Category#DISPLAY Locale.Category#DISPLAY} locale
 * @since 1.7
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.lang.String getDisplayScript() { throw new RuntimeException("Stub!"); }

/**
 * Returns a name for the locale's script that is appropriate
 * for display to the user. If possible, the name will be
 * localized for the given locale. Returns the empty string if
 * this locale doesn't specify a script code.
 *
 * @param inLocale The locale for which to retrieve the display script.
 * @return the display name of the script code for the current default
 * {@link java.util.Locale.Category#DISPLAY Locale.Category#DISPLAY} locale
 * @throws java.lang.NullPointerException if <code>inLocale</code> is <code>null</code>
 * @since 1.7
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.lang.String getDisplayScript(@androidx.annotation.NonNull java.util.Locale inLocale) { throw new RuntimeException("Stub!"); }

/**
 * Returns a name for the locale's country that is appropriate for display to the
 * user.
 * If possible, the name returned will be localized for the default
 * {@link java.util.Locale.Category#DISPLAY Locale.Category#DISPLAY} locale.
 * For example, if the locale is fr_FR and the default
 * {@link java.util.Locale.Category#DISPLAY Locale.Category#DISPLAY} locale
 * is en_US, getDisplayCountry() will return "France"; if the locale is en_US and
 * the default {@link java.util.Locale.Category#DISPLAY Locale.Category#DISPLAY} locale is fr_FR,
 * getDisplayCountry() will return "Etats-Unis".
 * If the name returned cannot be localized for the default
 * {@link java.util.Locale.Category#DISPLAY Locale.Category#DISPLAY} locale,
 * (say, we don't have a Japanese name for Croatia),
 * this function falls back on the English name, and uses the ISO code as a last-resort
 * value.  If the locale doesn't specify a country, this function returns the empty string.
 *
 * @return The name of the country appropriate to the locale.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String getDisplayCountry() { throw new RuntimeException("Stub!"); }

/**
 * Returns the name of this locale's country, localized to {@code locale}.
 * Returns the empty string if this locale does not correspond to a specific
 * country.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String getDisplayCountry(@androidx.annotation.NonNull java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Returns a name for the locale's variant code that is appropriate for display to the
 * user.  If possible, the name will be localized for the default
 * {@link java.util.Locale.Category#DISPLAY Locale.Category#DISPLAY} locale.  If the locale
 * doesn't specify a variant code, this function returns the empty string.
 *
 * @return The name of the display variant code appropriate to the locale.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String getDisplayVariant() { throw new RuntimeException("Stub!"); }

/**
 * Returns a name for the locale's variant code that is appropriate for display to the
 * user.  If possible, the name will be localized for inLocale.  If the locale
 * doesn't specify a variant code, this function returns the empty string.
 *
 * @param inLocale The locale for which to retrieve the display variant code.
 * @return The name of the display variant code appropriate to the given locale.
 * @exception java.lang.NullPointerException if <code>inLocale</code> is <code>null</code>
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String getDisplayVariant(@androidx.annotation.NonNull java.util.Locale inLocale) { throw new RuntimeException("Stub!"); }

/**
 * Returns a name for the locale that is appropriate for display to the
 * user. This will be the values returned by getDisplayLanguage(),
 * getDisplayScript(), getDisplayCountry(), and getDisplayVariant() assembled
 * into a single string. The the non-empty values are used in order,
 * with the second and subsequent names in parentheses.  For example:
 * <blockquote>
 * language (script, country, variant)<br>
 * language (country)<br>
 * language (variant)<br>
 * script (country)<br>
 * country<br>
 * </blockquote>
 * depending on which fields are specified in the locale.  If the
 * language, script, country, and variant fields are all empty,
 * this function returns the empty string.
 *
 * @return The name of the locale appropriate to display.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String getDisplayName() { throw new RuntimeException("Stub!"); }

/**
 * Returns this locale's language name, country name, and variant, localized
 * to {@code locale}. The exact output form depends on whether this locale
 * corresponds to a specific language, script, country and variant.
 *
 * <p>For example:
 * <ul>
 * <li>{@code new Locale("en").getDisplayName(Locale.US)} -> {@code English}
 * <li>{@code new Locale("en", "US").getDisplayName(Locale.US)} -> {@code English (United States)}
 * <li>{@code new Locale("en", "US", "POSIX").getDisplayName(Locale.US)} -> {@code English (United States,Computer)}
 * <li>{@code Locale.forLanguageTag("zh-Hant-CN").getDisplayName(Locale.US)} -> {@code Chinese (Traditional Han,China)}
 * <li>{@code new Locale("en").getDisplayName(Locale.FRANCE)} -> {@code anglais}
 * <li>{@code new Locale("en", "US").getDisplayName(Locale.FRANCE)} -> {@code anglais (États-Unis)}
 * <li>{@code new Locale("en", "US", "POSIX").getDisplayName(Locale.FRANCE)} -> {@code anglais (États-Unis,informatique)}.
 * </ul>
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.String getDisplayName(@androidx.annotation.NonNull java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Overrides Cloneable.
 * @apiSince 1
 */

@androidx.annotation.NonNull
public java.lang.Object clone() { throw new RuntimeException("Stub!"); }

/**
 * Override hashCode.
 * Since Locales are often used in hashtables, caches the value
 * for speed.
 * @apiSince 1
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this Locale is equal to another object.  A Locale is
 * deemed equal to another Locale with identical language, script, country,
 * variant and extensions, and unequal to all other objects.
 *
 * @return true if this Locale is equal to the specified object.
 * @apiSince 1
 */

public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of matching {@code Locale} instances using the filtering
 * mechanism defined in RFC 4647.
 *
 * @param priorityList user's Language Priority List in which each language
 *     tag is sorted in descending order based on priority or weight
 * @param locales {@code Locale} instances used for matching
 * @param mode filtering mode
 * @return a list of {@code Locale} instances for matching language tags
 *     sorted in descending order based on priority or weight, or an empty
 *     list if nothing matches. The list is modifiable.
 * @throws java.lang.NullPointerException if {@code priorityList} or {@code locales}
 *     is {@code null}
 * @throws java.lang.IllegalArgumentException if one or more extended language ranges
 *     are included in the given list when
 *     {@link java.util.Locale.FilteringMode#REJECT_EXTENDED_RANGES FilteringMode#REJECT_EXTENDED_RANGES} is specified
 *
 * @since 1.8
 * @apiSince 26
 */

@androidx.annotation.NonNull
public static java.util.List<java.util.Locale> filter(@androidx.annotation.NonNull java.util.List<java.util.Locale.LanguageRange> priorityList, @androidx.annotation.NonNull java.util.Collection<java.util.Locale> locales, @androidx.annotation.NonNull java.util.Locale.FilteringMode mode) { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of matching {@code Locale} instances using the filtering
 * mechanism defined in RFC 4647. This is equivalent to
 * {@link #filter(java.util.List,java.util.Collection,java.util.Locale.FilteringMode)} when {@code mode} is
 * {@link java.util.Locale.FilteringMode#AUTOSELECT_FILTERING FilteringMode#AUTOSELECT_FILTERING}.
 *
 * @param priorityList user's Language Priority List in which each language
 *     tag is sorted in descending order based on priority or weight
 * @param locales {@code Locale} instances used for matching
 * @return a list of {@code Locale} instances for matching language tags
 *     sorted in descending order based on priority or weight, or an empty
 *     list if nothing matches. The list is modifiable.
 * @throws java.lang.NullPointerException if {@code priorityList} or {@code locales}
 *     is {@code null}
 *
 * @since 1.8
 * @apiSince 26
 */

@androidx.annotation.NonNull
public static java.util.List<java.util.Locale> filter(@androidx.annotation.NonNull java.util.List<java.util.Locale.LanguageRange> priorityList, @androidx.annotation.NonNull java.util.Collection<java.util.Locale> locales) { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of matching languages tags using the basic filtering
 * mechanism defined in RFC 4647.
 *
 * @param priorityList user's Language Priority List in which each language
 *     tag is sorted in descending order based on priority or weight
 * @param tags language tags
 * @param mode filtering mode
 * @return a list of matching language tags sorted in descending order
 *     based on priority or weight, or an empty list if nothing matches.
 *     The list is modifiable.
 * @throws java.lang.NullPointerException if {@code priorityList} or {@code tags} is
 *     {@code null}
 * @throws java.lang.IllegalArgumentException if one or more extended language ranges
 *     are included in the given list when
 *     {@link java.util.Locale.FilteringMode#REJECT_EXTENDED_RANGES FilteringMode#REJECT_EXTENDED_RANGES} is specified
 *
 * @since 1.8
 * @apiSince 26
 */

@androidx.annotation.NonNull
public static java.util.List<java.lang.String> filterTags(@androidx.annotation.NonNull java.util.List<java.util.Locale.LanguageRange> priorityList, @androidx.annotation.NonNull java.util.Collection<java.lang.String> tags, @androidx.annotation.NonNull java.util.Locale.FilteringMode mode) { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of matching languages tags using the basic filtering
 * mechanism defined in RFC 4647. This is equivalent to
 * {@link #filterTags(java.util.List,java.util.Collection,java.util.Locale.FilteringMode)} when {@code mode}
 * is {@link java.util.Locale.FilteringMode#AUTOSELECT_FILTERING FilteringMode#AUTOSELECT_FILTERING}.
 *
 * @param priorityList user's Language Priority List in which each language
 *     tag is sorted in descending order based on priority or weight
 * @param tags language tags
 * @return a list of matching language tags sorted in descending order
 *     based on priority or weight, or an empty list if nothing matches.
 *     The list is modifiable.
 * @throws java.lang.NullPointerException if {@code priorityList} or {@code tags} is
 *     {@code null}
 *
 * @since 1.8
 * @apiSince 26
 */

@androidx.annotation.NonNull
public static java.util.List<java.lang.String> filterTags(@androidx.annotation.NonNull java.util.List<java.util.Locale.LanguageRange> priorityList, @androidx.annotation.NonNull java.util.Collection<java.lang.String> tags) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Locale} instance for the best-matching language
 * tag using the lookup mechanism defined in RFC 4647.
 *
 * @param priorityList user's Language Priority List in which each language
 *     tag is sorted in descending order based on priority or weight
 * @param locales {@code Locale} instances used for matching
 * @return the best matching <code>Locale</code> instance chosen based on
 *     priority or weight, or {@code null} if nothing matches.
 * @throws java.lang.NullPointerException if {@code priorityList} or {@code tags} is
 *     {@code null}
 *
 * @since 1.8
 * @apiSince 26
 */

@androidx.annotation.Nullable
public static java.util.Locale lookup(@androidx.annotation.NonNull java.util.List<java.util.Locale.LanguageRange> priorityList, @androidx.annotation.NonNull java.util.Collection<java.util.Locale> locales) { throw new RuntimeException("Stub!"); }

/**
 * Returns the best-matching language tag using the lookup mechanism
 * defined in RFC 4647.
 *
 * @param priorityList user's Language Priority List in which each language
 *     tag is sorted in descending order based on priority or weight
 * @param tags language tangs used for matching
 * @return the best matching language tag chosen based on priority or
 *     weight, or {@code null} if nothing matches.
 * @throws java.lang.NullPointerException if {@code priorityList} or {@code tags} is
 *     {@code null}
 *
 * @since 1.8
 * @apiSince 26
 */

@androidx.annotation.Nullable
public static java.lang.String lookupTag(@androidx.annotation.NonNull java.util.List<java.util.Locale.LanguageRange> priorityList, @androidx.annotation.NonNull java.util.Collection<java.lang.String> tags) { throw new RuntimeException("Stub!"); }

/** Useful constant for country.
 @apiSince 1
 */

@androidx.annotation.NonNull public static final java.util.Locale CANADA;
static { CANADA = null; }

/** Useful constant for country.
 @apiSince 1
 */

@androidx.annotation.NonNull public static final java.util.Locale CANADA_FRENCH;
static { CANADA_FRENCH = null; }

/** Useful constant for country.
 @apiSince 1
 */

@androidx.annotation.NonNull public static final java.util.Locale CHINA;
static { CHINA = null; }

/** Useful constant for language.
 @apiSince 1
 */

@androidx.annotation.NonNull public static final java.util.Locale CHINESE;
static { CHINESE = null; }

/** Useful constant for language.
 @apiSince 1
 */

@androidx.annotation.NonNull public static final java.util.Locale ENGLISH;
static { ENGLISH = null; }

/** Useful constant for country.
 @apiSince 1
 */

@androidx.annotation.NonNull public static final java.util.Locale FRANCE;
static { FRANCE = null; }

/** Useful constant for language.
 @apiSince 1
 */

@androidx.annotation.NonNull public static final java.util.Locale FRENCH;
static { FRENCH = null; }

/** Useful constant for language.
 @apiSince 1
 */

@androidx.annotation.NonNull public static final java.util.Locale GERMAN;
static { GERMAN = null; }

/** Useful constant for country.
 @apiSince 1
 */

@androidx.annotation.NonNull public static final java.util.Locale GERMANY;
static { GERMANY = null; }

/** Useful constant for language.
 @apiSince 1
 */

@androidx.annotation.NonNull public static final java.util.Locale ITALIAN;
static { ITALIAN = null; }

/** Useful constant for country.
 @apiSince 1
 */

@androidx.annotation.NonNull public static final java.util.Locale ITALY;
static { ITALY = null; }

/** Useful constant for country.
 @apiSince 1
 */

@androidx.annotation.NonNull public static final java.util.Locale JAPAN;
static { JAPAN = null; }

/** Useful constant for language.
 @apiSince 1
 */

@androidx.annotation.NonNull public static final java.util.Locale JAPANESE;
static { JAPANESE = null; }

/** Useful constant for country.
 @apiSince 1
 */

@androidx.annotation.NonNull public static final java.util.Locale KOREA;
static { KOREA = null; }

/** Useful constant for language.
 @apiSince 1
 */

@androidx.annotation.NonNull public static final java.util.Locale KOREAN;
static { KOREAN = null; }

/** Useful constant for country.
 @apiSince 1
 */

@androidx.annotation.NonNull public static final java.util.Locale PRC;
static { PRC = null; }

/**
 * The key for the private use extension ('x').
 *
 * @see #getExtension(char)
 * @see java.util.Locale.Builder#setExtension(char, String)
 * @since 1.7
 * @apiSince 21
 */

public static final char PRIVATE_USE_EXTENSION = 120; // 0x0078 'x'

/**
 * Useful constant for the root locale.  The root locale is the locale whose
 * language, country, and variant are empty ("") strings.  This is regarded
 * as the base locale of all locales, and is used as the language/country
 * neutral locale for the locale sensitive operations.
 *
 * @since 1.6
 * @apiSince 9
 */

@androidx.annotation.NonNull public static final java.util.Locale ROOT;
static { ROOT = null; }

/** Useful constant for language.
 @apiSince 1
 */

@androidx.annotation.NonNull public static final java.util.Locale SIMPLIFIED_CHINESE;
static { SIMPLIFIED_CHINESE = null; }

/** Useful constant for country.
 @apiSince 1
 */

@androidx.annotation.NonNull public static final java.util.Locale TAIWAN;
static { TAIWAN = null; }

/** Useful constant for language.
 @apiSince 1
 */

@androidx.annotation.NonNull public static final java.util.Locale TRADITIONAL_CHINESE;
static { TRADITIONAL_CHINESE = null; }

/** Useful constant for country.
 @apiSince 1
 */

@androidx.annotation.NonNull public static final java.util.Locale UK;
static { UK = null; }

/**
 * The key for Unicode locale extension ('u').
 *
 * @see #getExtension(char)
 * @see java.util.Locale.Builder#setExtension(char, String)
 * @since 1.7
 * @apiSince 21
 */

public static final char UNICODE_LOCALE_EXTENSION = 117; // 0x0075 'u'

/** Useful constant for country.
 @apiSince 1
 */

@androidx.annotation.NonNull public static final java.util.Locale US;
static { US = null; }
/**
 * <code>Builder</code> is used to build instances of <code>Locale</code>
 * from values configured by the setters.  Unlike the <code>Locale</code>
 * constructors, the <code>Builder</code> checks if a value configured by a
 * setter satisfies the syntax requirements defined by the <code>Locale</code>
 * class.  A <code>Locale</code> object created by a <code>Builder</code> is
 * well-formed and can be transformed to a well-formed IETF BCP 47 language tag
 * without losing information.
 *
 * <p><b>Note:</b> The <code>Locale</code> class does not provide any
 * syntactic restrictions on variant, while BCP 47 requires each variant
 * subtag to be 5 to 8 alphanumerics or a single numeric followed by 3
 * alphanumerics.  The method <code>setVariant</code> throws
 * <code>IllformedLocaleException</code> for a variant that does not satisfy
 * this restriction. If it is necessary to support such a variant, use a
 * Locale constructor.  However, keep in mind that a <code>Locale</code>
 * object created this way might lose the variant information when
 * transformed to a BCP 47 language tag.
 *
 * <p>The following example shows how to create a <code>Locale</code> object
 * with the <code>Builder</code>.
 * <blockquote>
 * <pre>
 *     Locale aLocale = new Builder().setLanguage("sr").setScript("Latn").setRegion("RS").build();
 * </pre>
 * </blockquote>
 *
 * <p>Builders can be reused; <code>clear()</code> resets all
 * fields to their default values.
 *
 * @see java.util.Locale#forLanguageTag
 * @since 1.7
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Constructs an empty Builder. The default value of all
 * fields, extensions, and private use information is the
 * empty string.
 * @apiSince 21
 */

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Resets the <code>Builder</code> to match the provided
 * <code>locale</code>.  Existing state is discarded.
 *
 * <p>All fields of the locale must be well-formed, see {@link java.util.Locale Locale}.
 *
 * <p>Locales with any ill-formed fields cause
 * <code>IllformedLocaleException</code> to be thrown, except for the
 * following three cases which are accepted for compatibility
 * reasons:<ul>
 * <li>Locale("ja", "JP", "JP") is treated as "ja-JP-u-ca-japanese"
 * <li>Locale("th", "TH", "TH") is treated as "th-TH-u-nu-thai"
 * <li>Locale("no", "NO", "NY") is treated as "nn-NO"</ul>
 *
 * @param locale the locale
 * @return This builder.
 * @throws java.util.IllformedLocaleException if <code>locale</code> has
 * any ill-formed fields.
 * @throws java.lang.NullPointerException if <code>locale</code> is null.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.util.Locale.Builder setLocale(@androidx.annotation.NonNull java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Resets the Builder to match the provided IETF BCP 47
 * language tag.  Discards the existing state.  Null and the
 * empty string cause the builder to be reset, like {@link
 * #clear}.  Grandfathered tags (see {@link java.util.Locale#forLanguageTag Locale#forLanguageTag}) are converted to their canonical
 * form before being processed.  Otherwise, the language tag
 * must be well-formed (see {@link java.util.Locale Locale}) or an exception is
 * thrown (unlike <code>Locale.forLanguageTag</code>, which
 * just discards ill-formed and following portions of the
 * tag).
 *
 * @param languageTag the language tag
 * @return This builder.
 * @throws java.util.IllformedLocaleException if <code>languageTag</code> is ill-formed
 * @see java.util.Locale#forLanguageTag(String)
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.util.Locale.Builder setLanguageTag(@androidx.annotation.NonNull java.lang.String languageTag) { throw new RuntimeException("Stub!"); }

/**
 * Sets the language.  If <code>language</code> is the empty string or
 * null, the language in this <code>Builder</code> is removed.  Otherwise,
 * the language must be <a href="./Locale.html#def_language">well-formed</a>
 * or an exception is thrown.
 *
 * <p>The typical language value is a two or three-letter language
 * code as defined in ISO639.
 *
 * @param language the language
 * @return This builder.
 * @throws java.util.IllformedLocaleException if <code>language</code> is ill-formed
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.util.Locale.Builder setLanguage(@androidx.annotation.Nullable java.lang.String language) { throw new RuntimeException("Stub!"); }

/**
 * Sets the script. If <code>script</code> is null or the empty string,
 * the script in this <code>Builder</code> is removed.
 * Otherwise, the script must be <a href="./Locale.html#def_script">well-formed</a> or an
 * exception is thrown.
 *
 * <p>The typical script value is a four-letter script code as defined by ISO 15924.
 *
 * @param script the script
 * @return This builder.
 * @throws java.util.IllformedLocaleException if <code>script</code> is ill-formed
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.util.Locale.Builder setScript(@androidx.annotation.Nullable java.lang.String script) { throw new RuntimeException("Stub!"); }

/**
 * Sets the region.  If region is null or the empty string, the region
 * in this <code>Builder</code> is removed.  Otherwise,
 * the region must be <a href="./Locale.html#def_region">well-formed</a> or an
 * exception is thrown.
 *
 * <p>The typical region value is a two-letter ISO 3166 code or a
 * three-digit UN M.49 area code.
 *
 * <p>The country value in the <code>Locale</code> created by the
 * <code>Builder</code> is always normalized to upper case.
 *
 * @param region the region
 * @return This builder.
 * @throws java.util.IllformedLocaleException if <code>region</code> is ill-formed
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.util.Locale.Builder setRegion(@androidx.annotation.Nullable java.lang.String region) { throw new RuntimeException("Stub!"); }

/**
 * Sets the variant.  If variant is null or the empty string, the
 * variant in this <code>Builder</code> is removed.  Otherwise, it
 * must consist of one or more <a href="./Locale.html#def_variant">well-formed</a>
 * subtags, or an exception is thrown.
 *
 * <p><b>Note:</b> This method checks if <code>variant</code>
 * satisfies the IETF BCP 47 variant subtag's syntax requirements,
 * and normalizes the value to lowercase letters.  However,
 * the <code>Locale</code> class does not impose any syntactic
 * restriction on variant, and the variant value in
 * <code>Locale</code> is case sensitive.  To set such a variant,
 * use a Locale constructor.
 *
 * @param variant the variant
 * @return This builder.
 * @throws java.util.IllformedLocaleException if <code>variant</code> is ill-formed
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.util.Locale.Builder setVariant(@androidx.annotation.Nullable java.lang.String variant) { throw new RuntimeException("Stub!"); }

/**
 * Sets the extension for the given key. If the value is null or the
 * empty string, the extension is removed.  Otherwise, the extension
 * must be <a href="./Locale.html#def_extensions">well-formed</a> or an exception
 * is thrown.
 *
 * <p><b>Note:</b> The key {@link java.util.Locale#UNICODE_LOCALE_EXTENSION Locale#UNICODE_LOCALE_EXTENSION} ('u') is used for the Unicode locale extension.
 * Setting a value for this key replaces any existing Unicode locale key/type
 * pairs with those defined in the extension.
 *
 * <p><b>Note:</b> The key {@link java.util.Locale#PRIVATE_USE_EXTENSION Locale#PRIVATE_USE_EXTENSION} ('x') is used for the private use code. To be
 * well-formed, the value for this key needs only to have subtags of one to
 * eight alphanumeric characters, not two to eight as in the general case.
 *
 * @param key the extension key
 * @param value the extension value
 * @return This builder.
 * @throws java.util.IllformedLocaleException if <code>key</code> is illegal
 * or <code>value</code> is ill-formed
 * @see #setUnicodeLocaleKeyword(String, String)
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.util.Locale.Builder setExtension(char key, @androidx.annotation.Nullable java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Sets the Unicode locale keyword type for the given key.  If the type
 * is null, the Unicode keyword is removed.  Otherwise, the key must be
 * non-null and both key and type must be <a
 * href="./Locale.html#def_locale_extension">well-formed</a> or an exception
 * is thrown.
 *
 * <p>Keys and types are converted to lower case.
 *
 * <p><b>Note</b>:Setting the 'u' extension via {@link #setExtension}
 * replaces all Unicode locale keywords with those defined in the
 * extension.
 *
 * @param key the Unicode locale key
 * @param type the Unicode locale type
 * @return This builder.
 * @throws java.util.IllformedLocaleException if <code>key</code> or <code>type</code>
 * is ill-formed
 * @throws java.lang.NullPointerException if <code>key</code> is null
 * @see #setExtension(char, String)
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.util.Locale.Builder setUnicodeLocaleKeyword(@androidx.annotation.NonNull java.lang.String key, @androidx.annotation.Nullable java.lang.String type) { throw new RuntimeException("Stub!"); }

/**
 * Adds a unicode locale attribute, if not already present, otherwise
 * has no effect.  The attribute must not be null and must be <a
 * href="./Locale.html#def_locale_extension">well-formed</a> or an exception
 * is thrown.
 *
 * @param attribute the attribute
 * @return This builder.
 * @throws java.lang.NullPointerException if <code>attribute</code> is null
 * @throws java.util.IllformedLocaleException if <code>attribute</code> is ill-formed
 * @see #setExtension(char, String)
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.util.Locale.Builder addUnicodeLocaleAttribute(@androidx.annotation.NonNull java.lang.String attribute) { throw new RuntimeException("Stub!"); }

/**
 * Removes a unicode locale attribute, if present, otherwise has no
 * effect.  The attribute must not be null and must be <a
 * href="./Locale.html#def_locale_extension">well-formed</a> or an exception
 * is thrown.
 *
 * <p>Attribute comparision for removal is case-insensitive.
 *
 * @param attribute the attribute
 * @return This builder.
 * @throws java.lang.NullPointerException if <code>attribute</code> is null
 * @throws java.util.IllformedLocaleException if <code>attribute</code> is ill-formed
 * @see #setExtension(char, String)
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.util.Locale.Builder removeUnicodeLocaleAttribute(@androidx.annotation.NonNull java.lang.String attribute) { throw new RuntimeException("Stub!"); }

/**
 * Resets the builder to its initial, empty state.
 *
 * @return This builder.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.util.Locale.Builder clear() { throw new RuntimeException("Stub!"); }

/**
 * Resets the extensions to their initial, empty state.
 * Language, script, region and variant are unchanged.
 *
 * @return This builder.
 * @see #setExtension(char, String)
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.util.Locale.Builder clearExtensions() { throw new RuntimeException("Stub!"); }

/**
 * Returns an instance of <code>Locale</code> created from the fields set
 * on this builder.
 *
 * <p>This applies the conversions listed in {@link java.util.Locale#forLanguageTag Locale#forLanguageTag}
 * when constructing a Locale. (Grandfathered tags are handled in
 * {@link #setLanguageTag}.)
 *
 * @return A Locale.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.util.Locale build() { throw new RuntimeException("Stub!"); }
}

/**
 * Enum for locale categories.  These locale categories are used to get/set
 * the default locale for the specific functionality represented by the
 * category.
 *
 * @see #getDefault(Locale.Category)
 * @see #setDefault(Locale.Category, Locale)
 * @since 1.7
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum Category {
/**
 * Category used to represent the default locale for
 * displaying user interfaces.
 * @apiSince 24
 */

DISPLAY,
/**
 * Category used to represent the default locale for
 * formatting dates, numbers, and/or currencies.
 * @apiSince 24
 */

FORMAT;
}

/**
 * This enum provides constants to select a filtering mode for locale
 * matching. Refer to <a href="http://tools.ietf.org/html/rfc4647">RFC 4647
 * Matching of Language Tags</a> for details.
 *
 * <p>As an example, think of two Language Priority Lists each of which
 * includes only one language range and a set of following language tags:
 *
 * <pre>
 *    de (German)
 *    de-DE (German, Germany)
 *    de-Deva (German, in Devanagari script)
 *    de-Deva-DE (German, in Devanagari script, Germany)
 *    de-DE-1996 (German, Germany, orthography of 1996)
 *    de-Latn-DE (German, in Latin script, Germany)
 *    de-Latn-DE-1996 (German, in Latin script, Germany, orthography of 1996)
 * </pre>
 *
 * The filtering method will behave as follows:
 *
 * <table cellpadding=2 summary="Filtering method behavior">
 * <tr>
 * <th>Filtering Mode</th>
 * <th>Language Priority List: {@code "de-DE"}</th>
 * <th>Language Priority List: {@code "de-*-DE"}</th>
 * </tr>
 * <tr>
 * <td valign=top>
 * {@link java.util.Locale.FilteringMode#AUTOSELECT_FILTERING FilteringMode#AUTOSELECT_FILTERING}
 * </td>
 * <td valign=top>
 * Performs <em>basic</em> filtering and returns {@code "de-DE"} and
 * {@code "de-DE-1996"}.
 * </td>
 * <td valign=top>
 * Performs <em>extended</em> filtering and returns {@code "de-DE"},
 * {@code "de-Deva-DE"}, {@code "de-DE-1996"}, {@code "de-Latn-DE"}, and
 * {@code "de-Latn-DE-1996"}.
 * </td>
 * </tr>
 * <tr>
 * <td valign=top>
 * {@link java.util.Locale.FilteringMode#EXTENDED_FILTERING FilteringMode#EXTENDED_FILTERING}
 * </td>
 * <td valign=top>
 * Performs <em>extended</em> filtering and returns {@code "de-DE"},
 * {@code "de-Deva-DE"}, {@code "de-DE-1996"}, {@code "de-Latn-DE"}, and
 * {@code "de-Latn-DE-1996"}.
 * </td>
 * <td valign=top>Same as above.</td>
 * </tr>
 * <tr>
 * <td valign=top>
 * {@link java.util.Locale.FilteringMode#IGNORE_EXTENDED_RANGES FilteringMode#IGNORE_EXTENDED_RANGES}
 * </td>
 * <td valign=top>
 * Performs <em>basic</em> filtering and returns {@code "de-DE"} and
 * {@code "de-DE-1996"}.
 * </td>
 * <td valign=top>
 * Performs <em>basic</em> filtering and returns {@code null} because
 * nothing matches.
 * </td>
 * </tr>
 * <tr>
 * <td valign=top>
 * {@link java.util.Locale.FilteringMode#MAP_EXTENDED_RANGES FilteringMode#MAP_EXTENDED_RANGES}
 * </td>
 * <td valign=top>Same as above.</td>
 * <td valign=top>
 * Performs <em>basic</em> filtering and returns {@code "de-DE"} and
 * {@code "de-DE-1996"} because {@code "de-*-DE"} is mapped to
 * {@code "de-DE"}.
 * </td>
 * </tr>
 * <tr>
 * <td valign=top>
 * {@link java.util.Locale.FilteringMode#REJECT_EXTENDED_RANGES FilteringMode#REJECT_EXTENDED_RANGES}
 * </td>
 * <td valign=top>Same as above.</td>
 * <td valign=top>
 * Throws {@link java.lang.IllegalArgumentException IllegalArgumentException} because {@code "de-*-DE"} is
 * not a valid basic language range.
 * </td>
 * </tr>
 * </table>
 *
 * @see #filter(List, Collection, FilteringMode)
 * @see #filterTags(List, Collection, FilteringMode)
 *
 * @since 1.8
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum FilteringMode {
/**
 * Specifies automatic filtering mode based on the given Language
 * Priority List consisting of language ranges. If all of the ranges
 * are basic, basic filtering is selected. Otherwise, extended
 * filtering is selected.
 * @apiSince 26
 */

AUTOSELECT_FILTERING,
/**
 * Specifies extended filtering.
 * @apiSince 26
 */

EXTENDED_FILTERING,
/**
 * Specifies basic filtering: Note that any extended language ranges
 * included in the given Language Priority List are ignored.
 * @apiSince 26
 */

IGNORE_EXTENDED_RANGES,
/**
 * Specifies basic filtering: If any extended language ranges are
 * included in the given Language Priority List, they are mapped to the
 * basic language range. Specifically, a language range starting with a
 * subtag {@code "*"} is treated as a language range {@code "*"}. For
 * example, {@code "*-US"} is treated as {@code "*"}. If {@code "*"} is
 * not the first subtag, {@code "*"} and extra {@code "-"} are removed.
 * For example, {@code "ja-*-JP"} is mapped to {@code "ja-JP"}.
 * @apiSince 26
 */

MAP_EXTENDED_RANGES,
/**
 * Specifies basic filtering: If any extended language ranges are
 * included in the given Language Priority List, the list is rejected
 * and the filtering method throws {@link java.lang.IllegalArgumentException IllegalArgumentException}.
 * @apiSince 26
 */

REJECT_EXTENDED_RANGES;
}

/**
 * This class expresses a <em>Language Range</em> defined in
 * <a href="http://tools.ietf.org/html/rfc4647">RFC 4647 Matching of
 * Language Tags</a>. A language range is an identifier which is used to
 * select language tag(s) meeting specific requirements by using the
 * mechanisms described in <a href="Locale.html#LocaleMatching">Locale
 * Matching</a>. A list which represents a user's preferences and consists
 * of language ranges is called a <em>Language Priority List</em>.
 *
 * <p>There are two types of language ranges: basic and extended. In RFC
 * 4647, the syntax of language ranges is expressed in
 * <a href="http://tools.ietf.org/html/rfc4234">ABNF</a> as follows:
 * <blockquote>
 * <pre>
 *     basic-language-range    = (1*8ALPHA *("-" 1*8alphanum)) / "*"
 *     extended-language-range = (1*8ALPHA / "*")
 *                               *("-" (1*8alphanum / "*"))
 *     alphanum                = ALPHA / DIGIT
 * </pre>
 * </blockquote>
 * For example, {@code "en"} (English), {@code "ja-JP"} (Japanese, Japan),
 * {@code "*"} (special language range which matches any language tag) are
 * basic language ranges, whereas {@code "*-CH"} (any languages,
 * Switzerland), {@code "es-*"} (Spanish, any regions), and
 * {@code "zh-Hant-*"} (Traditional Chinese, any regions) are extended
 * language ranges.
 *
 * @see #filter
 * @see #filterTags
 * @see #lookup
 * @see #lookupTag
 *
 * @since 1.8
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class LanguageRange {

/**
 * Constructs a {@code LanguageRange} using the given {@code range}.
 * Note that no validation is done against the IANA Language Subtag
 * Registry at time of construction.
 *
 * <p>This is equivalent to {@code LanguageRange(range, MAX_WEIGHT)}.
 *
 * @param range a language range
 * @throws java.lang.NullPointerException if the given {@code range} is
 *     {@code null}
 * @apiSince 26
 */

public LanguageRange(@androidx.annotation.NonNull java.lang.String range) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a {@code LanguageRange} using the given {@code range} and
 * {@code weight}. Note that no validation is done against the IANA
 * Language Subtag Registry at time of construction.
 *
 * @param range  a language range
 * @param weight a weight value between {@code MIN_WEIGHT} and
 *     {@code MAX_WEIGHT}
 * @throws java.lang.NullPointerException if the given {@code range} is
 *     {@code null}
 * @throws java.lang.IllegalArgumentException if the given {@code weight} is less
 *     than {@code MIN_WEIGHT} or greater than {@code MAX_WEIGHT}
 * @apiSince 26
 */

public LanguageRange(@androidx.annotation.NonNull java.lang.String range, double weight) { throw new RuntimeException("Stub!"); }

/**
 * Returns the language range of this {@code LanguageRange}.
 *
 * @return the language range.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public java.lang.String getRange() { throw new RuntimeException("Stub!"); }

/**
 * Returns the weight of this {@code LanguageRange}.
 *
 * @return the weight value.
 * @apiSince 26
 */

public double getWeight() { throw new RuntimeException("Stub!"); }

/**
 * Parses the given {@code ranges} to generate a Language Priority List.
 *
 * <p>This method performs a syntactic check for each language range in
 * the given {@code ranges} but doesn't do validation using the IANA
 * Language Subtag Registry.
 *
 * <p>The {@code ranges} to be given can take one of the following
 * forms:
 *
 * <pre>
 *   "Accept-Language: ja,en;q=0.4"  (weighted list with Accept-Language prefix)
 *   "ja,en;q=0.4"                   (weighted list)
 *   "ja,en"                         (prioritized list)
 * </pre>
 *
 * In a weighted list, each language range is given a weight value.
 * The weight value is identical to the "quality value" in
 * <a href="http://tools.ietf.org/html/rfc2616">RFC 2616</a>, and it
 * expresses how much the user prefers  the language. A weight value is
 * specified after a corresponding language range followed by
 * {@code ";q="}, and the default weight value is {@code MAX_WEIGHT}
 * when it is omitted.
 *
 * <p>Unlike a weighted list, language ranges in a prioritized list
 * are sorted in the descending order based on its priority. The first
 * language range has the highest priority and meets the user's
 * preference most.
 *
 * <p>In either case, language ranges are sorted in descending order in
 * the Language Priority List based on priority or weight. If a
 * language range appears in the given {@code ranges} more than once,
 * only the first one is included on the Language Priority List.
 *
 * <p>The returned list consists of language ranges from the given
 * {@code ranges} and their equivalents found in the IANA Language
 * Subtag Registry. For example, if the given {@code ranges} is
 * {@code "Accept-Language: iw,en-us;q=0.7,en;q=0.3"}, the elements in
 * the list to be returned are:
 *
 * <pre>
 *  <b>Range</b>                                   <b>Weight</b>
 *    "iw" (older tag for Hebrew)             1.0
 *    "he" (new preferred code for Hebrew)    1.0
 *    "en-us" (English, United States)        0.7
 *    "en" (English)                          0.3
 * </pre>
 *
 * Two language ranges, {@code "iw"} and {@code "he"}, have the same
 * highest priority in the list. By adding {@code "he"} to the user's
 * Language Priority List, locale-matching method can find Hebrew as a
 * matching locale (or language tag) even if the application or system
 * offers only {@code "he"} as a supported locale (or language tag).
 *
 * @param ranges a list of comma-separated language ranges or a list of
 *     language ranges in the form of the "Accept-Language" header
 *     defined in <a href="http://tools.ietf.org/html/rfc2616">RFC
 *     2616</a>
 * @return a Language Priority List consisting of language ranges
 *     included in the given {@code ranges} and their equivalent
 *     language ranges if available. The list is modifiable.
 * @throws java.lang.NullPointerException if {@code ranges} is null
 * @throws java.lang.IllegalArgumentException if a language range or a weight
 *     found in the given {@code ranges} is ill-formed
 * @apiSince 26
 */

@androidx.annotation.NonNull
public static java.util.List<java.util.Locale.LanguageRange> parse(@androidx.annotation.NonNull java.lang.String ranges) { throw new RuntimeException("Stub!"); }

/**
 * Parses the given {@code ranges} to generate a Language Priority
 * List, and then customizes the list using the given {@code map}.
 * This method is equivalent to
 * {@code mapEquivalents(parse(ranges), map)}.
 *
 * @param ranges a list of comma-separated language ranges or a list
 *     of language ranges in the form of the "Accept-Language" header
 *     defined in <a href="http://tools.ietf.org/html/rfc2616">RFC
 *     2616</a>
 * @param map a map containing information to customize language ranges
 * @return a Language Priority List with customization. The list is
 *     modifiable.
 * @throws java.lang.NullPointerException if {@code ranges} is null
 * @throws java.lang.IllegalArgumentException if a language range or a weight
 *     found in the given {@code ranges} is ill-formed
 * @see #parse(String)
 * @see #mapEquivalents
 * @apiSince 26
 */

@androidx.annotation.NonNull
public static java.util.List<java.util.Locale.LanguageRange> parse(@androidx.annotation.NonNull java.lang.String ranges, @androidx.annotation.NonNull java.util.Map<java.lang.String,java.util.List<java.lang.String>> map) { throw new RuntimeException("Stub!"); }

/**
 * Generates a new customized Language Priority List using the given
 * {@code priorityList} and {@code map}. If the given {@code map} is
 * empty, this method returns a copy of the given {@code priorityList}.
 *
 * <p>In the map, a key represents a language range whereas a value is
 * a list of equivalents of it. {@code '*'} cannot be used in the map.
 * Each equivalent language range has the same weight value as its
 * original language range.
 *
 * <pre>
 *  An example of map:
 *    <b>Key</b>                            <b>Value</b>
 *      "zh" (Chinese)                 "zh",
 *                                     "zh-Hans"(Simplified Chinese)
 *      "zh-HK" (Chinese, Hong Kong)   "zh-HK"
 *      "zh-TW" (Chinese, Taiwan)      "zh-TW"
 * </pre>
 *
 * The customization is performed after modification using the IANA
 * Language Subtag Registry.
 *
 * <p>For example, if a user's Language Priority List consists of five
 * language ranges ({@code "zh"}, {@code "zh-CN"}, {@code "en"},
 * {@code "zh-TW"}, and {@code "zh-HK"}), the newly generated Language
 * Priority List which is customized using the above map example will
 * consists of {@code "zh"}, {@code "zh-Hans"}, {@code "zh-CN"},
 * {@code "zh-Hans-CN"}, {@code "en"}, {@code "zh-TW"}, and
 * {@code "zh-HK"}.
 *
 * <p>{@code "zh-HK"} and {@code "zh-TW"} aren't converted to
 * {@code "zh-Hans-HK"} nor {@code "zh-Hans-TW"} even if they are
 * included in the Language Priority List. In this example, mapping
 * is used to clearly distinguish Simplified Chinese and Traditional
 * Chinese.
 *
 * <p>If the {@code "zh"}-to-{@code "zh"} mapping isn't included in the
 * map, a simple replacement will be performed and the customized list
 * won't include {@code "zh"} and {@code "zh-CN"}.
 *
 * @param priorityList user's Language Priority List
 * @param map a map containing information to customize language ranges
 * @return a new Language Priority List with customization. The list is
 *     modifiable.
 * @throws java.lang.NullPointerException if {@code priorityList} is {@code null}
 * @see #parse(String, Map)
 * @apiSince 26
 */

@androidx.annotation.NonNull
public static java.util.List<java.util.Locale.LanguageRange> mapEquivalents(@androidx.annotation.NonNull java.util.List<java.util.Locale.LanguageRange> priorityList, @androidx.annotation.NonNull java.util.Map<java.lang.String,java.util.List<java.lang.String>> map) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code value for the object.
 *
 * @return  a hash code value for this object.
 * @apiSince 26
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Compares this object to the specified object. The result is true if
 * and only if the argument is not {@code null} and is a
 * {@code LanguageRange} object that contains the same {@code range}
 * and {@code weight} values as this object.
 *
 * @param obj the object to compare with
 * @return  {@code true} if this object's {@code range} and
 *     {@code weight} are the same as the {@code obj}'s; {@code false}
 *     otherwise.
 * @apiSince 26
 */

public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * A constant holding the maximum value of weight, 1.0, which indicates
 * that the language range is a good fit for the user.
 * @apiSince 26
 */

public static final double MAX_WEIGHT = 1.0;

/**
 * A constant holding the minimum value of weight, 0.0, which indicates
 * that the language range is not a good fit for the user.
 * @apiSince 26
 */

public static final double MIN_WEIGHT = 0.0;
}

}

