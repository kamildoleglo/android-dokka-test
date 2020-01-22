/*
 * Copyright (C) 2008 The Android Open Source Project
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

import java.nio.ByteBuffer;
import android.os.PersistableBundle;
import android.os.Handler;
import android.os.Looper;
import java.io.IOException;
import java.util.concurrent.Executor;

/**
 * The AudioRecord class manages the audio resources for Java applications
 * to record audio from the audio input hardware of the platform. This is
 * achieved by "pulling" (reading) the data from the AudioRecord object. The
 * application is responsible for polling the AudioRecord object in time using one of
 * the following three methods:  {@link #read(byte[],int,int)}, {@link #read(short[],int,int)}
 * or {@link #read(java.nio.ByteBuffer,int)}. The choice of which method to use will be based
 * on the audio data storage format that is the most convenient for the user of AudioRecord.
 * <p>Upon creation, an AudioRecord object initializes its associated audio buffer that it will
 * fill with the new audio data. The size of this buffer, specified during the construction,
 * determines how long an AudioRecord can record before "over-running" data that has not
 * been read yet. Data should be read from the audio hardware in chunks of sizes inferior to
 * the total recording buffer size.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AudioRecord implements android.media.AudioRouting, android.media.MicrophoneDirection, android.media.AudioRecordingMonitor {

/**
 * Class constructor.
 * Though some invalid parameters will result in an {@link java.lang.IllegalArgumentException IllegalArgumentException} exception,
 * other errors do not.  Thus you should call {@link #getState()} immediately after construction
 * to confirm that the object is usable.
 * @param audioSource the recording source.
 *   See {@link android.media.MediaRecorder.AudioSource MediaRecorder.AudioSource} for the recording source definitions.
 * @param sampleRateInHz the sample rate expressed in Hertz. 44100Hz is currently the only
 *   rate that is guaranteed to work on all devices, but other rates such as 22050,
 *   16000, and 11025 may work on some devices.
 *   {@link android.media.AudioFormat#SAMPLE_RATE_UNSPECIFIED AudioFormat#SAMPLE_RATE_UNSPECIFIED} means to use a route-dependent value
 *   which is usually the sample rate of the source.
 *   {@link #getSampleRate()} can be used to retrieve the actual sample rate chosen.
 * @param channelConfig describes the configuration of the audio channels.
 *   See {@link android.media.AudioFormat#CHANNEL_IN_MONO AudioFormat#CHANNEL_IN_MONO} and
 *   {@link android.media.AudioFormat#CHANNEL_IN_STEREO AudioFormat#CHANNEL_IN_STEREO}.  {@link android.media.AudioFormat#CHANNEL_IN_MONO AudioFormat#CHANNEL_IN_MONO} is guaranteed
 *   to work on all devices.
 * @param audioFormat the format in which the audio data is to be returned.
 *   See {@link android.media.AudioFormat#ENCODING_PCM_8BIT AudioFormat#ENCODING_PCM_8BIT}, {@link android.media.AudioFormat#ENCODING_PCM_16BIT AudioFormat#ENCODING_PCM_16BIT},
 *   and {@link android.media.AudioFormat#ENCODING_PCM_FLOAT AudioFormat#ENCODING_PCM_FLOAT}.
 * @param bufferSizeInBytes the total size (in bytes) of the buffer where audio data is written
 *   to during the recording. New audio data can be read from this buffer in smaller chunks
 *   than this size. See {@link #getMinBufferSize(int,int,int)} to determine the minimum
 *   required buffer size for the successful creation of an AudioRecord instance. Using values
 *   smaller than getMinBufferSize() will result in an initialization failure.
 * @throws java.lang.IllegalArgumentException
 * @apiSince 3
 */

public AudioRecord(int audioSource, int sampleRateInHz, int channelConfig, int audioFormat, int bufferSizeInBytes) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Releases the native AudioRecord resources.
 * The object can no longer be used and the reference should be set to null
 * after a call to release()
 * @apiSince 3
 */

public void release() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

protected void finalize() { throw new RuntimeException("Stub!"); }

/**
 * Returns the configured audio sink sample rate in Hz.
 * The sink sample rate never changes after construction.
 * If the constructor had a specific sample rate, then the sink sample rate is that value.
 * If the constructor had {@link android.media.AudioFormat#SAMPLE_RATE_UNSPECIFIED AudioFormat#SAMPLE_RATE_UNSPECIFIED},
 * then the sink sample rate is a route-dependent default value based on the source [sic].
 * @apiSince 3
 */

public int getSampleRate() { throw new RuntimeException("Stub!"); }

/**
 * Returns the audio recording source.
 * @see android.media.MediaRecorder.AudioSource
 * @apiSince 3
 */

public int getAudioSource() { throw new RuntimeException("Stub!"); }

/**
 * Returns the configured audio data encoding. See {@link android.media.AudioFormat#ENCODING_PCM_8BIT AudioFormat#ENCODING_PCM_8BIT},
 * {@link android.media.AudioFormat#ENCODING_PCM_16BIT AudioFormat#ENCODING_PCM_16BIT}, and {@link android.media.AudioFormat#ENCODING_PCM_FLOAT AudioFormat#ENCODING_PCM_FLOAT}.
 * @apiSince 3
 */

public int getAudioFormat() { throw new RuntimeException("Stub!"); }

