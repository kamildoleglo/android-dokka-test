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

import java.util.List;
import android.hardware.camera2.params.RecommendedStreamConfigurationMap;
import java.util.Set;
import android.hardware.camera2.params.SessionConfiguration;

/**
 * <p>The properties describing a
 * {@link android.hardware.camera2.CameraDevice CameraDevice}.</p>
 *
 * <p>These properties are fixed for a given CameraDevice, and can be queried
 * through the {@link android.hardware.camera2.CameraManager CameraManager}
 * interface with {@link android.hardware.camera2.CameraManager#getCameraCharacteristics CameraManager#getCameraCharacteristics}.</p>
 *
 * <p>{@link android.hardware.camera2.CameraCharacteristics CameraCharacteristics} objects are immutable.</p>
 *
 * @see android.hardware.camera2.CameraDevice
 * @see android.hardware.camera2.CameraManager
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CameraCharacteristics extends android.hardware.camera2.CameraMetadata<android.hardware.camera2.CameraCharacteristics.Key<?>> {

CameraCharacteristics() { throw new RuntimeException("Stub!"); }

/**
 * Get a camera characteristics field value.
 *
 * <p>The field definitions can be
 * found in {@link android.hardware.camera2.CameraCharacteristics CameraCharacteristics}.</p>
 *
 * <p>Querying the value for the same key more than once will return a value
 * which is equal to the previous queried value.</p>
 *
 * @throws java.lang.IllegalArgumentException if the key was not valid
 *
 * @param key The characteristics field to read.
 * @return The value of that key, or {@code null} if the field is not set.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public <T> T get(android.hardware.camera2.CameraCharacteristics.Key<T> key) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @return This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.util.List<android.hardware.camera2.CameraCharacteristics.Key<?>> getKeys() { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns a subset of the list returned by {@link #getKeys} with all keys that
 * require camera clients to obtain the {@link android.Manifest.permission#CAMERA} permission.
 * </p>
 *
 * <p>If an application calls {@link android.hardware.camera2.CameraManager#getCameraCharacteristics CameraManager#getCameraCharacteristics} without holding the
 * {@link android.Manifest.permission#CAMERA} permission,
 * all keys in this list will not be available, and calling {@link #get} will
 * return null for those keys. If the application obtains the
 * {@link android.Manifest.permission#CAMERA} permission, then the
 * CameraCharacteristics from a call to a subsequent
 * {@link android.hardware.camera2.CameraManager#getCameraCharacteristics CameraManager#getCameraCharacteristics} will have the keys available.</p>
 *
 * <p>The list returned is not modifiable, so any attempts to modify it will throw
 * a {@code UnsupportedOperationException}.</p>
 *
 * <p>Each key is only listed once in the list. The order of the keys is undefined.</p>
 *
 * @return List of camera characteristic keys that require the
 *         {@link android.Manifest.permission#CAMERA} permission. The list can be empty in case
 *         there are no currently present keys that need additional permission.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.util.List<android.hardware.camera2.CameraCharacteristics.Key<?>> getKeysNeedingPermission() { throw new RuntimeException("Stub!"); }

/**
 * <p>Retrieve camera device recommended stream configuration map
 * {@link android.hardware.camera2.params.RecommendedStreamConfigurationMap RecommendedStreamConfigurationMap} for a given use case.</p>
 *
 * <p>The stream configurations advertised here are efficient in terms of power and performance
 * for common use cases like preview, video, snapshot, etc. The recommended maps are usually
 * only small subsets of the exhaustive list provided in
 * {@link #SCALER_STREAM_CONFIGURATION_MAP} and suggested for a particular use case by the
 * camera device implementation. For further information about the expected configurations in
 * various scenarios please refer to:
 * <ul>
 * <li>{@link android.hardware.camera2.params.RecommendedStreamConfigurationMap#USECASE_PREVIEW RecommendedStreamConfigurationMap#USECASE_PREVIEW}</li>
 * <li>{@link android.hardware.camera2.params.RecommendedStreamConfigurationMap#USECASE_RECORD RecommendedStreamConfigurationMap#USECASE_RECORD}</li>
 * <li>{@link android.hardware.camera2.params.RecommendedStreamConfigurationMap#USECASE_VIDEO_SNAPSHOT RecommendedStreamConfigurationMap#USECASE_VIDEO_SNAPSHOT}</li>
 * <li>{@link android.hardware.camera2.params.RecommendedStreamConfigurationMap#USECASE_SNAPSHOT RecommendedStreamConfigurationMap#USECASE_SNAPSHOT}</li>
 * <li>{@link android.hardware.camera2.params.RecommendedStreamConfigurationMap#USECASE_RAW RecommendedStreamConfigurationMap#USECASE_RAW}</li>
 * <li>{@link android.hardware.camera2.params.RecommendedStreamConfigurationMap#USECASE_ZSL RecommendedStreamConfigurationMap#USECASE_ZSL}</li>
 * <li>{@link android.hardware.camera2.params.RecommendedStreamConfigurationMap#USECASE_LOW_LATENCY_SNAPSHOT RecommendedStreamConfigurationMap#USECASE_LOW_LATENCY_SNAPSHOT}</li>
 * </ul>
 * </p>
 *
 * <p>For example on how this can be used by camera clients to find out the maximum recommended
 * preview and snapshot resolution, consider the following pseudo-code:
 * </p>
 * <pre><code>
 * public static Size getMaxSize(Size... sizes) {
 *     if (sizes == null || sizes.length == 0) {
 *         throw new IllegalArgumentException("sizes was empty");
 *     }
 *
 *     Size sz = sizes[0];
 *     for (Size size : sizes) {
 *         if (size.getWidth() * size.getHeight() &gt; sz.getWidth() * sz.getHeight()) {
 *             sz = size;
 *         }
 *     }
 *
 *     return sz;
 * }
 *
 * CameraCharacteristics characteristics =
 *         cameraManager.getCameraCharacteristics(cameraId);
 * RecommendedStreamConfigurationMap previewConfig =
 *         characteristics.getRecommendedStreamConfigurationMap(
 *                  RecommendedStreamConfigurationMap.USECASE_PREVIEW);
 * RecommendedStreamConfigurationMap snapshotConfig =
 *         characteristics.getRecommendedStreamConfigurationMap(
 *                  RecommendedStreamConfigurationMap.USECASE_SNAPSHOT);
 *
 * if ((previewConfig != null) &amp;&amp; (snapshotConfig != null)) {
 *
 *      Set<Size> snapshotSizeSet = snapshotConfig.getOutputSizes(
 *              ImageFormat.JPEG);
 *      Size[] snapshotSizes = new Size[snapshotSizeSet.size()];
 *      snapshotSizes = snapshotSizeSet.toArray(snapshotSizes);
 *      Size suggestedMaxJpegSize = getMaxSize(snapshotSizes);
 *
 *      Set<Size> previewSizeSet = snapshotConfig.getOutputSizes(
 *              ImageFormat.PRIVATE);
 *      Size[] previewSizes = new Size[previewSizeSet.size()];
 *      previewSizes = previewSizeSet.toArray(previewSizes);
 *      Size suggestedMaxPreviewSize = getMaxSize(previewSizes);
 * }
 *
 * </code></pre>
 *
 * <p>Similar logic can be used for other use cases as well.</p>
 *
 * <p>Support for recommended stream configurations is optional. In case there a no
 * suggested configurations for the particular use case, please refer to
 * {@link #SCALER_STREAM_CONFIGURATION_MAP} for the exhaustive available list.</p>
 *
 * @param usecase Use case id.
 *
 * Value is {@link android.hardware.camera2.params.RecommendedStreamConfigurationMap#USECASE_PREVIEW}, {@link android.hardware.camera2.params.RecommendedStreamConfigurationMap#USECASE_RECORD}, {@link android.hardware.camera2.params.RecommendedStreamConfigurationMap#USECASE_VIDEO_SNAPSHOT}, {@link android.hardware.camera2.params.RecommendedStreamConfigurationMap#USECASE_SNAPSHOT}, {@link android.hardware.camera2.params.RecommendedStreamConfigurationMap#USECASE_ZSL}, {@link android.hardware.camera2.params.RecommendedStreamConfigurationMap#USECASE_RAW}, or {@link android.hardware.camera2.params.RecommendedStreamConfigurationMap#USECASE_LOW_LATENCY_SNAPSHOT}
 * @throws java.lang.IllegalArgumentException In case the use case argument is invalid.
 * @return Valid {@link android.hardware.camera2.params.RecommendedStreamConfigurationMap RecommendedStreamConfigurationMap} or null in case the camera device
 *         doesn't have any recommendation for this use case or the recommended configurations
 *         are invalid.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public android.hardware.camera2.params.RecommendedStreamConfigurationMap getRecommendedStreamConfigurationMap(int usecase) { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns a subset of {@link #getAvailableCaptureRequestKeys} keys that the
 * camera device can pass as part of the capture session initialization.</p>
 *
 * <p>This list includes keys that are difficult to apply per-frame and
 * can result in unexpected delays when modified during the capture session
 * lifetime. Typical examples include parameters that require a
 * time-consuming hardware re-configuration or internal camera pipeline
 * change. For performance reasons we suggest clients to pass their initial
 * values as part of {@link android.hardware.camera2.params.SessionConfiguration#setSessionParameters SessionConfiguration#setSessionParameters}. Once
 * the camera capture session is enabled it is also recommended to avoid
 * changing them from their initial values set in
 * {@link android.hardware.camera2.params.SessionConfiguration#setSessionParameters SessionConfiguration#setSessionParameters}.
 * Control over session parameters can still be exerted in capture requests
 * but clients should be aware and expect delays during their application.
 * An example usage scenario could look like this:</p>
 * <ul>
 * <li>The camera client starts by querying the session parameter key list via
 *   {@link android.hardware.camera2.CameraCharacteristics#getAvailableSessionKeys }.</li>
 * <li>Before triggering the capture session create sequence, a capture request
 *   must be built via {@link android.hardware.camera2.CameraDevice#createCaptureRequest CameraDevice#createCaptureRequest} using an
 *   appropriate template matching the particular use case.</li>
 * <li>The client should go over the list of session parameters and check
 *   whether some of the keys listed matches with the parameters that
 *   they intend to modify as part of the first capture request.</li>
 * <li>If there is no such match, the capture request can be  passed
 *   unmodified to {@link android.hardware.camera2.params.SessionConfiguration#setSessionParameters SessionConfiguration#setSessionParameters}.</li>
 * <li>If matches do exist, the client should update the respective values
 *   and pass the request to {@link android.hardware.camera2.params.SessionConfiguration#setSessionParameters SessionConfiguration#setSessionParameters}.</li>
 * <li>After the capture session initialization completes the session parameter
 *   key list can continue to serve as reference when posting or updating
 *   further requests. As mentioned above further changes to session
 *   parameters should ideally be avoided, if updates are necessary
 *   however clients could expect a delay/glitch during the
 *   parameter switch.</li>
 * </ul>
 *
 * <p>The list returned is not modifiable, so any attempts to modify it will throw
 * a {@code UnsupportedOperationException}.</p>
 *
 * <p>Each key is only listed once in the list. The order of the keys is undefined.</p>
 *
 * @return List of keys that can be passed during capture session initialization. In case the
 * camera device doesn't support such keys the list can be null.
 * @apiSince 28
 */

