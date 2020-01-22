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
 * The CameraProfile class is used to retrieve the pre-defined still image
 * capture (jpeg) quality levels (0-100) used for low, medium, and high
 * quality settings in the Camera application.
 *
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CameraProfile {

public CameraProfile() { throw new RuntimeException("Stub!"); }

/**
 * Returns a pre-defined still image capture (jpeg) quality level
 * used for the given quality level in the Camera application for
 * the first back-facing camera on the device. If the device has no
 * back-facing camera, this returns 0.
 *
 * @param quality The target quality level
 * @apiSince 8
 */

public static int getJpegEncodingQualityParameter(int quality) { throw new RuntimeException("Stub!"); }

/**
 * Returns a pre-defined still image capture (jpeg) quality level
 * used for the given quality level in the Camera application for
 * the specified camera.
 *
 * @param cameraId The id of the camera
 * @param quality The target quality level
 * @apiSince 9
 */

public static int getJpegEncodingQualityParameter(int cameraId, int quality) { throw new RuntimeException("Stub!"); }

/** @apiSince 8 */

public static final int QUALITY_HIGH = 2; // 0x2

/**
 * Define three quality levels for JPEG image encoding.
 * @apiSince 8
 */

public static final int QUALITY_LOW = 0; // 0x0

/** @apiSince 8 */

public static final int QUALITY_MEDIUM = 1; // 0x1
}

