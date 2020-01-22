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

import android.content.ComponentName;
import android.text.InputType;
import android.view.inputmethod.EditorInfo;

/**
 * Searchability meta-data for an activity. Only applications that search other applications
 * should need to use this class.
 * See <a href="{@docRoot}guide/topics/search/searchable-config.html">Searchable Configuration</a>
 * for more information about declaring searchability meta-data for your application.
 *
 * @see android.app.SearchManager#getSearchableInfo(ComponentName)
 * @see android.app.SearchManager#getSearchablesInGlobalSearch()
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SearchableInfo implements android.os.Parcelable {

SearchableInfo() { throw new RuntimeException("Stub!"); }

/**
 * Gets the search suggestion content provider authority.
 *
 * @return The search suggestions authority, or {@code null} if not set.
 * @see android.R.styleable#Searchable_searchSuggestAuthority
 * @apiSince 8
 */

public java.lang.String getSuggestAuthority() { throw new RuntimeException("Stub!"); }

/**
 * Gets the name of the package where the suggestion provider lives,
 * or {@code null}.
 * @apiSince 8
 */

public java.lang.String getSuggestPackage() { throw new RuntimeException("Stub!"); }

/**
 * Gets the component name of the searchable activity.
 *
 * @return A component name, never {@code null}.
 * @apiSince 8
 */

public android.content.ComponentName getSearchActivity() { throw new RuntimeException("Stub!"); }

/**
 * Checks whether the text in the query field should come from the suggestion intent data.
 *
 * @see android.R.styleable#Searchable_searchMode
 * @apiSince 8
 */

public boolean shouldRewriteQueryFromData() { throw new RuntimeException("Stub!"); }

/**
 * Checks whether the text in the query field should come from the suggestion title.
 *
 * @see android.R.styleable#Searchable_searchMode
 * @apiSince 8
 */

public boolean shouldRewriteQueryFromText() { throw new RuntimeException("Stub!"); }

/**
 * Gets the resource id of the description string to use for this source in system search
 * settings, or {@code 0} if none has been specified.
 *
 * @see android.R.styleable#Searchable_searchSettingsDescription
 * @apiSince 8
 */

public int getSettingsDescriptionId() { throw new RuntimeException("Stub!"); }

/**
 * Gets the content provider path for obtaining search suggestions.
 *
 * @return The suggestion path, or {@code null} if not set.
 * @see android.R.styleable#Searchable_searchSuggestPath
 * @apiSince 8
 */

public java.lang.String getSuggestPath() { throw new RuntimeException("Stub!"); }

/**
 * Gets the selection for obtaining search suggestions.
 *
 * @see android.R.styleable#Searchable_searchSuggestSelection
 * @apiSince 8
 */

public java.lang.String getSuggestSelection() { throw new RuntimeException("Stub!"); }

/**
 * Gets the optional intent action for use with these suggestions. This is
 * useful if all intents will have the same action
 * (e.g. {@link android.content.Intent#ACTION_VIEW})
 *
 * This can be overriden in any given suggestion using the column
 * {@link android.app.SearchManager#SUGGEST_COLUMN_INTENT_ACTION SearchManager#SUGGEST_COLUMN_INTENT_ACTION}.
 *
 * @return The default intent action, or {@code null} if not set.
 * @see android.R.styleable#Searchable_searchSuggestIntentAction
 * @apiSince 8
 */

public java.lang.String getSuggestIntentAction() { throw new RuntimeException("Stub!"); }

/**
 * Gets the optional intent data for use with these suggestions.  This is
 * useful if all intents will have similar data URIs,
 * but you'll likely need to provide a specific ID as well via the column
 * {@link android.app.SearchManager#SUGGEST_COLUMN_INTENT_DATA_ID SearchManager#SUGGEST_COLUMN_INTENT_DATA_ID}, which will be appended to the
 * intent data URI.
 *
 * This can be overriden in any given suggestion using the column
 * {@link android.app.SearchManager#SUGGEST_COLUMN_INTENT_DATA SearchManager#SUGGEST_COLUMN_INTENT_DATA}.
 *
 * @return The default intent data, or {@code null} if not set.
 * @see android.R.styleable#Searchable_searchSuggestIntentData
 * @apiSince 8
 */

public java.lang.String getSuggestIntentData() { throw new RuntimeException("Stub!"); }

