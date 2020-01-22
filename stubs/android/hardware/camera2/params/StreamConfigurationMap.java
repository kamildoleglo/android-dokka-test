/*
 * Copyright (C) 2014 The Android Open Source Project
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
 * Immutable class to store the available stream
 * {@link android.hardware.camera2.CameraCharacteristics#SCALER_STREAM_CONFIGURATION_MAP CameraCharacteristics#SCALER_STREAM_CONFIGURATION_MAP} to set up
 * {@link android.view.Surface Surfaces} for creating a
 * {@link android.hardware.camera2.CameraCaptureSession capture session} with
 * {@link android.hardware.camera2.CameraDevice#createCaptureSession}.
 * <!-- TODO: link to input stream configuration -->
 *
 * <p>This is the authoritative list for all <!-- input/ -->output formats (and sizes respectively
 * for that format) that are supported by a camera device.</p>
 *
 * <p>This also contains the minimum frame durations and stall durations for each format/size
 * combination that can be used to calculate effective frame rate when submitting multiple captures.
 * </p>
 *
 * <p>An instance of this object is available from {@link android.hardware.camera2.CameraCharacteristics CameraCharacteristics} using
 * the {@link android.hardware.camera2.CameraCharacteristics#SCALER_STREAM_CONFIGURATION_MAP CameraCharacteristics#SCALER_STREAM_CONFIGURATION_MAP} key and the
 * {@link android.hardware.camera2.CameraCharacteristics#get CameraCharacteristics#get} method.</p>
 *
 * <pre><code>{@code
 * CameraCharacteristics characteristics = cameraManager.getCameraCharacteristics(cameraId);
 * StreamConfigurationMap configs = characteristics.get(
 *         CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
 * }</code></pre>
 *
 * @see android.hardware.camera2.CameraCharacteristics#SCALER_STREAM_CONFIGURATION_MAP
 * @see CameraDevice#createCaptureSession
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class StreamConfigurationMap {

StreamConfigurationMap() { throw new RuntimeException("Stub!"); }

/**
 * Get the image {@code format} output formats in this stream configuration.
 *
 * <p>All image formats returned by this function will be defined in either {@link android.graphics.ImageFormat ImageFormat}
 * or in {@link android.graphics.PixelFormat PixelFormat} (and there is no possibility of collision).</p>
 *
 * <p>Formats listed in this array are guaranteed to return true if queried with
 * {@link #isOutputSupportedFor(int)}.</p>
 *
 * @return an array of integer format
 *
 * @see android.graphics.ImageFormat
 * @see android.graphics.PixelFormat
 * @apiSince 21
 */

public int[] getOutputFormats() { throw new RuntimeException("Stub!"); }

/**
 * Get the image {@code format} output formats for a reprocessing input format.
 *
 * <p>When submitting a {@link android.hardware.camera2.CaptureRequest CaptureRequest} with an input Surface of a given format,
 * the only allowed target outputs of the {@link android.hardware.camera2.CaptureRequest CaptureRequest} are the ones with a format
 * listed in the return value of this method. Including any other output Surface as a target
 * will throw an IllegalArgumentException. If no output format is supported given the input
 * format, an empty int[] will be returned.</p>
 *
 * <p>All image formats returned by this function will be defined in either {@link android.graphics.ImageFormat ImageFormat}
 * or in {@link android.graphics.PixelFormat PixelFormat} (and there is no possibility of collision).</p>
 *
 * <p>Formats listed in this array are guaranteed to return true if queried with
 * {@link #isOutputSupportedFor(int)}.</p>
 *
 * @return an array of integer format
 *
 * @see android.graphics.ImageFormat
 * @see android.graphics.PixelFormat
 * @apiSince 23
 */

public int[] getValidOutputFormatsForInput(int inputFormat) { throw new RuntimeException("Stub!"); }

/**
 * Get the image {@code format} input formats in this stream configuration.
 *
 * <p>All image formats returned by this function will be defined in either {@link android.graphics.ImageFormat ImageFormat}
 * or in {@link android.graphics.PixelFormat PixelFormat} (and there is no possibility of collision).</p>
 *
 * @return an array of integer format
 *
 * @see android.graphics.ImageFormat
 * @see android.graphics.PixelFormat
 * @apiSince 23
 */

public int[] getInputFormats() { throw new RuntimeException("Stub!"); }

