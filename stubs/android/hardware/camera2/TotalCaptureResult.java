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


package android.hardware.camera2;


/**
 * <p>The total assembled results of a single image capture from the image sensor.</p>
 *
 * <p>Contains the final configuration for the capture hardware (sensor, lens,
 * flash), the processing pipeline, the control algorithms, and the output
 * buffers.</p>
 *
 * <p>A {@code TotalCaptureResult} is produced by a {@link android.hardware.camera2.CameraDevice CameraDevice} after processing a
 * {@link android.hardware.camera2.CaptureRequest CaptureRequest}. All properties listed for capture requests can also
 * be queried on the capture result, to determine the final values used for
 * capture. The result also includes additional metadata about the state of the
 * camera device during the capture.</p>
 *
 * <p>All properties returned by {@link android.hardware.camera2.CameraCharacteristics#getAvailableCaptureResultKeys() CameraCharacteristics#getAvailableCaptureResultKeys()}
 * are available (that is {@link android.hardware.camera2.CaptureResult#get CaptureResult#get} will return non-{@code null}, if and only if
 * that key that was enabled by the request. A few keys such as
 * {@link android.hardware.camera2.CaptureResult#STATISTICS_FACES CaptureResult#STATISTICS_FACES} are disabled by default unless enabled with a switch (such
 * as {@link android.hardware.camera2.CaptureRequest#STATISTICS_FACE_DETECT_MODE CaptureRequest#STATISTICS_FACE_DETECT_MODE}). Refer to each key documentation on
 * a case-by-case basis.</p>
 *
 * <p>For a logical multi-camera device, if the CaptureRequest contains a surface for an underlying
 * physical camera, the corresponding {@link android.hardware.camera2.TotalCaptureResult TotalCaptureResult} object will include the metadata
 * for that physical camera. And the mapping between the physical camera id and result metadata
 * can be accessed via {@link #getPhysicalCameraResults}. If all requested surfaces are for the
 * logical camera, no metadata for physical camera will be included.</p>
 *
 * <p>{@link android.hardware.camera2.TotalCaptureResult TotalCaptureResult} objects are immutable.</p>
 *
 * @see android.hardware.camera2.CameraCaptureSession.CaptureCallback#onCaptureCompleted
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class TotalCaptureResult extends android.hardware.camera2.CaptureResult {

TotalCaptureResult() { throw new RuntimeException("Stub!"); }

/**
 * Get the read-only list of partial results that compose this total result.
 *
 * <p>The list is returned is unmodifiable; attempting to modify it will result in a
 * {@code UnsupportedOperationException} being thrown.</p>
 *
 * <p>The list size will be inclusive between {@code 0} and
 * {@link android.hardware.camera2.CameraCharacteristics#REQUEST_PARTIAL_RESULT_COUNT CameraCharacteristics#REQUEST_PARTIAL_RESULT_COUNT}, with elements in ascending order
 * of when {@link android.hardware.camera2.CameraCaptureSession.CaptureCallback#onCaptureProgressed CameraCaptureSession.CaptureCallback#onCaptureProgressed} was invoked.</p>
 *
 * @return unmodifiable list of partial results
 
 * This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.util.List<android.hardware.camera2.CaptureResult> getPartialResults() { throw new RuntimeException("Stub!"); }

/**
 * Get the map between physical camera ids and their capture result metadata
 *
 * <p>This function can be called for logical multi-camera devices, which are devices that have
 * REQUEST_AVAILABLE_CAPABILITIES_LOGICAL_MULTI_CAMERA capability and calls to {@link android.hardware.camera2.CameraCharacteristics#getPhysicalCameraIds CameraCharacteristics#getPhysicalCameraIds} return a non-empty set of physical devices that
 * are backing the logical camera.</p>
 *
 * <p>If one or more streams from the underlying physical cameras were requested by the
 * corresponding capture request, this function returns the result metadata for those physical
 * cameras. Otherwise, an empty map is returned.</p>
 
 * @return unmodifiable map between physical camera ids and their capture result metadata
 * @apiSince 28
 */

public java.util.Map<java.lang.String,android.hardware.camera2.CaptureResult> getPhysicalCameraResults() { throw new RuntimeException("Stub!"); }
}

