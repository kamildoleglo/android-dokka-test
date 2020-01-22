/*
 * Copyright (C) 2008 The Android Open Source Project
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


package android.hardware;

import android.view.SurfaceHolder;
import java.io.IOException;
import android.view.Surface;
import android.graphics.SurfaceTexture;
import android.graphics.ImageFormat;
import java.util.List;
import android.os.Build;

/**
 * The Camera class is used to set image capture settings, start/stop preview,
 * snap pictures, and retrieve frames for encoding for video.  This class is a
 * client for the Camera service, which manages the actual camera hardware.
 *
 * <p>To access the device camera, you must declare the
 * {@link android.Manifest.permission#CAMERA} permission in your Android
 * Manifest. Also be sure to include the
 * <a href="{@docRoot}guide/topics/manifest/uses-feature-element.html">&lt;uses-feature></a>
 * manifest element to declare camera features used by your application.
 * For example, if you use the camera and auto-focus feature, your Manifest
 * should include the following:</p>
 * <pre> &lt;uses-permission android:name="android.permission.CAMERA" />
 * &lt;uses-feature android:name="android.hardware.camera" />
 * &lt;uses-feature android:name="android.hardware.camera.autofocus" /></pre>
 *
 * <p>To take pictures with this class, use the following steps:</p>
 *
 * <ol>
 * <li>Obtain an instance of Camera from {@link #open(int)}.
 *
 * <li>Get existing (default) settings with {@link #getParameters()}.
 *
 * <li>If necessary, modify the returned {@link android.hardware.Camera.Parameters Camera.Parameters} object and call
 * {@link #setParameters(android.hardware.Camera.Parameters)}.
 *
 * <li>Call {@link #setDisplayOrientation(int)} to ensure correct orientation of preview.
 *
 * <li><b>Important</b>: Pass a fully initialized {@link android.view.SurfaceHolder SurfaceHolder} to
 * {@link #setPreviewDisplay(android.view.SurfaceHolder)}.  Without a surface, the camera
 * will be unable to start the preview.
 *
 * <li><b>Important</b>: Call {@link #startPreview()} to start updating the
 * preview surface.  Preview must be started before you can take a picture.
 *
 * <li>When you want, call {@link #takePicture(android.hardware.Camera.ShutterCallback,android.hardware.Camera.PictureCallback,android.hardware.Camera.PictureCallback,android.hardware.Camera.PictureCallback)} to
 * capture a photo.  Wait for the callbacks to provide the actual image data.
 *
 * <li>After taking a picture, preview display will have stopped.  To take more
 * photos, call {@link #startPreview()} again first.
 *
 * <li>Call {@link #stopPreview()} to stop updating the preview surface.
 *
 * <li><b>Important:</b> Call {@link #release()} to release the camera for
 * use by other applications.  Applications should release the camera
 * immediately in {@link android.app.Activity#onPause()} (and re-{@link #open()}
 * it in {@link android.app.Activity#onResume()}).
 * </ol>
 *
 * <p>To quickly switch to video recording mode, use these steps:</p>
 *
 * <ol>
 * <li>Obtain and initialize a Camera and start preview as described above.
 *
 * <li>Call {@link #unlock()} to allow the media process to access the camera.
 *
 * <li>Pass the camera to {@link android.media.MediaRecorder#setCamera(Camera)}.
 * See {@link android.media.MediaRecorder} information about video recording.
 *
 * <li>When finished recording, call {@link #reconnect()} to re-acquire
 * and re-lock the camera.
 *
 * <li>If desired, restart preview and take more photos or videos.
 *
 * <li>Call {@link #stopPreview()} and {@link #release()} as described above.
 * </ol>
 *
 * <p>This class is not thread-safe, and is meant for use from one event thread.
 * Most long-running operations (preview, focus, photo capture, etc) happen
 * asynchronously and invoke callbacks as necessary.  Callbacks will be invoked
 * on the event thread {@link #open(int)} was called from.  This class's methods
 * must never be called from multiple threads at once.</p>
 *
 * <p class="caution"><strong>Caution:</strong> Different Android-powered devices
 * may have different hardware specifications, such as megapixel ratings and
 * auto-focus capabilities. In order for your application to be compatible with
 * more devices, you should not make assumptions about the device camera
 * specifications.</p>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about using cameras, read the
 * <a href="{@docRoot}guide/topics/media/camera.html">Camera</a> developer guide.</p>
 * </div>
 *
 * @deprecated We recommend using the new {@link android.hardware.camera2} API for new
 *             applications.
 * @apiSince 1
 * @deprecatedSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class Camera {

Camera() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of physical cameras available on this device.
 * The return value of this method might change dynamically if the device
 * supports external cameras and an external camera is connected or
 * disconnected.
 *
 * If there is a
 * {@link android.hardware.camera2.CameraCharacteristics#REQUEST_AVAILABLE_CAPABILITIES_LOGICAL_MULTI_CAMERA
 * logical multi-camera} in the system, to maintain app backward compatibility, this method will
 * only expose one camera per facing for all logical camera and physical camera groups.
 * Use camera2 API to see all cameras.
 *
 * @return total number of accessible camera devices, or 0 if there are no
 *   cameras or an error was encountered enumerating them.
 * @apiSince 9
 * @deprecatedSince 21
 */

@Deprecated
public static native int getNumberOfCameras();

/**
 * Returns the information about a particular camera.
 * If {@link #getNumberOfCameras()} returns N, the valid id is 0 to N-1.
 *
 * @throws java.lang.RuntimeException if an invalid ID is provided, or if there is an
 *    error retrieving the information (generally due to a hardware or other
 *    low-level failure).
 * @apiSince 9
 * @deprecatedSince 21
 */

