/*
 * Copyright (c) 1996, 2013, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */



package java.io;


/**
 * A description of a Serializable field from a Serializable class.  An array
 * of ObjectStreamFields is used to declare the Serializable fields of a class.
 *
 * @author      Mike Warres
 * @author      Roger Riggs
 * @see java.io.ObjectStreamClass
 * @since 1.2
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ObjectStreamField implements java.lang.Comparable<java.lang.Object> {

/**
 * Create a Serializable field with the specified type.  This field should
 * be documented with a <code>serialField</code> tag.
 *
 * @param   name the name of the serializable field
 * @param   type the <code>Class</code> object of the serializable field
 * @apiSince 1
 */

public ObjectStreamField(java.lang.String name, java.lang.Class<?> type) { throw new RuntimeException("Stub!"); }

/**
 * Creates an ObjectStreamField representing a serializable field with the
 * given name and type.  If unshared is false, values of the represented
 * field are serialized and deserialized in the default manner--if the
 * field is non-primitive, object values are serialized and deserialized as
 * if they had been written and read by calls to writeObject and
 * readObject.  If unshared is true, values of the represented field are
 * serialized and deserialized as if they had been written and read by
 * calls to writeUnshared and readUnshared.
 *
 * @param   name field name
 * @param   type field type
 * @param   unshared if false, write/read field values in the same manner
 *          as writeObject/readObject; if true, write/read in the same
 *          manner as writeUnshared/readUnshared
 * @since   1.4
 * @apiSince 1
 */

public ObjectStreamField(java.lang.String name, java.lang.Class<?> type, boolean unshared) { throw new RuntimeException("Stub!"); }

/**
 * Get the name of this field.
 *
 * @return  a <code>String</code> representing the name of the serializable
 *          field
 * @apiSince 1
 */

public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Get the type of the field.  If the type is non-primitive and this
 * <code>ObjectStreamField</code> was obtained from a deserialized {@link java.io.ObjectStreamClass ObjectStreamClass} instance, then <code>Object.class</code> is returned.
 * Otherwise, the <code>Class</code> object for the type of the field is
 * returned.
 *
 * @return  a <code>Class</code> object representing the type of the
 *          serializable field
 * @apiSince 1
 */

public java.lang.Class<?> getType() { throw new RuntimeException("Stub!"); }

/**
 * Returns character encoding of field type.  The encoding is as follows:
 * <blockquote><pre>
 * B            byte
 * C            char
 * D            double
 * F            float
 * I            int
 * J            long
 * L            class or interface
 * S            short
 * Z            boolean
 * [            array
 * </pre></blockquote>
 *
 * @return  the typecode of the serializable field
 * @apiSince 1
 */

public char getTypeCode() { throw new RuntimeException("Stub!"); }

/**
 * Return the JVM type signature.
 *
 * @return  null if this field has a primitive type.
 * @apiSince 1
 */

public java.lang.String getTypeString() { throw new RuntimeException("Stub!"); }

/**
 * Offset of field within instance data.
 *
 * @return  the offset of this field
 * @see #setOffset
 * @apiSince 1
 */

public int getOffset() { throw new RuntimeException("Stub!"); }

/**
 * Offset within instance data.
 *
 * @param   offset the offset of the field
 * @see #getOffset
 * @apiSince 1
 */

protected void setOffset(int offset) { throw new RuntimeException("Stub!"); }

/**
 * Return true if this field has a primitive type.
 *
 * @return  true if and only if this field corresponds to a primitive type
 * @apiSince 1
 */

public boolean isPrimitive() { throw new RuntimeException("Stub!"); }

/**
 * Returns boolean value indicating whether or not the serializable field
 * represented by this ObjectStreamField instance is unshared.
 *
 * @return {@code true} if this field is unshared
 *
 * @since 1.4
 * @apiSince 1
 */

public boolean isUnshared() { throw new RuntimeException("Stub!"); }

/**
 * Compare this field with another <code>ObjectStreamField</code>.  Return
 * -1 if this is smaller, 0 if equal, 1 if greater.  Types that are
 * primitives are "smaller" than object types.  If equal, the field names
 * are compared.
 * @apiSince 1
 */

public int compareTo(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Return a string that describes this field.
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

