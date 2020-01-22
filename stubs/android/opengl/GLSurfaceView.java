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


package android.opengl;

import javax.microedition.khronos.egl.EGLConfig;
import android.view.SurfaceView;
import javax.microedition.khronos.opengles.GL;
import android.content.Context;
import javax.microedition.khronos.egl.EGLContext;
import android.view.SurfaceHolder;
import android.util.Log;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.egl.EGL10;

/**
 * An implementation of SurfaceView that uses the dedicated surface for
 * displaying OpenGL rendering.
 * <p>
 * A GLSurfaceView provides the following features:
 * <p>
 * <ul>
 * <li>Manages a surface, which is a special piece of memory that can be
 * composited into the Android view system.
 * <li>Manages an EGL display, which enables OpenGL to render into a surface.
 * <li>Accepts a user-provided Renderer object that does the actual rendering.
 * <li>Renders on a dedicated thread to decouple rendering performance from the
 * UI thread.
 * <li>Supports both on-demand and continuous rendering.
 * <li>Optionally wraps, traces, and/or error-checks the renderer's OpenGL calls.
 * </ul>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about how to use OpenGL, read the
 * <a href="{@docRoot}guide/topics/graphics/opengl.html">OpenGL</a> developer guide.</p>
 * </div>
 *
 * <h3>Using GLSurfaceView</h3>
 * <p>
 * Typically you use GLSurfaceView by subclassing it and overriding one or more of the
 * View system input event methods. If your application does not need to override event
 * methods then GLSurfaceView can be used as-is. For the most part
 * GLSurfaceView behavior is customized by calling "set" methods rather than by subclassing.
 * For example, unlike a regular View, drawing is delegated to a separate Renderer object which
 * is registered with the GLSurfaceView
 * using the {@link #setRenderer(android.opengl.GLSurfaceView.Renderer)} call.
 * <p>
 * <h3>Initializing GLSurfaceView</h3>
 * All you have to do to initialize a GLSurfaceView is call {@link #setRenderer(android.opengl.GLSurfaceView.Renderer)}.
 * However, if desired, you can modify the default behavior of GLSurfaceView by calling one or
 * more of these methods before calling setRenderer:
 * <ul>
 * <li>{@link #setDebugFlags(int)}
 * <li>{@link #setEGLConfigChooser(boolean)}
 * <li>{@link #setEGLConfigChooser(android.opengl.GLSurfaceView.EGLConfigChooser)}
 * <li>{@link #setEGLConfigChooser(int,int,int,int,int,int)}
 * <li>{@link #setGLWrapper(android.opengl.GLSurfaceView.GLWrapper)}
 * </ul>
 * <p>
 * <h4>Specifying the android.view.Surface</h4>
 * By default GLSurfaceView will create a PixelFormat.RGB_888 format surface. If a translucent
 * surface is required, call getHolder().setFormat(PixelFormat.TRANSLUCENT).
 * The exact format of a TRANSLUCENT surface is device dependent, but it will be
 * a 32-bit-per-pixel surface with 8 bits per component.
 * <p>
 * <h4>Choosing an EGL Configuration</h4>
 * A given Android device may support multiple EGLConfig rendering configurations.
 * The available configurations may differ in how many channels of data are present, as
 * well as how many bits are allocated to each channel. Therefore, the first thing
 * GLSurfaceView has to do when starting to render is choose what EGLConfig to use.
 * <p>
 * By default GLSurfaceView chooses a EGLConfig that has an RGB_888 pixel format,
 * with at least a 16-bit depth buffer and no stencil.
 * <p>
 * If you would prefer a different EGLConfig
 * you can override the default behavior by calling one of the
 * setEGLConfigChooser methods.
 * <p>
 * <h4>Debug Behavior</h4>
 * You can optionally modify the behavior of GLSurfaceView by calling
 * one or more of the debugging methods {@link #setDebugFlags(int)},
 * and {@link #setGLWrapper}. These methods may be called before and/or after setRenderer, but
 * typically they are called before setRenderer so that they take effect immediately.
 * <p>
 * <h4>Setting a Renderer</h4>
 * Finally, you must call {@link #setRenderer} to register a {@link android.opengl.GLSurfaceView.Renderer Renderer}.
 * The renderer is
 * responsible for doing the actual OpenGL rendering.
 * <p>
 * <h3>Rendering Mode</h3>
 * Once the renderer is set, you can control whether the renderer draws
 * continuously or on-demand by calling
 * {@link #setRenderMode}. The default is continuous rendering.
 * <p>
 * <h3>Activity Life-cycle</h3>
 * A GLSurfaceView must be notified when to pause and resume rendering. GLSurfaceView clients
 * are required to call {@link #onPause()} when the activity stops and
 * {@link #onResume()} when the activity starts. These calls allow GLSurfaceView to
 * pause and resume the rendering thread, and also allow GLSurfaceView to release and recreate
 * the OpenGL display.
 * <p>
 * <h3>Handling events</h3>
 * <p>
 * To handle an event you will typically subclass GLSurfaceView and override the
 * appropriate method, just as you would with any other View. However, when handling
 * the event, you may need to communicate with the Renderer object
 * that's running in the rendering thread. You can do this using any
 * standard Java cross-thread communication mechanism. In addition,
 * one relatively easy way to communicate with your renderer is
 * to call
 * {@link #queueEvent(java.lang.Runnable)}. For example:
 * <pre class="prettyprint">
 * class MyGLSurfaceView extends GLSurfaceView {
 *
 *     private MyRenderer mMyRenderer;
 *
 *     public void start() {
 *         mMyRenderer = ...;
 *         setRenderer(mMyRenderer);
 *     }
 *
 *     public boolean onKeyDown(int keyCode, KeyEvent event) {
 *         if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
 *             queueEvent(new Runnable() {
 *                 // This method will be called on the rendering
 *                 // thread:
 *                 public void run() {
 *                     mMyRenderer.handleDpadCenter();
 *                 }});
 *             return true;
 *         }
 *         return super.onKeyDown(keyCode, event);
 *     }
 * }
 * </pre>
 *
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class GLSurfaceView extends android.view.SurfaceView implements android.view.SurfaceHolder.Callback2 {

/**
 * Standard View constructor. In order to render something, you
 * must call {@link #setRenderer} to register a renderer.
 * @apiSince 3
 */

