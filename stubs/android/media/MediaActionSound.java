/*
 * Copyright (C) 2012 The Android Open Source Project
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


/**
 * <p>A class for producing sounds that match those produced by various actions
 * taken by the media and camera APIs.  </p>
 *
 * <p>This class is recommended for use with the {@link android.hardware.camera2} API, since the
 * camera2 API does not play any sounds on its own for any capture or video recording actions.</p>
 *
 * <p>With the older {@link android.hardware.Camera} API, use this class to play an appropriate
 * camera operation sound when implementing a custom still or video recording mechanism (through the
 * Camera preview callbacks with
 * {@link android.hardware.Camera#setPreviewCallback Camera.setPreviewCallback}, or through GPU
 * processing with {@link android.hardware.Camera#setPreviewTexture Camera.setPreviewTexture}, for
 * example), or when implementing some other camera-like function in your application.</p>
 *
 * <p>There is no need to play sounds when using
 * {@link android.hardware.Camera#takePicture Camera.takePicture} or
 * {@link android.media.MediaRecorder} for still images or video, respectively,
 * as the Android framework will play the appropriate sounds when needed for
 * these calls.</p>
 *
 * @apiSince 16
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MediaActionSound {

/**
 * Construct a new MediaActionSound instance. Only a single instance is
 * needed for playing any platform media action sound; you do not need a
 * separate instance for each sound type.
 * @apiSince 16
 */

public MediaActionSound() { throw new RuntimeException("Stub!"); }

/**
 * Preload a predefined platform sound to minimize latency when the sound is
 * played later by {@link #play}.
 * @param soundName The type of sound to preload, selected from
 *         SHUTTER_CLICK, FOCUS_COMPLETE, START_VIDEO_RECORDING, or
 *         STOP_VIDEO_RECORDING.
 * @see #play
 * @see #SHUTTER_CLICK
 * @see #FOCUS_COMPLETE
 * @see #START_VIDEO_RECORDING
 * @see #STOP_VIDEO_RECORDING
 * @apiSince 16
 */

public void load(int soundName) { throw new RuntimeException("Stub!"); }

/**
 * <p>Play one of the predefined platform sounds for media actions.</p>
 *
 * <p>Use this method to play a platform-specific sound for various media
 * actions. The sound playback is done asynchronously, with the same
 * behavior and content as the sounds played by
 * {@link android.hardware.Camera#takePicture Camera.takePicture},
 * {@link android.media.MediaRecorder#start MediaRecorder.start}, and
 * {@link android.media.MediaRecorder#stop MediaRecorder.stop}.</p>
 *
 * <p>With the {@link android.hardware.camera2 camera2} API, this method can be used to play
 * standard camera operation sounds with the appropriate system behavior for such sounds.</p>
 
 * <p>With the older {@link android.hardware.Camera} API, using this method makes it easy to
 * match the default device sounds when recording or capturing data through the preview
 * callbacks, or when implementing custom camera-like features in your application.</p>
 *
 * <p>If the sound has not been loaded by {@link #load} before calling play,
 * play will load the sound at the cost of some additional latency before
 * sound playback begins. </p>
 *
 * @param soundName The type of sound to play, selected from
 *         SHUTTER_CLICK, FOCUS_COMPLETE, START_VIDEO_RECORDING, or
 *         STOP_VIDEO_RECORDING.
 * @see android.hardware.Camera#takePicture
 * @see android.media.MediaRecorder
 * @see #SHUTTER_CLICK
 * @see #FOCUS_COMPLETE
 * @see #START_VIDEO_RECORDING
 * @see #STOP_VIDEO_RECORDING
 * @apiSince 16
 */

public void play(int soundName) { throw new RuntimeException("Stub!"); }

/**
 * Free up all audio resources used by this MediaActionSound instance. Do
 * not call any other methods on a MediaActionSound instance after calling
 * release().
 * @apiSince 16
 */

public void release() { throw new RuntimeException("Stub!"); }

/**
 * A sound to indicate that focusing has completed. Because deciding
 * when this occurs is application-dependent, this sound is not used by
 * any methods in the media or camera APIs.
 * @see #play
 * @apiSince 16
 */

public static final int FOCUS_COMPLETE = 1; // 0x1

/**
 * The sound used by
 * {@link android.hardware.Camera#takePicture Camera.takePicture} to
 * indicate still image capture.
 * @see #play
 * @apiSince 16
 */

public static final int SHUTTER_CLICK = 0; // 0x0

/**
 * The sound used by
 * {@link android.media.MediaRecorder#start MediaRecorder.start()} to
 * indicate the start of video recording.
 * @see #play
 * @apiSince 16
 */

public static final int START_VIDEO_RECORDING = 2; // 0x2

/**
 * The sound used by
 * {@link android.media.MediaRecorder#stop MediaRecorder.stop()} to
 * indicate the end of video recording.
 * @see #play
 * @apiSince 16
 */

public static final int STOP_VIDEO_RECORDING = 3; // 0x3
}

