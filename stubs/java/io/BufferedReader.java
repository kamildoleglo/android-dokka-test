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



package java.io;

import java.util.stream.Stream;

/**
 * Reads text from a character-input stream, buffering characters so as to
 * provide for the efficient reading of characters, arrays, and lines.
 *
 * <p> The buffer size may be specified, or the default size may be used.  The
 * default is large enough for most purposes.
 *
 * <p> In general, each read request made of a Reader causes a corresponding
 * read request to be made of the underlying character or byte stream.  It is
 * therefore advisable to wrap a BufferedReader around any Reader whose read()
 * operations may be costly, such as FileReaders and InputStreamReaders.  For
 * example,
 *
 * <pre>
 * BufferedReader in
 *   = new BufferedReader(new FileReader("foo.in"));
 * </pre>
 *
 * will buffer the input from the specified file.  Without buffering, each
 * invocation of read() or readLine() could cause bytes to be read from the
 * file, converted into characters, and then returned, which can be very
 * inefficient.
 *
 * <p> Programs that use DataInputStreams for textual input can be localized by
 * replacing each DataInputStream with an appropriate BufferedReader.
 *
 * @see java.io.FileReader
 * @see java.io.InputStreamReader
 * @see java.nio.file.Files#newBufferedReader
 *
 * @author      Mark Reinhold
 * @since       JDK1.1
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class BufferedReader extends java.io.Reader {

/**
 * Creates a buffering character-input stream that uses an input buffer of
 * the specified size.
 *
 * @param  in   A Reader
 * @param  sz   Input-buffer size
 *
 * @exception  java.lang.IllegalArgumentException  If {@code sz <= 0}
 * @apiSince 1
 */

public BufferedReader(java.io.Reader in, int sz) { throw new RuntimeException("Stub!"); }

/**
 * Creates a buffering character-input stream that uses a default-sized
 * input buffer.
 *
 * @param  in   A Reader
 * @apiSince 1
 */

public BufferedReader(java.io.Reader in) { throw new RuntimeException("Stub!"); }

/**
 * Reads a single character.
 *
 * @return The character read, as an integer in the range
 *         0 to 65535 (<tt>0x00-0xffff</tt>), or -1 if the
 *         end of the stream has been reached
 * @exception  java.io.IOException  If an I/O error occurs
 * @apiSince 1
 */

