/*
 * Copyright (C) 2018 The Android Open Source Project
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


package android.media;

import java.util.Locale;

/**
 * The AudioPresentation class encapsulates the information that describes an audio presentation
 * which is available in next generation audio content.
 *
 * Used by {@link android.media.MediaExtractor MediaExtractor} {@link android.media.MediaExtractor#getAudioPresentations(int) MediaExtractor#getAudioPresentations(int)} and
 * {@link android.media.AudioTrack AudioTrack} {@link android.media.AudioTrack#setPresentation(android.media.AudioPresentation) AudioTrack#setPresentation(AudioPresentation)} to query available
 * presentations and to select one, respectively.
 *
 * A list of available audio presentations in a media source can be queried using
 * {@link android.media.MediaExtractor#getAudioPresentations(int) MediaExtractor#getAudioPresentations(int)}. This list can be presented to a user for
 * selection.
 * An AudioPresentation can be passed to an offloaded audio decoder via
 * {@link android.media.AudioTrack#setPresentation(android.media.AudioPresentation) AudioTrack#setPresentation(AudioPresentation)} to request decoding of the selected
 * presentation. An audio stream may contain multiple presentations that differ by language,
 * accessibility, end point mastering and dialogue enhancement. An audio presentation may also have
 * a set of description labels in different languages to help the user to make an informed
 * selection.
 *
 * Applications that parse media streams and extract presentation information on their own
 * can create instances of AudioPresentation by using {@link android.media.AudioPresentation.Builder AudioPresentation.Builder} class.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class AudioPresentation {

private AudioPresentation() { throw new RuntimeException("Stub!"); }

/**
 * Returns presentation ID used by the framework to select an audio presentation rendered by a
 * decoder. Presentation ID is typically sequential, but does not have to be.
 * @apiSince 29
 */

public int getPresentationId() { throw new RuntimeException("Stub!"); }

/**
 * Returns program ID used by the framework to select an audio presentation rendered by a
 * decoder. Program ID can be used to further uniquely identify the presentation to a decoder.
 * @apiSince 29
 */

public int getProgramId() { throw new RuntimeException("Stub!"); }

/**
 * @return a map of available text labels for this presentation. Each label is indexed by its
 * locale corresponding to the language code as specified by ISO 639-2. Either ISO 639-2/B
 * or ISO 639-2/T could be used.
 * @apiSince 28
 */

public java.util.Map<java.util.Locale,java.lang.String> getLabels() { throw new RuntimeException("Stub!"); }

/**
 * @return the locale corresponding to audio presentation's ISO 639-1/639-2 language code.
 * @apiSince 28
 */

public java.util.Locale getLocale() { throw new RuntimeException("Stub!"); }

/**
 * @return the mastering indication of the audio presentation.
 * See {@link android.media.AudioPresentation#MASTERING_NOT_INDICATED AudioPresentation#MASTERING_NOT_INDICATED},
 *     {@link android.media.AudioPresentation#MASTERED_FOR_STEREO AudioPresentation#MASTERED_FOR_STEREO},
 *     {@link android.media.AudioPresentation#MASTERED_FOR_SURROUND AudioPresentation#MASTERED_FOR_SURROUND},
 *     {@link android.media.AudioPresentation#MASTERED_FOR_3D AudioPresentation#MASTERED_FOR_3D},
 *     {@link android.media.AudioPresentation#MASTERED_FOR_HEADPHONE AudioPresentation#MASTERED_FOR_HEADPHONE}
 
 * Value is {@link android.media.AudioPresentation#MASTERING_NOT_INDICATED}, {@link android.media.AudioPresentation#MASTERED_FOR_STEREO}, {@link android.media.AudioPresentation#MASTERED_FOR_SURROUND}, {@link android.media.AudioPresentation#MASTERED_FOR_3D}, or {@link android.media.AudioPresentation#MASTERED_FOR_HEADPHONE}
 * @apiSince 28
 */

public int getMasteringIndication() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether an audio description for the visually impaired is available.
 * @return {@code true} if audio description is available.
 * @apiSince 28
 */

public boolean hasAudioDescription() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether spoken subtitles for the visually impaired are available.
 * @return {@code true} if spoken subtitles are available.
 * @apiSince 28
 */

public boolean hasSpokenSubtitles() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether dialogue enhancement is available.
 * @return {@code true} if dialogue enhancement is available.
 * @apiSince 28
 */

public boolean hasDialogueEnhancement() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Three-dimensional (e.g.&nbsp;5.1.2) speaker layout.
 *
 * @see android.media.AudioPresentation.Builder#setMasteringIndication(int)
 * @apiSince 28
 */

public static final int MASTERED_FOR_3D = 3; // 0x3

/**
 * Prerendered for headphone playback.
 *
 * @see android.media.AudioPresentation.Builder#setMasteringIndication(int)
 * @apiSince 28
 */

