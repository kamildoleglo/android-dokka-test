/*
 * Copyright (C) 2008-2012 The Android Open Source Project
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

import android.graphics.Bitmap;
import java.nio.ByteBuffer;
import android.view.Surface;

/**
 * <p> This class provides the primary method through which data is passed to
 * and from RenderScript kernels.  An Allocation provides the backing store for
 * a given {@link android.renderscript.Type}.  </p>
 *
 * <p>An Allocation also contains a set of usage flags that denote how the
 * Allocation could be used. For example, an Allocation may have usage flags
 * specifying that it can be used from a script as well as input to a {@link
 * android.renderscript.Sampler}. A developer must synchronize across these
 * different usages using {@link android.renderscript.Allocation#syncAll} in
 * order to ensure that different users of the Allocation have a consistent view
 * of memory. For example, in the case where an Allocation is used as the output
 * of one kernel and as Sampler input in a later kernel, a developer must call
 * {@link #syncAll syncAll(Allocation.USAGE_SCRIPT)} prior to launching the
 * second kernel to ensure correctness.
 *
 * <p>An Allocation can be populated with the {@link #copyFrom} routines. For
 * more complex Element types, the {@link #copyFromUnchecked} methods can be
 * used to copy from byte arrays or similar constructs.</p>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about creating an application that uses RenderScript, read the
 * <a href="{@docRoot}guide/topics/renderscript/index.html">RenderScript</a> developer guide.</p>
 * </div>
 * * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Allocation extends android.renderscript.BaseObj {

Allocation() { throw new RuntimeException("Stub!"); }

/**
 * Get the {@link android.renderscript.Element} of the {@link
 * android.renderscript.Type} of the Allocation.
 *
 * @return Element
 *
 * @apiSince 16
 */

public android.renderscript.Element getElement() { throw new RuntimeException("Stub!"); }

/**
 * Get the usage flags of the Allocation.
 *
 * @return usage this Allocation's set of the USAGE_* flags OR'd together
 *
 * @apiSince 16
 */

public int getUsage() { throw new RuntimeException("Stub!"); }

/**
 * Specifies the mapping between the Allocation's cells and an array's elements
 * when data is copied from the Allocation to the array, or vice-versa.
 *
 * Only applies to an Allocation whose Element is a vector of length 3 (such as
 * {@link android.renderscript.Element#U8_3 Element#U8_3} or {@link android.renderscript.Element#RGB_888 Element#RGB_888}). Enabling this feature may make
 * copying data from the Allocation to an array or vice-versa less efficient.
 *
 * <p> Vec3 Element cells are stored in an Allocation as Vec4 Element cells with
 * the same {@link android.renderscript.Element.DataType}, with the fourth vector
 * component treated as padding. When this feature is enabled, only the data components,
 * i.e. the first 3 vector components of each cell, will be mapped between the array
 * and the Allocation. When disabled, explicit mapping of the padding components
 * is required, as described in the following example.
 *
 * <p> For example, when copying an integer array to an Allocation of two {@link android.renderscript.Element#I32_3 Element#I32_3} cells using {@link #copyFrom(int[])}:
 * <p> When disabled:
 *     The array must have at least 8 integers, with the first 4 integers copied
 *     to the first cell of the Allocation, and the next 4 integers copied to
 *     the second cell. The 4th and 8th integers are mapped as the padding components.
 *
 * <p> When enabled:
 *     The array just needs to have at least 6 integers, with the first 3 integers
 *     copied to the the first cell as data components, and the next 3 copied to
 *     the second cell. There is no mapping for the padding components.
 *
 * <p> Similarly, when copying a byte array to an Allocation of two {@link android.renderscript.Element#I32_3 Element#I32_3} cells, using {@link #copyFromUnchecked(int[])}:
 * <p> When disabled:
 *     The array must have at least 32 bytes, with the first 16 bytes copied
 *     to the first cell of the Allocation, and the next 16 bytes copied to
 *     the second cell. The 13th-16th and 29th-32nd bytes are mapped as padding
 *     components.
 *
 * <p> When enabled:
 *     The array just needs to have at least 24 bytes, with the first 12 bytes copied
 *     to the first cell of the Allocation, and the next 12 bytes copied to
 *     the second cell. There is no mapping for the padding components.
 *
 * <p> Similar to copying data to an Allocation from an array, when copying data from an
 * Allocation to an array, the padding components for Vec3 Element cells will not be
 * copied/mapped to the array if AutoPadding is enabled.
 *
 * <p> Default: Disabled.
 *
 * @param useAutoPadding True: enable AutoPadding; False: disable AutoPadding
 *
 * @apiSince 23
 */

public void setAutoPadding(boolean useAutoPadding) { throw new RuntimeException("Stub!"); }

/**
 * Get the size of the Allocation in bytes.
 *
 * @return size of the Allocation in bytes.
 *
 * @apiSince 16
 */

