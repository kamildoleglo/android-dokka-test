/*
 * Copyright (C) 2019 The Android Open Source Project
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

import android.media.projection.MediaProjection;

/**
 * Configuration for capturing audio played by other apps.
 *
 *  When capturing audio signals played by other apps (and yours),
 *  you will only capture a mix of the audio signals played by players
 *  (such as AudioTrack or MediaPlayer) which present the following characteristics:
 *  <ul>
 *  <li> the usage value MUST be {@link android.media.AudioAttributes#USAGE_UNKNOWN AudioAttributes#USAGE_UNKNOWN} or
 *       {@link android.media.AudioAttributes#USAGE_GAME AudioAttributes#USAGE_GAME}
 *       or {@link android.media.AudioAttributes#USAGE_MEDIA AudioAttributes#USAGE_MEDIA}. All other usages CAN NOT be captured. </li>
 *  <li> AND the capture policy set by their app (with {@link android.media.AudioManager#setAllowedCapturePolicy AudioManager#setAllowedCapturePolicy})
 *       or on each player (with {@link android.media.AudioAttributes.Builder#setAllowedCapturePolicy AudioAttributes.Builder#setAllowedCapturePolicy}) is
 *       {@link android.media.AudioAttributes#ALLOW_CAPTURE_BY_ALL AudioAttributes#ALLOW_CAPTURE_BY_ALL}, whichever is the most strict. </li>
 *  <li> AND their app attribute allowAudioPlaybackCapture in their manifest
 *       MUST either be: <ul>
 *       <li> set to "true" </li>
 *       <li> not set, and their {@code targetSdkVersion} MUST be equal to or greater than
 *            {@link android.os.Build.VERSION_CODES#Q}.
 *            Ie. Apps that do not target at least Android Q must explicitly opt-in to be captured
 *            by a MediaProjection. </li></ul>
 *  <li> AND their apps MUST be in the same user profile as your app
 *       (eg work profile cannot capture user profile apps and vice-versa). </li>
 *  </ul>
 *
 * <p>An example for creating a capture configuration for capturing all media playback:
 *
 * <pre>
 *     MediaProjection mediaProjection;
 *     // Retrieve a audio capable projection from the MediaProjectionManager
 *     AudioPlaybackCaptureConfiguration config =
 *         new AudioPlaybackCaptureConfiguration.Builder(mediaProjection)
 *         .addMatchingUsage(AudioAttributes.USAGE_MEDIA)
 *         .build();
 *     AudioRecord record = new AudioRecord.Builder()
 *         .setAudioPlaybackCaptureConfig(config)
 *         .build();
 * </pre>
 *
 * @see android.media.AudioPlaybackCaptureConfiguration.Builder
 * @see android.media.projection.MediaProjectionManager#getMediaProjection(int, Intent)
 * @see android.media.AudioRecord.Builder#setAudioPlaybackCaptureConfig(AudioPlaybackCaptureConfiguration)
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class AudioPlaybackCaptureConfiguration {

private AudioPlaybackCaptureConfiguration() { throw new RuntimeException("Stub!"); }

/**
 * @return the {@code MediaProjection} used to build this object.
 * This value will never be {@code null}.
 * @see android.media.AudioPlaybackCaptureConfiguration.Builder#Builder(MediaProjection)
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.media.projection.MediaProjection getMediaProjection() { throw new RuntimeException("Stub!"); }

/**
 * @return the usages passed to {@link android.media.AudioPlaybackCaptureConfiguration.Builder#addMatchingUsage(int) Builder#addMatchingUsage(int)}.
 * Value is {@link android.media.AudioAttributes#USAGE_UNKNOWN}, {@link android.media.AudioAttributes#USAGE_MEDIA}, {@link android.media.AudioAttributes#USAGE_VOICE_COMMUNICATION}, {@link android.media.AudioAttributes#USAGE_VOICE_COMMUNICATION_SIGNALLING}, {@link android.media.AudioAttributes#USAGE_ALARM}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION_RINGTONE}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION_COMMUNICATION_REQUEST}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION_COMMUNICATION_INSTANT}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION_COMMUNICATION_DELAYED}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION_EVENT}, {@link android.media.AudioAttributes#USAGE_ASSISTANCE_ACCESSIBILITY}, {@link android.media.AudioAttributes#USAGE_ASSISTANCE_NAVIGATION_GUIDANCE}, {@link android.media.AudioAttributes#USAGE_ASSISTANCE_SONIFICATION}, {@link android.media.AudioAttributes#USAGE_GAME}, or {@link android.media.AudioAttributes#USAGE_ASSISTANT}
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public int[] getMatchingUsages() { throw new RuntimeException("Stub!"); }

/**
 * @return the UIDs passed to {@link android.media.AudioPlaybackCaptureConfiguration.Builder#addMatchingUid(int) Builder#addMatchingUid(int)}.
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public int[] getMatchingUids() { throw new RuntimeException("Stub!"); }

/**
 * @return the usages passed to {@link android.media.AudioPlaybackCaptureConfiguration.Builder#excludeUsage(int) Builder#excludeUsage(int)}.
 * Value is {@link android.media.AudioAttributes#USAGE_UNKNOWN}, {@link android.media.AudioAttributes#USAGE_MEDIA}, {@link android.media.AudioAttributes#USAGE_VOICE_COMMUNICATION}, {@link android.media.AudioAttributes#USAGE_VOICE_COMMUNICATION_SIGNALLING}, {@link android.media.AudioAttributes#USAGE_ALARM}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION_RINGTONE}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION_COMMUNICATION_REQUEST}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION_COMMUNICATION_INSTANT}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION_COMMUNICATION_DELAYED}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION_EVENT}, {@link android.media.AudioAttributes#USAGE_ASSISTANCE_ACCESSIBILITY}, {@link android.media.AudioAttributes#USAGE_ASSISTANCE_NAVIGATION_GUIDANCE}, {@link android.media.AudioAttributes#USAGE_ASSISTANCE_SONIFICATION}, {@link android.media.AudioAttributes#USAGE_GAME}, or {@link android.media.AudioAttributes#USAGE_ASSISTANT}
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public int[] getExcludeUsages() { throw new RuntimeException("Stub!"); }

/**
 * @return the UIDs passed to {@link android.media.AudioPlaybackCaptureConfiguration.Builder#excludeUid(int) Builder#excludeUid(int)}.
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public int[] getExcludeUids() { throw new RuntimeException("Stub!"); }
/**
 * Builder for creating {@link android.media.AudioPlaybackCaptureConfiguration AudioPlaybackCaptureConfiguration} instances.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * @param projection A MediaProjection that supports audio projection.
 * This value must never be {@code null}.
 * @apiSince 29
 */

