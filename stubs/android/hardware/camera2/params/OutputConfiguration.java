/*
 * Copyright (C) 2015 The Android Open Source Project
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
import android.hardware.camera2.CameraCaptureSession;
import android.graphics.ImageFormat;
import android.view.Surface;
import android.util.Size;

/**
 * A class for describing camera output, which contains a {@link android.view.Surface Surface} and its specific
 * configuration for creating capture session.
 *
 * <p>There are several ways to instantiate, modify and use OutputConfigurations. The most common
 * and recommended usage patterns are summarized in the following list:</p>
 *<ul>
 * <li>Passing a {@link android.view.Surface Surface} to the constructor and using the OutputConfiguration instance as
 * argument to {@link android.hardware.camera2.CameraDevice#createCaptureSessionByOutputConfigurations CameraDevice#createCaptureSessionByOutputConfigurations}. This is the most
 * frequent usage and clients should consider it first before other more complicated alternatives.
 * </li>
 *
 * <li>Passing only a surface source class as an argument to the constructor. This is usually
 * followed by a call to create a capture session
 * (see {@link android.hardware.camera2.CameraDevice#createCaptureSessionByOutputConfigurations CameraDevice#createCaptureSessionByOutputConfigurations} and a {@link android.view.Surface Surface} add
 * call {@link #addSurface} with a valid {@link android.view.Surface Surface}. The sequence completes with
 * {@link android.hardware.camera2.CameraCaptureSession#finalizeOutputConfigurations CameraCaptureSession#finalizeOutputConfigurations}. This is the deferred usage case which
 * aims to enhance performance by allowing the resource-intensive capture session create call to
 * execute in parallel with any {@link android.view.Surface Surface} initialization, such as waiting for a
 * {@link android.view.SurfaceView} to be ready as part of the UI initialization.</li>
 *
 * <li>The third and most complex usage pattern involves surface sharing. Once instantiated an
 * OutputConfiguration can be enabled for surface sharing via {@link #enableSurfaceSharing}. This
 * must be done before creating a new capture session and enables calls to
 * {@link android.hardware.camera2.CameraCaptureSession#updateOutputConfiguration CameraCaptureSession#updateOutputConfiguration}. An OutputConfiguration with enabled
 * surface sharing can be modified via {@link #addSurface} or {@link #removeSurface}. The updates
 * to this OutputConfiguration will only come into effect after
 * {@link android.hardware.camera2.CameraCaptureSession#updateOutputConfiguration CameraCaptureSession#updateOutputConfiguration} returns without throwing exceptions.
 * Such updates can be done as long as the session is active. Clients should always consider the
 * additional requirements and limitations placed on the output surfaces (for more details see
 * {@link #enableSurfaceSharing}, {@link #addSurface}, {@link #removeSurface},
 * {@link android.hardware.camera2.CameraCaptureSession#updateOutputConfiguration CameraCaptureSession#updateOutputConfiguration}). A trade-off exists between additional
 * complexity and flexibility. If exercised correctly surface sharing can switch between different
 * output surfaces without interrupting any ongoing repeating capture requests. This saves time and
 * can significantly improve the user experience.</li>
 *
 * <li>Surface sharing can be used in combination with deferred surfaces. The rules from both cases
 * are combined and clients must call {@link #enableSurfaceSharing} before creating a capture
 * session. Attach and/or remove output surfaces via  {@link #addSurface}/{@link #removeSurface} and
 * finalize the configuration using {@link android.hardware.camera2.CameraCaptureSession#finalizeOutputConfigurations CameraCaptureSession#finalizeOutputConfigurations}.
 * {@link android.hardware.camera2.CameraCaptureSession#updateOutputConfiguration CameraCaptureSession#updateOutputConfiguration} can be called after the configuration
 * finalize method returns without exceptions.</li>
 *
 * </ul>
 *
 * <p> As of {@link android.os.Build.VERSION_CODES#P Android P}, all formats except
 * {@link android.graphics.ImageFormat#JPEG ImageFormat#JPEG} and {@link android.graphics.ImageFormat#RAW_PRIVATE ImageFormat#RAW_PRIVATE} can be used for sharing, subject to
 * device support. On prior API levels, only {@link android.graphics.ImageFormat#PRIVATE ImageFormat#PRIVATE} format may be used.</p>
 *
 * @see android.hardware.camera2.CameraDevice#createCaptureSessionByOutputConfigurations
 *
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class OutputConfiguration implements android.os.Parcelable {

/**
 * Create a new {@link android.hardware.camera2.params.OutputConfiguration OutputConfiguration} instance with a {@link android.view.Surface Surface}.
 *
 * @param surface
 *          A Surface for camera to output to.
 *
 * <p>This constructor creates a default configuration, with a surface group ID of
 * {@value #SURFACE_GROUP_ID_NONE}.</p>
 *
 
 * This value must never be {@code null}.
 * @apiSince 24
 */

