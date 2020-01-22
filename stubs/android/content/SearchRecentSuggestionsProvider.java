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


package android.content;

import android.app.SearchManager;

/**
 * This superclass can be used to create a simple search suggestions provider for your application.
 * It creates suggestions (as the user types) based on recent queries and/or recent views.
 *
 * <p>In order to use this class, you must do the following.
 *
 * <ul>
 * <li>Implement and test query search, as described in {@link android.app.SearchManager}.  (This
 * provider will send any suggested queries via the standard
 * {@link android.content.Intent#ACTION_SEARCH ACTION_SEARCH} Intent, which you'll already
 * support once you have implemented and tested basic searchability.)</li>
 * <li>Create a Content Provider within your application by extending
 * {@link android.content.SearchRecentSuggestionsProvider}.  The class you create will be
 * very simple - typically, it will have only a constructor.  But the constructor has a very
 * important responsibility:  When it calls {@link #setupSuggestions(java.lang.String,int)}, it
 * <i>configures</i> the provider to match the requirements of your searchable activity.</li>
 * <li>Create a manifest entry describing your provider.  Typically this would be as simple
 * as adding the following lines:
 * <pre class="prettyprint">
 *     &lt;!-- Content provider for search suggestions --&gt;
 *     &lt;provider android:name="YourSuggestionProviderClass"
 *               android:authorities="your.suggestion.authority" /&gt;</pre>
 * </li>
 * <li>Please note that you <i>do not</i> instantiate this content provider directly from within
 * your code.  This is done automatically by the system Content Resolver, when the search dialog
 * looks for suggestions.</li>
 * <li>In order for the Content Resolver to do this, you must update your searchable activity's
 * XML configuration file with information about your content provider.  The following additions
 * are usually sufficient:
 * <pre class="prettyprint">
 *     android:searchSuggestAuthority="your.suggestion.authority"
 *     android:searchSuggestSelection=" ? "</pre>
 * </li>
 * <li>In your searchable activities, capture any user-generated queries and record them
 * for future searches by calling {@link android.provider.SearchRecentSuggestions#saveRecentQuery
 * SearchRecentSuggestions.saveRecentQuery()}.</li>
 * </ul>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For information about using search suggestions in your application, read the
 * <a href="{@docRoot}guide/topics/search/index.html">Search</a> developer guide.</p>
 * </div>
 *
 * @see android.provider.SearchRecentSuggestions
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SearchRecentSuggestionsProvider extends android.content.ContentProvider {

public SearchRecentSuggestionsProvider() { throw new RuntimeException("Stub!"); }

/**
 * In order to use this class, you must extend it, and call this setup function from your
 * constructor.  In your application or activities, you must provide the same values when
 * you create the {@link android.provider.SearchRecentSuggestions} helper.
 *
 * @param authority This must match the authority that you've declared in your manifest.
 * @param mode You can use mode flags here to determine certain functional aspects of your
 * database.  Note, this value should not change from run to run, because when it does change,
 * your suggestions database may be wiped.
 *
 * @see #DATABASE_MODE_QUERIES
 * @see #DATABASE_MODE_2LINES
 * @apiSince 1
 */

protected void setupSuggestions(java.lang.String authority, int mode) { throw new RuntimeException("Stub!"); }

/**
 * This method is provided for use by the ContentResolver.  Do not override, or directly
 * call from your own code.
 * @apiSince 1
 */

public int delete(android.net.Uri uri, java.lang.String selection, java.lang.String[] selectionArgs) { throw new RuntimeException("Stub!"); }

/**
 * This method is provided for use by the ContentResolver.  Do not override, or directly
 * call from your own code.
 * @apiSince 1
 */

public java.lang.String getType(android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * This method is provided for use by the ContentResolver.  Do not override, or directly
 * call from your own code.
 * @apiSince 1
 */

public android.net.Uri insert(android.net.Uri uri, android.content.ContentValues values) { throw new RuntimeException("Stub!"); }

/**
 * This method is provided for use by the ContentResolver.  Do not override, or directly
 * call from your own code.
 * @apiSince 1
 */

public boolean onCreate() { throw new RuntimeException("Stub!"); }

/**
 * This method is provided for use by the ContentResolver.  Do not override, or directly
 * call from your own code.
 * @apiSince 1
 */

public android.database.Cursor query(android.net.Uri uri, java.lang.String[] projection, java.lang.String selection, java.lang.String[] selectionArgs, java.lang.String sortOrder) { throw new RuntimeException("Stub!"); }

/**
 * This method is provided for use by the ContentResolver.  Do not override, or directly
 * call from your own code.
 * @apiSince 1
 */

public int update(android.net.Uri uri, android.content.ContentValues values, java.lang.String selection, java.lang.String[] selectionArgs) { throw new RuntimeException("Stub!"); }

/**
 * This mode bit configures the database to include a 2nd annotation line with each entry.
 * <i>optional</i>
 *
 * @see #setupSuggestions(String, int)
 * @apiSince 1
 */

public static final int DATABASE_MODE_2LINES = 2; // 0x2

/**
 * This mode bit configures the database to record recent queries.  <i>required</i>
 *
 * @see #setupSuggestions(String, int)
 * @apiSince 1
 */

public static final int DATABASE_MODE_QUERIES = 1; // 0x1
}

