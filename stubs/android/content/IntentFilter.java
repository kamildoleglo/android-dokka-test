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


package android.content;

import android.net.Uri;
import android.os.PatternMatcher;
import java.util.Iterator;
import java.util.Set;

/**
 * Structured description of Intent values to be matched.  An IntentFilter can
 * match against actions, categories, and data (either via its type, scheme,
 * and/or path) in an Intent.  It also includes a "priority" value which is
 * used to order multiple matching filters.
 *
 * <p>IntentFilter objects are often created in XML as part of a package's
 * {@link android.R.styleable#AndroidManifest AndroidManifest.xml} file,
 * using {@link android.R.styleable#AndroidManifestIntentFilter intent-filter}
 * tags.
 *
 * <p>There are three Intent characteristics you can filter on: the
 * <em>action</em>, <em>data</em>, and <em>categories</em>.  For each of these
 * characteristics you can provide
 * multiple possible matching values (via {@link #addAction},
 * {@link #addDataType}, {@link #addDataScheme}, {@link #addDataSchemeSpecificPart},
 * {@link #addDataAuthority}, {@link #addDataPath}, and {@link #addCategory}, respectively).
 * For actions, if no data characteristics are specified, then the filter will
 * only match intents that contain no data.
 *
 * <p>The data characteristic is
 * itself divided into three attributes: type, scheme, authority, and path.
 * Any that are
 * specified must match the contents of the Intent.  If you specify a scheme
 * but no type, only Intent that does not have a type (such as mailto:) will
 * match; a content: URI will never match because they always have a MIME type
 * that is supplied by their content provider.  Specifying a type with no scheme
 * has somewhat special meaning: it will match either an Intent with no URI
 * field, or an Intent with a content: or file: URI.  If you specify neither,
 * then only an Intent with no data or type will match.  To specify an authority,
 * you must also specify one or more schemes that it is associated with.
 * To specify a path, you also must specify both one or more authorities and
 * one or more schemes it is associated with.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For information about how to create and resolve intents, read the
 * <a href="{@docRoot}guide/topics/intents/intents-filters.html">Intents and Intent Filters</a>
 * developer guide.</p>
 * </div>
 *
 * <h3>Filter Rules</h3>
 * <p>A match is based on the following rules.  Note that
 * for an IntentFilter to match an Intent, three conditions must hold:
 * the <strong>action</strong> and <strong>category</strong> must match, and
 * the data (both the <strong>data type</strong> and
 * <strong>data scheme+authority+path</strong> if specified) must match
 * (see {@link #match(android.content.ContentResolver,android.content.Intent,boolean,java.lang.String)} for more details
 * on how the data fields match).
 *
 * <p><strong>Action</strong> matches if any of the given values match the
 * Intent action; if the filter specifies no actions, then it will only match
 * Intents that do not contain an action.
 *
 * <p><strong>Data Type</strong> matches if any of the given values match the
 * Intent type.  The Intent
 * type is determined by calling {@link android.content.Intent#resolveType Intent#resolveType}.  A wildcard can be
 * used for the MIME sub-type, in both the Intent and IntentFilter, so that the
 * type "audio/*" will match "audio/mpeg", "audio/aiff", "audio/*", etc.
 * <em>Note that MIME type matching here is <b>case sensitive</b>, unlike
 * formal RFC MIME types!</em>  You should thus always use lower case letters
 * for your MIME types.
 *
 * <p><strong>Data Scheme</strong> matches if any of the given values match the
 * Intent data's scheme.
 * The Intent scheme is determined by calling {@link android.content.Intent#getData Intent#getData}
 * and {@link android.net.Uri#getScheme} on that URI.
 * <em>Note that scheme matching here is <b>case sensitive</b>, unlike
 * formal RFC schemes!</em>  You should thus always use lower case letters
 * for your schemes.
 *
 * <p><strong>Data Scheme Specific Part</strong> matches if any of the given values match
 * the Intent's data scheme specific part <em>and</em> one of the data schemes in the filter
 * has matched the Intent, <em>or</em> no scheme specific parts were supplied in the filter.
 * The Intent scheme specific part is determined by calling
 * {@link android.content.Intent#getData Intent#getData} and {@link android.net.Uri#getSchemeSpecificPart} on that URI.
 * <em>Note that scheme specific part matching is <b>case sensitive</b>.</em>
 *
 * <p><strong>Data Authority</strong> matches if any of the given values match
 * the Intent's data authority <em>and</em> one of the data schemes in the filter
 * has matched the Intent, <em>or</em> no authorities were supplied in the filter.
 * The Intent authority is determined by calling
 * {@link android.content.Intent#getData Intent#getData} and {@link android.net.Uri#getAuthority} on that URI.
 * <em>Note that authority matching here is <b>case sensitive</b>, unlike
 * formal RFC host names!</em>  You should thus always use lower case letters
 * for your authority.
 *
 * <p><strong>Data Path</strong> matches if any of the given values match the
 * Intent's data path <em>and</em> both a scheme and authority in the filter
 * has matched against the Intent, <em>or</em> no paths were supplied in the
 * filter.  The Intent authority is determined by calling
 * {@link android.content.Intent#getData Intent#getData} and {@link android.net.Uri#getPath} on that URI.
 *
 * <p><strong>Categories</strong> match if <em>all</em> of the categories in
 * the Intent match categories given in the filter.  Extra categories in the
 * filter that are not in the Intent will not cause the match to fail.  Note
 * that unlike the action, an IntentFilter with no categories
 * will only match an Intent that does not have any categories.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class IntentFilter implements android.os.Parcelable {

/**
 * New empty IntentFilter.
 * @apiSince 1
 */

