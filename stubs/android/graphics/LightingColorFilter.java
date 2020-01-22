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

// This file was generated from the C++ include file: SkColorFilter.h
// Any changes made to this file will be discarded by the build.
// To change this file, either edit the include, or device/tools/gluemaker/main.cpp, 
// or one of the auxilary file specifications in device/tools/gluemaker.


package android.graphics;


/**
 * A color filter that can be used to simulate simple lighting effects.
 * A <code>LightingColorFilter</code> is defined by two parameters, one
 * used to multiply the source color (called <code>colorMultiply</code>)
 * and one used to add to the source color (called <code>colorAdd</code>).
 * The alpha channel is left untouched by this color filter.
 *
 * Given a source color RGB, the resulting R'G'B' color is computed thusly:
 * <pre>
 * R' = R * colorMultiply.R + colorAdd.R
 * G' = G * colorMultiply.G + colorAdd.G
 * B' = B * colorMultiply.B + colorAdd.B
 * </pre>
 * The result is pinned to the <code>[0..255]</code> range for each channel.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class LightingColorFilter extends android.graphics.ColorFilter {

/**
 * Create a colorfilter that multiplies the RGB channels by one color,
 * and then adds a second color. The alpha components of the mul and add
 * arguments are ignored.
 * @apiSince 1
 */

public LightingColorFilter(int mul, int add) { throw new RuntimeException("Stub!"); }

/**
 * Returns the RGB color used to multiply the source color when the
 * color filter is applied.
 * @apiSince 26
 */

public int getColorMultiply() { throw new RuntimeException("Stub!"); }

/**
 * Returns the RGB color that will be added to the source color
 * when the color filter is applied.
 * @apiSince 26
 */

public int getColorAdd() { throw new RuntimeException("Stub!"); }
}

