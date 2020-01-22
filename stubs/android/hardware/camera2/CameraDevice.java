/*
 * Copyright (C) 2013 The Android Open Source Project
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


package android.hardware.camera2;

import java.util.Set;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.view.Surface;
import android.hardware.camera2.params.OutputConfiguration;
import android.os.Handler;
import java.util.List;
import android.hardware.camera2.params.SessionConfiguration;

/**
 * <p>The CameraDevice class is a representation of a single camera connected to an
 * Android device, allowing for fine-grain control of image capture and
 * post-processing at high frame rates.</p>
 *
 * <p>Your application must declare the
 * {@link android.Manifest.permission#CAMERA Camera} permission in its manifest
 * in order to access camera devices.</p>
 *
 * <p>A given camera device may provide support at one of several levels defined
 * in {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL}.
 * If a device supports {@link android.hardware.camera2.CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY} level,
 * the camera device is running in backward compatibility mode and has minimum camera2 API support.
 * If a device supports the {@link android.hardware.camera2.CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED}
 * level, then Camera2 exposes a feature set that is roughly equivalent to the older
 * {@link android.hardware.Camera Camera} API, although with a cleaner and more
 * efficient interface.
 * If a device supports the {@link android.hardware.camera2.CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_EXTERNAL CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_EXTERNAL}
 * level, then the device is a removable camera that provides similar but slightly less features
 * as the {@link android.hardware.camera2.CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED} level.
 * Devices that implement the {@link android.hardware.camera2.CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_FULL} or
 * {@link android.hardware.camera2.CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_3 CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_3} level of support
 * provide substantially improved capabilities over the older camera
 * API. If your application requires a full-level device for
 * proper operation, declare the "android.hardware.camera.level.full" feature in your
 * manifest.</p>
 *
 * @see CameraManager#openCamera
 * @see android.Manifest.permission#CAMERA
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class CameraDevice implements java.lang.AutoCloseable {

CameraDevice() { throw new RuntimeException("Stub!"); }

/**
 * Get the ID of this camera device.
 *
 * <p>This matches the ID given to {@link android.hardware.camera2.CameraManager#openCamera CameraManager#openCamera} to instantiate this
 * this camera device.</p>
 *
 * <p>This ID can be used to query the camera device's {@link android.hardware.camera2.CameraCharacteristics CameraCharacteristics} with {@link android.hardware.camera2.CameraManager#getCameraCharacteristics CameraManager#getCameraCharacteristics}.</p>
 *
 * <p>This method can be called even if the device has been closed or has encountered
 * a serious error.</p>
 *
 * @return the ID for this camera device
 *
 * This value will never be {@code null}.
 * @see android.hardware.camera2.CameraManager#getCameraCharacteristics
 * @see android.hardware.camera2.CameraManager#getCameraIdList
 * @apiSince 21
 */

@androidx.annotation.NonNull
public abstract java.lang.String getId();

