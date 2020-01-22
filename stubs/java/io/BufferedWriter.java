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
 * Writes text to a character-output stream, buffering characters so as to
 * provide for the efficient writing of single characters, arrays, and strings.
 *
 * <p> The buffer size may be specified, or the default size may be accepted.
 * The default is large enough for most purposes.
 *
 * <p> A newLine() method is provided, which uses the platform's own notion of
 * line separator as defined by the system property <tt>line.separator</tt>.
 * Not all platforms use the newline character ('\n') to terminate lines.
 * Calling this method to terminate each output line is therefore preferred to
 * writing a newline character directly.
 *
 * <p> In general, a Writer sends its output immediately to the underlying
 * character or byte stream.  Unless prompt output is required, it is advisable
 * to wrap a BufferedWriter around any Writer whose write() operations may be
 * costly, such as FileWriters and OutputStreamWriters.  For example,
 *
 * <pre>
 * PrintWriter out
 *   = new PrintWriter(new BufferedWriter(new FileWriter("foo.out")));
 * </pre>
 *
 * will buffer the PrintWriter's output to the file.  Without buffering, each
 * invocation of a print() method would cause characters to be converted into
 * bytes that would then be written immediately to the file, which can be very
 * inefficient.
 *
 * @see java.io.PrintWriter
 * @see java.io.FileWriter
 * @see java.io.OutputStreamWriter
 * @see java.nio.file.Files#newBufferedWriter
 *
 * @author      Mark Reinhold
 * @since       JDK1.1
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class BufferedWriter extends java.io.Writer {

/**
 * Creates a buffered character-output stream that uses a default-sized
 * output buffer.
 *
 * @param  out  A Writer
 * @apiSince 1
 */

public BufferedWriter(java.io.Writer out) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new buffered character-output stream that uses an output
 * buffer of the given size.
 *
 * @param  out  A Writer
 * @param  sz   Output-buffer size, a positive integer
 *
 * @exception  java.lang.IllegalArgumentException  If {@code sz <= 0}
 * @apiSince 1
 */

public BufferedWriter(java.io.Writer out, int sz) { throw new RuntimeException("Stub!"); }

/**
 * Writes a single character.
 *
 * @exception  java.io.IOException  If an I/O error occurs
 * @apiSince 1
 */

public void write(int c) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Writes a portion of an array of characters.
 *
 * <p> Ordinarily this method stores characters from the given array into
 * this stream's buffer, flushing the buffer to the underlying stream as
 * needed.  If the requested length is at least as large as the buffer,
 * however, then this method will flush the buffer and write the characters
 * directly to the underlying stream.  Thus redundant
 * <code>BufferedWriter</code>s will not copy data unnecessarily.
 *
 * @param  cbuf  A character array
 * @param  off   Offset from which to start reading characters
 * @param  len   Number of characters to write
 *
 * @exception  java.io.IOException  If an I/O error occurs
 * @apiSince 1
 */

public void write(char[] cbuf, int off, int len) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Writes a portion of a String.
 *
 * <p> If the value of the <tt>len</tt> parameter is negative then no
 * characters are written.  This is contrary to the specification of this
 * method in the {@linkplain java.io.Writer#write(java.lang.String,int,int)
 * superclass}, which requires that an {@link java.lang.IndexOutOfBoundsException IndexOutOfBoundsException} be
 * thrown.
 *
 * @param  s     String to be written
 * @param  off   Offset from which to start reading characters
 * @param  len   Number of characters to be written
 *
 * @exception  java.io.IOException  If an I/O error occurs
 * @apiSince 1
 */

public void write(java.lang.String s, int off, int len) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Writes a line separator.  The line separator string is defined by the
 * system property <tt>line.separator</tt>, and is not necessarily a single
 * newline ('\n') character.
 *
 * @exception  java.io.IOException  If an I/O error occurs
 * @apiSince 1
 */

public void newLine() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Flushes the stream.
 *
 * @exception  java.io.IOException  If an I/O error occurs
 * @apiSince 1
 */

public void flush() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }
}