/**
 * Get the supported input sizes for this input format.
 *
 * <p>The format must have come from {@link #getInputFormats}; otherwise
 * {@code null} is returned.</p>
 *
 * @param format a format from {@link #getInputFormats}
 * @return a non-empty array of sizes, or {@code null} if the format was not available.
 * @apiSince 23
 */

public android.util.Size[] getInputSizes(int format) { throw new RuntimeException("Stub!"); }

/**
 * Determine whether or not output surfaces with a particular user-defined format can be passed
 * {@link android.hardware.camera2.CameraDevice#createCaptureSession CameraDevice#createCaptureSession}.
 *
 * <p>This method determines that the output {@code format} is supported by the camera device;
 * each output {@code surface} target may or may not itself support that {@code format}.
 * Refer to the class which provides the surface for additional documentation.</p>
 *
 * <p>Formats for which this returns {@code true} are guaranteed to exist in the result
 * returned by {@link #getOutputSizes}.</p>
 *
 * @param format an image format from either {@link android.graphics.ImageFormat ImageFormat} or {@link android.graphics.PixelFormat PixelFormat}
 * @return
 *          {@code true} iff using a {@code surface} with this {@code format} will be
 *          supported with {@link android.hardware.camera2.CameraDevice#createCaptureSession CameraDevice#createCaptureSession}
 *
 * @throws java.lang.IllegalArgumentException
 *          if the image format was not a defined named constant
 *          from either {@link android.graphics.ImageFormat ImageFormat} or {@link android.graphics.PixelFormat PixelFormat}
 *
 * @see android.graphics.ImageFormat
 * @see android.graphics.PixelFormat
 * @see CameraDevice#createCaptureSession
 * @apiSince 21
 */

public boolean isOutputSupportedFor(int format) { throw new RuntimeException("Stub!"); }

/**
 * Determine whether or not output streams can be configured with a particular class
 * as a consumer.
 *
 * <p>The following list is generally usable for outputs:
 * <ul>
 * <li>{@link android.media.ImageReader} -
 * Recommended for image processing or streaming to external resources (such as a file or
 * network)
 * <li>{@link android.media.MediaRecorder} -
 * Recommended for recording video (simple to use)
 * <li>{@link android.media.MediaCodec} -
 * Recommended for recording video (more complicated to use, with more flexibility)
 * <li>{@link android.renderscript.Allocation} -
 * Recommended for image processing with {@link android.renderscript RenderScript}
 * <li>{@link android.view.SurfaceHolder} -
 * Recommended for low-power camera preview with {@link android.view.SurfaceView}
 * <li>{@link android.graphics.SurfaceTexture} -
 * Recommended for OpenGL-accelerated preview processing or compositing with
 * {@link android.view.TextureView}
 * </ul>
 * </p>
 *
 * <p>Generally speaking this means that creating a {@link android.view.Surface Surface} from that class <i>may</i>
 * provide a producer endpoint that is suitable to be used with
 * {@link android.hardware.camera2.CameraDevice#createCaptureSession CameraDevice#createCaptureSession}.</p>
 *
 * <p>Since not all of the above classes support output of all format and size combinations,
 * the particular combination should be queried with {@link #isOutputSupportedFor(android.view.Surface)}.</p>
 *
 * @param klass a non-{@code null} {@link java.lang.Class Class} object reference
 * @return {@code true} if this class is supported as an output, {@code false} otherwise
 *
 * @throws java.lang.NullPointerException if {@code klass} was {@code null}
 *
 * @see CameraDevice#createCaptureSession
 * @see #isOutputSupportedFor(Surface)
 * @apiSince 21
 */

public static <T> boolean isOutputSupportedFor(java.lang.Class<T> klass) { throw new RuntimeException("Stub!"); }