/**
 * <p>Create a new camera capture session by providing the target output set of Surfaces to the
 * camera device.</p>
 *
 * <p>The active capture session determines the set of potential output Surfaces for
 * the camera device for each capture request. A given request may use all
 * or only some of the outputs. Once the CameraCaptureSession is created, requests can be
 * submitted with {@link android.hardware.camera2.CameraCaptureSession#capture CameraCaptureSession#capture},
 * {@link android.hardware.camera2.CameraCaptureSession#captureBurst CameraCaptureSession#captureBurst},
 * {@link android.hardware.camera2.CameraCaptureSession#setRepeatingRequest CameraCaptureSession#setRepeatingRequest}, or
 * {@link android.hardware.camera2.CameraCaptureSession#setRepeatingBurst CameraCaptureSession#setRepeatingBurst}.</p>
 *
 * <p>Surfaces suitable for inclusion as a camera output can be created for
 * various use cases and targets:</p>
 *
 * <ul>
 *
 * <li>For drawing to a {@link android.view.SurfaceView SurfaceView}: Once the SurfaceView's
 *   Surface is {@link android.view.SurfaceHolder.Callback#surfaceCreated created}, set the size
 *   of the Surface with {@link android.view.SurfaceHolder#setFixedSize} to be one of the sizes
 *   returned by {@link android.hardware.camera2.params.StreamConfigurationMap#getOutputSizes(java.lang.Class) StreamConfigurationMap#getOutputSizes(Class)} and then obtain the Surface by calling {@link
 *   android.view.SurfaceHolder#getSurface}. If the size is not set by the application, it will
 *   be rounded to the nearest supported size less than 1080p, by the camera device.</li>
 *
 * <li>For accessing through an OpenGL texture via a {@link android.graphics.SurfaceTexture
 *   SurfaceTexture}: Set the size of the SurfaceTexture with {@link
 *   android.graphics.SurfaceTexture#setDefaultBufferSize} to be one of the sizes returned by
 *   {@link android.hardware.camera2.params.StreamConfigurationMap#getOutputSizes(java.lang.Class) StreamConfigurationMap#getOutputSizes(Class)}
 *   before creating a Surface from the SurfaceTexture with {@link android.view.Surface#Surface Surface#Surface}. If the size
 *   is not set by the application, it will be set to be the smallest supported size less than
 *   1080p, by the camera device.</li>
 *
 * <li>For recording with {@link android.media.MediaCodec}: Call
 *   {@link android.media.MediaCodec#createInputSurface} after configuring
 *   the media codec to use one of the sizes returned by
 *   {@link android.hardware.camera2.params.StreamConfigurationMap#getOutputSizes(java.lang.Class) StreamConfigurationMap#getOutputSizes(Class)}
 *   </li>
 *
 * <li>For recording with {@link android.media.MediaRecorder}: Call
 *   {@link android.media.MediaRecorder#getSurface} after configuring the media recorder to use
 *   one of the sizes returned by
 *   {@link android.hardware.camera2.params.StreamConfigurationMap#getOutputSizes(java.lang.Class) StreamConfigurationMap#getOutputSizes(Class)},
 *   or configuring it to use one of the supported
 *   {@link android.media.CamcorderProfile CamcorderProfiles}.</li>
 *
 * <li>For efficient YUV processing with {@link android.renderscript}:
 *   Create a RenderScript
 *   {@link android.renderscript.Allocation Allocation} with a supported YUV
 *   type, the IO_INPUT flag, and one of the sizes returned by
 *   {@link android.hardware.camera2.params.StreamConfigurationMap#getOutputSizes(java.lang.Class) StreamConfigurationMap#getOutputSizes(Class)},
 *   Then obtain the Surface with
 *   {@link android.renderscript.Allocation#getSurface}.</li>
 *
 * <li>For access to RAW, uncompressed YUV, or compressed JPEG data in the application: Create an
 *   {@link android.media.ImageReader} object with one of the supported output formats given by
 *   {@link android.hardware.camera2.params.StreamConfigurationMap#getOutputFormats() StreamConfigurationMap#getOutputFormats()}, setting its size to one of the
 *   corresponding supported sizes by passing the chosen output format into
 *   {@link android.hardware.camera2.params.StreamConfigurationMap#getOutputSizes(int) StreamConfigurationMap#getOutputSizes(int)}. Then obtain a
 *   {@link android.view.Surface} from it with {@link android.media.ImageReader#getSurface()}.
 *   If the ImageReader size is not set to a supported size, it will be rounded to a supported
 *   size less than 1080p by the camera device.
 *   </li>
 *
 * </ul>
 *
 * <p>The camera device will query each Surface's size and formats upon this
 * call, so they must be set to a valid setting at this time.</p>
 *
 * <p>It can take several hundred milliseconds for the session's configuration to complete,
 * since camera hardware may need to be powered on or reconfigured. Once the configuration is
 * complete and the session is ready to actually capture data, the provided
 * {@link android.hardware.camera2.CameraCaptureSession.StateCallback CameraCaptureSession.StateCallback}'s
 * {@link android.hardware.camera2.CameraCaptureSession.StateCallback#onConfigured CameraCaptureSession.StateCallback#onConfigured} callback will be called.</p>
 *
 * <p>If a prior CameraCaptureSession already exists when this method is called, the previous
 * session will no longer be able to accept new capture requests and will be closed. Any
 * in-progress capture requests made on the prior session will be completed before it's closed.
 * {@link android.hardware.camera2.CameraCaptureSession.StateCallback#onConfigured CameraCaptureSession.StateCallback#onConfigured} for the new session may be invoked
 * before {@link android.hardware.camera2.CameraCaptureSession.StateCallback#onClosed CameraCaptureSession.StateCallback#onClosed} is invoked for the prior
 * session. Once the new session is {@link android.hardware.camera2.CameraCaptureSession.StateCallback#onConfigured CameraCaptureSession.StateCallback#onConfigured}, it is able to start capturing its own requests. To minimize the transition time,
 * the {@link android.hardware.camera2.CameraCaptureSession#abortCaptures CameraCaptureSession#abortCaptures} call can be used to discard the remaining
 * requests for the prior capture session before a new one is created. Note that once the new
 * session is created, the old one can no longer have its captures aborted.</p>
 *
 * <p>Using larger resolution outputs, or more outputs, can result in slower
 * output rate from the device.</p>
 *
 * <p>Configuring a session with an empty or null list will close the current session, if
 * any. This can be used to release the current session's target surfaces for another use.</p>
 *
 * <p>While any of the sizes from {@link android.hardware.camera2.params.StreamConfigurationMap#getOutputSizes StreamConfigurationMap#getOutputSizes} can be used when
 * a single output stream is configured, a given camera device may not be able to support all
 * combination of sizes, formats, and targets when multiple outputs are configured at once.  The
 * tables below list the maximum guaranteed resolutions for combinations of streams and targets,
 * given the capabilities of the camera device.</p>
 *
 * <p>If an application tries to create a session using a set of targets that exceed the limits
 * described in the below tables, one of three possibilities may occur. First, the session may
 * be successfully created and work normally. Second, the session may be successfully created,
 * but the camera device won't meet the frame rate guarantees as described in
 * {@link android.hardware.camera2.params.StreamConfigurationMap#getOutputMinFrameDuration StreamConfigurationMap#getOutputMinFrameDuration}. Or third, if the output set
 * cannot be used at all, session creation will fail entirely, with
 * {@link android.hardware.camera2.CameraCaptureSession.StateCallback#onConfigureFailed CameraCaptureSession.StateCallback#onConfigureFailed} being invoked.</p>
 *
 * <p>For the type column, {@code PRIV} refers to any target whose available sizes are found
 * using {@link android.hardware.camera2.params.StreamConfigurationMap#getOutputSizes(java.lang.Class) StreamConfigurationMap#getOutputSizes(Class)} with no direct application-visible
 * format, {@code YUV} refers to a target Surface using the
 * {@link android.graphics.ImageFormat#YUV_420_888} format, {@code JPEG} refers to the
 * {@link android.graphics.ImageFormat#JPEG} format, and {@code RAW} refers to the
 * {@link android.graphics.ImageFormat#RAW_SENSOR} format.</p>
 *
 * <p>For the maximum size column, {@code PREVIEW} refers to the best size match to the
 * device's screen resolution, or to 1080p ({@code 1920x1080}), whichever is
 * smaller. {@code RECORD} refers to the camera device's maximum supported recording resolution,
 * as determined by {@link android.media.CamcorderProfile}. And {@code MAXIMUM} refers to the
 * camera device's maximum output resolution for that format or target from
 * {@link android.hardware.camera2.params.StreamConfigurationMap#getOutputSizes StreamConfigurationMap#getOutputSizes}.</p>
 *
 * <p>To use these tables, determine the number and the formats/targets of outputs needed, and
 * find the row(s) of the table with those targets. The sizes indicate the maximum set of sizes
 * that can be used; it is guaranteed that for those targets, the listed sizes and anything
 * smaller from the list given by {@link android.hardware.camera2.params.StreamConfigurationMap#getOutputSizes StreamConfigurationMap#getOutputSizes} can be
 * successfully used to create a session.  For example, if a row indicates that a 8 megapixel
 * (MP) YUV_420_888 output can be used together with a 2 MP {@code PRIV} output, then a session
 * can be created with targets {@code [8 MP YUV, 2 MP PRIV]} or targets {@code [2 MP YUV, 2 MP
 * PRIV]}; but a session with targets {@code [8 MP YUV, 4 MP PRIV]}, targets {@code [4 MP YUV, 4
 * MP PRIV]}, or targets {@code [8 MP PRIV, 2 MP YUV]} would not be guaranteed to work, unless
 * some other row of the table lists such a combination.</p>
 *
 * <style scoped>
 *  #rb { border-right-width: thick; }
 * </style>
 * <p>Legacy devices ({@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL}
 * {@code == }{@link android.hardware.camera2.CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY}) support at
 * least the following stream combinations:
 *
 * <table>
 * <tr><th colspan="7">LEGACY-level guaranteed configurations</th></tr>
 * <tr> <th colspan="2" id="rb">Target 1</th> <th colspan="2" id="rb">Target 2</th>  <th colspan="2" id="rb">Target 3</th> <th rowspan="2">Sample use case(s)</th> </tr>
 * <tr> <th>Type</th><th id="rb">Max size</th> <th>Type</th><th id="rb">Max size</th> <th>Type</th><th id="rb">Max size</th></tr>
 * <tr> <td>{@code PRIV}</td><td id="rb">{@code MAXIMUM}</td> <td colspan="2" id="rb"></td> <td colspan="2" id="rb"></td> <td>Simple preview, GPU video processing, or no-preview video recording.</td> </tr>
 * <tr> <td>{@code JPEG}</td><td id="rb">{@code MAXIMUM}</td> <td colspan="2" id="rb"></td> <td colspan="2" id="rb"></td> <td>No-viewfinder still image capture.</td> </tr>
 * <tr> <td>{@code YUV }</td><td id="rb">{@code MAXIMUM}</td> <td colspan="2" id="rb"></td> <td colspan="2" id="rb"></td> <td>In-application video/image processing.</td> </tr>
 * <tr> <td>{@code PRIV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code JPEG}</td><td id="rb">{@code MAXIMUM}</td> <td colspan="2" id="rb"></td> <td>Standard still imaging.</td> </tr>
 * <tr> <td>{@code YUV }</td><td id="rb">{@code PREVIEW}</td> <td>{@code JPEG}</td><td id="rb">{@code MAXIMUM}</td> <td colspan="2" id="rb"></td> <td>In-app processing plus still capture.</td> </tr>
 * <tr> <td>{@code PRIV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code PRIV}</td><td id="rb">{@code PREVIEW}</td> <td colspan="2" id="rb"></td> <td>Standard recording.</td> </tr>
 * <tr> <td>{@code PRIV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code YUV }</td><td id="rb">{@code PREVIEW}</td> <td colspan="2" id="rb"></td> <td>Preview plus in-app processing.</td> </tr>
 * <tr> <td>{@code PRIV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code YUV }</td><td id="rb">{@code PREVIEW}</td> <td>{@code JPEG}</td><td id="rb">{@code MAXIMUM}</td> <td>Still capture plus in-app processing.</td> </tr>
 * </table><br>
 * </p>
 *
 * <p>Limited-level ({@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL}
 * {@code == }{@link android.hardware.camera2.CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED}) devices
 * support at least the following stream combinations in addition to those for
 * {@link android.hardware.camera2.CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY} devices:
 *
 * <table>
 * <tr><th colspan="7">LIMITED-level additional guaranteed configurations</th></tr>
 * <tr><th colspan="2" id="rb">Target 1</th><th colspan="2" id="rb">Target 2</th><th colspan="2" id="rb">Target 3</th> <th rowspan="2">Sample use case(s)</th> </tr>
 * <tr><th>Type</th><th id="rb">Max size</th><th>Type</th><th id="rb">Max size</th><th>Type</th><th id="rb">Max size</th></tr>
 * <tr> <td>{@code PRIV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code PRIV}</td><td id="rb">{@code RECORD }</td> <td colspan="2" id="rb"></td> <td>High-resolution video recording with preview.</td> </tr>
 * <tr> <td>{@code PRIV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code YUV }</td><td id="rb">{@code RECORD }</td> <td colspan="2" id="rb"></td> <td>High-resolution in-app video processing with preview.</td> </tr>
 * <tr> <td>{@code YUV }</td><td id="rb">{@code PREVIEW}</td> <td>{@code YUV }</td><td id="rb">{@code RECORD }</td> <td colspan="2" id="rb"></td> <td>Two-input in-app video processing.</td> </tr>
 * <tr> <td>{@code PRIV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code PRIV}</td><td id="rb">{@code RECORD }</td> <td>{@code JPEG}</td><td id="rb">{@code RECORD }</td> <td>High-resolution recording with video snapshot.</td> </tr>
 * <tr> <td>{@code PRIV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code YUV }</td><td id="rb">{@code RECORD }</td> <td>{@code JPEG}</td><td id="rb">{@code RECORD }</td> <td>High-resolution in-app processing with video snapshot.</td> </tr>
 * <tr> <td>{@code YUV }</td><td id="rb">{@code PREVIEW}</td> <td>{@code YUV }</td><td id="rb">{@code PREVIEW}</td> <td>{@code JPEG}</td><td id="rb">{@code MAXIMUM}</td> <td>Two-input in-app processing with still capture.</td> </tr>
 * </table><br>
 * </p>
 *
 * <p>FULL-level ({@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL}
 * {@code == }{@link android.hardware.camera2.CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_FULL}) devices
 * support at least the following stream combinations in addition to those for
 * {@link android.hardware.camera2.CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED} devices:
 *
 * <table>
 * <tr><th colspan="7">FULL-level additional guaranteed configurations</th></tr>
 * <tr><th colspan="2" id="rb">Target 1</th><th colspan="2" id="rb">Target 2</th><th colspan="2" id="rb">Target 3</th> <th rowspan="2">Sample use case(s)</th> </tr>
 * <tr><th>Type</th><th id="rb">Max size</th><th>Type</th><th id="rb">Max size</th><th>Type</th><th id="rb">Max size</th> </tr>
 * <tr> <td>{@code PRIV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code PRIV}</td><td id="rb">{@code MAXIMUM}</td> <td colspan="2" id="rb"></td> <td>Maximum-resolution GPU processing with preview.</td> </tr>
 * <tr> <td>{@code PRIV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code YUV }</td><td id="rb">{@code MAXIMUM}</td> <td colspan="2" id="rb"></td> <td>Maximum-resolution in-app processing with preview.</td> </tr>
 * <tr> <td>{@code YUV }</td><td id="rb">{@code PREVIEW}</td> <td>{@code YUV }</td><td id="rb">{@code MAXIMUM}</td> <td colspan="2" id="rb"></td> <td>Maximum-resolution two-input in-app processsing.</td> </tr>
 * <tr> <td>{@code PRIV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code PRIV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code JPEG}</td><td id="rb">{@code MAXIMUM}</td> <td>Video recording with maximum-size video snapshot</td> </tr>
 * <tr> <td>{@code YUV }</td><td id="rb">{@code 640x480}</td> <td>{@code PRIV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code YUV }</td><td id="rb">{@code MAXIMUM}</td> <td>Standard video recording plus maximum-resolution in-app processing.</td> </tr>
 * <tr> <td>{@code YUV }</td><td id="rb">{@code 640x480}</td> <td>{@code YUV }</td><td id="rb">{@code PREVIEW}</td> <td>{@code YUV }</td><td id="rb">{@code MAXIMUM}</td> <td>Preview plus two-input maximum-resolution in-app processing.</td> </tr>
 * </table><br>
 * </p>
 *
 * <p>RAW-capability ({@link android.hardware.camera2.CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES} includes
 * {@link android.hardware.camera2.CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_RAW CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_RAW}) devices additionally support
 * at least the following stream combinations on both
 * {@link android.hardware.camera2.CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_FULL} and
 * {@link android.hardware.camera2.CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED} devices:
 *
 * <table>
 * <tr><th colspan="7">RAW-capability additional guaranteed configurations</th></tr>
 * <tr><th colspan="2" id="rb">Target 1</th><th colspan="2" id="rb">Target 2</th><th colspan="2" id="rb">Target 3</th> <th rowspan="2">Sample use case(s)</th> </tr>
 * <tr><th>Type</th><th id="rb">Max size</th><th>Type</th><th id="rb">Max size</th><th>Type</th><th id="rb">Max size</th> </tr>
 * <tr> <td>{@code RAW }</td><td id="rb">{@code MAXIMUM}</td> <td colspan="2" id="rb"></td> <td colspan="2" id="rb"></td> <td>No-preview DNG capture.</td> </tr>
 * <tr> <td>{@code PRIV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code RAW }</td><td id="rb">{@code MAXIMUM}</td> <td colspan="2" id="rb"></td> <td>Standard DNG capture.</td> </tr>
 * <tr> <td>{@code YUV }</td><td id="rb">{@code PREVIEW}</td> <td>{@code RAW }</td><td id="rb">{@code MAXIMUM}</td> <td colspan="2" id="rb"></td> <td>In-app processing plus DNG capture.</td> </tr>
 * <tr> <td>{@code PRIV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code PRIV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code RAW }</td><td id="rb">{@code MAXIMUM}</td> <td>Video recording with DNG capture.</td> </tr>
 * <tr> <td>{@code PRIV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code YUV }</td><td id="rb">{@code PREVIEW}</td> <td>{@code RAW }</td><td id="rb">{@code MAXIMUM}</td> <td>Preview with in-app processing and DNG capture.</td> </tr>
 * <tr> <td>{@code YUV }</td><td id="rb">{@code PREVIEW}</td> <td>{@code YUV }</td><td id="rb">{@code PREVIEW}</td> <td>{@code RAW }</td><td id="rb">{@code MAXIMUM}</td> <td>Two-input in-app processing plus DNG capture.</td> </tr>
 * <tr> <td>{@code PRIV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code JPEG}</td><td id="rb">{@code MAXIMUM}</td> <td>{@code RAW }</td><td id="rb">{@code MAXIMUM}</td> <td>Still capture with simultaneous JPEG and DNG.</td> </tr>
 * <tr> <td>{@code YUV }</td><td id="rb">{@code PREVIEW}</td> <td>{@code JPEG}</td><td id="rb">{@code MAXIMUM}</td> <td>{@code RAW }</td><td id="rb">{@code MAXIMUM}</td> <td>In-app processing with simultaneous JPEG and DNG.</td> </tr>
 * </table><br>
 * </p>
 *
 * <p>BURST-capability ({@link android.hardware.camera2.CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES} includes
 * {@link android.hardware.camera2.CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_BURST_CAPTURE CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_BURST_CAPTURE}) devices
 * support at least the below stream combinations in addition to those for
 * {@link android.hardware.camera2.CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED} devices. Note that all
 * FULL-level devices support the BURST capability, and the below list is a strict subset of the
 * list for FULL-level devices, so this table is only relevant for LIMITED-level devices that
 * support the BURST_CAPTURE capability.
 *
 * <table>
 * <tr><th colspan="5">BURST-capability additional guaranteed configurations</th></tr>
 * <tr><th colspan="2" id="rb">Target 1</th><th colspan="2" id="rb">Target 2</th><th rowspan="2">Sample use case(s)</th> </tr>
 * <tr><th>Type</th><th id="rb">Max size</th><th>Type</th><th id="rb">Max size</th> </tr>
 * <tr> <td>{@code PRIV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code PRIV}</td><td id="rb">{@code MAXIMUM}</td> <td>Maximum-resolution GPU processing with preview.</td> </tr>
 * <tr> <td>{@code PRIV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code YUV }</td><td id="rb">{@code MAXIMUM}</td> <td>Maximum-resolution in-app processing with preview.</td> </tr>
 * <tr> <td>{@code YUV }</td><td id="rb">{@code PREVIEW}</td> <td>{@code YUV }</td><td id="rb">{@code MAXIMUM}</td> <td>Maximum-resolution two-input in-app processsing.</td> </tr>
 * </table><br>
 * </p>
 *
 * <p>LEVEL-3 ({@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL}
 * {@code == }{@link android.hardware.camera2.CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_3 CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_3})
 * support at least the following stream combinations in addition to the combinations for
 * {@link android.hardware.camera2.CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_FULL} and for
 * RAW capability ({@link android.hardware.camera2.CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES} includes
 * {@link android.hardware.camera2.CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_RAW CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_RAW}):
 *
 * <table>
 * <tr><th colspan="11">LEVEL-3 additional guaranteed configurations</th></tr>
 * <tr><th colspan="2" id="rb">Target 1</th><th colspan="2" id="rb">Target 2</th><th colspan="2" id="rb">Target 3</th><th colspan="2" id="rb">Target 4</th><th rowspan="2">Sample use case(s)</th> </tr>
 * <tr><th>Type</th><th id="rb">Max size</th><th>Type</th><th id="rb">Max size</th><th>Type</th><th id="rb">Max size</th><th>Type</th><th id="rb">Max size</th> </tr>
 * <tr> <td>{@code PRIV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code PRIV}</td><td id="rb">{@code 640x480}</td> <td>{@code YUV}</td><td id="rb">{@code MAXIMUM}</td> <td>{@code RAW}</td><td id="rb">{@code MAXIMUM}</td> <td>In-app viewfinder analysis with dynamic selection of output format.</td> </tr>
 * <tr> <td>{@code PRIV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code PRIV}</td><td id="rb">{@code 640x480}</td> <td>{@code JPEG}</td><td id="rb">{@code MAXIMUM}</td> <td>{@code RAW}</td><td id="rb">{@code MAXIMUM}</td> <td>In-app viewfinder analysis with dynamic selection of output format.</td> </tr>
 * </table><br>
 * </p>
 *
 * <p>MONOCHROME-capability ({@link android.hardware.camera2.CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES}
 * includes {@link android.hardware.camera2.CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_MONOCHROME CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_MONOCHROME}) devices
 * supporting {@link android.graphics.ImageFormat#Y8 Y8} support substituting {@code YUV}
 * streams with {@code Y8} in all guaranteed stream combinations for the device's hardware level
 * and capabilities.</p>
 *
 * <p>Devices capable of outputting HEIC formats ({@link android.hardware.camera2.params.StreamConfigurationMap#getOutputFormats StreamConfigurationMap#getOutputFormats}
 * contains {@link android.graphics.ImageFormat#HEIC}) will support substituting {@code JPEG}
 * streams with {@code HEIC} in all guaranteed stream combinations for the device's hardware
 * level and capabilities. Calling createCaptureSession with both JPEG and HEIC outputs is not
 * supported.</p>
 *
 * <p>Clients can access the above mandatory stream combination tables via
 * {@link android.hardware.camera2.params.MandatoryStreamCombination}.</p>
 *
 * <p>Since the capabilities of camera devices vary greatly, a given camera device may support
 * target combinations with sizes outside of these guarantees, but this can only be tested for
 * by calling {@link #isSessionConfigurationSupported} or attempting to create a session with
 * such targets.</p>
 *
 * <p>Exception on 176x144 (QCIF) resolution:
 * Camera devices usually have a fixed capability for downscaling from larger resolution to
 * smaller, and the QCIF resolution sometimes is not fully supported due to this
 * limitation on devices with high-resolution image sensors. Therefore, trying to configure a
 * QCIF resolution stream together with any other stream larger than 1920x1080 resolution
 * (either width or height) might not be supported, and capture session creation will fail if it
 * is not.</p>
 *
 * @param outputs The new set of Surfaces that should be made available as
 *                targets for captured image data.
 * This value must never be {@code null}.
 * @param callback The callback to notify about the status of the new capture session.
 * This value must never be {@code null}.
 * @param handler The handler on which the callback should be invoked, or {@code null} to use
 *                the current thread's {@link android.os.Looper looper}.
 *
 * This value may be {@code null}.
 * @throws java.lang.IllegalArgumentException if the set of output Surfaces do not meet the requirements,
 *                                  the callback is null, or the handler is null but the current
 *                                  thread has no looper.
 * @throws android.hardware.camera2.CameraAccessException if the camera device is no longer connected or has
 *                               encountered a fatal error
 * @throws java.lang.IllegalStateException if the camera device has been closed
 *
 * @see android.hardware.camera2.CameraCaptureSession
 * @see android.hardware.camera2.params.StreamConfigurationMap#getOutputFormats()
 * @see android.hardware.camera2.params.StreamConfigurationMap#getOutputSizes(int)
 * @see android.hardware.camera2.params.StreamConfigurationMap#getOutputSizes(Class)
 * @apiSince 21
 */

