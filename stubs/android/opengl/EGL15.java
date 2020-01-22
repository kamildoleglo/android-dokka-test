/*
** Copyright 2018, The Android Open Source Project
**
** Licensed under the Apache License, Version 2.0 (the "License");
** you may not use this file except in compliance with the License.
** You may obtain a copy of the License at
**
**     http://www.apache.org/licenses/LICENSE-2.0
**
** Unless required by applicable law or agreed to in writing, software
** distributed under the License is distributed on an "AS IS" BASIS,
** WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
** See the License for the specific language governing permissions and
** limitations under the License.
*/


package android.opengl;


/**
 * EGL 1.5
 *
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class EGL15 {

private EGL15() { throw new RuntimeException("Stub!"); }

/** @apiSince 29 */

public static native android.opengl.EGLSync eglCreateSync(android.opengl.EGLDisplay dpy, int type, long[] attrib_list, int offset);

/**
 * C function EGLBoolean eglGetSyncAttrib ( EGLDisplay dpy, EGLSync sync, EGLint attribute,
 *                                          EGLAttrib *value )
 * @apiSince 29
 */

public static native boolean eglGetSyncAttrib(android.opengl.EGLDisplay dpy, android.opengl.EGLSync sync, int attribute, long[] value, int offset);

/** @apiSince 29 */

public static native boolean eglDestroySync(android.opengl.EGLDisplay dpy, android.opengl.EGLSync sync);

/** @apiSince 29 */

public static native int eglClientWaitSync(android.opengl.EGLDisplay dpy, android.opengl.EGLSync sync, int flags, long timeout);

/** @apiSince 29 */

public static native android.opengl.EGLDisplay eglGetPlatformDisplay(int platform, long native_display, long[] attrib_list, int offset);

/** @apiSince 29 */

public static native android.opengl.EGLSurface eglCreatePlatformWindowSurface(android.opengl.EGLDisplay dpy, android.opengl.EGLConfig config, java.nio.Buffer native_window, long[] attrib_list, int offset);

/** @apiSince 29 */

public static native android.opengl.EGLSurface eglCreatePlatformPixmapSurface(android.opengl.EGLDisplay dpy, android.opengl.EGLConfig config, java.nio.Buffer native_pixmap, long[] attrib_list, int offset);

/** @apiSince 29 */

public static native boolean eglWaitSync(android.opengl.EGLDisplay dpy, android.opengl.EGLSync sync, int flags);

/** @apiSince 29 */

public static native android.opengl.EGLImage eglCreateImage(android.opengl.EGLDisplay dpy, android.opengl.EGLContext context, int target, long buffer, long[] attrib_list, int offset);

/** @apiSince 29 */

public static native boolean eglDestroyImage(android.opengl.EGLDisplay dpy, android.opengl.EGLImage image);

/** @apiSince 29 */

public static final int EGL_CL_EVENT_HANDLE = 12444; // 0x309c

/** @apiSince 29 */

public static final int EGL_CONDITION_SATISFIED = 12534; // 0x30f6

/** @apiSince 29 */

public static final int EGL_CONTEXT_MAJOR_VERSION = 12440; // 0x3098

/** @apiSince 29 */

public static final int EGL_CONTEXT_MINOR_VERSION = 12539; // 0x30fb

/** @apiSince 29 */

public static final int EGL_CONTEXT_OPENGL_COMPATIBILITY_PROFILE_BIT = 2; // 0x2

/** @apiSince 29 */

public static final int EGL_CONTEXT_OPENGL_CORE_PROFILE_BIT = 1; // 0x1

/** @apiSince 29 */

public static final int EGL_CONTEXT_OPENGL_DEBUG = 12720; // 0x31b0

/** @apiSince 29 */

public static final int EGL_CONTEXT_OPENGL_FORWARD_COMPATIBLE = 12721; // 0x31b1

/** @apiSince 29 */

public static final int EGL_CONTEXT_OPENGL_PROFILE_MASK = 12541; // 0x30fd

/** @apiSince 29 */

public static final int EGL_CONTEXT_OPENGL_RESET_NOTIFICATION_STRATEGY = 12733; // 0x31bd

/** @apiSince 29 */

public static final int EGL_CONTEXT_OPENGL_ROBUST_ACCESS = 12722; // 0x31b2

/** @apiSince 29 */

public static final long EGL_FOREVER = -1L; // 0xffffffffffffffffL

/** @apiSince 29 */

