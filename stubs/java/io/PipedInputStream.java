/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1995, 2013, Oracle and/or its affiliates. All rights reserved.
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
 * A piped input stream should be connected
 * to a piped output stream; the piped  input
 * stream then provides whatever data bytes
 * are written to the piped output  stream.
 * Typically, data is read from a <code>PipedInputStream</code>
 * object by one thread  and data is written
 * to the corresponding <code>PipedOutputStream</code>
 * by some  other thread. Attempting to use
 * both objects from a single thread is not
 * recommended, as it may deadlock the thread.
 * The piped input stream contains a buffer,
 * decoupling read operations from write operations,
 * within limits.
 * A pipe is said to be <a name="BROKEN"> <i>broken</i> </a> if a
 * thread that was providing data bytes to the connected
 * piped output stream is no longer alive.
 *
 * @author  James Gosling
 * @see     java.io.PipedOutputStream
 * @since   JDK1.0
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PipedInputStream extends java.io.InputStream {

/**
 * Creates a <code>PipedInputStream</code> so
 * that it is connected to the piped output
 * stream <code>src</code>. Data bytes written
 * to <code>src</code> will then be  available
 * as input from this stream.
 *
 * @param      src   the stream to connect to.
 * @exception  java.io.IOException  if an I/O error occurs.
 * @apiSince 1
 */

public PipedInputStream(java.io.PipedOutputStream src) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Creates a <code>PipedInputStream</code> so that it is
 * connected to the piped output stream
 * <code>src</code> and uses the specified pipe size for
 * the pipe's buffer.
 * Data bytes written to <code>src</code> will then
 * be available as input from this stream.
 *
 * @param      src   the stream to connect to.
 * @param      pipeSize the size of the pipe's buffer.
 * @exception  java.io.IOException  if an I/O error occurs.
 * @exception  java.lang.IllegalArgumentException if {@code pipeSize <= 0}.
 * @since      1.6
 * @apiSince 9
 */

public PipedInputStream(java.io.PipedOutputStream src, int pipeSize) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Creates a <code>PipedInputStream</code> so
 * that it is not yet {@linkplain #connect(java.io.PipedOutputStream)
 * connected}.
 * It must be {@linkplain java.io.PipedOutputStream#connect(
 * java.io.PipedInputStream) connected} to a
 * <code>PipedOutputStream</code> before being used.
 * @apiSince 1
 */

public PipedInputStream() { throw new RuntimeException("Stub!"); }

/**
 * Creates a <code>PipedInputStream</code> so that it is not yet
 * {@linkplain #connect(java.io.PipedOutputStream) connected} and
 * uses the specified pipe size for the pipe's buffer.
 * It must be {@linkplain java.io.PipedOutputStream#connect(
 * java.io.PipedInputStream)
 * connected} to a <code>PipedOutputStream</code> before being used.
 *
 * @param      pipeSize the size of the pipe's buffer.
 * @exception  java.lang.IllegalArgumentException if {@code pipeSize <= 0}.
 * @since      1.6
 * @apiSince 9
 */

public PipedInputStream(int pipeSize) { throw new RuntimeException("Stub!"); }

/**
 * Causes this piped input stream to be connected
 * to the piped  output stream <code>src</code>.
 * If this object is already connected to some
 * other piped output  stream, an <code>IOException</code>
 * is thrown.
 * <p>
 * If <code>src</code> is an
 * unconnected piped output stream and <code>snk</code>
 * is an unconnected piped input stream, they
 * may be connected by either the call:
 *
 * <pre><code>snk.connect(src)</code> </pre>
 * <p>
 * or the call:
 *
 * <pre><code>src.connect(snk)</code> </pre>
 * <p>
 * The two calls have the same effect.
 *
 * @param      src   The piped output stream to connect to.
 * @exception  java.io.IOException  if an I/O error occurs.
 * @apiSince 1
 */