public abstract void createCaptureSession(@androidx.annotation.NonNull java.util.List<android.view.Surface> outputs, @androidx.annotation.NonNull android.hardware.camera2.CameraCaptureSession.StateCallback callback, @androidx.annotation.Nullable android.os.Handler handler) throws android.hardware.camera2.CameraAccessException;

/**
 * <p>Create a new camera capture session by providing the target output set of Surfaces and
 * its corresponding surface configuration to the camera device.</p>
 *
 * @see #createCaptureSession
 * @see android.hardware.camera2.params.OutputConfiguration
 
 * @param handler This value may be {@code null}.
 * @apiSince 24
 */

public abstract void createCaptureSessionByOutputConfigurations(java.util.List<android.hardware.camera2.params.OutputConfiguration> outputConfigurations, android.hardware.camera2.CameraCaptureSession.StateCallback callback, @androidx.annotation.Nullable android.os.Handler handler) throws android.hardware.camera2.CameraAccessException;

/**
 * Create a new reprocessable camera capture session by providing the desired reprocessing
 * input Surface configuration and the target output set of Surfaces to the camera device.
 *
 * <p>If a camera device supports YUV reprocessing
 * ({@link android.hardware.camera2.CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES_YUV_REPROCESSING CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES_YUV_REPROCESSING}) or PRIVATE
 * reprocessing
 * ({@link android.hardware.camera2.CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES_PRIVATE_REPROCESSING CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES_PRIVATE_REPROCESSING}), besides
 * the capture session created via {@link #createCaptureSession createCaptureSession}, the
 * application can also create a reprocessable capture session to submit reprocess capture
 * requests in addition to regular capture requests. A reprocess capture request takes the next
 * available buffer from the session's input Surface, and sends it through the camera device's
 * processing pipeline again, to produce buffers for the request's target output Surfaces. No
 * new image data is captured for a reprocess request. However the input buffer provided by
 * the application must be captured previously by the same camera device in the same session
 * directly (e.g. for Zero-Shutter-Lag use case) or indirectly (e.g. combining multiple output
 * images).</p>
 *
 * <p>The active reprocessable capture session determines an input {@link android.view.Surface Surface} and the set
 * of potential output Surfaces for the camera devices for each capture request. The application
 * can use {@link #createCaptureRequest createCaptureRequest} to create regular capture requests
 * to capture new images from the camera device, and use {@link #createReprocessCaptureRequest
 * createReprocessCaptureRequest} to create reprocess capture requests to process buffers from
 * the input {@link android.view.Surface Surface}. Some combinations of output Surfaces in a session may not be used
 * in a request simultaneously. The guaranteed combinations of output Surfaces that can be used
 * in a request simultaneously are listed in the tables under {@link #createCaptureSession
 * createCaptureSession}. All the output Surfaces in one capture request will come from the
 * same source, either from a new capture by the camera device, or from the input Surface
 * depending on if the request is a reprocess capture request.</p>
 *
 * <p>Input formats and sizes supported by the camera device can be queried via
 * {@link android.hardware.camera2.params.StreamConfigurationMap#getInputFormats StreamConfigurationMap#getInputFormats} and
 * {@link android.hardware.camera2.params.StreamConfigurationMap#getInputSizes StreamConfigurationMap#getInputSizes}. For each supported input format, the camera
 * device supports a set of output formats and sizes for reprocessing that can be queried via
 * {@link android.hardware.camera2.params.StreamConfigurationMap#getValidOutputFormatsForInput StreamConfigurationMap#getValidOutputFormatsForInput} and
 * {@link android.hardware.camera2.params.StreamConfigurationMap#getOutputSizes StreamConfigurationMap#getOutputSizes}. While output Surfaces with formats that
 * aren't valid reprocess output targets for the input configuration can be part of a session,
 * they cannot be used as targets for a reprocessing request.</p>
 *
 * <p>Since the application cannot access {@link android.graphics.ImageFormat#PRIVATE} images
 * directly, an output Surface created by {@link android.media.ImageReader#newInstance} with
 * {@link android.graphics.ImageFormat#PRIVATE} as the format will be considered as intended to
 * be used for reprocessing input and thus the {@link android.media.ImageReader} size must
 * match one of the supported input sizes for {@link android.graphics.ImageFormat#PRIVATE}
 * format. Otherwise, creating a reprocessable capture session will fail.</p>
 *
 * <p>The guaranteed stream configurations listed in
 * {@link #createCaptureSession createCaptureSession} are also guaranteed to work for
 * {@link #createReprocessableCaptureSession createReprocessableCaptureSession}. In addition,
 * the configurations in the tables below are also guaranteed for creating a reprocessable
 * capture session if the camera device supports YUV reprocessing or PRIVATE reprocessing.
 * However, not all output targets used to create a reprocessable session may be used in a
 * {@link android.hardware.camera2.CaptureRequest CaptureRequest} simultaneously. For devices that support only 1 output target in a
 * reprocess {@link android.hardware.camera2.CaptureRequest CaptureRequest}, submitting a reprocess {@link android.hardware.camera2.CaptureRequest CaptureRequest} with multiple
 * output targets will result in a {@link android.hardware.camera2.CaptureFailure CaptureFailure}. For devices that support multiple
 * output targets in a reprocess {@link android.hardware.camera2.CaptureRequest CaptureRequest}, the guaranteed output targets that can
 * be included in a {@link android.hardware.camera2.CaptureRequest CaptureRequest} simultaneously are listed in the tables under
 * {@link #createCaptureSession createCaptureSession}. For example, with a FULL-capability
 * ({@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} {@code == }
 * {@link android.hardware.camera2.CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_FULL}) device that supports PRIVATE
 * reprocessing, an application can create a reprocessable capture session with 1 input,
 * ({@code PRIV}, {@code MAXIMUM}), and 3 outputs, ({@code PRIV}, {@code MAXIMUM}),
 * ({@code PRIV}, {@code PREVIEW}), and ({@code YUV}, {@code MAXIMUM}). However, it's not
 * guaranteed that an application can submit a regular or reprocess capture with ({@code PRIV},
 * {@code MAXIMUM}) and ({@code YUV}, {@code MAXIMUM}) outputs based on the table listed under
 * {@link #createCaptureSession createCaptureSession}. In other words, use the tables below to
 * determine the guaranteed stream configurations for creating a reprocessable capture session,
 * and use the tables under {@link #createCaptureSession createCaptureSession} to determine the
 * guaranteed output targets that can be submitted in a regular or reprocess
 * {@link android.hardware.camera2.CaptureRequest CaptureRequest} simultaneously.</p>
 *
 * <style scoped>
 *  #rb { border-right-width: thick; }
 * </style>
 *
 * <p>LIMITED-level ({@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL}
 * {@code == }{@link android.hardware.camera2.CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED}) devices
 * support at least the following stream combinations for creating a reprocessable capture
 * session in addition to those listed in {@link #createCaptureSession createCaptureSession} for
 * {@link android.hardware.camera2.CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED} devices:
 *
 * <table>
 * <tr><th colspan="11">LIMITED-level additional guaranteed configurations for creating a reprocessable capture session<br>({@code PRIV} input is guaranteed only if PRIVATE reprocessing is supported. {@code YUV} input is guaranteed only if YUV reprocessing is supported)</th></tr>
 * <tr><th colspan="2" id="rb">Input</th><th colspan="2" id="rb">Target 1</th><th colspan="2" id="rb">Target 2</th><th colspan="2" id="rb">Target 3</th><th colspan="2" id="rb">Target 4</th><th rowspan="2">Sample use case(s)</th> </tr>
 * <tr><th>Type</th><th id="rb">Max size</th><th>Type</th><th id="rb">Max size</th><th>Type</th><th id="rb">Max size</th><th>Type</th><th id="rb">Max size</th><th>Type</th><th id="rb">Max size</th></tr>
 * <tr> <td>{@code PRIV}/{@code YUV}</td><td id="rb">{@code MAXIMUM}</td> <td>Same as input</td><td id="rb">{@code MAXIMUM}</td> <td>{@code JPEG}</td><td id="rb">{@code MAXIMUM}</td> <td></td><td id="rb"></td> <td></td><td id="rb"></td> <td>No-viewfinder still image reprocessing.</td> </tr>
 * <tr> <td>{@code PRIV}/{@code YUV}</td><td id="rb">{@code MAXIMUM}</td> <td>Same as input</td><td id="rb">{@code MAXIMUM}</td> <td>{@code PRIV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code JPEG}</td><td id="rb">{@code MAXIMUM}</td> <td></td><td id="rb"></td> <td>ZSL(Zero-Shutter-Lag) still imaging.</td> </tr>
 * <tr> <td>{@code PRIV}/{@code YUV}</td><td id="rb">{@code MAXIMUM}</td> <td>Same as input</td><td id="rb">{@code MAXIMUM}</td> <td>{@code YUV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code JPEG}</td><td id="rb">{@code MAXIMUM}</td> <td></td><td id="rb"></td> <td>ZSL still and in-app processing imaging.</td> </tr>
 * <tr> <td>{@code PRIV}/{@code YUV}</td><td id="rb">{@code MAXIMUM}</td> <td>Same as input</td><td id="rb">{@code MAXIMUM}</td> <td>{@code YUV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code YUV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code JPEG}</td><td id="rb">{@code MAXIMUM}</td> <td>ZSL in-app processing with still capture.</td> </tr>
 * </table><br>
 * </p>
 *
 * <p>FULL-level ({@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL}
 * {@code == }{@link android.hardware.camera2.CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_FULL}) devices
 * support at least the following stream combinations for creating a reprocessable capture
 * session in addition to those for
 * {@link android.hardware.camera2.CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED} devices:
 *
 * <table>
 * <tr><th colspan="11">FULL-level additional guaranteed configurations for creating a reprocessable capture session<br>({@code PRIV} input is guaranteed only if PRIVATE reprocessing is supported. {@code YUV} input is guaranteed only if YUV reprocessing is supported)</th></tr>
 * <tr><th colspan="2" id="rb">Input</th><th colspan="2" id="rb">Target 1</th><th colspan="2" id="rb">Target 2</th><th colspan="2" id="rb">Target 3</th><th colspan="2" id="rb">Target 4</th><th rowspan="2">Sample use case(s)</th> </tr>
 * <tr><th>Type</th><th id="rb">Max size</th><th>Type</th><th id="rb">Max size</th><th>Type</th><th id="rb">Max size</th><th>Type</th><th id="rb">Max size</th><th>Type</th><th id="rb">Max size</th></tr>
 * <tr> <td>{@code YUV}</td><td id="rb">{@code MAXIMUM}</td> <td>{@code YUV}</td><td id="rb">{@code MAXIMUM}</td> <td>{@code PRIV}</td><td id="rb">{@code PREVIEW}</td> <td></td><td id="rb"></td> <td></td><td id="rb"></td> <td>Maximum-resolution multi-frame image fusion in-app processing with regular preview.</td> </tr>
 * <tr> <td>{@code YUV}</td><td id="rb">{@code MAXIMUM}</td> <td>{@code YUV}</td><td id="rb">{@code MAXIMUM}</td> <td>{@code YUV}</td><td id="rb">{@code PREVIEW}</td> <td></td><td id="rb"></td> <td></td><td id="rb"></td> <td>Maximum-resolution multi-frame image fusion two-input in-app processing.</td> </tr>
 * <tr> <td>{@code PRIV}/{@code YUV}</td><td id="rb">{@code MAXIMUM}</td> <td>Same as input</td><td id="rb">{@code MAXIMUM}</td> <td>{@code PRIV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code YUV}</td><td id="rb">{@code RECORD}</td> <td></td><td id="rb"></td> <td>High-resolution ZSL in-app video processing with regular preview.</td> </tr>
 * <tr> <td>{@code PRIV}</td><td id="rb">{@code MAXIMUM}</td> <td>{@code PRIV}</td><td id="rb">{@code MAXIMUM}</td> <td>{@code PRIV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code YUV}</td><td id="rb">{@code MAXIMUM}</td> <td></td><td id="rb"></td> <td>Maximum-resolution ZSL in-app processing with regular preview.</td> </tr>
 * <tr> <td>{@code PRIV}</td><td id="rb">{@code MAXIMUM}</td> <td>{@code PRIV}</td><td id="rb">{@code MAXIMUM}</td> <td>{@code YUV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code YUV}</td><td id="rb">{@code MAXIMUM}</td> <td></td><td id="rb"></td> <td>Maximum-resolution two-input ZSL in-app processing.</td> </tr>
 * <tr> <td>{@code PRIV}/{@code YUV}</td><td id="rb">{@code MAXIMUM}</td> <td>Same as input</td><td id="rb">{@code MAXIMUM}</td> <td>{@code PRIV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code YUV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code JPEG}</td><td id="rb">{@code MAXIMUM}</td> <td>ZSL still capture and in-app processing.</td> </tr>
 * </table><br>
 * </p>
 *
 * <p>RAW-capability ({@link android.hardware.camera2.CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES} includes
 * {@link android.hardware.camera2.CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_RAW CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_RAW}) devices additionally support
 * at least the following stream combinations for creating a reprocessable capture session
 * on both {@link android.hardware.camera2.CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_FULL} and
 * {@link android.hardware.camera2.CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED} devices
 *
 * <table>
 * <tr><th colspan="11">RAW-capability additional guaranteed configurations for creating a reprocessable capture session<br>({@code PRIV} input is guaranteed only if PRIVATE reprocessing is supported. {@code YUV} input is guaranteed only if YUV reprocessing is supported)</th></tr>
 * <tr><th colspan="2" id="rb">Input</th><th colspan="2" id="rb">Target 1</th><th colspan="2" id="rb">Target 2</th><th colspan="2" id="rb">Target 3</th><th colspan="2" id="rb">Target 4</th><th rowspan="2">Sample use case(s)</th> </tr>
 * <tr><th>Type</th><th id="rb">Max size</th><th>Type</th><th id="rb">Max size</th><th>Type</th><th id="rb">Max size</th><th>Type</th><th id="rb">Max size</th><th>Type</th><th id="rb">Max size</th></tr>
 * <tr> <td>{@code PRIV}/{@code YUV}</td><td id="rb">{@code MAXIMUM}</td> <td>Same as input</td><td id="rb">{@code MAXIMUM}</td> <td>{@code YUV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code RAW}</td><td id="rb">{@code MAXIMUM}</td> <td></td><td id="rb"></td> <td>Mutually exclusive ZSL in-app processing and DNG capture.</td> </tr>
 * <tr> <td>{@code PRIV}/{@code YUV}</td><td id="rb">{@code MAXIMUM}</td> <td>Same as input</td><td id="rb">{@code MAXIMUM}</td> <td>{@code PRIV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code YUV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code RAW}</td><td id="rb">{@code MAXIMUM}</td> <td>Mutually exclusive ZSL in-app processing and preview with DNG capture.</td> </tr>
 * <tr> <td>{@code PRIV}/{@code YUV}</td><td id="rb">{@code MAXIMUM}</td> <td>Same as input</td><td id="rb">{@code MAXIMUM}</td> <td>{@code YUV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code YUV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code RAW}</td><td id="rb">{@code MAXIMUM}</td> <td>Mutually exclusive ZSL two-input in-app processing and DNG capture.</td> </tr>
 * <tr> <td>{@code PRIV}/{@code YUV}</td><td id="rb">{@code MAXIMUM}</td> <td>Same as input</td><td id="rb">{@code MAXIMUM}</td> <td>{@code PRIV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code JPEG}</td><td id="rb">{@code MAXIMUM}</td> <td>{@code RAW}</td><td id="rb">{@code MAXIMUM}</td> <td>Mutually exclusive ZSL still capture and preview with DNG capture.</td> </tr>
 * <tr> <td>{@code PRIV}/{@code YUV}</td><td id="rb">{@code MAXIMUM}</td> <td>Same as input</td><td id="rb">{@code MAXIMUM}</td> <td>{@code YUV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code JPEG}</td><td id="rb">{@code MAXIMUM}</td> <td>{@code RAW}</td><td id="rb">{@code MAXIMUM}</td> <td>Mutually exclusive ZSL in-app processing with still capture and DNG capture.</td> </tr>
 * </table><br>
 * </p>
 *
 * <p>LEVEL-3 ({@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL}
 * {@code == }{@link android.hardware.camera2.CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_3 CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_3}) devices
 * support at least the following stream combinations for creating a reprocessable capture
 * session in addition to those for
 * {@link android.hardware.camera2.CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_FULL} devices. Note that while
 * the second configuration allows for configuring {@code MAXIMUM} {@code YUV} and {@code JPEG}
 * outputs at the same time, that configuration is not listed for regular capture sessions, and
 * therefore simultaneous output to both targets is not allowed.
 *
 * <table>
 * <tr><th colspan="13">LEVEL-3 additional guaranteed configurations for creating a reprocessable capture session<br>({@code PRIV} input is guaranteed only if PRIVATE reprocessing is supported. {@code YUV} input is always guaranteed.</th></tr>
 * <tr><th colspan="2" id="rb">Input</th><th colspan="2" id="rb">Target 1</th><th colspan="2" id="rb">Target 2</th><th colspan="2" id="rb">Target 3</th><th colspan="2" id="rb">Target 4</th><th colspan="2" id="rb">Target 5</th><th rowspan="2">Sample use case(s)</th> </tr>
 * <tr><th>Type</th><th id="rb">Max size</th><th>Type</th><th id="rb">Max size</th><th>Type</th><th id="rb">Max size</th><th>Type</th><th id="rb">Max size</th><th>Type</th><th id="rb">Max size</th><th>Type</th><th id="rb">Max size</th></tr>
 * <tr> <td>{@code YUV}</td><td id="rb">{@code MAXIMUM}</td> <td>{@code YUV}</td><td id="rb">{@code MAXIMUM}</td> <td>{@code PRIV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code PRIV}</td><td id="rb">{@code 640x480}</td> <td>{@code RAW}</td><td id="rb">{@code MAXIMUM}</td> <td></td><td id="rb"></td> <td>In-app viewfinder analysis with ZSL and RAW.</td> </tr>
 * <tr> <td>{@code PRIV}/{@code YUV}</td><td id="rb">{@code MAXIMUM}</td> <td>Same as input</td><td id="rb">{@code MAXIMUM}</td> <td>{@code PRIV}</td><td id="rb">{@code PREVIEW}</td> <td>{@code PRIV}</td><td id="rb">{@code 640x480}</td> <td>{@code RAW}</td><td id="rb">{@code MAXIMUM}</td> <td>{@code JPEG}</td><td id="rb">{@code MAXIMUM}</td><td>In-app viewfinder analysis with ZSL, RAW, and JPEG reprocessing output.</td> </tr>
 * </table><br>
 * </p>
 *
 * <p>Clients can access the above mandatory stream combination tables via
 * {@link android.hardware.camera2.params.MandatoryStreamCombination}.</p>
 *
 * @param inputConfig The configuration for the input {@link android.view.Surface Surface}
 * This value must never be {@code null}.
 * @param outputs The new set of Surfaces that should be made available as
 *                targets for captured image data.
 * This value must never be {@code null}.
 * @param callback The callback to notify about the status of the new capture session.
 * This value must never be {@code null}.
 * @param handler The handler on which the callback should be invoked, or {@code null} to use
 *                the current thread's {@link android.os.Looper looper}.
 *
 * This value may be {@code null}.
 * @throws java.lang.IllegalArgumentException if the input configuration is null or not supported, the set
 *                                  of output Surfaces do not meet the requirements, the
 *                                  callback is null, or the handler is null but the current
 *                                  thread has no looper.
 * @throws android.hardware.camera2.CameraAccessException if the camera device is no longer connected or has
 *                               encountered a fatal error
 * @throws java.lang.IllegalStateException if the camera device has been closed
 *
 * @see #createCaptureSession
 * @see android.hardware.camera2.CameraCaptureSession
 * @see android.hardware.camera2.params.StreamConfigurationMap#getInputFormats
 * @see android.hardware.camera2.params.StreamConfigurationMap#getInputSizes
 * @see android.hardware.camera2.params.StreamConfigurationMap#getValidOutputFormatsForInput
 * @see StreamConfigurationMap#getOutputSizes
 * @see android.media.ImageWriter
 * @see android.media.ImageReader
 * @apiSince 23
 */

