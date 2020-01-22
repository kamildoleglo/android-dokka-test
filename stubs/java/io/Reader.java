/*
 * Copyright (c) 1996, 2012, Oracle and/or its affiliates. All rights reserved.
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
 * Abstract class for reading character streams.  The only methods that a
 * subclass must implement are read(char[], int, int) and close().  Most
 * subclasses, however, will override some of the methods defined here in order
 * to provide higher efficiency, additional functionality, or both.
 *
 *
 * @see java.io.BufferedReader
 * @see   java.io.LineNumberReader
 * @see java.io.CharArrayReader
 * @see java.io.InputStreamReader
 * @see   java.io.FileReader
 * @see java.io.FilterReader
 * @see   java.io.PushbackReader
 * @see java.io.PipedReader
 * @see java.io.StringReader
 * @see java.io.Writer
 *
 * @author      Mark Reinhold
 * @since       JDK1.1
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class Reader implements java.lang.Readable, java.io.Closeable {

/**
 * Creates a new character-stream reader whose critical sections will
 * synchronize on the reader itself.
 * @apiSince 1
 */

protected Reader() { throw new RuntimeException("Stub!"); }

/**
 * Creates a new character-stream reader whose critical sections will
 * synchronize on the given object.
 *
 * @param lock  The Object to synchronize on.
 * @apiSince 1
 */

protected Reader(java.lang.Object lock) { throw new RuntimeException("Stub!"); }

/**
 * Attempts to read characters into the specified character buffer.
 * The buffer is used as a repository of characters as-is: the only
 * changes made are the results of a put operation. No flipping or
 * rewinding of the buffer is performed.
 *
 * @param target the buffer to read characters into
 * @return The number of characters added to the buffer, or
 *         -1 if this source of characters is at its end
 * @throws java.io.IOException if an I/O error occurs
 * @throws java.lang.NullPointerException if target is null
 * @throws java.nio.ReadOnlyBufferException if target is a read only buffer
 * @since 1.5
 * @apiSince 1
 */

public int read(java.nio.CharBuffer target) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Reads a single character.  This method will block until a character is
 * available, an I/O error occurs, or the end of the stream is reached.
 *
 * <p> Subclasses that intend to support efficient single-character input
 * should override this method.
 *
 * @return     The character read, as an integer in the range 0 to 65535
 *             (<tt>0x00-0xffff</tt>), or -1 if the end of the stream has
 *             been reached
 *
 * @exception  java.io.IOException  If an I/O error occurs
 * @apiSince 1
 */

public int read() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Reads characters into an array.  This method will block until some input
 * is available, an I/O error occurs, or the end of the stream is reached.
 *
 * @param       cbuf  Destination buffer
 *
 * @return      The number of characters read, or -1
 *              if the end of the stream
 *              has been reached
 *
 * @exception   java.io.IOException  If an I/O error occurs
 * @apiSince 1
 */

public int read(char[] cbuf) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Reads characters into a portion of an array.  This method will block
 * until some input is available, an I/O error occurs, or the end of the
 * stream is reached.
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

public abstract int read(char[] cbuf, int off, int len) throws java.io.IOException;

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

/**
 * Tells whether this stream is ready to be read.
 *
 * @return True if the next read() is guaranteed not to block for input,
 * false otherwise.  Note that returning false does not guarantee that the
 * next read will block.
 *
 * @exception  java.io.IOException  If an I/O error occurs
 * @apiSince 1
 */

public boolean ready() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Tells whether this stream supports the mark() operation. The default
 * implementation always returns false. Subclasses should override this
 * method.
 *
 * @return true if and only if this stream supports the mark operation.
 * @apiSince 1
 */

public boolean markSupported() { throw new RuntimeException("Stub!"); }

/**
 * Marks the present position in the stream.  Subsequent calls to reset()
 * will attempt to reposition the stream to this point.  Not all
 * character-input streams support the mark() operation.
 *
 * @param  readAheadLimit  Limit on the number of characters that may be
 *                         read while still preserving the mark.  After
 *                         reading this many characters, attempting to
 *                         reset the stream may fail.
 *
 * @exception  java.io.IOException  If the stream does not support mark(),
 *                          or if some other I/O error occurs
 * @apiSince 1
 */

public void mark(int readAheadLimit) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Resets the stream.  If the stream has been marked, then attempt to
 * reposition it at the mark.  If the stream has not been marked, then
 * attempt to reset it in some way appropriate to the particular stream,
 * for example by repositioning it to its starting point.  Not all
 * character-input streams support the reset() operation, and some support
 * reset() without supporting mark().
 *
 * @exception  java.io.IOException  If the stream has not been marked,
 *                          or if the mark has been invalidated,
 *                          or if the stream does not support reset(),
 *                          or if some other I/O error occurs
 * @apiSince 1
 */

public void reset() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Closes the stream and releases any system resources associated with
 * it.  Once the stream has been closed, further read(), ready(),
 * mark(), reset(), or skip() invocations will throw an IOException.
 * Closing a previously closed stream has no effect.
 *
 * @exception  java.io.IOException  If an I/O error occurs
 * @apiSince 1
 */

public abstract void close() throws java.io.IOException;

/**
 * The object used to synchronize operations on this stream.  For
 * efficiency, a character-stream object may use an object other than
 * itself to protect critical sections.  A subclass should therefore use
 * the object in this field rather than <tt>this</tt> or a synchronized
 * method.
 * @apiSince 1
 */

protected java.lang.Object lock;
}

