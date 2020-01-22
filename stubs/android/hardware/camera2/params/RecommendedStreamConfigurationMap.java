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


package android.hardware.camera2.params;

import android.hardware.camera2.CameraDevice;
import android.view.Surface;
import android.hardware.camera2.CameraCharacteristics;
import android.graphics.ImageFormat;
import android.graphics.PixelFormat;
import android.hardware.camera2.CaptureRequest;
import android.util.Size;
import android.hardware.camera2.CameraMetadata;

/**
 * Immutable class to store the recommended stream configurations to set up
 * {@link android.view.Surface Surfaces} for creating a
 * {@link android.hardware.camera2.CameraCaptureSession capture session} with
 * {@link android.hardware.camera2.CameraDevice#createCaptureSession}.
 *
 * <p>The recommended list does not replace or deprecate the exhaustive complete list found in
 * {@link android.hardware.camera2.params.StreamConfigurationMap StreamConfigurationMap}. It is a suggestion about available power and performance
 * efficient stream configurations for a specific use case. Per definition it is only a subset
 * of {@link android.hardware.camera2.params.StreamConfigurationMap StreamConfigurationMap} and can be considered by developers for optimization
 * purposes.</p>
 *
 * <p>This also duplicates the minimum frame durations and stall durations from the
 * {@link android.hardware.camera2.params.StreamConfigurationMap StreamConfigurationMap} for each format/size combination that can be used to calculate
 * effective frame rate when submitting multiple captures.
 * </p>
 *
 * <p>An instance of this object is available by invoking
 * {@link android.hardware.camera2.CameraCharacteristics#getRecommendedStreamConfigurationMap CameraCharacteristics#getRecommendedStreamConfigurationMap} and passing a respective
 * usecase id. For more information about supported use case constants see
 * {@link #USECASE_PREVIEW}.</p>
 *
 * <pre><code>{@code
 * CameraCharacteristics characteristics = cameraManager.getCameraCharacteristics(cameraId);
 * RecommendedStreamConfigurationMap configs = characteristics.getRecommendedStreamConfigurationMap(
 *         RecommendedStreamConfigurationMap.USECASE_PREVIEW);
 * }</code></pre>
 *
 * @see android.hardware.camera2.CameraCharacteristics#getRecommendedStreamConfigurationMap
 * @see CameraDevice#createCaptureSession
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class RecommendedStreamConfigurationMap {

RecommendedStreamConfigurationMap() { throw new RuntimeException("Stub!"); }

/**
 * Get the use case value for the recommended stream configurations.
 *
 * @return Use case id.
 
 * Value is {@link android.hardware.camera2.params.RecommendedStreamConfigurationMap#USECASE_PREVIEW}, {@link android.hardware.camera2.params.RecommendedStreamConfigurationMap#USECASE_RECORD}, {@link android.hardware.camera2.params.RecommendedStreamConfigurationMap#USECASE_VIDEO_SNAPSHOT}, {@link android.hardware.camera2.params.RecommendedStreamConfigurationMap#USECASE_SNAPSHOT}, {@link android.hardware.camera2.params.RecommendedStreamConfigurationMap#USECASE_ZSL}, {@link android.hardware.camera2.params.RecommendedStreamConfigurationMap#USECASE_RAW}, or {@link android.hardware.camera2.params.RecommendedStreamConfigurationMap#USECASE_LOW_LATENCY_SNAPSHOT}
 * @apiSince 29
 */

public int getRecommendedUseCase() { throw new RuntimeException("Stub!"); }

