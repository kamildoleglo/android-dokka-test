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
 *
 * Intrinsic for converting RGB to RGBA by using a 3D lookup table.  The
 * incoming r,g,b values are use as normalized x,y,z coordinates into a 3D
 * allocation.  The 8 nearest values are sampled and linearly interpolated.  The
 * result is placed in the output.
 *
 * @apiSince 18
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ScriptIntrinsic3DLUT extends android.renderscript.ScriptIntrinsic {

private ScriptIntrinsic3DLUT() { throw new RuntimeException("Stub!"); }

/**
 * Supported elements types are {@link android.renderscript.Element#U8_4 Element#U8_4}
 *
 * The defaults tables are identity.
 *
 * @param rs The RenderScript context
 * @param e Element type for intputs and outputs
 *
 * @return ScriptIntrinsic3DLUT
 * @apiSince 18
 */

public static android.renderscript.ScriptIntrinsic3DLUT create(android.renderscript.RenderScript rs, android.renderscript.Element e) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link android.renderscript.Allocation} to be used as the lookup table.
 *
 * The lookup table must use the same {@link android.renderscript.Element} as the intrinsic.
 *
 * @apiSince 18
 */

public void setLUT(android.renderscript.Allocation lut) { throw new RuntimeException("Stub!"); }

/**
 * Invoke the kernel and apply the lookup to each cell of ain
 * and copy to aout.
 *
 * @param ain Input allocation
 * @param aout Output allocation
 * @apiSince 18
 */

public void forEach(android.renderscript.Allocation ain, android.renderscript.Allocation aout) { throw new RuntimeException("Stub!"); }

/**
 * Invoke the kernel and apply the lookup to each cell of ain
 * and copy to aout.
 *
 * @param ain Input allocation
 * @param aout Output allocation
 * @param opt Launch options for kernel
 * @apiSince 21
 */

public void forEach(android.renderscript.Allocation ain, android.renderscript.Allocation aout, android.renderscript.Script.LaunchOptions opt) { throw new RuntimeException("Stub!"); }

/**
 * Get a KernelID for this intrinsic kernel.
 *
 * @return Script.KernelID The KernelID object.
 * @apiSince 18
 */

public android.renderscript.Script.KernelID getKernelID() { throw new RuntimeException("Stub!"); }
}

