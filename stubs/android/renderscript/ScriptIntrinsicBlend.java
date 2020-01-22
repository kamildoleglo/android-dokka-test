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
 * Intrinsic kernels for blending two {@link android.renderscript.Allocation} objects.
 * * @apiSince 17
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ScriptIntrinsicBlend extends android.renderscript.ScriptIntrinsic {

ScriptIntrinsicBlend() { throw new RuntimeException("Stub!"); }

/**
 * Supported elements types are {@link android.renderscript.Element#U8_4 Element#U8_4}
 *
 * @param rs The RenderScript context
 * @param e Element type for inputs and outputs
 *
 * @return ScriptIntrinsicBlend
 * @apiSince 17
 */

public static android.renderscript.ScriptIntrinsicBlend create(android.renderscript.RenderScript rs, android.renderscript.Element e) { throw new RuntimeException("Stub!"); }

/**
 * Sets dst = {0, 0, 0, 0}
 *
 * @param ain The source buffer
 * @param aout The destination buffer
 * @apiSince 17
 */

public void forEachClear(android.renderscript.Allocation ain, android.renderscript.Allocation aout) { throw new RuntimeException("Stub!"); }

/**
 * Sets dst = {0, 0, 0, 0}
 *
 * @param ain The source buffer
 * @param aout The destination buffer
 * @param opt LaunchOptions for clipping
 * @apiSince 21
 */

public void forEachClear(android.renderscript.Allocation ain, android.renderscript.Allocation aout, android.renderscript.Script.LaunchOptions opt) { throw new RuntimeException("Stub!"); }

/**
 * Get a KernelID for the Clear kernel.
 *
 * @return Script.KernelID The KernelID object.
 * @apiSince 17
 */

public android.renderscript.Script.KernelID getKernelIDClear() { throw new RuntimeException("Stub!"); }

/**
 * Sets dst = src
 *
 * @param ain The source buffer
 * @param aout The destination buffer
 * @apiSince 17
 */

public void forEachSrc(android.renderscript.Allocation ain, android.renderscript.Allocation aout) { throw new RuntimeException("Stub!"); }

/**
 * Sets dst = src
 *
 * @param ain The source buffer
 * @param aout The destination buffer
 * @param opt LaunchOptions for clipping
 * @apiSince 21
 */

public void forEachSrc(android.renderscript.Allocation ain, android.renderscript.Allocation aout, android.renderscript.Script.LaunchOptions opt) { throw new RuntimeException("Stub!"); }

/**
 * Get a KernelID for the Src kernel.
 *
 * @return Script.KernelID The KernelID object.
 * @apiSince 17
 */

public android.renderscript.Script.KernelID getKernelIDSrc() { throw new RuntimeException("Stub!"); }

/**
 * Sets dst = dst
 *
 * This is a NOP.
 *
 * @param ain The source buffer
 * @param aout The destination buffer
 * @apiSince 17
 */

public void forEachDst(android.renderscript.Allocation ain, android.renderscript.Allocation aout) { throw new RuntimeException("Stub!"); }

/**
 * Sets dst = dst
 *
 * This is a NOP.
 *
 * @param ain The source buffer
 * @param aout The destination buffer
 * @param opt LaunchOptions for clipping
 * @apiSince 21
 */

public void forEachDst(android.renderscript.Allocation ain, android.renderscript.Allocation aout, android.renderscript.Script.LaunchOptions opt) { throw new RuntimeException("Stub!"); }

/**
 * Get a KernelID for the Dst kernel.
 *
 * @return Script.KernelID The KernelID object.
 * @apiSince 17
 */

public android.renderscript.Script.KernelID getKernelIDDst() { throw new RuntimeException("Stub!"); }

/**
 * Sets dst = src + dst * (1.0 - src.a)
 *
 * @param ain The source buffer
 * @param aout The destination buffer
 * @apiSince 17
 */

public void forEachSrcOver(android.renderscript.Allocation ain, android.renderscript.Allocation aout) { throw new RuntimeException("Stub!"); }

/**
 * Sets dst = src + dst * (1.0 - src.a)
 *
 * @param ain The source buffer
 * @param aout The destination buffer
 * @param opt LaunchOptions for clipping
 * @apiSince 21
 */

public void forEachSrcOver(android.renderscript.Allocation ain, android.renderscript.Allocation aout, android.renderscript.Script.LaunchOptions opt) { throw new RuntimeException("Stub!"); }

/**
 * Get a KernelID for the SrcOver kernel.
 *
 * @return Script.KernelID The KernelID object.
 * @apiSince 17
 */

public android.renderscript.Script.KernelID getKernelIDSrcOver() { throw new RuntimeException("Stub!"); }

/**
 * Sets dst = dst + src * (1.0 - dst.a)
 *
 * @param ain The source buffer
 * @param aout The destination buffer
 * @apiSince 17
 */

public void forEachDstOver(android.renderscript.Allocation ain, android.renderscript.Allocation aout) { throw new RuntimeException("Stub!"); }

/**
 * Sets dst = dst + src * (1.0 - dst.a)
 *
 * @param ain The source buffer
 * @param aout The destination buffer
 * @param opt LaunchOptions for clipping
 * @apiSince 21
 */

public void forEachDstOver(android.renderscript.Allocation ain, android.renderscript.Allocation aout, android.renderscript.Script.LaunchOptions opt) { throw new RuntimeException("Stub!"); }

/**
 * Get a KernelID for the DstOver kernel.
 *
 * @return Script.KernelID The KernelID object.
 * @apiSince 17
 */

public android.renderscript.Script.KernelID getKernelIDDstOver() { throw new RuntimeException("Stub!"); }

/**
 * Sets dst = src * dst.a
 *
 * @param ain The source buffer
 * @param aout The destination buffer
 * @apiSince 17
 */

public void forEachSrcIn(android.renderscript.Allocation ain, android.renderscript.Allocation aout) { throw new RuntimeException("Stub!"); }

/**
 * Sets dst = src * dst.a
 *
 * @param ain The source buffer
 * @param aout The destination buffer
 * @param opt LaunchOptions for clipping
 * @apiSince 21
 */

public void forEachSrcIn(android.renderscript.Allocation ain, android.renderscript.Allocation aout, android.renderscript.Script.LaunchOptions opt) { throw new RuntimeException("Stub!"); }

/**
 * Get a KernelID for the SrcIn kernel.
 *
 * @return Script.KernelID The KernelID object.
 * @apiSince 17
 */

public android.renderscript.Script.KernelID getKernelIDSrcIn() { throw new RuntimeException("Stub!"); }

/**
 * Sets dst = dst * src.a
 *
 * @param ain The source buffer
 * @param aout The destination buffer
 * @apiSince 17
 */

public void forEachDstIn(android.renderscript.Allocation ain, android.renderscript.Allocation aout) { throw new RuntimeException("Stub!"); }

/**
 * Sets dst = dst * src.a
 *
 * @param ain The source buffer
 * @param aout The destination buffer
 * @param opt LaunchOptions for clipping
 * @apiSince 21
 */

public void forEachDstIn(android.renderscript.Allocation ain, android.renderscript.Allocation aout, android.renderscript.Script.LaunchOptions opt) { throw new RuntimeException("Stub!"); }

/**
 * Get a KernelID for the DstIn kernel.
 *
 * @return Script.KernelID The KernelID object.
 * @apiSince 17
 */

public android.renderscript.Script.KernelID getKernelIDDstIn() { throw new RuntimeException("Stub!"); }

/**
 * Sets dst = src * (1.0 - dst.a)
 *
 * @param ain The source buffer
 * @param aout The destination buffer
 * @apiSince 17
 */

public void forEachSrcOut(android.renderscript.Allocation ain, android.renderscript.Allocation aout) { throw new RuntimeException("Stub!"); }

/**
 * Sets dst = src * (1.0 - dst.a)
 *
 * @param ain The source buffer
 * @param aout The destination buffer
 * @param opt LaunchOptions for clipping
 * @apiSince 21
 */

public void forEachSrcOut(android.renderscript.Allocation ain, android.renderscript.Allocation aout, android.renderscript.Script.LaunchOptions opt) { throw new RuntimeException("Stub!"); }

/**
 * Get a KernelID for the SrcOut kernel.
 *
 * @return Script.KernelID The KernelID object.
 * @apiSince 17
 */

public android.renderscript.Script.KernelID getKernelIDSrcOut() { throw new RuntimeException("Stub!"); }

/**
 * Sets dst = dst * (1.0 - src.a)
 *
 * @param ain The source buffer
 * @param aout The destination buffer
 * @apiSince 17
 */

public void forEachDstOut(android.renderscript.Allocation ain, android.renderscript.Allocation aout) { throw new RuntimeException("Stub!"); }

/**
 * Sets dst = dst * (1.0 - src.a)
 *
 * @param ain The source buffer
 * @param aout The destination buffer
 * @param opt LaunchOptions for clipping
 * @apiSince 21
 */

public void forEachDstOut(android.renderscript.Allocation ain, android.renderscript.Allocation aout, android.renderscript.Script.LaunchOptions opt) { throw new RuntimeException("Stub!"); }

/**
 * Get a KernelID for the DstOut kernel.
 *
 * @return Script.KernelID The KernelID object.
 * @apiSince 17
 */

public android.renderscript.Script.KernelID getKernelIDDstOut() { throw new RuntimeException("Stub!"); }

/**
 * dst.rgb = src.rgb * dst.a + (1.0 - src.a) * dst.rgb
 * dst.a = dst.a
 *
 * @param ain The source buffer
 * @param aout The destination buffer
 * @apiSince 17
 */

public void forEachSrcAtop(android.renderscript.Allocation ain, android.renderscript.Allocation aout) { throw new RuntimeException("Stub!"); }

/**
 * dst.rgb = src.rgb * dst.a + (1.0 - src.a) * dst.rgb
 * dst.a = dst.a
 *
 * @param ain The source buffer
 * @param aout The destination buffer
 * @param opt LaunchOptions for clipping
 * @apiSince 21
 */

public void forEachSrcAtop(android.renderscript.Allocation ain, android.renderscript.Allocation aout, android.renderscript.Script.LaunchOptions opt) { throw new RuntimeException("Stub!"); }

/**
 * Get a KernelID for the SrcAtop kernel.
 *
 * @return Script.KernelID The KernelID object.
 * @apiSince 17
 */

public android.renderscript.Script.KernelID getKernelIDSrcAtop() { throw new RuntimeException("Stub!"); }

/**
 * dst = dst.rgb * src.a + (1.0 - dst.a) * src.rgb
 * dst.a = src.a
 * Note: Before API 23, the alpha channel was not correctly set.
 *       Please use with caution when targeting older APIs.
 *
 * @param ain The source buffer
 * @param aout The destination buffer
 * @apiSince 17
 */

public void forEachDstAtop(android.renderscript.Allocation ain, android.renderscript.Allocation aout) { throw new RuntimeException("Stub!"); }

/**
 * dst = dst.rgb * src.a + (1.0 - dst.a) * src.rgb
 * dst.a = src.a
 * Note: Before API 23, the alpha channel was not correctly set.
 *       Please use with caution when targeting older APIs.
 *
 * @param ain The source buffer
 * @param aout The destination buffer
 * @param opt LaunchOptions for clipping
 * @apiSince 21
 */

public void forEachDstAtop(android.renderscript.Allocation ain, android.renderscript.Allocation aout, android.renderscript.Script.LaunchOptions opt) { throw new RuntimeException("Stub!"); }

/**
 * Get a KernelID for the DstAtop kernel.
 *
 * @return Script.KernelID The KernelID object.
 * @apiSince 17
 */

public android.renderscript.Script.KernelID getKernelIDDstAtop() { throw new RuntimeException("Stub!"); }

/**
 * Sets dst = {src.r ^ dst.r, src.g ^ dst.g, src.b ^ dst.b, src.a ^ dst.a}
 *
 * @param ain The source buffer
 * @param aout The destination buffer
 * @apiSince 17
 */

public void forEachXor(android.renderscript.Allocation ain, android.renderscript.Allocation aout) { throw new RuntimeException("Stub!"); }

/**
 * Sets dst = {src.r ^ dst.r, src.g ^ dst.g, src.b ^ dst.b, src.a ^ dst.a}
 *
 * <b>Note:</b> this is NOT the Porter/Duff XOR mode; this is a bitwise xor.
 *
 * @param ain The source buffer
 * @param aout The destination buffer
 * @param opt LaunchOptions for clipping
 * @apiSince 21
 */

public void forEachXor(android.renderscript.Allocation ain, android.renderscript.Allocation aout, android.renderscript.Script.LaunchOptions opt) { throw new RuntimeException("Stub!"); }

/**
 * Get a KernelID for the Xor kernel.
 *
 * @return Script.KernelID The KernelID object.
 * @apiSince 17
 */

public android.renderscript.Script.KernelID getKernelIDXor() { throw new RuntimeException("Stub!"); }

/**
 * Sets dst = src * dst
 *
 * @param ain The source buffer
 * @param aout The destination buffer
 * @apiSince 17
 */

public void forEachMultiply(android.renderscript.Allocation ain, android.renderscript.Allocation aout) { throw new RuntimeException("Stub!"); }

/**
 * Sets dst = src * dst
 *
 * @param ain The source buffer
 * @param aout The destination buffer
 * @param opt LaunchOptions for clipping
 * @apiSince 21
 */

public void forEachMultiply(android.renderscript.Allocation ain, android.renderscript.Allocation aout, android.renderscript.Script.LaunchOptions opt) { throw new RuntimeException("Stub!"); }

/**
 * Get a KernelID for the Multiply kernel.
 *
 * @return Script.KernelID The KernelID object.
 * @apiSince 17
 */

public android.renderscript.Script.KernelID getKernelIDMultiply() { throw new RuntimeException("Stub!"); }

/**
 * Sets dst = min(src + dst, 1.0)
 *
 * @param ain The source buffer
 * @param aout The destination buffer
 * @apiSince 17
 */

public void forEachAdd(android.renderscript.Allocation ain, android.renderscript.Allocation aout) { throw new RuntimeException("Stub!"); }

/**
 * Sets dst = min(src + dst, 1.0)
 *
 * @param ain The source buffer
 * @param aout The destination buffer
 * @param opt LaunchOptions for clipping
 * @apiSince 21
 */

public void forEachAdd(android.renderscript.Allocation ain, android.renderscript.Allocation aout, android.renderscript.Script.LaunchOptions opt) { throw new RuntimeException("Stub!"); }

/**
 * Get a KernelID for the Add kernel.
 *
 * @return Script.KernelID The KernelID object.
 * @apiSince 17
 */

public android.renderscript.Script.KernelID getKernelIDAdd() { throw new RuntimeException("Stub!"); }

/**
 * Sets dst = max(dst - src, 0.0)
 *
 * @param ain The source buffer
 * @param aout The destination buffer
 * @apiSince 17
 */

public void forEachSubtract(android.renderscript.Allocation ain, android.renderscript.Allocation aout) { throw new RuntimeException("Stub!"); }

/**
 * Sets dst = max(dst - src, 0.0)
 *
 * @param ain The source buffer
 * @param aout The destination buffer
 * @param opt LaunchOptions for clipping
 * @apiSince 21
 */

public void forEachSubtract(android.renderscript.Allocation ain, android.renderscript.Allocation aout, android.renderscript.Script.LaunchOptions opt) { throw new RuntimeException("Stub!"); }

/**
 * Get a KernelID for the Subtract kernel.
 *
 * @return Script.KernelID The KernelID object.
 * @apiSince 17
 */

public android.renderscript.Script.KernelID getKernelIDSubtract() { throw new RuntimeException("Stub!"); }
}