public OutputConfiguration(@androidx.annotation.NonNull android.view.Surface surface) { throw new RuntimeException("Stub!"); }

/**
 * Create a new {@link android.hardware.camera2.params.OutputConfiguration OutputConfiguration} instance with a {@link android.view.Surface Surface},
 * with a surface group ID.
 *
 * <p>
 * A surface group ID is used to identify which surface group this output surface belongs to. A
 * surface group is a group of output surfaces that are not intended to receive camera output
 * buffer streams simultaneously. The {@link android.hardware.camera2.CameraDevice CameraDevice} may be able to share the buffers used
 * by all the surfaces from the same surface group, therefore may reduce the overall memory
 * footprint. The application should only set the same set ID for the streams that are not
 * simultaneously streaming. A negative ID indicates that this surface doesn't belong to any
 * surface group. The default value is {@value #SURFACE_GROUP_ID_NONE}.</p>
 *
 * <p>For example, a video chat application that has an adaptive output resolution feature would
 * need two (or more) output resolutions, to switch resolutions without any output glitches.
 * However, at any given time, only one output is active to minimize outgoing network bandwidth
 * and encoding overhead.  To save memory, the application should set the video outputs to have
 * the same non-negative group ID, so that the camera device can share the same memory region
 * for the alternating outputs.</p>
 *
 * <p>It is not an error to include output streams with the same group ID in the same capture
 * request, but the resulting memory consumption may be higher than if the two streams were
 * not in the same surface group to begin with, especially if the outputs have substantially
 * different dimensions.</p>
 *
 * @param surfaceGroupId
 *          A group ID for this output, used for sharing memory between multiple outputs.
 * @param surface
 *          A Surface for camera to output to.
 *
 
 * This value must never be {@code null}.
 * @apiSince 24
 */

public OutputConfiguration(int surfaceGroupId, @androidx.annotation.NonNull android.view.Surface surface) { throw new RuntimeException("Stub!"); }

/**
 * Create a new {@link android.hardware.camera2.params.OutputConfiguration OutputConfiguration} instance, with desired Surface size and Surface
 * source class.
 * <p>
 * This constructor takes an argument for desired Surface size and the Surface source class
 * without providing the actual output Surface. This is used to setup an output configuration
 * with a deferred Surface. The application can use this output configuration to create a
 * session.
 * </p>
 * <p>
 * However, the actual output Surface must be set via {@link #addSurface} and the deferred
 * Surface configuration must be finalized via {@link android.hardware.camera2.CameraCaptureSession#finalizeOutputConfigurations CameraCaptureSession#finalizeOutputConfigurations} before submitting a request with this
 * Surface target. The deferred Surface can only be obtained either from {@link
 * android.view.SurfaceView} by calling {@link android.view.SurfaceHolder#getSurface}, or from
 * {@link android.graphics.SurfaceTexture} via
 * {@link android.view.Surface#Surface(android.graphics.SurfaceTexture)}).
 * </p>
 *
 * @param surfaceSize Size for the deferred surface.
 * This value must never be {@code null}.
 * @param klass a non-{@code null} {@link java.lang.Class Class} object reference that indicates the source of
 *            this surface. Only {@link android.view.SurfaceHolder SurfaceHolder.class} and
 *            {@link android.graphics.SurfaceTexture SurfaceTexture.class} are supported.
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if the Surface source class is not supported, or Surface
 *         size is zero.
 * @apiSince 26
 */

public <T> OutputConfiguration(@androidx.annotation.NonNull android.util.Size surfaceSize, @androidx.annotation.NonNull java.lang.Class<T> klass) { throw new RuntimeException("Stub!"); }

