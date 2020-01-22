/*
 * Copyright (C) 2017 The Android Open Source Project
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

import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import java.io.File;
import android.content.ContentResolver;
import android.content.res.Resources;
import android.net.Uri;
import java.nio.ByteBuffer;
import java.util.concurrent.Callable;
import android.content.res.AssetFileDescriptor;
import java.io.IOException;
import android.util.Size;

/**
 *  <p>A class for converting encoded images (like {@code PNG}, {@code JPEG},
 *  {@code WEBP}, {@code GIF}, or {@code HEIF}) into {@link android.graphics.drawable.Drawable Drawable} or
 *  {@link android.graphics.Bitmap Bitmap} objects.
 *
 *  <p>To use it, first create a {@link android.graphics.ImageDecoder.Source Source} using one of the
 *  {@code createSource} overloads. For example, to decode from a {@link java.io.File File}, call
 *  {@link #createSource(java.io.File)} and pass the result to {@link #decodeDrawable(android.graphics.ImageDecoder.Source)}
 *  or {@link #decodeBitmap(android.graphics.ImageDecoder.Source)}:
 *
 *  <pre class="prettyprint">
 *  File file = new File(...);
 *  ImageDecoder.Source source = ImageDecoder.createSource(file);
 *  Drawable drawable = ImageDecoder.decodeDrawable(source);
 *  </pre>
 *
 *  <p>To change the default settings, pass the {@link android.graphics.ImageDecoder.Source Source} and an
 *  {@link android.graphics.ImageDecoder.OnHeaderDecodedListener OnHeaderDecodedListener} to
 *  {@link #decodeDrawable(android.graphics.ImageDecoder.Source,android.graphics.ImageDecoder.OnHeaderDecodedListener)} or
 *  {@link #decodeBitmap(android.graphics.ImageDecoder.Source,android.graphics.ImageDecoder.OnHeaderDecodedListener)}. For example, to
 *  create a sampled image with half the width and height of the original image,
 *  call {@link #setTargetSampleSize setTargetSampleSize(2)} inside
 *  {@link android.graphics.ImageDecoder.OnHeaderDecodedListener#onHeaderDecoded OnHeaderDecodedListener#onHeaderDecoded}:
 *
 *  <pre class="prettyprint">
 *  OnHeaderDecodedListener listener = new OnHeaderDecodedListener() {
 *      public void onHeaderDecoded(ImageDecoder decoder, ImageInfo info, Source source) {
 *          decoder.setTargetSampleSize(2);
 *      }
 *  };
 *  Drawable drawable = ImageDecoder.decodeDrawable(source, listener);
 *  </pre>
 *
 *  <p>The {@link android.graphics.ImageDecoder.ImageInfo ImageInfo} contains information about the encoded image, like
 *  its width and height, and the {@link android.graphics.ImageDecoder.Source Source} can be used to match to a particular
 *  {@link android.graphics.ImageDecoder.Source Source} if a single {@link android.graphics.ImageDecoder.OnHeaderDecodedListener OnHeaderDecodedListener}
 *  is used with multiple {@link android.graphics.ImageDecoder.Source Source} objects.
 *
 *  <p>The {@link android.graphics.ImageDecoder.OnHeaderDecodedListener OnHeaderDecodedListener} can also be implemented
 *  as a lambda:
 *
 *  <pre class="prettyprint">
 *  Drawable drawable = ImageDecoder.decodeDrawable(source, (decoder, info, src) -&gt; {
 *      decoder.setTargetSampleSize(2);
 *  });
 *  </pre>
 *
 *  <p>If the encoded image is an animated {@code GIF} or {@code WEBP},
 *  {@link #decodeDrawable decodeDrawable} will return an {@link android.graphics.drawable.AnimatedImageDrawable AnimatedImageDrawable}. To
 *  start its animation, call {@link android.graphics.drawable.AnimatedImageDrawable#start AnimatedImageDrawable#start}:
 *
 *  <pre class="prettyprint">
 *  Drawable drawable = ImageDecoder.decodeDrawable(source);
 *  if (drawable instanceof AnimatedImageDrawable) {
 *      ((AnimatedImageDrawable) drawable).start();
 *  }
 *  </pre>
 *
 *  <p>By default, a {@link android.graphics.Bitmap Bitmap} created by {@link android.graphics.ImageDecoder ImageDecoder} (including
 *  one that is inside a {@link android.graphics.drawable.Drawable Drawable}) will be immutable (i.e.
 *  {@link android.graphics.Bitmap#isMutable Bitmap#isMutable} returns {@code false}), and it
 *  will typically have {@code Config} {@link android.graphics.Bitmap.Config#HARDWARE Bitmap.Config#HARDWARE}. Although
 *  these properties can be changed with {@link #setMutableRequired setMutableRequired(true)}
 *  (which is only compatible with {@link #decodeBitmap(android.graphics.ImageDecoder.Source)} and
 *  {@link #decodeBitmap(android.graphics.ImageDecoder.Source,android.graphics.ImageDecoder.OnHeaderDecodedListener)}) and {@link #setAllocator},
 *  it is also possible to apply custom effects regardless of the mutability of
 *  the final returned object by passing a {@link android.graphics.PostProcessor PostProcessor} to
 *  {@link #setPostProcessor setPostProcessor}. A {@link android.graphics.PostProcessor PostProcessor} can also be a lambda:
 *
 *  <pre class="prettyprint">
 *  Drawable drawable = ImageDecoder.decodeDrawable(source, (decoder, info, src) -&gt; {
 *      decoder.setPostProcessor((canvas) -&gt; {
 *              // This will create rounded corners.
 *              Path path = new Path();
 *              path.setFillType(Path.FillType.INVERSE_EVEN_ODD);
 *              int width = canvas.getWidth();
 *              int height = canvas.getHeight();
 *              path.addRoundRect(0, 0, width, height, 20, 20, Path.Direction.CW);
 *              Paint paint = new Paint();
 *              paint.setAntiAlias(true);
 *              paint.setColor(Color.TRANSPARENT);
 *              paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
 *              canvas.drawPath(path, paint);
 *              return PixelFormat.TRANSLUCENT;
 *      });
 *  });
 *  </pre>
 *
 *  <p>If the encoded image is incomplete or contains an error, or if an
 *  {@link java.lang.Exception Exception} occurs during decoding, a {@link android.graphics.ImageDecoder.DecodeException DecodeException}
 *  will be thrown. In some cases, the {@link android.graphics.ImageDecoder ImageDecoder} may have decoded part of
 *  the image. In order to display the partial image, an
 *  {@link android.graphics.ImageDecoder.OnPartialImageListener OnPartialImageListener} must be passed to
 *  {@link #setOnPartialImageListener setOnPartialImageListener}. For example:
 *
 *  <pre class="prettyprint">
 *  Drawable drawable = ImageDecoder.decodeDrawable(source, (decoder, info, src) -&gt; {
 *      decoder.setOnPartialImageListener((DecodeException e) -&gt; {
 *              // Returning true indicates to create a Drawable or Bitmap even
 *              // if the whole image could not be decoded. Any remaining lines
 *              // will be blank.
 *              return true;
 *      });
 *  });
 *  </pre>
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ImageDecoder implements java.lang.AutoCloseable {

private ImageDecoder() { throw new RuntimeException("Stub!"); }

/** @apiSince 28 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Return if the given MIME type is a supported file format that can be
 * decoded by this class. This can be useful to determine if a file can be
 * decoded directly, or if it needs to be converted into a more general
 * format using an API like {@link android.content.ContentResolver#openTypedAssetFile ContentResolver#openTypedAssetFile}.
 
 * @param mimeType This value must never be {@code null}.
 * @apiSince 29
 */

