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


package android.speech;

import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ActivityNotFoundException;
import java.util.ArrayList;
import android.content.ComponentName;

/**
 * Constants for supporting speech recognition through starting an {@link android.content.Intent Intent}
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class RecognizerIntent {

private RecognizerIntent() { throw new RuntimeException("Stub!"); }

/**
 * Returns the broadcast intent to fire with
 * {@link android.content.Context#sendOrderedBroadcast(android.content.Intent,java.lang.String,android.content.BroadcastReceiver,android.os.Handler,int,java.lang.String,android.os.Bundle) Context#sendOrderedBroadcast(Intent, String, BroadcastReceiver, android.os.Handler, int, String, Bundle)}
 * to receive details from the package that implements voice search.
 * <p>
 * This is based on the value specified by the voice search {@link android.app.Activity Activity} in
 * {@link #DETAILS_META_DATA}, and if this is not specified, will return null. Also if there
 * is no chosen default to resolve for {@link #ACTION_WEB_SEARCH}, this will return null.
 * <p>
 * If an intent is returned and is fired, a {@link android.os.Bundle Bundle} of extras will be returned to the
 * provided result receiver, and should ideally contain values for
 * {@link #EXTRA_LANGUAGE_PREFERENCE} and {@link #EXTRA_SUPPORTED_LANGUAGES}.
 * <p>
 * (Whether these are actually provided is up to the particular implementation. It is
 * recommended that {@link android.app.Activity Activity}s implementing {@link #ACTION_WEB_SEARCH} provide this
 * information, but it is not required.)
 *
 * @param context a context object
 * @return the broadcast intent to fire or null if not available
 * @apiSince 8
 */

