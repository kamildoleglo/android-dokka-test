/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */


package android.service.textservice;

import android.app.Service;
import android.view.textservice.TextInfo;
import android.view.textservice.SuggestionsInfo;
import android.view.textservice.SentenceSuggestionsInfo;
import java.util.Locale;
import android.os.Bundle;

/**
 * SpellCheckerService provides an abstract base class for a spell checker.
 * This class combines a service to the system with the spell checker service interface that
 * spell checker must implement.
 *
 * <p>In addition to the normal Service lifecycle methods, this class
 * introduces a new specific callback that subclasses should override
 * {@link #createSession()} to provide a spell checker session that is corresponding
 * to requested language and so on. The spell checker session returned by this method
 * should extend {@link android.service.textservice.SpellCheckerService.Session SpellCheckerService.Session}.
 * </p>
 *
 * <h3>Returning spell check results</h3>
 *
 * <p>{@link android.service.textservice.SpellCheckerService.Session#onGetSuggestions(android.view.textservice.TextInfo,int) SpellCheckerService.Session#onGetSuggestions(TextInfo, int)}
 * should return spell check results.
 * It receives {@link android.view.textservice.TextInfo} and returns
 * {@link android.view.textservice.SuggestionsInfo} for the input.
 * You may want to override
 * {@link android.service.textservice.SpellCheckerService.Session#onGetSuggestionsMultiple(android.view.textservice.TextInfo[],int,boolean) SpellCheckerService.Session#onGetSuggestionsMultiple(TextInfo[], int, boolean)} for
 * better performance and quality.
 * </p>
 *
 * <p>Please note that {@link android.service.textservice.SpellCheckerService.Session#getLocale() SpellCheckerService.Session#getLocale()} does not return a valid
 * locale before {@link android.service.textservice.SpellCheckerService.Session#onCreate() SpellCheckerService.Session#onCreate()} </p>
 *
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class SpellCheckerService extends android.app.Service {

public SpellCheckerService() { throw new RuntimeException("Stub!"); }

/**
 * Implement to return the implementation of the internal spell checker
 * service interface. Subclasses should not override.
 * @apiSince 14
 */

public final android.os.IBinder onBind(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Factory method to create a spell checker session impl
 * @return SpellCheckerSessionImpl which should be overridden by a concrete implementation.
 * @apiSince 14
 */

public abstract android.service.textservice.SpellCheckerService.Session createSession();

/** @apiSince 14 */

public static final java.lang.String SERVICE_INTERFACE = "android.service.textservice.SpellCheckerService";
/**
 * This abstract class should be overridden by a concrete implementation of a spell checker.
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class Session {

public Session() { throw new RuntimeException("Stub!"); }

/**
 * This is called after the class is initialized, at which point it knows it can call
 * getLocale() etc...
 * @apiSince 14
 */

public abstract void onCreate();

/**
 * Get suggestions for specified text in TextInfo.
 * This function will run on the incoming IPC thread.
 * So, this is not called on the main thread,
 * but will be called in series on another thread.
 * @param textInfo the text metadata
 * @param suggestionsLimit the maximum number of suggestions to be returned
 * @return SuggestionsInfo which contains suggestions for textInfo
 * @apiSince 14
 */

public abstract android.view.textservice.SuggestionsInfo onGetSuggestions(android.view.textservice.TextInfo textInfo, int suggestionsLimit);

/**
 * A batch process of onGetSuggestions.
 * This function will run on the incoming IPC thread.
 * So, this is not called on the main thread,
 * but will be called in series on another thread.
 * @param textInfos an array of the text metadata
 * @param suggestionsLimit the maximum number of suggestions to be returned
 * @param sequentialWords true if textInfos can be treated as sequential words.
 * @return an array of {@link android.view.textservice.SentenceSuggestionsInfo SentenceSuggestionsInfo} returned by
 * {@link android.service.textservice.SpellCheckerService.Session#onGetSuggestions(android.view.textservice.TextInfo,int) SpellCheckerService.Session#onGetSuggestions(TextInfo, int)}
 * @apiSince 14
 */

public android.view.textservice.SuggestionsInfo[] onGetSuggestionsMultiple(android.view.textservice.TextInfo[] textInfos, int suggestionsLimit, boolean sequentialWords) { throw new RuntimeException("Stub!"); }

/**
 * Get sentence suggestions for specified texts in an array of TextInfo.
 * The default implementation splits the input text to words and returns
 * {@link android.view.textservice.SentenceSuggestionsInfo SentenceSuggestionsInfo} which contains suggestions for each word.
 * This function will run on the incoming IPC thread.
 * So, this is not called on the main thread,
 * but will be called in series on another thread.
 * When you override this method, make sure that suggestionsLimit is applied to suggestions
 * that share the same start position and length.
 * @param textInfos an array of the text metadata
 * @param suggestionsLimit the maximum number of suggestions to be returned
 * @return an array of {@link android.view.textservice.SentenceSuggestionsInfo SentenceSuggestionsInfo} returned by
 * {@link android.service.textservice.SpellCheckerService.Session#onGetSuggestions(android.view.textservice.TextInfo,int) SpellCheckerService.Session#onGetSuggestions(TextInfo, int)}
 * @apiSince 16
 */

public android.view.textservice.SentenceSuggestionsInfo[] onGetSentenceSuggestionsMultiple(android.view.textservice.TextInfo[] textInfos, int suggestionsLimit) { throw new RuntimeException("Stub!"); }

/**
 * Request to abort all tasks executed in SpellChecker.
 * This function will run on the incoming IPC thread.
 * So, this is not called on the main thread,
 * but will be called in series on another thread.
 * @apiSince 14
 */

public void onCancel() { throw new RuntimeException("Stub!"); }

/**
 * Request to close this session.
 * This function will run on the incoming IPC thread.
 * So, this is not called on the main thread,
 * but will be called in series on another thread.
 * @apiSince 15
 */

public void onClose() { throw new RuntimeException("Stub!"); }

/**
 * @return Locale for this session
 * @apiSince 14
 */

public java.lang.String getLocale() { throw new RuntimeException("Stub!"); }

/**
 * @return Bundle for this session
 * @apiSince 14
 */

public android.os.Bundle getBundle() { throw new RuntimeException("Stub!"); }
}

}