public static boolean isMimeTypeSupported(@androidx.annotation.NonNull java.lang.String mimeType) { throw new RuntimeException("Stub!"); }

/**
 * Create a new {@link android.graphics.ImageDecoder.Source Source} from a resource.
 *
 * <br>
 * This method is safe to call from any thread.
 * @param res the {@link android.content.res.Resources Resources} object containing the image data.
 * This value must never be {@code null}.
 * @param resId resource ID of the image data.
 * @return a new Source object, which can be passed to
 *      {@link #decodeDrawable decodeDrawable} or
 *      {@link #decodeBitmap decodeBitmap}.
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public static android.graphics.ImageDecoder.Source createSource(@androidx.annotation.NonNull android.content.res.Resources res, int resId) { throw new RuntimeException("Stub!"); }

/**
 * Create a new {@link android.graphics.ImageDecoder.Source Source} from a {@link android.net.Uri}.
 *
 * <h5>Accepts the following URI schemes:</h5>
 * <ul>
 * <li>content ({@link android.content.ContentResolver#SCHEME_CONTENT ContentResolver#SCHEME_CONTENT})</li>
 * <li>android.resource ({@link android.content.ContentResolver#SCHEME_ANDROID_RESOURCE ContentResolver#SCHEME_ANDROID_RESOURCE})</li>
 * <li>file ({@link android.content.ContentResolver#SCHEME_FILE ContentResolver#SCHEME_FILE})</li>
 * </ul>
 *
 * <br>
 * This method is safe to call from any thread.
 * @param cr to retrieve from.
 * This value must never be {@code null}.
 * @param uri of the image file.
 * This value must never be {@code null}.
 * @return a new Source object, which can be passed to
 *      {@link #decodeDrawable decodeDrawable} or
 *      {@link #decodeBitmap decodeBitmap}.
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public static android.graphics.ImageDecoder.Source createSource(@androidx.annotation.NonNull android.content.ContentResolver cr, @androidx.annotation.NonNull android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Create a new {@link android.graphics.ImageDecoder.Source Source} from a file in the "assets" directory.
 
 * <br>
 * This method is safe to call from any thread.
 
 * @param assets This value must never be {@code null}.
 * @param fileName This value must never be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public static android.graphics.ImageDecoder.Source createSource(@androidx.annotation.NonNull android.content.res.AssetManager assets, @androidx.annotation.NonNull java.lang.String fileName) { throw new RuntimeException("Stub!"); }

/**
 * Create a new {@link android.graphics.ImageDecoder.Source Source} from a {@link java.nio.ByteBuffer}.
 *
 * <p>Decoding will start from {@link java.nio.ByteBuffer#position() buffer.position()}.
 * The position of {@code buffer} will not be affected.</p>
 *
 * <p>Note: If this {@code Source} is passed to {@link #decodeDrawable decodeDrawable},
 * and the encoded image is animated, the returned {@link android.graphics.drawable.AnimatedImageDrawable AnimatedImageDrawable}
 * will continue reading from the {@code buffer}, so its contents must not
 * be modified, even after the {@code AnimatedImageDrawable} is returned.
 * {@code buffer}'s contents should never be modified during decode.</p>
 *
 * <br>
 * This method is safe to call from any thread.
 * @param buffer This value must never be {@code null}.
 * @return a new Source object, which can be passed to
 *      {@link #decodeDrawable decodeDrawable} or
 *      {@link #decodeBitmap decodeBitmap}.
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public static android.graphics.ImageDecoder.Source createSource(@androidx.annotation.NonNull java.nio.ByteBuffer buffer) { throw new RuntimeException("Stub!"); }

/**
 * Create a new {@link android.graphics.ImageDecoder.Source Source} from a {@link java.io.File}.
 *
 * <br>
 * This method is safe to call from any thread.
 * @param file This value must never be {@code null}.
 * @return a new Source object, which can be passed to
 *      {@link #decodeDrawable decodeDrawable} or
 *      {@link #decodeBitmap decodeBitmap}.
 
 * This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public static android.graphics.ImageDecoder.Source createSource(@androidx.annotation.NonNull java.io.File file) { throw new RuntimeException("Stub!"); }

/**
 * Create a new {@link android.graphics.ImageDecoder.Source Source} from a {@link java.util.concurrent.Callable Callable} that returns a
 * new {@link android.content.res.AssetFileDescriptor AssetFileDescriptor} for each request. This provides control
 * over how the {@link android.content.res.AssetFileDescriptor AssetFileDescriptor} is created, such as passing
 * options into {@link android.content.ContentResolver#openTypedAssetFileDescriptor ContentResolver#openTypedAssetFileDescriptor}, or
 * enabling use of a {@link android.os.CancellationSignal}.
 * <p>
 * It's important for the given {@link java.util.concurrent.Callable Callable} to return a new, unique
 * {@link android.content.res.AssetFileDescriptor AssetFileDescriptor} for each invocation, to support reuse of the
 * returned {@link android.graphics.ImageDecoder.Source Source}.
 *
 * <br>
 * This method is safe to call from any thread.
 * @param callable This value must never be {@code null}.
 * @return a new Source object, which can be passed to
 *         {@link #decodeDrawable decodeDrawable} or {@link #decodeBitmap
 *         decodeBitmap}.
 
 * This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public static android.graphics.ImageDecoder.Source createSource(@androidx.annotation.NonNull java.util.concurrent.Callable<android.content.res.AssetFileDescriptor> callable) { throw new RuntimeException("Stub!"); }

/**
 *  Specify the size of the output {@link android.graphics.drawable.Drawable Drawable} or {@link android.graphics.Bitmap Bitmap}.
 *
 *  <p>By default, the output size will match the size of the encoded
 *  image, which can be retrieved from the {@link android.graphics.ImageDecoder.ImageInfo ImageInfo} in
 *  {@link android.graphics.ImageDecoder.OnHeaderDecodedListener#onHeaderDecoded OnHeaderDecodedListener#onHeaderDecoded}.</p>
 *
 *  <p>This will sample or scale the output to an arbitrary size that may
 *  be smaller or larger than the encoded size.</p>
 *
 *  <p>Only the last call to this or {@link #setTargetSampleSize} is
 *  respected.</p>
 *
 *  <p>Like all setters on ImageDecoder, this must be called inside
 *  {@link android.graphics.ImageDecoder.OnHeaderDecodedListener#onHeaderDecoded OnHeaderDecodedListener#onHeaderDecoded}.</p>
 *
 *  @param width width in pixels of the output, must be greater than 0
 *
 * This units of this value are pixels.
 * Value is 1 or greater
 * @param height height in pixels of the output, must be greater than 0
 
 * This units of this value are pixels.
 
 * Value is 1 or greater
 * @apiSince 28
 */

