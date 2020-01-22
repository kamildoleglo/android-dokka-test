/*
 * Copyright (C) 2007 The Android Open Source Project
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

import android.os.Looper;
import android.hardware.Camera;
import android.view.Surface;
import java.io.File;
import java.io.IOException;
import android.os.Handler;
import java.util.concurrent.Executor;
import android.os.PersistableBundle;

/**
 * Used to record audio and video. The recording control is based on a
 * simple state machine (see below).
 *
 * <p><img src="{@docRoot}images/mediarecorder_state_diagram.gif" border="0" />
 * </p>
 *
 * <p>A common case of using MediaRecorder to record audio works as follows:
 *
 * <pre>MediaRecorder recorder = new MediaRecorder();
 * recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
 * recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
 * recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
 * recorder.setOutputFile(PATH_NAME);
 * recorder.prepare();
 * recorder.start();   // Recording is now started
 * ...
 * recorder.stop();
 * recorder.reset();   // You can reuse the object by going back to setAudioSource() step
 * recorder.release(); // Now the object cannot be reused
 * </pre>
 *
 * <p>Applications may want to register for informational and error
 * events in order to be informed of some internal update and possible
 * runtime errors during recording. Registration for such events is
 * done by setting the appropriate listeners (via calls
 * (to {@link #setOnInfoListener(android.media.MediaRecorder.OnInfoListener)}setOnInfoListener and/or
 * {@link #setOnErrorListener(android.media.MediaRecorder.OnErrorListener)}setOnErrorListener).
 * In order to receive the respective callback associated with these listeners,
 * applications are required to create MediaRecorder objects on threads with a
 * Looper running (the main UI thread by default already has a Looper running).
 *
 * <p><strong>Note:</strong> Currently, MediaRecorder does not work on the emulator.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about how to use MediaRecorder for recording video, read the
 * <a href="{@docRoot}guide/topics/media/camera.html#capture-video">Camera</a> developer guide.
 * For more information about how to use MediaRecorder for recording sound, read the
 * <a href="{@docRoot}guide/topics/media/audio-capture.html">Audio Capture</a> developer guide.</p>
 * </div>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MediaRecorder implements android.media.AudioRouting, android.media.AudioRecordingMonitor, android.media.MicrophoneDirection {

/**
 * Default constructor.
 * @apiSince 1
 */

public MediaRecorder() { throw new RuntimeException("Stub!"); }

/**
 * Sets a {@link android.hardware.Camera} to use for recording.
 *
 * <p>Use this function to switch quickly between preview and capture mode without a teardown of
 * the camera object. {@link android.hardware.Camera#unlock()} should be called before
 * this. Must call before {@link #prepare}.</p>
 *
 * @param c the Camera to use for recording
 * @deprecated Use {@link #getSurface} and the {@link android.hardware.camera2} API instead.
 * @apiSince 3
 * @deprecatedSince 21
 */

@Deprecated
public native void setCamera(android.hardware.Camera c);

/**
 * Gets the surface to record from when using SURFACE video source.
 *
 * <p> May only be called after {@link #prepare}. Frames rendered to the Surface before
 * {@link #start} will be discarded.</p>
 *
 * @throws java.lang.IllegalStateException if it is called before {@link #prepare}, after
 * {@link #stop}, or is called when VideoSource is not set to SURFACE.
 * @see android.media.MediaRecorder.VideoSource
 * @apiSince 21
 */

public native android.view.Surface getSurface();

/**
 * Configures the recorder to use a persistent surface when using SURFACE video source.
 * <p> May only be called before {@link #prepare}. If called, {@link #getSurface} should
 * not be used and will throw IllegalStateException. Frames rendered to the Surface
 * before {@link #start} will be discarded.</p>
 
 * @param surface a persistent input surface created by
 *           {@link android.media.MediaCodec#createPersistentInputSurface MediaCodec#createPersistentInputSurface}
 * This value must never be {@code null}.
 * @throws java.lang.IllegalStateException if it is called after {@link #prepare} and before
 * {@link #stop}.
 * @throws java.lang.IllegalArgumentException if the surface was not created by
 *           {@link android.media.MediaCodec#createPersistentInputSurface MediaCodec#createPersistentInputSurface}.
 * @see android.media.MediaCodec#createPersistentInputSurface
 * @see android.media.MediaRecorder.VideoSource
 * @apiSince 23
 */

public void setInputSurface(@androidx.annotation.NonNull android.view.Surface surface) { throw new RuntimeException("Stub!"); }

/**
 * Sets a Surface to show a preview of recorded media (video). Calls this
 * before prepare() to make sure that the desirable preview display is
 * set. If {@link #setCamera(android.hardware.Camera)} is used and the surface has been
 * already set to the camera, application do not need to call this. If
 * this is called with non-null surface, the preview surface of the camera
 * will be replaced by the new surface. If this method is called with null
 * surface or not called at all, media recorder will not change the preview
 * surface of the camera.
 *
 * @param sv the Surface to use for the preview
 * @see android.hardware.Camera#setPreviewDisplay(android.view.SurfaceHolder)
 * @apiSince 1
 */

public void setPreviewDisplay(android.view.Surface sv) { throw new RuntimeException("Stub!"); }

/**
 * Sets the audio source to be used for recording. If this method is not
 * called, the output file will not contain an audio track. The source needs
 * to be specified before setting recording-parameters or encoders. Call
 * this only before setOutputFormat().
 *
 * @param audioSource the audio source to use
 * Value is {@link android.media.MediaRecorder.AudioSource#DEFAULT}, {@link android.media.MediaRecorder.AudioSource#MIC}, {@link android.media.MediaRecorder.AudioSource#VOICE_UPLINK}, {@link android.media.MediaRecorder.AudioSource#VOICE_DOWNLINK}, {@link android.media.MediaRecorder.AudioSource#VOICE_CALL}, {@link android.media.MediaRecorder.AudioSource#CAMCORDER}, {@link android.media.MediaRecorder.AudioSource#VOICE_RECOGNITION}, {@link android.media.MediaRecorder.AudioSource#VOICE_COMMUNICATION}, {@link android.media.MediaRecorder.AudioSource#UNPROCESSED}, or {@link android.media.MediaRecorder.AudioSource#VOICE_PERFORMANCE}
 * @throws java.lang.IllegalStateException if it is called after setOutputFormat()
 * @see android.media.MediaRecorder.AudioSource
 * @apiSince 1
 */

