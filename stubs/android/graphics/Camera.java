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


package android.graphics;


/**
 * A camera instance can be used to compute 3D transformations and
 * generate a matrix that can be applied, for instance, on a
 * {@link android.graphics.Canvas Canvas}.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Camera {

/**
 * Creates a new camera, with empty transformations.
 * @apiSince 1
 */

public Camera() { throw new RuntimeException("Stub!"); }

/**
 * Saves the camera state. Each save should be balanced
 * with a call to {@link #restore()}.
 *
 * @see #save()
 * @apiSince 1
 */

public native void save();

/**
 * Restores the saved state, if any.
 *
 * @see #restore()
 * @apiSince 1
 */

public native void restore();

/**
 * Applies a translation transform on all three axis.
 *
 * @param x The distance to translate by on the X axis
 * @param y The distance to translate by on the Y axis
 * @param z The distance to translate by on the Z axis
 * @apiSince 1
 */

public native void translate(float x, float y, float z);

/**
 * Applies a rotation transform around the X axis.
 *
 * @param deg The angle of rotation around the X axis, in degrees
 *
 * @see #rotateY(float)
 * @see #rotateZ(float)
 * @see #rotate(float, float, float)
 * @apiSince 1
 */

public native void rotateX(float deg);

/**
 * Applies a rotation transform around the Y axis.
 *
 * @param deg The angle of rotation around the Y axis, in degrees
 *
 * @see #rotateX(float)
 * @see #rotateZ(float)
 * @see #rotate(float, float, float)
 * @apiSince 1
 */

public native void rotateY(float deg);

/**
 * Applies a rotation transform around the Z axis.
 *
 * @param deg The angle of rotation around the Z axis, in degrees
 *
 * @see #rotateX(float)
 * @see #rotateY(float)
 * @see #rotate(float, float, float)
 * @apiSince 1
 */

public native void rotateZ(float deg);

/**
 * Applies a rotation transform around all three axis.
 *
 * @param x The angle of rotation around the X axis, in degrees
 * @param y The angle of rotation around the Y axis, in degrees
 * @param z The angle of rotation around the Z axis, in degrees
 *
 * @see #rotateX(float)
 * @see #rotateY(float)
 * @see #rotateZ(float)
 * @apiSince 12
 */

public native void rotate(float x, float y, float z);

/**
 * Gets the x location of the camera.
 *
 * @see #setLocation(float, float, float)
 * @apiSince 16
 */

public native float getLocationX();

/**
 * Gets the y location of the camera.
 *
 * @see #setLocation(float, float, float)
 * @apiSince 16
 */

public native float getLocationY();

/**
 * Gets the z location of the camera.
 *
 * @see #setLocation(float, float, float)
 * @apiSince 16
 */

public native float getLocationZ();

/**
 * Sets the location of the camera. The default location is set at
 * 0, 0, -8.
 *
 * @param x The x location of the camera
 * @param y The y location of the camera
 * @param z The z location of the camera
 * @apiSince 12
 */

public native void setLocation(float x, float y, float z);

/**
 * Computes the matrix corresponding to the current transformation
 * and copies it to the supplied matrix object.
 *
 * @param matrix The matrix to copy the current transforms into
 * @apiSince 1
 */

public void getMatrix(android.graphics.Matrix matrix) { throw new RuntimeException("Stub!"); }

/**
 * Computes the matrix corresponding to the current transformation
 * and applies it to the specified Canvas.
 *
 * @param canvas The Canvas to set the transform matrix onto
 * @apiSince 1
 */

public void applyToCanvas(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public native float dotWithNormal(float dx, float dy, float dz);

/** @apiSince 1 */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }
}