public static final int EGL_GL_COLORSPACE = 12445; // 0x309d

/** @apiSince 29 */

public static final int EGL_GL_COLORSPACE_LINEAR = 12426; // 0x308a

/** @apiSince 29 */

public static final int EGL_GL_COLORSPACE_SRGB = 12425; // 0x3089

/** @apiSince 29 */

public static final int EGL_GL_RENDERBUFFER = 12473; // 0x30b9

/** @apiSince 29 */

public static final int EGL_GL_TEXTURE_2D = 12465; // 0x30b1

/** @apiSince 29 */

public static final int EGL_GL_TEXTURE_3D = 12466; // 0x30b2

/** @apiSince 29 */

public static final int EGL_GL_TEXTURE_CUBE_MAP_NEGATIVE_X = 12468; // 0x30b4

/** @apiSince 29 */

public static final int EGL_GL_TEXTURE_CUBE_MAP_NEGATIVE_Y = 12470; // 0x30b6

/** @apiSince 29 */

public static final int EGL_GL_TEXTURE_CUBE_MAP_NEGATIVE_Z = 12472; // 0x30b8

/** @apiSince 29 */

public static final int EGL_GL_TEXTURE_CUBE_MAP_POSITIVE_X = 12467; // 0x30b3

/** @apiSince 29 */

public static final int EGL_GL_TEXTURE_CUBE_MAP_POSITIVE_Y = 12469; // 0x30b5

/** @apiSince 29 */

public static final int EGL_GL_TEXTURE_CUBE_MAP_POSITIVE_Z = 12471; // 0x30b7

/** @apiSince 29 */

public static final int EGL_GL_TEXTURE_LEVEL = 12476; // 0x30bc

/** @apiSince 29 */

public static final int EGL_GL_TEXTURE_ZOFFSET = 12477; // 0x30bd

/** @apiSince 29 */

public static final int EGL_IMAGE_PRESERVED = 12498; // 0x30d2

/** @apiSince 29 */

public static final int EGL_LOSE_CONTEXT_ON_RESET = 12735; // 0x31bf

/** @apiSince 29 */

public static final android.opengl.EGLContext EGL_NO_CONTEXT;
static { EGL_NO_CONTEXT = null; }

/** @apiSince 29 */

public static final android.opengl.EGLDisplay EGL_NO_DISPLAY;
static { EGL_NO_DISPLAY = null; }

/** @apiSince 29 */

public static final android.opengl.EGLImage EGL_NO_IMAGE;
static { EGL_NO_IMAGE = null; }

/** @apiSince 29 */

public static final int EGL_NO_RESET_NOTIFICATION = 12734; // 0x31be

/** @apiSince 29 */

public static final android.opengl.EGLSurface EGL_NO_SURFACE;
static { EGL_NO_SURFACE = null; }

/** @apiSince 29 */

public static final android.opengl.EGLSync EGL_NO_SYNC;
static { EGL_NO_SYNC = null; }

/** @apiSince 29 */

public static final int EGL_OPENGL_ES3_BIT = 64; // 0x40

/** @apiSince 29 */

public static final int EGL_PLATFORM_ANDROID_KHR = 12609; // 0x3141

/** @apiSince 29 */

public static final int EGL_SIGNALED = 12530; // 0x30f2

/** @apiSince 29 */

public static final int EGL_SYNC_CL_EVENT = 12542; // 0x30fe

/** @apiSince 29 */

public static final int EGL_SYNC_CL_EVENT_COMPLETE = 12543; // 0x30ff

/** @apiSince 29 */

public static final int EGL_SYNC_CONDITION = 12536; // 0x30f8

/** @apiSince 29 */

public static final int EGL_SYNC_FENCE = 12537; // 0x30f9

/** @apiSince 29 */

public static final int EGL_SYNC_FLUSH_COMMANDS_BIT = 1; // 0x1

/** @apiSince 29 */

public static final int EGL_SYNC_PRIOR_COMMANDS_COMPLETE = 12528; // 0x30f0

/** @apiSince 29 */

public static final int EGL_SYNC_STATUS = 12529; // 0x30f1

/** @apiSince 29 */

public static final int EGL_SYNC_TYPE = 12535; // 0x30f7

/** @apiSince 29 */

public static final int EGL_TIMEOUT_EXPIRED = 12533; // 0x30f5

/** @apiSince 29 */

public static final int EGL_UNSIGNALED = 12531; // 0x30f3
}