public abstract void createReprocessableCaptureSession(@androidx.annotation.NonNull android.hardware.camera2.params.InputConfiguration inputConfig, @androidx.annotation.NonNull java.util.List<android.view.Surface> outputs, @androidx.annotation.NonNull android.hardware.camera2.CameraCaptureSession.StateCallback callback, @androidx.annotation.Nullable android.os.Handler handler) throws android.hardware.camera2.CameraAccessException;

/**
 * Create a new reprocessable camera capture session by providing the desired reprocessing
 * input configuration and output {@link android.hardware.camera2.params.OutputConfiguration OutputConfiguration}
 * to the camera device.
 *
 * @see #createReprocessableCaptureSession
 * @see android.hardware.camera2.params.OutputConfiguration
 *
 
 * @param inputConfig This value must never be {@code null}.
 
 * @param outputs This value must never be {@code null}.
 
 * @param callback This value must never be {@code null}.
 
 * @param handler This value may be {@code null}.
 * @apiSince 24
 */

public abstract void createReprocessableCaptureSessionByConfigurations(@androidx.annotation.NonNull android.hardware.camera2.params.InputConfiguration inputConfig, @androidx.annotation.NonNull java.util.List<android.hardware.camera2.params.OutputConfiguration> outputs, @androidx.annotation.NonNull android.hardware.camera2.CameraCaptureSession.StateCallback callback, @androidx.annotation.Nullable android.os.Handler handler) throws android.hardware.camera2.CameraAccessException;

