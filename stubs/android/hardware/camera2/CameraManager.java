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

import android.content.Context;
import android.os.Handler;
import java.util.concurrent.Executor;

/**
 * <p>A system service manager for detecting, characterizing, and connecting to
 * {@link android.hardware.camera2.CameraDevice CameraDevice}.</p>
 *
 * <p>For more details about communicating with camera devices, read the Camera
 * developer guide or the {@link android.hardware.camera2 camera2}
 * package documentation.</p>
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CameraManager {

CameraManager() { throw new RuntimeException("Stub!"); }

/**
 * Return the list of currently connected camera devices by identifier, including
 * cameras that may be in use by other camera API clients.
 *
 * <p>Non-removable cameras use integers starting at 0 for their
 * identifiers, while removable cameras have a unique identifier for each
 * individual device, even if they are the same model.</p>
 *
 * <p>This list doesn't contain physical cameras that can only be used as part of a logical
 * multi-camera device.</p>
 *
 * @return The list of currently connected camera devices.
 
 * This value will never be {@code null}.
 * @apiSince 21
 */

@androidx.annotation.NonNull
public java.lang.String[] getCameraIdList() throws android.hardware.camera2.CameraAccessException { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be notified about camera device availability.
 *
 * <p>Registering the same callback again will replace the handler with the
 * new one provided.</p>
 *
 * <p>The first time a callback is registered, it is immediately called
 * with the availability status of all currently known camera devices.</p>
 *
 * <p>{@link android.hardware.camera2.CameraManager.AvailabilityCallback#onCameraUnavailable(java.lang.String) AvailabilityCallback#onCameraUnavailable(String)} will be called whenever a camera
 * device is opened by any camera API client. As of API level 23, other camera API clients may
 * still be able to open such a camera device, evicting the existing client if they have higher
 * priority than the existing client of a camera device. See open() for more details.</p>
 *
 * <p>Since this callback will be registered with the camera service, remember to unregister it
 * once it is no longer needed; otherwise the callback will continue to receive events
 * indefinitely and it may prevent other resources from being released. Specifically, the
 * callbacks will be invoked independently of the general activity lifecycle and independently
 * of the state of individual CameraManager instances.</p>
 *
 * @param callback the new callback to send camera availability notices to
 * This value must never be {@code null}.
 * @param handler The handler on which the callback should be invoked, or {@code null} to use
 *             the current thread's {@link android.os.Looper looper}.
 *
 * This value may be {@code null}.
 * @throws java.lang.IllegalArgumentException if the handler is {@code null} but the current thread has
 *             no looper.
 * @apiSince 21
 */

public void registerAvailabilityCallback(@androidx.annotation.NonNull android.hardware.camera2.CameraManager.AvailabilityCallback callback, @androidx.annotation.Nullable android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be notified about camera device availability.
 *
 * <p>The behavior of this method matches that of
 * {@link #registerAvailabilityCallback(android.hardware.camera2.CameraManager.AvailabilityCallback,android.os.Handler)},
 * except that it uses {@link java.util.concurrent.Executor} as an argument
 * instead of {@link android.os.Handler}.</p>
 *
 * @param executor The executor which will be used to invoke the callback.
 * This value must never be {@code null}.
 * Callback and listener events are dispatched through this
 * {@link java.util.concurrent.Executor Executor}, providing an easy way to control which thread is
 * used. To dispatch events through the main thread of your
 * application, you can use {@link android.content.Context#getMainExecutor() Context#getMainExecutor()}. To
 * dispatch events through a shared thread pool, you can use
 * {@link android.os.AsyncTask#THREAD_POOL_EXECUTOR AsyncTask#THREAD_POOL_EXECUTOR}.
 * @param callback the new callback to send camera availability notices to
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if the executor is {@code null}.
 * @apiSince 28
 */

public void registerAvailabilityCallback(@androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull android.hardware.camera2.CameraManager.AvailabilityCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Remove a previously-added callback; the callback will no longer receive connection and
 * disconnection callbacks.
 *
 * <p>Removing a callback that isn't registered has no effect.</p>
 *
 * @param callback The callback to remove from the notification list
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public void unregisterAvailabilityCallback(@androidx.annotation.NonNull android.hardware.camera2.CameraManager.AvailabilityCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be notified about torch mode status.
 *
 * <p>Registering the same callback again will replace the handler with the
 * new one provided.</p>
 *
 * <p>The first time a callback is registered, it is immediately called
 * with the torch mode status of all currently known camera devices with a flash unit.</p>
 *
 * <p>Since this callback will be registered with the camera service, remember to unregister it
 * once it is no longer needed; otherwise the callback will continue to receive events
 * indefinitely and it may prevent other resources from being released. Specifically, the
 * callbacks will be invoked independently of the general activity lifecycle and independently
 * of the state of individual CameraManager instances.</p>
 *
 * @param callback The new callback to send torch mode status to
 * This value must never be {@code null}.
 * @param handler The handler on which the callback should be invoked, or {@code null} to use
 *             the current thread's {@link android.os.Looper looper}.
 *
 * This value may be {@code null}.
 * @throws java.lang.IllegalArgumentException if the handler is {@code null} but the current thread has
 *             no looper.
 * @apiSince 23
 */

public void registerTorchCallback(@androidx.annotation.NonNull android.hardware.camera2.CameraManager.TorchCallback callback, @androidx.annotation.Nullable android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be notified about torch mode status.
 *
 * <p>The behavior of this method matches that of
 * {@link #registerTorchCallback(android.hardware.camera2.CameraManager.TorchCallback,android.os.Handler)},
 * except that it uses {@link java.util.concurrent.Executor} as an argument
 * instead of {@link android.os.Handler}.</p>
 *
 * @param executor The executor which will be used to invoke the callback
 * This value must never be {@code null}.
 * Callback and listener events are dispatched through this
 * {@link java.util.concurrent.Executor Executor}, providing an easy way to control which thread is
 * used. To dispatch events through the main thread of your
 * application, you can use {@link android.content.Context#getMainExecutor() Context#getMainExecutor()}. To
 * dispatch events through a shared thread pool, you can use
 * {@link android.os.AsyncTask#THREAD_POOL_EXECUTOR AsyncTask#THREAD_POOL_EXECUTOR}.
 * @param callback The new callback to send torch mode status to
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if the executor is {@code null}.
 * @apiSince 28
 */

public void registerTorchCallback(@androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull android.hardware.camera2.CameraManager.TorchCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Remove a previously-added callback; the callback will no longer receive torch mode status
 * callbacks.
 *
 * <p>Removing a callback that isn't registered has no effect.</p>
 *
 * @param callback The callback to remove from the notification list
 
 * This value must never be {@code null}.
 * @apiSince 23
 */

public void unregisterTorchCallback(@androidx.annotation.NonNull android.hardware.camera2.CameraManager.TorchCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * <p>Query the capabilities of a camera device. These capabilities are
 * immutable for a given camera.</p>
 *
 * <p>From API level 29, this function can also be used to query the capabilities of physical
 * cameras that can only be used as part of logical multi-camera. These cameras cannot be
 * opened directly via {@link #openCamera}</p>
 *
 * @param cameraId The id of the camera device to query. This could be either a standalone
 * camera ID which can be directly opened by {@link #openCamera}, or a physical camera ID that
 * can only used as part of a logical multi-camera.
 * This value must never be {@code null}.
 * @return The properties of the given camera
 *
 * This value will never be {@code null}.
 * @throws java.lang.IllegalArgumentException if the cameraId does not match any
 *         known camera device.
 * @throws android.hardware.camera2.CameraAccessException if the camera device has been disconnected.
 *
 * @see #getCameraIdList
 * @see android.app.admin.DevicePolicyManager#setCameraDisabled
 * @apiSince 21
 */

@androidx.annotation.NonNull
public android.hardware.camera2.CameraCharacteristics getCameraCharacteristics(@androidx.annotation.NonNull java.lang.String cameraId) throws android.hardware.camera2.CameraAccessException { throw new RuntimeException("Stub!"); }

/**
 * Open a connection to a camera with the given ID.
 *
 * <p>Use {@link #getCameraIdList} to get the list of available camera
 * devices. Note that even if an id is listed, open may fail if the device
 * is disconnected between the calls to {@link #getCameraIdList} and
 * {@link #openCamera}, or if a higher-priority camera API client begins using the
 * camera device.</p>
 *
 * <p>As of API level 23, devices for which the
 * {@link android.hardware.camera2.CameraManager.AvailabilityCallback#onCameraUnavailable(java.lang.String) AvailabilityCallback#onCameraUnavailable(String)} callback has been called due to the
 * device being in use by a lower-priority, background camera API client can still potentially
 * be opened by calling this method when the calling camera API client has a higher priority
 * than the current camera API client using this device.  In general, if the top, foreground
 * activity is running within your application process, your process will be given the highest
 * priority when accessing the camera, and this method will succeed even if the camera device is
 * in use by another camera API client. Any lower-priority application that loses control of the
 * camera in this way will receive an
 * {@link android.hardware.camera2.CameraDevice.StateCallback#onDisconnected} callback.</p>
 *
 * <p>Once the camera is successfully opened, {@link android.hardware.camera2.CameraDevice.StateCallback#onOpened CameraDevice.StateCallback#onOpened} will
 * be invoked with the newly opened {@link android.hardware.camera2.CameraDevice CameraDevice}. The camera device can then be set up
 * for operation by calling {@link android.hardware.camera2.CameraDevice#createCaptureSession CameraDevice#createCaptureSession} and
 * {@link android.hardware.camera2.CameraDevice#createCaptureRequest CameraDevice#createCaptureRequest}</p>
 *
 * <!--
 * <p>Since the camera device will be opened asynchronously, any asynchronous operations done
 * on the returned CameraDevice instance will be queued up until the device startup has
 * completed and the callback's {@link android.hardware.camera2.CameraDevice.StateCallback#onOpened CameraDevice.StateCallback#onOpened} method is
 * called. The pending operations are then processed in order.</p>
 * -->
 * <p>If the camera becomes disconnected during initialization
 * after this function call returns,
 * {@link android.hardware.camera2.CameraDevice.StateCallback#onDisconnected CameraDevice.StateCallback#onDisconnected} with a
 * {@link android.hardware.camera2.CameraDevice CameraDevice} in the disconnected state (and
 * {@link android.hardware.camera2.CameraDevice.StateCallback#onOpened CameraDevice.StateCallback#onOpened} will be skipped).</p>
 *
 * <p>If opening the camera device fails, then the device callback's
 * {@link android.hardware.camera2.CameraDevice.StateCallback#onError CameraDevice.StateCallback#onError} method will be called, and subsequent
 * calls on the camera device will throw a {@link android.hardware.camera2.CameraAccessException CameraAccessException}.</p>
 *
 * <br>
 * Requires {@link android.Manifest.permission#CAMERA}
 * @param cameraId
 *             The unique identifier of the camera device to open
 * This value must never be {@code null}.
 * @param callback
 *             The callback which is invoked once the camera is opened
 * This value must never be {@code null}.
 * @param handler
 *             The handler on which the callback should be invoked, or
 *             {@code null} to use the current thread's {@link android.os.Looper looper}.
 *
 * This value may be {@code null}.
 * @throws android.hardware.camera2.CameraAccessException if the camera is disabled by device policy,
 * has been disconnected, or is being used by a higher-priority camera API client.
 *
 * @throws java.lang.IllegalArgumentException if cameraId or the callback was null,
 * or the cameraId does not match any currently or previously available
 * camera device returned by {@link #getCameraIdList}.
 *
 * @throws java.lang.SecurityException if the application does not have permission to
 * access the camera
 *
 * @see #getCameraIdList
 * @see android.app.admin.DevicePolicyManager#setCameraDisabled
 * @apiSince 21
 */

public void openCamera(@androidx.annotation.NonNull java.lang.String cameraId, @androidx.annotation.NonNull android.hardware.camera2.CameraDevice.StateCallback callback, @androidx.annotation.Nullable android.os.Handler handler) throws android.hardware.camera2.CameraAccessException { throw new RuntimeException("Stub!"); }

/**
 * Open a connection to a camera with the given ID.
 *
 * <p>The behavior of this method matches that of
 * {@link #openCamera(java.lang.String,StateCallback,android.os.Handler)}, except that it uses
 * {@link java.util.concurrent.Executor} as an argument instead of
 * {@link android.os.Handler}.</p>
 *
 * <br>
 * Requires {@link android.Manifest.permission#CAMERA}
 * @param cameraId
 *             The unique identifier of the camera device to open
 * This value must never be {@code null}.
 * @param executor
 *             The executor which will be used when invoking the callback.
 * This value must never be {@code null}.
 * Callback and listener events are dispatched through this
 * {@link java.util.concurrent.Executor Executor}, providing an easy way to control which thread is
 * used. To dispatch events through the main thread of your
 * application, you can use {@link android.content.Context#getMainExecutor() Context#getMainExecutor()}. To
 * dispatch events through a shared thread pool, you can use
 * {@link android.os.AsyncTask#THREAD_POOL_EXECUTOR AsyncTask#THREAD_POOL_EXECUTOR}.
 * @param callback
 *             The callback which is invoked once the camera is opened
 *
 * This value must never be {@code null}.
 * @throws android.hardware.camera2.CameraAccessException if the camera is disabled by device policy,
 * has been disconnected, or is being used by a higher-priority camera API client.
 *
 * @throws java.lang.IllegalArgumentException if cameraId, the callback or the executor was null,
 * or the cameraId does not match any currently or previously available
 * camera device.
 *
 * @throws java.lang.SecurityException if the application does not have permission to
 * access the camera
 *
 * @see #getCameraIdList
 * @see android.app.admin.DevicePolicyManager#setCameraDisabled
 * @apiSince 28
 */

public void openCamera(@androidx.annotation.NonNull java.lang.String cameraId, @androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull android.hardware.camera2.CameraDevice.StateCallback callback) throws android.hardware.camera2.CameraAccessException { throw new RuntimeException("Stub!"); }

/**
 * Set the flash unit's torch mode of the camera of the given ID without opening the camera
 * device.
 *
 * <p>Use {@link #getCameraIdList} to get the list of available camera devices and use
 * {@link #getCameraCharacteristics} to check whether the camera device has a flash unit.
 * Note that even if a camera device has a flash unit, turning on the torch mode may fail
 * if the camera device or other camera resources needed to turn on the torch mode are in use.
 * </p>
 *
 * <p> If {@link #setTorchMode} is called to turn on or off the torch mode successfully,
 * {@link android.hardware.camera2.CameraManager.TorchCallback#onTorchModeChanged CameraManager.TorchCallback#onTorchModeChanged} will be invoked.
 * However, even if turning on the torch mode is successful, the application does not have the
 * exclusive ownership of the flash unit or the camera device. The torch mode will be turned
 * off and becomes unavailable when the camera device that the flash unit belongs to becomes
 * unavailable or when other camera resources to keep the torch on become unavailable (
 * {@link android.hardware.camera2.CameraManager.TorchCallback#onTorchModeUnavailable CameraManager.TorchCallback#onTorchModeUnavailable} will be invoked). Also,
 * other applications are free to call {@link #setTorchMode} to turn off the torch mode (
 * {@link android.hardware.camera2.CameraManager.TorchCallback#onTorchModeChanged CameraManager.TorchCallback#onTorchModeChanged} will be invoked). If the latest
 * application that turned on the torch mode exits, the torch mode will be turned off.
 *
 * @param cameraId
 *             The unique identifier of the camera device that the flash unit belongs to.
 * This value must never be {@code null}.
 * @param enabled
 *             The desired state of the torch mode for the target camera device. Set to
 *             {@code true} to turn on the torch mode. Set to {@code false} to turn off the
 *             torch mode.
 *
 * @throws android.hardware.camera2.CameraAccessException if it failed to access the flash unit.
 *             {@link android.hardware.camera2.CameraAccessException#CAMERA_IN_USE CameraAccessException#CAMERA_IN_USE} will be thrown if the camera device
 *             is in use. {@link android.hardware.camera2.CameraAccessException#MAX_CAMERAS_IN_USE CameraAccessException#MAX_CAMERAS_IN_USE} will be thrown if
 *             other camera resources needed to turn on the torch mode are in use.
 *             {@link android.hardware.camera2.CameraAccessException#CAMERA_DISCONNECTED CameraAccessException#CAMERA_DISCONNECTED} will be thrown if camera
 *             service is not available.
 *
 * @throws java.lang.IllegalArgumentException if cameraId was null, cameraId doesn't match any currently
 *             or previously available camera device, or the camera device doesn't have a
 *             flash unit.
 * @apiSince 23
 */

public void setTorchMode(@androidx.annotation.NonNull java.lang.String cameraId, boolean enabled) throws android.hardware.camera2.CameraAccessException { throw new RuntimeException("Stub!"); }
/**
 * A callback for camera devices becoming available or unavailable to open.
 *
 * <p>Cameras become available when they are no longer in use, or when a new
 * removable camera is connected. They become unavailable when some
 * application or service starts using a camera, or when a removable camera
 * is disconnected.</p>
 *
 * <p>Extend this callback and pass an instance of the subclass to
 * {@link android.hardware.camera2.CameraManager#registerAvailabilityCallback CameraManager#registerAvailabilityCallback} to be notified of such availability
 * changes.</p>
 *
 * @see #registerAvailabilityCallback
 * @apiSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class AvailabilityCallback {

public AvailabilityCallback() { throw new RuntimeException("Stub!"); }

/**
 * A new camera has become available to use.
 *
 * <p>The default implementation of this method does nothing.</p>
 *
 * @param cameraId The unique identifier of the new camera.
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public void onCameraAvailable(@androidx.annotation.NonNull java.lang.String cameraId) { throw new RuntimeException("Stub!"); }

/**
 * A previously-available camera has become unavailable for use.
 *
 * <p>If an application had an active CameraDevice instance for the
 * now-disconnected camera, that application will receive a
 * {@link android.hardware.camera2.CameraDevice.StateCallback#onDisconnected CameraDevice.StateCallback#onDisconnected}.</p>
 *
 * <p>The default implementation of this method does nothing.</p>
 *
 * @param cameraId The unique identifier of the disconnected camera.
 
 * This value must never be {@code null}.
 * @apiSince 21
 */

public void onCameraUnavailable(@androidx.annotation.NonNull java.lang.String cameraId) { throw new RuntimeException("Stub!"); }

/**
 * Called whenever camera access priorities change.
 *
 * <p>Notification that camera access priorities have changed and the camera may
 * now be openable. An application that was previously denied camera access due to
 * a higher-priority user already using the camera, or that was disconnected from an
 * active camera session due to a higher-priority user trying to open the camera,
 * should try to open the camera again if it still wants to use it.  Note that
 * multiple applications may receive this callback at the same time, and only one of
 * them will succeed in opening the camera in practice, depending on exact access
 * priority levels and timing. This method is useful in cases where multiple
 * applications may be in the resumed state at the same time, and the user switches
 * focus between them, or if the current camera-using application moves between
 * full-screen and Picture-in-Picture (PiP) states. In such cases, the camera
 * available/unavailable callbacks will not be invoked, but another application may
 * now have higher priority for camera access than the current camera-using
 * application.</p>
 *
 * <p>The default implementation of this method does nothing.</p>
 *
 * @apiSince 29
 */

public void onCameraAccessPrioritiesChanged() { throw new RuntimeException("Stub!"); }
}

/**
 * A callback for camera flash torch modes becoming unavailable, disabled, or enabled.
 *
 * <p>The torch mode becomes unavailable when the camera device it belongs to becomes
 * unavailable or other camera resources it needs become busy due to other higher priority
 * camera activities. The torch mode becomes disabled when it was turned off or when the camera
 * device it belongs to is no longer in use and other camera resources it needs are no longer
 * busy. A camera's torch mode is turned off when an application calls {@link #setTorchMode} to
 * turn off the camera's torch mode, or when an application turns on another camera's torch mode
 * if keeping multiple torch modes on simultaneously is not supported. The torch mode becomes
 * enabled when it is turned on via {@link #setTorchMode}.</p>
 *
 * <p>The torch mode is available to set via {@link #setTorchMode} only when it's in a disabled
 * or enabled state.</p>
 *
 * <p>Extend this callback and pass an instance of the subclass to
 * {@link android.hardware.camera2.CameraManager#registerTorchCallback CameraManager#registerTorchCallback} to be notified of such status changes.
 * </p>
 *
 * @see #registerTorchCallback
 * @apiSince 23
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class TorchCallback {

public TorchCallback() { throw new RuntimeException("Stub!"); }

/**
 * A camera's torch mode has become unavailable to set via {@link #setTorchMode}.
 *
 * <p>If torch mode was previously turned on by calling {@link #setTorchMode}, it will be
 * turned off before {@link android.hardware.camera2.CameraManager.TorchCallback#onTorchModeUnavailable CameraManager.TorchCallback#onTorchModeUnavailable} is
 * invoked. {@link #setTorchMode} will fail until the torch mode has entered a disabled or
 * enabled state again.</p>
 *
 * <p>The default implementation of this method does nothing.</p>
 *
 * @param cameraId The unique identifier of the camera whose torch mode has become
 *                 unavailable.
 
 * This value must never be {@code null}.
 * @apiSince 23
 */

public void onTorchModeUnavailable(@androidx.annotation.NonNull java.lang.String cameraId) { throw new RuntimeException("Stub!"); }

/**
 * A camera's torch mode has become enabled or disabled and can be changed via
 * {@link #setTorchMode}.
 *
 * <p>The default implementation of this method does nothing.</p>
 *
 * @param cameraId The unique identifier of the camera whose torch mode has been changed.
 *
 * This value must never be {@code null}.
 * @param enabled The state that the torch mode of the camera has been changed to.
 *                {@code true} when the torch mode has become on and available to be turned
 *                off. {@code false} when the torch mode has becomes off and available to
 *                be turned on.
 * @apiSince 23
 */

public void onTorchModeChanged(@androidx.annotation.NonNull java.lang.String cameraId, boolean enabled) { throw new RuntimeException("Stub!"); }
}

}

