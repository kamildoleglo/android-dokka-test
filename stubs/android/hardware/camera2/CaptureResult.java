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


package android.hardware.camera2;

import java.util.List;

/**
 * <p>The subset of the results of a single image capture from the image sensor.</p>
 *
 * <p>Contains a subset of the final configuration for the capture hardware (sensor, lens,
 * flash), the processing pipeline, the control algorithms, and the output
 * buffers.</p>
 *
 * <p>CaptureResults are produced by a {@link android.hardware.camera2.CameraDevice CameraDevice} after processing a
 * {@link android.hardware.camera2.CaptureRequest CaptureRequest}. All properties listed for capture requests can also
 * be queried on the capture result, to determine the final values used for
 * capture. The result also includes additional metadata about the state of the
 * camera device during the capture.</p>
 *
 * <p>Not all properties returned by {@link android.hardware.camera2.CameraCharacteristics#getAvailableCaptureResultKeys() CameraCharacteristics#getAvailableCaptureResultKeys()}
 * are necessarily available. Some results are {@link android.hardware.camera2.CaptureResult CaptureResult} and will
 * not have every key set. Only {@link android.hardware.camera2.TotalCaptureResult TotalCaptureResult} results are guaranteed to have
 * every key available that was enabled by the request.</p>
 *
 * <p>{@link android.hardware.camera2.CaptureResult CaptureResult} objects are immutable.</p>
 *
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CaptureResult extends android.hardware.camera2.CameraMetadata<android.hardware.camera2.CaptureResult.Key<?>> {

CaptureResult() { throw new RuntimeException("Stub!"); }

/**
 * Get a capture result field value.
 *
 * <p>The field definitions can be found in {@link android.hardware.camera2.CaptureResult CaptureResult}.</p>
 *
 * <p>Querying the value for the same key more than once will return a value
 * which is equal to the previous queried value.</p>
 *
 * @throws java.lang.IllegalArgumentException if the key was not valid
 *
 * @param key The result field to read.
 * @return The value of that key, or {@code null} if the field is not set.
 * @apiSince 21
 */

@androidx.annotation.Nullable
public <T> T get(android.hardware.camera2.CaptureResult.Key<T> key) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 
 * @return This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.util.List<android.hardware.camera2.CaptureResult.Key<?>> getKeys() { throw new RuntimeException("Stub!"); }

/**
 * Get the request associated with this result.
 *
 * <p>Whenever a request has been fully or partially captured, with
 * {@link android.hardware.camera2.CameraCaptureSession.CaptureCallback#onCaptureCompleted CameraCaptureSession.CaptureCallback#onCaptureCompleted} or
 * {@link android.hardware.camera2.CameraCaptureSession.CaptureCallback#onCaptureProgressed CameraCaptureSession.CaptureCallback#onCaptureProgressed}, the {@code result}'s
 * {@code getRequest()} will return that {@code request}.
 * </p>
 *
 * <p>For example,
 * <code><pre>cameraDevice.capture(someRequest, new CaptureCallback() {
 *     {@literal @}Override
 *     void onCaptureCompleted(CaptureRequest myRequest, CaptureResult myResult) {
 *         assert(myResult.getRequest.equals(myRequest) == true);
 *     }
 * }, null);
 * </code></pre>
 * </p>
 *
 * @return The request associated with this result. Never {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public android.hardware.camera2.CaptureRequest getRequest() { throw new RuntimeException("Stub!"); }

/**
 * Get the frame number associated with this result.
 *
 * <p>Whenever a request has been processed, regardless of failure or success,
 * it gets a unique frame number assigned to its future result/failure.</p>
 *
 * <p>For the same type of request (capturing from the camera device or reprocessing), this
 * value monotonically increments, starting with 0, for every new result or failure and the
 * scope is the lifetime of the {@link android.hardware.camera2.CameraDevice CameraDevice}. Between different types of requests,
 * the frame number may not monotonically increment. For example, the frame number of a newer
 * reprocess result may be smaller than the frame number of an older result of capturing new
 * images from the camera device, but the frame number of a newer reprocess result will never be
 * smaller than the frame number of an older reprocess result.</p>
 *
 * @return The frame number
 *
 * @see CameraDevice#createCaptureRequest
 * @see android.hardware.camera2.CameraDevice#createReprocessCaptureRequest
 * @apiSince 21
 */

public long getFrameNumber() { throw new RuntimeException("Stub!"); }

/**
 * The sequence ID for this failure that was returned by the
 * {@link android.hardware.camera2.CameraCaptureSession#capture CameraCaptureSession#capture} family of functions.
 *
 * <p>The sequence ID is a unique monotonically increasing value starting from 0,
 * incremented every time a new group of requests is submitted to the CameraDevice.</p>
 *
 * @return int The ID for the sequence of requests that this capture result is a part of
 *
 * @see android.hardware.camera2.CameraCaptureSession.CaptureCallback#onCaptureSequenceCompleted
 * @see android.hardware.camera2.CameraCaptureSession.CaptureCallback#onCaptureSequenceAborted
 * @apiSince 21
 */

public int getSequenceId() { throw new RuntimeException("Stub!"); }

