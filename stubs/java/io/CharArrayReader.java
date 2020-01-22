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
 * This class implements a character buffer that can be used as a
 * character-input stream.
 *
 * @author      Herb Jellinek
 * @since       JDK1.1
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CharArrayReader extends java.io.Reader {

/**
 * Creates a CharArrayReader from the specified array of chars.
 * @param buf       Input buffer (not copied)
 * @apiSince 1
 */

public CharArrayReader(char[] buf) { throw new RuntimeException("Stub!"); }

/**
 * Creates a CharArrayReader from the specified array of chars.
 *
 * <p> The resulting reader will start reading at the given
 * <tt>offset</tt>.  The total number of <tt>char</tt> values that can be
 * read from this reader will be either <tt>length</tt> or
 * <tt>buf.length-offset</tt>, whichever is smaller.
 *
 * @throws java.lang.IllegalArgumentException
 *         If <tt>offset</tt> is negative or greater than
 *         <tt>buf.length</tt>, or if <tt>length</tt> is negative, or if
 *         the sum of these two values is negative.
 *
 * @param buf       Input buffer (not copied)
 * @param offset    Offset of the first char to read
 * @param length    Number of chars to read
 * @apiSince 1
 */

public CharArrayReader(char[] buf, int offset, int length) { throw new RuntimeException("Stub!"); }

/**
 * Reads a single character.
 *
 * @exception   java.io.IOException  If an I/O error occurs
 * @apiSince 1
 */

public int read() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Reads characters into a portion of an array.
 * @param b  Destination buffer
 * @param off  Offset at which to start storing characters
 * @param len   Maximum number of characters to read
 * @return  The actual number of characters read, or -1 if
 *          the end of the stream has been reached
 *
 * @exception   java.io.IOException  If an I/O error occurs
 * @apiSince 1
 */

public int read(char[] b, int off, int len) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Skips characters.  Returns the number of characters that were skipped.
 *
 * <p>The <code>n</code> parameter may be negative, even though the
 * <code>skip</code> method of the {@link java.io.Reader Reader} superclass throws
 * an exception in this case. If <code>n</code> is negative, then
 * this method does nothing and returns <code>0</code>.
 *
 * @param n The number of characters to skip
 * @return       The number of characters actually skipped
 * @exception  java.io.IOException If the stream is closed, or an I/O error occurs
 * @apiSince 1
 */

public long skip(long n) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Tells whether this stream is ready to be read.  Character-array readers
 * are always ready to be read.
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
 * will reposition the stream to this point.
 *
 * @param  readAheadLimit  Limit on the number of characters that may be
 *                         read while still preserving the mark.  Because
 *                         the stream's input comes from a character array,
 *                         there is no actual limit; hence this argument is
 *                         ignored.
 *
 * @exception  java.io.IOException  If an I/O error occurs
 * @apiSince 1
 */

public void mark(int readAheadLimit) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Resets the stream to the most recent mark, or to the beginning if it has
 * never been marked.
 *
 * @exception  java.io.IOException  If an I/O error occurs
 * @apiSince 1
 */

public void reset() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Closes the stream and releases any system resources associated with
 * it.  Once the stream has been closed, further read(), ready(),
 * mark(), reset(), or skip() invocations will throw an IOException.
 * Closing a previously closed stream has no effect.
 * @apiSince 1
 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * The character buffer.
 * @apiSince 1
 */

protected char[] buf;

/**
 *  The index of the end of this buffer.  There is not valid
 *  data at or beyond this index.
 * @apiSince 1
 */

protected int count;

/**
 * The position of mark in buffer.
 * @apiSince 1
 */

protected int markedPos = 0; // 0x0

/**
 * The current buffer position.
 * @apiSince 1
 */

protected int pos;
}

