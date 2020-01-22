/*
 * Copyright (c) 1996, 2005, Oracle and/or its affiliates. All rights reserved.
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
 * This class implements a character buffer that can be used as an Writer.
 * The buffer automatically grows when data is written to the stream.  The data
 * can be retrieved using toCharArray() and toString().
 * <P>
 * Note: Invoking close() on this class has no effect, and methods
 * of this class can be called after the stream has closed
 * without generating an IOException.
 *
 * @author      Herb Jellinek
 * @since       JDK1.1
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CharArrayWriter extends java.io.Writer {

/**
 * Creates a new CharArrayWriter.
 * @apiSince 1
 */

public CharArrayWriter() { throw new RuntimeException("Stub!"); }

/**
 * Creates a new CharArrayWriter with the specified initial size.
 *
 * @param initialSize  an int specifying the initial buffer size.
 * @exception java.lang.IllegalArgumentException if initialSize is negative
 * @apiSince 1
 */

public CharArrayWriter(int initialSize) { throw new RuntimeException("Stub!"); }

/**
 * Writes a character to the buffer.
 * @apiSince 1
 */

public void write(int c) { throw new RuntimeException("Stub!"); }

/**
 * Writes characters to the buffer.
 * @param c the data to be written
 * @param off       the start offset in the data
 * @param len       the number of chars that are written
 * @apiSince 1
 */

public void write(char[] c, int off, int len) { throw new RuntimeException("Stub!"); }

/**
 * Write a portion of a string to the buffer.
 * @param  str  String to be written from
 * @param  off  Offset from which to start reading characters
 * @param  len  Number of characters to be written
 * @apiSince 1
 */

public void write(java.lang.String str, int off, int len) { throw new RuntimeException("Stub!"); }

/**
 * Writes the contents of the buffer to another character stream.
 *
 * @param out       the output stream to write to
 * @throws java.io.IOException If an I/O error occurs.
 * @apiSince 1
 */

public void writeTo(java.io.Writer out) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Appends the specified character sequence to this writer.
 *
 * <p> An invocation of this method of the form <tt>out.append(csq)</tt>
 * behaves in exactly the same way as the invocation
 *
 * <pre>
 *     out.write(csq.toString()) </pre>
 *
 * <p> Depending on the specification of <tt>toString</tt> for the
 * character sequence <tt>csq</tt>, the entire sequence may not be
 * appended. For instance, invoking the <tt>toString</tt> method of a
 * character buffer will return a subsequence whose content depends upon
 * the buffer's position and limit.
 *
 * @param  csq
 *         The character sequence to append.  If <tt>csq</tt> is
 *         <tt>null</tt>, then the four characters <tt>"null"</tt> are
 *         appended to this writer.
 *
 * @return  This writer
 *
 * @since  1.5
 * @apiSince 1
 */

public java.io.CharArrayWriter append(java.lang.CharSequence csq) { throw new RuntimeException("Stub!"); }

/**
 * Appends a subsequence of the specified character sequence to this writer.
 *
 * <p> An invocation of this method of the form <tt>out.append(csq, start,
 * end)</tt> when <tt>csq</tt> is not <tt>null</tt>, behaves in
 * exactly the same way as the invocation
 *
 * <pre>
 *     out.write(csq.subSequence(start, end).toString()) </pre>
 *
 * @param  csq
 *         The character sequence from which a subsequence will be
 *         appended.  If <tt>csq</tt> is <tt>null</tt>, then characters
 *         will be appended as if <tt>csq</tt> contained the four
 *         characters <tt>"null"</tt>.
 *
 * @param  start
 *         The index of the first character in the subsequence
 *
 * @param  end
 *         The index of the character following the last character in the
 *         subsequence
 *
 * @return  This writer
 *
 * @throws  java.lang.IndexOutOfBoundsException
 *          If <tt>start</tt> or <tt>end</tt> are negative, <tt>start</tt>
 *          is greater than <tt>end</tt>, or <tt>end</tt> is greater than
 *          <tt>csq.length()</tt>
 *
 * @since  1.5
 * @apiSince 1
 */

public java.io.CharArrayWriter append(java.lang.CharSequence csq, int start, int end) { throw new RuntimeException("Stub!"); }

/**
 * Appends the specified character to this writer.
 *
 * <p> An invocation of this method of the form <tt>out.append(c)</tt>
 * behaves in exactly the same way as the invocation
 *
 * <pre>
 *     out.write(c) </pre>
 *
 * @param  c
 *         The 16-bit character to append
 *
 * @return  This writer
 *
 * @since 1.5
 * @apiSince 1
 */

public java.io.CharArrayWriter append(char c) { throw new RuntimeException("Stub!"); }

/**
 * Resets the buffer so that you can use it again without
 * throwing away the already allocated buffer.
 * @apiSince 1
 */

public void reset() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of the input data.
 *
 * @return an array of chars copied from the input data.
 * @apiSince 1
 */

public char[] toCharArray() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current size of the buffer.
 *
 * @return an int representing the current size of the buffer.
 * @apiSince 1
 */

public int size() { throw new RuntimeException("Stub!"); }

/**
 * Converts input data to a string.
 * @return the string.
 * @apiSince 1
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Flush the stream.
 * @apiSince 1
 */

public void flush() { throw new RuntimeException("Stub!"); }

/**
 * Close the stream.  This method does not release the buffer, since its
 * contents might still be required. Note: Invoking this method in this class
 * will have no effect.
 * @apiSince 1
 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * The buffer where data is stored.
 * @apiSince 1
 */

protected char[] buf;

/**
 * The number of chars in the buffer.
 * @apiSince 1
 */

protected int count;
}

