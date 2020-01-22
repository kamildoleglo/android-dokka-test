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


package android.media.tv;

import android.net.Uri;
import android.media.tv.TvInputManager;

/**
 * The public interface object used to interact with a specific TV input service for TV program
 * recording.
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TvRecordingClient {

/**
 * Creates a new TvRecordingClient object.
 *
 * @param context The application context to create a TvRecordingClient with.
 * @param tag A short name for debugging purposes.
 * @param callback The callback to receive recording status changes.
 * This value must never be {@code null}.
 * @param handler The handler to invoke the callback on.
 * @apiSince 24
 */

public TvRecordingClient(android.content.Context context, java.lang.String tag, @androidx.annotation.NonNull android.media.tv.TvRecordingClient.RecordingCallback callback, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Tunes to a given channel for TV program recording. The first tune request will create a new
 * recording session for the corresponding TV input and establish a connection between the
 * application and the session. If recording has already started in the current recording
 * session, this method throws an exception.
 *
 * <p>The application may call this method before starting or after stopping recording, but not
 * during recording.
 *
 * <p>The recording session will respond by calling
 * {@link android.media.tv.TvRecordingClient.RecordingCallback#onTuned(android.net.Uri) RecordingCallback#onTuned(Uri)} if the tune request was fulfilled, or
 * {@link android.media.tv.TvRecordingClient.RecordingCallback#onError(int) RecordingCallback#onError(int)} otherwise.
 *
 * @param inputId The ID of the TV input for the given channel.
 * @param channelUri The URI of a channel.
 * @throws java.lang.IllegalStateException If recording is already started.
 * @apiSince 24
 */

public void tune(java.lang.String inputId, android.net.Uri channelUri) { throw new RuntimeException("Stub!"); }

/**
 * Tunes to a given channel for TV program recording. The first tune request will create a new
 * recording session for the corresponding TV input and establish a connection between the
 * application and the session. If recording has already started in the current recording
 * session, this method throws an exception. This can be used to provide domain-specific
 * features that are only known between certain client and their TV inputs.
 *
 * <p>The application may call this method before starting or after stopping recording, but not
 * during recording.
 *
 * <p>The recording session will respond by calling
 * {@link android.media.tv.TvRecordingClient.RecordingCallback#onTuned(android.net.Uri) RecordingCallback#onTuned(Uri)} if the tune request was fulfilled, or
 * {@link android.media.tv.TvRecordingClient.RecordingCallback#onError(int) RecordingCallback#onError(int)} otherwise.
 *
 * @param inputId The ID of the TV input for the given channel.
 * @param channelUri The URI of a channel.
 * @param params Domain-specific data for this tune request. Keys <em>must</em> be a scoped
 *            name, i.e. prefixed with a package name you own, so that different developers will
 *            not create conflicting keys.
 * @throws java.lang.IllegalStateException If recording is already started.
 * @apiSince 24
 */

public void tune(java.lang.String inputId, android.net.Uri channelUri, android.os.Bundle params) { throw new RuntimeException("Stub!"); }

/**
 * Releases the resources in the current recording session immediately. This may be called at
 * any time, however if the session is already released, it does nothing.
 * @apiSince 24
 */

public void release() { throw new RuntimeException("Stub!"); }

/**
 * Starts TV program recording in the current recording session. Recording is expected to start
 * immediately when this method is called. If the current recording session has not yet tuned to
 * any channel, this method throws an exception.
 *
 * <p>The application may supply the URI for a TV program for filling in program specific data
 * fields in the {@link android.media.tv.TvContract.RecordedPrograms} table.
 * A non-null {@code programUri} implies the started recording should be of that specific
 * program, whereas null {@code programUri} does not impose such a requirement and the
 * recording can span across multiple TV programs. In either case, the application must call
 * {@link android.media.tv.TvRecordingClient#stopRecording() TvRecordingClient#stopRecording()} to stop the recording.
 *
 * <p>The recording session will respond by calling {@link android.media.tv.TvRecordingClient.RecordingCallback#onError(int) RecordingCallback#onError(int)} if
 * the start request cannot be fulfilled.
 *
 * @param programUri The URI for the TV program to record, built by
 *            {@link android.media.tv.TvContract#buildProgramUri(long) TvContract#buildProgramUri(long)}. Can be {@code null}.
 * This value may be {@code null}.
 * @throws java.lang.IllegalStateException If {@link #tune} request hasn't been handled yet.
 * @apiSince 24
 */

public void startRecording(@androidx.annotation.Nullable android.net.Uri programUri) { throw new RuntimeException("Stub!"); }

/**
 * Stops TV program recording in the current recording session. Recording is expected to stop
 * immediately when this method is called. If recording has not yet started in the current
 * recording session, this method does nothing.
 *
 * <p>The recording session is expected to create a new data entry in the
 * {@link android.media.tv.TvContract.RecordedPrograms} table that describes the newly
 * recorded program and pass the URI to that entry through to
 * {@link android.media.tv.TvRecordingClient.RecordingCallback#onRecordingStopped(android.net.Uri) RecordingCallback#onRecordingStopped(Uri)}.
 * If the stop request cannot be fulfilled, the recording session will respond by calling
 * {@link android.media.tv.TvRecordingClient.RecordingCallback#onError(int) RecordingCallback#onError(int)}.
 * @apiSince 24
 */

public void stopRecording() { throw new RuntimeException("Stub!"); }

/**
 * Sends a private command to the underlying TV input. This can be used to provide
 * domain-specific features that are only known between certain clients and their TV inputs.
 *
 * @param action The name of the private command to send. This <em>must</em> be a scoped name,
 *            i.e. prefixed with a package name you own, so that different developers will not
 *            create conflicting commands.
 * This value must never be {@code null}.
 * @param data An optional bundle to send with the command.
 * @apiSince 24
 */

public void sendAppPrivateCommand(@androidx.annotation.NonNull java.lang.String action, android.os.Bundle data) { throw new RuntimeException("Stub!"); }
/**
 * Callback used to receive various status updates on the
 * {@link android.media.tv.TvInputService.RecordingSession}
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class RecordingCallback {

public RecordingCallback() { throw new RuntimeException("Stub!"); }

/**
 * This is called when an error occurred while establishing a connection to the recording
 * session for the corresponding TV input.
 *
 * @param inputId The ID of the TV input bound to the current TvRecordingClient.
 * @apiSince 24
 */

public void onConnectionFailed(java.lang.String inputId) { throw new RuntimeException("Stub!"); }

/**
 * This is called when the connection to the current recording session is lost.
 *
 * @param inputId The ID of the TV input bound to the current TvRecordingClient.
 * @apiSince 24
 */

public void onDisconnected(java.lang.String inputId) { throw new RuntimeException("Stub!"); }

/**
 * This is called when the recording session has been tuned to the given channel and is
 * ready to start recording.
 *
 * @param channelUri The URI of a channel.
 * @apiSince 24
 */

public void onTuned(android.net.Uri channelUri) { throw new RuntimeException("Stub!"); }

/**
 * This is called when the current recording session has stopped recording and created a
 * new data entry in the {@link android.media.tv.TvContract.RecordedPrograms TvContract.RecordedPrograms} table that describes the newly
 * recorded program.
 *
 * @param recordedProgramUri The URI for the newly recorded program.
 * @apiSince 24
 */

public void onRecordingStopped(android.net.Uri recordedProgramUri) { throw new RuntimeException("Stub!"); }

/**
 * This is called when an issue has occurred. It may be called at any time after the current
 * recording session is created until it is released.
 *
 * @param error The error code. Should be one of the followings.
 * <ul>
 * <li>{@link android.media.tv.TvInputManager#RECORDING_ERROR_UNKNOWN TvInputManager#RECORDING_ERROR_UNKNOWN}
 * <li>{@link android.media.tv.TvInputManager#RECORDING_ERROR_INSUFFICIENT_SPACE TvInputManager#RECORDING_ERROR_INSUFFICIENT_SPACE}
 * <li>{@link android.media.tv.TvInputManager#RECORDING_ERROR_RESOURCE_BUSY TvInputManager#RECORDING_ERROR_RESOURCE_BUSY}
 * </ul>
 
 * Value is {@link android.media.tv.TvInputManager#RECORDING_ERROR_UNKNOWN}, {@link android.media.tv.TvInputManager#RECORDING_ERROR_INSUFFICIENT_SPACE}, or {@link android.media.tv.TvInputManager#RECORDING_ERROR_RESOURCE_BUSY}
 * @apiSince 24
 */

public void onError(int error) { throw new RuntimeException("Stub!"); }
}

}

