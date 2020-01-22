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


package android.hardware;

import android.os.Parcel;

/**
 * HardwareBuffer wraps a native <code>AHardwareBuffer</code> object, which is a low-level object
 * representing a memory buffer accessible by various hardware units. HardwareBuffer allows sharing
 * buffers across different application processes. In particular, HardwareBuffers may be mappable
 * to memory accessibly to various hardware systems, such as the GPU, a sensor or context hub, or
 * other auxiliary processing units.
 *
 * For more information, see the NDK documentation for <code>AHardwareBuffer</code>.
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class HardwareBuffer implements android.os.Parcelable, java.lang.AutoCloseable {

private HardwareBuffer() { throw new RuntimeException("Stub!"); }

/**
 * Creates a new <code>HardwareBuffer</code> instance.
 *
 * <p>Calling this method will throw an <code>IllegalStateException</code> if
 * format is not a supported Format type.</p>
 *
 * @param width The width in pixels of the buffer
 * Value is 1 or greater
 * @param height The height in pixels of the buffer
 * Value is 1 or greater
 * @param format The @Format of each pixel
 * Value is {@link android.hardware.HardwareBuffer#RGBA_8888}, {@link android.hardware.HardwareBuffer#RGBA_FP16}, {@link android.hardware.HardwareBuffer#RGBA_1010102}, {@link android.hardware.HardwareBuffer#RGBX_8888}, {@link android.hardware.HardwareBuffer#RGB_888}, {@link android.hardware.HardwareBuffer#RGB_565}, {@link android.hardware.HardwareBuffer#BLOB}, {@link android.hardware.HardwareBuffer#D_16}, {@link android.hardware.HardwareBuffer#D_24}, {@link android.hardware.HardwareBuffer#DS_24UI8}, {@link android.hardware.HardwareBuffer#D_FP32}, {@link android.hardware.HardwareBuffer#DS_FP32UI8}, or {@link android.hardware.HardwareBuffer#S_UI8}
 * @param layers The number of layers in the buffer
 * Value is 1 or greater
 * @param usage The @Usage flags describing how the buffer will be used
 * Value is either <code>0</code> or a combination of {@link android.hardware.HardwareBuffer#USAGE_CPU_READ_RARELY}, {@link android.hardware.HardwareBuffer#USAGE_CPU_READ_OFTEN}, {@link android.hardware.HardwareBuffer#USAGE_CPU_WRITE_RARELY}, {@link android.hardware.HardwareBuffer#USAGE_CPU_WRITE_OFTEN}, {@link android.hardware.HardwareBuffer#USAGE_GPU_SAMPLED_IMAGE}, {@link android.hardware.HardwareBuffer#USAGE_GPU_COLOR_OUTPUT}, {@link android.hardware.HardwareBuffer#USAGE_PROTECTED_CONTENT}, {@link android.hardware.HardwareBuffer#USAGE_VIDEO_ENCODE}, {@link android.hardware.HardwareBuffer#USAGE_GPU_DATA_BUFFER}, {@link android.hardware.HardwareBuffer#USAGE_SENSOR_DIRECT_DATA}, {@link android.hardware.HardwareBuffer#USAGE_GPU_CUBE_MAP}, and {@link android.hardware.HardwareBuffer#USAGE_GPU_MIPMAP_COMPLETE}
 * @return A <code>HardwareBuffer</code> instance if successful, or throws an
 *     IllegalArgumentException if the dimensions passed are invalid (either zero, negative, or
 *     too large to allocate), if the format is not supported, if the requested number of layers
 *     is less than one or not supported, or if the passed usage flags are not a supported set.
 
 * This value will never be {@code null}.
 * @apiSince 26
 */

@androidx.annotation.NonNull
public static android.hardware.HardwareBuffer create(int width, int height, int format, int layers, long usage) { throw new RuntimeException("Stub!"); }