public void connect(java.io.PipedOutputStream src) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Receives a byte of data.  This method will block if no input is
 * available.
 * @param b the byte being received
 * @exception java.io.IOException If the pipe is <a href="#BROKEN"> <code>broken</code></a>,
 *          {@link #connect(java.io.PipedOutputStream) unconnected},
 *          closed, or if an I/O error occurs.
 * @since     JDK1.1
 * @apiSince 1
 */

protected synchronized void receive(int b) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Reads the next byte of data from this piped input stream. The
 * value byte is returned as an <code>int</code> in the range
 * <code>0</code> to <code>255</code>.
 * This method blocks until input data is available, the end of the
 * stream is detected, or an exception is thrown.
 *
 * @return     the next byte of data, or <code>-1</code> if the end of the
 *             stream is reached.
 * @exception  java.io.IOException  if the pipe is
 *           {@link #connect(java.io.PipedOutputStream) unconnected},
 *           <a href="#BROKEN"> <code>broken</code></a>, closed,
 *           or if an I/O error occurs.
 * @apiSince 1
 */

public synchronized int read() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Reads up to <code>len</code> bytes of data from this piped input
 * stream into an array of bytes. Less than <code>len</code> bytes
 * will be read if the end of the data stream is reached or if
 * <code>len</code> exceeds the pipe's buffer size.
 * If <code>len </code> is zero, then no bytes are read and 0 is returned;
 * otherwise, the method blocks until at least 1 byte of input is
 * available, end of the stream has been detected, or an exception is
 * thrown.
 *
 * @param      b     the buffer into which the data is read.
 * @param      off   the start offset in the destination array <code>b</code>
 * @param      len   the maximum number of bytes read.
 * @return     the total number of bytes read into the buffer, or
 *             <code>-1</code> if there is no more data because the end of
 *             the stream has been reached.
 * @exception  java.lang.NullPointerException If <code>b</code> is <code>null</code>.
 * @exception  java.lang.IndexOutOfBoundsException If <code>off</code> is negative,
 * <code>len</code> is negative, or <code>len</code> is greater than
 * <code>b.length - off</code>
 * @exception  java.io.IOException if the pipe is <a href="#BROKEN"> <code>broken</code></a>,
 *           {@link #connect(java.io.PipedOutputStream) unconnected},
 *           closed, or if an I/O error occurs.
 * @apiSince 1
 */

public synchronized int read(byte[] b, int off, int len) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of bytes that can be read from this input
 * stream without blocking.
 *
 * @return the number of bytes that can be read from this input stream
 *         without blocking, or {@code 0} if this input stream has been
 *         closed by invoking its {@link #close()} method, or if the pipe
 *         is {@link #connect(java.io.PipedOutputStream) unconnected}, or
 *          <a href="#BROKEN"> <code>broken</code></a>.
 *
 * @exception  java.io.IOException  if an I/O error occurs.
 * @since   JDK1.0.2
 * @apiSince 1
 */

public synchronized int available() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Closes this piped input stream and releases any system resources
 * associated with the stream.
 *
 * @exception  java.io.IOException  if an I/O error occurs.
 * @apiSince 1
 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * The default size of the pipe's circular input buffer.
 * @since   JDK1.1
 * @apiSince 1
 */

protected static final int PIPE_SIZE = 1024; // 0x400

/**
 * The circular buffer into which incoming data is placed.
 * @since   JDK1.1
 * @apiSince 1
 */

protected byte[] buffer;

/**
 * The index of the position in the circular buffer at which the
 * next byte of data will be stored when received from the connected
 * piped output stream. <code>in&lt;0</code> implies the buffer is empty,
 * <code>in==out</code> implies the buffer is full
 * @since   JDK1.1
 * @apiSince 1
 */

protected int in = -1; // 0xffffffff

/**
 * The index of the position in the circular buffer at which the next
 * byte of data will be read by this piped input stream.
 * @since   JDK1.1
 * @apiSince 1
 */

protected int out = 0; // 0x0
}

