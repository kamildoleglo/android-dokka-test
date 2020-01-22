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

import android.view.Surface;
import android.graphics.ImageFormat;
import android.hardware.HardwareBuffer;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

/**
 * <p>The ImageReader class allows direct application access to image data
 * rendered into a {@link android.view.Surface}</p>
 *
 * <p>Several Android media API classes accept Surface objects as targets to
 * render to, including {@link android.media.MediaPlayer MediaPlayer}, {@link android.media.MediaCodec MediaCodec},
 * {@link android.hardware.camera2.CameraDevice}, {@link android.media.ImageWriter ImageWriter} and
 * {@link android.renderscript.Allocation RenderScript Allocations}. The image
 * sizes and formats that can be used with each source vary, and should be
 * checked in the documentation for the specific API.</p>
 *
 * <p>The image data is encapsulated in {@link android.media.Image Image} objects, and multiple such
 * objects can be accessed at the same time, up to the number specified by the
 * {@code maxImages} constructor parameter. New images sent to an ImageReader
 * through its {@link android.view.Surface Surface} are queued until accessed through the {@link #acquireLatestImage}
 * or {@link #acquireNextImage} call. Due to memory limits, an image source will
 * eventually stall or drop Images in trying to render to the Surface if the
 * ImageReader does not obtain and release Images at a rate equal to the
 * production rate.</p>
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ImageReader implements java.lang.AutoCloseable {

ImageReader() { throw new RuntimeException("Stub!"); }

/**
 * <p>
 * Create a new reader for images of the desired size and format.
 * </p>
 * <p>
 * The {@code maxImages} parameter determines the maximum number of
 * {@link android.media.Image Image} objects that can be be acquired from the
 * {@code ImageReader} simultaneously. Requesting more buffers will use up
 * more memory, so it is important to use only the minimum number necessary
 * for the use case.
 * </p>
 * <p>
 * The valid sizes and formats depend on the source of the image data.
 * </p>
 * <p>
 * If the {@code format} is {@link android.graphics.ImageFormat#PRIVATE ImageFormat#PRIVATE}, the created
 * {@link android.media.ImageReader ImageReader} will produce images that are not directly accessible
 * by the application. The application can still acquire images from this
 * {@link android.media.ImageReader ImageReader}, and send them to the
 * {@link android.hardware.camera2.CameraDevice camera} for reprocessing via
 * {@link android.media.ImageWriter ImageWriter} interface. However, the {@link android.media.Image#getPlanes() Image#getPlanes()} will return an empty array for {@link android.graphics.ImageFormat#PRIVATE ImageFormat#PRIVATE} format images. The application can check if an existing reader's
 * format by calling {@link #getImageFormat()}.
 * </p>
 * <p>
 * {@link android.graphics.ImageFormat#PRIVATE ImageFormat#PRIVATE} format {@link android.media.ImageReader ImageReader} are more efficient to use when application access to image
 * data is not necessary, compared to ImageReaders using other format such
 * as {@link android.graphics.ImageFormat#YUV_420_888 ImageFormat#YUV_420_888}.
 * </p>
 *
 * @param width The default width in pixels of the Images that this reader
 *            will produce.
 * Value is 1 or greater
 * @param height The default height in pixels of the Images that this reader
 *            will produce.
 * Value is 1 or greater
 * @param format The format of the Image that this reader will produce. This
 *            must be one of the {@link android.graphics.ImageFormat} or
 *            {@link android.graphics.PixelFormat} constants. Note that not
 *            all formats are supported, like ImageFormat.NV21.
 * Value is {@link android.graphics.ImageFormat#UNKNOWN}, {@link android.graphics.ImageFormat#RGB_565}, {@link android.graphics.ImageFormat#YV12}, {@link android.graphics.ImageFormat#Y8}, android.graphics.ImageFormat.Y16, {@link android.graphics.ImageFormat#NV16}, {@link android.graphics.ImageFormat#NV21}, {@link android.graphics.ImageFormat#YUY2}, {@link android.graphics.ImageFormat#JPEG}, {@link android.graphics.ImageFormat#DEPTH_JPEG}, {@link android.graphics.ImageFormat#YUV_420_888}, {@link android.graphics.ImageFormat#YUV_422_888}, {@link android.graphics.ImageFormat#YUV_444_888}, {@link android.graphics.ImageFormat#FLEX_RGB_888}, {@link android.graphics.ImageFormat#FLEX_RGBA_8888}, {@link android.graphics.ImageFormat#RAW_SENSOR}, {@link android.graphics.ImageFormat#RAW_PRIVATE}, {@link android.graphics.ImageFormat#RAW10}, {@link android.graphics.ImageFormat#RAW12}, {@link android.graphics.ImageFormat#DEPTH16}, {@link android.graphics.ImageFormat#DEPTH_POINT_CLOUD}, android.graphics.ImageFormat.RAW_DEPTH, {@link android.graphics.ImageFormat#PRIVATE}, or {@link android.graphics.ImageFormat#HEIC}
 * @param maxImages The maximum number of images the user will want to
 *            access simultaneously. This should be as small as possible to
 *            limit memory use. Once maxImages Images are obtained by the
 *            user, one of them has to be released before a new Image will
 *            become available for access through
 *            {@link #acquireLatestImage()} or {@link #acquireNextImage()}.
 *            Must be greater than 0.
 * Value is 1 or greater
 * @see android.media.Image
 
 * @return This value will never be {@code null}.
 * @apiSince 19
 */

