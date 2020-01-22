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
 * Intrinsic for converting an Android YUV buffer to RGB.
 *
 * The input allocation should be supplied in a supported YUV format
 * as a YUV element Allocation. The output is RGBA; the alpha channel
 * will be set to 255.
 * @apiSince 17
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ScriptIntrinsicYuvToRGB extends android.renderscript.ScriptIntrinsic {

ScriptIntrinsicYuvToRGB() { throw new RuntimeException("Stub!"); }

/**
 * Create an intrinsic for converting YUV to RGB.
 *
 * Supported elements types are {@link android.renderscript.Element#U8_4 Element#U8_4}
 *
 * @param rs The RenderScript context
 * @param e Element type for output
 *
 * @return ScriptIntrinsicYuvToRGB
 * @apiSince 17
 */

public static android.renderscript.ScriptIntrinsicYuvToRGB create(android.renderscript.RenderScript rs, android.renderscript.Element e) { throw new RuntimeException("Stub!"); }

/**
 * Set the input yuv allocation, must be {@link android.renderscript.Element#U8 Element#U8}.
 *
 * @param ain The input allocation.
 * @apiSince 17
 */

public void setInput(android.renderscript.Allocation ain) { throw new RuntimeException("Stub!"); }

/**
 * Convert the image to RGB.
 *
 * @param aout Output allocation. Must match creation element
 *             type.
 * @apiSince 17
 */

public void forEach(android.renderscript.Allocation aout) { throw new RuntimeException("Stub!"); }

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