public IntentFilter() { throw new RuntimeException("Stub!"); }

/**
 * New IntentFilter that matches a single action with no data.  If
 * no data characteristics are subsequently specified, then the
 * filter will only match intents that contain no data.
 *
 * @param action The action to match, such as Intent.ACTION_MAIN.
 * @apiSince 1
 */

public IntentFilter(java.lang.String action) { throw new RuntimeException("Stub!"); }

/**
 * New IntentFilter that matches a single action and data type.
 *
 * <p><em>Note: MIME type matching in the Android framework is
 * case-sensitive, unlike formal RFC MIME types.  As a result,
 * you should always write your MIME types with lower case letters,
 * and any MIME types you receive from outside of Android should be
 * converted to lower case before supplying them here.</em></p>
 *
 * <p>Throws {@link android.content.IntentFilter.MalformedMimeTypeException MalformedMimeTypeException} if the given MIME type is
 * not syntactically correct.
 *
 * @param action The action to match, such as Intent.ACTION_VIEW.
 * @param dataType The type to match, such as "vnd.android.cursor.dir/person".
 *
 * @apiSince 1
 */

public IntentFilter(java.lang.String action, java.lang.String dataType) throws android.content.IntentFilter.MalformedMimeTypeException { throw new RuntimeException("Stub!"); }

/**
 * New IntentFilter containing a copy of an existing filter.
 *
 * @param o The original filter to copy.
 * @apiSince 1
 */

public IntentFilter(android.content.IntentFilter o) { throw new RuntimeException("Stub!"); }

/**
 * Create a new IntentFilter instance with a specified action and MIME
 * type, where you know the MIME type is correctly formatted.  This catches
 * the {@link android.content.IntentFilter.MalformedMimeTypeException MalformedMimeTypeException} exception that the constructor
 * can call and turns it into a runtime exception.
 *
 * @param action The action to match, such as Intent.ACTION_VIEW.
 * @param dataType The type to match, such as "vnd.android.cursor.dir/person".
 *
 * @return A new IntentFilter for the given action and type.
 *
 * @see #IntentFilter(String, String)
 * @apiSince 1
 */

public static android.content.IntentFilter create(java.lang.String action, java.lang.String dataType) { throw new RuntimeException("Stub!"); }

/**
 * Modify priority of this filter.  This only affects receiver filters.
 * The priority of activity filters are set in XML and cannot be changed
 * programmatically. The default priority is 0. Positive values will be
 * before the default, lower values will be after it. Applications should
 * use a value that is larger than {@link #SYSTEM_LOW_PRIORITY} and
 * smaller than {@link #SYSTEM_HIGH_PRIORITY} .
 *
 * @param priority The new priority value.
 *
 * @see #getPriority
 * @see #SYSTEM_LOW_PRIORITY
 * @see #SYSTEM_HIGH_PRIORITY
 * @apiSince 1
 */

