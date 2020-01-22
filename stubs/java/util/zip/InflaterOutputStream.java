/*
 * Copyright (c) 2006, 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.io.IOException;

/**
 * Implements an output stream filter for uncompressing data stored in the
 * "deflate" compression format.
 *
 * @since       1.6
 * @author      David R Tribble (david@tribble.com)
 *
 * @see java.util.zip.InflaterInputStream
 * @see java.util.zip.DeflaterInputStream
 * @see java.util.zip.DeflaterOutputStream
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class InflaterOutputStream extends java.io.FilterOutputStream {

/**
 * Creates a new output stream with a default decompressor and buffer
 * size.
 *
 * @param out output stream to write the uncompressed data to
 * @throws java.lang.NullPointerException if {@code out} is null
 * @apiSince 9
 */

public InflaterOutputStream(java.io.OutputStream out) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new output stream with the specified decompressor and a
 * default buffer size.
 *
 * @param out output stream to write the uncompressed data to
 * @param infl decompressor ("inflater") for this stream
 * @throws java.lang.NullPointerException if {@code out} or {@code infl} is null
 * @apiSince 9
 */

public InflaterOutputStream(java.io.OutputStream out, java.util.zip.Inflater infl) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new output stream with the specified decompressor and
 * buffer size.
 *
 * @param out output stream to write the uncompressed data to
 * @param infl decompressor ("inflater") for this stream
 * @param bufLen decompression buffer size
 * @throws java.lang.IllegalArgumentException if {@code bufLen <= 0}
 * @throws java.lang.NullPointerException if {@code out} or {@code infl} is null
 * @apiSince 9
 */

public InflaterOutputStream(java.io.OutputStream out, java.util.zip.Inflater infl, int bufLen) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Writes any remaining uncompressed data to the output stream and closes
 * the underlying output stream.
 *
 * @throws java.io.IOException if an I/O error occurs
 * @apiSince 9
 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Flushes this output stream, forcing any pending buffered output bytes to be
 * written.
 *
 * @throws java.io.IOException if an I/O error occurs or this stream is already
 * closed
 * @apiSince 9
 */

public void flush() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Finishes writing uncompressed data to the output stream without closing
 * the underlying stream.  Use this method when applying multiple filters in
 * succession to the same output stream.
 *
 * @throws java.io.IOException if an I/O error occurs or this stream is already
 * closed
 * @apiSince 9
 */

public void finish() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Writes a byte to the uncompressed output stream.
 *
 * @param b a single byte of compressed data to decompress and write to
 * the output stream
 * @throws java.io.IOException if an I/O error occurs or this stream is already
 * closed
 * @throws java.util.zip.ZipException if a compression (ZIP) format error occurs
 * @apiSince 9
 */

public void write(int b) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Writes an array of bytes to the uncompressed output stream.
 *
 * @param b buffer containing compressed data to decompress and write to
 * the output stream
 * @param off starting offset of the compressed data within {@code b}
 * @param len number of bytes to decompress from {@code b}
 * @throws java.lang.IndexOutOfBoundsException if {@code off < 0}, or if
 * {@code len < 0}, or if {@code len > b.length - off}
 * @throws java.io.IOException if an I/O error occurs or this stream is already
 * closed
 * @throws java.lang.NullPointerException if {@code b} is null
 * @throws java.util.zip.ZipException if a compression (ZIP) format error occurs
 * @apiSince 9
 */

public void write(byte[] b, int off, int len) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Output buffer for writing uncompressed data.
 * @apiSince 9
 */

protected final byte[] buf;
{ buf = new byte[0]; }

/**
 * Decompressor for this stream.
 * @apiSince 9
 */

protected final java.util.zip.Inflater inf;
{ inf = null; }
}