/**
 * Queries whether the given buffer description is supported by the system. If this returns
 * true, then the allocation may succeed until resource exhaustion occurs. If this returns
 * false then this combination will never succeed.
 *
 * @param width The width in pixels of the buffer
 * Value is 1 or greater
 * @param height The height in pixels of the buffer
 * Value is 1 or greater
 * @param format The @Format of each pixel
 * Value is {@link android.hardware.HardwareBuffer#RGBA_8888}, {@link android.hardware.HardwareBuffer#RGBA_FP16}, {@link android.hardware.HardwareBuffer#RGBA_1010102}, {@link android.hardware.HardwareBuffer#RGBX_8888}, {@link android.hardware.HardwareBuffer#RGB_888}, {@link android.hardware.HardwareBuffer#RGB_565}, {@link android.hardware.HardwareBuffer#BLOB}, {@link android.hardware.HardwareBuffer#D_16}, {@link android.hardware.HardwareBuffer#D_24}, {@link android.hardware.HardwareBuffer#DS_24UI8}, {@link android.hardware.HardwareBuffer#D_FP32}, {@link android.hardware.HardwareBuffer#DS_FP32UI8}, or {@link android.hardware.HardwareBuffer#S_UI8}
 * @param layers The number of layers in the buffer
 * Value is 1 or greater
 * @param usage The @Usage flags describing how the buffer will be used
 * Value is either <code>0</code> or a combination of {@link android.hardware.HardwareBuffer#USAGE_CPU_READ_RARELY}, {@link android.hardware.HardwareBuffer#USAGE_CPU_READ_OFTEN}, {@link android.hardware.HardwareBuffer#USAGE_CPU_WRITE_RARELY}, {@link android.hardware.HardwareBuffer#USAGE_CPU_WRITE_OFTEN}, {@link android.hardware.HardwareBuffer#USAGE_GPU_SAMPLED_IMAGE}, {@link android.hardware.HardwareBuffer#USAGE_GPU_COLOR_OUTPUT}, {@link android.hardware.HardwareBuffer#USAGE_PROTECTED_CONTENT}, {@link android.hardware.HardwareBuffer#USAGE_VIDEO_ENCODE}, {@link android.hardware.HardwareBuffer#USAGE_GPU_DATA_BUFFER}, {@link android.hardware.HardwareBuffer#USAGE_SENSOR_DIRECT_DATA}, {@link android.hardware.HardwareBuffer#USAGE_GPU_CUBE_MAP}, and {@link android.hardware.HardwareBuffer#USAGE_GPU_MIPMAP_COMPLETE}
 * @return True if the combination is supported, false otherwise.
 * @apiSince 29
 */

