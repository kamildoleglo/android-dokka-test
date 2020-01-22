/*
 * Copyright (C) 2009 The Android Open Source Project
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

package android.speech.tts;

import android.os.Bundle;
import java.io.File;
import java.util.HashMap;
import java.util.Set;
import android.media.AudioAttributes;
import java.util.Locale;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;

/**
 *
 * Synthesizes speech from text for immediate playback or to create a sound file.
 * <p>A TextToSpeech instance can only be used to synthesize text once it has completed its
 * initialization. Implement the {@link android.speech.tts.TextToSpeech.OnInitListener TextToSpeech.OnInitListener} to be
 * notified of the completion of the initialization.<br>
 * When you are done using the TextToSpeech instance, call the {@link #shutdown()} method
 * to release the native resources used by the TextToSpeech engine.
 @apiSince 4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TextToSpeech {

/**
 * The constructor for the TextToSpeech class, using the default TTS engine.
 * This will also initialize the associated TextToSpeech engine if it isn't already running.
 *
 * @param context
 *            The context this instance is running in.
 * @param listener
 *            The {@link android.speech.tts.TextToSpeech.OnInitListener TextToSpeech.OnInitListener} that will be called when the
 *            TextToSpeech engine has initialized. In a case of a failure the listener
 *            may be called immediately, before TextToSpeech instance is fully constructed.
 * @apiSince 4
 */

public TextToSpeech(android.content.Context context, android.speech.tts.TextToSpeech.OnInitListener listener) { throw new RuntimeException("Stub!"); }

/**
 * The constructor for the TextToSpeech class, using the given TTS engine.
 * This will also initialize the associated TextToSpeech engine if it isn't already running.
 *
 * @param context
 *            The context this instance is running in.
 * @param listener
 *            The {@link android.speech.tts.TextToSpeech.OnInitListener TextToSpeech.OnInitListener} that will be called when the
 *            TextToSpeech engine has initialized. In a case of a failure the listener
 *            may be called immediately, before TextToSpeech instance is fully constructed.
 * @param engine Package name of the TTS engine to use.
 * @apiSince 14
 */

public TextToSpeech(android.content.Context context, android.speech.tts.TextToSpeech.OnInitListener listener, java.lang.String engine) { throw new RuntimeException("Stub!"); }

/**
 * Releases the resources used by the TextToSpeech engine.
 * It is good practice for instance to call this method in the onDestroy() method of an Activity
 * so the TextToSpeech engine can be cleanly stopped.
 * @apiSince 4
 */

public void shutdown() { throw new RuntimeException("Stub!"); }

/**
 * Adds a mapping between a string of text and a sound resource in a
 * package. After a call to this method, subsequent calls to
 * {@link #speak(java.lang.CharSequence,int,android.os.Bundle,java.lang.String)} will play the specified sound resource
 * if it is available, or synthesize the text it is missing.
 *
 * @param text
 *            The string of text. Example: <code>"south_south_east"</code>
 *
 * @param packagename
 *            Pass the packagename of the application that contains the
 *            resource. If the resource is in your own application (this is
 *            the most common case), then put the packagename of your
 *            application here.<br/>
 *            Example: <b>"com.google.marvin.compass"</b><br/>
 *            The packagename can be found in the AndroidManifest.xml of
 *            your application.
 *            <p>
 *            <code>&lt;manifest xmlns:android=&quot;...&quot;
 *      package=&quot;<b>com.google.marvin.compass</b>&quot;&gt;</code>
 *            </p>
 *
 * @param resourceId
 *            Example: <code>R.raw.south_south_east</code>
 *
 * @return Code indicating success or failure. See {@link #ERROR} and {@link #SUCCESS}.
 * @apiSince 4
 */

public int addSpeech(java.lang.String text, java.lang.String packagename, int resourceId) { throw new RuntimeException("Stub!"); }

/**
 * Adds a mapping between a CharSequence (may be spanned with TtsSpans) of text
 * and a sound resource in a package. After a call to this method, subsequent calls to
 * {@link #speak(java.lang.CharSequence,int,android.os.Bundle,java.lang.String)} will play the specified sound resource
 * if it is available, or synthesize the text it is missing.
 *
 * @param text
 *            The string of text. Example: <code>"south_south_east"</code>
 *
 * @param packagename
 *            Pass the packagename of the application that contains the
 *            resource. If the resource is in your own application (this is
 *            the most common case), then put the packagename of your
 *            application here.<br/>
 *            Example: <b>"com.google.marvin.compass"</b><br/>
 *            The packagename can be found in the AndroidManifest.xml of
 *            your application.
 *            <p>
 *            <code>&lt;manifest xmlns:android=&quot;...&quot;
 *      package=&quot;<b>com.google.marvin.compass</b>&quot;&gt;</code>
 *            </p>
 *
 * @param resourceId
 *            Example: <code>R.raw.south_south_east</code>
 *
 * @return Code indicating success or failure. See {@link #ERROR} and {@link #SUCCESS}.
 * @apiSince 21
 */

public int addSpeech(java.lang.CharSequence text, java.lang.String packagename, int resourceId) { throw new RuntimeException("Stub!"); }

/**
 * Adds a mapping between a string of text and a sound file. Using this, it is possible to
 * add custom pronounciations for a string of text. After a call to this method, subsequent
 * calls to {@link #speak(java.lang.CharSequence,int,android.os.Bundle,java.lang.String)} will play the specified sound
 * resource if it is available, or synthesize the text it is missing.
 *
 * @param text
 *            The string of text. Example: <code>"south_south_east"</code>
 * @param filename
 *            The full path to the sound file (for example:
 *            "/sdcard/mysounds/hello.wav")
 *
 * @return Code indicating success or failure. See {@link #ERROR} and {@link #SUCCESS}.
 * @apiSince 4
 */

public int addSpeech(java.lang.String text, java.lang.String filename) { throw new RuntimeException("Stub!"); }

/**
 * Adds a mapping between a CharSequence (may be spanned with TtsSpans and a sound file.
 * Using this, it is possible to add custom pronounciations for a string of text. After a call
 * to this method, subsequent calls to {@link #speak(java.lang.CharSequence,int,android.os.Bundle,java.lang.String)}
 * will play the specified sound resource if it is available, or synthesize the text it is
 * missing.
 *
 * @param text
 *            The string of text. Example: <code>"south_south_east"</code>
 * @param file
 *            File object pointing to the sound file.
 *
 * @return Code indicating success or failure. See {@link #ERROR} and {@link #SUCCESS}.
 * @apiSince 21
 */

public int addSpeech(java.lang.CharSequence text, java.io.File file) { throw new RuntimeException("Stub!"); }

/**
 * Adds a mapping between a string of text and a sound resource in a
 * package. Use this to add custom earcons.
 *
 * @see #playEarcon(String, int, HashMap)
 *
 * @param earcon The name of the earcon.
 *            Example: <code>"[tick]"</code><br/>
 *
 * @param packagename
 *            the package name of the application that contains the
 *            resource. This can for instance be the package name of your own application.
 *            Example: <b>"com.google.marvin.compass"</b><br/>
 *            The package name can be found in the AndroidManifest.xml of
 *            the application containing the resource.
 *            <p>
 *            <code>&lt;manifest xmlns:android=&quot;...&quot;
 *      package=&quot;<b>com.google.marvin.compass</b>&quot;&gt;</code>
 *            </p>
 *
 * @param resourceId
 *            Example: <code>R.raw.tick_snd</code>
 *
 * @return Code indicating success or failure. See {@link #ERROR} and {@link #SUCCESS}.
 * @apiSince 4
 */

