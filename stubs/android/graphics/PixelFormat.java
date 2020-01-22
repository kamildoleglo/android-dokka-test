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


/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PixelFormat {

public PixelFormat() { throw new RuntimeException("Stub!"); }

/**
 * @param format Value is {@link android.graphics.PixelFormat#RGBA_8888}, {@link android.graphics.PixelFormat#RGBX_8888}, {@link android.graphics.PixelFormat#RGBA_F16}, {@link android.graphics.PixelFormat#RGBA_1010102}, {@link android.graphics.PixelFormat#RGB_888}, or {@link android.graphics.PixelFormat#RGB_565}
 * @apiSince 1
 */

public static void getPixelFormatInfo(int format, android.graphics.PixelFormat info) { throw new RuntimeException("Stub!"); }

/**
 * @param format Value is {@link android.graphics.PixelFormat#RGBA_8888}, {@link android.graphics.PixelFormat#RGBX_8888}, {@link android.graphics.PixelFormat#RGBA_F16}, {@link android.graphics.PixelFormat#RGBA_1010102}, {@link android.graphics.PixelFormat#RGB_888}, or {@link android.graphics.PixelFormat#RGB_565}
 * @apiSince 1
 */

public static boolean formatHasAlpha(int format) { throw new RuntimeException("Stub!"); }

/**
 * @apiSince 1
 * @deprecatedSince 19
 */

@Deprecated public static final int A_8 = 8; // 0x8

/**
 * @deprecated use {@link android.graphics.ImageFormat#JPEG
 * ImageFormat.JPEG} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int JPEG = 256; // 0x100

/**
 * @apiSince 1
 * @deprecatedSince 16
 */

@Deprecated public static final int LA_88 = 10; // 0xa

/**
 * @apiSince 1
 * @deprecatedSince 19
 */

@Deprecated public static final int L_8 = 9; // 0x9

/**
 * System chooses an opaque format (no alpha bits required)
 * @apiSince 1
 */

public static final int OPAQUE = -1; // 0xffffffff

/** @apiSince 26 */

public static final int RGBA_1010102 = 43; // 0x2b

/**
 * @apiSince 1
 * @deprecatedSince 16
 */

@Deprecated public static final int RGBA_4444 = 7; // 0x7

/**
 * @apiSince 1
 * @deprecatedSince 16
 */

@Deprecated public static final int RGBA_5551 = 6; // 0x6

/** @apiSince 1 */

public static final int RGBA_8888 = 1; // 0x1

/** @apiSince 26 */

public static final int RGBA_F16 = 22; // 0x16

/** @apiSince 1 */

public static final int RGBX_8888 = 2; // 0x2

/**
 * @apiSince 1
 * @deprecatedSince 16
 */

@Deprecated public static final int RGB_332 = 11; // 0xb

/** @apiSince 1 */

public static final int RGB_565 = 4; // 0x4

/** @apiSince 1 */

public static final int RGB_888 = 3; // 0x3

/**
 * System chooses a format that supports translucency (many alpha bits)
 * @apiSince 1
 */

public static final int TRANSLUCENT = -3; // 0xfffffffd

/**
 * System chooses a format that supports transparency
 * (at least 1 alpha bit)
 * @apiSince 1
 */

public static final int TRANSPARENT = -2; // 0xfffffffe

/** @apiSince 1 */

public static final int UNKNOWN = 0; // 0x0

/**
 * @deprecated use {@link android.graphics.ImageFormat#NV21
 * ImageFormat.NV21} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int YCbCr_420_SP = 17; // 0x11

/**
 * @deprecated use {@link android.graphics.ImageFormat#YUY2
 * ImageFormat.YUY2} instead.
 * @apiSince 5
 * @deprecatedSince 15
 */

@Deprecated public static final int YCbCr_422_I = 20; // 0x14

/**
 * @deprecated use {@link android.graphics.ImageFormat#NV16
 * ImageFormat.NV16} instead.
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated public static final int YCbCr_422_SP = 16; // 0x10

/** @apiSince 1 */

public int bitsPerPixel;

/** @apiSince 1 */

public int bytesPerPixel;
}

