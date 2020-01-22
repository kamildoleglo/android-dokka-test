/*
 * Copyright (C) 2014 The Android Open Source Project
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

import android.os.Build;

/**
 * A class to encapsulate a collection of attributes describing information about an audio
 * stream.
 * <p><code>AudioAttributes</code> supersede the notion of stream types (see for instance
 * {@link android.media.AudioManager#STREAM_MUSIC AudioManager#STREAM_MUSIC} or {@link android.media.AudioManager#STREAM_ALARM AudioManager#STREAM_ALARM}) for defining the
 * behavior of audio playback. Attributes allow an application to specify more information than is
 * conveyed in a stream type by allowing the application to define:
 * <ul>
 * <li>usage: "why" you are playing a sound, what is this sound used for. This is achieved with
 *     the "usage" information. Examples of usage are {@link #USAGE_MEDIA} and {@link #USAGE_ALARM}.
 *     These two examples are the closest to stream types, but more detailed use cases are
 *     available. Usage information is more expressive than a stream type, and allows certain
 *     platforms or routing policies to use this information for more refined volume or routing
 *     decisions. Usage is the most important information to supply in <code>AudioAttributes</code>
 *     and it is recommended to build any instance with this information supplied, see
 *     {@link android.media.AudioAttributes.Builder AudioAttributes.Builder} for exceptions.</li>
 * <li>content type: "what" you are playing. The content type expresses the general category of
 *     the content. This information is optional. But in case it is known (for instance
 *     {@link #CONTENT_TYPE_MOVIE} for a movie streaming service or {@link #CONTENT_TYPE_MUSIC} for
 *     a music playback application) this information might be used by the audio framework to
 *     selectively configure some audio post-processing blocks.</li>
 * <li>flags: "how" is playback to be affected, see the flag definitions for the specific playback
 *     behaviors they control. </li>
 * </ul>
 * <p><code>AudioAttributes</code> are used for example in one of the {@link android.media.AudioTrack AudioTrack}
 * constructors (see {@link android.media.AudioTrack#AudioTrack(android.media.AudioAttributes,android.media.AudioFormat,int,int,int) AudioTrack#AudioTrack(AudioAttributes, AudioFormat, int, int, int)}),
 * to configure a {@link android.media.MediaPlayer MediaPlayer}
 * (see {@link android.media.MediaPlayer#setAudioAttributes(android.media.AudioAttributes) MediaPlayer#setAudioAttributes(AudioAttributes)} or a
 * {@link android.app.Notification} (see {@link android.app.Notification#audioAttributes}). An
 * <code>AudioAttributes</code> instance is built through its builder,
 * {@link android.media.AudioAttributes.Builder AudioAttributes.Builder}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class AudioAttributes implements android.os.Parcelable {

private AudioAttributes() { throw new RuntimeException("Stub!"); }

/**
 * Return the content type.
 * @return one of the values that can be set in {@link android.media.AudioAttributes.Builder#setContentType(int) Builder#setContentType(int)}
 * @apiSince 21
 */

public int getContentType() { throw new RuntimeException("Stub!"); }

/**
 * Return the usage.
 * @return one of the values that can be set in {@link android.media.AudioAttributes.Builder#setUsage(int) Builder#setUsage(int)}
 * @apiSince 21
 */

public int getUsage() { throw new RuntimeException("Stub!"); }

/**
 * Return the flags.
 * @return a combined mask of all flags
 * @apiSince 21
 */

public int getFlags() { throw new RuntimeException("Stub!"); }

/**
 * Return if haptic channels are muted.
 * @return {@code true} if haptic channels are muted, {@code false} otherwise.
 * @apiSince 29
 */

public boolean areHapticChannelsMuted() { throw new RuntimeException("Stub!"); }

/**
 * Return the capture policy.
 * @return the capture policy set by {@link android.media.AudioAttributes.Builder#setAllowedCapturePolicy(int) Builder#setAllowedCapturePolicy(int)} or
 *         the default if it was not called.
 
 * Value is {@link android.media.AudioAttributes#ALLOW_CAPTURE_BY_ALL}, {@link android.media.AudioAttributes#ALLOW_CAPTURE_BY_SYSTEM}, or {@link android.media.AudioAttributes#ALLOW_CAPTURE_BY_NONE}
 * @apiSince 29
 */