/**
 * <p>Whether black-level compensation is locked
 * to its current values, or is free to vary.</p>
 * <p>Whether the black level offset was locked for this frame.  Should be
 * ON if {@link android.hardware.camera2.CaptureRequest#BLACK_LEVEL_LOCK CaptureRequest#BLACK_LEVEL_LOCK} was ON in the capture request, unless
 * a change in other capture settings forced the camera device to
 * perform a black level reset.</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Full capability</b> -
 * Present on all camera devices that report being {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CaptureRequest#BLACK_LEVEL_LOCK
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Boolean> BLACK_LEVEL_LOCK;
static { BLACK_LEVEL_LOCK = null; }

/**
 * <p>Mode of operation for the chromatic aberration correction algorithm.</p>
 * <p>Chromatic (color) aberration is caused by the fact that different wavelengths of light
 * can not focus on the same point after exiting from the lens. This metadata defines
 * the high level control of chromatic aberration correction algorithm, which aims to
 * minimize the chromatic artifacts that may occur along the object boundaries in an
 * image.</p>
 * <p>FAST/HIGH_QUALITY both mean that camera device determined aberration
 * correction will be applied. HIGH_QUALITY mode indicates that the camera device will
 * use the highest-quality aberration correction algorithms, even if it slows down
 * capture rate. FAST means the camera device will not slow down capture rate when
 * applying aberration correction.</p>
 * <p>LEGACY devices will always be in FAST mode.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #COLOR_CORRECTION_ABERRATION_MODE_OFF OFF}</li>
 *   <li>{@link #COLOR_CORRECTION_ABERRATION_MODE_FAST FAST}</li>
 *   <li>{@link #COLOR_CORRECTION_ABERRATION_MODE_HIGH_QUALITY HIGH_QUALITY}</li>
 * </ul></p>
 * <p><b>Available values for this device:</b><br>
 * {@link android.hardware.camera2.CameraCharacteristics#COLOR_CORRECTION_AVAILABLE_ABERRATION_MODES CameraCharacteristics#COLOR_CORRECTION_AVAILABLE_ABERRATION_MODES}</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#COLOR_CORRECTION_AVAILABLE_ABERRATION_MODES
 * @see #COLOR_CORRECTION_ABERRATION_MODE_OFF
 * @see #COLOR_CORRECTION_ABERRATION_MODE_FAST
 * @see #COLOR_CORRECTION_ABERRATION_MODE_HIGH_QUALITY
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> COLOR_CORRECTION_ABERRATION_MODE;
static { COLOR_CORRECTION_ABERRATION_MODE = null; }

/**
 * <p>Gains applying to Bayer raw color channels for
 * white-balance.</p>
 * <p>These per-channel gains are either set by the camera device
 * when the request {@link android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_MODE CaptureRequest#COLOR_CORRECTION_MODE} is not
 * TRANSFORM_MATRIX, or directly by the application in the
 * request when the {@link android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_MODE CaptureRequest#COLOR_CORRECTION_MODE} is
 * TRANSFORM_MATRIX.</p>
 * <p>The gains in the result metadata are the gains actually
 * applied by the camera device to the current frame.</p>
 * <p>The valid range of gains varies on different devices, but gains
 * between [1.0, 3.0] are guaranteed not to be clipped. Even if a given
 * device allows gains below 1.0, this is usually not recommended because
 * this can create color artifacts.</p>
 * <p><b>Units</b>: Unitless gain factors</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Full capability</b> -
 * Present on all camera devices that report being {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_MODE
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<android.hardware.camera2.params.RggbChannelVector> COLOR_CORRECTION_GAINS;
static { COLOR_CORRECTION_GAINS = null; }

/**
 * <p>The mode control selects how the image data is converted from the
 * sensor's native color into linear sRGB color.</p>
 * <p>When auto-white balance (AWB) is enabled with {@link android.hardware.camera2.CaptureRequest#CONTROL_AWB_MODE CaptureRequest#CONTROL_AWB_MODE}, this
 * control is overridden by the AWB routine. When AWB is disabled, the
 * application controls how the color mapping is performed.</p>
 * <p>We define the expected processing pipeline below. For consistency
 * across devices, this is always the case with TRANSFORM_MATRIX.</p>
 * <p>When either FULL or HIGH_QUALITY is used, the camera device may
 * do additional processing but {@link android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_GAINS CaptureRequest#COLOR_CORRECTION_GAINS} and
 * {@link android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_TRANSFORM CaptureRequest#COLOR_CORRECTION_TRANSFORM} will still be provided by the
 * camera device (in the results) and be roughly correct.</p>
 * <p>Switching to TRANSFORM_MATRIX and using the data provided from
 * FAST or HIGH_QUALITY will yield a picture with the same white point
 * as what was produced by the camera device in the earlier frame.</p>
 * <p>The expected processing pipeline is as follows:</p>
 * <p><img alt="White balance processing pipeline" src="/reference/images/camera2/metadata/android.colorCorrection.mode/processing_pipeline.png" /></p>
 * <p>The white balance is encoded by two values, a 4-channel white-balance
 * gain vector (applied in the Bayer domain), and a 3x3 color transform
 * matrix (applied after demosaic).</p>
 * <p>The 4-channel white-balance gains are defined as:</p>
 * <pre><code>{@link android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_GAINS CaptureRequest#COLOR_CORRECTION_GAINS} = [ R G_even G_odd B ]
 * </code></pre>
 * <p>where <code>G_even</code> is the gain for green pixels on even rows of the
 * output, and <code>G_odd</code> is the gain for green pixels on the odd rows.
 * These may be identical for a given camera device implementation; if
 * the camera device does not support a separate gain for even/odd green
 * channels, it will use the <code>G_even</code> value, and write <code>G_odd</code> equal to
 * <code>G_even</code> in the output result metadata.</p>
 * <p>The matrices for color transforms are defined as a 9-entry vector:</p>
 * <pre><code>{@link android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_TRANSFORM CaptureRequest#COLOR_CORRECTION_TRANSFORM} = [ I0 I1 I2 I3 I4 I5 I6 I7 I8 ]
 * </code></pre>
 * <p>which define a transform from input sensor colors, <code>P_in = [ r g b ]</code>,
 * to output linear sRGB, <code>P_out = [ r' g' b' ]</code>,</p>
 * <p>with colors as follows:</p>
 * <pre><code>r' = I0r + I1g + I2b
 * g' = I3r + I4g + I5b
 * b' = I6r + I7g + I8b
 * </code></pre>
 * <p>Both the input and output value ranges must match. Overflow/underflow
 * values are clipped to fit within the range.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #COLOR_CORRECTION_MODE_TRANSFORM_MATRIX TRANSFORM_MATRIX}</li>
 *   <li>{@link #COLOR_CORRECTION_MODE_FAST FAST}</li>
 *   <li>{@link #COLOR_CORRECTION_MODE_HIGH_QUALITY HIGH_QUALITY}</li>
 * </ul></p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Full capability</b> -
 * Present on all camera devices that report being {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_GAINS
 * @see android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_TRANSFORM
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AWB_MODE
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see #COLOR_CORRECTION_MODE_TRANSFORM_MATRIX
 * @see #COLOR_CORRECTION_MODE_FAST
 * @see #COLOR_CORRECTION_MODE_HIGH_QUALITY
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> COLOR_CORRECTION_MODE;
static { COLOR_CORRECTION_MODE = null; }

/**
 * <p>A color transform matrix to use to transform
 * from sensor RGB color space to output linear sRGB color space.</p>
 * <p>This matrix is either set by the camera device when the request
 * {@link android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_MODE CaptureRequest#COLOR_CORRECTION_MODE} is not TRANSFORM_MATRIX, or
 * directly by the application in the request when the
 * {@link android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_MODE CaptureRequest#COLOR_CORRECTION_MODE} is TRANSFORM_MATRIX.</p>
 * <p>In the latter case, the camera device may round the matrix to account
 * for precision issues; the final rounded matrix should be reported back
 * in this matrix result metadata. The transform should keep the magnitude
 * of the output color values within <code>[0, 1.0]</code> (assuming input color
 * values is within the normalized range <code>[0, 1.0]</code>), or clipping may occur.</p>
 * <p>The valid range of each matrix element varies on different devices, but
 * values within [-1.5, 3.0] are guaranteed not to be clipped.</p>
 * <p><b>Units</b>: Unitless scale factors</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Full capability</b> -
 * Present on all camera devices that report being {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_MODE
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<android.hardware.camera2.params.ColorSpaceTransform> COLOR_CORRECTION_TRANSFORM;
static { COLOR_CORRECTION_TRANSFORM = null; }

/**
 * <p>The desired setting for the camera device's auto-exposure
 * algorithm's antibanding compensation.</p>
 * <p>Some kinds of lighting fixtures, such as some fluorescent
 * lights, flicker at the rate of the power supply frequency
 * (60Hz or 50Hz, depending on country). While this is
 * typically not noticeable to a person, it can be visible to
 * a camera device. If a camera sets its exposure time to the
 * wrong value, the flicker may become visible in the
 * viewfinder as flicker or in a final captured image, as a
 * set of variable-brightness bands across the image.</p>
 * <p>Therefore, the auto-exposure routines of camera devices
 * include antibanding routines that ensure that the chosen
 * exposure value will not cause such banding. The choice of
 * exposure time depends on the rate of flicker, which the
 * camera device can detect automatically, or the expected
 * rate can be selected by the application using this
 * control.</p>
 * <p>A given camera device may not support all of the possible
 * options for the antibanding mode. The
 * {@link android.hardware.camera2.CameraCharacteristics#CONTROL_AE_AVAILABLE_ANTIBANDING_MODES CameraCharacteristics#CONTROL_AE_AVAILABLE_ANTIBANDING_MODES} key contains
 * the available modes for a given camera device.</p>
 * <p>AUTO mode is the default if it is available on given
 * camera device. When AUTO mode is not available, the
 * default will be either 50HZ or 60HZ, and both 50HZ
 * and 60HZ will be available.</p>
 * <p>If manual exposure control is enabled (by setting
 * {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE CaptureRequest#CONTROL_AE_MODE} or {@link android.hardware.camera2.CaptureRequest#CONTROL_MODE CaptureRequest#CONTROL_MODE} to OFF),
 * then this setting has no effect, and the application must
 * ensure it selects exposure times that do not cause banding
 * issues. The {@link android.hardware.camera2.CaptureResult#STATISTICS_SCENE_FLICKER CaptureResult#STATISTICS_SCENE_FLICKER} key can assist
 * the application in this.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #CONTROL_AE_ANTIBANDING_MODE_OFF OFF}</li>
 *   <li>{@link #CONTROL_AE_ANTIBANDING_MODE_50HZ 50HZ}</li>
 *   <li>{@link #CONTROL_AE_ANTIBANDING_MODE_60HZ 60HZ}</li>
 *   <li>{@link #CONTROL_AE_ANTIBANDING_MODE_AUTO AUTO}</li>
 * </ul></p>
 * <p><b>Available values for this device:</b><br></p>
 * <p>{@link android.hardware.camera2.CameraCharacteristics#CONTROL_AE_AVAILABLE_ANTIBANDING_MODES CameraCharacteristics#CONTROL_AE_AVAILABLE_ANTIBANDING_MODES}</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#CONTROL_AE_AVAILABLE_ANTIBANDING_MODES
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE
 * @see android.hardware.camera2.CaptureRequest#CONTROL_MODE
 * @see android.hardware.camera2.CaptureResult#STATISTICS_SCENE_FLICKER
 * @see #CONTROL_AE_ANTIBANDING_MODE_OFF
 * @see #CONTROL_AE_ANTIBANDING_MODE_50HZ
 * @see #CONTROL_AE_ANTIBANDING_MODE_60HZ
 * @see #CONTROL_AE_ANTIBANDING_MODE_AUTO
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> CONTROL_AE_ANTIBANDING_MODE;
static { CONTROL_AE_ANTIBANDING_MODE = null; }

/**
 * <p>Adjustment to auto-exposure (AE) target image
 * brightness.</p>
 * <p>The adjustment is measured as a count of steps, with the
 * step size defined by {@link android.hardware.camera2.CameraCharacteristics#CONTROL_AE_COMPENSATION_STEP CameraCharacteristics#CONTROL_AE_COMPENSATION_STEP} and the
 * allowed range by {@link android.hardware.camera2.CameraCharacteristics#CONTROL_AE_COMPENSATION_RANGE CameraCharacteristics#CONTROL_AE_COMPENSATION_RANGE}.</p>
 * <p>For example, if the exposure value (EV) step is 0.333, '6'
 * will mean an exposure compensation of +2 EV; -3 will mean an
 * exposure compensation of -1 EV. One EV represents a doubling
 * of image brightness. Note that this control will only be
 * effective if {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE CaptureRequest#CONTROL_AE_MODE} <code>!=</code> OFF. This control
 * will take effect even when {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_LOCK CaptureRequest#CONTROL_AE_LOCK} <code>== true</code>.</p>
 * <p>In the event of exposure compensation value being changed, camera device
 * may take several frames to reach the newly requested exposure target.
 * During that time, {@link android.hardware.camera2.CaptureResult#CONTROL_AE_STATE CaptureResult#CONTROL_AE_STATE} field will be in the SEARCHING
 * state. Once the new exposure target is reached, {@link android.hardware.camera2.CaptureResult#CONTROL_AE_STATE CaptureResult#CONTROL_AE_STATE} will
 * change from SEARCHING to either CONVERGED, LOCKED (if AE lock is enabled), or
 * FLASH_REQUIRED (if the scene is too dark for still capture).</p>
 * <p><b>Units</b>: Compensation steps</p>
 * <p><b>Range of valid values:</b><br>
 * {@link android.hardware.camera2.CameraCharacteristics#CONTROL_AE_COMPENSATION_RANGE CameraCharacteristics#CONTROL_AE_COMPENSATION_RANGE}</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#CONTROL_AE_COMPENSATION_RANGE
 * @see android.hardware.camera2.CameraCharacteristics#CONTROL_AE_COMPENSATION_STEP
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AE_LOCK
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE
 * @see android.hardware.camera2.CaptureResult#CONTROL_AE_STATE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> CONTROL_AE_EXPOSURE_COMPENSATION;
static { CONTROL_AE_EXPOSURE_COMPENSATION = null; }

/**
 * <p>Whether auto-exposure (AE) is currently locked to its latest
 * calculated values.</p>
 * <p>When set to <code>true</code> (ON), the AE algorithm is locked to its latest parameters,
 * and will not change exposure settings until the lock is set to <code>false</code> (OFF).</p>
 * <p>Note that even when AE is locked, the flash may be fired if
 * the {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE CaptureRequest#CONTROL_AE_MODE} is ON_AUTO_FLASH /
 * ON_ALWAYS_FLASH / ON_AUTO_FLASH_REDEYE.</p>
 * <p>When {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_EXPOSURE_COMPENSATION CaptureRequest#CONTROL_AE_EXPOSURE_COMPENSATION} is changed, even if the AE lock
 * is ON, the camera device will still adjust its exposure value.</p>
 * <p>If AE precapture is triggered (see {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_PRECAPTURE_TRIGGER CaptureRequest#CONTROL_AE_PRECAPTURE_TRIGGER})
 * when AE is already locked, the camera device will not change the exposure time
 * ({@link android.hardware.camera2.CaptureRequest#SENSOR_EXPOSURE_TIME CaptureRequest#SENSOR_EXPOSURE_TIME}) and sensitivity ({@link android.hardware.camera2.CaptureRequest#SENSOR_SENSITIVITY CaptureRequest#SENSOR_SENSITIVITY})
 * parameters. The flash may be fired if the {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE CaptureRequest#CONTROL_AE_MODE}
 * is ON_AUTO_FLASH/ON_AUTO_FLASH_REDEYE and the scene is too dark. If the
 * {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE CaptureRequest#CONTROL_AE_MODE} is ON_ALWAYS_FLASH, the scene may become overexposed.
 * Similarly, AE precapture trigger CANCEL has no effect when AE is already locked.</p>
 * <p>When an AE precapture sequence is triggered, AE unlock will not be able to unlock
 * the AE if AE is locked by the camera device internally during precapture metering
 * sequence In other words, submitting requests with AE unlock has no effect for an
 * ongoing precapture metering sequence. Otherwise, the precapture metering sequence
 * will never succeed in a sequence of preview requests where AE lock is always set
 * to <code>false</code>.</p>
 * <p>Since the camera device has a pipeline of in-flight requests, the settings that
 * get locked do not necessarily correspond to the settings that were present in the
 * latest capture result received from the camera device, since additional captures
 * and AE updates may have occurred even before the result was sent out. If an
 * application is switching between automatic and manual control and wishes to eliminate
 * any flicker during the switch, the following procedure is recommended:</p>
 * <ol>
 * <li>Starting in auto-AE mode:</li>
 * <li>Lock AE</li>
 * <li>Wait for the first result to be output that has the AE locked</li>
 * <li>Copy exposure settings from that result into a request, set the request to manual AE</li>
 * <li>Submit the capture request, proceed to run manual AE as desired.</li>
 * </ol>
 * <p>See {@link android.hardware.camera2.CaptureResult#CONTROL_AE_STATE CaptureResult#CONTROL_AE_STATE} for AE lock related state transition details.</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AE_EXPOSURE_COMPENSATION
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AE_PRECAPTURE_TRIGGER
 * @see android.hardware.camera2.CaptureResult#CONTROL_AE_STATE
 * @see android.hardware.camera2.CaptureRequest#SENSOR_EXPOSURE_TIME
 * @see android.hardware.camera2.CaptureRequest#SENSOR_SENSITIVITY
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Boolean> CONTROL_AE_LOCK;
static { CONTROL_AE_LOCK = null; }

/**
 * <p>The desired mode for the camera device's
 * auto-exposure routine.</p>
 * <p>This control is only effective if {@link android.hardware.camera2.CaptureRequest#CONTROL_MODE CaptureRequest#CONTROL_MODE} is
 * AUTO.</p>
 * <p>When set to any of the ON modes, the camera device's
 * auto-exposure routine is enabled, overriding the
 * application's selected exposure time, sensor sensitivity,
 * and frame duration ({@link android.hardware.camera2.CaptureRequest#SENSOR_EXPOSURE_TIME CaptureRequest#SENSOR_EXPOSURE_TIME},
 * {@link android.hardware.camera2.CaptureRequest#SENSOR_SENSITIVITY CaptureRequest#SENSOR_SENSITIVITY}, and
 * {@link android.hardware.camera2.CaptureRequest#SENSOR_FRAME_DURATION CaptureRequest#SENSOR_FRAME_DURATION}). If one of the FLASH modes
 * is selected, the camera device's flash unit controls are
 * also overridden.</p>
 * <p>The FLASH modes are only available if the camera device
 * has a flash unit ({@link android.hardware.camera2.CameraCharacteristics#FLASH_INFO_AVAILABLE CameraCharacteristics#FLASH_INFO_AVAILABLE} is <code>true</code>).</p>
 * <p>If flash TORCH mode is desired, this field must be set to
 * ON or OFF, and {@link android.hardware.camera2.CaptureRequest#FLASH_MODE CaptureRequest#FLASH_MODE} set to TORCH.</p>
 * <p>When set to any of the ON modes, the values chosen by the
 * camera device auto-exposure routine for the overridden
 * fields for a given capture will be available in its
 * CaptureResult.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #CONTROL_AE_MODE_OFF OFF}</li>
 *   <li>{@link #CONTROL_AE_MODE_ON ON}</li>
 *   <li>{@link #CONTROL_AE_MODE_ON_AUTO_FLASH ON_AUTO_FLASH}</li>
 *   <li>{@link #CONTROL_AE_MODE_ON_ALWAYS_FLASH ON_ALWAYS_FLASH}</li>
 *   <li>{@link #CONTROL_AE_MODE_ON_AUTO_FLASH_REDEYE ON_AUTO_FLASH_REDEYE}</li>
 *   <li>{@link #CONTROL_AE_MODE_ON_EXTERNAL_FLASH ON_EXTERNAL_FLASH}</li>
 * </ul></p>
 * <p><b>Available values for this device:</b><br>
 * {@link android.hardware.camera2.CameraCharacteristics#CONTROL_AE_AVAILABLE_MODES CameraCharacteristics#CONTROL_AE_AVAILABLE_MODES}</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#CONTROL_AE_AVAILABLE_MODES
 * @see android.hardware.camera2.CaptureRequest#CONTROL_MODE
 * @see android.hardware.camera2.CameraCharacteristics#FLASH_INFO_AVAILABLE
 * @see android.hardware.camera2.CaptureRequest#FLASH_MODE
 * @see android.hardware.camera2.CaptureRequest#SENSOR_EXPOSURE_TIME
 * @see android.hardware.camera2.CaptureRequest#SENSOR_FRAME_DURATION
 * @see android.hardware.camera2.CaptureRequest#SENSOR_SENSITIVITY
 * @see #CONTROL_AE_MODE_OFF
 * @see #CONTROL_AE_MODE_ON
 * @see #CONTROL_AE_MODE_ON_AUTO_FLASH
 * @see #CONTROL_AE_MODE_ON_ALWAYS_FLASH
 * @see #CONTROL_AE_MODE_ON_AUTO_FLASH_REDEYE
 * @see #CONTROL_AE_MODE_ON_EXTERNAL_FLASH
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> CONTROL_AE_MODE;
static { CONTROL_AE_MODE = null; }

/**
 * <p>Whether the camera device will trigger a precapture
 * metering sequence when it processes this request.</p>
 * <p>This entry is normally set to IDLE, or is not
 * included at all in the request settings. When included and
 * set to START, the camera device will trigger the auto-exposure (AE)
 * precapture metering sequence.</p>
 * <p>When set to CANCEL, the camera device will cancel any active
 * precapture metering trigger, and return to its initial AE state.
 * If a precapture metering sequence is already completed, and the camera
 * device has implicitly locked the AE for subsequent still capture, the
 * CANCEL trigger will unlock the AE and return to its initial AE state.</p>
 * <p>The precapture sequence should be triggered before starting a
 * high-quality still capture for final metering decisions to
 * be made, and for firing pre-capture flash pulses to estimate
 * scene brightness and required final capture flash power, when
 * the flash is enabled.</p>
 * <p>Normally, this entry should be set to START for only a
 * single request, and the application should wait until the
 * sequence completes before starting a new one.</p>
 * <p>When a precapture metering sequence is finished, the camera device
 * may lock the auto-exposure routine internally to be able to accurately expose the
 * subsequent still capture image (<code>{@link android.hardware.camera2.CaptureRequest#CONTROL_CAPTURE_INTENT CaptureRequest#CONTROL_CAPTURE_INTENT} == STILL_CAPTURE</code>).
 * For this case, the AE may not resume normal scan if no subsequent still capture is
 * submitted. To ensure that the AE routine restarts normal scan, the application should
 * submit a request with <code>{@link android.hardware.camera2.CaptureRequest#CONTROL_AE_LOCK CaptureRequest#CONTROL_AE_LOCK} == true</code>, followed by a request
 * with <code>{@link android.hardware.camera2.CaptureRequest#CONTROL_AE_LOCK CaptureRequest#CONTROL_AE_LOCK} == false</code>, if the application decides not to submit a
 * still capture request after the precapture sequence completes. Alternatively, for
 * API level 23 or newer devices, the CANCEL can be used to unlock the camera device
 * internally locked AE if the application doesn't submit a still capture request after
 * the AE precapture trigger. Note that, the CANCEL was added in API level 23, and must not
 * be used in devices that have earlier API levels.</p>
 * <p>The exact effect of auto-exposure (AE) precapture trigger
 * depends on the current AE mode and state; see
 * {@link android.hardware.camera2.CaptureResult#CONTROL_AE_STATE CaptureResult#CONTROL_AE_STATE} for AE precapture state transition
 * details.</p>
 * <p>On LEGACY-level devices, the precapture trigger is not supported;
 * capturing a high-resolution JPEG image will automatically trigger a
 * precapture sequence before the high-resolution capture, including
 * potentially firing a pre-capture flash.</p>
 * <p>Using the precapture trigger and the auto-focus trigger {@link android.hardware.camera2.CaptureRequest#CONTROL_AF_TRIGGER CaptureRequest#CONTROL_AF_TRIGGER}
 * simultaneously is allowed. However, since these triggers often require cooperation between
 * the auto-focus and auto-exposure routines (for example, the may need to be enabled for a
 * focus sweep), the camera device may delay acting on a later trigger until the previous
 * trigger has been fully handled. This may lead to longer intervals between the trigger and
 * changes to {@link android.hardware.camera2.CaptureResult#CONTROL_AE_STATE CaptureResult#CONTROL_AE_STATE} indicating the start of the precapture sequence, for
 * example.</p>
 * <p>If both the precapture and the auto-focus trigger are activated on the same request, then
 * the camera device will complete them in the optimal order for that device.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #CONTROL_AE_PRECAPTURE_TRIGGER_IDLE IDLE}</li>
 *   <li>{@link #CONTROL_AE_PRECAPTURE_TRIGGER_START START}</li>
 *   <li>{@link #CONTROL_AE_PRECAPTURE_TRIGGER_CANCEL CANCEL}</li>
 * </ul></p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Limited capability</b> -
 * Present on all camera devices that report being at least {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AE_LOCK
 * @see android.hardware.camera2.CaptureResult#CONTROL_AE_STATE
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AF_TRIGGER
 * @see android.hardware.camera2.CaptureRequest#CONTROL_CAPTURE_INTENT
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see #CONTROL_AE_PRECAPTURE_TRIGGER_IDLE
 * @see #CONTROL_AE_PRECAPTURE_TRIGGER_START
 * @see #CONTROL_AE_PRECAPTURE_TRIGGER_CANCEL
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> CONTROL_AE_PRECAPTURE_TRIGGER;
static { CONTROL_AE_PRECAPTURE_TRIGGER = null; }

/**
 * <p>List of metering areas to use for auto-exposure adjustment.</p>
 * <p>Not available if {@link android.hardware.camera2.CameraCharacteristics#CONTROL_MAX_REGIONS_AE CameraCharacteristics#CONTROL_MAX_REGIONS_AE} is 0.
 * Otherwise will always be present.</p>
 * <p>The maximum number of regions supported by the device is determined by the value
 * of {@link android.hardware.camera2.CameraCharacteristics#CONTROL_MAX_REGIONS_AE CameraCharacteristics#CONTROL_MAX_REGIONS_AE}.</p>
 * <p>For devices not supporting {@link android.hardware.camera2.CaptureRequest#DISTORTION_CORRECTION_MODE CaptureRequest#DISTORTION_CORRECTION_MODE} control, the coordinate
 * system always follows that of {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE}, with (0,0) being
 * the top-left pixel in the active pixel array, and
 * ({@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE}.width - 1,
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE}.height - 1) being the bottom-right pixel in the
 * active pixel array.</p>
 * <p>For devices supporting {@link android.hardware.camera2.CaptureRequest#DISTORTION_CORRECTION_MODE CaptureRequest#DISTORTION_CORRECTION_MODE} control, the coordinate
 * system depends on the mode being set.
 * When the distortion correction mode is OFF, the coordinate system follows
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE}, with
 * <code>(0, 0)</code> being the top-left pixel of the pre-correction active array, and
 * ({@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE}.width - 1,
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE}.height - 1) being the bottom-right
 * pixel in the pre-correction active pixel array.
 * When the distortion correction mode is not OFF, the coordinate system follows
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE}, with
 * <code>(0, 0)</code> being the top-left pixel of the active array, and
 * ({@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE}.width - 1,
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE}.height - 1) being the bottom-right pixel in the
 * active pixel array.</p>
 * <p>The weight must be within <code>[0, 1000]</code>, and represents a weight
 * for every pixel in the area. This means that a large metering area
 * with the same weight as a smaller area will have more effect in
 * the metering result. Metering areas can partially overlap and the
 * camera device will add the weights in the overlap region.</p>
 * <p>The weights are relative to weights of other exposure metering regions, so if only one
 * region is used, all non-zero weights will have the same effect. A region with 0
 * weight is ignored.</p>
 * <p>If all regions have 0 weight, then no specific metering area needs to be used by the
 * camera device.</p>
 * <p>If the metering region is outside the used {@link android.hardware.camera2.CaptureRequest#SCALER_CROP_REGION CaptureRequest#SCALER_CROP_REGION} returned in
 * capture result metadata, the camera device will ignore the sections outside the crop
 * region and output only the intersection rectangle as the metering region in the result
 * metadata.  If the region is entirely outside the crop region, it will be ignored and
 * not reported in the result metadata.</p>
 * <p><b>Units</b>: Pixel coordinates within {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE} or
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE} depending on
 * distortion correction capability and mode</p>
 * <p><b>Range of valid values:</b><br>
 * Coordinates must be between <code>[(0,0), (width, height))</code> of
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE} or {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE}
 * depending on distortion correction capability and mode</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#CONTROL_MAX_REGIONS_AE
 * @see android.hardware.camera2.CaptureRequest#DISTORTION_CORRECTION_MODE
 * @see android.hardware.camera2.CaptureRequest#SCALER_CROP_REGION
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<android.hardware.camera2.params.MeteringRectangle[]> CONTROL_AE_REGIONS;
static { CONTROL_AE_REGIONS = null; }

/**
 * <p>Current state of the auto-exposure (AE) algorithm.</p>
 * <p>Switching between or enabling AE modes ({@link android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE CaptureRequest#CONTROL_AE_MODE}) always
 * resets the AE state to INACTIVE. Similarly, switching between {@link android.hardware.camera2.CaptureRequest#CONTROL_MODE CaptureRequest#CONTROL_MODE},
 * or {@link android.hardware.camera2.CaptureRequest#CONTROL_SCENE_MODE CaptureRequest#CONTROL_SCENE_MODE} if <code>{@link android.hardware.camera2.CaptureRequest#CONTROL_MODE CaptureRequest#CONTROL_MODE} == USE_SCENE_MODE</code> resets all
 * the algorithm states to INACTIVE.</p>
 * <p>The camera device can do several state transitions between two results, if it is
 * allowed by the state transition table. For example: INACTIVE may never actually be
 * seen in a result.</p>
 * <p>The state in the result is the state for this image (in sync with this image): if
 * AE state becomes CONVERGED, then the image data associated with this result should
 * be good to use.</p>
 * <p>Below are state transition tables for different AE modes.</p>
 * <table>
 * <thead>
 * <tr>
 * <th align="center">State</th>
 * <th align="center">Transition Cause</th>
 * <th align="center">New State</th>
 * <th align="center">Notes</th>
 * </tr>
 * </thead>
 * <tbody>
 * <tr>
 * <td align="center">INACTIVE</td>
 * <td align="center"></td>
 * <td align="center">INACTIVE</td>
 * <td align="center">Camera device auto exposure algorithm is disabled</td>
 * </tr>
 * </tbody>
 * </table>
 * <p>When {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE CaptureRequest#CONTROL_AE_MODE} is AE_MODE_ON*:</p>
 * <table>
 * <thead>
 * <tr>
 * <th align="center">State</th>
 * <th align="center">Transition Cause</th>
 * <th align="center">New State</th>
 * <th align="center">Notes</th>
 * </tr>
 * </thead>
 * <tbody>
 * <tr>
 * <td align="center">INACTIVE</td>
 * <td align="center">Camera device initiates AE scan</td>
 * <td align="center">SEARCHING</td>
 * <td align="center">Values changing</td>
 * </tr>
 * <tr>
 * <td align="center">INACTIVE</td>
 * <td align="center">{@link android.hardware.camera2.CaptureRequest#CONTROL_AE_LOCK CaptureRequest#CONTROL_AE_LOCK} is ON</td>
 * <td align="center">LOCKED</td>
 * <td align="center">Values locked</td>
 * </tr>
 * <tr>
 * <td align="center">SEARCHING</td>
 * <td align="center">Camera device finishes AE scan</td>
 * <td align="center">CONVERGED</td>
 * <td align="center">Good values, not changing</td>
 * </tr>
 * <tr>
 * <td align="center">SEARCHING</td>
 * <td align="center">Camera device finishes AE scan</td>
 * <td align="center">FLASH_REQUIRED</td>
 * <td align="center">Converged but too dark w/o flash</td>
 * </tr>
 * <tr>
 * <td align="center">SEARCHING</td>
 * <td align="center">{@link android.hardware.camera2.CaptureRequest#CONTROL_AE_LOCK CaptureRequest#CONTROL_AE_LOCK} is ON</td>
 * <td align="center">LOCKED</td>
 * <td align="center">Values locked</td>
 * </tr>
 * <tr>
 * <td align="center">CONVERGED</td>
 * <td align="center">Camera device initiates AE scan</td>
 * <td align="center">SEARCHING</td>
 * <td align="center">Values changing</td>
 * </tr>
 * <tr>
 * <td align="center">CONVERGED</td>
 * <td align="center">{@link android.hardware.camera2.CaptureRequest#CONTROL_AE_LOCK CaptureRequest#CONTROL_AE_LOCK} is ON</td>
 * <td align="center">LOCKED</td>
 * <td align="center">Values locked</td>
 * </tr>
 * <tr>
 * <td align="center">FLASH_REQUIRED</td>
 * <td align="center">Camera device initiates AE scan</td>
 * <td align="center">SEARCHING</td>
 * <td align="center">Values changing</td>
 * </tr>
 * <tr>
 * <td align="center">FLASH_REQUIRED</td>
 * <td align="center">{@link android.hardware.camera2.CaptureRequest#CONTROL_AE_LOCK CaptureRequest#CONTROL_AE_LOCK} is ON</td>
 * <td align="center">LOCKED</td>
 * <td align="center">Values locked</td>
 * </tr>
 * <tr>
 * <td align="center">LOCKED</td>
 * <td align="center">{@link android.hardware.camera2.CaptureRequest#CONTROL_AE_LOCK CaptureRequest#CONTROL_AE_LOCK} is OFF</td>
 * <td align="center">SEARCHING</td>
 * <td align="center">Values not good after unlock</td>
 * </tr>
 * <tr>
 * <td align="center">LOCKED</td>
 * <td align="center">{@link android.hardware.camera2.CaptureRequest#CONTROL_AE_LOCK CaptureRequest#CONTROL_AE_LOCK} is OFF</td>
 * <td align="center">CONVERGED</td>
 * <td align="center">Values good after unlock</td>
 * </tr>
 * <tr>
 * <td align="center">LOCKED</td>
 * <td align="center">{@link android.hardware.camera2.CaptureRequest#CONTROL_AE_LOCK CaptureRequest#CONTROL_AE_LOCK} is OFF</td>
 * <td align="center">FLASH_REQUIRED</td>
 * <td align="center">Exposure good, but too dark</td>
 * </tr>
 * <tr>
 * <td align="center">PRECAPTURE</td>
 * <td align="center">Sequence done. {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_LOCK CaptureRequest#CONTROL_AE_LOCK} is OFF</td>
 * <td align="center">CONVERGED</td>
 * <td align="center">Ready for high-quality capture</td>
 * </tr>
 * <tr>
 * <td align="center">PRECAPTURE</td>
 * <td align="center">Sequence done. {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_LOCK CaptureRequest#CONTROL_AE_LOCK} is ON</td>
 * <td align="center">LOCKED</td>
 * <td align="center">Ready for high-quality capture</td>
 * </tr>
 * <tr>
 * <td align="center">LOCKED</td>
 * <td align="center">aeLock is ON and aePrecaptureTrigger is START</td>
 * <td align="center">LOCKED</td>
 * <td align="center">Precapture trigger is ignored when AE is already locked</td>
 * </tr>
 * <tr>
 * <td align="center">LOCKED</td>
 * <td align="center">aeLock is ON and aePrecaptureTrigger is CANCEL</td>
 * <td align="center">LOCKED</td>
 * <td align="center">Precapture trigger is ignored when AE is already locked</td>
 * </tr>
 * <tr>
 * <td align="center">Any state (excluding LOCKED)</td>
 * <td align="center">{@link android.hardware.camera2.CaptureRequest#CONTROL_AE_PRECAPTURE_TRIGGER CaptureRequest#CONTROL_AE_PRECAPTURE_TRIGGER} is START</td>
 * <td align="center">PRECAPTURE</td>
 * <td align="center">Start AE precapture metering sequence</td>
 * </tr>
 * <tr>
 * <td align="center">Any state (excluding LOCKED)</td>
 * <td align="center">{@link android.hardware.camera2.CaptureRequest#CONTROL_AE_PRECAPTURE_TRIGGER CaptureRequest#CONTROL_AE_PRECAPTURE_TRIGGER} is CANCEL</td>
 * <td align="center">INACTIVE</td>
 * <td align="center">Currently active precapture metering sequence is canceled</td>
 * </tr>
 * </tbody>
 * </table>
 * <p>If the camera device supports AE external flash mode (ON_EXTERNAL_FLASH is included in
 * {@link android.hardware.camera2.CameraCharacteristics#CONTROL_AE_AVAILABLE_MODES CameraCharacteristics#CONTROL_AE_AVAILABLE_MODES}), {@link android.hardware.camera2.CaptureResult#CONTROL_AE_STATE CaptureResult#CONTROL_AE_STATE} must be FLASH_REQUIRED after
 * the camera device finishes AE scan and it's too dark without flash.</p>
 * <p>For the above table, the camera device may skip reporting any state changes that happen
 * without application intervention (i.e. mode switch, trigger, locking). Any state that
 * can be skipped in that manner is called a transient state.</p>
 * <p>For example, for above AE modes (AE_MODE_ON*), in addition to the state transitions
 * listed in above table, it is also legal for the camera device to skip one or more
 * transient states between two results. See below table for examples:</p>
 * <table>
 * <thead>
 * <tr>
 * <th align="center">State</th>
 * <th align="center">Transition Cause</th>
 * <th align="center">New State</th>
 * <th align="center">Notes</th>
 * </tr>
 * </thead>
 * <tbody>
 * <tr>
 * <td align="center">INACTIVE</td>
 * <td align="center">Camera device finished AE scan</td>
 * <td align="center">CONVERGED</td>
 * <td align="center">Values are already good, transient states are skipped by camera device.</td>
 * </tr>
 * <tr>
 * <td align="center">Any state (excluding LOCKED)</td>
 * <td align="center">{@link android.hardware.camera2.CaptureRequest#CONTROL_AE_PRECAPTURE_TRIGGER CaptureRequest#CONTROL_AE_PRECAPTURE_TRIGGER} is START, sequence done</td>
 * <td align="center">FLASH_REQUIRED</td>
 * <td align="center">Converged but too dark w/o flash after a precapture sequence, transient states are skipped by camera device.</td>
 * </tr>
 * <tr>
 * <td align="center">Any state (excluding LOCKED)</td>
 * <td align="center">{@link android.hardware.camera2.CaptureRequest#CONTROL_AE_PRECAPTURE_TRIGGER CaptureRequest#CONTROL_AE_PRECAPTURE_TRIGGER} is START, sequence done</td>
 * <td align="center">CONVERGED</td>
 * <td align="center">Converged after a precapture sequence, transient states are skipped by camera device.</td>
 * </tr>
 * <tr>
 * <td align="center">Any state (excluding LOCKED)</td>
 * <td align="center">{@link android.hardware.camera2.CaptureRequest#CONTROL_AE_PRECAPTURE_TRIGGER CaptureRequest#CONTROL_AE_PRECAPTURE_TRIGGER} is CANCEL, converged</td>
 * <td align="center">FLASH_REQUIRED</td>
 * <td align="center">Converged but too dark w/o flash after a precapture sequence is canceled, transient states are skipped by camera device.</td>
 * </tr>
 * <tr>
 * <td align="center">Any state (excluding LOCKED)</td>
 * <td align="center">{@link android.hardware.camera2.CaptureRequest#CONTROL_AE_PRECAPTURE_TRIGGER CaptureRequest#CONTROL_AE_PRECAPTURE_TRIGGER} is CANCEL, converged</td>
 * <td align="center">CONVERGED</td>
 * <td align="center">Converged after a precapture sequenceis canceled, transient states are skipped by camera device.</td>
 * </tr>
 * <tr>
 * <td align="center">CONVERGED</td>
 * <td align="center">Camera device finished AE scan</td>
 * <td align="center">FLASH_REQUIRED</td>
 * <td align="center">Converged but too dark w/o flash after a new scan, transient states are skipped by camera device.</td>
 * </tr>
 * <tr>
 * <td align="center">FLASH_REQUIRED</td>
 * <td align="center">Camera device finished AE scan</td>
 * <td align="center">CONVERGED</td>
 * <td align="center">Converged after a new scan, transient states are skipped by camera device.</td>
 * </tr>
 * </tbody>
 * </table>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #CONTROL_AE_STATE_INACTIVE INACTIVE}</li>
 *   <li>{@link #CONTROL_AE_STATE_SEARCHING SEARCHING}</li>
 *   <li>{@link #CONTROL_AE_STATE_CONVERGED CONVERGED}</li>
 *   <li>{@link #CONTROL_AE_STATE_LOCKED LOCKED}</li>
 *   <li>{@link #CONTROL_AE_STATE_FLASH_REQUIRED FLASH_REQUIRED}</li>
 *   <li>{@link #CONTROL_AE_STATE_PRECAPTURE PRECAPTURE}</li>
 * </ul></p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Limited capability</b> -
 * Present on all camera devices that report being at least {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#CONTROL_AE_AVAILABLE_MODES
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AE_LOCK
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AE_PRECAPTURE_TRIGGER
 * @see android.hardware.camera2.CaptureResult#CONTROL_AE_STATE
 * @see android.hardware.camera2.CaptureRequest#CONTROL_MODE
 * @see android.hardware.camera2.CaptureRequest#CONTROL_SCENE_MODE
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see #CONTROL_AE_STATE_INACTIVE
 * @see #CONTROL_AE_STATE_SEARCHING
 * @see #CONTROL_AE_STATE_CONVERGED
 * @see #CONTROL_AE_STATE_LOCKED
 * @see #CONTROL_AE_STATE_FLASH_REQUIRED
 * @see #CONTROL_AE_STATE_PRECAPTURE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> CONTROL_AE_STATE;
static { CONTROL_AE_STATE = null; }

/**
 * <p>Range over which the auto-exposure routine can
 * adjust the capture frame rate to maintain good
 * exposure.</p>
 * <p>Only constrains auto-exposure (AE) algorithm, not
 * manual control of {@link android.hardware.camera2.CaptureRequest#SENSOR_EXPOSURE_TIME CaptureRequest#SENSOR_EXPOSURE_TIME} and
 * {@link android.hardware.camera2.CaptureRequest#SENSOR_FRAME_DURATION CaptureRequest#SENSOR_FRAME_DURATION}.</p>
 * <p><b>Units</b>: Frames per second (FPS)</p>
 * <p><b>Range of valid values:</b><br>
 * Any of the entries in {@link android.hardware.camera2.CameraCharacteristics#CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES CameraCharacteristics#CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES}</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES
 * @see android.hardware.camera2.CaptureRequest#SENSOR_EXPOSURE_TIME
 * @see android.hardware.camera2.CaptureRequest#SENSOR_FRAME_DURATION
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<android.util.Range<java.lang.Integer>> CONTROL_AE_TARGET_FPS_RANGE;
static { CONTROL_AE_TARGET_FPS_RANGE = null; }

/**
 * <p>Whether auto-focus (AF) is currently enabled, and what
 * mode it is set to.</p>
 * <p>Only effective if {@link android.hardware.camera2.CaptureRequest#CONTROL_MODE CaptureRequest#CONTROL_MODE} = AUTO and the lens is not fixed focus
 * (i.e. <code>{@link android.hardware.camera2.CameraCharacteristics#LENS_INFO_MINIMUM_FOCUS_DISTANCE CameraCharacteristics#LENS_INFO_MINIMUM_FOCUS_DISTANCE} &gt; 0</code>). Also note that
 * when {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE CaptureRequest#CONTROL_AE_MODE} is OFF, the behavior of AF is device
 * dependent. It is recommended to lock AF by using {@link android.hardware.camera2.CaptureRequest#CONTROL_AF_TRIGGER CaptureRequest#CONTROL_AF_TRIGGER} before
 * setting {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE CaptureRequest#CONTROL_AE_MODE} to OFF, or set AF mode to OFF when AE is OFF.</p>
 * <p>If the lens is controlled by the camera device auto-focus algorithm,
 * the camera device will report the current AF status in {@link android.hardware.camera2.CaptureResult#CONTROL_AF_STATE CaptureResult#CONTROL_AF_STATE}
 * in result metadata.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #CONTROL_AF_MODE_OFF OFF}</li>
 *   <li>{@link #CONTROL_AF_MODE_AUTO AUTO}</li>
 *   <li>{@link #CONTROL_AF_MODE_MACRO MACRO}</li>
 *   <li>{@link #CONTROL_AF_MODE_CONTINUOUS_VIDEO CONTINUOUS_VIDEO}</li>
 *   <li>{@link #CONTROL_AF_MODE_CONTINUOUS_PICTURE CONTINUOUS_PICTURE}</li>
 *   <li>{@link #CONTROL_AF_MODE_EDOF EDOF}</li>
 * </ul></p>
 * <p><b>Available values for this device:</b><br>
 * {@link android.hardware.camera2.CameraCharacteristics#CONTROL_AF_AVAILABLE_MODES CameraCharacteristics#CONTROL_AF_AVAILABLE_MODES}</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE
 * @see android.hardware.camera2.CameraCharacteristics#CONTROL_AF_AVAILABLE_MODES
 * @see android.hardware.camera2.CaptureResult#CONTROL_AF_STATE
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AF_TRIGGER
 * @see android.hardware.camera2.CaptureRequest#CONTROL_MODE
 * @see android.hardware.camera2.CameraCharacteristics#LENS_INFO_MINIMUM_FOCUS_DISTANCE
 * @see #CONTROL_AF_MODE_OFF
 * @see #CONTROL_AF_MODE_AUTO
 * @see #CONTROL_AF_MODE_MACRO
 * @see #CONTROL_AF_MODE_CONTINUOUS_VIDEO
 * @see #CONTROL_AF_MODE_CONTINUOUS_PICTURE
 * @see #CONTROL_AF_MODE_EDOF
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> CONTROL_AF_MODE;
static { CONTROL_AF_MODE = null; }

/**
 * <p>List of metering areas to use for auto-focus.</p>
 * <p>Not available if {@link android.hardware.camera2.CameraCharacteristics#CONTROL_MAX_REGIONS_AF CameraCharacteristics#CONTROL_MAX_REGIONS_AF} is 0.
 * Otherwise will always be present.</p>
 * <p>The maximum number of focus areas supported by the device is determined by the value
 * of {@link android.hardware.camera2.CameraCharacteristics#CONTROL_MAX_REGIONS_AF CameraCharacteristics#CONTROL_MAX_REGIONS_AF}.</p>
 * <p>For devices not supporting {@link android.hardware.camera2.CaptureRequest#DISTORTION_CORRECTION_MODE CaptureRequest#DISTORTION_CORRECTION_MODE} control, the coordinate
 * system always follows that of {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE}, with (0,0) being
 * the top-left pixel in the active pixel array, and
 * ({@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE}.width - 1,
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE}.height - 1) being the bottom-right pixel in the
 * active pixel array.</p>
 * <p>For devices supporting {@link android.hardware.camera2.CaptureRequest#DISTORTION_CORRECTION_MODE CaptureRequest#DISTORTION_CORRECTION_MODE} control, the coordinate
 * system depends on the mode being set.
 * When the distortion correction mode is OFF, the coordinate system follows
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE}, with
 * <code>(0, 0)</code> being the top-left pixel of the pre-correction active array, and
 * ({@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE}.width - 1,
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE}.height - 1) being the bottom-right
 * pixel in the pre-correction active pixel array.
 * When the distortion correction mode is not OFF, the coordinate system follows
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE}, with
 * <code>(0, 0)</code> being the top-left pixel of the active array, and
 * ({@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE}.width - 1,
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE}.height - 1) being the bottom-right pixel in the
 * active pixel array.</p>
 * <p>The weight must be within <code>[0, 1000]</code>, and represents a weight
 * for every pixel in the area. This means that a large metering area
 * with the same weight as a smaller area will have more effect in
 * the metering result. Metering areas can partially overlap and the
 * camera device will add the weights in the overlap region.</p>
 * <p>The weights are relative to weights of other metering regions, so if only one region
 * is used, all non-zero weights will have the same effect. A region with 0 weight is
 * ignored.</p>
 * <p>If all regions have 0 weight, then no specific metering area needs to be used by the
 * camera device. The capture result will either be a zero weight region as well, or
 * the region selected by the camera device as the focus area of interest.</p>
 * <p>If the metering region is outside the used {@link android.hardware.camera2.CaptureRequest#SCALER_CROP_REGION CaptureRequest#SCALER_CROP_REGION} returned in
 * capture result metadata, the camera device will ignore the sections outside the crop
 * region and output only the intersection rectangle as the metering region in the result
 * metadata. If the region is entirely outside the crop region, it will be ignored and
 * not reported in the result metadata.</p>
 * <p><b>Units</b>: Pixel coordinates within {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE} or
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE} depending on
 * distortion correction capability and mode</p>
 * <p><b>Range of valid values:</b><br>
 * Coordinates must be between <code>[(0,0), (width, height))</code> of
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE} or {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE}
 * depending on distortion correction capability and mode</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#CONTROL_MAX_REGIONS_AF
 * @see android.hardware.camera2.CaptureRequest#DISTORTION_CORRECTION_MODE
 * @see android.hardware.camera2.CaptureRequest#SCALER_CROP_REGION
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<android.hardware.camera2.params.MeteringRectangle[]> CONTROL_AF_REGIONS;
static { CONTROL_AF_REGIONS = null; }

/**
 * <p>Whether a significant scene change is detected within the currently-set AF
 * region(s).</p>
 * <p>When the camera focus routine detects a change in the scene it is looking at,
 * such as a large shift in camera viewpoint, significant motion in the scene, or a
 * significant illumination change, this value will be set to DETECTED for a single capture
 * result. Otherwise the value will be NOT_DETECTED. The threshold for detection is similar
 * to what would trigger a new passive focus scan to begin in CONTINUOUS autofocus modes.</p>
 * <p>This key will be available if the camera device advertises this key via {@link android.hardware.camera2.CameraCharacteristics#getAvailableCaptureResultKeys }.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #CONTROL_AF_SCENE_CHANGE_NOT_DETECTED NOT_DETECTED}</li>
 *   <li>{@link #CONTROL_AF_SCENE_CHANGE_DETECTED DETECTED}</li>
 * </ul></p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * @see #CONTROL_AF_SCENE_CHANGE_NOT_DETECTED
 * @see #CONTROL_AF_SCENE_CHANGE_DETECTED
 * @apiSince 28
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> CONTROL_AF_SCENE_CHANGE;
static { CONTROL_AF_SCENE_CHANGE = null; }

/**
 * <p>Current state of auto-focus (AF) algorithm.</p>
 * <p>Switching between or enabling AF modes ({@link android.hardware.camera2.CaptureRequest#CONTROL_AF_MODE CaptureRequest#CONTROL_AF_MODE}) always
 * resets the AF state to INACTIVE. Similarly, switching between {@link android.hardware.camera2.CaptureRequest#CONTROL_MODE CaptureRequest#CONTROL_MODE},
 * or {@link android.hardware.camera2.CaptureRequest#CONTROL_SCENE_MODE CaptureRequest#CONTROL_SCENE_MODE} if <code>{@link android.hardware.camera2.CaptureRequest#CONTROL_MODE CaptureRequest#CONTROL_MODE} == USE_SCENE_MODE</code> resets all
 * the algorithm states to INACTIVE.</p>
 * <p>The camera device can do several state transitions between two results, if it is
 * allowed by the state transition table. For example: INACTIVE may never actually be
 * seen in a result.</p>
 * <p>The state in the result is the state for this image (in sync with this image): if
 * AF state becomes FOCUSED, then the image data associated with this result should
 * be sharp.</p>
 * <p>Below are state transition tables for different AF modes.</p>
 * <p>When {@link android.hardware.camera2.CaptureRequest#CONTROL_AF_MODE CaptureRequest#CONTROL_AF_MODE} is AF_MODE_OFF or AF_MODE_EDOF:</p>
 * <table>
 * <thead>
 * <tr>
 * <th align="center">State</th>
 * <th align="center">Transition Cause</th>
 * <th align="center">New State</th>
 * <th align="center">Notes</th>
 * </tr>
 * </thead>
 * <tbody>
 * <tr>
 * <td align="center">INACTIVE</td>
 * <td align="center"></td>
 * <td align="center">INACTIVE</td>
 * <td align="center">Never changes</td>
 * </tr>
 * </tbody>
 * </table>
 * <p>When {@link android.hardware.camera2.CaptureRequest#CONTROL_AF_MODE CaptureRequest#CONTROL_AF_MODE} is AF_MODE_AUTO or AF_MODE_MACRO:</p>
 * <table>
 * <thead>
 * <tr>
 * <th align="center">State</th>
 * <th align="center">Transition Cause</th>
 * <th align="center">New State</th>
 * <th align="center">Notes</th>
 * </tr>
 * </thead>
 * <tbody>
 * <tr>
 * <td align="center">INACTIVE</td>
 * <td align="center">AF_TRIGGER</td>
 * <td align="center">ACTIVE_SCAN</td>
 * <td align="center">Start AF sweep, Lens now moving</td>
 * </tr>
 * <tr>
 * <td align="center">ACTIVE_SCAN</td>
 * <td align="center">AF sweep done</td>
 * <td align="center">FOCUSED_LOCKED</td>
 * <td align="center">Focused, Lens now locked</td>
 * </tr>
 * <tr>
 * <td align="center">ACTIVE_SCAN</td>
 * <td align="center">AF sweep done</td>
 * <td align="center">NOT_FOCUSED_LOCKED</td>
 * <td align="center">Not focused, Lens now locked</td>
 * </tr>
 * <tr>
 * <td align="center">ACTIVE_SCAN</td>
 * <td align="center">AF_CANCEL</td>
 * <td align="center">INACTIVE</td>
 * <td align="center">Cancel/reset AF, Lens now locked</td>
 * </tr>
 * <tr>
 * <td align="center">FOCUSED_LOCKED</td>
 * <td align="center">AF_CANCEL</td>
 * <td align="center">INACTIVE</td>
 * <td align="center">Cancel/reset AF</td>
 * </tr>
 * <tr>
 * <td align="center">FOCUSED_LOCKED</td>
 * <td align="center">AF_TRIGGER</td>
 * <td align="center">ACTIVE_SCAN</td>
 * <td align="center">Start new sweep, Lens now moving</td>
 * </tr>
 * <tr>
 * <td align="center">NOT_FOCUSED_LOCKED</td>
 * <td align="center">AF_CANCEL</td>
 * <td align="center">INACTIVE</td>
 * <td align="center">Cancel/reset AF</td>
 * </tr>
 * <tr>
 * <td align="center">NOT_FOCUSED_LOCKED</td>
 * <td align="center">AF_TRIGGER</td>
 * <td align="center">ACTIVE_SCAN</td>
 * <td align="center">Start new sweep, Lens now moving</td>
 * </tr>
 * <tr>
 * <td align="center">Any state</td>
 * <td align="center">Mode change</td>
 * <td align="center">INACTIVE</td>
 * <td align="center"></td>
 * </tr>
 * </tbody>
 * </table>
 * <p>For the above table, the camera device may skip reporting any state changes that happen
 * without application intervention (i.e. mode switch, trigger, locking). Any state that
 * can be skipped in that manner is called a transient state.</p>
 * <p>For example, for these AF modes (AF_MODE_AUTO and AF_MODE_MACRO), in addition to the
 * state transitions listed in above table, it is also legal for the camera device to skip
 * one or more transient states between two results. See below table for examples:</p>
 * <table>
 * <thead>
 * <tr>
 * <th align="center">State</th>
 * <th align="center">Transition Cause</th>
 * <th align="center">New State</th>
 * <th align="center">Notes</th>
 * </tr>
 * </thead>
 * <tbody>
 * <tr>
 * <td align="center">INACTIVE</td>
 * <td align="center">AF_TRIGGER</td>
 * <td align="center">FOCUSED_LOCKED</td>
 * <td align="center">Focus is already good or good after a scan, lens is now locked.</td>
 * </tr>
 * <tr>
 * <td align="center">INACTIVE</td>
 * <td align="center">AF_TRIGGER</td>
 * <td align="center">NOT_FOCUSED_LOCKED</td>
 * <td align="center">Focus failed after a scan, lens is now locked.</td>
 * </tr>
 * <tr>
 * <td align="center">FOCUSED_LOCKED</td>
 * <td align="center">AF_TRIGGER</td>
 * <td align="center">FOCUSED_LOCKED</td>
 * <td align="center">Focus is already good or good after a scan, lens is now locked.</td>
 * </tr>
 * <tr>
 * <td align="center">NOT_FOCUSED_LOCKED</td>
 * <td align="center">AF_TRIGGER</td>
 * <td align="center">FOCUSED_LOCKED</td>
 * <td align="center">Focus is good after a scan, lens is not locked.</td>
 * </tr>
 * </tbody>
 * </table>
 * <p>When {@link android.hardware.camera2.CaptureRequest#CONTROL_AF_MODE CaptureRequest#CONTROL_AF_MODE} is AF_MODE_CONTINUOUS_VIDEO:</p>
 * <table>
 * <thead>
 * <tr>
 * <th align="center">State</th>
 * <th align="center">Transition Cause</th>
 * <th align="center">New State</th>
 * <th align="center">Notes</th>
 * </tr>
 * </thead>
 * <tbody>
 * <tr>
 * <td align="center">INACTIVE</td>
 * <td align="center">Camera device initiates new scan</td>
 * <td align="center">PASSIVE_SCAN</td>
 * <td align="center">Start AF scan, Lens now moving</td>
 * </tr>
 * <tr>
 * <td align="center">INACTIVE</td>
 * <td align="center">AF_TRIGGER</td>
 * <td align="center">NOT_FOCUSED_LOCKED</td>
 * <td align="center">AF state query, Lens now locked</td>
 * </tr>
 * <tr>
 * <td align="center">PASSIVE_SCAN</td>
 * <td align="center">Camera device completes current scan</td>
 * <td align="center">PASSIVE_FOCUSED</td>
 * <td align="center">End AF scan, Lens now locked</td>
 * </tr>
 * <tr>
 * <td align="center">PASSIVE_SCAN</td>
 * <td align="center">Camera device fails current scan</td>
 * <td align="center">PASSIVE_UNFOCUSED</td>
 * <td align="center">End AF scan, Lens now locked</td>
 * </tr>
 * <tr>
 * <td align="center">PASSIVE_SCAN</td>
 * <td align="center">AF_TRIGGER</td>
 * <td align="center">FOCUSED_LOCKED</td>
 * <td align="center">Immediate transition, if focus is good. Lens now locked</td>
 * </tr>
 * <tr>
 * <td align="center">PASSIVE_SCAN</td>
 * <td align="center">AF_TRIGGER</td>
 * <td align="center">NOT_FOCUSED_LOCKED</td>
 * <td align="center">Immediate transition, if focus is bad. Lens now locked</td>
 * </tr>
 * <tr>
 * <td align="center">PASSIVE_SCAN</td>
 * <td align="center">AF_CANCEL</td>
 * <td align="center">INACTIVE</td>
 * <td align="center">Reset lens position, Lens now locked</td>
 * </tr>
 * <tr>
 * <td align="center">PASSIVE_FOCUSED</td>
 * <td align="center">Camera device initiates new scan</td>
 * <td align="center">PASSIVE_SCAN</td>
 * <td align="center">Start AF scan, Lens now moving</td>
 * </tr>
 * <tr>
 * <td align="center">PASSIVE_UNFOCUSED</td>
 * <td align="center">Camera device initiates new scan</td>
 * <td align="center">PASSIVE_SCAN</td>
 * <td align="center">Start AF scan, Lens now moving</td>
 * </tr>
 * <tr>
 * <td align="center">PASSIVE_FOCUSED</td>
 * <td align="center">AF_TRIGGER</td>
 * <td align="center">FOCUSED_LOCKED</td>
 * <td align="center">Immediate transition, lens now locked</td>
 * </tr>
 * <tr>
 * <td align="center">PASSIVE_UNFOCUSED</td>
 * <td align="center">AF_TRIGGER</td>
 * <td align="center">NOT_FOCUSED_LOCKED</td>
 * <td align="center">Immediate transition, lens now locked</td>
 * </tr>
 * <tr>
 * <td align="center">FOCUSED_LOCKED</td>
 * <td align="center">AF_TRIGGER</td>
 * <td align="center">FOCUSED_LOCKED</td>
 * <td align="center">No effect</td>
 * </tr>
 * <tr>
 * <td align="center">FOCUSED_LOCKED</td>
 * <td align="center">AF_CANCEL</td>
 * <td align="center">INACTIVE</td>
 * <td align="center">Restart AF scan</td>
 * </tr>
 * <tr>
 * <td align="center">NOT_FOCUSED_LOCKED</td>
 * <td align="center">AF_TRIGGER</td>
 * <td align="center">NOT_FOCUSED_LOCKED</td>
 * <td align="center">No effect</td>
 * </tr>
 * <tr>
 * <td align="center">NOT_FOCUSED_LOCKED</td>
 * <td align="center">AF_CANCEL</td>
 * <td align="center">INACTIVE</td>
 * <td align="center">Restart AF scan</td>
 * </tr>
 * </tbody>
 * </table>
 * <p>When {@link android.hardware.camera2.CaptureRequest#CONTROL_AF_MODE CaptureRequest#CONTROL_AF_MODE} is AF_MODE_CONTINUOUS_PICTURE:</p>
 * <table>
 * <thead>
 * <tr>
 * <th align="center">State</th>
 * <th align="center">Transition Cause</th>
 * <th align="center">New State</th>
 * <th align="center">Notes</th>
 * </tr>
 * </thead>
 * <tbody>
 * <tr>
 * <td align="center">INACTIVE</td>
 * <td align="center">Camera device initiates new scan</td>
 * <td align="center">PASSIVE_SCAN</td>
 * <td align="center">Start AF scan, Lens now moving</td>
 * </tr>
 * <tr>
 * <td align="center">INACTIVE</td>
 * <td align="center">AF_TRIGGER</td>
 * <td align="center">NOT_FOCUSED_LOCKED</td>
 * <td align="center">AF state query, Lens now locked</td>
 * </tr>
 * <tr>
 * <td align="center">PASSIVE_SCAN</td>
 * <td align="center">Camera device completes current scan</td>
 * <td align="center">PASSIVE_FOCUSED</td>
 * <td align="center">End AF scan, Lens now locked</td>
 * </tr>
 * <tr>
 * <td align="center">PASSIVE_SCAN</td>
 * <td align="center">Camera device fails current scan</td>
 * <td align="center">PASSIVE_UNFOCUSED</td>
 * <td align="center">End AF scan, Lens now locked</td>
 * </tr>
 * <tr>
 * <td align="center">PASSIVE_SCAN</td>
 * <td align="center">AF_TRIGGER</td>
 * <td align="center">FOCUSED_LOCKED</td>
 * <td align="center">Eventual transition once the focus is good. Lens now locked</td>
 * </tr>
 * <tr>
 * <td align="center">PASSIVE_SCAN</td>
 * <td align="center">AF_TRIGGER</td>
 * <td align="center">NOT_FOCUSED_LOCKED</td>
 * <td align="center">Eventual transition if cannot find focus. Lens now locked</td>
 * </tr>
 * <tr>
 * <td align="center">PASSIVE_SCAN</td>
 * <td align="center">AF_CANCEL</td>
 * <td align="center">INACTIVE</td>
 * <td align="center">Reset lens position, Lens now locked</td>
 * </tr>
 * <tr>
 * <td align="center">PASSIVE_FOCUSED</td>
 * <td align="center">Camera device initiates new scan</td>
 * <td align="center">PASSIVE_SCAN</td>
 * <td align="center">Start AF scan, Lens now moving</td>
 * </tr>
 * <tr>
 * <td align="center">PASSIVE_UNFOCUSED</td>
 * <td align="center">Camera device initiates new scan</td>
 * <td align="center">PASSIVE_SCAN</td>
 * <td align="center">Start AF scan, Lens now moving</td>
 * </tr>
 * <tr>
 * <td align="center">PASSIVE_FOCUSED</td>
 * <td align="center">AF_TRIGGER</td>
 * <td align="center">FOCUSED_LOCKED</td>
 * <td align="center">Immediate trans. Lens now locked</td>
 * </tr>
 * <tr>
 * <td align="center">PASSIVE_UNFOCUSED</td>
 * <td align="center">AF_TRIGGER</td>
 * <td align="center">NOT_FOCUSED_LOCKED</td>
 * <td align="center">Immediate trans. Lens now locked</td>
 * </tr>
 * <tr>
 * <td align="center">FOCUSED_LOCKED</td>
 * <td align="center">AF_TRIGGER</td>
 * <td align="center">FOCUSED_LOCKED</td>
 * <td align="center">No effect</td>
 * </tr>
 * <tr>
 * <td align="center">FOCUSED_LOCKED</td>
 * <td align="center">AF_CANCEL</td>
 * <td align="center">INACTIVE</td>
 * <td align="center">Restart AF scan</td>
 * </tr>
 * <tr>
 * <td align="center">NOT_FOCUSED_LOCKED</td>
 * <td align="center">AF_TRIGGER</td>
 * <td align="center">NOT_FOCUSED_LOCKED</td>
 * <td align="center">No effect</td>
 * </tr>
 * <tr>
 * <td align="center">NOT_FOCUSED_LOCKED</td>
 * <td align="center">AF_CANCEL</td>
 * <td align="center">INACTIVE</td>
 * <td align="center">Restart AF scan</td>
 * </tr>
 * </tbody>
 * </table>
 * <p>When switch between AF_MODE_CONTINUOUS_* (CAF modes) and AF_MODE_AUTO/AF_MODE_MACRO
 * (AUTO modes), the initial INACTIVE or PASSIVE_SCAN states may be skipped by the
 * camera device. When a trigger is included in a mode switch request, the trigger
 * will be evaluated in the context of the new mode in the request.
 * See below table for examples:</p>
 * <table>
 * <thead>
 * <tr>
 * <th align="center">State</th>
 * <th align="center">Transition Cause</th>
 * <th align="center">New State</th>
 * <th align="center">Notes</th>
 * </tr>
 * </thead>
 * <tbody>
 * <tr>
 * <td align="center">any state</td>
 * <td align="center">CAF--&gt;AUTO mode switch</td>
 * <td align="center">INACTIVE</td>
 * <td align="center">Mode switch without trigger, initial state must be INACTIVE</td>
 * </tr>
 * <tr>
 * <td align="center">any state</td>
 * <td align="center">CAF--&gt;AUTO mode switch with AF_TRIGGER</td>
 * <td align="center">trigger-reachable states from INACTIVE</td>
 * <td align="center">Mode switch with trigger, INACTIVE is skipped</td>
 * </tr>
 * <tr>
 * <td align="center">any state</td>
 * <td align="center">AUTO--&gt;CAF mode switch</td>
 * <td align="center">passively reachable states from INACTIVE</td>
 * <td align="center">Mode switch without trigger, passive transient state is skipped</td>
 * </tr>
 * </tbody>
 * </table>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #CONTROL_AF_STATE_INACTIVE INACTIVE}</li>
 *   <li>{@link #CONTROL_AF_STATE_PASSIVE_SCAN PASSIVE_SCAN}</li>
 *   <li>{@link #CONTROL_AF_STATE_PASSIVE_FOCUSED PASSIVE_FOCUSED}</li>
 *   <li>{@link #CONTROL_AF_STATE_ACTIVE_SCAN ACTIVE_SCAN}</li>
 *   <li>{@link #CONTROL_AF_STATE_FOCUSED_LOCKED FOCUSED_LOCKED}</li>
 *   <li>{@link #CONTROL_AF_STATE_NOT_FOCUSED_LOCKED NOT_FOCUSED_LOCKED}</li>
 *   <li>{@link #CONTROL_AF_STATE_PASSIVE_UNFOCUSED PASSIVE_UNFOCUSED}</li>
 * </ul></p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AF_MODE
 * @see android.hardware.camera2.CaptureRequest#CONTROL_MODE
 * @see android.hardware.camera2.CaptureRequest#CONTROL_SCENE_MODE
 * @see #CONTROL_AF_STATE_INACTIVE
 * @see #CONTROL_AF_STATE_PASSIVE_SCAN
 * @see #CONTROL_AF_STATE_PASSIVE_FOCUSED
 * @see #CONTROL_AF_STATE_ACTIVE_SCAN
 * @see #CONTROL_AF_STATE_FOCUSED_LOCKED
 * @see #CONTROL_AF_STATE_NOT_FOCUSED_LOCKED
 * @see #CONTROL_AF_STATE_PASSIVE_UNFOCUSED
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> CONTROL_AF_STATE;
static { CONTROL_AF_STATE = null; }

/**
 * <p>Whether the camera device will trigger autofocus for this request.</p>
 * <p>This entry is normally set to IDLE, or is not
 * included at all in the request settings.</p>
 * <p>When included and set to START, the camera device will trigger the
 * autofocus algorithm. If autofocus is disabled, this trigger has no effect.</p>
 * <p>When set to CANCEL, the camera device will cancel any active trigger,
 * and return to its initial AF state.</p>
 * <p>Generally, applications should set this entry to START or CANCEL for only a
 * single capture, and then return it to IDLE (or not set at all). Specifying
 * START for multiple captures in a row means restarting the AF operation over
 * and over again.</p>
 * <p>See {@link android.hardware.camera2.CaptureResult#CONTROL_AF_STATE CaptureResult#CONTROL_AF_STATE} for what the trigger means for each AF mode.</p>
 * <p>Using the autofocus trigger and the precapture trigger {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_PRECAPTURE_TRIGGER CaptureRequest#CONTROL_AE_PRECAPTURE_TRIGGER}
 * simultaneously is allowed. However, since these triggers often require cooperation between
 * the auto-focus and auto-exposure routines (for example, the may need to be enabled for a
 * focus sweep), the camera device may delay acting on a later trigger until the previous
 * trigger has been fully handled. This may lead to longer intervals between the trigger and
 * changes to {@link android.hardware.camera2.CaptureResult#CONTROL_AF_STATE CaptureResult#CONTROL_AF_STATE}, for example.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #CONTROL_AF_TRIGGER_IDLE IDLE}</li>
 *   <li>{@link #CONTROL_AF_TRIGGER_START START}</li>
 *   <li>{@link #CONTROL_AF_TRIGGER_CANCEL CANCEL}</li>
 * </ul></p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AE_PRECAPTURE_TRIGGER
 * @see android.hardware.camera2.CaptureResult#CONTROL_AF_STATE
 * @see #CONTROL_AF_TRIGGER_IDLE
 * @see #CONTROL_AF_TRIGGER_START
 * @see #CONTROL_AF_TRIGGER_CANCEL
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> CONTROL_AF_TRIGGER;
static { CONTROL_AF_TRIGGER = null; }

/**
 * <p>Whether auto-white balance (AWB) is currently locked to its
 * latest calculated values.</p>
 * <p>When set to <code>true</code> (ON), the AWB algorithm is locked to its latest parameters,
 * and will not change color balance settings until the lock is set to <code>false</code> (OFF).</p>
 * <p>Since the camera device has a pipeline of in-flight requests, the settings that
 * get locked do not necessarily correspond to the settings that were present in the
 * latest capture result received from the camera device, since additional captures
 * and AWB updates may have occurred even before the result was sent out. If an
 * application is switching between automatic and manual control and wishes to eliminate
 * any flicker during the switch, the following procedure is recommended:</p>
 * <ol>
 * <li>Starting in auto-AWB mode:</li>
 * <li>Lock AWB</li>
 * <li>Wait for the first result to be output that has the AWB locked</li>
 * <li>Copy AWB settings from that result into a request, set the request to manual AWB</li>
 * <li>Submit the capture request, proceed to run manual AWB as desired.</li>
 * </ol>
 * <p>Note that AWB lock is only meaningful when
 * {@link android.hardware.camera2.CaptureRequest#CONTROL_AWB_MODE CaptureRequest#CONTROL_AWB_MODE} is in the AUTO mode; in other modes,
 * AWB is already fixed to a specific setting.</p>
 * <p>Some LEGACY devices may not support ON; the value is then overridden to OFF.</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AWB_MODE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Boolean> CONTROL_AWB_LOCK;
static { CONTROL_AWB_LOCK = null; }

/**
 * <p>Whether auto-white balance (AWB) is currently setting the color
 * transform fields, and what its illumination target
 * is.</p>
 * <p>This control is only effective if {@link android.hardware.camera2.CaptureRequest#CONTROL_MODE CaptureRequest#CONTROL_MODE} is AUTO.</p>
 * <p>When set to the ON mode, the camera device's auto-white balance
 * routine is enabled, overriding the application's selected
 * {@link android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_TRANSFORM CaptureRequest#COLOR_CORRECTION_TRANSFORM}, {@link android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_GAINS CaptureRequest#COLOR_CORRECTION_GAINS} and
 * {@link android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_MODE CaptureRequest#COLOR_CORRECTION_MODE}. Note that when {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE CaptureRequest#CONTROL_AE_MODE}
 * is OFF, the behavior of AWB is device dependent. It is recommened to
 * also set AWB mode to OFF or lock AWB by using {@link android.hardware.camera2.CaptureRequest#CONTROL_AWB_LOCK CaptureRequest#CONTROL_AWB_LOCK} before
 * setting AE mode to OFF.</p>
 * <p>When set to the OFF mode, the camera device's auto-white balance
 * routine is disabled. The application manually controls the white
 * balance by {@link android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_TRANSFORM CaptureRequest#COLOR_CORRECTION_TRANSFORM}, {@link android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_GAINS CaptureRequest#COLOR_CORRECTION_GAINS}
 * and {@link android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_MODE CaptureRequest#COLOR_CORRECTION_MODE}.</p>
 * <p>When set to any other modes, the camera device's auto-white
 * balance routine is disabled. The camera device uses each
 * particular illumination target for white balance
 * adjustment. The application's values for
 * {@link android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_TRANSFORM CaptureRequest#COLOR_CORRECTION_TRANSFORM},
 * {@link android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_GAINS CaptureRequest#COLOR_CORRECTION_GAINS} and
 * {@link android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_MODE CaptureRequest#COLOR_CORRECTION_MODE} are ignored.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #CONTROL_AWB_MODE_OFF OFF}</li>
 *   <li>{@link #CONTROL_AWB_MODE_AUTO AUTO}</li>
 *   <li>{@link #CONTROL_AWB_MODE_INCANDESCENT INCANDESCENT}</li>
 *   <li>{@link #CONTROL_AWB_MODE_FLUORESCENT FLUORESCENT}</li>
 *   <li>{@link #CONTROL_AWB_MODE_WARM_FLUORESCENT WARM_FLUORESCENT}</li>
 *   <li>{@link #CONTROL_AWB_MODE_DAYLIGHT DAYLIGHT}</li>
 *   <li>{@link #CONTROL_AWB_MODE_CLOUDY_DAYLIGHT CLOUDY_DAYLIGHT}</li>
 *   <li>{@link #CONTROL_AWB_MODE_TWILIGHT TWILIGHT}</li>
 *   <li>{@link #CONTROL_AWB_MODE_SHADE SHADE}</li>
 * </ul></p>
 * <p><b>Available values for this device:</b><br>
 * {@link android.hardware.camera2.CameraCharacteristics#CONTROL_AWB_AVAILABLE_MODES CameraCharacteristics#CONTROL_AWB_AVAILABLE_MODES}</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_GAINS
 * @see android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_MODE
 * @see android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_TRANSFORM
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE
 * @see android.hardware.camera2.CameraCharacteristics#CONTROL_AWB_AVAILABLE_MODES
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AWB_LOCK
 * @see android.hardware.camera2.CaptureRequest#CONTROL_MODE
 * @see #CONTROL_AWB_MODE_OFF
 * @see #CONTROL_AWB_MODE_AUTO
 * @see #CONTROL_AWB_MODE_INCANDESCENT
 * @see #CONTROL_AWB_MODE_FLUORESCENT
 * @see #CONTROL_AWB_MODE_WARM_FLUORESCENT
 * @see #CONTROL_AWB_MODE_DAYLIGHT
 * @see #CONTROL_AWB_MODE_CLOUDY_DAYLIGHT
 * @see #CONTROL_AWB_MODE_TWILIGHT
 * @see #CONTROL_AWB_MODE_SHADE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> CONTROL_AWB_MODE;
static { CONTROL_AWB_MODE = null; }

/**
 * <p>List of metering areas to use for auto-white-balance illuminant
 * estimation.</p>
 * <p>Not available if {@link android.hardware.camera2.CameraCharacteristics#CONTROL_MAX_REGIONS_AWB CameraCharacteristics#CONTROL_MAX_REGIONS_AWB} is 0.
 * Otherwise will always be present.</p>
 * <p>The maximum number of regions supported by the device is determined by the value
 * of {@link android.hardware.camera2.CameraCharacteristics#CONTROL_MAX_REGIONS_AWB CameraCharacteristics#CONTROL_MAX_REGIONS_AWB}.</p>
 * <p>For devices not supporting {@link android.hardware.camera2.CaptureRequest#DISTORTION_CORRECTION_MODE CaptureRequest#DISTORTION_CORRECTION_MODE} control, the coordinate
 * system always follows that of {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE}, with (0,0) being
 * the top-left pixel in the active pixel array, and
 * ({@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE}.width - 1,
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE}.height - 1) being the bottom-right pixel in the
 * active pixel array.</p>
 * <p>For devices supporting {@link android.hardware.camera2.CaptureRequest#DISTORTION_CORRECTION_MODE CaptureRequest#DISTORTION_CORRECTION_MODE} control, the coordinate
 * system depends on the mode being set.
 * When the distortion correction mode is OFF, the coordinate system follows
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE}, with
 * <code>(0, 0)</code> being the top-left pixel of the pre-correction active array, and
 * ({@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE}.width - 1,
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE}.height - 1) being the bottom-right
 * pixel in the pre-correction active pixel array.
 * When the distortion correction mode is not OFF, the coordinate system follows
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE}, with
 * <code>(0, 0)</code> being the top-left pixel of the active array, and
 * ({@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE}.width - 1,
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE}.height - 1) being the bottom-right pixel in the
 * active pixel array.</p>
 * <p>The weight must range from 0 to 1000, and represents a weight
 * for every pixel in the area. This means that a large metering area
 * with the same weight as a smaller area will have more effect in
 * the metering result. Metering areas can partially overlap and the
 * camera device will add the weights in the overlap region.</p>
 * <p>The weights are relative to weights of other white balance metering regions, so if
 * only one region is used, all non-zero weights will have the same effect. A region with
 * 0 weight is ignored.</p>
 * <p>If all regions have 0 weight, then no specific metering area needs to be used by the
 * camera device.</p>
 * <p>If the metering region is outside the used {@link android.hardware.camera2.CaptureRequest#SCALER_CROP_REGION CaptureRequest#SCALER_CROP_REGION} returned in
 * capture result metadata, the camera device will ignore the sections outside the crop
 * region and output only the intersection rectangle as the metering region in the result
 * metadata.  If the region is entirely outside the crop region, it will be ignored and
 * not reported in the result metadata.</p>
 * <p><b>Units</b>: Pixel coordinates within {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE} or
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE} depending on
 * distortion correction capability and mode</p>
 * <p><b>Range of valid values:</b><br>
 * Coordinates must be between <code>[(0,0), (width, height))</code> of
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE} or {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE}
 * depending on distortion correction capability and mode</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#CONTROL_MAX_REGIONS_AWB
 * @see android.hardware.camera2.CaptureRequest#DISTORTION_CORRECTION_MODE
 * @see android.hardware.camera2.CaptureRequest#SCALER_CROP_REGION
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<android.hardware.camera2.params.MeteringRectangle[]> CONTROL_AWB_REGIONS;
static { CONTROL_AWB_REGIONS = null; }

/**
 * <p>Current state of auto-white balance (AWB) algorithm.</p>
 * <p>Switching between or enabling AWB modes ({@link android.hardware.camera2.CaptureRequest#CONTROL_AWB_MODE CaptureRequest#CONTROL_AWB_MODE}) always
 * resets the AWB state to INACTIVE. Similarly, switching between {@link android.hardware.camera2.CaptureRequest#CONTROL_MODE CaptureRequest#CONTROL_MODE},
 * or {@link android.hardware.camera2.CaptureRequest#CONTROL_SCENE_MODE CaptureRequest#CONTROL_SCENE_MODE} if <code>{@link android.hardware.camera2.CaptureRequest#CONTROL_MODE CaptureRequest#CONTROL_MODE} == USE_SCENE_MODE</code> resets all
 * the algorithm states to INACTIVE.</p>
 * <p>The camera device can do several state transitions between two results, if it is
 * allowed by the state transition table. So INACTIVE may never actually be seen in
 * a result.</p>
 * <p>The state in the result is the state for this image (in sync with this image): if
 * AWB state becomes CONVERGED, then the image data associated with this result should
 * be good to use.</p>
 * <p>Below are state transition tables for different AWB modes.</p>
 * <p>When <code>{@link android.hardware.camera2.CaptureRequest#CONTROL_AWB_MODE CaptureRequest#CONTROL_AWB_MODE} != AWB_MODE_AUTO</code>:</p>
 * <table>
 * <thead>
 * <tr>
 * <th align="center">State</th>
 * <th align="center">Transition Cause</th>
 * <th align="center">New State</th>
 * <th align="center">Notes</th>
 * </tr>
 * </thead>
 * <tbody>
 * <tr>
 * <td align="center">INACTIVE</td>
 * <td align="center"></td>
 * <td align="center">INACTIVE</td>
 * <td align="center">Camera device auto white balance algorithm is disabled</td>
 * </tr>
 * </tbody>
 * </table>
 * <p>When {@link android.hardware.camera2.CaptureRequest#CONTROL_AWB_MODE CaptureRequest#CONTROL_AWB_MODE} is AWB_MODE_AUTO:</p>
 * <table>
 * <thead>
 * <tr>
 * <th align="center">State</th>
 * <th align="center">Transition Cause</th>
 * <th align="center">New State</th>
 * <th align="center">Notes</th>
 * </tr>
 * </thead>
 * <tbody>
 * <tr>
 * <td align="center">INACTIVE</td>
 * <td align="center">Camera device initiates AWB scan</td>
 * <td align="center">SEARCHING</td>
 * <td align="center">Values changing</td>
 * </tr>
 * <tr>
 * <td align="center">INACTIVE</td>
 * <td align="center">{@link android.hardware.camera2.CaptureRequest#CONTROL_AWB_LOCK CaptureRequest#CONTROL_AWB_LOCK} is ON</td>
 * <td align="center">LOCKED</td>
 * <td align="center">Values locked</td>
 * </tr>
 * <tr>
 * <td align="center">SEARCHING</td>
 * <td align="center">Camera device finishes AWB scan</td>
 * <td align="center">CONVERGED</td>
 * <td align="center">Good values, not changing</td>
 * </tr>
 * <tr>
 * <td align="center">SEARCHING</td>
 * <td align="center">{@link android.hardware.camera2.CaptureRequest#CONTROL_AWB_LOCK CaptureRequest#CONTROL_AWB_LOCK} is ON</td>
 * <td align="center">LOCKED</td>
 * <td align="center">Values locked</td>
 * </tr>
 * <tr>
 * <td align="center">CONVERGED</td>
 * <td align="center">Camera device initiates AWB scan</td>
 * <td align="center">SEARCHING</td>
 * <td align="center">Values changing</td>
 * </tr>
 * <tr>
 * <td align="center">CONVERGED</td>
 * <td align="center">{@link android.hardware.camera2.CaptureRequest#CONTROL_AWB_LOCK CaptureRequest#CONTROL_AWB_LOCK} is ON</td>
 * <td align="center">LOCKED</td>
 * <td align="center">Values locked</td>
 * </tr>
 * <tr>
 * <td align="center">LOCKED</td>
 * <td align="center">{@link android.hardware.camera2.CaptureRequest#CONTROL_AWB_LOCK CaptureRequest#CONTROL_AWB_LOCK} is OFF</td>
 * <td align="center">SEARCHING</td>
 * <td align="center">Values not good after unlock</td>
 * </tr>
 * </tbody>
 * </table>
 * <p>For the above table, the camera device may skip reporting any state changes that happen
 * without application intervention (i.e. mode switch, trigger, locking). Any state that
 * can be skipped in that manner is called a transient state.</p>
 * <p>For example, for this AWB mode (AWB_MODE_AUTO), in addition to the state transitions
 * listed in above table, it is also legal for the camera device to skip one or more
 * transient states between two results. See below table for examples:</p>
 * <table>
 * <thead>
 * <tr>
 * <th align="center">State</th>
 * <th align="center">Transition Cause</th>
 * <th align="center">New State</th>
 * <th align="center">Notes</th>
 * </tr>
 * </thead>
 * <tbody>
 * <tr>
 * <td align="center">INACTIVE</td>
 * <td align="center">Camera device finished AWB scan</td>
 * <td align="center">CONVERGED</td>
 * <td align="center">Values are already good, transient states are skipped by camera device.</td>
 * </tr>
 * <tr>
 * <td align="center">LOCKED</td>
 * <td align="center">{@link android.hardware.camera2.CaptureRequest#CONTROL_AWB_LOCK CaptureRequest#CONTROL_AWB_LOCK} is OFF</td>
 * <td align="center">CONVERGED</td>
 * <td align="center">Values good after unlock, transient states are skipped by camera device.</td>
 * </tr>
 * </tbody>
 * </table>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #CONTROL_AWB_STATE_INACTIVE INACTIVE}</li>
 *   <li>{@link #CONTROL_AWB_STATE_SEARCHING SEARCHING}</li>
 *   <li>{@link #CONTROL_AWB_STATE_CONVERGED CONVERGED}</li>
 *   <li>{@link #CONTROL_AWB_STATE_LOCKED LOCKED}</li>
 * </ul></p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Limited capability</b> -
 * Present on all camera devices that report being at least {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AWB_LOCK
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AWB_MODE
 * @see android.hardware.camera2.CaptureRequest#CONTROL_MODE
 * @see android.hardware.camera2.CaptureRequest#CONTROL_SCENE_MODE
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see #CONTROL_AWB_STATE_INACTIVE
 * @see #CONTROL_AWB_STATE_SEARCHING
 * @see #CONTROL_AWB_STATE_CONVERGED
 * @see #CONTROL_AWB_STATE_LOCKED
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> CONTROL_AWB_STATE;
static { CONTROL_AWB_STATE = null; }

/**
 * <p>Information to the camera device 3A (auto-exposure,
 * auto-focus, auto-white balance) routines about the purpose
 * of this capture, to help the camera device to decide optimal 3A
 * strategy.</p>
 * <p>This control (except for MANUAL) is only effective if
 * <code>{@link android.hardware.camera2.CaptureRequest#CONTROL_MODE CaptureRequest#CONTROL_MODE} != OFF</code> and any 3A routine is active.</p>
 * <p>All intents are supported by all devices, except that:
 *   * ZERO_SHUTTER_LAG will be supported if {@link android.hardware.camera2.CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES} contains
 * PRIVATE_REPROCESSING or YUV_REPROCESSING.
 *   * MANUAL will be supported if {@link android.hardware.camera2.CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES} contains
 * MANUAL_SENSOR.
 *   * MOTION_TRACKING will be supported if {@link android.hardware.camera2.CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES} contains
 * MOTION_TRACKING.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #CONTROL_CAPTURE_INTENT_CUSTOM CUSTOM}</li>
 *   <li>{@link #CONTROL_CAPTURE_INTENT_PREVIEW PREVIEW}</li>
 *   <li>{@link #CONTROL_CAPTURE_INTENT_STILL_CAPTURE STILL_CAPTURE}</li>
 *   <li>{@link #CONTROL_CAPTURE_INTENT_VIDEO_RECORD VIDEO_RECORD}</li>
 *   <li>{@link #CONTROL_CAPTURE_INTENT_VIDEO_SNAPSHOT VIDEO_SNAPSHOT}</li>
 *   <li>{@link #CONTROL_CAPTURE_INTENT_ZERO_SHUTTER_LAG ZERO_SHUTTER_LAG}</li>
 *   <li>{@link #CONTROL_CAPTURE_INTENT_MANUAL MANUAL}</li>
 *   <li>{@link #CONTROL_CAPTURE_INTENT_MOTION_TRACKING MOTION_TRACKING}</li>
 * </ul></p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_MODE
 * @see android.hardware.camera2.CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES
 * @see #CONTROL_CAPTURE_INTENT_CUSTOM
 * @see #CONTROL_CAPTURE_INTENT_PREVIEW
 * @see #CONTROL_CAPTURE_INTENT_STILL_CAPTURE
 * @see #CONTROL_CAPTURE_INTENT_VIDEO_RECORD
 * @see #CONTROL_CAPTURE_INTENT_VIDEO_SNAPSHOT
 * @see #CONTROL_CAPTURE_INTENT_ZERO_SHUTTER_LAG
 * @see #CONTROL_CAPTURE_INTENT_MANUAL
 * @see #CONTROL_CAPTURE_INTENT_MOTION_TRACKING
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> CONTROL_CAPTURE_INTENT;
static { CONTROL_CAPTURE_INTENT = null; }

/**
 * <p>A special color effect to apply.</p>
 * <p>When this mode is set, a color effect will be applied
 * to images produced by the camera device. The interpretation
 * and implementation of these color effects is left to the
 * implementor of the camera device, and should not be
 * depended on to be consistent (or present) across all
 * devices.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #CONTROL_EFFECT_MODE_OFF OFF}</li>
 *   <li>{@link #CONTROL_EFFECT_MODE_MONO MONO}</li>
 *   <li>{@link #CONTROL_EFFECT_MODE_NEGATIVE NEGATIVE}</li>
 *   <li>{@link #CONTROL_EFFECT_MODE_SOLARIZE SOLARIZE}</li>
 *   <li>{@link #CONTROL_EFFECT_MODE_SEPIA SEPIA}</li>
 *   <li>{@link #CONTROL_EFFECT_MODE_POSTERIZE POSTERIZE}</li>
 *   <li>{@link #CONTROL_EFFECT_MODE_WHITEBOARD WHITEBOARD}</li>
 *   <li>{@link #CONTROL_EFFECT_MODE_BLACKBOARD BLACKBOARD}</li>
 *   <li>{@link #CONTROL_EFFECT_MODE_AQUA AQUA}</li>
 * </ul></p>
 * <p><b>Available values for this device:</b><br>
 * {@link android.hardware.camera2.CameraCharacteristics#CONTROL_AVAILABLE_EFFECTS CameraCharacteristics#CONTROL_AVAILABLE_EFFECTS}</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#CONTROL_AVAILABLE_EFFECTS
 * @see #CONTROL_EFFECT_MODE_OFF
 * @see #CONTROL_EFFECT_MODE_MONO
 * @see #CONTROL_EFFECT_MODE_NEGATIVE
 * @see #CONTROL_EFFECT_MODE_SOLARIZE
 * @see #CONTROL_EFFECT_MODE_SEPIA
 * @see #CONTROL_EFFECT_MODE_POSTERIZE
 * @see #CONTROL_EFFECT_MODE_WHITEBOARD
 * @see #CONTROL_EFFECT_MODE_BLACKBOARD
 * @see #CONTROL_EFFECT_MODE_AQUA
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> CONTROL_EFFECT_MODE;
static { CONTROL_EFFECT_MODE = null; }

/**
 * <p>Allow camera device to enable zero-shutter-lag mode for requests with
 * {@link android.hardware.camera2.CaptureRequest#CONTROL_CAPTURE_INTENT CaptureRequest#CONTROL_CAPTURE_INTENT} == STILL_CAPTURE.</p>
 * <p>If enableZsl is <code>true</code>, the camera device may enable zero-shutter-lag mode for requests with
 * STILL_CAPTURE capture intent. The camera device may use images captured in the past to
 * produce output images for a zero-shutter-lag request. The result metadata including the
 * {@link android.hardware.camera2.CaptureResult#SENSOR_TIMESTAMP CaptureResult#SENSOR_TIMESTAMP} reflects the source frames used to produce output images.
 * Therefore, the contents of the output images and the result metadata may be out of order
 * compared to previous regular requests. enableZsl does not affect requests with other
 * capture intents.</p>
 * <p>For example, when requests are submitted in the following order:
 *   Request A: enableZsl is ON, {@link android.hardware.camera2.CaptureRequest#CONTROL_CAPTURE_INTENT CaptureRequest#CONTROL_CAPTURE_INTENT} is PREVIEW
 *   Request B: enableZsl is ON, {@link android.hardware.camera2.CaptureRequest#CONTROL_CAPTURE_INTENT CaptureRequest#CONTROL_CAPTURE_INTENT} is STILL_CAPTURE</p>
 * <p>The output images for request B may have contents captured before the output images for
 * request A, and the result metadata for request B may be older than the result metadata for
 * request A.</p>
 * <p>Note that when enableZsl is <code>true</code>, it is not guaranteed to get output images captured in
 * the past for requests with STILL_CAPTURE capture intent.</p>
 * <p>For applications targeting SDK versions O and newer, the value of enableZsl in
 * TEMPLATE_STILL_CAPTURE template may be <code>true</code>. The value in other templates is always
 * <code>false</code> if present.</p>
 * <p>For applications targeting SDK versions older than O, the value of enableZsl in all
 * capture templates is always <code>false</code> if present.</p>
 * <p>For application-operated ZSL, use CAMERA3_TEMPLATE_ZERO_SHUTTER_LAG template.</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_CAPTURE_INTENT
 * @see android.hardware.camera2.CaptureResult#SENSOR_TIMESTAMP
 * @apiSince 26
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Boolean> CONTROL_ENABLE_ZSL;
static { CONTROL_ENABLE_ZSL = null; }

/**
 * <p>Overall mode of 3A (auto-exposure, auto-white-balance, auto-focus) control
 * routines.</p>
 * <p>This is a top-level 3A control switch. When set to OFF, all 3A control
 * by the camera device is disabled. The application must set the fields for
 * capture parameters itself.</p>
 * <p>When set to AUTO, the individual algorithm controls in
 * android.control.* are in effect, such as {@link android.hardware.camera2.CaptureRequest#CONTROL_AF_MODE CaptureRequest#CONTROL_AF_MODE}.</p>
 * <p>When set to USE_SCENE_MODE, the individual controls in
 * android.control.* are mostly disabled, and the camera device
 * implements one of the scene mode settings (such as ACTION,
 * SUNSET, or PARTY) as it wishes. The camera device scene mode
 * 3A settings are provided by {@link android.hardware.camera2.CaptureResult capture results}.</p>
 * <p>When set to OFF_KEEP_STATE, it is similar to OFF mode, the only difference
 * is that this frame will not be used by camera device background 3A statistics
 * update, as if this frame is never captured. This mode can be used in the scenario
 * where the application doesn't want a 3A manual control capture to affect
 * the subsequent auto 3A capture results.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #CONTROL_MODE_OFF OFF}</li>
 *   <li>{@link #CONTROL_MODE_AUTO AUTO}</li>
 *   <li>{@link #CONTROL_MODE_USE_SCENE_MODE USE_SCENE_MODE}</li>
 *   <li>{@link #CONTROL_MODE_OFF_KEEP_STATE OFF_KEEP_STATE}</li>
 * </ul></p>
 * <p><b>Available values for this device:</b><br>
 * {@link android.hardware.camera2.CameraCharacteristics#CONTROL_AVAILABLE_MODES CameraCharacteristics#CONTROL_AVAILABLE_MODES}</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AF_MODE
 * @see android.hardware.camera2.CameraCharacteristics#CONTROL_AVAILABLE_MODES
 * @see #CONTROL_MODE_OFF
 * @see #CONTROL_MODE_AUTO
 * @see #CONTROL_MODE_USE_SCENE_MODE
 * @see #CONTROL_MODE_OFF_KEEP_STATE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> CONTROL_MODE;
static { CONTROL_MODE = null; }

/**
 * <p>The amount of additional sensitivity boost applied to output images
 * after RAW sensor data is captured.</p>
 * <p>Some camera devices support additional digital sensitivity boosting in the
 * camera processing pipeline after sensor RAW image is captured.
 * Such a boost will be applied to YUV/JPEG format output images but will not
 * have effect on RAW output formats like RAW_SENSOR, RAW10, RAW12 or RAW_OPAQUE.</p>
 * <p>This key will be <code>null</code> for devices that do not support any RAW format
 * outputs. For devices that do support RAW format outputs, this key will always
 * present, and if a device does not support post RAW sensitivity boost, it will
 * list <code>100</code> in this key.</p>
 * <p>If the camera device cannot apply the exact boost requested, it will reduce the
 * boost to the nearest supported value.
 * The final boost value used will be available in the output capture result.</p>
 * <p>For devices that support post RAW sensitivity boost, the YUV/JPEG output images
 * of such device will have the total sensitivity of
 * <code>{@link android.hardware.camera2.CaptureRequest#SENSOR_SENSITIVITY CaptureRequest#SENSOR_SENSITIVITY} * {@link android.hardware.camera2.CaptureRequest#CONTROL_POST_RAW_SENSITIVITY_BOOST CaptureRequest#CONTROL_POST_RAW_SENSITIVITY_BOOST} / 100</code>
 * The sensitivity of RAW format images will always be <code>{@link android.hardware.camera2.CaptureRequest#SENSOR_SENSITIVITY CaptureRequest#SENSOR_SENSITIVITY}</code></p>
 * <p>This control is only effective if {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE CaptureRequest#CONTROL_AE_MODE} or {@link android.hardware.camera2.CaptureRequest#CONTROL_MODE CaptureRequest#CONTROL_MODE} is set to
 * OFF; otherwise the auto-exposure algorithm will override this value.</p>
 * <p><b>Units</b>: ISO arithmetic units, the same as {@link android.hardware.camera2.CaptureRequest#SENSOR_SENSITIVITY CaptureRequest#SENSOR_SENSITIVITY}</p>
 * <p><b>Range of valid values:</b><br>
 * {@link android.hardware.camera2.CameraCharacteristics#CONTROL_POST_RAW_SENSITIVITY_BOOST_RANGE CameraCharacteristics#CONTROL_POST_RAW_SENSITIVITY_BOOST_RANGE}</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE
 * @see android.hardware.camera2.CaptureRequest#CONTROL_MODE
 * @see android.hardware.camera2.CaptureRequest#CONTROL_POST_RAW_SENSITIVITY_BOOST
 * @see android.hardware.camera2.CameraCharacteristics#CONTROL_POST_RAW_SENSITIVITY_BOOST_RANGE
 * @see android.hardware.camera2.CaptureRequest#SENSOR_SENSITIVITY
 * @apiSince 24
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> CONTROL_POST_RAW_SENSITIVITY_BOOST;
static { CONTROL_POST_RAW_SENSITIVITY_BOOST = null; }

/**
 * <p>Control for which scene mode is currently active.</p>
 * <p>Scene modes are custom camera modes optimized for a certain set of conditions and
 * capture settings.</p>
 * <p>This is the mode that that is active when
 * <code>{@link android.hardware.camera2.CaptureRequest#CONTROL_MODE CaptureRequest#CONTROL_MODE} == USE_SCENE_MODE</code>. Aside from FACE_PRIORITY, these modes will
 * disable {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE CaptureRequest#CONTROL_AE_MODE}, {@link android.hardware.camera2.CaptureRequest#CONTROL_AWB_MODE CaptureRequest#CONTROL_AWB_MODE}, and {@link android.hardware.camera2.CaptureRequest#CONTROL_AF_MODE CaptureRequest#CONTROL_AF_MODE}
 * while in use.</p>
 * <p>The interpretation and implementation of these scene modes is left
 * to the implementor of the camera device. Their behavior will not be
 * consistent across all devices, and any given device may only implement
 * a subset of these modes.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #CONTROL_SCENE_MODE_DISABLED DISABLED}</li>
 *   <li>{@link #CONTROL_SCENE_MODE_FACE_PRIORITY FACE_PRIORITY}</li>
 *   <li>{@link #CONTROL_SCENE_MODE_ACTION ACTION}</li>
 *   <li>{@link #CONTROL_SCENE_MODE_PORTRAIT PORTRAIT}</li>
 *   <li>{@link #CONTROL_SCENE_MODE_LANDSCAPE LANDSCAPE}</li>
 *   <li>{@link #CONTROL_SCENE_MODE_NIGHT NIGHT}</li>
 *   <li>{@link #CONTROL_SCENE_MODE_NIGHT_PORTRAIT NIGHT_PORTRAIT}</li>
 *   <li>{@link #CONTROL_SCENE_MODE_THEATRE THEATRE}</li>
 *   <li>{@link #CONTROL_SCENE_MODE_BEACH BEACH}</li>
 *   <li>{@link #CONTROL_SCENE_MODE_SNOW SNOW}</li>
 *   <li>{@link #CONTROL_SCENE_MODE_SUNSET SUNSET}</li>
 *   <li>{@link #CONTROL_SCENE_MODE_STEADYPHOTO STEADYPHOTO}</li>
 *   <li>{@link #CONTROL_SCENE_MODE_FIREWORKS FIREWORKS}</li>
 *   <li>{@link #CONTROL_SCENE_MODE_SPORTS SPORTS}</li>
 *   <li>{@link #CONTROL_SCENE_MODE_PARTY PARTY}</li>
 *   <li>{@link #CONTROL_SCENE_MODE_CANDLELIGHT CANDLELIGHT}</li>
 *   <li>{@link #CONTROL_SCENE_MODE_BARCODE BARCODE}</li>
 *   <li>{@link #CONTROL_SCENE_MODE_HIGH_SPEED_VIDEO HIGH_SPEED_VIDEO}</li>
 *   <li>{@link #CONTROL_SCENE_MODE_HDR HDR}</li>
 * </ul></p>
 * <p><b>Available values for this device:</b><br>
 * {@link android.hardware.camera2.CameraCharacteristics#CONTROL_AVAILABLE_SCENE_MODES CameraCharacteristics#CONTROL_AVAILABLE_SCENE_MODES}</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AF_MODE
 * @see android.hardware.camera2.CameraCharacteristics#CONTROL_AVAILABLE_SCENE_MODES
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AWB_MODE
 * @see android.hardware.camera2.CaptureRequest#CONTROL_MODE
 * @see #CONTROL_SCENE_MODE_DISABLED
 * @see #CONTROL_SCENE_MODE_FACE_PRIORITY
 * @see #CONTROL_SCENE_MODE_ACTION
 * @see #CONTROL_SCENE_MODE_PORTRAIT
 * @see #CONTROL_SCENE_MODE_LANDSCAPE
 * @see #CONTROL_SCENE_MODE_NIGHT
 * @see #CONTROL_SCENE_MODE_NIGHT_PORTRAIT
 * @see #CONTROL_SCENE_MODE_THEATRE
 * @see #CONTROL_SCENE_MODE_BEACH
 * @see #CONTROL_SCENE_MODE_SNOW
 * @see #CONTROL_SCENE_MODE_SUNSET
 * @see #CONTROL_SCENE_MODE_STEADYPHOTO
 * @see #CONTROL_SCENE_MODE_FIREWORKS
 * @see #CONTROL_SCENE_MODE_SPORTS
 * @see #CONTROL_SCENE_MODE_PARTY
 * @see #CONTROL_SCENE_MODE_CANDLELIGHT
 * @see #CONTROL_SCENE_MODE_BARCODE
 * @see #CONTROL_SCENE_MODE_HIGH_SPEED_VIDEO
 * @see #CONTROL_SCENE_MODE_HDR
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> CONTROL_SCENE_MODE;
static { CONTROL_SCENE_MODE = null; }

/**
 * <p>Whether video stabilization is
 * active.</p>
 * <p>Video stabilization automatically warps images from
 * the camera in order to stabilize motion between consecutive frames.</p>
 * <p>If enabled, video stabilization can modify the
 * {@link android.hardware.camera2.CaptureRequest#SCALER_CROP_REGION CaptureRequest#SCALER_CROP_REGION} to keep the video stream stabilized.</p>
 * <p>Switching between different video stabilization modes may take several
 * frames to initialize, the camera device will report the current mode
 * in capture result metadata. For example, When "ON" mode is requested,
 * the video stabilization modes in the first several capture results may
 * still be "OFF", and it will become "ON" when the initialization is
 * done.</p>
 * <p>In addition, not all recording sizes or frame rates may be supported for
 * stabilization by a device that reports stabilization support. It is guaranteed
 * that an output targeting a MediaRecorder or MediaCodec will be stabilized if
 * the recording resolution is less than or equal to 1920 x 1080 (width less than
 * or equal to 1920, height less than or equal to 1080), and the recording
 * frame rate is less than or equal to 30fps.  At other sizes, the CaptureResult
 * {@link android.hardware.camera2.CaptureRequest#CONTROL_VIDEO_STABILIZATION_MODE CaptureRequest#CONTROL_VIDEO_STABILIZATION_MODE} field will return
 * OFF if the recording output is not stabilized, or if there are no output
 * Surface types that can be stabilized.</p>
 * <p>If a camera device supports both this mode and OIS
 * ({@link android.hardware.camera2.CaptureRequest#LENS_OPTICAL_STABILIZATION_MODE CaptureRequest#LENS_OPTICAL_STABILIZATION_MODE}), turning both modes on may
 * produce undesirable interaction, so it is recommended not to enable
 * both at the same time.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #CONTROL_VIDEO_STABILIZATION_MODE_OFF OFF}</li>
 *   <li>{@link #CONTROL_VIDEO_STABILIZATION_MODE_ON ON}</li>
 * </ul></p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_VIDEO_STABILIZATION_MODE
 * @see android.hardware.camera2.CaptureRequest#LENS_OPTICAL_STABILIZATION_MODE
 * @see android.hardware.camera2.CaptureRequest#SCALER_CROP_REGION
 * @see #CONTROL_VIDEO_STABILIZATION_MODE_OFF
 * @see #CONTROL_VIDEO_STABILIZATION_MODE_ON
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> CONTROL_VIDEO_STABILIZATION_MODE;
static { CONTROL_VIDEO_STABILIZATION_MODE = null; }

/**
 * <p>Mode of operation for the lens distortion correction block.</p>
 * <p>The lens distortion correction block attempts to improve image quality by fixing
 * radial, tangential, or other geometric aberrations in the camera device's optics.  If
 * available, the {@link android.hardware.camera2.CameraCharacteristics#LENS_DISTORTION CameraCharacteristics#LENS_DISTORTION} field documents the lens's distortion parameters.</p>
 * <p>OFF means no distortion correction is done.</p>
 * <p>FAST/HIGH_QUALITY both mean camera device determined distortion correction will be
 * applied. HIGH_QUALITY mode indicates that the camera device will use the highest-quality
 * correction algorithms, even if it slows down capture rate. FAST means the camera device
 * will not slow down capture rate when applying correction. FAST may be the same as OFF if
 * any correction at all would slow down capture rate.  Every output stream will have a
 * similar amount of enhancement applied.</p>
 * <p>The correction only applies to processed outputs such as YUV, Y8, JPEG, or DEPTH16; it is
 * not applied to any RAW output.</p>
 * <p>This control will be on by default on devices that support this control. Applications
 * disabling distortion correction need to pay extra attention with the coordinate system of
 * metering regions, crop region, and face rectangles. When distortion correction is OFF,
 * metadata coordinates follow the coordinate system of
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE}. When distortion is not OFF, metadata
 * coordinates follow the coordinate system of {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE}.  The
 * camera device will map these metadata fields to match the corrected image produced by the
 * camera device, for both capture requests and results.  However, this mapping is not very
 * precise, since rectangles do not generally map to rectangles when corrected.  Only linear
 * scaling between the active array and precorrection active array coordinates is
 * performed. Applications that require precise correction of metadata need to undo that
 * linear scaling, and apply a more complete correction that takes into the account the app's
 * own requirements.</p>
 * <p>The full list of metadata that is affected in this way by distortion correction is:</p>
 * <ul>
 * <li>{@link android.hardware.camera2.CaptureRequest#CONTROL_AF_REGIONS CaptureRequest#CONTROL_AF_REGIONS}</li>
 * <li>{@link android.hardware.camera2.CaptureRequest#CONTROL_AE_REGIONS CaptureRequest#CONTROL_AE_REGIONS}</li>
 * <li>{@link android.hardware.camera2.CaptureRequest#CONTROL_AWB_REGIONS CaptureRequest#CONTROL_AWB_REGIONS}</li>
 * <li>{@link android.hardware.camera2.CaptureRequest#SCALER_CROP_REGION CaptureRequest#SCALER_CROP_REGION}</li>
 * <li>{@link android.hardware.camera2.CaptureResult#STATISTICS_FACES CaptureResult#STATISTICS_FACES}</li>
 * </ul>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #DISTORTION_CORRECTION_MODE_OFF OFF}</li>
 *   <li>{@link #DISTORTION_CORRECTION_MODE_FAST FAST}</li>
 *   <li>{@link #DISTORTION_CORRECTION_MODE_HIGH_QUALITY HIGH_QUALITY}</li>
 * </ul></p>
 * <p><b>Available values for this device:</b><br>
 * {@link android.hardware.camera2.CameraCharacteristics#DISTORTION_CORRECTION_AVAILABLE_MODES CameraCharacteristics#DISTORTION_CORRECTION_AVAILABLE_MODES}</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AE_REGIONS
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AF_REGIONS
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AWB_REGIONS
 * @see android.hardware.camera2.CameraCharacteristics#DISTORTION_CORRECTION_AVAILABLE_MODES
 * @see android.hardware.camera2.CameraCharacteristics#LENS_DISTORTION
 * @see android.hardware.camera2.CaptureRequest#SCALER_CROP_REGION
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE
 * @see android.hardware.camera2.CaptureResult#STATISTICS_FACES
 * @see #DISTORTION_CORRECTION_MODE_OFF
 * @see #DISTORTION_CORRECTION_MODE_FAST
 * @see #DISTORTION_CORRECTION_MODE_HIGH_QUALITY
 * @apiSince 28
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> DISTORTION_CORRECTION_MODE;
static { DISTORTION_CORRECTION_MODE = null; }

/**
 * <p>Operation mode for edge
 * enhancement.</p>
 * <p>Edge enhancement improves sharpness and details in the captured image. OFF means
 * no enhancement will be applied by the camera device.</p>
 * <p>FAST/HIGH_QUALITY both mean camera device determined enhancement
 * will be applied. HIGH_QUALITY mode indicates that the
 * camera device will use the highest-quality enhancement algorithms,
 * even if it slows down capture rate. FAST means the camera device will
 * not slow down capture rate when applying edge enhancement. FAST may be the same as OFF if
 * edge enhancement will slow down capture rate. Every output stream will have a similar
 * amount of enhancement applied.</p>
 * <p>ZERO_SHUTTER_LAG is meant to be used by applications that maintain a continuous circular
 * buffer of high-resolution images during preview and reprocess image(s) from that buffer
 * into a final capture when triggered by the user. In this mode, the camera device applies
 * edge enhancement to low-resolution streams (below maximum recording resolution) to
 * maximize preview quality, but does not apply edge enhancement to high-resolution streams,
 * since those will be reprocessed later if necessary.</p>
 * <p>For YUV_REPROCESSING, these FAST/HIGH_QUALITY modes both mean that the camera
 * device will apply FAST/HIGH_QUALITY YUV-domain edge enhancement, respectively.
 * The camera device may adjust its internal edge enhancement parameters for best
 * image quality based on the {@link android.hardware.camera2.CaptureRequest#REPROCESS_EFFECTIVE_EXPOSURE_FACTOR CaptureRequest#REPROCESS_EFFECTIVE_EXPOSURE_FACTOR}, if it is set.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #EDGE_MODE_OFF OFF}</li>
 *   <li>{@link #EDGE_MODE_FAST FAST}</li>
 *   <li>{@link #EDGE_MODE_HIGH_QUALITY HIGH_QUALITY}</li>
 *   <li>{@link #EDGE_MODE_ZERO_SHUTTER_LAG ZERO_SHUTTER_LAG}</li>
 * </ul></p>
 * <p><b>Available values for this device:</b><br>
 * {@link android.hardware.camera2.CameraCharacteristics#EDGE_AVAILABLE_EDGE_MODES CameraCharacteristics#EDGE_AVAILABLE_EDGE_MODES}</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Full capability</b> -
 * Present on all camera devices that report being {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#EDGE_AVAILABLE_EDGE_MODES
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see android.hardware.camera2.CaptureRequest#REPROCESS_EFFECTIVE_EXPOSURE_FACTOR
 * @see #EDGE_MODE_OFF
 * @see #EDGE_MODE_FAST
 * @see #EDGE_MODE_HIGH_QUALITY
 * @see #EDGE_MODE_ZERO_SHUTTER_LAG
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> EDGE_MODE;
static { EDGE_MODE = null; }

/**
 * <p>The desired mode for for the camera device's flash control.</p>
 * <p>This control is only effective when flash unit is available
 * (<code>{@link android.hardware.camera2.CameraCharacteristics#FLASH_INFO_AVAILABLE CameraCharacteristics#FLASH_INFO_AVAILABLE} == true</code>).</p>
 * <p>When this control is used, the {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE CaptureRequest#CONTROL_AE_MODE} must be set to ON or OFF.
 * Otherwise, the camera device auto-exposure related flash control (ON_AUTO_FLASH,
 * ON_ALWAYS_FLASH, or ON_AUTO_FLASH_REDEYE) will override this control.</p>
 * <p>When set to OFF, the camera device will not fire flash for this capture.</p>
 * <p>When set to SINGLE, the camera device will fire flash regardless of the camera
 * device's auto-exposure routine's result. When used in still capture case, this
 * control should be used along with auto-exposure (AE) precapture metering sequence
 * ({@link android.hardware.camera2.CaptureRequest#CONTROL_AE_PRECAPTURE_TRIGGER CaptureRequest#CONTROL_AE_PRECAPTURE_TRIGGER}), otherwise, the image may be incorrectly exposed.</p>
 * <p>When set to TORCH, the flash will be on continuously. This mode can be used
 * for use cases such as preview, auto-focus assist, still capture, or video recording.</p>
 * <p>The flash status will be reported by {@link android.hardware.camera2.CaptureResult#FLASH_STATE CaptureResult#FLASH_STATE} in the capture result metadata.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #FLASH_MODE_OFF OFF}</li>
 *   <li>{@link #FLASH_MODE_SINGLE SINGLE}</li>
 *   <li>{@link #FLASH_MODE_TORCH TORCH}</li>
 * </ul></p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AE_PRECAPTURE_TRIGGER
 * @see android.hardware.camera2.CameraCharacteristics#FLASH_INFO_AVAILABLE
 * @see android.hardware.camera2.CaptureResult#FLASH_STATE
 * @see #FLASH_MODE_OFF
 * @see #FLASH_MODE_SINGLE
 * @see #FLASH_MODE_TORCH
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> FLASH_MODE;
static { FLASH_MODE = null; }

/**
 * <p>Current state of the flash
 * unit.</p>
 * <p>When the camera device doesn't have flash unit
 * (i.e. <code>{@link android.hardware.camera2.CameraCharacteristics#FLASH_INFO_AVAILABLE CameraCharacteristics#FLASH_INFO_AVAILABLE} == false</code>), this state will always be UNAVAILABLE.
 * Other states indicate the current flash status.</p>
 * <p>In certain conditions, this will be available on LEGACY devices:</p>
 * <ul>
 * <li>Flash-less cameras always return UNAVAILABLE.</li>
 * <li>Using {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE CaptureRequest#CONTROL_AE_MODE} <code>==</code> ON_ALWAYS_FLASH
 *    will always return FIRED.</li>
 * <li>Using {@link android.hardware.camera2.CaptureRequest#FLASH_MODE CaptureRequest#FLASH_MODE} <code>==</code> TORCH
 *    will always return FIRED.</li>
 * </ul>
 * <p>In all other conditions the state will not be available on
 * LEGACY devices (i.e. it will be <code>null</code>).</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #FLASH_STATE_UNAVAILABLE UNAVAILABLE}</li>
 *   <li>{@link #FLASH_STATE_CHARGING CHARGING}</li>
 *   <li>{@link #FLASH_STATE_READY READY}</li>
 *   <li>{@link #FLASH_STATE_FIRED FIRED}</li>
 *   <li>{@link #FLASH_STATE_PARTIAL PARTIAL}</li>
 * </ul></p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Limited capability</b> -
 * Present on all camera devices that report being at least {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE
 * @see android.hardware.camera2.CameraCharacteristics#FLASH_INFO_AVAILABLE
 * @see android.hardware.camera2.CaptureRequest#FLASH_MODE
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see #FLASH_STATE_UNAVAILABLE
 * @see #FLASH_STATE_CHARGING
 * @see #FLASH_STATE_READY
 * @see #FLASH_STATE_FIRED
 * @see #FLASH_STATE_PARTIAL
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> FLASH_STATE;
static { FLASH_STATE = null; }

/**
 * <p>Operational mode for hot pixel correction.</p>
 * <p>Hotpixel correction interpolates out, or otherwise removes, pixels
 * that do not accurately measure the incoming light (i.e. pixels that
 * are stuck at an arbitrary value or are oversensitive).</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #HOT_PIXEL_MODE_OFF OFF}</li>
 *   <li>{@link #HOT_PIXEL_MODE_FAST FAST}</li>
 *   <li>{@link #HOT_PIXEL_MODE_HIGH_QUALITY HIGH_QUALITY}</li>
 * </ul></p>
 * <p><b>Available values for this device:</b><br>
 * {@link android.hardware.camera2.CameraCharacteristics#HOT_PIXEL_AVAILABLE_HOT_PIXEL_MODES CameraCharacteristics#HOT_PIXEL_AVAILABLE_HOT_PIXEL_MODES}</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#HOT_PIXEL_AVAILABLE_HOT_PIXEL_MODES
 * @see #HOT_PIXEL_MODE_OFF
 * @see #HOT_PIXEL_MODE_FAST
 * @see #HOT_PIXEL_MODE_HIGH_QUALITY
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> HOT_PIXEL_MODE;
static { HOT_PIXEL_MODE = null; }

/**
 * <p>A location object to use when generating image GPS metadata.</p>
 * <p>Setting a location object in a request will include the GPS coordinates of the location
 * into any JPEG images captured based on the request. These coordinates can then be
 * viewed by anyone who receives the JPEG image.</p>
 * <p>This tag is also used for HEIC image capture.</p>
 * <p>This key is available on all devices.</p>
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<android.location.Location> JPEG_GPS_LOCATION;
static { JPEG_GPS_LOCATION = null; }

/**
 * <p>The orientation for a JPEG image.</p>
 * <p>The clockwise rotation angle in degrees, relative to the orientation
 * to the camera, that the JPEG picture needs to be rotated by, to be viewed
 * upright.</p>
 * <p>Camera devices may either encode this value into the JPEG EXIF header, or
 * rotate the image data to match this orientation. When the image data is rotated,
 * the thumbnail data will also be rotated.</p>
 * <p>Note that this orientation is relative to the orientation of the camera sensor, given
 * by {@link android.hardware.camera2.CameraCharacteristics#SENSOR_ORIENTATION CameraCharacteristics#SENSOR_ORIENTATION}.</p>
 * <p>To translate from the device orientation given by the Android sensor APIs for camera
 * sensors which are not EXTERNAL, the following sample code may be used:</p>
 * <pre><code>private int getJpegOrientation(CameraCharacteristics c, int deviceOrientation) {
 *     if (deviceOrientation == android.view.OrientationEventListener.ORIENTATION_UNKNOWN) return 0;
 *     int sensorOrientation = c.get(CameraCharacteristics.SENSOR_ORIENTATION);
 *
 *     // Round device orientation to a multiple of 90
 *     deviceOrientation = (deviceOrientation + 45) / 90 * 90;
 *
 *     // Reverse device orientation for front-facing cameras
 *     boolean facingFront = c.get(CameraCharacteristics.LENS_FACING) == CameraCharacteristics.LENS_FACING_FRONT;
 *     if (facingFront) deviceOrientation = -deviceOrientation;
 *
 *     // Calculate desired JPEG orientation relative to camera orientation to make
 *     // the image upright relative to the device orientation
 *     int jpegOrientation = (sensorOrientation + deviceOrientation + 360) % 360;
 *
 *     return jpegOrientation;
 * }
 * </code></pre>
 * <p>For EXTERNAL cameras the sensor orientation will always be set to 0 and the facing will
 * also be set to EXTERNAL. The above code is not relevant in such case.</p>
 * <p>This tag is also used to describe the orientation of the HEIC image capture, in which
 * case the rotation is reflected by
 * {@link android.media.ExifInterface#TAG_ORIENTATION EXIF orientation flag}, and not by
 * rotating the image data itself.</p>
 * <p><b>Units</b>: Degrees in multiples of 90</p>
 * <p><b>Range of valid values:</b><br>
 * 0, 90, 180, 270</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_ORIENTATION
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> JPEG_ORIENTATION;
static { JPEG_ORIENTATION = null; }

/**
 * <p>Compression quality of the final JPEG
 * image.</p>
 * <p>85-95 is typical usage range. This tag is also used to describe the quality
 * of the HEIC image capture.</p>
 * <p><b>Range of valid values:</b><br>
 * 1-100; larger is higher quality</p>
 * <p>This key is available on all devices.</p>
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Byte> JPEG_QUALITY;
static { JPEG_QUALITY = null; }

/**
 * <p>Compression quality of JPEG
 * thumbnail.</p>
 * <p>This tag is also used to describe the quality of the HEIC image capture.</p>
 * <p><b>Range of valid values:</b><br>
 * 1-100; larger is higher quality</p>
 * <p>This key is available on all devices.</p>
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Byte> JPEG_THUMBNAIL_QUALITY;
static { JPEG_THUMBNAIL_QUALITY = null; }

/**
 * <p>Resolution of embedded JPEG thumbnail.</p>
 * <p>When set to (0, 0) value, the JPEG EXIF will not contain thumbnail,
 * but the captured JPEG will still be a valid image.</p>
 * <p>For best results, when issuing a request for a JPEG image, the thumbnail size selected
 * should have the same aspect ratio as the main JPEG output.</p>
 * <p>If the thumbnail image aspect ratio differs from the JPEG primary image aspect
 * ratio, the camera device creates the thumbnail by cropping it from the primary image.
 * For example, if the primary image has 4:3 aspect ratio, the thumbnail image has
 * 16:9 aspect ratio, the primary image will be cropped vertically (letterbox) to
 * generate the thumbnail image. The thumbnail image will always have a smaller Field
 * Of View (FOV) than the primary image when aspect ratios differ.</p>
 * <p>When an {@link android.hardware.camera2.CaptureRequest#JPEG_ORIENTATION CaptureRequest#JPEG_ORIENTATION} of non-zero degree is requested,
 * the camera device will handle thumbnail rotation in one of the following ways:</p>
 * <ul>
 * <li>Set the {@link android.media.ExifInterface#TAG_ORIENTATION EXIF orientation flag}
 *   and keep jpeg and thumbnail image data unrotated.</li>
 * <li>Rotate the jpeg and thumbnail image data and not set
 *   {@link android.media.ExifInterface#TAG_ORIENTATION EXIF orientation flag}. In this
 *   case, LIMITED or FULL hardware level devices will report rotated thumnail size in
 *   capture result, so the width and height will be interchanged if 90 or 270 degree
 *   orientation is requested. LEGACY device will always report unrotated thumbnail
 *   size.</li>
 * </ul>
 * <p>The tag is also used as thumbnail size for HEIC image format capture, in which case the
 * the thumbnail rotation is reflected by
 * {@link android.media.ExifInterface#TAG_ORIENTATION EXIF orientation flag}, and not by
 * rotating the thumbnail data itself.</p>
 * <p><b>Range of valid values:</b><br>
 * {@link android.hardware.camera2.CameraCharacteristics#JPEG_AVAILABLE_THUMBNAIL_SIZES CameraCharacteristics#JPEG_AVAILABLE_THUMBNAIL_SIZES}</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#JPEG_AVAILABLE_THUMBNAIL_SIZES
 * @see android.hardware.camera2.CaptureRequest#JPEG_ORIENTATION
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<android.util.Size> JPEG_THUMBNAIL_SIZE;
static { JPEG_THUMBNAIL_SIZE = null; }

/**
 * <p>The desired lens aperture size, as a ratio of lens focal length to the
 * effective aperture diameter.</p>
 * <p>Setting this value is only supported on the camera devices that have a variable
 * aperture lens.</p>
 * <p>When this is supported and {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE CaptureRequest#CONTROL_AE_MODE} is OFF,
 * this can be set along with {@link android.hardware.camera2.CaptureRequest#SENSOR_EXPOSURE_TIME CaptureRequest#SENSOR_EXPOSURE_TIME},
 * {@link android.hardware.camera2.CaptureRequest#SENSOR_SENSITIVITY CaptureRequest#SENSOR_SENSITIVITY}, and {@link android.hardware.camera2.CaptureRequest#SENSOR_FRAME_DURATION CaptureRequest#SENSOR_FRAME_DURATION}
 * to achieve manual exposure control.</p>
 * <p>The requested aperture value may take several frames to reach the
 * requested value; the camera device will report the current (intermediate)
 * aperture size in capture result metadata while the aperture is changing.
 * While the aperture is still changing, {@link android.hardware.camera2.CaptureResult#LENS_STATE CaptureResult#LENS_STATE} will be set to MOVING.</p>
 * <p>When this is supported and {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE CaptureRequest#CONTROL_AE_MODE} is one of
 * the ON modes, this will be overridden by the camera device
 * auto-exposure algorithm, the overridden values are then provided
 * back to the user in the corresponding result.</p>
 * <p><b>Units</b>: The f-number (f/N)</p>
 * <p><b>Range of valid values:</b><br>
 * {@link android.hardware.camera2.CameraCharacteristics#LENS_INFO_AVAILABLE_APERTURES CameraCharacteristics#LENS_INFO_AVAILABLE_APERTURES}</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Full capability</b> -
 * Present on all camera devices that report being {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see android.hardware.camera2.CameraCharacteristics#LENS_INFO_AVAILABLE_APERTURES
 * @see android.hardware.camera2.CaptureResult#LENS_STATE
 * @see android.hardware.camera2.CaptureRequest#SENSOR_EXPOSURE_TIME
 * @see android.hardware.camera2.CaptureRequest#SENSOR_FRAME_DURATION
 * @see android.hardware.camera2.CaptureRequest#SENSOR_SENSITIVITY
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Float> LENS_APERTURE;
static { LENS_APERTURE = null; }

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

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<float[]> LENS_DISTORTION;
static { LENS_DISTORTION = null; }

/**
 * <p>The desired setting for the lens neutral density filter(s).</p>
 * <p>This control will not be supported on most camera devices.</p>
 * <p>Lens filters are typically used to lower the amount of light the
 * sensor is exposed to (measured in steps of EV). As used here, an EV
 * step is the standard logarithmic representation, which are
 * non-negative, and inversely proportional to the amount of light
 * hitting the sensor.  For example, setting this to 0 would result
 * in no reduction of the incoming light, and setting this to 2 would
 * mean that the filter is set to reduce incoming light by two stops
 * (allowing 1/4 of the prior amount of light to the sensor).</p>
 * <p>It may take several frames before the lens filter density changes
 * to the requested value. While the filter density is still changing,
 * {@link android.hardware.camera2.CaptureResult#LENS_STATE CaptureResult#LENS_STATE} will be set to MOVING.</p>
 * <p><b>Units</b>: Exposure Value (EV)</p>
 * <p><b>Range of valid values:</b><br>
 * {@link android.hardware.camera2.CameraCharacteristics#LENS_INFO_AVAILABLE_FILTER_DENSITIES CameraCharacteristics#LENS_INFO_AVAILABLE_FILTER_DENSITIES}</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Full capability</b> -
 * Present on all camera devices that report being {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see android.hardware.camera2.CameraCharacteristics#LENS_INFO_AVAILABLE_FILTER_DENSITIES
 * @see android.hardware.camera2.CaptureResult#LENS_STATE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Float> LENS_FILTER_DENSITY;
static { LENS_FILTER_DENSITY = null; }

/**
 * <p>The desired lens focal length; used for optical zoom.</p>
 * <p>This setting controls the physical focal length of the camera
 * device's lens. Changing the focal length changes the field of
 * view of the camera device, and is usually used for optical zoom.</p>
 * <p>Like {@link android.hardware.camera2.CaptureRequest#LENS_FOCUS_DISTANCE CaptureRequest#LENS_FOCUS_DISTANCE} and {@link android.hardware.camera2.CaptureRequest#LENS_APERTURE CaptureRequest#LENS_APERTURE}, this
 * setting won't be applied instantaneously, and it may take several
 * frames before the lens can change to the requested focal length.
 * While the focal length is still changing, {@link android.hardware.camera2.CaptureResult#LENS_STATE CaptureResult#LENS_STATE} will
 * be set to MOVING.</p>
 * <p>Optical zoom will not be supported on most devices.</p>
 * <p><b>Units</b>: Millimeters</p>
 * <p><b>Range of valid values:</b><br>
 * {@link android.hardware.camera2.CameraCharacteristics#LENS_INFO_AVAILABLE_FOCAL_LENGTHS CameraCharacteristics#LENS_INFO_AVAILABLE_FOCAL_LENGTHS}</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#LENS_APERTURE
 * @see android.hardware.camera2.CaptureRequest#LENS_FOCUS_DISTANCE
 * @see android.hardware.camera2.CameraCharacteristics#LENS_INFO_AVAILABLE_FOCAL_LENGTHS
 * @see android.hardware.camera2.CaptureResult#LENS_STATE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Float> LENS_FOCAL_LENGTH;
static { LENS_FOCAL_LENGTH = null; }

/**
 * <p>Desired distance to plane of sharpest focus,
 * measured from frontmost surface of the lens.</p>
 * <p>Should be zero for fixed-focus cameras</p>
 * <p><b>Units</b>: See {@link android.hardware.camera2.CameraCharacteristics#LENS_INFO_FOCUS_DISTANCE_CALIBRATION CameraCharacteristics#LENS_INFO_FOCUS_DISTANCE_CALIBRATION} for details</p>
 * <p><b>Range of valid values:</b><br>
 * &gt;= 0</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Full capability</b> -
 * Present on all camera devices that report being {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see android.hardware.camera2.CameraCharacteristics#LENS_INFO_FOCUS_DISTANCE_CALIBRATION
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Float> LENS_FOCUS_DISTANCE;
static { LENS_FOCUS_DISTANCE = null; }

/**
 * <p>The range of scene distances that are in
 * sharp focus (depth of field).</p>
 * <p>If variable focus not supported, can still report
 * fixed depth of field range</p>
 * <p><b>Units</b>: A pair of focus distances in diopters: (near,
 * far); see {@link android.hardware.camera2.CameraCharacteristics#LENS_INFO_FOCUS_DISTANCE_CALIBRATION CameraCharacteristics#LENS_INFO_FOCUS_DISTANCE_CALIBRATION} for details.</p>
 * <p><b>Range of valid values:</b><br>
 * &gt;=0</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Limited capability</b> -
 * Present on all camera devices that report being at least {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see android.hardware.camera2.CameraCharacteristics#LENS_INFO_FOCUS_DISTANCE_CALIBRATION
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<android.util.Pair<java.lang.Float,java.lang.Float>> LENS_FOCUS_RANGE;
static { LENS_FOCUS_RANGE = null; }

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

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<float[]> LENS_INTRINSIC_CALIBRATION;
static { LENS_INTRINSIC_CALIBRATION = null; }

/**
 * <p>Sets whether the camera device uses optical image stabilization (OIS)
 * when capturing images.</p>
 * <p>OIS is used to compensate for motion blur due to small
 * movements of the camera during capture. Unlike digital image
 * stabilization ({@link android.hardware.camera2.CaptureRequest#CONTROL_VIDEO_STABILIZATION_MODE CaptureRequest#CONTROL_VIDEO_STABILIZATION_MODE}), OIS
 * makes use of mechanical elements to stabilize the camera
 * sensor, and thus allows for longer exposure times before
 * camera shake becomes apparent.</p>
 * <p>Switching between different optical stabilization modes may take several
 * frames to initialize, the camera device will report the current mode in
 * capture result metadata. For example, When "ON" mode is requested, the
 * optical stabilization modes in the first several capture results may still
 * be "OFF", and it will become "ON" when the initialization is done.</p>
 * <p>If a camera device supports both OIS and digital image stabilization
 * ({@link android.hardware.camera2.CaptureRequest#CONTROL_VIDEO_STABILIZATION_MODE CaptureRequest#CONTROL_VIDEO_STABILIZATION_MODE}), turning both modes on may produce undesirable
 * interaction, so it is recommended not to enable both at the same time.</p>
 * <p>Not all devices will support OIS; see
 * {@link android.hardware.camera2.CameraCharacteristics#LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION CameraCharacteristics#LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION} for
 * available controls.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #LENS_OPTICAL_STABILIZATION_MODE_OFF OFF}</li>
 *   <li>{@link #LENS_OPTICAL_STABILIZATION_MODE_ON ON}</li>
 * </ul></p>
 * <p><b>Available values for this device:</b><br>
 * {@link android.hardware.camera2.CameraCharacteristics#LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION CameraCharacteristics#LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION}</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Limited capability</b> -
 * Present on all camera devices that report being at least {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_VIDEO_STABILIZATION_MODE
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see android.hardware.camera2.CameraCharacteristics#LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION
 * @see #LENS_OPTICAL_STABILIZATION_MODE_OFF
 * @see #LENS_OPTICAL_STABILIZATION_MODE_ON
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> LENS_OPTICAL_STABILIZATION_MODE;
static { LENS_OPTICAL_STABILIZATION_MODE = null; }

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

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<float[]> LENS_POSE_ROTATION;
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

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<float[]> LENS_POSE_TRANSLATION;
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

@Deprecated @androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<float[]> LENS_RADIAL_DISTORTION;
static { LENS_RADIAL_DISTORTION = null; }

/**
 * <p>Current lens status.</p>
 * <p>For lens parameters {@link android.hardware.camera2.CaptureRequest#LENS_FOCAL_LENGTH CaptureRequest#LENS_FOCAL_LENGTH}, {@link android.hardware.camera2.CaptureRequest#LENS_FOCUS_DISTANCE CaptureRequest#LENS_FOCUS_DISTANCE},
 * {@link android.hardware.camera2.CaptureRequest#LENS_FILTER_DENSITY CaptureRequest#LENS_FILTER_DENSITY} and {@link android.hardware.camera2.CaptureRequest#LENS_APERTURE CaptureRequest#LENS_APERTURE}, when changes are requested,
 * they may take several frames to reach the requested values. This state indicates
 * the current status of the lens parameters.</p>
 * <p>When the state is STATIONARY, the lens parameters are not changing. This could be
 * either because the parameters are all fixed, or because the lens has had enough
 * time to reach the most recently-requested values.
 * If all these lens parameters are not changable for a camera device, as listed below:</p>
 * <ul>
 * <li>Fixed focus (<code>{@link android.hardware.camera2.CameraCharacteristics#LENS_INFO_MINIMUM_FOCUS_DISTANCE CameraCharacteristics#LENS_INFO_MINIMUM_FOCUS_DISTANCE} == 0</code>), which means
 * {@link android.hardware.camera2.CaptureRequest#LENS_FOCUS_DISTANCE CaptureRequest#LENS_FOCUS_DISTANCE} parameter will always be 0.</li>
 * <li>Fixed focal length ({@link android.hardware.camera2.CameraCharacteristics#LENS_INFO_AVAILABLE_FOCAL_LENGTHS CameraCharacteristics#LENS_INFO_AVAILABLE_FOCAL_LENGTHS} contains single value),
 * which means the optical zoom is not supported.</li>
 * <li>No ND filter ({@link android.hardware.camera2.CameraCharacteristics#LENS_INFO_AVAILABLE_FILTER_DENSITIES CameraCharacteristics#LENS_INFO_AVAILABLE_FILTER_DENSITIES} contains only 0).</li>
 * <li>Fixed aperture ({@link android.hardware.camera2.CameraCharacteristics#LENS_INFO_AVAILABLE_APERTURES CameraCharacteristics#LENS_INFO_AVAILABLE_APERTURES} contains single value).</li>
 * </ul>
 * <p>Then this state will always be STATIONARY.</p>
 * <p>When the state is MOVING, it indicates that at least one of the lens parameters
 * is changing.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #LENS_STATE_STATIONARY STATIONARY}</li>
 *   <li>{@link #LENS_STATE_MOVING MOVING}</li>
 * </ul></p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Limited capability</b> -
 * Present on all camera devices that report being at least {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see android.hardware.camera2.CaptureRequest#LENS_APERTURE
 * @see android.hardware.camera2.CaptureRequest#LENS_FILTER_DENSITY
 * @see android.hardware.camera2.CaptureRequest#LENS_FOCAL_LENGTH
 * @see android.hardware.camera2.CaptureRequest#LENS_FOCUS_DISTANCE
 * @see android.hardware.camera2.CameraCharacteristics#LENS_INFO_AVAILABLE_APERTURES
 * @see android.hardware.camera2.CameraCharacteristics#LENS_INFO_AVAILABLE_FILTER_DENSITIES
 * @see android.hardware.camera2.CameraCharacteristics#LENS_INFO_AVAILABLE_FOCAL_LENGTHS
 * @see android.hardware.camera2.CameraCharacteristics#LENS_INFO_MINIMUM_FOCUS_DISTANCE
 * @see #LENS_STATE_STATIONARY
 * @see #LENS_STATE_MOVING
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> LENS_STATE;
static { LENS_STATE = null; }

/**
 * <p>String containing the ID of the underlying active physical camera.</p>
 * <p>The ID of the active physical camera that's backing the logical camera. All camera
 * streams and metadata that are not physical camera specific will be originating from this
 * physical camera.</p>
 * <p>For a logical camera made up of physical cameras where each camera's lenses have
 * different characteristics, the camera device may choose to switch between the physical
 * cameras when application changes FOCAL_LENGTH or SCALER_CROP_REGION.
 * At the time of lens switch, this result metadata reflects the new active physical camera
 * ID.</p>
 * <p>This key will be available if the camera device advertises this key via {@link android.hardware.camera2.CameraCharacteristics#getAvailableCaptureResultKeys }.
 * When available, this must be one of valid physical IDs backing this logical multi-camera.
 * If this key is not available for a logical multi-camera, the camera device implementation
 * may still switch between different active physical cameras based on use case, but the
 * current active physical camera information won't be available to the application.</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * @apiSince 29
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.String> LOGICAL_MULTI_CAMERA_ACTIVE_PHYSICAL_ID;
static { LOGICAL_MULTI_CAMERA_ACTIVE_PHYSICAL_ID = null; }

/**
 * <p>Mode of operation for the noise reduction algorithm.</p>
 * <p>The noise reduction algorithm attempts to improve image quality by removing
 * excessive noise added by the capture process, especially in dark conditions.</p>
 * <p>OFF means no noise reduction will be applied by the camera device, for both raw and
 * YUV domain.</p>
 * <p>MINIMAL means that only sensor raw domain basic noise reduction is enabled ,to remove
 * demosaicing or other processing artifacts. For YUV_REPROCESSING, MINIMAL is same as OFF.
 * This mode is optional, may not be support by all devices. The application should check
 * {@link android.hardware.camera2.CameraCharacteristics#NOISE_REDUCTION_AVAILABLE_NOISE_REDUCTION_MODES CameraCharacteristics#NOISE_REDUCTION_AVAILABLE_NOISE_REDUCTION_MODES} before using it.</p>
 * <p>FAST/HIGH_QUALITY both mean camera device determined noise filtering
 * will be applied. HIGH_QUALITY mode indicates that the camera device
 * will use the highest-quality noise filtering algorithms,
 * even if it slows down capture rate. FAST means the camera device will not
 * slow down capture rate when applying noise filtering. FAST may be the same as MINIMAL if
 * MINIMAL is listed, or the same as OFF if any noise filtering will slow down capture rate.
 * Every output stream will have a similar amount of enhancement applied.</p>
 * <p>ZERO_SHUTTER_LAG is meant to be used by applications that maintain a continuous circular
 * buffer of high-resolution images during preview and reprocess image(s) from that buffer
 * into a final capture when triggered by the user. In this mode, the camera device applies
 * noise reduction to low-resolution streams (below maximum recording resolution) to maximize
 * preview quality, but does not apply noise reduction to high-resolution streams, since
 * those will be reprocessed later if necessary.</p>
 * <p>For YUV_REPROCESSING, these FAST/HIGH_QUALITY modes both mean that the camera device
 * will apply FAST/HIGH_QUALITY YUV domain noise reduction, respectively. The camera device
 * may adjust the noise reduction parameters for best image quality based on the
 * {@link android.hardware.camera2.CaptureRequest#REPROCESS_EFFECTIVE_EXPOSURE_FACTOR CaptureRequest#REPROCESS_EFFECTIVE_EXPOSURE_FACTOR} if it is set.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #NOISE_REDUCTION_MODE_OFF OFF}</li>
 *   <li>{@link #NOISE_REDUCTION_MODE_FAST FAST}</li>
 *   <li>{@link #NOISE_REDUCTION_MODE_HIGH_QUALITY HIGH_QUALITY}</li>
 *   <li>{@link #NOISE_REDUCTION_MODE_MINIMAL MINIMAL}</li>
 *   <li>{@link #NOISE_REDUCTION_MODE_ZERO_SHUTTER_LAG ZERO_SHUTTER_LAG}</li>
 * </ul></p>
 * <p><b>Available values for this device:</b><br>
 * {@link android.hardware.camera2.CameraCharacteristics#NOISE_REDUCTION_AVAILABLE_NOISE_REDUCTION_MODES CameraCharacteristics#NOISE_REDUCTION_AVAILABLE_NOISE_REDUCTION_MODES}</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Full capability</b> -
 * Present on all camera devices that report being {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see android.hardware.camera2.CameraCharacteristics#NOISE_REDUCTION_AVAILABLE_NOISE_REDUCTION_MODES
 * @see android.hardware.camera2.CaptureRequest#REPROCESS_EFFECTIVE_EXPOSURE_FACTOR
 * @see #NOISE_REDUCTION_MODE_OFF
 * @see #NOISE_REDUCTION_MODE_FAST
 * @see #NOISE_REDUCTION_MODE_HIGH_QUALITY
 * @see #NOISE_REDUCTION_MODE_MINIMAL
 * @see #NOISE_REDUCTION_MODE_ZERO_SHUTTER_LAG
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> NOISE_REDUCTION_MODE;
static { NOISE_REDUCTION_MODE = null; }

/**
 * <p>The amount of exposure time increase factor applied to the original output
 * frame by the application processing before sending for reprocessing.</p>
 * <p>This is optional, and will be supported if the camera device supports YUV_REPROCESSING
 * capability ({@link android.hardware.camera2.CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES} contains YUV_REPROCESSING).</p>
 * <p>For some YUV reprocessing use cases, the application may choose to filter the original
 * output frames to effectively reduce the noise to the same level as a frame that was
 * captured with longer exposure time. To be more specific, assuming the original captured
 * images were captured with a sensitivity of S and an exposure time of T, the model in
 * the camera device is that the amount of noise in the image would be approximately what
 * would be expected if the original capture parameters had been a sensitivity of
 * S/effectiveExposureFactor and an exposure time of T*effectiveExposureFactor, rather
 * than S and T respectively. If the captured images were processed by the application
 * before being sent for reprocessing, then the application may have used image processing
 * algorithms and/or multi-frame image fusion to reduce the noise in the
 * application-processed images (input images). By using the effectiveExposureFactor
 * control, the application can communicate to the camera device the actual noise level
 * improvement in the application-processed image. With this information, the camera
 * device can select appropriate noise reduction and edge enhancement parameters to avoid
 * excessive noise reduction ({@link android.hardware.camera2.CaptureRequest#NOISE_REDUCTION_MODE CaptureRequest#NOISE_REDUCTION_MODE}) and insufficient edge
 * enhancement ({@link android.hardware.camera2.CaptureRequest#EDGE_MODE CaptureRequest#EDGE_MODE}) being applied to the reprocessed frames.</p>
 * <p>For example, for multi-frame image fusion use case, the application may fuse
 * multiple output frames together to a final frame for reprocessing. When N image are
 * fused into 1 image for reprocessing, the exposure time increase factor could be up to
 * square root of N (based on a simple photon shot noise model). The camera device will
 * adjust the reprocessing noise reduction and edge enhancement parameters accordingly to
 * produce the best quality images.</p>
 * <p>This is relative factor, 1.0 indicates the application hasn't processed the input
 * buffer in a way that affects its effective exposure time.</p>
 * <p>This control is only effective for YUV reprocessing capture request. For noise
 * reduction reprocessing, it is only effective when <code>{@link android.hardware.camera2.CaptureRequest#NOISE_REDUCTION_MODE CaptureRequest#NOISE_REDUCTION_MODE} != OFF</code>.
 * Similarly, for edge enhancement reprocessing, it is only effective when
 * <code>{@link android.hardware.camera2.CaptureRequest#EDGE_MODE CaptureRequest#EDGE_MODE} != OFF</code>.</p>
 * <p><b>Units</b>: Relative exposure time increase factor.</p>
 * <p><b>Range of valid values:</b><br>
 * &gt;= 1.0</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Limited capability</b> -
 * Present on all camera devices that report being at least {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CaptureRequest#EDGE_MODE
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see android.hardware.camera2.CaptureRequest#NOISE_REDUCTION_MODE
 * @see android.hardware.camera2.CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES
 * @apiSince 23
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Float> REPROCESS_EFFECTIVE_EXPOSURE_FACTOR;
static { REPROCESS_EFFECTIVE_EXPOSURE_FACTOR = null; }

/**
 * <p>Specifies the number of pipeline stages the frame went
 * through from when it was exposed to when the final completed result
 * was available to the framework.</p>
 * <p>Depending on what settings are used in the request, and
 * what streams are configured, the data may undergo less processing,
 * and some pipeline stages skipped.</p>
 * <p>See {@link android.hardware.camera2.CameraCharacteristics#REQUEST_PIPELINE_MAX_DEPTH CameraCharacteristics#REQUEST_PIPELINE_MAX_DEPTH} for more details.</p>
 * <p><b>Range of valid values:</b><br>
 * &lt;= {@link android.hardware.camera2.CameraCharacteristics#REQUEST_PIPELINE_MAX_DEPTH CameraCharacteristics#REQUEST_PIPELINE_MAX_DEPTH}</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#REQUEST_PIPELINE_MAX_DEPTH
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Byte> REQUEST_PIPELINE_DEPTH;
static { REQUEST_PIPELINE_DEPTH = null; }

/**
 * <p>The desired region of the sensor to read out for this capture.</p>
 * <p>This control can be used to implement digital zoom.</p>
 * <p>For devices not supporting {@link android.hardware.camera2.CaptureRequest#DISTORTION_CORRECTION_MODE CaptureRequest#DISTORTION_CORRECTION_MODE} control, the coordinate
 * system always follows that of {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE}, with <code>(0, 0)</code> being
 * the top-left pixel of the active array.</p>
 * <p>For devices supporting {@link android.hardware.camera2.CaptureRequest#DISTORTION_CORRECTION_MODE CaptureRequest#DISTORTION_CORRECTION_MODE} control, the coordinate
 * system depends on the mode being set.
 * When the distortion correction mode is OFF, the coordinate system follows
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE}, with
 * <code>(0, 0)</code> being the top-left pixel of the pre-correction active array.
 * When the distortion correction mode is not OFF, the coordinate system follows
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE}, with
 * <code>(0, 0)</code> being the top-left pixel of the active array.</p>
 * <p>Output streams use this rectangle to produce their output,
 * cropping to a smaller region if necessary to maintain the
 * stream's aspect ratio, then scaling the sensor input to
 * match the output's configured resolution.</p>
 * <p>The crop region is applied after the RAW to other color
 * space (e.g. YUV) conversion. Since raw streams
 * (e.g. RAW16) don't have the conversion stage, they are not
 * croppable. The crop region will be ignored by raw streams.</p>
 * <p>For non-raw streams, any additional per-stream cropping will
 * be done to maximize the final pixel area of the stream.</p>
 * <p>For example, if the crop region is set to a 4:3 aspect
 * ratio, then 4:3 streams will use the exact crop
 * region. 16:9 streams will further crop vertically
 * (letterbox).</p>
 * <p>Conversely, if the crop region is set to a 16:9, then 4:3
 * outputs will crop horizontally (pillarbox), and 16:9
 * streams will match exactly. These additional crops will
 * be centered within the crop region.</p>
 * <p>If the coordinate system is {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE}, the width and height
 * of the crop region cannot be set to be smaller than
 * <code>floor( activeArraySize.width / {@link android.hardware.camera2.CameraCharacteristics#SCALER_AVAILABLE_MAX_DIGITAL_ZOOM CameraCharacteristics#SCALER_AVAILABLE_MAX_DIGITAL_ZOOM} )</code> and
 * <code>floor( activeArraySize.height / {@link android.hardware.camera2.CameraCharacteristics#SCALER_AVAILABLE_MAX_DIGITAL_ZOOM CameraCharacteristics#SCALER_AVAILABLE_MAX_DIGITAL_ZOOM} )</code>, respectively.</p>
 * <p>If the coordinate system is {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE}, the width
 * and height of the crop region cannot be set to be smaller than
 * <code>floor( preCorrectionActiveArraySize.width / {@link android.hardware.camera2.CameraCharacteristics#SCALER_AVAILABLE_MAX_DIGITAL_ZOOM CameraCharacteristics#SCALER_AVAILABLE_MAX_DIGITAL_ZOOM} )</code>
 * and
 * <code>floor( preCorrectionActiveArraySize.height / {@link android.hardware.camera2.CameraCharacteristics#SCALER_AVAILABLE_MAX_DIGITAL_ZOOM CameraCharacteristics#SCALER_AVAILABLE_MAX_DIGITAL_ZOOM} )</code>,
 * respectively.</p>
 * <p>The camera device may adjust the crop region to account
 * for rounding and other hardware requirements; the final
 * crop region used will be included in the output capture
 * result.</p>
 * <p><b>Units</b>: Pixel coordinates relative to
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE} or
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE} depending on distortion correction
 * capability and mode</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#DISTORTION_CORRECTION_MODE
 * @see android.hardware.camera2.CameraCharacteristics#SCALER_AVAILABLE_MAX_DIGITAL_ZOOM
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<android.graphics.Rect> SCALER_CROP_REGION;
static { SCALER_CROP_REGION = null; }

/**
 * <p>A per-frame dynamic black level offset for each of the color filter
 * arrangement (CFA) mosaic channels.</p>
 * <p>Camera sensor black levels may vary dramatically for different
 * capture settings (e.g. {@link android.hardware.camera2.CaptureRequest#SENSOR_SENSITIVITY CaptureRequest#SENSOR_SENSITIVITY}). The fixed black
 * level reported by {@link android.hardware.camera2.CameraCharacteristics#SENSOR_BLACK_LEVEL_PATTERN CameraCharacteristics#SENSOR_BLACK_LEVEL_PATTERN} may be too
 * inaccurate to represent the actual value on a per-frame basis. The
 * camera device internal pipeline relies on reliable black level values
 * to process the raw images appropriately. To get the best image
 * quality, the camera device may choose to estimate the per frame black
 * level values either based on optically shielded black regions
 * ({@link android.hardware.camera2.CameraCharacteristics#SENSOR_OPTICAL_BLACK_REGIONS CameraCharacteristics#SENSOR_OPTICAL_BLACK_REGIONS}) or its internal model.</p>
 * <p>This key reports the camera device estimated per-frame zero light
 * value for each of the CFA mosaic channels in the camera sensor. The
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_BLACK_LEVEL_PATTERN CameraCharacteristics#SENSOR_BLACK_LEVEL_PATTERN} may only represent a coarse
 * approximation of the actual black level values. This value is the
 * black level used in camera device internal image processing pipeline
 * and generally more accurate than the fixed black level values.
 * However, since they are estimated values by the camera device, they
 * may not be as accurate as the black level values calculated from the
 * optical black pixels reported by {@link android.hardware.camera2.CameraCharacteristics#SENSOR_OPTICAL_BLACK_REGIONS CameraCharacteristics#SENSOR_OPTICAL_BLACK_REGIONS}.</p>
 * <p>The values are given in the same order as channels listed for the CFA
 * layout key (see {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_COLOR_FILTER_ARRANGEMENT CameraCharacteristics#SENSOR_INFO_COLOR_FILTER_ARRANGEMENT}), i.e. the
 * nth value given corresponds to the black level offset for the nth
 * color channel listed in the CFA.</p>
 * <p>For a MONOCHROME camera, all of the 2x2 channels must have the same values.</p>
 * <p>This key will be available if {@link android.hardware.camera2.CameraCharacteristics#SENSOR_OPTICAL_BLACK_REGIONS CameraCharacteristics#SENSOR_OPTICAL_BLACK_REGIONS} is available or the
 * camera device advertises this key via {@link android.hardware.camera2.CameraCharacteristics#getAvailableCaptureResultKeys }.</p>
 * <p><b>Range of valid values:</b><br>
 * &gt;= 0 for each.</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_BLACK_LEVEL_PATTERN
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_COLOR_FILTER_ARRANGEMENT
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_OPTICAL_BLACK_REGIONS
 * @see android.hardware.camera2.CaptureRequest#SENSOR_SENSITIVITY
 * @apiSince 24
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<float[]> SENSOR_DYNAMIC_BLACK_LEVEL;
static { SENSOR_DYNAMIC_BLACK_LEVEL = null; }

/**
 * <p>Maximum raw value output by sensor for this frame.</p>
 * <p>Since the {@link android.hardware.camera2.CameraCharacteristics#SENSOR_BLACK_LEVEL_PATTERN CameraCharacteristics#SENSOR_BLACK_LEVEL_PATTERN} may change for different
 * capture settings (e.g., {@link android.hardware.camera2.CaptureRequest#SENSOR_SENSITIVITY CaptureRequest#SENSOR_SENSITIVITY}), the white
 * level will change accordingly. This key is similar to
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_WHITE_LEVEL CameraCharacteristics#SENSOR_INFO_WHITE_LEVEL}, but specifies the camera device
 * estimated white level for each frame.</p>
 * <p>This key will be available if {@link android.hardware.camera2.CameraCharacteristics#SENSOR_OPTICAL_BLACK_REGIONS CameraCharacteristics#SENSOR_OPTICAL_BLACK_REGIONS} is
 * available or the camera device advertises this key via
 * {@link android.hardware.camera2.CameraCharacteristics#getAvailableCaptureRequestKeys }.</p>
 * <p><b>Range of valid values:</b><br>
 * &gt;= 0</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_BLACK_LEVEL_PATTERN
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_WHITE_LEVEL
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_OPTICAL_BLACK_REGIONS
 * @see android.hardware.camera2.CaptureRequest#SENSOR_SENSITIVITY
 * @apiSince 24
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> SENSOR_DYNAMIC_WHITE_LEVEL;
static { SENSOR_DYNAMIC_WHITE_LEVEL = null; }

/**
 * <p>Duration each pixel is exposed to
 * light.</p>
 * <p>If the sensor can't expose this exact duration, it will shorten the
 * duration exposed to the nearest possible value (rather than expose longer).
 * The final exposure time used will be available in the output capture result.</p>
 * <p>This control is only effective if {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE CaptureRequest#CONTROL_AE_MODE} or {@link android.hardware.camera2.CaptureRequest#CONTROL_MODE CaptureRequest#CONTROL_MODE} is set to
 * OFF; otherwise the auto-exposure algorithm will override this value.</p>
 * <p><b>Units</b>: Nanoseconds</p>
 * <p><b>Range of valid values:</b><br>
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_EXPOSURE_TIME_RANGE CameraCharacteristics#SENSOR_INFO_EXPOSURE_TIME_RANGE}</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Full capability</b> -
 * Present on all camera devices that report being {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE
 * @see android.hardware.camera2.CaptureRequest#CONTROL_MODE
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_EXPOSURE_TIME_RANGE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Long> SENSOR_EXPOSURE_TIME;
static { SENSOR_EXPOSURE_TIME = null; }

/**
 * <p>Duration from start of frame exposure to
 * start of next frame exposure.</p>
 * <p>The maximum frame rate that can be supported by a camera subsystem is
 * a function of many factors:</p>
 * <ul>
 * <li>Requested resolutions of output image streams</li>
 * <li>Availability of binning / skipping modes on the imager</li>
 * <li>The bandwidth of the imager interface</li>
 * <li>The bandwidth of the various ISP processing blocks</li>
 * </ul>
 * <p>Since these factors can vary greatly between different ISPs and
 * sensors, the camera abstraction tries to represent the bandwidth
 * restrictions with as simple a model as possible.</p>
 * <p>The model presented has the following characteristics:</p>
 * <ul>
 * <li>The image sensor is always configured to output the smallest
 * resolution possible given the application's requested output stream
 * sizes.  The smallest resolution is defined as being at least as large
 * as the largest requested output stream size; the camera pipeline must
 * never digitally upsample sensor data when the crop region covers the
 * whole sensor. In general, this means that if only small output stream
 * resolutions are configured, the sensor can provide a higher frame
 * rate.</li>
 * <li>Since any request may use any or all the currently configured
 * output streams, the sensor and ISP must be configured to support
 * scaling a single capture to all the streams at the same time.  This
 * means the camera pipeline must be ready to produce the largest
 * requested output size without any delay.  Therefore, the overall
 * frame rate of a given configured stream set is governed only by the
 * largest requested stream resolution.</li>
 * <li>Using more than one output stream in a request does not affect the
 * frame duration.</li>
 * <li>Certain format-streams may need to do additional background processing
 * before data is consumed/produced by that stream. These processors
 * can run concurrently to the rest of the camera pipeline, but
 * cannot process more than 1 capture at a time.</li>
 * </ul>
 * <p>The necessary information for the application, given the model above, is provided via
 * {@link android.hardware.camera2.params.StreamConfigurationMap#getOutputMinFrameDuration }.
 * These are used to determine the maximum frame rate / minimum frame duration that is
 * possible for a given stream configuration.</p>
 * <p>Specifically, the application can use the following rules to
 * determine the minimum frame duration it can request from the camera
 * device:</p>
 * <ol>
 * <li>Let the set of currently configured input/output streams be called <code>S</code>.</li>
 * <li>Find the minimum frame durations for each stream in <code>S</code>, by looking it up in {@link android.hardware.camera2.params.StreamConfigurationMap#getOutputMinFrameDuration }
 * (with its respective size/format). Let this set of frame durations be called <code>F</code>.</li>
 * <li>For any given request <code>R</code>, the minimum frame duration allowed for <code>R</code> is the maximum
 * out of all values in <code>F</code>. Let the streams used in <code>R</code> be called <code>S_r</code>.</li>
 * </ol>
 * <p>If none of the streams in <code>S_r</code> have a stall time (listed in {@link android.hardware.camera2.params.StreamConfigurationMap#getOutputStallDuration }
 * using its respective size/format), then the frame duration in <code>F</code> determines the steady
 * state frame rate that the application will get if it uses <code>R</code> as a repeating request. Let
 * this special kind of request be called <code>Rsimple</code>.</p>
 * <p>A repeating request <code>Rsimple</code> can be <em>occasionally</em> interleaved by a single capture of a
 * new request <code>Rstall</code> (which has at least one in-use stream with a non-0 stall time) and if
 * <code>Rstall</code> has the same minimum frame duration this will not cause a frame rate loss if all
 * buffers from the previous <code>Rstall</code> have already been delivered.</p>
 * <p>For more details about stalling, see {@link android.hardware.camera2.params.StreamConfigurationMap#getOutputStallDuration }.</p>
 * <p>This control is only effective if {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE CaptureRequest#CONTROL_AE_MODE} or {@link android.hardware.camera2.CaptureRequest#CONTROL_MODE CaptureRequest#CONTROL_MODE} is set to
 * OFF; otherwise the auto-exposure algorithm will override this value.</p>
 * <p><b>Units</b>: Nanoseconds</p>
 * <p><b>Range of valid values:</b><br>
 * See {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_MAX_FRAME_DURATION CameraCharacteristics#SENSOR_INFO_MAX_FRAME_DURATION}, {@link android.hardware.camera2.params.StreamConfigurationMap }.
 * The duration is capped to <code>max(duration, exposureTime + overhead)</code>.</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Full capability</b> -
 * Present on all camera devices that report being {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE
 * @see android.hardware.camera2.CaptureRequest#CONTROL_MODE
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_MAX_FRAME_DURATION
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Long> SENSOR_FRAME_DURATION;
static { SENSOR_FRAME_DURATION = null; }

/**
 * <p>The worst-case divergence between Bayer green channels.</p>
 * <p>This value is an estimate of the worst case split between the
 * Bayer green channels in the red and blue rows in the sensor color
 * filter array.</p>
 * <p>The green split is calculated as follows:</p>
 * <ol>
 * <li>A 5x5 pixel (or larger) window W within the active sensor array is
 * chosen. The term 'pixel' here is taken to mean a group of 4 Bayer
 * mosaic channels (R, Gr, Gb, B).  The location and size of the window
 * chosen is implementation defined, and should be chosen to provide a
 * green split estimate that is both representative of the entire image
 * for this camera sensor, and can be calculated quickly.</li>
 * <li>The arithmetic mean of the green channels from the red
 * rows (mean_Gr) within W is computed.</li>
 * <li>The arithmetic mean of the green channels from the blue
 * rows (mean_Gb) within W is computed.</li>
 * <li>The maximum ratio R of the two means is computed as follows:
 * <code>R = max((mean_Gr + 1)/(mean_Gb + 1), (mean_Gb + 1)/(mean_Gr + 1))</code></li>
 * </ol>
 * <p>The ratio R is the green split divergence reported for this property,
 * which represents how much the green channels differ in the mosaic
 * pattern.  This value is typically used to determine the treatment of
 * the green mosaic channels when demosaicing.</p>
 * <p>The green split value can be roughly interpreted as follows:</p>
 * <ul>
 * <li>R &lt; 1.03 is a negligible split (&lt;3% divergence).</li>
 * <li>1.20 &lt;= R &gt;= 1.03 will require some software
 * correction to avoid demosaic errors (3-20% divergence).</li>
 * <li>R &gt; 1.20 will require strong software correction to produce
 * a usuable image (&gt;20% divergence).</li>
 * </ul>
 * <p>Starting from Android Q, this key will not be present for a MONOCHROME camera, even if
 * the camera device has RAW capability.</p>
 * <p><b>Range of valid values:</b><br></p>
 * <p>&gt;= 0</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Float> SENSOR_GREEN_SPLIT;
static { SENSOR_GREEN_SPLIT = null; }

/**
 * <p>The estimated camera neutral color in the native sensor colorspace at
 * the time of capture.</p>
 * <p>This value gives the neutral color point encoded as an RGB value in the
 * native sensor color space.  The neutral color point indicates the
 * currently estimated white point of the scene illumination.  It can be
 * used to interpolate between the provided color transforms when
 * processing raw sensor data.</p>
 * <p>The order of the values is R, G, B; where R is in the lowest index.</p>
 * <p>Starting from Android Q, this key will not be present for a MONOCHROME camera, even if
 * the camera device has RAW capability.</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<android.util.Rational[]> SENSOR_NEUTRAL_COLOR_POINT;
static { SENSOR_NEUTRAL_COLOR_POINT = null; }

/**
 * <p>Noise model coefficients for each CFA mosaic channel.</p>
 * <p>This key contains two noise model coefficients for each CFA channel
 * corresponding to the sensor amplification (S) and sensor readout
 * noise (O).  These are given as pairs of coefficients for each channel
 * in the same order as channels listed for the CFA layout key
 * (see {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_COLOR_FILTER_ARRANGEMENT CameraCharacteristics#SENSOR_INFO_COLOR_FILTER_ARRANGEMENT}).  This is
 * represented as an array of Pair&lt;Double, Double&gt;, where
 * the first member of the Pair at index n is the S coefficient and the
 * second member is the O coefficient for the nth color channel in the CFA.</p>
 * <p>These coefficients are used in a two parameter noise model to describe
 * the amount of noise present in the image for each CFA channel.  The
 * noise model used here is:</p>
 * <p>N(x) = sqrt(Sx + O)</p>
 * <p>Where x represents the recorded signal of a CFA channel normalized to
 * the range [0, 1], and S and O are the noise model coeffiecients for
 * that channel.</p>
 * <p>A more detailed description of the noise model can be found in the
 * Adobe DNG specification for the NoiseProfile tag.</p>
 * <p>For a MONOCHROME camera, there is only one color channel. So the noise model coefficients
 * will only contain one S and one O.</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_COLOR_FILTER_ARRANGEMENT
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<android.util.Pair<java.lang.Double,java.lang.Double>[]> SENSOR_NOISE_PROFILE;
static { SENSOR_NOISE_PROFILE = null; }

/**
 * <p>Duration between the start of first row exposure
 * and the start of last row exposure.</p>
 * <p>This is the exposure time skew between the first and last
 * row exposure start times. The first row and the last row are
 * the first and last rows inside of the
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE}.</p>
 * <p>For typical camera sensors that use rolling shutters, this is also equivalent
 * to the frame readout time.</p>
 * <p><b>Units</b>: Nanoseconds</p>
 * <p><b>Range of valid values:</b><br>
 * &gt;= 0 and &lt;
 * {@link android.hardware.camera2.params.StreamConfigurationMap#getOutputMinFrameDuration }.</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Limited capability</b> -
 * Present on all camera devices that report being at least {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Long> SENSOR_ROLLING_SHUTTER_SKEW;
static { SENSOR_ROLLING_SHUTTER_SKEW = null; }

/**
 * <p>The amount of gain applied to sensor data
 * before processing.</p>
 * <p>The sensitivity is the standard ISO sensitivity value,
 * as defined in ISO 12232:2006.</p>
 * <p>The sensitivity must be within {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_SENSITIVITY_RANGE CameraCharacteristics#SENSOR_INFO_SENSITIVITY_RANGE}, and
 * if if it less than {@link android.hardware.camera2.CameraCharacteristics#SENSOR_MAX_ANALOG_SENSITIVITY CameraCharacteristics#SENSOR_MAX_ANALOG_SENSITIVITY}, the camera device
 * is guaranteed to use only analog amplification for applying the gain.</p>
 * <p>If the camera device cannot apply the exact sensitivity
 * requested, it will reduce the gain to the nearest supported
 * value. The final sensitivity used will be available in the
 * output capture result.</p>
 * <p>This control is only effective if {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE CaptureRequest#CONTROL_AE_MODE} or {@link android.hardware.camera2.CaptureRequest#CONTROL_MODE CaptureRequest#CONTROL_MODE} is set to
 * OFF; otherwise the auto-exposure algorithm will override this value.</p>
 * <p><b>Units</b>: ISO arithmetic units</p>
 * <p><b>Range of valid values:</b><br>
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_SENSITIVITY_RANGE CameraCharacteristics#SENSOR_INFO_SENSITIVITY_RANGE}</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Full capability</b> -
 * Present on all camera devices that report being {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE
 * @see android.hardware.camera2.CaptureRequest#CONTROL_MODE
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_SENSITIVITY_RANGE
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_MAX_ANALOG_SENSITIVITY
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> SENSOR_SENSITIVITY;
static { SENSOR_SENSITIVITY = null; }

/**
 * <p>A pixel <code>[R, G_even, G_odd, B]</code> that supplies the test pattern
 * when {@link android.hardware.camera2.CaptureRequest#SENSOR_TEST_PATTERN_MODE CaptureRequest#SENSOR_TEST_PATTERN_MODE} is SOLID_COLOR.</p>
 * <p>Each color channel is treated as an unsigned 32-bit integer.
 * The camera device then uses the most significant X bits
 * that correspond to how many bits are in its Bayer raw sensor
 * output.</p>
 * <p>For example, a sensor with RAW10 Bayer output would use the
 * 10 most significant bits from each color channel.</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#SENSOR_TEST_PATTERN_MODE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<int[]> SENSOR_TEST_PATTERN_DATA;
static { SENSOR_TEST_PATTERN_DATA = null; }

/**
 * <p>When enabled, the sensor sends a test pattern instead of
 * doing a real exposure from the camera.</p>
 * <p>When a test pattern is enabled, all manual sensor controls specified
 * by android.sensor.* will be ignored. All other controls should
 * work as normal.</p>
 * <p>For example, if manual flash is enabled, flash firing should still
 * occur (and that the test pattern remain unmodified, since the flash
 * would not actually affect it).</p>
 * <p>Defaults to OFF.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #SENSOR_TEST_PATTERN_MODE_OFF OFF}</li>
 *   <li>{@link #SENSOR_TEST_PATTERN_MODE_SOLID_COLOR SOLID_COLOR}</li>
 *   <li>{@link #SENSOR_TEST_PATTERN_MODE_COLOR_BARS COLOR_BARS}</li>
 *   <li>{@link #SENSOR_TEST_PATTERN_MODE_COLOR_BARS_FADE_TO_GRAY COLOR_BARS_FADE_TO_GRAY}</li>
 *   <li>{@link #SENSOR_TEST_PATTERN_MODE_PN9 PN9}</li>
 *   <li>{@link #SENSOR_TEST_PATTERN_MODE_CUSTOM1 CUSTOM1}</li>
 * </ul></p>
 * <p><b>Available values for this device:</b><br>
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_AVAILABLE_TEST_PATTERN_MODES CameraCharacteristics#SENSOR_AVAILABLE_TEST_PATTERN_MODES}</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_AVAILABLE_TEST_PATTERN_MODES
 * @see #SENSOR_TEST_PATTERN_MODE_OFF
 * @see #SENSOR_TEST_PATTERN_MODE_SOLID_COLOR
 * @see #SENSOR_TEST_PATTERN_MODE_COLOR_BARS
 * @see #SENSOR_TEST_PATTERN_MODE_COLOR_BARS_FADE_TO_GRAY
 * @see #SENSOR_TEST_PATTERN_MODE_PN9
 * @see #SENSOR_TEST_PATTERN_MODE_CUSTOM1
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> SENSOR_TEST_PATTERN_MODE;
static { SENSOR_TEST_PATTERN_MODE = null; }

/**
 * <p>Time at start of exposure of first
 * row of the image sensor active array, in nanoseconds.</p>
 * <p>The timestamps are also included in all image
 * buffers produced for the same capture, and will be identical
 * on all the outputs.</p>
 * <p>When {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_TIMESTAMP_SOURCE CameraCharacteristics#SENSOR_INFO_TIMESTAMP_SOURCE} <code>==</code> UNKNOWN,
 * the timestamps measure time since an unspecified starting point,
 * and are monotonically increasing. They can be compared with the
 * timestamps for other captures from the same camera device, but are
 * not guaranteed to be comparable to any other time source.</p>
 * <p>When {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_TIMESTAMP_SOURCE CameraCharacteristics#SENSOR_INFO_TIMESTAMP_SOURCE} <code>==</code> REALTIME, the
 * timestamps measure time in the same timebase as {@link android.os.SystemClock#elapsedRealtimeNanos }, and they can
 * be compared to other timestamps from other subsystems that
 * are using that base.</p>
 * <p>For reprocessing, the timestamp will match the start of exposure of
 * the input image, i.e. {@link android.hardware.camera2.CaptureResult#SENSOR_TIMESTAMP CaptureResult#SENSOR_TIMESTAMP} in the TotalCaptureResult that was used to create the
 * reprocess capture request.</p>
 * <p><b>Units</b>: Nanoseconds</p>
 * <p><b>Range of valid values:</b><br>
 * &gt; 0</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_TIMESTAMP_SOURCE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Long> SENSOR_TIMESTAMP;
static { SENSOR_TIMESTAMP = null; }

/**
 * <p>Quality of lens shading correction applied
 * to the image data.</p>
 * <p>When set to OFF mode, no lens shading correction will be applied by the
 * camera device, and an identity lens shading map data will be provided
 * if <code>{@link android.hardware.camera2.CaptureRequest#STATISTICS_LENS_SHADING_MAP_MODE CaptureRequest#STATISTICS_LENS_SHADING_MAP_MODE} == ON</code>. For example, for lens
 * shading map with size of <code>[ 4, 3 ]</code>,
 * the output {@link android.hardware.camera2.CaptureResult#STATISTICS_LENS_SHADING_CORRECTION_MAP CaptureResult#STATISTICS_LENS_SHADING_CORRECTION_MAP} for this case will be an identity
 * map shown below:</p>
 * <pre><code>[ 1.0, 1.0, 1.0, 1.0,  1.0, 1.0, 1.0, 1.0,
 *  1.0, 1.0, 1.0, 1.0,  1.0, 1.0, 1.0, 1.0,
 *  1.0, 1.0, 1.0, 1.0,  1.0, 1.0, 1.0, 1.0,
 *  1.0, 1.0, 1.0, 1.0,  1.0, 1.0, 1.0, 1.0,
 *  1.0, 1.0, 1.0, 1.0,  1.0, 1.0, 1.0, 1.0,
 *  1.0, 1.0, 1.0, 1.0,  1.0, 1.0, 1.0, 1.0 ]
 * </code></pre>
 * <p>When set to other modes, lens shading correction will be applied by the camera
 * device. Applications can request lens shading map data by setting
 * {@link android.hardware.camera2.CaptureRequest#STATISTICS_LENS_SHADING_MAP_MODE CaptureRequest#STATISTICS_LENS_SHADING_MAP_MODE} to ON, and then the camera device will provide lens
 * shading map data in {@link android.hardware.camera2.CaptureResult#STATISTICS_LENS_SHADING_CORRECTION_MAP CaptureResult#STATISTICS_LENS_SHADING_CORRECTION_MAP}; the returned shading map
 * data will be the one applied by the camera device for this capture request.</p>
 * <p>The shading map data may depend on the auto-exposure (AE) and AWB statistics, therefore
 * the reliability of the map data may be affected by the AE and AWB algorithms. When AE and
 * AWB are in AUTO modes({@link android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE CaptureRequest#CONTROL_AE_MODE} <code>!=</code> OFF and {@link android.hardware.camera2.CaptureRequest#CONTROL_AWB_MODE CaptureRequest#CONTROL_AWB_MODE} <code>!=</code>
 * OFF), to get best results, it is recommended that the applications wait for the AE and AWB
 * to be converged before using the returned shading map data.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #SHADING_MODE_OFF OFF}</li>
 *   <li>{@link #SHADING_MODE_FAST FAST}</li>
 *   <li>{@link #SHADING_MODE_HIGH_QUALITY HIGH_QUALITY}</li>
 * </ul></p>
 * <p><b>Available values for this device:</b><br>
 * {@link android.hardware.camera2.CameraCharacteristics#SHADING_AVAILABLE_MODES CameraCharacteristics#SHADING_AVAILABLE_MODES}</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Full capability</b> -
 * Present on all camera devices that report being {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AWB_MODE
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see android.hardware.camera2.CameraCharacteristics#SHADING_AVAILABLE_MODES
 * @see android.hardware.camera2.CaptureResult#STATISTICS_LENS_SHADING_CORRECTION_MAP
 * @see android.hardware.camera2.CaptureRequest#STATISTICS_LENS_SHADING_MAP_MODE
 * @see #SHADING_MODE_OFF
 * @see #SHADING_MODE_FAST
 * @see #SHADING_MODE_HIGH_QUALITY
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> SHADING_MODE;
static { SHADING_MODE = null; }

/**
 * <p>List of the faces detected through camera face detection
 * in this capture.</p>
 * <p>Only available if {@link android.hardware.camera2.CaptureRequest#STATISTICS_FACE_DETECT_MODE CaptureRequest#STATISTICS_FACE_DETECT_MODE} <code>!=</code> OFF.</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#STATISTICS_FACE_DETECT_MODE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<android.hardware.camera2.params.Face[]> STATISTICS_FACES;
static { STATISTICS_FACES = null; }

/**
 * <p>Operating mode for the face detector
 * unit.</p>
 * <p>Whether face detection is enabled, and whether it
 * should output just the basic fields or the full set of
 * fields.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #STATISTICS_FACE_DETECT_MODE_OFF OFF}</li>
 *   <li>{@link #STATISTICS_FACE_DETECT_MODE_SIMPLE SIMPLE}</li>
 *   <li>{@link #STATISTICS_FACE_DETECT_MODE_FULL FULL}</li>
 * </ul></p>
 * <p><b>Available values for this device:</b><br>
 * {@link android.hardware.camera2.CameraCharacteristics#STATISTICS_INFO_AVAILABLE_FACE_DETECT_MODES CameraCharacteristics#STATISTICS_INFO_AVAILABLE_FACE_DETECT_MODES}</p>
 * <p>This key is available on all devices.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#STATISTICS_INFO_AVAILABLE_FACE_DETECT_MODES
 * @see #STATISTICS_FACE_DETECT_MODE_OFF
 * @see #STATISTICS_FACE_DETECT_MODE_SIMPLE
 * @see #STATISTICS_FACE_DETECT_MODE_FULL
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> STATISTICS_FACE_DETECT_MODE;
static { STATISTICS_FACE_DETECT_MODE = null; }

/**
 * <p>List of <code>(x, y)</code> coordinates of hot/defective pixels on the sensor.</p>
 * <p>A coordinate <code>(x, y)</code> must lie between <code>(0, 0)</code>, and
 * <code>(width - 1, height - 1)</code> (inclusive), which are the top-left and
 * bottom-right of the pixel array, respectively. The width and
 * height dimensions are given in {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PIXEL_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PIXEL_ARRAY_SIZE}.
 * This may include hot pixels that lie outside of the active array
 * bounds given by {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE}.</p>
 * <p><b>Range of valid values:</b><br></p>
 * <p>n &lt;= number of pixels on the sensor.
 * The <code>(x, y)</code> coordinates must be bounded by
 * {@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PIXEL_ARRAY_SIZE CameraCharacteristics#SENSOR_INFO_PIXEL_ARRAY_SIZE}.</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_PIXEL_ARRAY_SIZE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<android.graphics.Point[]> STATISTICS_HOT_PIXEL_MAP;
static { STATISTICS_HOT_PIXEL_MAP = null; }

/**
 * <p>Operating mode for hot pixel map generation.</p>
 * <p>If set to <code>true</code>, a hot pixel map is returned in {@link android.hardware.camera2.CaptureResult#STATISTICS_HOT_PIXEL_MAP CaptureResult#STATISTICS_HOT_PIXEL_MAP}.
 * If set to <code>false</code>, no hot pixel map will be returned.</p>
 * <p><b>Range of valid values:</b><br>
 * {@link android.hardware.camera2.CameraCharacteristics#STATISTICS_INFO_AVAILABLE_HOT_PIXEL_MAP_MODES CameraCharacteristics#STATISTICS_INFO_AVAILABLE_HOT_PIXEL_MAP_MODES}</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 *
 * @see android.hardware.camera2.CaptureResult#STATISTICS_HOT_PIXEL_MAP
 * @see android.hardware.camera2.CameraCharacteristics#STATISTICS_INFO_AVAILABLE_HOT_PIXEL_MAP_MODES
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Boolean> STATISTICS_HOT_PIXEL_MAP_MODE;
static { STATISTICS_HOT_PIXEL_MAP_MODE = null; }

/**
 * <p>The shading map is a low-resolution floating-point map
 * that lists the coefficients used to correct for vignetting, for each
 * Bayer color channel.</p>
 * <p>The map provided here is the same map that is used by the camera device to
 * correct both color shading and vignetting for output non-RAW images.</p>
 * <p>When there is no lens shading correction applied to RAW
 * output images ({@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_LENS_SHADING_APPLIED CameraCharacteristics#SENSOR_INFO_LENS_SHADING_APPLIED} <code>==</code>
 * false), this map is the complete lens shading correction
 * map; when there is some lens shading correction applied to
 * the RAW output image ({@link android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_LENS_SHADING_APPLIED CameraCharacteristics#SENSOR_INFO_LENS_SHADING_APPLIED}<code>==</code> true), this map reports the remaining lens shading
 * correction map that needs to be applied to get shading
 * corrected images that match the camera device's output for
 * non-RAW formats.</p>
 * <p>For a complete shading correction map, the least shaded
 * section of the image will have a gain factor of 1; all
 * other sections will have gains above 1.</p>
 * <p>When {@link android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_MODE CaptureRequest#COLOR_CORRECTION_MODE} = TRANSFORM_MATRIX, the map
 * will take into account the colorCorrection settings.</p>
 * <p>The shading map is for the entire active pixel array, and is not
 * affected by the crop region specified in the request. Each shading map
 * entry is the value of the shading compensation map over a specific
 * pixel on the sensor.  Specifically, with a (N x M) resolution shading
 * map, and an active pixel array size (W x H), shading map entry
 * (x,y) ϵ (0 ... N-1, 0 ... M-1) is the value of the shading map at
 * pixel ( ((W-1)/(N-1)) * x, ((H-1)/(M-1)) * y) for the four color channels.
 * The map is assumed to be bilinearly interpolated between the sample points.</p>
 * <p>The channel order is [R, Geven, Godd, B], where Geven is the green
 * channel for the even rows of a Bayer pattern, and Godd is the odd rows.
 * The shading map is stored in a fully interleaved format.</p>
 * <p>The shading map will generally have on the order of 30-40 rows and columns,
 * and will be smaller than 64x64.</p>
 * <p>As an example, given a very small map defined as:</p>
 * <pre><code>width,height = [ 4, 3 ]
 * values =
 * [ 1.3, 1.2, 1.15, 1.2,  1.2, 1.2, 1.15, 1.2,
 *     1.1, 1.2, 1.2, 1.2,  1.3, 1.2, 1.3, 1.3,
 *   1.2, 1.2, 1.25, 1.1,  1.1, 1.1, 1.1, 1.0,
 *     1.0, 1.0, 1.0, 1.0,  1.2, 1.3, 1.25, 1.2,
 *   1.3, 1.2, 1.2, 1.3,   1.2, 1.15, 1.1, 1.2,
 *     1.2, 1.1, 1.0, 1.2,  1.3, 1.15, 1.2, 1.3 ]
 * </code></pre>
 * <p>The low-resolution scaling map images for each channel are
 * (displayed using nearest-neighbor interpolation):</p>
 * <p><img alt="Red lens shading map" src="/reference/images/camera2/metadata/android.statistics.lensShadingMap/red_shading.png" />
 * <img alt="Green (even rows) lens shading map" src="/reference/images/camera2/metadata/android.statistics.lensShadingMap/green_e_shading.png" />
 * <img alt="Green (odd rows) lens shading map" src="/reference/images/camera2/metadata/android.statistics.lensShadingMap/green_o_shading.png" />
 * <img alt="Blue lens shading map" src="/reference/images/camera2/metadata/android.statistics.lensShadingMap/blue_shading.png" /></p>
 * <p>As a visualization only, inverting the full-color map to recover an
 * image of a gray wall (using bicubic interpolation for visual quality) as captured by the sensor gives:</p>
 * <p><img alt="Image of a uniform white wall (inverse shading map)" src="/reference/images/camera2/metadata/android.statistics.lensShadingMap/inv_shading.png" /></p>
 * <p>For a MONOCHROME camera, all of the 2x2 channels must have the same values. An example
 * shading map for such a camera is defined as:</p>
 * <pre><code>android.lens.info.shadingMapSize = [ 4, 3 ]
 * android.statistics.lensShadingMap =
 * [ 1.3, 1.3, 1.3, 1.3,  1.2, 1.2, 1.2, 1.2,
 *     1.1, 1.1, 1.1, 1.1,  1.3, 1.3, 1.3, 1.3,
 *   1.2, 1.2, 1.2, 1.2,  1.1, 1.1, 1.1, 1.1,
 *     1.0, 1.0, 1.0, 1.0,  1.2, 1.2, 1.2, 1.2,
 *   1.3, 1.3, 1.3, 1.3,   1.2, 1.2, 1.2, 1.2,
 *     1.2, 1.2, 1.2, 1.2,  1.3, 1.3, 1.3, 1.3 ]
 * </code></pre>
 * <p><b>Range of valid values:</b><br>
 * Each gain factor is &gt;= 1</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Full capability</b> -
 * Present on all camera devices that report being {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CaptureRequest#COLOR_CORRECTION_MODE
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see android.hardware.camera2.CameraCharacteristics#SENSOR_INFO_LENS_SHADING_APPLIED
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<android.hardware.camera2.params.LensShadingMap> STATISTICS_LENS_SHADING_CORRECTION_MAP;
static { STATISTICS_LENS_SHADING_CORRECTION_MAP = null; }

/**
 * <p>Whether the camera device will output the lens
 * shading map in output result metadata.</p>
 * <p>When set to ON,
 * android.statistics.lensShadingMap will be provided in
 * the output result metadata.</p>
 * <p>ON is always supported on devices with the RAW capability.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #STATISTICS_LENS_SHADING_MAP_MODE_OFF OFF}</li>
 *   <li>{@link #STATISTICS_LENS_SHADING_MAP_MODE_ON ON}</li>
 * </ul></p>
 * <p><b>Available values for this device:</b><br>
 * {@link android.hardware.camera2.CameraCharacteristics#STATISTICS_INFO_AVAILABLE_LENS_SHADING_MAP_MODES CameraCharacteristics#STATISTICS_INFO_AVAILABLE_LENS_SHADING_MAP_MODES}</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Full capability</b> -
 * Present on all camera devices that report being {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see android.hardware.camera2.CameraCharacteristics#STATISTICS_INFO_AVAILABLE_LENS_SHADING_MAP_MODES
 * @see #STATISTICS_LENS_SHADING_MAP_MODE_OFF
 * @see #STATISTICS_LENS_SHADING_MAP_MODE_ON
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> STATISTICS_LENS_SHADING_MAP_MODE;
static { STATISTICS_LENS_SHADING_MAP_MODE = null; }

/**
 * <p>A control for selecting whether optical stabilization (OIS) position
 * information is included in output result metadata.</p>
 * <p>Since optical image stabilization generally involves motion much faster than the duration
 * of individualq image exposure, multiple OIS samples can be included for a single capture
 * result. For example, if the OIS reporting operates at 200 Hz, a typical camera operating
 * at 30fps may have 6-7 OIS samples per capture result. This information can be combined
 * with the rolling shutter skew to account for lens motion during image exposure in
 * post-processing algorithms.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #STATISTICS_OIS_DATA_MODE_OFF OFF}</li>
 *   <li>{@link #STATISTICS_OIS_DATA_MODE_ON ON}</li>
 * </ul></p>
 * <p><b>Available values for this device:</b><br>
 * {@link android.hardware.camera2.CameraCharacteristics#STATISTICS_INFO_AVAILABLE_OIS_DATA_MODES CameraCharacteristics#STATISTICS_INFO_AVAILABLE_OIS_DATA_MODES}</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#STATISTICS_INFO_AVAILABLE_OIS_DATA_MODES
 * @see #STATISTICS_OIS_DATA_MODE_OFF
 * @see #STATISTICS_OIS_DATA_MODE_ON
 * @apiSince 28
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> STATISTICS_OIS_DATA_MODE;
static { STATISTICS_OIS_DATA_MODE = null; }

/**
 * <p>An array of optical stabilization (OIS) position samples.</p>
 * <p>Each OIS sample contains the timestamp and the amount of shifts in x and y direction,
 * in pixels, of the OIS sample.</p>
 * <p>A positive value for a shift in x direction is a shift from left to right in the
 * pre-correction active array coordinate system. For example, if the optical center is
 * (1000, 500) in pre-correction active array coordinates, a shift of (3, 0) puts the new
 * optical center at (1003, 500).</p>
 * <p>A positive value for a shift in y direction is a shift from top to bottom in
 * pre-correction active array coordinate system. For example, if the optical center is
 * (1000, 500) in active array coordinates, a shift of (0, 5) puts the new optical center at
 * (1000, 505).</p>
 * <p>The OIS samples are not affected by whether lens distortion correction is enabled (on
 * supporting devices). They are always reported in pre-correction active array coordinates,
 * since the scaling of OIS shifts would depend on the specific spot on the sensor the shift
 * is needed.</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * @apiSince 28
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<android.hardware.camera2.params.OisSample[]> STATISTICS_OIS_SAMPLES;
static { STATISTICS_OIS_SAMPLES = null; }

/**
 * <p>The camera device estimated scene illumination lighting
 * frequency.</p>
 * <p>Many light sources, such as most fluorescent lights, flicker at a rate
 * that depends on the local utility power standards. This flicker must be
 * accounted for by auto-exposure routines to avoid artifacts in captured images.
 * The camera device uses this entry to tell the application what the scene
 * illuminant frequency is.</p>
 * <p>When manual exposure control is enabled
 * (<code>{@link android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE CaptureRequest#CONTROL_AE_MODE} == OFF</code> or <code>{@link android.hardware.camera2.CaptureRequest#CONTROL_MODE CaptureRequest#CONTROL_MODE} ==
 * OFF</code>), the {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_ANTIBANDING_MODE CaptureRequest#CONTROL_AE_ANTIBANDING_MODE} doesn't perform
 * antibanding, and the application can ensure it selects
 * exposure times that do not cause banding issues by looking
 * into this metadata field. See
 * {@link android.hardware.camera2.CaptureRequest#CONTROL_AE_ANTIBANDING_MODE CaptureRequest#CONTROL_AE_ANTIBANDING_MODE} for more details.</p>
 * <p>Reports NONE if there doesn't appear to be flickering illumination.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #STATISTICS_SCENE_FLICKER_NONE NONE}</li>
 *   <li>{@link #STATISTICS_SCENE_FLICKER_50HZ 50HZ}</li>
 *   <li>{@link #STATISTICS_SCENE_FLICKER_60HZ 60HZ}</li>
 * </ul></p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Full capability</b> -
 * Present on all camera devices that report being {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AE_ANTIBANDING_MODE
 * @see android.hardware.camera2.CaptureRequest#CONTROL_AE_MODE
 * @see android.hardware.camera2.CaptureRequest#CONTROL_MODE
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see #STATISTICS_SCENE_FLICKER_NONE
 * @see #STATISTICS_SCENE_FLICKER_50HZ
 * @see #STATISTICS_SCENE_FLICKER_60HZ
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> STATISTICS_SCENE_FLICKER;
static { STATISTICS_SCENE_FLICKER = null; }

/**
 * <p>Tonemapping / contrast / gamma curve to use when {@link android.hardware.camera2.CaptureRequest#TONEMAP_MODE CaptureRequest#TONEMAP_MODE}
 * is CONTRAST_CURVE.</p>
 * <p>The tonemapCurve consist of three curves for each of red, green, and blue
 * channels respectively. The following example uses the red channel as an
 * example. The same logic applies to green and blue channel.
 * Each channel's curve is defined by an array of control points:</p>
 * <pre><code>curveRed =
 *   [ P0(in, out), P1(in, out), P2(in, out), P3(in, out), ..., PN(in, out) ]
 * 2 &lt;= N &lt;= {@link android.hardware.camera2.CameraCharacteristics#TONEMAP_MAX_CURVE_POINTS CameraCharacteristics#TONEMAP_MAX_CURVE_POINTS}</code></pre>
 * <p>These are sorted in order of increasing <code>Pin</code>; it is always
 * guaranteed that input values 0.0 and 1.0 are included in the list to
 * define a complete mapping. For input values between control points,
 * the camera device must linearly interpolate between the control
 * points.</p>
 * <p>Each curve can have an independent number of points, and the number
 * of points can be less than max (that is, the request doesn't have to
 * always provide a curve with number of points equivalent to
 * {@link android.hardware.camera2.CameraCharacteristics#TONEMAP_MAX_CURVE_POINTS CameraCharacteristics#TONEMAP_MAX_CURVE_POINTS}).</p>
 * <p>For devices with MONOCHROME capability, all three channels must have the same set of
 * control points.</p>
 * <p>A few examples, and their corresponding graphical mappings; these
 * only specify the red channel and the precision is limited to 4
 * digits, for conciseness.</p>
 * <p>Linear mapping:</p>
 * <pre><code>curveRed = [ (0, 0), (1.0, 1.0) ]
 * </code></pre>
 * <p><img alt="Linear mapping curve" src="/reference/images/camera2/metadata/android.tonemap.curveRed/linear_tonemap.png" /></p>
 * <p>Invert mapping:</p>
 * <pre><code>curveRed = [ (0, 1.0), (1.0, 0) ]
 * </code></pre>
 * <p><img alt="Inverting mapping curve" src="/reference/images/camera2/metadata/android.tonemap.curveRed/inverse_tonemap.png" /></p>
 * <p>Gamma 1/2.2 mapping, with 16 control points:</p>
 * <pre><code>curveRed = [
 *   (0.0000, 0.0000), (0.0667, 0.2920), (0.1333, 0.4002), (0.2000, 0.4812),
 *   (0.2667, 0.5484), (0.3333, 0.6069), (0.4000, 0.6594), (0.4667, 0.7072),
 *   (0.5333, 0.7515), (0.6000, 0.7928), (0.6667, 0.8317), (0.7333, 0.8685),
 *   (0.8000, 0.9035), (0.8667, 0.9370), (0.9333, 0.9691), (1.0000, 1.0000) ]
 * </code></pre>
 * <p><img alt="Gamma = 1/2.2 tonemapping curve" src="/reference/images/camera2/metadata/android.tonemap.curveRed/gamma_tonemap.png" /></p>
 * <p>Standard sRGB gamma mapping, per IEC 61966-2-1:1999, with 16 control points:</p>
 * <pre><code>curveRed = [
 *   (0.0000, 0.0000), (0.0667, 0.2864), (0.1333, 0.4007), (0.2000, 0.4845),
 *   (0.2667, 0.5532), (0.3333, 0.6125), (0.4000, 0.6652), (0.4667, 0.7130),
 *   (0.5333, 0.7569), (0.6000, 0.7977), (0.6667, 0.8360), (0.7333, 0.8721),
 *   (0.8000, 0.9063), (0.8667, 0.9389), (0.9333, 0.9701), (1.0000, 1.0000) ]
 * </code></pre>
 * <p><img alt="sRGB tonemapping curve" src="/reference/images/camera2/metadata/android.tonemap.curveRed/srgb_tonemap.png" /></p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Full capability</b> -
 * Present on all camera devices that report being {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see android.hardware.camera2.CameraCharacteristics#TONEMAP_MAX_CURVE_POINTS
 * @see android.hardware.camera2.CaptureRequest#TONEMAP_MODE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<android.hardware.camera2.params.TonemapCurve> TONEMAP_CURVE;
static { TONEMAP_CURVE = null; }

/**
 * <p>Tonemapping curve to use when {@link android.hardware.camera2.CaptureRequest#TONEMAP_MODE CaptureRequest#TONEMAP_MODE} is
 * GAMMA_VALUE</p>
 * <p>The tonemap curve will be defined the following formula:
 * * OUT = pow(IN, 1.0 / gamma)
 * where IN and OUT is the input pixel value scaled to range [0.0, 1.0],
 * pow is the power function and gamma is the gamma value specified by this
 * key.</p>
 * <p>The same curve will be applied to all color channels. The camera device
 * may clip the input gamma value to its supported range. The actual applied
 * value will be returned in capture result.</p>
 * <p>The valid range of gamma value varies on different devices, but values
 * within [1.0, 5.0] are guaranteed not to be clipped.</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#TONEMAP_MODE
 * @apiSince 23
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Float> TONEMAP_GAMMA;
static { TONEMAP_GAMMA = null; }

/**
 * <p>High-level global contrast/gamma/tonemapping control.</p>
 * <p>When switching to an application-defined contrast curve by setting
 * {@link android.hardware.camera2.CaptureRequest#TONEMAP_MODE CaptureRequest#TONEMAP_MODE} to CONTRAST_CURVE, the curve is defined
 * per-channel with a set of <code>(in, out)</code> points that specify the
 * mapping from input high-bit-depth pixel value to the output
 * low-bit-depth value.  Since the actual pixel ranges of both input
 * and output may change depending on the camera pipeline, the values
 * are specified by normalized floating-point numbers.</p>
 * <p>More-complex color mapping operations such as 3D color look-up
 * tables, selective chroma enhancement, or other non-linear color
 * transforms will be disabled when {@link android.hardware.camera2.CaptureRequest#TONEMAP_MODE CaptureRequest#TONEMAP_MODE} is
 * CONTRAST_CURVE.</p>
 * <p>When using either FAST or HIGH_QUALITY, the camera device will
 * emit its own tonemap curve in {@link android.hardware.camera2.CaptureRequest#TONEMAP_CURVE CaptureRequest#TONEMAP_CURVE}.
 * These values are always available, and as close as possible to the
 * actually used nonlinear/nonglobal transforms.</p>
 * <p>If a request is sent with CONTRAST_CURVE with the camera device's
 * provided curve in FAST or HIGH_QUALITY, the image's tonemap will be
 * roughly the same.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #TONEMAP_MODE_CONTRAST_CURVE CONTRAST_CURVE}</li>
 *   <li>{@link #TONEMAP_MODE_FAST FAST}</li>
 *   <li>{@link #TONEMAP_MODE_HIGH_QUALITY HIGH_QUALITY}</li>
 *   <li>{@link #TONEMAP_MODE_GAMMA_VALUE GAMMA_VALUE}</li>
 *   <li>{@link #TONEMAP_MODE_PRESET_CURVE PRESET_CURVE}</li>
 * </ul></p>
 * <p><b>Available values for this device:</b><br>
 * {@link android.hardware.camera2.CameraCharacteristics#TONEMAP_AVAILABLE_TONE_MAP_MODES CameraCharacteristics#TONEMAP_AVAILABLE_TONE_MAP_MODES}</p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 * <p><b>Full capability</b> -
 * Present on all camera devices that report being {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL_FULL} devices in the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL} key</p>
 *
 * @see android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL
 * @see android.hardware.camera2.CameraCharacteristics#TONEMAP_AVAILABLE_TONE_MAP_MODES
 * @see android.hardware.camera2.CaptureRequest#TONEMAP_CURVE
 * @see android.hardware.camera2.CaptureRequest#TONEMAP_MODE
 * @see #TONEMAP_MODE_CONTRAST_CURVE
 * @see #TONEMAP_MODE_FAST
 * @see #TONEMAP_MODE_HIGH_QUALITY
 * @see #TONEMAP_MODE_GAMMA_VALUE
 * @see #TONEMAP_MODE_PRESET_CURVE
 * @apiSince 21
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> TONEMAP_MODE;
static { TONEMAP_MODE = null; }

/**
 * <p>Tonemapping curve to use when {@link android.hardware.camera2.CaptureRequest#TONEMAP_MODE CaptureRequest#TONEMAP_MODE} is
 * PRESET_CURVE</p>
 * <p>The tonemap curve will be defined by specified standard.</p>
 * <p>sRGB (approximated by 16 control points):</p>
 * <p><img alt="sRGB tonemapping curve" src="/reference/images/camera2/metadata/android.tonemap.curveRed/srgb_tonemap.png" /></p>
 * <p>Rec. 709 (approximated by 16 control points):</p>
 * <p><img alt="Rec. 709 tonemapping curve" src="/reference/images/camera2/metadata/android.tonemap.curveRed/rec709_tonemap.png" /></p>
 * <p>Note that above figures show a 16 control points approximation of preset
 * curves. Camera devices may apply a different approximation to the curve.</p>
 * <p><b>Possible values:</b>
 * <ul>
 *   <li>{@link #TONEMAP_PRESET_CURVE_SRGB SRGB}</li>
 *   <li>{@link #TONEMAP_PRESET_CURVE_REC709 REC709}</li>
 * </ul></p>
 * <p><b>Optional</b> - The value for this key may be {@code null} on some devices.</p>
 *
 * @see android.hardware.camera2.CaptureRequest#TONEMAP_MODE
 * @see #TONEMAP_PRESET_CURVE_SRGB
 * @see #TONEMAP_PRESET_CURVE_REC709
 * @apiSince 23
 */

