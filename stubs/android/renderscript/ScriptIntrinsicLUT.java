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
 * Intrinsic for applying a per-channel lookup table. Each
 * channel of the input has an independant lookup table. The
 * tables are 256 entries in size and can cover the full value
 * range of {@link android.renderscript.Element#U8_4 Element#U8_4}.
 * * @apiSince 17
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ScriptIntrinsicLUT extends android.renderscript.ScriptIntrinsic {

private ScriptIntrinsicLUT() { throw new RuntimeException("Stub!"); }

/**
 * Supported elements types are {@link android.renderscript.Element#U8_4 Element#U8_4}
 *
 * The defaults tables are identity.
 *
 * @param rs The RenderScript context
 * @param e Element type for intputs and outputs
 *
 * @return ScriptIntrinsicLUT
 * @apiSince 17
 */

public static android.renderscript.ScriptIntrinsicLUT create(android.renderscript.RenderScript rs, android.renderscript.Element e) { throw new RuntimeException("Stub!"); }

/** @apiSince 17 */

public void destroy() { throw new RuntimeException("Stub!"); }

/**
 * Set an entry in the red channel lookup table
 *
 * @param index Must be 0-255
 * @param value Must be 0-255
 * @apiSince 17
 */

public void setRed(int index, int value) { throw new RuntimeException("Stub!"); }

/**
 * Set an entry in the green channel lookup table
 *
 * @param index Must be 0-255
 * @param value Must be 0-255
 * @apiSince 17
 */

public void setGreen(int index, int value) { throw new RuntimeException("Stub!"); }

/**
 * Set an entry in the blue channel lookup table
 *
 * @param index Must be 0-255
 * @param value Must be 0-255
 * @apiSince 17
 */

public void setBlue(int index, int value) { throw new RuntimeException("Stub!"); }

/**
 * Set an entry in the alpha channel lookup table
 *
 * @param index Must be 0-255
 * @param value Must be 0-255
 * @apiSince 17
 */

public void setAlpha(int index, int value) { throw new RuntimeException("Stub!"); }

/**
 * Invoke the kernel and apply the lookup to each cell of ain
 * and copy to aout.
 *
 * @param ain Input allocation
 * @param aout Output allocation
 * @apiSince 17
 */

public void forEach(android.renderscript.Allocation ain, android.renderscript.Allocation aout) { throw new RuntimeException("Stub!"); }

/**
 * Invoke the kernel and apply the lookup to each cell of ain
 * and copy to aout.
 *
 * @param ain Input allocation
 * @param aout Output allocation
 * @param opt Options for clipping
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

