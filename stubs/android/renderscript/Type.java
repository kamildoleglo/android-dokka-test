/*
 * Copyright (C) 2013 The Android Open Source Project
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
 * <p>A Type describes the {@link android.renderscript.Element} and dimensions used for an {@link
 * android.renderscript.Allocation} or a parallel operation. Types are created through {@link
 * android.renderscript.Type.Builder}.</p>
 *
 * <p>A Type always includes an {@link android.renderscript.Element} and an X
 * dimension. A Type may be multidimensional, up to three dimensions. A nonzero
 * value in the Y or Z dimensions indicates that the dimension is present. Note
 * that a Type with only a given X dimension and a Type with the same X
 * dimension but Y = 1 are not equivalent.</p>
 *
 * <p>A Type also supports inclusion of level of detail (LOD) or cube map
 * faces. LOD and cube map faces are booleans to indicate present or not
 * present. </p>
 *
 * <p>A Type also supports YUV format information to support an
 * {@link android.renderscript.Allocation} in a YUV format. The YUV formats
 * supported are {@link android.graphics.ImageFormat#YV12},
 * {@link android.graphics.ImageFormat#NV21}, and
 * {@link android.graphics.ImageFormat#YUV_420_888}</p>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about creating an application that uses RenderScript, read the
 * <a href="{@docRoot}guide/topics/renderscript/index.html">RenderScript</a> developer guide.</p>
 * </div>
 * * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Type extends android.renderscript.BaseObj {

Type() { throw new RuntimeException("Stub!"); }

/**
 * Return the element associated with this Type.
 *
 * @return Element
 * @apiSince 11
 */

public android.renderscript.Element getElement() { throw new RuntimeException("Stub!"); }

/**
 * Return the value of the X dimension.
 *
 * @return int
 * @apiSince 11
 */

public int getX() { throw new RuntimeException("Stub!"); }

/**
 * Return the value of the Y dimension or 0 for a 1D allocation.
 *
 * @return int
 * @apiSince 11
 */

public int getY() { throw new RuntimeException("Stub!"); }

/**
 * Return the value of the Z dimension or 0 for a 1D or 2D allocation.
 *
 * @return int
 * @apiSince 11
 */

public int getZ() { throw new RuntimeException("Stub!"); }

/**
 * Get the YUV format
 *
 *
 * @return int
 * @apiSince 18
 */

public int getYuv() { throw new RuntimeException("Stub!"); }

/**
 * Return if the Type has a mipmap chain.
 *
 * @return boolean
 * @apiSince 11
 */

public boolean hasMipmaps() { throw new RuntimeException("Stub!"); }

/**
 * Return if the Type is a cube map.
 *
 * @return boolean
 * @apiSince 11
 */

public boolean hasFaces() { throw new RuntimeException("Stub!"); }

/**
 * Return the total number of accessable cells in the Type.
 *
 * @return int
 * @apiSince 11
 */

public int getCount() { throw new RuntimeException("Stub!"); }

/**
 * Utility function for creating basic 1D types. The type is
 * created without mipmaps enabled.
 *
 * @param rs The RenderScript context
 * @param e The Element for the Type
 * @param dimX The X dimension, must be > 0
 *
 * @return Type
 * @apiSince 21
 */

public static android.renderscript.Type createX(android.renderscript.RenderScript rs, android.renderscript.Element e, int dimX) { throw new RuntimeException("Stub!"); }

/**
 * Utility function for creating basic 2D types. The type is
 * created without mipmaps or cubemaps.
 *
 * @param rs The RenderScript context
 * @param e The Element for the Type
 * @param dimX The X dimension, must be > 0
 * @param dimY The Y dimension, must be > 0
 *
 * @return Type
 * @apiSince 21
 */

public static android.renderscript.Type createXY(android.renderscript.RenderScript rs, android.renderscript.Element e, int dimX, int dimY) { throw new RuntimeException("Stub!"); }

/**
 * Utility function for creating basic 3D types. The type is
 * created without mipmaps.
 *
 * @param rs The RenderScript context
 * @param e The Element for the Type
 * @param dimX The X dimension, must be > 0
 * @param dimY The Y dimension, must be > 0
 * @param dimZ The Z dimension, must be > 0
 *
 * @return Type
 * @apiSince 21
 */

public static android.renderscript.Type createXYZ(android.renderscript.RenderScript rs, android.renderscript.Element e, int dimX, int dimY, int dimZ) { throw new RuntimeException("Stub!"); }
/**
 * Builder class for Type.
 *
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

/**
 * Create a new builder object.
 *
 * @param rs
 * @param e The element for the type to be created.
 * @apiSince 11
 */

public Builder(android.renderscript.RenderScript rs, android.renderscript.Element e) { throw new RuntimeException("Stub!"); }

/**
 * Add a dimension to the Type.
 *
 *
 * @param value
 * @apiSince 11
 */

public android.renderscript.Type.Builder setX(int value) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public android.renderscript.Type.Builder setY(int value) { throw new RuntimeException("Stub!"); }

/** @apiSince 18 */

public android.renderscript.Type.Builder setZ(int value) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public android.renderscript.Type.Builder setMipmaps(boolean value) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public android.renderscript.Type.Builder setFaces(boolean value) { throw new RuntimeException("Stub!"); }

/**
 * Set the YUV layout for a Type.
 *
 * @param yuvFormat {@link android.graphics.ImageFormat#YV12}, {@link android.graphics.ImageFormat#NV21}, or
 * {@link android.graphics.ImageFormat#YUV_420_888}.
 * @apiSince 18
 */

public android.renderscript.Type.Builder setYuvFormat(int yuvFormat) { throw new RuntimeException("Stub!"); }

/**
 * Validate structure and create a new Type.
 *
 * @return Type
 * @apiSince 11
 */

public android.renderscript.Type create() { throw new RuntimeException("Stub!"); }
}

/** @apiSince 11 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum CubemapFace {
/** @apiSince 14 */

POSITIVE_X,
/** @apiSince 11 */

NEGATIVE_X,
/** @apiSince 14 */

POSITIVE_Y,
/** @apiSince 11 */

NEGATIVE_Y,
/** @apiSince 14 */

POSITIVE_Z,
/** @apiSince 11 */

NEGATIVE_Z,
/**
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
POSITVE_X,
/**
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
POSITVE_Y,
/**
 * @apiSince 11
 * @deprecatedSince 29
 */

@Deprecated
POSITVE_Z;
}

}