public void setTargetSize(int width, int height) { throw new RuntimeException("Stub!"); }

/**
 *  Set the target size with a sampleSize.
 *
 *  <p>By default, the output size will match the size of the encoded
 *  image, which can be retrieved from the {@link android.graphics.ImageDecoder.ImageInfo ImageInfo} in
 *  {@link android.graphics.ImageDecoder.OnHeaderDecodedListener#onHeaderDecoded OnHeaderDecodedListener#onHeaderDecoded}.</p>
 *
 *  <p>Requests the decoder to subsample the original image, returning a
 *  smaller image to save memory. The {@code sampleSize} is the number of pixels
 *  in either dimension that correspond to a single pixel in the output.
 *  For example, {@code sampleSize == 4} returns an image that is 1/4 the
 *  width/height of the original, and 1/16 the number of pixels.</p>
 *
 *  <p>Must be greater than or equal to 1.</p>
 *
 *  <p>This has the same effect as calling {@link #setTargetSize} with
 *  dimensions based on the {@code sampleSize}. Unlike dividing the original
 *  width and height by the {@code sampleSize} manually, calling this method
 *  allows {@code ImageDecoder} to round in the direction that it can do most
 *  efficiently.</p>
 *
 *  <p>Only the last call to this or {@link #setTargetSize} is respected.</p>
 *
 *  <p>Like all setters on ImageDecoder, this must be called inside
 *  {@link android.graphics.ImageDecoder.OnHeaderDecodedListener#onHeaderDecoded OnHeaderDecodedListener#onHeaderDecoded}.</p>
 *
 *  @param sampleSize sampling rate of the encoded image.
 
 * Value is 1 or greater
 * @apiSince 28
 */

public void setTargetSampleSize(int sampleSize) { throw new RuntimeException("Stub!"); }

/**
 *  Choose the backing for the pixel memory.
 *
 *  <p>This is ignored for animated drawables.</p>
 *
 *  <p>Like all setters on ImageDecoder, this must be called inside
 *  {@link android.graphics.ImageDecoder.OnHeaderDecodedListener#onHeaderDecoded OnHeaderDecodedListener#onHeaderDecoded}.</p>
 *
 *  @param allocator Type of allocator to use.
 
 * Value is {@link android.graphics.ImageDecoder#ALLOCATOR_DEFAULT}, {@link android.graphics.ImageDecoder#ALLOCATOR_SOFTWARE}, {@link android.graphics.ImageDecoder#ALLOCATOR_SHARED_MEMORY}, or {@link android.graphics.ImageDecoder#ALLOCATOR_HARDWARE}
 * @apiSince 28
 */