public int addEarcon(java.lang.String earcon, java.lang.String packagename, int resourceId) { throw new RuntimeException("Stub!"); }

/**
 * Adds a mapping between a string of text and a sound file.
 * Use this to add custom earcons.
 *
 * @see #playEarcon(String, int, HashMap)
 *
 * @param earcon
 *            The name of the earcon.
 *            Example: <code>"[tick]"</code>
 * @param filename
 *            The full path to the sound file (for example:
 *            "/sdcard/mysounds/tick.wav")
 *
 * @return Code indicating success or failure. See {@link #ERROR} and {@link #SUCCESS}.
 *
 * @deprecated As of API level 21, replaced by
 *         {@link #addEarcon(java.lang.String,java.io.File)}.
 * @apiSince 4
 * @deprecatedSince 21
 */

@Deprecated
public int addEarcon(java.lang.String earcon, java.lang.String filename) { throw new RuntimeException("Stub!"); }

/**
 * Adds a mapping between a string of text and a sound file.
 * Use this to add custom earcons.
 *
 * @see #playEarcon(String, int, HashMap)
 *
 * @param earcon
 *            The name of the earcon.
 *            Example: <code>"[tick]"</code>
 * @param file
 *            File object pointing to the sound file.
 *
 * @return Code indicating success or failure. See {@link #ERROR} and {@link #SUCCESS}.
 * @apiSince 21
 */

public int addEarcon(java.lang.String earcon, java.io.File file) { throw new RuntimeException("Stub!"); }

/**
 * Speaks the text using the specified queuing strategy and speech parameters, the text may
 * be spanned with TtsSpans.
 * This method is asynchronous, i.e. the method just adds the request to the queue of TTS
 * requests and then returns. The synthesis might not have finished (or even started!) at the
 * time when this method returns. In order to reliably detect errors during synthesis,
 * we recommend setting an utterance progress listener (see
 * {@link #setOnUtteranceProgressListener}) and using the
 * {@link android.speech.tts.TextToSpeech.Engine#KEY_PARAM_UTTERANCE_ID Engine#KEY_PARAM_UTTERANCE_ID} parameter.
 *
 * @param text The string of text to be spoken. No longer than
 *            {@link #getMaxSpeechInputLength()} characters.
 * @param queueMode The queuing strategy to use, {@link #QUEUE_ADD} or {@link #QUEUE_FLUSH}.
 * @param params Parameters for the request. Can be null.
 *            Supported parameter names:
 *            {@link android.speech.tts.TextToSpeech.Engine#KEY_PARAM_STREAM Engine#KEY_PARAM_STREAM},
 *            {@link android.speech.tts.TextToSpeech.Engine#KEY_PARAM_VOLUME Engine#KEY_PARAM_VOLUME},
 *            {@link android.speech.tts.TextToSpeech.Engine#KEY_PARAM_PAN Engine#KEY_PARAM_PAN}.
 *            Engine specific parameters may be passed in but the parameter keys
 *            must be prefixed by the name of the engine they are intended for. For example
 *            the keys "com.svox.pico_foo" and "com.svox.pico:bar" will be passed to the
 *            engine named "com.svox.pico" if it is being used.
 * @param utteranceId An unique identifier for this request.
 *
 * @return {@link #ERROR} or {@link #SUCCESS} of <b>queuing</b> the speak operation.
 * @apiSince 21
 */

public int speak(java.lang.CharSequence text, int queueMode, android.os.Bundle params, java.lang.String utteranceId) { throw new RuntimeException("Stub!"); }

/**
 * Speaks the string using the specified queuing strategy and speech parameters.
 * This method is asynchronous, i.e. the method just adds the request to the queue of TTS
 * requests and then returns. The synthesis might not have finished (or even started!) at the
 * time when this method returns. In order to reliably detect errors during synthesis,
 * we recommend setting an utterance progress listener (see
 * {@link #setOnUtteranceProgressListener}) and using the
 * {@link android.speech.tts.TextToSpeech.Engine#KEY_PARAM_UTTERANCE_ID Engine#KEY_PARAM_UTTERANCE_ID} parameter.
 *
 * @param text The string of text to be spoken. No longer than
 *            {@link #getMaxSpeechInputLength()} characters.
 * @param queueMode The queuing strategy to use, {@link #QUEUE_ADD} or {@link #QUEUE_FLUSH}.
 * @param params Parameters for the request. Can be null.
 *            Supported parameter names:
 *            {@link android.speech.tts.TextToSpeech.Engine#KEY_PARAM_STREAM Engine#KEY_PARAM_STREAM},
 *            {@link android.speech.tts.TextToSpeech.Engine#KEY_PARAM_UTTERANCE_ID Engine#KEY_PARAM_UTTERANCE_ID},
 *            {@link android.speech.tts.TextToSpeech.Engine#KEY_PARAM_VOLUME Engine#KEY_PARAM_VOLUME},
 *            {@link android.speech.tts.TextToSpeech.Engine#KEY_PARAM_PAN Engine#KEY_PARAM_PAN}.
 *            Engine specific parameters may be passed in but the parameter keys
 *            must be prefixed by the name of the engine they are intended for. For example
 *            the keys "com.svox.pico_foo" and "com.svox.pico:bar" will be passed to the
 *            engine named "com.svox.pico" if it is being used.
 *
 * @return {@link #ERROR} or {@link #SUCCESS} of <b>queuing</b> the speak operation.
 * @deprecated As of API level 21, replaced by
 *         {@link #speak(java.lang.CharSequence,int,android.os.Bundle,java.lang.String)}.
 * @apiSince 4
 * @deprecatedSince 21
 */

@Deprecated
public int speak(java.lang.String text, int queueMode, java.util.HashMap<java.lang.String,java.lang.String> params) { throw new RuntimeException("Stub!"); }

/**
 * Plays the earcon using the specified queueing mode and parameters.
 * The earcon must already have been added with {@link #addEarcon(java.lang.String,java.lang.String)} or
 * {@link #addEarcon(java.lang.String,java.lang.String,int)}.
 * This method is asynchronous, i.e. the method just adds the request to the queue of TTS
 * requests and then returns. The synthesis might not have finished (or even started!) at the
 * time when this method returns. In order to reliably detect errors during synthesis,
 * we recommend setting an utterance progress listener (see
 * {@link #setOnUtteranceProgressListener}) and using the
 * {@link android.speech.tts.TextToSpeech.Engine#KEY_PARAM_UTTERANCE_ID Engine#KEY_PARAM_UTTERANCE_ID} parameter.
 *
 * @param earcon The earcon that should be played
 * @param queueMode {@link #QUEUE_ADD} or {@link #QUEUE_FLUSH}.
 * @param params Parameters for the request. Can be null.
 *            Supported parameter names:
 *            {@link android.speech.tts.TextToSpeech.Engine#KEY_PARAM_STREAM Engine#KEY_PARAM_STREAM},
 *            Engine specific parameters may be passed in but the parameter keys
 *            must be prefixed by the name of the engine they are intended for. For example
 *            the keys "com.svox.pico_foo" and "com.svox.pico:bar" will be passed to the
 *            engine named "com.svox.pico" if it is being used.
 *
 * @return {@link #ERROR} or {@link #SUCCESS} of <b>queuing</b> the playEarcon operation.
 * @apiSince 21
 */