public native void setAudioSource(int audioSource) throws java.lang.IllegalStateException;

/**
 * Gets the maximum value for audio sources.
 * @see android.media.MediaRecorder.AudioSource
 * @apiSince 4
 */

public static final int getAudioSourceMax() { throw new RuntimeException("Stub!"); }

/**
 * Sets the video source to be used for recording. If this method is not
 * called, the output file will not contain an video track. The source needs
 * to be specified before setting recording-parameters or encoders. Call
 * this only before setOutputFormat().
 *
 * @param video_source the video source to use
 * @throws java.lang.IllegalStateException if it is called after setOutputFormat()
 * @see android.media.MediaRecorder.VideoSource
 * @apiSince 3
 */

public native void setVideoSource(int video_source) throws java.lang.IllegalStateException;

/**
 * Uses the settings from a CamcorderProfile object for recording. This method should
 * be called after the video AND audio sources are set, and before setOutputFile().
 * If a time lapse CamcorderProfile is used, audio related source or recording
 * parameters are ignored.
 *
 * @param profile the CamcorderProfile to use
 * @see android.media.CamcorderProfile
 * @apiSince 8
 */

public void setProfile(android.media.CamcorderProfile profile) { throw new RuntimeException("Stub!"); }

/**
 * Set video frame capture rate. This can be used to set a different video frame capture
 * rate than the recorded video's playback rate. This method also sets the recording mode
 * to time lapse. In time lapse video recording, only video is recorded. Audio related
 * parameters are ignored when a time lapse recording session starts, if an application
 * sets them.
 *
 * @param fps Rate at which frames should be captured in frames per second.
 * The fps can go as low as desired. However the fastest fps will be limited by the hardware.
 * For resolutions that can be captured by the video camera, the fastest fps can be computed using
 * {@link android.hardware.Camera.Parameters#getPreviewFpsRange(int[])}. For higher
 * resolutions the fastest fps may be more restrictive.
 * Note that the recorder cannot guarantee that frames will be captured at the
 * given rate due to camera/encoder limitations. However it tries to be as close as
 * possible.
 * @apiSince 11
 */

public void setCaptureRate(double fps) { throw new RuntimeException("Stub!"); }

/**
 * Sets the orientation hint for output video playback.
 * This method should be called before prepare(). This method will not
 * trigger the source video frame to rotate during video recording, but to
 * add a composition matrix containing the rotation angle in the output
 * video if the output format is OutputFormat.THREE_GPP or
 * OutputFormat.MPEG_4 so that a video player can choose the proper
 * orientation for playback. Note that some video players may choose
 * to ignore the compostion matrix in a video during playback.
 *
 * @param degrees the angle to be rotated clockwise in degrees.
 * The supported angles are 0, 90, 180, and 270 degrees.
 * @throws java.lang.IllegalArgumentException if the angle is not supported.
 *
 * @apiSince 9
 */

public void setOrientationHint(int degrees) { throw new RuntimeException("Stub!"); }

/**
 * Set and store the geodata (latitude and longitude) in the output file.
 * This method should be called before prepare(). The geodata is
 * stored in udta box if the output format is OutputFormat.THREE_GPP
 * or OutputFormat.MPEG_4, and is ignored for other output formats.
 * The geodata is stored according to ISO-6709 standard.
 *
 * @param latitude latitude in degrees. Its value must be in the
 * range [-90, 90].
 * @param longitude longitude in degrees. Its value must be in the
 * range [-180, 180].
 *
 * @throws java.lang.IllegalArgumentException if the given latitude or
 * longitude is out of range.
 *
 * @apiSince 14
 */

public void setLocation(float latitude, float longitude) { throw new RuntimeException("Stub!"); }

/**
 * Sets the format of the output file produced during recording. Call this
 * after setAudioSource()/setVideoSource() but before prepare().
 *
 * <p>It is recommended to always use 3GP format when using the H.263
 * video encoder and AMR audio encoder. Using an MPEG-4 container format
 * may confuse some desktop players.</p>
 *
 * @param output_format the output format to use. The output format
 * needs to be specified before setting recording-parameters or encoders.
 * @throws java.lang.IllegalStateException if it is called after prepare() or before
 * setAudioSource()/setVideoSource().
 * @see android.media.MediaRecorder.OutputFormat
 * @apiSince 1
 */

public native void setOutputFormat(int output_format) throws java.lang.IllegalStateException;

/**
 * Sets the width and height of the video to be captured.  Must be called
 * after setVideoSource(). Call this after setOutFormat() but before
 * prepare().
 *
 * @param width the width of the video to be captured
 * @param height the height of the video to be captured
 * @throws java.lang.IllegalStateException if it is called after
 * prepare() or before setOutputFormat()
 * @apiSince 3
 */

public native void setVideoSize(int width, int height) throws java.lang.IllegalStateException;

/**
 * Sets the frame rate of the video to be captured.  Must be called
 * after setVideoSource(). Call this after setOutFormat() but before
 * prepare().
 *
 * @param rate the number of frames per second of video to capture
 * @throws java.lang.IllegalStateException if it is called after
 * prepare() or before setOutputFormat().
 *
 * NOTE: On some devices that have auto-frame rate, this sets the
 * maximum frame rate, not a constant frame rate. Actual frame rate
 * will vary according to lighting conditions.
 * @apiSince 3
 */

public native void setVideoFrameRate(int rate) throws java.lang.IllegalStateException;