public static boolean isSupported(int width, int height, int format, int layers, long usage) { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Returns the width of this buffer in pixels.
 * @apiSince 26
 */

public int getWidth() { throw new RuntimeException("Stub!"); }

/**
 * Returns the height of this buffer in pixels.
 * @apiSince 26
 */

public int getHeight() { throw new RuntimeException("Stub!"); }

/**
 * Returns the @Format of this buffer.
 
 * @return Value is {@link android.hardware.HardwareBuffer#RGBA_8888}, {@link android.hardware.HardwareBuffer#RGBA_FP16}, {@link android.hardware.HardwareBuffer#RGBA_1010102}, {@link android.hardware.HardwareBuffer#RGBX_8888}, {@link android.hardware.HardwareBuffer#RGB_888}, {@link android.hardware.HardwareBuffer#RGB_565}, {@link android.hardware.HardwareBuffer#BLOB}, {@link android.hardware.HardwareBuffer#D_16}, {@link android.hardware.HardwareBuffer#D_24}, {@link android.hardware.HardwareBuffer#DS_24UI8}, {@link android.hardware.HardwareBuffer#D_FP32}, {@link android.hardware.HardwareBuffer#DS_FP32UI8}, or {@link android.hardware.HardwareBuffer#S_UI8}
 * @apiSince 26
 */

public int getFormat() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of layers in this buffer.
 * @apiSince 26
 */

public int getLayers() { throw new RuntimeException("Stub!"); }

/**
 * Returns the usage flags of the usage hints set on this buffer.
 * @apiSince 26
 */

public long getUsage() { throw new RuntimeException("Stub!"); }

/**
 * Destroys this buffer immediately. Calling this method frees up any
 * underlying native resources. After calling this method, this buffer
 * must not be used in any way.
 *
 * @see #isClosed()
 * @apiSince 26
 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether this buffer has been closed. A closed buffer cannot
 * be used in any way: the buffer cannot be written to a parcel, etc.
 *
 * @return True if this <code>HardwareBuffer</code> is in a closed state,
 *         false otherwise.
 *
 * @see #close()
 * @apiSince 26
 */

public boolean isClosed() { throw new RuntimeException("Stub!"); }

/** @apiSince 26 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Flatten this object in to a Parcel.
 *
 * <p>Calling this method will throw an <code>IllegalStateException</code> if
 * {@link #close()} has been previously called.</p>
 *
 * @param dest The Parcel in which the object should be written.
 * @param flags Additional flags about how the object should be written.
 *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
 * @apiSince 26
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Format: opaque format used for raw data transfer; must have a height of 1
 * @apiSince 26
 */

public static final int BLOB = 33; // 0x21

/** @apiSince 26 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.hardware.HardwareBuffer> CREATOR;
static { CREATOR = null; }

/**
 * Format: 24 bits depth, 8 bits stencil
 * @apiSince 28
 */

public static final int DS_24UI8 = 50; // 0x32

/**
 * Format: 32 bits depth, 8 bits stencil
 * @apiSince 28
 */

public static final int DS_FP32UI8 = 52; // 0x34

/**
 * Format: 16 bits depth
 * @apiSince 28
 */

public static final int D_16 = 48; // 0x30

/**
 * Format: 24 bits depth
 * @apiSince 28
 */

public static final int D_24 = 49; // 0x31

/**
 * Format: 32 bits depth
 * @apiSince 28
 */

public static final int D_FP32 = 51; // 0x33

/**
 * Format: 10 bits each red, green, blue, 2 bits alpha
 * @apiSince 26
 */

public static final int RGBA_1010102 = 43; // 0x2b

/**
 * Value is {@link android.hardware.HardwareBuffer#RGBA_8888}, {@link android.hardware.HardwareBuffer#RGBA_FP16}, {@link android.hardware.HardwareBuffer#RGBA_1010102}, {@link android.hardware.HardwareBuffer#RGBX_8888}, {@link android.hardware.HardwareBuffer#RGB_888}, {@link android.hardware.HardwareBuffer#RGB_565}, {@link android.hardware.HardwareBuffer#BLOB}, {@link android.hardware.HardwareBuffer#D_16}, {@link android.hardware.HardwareBuffer#D_24}, {@link android.hardware.HardwareBuffer#DS_24UI8}, {@link android.hardware.HardwareBuffer#D_FP32}, {@link android.hardware.HardwareBuffer#DS_FP32UI8}, or {@link android.hardware.HardwareBuffer#S_UI8}
 * @apiSince 26
 */

public static final int RGBA_8888 = 1; // 0x1

/**
 * Format: 16 bits each red, green, blue, alpha
 * @apiSince 26
 */

public static final int RGBA_FP16 = 22; // 0x16

/**
 * Format: 8 bits each red, green, blue, alpha, alpha is always 0xFF
 * @apiSince 26
 */

public static final int RGBX_8888 = 2; // 0x2

/**
 * Format: 5 bits each red and blue, 6 bits green, no alpha
 * @apiSince 26
 */

public static final int RGB_565 = 4; // 0x4

/**
 * Format: 8 bits each red, green, blue, no alpha
 * @apiSince 26
 */

public static final int RGB_888 = 3; // 0x3

/**
 * Format: 8 bits stencil
 * @apiSince 28
 */

public static final int S_UI8 = 53; // 0x35

/**
 * Usage: The buffer will often be read by the CPU
 * @apiSince 26
 */

public static final long USAGE_CPU_READ_OFTEN = 3L; // 0x3L

/**
 * Value is either <code>0</code> or a combination of {@link android.hardware.HardwareBuffer#USAGE_CPU_READ_RARELY}, {@link android.hardware.HardwareBuffer#USAGE_CPU_READ_OFTEN}, {@link android.hardware.HardwareBuffer#USAGE_CPU_WRITE_RARELY}, {@link android.hardware.HardwareBuffer#USAGE_CPU_WRITE_OFTEN}, {@link android.hardware.HardwareBuffer#USAGE_GPU_SAMPLED_IMAGE}, {@link android.hardware.HardwareBuffer#USAGE_GPU_COLOR_OUTPUT}, {@link android.hardware.HardwareBuffer#USAGE_PROTECTED_CONTENT}, {@link android.hardware.HardwareBuffer#USAGE_VIDEO_ENCODE}, {@link android.hardware.HardwareBuffer#USAGE_GPU_DATA_BUFFER}, {@link android.hardware.HardwareBuffer#USAGE_SENSOR_DIRECT_DATA}, {@link android.hardware.HardwareBuffer#USAGE_GPU_CUBE_MAP}, and {@link android.hardware.HardwareBuffer#USAGE_GPU_MIPMAP_COMPLETE}
 * @apiSince 26
 */

public static final long USAGE_CPU_READ_RARELY = 2L; // 0x2L

/**
 * Usage: The buffer will often be written to by the CPU
 * @apiSince 26
 */

public static final long USAGE_CPU_WRITE_OFTEN = 48L; // 0x30L

/**
 * Usage: The buffer will sometimes be written to by the CPU
 * @apiSince 26
 */

public static final long USAGE_CPU_WRITE_RARELY = 32L; // 0x20L

/**
 * Usage: The buffer will be written to by the GPU
 * @apiSince 26
 */

public static final long USAGE_GPU_COLOR_OUTPUT = 512L; // 0x200L

/**
 * Usage: The buffer will be used as a cube map texture
 * @apiSince 28
 */

public static final long USAGE_GPU_CUBE_MAP = 33554432L; // 0x2000000L

/**
 * Usage: The buffer will be used as a shader storage or uniform buffer object
 * @apiSince 26
 */

public static final long USAGE_GPU_DATA_BUFFER = 16777216L; // 0x1000000L

/**
 * Usage: The buffer contains a complete mipmap hierarchy
 * @apiSince 28
 */

public static final long USAGE_GPU_MIPMAP_COMPLETE = 67108864L; // 0x4000000L

/**
 * Usage: The buffer will be read from by the GPU
 * @apiSince 26
 */

public static final long USAGE_GPU_SAMPLED_IMAGE = 256L; // 0x100L

/**
 * Usage: The buffer must not be used outside of a protected hardware path
 * @apiSince 26
 */

public static final long USAGE_PROTECTED_CONTENT = 16384L; // 0x4000L

/**
 * Usage: The buffer will be used for sensor direct data
 * @apiSince 26
 */

public static final long USAGE_SENSOR_DIRECT_DATA = 8388608L; // 0x800000L

/**
 * Usage: The buffer will be read by a hardware video encoder
 * @apiSince 26
 */

public static final long USAGE_VIDEO_ENCODE = 65536L; // 0x10000L
}