/**
 * Determine whether or not the {@code surface} in its current state is suitable to be included
 * in a {@link android.hardware.camera2.CameraDevice#createCaptureSession CameraDevice#createCaptureSession} as an output.
 *
 * <p>Not all surfaces are usable with the {@link android.hardware.camera2.CameraDevice CameraDevice}, and not all configurations
 * of that {@code surface} are compatible. Some classes that provide the {@code surface} are
 * compatible with the {@link android.hardware.camera2.CameraDevice CameraDevice} in general
 * (see {@link #isOutputSupportedFor(java.lang.Class)}, but it is the caller's responsibility to put the
 * {@code surface} into a state that will be compatible with the {@link android.hardware.camera2.CameraDevice CameraDevice}.</p>
 *
 * <p>Reasons for a {@code surface} being specifically incompatible might be:
 * <ul>
 * <li>Using a format that's not listed by {@link #getOutputFormats}
 * <li>Using a format/size combination that's not listed by {@link #getOutputSizes}
 * <li>The {@code surface} itself is not in a state where it can service a new producer.</p>
 * </li>
 * </ul>
 *
 * <p>Surfaces from flexible sources will return true even if the exact size of the Surface does
 * not match a camera-supported size, as long as the format (or class) is supported and the
 * camera device supports a size that is equal to or less than 1080p in that format. If such as
 * Surface is used to create a capture session, it will have its size rounded to the nearest
 * supported size, below or equal to 1080p. Flexible sources include SurfaceView, SurfaceTexture,
 * and ImageReader.</p>
 *
 * <p>This is not an exhaustive list; see the particular class's documentation for further
 * possible reasons of incompatibility.</p>
 *
 * @param surface a non-{@code null} {@link android.view.Surface Surface} object reference
 * @return {@code true} if this is supported, {@code false} otherwise
 *
 * @throws java.lang.NullPointerException if {@code surface} was {@code null}
 * @throws java.lang.IllegalArgumentException if the Surface endpoint is no longer valid
 *
 * @see CameraDevice#createCaptureSession
 * @see #isOutputSupportedFor(Class)
 * @apiSince 21
 */

public boolean isOutputSupportedFor(android.view.Surface surface) { throw new RuntimeException("Stub!"); }

/**
 * Get a list of sizes compatible with {@code klass} to use as an output.
 *
 * <p>Some of the supported classes may support additional formats beyond
 * {@link android.graphics.ImageFormat#PRIVATE ImageFormat#PRIVATE}; this function only returns
 * sizes for {@link android.graphics.ImageFormat#PRIVATE ImageFormat#PRIVATE}. For example, {@link android.media.ImageReader}
 * supports {@link android.graphics.ImageFormat#YUV_420_888 ImageFormat#YUV_420_888} and {@link android.graphics.ImageFormat#PRIVATE ImageFormat#PRIVATE}, this method will
 * only return the sizes for {@link android.graphics.ImageFormat#PRIVATE ImageFormat#PRIVATE} for {@link android.media.ImageReader}
 * class.</p>
 *
 * <p>If a well-defined format such as {@code NV21} is required, use
 * {@link #getOutputSizes(int)} instead.</p>
 *
 * <p>The {@code klass} should be a supported output, that querying
 * {@code #isOutputSupportedFor(Class)} should return {@code true}.</p>
 *
 * @param klass
 *          a non-{@code null} {@link java.lang.Class Class} object reference
 * @return
 *          an array of supported sizes for {@link android.graphics.ImageFormat#PRIVATE ImageFormat#PRIVATE} format,
 *          or {@code null} iff the {@code klass} is not a supported output.
 *
 *
 * @throws java.lang.NullPointerException if {@code klass} was {@code null}
 *
 * @see #isOutputSupportedFor(Class)
 * @apiSince 21
 */

public <T> android.util.Size[] getOutputSizes(java.lang.Class<T> klass) { throw new RuntimeException("Stub!"); }

/**
 * Get a list of sizes compatible with the requested image {@code format}.
 *
 * <p>The {@code format} should be a supported format (one of the formats returned by
 * {@link #getOutputFormats}).</p>
 *
 * As of API level 23, the {@link #getHighResolutionOutputSizes} method can be used on devices
 * that support the
 * {@link android.hardware.camera2.CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES_BURST_CAPTURE BURST_CAPTURE}
 * capability to get a list of high-resolution output sizes that cannot operate at the preferred
 * 20fps rate. This means that for some supported formats, this method will return an empty
 * list, if all the supported resolutions operate at below 20fps.  For devices that do not
 * support the BURST_CAPTURE capability, all output resolutions are listed through this method.
 *
 * @param format an image format from {@link android.graphics.ImageFormat ImageFormat} or {@link android.graphics.PixelFormat PixelFormat}
 * @return
 *          an array of supported sizes,
 *          or {@code null} if the {@code format} is not a supported output
 *
 * @see android.graphics.ImageFormat
 * @see android.graphics.PixelFormat
 * @see #getOutputFormats
 * @apiSince 21
 */

public android.util.Size[] getOutputSizes(int format) { throw new RuntimeException("Stub!"); }