/**
 * Enable multiple surfaces sharing the same OutputConfiguration
 *
 * <p>For advanced use cases, a camera application may require more streams than the combination
 * guaranteed by {@link android.hardware.camera2.CameraDevice#createCaptureSession CameraDevice#createCaptureSession}. In this case, more than one
 * compatible surface can be attached to an OutputConfiguration so that they map to one
 * camera stream, and the outputs share memory buffers when possible. Due to buffer sharing
 * clients should be careful when adding surface outputs that modify their input data. If such
 * case exists, camera clients should have an additional mechanism to synchronize read and write
 * access between individual consumers.</p>
 *
 * <p>Two surfaces are compatible in the below cases:</p>
 *
 * <li> Surfaces with the same size, format, dataSpace, and Surface source class. In this case,
 * {@link android.hardware.camera2.CameraDevice#createCaptureSessionByOutputConfigurations CameraDevice#createCaptureSessionByOutputConfigurations} is guaranteed to succeed.
 *
 * <li> Surfaces with the same size, format, and dataSpace, but different Surface source classes
 * that are generally not compatible. However, on some devices, the underlying camera device is
 * able to use the same buffer layout for both surfaces. The only way to discover if this is the
 * case is to create a capture session with that output configuration. For example, if the
 * camera device uses the same private buffer format between a SurfaceView/SurfaceTexture and a
 * MediaRecorder/MediaCodec, {@link android.hardware.camera2.CameraDevice#createCaptureSessionByOutputConfigurations CameraDevice#createCaptureSessionByOutputConfigurations}
 * will succeed. Otherwise, it fails with {@link android.hardware.camera2.CameraCaptureSession.StateCallback#onConfigureFailed CameraCaptureSession.StateCallback#onConfigureFailed}.
 * </ol>
 *
 * <p>To enable surface sharing, this function must be called before {@link android.hardware.camera2.CameraDevice#createCaptureSessionByOutputConfigurations CameraDevice#createCaptureSessionByOutputConfigurations} or {@link android.hardware.camera2.CameraDevice#createReprocessableCaptureSessionByConfigurations CameraDevice#createReprocessableCaptureSessionByConfigurations}. Calling this function after
 * {@link android.hardware.camera2.CameraDevice#createCaptureSessionByOutputConfigurations CameraDevice#createCaptureSessionByOutputConfigurations} has no effect.</p>
 *
 * <p>Up to {@link #getMaxSharedSurfaceCount} surfaces can be shared for an OutputConfiguration.
 * The supported surfaces for sharing must be of type SurfaceTexture, SurfaceView,
 * MediaRecorder, MediaCodec, or implementation defined ImageReader.</p>
 * @apiSince 26
 */

public void enableSurfaceSharing() { throw new RuntimeException("Stub!"); }

/**
 * Set the id of the physical camera for this OutputConfiguration
 *
 * <p>In the case one logical camera is made up of multiple physical cameras, it could be
 * desirable for the camera application to request streams from individual physical cameras.
 * This call achieves it by mapping the OutputConfiguration to the physical camera id.</p>
 *
 * <p>The valid physical camera ids can be queried by {@link
 * android.hardware.camera2.CameraCharacteristics#getPhysicalCameraIds}.
 * </p>
 *
 * <p>Passing in a null physicalCameraId means that the OutputConfiguration is for a logical
 * stream.</p>
 *
 * <p>This function must be called before {@link android.hardware.camera2.CameraDevice#createCaptureSessionByOutputConfigurations CameraDevice#createCaptureSessionByOutputConfigurations} or {@link android.hardware.camera2.CameraDevice#createReprocessableCaptureSessionByConfigurations CameraDevice#createReprocessableCaptureSessionByConfigurations}. Calling this function
 * after {@link android.hardware.camera2.CameraDevice#createCaptureSessionByOutputConfigurations CameraDevice#createCaptureSessionByOutputConfigurations} or {@link android.hardware.camera2.CameraDevice#createReprocessableCaptureSessionByConfigurations CameraDevice#createReprocessableCaptureSessionByConfigurations} has no effect.</p>
 *
 * <p>The surface belonging to a physical camera OutputConfiguration must not be used as input
 * or output of a reprocessing request. </p>
 
 * @param physicalCameraId This value may be {@code null}.
 * @apiSince 28
 */

public void setPhysicalCameraId(@androidx.annotation.Nullable java.lang.String physicalCameraId) { throw new RuntimeException("Stub!"); }

/**
 * Add a surface to this OutputConfiguration.
 *
 * <p> This function can be called before or after {@link android.hardware.camera2.CameraDevice#createCaptureSessionByOutputConfigurations CameraDevice#createCaptureSessionByOutputConfigurations}. If it's called after,
 * the application must finalize the capture session with
 * {@link android.hardware.camera2.CameraCaptureSession#finalizeOutputConfigurations CameraCaptureSession#finalizeOutputConfigurations}. It is possible to call this method
 * after the output configurations have been finalized only in cases of enabled surface sharing
 * see {@link #enableSurfaceSharing}. The modified output configuration must be updated with
 * {@link android.hardware.camera2.CameraCaptureSession#updateOutputConfiguration CameraCaptureSession#updateOutputConfiguration}.</p>
 *
 * <p> If the OutputConfiguration was constructed with a deferred surface by {@link android.hardware.camera2.params.OutputConfiguration#OutputConfiguration(android.util.Size,java.lang.Class) OutputConfiguration#OutputConfiguration(Size, Class)}, the added surface must be obtained
 * from {@link android.view.SurfaceView} by calling {@link android.view.SurfaceHolder#getSurface},
 * or from {@link android.graphics.SurfaceTexture} via
 * {@link android.view.Surface#Surface(android.graphics.SurfaceTexture)}).</p>
 *
 * <p> If the OutputConfiguration was constructed by other constructors, the added
 * surface must be compatible with the existing surface. See {@link #enableSurfaceSharing} for
 * details of compatible surfaces.</p>
 *
 * <p> If the OutputConfiguration already contains a Surface, {@link #enableSurfaceSharing} must
 * be called before calling this function to add a new Surface.</p>
 *
 * @param surface The surface to be added.
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if the Surface is invalid, the Surface's
 *         dataspace/format doesn't match, or adding the Surface would exceed number of
 *         shared surfaces supported.
 * @throws java.lang.IllegalStateException if the Surface was already added to this OutputConfiguration,
 *         or if the OutputConfiguration is not shared and it already has a surface associated
 *         with it.
 * @apiSince 26
 */

