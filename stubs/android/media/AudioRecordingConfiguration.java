/*
 * Copyright (C) 2016 The Android Open Source Project
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

import java.util.List;
import android.media.audiofx.AudioEffect;

/**
 * The AudioRecordingConfiguration class collects the information describing an audio recording
 * session.
 * <p>Direct polling (see {@link android.media.AudioManager#getActiveRecordingConfigurations() AudioManager#getActiveRecordingConfigurations()}) or callback
 * (see {@link android.media.AudioManager#registerAudioRecordingCallback(android.media.AudioManager.AudioRecordingCallback,android.os.Handler) AudioManager#registerAudioRecordingCallback(android.media.AudioManager.AudioRecordingCallback, android.os.Handler)}
 * methods are ways to receive information about the current recording configuration of the device.
 * <p>An audio recording configuration contains information about the recording format as used by
 * the application ({@link #getClientFormat()}, as well as the recording format actually used by
 * the device ({@link #getFormat()}). The two recording formats may, for instance, be at different
 * sampling rates due to hardware limitations (e.g. application recording at 44.1kHz whereas the
 * device always records at 48kHz, and the Android framework resamples for the application).
 * <p>The configuration also contains the use case for which audio is recorded
 * ({@link #getClientAudioSource()}), enabling the ability to distinguish between different
 * activities such as ongoing voice recognition or camcorder recording.
 *
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class AudioRecordingConfiguration implements android.os.Parcelable {

AudioRecordingConfiguration() { throw new RuntimeException("Stub!"); }

/**
 * Returns the audio source selected by the client.
 * @return the audio source selected by the client.
 
 * Value is {@link android.media.MediaRecorder.AudioSource#DEFAULT}, {@link android.media.MediaRecorder.AudioSource#MIC}, {@link android.media.MediaRecorder.AudioSource#VOICE_UPLINK}, {@link android.media.MediaRecorder.AudioSource#VOICE_DOWNLINK}, {@link android.media.MediaRecorder.AudioSource#VOICE_CALL}, {@link android.media.MediaRecorder.AudioSource#CAMCORDER}, {@link android.media.MediaRecorder.AudioSource#VOICE_RECOGNITION}, {@link android.media.MediaRecorder.AudioSource#VOICE_COMMUNICATION}, {@link android.media.MediaRecorder.AudioSource#UNPROCESSED}, or {@link android.media.MediaRecorder.AudioSource#VOICE_PERFORMANCE}
 * @apiSince 24
 */

public int getClientAudioSource() { throw new RuntimeException("Stub!"); }

/**
 * Returns the session number of the recording, see {@link android.media.AudioRecord#getAudioSessionId() AudioRecord#getAudioSessionId()}.
 * @return the session number.
 * @apiSince 24
 */

public int getClientAudioSessionId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the audio format at which audio is recorded on this Android device.
 * Note that it may differ from the client application recording format
 * (see {@link #getClientFormat()}).
 * @return the device recording format
 * @apiSince 24
 */

public android.media.AudioFormat getFormat() { throw new RuntimeException("Stub!"); }

/**
 * Returns the audio format at which the client application is recording audio.
 * Note that it may differ from the actual recording format (see {@link #getFormat()}).
 * @return the recording format
 * @apiSince 24
 */

public android.media.AudioFormat getClientFormat() { throw new RuntimeException("Stub!"); }

/**
 * Returns information about the audio input device used for this recording.
 * @return the audio recording device or null if this information cannot be retrieved
 * @apiSince 24
 */

public android.media.AudioDeviceInfo getAudioDevice() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the audio returned to the client is currently being silenced by the
 * audio framework due to concurrent capture policy (e.g the capturing application does not have
 * an active foreground process or service anymore).
 * @return true if captured audio is silenced, false otherwise .
 * @apiSince 29
 */

public boolean isClientSilenced() { throw new RuntimeException("Stub!"); }

/**
 * Returns the audio source currently used to configure the capture path. It can be different
 * from the source returned by {@link #getClientAudioSource()} if another capture is active.
 * @return the audio source active on the capture path.
 
 * Value is {@link android.media.MediaRecorder.AudioSource#DEFAULT}, {@link android.media.MediaRecorder.AudioSource#MIC}, {@link android.media.MediaRecorder.AudioSource#VOICE_UPLINK}, {@link android.media.MediaRecorder.AudioSource#VOICE_DOWNLINK}, {@link android.media.MediaRecorder.AudioSource#VOICE_CALL}, {@link android.media.MediaRecorder.AudioSource#CAMCORDER}, {@link android.media.MediaRecorder.AudioSource#VOICE_RECOGNITION}, {@link android.media.MediaRecorder.AudioSource#VOICE_COMMUNICATION}, {@link android.media.MediaRecorder.AudioSource#UNPROCESSED}, or {@link android.media.MediaRecorder.AudioSource#VOICE_PERFORMANCE}
 * @apiSince 29
 */

public int getAudioSource() { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of {@link android.media.audiofx.AudioEffect.Descriptor AudioEffect.Descriptor} for all effects currently enabled on
 * the audio capture client (e.g. {@link android.media.AudioRecord AudioRecord} or {@link android.media.MediaRecorder MediaRecorder}).
 * @return List of {@link android.media.audiofx.AudioEffect.Descriptor AudioEffect.Descriptor} containing all effects enabled for the client.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.util.List<android.media.audiofx.AudioEffect.Descriptor> getClientEffects() { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of {@link android.media.audiofx.AudioEffect.Descriptor AudioEffect.Descriptor} for all effects currently enabled on
 * the capture stream.
 * @return List of {@link android.media.audiofx.AudioEffect.Descriptor AudioEffect.Descriptor} containing all effects enabled on the
 * capture stream. This can be different from the list returned by {@link #getClientEffects()}
 * if another capture is active.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.util.List<android.media.audiofx.AudioEffect.Descriptor> getEffects() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.media.AudioRecordingConfiguration> CREATOR;
static { CREATOR = null; }
}

