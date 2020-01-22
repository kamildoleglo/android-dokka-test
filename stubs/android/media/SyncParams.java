/*
 * Copyright 2015 The Android Open Source Project
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
 * Structure for common A/V sync params.
 *
 * Used by {@link android.media.MediaSync MediaSync} {link MediaSync#getSyncParams()} and
 * {link MediaSync#setSyncParams(SyncParams)}
 * to control A/V sync behavior.
 * <p> <strong>audio adjust mode:</strong>
 * select handling of audio track when changing playback speed due to sync.
 * <ul>
 * <li> {@link android.media.SyncParams#AUDIO_ADJUST_MODE_DEFAULT SyncParams#AUDIO_ADJUST_MODE_DEFAULT}:
 *   System will determine best handling. </li>
 * <li> {@link android.media.SyncParams#AUDIO_ADJUST_MODE_STRETCH SyncParams#AUDIO_ADJUST_MODE_STRETCH}:
 *   Change the speed of audio playback without altering its pitch.</li>
 * <li> {@link android.media.SyncParams#AUDIO_ADJUST_MODE_RESAMPLE SyncParams#AUDIO_ADJUST_MODE_RESAMPLE}:
 *   Change the speed of audio playback by resampling the audio.</li>
 * </ul>
 * <p> <strong>sync source:</strong> select
 * clock source for sync.
 * <ul>
 * <li> {@link android.media.SyncParams#SYNC_SOURCE_DEFAULT SyncParams#SYNC_SOURCE_DEFAULT}:
 *   System will determine best selection.</li>
 * <li> {@link android.media.SyncParams#SYNC_SOURCE_SYSTEM_CLOCK SyncParams#SYNC_SOURCE_SYSTEM_CLOCK}:
 *   Use system clock for sync source.</li>
 * <li> {@link android.media.SyncParams#SYNC_SOURCE_AUDIO SyncParams#SYNC_SOURCE_AUDIO}:
 *   Use audio track for sync source.</li>
 * <li> {@link android.media.SyncParams#SYNC_SOURCE_VSYNC SyncParams#SYNC_SOURCE_VSYNC}:
 *   Syncronize media to vsync.</li>
 * </ul>
 * <p> <strong>tolerance:</strong> specifies the amount of allowed playback rate
 * change to keep media in sync with the sync source. The handling of this depends
 * on the sync source, but must not be negative, and must be less than one.
 * <p> <strong>frameRate:</strong> initial hint for video frame rate. Used when
 * sync source is vsync. Negative values can be used to clear a previous hint.
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SyncParams {

public SyncParams() { throw new RuntimeException("Stub!"); }

/**
 * Allows defaults to be returned for properties not set.
 * Otherwise a {@link java.lang.IllegalArgumentException} exception
 * is raised when getting those properties
 * which have defaults but have never been set.
 * @return this <code>SyncParams</code> instance.
 * @apiSince 23
 */

public android.media.SyncParams allowDefaults() { throw new RuntimeException("Stub!"); }

/**
 * Sets the audio adjust mode.
 * @param audioAdjustMode
 * Value is {@link android.media.SyncParams#AUDIO_ADJUST_MODE_DEFAULT}, {@link android.media.SyncParams#AUDIO_ADJUST_MODE_STRETCH}, or {@link android.media.SyncParams#AUDIO_ADJUST_MODE_RESAMPLE}
 * @return this <code>SyncParams</code> instance.
 * @apiSince 23
 */

