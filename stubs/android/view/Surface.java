/*
 * Copyright (C) 2007 The Android Open Source Project
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


package android.view;

import android.graphics.SurfaceTexture;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Handle onto a raw buffer that is being managed by the screen compositor.
 *
 * <p>A Surface is generally created by or from a consumer of image buffers (such as a
 * {@link android.graphics.SurfaceTexture}, {@link android.media.MediaRecorder}, or
 * {@link android.renderscript.Allocation}), and is handed to some kind of producer (such as
 * {@link android.opengl.EGL14#eglCreateWindowSurface(android.opengl.EGLDisplay,android.opengl.EGLConfig,java.lang.Object,int[],int) OpenGL},
 * {@link android.media.MediaPlayer#setSurface MediaPlayer}, or
 * {@link android.hardware.camera2.CameraDevice#createCaptureSession CameraDevice}) to draw
 * into.</p>
 *
 * <p><strong>Note:</strong> A Surface acts like a
 * {@link java.lang.ref.WeakReference weak reference} to the consumer it is associated with. By
 * itself it will not keep its parent consumer from being reclaimed.</p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Surface implements android.os.Parcelable {

/**
 * Create a Surface assosciated with a given {@link android.view.SurfaceControl SurfaceControl}. Buffers submitted to this
 * surface will be displayed by the system compositor according to the parameters
 * specified by the control. Multiple surfaces may be constructed from one SurfaceControl,
 * but only one can be connected (e.g. have an active EGL context) at a time.
 *
 * @param from The SurfaceControl to assosciate this Surface with
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public Surface(@androidx.annotation.NonNull android.view.SurfaceControl from) { throw new RuntimeException("Stub!"); }

/**
 * Create Surface from a {@link android.graphics.SurfaceTexture SurfaceTexture}.
 *
 * Images drawn to the Surface will be made available to the {@link android.graphics.SurfaceTexture SurfaceTexture}, which can attach them to an OpenGL ES texture via {@link android.graphics.SurfaceTexture#updateTexImage SurfaceTexture#updateTexImage}.
 *
 * Please note that holding onto the Surface created here is not enough to
 * keep the provided SurfaceTexture from being reclaimed.  In that sense,
 * the Surface will act like a
 * {@link java.lang.ref.WeakReference weak reference} to the SurfaceTexture.
 *
 * @param surfaceTexture The {@link android.graphics.SurfaceTexture SurfaceTexture} that is updated by this
 * Surface.
 * @throws android.view.Surface.OutOfResourcesException if the surface could not be created.
 * @apiSince 14
 */

public Surface(android.graphics.SurfaceTexture surfaceTexture) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Release the local reference to the server-side surface.
 * Always call release() when you're done with a Surface.
 * This will make the surface invalid.
 * @apiSince 14
 */

public void release() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this object holds a valid surface.
 *
 * @return True if it holds a physical surface, so lockCanvas() will succeed.
 * Otherwise returns false.
 * @apiSince 1
 */

public boolean isValid() { throw new RuntimeException("Stub!"); }

/**
 * Gets a {@link android.graphics.Canvas Canvas} for drawing into this surface.
 *
 * After drawing into the provided {@link android.graphics.Canvas Canvas}, the caller must
 * invoke {@link #unlockCanvasAndPost} to post the new contents to the surface.
 *
 * @param inOutDirty A rectangle that represents the dirty region that the caller wants
 * to redraw.  This function may choose to expand the dirty rectangle if for example
 * the surface has been resized or if the previous contents of the surface were
 * not available.  The caller must redraw the entire dirty region as represented
 * by the contents of the inOutDirty rectangle upon return from this function.
 * The caller may also pass <code>null</code> instead, in the case where the
 * entire surface should be redrawn.
 * @return A canvas for drawing into the surface.
 *
 * @throws java.lang.IllegalArgumentException If the inOutDirty rectangle is not valid.
 * @throws android.view.Surface.OutOfResourcesException If the canvas cannot be locked.
 * @apiSince 1
 */

public android.graphics.Canvas lockCanvas(android.graphics.Rect inOutDirty) throws java.lang.IllegalArgumentException, android.view.Surface.OutOfResourcesException { throw new RuntimeException("Stub!"); }

/**
 * Posts the new contents of the {@link android.graphics.Canvas Canvas} to the surface and
 * releases the {@link android.graphics.Canvas Canvas}.
 *
 * @param canvas The canvas previously obtained from {@link #lockCanvas}.
 * @apiSince 1
 */

public void unlockCanvasAndPost(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * Gets a {@link android.graphics.Canvas Canvas} for drawing into this surface.
 *
 * After drawing into the provided {@link android.graphics.Canvas Canvas}, the caller must
 * invoke {@link #unlockCanvasAndPost} to post the new contents to the surface.
 *
 * Unlike {@link #lockCanvas(android.graphics.Rect)} this will return a hardware-accelerated
 * canvas. See the <a href="{@docRoot}guide/topics/graphics/hardware-accel.html#unsupported">
 * unsupported drawing operations</a> for a list of what is and isn't
 * supported in a hardware-accelerated canvas. It is also required to
 * fully cover the surface every time {@link #lockHardwareCanvas()} is
 * called as the buffer is not preserved between frames. Partial updates
 * are not supported.
 *
 * @return A canvas for drawing into the surface.
 *
 * @throws java.lang.IllegalStateException If the canvas cannot be locked.
 * @apiSince 23
 */

public android.graphics.Canvas lockHardwareCanvas() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated This API has been removed and is not supported.  Do not use.
 * @apiSince 1
 * @deprecatedSince 17
 */

@Deprecated
public void unlockCanvas(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void readFromParcel(android.os.Parcel source) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.view.Surface> CREATOR;
static { CREATOR = null; }

/**
 * Rotation constant: 0 degree rotation (natural orientation)
 * @apiSince 1
 */

public static final int ROTATION_0 = 0; // 0x0

/**
 * Rotation constant: 180 degree rotation.
 * @apiSince 1
 */

public static final int ROTATION_180 = 2; // 0x2

/**
 * Rotation constant: 270 degree rotation.
 * @apiSince 1
 */

public static final int ROTATION_270 = 3; // 0x3

/**
 * Rotation constant: 90 degree rotation.
 * @apiSince 1
 */

public static final int ROTATION_90 = 1; // 0x1
/**
 * Exception thrown when a Canvas couldn't be locked with {@link android.view.Surface#lockCanvas Surface#lockCanvas}, or
 * when a SurfaceTexture could not successfully be allocated.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class OutOfResourcesException extends java.lang.RuntimeException {

/** @apiSince 1 */

public OutOfResourcesException() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public OutOfResourcesException(java.lang.String name) { throw new RuntimeException("Stub!"); }
}

}

