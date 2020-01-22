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
 * <p>An Element represents one item within an {@link
 * android.renderscript.Allocation}.  An Element is roughly equivalent to a C
 * type in a RenderScript kernel. Elements may be basic or complex. Some basic
 * elements are</p> <ul> <li>A single float value (equivalent to a float in a
 * kernel)</li> <li>A four-element float vector (equivalent to a float4 in a
 * kernel)</li> <li>An unsigned 32-bit integer (equivalent to an unsigned int in
 * a kernel)</li> <li>A single signed 8-bit integer (equivalent to a char in a
 * kernel)</li> </ul> <p>A complex element is roughly equivalent to a C struct
 * and contains a number of basic or complex Elements. From Java code, a complex
 * element contains a list of sub-elements and names that represents a
 * particular data structure. Structs used in RS scripts are available to Java
 * code by using the {@code ScriptField_structname} class that is reflected from
 * a particular script.</p>
 *
 * <p>Basic Elements are comprised of a {@link
 * android.renderscript.Element.DataType} and a {@link
 * android.renderscript.Element.DataKind}. The DataType encodes C type
 * information of an Element, while the DataKind encodes how that Element should
 * be interpreted by a {@link android.renderscript.Sampler}. Note that {@link
 * android.renderscript.Allocation} objects with DataKind {@link
 * android.renderscript.Element.DataKind#USER} cannot be used as input for a
 * {@link android.renderscript.Sampler}. In general, {@link
 * android.renderscript.Allocation} objects that are intended for use with a
 * {@link android.renderscript.Sampler} should use bitmap-derived Elements such
 * as {@link android.renderscript.Element#RGBA_8888} or {@link
 * android.renderscript#Element.A_8}.</p>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about creating an application that uses RenderScript, read the
 * <a href="{@docRoot}guide/topics/renderscript/index.html">RenderScript</a> developer guide.</p>
 * </div>
 * * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Element extends android.renderscript.BaseObj {

Element() { throw new RuntimeException("Stub!"); }

/**
 * @return element size in bytes
 * @apiSince 16
 */

public int getBytesSize() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of vector components. 2 for float2, 4 for
 * float4, etc.
 * @return element vector size
 * @apiSince 16
 */

public int getVectorSize() { throw new RuntimeException("Stub!"); }

/**
 * Return if a element is too complex for use as a data source for a Mesh or
 * a Program.
 *
 * @return boolean
 * @apiSince 11
 */

public boolean isComplex() { throw new RuntimeException("Stub!"); }

/**
 * Elements could be simple, such as an int or a float, or a
 * structure with multiple sub elements, such as a collection of
 * floats, float2, float4. This function returns zero for simple
 * elements or the number of sub-elements otherwise.
 * @return number of sub-elements in this element
 * @apiSince 16
 */

public int getSubElementCount() { throw new RuntimeException("Stub!"); }

/**
 * For complex elements, this function will return the
 * sub-element at index
 * @param index index of the sub-element to return
 * @return sub-element in this element at given index
 * @apiSince 16
 */

public android.renderscript.Element getSubElement(int index) { throw new RuntimeException("Stub!"); }

/**
 * For complex elements, this function will return the
 * sub-element name at index
 * @param index index of the sub-element
 * @return sub-element in this element at given index
 * @apiSince 16
 */

public java.lang.String getSubElementName(int index) { throw new RuntimeException("Stub!"); }

/**
 * For complex elements, some sub-elements could be statically
 * sized arrays. This function will return the array size for
 * sub-element at index
 * @param index index of the sub-element
 * @return array size of sub-element in this element at given index
 * @apiSince 16
 */

public int getSubElementArraySize(int index) { throw new RuntimeException("Stub!"); }

/**
 * This function specifies the location of a sub-element within
 * the element
 * @param index index of the sub-element
 * @return offset in bytes of sub-element in this element at given index
 * @apiSince 16
 */

public int getSubElementOffsetBytes(int index) { throw new RuntimeException("Stub!"); }

/**
 * @return element data type
 * @apiSince 16
 */

public android.renderscript.Element.DataType getDataType() { throw new RuntimeException("Stub!"); }

/**
 * @return element data kind
 * @apiSince 16
 */

public android.renderscript.Element.DataKind getDataKind() { throw new RuntimeException("Stub!"); }

/**
 * Utility function for returning an Element containing a single Boolean.
 *
 * @param rs Context to which the element will belong.
 *
 * @return Element
 * @apiSince 11
 */

public static android.renderscript.Element BOOLEAN(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/**
 * Utility function for returning an Element containing a single UNSIGNED_8.
 *
 * @param rs Context to which the element will belong.
 *
 * @return Element
 * @apiSince 11
 */

public static android.renderscript.Element U8(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/**
 * Utility function for returning an Element containing a single SIGNED_8.
 *
 * @param rs Context to which the element will belong.
 *
 * @return Element
 * @apiSince 11
 */

public static android.renderscript.Element I8(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public static android.renderscript.Element U16(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public static android.renderscript.Element I16(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public static android.renderscript.Element U32(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public static android.renderscript.Element I32(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public static android.renderscript.Element U64(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public static android.renderscript.Element I64(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public static android.renderscript.Element F16(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public static android.renderscript.Element F32(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public static android.renderscript.Element F64(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public static android.renderscript.Element ELEMENT(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public static android.renderscript.Element TYPE(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public static android.renderscript.Element ALLOCATION(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public static android.renderscript.Element SAMPLER(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public static android.renderscript.Element SCRIPT(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public static android.renderscript.Element MESH(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public static android.renderscript.Element PROGRAM_FRAGMENT(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public static android.renderscript.Element PROGRAM_VERTEX(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public static android.renderscript.Element PROGRAM_RASTER(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public static android.renderscript.Element PROGRAM_STORE(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 16 */

public static android.renderscript.Element FONT(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public static android.renderscript.Element A_8(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public static android.renderscript.Element RGB_565(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public static android.renderscript.Element RGB_888(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public static android.renderscript.Element RGBA_5551(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public static android.renderscript.Element RGBA_4444(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public static android.renderscript.Element RGBA_8888(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public static android.renderscript.Element F16_2(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public static android.renderscript.Element F16_3(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public static android.renderscript.Element F16_4(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public static android.renderscript.Element F32_2(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public static android.renderscript.Element F32_3(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public static android.renderscript.Element F32_4(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public static android.renderscript.Element F64_2(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public static android.renderscript.Element F64_3(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public static android.renderscript.Element F64_4(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public static android.renderscript.Element U8_2(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public static android.renderscript.Element U8_3(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public static android.renderscript.Element U8_4(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public static android.renderscript.Element I8_2(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public static android.renderscript.Element I8_3(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public static android.renderscript.Element I8_4(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public static android.renderscript.Element U16_2(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public static android.renderscript.Element U16_3(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public static android.renderscript.Element U16_4(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public static android.renderscript.Element I16_2(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public static android.renderscript.Element I16_3(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public static android.renderscript.Element I16_4(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public static android.renderscript.Element U32_2(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public static android.renderscript.Element U32_3(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public static android.renderscript.Element U32_4(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public static android.renderscript.Element I32_2(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public static android.renderscript.Element I32_3(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public static android.renderscript.Element I32_4(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public static android.renderscript.Element U64_2(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public static android.renderscript.Element U64_3(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public static android.renderscript.Element U64_4(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public static android.renderscript.Element I64_2(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public static android.renderscript.Element I64_3(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 14 */

public static android.renderscript.Element I64_4(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 19 */

public static android.renderscript.Element YUV(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public static android.renderscript.Element MATRIX_4X4(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @deprecated use MATRIX_4X4
 @apiSince 11
 @deprecatedSince 16
 */

@Deprecated
public static android.renderscript.Element MATRIX4X4(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public static android.renderscript.Element MATRIX_3X3(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/** @apiSince 11 */

public static android.renderscript.Element MATRIX_2X2(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/**
 * Create a custom vector element of the specified DataType and vector size.
 * DataKind will be set to USER. Only primitive types (FLOAT_32, FLOAT_64,
 * SIGNED_8, SIGNED_16, SIGNED_32, SIGNED_64, UNSIGNED_8, UNSIGNED_16,
 * UNSIGNED_32, UNSIGNED_64, BOOLEAN) are supported.
 *
 * @param rs The context associated with the new Element.
 * @param dt The DataType for the new Element.
 * @param size Vector size for the new Element.  Range 2-4 inclusive
 *             supported.
 *
 * @return Element
 * @apiSince 11
 */

public static android.renderscript.Element createVector(android.renderscript.RenderScript rs, android.renderscript.Element.DataType dt, int size) { throw new RuntimeException("Stub!"); }

/**
 * Create a new pixel Element type.  A matching DataType and DataKind must
 * be provided.  The DataType and DataKind must contain the same number of
 * components.  Vector size will be set to 1.
 *
 * @param rs The context associated with the new Element.
 * @param dt The DataType for the new element.
 * @param dk The DataKind to specify the mapping of each component in the
 *           DataType.
 *
 * @return Element
 * @apiSince 11
 */

public static android.renderscript.Element createPixel(android.renderscript.RenderScript rs, android.renderscript.Element.DataType dt, android.renderscript.Element.DataKind dk) { throw new RuntimeException("Stub!"); }

/**
 * Check if the current Element is compatible with another Element.
 * Primitive Elements are compatible if they share the same underlying
 * size and type (i.e. U8 is compatible with A_8). User-defined Elements
 * must be equal in order to be compatible. This requires strict name
 * equivalence for all sub-Elements (in addition to structural equivalence).
 *
 * @param e The Element to check compatibility with.
 *
 * @return boolean true if the Elements are compatible, otherwise false.
 * @apiSince 14
 */

public boolean isCompatible(android.renderscript.Element e) { throw new RuntimeException("Stub!"); }
/**
 * Builder class for producing complex elements with matching field and name
 * pairs.  The builder starts empty.  The order in which elements are added
 * is retained for the layout in memory.
 *
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

/**
 * Create a builder object.
 *
 * @param rs
 * @apiSince 11
 */

public Builder(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/**
 * Add an array of elements to this element.
 *
 * @param element
 * @param name
 * @param arraySize
 * @apiSince 11
 */

public android.renderscript.Element.Builder add(android.renderscript.Element element, java.lang.String name, int arraySize) { throw new RuntimeException("Stub!"); }

/**
 * Add a single element to this Element.
 *
 * @param element
 * @param name
 * @apiSince 11
 */

public android.renderscript.Element.Builder add(android.renderscript.Element element, java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Create the element from this builder.
 *
 *
 * @return Element
 * @apiSince 11
 */

public android.renderscript.Element create() { throw new RuntimeException("Stub!"); }
}

/**
 * The special interpretation of the data if required.  This is primarly
 * useful for graphical data.  USER indicates no special interpretation is
 * expected.  PIXEL is used in conjunction with the standard data types for
 * representing texture formats.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum DataKind {
/** @apiSince 11 */

USER,
/** @apiSince 11 */

PIXEL_L,
/** @apiSince 11 */

PIXEL_A,
/** @apiSince 11 */

PIXEL_LA,
/** @apiSince 11 */

PIXEL_RGB,
/** @apiSince 11 */

PIXEL_RGBA,
/** @apiSince 14 */

PIXEL_DEPTH,
/** @apiSince 18 */

PIXEL_YUV;
}

/**
 * DataType represents the basic type information for a basic element.  The
 * naming convention follows.  For numeric types it is FLOAT,
 * SIGNED, or UNSIGNED followed by the _BITS where BITS is the
 * size of the data.  BOOLEAN is a true / false (1,0)
 * represented in an 8 bit container.  The UNSIGNED variants
 * with multiple bit definitions are for packed graphical data
 * formats and represent vectors with per vector member sizes
 * which are treated as a single unit for packing and alignment
 * purposes.
 *
 * MATRIX the three matrix types contain FLOAT_32 elements and are treated
 * as 32 bits for alignment purposes.
 *
 * RS_* objects:  opaque handles with implementation dependent
 * sizes.
 * @apiSince 11
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum DataType {
/** @apiSince 16 */

NONE,
/** @apiSince 23 */

FLOAT_16,
/** @apiSince 11 */

FLOAT_32,
/** @apiSince 11 */

FLOAT_64,
/** @apiSince 11 */

SIGNED_8,
/** @apiSince 11 */

SIGNED_16,
/** @apiSince 11 */

SIGNED_32,
/** @apiSince 11 */

SIGNED_64,
/** @apiSince 11 */

UNSIGNED_8,
/** @apiSince 11 */

UNSIGNED_16,
/** @apiSince 11 */

UNSIGNED_32,
/** @apiSince 11 */

UNSIGNED_64,
/** @apiSince 11 */

BOOLEAN,
/** @apiSince 11 */

UNSIGNED_5_6_5,
/** @apiSince 11 */

UNSIGNED_5_5_5_1,
/** @apiSince 11 */

UNSIGNED_4_4_4_4,
/** @apiSince 11 */

MATRIX_4X4,
/** @apiSince 11 */

MATRIX_3X3,
/** @apiSince 11 */

MATRIX_2X2,
/** @apiSince 11 */

RS_ELEMENT,
/** @apiSince 11 */

RS_TYPE,
/** @apiSince 11 */

RS_ALLOCATION,
/** @apiSince 11 */

RS_SAMPLER,
/** @apiSince 11 */

RS_SCRIPT,
/** @apiSince 11 */

RS_MESH,
/** @apiSince 11 */

RS_PROGRAM_FRAGMENT,
/** @apiSince 11 */

RS_PROGRAM_VERTEX,
/** @apiSince 11 */

RS_PROGRAM_RASTER,
/** @apiSince 11 */

RS_PROGRAM_STORE,
/** @apiSince 16 */

RS_FONT;
}

}