public android.media.SyncParams setAudioAdjustMode(int audioAdjustMode) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the audio adjust mode.
 * @return audio adjust mode
 * Value is {@link android.media.SyncParams#AUDIO_ADJUST_MODE_DEFAULT}, {@link android.media.SyncParams#AUDIO_ADJUST_MODE_STRETCH}, or {@link android.media.SyncParams#AUDIO_ADJUST_MODE_RESAMPLE}
 * @throws java.lang.IllegalStateException if the audio adjust mode is not set.
 * @apiSince 23
 */

public int getAudioAdjustMode() { throw new RuntimeException("Stub!"); }

/**
 * Sets the sync source.
 * @param syncSource
 * Value is {@link android.media.SyncParams#SYNC_SOURCE_DEFAULT}, {@link android.media.SyncParams#SYNC_SOURCE_SYSTEM_CLOCK}, {@link android.media.SyncParams#SYNC_SOURCE_AUDIO}, or {@link android.media.SyncParams#SYNC_SOURCE_VSYNC}
 * @return this <code>SyncParams</code> instance.
 * @apiSince 23
 */

public android.media.SyncParams setSyncSource(int syncSource) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the sync source.
 * @return sync source
 * Value is {@link android.media.SyncParams#SYNC_SOURCE_DEFAULT}, {@link android.media.SyncParams#SYNC_SOURCE_SYSTEM_CLOCK}, {@link android.media.SyncParams#SYNC_SOURCE_AUDIO}, or {@link android.media.SyncParams#SYNC_SOURCE_VSYNC}
 * @throws java.lang.IllegalStateException if the sync source is not set.
 * @apiSince 23
 */

public int getSyncSource() { throw new RuntimeException("Stub!"); }

/**
 * Sets the tolerance. The default tolerance is platform specific, but is never more than 1/24.
 * @param tolerance A non-negative number representing
 *     the maximum deviation of the playback rate from the playback rate
 *     set. ({@code abs(actual_rate - set_rate) / set_rate})
 * @return this <code>SyncParams</code> instance.
 * @throws java.lang.IllegalArgumentException if the tolerance is negative, or not less than one.
 * @apiSince 23
 */

public android.media.SyncParams setTolerance(float tolerance) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the tolerance factor.
 * @return tolerance factor. A non-negative number representing
 *     the maximum deviation of the playback rate from the playback rate
 *     set. ({@code abs(actual_rate - set_rate) / set_rate})
 * @throws java.lang.IllegalStateException if tolerance is not set.
 * @apiSince 23
 */

public float getTolerance() { throw new RuntimeException("Stub!"); }

/**
 * Sets the video frame rate hint to be used. By default the frame rate is unspecified.
 * @param frameRate A non-negative number used as an initial hint on
 *     the video frame rate to be used when using vsync as the sync source. A negative
 *     number is used to clear a previous hint.
 * @return this <code>SyncParams</code> instance.
 * @apiSince 23
 */

public android.media.SyncParams setFrameRate(float frameRate) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the video frame rate hint.
 * @return frame rate factor. A non-negative number representing
 *     the maximum deviation of the playback rate from the playback rate
 *     set. ({@code abs(actual_rate - set_rate) / set_rate}), or a negative
 *     number representing the desire to clear a previous hint using these params.
 * @throws java.lang.IllegalStateException if frame rate is not set.
 * @apiSince 23
 */

public float getFrameRate() { throw new RuntimeException("Stub!"); }

/**
 * System will determine best handling of audio for playback rate
 * adjustments.
 * <p>
 * Used by default. This will make audio play faster or slower as required
 * by the sync source without changing its pitch; however, system may fall
 * back to some other method (e.g. change the pitch, or mute the audio) if
 * time stretching is no longer supported for the playback rate.
 * @apiSince 23
 */

public static final int AUDIO_ADJUST_MODE_DEFAULT = 0; // 0x0

/**
 * Resample audio when playback rate must be adjusted.
 * <p>
 * This will make audio play faster or slower as required by the sync source
 * by changing its pitch (making it lower to play slower, and higher to play
 * faster.)
 * @apiSince 23
 */

public static final int AUDIO_ADJUST_MODE_RESAMPLE = 2; // 0x2

/**
 * Time stretch audio when playback rate must be adjusted.
 * <p>
 * This will make audio play faster or slower as required by the sync source
 * without changing its pitch, as long as it is supported for the playback
 * rate.
 * @apiSince 23
 */

public static final int AUDIO_ADJUST_MODE_STRETCH = 1; // 0x1

/**
 * Use audio track for sync source. This requires audio data and an audio track.
 *
 * @see android.media.AudioTrack#getTimestamp(android.media.AudioTimestamp)
 * @apiSince 23
 */

public static final int SYNC_SOURCE_AUDIO = 2; // 0x2

/**
 * Use the default sync source (default). If media has video, the sync renders to a
 * surface that directly renders to a display, and tolerance is non zero (e.g. not
 * less than 0.001) vsync source is used for clock source.  Otherwise, if media has
 * audio, audio track is used. Finally, if media has no audio, system clock is used.
 * @apiSince 23
 */

public static final int SYNC_SOURCE_DEFAULT = 0; // 0x0

/**
 * Use system monotonic clock for sync source.
 *
 * @see java.lang.System#nanoTime
 * @apiSince 23
 */

public static final int SYNC_SOURCE_SYSTEM_CLOCK = 1; // 0x1

/**
 * Use vsync as the sync source. This requires video data and an output surface that
 * directly renders to the display, e.g. {@link android.view.SurfaceView}
 * <p>
 * This mode allows smoother playback experience by adjusting the playback speed
 * to match the vsync rate, e.g. playing 30fps content on a 59.94Hz display.
 * When using this mode, the tolerance should be set to greater than 0 (e.g. at least
 * 1/1000), so that the playback speed can actually be adjusted.
 * <p>
 * This mode can also be used to play 25fps content on a 60Hz display using
 * a 2:3 pulldown (basically playing the content at 24fps), which results on
 * better playback experience on most devices. In this case the tolerance should be
 * at least (1/24).
 *
 * @see android.view.Choreographer.FrameCallback#doFrame
 * @see android.view.Display#getAppVsyncOffsetNanos
 * @apiSince 23
 */

public static final int SYNC_SOURCE_VSYNC = 3; // 0x3
}