/**
 * <p>Create a new constrained high speed capture session.</p>
 *
 * <p>The application can use normal capture session (created via {@link #createCaptureSession})
 * for high speed capture if the desired high speed FPS ranges are advertised by
 * {@link android.hardware.camera2.CameraCharacteristics#CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES CameraCharacteristics#CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES}, in which case all API
 * semantics associated with normal capture sessions applies.</p>
 *
 * <p>The method creates a specialized capture session that is only targeted at high speed
 * video recording (>=120fps) use case if the camera device supports high speed video
 * capability (i.e., {@link android.hardware.camera2.CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES} contains
 * {@link android.hardware.camera2.CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_CONSTRAINED_HIGH_SPEED_VIDEO CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_CONSTRAINED_HIGH_SPEED_VIDEO}).
 * Therefore, it has special characteristics compared with a normal capture session:</p>
 *
 * <ul>
 *
 * <li>In addition to the output target Surface requirements specified by the
 *   {@link #createCaptureSession} method, an active high speed capture session will support up
 *   to 2 output Surfaces, though the application might choose to configure just one Surface
 *   (e.g., preview only). All Surfaces must be either video encoder surfaces (acquired by
 *   {@link android.media.MediaRecorder#getSurface} or
 *   {@link android.media.MediaCodec#createInputSurface}) or preview surfaces (obtained from
 *   {@link android.view.SurfaceView}, {@link android.graphics.SurfaceTexture} via
 *   {@link android.view.Surface#Surface(android.graphics.SurfaceTexture)}). The Surface sizes
 *   must be one of the sizes reported by {@link android.hardware.camera2.params.StreamConfigurationMap#getHighSpeedVideoSizes StreamConfigurationMap#getHighSpeedVideoSizes}.
 *   When multiple Surfaces are configured, their size must be same.</li>
 *
 * <li>An active high speed capture session only accepts request lists created via
 *   {@link android.hardware.camera2.CameraConstrainedHighSpeedCaptureSession#createHighSpeedRequestList CameraConstrainedHighSpeedCaptureSession#createHighSpeedRequestList}, and the
 *   request list can only be submitted to this session via
 *   {@link android.hardware.camera2.CameraCaptureSession#captureBurst CameraCaptureSession#captureBurst}, or
 *   {@link android.hardware.camera2.CameraCaptureSession#setRepeatingBurst CameraCaptureSession#setRepeatingBurst}.</li>
 *
 * <li>The FPS ranges being requested to this session must be selected from
 *   {@link android.hardware.camera2.params.StreamConfigurationMap#getHighSpeedVideoFpsRangesFor StreamConfigurationMap#getHighSpeedVideoFpsRangesFor}. The application can still use
 *   {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_TARGET_FPS_RANGE CaptureRequest#CONTROL_AE_TARGET_FPS_RANGE} to control the desired FPS range.
 *   Switching to an FPS range that has different
 *   {@link android.util.Range#getUpper() maximum FPS} may trigger some camera device
 *   reconfigurations, which may introduce extra latency. It is recommended that the
 *   application avoids unnecessary maximum target FPS changes as much as possible during high
 *   speed streaming.</li>
 *
 * <li>For the request lists submitted to this session, the camera device will override the
 *   {@link android.hardware.camera2.CaptureRequest#CONTROL_MODE CaptureRequest#CONTROL_MODE}, auto-exposure (AE), auto-white balance
 *   (AWB) and auto-focus (AF) to {@link android.hardware.camera2.CameraMetadata#CONTROL_MODE_AUTO CameraMetadata#CONTROL_MODE_AUTO},
 *   {@link android.hardware.camera2.CameraMetadata#CONTROL_AE_MODE_ON CameraMetadata#CONTROL_AE_MODE_ON}, {@link android.hardware.camera2.CameraMetadata#CONTROL_AWB_MODE_AUTO CameraMetadata#CONTROL_AWB_MODE_AUTO}
 *   and {@link android.hardware.camera2.CameraMetadata#CONTROL_AF_MODE_CONTINUOUS_VIDEO CameraMetadata#CONTROL_AF_MODE_CONTINUOUS_VIDEO}, respectively. All
 *   post-processing block mode controls will be overridden to be FAST. Therefore, no manual
 *   control of capture and post-processing parameters is possible. Beside these, only a subset
 *   of controls will work, see
 *   {@link android.hardware.camera2.CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_CONSTRAINED_HIGH_SPEED_VIDEO CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_CONSTRAINED_HIGH_SPEED_VIDEO} for
 *   more details.</li>
 *
 * </ul>
 *
 * @param outputs The new set of Surfaces that should be made available as
 *                targets for captured high speed image data.
 * This value must never be {@code null}.
 * @param callback The callback to notify about the status of the new capture session.
 * This value must never be {@code null}.
 * @param handler The handler on which the callback should be invoked, or {@code null} to use
 *                the current thread's {@link android.os.Looper looper}.
 *
 * This value may be {@code null}.
 * @throws java.lang.IllegalArgumentException if the set of output Surfaces do not meet the requirements,
 *                                  the callback is null, or the handler is null but the current
 *                                  thread has no looper, or the camera device doesn't support
 *                                  high speed video capability.
 * @throws android.hardware.camera2.CameraAccessException if the camera device is no longer connected or has
 *                               encountered a fatal error
 * @throws java.lang.IllegalStateException if the camera device has been closed
 *
 * @see #createCaptureSession
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AE_TARGET_FPS_RANGE
 * @see android.hardware.camera2.params.StreamConfigurationMap#getHighSpeedVideoSizes
 * @see android.hardware.camera2.params.StreamConfigurationMap#getHighSpeedVideoFpsRangesFor
 * @see android.hardware.camera2.CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES
 * @see android.hardware.camera2.CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_CONSTRAINED_HIGH_SPEED_VIDEO
 * @see android.hardware.camera2.CameraCaptureSession#captureBurst
 * @see android.hardware.camera2.CameraCaptureSession#setRepeatingBurst
 * @see android.hardware.camera2.CameraConstrainedHighSpeedCaptureSession#createHighSpeedRequestList
 * @apiSince 23
 */

