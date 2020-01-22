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


/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SweepGradient extends android.graphics.Shader {

/**
 * A Shader that draws a sweep gradient around a center point.
 *
 * @param cx       The x-coordinate of the center
 * @param cy       The y-coordinate of the center
 * @param colors   The sRGB colors to be distributed between around the center.
 *                 There must be at least 2 colors in the array.
 * This value must never be {@code null}.
 * @param positions May be NULL. The relative position of
 *                 each corresponding color in the colors array, beginning
 *                 with 0 and ending with 1.0. If the values are not
 *                 monotonic, the drawing may produce unexpected results.
 *                 If positions is NULL, then the colors are automatically
 *                 spaced evenly.
 
 * This value may be {@code null}.
 * @apiSince 1
 */

public SweepGradient(float cx, float cy, @androidx.annotation.NonNull int[] colors, @androidx.annotation.Nullable float[] positions) { throw new RuntimeException("Stub!"); }

/**
 * A Shader that draws a sweep gradient around a center point.
 *
 * @param cx       The x-coordinate of the center
 * @param cy       The y-coordinate of the center
 * @param colors   The colors to be distributed between around the center.
 *                 There must be at least 2 colors in the array.
 * This value must never be {@code null}.
 * @param positions May be NULL. The relative position of
 *                 each corresponding color in the colors array, beginning
 *                 with 0 and ending with 1.0. If the values are not
 *                 monotonic, the drawing may produce unexpected results.
 *                 If positions is NULL, then the colors are automatically
 *                 spaced evenly.
 * This value may be {@code null}.
 * @throws java.lang.IllegalArgumentException if there are less than two colors, the colors do
 *      not share the same {@link android.graphics.ColorSpace ColorSpace} or do not use a valid one, or {@code positions}
 *      is not {@code null} and has a different length from {@code colors}.
 * @apiSince 29
 */

public SweepGradient(float cx, float cy, @androidx.annotation.NonNull long[] colors, @androidx.annotation.Nullable float[] positions) { throw new RuntimeException("Stub!"); }

/**
 * A Shader that draws a sweep gradient around a center point.
 *
 * @param cx       The x-coordinate of the center
 * @param cy       The y-coordinate of the center
 * @param color0   The sRGB color to use at the start of the sweep
 * @param color1   The sRGB color to use at the end of the sweep
 * @apiSince 1
 */

public SweepGradient(float cx, float cy, int color0, int color1) { throw new RuntimeException("Stub!"); }

/**
 * A Shader that draws a sweep gradient around a center point.
 *
 * @param cx       The x-coordinate of the center
 * @param cy       The y-coordinate of the center
 * @param color0   The color to use at the start of the sweep
 * @param color1   The color to use at the end of the sweep
 *
 * @throws java.lang.IllegalArgumentException if the colors do
 *      not share the same {@link android.graphics.ColorSpace ColorSpace} or do not use a valid one.
 * @apiSince 29
 */

public SweepGradient(float cx, float cy, long color0, long color1) { throw new RuntimeException("Stub!"); }
}

