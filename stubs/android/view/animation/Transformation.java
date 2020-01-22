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


package android.view.animation;

import android.graphics.Matrix;

/**
 * Defines the transformation to be applied at
 * one point in time of an Animation.
 *
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Transformation {

/**
 * Creates a new transformation with alpha = 1 and the identity matrix.
 * @apiSince 1
 */

public Transformation() { throw new RuntimeException("Stub!"); }

/**
 * Reset the transformation to a state that leaves the object
 * being animated in an unmodified state. The transformation type is
 * {@link #TYPE_BOTH} by default.
 * @apiSince 1
 */

public void clear() { throw new RuntimeException("Stub!"); }

/**
 * Indicates the nature of this transformation.
 *
 * @return {@link #TYPE_ALPHA}, {@link #TYPE_MATRIX},
 *         {@link #TYPE_BOTH} or {@link #TYPE_IDENTITY}.
 * @apiSince 1
 */

public int getTransformationType() { throw new RuntimeException("Stub!"); }

/**
 * Sets the transformation type.
 *
 * @param transformationType One of {@link #TYPE_ALPHA},
 *        {@link #TYPE_MATRIX}, {@link #TYPE_BOTH} or
 *        {@link #TYPE_IDENTITY}.
 * @apiSince 1
 */

public void setTransformationType(int transformationType) { throw new RuntimeException("Stub!"); }

/**
 * Clones the specified transformation.
 *
 * @param t The transformation to clone.
 * @apiSince 1
 */

public void set(android.view.animation.Transformation t) { throw new RuntimeException("Stub!"); }

/**
 * Apply this Transformation to an existing Transformation, e.g.&nbsp;apply
 * a scale effect to something that has already been rotated.
 * @param t
 * @apiSince 1
 */

public void compose(android.view.animation.Transformation t) { throw new RuntimeException("Stub!"); }

/**
 * @return The 3x3 Matrix representing the trnasformation to apply to the
 * coordinates of the object being animated
 * @apiSince 1
 */

public android.graphics.Matrix getMatrix() { throw new RuntimeException("Stub!"); }

/**
 * Sets the degree of transparency
 * @param alpha 1.0 means fully opaqe and 0.0 means fully transparent
 
 * Value is between 0.0 and 1.0 inclusive
 * @apiSince 1
 */

public void setAlpha(float alpha) { throw new RuntimeException("Stub!"); }

/**
 * @return The degree of transparency
 * @apiSince 1
 */

public float getAlpha() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Return a string representation of the transformation in a compact form.
 * @apiSince 3
 */

public java.lang.String toShortString() { throw new RuntimeException("Stub!"); }

/**
 * Indicates a transformation that applies an alpha only (uses an identity matrix.)
 * @apiSince 1
 */

public static final int TYPE_ALPHA = 1; // 0x1

/**
 * Indicates a transformation that applies an alpha and a matrix.
 * @apiSince 1
 */

public static final int TYPE_BOTH = 3; // 0x3

/**
 * Indicates a transformation that has no effect (alpha = 1 and identity matrix.)
 * @apiSince 1
 */

public static final int TYPE_IDENTITY = 0; // 0x0

/**
 * Indicates a transformation that applies a matrix only (alpha = 1.)
 * @apiSince 1
 */

public static final int TYPE_MATRIX = 2; // 0x2

/** @apiSince 1 */

protected float mAlpha;

/** @apiSince 1 */

protected android.graphics.Matrix mMatrix;

/** @apiSince 1 */

protected int mTransformationType;
}