/**
 * Returns the configured channel position mask.
 * <p> See {@link android.media.AudioFormat#CHANNEL_IN_MONO AudioFormat#CHANNEL_IN_MONO}
 * and {@link android.media.AudioFormat#CHANNEL_IN_STEREO AudioFormat#CHANNEL_IN_STEREO}.
 * This method may return {@link android.media.AudioFormat#CHANNEL_INVALID AudioFormat#CHANNEL_INVALID} if
 * a channel index mask is used.
 * Consider {@link #getFormat()} instead, to obtain an {@link android.media.AudioFormat AudioFormat},
 * which contains both the channel position mask and the channel index mask.
 * @apiSince 3
 */

public int getChannelConfiguration() { throw new RuntimeException("Stub!"); }

/**
 * Returns the configured <code>AudioRecord</code> format.
 * @return an {@link android.media.AudioFormat AudioFormat} containing the
 * <code>AudioRecord</code> parameters at the time of configuration.
 
 * This value will never be {@code null}.
 * @apiSince 23
 */

@androidx.annotation.NonNull
public android.media.AudioFormat getFormat() { throw new RuntimeException("Stub!"); }

/**
 * Returns the configured number of channels.
 * @apiSince 3
 */

public int getChannelCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the state of the AudioRecord instance. This is useful after the
 * AudioRecord instance has been created to check if it was initialized
 * properly. This ensures that the appropriate hardware resources have been
 * acquired.
 * @see android.media.AudioRecord#STATE_INITIALIZED
 * @see android.media.AudioRecord#STATE_UNINITIALIZED
 * @apiSince 3
 */

public int getState() { throw new RuntimeException("Stub!"); }

/**
 * Returns the recording state of the AudioRecord instance.
 * @see android.media.AudioRecord#RECORDSTATE_STOPPED
 * @see android.media.AudioRecord#RECORDSTATE_RECORDING
 * @apiSince 3
 */

public int getRecordingState() { throw new RuntimeException("Stub!"); }

/**
 *  Returns the frame count of the native <code>AudioRecord</code> buffer.
 *  This is greater than or equal to the bufferSizeInBytes converted to frame units
 *  specified in the <code>AudioRecord</code> constructor or Builder.
 *  The native frame count may be enlarged to accommodate the requirements of the
 *  source on creation or if the <code>AudioRecord</code>
 *  is subsequently rerouted.
 *  @return current size in frames of the <code>AudioRecord</code> buffer.
 *  @throws java.lang.IllegalStateException
 * @apiSince 23
 */

public int getBufferSizeInFrames() { throw new RuntimeException("Stub!"); }

/**
 * Returns the notification marker position expressed in frames.
 * @apiSince 3
 */

public int getNotificationMarkerPosition() { throw new RuntimeException("Stub!"); }

/**
 * Returns the notification update period expressed in frames.
 * @apiSince 3
 */

public int getPositionNotificationPeriod() { throw new RuntimeException("Stub!"); }

/**
 * Poll for an {@link android.media.AudioTimestamp AudioTimestamp} on demand.
 * <p>
 * The AudioTimestamp reflects the frame delivery information at
 * the earliest point available in the capture pipeline.
 * <p>
 * Calling {@link #startRecording()} following a {@link #stop()} will reset
 * the frame count to 0.
 *
 * @param outTimestamp a caller provided non-null AudioTimestamp instance,
 *        which is updated with the AudioRecord frame delivery information upon success.
 * This value must never be {@code null}.
 * @param timebase one of
 *        {@link android.media.AudioTimestamp#TIMEBASE_BOOTTIME AudioTimestamp#TIMEBASE_BOOTTIME} or
 *        {@link android.media.AudioTimestamp#TIMEBASE_MONOTONIC AudioTimestamp#TIMEBASE_MONOTONIC},
 *        used to select the clock for the AudioTimestamp time.
 * Value is {@link android.media.AudioTimestamp#TIMEBASE_MONOTONIC}, or {@link android.media.AudioTimestamp#TIMEBASE_BOOTTIME}
 * @return {@link #SUCCESS} if a timestamp is available,
 *         or {@link #ERROR_INVALID_OPERATION} if a timestamp not available.
 * @apiSince 24
 */

public int getTimestamp(@androidx.annotation.NonNull android.media.AudioTimestamp outTimestamp, int timebase) { throw new RuntimeException("Stub!"); }

/**
 * Returns the minimum buffer size required for the successful creation of an AudioRecord
 * object, in byte units.
 * Note that this size doesn't guarantee a smooth recording under load, and higher values
 * should be chosen according to the expected frequency at which the AudioRecord instance
 * will be polled for new data.
 * See {@link #AudioRecord(int,int,int,int,int)} for more information on valid
 * configuration values.
 * @param sampleRateInHz the sample rate expressed in Hertz.
 *   {@link android.media.AudioFormat#SAMPLE_RATE_UNSPECIFIED AudioFormat#SAMPLE_RATE_UNSPECIFIED} is not permitted.
 * @param channelConfig describes the configuration of the audio channels.
 *   See {@link android.media.AudioFormat#CHANNEL_IN_MONO AudioFormat#CHANNEL_IN_MONO} and
 *   {@link android.media.AudioFormat#CHANNEL_IN_STEREO AudioFormat#CHANNEL_IN_STEREO}
 * @param audioFormat the format in which the audio data is represented.
 *   See {@link android.media.AudioFormat#ENCODING_PCM_16BIT AudioFormat#ENCODING_PCM_16BIT}.
 * @return {@link #ERROR_BAD_VALUE} if the recording parameters are not supported by the
 *  hardware, or an invalid parameter was passed,
 *  or {@link #ERROR} if the implementation was unable to query the hardware for its
 *  input properties,
 *   or the minimum buffer size expressed in bytes.
 * @see #AudioRecord(int, int, int, int, int)
 * @apiSince 3
 */

public static int getMinBufferSize(int sampleRateInHz, int channelConfig, int audioFormat) { throw new RuntimeException("Stub!"); }

