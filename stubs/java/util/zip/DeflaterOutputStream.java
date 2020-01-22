/*
 * Copyright (C) 2014 The Android Open Source Project
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
import java.io.OutputStream;

/**
 * This class implements an output stream filter for compressing data in
 * the "deflate" compression format. It is also used as the basis for other
 * types of compression filters, such as GZIPOutputStream.
 *
 * @see         java.util.zip.Deflater
 * @author      David Connelly
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DeflaterOutputStream extends java.io.FilterOutputStream {

/**
 * Creates a new output stream with the specified compressor,
 * buffer size and flush mode.
 
 * @param out the output stream
 * @param def the compressor ("deflater")
 * @param size the output buffer size
 * @param syncFlush
 *        if {@code true} the {@link #flush()} method of this
 *        instance flushes the compressor with flush mode
 *        {@link java.util.zip.Deflater#SYNC_FLUSH Deflater#SYNC_FLUSH} before flushing the output
 *        stream, otherwise only flushes the output stream
 *
 * @throws java.lang.IllegalArgumentException if {@code size <= 0}
 *
 * @since 1.7
 * @apiSince 19
 */

public DeflaterOutputStream(java.io.OutputStream out, java.util.zip.Deflater def, int size, boolean syncFlush) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new output stream with the specified compressor and
 * buffer size.
 *
 * <p>The new output stream instance is created as if by invoking
 * the 4-argument constructor DeflaterOutputStream(out, def, size, false).
 *
 * @param out the output stream
 * @param def the compressor ("deflater")
 * @param size the output buffer size
 * @exception java.lang.IllegalArgumentException if {@code size <= 0}
 * @apiSince 1
 */

public DeflaterOutputStream(java.io.OutputStream out, java.util.zip.Deflater def, int size) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new output stream with the specified compressor, flush
 * mode and a default buffer size.
 *
 * @param out the output stream
 * @param def the compressor ("deflater")
 * @param syncFlush
 *        if {@code true} the {@link #flush()} method of this
 *        instance flushes the compressor with flush mode
 *        {@link java.util.zip.Deflater#SYNC_FLUSH Deflater#SYNC_FLUSH} before flushing the output
 *        stream, otherwise only flushes the output stream
 *
 * @since 1.7
 * @apiSince 19
 */

public DeflaterOutputStream(java.io.OutputStream out, java.util.zip.Deflater def, boolean syncFlush) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new output stream with the specified compressor and
 * a default buffer size.
 *
 * <p>The new output stream instance is created as if by invoking
 * the 3-argument constructor DeflaterOutputStream(out, def, false).
 *
 * @param out the output stream
 * @param def the compressor ("deflater")
 * @apiSince 1
 */

public DeflaterOutputStream(java.io.OutputStream out, java.util.zip.Deflater def) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new output stream with a default compressor, a default
 * buffer size and the specified flush mode.
 *
 * @param out the output stream
 * @param syncFlush
 *        if {@code true} the {@link #flush()} method of this
 *        instance flushes the compressor with flush mode
 *        {@link java.util.zip.Deflater#SYNC_FLUSH Deflater#SYNC_FLUSH} before flushing the output
 *        stream, otherwise only flushes the output stream
 *
 * @since 1.7
 * @apiSince 19
 */

public DeflaterOutputStream(java.io.OutputStream out, boolean syncFlush) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new output stream with a default compressor and buffer size.
 *
 * <p>The new output stream instance is created as if by invoking
 * the 2-argument constructor DeflaterOutputStream(out, false).
 *
 * @param out the output stream
 * @apiSince 1
 */

public DeflaterOutputStream(java.io.OutputStream out) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Writes a byte to the compressed output stream. This method will
 * block until the byte can be written.
 * @param b the byte to be written
 * @exception java.io.IOException if an I/O error has occurred
 * @apiSince 1
 */

public void write(int b) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Writes an array of bytes to the compressed output stream. This
 * method will block until all the bytes are written.
 * @param b the data to be written
 * @param off the start offset of the data
 * @param len the length of the data
 * @exception java.io.IOException if an I/O error has occurred
 * @apiSince 1
 */

public void write(byte[] b, int off, int len) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Finishes writing compressed data to the output stream without closing
 * the underlying stream. Use this method when applying multiple filters
 * in succession to the same output stream.
 * @exception java.io.IOException if an I/O error has occurred
 * @apiSince 1
 */

public void finish() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Writes remaining compressed data to the output stream and closes the
 * underlying stream.
 * @exception java.io.IOException if an I/O error has occurred
 * @apiSince 1
 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Writes next block of compressed data to the output stream.
 * @throws java.io.IOException if an I/O error has occurred
 * @apiSince 1
 */

protected void deflate() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Flushes the compressed output stream.
 *
 * If {@link #DeflaterOutputStream(java.io.OutputStream,java.util.zip.Deflater,int,boolean)
 * syncFlush} is {@code true} when this compressed output stream is
 * constructed, this method first flushes the underlying {@code compressor}
 * with the flush mode {@link java.util.zip.Deflater#SYNC_FLUSH Deflater#SYNC_FLUSH} to force
 * all pending data to be flushed out to the output stream and then
 * flushes the output stream. Otherwise this method only flushes the
 * output stream without flushing the {@code compressor}.
 *
 * @throws java.io.IOException if an I/O error has occurred
 *
 * @since 1.7
 * @apiSince 1
 */

public void flush() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Output buffer for writing compressed data.
 * @apiSince 1
 */

protected byte[] buf;

/**
 * Compressor for this stream.
 * @apiSince 1
 */

protected java.util.zip.Deflater def;
}

