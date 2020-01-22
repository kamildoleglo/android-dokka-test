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
 * Intrinsic Gausian blur filter. Applies a gaussian blur of the
 * specified radius to all elements of an allocation.
 *
 *
 * * @apiSince 17
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ScriptIntrinsicBlur extends android.renderscript.ScriptIntrinsic {

private ScriptIntrinsicBlur() { throw new RuntimeException("Stub!"); }

/**
 * Create an intrinsic for applying a blur to an allocation. The
 * default radius is 5.0.
 *
 * Supported elements types are {@link android.renderscript.Element#U8 Element#U8},
 * {@link android.renderscript.Element#U8_4 Element#U8_4}.
 *
 * @param rs The RenderScript context
 * @param e Element type for inputs and outputs
 *
 * @return ScriptIntrinsicBlur
 * @apiSince 17
 */

public static android.renderscript.ScriptIntrinsicBlur create(android.renderscript.RenderScript rs, android.renderscript.Element e) { throw new RuntimeException("Stub!"); }

/**
 * Set the input of the blur.
 * Must match the element type supplied during create.
 *
 * @param ain The input allocation
 * @apiSince 17
 */

public void setInput(android.renderscript.Allocation ain) { throw new RuntimeException("Stub!"); }

/**
 * Set the radius of the Blur.
 *
 * Supported range 0 < radius <= 25
 *
 * @param radius The radius of the blur
 * @apiSince 17
 */

public void setRadius(float radius) { throw new RuntimeException("Stub!"); }

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

