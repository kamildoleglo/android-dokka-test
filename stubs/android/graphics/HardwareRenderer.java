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


package android.graphics;

import android.app.Activity;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.PixelCopy;
import java.util.concurrent.Executor;

/**
 * <p>Creates an instance of a hardware-accelerated renderer. This is used to render a scene built
 * from {@link android.graphics.RenderNode RenderNode}'s to an output {@link android.view.Surface}. There can be as many
 * HardwareRenderer instances as desired.</p>
 *
 * <h3>Resources & lifecycle</h3>
 *
 * <p>All HardwareRenderer instances share a common render thread. The render thread contains
 * the GPU context & resources necessary to do GPU-accelerated rendering. As such, the first
 * HardwareRenderer created comes with the cost of also creating the associated GPU contexts,
 * however each incremental HardwareRenderer thereafter is fairly cheap. The expected usage
 * is to have a HardwareRenderer instance for every active {@link android.view.Surface Surface}. For example
 * when an Activity shows a Dialog the system internally will use 2 hardware renderers, both
 * of which may be drawing at the same time.</p>
 *
 * <p>NOTE: Due to the shared, cooperative nature of the render thread it is critical that
 * any {@link android.view.Surface Surface} used must have a prompt, reliable consuming side. System-provided
 * consumers such as {@link android.view.SurfaceView},
 * {@link android.view.Window#takeSurface(SurfaceHolder.Callback2)},
 * or {@link android.view.TextureView} all fit this requirement. However if custom consumers
 * are used such as when using {@link android.graphics.SurfaceTexture SurfaceTexture} or {@link android.media.ImageReader}
 * it is the app's responsibility to ensure that they consume updates promptly and rapidly.
 * Failure to do so will cause the render thread to stall on that surface, blocking all
 * HardwareRenderer instances.</p>
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class HardwareRenderer {

/**
 * Creates a new instance of a HardwareRenderer. The HardwareRenderer will default
 * to opaque with no light source configured.
 * @apiSince 29
 */

public HardwareRenderer() { throw new RuntimeException("Stub!"); }

/**
 * Destroys the rendering context of this HardwareRenderer. This destroys the resources
 * associated with this renderer and releases the currently set {@link android.view.Surface Surface}. This must
 * be called when this HardwareRenderer is no longer needed.
 *
 * <p>The renderer may be restored from this state by setting a new {@link android.view.Surface Surface}, setting
 * new rendering content with {@link #setContentRoot(android.graphics.RenderNode)}, and resuming
 * rendering by issuing a new {@link android.graphics.HardwareRenderer.FrameRenderRequest FrameRenderRequest}.
 *
 * <p>It is recommended to call this in response to callbacks such as
 * {@link android.view.SurfaceHolder.Callback#surfaceDestroyed(SurfaceHolder)}.
 *
 * <p>Note that if there are any outstanding frame commit callbacks they may never being
 * invoked if the frame was deferred to a later vsync.
 * @apiSince 29
 */

public void destroy() { throw new RuntimeException("Stub!"); }

/**
 * Sets a name for this renderer. This is used to identify this renderer instance
 * when reporting debug information such as the per-window frame time metrics
 * reported by 'adb shell dumpsys gfxinfo [package] framestats'
 *
 * @param name The debug name to use for this HardwareRenderer instance
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void setName(@androidx.annotation.NonNull java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Sets the center of the light source. The light source point controls the directionality
 * and shape of shadows rendered by RenderNode Z & elevation.
 *
 * <p>The platform's recommendation is to set lightX to 'displayWidth / 2f - windowLeft', set
 * lightY to 0 - windowTop, lightZ set to 600dp, and lightRadius to 800dp.
 *
 * <p>The light source should be setup both as part of initial configuration, and whenever
 * the window moves to ensure the light source stays anchored in display space instead
 * of in window space.
 *
 * <p>This must be set at least once along with {@link #setLightSourceAlpha(float,float)}
 * before shadows will work.
 *
 * @param lightX      The X position of the light source
 * @param lightY      The Y position of the light source
 * @param lightZ      The Z position of the light source. Must be >= 0.
 * @param lightRadius The radius of the light source. Smaller radius will have sharper edges,
 *                    larger radius will have softer shadows.
 * @apiSince 29
 */

public void setLightSourceGeometry(float lightX, float lightY, float lightZ, float lightRadius) { throw new RuntimeException("Stub!"); }

