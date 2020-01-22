/*
 * Copyright (C) 2012 The Android Open Source Project
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


package android.renderscript;


/**
 * Intrinsic for applying a color matrix to allocations.
 *
 * If the element type is {@link android.renderscript.Element.DataType#UNSIGNED_8 Element.DataType#UNSIGNED_8},
 * it is converted to {@link android.renderscript.Element.DataType#FLOAT_32 Element.DataType#FLOAT_32} and
 * normalized from (0-255) to (0-1). If the incoming vector size
 * is less than four, a {@link android.renderscript.Element#F32_4 Element#F32_4} is created by
 * filling the missing vector channels with zero. This value is
 * then multiplied by the 4x4 color matrix as performed by
 * rsMatrixMultiply(), adding a {@link android.renderscript.Element#F32_4 Element#F32_4}, and then
 * writing it to the output {@link android.renderscript.Allocation Allocation}.
 *
 * If the ouptut type is unsigned, the value is normalized from
 * (0-1) to (0-255) and converted. If the output vector size is
 * less than four, the unused channels are discarded.
 *
 * Supported elements types are {@link android.renderscript.Element#U8 Element#U8}, {@link android.renderscript.Element#U8_2 Element#U8_2}, {@link android.renderscript.Element#U8_3 Element#U8_3}, {@link android.renderscript.Element#U8_4 Element#U8_4},
 * {@link android.renderscript.Element#F32 Element#F32}, {@link android.renderscript.Element#F32_2 Element#F32_2}, {@link android.renderscript.Element#F32_3 Element#F32_3}, and {@link android.renderscript.Element#F32_4 Element#F32_4}.
 * * @apiSince 17
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ScriptIntrinsicColorMatrix extends android.renderscript.ScriptIntrinsic {

private ScriptIntrinsicColorMatrix() { throw new RuntimeException("Stub!"); }

/**
 * Create an intrinsic for applying a color matrix to an
 * allocation.
 *
 * @param rs The RenderScript context
 * @param e Element type for inputs and outputs, As of API 19,
 *          this parameter is ignored. The Element type check is
 *          performed in the kernel launch.
 *
 * @deprecated Use the single argument version as Element is now
 *             ignored.
 *
 * @return ScriptIntrinsicColorMatrix
 * @apiSince 17
 * @deprecatedSince 19
 */

@Deprecated
public static android.renderscript.ScriptIntrinsicColorMatrix create(android.renderscript.RenderScript rs, android.renderscript.Element e) { throw new RuntimeException("Stub!"); }

/**
 * Create an intrinsic for applying a color matrix to an
 * allocation.
 *
 * @param rs The RenderScript context
 *
 * @return ScriptIntrinsicColorMatrix
 * @apiSince 19
 */

public static android.renderscript.ScriptIntrinsicColorMatrix create(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/**
 * Set the color matrix which will be applied to each cell of
 * the image.
 *
 * @param m The 4x4 matrix to set.
 * @apiSince 17
 */

public void setColorMatrix(android.renderscript.Matrix4f m) { throw new RuntimeException("Stub!"); }

/**
 * Set the color matrix which will be applied to each cell of the image.
 * This will set the alpha channel to be a copy.
 *
 * @param m The 3x3 matrix to set.
 * @apiSince 17
 */

public void setColorMatrix(android.renderscript.Matrix3f m) { throw new RuntimeException("Stub!"); }

/**
 * Set the value to be added after the color matrix has been
 * applied. The default value is {0, 0, 0, 0}
 *
 * @param f The float4 value to be added.
 * @apiSince 19
 */

public void setAdd(android.renderscript.Float4 f) { throw new RuntimeException("Stub!"); }

/**
 * Set the value to be added after the color matrix has been
 * applied. The default value is {0, 0, 0, 0}
 *
 * @param r The red add value.
 * @param g The green add value.
 * @param b The blue add value.
 * @param a The alpha add value.
 * @apiSince 19
 */

public void setAdd(float r, float g, float b, float a) { throw new RuntimeException("Stub!"); }

/**
 * Set a color matrix to convert from RGB to luminance. The alpha channel
 * will be a copy.
 *
 * @apiSince 17
 */

public void setGreyscale() { throw new RuntimeException("Stub!"); }

/**
 * Set the matrix to convert from YUV to RGB with a direct copy of the 4th
 * channel.
 *
 * @apiSince 17
 */

public void setYUVtoRGB() { throw new RuntimeException("Stub!"); }

/**
 * Set the matrix to convert from RGB to YUV with a direct copy of the 4th
 * channel.
 *
 * @apiSince 17
 */

public void setRGBtoYUV() { throw new RuntimeException("Stub!"); }

/**
 * Invoke the kernel and apply the matrix to each cell of input
 * {@link android.renderscript.Allocation Allocation} and copy to the output {@link android.renderscript.Allocation Allocation}.
 *
 * If the vector size of the input is less than four, the
 * remaining components are treated as zero for the matrix
 * multiply.
 *
 * If the output vector size is less than four, the unused
 * vector components are discarded.
 *
 *
 * @param ain Input allocation
 * @param aout Output allocation
 * @apiSince 17
 */

public void forEach(android.renderscript.Allocation ain, android.renderscript.Allocation aout) { throw new RuntimeException("Stub!"); }

/**
 * Invoke the kernel and apply the matrix to each cell of input
 * {@link android.renderscript.Allocation Allocation} and copy to the output {@link android.renderscript.Allocation Allocation}.
 *
 * If the vector size of the input is less than four, the
 * remaining components are treated as zero for the matrix
 * multiply.
 *
 * If the output vector size is less than four, the unused
 * vector components are discarded.
 *
 *
 * @param ain Input allocation
 * @param aout Output allocation
 * @param opt LaunchOptions for clipping
 * @apiSince 21
 */

public void forEach(android.renderscript.Allocation ain, android.renderscript.Allocation aout, android.renderscript.Script.LaunchOptions opt) { throw new RuntimeException("Stub!"); }

/**
 * Get a KernelID for this intrinsic kernel.
 *
 * @return Script.KernelID The KernelID object.
 * @apiSince 17
 */

public android.renderscript.Script.KernelID getKernelID() { throw new RuntimeException("Stub!"); }
}

