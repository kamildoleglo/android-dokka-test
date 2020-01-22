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


package android.graphics;

import android.util.DisplayMetrics;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import android.hardware.HardwareBuffer;
import android.os.Build;
import android.os.Parcel;
import android.util.Half;

/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Bitmap implements android.os.Parcelable {

Bitmap() { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the density for this bitmap.</p>
 *
 * <p>The default density is the same density as the current display,
 * unless the current application does not support different screen
 * densities in which case it is
 * {@link android.util.DisplayMetrics#DENSITY_DEFAULT}.  Note that
 * compatibility mode is determined by the application that was initially
 * loaded into a process -- applications that share the same process should
 * all have the same compatibility, or ensure they explicitly set the
 * density of their bitmaps appropriately.</p>
 *
 * @return A scaling factor of the default density or {@link #DENSITY_NONE}
 *         if the scaling factor is unknown.
 *
 * @see #setDensity(int)
 * @see android.util.DisplayMetrics#DENSITY_DEFAULT
 * @see android.util.DisplayMetrics#densityDpi
 * @see #DENSITY_NONE
 * @apiSince 4
 */

public int getDensity() { throw new RuntimeException("Stub!"); }

/**
 * <p>Specifies the density for this bitmap.  When the bitmap is
 * drawn to a Canvas that also has a density, it will be scaled
 * appropriately.</p>
 *
 * @param density The density scaling factor to use with this bitmap or
 *        {@link #DENSITY_NONE} if the density is unknown.
 *
 * @see #getDensity()
 * @see android.util.DisplayMetrics#DENSITY_DEFAULT
 * @see android.util.DisplayMetrics#densityDpi
 * @see #DENSITY_NONE
 * @apiSince 4
 */

public void setDensity(int density) { throw new RuntimeException("Stub!"); }

/**
 * <p>Modifies the bitmap to have a specified width, height, and {@link android.graphics.Bitmap.Config Config}, without affecting the underlying allocation backing the bitmap.
 * Bitmap pixel data is not re-initialized for the new configuration.</p>
 *
 * <p>This method can be used to avoid allocating a new bitmap, instead
 * reusing an existing bitmap's allocation for a new configuration of equal
 * or lesser size. If the Bitmap's allocation isn't large enough to support
 * the new configuration, an IllegalArgumentException will be thrown and the
 * bitmap will not be modified.</p>
 *
 * <p>The result of {@link #getByteCount()} will reflect the new configuration,
 * while {@link #getAllocationByteCount()} will reflect that of the initial
 * configuration.</p>
 *
 * <p>Note: This may change this result of hasAlpha(). When converting to 565,
 * the new bitmap will always be considered opaque. When converting from 565,
 * the new bitmap will be considered non-opaque, and will respect the value
 * set by setPremultiplied().</p>
 *
 * <p>WARNING: This method should NOT be called on a bitmap currently in use
 * by the view system, Canvas, or the AndroidBitmap NDK API. It does not
 * make guarantees about how the underlying pixel buffer is remapped to the
 * new config, just that the allocation is reused. Additionally, the view
 * system does not account for bitmap properties being modifying during use,
 * e.g. while attached to drawables.</p>
 *
 * <p>In order to safely ensure that a Bitmap is no longer in use by the
 * View system it is necessary to wait for a draw pass to occur after
 * invalidate()'ing any view that had previously drawn the Bitmap in the last
 * draw pass due to hardware acceleration's caching of draw commands. As
 * an example, here is how this can be done for an ImageView:
 * <pre class="prettyprint">
 *      ImageView myImageView = ...;
 *      final Bitmap myBitmap = ...;
 *      myImageView.setImageDrawable(null);
 *      myImageView.post(new Runnable() {
 *          public void run() {
 *              // myBitmap is now no longer in use by the ImageView
 *              // and can be safely reconfigured.
 *              myBitmap.reconfigure(...);
 *          }
 *      });
 * </pre></p>
 *
 * @see #setWidth(int)
 * @see #setHeight(int)
 * @see #setConfig(Config)
 * @apiSince 19
 */

public void reconfigure(int width, int height, android.graphics.Bitmap.Config config) { throw new RuntimeException("Stub!"); }

/**
 * <p>Convenience method for calling {@link #reconfigure(int,int,android.graphics.Bitmap.Config)}
 * with the current height and config.</p>
 *
 * <p>WARNING: this method should not be used on bitmaps currently used by
 * the view system, see {@link #reconfigure(int,int,android.graphics.Bitmap.Config)} for more
 * details.</p>
 *
 * @see #reconfigure(int, int, Config)
 * @see #setHeight(int)
 * @see #setConfig(Config)
 * @apiSince 19
 */

public void setWidth(int width) { throw new RuntimeException("Stub!"); }

/**
 * <p>Convenience method for calling {@link #reconfigure(int,int,android.graphics.Bitmap.Config)}
 * with the current width and config.</p>
 *
 * <p>WARNING: this method should not be used on bitmaps currently used by
 * the view system, see {@link #reconfigure(int,int,android.graphics.Bitmap.Config)} for more
 * details.</p>
 *
 * @see #reconfigure(int, int, Config)
 * @see #setWidth(int)
 * @see #setConfig(Config)
 * @apiSince 19
 */

public void setHeight(int height) { throw new RuntimeException("Stub!"); }

/**
 * <p>Convenience method for calling {@link #reconfigure(int,int,android.graphics.Bitmap.Config)}
 * with the current height and width.</p>
 *
 * <p>WARNING: this method should not be used on bitmaps currently used by
 * the view system, see {@link #reconfigure(int,int,android.graphics.Bitmap.Config)} for more
 * details.</p>
 *
 * @see #reconfigure(int, int, Config)
 * @see #setWidth(int)
 * @see #setHeight(int)
 * @apiSince 19
 */

public void setConfig(android.graphics.Bitmap.Config config) { throw new RuntimeException("Stub!"); }

/**
 * Free the native object associated with this bitmap, and clear the
 * reference to the pixel data. This will not free the pixel data synchronously;
 * it simply allows it to be garbage collected if there are no other references.
 * The bitmap is marked as "dead", meaning it will throw an exception if
 * getPixels() or setPixels() is called, and will draw nothing. This operation
 * cannot be reversed, so it should only be called if you are sure there are no
 * further uses for the bitmap. This is an advanced call, and normally need
 * not be called, since the normal GC process will free up this memory when
 * there are no more references to this bitmap.
 * @apiSince 1
 */

public void recycle() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this bitmap has been recycled. If so, then it is an error
 * to try to access its pixels, and the bitmap will not draw.
 *
 * @return true if the bitmap has been recycled
 * @apiSince 1
 */

public boolean isRecycled() { throw new RuntimeException("Stub!"); }

/**
 * Returns the generation ID of this bitmap. The generation ID changes
 * whenever the bitmap is modified. This can be used as an efficient way to
 * check if a bitmap has changed.
 *
 * @return The current generation ID for this bitmap.
 * @apiSince 12
 */

public int getGenerationId() { throw new RuntimeException("Stub!"); }

/**
 * <p>Copy the bitmap's pixels into the specified buffer (allocated by the
 * caller). An exception is thrown if the buffer is not large enough to
 * hold all of the pixels (taking into account the number of bytes per
 * pixel) or if the Buffer subclass is not one of the support types
 * (ByteBuffer, ShortBuffer, IntBuffer).</p>
 * <p>The content of the bitmap is copied into the buffer as-is. This means
 * that if this bitmap stores its pixels pre-multiplied
 * (see {@link #isPremultiplied()}, the values in the buffer will also be
 * pre-multiplied. The pixels remain in the color space of the bitmap.</p>
 * <p>After this method returns, the current position of the buffer is
 * updated: the position is incremented by the number of elements written
 * in the buffer.</p>
 * @throws java.lang.IllegalStateException if the bitmap's config is {@link android.graphics.Bitmap.Config#HARDWARE Config#HARDWARE}
 * @apiSince 1
 */

public void copyPixelsToBuffer(java.nio.Buffer dst) { throw new RuntimeException("Stub!"); }

/**
 * <p>Copy the pixels from the buffer, beginning at the current position,
 * overwriting the bitmap's pixels. The data in the buffer is not changed
 * in any way (unlike setPixels(), which converts from unpremultipled 32bit
 * to whatever the bitmap's native format is. The pixels in the source
 * buffer are assumed to be in the bitmap's color space.</p>
 * <p>After this method returns, the current position of the buffer is
 * updated: the position is incremented by the number of elements read from
 * the buffer. If you need to read the bitmap from the buffer again you must
 * first rewind the buffer.</p>
 * @throws java.lang.IllegalStateException if the bitmap's config is {@link android.graphics.Bitmap.Config#HARDWARE Config#HARDWARE}
 * @apiSince 3
 */

public void copyPixelsFromBuffer(java.nio.Buffer src) { throw new RuntimeException("Stub!"); }

/**
 * Tries to make a new bitmap based on the dimensions of this bitmap,
 * setting the new bitmap's config to the one specified, and then copying
 * this bitmap's pixels into the new bitmap. If the conversion is not
 * supported, or the allocator fails, then this returns NULL.  The returned
 * bitmap has the same density and color space as the original, except in
 * the following cases. When copying to {@link android.graphics.Bitmap.Config#ALPHA_8 Config#ALPHA_8}, the color
 * space is dropped. When copying to or from {@link android.graphics.Bitmap.Config#RGBA_F16 Config#RGBA_F16},
 * EXTENDED or non-EXTENDED variants may be adjusted as appropriate.
 *
 * @param config    The desired config for the resulting bitmap
 * @param isMutable True if the resulting bitmap should be mutable (i.e.
 *                  its pixels can be modified)
 * @return the new bitmap, or null if the copy could not be made.
 * @throws java.lang.IllegalArgumentException if config is {@link android.graphics.Bitmap.Config#HARDWARE Config#HARDWARE} and isMutable is true
 * @apiSince 1
 */

public android.graphics.Bitmap copy(android.graphics.Bitmap.Config config, boolean isMutable) { throw new RuntimeException("Stub!"); }

/**
 * Create a hardware bitmap backed by a {@link android.hardware.HardwareBuffer HardwareBuffer}.
 *
 * <p>The passed HardwareBuffer's usage flags must contain
 * {@link android.hardware.HardwareBuffer#USAGE_GPU_SAMPLED_IMAGE HardwareBuffer#USAGE_GPU_SAMPLED_IMAGE}.
 *
 * <p>The bitmap will keep a reference to the buffer so that callers can safely close the
 * HardwareBuffer without affecting the Bitmap. However the HardwareBuffer must not be
 * modified while a wrapped Bitmap is accessing it. Doing so will result in undefined behavior.
 *
 * @param hardwareBuffer The HardwareBuffer to wrap.
 * This value must never be {@code null}.
 * @param colorSpace The color space of the bitmap. Must be a {@link android.graphics.ColorSpace.Rgb ColorSpace.Rgb} colorspace.
 *                   If null, SRGB is assumed.
 * This value may be {@code null}.
 * @return A bitmap wrapping the buffer, or null if there was a problem creating the bitmap.
 * @throws java.lang.IllegalArgumentException if the HardwareBuffer has an invalid usage, or an invalid
 *                                  colorspace is given.
 * @apiSince 29
 */

@androidx.annotation.Nullable
public static android.graphics.Bitmap wrapHardwareBuffer(@androidx.annotation.NonNull android.hardware.HardwareBuffer hardwareBuffer, @androidx.annotation.Nullable android.graphics.ColorSpace colorSpace) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new bitmap, scaled from an existing bitmap, when possible. If the
 * specified width and height are the same as the current width and height of
 * the source bitmap, the source bitmap is returned and no new bitmap is
 * created.
 *
 * @param src       The source bitmap.
 * This value must never be {@code null}.
 * @param dstWidth  The new bitmap's desired width.
 * @param dstHeight The new bitmap's desired height.
 * @param filter    Whether or not bilinear filtering should be used when scaling the
 *                  bitmap. If this is true then bilinear filtering will be used when
 *                  scaling which has better image quality at the cost of worse performance.
 *                  If this is false then nearest-neighbor scaling is used instead which
 *                  will have worse image quality but is faster. Recommended default
 *                  is to set filter to 'true' as the cost of bilinear filtering is
 *                  typically minimal and the improved image quality is significant.
 * @return The new scaled bitmap or the source bitmap if no scaling is required.
 * @throws java.lang.IllegalArgumentException if width is <= 0, or height is <= 0
 * @apiSince 1
 */

public static android.graphics.Bitmap createScaledBitmap(@androidx.annotation.NonNull android.graphics.Bitmap src, int dstWidth, int dstHeight, boolean filter) { throw new RuntimeException("Stub!"); }

/**
 * Returns a bitmap from the source bitmap. The new bitmap may
 * be the same object as source, or a copy may have been made.  It is
 * initialized with the same density and color space as the original bitmap.
 
 * @param src This value must never be {@code null}.
 * @apiSince 1
 */

public static android.graphics.Bitmap createBitmap(@androidx.annotation.NonNull android.graphics.Bitmap src) { throw new RuntimeException("Stub!"); }

/**
 * Returns a bitmap from the specified subset of the source
 * bitmap. The new bitmap may be the same object as source, or a copy may
 * have been made. It is initialized with the same density and color space
 * as the original bitmap.
 *
 * @param source   The bitmap we are subsetting
 * This value must never be {@code null}.
 * @param x        The x coordinate of the first pixel in source
 * @param y        The y coordinate of the first pixel in source
 * @param width    The number of pixels in each row
 * @param height   The number of rows
 * @return A copy of a subset of the source bitmap or the source bitmap itself.
 * @throws java.lang.IllegalArgumentException if the x, y, width, height values are
 *         outside of the dimensions of the source bitmap, or width is <= 0,
 *         or height is <= 0
 * @apiSince 1
 */

public static android.graphics.Bitmap createBitmap(@androidx.annotation.NonNull android.graphics.Bitmap source, int x, int y, int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * Returns a bitmap from subset of the source bitmap,
 * transformed by the optional matrix. The new bitmap may be the
 * same object as source, or a copy may have been made. It is
 * initialized with the same density and color space as the original
 * bitmap.
 *
 * If the source bitmap is immutable and the requested subset is the
 * same as the source bitmap itself, then the source bitmap is
 * returned and no new bitmap is created.
 *
 * The returned bitmap will always be mutable except in the following scenarios:
 * (1) In situations where the source bitmap is returned and the source bitmap is immutable
 *
 * (2) The source bitmap is a hardware bitmap. That is {@link #getConfig()} is equivalent to
 * {@link android.graphics.Bitmap.Config#HARDWARE Config#HARDWARE}
 *
 * @param source   The bitmap we are subsetting
 * This value must never be {@code null}.
 * @param x        The x coordinate of the first pixel in source
 * @param y        The y coordinate of the first pixel in source
 * @param width    The number of pixels in each row
 * @param height   The number of rows
 * @param m        Optional matrix to be applied to the pixels
 * This value may be {@code null}.
 * @param filter   true if the source should be filtered.
 *                   Only applies if the matrix contains more than just
 *                   translation.
 * @return A bitmap that represents the specified subset of source
 * @throws java.lang.IllegalArgumentException if the x, y, width, height values are
 *         outside of the dimensions of the source bitmap, or width is <= 0,
 *         or height is <= 0, or if the source bitmap has already been recycled
 * @apiSince 1
 */

public static android.graphics.Bitmap createBitmap(@androidx.annotation.NonNull android.graphics.Bitmap source, int x, int y, int width, int height, @androidx.annotation.Nullable android.graphics.Matrix m, boolean filter) { throw new RuntimeException("Stub!"); }

/**
 * Returns a mutable bitmap with the specified width and height.  Its
 * initial density is as per {@link #getDensity}. The newly created
 * bitmap is in the {@link android.graphics.ColorSpace.Named#SRGB ColorSpace.Named#SRGB} color space.
 *
 * @param width    The width of the bitmap
 * @param height   The height of the bitmap
 * @param config   The bitmap config to create.
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if the width or height are <= 0, or if
 *         Config is Config.HARDWARE, because hardware bitmaps are always immutable
 * @apiSince 1
 */

public static android.graphics.Bitmap createBitmap(int width, int height, @androidx.annotation.NonNull android.graphics.Bitmap.Config config) { throw new RuntimeException("Stub!"); }

/**
 * Returns a mutable bitmap with the specified width and height.  Its
 * initial density is determined from the given {@link android.util.DisplayMetrics DisplayMetrics}.
 * The newly created bitmap is in the {@link android.graphics.ColorSpace.Named#SRGB ColorSpace.Named#SRGB}
 * color space.
 *
 * @param display  Display metrics for the display this bitmap will be
 *                 drawn on.
 * This value may be {@code null}.
 * @param width    The width of the bitmap
 * @param height   The height of the bitmap
 * @param config   The bitmap config to create.
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if the width or height are <= 0, or if
 *         Config is Config.HARDWARE, because hardware bitmaps are always immutable
 * @apiSince 17
 */

public static android.graphics.Bitmap createBitmap(@androidx.annotation.Nullable android.util.DisplayMetrics display, int width, int height, @androidx.annotation.NonNull android.graphics.Bitmap.Config config) { throw new RuntimeException("Stub!"); }

/**
 * Returns a mutable bitmap with the specified width and height.  Its
 * initial density is as per {@link #getDensity}. The newly created
 * bitmap is in the {@link android.graphics.ColorSpace.Named#SRGB ColorSpace.Named#SRGB} color space.
 *
 * @param width    The width of the bitmap
 * @param height   The height of the bitmap
 * @param config   The bitmap config to create.
 * This value must never be {@code null}.
 * @param hasAlpha If the bitmap is ARGB_8888 or RGBA_16F this flag can be used to
 *                 mark the bitmap as opaque. Doing so will clear the bitmap in black
 *                 instead of transparent.
 *
 * @throws java.lang.IllegalArgumentException if the width or height are <= 0, or if
 *         Config is Config.HARDWARE, because hardware bitmaps are always immutable
 * @apiSince 26
 */

public static android.graphics.Bitmap createBitmap(int width, int height, @androidx.annotation.NonNull android.graphics.Bitmap.Config config, boolean hasAlpha) { throw new RuntimeException("Stub!"); }

/**
 * Returns a mutable bitmap with the specified width and height.  Its
 * initial density is as per {@link #getDensity}.
 *
 * @param width    The width of the bitmap
 * @param height   The height of the bitmap
 * @param config   The bitmap config to create.
 * This value must never be {@code null}.
 * @param hasAlpha If the bitmap is ARGB_8888 or RGBA_16F this flag can be used to
 *                 mark the bitmap as opaque. Doing so will clear the bitmap in black
 *                 instead of transparent.
 * @param colorSpace The color space of the bitmap. If the config is {@link android.graphics.Bitmap.Config#RGBA_F16 Config#RGBA_F16}
 *                   and {@link android.graphics.ColorSpace.Named#SRGB ColorSpace.Named#SRGB} or
 *                   {@link android.graphics.ColorSpace.Named#LINEAR_SRGB ColorSpace.Named#LINEAR_SRGB} is provided then the
 *                   corresponding extended range variant is assumed.
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if the width or height are <= 0, if
 *         Config is Config.HARDWARE (because hardware bitmaps are always
 *         immutable), if the specified color space is not {@link android.graphics.ColorSpace.Model#RGB ColorSpace.Model#RGB},
 *         if the specified color space's transfer function is not an
 *         {@link android.graphics.ColorSpace.Rgb.TransferParameters ColorSpace.Rgb.TransferParameters}, or if
 *         the color space is null
 * @apiSince 26
 */

public static android.graphics.Bitmap createBitmap(int width, int height, @androidx.annotation.NonNull android.graphics.Bitmap.Config config, boolean hasAlpha, @androidx.annotation.NonNull android.graphics.ColorSpace colorSpace) { throw new RuntimeException("Stub!"); }

/**
 * Returns a mutable bitmap with the specified width and height.  Its
 * initial density is determined from the given {@link android.util.DisplayMetrics DisplayMetrics}.
 * The newly created bitmap is in the {@link android.graphics.ColorSpace.Named#SRGB ColorSpace.Named#SRGB}
 * color space.
 *
 * @param display  Display metrics for the display this bitmap will be
 *                 drawn on.
 * This value may be {@code null}.
 * @param width    The width of the bitmap
 * @param height   The height of the bitmap
 * @param config   The bitmap config to create.
 * This value must never be {@code null}.
 * @param hasAlpha If the bitmap is ARGB_8888 or RGBA_16F this flag can be used to
 *                 mark the bitmap as opaque. Doing so will clear the bitmap in black
 *                 instead of transparent.
 *
 * @throws java.lang.IllegalArgumentException if the width or height are <= 0, or if
 *         Config is Config.HARDWARE, because hardware bitmaps are always immutable
 * @apiSince 26
 */

public static android.graphics.Bitmap createBitmap(@androidx.annotation.Nullable android.util.DisplayMetrics display, int width, int height, @androidx.annotation.NonNull android.graphics.Bitmap.Config config, boolean hasAlpha) { throw new RuntimeException("Stub!"); }

/**
 * Returns a mutable bitmap with the specified width and height.  Its
 * initial density is determined from the given {@link android.util.DisplayMetrics DisplayMetrics}.
 * The newly created bitmap is in the {@link android.graphics.ColorSpace.Named#SRGB ColorSpace.Named#SRGB}
 * color space.
 *
 * @param display  Display metrics for the display this bitmap will be
 *                 drawn on.
 * This value may be {@code null}.
 * @param width    The width of the bitmap
 * @param height   The height of the bitmap
 * @param config   The bitmap config to create.
 * This value must never be {@code null}.
 * @param hasAlpha If the bitmap is ARGB_8888 or RGBA_16F this flag can be used to
 *                 mark the bitmap as opaque. Doing so will clear the bitmap in black
 *                 instead of transparent.
 * @param colorSpace The color space of the bitmap. If the config is {@link android.graphics.Bitmap.Config#RGBA_F16 Config#RGBA_F16}
 *                   and {@link android.graphics.ColorSpace.Named#SRGB ColorSpace.Named#SRGB} or
 *                   {@link android.graphics.ColorSpace.Named#LINEAR_SRGB ColorSpace.Named#LINEAR_SRGB} is provided then the
 *                   corresponding extended range variant is assumed.
 *
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if the width or height are <= 0, if
 *         Config is Config.HARDWARE (because hardware bitmaps are always
 *         immutable), if the specified color space is not {@link android.graphics.ColorSpace.Model#RGB ColorSpace.Model#RGB},
 *         if the specified color space's transfer function is not an
 *         {@link android.graphics.ColorSpace.Rgb.TransferParameters ColorSpace.Rgb.TransferParameters}, or if
 *         the color space is null
 * @apiSince 26
 */

public static android.graphics.Bitmap createBitmap(@androidx.annotation.Nullable android.util.DisplayMetrics display, int width, int height, @androidx.annotation.NonNull android.graphics.Bitmap.Config config, boolean hasAlpha, @androidx.annotation.NonNull android.graphics.ColorSpace colorSpace) { throw new RuntimeException("Stub!"); }

/**
 * Returns a immutable bitmap with the specified width and height, with each
 * pixel value set to the corresponding value in the colors array.  Its
 * initial density is as per {@link #getDensity}. The newly created
 * bitmap is in the {@link android.graphics.ColorSpace.Named#SRGB ColorSpace.Named#SRGB} color space.
 *
 * @param colors   Array of sRGB {@link android.graphics.Color Color} used to initialize the pixels.
 * This value must never be {@code null}.
 * @param offset   Number of values to skip before the first color in the
 *                 array of colors.
 * @param stride   Number of colors in the array between rows (must be >=
 *                 width or <= -width).
 * @param width    The width of the bitmap
 * @param height   The height of the bitmap
 * @param config   The bitmap config to create. If the config does not
 *                 support per-pixel alpha (e.g. RGB_565), then the alpha
 *                 bytes in the colors[] will be ignored (assumed to be FF)
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if the width or height are <= 0, or if
 *         the color array's length is less than the number of pixels.
 * @apiSince 1
 */

public static android.graphics.Bitmap createBitmap(@androidx.annotation.NonNull int[] colors, int offset, int stride, int width, int height, @androidx.annotation.NonNull android.graphics.Bitmap.Config config) { throw new RuntimeException("Stub!"); }

/**
 * Returns a immutable bitmap with the specified width and height, with each
 * pixel value set to the corresponding value in the colors array.  Its
 * initial density is determined from the given {@link android.util.DisplayMetrics DisplayMetrics}.
 * The newly created bitmap is in the {@link android.graphics.ColorSpace.Named#SRGB ColorSpace.Named#SRGB}
 * color space.
 *
 * @param display  Display metrics for the display this bitmap will be
 *                 drawn on.
 * This value must never be {@code null}.
 * @param colors   Array of sRGB {@link android.graphics.Color Color} used to initialize the pixels.
 * This value must never be {@code null}.
 * @param offset   Number of values to skip before the first color in the
 *                 array of colors.
 * @param stride   Number of colors in the array between rows (must be >=
 *                 width or <= -width).
 * @param width    The width of the bitmap
 * @param height   The height of the bitmap
 * @param config   The bitmap config to create. If the config does not
 *                 support per-pixel alpha (e.g. RGB_565), then the alpha
 *                 bytes in the colors[] will be ignored (assumed to be FF)
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if the width or height are <= 0, or if
 *         the color array's length is less than the number of pixels.
 * @apiSince 17
 */

public static android.graphics.Bitmap createBitmap(@androidx.annotation.NonNull android.util.DisplayMetrics display, @androidx.annotation.NonNull int[] colors, int offset, int stride, int width, int height, @androidx.annotation.NonNull android.graphics.Bitmap.Config config) { throw new RuntimeException("Stub!"); }

/**
 * Returns a immutable bitmap with the specified width and height, with each
 * pixel value set to the corresponding value in the colors array.  Its
 * initial density is as per {@link #getDensity}. The newly created
 * bitmap is in the {@link android.graphics.ColorSpace.Named#SRGB ColorSpace.Named#SRGB} color space.
 *
 * @param colors   Array of sRGB {@link android.graphics.Color Color} used to initialize the pixels.
 *                 This array must be at least as large as width * height.
 * This value must never be {@code null}.
 * @param width    The width of the bitmap
 * @param height   The height of the bitmap
 * @param config   The bitmap config to create. If the config does not
 *                 support per-pixel alpha (e.g. RGB_565), then the alpha
 *                 bytes in the colors[] will be ignored (assumed to be FF)
 * @throws java.lang.IllegalArgumentException if the width or height are <= 0, or if
 *         the color array's length is less than the number of pixels.
 * @apiSince 1
 */

public static android.graphics.Bitmap createBitmap(@androidx.annotation.NonNull int[] colors, int width, int height, android.graphics.Bitmap.Config config) { throw new RuntimeException("Stub!"); }

/**
 * Returns a immutable bitmap with the specified width and height, with each
 * pixel value set to the corresponding value in the colors array.  Its
 * initial density is determined from the given {@link android.util.DisplayMetrics DisplayMetrics}.
 * The newly created bitmap is in the {@link android.graphics.ColorSpace.Named#SRGB ColorSpace.Named#SRGB}
 * color space.
 *
 * @param display  Display metrics for the display this bitmap will be
 *                 drawn on.
 * This value may be {@code null}.
 * @param colors   Array of sRGB {@link android.graphics.Color Color} used to initialize the pixels.
 *                 This array must be at least as large as width * height.
 * This value must never be {@code null}.
 * @param width    The width of the bitmap
 * @param height   The height of the bitmap
 * @param config   The bitmap config to create. If the config does not
 *                 support per-pixel alpha (e.g. RGB_565), then the alpha
 *                 bytes in the colors[] will be ignored (assumed to be FF)
 * This value must never be {@code null}.
 * @throws java.lang.IllegalArgumentException if the width or height are <= 0, or if
 *         the color array's length is less than the number of pixels.
 * @apiSince 17
 */

public static android.graphics.Bitmap createBitmap(@androidx.annotation.Nullable android.util.DisplayMetrics display, @androidx.annotation.NonNull int[] colors, int width, int height, @androidx.annotation.NonNull android.graphics.Bitmap.Config config) { throw new RuntimeException("Stub!"); }

/**
 * Creates a Bitmap from the given {@link android.graphics.Picture Picture} source of recorded drawing commands.
 *
 * Equivalent to calling {@link #createBitmap(android.graphics.Picture,int,int,android.graphics.Bitmap.Config)} with
 * width and height the same as the Picture's width and height and a Config.HARDWARE
 * config.
 *
 * @param source The recorded {@link android.graphics.Picture Picture} of drawing commands that will be
 *               drawn into the returned Bitmap.
 * This value must never be {@code null}.
 * @return An immutable bitmap with a HARDWARE config whose contents are created
 * from the recorded drawing commands in the Picture source.
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public static android.graphics.Bitmap createBitmap(@androidx.annotation.NonNull android.graphics.Picture source) { throw new RuntimeException("Stub!"); }

/**
 * Creates a Bitmap from the given {@link android.graphics.Picture Picture} source of recorded drawing commands.
 *
 * The bitmap will be immutable with the given width and height. If the width and height
 * are not the same as the Picture's width & height, the Picture will be scaled to
 * fit the given width and height.
 *
 * @param source The recorded {@link android.graphics.Picture Picture} of drawing commands that will be
 *               drawn into the returned Bitmap.
 * This value must never be {@code null}.
 * @param width The width of the bitmap to create. The picture's width will be
 *              scaled to match if necessary.
 * @param height The height of the bitmap to create. The picture's height will be
 *              scaled to match if necessary.
 * @param config The {@link android.graphics.Bitmap.Config Config} of the created bitmap.
 *
 * This value must never be {@code null}.
 * @return An immutable bitmap with a configuration specified by the config parameter
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public static android.graphics.Bitmap createBitmap(@androidx.annotation.NonNull android.graphics.Picture source, int width, int height, @androidx.annotation.NonNull android.graphics.Bitmap.Config config) { throw new RuntimeException("Stub!"); }

/**
 * Returns an optional array of private data, used by the UI system for
 * some bitmaps. Not intended to be called by applications.
 * @apiSince 1
 */

public byte[] getNinePatchChunk() { throw new RuntimeException("Stub!"); }

/**
 * Write a compressed version of the bitmap to the specified outputstream.
 * If this returns true, the bitmap can be reconstructed by passing a
 * corresponding inputstream to BitmapFactory.decodeStream(). Note: not
 * all Formats support all bitmap configs directly, so it is possible that
 * the returned bitmap from BitmapFactory could be in a different bitdepth,
 * and/or may have lost per-pixel alpha (e.g. JPEG only supports opaque
 * pixels).
 *
 * <br>
 * This method may take several seconds to complete, so it should
 * only be called from a worker thread.
 * @param format   The format of the compressed image
 * @param quality  Hint to the compressor, 0-100. 0 meaning compress for
 *                 small size, 100 meaning compress for max quality. Some
 *                 formats, like PNG which is lossless, will ignore the
 *                 quality setting
 * @param stream   The outputstream to write the compressed data.
 * @return true if successfully compressed to the specified stream.
 * @apiSince 1
 */

public boolean compress(android.graphics.Bitmap.CompressFormat format, int quality, java.io.OutputStream stream) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the bitmap is marked as mutable (i.e.&nbsp;can be drawn into)
 * @apiSince 1
 */

public boolean isMutable() { throw new RuntimeException("Stub!"); }

/**
 * <p>Indicates whether pixels stored in this bitmaps are stored pre-multiplied.
 * When a pixel is pre-multiplied, the RGB components have been multiplied by
 * the alpha component. For instance, if the original color is a 50%
 * translucent red <code>(128, 255, 0, 0)</code>, the pre-multiplied form is
 * <code>(128, 128, 0, 0)</code>.</p>
 *
 * <p>This method always returns false if {@link #getConfig()} is
 * {@link android.graphics.Bitmap.Config#RGB_565 Bitmap.Config#RGB_565}.</p>
 *
 * <p>The return value is undefined if {@link #getConfig()} is
 * {@link android.graphics.Bitmap.Config#ALPHA_8 Bitmap.Config#ALPHA_8}.</p>
 *
 * <p>This method only returns true if {@link #hasAlpha()} returns true.
 * A bitmap with no alpha channel can be used both as a pre-multiplied and
 * as a non pre-multiplied bitmap.</p>
 *
 * <p>Only pre-multiplied bitmaps may be drawn by the view system or
 * {@link android.graphics.Canvas Canvas}. If a non-pre-multiplied bitmap with an alpha channel is
 * drawn to a Canvas, a RuntimeException will be thrown.</p>
 *
 * @return true if the underlying pixels have been pre-multiplied, false
 *         otherwise
 *
 * @see android.graphics.Bitmap#setPremultiplied(boolean)
 * @see android.graphics.BitmapFactory.Options#inPremultiplied
 * @apiSince 17
 */

public boolean isPremultiplied() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the bitmap should treat its data as pre-multiplied.
 *
 * <p>Bitmaps are always treated as pre-multiplied by the view system and
 * {@link android.graphics.Canvas Canvas} for performance reasons. Storing un-pre-multiplied data in
 * a Bitmap (through {@link #setPixel}, {@link #setPixels}, or {@link android.graphics.BitmapFactory.Options#inPremultiplied BitmapFactory.Options#inPremultiplied})
 * can lead to incorrect blending if drawn by the framework.</p>
 *
 * <p>This method will not affect the behavior of a bitmap without an alpha
 * channel, or if {@link #hasAlpha()} returns false.</p>
 *
 * <p>Calling {@link #createBitmap} or {@link #createScaledBitmap} with a source
 * Bitmap whose colors are not pre-multiplied may result in a RuntimeException,
 * since those functions require drawing the source, which is not supported for
 * un-pre-multiplied Bitmaps.</p>
 *
 * @see android.graphics.Bitmap#isPremultiplied()
 * @see android.graphics.BitmapFactory.Options#inPremultiplied
 * @apiSince 19
 */

public void setPremultiplied(boolean premultiplied) { throw new RuntimeException("Stub!"); }

/**
 * Returns the bitmap's width
 * @apiSince 1
 */

public int getWidth() { throw new RuntimeException("Stub!"); }

/**
 * Returns the bitmap's height
 * @apiSince 1
 */

public int getHeight() { throw new RuntimeException("Stub!"); }

/**
 * Convenience for calling {@link #getScaledWidth(int)} with the target
 * density of the given {@link android.graphics.Canvas Canvas}.
 * @apiSince 4
 */

public int getScaledWidth(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * Convenience for calling {@link #getScaledHeight(int)} with the target
 * density of the given {@link android.graphics.Canvas Canvas}.
 * @apiSince 4
 */

public int getScaledHeight(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * Convenience for calling {@link #getScaledWidth(int)} with the target
 * density of the given {@link android.util.DisplayMetrics DisplayMetrics}.
 * @apiSince 4
 */

public int getScaledWidth(android.util.DisplayMetrics metrics) { throw new RuntimeException("Stub!"); }

/**
 * Convenience for calling {@link #getScaledHeight(int)} with the target
 * density of the given {@link android.util.DisplayMetrics DisplayMetrics}.
 * @apiSince 4
 */

public int getScaledHeight(android.util.DisplayMetrics metrics) { throw new RuntimeException("Stub!"); }

/**
 * Convenience method that returns the width of this bitmap divided
 * by the density scale factor.
 *
 * Returns the bitmap's width multiplied by the ratio of the target density to the bitmap's
 * source density
 *
 * @param targetDensity The density of the target canvas of the bitmap.
 * @return The scaled width of this bitmap, according to the density scale factor.
 * @apiSince 4
 */

public int getScaledWidth(int targetDensity) { throw new RuntimeException("Stub!"); }

/**
 * Convenience method that returns the height of this bitmap divided
 * by the density scale factor.
 *
 * Returns the bitmap's height multiplied by the ratio of the target density to the bitmap's
 * source density
 *
 * @param targetDensity The density of the target canvas of the bitmap.
 * @return The scaled height of this bitmap, according to the density scale factor.
 * @apiSince 4
 */

public int getScaledHeight(int targetDensity) { throw new RuntimeException("Stub!"); }

/**
 * Return the number of bytes between rows in the bitmap's pixels. Note that
 * this refers to the pixels as stored natively by the bitmap. If you call
 * getPixels() or setPixels(), then the pixels are uniformly treated as
 * 32bit values, packed according to the Color class.
 *
 * <p>As of {@link android.os.Build.VERSION_CODES#KITKAT}, this method
 * should not be used to calculate the memory usage of the bitmap. Instead,
 * see {@link #getAllocationByteCount()}.
 *
 * @return number of bytes between rows of the native bitmap pixels.
 * @apiSince 1
 */

public int getRowBytes() { throw new RuntimeException("Stub!"); }

/**
 * Returns the minimum number of bytes that can be used to store this bitmap's pixels.
 *
 * <p>As of {@link android.os.Build.VERSION_CODES#KITKAT}, the result of this method can
 * no longer be used to determine memory usage of a bitmap. See {@link
 * #getAllocationByteCount()}.</p>
 * @apiSince 12
 */

public int getByteCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the size of the allocated memory used to store this bitmap's pixels.
 *
 * <p>This can be larger than the result of {@link #getByteCount()} if a bitmap is reused to
 * decode other bitmaps of smaller size, or by manual reconfiguration. See {@link
 * #reconfigure(int,int,android.graphics.Bitmap.Config)}, {@link #setWidth(int)}, {@link #setHeight(int)}, {@link
 * #setConfig(android.graphics.Bitmap.Config)}, and {@link android.graphics.BitmapFactory.Options#inBitmap BitmapFactory.Options#inBitmap}. If a bitmap is not modified in this way, this value will be
 * the same as that returned by {@link #getByteCount()}.</p>
 *
 * <p>This value will not change over the lifetime of a Bitmap.</p>
 *
 * @see #reconfigure(int, int, Config)
 * @apiSince 19
 */

public int getAllocationByteCount() { throw new RuntimeException("Stub!"); }

/**
 * If the bitmap's internal config is in one of the public formats, return
 * that config, otherwise return null.
 * @apiSince 1
 */

public android.graphics.Bitmap.Config getConfig() { throw new RuntimeException("Stub!"); }

/** Returns true if the bitmap's config supports per-pixel alpha, and
 * if the pixels may contain non-opaque alpha values. For some configs,
 * this is always false (e.g. RGB_565), since they do not support per-pixel
 * alpha. However, for configs that do, the bitmap may be flagged to be
 * known that all of its pixels are opaque. In this case hasAlpha() will
 * also return false. If a config such as ARGB_8888 is not so flagged,
 * it will return true by default.
 * @apiSince 1
 */

public boolean hasAlpha() { throw new RuntimeException("Stub!"); }

/**
 * Tell the bitmap if all of the pixels are known to be opaque (false)
 * or if some of the pixels may contain non-opaque alpha values (true).
 * Note, for some configs (e.g. RGB_565) this call is ignored, since it
 * does not support per-pixel alpha values.
 *
 * This is meant as a drawing hint, as in some cases a bitmap that is known
 * to be opaque can take a faster drawing case than one that may have
 * non-opaque per-pixel alpha values.
 * @apiSince 12
 */

public void setHasAlpha(boolean hasAlpha) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the renderer responsible for drawing this
 * bitmap should attempt to use mipmaps when this bitmap is drawn
 * scaled down.
 *
 * If you know that you are going to draw this bitmap at less than
 * 50% of its original size, you may be able to obtain a higher
 * quality
 *
 * This property is only a suggestion that can be ignored by the
 * renderer. It is not guaranteed to have any effect.
 *
 * @return true if the renderer should attempt to use mipmaps,
 *         false otherwise
 *
 * @see #setHasMipMap(boolean)
 * @apiSince 17
 */

public boolean hasMipMap() { throw new RuntimeException("Stub!"); }

/**
 * Set a hint for the renderer responsible for drawing this bitmap
 * indicating that it should attempt to use mipmaps when this bitmap
 * is drawn scaled down.
 *
 * If you know that you are going to draw this bitmap at less than
 * 50% of its original size, you may be able to obtain a higher
 * quality by turning this property on.
 *
 * Note that if the renderer respects this hint it might have to
 * allocate extra memory to hold the mipmap levels for this bitmap.
 *
 * This property is only a suggestion that can be ignored by the
 * renderer. It is not guaranteed to have any effect.
 *
 * @param hasMipMap indicates whether the renderer should attempt
 *                  to use mipmaps
 *
 * @see #hasMipMap()
 * @apiSince 17
 */

public void setHasMipMap(boolean hasMipMap) { throw new RuntimeException("Stub!"); }

/**
 * Returns the color space associated with this bitmap. If the color
 * space is unknown, this method returns null.
 * @apiSince 26
 */

@androidx.annotation.Nullable
public android.graphics.ColorSpace getColorSpace() { throw new RuntimeException("Stub!"); }

/**
 * <p>Modifies the bitmap to have the specified {@link android.graphics.ColorSpace ColorSpace}, without
 * affecting the underlying allocation backing the bitmap.</p>
 *
 * <p>This affects how the framework will interpret the color at each pixel. A bitmap
 * with {@link android.graphics.Bitmap.Config#ALPHA_8 Config#ALPHA_8} never has a color space, since a color space does not
 * affect the alpha channel. Other {@code Config}s must always have a non-null
 * {@code ColorSpace}.</p>
 *
 * @throws java.lang.IllegalArgumentException If the specified color space is {@code null}, not
 *         {@link android.graphics.ColorSpace.Model#RGB ColorSpace.Model#RGB}, has a transfer function that is not an
 *         {@link android.graphics.ColorSpace.Rgb.TransferParameters ColorSpace.Rgb.TransferParameters}, or whose
 *         components min/max values reduce the numerical range compared to the
 *         previously assigned color space.
 *
 * @throws java.lang.IllegalArgumentException If the {@code Config} (returned by {@link #getConfig()})
 *         is {@link android.graphics.Bitmap.Config#ALPHA_8 Config#ALPHA_8}.
 *
 * @param colorSpace to assign to the bitmap
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void setColorSpace(@androidx.annotation.NonNull android.graphics.ColorSpace colorSpace) { throw new RuntimeException("Stub!"); }

/**
 * Fills the bitmap's pixels with the specified {@link android.graphics.Color Color}.
 *
 * @throws java.lang.IllegalStateException if the bitmap is not mutable.
 * @apiSince 1
 */

public void eraseColor(int c) { throw new RuntimeException("Stub!"); }

/**
 * Fills the bitmap's pixels with the specified {@code ColorLong}.
 *
 * @param color The color to fill as packed by the {@link android.graphics.Color Color} class.
 * @throws java.lang.IllegalStateException if the bitmap is not mutable.
 * @throws java.lang.IllegalArgumentException if the color space encoded in the
 *                                  {@code ColorLong} is invalid or unknown.
 *
 * @apiSince 29
 */

public void eraseColor(long color) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.graphics.Color Color} at the specified location. Throws an exception
 * if x or y are out of bounds (negative or >= to the width or height
 * respectively). The returned color is a non-premultiplied ARGB value in
 * the {@link android.graphics.ColorSpace.Named#SRGB ColorSpace.Named#SRGB} color space.
 *
 * @param x    The x coordinate (0...width-1) of the pixel to return
 * @param y    The y coordinate (0...height-1) of the pixel to return
 * @return     The argb {@link android.graphics.Color Color} at the specified coordinate
 * @throws java.lang.IllegalArgumentException if x, y exceed the bitmap's bounds
 * @throws java.lang.IllegalStateException if the bitmap's config is {@link android.graphics.Bitmap.Config#HARDWARE Config#HARDWARE}
 * @apiSince 1
 */

public int getPixel(int x, int y) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link android.graphics.Color Color} at the specified location. Throws an exception
 * if x or y are out of bounds (negative or >= to the width or height
 * respectively).
 *
 * @param x    The x coordinate (0...width-1) of the pixel to return
 * @param y    The y coordinate (0...height-1) of the pixel to return
 * @return     The {@link android.graphics.Color Color} at the specified coordinate
 * This value will never be {@code null}.
 * @throws java.lang.IllegalArgumentException if x, y exceed the bitmap's bounds
 * @throws java.lang.IllegalStateException if the bitmap's config is {@link android.graphics.Bitmap.Config#HARDWARE Config#HARDWARE}
 *
 * @apiSince 29
 */

@androidx.annotation.NonNull
public android.graphics.Color getColor(int x, int y) { throw new RuntimeException("Stub!"); }

/**
 * Returns in pixels[] a copy of the data in the bitmap. Each value is
 * a packed int representing a {@link android.graphics.Color Color}. The stride parameter allows
 * the caller to allow for gaps in the returned pixels array between
 * rows. For normal packed results, just pass width for the stride value.
 * The returned colors are non-premultiplied ARGB values in the
 * {@link android.graphics.ColorSpace.Named#SRGB ColorSpace.Named#SRGB} color space.
 *
 * @param pixels   The array to receive the bitmap's colors
 * @param offset   The first index to write into pixels[]
 * @param stride   The number of entries in pixels[] to skip between
 *                 rows (must be >= bitmap's width). Can be negative.
 * @param x        The x coordinate of the first pixel to read from
 *                 the bitmap
 * @param y        The y coordinate of the first pixel to read from
 *                 the bitmap
 * @param width    The number of pixels to read from each row
 * @param height   The number of rows to read
 *
 * @throws java.lang.IllegalArgumentException if x, y, width, height exceed the
 *         bounds of the bitmap, or if abs(stride) < width.
 * @throws java.lang.ArrayIndexOutOfBoundsException if the pixels array is too small
 *         to receive the specified number of pixels.
 * @throws java.lang.IllegalStateException if the bitmap's config is {@link android.graphics.Bitmap.Config#HARDWARE Config#HARDWARE}
 * @apiSince 1
 */

public void getPixels(int[] pixels, int offset, int stride, int x, int y, int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * <p>Write the specified {@link android.graphics.Color Color} into the bitmap (assuming it is
 * mutable) at the x,y coordinate. The color must be a
 * non-premultiplied ARGB value in the {@link android.graphics.ColorSpace.Named#SRGB ColorSpace.Named#SRGB}
 * color space.</p>
 *
 * @param x     The x coordinate of the pixel to replace (0...width-1)
 * @param y     The y coordinate of the pixel to replace (0...height-1)
 * @param color The ARGB color to write into the bitmap
 *
 * @throws java.lang.IllegalStateException if the bitmap is not mutable
 * @throws java.lang.IllegalArgumentException if x, y are outside of the bitmap's
 *         bounds.
 * @apiSince 1
 */

public void setPixel(int x, int y, int color) { throw new RuntimeException("Stub!"); }

/**
 * <p>Replace pixels in the bitmap with the colors in the array. Each element
 * in the array is a packed int representing a non-premultiplied ARGB
 * {@link android.graphics.Color Color} in the {@link android.graphics.ColorSpace.Named#SRGB ColorSpace.Named#SRGB} color space.</p>
 *
 * @param pixels   The colors to write to the bitmap
 * @param offset   The index of the first color to read from pixels[]
 * @param stride   The number of colors in pixels[] to skip between rows.
 *                 Normally this value will be the same as the width of
 *                 the bitmap, but it can be larger (or negative).
 * @param x        The x coordinate of the first pixel to write to in
 *                 the bitmap.
 * @param y        The y coordinate of the first pixel to write to in
 *                 the bitmap.
 * @param width    The number of colors to copy from pixels[] per row
 * @param height   The number of rows to write to the bitmap
 *
 * @throws java.lang.IllegalStateException if the bitmap is not mutable
 * @throws java.lang.IllegalArgumentException if x, y, width, height are outside of
 *         the bitmap's bounds.
 * @throws java.lang.ArrayIndexOutOfBoundsException if the pixels array is too small
 *         to receive the specified number of pixels.
 * @apiSince 1
 */

public void setPixels(int[] pixels, int offset, int stride, int x, int y, int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * No special parcel contents.
 * @apiSince 1
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Write the bitmap and its pixels to the parcel. The bitmap can be
 * rebuilt from the parcel by calling CREATOR.createFromParcel().
 *
 * If this bitmap is {@link android.graphics.Bitmap.Config#HARDWARE Config#HARDWARE}, it may be unparceled with a different pixel
 * format (e.g. 565, 8888), but the content will be preserved to the best quality permitted
 * by the final pixel format
 * @param p    Parcel object to write the bitmap data into
 * @apiSince 1
 */

public void writeToParcel(android.os.Parcel p, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new bitmap that captures the alpha values of the original.
 * This may be drawn with Canvas.drawBitmap(), where the color(s) will be
 * taken from the paint that is passed to the draw call.
 *
 * @return new bitmap containing the alpha channel of the original bitmap.
 * @apiSince 1
 */

public android.graphics.Bitmap extractAlpha() { throw new RuntimeException("Stub!"); }

/**
 * Returns a new bitmap that captures the alpha values of the original.
 * These values may be affected by the optional Paint parameter, which
 * can contain its own alpha, and may also contain a MaskFilter which
 * could change the actual dimensions of the resulting bitmap (e.g.
 * a blur maskfilter might enlarge the resulting bitmap). If offsetXY
 * is not null, it returns the amount to offset the returned bitmap so
 * that it will logically align with the original. For example, if the
 * paint contains a blur of radius 2, then offsetXY[] would contains
 * -2, -2, so that drawing the alpha bitmap offset by (-2, -2) and then
 * drawing the original would result in the blur visually aligning with
 * the original.
 *
 * <p>The initial density of the returned bitmap is the same as the original's.
 *
 * @param paint Optional paint used to modify the alpha values in the
 *              resulting bitmap. Pass null for default behavior.
 * @param offsetXY Optional array that returns the X (index 0) and Y
 *                 (index 1) offset needed to position the returned bitmap
 *                 so that it visually lines up with the original.
 * @return new bitmap containing the (optionally modified by paint) alpha
 *         channel of the original bitmap. This may be drawn with
 *         Canvas.drawBitmap(), where the color(s) will be taken from the
 *         paint that is passed to the draw call.
 * @apiSince 1
 */

public android.graphics.Bitmap extractAlpha(android.graphics.Paint paint, int[] offsetXY) { throw new RuntimeException("Stub!"); }

/**
 *  Given another bitmap, return true if it has the same dimensions, config,
 *  and pixel data as this bitmap. If any of those differ, return false.
 *  If other is null, return false.
 * @apiSince 12
 */

public boolean sameAs(android.graphics.Bitmap other) { throw new RuntimeException("Stub!"); }

/**
 * Builds caches associated with the bitmap that are used for drawing it.
 *
 * <p>Starting in {@link android.os.Build.VERSION_CODES#N}, this call initiates an asynchronous
 * upload to the GPU on RenderThread, if the Bitmap is not already uploaded. With Hardware
 * Acceleration, Bitmaps must be uploaded to the GPU in order to be rendered. This is done by
 * default the first time a Bitmap is drawn, but the process can take several milliseconds,
 * depending on the size of the Bitmap. Each time a Bitmap is modified and drawn again, it must
 * be re-uploaded.</p>
 *
 * <p>Calling this method in advance can save time in the first frame it's used. For example, it
 * is recommended to call this on an image decoding worker thread when a decoded Bitmap is about
 * to be displayed. It is recommended to make any pre-draw modifications to the Bitmap before
 * calling this method, so the cached, uploaded copy may be reused without re-uploading.</p>
 *
 * In {@link android.os.Build.VERSION_CODES#KITKAT} and below, for purgeable bitmaps, this call
 * would attempt to ensure that the pixels have been decoded.
 * @apiSince 4
 */

public void prepareToDraw() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.graphics.Bitmap> CREATOR;
static { CREATOR = null; }

/**
 * Indicates that the bitmap was created for an unknown pixel density.
 *
 * @see android.graphics.Bitmap#getDensity()
 * @see android.graphics.Bitmap#setDensity(int)
 * @apiSince 4
 */

public static final int DENSITY_NONE = 0; // 0x0
/**
 * Specifies the known formats a bitmap can be compressed into
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum CompressFormat {
/** @apiSince 1 */

JPEG,
/** @apiSince 1 */

PNG,
/** @apiSince 14 */

WEBP;
}

/**
 * Possible bitmap configurations. A bitmap configuration describes
 * how pixels are stored. This affects the quality (color depth) as
 * well as the ability to display transparent/translucent colors.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum Config {
/**
 * Each pixel is stored as a single translucency (alpha) channel.
 * This is very useful to efficiently store masks for instance.
 * No color information is stored.
 * With this configuration, each pixel requires 1 byte of memory.
 * @apiSince 1
 */

ALPHA_8,
/**
 * Each pixel is stored on 2 bytes and only the RGB channels are
 * encoded: red is stored with 5 bits of precision (32 possible
 * values), green is stored with 6 bits of precision (64 possible
 * values) and blue is stored with 5 bits of precision.
 *
 * This configuration can produce slight visual artifacts depending
 * on the configuration of the source. For instance, without
 * dithering, the result might show a greenish tint. To get better
 * results dithering should be applied.
 *
 * This configuration may be useful when using opaque bitmaps
 * that do not require high color fidelity.
 *
 * <p>Use this formula to pack into 16 bits:</p>
 * <pre class="prettyprint">
 * short color = (R & 0x1f) << 11 | (G & 0x3f) << 5 | (B & 0x1f);
 * </pre>
 * @apiSince 1
 */

RGB_565,
/**
 * Each pixel is stored on 2 bytes. The three RGB color channels
 * and the alpha channel (translucency) are stored with a 4 bits
 * precision (16 possible values.)
 *
 * This configuration is mostly useful if the application needs
 * to store translucency information but also needs to save
 * memory.
 *
 * It is recommended to use {@link #ARGB_8888} instead of this
 * configuration.
 *
 * Note: as of {@link android.os.Build.VERSION_CODES#KITKAT},
 * any bitmap created with this configuration will be created
 * using {@link #ARGB_8888} instead.
 *
 * @deprecated Because of the poor quality of this configuration,
 *             it is advised to use {@link #ARGB_8888} instead.
 * @apiSince 1
 * @deprecatedSince 29
 */

@Deprecated
ARGB_4444,
/**
 * Each pixel is stored on 4 bytes. Each channel (RGB and alpha
 * for translucency) is stored with 8 bits of precision (256
 * possible values.)
 *
 * This configuration is very flexible and offers the best
 * quality. It should be used whenever possible.
 *
 * <p>Use this formula to pack into 32 bits:</p>
 * <pre class="prettyprint">
 * int color = (A & 0xff) << 24 | (B & 0xff) << 16 | (G & 0xff) << 8 | (R & 0xff);
 * </pre>
 * @apiSince 1
 */

ARGB_8888,
/**
 * Each pixels is stored on 8 bytes. Each channel (RGB and alpha
 * for translucency) is stored as a
 * {@link android.util.Half half-precision floating point value}.
 *
 * This configuration is particularly suited for wide-gamut and
 * HDR content.
 *
 * <p>Use this formula to pack into 64 bits:</p>
 * <pre class="prettyprint">
 * long color = (A & 0xffff) << 48 | (B & 0xffff) << 32 | (G & 0xffff) << 16 | (R & 0xffff);
 * </pre>
 * @apiSince 26
 */

RGBA_F16,
/**
 * Special configuration, when bitmap is stored only in graphic memory.
 * Bitmaps in this configuration are always immutable.
 *
 * It is optimal for cases, when the only operation with the bitmap is to draw it on a
 * screen.
 * @apiSince 26
 */

HARDWARE;
}

}