public Builder(@androidx.annotation.NonNull android.media.projection.MediaProjection projection) { throw new RuntimeException("Stub!"); }

/**
 * Only capture audio output with the given {@link android.media.AudioAttributes AudioAttributes}.
 *
 * <p>If called multiple times, will capture audio output that matches any of the given
 * attributes.
 *
 * @throws java.lang.IllegalStateException if called in conjunction with
 *     {@link #excludeUsage(int)}.
 
 * @param usage Value is {@link android.media.AudioAttributes#USAGE_UNKNOWN}, {@link android.media.AudioAttributes#USAGE_MEDIA}, {@link android.media.AudioAttributes#USAGE_VOICE_COMMUNICATION}, {@link android.media.AudioAttributes#USAGE_VOICE_COMMUNICATION_SIGNALLING}, {@link android.media.AudioAttributes#USAGE_ALARM}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION_RINGTONE}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION_COMMUNICATION_REQUEST}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION_COMMUNICATION_INSTANT}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION_COMMUNICATION_DELAYED}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION_EVENT}, {@link android.media.AudioAttributes#USAGE_ASSISTANCE_ACCESSIBILITY}, {@link android.media.AudioAttributes#USAGE_ASSISTANCE_NAVIGATION_GUIDANCE}, {@link android.media.AudioAttributes#USAGE_ASSISTANCE_SONIFICATION}, {@link android.media.AudioAttributes#USAGE_GAME}, or {@link android.media.AudioAttributes#USAGE_ASSISTANT}
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.media.AudioPlaybackCaptureConfiguration.Builder addMatchingUsage(int usage) { throw new RuntimeException("Stub!"); }

/**
 * Only capture audio output by app with the matching {@code uid}.
 *
 * <p>If called multiple times, will capture audio output by apps whose uid is any of the
 * given uids.
 *
 * @throws java.lang.IllegalStateException if called in conjunction with {@link #excludeUid(int)}.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.media.AudioPlaybackCaptureConfiguration.Builder addMatchingUid(int uid) { throw new RuntimeException("Stub!"); }

/**
 * Only capture audio output that does not match the given {@link android.media.AudioAttributes AudioAttributes}.
 *
 * <p>If called multiple times, will capture audio output that does not match any of the
 * given attributes.
 *
 * @throws java.lang.IllegalStateException if called in conjunction with
 *     {@link #addMatchingUsage(int)}.
 
 * @param usage Value is {@link android.media.AudioAttributes#USAGE_UNKNOWN}, {@link android.media.AudioAttributes#USAGE_MEDIA}, {@link android.media.AudioAttributes#USAGE_VOICE_COMMUNICATION}, {@link android.media.AudioAttributes#USAGE_VOICE_COMMUNICATION_SIGNALLING}, {@link android.media.AudioAttributes#USAGE_ALARM}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION_RINGTONE}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION_COMMUNICATION_REQUEST}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION_COMMUNICATION_INSTANT}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION_COMMUNICATION_DELAYED}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION_EVENT}, {@link android.media.AudioAttributes#USAGE_ASSISTANCE_ACCESSIBILITY}, {@link android.media.AudioAttributes#USAGE_ASSISTANCE_NAVIGATION_GUIDANCE}, {@link android.media.AudioAttributes#USAGE_ASSISTANCE_SONIFICATION}, {@link android.media.AudioAttributes#USAGE_GAME}, or {@link android.media.AudioAttributes#USAGE_ASSISTANT}
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.media.AudioPlaybackCaptureConfiguration.Builder excludeUsage(int usage) { throw new RuntimeException("Stub!"); }

/**
 * Only capture audio output by apps that do not have the matching {@code uid}.
 *
 * <p>If called multiple times, will capture audio output by apps whose uid is not any of
 * the given uids.
 *
 * @throws java.lang.IllegalStateException if called in conjunction with {@link #addMatchingUid(int)}.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.media.AudioPlaybackCaptureConfiguration.Builder excludeUid(int uid) { throw new RuntimeException("Stub!"); }

/**
 * Builds the configuration instance.
 *
 * @throws java.lang.UnsupportedOperationException if the parameters set are incompatible.
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.media.AudioPlaybackCaptureConfiguration build() { throw new RuntimeException("Stub!"); }
}

}

