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

import java.io.IOException;

/**
 * This class implements a stream filter for reading compressed data in
 * the GZIP file format.
 *
 * @see         java.util.zip.InflaterInputStream
 * @author      David Connelly
 *
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class GZIPInputStream extends java.util.zip.InflaterInputStream {

/**
 * Creates a new input stream with the specified buffer size.
 * @param in the input stream
 * @param size the input buffer size
 *
 * @exception java.util.zip.ZipException if a GZIP format error has occurred or the
 *                         compression method used is unsupported
 * @exception java.io.IOException if an I/O error has occurred
 * @exception java.lang.IllegalArgumentException if {@code size <= 0}
 * @apiSince 1
 */

public GZIPInputStream(java.io.InputStream in, int size) throws java.io.IOException { super((java.io.InputStream)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new input stream with a default buffer size.
 * @param in the input stream
 *
 * @exception java.util.zip.ZipException if a GZIP format error has occurred or the
 *                         compression method used is unsupported
 * @exception java.io.IOException if an I/O error has occurred
 * @apiSince 1
 */

public GZIPInputStream(java.io.InputStream in) throws java.io.IOException { super((java.io.InputStream)null); throw new RuntimeException("Stub!"); }

/**
 * Reads uncompressed data into an array of bytes. If <code>len</code> is not
 * zero, the method will block until some input can be decompressed; otherwise,
 * no bytes are read and <code>0</code> is returned.
 * @param buf the buffer into which the data is read
 * @param off the start offset in the destination array <code>b</code>
 * @param len the maximum number of bytes read
 * @return  the actual number of bytes read, or -1 if the end of the
 *          compressed input stream is reached
 *
 * @exception  java.lang.NullPointerException If <code>buf</code> is <code>null</code>.
 * @exception  java.lang.IndexOutOfBoundsException If <code>off</code> is negative,
 * <code>len</code> is negative, or <code>len</code> is greater than
 * <code>buf.length - off</code>
 * @exception java.util.zip.ZipException if the compressed input data is corrupt.
 * @exception java.io.IOException if an I/O error has occurred.
 *
 * @apiSince 1
 */

public int read(byte[] buf, int off, int len) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Closes this input stream and releases any system resources associated
 * with the stream.
 * @exception java.io.IOException if an I/O error has occurred
 * @apiSince 1
 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * GZIP header magic number.
 * @apiSince 1
 */

public static final int GZIP_MAGIC = 35615; // 0x8b1f

/**
 * CRC-32 for uncompressed data.
 * @apiSince 1
 */

protected java.util.zip.CRC32 crc;

/**
 * Indicates end of input stream.
 * @apiSince 1
 */

protected boolean eos;
}

