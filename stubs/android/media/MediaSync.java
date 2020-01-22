/*
 * Copyright (C) 2015 The Android Open Source Project
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

import android.media.PlaybackParams;
import java.nio.ByteBuffer;
import android.view.Surface;
import android.media.AudioTrack;
import android.os.Handler;

/**
 * MediaSync class can be used to synchronously play audio and video streams.
 * It can be used to play audio-only or video-only stream, too.
 *
 * <p>MediaSync is generally used like this:
 * <pre>
 * MediaSync sync = new MediaSync();
 * sync.setSurface(surface);
 * Surface inputSurface = sync.createInputSurface();
 * ...
 * // MediaCodec videoDecoder = ...;
 * videoDecoder.configure(format, inputSurface, ...);
 * ...
 * sync.setAudioTrack(audioTrack);
 * sync.setCallback(new MediaSync.Callback() {
 *     {@literal @Override}
 *     public void onAudioBufferConsumed(MediaSync sync, ByteBuffer audioBuffer, int bufferId) {
 *         ...
 *     }
 * }, null);
 * // This needs to be done since sync is paused on creation.
 * sync.setPlaybackParams(new PlaybackParams().setSpeed(1.f));
 *
 * for (;;) {
 *   ...
 *   // send video frames to surface for rendering, e.g., call
 *   // videoDecoder.releaseOutputBuffer(videoOutputBufferIx, videoPresentationTimeNs);
 *   // More details are available as below.
 *   ...
 *   sync.queueAudio(audioByteBuffer, bufferId, audioPresentationTimeUs); // non-blocking.
 *   // The audioByteBuffer and bufferId will be returned via callback.
 *   // More details are available as below.
 *   ...
 *     ...
 * }
 * sync.setPlaybackParams(new PlaybackParams().setSpeed(0.f));
 * sync.release();
 * sync = null;
 *
 * // The following code snippet illustrates how video/audio raw frames are created by
 * // MediaCodec's, how they are fed to MediaSync and how they are returned by MediaSync.
 * // This is the callback from MediaCodec.
 * onOutputBufferAvailable(MediaCodec codec, int bufferId, BufferInfo info) {
 *     // ...
 *     if (codec == videoDecoder) {
 *         // surface timestamp must contain media presentation time in nanoseconds.
 *         codec.releaseOutputBuffer(bufferId, 1000 * info.presentationTime);
 *     } else {
 *         ByteBuffer audioByteBuffer = codec.getOutputBuffer(bufferId);
 *         sync.queueAudio(audioByteBuffer, bufferId, info.presentationTime);
 *     }
 *     // ...
 * }
 *
 * // This is the callback from MediaSync.
 * onAudioBufferConsumed(MediaSync sync, ByteBuffer buffer, int bufferId) {
 *     // ...
 *     audioDecoder.releaseBuffer(bufferId, false);
 *     // ...
 * }
 *
 * </pre>
 *
 * The client needs to configure corresponding sink by setting the Surface and/or AudioTrack
 * based on the stream type it will play.
 * <p>
 * For video, the client needs to call {@link #createInputSurface} to obtain a surface on
 * which it will render video frames.
 * <p>
 * For audio, the client needs to set up audio track correctly, e.g., using {@link android.media.AudioTrack#MODE_STREAM AudioTrack#MODE_STREAM}. The audio buffers are sent to MediaSync directly via {@link
 * #queueAudio}, and are returned to the client via {@link android.media.MediaSync.Callback#onAudioBufferConsumed Callback#onAudioBufferConsumed}
 * asynchronously. The client should not modify an audio buffer till it's returned.
 * <p>
 * The client can optionally pre-fill audio/video buffers by setting playback rate to 0.0,
 * and then feed audio/video buffers to corresponding components. This can reduce possible
 * initial underrun.
 * <p>
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MediaSync {

/**
 * Class constructor. On creation, MediaSync is paused, i.e., playback rate is 0.0f.
 * @apiSince 23
 */