public int playEarcon(java.lang.String earcon, int queueMode, android.os.Bundle params, java.lang.String utteranceId) { throw new RuntimeException("Stub!"); }

/**
 * Plays the earcon using the specified queueing mode and parameters.
 * The earcon must already have been added with {@link #addEarcon(java.lang.String,java.lang.String)} or
 * {@link #addEarcon(java.lang.String,java.lang.String,int)}.
 * This method is asynchronous, i.e. the method just adds the request to the queue of TTS
 * requests and then returns. The synthesis might not have finished (or even started!) at the
 * time when this method returns. In order to reliably detect errors during synthesis,
 * we recommend setting an utterance progress listener (see
 * {@link #setOnUtteranceProgressListener}) and using the
 * {@link android.speech.tts.TextToSpeech.Engine#KEY_PARAM_UTTERANCE_ID Engine#KEY_PARAM_UTTERANCE_ID} parameter.
 *
 * @param earcon The earcon that should be played
 * @param queueMode {@link #QUEUE_ADD} or {@link #QUEUE_FLUSH}.
 * @param params Parameters for the request. Can be null.
 *            Supported parameter names:
 *            {@link android.speech.tts.TextToSpeech.Engine#KEY_PARAM_STREAM Engine#KEY_PARAM_STREAM},
 *            {@link android.speech.tts.TextToSpeech.Engine#KEY_PARAM_UTTERANCE_ID Engine#KEY_PARAM_UTTERANCE_ID}.
 *            Engine specific parameters may be passed in but the parameter keys
 *            must be prefixed by the name of the engine they are intended for. For example
 *            the keys "com.svox.pico_foo" and "com.svox.pico:bar" will be passed to the
 *            engine named "com.svox.pico" if it is being used.
 *
 * @return {@link #ERROR} or {@link #SUCCESS} of <b>queuing</b> the playEarcon operation.
 * @deprecated As of API level 21, replaced by
 *         {@link #playEarcon(java.lang.String,int,android.os.Bundle,java.lang.String)}.
 * @apiSince 4
 * @deprecatedSince 21
 */

@Deprecated
public int playEarcon(java.lang.String earcon, int queueMode, java.util.HashMap<java.lang.String,java.lang.String> params) { throw new RuntimeException("Stub!"); }

/**
 * Plays silence for the specified amount of time using the specified
 * queue mode.
 * This method is asynchronous, i.e. the method just adds the request to the queue of TTS
 * requests and then returns. The synthesis might not have finished (or even started!) at the
 * time when this method returns. In order to reliably detect errors during synthesis,
 * we recommend setting an utterance progress listener (see
 * {@link #setOnUtteranceProgressListener}) and using the
 * {@link android.speech.tts.TextToSpeech.Engine#KEY_PARAM_UTTERANCE_ID Engine#KEY_PARAM_UTTERANCE_ID} parameter.
 *
 * @param durationInMs The duration of the silence.
 * @param queueMode {@link #QUEUE_ADD} or {@link #QUEUE_FLUSH}.
 * @param utteranceId An unique identifier for this request.
 *
 * @return {@link #ERROR} or {@link #SUCCESS} of <b>queuing</b> the playSilentUtterance operation.
 * @apiSince 21
 */

public int playSilentUtterance(long durationInMs, int queueMode, java.lang.String utteranceId) { throw new RuntimeException("Stub!"); }

/**
 * Plays silence for the specified amount of time using the specified
 * queue mode.
 * This method is asynchronous, i.e. the method just adds the request to the queue of TTS
 * requests and then returns. The synthesis might not have finished (or even started!) at the
 * time when this method returns. In order to reliably detect errors during synthesis,
 * we recommend setting an utterance progress listener (see
 * {@link #setOnUtteranceProgressListener}) and using the
 * {@link android.speech.tts.TextToSpeech.Engine#KEY_PARAM_UTTERANCE_ID Engine#KEY_PARAM_UTTERANCE_ID} parameter.
 *
 * @param durationInMs The duration of the silence.
 * @param queueMode {@link #QUEUE_ADD} or {@link #QUEUE_FLUSH}.
 * @param params Parameters for the request. Can be null.
 *            Supported parameter names:
 *            {@link android.speech.tts.TextToSpeech.Engine#KEY_PARAM_UTTERANCE_ID Engine#KEY_PARAM_UTTERANCE_ID}.
 *            Engine specific parameters may be passed in but the parameter keys
 *            must be prefixed by the name of the engine they are intended for. For example
 *            the keys "com.svox.pico_foo" and "com.svox.pico:bar" will be passed to the
 *            engine named "com.svox.pico" if it is being used.
 *
 * @return {@link #ERROR} or {@link #SUCCESS} of <b>queuing</b> the playSilence operation.
 * @deprecated As of API level 21, replaced by
 *         {@link #playSilentUtterance(long,int,java.lang.String)}.
 * @apiSince 4
 * @deprecatedSince 21
 */

@Deprecated
public int playSilence(long durationInMs, int queueMode, java.util.HashMap<java.lang.String,java.lang.String> params) { throw new RuntimeException("Stub!"); }

/**
 * Queries the engine for the set of features it supports for a given locale.
 * Features can either be framework defined, e.g.
 * {@link android.speech.tts.TextToSpeech.Engine#KEY_FEATURE_NETWORK_SYNTHESIS TextToSpeech.Engine#KEY_FEATURE_NETWORK_SYNTHESIS} or engine specific.
 * Engine specific keys must be prefixed by the name of the engine they
 * are intended for. These keys can be used as parameters to
 * {@link android.speech.tts.TextToSpeech#speak(java.lang.String,int,java.util.HashMap) TextToSpeech#speak(String, int, java.util.HashMap)} and
 * {@link android.speech.tts.TextToSpeech#synthesizeToFile(java.lang.String,java.util.HashMap,java.lang.String) TextToSpeech#synthesizeToFile(String, java.util.HashMap, String)}.
 *
 * Features values are strings and their values must meet restrictions described in their
 * documentation.
 *
 * @param locale The locale to query features for.
 * @return Set instance. May return {@code null} on error.
 * @deprecated As of API level 21, please use voices. In order to query features of the voice,
 * call {@link #getVoices()} to retrieve the list of available voices and
 * {@link android.speech.tts.Voice#getFeatures() Voice#getFeatures()} to retrieve the set of features.
 * @apiSince 15
 * @deprecatedSince 21
 */

