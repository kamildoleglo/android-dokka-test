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

import java.util.concurrent.Executor;

/**
 * AudioRecordingMonitor defines an interface implemented by {@link android.media.AudioRecord AudioRecord} and
 * {@link android.media.MediaRecorder MediaRecorder} allowing applications to install a callback and be notified of changes
 * in the capture path while recoding is active.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface AudioRecordingMonitor {

/**
 * Register a callback to be notified of audio capture changes via a
 * {@link android.media.AudioManager.AudioRecordingCallback AudioManager.AudioRecordingCallback}. A callback is received when the capture path
 * configuration changes (pre-processing, format, sampling rate...) or capture is
 * silenced/unsilenced by the system.
 * @param executor {@link java.util.concurrent.Executor Executor} to handle the callbacks.
 * This value must never be {@code null}.
 * Callback and listener events are dispatched through this
 * {@link java.util.concurrent.Executor Executor}, providing an easy way to control which thread is
 * used. To dispatch events through the main thread of your
 * application, you can use {@link android.content.Context#getMainExecutor() Context#getMainExecutor()}. To
 * dispatch events through a shared thread pool, you can use
 * {@link android.os.AsyncTask#THREAD_POOL_EXECUTOR AsyncTask#THREAD_POOL_EXECUTOR}.
 * @param cb non-null callback to register
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void registerAudioRecordingCallback(@androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull android.media.AudioManager.AudioRecordingCallback cb);

/**
 * Unregister an audio recording callback previously registered with
 * {@link #registerAudioRecordingCallback(java.util.concurrent.Executor,android.media.AudioManager.AudioRecordingCallback)}.
 * @param cb non-null callback to unregister
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void unregisterAudioRecordingCallback(@androidx.annotation.NonNull android.media.AudioManager.AudioRecordingCallback cb);

/**
 * Returns the current active audio recording for this audio recorder.
 * @return a valid {@link android.media.AudioRecordingConfiguration AudioRecordingConfiguration} if this recorder is active
 * or null otherwise.
 * @see android.media.AudioRecordingConfiguration
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.media.AudioRecordingConfiguration getActiveRecordingConfiguration();
}

