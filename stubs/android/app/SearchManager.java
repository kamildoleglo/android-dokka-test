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


package android.app;

import android.content.res.Configuration;
import android.content.Intent;
import android.content.ComponentName;
import android.database.Cursor;
import android.net.Uri;
import android.content.ContentResolver;

/**
 * This class provides access to the system search services.
 *
 * <p>In practice, you won't interact with this class directly, as search
 * services are provided through methods in {@link android.app.Activity Activity}
 * and the {@link android.content.Intent#ACTION_SEARCH ACTION_SEARCH}
 * {@link android.content.Intent Intent}.
 *
 * <p>
 * {@link android.content.res.Configuration#UI_MODE_TYPE_WATCH Configuration#UI_MODE_TYPE_WATCH} does not support this system service.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about using the search dialog and adding search
 * suggestions in your application, read the
 * <a href="{@docRoot}guide/topics/search/index.html">Search</a> developer guide.</p>
 * </div>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SearchManager implements android.content.DialogInterface.OnDismissListener, android.content.DialogInterface.OnCancelListener {

SearchManager() { throw new RuntimeException("Stub!"); }

/**
 * Launch search UI.
 *
 * <p>The search manager will open a search widget in an overlapping
 * window, and the underlying activity may be obscured.  The search
 * entry state will remain in effect until one of the following events:
 * <ul>
 * <li>The user completes the search.  In most cases this will launch
 * a search intent.</li>
 * <li>The user uses the back, home, or other keys to exit the search.</li>
 * <li>The application calls the {@link #stopSearch}
 * method, which will hide the search window and return focus to the
 * activity from which it was launched.</li>
 *
 * <p>Most applications will <i>not</i> use this interface to invoke search.
 * The primary method for invoking search is to call
 * {@link android.app.Activity#onSearchRequested Activity.onSearchRequested()} or
 * {@link android.app.Activity#startSearch Activity.startSearch()}.
 *
 * @param initialQuery A search string can be pre-entered here, but this
 * is typically null or empty.
 * @param selectInitialQuery If true, the initial query will be preselected, which means that
 * any further typing will replace it.  This is useful for cases where an entire pre-formed
 * query is being inserted.  If false, the selection point will be placed at the end of the
 * inserted query.  This is useful when the inserted query is text that the user entered,
 * and the user would expect to be able to keep typing.  <i>This parameter is only meaningful
 * if initialQuery is a non-empty string.</i>
 * @param launchActivity The ComponentName of the activity that has launched this search.
 * @param appSearchData An application can insert application-specific
 * context here, in order to improve quality or specificity of its own
 * searches.  This data will be returned with SEARCH intent(s).  Null if
 * no extra data is required.
 * @param globalSearch If false, this will only launch the search that has been specifically
 * defined by the application (which is usually defined as a local search).  If no default
 * search is defined in the current application or activity, global search will be launched.
 * If true, this will always launch a platform-global (e.g. web-based) search instead.
 *
 * @see android.app.Activity#onSearchRequested
 * @see #stopSearch
 * @apiSince 1
 */

public void startSearch(java.lang.String initialQuery, boolean selectInitialQuery, android.content.ComponentName launchActivity, android.os.Bundle appSearchData, boolean globalSearch) { throw new RuntimeException("Stub!"); }

/**
 * Gets the name of the global search activity.
 * @apiSince 16
 */

public android.content.ComponentName getGlobalSearchActivity() { throw new RuntimeException("Stub!"); }

/**
 * Similar to {@link #startSearch} but actually fires off the search query after invoking
 * the search dialog.  Made available for testing purposes.
 *
 * @param query The query to trigger.  If empty, request will be ignored.
 * @param launchActivity The ComponentName of the activity that has launched this search.
 * @param appSearchData An application can insert application-specific
 * context here, in order to improve quality or specificity of its own
 * searches.  This data will be returned with SEARCH intent(s).  Null if
 * no extra data is required.
 *
 * @see #startSearch
 * @apiSince 5
 */

public void triggerSearch(java.lang.String query, android.content.ComponentName launchActivity, android.os.Bundle appSearchData) { throw new RuntimeException("Stub!"); }