/**
 * Returns the audio session ID.
 *
 * @return the ID of the audio session this AudioRecord belongs to.
 * @apiSince 16
 */

public int getAudioSessionId() { throw new RuntimeException("Stub!"); }

/**
 * Starts recording from the AudioRecord instance.
 * @throws java.lang.IllegalStateException
 * @apiSince 3
 */

public void startRecording() throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Starts recording from the AudioRecord instance when the specified synchronization event
 * occurs on the specified audio session.
 * @throws java.lang.IllegalStateException
 * @param syncEvent event that triggers the capture.
 * @see android.media.MediaSyncEvent
 * @apiSince 16
 */

public void startRecording(android.media.MediaSyncEvent syncEvent) throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Stops recording.
 * @throws java.lang.IllegalStateException
 * @apiSince 3
 */

public void stop() throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Reads audio data from the audio hardware for recording into a byte array.
 * The format specified in the AudioRecord constructor should be
 * {@link android.media.AudioFormat#ENCODING_PCM_8BIT AudioFormat#ENCODING_PCM_8BIT} to correspond to the data in the array.
 * @param audioData the array to which the recorded audio data is written.
 * This value must never be {@code null}.
 * @param offsetInBytes index in audioData from which the data is written expressed in bytes.
 * @param sizeInBytes the number of requested bytes.
 * @return zero or the positive number of bytes that were read, or one of the following
 *    error codes. The number of bytes will not exceed sizeInBytes.
 * <ul>
 * <li>{@link #ERROR_INVALID_OPERATION} if the object isn't properly initialized</li>
 * <li>{@link #ERROR_BAD_VALUE} if the parameters don't resolve to valid data and indexes</li>
 * <li>{@link #ERROR_DEAD_OBJECT} if the object is not valid anymore and
 *    needs to be recreated. The dead object error code is not returned if some data was
 *    successfully transferred. In this case, the error is returned at the next read()</li>
 * <li>{@link #ERROR} in case of other error</li>
 * </ul>
 * @apiSince 3
 */

public int read(@androidx.annotation.NonNull byte[] audioData, int offsetInBytes, int sizeInBytes) { throw new RuntimeException("Stub!"); }

/**
 * Reads audio data from the audio hardware for recording into a byte array.
 * The format specified in the AudioRecord constructor should be
 * {@link android.media.AudioFormat#ENCODING_PCM_8BIT AudioFormat#ENCODING_PCM_8BIT} to correspond to the data in the array.
 * The format can be {@link android.media.AudioFormat#ENCODING_PCM_16BIT AudioFormat#ENCODING_PCM_16BIT}, but this is deprecated.
 * @param audioData the array to which the recorded audio data is written.
 * This value must never be {@code null}.
 * @param offsetInBytes index in audioData to which the data is written expressed in bytes.
 *        Must not be negative, or cause the data access to go out of bounds of the array.
 * @param sizeInBytes the number of requested bytes.
 *        Must not be negative, or cause the data access to go out of bounds of the array.
 * @param readMode one of {@link #READ_BLOCKING}, {@link #READ_NON_BLOCKING}.
 *     <br>With {@link #READ_BLOCKING}, the read will block until all the requested data
 *     is read.
 *     <br>With {@link #READ_NON_BLOCKING}, the read will return immediately after
 *     reading as much audio data as possible without blocking.
 * Value is {@link android.media.AudioRecord#READ_BLOCKING}, or {@link android.media.AudioRecord#READ_NON_BLOCKING}
 * @return zero or the positive number of bytes that were read, or one of the following
 *    error codes. The number of bytes will be a multiple of the frame size in bytes
 *    not to exceed sizeInBytes.
 * <ul>
 * <li>{@link #ERROR_INVALID_OPERATION} if the object isn't properly initialized</li>
 * <li>{@link #ERROR_BAD_VALUE} if the parameters don't resolve to valid data and indexes</li>
 * <li>{@link #ERROR_DEAD_OBJECT} if the object is not valid anymore and
 *    needs to be recreated. The dead object error code is not returned if some data was
 *    successfully transferred. In this case, the error is returned at the next read()</li>
 * <li>{@link #ERROR} in case of other error</li>
 * </ul>
 * @apiSince 23
 */

public int read(@androidx.annotation.NonNull byte[] audioData, int offsetInBytes, int sizeInBytes, int readMode) { throw new RuntimeException("Stub!"); }

/**
 * Reads audio data from the audio hardware for recording into a short array.
 * The format specified in the AudioRecord constructor should be
 * {@link android.media.AudioFormat#ENCODING_PCM_16BIT AudioFormat#ENCODING_PCM_16BIT} to correspond to the data in the array.
 * @param audioData the array to which the recorded audio data is written.
 * This value must never be {@code null}.
 * @param offsetInShorts index in audioData to which the data is written expressed in shorts.
 *        Must not be negative, or cause the data access to go out of bounds of the array.
 * @param sizeInShorts the number of requested shorts.
 *        Must not be negative, or cause the data access to go out of bounds of the array.
 * @return zero or the positive number of shorts that were read, or one of the following
 *    error codes. The number of shorts will be a multiple of the channel count not to exceed
 *    sizeInShorts.
 * <ul>
 * <li>{@link #ERROR_INVALID_OPERATION} if the object isn't properly initialized</li>
 * <li>{@link #ERROR_BAD_VALUE} if the parameters don't resolve to valid data and indexes</li>
 * <li>{@link #ERROR_DEAD_OBJECT} if the object is not valid anymore and
 *    needs to be recreated. The dead object error code is not returned if some data was
 *    successfully transferred. In this case, the error is returned at the next read()</li>
 * <li>{@link #ERROR} in case of other error</li>
 * </ul>
 * @apiSince 3
 */

public int read(@androidx.annotation.NonNull short[] audioData, int offsetInShorts, int sizeInShorts) { throw new RuntimeException("Stub!"); }

/**
 * Reads audio data from the audio hardware for recording into a short array.
 * The format specified in the AudioRecord constructor should be
 * {@link android.media.AudioFormat#ENCODING_PCM_16BIT AudioFormat#ENCODING_PCM_16BIT} to correspond to the data in the array.
 * @param audioData the array to which the recorded audio data is written.
 * This value must never be {@code null}.
 * @param offsetInShorts index in audioData from which the data is written expressed in shorts.
 *        Must not be negative, or cause the data access to go out of bounds of the array.
 * @param sizeInShorts the number of requested shorts.
 *        Must not be negative, or cause the data access to go out of bounds of the array.
 * @param readMode one of {@link #READ_BLOCKING}, {@link #READ_NON_BLOCKING}.
 *     <br>With {@link #READ_BLOCKING}, the read will block until all the requested data
 *     is read.
 *     <br>With {@link #READ_NON_BLOCKING}, the read will return immediately after
 *     reading as much audio data as possible without blocking.
 * Value is {@link android.media.AudioRecord#READ_BLOCKING}, or {@link android.media.AudioRecord#READ_NON_BLOCKING}
 * @return zero or the positive number of shorts that were read, or one of the following
 *    error codes. The number of shorts will be a multiple of the channel count not to exceed
 *    sizeInShorts.
 * <ul>
 * <li>{@link #ERROR_INVALID_OPERATION} if the object isn't properly initialized</li>
 * <li>{@link #ERROR_BAD_VALUE} if the parameters don't resolve to valid data and indexes</li>
 * <li>{@link #ERROR_DEAD_OBJECT} if the object is not valid anymore and
 *    needs to be recreated. The dead object error code is not returned if some data was
 *    successfully transferred. In this case, the error is returned at the next read()</li>
 * <li>{@link #ERROR} in case of other error</li>
 * </ul>
 * @apiSince 23
 */

public int read(@androidx.annotation.NonNull short[] audioData, int offsetInShorts, int sizeInShorts, int readMode) { throw new RuntimeException("Stub!"); }

/**
 * Reads audio data from the audio hardware for recording into a float array.
 * The format specified in the AudioRecord constructor should be
 * {@link android.media.AudioFormat#ENCODING_PCM_FLOAT AudioFormat#ENCODING_PCM_FLOAT} to correspond to the data in the array.
 * @param audioData the array to which the recorded audio data is written.
 * This value must never be {@code null}.
 * @param offsetInFloats index in audioData from which the data is written.
 *        Must not be negative, or cause the data access to go out of bounds of the array.
 * @param sizeInFloats the number of requested floats.
 *        Must not be negative, or cause the data access to go out of bounds of the array.
 * @param readMode one of {@link #READ_BLOCKING}, {@link #READ_NON_BLOCKING}.
 *     <br>With {@link #READ_BLOCKING}, the read will block until all the requested data
 *     is read.
 *     <br>With {@link #READ_NON_BLOCKING}, the read will return immediately after
 *     reading as much audio data as possible without blocking.
 * Value is {@link android.media.AudioRecord#READ_BLOCKING}, or {@link android.media.AudioRecord#READ_NON_BLOCKING}
 * @return zero or the positive number of floats that were read, or one of the following
 *    error codes. The number of floats will be a multiple of the channel count not to exceed
 *    sizeInFloats.
 * <ul>
 * <li>{@link #ERROR_INVALID_OPERATION} if the object isn't properly initialized</li>
 * <li>{@link #ERROR_BAD_VALUE} if the parameters don't resolve to valid data and indexes</li>
 * <li>{@link #ERROR_DEAD_OBJECT} if the object is not valid anymore and
 *    needs to be recreated. The dead object error code is not returned if some data was
 *    successfully transferred. In this case, the error is returned at the next read()</li>
 * <li>{@link #ERROR} in case of other error</li>
 * </ul>
 * @apiSince 23
 */

public int read(@androidx.annotation.NonNull float[] audioData, int offsetInFloats, int sizeInFloats, int readMode) { throw new RuntimeException("Stub!"); }

/**
 * Reads audio data from the audio hardware for recording into a direct buffer. If this buffer
 * is not a direct buffer, this method will always return 0.
 * Note that the value returned by {@link java.nio.Buffer#position()} on this buffer is
 * unchanged after a call to this method.
 * The representation of the data in the buffer will depend on the format specified in
 * the AudioRecord constructor, and will be native endian.
 * @param audioBuffer the direct buffer to which the recorded audio data is written.
 * Data is written to audioBuffer.position().
 * This value must never be {@code null}.
 * @param sizeInBytes the number of requested bytes. It is recommended but not enforced
 *    that the number of bytes requested be a multiple of the frame size (sample size in
 *    bytes multiplied by the channel count).
 * @return zero or the positive number of bytes that were read, or one of the following
 *    error codes. The number of bytes will not exceed sizeInBytes and will be truncated to be
 *    a multiple of the frame size.
 * <ul>
 * <li>{@link #ERROR_INVALID_OPERATION} if the object isn't properly initialized</li>
 * <li>{@link #ERROR_BAD_VALUE} if the parameters don't resolve to valid data and indexes</li>
 * <li>{@link #ERROR_DEAD_OBJECT} if the object is not valid anymore and
 *    needs to be recreated. The dead object error code is not returned if some data was
 *    successfully transferred. In this case, the error is returned at the next read()</li>
 * <li>{@link #ERROR} in case of other error</li>
 * </ul>
 * @apiSince 3
 */

public int read(@androidx.annotation.NonNull java.nio.ByteBuffer audioBuffer, int sizeInBytes) { throw new RuntimeException("Stub!"); }

/**
 * Reads audio data from the audio hardware for recording into a direct buffer. If this buffer
 * is not a direct buffer, this method will always return 0.
 * Note that the value returned by {@link java.nio.Buffer#position()} on this buffer is
 * unchanged after a call to this method.
 * The representation of the data in the buffer will depend on the format specified in
 * the AudioRecord constructor, and will be native endian.
 * @param audioBuffer the direct buffer to which the recorded audio data is written.
 * Data is written to audioBuffer.position().
 * This value must never be {@code null}.
 * @param sizeInBytes the number of requested bytes. It is recommended but not enforced
 *    that the number of bytes requested be a multiple of the frame size (sample size in
 *    bytes multiplied by the channel count).
 * @param readMode one of {@link #READ_BLOCKING}, {@link #READ_NON_BLOCKING}.
 *     <br>With {@link #READ_BLOCKING}, the read will block until all the requested data
 *     is read.
 *     <br>With {@link #READ_NON_BLOCKING}, the read will return immediately after
 *     reading as much audio data as possible without blocking.
 * Value is {@link android.media.AudioRecord#READ_BLOCKING}, or {@link android.media.AudioRecord#READ_NON_BLOCKING}
 * @return zero or the positive number of bytes that were read, or one of the following
 *    error codes. The number of bytes will not exceed sizeInBytes and will be truncated to be
 *    a multiple of the frame size.
 * <ul>
 * <li>{@link #ERROR_INVALID_OPERATION} if the object isn't properly initialized</li>
 * <li>{@link #ERROR_BAD_VALUE} if the parameters don't resolve to valid data and indexes</li>
 * <li>{@link #ERROR_DEAD_OBJECT} if the object is not valid anymore and
 *    needs to be recreated. The dead object error code is not returned if some data was
 *    successfully transferred. In this case, the error is returned at the next read()</li>
 * <li>{@link #ERROR} in case of other error</li>
 * </ul>
 * @apiSince 23
 */

public int read(@androidx.annotation.NonNull java.nio.ByteBuffer audioBuffer, int sizeInBytes, int readMode) { throw new RuntimeException("Stub!"); }

/**
 *  Return Metrics data about the current AudioTrack instance.
 *
 * @return a {@link android.os.PersistableBundle PersistableBundle} containing the set of attributes and values
 * available for the media being handled by this instance of AudioRecord
 * The attributes are descibed in {@link android.media.AudioRecord.MetricsConstants MetricsConstants}.
 *
 * Additional vendor-specific fields may also be present in
 * the return value.
 * @apiSince 28
 */

public android.os.PersistableBundle getMetrics() { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener the AudioRecord notifies when a previously set marker is reached or
 * for each periodic record head position update.
 * @param listener
 * @apiSince 3
 */

public void setRecordPositionUpdateListener(android.media.AudioRecord.OnRecordPositionUpdateListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener the AudioRecord notifies when a previously set marker is reached or
 * for each periodic record head position update.
 * Use this method to receive AudioRecord events in the Handler associated with another
 * thread than the one in which you created the AudioRecord instance.
 * @param listener
 * @param handler the Handler that will receive the event notification messages.
 * @apiSince 3
 */

public void setRecordPositionUpdateListener(android.media.AudioRecord.OnRecordPositionUpdateListener listener, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Sets the marker position at which the listener is called, if set with
 * {@link #setRecordPositionUpdateListener(android.media.AudioRecord.OnRecordPositionUpdateListener)} or
 * {@link #setRecordPositionUpdateListener(android.media.AudioRecord.OnRecordPositionUpdateListener,android.os.Handler)}.
 * @param markerInFrames marker position expressed in frames
 * @return error code or success, see {@link #SUCCESS}, {@link #ERROR_BAD_VALUE},
 *  {@link #ERROR_INVALID_OPERATION}
 * @apiSince 3
 */

public int setNotificationMarkerPosition(int markerInFrames) { throw new RuntimeException("Stub!"); }

/**
 * Returns an {@link android.media.AudioDeviceInfo AudioDeviceInfo} identifying the current routing of this AudioRecord.
 * Note: The query is only valid if the AudioRecord is currently recording. If it is not,
 * <code>getRoutedDevice()</code> will return null.
 * @apiSince 23
 */

public android.media.AudioDeviceInfo getRoutedDevice() { throw new RuntimeException("Stub!"); }

/**
 * Adds an {@link android.media.AudioRouting.OnRoutingChangedListener AudioRouting.OnRoutingChangedListener} to receive notifications of
 * routing changes on this AudioRecord.
 * @param listener The {@link android.media.AudioRouting.OnRoutingChangedListener AudioRouting.OnRoutingChangedListener} interface to receive
 * notifications of rerouting events.
 * @param handler  Specifies the {@link android.os.Handler Handler} object for the thread on which to execute
 * the callback. If <code>null</code>, the {@link android.os.Handler Handler} associated with the main
 * {@link android.os.Looper Looper} will be used.
 * @apiSince 24
 */

public void addOnRoutingChangedListener(android.media.AudioRouting.OnRoutingChangedListener listener, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Removes an {@link android.media.AudioRouting.OnRoutingChangedListener AudioRouting.OnRoutingChangedListener} which has been previously added
 * to receive rerouting notifications.
 * @param listener The previously added {@link android.media.AudioRouting.OnRoutingChangedListener AudioRouting.OnRoutingChangedListener} interface
 * to remove.
 * @apiSince 24
  */

public void removeOnRoutingChangedListener(android.media.AudioRouting.OnRoutingChangedListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Adds an {@link android.media.AudioRecord.OnRoutingChangedListener OnRoutingChangedListener} to receive notifications of routing changes
 * on this AudioRecord.
 * @param listener The {@link android.media.AudioRecord.OnRoutingChangedListener OnRoutingChangedListener} interface to receive notifications
 * of rerouting events.
 * @param handler  Specifies the {@link android.os.Handler Handler} object for the thread on which to execute
 * the callback. If <code>null</code>, the {@link android.os.Handler Handler} associated with the main
 * {@link android.os.Looper Looper} will be used.
 * @deprecated users should switch to the general purpose
 *             {@link android.media.AudioRouting.OnRoutingChangedListener AudioRouting.OnRoutingChangedListener} class instead.
 * @apiSince 23
 * @deprecatedSince 24
 */

@Deprecated
public void addOnRoutingChangedListener(android.media.AudioRecord.OnRoutingChangedListener listener, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Removes an {@link android.media.AudioRecord.OnRoutingChangedListener OnRoutingChangedListener} which has been previously added
 * to receive rerouting notifications.
 * @param listener The previously added {@link android.media.AudioRecord.OnRoutingChangedListener OnRoutingChangedListener} interface to remove.
 * @deprecated users should switch to the general purpose
 *             {@link android.media.AudioRouting.OnRoutingChangedListener AudioRouting.OnRoutingChangedListener} class instead.
 * @apiSince 23
 * @deprecatedSince 24
  */

@Deprecated
public void removeOnRoutingChangedListener(android.media.AudioRecord.OnRoutingChangedListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Sets the period at which the listener is called, if set with
 * {@link #setRecordPositionUpdateListener(android.media.AudioRecord.OnRecordPositionUpdateListener)} or
 * {@link #setRecordPositionUpdateListener(android.media.AudioRecord.OnRecordPositionUpdateListener,android.os.Handler)}.
 * It is possible for notifications to be lost if the period is too small.
 * @param periodInFrames update period expressed in frames
 * @return error code or success, see {@link #SUCCESS}, {@link #ERROR_INVALID_OPERATION}
 * @apiSince 3
 */

public int setPositionNotificationPeriod(int periodInFrames) { throw new RuntimeException("Stub!"); }

/**
 * Specifies an audio device (via an {@link android.media.AudioDeviceInfo AudioDeviceInfo} object) to route
 * the input to this AudioRecord.
 * @param deviceInfo The {@link android.media.AudioDeviceInfo AudioDeviceInfo} specifying the audio source.
 *  If deviceInfo is null, default routing is restored.
 * @return true if successful, false if the specified {@link android.media.AudioDeviceInfo AudioDeviceInfo} is non-null and
 * does not correspond to a valid audio input device.
 * @apiSince 23
 */

public boolean setPreferredDevice(android.media.AudioDeviceInfo deviceInfo) { throw new RuntimeException("Stub!"); }

/**
 * Returns the selected input specified by {@link #setPreferredDevice}. Note that this
 * is not guarenteed to correspond to the actual device being used for recording.
 * @apiSince 23
 */

public android.media.AudioDeviceInfo getPreferredDevice() { throw new RuntimeException("Stub!"); }

/**
 * Returns a lists of {@link android.media.MicrophoneInfo MicrophoneInfo} representing the active microphones.
 * By querying channel mapping for each active microphone, developer can know how
 * the microphone is used by each channels or a capture stream.
 * Note that the information about the active microphones may change during a recording.
 * See {@link android.media.AudioManager#registerAudioDeviceCallback AudioManager#registerAudioDeviceCallback} to be notified of changes
 * in the audio devices, querying the active microphones then will return the latest
 * information.
 *
 * @return a lists of {@link android.media.MicrophoneInfo MicrophoneInfo} representing the active microphones.
 * @throws java.io.IOException if an error occurs
 * @apiSince 28
 */

public java.util.List<android.media.MicrophoneInfo> getActiveMicrophones() throws java.io.IOException { throw new RuntimeException("Stub!"); }

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

public void registerAudioRecordingCallback(@androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull android.media.AudioManager.AudioRecordingCallback cb) { throw new RuntimeException("Stub!"); }

/**
 * Unregister an audio recording callback previously registered with
 * {@link #registerAudioRecordingCallback(java.util.concurrent.Executor,android.media.AudioManager.AudioRecordingCallback)}.
 * @param cb non-null callback to unregister
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void unregisterAudioRecordingCallback(@androidx.annotation.NonNull android.media.AudioManager.AudioRecordingCallback cb) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current active audio recording for this audio recorder.
 * @return a valid {@link android.media.AudioRecordingConfiguration AudioRecordingConfiguration} if this recorder is active
 * or null otherwise.
 * @see android.media.AudioRecordingConfiguration
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.media.AudioRecordingConfiguration getActiveRecordingConfiguration() { throw new RuntimeException("Stub!"); }

/**
 * Specifies the logical microphone (for processing). Applications can use this to specify
 * which side of the device to optimize capture from. Typically used in conjunction with
 * the camera capturing video.
 *
 * @param direction Value is {@link android.media.MicrophoneDirection#MIC_DIRECTION_UNSPECIFIED}, {@link android.media.MicrophoneDirection#MIC_DIRECTION_TOWARDS_USER}, {@link android.media.MicrophoneDirection#MIC_DIRECTION_AWAY_FROM_USER}, or {@link android.media.MicrophoneDirection#MIC_DIRECTION_EXTERNAL}
 * @return true if sucessful.
 * @apiSince 29
 */

public boolean setPreferredMicrophoneDirection(int direction) { throw new RuntimeException("Stub!"); }

/**
 * Specifies the zoom factor (i.e. the field dimension) for the selected microphone
 * (for processing). The selected microphone is determined by the use-case for the stream.
 *
 * @param zoom the desired field dimension of microphone capture. Range is from -1 (wide angle),
 * though 0 (no zoom) to 1 (maximum zoom).
 * Value is between -1.0 and 1.0 inclusive
 * @return true if sucessful.
 * @apiSince 29
 */

public boolean setPreferredMicrophoneFieldDimension(float zoom) { throw new RuntimeException("Stub!"); }

/**
 * Denotes a generic operation failure.
 * @apiSince 3
 */

public static final int ERROR = -1; // 0xffffffff

/**
 * Denotes a failure due to the use of an invalid value.
 * @apiSince 3
 */

public static final int ERROR_BAD_VALUE = -2; // 0xfffffffe

/**
 * An error code indicating that the object reporting it is no longer valid and needs to
 * be recreated.
 * @apiSince 24
 */

public static final int ERROR_DEAD_OBJECT = -6; // 0xfffffffa

/**
 * Denotes a failure due to the improper use of a method.
 * @apiSince 3
 */

public static final int ERROR_INVALID_OPERATION = -3; // 0xfffffffd

/**
 * The read mode indicating the read operation will block until all data
 * requested has been read.
 * @apiSince 23
 */

public static final int READ_BLOCKING = 0; // 0x0

/**
 * The read mode indicating the read operation will return immediately after
 * reading as much audio data as possible without blocking.
 * @apiSince 23
 */

public static final int READ_NON_BLOCKING = 1; // 0x1

/**
 * indicates AudioRecord recording state is recording
 * @apiSince 3
 */

public static final int RECORDSTATE_RECORDING = 3; // 0x3

/**
 * indicates AudioRecord recording state is not recording
 * @apiSince 3
 */

public static final int RECORDSTATE_STOPPED = 1; // 0x1

/**
 *  indicates AudioRecord state is ready to be used
 * @apiSince 3
 */

public static final int STATE_INITIALIZED = 1; // 0x1

/**
 *  indicates AudioRecord state is not successfully initialized.
 * @apiSince 3
 */

public static final int STATE_UNINITIALIZED = 0; // 0x0

/**
 * Denotes a successful operation.
 * @apiSince 3
 */

public static final int SUCCESS = 0; // 0x0
/**
 * Builder class for {@link android.media.AudioRecord AudioRecord} objects.
 * Use this class to configure and create an <code>AudioRecord</code> instance. By setting the
 * recording source and audio format parameters, you indicate which of
 * those vary from the default behavior on the device.
 * <p> Here is an example where <code>Builder</code> is used to specify all {@link android.media.AudioFormat AudioFormat}
 * parameters, to be used by a new <code>AudioRecord</code> instance:
 *
 * <pre class="prettyprint">
 * AudioRecord recorder = new AudioRecord.Builder()
 *         .setAudioSource(MediaRecorder.AudioSource.VOICE_COMMUNICATION)
 *         .setAudioFormat(new AudioFormat.Builder()
 *                 .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
 *                 .setSampleRate(32000)
 *                 .setChannelMask(AudioFormat.CHANNEL_IN_MONO)
 *                 .build())
 *         .setBufferSizeInBytes(2*minBuffSize)
 *         .build();
 * </pre>
 * <p>
 * If the audio source is not set with {@link #setAudioSource(int)},
 * {@link android.media.MediaRecorder.AudioSource#DEFAULT MediaRecorder.AudioSource#DEFAULT} is used.
 * <br>If the audio format is not specified or is incomplete, its channel configuration will be
 * {@link android.media.AudioFormat#CHANNEL_IN_MONO AudioFormat#CHANNEL_IN_MONO}, and the encoding will be
 * {@link android.media.AudioFormat#ENCODING_PCM_16BIT AudioFormat#ENCODING_PCM_16BIT}.
 * The sample rate will depend on the device actually selected for capture and can be queried
 * with {@link #getSampleRate()} method.
 * <br>If the buffer size is not specified with {@link #setBufferSizeInBytes(int)},
 * the minimum buffer size for the source is used.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

/**
 * Constructs a new Builder with the default values as described above.
 * @apiSince 23
 */

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * @param source the audio source.
 * See {@link android.media.MediaRecorder.AudioSource MediaRecorder.AudioSource} for the supported audio source definitions.
 * Value is {@link android.media.MediaRecorder.AudioSource#DEFAULT}, {@link android.media.MediaRecorder.AudioSource#MIC}, {@link android.media.MediaRecorder.AudioSource#VOICE_UPLINK}, {@link android.media.MediaRecorder.AudioSource#VOICE_DOWNLINK}, {@link android.media.MediaRecorder.AudioSource#VOICE_CALL}, {@link android.media.MediaRecorder.AudioSource#CAMCORDER}, {@link android.media.MediaRecorder.AudioSource#VOICE_RECOGNITION}, {@link android.media.MediaRecorder.AudioSource#VOICE_COMMUNICATION}, {@link android.media.MediaRecorder.AudioSource#UNPROCESSED}, or {@link android.media.MediaRecorder.AudioSource#VOICE_PERFORMANCE}
 * @return the same Builder instance.
 * @throws java.lang.IllegalArgumentException
 * @apiSince 23
 */

public android.media.AudioRecord.Builder setAudioSource(int source) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Sets the format of the audio data to be captured.
 * @param format a non-null {@link android.media.AudioFormat AudioFormat} instance
 * This value must never be {@code null}.
 * @return the same Builder instance.
 * @throws java.lang.IllegalArgumentException
 * @apiSince 23
 */

public android.media.AudioRecord.Builder setAudioFormat(@androidx.annotation.NonNull android.media.AudioFormat format) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Sets the total size (in bytes) of the buffer where audio data is written
 * during the recording. New audio data can be read from this buffer in smaller chunks
 * than this size. See {@link #getMinBufferSize(int,int,int)} to determine the minimum
 * required buffer size for the successful creation of an AudioRecord instance.
 * Since bufferSizeInBytes may be internally increased to accommodate the source
 * requirements, use {@link #getBufferSizeInFrames()} to determine the actual buffer size
 * in frames.
 * @param bufferSizeInBytes a value strictly greater than 0
 * @return the same Builder instance.
 * @throws java.lang.IllegalArgumentException
 * @apiSince 23
 */

public android.media.AudioRecord.Builder setBufferSizeInBytes(int bufferSizeInBytes) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link android.media.AudioRecord AudioRecord} to record audio played by other apps.
 *
 * @param config Defines what apps to record audio from (i.e., via either their uid or
 *               the type of audio).
 * This value must never be {@code null}.
 * @throws java.lang.IllegalStateException if called in conjunction with {@link #setAudioSource(int)}.
 * @throws java.lang.NullPointerException if {@code config} is null.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.media.AudioRecord.Builder setAudioPlaybackCaptureConfig(@androidx.annotation.NonNull android.media.AudioPlaybackCaptureConfiguration config) { throw new RuntimeException("Stub!"); }

/**
 * @return a new {@link android.media.AudioRecord AudioRecord} instance successfully initialized with all
 *     the parameters set on this <code>Builder</code>.
 * @throws java.lang.UnsupportedOperationException if the parameters set on the <code>Builder</code>
 *     were incompatible, or if they are not supported by the device,
 *     or if the device was not available.
 * @apiSince 23
 */

public android.media.AudioRecord build() throws java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }
}

/** @apiSince 28 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class MetricsConstants {

private MetricsConstants() { throw new RuntimeException("Stub!"); }

/**
 * Key to extract the number of channels being recorded in this record track
 * from the {@link android.media.AudioRecord#getMetrics AudioRecord#getMetrics} return value.
 * The value is an {@code int}.
 * @apiSince 28
 */

public static final java.lang.String CHANNELS = "android.media.audiorecord.channels";

/**
 * Key to extract the audio data encoding for this track
 * from the {@link android.media.AudioRecord#getMetrics AudioRecord#getMetrics} return value.
 * The value is a {@code String}.
 * @apiSince 28
 */

public static final java.lang.String ENCODING = "android.media.audiorecord.encoding";

/**
 * Key to extract the estimated latency through the recording pipeline
 * from the {@link android.media.AudioRecord#getMetrics AudioRecord#getMetrics} return value.
 * This is in units of milliseconds.
 * The value is an {@code int}.
 * @deprecated Not properly supported in the past.
 * @apiSince 28
 * @deprecatedSince 29
 */

@Deprecated public static final java.lang.String LATENCY = "android.media.audiorecord.latency";

/**
 * Key to extract the sink sample rate for this record track in Hz
 * from the {@link android.media.AudioRecord#getMetrics AudioRecord#getMetrics} return value.
 * The value is an {@code int}.
 * @apiSince 28
 */

public static final java.lang.String SAMPLERATE = "android.media.audiorecord.samplerate";

/**
 * Key to extract the source type for this track
 * from the {@link android.media.AudioRecord#getMetrics AudioRecord#getMetrics} return value.
 * The value is a {@code String}.
 * @apiSince 28
 */

public static final java.lang.String SOURCE = "android.media.audiorecord.source";
}

/**
 * Interface definition for a callback to be invoked when an AudioRecord has
 * reached a notification marker set by {@link android.media.AudioRecord#setNotificationMarkerPosition(int) AudioRecord#setNotificationMarkerPosition(int)}
 * or for periodic updates on the progress of the record head, as set by
 * {@link android.media.AudioRecord#setPositionNotificationPeriod(int) AudioRecord#setPositionNotificationPeriod(int)}.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnRecordPositionUpdateListener {

/**
 * Called on the listener to notify it that the previously set marker has been reached
 * by the recording head.
 * @apiSince 3
 */

public void onMarkerReached(android.media.AudioRecord recorder);

/**
 * Called on the listener to periodically notify it that the record head has reached
 * a multiple of the notification period.
 * @apiSince 3
 */

public void onPeriodicNotification(android.media.AudioRecord recorder);
}

/**
 * Defines the interface by which applications can receive notifications of
 * routing changes for the associated {@link android.media.AudioRecord AudioRecord}.
 *
 * @deprecated users should switch to the general purpose
 *             {@link android.media.AudioRouting.OnRoutingChangedListener AudioRouting.OnRoutingChangedListener} class instead.
 * @apiSince 23
 * @deprecatedSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface OnRoutingChangedListener extends android.media.AudioRouting.OnRoutingChangedListener {

/**
 * Called when the routing of an AudioRecord changes from either and
 * explicit or policy rerouting. Use {@link #getRoutedDevice()} to
 * retrieve the newly routed-from device.
 * @apiSince 23
 * @deprecatedSince 24
 */

@Deprecated
public void onRoutingChanged(android.media.AudioRecord audioRecord);

/**
 * @apiSince 24
 * @deprecatedSince 24
 */

@Deprecated
public default void onRoutingChanged(android.media.AudioRouting router) { throw new RuntimeException("Stub!"); }
}

}