/**
 * Sets the maximum duration (in ms) of the recording session.
 * Call this after setOutFormat() but before prepare().
 * After recording reaches the specified duration, a notification
 * will be sent to the {@link android.media.MediaRecorder.OnInfoListener}
 * with a "what" code of {@link #MEDIA_RECORDER_INFO_MAX_DURATION_REACHED}
 * and recording will be stopped. Stopping happens asynchronously, there
 * is no guarantee that the recorder will have stopped by the time the
 * listener is notified.
 *
 * <p>When using MPEG-4 container ({@link #setOutputFormat(int)} with
 * {@link android.media.MediaRecorder.OutputFormat#MPEG_4 OutputFormat#MPEG_4}), it is recommended to set maximum duration that fits the use
 * case. Setting a larger than required duration may result in a larger than needed output file
 * because of space reserved for MOOV box expecting large movie data in this recording session.
 *  Unused space of MOOV box is turned into FREE box in the output file.</p>
 *
 * @param max_duration_ms the maximum duration in ms (if zero or negative, disables the duration limit)
 *
 * @apiSince 3
 */

public native void setMaxDuration(int max_duration_ms) throws java.lang.IllegalArgumentException;

/**
 * Sets the maximum filesize (in bytes) of the recording session.
 * Call this after setOutFormat() but before prepare().
 * After recording reaches the specified filesize, a notification
 * will be sent to the {@link android.media.MediaRecorder.OnInfoListener}
 * with a "what" code of {@link #MEDIA_RECORDER_INFO_MAX_FILESIZE_REACHED}
 * and recording will be stopped. Stopping happens asynchronously, there
 * is no guarantee that the recorder will have stopped by the time the
 * listener is notified.
 *
 * <p>When using MPEG-4 container ({@link #setOutputFormat(int)} with
 * {@link android.media.MediaRecorder.OutputFormat#MPEG_4 OutputFormat#MPEG_4}), it is recommended to set maximum filesize that fits the use
 * case. Setting a larger than required filesize may result in a larger than needed output file
 * because of space reserved for MOOV box expecting large movie data in this recording session.
 * Unused space of MOOV box is turned into FREE box in the output file.</p>
 *
 * @param max_filesize_bytes the maximum filesize in bytes (if zero or negative, disables the limit)
 *
 * @apiSince 3
 */

public native void setMaxFileSize(long max_filesize_bytes) throws java.lang.IllegalArgumentException;

/**
 * Sets the audio encoder to be used for recording. If this method is not
 * called, the output file will not contain an audio track. Call this after
 * setOutputFormat() but before prepare().
 *
 * @param audio_encoder the audio encoder to use.
 * @throws java.lang.IllegalStateException if it is called before
 * setOutputFormat() or after prepare().
 * @see android.media.MediaRecorder.AudioEncoder
 * @apiSince 1
 */

public native void setAudioEncoder(int audio_encoder) throws java.lang.IllegalStateException;

/**
 * Sets the video encoder to be used for recording. If this method is not
 * called, the output file will not contain an video track. Call this after
 * setOutputFormat() and before prepare().
 *
 * @param video_encoder the video encoder to use.
 * @throws java.lang.IllegalStateException if it is called before
 * setOutputFormat() or after prepare()
 * @see android.media.MediaRecorder.VideoEncoder
 * @apiSince 3
 */

public native void setVideoEncoder(int video_encoder) throws java.lang.IllegalStateException;

/**
 * Sets the audio sampling rate for recording. Call this method before prepare().
 * Prepare() may perform additional checks on the parameter to make sure whether
 * the specified audio sampling rate is applicable. The sampling rate really depends
 * on the format for the audio recording, as well as the capabilities of the platform.
 * For instance, the sampling rate supported by AAC audio coding standard ranges
 * from 8 to 96 kHz, the sampling rate supported by AMRNB is 8kHz, and the sampling
 * rate supported by AMRWB is 16kHz. Please consult with the related audio coding
 * standard for the supported audio sampling rate.
 *
 * @param samplingRate the sampling rate for audio in samples per second.
 * @apiSince 8
 */

public void setAudioSamplingRate(int samplingRate) { throw new RuntimeException("Stub!"); }

/**
 * Sets the number of audio channels for recording. Call this method before prepare().
 * Prepare() may perform additional checks on the parameter to make sure whether the
 * specified number of audio channels are applicable.
 *
 * @param numChannels the number of audio channels. Usually it is either 1 (mono) or 2
 * (stereo).
 * @apiSince 8
 */

public void setAudioChannels(int numChannels) { throw new RuntimeException("Stub!"); }

/**
 * Sets the audio encoding bit rate for recording. Call this method before prepare().
 * Prepare() may perform additional checks on the parameter to make sure whether the
 * specified bit rate is applicable, and sometimes the passed bitRate will be clipped
 * internally to ensure the audio recording can proceed smoothly based on the
 * capabilities of the platform.
 *
 * @param bitRate the audio encoding bit rate in bits per second.
 * @apiSince 8
 */

public void setAudioEncodingBitRate(int bitRate) { throw new RuntimeException("Stub!"); }

/**
 * Sets the video encoding bit rate for recording. Call this method before prepare().
 * Prepare() may perform additional checks on the parameter to make sure whether the
 * specified bit rate is applicable, and sometimes the passed bitRate will be
 * clipped internally to ensure the video recording can proceed smoothly based on
 * the capabilities of the platform.
 *
 * @param bitRate the video encoding bit rate in bits per second.
 * @apiSince 8
 */

public void setVideoEncodingBitRate(int bitRate) { throw new RuntimeException("Stub!"); }

/**
 * Sets the desired video encoding profile and level for recording. The profile and level
 * must be valid for the video encoder set by {@link #setVideoEncoder}. This method can
 * called before or after {@link #setVideoEncoder} but it must be called before {@link #prepare}.
 * {@code prepare()} may perform additional checks on the parameter to make sure that the specified
 * profile and level are applicable, and sometimes the passed profile or level will be
 * discarded due to codec capablity or to ensure the video recording can proceed smoothly
 * based on the capabilities of the platform. <br>Application can also use the
 * {@link android.media.MediaCodecInfo.CodecCapabilities#profileLevels MediaCodecInfo.CodecCapabilities#profileLevels} to query applicable combination of profile
 * and level for the corresponding format. Note that the requested profile/level may not be supported by
 * the codec that is actually being used by this MediaRecorder instance.
 * @param profile declared in {@link android.media.MediaCodecInfo.CodecProfileLevel MediaCodecInfo.CodecProfileLevel}.
 * @param level declared in {@link android.media.MediaCodecInfo.CodecProfileLevel MediaCodecInfo.CodecProfileLevel}.
 * @throws java.lang.IllegalArgumentException when an invalid profile or level value is used.
 * @apiSince 26
 */

