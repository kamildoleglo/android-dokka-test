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
public class PathDashPathEffect extends android.graphics.PathEffect {

/**
 * Dash the drawn path by stamping it with the specified shape. This only
 * applies to drawings when the paint's style is STROKE or STROKE_AND_FILL.
 * If the paint's style is FILL, then this effect is ignored. The paint's
 * strokeWidth does not affect the results.
 * @param shape The path to stamp along
 * @param advance spacing between each stamp of shape
 * @param phase amount to offset before the first shape is stamped
 * @param style how to transform the shape at each position as it is stamped
 * @apiSince 1
 */

public PathDashPathEffect(android.graphics.Path shape, float advance, float phase, android.graphics.PathDashPathEffect.Style style) { throw new RuntimeException("Stub!"); }
/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum Style {
/** @apiSince 1 */

TRANSLATE,
/** @apiSince 1 */

ROTATE,
/** @apiSince 1 */

MORPH;
}

}

