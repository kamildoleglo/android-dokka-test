/*
 * Copyright (C) 2008 The Android Open Source Project
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
 * Only intended for use by generated reflected code.
 *
 * * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AllocationAdapter extends android.renderscript.Allocation {

AllocationAdapter() { throw new RuntimeException("Stub!"); }

/**
 * Set the active LOD.  The LOD must be within the range for the
 * type being adapted.  The base allocation must have mipmaps.
 *
 * Because this changes the dimensions of the adapter the
 * current Y and Z will be reset.
 *
 * @param lod The LOD to make active.
 * @apiSince 11
 */

public void setLOD(int lod) { throw new RuntimeException("Stub!"); }

/**
 * Set the active Face.  The base allocation must be of a type
 * that includes faces.
 *
 * @param cf The face to make active.
 * @apiSince 11
 */

public void setFace(android.renderscript.Type.CubemapFace cf) { throw new RuntimeException("Stub!"); }

/**
 *
 * Set the active X.  The x value must be within the range for
 * the allocation being adapted.
 *
 * @param x The x to make active.
 @apiSince 23
 */

public void setX(int x) { throw new RuntimeException("Stub!"); }

/**
 * Set the active Y.  The y value must be within the range for
 * the allocation being adapted.  The base allocation must
 * contain the Y dimension.
 *
 * @param y The y to make active.
 * @apiSince 11
 */

public void setY(int y) { throw new RuntimeException("Stub!"); }

/**
 * Set the active Z.  The z value must be within the range for
 * the allocation being adapted.  The base allocation must
 * contain the Z dimension.
 *
 * @param z The z to make active.
 * @apiSince 11
 */

public void setZ(int z) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public static android.renderscript.AllocationAdapter create1D(android.renderscript.RenderScript rs, android.renderscript.Allocation a) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public static android.renderscript.AllocationAdapter create2D(android.renderscript.RenderScript rs, android.renderscript.Allocation a) { throw new RuntimeException("Stub!"); }

/**
 *
 *
 * Create an arbitrary window into the base allocation.
 * The type describes the shape of the window.
 *
 * Any dimensions present in the type must be equal or smaller
 * to the dimensions in the source allocation.  A dimension
 * present in the allocation that is not present in the type
 * will be constrained away with the selectors.
 *
 * If a dimension is present in both the type and allocation, one of
 * two things will happen.
 *
 * If the type is smaller than the allocation, a window will be
 * created, the selected value in the adapter for that dimension
 * will act as the base address, and the type will describe the
 * size of the view starting at that point.
 *
 * If the type and allocation dimension are of the same size,
 * then setting the selector for the dimension will be an error.
 @apiSince 23
 */

public static android.renderscript.AllocationAdapter createTyped(android.renderscript.RenderScript rs, android.renderscript.Allocation a, android.renderscript.Type t) { throw new RuntimeException("Stub!"); }

/**
 * Override the Allocation resize.  Resizing adapters is not
 * allowed and will throw a RSInvalidStateException.
 *
 * @param dimX ignored.
 * @apiSince 11
 */

public synchronized void resize(int dimX) { throw new RuntimeException("Stub!"); }
}

