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

package android.speech.tts;

import java.util.Locale;

/**
 * Abstract base class for TTS engine implementations. The following methods
 * need to be implemented:
 * <ul>
 * <li>{@link #onIsLanguageAvailable}</li>
 * <li>{@link #onLoadLanguage}</li>
 * <li>{@link #onGetLanguage}</li>
 * <li>{@link #onSynthesizeText}</li>
 * <li>{@link #onStop}</li>
 * </ul>
 * The first three deal primarily with language management, and are used to
 * query the engine for it's support for a given language and indicate to it
 * that requests in a given language are imminent.
 *
 * {@link #onSynthesizeText} is central to the engine implementation. The
 * implementation should synthesize text as per the request parameters and
 * return synthesized data via the supplied callback. This class and its helpers
 * will then consume that data, which might mean queuing it for playback or writing
 * it to a file or similar. All calls to this method will be on a single thread,
 * which will be different from the main thread of the service. Synthesis must be
 * synchronous which means the engine must NOT hold on to the callback or call any
 * methods on it after the method returns.
 *
 * {@link #onStop} tells the engine that it should stop
 * all ongoing synthesis, if any. Any pending data from the current synthesis
 * will be discarded.
 *
 * {@link #onGetLanguage} is not required as of JELLYBEAN_MR2 (API 18) and later, it is only
 * called on earlier versions of Android.
 *
 * API Level 20 adds support for Voice objects. Voices are an abstraction that allow the TTS
 * service to expose multiple backends for a single locale. Each one of them can have a different
 * features set. In order to fully take advantage of voices, an engine should implement
 * the following methods:
 * <ul>
 * <li>{@link #onGetVoices()}</li>
 * <li>{@link #onIsValidVoiceName(java.lang.String)}</li>
 * <li>{@link #onLoadVoice(java.lang.String)}</li>
 * <li>{@link #onGetDefaultVoiceNameFor(java.lang.String,java.lang.String,java.lang.String)}</li>
 * </ul>
 * The first three methods are siblings of the {@link #onGetLanguage},
 * {@link #onIsLanguageAvailable} and {@link #onLoadLanguage} methods. The last one,
 * {@link #onGetDefaultVoiceNameFor(java.lang.String,java.lang.String,java.lang.String)} is a link between locale and voice
 * based methods. Since API level 21 {@link android.speech.tts.TextToSpeech#setLanguage TextToSpeech#setLanguage} is implemented by
 * calling {@link android.speech.tts.TextToSpeech#setVoice TextToSpeech#setVoice} with the voice returned by
 * {@link #onGetDefaultVoiceNameFor(java.lang.String,java.lang.String,java.lang.String)}.
 *
 * If the client uses a voice instead of a locale, {@link android.speech.tts.SynthesisRequest SynthesisRequest} will contain the
 * requested voice name.
 *
 * The default implementations of Voice-related methods implement them using the
 * pre-existing locale-based implementation.
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class TextToSpeechService extends android.app.Service {

public TextToSpeechService() { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public void onCreate() { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public void onDestroy() { throw new RuntimeException("Stub!"); }

/**
 * Checks whether the engine supports a given language.
 *
 * Can be called on multiple threads.
 *
 * Its return values HAVE to be consistent with onLoadLanguage.
 *
 * @param lang ISO-3 language code.
 * @param country ISO-3 country code. May be empty or null.
 * @param variant Language variant. May be empty or null.
 * @return Code indicating the support status for the locale.
 *         One of {@link android.speech.tts.TextToSpeech#LANG_AVAILABLE TextToSpeech#LANG_AVAILABLE},
 *         {@link android.speech.tts.TextToSpeech#LANG_COUNTRY_AVAILABLE TextToSpeech#LANG_COUNTRY_AVAILABLE},
 *         {@link android.speech.tts.TextToSpeech#LANG_COUNTRY_VAR_AVAILABLE TextToSpeech#LANG_COUNTRY_VAR_AVAILABLE},
 *         {@link android.speech.tts.TextToSpeech#LANG_MISSING_DATA TextToSpeech#LANG_MISSING_DATA}
 *         {@link android.speech.tts.TextToSpeech#LANG_NOT_SUPPORTED TextToSpeech#LANG_NOT_SUPPORTED}.
 * @apiSince 14
 */

protected abstract int onIsLanguageAvailable(java.lang.String lang, java.lang.String country, java.lang.String variant);

/**
 * Returns the language, country and variant currently being used by the TTS engine.
 *
 * This method will be called only on Android 4.2 and before (API <= 17). In later versions
 * this method is not called by the Android TTS framework.
 *
 * Can be called on multiple threads.
 *
 * @return A 3-element array, containing language (ISO 3-letter code),
 *         country (ISO 3-letter code) and variant used by the engine.
 *         The country and variant may be {@code ""}. If country is empty, then variant must
 *         be empty too.
 * @see java.util.Locale#getISO3Language()
 * @see java.util.Locale#getISO3Country()
 * @see java.util.Locale#getVariant()
 * @apiSince 14
 */

protected abstract java.lang.String[] onGetLanguage();

