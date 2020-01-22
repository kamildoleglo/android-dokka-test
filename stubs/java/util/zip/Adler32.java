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



package java.util.zip;

import java.nio.ByteBuffer;

/**
 * A class that can be used to compute the Adler-32 checksum of a data
 * stream. An Adler-32 checksum is almost as reliable as a CRC-32 but
 * can be computed much faster.
 *
 * <p> Passing a {@code null} argument to a method in this class will cause
 * a {@link java.lang.NullPointerException NullPointerException} to be thrown.
 *
 * @see         java.util.zip.Checksum
 * @author      David Connelly
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Adler32 implements java.util.zip.Checksum {

/**
 * Creates a new Adler32 object.
 * @apiSince 1
 */

public Adler32() { throw new RuntimeException("Stub!"); }

/**
 * Updates the checksum with the specified byte (the low eight
 * bits of the argument b).
 *
 * @param b the byte to update the checksum with
 * @apiSince 1
 */

public void update(int b) { throw new RuntimeException("Stub!"); }

/**
 * Updates the checksum with the specified array of bytes.
 *
 * @throws  java.lang.ArrayIndexOutOfBoundsException
 *          if {@code off} is negative, or {@code len} is negative,
 *          or {@code off+len} is greater than the length of the
 *          array {@code b}
 * @apiSince 1
 */

public void update(byte[] b, int off, int len) { throw new RuntimeException("Stub!"); }

/**
 * Updates the checksum with the specified array of bytes.
 *
 * @param b the byte array to update the checksum with
 * @apiSince 1
 */

public void update(byte[] b) { throw new RuntimeException("Stub!"); }

/**
 * Updates the checksum with the bytes from the specified buffer.
 *
 * The checksum is updated using
 * buffer.{@link java.nio.Buffer#remaining() remaining()}
 * bytes starting at
 * buffer.{@link java.nio.Buffer#position() position()}
 * Upon return, the buffer's position will be updated to its
 * limit; its limit will not have been changed.
 *
 * @param buffer the ByteBuffer to update the checksum with
 * @since 1.8
 * @apiSince 26
 */

public void update(java.nio.ByteBuffer buffer) { throw new RuntimeException("Stub!"); }

/**
 * Resets the checksum to initial value.
 * @apiSince 1
 */

public void reset() { throw new RuntimeException("Stub!"); }

/**
 * Returns the checksum value.
 * @apiSince 1
 */

public long getValue() { throw new RuntimeException("Stub!"); }
}