public static final android.content.Intent getVoiceDetailsIntent(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * A broadcast intent which can be fired to the {@link android.content.BroadcastReceiver BroadcastReceiver} component specified
 * in the meta-data defined in the {@link #DETAILS_META_DATA} meta-data of an
 * {@link android.app.Activity Activity} satisfying {@link #ACTION_WEB_SEARCH}.
 * <p>
 * When fired with
 * {@link android.content.Context#sendOrderedBroadcast(android.content.Intent,java.lang.String,android.content.BroadcastReceiver,android.os.Handler,int,java.lang.String,android.os.Bundle) Context#sendOrderedBroadcast(Intent, String, BroadcastReceiver, android.os.Handler, int, String, android.os.Bundle)},
 * a {@link android.os.Bundle Bundle} of extras will be returned to the provided result receiver, and should
 * ideally contain values for {@link #EXTRA_LANGUAGE_PREFERENCE} and
 * {@link #EXTRA_SUPPORTED_LANGUAGES}.
 * <p>
 * (Whether these are actually provided is up to the particular implementation. It is
 * recommended that {@link android.app.Activity Activity}s implementing {@link #ACTION_WEB_SEARCH} provide this
 * information, but it is not required.)
 * @apiSince 8
 */

public static final java.lang.String ACTION_GET_LANGUAGE_DETAILS = "android.speech.action.GET_LANGUAGE_DETAILS";

/**
 * Starts an activity that will prompt the user for speech and send it through a
 * speech recognizer.  The results will be returned via activity results (in
 * {@link android.app.Activity#onActivityResult Activity#onActivityResult}, if you start the intent using
 * {@link android.app.Activity#startActivityForResult(android.content.Intent,int) Activity#startActivityForResult(Intent, int)}), or forwarded via a PendingIntent
 * if one is provided.
 *
 * <p>Starting this intent with just {@link android.app.Activity#startActivity(android.content.Intent) Activity#startActivity(Intent)} is not supported.
 * You must either use {@link android.app.Activity#startActivityForResult(android.content.Intent,int) Activity#startActivityForResult(Intent, int)}, or provide a
 * PendingIntent, to receive recognition results.
 *
 * <p>The implementation of this API is likely to stream audio to remote servers to perform
 * speech recognition which can use a substantial amount of bandwidth.
 *
 * <p>Required extras:
 * <ul>
 *   <li>{@link #EXTRA_LANGUAGE_MODEL}
 * </ul>
 *
 * <p>Optional extras:
 * <ul>
 *   <li>{@link #EXTRA_PROMPT}
 *   <li>{@link #EXTRA_LANGUAGE}
 *   <li>{@link #EXTRA_MAX_RESULTS}
 *   <li>{@link #EXTRA_RESULTS_PENDINGINTENT}
 *   <li>{@link #EXTRA_RESULTS_PENDINGINTENT_BUNDLE}
 * </ul>
 *
 * <p> Result extras (returned in the result, not to be specified in the request):
 * <ul>
 *   <li>{@link #EXTRA_RESULTS}
 * </ul>
 *
 * <p>NOTE: There may not be any applications installed to handle this action, so you should
 * make sure to catch {@link android.content.ActivityNotFoundException ActivityNotFoundException}.
 * @apiSince 3
 */

public static final java.lang.String ACTION_RECOGNIZE_SPEECH = "android.speech.action.RECOGNIZE_SPEECH";

/**
 * Starts an activity that will prompt the user for speech without requiring the user's
 * visual attention or touch input. It will send it through a speech recognizer,
 * and either synthesize speech for a web search result or trigger
 * another type of action based on the user's speech.
 *
 * This activity may be launched while device is locked in a secure mode.
 * Special care must be taken to ensure that the voice actions that are performed while
 * hands free cannot compromise the device's security.
 * The activity should check the value of the {@link #EXTRA_SECURE} extra to determine
 * whether the device has been securely locked. If so, the activity should either restrict
 * the set of voice actions that are permitted or require some form of secure
 * authentication before proceeding.
 *
 * To ensure that the activity's user interface is visible while the lock screen is showing,
 * the activity should set the
 * {@link android.view.WindowManager.LayoutParams#FLAG_SHOW_WHEN_LOCKED} window flag.
 * Otherwise the activity's user interface may be hidden by the lock screen. The activity
 * should take care not to leak private information when the device is securely locked.
 *
 * <p>Optional extras:
 * <ul>
 *   <li>{@link #EXTRA_SECURE}
 * </ul>
 *
 * <p class="note">
 * In some cases, a matching Activity may not exist, so ensure you
 * safeguard against this.
 * @apiSince 16
 */

public static final java.lang.String ACTION_VOICE_SEARCH_HANDS_FREE = "android.speech.action.VOICE_SEARCH_HANDS_FREE";

/**
 * Starts an activity that will prompt the user for speech, send it through a
 * speech recognizer, and either display a web search result or trigger
 * another type of action based on the user's speech.
 *
 * <p>If you want to avoid triggering any type of action besides web search, you can use
 * the {@link #EXTRA_WEB_SEARCH_ONLY} extra.
 *
 * <p>Required extras:
 * <ul>
 *   <li>{@link #EXTRA_LANGUAGE_MODEL}
 * </ul>
 *
 * <p>Optional extras:
 * <ul>
 *   <li>{@link #EXTRA_PROMPT}
 *   <li>{@link #EXTRA_LANGUAGE}
 *   <li>{@link #EXTRA_MAX_RESULTS}
 *   <li>{@link #EXTRA_PARTIAL_RESULTS}
 *   <li>{@link #EXTRA_WEB_SEARCH_ONLY}
 *   <li>{@link #EXTRA_ORIGIN}
 * </ul>
 *
 * <p> Result extras (returned in the result, not to be specified in the request):
 * <ul>
 *   <li>{@link #EXTRA_RESULTS}
 *   <li>{@link #EXTRA_CONFIDENCE_SCORES} (optional)
 * </ul>
 *
 * <p>NOTE: There may not be any applications installed to handle this action, so you should
 * make sure to catch {@link android.content.ActivityNotFoundException ActivityNotFoundException}.
 * @apiSince 3
 */

public static final java.lang.String ACTION_WEB_SEARCH = "android.speech.action.WEB_SEARCH";

/**
 * Meta-data name under which an {@link android.app.Activity Activity} implementing {@link #ACTION_WEB_SEARCH} can
 * use to expose the class name of a {@link android.content.BroadcastReceiver BroadcastReceiver} which can respond to request for
 * more information, from any of the broadcast intents specified in this class.
 * <p>
 * Broadcast intents can be directed to the class name specified in the meta-data by creating
 * an {@link android.content.Intent Intent}, setting the component with
 * {@link android.content.Intent#setComponent(android.content.ComponentName) Intent#setComponent(android.content.ComponentName)}, and using
 * {@link android.content.Context#sendOrderedBroadcast(android.content.Intent,java.lang.String,android.content.BroadcastReceiver,android.os.Handler,int,java.lang.String,android.os.Bundle) Context#sendOrderedBroadcast(Intent, String, BroadcastReceiver, android.os.Handler, int, String, android.os.Bundle)}
 * with another {@link android.content.BroadcastReceiver BroadcastReceiver} which can receive the results.
 * <p>
 * The {@link #getVoiceDetailsIntent(android.content.Context)} method is provided as a convenience to create
 * a broadcast intent based on the value of this meta-data, if available.
 * <p>
 * This is optional and not all {@link android.app.Activity Activity}s which implement {@link #ACTION_WEB_SEARCH}
 * are required to implement this. Thus retrieving this meta-data may be null.
 * @apiSince 8
 */

public static final java.lang.String DETAILS_META_DATA = "android.speech.DETAILS";

/**
 * The extra key used in an intent to the speech recognizer for voice search. Not
 * generally to be used by developers. The system search dialog uses this, for example,
 * to set a calling package for identification by a voice search API. If this extra
 * is set by anyone but the system process, it should be overridden by the voice search
 * implementation.
 * @apiSince 8
 */

public static final java.lang.String EXTRA_CALLING_PACKAGE = "calling_package";

/**
 * A float array of confidence scores of the recognition results when performing
 * {@link #ACTION_RECOGNIZE_SPEECH}. The array should be the same size as the ArrayList
 * returned in {@link #EXTRA_RESULTS}, and should contain values ranging from 0.0 to 1.0,
 * or -1 to represent an unavailable confidence score.
 * <p>
 * Confidence values close to 1.0 indicate high confidence (the speech recognizer is
 * confident that the recognition result is correct), while values close to 0.0 indicate
 * low confidence.
 * <p>
 * Returned in the results; not to be specified in the recognition request. This extra is
 * optional and might not be provided. Only present when {@link android.app.Activity#RESULT_OK Activity#RESULT_OK} is
 * returned in an activity result.
 * @apiSince 14
 */

public static final java.lang.String EXTRA_CONFIDENCE_SCORES = "android.speech.extra.CONFIDENCE_SCORES";

/**
 * Optional IETF language tag (as defined by BCP 47), for example "en-US". This tag informs the
 * recognizer to perform speech recognition in a language different than the one set in the
 * {@link java.util.Locale#getDefault()}.
 * @apiSince 3
 */

public static final java.lang.String EXTRA_LANGUAGE = "android.speech.extra.LANGUAGE";

/**
 * Informs the recognizer which speech model to prefer when performing
 * {@link #ACTION_RECOGNIZE_SPEECH}. The recognizer uses this
 * information to fine tune the results. This extra is required. Activities implementing
 * {@link #ACTION_RECOGNIZE_SPEECH} may interpret the values as they see fit.
 *
 *  @see #LANGUAGE_MODEL_FREE_FORM
 *  @see #LANGUAGE_MODEL_WEB_SEARCH
 * @apiSince 3
 */

public static final java.lang.String EXTRA_LANGUAGE_MODEL = "android.speech.extra.LANGUAGE_MODEL";

/**
 * The key to the extra in the {@link android.os.Bundle Bundle} returned by {@link #ACTION_GET_LANGUAGE_DETAILS}
 * which is a {@link java.lang.String String} that represents the current language preference this user has
 * specified - a locale string like "en-US".
 * @apiSince 8
 */

public static final java.lang.String EXTRA_LANGUAGE_PREFERENCE = "android.speech.extra.LANGUAGE_PREFERENCE";

/** 
 * Optional limit on the maximum number of results to return. If omitted the recognizer
 * will choose how many results to return. Must be an integer.
 * @apiSince 3
 */

public static final java.lang.String EXTRA_MAX_RESULTS = "android.speech.extra.MAX_RESULTS";

/**
 * Specify this boolean extra in a broadcast of {@link #ACTION_GET_LANGUAGE_DETAILS} to
 * indicate that only the current language preference is needed in the response. This
 * avoids any additional computation if all you need is {@link #EXTRA_LANGUAGE_PREFERENCE}
 * in the response.
 * @apiSince 8
 */

public static final java.lang.String EXTRA_ONLY_RETURN_LANGUAGE_PREFERENCE = "android.speech.extra.ONLY_RETURN_LANGUAGE_PREFERENCE";

/**
 * Optional value which can be used to indicate the referer url of a page in which
 * speech was requested. For example, a web browser may choose to provide this for
 * uses of speech on a given page.
 * @apiSince 14
 */

public static final java.lang.String EXTRA_ORIGIN = "android.speech.extra.ORIGIN";

/**
 * Optional boolean to indicate whether partial results should be returned by the recognizer
 * as the user speaks (default is false).  The server may ignore a request for partial
 * results in some or all cases.
 * @apiSince 8
 */

public static final java.lang.String EXTRA_PARTIAL_RESULTS = "android.speech.extra.PARTIAL_RESULTS";

/**
 * Optional boolean, to be used with {@link #ACTION_RECOGNIZE_SPEECH},
 * {@link #ACTION_VOICE_SEARCH_HANDS_FREE}, {@link #ACTION_WEB_SEARCH} to indicate whether to
 * only use an offline speech recognition engine. The default is false, meaning that either
 * network or offline recognition engines may be used.
 * @apiSince 23
 */

public static final java.lang.String EXTRA_PREFER_OFFLINE = "android.speech.extra.PREFER_OFFLINE";

/**
 * Optional text prompt to show to the user when asking them to speak.
 * @apiSince 3
 */

public static final java.lang.String EXTRA_PROMPT = "android.speech.extra.PROMPT";

/**
 * An ArrayList&lt;String&gt; of the recognition results when performing
 * {@link #ACTION_RECOGNIZE_SPEECH}. Generally this list should be ordered in
 * descending order of speech recognizer confidence. (See {@link #EXTRA_CONFIDENCE_SCORES}).
 * Returned in the results; not to be specified in the recognition request. Only present
 * when {@link android.app.Activity#RESULT_OK Activity#RESULT_OK} is returned in an activity result. In a PendingIntent,
 * the lack of this extra indicates failure.
 * @apiSince 3
 */

public static final java.lang.String EXTRA_RESULTS = "android.speech.extra.RESULTS";

/**
 * When the intent is {@link #ACTION_RECOGNIZE_SPEECH}, the speech input activity will
 * return results to you via the activity results mechanism.  Alternatively, if you use this
 * extra to supply a PendingIntent, the results will be added to its bundle and the
 * PendingIntent will be sent to its target.
 * @apiSince 3
 */

public static final java.lang.String EXTRA_RESULTS_PENDINGINTENT = "android.speech.extra.RESULTS_PENDINGINTENT";

/**
 * If you use {@link #EXTRA_RESULTS_PENDINGINTENT} to supply a forwarding intent, you can
 * also use this extra to supply additional extras for the final intent.  The search results
 * will be added to this bundle, and the combined bundle will be sent to the target.
 * @apiSince 3
 */

public static final java.lang.String EXTRA_RESULTS_PENDINGINTENT_BUNDLE = "android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE";

/**
 * Optional boolean to indicate that a "hands free" voice search was performed while the device
 * was in a secure mode. An example of secure mode is when the device's screen lock is active,
 * and it requires some form of authentication to be unlocked.
 *
 * When the device is securely locked, the voice search activity should either restrict
 * the set of voice actions that are permitted, or require some form of secure authentication
 * before proceeding.
 * @apiSince 16
 */

public static final java.lang.String EXTRA_SECURE = "android.speech.extras.EXTRA_SECURE";

/**
 * The amount of time that it should take after we stop hearing speech to consider the input
 * complete.
 *
 * Note that it is extremely rare you'd want to specify this value in an intent. If
 * you don't have a very good reason to change these, you should leave them as they are. Note
 * also that certain values may cause undesired or unexpected results - use judiciously!
 * Additionally, depending on the recognizer implementation, these values may have no effect.
 * @apiSince 8
 */

public static final java.lang.String EXTRA_SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS = "android.speech.extras.SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS";

/**
 * The minimum length of an utterance. We will not stop recording before this amount of time.
 *
 * Note that it is extremely rare you'd want to specify this value in an intent. If you don't
 * have a very good reason to change these, you should leave them as they are. Note also that
 * certain values may cause undesired or unexpected results - use judiciously! Additionally,
 * depending on the recognizer implementation, these values may have no effect.
 * @apiSince 8
 */

public static final java.lang.String EXTRA_SPEECH_INPUT_MINIMUM_LENGTH_MILLIS = "android.speech.extras.SPEECH_INPUT_MINIMUM_LENGTH_MILLIS";

/**
 * The amount of time that it should take after we stop hearing speech to consider the input
 * possibly complete. This is used to prevent the endpointer cutting off during very short
 * mid-speech pauses.
 *
 * Note that it is extremely rare you'd want to specify this value in an intent. If
 * you don't have a very good reason to change these, you should leave them as they are. Note
 * also that certain values may cause undesired or unexpected results - use judiciously!
 * Additionally, depending on the recognizer implementation, these values may have no effect.
 * @apiSince 8
 */

public static final java.lang.String EXTRA_SPEECH_INPUT_POSSIBLY_COMPLETE_SILENCE_LENGTH_MILLIS = "android.speech.extras.SPEECH_INPUT_POSSIBLY_COMPLETE_SILENCE_LENGTH_MILLIS";

/**
 * The key to the extra in the {@link android.os.Bundle Bundle} returned by {@link #ACTION_GET_LANGUAGE_DETAILS}
 * which is an {@link java.util.ArrayList ArrayList} of {@link java.lang.String String}s that represents the languages supported by
 * this implementation of voice recognition - a list of strings like "en-US", "cmn-Hans-CN",
 * etc.
 * @apiSince 8
 */

public static final java.lang.String EXTRA_SUPPORTED_LANGUAGES = "android.speech.extra.SUPPORTED_LANGUAGES";

/**
 * Optional boolean, to be used with {@link #ACTION_WEB_SEARCH}, to indicate whether to
 * only fire web searches in response to a user's speech. The default is false, meaning
 * that other types of actions can be taken based on the user's speech.
 * @apiSince 11
 */

public static final java.lang.String EXTRA_WEB_SEARCH_ONLY = "android.speech.extra.WEB_SEARCH_ONLY";

/** 
 * Use a language model based on free-form speech recognition.  This is a value to use for
 * {@link #EXTRA_LANGUAGE_MODEL}.
 * @see #EXTRA_LANGUAGE_MODEL
 * @apiSince 3
 */

public static final java.lang.String LANGUAGE_MODEL_FREE_FORM = "free_form";

/** 
 * Use a language model based on web search terms.  This is a value to use for
 * {@link #EXTRA_LANGUAGE_MODEL}.
 * @see #EXTRA_LANGUAGE_MODEL
 * @apiSince 3
 */

public static final java.lang.String LANGUAGE_MODEL_WEB_SEARCH = "web_search";

/**
 * Result code returned when an audio error was encountered
 * @apiSince 3
 */

public static final int RESULT_AUDIO_ERROR = 5; // 0x5

/**
 * Result code returned when there is a generic client error
 * @apiSince 3
 */

public static final int RESULT_CLIENT_ERROR = 2; // 0x2

/**
 * Result code returned when a network error was encountered
 * @apiSince 3
 */

public static final int RESULT_NETWORK_ERROR = 4; // 0x4

/**
 * Result code returned when no matches are found for the given speech
 * @apiSince 3
 */

public static final int RESULT_NO_MATCH = 1; // 0x1

/**
 * Result code returned when the recognition server returns an error
 * @apiSince 3
 */

public static final int RESULT_SERVER_ERROR = 3; // 0x3
}