public GLSurfaceView(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Standard View constructor. In order to render something, you
 * must call {@link #setRenderer} to register a renderer.
 * @apiSince 3
 */

public GLSurfaceView(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Set the glWrapper. If the glWrapper is not null, its
 * {@link android.opengl.GLSurfaceView.GLWrapper#wrap(javax.microedition.khronos.opengles.GL) GLWrapper#wrap(GL)} method is called
 * whenever a surface is created. A GLWrapper can be used to wrap
 * the GL object that's passed to the renderer. Wrapping a GL
 * object enables examining and modifying the behavior of the
 * GL calls made by the renderer.
 * <p>
 * Wrapping is typically used for debugging purposes.
 * <p>
 * The default value is null.
 * @param glWrapper the new GLWrapper
 * @apiSince 3
 */

public void setGLWrapper(android.opengl.GLSurfaceView.GLWrapper glWrapper) { throw new RuntimeException("Stub!"); }

/**
 * Set the debug flags to a new value. The value is
 * constructed by OR-together zero or more
 * of the DEBUG_CHECK_* constants. The debug flags take effect
 * whenever a surface is created. The default value is zero.
 * @param debugFlags the new debug flags
 * @see #DEBUG_CHECK_GL_ERROR
 * @see #DEBUG_LOG_GL_CALLS
 * @apiSince 3
 */

public void setDebugFlags(int debugFlags) { throw new RuntimeException("Stub!"); }

/**
 * Get the current value of the debug flags.
 * @return the current value of the debug flags.
 * @apiSince 3
 */

public int getDebugFlags() { throw new RuntimeException("Stub!"); }

/**
 * Control whether the EGL context is preserved when the GLSurfaceView is paused and
 * resumed.
 * <p>
 * If set to true, then the EGL context may be preserved when the GLSurfaceView is paused.
 * <p>
 * Prior to API level 11, whether the EGL context is actually preserved or not
 * depends upon whether the Android device can support an arbitrary number of
 * EGL contexts or not. Devices that can only support a limited number of EGL
 * contexts must release the EGL context in order to allow multiple applications
 * to share the GPU.
 * <p>
 * If set to false, the EGL context will be released when the GLSurfaceView is paused,
 * and recreated when the GLSurfaceView is resumed.
 * <p>
 *
 * The default is false.
 *
 * @param preserveOnPause preserve the EGL context when paused
 * @apiSince 11
 */

public void setPreserveEGLContextOnPause(boolean preserveOnPause) { throw new RuntimeException("Stub!"); }

/**
 * @return true if the EGL context will be preserved when paused
 * @apiSince 11
 */

public boolean getPreserveEGLContextOnPause() { throw new RuntimeException("Stub!"); }

/**
 * Set the renderer associated with this view. Also starts the thread that
 * will call the renderer, which in turn causes the rendering to start.
 * <p>This method should be called once and only once in the life-cycle of
 * a GLSurfaceView.
 * <p>The following GLSurfaceView methods can only be called <em>before</em>
 * setRenderer is called:
 * <ul>
 * <li>{@link #setEGLConfigChooser(boolean)}
 * <li>{@link #setEGLConfigChooser(android.opengl.GLSurfaceView.EGLConfigChooser)}
 * <li>{@link #setEGLConfigChooser(int,int,int,int,int,int)}
 * </ul>
 * <p>
 * The following GLSurfaceView methods can only be called <em>after</em>
 * setRenderer is called:
 * <ul>
 * <li>{@link #getRenderMode()}
 * <li>{@link #onPause()}
 * <li>{@link #onResume()}
 * <li>{@link #queueEvent(java.lang.Runnable)}
 * <li>{@link #requestRender()}
 * <li>{@link #setRenderMode(int)}
 * </ul>
 *
 * @param renderer the renderer to use to perform OpenGL drawing.
 * @apiSince 3
 */

public void setRenderer(android.opengl.GLSurfaceView.Renderer renderer) { throw new RuntimeException("Stub!"); }

/**
 * Install a custom EGLContextFactory.
 * <p>If this method is
 * called, it must be called before {@link #setRenderer(android.opengl.GLSurfaceView.Renderer)}
 * is called.
 * <p>
 * If this method is not called, then by default
 * a context will be created with no shared context and
 * with a null attribute list.
 * @apiSince 5
 */

public void setEGLContextFactory(android.opengl.GLSurfaceView.EGLContextFactory factory) { throw new RuntimeException("Stub!"); }

/**
 * Install a custom EGLWindowSurfaceFactory.
 * <p>If this method is
 * called, it must be called before {@link #setRenderer(android.opengl.GLSurfaceView.Renderer)}
 * is called.
 * <p>
 * If this method is not called, then by default
 * a window surface will be created with a null attribute list.
 * @apiSince 5
 */

public void setEGLWindowSurfaceFactory(android.opengl.GLSurfaceView.EGLWindowSurfaceFactory factory) { throw new RuntimeException("Stub!"); }

/**
 * Install a custom EGLConfigChooser.
 * <p>If this method is
 * called, it must be called before {@link #setRenderer(android.opengl.GLSurfaceView.Renderer)}
 * is called.
 * <p>
 * If no setEGLConfigChooser method is called, then by default the
 * view will choose an EGLConfig that is compatible with the current
 * android.view.Surface, with a depth buffer depth of
 * at least 16 bits.
 * @param configChooser
 * @apiSince 3
 */

public void setEGLConfigChooser(android.opengl.GLSurfaceView.EGLConfigChooser configChooser) { throw new RuntimeException("Stub!"); }

/**
 * Install a config chooser which will choose a config
 * as close to 16-bit RGB as possible, with or without an optional depth
 * buffer as close to 16-bits as possible.
 * <p>If this method is
 * called, it must be called before {@link #setRenderer(android.opengl.GLSurfaceView.Renderer)}
 * is called.
 * <p>
 * If no setEGLConfigChooser method is called, then by default the
 * view will choose an RGB_888 surface with a depth buffer depth of
 * at least 16 bits.
 *
 * @param needDepth
 * @apiSince 3
 */

public void setEGLConfigChooser(boolean needDepth) { throw new RuntimeException("Stub!"); }

/**
 * Install a config chooser which will choose a config
 * with at least the specified depthSize and stencilSize,
 * and exactly the specified redSize, greenSize, blueSize and alphaSize.
 * <p>If this method is
 * called, it must be called before {@link #setRenderer(android.opengl.GLSurfaceView.Renderer)}
 * is called.
 * <p>
 * If no setEGLConfigChooser method is called, then by default the
 * view will choose an RGB_888 surface with a depth buffer depth of
 * at least 16 bits.
 *
 * @apiSince 3
 */

public void setEGLConfigChooser(int redSize, int greenSize, int blueSize, int alphaSize, int depthSize, int stencilSize) { throw new RuntimeException("Stub!"); }

/**
 * Inform the default EGLContextFactory and default EGLConfigChooser
 * which EGLContext client version to pick.
 * <p>Use this method to create an OpenGL ES 2.0-compatible context.
 * Example:
 * <pre class="prettyprint">
 *     public MyView(Context context) {
 *         super(context);
 *         setEGLContextClientVersion(2); // Pick an OpenGL ES 2.0 context.
 *         setRenderer(new MyRenderer());
 *     }
 * </pre>
 * <p>Note: Activities which require OpenGL ES 2.0 should indicate this by
 * setting @lt;uses-feature android:glEsVersion="0x00020000" /> in the activity's
 * AndroidManifest.xml file.
 * <p>If this method is called, it must be called before {@link #setRenderer(android.opengl.GLSurfaceView.Renderer)}
 * is called.
 * <p>This method only affects the behavior of the default EGLContexFactory and the
 * default EGLConfigChooser. If
 * {@link #setEGLContextFactory(android.opengl.GLSurfaceView.EGLContextFactory)} has been called, then the supplied
 * EGLContextFactory is responsible for creating an OpenGL ES 2.0-compatible context.
 * If
 * {@link #setEGLConfigChooser(android.opengl.GLSurfaceView.EGLConfigChooser)} has been called, then the supplied
 * EGLConfigChooser is responsible for choosing an OpenGL ES 2.0-compatible config.
 * @param version The EGLContext client version to choose. Use 2 for OpenGL ES 2.0
 * @apiSince 8
 */

public void setEGLContextClientVersion(int version) { throw new RuntimeException("Stub!"); }

/**
 * Set the rendering mode. When renderMode is
 * RENDERMODE_CONTINUOUSLY, the renderer is called
 * repeatedly to re-render the scene. When renderMode
 * is RENDERMODE_WHEN_DIRTY, the renderer only rendered when the surface
 * is created, or when {@link #requestRender} is called. Defaults to RENDERMODE_CONTINUOUSLY.
 * <p>
 * Using RENDERMODE_WHEN_DIRTY can improve battery life and overall system performance
 * by allowing the GPU and CPU to idle when the view does not need to be updated.
 * <p>
 * This method can only be called after {@link #setRenderer(android.opengl.GLSurfaceView.Renderer)}
 *
 * @param renderMode one of the RENDERMODE_X constants
 * @see #RENDERMODE_CONTINUOUSLY
 * @see #RENDERMODE_WHEN_DIRTY
 * @apiSince 3
 */

public void setRenderMode(int renderMode) { throw new RuntimeException("Stub!"); }

/**
 * Get the current rendering mode. May be called
 * from any thread. Must not be called before a renderer has been set.
 * @return the current rendering mode.
 * @see #RENDERMODE_CONTINUOUSLY
 * @see #RENDERMODE_WHEN_DIRTY
 * @apiSince 3
 */

public int getRenderMode() { throw new RuntimeException("Stub!"); }

/**
 * Request that the renderer render a frame.
 * This method is typically used when the render mode has been set to
 * {@link #RENDERMODE_WHEN_DIRTY}, so that frames are only rendered on demand.
 * May be called
 * from any thread. Must not be called before a renderer has been set.
 * @apiSince 3
 */

public void requestRender() { throw new RuntimeException("Stub!"); }

/**
 * This method is part of the SurfaceHolder.Callback interface, and is
 * not normally called or subclassed by clients of GLSurfaceView.
 * @apiSince 3
 */

public void surfaceCreated(android.view.SurfaceHolder holder) { throw new RuntimeException("Stub!"); }

/**
 * This method is part of the SurfaceHolder.Callback interface, and is
 * not normally called or subclassed by clients of GLSurfaceView.
 * @apiSince 3
 */

public void surfaceDestroyed(android.view.SurfaceHolder holder) { throw new RuntimeException("Stub!"); }

/**
 * This method is part of the SurfaceHolder.Callback interface, and is
 * not normally called or subclassed by clients of GLSurfaceView.
 * @apiSince 3
 */

public void surfaceChanged(android.view.SurfaceHolder holder, int format, int w, int h) { throw new RuntimeException("Stub!"); }

/**
 * This method is part of the SurfaceHolder.Callback2 interface, and is
 * not normally called or subclassed by clients of GLSurfaceView.
 * @apiSince 26
 */

public void surfaceRedrawNeededAsync(android.view.SurfaceHolder holder, java.lang.Runnable finishDrawing) { throw new RuntimeException("Stub!"); }

/**
 * This method is part of the SurfaceHolder.Callback2 interface, and is
 * not normally called or subclassed by clients of GLSurfaceView.
 * @apiSince 24
 */

@Deprecated
public void surfaceRedrawNeeded(android.view.SurfaceHolder holder) { throw new RuntimeException("Stub!"); }

/**
 * Pause the rendering thread, optionally tearing down the EGL context
 * depending upon the value of {@link #setPreserveEGLContextOnPause(boolean)}.
 *
 * This method should be called when it is no longer desirable for the
 * GLSurfaceView to continue rendering, such as in response to
 * {@link android.app.Activity#onStop Activity.onStop}.
 *
 * Must not be called before a renderer has been set.
 * @apiSince 3
 */

public void onPause() { throw new RuntimeException("Stub!"); }

/**
 * Resumes the rendering thread, re-creating the OpenGL context if necessary. It
 * is the counterpart to {@link #onPause()}.
 *
 * This method should typically be called in
 * {@link android.app.Activity#onStart Activity.onStart}.
 *
 * Must not be called before a renderer has been set.
 * @apiSince 3
 */

public void onResume() { throw new RuntimeException("Stub!"); }

/**
 * Queue a runnable to be run on the GL rendering thread. This can be used
 * to communicate with the Renderer on the rendering thread.
 * Must not be called before a renderer has been set.
 * @param r the runnable to be run on the GL rendering thread.
 * @apiSince 3
 */

public void queueEvent(java.lang.Runnable r) { throw new RuntimeException("Stub!"); }

/**
 * This method is used as part of the View class and is not normally
 * called or subclassed by clients of GLSurfaceView.
 * @apiSince 3
 */

protected void onAttachedToWindow() { throw new RuntimeException("Stub!"); }

/** @apiSince 3 */

protected void onDetachedFromWindow() { throw new RuntimeException("Stub!"); }

/**
 * Check glError() after every GL call and throw an exception if glError indicates
 * that an error has occurred. This can be used to help track down which OpenGL ES call
 * is causing an error.
 *
 * @see #getDebugFlags
 * @see #setDebugFlags
 * @apiSince 3
 */

public static final int DEBUG_CHECK_GL_ERROR = 1; // 0x1

/**
 * Log GL calls to the system log at "verbose" level with tag "GLSurfaceView".
 *
 * @see #getDebugFlags
 * @see #setDebugFlags
 * @apiSince 3
 */

public static final int DEBUG_LOG_GL_CALLS = 2; // 0x2

/**
 * The renderer is called
 * continuously to re-render the scene.
 *
 * @see #getRenderMode()
 * @see #setRenderMode(int)
 * @apiSince 3
 */

public static final int RENDERMODE_CONTINUOUSLY = 1; // 0x1

/**
 * The renderer only renders
 * when the surface is created, or when {@link #requestRender} is called.
 *
 * @see #getRenderMode()
 * @see #setRenderMode(int)
 * @see #requestRender()
 * @apiSince 3
 */

public static final int RENDERMODE_WHEN_DIRTY = 0; // 0x0
/**
 * An interface for choosing an EGLConfig configuration from a list of
 * potential configurations.
 * <p>
 * This interface must be implemented by clients wishing to call
 * {@link android.opengl.GLSurfaceView#setEGLConfigChooser(android.opengl.GLSurfaceView.EGLConfigChooser) GLSurfaceView#setEGLConfigChooser(EGLConfigChooser)}
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface EGLConfigChooser {

/**
 * Choose a configuration from the list. Implementors typically
 * implement this method by calling
 * {@link javax.microedition.khronos.egl.EGL10#eglChooseConfig EGL10#eglChooseConfig} and iterating through the results. Please consult the
 * EGL specification available from The Khronos Group to learn how to call eglChooseConfig.
 * @param egl the EGL10 for the current display.
 * @param display the current display.
 * @return the chosen configuration.
 * @apiSince 3
 */

public javax.microedition.khronos.egl.EGLConfig chooseConfig(javax.microedition.khronos.egl.EGL10 egl, javax.microedition.khronos.egl.EGLDisplay display);
}

/**
 * An interface for customizing the eglCreateContext and eglDestroyContext calls.
 * <p>
 * This interface must be implemented by clients wishing to call
 * {@link android.opengl.GLSurfaceView#setEGLContextFactory(android.opengl.GLSurfaceView.EGLContextFactory) GLSurfaceView#setEGLContextFactory(EGLContextFactory)}
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface EGLContextFactory {

/** @apiSince 5 */

public javax.microedition.khronos.egl.EGLContext createContext(javax.microedition.khronos.egl.EGL10 egl, javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLConfig eglConfig);

/** @apiSince 5 */

public void destroyContext(javax.microedition.khronos.egl.EGL10 egl, javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLContext context);
}

/**
 * An interface for customizing the eglCreateWindowSurface and eglDestroySurface calls.
 * <p>
 * This interface must be implemented by clients wishing to call
 * {@link android.opengl.GLSurfaceView#setEGLWindowSurfaceFactory(android.opengl.GLSurfaceView.EGLWindowSurfaceFactory) GLSurfaceView#setEGLWindowSurfaceFactory(EGLWindowSurfaceFactory)}
 * @apiSince 5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface EGLWindowSurfaceFactory {

/**
 *  @return null if the surface cannot be constructed.
 * @apiSince 5
 */

public javax.microedition.khronos.egl.EGLSurface createWindowSurface(javax.microedition.khronos.egl.EGL10 egl, javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLConfig config, java.lang.Object nativeWindow);

/** @apiSince 5 */

public void destroySurface(javax.microedition.khronos.egl.EGL10 egl, javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLSurface surface);
}

/**
 * An interface used to wrap a GL interface.
 * <p>Typically
 * used for implementing debugging and tracing on top of the default
 * GL interface. You would typically use this by creating your own class
 * that implemented all the GL methods by delegating to another GL instance.
 * Then you could add your own behavior before or after calling the
 * delegate. All the GLWrapper would do was instantiate and return the
 * wrapper GL instance:
 * <pre class="prettyprint">
 * class MyGLWrapper implements GLWrapper {
 *     GL wrap(GL gl) {
 *         return new MyGLImplementation(gl);
 *     }
 *     static class MyGLImplementation implements GL,GL10,GL11,... {
 *         ...
 *     }
 * }
 * </pre>
 * @see #setGLWrapper(GLWrapper)
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface GLWrapper {

/**
 * Wraps a gl interface in another gl interface.
 * @param gl a GL interface that is to be wrapped.
 * @return either the input argument or another GL object that wraps the input argument.
 * @apiSince 3
 */

public javax.microedition.khronos.opengles.GL wrap(javax.microedition.khronos.opengles.GL gl);
}