/**
 * Gets the suggestion threshold.
 *
 * @return The suggestion threshold, or {@code 0} if not set.
 * @see android.R.styleable#Searchable_searchSuggestThreshold
 * @apiSince 8
 */

public int getSuggestThreshold() { throw new RuntimeException("Stub!"); }

/**
 * Gets the resource id of the hint text. This must be
 * read using the searchable Activity's resources.
 *
 * @return A resource id, or {@code 0} if no hint was specified.
 * @see android.R.styleable#Searchable_hint
 * @apiSince 8
 */

public int getHintId() { throw new RuntimeException("Stub!"); }

/**
 * Checks if the searchable activity wants the voice search button to be shown.
 *
 * @see android.R.styleable#Searchable_voiceSearchMode
 * @apiSince 8
 */

public boolean getVoiceSearchEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Checks if voice search should start web search.
 *
 * @see android.R.styleable#Searchable_voiceSearchMode
 * @apiSince 8
 */

public boolean getVoiceSearchLaunchWebSearch() { throw new RuntimeException("Stub!"); }

/**
 * Checks if voice search should start in-app search.
 *
 * @see android.R.styleable#Searchable_voiceSearchMode
 * @apiSince 8
 */

public boolean getVoiceSearchLaunchRecognizer() { throw new RuntimeException("Stub!"); }

/**
 * Gets the resource id of the voice search language model string.
 *
 * @return A resource id, or {@code 0} if no language model was specified.
 * @see android.R.styleable#Searchable_voiceLanguageModel
 * @apiSince 8
 */

public int getVoiceLanguageModeId() { throw new RuntimeException("Stub!"); }

/**
 * Gets the resource id of the voice prompt text string.
 *
 * @return A resource id, or {@code 0} if no voice prompt text was specified.
 * @see android.R.styleable#Searchable_voicePromptText
 * @apiSince 8
 */

public int getVoicePromptTextId() { throw new RuntimeException("Stub!"); }

/**
 * Gets the resource id of the spoken language to recognize in voice search.
 *
 * @return A resource id, or {@code 0} if no language was specified.
 * @see android.R.styleable#Searchable_voiceLanguage
 * @apiSince 8
 */

public int getVoiceLanguageId() { throw new RuntimeException("Stub!"); }

/**
 * The maximum number of voice recognition results to return.
 *
 * @return the max results count, if specified in the searchable
 *         activity's metadata, or {@code 0} if not specified.
 * @see android.R.styleable#Searchable_voiceMaxResults
 * @apiSince 8
 */

public int getVoiceMaxResults() { throw new RuntimeException("Stub!"); }

/**
 * Gets the input type as specified in the searchable attributes. This will default to
 * {@link android.text.InputType#TYPE_CLASS_TEXT InputType#TYPE_CLASS_TEXT} if not specified (which is appropriate
 * for free text input).
 *
 * @return the input type
 * @see android.R.styleable#Searchable_inputType
 * @apiSince 8
 */

public int getInputType() { throw new RuntimeException("Stub!"); }

/**
 * Gets the input method options specified in the searchable attributes.
 * This will default to {@link android.view.inputmethod.EditorInfo#IME_ACTION_GO EditorInfo#IME_ACTION_GO} if not specified (which is
 * appropriate for a search box).
 *
 * @return the input type
 * @see android.R.styleable#Searchable_imeOptions
 * @apiSince 8
 */

public int getImeOptions() { throw new RuntimeException("Stub!"); }

/**
 * Checks whether the searchable should be included in global search.
 *
 * @return The value of the {@link android.R.styleable#Searchable_includeInGlobalSearch}
 *         attribute, or {@code false} if the attribute is not set.
 * @see android.R.styleable#Searchable_includeInGlobalSearch
 * @apiSince 8
 */

public boolean shouldIncludeInGlobalSearch() { throw new RuntimeException("Stub!"); }

/**
 * Checks whether this searchable activity should be queried for suggestions if a prefix
 * of the query has returned no results.
 *
 * @see android.R.styleable#Searchable_queryAfterZeroResults
 * @apiSince 8
 */

public boolean queryAfterZeroResults() { throw new RuntimeException("Stub!"); }

/**
 * Checks whether this searchable activity has auto URL detection turned on.
 *
 * @see android.R.styleable#Searchable_autoUrlDetect
 * @apiSince 8
 */

public boolean autoUrlDetect() { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Support for parcelable and aidl operations.
 * @apiSince 8
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.app.SearchableInfo> CREATOR;
static { CREATOR = null; }
}

