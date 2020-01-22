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


package android.opengl;

import javax.microedition.khronos.opengles.GL10;

/**
 * A set of GL utilities inspired by the OpenGL Utility Toolkit.
 *
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class GLU {

public GLU() { throw new RuntimeException("Stub!"); }

/**
 * Return an error string from a GL or GLU error code.
 *
 * @param error - a GL or GLU error code.
 * @return the error string for the input error code, or NULL if the input
 *         was not a valid GL or GLU error code.
 * @apiSince 1
 */

public static java.lang.String gluErrorString(int error) { throw new RuntimeException("Stub!"); }

/**
 * Define a viewing transformation in terms of an eye point, a center of
 * view, and an up vector.
 *
 * @param gl a GL10 interface
 * @param eyeX eye point X
 * @param eyeY eye point Y
 * @param eyeZ eye point Z
 * @param centerX center of view X
 * @param centerY center of view Y
 * @param centerZ center of view Z
 * @param upX up vector X
 * @param upY up vector Y
 * @param upZ up vector Z
 * @apiSince 1
 */

public static void gluLookAt(javax.microedition.khronos.opengles.GL10 gl, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) { throw new RuntimeException("Stub!"); }

/**
 * Set up a 2D orthographic projection matrix
 *
 * @param gl
 * @param left
 * @param right
 * @param bottom
 * @param top
 * @apiSince 1
 */

public static void gluOrtho2D(javax.microedition.khronos.opengles.GL10 gl, float left, float right, float bottom, float top) { throw new RuntimeException("Stub!"); }

/**
 * Set up a perspective projection matrix
 *
 * @param gl a GL10 interface
 * @param fovy specifies the field of view angle, in degrees, in the Y
 *        direction.
 * @param aspect specifies the aspect ration that determins the field of
 *        view in the x direction. The aspect ratio is the ratio of x
 *        (width) to y (height).
 * @param zNear specifies the distance from the viewer to the near clipping
 *        plane (always positive).
 * @param zFar specifies the distance from the viewer to the far clipping
 *        plane (always positive).
 * @apiSince 1
 */

public static void gluPerspective(javax.microedition.khronos.opengles.GL10 gl, float fovy, float aspect, float zNear, float zFar) { throw new RuntimeException("Stub!"); }

/**
 * Map object coordinates into window coordinates. gluProject transforms the
 * specified object coordinates into window coordinates using model, proj,
 * and view. The result is stored in win.
 * <p>
 * Note that you can use the OES_matrix_get extension, if present, to get
 * the current modelView and projection matrices.
 *
 * @param objX object coordinates X
 * @param objY object coordinates Y
 * @param objZ object coordinates Z
 * @param model the current modelview matrix
 * @param modelOffset the offset into the model array where the modelview
 *        maxtrix data starts.
 * @param project the current projection matrix
 * @param projectOffset the offset into the project array where the project
 *        matrix data starts.
 * @param view the current view, {x, y, width, height}
 * @param viewOffset the offset into the view array where the view vector
 *        data starts.
 * @param win the output vector {winX, winY, winZ}, that returns the
 *        computed window coordinates.
 * @param winOffset the offset into the win array where the win vector data
 *        starts.
 * @return A return value of GL_TRUE indicates success, a return value of
 *         GL_FALSE indicates failure.
 * @apiSince 1
 */

public static int gluProject(float objX, float objY, float objZ, float[] model, int modelOffset, float[] project, int projectOffset, int[] view, int viewOffset, float[] win, int winOffset) { throw new RuntimeException("Stub!"); }

/**
 * Map window coordinates to object coordinates. gluUnProject maps the
 * specified window coordinates into object coordinates using model, proj,
 * and view. The result is stored in obj.
 * <p>
 * Note that you can use the OES_matrix_get extension, if present, to get
 * the current modelView and projection matrices.
 *
 * @param winX window coordinates X
 * @param winY window coordinates Y
 * @param winZ window coordinates Z
 * @param model the current modelview matrix
 * @param modelOffset the offset into the model array where the modelview
 *        maxtrix data starts.
 * @param project the current projection matrix
 * @param projectOffset the offset into the project array where the project
 *        matrix data starts.
 * @param view the current view, {x, y, width, height}
 * @param viewOffset the offset into the view array where the view vector
 *        data starts.
 * @param obj the output vector {objX, objY, objZ, objW}, that returns the
 *        computed homogeneous object coordinates.
 * @param objOffset the offset into the obj array where the obj vector data
 *        starts.
 * @return A return value of GL10.GL_TRUE indicates success, a return value
 *         of GL10.GL_FALSE indicates failure.
 * @apiSince 1
 */

public static int gluUnProject(float winX, float winY, float winZ, float[] model, int modelOffset, float[] project, int projectOffset, int[] view, int viewOffset, float[] obj, int objOffset) { throw new RuntimeException("Stub!"); }
}

