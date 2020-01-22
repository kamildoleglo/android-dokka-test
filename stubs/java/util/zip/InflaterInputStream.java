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
import java.io.InputStream;

/**
 * This class implements a stream filter for uncompressing data in the
 * "deflate" compression format. It is also used as the basis for other
 * decompression filters, such as GZIPInputStream.
 *
 * @see         java.util.zip.Inflater
 * @author      David Connelly
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class InflaterInputStream extends java.io.FilterInputStream {

/**
 * Creates a new input stream with the specified decompressor and
 * buffer size.
 * @param in the input stream
 * @param inf the decompressor ("inflater")
 * @param size the input buffer size
 * @exception java.lang.IllegalArgumentException if {@code size <= 0}
 * @apiSince 1
 */

public InflaterInputStream(java.io.InputStream in, java.util.zip.Inflater inf, int size) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new input stream with the specified decompressor and a
 * default buffer size.
 * @param in the input stream
 * @param inf the decompressor ("inflater")
 * @apiSince 1
 */

public InflaterInputStream(java.io.InputStream in, java.util.zip.Inflater inf) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new input stream with a default decompressor and buffer size.
 * @param in the input stream
 * @apiSince 1
 */

public InflaterInputStream(java.io.InputStream in) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Reads a byte of uncompressed data. This method will block until
 * enough input is available for decompression.
 * @return the byte read, or -1 if end of compressed input is reached
 * @exception java.io.IOException if an I/O error has occurred
 * @apiSince 1
 */

public int read() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Reads uncompressed data into an array of bytes. If <code>len</code> is not
 * zero, the method will block until some input can be decompressed; otherwise,
 * no bytes are read and <code>0</code> is returned.
 * @param b the buffer into which the data is read
 * @param off the start offset in the destination array <code>b</code>
 * @param len the maximum number of bytes read
 * @return the actual number of bytes read, or -1 if the end of the
 *         compressed input is reached or a preset dictionary is needed
 * @exception  java.lang.NullPointerException If <code>b</code> is <code>null</code>.
 * @exception  java.lang.IndexOutOfBoundsException If <code>off</code> is negative,
 * <code>len</code> is negative, or <code>len</code> is greater than
 * <code>b.length - off</code>
 * @exception java.util.zip.ZipException if a ZIP format error has occurred
 * @exception java.io.IOException if an I/O error has occurred
 * @apiSince 1
 */

public int read(byte[] b, int off, int len) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns 0 after EOF has been reached, otherwise always return 1.
 * <p>
 * Programs should not count on this method to return the actual number
 * of bytes that could be read without blocking.
 *
 * @return     1 before EOF and 0 after EOF.
 * @exception  java.io.IOException  if an I/O error occurs.
 *
 * @apiSince 1
 */

public int available() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Skips specified number of bytes of uncompressed data.
 * @param n the number of bytes to skip
 * @return the actual number of bytes skipped.
 * @exception java.io.IOException if an I/O error has occurred
 * @exception java.lang.IllegalArgumentException if {@code n < 0}
 * @apiSince 1
 */

public long skip(long n) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Closes this input stream and releases any system resources associated
 * with the stream.
 * @exception java.io.IOException if an I/O error has occurred
 * @apiSince 1
 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Fills input buffer with more data to decompress.
 * @exception java.io.IOException if an I/O error has occurred
 * @apiSince 1
 */

protected void fill() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Tests if this input stream supports the <code>mark</code> and
 * <code>reset</code> methods. The <code>markSupported</code>
 * method of <code>InflaterInputStream</code> returns
 * <code>false</code>.
 *
 * @return  a <code>boolean</code> indicating if this stream type supports
 *          the <code>mark</code> and <code>reset</code> methods.
 * @see     java.io.InputStream#mark(int)
 * @see     java.io.InputStream#reset()
 * @apiSince 1
 */

public boolean markSupported() { throw new RuntimeException("Stub!"); }

/**
 * Marks the current position in this input stream.
 *
 * <p> The <code>mark</code> method of <code>InflaterInputStream</code>
 * does nothing.
 *
 * @param   readlimit   the maximum limit of bytes that can be read before
 *                      the mark position becomes invalid.
 * @see     java.io.InputStream#reset()
 * @apiSince 1
 */

public synchronized void mark(int readlimit) { throw new RuntimeException("Stub!"); }

/**
 * Repositions this stream to the position at the time the
 * <code>mark</code> method was last called on this input stream.
 *
 * <p> The method <code>reset</code> for class
 * <code>InflaterInputStream</code> does nothing except throw an
 * <code>IOException</code>.
 *
 * @exception  java.io.IOException  if this method is invoked.
 * @see     java.io.InputStream#mark(int)
 * @see     java.io.IOException
 * @apiSince 1
 */

public synchronized void reset() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Input buffer for decompression.
 * @apiSince 1
 */

protected byte[] buf;

/**
 * Indicates whether the {@link #close()} method has been called, internal use only.
 *
 * @deprecated This field will be removed from a future version of Android and should not be
 * used. Subclasses that access this field need to be modified to keep track of their own
 * closed state by overriding close().
 * @apiSince 24
 * @deprecatedSince 29
 */

@Deprecated protected boolean closed = false;

/**
 * Decompressor for this stream.
 * @apiSince 1
 */

protected java.util.zip.Inflater inf;

/**
 * Length of input buffer.
 * @apiSince 1
 */

protected int len;
}