/**
 * Get a list of supported high speed video recording sizes.
 * <p>
 * When {@link android.hardware.camera2.CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_CONSTRAINED_HIGH_SPEED_VIDEO CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_CONSTRAINED_HIGH_SPEED_VIDEO} is
 * supported in {@link android.hardware.camera2.CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES}, this method will
 * list the supported high speed video size configurations. All the sizes listed will be a
 * subset of the sizes reported by {@link #getOutputSizes} for processed non-stalling formats
 * (typically {@link android.graphics.ImageFormat#PRIVATE ImageFormat#PRIVATE} {@link android.graphics.ImageFormat#YUV_420_888 ImageFormat#YUV_420_888}, etc.)
 * </p>
 * <p>
 * To enable high speed video recording, application must create a constrained create high speed
 * capture session via {@link android.hardware.camera2.CameraDevice#createConstrainedHighSpeedCaptureSession CameraDevice#createConstrainedHighSpeedCaptureSession}, and submit
 * a CaptureRequest list created by
 * {@link android.hardware.camera2.CameraConstrainedHighSpeedCaptureSession#createHighSpeedRequestList}
 * to this session. The application must select the video size from this method and
 * {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_TARGET_FPS_RANGE CaptureRequest#CONTROL_AE_TARGET_FPS_RANGE} from
 * {@link #getHighSpeedVideoFpsRangesFor} to configure the constrained high speed session and
 * generate the high speed request list. For example, if the application intends to do high
 * speed recording, it can select the maximum size reported by this method to create high speed
 * capture session. Note that for the use case of multiple output streams, application must
 * select one unique size from this method to use (e.g., preview and recording streams must have
 * the same size). Otherwise, the high speed session creation will fail. Once the size is
 * selected, application can get the supported FPS ranges by
 * {@link #getHighSpeedVideoFpsRangesFor}, and use these FPS ranges to setup the recording
 * request lists via
 * {@link android.hardware.camera2.CameraConstrainedHighSpeedCaptureSession#createHighSpeedRequestList}.
 * </p>
 *
 * @return an array of supported high speed video recording sizes
 * @see #getHighSpeedVideoFpsRangesFor(Size)
 * @see android.hardware.camera2.CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_CONSTRAINED_HIGH_SPEED_VIDEO
 * @see android.hardware.camera2.CameraDevice#createConstrainedHighSpeedCaptureSession
 * @see android.hardware.camera2.CameraConstrainedHighSpeedCaptureSession#createHighSpeedRequestList
 * @apiSince 21
 */

public android.util.Size[] getHighSpeedVideoSizes() { throw new RuntimeException("Stub!"); }

/**
 * Get the frame per second ranges (fpsMin, fpsMax) for input high speed video size.
 * <p>
 * See {@link #getHighSpeedVideoFpsRanges} for how to enable high speed recording.
 * </p>
 * <p>
 * The {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_TARGET_FPS_RANGE CaptureRequest#CONTROL_AE_TARGET_FPS_RANGE} reported in this method
 * must not be used to setup capture requests that are submitted to unconstrained capture
 * sessions, or it will result in {@link java.lang.IllegalArgumentException IllegalArgumentException}.
 * </p>
 * <p>
 * See {@link #getHighSpeedVideoFpsRanges} for the characteristics of the returned FPS ranges.
 * </p>
 *
 * @param size one of the sizes returned by {@link #getHighSpeedVideoSizes()}
 * @return an array of supported high speed video recording FPS ranges The upper bound of
 *         returned ranges is guaranteed to be greater than or equal to 120.
 * @throws java.lang.IllegalArgumentException if input size does not exist in the return value of
 *             getHighSpeedVideoSizes
 * @see #getHighSpeedVideoSizes()
 * @see #getHighSpeedVideoFpsRanges()
 * @apiSince 21
 */

public android.util.Range<java.lang.Integer>[] getHighSpeedVideoFpsRangesFor(android.util.Size size) { throw new RuntimeException("Stub!"); }