public final void setPriority(int priority) { throw new RuntimeException("Stub!"); }

/**
 * Return the priority of this filter.
 *
 * @return The priority of the filter.
 *
 * @see #setPriority
 * @apiSince 1
 */

public final int getPriority() { throw new RuntimeException("Stub!"); }

/**
 * Add a new Intent action to match against.  If any actions are included
 * in the filter, then an Intent's action must be one of those values for
 * it to match.  If no actions are included, the Intent action is ignored.
 *
 * @param action Name of the action to match, such as Intent.ACTION_VIEW.
 * @apiSince 1
 */

public final void addAction(java.lang.String action) { throw new RuntimeException("Stub!"); }

/**
 * Return the number of actions in the filter.
 * @apiSince 1
 */

public final int countActions() { throw new RuntimeException("Stub!"); }

/**
 * Return an action in the filter.
 * @apiSince 1
 */

public final java.lang.String getAction(int index) { throw new RuntimeException("Stub!"); }

/**
 * Is the given action included in the filter?  Note that if the filter
 * does not include any actions, false will <em>always</em> be returned.
 *
 * @param action The action to look for.
 *
 * @return True if the action is explicitly mentioned in the filter.
 * @apiSince 1
 */

public final boolean hasAction(java.lang.String action) { throw new RuntimeException("Stub!"); }

/**
 * Match this filter against an Intent's action.  If the filter does not
 * specify any actions, the match will always fail.
 *
 * @param action The desired action to look for.
 *
 * @return True if the action is listed in the filter.
 * @apiSince 1
 */

public final boolean matchAction(java.lang.String action) { throw new RuntimeException("Stub!"); }

/**
 * Return an iterator over the filter's actions.  If there are no actions,
 * returns null.
 * @apiSince 1
 */

public final java.util.Iterator<java.lang.String> actionsIterator() { throw new RuntimeException("Stub!"); }

/**
 * Add a new Intent data type to match against.  If any types are
 * included in the filter, then an Intent's data must be <em>either</em>
 * one of these types <em>or</em> a matching scheme.  If no data types
 * are included, then an Intent will only match if it specifies no data.
 *
 * <p><em>Note: MIME type matching in the Android framework is
 * case-sensitive, unlike formal RFC MIME types.  As a result,
 * you should always write your MIME types with lower case letters,
 * and any MIME types you receive from outside of Android should be
 * converted to lower case before supplying them here.</em></p>
 *
 * <p>Throws {@link android.content.IntentFilter.MalformedMimeTypeException MalformedMimeTypeException} if the given MIME type is
 * not syntactically correct.
 *
 * @param type Name of the data type to match, such as "vnd.android.cursor.dir/person".
 *
 * @see #matchData
 * @apiSince 1
 */

public final void addDataType(java.lang.String type) throws android.content.IntentFilter.MalformedMimeTypeException { throw new RuntimeException("Stub!"); }

/**
 * Is the given data type included in the filter?  Note that if the filter
 * does not include any type, false will <em>always</em> be returned.
 *
 * @param type The data type to look for.
 *
 * @return True if the type is explicitly mentioned in the filter.
 * @apiSince 1
 */

public final boolean hasDataType(java.lang.String type) { throw new RuntimeException("Stub!"); }

/**
 * Return the number of data types in the filter.
 * @apiSince 1
 */

public final int countDataTypes() { throw new RuntimeException("Stub!"); }

/**
 * Return a data type in the filter.
 * @apiSince 1
 */

public final java.lang.String getDataType(int index) { throw new RuntimeException("Stub!"); }

/**
 * Return an iterator over the filter's data types.
 * @apiSince 1
 */

public final java.util.Iterator<java.lang.String> typesIterator() { throw new RuntimeException("Stub!"); }

/**
 * Add a new Intent data scheme to match against.  If any schemes are
 * included in the filter, then an Intent's data must be <em>either</em>
 * one of these schemes <em>or</em> a matching data type.  If no schemes
 * are included, then an Intent will match only if it includes no data.
 *
 * <p><em>Note: scheme matching in the Android framework is
 * case-sensitive, unlike formal RFC schemes.  As a result,
 * you should always write your schemes with lower case letters,
 * and any schemes you receive from outside of Android should be
 * converted to lower case before supplying them here.</em></p>
 *
 * @param scheme Name of the scheme to match, such as "http".
 *
 * @see #matchData
 * @apiSince 1
 */

