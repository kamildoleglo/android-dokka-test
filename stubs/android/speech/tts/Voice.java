/*
 * Copyright (C) 2014 The Android Open Source Project
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

import java.util.Set;

/**
 * Characteristics and features of a Text-To-Speech Voice. Each TTS Engine can expose
 * multiple voices for each locale, with different set of features.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Voice implements android.os.Parcelable {

/** @apiSince 21 */

public Voice(java.lang.String name, java.util.Locale locale, int quality, int latency, boolean requiresNetworkConnection, java.util.Set<java.lang.String> features) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * @return The voice's locale
 * @apiSince 21
 */

public java.util.Locale getLocale() { throw new RuntimeException("Stub!"); }

/**
 * @return The voice's quality (higher is better)
 * @see #QUALITY_VERY_HIGH
 * @see #QUALITY_HIGH
 * @see #QUALITY_NORMAL
 * @see #QUALITY_LOW
 * @see #QUALITY_VERY_LOW
 * @apiSince 21
 */

public int getQuality() { throw new RuntimeException("Stub!"); }

/**
 * @return The voice's latency (lower is better)
 * @see #LATENCY_VERY_LOW
 * @see #LATENCY_LOW
 * @see #LATENCY_NORMAL
 * @see #LATENCY_HIGH
 * @see #LATENCY_VERY_HIGH
 * @apiSince 21
 */

public int getLatency() { throw new RuntimeException("Stub!"); }

/**
 * @return Does the Voice require a network connection to work.
 * @apiSince 21
 */

public boolean isNetworkConnectionRequired() { throw new RuntimeException("Stub!"); }

/**
 * @return Unique voice name.
 * @apiSince 21
 */

public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the set of features it supports for a given voice.
 * Features can either be framework defined, e.g.
 * {@link android.speech.tts.TextToSpeech.Engine#KEY_FEATURE_NETWORK_TIMEOUT_MS TextToSpeech.Engine#KEY_FEATURE_NETWORK_TIMEOUT_MS} or engine specific.
 * Engine specific keys must be prefixed by the name of the engine they
 * are intended for. These keys can be used as parameters to
 * {@link android.speech.tts.TextToSpeech#speak(java.lang.String,int,java.util.HashMap) TextToSpeech#speak(String, int, java.util.HashMap)} and
 * {@link android.speech.tts.TextToSpeech#synthesizeToFile(java.lang.String,java.util.HashMap,java.lang.String) TextToSpeech#synthesizeToFile(String, java.util.HashMap, String)}.
 *
 * Features values are strings and their values must met restrictions described in their
 * documentation.
 *
 * @return Set instance. May return {@code null} on error.
 * @apiSince 21
 */

public java.util.Set<java.lang.String> getFeatures() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.speech.tts.Voice> CREATOR;
static { CREATOR = null; }

/**
 * Network based expected synthesizer latency (~200ms)
 * @apiSince 21
 */

public static final int LATENCY_HIGH = 400; // 0x190

/**
 * Low expected synthesizer latency (~20ms)
 * @apiSince 21
 */

public static final int LATENCY_LOW = 200; // 0xc8

/**
 * Normal expected synthesizer latency (~50ms)
 * @apiSince 21
 */

public static final int LATENCY_NORMAL = 300; // 0x12c

/**
 * Very slow network based expected synthesizer latency (> 200ms)
 * @apiSince 21
 */

public static final int LATENCY_VERY_HIGH = 500; // 0x1f4

/**
 * Very low expected synthesizer latency (< 20ms)
 * @apiSince 21
 */

public static final int LATENCY_VERY_LOW = 100; // 0x64

/**
 * High, human-like quality of speech synthesis
 * @apiSince 21
 */

public static final int QUALITY_HIGH = 400; // 0x190

/**
 * Low, not human-like quality of speech synthesis
 * @apiSince 21
 */

public static final int QUALITY_LOW = 200; // 0xc8

/**
 * Normal quality of speech synthesis
 * @apiSince 21
 */

public static final int QUALITY_NORMAL = 300; // 0x12c

/**
 * Very high, almost human-indistinguishable quality of speech synthesis
 * @apiSince 21
 */

public static final int QUALITY_VERY_HIGH = 500; // 0x1f4

/**
 * Very low, but still intelligible quality of speech synthesis
 * @apiSince 21
 */

public static final int QUALITY_VERY_LOW = 100; // 0x64
}