/**
 * Get the image {@code format} output formats in this stream configuration.
 *
 * <p>
 * For more information refer to {@link android.hardware.camera2.params.StreamConfigurationMap#getOutputFormats StreamConfigurationMap#getOutputFormats}.
 * </p>
 *
 * @return a non-modifiable set of Integer formats
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.util.Set<java.lang.Integer> getOutputFormats() { throw new RuntimeException("Stub!"); }

/**
 * Get the image {@code format} output formats for a reprocessing input format.
 *
 * <p>
 * For more information refer to {@link android.hardware.camera2.params.StreamConfigurationMap#getValidOutputFormatsForInput StreamConfigurationMap#getValidOutputFormatsForInput}.
 * </p>
 *
 * @param inputFormat Value is {@link android.graphics.ImageFormat#UNKNOWN}, {@link android.graphics.ImageFormat#RGB_565}, {@link android.graphics.ImageFormat#YV12}, {@link android.graphics.ImageFormat#Y8}, android.graphics.ImageFormat.Y16, {@link android.graphics.ImageFormat#NV16}, {@link android.graphics.ImageFormat#NV21}, {@link android.graphics.ImageFormat#YUY2}, {@link android.graphics.ImageFormat#JPEG}, {@link android.graphics.ImageFormat#DEPTH_JPEG}, {@link android.graphics.ImageFormat#YUV_420_888}, {@link android.graphics.ImageFormat#YUV_422_888}, {@link android.graphics.ImageFormat#YUV_444_888}, {@link android.graphics.ImageFormat#FLEX_RGB_888}, {@link android.graphics.ImageFormat#FLEX_RGBA_8888}, {@link android.graphics.ImageFormat#RAW_SENSOR}, {@link android.graphics.ImageFormat#RAW_PRIVATE}, {@link android.graphics.ImageFormat#RAW10}, {@link android.graphics.ImageFormat#RAW12}, {@link android.graphics.ImageFormat#DEPTH16}, {@link android.graphics.ImageFormat#DEPTH_POINT_CLOUD}, android.graphics.ImageFormat.RAW_DEPTH, {@link android.graphics.ImageFormat#PRIVATE}, or {@link android.graphics.ImageFormat#HEIC}
 * @return a non-modifiable set of Integer formats
 
 * This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.util.Set<java.lang.Integer> getValidOutputFormatsForInput(int inputFormat) { throw new RuntimeException("Stub!"); }

/**
 * Get the image {@code format} input formats in this stream configuration.
 *
 * <p>All image formats returned by this function will be defined in either {@link android.graphics.ImageFormat ImageFormat}
 * or in {@link android.graphics.PixelFormat PixelFormat} (and there is no possibility of collision).</p>
 *
 * @return a non-modifiable set of Integer formats
 
 * This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.util.Set<java.lang.Integer> getInputFormats() { throw new RuntimeException("Stub!"); }

/**
 * Get the supported input sizes for this input format.
 *
 * <p>The format must have come from {@link #getInputFormats}; otherwise
 * {@code null} is returned.</p>
 *
 * @param format a format from {@link #getInputFormats}
 * Value is {@link android.graphics.ImageFormat#UNKNOWN}, {@link android.graphics.ImageFormat#RGB_565}, {@link android.graphics.ImageFormat#YV12}, {@link android.graphics.ImageFormat#Y8}, android.graphics.ImageFormat.Y16, {@link android.graphics.ImageFormat#NV16}, {@link android.graphics.ImageFormat#NV21}, {@link android.graphics.ImageFormat#YUY2}, {@link android.graphics.ImageFormat#JPEG}, {@link android.graphics.ImageFormat#DEPTH_JPEG}, {@link android.graphics.ImageFormat#YUV_420_888}, {@link android.graphics.ImageFormat#YUV_422_888}, {@link android.graphics.ImageFormat#YUV_444_888}, {@link android.graphics.ImageFormat#FLEX_RGB_888}, {@link android.graphics.ImageFormat#FLEX_RGBA_8888}, {@link android.graphics.ImageFormat#RAW_SENSOR}, {@link android.graphics.ImageFormat#RAW_PRIVATE}, {@link android.graphics.ImageFormat#RAW10}, {@link android.graphics.ImageFormat#RAW12}, {@link android.graphics.ImageFormat#DEPTH16}, {@link android.graphics.ImageFormat#DEPTH_POINT_CLOUD}, android.graphics.ImageFormat.RAW_DEPTH, {@link android.graphics.ImageFormat#PRIVATE}, or {@link android.graphics.ImageFormat#HEIC}
 * @return a non-modifiable set of sizes, or {@code null} if the format was not available.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.util.Set<android.util.Size> getInputSizes(int format) { throw new RuntimeException("Stub!"); }

/**
 * Determine whether or not output surfaces with a particular user-defined format can be passed
 * {@link android.hardware.camera2.CameraDevice#createCaptureSession CameraDevice#createCaptureSession}.
 *
 * <p>
 * For further information refer to {@link android.hardware.camera2.params.StreamConfigurationMap#isOutputSupportedFor StreamConfigurationMap#isOutputSupportedFor}.
 * </p>
 *
 *
 * @param format an image format from either {@link android.graphics.ImageFormat ImageFormat} or {@link android.graphics.PixelFormat PixelFormat}
 * Value is {@link android.graphics.ImageFormat#UNKNOWN}, {@link android.graphics.ImageFormat#RGB_565}, {@link android.graphics.ImageFormat#YV12}, {@link android.graphics.ImageFormat#Y8}, android.graphics.ImageFormat.Y16, {@link android.graphics.ImageFormat#NV16}, {@link android.graphics.ImageFormat#NV21}, {@link android.graphics.ImageFormat#YUY2}, {@link android.graphics.ImageFormat#JPEG}, {@link android.graphics.ImageFormat#DEPTH_JPEG}, {@link android.graphics.ImageFormat#YUV_420_888}, {@link android.graphics.ImageFormat#YUV_422_888}, {@link android.graphics.ImageFormat#YUV_444_888}, {@link android.graphics.ImageFormat#FLEX_RGB_888}, {@link android.graphics.ImageFormat#FLEX_RGBA_8888}, {@link android.graphics.ImageFormat#RAW_SENSOR}, {@link android.graphics.ImageFormat#RAW_PRIVATE}, {@link android.graphics.ImageFormat#RAW10}, {@link android.graphics.ImageFormat#RAW12}, {@link android.graphics.ImageFormat#DEPTH16}, {@link android.graphics.ImageFormat#DEPTH_POINT_CLOUD}, android.graphics.ImageFormat.RAW_DEPTH, {@link android.graphics.ImageFormat#PRIVATE}, or {@link android.graphics.ImageFormat#HEIC}
 * @return
 *          {@code true} if using a {@code surface} with this {@code format} will be
 *          supported with {@link android.hardware.camera2.CameraDevice#createCaptureSession CameraDevice#createCaptureSession}
 *
 * @throws java.lang.IllegalArgumentException
 *          if the image format was not a defined named constant
 *          from either {@link android.graphics.ImageFormat ImageFormat} or {@link android.graphics.PixelFormat PixelFormat}
 * @apiSince 29
 */