public void setAllocator(int allocator) { throw new RuntimeException("Stub!"); }

/**
 *  Return the allocator for the pixel memory.
 
 * @return Value is {@link android.graphics.ImageDecoder#ALLOCATOR_DEFAULT}, {@link android.graphics.ImageDecoder#ALLOCATOR_SOFTWARE}, {@link android.graphics.ImageDecoder#ALLOCATOR_SHARED_MEMORY}, or {@link android.graphics.ImageDecoder#ALLOCATOR_HARDWARE}
 * @apiSince 28
 */

public int getAllocator() { throw new RuntimeException("Stub!"); }

/**
 *  Specify whether the {@link android.graphics.Bitmap Bitmap} should have unpremultiplied pixels.
 *
 *  <p>By default, ImageDecoder will create a {@link android.graphics.Bitmap Bitmap} with
 *  premultiplied pixels, which is required for drawing with the
 *  {@link android.view.View} system (i.e. to a {@link android.graphics.Canvas Canvas}). Calling
 *  this method with a value of {@code true} will result in
 *  {@link #decodeBitmap} returning a {@link android.graphics.Bitmap Bitmap} with unpremultiplied
 *  pixels. See {@link android.graphics.Bitmap#isPremultiplied Bitmap#isPremultiplied}.
 *  This is incompatible with {@link #decodeDrawable decodeDrawable};
 *  attempting to decode an unpremultiplied {@link android.graphics.drawable.Drawable Drawable} will throw an
 *  {@link java.lang.IllegalStateException}. </p>
 *
 *  <p>Like all setters on ImageDecoder, this must be called inside
 *  {@link android.graphics.ImageDecoder.OnHeaderDecodedListener#onHeaderDecoded OnHeaderDecodedListener#onHeaderDecoded}.</p>
 * @apiSince 28
 */

public void setUnpremultipliedRequired(boolean unpremultipliedRequired) { throw new RuntimeException("Stub!"); }

/**
 *  Return whether the {@link android.graphics.Bitmap Bitmap} will have unpremultiplied pixels.
 * @apiSince 28
 */

public boolean isUnpremultipliedRequired() { throw new RuntimeException("Stub!"); }

/**
 *  Modify the image after decoding and scaling.
 *
 *  <p>This allows adding effects prior to returning a {@link android.graphics.drawable.Drawable Drawable} or
 *  {@link android.graphics.Bitmap Bitmap}. For a {@code Drawable} or an immutable {@code Bitmap},
 *  this is the only way to process the image after decoding.</p>
 *
 *  <p>If combined with {@link #setTargetSize} and/or {@link #setCrop},
 *  {@link android.graphics.PostProcessor#onPostProcess PostProcessor#onPostProcess} occurs last.</p>
 *
 *  <p>If set on a nine-patch image, the nine-patch data is ignored.</p>
 *
 *  <p>For an animated image, the drawing commands drawn on the
 *  {@link android.graphics.Canvas Canvas} will be recorded immediately and then applied to each
 *  frame.</p>
 *
 *  <p>Like all setters on ImageDecoder, this must be called inside
 *  {@link android.graphics.ImageDecoder.OnHeaderDecodedListener#onHeaderDecoded OnHeaderDecodedListener#onHeaderDecoded}.</p>
 *
 
 * @param postProcessor This value may be {@code null}.
 * @apiSince 28
 */

public void setPostProcessor(@androidx.annotation.Nullable android.graphics.PostProcessor postProcessor) { throw new RuntimeException("Stub!"); }

/**
 *  Return the {@link android.graphics.PostProcessor PostProcessor} currently set.
 
 * @return This value may be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public android.graphics.PostProcessor getPostProcessor() { throw new RuntimeException("Stub!"); }

/**
 *  Set (replace) the {@link android.graphics.ImageDecoder.OnPartialImageListener OnPartialImageListener} on this object.
 *
 *  <p>Will be called if there is an error in the input. Without one, an
 *  error will result in an {@code Exception} being thrown.</p>
 *
 *  <p>Like all setters on ImageDecoder, this must be called inside
 *  {@link android.graphics.ImageDecoder.OnHeaderDecodedListener#onHeaderDecoded OnHeaderDecodedListener#onHeaderDecoded}.</p>
 *
 
 * @param listener This value may be {@code null}.
 * @apiSince 28
 */

public void setOnPartialImageListener(@androidx.annotation.Nullable android.graphics.ImageDecoder.OnPartialImageListener listener) { throw new RuntimeException("Stub!"); }

/**
 *  Return the {@link android.graphics.ImageDecoder.OnPartialImageListener OnPartialImageListener} currently set.
 
 * @return This value may be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public android.graphics.ImageDecoder.OnPartialImageListener getOnPartialImageListener() { throw new RuntimeException("Stub!"); }

/**
 *  Crop the output to {@code subset} of the (possibly) scaled image.
 *
 *  <p>{@code subset} must be contained within the size set by
 *  {@link #setTargetSize} or the bounds of the image if setTargetSize was
 *  not called. Otherwise an {@link java.lang.IllegalStateException IllegalStateException} will be thrown by
 *  {@link #decodeDrawable decodeDrawable}/{@link #decodeBitmap decodeBitmap}.</p>
 *
 *  <p>NOT intended as a replacement for
 *  {@link android.graphics.BitmapRegionDecoder#decodeRegion BitmapRegionDecoder#decodeRegion}.
 *  This supports all formats, but merely crops the output.</p>
 *
 *  <p>Like all setters on ImageDecoder, this must be called inside
 *  {@link android.graphics.ImageDecoder.OnHeaderDecodedListener#onHeaderDecoded OnHeaderDecodedListener#onHeaderDecoded}.</p>
 *
 
 * @param subset This value may be {@code null}.
 * @apiSince 28
 */

