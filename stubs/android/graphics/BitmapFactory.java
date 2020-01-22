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


package android.graphics;

import java.io.InputStream;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * Creates Bitmap objects from various sources, including files, streams,
 * and byte-arrays.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class BitmapFactory {

public BitmapFactory() { throw new RuntimeException("Stub!"); }

/**
 * Decode a file path into a bitmap. If the specified file name is null,
 * or cannot be decoded into a bitmap, the function returns null.
 *
 * @param pathName complete path name for the file to be decoded.
 * @param opts null-ok; Options that control downsampling and whether the
 *             image should be completely decoded, or just is size returned.
 * @return The decoded bitmap, or null if the image data could not be
 *         decoded, or, if opts is non-null, if opts requested only the
 *         size be returned (in opts.outWidth and opts.outHeight)
 * @throws java.lang.IllegalArgumentException if {@link android.graphics.BitmapFactory.Options#inPreferredConfig BitmapFactory.Options#inPreferredConfig}
 *         is {@link android.graphics.Bitmap.Config#HARDWARE}
 *         and {@link android.graphics.BitmapFactory.Options#inMutable BitmapFactory.Options#inMutable} is set, if the specified color space
 *         is not {@link android.graphics.ColorSpace.Model#RGB ColorSpace.Model#RGB}, or if the specified color space's transfer
 *         function is not an {@link android.graphics.ColorSpace.Rgb.TransferParameters ColorSpace.Rgb.TransferParameters}
 * @apiSince 1
 */

public static android.graphics.Bitmap decodeFile(java.lang.String pathName, android.graphics.BitmapFactory.Options opts) { throw new RuntimeException("Stub!"); }

/**
 * Decode a file path into a bitmap. If the specified file name is null,
 * or cannot be decoded into a bitmap, the function returns null.
 *
 * @param pathName complete path name for the file to be decoded.
 * @return the resulting decoded bitmap, or null if it could not be decoded.
 * @apiSince 1
 */

public static android.graphics.Bitmap decodeFile(java.lang.String pathName) { throw new RuntimeException("Stub!"); }

/**
 * Decode a new Bitmap from an InputStream. This InputStream was obtained from
 * resources, which we pass to be able to scale the bitmap accordingly.
 * @throws java.lang.IllegalArgumentException if {@link android.graphics.BitmapFactory.Options#inPreferredConfig BitmapFactory.Options#inPreferredConfig}
 *         is {@link android.graphics.Bitmap.Config#HARDWARE}
 *         and {@link android.graphics.BitmapFactory.Options#inMutable BitmapFactory.Options#inMutable} is set, if the specified color space
 *         is not {@link android.graphics.ColorSpace.Model#RGB ColorSpace.Model#RGB}, or if the specified color space's transfer
 *         function is not an {@link android.graphics.ColorSpace.Rgb.TransferParameters ColorSpace.Rgb.TransferParameters}
 
 * @param res This value may be {@code null}.
 * @param value This value may be {@code null}.
 * @param is This value may be {@code null}.
 * @param pad This value may be {@code null}.
 * @param opts This value may be {@code null}.
 * @return This value may be {@code null}.
 * @apiSince 4
 */

@androidx.annotation.Nullable
public static android.graphics.Bitmap decodeResourceStream(@androidx.annotation.Nullable android.content.res.Resources res, @androidx.annotation.Nullable android.util.TypedValue value, @androidx.annotation.Nullable java.io.InputStream is, @androidx.annotation.Nullable android.graphics.Rect pad, @androidx.annotation.Nullable android.graphics.BitmapFactory.Options opts) { throw new RuntimeException("Stub!"); }

/**
 * Synonym for opening the given resource and calling
 * {@link #decodeResourceStream}.
 *
 * @param res   The resources object containing the image data
 * @param id The resource id of the image data
 * @param opts null-ok; Options that control downsampling and whether the
 *             image should be completely decoded, or just is size returned.
 * @return The decoded bitmap, or null if the image data could not be
 *         decoded, or, if opts is non-null, if opts requested only the
 *         size be returned (in opts.outWidth and opts.outHeight)
 * @throws java.lang.IllegalArgumentException if {@link android.graphics.BitmapFactory.Options#inPreferredConfig BitmapFactory.Options#inPreferredConfig}
 *         is {@link android.graphics.Bitmap.Config#HARDWARE}
 *         and {@link android.graphics.BitmapFactory.Options#inMutable BitmapFactory.Options#inMutable} is set, if the specified color space
 *         is not {@link android.graphics.ColorSpace.Model#RGB ColorSpace.Model#RGB}, or if the specified color space's transfer
 *         function is not an {@link android.graphics.ColorSpace.Rgb.TransferParameters ColorSpace.Rgb.TransferParameters}
 * @apiSince 1
 */

public static android.graphics.Bitmap decodeResource(android.content.res.Resources res, int id, android.graphics.BitmapFactory.Options opts) { throw new RuntimeException("Stub!"); }

/**
 * Synonym for {@link #decodeResource(android.content.res.Resources,int,android.graphics.BitmapFactory.Options)}
 * with null Options.
 *
 * @param res The resources object containing the image data
 * @param id The resource id of the image data
 * @return The decoded bitmap, or null if the image could not be decoded.
 * @apiSince 1
 */

public static android.graphics.Bitmap decodeResource(android.content.res.Resources res, int id) { throw new RuntimeException("Stub!"); }

/**
 * Decode an immutable bitmap from the specified byte array.
 *
 * @param data byte array of compressed image data
 * @param offset offset into imageData for where the decoder should begin
 *               parsing.
 * @param length the number of bytes, beginning at offset, to parse
 * @param opts null-ok; Options that control downsampling and whether the
 *             image should be completely decoded, or just is size returned.
 * @return The decoded bitmap, or null if the image data could not be
 *         decoded, or, if opts is non-null, if opts requested only the
 *         size be returned (in opts.outWidth and opts.outHeight)
 * @throws java.lang.IllegalArgumentException if {@link android.graphics.BitmapFactory.Options#inPreferredConfig BitmapFactory.Options#inPreferredConfig}
 *         is {@link android.graphics.Bitmap.Config#HARDWARE}
 *         and {@link android.graphics.BitmapFactory.Options#inMutable BitmapFactory.Options#inMutable} is set, if the specified color space
 *         is not {@link android.graphics.ColorSpace.Model#RGB ColorSpace.Model#RGB}, or if the specified color space's transfer
 *         function is not an {@link android.graphics.ColorSpace.Rgb.TransferParameters ColorSpace.Rgb.TransferParameters}
 * @apiSince 1
 */

public static android.graphics.Bitmap decodeByteArray(byte[] data, int offset, int length, android.graphics.BitmapFactory.Options opts) { throw new RuntimeException("Stub!"); }

/**
 * Decode an immutable bitmap from the specified byte array.
 *
 * @param data byte array of compressed image data
 * @param offset offset into imageData for where the decoder should begin
 *               parsing.
 * @param length the number of bytes, beginning at offset, to parse
 * @return The decoded bitmap, or null if the image could not be decoded.
 * @apiSince 1
 */

public static android.graphics.Bitmap decodeByteArray(byte[] data, int offset, int length) { throw new RuntimeException("Stub!"); }

/**
 * Decode an input stream into a bitmap. If the input stream is null, or
 * cannot be used to decode a bitmap, the function returns null.
 * The stream's position will be where ever it was after the encoded data
 * was read.
 *
 * @param is The input stream that holds the raw data to be decoded into a
 *           bitmap.
 * This value may be {@code null}.
 * @param outPadding If not null, return the padding rect for the bitmap if
 *                   it exists, otherwise set padding to [-1,-1,-1,-1]. If
 *                   no bitmap is returned (null) then padding is
 *                   unchanged.
 * This value may be {@code null}.
 * @param opts null-ok; Options that control downsampling and whether the
 *             image should be completely decoded, or just is size returned.
 * This value may be {@code null}.
 * @return The decoded bitmap, or null if the image data could not be
 *         decoded, or, if opts is non-null, if opts requested only the
 *         size be returned (in opts.outWidth and opts.outHeight)
 * @throws java.lang.IllegalArgumentException if {@link android.graphics.BitmapFactory.Options#inPreferredConfig BitmapFactory.Options#inPreferredConfig}
 *         is {@link android.graphics.Bitmap.Config#HARDWARE}
 *         and {@link android.graphics.BitmapFactory.Options#inMutable BitmapFactory.Options#inMutable} is set, if the specified color space
 *         is not {@link android.graphics.ColorSpace.Model#RGB ColorSpace.Model#RGB}, or if the specified color space's transfer
 *         function is not an {@link android.graphics.ColorSpace.Rgb.TransferParameters ColorSpace.Rgb.TransferParameters}
 *
 * <p class="note">Prior to {@link android.os.Build.VERSION_CODES#KITKAT},
 * if {@link java.io.InputStream#markSupported InputStream#markSupported} returns true,
 * <code>is.mark(1024)</code> would be called. As of
 * {@link android.os.Build.VERSION_CODES#KITKAT}, this is no longer the case.</p>
 * @apiSince 1
 */

@androidx.annotation.Nullable
public static android.graphics.Bitmap decodeStream(@androidx.annotation.Nullable java.io.InputStream is, @androidx.annotation.Nullable android.graphics.Rect outPadding, @androidx.annotation.Nullable android.graphics.BitmapFactory.Options opts) { throw new RuntimeException("Stub!"); }

/**
 * Decode an input stream into a bitmap. If the input stream is null, or
 * cannot be used to decode a bitmap, the function returns null.
 * The stream's position will be where ever it was after the encoded data
 * was read.
 *
 * @param is The input stream that holds the raw data to be decoded into a
 *           bitmap.
 * @return The decoded bitmap, or null if the image data could not be decoded.
 * @apiSince 1
 */

public static android.graphics.Bitmap decodeStream(java.io.InputStream is) { throw new RuntimeException("Stub!"); }

/**
 * Decode a bitmap from the file descriptor. If the bitmap cannot be decoded
 * return null. The position within the descriptor will not be changed when
 * this returns, so the descriptor can be used again as-is.
 *
 * @param fd The file descriptor containing the bitmap data to decode
 * @param outPadding If not null, return the padding rect for the bitmap if
 *                   it exists, otherwise set padding to [-1,-1,-1,-1]. If
 *                   no bitmap is returned (null) then padding is
 *                   unchanged.
 * @param opts null-ok; Options that control downsampling and whether the
 *             image should be completely decoded, or just its size returned.
 * @return the decoded bitmap, or null
 * @throws java.lang.IllegalArgumentException if {@link android.graphics.BitmapFactory.Options#inPreferredConfig BitmapFactory.Options#inPreferredConfig}
 *         is {@link android.graphics.Bitmap.Config#HARDWARE}
 *         and {@link android.graphics.BitmapFactory.Options#inMutable BitmapFactory.Options#inMutable} is set, if the specified color space
 *         is not {@link android.graphics.ColorSpace.Model#RGB ColorSpace.Model#RGB}, or if the specified color space's transfer
 *         function is not an {@link android.graphics.ColorSpace.Rgb.TransferParameters ColorSpace.Rgb.TransferParameters}
 * @apiSince 1
 */

public static android.graphics.Bitmap decodeFileDescriptor(java.io.FileDescriptor fd, android.graphics.Rect outPadding, android.graphics.BitmapFactory.Options opts) { throw new RuntimeException("Stub!"); }

/**
 * Decode a bitmap from the file descriptor. If the bitmap cannot be decoded
 * return null. The position within the descriptor will not be changed when
 * this returns, so the descriptor can be used again as is.
 *
 * @param fd The file descriptor containing the bitmap data to decode
 * @return the decoded bitmap, or null
 * @apiSince 1
 */

public static android.graphics.Bitmap decodeFileDescriptor(java.io.FileDescriptor fd) { throw new RuntimeException("Stub!"); }
/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Options {

/**
 * Create a default Options object, which if left unchanged will give
 * the same result from the decoder as if null were passed.
 * @apiSince 1
 */

public Options() { throw new RuntimeException("Stub!"); }

/**
 *  @deprecated As of {@link android.os.Build.VERSION_CODES#N}, this
 *  will not affect the decode, though it will still set mCancel.
 *
 *  In {@link android.os.Build.VERSION_CODES#M} and below, if this can
 *  be called from another thread while this options object is inside
 *  a decode... call. Calling this will notify the decoder that it
 *  should cancel its operation. This is not guaranteed to cancel the
 *  decode, but if it does, the decoder... operation will return null,
 *  or if inJustDecodeBounds is true, will set outWidth/outHeight
 *  to -1
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public void requestCancelDecode() { throw new RuntimeException("Stub!"); }

/**
 * If set, decode methods that take the Options object will attempt to
 * reuse this bitmap when loading content. If the decode operation
 * cannot use this bitmap, the decode method will throw an
 * {@link java.lang.IllegalArgumentException}. The
 * current implementation necessitates that the reused bitmap be
 * mutable, and the resulting reused bitmap will continue to remain
 * mutable even when decoding a resource which would normally result in
 * an immutable bitmap.</p>
 *
 * <p>You should still always use the returned Bitmap of the decode
 * method and not assume that reusing the bitmap worked, due to the
 * constraints outlined above and failure situations that can occur.
 * Checking whether the return value matches the value of the inBitmap
 * set in the Options structure will indicate if the bitmap was reused,
 * but in all cases you should use the Bitmap returned by the decoding
 * function to ensure that you are using the bitmap that was used as the
 * decode destination.</p>
 *
 * <h3>Usage with BitmapFactory</h3>
 *
 * <p>As of {@link android.os.Build.VERSION_CODES#KITKAT}, any
 * mutable bitmap can be reused by {@link android.graphics.BitmapFactory BitmapFactory} to decode any
 * other bitmaps as long as the resulting {@link android.graphics.Bitmap#getByteCount() Bitmap#getByteCount()} of the decoded bitmap is less than or equal to the {@link android.graphics.Bitmap#getAllocationByteCount() Bitmap#getAllocationByteCount()} of the reused
 * bitmap. This can be because the intrinsic size is smaller, or its
 * size post scaling (for density / sample size) is smaller.</p>
 *
 * <p class="note">Prior to {@link android.os.Build.VERSION_CODES#KITKAT}
 * additional constraints apply: The image being decoded (whether as a
 * resource or as a stream) must be in jpeg or png format. Only equal
 * sized bitmaps are supported, with {@link #inSampleSize} set to 1.
 * Additionally, the {@link android.graphics.Bitmap.Config
 * configuration} of the reused bitmap will override the setting of
 * {@link #inPreferredConfig}, if set.</p>
 *
 * <h3>Usage with BitmapRegionDecoder</h3>
 *
 * <p>BitmapRegionDecoder will draw its requested content into the Bitmap
 * provided, clipping if the output content size (post scaling) is larger
 * than the provided Bitmap. The provided Bitmap's width, height, and
 * {@link android.graphics.Bitmap.Config Bitmap.Config} will not be changed.
 *
 * <p class="note">BitmapRegionDecoder support for {@link #inBitmap} was
 * introduced in {@link android.os.Build.VERSION_CODES#JELLY_BEAN}. All
 * formats supported by BitmapRegionDecoder support Bitmap reuse via
 * {@link #inBitmap}.</p>
 *
 * @see android.graphics.Bitmap#reconfigure(int,int, android.graphics.Bitmap.Config)
 * @apiSince 11
 */

public android.graphics.Bitmap inBitmap;

/**
 * The pixel density to use for the bitmap.  This will always result
 * in the returned bitmap having a density set for it (see
 * {@link android.graphics.Bitmap#setDensity(int) Bitmap#setDensity(int)}).  In addition,
 * if {@link #inScaled} is set (which it is by default} and this
 * density does not match {@link #inTargetDensity}, then the bitmap
 * will be scaled to the target density before being returned.
 *
 * <p>If this is 0,
 * {@link android.graphics.BitmapFactory#decodeResource(android.content.res.Resources,int) BitmapFactory#decodeResource(Resources, int)},
 * {@link android.graphics.BitmapFactory#decodeResource(android.content.res.Resources,int,android.graphics.BitmapFactory.Options) BitmapFactory#decodeResource(Resources, int, android.graphics.BitmapFactory.Options)},
 * and {@link android.graphics.BitmapFactory#decodeResourceStream BitmapFactory#decodeResourceStream}
 * will fill in the density associated with the resource.  The other
 * functions will leave it as-is and no density will be applied.
 *
 * @see #inTargetDensity
 * @see #inScreenDensity
 * @see #inScaled
 * @see android.graphics.Bitmap#setDensity(int)
 * @see android.util.DisplayMetrics#densityDpi
 * @apiSince 4
 */

public int inDensity;

/**
 * @deprecated As of {@link android.os.Build.VERSION_CODES#N}, this is
 * ignored.
 *
 * In {@link android.os.Build.VERSION_CODES#M} and below, if dither is
 * true, the decoder will attempt to dither the decoded image.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated public boolean inDither;

/**
 * @deprecated As of {@link android.os.Build.VERSION_CODES#LOLLIPOP}, this is
 * ignored.
 *
 * In {@link android.os.Build.VERSION_CODES#KITKAT} and below, this
 * field works in conjuction with inPurgeable. If inPurgeable is false,
 * then this field is ignored. If inPurgeable is true, then this field
 * determines whether the bitmap can share a reference to the input
 * data (inputstream, array, etc.) or if it must make a deep copy.
 * @apiSince 4
 * @deprecatedSince 21
 */

@Deprecated public boolean inInputShareable;

/**
 * If set to true, the decoder will return null (no bitmap), but
 * the <code>out...</code> fields will still be set, allowing the caller to
 * query the bitmap without having to allocate the memory for its pixels.
 * @apiSince 1
 */

public boolean inJustDecodeBounds;

/**
 * If set, decode methods will always return a mutable Bitmap instead of
 * an immutable one. This can be used for instance to programmatically apply
 * effects to a Bitmap loaded through BitmapFactory.
 * <p>Can not be set simultaneously with inPreferredConfig =
 * {@link android.graphics.Bitmap.Config#HARDWARE},
 * because hardware bitmaps are always immutable.
 * @apiSince 11
 */

public boolean inMutable;

/**
 * @deprecated As of {@link android.os.Build.VERSION_CODES#N}, this is
 * ignored.  The output will always be high quality.
 *
 * In {@link android.os.Build.VERSION_CODES#M} and below, if
 * inPreferQualityOverSpeed is set to true, the decoder will try to
 * decode the reconstructed image to a higher quality even at the
 * expense of the decoding speed. Currently the field only affects JPEG
 * decode, in the case of which a more accurate, but slightly slower,
 * IDCT method will be used instead.
 * @apiSince 10
 * @deprecatedSince 24
 */

@Deprecated public boolean inPreferQualityOverSpeed;

/**
 * <p>If this is non-null, the decoder will try to decode into this
 * color space. If it is null, or the request cannot be met,
 * the decoder will pick either the color space embedded in the image
 * or the color space best suited for the requested image configuration
 * (for instance {@link android.graphics.ColorSpace.Named#SRGB ColorSpace.Named#SRGB} for
 * {@link android.graphics.Bitmap.Config#ARGB_8888 Bitmap.Config#ARGB_8888} configuration and
 * {@link android.graphics.ColorSpace.Named#EXTENDED_SRGB ColorSpace.Named#EXTENDED_SRGB} for
 * {@link android.graphics.Bitmap.Config#RGBA_F16 Bitmap.Config#RGBA_F16}).</p>
 *
 * <p class="note">Only {@link android.graphics.ColorSpace.Model#RGB ColorSpace.Model#RGB} color spaces are
 * currently supported. An <code>IllegalArgumentException</code> will
 * be thrown by the decode methods when setting a non-RGB color space
 * such as {@link android.graphics.ColorSpace.Named#CIE_LAB ColorSpace.Named#CIE_LAB}.</p>
 *
 * <p class="note">The specified color space's transfer function must be
 * an {@link android.graphics.ColorSpace.Rgb.TransferParameters ColorSpace.Rgb.TransferParameters}. An
 * <code>IllegalArgumentException</code> will be thrown by the decode methods
 * if calling {@link android.graphics.ColorSpace.Rgb#getTransferParameters() ColorSpace.Rgb#getTransferParameters()} on the
 * specified color space returns null.</p>
 *
 * <p>After decode, the bitmap's color space is stored in
 * {@link #outColorSpace}.</p>
 * @apiSince 26
 */

public android.graphics.ColorSpace inPreferredColorSpace;

/**
 * If this is non-null, the decoder will try to decode into this
 * internal configuration. If it is null, or the request cannot be met,
 * the decoder will try to pick the best matching config based on the
 * system's screen depth, and characteristics of the original image such
 * as if it has per-pixel alpha (requiring a config that also does).
 *
 * Image are loaded with the {@link android.graphics.Bitmap.Config#ARGB_8888 Bitmap.Config#ARGB_8888} config by
 * default.
 * @apiSince 1
 */

public android.graphics.Bitmap.Config inPreferredConfig;

/**
 * If true (which is the default), the resulting bitmap will have its
 * color channels pre-multipled by the alpha channel.
 *
 * <p>This should NOT be set to false for images to be directly drawn by
 * the view system or through a {@link android.graphics.Canvas Canvas}. The view system and
 * {@link android.graphics.Canvas Canvas} assume all drawn images are pre-multiplied to simplify
 * draw-time blending, and will throw a RuntimeException when
 * un-premultiplied are drawn.</p>
 *
 * <p>This is likely only useful if you want to manipulate raw encoded
 * image data, e.g. with RenderScript or custom OpenGL.</p>
 *
 * <p>This does not affect bitmaps without an alpha channel.</p>
 *
 * <p>Setting this flag to false while setting {@link #inScaled} to true
 * may result in incorrect colors.</p>
 *
 * @see android.graphics.Bitmap#hasAlpha()
 * @see android.graphics.Bitmap#isPremultiplied()
 * @see #inScaled
 * @apiSince 19
 */

public boolean inPremultiplied;

/**
 * @deprecated As of {@link android.os.Build.VERSION_CODES#LOLLIPOP}, this is
 * ignored.
 *
 * In {@link android.os.Build.VERSION_CODES#KITKAT} and below, if this
 * is set to true, then the resulting bitmap will allocate its
 * pixels such that they can be purged if the system needs to reclaim
 * memory. In that instance, when the pixels need to be accessed again
 * (e.g. the bitmap is drawn, getPixels() is called), they will be
 * automatically re-decoded.
 *
 * <p>For the re-decode to happen, the bitmap must have access to the
 * encoded data, either by sharing a reference to the input
 * or by making a copy of it. This distinction is controlled by
 * inInputShareable. If this is true, then the bitmap may keep a shallow
 * reference to the input. If this is false, then the bitmap will
 * explicitly make a copy of the input data, and keep that. Even if
 * sharing is allowed, the implementation may still decide to make a
 * deep copy of the input data.</p>
 *
 * <p>While inPurgeable can help avoid big Dalvik heap allocations (from
 * API level 11 onward), it sacrifices performance predictability since any
 * image that the view system tries to draw may incur a decode delay which
 * can lead to dropped frames. Therefore, most apps should avoid using
 * inPurgeable to allow for a fast and fluid UI. To minimize Dalvik heap
 * allocations use the {@link #inBitmap} flag instead.</p>
 *
 * <p class="note"><strong>Note:</strong> This flag is ignored when used
 * with {@link #decodeResource(android.content.res.Resources,int,android.graphics.BitmapFactory.Options)} or {@link #decodeFile(java.lang.String,android.graphics.BitmapFactory.Options)}.</p>
 * @apiSince 4
 * @deprecatedSince 21
 */

@Deprecated public boolean inPurgeable;

/**
 * If set to a value > 1, requests the decoder to subsample the original
 * image, returning a smaller image to save memory. The sample size is
 * the number of pixels in either dimension that correspond to a single
 * pixel in the decoded bitmap. For example, inSampleSize == 4 returns
 * an image that is 1/4 the width/height of the original, and 1/16 the
 * number of pixels. Any value <= 1 is treated the same as 1. Note: the
 * decoder uses a final value based on powers of 2, any other value will
 * be rounded down to the nearest power of 2.
 * @apiSince 1
 */

public int inSampleSize;

/**
 * When this flag is set, if {@link #inDensity} and
 * {@link #inTargetDensity} are not 0, the
 * bitmap will be scaled to match {@link #inTargetDensity} when loaded,
 * rather than relying on the graphics system scaling it each time it
 * is drawn to a Canvas.
 *
 * <p>BitmapRegionDecoder ignores this flag, and will not scale output
 * based on density. (though {@link #inSampleSize} is supported)</p>
 *
 * <p>This flag is turned on by default and should be turned off if you need
 * a non-scaled version of the bitmap.  Nine-patch bitmaps ignore this
 * flag and are always scaled.
 *
 * <p>If {@link #inPremultiplied} is set to false, and the image has alpha,
 * setting this flag to true may result in incorrect colors.
 * @apiSince 4
 */

public boolean inScaled;

/**
 * The pixel density of the actual screen that is being used.  This is
 * purely for applications running in density compatibility code, where
 * {@link #inTargetDensity} is actually the density the application
 * sees rather than the real screen density.
 *
 * <p>By setting this, you
 * allow the loading code to avoid scaling a bitmap that is currently
 * in the screen density up/down to the compatibility density.  Instead,
 * if {@link #inDensity} is the same as {@link #inScreenDensity}, the
 * bitmap will be left as-is.  Anything using the resulting bitmap
 * must also used {@link android.graphics.Bitmap#getScaledWidth(int) Bitmap#getScaledWidth(int)} and {@link android.graphics.Bitmap#getScaledHeight Bitmap#getScaledHeight} to account for any different between the
 * bitmap's density and the target's density.
 *
 * <p>This is never set automatically for the caller by
 * {@link android.graphics.BitmapFactory BitmapFactory} itself.  It must be explicitly set, since the
 * caller must deal with the resulting bitmap in a density-aware way.
 *
 * @see #inDensity
 * @see #inTargetDensity
 * @see #inScaled
 * @see android.util.DisplayMetrics#densityDpi
 * @apiSince 4
 */

public int inScreenDensity;

/**
 * The pixel density of the destination this bitmap will be drawn to.
 * This is used in conjunction with {@link #inDensity} and
 * {@link #inScaled} to determine if and how to scale the bitmap before
 * returning it.
 *
 * <p>If this is 0,
 * {@link android.graphics.BitmapFactory#decodeResource(android.content.res.Resources,int) BitmapFactory#decodeResource(Resources, int)},
 * {@link android.graphics.BitmapFactory#decodeResource(android.content.res.Resources,int,android.graphics.BitmapFactory.Options) BitmapFactory#decodeResource(Resources, int, android.graphics.BitmapFactory.Options)},
 * and {@link android.graphics.BitmapFactory#decodeResourceStream BitmapFactory#decodeResourceStream}
 * will fill in the density associated the Resources object's
 * DisplayMetrics.  The other
 * functions will leave it as-is and no scaling for density will be
 * performed.
 *
 * @see #inDensity
 * @see #inScreenDensity
 * @see #inScaled
 * @see android.util.DisplayMetrics#densityDpi
 * @apiSince 4
 */

public int inTargetDensity;

/**
 * Temp storage to use for decoding.  Suggest 16K or so.
 * @apiSince 1
 */

public byte[] inTempStorage;

/**
 * @deprecated As of {@link android.os.Build.VERSION_CODES#N}, see
 * comments on {@link #requestCancelDecode()}.
 *
 * Flag to indicate that cancel has been called on this object.  This
 * is useful if there's an intermediary that wants to first decode the
 * bounds and then decode the image.  In that case the intermediary
 * can check, inbetween the bounds decode and the image decode, to see
 * if the operation is canceled.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated public boolean mCancel;

/**
 * If known, the color space the decoded bitmap will have. Note that the
 * output color space is not guaranteed to be the color space the bitmap
 * is encoded with. If not known (when the config is
 * {@link android.graphics.Bitmap.Config#ALPHA_8 Bitmap.Config#ALPHA_8} for instance), or there is an error,
 * it is set to null.
 * @apiSince 26
 */

public android.graphics.ColorSpace outColorSpace;

/**
 * If known, the config the decoded bitmap will have.
 * If not known, or there is an error, it is set to null.
 * @apiSince 26
 */

public android.graphics.Bitmap.Config outConfig;

/**
 * The resulting height of the bitmap. If {@link #inJustDecodeBounds} is
 * set to false, this will be height of the output bitmap after any
 * scaling is applied. If true, it will be the height of the input image
 * without any accounting for scaling.
 *
 * <p>outHeight will be set to -1 if there is an error trying to decode.</p>
 * @apiSince 1
 */

public int outHeight;

/**
 * If known, this string is set to the mimetype of the decoded image.
 * If not known, or there is an error, it is set to null.
 * @apiSince 1
 */

public java.lang.String outMimeType;

/**
 * The resulting width of the bitmap. If {@link #inJustDecodeBounds} is
 * set to false, this will be width of the output bitmap after any
 * scaling is applied. If true, it will be the width of the input image
 * without any accounting for scaling.
 *
 * <p>outWidth will be set to -1 if there is an error trying to decode.</p>
 * @apiSince 1
 */

public int outWidth;
}

}