public boolean isOutputSupportedFor(int format) { throw new RuntimeException("Stub!"); }

/**
 * Get a list of sizes compatible with the requested image {@code format}.
 *
 * <p>
 * For more information refer to {@link android.hardware.camera2.params.StreamConfigurationMap#getOutputSizes StreamConfigurationMap#getOutputSizes}.
 * </p>
 *
 *
 * @param format an image format from {@link android.graphics.ImageFormat ImageFormat} or {@link android.graphics.PixelFormat PixelFormat}
 * Value is {@link android.graphics.ImageFormat#UNKNOWN}, {@link android.graphics.ImageFormat#RGB_565}, {@link android.graphics.ImageFormat#YV12}, {@link android.graphics.ImageFormat#Y8}, android.graphics.ImageFormat.Y16, {@link android.graphics.ImageFormat#NV16}, {@link android.graphics.ImageFormat#NV21}, {@link android.graphics.ImageFormat#YUY2}, {@link android.graphics.ImageFormat#JPEG}, {@link android.graphics.ImageFormat#DEPTH_JPEG}, {@link android.graphics.ImageFormat#YUV_420_888}, {@link android.graphics.ImageFormat#YUV_422_888}, {@link android.graphics.ImageFormat#YUV_444_888}, {@link android.graphics.ImageFormat#FLEX_RGB_888}, {@link android.graphics.ImageFormat#FLEX_RGBA_8888}, {@link android.graphics.ImageFormat#RAW_SENSOR}, {@link android.graphics.ImageFormat#RAW_PRIVATE}, {@link android.graphics.ImageFormat#RAW10}, {@link android.graphics.ImageFormat#RAW12}, {@link android.graphics.ImageFormat#DEPTH16}, {@link android.graphics.ImageFormat#DEPTH_POINT_CLOUD}, android.graphics.ImageFormat.RAW_DEPTH, {@link android.graphics.ImageFormat#PRIVATE}, or {@link android.graphics.ImageFormat#HEIC}
 * @return  a non-modifiable set of supported sizes,
 *          or {@code null} if the {@code format} is not a supported output
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.util.Set<android.util.Size> getOutputSizes(int format) { throw new RuntimeException("Stub!"); }

/**
 * Get a list of supported high speed video recording sizes.
 * <p>
 * For more information refer to {@link android.hardware.camera2.params.StreamConfigurationMap#getHighSpeedVideoSizes StreamConfigurationMap#getHighSpeedVideoSizes}.
 * </p>
 *
 * @return a non-modifiable set of supported high speed video recording sizes
 
 * This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.util.Set<android.util.Size> getHighSpeedVideoSizes() { throw new RuntimeException("Stub!"); }

/**
 * Get the frame per second ranges (fpsMin, fpsMax) for input high speed video size.
 *
 * <p>
 * For further information refer to
 * {@link android.hardware.camera2.params.StreamConfigurationMap#getHighSpeedVideoFpsRangesFor StreamConfigurationMap#getHighSpeedVideoFpsRangesFor}.
 * </p>
 * @param size one of the sizes returned by {@link #getHighSpeedVideoSizes()}
 * This value must never be {@code null}.
 * @return a non-modifiable set of supported high speed video recording FPS ranges The upper
 *         bound of returned ranges is guaranteed to be greater than or equal to 120.
 * This value may be {@code null}.
 * @throws java.lang.IllegalArgumentException if input size does not exist in the return value of
 *             getHighSpeedVideoSizes
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.util.Set<android.util.Range<java.lang.Integer>> getHighSpeedVideoFpsRangesFor(@androidx.annotation.NonNull android.util.Size size) { throw new RuntimeException("Stub!"); }

/**
 * Get a list of supported high speed video recording FPS ranges.
 * <p>
 * For further information refer to {@link android.hardware.camera2.params.StreamConfigurationMap#getHighSpeedVideoFpsRanges StreamConfigurationMap#getHighSpeedVideoFpsRanges}.
 * </p>
 * @return a non-modifiable set of supported high speed video recording FPS ranges The upper
 *         bound of returned ranges is guaranteed to be larger or equal to 120.
 
 * This value may be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.util.Set<android.util.Range<java.lang.Integer>> getHighSpeedVideoFpsRanges() { throw new RuntimeException("Stub!"); }

/**
 * Get the supported video sizes for an input high speed FPS range.
 *
 * <p>
 * For further information refer to {@link android.hardware.camera2.params.StreamConfigurationMap#getHighSpeedVideoSizesFor StreamConfigurationMap#getHighSpeedVideoSizesFor}.
 * </p>
 *
 * @param fpsRange one of the FPS ranges returned by {@link #getHighSpeedVideoFpsRanges()}
 * This value must never be {@code null}.
 * @return A non-modifiable set of video sizes to create high speed capture sessions for high
 *         speed streaming use cases.
 *
 * This value may be {@code null}.
 * @throws java.lang.IllegalArgumentException if input FPS range does not exist in the return value of
 *         getHighSpeedVideoFpsRanges
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.util.Set<android.util.Size> getHighSpeedVideoSizesFor(@androidx.annotation.NonNull android.util.Range<java.lang.Integer> fpsRange) { throw new RuntimeException("Stub!"); }

/**
 * Get a list of supported high resolution sizes, which cannot operate at full BURST_CAPTURE
 * rate.
 *
 * <p>
 * For further information refer to {@link android.hardware.camera2.params.StreamConfigurationMap#getHighResolutionOutputSizes StreamConfigurationMap#getHighResolutionOutputSizes}.
 * </p>
 *
 * @param format Value is {@link android.graphics.ImageFormat#UNKNOWN}, {@link android.graphics.ImageFormat#RGB_565}, {@link android.graphics.ImageFormat#YV12}, {@link android.graphics.ImageFormat#Y8}, android.graphics.ImageFormat.Y16, {@link android.graphics.ImageFormat#NV16}, {@link android.graphics.ImageFormat#NV21}, {@link android.graphics.ImageFormat#YUY2}, {@link android.graphics.ImageFormat#JPEG}, {@link android.graphics.ImageFormat#DEPTH_JPEG}, {@link android.graphics.ImageFormat#YUV_420_888}, {@link android.graphics.ImageFormat#YUV_422_888}, {@link android.graphics.ImageFormat#YUV_444_888}, {@link android.graphics.ImageFormat#FLEX_RGB_888}, {@link android.graphics.ImageFormat#FLEX_RGBA_8888}, {@link android.graphics.ImageFormat#RAW_SENSOR}, {@link android.graphics.ImageFormat#RAW_PRIVATE}, {@link android.graphics.ImageFormat#RAW10}, {@link android.graphics.ImageFormat#RAW12}, {@link android.graphics.ImageFormat#DEPTH16}, {@link android.graphics.ImageFormat#DEPTH_POINT_CLOUD}, android.graphics.ImageFormat.RAW_DEPTH, {@link android.graphics.ImageFormat#PRIVATE}, or {@link android.graphics.ImageFormat#HEIC}
 * @return a non-modifiable set of supported slower high-resolution sizes, or {@code null} if
 *         the BURST_CAPTURE capability is not supported
 * @apiSince 29
 */

