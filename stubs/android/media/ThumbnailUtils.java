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


package android.media;

import android.util.Size;
import android.os.CancellationSignal;
import java.io.File;
import java.io.IOException;
import android.graphics.Bitmap;

/**
 * Utilities for generating visual thumbnails from files.
 * @apiSince 8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ThumbnailUtils {

public ThumbnailUtils() { throw new RuntimeException("Stub!"); }

/**
 * Create a thumbnail for given audio file.
 *
 * @param filePath The audio file.
 * This value must never be {@code null}.
 * @param kind The desired thumbnail kind, such as
 *            {@link android.provider.MediaStore.Images.Thumbnails#MINI_KIND}.
 * @deprecated Callers should migrate to using
 *             {@link #createAudioThumbnail(java.io.File,android.util.Size,android.os.CancellationSignal)},
 *             as it offers more control over resizing and cancellation.
 
 * @return This value may be {@code null}.
 * @apiSince 29
 * @deprecatedSince 29
 */

@Deprecated
@androidx.annotation.Nullable
public static android.graphics.Bitmap createAudioThumbnail(@androidx.annotation.NonNull java.lang.String filePath, int kind) { throw new RuntimeException("Stub!"); }

/**
 * Create a thumbnail for given audio file.
 *
 * @param file The audio file.
 * This value must never be {@code null}.
 * @param size The desired thumbnail size.
 * This value must never be {@code null}.
 * @throws java.io.IOException If any trouble was encountered while generating or
 *             loading the thumbnail, or if
 *             {@link android.os.CancellationSignal#cancel() CancellationSignal#cancel()} was invoked.
 
 * @param signal This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public static android.graphics.Bitmap createAudioThumbnail(@androidx.annotation.NonNull java.io.File file, @androidx.annotation.NonNull android.util.Size size, @androidx.annotation.Nullable android.os.CancellationSignal signal) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Create a thumbnail for given image file.
 *
 * @param filePath The image file.
 * This value must never be {@code null}.
 * @param kind The desired thumbnail kind, such as
 *            {@link android.provider.MediaStore.Images.Thumbnails#MINI_KIND}.
 * @deprecated Callers should migrate to using
 *             {@link #createImageThumbnail(java.io.File,android.util.Size,android.os.CancellationSignal)},
 *             as it offers more control over resizing and cancellation.
 
 * @return This value may be {@code null}.
 * @apiSince 29
 * @deprecatedSince 29
 */

@Deprecated
@androidx.annotation.Nullable
public static android.graphics.Bitmap createImageThumbnail(@androidx.annotation.NonNull java.lang.String filePath, int kind) { throw new RuntimeException("Stub!"); }

/**
 * Create a thumbnail for given image file.
 *
 * @param file The audio file.
 * This value must never be {@code null}.
 * @param size The desired thumbnail size.
 * This value must never be {@code null}.
 * @throws java.io.IOException If any trouble was encountered while generating or
 *             loading the thumbnail, or if
 *             {@link android.os.CancellationSignal#cancel() CancellationSignal#cancel()} was invoked.
 
 * @param signal This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public static android.graphics.Bitmap createImageThumbnail(@androidx.annotation.NonNull java.io.File file, @androidx.annotation.NonNull android.util.Size size, @androidx.annotation.Nullable android.os.CancellationSignal signal) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Create a thumbnail for given video file.
 *
 * @param filePath The video file.
 * This value must never be {@code null}.
 * @param kind The desired thumbnail kind, such as
 *            {@link android.provider.MediaStore.Images.Thumbnails#MINI_KIND}.
 * @deprecated Callers should migrate to using
 *             {@link #createVideoThumbnail(java.io.File,android.util.Size,android.os.CancellationSignal)},
 *             as it offers more control over resizing and cancellation.
 
 * @return This value may be {@code null}.
 * @apiSince 8
 * @deprecatedSince 29
 */

@Deprecated
@androidx.annotation.Nullable
public static android.graphics.Bitmap createVideoThumbnail(@androidx.annotation.NonNull java.lang.String filePath, int kind) { throw new RuntimeException("Stub!"); }

/**
 * Create a thumbnail for given video file.
 *
 * @param file The video file.
 * This value must never be {@code null}.
 * @param size The desired thumbnail size.
 * This value must never be {@code null}.
 * @throws java.io.IOException If any trouble was encountered while generating or
 *             loading the thumbnail, or if
 *             {@link android.os.CancellationSignal#cancel() CancellationSignal#cancel()} was invoked.
 
 * @param signal This value may be {@code null}.
 * @return This value will never be {@code null}.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public static android.graphics.Bitmap createVideoThumbnail(@androidx.annotation.NonNull java.io.File file, @androidx.annotation.NonNull android.util.Size size, @androidx.annotation.Nullable android.os.CancellationSignal signal) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Creates a centered bitmap of the desired size.
 *
 * @param source original bitmap source
 * @param width targeted width
 * @param height targeted height
 * @apiSince 8
 */

public static android.graphics.Bitmap extractThumbnail(android.graphics.Bitmap source, int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * Creates a centered bitmap of the desired size.
 *
 * @param source original bitmap source
 * @param width targeted width
 * @param height targeted height
 * @param options options used during thumbnail extraction
 * @apiSince 8
 */

public static android.graphics.Bitmap extractThumbnail(android.graphics.Bitmap source, int width, int height, int options) { throw new RuntimeException("Stub!"); }

/**
 * Constant used to indicate we should recycle the input in
 * {@link #extractThumbnail(android.graphics.Bitmap,int,int,int)} unless the output is the input.
 * @apiSince 8
 */

public static final int OPTIONS_RECYCLE_INPUT = 2; // 0x2
}

