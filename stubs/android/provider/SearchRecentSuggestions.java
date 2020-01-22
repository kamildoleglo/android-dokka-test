/*
 * Copyright (C) 2008 The Android Open Source Project
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


package android.provider;

import android.content.SearchRecentSuggestionsProvider;

/**
 * This is a utility class providing access to
 * {@link android.content.SearchRecentSuggestionsProvider}.
 *
 * <p>Unlike some utility classes, this one must be instantiated and properly initialized, so that
 * it can be configured to operate with the search suggestions provider that you have created.
 *
 * <p>Typically, you will do this in your searchable activity, each time you receive an incoming
 * {@link android.content.Intent#ACTION_SEARCH ACTION_SEARCH} Intent.  The code to record each
 * incoming query is as follows:
 * <pre class="prettyprint">
 *      SearchSuggestions suggestions = new SearchSuggestions(this,
 *              MySuggestionsProvider.AUTHORITY, MySuggestionsProvider.MODE);
 *      suggestions.saveRecentQuery(queryString, null);
 * </pre>
 *
 * <p>For a working example, see SearchSuggestionSampleProvider and SearchQueryResults in
 * samples/ApiDemos/app.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For information about using search suggestions in your application, read the
 * <a href="{@docRoot}guide/topics/search/adding-recent-query-suggestions.html">Adding Recent Query
 * Suggestions</a> developer guide.</p>
 * </div>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SearchRecentSuggestions {

/**
 * Although provider utility classes are typically static, this one must be constructed
 * because it needs to be initialized using the same values that you provided in your
 * {@link android.content.SearchRecentSuggestionsProvider}.
 *
 * @param authority This must match the authority that you've declared in your manifest.
 * @param mode You can use mode flags here to determine certain functional aspects of your
 * database.  Note, this value should not change from run to run, because when it does change,
 * your suggestions database may be wiped.
 *
 * @see android.content.SearchRecentSuggestionsProvider
 * @see android.content.SearchRecentSuggestionsProvider#setupSuggestions
 * @apiSince 1
 */

public SearchRecentSuggestions(android.content.Context context, java.lang.String authority, int mode) { throw new RuntimeException("Stub!"); }

/**
 * Add a query to the recent queries list.  Returns immediately, performing the save
 * in the background.
 *
 * @param queryString The string as typed by the user.  This string will be displayed as
 * the suggestion, and if the user clicks on the suggestion, this string will be sent to your
 * searchable activity (as a new search query).
 * @param line2 If you have configured your recent suggestions provider with
 * {@link android.content.SearchRecentSuggestionsProvider#DATABASE_MODE_2LINES}, you can
 * pass a second line of text here.  It will be shown in a smaller font, below the primary
 * suggestion.  When typing, matches in either line of text will be displayed in the list.
 * If you did not configure two-line mode, or if a given suggestion does not have any
 * additional text to display, you can pass null here.
 * @apiSince 1
 */

public void saveRecentQuery(java.lang.String queryString, java.lang.String line2) { throw new RuntimeException("Stub!"); }

/**
 * Completely delete the history.  Use this call to implement a "clear history" UI.
 *
 * Any application that implements search suggestions based on previous actions (such as
 * recent queries, page/items viewed, etc.) should provide a way for the user to clear the
 * history.  This gives the user a measure of privacy, if they do not wish for their recent
 * searches to be replayed by other users of the device (via suggestions).
 * @apiSince 1
 */

public void clearHistory() { throw new RuntimeException("Stub!"); }

/**
 * Reduces the length of the history table, to prevent it from growing too large.
 *
 * @param cr Convenience copy of the content resolver.
 * @param maxEntries Max entries to leave in the table. 0 means remove all entries.
 * @apiSince 1
 */

protected void truncateHistory(android.content.ContentResolver cr, int maxEntries) { throw new RuntimeException("Stub!"); }

/**
 * This is the database projection that can be used to view saved queries, when
 * configured for one-line operation.
 * @apiSince 1
 */

public static final java.lang.String[] QUERIES_PROJECTION_1LINE;
static { QUERIES_PROJECTION_1LINE = new java.lang.String[0]; }

/**
 * This is the database projection that can be used to view saved queries, when
 * configured for two-line operation.
 * @apiSince 1
 */

public static final java.lang.String[] QUERIES_PROJECTION_2LINE;
static { QUERIES_PROJECTION_2LINE = new java.lang.String[0]; }

/**
 * Index into the provided query projections.  For use with Cursor.update methods.
 * @apiSince 1
 */

public static final int QUERIES_PROJECTION_DATE_INDEX = 1; // 0x1

/**
 * Index into the provided query projections.  For use with Cursor.update methods.
 * @apiSince 1
 */

public static final int QUERIES_PROJECTION_DISPLAY1_INDEX = 3; // 0x3

/**
 * Index into the provided query projections.  For use with Cursor.update methods.
 * @apiSince 1
 */

public static final int QUERIES_PROJECTION_DISPLAY2_INDEX = 4; // 0x4

/**
 * Index into the provided query projections.  For use with Cursor.update methods.
 * @apiSince 1
 */

public static final int QUERIES_PROJECTION_QUERY_INDEX = 2; // 0x2
}