public int read() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Reads characters into a portion of an array.
 *
 * <p> This method implements the general contract of the corresponding
 * <code>{@link java.io.Reader#read(char[],int,int) Reader#read(char[], int, int)}</code> method of the
 * <code>{@link java.io.Reader Reader}</code> class.  As an additional convenience, it
 * attempts to read as many characters as possible by repeatedly invoking
 * the <code>read</code> method of the underlying stream.  This iterated
 * <code>read</code> continues until one of the following conditions becomes
 * true: <ul>
 *
 *   <li> The specified number of characters have been read,
 *
 *   <li> The <code>read</code> method of the underlying stream returns
 *   <code>-1</code>, indicating end-of-file, or
 *
 *   <li> The <code>ready</code> method of the underlying stream
 *   returns <code>false</code>, indicating that further input requests
 *   would block.
 *
 * </ul> If the first <code>read</code> on the underlying stream returns
 * <code>-1</code> to indicate end-of-file then this method returns
 * <code>-1</code>.  Otherwise this method returns the number of characters
 * actually read.
 *
 * <p> Subclasses of this class are encouraged, but not required, to
 * attempt to read as many characters as possible in the same fashion.
 *
 * <p> Ordinarily this method takes characters from this stream's character
 * buffer, filling it from the underlying stream as necessary.  If,
 * however, the buffer is empty, the mark is not valid, and the requested
 * length is at least as large as the buffer, then this method will read
 * characters directly from the underlying stream into the given array.
 * Thus redundant <code>BufferedReader</code>s will not copy data
 * unnecessarily.
 *
 * @param      cbuf  Destination buffer
 * @param      off   Offset at which to start storing characters
 * @param      len   Maximum number of characters to read
 *
 * @return     The number of characters read, or -1 if the end of the
 *             stream has been reached
 *
 * @exception  java.io.IOException  If an I/O error occurs
 * @apiSince 1
 */

public int read(char[] cbuf, int off, int len) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Reads a line of text.  A line is considered to be terminated by any one
 * of a line feed ('\n'), a carriage return ('\r'), or a carriage return
 * followed immediately by a linefeed.
 *
 * @return     A String containing the contents of the line, not including
 *             any line-termination characters, or null if the end of the
 *             stream has been reached
 *
 * @exception  java.io.IOException  If an I/O error occurs
 *
 * @see java.nio.file.Files#readAllLines
 * @apiSince 1
 */

public java.lang.String readLine() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Skips characters.
 *
 * @param  n  The number of characters to skip
 *
 * @return    The number of characters actually skipped
 *
 * @exception  java.lang.IllegalArgumentException  If <code>n</code> is negative.
 * @exception  java.io.IOException  If an I/O error occurs
 * @apiSince 1
 */

public long skip(long n) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Tells whether this stream is ready to be read.  A buffered character
 * stream is ready if the buffer is not empty, or if the underlying
 * character stream is ready.
 *
 * @exception  java.io.IOException  If an I/O error occurs
 * @apiSince 1
 */

public boolean ready() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Tells whether this stream supports the mark() operation, which it does.
 * @apiSince 1
 */

public boolean markSupported() { throw new RuntimeException("Stub!"); }

/**
 * Marks the present position in the stream.  Subsequent calls to reset()
 * will attempt to reposition the stream to this point.
 *
 * @param readAheadLimit   Limit on the number of characters that may be
 *                         read while still preserving the mark. An attempt
 *                         to reset the stream after reading characters
 *                         up to this limit or beyond may fail.
 *                         A limit value larger than the size of the input
 *                         buffer will cause a new buffer to be allocated
 *                         whose size is no smaller than limit.
 *                         Therefore large values should be used with care.
 *
 * @exception  java.lang.IllegalArgumentException  If {@code readAheadLimit < 0}
 * @exception  java.io.IOException  If an I/O error occurs
 * @apiSince 1
 */

public void mark(int readAheadLimit) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Resets the stream to the most recent mark.
 *
 * @exception  java.io.IOException  If the stream has never been marked,
 *                          or if the mark has been invalidated
 * @apiSince 1
 */

public void reset() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Stream}, the elements of which are lines read from
 * this {@code BufferedReader}.  The {@link java.util.stream.Stream Stream} is lazily populated,
 * i.e., read only occurs during the
 * <a href="../util/stream/package-summary.html#StreamOps">terminal
 * stream operation</a>.
 *
 * <p> The reader must not be operated on during the execution of the
 * terminal stream operation. Otherwise, the result of the terminal stream
 * operation is undefined.
 *
 * <p> After execution of the terminal stream operation there are no
 * guarantees that the reader will be at a specific position from which to
 * read the next character or line.
 *
 * <p> If an {@link java.io.IOException IOException} is thrown when accessing the underlying
 * {@code BufferedReader}, it is wrapped in an {@link java.io.UncheckedIOException UncheckedIOException} which will be thrown from the {@code Stream}
 * method that caused the read to take place. This method will return a
 * Stream if invoked on a BufferedReader that is closed. Any operation on
 * that stream that requires reading from the BufferedReader after it is
 * closed, will cause an UncheckedIOException to be thrown.
 *
 * @return a {@code Stream<String>} providing the lines of text
 *         described by this {@code BufferedReader}
 *
 * @since 1.8
 * @apiSince 24
 */

public java.util.stream.Stream<java.lang.String> lines() { throw new RuntimeException("Stub!"); }
}