@Deprecated
public java.util.Set<java.lang.String> getFeatures(java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Checks whether the TTS engine is busy speaking. Note that a speech item is
 * considered complete once it's audio data has been sent to the audio mixer, or
 * written to a file. There might be a finite lag between this point, and when
 * the audio hardware completes playback.
 *
 * @return {@code true} if the TTS engine is speaking.
 * @apiSince 4
 */

public boolean isSpeaking() { throw new RuntimeException("Stub!"); }

/**
 * Interrupts the current utterance (whether played or rendered to file) and discards other
 * utterances in the queue.
 *
 * @return {@link #ERROR} or {@link #SUCCESS}.
 * @apiSince 4
 */

public int stop() { throw new RuntimeException("Stub!"); }

/**
 * Sets the speech rate.
 *
 * This has no effect on any pre-recorded speech.
 *
 * @param speechRate Speech rate. {@code 1.0} is the normal speech rate,
 *            lower values slow down the speech ({@code 0.5} is half the normal speech rate),
 *            greater values accelerate it ({@code 2.0} is twice the normal speech rate).
 *
 * @return {@link #ERROR} or {@link #SUCCESS}.
 * @apiSince 4
 */

public int setSpeechRate(float speechRate) { throw new RuntimeException("Stub!"); }

/**
 * Sets the speech pitch for the TextToSpeech engine.
 *
 * This has no effect on any pre-recorded speech.
 *
 * @param pitch Speech pitch. {@code 1.0} is the normal pitch,
 *            lower values lower the tone of the synthesized voice,
 *            greater values increase it.
 *
 * @return {@link #ERROR} or {@link #SUCCESS}.
 * @apiSince 4
 */

public int setPitch(float pitch) { throw new RuntimeException("Stub!"); }

/**
 * Sets the audio attributes to be used when speaking text or playing
 * back a file.
 *
 * @param audioAttributes Valid AudioAttributes instance.
 *
 * @return {@link #ERROR} or {@link #SUCCESS}.
 * @apiSince 21
 */

public int setAudioAttributes(android.media.AudioAttributes audioAttributes) { throw new RuntimeException("Stub!"); }

/**
 * Returns a Locale instance describing the language currently being used as the default
 * Text-to-speech language.
 *
 * The locale object returned by this method is NOT a valid one. It has identical form to the
 * one in {@link #getLanguage()}. Please refer to {@link #getLanguage()} for more information.
 *
 * @return language, country (if any) and variant (if any) used by the client stored in a
 *     Locale instance, or {@code null} on error.
 * @deprecated As of API level 21, use <code>getDefaultVoice().getLocale()</code> ({@link
 *   #getDefaultVoice()})
 * @apiSince 18
 * @deprecatedSince 21
 */

@Deprecated
public java.util.Locale getDefaultLanguage() { throw new RuntimeException("Stub!"); }

/**
 * Sets the text-to-speech language.
 * The TTS engine will try to use the closest match to the specified
 * language as represented by the Locale, but there is no guarantee that the exact same Locale
 * will be used. Use {@link #isLanguageAvailable(java.util.Locale)} to check the level of support
 * before choosing the language to use for the next utterances.
 *
 * This method sets the current voice to the default one for the given Locale;
 * {@link #getVoice()} can be used to retrieve it.
 *
 * @param loc The locale describing the language to be used.
 *
 * @return Code indicating the support status for the locale. See {@link #LANG_AVAILABLE},
 *         {@link #LANG_COUNTRY_AVAILABLE}, {@link #LANG_COUNTRY_VAR_AVAILABLE},
 *         {@link #LANG_MISSING_DATA} and {@link #LANG_NOT_SUPPORTED}.
 * @apiSince 4
 */

public int setLanguage(java.util.Locale loc) { throw new RuntimeException("Stub!"); }

/**
 * Returns a Locale instance describing the language currently being used for synthesis
 * requests sent to the TextToSpeech engine.
 *
 * In Android 4.2 and before (API <= 17) this function returns the language that is currently
 * being used by the TTS engine. That is the last language set by this or any other
 * client by a {@link android.speech.tts.TextToSpeech#setLanguage TextToSpeech#setLanguage} call to the same engine.
 *
 * In Android versions after 4.2 this function returns the language that is currently being
 * used for the synthesis requests sent from this client. That is the last language set
 * by a {@link android.speech.tts.TextToSpeech#setLanguage TextToSpeech#setLanguage} call on this instance.
 *
 * If a voice is set (by {@link #setVoice(android.speech.tts.Voice)}), getLanguage will return the language of
 * the currently set voice.
 *
 * Please note that the Locale object returned by this method is NOT a valid Locale object. Its
 * language field contains a three-letter ISO 639-2/T code (where a proper Locale would use
 * a two-letter ISO 639-1 code), and the country field contains a three-letter ISO 3166 country
 * code (where a proper Locale would use a two-letter ISO 3166-1 code).
 *
 * @return language, country (if any) and variant (if any) used by the client stored in a
 *     Locale instance, or {@code null} on error.
 *
 * @deprecated As of API level 21, please use <code>getVoice().getLocale()</code>
 * ({@link #getVoice()}).
 * @apiSince 4
 * @deprecatedSince 21
 */

@Deprecated
public java.util.Locale getLanguage() { throw new RuntimeException("Stub!"); }

/**
 * Query the engine about the set of available languages.
 * @apiSince 21
 */

public java.util.Set<java.util.Locale> getAvailableLanguages() { throw new RuntimeException("Stub!"); }

/**
 * Query the engine about the set of available voices.
 *
 * Each TTS Engine can expose multiple voices for each locale, each with a different set of
 * features.
 *
 * @see #setVoice(Voice)
 * @see android.speech.tts.Voice
 * @apiSince 21
 */

public java.util.Set<android.speech.tts.Voice> getVoices() { throw new RuntimeException("Stub!"); }

/**
 * Sets the text-to-speech voice.
 *
 * @param voice One of objects returned by {@link #getVoices()}.
 *
 * @return {@link #ERROR} or {@link #SUCCESS}.
 *
 * @see #getVoices
 * @see android.speech.tts.Voice
 * @apiSince 21
 */

public int setVoice(android.speech.tts.Voice voice) { throw new RuntimeException("Stub!"); }

/**
 * Returns a Voice instance describing the voice currently being used for synthesis
 * requests sent to the TextToSpeech engine.
 *
 * @return Voice instance used by the client, or {@code null} if not set or on error.
 *
 * @see #getVoices
 * @see #setVoice
 * @see android.speech.tts.Voice
 * @apiSince 21
 */

public android.speech.tts.Voice getVoice() { throw new RuntimeException("Stub!"); }

/**
 * Returns a Voice instance that's the default voice for the default Text-to-speech language.
 * @return The default voice instance for the default language, or {@code null} if not set or
 *     on error.
 * @apiSince 21
 */

public android.speech.tts.Voice getDefaultVoice() { throw new RuntimeException("Stub!"); }

/**
 * Checks if the specified language as represented by the Locale is available and supported.
 *
 * @param loc The Locale describing the language to be used.
 *
 * @return Code indicating the support status for the locale. See {@link #LANG_AVAILABLE},
 *         {@link #LANG_COUNTRY_AVAILABLE}, {@link #LANG_COUNTRY_VAR_AVAILABLE},
 *         {@link #LANG_MISSING_DATA} and {@link #LANG_NOT_SUPPORTED}.
 * @apiSince 4
 */

public int isLanguageAvailable(java.util.Locale loc) { throw new RuntimeException("Stub!"); }

/**
 * Synthesizes the given text to a file using the specified parameters.
 * This method is asynchronous, i.e. the method just adds the request to the queue of TTS
 * requests and then returns. The synthesis might not have finished (or even started!) at the
 * time when this method returns. In order to reliably detect errors during synthesis,
 * we recommend setting an utterance progress listener (see
 * {@link #setOnUtteranceProgressListener}).
 *
 * @param text The text that should be synthesized. No longer than
 *            {@link #getMaxSpeechInputLength()} characters.
 * @param params Parameters for the request. Can be null.
 *            Engine specific parameters may be passed in but the parameter keys
 *            must be prefixed by the name of the engine they are intended for. For example
 *            the keys "com.svox.pico_foo" and "com.svox.pico:bar" will be passed to the
 *            engine named "com.svox.pico" if it is being used.
 * @param file File to write the generated audio data to.
 * @param utteranceId An unique identifier for this request.
 * @return {@link #ERROR} or {@link #SUCCESS} of <b>queuing</b> the synthesizeToFile operation.
 * @apiSince 21
 */

public int synthesizeToFile(java.lang.CharSequence text, android.os.Bundle params, java.io.File file, java.lang.String utteranceId) { throw new RuntimeException("Stub!"); }

/**
 * Synthesizes the given text to a file using the specified parameters.
 * This method is asynchronous, i.e. the method just adds the request to the queue of TTS
 * requests and then returns. The synthesis might not have finished (or even started!) at the
 * time when this method returns. In order to reliably detect errors during synthesis,
 * we recommend setting an utterance progress listener (see
 * {@link #setOnUtteranceProgressListener}) and using the
 * {@link android.speech.tts.TextToSpeech.Engine#KEY_PARAM_UTTERANCE_ID Engine#KEY_PARAM_UTTERANCE_ID} parameter.
 *
 * @param text The text that should be synthesized. No longer than
 *            {@link #getMaxSpeechInputLength()} characters.
 * @param params Parameters for the request. Can be null.
 *            Supported parameter names:
 *            {@link android.speech.tts.TextToSpeech.Engine#KEY_PARAM_UTTERANCE_ID Engine#KEY_PARAM_UTTERANCE_ID}.
 *            Engine specific parameters may be passed in but the parameter keys
 *            must be prefixed by the name of the engine they are intended for. For example
 *            the keys "com.svox.pico_foo" and "com.svox.pico:bar" will be passed to the
 *            engine named "com.svox.pico" if it is being used.
 * @param filename Absolute file filename to write the generated audio data to.It should be
 *            something like "/sdcard/myappsounds/mysound.wav".
 *
 * @return {@link #ERROR} or {@link #SUCCESS} of <b>queuing</b> the synthesizeToFile operation.
 * @deprecated As of API level 21, replaced by
 *         {@link #synthesizeToFile(java.lang.CharSequence,android.os.Bundle,java.io.File,java.lang.String)}.
 * @apiSince 4
 * @deprecatedSince 21
 */

@Deprecated
public int synthesizeToFile(java.lang.String text, java.util.HashMap<java.lang.String,java.lang.String> params, java.lang.String filename) { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener that will be notified when synthesis of an utterance completes.
 *
 * @param listener The listener to use.
 *
 * @return {@link #ERROR} or {@link #SUCCESS}.
 *
 * @deprecated Use {@link #setOnUtteranceProgressListener(android.speech.tts.UtteranceProgressListener)}
 *        instead.
 * @apiSince 4
 * @deprecatedSince 15
 */

@Deprecated
public int setOnUtteranceCompletedListener(android.speech.tts.TextToSpeech.OnUtteranceCompletedListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener that will be notified of various events related to the
 * synthesis of a given utterance.
 *
 * See {@link android.speech.tts.UtteranceProgressListener UtteranceProgressListener} and
 * {@link android.speech.tts.TextToSpeech.Engine#KEY_PARAM_UTTERANCE_ID TextToSpeech.Engine#KEY_PARAM_UTTERANCE_ID}.
 *
 * @param listener the listener to use.
 * @return {@link #ERROR} or {@link #SUCCESS}
 * @apiSince 15
 */

public int setOnUtteranceProgressListener(android.speech.tts.UtteranceProgressListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Sets the TTS engine to use.
 *
 * @deprecated This doesn't inform callers when the TTS engine has been
 *        initialized. {@link #TextToSpeech(android.content.Context,android.speech.tts.TextToSpeech.OnInitListener,java.lang.String)}
 *        can be used with the appropriate engine name. Also, there is no
 *        guarantee that the engine specified will be loaded. If it isn't
 *        installed or disabled, the user / system wide defaults will apply.
 *
 * @param enginePackageName The package name for the synthesis engine (e.g. "com.svox.pico")
 *
 * @return {@link #ERROR} or {@link #SUCCESS}.
 * @apiSince 8
 * @deprecatedSince 15
 */

@Deprecated
public int setEngineByPackageName(java.lang.String enginePackageName) { throw new RuntimeException("Stub!"); }

/**
 * Gets the package name of the default speech synthesis engine.
 *
 * @return Package name of the TTS engine that the user has chosen
 *        as their default.
 * @apiSince 8
 */

public java.lang.String getDefaultEngine() { throw new RuntimeException("Stub!"); }

/**
 * Checks whether the user's settings should override settings requested
 * by the calling application. As of the Ice cream sandwich release,
 * user settings never forcibly override the app's settings.
 * @apiSince 8
 * @deprecatedSince 21
 */

@Deprecated
public boolean areDefaultsEnforced() { throw new RuntimeException("Stub!"); }

/**
 * Gets a list of all installed TTS engines.
 *
 * @return A list of engine info objects. The list can be empty, but never {@code null}.
 * @apiSince 14
 */

public java.util.List<android.speech.tts.TextToSpeech.EngineInfo> getEngines() { throw new RuntimeException("Stub!"); }

/**
 * Limit of length of input string passed to speak and synthesizeToFile.
 *
 * @see #speak
 * @see #synthesizeToFile
 * @apiSince 18
 */

public static int getMaxSpeechInputLength() { throw new RuntimeException("Stub!"); }

/**
 * Broadcast Action: The TextToSpeech synthesizer has completed processing
 * of all the text in the speech queue.
 *
 * Note that this notifies callers when the <b>engine</b> has finished has
 * processing text data. Audio playback might not have completed (or even started)
 * at this point. If you wish to be notified when this happens, see
 * {@link android.speech.tts.TextToSpeech.OnUtteranceCompletedListener OnUtteranceCompletedListener}.
 * @apiSince 4
 */

public static final java.lang.String ACTION_TTS_QUEUE_PROCESSING_COMPLETED = "android.speech.tts.TTS_QUEUE_PROCESSING_COMPLETED";

/**
 * Denotes a generic operation failure.
 * @apiSince 4
 */

public static final int ERROR = -1; // 0xffffffff

/**
 * Denotes a failure caused by an invalid request.
 * @apiSince 21
 */

public static final int ERROR_INVALID_REQUEST = -8; // 0xfffffff8

/**
 * Denotes a failure caused by a network connectivity problems.
 * @apiSince 21
 */

public static final int ERROR_NETWORK = -6; // 0xfffffffa

/**
 * Denotes a failure caused by network timeout.
 * @apiSince 21
 */

public static final int ERROR_NETWORK_TIMEOUT = -7; // 0xfffffff9

/**
 * Denotes a failure caused by an unfinished download of the voice data.
 * @see android.speech.tts.TextToSpeech.Engine#KEY_FEATURE_NOT_INSTALLED
 * @apiSince 21
 */

public static final int ERROR_NOT_INSTALLED_YET = -9; // 0xfffffff7

/**
 * Denotes a failure related to the output (audio device or a file).
 * @apiSince 21
 */

public static final int ERROR_OUTPUT = -5; // 0xfffffffb

/**
 * Denotes a failure of a TTS service.
 * @apiSince 21
 */

public static final int ERROR_SERVICE = -4; // 0xfffffffc

/**
 * Denotes a failure of a TTS engine to synthesize the given input.
 * @apiSince 21
 */

public static final int ERROR_SYNTHESIS = -3; // 0xfffffffd

/**
 * Denotes the language is available for the language by the locale,
 * but not the country and variant.
 * @apiSince 4
 */

public static final int LANG_AVAILABLE = 0; // 0x0

/**
 * Denotes the language is available for the language and country specified
 * by the locale, but not the variant.
 * @apiSince 4
 */

public static final int LANG_COUNTRY_AVAILABLE = 1; // 0x1

/**
 * Denotes the language is available exactly as specified by the locale.
 * @apiSince 4
 */

public static final int LANG_COUNTRY_VAR_AVAILABLE = 2; // 0x2

/**
 * Denotes the language data is missing.
 * @apiSince 4
 */

public static final int LANG_MISSING_DATA = -1; // 0xffffffff

/**
 * Denotes the language is not supported.
 * @apiSince 4
 */

public static final int LANG_NOT_SUPPORTED = -2; // 0xfffffffe

/**
 * Queue mode where the new entry is added at the end of the playback queue.
 * @apiSince 4
 */

public static final int QUEUE_ADD = 1; // 0x1

/**
 * Queue mode where all entries in the playback queue (media to be played
 * and text to be synthesized) are dropped and replaced by the new entry.
 * Queues are flushed with respect to a given calling app. Entries in the queue
 * from other callees are not discarded.
 * @apiSince 4
 */

public static final int QUEUE_FLUSH = 0; // 0x0

/**
 * Denotes a stop requested by a client. It's used only on the service side of the API,
 * client should never expect to see this result code.
 * @apiSince 21
 */

public static final int STOPPED = -2; // 0xfffffffe

/**
 * Denotes a successful operation.
 * @apiSince 4
 */

public static final int SUCCESS = 0; // 0x0
/**
 * Constants and parameter names for controlling text-to-speech. These include:
 *
 * <ul>
 *     <li>
 *         Intents to ask engine to install data or check its data and
 *         extras for a TTS engine's check data activity.
 *     </li>
 *     <li>
 *         Keys for the parameters passed with speak commands, e.g.
 *         {@link android.speech.tts.TextToSpeech.Engine#KEY_PARAM_UTTERANCE_ID Engine#KEY_PARAM_UTTERANCE_ID}, {@link android.speech.tts.TextToSpeech.Engine#KEY_PARAM_STREAM Engine#KEY_PARAM_STREAM}.
 *     </li>
 *     <li>
 *         A list of feature strings that engines might support, e.g
 *         {@link android.speech.tts.TextToSpeech.Engine#KEY_FEATURE_NETWORK_SYNTHESIS Engine#KEY_FEATURE_NETWORK_SYNTHESIS}. These values may be passed in to
 *         {@link android.speech.tts.TextToSpeech#speak TextToSpeech#speak} and {@link android.speech.tts.TextToSpeech#synthesizeToFile TextToSpeech#synthesizeToFile} to modify
 *         engine behaviour. The engine can be queried for the set of features it supports
 *         through {@link android.speech.tts.TextToSpeech#getFeatures(java.util.Locale) TextToSpeech#getFeatures(java.util.Locale)}.
 *     </li>
 * </ul>
 * @apiSince 4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Engine {

public Engine() { throw new RuntimeException("Stub!"); }

/**
 * Activity Action: Starts the activity from the platform TextToSpeech
 * engine to verify the proper installation and availability of the
 * resource files on the system. Upon completion, the activity will
 * return one of the following codes:
 * {@link #CHECK_VOICE_DATA_PASS},
 * {@link #CHECK_VOICE_DATA_FAIL},
 * <p> Moreover, the data received in the activity result will contain the following
 * fields:
 * <ul>
 *   <li>{@link #EXTRA_AVAILABLE_VOICES} which contains an ArrayList<String> of all the
 *   available voices. The format of each voice is: lang-COUNTRY-variant where COUNTRY and
 *   variant are optional (ie, "eng" or "eng-USA" or "eng-USA-FEMALE").</li>
 *   <li>{@link #EXTRA_UNAVAILABLE_VOICES} which contains an ArrayList<String> of all the
 *   unavailable voices (ones that user can install). The format of each voice is:
 *   lang-COUNTRY-variant where COUNTRY and variant are optional (ie, "eng" or
 *   "eng-USA" or "eng-USA-FEMALE").</li>
 * </ul>
 * @apiSince 4
 */

public static final java.lang.String ACTION_CHECK_TTS_DATA = "android.speech.tts.engine.CHECK_TTS_DATA";

/**
 * Activity intent for getting some sample text to use for demonstrating TTS. Specific
 * locale have to be requested by passing following extra parameters:
 * <ul>
 *   <li>language</li>
 *   <li>country</li>
 *   <li>variant</li>
 * </ul>
 *
 * Upon completion, the activity result may contain the following fields:
 * <ul>
 *   <li>{@link #EXTRA_SAMPLE_TEXT} which contains an String with sample text.</li>
 * </ul>
 * @apiSince 18
 */

public static final java.lang.String ACTION_GET_SAMPLE_TEXT = "android.speech.tts.engine.GET_SAMPLE_TEXT";

/**
 * Activity Action: Triggers the platform TextToSpeech engine to
 * start the activity that installs the resource files on the device
 * that are required for TTS to be operational. Since the installation
 * of the data can be interrupted or declined by the user, the application
 * shouldn't expect successful installation upon return from that intent,
 * and if need be, should check installation status with
 * {@link #ACTION_CHECK_TTS_DATA}.
 * @apiSince 4
 */

public static final java.lang.String ACTION_INSTALL_TTS_DATA = "android.speech.tts.engine.INSTALL_TTS_DATA";

/**
 * Broadcast Action: broadcast to signal the change in the list of available
 * languages or/and their features.
 * @apiSince 4
 */

public static final java.lang.String ACTION_TTS_DATA_INSTALLED = "android.speech.tts.engine.TTS_DATA_INSTALLED";

/**
 * Indicates erroneous data when checking the installation status of the resources used by
 * the TextToSpeech engine with the {@link #ACTION_CHECK_TTS_DATA} intent.
 *
 * @deprecated Use CHECK_VOICE_DATA_FAIL instead.
 * @apiSince 4
 * @deprecatedSince 18
 */

@Deprecated public static final int CHECK_VOICE_DATA_BAD_DATA = -1; // 0xffffffff

/**
 * Indicates failure when checking the installation status of the resources used by the
 * TextToSpeech engine with the {@link #ACTION_CHECK_TTS_DATA} intent.
 * @apiSince 4
 */

public static final int CHECK_VOICE_DATA_FAIL = 0; // 0x0

/**
 * Indicates missing resources when checking the installation status of the resources used
 * by the TextToSpeech engine with the {@link #ACTION_CHECK_TTS_DATA} intent.
 *
 * @deprecated Use CHECK_VOICE_DATA_FAIL instead.
 * @apiSince 4
 * @deprecatedSince 18
 */

@Deprecated public static final int CHECK_VOICE_DATA_MISSING_DATA = -2; // 0xfffffffe

/**
 * Indicates missing storage volume when checking the installation status of the resources
 * used by the TextToSpeech engine with the {@link #ACTION_CHECK_TTS_DATA} intent.
 *
 * @deprecated Use CHECK_VOICE_DATA_FAIL instead.
 * @apiSince 4
 * @deprecatedSince 18
 */

@Deprecated public static final int CHECK_VOICE_DATA_MISSING_VOLUME = -3; // 0xfffffffd

/**
 * Indicates success when checking the installation status of the resources used by the
 * TextToSpeech engine with the {@link #ACTION_CHECK_TTS_DATA} intent.
 * @apiSince 4
 */

public static final int CHECK_VOICE_DATA_PASS = 1; // 0x1

/**
 * Default audio stream used when playing synthesized speech.
 * @apiSince 4
 */

public static final int DEFAULT_STREAM = 3; // 0x3

/**
 * Extra information received with the {@link #ACTION_CHECK_TTS_DATA} intent result where
 * the TextToSpeech engine returns an ArrayList<String> of all the available voices.
 * The format of each voice is: lang-COUNTRY-variant where COUNTRY and variant are
 * optional (ie, "eng" or "eng-USA" or "eng-USA-FEMALE").
 * @apiSince 8
 */

public static final java.lang.String EXTRA_AVAILABLE_VOICES = "availableVoices";

/**
 * Extra information sent with the {@link #ACTION_CHECK_TTS_DATA} intent where the
 * caller indicates to the TextToSpeech engine which specific sets of voice data to
 * check for by sending an ArrayList<String> of the voices that are of interest.
 * The format of each voice is: lang-COUNTRY-variant where COUNTRY and variant are
 * optional (ie, "eng" or "eng-USA" or "eng-USA-FEMALE").
 *
 * @deprecated Redundant functionality, checking for existence of specific sets of voice
 * data can be done on client side.
 * @apiSince 8
 * @deprecatedSince 18
 */

@Deprecated public static final java.lang.String EXTRA_CHECK_VOICE_DATA_FOR = "checkVoiceDataFor";

/**
 * Extra information received with the {@link #ACTION_GET_SAMPLE_TEXT} intent result where
 * the TextToSpeech engine returns an String with sample text for requested voice
 * @apiSince 18
 */

public static final java.lang.String EXTRA_SAMPLE_TEXT = "sampleText";

/**
 * Extra information received with the {@link #ACTION_TTS_DATA_INSTALLED} intent result.
 * It indicates whether the data files for the synthesis engine were successfully
 * installed. The installation was initiated with the  {@link #ACTION_INSTALL_TTS_DATA}
 * intent. The possible values for this extra are
 * {@link android.speech.tts.TextToSpeech#SUCCESS TextToSpeech#SUCCESS} and {@link android.speech.tts.TextToSpeech#ERROR TextToSpeech#ERROR}.
 *
 * @deprecated No longer in use. If client is interested in information about what
 * changed, it should use the ACTION_CHECK_TTS_DATA
 * intent to discover available voices.
 * @apiSince 4
 * @deprecatedSince 18
 */

@Deprecated public static final java.lang.String EXTRA_TTS_DATA_INSTALLED = "dataInstalled";

/**
 * Extra information received with the {@link #ACTION_CHECK_TTS_DATA} intent result where
 * the TextToSpeech engine returns an ArrayList<String> of all the unavailable voices.
 * The format of each voice is: lang-COUNTRY-variant where COUNTRY and variant are
 * optional (ie, "eng" or "eng-USA" or "eng-USA-FEMALE").
 * @apiSince 8
 */

public static final java.lang.String EXTRA_UNAVAILABLE_VOICES = "unavailableVoices";

/**
 * Extra information received with the {@link #ACTION_CHECK_TTS_DATA} intent result where
 * the TextToSpeech engine specifies the file names of its resources under the
 * resource path.
 *
 * @deprecated TTS engine implementation detail, this information has no use for
 * text-to-speech API client.
 * @apiSince 4
 * @deprecatedSince 18
 */

@Deprecated public static final java.lang.String EXTRA_VOICE_DATA_FILES = "dataFiles";

/**
 * Extra information received with the {@link #ACTION_CHECK_TTS_DATA} intent result where
 * the TextToSpeech engine specifies the locale associated with each resource file.
 *
 * @deprecated TTS engine implementation detail, this information has no use for
 * text-to-speech API client.
 * @apiSince 4
 * @deprecatedSince 18
 */

@Deprecated public static final java.lang.String EXTRA_VOICE_DATA_FILES_INFO = "dataFilesInfo";

/**
 * Extra information received with the {@link #ACTION_CHECK_TTS_DATA} intent result where
 * the TextToSpeech engine specifies the path to its resources.
 *
 * It may be used by language packages to find out where to put their data.
 *
 * @deprecated TTS engine implementation detail, this information has no use for
 * text-to-speech API client.
 * @apiSince 4
 * @deprecatedSince 18
 */

@Deprecated public static final java.lang.String EXTRA_VOICE_DATA_ROOT_DIRECTORY = "dataRoot";

/**
 * Intent for starting a TTS service. Services that handle this intent must
 * extend {@link android.speech.tts.TextToSpeechService TextToSpeechService}. Normal applications should not use this intent
 * directly, instead they should talk to the TTS service using the the methods in this
 * class.
 * @apiSince 14
 */

public static final java.lang.String INTENT_ACTION_TTS_SERVICE = "android.intent.action.TTS_SERVICE";

/**
 * Feature key for embedded synthesis. See {@link android.speech.tts.TextToSpeech#getFeatures(java.util.Locale) TextToSpeech#getFeatures(Locale)}
 * for a description of how feature keys work. If set and supported by the engine
 * as per {@link android.speech.tts.TextToSpeech#getFeatures(java.util.Locale) TextToSpeech#getFeatures(Locale)}, the engine must synthesize
 * text on-device (without making network requests).
 *
 * @see android.speech.tts.TextToSpeech#speak(CharSequence, int, Bundle, String)
 * @see android.speech.tts.TextToSpeech#synthesizeToFile(String, java.util.HashMap, String)
 * @see android.speech.tts.TextToSpeech#getFeatures(java.util.Locale)
 
 * @deprecated Starting from API level 21, to select embedded synthesis, call
 * ({@link android.speech.tts.TextToSpeech#getVoices() TextToSpeech#getVoices()}, find a suitable embedded voice
 * ({@link android.speech.tts.Voice#isNetworkConnectionRequired() Voice#isNetworkConnectionRequired()}) and pass it
 * to {@link android.speech.tts.TextToSpeech#setVoice(android.speech.tts.Voice) TextToSpeech#setVoice(Voice)}).
 * @apiSince 15
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String KEY_FEATURE_EMBEDDED_SYNTHESIS = "embeddedTts";

/**
 * Feature key that indicates that network request retries count can be set for the request.
 * If set and supported as per {@link android.speech.tts.TextToSpeech#getFeatures(java.util.Locale) TextToSpeech#getFeatures(Locale)} or
 * {@link android.speech.tts.Voice#getFeatures() Voice#getFeatures()}, it can be used as a request parameter to set the
 * number of network request retries that are attempted in case of failure. When used as
 * a key of a request parameter, its value should be a string with an integer value.
 *
 * @see android.speech.tts.TextToSpeech#getFeatures(java.util.Locale)
 * @see android.speech.tts.Voice#getFeatures()
 * @apiSince 21
 */

public static final java.lang.String KEY_FEATURE_NETWORK_RETRIES_COUNT = "networkRetriesCount";

/**
 * Feature key for network synthesis. See {@link android.speech.tts.TextToSpeech#getFeatures(java.util.Locale) TextToSpeech#getFeatures(Locale)}
 * for a description of how feature keys work. If set (and supported by the engine
 * as per {@link android.speech.tts.TextToSpeech#getFeatures(java.util.Locale) TextToSpeech#getFeatures(Locale)}, the engine must
 * use network based synthesis.
 *
 * @see android.speech.tts.TextToSpeech#speak(CharSequence, int, Bundle, String)
 * @see android.speech.tts.TextToSpeech#synthesizeToFile(String, java.util.HashMap, String)
 * @see android.speech.tts.TextToSpeech#getFeatures(java.util.Locale)
 *
 * @deprecated Starting from API level 21, to select network synthesis, call
 * {@link android.speech.tts.TextToSpeech#getVoices() TextToSpeech#getVoices()}, find a suitable network voice
 * ({@link android.speech.tts.Voice#isNetworkConnectionRequired() Voice#isNetworkConnectionRequired()}) and pass it
 * to {@link android.speech.tts.TextToSpeech#setVoice(android.speech.tts.Voice) TextToSpeech#setVoice(Voice)}.
 * @apiSince 15
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String KEY_FEATURE_NETWORK_SYNTHESIS = "networkTts";

/**
 * Feature key that indicate that a network timeout can be set for the request. If set and
 * supported as per {@link android.speech.tts.TextToSpeech#getFeatures(java.util.Locale) TextToSpeech#getFeatures(Locale)} or {@link android.speech.tts.Voice#getFeatures() Voice#getFeatures()},
 * it can be used as request parameter to set the maximum allowed time for a single
 * request attempt, in milliseconds, before synthesis fails. When used as a key of
 * a request parameter, its value should be a string with an integer value.
 *
 * @see android.speech.tts.TextToSpeech#getFeatures(java.util.Locale)
 * @see android.speech.tts.Voice#getFeatures()
 * @apiSince 21
 */

public static final java.lang.String KEY_FEATURE_NETWORK_TIMEOUT_MS = "networkTimeoutMs";

/**
 * Feature key that indicates that the voice may need to download additional data to be fully
 * functional. The download will be triggered by calling
 * {@link android.speech.tts.TextToSpeech#setVoice(android.speech.tts.Voice) TextToSpeech#setVoice(Voice)} or {@link android.speech.tts.TextToSpeech#setLanguage(java.util.Locale) TextToSpeech#setLanguage(Locale)}.
 * Until download is complete, each synthesis request will either report
 * {@link android.speech.tts.TextToSpeech#ERROR_NOT_INSTALLED_YET TextToSpeech#ERROR_NOT_INSTALLED_YET} error, or use a different voice to synthesize
 * the request. This feature should NOT be used as a key of a request parameter.
 *
 * @see android.speech.tts.TextToSpeech#getFeatures(java.util.Locale)
 * @see android.speech.tts.Voice#getFeatures()
 * @apiSince 21
 */

public static final java.lang.String KEY_FEATURE_NOT_INSTALLED = "notInstalled";

/**
 * Parameter key to specify how the speech is panned from left to right when speaking text.
 * Pan is specified as a float ranging from -1 to +1 where -1 maps to a hard-left pan,
 * 0 to center (the default behavior), and +1 to hard-right.
 *
 * @see android.speech.tts.TextToSpeech#speak(CharSequence, int, Bundle, String)
 * @see android.speech.tts.TextToSpeech#playEarcon(String, int, HashMap)
 * @apiSince 11
 */

public static final java.lang.String KEY_PARAM_PAN = "pan";

/**
 * Parameter key to specify an audio session identifier (obtained from
 * {@link android.media.AudioManager#generateAudioSessionId() AudioManager#generateAudioSessionId()}) that will be used by the request audio
 * output. It can be used to associate one of the {@link android.media.audiofx.AudioEffect}
 * objects with the synthesis (or earcon) output.
 *
 * @see android.speech.tts.TextToSpeech#speak(CharSequence, int, Bundle, String)
 * @see android.speech.tts.TextToSpeech#playEarcon(String, int, HashMap)
 * @apiSince 21
 */

public static final java.lang.String KEY_PARAM_SESSION_ID = "sessionId";

/**
 * Parameter key to specify the audio stream type to be used when speaking text
 * or playing back a file. The value should be one of the STREAM_ constants
 * defined in {@link android.media.AudioManager AudioManager}.
 *
 * @see android.speech.tts.TextToSpeech#speak(CharSequence, int, Bundle, String)
 * @see android.speech.tts.TextToSpeech#playEarcon(String, int, HashMap)
 * @apiSince 4
 */

public static final java.lang.String KEY_PARAM_STREAM = "streamType";

/**
 * Parameter key to identify an utterance in the
 * {@link android.speech.tts.TextToSpeech.OnUtteranceCompletedListener TextToSpeech.OnUtteranceCompletedListener} after text has been
 * spoken, a file has been played back or a silence duration has elapsed.
 *
 * @see android.speech.tts.TextToSpeech#speak(CharSequence, int, Bundle, String)
 * @see android.speech.tts.TextToSpeech#playEarcon(String, int, HashMap)
 * @see android.speech.tts.TextToSpeech#synthesizeToFile(String, HashMap, String)
 * @apiSince 4
 */

public static final java.lang.String KEY_PARAM_UTTERANCE_ID = "utteranceId";

/**
 * Parameter key to specify the speech volume relative to the current stream type
 * volume used when speaking text. Volume is specified as a float ranging from 0 to 1
 * where 0 is silence, and 1 is the maximum volume (the default behavior).
 *
 * @see android.speech.tts.TextToSpeech#speak(CharSequence, int, Bundle, String)
 * @see android.speech.tts.TextToSpeech#playEarcon(String, int, HashMap)
 * @apiSince 11
 */

public static final java.lang.String KEY_PARAM_VOLUME = "volume";

/**
 * Name under which a text to speech engine publishes information about itself.
 * This meta-data should reference an XML resource containing a
 * <code>&lt;{@link android.R.styleable#TextToSpeechEngine tts-engine}&gt;</code>
 * tag.
 * @apiSince 14
 */

public static final java.lang.String SERVICE_META_DATA = "android.speech.tts";
}

/**
 * Information about an installed text-to-speech engine.
 *
 * @see android.speech.tts.TextToSpeech#getEngines
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class EngineInfo {

public EngineInfo() { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Icon for the engine.
 * @apiSince 14
 */

public int icon;

/**
 * Localized label for the engine.
 * @apiSince 14
 */

public java.lang.String label;

/**
 * Engine package name..
 * @apiSince 14
 */

public java.lang.String name;
}

/**
 * Interface definition of a callback to be invoked indicating the completion of the
 * TextToSpeech engine initialization.
 * @apiSince 4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnInitListener {

/**
 * Called to signal the completion of the TextToSpeech engine initialization.
 *
 * @param status {@link android.speech.tts.TextToSpeech#SUCCESS TextToSpeech#SUCCESS} or {@link android.speech.tts.TextToSpeech#ERROR TextToSpeech#ERROR}.
 * @apiSince 4
 */

public void onInit(int status);
}

/**
 * Listener that will be called when the TTS service has
 * completed synthesizing an utterance. This is only called if the utterance
 * has an utterance ID (see {@link android.speech.tts.TextToSpeech.Engine#KEY_PARAM_UTTERANCE_ID TextToSpeech.Engine#KEY_PARAM_UTTERANCE_ID}).
 *
 * @deprecated Use {@link android.speech.tts.UtteranceProgressListener UtteranceProgressListener} instead.
 * @apiSince 4
 * @deprecatedSince 18
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface OnUtteranceCompletedListener {

/**
 * Called when an utterance has been synthesized.
 *
 * @param utteranceId the identifier of the utterance.
 * @apiSince 4
 * @deprecatedSince 18
 */

@Deprecated
public void onUtteranceCompleted(java.lang.String utteranceId);
}

}

