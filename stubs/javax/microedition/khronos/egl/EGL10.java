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


package javax.microedition.khronos.egl;


/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface EGL10 extends javax.microedition.khronos.egl.EGL {

/** @apiSince 1 */

public boolean eglChooseConfig(javax.microedition.khronos.egl.EGLDisplay display, int[] attrib_list, javax.microedition.khronos.egl.EGLConfig[] configs, int config_size, int[] num_config);

/** @apiSince 1 */

public boolean eglCopyBuffers(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLSurface surface, java.lang.Object native_pixmap);

/** @apiSince 1 */

public javax.microedition.khronos.egl.EGLContext eglCreateContext(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLConfig config, javax.microedition.khronos.egl.EGLContext share_context, int[] attrib_list);

/** @apiSince 1 */

public javax.microedition.khronos.egl.EGLSurface eglCreatePbufferSurface(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLConfig config, int[] attrib_list);

/**
 * @apiSince 1
 * @deprecatedSince 26
 */

@Deprecated
public javax.microedition.khronos.egl.EGLSurface eglCreatePixmapSurface(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLConfig config, java.lang.Object native_pixmap, int[] attrib_list);

/** @apiSince 1 */

public javax.microedition.khronos.egl.EGLSurface eglCreateWindowSurface(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLConfig config, java.lang.Object native_window, int[] attrib_list);

/** @apiSince 1 */

public boolean eglDestroyContext(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLContext context);

/** @apiSince 1 */

public boolean eglDestroySurface(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLSurface surface);

/** @apiSince 1 */

public boolean eglGetConfigAttrib(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLConfig config, int attribute, int[] value);

/** @apiSince 1 */

public boolean eglGetConfigs(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLConfig[] configs, int config_size, int[] num_config);

/** @apiSince 1 */

public javax.microedition.khronos.egl.EGLContext eglGetCurrentContext();

/** @apiSince 1 */

public javax.microedition.khronos.egl.EGLDisplay eglGetCurrentDisplay();

/** @apiSince 1 */

public javax.microedition.khronos.egl.EGLSurface eglGetCurrentSurface(int readdraw);

/** @apiSince 1 */

public javax.microedition.khronos.egl.EGLDisplay eglGetDisplay(java.lang.Object native_display);

/** @apiSince 1 */

public int eglGetError();

/** @apiSince 1 */

public boolean eglInitialize(javax.microedition.khronos.egl.EGLDisplay display, int[] major_minor);

/** @apiSince 1 */

public boolean eglMakeCurrent(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLSurface draw, javax.microedition.khronos.egl.EGLSurface read, javax.microedition.khronos.egl.EGLContext context);

/** @apiSince 1 */

public boolean eglQueryContext(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLContext context, int attribute, int[] value);

/** @apiSince 1 */

public java.lang.String eglQueryString(javax.microedition.khronos.egl.EGLDisplay display, int name);

/** @apiSince 1 */

public boolean eglQuerySurface(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLSurface surface, int attribute, int[] value);

/** @apiSince 1 */

public boolean eglSwapBuffers(javax.microedition.khronos.egl.EGLDisplay display, javax.microedition.khronos.egl.EGLSurface surface);

/** @apiSince 1 */

public boolean eglTerminate(javax.microedition.khronos.egl.EGLDisplay display);

/** @apiSince 1 */

public boolean eglWaitGL();

/** @apiSince 1 */

public boolean eglWaitNative(int engine, java.lang.Object bindTarget);

/** @apiSince 1 */

public static final int EGL_ALPHA_FORMAT = 12424; // 0x3088

/** @apiSince 1 */

public static final int EGL_ALPHA_MASK_SIZE = 12350; // 0x303e

/** @apiSince 1 */

public static final int EGL_ALPHA_SIZE = 12321; // 0x3021

/** @apiSince 1 */

public static final int EGL_BAD_ACCESS = 12290; // 0x3002

/** @apiSince 1 */

public static final int EGL_BAD_ALLOC = 12291; // 0x3003

/** @apiSince 1 */

public static final int EGL_BAD_ATTRIBUTE = 12292; // 0x3004

/** @apiSince 1 */

public static final int EGL_BAD_CONFIG = 12293; // 0x3005

/** @apiSince 1 */

public static final int EGL_BAD_CONTEXT = 12294; // 0x3006

/** @apiSince 1 */

public static final int EGL_BAD_CURRENT_SURFACE = 12295; // 0x3007

/** @apiSince 1 */

public static final int EGL_BAD_DISPLAY = 12296; // 0x3008

/** @apiSince 1 */

public static final int EGL_BAD_MATCH = 12297; // 0x3009

/** @apiSince 1 */

public static final int EGL_BAD_NATIVE_PIXMAP = 12298; // 0x300a

/** @apiSince 1 */

public static final int EGL_BAD_NATIVE_WINDOW = 12299; // 0x300b

/** @apiSince 1 */

public static final int EGL_BAD_PARAMETER = 12300; // 0x300c

/** @apiSince 1 */

public static final int EGL_BAD_SURFACE = 12301; // 0x300d

/** @apiSince 1 */

public static final int EGL_BLUE_SIZE = 12322; // 0x3022

/** @apiSince 1 */

public static final int EGL_BUFFER_SIZE = 12320; // 0x3020

/** @apiSince 1 */

public static final int EGL_COLORSPACE = 12423; // 0x3087

/** @apiSince 1 */

public static final int EGL_COLOR_BUFFER_TYPE = 12351; // 0x303f

/** @apiSince 1 */

public static final int EGL_CONFIG_CAVEAT = 12327; // 0x3027

/** @apiSince 1 */

public static final int EGL_CONFIG_ID = 12328; // 0x3028

/** @apiSince 1 */

public static final int EGL_CORE_NATIVE_ENGINE = 12379; // 0x305b

/** @apiSince 1 */

public static final java.lang.Object EGL_DEFAULT_DISPLAY = null;

/** @apiSince 1 */

public static final int EGL_DEPTH_SIZE = 12325; // 0x3025

/** @apiSince 1 */

public static final int EGL_DONT_CARE = -1; // 0xffffffff

/** @apiSince 1 */

public static final int EGL_DRAW = 12377; // 0x3059

/** @apiSince 1 */

public static final int EGL_EXTENSIONS = 12373; // 0x3055

/** @apiSince 1 */

public static final int EGL_GREEN_SIZE = 12323; // 0x3023

/** @apiSince 1 */

public static final int EGL_HEIGHT = 12374; // 0x3056

/** @apiSince 1 */

public static final int EGL_HORIZONTAL_RESOLUTION = 12432; // 0x3090

/** @apiSince 1 */

public static final int EGL_LARGEST_PBUFFER = 12376; // 0x3058

/** @apiSince 1 */

public static final int EGL_LEVEL = 12329; // 0x3029

/** @apiSince 1 */

public static final int EGL_LUMINANCE_BUFFER = 12431; // 0x308f

/** @apiSince 1 */

public static final int EGL_LUMINANCE_SIZE = 12349; // 0x303d

/** @apiSince 1 */

public static final int EGL_MAX_PBUFFER_HEIGHT = 12330; // 0x302a

/** @apiSince 1 */

public static final int EGL_MAX_PBUFFER_PIXELS = 12331; // 0x302b

/** @apiSince 1 */

public static final int EGL_MAX_PBUFFER_WIDTH = 12332; // 0x302c

/** @apiSince 1 */

public static final int EGL_NATIVE_RENDERABLE = 12333; // 0x302d

/** @apiSince 1 */

public static final int EGL_NATIVE_VISUAL_ID = 12334; // 0x302e

/** @apiSince 1 */

public static final int EGL_NATIVE_VISUAL_TYPE = 12335; // 0x302f

/** @apiSince 1 */

public static final int EGL_NONE = 12344; // 0x3038

/** @apiSince 1 */

public static final int EGL_NON_CONFORMANT_CONFIG = 12369; // 0x3051

/** @apiSince 1 */

public static final int EGL_NOT_INITIALIZED = 12289; // 0x3001

/** @apiSince 1 */

public static final javax.microedition.khronos.egl.EGLContext EGL_NO_CONTEXT = null;

/** @apiSince 1 */

public static final javax.microedition.khronos.egl.EGLDisplay EGL_NO_DISPLAY = null;

/** @apiSince 1 */

public static final javax.microedition.khronos.egl.EGLSurface EGL_NO_SURFACE = null;

/** @apiSince 1 */

public static final int EGL_PBUFFER_BIT = 1; // 0x1

/** @apiSince 1 */

public static final int EGL_PIXEL_ASPECT_RATIO = 12434; // 0x3092

/** @apiSince 1 */

public static final int EGL_PIXMAP_BIT = 2; // 0x2

/** @apiSince 1 */

public static final int EGL_READ = 12378; // 0x305a

/** @apiSince 1 */

public static final int EGL_RED_SIZE = 12324; // 0x3024

/** @apiSince 1 */

public static final int EGL_RENDERABLE_TYPE = 12352; // 0x3040

/** @apiSince 1 */

public static final int EGL_RENDER_BUFFER = 12422; // 0x3086

/** @apiSince 1 */

public static final int EGL_RGB_BUFFER = 12430; // 0x308e

/** @apiSince 1 */

public static final int EGL_SAMPLES = 12337; // 0x3031

/** @apiSince 1 */

public static final int EGL_SAMPLE_BUFFERS = 12338; // 0x3032

/** @apiSince 1 */

public static final int EGL_SINGLE_BUFFER = 12421; // 0x3085

/** @apiSince 1 */

public static final int EGL_SLOW_CONFIG = 12368; // 0x3050

/** @apiSince 1 */

public static final int EGL_STENCIL_SIZE = 12326; // 0x3026

/** @apiSince 1 */

public static final int EGL_SUCCESS = 12288; // 0x3000

/** @apiSince 1 */

public static final int EGL_SURFACE_TYPE = 12339; // 0x3033

/** @apiSince 1 */

public static final int EGL_TRANSPARENT_BLUE_VALUE = 12341; // 0x3035

/** @apiSince 1 */

public static final int EGL_TRANSPARENT_GREEN_VALUE = 12342; // 0x3036

/** @apiSince 1 */

public static final int EGL_TRANSPARENT_RED_VALUE = 12343; // 0x3037

/** @apiSince 1 */

public static final int EGL_TRANSPARENT_RGB = 12370; // 0x3052

/** @apiSince 1 */

public static final int EGL_TRANSPARENT_TYPE = 12340; // 0x3034

/** @apiSince 1 */

public static final int EGL_VENDOR = 12371; // 0x3053

/** @apiSince 1 */

public static final int EGL_VERSION = 12372; // 0x3054

/** @apiSince 1 */

public static final int EGL_VERTICAL_RESOLUTION = 12433; // 0x3091

/** @apiSince 1 */

public static final int EGL_WIDTH = 12375; // 0x3057

/** @apiSince 1 */

public static final int EGL_WINDOW_BIT = 4; // 0x4
}