public final void addDataScheme(java.lang.String scheme) { throw new RuntimeException("Stub!"); }

/**
 * Return the number of data schemes in the filter.
 * @apiSince 1
 */

public final int countDataSchemes() { throw new RuntimeException("Stub!"); }

/**
 * Return a data scheme in the filter.
 * @apiSince 1
 */

public final java.lang.String getDataScheme(int index) { throw new RuntimeException("Stub!"); }

/**
 * Is the given data scheme included in the filter?  Note that if the
 * filter does not include any scheme, false will <em>always</em> be
 * returned.
 *
 * @param scheme The data scheme to look for.
 *
 * @return True if the scheme is explicitly mentioned in the filter.
 * @apiSince 1
 */

public final boolean hasDataScheme(java.lang.String scheme) { throw new RuntimeException("Stub!"); }

/**
 * Return an iterator over the filter's data schemes.
 * @apiSince 1
 */

public final java.util.Iterator<java.lang.String> schemesIterator() { throw new RuntimeException("Stub!"); }

/**
 * Add a new Intent data "scheme specific part" to match against.  The filter must
 * include one or more schemes (via {@link #addDataScheme}) for the
 * scheme specific part to be considered.  If any scheme specific parts are
 * included in the filter, then an Intent's data must match one of
 * them.  If no scheme specific parts are included, then only the scheme must match.
 *
 * <p>The "scheme specific part" that this matches against is the string returned
 * by {@link android.net.Uri#getSchemeSpecificPart() Uri.getSchemeSpecificPart}.
 * For Uris that contain a path, this kind of matching is not generally of interest,
 * since {@link #addDataAuthority(java.lang.String,java.lang.String)} and
 * {@link #addDataPath(java.lang.String,int)} can provide a better mechanism for matching
 * them.  However, for Uris that do not contain a path, the authority and path
 * are empty, so this is the only way to match against the non-scheme part.</p>
 *
 * @param ssp Either a raw string that must exactly match the scheme specific part
 * path, or a simple pattern, depending on <var>type</var>.
 * @param type Determines how <var>ssp</var> will be compared to
 * determine a match: either {@link android.os.PatternMatcher#PATTERN_LITERAL PatternMatcher#PATTERN_LITERAL},
 * {@link android.os.PatternMatcher#PATTERN_PREFIX PatternMatcher#PATTERN_PREFIX}, or
 * {@link android.os.PatternMatcher#PATTERN_SIMPLE_GLOB PatternMatcher#PATTERN_SIMPLE_GLOB}.
 *
 * @see #matchData
 * @see #addDataScheme
 * @apiSince 19
 */

public final void addDataSchemeSpecificPart(java.lang.String ssp, int type) { throw new RuntimeException("Stub!"); }

/**
 * Return the number of data scheme specific parts in the filter.
 * @apiSince 19
 */

public final int countDataSchemeSpecificParts() { throw new RuntimeException("Stub!"); }

/**
 * Return a data scheme specific part in the filter.
 * @apiSince 19
 */

public final android.os.PatternMatcher getDataSchemeSpecificPart(int index) { throw new RuntimeException("Stub!"); }

/**
 * Is the given data scheme specific part included in the filter?  Note that if the
 * filter does not include any scheme specific parts, false will <em>always</em> be
 * returned.
 *
 * @param data The scheme specific part that is being looked for.
 *
 * @return Returns true if the data string matches a scheme specific part listed in the
 *         filter.
 * @apiSince 19
 */

public final boolean hasDataSchemeSpecificPart(java.lang.String data) { throw new RuntimeException("Stub!"); }

/**
 * Return an iterator over the filter's data scheme specific parts.
 * @apiSince 19
 */

public final java.util.Iterator<android.os.PatternMatcher> schemeSpecificPartsIterator() { throw new RuntimeException("Stub!"); }