public int getBytesSize() { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Get the {@link android.renderscript.Type} of the Allocation.
 *
 * @return Type
 *
 * @apiSince 11
 */

public android.renderscript.Type getType() { throw new RuntimeException("Stub!"); }

/**
 * Propagate changes from one usage of the Allocation to the
 * other usages of the Allocation.
 *
 * @apiSince 11
 */

public void syncAll(int srcLocation) { throw new RuntimeException("Stub!"); }

/**
 * Send a buffer to the output stream.  The contents of the Allocation will
 * be undefined after this operation. This operation is only valid if {@link
 * #USAGE_IO_OUTPUT} is set on the Allocation.
 *
 *
 * @apiSince 16
 */

public void ioSend() { throw new RuntimeException("Stub!"); }

/**
 * Receive the latest input into the Allocation. This operation
 * is only valid if {@link #USAGE_IO_INPUT} is set on the Allocation.
 *
 * @apiSince 16
 */

public void ioReceive() { throw new RuntimeException("Stub!"); }

/**
 * Copy an array of RS objects to the Allocation.
 *
 * @param d Source array.
 * @apiSince 11
 */

public void copyFrom(android.renderscript.BaseObj[] d) { throw new RuntimeException("Stub!"); }

/**
 * Copy into this Allocation from an array. This method does not guarantee
 * that the Allocation is compatible with the input buffer; it copies memory
 * without reinterpretation.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the Allocation {@link
 * #getBytesSize getBytesSize()}.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the Allocation {@link #getBytesSize getBytesSize()}. The padding bytes for
 * the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the Allocation {@link #getBytesSize getBytesSize()}. The padding bytes for
 * the cells must not be part of the array.
 *
 * @param array The source array
 * @apiSince 21
 */

public void copyFromUnchecked(java.lang.Object array) { throw new RuntimeException("Stub!"); }

/**
 * Copy into this Allocation from an array. This method does not guarantee
 * that the Allocation is compatible with the input buffer; it copies memory
 * without reinterpretation.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the Allocation {@link
 * #getBytesSize getBytesSize()}.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the Allocation {@link #getBytesSize getBytesSize()}. The padding bytes for
 * the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the Allocation {@link #getBytesSize getBytesSize()}. The padding bytes for
 * the cells must not be part of the array.
 *
 * @param d the source array
 * @apiSince 11
 */

public void copyFromUnchecked(int[] d) { throw new RuntimeException("Stub!"); }

/**
 * Copy into this Allocation from an array. This method does not guarantee
 * that the Allocation is compatible with the input buffer; it copies memory
 * without reinterpretation.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the Allocation {@link
 * #getBytesSize getBytesSize()}.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the Allocation {@link #getBytesSize getBytesSize()}. The padding bytes for
 * the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the Allocation {@link #getBytesSize getBytesSize()}. The padding bytes for
 * the cells must not be part of the array.
 *
 * @param d the source array
 * @apiSince 11
 */

public void copyFromUnchecked(short[] d) { throw new RuntimeException("Stub!"); }

/**
 * Copy into this Allocation from an array. This method does not guarantee
 * that the Allocation is compatible with the input buffer; it copies memory
 * without reinterpretation.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the Allocation {@link
 * #getBytesSize getBytesSize()}.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the Allocation {@link #getBytesSize getBytesSize()}. The padding bytes for
 * the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the Allocation {@link #getBytesSize getBytesSize()}. The padding bytes for
 * the cells must not be part of the array.
 *
 * @param d the source array
 * @apiSince 11
 */

public void copyFromUnchecked(byte[] d) { throw new RuntimeException("Stub!"); }

/**
 * Copy into this Allocation from an array. This method does not guarantee
 * that the Allocation is compatible with the input buffer; it copies memory
 * without reinterpretation.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the Allocation {@link
 * #getBytesSize getBytesSize()}.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the Allocation {@link #getBytesSize getBytesSize()}. The padding bytes for
 * the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the Allocation {@link #getBytesSize getBytesSize()}. The padding bytes for
 * the cells must not be part of the array.
 *
 * @param d the source array
 * @apiSince 11
 */

public void copyFromUnchecked(float[] d) { throw new RuntimeException("Stub!"); }

/**
 * Copy into this Allocation from an array.  This variant is type checked
 * and will generate exceptions if the Allocation's {@link
 * android.renderscript.Element} does not match the array's
 * primitive type.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the Allocation {@link
 * #getBytesSize getBytesSize()}.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the Allocation {@link #getBytesSize getBytesSize()}. The padding bytes for
 * the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the Allocation {@link #getBytesSize getBytesSize()}. The padding bytes for
 * the cells must not be part of the array.
 *
 * @param array The source array
 * @apiSince 21
 */

public void copyFrom(java.lang.Object array) { throw new RuntimeException("Stub!"); }

/**
 * Copy into this Allocation from an array.  This variant is type checked
 * and will generate exceptions if the Allocation's {@link
 * android.renderscript.Element} is not a 32 bit integer nor a vector of 32 bit
 * integers {@link android.renderscript.Element.DataType}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the Allocation {@link
 * #getBytesSize getBytesSize()}.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the Allocation {@link #getBytesSize getBytesSize()}. The padding bytes for
 * the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the Allocation {@link #getBytesSize getBytesSize()}. The padding bytes for
 * the cells must not be part of the array.
 *
 * @param d the source array
 * @apiSince 11
 */

public void copyFrom(int[] d) { throw new RuntimeException("Stub!"); }

/**
 * Copy into this Allocation from an array.  This variant is type checked
 * and will generate exceptions if the Allocation's {@link
 * android.renderscript.Element} is not a 16 bit integer nor a vector of 16 bit
 * integers {@link android.renderscript.Element.DataType}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the Allocation {@link
 * #getBytesSize getBytesSize()}.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the Allocation {@link #getBytesSize getBytesSize()}. The padding bytes for
 * the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the Allocation {@link #getBytesSize getBytesSize()}. The padding bytes for
 * the cells must not be part of the array.
 *
 * @param d the source array
 * @apiSince 11
 */

public void copyFrom(short[] d) { throw new RuntimeException("Stub!"); }

/**
 * Copy into this Allocation from an array.  This variant is type checked
 * and will generate exceptions if the Allocation's {@link
 * android.renderscript.Element} is not an 8 bit integer nor a vector of 8 bit
 * integers {@link android.renderscript.Element.DataType}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the Allocation {@link
 * #getBytesSize getBytesSize()}.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the Allocation {@link #getBytesSize getBytesSize()}. The padding bytes for
 * the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the Allocation {@link #getBytesSize getBytesSize()}. The padding bytes for
 * the cells must not be part of the array.
 *
 * @param d the source array
 * @apiSince 11
 */

public void copyFrom(byte[] d) { throw new RuntimeException("Stub!"); }

/**
 * Copy into this Allocation from an array.  This variant is type checked
 * and will generate exceptions if the Allocation's {@link
 * android.renderscript.Element} is neither a 32 bit float nor a vector of
 * 32 bit floats {@link android.renderscript.Element.DataType}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the Allocation {@link
 * #getBytesSize getBytesSize()}.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the Allocation {@link #getBytesSize getBytesSize()}. The padding bytes for
 * the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the Allocation {@link #getBytesSize getBytesSize()}. The padding bytes for
 * the cells must not be part of the array.
 *
 * @param d the source array
 * @apiSince 11
 */

public void copyFrom(float[] d) { throw new RuntimeException("Stub!"); }

/**
 * Copy into an Allocation from a {@link android.graphics.Bitmap}.  The
 * height, width, and format of the bitmap must match the existing
 * allocation.
 *
 * <p>If the {@link android.graphics.Bitmap} is the same as the {@link
 * android.graphics.Bitmap} used to create the Allocation with {@link
 * #createFromBitmap} and {@link #USAGE_SHARED} is set on the Allocation,
 * this will synchronize the Allocation with the latest data from the {@link
 * android.graphics.Bitmap}, potentially avoiding the actual copy.</p>
 *
 * @param b the source bitmap
 * @apiSince 11
 */

public void copyFrom(android.graphics.Bitmap b) { throw new RuntimeException("Stub!"); }

/**
 * Copy an Allocation from an Allocation.  The types of both allocations
 * must be identical.
 *
 * @param a the source allocation
 * @apiSince 18
 */

public void copyFrom(android.renderscript.Allocation a) { throw new RuntimeException("Stub!"); }

/**
 * This is only intended to be used by auto-generated code reflected from
 * the RenderScript script files and should not be used by developers.
 *
 * @param xoff
 * @param fp
 * @apiSince 11
 */

public void setFromFieldPacker(int xoff, android.renderscript.FieldPacker fp) { throw new RuntimeException("Stub!"); }

/**
 * This is only intended to be used by auto-generated code reflected from
 * the RenderScript script files and should not be used by developers.
 *
 * @param xoff
 * @param component_number
 * @param fp
 * @apiSince 11
 */

public void setFromFieldPacker(int xoff, int component_number, android.renderscript.FieldPacker fp) { throw new RuntimeException("Stub!"); }

/**
 * This is only intended to be used by auto-generated code reflected from
 * the RenderScript script files and should not be used by developers.
 *
 * @param xoff
 * @param yoff
 * @param zoff
 * @param component_number
 * @param fp
 * @apiSince 23
 */

public void setFromFieldPacker(int xoff, int yoff, int zoff, int component_number, android.renderscript.FieldPacker fp) { throw new RuntimeException("Stub!"); }

/**
 * Generate a mipmap chain. This is only valid if the Type of the Allocation
 * includes mipmaps.
 *
 * <p>This function will generate a complete set of mipmaps from the top
 * level LOD and place them into the script memory space.</p>
 *
 * <p>If the Allocation is also using other memory spaces, a call to {@link
 * #syncAll syncAll(Allocation.USAGE_SCRIPT)} is required.</p>
 * @apiSince 11
 */

public void generateMipmaps() { throw new RuntimeException("Stub!"); }

/**
 * Copy an array into a 1D region of this Allocation.  This method does not
 * guarantee that the Allocation is compatible with the input buffer.
 *
 * <p> The size of the region is: count * {@link #getElement}.{@link android.renderscript.Element#getBytesSize Element#getBytesSize}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the region.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the region. The padding bytes for the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the region. The padding bytes for the cells must not be part of the array.
 *
 * @param off The offset of the first element to be copied.
 * @param count The number of elements to be copied.
 * @param array The source array
 * @apiSince 21
 */

public void copy1DRangeFromUnchecked(int off, int count, java.lang.Object array) { throw new RuntimeException("Stub!"); }

/**
 * Copy an array into a 1D region of this Allocation.  This method does not
 * guarantee that the Allocation is compatible with the input buffer.
 *
 * <p> The size of the region is: count * {@link #getElement}.{@link android.renderscript.Element#getBytesSize Element#getBytesSize}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the region.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the region. The padding bytes for the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the region. The padding bytes for the cells must not be part of the array.
 *
 * @param off The offset of the first element to be copied.
 * @param count The number of elements to be copied.
 * @param d the source array
 * @apiSince 11
 */

public void copy1DRangeFromUnchecked(int off, int count, int[] d) { throw new RuntimeException("Stub!"); }

/**
 * Copy an array into a 1D region of this Allocation.  This method does not
 * guarantee that the Allocation is compatible with the input buffer.
 *
 * <p> The size of the region is: count * {@link #getElement}.{@link android.renderscript.Element#getBytesSize Element#getBytesSize}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the region.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the region. The padding bytes for the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the region. The padding bytes for the cells must not be part of the array.
 *
 * @param off The offset of the first element to be copied.
 * @param count The number of elements to be copied.
 * @param d the source array
 * @apiSince 11
 */

public void copy1DRangeFromUnchecked(int off, int count, short[] d) { throw new RuntimeException("Stub!"); }

/**
 * Copy an array into a 1D region of this Allocation.  This method does not
 * guarantee that the Allocation is compatible with the input buffer.
 *
 * <p> The size of the region is: count * {@link #getElement}.{@link android.renderscript.Element#getBytesSize Element#getBytesSize}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the region.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the region. The padding bytes for the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the region. The padding bytes for the cells must not be part of the array.
 *
 * @param off The offset of the first element to be copied.
 * @param count The number of elements to be copied.
 * @param d the source array
 * @apiSince 11
 */

public void copy1DRangeFromUnchecked(int off, int count, byte[] d) { throw new RuntimeException("Stub!"); }

/**
 * Copy an array into a 1D region of this Allocation.  This method does not
 * guarantee that the Allocation is compatible with the input buffer.
 *
 * <p> The size of the region is: count * {@link #getElement}.{@link android.renderscript.Element#getBytesSize Element#getBytesSize}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the region.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the region. The padding bytes for the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the region. The padding bytes for the cells must not be part of the array.
 *
 * @param off The offset of the first element to be copied.
 * @param count The number of elements to be copied.
 * @param d the source array
 * @apiSince 11
 */

public void copy1DRangeFromUnchecked(int off, int count, float[] d) { throw new RuntimeException("Stub!"); }

/**
 * Copy an array into a 1D region of this Allocation.  This variant is type checked
 * and will generate exceptions if the Allocation's {@link
 * android.renderscript.Element} does not match the component type
 * of the array passed in.
 *
 * <p> The size of the region is: count * {@link #getElement}.{@link android.renderscript.Element#getBytesSize Element#getBytesSize}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the region.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the region. The padding bytes for the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the region. The padding bytes for the cells must not be part of the array.
 *
 * @param off The offset of the first element to be copied.
 * @param count The number of elements to be copied.
 * @param array The source array.
 * @apiSince 21
 */

public void copy1DRangeFrom(int off, int count, java.lang.Object array) { throw new RuntimeException("Stub!"); }

/**
 * Copy an array into a 1D region of this Allocation.  This variant is type checked
 * and will generate exceptions if the Allocation's {@link
 * android.renderscript.Element} is not an 32 bit integer nor a vector of 32 bit
 * integers {@link android.renderscript.Element.DataType}.
 *
 * <p> The size of the region is: count * {@link #getElement}.{@link android.renderscript.Element#getBytesSize Element#getBytesSize}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the region.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the region. The padding bytes for the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the region. The padding bytes for the cells must not be part of the array.
 *
 * @param off The offset of the first element to be copied.
 * @param count The number of elements to be copied.
 * @param d the source array
 * @apiSince 11
 */

public void copy1DRangeFrom(int off, int count, int[] d) { throw new RuntimeException("Stub!"); }

/**
 * Copy an array into a 1D region of this Allocation.  This variant is type checked
 * and will generate exceptions if the Allocation's {@link
 * android.renderscript.Element} is not an 16 bit integer nor a vector of 16 bit
 * integers {@link android.renderscript.Element.DataType}.
 *
 * <p> The size of the region is: count * {@link #getElement}.{@link android.renderscript.Element#getBytesSize Element#getBytesSize}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the region.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the region. The padding bytes for the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the region. The padding bytes for the cells must not be part of the array.
 *
 * @param off The offset of the first element to be copied.
 * @param count The number of elements to be copied.
 * @param d the source array
 * @apiSince 11
 */

public void copy1DRangeFrom(int off, int count, short[] d) { throw new RuntimeException("Stub!"); }

/**
 * Copy an array into a 1D region of this Allocation.  This variant is type checked
 * and will generate exceptions if the Allocation's {@link
 * android.renderscript.Element} is not an 8 bit integer nor a vector of 8 bit
 * integers {@link android.renderscript.Element.DataType}.
 *
 * <p> The size of the region is: count * {@link #getElement}.{@link android.renderscript.Element#getBytesSize Element#getBytesSize}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the region.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the region. The padding bytes for the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the region. The padding bytes for the cells must not be part of the array.
 *
 * @param off The offset of the first element to be copied.
 * @param count The number of elements to be copied.
 * @param d the source array
 * @apiSince 11
 */

public void copy1DRangeFrom(int off, int count, byte[] d) { throw new RuntimeException("Stub!"); }

/**
 * Copy an array into a 1D region of this Allocation.  This variant is type checked
 * and will generate exceptions if the Allocation's {@link
 * android.renderscript.Element} is neither a 32 bit float nor a vector of
 * 32 bit floats {@link android.renderscript.Element.DataType}.
 *
 * <p> The size of the region is: count * {@link #getElement}.{@link android.renderscript.Element#getBytesSize Element#getBytesSize}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the region.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the region. The padding bytes for the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the region. The padding bytes for the cells must not be part of the array.
 *
 * @param off The offset of the first element to be copied.
 * @param count The number of elements to be copied.
 * @param d the source array.
 * @apiSince 11
 */

public void copy1DRangeFrom(int off, int count, float[] d) { throw new RuntimeException("Stub!"); }

/**
 * Copy part of an Allocation into this Allocation.
 *
 * @param off The offset of the first element to be copied.
 * @param count The number of elements to be copied.
 * @param data the source data allocation.
 * @param dataOff off The offset of the first element in data to
 *          be copied.
 * @apiSince 14
 */

public void copy1DRangeFrom(int off, int count, android.renderscript.Allocation data, int dataOff) { throw new RuntimeException("Stub!"); }

/**
 * Copy from an array into a rectangular region in this Allocation.  The
 * array is assumed to be tightly packed. This variant is type checked
 * and will generate exceptions if the Allocation's {@link
 * android.renderscript.Element} does not match the input data type.
 *
 * <p> The size of the region is: w * h * {@link #getElement}.{@link android.renderscript.Element#getBytesSize Element#getBytesSize}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the region.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the region. The padding bytes for the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the region. The padding bytes for the cells must not be part of the array.
 *
 * @param xoff X offset of the region to update in this Allocation
 * @param yoff Y offset of the region to update in this Allocation
 * @param w Width of the region to update
 * @param h Height of the region to update
 * @param array Data to be placed into the Allocation
 * @apiSince 21
 */

public void copy2DRangeFrom(int xoff, int yoff, int w, int h, java.lang.Object array) { throw new RuntimeException("Stub!"); }

/**
 * Copy from an array into a rectangular region in this Allocation.  The
 * array is assumed to be tightly packed. This variant is type checked
 * and will generate exceptions if the Allocation's {@link
 * android.renderscript.Element} is not an 8 bit integer nor a vector of 8 bit
 * integers {@link android.renderscript.Element.DataType}.
 *
 * <p> The size of the region is: w * h * {@link #getElement}.{@link android.renderscript.Element#getBytesSize Element#getBytesSize}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the region.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the region. The padding bytes for the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the region. The padding bytes for the cells must not be part of the array.
 *
 * @param xoff X offset of the region to update in this Allocation
 * @param yoff Y offset of the region to update in this Allocation
 * @param w Width of the region to update
 * @param h Height of the region to update
 * @param data to be placed into the Allocation
 * @apiSince 11
 */

public void copy2DRangeFrom(int xoff, int yoff, int w, int h, byte[] data) { throw new RuntimeException("Stub!"); }

/**
 * Copy from an array into a rectangular region in this Allocation.  The
 * array is assumed to be tightly packed. This variant is type checked
 * and will generate exceptions if the Allocation's {@link
 * android.renderscript.Element} is not a 16 bit integer nor a vector of 16 bit
 * integers {@link android.renderscript.Element.DataType}.
 *
 * <p> The size of the region is: w * h * {@link #getElement}.{@link android.renderscript.Element#getBytesSize Element#getBytesSize}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the region.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the region. The padding bytes for the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the region. The padding bytes for the cells must not be part of the array.
 *
 * @param xoff X offset of the region to update in this Allocation
 * @param yoff Y offset of the region to update in this Allocation
 * @param w Width of the region to update
 * @param h Height of the region to update
 * @param data to be placed into the Allocation
 * @apiSince 11
 */

public void copy2DRangeFrom(int xoff, int yoff, int w, int h, short[] data) { throw new RuntimeException("Stub!"); }

/**
 * Copy from an array into a rectangular region in this Allocation.  The
 * array is assumed to be tightly packed. This variant is type checked
 * and will generate exceptions if the Allocation's {@link
 * android.renderscript.Element} is not a 32 bit integer nor a vector of 32 bit
 * integers {@link android.renderscript.Element.DataType}.
 *
 * <p> The size of the region is: w * h * {@link #getElement}.{@link android.renderscript.Element#getBytesSize Element#getBytesSize}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the region.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the region. The padding bytes for the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the region. The padding bytes for the cells must not be part of the array.
 *
 * @param xoff X offset of the region to update in this Allocation
 * @param yoff Y offset of the region to update in this Allocation
 * @param w Width of the region to update
 * @param h Height of the region to update
 * @param data to be placed into the Allocation
 * @apiSince 11
 */

public void copy2DRangeFrom(int xoff, int yoff, int w, int h, int[] data) { throw new RuntimeException("Stub!"); }

/**
 * Copy from an array into a rectangular region in this Allocation.  The
 * array is assumed to be tightly packed. This variant is type checked
 * and will generate exceptions if the Allocation's {@link
 * android.renderscript.Element} is neither a 32 bit float nor a vector of
 * 32 bit floats {@link android.renderscript.Element.DataType}.
 *
 * <p> The size of the region is: w * h * {@link #getElement}.{@link android.renderscript.Element#getBytesSize Element#getBytesSize}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the region.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the region. The padding bytes for the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the region. The padding bytes for the cells must not be part of the array.
 *
 * @param xoff X offset of the region to update in this Allocation
 * @param yoff Y offset of the region to update in this Allocation
 * @param w Width of the region to update
 * @param h Height of the region to update
 * @param data to be placed into the Allocation
 * @apiSince 11
 */

public void copy2DRangeFrom(int xoff, int yoff, int w, int h, float[] data) { throw new RuntimeException("Stub!"); }

/**
 * Copy a rectangular region from an Allocation into a rectangular region in
 * this Allocation.
 *
 * @param xoff X offset of the region in this Allocation
 * @param yoff Y offset of the region in this Allocation
 * @param w Width of the region to update.
 * @param h Height of the region to update.
 * @param data source Allocation.
 * @param dataXoff X offset in source Allocation
 * @param dataYoff Y offset in source Allocation
 * @apiSince 14
 */

public void copy2DRangeFrom(int xoff, int yoff, int w, int h, android.renderscript.Allocation data, int dataXoff, int dataYoff) { throw new RuntimeException("Stub!"); }

/**
 * Copy a {@link android.graphics.Bitmap} into an Allocation.  The height
 * and width of the update will use the height and width of the {@link
 * android.graphics.Bitmap}.
 *
 * @param xoff X offset of the region to update in this Allocation
 * @param yoff Y offset of the region to update in this Allocation
 * @param data the Bitmap to be copied
 * @apiSince 11
 */

public void copy2DRangeFrom(int xoff, int yoff, android.graphics.Bitmap data) { throw new RuntimeException("Stub!"); }

/**
 * Copy from an array into a 3D region in this Allocation.  The
 * array is assumed to be tightly packed. This variant is type checked
 * and will generate exceptions if the Allocation's {@link
 * android.renderscript.Element} does not match the input data type.
 *
 * <p> The size of the region is: w * h * d * {@link #getElement}.{@link android.renderscript.Element#getBytesSize Element#getBytesSize}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the region.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the region. The padding bytes for the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the region. The padding bytes for the cells must not be part of the array.
 *
 * @param xoff X offset of the region to update in this Allocation
 * @param yoff Y offset of the region to update in this Allocation
 * @param zoff Z offset of the region to update in this Allocation
 * @param w Width of the region to update
 * @param h Height of the region to update
 * @param d Depth of the region to update
 * @param array to be placed into the allocation
 * @apiSince 23
 */

public void copy3DRangeFrom(int xoff, int yoff, int zoff, int w, int h, int d, java.lang.Object array) { throw new RuntimeException("Stub!"); }

/**
 * Copy a rectangular region into the allocation from another
 * allocation.
 *
 * @param xoff X offset of the region to update in this Allocation
 * @param yoff Y offset of the region to update in this Allocation
 * @param zoff Z offset of the region to update in this Allocation
 * @param w Width of the region to update.
 * @param h Height of the region to update.
 * @param d Depth of the region to update.
 * @param data source allocation.
 * @param dataXoff X offset of the region in the source Allocation
 * @param dataYoff Y offset of the region in the source Allocation
 * @param dataZoff Z offset of the region in the source Allocation
 * @apiSince 23
 */

public void copy3DRangeFrom(int xoff, int yoff, int zoff, int w, int h, int d, android.renderscript.Allocation data, int dataXoff, int dataYoff, int dataZoff) { throw new RuntimeException("Stub!"); }

/**
 * Copy from the Allocation into a {@link android.graphics.Bitmap}.  The
 * bitmap must match the dimensions of the Allocation.
 *
 * @param b The bitmap to be set from the Allocation.
 * @apiSince 11
 */

public void copyTo(android.graphics.Bitmap b) { throw new RuntimeException("Stub!"); }

/**
 * Copy from the Allocation into an array. The method is type checked
 * and will generate exceptions if the Allocation's {@link
 * android.renderscript.Element} does not match the input data type.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the Allocation {@link
 * #getBytesSize getBytesSize()}.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the Allocation {@link #getBytesSize getBytesSize()}. The padding bytes for
 * the cells will be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the Allocation {@link #getBytesSize getBytesSize()}. The padding bytes for
 * the cells must not be part of the array.
 *
 * @param array The array to be set from the Allocation.
 * @apiSince 21
 */

public void copyTo(java.lang.Object array) { throw new RuntimeException("Stub!"); }

/**
 * Copy from the Allocation into a byte array. This variant is type checked
 * and will generate exceptions if the Allocation's {@link
 * android.renderscript.Element} is neither an 8 bit integer nor a vector of 8 bit
 * integers {@link android.renderscript.Element.DataType}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the Allocation {@link
 * #getBytesSize getBytesSize()}.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the Allocation {@link #getBytesSize getBytesSize()}. The padding bytes for
 * the cells will be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the Allocation {@link #getBytesSize getBytesSize()}. The padding bytes for
 * the cells must not be part of the array.
 *
 * @param d The array to be set from the Allocation.
 * @apiSince 11
 */

public void copyTo(byte[] d) { throw new RuntimeException("Stub!"); }

/**
 * Copy from the Allocation into a short array. This variant is type checked
 * and will generate exceptions if the Allocation's {@link
 * android.renderscript.Element} is not a 16 bit integer nor a vector of 16 bit
 * integers {@link android.renderscript.Element.DataType}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the Allocation {@link
 * #getBytesSize getBytesSize()}.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the Allocation {@link #getBytesSize getBytesSize()}. The padding bytes for
 * the cells will be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the Allocation {@link #getBytesSize getBytesSize()}. The padding bytes for
 * the cells must not be part of the array.
 *
 * @param d The array to be set from the Allocation.
 * @apiSince 11
 */

public void copyTo(short[] d) { throw new RuntimeException("Stub!"); }

/**
 * Copy from the Allocation into a int array. This variant is type checked
 * and will generate exceptions if the Allocation's {@link
 * android.renderscript.Element} is not a 32 bit integer nor a vector of 32 bit
 * integers {@link android.renderscript.Element.DataType}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the Allocation {@link
 * #getBytesSize getBytesSize()}.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the Allocation {@link #getBytesSize getBytesSize()}. The padding bytes for
 * the cells will be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the Allocation {@link #getBytesSize getBytesSize()}. The padding bytes for
 * the cells must not be part of the array.
 *
 * @param d The array to be set from the Allocation.
 * @apiSince 11
 */

public void copyTo(int[] d) { throw new RuntimeException("Stub!"); }

/**
 * Copy from the Allocation into a float array. This variant is type checked
 * and will generate exceptions if the Allocation's {@link
 * android.renderscript.Element} is neither a 32 bit float nor a vector of
 * 32 bit floats {@link android.renderscript.Element.DataType}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the Allocation {@link
 * #getBytesSize getBytesSize()}.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the Allocation {@link #getBytesSize getBytesSize()}. The padding bytes for
 * the cells will be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the Allocation {@link #getBytesSize getBytesSize()}. The padding bytes for
 * the cells must not be part of the array.
 *
 * @param d The array to be set from the Allocation.
 * @apiSince 11
 */

public void copyTo(float[] d) { throw new RuntimeException("Stub!"); }

/**
 * Resize a 1D allocation.  The contents of the allocation are preserved.
 * If new elements are allocated objects are created with null contents and
 * the new region is otherwise undefined.
 *
 * <p>If the new region is smaller the references of any objects outside the
 * new region will be released.</p>
 *
 * <p>A new type will be created with the new dimension.</p>
 *
 * @param dimX The new size of the allocation.
 *
 * @deprecated RenderScript objects should be immutable once created.  The
 * replacement is to create a new allocation and copy the contents. This
 * function will throw an exception if API 21 or higher is used.
 * @apiSince 11
 * @deprecatedSince 18
 */

@Deprecated
public synchronized void resize(int dimX) { throw new RuntimeException("Stub!"); }

/**
 * Copy a 1D region of this Allocation into an array.  This method does not
 * guarantee that the Allocation is compatible with the input buffer.
 *
 * <p> The size of the region is: count * {@link #getElement}.{@link android.renderscript.Element#getBytesSize Element#getBytesSize}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the region.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the region. The padding bytes for the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the region. The padding bytes for the cells must not be part of the array.
 *
 * @param off The offset of the first element to be copied.
 * @param count The number of elements to be copied.
 * @param array The dest array
 * @apiSince 23
 */

public void copy1DRangeToUnchecked(int off, int count, java.lang.Object array) { throw new RuntimeException("Stub!"); }

/**
 * Copy a 1D region of this Allocation into an array.  This method does not
 * guarantee that the Allocation is compatible with the input buffer.
 *
 * <p> The size of the region is: count * {@link #getElement}.{@link android.renderscript.Element#getBytesSize Element#getBytesSize}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the region.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the region. The padding bytes for the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the region. The padding bytes for the cells must not be part of the array.
 *
 * @param off The offset of the first element to be copied.
 * @param count The number of elements to be copied.
 * @param d the source array
 * @apiSince 23
 */

public void copy1DRangeToUnchecked(int off, int count, int[] d) { throw new RuntimeException("Stub!"); }

/**
 * Copy a 1D region of this Allocation into an array.  This method does not
 * guarantee that the Allocation is compatible with the input buffer.
 *
 * <p> The size of the region is: count * {@link #getElement}.{@link android.renderscript.Element#getBytesSize Element#getBytesSize}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the region.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the region. The padding bytes for the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the region. The padding bytes for the cells must not be part of the array.
 *
 * @param off The offset of the first element to be copied.
 * @param count The number of elements to be copied.
 * @param d the source array
 * @apiSince 23
 */

public void copy1DRangeToUnchecked(int off, int count, short[] d) { throw new RuntimeException("Stub!"); }

/**
 * Copy a 1D region of this Allocation into an array.  This method does not
 * guarantee that the Allocation is compatible with the input buffer.
 *
 * <p> The size of the region is: count * {@link #getElement}.{@link android.renderscript.Element#getBytesSize Element#getBytesSize}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the region.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the region. The padding bytes for the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the region. The padding bytes for the cells must not be part of the array.
 *
 * @param off The offset of the first element to be copied.
 * @param count The number of elements to be copied.
 * @param d the source array
 * @apiSince 23
 */

public void copy1DRangeToUnchecked(int off, int count, byte[] d) { throw new RuntimeException("Stub!"); }

/**
 * Copy a 1D region of this Allocation into an array.  This method does not
 * guarantee that the Allocation is compatible with the input buffer.
 *
 * <p> The size of the region is: count * {@link #getElement}.{@link android.renderscript.Element#getBytesSize Element#getBytesSize}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the region.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the region. The padding bytes for the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the region. The padding bytes for the cells must not be part of the array.
 *
 * @param off The offset of the first element to be copied.
 * @param count The number of elements to be copied.
 * @param d the source array
 * @apiSince 23
 */

public void copy1DRangeToUnchecked(int off, int count, float[] d) { throw new RuntimeException("Stub!"); }

/**
 * Copy a 1D region of this Allocation into an array.  This method is type checked
 * and will generate exceptions if the Allocation's {@link
 * android.renderscript.Element} does not match the component type
 * of the array passed in.
 *
 * <p> The size of the region is: count * {@link #getElement}.{@link android.renderscript.Element#getBytesSize Element#getBytesSize}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the region.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the region. The padding bytes for the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the region. The padding bytes for the cells must not be part of the array.
 *
 * @param off The offset of the first element to be copied.
 * @param count The number of elements to be copied.
 * @param array The source array.
 * @apiSince 23
 */

public void copy1DRangeTo(int off, int count, java.lang.Object array) { throw new RuntimeException("Stub!"); }

/**
 * Copy a 1D region of this Allocation into an array. This variant is type checked
 * and will generate exceptions if the Allocation's {@link
 * android.renderscript.Element} is neither a 32 bit integer nor a vector of 32 bit
 * integers {@link android.renderscript.Element.DataType}.
 *
 * <p> The size of the region is: count * {@link #getElement}.{@link android.renderscript.Element#getBytesSize Element#getBytesSize}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the region.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the region. The padding bytes for the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the region. The padding bytes for the cells must not be part of the array.
 *
 * @param off The offset of the first element to be copied.
 * @param count The number of elements to be copied.
 * @param d the source array
 * @apiSince 23
 */

public void copy1DRangeTo(int off, int count, int[] d) { throw new RuntimeException("Stub!"); }

/**
 * Copy a 1D region of this Allocation into an array. This variant is type checked
 * and will generate exceptions if the Allocation's {@link
 * android.renderscript.Element} is neither a 16 bit integer nor a vector of 16 bit
 * integers {@link android.renderscript.Element.DataType}.
 *
 * <p> The size of the region is: count * {@link #getElement}.{@link android.renderscript.Element#getBytesSize Element#getBytesSize}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the region.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the region. The padding bytes for the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the region. The padding bytes for the cells must not be part of the array.
 *
 * @param off The offset of the first element to be copied.
 * @param count The number of elements to be copied.
 * @param d the source array
 * @apiSince 23
 */

public void copy1DRangeTo(int off, int count, short[] d) { throw new RuntimeException("Stub!"); }

/**
 * Copy a 1D region of this Allocation into an array. This variant is type checked
 * and will generate exceptions if the Allocation's {@link
 * android.renderscript.Element} is neither an 8 bit integer nor a vector of 8 bit
 * integers {@link android.renderscript.Element.DataType}.
 *
 * <p> The size of the region is: count * {@link #getElement}.{@link android.renderscript.Element#getBytesSize Element#getBytesSize}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the region.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the region. The padding bytes for the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the region. The padding bytes for the cells must not be part of the array.
 *
 * @param off The offset of the first element to be copied.
 * @param count The number of elements to be copied.
 * @param d the source array
 * @apiSince 23
 */

public void copy1DRangeTo(int off, int count, byte[] d) { throw new RuntimeException("Stub!"); }

/**
 * Copy a 1D region of this Allocation into an array. This variant is type checked
 * and will generate exceptions if the Allocation's {@link
 * android.renderscript.Element} is neither a 32 bit float nor a vector of
 * 32 bit floats {@link android.renderscript.Element.DataType}.
 *
 * <p> The size of the region is: count * {@link #getElement}.{@link android.renderscript.Element#getBytesSize Element#getBytesSize}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the region.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the region. The padding bytes for the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the region. The padding bytes for the cells must not be part of the array.
 *
 * @param off The offset of the first element to be copied.
 * @param count The number of elements to be copied.
 * @param d the source array.
 * @apiSince 23
 */

public void copy1DRangeTo(int off, int count, float[] d) { throw new RuntimeException("Stub!"); }

/**
 * Copy from a rectangular region in this Allocation into an array. This
 * method is type checked and will generate exceptions if the Allocation's
 * {@link android.renderscript.Element} does not match the component type
 * of the array passed in.
 *
 * <p> The size of the region is: w * h * {@link #getElement}.{@link android.renderscript.Element#getBytesSize Element#getBytesSize}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the region.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the region. The padding bytes for the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the region. The padding bytes for the cells must not be part of the array.
 *
 * @param xoff X offset of the region to copy in this Allocation
 * @param yoff Y offset of the region to copy in this Allocation
 * @param w Width of the region to copy
 * @param h Height of the region to copy
 * @param array Dest Array to be copied into
 * @apiSince 23
 */

public void copy2DRangeTo(int xoff, int yoff, int w, int h, java.lang.Object array) { throw new RuntimeException("Stub!"); }

/**
 * Copy from a rectangular region in this Allocation into an array. This
 * variant is type checked and will generate exceptions if the Allocation's
 * {@link android.renderscript.Element} is neither an 8 bit integer nor a vector
 * of 8 bit integers {@link android.renderscript.Element.DataType}.
 *
 * <p> The size of the region is: w * h * {@link #getElement}.{@link android.renderscript.Element#getBytesSize Element#getBytesSize}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the region.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the region. The padding bytes for the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the region. The padding bytes for the cells must not be part of the array.
 *
 * @param xoff X offset of the region to copy in this Allocation
 * @param yoff Y offset of the region to copy in this Allocation
 * @param w Width of the region to copy
 * @param h Height of the region to copy
 * @param data Dest Array to be copied into
 * @apiSince 23
 */

public void copy2DRangeTo(int xoff, int yoff, int w, int h, byte[] data) { throw new RuntimeException("Stub!"); }

/**
 * Copy from a rectangular region in this Allocation into an array. This
 * variant is type checked and will generate exceptions if the Allocation's
 * {@link android.renderscript.Element} is neither a 16 bit integer nor a vector
 * of 16 bit integers {@link android.renderscript.Element.DataType}.
 *
 * <p> The size of the region is: w * h * {@link #getElement}.{@link android.renderscript.Element#getBytesSize Element#getBytesSize}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the region.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the region. The padding bytes for the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the region. The padding bytes for the cells must not be part of the array.
 *
 * @param xoff X offset of the region to copy in this Allocation
 * @param yoff Y offset of the region to copy in this Allocation
 * @param w Width of the region to copy
 * @param h Height of the region to copy
 * @param data Dest Array to be copied into
 * @apiSince 23
 */

public void copy2DRangeTo(int xoff, int yoff, int w, int h, short[] data) { throw new RuntimeException("Stub!"); }

/**
 * Copy from a rectangular region in this Allocation into an array. This
 * variant is type checked and will generate exceptions if the Allocation's
 * {@link android.renderscript.Element} is neither a 32 bit integer nor a vector
 * of 32 bit integers {@link android.renderscript.Element.DataType}.
 *
 * <p> The size of the region is: w * h * {@link #getElement}.{@link android.renderscript.Element#getBytesSize Element#getBytesSize}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the region.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the region. The padding bytes for the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the region. The padding bytes for the cells must not be part of the array.
 *
 * @param xoff X offset of the region to copy in this Allocation
 * @param yoff Y offset of the region to copy in this Allocation
 * @param w Width of the region to copy
 * @param h Height of the region to copy
 * @param data Dest Array to be copied into
 * @apiSince 23
 */

public void copy2DRangeTo(int xoff, int yoff, int w, int h, int[] data) { throw new RuntimeException("Stub!"); }

/**
 * Copy from a rectangular region in this Allocation into an array. This
 * variant is type checked and will generate exceptions if the Allocation's
 * {@link android.renderscript.Element} is neither a 32 bit float nor a vector
 * of 32 bit floats {@link android.renderscript.Element.DataType}.
 *
 * <p> The size of the region is: w * h * {@link #getElement}.{@link android.renderscript.Element#getBytesSize Element#getBytesSize}.
 *
 * <p> If the Allocation does not have Vec3 Elements, then the size of the
 * array in bytes must be at least the size of the region.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is disabled, then the size of the array in bytes must be at least the size
 * of the region. The padding bytes for the cells must be part of the array.
 *
 * <p> If the Allocation has Vec3 Elements and {@link #setAutoPadding AutoPadding}
 * is enabled, then the size of the array in bytes must be at least 3/4 the size
 * of the region. The padding bytes for the cells must not be part of the array.
 *
 * @param xoff X offset of the region to copy in this Allocation
 * @param yoff Y offset of the region to copy in this Allocation
 * @param w Width of the region to copy
 * @param h Height of the region to copy
 * @param data Dest Array to be copied into
 * @apiSince 23
 */

public void copy2DRangeTo(int xoff, int yoff, int w, int h, float[] data) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public void copy3DRangeTo(int xoff, int yoff, int zoff, int w, int h, int d, java.lang.Object array) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new Allocation with the given {@link
 * android.renderscript.Type}, mipmap flag, and usage flags.
 *
 * @param type RenderScript type describing data layout
 * @param mips specifies desired mipmap behaviour for the
 *             allocation
 * @param usage bit field specifying how the Allocation is
 *              utilized
 * @apiSince 11
 */

public static android.renderscript.Allocation createTyped(android.renderscript.RenderScript rs, android.renderscript.Type type, android.renderscript.Allocation.MipmapControl mips, int usage) { throw new RuntimeException("Stub!"); }

/**
 * Creates an Allocation with the size specified by the type and no mipmaps
 * generated by default
 *
 * @param rs Context to which the allocation will belong.
 * @param type renderscript type describing data layout
 * @param usage bit field specifying how the allocation is
 *              utilized
 *
 * @return allocation
 * @apiSince 11
 */

public static android.renderscript.Allocation createTyped(android.renderscript.RenderScript rs, android.renderscript.Type type, int usage) { throw new RuntimeException("Stub!"); }

/**
 * Creates an Allocation for use by scripts with a given {@link
 * android.renderscript.Type} and no mipmaps
 *
 * @param rs Context to which the Allocation will belong.
 * @param type RenderScript Type describing data layout
 *
 * @return allocation
 * @apiSince 11
 */

public static android.renderscript.Allocation createTyped(android.renderscript.RenderScript rs, android.renderscript.Type type) { throw new RuntimeException("Stub!"); }

/**
 * Creates an Allocation with a specified number of given elements
 *
 * @param rs Context to which the Allocation will belong.
 * @param e Element to use in the Allocation
 * @param count the number of Elements in the Allocation
 * @param usage bit field specifying how the Allocation is
 *              utilized
 *
 * @return allocation
 * @apiSince 11
 */

public static android.renderscript.Allocation createSized(android.renderscript.RenderScript rs, android.renderscript.Element e, int count, int usage) { throw new RuntimeException("Stub!"); }

/**
 * Creates an Allocation with a specified number of given elements
 *
 * @param rs Context to which the Allocation will belong.
 * @param e Element to use in the Allocation
 * @param count the number of Elements in the Allocation
 *
 * @return allocation
 * @apiSince 11
 */

public static android.renderscript.Allocation createSized(android.renderscript.RenderScript rs, android.renderscript.Element e, int count) { throw new RuntimeException("Stub!"); }

/**
 * Creates an Allocation from a {@link android.graphics.Bitmap}.
 *
 * @param rs Context to which the allocation will belong.
 * @param b Bitmap source for the allocation data
 * @param mips specifies desired mipmap behaviour for the
 *             allocation
 * @param usage bit field specifying how the allocation is
 *              utilized
 *
 * @return Allocation containing bitmap data
 *
 * @apiSince 11
 */

public static android.renderscript.Allocation createFromBitmap(android.renderscript.RenderScript rs, android.graphics.Bitmap b, android.renderscript.Allocation.MipmapControl mips, int usage) { throw new RuntimeException("Stub!"); }

/**
 * Gets or creates a ByteBuffer that contains the raw data of the current Allocation.
 * <p> If the Allocation is created with USAGE_IO_INPUT, the returned ByteBuffer
 * would contain the up-to-date data as READ ONLY.
 * For a 2D or 3D Allocation, the raw data maybe padded so that each row of
 * the Allocation has certain alignment. The size of each row including padding,
 * called stride, can be queried using the {@link #getStride()} method.
 *
 * Note: Operating on the ByteBuffer of a destroyed Allocation will triger errors.
 *
 * @return ByteBuffer The ByteBuffer associated with raw data pointer of the Allocation.
 * @apiSince 24
 */

public java.nio.ByteBuffer getByteBuffer() { throw new RuntimeException("Stub!"); }

/**
 * Creates a new Allocation Array with the given {@link
 * android.renderscript.Type}, and usage flags.
 * Note: If the input allocation is of usage: USAGE_IO_INPUT,
 * the created Allocation will be sharing the same BufferQueue.
 *
 * @param rs RenderScript context
 * @param t RenderScript type describing data layout
 * @param usage bit field specifying how the Allocation is
 *              utilized
 * @param numAlloc Number of Allocations in the array.
 * @return Allocation[]
 * @apiSince 24
 */

public static android.renderscript.Allocation[] createAllocations(android.renderscript.RenderScript rs, android.renderscript.Type t, int usage, int numAlloc) { throw new RuntimeException("Stub!"); }

/**
 * Gets the stride of the Allocation.
 * For a 2D or 3D Allocation, the raw data maybe padded so that each row of
 * the Allocation has certain alignment. The size of each row including such
 * padding is called stride.
 *
 * @return the stride. For 1D Allocation, the stride will be the number of
 *         bytes of this Allocation. For 2D and 3D Allocations, the stride
 *         will be the stride in X dimension measuring in bytes.
 * @apiSince 24
 */

public long getStride() { throw new RuntimeException("Stub!"); }

/**
 * Get the timestamp for the most recent buffer held by this Allocation.
 * The timestamp is guaranteed to be unique and monotonically increasing.
 * Default value: -1. The timestamp will be updated after each {@link
 * #ioReceive ioReceive()} call.
 *
 * It can be used to identify the images by comparing the unique timestamps
 * when used with {@link android.hardware.camera2} APIs.
 * Example steps:
 *   1. Save {@link android.hardware.camera2.TotalCaptureResult} when the
 *      capture is completed.
 *   2. Get the timestamp after {@link #ioReceive ioReceive()} call.
 *   3. Comparing totalCaptureResult.get(CaptureResult.SENSOR_TIMESTAMP) with
 *      alloc.getTimeStamp().
 * @return long Timestamp associated with the buffer held by the Allocation.
 * @apiSince 24
 */

public long getTimeStamp() { throw new RuntimeException("Stub!"); }

/**
 * Returns the handle to a raw buffer that is being managed by the screen
 * compositor. This operation is only valid for Allocations with {@link
 * #USAGE_IO_INPUT}.
 *
 * @return Surface object associated with allocation
 *
 * @apiSince 16
 */

public android.view.Surface getSurface() { throw new RuntimeException("Stub!"); }

/**
 * Associate a {@link android.view.Surface} with this Allocation. This
 * operation is only valid for Allocations with {@link #USAGE_IO_OUTPUT}.
 *
 * @param sur Surface to associate with allocation
 * @apiSince 16
 */

public void setSurface(android.view.Surface sur) { throw new RuntimeException("Stub!"); }

/**
 * Creates an Allocation from a {@link android.graphics.Bitmap}.
 *
 * <p>With target API version 18 or greater, this Allocation will be created
 * with {@link #USAGE_SHARED}, {@link #USAGE_SCRIPT}, and {@link
 * #USAGE_GRAPHICS_TEXTURE}. With target API version 17 or lower, this
 * Allocation will be created with {@link #USAGE_GRAPHICS_TEXTURE}.</p>
 *
 * @param rs Context to which the allocation will belong.
 * @param b bitmap source for the allocation data
 *
 * @return Allocation containing bitmap data
 *
 * @apiSince 11
 */

public static android.renderscript.Allocation createFromBitmap(android.renderscript.RenderScript rs, android.graphics.Bitmap b) { throw new RuntimeException("Stub!"); }

/**
 * Creates a cubemap Allocation from a {@link android.graphics.Bitmap}
 * containing the horizontal list of cube faces. Each face must be a square,
 * have the same size as all other faces, and have a width that is a power
 * of 2.
 *
 * @param rs Context to which the allocation will belong.
 * @param b Bitmap with cubemap faces layed out in the following
 *          format: right, left, top, bottom, front, back
 * @param mips specifies desired mipmap behaviour for the cubemap
 * @param usage bit field specifying how the cubemap is utilized
 *
 * @return allocation containing cubemap data
 *
 * @apiSince 11
 */

public static android.renderscript.Allocation createCubemapFromBitmap(android.renderscript.RenderScript rs, android.graphics.Bitmap b, android.renderscript.Allocation.MipmapControl mips, int usage) { throw new RuntimeException("Stub!"); }

/**
 * Creates a non-mipmapped cubemap Allocation for use as a graphics texture
 * from a {@link android.graphics.Bitmap} containing the horizontal list of
 * cube faces. Each face must be a square, have the same size as all other
 * faces, and have a width that is a power of 2.
 *
 * @param rs Context to which the allocation will belong.
 * @param b bitmap with cubemap faces layed out in the following
 *          format: right, left, top, bottom, front, back
 *
 * @return allocation containing cubemap data
 *
 * @apiSince 11
 */

public static android.renderscript.Allocation createCubemapFromBitmap(android.renderscript.RenderScript rs, android.graphics.Bitmap b) { throw new RuntimeException("Stub!"); }

/**
 * Creates a cubemap Allocation from 6 {@link android.graphics.Bitmap}
 * objects containing the cube faces. Each face must be a square, have the
 * same size as all other faces, and have a width that is a power of 2.
 *
 * @param rs Context to which the allocation will belong.
 * @param xpos cubemap face in the positive x direction
 * @param xneg cubemap face in the negative x direction
 * @param ypos cubemap face in the positive y direction
 * @param yneg cubemap face in the negative y direction
 * @param zpos cubemap face in the positive z direction
 * @param zneg cubemap face in the negative z direction
 * @param mips specifies desired mipmap behaviour for the cubemap
 * @param usage bit field specifying how the cubemap is utilized
 *
 * @return allocation containing cubemap data
 *
 * @apiSince 11
 */

public static android.renderscript.Allocation createCubemapFromCubeFaces(android.renderscript.RenderScript rs, android.graphics.Bitmap xpos, android.graphics.Bitmap xneg, android.graphics.Bitmap ypos, android.graphics.Bitmap yneg, android.graphics.Bitmap zpos, android.graphics.Bitmap zneg, android.renderscript.Allocation.MipmapControl mips, int usage) { throw new RuntimeException("Stub!"); }

/**
 * Creates a non-mipmapped cubemap Allocation for use as a sampler input
 * from 6 {@link android.graphics.Bitmap} objects containing the cube
 * faces. Each face must be a square, have the same size as all other faces,
 * and have a width that is a power of 2.
 *
 * @param rs Context to which the allocation will belong.
 * @param xpos cubemap face in the positive x direction
 * @param xneg cubemap face in the negative x direction
 * @param ypos cubemap face in the positive y direction
 * @param yneg cubemap face in the negative y direction
 * @param zpos cubemap face in the positive z direction
 * @param zneg cubemap face in the negative z direction
 *
 * @return allocation containing cubemap data
 *
 * @apiSince 11
 */

public static android.renderscript.Allocation createCubemapFromCubeFaces(android.renderscript.RenderScript rs, android.graphics.Bitmap xpos, android.graphics.Bitmap xneg, android.graphics.Bitmap ypos, android.graphics.Bitmap yneg, android.graphics.Bitmap zpos, android.graphics.Bitmap zneg) { throw new RuntimeException("Stub!"); }

/**
 * Creates an Allocation from the Bitmap referenced
 * by resource ID.
 *
 * @param rs Context to which the allocation will belong.
 * @param res application resources
 * @param id resource id to load the data from
 * @param mips specifies desired mipmap behaviour for the
 *             allocation
 * @param usage bit field specifying how the allocation is
 *              utilized
 *
 * @return Allocation containing resource data
 *
 * @apiSince 11
 */

public static android.renderscript.Allocation createFromBitmapResource(android.renderscript.RenderScript rs, android.content.res.Resources res, int id, android.renderscript.Allocation.MipmapControl mips, int usage) { throw new RuntimeException("Stub!"); }

/**
 * Creates a non-mipmapped Allocation to use as a graphics texture from the
 * {@link android.graphics.Bitmap} referenced by resource ID.
 *
 * <p>With target API version 18 or greater, this allocation will be created
 * with {@link #USAGE_SCRIPT} and {@link #USAGE_GRAPHICS_TEXTURE}. With
 * target API version 17 or lower, this allocation will be created with
 * {@link #USAGE_GRAPHICS_TEXTURE}.</p>
 *
 * @param rs Context to which the allocation will belong.
 * @param res application resources
 * @param id resource id to load the data from
 *
 * @return Allocation containing resource data
 *
 * @apiSince 11
 */

public static android.renderscript.Allocation createFromBitmapResource(android.renderscript.RenderScript rs, android.content.res.Resources res, int id) { throw new RuntimeException("Stub!"); }

/**
 * Creates an Allocation containing string data encoded in UTF-8 format.
 *
 * @param rs Context to which the allocation will belong.
 * @param str string to create the allocation from
 * @param usage bit field specifying how the allocaiton is
 *              utilized
 *
 * @apiSince 11
 */

public static android.renderscript.Allocation createFromString(android.renderscript.RenderScript rs, java.lang.String str, int usage) { throw new RuntimeException("Stub!"); }

/**
 * Set a notification handler for {@link #USAGE_IO_INPUT}.
 *
 * @param callback instance of the OnBufferAvailableListener
 *                 class to be called when buffer arrive.
 * @apiSince 19
 */

public void setOnBufferAvailableListener(android.renderscript.Allocation.OnBufferAvailableListener callback) { throw new RuntimeException("Stub!"); }

/**
 * For USAGE_IO_OUTPUT, destroy() implies setSurface(null).
 *
 * @apiSince 11
 */

public void destroy() { throw new RuntimeException("Stub!"); }

/**
 * The Allocation will be used as the source of shader constants by one or
 * more programs.
 *
 * This was deprecated in API level 16.
 *
 * @apiSince 11
 */

public static final int USAGE_GRAPHICS_CONSTANTS = 8; // 0x8

/**
 * The Allocation will be used as a target for offscreen rendering
 *
 * This was deprecated in API level 16.
 *
 * @apiSince 14
 */

public static final int USAGE_GRAPHICS_RENDER_TARGET = 16; // 0x10

/**
 * The Allocation will be used as a texture source by one or more graphics
 * programs.
 *
 * @apiSince 11
 */

public static final int USAGE_GRAPHICS_TEXTURE = 2; // 0x2

/**
 * The Allocation will be used as a graphics mesh.
 *
 * This was deprecated in API level 16.
 *
 * @apiSince 11
 */

public static final int USAGE_GRAPHICS_VERTEX = 4; // 0x4

/**
 * The Allocation will be used as a {@link android.view.Surface}
 * consumer.  This usage will cause the Allocation to be created
 * as read-only.
 *
 * @apiSince 16
 */

public static final int USAGE_IO_INPUT = 32; // 0x20

/**
 * The Allocation will be used as a {@link android.view.Surface}
 * producer.  The dimensions and format of the {@link
 * android.view.Surface} will be forced to those of the
 * Allocation.
 *
 * @apiSince 16
 */

public static final int USAGE_IO_OUTPUT = 64; // 0x40

/**
 * The Allocation will be bound to and accessed by scripts.
 * @apiSince 11
 */

public static final int USAGE_SCRIPT = 1; // 0x1

/**
 * The Allocation's backing store will be inherited from another object
 * (usually a {@link android.graphics.Bitmap}); copying to or from the
 * original source Bitmap will cause a synchronization rather than a full
 * copy.  {@link #syncAll} may also be used to synchronize the Allocation
 * and the source Bitmap.
 *
 * <p>This is set by default for allocations created with {@link
 * #createFromBitmap} in API version 18 and higher.</p>
 *
 * @apiSince 18
 */

public static final int USAGE_SHARED = 128; // 0x80
/**
 * Controls mipmap behavior when using the bitmap creation and update
 * functions.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum MipmapControl {
/**
 * No mipmaps will be generated and the type generated from the incoming
 * bitmap will not contain additional LODs.
 * @apiSince 11
 */

MIPMAP_NONE,
/**
 * A full mipmap chain will be created in script memory.  The Type of
 * the Allocation will contain a full mipmap chain.  On upload, the full
 * chain will be transferred.
 * @apiSince 11
 */

MIPMAP_FULL,
/**
 * The Type of the Allocation will be the same as MIPMAP_NONE.  It will
 * not contain mipmaps.  On upload, the allocation data will contain a
 * full mipmap chain generated from the top level in script memory.
 * @apiSince 11
 */

MIPMAP_ON_SYNC_TO_TEXTURE;
}

/**
 * Interface to handle notification when new buffers are available via
 * {@link #USAGE_IO_INPUT}. An application will receive one notification
 * when a buffer is available. Additional buffers will not trigger new
 * notifications until a buffer is processed.
 * @apiSince 19
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnBufferAvailableListener {

/** @apiSince 19 */

public void onBufferAvailable(android.renderscript.Allocation a);
}

}

