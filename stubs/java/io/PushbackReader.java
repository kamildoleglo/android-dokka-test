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
 * A character-stream reader that allows characters to be pushed back into the
 * stream.
 *
 * @author      Mark Reinhold
 * @since       JDK1.1
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PushbackReader extends java.io.FilterReader {

/**
 * Creates a new pushback reader with a pushback buffer of the given size.
 *
 * @param   in   The reader from which characters will be read
 * @param   size The size of the pushback buffer
 * @exception java.lang.IllegalArgumentException if {@code size <= 0}
 * @apiSince 1
 */

public PushbackReader(java.io.Reader in, int size) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new pushback reader with a one-character pushback buffer.
 *
 * @param   in  The reader from which characters will be read
 * @apiSince 1
 */

public PushbackReader(java.io.Reader in) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Reads a single character.
 *
 * @return     The character read, or -1 if the end of the stream has been
 *             reached
 *
 * @exception  java.io.IOException  If an I/O error occurs
 * @apiSince 1
 */

public int read() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Reads characters into a portion of an array.
 *
 * @param      cbuf  Destination buffer
 * @param      off   Offset at which to start writing characters
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
 * Pushes back a single character by copying it to the front of the
 * pushback buffer. After this method returns, the next character to be read
 * will have the value <code>(char)c</code>.
 *
 * @param  c  The int value representing a character to be pushed back
 *
 * @exception  java.io.IOException  If the pushback buffer is full,
 *                          or if some other I/O error occurs
 * @apiSince 1
 */

public void unread(int c) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Pushes back a portion of an array of characters by copying it to the
 * front of the pushback buffer.  After this method returns, the next
 * character to be read will have the value <code>cbuf[off]</code>, the
 * character after that will have the value <code>cbuf[off+1]</code>, and
 * so forth.
 *
 * @param  cbuf  Character array
 * @param  off   Offset of first character to push back
 * @param  len   Number of characters to push back
 *
 * @exception  java.io.IOException  If there is insufficient room in the pushback
 *                          buffer, or if some other I/O error occurs
 * @apiSince 1
 */

public void unread(char[] cbuf, int off, int len) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Pushes back an array of characters by copying it to the front of the
 * pushback buffer.  After this method returns, the next character to be
 * read will have the value <code>cbuf[0]</code>, the character after that
 * will have the value <code>cbuf[1]</code>, and so forth.
 *
 * @param  cbuf  Character array to push back
 *
 * @exception  java.io.IOException  If there is insufficient room in the pushback
 *                          buffer, or if some other I/O error occurs
 * @apiSince 1
 */

public void unread(char[] cbuf) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Tells whether this stream is ready to be read.
 *
 * @exception  java.io.IOException  If an I/O error occurs
 * @apiSince 1
 */

public boolean ready() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Marks the present position in the stream. The <code>mark</code>
 * for class <code>PushbackReader</code> always throws an exception.
 *
 * @exception  java.io.IOException  Always, since mark is not supported
 * @apiSince 1
 */

public void mark(int readAheadLimit) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Resets the stream. The <code>reset</code> method of
 * <code>PushbackReader</code> always throws an exception.
 *
 * @exception  java.io.IOException  Always, since reset is not supported
 * @apiSince 1
 */

public void reset() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Tells whether this stream supports the mark() operation, which it does
 * not.
 * @apiSince 1
 */

public boolean markSupported() { throw new RuntimeException("Stub!"); }

/**
 * Closes the stream and releases any system resources associated with
 * it. Once the stream has been closed, further read(),
 * unread(), ready(), or skip() invocations will throw an IOException.
 * Closing a previously closed stream has no effect.
 *
 * @exception  java.io.IOException  If an I/O error occurs
 * @apiSince 1
 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Skips characters.  This method will block until some characters are
 * available, an I/O error occurs, or the end of the stream is reached.
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
}