public abstract void createConstrainedHighSpeedCaptureSession(@androidx.annotation.NonNull java.util.List<android.view.Surface> outputs, @androidx.annotation.NonNull android.hardware.camera2.CameraCaptureSession.StateCallback callback, @androidx.annotation.Nullable android.os.Handler handler) throws android.hardware.camera2.CameraAccessException;

/**
 * <p>Create a new {@link android.hardware.camera2.CameraCaptureSession CameraCaptureSession} using a {@link android.hardware.camera2.params.SessionConfiguration SessionConfiguration} helper
 * object that aggregates all supported parameters.</p>
 *
 * @param config A session configuration (see {@link android.hardware.camera2.params.SessionConfiguration SessionConfiguration}).
 *
 * @throws java.lang.IllegalArgumentException In case the session configuration is invalid; or the output
 *                                  configurations are empty; or the session configuration
 *                                  executor is invalid.
 * @throws android.hardware.camera2.CameraAccessException In case the camera device is no longer connected or has
 *                               encountered a fatal error.
 * @see #createCaptureSession(List, CameraCaptureSession.StateCallback, Handler)
 * @see #createCaptureSessionByOutputConfigurations
 * @see #createReprocessableCaptureSession
 * @see #createConstrainedHighSpeedCaptureSession
 * @apiSince 28
 */

public void createCaptureSession(android.hardware.camera2.params.SessionConfiguration config) throws android.hardware.camera2.CameraAccessException { throw new RuntimeException("Stub!"); }

/**
 * <p>Create a {@link android.hardware.camera2.CaptureRequest.Builder CaptureRequest.Builder} for new capture requests,
 * initialized with template for a target use case. The settings are chosen
 * to be the best options for the specific camera device, so it is not
 * recommended to reuse the same request for a different camera device;
 * create a builder specific for that device and template and override the
 * settings as desired, instead.</p>
 *
 * @param templateType An enumeration selecting the use case for this request. Not all template
 * types are supported on every device. See the documentation for each template type for
 * details.
 * Value is {@link android.hardware.camera2.CameraDevice#TEMPLATE_PREVIEW}, {@link android.hardware.camera2.CameraDevice#TEMPLATE_STILL_CAPTURE}, {@link android.hardware.camera2.CameraDevice#TEMPLATE_RECORD}, {@link android.hardware.camera2.CameraDevice#TEMPLATE_VIDEO_SNAPSHOT}, {@link android.hardware.camera2.CameraDevice#TEMPLATE_ZERO_SHUTTER_LAG}, or {@link android.hardware.camera2.CameraDevice#TEMPLATE_MANUAL}
 * @return a builder for a capture request, initialized with default
 * settings for that template, and no output streams
 *
 * This value will never be {@code null}.
 * @throws java.lang.IllegalArgumentException if the templateType is not supported by
 * this device.
 * @throws android.hardware.camera2.CameraAccessException if the camera device is no longer connected or has
 *                               encountered a fatal error
 * @throws java.lang.IllegalStateException if the camera device has been closed
 * @apiSince 21
 */

@androidx.annotation.NonNull
public abstract android.hardware.camera2.CaptureRequest.Builder createCaptureRequest(int templateType) throws android.hardware.camera2.CameraAccessException;

