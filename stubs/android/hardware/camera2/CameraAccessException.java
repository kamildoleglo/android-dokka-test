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


/**
 * <p><code>CameraAccessException</code> is thrown if a camera device could not
 * be queried or opened by the {@link android.hardware.camera2.CameraManager CameraManager}, or if the connection to an
 * opened {@link android.hardware.camera2.CameraDevice CameraDevice} is no longer valid.</p>
 *
 * @see android.hardware.camera2.CameraManager
 * @see android.hardware.camera2.CameraDevice
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CameraAccessException extends android.util.AndroidException {

/**
 * @param problem Value is {@link android.hardware.camera2.CameraAccessException#CAMERA_IN_USE}, {@link android.hardware.camera2.CameraAccessException#MAX_CAMERAS_IN_USE}, {@link android.hardware.camera2.CameraAccessException#CAMERA_DISABLED}, {@link android.hardware.camera2.CameraAccessException#CAMERA_DISCONNECTED}, or {@link android.hardware.camera2.CameraAccessException#CAMERA_ERROR}
 * @apiSince 21
 */

public CameraAccessException(int problem) { throw new RuntimeException("Stub!"); }

/**
 * @param problem Value is {@link android.hardware.camera2.CameraAccessException#CAMERA_IN_USE}, {@link android.hardware.camera2.CameraAccessException#MAX_CAMERAS_IN_USE}, {@link android.hardware.camera2.CameraAccessException#CAMERA_DISABLED}, {@link android.hardware.camera2.CameraAccessException#CAMERA_DISCONNECTED}, or {@link android.hardware.camera2.CameraAccessException#CAMERA_ERROR}
 * @apiSince 21
 */

public CameraAccessException(int problem, java.lang.String message) { throw new RuntimeException("Stub!"); }

/**
 * @param problem Value is {@link android.hardware.camera2.CameraAccessException#CAMERA_IN_USE}, {@link android.hardware.camera2.CameraAccessException#MAX_CAMERAS_IN_USE}, {@link android.hardware.camera2.CameraAccessException#CAMERA_DISABLED}, {@link android.hardware.camera2.CameraAccessException#CAMERA_DISCONNECTED}, or {@link android.hardware.camera2.CameraAccessException#CAMERA_ERROR}
 * @apiSince 21
 */

public CameraAccessException(int problem, java.lang.String message, java.lang.Throwable cause) { throw new RuntimeException("Stub!"); }

/**
 * @param problem Value is {@link android.hardware.camera2.CameraAccessException#CAMERA_IN_USE}, {@link android.hardware.camera2.CameraAccessException#MAX_CAMERAS_IN_USE}, {@link android.hardware.camera2.CameraAccessException#CAMERA_DISABLED}, {@link android.hardware.camera2.CameraAccessException#CAMERA_DISCONNECTED}, or {@link android.hardware.camera2.CameraAccessException#CAMERA_ERROR}
 * @apiSince 21
 */

public CameraAccessException(int problem, java.lang.Throwable cause) { throw new RuntimeException("Stub!"); }

/**
 * The reason for the failure to access the camera.
 *
 * @see #CAMERA_DISABLED
 * @see #CAMERA_DISCONNECTED
 * @see #CAMERA_ERROR
 
 * @return Value is {@link android.hardware.camera2.CameraAccessException#CAMERA_IN_USE}, {@link android.hardware.camera2.CameraAccessException#MAX_CAMERAS_IN_USE}, {@link android.hardware.camera2.CameraAccessException#CAMERA_DISABLED}, {@link android.hardware.camera2.CameraAccessException#CAMERA_DISCONNECTED}, or {@link android.hardware.camera2.CameraAccessException#CAMERA_ERROR}
 * @apiSince 21
 */

public final int getReason() { throw new RuntimeException("Stub!"); }

/**
 * The camera is disabled due to a device policy, and cannot be opened.
 *
 * @see android.app.admin.DevicePolicyManager#setCameraDisabled(android.content.ComponentName, boolean)
 * @apiSince 21
 */

public static final int CAMERA_DISABLED = 1; // 0x1

/**
 * The camera device is removable and has been disconnected from the Android
 * device, or the camera id used with {@link android.hardware.camera2.CameraManager#openCamera}
 * is no longer valid, or the camera service has shut down the connection due to a
 * higher-priority access request for the camera device.
 * @apiSince 21
 */

public static final int CAMERA_DISCONNECTED = 2; // 0x2

/**
 * The camera device is currently in the error state.
 *
 * <p>The camera has failed to open or has failed at a later time
 * as a result of some non-user interaction. Refer to
 * {@link android.hardware.camera2.CameraDevice.StateCallback#onError CameraDevice.StateCallback#onError} for the exact
 * nature of the error.</p>
 *
 * <p>No further calls to the camera will succeed. Clean up
 * the camera with {@link android.hardware.camera2.CameraDevice#close CameraDevice#close} and try
 * handling the error in order to successfully re-open the camera.
 * </p>
 *
 * @apiSince 21
 */

public static final int CAMERA_ERROR = 3; // 0x3

/**
 * The camera device is in use already.
 * @apiSince 23
 */

public static final int CAMERA_IN_USE = 4; // 0x4

/**
 * The system-wide limit for number of open cameras or camera resources has
 * been reached, and more camera devices cannot be opened or torch mode
 * cannot be turned on until previous instances are closed.
 * @apiSince 23
 */

public static final int MAX_CAMERAS_IN_USE = 5; // 0x5
}