@androidx.annotation.Nullable
public java.util.Set<android.util.Size> getHighResolutionOutputSizes(int format) { throw new RuntimeException("Stub!"); }

/**
 * Get the minimum
 * {@link android.hardware.camera2.CaptureRequest#SENSOR_FRAME_DURATION frame duration}
 * for the format/size combination (in nanoseconds).
 *
 * <p>
 * For further information refer to {@link android.hardware.camera2.params.StreamConfigurationMap#getOutputMinFrameDuration StreamConfigurationMap#getOutputMinFrameDuration}.
 * </p>
 *
 * @param format an image format from {@link android.graphics.ImageFormat ImageFormat} or {@link android.graphics.PixelFormat PixelFormat}
 * Value is {@link android.graphics.ImageFormat#UNKNOWN}, {@link android.graphics.ImageFormat#RGB_565}, {@link android.graphics.ImageFormat#YV12}, {@link android.graphics.ImageFormat#Y8}, android.graphics.ImageFormat.Y16, {@link android.graphics.ImageFormat#NV16}, {@link android.graphics.ImageFormat#NV21}, {@link android.graphics.ImageFormat#YUY2}, {@link android.graphics.ImageFormat#JPEG}, {@link android.graphics.ImageFormat#DEPTH_JPEG}, {@link android.graphics.ImageFormat#YUV_420_888}, {@link android.graphics.ImageFormat#YUV_422_888}, {@link android.graphics.ImageFormat#YUV_444_888}, {@link android.graphics.ImageFormat#FLEX_RGB_888}, {@link android.graphics.ImageFormat#FLEX_RGBA_8888}, {@link android.graphics.ImageFormat#RAW_SENSOR}, {@link android.graphics.ImageFormat#RAW_PRIVATE}, {@link android.graphics.ImageFormat#RAW10}, {@link android.graphics.ImageFormat#RAW12}, {@link android.graphics.ImageFormat#DEPTH16}, {@link android.graphics.ImageFormat#DEPTH_POINT_CLOUD}, android.graphics.ImageFormat.RAW_DEPTH, {@link android.graphics.ImageFormat#PRIVATE}, or {@link android.graphics.ImageFormat#HEIC}
 * @param size an output-compatible size
 * This value must never be {@code null}.
 * @return a minimum frame duration {@code >} 0 in nanoseconds, or
 *          0 if the minimum frame duration is not available.
 *
 * Value is 0 or greater
 * @throws java.lang.IllegalArgumentException if {@code format} or {@code size} was not supported
 * @apiSince 29
 */