@androidx.annotation.NonNull public static final android.hardware.camera2.CaptureResult.Key<java.lang.Integer> TONEMAP_PRESET_CURVE;
static { TONEMAP_PRESET_CURVE = null; }
/**
 * A {@code Key} is used to do capture result field lookups with
 * {@link android.hardware.camera2.CaptureResult#get CaptureResult#get}.
 *
 * <p>For example, to get the timestamp corresponding to the exposure of the first row:
 * <code><pre>
 * long timestamp = captureResult.get(CaptureResult.SENSOR_TIMESTAMP);
 * </pre></code>
 * </p>
 *
 * <p>To enumerate over all possible keys for {@link android.hardware.camera2.CaptureResult CaptureResult}, see
 * {@link android.hardware.camera2.CameraCharacteristics#getAvailableCaptureResultKeys CameraCharacteristics#getAvailableCaptureResultKeys}.</p>
 *
 * @see android.hardware.camera2.CaptureResult#get
 * @see android.hardware.camera2.CameraCharacteristics#getAvailableCaptureResultKeys
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Key<T> {

/**
 * Construct a new Key with a given name and type.
 *
 * <p>Normally, applications should use the existing Key definitions in
 * {@link android.hardware.camera2.CaptureResult CaptureResult}, and not need to construct their own Key objects. However, they may
 * be useful for testing purposes and for defining custom capture result fields.</p>
 
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
 * Return this {@link android.hardware.camera2.CaptureResult.Key Key} as a string representation.
 *
 * <p>{@code "CaptureResult.Key(%s)"}, where {@code %s} represents
 * the name of this key as returned by {@link #getName}.</p>
 *
 * @return string representation of {@link android.hardware.camera2.CaptureResult.Key Key}
 
 * This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

}
