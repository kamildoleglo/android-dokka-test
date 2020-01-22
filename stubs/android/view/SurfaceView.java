/*
 * Copyright (C) 2006 The Android Open Source Project
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

import android.os.Build;

/**
 * Provides a dedicated drawing surface embedded inside of a view hierarchy.
 * You can control the format of this surface and, if you like, its size; the
 * SurfaceView takes care of placing the surface at the correct location on the
 * screen
 *
 * <p>The surface is Z ordered so that it is behind the window holding its
 * SurfaceView; the SurfaceView punches a hole in its window to allow its
 * surface to be displayed. The view hierarchy will take care of correctly
 * compositing with the Surface any siblings of the SurfaceView that would
 * normally appear on top of it. This can be used to place overlays such as
 * buttons on top of the Surface, though note however that it can have an
 * impact on performance since a full alpha-blended composite will be performed
 * each time the Surface changes.
 *
 * <p> The transparent region that makes the surface visible is based on the
 * layout positions in the view hierarchy. If the post-layout transform
 * properties are used to draw a sibling view on top of the SurfaceView, the
 * view may not be properly composited with the surface.
 *
 * <p>Access to the underlying surface is provided via the SurfaceHolder interface,
 * which can be retrieved by calling {@link #getHolder}.
 *
 * <p>The Surface will be created for you while the SurfaceView's window is
 * visible; you should implement {@link android.view.SurfaceHolder.Callback#surfaceCreated SurfaceHolder.Callback#surfaceCreated}
 * and {@link android.view.SurfaceHolder.Callback#surfaceDestroyed SurfaceHolder.Callback#surfaceDestroyed} to discover when the
 * Surface is created and destroyed as the window is shown and hidden.
 *
 * <p>One of the purposes of this class is to provide a surface in which a
 * secondary thread can render into the screen. If you are going to use it
 * this way, you need to be aware of some threading semantics:
 *
 * <ul>
 * <li> All SurfaceView and
 * {@link android.view.SurfaceHolder.Callback SurfaceHolder.Callback} methods will be called
 * from the thread running the SurfaceView's window (typically the main thread
 * of the application). They thus need to correctly synchronize with any
 * state that is also touched by the drawing thread.
 * <li> You must ensure that the drawing thread only touches the underlying
 * Surface while it is valid -- between
 * {@link android.view.SurfaceHolder.Callback#surfaceCreated SurfaceHolder.Callback#surfaceCreated}
 * and
 * {@link android.view.SurfaceHolder.Callback#surfaceDestroyed SurfaceHolder.Callback#surfaceDestroyed}.
 * </ul>
 *
 * <p class="note"><strong>Note:</strong> Starting in platform version
 * {@link android.os.Build.VERSION_CODES#N}, SurfaceView's window position is
 * updated synchronously with other View rendering. This means that translating
 * and scaling a SurfaceView on screen will not cause rendering artifacts. Such
 * artifacts may occur on previous versions of the platform when its window is
 * positioned asynchronously.</p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SurfaceView extends android.view.View {

/** @apiSince 1 */

public SurfaceView(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public SurfaceView(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public SurfaceView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 21 */

public SurfaceView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Return the SurfaceHolder providing access and control over this
 * SurfaceView's underlying surface.
 *
 * @return SurfaceHolder The holder of the surface.
 * @apiSince 1
 */

public android.view.SurfaceHolder getHolder() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onAttachedToWindow() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onWindowVisibilityChanged(int visibility) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void setVisibility(int visibility) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public void setAlpha(float alpha) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onDetachedFromWindow() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean gatherTransparentRegion(android.graphics.Region region) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void draw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

protected void dispatchDraw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * Control whether the surface view's surface is placed on top of another
 * regular surface view in the window (but still behind the window itself).
 * This is typically used to place overlays on top of an underlying media
 * surface view.
 *
 * <p>Note that this must be set before the surface view's containing
 * window is attached to the window manager.
 *
 * <p>Calling this overrides any previous call to {@link #setZOrderOnTop}.
 * @apiSince 5
 */

public void setZOrderMediaOverlay(boolean isMediaOverlay) { throw new RuntimeException("Stub!"); }

/**
 * Control whether the surface view's surface is placed on top of its
 * window.  Normally it is placed behind the window, to allow it to
 * (for the most part) appear to composite with the views in the
 * hierarchy.  By setting this, you cause it to be placed above the
 * window.  This means that none of the contents of the window this
 * SurfaceView is in will be visible on top of its surface.
 *
 * <p>Note that this must be set before the surface view's containing
 * window is attached to the window manager.
 *
 * <p>Calling this overrides any previous call to {@link #setZOrderMediaOverlay}.
 * @apiSince 5
 */

public void setZOrderOnTop(boolean onTop) { throw new RuntimeException("Stub!"); }

/**
 * Control whether the surface view's content should be treated as secure,
 * preventing it from appearing in screenshots or from being viewed on
 * non-secure displays.
 *
 * <p>Note that this must be set before the surface view's containing
 * window is attached to the window manager.
 *
 * <p>See {@link android.view.Display#FLAG_SECURE} for details.
 *
 * @param isSecure True if the surface view is secure.
 * @apiSince 17
 */

public void setSecure(boolean isSecure) { throw new RuntimeException("Stub!"); }

/**
 * Return a SurfaceControl which can be used for parenting Surfaces to
 * this SurfaceView.
 *
 * @return The SurfaceControl for this SurfaceView.
 * @apiSince 29
 */

public android.view.SurfaceControl getSurfaceControl() { throw new RuntimeException("Stub!"); }
}