public long getOutputMinFrameDuration(int format, @androidx.annotation.NonNull android.util.Size size) { throw new RuntimeException("Stub!"); }

/**
 * Get the stall duration for the format/size combination (in nanoseconds).
 *
 * <p>
 * For further information refer to {@link android.hardware.camera2.params.StreamConfigurationMap#getOutputStallDuration StreamConfigurationMap#getOutputStallDuration}.
 * </p>
 *
 * @param format an image format from {@link android.graphics.ImageFormat ImageFormat} or {@link android.graphics.PixelFormat PixelFormat}
 * Value is {@link android.graphics.ImageFormat#UNKNOWN}, {@link android.graphics.ImageFormat#RGB_565}, {@link android.graphics.ImageFormat#YV12}, {@link android.graphics.ImageFormat#Y8}, android.graphics.ImageFormat.Y16, {@link android.graphics.ImageFormat#NV16}, {@link android.graphics.ImageFormat#NV21}, {@link android.graphics.ImageFormat#YUY2}, {@link android.graphics.ImageFormat#JPEG}, {@link android.graphics.ImageFormat#DEPTH_JPEG}, {@link android.graphics.ImageFormat#YUV_420_888}, {@link android.graphics.ImageFormat#YUV_422_888}, {@link android.graphics.ImageFormat#YUV_444_888}, {@link android.graphics.ImageFormat#FLEX_RGB_888}, {@link android.graphics.ImageFormat#FLEX_RGBA_8888}, {@link android.graphics.ImageFormat#RAW_SENSOR}, {@link android.graphics.ImageFormat#RAW_PRIVATE}, {@link android.graphics.ImageFormat#RAW10}, {@link android.graphics.ImageFormat#RAW12}, {@link android.graphics.ImageFormat#DEPTH16}, {@link android.graphics.ImageFormat#DEPTH_POINT_CLOUD}, android.graphics.ImageFormat.RAW_DEPTH, {@link android.graphics.ImageFormat#PRIVATE}, or {@link android.graphics.ImageFormat#HEIC}
 * @param size an output-compatible size
 * This value must never be {@code null}.
 * @return a stall duration {@code >=} 0 in nanoseconds
 *
 * Value is 0 or greater
 * @throws java.lang.IllegalArgumentException if {@code format} or {@code size} was not supported
 * @apiSince 29
 */

