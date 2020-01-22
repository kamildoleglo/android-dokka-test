/* //device/java/android/javax/microedition/khronos/opengles/GL11Ext.java
**
** Copyright 2007, The Android Open Source Project
**
** Licensed under the Apache License, Version 2.0 (the "License"); 
** you may not use this file except in compliance with the License. 
** You may obtain a copy of the License at 
**
**     http://www.apache.org/licenses/LICENSE-2.0 
**
** Unless required by applicable law or agreed to in writing, software 
** distributed under the License is distributed on an "AS IS" BASIS, 
** WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
** See the License for the specific language governing permissions and 
** limitations under the License.
*/

// This source file is automatically generated


package javax.microedition.khronos.opengles;


/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface GL11Ext extends javax.microedition.khronos.opengles.GL {

/** @apiSince 1 */

public void glTexParameterfv(int target, int pname, float[] param, int offset);

/** @apiSince 1 */

public void glCurrentPaletteMatrixOES(int matrixpaletteindex);

/** @apiSince 1 */

public void glDrawTexfOES(float x, float y, float z, float width, float height);

/** @apiSince 1 */

public void glDrawTexfvOES(float[] coords, int offset);

/** @apiSince 1 */

public void glDrawTexfvOES(java.nio.FloatBuffer coords);

/** @apiSince 1 */

public void glDrawTexiOES(int x, int y, int z, int width, int height);

/** @apiSince 1 */

public void glDrawTexivOES(int[] coords, int offset);

/** @apiSince 1 */

public void glDrawTexivOES(java.nio.IntBuffer coords);

/** @apiSince 1 */

public void glDrawTexsOES(short x, short y, short z, short width, short height);

/** @apiSince 1 */

public void glDrawTexsvOES(short[] coords, int offset);

/** @apiSince 1 */

public void glDrawTexsvOES(java.nio.ShortBuffer coords);

/** @apiSince 1 */

public void glDrawTexxOES(int x, int y, int z, int width, int height);

/** @apiSince 1 */

public void glDrawTexxvOES(int[] coords, int offset);

/** @apiSince 1 */

public void glDrawTexxvOES(java.nio.IntBuffer coords);

/** @apiSince 1 */

public void glEnable(int cap);

/** @apiSince 1 */

public void glEnableClientState(int array);

/** @apiSince 1 */

public void glLoadPaletteFromModelViewMatrixOES();

/** @apiSince 1 */

public void glMatrixIndexPointerOES(int size, int type, int stride, java.nio.Buffer pointer);

/** @apiSince 1 */

public void glMatrixIndexPointerOES(int size, int type, int stride, int offset);

/** @apiSince 1 */

public void glWeightPointerOES(int size, int type, int stride, java.nio.Buffer pointer);

/** @apiSince 1 */

public void glWeightPointerOES(int size, int type, int stride, int offset);

/** @apiSince 1 */

public static final int GL_MATRIX_INDEX_ARRAY_BUFFER_BINDING_OES = 35742; // 0x8b9e

/** @apiSince 1 */

public static final int GL_MATRIX_INDEX_ARRAY_OES = 34884; // 0x8844

/** @apiSince 1 */

public static final int GL_MATRIX_INDEX_ARRAY_POINTER_OES = 34889; // 0x8849

/** @apiSince 1 */

public static final int GL_MATRIX_INDEX_ARRAY_SIZE_OES = 34886; // 0x8846

/** @apiSince 1 */

public static final int GL_MATRIX_INDEX_ARRAY_STRIDE_OES = 34888; // 0x8848

/** @apiSince 1 */

public static final int GL_MATRIX_INDEX_ARRAY_TYPE_OES = 34887; // 0x8847

/** @apiSince 1 */

public static final int GL_MATRIX_PALETTE_OES = 34880; // 0x8840

/** @apiSince 1 */

public static final int GL_MAX_PALETTE_MATRICES_OES = 34882; // 0x8842

/** @apiSince 1 */

public static final int GL_MAX_VERTEX_UNITS_OES = 34468; // 0x86a4

/** @apiSince 1 */

public static final int GL_TEXTURE_CROP_RECT_OES = 35741; // 0x8b9d

/** @apiSince 1 */

public static final int GL_WEIGHT_ARRAY_BUFFER_BINDING_OES = 34974; // 0x889e

/** @apiSince 1 */

public static final int GL_WEIGHT_ARRAY_OES = 34477; // 0x86ad

/** @apiSince 1 */

public static final int GL_WEIGHT_ARRAY_POINTER_OES = 34476; // 0x86ac

/** @apiSince 1 */

public static final int GL_WEIGHT_ARRAY_SIZE_OES = 34475; // 0x86ab

/** @apiSince 1 */

public static final int GL_WEIGHT_ARRAY_STRIDE_OES = 34474; // 0x86aa

/** @apiSince 1 */

public static final int GL_WEIGHT_ARRAY_TYPE_OES = 34473; // 0x86a9
}

