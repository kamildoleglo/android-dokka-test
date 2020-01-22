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

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/**
 * An OutputStreamWriter is a bridge from character streams to byte streams:
 * Characters written to it are encoded into bytes using a specified {@link
 * java.nio.charset.Charset charset}.  The charset that it uses
 * may be specified by name or may be given explicitly, or the platform's
 * default charset may be accepted.
 *
 * <p> Each invocation of a write() method causes the encoding converter to be
 * invoked on the given character(s).  The resulting bytes are accumulated in a
 * buffer before being written to the underlying output stream.  The size of
 * this buffer may be specified, but by default it is large enough for most
 * purposes.  Note that the characters passed to the write() methods are not
 * buffered.
 *
 * <p> For top efficiency, consider wrapping an OutputStreamWriter within a
 * BufferedWriter so as to avoid frequent converter invocations.  For example:
 *
 * <pre>
 * Writer out
 *   = new BufferedWriter(new OutputStreamWriter(System.out));
 * </pre>
 *
 * <p> A <i>surrogate pair</i> is a character represented by a sequence of two
 * <tt>char</tt> values: A <i>high</i> surrogate in the range '&#92;uD800' to
 * '&#92;uDBFF' followed by a <i>low</i> surrogate in the range '&#92;uDC00' to
 * '&#92;uDFFF'.
 *
 * <p> A <i>malformed surrogate element</i> is a high surrogate that is not
 * followed by a low surrogate or a low surrogate that is not preceded by a
 * high surrogate.
 *
 * <p> This class always replaces malformed surrogate elements and unmappable
 * character sequences with the charset's default <i>substitution sequence</i>.
 * The {@linkplain java.nio.charset.CharsetEncoder} class should be used when more
 * control over the encoding process is required.
 *
 * @see java.io.BufferedWriter
 * @see java.io.OutputStream
 * @see java.nio.charset.Charset
 *
 * @author      Mark Reinhold
 * @since       JDK1.1
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class OutputStreamWriter extends java.io.Writer {

/**
 * Creates an OutputStreamWriter that uses the named charset.
 *
 * @param  out
 *         An OutputStream
 *
 * @param  charsetName
 *         The name of a supported
 *         {@link java.nio.charset.Charset charset}
 *
 * @exception  java.io.UnsupportedEncodingException
 *             If the named encoding is not supported
 * @apiSince 1
 */

public OutputStreamWriter(java.io.OutputStream out, java.lang.String charsetName) throws java.io.UnsupportedEncodingException { throw new RuntimeException("Stub!"); }

/**
 * Creates an OutputStreamWriter that uses the default character encoding.
 *
 * @param  out  An OutputStream
 * @apiSince 1
 */

public OutputStreamWriter(java.io.OutputStream out) { throw new RuntimeException("Stub!"); }

/**
 * Creates an OutputStreamWriter that uses the given charset.
 *
 * @param  out
 *         An OutputStream
 *
 * @param  cs
 *         A charset
 *
 * @since 1.4
 * @spec JSR-51
 * @apiSince 1
 */

public OutputStreamWriter(java.io.OutputStream out, java.nio.charset.Charset cs) { throw new RuntimeException("Stub!"); }

/**
 * Creates an OutputStreamWriter that uses the given charset encoder.
 *
 * @param  out
 *         An OutputStream
 *
 * @param  enc
 *         A charset encoder
 *
 * @since 1.4
 * @spec JSR-51
 * @apiSince 1
 */

public OutputStreamWriter(java.io.OutputStream out, java.nio.charset.CharsetEncoder enc) { throw new RuntimeException("Stub!"); }

/**
 * Returns the name of the character encoding being used by this stream.
 *
 * <p> If the encoding has an historical name then that name is returned;
 * otherwise the encoding's canonical name is returned.
 *
 * <p> If this instance was created with the {@link
 * #OutputStreamWriter(java.io.OutputStream,java.lang.String)} constructor then the returned
 * name, being unique for the encoding, may differ from the name passed to
 * the constructor.  This method may return <tt>null</tt> if the stream has
 * been closed. </p>
 *
 * @return The historical name of this encoding, or possibly
 *         <code>null</code> if the stream has been closed
 *
 * @see java.nio.charset.Charset
 *
 * @revised 1.4
 * @spec JSR-51
 * @apiSince 1
 */

public java.lang.String getEncoding() { throw new RuntimeException("Stub!"); }

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
 * @param  cbuf  Buffer of characters
 * @param  off   Offset from which to start writing characters
 * @param  len   Number of characters to write
 *
 * @exception  java.io.IOException  If an I/O error occurs
 * @apiSince 1
 */

public void write(char[] cbuf, int off, int len) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Writes a portion of a string.
 *
 * @param  str  A String
 * @param  off  Offset from which to start writing characters
 * @param  len  Number of characters to write
 *
 * @exception  java.io.IOException  If an I/O error occurs
 * @apiSince 1
 */

public void write(java.lang.String str, int off, int len) throws java.io.IOException { throw new RuntimeException("Stub!"); }

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

