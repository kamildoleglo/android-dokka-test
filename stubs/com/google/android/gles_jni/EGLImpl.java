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


package com.google.android.gles_jni;


/** @apiSince R */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class EGLImpl implements javax.microedition.khronos.egl.EGL10 {

/** @apiSince R */

public EGLImpl() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public native boolean eglInitialize(javax.microedition.khronos.egl.EGLDisplay display, int[] major_minor);

/** @apiSince R */

public native boolean eglQueryContext(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLContext context, int attribute, int[] value);

/** @apiSince R */

public native boolean eglQuerySurface(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLSurface surface, int attribute, int[] value);

/** @apiSince R */

public native boolean eglChooseConfig(javax.microedition.khronos.egl.EGLDisplay display, int[] attrib_list, javax.microedition.khronos.egl.EGLConfig[] configs, int config_size, int[] num_config);

/** @apiSince R */

public native boolean eglGetConfigAttrib(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLConfig config, int attribute, int[] value);

/** @apiSince R */

public native boolean eglGetConfigs(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLConfig[] configs, int config_size, int[] num_config);

/** @apiSince R */

public native int eglGetError();

/** @apiSince R */

public native boolean eglDestroyContext(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLContext context);

/** @apiSince R */

public native boolean eglDestroySurface(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLSurface surface);

/** @apiSince R */

public native boolean eglMakeCurrent(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLSurface draw, javax.microedition.khronos.egl.EGLSurface read, javax.microedition.khronos.egl.EGLContext context);

/** @apiSince R */

public native java.lang.String eglQueryString(javax.microedition.khronos.egl.EGLDisplay display, int name);

/** @apiSince R */

public native boolean eglSwapBuffers(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLSurface surface);

/** @apiSince R */

public native boolean eglTerminate(javax.microedition.khronos.egl.EGLDisplay display);

/** @apiSince R */

public native boolean eglCopyBuffers(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLSurface surface, java.lang.Object native_pixmap);

/** @apiSince R */

public native boolean eglWaitGL();

/** @apiSince R */

public native boolean eglWaitNative(int engine, java.lang.Object bindTarget);

/** @apiSince R */

public javax.microedition.khronos.egl.EGLContext eglCreateContext(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLConfig config, javax.microedition.khronos.egl.EGLContext share_context, int[] attrib_list) { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public javax.microedition.khronos.egl.EGLSurface eglCreatePbufferSurface(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLConfig config, int[] attrib_list) { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public javax.microedition.khronos.egl.EGLSurface eglCreatePixmapSurface(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLConfig config, java.lang.Object native_pixmap, int[] attrib_list) { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public javax.microedition.khronos.egl.EGLSurface eglCreateWindowSurface(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLConfig config, java.lang.Object native_window, int[] attrib_list) { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public synchronized javax.microedition.khronos.egl.EGLDisplay eglGetDisplay(java.lang.Object native_display) { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public synchronized javax.microedition.khronos.egl.EGLContext eglGetCurrentContext() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public synchronized javax.microedition.khronos.egl.EGLDisplay eglGetCurrentDisplay() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public synchronized javax.microedition.khronos.egl.EGLSurface eglGetCurrentSurface(int readdraw) { throw new RuntimeException("Stub!"); }
}

