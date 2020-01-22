/*
 * Copyright (C) 2010 The Android Open Source Project
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

import java.io.OutputStream;

/**
 * YuvImage contains YUV data and provides a method that compresses a region of
 * the YUV data to a Jpeg. The YUV data should be provided as a single byte
 * array irrespective of the number of image planes in it.
 * Currently only ImageFormat.NV21 and ImageFormat.YUY2 are supported.
 *
 * To compress a rectangle region in the YUV data, users have to specify the
 * region by left, top, width and height.
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class YuvImage {

/**
 * Construct an YuvImage.
 *
 * @param yuv     The YUV data. In the case of more than one image plane, all the planes must be
 *                concatenated into a single byte array.
 * @param format  The YUV data format as defined in {@link android.graphics.ImageFormat ImageFormat}.
 * @param width   The width of the YuvImage.
 * @param height  The height of the YuvImage.
 * @param strides (Optional) Row bytes of each image plane. If yuv contains padding, the stride
 *                of each image must be provided. If strides is null, the method assumes no
 *                padding and derives the row bytes by format and width itself.
 * @throws java.lang.IllegalArgumentException if format is not support; width or height <= 0; or yuv is
 *                null.
 * @apiSince 8
 */

public YuvImage(byte[] yuv, int format, int width, int height, int[] strides) { throw new RuntimeException("Stub!"); }

/**
 * Compress a rectangle region in the YuvImage to a jpeg.
 * Only ImageFormat.NV21 and ImageFormat.YUY2
 * are supported for now.
 *
 * @param rectangle The rectangle region to be compressed. The medthod checks if rectangle is
 *                  inside the image. Also, the method modifies rectangle if the chroma pixels
 *                  in it are not matched with the luma pixels in it.
 * @param quality   Hint to the compressor, 0-100. 0 meaning compress for
 *                  small size, 100 meaning compress for max quality.
 * @param stream    OutputStream to write the compressed data.
 * @return          True if the compression is successful.
 * @throws java.lang.IllegalArgumentException if rectangle is invalid; quality is not within [0,
 *                  100]; or stream is null.
 * @apiSince 8
 */

public boolean compressToJpeg(android.graphics.Rect rectangle, int quality, java.io.OutputStream stream) { throw new RuntimeException("Stub!"); }

/**
 * @return the YUV data.
 * @apiSince 8
 */

public byte[] getYuvData() { throw new RuntimeException("Stub!"); }

/**
 * @return the YUV format as defined in {@link android.graphics.ImageFormat ImageFormat}.
 * @apiSince 8
 */

public int getYuvFormat() { throw new RuntimeException("Stub!"); }

/**
 * @return the number of row bytes in each image plane.
 * @apiSince 8
 */

public int[] getStrides() { throw new RuntimeException("Stub!"); }

/**
 * @return the width of the image.
 * @apiSince 8
 */

public int getWidth() { throw new RuntimeException("Stub!"); }

/**
 * @return the height of the image.
 * @apiSince 8
 */

public int getHeight() { throw new RuntimeException("Stub!"); }
}