/**
 * Add a new Intent data authority to match against.  The filter must
 * include one or more schemes (via {@link #addDataScheme}) for the
 * authority to be considered.  If any authorities are
 * included in the filter, then an Intent's data must match one of
 * them.  If no authorities are included, then only the scheme must match.
 *
 * <p><em>Note: host name in the Android framework is
 * case-sensitive, unlike formal RFC host names.  As a result,
 * you should always write your host names with lower case letters,
 * and any host names you receive from outside of Android should be
 * converted to lower case before supplying them here.</em></p>
 *
 * @param host The host part of the authority to match.  May start with a
 *             single '*' to wildcard the front of the host name.
 * @param port Optional port part of the authority to match.  If null, any
 *             port is allowed.
 *
 * @see #matchData
 * @see #addDataScheme
 * @apiSince 1
 */

public final void addDataAuthority(java.lang.String host, java.lang.String port) { throw new RuntimeException("Stub!"); }

/**
 * Return the number of data authorities in the filter.
 * @apiSince 1
 */

public final int countDataAuthorities() { throw new RuntimeException("Stub!"); }

/**
 * Return a data authority in the filter.
 * @apiSince 1
 */

public final android.content.IntentFilter.AuthorityEntry getDataAuthority(int index) { throw new RuntimeException("Stub!"); }

/**
 * Is the given data authority included in the filter?  Note that if the
 * filter does not include any authorities, false will <em>always</em> be
 * returned.
 *
 * @param data The data whose authority is being looked for.
 *
 * @return Returns true if the data string matches an authority listed in the
 *         filter.
 * @apiSince 1
 */

public final boolean hasDataAuthority(android.net.Uri data) { throw new RuntimeException("Stub!"); }

/**
 * Return an iterator over the filter's data authorities.
 * @apiSince 1
 */

public final java.util.Iterator<android.content.IntentFilter.AuthorityEntry> authoritiesIterator() { throw new RuntimeException("Stub!"); }

/**
 * Add a new Intent data path to match against.  The filter must
 * include one or more schemes (via {@link #addDataScheme}) <em>and</em>
 * one or more authorities (via {@link #addDataAuthority}) for the
 * path to be considered.  If any paths are
 * included in the filter, then an Intent's data must match one of
 * them.  If no paths are included, then only the scheme/authority must
 * match.
 *
 * <p>The path given here can either be a literal that must directly
 * match or match against a prefix, or it can be a simple globbing pattern.
 * If the latter, you can use '*' anywhere in the pattern to match zero
 * or more instances of the previous character, '.' as a wildcard to match
 * any character, and '\' to escape the next character.
 *
 * @param path Either a raw string that must exactly match the file
 * path, or a simple pattern, depending on <var>type</var>.
 * @param type Determines how <var>path</var> will be compared to
 * determine a match: either {@link android.os.PatternMatcher#PATTERN_LITERAL PatternMatcher#PATTERN_LITERAL},
 * {@link android.os.PatternMatcher#PATTERN_PREFIX PatternMatcher#PATTERN_PREFIX}, or
 * {@link android.os.PatternMatcher#PATTERN_SIMPLE_GLOB PatternMatcher#PATTERN_SIMPLE_GLOB}.
 *
 * @see #matchData
 * @see #addDataScheme
 * @see #addDataAuthority
 * @apiSince 1
 */

public final void addDataPath(java.lang.String path, int type) { throw new RuntimeException("Stub!"); }

/**
 * Return the number of data paths in the filter.
 * @apiSince 1
 */

public final int countDataPaths() { throw new RuntimeException("Stub!"); }

/**
 * Return a data path in the filter.
 * @apiSince 1
 */

public final android.os.PatternMatcher getDataPath(int index) { throw new RuntimeException("Stub!"); }

/**
 * Is the given data path included in the filter?  Note that if the
 * filter does not include any paths, false will <em>always</em> be
 * returned.
 *
 * @param data The data path to look for.  This is without the scheme
 *             prefix.
 *
 * @return True if the data string matches a path listed in the
 *         filter.
 * @apiSince 1
 */

public final boolean hasDataPath(java.lang.String data) { throw new RuntimeException("Stub!"); }

/**
 * Return an iterator over the filter's data paths.
 * @apiSince 1
 */

public final java.util.Iterator<android.os.PatternMatcher> pathsIterator() { throw new RuntimeException("Stub!"); }