public java.util.List<android.hardware.camera2.CaptureRequest.Key<?>> getAvailableSessionKeys() { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns a subset of {@link #getAvailableCaptureRequestKeys} keys that can
 * be overridden for physical devices backing a logical multi-camera.</p>
 *
 * <p>This is a subset of android.request.availableRequestKeys which contains a list
 * of keys that can be overridden using {@link android.hardware.camera2.CaptureRequest.Builder#setPhysicalCameraKey CaptureRequest.Builder#setPhysicalCameraKey}.
 * The respective value of such request key can be obtained by calling
 * {@link android.hardware.camera2.CaptureRequest.Builder#getPhysicalCameraKey CaptureRequest.Builder#getPhysicalCameraKey}. Capture requests that contain
 * individual physical device requests must be built via
 * {@link android.hardware.camera2.CameraDevice#createCaptureRequest(int, Set)}.
 * Such extended capture requests can be passed only to
 * {@link android.hardware.camera2.CameraCaptureSession#capture CameraCaptureSession#capture} or {@link android.hardware.camera2.CameraCaptureSession#captureBurst CameraCaptureSession#captureBurst} and
 * not to {@link android.hardware.camera2.CameraCaptureSession#setRepeatingRequest CameraCaptureSession#setRepeatingRequest} or
 * {@link android.hardware.camera2.CameraCaptureSession#setRepeatingBurst CameraCaptureSession#setRepeatingBurst}.</p>
 *
 * <p>The list returned is not modifiable, so any attempts to modify it will throw
 * a {@code UnsupportedOperationException}.</p>
 *
 * <p>Each key is only listed once in the list. The order of the keys is undefined.</p>
 *
 * @return List of keys that can be overridden in individual physical device requests.
 * In case the camera device doesn't support such keys the list can be null.
 * @apiSince 28
 */

public java.util.List<android.hardware.camera2.CaptureRequest.Key<?>> getAvailablePhysicalCameraRequestKeys() { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of keys supported by this {@link android.hardware.camera2.CameraDevice CameraDevice} for querying
 * with a {@link android.hardware.camera2.CaptureRequest CaptureRequest}.
 *
 * <p>The list returned is not modifiable, so any attempts to modify it will throw
 * a {@code UnsupportedOperationException}.</p>
 *
 * <p>Each key is only listed once in the list. The order of the keys is undefined.</p>
 *
 * <p>Note that there is no {@code getAvailableCameraCharacteristicsKeys()} -- use
 * {@link #getKeys()} instead.</p>
 *
 * @return List of keys supported by this CameraDevice for CaptureRequests.
 
 * This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.util.List<android.hardware.camera2.CaptureRequest.Key<?>> getAvailableCaptureRequestKeys() { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of keys supported by this {@link android.hardware.camera2.CameraDevice CameraDevice} for querying
 * with a {@link android.hardware.camera2.CaptureResult CaptureResult}.
 *
 * <p>The list returned is not modifiable, so any attempts to modify it will throw
 * a {@code UnsupportedOperationException}.</p>
 *
 * <p>Each key is only listed once in the list. The order of the keys is undefined.</p>
 *
 * <p>Note that there is no {@code getAvailableCameraCharacteristicsKeys()} -- use
 * {@link #getKeys()} instead.</p>
 *
 * @return List of keys supported by this CameraDevice for CaptureResults.
 
 * This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.util.List<android.hardware.camera2.CaptureResult.Key<?>> getAvailableCaptureResultKeys() { throw new RuntimeException("Stub!"); }

/**
 * Returns the set of physical camera ids that this logical {@link android.hardware.camera2.CameraDevice CameraDevice} is
 * made up of.
 *
 * <p>A camera device is a logical camera if it has
 * REQUEST_AVAILABLE_CAPABILITIES_LOGICAL_MULTI_CAMERA capability. If the camera device
 * doesn't have the capability, the return value will be an empty set. </p>
 *
 * <p>Prior to API level 29, all returned IDs are guaranteed to be returned by {@link android.hardware.camera2.CameraManager#getCameraIdList CameraManager#getCameraIdList}, and can be opened directly by
 * {@link android.hardware.camera2.CameraManager#openCamera CameraManager#openCamera}. Starting from API level 29, for each of the returned ID,
 * if it's also returned by {@link android.hardware.camera2.CameraManager#getCameraIdList CameraManager#getCameraIdList}, it can be used as a
 * standalone camera by {@link android.hardware.camera2.CameraManager#openCamera CameraManager#openCamera}. Otherwise, the camera ID can only be
 * used as part of the current logical camera.</p>
 *
 * <p>The set returned is not modifiable, so any attempts to modify it will throw
 * a {@code UnsupportedOperationException}.</p>
 *
 * @return Set of physical camera ids for this logical camera device.
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.util.Set<java.lang.String> getPhysicalCameraIds() { throw new RuntimeException("Stub!"); }

/**
 * <p>List of aberration correction modes for {@link android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_ABERRATION_MODE CaptureRequest#COLOR_CORRECTION_ABERRATION_MODE} that are
 * supported by this camera device.</p>
 * <p>This key lists the valid modes for {@link android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_ABERRATION_MODE CaptureRequest#COLOR_CORRECTION_ABERRATION_MODE}.  If no
 * aberration correction modes are available for a device, this list will solely include
 * OFF mode. All camera devices will support either OFF or FAST mode.</p>
 * <p>Camera devices that support the MANUAL_POST_PROCESSING capability will always list
 * OFF mode. This includes all FULL level devices.</p>
 * <p>LEGACY devices will always only support FAST mode.</p>
 * <p><b>Range of valid values:</b><br>
 * Any value listed in {@link android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_ABERRATION_MODE CaptureRequest#COLOR_CORRECTION_ABERRATION_MODE}</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_ABERRATION_MODE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<int[]> COLOR_CORRECTION_AVAILABLE_ABERRATION_MODES;
static { COLOR_CORRECTION_AVAILABLE_ABERRATION_MODES = null; }

/**
 * <p>List of auto-exposure antibanding modes for {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_ANTIBANDING_MODE CaptureRequest#CONTROL_AE_ANTIBANDING_MODE} that are
 * supported by this camera device.</p>
 * <p>Not all of the auto-exposure anti-banding modes may be
 * supported by a given camera device. This field lists the
 * valid anti-banding modes that the application may request
 * for this camera device with the
 * {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_ANTIBANDING_MODE CaptureRequest#CONTROL_AE_ANTIBANDING_MODE} control.</p>
 * <p><b>Range of valid values:</b><br>
 * Any value listed in {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_ANTIBANDING_MODE CaptureRequest#CONTROL_AE_ANTIBANDING_MODE}</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AE_ANTIBANDING_MODE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<int[]> CONTROL_AE_AVAILABLE_ANTIBANDING_MODES;
static { CONTROL_AE_AVAILABLE_ANTIBANDING_MODES = null; }

/**
 * <p>List of auto-exposure modes for {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE CaptureRequest#CONTROL_AE_MODE} that are supported by this camera
 * device.</p>
 * <p>Not all the auto-exposure modes may be supported by a
 * given camera device, especially if no flash unit is
 * available. This entry lists the valid modes for
 * {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE CaptureRequest#CONTROL_AE_MODE} for this camera device.</p>
 * <p>All camera devices support ON, and all camera devices with flash
 * units support ON_AUTO_FLASH and ON_ALWAYS_FLASH.</p>
 * <p>FULL mode camera devices always support OFF mode,
 * which enables application control of camera exposure time,
 * sensitivity, and frame duration.</p>
 * <p>LEGACY mode camera devices never support OFF mode.
 * LIMITED mode devices support OFF if they support the MANUAL_SENSOR
 * capability.</p>
 * <p><b>Range of valid values:</b><br>
 * Any value listed in {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE CaptureRequest#CONTROL_AE_MODE}</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<int[]> CONTROL_AE_AVAILABLE_MODES;
static { CONTROL_AE_AVAILABLE_MODES = null; }

/**
 * <p>List of frame rate ranges for {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_TARGET_FPS_RANGE CaptureRequest#CONTROL_AE_TARGET_FPS_RANGE} supported by
 * this camera device.</p>
 * <p>For devices at the LEGACY level or above:</p>
 * <ul>
 * <li>
 * <p>For constant-framerate recording, for each normal
 * {@link android.media.CamcorderProfile CamcorderProfile}, that is, a
 * {@link android.media.CamcorderProfile CamcorderProfile} that has
 * {@link android.media.CamcorderProfile#quality quality} in
 * the range [{@link android.media.CamcorderProfile#QUALITY_LOW QUALITY_LOW},
 * {@link android.media.CamcorderProfile#QUALITY_2160P QUALITY_2160P}], if the profile is
 * supported by the device and has
 * {@link android.media.CamcorderProfile#videoFrameRate videoFrameRate} <code>x</code>, this list will
 * always include (<code>x</code>,<code>x</code>).</p>
 * </li>
 * <li>
 * <p>Also, a camera device must either not support any
 * {@link android.media.CamcorderProfile CamcorderProfile},
 * or support at least one
 * normal {@link android.media.CamcorderProfile CamcorderProfile} that has
 * {@link android.media.CamcorderProfile#videoFrameRate videoFrameRate} <code>x</code> &gt;= 24.</p>
 * </li>
 * </ul>
 * <p>For devices at the LIMITED level or above:</p>
 * <ul>
 * <li>For YUV_420_888 burst capture use case, this list will always include (<code>min</code>, <code>max</code>)
 * and (<code>max</code>, <code>max</code>) where <code>min</code> &lt;= 15 and <code>max</code> = the maximum output frame rate of the
 * maximum YUV_420_888 output size.</li>
 * </ul>
 * <p><b>Units</b>: Frames per second (FPS)</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AE_TARGET_FPS_RANGE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<android.util.Range<java.lang.Integer>[]> CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES;
static { CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES = null; }

/**
 * <p>Maximum and minimum exposure compensation values for
 * {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_EXPOSURE_COMPENSATION CaptureRequest#CONTROL_AE_EXPOSURE_COMPENSATION}, in counts of {@link android.hardware.camera2.CameraCharacteristics#CONTROL_AE_COMPENSATION_STEP CameraCharacteristics#CONTROL_AE_COMPENSATION_STEP},
 * that are supported by this camera device.</p>
 * <p><b>Range of valid values:</b><br></p>
 * <p>Range [0,0] indicates that exposure compensation is not supported.</p>
 * <p>For LIMITED and FULL devices, range must follow below requirements if exposure
 * compensation is supported (<code>range != [0, 0]</code>):</p>
 * <p><code>Min.exposure compensation * {@link android.hardware.camera2.CameraCharacteristics#CONTROL_AE_COMPENSATION_STEP CameraCharacteristics#CONTROL_AE_COMPENSATION_STEP} &lt;= -2 EV</code></p>
 * <p><code>Max.exposure compensation * {@link android.hardware.camera2.CameraCharacteristics#CONTROL_AE_COMPENSATION_STEP CameraCharacteristics#CONTROL_AE_COMPENSATION_STEP} &gt;= 2 EV</code></p>
 * <p>LEGACY devices may support a smaller range than this.</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#CONTROL_AE_COMPENSATION_STEP
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AE_EXPOSURE_COMPENSATION
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<android.util.Range<java.lang.Integer>> CONTROL_AE_COMPENSATION_RANGE;
static { CONTROL_AE_COMPENSATION_RANGE = null; }

/**
 * <p>Smallest step by which the exposure compensation
 * can be changed.</p>
 * <p>This is the unit for {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_EXPOSURE_COMPENSATION CaptureRequest#CONTROL_AE_EXPOSURE_COMPENSATION}. For example, if this key has
 * a value of <code>1/2</code>, then a setting of <code>-2</code> for {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_EXPOSURE_COMPENSATION CaptureRequest#CONTROL_AE_EXPOSURE_COMPENSATION} means
 * that the target EV offset for the auto-exposure routine is -1 EV.</p>
 * <p>One unit of EV compensation changes the brightness of the captured image by a factor
 * of two. +1 EV doubles the image brightness, while -1 EV halves the image brightness.</p>
 * <p><b>Units</b>: Exposure Value (EV)</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AE_EXPOSURE_COMPENSATION
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<android.util.Rational> CONTROL_AE_COMPENSATION_STEP;
static { CONTROL_AE_COMPENSATION_STEP = null; }

/**
 * <p>Whether the camera device supports {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_LOCK CaptureRequest#CONTROL_AE_LOCK}</p>
 * <p>Devices with MANUAL_SENSOR capability or BURST_CAPTURE capability will always
 * list <code>true</code>. This includes FULL devices.</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AE_LOCK
 * @apiSince 23
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.Boolean> CONTROL_AE_LOCK_AVAILABLE;
static { CONTROL_AE_LOCK_AVAILABLE = null; }

/**
 * <p>List of auto-focus (AF) modes for {@link android.hardware.camera2.CaptureRequest#CONTROL_AF_MODE CaptureRequest#CONTROL_AF_MODE} that are
 * supported by this camera device.</p>
 * <p>Not all the auto-focus modes may be supported by a
 * given camera device. This entry lists the valid modes for
 * {@link android.hardware.camera2.CaptureRequest#CONTROL_AF_MODE CaptureRequest#CONTROL_AF_MODE} for this camera device.</p>
 * <p>All LIMITED and FULL mode camera devices will support OFF mode, and all
 * camera devices with adjustable focuser units
 * (<code>{@link android.hardware.camera2.CameraCharacteristics#LENS_INFO_MINIMUM_FOCUS_DISTANCE CameraCharacteristics#LENS_INFO_MINIMUM_FOCUS_DISTANCE} &gt; 0</code>) will support AUTO mode.</p>
 * <p>LEGACY devices will support OFF mode only if they support
 * focusing to infinity (by also setting {@link android.hardware.camera2.CaptureRequest#LENS_FOCUS_DISTANCE CaptureRequest#LENS_FOCUS_DISTANCE} to
 * <code>0.0f</code>).</p>
 * <p><b>Range of valid values:</b><br>
 * Any value listed in {@link android.hardware.camera2.CaptureRequest#CONTROL_AF_MODE CaptureRequest#CONTROL_AF_MODE}</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AF_MODE
 * @see android.hardware.camera2.CaptureRequest#LENS_FOCUS_DISTANCE
 * @see android.hardware.camera2.CameraCharacteristics#LENS_INFO_MINIMUM_FOCUS_DISTANCE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<int[]> CONTROL_AF_AVAILABLE_MODES;
static { CONTROL_AF_AVAILABLE_MODES = null; }

/**
 * <p>List of color effects for {@link android.hardware.camera2.CaptureRequest#CONTROL_EFFECT_MODE CaptureRequest#CONTROL_EFFECT_MODE} that are supported by this camera
 * device.</p>
 * <p>This list contains the color effect modes that can be applied to
 * images produced by the camera device.
 * Implementations are not expected to be consistent across all devices.
 * If no color effect modes are available for a device, this will only list
 * OFF.</p>
 * <p>A color effect will only be applied if
 * {@link android.hardware.camera2.CaptureRequest#CONTROL_MODE CaptureRequest#CONTROL_MODE} != OFF.  OFF is always included in this list.</p>
 * <p>This control has no effect on the operation of other control routines such
 * as auto-exposure, white balance, or focus.</p>
 * <p><b>Range of valid values:</b><br>
 * Any value listed in {@link android.hardware.camera2.CaptureRequest#CONTROL_EFFECT_MODE CaptureRequest#CONTROL_EFFECT_MODE}</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_EFFECT_MODE
 * @see android.hardware.camera2.CaptureRequest#CONTROL_MODE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<int[]> CONTROL_AVAILABLE_EFFECTS;
static { CONTROL_AVAILABLE_EFFECTS = null; }

/**
 * <p>List of control modes for {@link android.hardware.camera2.CaptureRequest#CONTROL_MODE CaptureRequest#CONTROL_MODE} that are supported by this camera
 * device.</p>
 * <p>This list contains control modes that can be set for the camera device.
 * LEGACY mode devices will always support AUTO mode. LIMITED and FULL
 * devices will always support OFF, AUTO modes.</p>
 * <p><b>Range of valid values:</b><br>
 * Any value listed in {@link android.hardware.camera2.CaptureRequest#CONTROL_MODE CaptureRequest#CONTROL_MODE}</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_MODE
 * @apiSince 23
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<int[]> CONTROL_AVAILABLE_MODES;
static { CONTROL_AVAILABLE_MODES = null; }

/**
 * <p>List of scene modes for {@link android.hardware.camera2.CaptureRequest#CONTROL_SCENE_MODE CaptureRequest#CONTROL_SCENE_MODE} that are supported by this camera
 * device.</p>
 * <p>This list contains scene modes that can be set for the camera device.
 * Only scene modes that have been fully implemented for the
 * camera device may be included here. Implementations are not expected
 * to be consistent across all devices.</p>
 * <p>If no scene modes are supported by the camera device, this
 * will be set to DISABLED. Otherwise DISABLED will not be listed.</p>
 * <p>FACE_PRIORITY is always listed if face detection is
 * supported (i.e.<code>{@link android.hardware.camera2.CameraCharacteristics#STATISTICS_INFO_MAX_FACE_COUNT CameraCharacteristics#STATISTICS_INFO_MAX_FACE_COUNT} &gt;
 * 0</code>).</p>
 * <p><b>Range of valid values:</b><br>
 * Any value listed in {@link android.hardware.camera2.CaptureRequest#CONTROL_SCENE_MODE CaptureRequest#CONTROL_SCENE_MODE}</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_SCENE_MODE
 * @see android.hardware.camera2.CameraCharacteristics#STATISTICS_INFO_MAX_FACE_COUNT
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<int[]> CONTROL_AVAILABLE_SCENE_MODES;
static { CONTROL_AVAILABLE_SCENE_MODES = null; }

/**
 * <p>List of video stabilization modes for {@link android.hardware.camera2.CaptureRequest#CONTROL_VIDEO_STABILIZATION_MODE CaptureRequest#CONTROL_VIDEO_STABILIZATION_MODE}
 * that are supported by this camera device.</p>
 * <p>OFF will always be listed.</p>
 * <p><b>Range of valid values:</b><br>
 * Any value listed in {@link android.hardware.camera2.CaptureRequest#CONTROL_VIDEO_STABILIZATION_MODE CaptureRequest#CONTROL_VIDEO_STABILIZATION_MODE}</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_VIDEO_STABILIZATION_MODE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<int[]> CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES;
static { CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES = null; }

/**
 * <p>List of auto-white-balance modes for {@link android.hardware.camera2.CaptureRequest#CONTROL_AWB_MODE CaptureRequest#CONTROL_AWB_MODE} that are supported by this
 * camera device.</p>
 * <p>Not all the auto-white-balance modes may be supported by a
 * given camera device. This entry lists the valid modes for
 * {@link android.hardware.camera2.CaptureRequest#CONTROL_AWB_MODE CaptureRequest#CONTROL_AWB_MODE} for this camera device.</p>
 * <p>All camera devices will support ON mode.</p>
 * <p>Camera devices that support the MANUAL_POST_PROCESSING capability will always support OFF
 * mode, which enables application control of white balance, by using
 * {@link android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_TRANSFORM CaptureRequest#COLOR_CORRECTION_TRANSFORM} and {@link android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_GAINS CaptureRequest#COLOR_CORRECTION_GAINS}({@link android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_MODE CaptureRequest#COLOR_CORRECTION_MODE} must be set to TRANSFORM_MATRIX). This includes all FULL
 * mode camera devices.</p>
 * <p><b>Range of valid values:</b><br>
 * Any value listed in {@link android.hardware.camera2.CaptureRequest#CONTROL_AWB_MODE CaptureRequest#CONTROL_AWB_MODE}</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_GAINS
 * @see android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_MODE
 * @see android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_TRANSFORM
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AWB_MODE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<int[]> CONTROL_AWB_AVAILABLE_MODES;
static { CONTROL_AWB_AVAILABLE_MODES = null; }

/**
 * <p>Whether the camera device supports {@link android.hardware.camera2.CaptureRequest#CONTROL_AWB_LOCK CaptureRequest#CONTROL_AWB_LOCK}</p>
 * <p>Devices with MANUAL_POST_PROCESSING capability or BURST_CAPTURE capability will
 * always list <code>true</code>. This includes FULL devices.</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AWB_LOCK
 * @apiSince 23
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.Boolean> CONTROL_AWB_LOCK_AVAILABLE;
static { CONTROL_AWB_LOCK_AVAILABLE = null; }

/**
 * <p>The maximum number of metering regions that can be used by the auto-exposure (AE)
 * routine.</p>
 * <p>This corresponds to the the maximum allowed number of elements in
 * {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_REGIONS CaptureRequest#CONTROL_AE_REGIONS}.</p>
 * <p><b>Range of valid values:</b><br>
 * Value will be &gt;= 0. For FULL-capability devices, this
 * value will be &gt;= 1.</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AE_REGIONS
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.Integer> CONTROL_MAX_REGIONS_AE;
static { CONTROL_MAX_REGIONS_AE = null; }

/**
 * <p>The maximum number of metering regions that can be used by the auto-focus (AF) routine.</p>
 * <p>This corresponds to the the maximum allowed number of elements in
 * {@link android.hardware.camera2.CaptureRequest#CONTROL_AF_REGIONS CaptureRequest#CONTROL_AF_REGIONS}.</p>
 * <p><b>Range of valid values:</b><br>
 * Value will be &gt;= 0. For FULL-capability devices, this
 * value will be &gt;= 1.</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AF_REGIONS
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.Integer> CONTROL_MAX_REGIONS_AF;
static { CONTROL_MAX_REGIONS_AF = null; }

/**
 * <p>The maximum number of metering regions that can be used by the auto-white balance (AWB)
 * routine.</p>
 * <p>This corresponds to the the maximum allowed number of elements in
 * {@link android.hardware.camera2.CaptureRequest#CONTROL_AWB_REGIONS CaptureRequest#CONTROL_AWB_REGIONS}.</p>
 * <p><b>Range of valid values:</b><br>
 * Value will be &gt;= 0.</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AWB_REGIONS
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.Integer> CONTROL_MAX_REGIONS_AWB;
static { CONTROL_MAX_REGIONS_AWB = null; }

/**
 * <p>Range of boosts for {@link android.hardware.camera2.CaptureRequest#CONTROL_POST_RAW_SENSITIVITY_BOOST CaptureRequest#CONTROL_POST_RAW_SENSITIVITY_BOOST} supported
 * by this camera device.</p>
 * <p>Devices support post RAW sensitivity boost  will advertise
 * {@link android.hardware.camera2.CaptureRequest#CONTROL_POST_RAW_SENSITIVITY_BOOST CaptureRequest#CONTROL_POST_RAW_SENSITIVITY_BOOST} key for controling
 * post RAW sensitivity boost.</p>
 * <p>This key will be <code>null</code> for devices that do not support any RAW format
 * outputs. For devices that do support RAW format outputs, this key will always
 * present, and if a device does not support post RAW sensitivity boost, it will
 * list <code>(100, 100)</code> in this key.</p>
 * <p><b>Units</b>: ISO arithmetic units, the same as {@link android.hardware.camera2.CaptureRequest#SENSOR_SENSITIVITY CaptureRequest#SENSOR_SENSITIVITY}</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_POST_RAW_SENSITIVITY_BOOST
 * @see android.hardware.camera2.CaptureRequest#SENSOR_SENSITIVITY
 * @apiSince 24
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<android.util.Range<java.lang.Integer>> CONTROL_POST_RAW_SENSITIVITY_BOOST_RANGE;
static { CONTROL_POST_RAW_SENSITIVITY_BOOST_RANGE = null; }

/**
 * <p>Indicates whether a capture request may target both a
 * DEPTH16 / DEPTH_POINT_CLOUD output, and normal color outputs (such as
 * YUV_420_888, JPEG, or RAW) simultaneously.</p>
 * <p>If TRUE, including both depth and color outputs in a single
 * capture request is not supported. An application must interleave color
 * and depth requests.  If FALSE, a single request can target both types
 * of output.</p>
 * <p>Typically, this restriction exists on camera devices that
 * need to emit a specific pattern or wavelength of light to
 * measure depth values, which causes the color image to be
 * corrupted during depth measurement.</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Limited capability</b> -
 * Present on all camera devices that report being at least {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @apiSince 23
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.Boolean> DEPTH_DEPTH_IS_EXCLUSIVE;
static { DEPTH_DEPTH_IS_EXCLUSIVE = null; }

/**
 * <p>List of distortion correction modes for {@link android.hardware.camera2.CaptureRequest#DISTORTION_CORRECTION_MODE CaptureRequest#DISTORTION_CORRECTION_MODE} that are
 * supported by this camera device.</p>
 * <p>No device is required to support this API; such devices will always list only 'OFF'.
 * All devices that support this API will list both FAST and HIGH_QUALITY.</p>
 * <p><b>Range of valid values:</b><br>
 * Any value listed in {@link android.hardware.camera2.CaptureRequest#DISTORTION_CORRECTION_MODE CaptureRequest#DISTORTION_CORRECTION_MODE}</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#DISTORTION_CORRECTION_MODE
 * @apiSince 28
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<int[]> DISTORTION_CORRECTION_AVAILABLE_MODES;
static { DISTORTION_CORRECTION_AVAILABLE_MODES = null; }

/**
 * <p>List of edge enhancement modes for {@link android.hardware.camera2.CaptureRequest#EDGE_MODE CaptureRequest#EDGE_MODE} that are supported by this camera
 * device.</p>
 * <p>Full-capability camera devices must always support OFF; camera devices that support
 * YUV_REPROCESSING or PRIVATE_REPROCESSING will list ZERO_SHUTTER_LAG; all devices will
 * list FAST.</p>
 * <p><b>Range of valid values:</b><br>
 * Any value listed in {@link android.hardware.camera2.CaptureRequest#EDGE_MODE CaptureRequest#EDGE_MODE}</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Full capability</b> -
 * Present on all camera devices that report being {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CaptureRequest#EDGE_MODE
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<int[]> EDGE_AVAILABLE_EDGE_MODES;
static { EDGE_AVAILABLE_EDGE_MODES = null; }

/**
 * <p>Whether this camera device has a
 * flash unit.</p>
 * <p>Will be <code>false</code> if no flash is available.</p>
 * <p>If there is no flash unit, none of the flash controls do
 * anything.
 * This key is available on all devices.</p>
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.Boolean> FLASH_INFO_AVAILABLE;
static { FLASH_INFO_AVAILABLE = null; }

/**
 * <p>List of hot pixel correction modes for {@link android.hardware.camera2.CaptureRequest#HOT_PIXEL_MODE CaptureRequest#HOT_PIXEL_MODE} that are supported by this
 * camera device.</p>
 * <p>FULL mode camera devices will always support FAST.</p>
 * <p><b>Range of valid values:</b><br>
 * Any value listed in {@link android.hardware.camera2.CaptureRequest#HOT_PIXEL_MODE CaptureRequest#HOT_PIXEL_MODE}</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#HOT_PIXEL_MODE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<int[]> HOT_PIXEL_AVAILABLE_HOT_PIXEL_MODES;
static { HOT_PIXEL_AVAILABLE_HOT_PIXEL_MODES = null; }

/**
 * <p>Generally classifies the overall set of the camera device functionality.</p>
 * <p>The supported hardware level is a high-level description of the camera device's
 * capabilities, summarizing several capabilities into one field.  Each level adds additional
 * features to the previous one, and is always a strict superset of the previous level.
 * The ordering is <code>LEGACY &lt; LIMITED &lt; FULL &lt; LEVEL_3</code>.</p>
 * <p>Starting from <code>LEVEL_3</code>, the level enumerations are guaranteed to be in increasing
 * numerical value as well. To check if a given device is at least at a given hardware level,
 * the following code snippet can be used:</p>
 * <pre><code>// Returns true if the device supports the required hardware level, or better.
 * boolean isHardwareLevelSupported(CameraCharacteristics c, int requiredLevel) {
 *     final int[] sortedHwLevels = {
 *         CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY,
 *         CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL_EXTERNAL,
 *         CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED,
 *         CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL_FULL,
 *         CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL_3
 *     };
 *     int deviceLevel = c.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
 *     if (requiredLevel == deviceLevel) {
 *         return true;
 *     }
 *
 *     for (int sortedlevel : sortedHwLevels) {
 *         if (sortedlevel == requiredLevel) {
 *             return true;
 *         } else if (sortedlevel == deviceLevel) {
 *             return false;
 *         }
 *     }
 *     return false; // Should never reach here
 * }
 * </code></pre>
 * <p>At a high level, the levels are:</p>
 * <ul>
 * <li><code>LEGACY</code> devices operate in a backwards-compatibility mode for older
 *   Android devices, and have very limited capabilities.</li>
 * <li><code>LIMITED</code> devices represent the
 *   baseline feature set, and may also include additional capabilities that are
 *   subsets of <code>FULL</code>.</li>
 * <li><code>FULL</code> devices additionally support per-frame manual control of sensor, flash, lens and
 *   post-processing settings, and image capture at a high rate.</li>
 * <li><code>LEVEL_3</code> devices additionally support YUV reprocessing and RAW image capture, along
 *   with additional output stream configurations.</li>
 * <li><code>EXTERNAL</code> devices are similar to <code>LIMITED</code> devices with exceptions like some sensor or
 *   lens information not reported or less stable framerates.</li>
 * </ul>
 * <p>See the individual level enums for full descriptions of the supported capabilities.  The
 * {@link android.hardware.camera2.CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES} entry describes the device's capabilities at a
 * finer-grain level, if needed. In addition, many controls have their available settings or
 * ranges defined in individual entries from {@link android.hardware.camera2.CameraCharacteristics }.</p>
 * <p>Some features are not part of any particular hardware level or capability and must be
 * queried separately. These include:</p>
 * <ul>
 * <li>Calibrated timestamps ({@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_TIMESTAMP_SOURCE CameraCharacteristics#SENSOR_INFO_TIMESTAMP_SOURCE} <code>==</code> REALTIME)</li>
 * <li>Precision lens control ({@link android.hardware.camera2.CameraCharacteristics#LENS_INFO_FOCUS_DISTANCE_CALIBRATION CameraCharacteristics#LENS_INFO_FOCUS_DISTANCE_CALIBRATION} <code>==</code> CALIBRATED)</li>
 * <li>Face detection ({@link android.hardware.camera2.CameraCharacteristics#STATISTICS_INFO_AVAILABLE_FACE_DETECT_MODES CameraCharacteristics#STATISTICS_INFO_AVAILABLE_FACE_DETECT_MODES})</li>
 * <li>Optical or electrical image stabilization
 *   ({@link android.hardware.camera2.CameraCharacteristics#LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION CameraCharacteristics#LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION},
 *    {@link android.hardware.camera2.CameraCharacteristics#CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES CameraCharacteristics#CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES})</li>
 * </ul>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED LIMITED}</li>
 *   <li>{@link #INFO_SUPPORTED_HARDWARE_LEVEL_FULL FULL}</li>
 *   <li>{@link #INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY LEGACY}</li>
 *   <li>{@link #INFO_SUPPORTED_HARDWARE_LEVEL_3 3}</li>
 *   <li>{@link #INFO_SUPPORTED_HARDWARE_LEVEL_EXTERNAL EXTERNAL}</li>
 * </ul></p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES
 * @see android.hardware.camera2.CameraCharacteristics#LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION
 * @see android.hardware.camera2.CameraCharacteristics#LENS_INFO_FOCUS_DISTANCE_CALIBRATION
 * @see android.hardware.camera2.CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_TIMESTAMP_SOURCE
 * @see android.hardware.camera2.CameraCharacteristics#STATISTICS_INFO_AVAILABLE_FACE_DETECT_MODES
 * @see #INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED
 * @see #INFO_SUPPORTED_HARDWARE_LEVEL_FULL
 * @see #INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY
 * @see #INFO_SUPPORTED_HARDWARE_LEVEL_3
 * @see #INFO_SUPPORTED_HARDWARE_LEVEL_EXTERNAL
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.Integer> INFO_SUPPORTED_HARDWARE_LEVEL;
static { INFO_SUPPORTED_HARDWARE_LEVEL = null; }

/**
 * <p>A short string for manufacturer version information about the camera device, such as
 * ISP hardware, sensors, etc.</p>
 * <p>This can be used in {@link android.media.ExifInterface#TAG_IMAGE_DESCRIPTION TAG_IMAGE_DESCRIPTION}
 * in jpeg EXIF. This key may be absent if no version information is available on the
 * device.</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * @apiSince 28
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.String> INFO_VERSION;
static { INFO_VERSION = null; }

/**
 * <p>List of JPEG thumbnail sizes for {@link android.hardware.camera2.CaptureRequest#JPEG_THUMBNAIL_SIZE CaptureRequest#JPEG_THUMBNAIL_SIZE} supported by this
 * camera device.</p>
 * <p>This list will include at least one non-zero resolution, plus <code>(0,0)</code> for indicating no
 * thumbnail should be generated.</p>
 * <p>Below condiditions will be satisfied for this size list:</p>
 * <ul>
 * <li>The sizes will be sorted by increasing pixel area (width x height).
 * If several resolutions have the same area, they will be sorted by increasing width.</li>
 * <li>The aspect ratio of the largest thumbnail size will be same as the
 * aspect ratio of largest JPEG output size in android.scaler.availableStreamConfigurations.
 * The largest size is defined as the size that has the largest pixel area
 * in a given size list.</li>
 * <li>Each output JPEG size in android.scaler.availableStreamConfigurations will have at least
 * one corresponding size that has the same aspect ratio in availableThumbnailSizes,
 * and vice versa.</li>
 * <li>All non-<code>(0, 0)</code> sizes will have non-zero widths and heights.</li>
 * </ul>
 * <p>This list is also used as supported thumbnail sizes for HEIC image format capture.</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#JPEG_THUMBNAIL_SIZE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<android.util.Size[]> JPEG_AVAILABLE_THUMBNAIL_SIZES;
static { JPEG_AVAILABLE_THUMBNAIL_SIZES = null; }

/**
 * <p>The correction coefficients to correct for this camera device's
 * radial and tangential lens distortion.</p>
 * <p>Replaces the deprecated {@link android.hardware.camera2.CameraCharacteristics#LENS_RADIAL_DISTORTION CameraCharacteristics#LENS_RADIAL_DISTORTION} field, which was
 * inconsistently defined.</p>
 * <p>Three radial distortion coefficients <code>[kappa_1, kappa_2,
 * kappa_3]</code> and two tangential distortion coefficients
 * <code>[kappa_4, kappa_5]</code> that can be used to correct the
 * lens's geometric distortion with the mapping equations:</p>
 * <pre><code> x_c = x_i * ( 1 + kappa_1 * r^2 + kappa_2 * r^4 + kappa_3 * r^6 ) +
 *        kappa_4 * (2 * x_i * y_i) + kappa_5 * ( r^2 + 2 * x_i^2 )
 *  y_c = y_i * ( 1 + kappa_1 * r^2 + kappa_2 * r^4 + kappa_3 * r^6 ) +
 *        kappa_5 * (2 * x_i * y_i) + kappa_4 * ( r^2 + 2 * y_i^2 )
 * </code></pre>
 * <p>Here, <code>[x_c, y_c]</code> are the coordinates to sample in the
 * input image that correspond to the pixel values in the
 * corrected image at the coordinate <code>[x_i, y_i]</code>:</p>
 * <pre><code> correctedImage(x_i, y_i) = sample_at(x_c, y_c, inputImage)
 * </code></pre>
 * <p>The pixel coordinates are defined in a coordinate system
 * related to the {@link android.hardware.camera2.CameraCharacteristics#LENS_INTRINSIC_CALIBRATION CameraCharacteristics#LENS_INTRINSIC_CALIBRATION}
 * calibration fields; see that entry for details of the mapping stages.
 * Both <code>[x_i, y_i]</code> and <code>[x_c, y_c]</code>
 * have <code>(0,0)</code> at the lens optical center <code>[c_x, c_y]</code>, and
 * the range of the coordinates depends on the focal length
 * terms of the intrinsic calibration.</p>
 * <p>Finally, <code>r</code> represents the radial distance from the
 * optical center, <code>r^2 = x_i^2 + y_i^2</code>.</p>
 * <p>The distortion model used is the Brown-Conrady model.</p>
 * <p><b>Units</b>:
 * Unitless coefficients.</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Permission {@link android.Manifest.permission#CAMERA } is needed to access this property</b></p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#LENS_INTRINSIC_CALIBRATION
 * @see android.hardware.camera2.CameraCharacteristics#LENS_RADIAL_DISTORTION
 * @apiSince 28
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<float[]> LENS_DISTORTION;
static { LENS_DISTORTION = null; }

/**
 * <p>Direction the camera faces relative to
 * device screen.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #LENS_FACING_FRONT FRONT}</li>
 *   <li>{@link #LENS_FACING_BACK BACK}</li>
 *   <li>{@link #LENS_FACING_EXTERNAL EXTERNAL}</li>
 * </ul></p>
 * <p>This key is available on all devices.</p>
 * @see #LENS_FACING_FRONT
 * @see #LENS_FACING_BACK
 * @see #LENS_FACING_EXTERNAL
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.Integer> LENS_FACING;
static { LENS_FACING = null; }

/**
 * <p>List of aperture size values for {@link android.hardware.camera2.CaptureRequest#LENS_APERTURE CaptureRequest#LENS_APERTURE} that are
 * supported by this camera device.</p>
 * <p>If the camera device doesn't support a variable lens aperture,
 * this list will contain only one value, which is the fixed aperture size.</p>
 * <p>If the camera device supports a variable aperture, the aperture values
 * in this list will be sorted in ascending order.</p>
 * <p><b>Units</b>: The aperture f-number</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Full capability</b> -
 * Present on all camera devices that report being {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see android.hardware.camera2.CaptureRequest#LENS_APERTURE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<float[]> LENS_INFO_AVAILABLE_APERTURES;
static { LENS_INFO_AVAILABLE_APERTURES = null; }

/**
 * <p>List of neutral density filter values for
 * {@link android.hardware.camera2.CaptureRequest#LENS_FILTER_DENSITY CaptureRequest#LENS_FILTER_DENSITY} that are supported by this camera device.</p>
 * <p>If a neutral density filter is not supported by this camera device,
 * this list will contain only 0. Otherwise, this list will include every
 * filter density supported by the camera device, in ascending order.</p>
 * <p><b>Units</b>: Exposure value (EV)</p>
 * <p><b>Range of valid values:</b><br></p>
 * <p>Values are &gt;= 0</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Full capability</b> -
 * Present on all camera devices that report being {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see android.hardware.camera2.CaptureRequest#LENS_FILTER_DENSITY
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<float[]> LENS_INFO_AVAILABLE_FILTER_DENSITIES;
static { LENS_INFO_AVAILABLE_FILTER_DENSITIES = null; }

/**
 * <p>List of focal lengths for {@link android.hardware.camera2.CaptureRequest#LENS_FOCAL_LENGTH CaptureRequest#LENS_FOCAL_LENGTH} that are supported by this camera
 * device.</p>
 * <p>If optical zoom is not supported, this list will only contain
 * a single value corresponding to the fixed focal length of the
 * device. Otherwise, this list will include every focal length supported
 * by the camera device, in ascending order.</p>
 * <p><b>Units</b>: Millimeters</p>
 * <p><b>Range of valid values:</b><br></p>
 * <p>Values are &gt; 0</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#LENS_FOCAL_LENGTH
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<float[]> LENS_INFO_AVAILABLE_FOCAL_LENGTHS;
static { LENS_INFO_AVAILABLE_FOCAL_LENGTHS = null; }

/**
 * <p>List of optical image stabilization (OIS) modes for
 * {@link android.hardware.camera2.CaptureRequest#LENS_OPTICAL_STABILIZATION_MODE CaptureRequest#LENS_OPTICAL_STABILIZATION_MODE} that are supported by this camera device.</p>
 * <p>If OIS is not supported by a given camera device, this list will
 * contain only OFF.</p>
 * <p><b>Range of valid values:</b><br>
 * Any value listed in {@link android.hardware.camera2.CaptureRequest#LENS_OPTICAL_STABILIZATION_MODE CaptureRequest#LENS_OPTICAL_STABILIZATION_MODE}</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Limited capability</b> -
 * Present on all camera devices that report being at least {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see android.hardware.camera2.CaptureRequest#LENS_OPTICAL_STABILIZATION_MODE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<int[]> LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION;
static { LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION = null; }

/**
 * <p>The lens focus distance calibration quality.</p>
 * <p>The lens focus distance calibration quality determines the reliability of
 * focus related metadata entries, i.e. {@link android.hardware.camera2.CaptureRequest#LENS_FOCUS_DISTANCE CaptureRequest#LENS_FOCUS_DISTANCE},
 * {@link android.hardware.camera2.CaptureResult#LENS_FOCUS_RANGE CaptureResult#LENS_FOCUS_RANGE}, {@link android.hardware.camera2.CameraCharacteristics#LENS_INFO_HYPERFOCAL_DISTANCE CameraCharacteristics#LENS_INFO_HYPERFOCAL_DISTANCE}, and
 * {@link android.hardware.camera2.CameraCharacteristics#LENS_INFO_MINIMUM_FOCUS_DISTANCE CameraCharacteristics#LENS_INFO_MINIMUM_FOCUS_DISTANCE}.</p>
 * <p>APPROXIMATE and CALIBRATED devices report the focus metadata in
 * units of diopters (1/meter), so <code>0.0f</code> represents focusing at infinity,
 * and increasing positive numbers represent focusing closer and closer
 * to the camera device. The focus distance control also uses diopters
 * on these devices.</p>
 * <p>UNCALIBRATED devices do not use units that are directly comparable
 * to any real physical measurement, but <code>0.0f</code> still represents farthest
 * focus, and {@link android.hardware.camera2.CameraCharacteristics#LENS_INFO_MINIMUM_FOCUS_DISTANCE CameraCharacteristics#LENS_INFO_MINIMUM_FOCUS_DISTANCE} represents the
 * nearest focus the device can achieve.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #LENS_INFO_FOCUS_DISTANCE_CALIBRATION_UNCALIBRATED UNCALIBRATED}</li>
 *   <li>{@link #LENS_INFO_FOCUS_DISTANCE_CALIBRATION_APPROXIMATE APPROXIMATE}</li>
 *   <li>{@link #LENS_INFO_FOCUS_DISTANCE_CALIBRATION_CALIBRATED CALIBRATED}</li>
 * </ul></p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Limited capability</b> -
 * Present on all camera devices that report being at least {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see android.hardware.camera2.CaptureRequest#LENS_FOCUS_DISTANCE
 * @see android.hardware.camera2.CaptureResult#LENS_FOCUS_RANGE
 * @see android.hardware.camera2.CameraCharacteristics#LENS_INFO_HYPERFOCAL_DISTANCE
 * @see android.hardware.camera2.CameraCharacteristics#LENS_INFO_MINIMUM_FOCUS_DISTANCE
 * @see #LENS_INFO_FOCUS_DISTANCE_CALIBRATION_UNCALIBRATED
 * @see #LENS_INFO_FOCUS_DISTANCE_CALIBRATION_APPROXIMATE
 * @see #LENS_INFO_FOCUS_DISTANCE_CALIBRATION_CALIBRATED
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.Integer> LENS_INFO_FOCUS_DISTANCE_CALIBRATION;
static { LENS_INFO_FOCUS_DISTANCE_CALIBRATION = null; }

/**
 * <p>Hyperfocal distance for this lens.</p>
 * <p>If the lens is not fixed focus, the camera device will report this
 * field when {@link android.hardware.camera2.CameraCharacteristics#LENS_INFO_FOCUS_DISTANCE_CALIBRATION CameraCharacteristics#LENS_INFO_FOCUS_DISTANCE_CALIBRATION} is APPROXIMATE or CALIBRATED.</p>
 * <p><b>Units</b>: See {@link android.hardware.camera2.CameraCharacteristics#LENS_INFO_FOCUS_DISTANCE_CALIBRATION CameraCharacteristics#LENS_INFO_FOCUS_DISTANCE_CALIBRATION} for details</p>
 * <p><b>Range of valid values:</b><br>
 * If lens is fixed focus, &gt;= 0. If lens has focuser unit, the value is
 * within <code>(0.0f, {@link android.hardware.camera2.CameraCharacteristics#LENS_INFO_MINIMUM_FOCUS_DISTANCE CameraCharacteristics#LENS_INFO_MINIMUM_FOCUS_DISTANCE}]</code></p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Limited capability</b> -
 * Present on all camera devices that report being at least {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 * <p><b>Permission {@link android.Manifest.permission#CAMERA } is needed to access this property</b></p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see android.hardware.camera2.CameraCharacteristics#LENS_INFO_FOCUS_DISTANCE_CALIBRATION
 * @see android.hardware.camera2.CameraCharacteristics#LENS_INFO_MINIMUM_FOCUS_DISTANCE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.Float> LENS_INFO_HYPERFOCAL_DISTANCE;
static { LENS_INFO_HYPERFOCAL_DISTANCE = null; }

/**
 * <p>Shortest distance from frontmost surface
 * of the lens that can be brought into sharp focus.</p>
 * <p>If the lens is fixed-focus, this will be
 * 0.</p>
 * <p><b>Units</b>: See {@link android.hardware.camera2.CameraCharacteristics#LENS_INFO_FOCUS_DISTANCE_CALIBRATION CameraCharacteristics#LENS_INFO_FOCUS_DISTANCE_CALIBRATION} for details</p>
 * <p><b>Range of valid values:</b><br>
 * &gt;= 0</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Limited capability</b> -
 * Present on all camera devices that report being at least {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 * <p><b>Permission {@link android.Manifest.permission#CAMERA } is needed to access this property</b></p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see android.hardware.camera2.CameraCharacteristics#LENS_INFO_FOCUS_DISTANCE_CALIBRATION
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.Float> LENS_INFO_MINIMUM_FOCUS_DISTANCE;
static { LENS_INFO_MINIMUM_FOCUS_DISTANCE = null; }

/**
 * <p>The parameters for this camera device's intrinsic
 * calibration.</p>
 * <p>The five calibration parameters that describe the
 * transform from camera-centric 3D coordinates to sensor
 * pixel coordinates:</p>
 * <pre><code>[f_x, f_y, c_x, c_y, s]
 * </code></pre>
 * <p>Where <code>f_x</code> and <code>f_y</code> are the horizontal and vertical
 * focal lengths, <code>[c_x, c_y]</code> is the position of the optical
 * axis, and <code>s</code> is a skew parameter for the sensor plane not
 * being aligned with the lens plane.</p>
 * <p>These are typically used within a transformation matrix K:</p>
 * <pre><code>K = [ f_x,   s, c_x,
 *        0, f_y, c_y,
 *        0    0,   1 ]
 * </code></pre>
 * <p>which can then be combined with the camera pose rotation
 * <code>R</code> and translation <code>t</code> ({@link android.hardware.camera2.CameraCharacteristics#LENS_POSE_ROTATION CameraCharacteristics#LENS_POSE_ROTATION} and
 * {@link android.hardware.camera2.CameraCharacteristics#LENS_POSE_TRANSLATION CameraCharacteristics#LENS_POSE_TRANSLATION}, respectively) to calculate the
 * complete transform from world coordinates to pixel
 * coordinates:</p>
 * <pre><code>P = [ K 0   * [ R -Rt
 *      0 1 ]      0 1 ]
 * </code></pre>
 * <p>(Note the negation of poseTranslation when mapping from camera
 * to world coordinates, and multiplication by the rotation).</p>
 * <p>With <code>p_w</code> being a point in the world coordinate system
 * and <code>p_s</code> being a point in the camera active pixel array
 * coordinate system, and with the mapping including the
 * homogeneous division by z:</p>
 * <pre><code> p_h = (x_h, y_h, z_h) = P p_w
 * p_s = p_h / z_h
 * </code></pre>
 * <p>so <code>[x_s, y_s]</code> is the pixel coordinates of the world
 * point, <code>z_s = 1</code>, and <code>w_s</code> is a measurement of disparity
 * (depth) in pixel coordinates.</p>
 * <p>Note that the coordinate system for this transform is the
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE} system,
 * where <code>(0,0)</code> is the top-left of the
 * preCorrectionActiveArraySize rectangle. Once the pose and
 * intrinsic calibration transforms have been applied to a
 * world point, then the {@link android.hardware.camera2.CameraCharacteristics#LENS_DISTORTION CameraCharacteristics#LENS_DISTORTION}
 * transform needs to be applied, and the result adjusted to
 * be in the {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE} coordinate
 * system (where <code>(0, 0)</code> is the top-left of the
 * activeArraySize rectangle), to determine the final pixel
 * coordinate of the world point for processed (non-RAW)
 * output buffers.</p>
 * <p>For camera devices, the center of pixel <code>(x,y)</code> is located at
 * coordinate <code>(x + 0.5, y + 0.5)</code>.  So on a device with a
 * precorrection active array of size <code>(10,10)</code>, the valid pixel
 * indices go from <code>(0,0)-(9,9)</code>, and an perfectly-built camera would
 * have an optical center at the exact center of the pixel grid, at
 * coordinates <code>(5.0, 5.0)</code>, which is the top-left corner of pixel
 * <code>(5,5)</code>.</p>
 * <p><b>Units</b>:
 * Pixels in the
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE}
 * coordinate system.</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Permission {@link android.Manifest.permission#CAMERA } is needed to access this property</b></p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#LENS_DISTORTION
 * @see android.hardware.camera2.CameraCharacteristics#LENS_POSE_ROTATION
 * @see android.hardware.camera2.CameraCharacteristics#LENS_POSE_TRANSLATION
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE
 * @apiSince 23
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<float[]> LENS_INTRINSIC_CALIBRATION;
static { LENS_INTRINSIC_CALIBRATION = null; }

/**
 * <p>The origin for {@link android.hardware.camera2.CameraCharacteristics#LENS_POSE_TRANSLATION CameraCharacteristics#LENS_POSE_TRANSLATION}.</p>
 * <p>Different calibration methods and use cases can produce better or worse results
 * depending on the selected coordinate origin.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #LENS_POSE_REFERENCE_PRIMARY_CAMERA PRIMARY_CAMERA}</li>
 *   <li>{@link #LENS_POSE_REFERENCE_GYROSCOPE GYROSCOPE}</li>
 * </ul></p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Permission {@link android.Manifest.permission#CAMERA } is needed to access this property</b></p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#LENS_POSE_TRANSLATION
 * @see #LENS_POSE_REFERENCE_PRIMARY_CAMERA
 * @see #LENS_POSE_REFERENCE_GYROSCOPE
 * @apiSince 28
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.Integer> LENS_POSE_REFERENCE;
static { LENS_POSE_REFERENCE = null; }

/**
 * <p>The orientation of the camera relative to the sensor
 * coordinate system.</p>
 * <p>The four coefficients that describe the quaternion
 * rotation from the Android sensor coordinate system to a
 * camera-aligned coordinate system where the X-axis is
 * aligned with the long side of the image sensor, the Y-axis
 * is aligned with the short side of the image sensor, and
 * the Z-axis is aligned with the optical axis of the sensor.</p>
 * <p>To convert from the quaternion coefficients <code>(x,y,z,w)</code>
 * to the axis of rotation <code>(a_x, a_y, a_z)</code> and rotation
 * amount <code>theta</code>, the following formulas can be used:</p>
 * <pre><code> theta = 2 * acos(w)
 * a_x = x / sin(theta/2)
 * a_y = y / sin(theta/2)
 * a_z = z / sin(theta/2)
 * </code></pre>
 * <p>To create a 3x3 rotation matrix that applies the rotation
 * defined by this quaternion, the following matrix can be
 * used:</p>
 * <pre><code>R = [ 1 - 2y^2 - 2z^2,       2xy - 2zw,       2xz + 2yw,
 *            2xy + 2zw, 1 - 2x^2 - 2z^2,       2yz - 2xw,
 *            2xz - 2yw,       2yz + 2xw, 1 - 2x^2 - 2y^2 ]
 * </code></pre>
 * <p>This matrix can then be used to apply the rotation to a
 *  column vector point with</p>
 * <p><code>p' = Rp</code></p>
 * <p>where <code>p</code> is in the device sensor coordinate system, and
 *  <code>p'</code> is in the camera-oriented coordinate system.</p>
 * <p><b>Units</b>:
 * Quaternion coefficients</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Permission {@link android.Manifest.permission#CAMERA } is needed to access this property</b></p>
 * @apiSince 23
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<float[]> LENS_POSE_ROTATION;
static { LENS_POSE_ROTATION = null; }

/**
 * <p>Position of the camera optical center.</p>
 * <p>The position of the camera device's lens optical center,
 * as a three-dimensional vector <code>(x,y,z)</code>.</p>
 * <p>Prior to Android P, or when {@link android.hardware.camera2.CameraCharacteristics#LENS_POSE_REFERENCE CameraCharacteristics#LENS_POSE_REFERENCE} is PRIMARY_CAMERA, this position
 * is relative to the optical center of the largest camera device facing in the same
 * direction as this camera, in the {@link android.hardware.SensorEvent Android sensor
 * coordinate axes}. Note that only the axis definitions are shared with the sensor
 * coordinate system, but not the origin.</p>
 * <p>If this device is the largest or only camera device with a given facing, then this
 * position will be <code>(0, 0, 0)</code>; a camera device with a lens optical center located 3 cm
 * from the main sensor along the +X axis (to the right from the user's perspective) will
 * report <code>(0.03, 0, 0)</code>.  Note that this means that, for many computer vision
 * applications, the position needs to be negated to convert it to a translation from the
 * camera to the origin.</p>
 * <p>To transform a pixel coordinates between two cameras facing the same direction, first
 * the source camera {@link android.hardware.camera2.CameraCharacteristics#LENS_DISTORTION CameraCharacteristics#LENS_DISTORTION} must be corrected for.  Then the source
 * camera {@link android.hardware.camera2.CameraCharacteristics#LENS_INTRINSIC_CALIBRATION CameraCharacteristics#LENS_INTRINSIC_CALIBRATION} needs to be applied, followed by the
 * {@link android.hardware.camera2.CameraCharacteristics#LENS_POSE_ROTATION CameraCharacteristics#LENS_POSE_ROTATION} of the source camera, the translation of the source camera
 * relative to the destination camera, the {@link android.hardware.camera2.CameraCharacteristics#LENS_POSE_ROTATION CameraCharacteristics#LENS_POSE_ROTATION} of the destination
 * camera, and finally the inverse of {@link android.hardware.camera2.CameraCharacteristics#LENS_INTRINSIC_CALIBRATION CameraCharacteristics#LENS_INTRINSIC_CALIBRATION} of the destination
 * camera. This obtains a radial-distortion-free coordinate in the destination camera pixel
 * coordinates.</p>
 * <p>To compare this against a real image from the destination camera, the destination camera
 * image then needs to be corrected for radial distortion before comparison or sampling.</p>
 * <p>When {@link android.hardware.camera2.CameraCharacteristics#LENS_POSE_REFERENCE CameraCharacteristics#LENS_POSE_REFERENCE} is GYROSCOPE, then this position is relative to
 * the center of the primary gyroscope on the device. The axis definitions are the same as
 * with PRIMARY_CAMERA.</p>
 * <p><b>Units</b>: Meters</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Permission {@link android.Manifest.permission#CAMERA } is needed to access this property</b></p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#LENS_DISTORTION
 * @see android.hardware.camera2.CameraCharacteristics#LENS_INTRINSIC_CALIBRATION
 * @see android.hardware.camera2.CameraCharacteristics#LENS_POSE_REFERENCE
 * @see android.hardware.camera2.CameraCharacteristics#LENS_POSE_ROTATION
 * @apiSince 23
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<float[]> LENS_POSE_TRANSLATION;
static { LENS_POSE_TRANSLATION = null; }

/**
 * <p>The correction coefficients to correct for this camera device's
 * radial and tangential lens distortion.</p>
 * <p>Four radial distortion coefficients <code>[kappa_0, kappa_1, kappa_2,
 * kappa_3]</code> and two tangential distortion coefficients
 * <code>[kappa_4, kappa_5]</code> that can be used to correct the
 * lens's geometric distortion with the mapping equations:</p>
 * <pre><code> x_c = x_i * ( kappa_0 + kappa_1 * r^2 + kappa_2 * r^4 + kappa_3 * r^6 ) +
 *        kappa_4 * (2 * x_i * y_i) + kappa_5 * ( r^2 + 2 * x_i^2 )
 *  y_c = y_i * ( kappa_0 + kappa_1 * r^2 + kappa_2 * r^4 + kappa_3 * r^6 ) +
 *        kappa_5 * (2 * x_i * y_i) + kappa_4 * ( r^2 + 2 * y_i^2 )
 * </code></pre>
 * <p>Here, <code>[x_c, y_c]</code> are the coordinates to sample in the
 * input image that correspond to the pixel values in the
 * corrected image at the coordinate <code>[x_i, y_i]</code>:</p>
 * <pre><code> correctedImage(x_i, y_i) = sample_at(x_c, y_c, inputImage)
 * </code></pre>
 * <p>The pixel coordinates are defined in a normalized
 * coordinate system related to the
 * {@link android.hardware.camera2.CameraCharacteristics#LENS_INTRINSIC_CALIBRATION CameraCharacteristics#LENS_INTRINSIC_CALIBRATION} calibration fields.
 * Both <code>[x_i, y_i]</code> and <code>[x_c, y_c]</code> have <code>(0,0)</code> at the
 * lens optical center <code>[c_x, c_y]</code>. The maximum magnitudes
 * of both x and y coordinates are normalized to be 1 at the
 * edge further from the optical center, so the range
 * for both dimensions is <code>-1 &lt;= x &lt;= 1</code>.</p>
 * <p>Finally, <code>r</code> represents the radial distance from the
 * optical center, <code>r^2 = x_i^2 + y_i^2</code>, and its magnitude
 * is therefore no larger than <code>|r| &lt;= sqrt(2)</code>.</p>
 * <p>The distortion model used is the Brown-Conrady model.</p>
 * <p><b>Units</b>:
 * Unitless coefficients.</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Permission {@link android.Manifest.permission#CAMERA } is needed to access this property</b></p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#LENS_INTRINSIC_CALIBRATION
 * @deprecated
 * <p>This field was inconsistently defined in terms of its
 * normalization. Use {@link android.hardware.camera2.CameraCharacteristics#LENS_DISTORTION CameraCharacteristics#LENS_DISTORTION} instead.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#LENS_DISTORTION
 
 * @apiSince 23
 * @deprecatedSince 28
 */

@Deprecated @androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<float[]> LENS_RADIAL_DISTORTION;
static { LENS_RADIAL_DISTORTION = null; }

/**
 * <p>The accuracy of frame timestamp synchronization between physical cameras</p>
 * <p>The accuracy of the frame timestamp synchronization determines the physical cameras'
 * ability to start exposure at the same time. If the sensorSyncType is CALIBRATED,
 * the physical camera sensors usually run in master-slave mode so that their shutter
 * time is synchronized. For APPROXIMATE sensorSyncType, the camera sensors usually run in
 * master-master mode, and there could be offset between their start of exposure.</p>
 * <p>In both cases, all images generated for a particular capture request still carry the same
 * timestamps, so that they can be used to look up the matching frame number and
 * onCaptureStarted callback.</p>
 * <p>This tag is only applicable if the logical camera device supports concurrent physical
 * streams from different physical cameras.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #LOGICAL_MULTI_CAMERA_SENSOR_SYNC_TYPE_APPROXIMATE APPROXIMATE}</li>
 *   <li>{@link #LOGICAL_MULTI_CAMERA_SENSOR_SYNC_TYPE_CALIBRATED CALIBRATED}</li>
 * </ul></p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Limited capability</b> -
 * Present on all camera devices that report being at least {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see #LOGICAL_MULTI_CAMERA_SENSOR_SYNC_TYPE_APPROXIMATE
 * @see #LOGICAL_MULTI_CAMERA_SENSOR_SYNC_TYPE_CALIBRATED
 * @apiSince 28
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.Integer> LOGICAL_MULTI_CAMERA_SENSOR_SYNC_TYPE;
static { LOGICAL_MULTI_CAMERA_SENSOR_SYNC_TYPE = null; }

/**
 * <p>List of noise reduction modes for {@link android.hardware.camera2.CaptureRequest#NOISE_REDUCTION_MODE CaptureRequest#NOISE_REDUCTION_MODE} that are supported
 * by this camera device.</p>
 * <p>Full-capability camera devices will always support OFF and FAST.</p>
 * <p>Camera devices that support YUV_REPROCESSING or PRIVATE_REPROCESSING will support
 * ZERO_SHUTTER_LAG.</p>
 * <p>Legacy-capability camera devices will only support FAST mode.</p>
 * <p><b>Range of valid values:</b><br>
 * Any value listed in {@link android.hardware.camera2.CaptureRequest#NOISE_REDUCTION_MODE CaptureRequest#NOISE_REDUCTION_MODE}</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Limited capability</b> -
 * Present on all camera devices that report being at least {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see android.hardware.camera2.CaptureRequest#NOISE_REDUCTION_MODE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<int[]> NOISE_REDUCTION_AVAILABLE_NOISE_REDUCTION_MODES;
static { NOISE_REDUCTION_AVAILABLE_NOISE_REDUCTION_MODES = null; }

/**
 * <p>The maximal camera capture pipeline stall (in unit of frame count) introduced by a
 * reprocess capture request.</p>
 * <p>The key describes the maximal interference that one reprocess (input) request
 * can introduce to the camera simultaneous streaming of regular (output) capture
 * requests, including repeating requests.</p>
 * <p>When a reprocessing capture request is submitted while a camera output repeating request
 * (e.g. preview) is being served by the camera device, it may preempt the camera capture
 * pipeline for at least one frame duration so that the camera device is unable to process
 * the following capture request in time for the next sensor start of exposure boundary.
 * When this happens, the application may observe a capture time gap (longer than one frame
 * duration) between adjacent capture output frames, which usually exhibits as preview
 * glitch if the repeating request output targets include a preview surface. This key gives
 * the worst-case number of frame stall introduced by one reprocess request with any kind of
 * formats/sizes combination.</p>
 * <p>If this key reports 0, it means a reprocess request doesn't introduce any glitch to the
 * ongoing camera repeating request outputs, as if this reprocess request is never issued.</p>
 * <p>This key is supported if the camera device supports PRIVATE or YUV reprocessing (
 * i.e. {@link android.hardware.camera2.CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES} contains PRIVATE_REPROCESSING or
 * YUV_REPROCESSING).</p>
 * <p><b>Units</b>: Number of frames.</p>
 * <p><b>Range of valid values:</b><br>
 * &lt;= 4</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Limited capability</b> -
 * Present on all camera devices that report being at least {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see android.hardware.camera2.CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES
 * @apiSince 23
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.Integer> REPROCESS_MAX_CAPTURE_STALL;
static { REPROCESS_MAX_CAPTURE_STALL = null; }

/**
 * <p>List of capabilities that this camera device
 * advertises as fully supporting.</p>
 * <p>A capability is a contract that the camera device makes in order
 * to be able to satisfy one or more use cases.</p>
 * <p>Listing a capability guarantees that the whole set of features
 * required to support a common use will all be available.</p>
 * <p>Using a subset of the functionality provided by an unsupported
 * capability may be possible on a specific camera device implementation;
 * to do this query each of android.request.availableRequestKeys,
 * android.request.availableResultKeys,
 * android.request.availableCharacteristicsKeys.</p>
 * <p>The following capabilities are guaranteed to be available on
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} <code>==</code> FULL devices:</p>
 * <ul>
 * <li>MANUAL_SENSOR</li>
 * <li>MANUAL_POST_PROCESSING</li>
 * </ul>
 * <p>Other capabilities may be available on either FULL or LIMITED
 * devices, but the application should query this key to be sure.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #REQUEST_AVAILABLE_CAPABILITIES_BACKWARD_COMPATIBLE BACKWARD_COMPATIBLE}</li>
 *   <li>{@link #REQUEST_AVAILABLE_CAPABILITIES_MANUAL_SENSOR MANUAL_SENSOR}</li>
 *   <li>{@link #REQUEST_AVAILABLE_CAPABILITIES_MANUAL_POST_PROCESSING MANUAL_POST_PROCESSING}</li>
 *   <li>{@link #REQUEST_AVAILABLE_CAPABILITIES_RAW RAW}</li>
 *   <li>{@link #REQUEST_AVAILABLE_CAPABILITIES_PRIVATE_REPROCESSING PRIVATE_REPROCESSING}</li>
 *   <li>{@link #REQUEST_AVAILABLE_CAPABILITIES_READ_SENSOR_SETTINGS READ_SENSOR_SETTINGS}</li>
 *   <li>{@link #REQUEST_AVAILABLE_CAPABILITIES_BURST_CAPTURE BURST_CAPTURE}</li>
 *   <li>{@link #REQUEST_AVAILABLE_CAPABILITIES_YUV_REPROCESSING YUV_REPROCESSING}</li>
 *   <li>{@link #REQUEST_AVAILABLE_CAPABILITIES_DEPTH_OUTPUT DEPTH_OUTPUT}</li>
 *   <li>{@link #REQUEST_AVAILABLE_CAPABILITIES_CONSTRAINED_HIGH_SPEED_VIDEO CONSTRAINED_HIGH_SPEED_VIDEO}</li>
 *   <li>{@link #REQUEST_AVAILABLE_CAPABILITIES_MOTION_TRACKING MOTION_TRACKING}</li>
 *   <li>{@link #REQUEST_AVAILABLE_CAPABILITIES_LOGICAL_MULTI_CAMERA LOGICAL_MULTI_CAMERA}</li>
 *   <li>{@link #REQUEST_AVAILABLE_CAPABILITIES_MONOCHROME MONOCHROME}</li>
 *   <li>{@link #REQUEST_AVAILABLE_CAPABILITIES_SECURE_IMAGE_DATA SECURE_IMAGE_DATA}</li>
 * </ul></p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see #REQUEST_AVAILABLE_CAPABILITIES_BACKWARD_COMPATIBLE
 * @see #REQUEST_AVAILABLE_CAPABILITIES_MANUAL_SENSOR
 * @see #REQUEST_AVAILABLE_CAPABILITIES_MANUAL_POST_PROCESSING
 * @see #REQUEST_AVAILABLE_CAPABILITIES_RAW
 * @see #REQUEST_AVAILABLE_CAPABILITIES_PRIVATE_REPROCESSING
 * @see #REQUEST_AVAILABLE_CAPABILITIES_READ_SENSOR_SETTINGS
 * @see #REQUEST_AVAILABLE_CAPABILITIES_BURST_CAPTURE
 * @see #REQUEST_AVAILABLE_CAPABILITIES_YUV_REPROCESSING
 * @see #REQUEST_AVAILABLE_CAPABILITIES_DEPTH_OUTPUT
 * @see #REQUEST_AVAILABLE_CAPABILITIES_CONSTRAINED_HIGH_SPEED_VIDEO
 * @see #REQUEST_AVAILABLE_CAPABILITIES_MOTION_TRACKING
 * @see #REQUEST_AVAILABLE_CAPABILITIES_LOGICAL_MULTI_CAMERA
 * @see #REQUEST_AVAILABLE_CAPABILITIES_MONOCHROME
 * @see #REQUEST_AVAILABLE_CAPABILITIES_SECURE_IMAGE_DATA
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<int[]> REQUEST_AVAILABLE_CAPABILITIES;
static { REQUEST_AVAILABLE_CAPABILITIES = null; }

/**
 * <p>The maximum numbers of any type of input streams
 * that can be configured and used simultaneously by a camera device.</p>
 * <p>When set to 0, it means no input stream is supported.</p>
 * <p>The image format for a input stream can be any supported format returned by {@link android.hardware.camera2.params.StreamConfigurationMap#getInputFormats }. When using an
 * input stream, there must be at least one output stream configured to to receive the
 * reprocessed images.</p>
 * <p>When an input stream and some output streams are used in a reprocessing request,
 * only the input buffer will be used to produce these output stream buffers, and a
 * new sensor image will not be captured.</p>
 * <p>For example, for Zero Shutter Lag (ZSL) still capture use case, the input
 * stream image format will be PRIVATE, the associated output stream image format
 * should be JPEG.</p>
 * <p><b>Range of valid values:</b><br></p>
 * <p>0 or 1.</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Full capability</b> -
 * Present on all camera devices that report being {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @apiSince 23
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.Integer> REQUEST_MAX_NUM_INPUT_STREAMS;
static { REQUEST_MAX_NUM_INPUT_STREAMS = null; }

/**
 * <p>The maximum numbers of different types of output streams
 * that can be configured and used simultaneously by a camera device
 * for any processed (but not-stalling) formats.</p>
 * <p>This value contains the max number of output simultaneous
 * streams for any processed (but not-stalling) formats.</p>
 * <p>This lists the upper bound of the number of output streams supported by
 * the camera device. Using more streams simultaneously may require more hardware and
 * CPU resources that will consume more power. The image format for this kind of an output stream can
 * be any non-<code>RAW</code> and supported format provided by {@link android.hardware.camera2.CameraCharacteristics#SCALER_STREAM_CONFIGURATION_MAP CameraCharacteristics#SCALER_STREAM_CONFIGURATION_MAP}.</p>
 * <p>Processed (but not-stalling) is defined as any non-RAW format without a stall duration.
 * Typically:</p>
 * <ul>
 * <li>{@link android.graphics.ImageFormat#YUV_420_888 YUV_420_888}</li>
 * <li>{@link android.graphics.ImageFormat#NV21 NV21}</li>
 * <li>{@link android.graphics.ImageFormat#YV12 YV12}</li>
 * <li>Implementation-defined formats, i.e. {@link android.hardware.camera2.params.StreamConfigurationMap#isOutputSupportedFor(Class) }</li>
 * <li>{@link android.graphics.ImageFormat#Y8 Y8}</li>
 * </ul>
 * <p>For full guarantees, query {@link android.hardware.camera2.params.StreamConfigurationMap#getOutputStallDuration } with a
 * processed format -- it will return 0 for a non-stalling stream.</p>
 * <p>LEGACY devices will support at least 2 processing/non-stalling streams.</p>
 * <p><b>Range of valid values:</b><br></p>
 * <p>&gt;= 3
 * for FULL mode devices (<code>{@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} == FULL</code>);
 * &gt;= 2 for LIMITED mode devices (<code>{@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} == LIMITED</code>).</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see android.hardware.camera2.CameraCharacteristics#SCALER_STREAM_CONFIGURATION_MAP
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.Integer> REQUEST_MAX_NUM_OUTPUT_PROC;
static { REQUEST_MAX_NUM_OUTPUT_PROC = null; }

/**
 * <p>The maximum numbers of different types of output streams
 * that can be configured and used simultaneously by a camera device
 * for any processed (and stalling) formats.</p>
 * <p>This value contains the max number of output simultaneous
 * streams for any processed (but not-stalling) formats.</p>
 * <p>This lists the upper bound of the number of output streams supported by
 * the camera device. Using more streams simultaneously may require more hardware and
 * CPU resources that will consume more power. The image format for this kind of an output stream can
 * be any non-<code>RAW</code> and supported format provided by {@link android.hardware.camera2.CameraCharacteristics#SCALER_STREAM_CONFIGURATION_MAP CameraCharacteristics#SCALER_STREAM_CONFIGURATION_MAP}.</p>
 * <p>A processed and stalling format is defined as any non-RAW format with a stallDurations
 * &gt; 0.  Typically only the {@link android.graphics.ImageFormat#JPEG JPEG format} is a stalling format.</p>
 * <p>For full guarantees, query {@link android.hardware.camera2.params.StreamConfigurationMap#getOutputStallDuration } with a
 * processed format -- it will return a non-0 value for a stalling stream.</p>
 * <p>LEGACY devices will support up to 1 processing/stalling stream.</p>
 * <p><b>Range of valid values:</b><br></p>
 * <p>&gt;= 1</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#SCALER_STREAM_CONFIGURATION_MAP
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.Integer> REQUEST_MAX_NUM_OUTPUT_PROC_STALLING;
static { REQUEST_MAX_NUM_OUTPUT_PROC_STALLING = null; }

/**
 * <p>The maximum numbers of different types of output streams
 * that can be configured and used simultaneously by a camera device
 * for any <code>RAW</code> formats.</p>
 * <p>This value contains the max number of output simultaneous
 * streams from the raw sensor.</p>
 * <p>This lists the upper bound of the number of output streams supported by
 * the camera device. Using more streams simultaneously may require more hardware and
 * CPU resources that will consume more power. The image format for this kind of an output stream can
 * be any <code>RAW</code> and supported format provided by {@link android.hardware.camera2.CameraCharacteristics#SCALER_STREAM_CONFIGURATION_MAP CameraCharacteristics#SCALER_STREAM_CONFIGURATION_MAP}.</p>
 * <p>In particular, a <code>RAW</code> format is typically one of:</p>
 * <ul>
 * <li>{@link android.graphics.ImageFormat#RAW_SENSOR RAW_SENSOR}</li>
 * <li>{@link android.graphics.ImageFormat#RAW10 RAW10}</li>
 * <li>{@link android.graphics.ImageFormat#RAW12 RAW12}</li>
 * </ul>
 * <p>LEGACY mode devices ({@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} <code>==</code> LEGACY)
 * never support raw streams.</p>
 * <p><b>Range of valid values:</b><br></p>
 * <p>&gt;= 0</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see android.hardware.camera2.CameraCharacteristics#SCALER_STREAM_CONFIGURATION_MAP
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.Integer> REQUEST_MAX_NUM_OUTPUT_RAW;
static { REQUEST_MAX_NUM_OUTPUT_RAW = null; }

/**
 * <p>Defines how many sub-components
 * a result will be composed of.</p>
 * <p>In order to combat the pipeline latency, partial results
 * may be delivered to the application layer from the camera device as
 * soon as they are available.</p>
 * <p>Optional; defaults to 1. A value of 1 means that partial
 * results are not supported, and only the final TotalCaptureResult will
 * be produced by the camera device.</p>
 * <p>A typical use case for this might be: after requesting an
 * auto-focus (AF) lock the new AF state might be available 50%
 * of the way through the pipeline.  The camera device could
 * then immediately dispatch this state via a partial result to
 * the application, and the rest of the metadata via later
 * partial results.</p>
 * <p><b>Range of valid values:</b><br>
 * &gt;= 1</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.Integer> REQUEST_PARTIAL_RESULT_COUNT;
static { REQUEST_PARTIAL_RESULT_COUNT = null; }

/**
 * <p>Specifies the number of maximum pipeline stages a frame
 * has to go through from when it's exposed to when it's available
 * to the framework.</p>
 * <p>A typical minimum value for this is 2 (one stage to expose,
 * one stage to readout) from the sensor. The ISP then usually adds
 * its own stages to do custom HW processing. Further stages may be
 * added by SW processing.</p>
 * <p>Depending on what settings are used (e.g. YUV, JPEG) and what
 * processing is enabled (e.g. face detection), the actual pipeline
 * depth (specified by {@link android.hardware.camera2.CaptureResult#REQUEST_PIPELINE_DEPTH CaptureResult#REQUEST_PIPELINE_DEPTH}) may be less than
 * the max pipeline depth.</p>
 * <p>A pipeline depth of X stages is equivalent to a pipeline latency of
 * X frame intervals.</p>
 * <p>This value will normally be 8 or less, however, for high speed capture session,
 * the max pipeline depth will be up to 8 x size of high speed capture request list.</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureResult#REQUEST_PIPELINE_DEPTH
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.Byte> REQUEST_PIPELINE_MAX_DEPTH;
static { REQUEST_PIPELINE_MAX_DEPTH = null; }

/**
 * <p>The maximum ratio between both active area width
 * and crop region width, and active area height and
 * crop region height, for {@link android.hardware.camera2.CaptureRequest#SCALER_CROP_REGION CaptureRequest#SCALER_CROP_REGION}.</p>
 * <p>This represents the maximum amount of zooming possible by
 * the camera device, or equivalently, the minimum cropping
 * window size.</p>
 * <p>Crop regions that have a width or height that is smaller
 * than this ratio allows will be rounded up to the minimum
 * allowed size by the camera device.</p>
 * <p><b>Units</b>: Zoom scale factor</p>
 * <p><b>Range of valid values:</b><br>
 * &gt;=1</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#SCALER_CROP_REGION
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.Float> SCALER_AVAILABLE_MAX_DIGITAL_ZOOM;
static { SCALER_AVAILABLE_MAX_DIGITAL_ZOOM = null; }

/**
 * <p>The crop type that this camera device supports.</p>
 * <p>When passing a non-centered crop region ({@link android.hardware.camera2.CaptureRequest#SCALER_CROP_REGION CaptureRequest#SCALER_CROP_REGION}) to a camera
 * device that only supports CENTER_ONLY cropping, the camera device will move the
 * crop region to the center of the sensor active array ({@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE})
 * and keep the crop region width and height unchanged. The camera device will return the
 * final used crop region in metadata result {@link android.hardware.camera2.CaptureRequest#SCALER_CROP_REGION CaptureRequest#SCALER_CROP_REGION}.</p>
 * <p>Camera devices that support FREEFORM cropping will support any crop region that
 * is inside of the active array. The camera device will apply the same crop region and
 * return the final used crop region in capture result metadata {@link android.hardware.camera2.CaptureRequest#SCALER_CROP_REGION CaptureRequest#SCALER_CROP_REGION}.</p>
 * <p>LEGACY capability devices will only support CENTER_ONLY cropping.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #SCALER_CROPPING_TYPE_CENTER_ONLY CENTER_ONLY}</li>
 *   <li>{@link #SCALER_CROPPING_TYPE_FREEFORM FREEFORM}</li>
 * </ul></p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#SCALER_CROP_REGION
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE
 * @see #SCALER_CROPPING_TYPE_CENTER_ONLY
 * @see #SCALER_CROPPING_TYPE_FREEFORM
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.Integer> SCALER_CROPPING_TYPE;
static { SCALER_CROPPING_TYPE = null; }

/**
 * <p>An array of mandatory stream combinations generated according to the camera device
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL }
 * and {@link android.hardware.camera2.CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES }.
 * This is an app-readable conversion of the mandatory stream combination
 * {@link android.hardware.camera2.CameraDevice#createCaptureSession tables}.</p>
 * <p>The array of
 * {@link android.hardware.camera2.params.MandatoryStreamCombination combinations} is
 * generated according to the documented
 * {@link android.hardware.camera2.CameraDevice#createCaptureSession guideline} based on
 * specific device level and capabilities.
 * Clients can use the array as a quick reference to find an appropriate camera stream
 * combination.
 * As per documentation, the stream combinations with given PREVIEW, RECORD and
 * MAXIMUM resolutions and anything smaller from the list given by
 * {@link android.hardware.camera2.params.StreamConfigurationMap#getOutputSizes } are
 * guaranteed to work.
 * For a physical camera not independently exposed in
 * {@link android.hardware.camera2.CameraManager#getCameraIdList }, the mandatory stream
 * combinations for that physical camera Id are also generated, so that the application can
 * configure them as physical streams via the logical camera.
 * The mandatory stream combination array will be {@code null} in case the device is not
 * backward compatible.</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Limited capability</b> -
 * Present on all camera devices that report being at least {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<android.hardware.camera2.params.MandatoryStreamCombination[]> SCALER_MANDATORY_STREAM_COMBINATIONS;
static { SCALER_MANDATORY_STREAM_COMBINATIONS = null; }

/**
 * <p>The available stream configurations that this
 * camera device supports; also includes the minimum frame durations
 * and the stall durations for each format/size combination.</p>
 * <p>All camera devices will support sensor maximum resolution (defined by
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE}) for the JPEG format.</p>
 * <p>For a given use case, the actual maximum supported resolution
 * may be lower than what is listed here, depending on the destination
 * Surface for the image data. For example, for recording video,
 * the video encoder chosen may have a maximum size limit (e.g. 1080p)
 * smaller than what the camera (e.g. maximum resolution is 3264x2448)
 * can provide.</p>
 * <p>Please reference the documentation for the image data destination to
 * check if it limits the maximum size for image data.</p>
 * <p>The following table describes the minimum required output stream
 * configurations based on the hardware level
 * ({@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL}):</p>
 * <table>
 * <thead>
 * <tr>
 * <th align="center">Format</th>
 * <th align="center">Size</th>
 * <th align="center">Hardware Level</th>
 * <th align="center">Notes</th>
 * </tr>
 * </thead>
 * <tbody>
 * <tr>
 * <td align="center">{@link android.graphics.ImageFormat#JPEG }</td>
 * <td align="center">{@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE} (*1)</td>
 * <td align="center">Any</td>
 * <td align="center"></td>
 * </tr>
 * <tr>
 * <td align="center">{@link android.graphics.ImageFormat#JPEG }</td>
 * <td align="center">1920x1080 (1080p)</td>
 * <td align="center">Any</td>
 * <td align="center">if 1080p &lt;= activeArraySize</td>
 * </tr>
 * <tr>
 * <td align="center">{@link android.graphics.ImageFormat#JPEG }</td>
 * <td align="center">1280x720 (720p)</td>
 * <td align="center">Any</td>
 * <td align="center">if 720p &lt;= activeArraySize</td>
 * </tr>
 * <tr>
 * <td align="center">{@link android.graphics.ImageFormat#JPEG }</td>
 * <td align="center">640x480 (480p)</td>
 * <td align="center">Any</td>
 * <td align="center">if 480p &lt;= activeArraySize</td>
 * </tr>
 * <tr>
 * <td align="center">{@link android.graphics.ImageFormat#JPEG }</td>
 * <td align="center">320x240 (240p)</td>
 * <td align="center">Any</td>
 * <td align="center">if 240p &lt;= activeArraySize</td>
 * </tr>
 * <tr>
 * <td align="center">{@link android.graphics.ImageFormat#YUV_420_888 }</td>
 * <td align="center">all output sizes available for JPEG</td>
 * <td align="center">FULL</td>
 * <td align="center"></td>
 * </tr>
 * <tr>
 * <td align="center">{@link android.graphics.ImageFormat#YUV_420_888 }</td>
 * <td align="center">all output sizes available for JPEG, up to the maximum video size</td>
 * <td align="center">LIMITED</td>
 * <td align="center"></td>
 * </tr>
 * <tr>
 * <td align="center">{@link android.graphics.ImageFormat#PRIVATE }</td>
 * <td align="center">same as YUV_420_888</td>
 * <td align="center">Any</td>
 * <td align="center"></td>
 * </tr>
 * </tbody>
 * </table>
 * <p>Refer to {@link android.hardware.camera2.CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES} and {@link android.hardware.camera2.CameraDevice#createCaptureSession } for additional mandatory
 * stream configurations on a per-capability basis.</p>
 * <p>*1: For JPEG format, the sizes may be restricted by below conditions:</p>
 * <ul>
 * <li>The HAL may choose the aspect ratio of each Jpeg size to be one of well known ones
 * (e.g. 4:3, 16:9, 3:2 etc.). If the sensor maximum resolution
 * (defined by {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE}) has an aspect ratio other than these,
 * it does not have to be included in the supported JPEG sizes.</li>
 * <li>Some hardware JPEG encoders may have pixel boundary alignment requirements, such as
 * the dimensions being a multiple of 16.
 * Therefore, the maximum JPEG size may be smaller than sensor maximum resolution.
 * However, the largest JPEG size will be as close as possible to the sensor maximum
 * resolution given above constraints. It is required that after aspect ratio adjustments,
 * additional size reduction due to other issues must be less than 3% in area. For example,
 * if the sensor maximum resolution is 3280x2464, if the maximum JPEG size has aspect
 * ratio 4:3, and the JPEG encoder alignment requirement is 16, the maximum JPEG size will be
 * 3264x2448.</li>
 * </ul>
 * <p>Exception on 176x144 (QCIF) resolution: camera devices usually have a fixed capability on
 * downscaling from larger resolution to smaller ones, and the QCIF resolution can sometimes
 * not be fully supported due to this limitation on devices with high-resolution image
 * sensors. Therefore, trying to configure a QCIF resolution stream together with any other
 * stream larger than 1920x1080 resolution (either width or height) might not be supported,
 * and capture session creation will fail if it is not.</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see android.hardware.camera2.CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<android.hardware.camera2.params.StreamConfigurationMap> SCALER_STREAM_CONFIGURATION_MAP;
static { SCALER_STREAM_CONFIGURATION_MAP = null; }

/**
 * <p>List of sensor test pattern modes for {@link android.hardware.camera2.CaptureRequest#SENSOR_TEST_PATTERN_MODE CaptureRequest#SENSOR_TEST_PATTERN_MODE}
 * supported by this camera device.</p>
 * <p>Defaults to OFF, and always includes OFF if defined.</p>
 * <p><b>Range of valid values:</b><br>
 * Any value listed in {@link android.hardware.camera2.CaptureRequest#SENSOR_TEST_PATTERN_MODE CaptureRequest#SENSOR_TEST_PATTERN_MODE}</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#SENSOR_TEST_PATTERN_MODE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<int[]> SENSOR_AVAILABLE_TEST_PATTERN_MODES;
static { SENSOR_AVAILABLE_TEST_PATTERN_MODES = null; }

/**
 * <p>A fixed black level offset for each of the color filter arrangement
 * (CFA) mosaic channels.</p>
 * <p>This key specifies the zero light value for each of the CFA mosaic
 * channels in the camera sensor.  The maximal value output by the
 * sensor is represented by the value in {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_WHITE_LEVEL CameraCharacteristics#SENSOR_INFO_WHITE_LEVEL}.</p>
 * <p>The values are given in the same order as channels listed for the CFA
 * layout key (see {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_COLOR_FILTER_ARRANGEMENT CameraCharacteristics#SENSOR_INFO_COLOR_FILTER_ARRANGEMENT}), i.e. the
 * nth value given corresponds to the black level offset for the nth
 * color channel listed in the CFA.</p>
 * <p>The black level values of captured images may vary for different
 * capture settings (e.g., {@link android.hardware.camera2.CaptureRequest#SENSOR_SENSITIVITY CaptureRequest#SENSOR_SENSITIVITY}). This key
 * represents a coarse approximation for such case. It is recommended to
 * use {@link android.hardware.camera2.CaptureResult#SENSOR_DYNAMIC_BLACK_LEVEL CaptureResult#SENSOR_DYNAMIC_BLACK_LEVEL} or use pixels from
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_OPTICAL_BLACK_REGIONS CameraCharacteristics#SENSOR_OPTICAL_BLACK_REGIONS} directly for captures when
 * supported by the camera device, which provides more accurate black
 * level values. For raw capture in particular, it is recommended to use
 * pixels from {@link android.hardware.camera2.CameraCharacteristics#SENSOR_OPTICAL_BLACK_REGIONS CameraCharacteristics#SENSOR_OPTICAL_BLACK_REGIONS} to calculate black
 * level values for each frame.</p>
 * <p>For a MONOCHROME camera device, all of the 2x2 channels must have the same values.</p>
 * <p><b>Range of valid values:</b><br>
 * &gt;= 0 for each.</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 *
 * @see android.hardware.camera2.CaptureResult#SENSOR_DYNAMIC_BLACK_LEVEL
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_COLOR_FILTER_ARRANGEMENT
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_WHITE_LEVEL
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_OPTICAL_BLACK_REGIONS
 * @see android.hardware.camera2.CaptureRequest#SENSOR_SENSITIVITY
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<android.hardware.camera2.params.BlackLevelPattern> SENSOR_BLACK_LEVEL_PATTERN;
static { SENSOR_BLACK_LEVEL_PATTERN = null; }

/**
 * <p>A per-device calibration transform matrix that maps from the
 * reference sensor colorspace to the actual device sensor colorspace.</p>
 * <p>This matrix is used to correct for per-device variations in the
 * sensor colorspace, and is used for processing raw buffer data.</p>
 * <p>The matrix is expressed as a 3x3 matrix in row-major-order, and
 * contains a per-device calibration transform that maps colors
 * from reference sensor color space (i.e. the "golden module"
 * colorspace) into this camera device's native sensor color
 * space under the first reference illuminant
 * ({@link android.hardware.camera2.CameraCharacteristics#SENSOR_REFERENCE_ILLUMINANT1 CameraCharacteristics#SENSOR_REFERENCE_ILLUMINANT1}).</p>
 * <p>Starting from Android Q, this key will not be present for a MONOCHROME camera, even if
 * the camera device has RAW capability.</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Permission {@link android.Manifest.permission#CAMERA } is needed to access this property</b></p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_REFERENCE_ILLUMINANT1
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<android.hardware.camera2.params.ColorSpaceTransform> SENSOR_CALIBRATION_TRANSFORM1;
static { SENSOR_CALIBRATION_TRANSFORM1 = null; }

/**
 * <p>A per-device calibration transform matrix that maps from the
 * reference sensor colorspace to the actual device sensor colorspace
 * (this is the colorspace of the raw buffer data).</p>
 * <p>This matrix is used to correct for per-device variations in the
 * sensor colorspace, and is used for processing raw buffer data.</p>
 * <p>The matrix is expressed as a 3x3 matrix in row-major-order, and
 * contains a per-device calibration transform that maps colors
 * from reference sensor color space (i.e. the "golden module"
 * colorspace) into this camera device's native sensor color
 * space under the second reference illuminant
 * ({@link android.hardware.camera2.CameraCharacteristics#SENSOR_REFERENCE_ILLUMINANT2 CameraCharacteristics#SENSOR_REFERENCE_ILLUMINANT2}).</p>
 * <p>This matrix will only be present if the second reference
 * illuminant is present.</p>
 * <p>Starting from Android Q, this key will not be present for a MONOCHROME camera, even if
 * the camera device has RAW capability.</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Permission {@link android.Manifest.permission#CAMERA } is needed to access this property</b></p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_REFERENCE_ILLUMINANT2
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<android.hardware.camera2.params.ColorSpaceTransform> SENSOR_CALIBRATION_TRANSFORM2;
static { SENSOR_CALIBRATION_TRANSFORM2 = null; }

/**
 * <p>A matrix that transforms color values from CIE XYZ color space to
 * reference sensor color space.</p>
 * <p>This matrix is used to convert from the standard CIE XYZ color
 * space to the reference sensor colorspace, and is used when processing
 * raw buffer data.</p>
 * <p>The matrix is expressed as a 3x3 matrix in row-major-order, and
 * contains a color transform matrix that maps colors from the CIE
 * XYZ color space to the reference sensor color space (i.e. the
 * "golden module" colorspace) under the first reference illuminant
 * ({@link android.hardware.camera2.CameraCharacteristics#SENSOR_REFERENCE_ILLUMINANT1 CameraCharacteristics#SENSOR_REFERENCE_ILLUMINANT1}).</p>
 * <p>The white points chosen in both the reference sensor color space
 * and the CIE XYZ colorspace when calculating this transform will
 * match the standard white point for the first reference illuminant
 * (i.e. no chromatic adaptation will be applied by this transform).</p>
 * <p>Starting from Android Q, this key will not be present for a MONOCHROME camera, even if
 * the camera device has RAW capability.</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Permission {@link android.Manifest.permission#CAMERA } is needed to access this property</b></p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_REFERENCE_ILLUMINANT1
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<android.hardware.camera2.params.ColorSpaceTransform> SENSOR_COLOR_TRANSFORM1;
static { SENSOR_COLOR_TRANSFORM1 = null; }

/**
 * <p>A matrix that transforms color values from CIE XYZ color space to
 * reference sensor color space.</p>
 * <p>This matrix is used to convert from the standard CIE XYZ color
 * space to the reference sensor colorspace, and is used when processing
 * raw buffer data.</p>
 * <p>The matrix is expressed as a 3x3 matrix in row-major-order, and
 * contains a color transform matrix that maps colors from the CIE
 * XYZ color space to the reference sensor color space (i.e. the
 * "golden module" colorspace) under the second reference illuminant
 * ({@link android.hardware.camera2.CameraCharacteristics#SENSOR_REFERENCE_ILLUMINANT2 CameraCharacteristics#SENSOR_REFERENCE_ILLUMINANT2}).</p>
 * <p>The white points chosen in both the reference sensor color space
 * and the CIE XYZ colorspace when calculating this transform will
 * match the standard white point for the second reference illuminant
 * (i.e. no chromatic adaptation will be applied by this transform).</p>
 * <p>This matrix will only be present if the second reference
 * illuminant is present.</p>
 * <p>Starting from Android Q, this key will not be present for a MONOCHROME camera, even if
 * the camera device has RAW capability.</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Permission {@link android.Manifest.permission#CAMERA } is needed to access this property</b></p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_REFERENCE_ILLUMINANT2
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<android.hardware.camera2.params.ColorSpaceTransform> SENSOR_COLOR_TRANSFORM2;
static { SENSOR_COLOR_TRANSFORM2 = null; }

/**
 * <p>A matrix that transforms white balanced camera colors from the reference
 * sensor colorspace to the CIE XYZ colorspace with a D50 whitepoint.</p>
 * <p>This matrix is used to convert to the standard CIE XYZ colorspace, and
 * is used when processing raw buffer data.</p>
 * <p>This matrix is expressed as a 3x3 matrix in row-major-order, and contains
 * a color transform matrix that maps white balanced colors from the
 * reference sensor color space to the CIE XYZ color space with a D50 white
 * point.</p>
 * <p>Under the first reference illuminant ({@link android.hardware.camera2.CameraCharacteristics#SENSOR_REFERENCE_ILLUMINANT1 CameraCharacteristics#SENSOR_REFERENCE_ILLUMINANT1})
 * this matrix is chosen so that the standard white point for this reference
 * illuminant in the reference sensor colorspace is mapped to D50 in the
 * CIE XYZ colorspace.</p>
 * <p>Starting from Android Q, this key will not be present for a MONOCHROME camera, even if
 * the camera device has RAW capability.</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Permission {@link android.Manifest.permission#CAMERA } is needed to access this property</b></p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_REFERENCE_ILLUMINANT1
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<android.hardware.camera2.params.ColorSpaceTransform> SENSOR_FORWARD_MATRIX1;
static { SENSOR_FORWARD_MATRIX1 = null; }

/**
 * <p>A matrix that transforms white balanced camera colors from the reference
 * sensor colorspace to the CIE XYZ colorspace with a D50 whitepoint.</p>
 * <p>This matrix is used to convert to the standard CIE XYZ colorspace, and
 * is used when processing raw buffer data.</p>
 * <p>This matrix is expressed as a 3x3 matrix in row-major-order, and contains
 * a color transform matrix that maps white balanced colors from the
 * reference sensor color space to the CIE XYZ color space with a D50 white
 * point.</p>
 * <p>Under the second reference illuminant ({@link android.hardware.camera2.CameraCharacteristics#SENSOR_REFERENCE_ILLUMINANT2 CameraCharacteristics#SENSOR_REFERENCE_ILLUMINANT2})
 * this matrix is chosen so that the standard white point for this reference
 * illuminant in the reference sensor colorspace is mapped to D50 in the
 * CIE XYZ colorspace.</p>
 * <p>This matrix will only be present if the second reference
 * illuminant is present.</p>
 * <p>Starting from Android Q, this key will not be present for a MONOCHROME camera, even if
 * the camera device has RAW capability.</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Permission {@link android.Manifest.permission#CAMERA } is needed to access this property</b></p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_REFERENCE_ILLUMINANT2
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<android.hardware.camera2.params.ColorSpaceTransform> SENSOR_FORWARD_MATRIX2;
static { SENSOR_FORWARD_MATRIX2 = null; }

/**
 * <p>The area of the image sensor which corresponds to active pixels after any geometric
 * distortion correction has been applied.</p>
 * <p>This is the rectangle representing the size of the active region of the sensor (i.e.
 * the region that actually receives light from the scene) after any geometric correction
 * has been applied, and should be treated as the maximum size in pixels of any of the
 * image output formats aside from the raw formats.</p>
 * <p>This rectangle is defined relative to the full pixel array; (0,0) is the top-left of
 * the full pixel array, and the size of the full pixel array is given by
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PIXEL_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PIXEL_ARRAY_SIZE}.</p>
 * <p>The coordinate system for most other keys that list pixel coordinates, including
 * {@link android.hardware.camera2.CaptureRequest#SCALER_CROP_REGION CaptureRequest#SCALER_CROP_REGION}, is defined relative to the active array rectangle given in
 * this field, with <code>(0, 0)</code> being the top-left of this rectangle.</p>
 * <p>The active array may be smaller than the full pixel array, since the full array may
 * include black calibration pixels or other inactive regions.</p>
 * <p>For devices that do not support {@link android.hardware.camera2.CaptureRequest#DISTORTION_CORRECTION_MODE CaptureRequest#DISTORTION_CORRECTION_MODE} control, the active
 * array must be the same as {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE}.</p>
 * <p>For devices that support {@link android.hardware.camera2.CaptureRequest#DISTORTION_CORRECTION_MODE CaptureRequest#DISTORTION_CORRECTION_MODE} control, the active array must
 * be enclosed by {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE}. The difference between
 * pre-correction active array and active array accounts for scaling or cropping caused
 * by lens geometric distortion correction.</p>
 * <p>In general, application should always refer to active array size for controls like
 * metering regions or crop region. Two exceptions are when the application is dealing with
 * RAW image buffers (RAW_SENSOR, RAW10, RAW12 etc), or when application explicitly set
 * {@link android.hardware.camera2.CaptureRequest#DISTORTION_CORRECTION_MODE CaptureRequest#DISTORTION_CORRECTION_MODE} to OFF. In these cases, application should refer
 * to {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE}.</p>
 * <p><b>Units</b>: Pixel coordinates on the image sensor</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#DISTORTION_CORRECTION_MODE
 * @see android.hardware.camera2.CaptureRequest#SCALER_CROP_REGION
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PIXEL_ARRAY_SIZE
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<android.graphics.Rect> SENSOR_INFO_ACTIVE_ARRAY_SIZE;
static { SENSOR_INFO_ACTIVE_ARRAY_SIZE = null; }

/**
 * <p>The arrangement of color filters on sensor;
 * represents the colors in the top-left 2x2 section of
 * the sensor, in reading order, for a Bayer camera, or the
 * light spectrum it captures for MONOCHROME camera.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #SENSOR_INFO_COLOR_FILTER_ARRANGEMENT_RGGB RGGB}</li>
 *   <li>{@link #SENSOR_INFO_COLOR_FILTER_ARRANGEMENT_GRBG GRBG}</li>
 *   <li>{@link #SENSOR_INFO_COLOR_FILTER_ARRANGEMENT_GBRG GBRG}</li>
 *   <li>{@link #SENSOR_INFO_COLOR_FILTER_ARRANGEMENT_BGGR BGGR}</li>
 *   <li>{@link #SENSOR_INFO_COLOR_FILTER_ARRANGEMENT_RGB RGB}</li>
 *   <li>{@link #SENSOR_INFO_COLOR_FILTER_ARRANGEMENT_MONO MONO}</li>
 *   <li>{@link #SENSOR_INFO_COLOR_FILTER_ARRANGEMENT_NIR NIR}</li>
 * </ul></p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Full capability</b> -
 * Present on all camera devices that report being {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see #SENSOR_INFO_COLOR_FILTER_ARRANGEMENT_RGGB
 * @see #SENSOR_INFO_COLOR_FILTER_ARRANGEMENT_GRBG
 * @see #SENSOR_INFO_COLOR_FILTER_ARRANGEMENT_GBRG
 * @see #SENSOR_INFO_COLOR_FILTER_ARRANGEMENT_BGGR
 * @see #SENSOR_INFO_COLOR_FILTER_ARRANGEMENT_RGB
 * @see #SENSOR_INFO_COLOR_FILTER_ARRANGEMENT_MONO
 * @see #SENSOR_INFO_COLOR_FILTER_ARRANGEMENT_NIR
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.Integer> SENSOR_INFO_COLOR_FILTER_ARRANGEMENT;
static { SENSOR_INFO_COLOR_FILTER_ARRANGEMENT = null; }

/**
 * <p>The range of image exposure times for {@link android.hardware.camera2.CaptureRequest#SENSOR_EXPOSURE_TIME CaptureRequest#SENSOR_EXPOSURE_TIME} supported
 * by this camera device.</p>
 * <p><b>Units</b>: Nanoseconds</p>
 * <p><b>Range of valid values:</b><br>
 * The minimum exposure time will be less than 100 us. For FULL
 * capability devices ({@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} == FULL),
 * the maximum exposure time will be greater than 100ms.</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Full capability</b> -
 * Present on all camera devices that report being {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see android.hardware.camera2.CaptureRequest#SENSOR_EXPOSURE_TIME
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<android.util.Range<java.lang.Long>> SENSOR_INFO_EXPOSURE_TIME_RANGE;
static { SENSOR_INFO_EXPOSURE_TIME_RANGE = null; }

/**
 * <p>Whether the RAW images output from this camera device are subject to
 * lens shading correction.</p>
 * <p>If TRUE, all images produced by the camera device in the RAW image formats will
 * have lens shading correction already applied to it. If FALSE, the images will
 * not be adjusted for lens shading correction.
 * See {@link android.hardware.camera2.CameraCharacteristics#REQUEST_MAX_NUM_OUTPUT_RAW CameraCharacteristics#REQUEST_MAX_NUM_OUTPUT_RAW} for a list of RAW image formats.</p>
 * <p>This key will be <code>null</code> for all devices do not report this information.
 * Devices with RAW capability will always report this information in this key.</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#REQUEST_MAX_NUM_OUTPUT_RAW
 * @apiSince 23
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.Boolean> SENSOR_INFO_LENS_SHADING_APPLIED;
static { SENSOR_INFO_LENS_SHADING_APPLIED = null; }

/**
 * <p>The maximum possible frame duration (minimum frame rate) for
 * {@link android.hardware.camera2.CaptureRequest#SENSOR_FRAME_DURATION CaptureRequest#SENSOR_FRAME_DURATION} that is supported this camera device.</p>
 * <p>Attempting to use frame durations beyond the maximum will result in the frame
 * duration being clipped to the maximum. See that control for a full definition of frame
 * durations.</p>
 * <p>Refer to {@link android.hardware.camera2.params.StreamConfigurationMap#getOutputMinFrameDuration }
 * for the minimum frame duration values.</p>
 * <p><b>Units</b>: Nanoseconds</p>
 * <p><b>Range of valid values:</b><br>
 * For FULL capability devices
 * ({@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} == FULL), at least 100ms.</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Full capability</b> -
 * Present on all camera devices that report being {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see android.hardware.camera2.CaptureRequest#SENSOR_FRAME_DURATION
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.Long> SENSOR_INFO_MAX_FRAME_DURATION;
static { SENSOR_INFO_MAX_FRAME_DURATION = null; }

/**
 * <p>The physical dimensions of the full pixel
 * array.</p>
 * <p>This is the physical size of the sensor pixel
 * array defined by {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PIXEL_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PIXEL_ARRAY_SIZE}.</p>
 * <p><b>Units</b>: Millimeters</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PIXEL_ARRAY_SIZE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<android.util.SizeF> SENSOR_INFO_PHYSICAL_SIZE;
static { SENSOR_INFO_PHYSICAL_SIZE = null; }

/**
 * <p>Dimensions of the full pixel array, possibly
 * including black calibration pixels.</p>
 * <p>The pixel count of the full pixel array of the image sensor, which covers
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PHYSICAL_SIZE CameraCharacteristics#SENSOR_INFO_PHYSICAL_SIZE} area.  This represents the full pixel dimensions of
 * the raw buffers produced by this sensor.</p>
 * <p>If a camera device supports raw sensor formats, either this or
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE} is the maximum dimensions for the raw
 * output formats listed in {@link android.hardware.camera2.params.StreamConfigurationMap }
 * (this depends on whether or not the image sensor returns buffers containing pixels that
 * are not part of the active array region for blacklevel calibration or other purposes).</p>
 * <p>Some parts of the full pixel array may not receive light from the scene,
 * or be otherwise inactive.  The {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE} key
 * defines the rectangle of active pixels that will be included in processed image
 * formats.</p>
 * <p><b>Units</b>: Pixels</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PHYSICAL_SIZE
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<android.util.Size> SENSOR_INFO_PIXEL_ARRAY_SIZE;
static { SENSOR_INFO_PIXEL_ARRAY_SIZE = null; }

/**
 * <p>The area of the image sensor which corresponds to active pixels prior to the
 * application of any geometric distortion correction.</p>
 * <p>This is the rectangle representing the size of the active region of the sensor (i.e.
 * the region that actually receives light from the scene) before any geometric correction
 * has been applied, and should be treated as the active region rectangle for any of the
 * raw formats.  All metadata associated with raw processing (e.g. the lens shading
 * correction map, and radial distortion fields) treats the top, left of this rectangle as
 * the origin, (0,0).</p>
 * <p>The size of this region determines the maximum field of view and the maximum number of
 * pixels that an image from this sensor can contain, prior to the application of
 * geometric distortion correction. The effective maximum pixel dimensions of a
 * post-distortion-corrected image is given by the {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE}
 * field, and the effective maximum field of view for a post-distortion-corrected image
 * can be calculated by applying the geometric distortion correction fields to this
 * rectangle, and cropping to the rectangle given in {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE}.</p>
 * <p>E.g. to calculate position of a pixel, (x,y), in a processed YUV output image with the
 * dimensions in {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE} given the position of a pixel,
 * (x', y'), in the raw pixel array with dimensions give in
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PIXEL_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PIXEL_ARRAY_SIZE}:</p>
 * <ol>
 * <li>Choose a pixel (x', y') within the active array region of the raw buffer given in
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE}, otherwise this pixel is considered
 * to be outside of the FOV, and will not be shown in the processed output image.</li>
 * <li>Apply geometric distortion correction to get the post-distortion pixel coordinate,
 * (x_i, y_i). When applying geometric correction metadata, note that metadata for raw
 * buffers is defined relative to the top, left of the
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE} rectangle.</li>
 * <li>If the resulting corrected pixel coordinate is within the region given in
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE}, then the position of this pixel in the
 * processed output image buffer is <code>(x_i - activeArray.left, y_i - activeArray.top)</code>,
 * when the top, left coordinate of that buffer is treated as (0, 0).</li>
 * </ol>
 * <p>Thus, for pixel x',y' = (25, 25) on a sensor where {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PIXEL_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PIXEL_ARRAY_SIZE}
 * is (100,100), {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE} is (10, 10, 100, 100),
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE} is (20, 20, 80, 80), and the geometric distortion
 * correction doesn't change the pixel coordinate, the resulting pixel selected in
 * pixel coordinates would be x,y = (25, 25) relative to the top,left of the raw buffer
 * with dimensions given in {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PIXEL_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PIXEL_ARRAY_SIZE}, and would be (5, 5)
 * relative to the top,left of post-processed YUV output buffer with dimensions given in
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE}.</p>
 * <p>The currently supported fields that correct for geometric distortion are:</p>
 * <ol>
 * <li>{@link android.hardware.camera2.CameraCharacteristics#LENS_DISTORTION CameraCharacteristics#LENS_DISTORTION}.</li>
 * </ol>
 * <p>If the camera device doesn't support geometric distortion correction, or all of the
 * geometric distortion fields are no-ops, this rectangle will be the same as the
 * post-distortion-corrected rectangle given in {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE}.</p>
 * <p>This rectangle is defined relative to the full pixel array; (0,0) is the top-left of
 * the full pixel array, and the size of the full pixel array is given by
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PIXEL_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PIXEL_ARRAY_SIZE}.</p>
 * <p>The pre-correction active array may be smaller than the full pixel array, since the
 * full array may include black calibration pixels or other inactive regions.</p>
 * <p><b>Units</b>: Pixel coordinates on the image sensor</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#LENS_DISTORTION
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PIXEL_ARRAY_SIZE
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE
 * @apiSince 23
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<android.graphics.Rect> SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE;
static { SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE = null; }

/**
 * <p>Range of sensitivities for {@link android.hardware.camera2.CaptureRequest#SENSOR_SENSITIVITY CaptureRequest#SENSOR_SENSITIVITY} supported by this
 * camera device.</p>
 * <p>The values are the standard ISO sensitivity values,
 * as defined in ISO 12232:2006.</p>
 * <p><b>Range of valid values:</b><br>
 * Min &lt;= 100, Max &gt;= 800</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Full capability</b> -
 * Present on all camera devices that report being {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see android.hardware.camera2.CaptureRequest#SENSOR_SENSITIVITY
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<android.util.Range<java.lang.Integer>> SENSOR_INFO_SENSITIVITY_RANGE;
static { SENSOR_INFO_SENSITIVITY_RANGE = null; }

/**
 * <p>The time base source for sensor capture start timestamps.</p>
 * <p>The timestamps provided for captures are always in nanoseconds and monotonic, but
 * may not based on a time source that can be compared to other system time sources.</p>
 * <p>This characteristic defines the source for the timestamps, and therefore whether they
 * can be compared against other system time sources/timestamps.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #SENSOR_INFO_TIMESTAMP_SOURCE_UNKNOWN UNKNOWN}</li>
 *   <li>{@link #SENSOR_INFO_TIMESTAMP_SOURCE_REALTIME REALTIME}</li>
 * </ul></p>
 * <p>This key is available on all devices.</p>
 * @see #SENSOR_INFO_TIMESTAMP_SOURCE_UNKNOWN
 * @see #SENSOR_INFO_TIMESTAMP_SOURCE_REALTIME
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.Integer> SENSOR_INFO_TIMESTAMP_SOURCE;
static { SENSOR_INFO_TIMESTAMP_SOURCE = null; }

/**
 * <p>Maximum raw value output by sensor.</p>
 * <p>This specifies the fully-saturated encoding level for the raw
 * sample values from the sensor.  This is typically caused by the
 * sensor becoming highly non-linear or clipping. The minimum for
 * each channel is specified by the offset in the
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_BLACK_LEVEL_PATTERN CameraCharacteristics#SENSOR_BLACK_LEVEL_PATTERN} key.</p>
 * <p>The white level is typically determined either by sensor bit depth
 * (8-14 bits is expected), or by the point where the sensor response
 * becomes too non-linear to be useful.  The default value for this is
 * maximum representable value for a 16-bit raw sample (2^16 - 1).</p>
 * <p>The white level values of captured images may vary for different
 * capture settings (e.g., {@link android.hardware.camera2.CaptureRequest#SENSOR_SENSITIVITY CaptureRequest#SENSOR_SENSITIVITY}). This key
 * represents a coarse approximation for such case. It is recommended
 * to use {@link android.hardware.camera2.CaptureResult#SENSOR_DYNAMIC_WHITE_LEVEL CaptureResult#SENSOR_DYNAMIC_WHITE_LEVEL} for captures when supported
 * by the camera device, which provides more accurate white level values.</p>
 * <p><b>Range of valid values:</b><br>
 * &gt; 255 (8-bit output)</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_BLACK_LEVEL_PATTERN
 * @see android.hardware.camera2.CaptureResult#SENSOR_DYNAMIC_WHITE_LEVEL
 * @see android.hardware.camera2.CaptureRequest#SENSOR_SENSITIVITY
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.Integer> SENSOR_INFO_WHITE_LEVEL;
static { SENSOR_INFO_WHITE_LEVEL = null; }

/**
 * <p>Maximum sensitivity that is implemented
 * purely through analog gain.</p>
 * <p>For {@link android.hardware.camera2.CaptureRequest#SENSOR_SENSITIVITY CaptureRequest#SENSOR_SENSITIVITY} values less than or
 * equal to this, all applied gain must be analog. For
 * values above this, the gain applied can be a mix of analog and
 * digital.</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Full capability</b> -
 * Present on all camera devices that report being {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see android.hardware.camera2.CaptureRequest#SENSOR_SENSITIVITY
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.Integer> SENSOR_MAX_ANALOG_SENSITIVITY;
static { SENSOR_MAX_ANALOG_SENSITIVITY = null; }

/**
 * <p>List of disjoint rectangles indicating the sensor
 * optically shielded black pixel regions.</p>
 * <p>In most camera sensors, the active array is surrounded by some
 * optically shielded pixel areas. By blocking light, these pixels
 * provides a reliable black reference for black level compensation
 * in active array region.</p>
 * <p>This key provides a list of disjoint rectangles specifying the
 * regions of optically shielded (with metal shield) black pixel
 * regions if the camera device is capable of reading out these black
 * pixels in the output raw images. In comparison to the fixed black
 * level values reported by {@link android.hardware.camera2.CameraCharacteristics#SENSOR_BLACK_LEVEL_PATTERN CameraCharacteristics#SENSOR_BLACK_LEVEL_PATTERN}, this key
 * may provide a more accurate way for the application to calculate
 * black level of each captured raw images.</p>
 * <p>When this key is reported, the {@link android.hardware.camera2.CaptureResult#SENSOR_DYNAMIC_BLACK_LEVEL CaptureResult#SENSOR_DYNAMIC_BLACK_LEVEL} and
 * {@link android.hardware.camera2.CaptureResult#SENSOR_DYNAMIC_WHITE_LEVEL CaptureResult#SENSOR_DYNAMIC_WHITE_LEVEL} will also be reported.</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_BLACK_LEVEL_PATTERN
 * @see android.hardware.camera2.CaptureResult#SENSOR_DYNAMIC_BLACK_LEVEL
 * @see android.hardware.camera2.CaptureResult#SENSOR_DYNAMIC_WHITE_LEVEL
 * @apiSince 24
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<android.graphics.Rect[]> SENSOR_OPTICAL_BLACK_REGIONS;
static { SENSOR_OPTICAL_BLACK_REGIONS = null; }

/**
 * <p>Clockwise angle through which the output image needs to be rotated to be
 * upright on the device screen in its native orientation.</p>
 * <p>Also defines the direction of rolling shutter readout, which is from top to bottom in
 * the sensor's coordinate system.</p>
 * <p><b>Units</b>: Degrees of clockwise rotation; always a multiple of
 * 90</p>
 * <p><b>Range of valid values:</b><br>
 * 0, 90, 180, 270</p>
 * <p>This key is available on all devices.</p>
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.Integer> SENSOR_ORIENTATION;
static { SENSOR_ORIENTATION = null; }

/**
 * <p>The standard reference illuminant used as the scene light source when
 * calculating the {@link android.hardware.camera2.CameraCharacteristics#SENSOR_COLOR_TRANSFORM1 CameraCharacteristics#SENSOR_COLOR_TRANSFORM1},
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_CALIBRATION_TRANSFORM1 CameraCharacteristics#SENSOR_CALIBRATION_TRANSFORM1}, and
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_FORWARD_MATRIX1 CameraCharacteristics#SENSOR_FORWARD_MATRIX1} matrices.</p>
 * <p>The values in this key correspond to the values defined for the
 * EXIF LightSource tag. These illuminants are standard light sources
 * that are often used calibrating camera devices.</p>
 * <p>If this key is present, then {@link android.hardware.camera2.CameraCharacteristics#SENSOR_COLOR_TRANSFORM1 CameraCharacteristics#SENSOR_COLOR_TRANSFORM1},
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_CALIBRATION_TRANSFORM1 CameraCharacteristics#SENSOR_CALIBRATION_TRANSFORM1}, and
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_FORWARD_MATRIX1 CameraCharacteristics#SENSOR_FORWARD_MATRIX1} will also be present.</p>
 * <p>Some devices may choose to provide a second set of calibration
 * information for improved quality, including
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_REFERENCE_ILLUMINANT2 CameraCharacteristics#SENSOR_REFERENCE_ILLUMINANT2} and its corresponding matrices.</p>
 * <p>Starting from Android Q, this key will not be present for a MONOCHROME camera, even if
 * the camera device has RAW capability.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #SENSOR_REFERENCE_ILLUMINANT1_DAYLIGHT DAYLIGHT}</li>
 *   <li>{@link #SENSOR_REFERENCE_ILLUMINANT1_FLUORESCENT FLUORESCENT}</li>
 *   <li>{@link #SENSOR_REFERENCE_ILLUMINANT1_TUNGSTEN TUNGSTEN}</li>
 *   <li>{@link #SENSOR_REFERENCE_ILLUMINANT1_FLASH FLASH}</li>
 *   <li>{@link #SENSOR_REFERENCE_ILLUMINANT1_FINE_WEATHER FINE_WEATHER}</li>
 *   <li>{@link #SENSOR_REFERENCE_ILLUMINANT1_CLOUDY_WEATHER CLOUDY_WEATHER}</li>
 *   <li>{@link #SENSOR_REFERENCE_ILLUMINANT1_SHADE SHADE}</li>
 *   <li>{@link #SENSOR_REFERENCE_ILLUMINANT1_DAYLIGHT_FLUORESCENT DAYLIGHT_FLUORESCENT}</li>
 *   <li>{@link #SENSOR_REFERENCE_ILLUMINANT1_DAY_WHITE_FLUORESCENT DAY_WHITE_FLUORESCENT}</li>
 *   <li>{@link #SENSOR_REFERENCE_ILLUMINANT1_COOL_WHITE_FLUORESCENT COOL_WHITE_FLUORESCENT}</li>
 *   <li>{@link #SENSOR_REFERENCE_ILLUMINANT1_WHITE_FLUORESCENT WHITE_FLUORESCENT}</li>
 *   <li>{@link #SENSOR_REFERENCE_ILLUMINANT1_STANDARD_A STANDARD_A}</li>
 *   <li>{@link #SENSOR_REFERENCE_ILLUMINANT1_STANDARD_B STANDARD_B}</li>
 *   <li>{@link #SENSOR_REFERENCE_ILLUMINANT1_STANDARD_C STANDARD_C}</li>
 *   <li>{@link #SENSOR_REFERENCE_ILLUMINANT1_D55 D55}</li>
 *   <li>{@link #SENSOR_REFERENCE_ILLUMINANT1_D65 D65}</li>
 *   <li>{@link #SENSOR_REFERENCE_ILLUMINANT1_D75 D75}</li>
 *   <li>{@link #SENSOR_REFERENCE_ILLUMINANT1_D50 D50}</li>
 *   <li>{@link #SENSOR_REFERENCE_ILLUMINANT1_ISO_STUDIO_TUNGSTEN ISO_STUDIO_TUNGSTEN}</li>
 * </ul></p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Permission {@link android.Manifest.permission#CAMERA } is needed to access this property</b></p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_CALIBRATION_TRANSFORM1
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_COLOR_TRANSFORM1
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_FORWARD_MATRIX1
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_REFERENCE_ILLUMINANT2
 * @see #SENSOR_REFERENCE_ILLUMINANT1_DAYLIGHT
 * @see #SENSOR_REFERENCE_ILLUMINANT1_FLUORESCENT
 * @see #SENSOR_REFERENCE_ILLUMINANT1_TUNGSTEN
 * @see #SENSOR_REFERENCE_ILLUMINANT1_FLASH
 * @see #SENSOR_REFERENCE_ILLUMINANT1_FINE_WEATHER
 * @see #SENSOR_REFERENCE_ILLUMINANT1_CLOUDY_WEATHER
 * @see #SENSOR_REFERENCE_ILLUMINANT1_SHADE
 * @see #SENSOR_REFERENCE_ILLUMINANT1_DAYLIGHT_FLUORESCENT
 * @see #SENSOR_REFERENCE_ILLUMINANT1_DAY_WHITE_FLUORESCENT
 * @see #SENSOR_REFERENCE_ILLUMINANT1_COOL_WHITE_FLUORESCENT
 * @see #SENSOR_REFERENCE_ILLUMINANT1_WHITE_FLUORESCENT
 * @see #SENSOR_REFERENCE_ILLUMINANT1_STANDARD_A
 * @see #SENSOR_REFERENCE_ILLUMINANT1_STANDARD_B
 * @see #SENSOR_REFERENCE_ILLUMINANT1_STANDARD_C
 * @see #SENSOR_REFERENCE_ILLUMINANT1_D55
 * @see #SENSOR_REFERENCE_ILLUMINANT1_D65
 * @see #SENSOR_REFERENCE_ILLUMINANT1_D75
 * @see #SENSOR_REFERENCE_ILLUMINANT1_D50
 * @see #SENSOR_REFERENCE_ILLUMINANT1_ISO_STUDIO_TUNGSTEN
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.Integer> SENSOR_REFERENCE_ILLUMINANT1;
static { SENSOR_REFERENCE_ILLUMINANT1 = null; }

/**
 * <p>The standard reference illuminant used as the scene light source when
 * calculating the {@link android.hardware.camera2.CameraCharacteristics#SENSOR_COLOR_TRANSFORM2 CameraCharacteristics#SENSOR_COLOR_TRANSFORM2},
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_CALIBRATION_TRANSFORM2 CameraCharacteristics#SENSOR_CALIBRATION_TRANSFORM2}, and
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_FORWARD_MATRIX2 CameraCharacteristics#SENSOR_FORWARD_MATRIX2} matrices.</p>
 * <p>See {@link android.hardware.camera2.CameraCharacteristics#SENSOR_REFERENCE_ILLUMINANT1 CameraCharacteristics#SENSOR_REFERENCE_ILLUMINANT1} for more details.</p>
 * <p>If this key is present, then {@link android.hardware.camera2.CameraCharacteristics#SENSOR_COLOR_TRANSFORM2 CameraCharacteristics#SENSOR_COLOR_TRANSFORM2},
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_CALIBRATION_TRANSFORM2 CameraCharacteristics#SENSOR_CALIBRATION_TRANSFORM2}, and
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_FORWARD_MATRIX2 CameraCharacteristics#SENSOR_FORWARD_MATRIX2} will also be present.</p>
 * <p>Starting from Android Q, this key will not be present for a MONOCHROME camera, even if
 * the camera device has RAW capability.</p>
 * <p><b>Range of valid values:</b><br>
 * Any value listed in {@link android.hardware.camera2.CameraCharacteristics#SENSOR_REFERENCE_ILLUMINANT1 CameraCharacteristics#SENSOR_REFERENCE_ILLUMINANT1}</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Permission {@link android.Manifest.permission#CAMERA } is needed to access this property</b></p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_CALIBRATION_TRANSFORM2
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_COLOR_TRANSFORM2
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_FORWARD_MATRIX2
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_REFERENCE_ILLUMINANT1
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.Byte> SENSOR_REFERENCE_ILLUMINANT2;
static { SENSOR_REFERENCE_ILLUMINANT2 = null; }

/**
 * <p>List of lens shading modes for {@link android.hardware.camera2.CaptureRequest#SHADING_MODE CaptureRequest#SHADING_MODE} that are supported by this camera device.</p>
 * <p>This list contains lens shading modes that can be set for the camera device.
 * Camera devices that support the MANUAL_POST_PROCESSING capability will always
 * list OFF and FAST mode. This includes all FULL level devices.
 * LEGACY devices will always only support FAST mode.</p>
 * <p><b>Range of valid values:</b><br>
 * Any value listed in {@link android.hardware.camera2.CaptureRequest#SHADING_MODE CaptureRequest#SHADING_MODE}</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#SHADING_MODE
 * @apiSince 23
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<int[]> SHADING_AVAILABLE_MODES;
static { SHADING_AVAILABLE_MODES = null; }

/**
 * <p>List of face detection modes for {@link android.hardware.camera2.CaptureRequest#STATISTICS_FACE_DETECT_MODE CaptureRequest#STATISTICS_FACE_DETECT_MODE} that are
 * supported by this camera device.</p>
 * <p>OFF is always supported.</p>
 * <p><b>Range of valid values:</b><br>
 * Any value listed in {@link android.hardware.camera2.CaptureRequest#STATISTICS_FACE_DETECT_MODE CaptureRequest#STATISTICS_FACE_DETECT_MODE}</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#STATISTICS_FACE_DETECT_MODE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<int[]> STATISTICS_INFO_AVAILABLE_FACE_DETECT_MODES;
static { STATISTICS_INFO_AVAILABLE_FACE_DETECT_MODES = null; }

/**
 * <p>List of hot pixel map output modes for {@link android.hardware.camera2.CaptureRequest#STATISTICS_HOT_PIXEL_MAP_MODE CaptureRequest#STATISTICS_HOT_PIXEL_MAP_MODE} that are
 * supported by this camera device.</p>
 * <p>If no hotpixel map output is available for this camera device, this will contain only
 * <code>false</code>.</p>
 * <p>ON is always supported on devices with the RAW capability.</p>
 * <p><b>Range of valid values:</b><br>
 * Any value listed in {@link android.hardware.camera2.CaptureRequest#STATISTICS_HOT_PIXEL_MAP_MODE CaptureRequest#STATISTICS_HOT_PIXEL_MAP_MODE}</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#STATISTICS_HOT_PIXEL_MAP_MODE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<boolean[]> STATISTICS_INFO_AVAILABLE_HOT_PIXEL_MAP_MODES;
static { STATISTICS_INFO_AVAILABLE_HOT_PIXEL_MAP_MODES = null; }

/**
 * <p>List of lens shading map output modes for {@link android.hardware.camera2.CaptureRequest#STATISTICS_LENS_SHADING_MAP_MODE CaptureRequest#STATISTICS_LENS_SHADING_MAP_MODE} that
 * are supported by this camera device.</p>
 * <p>If no lens shading map output is available for this camera device, this key will
 * contain only OFF.</p>
 * <p>ON is always supported on devices with the RAW capability.
 * LEGACY mode devices will always only support OFF.</p>
 * <p><b>Range of valid values:</b><br>
 * Any value listed in {@link android.hardware.camera2.CaptureRequest#STATISTICS_LENS_SHADING_MAP_MODE CaptureRequest#STATISTICS_LENS_SHADING_MAP_MODE}</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#STATISTICS_LENS_SHADING_MAP_MODE
 * @apiSince 23
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<int[]> STATISTICS_INFO_AVAILABLE_LENS_SHADING_MAP_MODES;
static { STATISTICS_INFO_AVAILABLE_LENS_SHADING_MAP_MODES = null; }

/**
 * <p>List of OIS data output modes for {@link android.hardware.camera2.CaptureRequest#STATISTICS_OIS_DATA_MODE CaptureRequest#STATISTICS_OIS_DATA_MODE} that
 * are supported by this camera device.</p>
 * <p>If no OIS data output is available for this camera device, this key will
 * contain only OFF.</p>
 * <p><b>Range of valid values:</b><br>
 * Any value listed in {@link android.hardware.camera2.CaptureRequest#STATISTICS_OIS_DATA_MODE CaptureRequest#STATISTICS_OIS_DATA_MODE}</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#STATISTICS_OIS_DATA_MODE
 * @apiSince 28
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<int[]> STATISTICS_INFO_AVAILABLE_OIS_DATA_MODES;
static { STATISTICS_INFO_AVAILABLE_OIS_DATA_MODES = null; }

/**
 * <p>The maximum number of simultaneously detectable
 * faces.</p>
 * <p><b>Range of valid values:</b><br>
 * 0 for cameras without available face detection; otherwise:
 * <code>&gt;=4</code> for LIMITED or FULL hwlevel devices or
 * <code>&gt;0</code> for LEGACY devices.</p>
 * <p>This key is available on all devices.</p>
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.Integer> STATISTICS_INFO_MAX_FACE_COUNT;
static { STATISTICS_INFO_MAX_FACE_COUNT = null; }

/**
 * <p>The maximum number of frames that can occur after a request
 * (different than the previous) has been submitted, and before the
 * result's state becomes synchronized.</p>
 * <p>This defines the maximum distance (in number of metadata results),
 * between the frame number of the request that has new controls to apply
 * and the frame number of the result that has all the controls applied.</p>
 * <p>In other words this acts as an upper boundary for how many frames
 * must occur before the camera device knows for a fact that the new
 * submitted camera settings have been applied in outgoing frames.</p>
 * <p><b>Units</b>: Frame counts</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #SYNC_MAX_LATENCY_PER_FRAME_CONTROL PER_FRAME_CONTROL}</li>
 *   <li>{@link #SYNC_MAX_LATENCY_UNKNOWN UNKNOWN}</li>
 * </ul></p>
 * <p><b>Available values for this device:</b><br>
 * A positive value, PER_FRAME_CONTROL, or UNKNOWN.</p>
 * <p>This key is available on all devices.</p>
 * @see #SYNC_MAX_LATENCY_PER_FRAME_CONTROL
 * @see #SYNC_MAX_LATENCY_UNKNOWN
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.Integer> SYNC_MAX_LATENCY;
static { SYNC_MAX_LATENCY = null; }

/**
 * <p>List of tonemapping modes for {@link android.hardware.camera2.CaptureRequest#TONEMAP_MODE CaptureRequest#TONEMAP_MODE} that are supported by this camera
 * device.</p>
 * <p>Camera devices that support the MANUAL_POST_PROCESSING capability will always contain
 * at least one of below mode combinations:</p>
 * <ul>
 * <li>CONTRAST_CURVE, FAST and HIGH_QUALITY</li>
 * <li>GAMMA_VALUE, PRESET_CURVE, FAST and HIGH_QUALITY</li>
 * </ul>
 * <p>This includes all FULL level devices.</p>
 * <p><b>Range of valid values:</b><br>
 * Any value listed in {@link android.hardware.camera2.CaptureRequest#TONEMAP_MODE CaptureRequest#TONEMAP_MODE}</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Full capability</b> -
 * Present on all camera devices that report being {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see android.hardware.camera2.CaptureRequest#TONEMAP_MODE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<int[]> TONEMAP_AVAILABLE_TONE_MAP_MODES;
static { TONEMAP_AVAILABLE_TONE_MAP_MODES = null; }

/**
 * <p>Maximum number of supported points in the
 * tonemap curve that can be used for {@link android.hardware.camera2.CaptureRequest#TONEMAP_CURVE CaptureRequest#TONEMAP_CURVE}.</p>
 * <p>If the actual number of points provided by the application (in {@link android.hardware.camera2.CaptureRequest#TONEMAP_CURVE CaptureRequest#TONEMAP_CURVE}*) is
 * less than this maximum, the camera device will resample the curve to its internal
 * representation, using linear interpolation.</p>
 * <p>The output curves in the result metadata may have a different number
 * of points than the input curves, and will represent the actual
 * hardware curves used as closely as possible when linearly interpolated.</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Full capability</b> -
 * Present on all camera devices that report being {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see android.hardware.camera2.CaptureRequest#TONEMAP_CURVE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CameraCharacteristics.Key<java.lang.Integer> TONEMAP_MAX_CURVE_POINTS;
static { TONEMAP_MAX_CURVE_POINTS = null; }
/**
 * A {@code Key} is used to do camera characteristics field lookups with
 * {@link android.hardware.camera2.CameraCharacteristics#get CameraCharacteristics#get}.
 *
 * <p>For example, to get the stream configuration map:
 * <code><pre>
 * StreamConfigurationMap map = cameraCharacteristics.get(
 *      CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
 * </pre></code>
 * </p>
 *
 * <p>To enumerate over all possible keys for {@link android.hardware.camera2.CameraCharacteristics CameraCharacteristics}, see
 * {@link android.hardware.camera2.CameraCharacteristics#getKeys() CameraCharacteristics#getKeys()}.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#get
 * @see android.hardware.camera2.CameraCharacteristics#getKeys()
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Key<T> {

/**
 * Construct a new Key with a given name and type.
 *
 * <p>Normally, applications should use the existing Key definitions in
 * {@link android.hardware.camera2.CameraCharacteristics CameraCharacteristics}, and not need to construct their own Key objects. However,
 * they may be useful for testing purposes and for defining custom camera
 * characteristics.</p>
 
 * @param name This value must never be {@code null}.
 
 * @param type This value must never be {@code null}.
 * @apiSince 29
 */

public Key(@androidx.annotation.NonNull java.lang.String name, @androidx.annotation.NonNull java.lang.Class<T> type) { throw new RuntimeException("Stub!"); }

/**
 * Return a camelCase, period separated name formatted like:
 * {@code "root.section[.subsections].name"}.
 *
 * <p>Built-in keys exposed by the Android SDK are always prefixed with {@code "android."};
 * keys that are device/platform-specific are prefixed with {@code "com."}.</p>
 *
 * <p>For example, {@code CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP} would
 * have a name of {@code "android.scaler.streamConfigurationMap"}; whereas a device
 * specific key might look like {@code "com.google.nexus.data.private"}.</p>
 *
 * @return String representation of the key name
 
 * This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 21
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 21
 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Return this {@link android.hardware.camera2.CameraCharacteristics.Key Key} as a string representation.
 *
 * <p>{@code "CameraCharacteristics.Key(%s)"}, where {@code %s} represents
 * the name of this key as returned by {@link #getName}.</p>
 *
 * @return string representation of {@link android.hardware.camera2.CameraCharacteristics.Key Key}
 
 * This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

}

