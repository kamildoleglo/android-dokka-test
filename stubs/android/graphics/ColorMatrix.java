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
 * 4x5 matrix for transforming the color and alpha components of a Bitmap.
 * The matrix can be passed as single array, and is treated as follows:
 *
 * <pre>
 *  [ a, b, c, d, e,
 *    f, g, h, i, j,
 *    k, l, m, n, o,
 *    p, q, r, s, t ]</pre>
 *
 * <p>
 * When applied to a color <code>[R, G, B, A]</code>, the resulting color
 * is computed as:
 * </p>
 *
 * <pre>
 *   R&rsquo; = a*R + b*G + c*B + d*A + e;
 *   G&rsquo; = f*R + g*G + h*B + i*A + j;
 *   B&rsquo; = k*R + l*G + m*B + n*A + o;
 *   A&rsquo; = p*R + q*G + r*B + s*A + t;</pre>
 *
 * <p>
 * That resulting color <code>[R&rsquo;, G&rsquo;, B&rsquo;, A&rsquo;]</code>
 * then has each channel clamped to the <code>0</code> to <code>255</code>
 * range.
 * </p>
 *
 * <p>
 * The sample ColorMatrix below inverts incoming colors by scaling each
 * channel by <code>-1</code>, and then shifting the result up by
 * <code>255</code> to remain in the standard color space.
 * </p>
 *
 * <pre>
 *   [ -1, 0, 0, 0, 255,
 *     0, -1, 0, 0, 255,
 *     0, 0, -1, 0, 255,
 *     0, 0, 0, 1, 0 ]</pre>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ColorMatrix {

/**
 * Create a new colormatrix initialized to identity (as if reset() had
 * been called).
 * @apiSince 1
 */

public ColorMatrix() { throw new RuntimeException("Stub!"); }

/**
 * Create a new colormatrix initialized with the specified array of values.
 * @apiSince 1
 */

public ColorMatrix(float[] src) { throw new RuntimeException("Stub!"); }

/**
 * Create a new colormatrix initialized with the specified colormatrix.
 * @apiSince 1
 */

public ColorMatrix(android.graphics.ColorMatrix src) { throw new RuntimeException("Stub!"); }

/**
 * Return the array of floats representing this colormatrix.
 * @apiSince 1
 */

public final float[] getArray() { throw new RuntimeException("Stub!"); }

/**
 * Set this colormatrix to identity:
 * <pre>
 * [ 1 0 0 0 0   - red vector
 *   0 1 0 0 0   - green vector
 *   0 0 1 0 0   - blue vector
 *   0 0 0 1 0 ] - alpha vector
 * </pre>
 * @apiSince 1
 */

public void reset() { throw new RuntimeException("Stub!"); }

/**
 * Assign the src colormatrix into this matrix, copying all of its values.
 * @apiSince 1
 */

public void set(android.graphics.ColorMatrix src) { throw new RuntimeException("Stub!"); }

/**
 * Assign the array of floats into this matrix, copying all of its values.
 * @apiSince 1
 */

public void set(float[] src) { throw new RuntimeException("Stub!"); }

/**
 * Set this colormatrix to scale by the specified values.
 * @apiSince 1
 */

public void setScale(float rScale, float gScale, float bScale, float aScale) { throw new RuntimeException("Stub!"); }

/**
 * Set the rotation on a color axis by the specified values.
 * <p>
 * <code>axis=0</code> correspond to a rotation around the RED color
 * <code>axis=1</code> correspond to a rotation around the GREEN color
 * <code>axis=2</code> correspond to a rotation around the BLUE color
 * </p>
 * @apiSince 1
 */

public void setRotate(int axis, float degrees) { throw new RuntimeException("Stub!"); }

/**
 * Set this colormatrix to the concatenation of the two specified
 * colormatrices, such that the resulting colormatrix has the same effect
 * as applying matB and then applying matA.
 * <p>
 * It is legal for either matA or matB to be the same colormatrix as this.
 * </p>
 * @apiSince 1
 */

public void setConcat(android.graphics.ColorMatrix matA, android.graphics.ColorMatrix matB) { throw new RuntimeException("Stub!"); }

/**
 * Concat this colormatrix with the specified prematrix.
 * <p>
 * This is logically the same as calling setConcat(this, prematrix);
 * </p>
 * @apiSince 1
 */

public void preConcat(android.graphics.ColorMatrix prematrix) { throw new RuntimeException("Stub!"); }

/**
 * Concat this colormatrix with the specified postmatrix.
 * <p>
 * This is logically the same as calling setConcat(postmatrix, this);
 * </p>
 * @apiSince 1
 */

public void postConcat(android.graphics.ColorMatrix postmatrix) { throw new RuntimeException("Stub!"); }

/**
 * Set the matrix to affect the saturation of colors.
 *
 * @param sat A value of 0 maps the color to gray-scale. 1 is identity.
 * @apiSince 1
 */

public void setSaturation(float sat) { throw new RuntimeException("Stub!"); }

/**
 * Set the matrix to convert RGB to YUV
 * @apiSince 1
 */

public void setRGB2YUV() { throw new RuntimeException("Stub!"); }

/**
 * Set the matrix to convert from YUV to RGB
 * @apiSince 1
 */

public void setYUV2RGB() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }
}

