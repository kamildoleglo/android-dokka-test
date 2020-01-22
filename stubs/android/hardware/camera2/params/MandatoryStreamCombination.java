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
import android.hardware.camera2.CameraCharacteristics;
import android.graphics.ImageFormat;

/**
 * Immutable class to store the available mandatory stream combination.
 *
 * <p>A mandatory stream combination refers to a specific entry in the documented sets of
 * required stream {@link android.hardware.camera2.CameraDevice#createCaptureSession CameraDevice#createCaptureSession}.
 * These combinations of streams are required to be supported by the camera device.
 *
 * <p>The list of stream combinations is available by invoking
 * {@link android.hardware.camera2.CameraCharacteristics#get CameraCharacteristics#get} and passing key
 * {@link android.hardware.camera2.CameraCharacteristics#SCALER_MANDATORY_STREAM_COMBINATIONS}.</p>
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MandatoryStreamCombination {

MandatoryStreamCombination() { throw new RuntimeException("Stub!"); }

/**
 * Get the mandatory stream combination description.
 *
 * @return CharSequence with the mandatory combination description.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.lang.CharSequence getDescription() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the mandatory stream combination is reprocessable. Reprocessable is defined
 * as a stream combination that contains one input stream
 * ({@link android.hardware.camera2.params.MandatoryStreamCombination.MandatoryStreamInformation#isInput MandatoryStreamInformation#isInput} return true).
 *
 * @return {@code true} in case the mandatory stream combination contains an input,
 *         {@code false} otherwise.
 * @apiSince 29
 */

public boolean isReprocessable() { throw new RuntimeException("Stub!"); }

/**
 * Get information about each stream in the mandatory combination.
 *
 * @return Non-modifiable list of stream information.
 *
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.util.List<android.hardware.camera2.params.MandatoryStreamCombination.MandatoryStreamInformation> getStreamsInformation() { throw new RuntimeException("Stub!"); }

/**
 * Check if this {@link android.hardware.camera2.params.MandatoryStreamCombination MandatoryStreamCombination} is equal to another
 * {@link android.hardware.camera2.params.MandatoryStreamCombination MandatoryStreamCombination}.
 *
 * <p>Two vectors are only equal if and only if each of the respective elements is equal.</p>
 *
 * @return {@code true} if the objects were equal, {@code false} otherwise
 * @apiSince 29
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 29
 */

public int hashCode() { throw new RuntimeException("Stub!"); }
/**
 * Immutable class to store available mandatory stream information.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class MandatoryStreamInformation {

MandatoryStreamInformation() { throw new RuntimeException("Stub!"); }

/**
 * Confirms whether or not this is an input stream.
 * @return true in case the stream is input, false otherwise.
 * @apiSince 29
 */

public boolean isInput() { throw new RuntimeException("Stub!"); }

/**
 * Return the list of available sizes for this mandatory stream.
 *
 * <p>Per documented {@link android.hardware.camera2.CameraDevice#createCaptureSession CameraDevice#createCaptureSession} the largest
 * resolution in the result will be tested and guaranteed to work. If clients want to use
 * smaller sizes, then the resulting
 * {@link android.hardware.camera2.params.SessionConfiguration session configuration} can
 * be tested either by calling {@link android.hardware.camera2.CameraDevice#createCaptureSession CameraDevice#createCaptureSession} or
 * {@link android.hardware.camera2.CameraDevice#isSessionConfigurationSupported CameraDevice#isSessionConfigurationSupported}.
 *
 * @return non-modifiable ascending list of available sizes.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public java.util.List<android.util.Size> getAvailableSizes() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the mandatory stream {@code format}.
 *
 * @return integer format.
 
 * Value is {@link android.graphics.ImageFormat#UNKNOWN}, {@link android.graphics.ImageFormat#RGB_565}, {@link android.graphics.ImageFormat#YV12}, {@link android.graphics.ImageFormat#Y8}, android.graphics.ImageFormat.Y16, {@link android.graphics.ImageFormat#NV16}, {@link android.graphics.ImageFormat#NV21}, {@link android.graphics.ImageFormat#YUY2}, {@link android.graphics.ImageFormat#JPEG}, {@link android.graphics.ImageFormat#DEPTH_JPEG}, {@link android.graphics.ImageFormat#YUV_420_888}, {@link android.graphics.ImageFormat#YUV_422_888}, {@link android.graphics.ImageFormat#YUV_444_888}, {@link android.graphics.ImageFormat#FLEX_RGB_888}, {@link android.graphics.ImageFormat#FLEX_RGBA_8888}, {@link android.graphics.ImageFormat#RAW_SENSOR}, {@link android.graphics.ImageFormat#RAW_PRIVATE}, {@link android.graphics.ImageFormat#RAW10}, {@link android.graphics.ImageFormat#RAW12}, {@link android.graphics.ImageFormat#DEPTH16}, {@link android.graphics.ImageFormat#DEPTH_POINT_CLOUD}, android.graphics.ImageFormat.RAW_DEPTH, {@link android.graphics.ImageFormat#PRIVATE}, or {@link android.graphics.ImageFormat#HEIC}
 * @apiSince 29
 */

public int getFormat() { throw new RuntimeException("Stub!"); }

/**
 * Check if this {@link android.hardware.camera2.params.MandatoryStreamCombination.MandatoryStreamInformation MandatoryStreamInformation} is equal to another
 * {@link android.hardware.camera2.params.MandatoryStreamCombination.MandatoryStreamInformation MandatoryStreamInformation}.
 *
 * <p>Two vectors are only equal if and only if each of the respective elements is
 * equal.</p>
 *
 * @return {@code true} if the objects were equal, {@code false} otherwise
 * @apiSince 29
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 29
 */

public int hashCode() { throw new RuntimeException("Stub!"); }
}

}

