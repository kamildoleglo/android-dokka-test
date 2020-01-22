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


package android.opengl;


/**
 *
 * Utility class to help bridging OpenGL ES and Android APIs.
 *
 @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class GLUtils {

private GLUtils() { throw new RuntimeException("Stub!"); }

/**
 * return the internal format as defined by OpenGL ES of the supplied bitmap.
 * @param bitmap
 * @return the internal format of the bitmap.
 * @apiSince 1
 */

public static int getInternalFormat(android.graphics.Bitmap bitmap) { throw new RuntimeException("Stub!"); }

/**
 * Return the type as defined by OpenGL ES of the supplied bitmap, if there
 * is one. If the bitmap is stored in a compressed format, it may not have
 * a valid OpenGL ES type.
 * @throws java.lang.IllegalArgumentException if the bitmap does not have a type.
 * @param bitmap
 * @return the OpenGL ES type of the bitmap.
 * @apiSince 1
 */

public static int getType(android.graphics.Bitmap bitmap) { throw new RuntimeException("Stub!"); }

/**
 * Calls glTexImage2D() on the current OpenGL context. If no context is
 * current the behavior is the same as calling glTexImage2D() with  no
 * current context, that is, eglGetError() will return the appropriate
 * error.
 * Unlike glTexImage2D() bitmap cannot be null and will raise an exception
 * in that case.
 * All other parameters are identical to those used for glTexImage2D().
 *
 * NOTE: this method doesn't change GL_UNPACK_ALIGNMENT, you must make
 * sure to set it properly according to the supplied bitmap.
 *
 * Whether or not bitmap can have non power of two dimensions depends on
 * the current OpenGL context. Always check glGetError() some time
 * after calling this method, just like when using OpenGL directly.
 *
 * @param target
 * @param level
 * @param internalformat
 * @param bitmap
 * @param border
 * @apiSince 1
 */

public static void texImage2D(int target, int level, int internalformat, android.graphics.Bitmap bitmap, int border) { throw new RuntimeException("Stub!"); }

/**
 * A version of texImage2D() that takes an explicit type parameter
 * as defined by the OpenGL ES specification. The actual type and
 * internalformat of the bitmap must be compatible with the specified
 * type and internalformat parameters.
 *
 * @param target
 * @param level
 * @param internalformat
 * @param bitmap
 * @param type
 * @param border
 * @apiSince 1
 */

public static void texImage2D(int target, int level, int internalformat, android.graphics.Bitmap bitmap, int type, int border) { throw new RuntimeException("Stub!"); }

/**
 * A version of texImage2D that determines the internalFormat and type
 * automatically.
 *
 * @param target
 * @param level
 * @param bitmap
 * @param border
 * @apiSince 1
 */

public static void texImage2D(int target, int level, android.graphics.Bitmap bitmap, int border) { throw new RuntimeException("Stub!"); }

/**
 * Calls glTexSubImage2D() on the current OpenGL context. If no context is
 * current the behavior is the same as calling glTexSubImage2D() with  no
 * current context, that is, eglGetError() will return the appropriate
 * error.
 * Unlike glTexSubImage2D() bitmap cannot be null and will raise an exception
 * in that case.
 * All other parameters are identical to those used for glTexSubImage2D().
 *
 * NOTE: this method doesn't change GL_UNPACK_ALIGNMENT, you must make
 * sure to set it properly according to the supplied bitmap.
 *
 * Whether or not bitmap can have non power of two dimensions depends on
 * the current OpenGL context. Always check glGetError() some time
 * after calling this method, just like when using OpenGL directly.
 *
 * @param target
 * @param level
 * @param xoffset
 * @param yoffset
 * @param bitmap
 * @apiSince 1
 */

public static void texSubImage2D(int target, int level, int xoffset, int yoffset, android.graphics.Bitmap bitmap) { throw new RuntimeException("Stub!"); }

/**
 * A version of texSubImage2D() that takes an explicit type parameter
 * as defined by the OpenGL ES specification.
 *
 * @param target
 * @param level
 * @param xoffset
 * @param yoffset
 * @param bitmap
 * @param type
 * @apiSince 1
 */

public static void texSubImage2D(int target, int level, int xoffset, int yoffset, android.graphics.Bitmap bitmap, int format, int type) { throw new RuntimeException("Stub!"); }

/**
 * Return a string for the EGL error code, or the hex representation
 * if the error is unknown.
 *
 * @param error The EGL error to convert into a String.
 *
 * @return An error string corresponding to the EGL error code.
 * @apiSince 14
 */

public static java.lang.String getEGLErrorString(int error) { throw new RuntimeException("Stub!"); }
}

