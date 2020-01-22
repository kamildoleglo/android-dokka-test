/*
 * Copyright (C) 2010 The Android Open Source Project
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

import android.hardware.Camera;

/**
 * Retrieves the
 * predefined camcorder profile settings for camcorder applications.
 * These settings are read-only.
 *
 * <p>The compressed output from a recording session with a given
 * CamcorderProfile contains two tracks: one for audio and one for video.
 *
 * <p>Each profile specifies the following set of parameters:
 * <ul>
 * <li> The file output format
 * <li> Video codec format
 * <li> Video bit rate in bits per second
 * <li> Video frame rate in frames per second
 * <li> Video frame width and height,
 * <li> Audio codec format
 * <li> Audio bit rate in bits per second,
 * <li> Audio sample rate
 * <li> Number of audio channels for recording.
 * </ul>
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CamcorderProfile {

private CamcorderProfile() { throw new RuntimeException("Stub!"); }

/**
 * Returns the camcorder profile for the first back-facing camera on the
 * device at the given quality level. If the device has no back-facing
 * camera, this returns null.
 * @param quality the target quality level for the camcorder profile
 * @see #get(int, int)
 * @apiSince 8
 */

public static android.media.CamcorderProfile get(int quality) { throw new RuntimeException("Stub!"); }

/**
 * Returns the camcorder profile for the given camera at the given
 * quality level.
 *
 * Quality levels QUALITY_LOW, QUALITY_HIGH are guaranteed to be supported, while
 * other levels may or may not be supported. The supported levels can be checked using
 * {@link #hasProfile(int,int)}.
 * QUALITY_LOW refers to the lowest quality available, while QUALITY_HIGH refers to
 * the highest quality available.
 * QUALITY_LOW/QUALITY_HIGH have to match one of qcif, cif, 480p, 720p, 1080p or 2160p.
 * E.g. if the device supports 480p, 720p, 1080p and 2160p, then low is 480p and high is
 * 2160p.
 *
 * The same is true for time lapse quality levels, i.e. QUALITY_TIME_LAPSE_LOW,
 * QUALITY_TIME_LAPSE_HIGH are guaranteed to be supported and have to match one of
 * qcif, cif, 480p, 720p, 1080p, or 2160p.
 *
 * For high speed quality levels, they may or may not be supported. If a subset of the levels
 * are supported, QUALITY_HIGH_SPEED_LOW and QUALITY_HIGH_SPEED_HIGH are guaranteed to be
 * supported and have to match one of 480p, 720p, or 1080p.
 *
 * A camcorder recording session with higher quality level usually has higher output
 * bit rate, better video and/or audio recording quality, larger video frame
 * resolution and higher audio sampling rate, etc, than those with lower quality
 * level.
 *
 * @param cameraId the id for the camera
 * @param quality the target quality level for the camcorder profile.
 * @see #QUALITY_LOW
 * @see #QUALITY_HIGH
 * @see #QUALITY_QCIF
 * @see #QUALITY_CIF
 * @see #QUALITY_480P
 * @see #QUALITY_720P
 * @see #QUALITY_1080P
 * @see #QUALITY_2160P
 * @see #QUALITY_TIME_LAPSE_LOW
 * @see #QUALITY_TIME_LAPSE_HIGH
 * @see #QUALITY_TIME_LAPSE_QCIF
 * @see #QUALITY_TIME_LAPSE_CIF
 * @see #QUALITY_TIME_LAPSE_480P
 * @see #QUALITY_TIME_LAPSE_720P
 * @see #QUALITY_TIME_LAPSE_1080P
 * @see #QUALITY_TIME_LAPSE_2160P
 * @see #QUALITY_HIGH_SPEED_LOW
 * @see #QUALITY_HIGH_SPEED_HIGH
 * @see #QUALITY_HIGH_SPEED_480P
 * @see #QUALITY_HIGH_SPEED_720P
 * @see #QUALITY_HIGH_SPEED_1080P
 * @see #QUALITY_HIGH_SPEED_2160P
 * @apiSince 9
 */