public static final int MASTERED_FOR_HEADPHONE = 4; // 0x4

/**
 * Stereo speaker layout.
 *
 * @see android.media.AudioPresentation.Builder#setMasteringIndication(int)
 * @apiSince 28
 */

public static final int MASTERED_FOR_STEREO = 1; // 0x1

/**
 * Two-dimensional (e.g.&nbsp;5.1) speaker layout.
 *
 * @see android.media.AudioPresentation.Builder#setMasteringIndication(int)
 * @apiSince 28
 */

public static final int MASTERED_FOR_SURROUND = 2; // 0x2

/**
 * No preferred reproduction channel layout.
 *
 * @see android.media.AudioPresentation.Builder#setMasteringIndication(int)
 * @apiSince 28
 */

public static final int MASTERING_NOT_INDICATED = 0; // 0x0
/**
 * A builder class for creating {@link android.media.AudioPresentation AudioPresentation} objects.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Create a {@link android.media.AudioPresentation.Builder Builder}. Any field that should be included in the
 * {@link android.media.AudioPresentation AudioPresentation} must be added.
 *
 * @param presentationId The presentation ID of this audio presentation.
 * @apiSince 29
 */

public Builder(int presentationId) { throw new RuntimeException("Stub!"); }

/**
 * Sets the ProgramId to which this audio presentation refers.
 *
 * @param programId The program ID to be decoded.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.media.AudioPresentation.Builder setProgramId(int programId) { throw new RuntimeException("Stub!"); }

/**
 * Sets the language information of the audio presentation.
 *
 * @param language Locale corresponding to ISO 639-1/639-2 language code.
 
 * This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.media.AudioPresentation.Builder setLocale(@androidx.annotation.NonNull android.icu.util.ULocale language) { throw new RuntimeException("Stub!"); }

/**
 * Sets the mastering indication.
 *
 * @param masteringIndication Input to set mastering indication.
 * Value is {@link android.media.AudioPresentation#MASTERING_NOT_INDICATED}, {@link android.media.AudioPresentation#MASTERED_FOR_STEREO}, {@link android.media.AudioPresentation#MASTERED_FOR_SURROUND}, {@link android.media.AudioPresentation#MASTERED_FOR_3D}, or {@link android.media.AudioPresentation#MASTERED_FOR_HEADPHONE}
 * @throws java.lang.IllegalArgumentException if the mastering indication is not any of
 * {@link android.media.AudioPresentation#MASTERING_NOT_INDICATED AudioPresentation#MASTERING_NOT_INDICATED},
 * {@link android.media.AudioPresentation#MASTERED_FOR_STEREO AudioPresentation#MASTERED_FOR_STEREO},
 * {@link android.media.AudioPresentation#MASTERED_FOR_SURROUND AudioPresentation#MASTERED_FOR_SURROUND},
 * {@link android.media.AudioPresentation#MASTERED_FOR_3D AudioPresentation#MASTERED_FOR_3D},
 * and {@link android.media.AudioPresentation#MASTERED_FOR_HEADPHONE AudioPresentation#MASTERED_FOR_HEADPHONE}
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.media.AudioPresentation.Builder setMasteringIndication(int masteringIndication) { throw new RuntimeException("Stub!"); }

/**
 * Sets locale / text label pairs describing the presentation.
 *
 * @param labels Text label indexed by its locale corresponding to the language code.
 
 * This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.media.AudioPresentation.Builder setLabels(@androidx.annotation.NonNull java.util.Map<android.icu.util.ULocale,java.lang.CharSequence> labels) { throw new RuntimeException("Stub!"); }

/**
 * Indicate whether the presentation contains audio description for the visually impaired.
 *
 * @param audioDescriptionAvailable Audio description for the visually impaired.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.media.AudioPresentation.Builder setHasAudioDescription(boolean audioDescriptionAvailable) { throw new RuntimeException("Stub!"); }

/**
 * Indicate whether the presentation contains spoken subtitles for the visually impaired.
 *
 * @param spokenSubtitlesAvailable Spoken subtitles for the visually impaired.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.media.AudioPresentation.Builder setHasSpokenSubtitles(boolean spokenSubtitlesAvailable) { throw new RuntimeException("Stub!"); }

/**
 * Indicate whether the presentation supports dialogue enhancement.
 *
 * @param dialogueEnhancementAvailable Dialogue enhancement.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.media.AudioPresentation.Builder setHasDialogueEnhancement(boolean dialogueEnhancementAvailable) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link android.media.AudioPresentation AudioPresentation} instance with the specified fields.
 *
 * @return The new {@link android.media.AudioPresentation AudioPresentation} instance
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.media.AudioPresentation build() { throw new RuntimeException("Stub!"); }
}

}