public int getAllowedCapturePolicy() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Returns the stream type matching this {@code AudioAttributes} instance for volume control.
 * Use this method to derive the stream type needed to configure the volume
 * control slider in an {@link android.app.Activity} with
 * {@link android.app.Activity#setVolumeControlStream(int)} for playback conducted with these
 * attributes.
 * <BR>Do not use this method to set the stream type on an audio player object
 * (e.g. {@link android.media.AudioTrack AudioTrack}, {@link android.media.MediaPlayer MediaPlayer}) as this is deprecated,
 * use {@code AudioAttributes} instead.
 * @return a valid stream type for {@code Activity} or stream volume control that matches
 *     the attributes, or {@link android.media.AudioManager#USE_DEFAULT_STREAM_TYPE AudioManager#USE_DEFAULT_STREAM_TYPE} if there isn't a direct
 *     match. Note that {@code USE_DEFAULT_STREAM_TYPE} is not a valid value
 *     for {@link android.media.AudioManager#setStreamVolume(int,int,int) AudioManager#setStreamVolume(int, int, int)}.
 * @apiSince 26
 */

public int getVolumeControlStream() { throw new RuntimeException("Stub!"); }

/**
 * Indicates that the audio may be captured by any app.
 *
 * For privacy, the following usages cannot be recorded: VOICE_COMMUNICATION*,
 * USAGE_NOTIFICATION*, USAGE_ASSISTANCE* and USAGE_ASSISTANT.
 *
 * On {@link android.os.Build.VERSION_CODES#Q}, this means only {@link #USAGE_UNKNOWN},
 * {@link #USAGE_MEDIA} and {@link #USAGE_GAME} may be captured.
 *
 * See {@link android.media.projection.MediaProjection} and
 * {@link android.media.AudioAttributes.Builder#setAllowedCapturePolicy Builder#setAllowedCapturePolicy}.
 * @apiSince 29
 */

public static final int ALLOW_CAPTURE_BY_ALL = 1; // 0x1

/**
 * Indicates that the audio is not to be recorded by any app, even if it is a system app.
 *
 * It is encouraged to use {@link #ALLOW_CAPTURE_BY_SYSTEM} instead of this value as system apps
 * provide significant and useful features for the user (such as live captioning
 * and accessibility).
 *
 * See {@link android.media.AudioAttributes.Builder#setAllowedCapturePolicy Builder#setAllowedCapturePolicy}.
 * @apiSince 29
 */

public static final int ALLOW_CAPTURE_BY_NONE = 3; // 0x3

/**
 * Indicates that the audio may only be captured by system apps.
 *
 * System apps can capture for many purposes like accessibility, live captions, user guidance...
 * but abide to the following restrictions:
 *  - the audio cannot leave the device
 *  - the audio cannot be passed to a third party app
 *  - the audio cannot be recorded at a higher quality than 16kHz 16bit mono
 *
 * See {@link android.media.AudioAttributes.Builder#setAllowedCapturePolicy Builder#setAllowedCapturePolicy}.
 * @apiSince 29
 */

public static final int ALLOW_CAPTURE_BY_SYSTEM = 2; // 0x2

/**
 * Content type value to use when the content type is a soundtrack, typically accompanying
 * a movie or TV program.
 * @apiSince 21
 */

public static final int CONTENT_TYPE_MOVIE = 3; // 0x3

/**
 * Content type value to use when the content type is music.
 * @apiSince 21
 */

public static final int CONTENT_TYPE_MUSIC = 2; // 0x2

/**
 * Content type value to use when the content type is a sound used to accompany a user
 * action, such as a beep or sound effect expressing a key click, or event, such as the
 * type of a sound for a bonus being received in a game. These sounds are mostly synthesized
 * or short Foley sounds.
 * @apiSince 21
 */

public static final int CONTENT_TYPE_SONIFICATION = 4; // 0x4

/**
 * Content type value to use when the content type is speech.
 * @apiSince 21
 */

public static final int CONTENT_TYPE_SPEECH = 1; // 0x1

/**
 * Content type value to use when the content type is unknown, or other than the ones defined.
 * @apiSince 21
 */

public static final int CONTENT_TYPE_UNKNOWN = 0; // 0x0

/** @apiSince 21 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.media.AudioAttributes> CREATOR;
static { CREATOR = null; }

/**
 * Flag defining a behavior where the audibility of the sound will be ensured by the system.
 * @apiSince 21
 */

public static final int FLAG_AUDIBILITY_ENFORCED = 1; // 0x1

/**
 * Flag requesting the use of an output stream supporting hardware A/V synchronization.
 * @apiSince 21
 */

public static final int FLAG_HW_AV_SYNC = 16; // 0x10

/**
 * Flag requesting a low latency path when creating an AudioTrack.
 * When using this flag, the sample rate must match the native sample rate
 * of the device. Effects processing is also unavailable.
 *
 * Note that if this flag is used without specifying a bufferSizeInBytes then the
 * AudioTrack's actual buffer size may be too small. It is recommended that a fairly
 * large buffer should be specified when the AudioTrack is created.
 * Then the actual size can be reduced by calling
 * {@link android.media.AudioTrack#setBufferSizeInFrames(int) AudioTrack#setBufferSizeInFrames(int)}. The buffer size can be optimized
 * by lowering it after each write() call until the audio glitches, which is detected by calling
 * {@link android.media.AudioTrack#getUnderrunCount() AudioTrack#getUnderrunCount()}. Then the buffer size can be increased
 * until there are no glitches.
 * This tuning step should be done while playing silence.
 * This technique provides a compromise between latency and glitch rate.
 *
 * @deprecated Use {@link android.media.AudioTrack.Builder#setPerformanceMode(int) AudioTrack.Builder#setPerformanceMode(int)} with
 * {@link android.media.AudioTrack#PERFORMANCE_MODE_LOW_LATENCY AudioTrack#PERFORMANCE_MODE_LOW_LATENCY} to control performance.
 * @apiSince 24
 * @deprecatedSince 26
 */

@Deprecated public static final int FLAG_LOW_LATENCY = 256; // 0x100

/**
 * Usage value to use when the usage is an alarm (e.g.&nbsp;wake-up alarm).
 * @apiSince 21
 */

public static final int USAGE_ALARM = 4; // 0x4

/**
 * Usage value to use when the usage is for accessibility, such as with
 * a screen reader.
 * @apiSince 21
 */

public static final int USAGE_ASSISTANCE_ACCESSIBILITY = 11; // 0xb

/**
 * Usage value to use when the usage is driving or navigation directions.
 * @apiSince 21
 */

public static final int USAGE_ASSISTANCE_NAVIGATION_GUIDANCE = 12; // 0xc

/**
 * Usage value to use when the usage is sonification, such as  with user
 * interface sounds.
 * @apiSince 21
 */

public static final int USAGE_ASSISTANCE_SONIFICATION = 13; // 0xd

/**
 * Usage value to use for audio responses to user queries, audio instructions or help
 * utterances.
 * @apiSince 26
 */

public static final int USAGE_ASSISTANT = 16; // 0x10

/**
 * Usage value to use when the usage is for game audio.
 * @apiSince 21
 */

public static final int USAGE_GAME = 14; // 0xe

/**
 * Usage value to use when the usage is media, such as music, or movie
 * soundtracks.
 * @apiSince 21
 */

public static final int USAGE_MEDIA = 1; // 0x1

/**
 * Usage value to use when the usage is notification. See other
 * notification usages for more specialized uses.
 * @apiSince 21
 */

public static final int USAGE_NOTIFICATION = 5; // 0x5

/**
 * Usage value to use when the usage is notification for a
 * non-immediate type of communication such as e-mail.
 * @apiSince 21
 */

public static final int USAGE_NOTIFICATION_COMMUNICATION_DELAYED = 9; // 0x9

/**
 * Usage value to use when the usage is notification for an "instant"
 * communication such as a chat, or SMS.
 * @apiSince 21
 */

public static final int USAGE_NOTIFICATION_COMMUNICATION_INSTANT = 8; // 0x8

/**
 * Usage value to use when the usage is a request to enter/end a
 * communication, such as a VoIP communication or video-conference.
 * @apiSince 21
 */

public static final int USAGE_NOTIFICATION_COMMUNICATION_REQUEST = 7; // 0x7

/**
 * Usage value to use when the usage is to attract the user's attention,
 * such as a reminder or low battery warning.
 * @apiSince 21
 */

public static final int USAGE_NOTIFICATION_EVENT = 10; // 0xa

/**
 * Usage value to use when the usage is telephony ringtone.
 * @apiSince 21
 */

public static final int USAGE_NOTIFICATION_RINGTONE = 6; // 0x6

/**
 * Usage value to use when the usage is unknown.
 * @apiSince 21
 */

public static final int USAGE_UNKNOWN = 0; // 0x0

/**
 * Usage value to use when the usage is voice communications, such as telephony
 * or VoIP.
 * @apiSince 21
 */

public static final int USAGE_VOICE_COMMUNICATION = 2; // 0x2

/**
 * Usage value to use when the usage is in-call signalling, such as with
 * a "busy" beep, or DTMF tones.
 * @apiSince 21
 */

public static final int USAGE_VOICE_COMMUNICATION_SIGNALLING = 3; // 0x3
/**
 * Builder class for {@link android.media.AudioAttributes AudioAttributes} objects.
 * <p> Here is an example where <code>Builder</code> is used to define the
 * {@link android.media.AudioAttributes AudioAttributes} to be used by a new <code>AudioTrack</code> instance:
 *
 * <pre class="prettyprint">
 * AudioTrack myTrack = new AudioTrack(
 *         new AudioAttributes.Builder()
 *             .setUsage(AudioAttributes.USAGE_MEDIA)
 *             .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
 *             .build(),
 *         myFormat, myBuffSize, AudioTrack.MODE_STREAM, mySession);
 * </pre>
 *
 * <p>By default all types of information (usage, content type, flags) conveyed by an
 * <code>AudioAttributes</code> instance are set to "unknown". Unknown information will be
 * interpreted as a default value that is dependent on the context of use, for instance a
 * {@link android.media.MediaPlayer MediaPlayer} will use a default usage of {@link android.media.AudioAttributes#USAGE_MEDIA AudioAttributes#USAGE_MEDIA}.
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

/**
 * Constructs a new Builder with the defaults.
 * By default, usage and content type are respectively {@link android.media.AudioAttributes#USAGE_UNKNOWN AudioAttributes#USAGE_UNKNOWN}
 * and {@link android.media.AudioAttributes#CONTENT_TYPE_UNKNOWN AudioAttributes#CONTENT_TYPE_UNKNOWN}, and flags are 0. It is recommended to
 * configure the usage (with {@link #setUsage(int)}) or deriving attributes from a legacy
 * stream type (with {@link #setLegacyStreamType(int)}) before calling {@link #build()}
 * to override any default playback behavior in terms of routing and volume management.
 * @apiSince 21
 */

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new Builder from a given AudioAttributes
 * @param aa the AudioAttributes object whose data will be reused in the new Builder.
 * @apiSince 21
 */

public Builder(android.media.AudioAttributes aa) { throw new RuntimeException("Stub!"); }

/**
 * Combines all of the attributes that have been set and return a new
 * {@link android.media.AudioAttributes AudioAttributes} object.
 * @return a new {@link android.media.AudioAttributes AudioAttributes} object
 * @apiSince 21
 */

public android.media.AudioAttributes build() { throw new RuntimeException("Stub!"); }

/**
 * Sets the attribute describing what is the intended use of the the audio signal,
 * such as alarm or ringtone.
 * @param usage one of {@link android.media.AudioAttributes#USAGE_UNKNOWN AudioAttributes#USAGE_UNKNOWN},
 *     {@link android.media.AudioAttributes#USAGE_MEDIA AudioAttributes#USAGE_MEDIA},
 *     {@link android.media.AudioAttributes#USAGE_VOICE_COMMUNICATION AudioAttributes#USAGE_VOICE_COMMUNICATION},
 *     {@link android.media.AudioAttributes#USAGE_VOICE_COMMUNICATION_SIGNALLING AudioAttributes#USAGE_VOICE_COMMUNICATION_SIGNALLING},
 *     {@link android.media.AudioAttributes#USAGE_ALARM AudioAttributes#USAGE_ALARM}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION AudioAttributes#USAGE_NOTIFICATION},
 *     {@link android.media.AudioAttributes#USAGE_NOTIFICATION_RINGTONE AudioAttributes#USAGE_NOTIFICATION_RINGTONE},
 *     {@link android.media.AudioAttributes#USAGE_NOTIFICATION_COMMUNICATION_REQUEST AudioAttributes#USAGE_NOTIFICATION_COMMUNICATION_REQUEST},
 *     {@link android.media.AudioAttributes#USAGE_NOTIFICATION_COMMUNICATION_INSTANT AudioAttributes#USAGE_NOTIFICATION_COMMUNICATION_INSTANT},
 *     {@link android.media.AudioAttributes#USAGE_NOTIFICATION_COMMUNICATION_DELAYED AudioAttributes#USAGE_NOTIFICATION_COMMUNICATION_DELAYED},
 *     {@link android.media.AudioAttributes#USAGE_NOTIFICATION_EVENT AudioAttributes#USAGE_NOTIFICATION_EVENT},
 *     {@link android.media.AudioAttributes#USAGE_ASSISTANT AudioAttributes#USAGE_ASSISTANT},
 *     {@link android.media.AudioAttributes#USAGE_ASSISTANCE_ACCESSIBILITY AudioAttributes#USAGE_ASSISTANCE_ACCESSIBILITY},
 *     {@link android.media.AudioAttributes#USAGE_ASSISTANCE_NAVIGATION_GUIDANCE AudioAttributes#USAGE_ASSISTANCE_NAVIGATION_GUIDANCE},
 *     {@link android.media.AudioAttributes#USAGE_ASSISTANCE_SONIFICATION AudioAttributes#USAGE_ASSISTANCE_SONIFICATION},
 *     {@link android.media.AudioAttributes#USAGE_GAME AudioAttributes#USAGE_GAME}.
 * Value is {@link android.media.AudioAttributes#USAGE_UNKNOWN}, {@link android.media.AudioAttributes#USAGE_MEDIA}, {@link android.media.AudioAttributes#USAGE_VOICE_COMMUNICATION}, {@link android.media.AudioAttributes#USAGE_VOICE_COMMUNICATION_SIGNALLING}, {@link android.media.AudioAttributes#USAGE_ALARM}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION_RINGTONE}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION_COMMUNICATION_REQUEST}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION_COMMUNICATION_INSTANT}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION_COMMUNICATION_DELAYED}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION_EVENT}, {@link android.media.AudioAttributes#USAGE_ASSISTANCE_ACCESSIBILITY}, {@link android.media.AudioAttributes#USAGE_ASSISTANCE_NAVIGATION_GUIDANCE}, {@link android.media.AudioAttributes#USAGE_ASSISTANCE_SONIFICATION}, {@link android.media.AudioAttributes#USAGE_GAME}, or {@link android.media.AudioAttributes#USAGE_ASSISTANT}
 * @return the same Builder instance.
 * @apiSince 21
 */

public android.media.AudioAttributes.Builder setUsage(int usage) { throw new RuntimeException("Stub!"); }

/**
 * Sets the attribute describing the content type of the audio signal, such as speech,
 * or music.
 * @param contentType the content type values, one of
 *     {@link android.media.AudioAttributes#CONTENT_TYPE_MOVIE AudioAttributes#CONTENT_TYPE_MOVIE},
 *     {@link android.media.AudioAttributes#CONTENT_TYPE_MUSIC AudioAttributes#CONTENT_TYPE_MUSIC},
 *     {@link android.media.AudioAttributes#CONTENT_TYPE_SONIFICATION AudioAttributes#CONTENT_TYPE_SONIFICATION},
 *     {@link android.media.AudioAttributes#CONTENT_TYPE_SPEECH AudioAttributes#CONTENT_TYPE_SPEECH},
 *     {@link android.media.AudioAttributes#CONTENT_TYPE_UNKNOWN AudioAttributes#CONTENT_TYPE_UNKNOWN}.
 * Value is {@link android.media.AudioAttributes#CONTENT_TYPE_UNKNOWN}, {@link android.media.AudioAttributes#CONTENT_TYPE_SPEECH}, {@link android.media.AudioAttributes#CONTENT_TYPE_MUSIC}, {@link android.media.AudioAttributes#CONTENT_TYPE_MOVIE}, or {@link android.media.AudioAttributes#CONTENT_TYPE_SONIFICATION}
 * @return the same Builder instance.
 * @apiSince 21
 */

public android.media.AudioAttributes.Builder setContentType(int contentType) { throw new RuntimeException("Stub!"); }

/**
 * Sets the combination of flags.
 *
 * This is a bitwise OR with the existing flags.
 * @param flags a combination of {@link android.media.AudioAttributes#FLAG_AUDIBILITY_ENFORCED AudioAttributes#FLAG_AUDIBILITY_ENFORCED},
 *    {@link android.media.AudioAttributes#FLAG_HW_AV_SYNC AudioAttributes#FLAG_HW_AV_SYNC}.
 * @return the same Builder instance.
 * @apiSince 21
 */

public android.media.AudioAttributes.Builder setFlags(int flags) { throw new RuntimeException("Stub!"); }

/**
 * Specifies whether the audio may or may not be captured by other apps or the system.
 *
 * The default is {@link android.media.AudioAttributes#ALLOW_CAPTURE_BY_ALL AudioAttributes#ALLOW_CAPTURE_BY_ALL}.
 *
 * There are multiple ways to set this policy:
 * <ul>
 * <li> for each track independently, with this method </li>
 * <li> application-wide at runtime, with
 *      {@link android.media.AudioManager#setAllowedCapturePolicy(int) AudioManager#setAllowedCapturePolicy(int)} </li>
 * <li> application-wide at build time, see {@code allowAudioPlaybackCapture} in the
 *      application manifest. </li>
 * </ul>
 * The most restrictive policy is always applied.
 *
 * See {@link android.media.AudioPlaybackCaptureConfiguration AudioPlaybackCaptureConfiguration} for more details on
 * which audio signals can be captured.
 *
 * @param capturePolicy Value is {@link android.media.AudioAttributes#ALLOW_CAPTURE_BY_ALL}, {@link android.media.AudioAttributes#ALLOW_CAPTURE_BY_SYSTEM}, or {@link android.media.AudioAttributes#ALLOW_CAPTURE_BY_NONE}
 * @return the same Builder instance
 * This value will never be {@code null}.
 * @throws java.lang.IllegalArgumentException if the argument is not a valid value.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.media.AudioAttributes.Builder setAllowedCapturePolicy(int capturePolicy) { throw new RuntimeException("Stub!"); }

/**
 * Sets attributes as inferred from the legacy stream types.
 * Warning: do not use this method in combination with setting any other attributes such as
 * usage, content type, flags or haptic control, as this method will overwrite (the more
 * accurate) information describing the use case previously set in the <code>Builder</code>.
 * In general, avoid using it and prefer setting usage and content type directly
 * with {@link #setUsage(int)} and {@link #setContentType(int)}.
 * <p>Use this method when building an {@link android.media.AudioAttributes AudioAttributes} instance to initialize some
 * of the attributes by information derived from a legacy stream type.
 * @param streamType one of {@link android.media.AudioManager#STREAM_VOICE_CALL AudioManager#STREAM_VOICE_CALL},
 *   {@link android.media.AudioManager#STREAM_SYSTEM AudioManager#STREAM_SYSTEM}, {@link android.media.AudioManager#STREAM_RING AudioManager#STREAM_RING},
 *   {@link android.media.AudioManager#STREAM_MUSIC AudioManager#STREAM_MUSIC}, {@link android.media.AudioManager#STREAM_ALARM AudioManager#STREAM_ALARM},
 *    or {@link android.media.AudioManager#STREAM_NOTIFICATION AudioManager#STREAM_NOTIFICATION}.
 * @return the same Builder instance.
 * @apiSince 21
 */

public android.media.AudioAttributes.Builder setLegacyStreamType(int streamType) { throw new RuntimeException("Stub!"); }

/**
 * Specifying if haptic should be muted or not when playing audio-haptic coupled data.
 * By default, haptic channels are disabled.
 * @param muted true to force muting haptic channels.
 * @return the same Builder instance.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.media.AudioAttributes.Builder setHapticChannelsMuted(boolean muted) { throw new RuntimeException("Stub!"); }
}

}

