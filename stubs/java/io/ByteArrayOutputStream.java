/*
 * Copyright (c) 1994, 2013, Oracle and/or its affiliates. All rights reserved.
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
 * This class implements an output stream in which the data is
 * written into a byte array. The buffer automatically grows as data
 * is written to it.
 * The data can be retrieved using <code>toByteArray()</code> and
 * <code>toString()</code>.
 * <p>
 * Closing a <tt>ByteArrayOutputStream</tt> has no effect. The methods in
 * this class can be called after the stream has been closed without
 * generating an <tt>IOException</tt>.
 *
 * @author  Arthur van Hoff
 * @since   JDK1.0
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ByteArrayOutputStream extends java.io.OutputStream {

/**
 * Creates a new byte array output stream. The buffer capacity is
 * initially 32 bytes, though its size increases if necessary.
 * @apiSince 1
 */

public ByteArrayOutputStream() { throw new RuntimeException("Stub!"); }

/**
 * Creates a new byte array output stream, with a buffer capacity of
 * the specified size, in bytes.
 *
 * @param   size   the initial size.
 * @exception  java.lang.IllegalArgumentException if size is negative.
 * @apiSince 1
 */

public ByteArrayOutputStream(int size) { throw new RuntimeException("Stub!"); }

/**
 * Writes the specified byte to this byte array output stream.
 *
 * @param   b   the byte to be written.
 * @apiSince 1
 */

public synchronized void write(int b) { throw new RuntimeException("Stub!"); }

/**
 * Writes <code>len</code> bytes from the specified byte array
 * starting at offset <code>off</code> to this byte array output stream.
 *
 * @param   b     the data.
 * @param   off   the start offset in the data.
 * @param   len   the number of bytes to write.
 * @apiSince 1
 */

public synchronized void write(@androidx.annotation.NonNull byte[] b, int off, int len) { throw new RuntimeException("Stub!"); }

/**
 * Writes the complete contents of this byte array output stream to
 * the specified output stream argument, as if by calling the output
 * stream's write method using <code>out.write(buf, 0, count)</code>.
 *
 * @param      out   the output stream to which to write the data.
 * @exception  java.io.IOException  if an I/O error occurs.
 * @apiSince 1
 */

public synchronized void writeTo(@androidx.annotation.NonNull java.io.OutputStream out) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Resets the <code>count</code> field of this byte array output
 * stream to zero, so that all currently accumulated output in the
 * output stream is discarded. The output stream can be used again,
 * reusing the already allocated buffer space.
 *
 * @see     java.io.ByteArrayInputStream#count
 * @apiSince 1
 */

public synchronized void reset() { throw new RuntimeException("Stub!"); }

/**
 * Creates a newly allocated byte array. Its size is the current
 * size of this output stream and the valid contents of the buffer
 * have been copied into it.
 *
 * @return  the current contents of this output stream, as a byte array.
 * @see     java.io.ByteArrayOutputStream#size()
 * @apiSince 1
 */

@androidx.annotation.NonNull
public synchronized byte[] toByteArray() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current size of the buffer.
 *
 * @return  the value of the <code>count</code> field, which is the number
 *          of valid bytes in this output stream.
 * @see     java.io.ByteArrayOutputStream#count
 * @apiSince 1
 */

public synchronized int size() { throw new RuntimeException("Stub!"); }

/**
 * Converts the buffer's contents into a string decoding bytes using the
 * platform's default character set. The length of the new <tt>String</tt>
 * is a function of the character set, and hence may not be equal to the
 * size of the buffer.
 *
 * <p> This method always replaces malformed-input and unmappable-character
 * sequences with the default replacement string for the platform's
 * default character set. The {@linkplain java.nio.charset.CharsetDecoder}
 * class should be used when more control over the decoding process is
 * required.
 *
 * @return String decoded from the buffer's contents.
 * @since  JDK1.1
 * @apiSince 1
 */

@androidx.annotation.NonNull
public synchronized java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Converts the buffer's contents into a string by decoding the bytes using
 * the named {@link java.nio.charset.Charset charset}. The length of the new
 * <tt>String</tt> is a function of the charset, and hence may not be equal
 * to the length of the byte array.
 *
 * <p> This method always replaces malformed-input and unmappable-character
 * sequences with this charset's default replacement string. The {@link
 * java.nio.charset.CharsetDecoder} class should be used when more control
 * over the decoding process is required.
 *
 * @param      charsetName  the name of a supported
 *             {@link java.nio.charset.Charset charset}
 * @return     String decoded from the buffer's contents.
 * @exception  java.io.UnsupportedEncodingException
 *             If the named charset is not supported
 * @since      JDK1.1
 * @apiSince 1
 */

@androidx.annotation.NonNull
public synchronized java.lang.String toString(@androidx.annotation.NonNull java.lang.String charsetName) throws java.io.UnsupportedEncodingException { throw new RuntimeException("Stub!"); }

/**
 * Creates a newly allocated string. Its size is the current size of
 * the output stream and the valid contents of the buffer have been
 * copied into it. Each character <i>c</i> in the resulting string is
 * constructed from the corresponding element <i>b</i> in the byte
 * array such that:
 * <blockquote><pre>
 *     c == (char)(((hibyte &amp; 0xff) &lt;&lt; 8) | (b &amp; 0xff))
 * </pre></blockquote>
 *
 * @deprecated This method does not properly convert bytes into characters.
 * As of JDK&nbsp;1.1, the preferred way to do this is via the
 * <code>toString(String enc)</code> method, which takes an encoding-name
 * argument, or the <code>toString()</code> method, which uses the
 * platform's default character encoding.
 *
 * @param      hibyte    the high byte of each resulting Unicode character.
 * @return     the current contents of the output stream, as a string.
 * @see        java.io.ByteArrayOutputStream#size()
 * @see        java.io.ByteArrayOutputStream#toString(String)
 * @see        java.io.ByteArrayOutputStream#toString()
 * @apiSince 1
 * @deprecatedSince 15
 */

@Deprecated
@androidx.annotation.NonNull
public synchronized java.lang.String toString(int hibyte) { throw new RuntimeException("Stub!"); }

/**
 * Closing a <tt>ByteArrayOutputStream</tt> has no effect. The methods in
 * this class can be called after the stream has been closed without
 * generating an <tt>IOException</tt>.
 * @apiSince 1
 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * The buffer where data is stored.
 * @apiSince 1
 */

@androidx.annotation.NonNull protected byte[] buf;

/**
 * The number of valid bytes in the buffer.
 * @apiSince 1
 */

protected int count;
}