public void setCrop(@androidx.annotation.Nullable android.graphics.Rect subset) { throw new RuntimeException("Stub!"); }

/**
 *  Return the cropping rectangle, if set.
 
 * @return This value may be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public android.graphics.Rect getCrop() { throw new RuntimeException("Stub!"); }

/**
 *  Specify whether the {@link android.graphics.Bitmap Bitmap} should be mutable.
 *
 *  <p>By default, a {@link android.graphics.Bitmap Bitmap} created by {@link #decodeBitmap decodeBitmap}
 *  will be immutable i.e. {@link android.graphics.Bitmap#isMutable() Bitmap#isMutable()} returns
 *  {@code false}. This can be changed with {@code setMutableRequired(true)}.
 *
 *  <p>Mutable Bitmaps are incompatible with {@link #ALLOCATOR_HARDWARE},
 *  because {@link android.graphics.Bitmap.Config#HARDWARE Bitmap.Config#HARDWARE} Bitmaps cannot be mutable.
 *  Attempting to combine them will throw an
 *  {@link java.lang.IllegalStateException}.</p>
 *
 *  <p>Mutable Bitmaps are also incompatible with {@link #decodeDrawable decodeDrawable},
 *  which would require retrieving the Bitmap from the returned Drawable in
 *  order to modify. Attempting to decode a mutable {@link android.graphics.drawable.Drawable Drawable} will
 *  throw an {@link java.lang.IllegalStateException}.</p>
 *
 *  <p>Like all setters on ImageDecoder, this must be called inside
 *  {@link android.graphics.ImageDecoder.OnHeaderDecodedListener#onHeaderDecoded OnHeaderDecodedListener#onHeaderDecoded}.</p>
 * @apiSince 28
 */

public void setMutableRequired(boolean mutable) { throw new RuntimeException("Stub!"); }

/**
 *  Return whether the decoded {@link android.graphics.Bitmap Bitmap} will be mutable.
 * @apiSince 28
 */

public boolean isMutableRequired() { throw new RuntimeException("Stub!"); }

/**
 *  Specify the memory policy for the decoded {@link android.graphics.Bitmap Bitmap}.
 *
 *  <p>Like all setters on ImageDecoder, this must be called inside
 *  {@link android.graphics.ImageDecoder.OnHeaderDecodedListener#onHeaderDecoded OnHeaderDecodedListener#onHeaderDecoded}.</p>
 
 * @param policy Value is {@link android.graphics.ImageDecoder#MEMORY_POLICY_DEFAULT}, or {@link android.graphics.ImageDecoder#MEMORY_POLICY_LOW_RAM}
 * @apiSince 28
 */

public void setMemorySizePolicy(int policy) { throw new RuntimeException("Stub!"); }

/**
 *  Retrieve the memory policy for the decoded {@link android.graphics.Bitmap Bitmap}.
 
 * @return Value is {@link android.graphics.ImageDecoder#MEMORY_POLICY_DEFAULT}, or {@link android.graphics.ImageDecoder#MEMORY_POLICY_LOW_RAM}
 * @apiSince 28
 */

public int getMemorySizePolicy() { throw new RuntimeException("Stub!"); }

/**
 *  Specify whether to potentially treat the output as an alpha mask.
 *
 *  <p>If this is set to {@code true} and the image is encoded in a format
 *  with only one channel, treat that channel as alpha. Otherwise this call has
 *  no effect.</p>
 *
 *  <p>This is incompatible with {@link #ALLOCATOR_HARDWARE}. Trying to
 *  combine them will result in {@link #decodeDrawable decodeDrawable}/
 *  {@link #decodeBitmap decodeBitmap} throwing an
 *  {@link java.lang.IllegalStateException}.</p>
 *
 *  <p>Like all setters on ImageDecoder, this must be called inside
 *  {@link android.graphics.ImageDecoder.OnHeaderDecodedListener#onHeaderDecoded OnHeaderDecodedListener#onHeaderDecoded}.</p>
 * @apiSince 28
 */

public void setDecodeAsAlphaMaskEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 *  Return whether to treat single channel input as alpha.
 *
 *  <p>This returns whether {@link #setDecodeAsAlphaMaskEnabled} was set to
 *  {@code true}. It may still return {@code true} even if the image has
 *  more than one channel and therefore will not be treated as an alpha
 *  mask.</p>
 * @apiSince 28
 */

public boolean isDecodeAsAlphaMaskEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Specify the desired {@link android.graphics.ColorSpace ColorSpace} for the output.
 *
 * <p>If non-null, the decoder will try to decode into {@code colorSpace}.
 * If it is null, which is the default, or the request cannot be met, the
 * decoder will pick either the color space embedded in the image or the
 * {@link android.graphics.ColorSpace ColorSpace} best suited for the requested image configuration
 * (for instance {@link android.graphics.ColorSpace.Named#SRGB ColorSpace.Named#SRGB} for the
 * {@link android.graphics.Bitmap.Config#ARGB_8888 Bitmap.Config#ARGB_8888} configuration and
 * {@link android.graphics.ColorSpace.Named#EXTENDED_SRGB ColorSpace.Named#EXTENDED_SRGB} for
 * {@link android.graphics.Bitmap.Config#RGBA_F16 Bitmap.Config#RGBA_F16}).</p>
 *
 * <p class="note">Only {@link android.graphics.ColorSpace.Model#RGB ColorSpace.Model#RGB} color spaces are
 * currently supported. An <code>IllegalArgumentException</code> will
 * be thrown by {@link #decodeDrawable decodeDrawable}/
 * {@link #decodeBitmap decodeBitmap} when setting a non-RGB color space
 * such as {@link android.graphics.ColorSpace.Named#CIE_LAB ColorSpace.Named#CIE_LAB}.</p>
 *
 * <p class="note">The specified color space's transfer function must be
 * an {@link android.graphics.ColorSpace.Rgb.TransferParameters ColorSpace.Rgb.TransferParameters}. An
 * <code>IllegalArgumentException</code> will be thrown by the decode methods
 * if calling {@link android.graphics.ColorSpace.Rgb#getTransferParameters() ColorSpace.Rgb#getTransferParameters()} on the
 * specified color space returns null.</p>
 *
 * <p>Like all setters on ImageDecoder, this must be called inside
 * {@link android.graphics.ImageDecoder.OnHeaderDecodedListener#onHeaderDecoded OnHeaderDecodedListener#onHeaderDecoded}.</p>
 * @apiSince 28
 */

public void setTargetColorSpace(android.graphics.ColorSpace colorSpace) { throw new RuntimeException("Stub!"); }

/**
 * Closes this resource, relinquishing any underlying resources. This method
 * is invoked automatically on objects managed by the try-with-resources
 * statement.
 *
 * <p>This is an implementation detail of {@link android.graphics.ImageDecoder ImageDecoder}, and should
 * never be called manually.</p>
 * @apiSince 28
 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 *  Create a {@link android.graphics.drawable.Drawable Drawable} from a {@code Source}.
 *
 *
 * <br>
 * This method may take several seconds to complete, so it should
 * only be called from a worker thread.
 * @param src representing the encoded image.
 *
 * This value must never be {@code null}.
 * @param listener for learning the {@link android.graphics.ImageDecoder.ImageInfo ImageInfo} and changing any
 *      default settings on the {@code ImageDecoder}. This will be called on
 *      the same thread as {@code decodeDrawable} before that method returns.
 *      This is required in order to change any of the default settings.
 *
 * This value must never be {@code null}.
 * @return Drawable for displaying the image.
 *
 * This value will never be {@code null}.
 * @throws java.io.IOException if {@code src} is not found, is an unsupported
 *      format, or cannot be decoded for any reason.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public static android.graphics.drawable.Drawable decodeDrawable(@androidx.annotation.NonNull android.graphics.ImageDecoder.Source src, @androidx.annotation.NonNull android.graphics.ImageDecoder.OnHeaderDecodedListener listener) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 *  Create a {@link android.graphics.drawable.Drawable Drawable} from a {@code Source}.
 *
 *  <p>Since there is no {@link android.graphics.ImageDecoder.OnHeaderDecodedListener OnHeaderDecodedListener},
 *  the default settings will be used. In order to change any settings, call
 *  {@link #decodeDrawable(android.graphics.ImageDecoder.Source,android.graphics.ImageDecoder.OnHeaderDecodedListener)} instead.</p>
 *
 *
 * <br>
 * This method may take several seconds to complete, so it should
 * only be called from a worker thread.
 * @param src representing the encoded image.
 *
 * This value must never be {@code null}.
 * @return Drawable for displaying the image.
 *
 * This value will never be {@code null}.
 * @throws java.io.IOException if {@code src} is not found, is an unsupported
 *      format, or cannot be decoded for any reason.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public static android.graphics.drawable.Drawable decodeDrawable(@androidx.annotation.NonNull android.graphics.ImageDecoder.Source src) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 *  Create a {@link android.graphics.Bitmap Bitmap} from a {@code Source}.
 *
 *
 * <br>
 * This method may take several seconds to complete, so it should
 * only be called from a worker thread.
 * @param src representing the encoded image.
 *
 * This value must never be {@code null}.
 * @param listener for learning the {@link android.graphics.ImageDecoder.ImageInfo ImageInfo} and changing any
 *      default settings on the {@code ImageDecoder}. This will be called on
 *      the same thread as {@code decodeBitmap} before that method returns.
 *      This is required in order to change any of the default settings.
 *
 * This value must never be {@code null}.
 * @return Bitmap containing the image.
 *
 * This value will never be {@code null}.
 * @throws java.io.IOException if {@code src} is not found, is an unsupported
 *      format, or cannot be decoded for any reason.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public static android.graphics.Bitmap decodeBitmap(@androidx.annotation.NonNull android.graphics.ImageDecoder.Source src, @androidx.annotation.NonNull android.graphics.ImageDecoder.OnHeaderDecodedListener listener) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 *  Create a {@link android.graphics.Bitmap Bitmap} from a {@code Source}.
 *
 *  <p>Since there is no {@link android.graphics.ImageDecoder.OnHeaderDecodedListener OnHeaderDecodedListener},
 *  the default settings will be used. In order to change any settings, call
 *  {@link #decodeBitmap(android.graphics.ImageDecoder.Source,android.graphics.ImageDecoder.OnHeaderDecodedListener)} instead.</p>
 *
 *
 * <br>
 * This method may take several seconds to complete, so it should
 * only be called from a worker thread.
 * @param src representing the encoded image.
 *
 * This value must never be {@code null}.
 * @return Bitmap containing the image.
 *
 * This value will never be {@code null}.
 * @throws java.io.IOException if {@code src} is not found, is an unsupported
 *      format, or cannot be decoded for any reason.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public static android.graphics.Bitmap decodeBitmap(@androidx.annotation.NonNull android.graphics.ImageDecoder.Source src) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 *  Use the default allocation for the pixel memory.
 *
 *  Will typically result in a {@link android.graphics.Bitmap.Config#HARDWARE Bitmap.Config#HARDWARE}
 *  allocation, but may be software for small images. In addition, this will
 *  switch to software when HARDWARE is incompatible, e.g.
 *  {@link #setMutableRequired setMutableRequired(true)} or
 *  {@link #setDecodeAsAlphaMaskEnabled setDecodeAsAlphaMaskEnabled(true)}.
 * @apiSince 28
 */

public static final int ALLOCATOR_DEFAULT = 0; // 0x0

/**
 *  Require a {@link android.graphics.Bitmap.Config#HARDWARE Bitmap.Config#HARDWARE} {@link android.graphics.Bitmap Bitmap}.
 *
 *  <p>When this is combined with incompatible options, like
 *  {@link #setMutableRequired setMutableRequired(true)} or
 *  {@link #setDecodeAsAlphaMaskEnabled setDecodeAsAlphaMaskEnabled(true)},
 *  {@link #decodeDrawable decodeDrawable} or {@link #decodeBitmap decodeBitmap}
 *  will throw an {@link java.lang.IllegalStateException}.
 * @apiSince 28
 */

public static final int ALLOCATOR_HARDWARE = 3; // 0x3

/**
 *  Use shared memory for the pixel memory.
 *
 *  <p>Useful for sharing across processes.
 * @apiSince 28
 */

public static final int ALLOCATOR_SHARED_MEMORY = 2; // 0x2

/**
 *  Use a software allocation for the pixel memory.
 *
 *  <p>Useful for drawing to a software {@link android.graphics.Canvas Canvas} or for
 *  accessing the pixels on the final output.
 * @apiSince 28
 */

public static final int ALLOCATOR_SOFTWARE = 1; // 0x1

/**
 * Use the most natural {@link android.graphics.Bitmap.Config Bitmap.Config} for the internal {@link android.graphics.Bitmap Bitmap}.
 *
 * <p>This is the recommended default for most applications and usages. This
 * will use the closest {@link android.graphics.Bitmap.Config Bitmap.Config} for the encoded source. If the
 * encoded source does not exactly match any {@link android.graphics.Bitmap.Config Bitmap.Config}, the next
 * highest quality {@link android.graphics.Bitmap.Config Bitmap.Config} will be used avoiding any loss in
 * image quality.
 * @apiSince 28
 */

public static final int MEMORY_POLICY_DEFAULT = 1; // 0x1

/**
 * Save memory if possible by using a denser {@link android.graphics.Bitmap.Config Bitmap.Config} at the
 * cost of some image quality.
 *
 * <p>For example an opaque 8-bit image may be compressed into an
 * {@link android.graphics.Bitmap.Config#RGB_565 Bitmap.Config#RGB_565} configuration, sacrificing image
 * quality to save memory.
 * @apiSince 28
 */

public static final int MEMORY_POLICY_LOW_RAM = 0; // 0x0
/**
 *  Information about an interrupted decode.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class DecodeException extends java.io.IOException {

DecodeException() { throw new RuntimeException("Stub!"); }

/**
 *  Retrieve the reason that decoding was interrupted.
 *
 *  <p>If the error is {@link #SOURCE_EXCEPTION}, the underlying
 *  {@link java.lang.Throwable} can be retrieved with
 *  {@link java.lang.Throwable#getCause}.</p>
 
 * @return Value is {@link android.graphics.ImageDecoder.DecodeException#SOURCE_EXCEPTION}, {@link android.graphics.ImageDecoder.DecodeException#SOURCE_INCOMPLETE}, or {@link android.graphics.ImageDecoder.DecodeException#SOURCE_MALFORMED_DATA}
 * @apiSince 28
 */

public int getError() { throw new RuntimeException("Stub!"); }

/**
 *  Retrieve the {@link android.graphics.ImageDecoder.Source Source} that was interrupted.
 *
 *  <p>This can be used for equality checking to find the Source which
 *  failed to completely decode.</p>
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.graphics.ImageDecoder.Source getSource() { throw new RuntimeException("Stub!"); }

/**
 *  An Exception was thrown reading the {@link android.graphics.ImageDecoder.Source Source}.
 * @apiSince 28
 */

public static final int SOURCE_EXCEPTION = 1; // 0x1

/**
 *  The encoded data was incomplete.
 * @apiSince 28
 */

public static final int SOURCE_INCOMPLETE = 2; // 0x2

/**
 *  The encoded data contained an error.
 * @apiSince 28
 */

public static final int SOURCE_MALFORMED_DATA = 3; // 0x3
}

/**
 *  Information about an encoded image.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class ImageInfo {

private ImageInfo() { throw new RuntimeException("Stub!"); }

/**
 * Size of the image, without scaling or cropping.
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public android.util.Size getSize() { throw new RuntimeException("Stub!"); }

/**
 * The mimeType of the image.
 
 * @return This value will never be {@code null}.
 * @apiSince 28
 */

@androidx.annotation.NonNull
public java.lang.String getMimeType() { throw new RuntimeException("Stub!"); }

/**
 * Whether the image is animated.
 *
 * <p>If {@code true}, {@link #decodeDrawable decodeDrawable} will
 * return an {@link android.graphics.drawable.AnimatedImageDrawable AnimatedImageDrawable}.</p>
 * @apiSince 28
 */

public boolean isAnimated() { throw new RuntimeException("Stub!"); }

/**
 * If known, the color space the decoded bitmap will have. Note that the
 * output color space is not guaranteed to be the color space the bitmap
 * is encoded with. If not known (when the config is
 * {@link android.graphics.Bitmap.Config#ALPHA_8 Bitmap.Config#ALPHA_8} for instance), or there is an error,
 * it is set to null.
 * @apiSince 28
 */

@androidx.annotation.Nullable
public android.graphics.ColorSpace getColorSpace() { throw new RuntimeException("Stub!"); }
}

/**
 *  Interface for changing the default settings of a decode.
 *
 *  <p>Supply an instance to
 *  {@link #decodeDrawable(android.graphics.ImageDecoder.Source,android.graphics.ImageDecoder.OnHeaderDecodedListener) decodeDrawable}
 *  or {@link #decodeBitmap(android.graphics.ImageDecoder.Source,android.graphics.ImageDecoder.OnHeaderDecodedListener) decodeBitmap},
 *  which will call {@link android.graphics.ImageDecoder.OnHeaderDecodedListener#onHeaderDecoded OnHeaderDecodedListener#onHeaderDecoded}
 *  (in the same thread) once the size is known. The implementation of
 *  {@link android.graphics.ImageDecoder.OnHeaderDecodedListener#onHeaderDecoded OnHeaderDecodedListener#onHeaderDecoded} can then
 *  change the decode settings as desired.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnHeaderDecodedListener {

/**
 *  Called by {@link android.graphics.ImageDecoder ImageDecoder} when the header has been decoded and
 *  the image size is known.
 *
 *  @param decoder the object performing the decode, for changing
 *      its default settings.
 *
 * This value must never be {@code null}.
 * @param info information about the encoded image.
 *
 * This value must never be {@code null}.
 * @param source object that created {@code decoder}.
 
 * This value must never be {@code null}.
 * @apiSince 28
 */

public void onHeaderDecoded(@androidx.annotation.NonNull android.graphics.ImageDecoder decoder, @androidx.annotation.NonNull android.graphics.ImageDecoder.ImageInfo info, @androidx.annotation.NonNull android.graphics.ImageDecoder.Source source);
}

/**
 *  Interface for inspecting a {@link android.graphics.ImageDecoder.DecodeException DecodeException}
 *  and potentially preventing it from being thrown.
 *
 *  <p>If an instance is passed to
 *  {@link #setOnPartialImageListener setOnPartialImageListener}, a
 *  {@link android.graphics.ImageDecoder.DecodeException DecodeException} that would otherwise have been
 *  thrown can be inspected inside
 *  {@link android.graphics.ImageDecoder.OnPartialImageListener#onPartialImage OnPartialImageListener#onPartialImage}.
 *  If {@link android.graphics.ImageDecoder.OnPartialImageListener#onPartialImage OnPartialImageListener#onPartialImage} returns
 *  {@code true}, a partial image will be created.
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnPartialImageListener {

/**
 *  Called by {@link android.graphics.ImageDecoder ImageDecoder} when there is only a partial image to
 *  display.
 *
 *  <p>If decoding is interrupted after having decoded a partial image,
 *  this method will be called. The implementation can inspect the
 *  {@link android.graphics.ImageDecoder.DecodeException DecodeException} and optionally finish the
 *  rest of the decode creation process to create a partial {@link android.graphics.drawable.Drawable Drawable}
 *  or {@link android.graphics.Bitmap Bitmap}.
 *
 *  @param exception exception containing information about the
 *      decode interruption.
 *
 * This value must never be {@code null}.
 * @return {@code true} to create and return a {@link android.graphics.drawable.Drawable Drawable} or
 *      {@link android.graphics.Bitmap Bitmap} with partial data. {@code false} (which is the
 *      default) to abort the decode and throw {@code e}. Any undecoded
 *      lines in the image will be blank.
 * @apiSince 28
 */

public boolean onPartialImage(@androidx.annotation.NonNull android.graphics.ImageDecoder.DecodeException exception);
}

/**
 *  Source of encoded image data.
 *
 *  <p>References the data that will be used to decode a {@link android.graphics.drawable.Drawable Drawable}
 *  or {@link android.graphics.Bitmap Bitmap} in {@link #decodeDrawable decodeDrawable} or
 *  {@link #decodeBitmap decodeBitmap}. Constructing a {@code Source} (with
 *  one of the overloads of {@code createSource}) can be done on any thread
 *  because the construction simply captures values. The real work is done
 *  in {@link #decodeDrawable decodeDrawable} or {@link #decodeBitmap decodeBitmap}.
 *
 *  <p>A {@code Source} object can be reused to create multiple versions of the
 *  same image. For example, to decode a full size image and its thumbnail,
 *  the same {@code Source} can be used once with no
 *  {@link android.graphics.ImageDecoder.OnHeaderDecodedListener OnHeaderDecodedListener} and once with an
 *  implementation of {@link android.graphics.ImageDecoder.OnHeaderDecodedListener#onHeaderDecoded OnHeaderDecodedListener#onHeaderDecoded}
 *  that calls {@link #setTargetSize} with smaller dimensions. One {@code Source}
 *  can even be used simultaneously in multiple threads.</p>
 * @apiSince 28
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class Source {

private Source() { throw new RuntimeException("Stub!"); }
}

}