public static android.media.CamcorderProfile get(int cameraId, int quality) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if camcorder profile exists for the first back-facing
 * camera at the given quality level.
 *
 * <p>
 * When using the Camera 2 API in {@code LEGACY} mode (i.e. when
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} is set
 * to
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY}),
 * {@link #hasProfile} may return {@code true} for unsupported resolutions.  To ensure a
 * a given resolution is supported in LEGACY mode, the configuration given in
 * {@link android.hardware.camera2.CameraCharacteristics#SCALER_STREAM_CONFIGURATION_MAP}
 * must contain the the resolution in the supported output sizes.  The recommended way to check
 * this is with
 * {@link android.hardware.camera2.params.StreamConfigurationMap#getOutputSizes(Class)} with the
 * class of the desired recording endpoint, and check that the desired resolution is contained
 * in the list returned.
 * </p>
 * @see android.hardware.camera2.CameraManager
 * @see android.hardware.camera2.CameraCharacteristics
 *
 * @param quality the target quality level for the camcorder profile
 * @apiSince 11
 */

public static boolean hasProfile(int quality) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if camcorder profile exists for the given camera at
 * the given quality level.
 *
 * <p>
 * When using the Camera 2 API in LEGACY mode (i.e. when
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} is set
 * to
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY}),
 * {@link #hasProfile} may return {@code true} for unsupported resolutions.  To ensure a
 * a given resolution is supported in LEGACY mode, the configuration given in
 * {@link android.hardware.camera2.CameraCharacteristics#SCALER_STREAM_CONFIGURATION_MAP}
 * must contain the the resolution in the supported output sizes.  The recommended way to check
 * this is with
 * {@link android.hardware.camera2.params.StreamConfigurationMap#getOutputSizes(Class)} with the
 * class of the desired recording endpoint, and check that the desired resolution is contained
 * in the list returned.
 * </p>
 * @see android.hardware.camera2.CameraManager
 * @see android.hardware.camera2.CameraCharacteristics
 *
 * @param cameraId the id for the camera
 * @param quality the target quality level for the camcorder profile
 * @apiSince 11
 */

public static boolean hasProfile(int cameraId, int quality) { throw new RuntimeException("Stub!"); }

/**
 * Quality level corresponding to the 1080p (1920 x 1080) resolution.
 * Note that the vertical resolution for 1080p can also be 1088,
 * instead of 1080 (used by some vendors to avoid cropping during
 * video playback).
 * @apiSince 11
 */

public static final int QUALITY_1080P = 6; // 0x6

/**
 * Quality level corresponding to the 2160p (3840x2160) resolution.
 * @apiSince 21
 */

public static final int QUALITY_2160P = 8; // 0x8

/**
 * Quality level corresponding to the 480p (720 x 480) resolution.
 * Note that the horizontal resolution for 480p can also be other
 * values, such as 640 or 704, instead of 720.
 * @apiSince 11
 */

public static final int QUALITY_480P = 4; // 0x4

/**
 * Quality level corresponding to the 720p (1280 x 720) resolution.
 * @apiSince 11
 */

public static final int QUALITY_720P = 5; // 0x5

/**
 * Quality level corresponding to the cif (352 x 288) resolution.
 * @apiSince 11
 */

public static final int QUALITY_CIF = 3; // 0x3

/**
 * Quality level corresponding to the highest available resolution.
 * @apiSince 8
 */

public static final int QUALITY_HIGH = 1; // 0x1

/**
 * High speed ( >= 100fps) quality level corresponding to the 1080p (1920 x 1080 or 1920x1088)
 * resolution.
 * @apiSince 21
 */

public static final int QUALITY_HIGH_SPEED_1080P = 2004; // 0x7d4

/**
 * High speed ( >= 100fps) quality level corresponding to the 2160p (3840 x 2160)
 * resolution.
 * @apiSince 21
 */

public static final int QUALITY_HIGH_SPEED_2160P = 2005; // 0x7d5

/**
 * High speed ( >= 100fps) quality level corresponding to the 480p (720 x 480) resolution.
 *
 * Note that the horizontal resolution for 480p can also be other
 * values, such as 640 or 704, instead of 720.
 * @apiSince 21
 */

public static final int QUALITY_HIGH_SPEED_480P = 2002; // 0x7d2

/**
 * High speed ( >= 100fps) quality level corresponding to the 720p (1280 x 720) resolution.
 * @apiSince 21
 */

public static final int QUALITY_HIGH_SPEED_720P = 2003; // 0x7d3

/**
 * High speed ( >= 100fps) quality level corresponding to the highest available resolution.
 * @apiSince 21
 */

public static final int QUALITY_HIGH_SPEED_HIGH = 2001; // 0x7d1

/**
 * High speed ( >= 100fps) quality level corresponding to the lowest available resolution.
 * <p>
 * For all the high speed profiles defined below ((from {@link #QUALITY_HIGH_SPEED_LOW} to
 * {@link #QUALITY_HIGH_SPEED_2160P}), they are similar as normal recording profiles, with just
 * higher output frame rate and bit rate. Therefore, setting these profiles with
 * {@link android.media.MediaRecorder#setProfile MediaRecorder#setProfile} without specifying any other encoding parameters will
 * produce high speed videos rather than slow motion videos that have different capture and
 * output (playback) frame rates. To record slow motion videos, the application must set video
 * output (playback) frame rate and bit rate appropriately via
 * {@link android.media.MediaRecorder#setVideoFrameRate MediaRecorder#setVideoFrameRate} and {@link android.media.MediaRecorder#setVideoEncodingBitRate MediaRecorder#setVideoEncodingBitRate}
 * based on the slow motion factor. If the application intends to do the video recording with
 * {@link android.media.MediaCodec MediaCodec} encoder, it must set each individual field of {@link android.media.MediaFormat MediaFormat}
 * similarly according to this CamcorderProfile.
 * </p>
 *
 * @see #videoBitRate
 * @see #videoFrameRate
 * @see android.media.MediaRecorder
 * @see android.media.MediaCodec
 * @see android.media.MediaFormat
 * @apiSince 21
 */

public static final int QUALITY_HIGH_SPEED_LOW = 2000; // 0x7d0

/**
 * Quality level corresponding to the lowest available resolution.
 * @apiSince 8
 */

public static final int QUALITY_LOW = 0; // 0x0

/**
 * Quality level corresponding to the qcif (176 x 144) resolution.
 * @apiSince 11
 */

public static final int QUALITY_QCIF = 2; // 0x2

/**
 * Quality level corresponding to the QVGA (320x240) resolution.
 * @apiSince 15
 */

public static final int QUALITY_QVGA = 7; // 0x7

/**
 * Time lapse quality level corresponding to the 1080p (1920 x 1088) resolution.
 * @apiSince 11
 */

public static final int QUALITY_TIME_LAPSE_1080P = 1006; // 0x3ee

/**
 * Time lapse quality level corresponding to the 2160p (3840 x 2160) resolution.
 * @apiSince 21
 */

public static final int QUALITY_TIME_LAPSE_2160P = 1008; // 0x3f0

/**
 * Time lapse quality level corresponding to the 480p (720 x 480) resolution.
 * @apiSince 11
 */

public static final int QUALITY_TIME_LAPSE_480P = 1004; // 0x3ec

/**
 * Time lapse quality level corresponding to the 720p (1280 x 720) resolution.
 * @apiSince 11
 */

public static final int QUALITY_TIME_LAPSE_720P = 1005; // 0x3ed

/**
 * Time lapse quality level corresponding to the cif (352 x 288) resolution.
 * @apiSince 11
 */

public static final int QUALITY_TIME_LAPSE_CIF = 1003; // 0x3eb

/**
 * Time lapse quality level corresponding to the highest available resolution.
 * @apiSince 11
 */

public static final int QUALITY_TIME_LAPSE_HIGH = 1001; // 0x3e9

/**
 * Time lapse quality level corresponding to the lowest available resolution.
 * @apiSince 11
 */

public static final int QUALITY_TIME_LAPSE_LOW = 1000; // 0x3e8

/**
 * Time lapse quality level corresponding to the qcif (176 x 144) resolution.
 * @apiSince 11
 */

public static final int QUALITY_TIME_LAPSE_QCIF = 1002; // 0x3ea

/**
 * Time lapse quality level corresponding to the QVGA (320 x 240) resolution.
 * @apiSince 15
 */

public static final int QUALITY_TIME_LAPSE_QVGA = 1007; // 0x3ef

/**
 * The target audio output bit rate in bits per second
 * @apiSince 8
 */

public int audioBitRate;

/**
 * The number of audio channels used for the audio track
 * @apiSince 8
 */

public int audioChannels;

/**
 * The audio encoder being used for the audio track.
 * @see android.media.MediaRecorder.AudioEncoder
 * @apiSince 8
 */

public int audioCodec;

/**
 * The audio sampling rate used for the audio track
 * @apiSince 8
 */

public int audioSampleRate;

/**
 * Default recording duration in seconds before the session is terminated.
 * This is useful for applications like MMS has limited file size requirement.
 * @apiSince 8
 */

public int duration;

/**
 * The file output format of the camcorder profile
 * @see android.media.MediaRecorder.OutputFormat
 * @apiSince 8
 */

public int fileFormat;

/**
 * The quality level of the camcorder profile
 * @apiSince 8
 */

public int quality;

/**
 * The target video output bit rate in bits per second
 * <p>
 * This is the target recorded video output bit rate if the application configures the video
 * recording via {@link android.media.MediaRecorder#setProfile MediaRecorder#setProfile} without specifying any other
 * {@link android.media.MediaRecorder MediaRecorder} encoding parameters. For example, for high speed quality profiles (from
 * {@link #QUALITY_HIGH_SPEED_LOW} to {@link #QUALITY_HIGH_SPEED_2160P}), this is the bit rate
 * where the video is recorded with. If the application intends to record slow motion videos
 * with the high speed quality profiles, it must set a different video bit rate that is
 * corresponding to the desired recording output bit rate (i.e., the encoded video bit rate
 * during normal playback) via {@link android.media.MediaRecorder#setVideoEncodingBitRate MediaRecorder#setVideoEncodingBitRate}. For example, if
 * {@link #QUALITY_HIGH_SPEED_720P} advertises 240fps {@link #videoFrameRate} and 64Mbps
 * {@link #videoBitRate} in the high speed CamcorderProfile, and the application intends to
 * record 1/8 factor slow motion recording videos, the application must set 30fps via
 * {@link android.media.MediaRecorder#setVideoFrameRate MediaRecorder#setVideoFrameRate} and 8Mbps ( {@link #videoBitRate} * slow motion
 * factor) via {@link android.media.MediaRecorder#setVideoEncodingBitRate MediaRecorder#setVideoEncodingBitRate}. Failing to do so will result in
 * videos with unexpected frame rate and bit rate, or {@link android.media.MediaRecorder MediaRecorder} error if the output
 * bit rate exceeds the encoder limit. If the application intends to do the video recording with
 * {@link android.media.MediaCodec MediaCodec} encoder, it must set each individual field of {@link android.media.MediaFormat MediaFormat}
 * similarly according to this CamcorderProfile.
 * </p>
 *
 * @see #videoFrameRate
 * @see android.media.MediaRecorder
 * @see android.media.MediaCodec
 * @see android.media.MediaFormat
 * @apiSince 8
 */

public int videoBitRate;

/**
 * The video encoder being used for the video track
 * @see android.media.MediaRecorder.VideoEncoder
 * @apiSince 8
 */

public int videoCodec;

/**
 * The target video frame height in pixels
 * @apiSince 8
 */

public int videoFrameHeight;

/**
 * The target video frame rate in frames per second.
 * <p>
 * This is the target recorded video output frame rate per second if the application configures
 * the video recording via {@link android.media.MediaRecorder#setProfile MediaRecorder#setProfile} without specifying any other
 * {@link android.media.MediaRecorder MediaRecorder} encoding parameters. For example, for high speed quality profiles (from
 * {@link #QUALITY_HIGH_SPEED_LOW} to {@link #QUALITY_HIGH_SPEED_2160P}), this is the frame rate
 * where the video is recorded and played back with. If the application intends to create slow
 * motion use case with the high speed quality profiles, it must set a different video frame
 * rate that is corresponding to the desired output (playback) frame rate via
 * {@link android.media.MediaRecorder#setVideoFrameRate MediaRecorder#setVideoFrameRate}. For example, if {@link #QUALITY_HIGH_SPEED_720P}
 * advertises 240fps {@link #videoFrameRate} in the CamcorderProfile, and the application
 * intends to create 1/8 factor slow motion recording videos, the application must set 30fps via
 * {@link android.media.MediaRecorder#setVideoFrameRate MediaRecorder#setVideoFrameRate}. Failing to do so will result in high speed videos
 * with normal speed playback frame rate (240fps for above example). If the application intends
 * to do the video recording with {@link android.media.MediaCodec MediaCodec} encoder, it must set each individual field
 * of {@link android.media.MediaFormat MediaFormat} similarly according to this CamcorderProfile.
 * </p>
 *
 * @see #videoBitRate
 * @see android.media.MediaRecorder
 * @see android.media.MediaCodec
 * @see android.media.MediaFormat
 * @apiSince 8
 */

public int videoFrameRate;

/**
 * The target video frame width in pixels
 * @apiSince 8
 */

public int videoFrameWidth;
}