/**
 * Match this intent filter against the given Intent data.  This ignores
 * the data scheme -- unlike {@link #matchData}, the authority will match
 * regardless of whether there is a matching scheme.
 *
 * @param data The data whose authority is being looked for.
 *
 * @return Returns either {@link #MATCH_CATEGORY_HOST},
 * {@link #MATCH_CATEGORY_PORT}, {@link #NO_MATCH_DATA}.
 * @apiSince 1
 */

public final int matchDataAuthority(android.net.Uri data) { throw new RuntimeException("Stub!"); }

/**
 * Match this filter against an Intent's data (type, scheme and path). If
 * the filter does not specify any types and does not specify any
 * schemes/paths, the match will only succeed if the intent does not
 * also specify a type or data.  If the filter does not specify any schemes,
 * it will implicitly match intents with no scheme, or the schemes "content:"
 * or "file:" (basically performing a MIME-type only match).  If the filter
 * does not specify any MIME types, the Intent also must not specify a MIME
 * type.
 *
 * <p>Be aware that to match against an authority, you must also specify a base
 * scheme the authority is in.  To match against a data path, both a scheme
 * and authority must be specified.  If the filter does not specify any
 * types or schemes that it matches against, it is considered to be empty
 * (any authority or data path given is ignored, as if it were empty as
 * well).
 *
 * <p><em>Note: MIME type, Uri scheme, and host name matching in the
 * Android framework is case-sensitive, unlike the formal RFC definitions.
 * As a result, you should always write these elements with lower case letters,
 * and normalize any MIME types or Uris you receive from
 * outside of Android to ensure these elements are lower case before
 * supplying them here.</em></p>
 *
 * @param type The desired data type to look for, as returned by
 *             Intent.resolveType().
 * @param scheme The desired data scheme to look for, as returned by
 *               Intent.getScheme().
 * @param data The full data string to match against, as supplied in
 *             Intent.data.
 *
 * @return Returns either a valid match constant (a combination of
 * {@link #MATCH_CATEGORY_MASK} and {@link #MATCH_ADJUSTMENT_MASK}),
 * or one of the error codes {@link #NO_MATCH_TYPE} if the type didn't match
 * or {@link #NO_MATCH_DATA} if the scheme/path didn't match.
 *
 * @see #match
 * @apiSince 1
 */

public final int matchData(java.lang.String type, java.lang.String scheme, android.net.Uri data) { throw new RuntimeException("Stub!"); }

/**
 * Add a new Intent category to match against.  The semantics of
 * categories is the opposite of actions -- an Intent includes the
 * categories that it requires, all of which must be included in the
 * filter in order to match.  In other words, adding a category to the
 * filter has no impact on matching unless that category is specified in
 * the intent.
 *
 * @param category Name of category to match, such as Intent.CATEGORY_EMBED.
 * @apiSince 1
 */

public final void addCategory(java.lang.String category) { throw new RuntimeException("Stub!"); }

/**
 * Return the number of categories in the filter.
 * @apiSince 1
 */

public final int countCategories() { throw new RuntimeException("Stub!"); }

/**
 * Return a category in the filter.
 * @apiSince 1
 */

public final java.lang.String getCategory(int index) { throw new RuntimeException("Stub!"); }

/**
 * Is the given category included in the filter?
 *
 * @param category The category that the filter supports.
 *
 * @return True if the category is explicitly mentioned in the filter.
 * @apiSince 1
 */

public final boolean hasCategory(java.lang.String category) { throw new RuntimeException("Stub!"); }

/**
 * Return an iterator over the filter's categories.
 *
 * @return Iterator if this filter has categories or {@code null} if none.
 * @apiSince 1
 */

public final java.util.Iterator<java.lang.String> categoriesIterator() { throw new RuntimeException("Stub!"); }

/**
 * Match this filter against an Intent's categories.  Each category in
 * the Intent must be specified by the filter; if any are not in the
 * filter, the match fails.
 *
 * @param categories The categories included in the intent, as returned by
 *                   Intent.getCategories().
 *
 * @return If all categories match (success), null; else the name of the
 *         first category that didn't match.
 * @apiSince 1
 */

public final java.lang.String matchCategories(java.util.Set<java.lang.String> categories) { throw new RuntimeException("Stub!"); }