/**
 * Get a list of supported high speed video recording FPS ranges.
 * <p>
 * When {@link android.hardware.camera2.CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_CONSTRAINED_HIGH_SPEED_VIDEO CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_CONSTRAINED_HIGH_SPEED_VIDEO} is
 * supported in {@link android.hardware.camera2.CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES}, this method will
 * list the supported high speed video FPS range configurations. Application can then use
 * {@link #getHighSpeedVideoSizesFor} to query available sizes for one of returned FPS range.
 * </p>
 * <p>
 * To enable high speed video recording, application must create a constrained create high speed
 * capture session via {@link android.hardware.camera2.CameraDevice#createConstrainedHighSpeedCaptureSession CameraDevice#createConstrainedHighSpeedCaptureSession}, and submit
 * a CaptureRequest list created by
 * {@link android.hardware.camera2.CameraConstrainedHighSpeedCaptureSession#createHighSpeedRequestList}
 * to this session. The application must select the video size from this method and
 * {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_TARGET_FPS_RANGE CaptureRequest#CONTROL_AE_TARGET_FPS_RANGE} from
 * {@link #getHighSpeedVideoFpsRangesFor} to configure the constrained high speed session and
 * generate the high speed request list. For example, if the application intends to do high
 * speed recording, it can select one FPS range reported by this method, query the video sizes
 * corresponding to this FPS range by {@link #getHighSpeedVideoSizesFor} and use one of reported
 * sizes to create a high speed capture session. Note that for the use case of multiple output
 * streams, application must select one unique size from this method to use (e.g., preview and
 * recording streams must have the same size). Otherwise, the high speed session creation will
 * fail. Once the high speed capture session is created, the application can set the FPS range
 * in the recording request lists via
 * {@link android.hardware.camera2.CameraConstrainedHighSpeedCaptureSession#createHighSpeedRequestList}.
 * </p>
 * <p>
 * The FPS ranges reported by this method will have below characteristics:
 * <li>The fpsMin and fpsMax will be a multiple 30fps.</li>
 * <li>The fpsMin will be no less than 30fps, the fpsMax will be no less than 120fps.</li>
 * <li>At least one range will be a fixed FPS range where fpsMin == fpsMax.</li>
 * <li>For each fixed FPS range, there will be one corresponding variable FPS range [30,
 * fps_max]. These kinds of FPS ranges are suitable for preview-only use cases where the
 * application doesn't want the camera device always produce higher frame rate than the display
 * refresh rate.</li>
 * </p>
 *
 * @return an array of supported high speed video recording FPS ranges The upper bound of
 *         returned ranges is guaranteed to be larger or equal to 120.
 * @see #getHighSpeedVideoSizesFor
 * @see android.hardware.camera2.CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_CONSTRAINED_HIGH_SPEED_VIDEO
 * @see android.hardware.camera2.CameraDevice#createConstrainedHighSpeedCaptureSession
 * @see android.hardware.camera2.CameraConstrainedHighSpeedCaptureSession#createHighSpeedRequestList
 * @apiSince 21
 */

public android.util.Range<java.lang.Integer>[] getHighSpeedVideoFpsRanges() { throw new RuntimeException("Stub!"); }

/**
 * Get the supported video sizes for an input high speed FPS range.
 *
 * <p> See {@link #getHighSpeedVideoSizes} for how to enable high speed recording.</p>
 *
 * @param fpsRange one of the FPS range returned by {@link #getHighSpeedVideoFpsRanges()}
 * @return An array of video sizes to create high speed capture sessions for high speed streaming
 *         use cases.
 *
 * @throws java.lang.IllegalArgumentException if input FPS range does not exist in the return value of
 *         getHighSpeedVideoFpsRanges
 * @see #getHighSpeedVideoFpsRanges()
 * @apiSince 21
 */

public android.util.Size[] getHighSpeedVideoSizesFor(android.util.Range<java.lang.Integer> fpsRange) { throw new RuntimeException("Stub!"); }

/**
 * Get a list of supported high resolution sizes, which cannot operate at full BURST_CAPTURE
 * rate.
 *
 * <p>This includes all output sizes that cannot meet the 20 fps frame rate requirements for the
 * {@link android.hardware.camera2.CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES_BURST_CAPTURE BURST_CAPTURE}
 * capability.  This does not include the stall duration, so for example, a JPEG or RAW16 output
 * resolution with a large stall duration but a minimum frame duration that's above 20 fps will
 * still be listed in the regular {@link #getOutputSizes} list. All the sizes on this list that
 * are less than 24 megapixels are still guaranteed to operate at a rate of at least 10 fps,
 * not including stall duration. Sizes on this list that are at least 24 megapixels are allowed
 * to operate at less than 10 fps.</p>
 *
 * <p>For a device that does not support the BURST_CAPTURE capability, this list will be
 * {@code null}, since resolutions in the {@link #getOutputSizes} list are already not
 * guaranteed to meet &gt;= 20 fps rate requirements. For a device that does support the
 * BURST_CAPTURE capability, this list may be empty, if all supported resolutions meet the 20
 * fps requirement.</p>
 *
 * @return an array of supported slower high-resolution sizes, or {@code null} if the
 *         BURST_CAPTURE capability is not supported
 * @apiSince 23
 */

