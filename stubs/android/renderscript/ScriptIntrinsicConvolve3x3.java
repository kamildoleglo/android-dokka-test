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
 * Intrinsic for applying a 3x3 convolve to an allocation.
 *
 * * @apiSince 17
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ScriptIntrinsicConvolve3x3 extends android.renderscript.ScriptIntrinsic {

private ScriptIntrinsicConvolve3x3() { throw new RuntimeException("Stub!"); }

/**
 * Supported elements types are {@link android.renderscript.Element#U8 Element#U8}, {@link android.renderscript.Element#U8_2 Element#U8_2}, {@link android.renderscript.Element#U8_3 Element#U8_3}, {@link android.renderscript.Element#U8_4 Element#U8_4},
 * {@link android.renderscript.Element#F32 Element#F32}, {@link android.renderscript.Element#F32_2 Element#F32_2}, {@link android.renderscript.Element#F32_3 Element#F32_3}, and {@link android.renderscript.Element#F32_4 Element#F32_4}.
 *
 * <p> The default coefficients are:
 * <code>
 * <p> [ 0,  0,  0 ]
 * <p> [ 0,  1,  0 ]
 * <p> [ 0,  0,  0 ]
 * </code>
 *
 * @param rs The RenderScript context
 * @param e Element type for intputs and outputs
 *
 * @return ScriptIntrinsicConvolve3x3
 * @apiSince 17
 */

public static android.renderscript.ScriptIntrinsicConvolve3x3 create(android.renderscript.RenderScript rs, android.renderscript.Element e) { throw new RuntimeException("Stub!"); }

/**
 * Set the input of the 3x3 convolve.
 * Must match the element type supplied during create.
 *
 * @param ain The input allocation.
 * @apiSince 17
 */

public void setInput(android.renderscript.Allocation ain) { throw new RuntimeException("Stub!"); }

/**
 * Set the coefficients for the convolve.
 *
 * <p> The convolve layout is:
 * <code>
 * <p> [ 0,  1,  2 ]
 * <p> [ 3,  4,  5 ]
 * <p> [ 6,  7,  8 ]
 * </code>
 *
 * @param v The array of coefficients to set
 * @apiSince 17
 */

public void setCoefficients(float[] v) { throw new RuntimeException("Stub!"); }

/**
 * Apply the filter to the input and save to the specified
 * allocation.
 *
 * @param aout Output allocation. Must match creation element
 *             type.
 * @apiSince 17
 */

public void forEach(android.renderscript.Allocation aout) { throw new RuntimeException("Stub!"); }

/**
 * Apply the filter to the input and save to the specified
 * allocation.
 *
 * @param aout Output allocation. Must match creation element
 *             type.
 * @param opt LaunchOptions for clipping
 * @apiSince 21
 */

public void forEach(android.renderscript.Allocation aout, android.renderscript.Script.LaunchOptions opt) { throw new RuntimeException("Stub!"); }

/**
 * Get a KernelID for this intrinsic kernel.
 *
 * @return Script.KernelID The KernelID object.
 * @apiSince 17
 */

public android.renderscript.Script.KernelID getKernelID() { throw new RuntimeException("Stub!"); }

/**
 * Get a FieldID for the input field of this intrinsic.
 *
 * @return Script.FieldID The FieldID object.
 * @apiSince 17
 */

public android.renderscript.Script.FieldID getFieldID_Input() { throw new RuntimeException("Stub!"); }
}

