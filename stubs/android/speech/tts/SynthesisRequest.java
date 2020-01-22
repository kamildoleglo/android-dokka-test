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


/**
 * Contains data required by engines to synthesize speech. This data is:
 * <ul>
 *   <li>The text to synthesize</li>
 *   <li>The synthesis locale, represented as a language, country and a variant.
 *   The language is an ISO 639-3 letter language code, and the country is an
 *   ISO 3166 alpha 3 code. The variant is not specified.</li>
 *   <li>The name of the voice requested for this synthesis. May be empty if
 *   the client uses {@link android.speech.tts.TextToSpeech#setLanguage TextToSpeech#setLanguage} instead of
 *   {@link android.speech.tts.TextToSpeech#setVoice TextToSpeech#setVoice}</li>
 *   <li>The synthesis speech rate, with 100 being the normal, and
 *   higher values representing higher speech rates.</li>
 *   <li>The voice pitch, with 100 being the default pitch.</li>
 * </ul>
 *
 * Any additional parameters sent to the text to speech service are passed in
 * uninterpreted, see the {@code params} argument in {@link android.speech.tts.TextToSpeech#speak TextToSpeech#speak}
 * and {@link android.speech.tts.TextToSpeech#synthesizeToFile TextToSpeech#synthesizeToFile}.
 * @apiSince 14
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SynthesisRequest {

/** @apiSince 14 */

public SynthesisRequest(java.lang.String text, android.os.Bundle params) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public SynthesisRequest(java.lang.CharSequence text, android.os.Bundle params) { throw new RuntimeException("Stub!"); }

/**
 * Gets the text which should be synthesized.
 * @deprecated As of API level 21, replaced by {@link #getCharSequenceText}.
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated
public java.lang.String getText() { throw new RuntimeException("Stub!"); }

/**
 * Gets the text which should be synthesized.
 * @apiSince 21
 */

public java.lang.CharSequence getCharSequenceText() { throw new RuntimeException("Stub!"); }

/**
 * Gets the name of the voice to use.
 * @apiSince 21
 */

public java.lang.String getVoiceName() { throw new RuntimeException("Stub!"); }

/**
 * Gets the ISO 3-letter language code for the language to use.
 * @apiSince 14
 */

public java.lang.String getLanguage() { throw new RuntimeException("Stub!"); }

/**
 * Gets the ISO 3-letter country code for the language to use.
 * @apiSince 14
 */

public java.lang.String getCountry() { throw new RuntimeException("Stub!"); }

/**
 * Gets the language variant to use.
 * @apiSince 14
 */

public java.lang.String getVariant() { throw new RuntimeException("Stub!"); }

/**
 * Gets the speech rate to use. The normal rate is 100.
 * @apiSince 14
 */

public int getSpeechRate() { throw new RuntimeException("Stub!"); }

/**
 * Gets the pitch to use. The normal pitch is 100.
 * @apiSince 14
 */

public int getPitch() { throw new RuntimeException("Stub!"); }

/**
 * Gets the additional params, if any.
 * @apiSince 14
 */

public android.os.Bundle getParams() { throw new RuntimeException("Stub!"); }

/**
 * Gets the request caller Uid.
 * @apiSince 19
 */

public int getCallerUid() { throw new RuntimeException("Stub!"); }
}

