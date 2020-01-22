/*
 * Copyright (C) 2013 The Android Open Source Project
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


package android.media;

import java.nio.ByteBuffer;
import android.hardware.HardwareBuffer;

/**
 * <p>A single complete image buffer to use with a media source such as a
 * {@link android.media.MediaCodec MediaCodec} or a
 * {@link android.hardware.camera2.CameraDevice CameraDevice}.</p>
 *
 * <p>This class allows for efficient direct application access to the pixel
 * data of the Image through one or more
 * {@link java.nio.ByteBuffer ByteBuffers}. Each buffer is encapsulated in a
 * {@link android.media.Image.Plane Plane} that describes the layout of the pixel data in that plane. Due
 * to this direct access, and unlike the {@link android.graphics.Bitmap Bitmap} class,
 * Images are not directly usable as UI resources.</p>
 *
 * <p>Since Images are often directly produced or consumed by hardware
 * components, they are a limited resource shared across the system, and should
 * be closed as soon as they are no longer needed.</p>
 *
 * <p>For example, when using the {@link android.media.ImageReader ImageReader} class to read out Images
 * from various media sources, not closing old Image objects will prevent the
 * availability of new Images once
 * {@link android.media.ImageReader#getMaxImages ImageReader#getMaxImages} is
 * reached. When this happens, the function acquiring new Images will typically
 * throw an {@link java.lang.IllegalStateException IllegalStateException}.</p>
 *
 * @see android.media.ImageReader
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class Image implements java.lang.AutoCloseable {

Image() { throw new RuntimeException("Stub!"); }

/**
 * Get the format for this image. This format determines the number of
 * ByteBuffers needed to represent the image, and the general layout of the
 * pixel data in each ByteBuffer.
 *
 * <p>
 * The format is one of the values from
 * {@link android.graphics.ImageFormat ImageFormat}. The mapping between the
 * formats and the planes is as follows:
 * </p>
 *
 * <table>
 * <tr>
 *   <th>Format</th>
 *   <th>Plane count</th>
 *   <th>Layout details</th>
 * </tr>
 * <tr>
 *   <td>{@link android.graphics.ImageFormat#JPEG JPEG}</td>
 *   <td>1</td>
 *   <td>Compressed data, so row and pixel strides are 0. To uncompress, use
 *      {@link android.graphics.BitmapFactory#decodeByteArray BitmapFactory#decodeByteArray}.
 *   </td>
 * </tr>
 * <tr>
 *   <td>{@link android.graphics.ImageFormat#YUV_420_888 YUV_420_888}</td>
 *   <td>3</td>
 *   <td>A luminance plane followed by the Cb and Cr chroma planes.
 *     The chroma planes have half the width and height of the luminance
 *     plane (4:2:0 subsampling). Each pixel sample in each plane has 8 bits.
 *     Each plane has its own row stride and pixel stride.</td>
 * </tr>
 * <tr>
 *   <td>{@link android.graphics.ImageFormat#YUV_422_888 YUV_422_888}</td>
 *   <td>3</td>
 *   <td>A luminance plane followed by the Cb and Cr chroma planes.
 *     The chroma planes have half the width and the full height of the luminance
 *     plane (4:2:2 subsampling). Each pixel sample in each plane has 8 bits.
 *     Each plane has its own row stride and pixel stride.</td>
 * </tr>
 * <tr>
 *   <td>{@link android.graphics.ImageFormat#YUV_444_888 YUV_444_888}</td>
 *   <td>3</td>
 *   <td>A luminance plane followed by the Cb and Cr chroma planes.
 *     The chroma planes have the same width and height as that of the luminance
 *     plane (4:4:4 subsampling). Each pixel sample in each plane has 8 bits.
 *     Each plane has its own row stride and pixel stride.</td>
 * </tr>
 * <tr>
 *   <td>{@link android.graphics.ImageFormat#FLEX_RGB_888 FLEX_RGB_888}</td>
 *   <td>3</td>
 *   <td>A R (red) plane followed by the G (green) and B (blue) planes.
 *     All planes have the same widths and heights.
 *     Each pixel sample in each plane has 8 bits.
 *     Each plane has its own row stride and pixel stride.</td>
 * </tr>
 * <tr>
 *   <td>{@link android.graphics.ImageFormat#FLEX_RGBA_8888 FLEX_RGBA_8888}</td>
 *   <td>4</td>
 *   <td>A R (red) plane followed by the G (green), B (blue), and
 *     A (alpha) planes. All planes have the same widths and heights.
 *     Each pixel sample in each plane has 8 bits.
 *     Each plane has its own row stride and pixel stride.</td>
 * </tr>
 * <tr>
 *   <td>{@link android.graphics.ImageFormat#RAW_SENSOR RAW_SENSOR}</td>
 *   <td>1</td>
 *   <td>A single plane of raw sensor image data, with 16 bits per color
 *     sample. The details of the layout need to be queried from the source of
 *     the raw sensor data, such as
 *     {@link android.hardware.camera2.CameraDevice CameraDevice}.
 *   </td>
 * </tr>
 * <tr>
 *   <td>{@link android.graphics.ImageFormat#RAW_PRIVATE RAW_PRIVATE}</td>
 *   <td>1</td>
 *   <td>A single plane of raw sensor image data of private layout.
 *   The details of the layout is implementation specific. Row stride and
 *   pixel stride are undefined for this format. Calling {@link android.media.Image.Plane#getRowStride() Plane#getRowStride()}
 *   or {@link android.media.Image.Plane#getPixelStride() Plane#getPixelStride()} on RAW_PRIVATE image will cause
 *   UnSupportedOperationException being thrown.
 *   </td>
 * </tr>
 * <tr>
 *   <td>{@link android.graphics.ImageFormat#HEIC HEIC}</td>
 *   <td>1</td>
 *   <td>Compressed data, so row and pixel strides are 0. To uncompress, use
 *      {@link android.graphics.BitmapFactory#decodeByteArray BitmapFactory#decodeByteArray}.
 *   </td>
 * </tr>
 * </table>
 *
 * @see android.graphics.ImageFormat
 * @apiSince 19
 */