/**
 * A generic renderer interface.
 * <p>
 * The renderer is responsible for making OpenGL calls to render a frame.
 * <p>
 * GLSurfaceView clients typically create their own classes that implement
 * this interface, and then call {@link android.opengl.GLSurfaceView#setRenderer GLSurfaceView#setRenderer} to
 * register the renderer with the GLSurfaceView.
 * <p>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about how to use OpenGL, read the
 * <a href="{@docRoot}guide/topics/graphics/opengl.html">OpenGL</a> developer guide.</p>
 * </div>
 *
 * <h3>Threading</h3>
 * The renderer will be called on a separate thread, so that rendering
 * performance is decoupled from the UI thread. Clients typically need to
 * communicate with the renderer from the UI thread, because that's where
 * input events are received. Clients can communicate using any of the
 * standard Java techniques for cross-thread communication, or they can
 * use the {@link android.opengl.GLSurfaceView#queueEvent(java.lang.Runnable) GLSurfaceView#queueEvent(Runnable)} convenience method.
 * <p>
 * <h3>EGL Context Lost</h3>
 * There are situations where the EGL rendering context will be lost. This
 * typically happens when device wakes up after going to sleep. When
 * the EGL context is lost, all OpenGL resources (such as textures) that are
 * associated with that context will be automatically deleted. In order to
 * keep rendering correctly, a renderer must recreate any lost resources
 * that it still needs. The {@link #onSurfaceCreated(javax.microedition.khronos.opengles.GL10,javax.microedition.khronos.egl.EGLConfig)} method
 * is a convenient place to do this.
 *
 *
 * @see #setRenderer(Renderer)
 * @apiSince 3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface Renderer {

/**
 * Called when the surface is created or recreated.
 * <p>
 * Called when the rendering thread
 * starts and whenever the EGL context is lost. The EGL context will typically
 * be lost when the Android device awakes after going to sleep.
 * <p>
 * Since this method is called at the beginning of rendering, as well as
 * every time the EGL context is lost, this method is a convenient place to put
 * code to create resources that need to be created when the rendering
 * starts, and that need to be recreated when the EGL context is lost.
 * Textures are an example of a resource that you might want to create
 * here.
 * <p>
 * Note that when the EGL context is lost, all OpenGL resources associated
 * with that context will be automatically deleted. You do not need to call
 * the corresponding "glDelete" methods such as glDeleteTextures to
 * manually delete these lost resources.
 * <p>
 * @param gl the GL interface. Use <code>instanceof</code> to
 * test if the interface supports GL11 or higher interfaces.
 * @param config the EGLConfig of the created surface. Can be used
 * to create matching pbuffers.
 * @apiSince 3
 */

