/*
 * Copyright (C) 2009 The Android Open Source Project
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

import java.io.IOException;

/**
 * Utility methods for using ETC1 compressed textures.
 *
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ETC1Util {

public ETC1Util() { throw new RuntimeException("Stub!"); }

/**
 * Convenience method to load an ETC1 texture whether or not the active OpenGL context
 * supports the ETC1 texture compression format.
 * @param target the texture target.
 * @param level the texture level
 * @param border the border size. Typically 0.
 * @param fallbackFormat the format to use if ETC1 texture compression is not supported.
 * Must be GL_RGB.
 * @param fallbackType the type to use if ETC1 texture compression is not supported.
 * Can be either GL_UNSIGNED_SHORT_5_6_5, which implies 16-bits-per-pixel,
 * or GL_UNSIGNED_BYTE, which implies 24-bits-per-pixel.
 * @param input the input stream containing an ETC1 texture in PKM format.
 * @throws java.io.IOException
 * @apiSince 8
 */

public static void loadTexture(int target, int level, int border, int fallbackFormat, int fallbackType, java.io.InputStream input) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Convenience method to load an ETC1 texture whether or not the active OpenGL context
 * supports the ETC1 texture compression format.
 * @param target the texture target.
 * @param level the texture level
 * @param border the border size. Typically 0.
 * @param fallbackFormat the format to use if ETC1 texture compression is not supported.
 * Must be GL_RGB.
 * @param fallbackType the type to use if ETC1 texture compression is not supported.
 * Can be either GL_UNSIGNED_SHORT_5_6_5, which implies 16-bits-per-pixel,
 * or GL_UNSIGNED_BYTE, which implies 24-bits-per-pixel.
 * @param texture the ETC1 to load.
 * @apiSince 8
 */

public static void loadTexture(int target, int level, int border, int fallbackFormat, int fallbackType, android.opengl.ETC1Util.ETC1Texture texture) { throw new RuntimeException("Stub!"); }

/**
 * Check if ETC1 texture compression is supported by the active OpenGL ES context.
 * @return true if the active OpenGL ES context supports ETC1 texture compression.
 * @apiSince 8
 */

public static boolean isETC1Supported() { throw new RuntimeException("Stub!"); }

/**
 * Create a new ETC1Texture from an input stream containing a PKM formatted compressed texture.
 * @param input an input stream containing a PKM formatted compressed texture.
 * @return an ETC1Texture read from the input stream.
 * @throws java.io.IOException
 * @apiSince 8
 */

public static android.opengl.ETC1Util.ETC1Texture createTexture(java.io.InputStream input) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Helper function that compresses an image into an ETC1Texture.
 * @param input a native order direct buffer containing the image data
 * @param width the width of the image in pixels
 * @param height the height of the image in pixels
 * @param pixelSize the size of a pixel in bytes (2 or 3)
 * @param stride the width of a line of the image in bytes
 * @return the ETC1 texture.
 * @apiSince 8
 */

public static android.opengl.ETC1Util.ETC1Texture compressTexture(java.nio.Buffer input, int width, int height, int pixelSize, int stride) { throw new RuntimeException("Stub!"); }

/**
 * Helper function that writes an ETC1Texture to an output stream formatted as a PKM file.
 * @param texture the input texture.
 * @param output the stream to write the formatted texture data to.
 * @throws java.io.IOException
 * @apiSince 8
 */

public static void writeTexture(android.opengl.ETC1Util.ETC1Texture texture, java.io.OutputStream output) throws java.io.IOException { throw new RuntimeException("Stub!"); }
/**
 * A utility class encapsulating a compressed ETC1 texture.
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class ETC1Texture {

/** @apiSince 8 */

public ETC1Texture(int width, int height, java.nio.ByteBuffer data) { throw new RuntimeException("Stub!"); }

/**
 * Get the width of the texture in pixels.
 * @return the width of the texture in pixels.
 * @apiSince 8
 */

public int getWidth() { throw new RuntimeException("Stub!"); }

/**
 * Get the height of the texture in pixels.
 * @return the width of the texture in pixels.
 * @apiSince 8
 */

public int getHeight() { throw new RuntimeException("Stub!"); }

/**
 * Get the compressed data of the texture.
 * @return the texture data.
 * @apiSince 8
 */

public java.nio.ByteBuffer getData() { throw new RuntimeException("Stub!"); }
}

}