/**
 * Terminate search UI.
 *
 * <p>Typically the user will terminate the search UI by launching a
 * search or by canceling.  This function allows the underlying application
 * or activity to cancel the search prematurely (for any reason).
 *
 * <p>This function can be safely called at any time (even if no search is active.)
 *
 * <p>{@link android.content.res.Configuration#UI_MODE_TYPE_TELEVISION Configuration#UI_MODE_TYPE_TELEVISION} does not support this method.
 *
 * @see #startSearch
 * @apiSince 1
 */

public void stopSearch() { throw new RuntimeException("Stub!"); }

/**
 * Set or clear the callback that will be invoked whenever the search UI is dismissed.
 *
 * <p>{@link android.content.res.Configuration#UI_MODE_TYPE_TELEVISION Configuration#UI_MODE_TYPE_TELEVISION} does not support this method.
 *
 * @param listener The {@link android.app.SearchManager.OnDismissListener OnDismissListener} to use, or null.
 * @apiSince 1
 */

public void setOnDismissListener(android.app.SearchManager.OnDismissListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Set or clear the callback that will be invoked whenever the search UI is canceled.
 *
 * <p>{@link android.content.res.Configuration#UI_MODE_TYPE_TELEVISION Configuration#UI_MODE_TYPE_TELEVISION} does not support this method.
 *
 * @param listener The {@link android.app.SearchManager.OnCancelListener OnCancelListener} to use, or null.
 * @apiSince 1
 */

public void setOnCancelListener(android.app.SearchManager.OnCancelListener listener) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated This method is an obsolete internal implementation detail. Do not use.
 * @apiSince 1
 */

@Deprecated
public void onCancel(android.content.DialogInterface dialog) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated This method is an obsolete internal implementation detail. Do not use.
 * @apiSince 1
 */

@Deprecated
public void onDismiss(android.content.DialogInterface dialog) { throw new RuntimeException("Stub!"); }

/**
 * Gets information about a searchable activity.
 *
 * @param componentName The activity to get searchable information for.
 * @return Searchable information, or <code>null</code> if the activity does not
 *         exist, or is not searchable.
 * @apiSince 8
 */

public android.app.SearchableInfo getSearchableInfo(android.content.ComponentName componentName) { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of the searchable activities that can be included in global search.
 *
 * @return a list containing searchable information for all searchable activities
 *         that have the <code>android:includeInGlobalSearch</code> attribute set
 *         in their searchable meta-data.
 * @apiSince 8
 */

public java.util.List<android.app.SearchableInfo> getSearchablesInGlobalSearch() { throw new RuntimeException("Stub!"); }

/**
 * Intent extra data key: Use this key with Intent.ACTION_SEARCH and
 * {@link android.content.Intent#getIntExtra content.Intent.getIntExtra()}
 * to obtain the keycode that the user used to trigger this query.  It will be zero if the
 * user simply pressed the "GO" button on the search UI.  This is primarily used in conjunction
 * with the keycode attribute in the actionkey element of your searchable.xml configuration
 * file.
 * @apiSince 1
 */

public static final java.lang.String ACTION_KEY = "action_key";

/**
 * Intent extra data key: Use this key with Intent.ACTION_SEARCH and
 * {@link android.content.Intent#getStringExtra content.Intent.getStringExtra()}
 * to obtain the action message that was defined for a particular search action key and/or
 * suggestion.  It will be null if the search was launched by typing "enter", touching the
 * "GO" button, or other means not involving any action key.
 * @apiSince 1
 */

public static final java.lang.String ACTION_MSG = "action_msg";

/**
 * Intent extra data key: Use this key with Intent.ACTION_SEARCH and
 * {@link android.content.Intent#getBundleExtra
 *  content.Intent.getBundleExtra()}
 * to obtain any additional app-specific data that was inserted by the
 * activity that launched the search.
 * @apiSince 1
 */

public static final java.lang.String APP_DATA = "app_data";

/**
 * Boolean extra data key for a suggestion provider to return in {@link android.database.Cursor#getExtras Cursor#getExtras} to
 * indicate that the search is not complete yet. This can be used by the search UI
 * to indicate that a search is in progress. The suggestion provider can return partial results
 * this way and send a change notification on the cursor when more results are available.
 * @apiSince 8
 */

public static final java.lang.String CURSOR_EXTRA_KEY_IN_PROGRESS = "in_progress";

/**
 * Intent extra data key: This key will be used for the extra populated by the
 * {@link #SUGGEST_COLUMN_INTENT_EXTRA_DATA} column.
 * @apiSince 4
 */

public static final java.lang.String EXTRA_DATA_KEY = "intent_extra_data_key";

/**
 * Boolean extra data key for {@link android.content.Intent#ACTION_WEB_SEARCH Intent#ACTION_WEB_SEARCH} intents.  If {@code true},
 * this search should open a new browser window, rather than using an existing one.
 * @apiSince 12
 */

public static final java.lang.String EXTRA_NEW_SEARCH = "new_search";

/**
 * Boolean extra data key for {@link #INTENT_ACTION_GLOBAL_SEARCH} intents. If {@code true},
 * the initial query should be selected when the global search activity is started, so
 * that the user can easily replace it with another query.
 * @apiSince 8
 */

public static final java.lang.String EXTRA_SELECT_QUERY = "select_query";

/**
 * Extra data key for {@link android.content.Intent#ACTION_WEB_SEARCH Intent#ACTION_WEB_SEARCH}. If set, the value must be a
 * {@link android.app.PendingIntent PendingIntent}. The search activity handling the {@link android.content.Intent#ACTION_WEB_SEARCH Intent#ACTION_WEB_SEARCH}
 * intent will fill in and launch the pending intent. The data URI will be filled in with an
 * http or https URI, and {@link android.provider.Browser#EXTRA_HEADERS} may be filled in.
 * @apiSince 14
 */

public static final java.lang.String EXTRA_WEB_SEARCH_PENDINGINTENT = "web_search_pendingintent";

/**
 * Flag to specify that the entry can be used for query refinement, i.e., the query text
 * in the search field can be replaced with the text in this entry, when a query refinement
 * icon is clicked. The suggestion list should show such a clickable icon beside the entry.
 * <p>Use this flag as a bit-field for {@link #SUGGEST_COLUMN_FLAGS}.
 * @apiSince 11
 */

public static final int FLAG_QUERY_REFINEMENT = 1; // 0x1

/**
 * Intent action for starting the global search activity.
 * The global search provider should handle this intent.
 *
 * Supported extra data keys: {@link #QUERY},
 * {@link #EXTRA_SELECT_QUERY},
 * {@link #APP_DATA}.
 * @apiSince 8
 */

public static final java.lang.String INTENT_ACTION_GLOBAL_SEARCH = "android.search.action.GLOBAL_SEARCH";

/**
 * Intent action broadcasted to inform that the searchables list or default have changed.
 * Components should handle this intent if they cache any searchable data and wish to stay
 * up to date on changes.
 * @apiSince 4
 */

public static final java.lang.String INTENT_ACTION_SEARCHABLES_CHANGED = "android.search.action.SEARCHABLES_CHANGED";

/**
 * Intent action for starting the global search settings activity.
 * The global search provider should handle this intent.
 * @apiSince 8
 */

public static final java.lang.String INTENT_ACTION_SEARCH_SETTINGS = "android.search.action.SEARCH_SETTINGS";

/**
 * Intent action broadcasted to inform that the search settings have changed in some way.
 * Either searchables have been enabled or disabled, or a different web search provider
 * has been chosen.
 * @apiSince 4
 */

public static final java.lang.String INTENT_ACTION_SEARCH_SETTINGS_CHANGED = "android.search.action.SETTINGS_CHANGED";

/**
 * Intent action for starting a web search provider's settings activity.
 * Web search providers should handle this intent if they have provider-specific
 * settings to implement.
 * @apiSince 4
 */

public static final java.lang.String INTENT_ACTION_WEB_SEARCH_SETTINGS = "android.search.action.WEB_SEARCH_SETTINGS";

/**
 * Intent action to be broadcast to inform that the global search provider
 * has changed.
 * @apiSince 16
 */

public static final java.lang.String INTENT_GLOBAL_SEARCH_ACTIVITY_CHANGED = "android.search.action.GLOBAL_SEARCH_ACTIVITY_CHANGED";

/**
 * This is a shortcut definition for the default menu key to use for invoking search.
 *
 * See Menu.Item.setAlphabeticShortcut() for more information.
 * @apiSince 1
 */

public static final char MENU_KEY = 115; // 0x0073 's'

/**
 * This is a shortcut definition for the default menu key to use for invoking search.
 *
 * See Menu.Item.setAlphabeticShortcut() for more information.
 * @apiSince 1
 */

public static final int MENU_KEYCODE = 47; // 0x2f

/**
 * Intent extra data key: Use this key with
 * {@link android.content.Intent#getStringExtra
 *  content.Intent.getStringExtra()}
 * to obtain the query string from Intent.ACTION_SEARCH.
 * @apiSince 1
 */

public static final java.lang.String QUERY = "query";

/**
 * MIME type for shortcut validation.  You'll use this in your suggestions content provider
 * in the getType() function.
 * @apiSince 4
 */

public static final java.lang.String SHORTCUT_MIME_TYPE = "vnd.android.cursor.item/vnd.android.search.suggest";

/**
 * Column name for suggestions cursor. <i>Optional.</i>  If your content contains audio, you
 * should provide this column to specify the audio channel configuration. The data in the
 * column is string with format like "channels.subchannels" such as "1.0" or "5.1".
 * @apiSince 21
 */

public static final java.lang.String SUGGEST_COLUMN_AUDIO_CHANNEL_CONFIG = "suggest_audio_channel_config";

/**
 * Column name for suggestions cursor. <i>Optional.</i>  If your content is media type, you
 * should provide this column so search app could understand more about your content. The data
 * in the column must specify the MIME type of the content.
 * @apiSince 21
 */

public static final java.lang.String SUGGEST_COLUMN_CONTENT_TYPE = "suggest_content_type";

/**
 * Column name for suggestions cursor. <i>Optional.</i>  If your content is video or audio, you
 * should provide this column to specify the duration of your content in milliseconds. The data
 * in the column is of long type.
 * @apiSince 21
 */

public static final java.lang.String SUGGEST_COLUMN_DURATION = "suggest_duration";

/**
 * Column name for suggestions cursor. <i>Optional.</i> This column is used to specify
 * additional flags per item. Multiple flags can be specified.
 * <p>
 * Must be one of {@link #FLAG_QUERY_REFINEMENT} or 0 to indicate no flags.
 * </p>
 * @apiSince 11
 */

public static final java.lang.String SUGGEST_COLUMN_FLAGS = "suggest_flags";

/**
 * Column name for suggestions cursor.  <i>Unused - can be null or column can be omitted.</i>
 * @apiSince 1
 */

public static final java.lang.String SUGGEST_COLUMN_FORMAT = "suggest_format";

/**
 * Column name for suggestions cursor.  <i>Optional.</i>  If your cursor includes this column,
 *  then all suggestions will be provided in a format that includes space for two small icons,
 *  one at the left and one at the right of each suggestion.  The data in the column must
 *  be a resource ID of a drawable, or a URI in one of the following formats:
 *
 * <ul>
 * <li>content ({@link android.content.ContentResolver#SCHEME_CONTENT})</li>
 * <li>android.resource ({@link android.content.ContentResolver#SCHEME_ANDROID_RESOURCE})</li>
 * <li>file ({@link android.content.ContentResolver#SCHEME_FILE})</li>
 * </ul>
 *
 * See {@link android.content.ContentResolver#openAssetFileDescriptor(Uri, String)}
 * for more information on these schemes.
 * @apiSince 1
 */

public static final java.lang.String SUGGEST_COLUMN_ICON_1 = "suggest_icon_1";

/**
 * Column name for suggestions cursor.  <i>Optional.</i>  If your cursor includes this column,
 *  then all suggestions will be provided in a format that includes space for two small icons,
 *  one at the left and one at the right of each suggestion.  The data in the column must
 *  be a resource ID of a drawable, or a URI in one of the following formats:
 *
 * <ul>
 * <li>content ({@link android.content.ContentResolver#SCHEME_CONTENT})</li>
 * <li>android.resource ({@link android.content.ContentResolver#SCHEME_ANDROID_RESOURCE})</li>
 * <li>file ({@link android.content.ContentResolver#SCHEME_FILE})</li>
 * </ul>
 *
 * See {@link android.content.ContentResolver#openAssetFileDescriptor(Uri, String)}
 * for more information on these schemes.
 * @apiSince 1
 */

public static final java.lang.String SUGGEST_COLUMN_ICON_2 = "suggest_icon_2";

/**
 * Column name for suggestions cursor.  <i>Optional.</i>  If this column exists <i>and</i>
 * this element exists at the given row, this is the action that will be used when
 * forming the suggestion's intent.  If the element is not provided, the action will be taken
 * from the android:searchSuggestIntentAction field in your XML metadata.  <i>At least one of
 * these must be present for the suggestion to generate an intent.</i>  Note:  If your action is
 * the same for all suggestions, it is more efficient to specify it using XML metadata and omit
 * it from the cursor.
 * @apiSince 1
 */

public static final java.lang.String SUGGEST_COLUMN_INTENT_ACTION = "suggest_intent_action";

/**
 * Column name for suggestions cursor.  <i>Optional.</i>  If this column exists <i>and</i>
 * this element exists at the given row, this is the data that will be used when
 * forming the suggestion's intent.  If the element is not provided, the data will be taken
 * from the android:searchSuggestIntentData field in your XML metadata.  If neither source
 * is provided, the Intent's data field will be null.  Note:  If your data is
 * the same for all suggestions, or can be described using a constant part and a specific ID,
 * it is more efficient to specify it using XML metadata and omit it from the cursor.
 * @apiSince 1
 */

public static final java.lang.String SUGGEST_COLUMN_INTENT_DATA = "suggest_intent_data";

/**
 * Column name for suggestions cursor.  <i>Optional.</i>  If this column exists <i>and</i>
 * this element exists at the given row, then "/" and this value will be appended to the data
 * field in the Intent.  This should only be used if the data field has already been set to an
 * appropriate base string.
 * @apiSince 1
 */

public static final java.lang.String SUGGEST_COLUMN_INTENT_DATA_ID = "suggest_intent_data_id";

/**
 * Column name for suggestions cursor.  <i>Optional.</i>  If this column exists <i>and</i>
 * this element exists at the given row, this is the data that will be used when
 * forming the suggestion's intent. If not provided, the Intent's extra data field will be null.
 * This column allows suggestions to provide additional arbitrary data which will be included as
 * an extra under the key {@link #EXTRA_DATA_KEY}.
 * @apiSince 4
 */

public static final java.lang.String SUGGEST_COLUMN_INTENT_EXTRA_DATA = "suggest_intent_extra_data";

/**
 * Column name for suggestions cursor. <i>Optional.</i>  If your content is media type, you
 * should provide this column to specify whether your content is live media such as live video
 * or live audio. The value in the column is of integer type with value of either 0 indicating
 * non-live content or 1 indicating live content.
 * @apiSince 21
 */

public static final java.lang.String SUGGEST_COLUMN_IS_LIVE = "suggest_is_live";

/**
 * Column name for suggestions cursor. <i>Optional.</i> This column may be
 * used to specify the time in {@link java.lang.System#currentTimeMillis System#currentTimeMillis} (wall time in UTC) when an item was last
 * accessed within the results-providing application. If set, this may be
 * used to show more-recently-used items first.
 * @apiSince 14
 */

public static final java.lang.String SUGGEST_COLUMN_LAST_ACCESS_HINT = "suggest_last_access_hint";

/**
 * Column name for suggestions cursor. <i>Optional.</i>  If your content is video or audio and
 * has a known production year, you should provide this column to specify the production year
 * of your content. The data in the column is of integer type.
 * @apiSince 21
 */

public static final java.lang.String SUGGEST_COLUMN_PRODUCTION_YEAR = "suggest_production_year";

/**
 * Column name for suggestions cursor. <i>Optional.</i>  If your content is purchasable, you
 * should provide this column to specify the displayable string representation of the purchase
 * price of your content including the currency and the amount. If it's free, you should
 * provide localized string to specify that it's free. This column can be omitted if the content
 * is not applicable to purchase.
 * @apiSince 21
 */

public static final java.lang.String SUGGEST_COLUMN_PURCHASE_PRICE = "suggest_purchase_price";

/**
 * Column name for suggestions cursor.  <i>Required if action is
 * {@link android.content.Intent#ACTION_SEARCH ACTION_SEARCH}, optional otherwise.</i>  If this
 * column exists <i>and</i> this element exists at the given row, this is the data that will be
 * used when forming the suggestion's query.
 * @apiSince 1
 */

public static final java.lang.String SUGGEST_COLUMN_QUERY = "suggest_intent_query";

/**
 * Column name for suggestions cursor. <i>Optional.</i>  If your content has a rating, you
 * should provide this column to specify the rating score of your content. The data in the
 * column is of float type. See {@link android.media.Rating} about valid rating scores for each
 * rating style.
 * @apiSince 21
 */

public static final java.lang.String SUGGEST_COLUMN_RATING_SCORE = "suggest_rating_score";

/**
 * Column name for suggestions cursor. <i>Optional.</i>  If your content has a rating, you
 * should provide this column to specify the rating style of your content. The data in the
 * column must be one of the constant values specified in {@link android.media.Rating}
 * @apiSince 21
 */

public static final java.lang.String SUGGEST_COLUMN_RATING_STYLE = "suggest_rating_style";

/**
 * Column name for suggestions cursor. <i>Optional.</i>  If your content is rentable, you
 * should provide this column to specify the displayable string representation of the rental
 * price of your content including the currency and the amount. If it's free, you should
 * provide localized string to specify that it's free. This column can be omitted if the
 * content is not applicable to rent.
 * @apiSince 21
 */

public static final java.lang.String SUGGEST_COLUMN_RENTAL_PRICE = "suggest_rental_price";

/**
 * Column name for suggestions cursor.  <i>Optional.</i>  If your cursor includes this column,
 * then the image will be displayed when forming the suggestion. The suggested dimension for
 * the image is 270x400 px for portrait mode and 400x225 px for landscape mode. The data in the
 * column must be a resource ID of a drawable, or a URI in one of the following formats:
 *
 * <ul>
 * <li>content ({@link android.content.ContentResolver#SCHEME_CONTENT})</li>
 * <li>android.resource ({@link android.content.ContentResolver#SCHEME_ANDROID_RESOURCE})</li>
 * <li>file ({@link android.content.ContentResolver#SCHEME_FILE})</li>
 * </ul>
 *
 * See {@link android.content.ContentResolver#openAssetFileDescriptor(Uri, String)}
 * for more information on these schemes.
 * @apiSince 21
 */

public static final java.lang.String SUGGEST_COLUMN_RESULT_CARD_IMAGE = "suggest_result_card_image";

/**
 * Column name for suggestions cursor. <i>Optional.</i>  This column is used to indicate whether
 * a search suggestion should be stored as a shortcut, and whether it should be refreshed.  If
 * missing, the result will be stored as a shortcut and never validated.  If set to
 * {@link #SUGGEST_NEVER_MAKE_SHORTCUT}, the result will not be stored as a shortcut.
 * Otherwise, the shortcut id will be used to check back for an up to date suggestion using
 * {@link #SUGGEST_URI_PATH_SHORTCUT}.
 * @apiSince 4
 */

public static final java.lang.String SUGGEST_COLUMN_SHORTCUT_ID = "suggest_shortcut_id";

/**
 * Column name for suggestions cursor. <i>Optional.</i> This column is used to specify
 * that a spinner should be shown in lieu of an icon2 while the shortcut of this suggestion
 * is being refreshed.
 * @apiSince 4
 */

public static final java.lang.String SUGGEST_COLUMN_SPINNER_WHILE_REFRESHING = "suggest_spinner_while_refreshing";

/**
 * Column name for suggestions cursor.  <i>Required.</i>  This is the primary line of text that
 * will be presented to the user as the suggestion.
 * @apiSince 1
 */

public static final java.lang.String SUGGEST_COLUMN_TEXT_1 = "suggest_text_1";

/**
 * Column name for suggestions cursor.  <i>Optional.</i>  If your cursor includes this column,
 *  then all suggestions will be provided in a two-line format.  The second line of text is in
 *  a much smaller appearance.
 * @apiSince 1
 */

public static final java.lang.String SUGGEST_COLUMN_TEXT_2 = "suggest_text_2";

/**
 * Column name for suggestions cursor.  <i>Optional.</i> This is a URL that will be shown
 * as the second line of text instead of {@link #SUGGEST_COLUMN_TEXT_2}. This is a separate
 * column so that the search UI knows to display the text as a URL, e.g. by using a different
 * color. If this column is absent, or has the value {@code null},
 * {@link #SUGGEST_COLUMN_TEXT_2} will be used instead.
 * @apiSince 8
 */

public static final java.lang.String SUGGEST_COLUMN_TEXT_2_URL = "suggest_text_2_url";

/**
 * Column name for suggestions cursor. <i>Optional.</i>  If your content is video, you should
 * provide this column to specify the number of horizontal lines. The data in the column is of
 * integer type.
 * @apiSince 21
 */

public static final java.lang.String SUGGEST_COLUMN_VIDEO_HEIGHT = "suggest_video_height";

/**
 * Column name for suggestions cursor. <i>Optional.</i>  If your content is video, you should
 * provide this column to specify the number of vertical lines. The data in the column is of
 * integer type.
 * @apiSince 21
 */

public static final java.lang.String SUGGEST_COLUMN_VIDEO_WIDTH = "suggest_video_width";

/**
 * MIME type for suggestions data.  You'll use this in your suggestions content provider
 * in the getType() function.
 * @apiSince 1
 */

public static final java.lang.String SUGGEST_MIME_TYPE = "vnd.android.cursor.dir/vnd.android.search.suggest";

/**
 * Column value for suggestion column {@link #SUGGEST_COLUMN_SHORTCUT_ID} when a suggestion
 * should not be stored as a shortcut in global search.
 * @apiSince 4
 */

public static final java.lang.String SUGGEST_NEVER_MAKE_SHORTCUT = "_-1";

/**
 * Query parameter added to suggestion queries to limit the number of suggestions returned.
 * This limit is only advisory and suggestion providers may chose to ignore it.
 * @apiSince 5
 */

public static final java.lang.String SUGGEST_PARAMETER_LIMIT = "limit";

/**
 * Uri path for queried suggestions data.  This is the path that the search manager
 * will use when querying your content provider for suggestions data based on user input
 * (e.g. looking for partial matches).
 * Typically you'll use this with a URI matcher.
 * @apiSince 1
 */

public static final java.lang.String SUGGEST_URI_PATH_QUERY = "search_suggest_query";

/**
 * Uri path for shortcut validation.  This is the path that the search manager will use when
 * querying your content provider to refresh a shortcutted suggestion result and to check if it
 * is still valid.  When asked, a source may return an up to date result, or no result.  No
 * result indicates the shortcut refers to a no longer valid sugggestion.
 *
 * @see #SUGGEST_COLUMN_SHORTCUT_ID
 * @apiSince 4
 */

public static final java.lang.String SUGGEST_URI_PATH_SHORTCUT = "search_suggest_shortcut";

/**
 * Intent extra data key: Use this key with
 * {@link android.content.Intent#getStringExtra
 *  content.Intent.getStringExtra()}
 * to obtain the query string typed in by the user.
 * This may be different from the value of {@link #QUERY}
 * if the intent is the result of selecting a suggestion.
 * In that case, {@link #QUERY} will contain the value of
 * {@link #SUGGEST_COLUMN_QUERY} for the suggestion, and
 * {@link #USER_QUERY} will contain the string typed by the
 * user.
 * @apiSince 4
 */

public static final java.lang.String USER_QUERY = "user_query";
/**
 * See {@link android.app.SearchManager#setOnCancelListener SearchManager#setOnCancelListener} for configuring your activity to monitor
 * search UI state.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnCancelListener {

/**
 * This method will be called when the search UI is canceled. To make use if it, you must
 * implement this method in your activity, and call
 * {@link android.app.SearchManager#setOnCancelListener SearchManager#setOnCancelListener} to register it.
 * @apiSince 1
 */

public void onCancel();
}

/**
 * See {@link android.app.SearchManager#setOnDismissListener SearchManager#setOnDismissListener} for configuring your activity to monitor
 * search UI state.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnDismissListener {

/**
 * This method will be called when the search UI is dismissed. To make use of it, you must
 * implement this method in your activity, and call
 * {@link android.app.SearchManager#setOnDismissListener SearchManager#setOnDismissListener} to register it.
 * @apiSince 1
 */

public void onDismiss();
}

}