@androidx.annotation.NonNull
public static android.media.ImageReader newInstance(int width, int height, int format, int maxImages) { throw new RuntimeException("Stub!"); }

/**
 * <p>
 * Create a new reader for images of the desired size, format and consumer usage flag.
 * </p>
 * <p>
 * The {@code maxImages} parameter determines the maximum number of {@link android.media.Image Image} objects that
 * can be be acquired from the {@code ImageReader} simultaneously. Requesting more buffers will
 * use up more memory, so it is important to use only the minimum number necessary for the use
 * case.
 * </p>
 * <p>
 * The valid sizes and formats depend on the source of the image data.
 * </p>
 * <p>
 * The format and usage flag combination describes how the buffer will be used by
 * consumer end-points. For example, if the application intends to send the images to
 * {@link android.media.MediaCodec} or {@link android.media.MediaRecorder} for hardware video
 * encoding, the format and usage flag combination needs to be
 * {@link android.graphics.ImageFormat#PRIVATE ImageFormat#PRIVATE} and {@link android.hardware.HardwareBuffer#USAGE_VIDEO_ENCODE HardwareBuffer#USAGE_VIDEO_ENCODE}. When an
 * {@link android.media.ImageReader ImageReader} object is created with a valid size and such format/usage flag
 * combination, the application can send the {@link android.media.Image Image} to an {@link android.media.ImageWriter ImageWriter} that
 * is created with the input {@link android.view.Surface} provided by the
 * {@link android.media.MediaCodec} or {@link android.media.MediaRecorder}.
 * </p>
 * <p>
 * If the {@code format} is {@link android.graphics.ImageFormat#PRIVATE ImageFormat#PRIVATE}, the created {@link android.media.ImageReader ImageReader}
 * will produce images that are not directly accessible by the application. The application can
 * still acquire images from this {@link android.media.ImageReader ImageReader}, and send them to the
 * {@link android.hardware.camera2.CameraDevice camera} for reprocessing, or to the
 * {@link android.media.MediaCodec} / {@link android.media.MediaRecorder} for hardware video
 * encoding via {@link android.media.ImageWriter ImageWriter} interface. However, the {@link android.media.Image#getPlanes() Image#getPlanes()} will return an empty array for {@link android.graphics.ImageFormat#PRIVATE ImageFormat#PRIVATE} format
 * images. The application can check if an existing reader's format by calling
 * {@link #getImageFormat()}.
 * </p>
 * <p>
 * {@link android.graphics.ImageFormat#PRIVATE ImageFormat#PRIVATE} format {@link android.media.ImageReader ImageReader} are more
 * efficient to use when application access to image data is not necessary, compared to
 * ImageReaders using other format such as {@link android.graphics.ImageFormat#YUV_420_888 ImageFormat#YUV_420_888}.
 * </p>
 * <p>
 * Note that not all format and usage flag combinations are supported by the
 * {@link android.media.ImageReader ImageReader}. Below are the supported combinations by the {@link android.media.ImageReader ImageReader}
 * (assuming the consumer end-points support the such image consumption, e.g., hardware video
 * encoding).
 * <table>
 * <tr>
 *   <th>Format</th>
 *   <th>Compatible usage flags</th>
 * </tr>
 * <tr>
 *   <td>non-{@link android.graphics.ImageFormat#PRIVATE PRIVATE} formats defined by
 *   {@link android.graphics.ImageFormat ImageFormat} or
 *   {@link android.graphics.PixelFormat PixelFormat}</td>
 *   <td>{@link android.hardware.HardwareBuffer#USAGE_CPU_READ_RARELY HardwareBuffer#USAGE_CPU_READ_RARELY} or
 *   {@link android.hardware.HardwareBuffer#USAGE_CPU_READ_OFTEN HardwareBuffer#USAGE_CPU_READ_OFTEN}</td>
 * </tr>
 * <tr>
 *   <td>{@link android.graphics.ImageFormat#PRIVATE}</td>
 *   <td>{@link android.hardware.HardwareBuffer#USAGE_VIDEO_ENCODE HardwareBuffer#USAGE_VIDEO_ENCODE} or
 *   {@link android.hardware.HardwareBuffer#USAGE_GPU_SAMPLED_IMAGE HardwareBuffer#USAGE_GPU_SAMPLED_IMAGE}, or combined</td>
 * </tr>
 * </table>
 * Using other combinations may result in {@link java.lang.IllegalArgumentException IllegalArgumentException}.
 * </p>
 * @param width The default width in pixels of the Images that this reader will produce.
 * Value is 1 or greater
 * @param height The default height in pixels of the Images that this reader will produce.
 * Value is 1 or greater
 * @param format The format of the Image that this reader will produce. This must be one of the
 *            {@link android.graphics.ImageFormat} or {@link android.graphics.PixelFormat}
 *            constants. Note that not all formats are supported, like ImageFormat.NV21.
 * Value is {@link android.graphics.ImageFormat#UNKNOWN}, {@link android.graphics.ImageFormat#RGB_565}, {@link android.graphics.ImageFormat#YV12}, {@link android.graphics.ImageFormat#Y8}, android.graphics.ImageFormat.Y16, {@link android.graphics.ImageFormat#NV16}, {@link android.graphics.ImageFormat#NV21}, {@link android.graphics.ImageFormat#YUY2}, {@link android.graphics.ImageFormat#JPEG}, {@link android.graphics.ImageFormat#DEPTH_JPEG}, {@link android.graphics.ImageFormat#YUV_420_888}, {@link android.graphics.ImageFormat#YUV_422_888}, {@link android.graphics.ImageFormat#YUV_444_888}, {@link android.graphics.ImageFormat#FLEX_RGB_888}, {@link android.graphics.ImageFormat#FLEX_RGBA_8888}, {@link android.graphics.ImageFormat#RAW_SENSOR}, {@link android.graphics.ImageFormat#RAW_PRIVATE}, {@link android.graphics.ImageFormat#RAW10}, {@link android.graphics.ImageFormat#RAW12}, {@link android.graphics.ImageFormat#DEPTH16}, {@link android.graphics.ImageFormat#DEPTH_POINT_CLOUD}, android.graphics.ImageFormat.RAW_DEPTH, {@link android.graphics.ImageFormat#PRIVATE}, or {@link android.graphics.ImageFormat#HEIC}
 * @param maxImages The maximum number of images the user will want to access simultaneously.
 *            This should be as small as possible to limit memory use. Once maxImages Images are
 *            obtained by the user, one of them has to be released before a new Image will
 *            become available for access through {@link #acquireLatestImage()} or
 *            {@link #acquireNextImage()}. Must be greater than 0.
 * Value is 1 or greater
 * @param usage The intended usage of the images produced by this ImageReader. See the usages
 *              on {@link android.hardware.HardwareBuffer HardwareBuffer} for a list of valid usage bits. See also
 *              {@link android.hardware.HardwareBuffer#isSupported(int,int,int,int,long) HardwareBuffer#isSupported(int, int, int, int, long)} for checking
 *              if a combination is supported. If it's not supported this will throw
 *              an {@link java.lang.IllegalArgumentException IllegalArgumentException}.
 * Value is either <code>0</code> or a combination of {@link android.hardware.HardwareBuffer#USAGE_CPU_READ_RARELY}, {@link android.hardware.HardwareBuffer#USAGE_CPU_READ_OFTEN}, {@link android.hardware.HardwareBuffer#USAGE_CPU_WRITE_RARELY}, {@link android.hardware.HardwareBuffer#USAGE_CPU_WRITE_OFTEN}, {@link android.hardware.HardwareBuffer#USAGE_GPU_SAMPLED_IMAGE}, {@link android.hardware.HardwareBuffer#USAGE_GPU_COLOR_OUTPUT}, {@link android.hardware.HardwareBuffer#USAGE_PROTECTED_CONTENT}, {@link android.hardware.HardwareBuffer#USAGE_VIDEO_ENCODE}, {@link android.hardware.HardwareBuffer#USAGE_GPU_DATA_BUFFER}, {@link android.hardware.HardwareBuffer#USAGE_SENSOR_DIRECT_DATA}, {@link android.hardware.HardwareBuffer#USAGE_GPU_CUBE_MAP}, and {@link android.hardware.HardwareBuffer#USAGE_GPU_MIPMAP_COMPLETE}
 * @see android.media.Image
 * @see android.hardware.HardwareBuffer
 
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public static android.media.ImageReader newInstance(int width, int height, int format, int maxImages, long usage) { throw new RuntimeException("Stub!"); }

/**
 * The default width of {@link android.media.Image Image}, in pixels.
 *
 * <p>The width may be overridden by the producer sending buffers to this
 * ImageReader's Surface. If so, the actual width of the images can be
 * found using {@link android.media.Image#getWidth Image#getWidth}.</p>
 *
 * @return the expected width of an Image
 * @apiSince 19
 */