/**
 * Configures the ambient & spot shadow alphas. This is the alpha used when the shadow
 * has max alpha, and ramps down from the values provided to zero.
 *
 * <p>These values are typically provided by the current theme, see
 * {@link android.R.attr#spotShadowAlpha} and {@link android.R.attr#ambientShadowAlpha}.
 *
 * <p>This must be set at least once along with
 * {@link #setLightSourceGeometry(float,float,float,float)} before shadows will work.
 *
 * @param ambientShadowAlpha The alpha for the ambient shadow. If unsure, a reasonable default
 *                           is 0.039f.
 * Value is between 0.0f and 1.0f inclusive
 * @param spotShadowAlpha    The alpha for the spot shadow. If unsure, a reasonable default is
 *                           0.19f.
 
 * Value is between 0.0f and 1.0f inclusive
 * @apiSince 29
 */

public void setLightSourceAlpha(float ambientShadowAlpha, float spotShadowAlpha) { throw new RuntimeException("Stub!"); }

/**
 * Sets the content root to render. It is not necessary to call this whenever the content
 * recording changes. Any mutations to the RenderNode content, or any of the RenderNode's
 * contained within the content node, will be applied whenever a new {@link android.graphics.HardwareRenderer.FrameRenderRequest FrameRenderRequest}
 * is issued via {@link #createRenderRequest()} and {@link android.graphics.HardwareRenderer.FrameRenderRequest#syncAndDraw() FrameRenderRequest#syncAndDraw()}.
 *
 * @param content The content to set as the root RenderNode. If null the content root is removed
 *                and the renderer will draw nothing.
 
 * This value may be {@code null}.
 * @apiSince 29
 */

public void setContentRoot(@androidx.annotation.Nullable android.graphics.RenderNode content) { throw new RuntimeException("Stub!"); }

/**
 * <p>The surface to render into. The surface is assumed to be associated with the display and
 * as such is still driven by vsync signals such as those from
 * {@link android.view.Choreographer} and that it has a native refresh rate matching that of
 * the display's (typically 60hz).</p>
 *
 * <p>NOTE: Due to the shared, cooperative nature of the render thread it is critical that
 * any {@link android.view.Surface Surface} used must have a prompt, reliable consuming side. System-provided
 * consumers such as {@link android.view.SurfaceView},
 * {@link android.view.Window#takeSurface(SurfaceHolder.Callback2)},
 * or {@link android.view.TextureView} all fit this requirement. However if custom consumers
 * are used such as when using {@link android.graphics.SurfaceTexture SurfaceTexture} or {@link android.media.ImageReader}
 * it is the app's responsibility to ensure that they consume updates promptly and rapidly.
 * Failure to do so will cause the render thread to stall on that surface, blocking all
 * HardwareRenderer instances.</p>
 *
 * @param surface The surface to render into. If null then rendering will be stopped. If
 *                non-null then {@link android.view.Surface#isValid() Surface#isValid()} must be true.
 
 * This value may be {@code null}.
 * @apiSince 29
 */

