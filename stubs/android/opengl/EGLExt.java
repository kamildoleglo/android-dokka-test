/*
** Copyright 2013, The Android Open Source Project
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

// This source file is automatically generated


package android.opengl;


/**
 * EGL Extensions
 * @apiSince 18
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class EGLExt {

public EGLExt() { throw new RuntimeException("Stub!"); }

/** @apiSince 18 */

public static native boolean eglPresentationTimeANDROID(android.opengl.EGLDisplay dpy, android.opengl.EGLSurface sur, long time);

/** @apiSince 18 */

public static final int EGL_CONTEXT_FLAGS_KHR = 12540; // 0x30fc

/** @apiSince 18 */

public static final int EGL_CONTEXT_MAJOR_VERSION_KHR = 12440; // 0x3098

/** @apiSince 18 */

public static final int EGL_CONTEXT_MINOR_VERSION_KHR = 12539; // 0x30fb

/** @apiSince 18 */

public static final int EGL_OPENGL_ES3_BIT_KHR = 64; // 0x40

/** @apiSince 26 */

public static final int EGL_RECORDABLE_ANDROID = 12610; // 0x3142
}