public int getWidth() { throw new RuntimeException("Stub!"); }

/**
 * The default height of {@link android.media.Image Image}, in pixels.
 *
 * <p>The height may be overridden by the producer sending buffers to this
 * ImageReader's Surface. If so, the actual height of the images can be
 * found using {@link android.media.Image#getHeight Image#getHeight}.</p>
 *
 * @return the expected height of an Image
 * @apiSince 19
 */

public int getHeight() { throw new RuntimeException("Stub!"); }

/**
 * The default {@link android.graphics.ImageFormat ImageFormat} of {@link android.media.Image Image}.
 *
 * <p>Some color formats may be overridden by the producer sending buffers to
 * this ImageReader's Surface if the default color format allows. ImageReader
 * guarantees that all {@link android.media.Image Image} acquired from ImageReader
 * (for example, with {@link #acquireNextImage}) will have a "compatible"
 * format to what was specified in {@link #newInstance}.
 * As of now, each format is only compatible to itself.
 * The actual format of the images can be found using {@link android.media.Image#getFormat Image#getFormat}.</p>
 *
 * @return the expected format of an Image
 *
 * @see android.graphics.ImageFormat
 * @apiSince 19
 */

public int getImageFormat() { throw new RuntimeException("Stub!"); }

/**
 * Maximum number of images that can be acquired from the ImageReader by any time (for example,
 * with {@link #acquireNextImage}).
 *
 * <p>An image is considered acquired after it's returned by a function from ImageReader, and
 * until the Image is {@link android.media.Image#close Image#close} to release the image back to the ImageReader.
 * </p>
 *
 * <p>Attempting to acquire more than {@code maxImages} concurrently will result in the
 * acquire function throwing a {@link java.lang.IllegalStateException IllegalStateException}. Furthermore,
 * while the max number of images have been acquired by the ImageReader user, the producer
 * enqueueing additional images may stall until at least one image has been released. </p>
 *
 * @return Maximum number of images for this ImageReader.
 *
 * @see android.media.Image#close
 * @apiSince 19
 */

