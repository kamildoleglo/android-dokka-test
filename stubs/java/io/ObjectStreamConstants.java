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
 * Constants written into the Object Serialization Stream.
 *
 * @author  unascribed
 * @since JDK 1.1
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface ObjectStreamConstants {

/**
 * A Stream Protocol Version. <p>
 *
 * All externalizable data is written in JDK 1.1 external data
 * format after calling this method. This version is needed to write
 * streams containing Externalizable data that can be read by
 * pre-JDK 1.1.6 JVMs.
 *
 * @see java.io.ObjectOutputStream#useProtocolVersion(int)
 * @since 1.2
 * @apiSince 1
 */

public static final int PROTOCOL_VERSION_1 = 1; // 0x1

/**
 * A Stream Protocol Version. <p>
 *
 * This protocol is written by JVM 1.2.
 *
 * Externalizable data is written in block data mode and is
 * terminated with TC_ENDBLOCKDATA. Externalizable class descriptor
 * flags has SC_BLOCK_DATA enabled. JVM 1.1.6 and greater can
 * read this format change.
 *
 * Enables writing a nonSerializable class descriptor into the
 * stream. The serialVersionUID of a nonSerializable class is
 * set to 0L.
 *
 * @see java.io.ObjectOutputStream#useProtocolVersion(int)
 * @see #SC_BLOCK_DATA
 * @since 1.2
 * @apiSince 1
 */

public static final int PROTOCOL_VERSION_2 = 2; // 0x2

/**
 * Bit mask for ObjectStreamClass flag. Indicates Externalizable data
 * written in Block Data mode.
 * Added for PROTOCOL_VERSION_2.
 *
 * @see #PROTOCOL_VERSION_2
 * @since 1.2
 * @apiSince 1
 */

public static final byte SC_BLOCK_DATA = 8; // 0x8

/**
 * Bit mask for ObjectStreamClass flag. Indicates class is an enum type.
 * @since 1.5
 * @apiSince 1
 */

public static final byte SC_ENUM = 16; // 0x10

/**
 * Bit mask for ObjectStreamClass flag. Indicates class is Externalizable.
 * @apiSince 1
 */

public static final byte SC_EXTERNALIZABLE = 4; // 0x4

/**
 * Bit mask for ObjectStreamClass flag. Indicates class is Serializable.
 * @apiSince 1
 */

public static final byte SC_SERIALIZABLE = 2; // 0x2

/**
 * Bit mask for ObjectStreamClass flag. Indicates a Serializable class
 * defines its own writeObject method.
 * @apiSince 1
 */

public static final byte SC_WRITE_METHOD = 1; // 0x1

/**
 * Magic number that is written to the stream header.
 * @apiSince 1
 */

public static final short STREAM_MAGIC = -21267; // 0xffffaced

/**
 * Version number that is written to the stream header.
 * @apiSince 1
 */

public static final short STREAM_VERSION = 5; // 0x5

/**
 * Enable overriding of readObject and writeObject.
 *
 * @see java.io.ObjectOutputStream#writeObjectOverride(Object)
 * @see java.io.ObjectInputStream#readObjectOverride()
 * @since 1.2
 * @apiSince 1
 */

public static final java.io.SerializablePermission SUBCLASS_IMPLEMENTATION_PERMISSION = null;

/**
 * Enable substitution of one object for another during
 * serialization/deserialization.
 *
 * @see java.io.ObjectOutputStream#enableReplaceObject(boolean)
 * @see java.io.ObjectInputStream#enableResolveObject(boolean)
 * @since 1.2
 * @apiSince 1
 */

public static final java.io.SerializablePermission SUBSTITUTION_PERMISSION = null;

/**
 * new Array.
 * @apiSince 1
 */

public static final byte TC_ARRAY = 117; // 0x75

/**
 * First tag value.
 * @apiSince 1
 */

public static final byte TC_BASE = 112; // 0x70

/**
 * Block of optional data. Byte following tag indicates number
 * of bytes in this block data.
 * @apiSince 1
 */

public static final byte TC_BLOCKDATA = 119; // 0x77

/**
 * long Block data. The long following the tag indicates the
 * number of bytes in this block data.
 * @apiSince 1
 */

public static final byte TC_BLOCKDATALONG = 122; // 0x7a

/**
 * Reference to Class.
 * @apiSince 1
 */

public static final byte TC_CLASS = 118; // 0x76

/**
 * new Class Descriptor.
 * @apiSince 1
 */

public static final byte TC_CLASSDESC = 114; // 0x72

/**
 * End of optional block data blocks for an object.
 * @apiSince 1
 */

public static final byte TC_ENDBLOCKDATA = 120; // 0x78

/**
 * new Enum constant.
 * @since 1.5
 * @apiSince 1
 */

public static final byte TC_ENUM = 126; // 0x7e

/**
 * Exception during write.
 * @apiSince 1
 */

public static final byte TC_EXCEPTION = 123; // 0x7b

/**
 * Long string.
 * @apiSince 1
 */

public static final byte TC_LONGSTRING = 124; // 0x7c

/**
 * Last tag value.
 * @apiSince 1
 */

public static final byte TC_MAX = 126; // 0x7e

/**
 * Null object reference.
 * @apiSince 1
 */

public static final byte TC_NULL = 112; // 0x70

/**
 * new Object.
 * @apiSince 1
 */

public static final byte TC_OBJECT = 115; // 0x73

/**
 * new Proxy Class Descriptor.
 * @apiSince 1
 */

public static final byte TC_PROXYCLASSDESC = 125; // 0x7d

/**
 * Reference to an object already written into the stream.
 * @apiSince 1
 */

public static final byte TC_REFERENCE = 113; // 0x71

/**
 * Reset stream context. All handles written into stream are reset.
 * @apiSince 1
 */

public static final byte TC_RESET = 121; // 0x79

/**
 * new String.
 * @apiSince 1
 */

public static final byte TC_STRING = 116; // 0x74

/**
 * First wire handle to be assigned.
 * @apiSince 1
 */

public static final int baseWireHandle = 8257536; // 0x7e0000
}