public void setVideoEncodingProfileLevel(int profile, int level) { throw new RuntimeException("Stub!"); }

/**
 * Pass in the file descriptor of the file to be written. Call this after
 * setOutputFormat() but before prepare().
 *
 * @param fd an open file descriptor to be written into.
 * @throws java.lang.IllegalStateException if it is called before
 * setOutputFormat() or after prepare()
 * @apiSince 3
 */

public void setOutputFile(java.io.FileDescriptor fd) throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Pass in the file object to be written. Call this after setOutputFormat() but before prepare().
 * File should be seekable. After setting the next output file, application should not use the
 * file until {@link #stop}. Application is responsible for cleaning up unused files after
 * {@link #stop} is called.
 *
 * @param file the file object to be written into.
 * @apiSince 26
 */

public void setOutputFile(java.io.File file) { throw new RuntimeException("Stub!"); }

/**
 * Sets the next output file descriptor to be used when the maximum filesize is reached
 * on the prior output {@link #setOutputFile} or {@link #setNextOutputFile}). File descriptor
 * must be seekable and writable. After setting the next output file, application should not
 * use the file referenced by this file descriptor until {@link #stop}. It is the application's
 * responsibility to close the file descriptor. It is safe to do so as soon as this call returns.
 * Application must call this after receiving on the
 * {@link android.media.MediaRecorder.OnInfoListener} a "what" code of
 * {@link #MEDIA_RECORDER_INFO_MAX_FILESIZE_APPROACHING} and before receiving a "what" code of
 * {@link #MEDIA_RECORDER_INFO_MAX_FILESIZE_REACHED}. The file is not used until switching to
 * that output. Application will receive{@link #MEDIA_RECORDER_INFO_NEXT_OUTPUT_FILE_STARTED}
 * when the next output file is used. Application will not be able to set a new output file if
 * the previous one has not been used. Application is responsible for cleaning up unused files
 * after {@link #stop} is called.
 *
 * @param fd an open file descriptor to be written into.
 * @throws java.lang.IllegalStateException if it is called before prepare().
 * @throws java.io.IOException if setNextOutputFile fails otherwise.
 * @apiSince 26
 */

public void setNextOutputFile(java.io.FileDescriptor fd) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Sets the path of the output file to be produced. Call this after
 * setOutputFormat() but before prepare().
 *
 * @param path The pathname to use.
 * @throws java.lang.IllegalStateException if it is called before
 * setOutputFormat() or after prepare()
 * @apiSince 1
 */

public void setOutputFile(java.lang.String path) throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Sets the next output file to be used when the maximum filesize is reached on the prior
 * output {@link #setOutputFile} or {@link #setNextOutputFile}). File should be seekable.
 * After setting the next output file, application should not use the file until {@link #stop}.
 * Application must call this after receiving on the
 * {@link android.media.MediaRecorder.OnInfoListener} a "what" code of
 * {@link #MEDIA_RECORDER_INFO_MAX_FILESIZE_APPROACHING} and before receiving a "what" code of
 * {@link #MEDIA_RECORDER_INFO_MAX_FILESIZE_REACHED}. The file is not used until switching to
 * that output. Application will receive {@link #MEDIA_RECORDER_INFO_NEXT_OUTPUT_FILE_STARTED}
 * when the next output file is used. Application will not be able to set a new output file if
 * the previous one has not been used. Application is responsible for cleaning up unused files
 * after {@link #stop} is called.
 *
 * @param  file The file to use.
 * @throws java.lang.IllegalStateException if it is called before prepare().
 * @throws java.io.IOException if setNextOutputFile fails otherwise.
 * @apiSince 26
 */

public void setNextOutputFile(java.io.File file) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Prepares the recorder to begin capturing and encoding data. This method
 * must be called after setting up the desired audio and video sources,
 * encoders, file format, etc., but before start().
 *
 * @throws java.lang.IllegalStateException if it is called after
 * start() or before setOutputFormat().
 * @throws java.io.IOException if prepare fails otherwise.
 * @apiSince 1
 */

public void prepare() throws java.io.IOException, java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Begins capturing and encoding data to the file specified with
 * setOutputFile(). Call this after prepare().
 *
 * <p>Since API level 13, if applications set a camera via
 * {@link #setCamera(android.hardware.Camera)}, the apps can use the camera after this method
 * call. The apps do not need to lock the camera again. However, if this
 * method fails, the apps should still lock the camera back. The apps should
 * not start another recording session during recording.
 *
 * @throws java.lang.IllegalStateException if it is called before
 * prepare() or when the camera is already in use by another app.
 * @apiSince 1
 */

public native void start() throws java.lang.IllegalStateException;

/**
 * Stops recording. Call this after start(). Once recording is stopped,
 * you will have to configure it again as if it has just been constructed.
 * Note that a RuntimeException is intentionally thrown to the
 * application, if no valid audio/video data has been received when stop()
 * is called. This happens if stop() is called immediately after
 * start(). The failure lets the application take action accordingly to
 * clean up the output file (delete the output file, for instance), since
 * the output file is not properly constructed when this happens.
 *
 * @throws java.lang.IllegalStateException if it is called before start()
 * @apiSince 1
 */

public native void stop() throws java.lang.IllegalStateException;

/**
 * Pauses recording. Call this after start(). You may resume recording
 * with resume() without reconfiguration, as opposed to stop(). It does
 * nothing if the recording is already paused.
 *
 * When the recording is paused and resumed, the resulting output would
 * be as if nothing happend during paused period, immediately switching
 * to the resumed scene.
 *
 * @throws java.lang.IllegalStateException if it is called before start() or after
 * stop()
 * @apiSince 24
 */

public native void pause() throws java.lang.IllegalStateException;

/**
 * Resumes recording. Call this after start(). It does nothing if the
 * recording is not paused.
 *
 * @throws java.lang.IllegalStateException if it is called before start() or after
 * stop()
 * @see android.media.MediaRecorder#pause
 * @apiSince 24
 */

public native void resume() throws java.lang.IllegalStateException;

/**
 * Restarts the MediaRecorder to its idle state. After calling
 * this method, you will have to configure it again as if it had just been
 * constructed.
 * @apiSince 1
 */

public void reset() { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum absolute amplitude that was sampled since the last
 * call to this method. Call this only after the setAudioSource().
 *
 * @return the maximum absolute amplitude measured since the last call, or
 * 0 when called for the first time
 * @throws java.lang.IllegalStateException if it is called before
 * the audio source has been set.
 * @apiSince 1
 */

public native int getMaxAmplitude() throws java.lang.IllegalStateException;

/**
 * Register a callback to be invoked when an error occurs while
 * recording.
 *
 * @param l the callback that will be run
 * @apiSince 3
 */

public void setOnErrorListener(android.media.MediaRecorder.OnErrorListener l) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when an informational event occurs while
 * recording.
 *
 * @param listener the callback that will be run
 * @apiSince 3
 */

public void setOnInfoListener(android.media.MediaRecorder.OnInfoListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Specifies an audio device (via an {@link android.media.AudioDeviceInfo AudioDeviceInfo} object) to route
 * the input from this MediaRecorder.
 * @param deviceInfo The {@link android.media.AudioDeviceInfo AudioDeviceInfo} specifying the audio source.
 *  If deviceInfo is null, default routing is restored.
 * @return true if succesful, false if the specified {@link android.media.AudioDeviceInfo AudioDeviceInfo} is non-null and
 * does not correspond to a valid audio input device.
 * @apiSince 28
 */

public boolean setPreferredDevice(android.media.AudioDeviceInfo deviceInfo) { throw new RuntimeException("Stub!"); }

/**
 * Returns the selected input device specified by {@link #setPreferredDevice}. Note that this
 * is not guaranteed to correspond to the actual device being used for recording.
 * @apiSince 28
 */

public android.media.AudioDeviceInfo getPreferredDevice() { throw new RuntimeException("Stub!"); }

/**
 * Returns an {@link android.media.AudioDeviceInfo AudioDeviceInfo} identifying the current routing of this MediaRecorder
 * Note: The query is only valid if the MediaRecorder is currently recording.
 * If the recorder is not recording, the returned device can be null or correspond to previously
 * selected device when the recorder was last active.
 * @apiSince 28
 */

public android.media.AudioDeviceInfo getRoutedDevice() { throw new RuntimeException("Stub!"); }

/**
 * Adds an {@link android.media.AudioRouting.OnRoutingChangedListener AudioRouting.OnRoutingChangedListener} to receive notifications of routing
 * changes on this MediaRecorder.
 * @param listener The {@link android.media.AudioRouting.OnRoutingChangedListener AudioRouting.OnRoutingChangedListener} interface to receive
 * notifications of rerouting events.
 * @param handler  Specifies the {@link android.os.Handler Handler} object for the thread on which to execute
 * the callback. If <code>null</code>, the handler on the main looper will be used.
 * @apiSince 28
 */

public void addOnRoutingChangedListener(android.media.AudioRouting.OnRoutingChangedListener listener, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Removes an {@link android.media.AudioRouting.OnRoutingChangedListener AudioRouting.OnRoutingChangedListener} which has been previously added
 * to receive rerouting notifications.
 * @param listener The previously added {@link android.media.AudioRouting.OnRoutingChangedListener AudioRouting.OnRoutingChangedListener} interface
 * to remove.
 * @apiSince 28
 */

public void removeOnRoutingChangedListener(android.media.AudioRouting.OnRoutingChangedListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Return A lists of {@link android.media.MicrophoneInfo MicrophoneInfo} representing the active microphones.
 * By querying channel mapping for each active microphone, developer can know how
 * the microphone is used by each channels or a capture stream.
 *
 * @return a lists of {@link android.media.MicrophoneInfo MicrophoneInfo} representing the active microphones
 * @throws java.io.IOException if an error occurs
 * @apiSince 28
 */

public java.util.List<android.media.MicrophoneInfo> getActiveMicrophones() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Specifies the logical microphone (for processing).
 *
 * @param direction Direction constant.
 * Value is {@link android.media.MicrophoneDirection#MIC_DIRECTION_UNSPECIFIED}, {@link android.media.MicrophoneDirection#MIC_DIRECTION_TOWARDS_USER}, {@link android.media.MicrophoneDirection#MIC_DIRECTION_AWAY_FROM_USER}, or {@link android.media.MicrophoneDirection#MIC_DIRECTION_EXTERNAL}
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
 * Releases resources associated with this MediaRecorder object.
 * It is good practice to call this method when you're done
 * using the MediaRecorder. In particular, whenever an Activity
 * of an application is paused (its onPause() method is called),
 * or stopped (its onStop() method is called), this method should be
 * invoked to release the MediaRecorder object, unless the application
 * has a special need to keep the object around. In addition to
 * unnecessary resources (such as memory and instances of codecs)
 * being held, failure to call this method immediately if a
 * MediaRecorder object is no longer needed may also lead to
 * continuous battery consumption for mobile devices, and recording
 * failure for other applications if no multiple instances of the
 * same codec are supported on a device. Even if multiple instances
 * of the same codec are supported, some performance degradation
 * may be expected when unnecessary multiple instances are used
 * at the same time.
 * @apiSince 1
 */

public native void release();

/**
 *  Return Metrics data about the current Mediarecorder instance.
 *
 * @return a {@link android.os.PersistableBundle PersistableBundle} containing the set of attributes and values
 * available for the media being generated by this instance of
 * MediaRecorder.
 * The attributes are descibed in {@link android.media.MediaRecorder.MetricsConstants MetricsConstants}.
 *
 *  Additional vendor-specific fields may also be present in
 *  the return value.
 * @apiSince 26
 */

public android.os.PersistableBundle getMetrics() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void finalize() { throw new RuntimeException("Stub!"); }

/** Media server died. In this case, the application must release the
 * MediaRecorder object and instantiate a new one.
 * @see android.media.MediaRecorder.OnErrorListener
 * @apiSince 17
 */

public static final int MEDIA_ERROR_SERVER_DIED = 100; // 0x64

/** Unspecified media recorder error.
 * @see android.media.MediaRecorder.OnErrorListener
 * @apiSince 3
 */

public static final int MEDIA_RECORDER_ERROR_UNKNOWN = 1; // 0x1

/** A maximum duration had been setup and has now been reached.
 * @see android.media.MediaRecorder.OnInfoListener
 * @apiSince 3
 */

public static final int MEDIA_RECORDER_INFO_MAX_DURATION_REACHED = 800; // 0x320

/** A maximum filesize had been setup and current recorded file size
 * has reached 90% of the limit. This is sent once per file upon
 * reaching/passing the 90% limit. To continue the recording, applicaiton
 * should use {@link #setNextOutputFile} to set the next output file.
 * Otherwise, recording will stop when reaching maximum file size.
 * @see android.media.MediaRecorder.OnInfoListener
 * @apiSince 26
 */

public static final int MEDIA_RECORDER_INFO_MAX_FILESIZE_APPROACHING = 802; // 0x322

/** A maximum filesize had been setup and has now been reached.
 * Note: This event will not be sent if application already set
 * next output file through {@link #setNextOutputFile}.
 * @see android.media.MediaRecorder.OnInfoListener
 * @apiSince 3
 */

public static final int MEDIA_RECORDER_INFO_MAX_FILESIZE_REACHED = 801; // 0x321

/** A maximum filesize had been reached and MediaRecorder has switched
 * output to a new file set by application {@link #setNextOutputFile}.
 * For best practice, application should use this event to keep track
 * of whether the file previously set has been used or not.
 * @see android.media.MediaRecorder.OnInfoListener
 * @apiSince 26
 */

public static final int MEDIA_RECORDER_INFO_NEXT_OUTPUT_FILE_STARTED = 803; // 0x323

/** Unspecified media recorder info.
 * @see android.media.MediaRecorder.OnInfoListener
 * @apiSince 3
 */

public static final int MEDIA_RECORDER_INFO_UNKNOWN = 1; // 0x1
/**
 * Defines the audio encoding. These constants are used with
 * {@link android.media.MediaRecorder#setAudioEncoder(int) MediaRecorder#setAudioEncoder(int)}.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class AudioEncoder {

private AudioEncoder() { throw new RuntimeException("Stub!"); }

/**
 * AAC Low Complexity (AAC-LC) audio codec
 * @apiSince 10
 */

public static final int AAC = 3; // 0x3

/**
 * Enhanced Low Delay AAC (AAC-ELD) audio codec
 * @apiSince 16
 */

public static final int AAC_ELD = 5; // 0x5

/**
 * AMR (Narrowband) audio codec
 * @apiSince 1
 */

public static final int AMR_NB = 1; // 0x1

/**
 * AMR (Wideband) audio codec
 * @apiSince 10
 */

public static final int AMR_WB = 2; // 0x2

/** @apiSince 1 */

public static final int DEFAULT = 0; // 0x0

/**
 * High Efficiency AAC (HE-AAC) audio codec
 * @apiSince 16
 */

public static final int HE_AAC = 4; // 0x4

/**
 * Opus audio codec
 * @apiSince 29
 */

public static final int OPUS = 7; // 0x7

/**
 * Ogg Vorbis audio codec (Support is optional)
 * @apiSince 21
 */

public static final int VORBIS = 6; // 0x6
}

/**
 * Defines the audio source.
 * An audio source defines both a default physical source of audio signal, and a recording
 * configuration. These constants are for instance used
 * in {@link android.media.MediaRecorder#setAudioSource(int) MediaRecorder#setAudioSource(int)} or
 * {@link android.media.AudioRecord.Builder#setAudioSource(int) AudioRecord.Builder#setAudioSource(int)}.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class AudioSource {

private AudioSource() { throw new RuntimeException("Stub!"); }

/** Microphone audio source tuned for video recording, with the same orientation
 *  as the camera if available.         * @apiSince 7
 */

public static final int CAMCORDER = 5; // 0x5

/**
 * Default audio source *
 * @apiSince 1
 */

public static final int DEFAULT = 0; // 0x0

/**
 * Microphone audio source
 * @apiSince 1
 */

public static final int MIC = 1; // 0x1

/**
 * Audio source for a submix of audio streams to be presented remotely.
 * <p>
 * An application can use this audio source to capture a mix of audio streams
 * that should be transmitted to a remote receiver such as a Wifi display.
 * While recording is active, these audio streams are redirected to the remote
 * submix instead of being played on the device speaker or headset.
 * </p><p>
 * Certain streams are excluded from the remote submix, including
 * {@link android.media.AudioManager#STREAM_RING AudioManager#STREAM_RING}, {@link android.media.AudioManager#STREAM_ALARM AudioManager#STREAM_ALARM},
 * and {@link android.media.AudioManager#STREAM_NOTIFICATION AudioManager#STREAM_NOTIFICATION}.  These streams will continue
 * to be presented locally as usual.
 * </p><p>
 * Capturing the remote submix audio requires the
 * {@link android.Manifest.permission#CAPTURE_AUDIO_OUTPUT} permission.
 * This permission is reserved for use by system components and is not available to
 * third-party applications.
 * </p>
 
 * <br>
 * Requires {@link android.Manifest.permission#CAPTURE_AUDIO_OUTPUT}
 * @apiSince 19
 */

public static final int REMOTE_SUBMIX = 8; // 0x8

/** Microphone audio source tuned for unprocessed (raw) sound if available, behaves like
 *  {@link #DEFAULT} otherwise.         * @apiSince 24
 */

public static final int UNPROCESSED = 9; // 0x9

/** Voice call uplink + downlink audio source
 * <p>
 * Capturing from <code>VOICE_CALL</code> source requires the
 * {@link android.Manifest.permission#CAPTURE_AUDIO_OUTPUT} permission.
 * This permission is reserved for use by system components and is not available to
 * third-party applications.
 * </p>
 * @apiSince 4
 */

public static final int VOICE_CALL = 4; // 0x4

/** Microphone audio source tuned for voice communications such as VoIP. It
 *  will for instance take advantage of echo cancellation or automatic gain control
 *  if available.
 * @apiSince 11
 */

public static final int VOICE_COMMUNICATION = 7; // 0x7

/** Voice call downlink (Rx) audio source.
 * <p>
 * Capturing from <code>VOICE_DOWNLINK</code> source requires the
 * {@link android.Manifest.permission#CAPTURE_AUDIO_OUTPUT} permission.
 * This permission is reserved for use by system components and is not available to
 * third-party applications.
 * </p>
 * @apiSince 4
 */

public static final int VOICE_DOWNLINK = 3; // 0x3

/**
 * Source for capturing audio meant to be processed in real time and played back for live
 * performance (e.g karaoke).
 * <p>
 * The capture path will minimize latency and coupling with
 * playback path.
 * </p>
 * @apiSince 29
 */

public static final int VOICE_PERFORMANCE = 10; // 0xa

/**
 * Microphone audio source tuned for voice recognition.
 * @apiSince 7
 */

public static final int VOICE_RECOGNITION = 6; // 0x6

/** Voice call uplink (Tx) audio source.
 * <p>
 * Capturing from <code>VOICE_UPLINK</code> source requires the
 * {@link android.Manifest.permission#CAPTURE_AUDIO_OUTPUT} permission.
 * This permission is reserved for use by system components and is not available to
 * third-party applications.
 * </p>
 * @apiSince 4
 */

public static final int VOICE_UPLINK = 2; // 0x2
}

/** @apiSince 26 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class MetricsConstants {

private MetricsConstants() { throw new RuntimeException("Stub!"); }

/**
 * Key to extract the audio bitrate
 * from the {@link android.media.MediaRecorder#getMetrics MediaRecorder#getMetrics} return.
 * The value is an integer.
 * @apiSince 26
 */

public static final java.lang.String AUDIO_BITRATE = "android.media.mediarecorder.audio-bitrate";

/**
 * Key to extract the number of audio channels
 * from the {@link android.media.MediaRecorder#getMetrics MediaRecorder#getMetrics} return.
 * The value is an integer.
 * @apiSince 26
 */

public static final java.lang.String AUDIO_CHANNELS = "android.media.mediarecorder.audio-channels";

/**
 * Key to extract the audio samplerate
 * from the {@link android.media.MediaRecorder#getMetrics MediaRecorder#getMetrics} return.
 * The value is an integer.
 * @apiSince 26
 */

public static final java.lang.String AUDIO_SAMPLERATE = "android.media.mediarecorder.audio-samplerate";

/**
 * Key to extract the audio timescale
 * from the {@link android.media.MediaRecorder#getMetrics MediaRecorder#getMetrics} return.
 * The value is an integer.
 * @apiSince 26
 */

public static final java.lang.String AUDIO_TIMESCALE = "android.media.mediarecorder.audio-timescale";

/**
 * Key to extract the video capture frame rate
 * from the {@link android.media.MediaRecorder#getMetrics MediaRecorder#getMetrics} return.
 * The value is a double.
 * @apiSince 26
 */

public static final java.lang.String CAPTURE_FPS = "android.media.mediarecorder.capture-fps";

/**
 * Key to extract the video capture framerate enable value
 * from the {@link android.media.MediaRecorder#getMetrics MediaRecorder#getMetrics} return.
 * The value is an integer.
 * @apiSince 26
 */

public static final java.lang.String CAPTURE_FPS_ENABLE = "android.media.mediarecorder.capture-fpsenable";

/**
 * Key to extract the intended playback frame rate
 * from the {@link android.media.MediaRecorder#getMetrics MediaRecorder#getMetrics} return.
 * The value is an integer.
 * @apiSince 26
 */

public static final java.lang.String FRAMERATE = "android.media.mediarecorder.frame-rate";

/**
 * Key to extract the height (in pixels) of the captured video
 * from the {@link android.media.MediaRecorder#getMetrics MediaRecorder#getMetrics} return.
 * The value is an integer.
 * @apiSince 26
 */

public static final java.lang.String HEIGHT = "android.media.mediarecorder.height";

/**
 * Key to extract the recorded movies time units
 * from the {@link android.media.MediaRecorder#getMetrics MediaRecorder#getMetrics} return.
 * The value is an integer.
 * A value of 1000 indicates that the movie's timing is in milliseconds.
 * @apiSince 26
 */

public static final java.lang.String MOVIE_TIMESCALE = "android.media.mediarecorder.movie-timescale";

/**
 * Key to extract the rotation (in degrees) to properly orient the video
 * from the {@link android.media.MediaRecorder#getMetrics MediaRecorder#getMetrics} return.
 * The value is an integer.
 * @apiSince 26
 */

public static final java.lang.String ROTATION = "android.media.mediarecorder.rotation";

/**
 * Key to extract the video bitrate from being used
 * from the {@link android.media.MediaRecorder#getMetrics MediaRecorder#getMetrics} return.
 * The value is an integer.
 * @apiSince 26
 */

public static final java.lang.String VIDEO_BITRATE = "android.media.mediarecorder.video-bitrate";

/**
 * Key to extract the value for how often video iframes are generated
 * from the {@link android.media.MediaRecorder#getMetrics MediaRecorder#getMetrics} return.
 * The value is an integer.
 * @apiSince 26
 */

public static final java.lang.String VIDEO_IFRAME_INTERVAL = "android.media.mediarecorder.video-iframe-interval";

/**
 * Key to extract the video encoding level
 * from the {@link android.media.MediaRecorder#getMetrics MediaRecorder#getMetrics} return.
 * The value is an integer.
 * @apiSince 26
 */

public static final java.lang.String VIDEO_LEVEL = "android.media.mediarecorder.video-encoder-level";

/**
 * Key to extract the video encoding profile
 * from the {@link android.media.MediaRecorder#getMetrics MediaRecorder#getMetrics} return.
 * The value is an integer.
 * @apiSince 26
 */

public static final java.lang.String VIDEO_PROFILE = "android.media.mediarecorder.video-encoder-profile";

/**
 * Key to extract the recorded video time units
 * from the {@link android.media.MediaRecorder#getMetrics MediaRecorder#getMetrics} return.
 * The value is an integer.
 * A value of 1000 indicates that the video's timing is in milliseconds.
 * @apiSince 26
 */

public static final java.lang.String VIDEO_TIMESCALE = "android.media.mediarecorder.video-timescale";

/**
 * Key to extract the width (in pixels) of the captured video
 * from the {@link android.media.MediaRecorder#getMetrics MediaRecorder#getMetrics} return.
 * The value is an integer.
 * @apiSince 26
 */

public static final java.lang.String WIDTH = "android.media.mediarecorder.width";
}

/**
 * Interface definition for a callback to be invoked when an error
 * occurs while recording.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnErrorListener {

/**
 * Called when an error occurs while recording.
 *
 * @param mr the MediaRecorder that encountered the error
 * @param what    the type of error that has occurred:
 * <ul>
 * <li>{@link #MEDIA_RECORDER_ERROR_UNKNOWN}
 * <li>{@link #MEDIA_ERROR_SERVER_DIED}
 * </ul>
 * @param extra   an extra code, specific to the error type
 * @apiSince 3
 */

public void onError(android.media.MediaRecorder mr, int what, int extra);
}

/**
 * Interface definition of a callback to be invoked to communicate some
 * info and/or warning about the recording.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnInfoListener {

/**
 * Called to indicate an info or a warning during recording.
 *
 * @param mr   the MediaRecorder the info pertains to
 * @param what the type of info or warning that has occurred
 * <ul>
 * <li>{@link #MEDIA_RECORDER_INFO_UNKNOWN}
 * <li>{@link #MEDIA_RECORDER_INFO_MAX_DURATION_REACHED}
 * <li>{@link #MEDIA_RECORDER_INFO_MAX_FILESIZE_REACHED}
 * </ul>
 * @param extra   an extra code, specific to the info type
 * @apiSince 3
 */

public void onInfo(android.media.MediaRecorder mr, int what, int extra);
}

/**
 * Defines the output format. These constants are used with
 * {@link android.media.MediaRecorder#setOutputFormat(int) MediaRecorder#setOutputFormat(int)}.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class OutputFormat {

private OutputFormat() { throw new RuntimeException("Stub!"); }

/**
 * AAC ADTS file format
 * @apiSince 16
 */

public static final int AAC_ADTS = 6; // 0x6

/**
 * AMR NB file format
 * @apiSince 10
 */

public static final int AMR_NB = 3; // 0x3

/**
 * AMR WB file format
 * @apiSince 10
 */

public static final int AMR_WB = 4; // 0x4

/** @apiSince 1 */

public static final int DEFAULT = 0; // 0x0

/**
 * H.264/AAC data encapsulated in MPEG2/TS
 * @apiSince 26
 */

public static final int MPEG_2_TS = 8; // 0x8

/**
 * MPEG4 media file format
 * @apiSince 1
 */

public static final int MPEG_4 = 2; // 0x2

/**
 * Opus data in a Ogg container
 * @apiSince 29
 */

public static final int OGG = 11; // 0xb

/**
 * AMR NB file format
 * @deprecated  Deprecated in favor of MediaRecorder.OutputFormat.AMR_NB
 * @apiSince 3
 * @deprecatedSince 16
 */

@Deprecated public static final int RAW_AMR = 3; // 0x3

/**
 * 3GPP media file format
 * @apiSince 1
 */

public static final int THREE_GPP = 1; // 0x1

/**
 * VP8/VORBIS data in a WEBM container
 * @apiSince 21
 */

public static final int WEBM = 9; // 0x9
}

/**
 * Defines the video encoding. These constants are used with
 * {@link android.media.MediaRecorder#setVideoEncoder(int) MediaRecorder#setVideoEncoder(int)}.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class VideoEncoder {

private VideoEncoder() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

public static final int DEFAULT = 0; // 0x0

/** @apiSince 3 */

public static final int H263 = 1; // 0x1

/** @apiSince 3 */

public static final int H264 = 2; // 0x2

/** @apiSince 24 */

public static final int HEVC = 5; // 0x5

/** @apiSince 3 */

public static final int MPEG_4_SP = 3; // 0x3

/** @apiSince 21 */

public static final int VP8 = 4; // 0x4
}

/**
 * Defines the video source. These constants are used with
 * {@link android.media.MediaRecorder#setVideoSource(int) MediaRecorder#setVideoSource(int)}.
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class VideoSource {

private VideoSource() { throw new RuntimeException("Stub!"); }

/** Camera video source
 * <p>
 * Using the {@link android.hardware.Camera} API as video source.
 * </p>
 * @apiSince 3
 */

public static final int CAMERA = 1; // 0x1

/** @apiSince 3 */

public static final int DEFAULT = 0; // 0x0

/** Surface video source
 * <p>
 * Using a Surface as video source.
 * </p><p>
 * This flag must be used when recording from an
 * {@link android.hardware.camera2} API source.
 * </p><p>
 * When using this video source type, use {@link android.media.MediaRecorder#getSurface() MediaRecorder#getSurface()}
 * to retrieve the surface created by MediaRecorder.
 * @apiSince 21
 */

public static final int SURFACE = 2; // 0x2
}

}