public int getMaxImages() { throw new RuntimeException("Stub!"); }

/**
 * <p>Get a {@link android.view.Surface Surface} that can be used to produce {@link android.media.Image Image} for this
 * {@code ImageReader}.</p>
 *
 * <p>Until valid image data is rendered into this {@link android.view.Surface Surface}, the
 * {@link #acquireNextImage} method will return {@code null}. Only one source
 * can be producing data into this Surface at the same time, although the
 * same {@link android.view.Surface Surface} can be reused with a different API once the first source is
 * disconnected from the {@link android.view.Surface Surface}.</p>
 *
 * <p>Please note that holding on to the Surface object returned by this method is not enough
 * to keep its parent ImageReader from being reclaimed. In that sense, a Surface acts like a
 * {@link java.lang.ref.WeakReference weak reference} to the ImageReader that provides it.</p>
 *
 * @return A {@link android.view.Surface Surface} to use for a drawing target for various APIs.
 * @apiSince 19
 */

public android.view.Surface getSurface() { throw new RuntimeException("Stub!"); }

/**
 * <p>
 * Acquire the latest {@link android.media.Image Image} from the ImageReader's queue, dropping older
 * {@link android.media.Image Image}. Returns {@code null} if no new image is available.
 * </p>
 * <p>
 * This operation will acquire all the images possible from the ImageReader,
 * but {@link #close} all images that aren't the latest. This function is
 * recommended to use over {@link #acquireNextImage} for most use-cases, as it's
 * more suited for real-time processing.
 * </p>
 * <p>
 * Note that {@link #getMaxImages maxImages} should be at least 2 for
 * {@link #acquireLatestImage} to be any different than {@link #acquireNextImage} -
 * discarding all-but-the-newest {@link android.media.Image Image} requires temporarily acquiring two
 * {@link android.media.Image Image} at once. Or more generally, calling {@link #acquireLatestImage}
 * with less than two images of margin, that is
 * {@code (maxImages - currentAcquiredImages < 2)} will not discard as expected.
 * </p>
 * <p>
 * This operation will fail by throwing an {@link java.lang.IllegalStateException IllegalStateException} if
 * {@code maxImages} have been acquired with {@link #acquireLatestImage} or
 * {@link #acquireNextImage}. In particular a sequence of {@link #acquireLatestImage}
 * calls greater than {@link #getMaxImages} without calling {@link android.media.Image#close Image#close} in-between
 * will exhaust the underlying queue. At such a time, {@link java.lang.IllegalStateException IllegalStateException}
 * will be thrown until more images are
 * released with {@link android.media.Image#close Image#close}.
 * </p>
 *
 * @return latest frame of image data, or {@code null} if no image data is available.
 * @throws java.lang.IllegalStateException if too many images are currently acquired
 * @apiSince 19
 */

