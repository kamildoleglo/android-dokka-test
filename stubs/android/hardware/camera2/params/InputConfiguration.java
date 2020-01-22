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


package android.hardware.camera2.params;


/**
 * Immutable class to store an input configuration that is used to create a reprocessable capture
 * session.
 *
 * @see android.hardware.camera2.CameraDevice#createReprocessableCaptureSession
 * @see android.hardware.camera2.CameraCharacteristics#SCALER_STREAM_CONFIGURATION_MAP
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class InputConfiguration {

/**
 * Create an input configration with the width, height, and user-defined format.
 *
 * <p>Images of an user-defined format are accessible by applications. Use
 * {@link android.hardware.camera2.CameraCharacteristics#SCALER_STREAM_CONFIGURATION_MAP}
 * to query supported input formats</p>
 *
 * @param width Width of the input buffers.
 * @param height Height of the input buffers.
 * @param format Format of the input buffers. One of ImageFormat or PixelFormat constants.
 *
 * @see android.graphics.ImageFormat
 * @see android.graphics.PixelFormat
 * @see android.hardware.camera2.CameraCharacteristics#SCALER_STREAM_CONFIGURATION_MAP
 * @apiSince 23
 */

public InputConfiguration(int width, int height, int format) { throw new RuntimeException("Stub!"); }

/**
 * Get the width of this input configration.
 *
 * @return width of this input configuration.
 * @apiSince 23
 */

public int getWidth() { throw new RuntimeException("Stub!"); }

/**
 * Get the height of this input configration.
 *
 * @return height of this input configuration.
 * @apiSince 23
 */

public int getHeight() { throw new RuntimeException("Stub!"); }

/**
 * Get the format of this input configration.
 *
 * @return format of this input configuration.
 * @apiSince 23
 */

public int getFormat() { throw new RuntimeException("Stub!"); }

/**
 * Check if this InputConfiguration is equal to another InputConfiguration.
 *
 * <p>Two input configurations are equal if and only if they have the same widths, heights, and
 * formats.</p>
 *
 * @param obj the object to compare this instance with.
 *
 * @return {@code true} if the objects were equal, {@code false} otherwise.
 * @apiSince 23
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 23
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Return this {@link android.hardware.camera2.params.InputConfiguration InputConfiguration} as a string representation.
 *
 * <p> {@code "InputConfiguration(w:%d, h:%d, format:%d)"}, where {@code %d} represents
 * the width, height, and format, respectively.</p>
 *
 * @return string representation of {@link android.hardware.camera2.params.InputConfiguration InputConfiguration}
 * @apiSince 23
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