@Deprecated
public static void getCameraInfo(int cameraId, android.hardware.Camera.CameraInfo cameraInfo) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new Camera object to access a particular hardware camera. If
 * the same camera is opened by other applications, this will throw a
 * RuntimeException.
 *
 * <p>You must call {@link #release()} when you are done using the camera,
 * otherwise it will remain locked and be unavailable to other applications.
 *
 * <p>Your application should only have one Camera object active at a time
 * for a particular hardware camera.
 *
 * <p>Callbacks from other methods are delivered to the event loop of the
 * thread which called open().  If this thread has no event loop, then
 * callbacks are delivered to the main application event loop.  If there
 * is no main application event loop, callbacks are not delivered.
 *
 * <p class="caution"><b>Caution:</b> On some devices, this method may
 * take a long time to complete.  It is best to call this method from a
 * worker thread (possibly using {@link android.os.AsyncTask}) to avoid
 * blocking the main application UI thread.
 *
 * @param cameraId the hardware camera to access, between 0 and
 *     {@link #getNumberOfCameras()}-1.
 * @return a new Camera object, connected, locked and ready for use.
 * @throws java.lang.RuntimeException if opening the camera fails (for example, if the
 *     camera is in use by another process or device policy manager has
 *     disabled the camera).
 * @see android.app.admin.DevicePolicyManager#getCameraDisabled(android.content.ComponentName)
 * @apiSince 9
 * @deprecatedSince 21
 */

@Deprecated
public static android.hardware.Camera open(int cameraId) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new Camera object to access the first back-facing camera on the
 * device. If the device does not have a back-facing camera, this returns
 * null. Otherwise acts like the {@link #open(int)} call.
 *
 * @return a new Camera object for the first back-facing camera, or null if there is no
 *  backfacing camera
 * @see #open(int)
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public static android.hardware.Camera open() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
protected void finalize() { throw new RuntimeException("Stub!"); }

/**
 * Disconnects and releases the Camera object resources.
 *
 * <p>You must call this as soon as you're done with the Camera object.</p>
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public final void release() { throw new RuntimeException("Stub!"); }

/**
 * Unlocks the camera to allow another process to access it.
 * Normally, the camera is locked to the process with an active Camera
 * object until {@link #release()} is called.  To allow rapid handoff
 * between processes, you can call this method to release the camera
 * temporarily for another process to use; once the other process is done
 * you can call {@link #reconnect()} to reclaim the camera.
 *
 * <p>This must be done before calling
 * {@link android.media.MediaRecorder#setCamera(Camera)}. This cannot be
 * called after recording starts.
 *
 * <p>If you are not recording video, you probably do not need this method.
 *
 * @throws java.lang.RuntimeException if the camera cannot be unlocked.
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public final native void unlock();

/**
 * Re-locks the camera to prevent other processes from accessing it.
 * Camera objects are locked by default unless {@link #unlock()} is
 * called.  Normally {@link #reconnect()} is used instead.
 *
 * <p>Since API level 14, camera is automatically locked for applications in
 * {@link android.media.MediaRecorder#start()}. Applications can use the
 * camera (ex: zoom) after recording starts. There is no need to call this
 * after recording starts or stops.
 *
 * <p>If you are not recording video, you probably do not need this method.
 *
 * @throws java.lang.RuntimeException if the camera cannot be re-locked (for
 *     example, if the camera is still in use by another process).
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public final native void lock();

/**
 * Reconnects to the camera service after another process used it.
 * After {@link #unlock()} is called, another process may use the
 * camera; when the process is done, you must reconnect to the camera,
 * which will re-acquire the lock and allow you to continue using the
 * camera.
 *
 * <p>Since API level 14, camera is automatically locked for applications in
 * {@link android.media.MediaRecorder#start()}. Applications can use the
 * camera (ex: zoom) after recording starts. There is no need to call this
 * after recording starts or stops.
 *
 * <p>If you are not recording video, you probably do not need this method.
 *
 * @throws java.io.IOException if a connection cannot be re-established (for
 *     example, if the camera is still in use by another process).
 * @throws java.lang.RuntimeException if release() has been called on this Camera
 *     instance.
 * @apiSince 8
 * @deprecatedSince 21
 */

@Deprecated
public final native void reconnect() throws java.io.IOException;

/**
 * Sets the {@link android.view.Surface Surface} to be used for live preview.
 * Either a surface or surface texture is necessary for preview, and
 * preview is necessary to take pictures.  The same surface can be re-set
 * without harm.  Setting a preview surface will un-set any preview surface
 * texture that was set via {@link #setPreviewTexture}.
 *
 * <p>The {@link android.view.SurfaceHolder SurfaceHolder} must already contain a surface when this
 * method is called.  If you are using {@link android.view.SurfaceView},
 * you will need to register a {@link android.view.SurfaceHolder.Callback SurfaceHolder.Callback} with
 * {@link android.view.SurfaceHolder#addCallback(android.view.SurfaceHolder.Callback) SurfaceHolder#addCallback(SurfaceHolder.Callback)} and wait for
 * {@link android.view.SurfaceHolder.Callback#surfaceCreated(android.view.SurfaceHolder) SurfaceHolder.Callback#surfaceCreated(SurfaceHolder)} before
 * calling setPreviewDisplay() or starting preview.
 *
 * <p>This method must be called before {@link #startPreview()}.  The
 * one exception is that if the preview surface is not set (or set to null)
 * before startPreview() is called, then this method may be called once
 * with a non-null parameter to set the preview surface.  (This allows
 * camera setup and surface creation to happen in parallel, saving time.)
 * The preview surface may not otherwise change while preview is running.
 *
 * @param holder containing the Surface on which to place the preview,
 *     or null to remove the preview surface
 * @throws java.io.IOException if the method fails (for example, if the surface
 *     is unavailable or unsuitable).
 * @throws java.lang.RuntimeException if release() has been called on this Camera
 *    instance.
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public final void setPreviewDisplay(android.view.SurfaceHolder holder) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link android.graphics.SurfaceTexture SurfaceTexture} to be used for live preview.
 * Either a surface or surface texture is necessary for preview, and
 * preview is necessary to take pictures.  The same surface texture can be
 * re-set without harm.  Setting a preview surface texture will un-set any
 * preview surface that was set via {@link #setPreviewDisplay}.
 *
 * <p>This method must be called before {@link #startPreview()}.  The
 * one exception is that if the preview surface texture is not set (or set
 * to null) before startPreview() is called, then this method may be called
 * once with a non-null parameter to set the preview surface.  (This allows
 * camera setup and surface creation to happen in parallel, saving time.)
 * The preview surface texture may not otherwise change while preview is
 * running.
 *
 * <p>The timestamps provided by {@link android.graphics.SurfaceTexture#getTimestamp() SurfaceTexture#getTimestamp()} for a
 * SurfaceTexture set as the preview texture have an unspecified zero point,
 * and cannot be directly compared between different cameras or different
 * instances of the same camera, or across multiple runs of the same
 * program.
 *
 * <p>If you are using the preview data to create video or still images,
 * strongly consider using {@link android.media.MediaActionSound} to
 * properly indicate image capture or recording start/stop to the user.</p>
 *
 * @see android.media.MediaActionSound
 * @see android.graphics.SurfaceTexture
 * @see android.view.TextureView
 * @param surfaceTexture the {@link android.graphics.SurfaceTexture SurfaceTexture} to which the preview
 *     images are to be sent or null to remove the current preview surface
 *     texture
 * @throws java.io.IOException if the method fails (for example, if the surface
 *     texture is unavailable or unsuitable).
 * @throws java.lang.RuntimeException if release() has been called on this Camera
 *    instance.
 * @apiSince 11
 * @deprecatedSince 21
 */

@Deprecated
public final native void setPreviewTexture(android.graphics.SurfaceTexture surfaceTexture) throws java.io.IOException;

/**
 * Starts capturing and drawing preview frames to the screen.
 * Preview will not actually start until a surface is supplied
 * with {@link #setPreviewDisplay(android.view.SurfaceHolder)} or
 * {@link #setPreviewTexture(android.graphics.SurfaceTexture)}.
 *
 * <p>If {@link #setPreviewCallback(android.hardware.Camera.PreviewCallback)},
 * {@link #setOneShotPreviewCallback(android.hardware.Camera.PreviewCallback)}, or
 * {@link #setPreviewCallbackWithBuffer(android.hardware.Camera.PreviewCallback)} were
 * called, {@link android.hardware.Camera.PreviewCallback#onPreviewFrame(byte[],android.hardware.Camera) Camera.PreviewCallback#onPreviewFrame(byte[], Camera)}
 * will be called when preview data becomes available.
 *
 * @throws java.lang.RuntimeException if starting preview fails; usually this would be
 *    because of a hardware or other low-level error, or because release()
 *    has been called on this Camera instance. The QCIF (176x144) exception
 *    mentioned in {@link android.hardware.Camera.Parameters#setPreviewSize Parameters#setPreviewSize} and
 *    {@link android.hardware.Camera.Parameters#setPictureSize Parameters#setPictureSize} can also cause this
 *    exception be thrown.
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public final native void startPreview();

/**
 * Stops capturing and drawing preview frames to the surface, and
 * resets the camera for a future call to {@link #startPreview()}.
 *
 * @throws java.lang.RuntimeException if stopping preview fails; usually this would be
 *    because of a hardware or other low-level error, or because release()
 *    has been called on this Camera instance.
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public final void stopPreview() { throw new RuntimeException("Stub!"); }

/**
 * <p>Installs a callback to be invoked for every preview frame in addition
 * to displaying them on the screen.  The callback will be repeatedly called
 * for as long as preview is active.  This method can be called at any time,
 * even while preview is live.  Any other preview callbacks are
 * overridden.</p>
 *
 * <p>If you are using the preview data to create video or still images,
 * strongly consider using {@link android.media.MediaActionSound} to
 * properly indicate image capture or recording start/stop to the user.</p>
 *
 * @param cb a callback object that receives a copy of each preview frame,
 *     or null to stop receiving callbacks.
 * @throws java.lang.RuntimeException if release() has been called on this Camera
 *     instance.
 * @see android.media.MediaActionSound
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public final void setPreviewCallback(android.hardware.Camera.PreviewCallback cb) { throw new RuntimeException("Stub!"); }

/**
 * <p>Installs a callback to be invoked for the next preview frame in
 * addition to displaying it on the screen.  After one invocation, the
 * callback is cleared. This method can be called any time, even when
 * preview is live.  Any other preview callbacks are overridden.</p>
 *
 * <p>If you are using the preview data to create video or still images,
 * strongly consider using {@link android.media.MediaActionSound} to
 * properly indicate image capture or recording start/stop to the user.</p>
 *
 * @param cb a callback object that receives a copy of the next preview frame,
 *     or null to stop receiving callbacks.
 * @throws java.lang.RuntimeException if release() has been called on this Camera
 *     instance.
 * @see android.media.MediaActionSound
 * @apiSince 3
 * @deprecatedSince 21
 */

@Deprecated
public final void setOneShotPreviewCallback(android.hardware.Camera.PreviewCallback cb) { throw new RuntimeException("Stub!"); }

/**
 * <p>Installs a callback to be invoked for every preview frame, using
 * buffers supplied with {@link #addCallbackBuffer(byte[])}, in addition to
 * displaying them on the screen.  The callback will be repeatedly called
 * for as long as preview is active and buffers are available.  Any other
 * preview callbacks are overridden.</p>
 *
 * <p>The purpose of this method is to improve preview efficiency and frame
 * rate by allowing preview frame memory reuse.  You must call
 * {@link #addCallbackBuffer(byte[])} at some point -- before or after
 * calling this method -- or no callbacks will received.</p>
 *
 * <p>The buffer queue will be cleared if this method is called with a null
 * callback, {@link #setPreviewCallback(android.hardware.Camera.PreviewCallback)} is called,
 * or {@link #setOneShotPreviewCallback(android.hardware.Camera.PreviewCallback)} is
 * called.</p>
 *
 * <p>If you are using the preview data to create video or still images,
 * strongly consider using {@link android.media.MediaActionSound} to
 * properly indicate image capture or recording start/stop to the user.</p>
 *
 * @param cb a callback object that receives a copy of the preview frame,
 *     or null to stop receiving callbacks and clear the buffer queue.
 * @throws java.lang.RuntimeException if release() has been called on this Camera
 *     instance.
 * @see #addCallbackBuffer(byte[])
 * @see android.media.MediaActionSound
 * @apiSince 8
 * @deprecatedSince 21
 */

@Deprecated
public final void setPreviewCallbackWithBuffer(android.hardware.Camera.PreviewCallback cb) { throw new RuntimeException("Stub!"); }

/**
 * Adds a pre-allocated buffer to the preview callback buffer queue.
 * Applications can add one or more buffers to the queue. When a preview
 * frame arrives and there is still at least one available buffer, the
 * buffer will be used and removed from the queue. Then preview callback is
 * invoked with the buffer. If a frame arrives and there is no buffer left,
 * the frame is discarded. Applications should add buffers back when they
 * finish processing the data in them.
 *
 * <p>For formats besides YV12, the size of the buffer is determined by
 * multiplying the preview image width, height, and bytes per pixel. The
 * width and height can be read from
 * {@link android.hardware.Camera.Parameters#getPreviewSize() Camera.Parameters#getPreviewSize()}. Bytes per pixel can be
 * computed from {@link android.graphics.ImageFormat#getBitsPerPixel(int)} /
 * 8, using the image format from
 * {@link android.hardware.Camera.Parameters#getPreviewFormat() Camera.Parameters#getPreviewFormat()}.
 *
 * <p>If using the {@link android.graphics.ImageFormat#YV12} format, the
 * size can be calculated using the equations listed in
 * {@link android.hardware.Camera.Parameters#setPreviewFormat Camera.Parameters#setPreviewFormat}.
 *
 * <p>This method is only necessary when
 * {@link #setPreviewCallbackWithBuffer(android.hardware.Camera.PreviewCallback)} is used. When
 * {@link #setPreviewCallback(android.hardware.Camera.PreviewCallback)} or
 * {@link #setOneShotPreviewCallback(android.hardware.Camera.PreviewCallback)} are used, buffers
 * are automatically allocated. When a supplied buffer is too small to
 * hold the preview frame data, preview callback will return null and
 * the buffer will be removed from the buffer queue.
 *
 * @param callbackBuffer the buffer to add to the queue. The size of the
 *   buffer must match the values described above.
 * @see #setPreviewCallbackWithBuffer(PreviewCallback)
 * @apiSince 8
 * @deprecatedSince 21
 */

@Deprecated
public final void addCallbackBuffer(byte[] callbackBuffer) { throw new RuntimeException("Stub!"); }

/**
 * Starts camera auto-focus and registers a callback function to run when
 * the camera is focused.  This method is only valid when preview is active
 * (between {@link #startPreview()} and before {@link #stopPreview()}).
 *
 * <p>Callers should check
 * {@link android.hardware.Camera.Parameters#getFocusMode()} to determine if
 * this method should be called. If the camera does not support auto-focus,
 * it is a no-op and {@link android.hardware.Camera.AutoFocusCallback#onAutoFocus(boolean,android.hardware.Camera) AutoFocusCallback#onAutoFocus(boolean, Camera)}
 * callback will be called immediately.
 *
 * <p>If your application should not be installed
 * on devices without auto-focus, you must declare that your application
 * uses auto-focus with the
 * <a href="{@docRoot}guide/topics/manifest/uses-feature-element.html">&lt;uses-feature></a>
 * manifest element.</p>
 *
 * <p>If the current flash mode is not
 * {@link android.hardware.Camera.Parameters#FLASH_MODE_OFF}, flash may be
 * fired during auto-focus, depending on the driver and camera hardware.<p>
 *
 * <p>Auto-exposure lock {@link android.hardware.Camera.Parameters#getAutoExposureLock()}
 * and auto-white balance locks {@link android.hardware.Camera.Parameters#getAutoWhiteBalanceLock()}
 * do not change during and after autofocus. But auto-focus routine may stop
 * auto-exposure and auto-white balance transiently during focusing.
 *
 * <p>Stopping preview with {@link #stopPreview()}, or triggering still
 * image capture with {@link #takePicture(android.hardware.Camera.ShutterCallback,android.hardware.Camera.PictureCallback,android.hardware.Camera.PictureCallback)}, will not change the
 * the focus position. Applications must call cancelAutoFocus to reset the
 * focus.</p>
 *
 * <p>If autofocus is successful, consider using
 * {@link android.media.MediaActionSound} to properly play back an autofocus
 * success sound to the user.</p>
 *
 * @param cb the callback to run
 * @throws java.lang.RuntimeException if starting autofocus fails; usually this would
 *    be because of a hardware or other low-level error, or because
 *    release() has been called on this Camera instance.
 * @see #cancelAutoFocus()
 * @see android.hardware.Camera.Parameters#setAutoExposureLock(boolean)
 * @see android.hardware.Camera.Parameters#setAutoWhiteBalanceLock(boolean)
 * @see android.media.MediaActionSound
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public final void autoFocus(android.hardware.Camera.AutoFocusCallback cb) { throw new RuntimeException("Stub!"); }

/**
 * Cancels any auto-focus function in progress.
 * Whether or not auto-focus is currently in progress,
 * this function will return the focus position to the default.
 * If the camera does not support auto-focus, this is a no-op.
 *
 * @throws java.lang.RuntimeException if canceling autofocus fails; usually this would
 *    be because of a hardware or other low-level error, or because
 *    release() has been called on this Camera instance.
 * @see #autoFocus(Camera.AutoFocusCallback)
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public final void cancelAutoFocus() { throw new RuntimeException("Stub!"); }

/**
 * Sets camera auto-focus move callback.
 *
 * @param cb the callback to run
 * @throws java.lang.RuntimeException if enabling the focus move callback fails;
 *    usually this would be because of a hardware or other low-level error,
 *    or because release() has been called on this Camera instance.
 * @apiSince 16
 * @deprecatedSince 21
 */

@Deprecated
public void setAutoFocusMoveCallback(android.hardware.Camera.AutoFocusMoveCallback cb) { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to <pre>takePicture(Shutter, raw, null, jpeg)</pre>.
 *
 * @see #takePicture(ShutterCallback, PictureCallback, PictureCallback, PictureCallback)
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public final void takePicture(android.hardware.Camera.ShutterCallback shutter, android.hardware.Camera.PictureCallback raw, android.hardware.Camera.PictureCallback jpeg) { throw new RuntimeException("Stub!"); }

/**
 * Triggers an asynchronous image capture. The camera service will initiate
 * a series of callbacks to the application as the image capture progresses.
 * The shutter callback occurs after the image is captured. This can be used
 * to trigger a sound to let the user know that image has been captured. The
 * raw callback occurs when the raw image data is available (NOTE: the data
 * will be null if there is no raw image callback buffer available or the
 * raw image callback buffer is not large enough to hold the raw image).
 * The postview callback occurs when a scaled, fully processed postview
 * image is available (NOTE: not all hardware supports this). The jpeg
 * callback occurs when the compressed image is available. If the
 * application does not need a particular callback, a null can be passed
 * instead of a callback method.
 *
 * <p>This method is only valid when preview is active (after
 * {@link #startPreview()}).  Preview will be stopped after the image is
 * taken; callers must call {@link #startPreview()} again if they want to
 * re-start preview or take more pictures. This should not be called between
 * {@link android.media.MediaRecorder#start()} and
 * {@link android.media.MediaRecorder#stop()}.
 *
 * <p>After calling this method, you must not call {@link #startPreview()}
 * or take another picture until the JPEG callback has returned.
 *
 * @param shutter   the callback for image capture moment, or null
 * @param raw       the callback for raw (uncompressed) image data, or null
 * @param postview  callback with postview image data, may be null
 * @param jpeg      the callback for JPEG image data, or null
 * @throws java.lang.RuntimeException if starting picture capture fails; usually this
 *    would be because of a hardware or other low-level error, or because
 *    release() has been called on this Camera instance.
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public final void takePicture(android.hardware.Camera.ShutterCallback shutter, android.hardware.Camera.PictureCallback raw, android.hardware.Camera.PictureCallback postview, android.hardware.Camera.PictureCallback jpeg) { throw new RuntimeException("Stub!"); }

/**
 * Zooms to the requested value smoothly. The driver will notify {@link android.hardware.Camera.OnZoomChangeListener OnZoomChangeListener} of the zoom value and whether zoom is stopped at
 * the time. For example, suppose the current zoom is 0 and startSmoothZoom
 * is called with value 3. The
 * {@link android.hardware.Camera.OnZoomChangeListener#onZoomChange(int,boolean,android.hardware.Camera) Camera.OnZoomChangeListener#onZoomChange(int, boolean, Camera)}
 * method will be called three times with zoom values 1, 2, and 3.
 * Applications can call {@link #stopSmoothZoom} to stop the zoom earlier.
 * Applications should not call startSmoothZoom again or change the zoom
 * value before zoom stops. If the supplied zoom value equals to the current
 * zoom value, no zoom callback will be generated. This method is supported
 * if {@link android.hardware.Camera.Parameters#isSmoothZoomSupported}
 * returns true.
 *
 * @param value zoom value. The valid range is 0 to {@link
 *              android.hardware.Camera.Parameters#getMaxZoom}.
 * @throws java.lang.IllegalArgumentException if the zoom value is invalid.
 * @throws java.lang.RuntimeException if the method fails.
 * @see #setZoomChangeListener(OnZoomChangeListener)
 * @apiSince 8
 * @deprecatedSince 21
 */

@Deprecated
public final native void startSmoothZoom(int value);

/**
 * Stops the smooth zoom. Applications should wait for the {@link android.hardware.Camera.OnZoomChangeListener OnZoomChangeListener} to know when the zoom is actually stopped. This
 * method is supported if {@link
 * android.hardware.Camera.Parameters#isSmoothZoomSupported} is true.
 *
 * @throws java.lang.RuntimeException if the method fails.
 * @apiSince 8
 * @deprecatedSince 21
 */

@Deprecated
public final native void stopSmoothZoom();

/**
 * Set the clockwise rotation of preview display in degrees. This affects
 * the preview frames and the picture displayed after snapshot. This method
 * is useful for portrait mode applications. Note that preview display of
 * front-facing cameras is flipped horizontally before the rotation, that
 * is, the image is reflected along the central vertical axis of the camera
 * sensor. So the users can see themselves as looking into a mirror.
 *
 * <p>This does not affect the order of byte array passed in {@link android.hardware.Camera.PreviewCallback#onPreviewFrame PreviewCallback#onPreviewFrame}, JPEG pictures, or recorded videos. This
 * method is not allowed to be called during preview.
 *
 * <p>If you want to make the camera image show in the same orientation as
 * the display, you can use the following code.
 * <pre>
 * public static void setCameraDisplayOrientation(Activity activity,
 *         int cameraId, android.hardware.Camera camera) {
 *     android.hardware.Camera.CameraInfo info =
 *             new android.hardware.Camera.CameraInfo();
 *     android.hardware.Camera.getCameraInfo(cameraId, info);
 *     int rotation = activity.getWindowManager().getDefaultDisplay()
 *             .getRotation();
 *     int degrees = 0;
 *     switch (rotation) {
 *         case Surface.ROTATION_0: degrees = 0; break;
 *         case Surface.ROTATION_90: degrees = 90; break;
 *         case Surface.ROTATION_180: degrees = 180; break;
 *         case Surface.ROTATION_270: degrees = 270; break;
 *     }
 *
 *     int result;
 *     if (info.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
 *         result = (info.orientation + degrees) % 360;
 *         result = (360 - result) % 360;  // compensate the mirror
 *     } else {  // back-facing
 *         result = (info.orientation - degrees + 360) % 360;
 *     }
 *     camera.setDisplayOrientation(result);
 * }
 * </pre>
 *
 * <p>Starting from API level 14, this method can be called when preview is
 * active.
 *
 * <p><b>Note: </b>Before API level 24, the default value for orientation is 0. Starting in
 * API level 24, the default orientation will be such that applications in forced-landscape mode
 * will have correct preview orientation, which may be either a default of 0 or
 * 180. Applications that operate in portrait mode or allow for changing orientation must still
 * call this method after each orientation change to ensure correct preview display in all
 * cases.</p>
 *
 * @param degrees the angle that the picture will be rotated clockwise.
 *                Valid values are 0, 90, 180, and 270.
 * @throws java.lang.RuntimeException if setting orientation fails; usually this would
 *    be because of a hardware or other low-level error, or because
 *    release() has been called on this Camera instance.
 * @see #setPreviewDisplay(SurfaceHolder)
 * @apiSince 8
 * @deprecatedSince 21
 */

@Deprecated
public final native void setDisplayOrientation(int degrees);

/**
 * <p>Enable or disable the default shutter sound when taking a picture.</p>
 *
 * <p>By default, the camera plays the system-defined camera shutter sound
 * when {@link #takePicture} is called. Using this method, the shutter sound
 * can be disabled. It is strongly recommended that an alternative shutter
 * sound is played in the {@link android.hardware.Camera.ShutterCallback ShutterCallback} when the system shutter
 * sound is disabled.</p>
 *
 * <p>Note that devices may not always allow disabling the camera shutter
 * sound. If the shutter sound state cannot be set to the desired value,
 * this method will return false. {@link android.hardware.Camera.CameraInfo#canDisableShutterSound CameraInfo#canDisableShutterSound}
 * can be used to determine whether the device will allow the shutter sound
 * to be disabled.</p>
 *
 * @param enabled whether the camera should play the system shutter sound
 *                when {@link #takePicture takePicture} is called.
 * @return {@code true} if the shutter sound state was successfully
 *         changed. {@code false} if the shutter sound state could not be
 *         changed. {@code true} is also returned if shutter sound playback
 *         is already set to the requested state.
 * @throws java.lang.RuntimeException if the call fails; usually this would be because
 *    of a hardware or other low-level error, or because release() has been
 *    called on this Camera instance.
 * @see #takePicture
 * @see android.hardware.Camera.CameraInfo#canDisableShutterSound
 * @see android.hardware.Camera.ShutterCallback
 * @apiSince 17
 * @deprecatedSince 21
 */

@Deprecated
public final boolean enableShutterSound(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Registers a listener to be notified when the zoom value is updated by the
 * camera driver during smooth zoom.
 *
 * @param listener the listener to notify
 * @see #startSmoothZoom(int)
 * @apiSince 8
 * @deprecatedSince 21
 */

@Deprecated
public final void setZoomChangeListener(android.hardware.Camera.OnZoomChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Registers a listener to be notified about the faces detected in the
 * preview frame.
 *
 * @param listener the listener to notify
 * @see #startFaceDetection()
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated
public final void setFaceDetectionListener(android.hardware.Camera.FaceDetectionListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Starts the face detection. This should be called after preview is started.
 * The camera will notify {@link android.hardware.Camera.FaceDetectionListener FaceDetectionListener} of the detected
 * faces in the preview frame. The detected faces may be the same as the
 * previous ones. Applications should call {@link #stopFaceDetection} to
 * stop the face detection. This method is supported if {@link android.hardware.Camera.Parameters#getMaxNumDetectedFaces() Parameters#getMaxNumDetectedFaces()} returns a number larger than 0.
 * If the face detection has started, apps should not call this again.
 *
 * <p>When the face detection is running, {@link android.hardware.Camera.Parameters#setWhiteBalance(java.lang.String) Parameters#setWhiteBalance(String)},
 * {@link android.hardware.Camera.Parameters#setFocusAreas(java.util.List) Parameters#setFocusAreas(List)}, and {@link android.hardware.Camera.Parameters#setMeteringAreas(java.util.List) Parameters#setMeteringAreas(List)}
 * have no effect. The camera uses the detected faces to do auto-white balance,
 * auto exposure, and autofocus.
 *
 * <p>If the apps call {@link #autoFocus(android.hardware.Camera.AutoFocusCallback)}, the camera
 * will stop sending face callbacks. The last face callback indicates the
 * areas used to do autofocus. After focus completes, face detection will
 * resume sending face callbacks. If the apps call {@link
 * #cancelAutoFocus()}, the face callbacks will also resume.</p>
 *
 * <p>After calling {@link #takePicture(android.hardware.Camera.ShutterCallback,android.hardware.Camera.PictureCallback,android.hardware.Camera.PictureCallback)} or {@link #stopPreview()}, and then resuming
 * preview with {@link #startPreview()}, the apps should call this method
 * again to resume face detection.</p>
 *
 * @throws java.lang.IllegalArgumentException if the face detection is unsupported.
 * @throws java.lang.RuntimeException if the method fails or the face detection is
 *         already running.
 * @see android.hardware.Camera.FaceDetectionListener
 * @see #stopFaceDetection()
 * @see android.hardware.Camera.Parameters#getMaxNumDetectedFaces()
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated
public final void startFaceDetection() { throw new RuntimeException("Stub!"); }

/**
 * Stops the face detection.
 *
 * @see #startFaceDetection()
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated
public final void stopFaceDetection() { throw new RuntimeException("Stub!"); }

/**
 * Registers a callback to be invoked when an error occurs.
 * @param cb The callback to run
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public final void setErrorCallback(android.hardware.Camera.ErrorCallback cb) { throw new RuntimeException("Stub!"); }

/**
 * Changes the settings for this Camera service.
 *
 * @param params the Parameters to use for this Camera service
 * @throws java.lang.RuntimeException if any parameter is invalid or not supported.
 * @see #getParameters()
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public void setParameters(android.hardware.Camera.Parameters params) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current settings for this Camera service.
 * If modifications are made to the returned Parameters, they must be passed
 * to {@link #setParameters(android.hardware.Camera.Parameters)} to take effect.
 *
 * @throws java.lang.RuntimeException if reading parameters fails; usually this would
 *    be because of a hardware or other low-level error, or because
 *    release() has been called on this Camera instance.
 * @see #setParameters(Camera.Parameters)
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public android.hardware.Camera.Parameters getParameters() { throw new RuntimeException("Stub!"); }

/**
 * Broadcast Action:  A new picture is taken by the camera, and the entry of
 * the picture has been added to the media store.
 * {@link android.content.Intent#getData} is URI of the picture.
 *
 * <p>In {@link android.os.Build.VERSION_CODES#N Android N} this broadcast was removed, and
 * applications are recommended to use
 * {@link android.app.job.JobInfo.Builder JobInfo.Builder}.{@link android.app.job.JobInfo.Builder#addTriggerContentUri}
 * instead.</p>
 *
 * <p>In {@link android.os.Build.VERSION_CODES#O Android O} this broadcast has been brought
 * back, but only for <em>registered</em> receivers.  Apps that are actively running can
 * again listen to the broadcast if they want an immediate clear signal about a picture
 * being taken, however anything doing heavy work (or needing to be launched) as a result of
 * this should still use JobScheduler.</p>
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String ACTION_NEW_PICTURE = "android.hardware.action.NEW_PICTURE";

/**
 * Broadcast Action:  A new video is recorded by the camera, and the entry
 * of the video has been added to the media store.
 * {@link android.content.Intent#getData} is URI of the video.
 *
 * <p>In {@link android.os.Build.VERSION_CODES#N Android N} this broadcast was removed, and
 * applications are recommended to use
 * {@link android.app.job.JobInfo.Builder JobInfo.Builder}.{@link android.app.job.JobInfo.Builder#addTriggerContentUri}
 * instead.</p>
 *
 * <p>In {@link android.os.Build.VERSION_CODES#O Android O} this broadcast has been brought
 * back, but only for <em>registered</em> receivers.  Apps that are actively running can
 * again listen to the broadcast if they want an immediate clear signal about a video
 * being taken, however anything doing heavy work (or needing to be launched) as a result of
 * this should still use JobScheduler.</p>
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String ACTION_NEW_VIDEO = "android.hardware.action.NEW_VIDEO";

/**
 * Camera was disconnected due to use by higher priority user.
 * @see android.hardware.Camera.ErrorCallback
 * @apiSince 23
 * @deprecatedSince 21
 */

@Deprecated public static final int CAMERA_ERROR_EVICTED = 2; // 0x2

/**
 * Media server died. In this case, the application must release the
 * Camera object and instantiate a new one.
 * @see android.hardware.Camera.ErrorCallback
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated public static final int CAMERA_ERROR_SERVER_DIED = 100; // 0x64

/**
 * Unspecified camera error.
 * @see android.hardware.Camera.ErrorCallback
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated public static final int CAMERA_ERROR_UNKNOWN = 1; // 0x1
/**
 * <p>The Area class is used for choosing specific metering and focus areas for
 * the camera to use when calculating auto-exposure, auto-white balance, and
 * auto-focus.</p>
 *
 * <p>To find out how many simultaneous areas a given camera supports, use
 * {@link android.hardware.Camera.Parameters#getMaxNumMeteringAreas() Parameters#getMaxNumMeteringAreas()} and
 * {@link android.hardware.Camera.Parameters#getMaxNumFocusAreas() Parameters#getMaxNumFocusAreas()}. If metering or focusing area
 * selection is unsupported, these methods will return 0.</p>
 *
 * <p>Each Area consists of a rectangle specifying its bounds, and a weight
 * that determines its importance. The bounds are relative to the camera's
 * current field of view. The coordinates are mapped so that (-1000, -1000)
 * is always the top-left corner of the current field of view, and (1000,
 * 1000) is always the bottom-right corner of the current field of
 * view. Setting Areas with bounds outside that range is not allowed. Areas
 * with zero or negative width or height are not allowed.</p>
 *
 * <p>The weight must range from 1 to 1000, and represents a weight for
 * every pixel in the area. This means that a large metering area with
 * the same weight as a smaller area will have more effect in the
 * metering result.  Metering areas can overlap and the driver
 * will add the weights in the overlap region.</p>
 *
 * @see android.hardware.Camera.Parameters#setFocusAreas(List)
 * @see android.hardware.Camera.Parameters#getFocusAreas()
 * @see android.hardware.Camera.Parameters#getMaxNumFocusAreas()
 * @see android.hardware.Camera.Parameters#setMeteringAreas(List)
 * @see android.hardware.Camera.Parameters#getMeteringAreas()
 * @see android.hardware.Camera.Parameters#getMaxNumMeteringAreas()
 *
 * @deprecated We recommend using the new {@link android.hardware.camera2} API for new
 *             applications.
 * @apiSince 14
 * @deprecatedSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static class Area {

/**
 * Create an area with specified rectangle and weight.
 *
 * @param rect the bounds of the area.
 * @param weight the weight of the area.
 * @apiSince 14
 */

@Deprecated
public Area(android.graphics.Rect rect, int weight) { throw new RuntimeException("Stub!"); }

/**
 * Compares {@code obj} to this area.
 *
 * @param obj the object to compare this area with.
 * @return {@code true} if the rectangle and weight of {@code obj} is
 *         the same as those of this area. {@code false} otherwise.
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated
public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Bounds of the area. (-1000, -1000) represents the top-left of the
 * camera field of view, and (1000, 1000) represents the bottom-right of
 * the field of view. Setting bounds outside that range is not
 * allowed. Bounds with zero or negative width or height are not
 * allowed.
 *
 * @see android.hardware.Camera.Parameters#getFocusAreas()
 * @see android.hardware.Camera.Parameters#getMeteringAreas()
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated public android.graphics.Rect rect;

/**
 * Weight of the area. The weight must range from 1 to 1000, and
 * represents a weight for every pixel in the area. This means that a
 * large metering area with the same weight as a smaller area will have
 * more effect in the metering result.  Metering areas can overlap and
 * the driver will add the weights in the overlap region.
 *
 * @see android.hardware.Camera.Parameters#getFocusAreas()
 * @see android.hardware.Camera.Parameters#getMeteringAreas()
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated public int weight;
}

/**
 * Callback interface used to notify on completion of camera auto focus.
 *
 * <p>Devices that do not support auto-focus will receive a "fake"
 * callback to this interface. If your application needs auto-focus and
 * should not be installed on devices <em>without</em> auto-focus, you must
 * declare that your app uses the
 * {@code android.hardware.camera.autofocus} feature, in the
 * <a href="{@docRoot}guide/topics/manifest/uses-feature-element.html">&lt;uses-feature></a>
 * manifest element.</p>
 *
 * @see #autoFocus(AutoFocusCallback)
 * @deprecated We recommend using the new {@link android.hardware.camera2} API for new
 *             applications.
 * @apiSince 1
 * @deprecatedSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface AutoFocusCallback {

/**
 * Called when the camera auto focus completes.  If the camera
 * does not support auto-focus and autoFocus is called,
 * onAutoFocus will be called immediately with a fake value of
 * <code>success</code> set to <code>true</code>.
 *
 * The auto-focus routine does not lock auto-exposure and auto-white
 * balance after it completes.
 *
 * @param success true if focus was successful, false if otherwise
 * @param camera  the Camera service object
 * @see android.hardware.Camera.Parameters#setAutoExposureLock(boolean)
 * @see android.hardware.Camera.Parameters#setAutoWhiteBalanceLock(boolean)
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public void onAutoFocus(boolean success, android.hardware.Camera camera);
}

/**
 * Callback interface used to notify on auto focus start and stop.
 *
 * <p>This is only supported in continuous autofocus modes -- {@link android.hardware.Camera.Parameters#FOCUS_MODE_CONTINUOUS_VIDEO Parameters#FOCUS_MODE_CONTINUOUS_VIDEO} and {@link android.hardware.Camera.Parameters#FOCUS_MODE_CONTINUOUS_PICTURE Parameters#FOCUS_MODE_CONTINUOUS_PICTURE}. Applications can show
 * autofocus animation based on this.</p>
 *
 * @deprecated We recommend using the new {@link android.hardware.camera2} API for new
 *             applications.
 * @apiSince 16
 * @deprecatedSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface AutoFocusMoveCallback {

/**
 * Called when the camera auto focus starts or stops.
 *
 * @param start true if focus starts to move, false if focus stops to move
 * @param camera the Camera service object
 * @apiSince 16
 * @deprecatedSince 21
 */

@Deprecated
public void onAutoFocusMoving(boolean start, android.hardware.Camera camera);
}

/**
 * Information about a camera
 *
 * @deprecated We recommend using the new {@link android.hardware.camera2} API for new
 *             applications.
 * @apiSince 9
 * @deprecatedSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static class CameraInfo {

@Deprecated
public CameraInfo() { throw new RuntimeException("Stub!"); }

/**
 * The facing of the camera is opposite to that of the screen.
 * @apiSince 9
 * @deprecatedSince 21
 */

@Deprecated public static final int CAMERA_FACING_BACK = 0; // 0x0

/**
 * The facing of the camera is the same as that of the screen.
 * @apiSince 9
 * @deprecatedSince 21
 */

@Deprecated public static final int CAMERA_FACING_FRONT = 1; // 0x1

/**
 * <p>Whether the shutter sound can be disabled.</p>
 *
 * <p>On some devices, the camera shutter sound cannot be turned off
 * through {@link #enableShutterSound enableShutterSound}. This field
 * can be used to determine whether a call to disable the shutter sound
 * will succeed.</p>
 *
 * <p>If this field is set to true, then a call of
 * {@code enableShutterSound(false)} will be successful. If set to
 * false, then that call will fail, and the shutter sound will be played
 * when {@link android.hardware.Camera#takePicture Camera#takePicture} is called.</p>
 * @apiSince 17
 * @deprecatedSince 21
 */

@Deprecated public boolean canDisableShutterSound;

/**
 * The direction that the camera faces. It should be
 * CAMERA_FACING_BACK or CAMERA_FACING_FRONT.
 * @apiSince 9
 * @deprecatedSince 21
 */

@Deprecated public int facing;

/**
 * <p>The orientation of the camera image. The value is the angle that the
 * camera image needs to be rotated clockwise so it shows correctly on
 * the display in its natural orientation. It should be 0, 90, 180, or 270.</p>
 *
 * <p>For example, suppose a device has a naturally tall screen. The
 * back-facing camera sensor is mounted in landscape. You are looking at
 * the screen. If the top side of the camera sensor is aligned with the
 * right edge of the screen in natural orientation, the value should be
 * 90. If the top side of a front-facing camera sensor is aligned with
 * the right of the screen, the value should be 270.</p>
 *
 * @see #setDisplayOrientation(int)
 * @see android.hardware.Camera.Parameters#setRotation(int)
 * @see android.hardware.Camera.Parameters#setPreviewSize(int, int)
 * @see android.hardware.Camera.Parameters#setPictureSize(int, int)
 * @see android.hardware.Camera.Parameters#setJpegThumbnailSize(int, int)
 * @apiSince 9
 * @deprecatedSince 21
 */

@Deprecated public int orientation;
}

/**
 * Callback interface for camera error notification.
 *
 * @see #setErrorCallback(ErrorCallback)
 *
 * @deprecated We recommend using the new {@link android.hardware.camera2} API for new
 *             applications.
 * @apiSince 1
 * @deprecatedSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface ErrorCallback {

/**
 * Callback for camera errors.
 * @param error   error code:
 * <ul>
 * <li>{@link #CAMERA_ERROR_UNKNOWN}
 * <li>{@link #CAMERA_ERROR_SERVER_DIED}
 * </ul>
 * @param camera  the Camera service object
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public void onError(int error, android.hardware.Camera camera);
}

/**
 * Information about a face identified through camera face detection.
 *
 * <p>When face detection is used with a camera, the {@link android.hardware.Camera.FaceDetectionListener FaceDetectionListener} returns a
 * list of face objects for use in focusing and metering.</p>
 *
 * @see android.hardware.Camera.FaceDetectionListener
 * @deprecated We recommend using the new {@link android.hardware.camera2} API for new
 *             applications.
 * @apiSince 14
 * @deprecatedSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static class Face {

/**
 * Create an empty face.
 * @apiSince 14
 */

@Deprecated
public Face() { throw new RuntimeException("Stub!"); }

/**
 * An unique id per face while the face is visible to the tracker. If
 * the face leaves the field-of-view and comes back, it will get a new
 * id. This is an optional field, may not be supported on all devices.
 * If not supported, id will always be set to -1. The optional fields
 * are supported as a set. Either they are all valid, or none of them
 * are.
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated public int id = -1; // 0xffffffff

/**
 * The coordinates of the center of the left eye. The coordinates are in
 * the same space as the ones for {@link #rect}. This is an optional
 * field, may not be supported on all devices. If not supported, the
 * value will always be set to null. The optional fields are supported
 * as a set. Either they are all valid, or none of them are.
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated public android.graphics.Point leftEye;

/**
 * The coordinates of the center of the mouth.  The coordinates are in
 * the same space as the ones for {@link #rect}. This is an optional
 * field, may not be supported on all devices. If not supported, the
 * value will always be set to null. The optional fields are supported
 * as a set. Either they are all valid, or none of them are.
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated public android.graphics.Point mouth;

/**
 * Bounds of the face. (-1000, -1000) represents the top-left of the
 * camera field of view, and (1000, 1000) represents the bottom-right of
 * the field of view. For example, suppose the size of the viewfinder UI
 * is 800x480. The rect passed from the driver is (-1000, -1000, 0, 0).
 * The corresponding viewfinder rect should be (0, 0, 400, 240). It is
 * guaranteed left < right and top < bottom. The coordinates can be
 * smaller than -1000 or bigger than 1000. But at least one vertex will
 * be within (-1000, -1000) and (1000, 1000).
 *
 * <p>The direction is relative to the sensor orientation, that is, what
 * the sensor sees. The direction is not affected by the rotation or
 * mirroring of {@link #setDisplayOrientation(int)}. The face bounding
 * rectangle does not provide any information about face orientation.</p>
 *
 * <p>Here is the matrix to convert driver coordinates to View coordinates
 * in pixels.</p>
 * <pre>
 * Matrix matrix = new Matrix();
 * CameraInfo info = CameraHolder.instance().getCameraInfo()[cameraId];
 * // Need mirror for front camera.
 * boolean mirror = (info.facing == CameraInfo.CAMERA_FACING_FRONT);
 * matrix.setScale(mirror ? -1 : 1, 1);
 * // This is the value for android.hardware.Camera.setDisplayOrientation.
 * matrix.postRotate(displayOrientation);
 * // Camera driver coordinates range from (-1000, -1000) to (1000, 1000).
 * // UI coordinates range from (0, 0) to (width, height).
 * matrix.postScale(view.getWidth() / 2000f, view.getHeight() / 2000f);
 * matrix.postTranslate(view.getWidth() / 2f, view.getHeight() / 2f);
 * </pre>
 *
 * @see #startFaceDetection()
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated public android.graphics.Rect rect;

/**
 * The coordinates of the center of the right eye. The coordinates are
 * in the same space as the ones for {@link #rect}.This is an optional
 * field, may not be supported on all devices. If not supported, the
 * value will always be set to null. The optional fields are supported
 * as a set. Either they are all valid, or none of them are.
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated public android.graphics.Point rightEye;

/**
 * <p>The confidence level for the detection of the face. The range is 1 to
 * 100. 100 is the highest confidence.</p>
 *
 * <p>Depending on the device, even very low-confidence faces may be
 * listed, so applications should filter out faces with low confidence,
 * depending on the use case. For a typical point-and-shoot camera
 * application that wishes to display rectangles around detected faces,
 * filtering out faces with confidence less than 50 is recommended.</p>
 *
 * @see #startFaceDetection()
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated public int score;
}

/**
 * Callback interface for face detected in the preview frame.
 *
 * @deprecated We recommend using the new {@link android.hardware.camera2} API for new
 *             applications.
 * @apiSince 14
 * @deprecatedSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface FaceDetectionListener {

/**
 * Notify the listener of the detected faces in the preview frame.
 *
 * @param faces The detected faces in a list
 * @param camera  The {@link android.hardware.Camera Camera} service object
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated
public void onFaceDetection(android.hardware.Camera.Face[] faces, android.hardware.Camera camera);
}

/**
 * Callback interface for zoom changes during a smooth zoom operation.
 *
 * @see #setZoomChangeListener(OnZoomChangeListener)
 * @see #startSmoothZoom(int)
 *
 * @deprecated We recommend using the new {@link android.hardware.camera2} API for new
 *             applications.
 * @apiSince 8
 * @deprecatedSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface OnZoomChangeListener {

/**
 * Called when the zoom value has changed during a smooth zoom.
 *
 * @param zoomValue the current zoom value. In smooth zoom mode, camera
 *                  calls this for every new zoom value.
 * @param stopped whether smooth zoom is stopped. If the value is true,
 *                this is the last zoom update for the application.
 * @param camera  the Camera service object
 * @apiSince 8
 * @deprecatedSince 21
 */

@Deprecated
public void onZoomChange(int zoomValue, boolean stopped, android.hardware.Camera camera);
}

/**
 * Camera service settings.
 *
 * <p>To make camera parameters take effect, applications have to call
 * {@link android.hardware.Camera#setParameters(android.hardware.Camera.Parameters) Camera#setParameters(Camera.Parameters)}. For example, after
 * {@link android.hardware.Camera.Parameters#setWhiteBalance Camera.Parameters#setWhiteBalance} is called, white balance is not
 * actually changed until {@link android.hardware.Camera#setParameters(android.hardware.Camera.Parameters) Camera#setParameters(Camera.Parameters)}
 * is called with the changed parameters object.
 *
 * <p>Different devices may have different camera capabilities, such as
 * picture size or flash modes. The application should query the camera
 * capabilities before setting parameters. For example, the application
 * should call {@link android.hardware.Camera.Parameters#getSupportedColorEffects() Camera.Parameters#getSupportedColorEffects()} before
 * calling {@link android.hardware.Camera.Parameters#setColorEffect(java.lang.String) Camera.Parameters#setColorEffect(String)}. If the
 * camera does not support color effects,
 * {@link android.hardware.Camera.Parameters#getSupportedColorEffects() Camera.Parameters#getSupportedColorEffects()} will return null.
 *
 * @deprecated We recommend using the new {@link android.hardware.camera2} API for new
 *             applications.
 * @apiSince 1
 * @deprecatedSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class Parameters {

private Parameters() { throw new RuntimeException("Stub!"); }

/**
 * Creates a single string with all the parameters set in
 * this Parameters object.
 * <p>The {@link #unflatten(java.lang.String)} method does the reverse.</p>
 *
 * @return a String with all values from this Parameters object, in
 *         semi-colon delimited key-value pairs
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public java.lang.String flatten() { throw new RuntimeException("Stub!"); }

/**
 * Takes a flattened string of parameters and adds each one to
 * this Parameters object.
 * <p>The {@link #flatten()} method does the reverse.</p>
 *
 * @param flattened a String of parameters (key-value paired) that
 *                  are semi-colon delimited
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public void unflatten(java.lang.String flattened) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public void remove(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Sets a String parameter.
 *
 * @param key   the key name for the parameter
 * @param value the String value of the parameter
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public void set(java.lang.String key, java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Sets an integer parameter.
 *
 * @param key   the key name for the parameter
 * @param value the int value of the parameter
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public void set(java.lang.String key, int value) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of a String parameter.
 *
 * @param key the key name for the parameter
 * @return the String value of the parameter
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public java.lang.String get(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of an integer parameter.
 *
 * @param key the key name for the parameter
 * @return the int value of the parameter
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public int getInt(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Sets the dimensions for preview pictures. If the preview has already
 * started, applications should stop the preview first before changing
 * preview size.
 *
 * The sides of width and height are based on camera orientation. That
 * is, the preview size is the size before it is rotated by display
 * orientation. So applications need to consider the display orientation
 * while setting preview size. For example, suppose the camera supports
 * both 480x320 and 320x480 preview sizes. The application wants a 3:2
 * preview ratio. If the display orientation is set to 0 or 180, preview
 * size should be set to 480x320. If the display orientation is set to
 * 90 or 270, preview size should be set to 320x480. The display
 * orientation should also be considered while setting picture size and
 * thumbnail size.
 *
 * Exception on 176x144 (QCIF) resolution:
 * Camera devices usually have a fixed capability for downscaling from
 * larger resolution to smaller, and the QCIF resolution sometimes
 * is not fully supported due to this limitation on devices with
 * high-resolution image sensors. Therefore, trying to configure a QCIF
 * preview size with any picture or video size larger than 1920x1080
 * (either width or height) might not be supported, and
 * {@link #setParameters(android.hardware.Camera.Parameters)} might throw a
 * RuntimeException if it is not.
 *
 * @param width  the width of the pictures, in pixels
 * @param height the height of the pictures, in pixels
 * @see #setDisplayOrientation(int)
 * @see #getCameraInfo(int, CameraInfo)
 * @see #setPictureSize(int, int)
 * @see #setJpegThumbnailSize(int, int)
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public void setPreviewSize(int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * Returns the dimensions setting for preview pictures.
 *
 * @return a Size object with the width and height setting
 *          for the preview picture
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public android.hardware.Camera.Size getPreviewSize() { throw new RuntimeException("Stub!"); }

/**
 * Gets the supported preview sizes.
 *
 * @return a list of Size object. This method will always return a list
 *         with at least one element.
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public java.util.List<android.hardware.Camera.Size> getSupportedPreviewSizes() { throw new RuntimeException("Stub!"); }

/**
 * <p>Gets the supported video frame sizes that can be used by
 * MediaRecorder.</p>
 *
 * <p>If the returned list is not null, the returned list will contain at
 * least one Size and one of the sizes in the returned list must be
 * passed to MediaRecorder.setVideoSize() for camcorder application if
 * camera is used as the video source. In this case, the size of the
 * preview can be different from the resolution of the recorded video
 * during video recording.</p>
 *
 * <p>Exception on 176x144 (QCIF) resolution:
 * Camera devices usually have a fixed capability for downscaling from
 * larger resolution to smaller, and the QCIF resolution sometimes
 * is not fully supported due to this limitation on devices with
 * high-resolution image sensors. Therefore, trying to configure a QCIF
 * video resolution with any preview or picture size larger than
 * 1920x1080  (either width or height) might not be supported, and
 * {@link #setParameters(android.hardware.Camera.Parameters)} will throw a
 * RuntimeException if it is not.</p>
 *
 * @return a list of Size object if camera has separate preview and
 *         video output; otherwise, null is returned.
 * @see #getPreferredPreviewSizeForVideo()
 * @apiSince 11
 * @deprecatedSince 21
 */

@Deprecated
public java.util.List<android.hardware.Camera.Size> getSupportedVideoSizes() { throw new RuntimeException("Stub!"); }

/**
 * Returns the preferred or recommended preview size (width and height)
 * in pixels for video recording. Camcorder applications should
 * set the preview size to a value that is not larger than the
 * preferred preview size. In other words, the product of the width
 * and height of the preview size should not be larger than that of
 * the preferred preview size. In addition, we recommend to choose a
 * preview size that has the same aspect ratio as the resolution of
 * video to be recorded.
 *
 * @return the preferred preview size (width and height) in pixels for
 *         video recording if getSupportedVideoSizes() does not return
 *         null; otherwise, null is returned.
 * @see #getSupportedVideoSizes()
 * @apiSince 11
 * @deprecatedSince 21
 */

@Deprecated
public android.hardware.Camera.Size getPreferredPreviewSizeForVideo() { throw new RuntimeException("Stub!"); }

/**
 * <p>Sets the dimensions for EXIF thumbnail in Jpeg picture. If
 * applications set both width and height to 0, EXIF will not contain
 * thumbnail.</p>
 *
 * <p>Applications need to consider the display orientation. See {@link
 * #setPreviewSize(int,int)} for reference.</p>
 *
 * @param width  the width of the thumbnail, in pixels
 * @param height the height of the thumbnail, in pixels
 * @see #setPreviewSize(int,int)
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public void setJpegThumbnailSize(int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * Returns the dimensions for EXIF thumbnail in Jpeg picture.
 *
 * @return a Size object with the height and width setting for the EXIF
 *         thumbnails
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public android.hardware.Camera.Size getJpegThumbnailSize() { throw new RuntimeException("Stub!"); }

/**
 * Gets the supported jpeg thumbnail sizes.
 *
 * @return a list of Size object. This method will always return a list
 *         with at least two elements. Size 0,0 (no thumbnail) is always
 *         supported.
 * @apiSince 8
 * @deprecatedSince 21
 */

@Deprecated
public java.util.List<android.hardware.Camera.Size> getSupportedJpegThumbnailSizes() { throw new RuntimeException("Stub!"); }

/**
 * Sets the quality of the EXIF thumbnail in Jpeg picture.
 *
 * @param quality the JPEG quality of the EXIF thumbnail. The range is 1
 *                to 100, with 100 being the best.
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public void setJpegThumbnailQuality(int quality) { throw new RuntimeException("Stub!"); }

/**
 * Returns the quality setting for the EXIF thumbnail in Jpeg picture.
 *
 * @return the JPEG quality setting of the EXIF thumbnail.
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public int getJpegThumbnailQuality() { throw new RuntimeException("Stub!"); }

/**
 * Sets Jpeg quality of captured picture.
 *
 * @param quality the JPEG quality of captured picture. The range is 1
 *                to 100, with 100 being the best.
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public void setJpegQuality(int quality) { throw new RuntimeException("Stub!"); }

/**
 * Returns the quality setting for the JPEG picture.
 *
 * @return the JPEG picture quality setting.
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public int getJpegQuality() { throw new RuntimeException("Stub!"); }

/**
 * Sets the rate at which preview frames are received. This is the
 * target frame rate. The actual frame rate depends on the driver.
 *
 * @param fps the frame rate (frames per second)
 * @deprecated replaced by {@link #setPreviewFpsRange(int,int)}
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public void setPreviewFrameRate(int fps) { throw new RuntimeException("Stub!"); }

/**
 * Returns the setting for the rate at which preview frames are
 * received. This is the target frame rate. The actual frame rate
 * depends on the driver.
 *
 * @return the frame rate setting (frames per second)
 * @deprecated replaced by {@link #getPreviewFpsRange(int[])}
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
public int getPreviewFrameRate() { throw new RuntimeException("Stub!"); }

/**
 * Gets the supported preview frame rates.
 *
 * @return a list of supported preview frame rates. null if preview
 *         frame rate setting is not supported.
 * @deprecated replaced by {@link #getSupportedPreviewFpsRange()}
 * @apiSince 5
 * @deprecatedSince 15
 */

@Deprecated
public java.util.List<java.lang.Integer> getSupportedPreviewFrameRates() { throw new RuntimeException("Stub!"); }

/**
 * Sets the minimum and maximum preview fps. This controls the rate of
 * preview frames received in {@link android.hardware.Camera.PreviewCallback PreviewCallback}. The minimum and
 * maximum preview fps must be one of the elements from {@link
 * #getSupportedPreviewFpsRange}.
 *
 * @param min the minimum preview fps (scaled by 1000).
 * @param max the maximum preview fps (scaled by 1000).
 * @throws java.lang.RuntimeException if fps range is invalid.
 * @see #setPreviewCallbackWithBuffer(Camera.PreviewCallback)
 * @see #getSupportedPreviewFpsRange()
 * @apiSince 9
 * @deprecatedSince 21
 */

@Deprecated
public void setPreviewFpsRange(int min, int max) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current minimum and maximum preview fps. The values are
 * one of the elements returned by {@link #getSupportedPreviewFpsRange}.
 *
 * @return range the minimum and maximum preview fps (scaled by 1000).
 * @see #PREVIEW_FPS_MIN_INDEX
 * @see #PREVIEW_FPS_MAX_INDEX
 * @see #getSupportedPreviewFpsRange()
 * @apiSince 9
 * @deprecatedSince 21
 */

@Deprecated
public void getPreviewFpsRange(int[] range) { throw new RuntimeException("Stub!"); }

/**
 * Gets the supported preview fps (frame-per-second) ranges. Each range
 * contains a minimum fps and maximum fps. If minimum fps equals to
 * maximum fps, the camera outputs frames in fixed frame rate. If not,
 * the camera outputs frames in auto frame rate. The actual frame rate
 * fluctuates between the minimum and the maximum. The values are
 * multiplied by 1000 and represented in integers. For example, if frame
 * rate is 26.623 frames per second, the value is 26623.
 *
 * @return a list of supported preview fps ranges. This method returns a
 *         list with at least one element. Every element is an int array
 *         of two values - minimum fps and maximum fps. The list is
 *         sorted from small to large (first by maximum fps and then
 *         minimum fps).
 * @see #PREVIEW_FPS_MIN_INDEX
 * @see #PREVIEW_FPS_MAX_INDEX
 * @apiSince 9
 * @deprecatedSince 21
 */

@Deprecated
public java.util.List<int[]> getSupportedPreviewFpsRange() { throw new RuntimeException("Stub!"); }

/**
 * Sets the image format for preview pictures.
 * <p>If this is never called, the default format will be
 * {@link android.graphics.ImageFormat#NV21}, which
 * uses the NV21 encoding format.</p>
 *
 * <p>Use {@link android.hardware.Camera.Parameters#getSupportedPreviewFormats Parameters#getSupportedPreviewFormats} to get a list of
 * the available preview formats.
 *
 * <p>It is strongly recommended that either
 * {@link android.graphics.ImageFormat#NV21} or
 * {@link android.graphics.ImageFormat#YV12} is used, since
 * they are supported by all camera devices.</p>
 *
 * <p>For YV12, the image buffer that is received is not necessarily
 * tightly packed, as there may be padding at the end of each row of
 * pixel data, as described in
 * {@link android.graphics.ImageFormat#YV12}. For camera callback data,
 * it can be assumed that the stride of the Y and UV data is the
 * smallest possible that meets the alignment requirements. That is, if
 * the preview size is <var>width x height</var>, then the following
 * equations describe the buffer index for the beginning of row
 * <var>y</var> for the Y plane and row <var>c</var> for the U and V
 * planes:
 *
 * <pre>{@code
 * yStride   = (int) ceil(width / 16.0) * 16;
 * uvStride  = (int) ceil( (yStride / 2) / 16.0) * 16;
 * ySize     = yStride * height;
 * uvSize    = uvStride * height / 2;
 * yRowIndex = yStride * y;
 * uRowIndex = ySize + uvSize + uvStride * c;
 * vRowIndex = ySize + uvStride * c;
 * size      = ySize + uvSize * 2;
 * }
 *</pre>
 *
 * @param pixel_format the desired preview picture format, defined by
 *   one of the {@link android.graphics.ImageFormat} constants.  (E.g.,
 *   <var>ImageFormat.NV21</var> (default), or
 *   <var>ImageFormat.YV12</var>)
 *
 * @see android.graphics.ImageFormat
 * @see android.hardware.Camera.Parameters#getSupportedPreviewFormats
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public void setPreviewFormat(int pixel_format) { throw new RuntimeException("Stub!"); }

/**
 * Returns the image format for preview frames got from
 * {@link android.hardware.Camera.PreviewCallback PreviewCallback}.
 *
 * @return the preview format.
 * @see android.graphics.ImageFormat
 * @see #setPreviewFormat
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public int getPreviewFormat() { throw new RuntimeException("Stub!"); }

/**
 * Gets the supported preview formats. {@link android.graphics.ImageFormat#NV21}
 * is always supported. {@link android.graphics.ImageFormat#YV12}
 * is always supported since API level 12.
 *
 * @return a list of supported preview formats. This method will always
 *         return a list with at least one element.
 * @see android.graphics.ImageFormat
 * @see #setPreviewFormat
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public java.util.List<java.lang.Integer> getSupportedPreviewFormats() { throw new RuntimeException("Stub!"); }

/**
 * <p>Sets the dimensions for pictures.</p>
 *
 * <p>Applications need to consider the display orientation. See {@link
 * #setPreviewSize(int,int)} for reference.</p>
 *
 * <p>Exception on 176x144 (QCIF) resolution:
 * Camera devices usually have a fixed capability for downscaling from
 * larger resolution to smaller, and the QCIF resolution sometimes
 * is not fully supported due to this limitation on devices with
 * high-resolution image sensors. Therefore, trying to configure a QCIF
 * picture size with any preview or video size larger than 1920x1080
 * (either width or height) might not be supported, and
 * {@link #setParameters(android.hardware.Camera.Parameters)} might throw a
 * RuntimeException if it is not.</p>
 *
 * @param width  the width for pictures, in pixels
 * @param height the height for pictures, in pixels
 * @see #setPreviewSize(int,int)
 *
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public void setPictureSize(int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * Returns the dimension setting for pictures.
 *
 * @return a Size object with the height and width setting
 *          for pictures
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public android.hardware.Camera.Size getPictureSize() { throw new RuntimeException("Stub!"); }

/**
 * Gets the supported picture sizes.
 *
 * @return a list of supported picture sizes. This method will always
 *         return a list with at least one element.
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public java.util.List<android.hardware.Camera.Size> getSupportedPictureSizes() { throw new RuntimeException("Stub!"); }

/**
 * Sets the image format for pictures.
 *
 * @param pixel_format the desired picture format
 *                     (<var>ImageFormat.NV21</var>,
 *                      <var>ImageFormat.RGB_565</var>, or
 *                      <var>ImageFormat.JPEG</var>)
 * @see android.graphics.ImageFormat
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public void setPictureFormat(int pixel_format) { throw new RuntimeException("Stub!"); }

/**
 * Returns the image format for pictures.
 *
 * @return the picture format
 * @see android.graphics.ImageFormat
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public int getPictureFormat() { throw new RuntimeException("Stub!"); }

/**
 * Gets the supported picture formats.
 *
 * @return supported picture formats. This method will always return a
 *         list with at least one element.
 * @see android.graphics.ImageFormat
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public java.util.List<java.lang.Integer> getSupportedPictureFormats() { throw new RuntimeException("Stub!"); }

/**
 * Sets the clockwise rotation angle in degrees relative to the
 * orientation of the camera. This affects the pictures returned from
 * JPEG {@link android.hardware.Camera.PictureCallback PictureCallback}. The camera driver may set orientation
 * in the EXIF header without rotating the picture. Or the driver may
 * rotate the picture and the EXIF thumbnail. If the Jpeg picture is
 * rotated, the orientation in the EXIF header will be missing or 1 (row
 * #0 is top and column #0 is left side).
 *
 * <p>
 * If applications want to rotate the picture to match the orientation
 * of what users see, apps should use
 * {@link android.view.OrientationEventListener} and
 * {@link android.hardware.Camera.CameraInfo}. The value from
 * OrientationEventListener is relative to the natural orientation of
 * the device. CameraInfo.orientation is the angle between camera
 * orientation and natural device orientation. The sum of the two is the
 * rotation angle for back-facing camera. The difference of the two is
 * the rotation angle for front-facing camera. Note that the JPEG
 * pictures of front-facing cameras are not mirrored as in preview
 * display.
 *
 * <p>
 * For example, suppose the natural orientation of the device is
 * portrait. The device is rotated 270 degrees clockwise, so the device
 * orientation is 270. Suppose a back-facing camera sensor is mounted in
 * landscape and the top side of the camera sensor is aligned with the
 * right edge of the display in natural orientation. So the camera
 * orientation is 90. The rotation should be set to 0 (270 + 90).
 *
 * <p>The reference code is as follows.
 *
 * <pre>
 * public void onOrientationChanged(int orientation) {
 *     if (orientation == ORIENTATION_UNKNOWN) return;
 *     android.hardware.Camera.CameraInfo info =
 *            new android.hardware.Camera.CameraInfo();
 *     android.hardware.Camera.getCameraInfo(cameraId, info);
 *     orientation = (orientation + 45) / 90 * 90;
 *     int rotation = 0;
 *     if (info.facing == CameraInfo.CAMERA_FACING_FRONT) {
 *         rotation = (info.orientation - orientation + 360) % 360;
 *     } else {  // back-facing camera
 *         rotation = (info.orientation + orientation) % 360;
 *     }
 *     mParameters.setRotation(rotation);
 * }
 * </pre>
 *
 * @param rotation The rotation angle in degrees relative to the
 *                 orientation of the camera. Rotation can only be 0,
 *                 90, 180 or 270.
 * @throws java.lang.IllegalArgumentException if rotation value is invalid.
 * @see android.view.OrientationEventListener
 * @see #getCameraInfo(int, CameraInfo)
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public void setRotation(int rotation) { throw new RuntimeException("Stub!"); }

/**
 * Sets GPS latitude coordinate. This will be stored in JPEG EXIF
 * header.
 *
 * @param latitude GPS latitude coordinate.
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public void setGpsLatitude(double latitude) { throw new RuntimeException("Stub!"); }

/**
 * Sets GPS longitude coordinate. This will be stored in JPEG EXIF
 * header.
 *
 * @param longitude GPS longitude coordinate.
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public void setGpsLongitude(double longitude) { throw new RuntimeException("Stub!"); }

/**
 * Sets GPS altitude. This will be stored in JPEG EXIF header.
 *
 * @param altitude GPS altitude in meters.
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public void setGpsAltitude(double altitude) { throw new RuntimeException("Stub!"); }

/**
 * Sets GPS timestamp. This will be stored in JPEG EXIF header.
 *
 * @param timestamp GPS timestamp (UTC in seconds since January 1,
 *                  1970).
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public void setGpsTimestamp(long timestamp) { throw new RuntimeException("Stub!"); }

/**
 * Sets GPS processing method. The method will be stored in a UTF-8 string up to 31 bytes
 * long, in the JPEG EXIF header.
 *
 * @param processing_method The processing method to get this location.
 * @apiSince 8
 * @deprecatedSince 21
 */

@Deprecated
public void setGpsProcessingMethod(java.lang.String processing_method) { throw new RuntimeException("Stub!"); }

/**
 * Removes GPS latitude, longitude, altitude, and timestamp from the
 * parameters.
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public void removeGpsData() { throw new RuntimeException("Stub!"); }

/**
 * Gets the current white balance setting.
 *
 * @return current white balance. null if white balance setting is not
 *         supported.
 * @see #WHITE_BALANCE_AUTO
 * @see #WHITE_BALANCE_INCANDESCENT
 * @see #WHITE_BALANCE_FLUORESCENT
 * @see #WHITE_BALANCE_WARM_FLUORESCENT
 * @see #WHITE_BALANCE_DAYLIGHT
 * @see #WHITE_BALANCE_CLOUDY_DAYLIGHT
 * @see #WHITE_BALANCE_TWILIGHT
 * @see #WHITE_BALANCE_SHADE
 *
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public java.lang.String getWhiteBalance() { throw new RuntimeException("Stub!"); }

/**
 * Sets the white balance. Changing the setting will release the
 * auto-white balance lock. It is recommended not to change white
 * balance and AWB lock at the same time.
 *
 * @param value new white balance.
 * @see #getWhiteBalance()
 * @see #setAutoWhiteBalanceLock(boolean)
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public void setWhiteBalance(java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Gets the supported white balance.
 *
 * @return a list of supported white balance. null if white balance
 *         setting is not supported.
 * @see #getWhiteBalance()
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public java.util.List<java.lang.String> getSupportedWhiteBalance() { throw new RuntimeException("Stub!"); }

/**
 * Gets the current color effect setting.
 *
 * @return current color effect. null if color effect
 *         setting is not supported.
 * @see #EFFECT_NONE
 * @see #EFFECT_MONO
 * @see #EFFECT_NEGATIVE
 * @see #EFFECT_SOLARIZE
 * @see #EFFECT_SEPIA
 * @see #EFFECT_POSTERIZE
 * @see #EFFECT_WHITEBOARD
 * @see #EFFECT_BLACKBOARD
 * @see #EFFECT_AQUA
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public java.lang.String getColorEffect() { throw new RuntimeException("Stub!"); }

/**
 * Sets the current color effect setting.
 *
 * @param value new color effect.
 * @see #getColorEffect()
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public void setColorEffect(java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Gets the supported color effects.
 *
 * @return a list of supported color effects. null if color effect
 *         setting is not supported.
 * @see #getColorEffect()
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public java.util.List<java.lang.String> getSupportedColorEffects() { throw new RuntimeException("Stub!"); }

/**
 * Gets the current antibanding setting.
 *
 * @return current antibanding. null if antibanding setting is not
 *         supported.
 * @see #ANTIBANDING_AUTO
 * @see #ANTIBANDING_50HZ
 * @see #ANTIBANDING_60HZ
 * @see #ANTIBANDING_OFF
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public java.lang.String getAntibanding() { throw new RuntimeException("Stub!"); }

/**
 * Sets the antibanding.
 *
 * @param antibanding new antibanding value.
 * @see #getAntibanding()
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public void setAntibanding(java.lang.String antibanding) { throw new RuntimeException("Stub!"); }

/**
 * Gets the supported antibanding values.
 *
 * @return a list of supported antibanding values. null if antibanding
 *         setting is not supported.
 * @see #getAntibanding()
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public java.util.List<java.lang.String> getSupportedAntibanding() { throw new RuntimeException("Stub!"); }

/**
 * Gets the current scene mode setting.
 *
 * @return one of SCENE_MODE_XXX string constant. null if scene mode
 *         setting is not supported.
 * @see #SCENE_MODE_AUTO
 * @see #SCENE_MODE_ACTION
 * @see #SCENE_MODE_PORTRAIT
 * @see #SCENE_MODE_LANDSCAPE
 * @see #SCENE_MODE_NIGHT
 * @see #SCENE_MODE_NIGHT_PORTRAIT
 * @see #SCENE_MODE_THEATRE
 * @see #SCENE_MODE_BEACH
 * @see #SCENE_MODE_SNOW
 * @see #SCENE_MODE_SUNSET
 * @see #SCENE_MODE_STEADYPHOTO
 * @see #SCENE_MODE_FIREWORKS
 * @see #SCENE_MODE_SPORTS
 * @see #SCENE_MODE_PARTY
 * @see #SCENE_MODE_CANDLELIGHT
 * @see #SCENE_MODE_BARCODE
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public java.lang.String getSceneMode() { throw new RuntimeException("Stub!"); }

/**
 * Sets the scene mode. Changing scene mode may override other
 * parameters (such as flash mode, focus mode, white balance). For
 * example, suppose originally flash mode is on and supported flash
 * modes are on/off. In night scene mode, both flash mode and supported
 * flash mode may be changed to off. After setting scene mode,
 * applications should call getParameters to know if some parameters are
 * changed.
 *
 * @param value scene mode.
 * @see #getSceneMode()
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public void setSceneMode(java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Gets the supported scene modes.
 *
 * @return a list of supported scene modes. null if scene mode setting
 *         is not supported.
 * @see #getSceneMode()
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public java.util.List<java.lang.String> getSupportedSceneModes() { throw new RuntimeException("Stub!"); }

/**
 * Gets the current flash mode setting.
 *
 * @return current flash mode. null if flash mode setting is not
 *         supported.
 * @see #FLASH_MODE_OFF
 * @see #FLASH_MODE_AUTO
 * @see #FLASH_MODE_ON
 * @see #FLASH_MODE_RED_EYE
 * @see #FLASH_MODE_TORCH
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public java.lang.String getFlashMode() { throw new RuntimeException("Stub!"); }

/**
 * Sets the flash mode.
 *
 * @param value flash mode.
 * @see #getFlashMode()
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public void setFlashMode(java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Gets the supported flash modes.
 *
 * @return a list of supported flash modes. null if flash mode setting
 *         is not supported.
 * @see #getFlashMode()
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public java.util.List<java.lang.String> getSupportedFlashModes() { throw new RuntimeException("Stub!"); }

/**
 * Gets the current focus mode setting.
 *
 * @return current focus mode. This method will always return a non-null
 *         value. Applications should call {@link
 *         #autoFocus(android.hardware.Camera.AutoFocusCallback)} to start the focus if focus
 *         mode is FOCUS_MODE_AUTO or FOCUS_MODE_MACRO.
 * @see #FOCUS_MODE_AUTO
 * @see #FOCUS_MODE_INFINITY
 * @see #FOCUS_MODE_MACRO
 * @see #FOCUS_MODE_FIXED
 * @see #FOCUS_MODE_EDOF
 * @see #FOCUS_MODE_CONTINUOUS_VIDEO
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public java.lang.String getFocusMode() { throw new RuntimeException("Stub!"); }

/**
 * Sets the focus mode.
 *
 * @param value focus mode.
 * @see #getFocusMode()
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public void setFocusMode(java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Gets the supported focus modes.
 *
 * @return a list of supported focus modes. This method will always
 *         return a list with at least one element.
 * @see #getFocusMode()
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated
public java.util.List<java.lang.String> getSupportedFocusModes() { throw new RuntimeException("Stub!"); }

/**
 * Gets the focal length (in millimeter) of the camera.
 *
 * @return the focal length. Returns -1.0 when the device
 *         doesn't report focal length information.
 * @apiSince 8
 * @deprecatedSince 21
 */

@Deprecated
public float getFocalLength() { throw new RuntimeException("Stub!"); }

/**
 * Gets the horizontal angle of view in degrees.
 *
 * @return horizontal angle of view. Returns -1.0 when the device
 *         doesn't report view angle information.
 * @apiSince 8
 * @deprecatedSince 21
 */

@Deprecated
public float getHorizontalViewAngle() { throw new RuntimeException("Stub!"); }

/**
 * Gets the vertical angle of view in degrees.
 *
 * @return vertical angle of view. Returns -1.0 when the device
 *         doesn't report view angle information.
 * @apiSince 8
 * @deprecatedSince 21
 */

@Deprecated
public float getVerticalViewAngle() { throw new RuntimeException("Stub!"); }

/**
 * Gets the current exposure compensation index.
 *
 * @return current exposure compensation index. The range is {@link
 *         #getMinExposureCompensation} to {@link
 *         #getMaxExposureCompensation}. 0 means exposure is not
 *         adjusted.
 * @apiSince 8
 * @deprecatedSince 21
 */

@Deprecated
public int getExposureCompensation() { throw new RuntimeException("Stub!"); }

/**
 * Sets the exposure compensation index.
 *
 * @param value exposure compensation index. The valid value range is
 *        from {@link #getMinExposureCompensation} (inclusive) to {@link
 *        #getMaxExposureCompensation} (inclusive). 0 means exposure is
 *        not adjusted. Application should call
 *        getMinExposureCompensation and getMaxExposureCompensation to
 *        know if exposure compensation is supported.
 * @apiSince 8
 * @deprecatedSince 21
 */

@Deprecated
public void setExposureCompensation(int value) { throw new RuntimeException("Stub!"); }

/**
 * Gets the maximum exposure compensation index.
 *
 * @return maximum exposure compensation index (>=0). If both this
 *         method and {@link #getMinExposureCompensation} return 0,
 *         exposure compensation is not supported.
 * @apiSince 8
 * @deprecatedSince 21
 */

@Deprecated
public int getMaxExposureCompensation() { throw new RuntimeException("Stub!"); }

/**
 * Gets the minimum exposure compensation index.
 *
 * @return minimum exposure compensation index (<=0). If both this
 *         method and {@link #getMaxExposureCompensation} return 0,
 *         exposure compensation is not supported.
 * @apiSince 8
 * @deprecatedSince 21
 */

@Deprecated
public int getMinExposureCompensation() { throw new RuntimeException("Stub!"); }

/**
 * Gets the exposure compensation step.
 *
 * @return exposure compensation step. Applications can get EV by
 *         multiplying the exposure compensation index and step. Ex: if
 *         exposure compensation index is -6 and step is 0.333333333, EV
 *         is -2.
 * @apiSince 8
 * @deprecatedSince 21
 */

@Deprecated
public float getExposureCompensationStep() { throw new RuntimeException("Stub!"); }

/**
 * <p>Sets the auto-exposure lock state. Applications should check
 * {@link #isAutoExposureLockSupported} before using this method.</p>
 *
 * <p>If set to true, the camera auto-exposure routine will immediately
 * pause until the lock is set to false. Exposure compensation settings
 * changes will still take effect while auto-exposure is locked.</p>
 *
 * <p>If auto-exposure is already locked, setting this to true again has
 * no effect (the driver will not recalculate exposure values).</p>
 *
 * <p>Stopping preview with {@link #stopPreview()}, or triggering still
 * image capture with {@link #takePicture(android.hardware.Camera.ShutterCallback,android.hardware.Camera.PictureCallback,android.hardware.Camera.PictureCallback)}, will not change the
 * lock.</p>
 *
 * <p>Exposure compensation, auto-exposure lock, and auto-white balance
 * lock can be used to capture an exposure-bracketed burst of images,
 * for example.</p>
 *
 * <p>Auto-exposure state, including the lock state, will not be
 * maintained after camera {@link #release()} is called.  Locking
 * auto-exposure after {@link #open()} but before the first call to
 * {@link #startPreview()} will not allow the auto-exposure routine to
 * run at all, and may result in severely over- or under-exposed
 * images.</p>
 *
 * @param toggle new state of the auto-exposure lock. True means that
 *        auto-exposure is locked, false means that the auto-exposure
 *        routine is free to run normally.
 *
 * @see #getAutoExposureLock()
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated
public void setAutoExposureLock(boolean toggle) { throw new RuntimeException("Stub!"); }

/**
 * Gets the state of the auto-exposure lock. Applications should check
 * {@link #isAutoExposureLockSupported} before using this method. See
 * {@link #setAutoExposureLock} for details about the lock.
 *
 * @return State of the auto-exposure lock. Returns true if
 *         auto-exposure is currently locked, and false otherwise.
 *
 * @see #setAutoExposureLock(boolean)
 *
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated
public boolean getAutoExposureLock() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if auto-exposure locking is supported. Applications
 * should call this before trying to lock auto-exposure. See
 * {@link #setAutoExposureLock} for details about the lock.
 *
 * @return true if auto-exposure lock is supported.
 * @see #setAutoExposureLock(boolean)
 *
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated
public boolean isAutoExposureLockSupported() { throw new RuntimeException("Stub!"); }

/**
 * <p>Sets the auto-white balance lock state. Applications should check
 * {@link #isAutoWhiteBalanceLockSupported} before using this
 * method.</p>
 *
 * <p>If set to true, the camera auto-white balance routine will
 * immediately pause until the lock is set to false.</p>
 *
 * <p>If auto-white balance is already locked, setting this to true
 * again has no effect (the driver will not recalculate white balance
 * values).</p>
 *
 * <p>Stopping preview with {@link #stopPreview()}, or triggering still
 * image capture with {@link #takePicture(android.hardware.Camera.ShutterCallback,android.hardware.Camera.PictureCallback,android.hardware.Camera.PictureCallback)}, will not change the
 * the lock.</p>
 *
 * <p> Changing the white balance mode with {@link #setWhiteBalance}
 * will release the auto-white balance lock if it is set.</p>
 *
 * <p>Exposure compensation, AE lock, and AWB lock can be used to
 * capture an exposure-bracketed burst of images, for example.
 * Auto-white balance state, including the lock state, will not be
 * maintained after camera {@link #release()} is called.  Locking
 * auto-white balance after {@link #open()} but before the first call to
 * {@link #startPreview()} will not allow the auto-white balance routine
 * to run at all, and may result in severely incorrect color in captured
 * images.</p>
 *
 * @param toggle new state of the auto-white balance lock. True means
 *        that auto-white balance is locked, false means that the
 *        auto-white balance routine is free to run normally.
 *
 * @see #getAutoWhiteBalanceLock()
 * @see #setWhiteBalance(String)
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated
public void setAutoWhiteBalanceLock(boolean toggle) { throw new RuntimeException("Stub!"); }

/**
 * Gets the state of the auto-white balance lock. Applications should
 * check {@link #isAutoWhiteBalanceLockSupported} before using this
 * method. See {@link #setAutoWhiteBalanceLock} for details about the
 * lock.
 *
 * @return State of the auto-white balance lock. Returns true if
 *         auto-white balance is currently locked, and false
 *         otherwise.
 *
 * @see #setAutoWhiteBalanceLock(boolean)
 *
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated
public boolean getAutoWhiteBalanceLock() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if auto-white balance locking is supported. Applications
 * should call this before trying to lock auto-white balance. See
 * {@link #setAutoWhiteBalanceLock} for details about the lock.
 *
 * @return true if auto-white balance lock is supported.
 * @see #setAutoWhiteBalanceLock(boolean)
 *
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated
public boolean isAutoWhiteBalanceLockSupported() { throw new RuntimeException("Stub!"); }

/**
 * Gets current zoom value. This also works when smooth zoom is in
 * progress. Applications should check {@link #isZoomSupported} before
 * using this method.
 *
 * @return the current zoom value. The range is 0 to {@link
 *         #getMaxZoom}. 0 means the camera is not zoomed.
 * @apiSince 8
 * @deprecatedSince 21
 */

@Deprecated
public int getZoom() { throw new RuntimeException("Stub!"); }

/**
 * Sets current zoom value. If the camera is zoomed (value > 0), the
 * actual picture size may be smaller than picture size setting.
 * Applications can check the actual picture size after picture is
 * returned from {@link android.hardware.Camera.PictureCallback PictureCallback}. The preview size remains the
 * same in zoom. Applications should check {@link #isZoomSupported}
 * before using this method.
 *
 * @param value zoom value. The valid range is 0 to {@link #getMaxZoom}.
 * @apiSince 8
 * @deprecatedSince 21
 */

@Deprecated
public void setZoom(int value) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if zoom is supported. Applications should call this
 * before using other zoom methods.
 *
 * @return true if zoom is supported.
 * @apiSince 8
 * @deprecatedSince 21
 */

@Deprecated
public boolean isZoomSupported() { throw new RuntimeException("Stub!"); }

/**
 * Gets the maximum zoom value allowed for snapshot. This is the maximum
 * value that applications can set to {@link #setZoom(int)}.
 * Applications should call {@link #isZoomSupported} before using this
 * method. This value may change in different preview size. Applications
 * should call this again after setting preview size.
 *
 * @return the maximum zoom value supported by the camera.
 * @apiSince 8
 * @deprecatedSince 21
 */

@Deprecated
public int getMaxZoom() { throw new RuntimeException("Stub!"); }

/**
 * Gets the zoom ratios of all zoom values. Applications should check
 * {@link #isZoomSupported} before using this method.
 *
 * @return the zoom ratios in 1/100 increments. Ex: a zoom of 3.2x is
 *         returned as 320. The number of elements is {@link
 *         #getMaxZoom} + 1. The list is sorted from small to large. The
 *         first element is always 100. The last element is the zoom
 *         ratio of the maximum zoom value.
 * @apiSince 8
 * @deprecatedSince 21
 */

@Deprecated
public java.util.List<java.lang.Integer> getZoomRatios() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if smooth zoom is supported. Applications should call
 * this before using other smooth zoom methods.
 *
 * @return true if smooth zoom is supported.
 * @apiSince 8
 * @deprecatedSince 21
 */

@Deprecated
public boolean isSmoothZoomSupported() { throw new RuntimeException("Stub!"); }

/**
 * <p>Gets the distances from the camera to where an object appears to be
 * in focus. The object is sharpest at the optimal focus distance. The
 * depth of field is the far focus distance minus near focus distance.</p>
 *
 * <p>Focus distances may change after calling {@link
 * #autoFocus(android.hardware.Camera.AutoFocusCallback)}, {@link #cancelAutoFocus}, or {@link
 * #startPreview()}. Applications can call {@link #getParameters()}
 * and this method anytime to get the latest focus distances. If the
 * focus mode is FOCUS_MODE_CONTINUOUS_VIDEO, focus distances may change
 * from time to time.</p>
 *
 * <p>This method is intended to estimate the distance between the camera
 * and the subject. After autofocus, the subject distance may be within
 * near and far focus distance. However, the precision depends on the
 * camera hardware, autofocus algorithm, the focus area, and the scene.
 * The error can be large and it should be only used as a reference.</p>
 *
 * <p>Far focus distance >= optimal focus distance >= near focus distance.
 * If the focus distance is infinity, the value will be
 * {@code Float.POSITIVE_INFINITY}.</p>
 *
 * @param output focus distances in meters. output must be a float
 *        array with three elements. Near focus distance, optimal focus
 *        distance, and far focus distance will be filled in the array.
 * @see #FOCUS_DISTANCE_NEAR_INDEX
 * @see #FOCUS_DISTANCE_OPTIMAL_INDEX
 * @see #FOCUS_DISTANCE_FAR_INDEX
 * @apiSince 9
 * @deprecatedSince 21
 */

@Deprecated
public void getFocusDistances(float[] output) { throw new RuntimeException("Stub!"); }

/**
 * Gets the maximum number of focus areas supported. This is the maximum
 * length of the list in {@link #setFocusAreas(java.util.List)} and
 * {@link #getFocusAreas()}.
 *
 * @return the maximum number of focus areas supported by the camera.
 * @see #getFocusAreas()
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated
public int getMaxNumFocusAreas() { throw new RuntimeException("Stub!"); }

/**
 * <p>Gets the current focus areas. Camera driver uses the areas to decide
 * focus.</p>
 *
 * <p>Before using this API or {@link #setFocusAreas(java.util.List)}, apps should
 * call {@link #getMaxNumFocusAreas()} to know the maximum number of
 * focus areas first. If the value is 0, focus area is not supported.</p>
 *
 * <p>Each focus area is a rectangle with specified weight. The direction
 * is relative to the sensor orientation, that is, what the sensor sees.
 * The direction is not affected by the rotation or mirroring of
 * {@link #setDisplayOrientation(int)}. Coordinates of the rectangle
 * range from -1000 to 1000. (-1000, -1000) is the upper left point.
 * (1000, 1000) is the lower right point. The width and height of focus
 * areas cannot be 0 or negative.</p>
 *
 * <p>The weight must range from 1 to 1000. The weight should be
 * interpreted as a per-pixel weight - all pixels in the area have the
 * specified weight. This means a small area with the same weight as a
 * larger area will have less influence on the focusing than the larger
 * area. Focus areas can partially overlap and the driver will add the
 * weights in the overlap region.</p>
 *
 * <p>A special case of a {@code null} focus area list means the driver is
 * free to select focus targets as it wants. For example, the driver may
 * use more signals to select focus areas and change them
 * dynamically. Apps can set the focus area list to {@code null} if they
 * want the driver to completely control focusing.</p>
 *
 * <p>Focus areas are relative to the current field of view
 * ({@link #getZoom()}). No matter what the zoom level is, (-1000,-1000)
 * represents the top of the currently visible camera frame. The focus
 * area cannot be set to be outside the current field of view, even
 * when using zoom.</p>
 *
 * <p>Focus area only has effect if the current focus mode is
 * {@link #FOCUS_MODE_AUTO}, {@link #FOCUS_MODE_MACRO},
 * {@link #FOCUS_MODE_CONTINUOUS_VIDEO}, or
 * {@link #FOCUS_MODE_CONTINUOUS_PICTURE}.</p>
 *
 * @return a list of current focus areas
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated
public java.util.List<android.hardware.Camera.Area> getFocusAreas() { throw new RuntimeException("Stub!"); }

/**
 * Sets focus areas. See {@link #getFocusAreas()} for documentation.
 *
 * @param focusAreas the focus areas
 * @see #getFocusAreas()
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated
public void setFocusAreas(java.util.List<android.hardware.Camera.Area> focusAreas) { throw new RuntimeException("Stub!"); }

/**
 * Gets the maximum number of metering areas supported. This is the
 * maximum length of the list in {@link #setMeteringAreas(java.util.List)} and
 * {@link #getMeteringAreas()}.
 *
 * @return the maximum number of metering areas supported by the camera.
 * @see #getMeteringAreas()
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated
public int getMaxNumMeteringAreas() { throw new RuntimeException("Stub!"); }

/**
 * <p>Gets the current metering areas. Camera driver uses these areas to
 * decide exposure.</p>
 *
 * <p>Before using this API or {@link #setMeteringAreas(java.util.List)}, apps should
 * call {@link #getMaxNumMeteringAreas()} to know the maximum number of
 * metering areas first. If the value is 0, metering area is not
 * supported.</p>
 *
 * <p>Each metering area is a rectangle with specified weight. The
 * direction is relative to the sensor orientation, that is, what the
 * sensor sees. The direction is not affected by the rotation or
 * mirroring of {@link #setDisplayOrientation(int)}. Coordinates of the
 * rectangle range from -1000 to 1000. (-1000, -1000) is the upper left
 * point. (1000, 1000) is the lower right point. The width and height of
 * metering areas cannot be 0 or negative.</p>
 *
 * <p>The weight must range from 1 to 1000, and represents a weight for
 * every pixel in the area. This means that a large metering area with
 * the same weight as a smaller area will have more effect in the
 * metering result.  Metering areas can partially overlap and the driver
 * will add the weights in the overlap region.</p>
 *
 * <p>A special case of a {@code null} metering area list means the driver
 * is free to meter as it chooses. For example, the driver may use more
 * signals to select metering areas and change them dynamically. Apps
 * can set the metering area list to {@code null} if they want the
 * driver to completely control metering.</p>
 *
 * <p>Metering areas are relative to the current field of view
 * ({@link #getZoom()}). No matter what the zoom level is, (-1000,-1000)
 * represents the top of the currently visible camera frame. The
 * metering area cannot be set to be outside the current field of view,
 * even when using zoom.</p>
 *
 * <p>No matter what metering areas are, the final exposure are compensated
 * by {@link #setExposureCompensation(int)}.</p>
 *
 * @return a list of current metering areas
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated
public java.util.List<android.hardware.Camera.Area> getMeteringAreas() { throw new RuntimeException("Stub!"); }

/**
 * Sets metering areas. See {@link #getMeteringAreas()} for
 * documentation.
 *
 * @param meteringAreas the metering areas
 * @see #getMeteringAreas()
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated
public void setMeteringAreas(java.util.List<android.hardware.Camera.Area> meteringAreas) { throw new RuntimeException("Stub!"); }

/**
 * Gets the maximum number of detected faces supported. This is the
 * maximum length of the list returned from {@link android.hardware.Camera.FaceDetectionListener FaceDetectionListener}.
 * If the return value is 0, face detection of the specified type is not
 * supported.
 *
 * @return the maximum number of detected face supported by the camera.
 * @see #startFaceDetection()
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated
public int getMaxNumDetectedFaces() { throw new RuntimeException("Stub!"); }

/**
 * Sets recording mode hint. This tells the camera that the intent of
 * the application is to record videos {@link
 * android.media.MediaRecorder#start()}, not to take still pictures
 * {@link #takePicture(android.hardware.Camera.ShutterCallback,android.hardware.Camera.PictureCallback,android.hardware.Camera.PictureCallback,android.hardware.Camera.PictureCallback)}. Using this hint can
 * allow MediaRecorder.start() to start faster or with fewer glitches on
 * output. This should be called before starting preview for the best
 * result, but can be changed while the preview is active. The default
 * value is false.
 *
 * The app can still call takePicture() when the hint is true or call
 * MediaRecorder.start() when the hint is false. But the performance may
 * be worse.
 *
 * @param hint true if the apps intend to record videos using
 *             {@link android.media.MediaRecorder}.
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated
public void setRecordingHint(boolean hint) { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns true if video snapshot is supported. That is, applications
 * can call {@link #takePicture(android.hardware.Camera.ShutterCallback,android.hardware.Camera.PictureCallback,android.hardware.Camera.PictureCallback,android.hardware.Camera.PictureCallback)} during recording. Applications do not need
 * to call {@link #startPreview()} after taking a picture. The preview
 * will be still active. Other than that, taking a picture during
 * recording is identical to taking a picture normally. All settings and
 * methods related to takePicture work identically. Ex:
 * {@link #getPictureSize()}, {@link #getSupportedPictureSizes()},
 * {@link #setJpegQuality(int)}, {@link #setRotation(int)}, and etc. The
 * picture will have an EXIF header. {@link #FLASH_MODE_AUTO} and
 * {@link #FLASH_MODE_ON} also still work, but the video will record the
 * flash.</p>
 *
 * <p>Applications can set shutter callback as null to avoid the shutter
 * sound. It is also recommended to set raw picture and post view
 * callbacks to null to avoid the interrupt of preview display.</p>
 *
 * <p>Field-of-view of the recorded video may be different from that of the
 * captured pictures. The maximum size of a video snapshot may be
 * smaller than that for regular still captures. If the current picture
 * size is set higher than can be supported by video snapshot, the
 * picture will be captured at the maximum supported size instead.</p>
 *
 * @return true if video snapshot is supported.
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated
public boolean isVideoSnapshotSupported() { throw new RuntimeException("Stub!"); }

/**
 * <p>Enables and disables video stabilization. Use
 * {@link #isVideoStabilizationSupported} to determine if calling this
 * method is valid.</p>
 *
 * <p>Video stabilization reduces the shaking due to the motion of the
 * camera in both the preview stream and in recorded videos, including
 * data received from the preview callback. It does not reduce motion
 * blur in images captured with
 * {@link android.hardware.Camera#takePicture Camera#takePicture}.</p>
 *
 * <p>Video stabilization can be enabled and disabled while preview or
 * recording is active, but toggling it may cause a jump in the video
 * stream that may be undesirable in a recorded video.</p>
 *
 * @param toggle Set to true to enable video stabilization, and false to
 * disable video stabilization.
 * @see #isVideoStabilizationSupported()
 * @see #getVideoStabilization()
 * @apiSince 15
 * @deprecatedSince 21
 */

@Deprecated
public void setVideoStabilization(boolean toggle) { throw new RuntimeException("Stub!"); }

/**
 * Get the current state of video stabilization. See
 * {@link #setVideoStabilization} for details of video stabilization.
 *
 * @return true if video stabilization is enabled
 * @see #isVideoStabilizationSupported()
 * @see #setVideoStabilization(boolean)
 * @apiSince 15
 * @deprecatedSince 21
 */

@Deprecated
public boolean getVideoStabilization() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if video stabilization is supported. See
 * {@link #setVideoStabilization} for details of video stabilization.
 *
 * @return true if video stabilization is supported
 * @see #setVideoStabilization(boolean)
 * @see #getVideoStabilization()
 * @apiSince 15
 * @deprecatedSince 21
 */

@Deprecated
public boolean isVideoStabilizationSupported() { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String ANTIBANDING_50HZ = "50hz";

/**
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String ANTIBANDING_60HZ = "60hz";

/**
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String ANTIBANDING_AUTO = "auto";

/**
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String ANTIBANDING_OFF = "off";

/**
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String EFFECT_AQUA = "aqua";

/**
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String EFFECT_BLACKBOARD = "blackboard";

/**
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String EFFECT_MONO = "mono";

/**
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String EFFECT_NEGATIVE = "negative";

/**
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String EFFECT_NONE = "none";

/**
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String EFFECT_POSTERIZE = "posterize";

/**
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String EFFECT_SEPIA = "sepia";

/**
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String EFFECT_SOLARIZE = "solarize";

/**
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String EFFECT_WHITEBOARD = "whiteboard";

/**
 * Flash will be fired automatically when required. The flash may be fired
 * during preview, auto-focus, or snapshot depending on the driver.
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String FLASH_MODE_AUTO = "auto";

/**
 * Flash will not be fired.
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String FLASH_MODE_OFF = "off";

/**
 * Flash will always be fired during snapshot. The flash may also be
 * fired during preview or auto-focus depending on the driver.
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String FLASH_MODE_ON = "on";

/**
 * Flash will be fired in red-eye reduction mode.
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String FLASH_MODE_RED_EYE = "red-eye";

/**
 * Constant emission of light during preview, auto-focus and snapshot.
 * This can also be used for video recording.
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String FLASH_MODE_TORCH = "torch";

/**
 * The array index of far focus distance for use with
 * {@link #getFocusDistances(float[])}.
 * @apiSince 9
 * @deprecatedSince 21
 */

@Deprecated public static final int FOCUS_DISTANCE_FAR_INDEX = 2; // 0x2

/**
 * The array index of near focus distance for use with
 * {@link #getFocusDistances(float[])}.
 * @apiSince 9
 * @deprecatedSince 21
 */

@Deprecated public static final int FOCUS_DISTANCE_NEAR_INDEX = 0; // 0x0

/**
 * The array index of optimal focus distance for use with
 * {@link #getFocusDistances(float[])}.
 * @apiSince 9
 * @deprecatedSince 21
 */

@Deprecated public static final int FOCUS_DISTANCE_OPTIMAL_INDEX = 1; // 0x1

/**
 * Auto-focus mode. Applications should call {@link
 * #autoFocus(android.hardware.Camera.AutoFocusCallback)} to start the focus in this mode.
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String FOCUS_MODE_AUTO = "auto";

/**
 * Continuous auto focus mode intended for taking pictures. The camera
 * continuously tries to focus. The speed of focus change is more
 * aggressive than {@link #FOCUS_MODE_CONTINUOUS_VIDEO}. Auto focus
 * starts when the parameter is set.
 *
 * <p>Applications can call {@link #autoFocus(android.hardware.Camera.AutoFocusCallback)} in
 * this mode. If the autofocus is in the middle of scanning, the focus
 * callback will return when it completes. If the autofocus is not
 * scanning, the focus callback will immediately return with a boolean
 * that indicates whether the focus is sharp or not. The apps can then
 * decide if they want to take a picture immediately or to change the
 * focus mode to auto, and run a full autofocus cycle. The focus
 * position is locked after autoFocus call. If applications want to
 * resume the continuous focus, cancelAutoFocus must be called.
 * Restarting the preview will not resume the continuous autofocus. To
 * stop continuous focus, applications should change the focus mode to
 * other modes.
 *
 * @see #FOCUS_MODE_CONTINUOUS_VIDEO
 * @apiSince 14
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String FOCUS_MODE_CONTINUOUS_PICTURE = "continuous-picture";

/**
 * Continuous auto focus mode intended for video recording. The camera
 * continuously tries to focus. This is the best choice for video
 * recording because the focus changes smoothly . Applications still can
 * call {@link #takePicture(android.hardware.Camera.ShutterCallback,android.hardware.Camera.PictureCallback,android.hardware.Camera.PictureCallback)} in this mode but the
 * subject may not be in focus. Auto focus starts when the parameter is
 * set.
 *
 * <p>Since API level 14, applications can call {@link
 * #autoFocus(android.hardware.Camera.AutoFocusCallback)} in this mode. The focus callback will
 * immediately return with a boolean that indicates whether the focus is
 * sharp or not. The focus position is locked after autoFocus call. If
 * applications want to resume the continuous focus, cancelAutoFocus
 * must be called. Restarting the preview will not resume the continuous
 * autofocus. To stop continuous focus, applications should change the
 * focus mode to other modes.
 *
 * @see #FOCUS_MODE_CONTINUOUS_PICTURE
 * @apiSince 9
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String FOCUS_MODE_CONTINUOUS_VIDEO = "continuous-video";

/**
 * Extended depth of field (EDOF). Focusing is done digitally and
 * continuously. Applications should not call {@link
 * #autoFocus(android.hardware.Camera.AutoFocusCallback)} in this mode.
 * @apiSince 8
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String FOCUS_MODE_EDOF = "edof";

/**
 * Focus is fixed. The camera is always in this mode if the focus is not
 * adjustable. If the camera has auto-focus, this mode can fix the
 * focus, which is usually at hyperfocal distance. Applications should
 * not call {@link #autoFocus(android.hardware.Camera.AutoFocusCallback)} in this mode.
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String FOCUS_MODE_FIXED = "fixed";

/**
 * Focus is set at infinity. Applications should not call
 * {@link #autoFocus(android.hardware.Camera.AutoFocusCallback)} in this mode.
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String FOCUS_MODE_INFINITY = "infinity";

/**
 * Macro (close-up) focus mode. Applications should call
 * {@link #autoFocus(android.hardware.Camera.AutoFocusCallback)} to start the focus in this
 * mode.
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String FOCUS_MODE_MACRO = "macro";

/**
 * The array index of maximum preview fps for use with {@link
 * #getPreviewFpsRange(int[])} or {@link
 * #getSupportedPreviewFpsRange()}.
 * @apiSince 9
 * @deprecatedSince 21
 */

@Deprecated public static final int PREVIEW_FPS_MAX_INDEX = 1; // 0x1

/**
 * The array index of minimum preview fps for use with {@link
 * #getPreviewFpsRange(int[])} or {@link
 * #getSupportedPreviewFpsRange()}.
 * @apiSince 9
 * @deprecatedSince 21
 */

@Deprecated public static final int PREVIEW_FPS_MIN_INDEX = 0; // 0x0

/**
 * Take photos of fast moving objects. Same as {@link
 * #SCENE_MODE_SPORTS}.
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String SCENE_MODE_ACTION = "action";

/**
 * Scene mode is off.
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String SCENE_MODE_AUTO = "auto";

/**
 * Applications are looking for a barcode. Camera driver will be
 * optimized for barcode reading.
 * @apiSince 8
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String SCENE_MODE_BARCODE = "barcode";

/**
 * Take pictures on the beach.
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String SCENE_MODE_BEACH = "beach";

/**
 * Capture the naturally warm color of scenes lit by candles.
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String SCENE_MODE_CANDLELIGHT = "candlelight";

/**
 * For shooting firework displays.
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String SCENE_MODE_FIREWORKS = "fireworks";

/**
 * Capture a scene using high dynamic range imaging techniques. The
 * camera will return an image that has an extended dynamic range
 * compared to a regular capture. Capturing such an image may take
 * longer than a regular capture.
 * @apiSince 17
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String SCENE_MODE_HDR = "hdr";

/**
 * Take pictures on distant objects.
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String SCENE_MODE_LANDSCAPE = "landscape";

/**
 * Take photos at night.
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String SCENE_MODE_NIGHT = "night";

/**
 * Take people pictures at night.
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String SCENE_MODE_NIGHT_PORTRAIT = "night-portrait";

/**
 * Take indoor low-light shot.
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String SCENE_MODE_PARTY = "party";

/**
 * Take people pictures.
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String SCENE_MODE_PORTRAIT = "portrait";

/**
 * Take pictures on the snow.
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String SCENE_MODE_SNOW = "snow";

/**
 * Take photos of fast moving objects. Same as {@link
 * #SCENE_MODE_ACTION}.
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String SCENE_MODE_SPORTS = "sports";

/**
 * Avoid blurry pictures (for example, due to hand shake).
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String SCENE_MODE_STEADYPHOTO = "steadyphoto";

/**
 * Take sunset photos.
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String SCENE_MODE_SUNSET = "sunset";

/**
 * Take photos in a theater. Flash light is off.
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String SCENE_MODE_THEATRE = "theatre";

/**
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String WHITE_BALANCE_AUTO = "auto";

/**
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String WHITE_BALANCE_CLOUDY_DAYLIGHT = "cloudy-daylight";

/**
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String WHITE_BALANCE_DAYLIGHT = "daylight";

/**
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String WHITE_BALANCE_FLUORESCENT = "fluorescent";

/**
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String WHITE_BALANCE_INCANDESCENT = "incandescent";

/**
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String WHITE_BALANCE_SHADE = "shade";

/**
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String WHITE_BALANCE_TWILIGHT = "twilight";

/**
 * @apiSince 5
 * @deprecatedSince 21
 */

@Deprecated public static final java.lang.String WHITE_BALANCE_WARM_FLUORESCENT = "warm-fluorescent";
}

/**
 * Callback interface used to supply image data from a photo capture.
 *
 * @see #takePicture(ShutterCallback, PictureCallback, PictureCallback, PictureCallback)
 *
 * @deprecated We recommend using the new {@link android.hardware.camera2} API for new
 *             applications.
 * @apiSince 1
 * @deprecatedSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface PictureCallback {

/**
 * Called when image data is available after a picture is taken.
 * The format of the data depends on the context of the callback
 * and {@link android.hardware.Camera.Parameters Camera.Parameters} settings.
 *
 * @param data   a byte array of the picture data
 * @param camera the Camera service object
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public void onPictureTaken(byte[] data, android.hardware.Camera camera);
}

/**
 * Callback interface used to deliver copies of preview frames as
 * they are displayed.
 *
 * @see #setPreviewCallback(Camera.PreviewCallback)
 * @see #setOneShotPreviewCallback(Camera.PreviewCallback)
 * @see #setPreviewCallbackWithBuffer(Camera.PreviewCallback)
 * @see #startPreview()
 *
 * @deprecated We recommend using the new {@link android.hardware.camera2} API for new
 *             applications.
 * @apiSince 1
 * @deprecatedSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface PreviewCallback {

/**
 * Called as preview frames are displayed.  This callback is invoked
 * on the event thread {@link #open(int)} was called from.
 *
 * <p>If using the {@link android.graphics.ImageFormat#YV12} format,
 * refer to the equations in {@link android.hardware.Camera.Parameters#setPreviewFormat Camera.Parameters#setPreviewFormat}
 * for the arrangement of the pixel data in the preview callback
 * buffers.
 *
 * @param data the contents of the preview frame in the format defined
 *  by {@link android.graphics.ImageFormat}, which can be queried
 *  with {@link android.hardware.Camera.Parameters#getPreviewFormat()}.
 *  If {@link android.hardware.Camera.Parameters#setPreviewFormat(int)}
 *             is never called, the default will be the YCbCr_420_SP
 *             (NV21) format.
 * @param camera the Camera service object.
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public void onPreviewFrame(byte[] data, android.hardware.Camera camera);
}

/**
 * Callback interface used to signal the moment of actual image capture.
 *
 * @see #takePicture(ShutterCallback, PictureCallback, PictureCallback, PictureCallback)
 *
 * @deprecated We recommend using the new {@link android.hardware.camera2} API for new
 *             applications.
 * @apiSince 1
 * @deprecatedSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface ShutterCallback {

/**
 * Called as near as possible to the moment when a photo is captured
 * from the sensor.  This is a good opportunity to play a shutter sound
 * or give other feedback of camera operation.  This may be some time
 * after the photo was triggered, but some time before the actual data
 * is available.
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public void onShutter();
}

/**
 * Image size (width and height dimensions).
 * @deprecated We recommend using the new {@link android.hardware.camera2} API for new
 *             applications.
 * @apiSince 1
 * @deprecatedSince 21
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class Size {

/**
 * Sets the dimensions for pictures.
 *
 * @param w the photo width (pixels)
 * @param h the photo height (pixels)
 */

@Deprecated
public Size(int w, int h) { throw new RuntimeException("Stub!"); }

/**
 * Compares {@code obj} to this size.
 *
 * @param obj the object to compare this size with.
 * @return {@code true} if the width and height of {@code obj} is the
 *         same as those of this size. {@code false} otherwise.
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated
public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * height of the picture
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated public int height;

/**
 * width of the picture
 * @apiSince 1
 * @deprecatedSince 21
 */

@Deprecated public int width;
}

}