public abstract int getFormat();

/**
 * The width of the image in pixels. For formats where some color channels
 * are subsampled, this is the width of the largest-resolution plane.
 * @apiSince 19
 */

public abstract int getWidth();

/**
 * The height of the image in pixels. For formats where some color channels
 * are subsampled, this is the height of the largest-resolution plane.
 * @apiSince 19
 */

public abstract int getHeight();

/**
 * Get the timestamp associated with this frame.
 * <p>
 * The timestamp is measured in nanoseconds, and is normally monotonically
 * increasing. The timestamps for the images from different sources may have
 * different timebases therefore may not be comparable. The specific meaning and
 * timebase of the timestamp depend on the source providing images. See
 * {@link android.hardware.Camera Camera},
 * {@link android.hardware.camera2.CameraDevice CameraDevice},
 * {@link android.media.MediaPlayer MediaPlayer} and {@link android.media.MediaCodec MediaCodec} for more details.
 * </p>
 * @apiSince 19
 */

public abstract long getTimestamp();

/**
 * Get the {@link android.hardware.HardwareBuffer HardwareBuffer} handle of the input image
 * intended for GPU and/or hardware access.
 * <p>
 * The returned {@link android.hardware.HardwareBuffer HardwareBuffer} shall not be used
 * after  {@link android.media.Image#close Image#close} has been called.
 * </p>
 * @return the HardwareBuffer associated with this Image or null if this Image doesn't support
 * this feature. (Unsupported use cases include Image instances obtained through
 * {@link android.media.MediaCodec MediaCodec}, and on versions prior to Android P,
 * {@link android.media.ImageWriter ImageWriter}).
 * @apiSince 28
 */

@androidx.annotation.Nullable
public android.hardware.HardwareBuffer getHardwareBuffer() { throw new RuntimeException("Stub!"); }

/**
 * Set the timestamp associated with this frame.
 * <p>
 * The timestamp is measured in nanoseconds, and is normally monotonically
 * increasing. The timestamps for the images from different sources may have
 * different timebases therefore may not be comparable. The specific meaning and
 * timebase of the timestamp depend on the source providing images. See
 * {@link android.hardware.Camera Camera},
 * {@link android.hardware.camera2.CameraDevice CameraDevice},
 * {@link android.media.MediaPlayer MediaPlayer} and {@link android.media.MediaCodec MediaCodec} for more details.
 * </p>
 * <p>
 * For images dequeued from {@link android.media.ImageWriter ImageWriter} via
 * {@link android.media.ImageWriter#dequeueInputImage() ImageWriter#dequeueInputImage()}, it's up to the application to
 * set the timestamps correctly before sending them back to the
 * {@link android.media.ImageWriter ImageWriter}, or the timestamp will be generated automatically when
 * {@link android.media.ImageWriter#queueInputImage ImageWriter#queueInputImage} is called.
 * </p>
 *
 * @param timestamp The timestamp to be set for this image.
 * @apiSince 23
 */