public android.util.Size[] getHighResolutionOutputSizes(int format) { throw new RuntimeException("Stub!"); }

/**
 * Get the minimum {@link android.hardware.camera2.CaptureRequest#SENSOR_FRAME_DURATION CaptureRequest#SENSOR_FRAME_DURATION}
 * for the format/size combination (in nanoseconds).
 *
 * <p>{@code format} should be one of the ones returned by {@link #getOutputFormats()}.</p>
 * <p>{@code size} should be one of the ones returned by
 * {@link #getOutputSizes(int)}.</p>
 *
 * <p>This should correspond to the frame duration when only that stream is active, with all
 * processing (typically in {@code android.*.mode}) set to either {@code OFF} or {@code FAST}.
 * </p>
 *
 * <p>When multiple streams are used in a request, the minimum frame duration will be
 * {@code max(individual stream min durations)}.</p>
 *
 * <p>For devices that do not support manual sensor control
 * ({@link android.hardware.camera2.CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_MANUAL_SENSOR}),
 * this function may return 0.</p>
 *
 * <!--
 * TODO: uncomment after adding input stream support
 * <p>The minimum frame duration of a stream (of a particular format, size) is the same
 * regardless of whether the stream is input or output.</p>
 * -->
 *
 * @param format an image format from {@link android.graphics.ImageFormat ImageFormat} or {@link android.graphics.PixelFormat PixelFormat}
 * @param size an output-compatible size
 * @return a minimum frame duration {@code >} 0 in nanoseconds, or
 *          0 if the minimum frame duration is not available.
 *
 * @throws java.lang.IllegalArgumentException if {@code format} or {@code size} was not supported
 * @throws java.lang.NullPointerException if {@code size} was {@code null}
 *
 * @see android.hardware.camera2.CaptureRequest#SENSOR_FRAME_DURATION
 * @see #getOutputStallDuration(int, Size)
 * @see android.graphics.ImageFormat
 * @see android.graphics.PixelFormat
 * @apiSince 21
 */

public long getOutputMinFrameDuration(int format, android.util.Size size) { throw new RuntimeException("Stub!"); }

/**
 * Get the minimum {@link android.hardware.camera2.CaptureRequest#SENSOR_FRAME_DURATION CaptureRequest#SENSOR_FRAME_DURATION}
 * for the class/size combination (in nanoseconds).
 *
 * <p>This assumes that the {@code klass} is set up to use {@link android.graphics.ImageFormat#PRIVATE ImageFormat#PRIVATE}.
 * For user-defined formats, use {@link #getOutputMinFrameDuration(int,android.util.Size)}.</p>
 *
 * <p>{@code klass} should be one of the ones which is supported by
 * {@link #isOutputSupportedFor(java.lang.Class)}.</p>
 *
 * <p>{@code size} should be one of the ones returned by
 * {@link #getOutputSizes(int)}.</p>
 *
 * <p>This should correspond to the frame duration when only that stream is active, with all
 * processing (typically in {@code android.*.mode}) set to either {@code OFF} or {@code FAST}.
 * </p>
 *
 * <p>When multiple streams are used in a request, the minimum frame duration will be
 * {@code max(individual stream min durations)}.</p>
 *
 * <p>For devices that do not support manual sensor control
 * ({@link android.hardware.camera2.CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_MANUAL_SENSOR}),
 * this function may return 0.</p>
 *
 * <!--
 * TODO: uncomment after adding input stream support
 * <p>The minimum frame duration of a stream (of a particular format, size) is the same
 * regardless of whether the stream is input or output.</p>
 * -->
 *
 * @param klass
 *          a class which is supported by {@link #isOutputSupportedFor(java.lang.Class)} and has a
 *          non-empty array returned by {@link #getOutputSizes(java.lang.Class)}
 * @param size an output-compatible size
 * @return a minimum frame duration {@code >} 0 in nanoseconds, or
 *          0 if the minimum frame duration is not available.
 *
 * @throws java.lang.IllegalArgumentException if {@code klass} or {@code size} was not supported
 * @throws java.lang.NullPointerException if {@code size} or {@code klass} was {@code null}
 *
 * @see android.hardware.camera2.CaptureRequest#SENSOR_FRAME_DURATION
 * @see android.graphics.ImageFormat
 * @see android.graphics.PixelFormat
 * @apiSince 21
 */

