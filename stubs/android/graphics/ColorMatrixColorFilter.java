/*
 * Copyright (C) 2007 The Android Open Source Project
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


package android.graphics;


/**
 * A color filter that transforms colors through a 4x5 color matrix. This filter
 * can be used to change the saturation of pixels, convert from YUV to RGB, etc.
 *
 * @see android.graphics.ColorMatrix
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ColorMatrixColorFilter extends android.graphics.ColorFilter {

/**
 * Create a color filter that transforms colors through a 4x5 color matrix.
 *
 * @param matrix 4x5 matrix used to transform colors. It is copied into
 *               the filter, so changes made to the matrix after the filter
 *               is constructed will not be reflected in the filter.
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public ColorMatrixColorFilter(@androidx.annotation.NonNull android.graphics.ColorMatrix matrix) { throw new RuntimeException("Stub!"); }

/**
 * Create a color filter that transforms colors through a 4x5 color matrix.
 *
 * @param array Array of floats used to transform colors, treated as a 4x5
 *              matrix. The first 20 entries of the array are copied into
 *              the filter. See ColorMatrix.
 
 * This value must never be {@code null}.
 * @apiSince 1
 */

public ColorMatrixColorFilter(@androidx.annotation.NonNull float[] array) { throw new RuntimeException("Stub!"); }

/**
 * Copies the ColorMatrix from the filter into the passed ColorMatrix.
 *
 * @param colorMatrix Set to the current value of the filter's ColorMatrix.
 * @apiSince 26
 */

public void getColorMatrix(android.graphics.ColorMatrix colorMatrix) { throw new RuntimeException("Stub!"); }
}

