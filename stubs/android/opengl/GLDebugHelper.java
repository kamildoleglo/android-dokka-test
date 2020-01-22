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


package android.opengl;

import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.egl.EGL;

/**
 * A helper class for debugging OpenGL ES applications.
 *
 * Wraps the supplied GL interface with a new GL interface that adds support for
 * error checking and logging.
 *
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class GLDebugHelper {

public GLDebugHelper() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public static javax.microedition.khronos.opengles.GL wrap(javax.microedition.khronos.opengles.GL gl, int configFlags, java.io.Writer log) { throw new RuntimeException("Stub!"); }

/**
 * Wrap an existing EGL interface in a new EGL interface that adds
 * support for error checking and/or logging.
 * @param egl the existing GL interface. Must implement EGL and EGL10. May
 * optionally implement EGL11 as well.
 * @param configFlags A bitmask of error checking flags.
 * @param log - null to disable logging, non-null to enable logging.
 * @return the wrapped EGL interface.
 * @apiSince 1
 */

public static javax.microedition.khronos.egl.EGL wrap(javax.microedition.khronos.egl.EGL egl, int configFlags, java.io.Writer log) { throw new RuntimeException("Stub!"); }

/**
 * Check glError() after every call.
 * @apiSince 1
 */

public static final int CONFIG_CHECK_GL_ERROR = 1; // 0x1

/**
 * Check if all calls are on the same thread.
 * @apiSince 1
 */

public static final int CONFIG_CHECK_THREAD = 2; // 0x2

/**
 * Print argument names when logging GL Calls.
 * @apiSince 1
 */

public static final int CONFIG_LOG_ARGUMENT_NAMES = 4; // 0x4

/**
 * The Error number used in the GLException that is thrown if
 * CONFIG_CHECK_THREAD is enabled and you call OpenGL ES on the
 * a different thread.
 * @apiSince 1
 */

public static final int ERROR_WRONG_THREAD = 28672; // 0x7000
}

