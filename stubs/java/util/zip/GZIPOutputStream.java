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
 * This class implements a stream filter for writing compressed data in
 * the GZIP file format.
 * @author      David Connelly
 *
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class GZIPOutputStream extends java.util.zip.DeflaterOutputStream {

/**
 * Creates a new output stream with the specified buffer size.
 *
 * <p>The new output stream instance is created as if by invoking
 * the 3-argument constructor GZIPOutputStream(out, size, false).
 *
 * @param out the output stream
 * @param size the output buffer size
 * @exception java.io.IOException If an I/O error has occurred.
 * @exception java.lang.IllegalArgumentException if {@code size <= 0}
 * @apiSince 1
 */

public GZIPOutputStream(java.io.OutputStream out, int size) throws java.io.IOException { super((java.io.OutputStream)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new output stream with the specified buffer size and
 * flush mode.
 *
 * @param out the output stream
 * @param size the output buffer size
 * @param syncFlush
 *        if {@code true} invocation of the inherited
 *        {@link java.util.zip.DeflaterOutputStream#flush() DeflaterOutputStream#flush()} method of
 *        this instance flushes the compressor with flush mode
 *        {@link java.util.zip.Deflater#SYNC_FLUSH Deflater#SYNC_FLUSH} before flushing the output
 *        stream, otherwise only flushes the output stream
 * @exception java.io.IOException If an I/O error has occurred.
 * @exception java.lang.IllegalArgumentException if {@code size <= 0}
 *
 * @since 1.7
 * @apiSince 19
 */

public GZIPOutputStream(java.io.OutputStream out, int size, boolean syncFlush) throws java.io.IOException { super((java.io.OutputStream)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new output stream with a default buffer size.
 *
 * <p>The new output stream instance is created as if by invoking
 * the 2-argument constructor GZIPOutputStream(out, false).
 *
 * @param out the output stream
 * @exception java.io.IOException If an I/O error has occurred.
 * @apiSince 1
 */

public GZIPOutputStream(java.io.OutputStream out) throws java.io.IOException { super((java.io.OutputStream)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new output stream with a default buffer size and
 * the specified flush mode.
 *
 * @param out the output stream
 * @param syncFlush
 *        if {@code true} invocation of the inherited
 *        {@link java.util.zip.DeflaterOutputStream#flush() DeflaterOutputStream#flush()} method of
 *        this instance flushes the compressor with flush mode
 *        {@link java.util.zip.Deflater#SYNC_FLUSH Deflater#SYNC_FLUSH} before flushing the output
 *        stream, otherwise only flushes the output stream
 *
 * @exception java.io.IOException If an I/O error has occurred.
 *
 * @since 1.7
 * @apiSince 19
 */

public GZIPOutputStream(java.io.OutputStream out, boolean syncFlush) throws java.io.IOException { super((java.io.OutputStream)null); throw new RuntimeException("Stub!"); }

/**
 * Writes array of bytes to the compressed output stream. This method
 * will block until all the bytes are written.
 * @param buf the data to be written
 * @param off the start offset of the data
 * @param len the length of the data
 * @exception java.io.IOException If an I/O error has occurred.
 * @apiSince 1
 */

public synchronized void write(byte[] buf, int off, int len) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Finishes writing compressed data to the output stream without closing
 * the underlying stream. Use this method when applying multiple filters
 * in succession to the same output stream.
 * @exception java.io.IOException if an I/O error has occurred
 * @apiSince 1
 */

public void finish() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * CRC-32 of uncompressed data.
 * @apiSince 1
 */

protected java.util.zip.CRC32 crc;
}