/**
 * Notifies the engine that it should load a speech synthesis language. There is no guarantee
 * that this method is always called before the language is used for synthesis. It is merely
 * a hint to the engine that it will probably get some synthesis requests for this language
 * at some point in the future.
 *
 * Can be called on multiple threads.
 * In <= Android 4.2 (<= API 17) can be called on main and service binder threads.
 * In > Android 4.2 (> API 17) can be called on main and synthesis threads.
 *
 * @param lang ISO-3 language code.
 * @param country ISO-3 country code. May be empty or null.
 * @param variant Language variant. May be empty or null.
 * @return Code indicating the support status for the locale.
 *         One of {@link android.speech.tts.TextToSpeech#LANG_AVAILABLE TextToSpeech#LANG_AVAILABLE},
 *         {@link android.speech.tts.TextToSpeech#LANG_COUNTRY_AVAILABLE TextToSpeech#LANG_COUNTRY_AVAILABLE},
 *         {@link android.speech.tts.TextToSpeech#LANG_COUNTRY_VAR_AVAILABLE TextToSpeech#LANG_COUNTRY_VAR_AVAILABLE},
 *         {@link android.speech.tts.TextToSpeech#LANG_MISSING_DATA TextToSpeech#LANG_MISSING_DATA}
 *         {@link android.speech.tts.TextToSpeech#LANG_NOT_SUPPORTED TextToSpeech#LANG_NOT_SUPPORTED}.
 * @apiSince 14
 */

protected abstract int onLoadLanguage(java.lang.String lang, java.lang.String country, java.lang.String variant);

/**
 * Notifies the service that it should stop any in-progress speech synthesis.
 * This method can be called even if no speech synthesis is currently in progress.
 *
 * Can be called on multiple threads, but not on the synthesis thread.
 * @apiSince 14
 */

protected abstract void onStop();

/**
 * Tells the service to synthesize speech from the given text. This method should block until
 * the synthesis is finished. Called on the synthesis thread.
 *
 * @param request The synthesis request.
 * @param callback The callback that the engine must use to make data available for playback or
 *     for writing to a file.
 * @apiSince 14
 */

protected abstract void onSynthesizeText(android.speech.tts.SynthesisRequest request, android.speech.tts.SynthesisCallback callback);

/**
 * Queries the service for a set of features supported for a given language.
 *
 * Can be called on multiple threads.
 *
 * @param lang ISO-3 language code.
 * @param country ISO-3 country code. May be empty or null.
 * @param variant Language variant. May be empty or null.
 * @return A list of features supported for the given language.
 * @apiSince 15
 */

protected java.util.Set<java.lang.String> onGetFeaturesForLanguage(java.lang.String lang, java.lang.String country, java.lang.String variant) { throw new RuntimeException("Stub!"); }

/**
 * Queries the service for a set of supported voices.
 *
 * Can be called on multiple threads.
 *
 * The default implementation tries to enumerate all available locales, pass them to
 * {@link #onIsLanguageAvailable(java.lang.String,java.lang.String,java.lang.String)} and create Voice instances (using
 * the locale's BCP-47 language tag as the voice name) for the ones that are supported.
 * Note, that this implementation is suitable only for engines that don't have multiple voices
 * for a single locale. Also, this implementation won't work with Locales not listed in the
 * set returned by the {@link java.util.Locale#getAvailableLocales() Locale#getAvailableLocales()} method.
 *
 * @return A list of voices supported.
 * @apiSince 21
 */

public java.util.List<android.speech.tts.Voice> onGetVoices() { throw new RuntimeException("Stub!"); }

/**
 * Return a name of the default voice for a given locale.
 *
 * This method provides a mapping between locales and available voices. This method is
 * used in {@link android.speech.tts.TextToSpeech#setLanguage TextToSpeech#setLanguage}, which calls this method and then calls
 * {@link android.speech.tts.TextToSpeech#setVoice TextToSpeech#setVoice} with the voice returned by this method.
 *
 * Also, it's used by {@link android.speech.tts.TextToSpeech#getDefaultVoice() TextToSpeech#getDefaultVoice()} to find a default voice for
 * the default locale.
 *
 * @param lang ISO-3 language code.
 * @param country ISO-3 country code. May be empty or null.
 * @param variant Language variant. May be empty or null.
 
 * @return A name of the default voice for a given locale.
 * @apiSince 21
 */

public java.lang.String onGetDefaultVoiceNameFor(java.lang.String lang, java.lang.String country, java.lang.String variant) { throw new RuntimeException("Stub!"); }

/**
 * Notifies the engine that it should load a speech synthesis voice. There is no guarantee
 * that this method is always called before the voice is used for synthesis. It is merely
 * a hint to the engine that it will probably get some synthesis requests for this voice
 * at some point in the future.
 *
 * Will be called only on synthesis thread.
 *
 * The default implementation creates a Locale from the voice name (by interpreting the name as
 * a BCP-47 tag for the locale), and passes it to
 * {@link #onLoadLanguage(java.lang.String,java.lang.String,java.lang.String)}.
 *
 * @param voiceName Name of the voice.
 * @return {@link android.speech.tts.TextToSpeech#ERROR TextToSpeech#ERROR} or {@link android.speech.tts.TextToSpeech#SUCCESS TextToSpeech#SUCCESS}.
 * @apiSince 21
 */

public int onLoadVoice(java.lang.String voiceName) { throw new RuntimeException("Stub!"); }

/**
 * Checks whether the engine supports a voice with a given name.
 *
 * Can be called on multiple threads.
 *
 * The default implementation treats the voice name as a language tag, creating a Locale from
 * the voice name, and passes it to {@link #onIsLanguageAvailable(java.lang.String,java.lang.String,java.lang.String)}.
 *
 * @param voiceName Name of the voice.
 * @return {@link android.speech.tts.TextToSpeech#ERROR TextToSpeech#ERROR} or {@link android.speech.tts.TextToSpeech#SUCCESS TextToSpeech#SUCCESS}.
 * @apiSince 21
 */

public int onIsValidVoiceName(java.lang.String voiceName) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public android.os.IBinder onBind(android.content.Intent intent) { throw new RuntimeException("Stub!"); }
}