public void addSurface(@androidx.annotation.NonNull android.view.Surface surface) { throw new RuntimeException("Stub!"); }

/**
 * Remove a surface from this OutputConfiguration.
 *
 * <p> Surfaces added via calls to {@link #addSurface} can also be removed from the
 *  OutputConfiguration. The only notable exception is the surface associated with
 *  the OutputConfigration see {@link #getSurface} which was passed as part of the constructor
 *  or was added first in the deferred case
 *  {@link android.hardware.camera2.params.OutputConfiguration#OutputConfiguration(android.util.Size,java.lang.Class) OutputConfiguration#OutputConfiguration(Size, Class)}.</p>
 *
 * @param surface The surface to be removed.
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException If the surface is associated with this OutputConfiguration
 *                                  (see {@link #getSurface}) or the surface didn't get added
 *                                  with {@link #addSurface}.
 * @apiSince 28
 */

public void removeSurface(@androidx.annotation.NonNull android.view.Surface surface) { throw new RuntimeException("Stub!"); }

/**
 * Get the maximum supported shared {@link android.view.Surface Surface} count.
 *
 * @return the maximum number of surfaces that can be added per each OutputConfiguration.
 *
 * @see #enableSurfaceSharing
 * @apiSince 28
 */

public int getMaxSharedSurfaceCount() { throw new RuntimeException("Stub!"); }

/**
 * Get the {@link android.view.Surface Surface} associated with this {@link android.hardware.camera2.params.OutputConfiguration OutputConfiguration}.
 *
 * If more than one surface is associated with this {@link android.hardware.camera2.params.OutputConfiguration OutputConfiguration}, return the
 * first one as specified in the constructor or {@link android.hardware.camera2.params.OutputConfiguration#addSurface OutputConfiguration#addSurface}.
 
 * @return This value may be {@code null}.
 * @apiSince 24
 */

@androidx.annotation.Nullable
public android.view.Surface getSurface() { throw new RuntimeException("Stub!"); }

/**
 * Get the immutable list of surfaces associated with this {@link android.hardware.camera2.params.OutputConfiguration OutputConfiguration}.
 *
 * @return the list of surfaces associated with this {@link android.hardware.camera2.params.OutputConfiguration OutputConfiguration} as specified in
 * the constructor and {@link android.hardware.camera2.params.OutputConfiguration#addSurface OutputConfiguration#addSurface}. The list should not be modified.
 
 * This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public java.util.List<android.view.Surface> getSurfaces() { throw new RuntimeException("Stub!"); }

/**
 * Get the surface group ID associated with this {@link android.hardware.camera2.params.OutputConfiguration OutputConfiguration}.
 *
 * @return the surface group ID associated with this {@link android.hardware.camera2.params.OutputConfiguration OutputConfiguration}.
 *         The default value is {@value #SURFACE_GROUP_ID_NONE}.
 * @apiSince 24
 */

public int getSurfaceGroupId() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Check if this {@link android.hardware.camera2.params.OutputConfiguration OutputConfiguration} is equal to another {@link android.hardware.camera2.params.OutputConfiguration OutputConfiguration}.
 *
 * <p>Two output configurations are only equal if and only if the underlying surfaces, surface
 * properties (width, height, format, dataspace) when the output configurations are created,
 * and all other configuration parameters are equal. </p>
 *
 * @return {@code true} if the objects were equal, {@code false} otherwise
 * @apiSince 24
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 24
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.hardware.camera2.params.OutputConfiguration> CREATOR;
static { CREATOR = null; }

/**
 * Invalid surface group ID.
 *
 *<p>An {@link android.hardware.camera2.params.OutputConfiguration OutputConfiguration} with this value indicates that the included surface
 *doesn't belong to any surface group.</p>
 * @apiSince 24
 */

public static final int SURFACE_GROUP_ID_NONE = -1; // 0xffffffff
}

