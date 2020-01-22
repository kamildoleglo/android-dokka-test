/*
 * Copyright (C) 2011 The Android Open Source Project
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


package android.view.textservice;


/**
 * The SpellCheckerSession interface provides the per client functionality of SpellCheckerService.
 *
 *
 * <a name="Applications"></a>
 * <h3>Applications</h3>
 *
 * <p>In most cases, applications that are using the standard
 * {@link android.widget.TextView} or its subclasses will have little they need
 * to do to work well with spell checker services.  The main things you need to
 * be aware of are:</p>
 *
 * <ul>
 * <li> Properly set the {@link android.R.attr#inputType} in your editable
 * text views, so that the spell checker will have enough context to help the
 * user in editing text in them.
 * </ul>
 *
 * <p>For the rare people amongst us writing client applications that use the spell checker service
 * directly, you will need to use {@link #getSuggestions(android.view.textservice.TextInfo,int)} or
 * {@link #getSuggestions(android.view.textservice.TextInfo[],int,boolean)} for obtaining results from the spell checker
 * service by yourself.</p>
 *
 * <h3>Security</h3>
 *
 * <p>There are a lot of security issues associated with spell checkers,
 * since they could monitor all the text being sent to them
 * through, for instance, {@link android.widget.TextView}.
 * The Android spell checker framework also allows
 * arbitrary third party spell checkers, so care must be taken to restrict their
 * selection and interactions.</p>
 *
 * <p>Here are some key points about the security architecture behind the
 * spell checker framework:</p>
 *
 * <ul>
 * <li>Only the system is allowed to directly access a spell checker framework's
 * {@link android.service.textservice.SpellCheckerService} interface, via the
 * {@link android.Manifest.permission#BIND_TEXT_SERVICE} permission.  This is
 * enforced in the system by not binding to a spell checker service that does
 * not require this permission.
 *
 * <li>The user must explicitly enable a new spell checker in settings before
 * they can be enabled, to confirm with the system that they know about it
 * and want to make it available for use.
 * </ul>
 *
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SpellCheckerSession {

SpellCheckerSession() { throw new RuntimeException("Stub!"); }

/**
 * @return true if the connection to a text service of this session is disconnected and not
 * alive.
 * @apiSince 14
 */

public boolean isSessionDisconnected() { throw new RuntimeException("Stub!"); }

/**
 * Get the spell checker service info this spell checker session has.
 * @return SpellCheckerInfo for the specified locale.
 * @apiSince 14
 */

public android.view.textservice.SpellCheckerInfo getSpellChecker() { throw new RuntimeException("Stub!"); }

/**
 * Cancel pending and running spell check tasks
 * @apiSince 15
 */

public void cancel() { throw new RuntimeException("Stub!"); }

/**
 * Finish this session and allow TextServicesManagerService to disconnect the bound spell
 * checker.
 * @apiSince 14
 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * Get suggestions from the specified sentences
 * @param textInfos an array of text metadata for a spell checker
 * @param suggestionsLimit the maximum number of suggestions that will be returned
 * @apiSince 16
 */

public void getSentenceSuggestions(android.view.textservice.TextInfo[] textInfos, int suggestionsLimit) { throw new RuntimeException("Stub!"); }

/**
 * Get candidate strings for a substring of the specified text.
 * @param textInfo text metadata for a spell checker
 * @param suggestionsLimit the maximum number of suggestions that will be returned
 * @deprecated use {@link android.view.textservice.SpellCheckerSession#getSentenceSuggestions(android.view.textservice.TextInfo[],int) SpellCheckerSession#getSentenceSuggestions(TextInfo[], int)} instead
 * @apiSince 14
 * @deprecatedSince 16
 */

@Deprecated
public void getSuggestions(android.view.textservice.TextInfo textInfo, int suggestionsLimit) { throw new RuntimeException("Stub!"); }

/**
 * A batch process of getSuggestions
 * @param textInfos an array of text metadata for a spell checker
 * @param suggestionsLimit the maximum number of suggestions that will be returned
 * @param sequentialWords true if textInfos can be treated as sequential words.
 * @deprecated use {@link android.view.textservice.SpellCheckerSession#getSentenceSuggestions(android.view.textservice.TextInfo[],int) SpellCheckerSession#getSentenceSuggestions(TextInfo[], int)} instead
 * @apiSince 14
 * @deprecatedSince 16
 */

@Deprecated
public void getSuggestions(android.view.textservice.TextInfo[] textInfos, int suggestionsLimit, boolean sequentialWords) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Name under which a SpellChecker service component publishes information about itself.
 * This meta-data must reference an XML resource.
 *     * @apiSince 14
 */

public static final java.lang.String SERVICE_META_DATA = "android.view.textservice.scs";
/**
 * Callback for getting results from text services
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface SpellCheckerSessionListener {

/**
 * Callback for {@link android.view.textservice.SpellCheckerSession#getSuggestions(android.view.textservice.TextInfo,int) SpellCheckerSession#getSuggestions(TextInfo, int)}
 * and {@link android.view.textservice.SpellCheckerSession#getSuggestions(android.view.textservice.TextInfo[],int,boolean) SpellCheckerSession#getSuggestions(TextInfo[], int, boolean)}
 * @param results an array of {@link android.view.textservice.SuggestionsInfo SuggestionsInfo}s.
 * These results are suggestions for {@link android.view.textservice.TextInfo TextInfo}s queried by
 * {@link android.view.textservice.SpellCheckerSession#getSuggestions(android.view.textservice.TextInfo,int) SpellCheckerSession#getSuggestions(TextInfo, int)} or
 * {@link android.view.textservice.SpellCheckerSession#getSuggestions(android.view.textservice.TextInfo[],int,boolean) SpellCheckerSession#getSuggestions(TextInfo[], int, boolean)}
 * @apiSince 14
 */

public void onGetSuggestions(android.view.textservice.SuggestionsInfo[] results);

/**
 * Callback for {@link android.view.textservice.SpellCheckerSession#getSentenceSuggestions(android.view.textservice.TextInfo[],int) SpellCheckerSession#getSentenceSuggestions(TextInfo[], int)}
 * @param results an array of {@link android.view.textservice.SentenceSuggestionsInfo SentenceSuggestionsInfo}s.
 * These results are suggestions for {@link android.view.textservice.TextInfo TextInfo}s
 * queried by {@link android.view.textservice.SpellCheckerSession#getSentenceSuggestions(android.view.textservice.TextInfo[],int) SpellCheckerSession#getSentenceSuggestions(TextInfo[], int)}.
 * @apiSince 16
 */

public void onGetSentenceSuggestions(android.view.textservice.SentenceSuggestionsInfo[] results);
}

}