public android.media.Image acquireLatestImage() { throw new RuntimeException("Stub!"); }

/**
 * <p>
 * Acquire the next Image from the ImageReader's queue. Returns {@code null} if
 * no new image is available.
 * </p>
 *
 * <p><i>Warning:</i> Consider using {@link #acquireLatestImage()} instead, as it will
 * automatically release older images, and allow slower-running processing routines to catch
 * up to the newest frame. Usage of {@link #acquireNextImage} is recommended for
 * batch/background processing. Incorrectly using this function can cause images to appear
 * with an ever-increasing delay, followed by a complete stall where no new images seem to
 * appear.
 * </p>
 *
 * <p>
 * This operation will fail by throwing an {@link java.lang.IllegalStateException IllegalStateException} if
 * {@code maxImages} have been acquired with {@link #acquireNextImage} or
 * {@link #acquireLatestImage}. In particular a sequence of {@link #acquireNextImage} or
 * {@link #acquireLatestImage} calls greater than {@link #getMaxImages maxImages} without
 * calling {@link android.media.Image#close Image#close} in-between will exhaust the underlying queue. At such a time,
 * {@link java.lang.IllegalStateException IllegalStateException} will be thrown until more images are released with
 * {@link android.media.Image#close Image#close}.
 * </p>
 *
 * @return a new frame of image data, or {@code null} if no image data is available.
 * @throws java.lang.IllegalStateException if {@code maxImages} images are currently acquired
 * @see #acquireLatestImage
 * @apiSince 19
 */