public <T> long getOutputMinFrameDuration(java.lang.Class<T> klass, android.util.Size size) { throw new RuntimeException("Stub!"); }

/**
 * Get the stall duration for the format/size combination (in nanoseconds).
 *
 * <p>{@code format} should be one of the ones returned by {@link #getOutputFormats()}.</p>
 * <p>{@code size} should be one of the ones returned by
 * {@link #getOutputSizes(int)}.</p>
 *
 * <p>
 * A stall duration is how much extra time would get added to the normal minimum frame duration
 * for a repeating request that has streams with non-zero stall.
 *
 * <p>For example, consider JPEG captures which have the following characteristics:
 *
 * <ul>
 * <li>JPEG streams act like processed YUV streams in requests for which they are not included;
 * in requests in which they are directly referenced, they act as JPEG streams.
 * This is because supporting a JPEG stream requires the underlying YUV data to always be ready
 * for use by a JPEG encoder, but the encoder will only be used (and impact frame duration) on
 * requests that actually reference a JPEG stream.
 * <li>The JPEG processor can run concurrently to the rest of the camera pipeline, but cannot
 * process more than 1 capture at a time.
 * </ul>
 *
 * <p>In other words, using a repeating YUV request would result in a steady frame rate
 * (let's say it's 30 FPS). If a single JPEG request is submitted periodically,
 * the frame rate will stay at 30 FPS (as long as we wait for the previous JPEG to return each
 * time). If we try to submit a repeating YUV + JPEG request, then the frame rate will drop from
 * 30 FPS.</p>
 *
 * <p>In general, submitting a new request with a non-0 stall time stream will <em>not</em> cause a
 * frame rate drop unless there are still outstanding buffers for that stream from previous
 * requests.</p>
 *
 * <p>Submitting a repeating request with streams (call this {@code S}) is the same as setting
 * the minimum frame duration from the normal minimum frame duration corresponding to {@code S},
 * added with the maximum stall duration for {@code S}.</p>
 *
 * <p>If interleaving requests with and without a stall duration, a request will stall by the
 * maximum of the remaining times for each can-stall stream with outstanding buffers.</p>
 *
 * <p>This means that a stalling request will not have an exposure start until the stall has
 * completed.</p>
 *
 * <p>This should correspond to the stall duration when only that stream is active, with all
 * processing (typically in {@code android.*.mode}) set to {@code FAST} or {@code OFF}.
 * Setting any of the processing modes to {@code HIGH_QUALITY} effectively results in an
 * indeterminate stall duration for all streams in a request (the regular stall calculation
 * rules are ignored).</p>
 *
 * <p>The following formats may always have a stall duration:
 * <ul>
 * <li>{@link android.graphics.ImageFormat#JPEG ImageFormat#JPEG}
 * <li>{@link android.graphics.ImageFormat#RAW_SENSOR ImageFormat#RAW_SENSOR}
 * <li>{@link android.graphics.ImageFormat#RAW_PRIVATE ImageFormat#RAW_PRIVATE}
 * </ul>
 * </p>
 *
 * <p>The following formats will never have a stall duration:
 * <ul>
 * <li>{@link android.graphics.ImageFormat#YUV_420_888 ImageFormat#YUV_420_888}
 * <li>{@link #isOutputSupportedFor(java.lang.Class) Implementation-Defined}
 * </ul></p>
 *
 * <p>
 * All other formats may or may not have an allowed stall duration on a per-capability basis;
 * refer to {@link android.hardware.camera2.CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES} for more details.</p>
 * </p>
 *
 * <p>See {@link android.hardware.camera2.CaptureRequest#SENSOR_FRAME_DURATION CaptureRequest#SENSOR_FRAME_DURATION}
 * for more information about calculating the max frame rate (absent stalls).</p>
 *
 * @param format an image format from {@link android.graphics.ImageFormat ImageFormat} or {@link android.graphics.PixelFormat PixelFormat}
 * @param size an output-compatible size
 * @return a stall duration {@code >=} 0 in nanoseconds
 *
 * @throws java.lang.IllegalArgumentException if {@code format} or {@code size} was not supported
 * @throws java.lang.NullPointerException if {@code size} was {@code null}
 *
 * @see android.hardware.camera2.CaptureRequest#SENSOR_FRAME_DURATION
 * @see android.graphics.ImageFormat
 * @see android.graphics.PixelFormat
 * @apiSince 21
 */

public long getOutputStallDuration(int format, android.util.Size size) { throw new RuntimeException("Stub!"); }

