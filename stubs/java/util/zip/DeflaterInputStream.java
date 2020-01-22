/*
 * Copyright (C) 2014 The Android Open Source Project
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
 * Implements an input stream filter for compressing data in the "deflate"
 * compression format.
 *
 * @since       1.6
 * @author      David R Tribble (david@tribble.com)
 *
 * @see java.util.zip.DeflaterOutputStream
 * @see java.util.zip.InflaterOutputStream
 * @see java.util.zip.InflaterInputStream
 * @apiSince 9
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DeflaterInputStream extends java.io.FilterInputStream {

/**
 * Creates a new input stream with a default compressor and buffer
 * size.
 *
 * @param in input stream to read the uncompressed data to
 * @throws java.lang.NullPointerException if {@code in} is null
 * @apiSince 9
 */

public DeflaterInputStream(java.io.InputStream in) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new input stream with the specified compressor and a
 * default buffer size.
 *
 * @param in input stream to read the uncompressed data to
 * @param defl compressor ("deflater") for this stream
 * @throws java.lang.NullPointerException if {@code in} or {@code defl} is null
 * @apiSince 9
 */

public DeflaterInputStream(java.io.InputStream in, java.util.zip.Deflater defl) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new input stream with the specified compressor and buffer
 * size.
 *
 * @param in input stream to read the uncompressed data to
 * @param defl compressor ("deflater") for this stream
 * @param bufLen compression buffer size
 * @throws java.lang.IllegalArgumentException if {@code bufLen <= 0}
 * @throws java.lang.NullPointerException if {@code in} or {@code defl} is null
 * @apiSince 9
 */

public DeflaterInputStream(java.io.InputStream in, java.util.zip.Deflater defl, int bufLen) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Closes this input stream and its underlying input stream, discarding
 * any pending uncompressed data.
 *
 * @throws java.io.IOException if an I/O error occurs
 * @apiSince 9
 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Reads a single byte of compressed data from the input stream.
 * This method will block until some input can be read and compressed.
 *
 * @return a single byte of compressed data, or -1 if the end of the
 * uncompressed input stream is reached
 * @throws java.io.IOException if an I/O error occurs or if this stream is
 * already closed
 * @apiSince 9
 */

public int read() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Reads compressed data into a byte array.
 * This method will block until some input can be read and compressed.
 *
 * @param b buffer into which the data is read
 * @param off starting offset of the data within {@code b}
 * @param len maximum number of compressed bytes to read into {@code b}
 * @return the actual number of bytes read, or -1 if the end of the
 * uncompressed input stream is reached
 * @throws java.lang.IndexOutOfBoundsException  if {@code len > b.length - off}
 * @throws java.io.IOException if an I/O error occurs or if this input stream is
 * already closed
 * @apiSince 9
 */

public int read(byte[] b, int off, int len) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Skips over and discards data from the input stream.
 * This method may block until the specified number of bytes are read and
 * skipped. <em>Note:</em> While {@code n} is given as a {@code long},
 * the maximum number of bytes which can be skipped is
 * {@code Integer.MAX_VALUE}.
 *
 * @param n number of bytes to be skipped
 * @return the actual number of bytes skipped
 * @throws java.io.IOException if an I/O error occurs or if this stream is
 * already closed
 * @apiSince 9
 */

public long skip(long n) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns 0 after EOF has been reached, otherwise always return 1.
 * <p>
 * Programs should not count on this method to return the actual number
 * of bytes that could be read without blocking
 * @return zero after the end of the underlying input stream has been
 * reached, otherwise always returns 1
 * @throws java.io.IOException if an I/O error occurs or if this stream is
 * already closed
 * @apiSince 9
 */

public int available() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Always returns {@code false} because this input stream does not support
 * the {@link #mark mark()} and {@link #reset reset()} methods.
 *
 * @return false, always
 * @apiSince 9
 */

public boolean markSupported() { throw new RuntimeException("Stub!"); }

/**
 * <i>This operation is not supported</i>.
 *
 * @param limit maximum bytes that can be read before invalidating the position marker
 * @apiSince 9
 */

public void mark(int limit) { throw new RuntimeException("Stub!"); }

/**
 * <i>This operation is not supported</i>.
 *
 * @throws java.io.IOException always thrown
 * @apiSince 9
 */

public void reset() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Input buffer for reading compressed data.
 * @apiSince 9
 */

protected final byte[] buf;
{ buf = new byte[0]; }

/**
 * Compressor for this stream.
 * @apiSince 9
 */

protected final java.util.zip.Deflater def;
{ def = null; }
}