public void onSurfaceCreated(javax.microedition.khronos.opengles.GL10 gl, javax.microedition.khronos.egl.EGLConfig config);

/**
 * Called when the surface changed size.
 * <p>
 * Called after the surface is created and whenever
 * the OpenGL ES surface size changes.
 * <p>
 * Typically you will set your viewport here. If your camera
 * is fixed then you could also set your projection matrix here:
 * <pre class="prettyprint">
 * void onSurfaceChanged(GL10 gl, int width, int height) {
 *     gl.glViewport(0, 0, width, height);
 *     // for a fixed camera, set the projection too
 *     float ratio = (float) width / height;
 *     gl.glMatrixMode(GL10.GL_PROJECTION);
 *     gl.glLoadIdentity();
 *     gl.glFrustumf(-ratio, ratio, -1, 1, 1, 10);
 * }
 * </pre>
 * @param gl the GL interface. Use <code>instanceof</code> to
 * test if the interface supports GL11 or higher interfaces.
 * @param width
 * @param height
 * @apiSince 3
 */

public void onSurfaceChanged(javax.microedition.khronos.opengles.GL10 gl, int width, int height);

/**
 * Called to draw the current frame.
 * <p>
 * This method is responsible for drawing the current frame.
 * <p>
 * The implementation of this method typically looks like this:
 * <pre class="prettyprint">
 * void onDrawFrame(GL10 gl) {
 *     gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
 *     //... other gl calls to render the scene ...
 * }
 * </pre>
 * @param gl the GL interface. Use <code>instanceof</code> to
 * test if the interface supports GL11 or higher interfaces.
 * @apiSince 3
 */

public void onDrawFrame(javax.microedition.khronos.opengles.GL10 gl);
}

}