public long getOutputStallDuration(int format, @androidx.annotation.NonNull android.util.Size size) { throw new RuntimeException("Stub!"); }

/**
 * Get a list of sizes compatible with {@code klass} to use as an output.
 *
 * <p>For further information refer to {@link android.hardware.camera2.params.StreamConfigurationMap#getOutputSizes(java.lang.Class) StreamConfigurationMap#getOutputSizes(Class)}.
 * </p>
 *
 * @param klass
 *          a {@link java.lang.Class Class} object reference
 * This value must never be {@code null}.
 * @return
 *          a non-modifiable set of supported sizes for {@link android.graphics.ImageFormat#PRIVATE ImageFormat#PRIVATE} format,
 *          or {@code null} if the {@code klass} is not a supported output.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public <T> java.util.Set<android.util.Size> getOutputSizes(@androidx.annotation.NonNull java.lang.Class<T> klass) { throw new RuntimeException("Stub!"); }

/**
 * Get the minimum {@link android.hardware.camera2.CaptureRequest#SENSOR_FRAME_DURATION CaptureRequest#SENSOR_FRAME_DURATION}
 * for the class/size combination (in nanoseconds).
 *
 * <p>For more information refer to
 * {@link android.hardware.camera2.params.StreamConfigurationMap#getOutputMinFrameDuration(java.lang.Class,android.util.Size) StreamConfigurationMap#getOutputMinFrameDuration(Class, Size)}.</p>
 *
 * @param klass
 *          a class which has a non-empty array returned by {@link #getOutputSizes(java.lang.Class)}
 * This value must never be {@code null}.
 * @param size an output-compatible size
 * This value must never be {@code null}.
 * @return a minimum frame duration {@code >} 0 in nanoseconds, or
 *          0 if the minimum frame duration is not available.
 *
 * Value is 0 or greater
 * @throws java.lang.IllegalArgumentException if {@code klass} or {@code size} was not supported
 * @apiSince 29
 */

public <T> long getOutputMinFrameDuration(@androidx.annotation.NonNull java.lang.Class<T> klass, @androidx.annotation.NonNull android.util.Size size) { throw new RuntimeException("Stub!"); }

/**
 * Get the stall duration for the class/size combination (in nanoseconds).
 *
 * <p>For more information refer to
 * {@link android.hardware.camera2.params.StreamConfigurationMap#getOutputStallDuration(java.lang.Class,android.util.Size) StreamConfigurationMap#getOutputStallDuration(Class, Size)}.
 *
 * @param klass
 *          a class which has a non-empty array returned by {@link #getOutputSizes(java.lang.Class)}.
 * This value must never be {@code null}.
 * @param size an output-compatible size
 * This value must never be {@code null}.
 * @return a minimum frame duration {@code >} 0 in nanoseconds, or 0 if the stall duration is
 *         not available.
 *
 * Value is 0 or greater
 * @throws java.lang.IllegalArgumentException if {@code klass} or {@code size} was not supported
 * @apiSince 29
 */