public MediaSync() { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

protected void finalize() { throw new RuntimeException("Stub!"); }

/**
 * Make sure you call this when you're done to free up any opened
 * component instance instead of relying on the garbage collector
 * to do this for you at some point in the future.
 * @apiSince 23
 */

public void release() { throw new RuntimeException("Stub!"); }

/**
 * Sets an asynchronous callback for actionable MediaSync events.
 * <p>
 * This method can be called multiple times to update a previously set callback. If the
 * handler is changed, undelivered notifications scheduled for the old handler may be dropped.
 * <p>
 * <b>Do not call this inside callback.</b>
 *
 * @param cb The callback that will run. Use {@code null} to stop receiving callbacks.
 * This value may be {@code null}.
 * @param handler The Handler that will run the callback. Use {@code null} to use MediaSync's
 *     internal handler if it exists.
 
 * This value may be {@code null}.
 * @apiSince 23
 */

public void setCallback(@androidx.annotation.Nullable android.media.MediaSync.Callback cb, @androidx.annotation.Nullable android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Sets an asynchronous callback for error events.
 * <p>
 * This method can be called multiple times to update a previously set listener. If the
 * handler is changed, undelivered notifications scheduled for the old handler may be dropped.
 * <p>
 * <b>Do not call this inside callback.</b>
 *
 * @param listener The callback that will run. Use {@code null} to stop receiving callbacks.
 * This value may be {@code null}.
 * @param handler The Handler that will run the callback. Use {@code null} to use MediaSync's
 *     internal handler if it exists.
 
 * This value may be {@code null}.
 * @apiSince 23
 */

public void setOnErrorListener(@androidx.annotation.Nullable android.media.MediaSync.OnErrorListener listener, @androidx.annotation.Nullable android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Sets the output surface for MediaSync.
 * <p>
 * Currently, this is only supported in the Initialized state.
 *
 * @param surface Specify a surface on which to render the video data.
 * This value may be {@code null}.
 * @throws java.lang.IllegalArgumentException if the surface has been released, is invalid,
 *     or can not be connected.
 * @throws java.lang.IllegalStateException if setting the surface is not supported, e.g.
 *     not in the Initialized state, or another surface has already been set.
 * @apiSince 23
 */

public void setSurface(@androidx.annotation.Nullable android.view.Surface surface) { throw new RuntimeException("Stub!"); }

/**
 * Sets the audio track for MediaSync.
 * <p>
 * Currently, this is only supported in the Initialized state.
 *
 * @param audioTrack Specify an AudioTrack through which to render the audio data.
 * This value may be {@code null}.
 * @throws java.lang.IllegalArgumentException if the audioTrack has been released, or is invalid.
 * @throws java.lang.IllegalStateException if setting the audio track is not supported, e.g.
 *     not in the Initialized state, or another audio track has already been set.
 * @apiSince 23
 */

public void setAudioTrack(@androidx.annotation.Nullable android.media.AudioTrack audioTrack) { throw new RuntimeException("Stub!"); }

/**
 * Requests a Surface to use as the input. This may only be called after
 * {@link #setSurface}.
 * <p>
 * The application is responsible for calling release() on the Surface when
 * done.
 * @throws java.lang.IllegalStateException if not set, or another input surface has
 *     already been created.
 
 * @return This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public native android.view.Surface createInputSurface();

/**
 * Sets playback rate using {@link android.media.PlaybackParams PlaybackParams}.
 * <p>
 * When using MediaSync with {@link android.media.AudioTrack AudioTrack}, set playback params using this
 * call instead of calling it directly on the track, so that the sync is aware of
 * the params change.
 * <p>
 * This call also works if there is no audio track.
 *
 * @param params the playback params to use. {@link android.media.PlaybackParams#getSpeed PlaybackParams#getSpeed} is the ratio between desired playback rate and normal one. 1.0 means
 *     normal playback speed. 0.0 means pause. Value larger than 1.0 means faster playback,
 *     while value between 0.0 and 1.0 for slower playback. <b>Note:</b> the normal rate
 *     does not change as a result of this call. To restore the original rate at any time,
 *     use speed of 1.0.
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalStateException if the internal sync engine or the audio track has not
 *     been initialized.
 * @throws java.lang.IllegalArgumentException if the params are not supported.
 * @apiSince 23
 */

public void setPlaybackParams(@androidx.annotation.NonNull android.media.PlaybackParams params) { throw new RuntimeException("Stub!"); }

/**
 * Gets the playback rate using {@link android.media.PlaybackParams PlaybackParams}.
 *
 * @return the playback rate being used.
 *
 * This value will never be {@code null}.
 * @throws java.lang.IllegalStateException if the internal sync engine or the audio track has not
 *     been initialized.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public native android.media.PlaybackParams getPlaybackParams();

/**
 * Sets A/V sync mode.
 *
 * @param params the A/V sync params to apply
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalStateException if the internal player engine has not been
 * initialized.
 * @throws java.lang.IllegalArgumentException if params are not supported.
 * @apiSince 23
 */

public void setSyncParams(@androidx.annotation.NonNull android.media.SyncParams params) { throw new RuntimeException("Stub!"); }

/**
 * Gets the A/V sync mode.
 *
 * @return the A/V sync params
 *
 * This value will never be {@code null}.
 * @throws java.lang.IllegalStateException if the internal player engine has not been
 * initialized.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public native android.media.SyncParams getSyncParams();

/**
 * Flushes all buffers from the sync object.
 * <p>
 * All pending unprocessed audio and video buffers are discarded. If an audio track was
 * configured, it is flushed and stopped. If a video output surface was configured, the
 * last frame queued to it is left on the frame. Queue a blank video frame to clear the
 * surface,
 * <p>
 * No callbacks are received for the flushed buffers.
 *
 * @throws java.lang.IllegalStateException if the internal player engine has not been
 * initialized.
 * @apiSince 23
 */

public void flush() { throw new RuntimeException("Stub!"); }

/**
 * Get current playback position.
 * <p>
 * The MediaTimestamp represents how the media time correlates to the system time in
 * a linear fashion using an anchor and a clock rate. During regular playback, the media
 * time moves fairly constantly (though the anchor frame may be rebased to a current
 * system time, the linear correlation stays steady). Therefore, this method does not
 * need to be called often.
 * <p>
 * To help users get current playback position, this method always anchors the timestamp
 * to the current {@link java.lang.System#nanoTime System#nanoTime}, so
 * {@link android.media.MediaTimestamp#getAnchorMediaTimeUs MediaTimestamp#getAnchorMediaTimeUs} can be used as current playback position.
 *
 * @return a MediaTimestamp object if a timestamp is available, or {@code null} if no timestamp
 *         is available, e.g. because the media player has not been initialized.
 *
 * @see android.media.MediaTimestamp
 * @apiSince 23
 */

@androidx.annotation.Nullable
public android.media.MediaTimestamp getTimestamp() { throw new RuntimeException("Stub!"); }

/**
 * Queues the audio data asynchronously for playback (AudioTrack must be in streaming mode).
 * If the audio track was flushed as a result of {@link #flush}, it will be restarted.
 * @param audioData the buffer that holds the data to play. This buffer will be returned
 *     to the client via registered callback.
 * This value must never be {@code null}.
 * @param bufferId an integer used to identify audioData. It will be returned to
 *     the client along with audioData. This helps applications to keep track of audioData,
 *     e.g., it can be used to store the output buffer index used by the audio codec.
 * @param presentationTimeUs the presentation timestamp in microseconds for the first frame
 *     in the buffer.
 * @throws java.lang.IllegalStateException if audio track is not set or internal configureation
 *     has not been done correctly.
 * @apiSince 23
 */

public void queueAudio(@androidx.annotation.NonNull java.nio.ByteBuffer audioData, int bufferId, long presentationTimeUs) { throw new RuntimeException("Stub!"); }

/** Audio track failed.
 * @see android.media.MediaSync.OnErrorListener
 * @apiSince 23
 */

public static final int MEDIASYNC_ERROR_AUDIOTRACK_FAIL = 1; // 0x1

/** The surface failed to handle video buffers.
 * @see android.media.MediaSync.OnErrorListener
 * @apiSince 23
 */

public static final int MEDIASYNC_ERROR_SURFACE_FAIL = 2; // 0x2
/**
 * MediaSync callback interface. Used to notify the user asynchronously
 * of various MediaSync events.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class Callback {

public Callback() { throw new RuntimeException("Stub!"); }

/**
 * Called when returning an audio buffer which has been consumed.
 *
 * @param sync The MediaSync object.
 * This value must never be {@code null}.
 * @param audioBuffer The returned audio buffer.
 * This value must never be {@code null}.
 * @param bufferId The ID associated with audioBuffer as passed into
 *     {@link android.media.MediaSync#queueAudio MediaSync#queueAudio}.
 * @apiSince 23
 */

public abstract void onAudioBufferConsumed(@androidx.annotation.NonNull android.media.MediaSync sync, @androidx.annotation.NonNull java.nio.ByteBuffer audioBuffer, int bufferId);
}

/**
 * Interface definition of a callback to be invoked when there
 * has been an error during an asynchronous operation (other errors
 * will throw exceptions at method call time).
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnErrorListener {

/**
 * Called to indicate an error.
 *
 * @param sync The MediaSync the error pertains to
 * This value must never be {@code null}.
 * @param what The type of error that has occurred:
 * <ul>
 * <li>{@link #MEDIASYNC_ERROR_AUDIOTRACK_FAIL}
 * <li>{@link #MEDIASYNC_ERROR_SURFACE_FAIL}
 * </ul>
 * @param extra an extra code, specific to the error. Typically
 * implementation dependent.
 * @apiSince 23
 */

public void onError(@androidx.annotation.NonNull android.media.MediaSync sync, int what, int extra);
}

}