/**
 * Test whether this filter matches the given <var>intent</var>.
 *
 * @param intent The Intent to compare against.
 * @param resolve If true, the intent's type will be resolved by calling
 *                Intent.resolveType(); otherwise a simple match against
 *                Intent.type will be performed.
 * @param logTag Tag to use in debugging messages.
 *
 * @return Returns either a valid match constant (a combination of
 * {@link #MATCH_CATEGORY_MASK} and {@link #MATCH_ADJUSTMENT_MASK}),
 * or one of the error codes {@link #NO_MATCH_TYPE} if the type didn't match,
 * {@link #NO_MATCH_DATA} if the scheme/path didn't match,
 * {@link #NO_MATCH_ACTION} if the action didn't match, or
 * {@link #NO_MATCH_CATEGORY} if one or more categories didn't match.
 *
 * @see #match(String, String, String, android.net.Uri , Set, String)
 * @apiSince 1
 */

public final int match(android.content.ContentResolver resolver, android.content.Intent intent, boolean resolve, java.lang.String logTag) { throw new RuntimeException("Stub!"); }

/**
 * Test whether this filter matches the given intent data.  A match is
 * only successful if the actions and categories in the Intent match
 * against the filter, as described in {@link android.content.IntentFilter IntentFilter}; in that case,
 * the match result returned will be as per {@link #matchData}.
 *
 * @param action The intent action to match against (Intent.getAction).
 * @param type The intent type to match against (Intent.resolveType()).
 * @param scheme The data scheme to match against (Intent.getScheme()).
 * @param data The data URI to match against (Intent.getData()).
 * @param categories The categories to match against
 *                   (Intent.getCategories()).
 * @param logTag Tag to use in debugging messages.
 *
 * @return Returns either a valid match constant (a combination of
 * {@link #MATCH_CATEGORY_MASK} and {@link #MATCH_ADJUSTMENT_MASK}),
 * or one of the error codes {@link #NO_MATCH_TYPE} if the type didn't match,
 * {@link #NO_MATCH_DATA} if the scheme/path didn't match,
 * {@link #NO_MATCH_ACTION} if the action didn't match, or
 * {@link #NO_MATCH_CATEGORY} if one or more categories didn't match.
 *
 * @see #matchData
 * @see android.content.Intent#getAction
 * @see Intent#resolveType
 * @see android.content.Intent#getScheme
 * @see android.content.Intent#getData
 * @see android.content.Intent#getCategories
 * @apiSince 1
 */

public final int match(java.lang.String action, java.lang.String type, java.lang.String scheme, android.net.Uri data, java.util.Set<java.lang.String> categories, java.lang.String logTag) { throw new RuntimeException("Stub!"); }

/**
 * Write the contents of the IntentFilter as an XML stream.
 * @apiSince 1
 */

public void writeToXml(org.xmlpull.v1.XmlSerializer serializer) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void readFromXml(org.xmlpull.v1.XmlPullParser parser) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void dump(android.util.Printer du, java.lang.String prefix) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public final void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.content.IntentFilter> CREATOR;
static { CREATOR = null; }

/**
 * The part of a match constant that applies a quality adjustment to the
 * basic category of match.  The value {@link #MATCH_ADJUSTMENT_NORMAL}
 * is no adjustment; higher numbers than that improve the quality, while
 * lower numbers reduce it.
 * @apiSince 1
 */

public static final int MATCH_ADJUSTMENT_MASK = 65535; // 0xffff

/**
 * Quality adjustment applied to the category of match that signifies
 * the default, base value; higher numbers improve the quality while
 * lower numbers reduce it.
 * @apiSince 1
 */

public static final int MATCH_ADJUSTMENT_NORMAL = 32768; // 0x8000

/**
 * The filter matched an intent that had no data specified.
 * @apiSince 1
 */

public static final int MATCH_CATEGORY_EMPTY = 1048576; // 0x100000

/**
 * The filter matched an intent with the same data URI scheme and
 * authority host.
 * @apiSince 1
 */

public static final int MATCH_CATEGORY_HOST = 3145728; // 0x300000