public android.media.Image acquireNextImage() { throw new RuntimeException("Stub!"); }

/**
 * Register a listener to be invoked when a new image becomes available
 * from the ImageReader.
 *
 * @param listener
 *            The listener that will be run.
 * @param handler
 *            The handler on which the listener should be invoked, or null
 *            if the listener should be invoked on the calling thread's looper.
 * @throws java.lang.IllegalArgumentException
 *            If no handler specified and the calling thread has no looper.
 * @apiSince 19
 */

public void setOnImageAvailableListener(android.media.ImageReader.OnImageAvailableListener listener, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Free up all the resources associated with this ImageReader.
 *
 * <p>
 * After calling this method, this ImageReader can not be used. Calling
 * any methods on this ImageReader and Images previously provided by
 * {@link #acquireNextImage} or {@link #acquireLatestImage}
 * will result in an {@link java.lang.IllegalStateException IllegalStateException}, and attempting to read from
 * {@link java.nio.ByteBuffer ByteBuffer} returned by an earlier
 * {@link android.media.Image.Plane#getBuffer Image.Plane#getBuffer} call will
 * have undefined behavior.
 * </p>
 * @apiSince 19
 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * Discard any free buffers owned by this ImageReader.
 *
 * <p>
 * Generally, the ImageReader caches buffers for reuse once they have been
 * allocated, for best performance. However, sometimes it may be important to
 * release all the cached, unused buffers to save on memory.
 * </p>
 * <p>
 * Calling this method will discard all free cached buffers. This does not include any buffers
 * associated with Images acquired from the ImageReader, any filled buffers waiting to be
 * acquired, and any buffers currently in use by the source rendering buffers into the
 * ImageReader's Surface.
 * <p>
 * The ImageReader continues to be usable after this call, but may need to reallocate buffers
 * when more buffers are needed for rendering.
 * </p>
 * @apiSince 28
 */

public void discardFreeBuffers() { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }
/**
 * Callback interface for being notified that a new image is available.
 *
 * <p>
 * The onImageAvailable is called per image basis, that is, callback fires for every new frame
 * available from ImageReader.
 * </p>
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnImageAvailableListener {

/**
 * Callback that is called when a new image is available from ImageReader.
 *
 * @param reader the ImageReader the callback is associated with.
 * @see android.media.ImageReader
 * @see android.media.Image
 * @apiSince 19
 */

public void onImageAvailable(android.media.ImageReader reader);
}

}