/**
 * <p>Create a {@link android.hardware.camera2.CaptureRequest.Builder CaptureRequest.Builder} for new capture requests,
 * initialized with template for a target use case. This methods allows
 * clients to pass physical camera ids which can be used to customize the
 * request for a specific physical camera. The settings are chosen
 * to be the best options for the specific logical camera device. If
 * additional physical camera ids are passed, then they will also use the
 * same settings template. Clients can further modify individual camera
 * settings by calling {@link android.hardware.camera2.CaptureRequest.Builder#setPhysicalCameraKey CaptureRequest.Builder#setPhysicalCameraKey}.</p>
 *
 * <p>Individual physical camera settings will only be honored for camera session
 * that was initialiazed with corresponding physical camera id output configuration
 * {@link android.hardware.camera2.params.OutputConfiguration#setPhysicalCameraId OutputConfiguration#setPhysicalCameraId} and the same output targets are
 * also attached in the request by {@link android.hardware.camera2.CaptureRequest.Builder#addTarget CaptureRequest.Builder#addTarget}.</p>
 *
 * <p>The output is undefined for any logical camera streams in case valid physical camera
 * settings are attached.</p>
 *
 * @param templateType An enumeration selecting the use case for this request. Not all template
 * types are supported on every device. See the documentation for each template type for
 * details.
 * Value is {@link android.hardware.camera2.CameraDevice#TEMPLATE_PREVIEW}, {@link android.hardware.camera2.CameraDevice#TEMPLATE_STILL_CAPTURE}, {@link android.hardware.camera2.CameraDevice#TEMPLATE_RECORD}, {@link android.hardware.camera2.CameraDevice#TEMPLATE_VIDEO_SNAPSHOT}, {@link android.hardware.camera2.CameraDevice#TEMPLATE_ZERO_SHUTTER_LAG}, or {@link android.hardware.camera2.CameraDevice#TEMPLATE_MANUAL}
 * @param physicalCameraIdSet A set of physical camera ids that can be used to customize
 *                            the request for a specific physical camera.
 * @return a builder for a capture request, initialized with default
 * settings for that template, and no output streams
 *
 * This value will never be {@code null}.
 * @throws java.lang.IllegalArgumentException if the templateType is not supported by
 * this device, or one of the physical id arguments matches with logical camera id.
 * @throws android.hardware.camera2.CameraAccessException if the camera device is no longer connected or has
 *                               encountered a fatal error
 * @throws java.lang.IllegalStateException if the camera device has been closed
 *
 * @see #TEMPLATE_PREVIEW
 * @see #TEMPLATE_RECORD
 * @see #TEMPLATE_STILL_CAPTURE
 * @see #TEMPLATE_VIDEO_SNAPSHOT
 * @see #TEMPLATE_MANUAL
 * @see android.hardware.camera2.CaptureRequest.Builder#setPhysicalCameraKey
 * @see android.hardware.camera2.CaptureRequest.Builder#getPhysicalCameraKey
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.hardware.camera2.CaptureRequest.Builder createCaptureRequest(int templateType, java.util.Set<java.lang.String> physicalCameraIdSet) throws android.hardware.camera2.CameraAccessException { throw new RuntimeException("Stub!"); }

/**
 * <p>Create a {@link android.hardware.camera2.CaptureRequest.Builder CaptureRequest.Builder} for a new reprocess {@link android.hardware.camera2.CaptureRequest CaptureRequest} from a
 * {@link android.hardware.camera2.TotalCaptureResult TotalCaptureResult}.
 *
 * <p>Each reprocess {@link android.hardware.camera2.CaptureRequest CaptureRequest} processes one buffer from
 * {@link android.hardware.camera2.CameraCaptureSession CameraCaptureSession}'s input {@link android.view.Surface Surface} to all output {@link android.view.Surface Surface}
 * included in the reprocess capture request. The reprocess input images must be generated from
 * one or multiple output images captured from the same camera device. The application can
 * provide input images to camera device via {@link android.media.ImageWriter#queueInputImage}.
 * The application must use the capture result of one of those output images to create a
 * reprocess capture request so that the camera device can use the information to achieve
 * optimal reprocess image quality. For camera devices that support only 1 output
 * {@link android.view.Surface Surface}, submitting a reprocess {@link android.hardware.camera2.CaptureRequest CaptureRequest} with multiple
 * output targets will result in a {@link android.hardware.camera2.CaptureFailure CaptureFailure}.
 *
 * @param inputResult The capture result of the output image or one of the output images used
 *                       to generate the reprocess input image for this capture request.
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if inputResult is null.
 * @throws android.hardware.camera2.CameraAccessException if the camera device is no longer connected or has
 *                               encountered a fatal error
 * @throws java.lang.IllegalStateException if the camera device has been closed
 *
 * @see android.hardware.camera2.CaptureRequest.Builder
 * @see android.hardware.camera2.TotalCaptureResult
 * @see android.hardware.camera2.CameraDevice#createReprocessableCaptureSession
 * @see android.media.ImageWriter
 * @apiSince 23
 */

@androidx.annotation.NonNull
public abstract android.hardware.camera2.CaptureRequest.Builder createReprocessCaptureRequest(@androidx.annotation.NonNull android.hardware.camera2.TotalCaptureResult inputResult) throws android.hardware.camera2.CameraAccessException;

/**
 * Close the connection to this camera device as quickly as possible.
 *
 * <p>Immediately after this call, all calls to the camera device or active session interface
 * will throw a {@link java.lang.IllegalStateException IllegalStateException}, except for calls to close(). Once the device has
 * fully shut down, the {@link android.hardware.camera2.CameraDevice.StateCallback#onClosed StateCallback#onClosed} callback will be called, and the camera
 * is free to be re-opened.</p>
 *
 * <p>Immediately after this call, besides the final {@link android.hardware.camera2.CameraDevice.StateCallback#onClosed StateCallback#onClosed} calls, no
 * further callbacks from the device or the active session will occur, and any remaining
 * submitted capture requests will be discarded, as if
 * {@link android.hardware.camera2.CameraCaptureSession#abortCaptures CameraCaptureSession#abortCaptures} had been called, except that no success or failure
 * callbacks will be invoked.</p>
 *
 * @apiSince 21
 */

public abstract void close();

/**
 * Checks whether a particular {@link android.hardware.camera2.params.SessionConfiguration SessionConfiguration} is supported by the camera device.
 *
 * <p>This method performs a runtime check of a given {@link android.hardware.camera2.params.SessionConfiguration SessionConfiguration}. The result
 * confirms whether or not the passed session configuration can be successfully used to
 * create a camera capture session using
 * {@link android.hardware.camera2.CameraDevice#createCaptureSession(android.hardware.camera2.params.SessionConfiguration) CameraDevice#createCaptureSession(SessionConfiguration)}.
 * </p>
 *
 * <p>The method can be called at any point before, during and after active capture session.
 * It must not impact normal camera behavior in any way and must complete significantly
 * faster than creating a regular or constrained capture session.</p>
 *
 * <p>Although this method is faster than creating a new capture session, it is not intended
 * to be used for exploring the entire space of supported stream combinations. The available
 * mandatory stream combinations
 * {@link android.hardware.camera2.params.MandatoryStreamCombination} are better suited for this
 * purpose.</p>
 *
 * <p>Note that session parameters will be ignored and calls to
 * {@link android.hardware.camera2.params.SessionConfiguration#setSessionParameters SessionConfiguration#setSessionParameters} are not required.</p>
 *
 * @param sessionConfig This value must never be {@code null}.
 * @return {@code true} if the given session configuration is supported by the camera device
 *         {@code false} otherwise.
 * @throws java.lang.UnsupportedOperationException if the query operation is not supported by the camera
 *                                       device
 * @throws java.lang.IllegalArgumentException if the session configuration is invalid
 * @throws android.hardware.camera2.CameraAccessException if the camera device is no longer connected or has
 *                               encountered a fatal error
 * @throws java.lang.IllegalStateException if the camera device has been closed
 * @apiSince 29
 */

public boolean isSessionConfigurationSupported(@androidx.annotation.NonNull android.hardware.camera2.params.SessionConfiguration sessionConfig) throws android.hardware.camera2.CameraAccessException { throw new RuntimeException("Stub!"); }

/**
 * A basic template for direct application control of capture
 * parameters. All automatic control is disabled (auto-exposure, auto-white
 * balance, auto-focus), and post-processing parameters are set to preview
 * quality. The manual capture parameters (exposure, sensitivity, and so on)
 * are set to reasonable defaults, but should be overriden by the
 * application depending on the intended use case.
 * This template is guaranteed to be supported on camera devices that support the
 * {@link android.hardware.camera2.CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_MANUAL_SENSOR CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_MANUAL_SENSOR}
 * capability.
 *
 * @see #createCaptureRequest
 * @apiSince 21
 */

public static final int TEMPLATE_MANUAL = 6; // 0x6

/**
 * Create a request suitable for a camera preview window. Specifically, this
 * means that high frame rate is given priority over the highest-quality
 * post-processing. These requests would normally be used with the
 * {@link android.hardware.camera2.CameraCaptureSession#setRepeatingRequest CameraCaptureSession#setRepeatingRequest} method.
 * This template is guaranteed to be supported on all camera devices.
 *
 * @see #createCaptureRequest
 * @apiSince 21
 */

public static final int TEMPLATE_PREVIEW = 1; // 0x1

/**
 * Create a request suitable for video recording. Specifically, this means
 * that a stable frame rate is used, and post-processing is set for
 * recording quality. These requests would commonly be used with the
 * {@link android.hardware.camera2.CameraCaptureSession#setRepeatingRequest CameraCaptureSession#setRepeatingRequest} method.
 * This template is guaranteed to be supported on all camera devices except
 * {@link android.hardware.camera2.CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_DEPTH_OUTPUT CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_DEPTH_OUTPUT} devices
 * that are not {@link android.hardware.camera2.CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_BACKWARD_COMPATIBLE CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_BACKWARD_COMPATIBLE}.
 *
 * @see #createCaptureRequest
 * @apiSince 21
 */

public static final int TEMPLATE_RECORD = 3; // 0x3