public <T> long getOutputStallDuration(@androidx.annotation.NonNull java.lang.Class<T> klass, @androidx.annotation.NonNull android.util.Size size) { throw new RuntimeException("Stub!"); }

/**
 * Determine whether or not the {@code surface} in its current state is suitable to be included
 * in a {@link android.hardware.camera2.CameraDevice#createCaptureSession CameraDevice#createCaptureSession} as an output.
 *
 * <p>For more information refer to {@link android.hardware.camera2.params.StreamConfigurationMap#isOutputSupportedFor StreamConfigurationMap#isOutputSupportedFor}.
 * </p>
 *
 * @param surface a {@link android.view.Surface Surface} object reference
 * This value must never be {@code null}.
 * @return {@code true} if this is supported, {@code false} otherwise
 *
 * @throws java.lang.IllegalArgumentException if the Surface endpoint is no longer valid
 *
 * @apiSince 29
 */

public boolean isOutputSupportedFor(@androidx.annotation.NonNull android.view.Surface surface) { throw new RuntimeException("Stub!"); }

/**
 * The recommended stream configuration map for use case low latency snapshot must contain
 * subset of configurations with end-to-end latency that does not exceed 200 ms. under standard
 * operating conditions (reasonable light levels, not loaded system). The expected output format
 * will be primarily {@link android.graphics.ImageFormat#JPEG} however other image formats can
 * be present as well.  Even if available for the camera device, high speed and input
 * configurations will be absent. This suggested configuration map may be absent on some devices
 * that can not support any low latency requests.
 * @apiSince 29
 */

public static final int USECASE_LOW_LATENCY_SNAPSHOT = 6; // 0x6

/**
 * The recommended stream configuration map for use case preview must contain a subset of
 * efficient, non-stalling configurations that must include both
 * {@link android.graphics.ImageFormat#PRIVATE} and
 * {@link android.graphics.ImageFormat#YUV_420_888} output formats. Even if available for the
 * camera device, high speed or input configurations will be absent.
 * @apiSince 29
 */

public static final int USECASE_PREVIEW = 0; // 0x0

/**
 * In case the device supports
 * {@link android.hardware.camera2.CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_RAW}, the
 * recommended stream configuration map for use case RAW must contain a subset of efficient
 * configurations that include the {@link android.graphics.ImageFormat#RAW_SENSOR} and other
 * RAW output formats. Even if available for the camera device, high speed and input
 * configurations will be absent.
 * @apiSince 29
 */

public static final int USECASE_RAW = 5; // 0x5

/**
 * The recommended stream configuration map for recording must contain a subset of efficient
 * video configurations that include {@link android.graphics.ImageFormat#PRIVATE}
 * output format for at least all supported {@link android.media.CamcorderProfile profiles}.
 * High speed configurations if supported will be available as well. Even if available for the
 * camera device, input configurations will be absent.
 * @apiSince 29
 */

public static final int USECASE_RECORD = 1; // 0x1

/**
 * The recommended stream configuration map for use case snapshot must contain a subset of
 * efficient still capture configurations that must include
 * {@link android.graphics.ImageFormat#JPEG} output format and at least one configuration with
 * size approximately equal to the sensor pixel array size
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE}.
 * Even if available for the camera device, high speed or input configurations will be absent.
 * @apiSince 29
 */

public static final int USECASE_SNAPSHOT = 3; // 0x3

/**
 * The recommended stream configuration map for use case video snapshot must only contain a
 * subset of efficient liveshot configurations that include
 * {@link android.graphics.ImageFormat#JPEG} output format. The sizes will match at least
 * the maximum resolution of usecase record and will not cause any preview glitches. Even
 * if available for the camera device, high speed or input configurations will be absent.
 * @apiSince 29
 */

public static final int USECASE_VIDEO_SNAPSHOT = 2; // 0x2

/**
 * In case the device supports
 * {@link android.hardware.camera2.CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_YUV_REPROCESSING CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_YUV_REPROCESSING} and/or
 * {@link android.hardware.camera2.CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_PRIVATE_REPROCESSING CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_PRIVATE_REPROCESSING},
 * the recommended stream configuration map for use case ZSL must contain a subset of efficient
 * configurations that include the suggested input and output format mappings. Even if
 * available for the camera device, high speed configurations will be absent.
 * @apiSince 29
 */

public static final int USECASE_ZSL = 4; // 0x4
}