public void setTimestamp(long timestamp) { throw new RuntimeException("Stub!"); }

/**
 * Get the crop rectangle associated with this frame.
 * <p>
 * The crop rectangle specifies the region of valid pixels in the image,
 * using coordinates in the largest-resolution plane.
 * @apiSince 21
 */

public android.graphics.Rect getCropRect() { throw new RuntimeException("Stub!"); }

/**
 * Set the crop rectangle associated with this frame.
 * <p>
 * The crop rectangle specifies the region of valid pixels in the image,
 * using coordinates in the largest-resolution plane.
 * @apiSince 21
 */

public void setCropRect(android.graphics.Rect cropRect) { throw new RuntimeException("Stub!"); }

/**
 * Get the array of pixel planes for this Image. The number of planes is
 * determined by the format of the Image. The application will get an empty
 * array if the image format is {@link android.graphics.ImageFormat#PRIVATE
 * PRIVATE}, because the image pixel data is not directly accessible. The
 * application can check the image format by calling
 * {@link android.media.Image#getFormat() Image#getFormat()}.
 * @apiSince 19
 */

public abstract android.media.Image.Plane[] getPlanes();

/**
 * Free up this frame for reuse.
 * <p>
 * After calling this method, calling any methods on this {@code Image} will
 * result in an {@link java.lang.IllegalStateException IllegalStateException}, and attempting to read from
 * or write to {@link java.nio.ByteBuffer ByteBuffer} returned by an earlier
 * {@link android.media.Image.Plane#getBuffer Plane#getBuffer} call will have undefined behavior. If the image
 * was obtained from {@link android.media.ImageWriter ImageWriter} via
 * {@link android.media.ImageWriter#dequeueInputImage() ImageWriter#dequeueInputImage()}, after calling this method, any
 * image data filled by the application will be lost and the image will be
 * returned to {@link android.media.ImageWriter ImageWriter} for reuse. Images given to
 * {@link android.media.ImageWriter#queueInputImage ImageWriter#queueInputImage} are automatically
 * closed.
 * </p>
 * @apiSince 19
 */

public abstract void close();
/**
 * <p>A single color plane of image data.</p>
 *
 * <p>The number and meaning of the planes in an Image are determined by the
 * format of the Image.</p>
 *
 * <p>Once the Image has been closed, any access to the the plane's
 * ByteBuffer will fail.</p>
 *
 * @see #getFormat
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class Plane {

Plane() { throw new RuntimeException("Stub!"); }

/**
 * <p>The row stride for this color plane, in bytes.</p>
 *
 * <p>This is the distance between the start of two consecutive rows of
 * pixels in the image. Note that row stried is undefined for some formats
 * such as
 * {@link android.graphics.ImageFormat#RAW_PRIVATE RAW_PRIVATE},
 * and calling getRowStride on images of these formats will
 * cause an UnsupportedOperationException being thrown.
 * For formats where row stride is well defined, the row stride
 * is always greater than 0.</p>
 * @apiSince 19
 */

public abstract int getRowStride();

/**
 * <p>The distance between adjacent pixel samples, in bytes.</p>
 *
 * <p>This is the distance between two consecutive pixel values in a row
 * of pixels. It may be larger than the size of a single pixel to
 * account for interleaved image data or padded formats.
 * Note that pixel stride is undefined for some formats such as
 * {@link android.graphics.ImageFormat#RAW_PRIVATE RAW_PRIVATE},
 * and calling getPixelStride on images of these formats will
 * cause an UnsupportedOperationException being thrown.
 * For formats where pixel stride is well defined, the pixel stride
 * is always greater than 0.</p>
 * @apiSince 19
 */

public abstract int getPixelStride();

/**
 * <p>Get a direct {@link java.nio.ByteBuffer ByteBuffer}
 * containing the frame data.</p>
 *
 * <p>In particular, the buffer returned will always have
 * {@link java.nio.ByteBuffer#isDirect isDirect} return {@code true}, so
 * the underlying data could be mapped as a pointer in JNI without doing
 * any copies with {@code GetDirectBufferAddress}.</p>
 *
 * <p>For raw formats, each plane is only guaranteed to contain data
 * up to the last pixel in the last row. In other words, the stride
 * after the last row may not be mapped into the buffer. This is a
 * necessary requirement for any interleaved format.</p>
 *
 * @return the byte buffer containing the image data for this plane.
 * @apiSince 19
 */

public abstract java.nio.ByteBuffer getBuffer();
}

}