/**
 * Create a request suitable for still image capture. Specifically, this
 * means prioritizing image quality over frame rate. These requests would
 * commonly be used with the {@link android.hardware.camera2.CameraCaptureSession#capture CameraCaptureSession#capture} method.
 * This template is guaranteed to be supported on all camera devices except
 * {@link android.hardware.camera2.CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_DEPTH_OUTPUT CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_DEPTH_OUTPUT} devices
 * that are not {@link android.hardware.camera2.CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_BACKWARD_COMPATIBLE CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_BACKWARD_COMPATIBLE}.
 * @see #createCaptureRequest
 * @apiSince 21
 */

public static final int TEMPLATE_STILL_CAPTURE = 2; // 0x2

/**
 * Create a request suitable for still image capture while recording
 * video. Specifically, this means maximizing image quality without
 * disrupting the ongoing recording. These requests would commonly be used
 * with the {@link android.hardware.camera2.CameraCaptureSession#capture CameraCaptureSession#capture} method while a request based on
 * {@link #TEMPLATE_RECORD} is is in use with {@link android.hardware.camera2.CameraCaptureSession#setRepeatingRequest CameraCaptureSession#setRepeatingRequest}.
 * This template is guaranteed to be supported on all camera devices except
 * legacy devices ({@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL}
 * {@code == }{@link android.hardware.camera2.CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY CameraMetadata#INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY}) and
 * {@link android.hardware.camera2.CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_DEPTH_OUTPUT CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_DEPTH_OUTPUT} devices
 * that are not {@link android.hardware.camera2.CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_BACKWARD_COMPATIBLE CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_BACKWARD_COMPATIBLE}.
 *
 * @see #createCaptureRequest
 * @apiSince 21
 */

public static final int TEMPLATE_VIDEO_SNAPSHOT = 4; // 0x4

/**
 * Create a request suitable for zero shutter lag still capture. This means
 * means maximizing image quality without compromising preview frame rate.
 * AE/AWB/AF should be on auto mode. This is intended for application-operated ZSL. For
 * device-operated ZSL, use {@link android.hardware.camera2.CaptureRequest#CONTROL_ENABLE_ZSL CaptureRequest#CONTROL_ENABLE_ZSL} if available.
 * This template is guaranteed to be supported on camera devices that support the
 * {@link android.hardware.camera2.CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_PRIVATE_REPROCESSING CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_PRIVATE_REPROCESSING}
 * capability or the
 * {@link android.hardware.camera2.CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_YUV_REPROCESSING CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_YUV_REPROCESSING}
 * capability.
 *
 * @see #createCaptureRequest
 * @see android.hardware.camera2.CaptureRequest#CONTROL_ENABLE_ZSL
 * @apiSince 21
 */

public static final int TEMPLATE_ZERO_SHUTTER_LAG = 5; // 0x5
/**
 * A callback objects for receiving updates about the state of a camera device.
 *
 * <p>A callback instance must be provided to the {@link android.hardware.camera2.CameraManager#openCamera CameraManager#openCamera} method to
 * open a camera device.</p>
 *
 * <p>These state updates include notifications about the device completing startup (
 * allowing for {@link #createCaptureSession} to be called), about device
 * disconnection or closure, and about unexpected device errors.</p>
 *
 * <p>Events about the progress of specific {@link android.hardware.camera2.CaptureRequest CaptureRequest} are provided
 * through a {@link android.hardware.camera2.CameraCaptureSession.CaptureCallback CameraCaptureSession.CaptureCallback} given to the
 * {@link android.hardware.camera2.CameraCaptureSession#capture CameraCaptureSession#capture}, {@link android.hardware.camera2.CameraCaptureSession#captureBurst CameraCaptureSession#captureBurst},
 * {@link android.hardware.camera2.CameraCaptureSession#setRepeatingRequest CameraCaptureSession#setRepeatingRequest}, or
 * {@link android.hardware.camera2.CameraCaptureSession#setRepeatingBurst CameraCaptureSession#setRepeatingBurst} methods.
 *
 * @see CameraManager#openCamera
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class StateCallback {

public StateCallback() { throw new RuntimeException("Stub!"); }

/**
 * The method called when a camera device has finished opening.
 *
 * <p>At this point, the camera device is ready to use, and
 * {@link android.hardware.camera2.CameraDevice#createCaptureSession CameraDevice#createCaptureSession} can be called to set up the first capture
 * session.</p>
 *
 * @param camera the camera device that has become opened
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public abstract void onOpened(@androidx.annotation.NonNull android.hardware.camera2.CameraDevice camera);

/**
 * The method called when a camera device has been closed with
 * {@link android.hardware.camera2.CameraDevice#close CameraDevice#close}.
 *
 * <p>Any attempt to call methods on this CameraDevice in the
 * future will throw a {@link java.lang.IllegalStateException IllegalStateException}.</p>
 *
 * <p>The default implementation of this method does nothing.</p>
 *
 * @param camera the camera device that has become closed
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public void onClosed(@androidx.annotation.NonNull android.hardware.camera2.CameraDevice camera) { throw new RuntimeException("Stub!"); }

/**
 * The method called when a camera device is no longer available for
 * use.
 *
 * <p>This callback may be called instead of {@link #onOpened}
 * if opening the camera fails.</p>
 *
 * <p>Any attempt to call methods on this CameraDevice will throw a
 * {@link android.hardware.camera2.CameraAccessException CameraAccessException}. The disconnection could be due to a
 * change in security policy or permissions; the physical disconnection
 * of a removable camera device; or the camera being needed for a
 * higher-priority camera API client.</p>
 *
 * <p>There may still be capture callbacks that are invoked
 * after this method is called, or new image buffers that are delivered
 * to active outputs.</p>
 *
 * <p>The default implementation logs a notice to the system log
 * about the disconnection.</p>
 *
 * <p>You should clean up the camera with {@link android.hardware.camera2.CameraDevice#close CameraDevice#close} after
 * this happens, as it is not recoverable until the camera can be opened
 * again. For most use cases, this will be when the camera again becomes
 * {@link android.hardware.camera2.CameraManager.AvailabilityCallback#onCameraAvailable CameraManager.AvailabilityCallback#onCameraAvailable}.
 * </p>
 *
 * @param camera the device that has been disconnected
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public abstract void onDisconnected(@androidx.annotation.NonNull android.hardware.camera2.CameraDevice camera);

/**
 * The method called when a camera device has encountered a serious error.
 *
 * <p>This callback may be called instead of {@link #onOpened}
 * if opening the camera fails.</p>
 *
 * <p>This indicates a failure of the camera device or camera service in
 * some way. Any attempt to call methods on this CameraDevice in the
 * future will throw a {@link android.hardware.camera2.CameraAccessException CameraAccessException} with the
 * {@link android.hardware.camera2.CameraAccessException#CAMERA_ERROR CameraAccessException#CAMERA_ERROR} reason.
 * </p>
 *
 * <p>There may still be capture completion or camera stream callbacks
 * that will be called after this error is received.</p>
 *
 * <p>You should clean up the camera with {@link android.hardware.camera2.CameraDevice#close CameraDevice#close} after
 * this happens. Further attempts at recovery are error-code specific.</p>
 *
 * @param camera The device reporting the error
 * This value must never be {@code null}.
 * @param error The error code.
 *
 * Value is {@link android.hardware.camera2.CameraDevice.StateCallback#ERROR_CAMERA_IN_USE}, {@link android.hardware.camera2.CameraDevice.StateCallback#ERROR_MAX_CAMERAS_IN_USE}, {@link android.hardware.camera2.CameraDevice.StateCallback#ERROR_CAMERA_DISABLED}, {@link android.hardware.camera2.CameraDevice.StateCallback#ERROR_CAMERA_DEVICE}, or {@link android.hardware.camera2.CameraDevice.StateCallback#ERROR_CAMERA_SERVICE}
 * @see #ERROR_CAMERA_IN_USE
 * @see #ERROR_MAX_CAMERAS_IN_USE
 * @see #ERROR_CAMERA_DISABLED
 * @see #ERROR_CAMERA_DEVICE
 * @see #ERROR_CAMERA_SERVICE
 * @apiSince 21
 */

public abstract void onError(@androidx.annotation.NonNull android.hardware.camera2.CameraDevice camera, int error);

/**
 * An error code that can be reported by {@link #onError}
 * indicating that the camera device has encountered a fatal error.
 *
 * <p>The camera device needs to be re-opened to be used again.</p>
 *
 * @see #onError
 * @apiSince 21
 */

public static final int ERROR_CAMERA_DEVICE = 4; // 0x4

/**
 * An error code that can be reported by {@link #onError}
 * indicating that the camera device could not be opened due to a device
 * policy.
 *
 * @see android.app.admin.DevicePolicyManager#setCameraDisabled(android.content.ComponentName, boolean)
 * @see #onError
 * @apiSince 21
 */

public static final int ERROR_CAMERA_DISABLED = 3; // 0x3

/**
 * An error code that can be reported by {@link #onError}
 * indicating that the camera device is in use already.
 *
 * <p>
 * This error can be produced when opening the camera fails due to the camera
 *  being used by a higher-priority camera API client.
 * </p>
 *
 * @see #onError
 * @apiSince 21
  */

public static final int ERROR_CAMERA_IN_USE = 1; // 0x1

/**
 * An error code that can be reported by {@link #onError}
 * indicating that the camera service has encountered a fatal error.
 *
 * <p>The Android device may need to be shut down and restarted to restore
 * camera function, or there may be a persistent hardware problem.</p>
 *
 * <p>An attempt at recovery <i>may</i> be possible by closing the
 * CameraDevice and the CameraManager, and trying to acquire all resources
 * again from scratch.</p>
 *
 * @see #onError
 * @apiSince 21
 */

public static final int ERROR_CAMERA_SERVICE = 5; // 0x5

/**
 * An error code that can be reported by {@link #onError}
 * indicating that the camera device could not be opened
 * because there are too many other open camera devices.
 *
 * <p>
 * The system-wide limit for number of open cameras has been reached,
 * and more camera devices cannot be opened until previous instances are
 * closed.
 * </p>
 *
 * <p>
 * This error can be produced when opening the camera fails.
 * </p>
 *
 * @see #onError
 * @apiSince 21
 */

public static final int ERROR_MAX_CAMERAS_IN_USE = 2; // 0x2
}

}