/**
 * Get the stall duration for the class/size combination (in nanoseconds).
 *
 * <p>This assumes that the {@code klass} is set up to use {@link android.graphics.ImageFormat#PRIVATE ImageFormat#PRIVATE}.
 * For user-defined formats, use {@link #getOutputMinFrameDuration(int,android.util.Size)}.</p>
 *
 * <p>{@code klass} should be one of the ones with a non-empty array returned by
 * {@link #getOutputSizes(java.lang.Class)}.</p>
 *
 * <p>{@code size} should be one of the ones returned by
 * {@link #getOutputSizes(java.lang.Class)}.</p>
 *
 * <p>See {@link #getOutputStallDuration(int,android.util.Size)} for a definition of a
 * <em>stall duration</em>.</p>
 *
 * @param klass
 *          a class which is supported by {@link #isOutputSupportedFor(java.lang.Class)} and has a
 *          non-empty array returned by {@link #getOutputSizes(java.lang.Class)}
 * @param size an output-compatible size
 * @return a minimum frame duration {@code >=} 0 in nanoseconds
 *
 * @throws java.lang.IllegalArgumentException if {@code klass} or {@code size} was not supported
 * @throws java.lang.NullPointerException if {@code size} or {@code klass} was {@code null}
 *
 * @see android.hardware.camera2.CaptureRequest#SENSOR_FRAME_DURATION
 * @see android.graphics.ImageFormat
 * @see android.graphics.PixelFormat
 * @apiSince 21
 */

public <T> long getOutputStallDuration(java.lang.Class<T> klass, android.util.Size size) { throw new RuntimeException("Stub!"); }

/**
 * Check if this {@link android.hardware.camera2.params.StreamConfigurationMap StreamConfigurationMap} is equal to another
 * {@link android.hardware.camera2.params.StreamConfigurationMap StreamConfigurationMap}.
 *
 * <p>Two vectors are only equal if and only if each of the respective elements is equal.</p>
 *
 * @return {@code true} if the objects were equal, {@code false} otherwise
 * @apiSince 21
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 21
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Return this {@link android.hardware.camera2.params.StreamConfigurationMap StreamConfigurationMap} as a string representation.
 *
 * <p>{@code "StreamConfigurationMap(Outputs([w:%d, h:%d, format:%s(%d), min_duration:%d,
 * stall:%d], ... [w:%d, h:%d, format:%s(%d), min_duration:%d, stall:%d]), Inputs([w:%d, h:%d,
 * format:%s(%d)], ... [w:%d, h:%d, format:%s(%d)]), ValidOutputFormatsForInput(
 * [in:%d, out:%d, ... %d], ... [in:%d, out:%d, ... %d]), HighSpeedVideoConfigurations(
 * [w:%d, h:%d, min_fps:%d, max_fps:%d], ... [w:%d, h:%d, min_fps:%d, max_fps:%d]))"}.</p>
 *
 * <p>{@code Outputs([w:%d, h:%d, format:%s(%d), min_duration:%d, stall:%d], ...
 * [w:%d, h:%d, format:%s(%d), min_duration:%d, stall:%d])}, where
 * {@code [w:%d, h:%d, format:%s(%d), min_duration:%d, stall:%d]} represents an output
 * configuration's width, height, format, minimal frame duration in nanoseconds, and stall
 * duration in nanoseconds.</p>
 *
 * <p>{@code Inputs([w:%d, h:%d, format:%s(%d)], ... [w:%d, h:%d, format:%s(%d)])}, where
 * {@code [w:%d, h:%d, format:%s(%d)]} represents an input configuration's width, height, and
 * format.</p>
 *
 * <p>{@code ValidOutputFormatsForInput([in:%s(%d), out:%s(%d), ... %s(%d)],
 * ... [in:%s(%d), out:%s(%d), ... %s(%d)])}, where {@code [in:%s(%d), out:%s(%d), ... %s(%d)]}
 * represents an input fomat and its valid output formats.</p>
 *
 * <p>{@code HighSpeedVideoConfigurations([w:%d, h:%d, min_fps:%d, max_fps:%d],
 * ... [w:%d, h:%d, min_fps:%d, max_fps:%d])}, where
 * {@code [w:%d, h:%d, min_fps:%d, max_fps:%d]} represents a high speed video output
 * configuration's width, height, minimal frame rate, and maximal frame rate.</p>
 *
 * @return string representation of {@link android.hardware.camera2.params.StreamConfigurationMap StreamConfigurationMap}
 * @apiSince 21
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