public void setSurface(@androidx.annotation.Nullable android.view.Surface surface) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link android.graphics.HardwareRenderer.FrameRenderRequest FrameRenderRequest} that can be used to render a new frame. This is used
 * to synchronize the RenderNode content provided by {@link #setContentRoot(android.graphics.RenderNode)} with
 * the RenderThread and then renders a single frame to the Surface set with
 * {@link #setSurface(android.view.Surface)}.
 *
 * @return An instance of {@link android.graphics.HardwareRenderer.FrameRenderRequest FrameRenderRequest}. The instance may be reused for every
 * frame, so the caller should not hold onto it for longer than a single render request.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.HardwareRenderer.FrameRenderRequest createRenderRequest() { throw new RuntimeException("Stub!"); }

/**
 * Hard stops rendering into the surface. If the renderer is stopped it will
 * block any attempt to render. Calls to {@link android.graphics.HardwareRenderer.FrameRenderRequest#syncAndDraw() FrameRenderRequest#syncAndDraw()} will
 * still sync over the latest rendering content, however they will not render and instead
 * {@link #SYNC_CONTEXT_IS_STOPPED} will be returned.
 *
 * <p>This is useful in combination with lifecycle events such as {@link android.app.Activity#onStop() Activity#onStop()}.
 * See {@link #start()} for resuming rendering.
 * @apiSince 29
 */

public void stop() { throw new RuntimeException("Stub!"); }

/**
 * Resumes rendering into the surface. Any pending rendering requests
 * will produce a new frame at the next vsync signal.
 *
 * <p>This is useful in combination with lifecycle events such as {@link android.app.Activity#onStart() Activity#onStart()}.
 * See {@link #stop()} for stopping rendering.
 * @apiSince 29
 */

public void start() { throw new RuntimeException("Stub!"); }

/**
 * Destroys all the display lists associated with the current rendering content.
 * This includes releasing a reference to the current content root RenderNode. It will
 * therefore be necessary to call {@link #setContentRoot(android.graphics.RenderNode)} in order to resume
 * rendering after calling this, along with re-recording the display lists for the
 * RenderNode tree.
 *
 * <p>It is recommended, but not necessary, to use this in combination with lifecycle events
 * such as {@link android.app.Activity#onStop() Activity#onStop()} and {@link android.app.Activity#onStart() Activity#onStart()} or in response to
 * {@link android.content.ComponentCallbacks2#onTrimMemory(int)} signals such as
 * {@link android.content.ComponentCallbacks2#TRIM_MEMORY_UI_HIDDEN}
 *
 * See also {@link #stop()}.
 * @apiSince 29
 */

public void clearContent() { throw new RuntimeException("Stub!"); }

/**
 * Notifies the hardware renderer that a call to {@link android.graphics.HardwareRenderer.FrameRenderRequest#syncAndDraw() FrameRenderRequest#syncAndDraw()} will
 * be coming soon. This is used to help schedule when RenderThread-driven animations will
 * happen as the renderer wants to avoid producing more than one frame per vsync signal.
 * @apiSince 29
 */

public void notifyFramePending() { throw new RuntimeException("Stub!"); }

/**
 * Change the HardwareRenderer's opacity. Will take effect on the next frame produced.
 *
 * <p>If the renderer is set to opaque it is the app's responsibility to ensure that the
 * content renders to every pixel of the Surface, otherwise corruption may result. Note that
 * this includes ensuring that the first draw of any given pixel does not attempt to blend
 * against the destination. If this is false then the hardware renderer will clear to
 * transparent at the start of every frame.
 *
 * @param opaque true if the content rendered is opaque, false if the renderer should clear
 *               to transparent before rendering
 * @apiSince 29
 */

public void setOpaque(boolean opaque) { throw new RuntimeException("Stub!"); }

/**
 * Whether or not the renderer is set to be opaque. See {@link #setOpaque(boolean)}
 *
 * @return true if the renderer is opaque, false otherwise
 * @apiSince 29
 */

public boolean isOpaque() { throw new RuntimeException("Stub!"); }

/**
 * The hardware renderer has been set to a "stopped" state. If this is returned then the
 * rendering content has been synced, however a frame was not produced.
 * @apiSince 29
 */

public static final int SYNC_CONTEXT_IS_STOPPED = 4; // 0x4

/**
 * The content was synced but the renderer has declined to produce a frame in this vsync
 * interval. This can happen if a frame was already drawn in this vsync or if the renderer
 * is outrunning the frame consumer. The renderer will internally re-schedule itself
 * to render a frame in the next vsync signal, so the caller does not need to do anything
 * in response to this signal.
 * @apiSince 29
 */

public static final int SYNC_FRAME_DROPPED = 8; // 0x8

/**
 * The hardware renderer no longer has a valid {@link android.view.Surface} to render to.
 * This can happen if {@link android.view.Surface#release() Surface#release()} was called. The user should no longer
 * attempt to call syncAndDraw until a new surface has been provided by calling
 * setSurface.
 *
 * <p>Spoiler: the reward is GPU-accelerated drawing, better find that Surface!
 * @apiSince 29
 */

public static final int SYNC_LOST_SURFACE_REWARD_IF_FOUND = 2; // 0x2

/**
 * Nothing interesting to report. Sync & draw kicked off
 * @apiSince 29
 */

public static final int SYNC_OK = 0; // 0x0

/**
 * The renderer is requesting a redraw. This can occur if there's an animation that's running
 * in the RenderNode tree and the hardware renderer is unable to self-animate.
 *
 * <p>If this is returned from syncAndDraw the expectation is that syncAndDraw
 * will be called again on the next vsync signal.
 * @apiSince 29
 */

public static final int SYNC_REDRAW_REQUESTED = 1; // 0x1
/**
 * Sets the parameters that can be used to control a render request for a
 * {@link android.graphics.HardwareRenderer HardwareRenderer}. This is not thread-safe and must not be held on to for longer
 * than a single frame request.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class FrameRenderRequest {

private FrameRenderRequest() { throw new RuntimeException("Stub!"); }

/**
 * Sets the vsync time that represents the start point of this frame. Typically this
 * comes from {@link android.view.Choreographer.FrameCallback}. Other compatible time
 * sources include {@link java.lang.System#nanoTime() System#nanoTime()}, however if the result is being displayed
 * on-screen then using {@link android.view.Choreographer} is strongly recommended to
 * ensure smooth animations.
 *
 * <p>If the clock source is not from a CLOCK_MONOTONIC source then any animations driven
 * directly by RenderThread will not be synchronized properly with the current frame.
 *
 * @param vsyncTime The vsync timestamp for this frame. The timestamp is in nanoseconds
 *                  and should come from a CLOCK_MONOTONIC source.
 *
 * @return this instance
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.HardwareRenderer.FrameRenderRequest setVsyncTime(long vsyncTime) { throw new RuntimeException("Stub!"); }

/**
 * Adds a frame commit callback. This callback will be invoked when the current rendering
 * content has been rendered into a frame and submitted to the swap chain. The frame may
 * not currently be visible on the display when this is invoked, but it has been submitted.
 * This callback is useful in combination with {@link android.view.PixelCopy PixelCopy} to capture the current
 * rendered content of the UI reliably.
 *
 * @param executor The executor to run the callback on. It is strongly recommended that
 *                 this executor post to a different thread, as the calling thread is
 *                 highly sensitive to being blocked.
 * This value must never be {@code null}.
 * @param frameCommitCallback The callback to invoke when the frame content has been drawn.
 *                            Will be invoked on the given {@link java.util.concurrent.Executor Executor}.
 *
 * This value must never be {@code null}.
 * @return this instance
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.HardwareRenderer.FrameRenderRequest setFrameCommitCallback(@androidx.annotation.NonNull java.util.concurrent.Executor executor, @androidx.annotation.NonNull java.lang.Runnable frameCommitCallback) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether or not {@link #syncAndDraw()} should block until the frame has been
 * presented. If this is true and {@link #syncAndDraw()} does not return
 * {@link #SYNC_FRAME_DROPPED} or an error then when {@link #syncAndDraw()} has returned
 * the frame has been submitted to the {@link android.view.Surface Surface}. The default and typically
 * recommended value is false, as blocking for present will prevent pipelining from
 * happening, reducing overall throughput. This is useful for situations such as
 * {@link android.view.SurfaceHolder.Callback2#surfaceRedrawNeeded(android.view.SurfaceHolder) SurfaceHolder.Callback2#surfaceRedrawNeeded(SurfaceHolder)} where it is desired
 * to block until a frame has been presented to ensure first-frame consistency with
 * other Surfaces.
 *
 * @param shouldWait If true the next call to {@link #syncAndDraw()} will block until
 *                   completion.
 * @return this instance
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.HardwareRenderer.FrameRenderRequest setWaitForPresent(boolean shouldWait) { throw new RuntimeException("Stub!"); }

/**
 * Syncs the RenderNode tree to the render thread and requests a frame to be drawn. This
 * {@link android.graphics.HardwareRenderer.FrameRenderRequest FrameRenderRequest} instance should no longer be used after calling this method.
 * The system internally may reuse instances of {@link android.graphics.HardwareRenderer.FrameRenderRequest FrameRenderRequest} to reduce
 * allocation churn.
 *
 * @return The result of the sync operation.
 
 * Value is {@link android.graphics.HardwareRenderer#SYNC_OK}, {@link android.graphics.HardwareRenderer#SYNC_REDRAW_REQUESTED}, {@link android.graphics.HardwareRenderer#SYNC_LOST_SURFACE_REWARD_IF_FOUND}, {@link android.graphics.HardwareRenderer#SYNC_CONTEXT_IS_STOPPED}, or {@link android.graphics.HardwareRenderer#SYNC_FRAME_DROPPED}
 * @apiSince 29
 */

public int syncAndDraw() { throw new RuntimeException("Stub!"); }
}

}