/**
 * The part of a match constant that describes the category of match
 * that occurred.  May be either {@link #MATCH_CATEGORY_EMPTY},
 * {@link #MATCH_CATEGORY_SCHEME}, {@link #MATCH_CATEGORY_SCHEME_SPECIFIC_PART},
 * {@link #MATCH_CATEGORY_HOST}, {@link #MATCH_CATEGORY_PORT},
 * {@link #MATCH_CATEGORY_PATH}, or {@link #MATCH_CATEGORY_TYPE}.  Higher
 * values indicate a better match.
 * @apiSince 1
 */

public static final int MATCH_CATEGORY_MASK = 268369920; // 0xfff0000

/**
 * The filter matched an intent with the same data URI scheme,
 * authority, and path.
 * @apiSince 1
 */

public static final int MATCH_CATEGORY_PATH = 5242880; // 0x500000

/**
 * The filter matched an intent with the same data URI scheme and
 * authority host and port.
 * @apiSince 1
 */

public static final int MATCH_CATEGORY_PORT = 4194304; // 0x400000

/**
 * The filter matched an intent with the same data URI scheme.
 * @apiSince 1
 */

public static final int MATCH_CATEGORY_SCHEME = 2097152; // 0x200000

/**
 * The filter matched an intent with the same data URI scheme and
 * scheme specific part.
 * @apiSince 19
 */

public static final int MATCH_CATEGORY_SCHEME_SPECIFIC_PART = 5767168; // 0x580000

/**
 * The filter matched an intent with the same data MIME type.
 * @apiSince 1
 */

public static final int MATCH_CATEGORY_TYPE = 6291456; // 0x600000

/**
 * The filter didn't match due to different actions.
 * @apiSince 1
 */

public static final int NO_MATCH_ACTION = -3; // 0xfffffffd

/**
 * The filter didn't match because it required one or more categories
 * that were not in the Intent.
 * @apiSince 1
 */

public static final int NO_MATCH_CATEGORY = -4; // 0xfffffffc

/**
 * The filter didn't match due to different data URIs.
 * @apiSince 1
 */

public static final int NO_MATCH_DATA = -2; // 0xfffffffe

/**
 * The filter didn't match due to different MIME types.
 * @apiSince 1
 */

public static final int NO_MATCH_TYPE = -1; // 0xffffffff

/**
 * The filter {@link #setPriority} value at which system high-priority
 * receivers are placed; that is, receivers that should execute before
 * application code. Applications should never use filters with this or
 * higher priorities.
 *
 * @see #setPriority
 * @apiSince 1
 */

public static final int SYSTEM_HIGH_PRIORITY = 1000; // 0x3e8

/**
 * The filter {@link #setPriority} value at which system low-priority
 * receivers are placed; that is, receivers that should execute after
 * application code. Applications should never use filters with this or
 * lower priorities.
 *
 * @see #setPriority
 * @apiSince 1
 */

public static final int SYSTEM_LOW_PRIORITY = -1000; // 0xfffffc18
/**
 * This is an entry for a single authority in the Iterator returned by
 * {@link #authoritiesIterator()}.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class AuthorityEntry {

/** @apiSince 1 */

public AuthorityEntry(java.lang.String host, java.lang.String port) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String getHost() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int getPort() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Determine whether this AuthorityEntry matches the given data Uri.
 * <em>Note that this comparison is case-sensitive, unlike formal
 * RFC host names.  You thus should always normalize to lower-case.</em>
 *
 * @param data The Uri to match.
 * @return Returns either {@link android.content.IntentFilter#NO_MATCH_DATA IntentFilter#NO_MATCH_DATA},
 * {@link android.content.IntentFilter#MATCH_CATEGORY_PORT IntentFilter#MATCH_CATEGORY_PORT}, or
 * {@link android.content.IntentFilter#MATCH_CATEGORY_HOST IntentFilter#MATCH_CATEGORY_HOST}.
 * @apiSince 1
 */

public int match(android.net.Uri data) { throw new RuntimeException("Stub!"); }
}

/**
 * This exception is thrown when a given MIME type does not have a valid
 * syntax.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class MalformedMimeTypeException extends android.util.AndroidException {

/** @apiSince 1 */

public MalformedMimeTypeException() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public MalformedMimeTypeException(java.lang.String name) { throw new RuntimeException("Stub!"); }
}

}

